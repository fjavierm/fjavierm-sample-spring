/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.ua.jtech.clienteDailymotion.modelo;

import java.util.List;

/**
 *
 * @author especialista
 */
public class ResultadosBusqueda {

	private int page;
	private int limit;
	boolean explicit;
	int total;
	boolean has_more;
	List<Video> list;

	public int getTotal() {
		return this.total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public boolean isHas_more() {
		return this.has_more;
	}

	public void setHas_more(boolean has_more) {
		this.has_more = has_more;
	}

	public int getLimit() {
		return this.limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public List<Video> getList() {
		return this.list;
	}

	public void setList(List<Video> list) {
		this.list = list;
	}

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public boolean isExplicit() {
		return this.explicit;
	}

	public void setExplicit(boolean explicit) {
		this.explicit = explicit;
	}

}
