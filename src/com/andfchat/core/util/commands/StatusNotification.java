/*******************************************************************************
 *     This file is part of AndFChat.
 *
 *     AndFChat is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     AndFChat is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with AndFChat.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/


package com.andfchat.core.util.commands;

import com.andfchat.core.data.Chatroom.ChatroomType;
import com.andfchat.core.data.SessionData;
import com.google.inject.Inject;


public class StatusNotification extends TextCommand {

    @Inject
    protected SessionData sessionData;

    public StatusNotification() {
        allowedIn = ChatroomType.values();
    }

    @Override
    public String getDescription() {
        return "*  /status_info [on/off] | SET NOTATIONS ABOUT STATUS CHANGES ON/OFF.";
    }

    @Override
    public boolean fitToCommand(String token) {
        return token.equals("/status_info");
    }

    @Override
    public void runCommand(String token, String text) {
        boolean value = text.equals("on");
        sessionData.getSessionSettings().setShowStatusChanges(value);
    }
}
