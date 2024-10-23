package com.dress_size_picker.personalProject;

import static org.fusesource.jansi.Ansi.ansi;
import static org.fusesource.jansi.Ansi.Color.BLACK;
import static org.fusesource.jansi.Ansi.Color.RED;

import org.fusesource.jansi.Ansi;

public class Colors {
	public static Ansi info(String text) {
		return ansi().eraseScreen().render("@|green " + text + " |@");
	}

	public static Ansi warm(String text) {
		return ansi().eraseScreen().render("@|yellow " + text + " |@");
	}

	public static Ansi error(String text) {
		return ansi().eraseScreen().bg(BLACK).fg(RED).a(text).reset();
	}
}
