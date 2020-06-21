package org.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {
    private TicTacToe ticTacToe;

    @BeforeEach
    public void setUp(){
        ticTacToe = new TicTacToe();
    }

    @Test
    public void whenXOutsideBoardThenRuntimeException(){

        assertThatThrownBy(() -> ticTacToe.play(5,2))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void whenYOutsideBoardThenRuntimeException(){

        assertThatThrownBy(() -> ticTacToe.play(2,5))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void whenIsPutOnAssignedField(){
        ticTacToe.play(2,2);
        assertThatThrownBy(() -> ticTacToe.play(2,2))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void givenFirstTurnWhenNextPlayerThenX(){
        assertThat(ticTacToe.nextPlayer())
                .isEqualTo('X');
    }


}