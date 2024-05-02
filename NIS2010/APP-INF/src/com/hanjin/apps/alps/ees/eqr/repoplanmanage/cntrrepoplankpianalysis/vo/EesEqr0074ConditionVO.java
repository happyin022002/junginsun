/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0074ConditionVO.java
*@FileTitle : EesEqr0074ConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.09.24 채창호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplankpianalysis.vo;

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
 * @author 채창호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr0074ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0074ConditionVO> models = new ArrayList<EesEqr0074ConditionVO>();
	
	/* Column Info */
	private String trade = null;
	/* Column Info */
	private String toYyyy = null;
	/* Column Info */
	private String loclist = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String lane = null;
	/* Column Info */
	private String yyyyww = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String frWeek = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String toWeek = null;
	/* Column Info */
	private String company = null;
	/* Column Info */
	private String loctype = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String report = null;
	/* Column Info */
	private String frYyyy = null;
	/* Column Info */
	private String repoplanid = null;
	/* Column Info */
	private String based = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0074ConditionVO() {}

	public EesEqr0074ConditionVO(String ibflag, String pagerows, String based, String company, String loctype, String loclist, String report, String frYyyy, String frWeek, String toYyyy, String toWeek, String trade, String lane, String vvd, String yyyyww, String seq, String repoplanid) {
		this.trade = trade;
		this.toYyyy = toYyyy;
		this.loclist = loclist;
		this.pagerows = pagerows;
		this.lane = lane;
		this.yyyyww = yyyyww;
		this.vvd = vvd;
		this.frWeek = frWeek;
		this.ibflag = ibflag;
		this.toWeek = toWeek;
		this.company = company;
		this.loctype = loctype;
		this.seq = seq;
		this.report = report;
		this.frYyyy = frYyyy;
		this.repoplanid = repoplanid;
		this.based = based;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("trade", getTrade());
		this.hashColumns.put("to_yyyy", getToYyyy());
		this.hashColumns.put("loclist", getLoclist());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("yyyyww", getYyyyww());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("fr_week", getFrWeek());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("to_week", getToWeek());
		this.hashColumns.put("company", getCompany());
		this.hashColumns.put("loctype", getLoctype());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("report", getReport());
		this.hashColumns.put("fr_yyyy", getFrYyyy());
		this.hashColumns.put("repoplanid", getRepoplanid());
		this.hashColumns.put("based", getBased());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("trade", "trade");
		this.hashFields.put("to_yyyy", "toYyyy");
		this.hashFields.put("loclist", "loclist");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("yyyyww", "yyyyww");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("fr_week", "frWeek");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("to_week", "toWeek");
		this.hashFields.put("company", "company");
		this.hashFields.put("loctype", "loctype");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("report", "report");
		this.hashFields.put("fr_yyyy", "frYyyy");
		this.hashFields.put("repoplanid", "repoplanid");
		this.hashFields.put("based", "based");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return trade
	 */
	public String getTrade() {
		return this.trade;
	}
	
	/**
	 * Column Info
	 * @return toYyyy
	 */
	public String getToYyyy() {
		return this.toYyyy;
	}
	
	/**
	 * Column Info
	 * @return loclist
	 */
	public String getLoclist() {
		return this.loclist;
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
	 * @return yyyyww
	 */
	public String getYyyyww() {
		return this.yyyyww;
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
	 * @return frWeek
	 */
	public String getFrWeek() {
		return this.frWeek;
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
	 * @return toWeek
	 */
	public String getToWeek() {
		return this.toWeek;
	}
	
	/**
	 * Column Info
	 * @return company
	 */
	public String getCompany() {
		return this.company;
	}
	
	/**
	 * Column Info
	 * @return loctype
	 */
	public String getLoctype() {
		return this.loctype;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return report
	 */
	public String getReport() {
		return this.report;
	}
	
	/**
	 * Column Info
	 * @return frYyyy
	 */
	public String getFrYyyy() {
		return this.frYyyy;
	}
	
	/**
	 * Column Info
	 * @return repoplanid
	 */
	public String getRepoplanid() {
		return this.repoplanid;
	}
	
	/**
	 * Column Info
	 * @return based
	 */
	public String getBased() {
		return this.based;
	}
	

	/**
	 * Column Info
	 * @param trade
	 */
	public void setTrade(String trade) {
		this.trade = trade;
	}
	
	/**
	 * Column Info
	 * @param toYyyy
	 */
	public void setToYyyy(String toYyyy) {
		this.toYyyy = toYyyy;
	}
	
	/**
	 * Column Info
	 * @param loclist
	 */
	public void setLoclist(String loclist) {
		this.loclist = loclist;
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
	 * @param yyyyww
	 */
	public void setYyyyww(String yyyyww) {
		this.yyyyww = yyyyww;
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
	 * @param frWeek
	 */
	public void setFrWeek(String frWeek) {
		this.frWeek = frWeek;
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
	 * @param toWeek
	 */
	public void setToWeek(String toWeek) {
		this.toWeek = toWeek;
	}
	
	/**
	 * Column Info
	 * @param company
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	
	/**
	 * Column Info
	 * @param loctype
	 */
	public void setLoctype(String loctype) {
		this.loctype = loctype;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param report
	 */
	public void setReport(String report) {
		this.report = report;
	}
	
	/**
	 * Column Info
	 * @param frYyyy
	 */
	public void setFrYyyy(String frYyyy) {
		this.frYyyy = frYyyy;
	}
	
	/**
	 * Column Info
	 * @param repoplanid
	 */
	public void setRepoplanid(String repoplanid) {
		this.repoplanid = repoplanid;
	}
	
	/**
	 * Column Info
	 * @param based
	 */
	public void setBased(String based) {
		this.based = based;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTrade(JSPUtil.getParameter(request, "trade", ""));
		setToYyyy(JSPUtil.getParameter(request, "to_yyyy", ""));
		setLoclist(JSPUtil.getParameter(request, "loclist", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setLane(JSPUtil.getParameter(request, "lane", ""));
		setYyyyww(JSPUtil.getParameter(request, "yyyyww", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setFrWeek(JSPUtil.getParameter(request, "fr_week", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setToWeek(JSPUtil.getParameter(request, "to_week", ""));
		setCompany(JSPUtil.getParameter(request, "company", ""));
		setLoctype(JSPUtil.getParameter(request, "loctype", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setReport(JSPUtil.getParameter(request, "report", ""));
		setFrYyyy(JSPUtil.getParameter(request, "fr_yyyy", ""));
		setRepoplanid(JSPUtil.getParameter(request, "repoplanid", ""));
		setBased(JSPUtil.getParameter(request, "based", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr0074ConditionVO[]
	 */
	public EesEqr0074ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr0074ConditionVO[]
	 */
	public EesEqr0074ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0074ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] trade = (JSPUtil.getParameter(request, prefix	+ "trade", length));
			String[] toYyyy = (JSPUtil.getParameter(request, prefix	+ "to_yyyy", length));
			String[] loclist = (JSPUtil.getParameter(request, prefix	+ "loclist", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] yyyyww = (JSPUtil.getParameter(request, prefix	+ "yyyyww", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] frWeek = (JSPUtil.getParameter(request, prefix	+ "fr_week", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] toWeek = (JSPUtil.getParameter(request, prefix	+ "to_week", length));
			String[] company = (JSPUtil.getParameter(request, prefix	+ "company", length));
			String[] loctype = (JSPUtil.getParameter(request, prefix	+ "loctype", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] report = (JSPUtil.getParameter(request, prefix	+ "report", length));
			String[] frYyyy = (JSPUtil.getParameter(request, prefix	+ "fr_yyyy", length));
			String[] repoplanid = (JSPUtil.getParameter(request, prefix	+ "repoplanid", length));
			String[] based = (JSPUtil.getParameter(request, prefix	+ "based", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0074ConditionVO();
				if (trade[i] != null)
					model.setTrade(trade[i]);
				if (toYyyy[i] != null)
					model.setToYyyy(toYyyy[i]);
				if (loclist[i] != null)
					model.setLoclist(loclist[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (yyyyww[i] != null)
					model.setYyyyww(yyyyww[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (frWeek[i] != null)
					model.setFrWeek(frWeek[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (toWeek[i] != null)
					model.setToWeek(toWeek[i]);
				if (company[i] != null)
					model.setCompany(company[i]);
				if (loctype[i] != null)
					model.setLoctype(loctype[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (report[i] != null)
					model.setReport(report[i]);
				if (frYyyy[i] != null)
					model.setFrYyyy(frYyyy[i]);
				if (repoplanid[i] != null)
					model.setRepoplanid(repoplanid[i]);
				if (based[i] != null)
					model.setBased(based[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr0074ConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr0074ConditionVO[]
	 */
	public EesEqr0074ConditionVO[] getEesEqr0074ConditionVOs(){
		EesEqr0074ConditionVO[] vos = (EesEqr0074ConditionVO[])models.toArray(new EesEqr0074ConditionVO[models.size()]);
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
		this.trade = this.trade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toYyyy = this.toYyyy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclist = this.loclist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yyyyww = this.yyyyww .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frWeek = this.frWeek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toWeek = this.toWeek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.company = this.company .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loctype = this.loctype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.report = this.report .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frYyyy = this.frYyyy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoplanid = this.repoplanid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.based = this.based .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
