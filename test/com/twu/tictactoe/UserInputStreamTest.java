package com.twu.tictactoe;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.junit.Ignore;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by kprakobk on 5/3/15.
 */
public class UserInputStreamTest {
    @Test
    public void shouldReturnAString() throws IOException {
        BufferedReader bufferedReader = mock(BufferedReader.class);
        when(bufferedReader.readLine()).thenReturn("2");
        UserInputStream userInputStream = new UserInputStream(bufferedReader);
        String result = userInputStream.getInput();
        String expected = "2";

        assertEquals(expected, result);
    }
}