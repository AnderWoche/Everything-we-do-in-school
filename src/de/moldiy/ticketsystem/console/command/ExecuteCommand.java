package de.moldiy.ticketsystem.console.command;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ExecuteCommand {
	public String[] value();
}
