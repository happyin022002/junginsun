/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FcmRmnOilMonEndRptVO.java
*@FileTitle : FcmRmnOilMonEndRptVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.31
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.01.31 진마리아 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.fcm.estimation.estimation.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 진마리아
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FcmRmnOilMonEndRptVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FcmRmnOilMonEndRptVO> models = new ArrayList<FcmRmnOilMonEndRptVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String rptUsrId = null;
	/* Column Info */
	private String sysOilRmnWgt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String rptDocNo = null;
	/* Column Info */
	private String teamDesc = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rptUsrNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rptRmk = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String revYrmon = null;
	/* Column Info */
	private String lowSulpFoilRmnWgt = null;
	/* Column Info */
	private String lowSulpDoilRmnWgt = null;
	/* Column Info */
	private String doilRmnWgt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String trbnGnrOilRmnWgt = null;
	/* Column Info */
	private String rptIssDt = null;
	/* Column Info */
	private String clndOilRmnWgt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String foilRmnWgt = null;
	/* Column Info */
	private String gnrOilRmnWgt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FcmRmnOilMonEndRptVO() {}

	public FcmRmnOilMonEndRptVO(String ibflag, String pagerows, String revYrmon, String vslCd, String skdVoyNo, String skdDirCd, String vslSlanCd, String foilRmnWgt, String doilRmnWgt, String clndOilRmnWgt, String sysOilRmnWgt, String gnrOilRmnWgt, String lowSulpDoilRmnWgt, String trbnGnrOilRmnWgt, String lowSulpFoilRmnWgt, String rptDocNo, String rptIssDt, String rptUsrId, String rptUsrNm, String teamDesc, String rptRmk, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.vslCd = vslCd;
		this.rptUsrId = rptUsrId;
		this.sysOilRmnWgt = sysOilRmnWgt;
		this.creDt = creDt;
		this.rptDocNo = rptDocNo;
		this.teamDesc = teamDesc;
		this.vslSlanCd = vslSlanCd;
		this.pagerows = pagerows;
		this.rptUsrNm = rptUsrNm;
		this.ibflag = ibflag;
		this.rptRmk = rptRmk;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.revYrmon = revYrmon;
		this.lowSulpFoilRmnWgt = lowSulpFoilRmnWgt;
		this.lowSulpDoilRmnWgt = lowSulpDoilRmnWgt;
		this.doilRmnWgt = doilRmnWgt;
		this.skdVoyNo = skdVoyNo;
		this.trbnGnrOilRmnWgt = trbnGnrOilRmnWgt;
		this.rptIssDt = rptIssDt;
		this.clndOilRmnWgt = clndOilRmnWgt;
		this.skdDirCd = skdDirCd;
		this.creUsrId = creUsrId;
		this.foilRmnWgt = foilRmnWgt;
		this.gnrOilRmnWgt = gnrOilRmnWgt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("rpt_usr_id", getRptUsrId());
		this.hashColumns.put("sys_oil_rmn_wgt", getSysOilRmnWgt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("rpt_doc_no", getRptDocNo());
		this.hashColumns.put("team_desc", getTeamDesc());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rpt_usr_nm", getRptUsrNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rpt_rmk", getRptRmk());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rev_yrmon", getRevYrmon());
		this.hashColumns.put("low_sulp_foil_rmn_wgt", getLowSulpFoilRmnWgt());
		this.hashColumns.put("low_sulp_doil_rmn_wgt", getLowSulpDoilRmnWgt());
		this.hashColumns.put("doil_rmn_wgt", getDoilRmnWgt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("trbn_gnr_oil_rmn_wgt", getTrbnGnrOilRmnWgt());
		this.hashColumns.put("rpt_iss_dt", getRptIssDt());
		this.hashColumns.put("clnd_oil_rmn_wgt", getClndOilRmnWgt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("foil_rmn_wgt", getFoilRmnWgt());
		this.hashColumns.put("gnr_oil_rmn_wgt", getGnrOilRmnWgt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("rpt_usr_id", "rptUsrId");
		this.hashFields.put("sys_oil_rmn_wgt", "sysOilRmnWgt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("rpt_doc_no", "rptDocNo");
		this.hashFields.put("team_desc", "teamDesc");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rpt_usr_nm", "rptUsrNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rpt_rmk", "rptRmk");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rev_yrmon", "revYrmon");
		this.hashFields.put("low_sulp_foil_rmn_wgt", "lowSulpFoilRmnWgt");
		this.hashFields.put("low_sulp_doil_rmn_wgt", "lowSulpDoilRmnWgt");
		this.hashFields.put("doil_rmn_wgt", "doilRmnWgt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("trbn_gnr_oil_rmn_wgt", "trbnGnrOilRmnWgt");
		this.hashFields.put("rpt_iss_dt", "rptIssDt");
		this.hashFields.put("clnd_oil_rmn_wgt", "clndOilRmnWgt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("foil_rmn_wgt", "foilRmnWgt");
		this.hashFields.put("gnr_oil_rmn_wgt", "gnrOilRmnWgt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return rptUsrId
	 */
	public String getRptUsrId() {
		return this.rptUsrId;
	}
	
	/**
	 * Column Info
	 * @return sysOilRmnWgt
	 */
	public String getSysOilRmnWgt() {
		return this.sysOilRmnWgt;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return rptDocNo
	 */
	public String getRptDocNo() {
		return this.rptDocNo;
	}
	
	/**
	 * Column Info
	 * @return teamDesc
	 */
	public String getTeamDesc() {
		return this.teamDesc;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
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
	 * @return rptUsrNm
	 */
	public String getRptUsrNm() {
		return this.rptUsrNm;
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
	 * @return rptRmk
	 */
	public String getRptRmk() {
		return this.rptRmk;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return revYrmon
	 */
	public String getRevYrmon() {
		return this.revYrmon;
	}
	
	/**
	 * Column Info
	 * @return lowSulpFoilRmnWgt
	 */
	public String getLowSulpFoilRmnWgt() {
		return this.lowSulpFoilRmnWgt;
	}
	
	/**
	 * Column Info
	 * @return lowSulpDoilRmnWgt
	 */
	public String getLowSulpDoilRmnWgt() {
		return this.lowSulpDoilRmnWgt;
	}
	
	/**
	 * Column Info
	 * @return doilRmnWgt
	 */
	public String getDoilRmnWgt() {
		return this.doilRmnWgt;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return trbnGnrOilRmnWgt
	 */
	public String getTrbnGnrOilRmnWgt() {
		return this.trbnGnrOilRmnWgt;
	}
	
	/**
	 * Column Info
	 * @return rptIssDt
	 */
	public String getRptIssDt() {
		return this.rptIssDt;
	}
	
	/**
	 * Column Info
	 * @return clndOilRmnWgt
	 */
	public String getClndOilRmnWgt() {
		return this.clndOilRmnWgt;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return foilRmnWgt
	 */
	public String getFoilRmnWgt() {
		return this.foilRmnWgt;
	}
	
	/**
	 * Column Info
	 * @return gnrOilRmnWgt
	 */
	public String getGnrOilRmnWgt() {
		return this.gnrOilRmnWgt;
	}
	

	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param rptUsrId
	 */
	public void setRptUsrId(String rptUsrId) {
		this.rptUsrId = rptUsrId;
	}
	
	/**
	 * Column Info
	 * @param sysOilRmnWgt
	 */
	public void setSysOilRmnWgt(String sysOilRmnWgt) {
		this.sysOilRmnWgt = sysOilRmnWgt;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param rptDocNo
	 */
	public void setRptDocNo(String rptDocNo) {
		this.rptDocNo = rptDocNo;
	}
	
	/**
	 * Column Info
	 * @param teamDesc
	 */
	public void setTeamDesc(String teamDesc) {
		this.teamDesc = teamDesc;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
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
	 * @param rptUsrNm
	 */
	public void setRptUsrNm(String rptUsrNm) {
		this.rptUsrNm = rptUsrNm;
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
	 * @param rptRmk
	 */
	public void setRptRmk(String rptRmk) {
		this.rptRmk = rptRmk;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param revYrmon
	 */
	public void setRevYrmon(String revYrmon) {
		this.revYrmon = revYrmon;
	}
	
	/**
	 * Column Info
	 * @param lowSulpFoilRmnWgt
	 */
	public void setLowSulpFoilRmnWgt(String lowSulpFoilRmnWgt) {
		this.lowSulpFoilRmnWgt = lowSulpFoilRmnWgt;
	}
	
	/**
	 * Column Info
	 * @param lowSulpDoilRmnWgt
	 */
	public void setLowSulpDoilRmnWgt(String lowSulpDoilRmnWgt) {
		this.lowSulpDoilRmnWgt = lowSulpDoilRmnWgt;
	}
	
	/**
	 * Column Info
	 * @param doilRmnWgt
	 */
	public void setDoilRmnWgt(String doilRmnWgt) {
		this.doilRmnWgt = doilRmnWgt;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param trbnGnrOilRmnWgt
	 */
	public void setTrbnGnrOilRmnWgt(String trbnGnrOilRmnWgt) {
		this.trbnGnrOilRmnWgt = trbnGnrOilRmnWgt;
	}
	
	/**
	 * Column Info
	 * @param rptIssDt
	 */
	public void setRptIssDt(String rptIssDt) {
		this.rptIssDt = rptIssDt;
	}
	
	/**
	 * Column Info
	 * @param clndOilRmnWgt
	 */
	public void setClndOilRmnWgt(String clndOilRmnWgt) {
		this.clndOilRmnWgt = clndOilRmnWgt;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param foilRmnWgt
	 */
	public void setFoilRmnWgt(String foilRmnWgt) {
		this.foilRmnWgt = foilRmnWgt;
	}
	
	/**
	 * Column Info
	 * @param gnrOilRmnWgt
	 */
	public void setGnrOilRmnWgt(String gnrOilRmnWgt) {
		this.gnrOilRmnWgt = gnrOilRmnWgt;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setRptUsrId(JSPUtil.getParameter(request, prefix + "rpt_usr_id", ""));
		setSysOilRmnWgt(JSPUtil.getParameter(request, prefix + "sys_oil_rmn_wgt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setRptDocNo(JSPUtil.getParameter(request, prefix + "rpt_doc_no", ""));
		setTeamDesc(JSPUtil.getParameter(request, prefix + "team_desc", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRptUsrNm(JSPUtil.getParameter(request, prefix + "rpt_usr_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRptRmk(JSPUtil.getParameter(request, prefix + "rpt_rmk", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setRevYrmon(JSPUtil.getParameter(request, prefix + "rev_yrmon", ""));
		setLowSulpFoilRmnWgt(JSPUtil.getParameter(request, prefix + "low_sulp_foil_rmn_wgt", ""));
		setLowSulpDoilRmnWgt(JSPUtil.getParameter(request, prefix + "low_sulp_doil_rmn_wgt", ""));
		setDoilRmnWgt(JSPUtil.getParameter(request, prefix + "doil_rmn_wgt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setTrbnGnrOilRmnWgt(JSPUtil.getParameter(request, prefix + "trbn_gnr_oil_rmn_wgt", ""));
		setRptIssDt(JSPUtil.getParameter(request, prefix + "rpt_iss_dt", ""));
		setClndOilRmnWgt(JSPUtil.getParameter(request, prefix + "clnd_oil_rmn_wgt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setFoilRmnWgt(JSPUtil.getParameter(request, prefix + "foil_rmn_wgt", ""));
		setGnrOilRmnWgt(JSPUtil.getParameter(request, prefix + "gnr_oil_rmn_wgt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FcmRmnOilMonEndRptVO[]
	 */
	public FcmRmnOilMonEndRptVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FcmRmnOilMonEndRptVO[]
	 */
	public FcmRmnOilMonEndRptVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FcmRmnOilMonEndRptVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] rptUsrId = (JSPUtil.getParameter(request, prefix	+ "rpt_usr_id", length));
			String[] sysOilRmnWgt = (JSPUtil.getParameter(request, prefix	+ "sys_oil_rmn_wgt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] rptDocNo = (JSPUtil.getParameter(request, prefix	+ "rpt_doc_no", length));
			String[] teamDesc = (JSPUtil.getParameter(request, prefix	+ "team_desc", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rptUsrNm = (JSPUtil.getParameter(request, prefix	+ "rpt_usr_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rptRmk = (JSPUtil.getParameter(request, prefix	+ "rpt_rmk", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] revYrmon = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon", length));
			String[] lowSulpFoilRmnWgt = (JSPUtil.getParameter(request, prefix	+ "low_sulp_foil_rmn_wgt", length));
			String[] lowSulpDoilRmnWgt = (JSPUtil.getParameter(request, prefix	+ "low_sulp_doil_rmn_wgt", length));
			String[] doilRmnWgt = (JSPUtil.getParameter(request, prefix	+ "doil_rmn_wgt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] trbnGnrOilRmnWgt = (JSPUtil.getParameter(request, prefix	+ "trbn_gnr_oil_rmn_wgt", length));
			String[] rptIssDt = (JSPUtil.getParameter(request, prefix	+ "rpt_iss_dt", length));
			String[] clndOilRmnWgt = (JSPUtil.getParameter(request, prefix	+ "clnd_oil_rmn_wgt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] foilRmnWgt = (JSPUtil.getParameter(request, prefix	+ "foil_rmn_wgt", length));
			String[] gnrOilRmnWgt = (JSPUtil.getParameter(request, prefix	+ "gnr_oil_rmn_wgt", length));
			
			for (int i = 0; i < length; i++) {
				model = new FcmRmnOilMonEndRptVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (rptUsrId[i] != null)
					model.setRptUsrId(rptUsrId[i]);
				if (sysOilRmnWgt[i] != null)
					model.setSysOilRmnWgt(sysOilRmnWgt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (rptDocNo[i] != null)
					model.setRptDocNo(rptDocNo[i]);
				if (teamDesc[i] != null)
					model.setTeamDesc(teamDesc[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rptUsrNm[i] != null)
					model.setRptUsrNm(rptUsrNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rptRmk[i] != null)
					model.setRptRmk(rptRmk[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (revYrmon[i] != null)
					model.setRevYrmon(revYrmon[i]);
				if (lowSulpFoilRmnWgt[i] != null)
					model.setLowSulpFoilRmnWgt(lowSulpFoilRmnWgt[i]);
				if (lowSulpDoilRmnWgt[i] != null)
					model.setLowSulpDoilRmnWgt(lowSulpDoilRmnWgt[i]);
				if (doilRmnWgt[i] != null)
					model.setDoilRmnWgt(doilRmnWgt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (trbnGnrOilRmnWgt[i] != null)
					model.setTrbnGnrOilRmnWgt(trbnGnrOilRmnWgt[i]);
				if (rptIssDt[i] != null)
					model.setRptIssDt(rptIssDt[i]);
				if (clndOilRmnWgt[i] != null)
					model.setClndOilRmnWgt(clndOilRmnWgt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (foilRmnWgt[i] != null)
					model.setFoilRmnWgt(foilRmnWgt[i]);
				if (gnrOilRmnWgt[i] != null)
					model.setGnrOilRmnWgt(gnrOilRmnWgt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFcmRmnOilMonEndRptVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FcmRmnOilMonEndRptVO[]
	 */
	public FcmRmnOilMonEndRptVO[] getFcmRmnOilMonEndRptVOs(){
		FcmRmnOilMonEndRptVO[] vos = (FcmRmnOilMonEndRptVO[])models.toArray(new FcmRmnOilMonEndRptVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptUsrId = this.rptUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysOilRmnWgt = this.sysOilRmnWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptDocNo = this.rptDocNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teamDesc = this.teamDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptUsrNm = this.rptUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptRmk = this.rptRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmon = this.revYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lowSulpFoilRmnWgt = this.lowSulpFoilRmnWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lowSulpDoilRmnWgt = this.lowSulpDoilRmnWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doilRmnWgt = this.doilRmnWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trbnGnrOilRmnWgt = this.trbnGnrOilRmnWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptIssDt = this.rptIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clndOilRmnWgt = this.clndOilRmnWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilRmnWgt = this.foilRmnWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gnrOilRmnWgt = this.gnrOilRmnWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
