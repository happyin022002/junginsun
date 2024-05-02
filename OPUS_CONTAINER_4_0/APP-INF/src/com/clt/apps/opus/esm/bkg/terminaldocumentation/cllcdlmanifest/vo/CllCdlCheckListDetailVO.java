/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CllCdlCheckListDetailVO.java
*@FileTitle : CllCdlCheckListDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier :
*@LastVersion : 1.0
* 2009.10.12
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CllCdlCheckListDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<CllCdlCheckListDetailVO> models = new ArrayList<CllCdlCheckListDetailVO>();

	/* Column Info */
	private String cstmsDeclNo = null;
	/* Column Info */
	private String cgoTpCd = null;
	/* Column Info */
	private String crrCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String temp1 = null;
	/* Column Info */
	private String temp2 = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String trspModId = null;
	/* Column Info */
	private String evntYdCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String ediRptMsgRcvDt = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String eurTmlDmgId = null;
	/* Column Info */
	private String coRptId = null;
	/* Column Info */
	private String cntrSealNo2 = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String n1stPodCd = null;
	/* Column Info */
	private String callSgnNo = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String orgYdCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String cntrLdisDt = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String imdgClssId = null;
	/* Column Info */
	private String cntrLdisDt2 = null;
	/* Column Info */
	private String cntrTareWgt = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String stwgCellNo = null;
	/* Column Info */
	private String cgoStsId = null;
	/* Column Info */
	private String cntrSealNo = null;
	/* Column Info */
	private String mtchFlg = null;
	/* Column Info */
	private String ediSndrId = null;
	/* Column Info */
	private String grsWgt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public CllCdlCheckListDetailVO() {}

	public CllCdlCheckListDetailVO(String ibflag, String pagerows, String mtchFlg, String vvdCd, String cntrNo, String cntrTpszCd, String cntrSealNo, String cntrSealNo2, String cgoStsId, String evntYdCd, String polCd, String podCd, String n1stPodCd, String grsWgt, String cgoTpCd, String imdgClssId, String eurTmlDmgId, String trspModId, String cntrLdisDt, String bkgNo, String callSgnNo, String vslNm, String ediRptMsgRcvDt, String orgYdCd, String ediSndrId, String coRptId, String cntrLdisDt2, String stwgCellNo, String updDt, String temp1, String temp2, String crrCd, String cstmsDeclNo, String cntrTareWgt) {
		this.cstmsDeclNo = cstmsDeclNo;
		this.cgoTpCd = cgoTpCd;
		this.crrCd = crrCd;
		this.pagerows = pagerows;
		this.temp1 = temp1;
		this.temp2 = temp2;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.trspModId = trspModId;
		this.evntYdCd = evntYdCd;
		this.vvdCd = vvdCd;
		this.ediRptMsgRcvDt = ediRptMsgRcvDt;
		this.cntrTpszCd = cntrTpszCd;
		this.eurTmlDmgId = eurTmlDmgId;
		this.coRptId = coRptId;
		this.cntrSealNo2 = cntrSealNo2;
		this.updDt = updDt;
		this.n1stPodCd = n1stPodCd;
		this.callSgnNo = callSgnNo;
		this.vslNm = vslNm;
		this.orgYdCd = orgYdCd;
		this.podCd = podCd;
		this.cntrLdisDt = cntrLdisDt;
		this.bkgNo = bkgNo;
		this.imdgClssId = imdgClssId;
		this.cntrLdisDt2 = cntrLdisDt2;
		this.cntrTareWgt = cntrTareWgt;
		this.cntrNo = cntrNo;
		this.stwgCellNo = stwgCellNo;
		this.cgoStsId = cgoStsId;
		this.cntrSealNo = cntrSealNo;
		this.mtchFlg = mtchFlg;
		this.ediSndrId = ediSndrId;
		this.grsWgt = grsWgt;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cstms_decl_no", getCstmsDeclNo());
		this.hashColumns.put("cgo_tp_cd", getCgoTpCd());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("temp1", getTemp1());
		this.hashColumns.put("temp2", getTemp2());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("trsp_mod_id", getTrspModId());
		this.hashColumns.put("evnt_yd_cd", getEvntYdCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("edi_rpt_msg_rcv_dt", getEdiRptMsgRcvDt());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("eur_tml_dmg_id", getEurTmlDmgId());
		this.hashColumns.put("co_rpt_id", getCoRptId());
		this.hashColumns.put("cntr_seal_no2", getCntrSealNo2());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("n1st_pod_cd", getN1stPodCd());
		this.hashColumns.put("call_sgn_no", getCallSgnNo());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("org_yd_cd", getOrgYdCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cntr_ldis_dt", getCntrLdisDt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("imdg_clss_id", getImdgClssId());
		this.hashColumns.put("cntr_ldis_dt2", getCntrLdisDt2());
		this.hashColumns.put("cntr_tare_wgt", getCntrTareWgt());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("stwg_cell_no", getStwgCellNo());
		this.hashColumns.put("cgo_sts_id", getCgoStsId());
		this.hashColumns.put("cntr_seal_no", getCntrSealNo());
		this.hashColumns.put("mtch_flg", getMtchFlg());
		this.hashColumns.put("edi_sndr_id", getEdiSndrId());
		this.hashColumns.put("grs_wgt", getGrsWgt());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cstms_decl_no", "cstmsDeclNo");
		this.hashFields.put("cgo_tp_cd", "cgoTpCd");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("temp1", "temp1");
		this.hashFields.put("temp2", "temp2");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("trsp_mod_id", "trspModId");
		this.hashFields.put("evnt_yd_cd", "evntYdCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("edi_rpt_msg_rcv_dt", "ediRptMsgRcvDt");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("eur_tml_dmg_id", "eurTmlDmgId");
		this.hashFields.put("co_rpt_id", "coRptId");
		this.hashFields.put("cntr_seal_no2", "cntrSealNo2");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("n1st_pod_cd", "n1stPodCd");
		this.hashFields.put("call_sgn_no", "callSgnNo");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("org_yd_cd", "orgYdCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cntr_ldis_dt", "cntrLdisDt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("imdg_clss_id", "imdgClssId");
		this.hashFields.put("cntr_ldis_dt2", "cntrLdisDt2");
		this.hashFields.put("cntr_tare_wgt", "cntrTareWgt");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("stwg_cell_no", "stwgCellNo");
		this.hashFields.put("cgo_sts_id", "cgoStsId");
		this.hashFields.put("cntr_seal_no", "cntrSealNo");
		this.hashFields.put("mtch_flg", "mtchFlg");
		this.hashFields.put("edi_sndr_id", "ediSndrId");
		this.hashFields.put("grs_wgt", "grsWgt");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return cstmsDeclNo
	 */
	public String getCstmsDeclNo() {
		return this.cstmsDeclNo;
	}

	/**
	 * Column Info
	 * @return cgoTpCd
	 */
	public String getCgoTpCd() {
		return this.cgoTpCd;
	}

	/**
	 * Column Info
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
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
	 * @return temp1
	 */
	public String getTemp1() {
		return this.temp1;
	}

	/**
	 * Column Info
	 * @return temp2
	 */
	public String getTemp2() {
		return this.temp2;
	}

	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return trspModId
	 */
	public String getTrspModId() {
		return this.trspModId;
	}

	/**
	 * Column Info
	 * @return evntYdCd
	 */
	public String getEvntYdCd() {
		return this.evntYdCd;
	}

	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}

	/**
	 * Column Info
	 * @return ediRptMsgRcvDt
	 */
	public String getEdiRptMsgRcvDt() {
		return this.ediRptMsgRcvDt;
	}

	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}

	/**
	 * Column Info
	 * @return eurTmlDmgId
	 */
	public String getEurTmlDmgId() {
		return this.eurTmlDmgId;
	}

	/**
	 * Column Info
	 * @return coRptId
	 */
	public String getCoRptId() {
		return this.coRptId;
	}

	/**
	 * Column Info
	 * @return cntrSealNo2
	 */
	public String getCntrSealNo2() {
		return this.cntrSealNo2;
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
	 * @return n1stPodCd
	 */
	public String getN1stPodCd() {
		return this.n1stPodCd;
	}

	/**
	 * Column Info
	 * @return callSgnNo
	 */
	public String getCallSgnNo() {
		return this.callSgnNo;
	}

	/**
	 * Column Info
	 * @return vslNm
	 */
	public String getVslNm() {
		return this.vslNm;
	}

	/**
	 * Column Info
	 * @return orgYdCd
	 */
	public String getOrgYdCd() {
		return this.orgYdCd;
	}

	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}

	/**
	 * Column Info
	 * @return cntrLdisDt
	 */
	public String getCntrLdisDt() {
		return this.cntrLdisDt;
	}

	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}

	/**
	 * Column Info
	 * @return imdgClssId
	 */
	public String getImdgClssId() {
		return this.imdgClssId;
	}

	/**
	 * Column Info
	 * @return cntrLdisDt2
	 */
	public String getCntrLdisDt2() {
		return this.cntrLdisDt2;
	}

	/**
	 * Column Info
	 * @return cntrTareWgt
	 */
	public String getCntrTareWgt() {
		return this.cntrTareWgt;
	}

	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}

	/**
	 * Column Info
	 * @return stwgCellNo
	 */
	public String getStwgCellNo() {
		return this.stwgCellNo;
	}

	/**
	 * Column Info
	 * @return cgoStsId
	 */
	public String getCgoStsId() {
		return this.cgoStsId;
	}

	/**
	 * Column Info
	 * @return cntrSealNo
	 */
	public String getCntrSealNo() {
		return this.cntrSealNo;
	}

	/**
	 * Column Info
	 * @return mtchFlg
	 */
	public String getMtchFlg() {
		return this.mtchFlg;
	}

	/**
	 * Column Info
	 * @return ediSndrId
	 */
	public String getEdiSndrId() {
		return this.ediSndrId;
	}

	/**
	 * Column Info
	 * @return grsWgt
	 */
	public String getGrsWgt() {
		return this.grsWgt;
	}


	/**
	 * Column Info
	 * @param cstmsDeclNo
	 */
	public void setCstmsDeclNo(String cstmsDeclNo) {
		this.cstmsDeclNo = cstmsDeclNo;
	}

	/**
	 * Column Info
	 * @param cgoTpCd
	 */
	public void setCgoTpCd(String cgoTpCd) {
		this.cgoTpCd = cgoTpCd;
	}

	/**
	 * Column Info
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
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
	 * @param temp1
	 */
	public void setTemp1(String temp1) {
		this.temp1 = temp1;
	}

	/**
	 * Column Info
	 * @param temp2
	 */
	public void setTemp2(String temp2) {
		this.temp2 = temp2;
	}

	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param trspModId
	 */
	public void setTrspModId(String trspModId) {
		this.trspModId = trspModId;
	}

	/**
	 * Column Info
	 * @param evntYdCd
	 */
	public void setEvntYdCd(String evntYdCd) {
		this.evntYdCd = evntYdCd;
	}

	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}

	/**
	 * Column Info
	 * @param ediRptMsgRcvDt
	 */
	public void setEdiRptMsgRcvDt(String ediRptMsgRcvDt) {
		this.ediRptMsgRcvDt = ediRptMsgRcvDt;
	}

	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}

	/**
	 * Column Info
	 * @param eurTmlDmgId
	 */
	public void setEurTmlDmgId(String eurTmlDmgId) {
		this.eurTmlDmgId = eurTmlDmgId;
	}

	/**
	 * Column Info
	 * @param coRptId
	 */
	public void setCoRptId(String coRptId) {
		this.coRptId = coRptId;
	}

	/**
	 * Column Info
	 * @param cntrSealNo2
	 */
	public void setCntrSealNo2(String cntrSealNo2) {
		this.cntrSealNo2 = cntrSealNo2;
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
	 * @param n1stPodCd
	 */
	public void setN1stPodCd(String n1stPodCd) {
		this.n1stPodCd = n1stPodCd;
	}

	/**
	 * Column Info
	 * @param callSgnNo
	 */
	public void setCallSgnNo(String callSgnNo) {
		this.callSgnNo = callSgnNo;
	}

	/**
	 * Column Info
	 * @param vslNm
	 */
	public void setVslNm(String vslNm) {
		this.vslNm = vslNm;
	}

	/**
	 * Column Info
	 * @param orgYdCd
	 */
	public void setOrgYdCd(String orgYdCd) {
		this.orgYdCd = orgYdCd;
	}

	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}

	/**
	 * Column Info
	 * @param cntrLdisDt
	 */
	public void setCntrLdisDt(String cntrLdisDt) {
		this.cntrLdisDt = cntrLdisDt;
	}

	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	/**
	 * Column Info
	 * @param imdgClssId
	 */
	public void setImdgClssId(String imdgClssId) {
		this.imdgClssId = imdgClssId;
	}

	/**
	 * Column Info
	 * @param cntrLdisDt2
	 */
	public void setCntrLdisDt2(String cntrLdisDt2) {
		this.cntrLdisDt2 = cntrLdisDt2;
	}

	/**
	 * Column Info
	 * @param cntrTareWgt
	 */
	public void setCntrTareWgt(String cntrTareWgt) {
		this.cntrTareWgt = cntrTareWgt;
	}

	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	/**
	 * Column Info
	 * @param stwgCellNo
	 */
	public void setStwgCellNo(String stwgCellNo) {
		this.stwgCellNo = stwgCellNo;
	}

	/**
	 * Column Info
	 * @param cgoStsId
	 */
	public void setCgoStsId(String cgoStsId) {
		this.cgoStsId = cgoStsId;
	}

	/**
	 * Column Info
	 * @param cntrSealNo
	 */
	public void setCntrSealNo(String cntrSealNo) {
		this.cntrSealNo = cntrSealNo;
	}

	/**
	 * Column Info
	 * @param mtchFlg
	 */
	public void setMtchFlg(String mtchFlg) {
		this.mtchFlg = mtchFlg;
	}

	/**
	 * Column Info
	 * @param ediSndrId
	 */
	public void setEdiSndrId(String ediSndrId) {
		this.ediSndrId = ediSndrId;
	}

	/**
	 * Column Info
	 * @param grsWgt
	 */
	public void setGrsWgt(String grsWgt) {
		this.grsWgt = grsWgt;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCstmsDeclNo(JSPUtil.getParameter(request, "cstms_decl_no", ""));
		setCgoTpCd(JSPUtil.getParameter(request, "cgo_tp_cd", ""));
		setCrrCd(JSPUtil.getParameter(request, "crr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setTemp1(JSPUtil.getParameter(request, "temp1", ""));
		setTemp2(JSPUtil.getParameter(request, "temp2", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTrspModId(JSPUtil.getParameter(request, "trsp_mod_id", ""));
		setEvntYdCd(JSPUtil.getParameter(request, "evnt_yd_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setEdiRptMsgRcvDt(JSPUtil.getParameter(request, "edi_rpt_msg_rcv_dt", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setEurTmlDmgId(JSPUtil.getParameter(request, "eur_tml_dmg_id", ""));
		setCoRptId(JSPUtil.getParameter(request, "co_rpt_id", ""));
		setCntrSealNo2(JSPUtil.getParameter(request, "cntr_seal_no2", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setN1stPodCd(JSPUtil.getParameter(request, "n1st_pod_cd", ""));
		setCallSgnNo(JSPUtil.getParameter(request, "call_sgn_no", ""));
		setVslNm(JSPUtil.getParameter(request, "vsl_nm", ""));
		setOrgYdCd(JSPUtil.getParameter(request, "org_yd_cd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setCntrLdisDt(JSPUtil.getParameter(request, "cntr_ldis_dt", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setImdgClssId(JSPUtil.getParameter(request, "imdg_clss_id", ""));
		setCntrLdisDt2(JSPUtil.getParameter(request, "cntr_ldis_dt2", ""));
		setCntrTareWgt(JSPUtil.getParameter(request, "cntr_tare_wgt", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setStwgCellNo(JSPUtil.getParameter(request, "stwg_cell_no", ""));
		setCgoStsId(JSPUtil.getParameter(request, "cgo_sts_id", ""));
		setCntrSealNo(JSPUtil.getParameter(request, "cntr_seal_no", ""));
		setMtchFlg(JSPUtil.getParameter(request, "mtch_flg", ""));
		setEdiSndrId(JSPUtil.getParameter(request, "edi_sndr_id", ""));
		setGrsWgt(JSPUtil.getParameter(request, "grs_wgt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CllCdlCheckListDetailVO[]
	 */
	public CllCdlCheckListDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return CllCdlCheckListDetailVO[]
	 */
	public CllCdlCheckListDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CllCdlCheckListDetailVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] cstmsDeclNo = (JSPUtil.getParameter(request, prefix	+ "cstms_decl_no", length));
			String[] cgoTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_tp_cd", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] temp1 = (JSPUtil.getParameter(request, prefix	+ "temp1", length));
			String[] temp2 = (JSPUtil.getParameter(request, prefix	+ "temp2", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] trspModId = (JSPUtil.getParameter(request, prefix	+ "trsp_mod_id", length));
			String[] evntYdCd = (JSPUtil.getParameter(request, prefix	+ "evnt_yd_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] ediRptMsgRcvDt = (JSPUtil.getParameter(request, prefix	+ "edi_rpt_msg_rcv_dt", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] eurTmlDmgId = (JSPUtil.getParameter(request, prefix	+ "eur_tml_dmg_id", length));
			String[] coRptId = (JSPUtil.getParameter(request, prefix	+ "co_rpt_id", length));
			String[] cntrSealNo2 = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no2", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] n1stPodCd = (JSPUtil.getParameter(request, prefix	+ "n1st_pod_cd", length));
			String[] callSgnNo = (JSPUtil.getParameter(request, prefix	+ "call_sgn_no", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] orgYdCd = (JSPUtil.getParameter(request, prefix	+ "org_yd_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] cntrLdisDt = (JSPUtil.getParameter(request, prefix	+ "cntr_ldis_dt", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] imdgClssId = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_id", length));
			String[] cntrLdisDt2 = (JSPUtil.getParameter(request, prefix	+ "cntr_ldis_dt2", length));
			String[] cntrTareWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_tare_wgt", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] stwgCellNo = (JSPUtil.getParameter(request, prefix	+ "stwg_cell_no", length));
			String[] cgoStsId = (JSPUtil.getParameter(request, prefix	+ "cgo_sts_id", length));
			String[] cntrSealNo = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no", length));
			String[] mtchFlg = (JSPUtil.getParameter(request, prefix	+ "mtch_flg", length));
			String[] ediSndrId = (JSPUtil.getParameter(request, prefix	+ "edi_sndr_id", length));
			String[] grsWgt = (JSPUtil.getParameter(request, prefix	+ "grs_wgt", length));

			for (int i = 0; i < length; i++) {
				model = new CllCdlCheckListDetailVO();
				if (cstmsDeclNo[i] != null)
					model.setCstmsDeclNo(cstmsDeclNo[i]);
				if (cgoTpCd[i] != null)
					model.setCgoTpCd(cgoTpCd[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (temp1[i] != null)
					model.setTemp1(temp1[i]);
				if (temp2[i] != null)
					model.setTemp2(temp2[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (trspModId[i] != null)
					model.setTrspModId(trspModId[i]);
				if (evntYdCd[i] != null)
					model.setEvntYdCd(evntYdCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (ediRptMsgRcvDt[i] != null)
					model.setEdiRptMsgRcvDt(ediRptMsgRcvDt[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (eurTmlDmgId[i] != null)
					model.setEurTmlDmgId(eurTmlDmgId[i]);
				if (coRptId[i] != null)
					model.setCoRptId(coRptId[i]);
				if (cntrSealNo2[i] != null)
					model.setCntrSealNo2(cntrSealNo2[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (n1stPodCd[i] != null)
					model.setN1stPodCd(n1stPodCd[i]);
				if (callSgnNo[i] != null)
					model.setCallSgnNo(callSgnNo[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (orgYdCd[i] != null)
					model.setOrgYdCd(orgYdCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (cntrLdisDt[i] != null)
					model.setCntrLdisDt(cntrLdisDt[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (imdgClssId[i] != null)
					model.setImdgClssId(imdgClssId[i]);
				if (cntrLdisDt2[i] != null)
					model.setCntrLdisDt2(cntrLdisDt2[i]);
				if (cntrTareWgt[i] != null)
					model.setCntrTareWgt(cntrTareWgt[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (stwgCellNo[i] != null)
					model.setStwgCellNo(stwgCellNo[i]);
				if (cgoStsId[i] != null)
					model.setCgoStsId(cgoStsId[i]);
				if (cntrSealNo[i] != null)
					model.setCntrSealNo(cntrSealNo[i]);
				if (mtchFlg[i] != null)
					model.setMtchFlg(mtchFlg[i]);
				if (ediSndrId[i] != null)
					model.setEdiSndrId(ediSndrId[i]);
				if (grsWgt[i] != null)
					model.setGrsWgt(grsWgt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCllCdlCheckListDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CllCdlCheckListDetailVO[]
	 */
	public CllCdlCheckListDetailVO[] getCllCdlCheckListDetailVOs(){
		CllCdlCheckListDetailVO[] vos = (CllCdlCheckListDetailVO[])models.toArray(new CllCdlCheckListDetailVO[models.size()]);
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
		this.cstmsDeclNo = this.cstmsDeclNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTpCd = this.cgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.temp1 = this.temp1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.temp2 = this.temp2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspModId = this.trspModId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntYdCd = this.evntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRptMsgRcvDt = this.ediRptMsgRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eurTmlDmgId = this.eurTmlDmgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coRptId = this.coRptId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo2 = this.cntrSealNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPodCd = this.n1stPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSgnNo = this.callSgnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYdCd = this.orgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrLdisDt = this.cntrLdisDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssId = this.imdgClssId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrLdisDt2 = this.cntrLdisDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTareWgt = this.cntrTareWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwgCellNo = this.stwgCellNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoStsId = this.cgoStsId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo = this.cntrSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtchFlg = this.mtchFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndrId = this.ediSndrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgt = this.grsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
