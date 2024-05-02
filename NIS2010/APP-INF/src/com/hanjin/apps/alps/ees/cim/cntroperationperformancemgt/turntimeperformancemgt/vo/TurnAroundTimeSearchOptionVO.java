/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : TurnAroundTimeSearchOptionVO.java
 *@FileTitle : TurnAroundTimeSearchOptionVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.19
 *@LastModifier : 박광석
 *@LastVersion : 1.0
 * 2009.05.19 박광석 
 * 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 박광석
 * @since J2EE 1.5
 * @see AbstractValueObject
 */

public class TurnAroundTimeSearchOptionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<TurnAroundTimeSearchOptionVO> models = new ArrayList<TurnAroundTimeSearchOptionVO>();

	/* Column Info */
	private String idloc = null;
	/* Column Info */
	private String to = null;
	/* Column Info */
	private String tscntr = null;
	/* Column Info */
	private String trade = null;
	/* Column Info */
	private String subtrade = null;
	/* Column Info */
	private String from = null;
	/* Column Info */
	private String period = null;
	/* Column Info */
	private String oploc = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String lane = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String tpsz = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String company = null;
	/* Column Info */
	private String bound = null;
	/* Column Info */
	private String soc = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String locdivision = null;

	/* Table Column name으로 맴버변수 value 담는다 */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/* Table Column name으로 맴버변수 name 담는다 */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public TurnAroundTimeSearchOptionVO() {
	}

	/**
	 * 
	 * @param ibflag
	 * @param pagerows
	 * @param period
	 * @param from
	 * @param to
	 * @param trade
	 * @param subtrade
	 * @param bound
	 * @param lane
	 * @param tpsz
	 * @param tscntr
	 * @param soc
	 * @param company
	 * @param locdivision
	 * @param oploc
	 * @param idloc
	 * @param pol
	 * @param pod
	 */
	public TurnAroundTimeSearchOptionVO(String ibflag, String pagerows, String period, String from, String to,
			String trade, String subtrade,String bound, String lane, String tpsz, String tscntr, String soc, String company,
			String locdivision, String oploc, String idloc, String pol, String pod) {
		this.idloc = idloc;
		this.to = to;
		this.tscntr = tscntr;
		this.trade = trade;
		this.subtrade = subtrade;
		this.from = from;
		this.period = period;
		this.oploc = oploc;
		this.pagerows = pagerows;
		this.lane = lane;
		this.ibflag = ibflag;
		this.tpsz = tpsz;
		this.pol = pol;
		this.company = company;
		this.bound = bound;
		this.soc = soc;
		this.pod = pod;
		this.locdivision = locdivision;
	}

	/**
	 * Table Column name 으로 맴버변수에 value를 리턴한다.
	 * 
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues() {
		this.hashColumns.put("idloc", getIdloc());
		this.hashColumns.put("to", getTo());
		this.hashColumns.put("tscntr", getTscntr());
		this.hashColumns.put("trade", getTrade());
		this.hashColumns.put("subtrade", getSubTrade());
		this.hashColumns.put("from", getFrom());
		this.hashColumns.put("period", getPeriod());
		this.hashColumns.put("oploc", getOploc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tpsz", getTpsz());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("company", getCompany());
		this.hashColumns.put("bound", getBound());
		this.hashColumns.put("soc", getSoc());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("locdivision", getLocdivision());
		return this.hashColumns;
	}

	/**
	 * Table Column name 으로 맴버변수를 호출한다
	 * 
	 * @return
	 */
	public HashMap<String, String> getFieldNames() {
		this.hashFields.put("idloc", "idloc");
		this.hashFields.put("to", "to");
		this.hashFields.put("tscntr", "tscntr");
		this.hashFields.put("trade", "trade");
		this.hashFields.put("subtrade", "subtrade");
		this.hashFields.put("from", "from");
		this.hashFields.put("period", "period");
		this.hashFields.put("oploc", "oploc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tpsz", "tpsz");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("company", "company");
		this.hashFields.put("bound", "bound");
		this.hashFields.put("soc", "soc");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("locdivision", "locdivision");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * 
	 * @return idloc
	 */
	public String getIdloc() {
		return this.idloc;
	}

	/**
	 * Column Info
	 * 
	 * @return to
	 */
	public String getTo() {
		return this.to;
	}

	/**
	 * Column Info
	 * 
	 * @return tscntr
	 */
	public String getTscntr() {
		return this.tscntr;
	}

	/**
	 * Column Info
	 * 
	 * @return trade
	 */
	public String getTrade() {
		return this.trade;
	}

	/**
	 * Column Info
	 * 
	 * @return subtrade
	 */
	public String getSubTrade() {
		return this.subtrade;
	}
	
	/**
	 * Column Info
	 * 
	 * @return from
	 */
	public String getFrom() {
		return this.from;
	}

	/**
	 * Column Info
	 * 
	 * @return period
	 */
	public String getPeriod() {
		return this.period;
	}

	/**
	 * Column Info
	 * 
	 * @return oploc
	 */
	public String getOploc() {
		return this.oploc;
	}

	/**
	 * Page Number
	 * 
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}

	/**
	 * Column Info
	 * 
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
	}

	/**
	 * Status
	 * 
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}

	/**
	 * Column Info
	 * 
	 * @return tpsz
	 */
	public String getTpsz() {
		return this.tpsz;
	}

	/**
	 * Column Info
	 * 
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}

	/**
	 * Column Info
	 * 
	 * @return company
	 */
	public String getCompany() {
		return this.company;
	}

	/**
	 * Column Info
	 * 
	 * @return bound
	 */
	public String getBound() {
		return this.bound;
	}

	/**
	 * Column Info
	 * 
	 * @return soc
	 */
	public String getSoc() {
		return this.soc;
	}

	/**
	 * Column Info
	 * 
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}

	/**
	 * Column Info
	 * 
	 * @return locdivision
	 */
	public String getLocdivision() {
		return this.locdivision;
	}

	/**
	 * Column Info
	 * 
	 * @param idloc
	 */
	public void setIdloc(String idloc) {
		this.idloc = idloc;
	}

	/**
	 * Column Info
	 * 
	 * @param to
	 */
	public void setTo(String to) {
		this.to = to;
	}

	/**
	 * Column Info
	 * 
	 * @param tscntr
	 */
	public void setTscntr(String tscntr) {
		this.tscntr = tscntr;
	}

	/**
	 * Column Info
	 * 
	 * @param trade
	 */
	public void setTrade(String trade) {
		this.trade = trade;
	}

	/**
	 * Column Info
	 * 
	 * @param subtrade
	 */
	public void setSubTrade(String subtrade) {
		this.subtrade = subtrade;
	}
	
	/**
	 * Column Info
	 * 
	 * @param from
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * Column Info
	 * 
	 * @param period
	 */
	public void setPeriod(String period) {
		this.period = period;
	}

	/**
	 * Column Info
	 * 
	 * @param oploc
	 */
	public void setOploc(String oploc) {
		this.oploc = oploc;
	}

	/**
	 * Page Number
	 * 
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	/**
	 * Column Info
	 * 
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
	}

	/**
	 * Status
	 * 
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	/**
	 * Column Info
	 * 
	 * @param tpsz
	 */
	public void setTpsz(String tpsz) {
		this.tpsz = tpsz;
	}

	/**
	 * Column Info
	 * 
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}

	/**
	 * Column Info
	 * 
	 * @param company
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * Column Info
	 * 
	 * @param bound
	 */
	public void setBound(String bound) {
		this.bound = bound;
	}

	/**
	 * Column Info
	 * 
	 * @param soc
	 */
	public void setSoc(String soc) {
		this.soc = soc;
	}

	/**
	 * Column Info
	 * 
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}

	/**
	 * Column Info
	 * 
	 * @param locdivision
	 */
	public void setLocdivision(String locdivision) {
		this.locdivision = locdivision;
	}

	/**
	 * Request 넘어온 단건 DATA를 VO Class 에 담는다.
	 * 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIdloc(JSPUtil.getParameter(request, "idloc", ""));
		setTo(JSPUtil.getParameter(request, "to", ""));
		setTscntr(JSPUtil.getParameter(request, "tscntr", ""));
		setTrade(JSPUtil.getParameter(request, "trade", ""));
		setSubTrade(JSPUtil.getParameter(request, "subtrade", ""));
		setFrom(JSPUtil.getParameter(request, "from", ""));
		setPeriod(JSPUtil.getParameter(request, "period", ""));
		setOploc(JSPUtil.getParameter(request, "oploc", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setLane(JSPUtil.getParameter(request, "lane", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTpsz(JSPUtil.getParameter(request, "tpsz", ""));
		setPol(JSPUtil.getParameter(request, "pol", ""));
		setCompany(JSPUtil.getParameter(request, "company", ""));
		setBound(JSPUtil.getParameter(request, "bound", ""));
		setSoc(JSPUtil.getParameter(request, "soc", ""));
		setPod(JSPUtil.getParameter(request, "pod", ""));
		setLocdivision(JSPUtil.getParameter(request, "locdivision", ""));
	}

	/**
	 * Request를 VO Class를 담는다.
	 * 
	 * @param request
	 * @return TurnAroundTimeSearchOptionVO[]
	 */
	public TurnAroundTimeSearchOptionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * 
	 * @param request
	 * @param prefix
	 * @return TurnAroundTimeSearchOptionVO[]
	 */
	public TurnAroundTimeSearchOptionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TurnAroundTimeSearchOptionVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] idloc = (JSPUtil.getParameter(request, prefix + "idloc".trim(), length));
			String[] to = (JSPUtil.getParameter(request, prefix + "to".trim(), length));
			String[] tscntr = (JSPUtil.getParameter(request, prefix + "tscntr".trim(), length));
			String[] trade = (JSPUtil.getParameter(request, prefix + "trade".trim(), length));
			String[] subtrade = (JSPUtil.getParameter(request, prefix + "subtrade".trim(), length));
			String[] from = (JSPUtil.getParameter(request, prefix + "from".trim(), length));
			String[] period = (JSPUtil.getParameter(request, prefix + "period".trim(), length));
			String[] oploc = (JSPUtil.getParameter(request, prefix + "oploc".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows".trim(), length));
			String[] lane = (JSPUtil.getParameter(request, prefix + "lane".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag".trim(), length));
			String[] tpsz = (JSPUtil.getParameter(request, prefix + "tpsz".trim(), length));
			String[] pol = (JSPUtil.getParameter(request, prefix + "pol".trim(), length));
			String[] company = (JSPUtil.getParameter(request, prefix + "company".trim(), length));
			String[] bound = (JSPUtil.getParameter(request, prefix + "bound".trim(), length));
			String[] soc = (JSPUtil.getParameter(request, prefix + "soc".trim(), length));
			String[] pod = (JSPUtil.getParameter(request, prefix + "pod".trim(), length));
			String[] locdivision = (JSPUtil.getParameter(request, prefix + "locdivision".trim(), length));

			for (int i = 0; i < length; i++) {
				model = new TurnAroundTimeSearchOptionVO();
				if (idloc[i] != null)
					model.setIdloc(idloc[i]);
				if (to[i] != null)
					model.setTo(to[i]);
				if (tscntr[i] != null)
					model.setTscntr(tscntr[i]);
				if (trade[i] != null)
					model.setTrade(trade[i]);
				if (subtrade[i] != null)
					model.setSubTrade(subtrade[i]);
				if (from[i] != null)
					model.setFrom(from[i]);
				if (period[i] != null)
					model.setPeriod(period[i]);
				if (oploc[i] != null)
					model.setOploc(oploc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tpsz[i] != null)
					model.setTpsz(tpsz[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (company[i] != null)
					model.setCompany(company[i]);
				if (bound[i] != null)
					model.setBound(bound[i]);
				if (soc[i] != null)
					model.setSoc(soc[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (locdivision[i] != null)
					model.setLocdivision(locdivision[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTurnAroundTimeSearchOptionVOs();
	}

	/**
	 * 여러 VO Calss를 배열화 한다
	 * 
	 * @return TurnAroundTimeSearchOptionVO[]
	 */
	public TurnAroundTimeSearchOptionVO[] getTurnAroundTimeSearchOptionVOs() {
		TurnAroundTimeSearchOptionVO[] vos = (TurnAroundTimeSearchOptionVO[]) models
				.toArray(new TurnAroundTimeSearchOptionVO[models.size()]);
		return vos;
	}

	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try {
			for (int i = 0; i < field.length; i++) {
				String[] arr = null;
				arr = getField(field, i);
				if (arr != null) {
					for (int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}

	/**
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다
	 * 
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try {
			arr = (String[]) field[i].get(this);
		} catch (Exception ex) {
			arr = getFieldCatct(field, i, arr);
		}
		return arr;
	}

	/**
	 * getField 에서 catch문에 대한 로직
	 * 
	 * @param field
	 * @param i
	 * @param arr
	 * @return arr
	 */
	private String[] getFieldCatct(Field[] field, int i, String[] arr) {
		try {
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		} catch (IllegalAccessException e) {
			return null;
		}
		return arr;
	}

	/**
	 * DataFormat 설정
	 */
	public void unDataFormat() {
		this.idloc = this.idloc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.to = this.to.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tscntr = this.tscntr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trade = this.trade.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subtrade = this.subtrade.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.from = this.from.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.period = this.period.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oploc = this.oploc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpsz = this.tpsz.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.company = this.company.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bound = this.bound.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soc = this.soc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locdivision = this.locdivision.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":",
				"");
	}
}
