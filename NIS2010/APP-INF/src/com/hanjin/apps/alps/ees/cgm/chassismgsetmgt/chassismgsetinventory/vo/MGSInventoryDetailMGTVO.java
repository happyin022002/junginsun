/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MGSInventoryDetailMGTVO.java
*@FileTitle : MGSInventoryDetailMGTVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.23
*@LastModifier : Chang Young Kim
*@LastVersion : 1.0
* 2015.06.23  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MGSInventoryDetailMGTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MGSInventoryDetailMGTVO> models = new ArrayList<MGSInventoryDetailMGTVO>();
	
	/* Column Info */
	private String atchDtHd = null;
	/* Column Info */
	private String dmgFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String chssMvmtDt = null;
	/* Column Info */
	private String atchDtch = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String stayDys = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String dtchYdCd = null;
	/* Column Info */
	private String dtchDtYmd = null;
	/* Column Info */
	private String updDtHd = null;
	/* Column Info */
	private String lstYd = null;
	/* Column Info */
	private String atchYdCd = null;
	/* Column Info */
	private String updDtYmd = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String agmtLstmCd = null;
	/* Column Info */
	private String aciacDivCd = null;
	/* Column Info */
	private String dtchDtHd = null;
	/* Column Info */
	private String cntrChss = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String dispFlg = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String stsUpdDt = null;
	/* Column Info */
	private String chssMvmtStsCd = null;
	/* Column Info */
	private String atchDtYmd = null;
	/* Column Info */
	private String lccCd = null;
	/* Column Info */
	private String sccCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public MGSInventoryDetailMGTVO() {}

	public MGSInventoryDetailMGTVO(String ibflag, String pagerows, String eqNo, String eqTpszCd, String agmtLstmCd, String agmtNo, String aciacDivCd, String dmgFlg, String dispFlg, String atchDtch, String lstYd, String stsUpdDt, String stayDys, String cntrChss, String chssMvmtStsCd, String chssMvmtDt, String atchDtYmd, String atchDtHd, String atchYdCd, String dtchDtYmd, String dtchDtHd, String dtchYdCd, String updDtYmd, String updDtHd, String ofcCd, String usrNm, String lccCd, String sccCd) {
		this.atchDtHd = atchDtHd;
		this.dmgFlg = dmgFlg;
		this.pagerows = pagerows;
		this.chssMvmtDt = chssMvmtDt;
		this.atchDtch = atchDtch;
		this.ibflag = ibflag;
		this.stayDys = stayDys;
		this.eqNo = eqNo;
		this.usrNm = usrNm;
		this.dtchYdCd = dtchYdCd;
		this.dtchDtYmd = dtchDtYmd;
		this.updDtHd = updDtHd;
		this.lstYd = lstYd;
		this.atchYdCd = atchYdCd;
		this.updDtYmd = updDtYmd;
		this.agmtNo = agmtNo;
		this.agmtLstmCd = agmtLstmCd;
		this.aciacDivCd = aciacDivCd;
		this.dtchDtHd = dtchDtHd;
		this.cntrChss = cntrChss;
		this.eqTpszCd = eqTpszCd;
		this.dispFlg = dispFlg;
		this.ofcCd = ofcCd;
		this.stsUpdDt = stsUpdDt;
		this.chssMvmtStsCd = chssMvmtStsCd;
		this.atchDtYmd = atchDtYmd;
		this.lccCd = lccCd;
		this.sccCd = sccCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("atch_dt_hd", getAtchDtHd());
		this.hashColumns.put("dmg_flg", getDmgFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("chss_mvmt_dt", getChssMvmtDt());
		this.hashColumns.put("atch_dtch", getAtchDtch());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("stay_dys", getStayDys());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("dtch_yd_cd", getDtchYdCd());
		this.hashColumns.put("dtch_dt_ymd", getDtchDtYmd());
		this.hashColumns.put("upd_dt_hd", getUpdDtHd());
		this.hashColumns.put("lst_yd", getLstYd());
		this.hashColumns.put("atch_yd_cd", getAtchYdCd());
		this.hashColumns.put("upd_dt_ymd", getUpdDtYmd());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("agmt_lstm_cd", getAgmtLstmCd());
		this.hashColumns.put("aciac_div_cd", getAciacDivCd());
		this.hashColumns.put("dtch_dt_hd", getDtchDtHd());
		this.hashColumns.put("cntr_chss", getCntrChss());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("disp_flg", getDispFlg());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("sts_upd_dt", getStsUpdDt());
		this.hashColumns.put("chss_mvmt_sts_cd", getChssMvmtStsCd());
		this.hashColumns.put("atch_dt_ymd", getAtchDtYmd());
		this.hashColumns.put("lcc_cd", getLccCd());
		this.hashColumns.put("scc_cd", getSccCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("atch_dt_hd", "atchDtHd");
		this.hashFields.put("dmg_flg", "dmgFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("chss_mvmt_dt", "chssMvmtDt");
		this.hashFields.put("atch_dtch", "atchDtch");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("stay_dys", "stayDys");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("dtch_yd_cd", "dtchYdCd");
		this.hashFields.put("dtch_dt_ymd", "dtchDtYmd");
		this.hashFields.put("upd_dt_hd", "updDtHd");
		this.hashFields.put("lst_yd", "lstYd");
		this.hashFields.put("atch_yd_cd", "atchYdCd");
		this.hashFields.put("upd_dt_ymd", "updDtYmd");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("agmt_lstm_cd", "agmtLstmCd");
		this.hashFields.put("aciac_div_cd", "aciacDivCd");
		this.hashFields.put("dtch_dt_hd", "dtchDtHd");
		this.hashFields.put("cntr_chss", "cntrChss");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("disp_flg", "dispFlg");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("sts_upd_dt", "stsUpdDt");
		this.hashFields.put("chss_mvmt_sts_cd", "chssMvmtStsCd");
		this.hashFields.put("atch_dt_ymd", "atchDtYmd");
		this.hashFields.put("lcc_cd", "lccCd");
		this.hashFields.put("scc_cd", "sccCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return atchDtHd
	 */
	public String getAtchDtHd() {
		return this.atchDtHd;
	}
	
	/**
	 * Column Info
	 * @return dmgFlg
	 */
	public String getDmgFlg() {
		return this.dmgFlg;
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
	 * @return chssMvmtDt
	 */
	public String getChssMvmtDt() {
		return this.chssMvmtDt;
	}
	
	/**
	 * Column Info
	 * @return atchDtch
	 */
	public String getAtchDtch() {
		return this.atchDtch;
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
	 * @return stayDys
	 */
	public String getStayDys() {
		return this.stayDys;
	}
	
	/**
	 * Column Info
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
	}
	
	/**
	 * Column Info
	 * @return dtchYdCd
	 */
	public String getDtchYdCd() {
		return this.dtchYdCd;
	}
	
	/**
	 * Column Info
	 * @return dtchDtYmd
	 */
	public String getDtchDtYmd() {
		return this.dtchDtYmd;
	}
	
	/**
	 * Column Info
	 * @return updDtHd
	 */
	public String getUpdDtHd() {
		return this.updDtHd;
	}
	
	/**
	 * Column Info
	 * @return lstYd
	 */
	public String getLstYd() {
		return this.lstYd;
	}
	
	/**
	 * Column Info
	 * @return atchYdCd
	 */
	public String getAtchYdCd() {
		return this.atchYdCd;
	}
	
	/**
	 * Column Info
	 * @return updDtYmd
	 */
	public String getUpdDtYmd() {
		return this.updDtYmd;
	}
	
	/**
	 * Column Info
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
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
	 * @return dtchDtHd
	 */
	public String getDtchDtHd() {
		return this.dtchDtHd;
	}
	
	/**
	 * Column Info
	 * @return cntrChss
	 */
	public String getCntrChss() {
		return this.cntrChss;
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
	 * @return dispFlg
	 */
	public String getDispFlg() {
		return this.dispFlg;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return stsUpdDt
	 */
	public String getStsUpdDt() {
		return this.stsUpdDt;
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
	 * @return atchDtYmd
	 */
	public String getAtchDtYmd() {
		return this.atchDtYmd;
	}
	
	/**
	 * Column Info
	 * @return lccCd
	 */
	public String getLccCd() {
		return this.lccCd;
	}

	/**
	 * Column Info
	 * @return sccCd
	 */
	public String getSccCd() {
		return this.sccCd;
	}
	
	/**
	 * Column Info
	 * @param atchDtHd
	 */
	public void setAtchDtHd(String atchDtHd) {
		this.atchDtHd = atchDtHd;
	}
	
	/**
	 * Column Info
	 * @param dmgFlg
	 */
	public void setDmgFlg(String dmgFlg) {
		this.dmgFlg = dmgFlg;
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
	 * @param chssMvmtDt
	 */
	public void setChssMvmtDt(String chssMvmtDt) {
		this.chssMvmtDt = chssMvmtDt;
	}
	
	/**
	 * Column Info
	 * @param atchDtch
	 */
	public void setAtchDtch(String atchDtch) {
		this.atchDtch = atchDtch;
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
	 * @param stayDys
	 */
	public void setStayDys(String stayDys) {
		this.stayDys = stayDys;
	}
	
	/**
	 * Column Info
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	
	/**
	 * Column Info
	 * @param dtchYdCd
	 */
	public void setDtchYdCd(String dtchYdCd) {
		this.dtchYdCd = dtchYdCd;
	}
	
	/**
	 * Column Info
	 * @param dtchDtYmd
	 */
	public void setDtchDtYmd(String dtchDtYmd) {
		this.dtchDtYmd = dtchDtYmd;
	}
	
	/**
	 * Column Info
	 * @param updDtHd
	 */
	public void setUpdDtHd(String updDtHd) {
		this.updDtHd = updDtHd;
	}
	
	/**
	 * Column Info
	 * @param lstYd
	 */
	public void setLstYd(String lstYd) {
		this.lstYd = lstYd;
	}
	
	/**
	 * Column Info
	 * @param atchYdCd
	 */
	public void setAtchYdCd(String atchYdCd) {
		this.atchYdCd = atchYdCd;
	}
	
	/**
	 * Column Info
	 * @param updDtYmd
	 */
	public void setUpdDtYmd(String updDtYmd) {
		this.updDtYmd = updDtYmd;
	}
	
	/**
	 * Column Info
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
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
	 * @param dtchDtHd
	 */
	public void setDtchDtHd(String dtchDtHd) {
		this.dtchDtHd = dtchDtHd;
	}
	
	/**
	 * Column Info
	 * @param cntrChss
	 */
	public void setCntrChss(String cntrChss) {
		this.cntrChss = cntrChss;
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
	 * @param dispFlg
	 */
	public void setDispFlg(String dispFlg) {
		this.dispFlg = dispFlg;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param stsUpdDt
	 */
	public void setStsUpdDt(String stsUpdDt) {
		this.stsUpdDt = stsUpdDt;
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
	 * @param atchDtYmd
	 */
	public void setAtchDtYmd(String atchDtYmd) {
		this.atchDtYmd = atchDtYmd;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}
	
	/**
	 * Column Info
	 * @return lccCd
	 */
	public void setLccCd(String lccCd) {
		this.lccCd = lccCd;
	}

	/**
	 * Column Info
	 * @return sccCd
	 */
	public void setSccCd(String sccCd) {
		this.sccCd = sccCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setAtchDtHd(JSPUtil.getParameter(request, prefix + "atch_dt_hd", ""));
		setDmgFlg(JSPUtil.getParameter(request, prefix + "dmg_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setChssMvmtDt(JSPUtil.getParameter(request, prefix + "chss_mvmt_dt", ""));
		setAtchDtch(JSPUtil.getParameter(request, prefix + "atch_dtch", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setStayDys(JSPUtil.getParameter(request, prefix + "stay_dys", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setUsrNm(JSPUtil.getParameter(request, prefix + "usr_nm", ""));
		setDtchYdCd(JSPUtil.getParameter(request, prefix + "dtch_yd_cd", ""));
		setDtchDtYmd(JSPUtil.getParameter(request, prefix + "dtch_dt_ymd", ""));
		setUpdDtHd(JSPUtil.getParameter(request, prefix + "upd_dt_hd", ""));
		setLstYd(JSPUtil.getParameter(request, prefix + "lst_yd", ""));
		setAtchYdCd(JSPUtil.getParameter(request, prefix + "atch_yd_cd", ""));
		setUpdDtYmd(JSPUtil.getParameter(request, prefix + "upd_dt_ymd", ""));
		setAgmtNo(JSPUtil.getParameter(request, prefix + "agmt_no", ""));
		setAgmtLstmCd(JSPUtil.getParameter(request, prefix + "agmt_lstm_cd", ""));
		setAciacDivCd(JSPUtil.getParameter(request, prefix + "aciac_div_cd", ""));
		setDtchDtHd(JSPUtil.getParameter(request, prefix + "dtch_dt_hd", ""));
		setCntrChss(JSPUtil.getParameter(request, prefix + "cntr_chss", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setDispFlg(JSPUtil.getParameter(request, prefix + "disp_flg", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setStsUpdDt(JSPUtil.getParameter(request, prefix + "sts_upd_dt", ""));
		setChssMvmtStsCd(JSPUtil.getParameter(request, prefix + "chss_mvmt_sts_cd", ""));
		setAtchDtYmd(JSPUtil.getParameter(request, prefix + "atch_dt_ymd", ""));
		setLccCd(JSPUtil.getParameter(request, prefix + "lcc_cd", ""));
		setSccCd(JSPUtil.getParameter(request, prefix + "scc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MGSInventoryDetailMGTVO[]
	 */
	public MGSInventoryDetailMGTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MGSInventoryDetailMGTVO[]
	 */
	public MGSInventoryDetailMGTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MGSInventoryDetailMGTVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] atchDtHd = (JSPUtil.getParameter(request, prefix	+ "atch_dt_hd", length));
			String[] dmgFlg = (JSPUtil.getParameter(request, prefix	+ "dmg_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] chssMvmtDt = (JSPUtil.getParameter(request, prefix	+ "chss_mvmt_dt", length));
			String[] atchDtch = (JSPUtil.getParameter(request, prefix	+ "atch_dtch", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] stayDys = (JSPUtil.getParameter(request, prefix	+ "stay_dys", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] dtchYdCd = (JSPUtil.getParameter(request, prefix	+ "dtch_yd_cd", length));
			String[] dtchDtYmd = (JSPUtil.getParameter(request, prefix	+ "dtch_dt_ymd", length));
			String[] updDtHd = (JSPUtil.getParameter(request, prefix	+ "upd_dt_hd", length));
			String[] lstYd = (JSPUtil.getParameter(request, prefix	+ "lst_yd", length));
			String[] atchYdCd = (JSPUtil.getParameter(request, prefix	+ "atch_yd_cd", length));
			String[] updDtYmd = (JSPUtil.getParameter(request, prefix	+ "upd_dt_ymd", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] agmtLstmCd = (JSPUtil.getParameter(request, prefix	+ "agmt_lstm_cd", length));
			String[] aciacDivCd = (JSPUtil.getParameter(request, prefix	+ "aciac_div_cd", length));
			String[] dtchDtHd = (JSPUtil.getParameter(request, prefix	+ "dtch_dt_hd", length));
			String[] cntrChss = (JSPUtil.getParameter(request, prefix	+ "cntr_chss", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] dispFlg = (JSPUtil.getParameter(request, prefix	+ "disp_flg", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] stsUpdDt = (JSPUtil.getParameter(request, prefix	+ "sts_upd_dt", length));
			String[] chssMvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "chss_mvmt_sts_cd", length));
			String[] atchDtYmd = (JSPUtil.getParameter(request, prefix	+ "atch_dt_ymd", length));
			String[] lccCd = (JSPUtil.getParameter(request, prefix + "lcc_cd", length));
			String[] sccCd = (JSPUtil.getParameter(request, prefix + "scc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new MGSInventoryDetailMGTVO();
				if (atchDtHd[i] != null)
					model.setAtchDtHd(atchDtHd[i]);
				if (dmgFlg[i] != null)
					model.setDmgFlg(dmgFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (chssMvmtDt[i] != null)
					model.setChssMvmtDt(chssMvmtDt[i]);
				if (atchDtch[i] != null)
					model.setAtchDtch(atchDtch[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (stayDys[i] != null)
					model.setStayDys(stayDys[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (dtchYdCd[i] != null)
					model.setDtchYdCd(dtchYdCd[i]);
				if (dtchDtYmd[i] != null)
					model.setDtchDtYmd(dtchDtYmd[i]);
				if (updDtHd[i] != null)
					model.setUpdDtHd(updDtHd[i]);
				if (lstYd[i] != null)
					model.setLstYd(lstYd[i]);
				if (atchYdCd[i] != null)
					model.setAtchYdCd(atchYdCd[i]);
				if (updDtYmd[i] != null)
					model.setUpdDtYmd(updDtYmd[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (agmtLstmCd[i] != null)
					model.setAgmtLstmCd(agmtLstmCd[i]);
				if (aciacDivCd[i] != null)
					model.setAciacDivCd(aciacDivCd[i]);
				if (dtchDtHd[i] != null)
					model.setDtchDtHd(dtchDtHd[i]);
				if (cntrChss[i] != null)
					model.setCntrChss(cntrChss[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (dispFlg[i] != null)
					model.setDispFlg(dispFlg[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (stsUpdDt[i] != null)
					model.setStsUpdDt(stsUpdDt[i]);
				if (chssMvmtStsCd[i] != null)
					model.setChssMvmtStsCd(chssMvmtStsCd[i]);
				if (atchDtYmd[i] != null)
					model.setAtchDtYmd(atchDtYmd[i]);
				if (lccCd[i] != null)
					model.setLccCd(lccCd[i]);
				if (sccCd[i] != null)
					model.setSccCd(sccCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMGSInventoryDetailMGTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MGSInventoryDetailMGTVO[]
	 */
	public MGSInventoryDetailMGTVO[] getMGSInventoryDetailMGTVOs(){
		MGSInventoryDetailMGTVO[] vos = (MGSInventoryDetailMGTVO[])models.toArray(new MGSInventoryDetailMGTVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.atchDtHd = this.atchDtHd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgFlg = this.dmgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssMvmtDt = this.chssMvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchDtch = this.atchDtch .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDys = this.stayDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtchYdCd = this.dtchYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtchDtYmd = this.dtchDtYmd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDtHd = this.updDtHd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstYd = this.lstYd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchYdCd = this.atchYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDtYmd = this.updDtYmd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtLstmCd = this.agmtLstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aciacDivCd = this.aciacDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtchDtHd = this.dtchDtHd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrChss = this.cntrChss .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispFlg = this.dispFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsUpdDt = this.stsUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssMvmtStsCd = this.chssMvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchDtYmd = this.atchDtYmd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lccCd = this.lccCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd = this.sccCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
