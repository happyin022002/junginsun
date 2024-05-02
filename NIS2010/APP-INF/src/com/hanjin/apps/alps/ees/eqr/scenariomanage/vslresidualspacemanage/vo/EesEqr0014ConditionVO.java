/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0014ContitionVO.java
*@FileTitle : BSA 조회 / 수정
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.08.11 정은호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.scenariomanage.vslresidualspacemanage.vo;

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
 * @author 정은호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr0014ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0014ConditionVO> models = new ArrayList<EesEqr0014ConditionVO>();

	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;
	//scnr_id
	private String yyyyww     = "";
	private String seq     = "";
	private String statusType     = "";
	private String scnr_rmk ="";
	
	// 구분
	private String fmToAt     = "";
	
 	// FM/TO
 	private String fmType     = "";
 	private String fmEccCd    = "";
 	private String fmTypeBy   = "";
    private String fmPlnYr    = "";
    private String fmPlnMm    = "";
    private String fmPlnWk    = "";
    
    private String fmToPlnYr    = "";
    private String fmToPlnMm    = "";
    private String fmToPlnWk    = "";
    
    private String toToPlnYr    = "";
    private String toToPlnMm    = "";
    private String toToPlnWk    = "";
	
    
 	private String toType     = "";
 	private String toEccCd    = "";
 	private String toTypeBy   = "";
 	private String toPlnYr    = "";
    private String toPlnMm    = "";
    private String toPlnWk    = "";
	    	
 	// At
 	private String atType     = "";
 	private String atEccCd    = "";
 	private String atTypeBy   = "";
 	private String atFmPlnYr    = "";
 	private String atFmPlnMm    = "";
 	private String atFmPlnWk    = "";
 	private String atToPlnYr   = "";
 	private String atToPlnMm   = "";
 	private String atToPlnWk   = "";
 	
	// TP/SZ 
	private String cntrTpszCd = "";
	private String company    ="";
	private String lane       ="";
	private String vvd        ="";
    private String company_code ="";
	
	//변수 넘기기 
	
	private String scnr_id = "";
	private String fm_yrwk = "";
	private String to_yrwk = "";
	private String vsl_cd  = "";
	private String skd_voy_no = "";
	private String skd_dir_cd = "";
	private String cntr_tpsz_cd ="";
	private String st_key ="";
	private String trade_code ="";
	private String newTitle = "";
	
	private String flag = "";

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0014ConditionVO() {}

	public EesEqr0014ConditionVO(String ibflag, String pagerows, String yyyyww, String seq, String statustype, String scnrRmk, String fmToAt, String fmtype, String fmecccd, String fmtypeby, String fmplnyr, String fmplnmm, String fmplnwk, String fmtoplnyr, String fmtoplnmm, String fmtoplnwk, String totoplnyr, String totoplnmm, String totoplnwk, String totype, String toecccd, String totypeby, String toplnyr, String toplnmm, String toplnwk, String attype, String atecccd, String attypeby, String atfmplnyr, String atfmplnmm, String atfmplnwk, String attoplnyr, String attoplnmm, String attoplnwk, String cntrtpszcd, String company, String lane, String vvd, String companyCode, String scnrId, String fmYrwk, String toYrwk, String vslCd, String skdVoyNo, String skdDirCd, String cntrTpszCd, String stKey, String tradeCode) {
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		
		return this.hashFields;
	}
	/**
	 * @return Returns the atEccCd.
	 */
	public String getAtEccCd() {
		return atEccCd;
	}

	/**
	 * @param atEccCd The atEccCd to set.
	 */
	public void setAtEccCd(String atEccCd) {
		this.atEccCd = atEccCd;
	}

	/**
	 * @return Returns the atFmPlnMm.
	 */
	public String getAtFmPlnMm() {
		return atFmPlnMm;
	}

	/**
	 * @param atFmPlnMm The atFmPlnMm to set.
	 */
	public void setAtFmPlnMm(String atFmPlnMm) {
		this.atFmPlnMm = atFmPlnMm;
	}

	/**
	 * @return Returns the atFmPlnWk.
	 */
	public String getAtFmPlnWk() {
		return atFmPlnWk;
	}

	/**
	 * @param atFmPlnWk The atFmPlnWk to set.
	 */
	public void setAtFmPlnWk(String atFmPlnWk) {
		this.atFmPlnWk = atFmPlnWk;
	}

	/**
	 * @return Returns the atFmPlnYr.
	 */
	public String getAtFmPlnYr() {
		return atFmPlnYr;
	}

	/**
	 * @param atFmPlnYr The atFmPlnYr to set.
	 */
	public void setAtFmPlnYr(String atFmPlnYr) {
		this.atFmPlnYr = atFmPlnYr;
	}

	/**
	 * @return Returns the atToPlnMm.
	 */
	public String getAtToPlnMm() {
		return atToPlnMm;
	}

	/**
	 * @param atToPlnMm The atToPlnMm to set.
	 */
	public void setAtToPlnMm(String atToPlnMm) {
		this.atToPlnMm = atToPlnMm;
	}

	/**
	 * @return Returns the atToPlnWk.
	 */
	public String getAtToPlnWk() {
		return atToPlnWk;
	}

	/**
	 * @param atToPlnWk The atToPlnWk to set.
	 */
	public void setAtToPlnWk(String atToPlnWk) {
		this.atToPlnWk = atToPlnWk;
	}

	/**
	 * @return Returns the atToPlnYr.
	 */
	public String getAtToPlnYr() {
		return atToPlnYr;
	}

	/**
	 * @param atToPlnYr The atToPlnYr to set.
	 */
	public void setAtToPlnYr(String atToPlnYr) {
		this.atToPlnYr = atToPlnYr;
	}

	/**
	 * @return Returns the atType.
	 */
	public String getAtType() {
		return atType;
	}

	/**
	 * @param atType The atType to set.
	 */
	public void setAtType(String atType) {
		this.atType = atType;
	}

	/**
	 * @return Returns the atTypeBy.
	 */
	public String getAtTypeBy() {
		return atTypeBy;
	}

	/**
	 * @param atTypeBy The atTypeBy to set.
	 */
	public void setAtTypeBy(String atTypeBy) {
		this.atTypeBy = atTypeBy;
	}

	/**
	 * @return Returns the cntr_tpsz_cd.
	 */
	public String getCntr_tpsz_cd() {
		return cntr_tpsz_cd;
	}

	/**
	 * @param cntr_tpsz_cd The cntr_tpsz_cd to set.
	 */
	public void setCntr_tpsz_cd(String cntr_tpsz_cd) {
		this.cntr_tpsz_cd = cntr_tpsz_cd;
	}

	/**
	 * @return Returns the cntrTpszCd.
	 */
	public String getCntrTpszCd() {
		return cntrTpszCd;
	}

	/**
	 * @param cntrTpszCd The cntrTpszCd to set.
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}

	/**
	 * @return Returns the company.
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @param company The company to set.
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * @return Returns the company_code.
	 */
	public String getCompany_code() {
		return company_code;
	}

	/**
	 * @param company_code The company_code to set.
	 */
	public void setCompany_code(String company_code) {
		this.company_code = company_code;
	}

	/**
	 * @return Returns the fm_yrwk.
	 */
	public String getFm_yrwk() {
		return fm_yrwk;
	}

	/**
	 * @param fm_yrwk The fm_yrwk to set.
	 */
	public void setFm_yrwk(String fm_yrwk) {
		this.fm_yrwk = fm_yrwk;
	}

	/**
	 * @return Returns the fmEccCd.
	 */
	public String getFmEccCd() {
		return fmEccCd;
	}

	/**
	 * @param fmEccCd The fmEccCd to set.
	 */
	public void setFmEccCd(String fmEccCd) {
		this.fmEccCd = fmEccCd;
	}

	/**
	 * @return Returns the fmPlnMm.
	 */
	public String getFmPlnMm() {
		return fmPlnMm;
	}

	/**
	 * @param fmPlnMm The fmPlnMm to set.
	 */
	public void setFmPlnMm(String fmPlnMm) {
		this.fmPlnMm = fmPlnMm;
	}

	/**
	 * @return Returns the fmPlnWk.
	 */
	public String getFmPlnWk() {
		return fmPlnWk;
	}

	/**
	 * @param fmPlnWk The fmPlnWk to set.
	 */
	public void setFmPlnWk(String fmPlnWk) {
		this.fmPlnWk = fmPlnWk;
	}

	/**
	 * @return Returns the fmPlnYr.
	 */
	public String getFmPlnYr() {
		return fmPlnYr;
	}

	/**
	 * @param fmPlnYr The fmPlnYr to set.
	 */
	public void setFmPlnYr(String fmPlnYr) {
		this.fmPlnYr = fmPlnYr;
	}

	/**
	 * @return Returns the fmToAt.
	 */
	public String getFmToAt() {
		return fmToAt;
	}

	/**
	 * @param fmToAt The fmToAt to set.
	 */
	public void setFmToAt(String fmToAt) {
		this.fmToAt = fmToAt;
	}

	/**
	 * @return Returns the fmToPlnMm.
	 */
	public String getFmToPlnMm() {
		return fmToPlnMm;
	}

	/**
	 * @param fmToPlnMm The fmToPlnMm to set.
	 */
	public void setFmToPlnMm(String fmToPlnMm) {
		this.fmToPlnMm = fmToPlnMm;
	}

	/**
	 * @return Returns the fmToPlnWk.
	 */
	public String getFmToPlnWk() {
		return fmToPlnWk;
	}

	/**
	 * @param fmToPlnWk The fmToPlnWk to set.
	 */
	public void setFmToPlnWk(String fmToPlnWk) {
		this.fmToPlnWk = fmToPlnWk;
	}

	/**
	 * @return Returns the fmToPlnYr.
	 */
	public String getFmToPlnYr() {
		return fmToPlnYr;
	}

	/**
	 * @param fmToPlnYr The fmToPlnYr to set.
	 */
	public void setFmToPlnYr(String fmToPlnYr) {
		this.fmToPlnYr = fmToPlnYr;
	}

	/**
	 * @return Returns the fmType.
	 */
	public String getFmType() {
		return fmType;
	}

	/**
	 * @param fmType The fmType to set.
	 */
	public void setFmType(String fmType) {
		this.fmType = fmType;
	}

	/**
	 * @return Returns the fmTypeBy.
	 */
	public String getFmTypeBy() {
		return fmTypeBy;
	}

	/**
	 * @param fmTypeBy The fmTypeBy to set.
	 */
	public void setFmTypeBy(String fmTypeBy) {
		this.fmTypeBy = fmTypeBy;
	}

	/**
	 * @return Returns the lane.
	 */
	public String getLane() {
		return lane;
	}

	/**
	 * @param lane The lane to set.
	 */
	public void setLane(String lane) {
		this.lane = lane;
	}

	/**
	 * @return Returns the scnr_id.
	 */
	public String getScnr_id() {
		return scnr_id;
	}

	/**
	 * @param scnr_id The scnr_id to set.
	 */
	public void setScnr_id(String scnr_id) {
		this.scnr_id = scnr_id;
	}

	/**
	 * @return Returns the scnr_rmk.
	 */
	public String getScnr_rmk() {
		return scnr_rmk;
	}

	/**
	 * @param scnr_rmk The scnr_rmk to set.
	 */
	public void setScnr_rmk(String scnr_rmk) {
		this.scnr_rmk = scnr_rmk;
	}

	/**
	 * @return Returns the seq.
	 */
	public String getSeq() {
		return seq;
	}

	/**
	 * @param seq The seq to set.
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}

	/**
	 * @return Returns the skd_dir_cd.
	 */
	public String getSkd_dir_cd() {
		return skd_dir_cd;
	}

	/**
	 * @param skd_dir_cd The skd_dir_cd to set.
	 */
	public void setSkd_dir_cd(String skd_dir_cd) {
		this.skd_dir_cd = skd_dir_cd;
	}

	/**
	 * @return Returns the skd_voy_no.
	 */
	public String getSkd_voy_no() {
		return skd_voy_no;
	}

	/**
	 * @param skd_voy_no The skd_voy_no to set.
	 */
	public void setSkd_voy_no(String skd_voy_no) {
		this.skd_voy_no = skd_voy_no;
	}

	/**
	 * @return Returns the st_key.
	 */
	public String getSt_key() {
		return st_key;
	}

	/**
	 * @param st_key The st_key to set.
	 */
	public void setSt_key(String st_key) {
		this.st_key = st_key;
	}

	/**
	 * @return Returns the statusType.
	 */
	public String getStatusType() {
		return statusType;
	}

	/**
	 * @param statusType The statusType to set.
	 */
	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}

	/**
	 * @return Returns the to_yrwk.
	 */
	public String getTo_yrwk() {
		return to_yrwk;
	}

	/**
	 * @param to_yrwk The to_yrwk to set.
	 */
	public void setTo_yrwk(String to_yrwk) {
		this.to_yrwk = to_yrwk;
	}

	/**
	 * @return Returns the toEccCd.
	 */
	public String getToEccCd() {
		return toEccCd;
	}

	/**
	 * @param toEccCd The toEccCd to set.
	 */
	public void setToEccCd(String toEccCd) {
		this.toEccCd = toEccCd;
	}

	/**
	 * @return Returns the toPlnMm.
	 */
	public String getToPlnMm() {
		return toPlnMm;
	}

	/**
	 * @param toPlnMm The toPlnMm to set.
	 */
	public void setToPlnMm(String toPlnMm) {
		this.toPlnMm = toPlnMm;
	}

	/**
	 * @return Returns the toPlnWk.
	 */
	public String getToPlnWk() {
		return toPlnWk;
	}

	/**
	 * @param toPlnWk The toPlnWk to set.
	 */
	public void setToPlnWk(String toPlnWk) {
		this.toPlnWk = toPlnWk;
	}

	/**
	 * @return Returns the toPlnYr.
	 */
	public String getToPlnYr() {
		return toPlnYr;
	}

	/**
	 * @param toPlnYr The toPlnYr to set.
	 */
	public void setToPlnYr(String toPlnYr) {
		this.toPlnYr = toPlnYr;
	}

	/**
	 * @return Returns the toToPlnMm.
	 */
	public String getToToPlnMm() {
		return toToPlnMm;
	}

	/**
	 * @param toToPlnMm The toToPlnMm to set.
	 */
	public void setToToPlnMm(String toToPlnMm) {
		this.toToPlnMm = toToPlnMm;
	}

	/**
	 * @return Returns the toToPlnWk.
	 */
	public String getToToPlnWk() {
		return toToPlnWk;
	}

	/**
	 * @param toToPlnWk The toToPlnWk to set.
	 */
	public void setToToPlnWk(String toToPlnWk) {
		this.toToPlnWk = toToPlnWk;
	}

	/**
	 * @return Returns the toToPlnYr.
	 */
	public String getToToPlnYr() {
		return toToPlnYr;
	}

	/**
	 * @param toToPlnYr The toToPlnYr to set.
	 */
	public void setToToPlnYr(String toToPlnYr) {
		this.toToPlnYr = toToPlnYr;
	}

	/**
	 * @return Returns the toType.
	 */
	public String getToType() {
		return toType;
	}

	/**
	 * @param toType The toType to set.
	 */
	public void setToType(String toType) {
		this.toType = toType;
	}

	/**
	 * @return Returns the toTypeBy.
	 */
	public String getToTypeBy() {
		return toTypeBy;
	}

	/**
	 * @param toTypeBy The toTypeBy to set.
	 */
	public void setToTypeBy(String toTypeBy) {
		this.toTypeBy = toTypeBy;
	}

	/**
	 * @return Returns the vsl_cd.
	 */
	public String getVsl_cd() {
		return vsl_cd;
	}

	/**
	 * @param vsl_cd The vsl_cd to set.
	 */
	public void setVsl_cd(String vsl_cd) {
		this.vsl_cd = vsl_cd;
	}

	/**
	 * @return Returns the vvd.
	 */
	public String getVvd() {
		return vvd;
	}

	/**
	 * @param vvd The vvd to set.
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}

	/**
	 * @return Returns the yyyyww.
	 */
	public String getYyyyww() {
		return yyyyww;
	}

	/**
	 * @param yyyyww The yyyyww to set.
	 */
	public void setYyyyww(String yyyyww) {
		this.yyyyww = yyyyww;
	}

	/**
	 * @return Returns the trade_code.
	 */
	public String getTrade_code() {
		return trade_code;
	}

	/**
	 * @param trade_code The trade_code to set.
	 */
	public void setTrade_code(String trade_code) {
		this.trade_code = trade_code;
	}	

	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}

	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	public String getIbflag() {
		return ibflag;
	}

	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	public String getNewTitle() {
		return newTitle;
	}

	public void setNewTitle(String newTitle) {
		this.newTitle = newTitle;
	}
	
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setScnr_id(JSPUtil.getParameter(request , "scnr_id".trim(),""));
    	setFm_yrwk(JSPUtil.getParameter(request , "fm_yrwk".trim(),""));
    	setTo_yrwk(JSPUtil.getParameter(request,  "to_yrwk".trim(),""));
    	setVsl_cd(JSPUtil.getParameter(request, "vsl_cd".trim(),""));
    	setSkd_voy_no(JSPUtil.getParameter(request, "skd_voy_no".trim(),""));
    	setSkd_dir_cd(JSPUtil.getParameter(request , "skd_dir_cd".trim(),""));
    	setCompany_code(JSPUtil.getParameter(request , "company_code".trim(),""));
    	setSt_key(JSPUtil.getParameter(request, "st_checked".trim() , ""));
    	setTrade_code(JSPUtil.getParameter(request , "trade_code".trim(),""));
    	//SCNR_ID
		setYyyyww(JSPUtil.getParameter(request, "yyyyww".trim(), ""));
		setSeq(JSPUtil.getParameter(request, "seq".trim(), ""));
		setStatusType(JSPUtil.getParameter(request, "status_type".trim(), ""));
		setScnr_rmk(JSPUtil.getParameter(request, "scnr_rmk".trim(), ""));
		setScnr_id(JSPUtil.getParameter(request , "scnr_id".trim(),""));
		
    	// FM/TO, At
    	setFmToAt(JSPUtil.getParameter(request, "fmToAt".trim(), ""));
    	
    	// FM/TO
    	setFmType(JSPUtil.getParameter(request, "fmType".trim(), ""));
    	setFmEccCd(JSPUtil.getParameter(request, "fmEccCd".trim(), ""));
    	setFmTypeBy(JSPUtil.getParameter(request, "fmTypeBy".trim(), ""));
    	setFmPlnYr(JSPUtil.getParameter(request, "fmPlnYr".trim(), ""));
    	setFmPlnMm(JSPUtil.getParameter(request, "fmPlnMm".trim(), ""));
    	setFmPlnWk(JSPUtil.getParameter(request, "fmPlnWk".trim(), ""));
    	
    	setToPlnYr(JSPUtil.getParameter(request, "toPlnYr".trim(), "")); 
    	setToPlnMm(JSPUtil.getParameter(request, "toPlnMm".trim(), "")); 
    	setToPlnWk(JSPUtil.getParameter(request, "toPlnWk".trim(), ""));
    	
    	setFmToPlnYr(JSPUtil.getParameter(request, "fmToPlnYr".trim(), ""));
    	setFmToPlnMm(JSPUtil.getParameter(request, "fmToPlnMm".trim(), ""));
    	setFmToPlnWk(JSPUtil.getParameter(request, "fmToPlnWk".trim(), ""));
    	
    	setToToPlnYr(JSPUtil.getParameter(request, "toToPlnYr".trim(), "")); 
    	setToToPlnMm(JSPUtil.getParameter(request, "toToPlnMm".trim(), "")); 
    	setToToPlnWk(JSPUtil.getParameter(request, "toToPlnWk".trim(), ""));
    	
    	
    	setToType(JSPUtil.getParameter(request, "toType".trim(), ""));
    	setToEccCd(JSPUtil.getParameter(request, "toEccCd".trim(), ""));
    	setToTypeBy(JSPUtil.getParameter(request, "toTypeBy".trim(), ""));   
    	
    	// At
    	setAtType(JSPUtil.getParameter(request, "atType".trim(), ""));
    	setAtEccCd(JSPUtil.getParameter(request, "atEccCd".trim(), ""));
    	setAtTypeBy(JSPUtil.getParameter(request, "atTypeBy".trim(), ""));
    	setAtFmPlnYr(JSPUtil.getParameter(request, "atFmPlnYr".trim(), ""));
    	setAtFmPlnMm(JSPUtil.getParameter(request, "atFmPlnMm".trim(), ""));
    	setAtFmPlnWk(JSPUtil.getParameter(request, "atFmPlnWk".trim(), ""));
    	setAtToPlnYr(JSPUtil.getParameter(request, "atToPlnYr".trim(), ""));
    	setAtToPlnMm(JSPUtil.getParameter(request, "atToPlnMm".trim(), ""));
    	setAtToPlnWk(JSPUtil.getParameter(request, "atToPlnWk".trim(), ""));
    	
    	// TP/SZ
    	setCntrTpszCd(JSPUtil.getParameter(request, "cntrTpszCd".trim(), ""));
    	setCompany(JSPUtil.getParameter(request, "company".trim(),""));
    	setLane(JSPUtil.getParameter(request, "lanecode".trim() ,""));
    	setVvd(JSPUtil.getParameter(request,"vvdcode".trim() , ""));
    	setNewTitle(JSPUtil.getParameter(request, "title_weekly".trim(),""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr0014ContitionVO[]
	 */
	public EesEqr0014ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr0014ContitionVO[]
	 */
	public EesEqr0014ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {		
		return getEesEqr0014ContitionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr0014ContitionVO[]
	 */
	public EesEqr0014ConditionVO[] getEesEqr0014ContitionVOs(){
		EesEqr0014ConditionVO[] vos = (EesEqr0014ConditionVO[])models.toArray(new EesEqr0014ConditionVO[models.size()]);
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
		
	}
}
