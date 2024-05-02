/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CHSInventoryGeneralINVO.java
*@FileTitle : CHSInventoryGeneralINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.07.23 김창식 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김창식
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CHSInventoryGeneralINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CHSInventoryGeneralINVO> models = new ArrayList<CHSInventoryGeneralINVO>();
	
	/* Column Info */
	private String eqTpszCdSf4 = null;
	/* Column Info */
	private String chssPoolCd = null;
	/* Column Info */
	private String location = null;
	/* Column Info */
	private String includeNp = null;
	/* Column Info */
	private String eqTpszCdSl2 = null;
	/* Column Info */
	private String crntYdCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqTpszCdEg8 = null;
	/* Column Info */
	private String eqTpszCdZt4 = null;
	/* Column Info */
	private String eqTpszCdTa2 = null;
	/* Column Info */
	private String eqTpszCdEg5 = null;
	/* Column Info */
	private String group3 = null;
	/* Column Info */
	private String group1 = null;
	/* Column Info */
	private String group2 = null;
	/* Column Info */
	private String eqTpszCdSf2 = null;
	/* Column Info */
	private String eqTpszCdCb4 = null;
	/* Column Info */
	private String agmtLstmCd = null;
	/* Column Info */
	private String aciacDivCd = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String eqTpszCdGn4 = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String eqTpszCdGn5 = null;
	/* Column Info */
	private String stayingDays = null;
	/* Column Info */
	private String chssMvmtStsCd = null;
	/* Column Info */
	private String crntLocCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CHSInventoryGeneralINVO() {}

	public CHSInventoryGeneralINVO(String ibflag, String pagerows, String location, String eqKndCd, String crntLocCd, String crntYdCd, String aciacDivCd, String chssPoolCd, String includeNp, String stayingDays, String group1, String group2, String group3, String eqTpszCd, String agmtLstmCd, String vndrSeq, String chssMvmtStsCd, String eqTpszCdSf2, String eqTpszCdSl2, String eqTpszCdTa2, String eqTpszCdSf4, String eqTpszCdGn4, String eqTpszCdCb4, String eqTpszCdEg5, String eqTpszCdGn5, String eqTpszCdEg8, String eqTpszCdZt4) {
		this.eqTpszCdSf4 = eqTpszCdSf4;
		this.chssPoolCd = chssPoolCd;
		this.location = location;
		this.includeNp = includeNp;
		this.eqTpszCdSl2 = eqTpszCdSl2;
		this.crntYdCd = crntYdCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.eqTpszCdEg8 = eqTpszCdEg8;
		this.eqTpszCdZt4 = eqTpszCdZt4;
		this.eqTpszCdTa2 = eqTpszCdTa2;
		this.eqTpszCdEg5 = eqTpszCdEg5;
		this.group3 = group3;
		this.group1 = group1;
		this.group2 = group2;
		this.eqTpszCdSf2 = eqTpszCdSf2;
		this.eqTpszCdCb4 = eqTpszCdCb4;
		this.agmtLstmCd = agmtLstmCd;
		this.aciacDivCd = aciacDivCd;
		this.eqKndCd = eqKndCd;
		this.eqTpszCd = eqTpszCd;
		this.eqTpszCdGn4 = eqTpszCdGn4;
		this.vndrSeq = vndrSeq;
		this.eqTpszCdGn5 = eqTpszCdGn5;
		this.stayingDays = stayingDays;
		this.chssMvmtStsCd = chssMvmtStsCd;
		this.crntLocCd = crntLocCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eq_tpsz_cd_sf4", getEqTpszCdSf4());
		this.hashColumns.put("chss_pool_cd", getChssPoolCd());
		this.hashColumns.put("location", getLocation());
		this.hashColumns.put("include_np", getIncludeNp());
		this.hashColumns.put("eq_tpsz_cd_sl2", getEqTpszCdSl2());
		this.hashColumns.put("crnt_yd_cd", getCrntYdCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_tpsz_cd_eg8", getEqTpszCdEg8());
		this.hashColumns.put("eq_tpsz_cd_zt4", getEqTpszCdZt4());
		this.hashColumns.put("eq_tpsz_cd_ta2", getEqTpszCdTa2());
		this.hashColumns.put("eq_tpsz_cd_eg5", getEqTpszCdEg5());
		this.hashColumns.put("group3", getGroup3());
		this.hashColumns.put("group1", getGroup1());
		this.hashColumns.put("group2", getGroup2());
		this.hashColumns.put("eq_tpsz_cd_sf2", getEqTpszCdSf2());
		this.hashColumns.put("eq_tpsz_cd_cb4", getEqTpszCdCb4());
		this.hashColumns.put("agmt_lstm_cd", getAgmtLstmCd());
		this.hashColumns.put("aciac_div_cd", getAciacDivCd());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("eq_tpsz_cd_gn4", getEqTpszCdGn4());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("eq_tpsz_cd_gn5", getEqTpszCdGn5());
		this.hashColumns.put("staying_days", getStayingDays());
		this.hashColumns.put("chss_mvmt_sts_cd", getChssMvmtStsCd());
		this.hashColumns.put("crnt_loc_cd", getCrntLocCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eq_tpsz_cd_sf4", "eqTpszCdSf4");
		this.hashFields.put("chss_pool_cd", "chssPoolCd");
		this.hashFields.put("location", "location");
		this.hashFields.put("include_np", "includeNp");
		this.hashFields.put("eq_tpsz_cd_sl2", "eqTpszCdSl2");
		this.hashFields.put("crnt_yd_cd", "crntYdCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_tpsz_cd_eg8", "eqTpszCdEg8");
		this.hashFields.put("eq_tpsz_cd_zt4", "eqTpszCdZt4");
		this.hashFields.put("eq_tpsz_cd_ta2", "eqTpszCdTa2");
		this.hashFields.put("eq_tpsz_cd_eg5", "eqTpszCdEg5");
		this.hashFields.put("group3", "group3");
		this.hashFields.put("group1", "group1");
		this.hashFields.put("group2", "group2");
		this.hashFields.put("eq_tpsz_cd_sf2", "eqTpszCdSf2");
		this.hashFields.put("eq_tpsz_cd_cb4", "eqTpszCdCb4");
		this.hashFields.put("agmt_lstm_cd", "agmtLstmCd");
		this.hashFields.put("aciac_div_cd", "aciacDivCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("eq_tpsz_cd_gn4", "eqTpszCdGn4");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("eq_tpsz_cd_gn5", "eqTpszCdGn5");
		this.hashFields.put("staying_days", "stayingDays");
		this.hashFields.put("chss_mvmt_sts_cd", "chssMvmtStsCd");
		this.hashFields.put("crnt_loc_cd", "crntLocCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCdSf4
	 */
	public String getEqTpszCdSf4() {
		return this.eqTpszCdSf4;
	}
	
	/**
	 * Column Info
	 * @return chssPoolCd
	 */
	public String getChssPoolCd() {
		return this.chssPoolCd;
	}
	
	/**
	 * Column Info
	 * @return location
	 */
	public String getLocation() {
		return this.location;
	}
	
	/**
	 * Column Info
	 * @return includeNp
	 */
	public String getIncludeNp() {
		return this.includeNp;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCdSl2
	 */
	public String getEqTpszCdSl2() {
		return this.eqTpszCdSl2;
	}
	
	/**
	 * Column Info
	 * @return crntYdCd
	 */
	public String getCrntYdCd() {
		return this.crntYdCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return eqTpszCdEg8
	 */
	public String getEqTpszCdEg8() {
		return this.eqTpszCdEg8;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCdZt4
	 */
	public String getEqTpszCdZt4() {
		return this.eqTpszCdZt4;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCdTa2
	 */
	public String getEqTpszCdTa2() {
		return this.eqTpszCdTa2;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCdEg5
	 */
	public String getEqTpszCdEg5() {
		return this.eqTpszCdEg5;
	}
	
	/**
	 * Column Info
	 * @return group3
	 */
	public String getGroup3() {
		return this.group3;
	}
	
	/**
	 * Column Info
	 * @return group1
	 */
	public String getGroup1() {
		return this.group1;
	}
	
	/**
	 * Column Info
	 * @return group2
	 */
	public String getGroup2() {
		return this.group2;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCdSf2
	 */
	public String getEqTpszCdSf2() {
		return this.eqTpszCdSf2;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCdCb4
	 */
	public String getEqTpszCdCb4() {
		return this.eqTpszCdCb4;
	}
	
	/**
	 * Column Info
	 * @return agmtLstmCd
	 */
	public String getAgmtLstmCd() {
		return this.agmtLstmCd;
	}
	
	/**
	 * Column Info
	 * @return aciacDivCd
	 */
	public String getAciacDivCd() {
		return this.aciacDivCd;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCdGn4
	 */
	public String getEqTpszCdGn4() {
		return this.eqTpszCdGn4;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCdGn5
	 */
	public String getEqTpszCdGn5() {
		return this.eqTpszCdGn5;
	}
	
	/**
	 * Column Info
	 * @return stayingDays
	 */
	public String getStayingDays() {
		return this.stayingDays;
	}
	
	/**
	 * Column Info
	 * @return chssMvmtStsCd
	 */
	public String getChssMvmtStsCd() {
		return this.chssMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @return crntLocCd
	 */
	public String getCrntLocCd() {
		return this.crntLocCd;
	}
	

	/**
	 * Column Info
	 * @param eqTpszCdSf4
	 */
	public void setEqTpszCdSf4(String eqTpszCdSf4) {
		this.eqTpszCdSf4 = eqTpszCdSf4;
	}
	
	/**
	 * Column Info
	 * @param chssPoolCd
	 */
	public void setChssPoolCd(String chssPoolCd) {
		this.chssPoolCd = chssPoolCd;
	}
	
	/**
	 * Column Info
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * Column Info
	 * @param includeNp
	 */
	public void setIncludeNp(String includeNp) {
		this.includeNp = includeNp;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCdSl2
	 */
	public void setEqTpszCdSl2(String eqTpszCdSl2) {
		this.eqTpszCdSl2 = eqTpszCdSl2;
	}
	
	/**
	 * Column Info
	 * @param crntYdCd
	 */
	public void setCrntYdCd(String crntYdCd) {
		this.crntYdCd = crntYdCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param eqTpszCdEg8
	 */
	public void setEqTpszCdEg8(String eqTpszCdEg8) {
		this.eqTpszCdEg8 = eqTpszCdEg8;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCdZt4
	 */
	public void setEqTpszCdZt4(String eqTpszCdZt4) {
		this.eqTpszCdZt4 = eqTpszCdZt4;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCdTa2
	 */
	public void setEqTpszCdTa2(String eqTpszCdTa2) {
		this.eqTpszCdTa2 = eqTpszCdTa2;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCdEg5
	 */
	public void setEqTpszCdEg5(String eqTpszCdEg5) {
		this.eqTpszCdEg5 = eqTpszCdEg5;
	}
	
	/**
	 * Column Info
	 * @param group3
	 */
	public void setGroup3(String group3) {
		this.group3 = group3;
	}
	
	/**
	 * Column Info
	 * @param group1
	 */
	public void setGroup1(String group1) {
		this.group1 = group1;
	}
	
	/**
	 * Column Info
	 * @param group2
	 */
	public void setGroup2(String group2) {
		this.group2 = group2;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCdSf2
	 */
	public void setEqTpszCdSf2(String eqTpszCdSf2) {
		this.eqTpszCdSf2 = eqTpszCdSf2;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCdCb4
	 */
	public void setEqTpszCdCb4(String eqTpszCdCb4) {
		this.eqTpszCdCb4 = eqTpszCdCb4;
	}
	
	/**
	 * Column Info
	 * @param agmtLstmCd
	 */
	public void setAgmtLstmCd(String agmtLstmCd) {
		this.agmtLstmCd = agmtLstmCd;
	}
	
	/**
	 * Column Info
	 * @param aciacDivCd
	 */
	public void setAciacDivCd(String aciacDivCd) {
		this.aciacDivCd = aciacDivCd;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCdGn4
	 */
	public void setEqTpszCdGn4(String eqTpszCdGn4) {
		this.eqTpszCdGn4 = eqTpszCdGn4;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCdGn5
	 */
	public void setEqTpszCdGn5(String eqTpszCdGn5) {
		this.eqTpszCdGn5 = eqTpszCdGn5;
	}
	
	/**
	 * Column Info
	 * @param stayingDays
	 */
	public void setStayingDays(String stayingDays) {
		this.stayingDays = stayingDays;
	}
	
	/**
	 * Column Info
	 * @param chssMvmtStsCd
	 */
	public void setChssMvmtStsCd(String chssMvmtStsCd) {
		this.chssMvmtStsCd = chssMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @param crntLocCd
	 */
	public void setCrntLocCd(String crntLocCd) {
		this.crntLocCd = crntLocCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setEqTpszCdSf4(JSPUtil.getParameter(request, "eq_tpsz_cd_sf4", ""));
		setChssPoolCd(JSPUtil.getParameter(request, "chss_pool_cd", ""));
		setLocation(JSPUtil.getParameter(request, "location", ""));
		setIncludeNp(JSPUtil.getParameter(request, "include_np", ""));
		setEqTpszCdSl2(JSPUtil.getParameter(request, "eq_tpsz_cd_sl2", ""));
		setCrntYdCd(JSPUtil.getParameter(request, "crnt_yd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEqTpszCdEg8(JSPUtil.getParameter(request, "eq_tpsz_cd_eg8", ""));
		setEqTpszCdZt4(JSPUtil.getParameter(request, "eq_tpsz_cd_zt4", ""));
		setEqTpszCdTa2(JSPUtil.getParameter(request, "eq_tpsz_cd_ta2", ""));
		setEqTpszCdEg5(JSPUtil.getParameter(request, "eq_tpsz_cd_eg5", ""));
		setGroup3(JSPUtil.getParameter(request, "group3", ""));
		setGroup1(JSPUtil.getParameter(request, "group1", ""));
		setGroup2(JSPUtil.getParameter(request, "group2", ""));
		setEqTpszCdSf2(JSPUtil.getParameter(request, "eq_tpsz_cd_sf2", ""));
		setEqTpszCdCb4(JSPUtil.getParameter(request, "eq_tpsz_cd_cb4", ""));
		setAgmtLstmCd(JSPUtil.getParameter(request, "agmt_lstm_cd", ""));
		setAciacDivCd(JSPUtil.getParameter(request, "aciac_div_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setEqTpszCdGn4(JSPUtil.getParameter(request, "eq_tpsz_cd_gn4", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setEqTpszCdGn5(JSPUtil.getParameter(request, "eq_tpsz_cd_gn5", ""));
		setStayingDays(JSPUtil.getParameter(request, "staying_days", ""));
		setChssMvmtStsCd(JSPUtil.getParameter(request, "chss_mvmt_sts_cd", ""));
		setCrntLocCd(JSPUtil.getParameter(request, "crnt_loc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CHSInventoryGeneralINVO[]
	 */
	public CHSInventoryGeneralINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CHSInventoryGeneralINVO[]
	 */
	public CHSInventoryGeneralINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CHSInventoryGeneralINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] eqTpszCdSf4 = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd_sf4", length));
			String[] chssPoolCd = (JSPUtil.getParameter(request, prefix	+ "chss_pool_cd", length));
			String[] location = (JSPUtil.getParameter(request, prefix	+ "location", length));
			String[] includeNp = (JSPUtil.getParameter(request, prefix	+ "include_np", length));
			String[] eqTpszCdSl2 = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd_sl2", length));
			String[] crntYdCd = (JSPUtil.getParameter(request, prefix	+ "crnt_yd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqTpszCdEg8 = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd_eg8", length));
			String[] eqTpszCdZt4 = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd_zt4", length));
			String[] eqTpszCdTa2 = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd_ta2", length));
			String[] eqTpszCdEg5 = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd_eg5", length));
			String[] group3 = (JSPUtil.getParameter(request, prefix	+ "group3", length));
			String[] group1 = (JSPUtil.getParameter(request, prefix	+ "group1", length));
			String[] group2 = (JSPUtil.getParameter(request, prefix	+ "group2", length));
			String[] eqTpszCdSf2 = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd_sf2", length));
			String[] eqTpszCdCb4 = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd_cb4", length));
			String[] agmtLstmCd = (JSPUtil.getParameter(request, prefix	+ "agmt_lstm_cd", length));
			String[] aciacDivCd = (JSPUtil.getParameter(request, prefix	+ "aciac_div_cd", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] eqTpszCdGn4 = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd_gn4", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] eqTpszCdGn5 = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd_gn5", length));
			String[] stayingDays = (JSPUtil.getParameter(request, prefix	+ "staying_days", length));
			String[] chssMvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "chss_mvmt_sts_cd", length));
			String[] crntLocCd = (JSPUtil.getParameter(request, prefix	+ "crnt_loc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CHSInventoryGeneralINVO();
				if (eqTpszCdSf4[i] != null)
					model.setEqTpszCdSf4(eqTpszCdSf4[i]);
				if (chssPoolCd[i] != null)
					model.setChssPoolCd(chssPoolCd[i]);
				if (location[i] != null)
					model.setLocation(location[i]);
				if (includeNp[i] != null)
					model.setIncludeNp(includeNp[i]);
				if (eqTpszCdSl2[i] != null)
					model.setEqTpszCdSl2(eqTpszCdSl2[i]);
				if (crntYdCd[i] != null)
					model.setCrntYdCd(crntYdCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqTpszCdEg8[i] != null)
					model.setEqTpszCdEg8(eqTpszCdEg8[i]);
				if (eqTpszCdZt4[i] != null)
					model.setEqTpszCdZt4(eqTpszCdZt4[i]);
				if (eqTpszCdTa2[i] != null)
					model.setEqTpszCdTa2(eqTpszCdTa2[i]);
				if (eqTpszCdEg5[i] != null)
					model.setEqTpszCdEg5(eqTpszCdEg5[i]);
				if (group3[i] != null)
					model.setGroup3(group3[i]);
				if (group1[i] != null)
					model.setGroup1(group1[i]);
				if (group2[i] != null)
					model.setGroup2(group2[i]);
				if (eqTpszCdSf2[i] != null)
					model.setEqTpszCdSf2(eqTpszCdSf2[i]);
				if (eqTpszCdCb4[i] != null)
					model.setEqTpszCdCb4(eqTpszCdCb4[i]);
				if (agmtLstmCd[i] != null)
					model.setAgmtLstmCd(agmtLstmCd[i]);
				if (aciacDivCd[i] != null)
					model.setAciacDivCd(aciacDivCd[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (eqTpszCdGn4[i] != null)
					model.setEqTpszCdGn4(eqTpszCdGn4[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (eqTpszCdGn5[i] != null)
					model.setEqTpszCdGn5(eqTpszCdGn5[i]);
				if (stayingDays[i] != null)
					model.setStayingDays(stayingDays[i]);
				if (chssMvmtStsCd[i] != null)
					model.setChssMvmtStsCd(chssMvmtStsCd[i]);
				if (crntLocCd[i] != null)
					model.setCrntLocCd(crntLocCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCHSInventoryGeneralINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CHSInventoryGeneralINVO[]
	 */
	public CHSInventoryGeneralINVO[] getCHSInventoryGeneralINVOs(){
		CHSInventoryGeneralINVO[] vos = (CHSInventoryGeneralINVO[])models.toArray(new CHSInventoryGeneralINVO[models.size()]);
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
		this.eqTpszCdSf4 = this.eqTpszCdSf4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssPoolCd = this.chssPoolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.location = this.location .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.includeNp = this.includeNp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdSl2 = this.eqTpszCdSl2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntYdCd = this.crntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdEg8 = this.eqTpszCdEg8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdZt4 = this.eqTpszCdZt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdTa2 = this.eqTpszCdTa2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdEg5 = this.eqTpszCdEg5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.group3 = this.group3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.group1 = this.group1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.group2 = this.group2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdSf2 = this.eqTpszCdSf2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdCb4 = this.eqTpszCdCb4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtLstmCd = this.agmtLstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aciacDivCd = this.aciacDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdGn4 = this.eqTpszCdGn4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdGn5 = this.eqTpszCdGn5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayingDays = this.stayingDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssMvmtStsCd = this.chssMvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntLocCd = this.crntLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
