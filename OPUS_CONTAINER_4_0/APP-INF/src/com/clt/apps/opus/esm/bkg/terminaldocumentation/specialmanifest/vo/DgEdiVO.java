/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DgEdiVO.java
*@FileTitle : DgEdiVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.26
*@LastModifier :
*@LastVersion : 1.0
* 2011.05.26
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo;

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

public class DgEdiVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<DgEdiVO> models = new ArrayList<DgEdiVO>();

	/* Column Info */
	private String brthYdCd = null;
	/* Column Info */
	private String svcRqstNo = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String reasonResending = null;
	/* Column Info */
	private String imdgUnNoSeq = null;
	/* Column Info */
	private String dcgoSeq = null;
	/* Column Info */
	private String outImdgPckQty1 = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String etaT = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String dType = null;
	/* Column Info */
	private String uiType = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Column Info */
	private String packages = null;
	/* Column Info */
	private String callSgnNo = null;
	/* Column Info */
	private String netWgt = null;
	/* Column Info */
	private String dgShortNm = null;
	/* Column Info */
	private String anrRoleDivCd = null;
	/* Column Info */
	private String agent = null;
	/* Column Info */
	private String cntrCgoSeq = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String transType = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String lloydNo = null;
	/* Column Info */
	private String ydNm = null;
	/* Column Info */
	private String hzdDesc = null;
	/* Column Info */
	private String imdgClssCd = null;
	/* Column Info */
	private String outImdgPckCd1 = null;
	/* Column Info */
	private String grsWgt = null;
	/* Column Info */
	private String imdgPckGrpCd = null;
	/* Column Info */
	private String flshPntCdoTemp = null;
	/* Column Info */
	private String sendType = null;
	/* Column Info */
	private String etdT = null;
	/* Column Info */
	private String emsNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String keyType = null;
	/* Column Info */
	private String localDbYn = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String scrFileNo = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String etdD = null;
	/* Column Info */
	private String vslCntCd = null;
	/* Column Info */
	private String dcgoMrnPolutCd = null;
	/* Column Info */
	private String dgCntrSeq = null;
	/* Column Info */
	private String cellPsnNo = null;
	/* Column Info */
	private String autoSndTpCd = null;
	/* Column Info */
	private String firstMsgSndNo = null;
	/* Column Info */
	private String cType = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String mergeBkgNo = null;
	/* Column Info */
	private String imdgSubsRskLblCd2 = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String imdgSubsRskLblCd1 = null;
	/* Column Info */
	private String ackRsltId = null;
	/* Column Info */
	private String prpShpNm = null;
	/* Column Info */
	private String msgSndNo = null;
	/* Column Info */
	private String imdgSubsRskLblCd4 = null;
	/* Column Info */
	private String fwrdId = null;
	/* Column Info */
	private String etaD = null;
	/* Column Info */
	private String crrDt = null;
	/* Column Info */
	private String imdgSubsRskLblCd3 = null;
	/* Column Info */
	private String imdgLmtQtyFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public DgEdiVO() {}

	public DgEdiVO(String ibflag, String pagerows, String brthYdCd, String svcRqstNo, String vslCd, String reasonResending, String imdgUnNoSeq, String dcgoSeq, String outImdgPckQty1, String blNo, String polCd, String etaT, String vvdCd, String dType, String uiType, String imdgUnNo, String updUsrId, String packages, String callSgnNo, String netWgt, String dgShortNm, String anrRoleDivCd, String agent, String cntrCgoSeq, String podCd, String transType, String bkgNo, String creUsrId, String lloydNo, String ydNm, String hzdDesc, String imdgClssCd, String outImdgPckCd1, String grsWgt, String imdgPckGrpCd, String flshPntCdoTemp, String sendType, String etdT, String emsNo, String keyType, String localDbYn, String vslEngNm, String usrId, String scrFileNo, String portCd, String etdD, String vslCntCd, String dcgoMrnPolutCd, String dgCntrSeq, String cellPsnNo, String autoSndTpCd, String firstMsgSndNo, String cType, String ofcCd, String mergeBkgNo, String cntrNo, String seq, String ackRsltId, String prpShpNm, String msgSndNo, String crrDt, String etaD, String fwrdId, String imdgLmtQtyFlg, String imdgSubsRskLblCd1, String imdgSubsRskLblCd2, String imdgSubsRskLblCd3, String imdgSubsRskLblCd4) {
		this.brthYdCd = brthYdCd;
		this.svcRqstNo = svcRqstNo;
		this.vslCd = vslCd;
		this.reasonResending = reasonResending;
		this.imdgUnNoSeq = imdgUnNoSeq;
		this.dcgoSeq = dcgoSeq;
		this.outImdgPckQty1 = outImdgPckQty1;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.etaT = etaT;
		this.vvdCd = vvdCd;
		this.dType = dType;
		this.uiType = uiType;
		this.updUsrId = updUsrId;
		this.imdgUnNo = imdgUnNo;
		this.packages = packages;
		this.callSgnNo = callSgnNo;
		this.netWgt = netWgt;
		this.dgShortNm = dgShortNm;
		this.anrRoleDivCd = anrRoleDivCd;
		this.agent = agent;
		this.cntrCgoSeq = cntrCgoSeq;
		this.podCd = podCd;
		this.transType = transType;
		this.bkgNo = bkgNo;
		this.creUsrId = creUsrId;
		this.lloydNo = lloydNo;
		this.ydNm = ydNm;
		this.hzdDesc = hzdDesc;
		this.imdgClssCd = imdgClssCd;
		this.outImdgPckCd1 = outImdgPckCd1;
		this.grsWgt = grsWgt;
		this.imdgPckGrpCd = imdgPckGrpCd;
		this.flshPntCdoTemp = flshPntCdoTemp;
		this.sendType = sendType;
		this.etdT = etdT;
		this.emsNo = emsNo;
		this.ibflag = ibflag;
		this.keyType = keyType;
		this.localDbYn = localDbYn;
		this.vslEngNm = vslEngNm;
		this.usrId = usrId;
		this.scrFileNo = scrFileNo;
		this.portCd = portCd;
		this.etdD = etdD;
		this.vslCntCd = vslCntCd;
		this.dcgoMrnPolutCd = dcgoMrnPolutCd;
		this.dgCntrSeq = dgCntrSeq;
		this.cellPsnNo = cellPsnNo;
		this.autoSndTpCd = autoSndTpCd;
		this.firstMsgSndNo = firstMsgSndNo;
		this.cType = cType;
		this.ofcCd = ofcCd;
		this.cntrNo = cntrNo;
		this.mergeBkgNo = mergeBkgNo;
		this.imdgSubsRskLblCd2 = imdgSubsRskLblCd2;
		this.seq = seq;
		this.imdgSubsRskLblCd1 = imdgSubsRskLblCd1;
		this.ackRsltId = ackRsltId;
		this.prpShpNm = prpShpNm;
		this.msgSndNo = msgSndNo;
		this.imdgSubsRskLblCd4 = imdgSubsRskLblCd4;
		this.fwrdId = fwrdId;
		this.etaD = etaD;
		this.crrDt = crrDt;
		this.imdgSubsRskLblCd3 = imdgSubsRskLblCd3;
		this.imdgLmtQtyFlg = imdgLmtQtyFlg;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("brth_yd_cd", getBrthYdCd());
		this.hashColumns.put("svc_rqst_no", getSvcRqstNo());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("reason_resending", getReasonResending());
		this.hashColumns.put("imdg_un_no_seq", getImdgUnNoSeq());
		this.hashColumns.put("dcgo_seq", getDcgoSeq());
		this.hashColumns.put("out_imdg_pck_qty1", getOutImdgPckQty1());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("eta_t", getEtaT());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("d_type", getDType());
		this.hashColumns.put("ui_type", getUiType());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("packages", getPackages());
		this.hashColumns.put("call_sgn_no", getCallSgnNo());
		this.hashColumns.put("net_wgt", getNetWgt());
		this.hashColumns.put("dg_short_nm", getDgShortNm());
		this.hashColumns.put("anr_role_div_cd", getAnrRoleDivCd());
		this.hashColumns.put("agent", getAgent());
		this.hashColumns.put("cntr_cgo_seq", getCntrCgoSeq());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("trans_type", getTransType());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("lloyd_no", getLloydNo());
		this.hashColumns.put("yd_nm", getYdNm());
		this.hashColumns.put("hzd_desc", getHzdDesc());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		this.hashColumns.put("out_imdg_pck_cd1", getOutImdgPckCd1());
		this.hashColumns.put("grs_wgt", getGrsWgt());
		this.hashColumns.put("imdg_pck_grp_cd", getImdgPckGrpCd());
		this.hashColumns.put("flsh_pnt_cdo_temp", getFlshPntCdoTemp());
		this.hashColumns.put("send_type", getSendType());
		this.hashColumns.put("etd_t", getEtdT());
		this.hashColumns.put("ems_no", getEmsNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("key_type", getKeyType());
		this.hashColumns.put("local_db_yn", getLocalDbYn());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("scr_file_no", getScrFileNo());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("etd_d", getEtdD());
		this.hashColumns.put("vsl_cnt_cd", getVslCntCd());
		this.hashColumns.put("dcgo_mrn_polut_cd", getDcgoMrnPolutCd());
		this.hashColumns.put("dg_cntr_seq", getDgCntrSeq());
		this.hashColumns.put("cell_psn_no", getCellPsnNo());
		this.hashColumns.put("auto_snd_tp_cd", getAutoSndTpCd());
		this.hashColumns.put("first_msg_snd_no", getFirstMsgSndNo());
		this.hashColumns.put("c_type", getCType());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("merge_bkg_no", getMergeBkgNo());
		this.hashColumns.put("imdg_subs_rsk_lbl_cd2", getImdgSubsRskLblCd2());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("imdg_subs_rsk_lbl_cd1", getImdgSubsRskLblCd1());
		this.hashColumns.put("ack_rslt_id", getAckRsltId());
		this.hashColumns.put("prp_shp_nm", getPrpShpNm());
		this.hashColumns.put("msg_snd_no", getMsgSndNo());
		this.hashColumns.put("imdg_subs_rsk_lbl_cd4", getImdgSubsRskLblCd4());
		this.hashColumns.put("fwrd_id", getFwrdId());
		this.hashColumns.put("eta_d", getEtaD());
		this.hashColumns.put("crr_dt", getCrrDt());
		this.hashColumns.put("imdg_subs_rsk_lbl_cd3", getImdgSubsRskLblCd3());
		this.hashColumns.put("imdg_lmt_qty_flg", getImdgLmtQtyFlg());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("brth_yd_cd", "brthYdCd");
		this.hashFields.put("svc_rqst_no", "svcRqstNo");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("reason_resending", "reasonResending");
		this.hashFields.put("imdg_un_no_seq", "imdgUnNoSeq");
		this.hashFields.put("dcgo_seq", "dcgoSeq");
		this.hashFields.put("out_imdg_pck_qty1", "outImdgPckQty1");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("eta_t", "etaT");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("d_type", "dType");
		this.hashFields.put("ui_type", "uiType");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("packages", "packages");
		this.hashFields.put("call_sgn_no", "callSgnNo");
		this.hashFields.put("net_wgt", "netWgt");
		this.hashFields.put("dg_short_nm", "dgShortNm");
		this.hashFields.put("anr_role_div_cd", "anrRoleDivCd");
		this.hashFields.put("agent", "agent");
		this.hashFields.put("cntr_cgo_seq", "cntrCgoSeq");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("trans_type", "transType");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("lloyd_no", "lloydNo");
		this.hashFields.put("yd_nm", "ydNm");
		this.hashFields.put("hzd_desc", "hzdDesc");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("out_imdg_pck_cd1", "outImdgPckCd1");
		this.hashFields.put("grs_wgt", "grsWgt");
		this.hashFields.put("imdg_pck_grp_cd", "imdgPckGrpCd");
		this.hashFields.put("flsh_pnt_cdo_temp", "flshPntCdoTemp");
		this.hashFields.put("send_type", "sendType");
		this.hashFields.put("etd_t", "etdT");
		this.hashFields.put("ems_no", "emsNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("key_type", "keyType");
		this.hashFields.put("local_db_yn", "localDbYn");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("scr_file_no", "scrFileNo");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("etd_d", "etdD");
		this.hashFields.put("vsl_cnt_cd", "vslCntCd");
		this.hashFields.put("dcgo_mrn_polut_cd", "dcgoMrnPolutCd");
		this.hashFields.put("dg_cntr_seq", "dgCntrSeq");
		this.hashFields.put("cell_psn_no", "cellPsnNo");
		this.hashFields.put("auto_snd_tp_cd", "autoSndTpCd");
		this.hashFields.put("first_msg_snd_no", "firstMsgSndNo");
		this.hashFields.put("c_type", "cType");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("merge_bkg_no", "mergeBkgNo");
		this.hashFields.put("imdg_subs_rsk_lbl_cd2", "imdgSubsRskLblCd2");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("imdg_subs_rsk_lbl_cd1", "imdgSubsRskLblCd1");
		this.hashFields.put("ack_rslt_id", "ackRsltId");
		this.hashFields.put("prp_shp_nm", "prpShpNm");
		this.hashFields.put("msg_snd_no", "msgSndNo");
		this.hashFields.put("imdg_subs_rsk_lbl_cd4", "imdgSubsRskLblCd4");
		this.hashFields.put("fwrd_id", "fwrdId");
		this.hashFields.put("eta_d", "etaD");
		this.hashFields.put("crr_dt", "crrDt");
		this.hashFields.put("imdg_subs_rsk_lbl_cd3", "imdgSubsRskLblCd3");
		this.hashFields.put("imdg_lmt_qty_flg", "imdgLmtQtyFlg");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return brthYdCd
	 */
	public String getBrthYdCd() {
		return this.brthYdCd;
	}

	/**
	 * Column Info
	 * @return svcRqstNo
	 */
	public String getSvcRqstNo() {
		return this.svcRqstNo;
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
	 * @return reasonResending
	 */
	public String getReasonResending() {
		return this.reasonResending;
	}

	/**
	 * Column Info
	 * @return imdgUnNoSeq
	 */
	public String getImdgUnNoSeq() {
		return this.imdgUnNoSeq;
	}

	/**
	 * Column Info
	 * @return dcgoSeq
	 */
	public String getDcgoSeq() {
		return this.dcgoSeq;
	}

	/**
	 * Column Info
	 * @return outImdgPckQty1
	 */
	public String getOutImdgPckQty1() {
		return this.outImdgPckQty1;
	}

	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}

	/**
	 * Column Info
	 * @return etaT
	 */
	public String getEtaT() {
		return this.etaT;
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
	 * @return dType
	 */
	public String getDType() {
		return this.dType;
	}

	/**
	 * Column Info
	 * @return uiType
	 */
	public String getUiType() {
		return this.uiType;
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
	 * @return imdgUnNo
	 */
	public String getImdgUnNo() {
		return this.imdgUnNo;
	}

	/**
	 * Column Info
	 * @return packages
	 */
	public String getPackages() {
		return this.packages;
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
	 * @return netWgt
	 */
	public String getNetWgt() {
		return this.netWgt;
	}

	/**
	 * Column Info
	 * @return dgShortNm
	 */
	public String getDgShortNm() {
		return this.dgShortNm;
	}

	/**
	 * Column Info
	 * @return anrRoleDivCd
	 */
	public String getAnrRoleDivCd() {
		return this.anrRoleDivCd;
	}

	/**
	 * Column Info
	 * @return agent
	 */
	public String getAgent() {
		return this.agent;
	}

	/**
	 * Column Info
	 * @return cntrCgoSeq
	 */
	public String getCntrCgoSeq() {
		return this.cntrCgoSeq;
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
	 * @return transType
	 */
	public String getTransType() {
		return this.transType;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}

	/**
	 * Column Info
	 * @return lloydNo
	 */
	public String getLloydNo() {
		return this.lloydNo;
	}

	/**
	 * Column Info
	 * @return ydNm
	 */
	public String getYdNm() {
		return this.ydNm;
	}

	/**
	 * Column Info
	 * @return hzdDesc
	 */
	public String getHzdDesc() {
		return this.hzdDesc;
	}

	/**
	 * Column Info
	 * @return imdgClssCd
	 */
	public String getImdgClssCd() {
		return this.imdgClssCd;
	}

	/**
	 * Column Info
	 * @return outImdgPckCd1
	 */
	public String getOutImdgPckCd1() {
		return this.outImdgPckCd1;
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
	 * @return imdgPckGrpCd
	 */
	public String getImdgPckGrpCd() {
		return this.imdgPckGrpCd;
	}

	/**
	 * Column Info
	 * @return flshPntCdoTemp
	 */
	public String getFlshPntCdoTemp() {
		return this.flshPntCdoTemp;
	}

	/**
	 * Column Info
	 * @return sendType
	 */
	public String getSendType() {
		return this.sendType;
	}

	/**
	 * Column Info
	 * @return etdT
	 */
	public String getEtdT() {
		return this.etdT;
	}

	/**
	 * Column Info
	 * @return emsNo
	 */
	public String getEmsNo() {
		return this.emsNo;
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
	 * @return keyType
	 */
	public String getKeyType() {
		return this.keyType;
	}

	/**
	 * Column Info
	 * @return localDbYn
	 */
	public String getLocalDbYn() {
		return this.localDbYn;
	}

	/**
	 * Column Info
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
	}

	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}

	/**
	 * Column Info
	 * @return scrFileNo
	 */
	public String getScrFileNo() {
		return this.scrFileNo;
	}

	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}

	/**
	 * Column Info
	 * @return etdD
	 */
	public String getEtdD() {
		return this.etdD;
	}

	/**
	 * Column Info
	 * @return vslCntCd
	 */
	public String getVslCntCd() {
		return this.vslCntCd;
	}

	/**
	 * Column Info
	 * @return dcgoMrnPolutCd
	 */
	public String getDcgoMrnPolutCd() {
		return this.dcgoMrnPolutCd;
	}

	/**
	 * Column Info
	 * @return dgCntrSeq
	 */
	public String getDgCntrSeq() {
		return this.dgCntrSeq;
	}

	/**
	 * Column Info
	 * @return cellPsnNo
	 */
	public String getCellPsnNo() {
		return this.cellPsnNo;
	}

	/**
	 * Column Info
	 * @return autoSndTpCd
	 */
	public String getAutoSndTpCd() {
		return this.autoSndTpCd;
	}

	/**
	 * Column Info
	 * @return firstMsgSndNo
	 */
	public String getFirstMsgSndNo() {
		return this.firstMsgSndNo;
	}

	/**
	 * Column Info
	 * @return cType
	 */
	public String getCType() {
		return this.cType;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}

	/**
	 * Column Info
	 * @return mergeBkgNo
	 */
	public String getMergeBkgNo() {
		return this.mergeBkgNo;
	}

	/**
	 * Column Info
	 * @return imdgSubsRskLblCd2
	 */
	public String getImdgSubsRskLblCd2() {
		return this.imdgSubsRskLblCd2;
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
	 * @return imdgSubsRskLblCd1
	 */
	public String getImdgSubsRskLblCd1() {
		return this.imdgSubsRskLblCd1;
	}

	/**
	 * Column Info
	 * @return ackRsltId
	 */
	public String getAckRsltId() {
		return this.ackRsltId;
	}

	/**
	 * Column Info
	 * @return prpShpNm
	 */
	public String getPrpShpNm() {
		return this.prpShpNm;
	}

	/**
	 * Column Info
	 * @return msgSndNo
	 */
	public String getMsgSndNo() {
		return this.msgSndNo;
	}

	/**
	 * Column Info
	 * @return imdgSubsRskLblCd4
	 */
	public String getImdgSubsRskLblCd4() {
		return this.imdgSubsRskLblCd4;
	}

	/**
	 * Column Info
	 * @return fwrdId
	 */
	public String getFwrdId() {
		return this.fwrdId;
	}

	/**
	 * Column Info
	 * @return etaD
	 */
	public String getEtaD() {
		return this.etaD;
	}

	/**
	 * Column Info
	 * @return crrDt
	 */
	public String getCrrDt() {
		return this.crrDt;
	}

	/**
	 * Column Info
	 * @return imdgSubsRskLblCd3
	 */
	public String getImdgSubsRskLblCd3() {
		return this.imdgSubsRskLblCd3;
	}

	/**
	 * Column Info
	 * @return imdgLmtQtyFlg
	 */
	public String getImdgLmtQtyFlg() {
		return this.imdgLmtQtyFlg;
	}


	/**
	 * Column Info
	 * @param brthYdCd
	 */
	public void setBrthYdCd(String brthYdCd) {
		this.brthYdCd = brthYdCd;
	}

	/**
	 * Column Info
	 * @param svcRqstNo
	 */
	public void setSvcRqstNo(String svcRqstNo) {
		this.svcRqstNo = svcRqstNo;
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
	 * @param reasonResending
	 */
	public void setReasonResending(String reasonResending) {
		this.reasonResending = reasonResending;
	}

	/**
	 * Column Info
	 * @param imdgUnNoSeq
	 */
	public void setImdgUnNoSeq(String imdgUnNoSeq) {
		this.imdgUnNoSeq = imdgUnNoSeq;
	}

	/**
	 * Column Info
	 * @param dcgoSeq
	 */
	public void setDcgoSeq(String dcgoSeq) {
		this.dcgoSeq = dcgoSeq;
	}

	/**
	 * Column Info
	 * @param outImdgPckQty1
	 */
	public void setOutImdgPckQty1(String outImdgPckQty1) {
		this.outImdgPckQty1 = outImdgPckQty1;
	}

	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}

	/**
	 * Column Info
	 * @param etaT
	 */
	public void setEtaT(String etaT) {
		this.etaT = etaT;
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
	 * @param dType
	 */
	public void setDType(String dType) {
		this.dType = dType;
	}

	/**
	 * Column Info
	 * @param uiType
	 */
	public void setUiType(String uiType) {
		this.uiType = uiType;
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
	 * @param imdgUnNo
	 */
	public void setImdgUnNo(String imdgUnNo) {
		this.imdgUnNo = imdgUnNo;
	}

	/**
	 * Column Info
	 * @param packages
	 */
	public void setPackages(String packages) {
		this.packages = packages;
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
	 * @param netWgt
	 */
	public void setNetWgt(String netWgt) {
		this.netWgt = netWgt;
	}

	/**
	 * Column Info
	 * @param dgShortNm
	 */
	public void setDgShortNm(String dgShortNm) {
		this.dgShortNm = dgShortNm;
	}

	/**
	 * Column Info
	 * @param anrRoleDivCd
	 */
	public void setAnrRoleDivCd(String anrRoleDivCd) {
		this.anrRoleDivCd = anrRoleDivCd;
	}

	/**
	 * Column Info
	 * @param agent
	 */
	public void setAgent(String agent) {
		this.agent = agent;
	}

	/**
	 * Column Info
	 * @param cntrCgoSeq
	 */
	public void setCntrCgoSeq(String cntrCgoSeq) {
		this.cntrCgoSeq = cntrCgoSeq;
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
	 * @param transType
	 */
	public void setTransType(String transType) {
		this.transType = transType;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	/**
	 * Column Info
	 * @param lloydNo
	 */
	public void setLloydNo(String lloydNo) {
		this.lloydNo = lloydNo;
	}

	/**
	 * Column Info
	 * @param ydNm
	 */
	public void setYdNm(String ydNm) {
		this.ydNm = ydNm;
	}

	/**
	 * Column Info
	 * @param hzdDesc
	 */
	public void setHzdDesc(String hzdDesc) {
		this.hzdDesc = hzdDesc;
	}

	/**
	 * Column Info
	 * @param imdgClssCd
	 */
	public void setImdgClssCd(String imdgClssCd) {
		this.imdgClssCd = imdgClssCd;
	}

	/**
	 * Column Info
	 * @param outImdgPckCd1
	 */
	public void setOutImdgPckCd1(String outImdgPckCd1) {
		this.outImdgPckCd1 = outImdgPckCd1;
	}

	/**
	 * Column Info
	 * @param grsWgt
	 */
	public void setGrsWgt(String grsWgt) {
		this.grsWgt = grsWgt;
	}

	/**
	 * Column Info
	 * @param imdgPckGrpCd
	 */
	public void setImdgPckGrpCd(String imdgPckGrpCd) {
		this.imdgPckGrpCd = imdgPckGrpCd;
	}

	/**
	 * Column Info
	 * @param flshPntCdoTemp
	 */
	public void setFlshPntCdoTemp(String flshPntCdoTemp) {
		this.flshPntCdoTemp = flshPntCdoTemp;
	}

	/**
	 * Column Info
	 * @param sendType
	 */
	public void setSendType(String sendType) {
		this.sendType = sendType;
	}

	/**
	 * Column Info
	 * @param etdT
	 */
	public void setEtdT(String etdT) {
		this.etdT = etdT;
	}

	/**
	 * Column Info
	 * @param emsNo
	 */
	public void setEmsNo(String emsNo) {
		this.emsNo = emsNo;
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
	 * @param keyType
	 */
	public void setKeyType(String keyType) {
		this.keyType = keyType;
	}

	/**
	 * Column Info
	 * @param localDbYn
	 */
	public void setLocalDbYn(String localDbYn) {
		this.localDbYn = localDbYn;
	}

	/**
	 * Column Info
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}

	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	/**
	 * Column Info
	 * @param scrFileNo
	 */
	public void setScrFileNo(String scrFileNo) {
		this.scrFileNo = scrFileNo;
	}

	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}

	/**
	 * Column Info
	 * @param etdD
	 */
	public void setEtdD(String etdD) {
		this.etdD = etdD;
	}

	/**
	 * Column Info
	 * @param vslCntCd
	 */
	public void setVslCntCd(String vslCntCd) {
		this.vslCntCd = vslCntCd;
	}

	/**
	 * Column Info
	 * @param dcgoMrnPolutCd
	 */
	public void setDcgoMrnPolutCd(String dcgoMrnPolutCd) {
		this.dcgoMrnPolutCd = dcgoMrnPolutCd;
	}

	/**
	 * Column Info
	 * @param dgCntrSeq
	 */
	public void setDgCntrSeq(String dgCntrSeq) {
		this.dgCntrSeq = dgCntrSeq;
	}

	/**
	 * Column Info
	 * @param cellPsnNo
	 */
	public void setCellPsnNo(String cellPsnNo) {
		this.cellPsnNo = cellPsnNo;
	}

	/**
	 * Column Info
	 * @param autoSndTpCd
	 */
	public void setAutoSndTpCd(String autoSndTpCd) {
		this.autoSndTpCd = autoSndTpCd;
	}

	/**
	 * Column Info
	 * @param firstMsgSndNo
	 */
	public void setFirstMsgSndNo(String firstMsgSndNo) {
		this.firstMsgSndNo = firstMsgSndNo;
	}

	/**
	 * Column Info
	 * @param cType
	 */
	public void setCType(String cType) {
		this.cType = cType;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	/**
	 * Column Info
	 * @param mergeBkgNo
	 */
	public void setMergeBkgNo(String mergeBkgNo) {
		this.mergeBkgNo = mergeBkgNo;
	}

	/**
	 * Column Info
	 * @param imdgSubsRskLblCd2
	 */
	public void setImdgSubsRskLblCd2(String imdgSubsRskLblCd2) {
		this.imdgSubsRskLblCd2 = imdgSubsRskLblCd2;
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
	 * @param imdgSubsRskLblCd1
	 */
	public void setImdgSubsRskLblCd1(String imdgSubsRskLblCd1) {
		this.imdgSubsRskLblCd1 = imdgSubsRskLblCd1;
	}

	/**
	 * Column Info
	 * @param ackRsltId
	 */
	public void setAckRsltId(String ackRsltId) {
		this.ackRsltId = ackRsltId;
	}

	/**
	 * Column Info
	 * @param prpShpNm
	 */
	public void setPrpShpNm(String prpShpNm) {
		this.prpShpNm = prpShpNm;
	}

	/**
	 * Column Info
	 * @param msgSndNo
	 */
	public void setMsgSndNo(String msgSndNo) {
		this.msgSndNo = msgSndNo;
	}

	/**
	 * Column Info
	 * @param imdgSubsRskLblCd4
	 */
	public void setImdgSubsRskLblCd4(String imdgSubsRskLblCd4) {
		this.imdgSubsRskLblCd4 = imdgSubsRskLblCd4;
	}

	/**
	 * Column Info
	 * @param fwrdId
	 */
	public void setFwrdId(String fwrdId) {
		this.fwrdId = fwrdId;
	}

	/**
	 * Column Info
	 * @param etaD
	 */
	public void setEtaD(String etaD) {
		this.etaD = etaD;
	}

	/**
	 * Column Info
	 * @param crrDt
	 */
	public void setCrrDt(String crrDt) {
		this.crrDt = crrDt;
	}

	/**
	 * Column Info
	 * @param imdgSubsRskLblCd3
	 */
	public void setImdgSubsRskLblCd3(String imdgSubsRskLblCd3) {
		this.imdgSubsRskLblCd3 = imdgSubsRskLblCd3;
	}

	/**
	 * Column Info
	 * @param imdgLmtQtyFlg
	 */
	public void setImdgLmtQtyFlg(String imdgLmtQtyFlg) {
		this.imdgLmtQtyFlg = imdgLmtQtyFlg;
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
		setBrthYdCd(JSPUtil.getParameter(request, prefix + "brth_yd_cd", ""));
		setSvcRqstNo(JSPUtil.getParameter(request, prefix + "svc_rqst_no", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setReasonResending(JSPUtil.getParameter(request, prefix + "reason_resending", ""));
		setImdgUnNoSeq(JSPUtil.getParameter(request, prefix + "imdg_un_no_seq", ""));
		setDcgoSeq(JSPUtil.getParameter(request, prefix + "dcgo_seq", ""));
		setOutImdgPckQty1(JSPUtil.getParameter(request, prefix + "out_imdg_pck_qty1", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setEtaT(JSPUtil.getParameter(request, prefix + "eta_t", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setDType(JSPUtil.getParameter(request, prefix + "d_type", ""));
		setUiType(JSPUtil.getParameter(request, prefix + "ui_type", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setImdgUnNo(JSPUtil.getParameter(request, prefix + "imdg_un_no", ""));
		setPackages(JSPUtil.getParameter(request, prefix + "packages", ""));
		setCallSgnNo(JSPUtil.getParameter(request, prefix + "call_sgn_no", ""));
		setNetWgt(JSPUtil.getParameter(request, prefix + "net_wgt", ""));
		setDgShortNm(JSPUtil.getParameter(request, prefix + "dg_short_nm", ""));
		setAnrRoleDivCd(JSPUtil.getParameter(request, prefix + "anr_role_div_cd", ""));
		setAgent(JSPUtil.getParameter(request, prefix + "agent", ""));
		setCntrCgoSeq(JSPUtil.getParameter(request, prefix + "cntr_cgo_seq", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setTransType(JSPUtil.getParameter(request, prefix + "trans_type", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setLloydNo(JSPUtil.getParameter(request, prefix + "lloyd_no", ""));
		setYdNm(JSPUtil.getParameter(request, prefix + "yd_nm", ""));
		setHzdDesc(JSPUtil.getParameter(request, prefix + "hzd_desc", ""));
		setImdgClssCd(JSPUtil.getParameter(request, prefix + "imdg_clss_cd", ""));
		setOutImdgPckCd1(JSPUtil.getParameter(request, prefix + "out_imdg_pck_cd1", ""));
		setGrsWgt(JSPUtil.getParameter(request, prefix + "grs_wgt", ""));
		setImdgPckGrpCd(JSPUtil.getParameter(request, prefix + "imdg_pck_grp_cd", ""));
		setFlshPntCdoTemp(JSPUtil.getParameter(request, prefix + "flsh_pnt_cdo_temp", ""));
		setSendType(JSPUtil.getParameter(request, prefix + "send_type", ""));
		setEtdT(JSPUtil.getParameter(request, prefix + "etd_t", ""));
		setEmsNo(JSPUtil.getParameter(request, prefix + "ems_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setKeyType(JSPUtil.getParameter(request, prefix + "key_type", ""));
		setLocalDbYn(JSPUtil.getParameter(request, prefix + "local_db_yn", ""));
		setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setScrFileNo(JSPUtil.getParameter(request, prefix + "scr_file_no", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setEtdD(JSPUtil.getParameter(request, prefix + "etd_d", ""));
		setVslCntCd(JSPUtil.getParameter(request, prefix + "vsl_cnt_cd", ""));
		setDcgoMrnPolutCd(JSPUtil.getParameter(request, prefix + "dcgo_mrn_polut_cd", ""));
		setDgCntrSeq(JSPUtil.getParameter(request, prefix + "dg_cntr_seq", ""));
		setCellPsnNo(JSPUtil.getParameter(request, prefix + "cell_psn_no", ""));
		setAutoSndTpCd(JSPUtil.getParameter(request, prefix + "auto_snd_tp_cd", ""));
		setFirstMsgSndNo(JSPUtil.getParameter(request, prefix + "first_msg_snd_no", ""));
		setCType(JSPUtil.getParameter(request, prefix + "c_type", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setMergeBkgNo(JSPUtil.getParameter(request, prefix + "merge_bkg_no", ""));
		setImdgSubsRskLblCd2(JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_cd2", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setImdgSubsRskLblCd1(JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_cd1", ""));
		setAckRsltId(JSPUtil.getParameter(request, prefix + "ack_rslt_id", ""));
		setPrpShpNm(JSPUtil.getParameter(request, prefix + "prp_shp_nm", ""));
		setMsgSndNo(JSPUtil.getParameter(request, prefix + "msg_snd_no", ""));
		setImdgSubsRskLblCd4(JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_cd4", ""));
		setFwrdId(JSPUtil.getParameter(request, prefix + "fwrd_id", ""));
		setEtaD(JSPUtil.getParameter(request, prefix + "eta_d", ""));
		setCrrDt(JSPUtil.getParameter(request, prefix + "crr_dt", ""));
		setImdgSubsRskLblCd3(JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_cd3", ""));
		setImdgLmtQtyFlg(JSPUtil.getParameter(request, prefix + "imdg_lmt_qty_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DgEdiVO[]
	 */
	public DgEdiVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return DgEdiVO[]
	 */
	public DgEdiVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DgEdiVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] brthYdCd = (JSPUtil.getParameter(request, prefix	+ "brth_yd_cd", length));
			String[] svcRqstNo = (JSPUtil.getParameter(request, prefix	+ "svc_rqst_no", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] reasonResending = (JSPUtil.getParameter(request, prefix	+ "reason_resending", length));
			String[] imdgUnNoSeq = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no_seq", length));
			String[] dcgoSeq = (JSPUtil.getParameter(request, prefix	+ "dcgo_seq", length));
			String[] outImdgPckQty1 = (JSPUtil.getParameter(request, prefix	+ "out_imdg_pck_qty1", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] etaT = (JSPUtil.getParameter(request, prefix	+ "eta_t", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] dType = (JSPUtil.getParameter(request, prefix	+ "d_type", length));
			String[] uiType = (JSPUtil.getParameter(request, prefix	+ "ui_type", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			String[] packages = (JSPUtil.getParameter(request, prefix	+ "packages", length));
			String[] callSgnNo = (JSPUtil.getParameter(request, prefix	+ "call_sgn_no", length));
			String[] netWgt = (JSPUtil.getParameter(request, prefix	+ "net_wgt", length));
			String[] dgShortNm = (JSPUtil.getParameter(request, prefix	+ "dg_short_nm", length));
			String[] anrRoleDivCd = (JSPUtil.getParameter(request, prefix	+ "anr_role_div_cd", length));
			String[] agent = (JSPUtil.getParameter(request, prefix	+ "agent", length));
			String[] cntrCgoSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_cgo_seq", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] transType = (JSPUtil.getParameter(request, prefix	+ "trans_type", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] lloydNo = (JSPUtil.getParameter(request, prefix	+ "lloyd_no", length));
			String[] ydNm = (JSPUtil.getParameter(request, prefix	+ "yd_nm", length));
			String[] hzdDesc = (JSPUtil.getParameter(request, prefix	+ "hzd_desc", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			String[] outImdgPckCd1 = (JSPUtil.getParameter(request, prefix	+ "out_imdg_pck_cd1", length));
			String[] grsWgt = (JSPUtil.getParameter(request, prefix	+ "grs_wgt", length));
			String[] imdgPckGrpCd = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_grp_cd", length));
			String[] flshPntCdoTemp = (JSPUtil.getParameter(request, prefix	+ "flsh_pnt_cdo_temp", length));
			String[] sendType = (JSPUtil.getParameter(request, prefix	+ "send_type", length));
			String[] etdT = (JSPUtil.getParameter(request, prefix	+ "etd_t", length));
			String[] emsNo = (JSPUtil.getParameter(request, prefix	+ "ems_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] keyType = (JSPUtil.getParameter(request, prefix	+ "key_type", length));
			String[] localDbYn = (JSPUtil.getParameter(request, prefix	+ "local_db_yn", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] scrFileNo = (JSPUtil.getParameter(request, prefix	+ "scr_file_no", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] etdD = (JSPUtil.getParameter(request, prefix	+ "etd_d", length));
			String[] vslCntCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cnt_cd", length));
			String[] dcgoMrnPolutCd = (JSPUtil.getParameter(request, prefix	+ "dcgo_mrn_polut_cd", length));
			String[] dgCntrSeq = (JSPUtil.getParameter(request, prefix	+ "dg_cntr_seq", length));
			String[] cellPsnNo = (JSPUtil.getParameter(request, prefix	+ "cell_psn_no", length));
			String[] autoSndTpCd = (JSPUtil.getParameter(request, prefix	+ "auto_snd_tp_cd", length));
			String[] firstMsgSndNo = (JSPUtil.getParameter(request, prefix	+ "first_msg_snd_no", length));
			String[] cType = (JSPUtil.getParameter(request, prefix	+ "c_type", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] mergeBkgNo = (JSPUtil.getParameter(request, prefix	+ "merge_bkg_no", length));
			String[] imdgSubsRskLblCd2 = (JSPUtil.getParameter(request, prefix	+ "imdg_subs_rsk_lbl_cd2", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] imdgSubsRskLblCd1 = (JSPUtil.getParameter(request, prefix	+ "imdg_subs_rsk_lbl_cd1", length));
			String[] ackRsltId = (JSPUtil.getParameter(request, prefix	+ "ack_rslt_id", length));
			String[] prpShpNm = (JSPUtil.getParameter(request, prefix	+ "prp_shp_nm", length));
			String[] msgSndNo = (JSPUtil.getParameter(request, prefix	+ "msg_snd_no", length));
			String[] imdgSubsRskLblCd4 = (JSPUtil.getParameter(request, prefix	+ "imdg_subs_rsk_lbl_cd4", length));
			String[] fwrdId = (JSPUtil.getParameter(request, prefix	+ "fwrd_id", length));
			String[] etaD = (JSPUtil.getParameter(request, prefix	+ "eta_d", length));
			String[] crrDt = (JSPUtil.getParameter(request, prefix	+ "crr_dt", length));
			String[] imdgSubsRskLblCd3 = (JSPUtil.getParameter(request, prefix	+ "imdg_subs_rsk_lbl_cd3", length));
			String[] imdgLmtQtyFlg = (JSPUtil.getParameter(request, prefix	+ "imdg_lmt_qty_flg", length));

			for (int i = 0; i < length; i++) {
				model = new DgEdiVO();
				if (brthYdCd[i] != null)
					model.setBrthYdCd(brthYdCd[i]);
				if (svcRqstNo[i] != null)
					model.setSvcRqstNo(svcRqstNo[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (reasonResending[i] != null)
					model.setReasonResending(reasonResending[i]);
				if (imdgUnNoSeq[i] != null)
					model.setImdgUnNoSeq(imdgUnNoSeq[i]);
				if (dcgoSeq[i] != null)
					model.setDcgoSeq(dcgoSeq[i]);
				if (outImdgPckQty1[i] != null)
					model.setOutImdgPckQty1(outImdgPckQty1[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (etaT[i] != null)
					model.setEtaT(etaT[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (dType[i] != null)
					model.setDType(dType[i]);
				if (uiType[i] != null)
					model.setUiType(uiType[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (packages[i] != null)
					model.setPackages(packages[i]);
				if (callSgnNo[i] != null)
					model.setCallSgnNo(callSgnNo[i]);
				if (netWgt[i] != null)
					model.setNetWgt(netWgt[i]);
				if (dgShortNm[i] != null)
					model.setDgShortNm(dgShortNm[i]);
				if (anrRoleDivCd[i] != null)
					model.setAnrRoleDivCd(anrRoleDivCd[i]);
				if (agent[i] != null)
					model.setAgent(agent[i]);
				if (cntrCgoSeq[i] != null)
					model.setCntrCgoSeq(cntrCgoSeq[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (transType[i] != null)
					model.setTransType(transType[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (lloydNo[i] != null)
					model.setLloydNo(lloydNo[i]);
				if (ydNm[i] != null)
					model.setYdNm(ydNm[i]);
				if (hzdDesc[i] != null)
					model.setHzdDesc(hzdDesc[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				if (outImdgPckCd1[i] != null)
					model.setOutImdgPckCd1(outImdgPckCd1[i]);
				if (grsWgt[i] != null)
					model.setGrsWgt(grsWgt[i]);
				if (imdgPckGrpCd[i] != null)
					model.setImdgPckGrpCd(imdgPckGrpCd[i]);
				if (flshPntCdoTemp[i] != null)
					model.setFlshPntCdoTemp(flshPntCdoTemp[i]);
				if (sendType[i] != null)
					model.setSendType(sendType[i]);
				if (etdT[i] != null)
					model.setEtdT(etdT[i]);
				if (emsNo[i] != null)
					model.setEmsNo(emsNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (keyType[i] != null)
					model.setKeyType(keyType[i]);
				if (localDbYn[i] != null)
					model.setLocalDbYn(localDbYn[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (scrFileNo[i] != null)
					model.setScrFileNo(scrFileNo[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (etdD[i] != null)
					model.setEtdD(etdD[i]);
				if (vslCntCd[i] != null)
					model.setVslCntCd(vslCntCd[i]);
				if (dcgoMrnPolutCd[i] != null)
					model.setDcgoMrnPolutCd(dcgoMrnPolutCd[i]);
				if (dgCntrSeq[i] != null)
					model.setDgCntrSeq(dgCntrSeq[i]);
				if (cellPsnNo[i] != null)
					model.setCellPsnNo(cellPsnNo[i]);
				if (autoSndTpCd[i] != null)
					model.setAutoSndTpCd(autoSndTpCd[i]);
				if (firstMsgSndNo[i] != null)
					model.setFirstMsgSndNo(firstMsgSndNo[i]);
				if (cType[i] != null)
					model.setCType(cType[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (mergeBkgNo[i] != null)
					model.setMergeBkgNo(mergeBkgNo[i]);
				if (imdgSubsRskLblCd2[i] != null)
					model.setImdgSubsRskLblCd2(imdgSubsRskLblCd2[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (imdgSubsRskLblCd1[i] != null)
					model.setImdgSubsRskLblCd1(imdgSubsRskLblCd1[i]);
				if (ackRsltId[i] != null)
					model.setAckRsltId(ackRsltId[i]);
				if (prpShpNm[i] != null)
					model.setPrpShpNm(prpShpNm[i]);
				if (msgSndNo[i] != null)
					model.setMsgSndNo(msgSndNo[i]);
				if (imdgSubsRskLblCd4[i] != null)
					model.setImdgSubsRskLblCd4(imdgSubsRskLblCd4[i]);
				if (fwrdId[i] != null)
					model.setFwrdId(fwrdId[i]);
				if (etaD[i] != null)
					model.setEtaD(etaD[i]);
				if (crrDt[i] != null)
					model.setCrrDt(crrDt[i]);
				if (imdgSubsRskLblCd3[i] != null)
					model.setImdgSubsRskLblCd3(imdgSubsRskLblCd3[i]);
				if (imdgLmtQtyFlg[i] != null)
					model.setImdgLmtQtyFlg(imdgLmtQtyFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDgEdiVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DgEdiVO[]
	 */
	public DgEdiVO[] getDgEdiVOs(){
		DgEdiVO[] vos = (DgEdiVO[])models.toArray(new DgEdiVO[models.size()]);
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
		this.brthYdCd = this.brthYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcRqstNo = this.svcRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reasonResending = this.reasonResending .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNoSeq = this.imdgUnNoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoSeq = this.dcgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outImdgPckQty1 = this.outImdgPckQty1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaT = this.etaT .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dType = this.dType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uiType = this.uiType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.packages = this.packages .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSgnNo = this.callSgnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netWgt = this.netWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgShortNm = this.dgShortNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anrRoleDivCd = this.anrRoleDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agent = this.agent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCgoSeq = this.cntrCgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transType = this.transType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lloydNo = this.lloydNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydNm = this.ydNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hzdDesc = this.hzdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outImdgPckCd1 = this.outImdgPckCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgt = this.grsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckGrpCd = this.imdgPckGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flshPntCdoTemp = this.flshPntCdoTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sendType = this.sendType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdT = this.etdT .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emsNo = this.emsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keyType = this.keyType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.localDbYn = this.localDbYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scrFileNo = this.scrFileNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdD = this.etdD .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCntCd = this.vslCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoMrnPolutCd = this.dcgoMrnPolutCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgCntrSeq = this.dgCntrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cellPsnNo = this.cellPsnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoSndTpCd = this.autoSndTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.firstMsgSndNo = this.firstMsgSndNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cType = this.cType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mergeBkgNo = this.mergeBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSubsRskLblCd2 = this.imdgSubsRskLblCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSubsRskLblCd1 = this.imdgSubsRskLblCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackRsltId = this.ackRsltId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prpShpNm = this.prpShpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgSndNo = this.msgSndNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSubsRskLblCd4 = this.imdgSubsRskLblCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fwrdId = this.fwrdId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaD = this.etaD .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrDt = this.crrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSubsRskLblCd3 = this.imdgSubsRskLblCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgLmtQtyFlg = this.imdgLmtQtyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
