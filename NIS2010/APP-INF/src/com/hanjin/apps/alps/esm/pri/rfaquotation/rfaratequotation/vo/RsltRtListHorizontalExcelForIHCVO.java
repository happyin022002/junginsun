/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RsltRtListHorizontalExcelForIHCVO.java
*@FileTitle : RsltRtListHorizontalExcelForIHCVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.27
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.07.27 이은섭 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo;

import java.lang.reflect.Field;
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
 * @author 이은섭
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltRtListHorizontalExcelForIHCVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltRtListHorizontalExcelForIHCVO> models = new ArrayList<RsltRtListHorizontalExcelForIHCVO>();
	
	/* Column Info */
	private String destRoutViaPortDefCd = null;
	/* Column Info */
	private String rateFicRf40hc = null;
	/* Column Info */
	private String rateRd40hc = null;
	/* Column Info */
	private String rateFicDry40 = null;
	/* Column Info */
	private String rateFicDry45 = null;
	/* Column Info */
	private String rateFicDry20 = null;
	/* Column Info */
	private String rateFicRd40hc = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String orgPrcTrspModNm = null;
	/* Column Info */
	private String rateDry20 = null;
	/* Column Info */
	private String rateDry45 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rateBofRd40hc = null;
	/* Column Info */
	private String rateBofDry20 = null;
	/* Column Info */
	private String rateBofRf40hc = null;
	/* Column Info */
	private String orgRoutViaPortDefCd = null;
	/* Column Info */
	private String rateDry40 = null;
	/* Column Info */
	private String prcCmdtDefNm = null;
	/* Column Info */
	private String rateBofDry40hc = null;
	/* Column Info */
	private String prcCmdtDefCd = null;
	/* Column Info */
	private String rateBofDry45 = null;
	/* Column Info */
	private String rateFicDry40hc = null;
	/* Column Info */
	private String orgRoutPntLocDefCd = null;
	/* Column Info */
	private String rateDry40hc = null;
	/* Column Info */
	private String orgRoutPntLocDefNm = null;
	/* Column Info */
	private String routDpSeq = null;
	/* Column Info */
	private String cmdtDpSeq = null;
	/* Column Info */
	private String rateRf40hc = null;
	/* Column Info */
	private String destPrcTrspModNm = null;
	/* Column Info */
	private String destRoutPntLocDefCd = null;
	/* Column Info */
	private String rateBofDry40 = null;
	/* Column Info */
	private String destRoutPntLocDefNm = null;
	/* Column Info */
	private String orgRcvDeTermNm = null;
	/* Column Info */
	private String destRcvDeTermNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltRtListHorizontalExcelForIHCVO() {}

	public RsltRtListHorizontalExcelForIHCVO(String ibflag, String pagerows, String cmdtDpSeq, String routDpSeq, String prcCmdtDefCd, String prcCmdtDefNm, String orgRoutPntLocDefCd, String orgRoutPntLocDefNm, String orgRcvDeTermNm, String orgPrcTrspModNm, String orgRoutViaPortDefCd, String destRoutViaPortDefCd, String destRoutPntLocDefCd, String destRoutPntLocDefNm, String destRcvDeTermNm, String destPrcTrspModNm, String rateDry20, String rateFicDry20, String rateBofDry20, String rateDry40, String rateFicDry40, String rateBofDry40, String rateDry40hc, String rateFicDry40hc, String rateBofDry40hc, String rateDry45, String rateFicDry45, String rateBofDry45, String rateRd40hc, String rateFicRd40hc, String rateBofRd40hc, String rateRf40hc, String rateFicRf40hc, String rateBofRf40hc) {
		this.destRoutViaPortDefCd = destRoutViaPortDefCd;
		this.rateFicRf40hc = rateFicRf40hc;
		this.rateRd40hc = rateRd40hc;
		this.rateFicDry40 = rateFicDry40;
		this.rateFicDry45 = rateFicDry45;
		this.rateFicDry20 = rateFicDry20;
		this.rateFicRd40hc = rateFicRd40hc;
		this.pagerows = pagerows;
		this.orgPrcTrspModNm = orgPrcTrspModNm;
		this.rateDry20 = rateDry20;
		this.rateDry45 = rateDry45;
		this.ibflag = ibflag;
		this.rateBofRd40hc = rateBofRd40hc;
		this.rateBofDry20 = rateBofDry20;
		this.rateBofRf40hc = rateBofRf40hc;
		this.orgRoutViaPortDefCd = orgRoutViaPortDefCd;
		this.rateDry40 = rateDry40;
		this.prcCmdtDefNm = prcCmdtDefNm;
		this.rateBofDry40hc = rateBofDry40hc;
		this.prcCmdtDefCd = prcCmdtDefCd;
		this.rateBofDry45 = rateBofDry45;
		this.rateFicDry40hc = rateFicDry40hc;
		this.orgRoutPntLocDefCd = orgRoutPntLocDefCd;
		this.rateDry40hc = rateDry40hc;
		this.orgRoutPntLocDefNm = orgRoutPntLocDefNm;
		this.routDpSeq = routDpSeq;
		this.cmdtDpSeq = cmdtDpSeq;
		this.rateRf40hc = rateRf40hc;
		this.destPrcTrspModNm = destPrcTrspModNm;
		this.destRoutPntLocDefCd = destRoutPntLocDefCd;
		this.rateBofDry40 = rateBofDry40;
		this.destRoutPntLocDefNm = destRoutPntLocDefNm;
		this.orgRcvDeTermNm = orgRcvDeTermNm;
		this.destRcvDeTermNm = destRcvDeTermNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dest_rout_via_port_def_cd", getDestRoutViaPortDefCd());
		this.hashColumns.put("rate_fic_rf40hc", getRateFicRf40hc());
		this.hashColumns.put("rate_rd40hc", getRateRd40hc());
		this.hashColumns.put("rate_fic_dry40", getRateFicDry40());
		this.hashColumns.put("rate_fic_dry45", getRateFicDry45());
		this.hashColumns.put("rate_fic_dry20", getRateFicDry20());
		this.hashColumns.put("rate_fic_rd40hc", getRateFicRd40hc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("org_prc_trsp_mod_nm", getOrgPrcTrspModNm());
		this.hashColumns.put("rate_dry20", getRateDry20());
		this.hashColumns.put("rate_dry45", getRateDry45());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rate_bof_rd40hc", getRateBofRd40hc());
		this.hashColumns.put("rate_bof_dry20", getRateBofDry20());
		this.hashColumns.put("rate_bof_rf40hc", getRateBofRf40hc());
		this.hashColumns.put("org_rout_via_port_def_cd", getOrgRoutViaPortDefCd());
		this.hashColumns.put("rate_dry40", getRateDry40());
		this.hashColumns.put("prc_cmdt_def_nm", getPrcCmdtDefNm());
		this.hashColumns.put("rate_bof_dry40hc", getRateBofDry40hc());
		this.hashColumns.put("prc_cmdt_def_cd", getPrcCmdtDefCd());
		this.hashColumns.put("rate_bof_dry45", getRateBofDry45());
		this.hashColumns.put("rate_fic_dry40hc", getRateFicDry40hc());
		this.hashColumns.put("org_rout_pnt_loc_def_cd", getOrgRoutPntLocDefCd());
		this.hashColumns.put("rate_dry40hc", getRateDry40hc());
		this.hashColumns.put("org_rout_pnt_loc_def_nm", getOrgRoutPntLocDefNm());
		this.hashColumns.put("rout_dp_seq", getRoutDpSeq());
		this.hashColumns.put("cmdt_dp_seq", getCmdtDpSeq());
		this.hashColumns.put("rate_rf40hc", getRateRf40hc());
		this.hashColumns.put("dest_prc_trsp_mod_nm", getDestPrcTrspModNm());
		this.hashColumns.put("dest_rout_pnt_loc_def_cd", getDestRoutPntLocDefCd());
		this.hashColumns.put("rate_bof_dry40", getRateBofDry40());
		this.hashColumns.put("dest_rout_pnt_loc_def_nm", getDestRoutPntLocDefNm());
		this.hashColumns.put("org_rcv_de_term_nm", getOrgRcvDeTermNm());
		this.hashColumns.put("dest_rcv_de_term_nm", getDestRcvDeTermNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dest_rout_via_port_def_cd", "destRoutViaPortDefCd");
		this.hashFields.put("rate_fic_rf40hc", "rateFicRf40hc");
		this.hashFields.put("rate_rd40hc", "rateRd40hc");
		this.hashFields.put("rate_fic_dry40", "rateFicDry40");
		this.hashFields.put("rate_fic_dry45", "rateFicDry45");
		this.hashFields.put("rate_fic_dry20", "rateFicDry20");
		this.hashFields.put("rate_fic_rd40hc", "rateFicRd40hc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("org_prc_trsp_mod_nm", "orgPrcTrspModNm");
		this.hashFields.put("rate_dry20", "rateDry20");
		this.hashFields.put("rate_dry45", "rateDry45");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rate_bof_rd40hc", "rateBofRd40hc");
		this.hashFields.put("rate_bof_dry20", "rateBofDry20");
		this.hashFields.put("rate_bof_rf40hc", "rateBofRf40hc");
		this.hashFields.put("org_rout_via_port_def_cd", "orgRoutViaPortDefCd");
		this.hashFields.put("rate_dry40", "rateDry40");
		this.hashFields.put("prc_cmdt_def_nm", "prcCmdtDefNm");
		this.hashFields.put("rate_bof_dry40hc", "rateBofDry40hc");
		this.hashFields.put("prc_cmdt_def_cd", "prcCmdtDefCd");
		this.hashFields.put("rate_bof_dry45", "rateBofDry45");
		this.hashFields.put("rate_fic_dry40hc", "rateFicDry40hc");
		this.hashFields.put("org_rout_pnt_loc_def_cd", "orgRoutPntLocDefCd");
		this.hashFields.put("rate_dry40hc", "rateDry40hc");
		this.hashFields.put("org_rout_pnt_loc_def_nm", "orgRoutPntLocDefNm");
		this.hashFields.put("rout_dp_seq", "routDpSeq");
		this.hashFields.put("cmdt_dp_seq", "cmdtDpSeq");
		this.hashFields.put("rate_rf40hc", "rateRf40hc");
		this.hashFields.put("dest_prc_trsp_mod_nm", "destPrcTrspModNm");
		this.hashFields.put("dest_rout_pnt_loc_def_cd", "destRoutPntLocDefCd");
		this.hashFields.put("rate_bof_dry40", "rateBofDry40");
		this.hashFields.put("dest_rout_pnt_loc_def_nm", "destRoutPntLocDefNm");
		this.hashFields.put("org_rcv_de_term_nm", "orgRcvDeTermNm");
		this.hashFields.put("dest_rcv_de_term_nm", "destRcvDeTermNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return destRoutViaPortDefCd
	 */
	public String getDestRoutViaPortDefCd() {
		return this.destRoutViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @return rateFicRf40hc
	 */
	public String getRateFicRf40hc() {
		return this.rateFicRf40hc;
	}
	
	/**
	 * Column Info
	 * @return rateRd40hc
	 */
	public String getRateRd40hc() {
		return this.rateRd40hc;
	}
	
	/**
	 * Column Info
	 * @return rateFicDry40
	 */
	public String getRateFicDry40() {
		return this.rateFicDry40;
	}
	
	/**
	 * Column Info
	 * @return rateFicDry45
	 */
	public String getRateFicDry45() {
		return this.rateFicDry45;
	}
	
	/**
	 * Column Info
	 * @return rateFicDry20
	 */
	public String getRateFicDry20() {
		return this.rateFicDry20;
	}
	
	/**
	 * Column Info
	 * @return rateFicRd40hc
	 */
	public String getRateFicRd40hc() {
		return this.rateFicRd40hc;
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
	 * @return orgPrcTrspModNm
	 */
	public String getOrgPrcTrspModNm() {
		return this.orgPrcTrspModNm;
	}
	
	/**
	 * Column Info
	 * @return rateDry20
	 */
	public String getRateDry20() {
		return this.rateDry20;
	}
	
	/**
	 * Column Info
	 * @return rateDry45
	 */
	public String getRateDry45() {
		return this.rateDry45;
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
	 * @return rateBofRd40hc
	 */
	public String getRateBofRd40hc() {
		return this.rateBofRd40hc;
	}
	
	/**
	 * Column Info
	 * @return rateBofDry20
	 */
	public String getRateBofDry20() {
		return this.rateBofDry20;
	}
	
	/**
	 * Column Info
	 * @return rateBofRf40hc
	 */
	public String getRateBofRf40hc() {
		return this.rateBofRf40hc;
	}
	
	/**
	 * Column Info
	 * @return orgRoutViaPortDefCd
	 */
	public String getOrgRoutViaPortDefCd() {
		return this.orgRoutViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @return rateDry40
	 */
	public String getRateDry40() {
		return this.rateDry40;
	}
	
	/**
	 * Column Info
	 * @return prcCmdtDefNm
	 */
	public String getPrcCmdtDefNm() {
		return this.prcCmdtDefNm;
	}
	
	/**
	 * Column Info
	 * @return rateBofDry40hc
	 */
	public String getRateBofDry40hc() {
		return this.rateBofDry40hc;
	}
	
	/**
	 * Column Info
	 * @return prcCmdtDefCd
	 */
	public String getPrcCmdtDefCd() {
		return this.prcCmdtDefCd;
	}
	
	/**
	 * Column Info
	 * @return rateBofDry45
	 */
	public String getRateBofDry45() {
		return this.rateBofDry45;
	}
	
	/**
	 * Column Info
	 * @return rateFicDry40hc
	 */
	public String getRateFicDry40hc() {
		return this.rateFicDry40hc;
	}
	
	/**
	 * Column Info
	 * @return orgRoutPntLocDefCd
	 */
	public String getOrgRoutPntLocDefCd() {
		return this.orgRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @return rateDry40hc
	 */
	public String getRateDry40hc() {
		return this.rateDry40hc;
	}
	
	/**
	 * Column Info
	 * @return orgRoutPntLocDefNm
	 */
	public String getOrgRoutPntLocDefNm() {
		return this.orgRoutPntLocDefNm;
	}
	
	/**
	 * Column Info
	 * @return routDpSeq
	 */
	public String getRoutDpSeq() {
		return this.routDpSeq;
	}
	
	/**
	 * Column Info
	 * @return cmdtDpSeq
	 */
	public String getCmdtDpSeq() {
		return this.cmdtDpSeq;
	}
	
	/**
	 * Column Info
	 * @return rateRf40hc
	 */
	public String getRateRf40hc() {
		return this.rateRf40hc;
	}
	
	/**
	 * Column Info
	 * @return destPrcTrspModNm
	 */
	public String getDestPrcTrspModNm() {
		return this.destPrcTrspModNm;
	}
	
	/**
	 * Column Info
	 * @return destRoutPntLocDefCd
	 */
	public String getDestRoutPntLocDefCd() {
		return this.destRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @return rateBofDry40
	 */
	public String getRateBofDry40() {
		return this.rateBofDry40;
	}
	
	/**
	 * Column Info
	 * @return destRoutPntLocDefNm
	 */
	public String getDestRoutPntLocDefNm() {
		return this.destRoutPntLocDefNm;
	}
	
	/**
	 * Column Info
	 * @return orgRcvDeTermNm
	 */
	public String getOrgRcvDeTermNm() {
		return this.orgRcvDeTermNm;
	}
	
	/**
	 * Column Info
	 * @return destRcvDeTermNm
	 */
	public String getDestRcvDeTermNm() {
		return this.destRcvDeTermNm;
	}
	

	/**
	 * Column Info
	 * @param destRoutViaPortDefCd
	 */
	public void setDestRoutViaPortDefCd(String destRoutViaPortDefCd) {
		this.destRoutViaPortDefCd = destRoutViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @param rateFicRf40hc
	 */
	public void setRateFicRf40hc(String rateFicRf40hc) {
		this.rateFicRf40hc = rateFicRf40hc;
	}
	
	/**
	 * Column Info
	 * @param rateRd40hc
	 */
	public void setRateRd40hc(String rateRd40hc) {
		this.rateRd40hc = rateRd40hc;
	}
	
	/**
	 * Column Info
	 * @param rateFicDry40
	 */
	public void setRateFicDry40(String rateFicDry40) {
		this.rateFicDry40 = rateFicDry40;
	}
	
	/**
	 * Column Info
	 * @param rateFicDry45
	 */
	public void setRateFicDry45(String rateFicDry45) {
		this.rateFicDry45 = rateFicDry45;
	}
	
	/**
	 * Column Info
	 * @param rateFicDry20
	 */
	public void setRateFicDry20(String rateFicDry20) {
		this.rateFicDry20 = rateFicDry20;
	}
	
	/**
	 * Column Info
	 * @param rateFicRd40hc
	 */
	public void setRateFicRd40hc(String rateFicRd40hc) {
		this.rateFicRd40hc = rateFicRd40hc;
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
	 * @param orgPrcTrspModNm
	 */
	public void setOrgPrcTrspModNm(String orgPrcTrspModNm) {
		this.orgPrcTrspModNm = orgPrcTrspModNm;
	}
	
	/**
	 * Column Info
	 * @param rateDry20
	 */
	public void setRateDry20(String rateDry20) {
		this.rateDry20 = rateDry20;
	}
	
	/**
	 * Column Info
	 * @param rateDry45
	 */
	public void setRateDry45(String rateDry45) {
		this.rateDry45 = rateDry45;
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
	 * @param rateBofRd40hc
	 */
	public void setRateBofRd40hc(String rateBofRd40hc) {
		this.rateBofRd40hc = rateBofRd40hc;
	}
	
	/**
	 * Column Info
	 * @param rateBofDry20
	 */
	public void setRateBofDry20(String rateBofDry20) {
		this.rateBofDry20 = rateBofDry20;
	}
	
	/**
	 * Column Info
	 * @param rateBofRf40hc
	 */
	public void setRateBofRf40hc(String rateBofRf40hc) {
		this.rateBofRf40hc = rateBofRf40hc;
	}
	
	/**
	 * Column Info
	 * @param orgRoutViaPortDefCd
	 */
	public void setOrgRoutViaPortDefCd(String orgRoutViaPortDefCd) {
		this.orgRoutViaPortDefCd = orgRoutViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @param rateDry40
	 */
	public void setRateDry40(String rateDry40) {
		this.rateDry40 = rateDry40;
	}
	
	/**
	 * Column Info
	 * @param prcCmdtDefNm
	 */
	public void setPrcCmdtDefNm(String prcCmdtDefNm) {
		this.prcCmdtDefNm = prcCmdtDefNm;
	}
	
	/**
	 * Column Info
	 * @param rateBofDry40hc
	 */
	public void setRateBofDry40hc(String rateBofDry40hc) {
		this.rateBofDry40hc = rateBofDry40hc;
	}
	
	/**
	 * Column Info
	 * @param prcCmdtDefCd
	 */
	public void setPrcCmdtDefCd(String prcCmdtDefCd) {
		this.prcCmdtDefCd = prcCmdtDefCd;
	}
	
	/**
	 * Column Info
	 * @param rateBofDry45
	 */
	public void setRateBofDry45(String rateBofDry45) {
		this.rateBofDry45 = rateBofDry45;
	}
	
	/**
	 * Column Info
	 * @param rateFicDry40hc
	 */
	public void setRateFicDry40hc(String rateFicDry40hc) {
		this.rateFicDry40hc = rateFicDry40hc;
	}
	
	/**
	 * Column Info
	 * @param orgRoutPntLocDefCd
	 */
	public void setOrgRoutPntLocDefCd(String orgRoutPntLocDefCd) {
		this.orgRoutPntLocDefCd = orgRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @param rateDry40hc
	 */
	public void setRateDry40hc(String rateDry40hc) {
		this.rateDry40hc = rateDry40hc;
	}
	
	/**
	 * Column Info
	 * @param orgRoutPntLocDefNm
	 */
	public void setOrgRoutPntLocDefNm(String orgRoutPntLocDefNm) {
		this.orgRoutPntLocDefNm = orgRoutPntLocDefNm;
	}
	
	/**
	 * Column Info
	 * @param routDpSeq
	 */
	public void setRoutDpSeq(String routDpSeq) {
		this.routDpSeq = routDpSeq;
	}
	
	/**
	 * Column Info
	 * @param cmdtDpSeq
	 */
	public void setCmdtDpSeq(String cmdtDpSeq) {
		this.cmdtDpSeq = cmdtDpSeq;
	}
	
	/**
	 * Column Info
	 * @param rateRf40hc
	 */
	public void setRateRf40hc(String rateRf40hc) {
		this.rateRf40hc = rateRf40hc;
	}
	
	/**
	 * Column Info
	 * @param destPrcTrspModNm
	 */
	public void setDestPrcTrspModNm(String destPrcTrspModNm) {
		this.destPrcTrspModNm = destPrcTrspModNm;
	}
	
	/**
	 * Column Info
	 * @param destRoutPntLocDefCd
	 */
	public void setDestRoutPntLocDefCd(String destRoutPntLocDefCd) {
		this.destRoutPntLocDefCd = destRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @param rateBofDry40
	 */
	public void setRateBofDry40(String rateBofDry40) {
		this.rateBofDry40 = rateBofDry40;
	}
	
	/**
	 * Column Info
	 * @param destRoutPntLocDefNm
	 */
	public void setDestRoutPntLocDefNm(String destRoutPntLocDefNm) {
		this.destRoutPntLocDefNm = destRoutPntLocDefNm;
	}
	
	/**
	 * Column Info
	 * @param orgRcvDeTermNm
	 */
	public void setOrgRcvDeTermNm(String orgRcvDeTermNm) {
		this.orgRcvDeTermNm = orgRcvDeTermNm;
	}
	
	/**
	 * Column Info
	 * @param destRcvDeTermNm
	 */
	public void setDestRcvDeTermNm(String destRcvDeTermNm) {
		this.destRcvDeTermNm = destRcvDeTermNm;
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
		setDestRoutViaPortDefCd(JSPUtil.getParameter(request, prefix + "dest_rout_via_port_def_cd", ""));
		setRateFicRf40hc(JSPUtil.getParameter(request, prefix + "rate_fic_rf40hc", ""));
		setRateRd40hc(JSPUtil.getParameter(request, prefix + "rate_rd40hc", ""));
		setRateFicDry40(JSPUtil.getParameter(request, prefix + "rate_fic_dry40", ""));
		setRateFicDry45(JSPUtil.getParameter(request, prefix + "rate_fic_dry45", ""));
		setRateFicDry20(JSPUtil.getParameter(request, prefix + "rate_fic_dry20", ""));
		setRateFicRd40hc(JSPUtil.getParameter(request, prefix + "rate_fic_rd40hc", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOrgPrcTrspModNm(JSPUtil.getParameter(request, prefix + "org_prc_trsp_mod_nm", ""));
		setRateDry20(JSPUtil.getParameter(request, prefix + "rate_dry20", ""));
		setRateDry45(JSPUtil.getParameter(request, prefix + "rate_dry45", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRateBofRd40hc(JSPUtil.getParameter(request, prefix + "rate_bof_rd40hc", ""));
		setRateBofDry20(JSPUtil.getParameter(request, prefix + "rate_bof_dry20", ""));
		setRateBofRf40hc(JSPUtil.getParameter(request, prefix + "rate_bof_rf40hc", ""));
		setOrgRoutViaPortDefCd(JSPUtil.getParameter(request, prefix + "org_rout_via_port_def_cd", ""));
		setRateDry40(JSPUtil.getParameter(request, prefix + "rate_dry40", ""));
		setPrcCmdtDefNm(JSPUtil.getParameter(request, prefix + "prc_cmdt_def_nm", ""));
		setRateBofDry40hc(JSPUtil.getParameter(request, prefix + "rate_bof_dry40hc", ""));
		setPrcCmdtDefCd(JSPUtil.getParameter(request, prefix + "prc_cmdt_def_cd", ""));
		setRateBofDry45(JSPUtil.getParameter(request, prefix + "rate_bof_dry45", ""));
		setRateFicDry40hc(JSPUtil.getParameter(request, prefix + "rate_fic_dry40hc", ""));
		setOrgRoutPntLocDefCd(JSPUtil.getParameter(request, prefix + "org_rout_pnt_loc_def_cd", ""));
		setRateDry40hc(JSPUtil.getParameter(request, prefix + "rate_dry40hc", ""));
		setOrgRoutPntLocDefNm(JSPUtil.getParameter(request, prefix + "org_rout_pnt_loc_def_nm", ""));
		setRoutDpSeq(JSPUtil.getParameter(request, prefix + "rout_dp_seq", ""));
		setCmdtDpSeq(JSPUtil.getParameter(request, prefix + "cmdt_dp_seq", ""));
		setRateRf40hc(JSPUtil.getParameter(request, prefix + "rate_rf40hc", ""));
		setDestPrcTrspModNm(JSPUtil.getParameter(request, prefix + "dest_prc_trsp_mod_nm", ""));
		setDestRoutPntLocDefCd(JSPUtil.getParameter(request, prefix + "dest_rout_pnt_loc_def_cd", ""));
		setRateBofDry40(JSPUtil.getParameter(request, prefix + "rate_bof_dry40", ""));
		setDestRoutPntLocDefNm(JSPUtil.getParameter(request, prefix + "dest_rout_pnt_loc_def_nm", ""));
		setOrgRcvDeTermNm(JSPUtil.getParameter(request, prefix + "org_rcv_de_term_nm", ""));
		setDestRcvDeTermNm(JSPUtil.getParameter(request, prefix + "dest_rcv_de_term_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltRtListHorizontalExcelForIHCVO[]
	 */
	public RsltRtListHorizontalExcelForIHCVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltRtListHorizontalExcelForIHCVO[]
	 */
	public RsltRtListHorizontalExcelForIHCVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltRtListHorizontalExcelForIHCVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] destRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "dest_rout_via_port_def_cd", length));
			String[] rateFicRf40hc = (JSPUtil.getParameter(request, prefix	+ "rate_fic_rf40hc", length));
			String[] rateRd40hc = (JSPUtil.getParameter(request, prefix	+ "rate_rd40hc", length));
			String[] rateFicDry40 = (JSPUtil.getParameter(request, prefix	+ "rate_fic_dry40", length));
			String[] rateFicDry45 = (JSPUtil.getParameter(request, prefix	+ "rate_fic_dry45", length));
			String[] rateFicDry20 = (JSPUtil.getParameter(request, prefix	+ "rate_fic_dry20", length));
			String[] rateFicRd40hc = (JSPUtil.getParameter(request, prefix	+ "rate_fic_rd40hc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] orgPrcTrspModNm = (JSPUtil.getParameter(request, prefix	+ "org_prc_trsp_mod_nm", length));
			String[] rateDry20 = (JSPUtil.getParameter(request, prefix	+ "rate_dry20", length));
			String[] rateDry45 = (JSPUtil.getParameter(request, prefix	+ "rate_dry45", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rateBofRd40hc = (JSPUtil.getParameter(request, prefix	+ "rate_bof_rd40hc", length));
			String[] rateBofDry20 = (JSPUtil.getParameter(request, prefix	+ "rate_bof_dry20", length));
			String[] rateBofRf40hc = (JSPUtil.getParameter(request, prefix	+ "rate_bof_rf40hc", length));
			String[] orgRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "org_rout_via_port_def_cd", length));
			String[] rateDry40 = (JSPUtil.getParameter(request, prefix	+ "rate_dry40", length));
			String[] prcCmdtDefNm = (JSPUtil.getParameter(request, prefix	+ "prc_cmdt_def_nm", length));
			String[] rateBofDry40hc = (JSPUtil.getParameter(request, prefix	+ "rate_bof_dry40hc", length));
			String[] prcCmdtDefCd = (JSPUtil.getParameter(request, prefix	+ "prc_cmdt_def_cd", length));
			String[] rateBofDry45 = (JSPUtil.getParameter(request, prefix	+ "rate_bof_dry45", length));
			String[] rateFicDry40hc = (JSPUtil.getParameter(request, prefix	+ "rate_fic_dry40hc", length));
			String[] orgRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "org_rout_pnt_loc_def_cd", length));
			String[] rateDry40hc = (JSPUtil.getParameter(request, prefix	+ "rate_dry40hc", length));
			String[] orgRoutPntLocDefNm = (JSPUtil.getParameter(request, prefix	+ "org_rout_pnt_loc_def_nm", length));
			String[] routDpSeq = (JSPUtil.getParameter(request, prefix	+ "rout_dp_seq", length));
			String[] cmdtDpSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_dp_seq", length));
			String[] rateRf40hc = (JSPUtil.getParameter(request, prefix	+ "rate_rf40hc", length));
			String[] destPrcTrspModNm = (JSPUtil.getParameter(request, prefix	+ "dest_prc_trsp_mod_nm", length));
			String[] destRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "dest_rout_pnt_loc_def_cd", length));
			String[] rateBofDry40 = (JSPUtil.getParameter(request, prefix	+ "rate_bof_dry40", length));
			String[] destRoutPntLocDefNm = (JSPUtil.getParameter(request, prefix	+ "dest_rout_pnt_loc_def_nm", length));
			String[] orgRcvDeTermNm = (JSPUtil.getParameter(request, prefix	+ "org_rcv_de_term_nm", length));
			String[] destRcvDeTermNm = (JSPUtil.getParameter(request, prefix	+ "dest_rcv_de_term_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltRtListHorizontalExcelForIHCVO();
				if (destRoutViaPortDefCd[i] != null)
					model.setDestRoutViaPortDefCd(destRoutViaPortDefCd[i]);
				if (rateFicRf40hc[i] != null)
					model.setRateFicRf40hc(rateFicRf40hc[i]);
				if (rateRd40hc[i] != null)
					model.setRateRd40hc(rateRd40hc[i]);
				if (rateFicDry40[i] != null)
					model.setRateFicDry40(rateFicDry40[i]);
				if (rateFicDry45[i] != null)
					model.setRateFicDry45(rateFicDry45[i]);
				if (rateFicDry20[i] != null)
					model.setRateFicDry20(rateFicDry20[i]);
				if (rateFicRd40hc[i] != null)
					model.setRateFicRd40hc(rateFicRd40hc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (orgPrcTrspModNm[i] != null)
					model.setOrgPrcTrspModNm(orgPrcTrspModNm[i]);
				if (rateDry20[i] != null)
					model.setRateDry20(rateDry20[i]);
				if (rateDry45[i] != null)
					model.setRateDry45(rateDry45[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rateBofRd40hc[i] != null)
					model.setRateBofRd40hc(rateBofRd40hc[i]);
				if (rateBofDry20[i] != null)
					model.setRateBofDry20(rateBofDry20[i]);
				if (rateBofRf40hc[i] != null)
					model.setRateBofRf40hc(rateBofRf40hc[i]);
				if (orgRoutViaPortDefCd[i] != null)
					model.setOrgRoutViaPortDefCd(orgRoutViaPortDefCd[i]);
				if (rateDry40[i] != null)
					model.setRateDry40(rateDry40[i]);
				if (prcCmdtDefNm[i] != null)
					model.setPrcCmdtDefNm(prcCmdtDefNm[i]);
				if (rateBofDry40hc[i] != null)
					model.setRateBofDry40hc(rateBofDry40hc[i]);
				if (prcCmdtDefCd[i] != null)
					model.setPrcCmdtDefCd(prcCmdtDefCd[i]);
				if (rateBofDry45[i] != null)
					model.setRateBofDry45(rateBofDry45[i]);
				if (rateFicDry40hc[i] != null)
					model.setRateFicDry40hc(rateFicDry40hc[i]);
				if (orgRoutPntLocDefCd[i] != null)
					model.setOrgRoutPntLocDefCd(orgRoutPntLocDefCd[i]);
				if (rateDry40hc[i] != null)
					model.setRateDry40hc(rateDry40hc[i]);
				if (orgRoutPntLocDefNm[i] != null)
					model.setOrgRoutPntLocDefNm(orgRoutPntLocDefNm[i]);
				if (routDpSeq[i] != null)
					model.setRoutDpSeq(routDpSeq[i]);
				if (cmdtDpSeq[i] != null)
					model.setCmdtDpSeq(cmdtDpSeq[i]);
				if (rateRf40hc[i] != null)
					model.setRateRf40hc(rateRf40hc[i]);
				if (destPrcTrspModNm[i] != null)
					model.setDestPrcTrspModNm(destPrcTrspModNm[i]);
				if (destRoutPntLocDefCd[i] != null)
					model.setDestRoutPntLocDefCd(destRoutPntLocDefCd[i]);
				if (rateBofDry40[i] != null)
					model.setRateBofDry40(rateBofDry40[i]);
				if (destRoutPntLocDefNm[i] != null)
					model.setDestRoutPntLocDefNm(destRoutPntLocDefNm[i]);
				if (orgRcvDeTermNm[i] != null)
					model.setOrgRcvDeTermNm(orgRcvDeTermNm[i]);
				if (destRcvDeTermNm[i] != null)
					model.setDestRcvDeTermNm(destRcvDeTermNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltRtListHorizontalExcelForIHCVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltRtListHorizontalExcelForIHCVO[]
	 */
	public RsltRtListHorizontalExcelForIHCVO[] getRsltRtListHorizontalExcelForIHCVOs(){
		RsltRtListHorizontalExcelForIHCVO[] vos = (RsltRtListHorizontalExcelForIHCVO[])models.toArray(new RsltRtListHorizontalExcelForIHCVO[models.size()]);
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
		this.destRoutViaPortDefCd = this.destRoutViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateFicRf40hc = this.rateFicRf40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateRd40hc = this.rateRd40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateFicDry40 = this.rateFicDry40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateFicDry45 = this.rateFicDry45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateFicDry20 = this.rateFicDry20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateFicRd40hc = this.rateFicRd40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgPrcTrspModNm = this.orgPrcTrspModNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateDry20 = this.rateDry20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateDry45 = this.rateDry45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateBofRd40hc = this.rateBofRd40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateBofDry20 = this.rateBofDry20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateBofRf40hc = this.rateBofRf40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutViaPortDefCd = this.orgRoutViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateDry40 = this.rateDry40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCmdtDefNm = this.prcCmdtDefNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateBofDry40hc = this.rateBofDry40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCmdtDefCd = this.prcCmdtDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateBofDry45 = this.rateBofDry45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateFicDry40hc = this.rateFicDry40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutPntLocDefCd = this.orgRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateDry40hc = this.rateDry40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutPntLocDefNm = this.orgRoutPntLocDefNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routDpSeq = this.routDpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDpSeq = this.cmdtDpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateRf40hc = this.rateRf40hc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destPrcTrspModNm = this.destPrcTrspModNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutPntLocDefCd = this.destRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateBofDry40 = this.rateBofDry40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutPntLocDefNm = this.destRoutPntLocDefNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRcvDeTermNm = this.orgRcvDeTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRcvDeTermNm = this.destRcvDeTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
