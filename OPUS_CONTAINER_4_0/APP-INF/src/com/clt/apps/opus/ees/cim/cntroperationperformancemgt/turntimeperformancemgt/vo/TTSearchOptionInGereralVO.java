/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : TTSearchOptionInGereralVO.java
 *@FileTitle : TTSearchOptionInGereralVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.29
 *@LastModifier : 박광석
 *@LastVersion : 1.0
 * 2009.04.29 박광석 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 박광석
 * @since J2EE 1.5
 */

public class TTSearchOptionInGereralVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<TTSearchOptionInGereralVO> models = new ArrayList<TTSearchOptionInGereralVO>();

	/* Column Info */
	private String period = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String from = null;
	/* Column Info */
	private String flowpattern = null;
	/* Column Info */
	private String soc = null;
	/* Column Info */
	private String tscntr = null;
	/* Column Info */
	private String company = null;
	/* Column Info */
	private String to = null;
	/* Column Info */
	private String inquiryLevel = null;
	/* Column Info */
	private String tpsz = null;
	/* Column Info */
	private String rdtype = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String enRoute = null;

	public String getEnRoute() {
		return enRoute;
	}

	public void setEnRoute(String enRoute) {
		this.enRoute = enRoute;
	}

	public String getPol() {
		return pol;
	}

	public void setPol(String pol) {
		this.pol = pol;
	}

	public String getLane() {
		return lane;
	}

	public void setLane(String lane) {
		this.lane = lane;
	}

	public String getVvd() {
		return vvd;
	}

	public void setVvd(String vvd) {
		this.vvd = vvd;
	}

	/* Column Info */
	private String lane = null;
	/* Column Info */
	private String vvd = null;

	public String getPortcom() {
		return portcom;
	}

	public String getMvmtPairDivision() {
		return mvmtPairDivision;
	}

	public void setMvmtPairDivision(String mvmtPairDivision) {
		this.mvmtPairDivision = mvmtPairDivision;
	}

	public String getMvmtPair1() {
		return mvmtPair1;
	}

	public void setMvmtPair1(String mvmtPair1) {
		this.mvmtPair1 = mvmtPair1;
	}

	public String getMvmtPair2() {
		return mvmtPair2;
	}

	public void setMvmtPair2(String mvmtPair2) {
		this.mvmtPair2 = mvmtPair2;
	}

	public void setPortcom(String portcom) {
		this.portcom = portcom;
	}

	/* Column Info */
	private String location = null;
	/* Column Info */
	private String portcom = null;
	/* Column Info */
	private String mvmtPairDivision = null;
	/* Column Info */
	private String mvmtPair1 = null;
	/* Column Info */
	private String mvmtPair2 = null;
	/* Page Number */
	private String pagerows = null;

	/* hashColumnInpo */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/* hashFildInpo */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public TTSearchOptionInGereralVO() {
	}

	/**
	 * 
	 * @param ibflag
	 * @param pagerows
	 * @param period
	 * @param from
	 * @param to
	 * @param inquiryLevel
	 * @param location
	 * @param flowpattern
	 * @param tpsz
	 * @param rdtype
	 * @param tscntr
	 * @param soc
	 * @param company
	 * @param portcom
	 * @param pol
	 * @param lane
	 * @param vvd
	 * @param enRoute
	 */
	public TTSearchOptionInGereralVO(String ibflag, String pagerows, String period, String from, String to,
			String inquiryLevel, String location, String flowpattern, String tpsz, String rdtype, String tscntr,
			String soc, String company, String portcom, String pol, String lane, String vvd, String enRoute,
			String mvmtPairDivision, String mvmtPair1, String mvmtPair2) {
		this.enRoute = enRoute;
		this.period = period;
		this.ibflag = ibflag;
		this.from = from;
		this.flowpattern = flowpattern;
		this.soc = soc;
		this.tscntr = tscntr;
		this.company = company;
		this.to = to;
		this.inquiryLevel = inquiryLevel;
		this.tpsz = tpsz;
		this.rdtype = rdtype;
		this.location = location;
		this.portcom = portcom;
		this.pol = pol;
		this.lane = lane;
		this.vvd = vvd;
		this.mvmtPairDivision = mvmtPairDivision;
		this.mvmtPair1 = mvmtPair1;
		this.mvmtPair2 = mvmtPair2;
		this.pagerows = pagerows;
	}

	/**
	 * hashColumnInpo
	 * 
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues() {
		this.hashColumns.put("period", getPeriod());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("from", getFrom());
		this.hashColumns.put("flowpattern", getFlowpattern());
		this.hashColumns.put("soc", getSoc());
		this.hashColumns.put("tscntr", getTscntr());
		this.hashColumns.put("company", getCompany());
		this.hashColumns.put("to", getTo());
		this.hashColumns.put("inquiryLevel", getInquiryLevel());
		this.hashColumns.put("tpsz", getTpsz());
		this.hashColumns.put("rdtype", getRdtype());
		this.hashColumns.put("location", getLocation());
		this.hashColumns.put("portcom", getPortcom());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("enRoute", getEnRoute());
		this.hashColumns.put("mvmtPairDivision", getMvmtPairDivision());
		this.hashColumns.put("mvmtPair1", getMvmtPair1());
		this.hashColumns.put("mvmtPair2", getMvmtPair2());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * hashFildInpo
	 * 
	 * @return
	 */
	public HashMap<String, String> getFieldNames() {
		this.hashFields.put("period", "period");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("from", "from");
		this.hashFields.put("flowpattern", "flowpattern");
		this.hashFields.put("soc", "soc");
		this.hashFields.put("tscntr", "tscntr");
		this.hashFields.put("company", "company");
		this.hashFields.put("to", "to");
		this.hashFields.put("inquiryLevel", "inquiryLevel");
		this.hashFields.put("tpsz", "tpsz");
		this.hashFields.put("rdtype", "rdtype");
		this.hashFields.put("location", "location");
		this.hashFields.put("portcom", "portcom");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("enRoute", "enRoute");
		this.hashFields.put("mvmtPairDivision", "mvmtPairDivision");
		this.hashFields.put("mvmtPair1", "mvmtPair1");
		this.hashFields.put("mvmtPair2", "mvmtPair2");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	public String getPeriod() {
		return this.period;
	}

	public String getIbflag() {
		return this.ibflag;
	}

	public String getFrom() {
		return this.from;
	}

	public String getFlowpattern() {
		return this.flowpattern;
	}

	public String getSoc() {
		return this.soc;
	}

	public String getTscntr() {
		return this.tscntr;
	}

	public String getCompany() {
		return this.company;
	}

	public String getTo() {
		return this.to;
	}

	public String getInquiryLevel() {
		return this.inquiryLevel;
	}

	public String getTpsz() {
		return this.tpsz;
	}

	public String getRdtype() {
		return this.rdtype;
	}

	public String getLocation() {
		return this.location;
	}

	public String getPagerows() {
		return this.pagerows;
	}

	public void setPeriod(String period) {
		this.period = period;
		// this.period=true;
	}

	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		// this.ibflag=true;
	}

	public void setFrom(String from) {
		this.from = from;
		// this.from=true;
	}

	public void setFlowpattern(String flowpattern) {
		this.flowpattern = flowpattern;
		// this.flowpattern=true;
	}

	public void setSoc(String soc) {
		this.soc = soc;
		// this.soc=true;
	}

	public void setTscntr(String tscntr) {
		this.tscntr = tscntr;
		// this.tscntr=true;
	}

	public void setCompany(String company) {
		this.company = company;
		// this.company=true;
	}

	public void setTo(String to) {
		this.to = to;
		// this.to=true;
	}

	public void setInquiryLevel(String inquiryLevel) {
		this.inquiryLevel = inquiryLevel;
		// this.inquirylevel=true;
	}

	public void setTpsz(String tpsz) {
		this.tpsz = tpsz;
		// this.tpsz=true;
	}

	public void setRdtype(String rdtype) {
		this.rdtype = rdtype;
		// this.rdtype=true;
	}

	public void setLocation(String location) {
		this.location = location;
		// this.location=true;
	}

	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		// this.pagerows=true;
	}

	/**
	 * 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setEnRoute(JSPUtil.getParameter(request, "enRoute", ""));
		setPeriod(JSPUtil.getParameter(request, "period", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFrom(JSPUtil.getParameter(request, "from", ""));
		setFlowpattern(JSPUtil.getParameter(request, "flowpattern", ""));
		setSoc(JSPUtil.getParameter(request, "soc", ""));
		setTscntr(JSPUtil.getParameter(request, "tscntr", ""));
		setCompany(JSPUtil.getParameter(request, "company", ""));
		setTo(JSPUtil.getParameter(request, "to", ""));
		setInquiryLevel(JSPUtil.getParameter(request, "inquiryLevel", ""));
		setTpsz(JSPUtil.getParameter(request, "tpsz", ""));
		setRdtype(JSPUtil.getParameter(request, "rdtype", ""));
		setLocation(JSPUtil.getParameter(request, "location", ""));
		setPortcom(JSPUtil.getParameter(request, "portcom", ""));
		setPol(JSPUtil.getParameter(request, "pol", ""));
		setLane(JSPUtil.getParameter(request, "lane", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setMvmtPairDivision(JSPUtil.getParameter(request, "mvmtPairDivision", ""));
		setMvmtPair1(JSPUtil.getParameter(request, "mvmtPair1", ""));
		setMvmtPair2(JSPUtil.getParameter(request, "mvmtPair2", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public TTSearchOptionInGereralVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * 
	 * @param request
	 * @param prefix
	 * @return
	 */
	public TTSearchOptionInGereralVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TTSearchOptionInGereralVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] period = (JSPUtil.getParameter(request, prefix + "period".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag".trim(), length));
			String[] from = (JSPUtil.getParameter(request, prefix + "from".trim(), length));
			String[] flowpattern = (JSPUtil.getParameter(request, prefix + "flowpattern".trim(), length));
			String[] soc = (JSPUtil.getParameter(request, prefix + "soc".trim(), length));
			String[] tscntr = (JSPUtil.getParameter(request, prefix + "tscntr".trim(), length));
			String[] company = (JSPUtil.getParameter(request, prefix + "company".trim(), length));
			String[] to = (JSPUtil.getParameter(request, prefix + "to".trim(), length));
			String[] inquiryLevel = (JSPUtil.getParameter(request, prefix + "inquiryLevel".trim(), length));
			String[] tpsz = (JSPUtil.getParameter(request, prefix + "tpsz".trim(), length));
			String[] rdtype = (JSPUtil.getParameter(request, prefix + "rdtype".trim(), length));
			String[] location = (JSPUtil.getParameter(request, prefix + "location".trim(), length));
			String[] portcom = (JSPUtil.getParameter(request, prefix + "portcom".trim(), length));
			String[] pol = (JSPUtil.getParameter(request, prefix + "pol".trim(), length));
			String[] lane = (JSPUtil.getParameter(request, prefix + "lane".trim(), length));
			String[] vvd = (JSPUtil.getParameter(request, prefix + "vvd".trim(), length));
			String[] enRoute = (JSPUtil.getParameter(request, prefix + "enRoute".trim(), length));
			String[] mvmtPairDivision = (JSPUtil.getParameter(request, prefix + "mvmtPairDivision".trim(), length));
			String[] mvmtPair1 = (JSPUtil.getParameter(request, prefix + "mvmtPair1".trim(), length));
			String[] mvmtPair2 = (JSPUtil.getParameter(request, prefix + "mvmtPair2".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows".trim(), length));

			for (int i = 0; i < length; i++) {
				model = new TTSearchOptionInGereralVO();
				if (period[i] != null)
					model.setPeriod(period[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (from[i] != null)
					model.setFrom(from[i]);
				if (flowpattern[i] != null)
					model.setFlowpattern(flowpattern[i]);
				if (soc[i] != null)
					model.setSoc(soc[i]);
				if (tscntr[i] != null)
					model.setTscntr(tscntr[i]);
				if (company[i] != null)
					model.setCompany(company[i]);
				if (to[i] != null)
					model.setTo(to[i]);
				if (inquiryLevel[i] != null)
					model.setInquiryLevel(inquiryLevel[i]);
				if (tpsz[i] != null)
					model.setTpsz(tpsz[i]);
				if (rdtype[i] != null)
					model.setRdtype(rdtype[i]);
				if (location[i] != null)
					model.setLocation(location[i]);
				if (portcom[i] != null)
					model.setPortcom(portcom[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (enRoute[i] != null)
					model.setEnRoute(enRoute[i]);
				if (mvmtPairDivision[i] != null)
					model.setMvmtPairDivision(mvmtPairDivision[i]);
				if (mvmtPair1[i] != null)
					model.setMvmtPair1(mvmtPair1[i]);
				if (mvmtPair2[i] != null)
					model.setMvmtPair2(mvmtPair2[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
		}
		return getTTSearchOptionInGereralVOs();
	}

	/**
	 * 
	 * @return
	 */
	public TTSearchOptionInGereralVO[] getTTSearchOptionInGereralVOs() {
		TTSearchOptionInGereralVO[] vos = (TTSearchOptionInGereralVO[]) models
				.toArray(new TTSearchOptionInGereralVO[models.size()]);
		return vos;
	}

	/**
	 * 
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
		}
		return ret.toString();
	}

	/**
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다
	 * 
	 * @param field
	 * @param i
	 * @return String[]
	 * @throws IllegalAccessException
	 */
	private String[] getField(Field[] field, int i) throws IllegalAccessException {
		String[] arr;
		try {
			arr = (String[]) field[i].get(this);
		} catch (Exception ex) {
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		}
		return arr;
	}

	/**
	 * DataFormat 설정
	 */
	public void onDataFormat() {
		this.period = this.period.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.from = this.from.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flowpattern = this.flowpattern.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":",
				"");
		this.soc = this.soc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tscntr = this.tscntr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.company = this.company.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.to = this.to.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inquiryLevel = this.inquiryLevel.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(
				":", "");
		this.tpsz = this.tpsz.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdtype = this.rdtype.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.location = this.location.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portcom = this.portcom.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.enRoute = this.enRoute.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtPairDivision = this.mvmtPairDivision.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "")
				.replaceAll(":", "");
		this.mvmtPair1 = this.mvmtPair1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtPair2 = this.mvmtPair2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
