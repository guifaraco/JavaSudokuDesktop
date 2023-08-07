package com.example.javadesktopsudokudemo.buildlogic;

import com.example.javadesktopsudokudemo.computationlogic.GameLogic;
import com.example.javadesktopsudokudemo.persistence.LocalStorageImpl;
import com.example.javadesktopsudokudemo.problemdomain.IStorage;
import com.example.javadesktopsudokudemo.problemdomain.SudokuGame;
import com.example.javadesktopsudokudemo.userinterface.IUserInterfaceContract;
import com.example.javadesktopsudokudemo.userinterface.logic.ControlLogic;

import java.io.IOException;

public class SudokuBuildLogic {

    public static void build(IUserInterfaceContract.View userInterface) throws IOException{
        SudokuGame initialState;
        IStorage storage = new LocalStorageImpl();

        try {
            initialState = storage.getGameData();
        } catch (IOException e) {
            initialState = GameLogic.getNewGame();
            storage.updateGameData(initialState);
        }

        IUserInterfaceContract.EventListener uiLogic = new ControlLogic(storage, userInterface);

        userInterface.setListener(uiLogic);
        userInterface.updateBoard(initialState);
    }
}
