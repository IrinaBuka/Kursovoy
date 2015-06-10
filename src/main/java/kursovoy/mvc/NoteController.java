package kursovoy.mvc;

import kursovoy.jdbc.JDBCUtil;
import kursovoy.model.Note;
import kursovoy.model.User;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Base64Utils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

@Controller
public class NoteController {

	@RequestMapping(value = "/noteList", method = RequestMethod.GET)
	public String get(HttpServletRequest request, Model model,
			@RequestParam(value = "userId", required = true) final String userId) {

		JDBCUtil jdbcUtil = new JDBCUtil();
		List<Note> allUsers = jdbcUtil.getNoteByUserId(userId);
		// Get all users
		model.addAttribute("notes", allUsers);
		return "notes";

	}

	@RequestMapping(value = "/note", method = RequestMethod.GET)
	public String getNote(
			Model model,
			@RequestParam(value = "noteId", required = false) final String noteId) {
		Note u = new Note();
		if (noteId != null) {
			JDBCUtil jdbcUtil = new JDBCUtil();
			List<Note> NoteByUserId = jdbcUtil.getNote(noteId);
			if (!org.springframework.util.CollectionUtils.isEmpty(NoteByUserId))
				u = NoteByUserId.get(0);
		}
		model.addAttribute("note", u);
		return "note";
	}

	@RequestMapping(value = "/note", method = RequestMethod.POST)
	public @ResponseBody String save(final HttpServletRequest request,
			final HttpServletResponse response, final @RequestBody Note u)
			throws Exception {
		JDBCUtil jdbcUtil = new JDBCUtil();
		try {
			User us = this.getCurrentUser(request);
			if (us != null)
				u.setUserId(us.getUserId());
			jdbcUtil.saveNote(u);
		} catch (Exception e) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "ERROR";
		}
		return "OK";
	}

	protected User getCurrentUser(HttpServletRequest request) {
		User result = null;
		Cookie[] cookie = request.getCookies();
		if (cookie != null) {
			for (Cookie cook : cookie) {
				if ("KursovoiCookie".equals(cook.getName())) {
					String value = cook.getValue();
					JDBCUtil util = new JDBCUtil();
					List<User> userLIst = util.getUser(value);
					if (!CollectionUtils.isEmpty(userLIst)) {
						result = userLIst.get(0);
						break;
					}
				}
			}
		}
		return result;
	}

	@RequestMapping(value = "/deleteNote", method = RequestMethod.GET)
	public String deleteNote(HttpServletRequest request, Model model,
			@RequestParam(value = "noteId", required = true) final int noteId) {
		JDBCUtil jdbcUtil = new JDBCUtil();
		jdbcUtil.deleteNote(noteId);
		User u = this.getCurrentUser(request);
		return "redirect:/noteList?userId=" + u.getUserId();

	}

}
