/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CdlDetailVO.java
*@FileTitle : CdlDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.30
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.09.30 김승민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김승민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CdlDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CdlDetailVO> models = new ArrayList<CdlDetailVO>();
	
	/* Column Info */
	private String cstmsDeclNo = null;
	/* Column Info */
	private String cgoTpCd = null;
	/* Column Info */
	private String tmlVvdId = null;
	/* Column Info */
	private String crrCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String trspModId = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String evntYdCd = null;
	/* Column Info */
	private String ediRptMsgRcvDt = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String eurTmlDmgId = null;
	/* Column Info */
	private String expDt = null;
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
	private String cntrTareWgt = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String mtchFlg = null;
	/* Column Info */
	private String cntrSealNo = null;
	/* Column Info */
	private String ediSndrId = null;
	/* Column Info */
	private String stwgCellNo = null;
	/* Column Info */
	private String cgoStsId = null;
	/* Column Info */
	private String grsWgt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CdlDetailVO() {}

	public CdlDetailVO(String ibflag, String pagerows, String ediSndrId, String evntYdCd, String tmlVvdId, String polCd, String podCd, String cntrNo, String coRptId, String callSgnNo, String vslNm, String bkgNo, String cntrSealNo, String cntrLdisDt, String stwgCellNo, String ediRptMsgRcvDt, String updDt, String crrCd, String cntrTpszCd, String cntrSealNo2, String cgoStsId, String n1stPodCd, String grsWgt, String cgoTpCd, String imdgClssId, String eurTmlDmgId, String trspModId, String orgYdCd, String expDt, String cstmsDeclNo, String cntrTareWgt, String mtchFlg) {
		this.cstmsDeclNo = cstmsDeclNo;
		this.cgoTpCd = cgoTpCd;
		this.tmlVvdId = tmlVvdId;
		this.crrCd = crrCd;
		this.pagerows = pagerows;
		this.trspModId = trspModId;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.evntYdCd = evntYdCd;
		this.ediRptMsgRcvDt = ediRptMsgRcvDt;
		this.cntrTpszCd = cntrTpszCd;
		this.eurTmlDmgId = eurTmlDmgId;
		this.expDt = expDt;
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
		this.cntrTareWgt = cntrTareWgt;
		this.cntrNo = cntrNo;
		this.mtchFlg = mtchFlg;
		this.cntrSealNo = cntrSealNo;
		this.ediSndrId = ediSndrId;
		this.stwgCellNo = stwgCellNo;
		this.cgoStsId = cgoStsId;
		this.grsWgt = grsWgt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cstms_decl_no", getCstmsDeclNo());
		this.hashColumns.put("cgo_tp_cd", getCgoTpCd());
		this.hashColumns.put("tml_vvd_id", getTmlVvdId());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("trsp_mod_id", getTrspModId());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("evnt_yd_cd", getEvntYdCd());
		this.hashColumns.put("edi_rpt_msg_rcv_dt", getEdiRptMsgRcvDt());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("eur_tml_dmg_id", getEurTmlDmgId());
		this.hashColumns.put("exp_dt", getExpDt());
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
		this.hashColumns.put("cntr_tare_wgt", getCntrTareWgt());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("mtch_flg", getMtchFlg());
		this.hashColumns.put("cntr_seal_no", getCntrSealNo());
		this.hashColumns.put("edi_sndr_id", getEdiSndrId());
		this.hashColumns.put("stwg_cell_no", getStwgCellNo());
		this.hashColumns.put("cgo_sts_id", getCgoStsId());
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
		this.hashFields.put("tml_vvd_id", "tmlVvdId");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("trsp_mod_id", "trspModId");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("evnt_yd_cd", "evntYdCd");
		this.hashFields.put("edi_rpt_msg_rcv_dt", "ediRptMsgRcvDt");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("eur_tml_dmg_id", "eurTmlDmgId");
		this.hashFields.put("exp_dt", "expDt");
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
		this.hashFields.put("cntr_tare_wgt", "cntrTareWgt");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("mtch_flg", "mtchFlg");
		this.hashFields.put("cntr_seal_no", "cntrSealNo");
		this.hashFields.put("edi_sndr_id", "ediSndrId");
		this.hashFields.put("stwg_cell_no", "stwgCellNo");
		this.hashFields.put("cgo_sts_id", "cgoStsId");
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
	 * @return tmlVvdId
	 */
	public String getTmlVvdId() {
		return this.tmlVvdId;
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
	 * @return trspModId
	 */
	public String getTrspModId() {
		return this.trspModId;
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
	 * @return evntYdCd
	 */
	public String getEvntYdCd() {
		return this.evntYdCd;
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
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
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
	 * @return mtchFlg
	 */
	public String getMtchFlg() {
		return this.mtchFlg;
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
	 * @return ediSndrId
	 */
	public String getEdiSndrId() {
		return this.ediSndrId;
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
	 * @param tmlVvdId
	 */
	public void setTmlVvdId(String tmlVvdId) {
		this.tmlVvdId = tmlVvdId;
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
	 * @param trspModId
	 */
	public void setTrspModId(String trspModId) {
		this.trspModId = trspModId;
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
	 * @param evntYdCd
	 */
	public void setEvntYdCd(String evntYdCd) {
		this.evntYdCd = evntYdCd;
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
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
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
	 * @param mtchFlg
	 */
	public void setMtchFlg(String mtchFlg) {
		this.mtchFlg = mtchFlg;
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
	 * @param ediSndrId
	 */
	public void setEdiSndrId(String ediSndrId) {
		this.ediSndrId = ediSndrId;
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
		setTmlVvdId(JSPUtil.getParameter(request, "tml_vvd_id", ""));
		setCrrCd(JSPUtil.getParameter(request, "crr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setTrspModId(JSPUtil.getParameter(request, "trsp_mod_id", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEvntYdCd(JSPUtil.getParameter(request, "evnt_yd_cd", ""));
		setEdiRptMsgRcvDt(JSPUtil.getParameter(request, "edi_rpt_msg_rcv_dt", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setEurTmlDmgId(JSPUtil.getParameter(request, "eur_tml_dmg_id", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
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
		setCntrTareWgt(JSPUtil.getParameter(request, "cntr_tare_wgt", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setMtchFlg(JSPUtil.getParameter(request, "mtch_flg", ""));
		setCntrSealNo(JSPUtil.getParameter(request, "cntr_seal_no", ""));
		setEdiSndrId(JSPUtil.getParameter(request, "edi_sndr_id", ""));
		setStwgCellNo(JSPUtil.getParameter(request, "stwg_cell_no", ""));
		setCgoStsId(JSPUtil.getParameter(request, "cgo_sts_id", ""));
		setGrsWgt(JSPUtil.getParameter(request, "grs_wgt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CdlDetailVO[]
	 */
	public CdlDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CdlDetailVO[]
	 */
	public CdlDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CdlDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cstmsDeclNo = (JSPUtil.getParameter(request, prefix	+ "cstms_decl_no", length));
			String[] cgoTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_tp_cd", length));
			String[] tmlVvdId = (JSPUtil.getParameter(request, prefix	+ "tml_vvd_id", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] trspModId = (JSPUtil.getParameter(request, prefix	+ "trsp_mod_id", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] evntYdCd = (JSPUtil.getParameter(request, prefix	+ "evnt_yd_cd", length));
			String[] ediRptMsgRcvDt = (JSPUtil.getParameter(request, prefix	+ "edi_rpt_msg_rcv_dt", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] eurTmlDmgId = (JSPUtil.getParameter(request, prefix	+ "eur_tml_dmg_id", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
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
			String[] cntrTareWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_tare_wgt", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] mtchFlg = (JSPUtil.getParameter(request, prefix	+ "mtch_flg", length));
			String[] cntrSealNo = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no", length));
			String[] ediSndrId = (JSPUtil.getParameter(request, prefix	+ "edi_sndr_id", length));
			String[] stwgCellNo = (JSPUtil.getParameter(request, prefix	+ "stwg_cell_no", length));
			String[] cgoStsId = (JSPUtil.getParameter(request, prefix	+ "cgo_sts_id", length));
			String[] grsWgt = (JSPUtil.getParameter(request, prefix	+ "grs_wgt", length));
			
			for (int i = 0; i < length; i++) {
				model = new CdlDetailVO();
				if (cstmsDeclNo[i] != null)
					model.setCstmsDeclNo(cstmsDeclNo[i]);
				if (cgoTpCd[i] != null)
					model.setCgoTpCd(cgoTpCd[i]);
				if (tmlVvdId[i] != null)
					model.setTmlVvdId(tmlVvdId[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (trspModId[i] != null)
					model.setTrspModId(trspModId[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (evntYdCd[i] != null)
					model.setEvntYdCd(evntYdCd[i]);
				if (ediRptMsgRcvDt[i] != null)
					model.setEdiRptMsgRcvDt(ediRptMsgRcvDt[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (eurTmlDmgId[i] != null)
					model.setEurTmlDmgId(eurTmlDmgId[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
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
				if (cntrTareWgt[i] != null)
					model.setCntrTareWgt(cntrTareWgt[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (mtchFlg[i] != null)
					model.setMtchFlg(mtchFlg[i]);
				if (cntrSealNo[i] != null)
					model.setCntrSealNo(cntrSealNo[i]);
				if (ediSndrId[i] != null)
					model.setEdiSndrId(ediSndrId[i]);
				if (stwgCellNo[i] != null)
					model.setStwgCellNo(stwgCellNo[i]);
				if (cgoStsId[i] != null)
					model.setCgoStsId(cgoStsId[i]);
				if (grsWgt[i] != null)
					model.setGrsWgt(grsWgt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCdlDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CdlDetailVO[]
	 */
	public CdlDetailVO[] getCdlDetailVOs(){
		CdlDetailVO[] vos = (CdlDetailVO[])models.toArray(new CdlDetailVO[models.size()]);
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
		this.cstmsDeclNo = this.cstmsDeclNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTpCd = this.cgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlVvdId = this.tmlVvdId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspModId = this.trspModId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntYdCd = this.evntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRptMsgRcvDt = this.ediRptMsgRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eurTmlDmgId = this.eurTmlDmgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
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
		this.cntrTareWgt = this.cntrTareWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtchFlg = this.mtchFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo = this.cntrSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndrId = this.ediSndrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwgCellNo = this.stwgCellNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoStsId = this.cgoStsId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgt = this.grsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
