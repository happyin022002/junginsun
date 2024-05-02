/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EmptyCODVVDVO.java
*@FileTitle : EmptyCODVVDVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.31
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2009.07.31 박광석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.eqtransportplannperform.emptycodadjustment.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박광석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EmptyCODVVDVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EmptyCODVVDVO> models = new ArrayList<EmptyCODVVDVO>();
	
	/* Column Info */
	private String bayport = null;
	/* Column Info */
	private String div = null;
	/* Column Info */
	private String remarkflag = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String lane = null;
	/* Column Info */
	private String version = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String dmgcount = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String updusrid = null;
	/* Column Info */
	private String creusrid = null;
	/* Column Info */
	private String revcount = null;
	/* Column Info */
	private String weekdivision = null;
	/* Column Info */
	private String week = null;
	/* Column Info */
	private String hrcount = null;
	/* Column Info */
	private String dclptsql = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String remark = null;
	/* Column Info */
	private String codcfmctscd = null;
	/* Column Info */
	private String firstetb = null;
	
	/* Column Info */
	private String mnlinpflg = null;

	

	public String getMnlinpflg() {
		return mnlinpflg;
	}

	public void setMnlinpflg(String mnlinpflg) {
		this.mnlinpflg = mnlinpflg;
	}

	public String getFirstetb() {
		return firstetb;
	}

	public void setFirstetb(String firstetb) {
		this.firstetb = firstetb;
	}

	public String getCodcfmctscd() {
		return codcfmctscd;
	}

	public void setCodcfmctscd(String codcfmctscd) {
		this.codcfmctscd = codcfmctscd;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getOfccd() {
		return ofccd;
	}

	public void setOfccd(String ofccd) {
		this.ofccd = ofccd;
	}

	/* Column Info */
	private String ofccd = null;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDclptsql() {
		return dclptsql;
	}

	public void setDclptsql(String dclptsql) {
		this.dclptsql = dclptsql;
	}

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EmptyCODVVDVO() {}

	public EmptyCODVVDVO(String ibflag, String pagerows, String weekdivision, String week, String div, String vvd, String lane, String remarkflag, String bayport, String version, String hrcount, String revcount, String dmgcount, String creusrid, String updusrid,String dclptsql,String status,String ofccd,String remark,String codcfmctscd,String firstetb,String mnlinpflg) {
		this.bayport = bayport;
		this.div = div;
		this.remarkflag = remarkflag;
		this.pagerows = pagerows;
		this.lane = lane;
		this.version = version;
		this.vvd = vvd;
		this.dmgcount = dmgcount;
		this.ibflag = ibflag;
		this.updusrid = updusrid;
		this.creusrid = creusrid;
		this.revcount = revcount;
		this.weekdivision = weekdivision;
		this.week = week;
		this.hrcount = hrcount;
		this.dclptsql = dclptsql;
		this.status = status;
		this.ofccd = ofccd;
		this.remark = remark;
		this.codcfmctscd = codcfmctscd;
		this.firstetb = firstetb;
		this.mnlinpflg = mnlinpflg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bayport", getBayport());
		this.hashColumns.put("div", getDiv());
		this.hashColumns.put("remarkflag", getRemarkflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("version", getVersion());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("dmgcount", getDmgcount());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("updusrid", getUpdusrid());
		this.hashColumns.put("creusrid", getCreusrid());
		this.hashColumns.put("revcount", getRevcount());
		this.hashColumns.put("weekdivision", getWeekdivision());
		this.hashColumns.put("week", getWeek());
		this.hashColumns.put("hrcount", getHrcount());
		this.hashColumns.put("dclptsql", getDclptsql());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("ofccd", getOfccd());
		this.hashColumns.put("remark", getRemark());
		this.hashColumns.put("codcfmctscd", getCodcfmctscd());
		this.hashColumns.put("firstetb", getFirstetb());
		this.hashColumns.put("mnlinpflg", getMnlinpflg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bayport", "bayport");
		this.hashFields.put("div", "div");
		this.hashFields.put("remarkflag", "remarkflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("version", "version");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("dmgcount", "dmgcount");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("updusrid", "updusrid");
		this.hashFields.put("creusrid", "creusrid");
		this.hashFields.put("revcount", "revcount");
		this.hashFields.put("weekdivision", "weekdivision");
		this.hashFields.put("week", "week");
		this.hashFields.put("hrcount", "hrcount");
		this.hashFields.put("dclptsql", "dclptsql");
		this.hashFields.put("status", "status");
		this.hashFields.put("ofccd", "ofccd");
		this.hashFields.put("remark", "remark");
		this.hashFields.put("codcfmctscd", "codcfmctscd");
		this.hashFields.put("firstetb", "firstetb");
		this.hashFields.put("mnlinpflg", "mnlinpflg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bayport
	 */
	public String getBayport() {
		return this.bayport;
	}
	
	/**
	 * Column Info
	 * @return div
	 */
	public String getDiv() {
		return this.div;
	}
	
	/**
	 * Column Info
	 * @return remarkflag
	 */
	public String getRemarkflag() {
		return this.remarkflag;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
	}
	
	/**
	 * Column Info
	 * @return version
	 */
	public String getVersion() {
		return this.version;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return dmgcount
	 */
	public String getDmgcount() {
		return this.dmgcount;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return updusrid
	 */
	public String getUpdusrid() {
		return this.updusrid;
	}
	
	/**
	 * Column Info
	 * @return creusrid
	 */
	public String getCreusrid() {
		return this.creusrid;
	}
	
	/**
	 * Column Info
	 * @return revcount
	 */
	public String getRevcount() {
		return this.revcount;
	}
	
	/**
	 * Column Info
	 * @return weekdivision
	 */
	public String getWeekdivision() {
		return this.weekdivision;
	}
	
	/**
	 * Column Info
	 * @return week
	 */
	public String getWeek() {
		return this.week;
	}
	
	/**
	 * Column Info
	 * @return hrcount
	 */
	public String getHrcount() {
		return this.hrcount;
	}
	

	/**
	 * Column Info
	 * @param bayport
	 */
	public void setBayport(String bayport) {
		this.bayport = bayport;
	}
	
	/**
	 * Column Info
	 * @param div
	 */
	public void setDiv(String div) {
		this.div = div;
	}
	
	/**
	 * Column Info
	 * @param remarkflag
	 */
	public void setRemarkflag(String remarkflag) {
		this.remarkflag = remarkflag;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
	}
	
	/**
	 * Column Info
	 * @param version
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param dmgcount
	 */
	public void setDmgcount(String dmgcount) {
		this.dmgcount = dmgcount;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param updusrid
	 */
	public void setUpdusrid(String updusrid) {
		this.updusrid = updusrid;
	}
	
	/**
	 * Column Info
	 * @param creusrid
	 */
	public void setCreusrid(String creusrid) {
		this.creusrid = creusrid;
	}
	
	/**
	 * Column Info
	 * @param revcount
	 */
	public void setRevcount(String revcount) {
		this.revcount = revcount;
	}
	
	/**
	 * Column Info
	 * @param weekdivision
	 */
	public void setWeekdivision(String weekdivision) {
		this.weekdivision = weekdivision;
	}
	
	/**
	 * Column Info
	 * @param week
	 */
	public void setWeek(String week) {
		this.week = week;
	}
	
	/**
	 * Column Info
	 * @param hrcount
	 */
	public void setHrcount(String hrcount) {
		this.hrcount = hrcount;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBayport(JSPUtil.getParameter(request, "bayport", ""));
		setDiv(JSPUtil.getParameter(request, "div", ""));
		setRemarkflag(JSPUtil.getParameter(request, "remarkflag", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setLane(JSPUtil.getParameter(request, "lane", ""));
		setVersion(JSPUtil.getParameter(request, "version", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setDmgcount(JSPUtil.getParameter(request, "dmgcount", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setUpdusrid(JSPUtil.getParameter(request, "updusrid", ""));
		setCreusrid(JSPUtil.getParameter(request, "creusrid", ""));
		setRevcount(JSPUtil.getParameter(request, "revcount", ""));
		setWeekdivision(JSPUtil.getParameter(request, "weekdivision", ""));
		setWeek(JSPUtil.getParameter(request, "week", ""));
		setHrcount(JSPUtil.getParameter(request, "hrcount", ""));
		setDclptsql(JSPUtil.getParameter(request, "dclptsql", ""));
		setStatus(JSPUtil.getParameter(request, "status", ""));
		setOfccd(JSPUtil.getParameter(request, "ofccd", ""));
		setRemark(JSPUtil.getParameter(request, "remark", ""));
		setCodcfmctscd(JSPUtil.getParameter(request, "codcfmctscd", ""));
		setFirstetb(JSPUtil.getParameter(request, "firstetb", ""));
		setMnlinpflg(JSPUtil.getParameter(request, "mnlinpflg", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EmptyCODVVDVO[]
	 */
	public EmptyCODVVDVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EmptyCODVVDVO[]
	 */
	public EmptyCODVVDVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EmptyCODVVDVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bayport = (JSPUtil.getParameter(request, prefix	+ "bayport", length));
			String[] div = (JSPUtil.getParameter(request, prefix	+ "div", length));
			String[] remarkflag = (JSPUtil.getParameter(request, prefix	+ "remarkflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] version = (JSPUtil.getParameter(request, prefix	+ "version", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] dmgcount = (JSPUtil.getParameter(request, prefix	+ "dmgcount", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] updusrid = (JSPUtil.getParameter(request, prefix	+ "updusrid", length));
			String[] creusrid = (JSPUtil.getParameter(request, prefix	+ "creusrid", length));
			String[] revcount = (JSPUtil.getParameter(request, prefix	+ "revcount", length));
			String[] weekdivision = (JSPUtil.getParameter(request, prefix	+ "weekdivision", length));
			String[] week = (JSPUtil.getParameter(request, prefix	+ "week", length));
			String[] hrcount = (JSPUtil.getParameter(request, prefix	+ "hrcount", length));
			String[] dclptsql = (JSPUtil.getParameter(request, prefix	+ "dclptsql", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] ofccd = (JSPUtil.getParameter(request, prefix	+ "ofccd", length));
			String[] remark = (JSPUtil.getParameter(request, prefix	+ "remark", length));
			String[] codcfmctscd = (JSPUtil.getParameter(request, prefix	+ "codcfmctscd", length));
			String[] firstetb = (JSPUtil.getParameter(request, prefix	+ "firstetb", length));
			String[] mnlinpflg = (JSPUtil.getParameter(request, prefix	+ "mnlinpflg", length));
					
			for (int i = 0; i < length; i++) {
				model = new EmptyCODVVDVO();
				if (bayport[i] != null)
					model.setBayport(bayport[i]);
				if (div[i] != null)
					model.setDiv(div[i]);
				if (remarkflag[i] != null)
					model.setRemarkflag(remarkflag[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (version[i] != null)
					model.setVersion(version[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (dmgcount[i] != null)
					model.setDmgcount(dmgcount[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (updusrid[i] != null)
					model.setUpdusrid(updusrid[i]);
				if (creusrid[i] != null)
					model.setCreusrid(creusrid[i]);
				if (revcount[i] != null)
					model.setRevcount(revcount[i]);
				if (weekdivision[i] != null)
					model.setWeekdivision(weekdivision[i]);
				if (week[i] != null)
					model.setWeek(week[i]);
				if (hrcount[i] != null)
					model.setHrcount(hrcount[i]);
				if (dclptsql[i] != null)
					model.setDclptsql(dclptsql[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (ofccd[i] != null)
					model.setOfccd(ofccd[i]);
				if (remark[i] != null)
					model.setRemark(remark[i]);
				if (codcfmctscd[i] != null)
					model.setCodcfmctscd(codcfmctscd[i]);
				if (firstetb[i] != null)
					model.setFirstetb(firstetb[i]);
				if (mnlinpflg[i] != null)
					model.setMnlinpflg(mnlinpflg[i]);
				models.add(model);
			}
			
		} catch (Exception e) {
			return null;
		}
		return getEmptyCODVVDVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EmptyCODVVDVO[]
	 */
	public EmptyCODVVDVO[] getEmptyCODVVDVOs(){
		EmptyCODVVDVO[] vos = (EmptyCODVVDVO[])models.toArray(new EmptyCODVVDVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
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
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.bayport = this.bayport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.div = this.div .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remarkflag = this.remarkflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.version = this.version .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgcount = this.dmgcount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updusrid = this.updusrid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creusrid = this.creusrid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revcount = this.revcount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.weekdivision = this.weekdivision .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.week = this.week .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hrcount = this.hrcount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dclptsql = this.dclptsql .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofccd = this.ofccd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark = this.remark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codcfmctscd = this.codcfmctscd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.firstetb = this.firstetb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlinpflg = this.mnlinpflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
