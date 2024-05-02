/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PsaDGRcvMsgVO.java
*@FileTitle : PsaDGRcvMsgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.22
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2011.11.22 박성진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.vo;

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
 * @author 박성진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PsaDGRcvMsgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PsaDGRcvMsgVO> models = new ArrayList<PsaDGRcvMsgVO>();
	
	/* Column Info */
	private String ibVvdCd = null;
	/* Column Info */
	private String ttlPckTpNm = null;
	/* Column Info */
	private String cstmsErrId = null;
	/* Column Info */
	private String msgRcvNo = null;
	/* Column Info */
	private String dgTtlWgt = null;
	/* Column Info */
	private String rcvLogErrSeq = null;
	/* Column Info */
	private String orgMsgCntr = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String orgMsgNm = null;
	/* Column Info */
	private String msgApproveDt = null;
	/* Column Info */
	private String psaEdiMsgTpId = null;
	/* Column Info */
	private String secFileNbr = null;
	/* Column Info */
	private String rcvLogSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Column Info */
	private String msgAckTp = null;
	/* Column Info */
	private String msgPhone = null;
	/* Column Info */
	private String msgUdtFlg = null;
	/* Column Info */
	private String msgRErrorCode = null;
	/* Column Info */
	private String cstmsErrMsg = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String imoNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String msgRRef1 = null;
	/* Column Info */
	private String orgMsgTp = null;
	/* Column Info */
	private String cntrTtlErrKnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String errCntrStsCd = null;
	/* Column Info */
	private String msgRRef2 = null;
	/* Column Info */
	private String msgAckDt = null;
	/* Column Info */
	private String orgMsgBl = null;
	/* Column Info */
	private String flshPntTempCtnt = null;
	/* Column Info */
	private String ttlPckQty = null;
	/* Column Info */
	private String cntrTtlScsKnt = null;
	/* Column Info */
	private String msgRErrorMsg = null;
	/* Column Info */
	private String keyVal = null;
	/* Column Info */
	private String cstmsErrRefNo2 = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String cntrTtlKnt = null;
	/* Column Info */
	private String msgTpId = null;
	/* Column Info */
	private String cstmsErrRefNo1 = null;
	/* Column Info */
	private String psaVslName = null;
	/* Column Info */
	private String tnkCntrTpszFlg = null;
	/* Column Info */
	private String msgAcceptRef = null;
	/* Column Info */
	private String msgFax = null;
	/* Column Info */
	private String msgAckRslt = null;
	/* Column Info */
	private String cntrHndlKndCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String obVvdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PsaDGRcvMsgVO() {}

	public PsaDGRcvMsgVO(String ibflag, String pagerows, String keyVal, String rcvLogSeq, String orgMsgTp, String msgUdtFlg, String orgMsgNm, String msgAckTp, String msgAckRslt, String msgAckDt, String msgApproveDt, String msgPhone, String msgFax, String orgMsgCntr, String orgMsgBl, String msgRErrorCode, String msgRErrorMsg, String msgRRef1, String msgRRef2, String secFileNbr, String msgAcceptRef, String creUsrId, String updUsrId, String msgTpId, String psaEdiMsgTpId, String msgRcvNo, String rcvLogErrSeq, String cstmsErrId, String cstmsErrMsg, String cstmsErrRefNo1, String cstmsErrRefNo2, String creDt, String updDt, String psaVslName, String ibVvdCd, String obVvdCd, String cntrNo, String cntrHndlKndCd, String errCntrStsCd, String tnkCntrTpszFlg, String ttlPckQty, String ttlPckTpNm, String dgTtlWgt, String imoNo, String imdgUnNo, String cntrTtlKnt, String cntrTtlErrKnt, String cntrTtlScsKnt, String flshPntTempCtnt) {
		this.ibVvdCd = ibVvdCd;
		this.ttlPckTpNm = ttlPckTpNm;
		this.cstmsErrId = cstmsErrId;
		this.msgRcvNo = msgRcvNo;
		this.dgTtlWgt = dgTtlWgt;
		this.rcvLogErrSeq = rcvLogErrSeq;
		this.orgMsgCntr = orgMsgCntr;
		this.pagerows = pagerows;
		this.orgMsgNm = orgMsgNm;
		this.msgApproveDt = msgApproveDt;
		this.psaEdiMsgTpId = psaEdiMsgTpId;
		this.secFileNbr = secFileNbr;
		this.rcvLogSeq = rcvLogSeq;
		this.updUsrId = updUsrId;
		this.imdgUnNo = imdgUnNo;
		this.msgAckTp = msgAckTp;
		this.msgPhone = msgPhone;
		this.msgUdtFlg = msgUdtFlg;
		this.msgRErrorCode = msgRErrorCode;
		this.cstmsErrMsg = cstmsErrMsg;
		this.creUsrId = creUsrId;
		this.imoNo = imoNo;
		this.creDt = creDt;
		this.msgRRef1 = msgRRef1;
		this.orgMsgTp = orgMsgTp;
		this.cntrTtlErrKnt = cntrTtlErrKnt;
		this.ibflag = ibflag;
		this.errCntrStsCd = errCntrStsCd;
		this.msgRRef2 = msgRRef2;
		this.msgAckDt = msgAckDt;
		this.orgMsgBl = orgMsgBl;
		this.flshPntTempCtnt = flshPntTempCtnt;
		this.ttlPckQty = ttlPckQty;
		this.cntrTtlScsKnt = cntrTtlScsKnt;
		this.msgRErrorMsg = msgRErrorMsg;
		this.keyVal = keyVal;
		this.cstmsErrRefNo2 = cstmsErrRefNo2;
		this.updDt = updDt;
		this.cntrTtlKnt = cntrTtlKnt;
		this.msgTpId = msgTpId;
		this.cstmsErrRefNo1 = cstmsErrRefNo1;
		this.psaVslName = psaVslName;
		this.tnkCntrTpszFlg = tnkCntrTpszFlg;
		this.msgAcceptRef = msgAcceptRef;
		this.msgFax = msgFax;
		this.msgAckRslt = msgAckRslt;
		this.cntrHndlKndCd = cntrHndlKndCd;
		this.cntrNo = cntrNo;
		this.obVvdCd = obVvdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ib_vvd_cd", getIbVvdCd());
		this.hashColumns.put("ttl_pck_tp_nm", getTtlPckTpNm());
		this.hashColumns.put("cstms_err_id", getCstmsErrId());
		this.hashColumns.put("msg_rcv_no", getMsgRcvNo());
		this.hashColumns.put("dg_ttl_wgt", getDgTtlWgt());
		this.hashColumns.put("rcv_log_err_seq", getRcvLogErrSeq());
		this.hashColumns.put("org_msg_cntr", getOrgMsgCntr());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("org_msg_nm", getOrgMsgNm());
		this.hashColumns.put("msg_approve_dt", getMsgApproveDt());
		this.hashColumns.put("psa_edi_msg_tp_id", getPsaEdiMsgTpId());
		this.hashColumns.put("sec_file_nbr", getSecFileNbr());
		this.hashColumns.put("rcv_log_seq", getRcvLogSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("msg_ack_tp", getMsgAckTp());
		this.hashColumns.put("msg_phone", getMsgPhone());
		this.hashColumns.put("msg_udt_flg", getMsgUdtFlg());
		this.hashColumns.put("msg_r_error_code", getMsgRErrorCode());
		this.hashColumns.put("cstms_err_msg", getCstmsErrMsg());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("imo_no", getImoNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("msg_r_ref1", getMsgRRef1());
		this.hashColumns.put("org_msg_tp", getOrgMsgTp());
		this.hashColumns.put("cntr_ttl_err_knt", getCntrTtlErrKnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("err_cntr_sts_cd", getErrCntrStsCd());
		this.hashColumns.put("msg_r_ref2", getMsgRRef2());
		this.hashColumns.put("msg_ack_dt", getMsgAckDt());
		this.hashColumns.put("org_msg_bl", getOrgMsgBl());
		this.hashColumns.put("flsh_pnt_temp_ctnt", getFlshPntTempCtnt());
		this.hashColumns.put("ttl_pck_qty", getTtlPckQty());
		this.hashColumns.put("cntr_ttl_scs_knt", getCntrTtlScsKnt());
		this.hashColumns.put("msg_r_error_msg", getMsgRErrorMsg());
		this.hashColumns.put("key_val", getKeyVal());
		this.hashColumns.put("cstms_err_ref_no2", getCstmsErrRefNo2());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cntr_ttl_knt", getCntrTtlKnt());
		this.hashColumns.put("msg_tp_id", getMsgTpId());
		this.hashColumns.put("cstms_err_ref_no1", getCstmsErrRefNo1());
		this.hashColumns.put("psa_vsl_name", getPsaVslName());
		this.hashColumns.put("tnk_cntr_tpsz_flg", getTnkCntrTpszFlg());
		this.hashColumns.put("msg_accept_ref", getMsgAcceptRef());
		this.hashColumns.put("msg_fax", getMsgFax());
		this.hashColumns.put("msg_ack_rslt", getMsgAckRslt());
		this.hashColumns.put("cntr_hndl_knd_cd", getCntrHndlKndCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("ob_vvd_cd", getObVvdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ib_vvd_cd", "ibVvdCd");
		this.hashFields.put("ttl_pck_tp_nm", "ttlPckTpNm");
		this.hashFields.put("cstms_err_id", "cstmsErrId");
		this.hashFields.put("msg_rcv_no", "msgRcvNo");
		this.hashFields.put("dg_ttl_wgt", "dgTtlWgt");
		this.hashFields.put("rcv_log_err_seq", "rcvLogErrSeq");
		this.hashFields.put("org_msg_cntr", "orgMsgCntr");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("org_msg_nm", "orgMsgNm");
		this.hashFields.put("msg_approve_dt", "msgApproveDt");
		this.hashFields.put("psa_edi_msg_tp_id", "psaEdiMsgTpId");
		this.hashFields.put("sec_file_nbr", "secFileNbr");
		this.hashFields.put("rcv_log_seq", "rcvLogSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("msg_ack_tp", "msgAckTp");
		this.hashFields.put("msg_phone", "msgPhone");
		this.hashFields.put("msg_udt_flg", "msgUdtFlg");
		this.hashFields.put("msg_r_error_code", "msgRErrorCode");
		this.hashFields.put("cstms_err_msg", "cstmsErrMsg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("imo_no", "imoNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("msg_r_ref1", "msgRRef1");
		this.hashFields.put("org_msg_tp", "orgMsgTp");
		this.hashFields.put("cntr_ttl_err_knt", "cntrTtlErrKnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("err_cntr_sts_cd", "errCntrStsCd");
		this.hashFields.put("msg_r_ref2", "msgRRef2");
		this.hashFields.put("msg_ack_dt", "msgAckDt");
		this.hashFields.put("org_msg_bl", "orgMsgBl");
		this.hashFields.put("flsh_pnt_temp_ctnt", "flshPntTempCtnt");
		this.hashFields.put("ttl_pck_qty", "ttlPckQty");
		this.hashFields.put("cntr_ttl_scs_knt", "cntrTtlScsKnt");
		this.hashFields.put("msg_r_error_msg", "msgRErrorMsg");
		this.hashFields.put("key_val", "keyVal");
		this.hashFields.put("cstms_err_ref_no2", "cstmsErrRefNo2");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cntr_ttl_knt", "cntrTtlKnt");
		this.hashFields.put("msg_tp_id", "msgTpId");
		this.hashFields.put("cstms_err_ref_no1", "cstmsErrRefNo1");
		this.hashFields.put("psa_vsl_name", "psaVslName");
		this.hashFields.put("tnk_cntr_tpsz_flg", "tnkCntrTpszFlg");
		this.hashFields.put("msg_accept_ref", "msgAcceptRef");
		this.hashFields.put("msg_fax", "msgFax");
		this.hashFields.put("msg_ack_rslt", "msgAckRslt");
		this.hashFields.put("cntr_hndl_knd_cd", "cntrHndlKndCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("ob_vvd_cd", "obVvdCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ibVvdCd
	 */
	public String getIbVvdCd() {
		return this.ibVvdCd;
	}
	
	/**
	 * Column Info
	 * @return ttlPckTpNm
	 */
	public String getTtlPckTpNm() {
		return this.ttlPckTpNm;
	}
	
	/**
	 * Column Info
	 * @return cstmsErrId
	 */
	public String getCstmsErrId() {
		return this.cstmsErrId;
	}
	
	/**
	 * Column Info
	 * @return msgRcvNo
	 */
	public String getMsgRcvNo() {
		return this.msgRcvNo;
	}
	
	/**
	 * Column Info
	 * @return dgTtlWgt
	 */
	public String getDgTtlWgt() {
		return this.dgTtlWgt;
	}
	
	/**
	 * Column Info
	 * @return rcvLogErrSeq
	 */
	public String getRcvLogErrSeq() {
		return this.rcvLogErrSeq;
	}
	
	/**
	 * Column Info
	 * @return orgMsgCntr
	 */
	public String getOrgMsgCntr() {
		return this.orgMsgCntr;
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
	 * @return orgMsgNm
	 */
	public String getOrgMsgNm() {
		return this.orgMsgNm;
	}
	
	/**
	 * Column Info
	 * @return msgApproveDt
	 */
	public String getMsgApproveDt() {
		return this.msgApproveDt;
	}
	
	/**
	 * Column Info
	 * @return psaEdiMsgTpId
	 */
	public String getPsaEdiMsgTpId() {
		return this.psaEdiMsgTpId;
	}
	
	/**
	 * Column Info
	 * @return secFileNbr
	 */
	public String getSecFileNbr() {
		return this.secFileNbr;
	}
	
	/**
	 * Column Info
	 * @return rcvLogSeq
	 */
	public String getRcvLogSeq() {
		return this.rcvLogSeq;
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
	 * @return msgAckTp
	 */
	public String getMsgAckTp() {
		return this.msgAckTp;
	}
	
	/**
	 * Column Info
	 * @return msgPhone
	 */
	public String getMsgPhone() {
		return this.msgPhone;
	}
	
	/**
	 * Column Info
	 * @return msgUdtFlg
	 */
	public String getMsgUdtFlg() {
		return this.msgUdtFlg;
	}
	
	/**
	 * Column Info
	 * @return msgRErrorCode
	 */
	public String getMsgRErrorCode() {
		return this.msgRErrorCode;
	}
	
	/**
	 * Column Info
	 * @return cstmsErrMsg
	 */
	public String getCstmsErrMsg() {
		return this.cstmsErrMsg;
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
	 * @return imoNo
	 */
	public String getImoNo() {
		return this.imoNo;
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
	 * @return msgRRef1
	 */
	public String getMsgRRef1() {
		return this.msgRRef1;
	}
	
	/**
	 * Column Info
	 * @return orgMsgTp
	 */
	public String getOrgMsgTp() {
		return this.orgMsgTp;
	}
	
	/**
	 * Column Info
	 * @return cntrTtlErrKnt
	 */
	public String getCntrTtlErrKnt() {
		return this.cntrTtlErrKnt;
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
	 * @return errCntrStsCd
	 */
	public String getErrCntrStsCd() {
		return this.errCntrStsCd;
	}
	
	/**
	 * Column Info
	 * @return msgRRef2
	 */
	public String getMsgRRef2() {
		return this.msgRRef2;
	}
	
	/**
	 * Column Info
	 * @return msgAckDt
	 */
	public String getMsgAckDt() {
		return this.msgAckDt;
	}
	
	/**
	 * Column Info
	 * @return orgMsgBl
	 */
	public String getOrgMsgBl() {
		return this.orgMsgBl;
	}
	
	/**
	 * Column Info
	 * @return flshPntTempCtnt
	 */
	public String getFlshPntTempCtnt() {
		return this.flshPntTempCtnt;
	}
	
	/**
	 * Column Info
	 * @return ttlPckQty
	 */
	public String getTtlPckQty() {
		return this.ttlPckQty;
	}
	
	/**
	 * Column Info
	 * @return cntrTtlScsKnt
	 */
	public String getCntrTtlScsKnt() {
		return this.cntrTtlScsKnt;
	}
	
	/**
	 * Column Info
	 * @return msgRErrorMsg
	 */
	public String getMsgRErrorMsg() {
		return this.msgRErrorMsg;
	}
	
	/**
	 * Column Info
	 * @return keyVal
	 */
	public String getKeyVal() {
		return this.keyVal;
	}
	
	/**
	 * Column Info
	 * @return cstmsErrRefNo2
	 */
	public String getCstmsErrRefNo2() {
		return this.cstmsErrRefNo2;
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
	 * @return cntrTtlKnt
	 */
	public String getCntrTtlKnt() {
		return this.cntrTtlKnt;
	}
	
	/**
	 * Column Info
	 * @return msgTpId
	 */
	public String getMsgTpId() {
		return this.msgTpId;
	}
	
	/**
	 * Column Info
	 * @return cstmsErrRefNo1
	 */
	public String getCstmsErrRefNo1() {
		return this.cstmsErrRefNo1;
	}
	
	/**
	 * Column Info
	 * @return psaVslName
	 */
	public String getPsaVslName() {
		return this.psaVslName;
	}
	
	/**
	 * Column Info
	 * @return tnkCntrTpszFlg
	 */
	public String getTnkCntrTpszFlg() {
		return this.tnkCntrTpszFlg;
	}
	
	/**
	 * Column Info
	 * @return msgAcceptRef
	 */
	public String getMsgAcceptRef() {
		return this.msgAcceptRef;
	}
	
	/**
	 * Column Info
	 * @return msgFax
	 */
	public String getMsgFax() {
		return this.msgFax;
	}
	
	/**
	 * Column Info
	 * @return msgAckRslt
	 */
	public String getMsgAckRslt() {
		return this.msgAckRslt;
	}
	
	/**
	 * Column Info
	 * @return cntrHndlKndCd
	 */
	public String getCntrHndlKndCd() {
		return this.cntrHndlKndCd;
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
	 * @return obVvdCd
	 */
	public String getObVvdCd() {
		return this.obVvdCd;
	}
	

	/**
	 * Column Info
	 * @param ibVvdCd
	 */
	public void setIbVvdCd(String ibVvdCd) {
		this.ibVvdCd = ibVvdCd;
	}
	
	/**
	 * Column Info
	 * @param ttlPckTpNm
	 */
	public void setTtlPckTpNm(String ttlPckTpNm) {
		this.ttlPckTpNm = ttlPckTpNm;
	}
	
	/**
	 * Column Info
	 * @param cstmsErrId
	 */
	public void setCstmsErrId(String cstmsErrId) {
		this.cstmsErrId = cstmsErrId;
	}
	
	/**
	 * Column Info
	 * @param msgRcvNo
	 */
	public void setMsgRcvNo(String msgRcvNo) {
		this.msgRcvNo = msgRcvNo;
	}
	
	/**
	 * Column Info
	 * @param dgTtlWgt
	 */
	public void setDgTtlWgt(String dgTtlWgt) {
		this.dgTtlWgt = dgTtlWgt;
	}
	
	/**
	 * Column Info
	 * @param rcvLogErrSeq
	 */
	public void setRcvLogErrSeq(String rcvLogErrSeq) {
		this.rcvLogErrSeq = rcvLogErrSeq;
	}
	
	/**
	 * Column Info
	 * @param orgMsgCntr
	 */
	public void setOrgMsgCntr(String orgMsgCntr) {
		this.orgMsgCntr = orgMsgCntr;
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
	 * @param orgMsgNm
	 */
	public void setOrgMsgNm(String orgMsgNm) {
		this.orgMsgNm = orgMsgNm;
	}
	
	/**
	 * Column Info
	 * @param msgApproveDt
	 */
	public void setMsgApproveDt(String msgApproveDt) {
		this.msgApproveDt = msgApproveDt;
	}
	
	/**
	 * Column Info
	 * @param psaEdiMsgTpId
	 */
	public void setPsaEdiMsgTpId(String psaEdiMsgTpId) {
		this.psaEdiMsgTpId = psaEdiMsgTpId;
	}
	
	/**
	 * Column Info
	 * @param secFileNbr
	 */
	public void setSecFileNbr(String secFileNbr) {
		this.secFileNbr = secFileNbr;
	}
	
	/**
	 * Column Info
	 * @param rcvLogSeq
	 */
	public void setRcvLogSeq(String rcvLogSeq) {
		this.rcvLogSeq = rcvLogSeq;
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
	 * @param msgAckTp
	 */
	public void setMsgAckTp(String msgAckTp) {
		this.msgAckTp = msgAckTp;
	}
	
	/**
	 * Column Info
	 * @param msgPhone
	 */
	public void setMsgPhone(String msgPhone) {
		this.msgPhone = msgPhone;
	}
	
	/**
	 * Column Info
	 * @param msgUdtFlg
	 */
	public void setMsgUdtFlg(String msgUdtFlg) {
		this.msgUdtFlg = msgUdtFlg;
	}
	
	/**
	 * Column Info
	 * @param msgRErrorCode
	 */
	public void setMsgRErrorCode(String msgRErrorCode) {
		this.msgRErrorCode = msgRErrorCode;
	}
	
	/**
	 * Column Info
	 * @param cstmsErrMsg
	 */
	public void setCstmsErrMsg(String cstmsErrMsg) {
		this.cstmsErrMsg = cstmsErrMsg;
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
	 * @param imoNo
	 */
	public void setImoNo(String imoNo) {
		this.imoNo = imoNo;
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
	 * @param msgRRef1
	 */
	public void setMsgRRef1(String msgRRef1) {
		this.msgRRef1 = msgRRef1;
	}
	
	/**
	 * Column Info
	 * @param orgMsgTp
	 */
	public void setOrgMsgTp(String orgMsgTp) {
		this.orgMsgTp = orgMsgTp;
	}
	
	/**
	 * Column Info
	 * @param cntrTtlErrKnt
	 */
	public void setCntrTtlErrKnt(String cntrTtlErrKnt) {
		this.cntrTtlErrKnt = cntrTtlErrKnt;
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
	 * @param errCntrStsCd
	 */
	public void setErrCntrStsCd(String errCntrStsCd) {
		this.errCntrStsCd = errCntrStsCd;
	}
	
	/**
	 * Column Info
	 * @param msgRRef2
	 */
	public void setMsgRRef2(String msgRRef2) {
		this.msgRRef2 = msgRRef2;
	}
	
	/**
	 * Column Info
	 * @param msgAckDt
	 */
	public void setMsgAckDt(String msgAckDt) {
		this.msgAckDt = msgAckDt;
	}
	
	/**
	 * Column Info
	 * @param orgMsgBl
	 */
	public void setOrgMsgBl(String orgMsgBl) {
		this.orgMsgBl = orgMsgBl;
	}
	
	/**
	 * Column Info
	 * @param flshPntTempCtnt
	 */
	public void setFlshPntTempCtnt(String flshPntTempCtnt) {
		this.flshPntTempCtnt = flshPntTempCtnt;
	}
	
	/**
	 * Column Info
	 * @param ttlPckQty
	 */
	public void setTtlPckQty(String ttlPckQty) {
		this.ttlPckQty = ttlPckQty;
	}
	
	/**
	 * Column Info
	 * @param cntrTtlScsKnt
	 */
	public void setCntrTtlScsKnt(String cntrTtlScsKnt) {
		this.cntrTtlScsKnt = cntrTtlScsKnt;
	}
	
	/**
	 * Column Info
	 * @param msgRErrorMsg
	 */
	public void setMsgRErrorMsg(String msgRErrorMsg) {
		this.msgRErrorMsg = msgRErrorMsg;
	}
	
	/**
	 * Column Info
	 * @param keyVal
	 */
	public void setKeyVal(String keyVal) {
		this.keyVal = keyVal;
	}
	
	/**
	 * Column Info
	 * @param cstmsErrRefNo2
	 */
	public void setCstmsErrRefNo2(String cstmsErrRefNo2) {
		this.cstmsErrRefNo2 = cstmsErrRefNo2;
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
	 * @param cntrTtlKnt
	 */
	public void setCntrTtlKnt(String cntrTtlKnt) {
		this.cntrTtlKnt = cntrTtlKnt;
	}
	
	/**
	 * Column Info
	 * @param msgTpId
	 */
	public void setMsgTpId(String msgTpId) {
		this.msgTpId = msgTpId;
	}
	
	/**
	 * Column Info
	 * @param cstmsErrRefNo1
	 */
	public void setCstmsErrRefNo1(String cstmsErrRefNo1) {
		this.cstmsErrRefNo1 = cstmsErrRefNo1;
	}
	
	/**
	 * Column Info
	 * @param psaVslName
	 */
	public void setPsaVslName(String psaVslName) {
		this.psaVslName = psaVslName;
	}
	
	/**
	 * Column Info
	 * @param tnkCntrTpszFlg
	 */
	public void setTnkCntrTpszFlg(String tnkCntrTpszFlg) {
		this.tnkCntrTpszFlg = tnkCntrTpszFlg;
	}
	
	/**
	 * Column Info
	 * @param msgAcceptRef
	 */
	public void setMsgAcceptRef(String msgAcceptRef) {
		this.msgAcceptRef = msgAcceptRef;
	}
	
	/**
	 * Column Info
	 * @param msgFax
	 */
	public void setMsgFax(String msgFax) {
		this.msgFax = msgFax;
	}
	
	/**
	 * Column Info
	 * @param msgAckRslt
	 */
	public void setMsgAckRslt(String msgAckRslt) {
		this.msgAckRslt = msgAckRslt;
	}
	
	/**
	 * Column Info
	 * @param cntrHndlKndCd
	 */
	public void setCntrHndlKndCd(String cntrHndlKndCd) {
		this.cntrHndlKndCd = cntrHndlKndCd;
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
	 * @param obVvdCd
	 */
	public void setObVvdCd(String obVvdCd) {
		this.obVvdCd = obVvdCd;
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
		setIbVvdCd(JSPUtil.getParameter(request, prefix + "ib_vvd_cd", ""));
		setTtlPckTpNm(JSPUtil.getParameter(request, prefix + "ttl_pck_tp_nm", ""));
		setCstmsErrId(JSPUtil.getParameter(request, prefix + "cstms_err_id", ""));
		setMsgRcvNo(JSPUtil.getParameter(request, prefix + "msg_rcv_no", ""));
		setDgTtlWgt(JSPUtil.getParameter(request, prefix + "dg_ttl_wgt", ""));
		setRcvLogErrSeq(JSPUtil.getParameter(request, prefix + "rcv_log_err_seq", ""));
		setOrgMsgCntr(JSPUtil.getParameter(request, prefix + "org_msg_cntr", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOrgMsgNm(JSPUtil.getParameter(request, prefix + "org_msg_nm", ""));
		setMsgApproveDt(JSPUtil.getParameter(request, prefix + "msg_approve_dt", ""));
		setPsaEdiMsgTpId(JSPUtil.getParameter(request, prefix + "psa_edi_msg_tp_id", ""));
		setSecFileNbr(JSPUtil.getParameter(request, prefix + "sec_file_nbr", ""));
		setRcvLogSeq(JSPUtil.getParameter(request, prefix + "rcv_log_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setImdgUnNo(JSPUtil.getParameter(request, prefix + "imdg_un_no", ""));
		setMsgAckTp(JSPUtil.getParameter(request, prefix + "msg_ack_tp", ""));
		setMsgPhone(JSPUtil.getParameter(request, prefix + "msg_phone", ""));
		setMsgUdtFlg(JSPUtil.getParameter(request, prefix + "msg_udt_flg", ""));
		setMsgRErrorCode(JSPUtil.getParameter(request, prefix + "msg_r_error_code", ""));
		setCstmsErrMsg(JSPUtil.getParameter(request, prefix + "cstms_err_msg", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setImoNo(JSPUtil.getParameter(request, prefix + "imo_no", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setMsgRRef1(JSPUtil.getParameter(request, prefix + "msg_r_ref1", ""));
		setOrgMsgTp(JSPUtil.getParameter(request, prefix + "org_msg_tp", ""));
		setCntrTtlErrKnt(JSPUtil.getParameter(request, prefix + "cntr_ttl_err_knt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setErrCntrStsCd(JSPUtil.getParameter(request, prefix + "err_cntr_sts_cd", ""));
		setMsgRRef2(JSPUtil.getParameter(request, prefix + "msg_r_ref2", ""));
		setMsgAckDt(JSPUtil.getParameter(request, prefix + "msg_ack_dt", ""));
		setOrgMsgBl(JSPUtil.getParameter(request, prefix + "org_msg_bl", ""));
		setFlshPntTempCtnt(JSPUtil.getParameter(request, prefix + "flsh_pnt_temp_ctnt", ""));
		setTtlPckQty(JSPUtil.getParameter(request, prefix + "ttl_pck_qty", ""));
		setCntrTtlScsKnt(JSPUtil.getParameter(request, prefix + "cntr_ttl_scs_knt", ""));
		setMsgRErrorMsg(JSPUtil.getParameter(request, prefix + "msg_r_error_msg", ""));
		setKeyVal(JSPUtil.getParameter(request, prefix + "key_val", ""));
		setCstmsErrRefNo2(JSPUtil.getParameter(request, prefix + "cstms_err_ref_no2", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCntrTtlKnt(JSPUtil.getParameter(request, prefix + "cntr_ttl_knt", ""));
		setMsgTpId(JSPUtil.getParameter(request, prefix + "msg_tp_id", ""));
		setCstmsErrRefNo1(JSPUtil.getParameter(request, prefix + "cstms_err_ref_no1", ""));
		setPsaVslName(JSPUtil.getParameter(request, prefix + "psa_vsl_name", ""));
		setTnkCntrTpszFlg(JSPUtil.getParameter(request, prefix + "tnk_cntr_tpsz_flg", ""));
		setMsgAcceptRef(JSPUtil.getParameter(request, prefix + "msg_accept_ref", ""));
		setMsgFax(JSPUtil.getParameter(request, prefix + "msg_fax", ""));
		setMsgAckRslt(JSPUtil.getParameter(request, prefix + "msg_ack_rslt", ""));
		setCntrHndlKndCd(JSPUtil.getParameter(request, prefix + "cntr_hndl_knd_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setObVvdCd(JSPUtil.getParameter(request, prefix + "ob_vvd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PsaDGRcvMsgVO[]
	 */
	public PsaDGRcvMsgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PsaDGRcvMsgVO[]
	 */
	public PsaDGRcvMsgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PsaDGRcvMsgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibVvdCd = (JSPUtil.getParameter(request, prefix	+ "ib_vvd_cd", length));
			String[] ttlPckTpNm = (JSPUtil.getParameter(request, prefix	+ "ttl_pck_tp_nm", length));
			String[] cstmsErrId = (JSPUtil.getParameter(request, prefix	+ "cstms_err_id", length));
			String[] msgRcvNo = (JSPUtil.getParameter(request, prefix	+ "msg_rcv_no", length));
			String[] dgTtlWgt = (JSPUtil.getParameter(request, prefix	+ "dg_ttl_wgt", length));
			String[] rcvLogErrSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_log_err_seq", length));
			String[] orgMsgCntr = (JSPUtil.getParameter(request, prefix	+ "org_msg_cntr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] orgMsgNm = (JSPUtil.getParameter(request, prefix	+ "org_msg_nm", length));
			String[] msgApproveDt = (JSPUtil.getParameter(request, prefix	+ "msg_approve_dt", length));
			String[] psaEdiMsgTpId = (JSPUtil.getParameter(request, prefix	+ "psa_edi_msg_tp_id", length));
			String[] secFileNbr = (JSPUtil.getParameter(request, prefix	+ "sec_file_nbr", length));
			String[] rcvLogSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_log_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			String[] msgAckTp = (JSPUtil.getParameter(request, prefix	+ "msg_ack_tp", length));
			String[] msgPhone = (JSPUtil.getParameter(request, prefix	+ "msg_phone", length));
			String[] msgUdtFlg = (JSPUtil.getParameter(request, prefix	+ "msg_udt_flg", length));
			String[] msgRErrorCode = (JSPUtil.getParameter(request, prefix	+ "msg_r_error_code", length));
			String[] cstmsErrMsg = (JSPUtil.getParameter(request, prefix	+ "cstms_err_msg", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] imoNo = (JSPUtil.getParameter(request, prefix	+ "imo_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] msgRRef1 = (JSPUtil.getParameter(request, prefix	+ "msg_r_ref1", length));
			String[] orgMsgTp = (JSPUtil.getParameter(request, prefix	+ "org_msg_tp", length));
			String[] cntrTtlErrKnt = (JSPUtil.getParameter(request, prefix	+ "cntr_ttl_err_knt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] errCntrStsCd = (JSPUtil.getParameter(request, prefix	+ "err_cntr_sts_cd", length));
			String[] msgRRef2 = (JSPUtil.getParameter(request, prefix	+ "msg_r_ref2", length));
			String[] msgAckDt = (JSPUtil.getParameter(request, prefix	+ "msg_ack_dt", length));
			String[] orgMsgBl = (JSPUtil.getParameter(request, prefix	+ "org_msg_bl", length));
			String[] flshPntTempCtnt = (JSPUtil.getParameter(request, prefix	+ "flsh_pnt_temp_ctnt", length));
			String[] ttlPckQty = (JSPUtil.getParameter(request, prefix	+ "ttl_pck_qty", length));
			String[] cntrTtlScsKnt = (JSPUtil.getParameter(request, prefix	+ "cntr_ttl_scs_knt", length));
			String[] msgRErrorMsg = (JSPUtil.getParameter(request, prefix	+ "msg_r_error_msg", length));
			String[] keyVal = (JSPUtil.getParameter(request, prefix	+ "key_val", length));
			String[] cstmsErrRefNo2 = (JSPUtil.getParameter(request, prefix	+ "cstms_err_ref_no2", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] cntrTtlKnt = (JSPUtil.getParameter(request, prefix	+ "cntr_ttl_knt", length));
			String[] msgTpId = (JSPUtil.getParameter(request, prefix	+ "msg_tp_id", length));
			String[] cstmsErrRefNo1 = (JSPUtil.getParameter(request, prefix	+ "cstms_err_ref_no1", length));
			String[] psaVslName = (JSPUtil.getParameter(request, prefix	+ "psa_vsl_name", length));
			String[] tnkCntrTpszFlg = (JSPUtil.getParameter(request, prefix	+ "tnk_cntr_tpsz_flg", length));
			String[] msgAcceptRef = (JSPUtil.getParameter(request, prefix	+ "msg_accept_ref", length));
			String[] msgFax = (JSPUtil.getParameter(request, prefix	+ "msg_fax", length));
			String[] msgAckRslt = (JSPUtil.getParameter(request, prefix	+ "msg_ack_rslt", length));
			String[] cntrHndlKndCd = (JSPUtil.getParameter(request, prefix	+ "cntr_hndl_knd_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] obVvdCd = (JSPUtil.getParameter(request, prefix	+ "ob_vvd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new PsaDGRcvMsgVO();
				if (ibVvdCd[i] != null)
					model.setIbVvdCd(ibVvdCd[i]);
				if (ttlPckTpNm[i] != null)
					model.setTtlPckTpNm(ttlPckTpNm[i]);
				if (cstmsErrId[i] != null)
					model.setCstmsErrId(cstmsErrId[i]);
				if (msgRcvNo[i] != null)
					model.setMsgRcvNo(msgRcvNo[i]);
				if (dgTtlWgt[i] != null)
					model.setDgTtlWgt(dgTtlWgt[i]);
				if (rcvLogErrSeq[i] != null)
					model.setRcvLogErrSeq(rcvLogErrSeq[i]);
				if (orgMsgCntr[i] != null)
					model.setOrgMsgCntr(orgMsgCntr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (orgMsgNm[i] != null)
					model.setOrgMsgNm(orgMsgNm[i]);
				if (msgApproveDt[i] != null)
					model.setMsgApproveDt(msgApproveDt[i]);
				if (psaEdiMsgTpId[i] != null)
					model.setPsaEdiMsgTpId(psaEdiMsgTpId[i]);
				if (secFileNbr[i] != null)
					model.setSecFileNbr(secFileNbr[i]);
				if (rcvLogSeq[i] != null)
					model.setRcvLogSeq(rcvLogSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (msgAckTp[i] != null)
					model.setMsgAckTp(msgAckTp[i]);
				if (msgPhone[i] != null)
					model.setMsgPhone(msgPhone[i]);
				if (msgUdtFlg[i] != null)
					model.setMsgUdtFlg(msgUdtFlg[i]);
				if (msgRErrorCode[i] != null)
					model.setMsgRErrorCode(msgRErrorCode[i]);
				if (cstmsErrMsg[i] != null)
					model.setCstmsErrMsg(cstmsErrMsg[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (imoNo[i] != null)
					model.setImoNo(imoNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (msgRRef1[i] != null)
					model.setMsgRRef1(msgRRef1[i]);
				if (orgMsgTp[i] != null)
					model.setOrgMsgTp(orgMsgTp[i]);
				if (cntrTtlErrKnt[i] != null)
					model.setCntrTtlErrKnt(cntrTtlErrKnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (errCntrStsCd[i] != null)
					model.setErrCntrStsCd(errCntrStsCd[i]);
				if (msgRRef2[i] != null)
					model.setMsgRRef2(msgRRef2[i]);
				if (msgAckDt[i] != null)
					model.setMsgAckDt(msgAckDt[i]);
				if (orgMsgBl[i] != null)
					model.setOrgMsgBl(orgMsgBl[i]);
				if (flshPntTempCtnt[i] != null)
					model.setFlshPntTempCtnt(flshPntTempCtnt[i]);
				if (ttlPckQty[i] != null)
					model.setTtlPckQty(ttlPckQty[i]);
				if (cntrTtlScsKnt[i] != null)
					model.setCntrTtlScsKnt(cntrTtlScsKnt[i]);
				if (msgRErrorMsg[i] != null)
					model.setMsgRErrorMsg(msgRErrorMsg[i]);
				if (keyVal[i] != null)
					model.setKeyVal(keyVal[i]);
				if (cstmsErrRefNo2[i] != null)
					model.setCstmsErrRefNo2(cstmsErrRefNo2[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (cntrTtlKnt[i] != null)
					model.setCntrTtlKnt(cntrTtlKnt[i]);
				if (msgTpId[i] != null)
					model.setMsgTpId(msgTpId[i]);
				if (cstmsErrRefNo1[i] != null)
					model.setCstmsErrRefNo1(cstmsErrRefNo1[i]);
				if (psaVslName[i] != null)
					model.setPsaVslName(psaVslName[i]);
				if (tnkCntrTpszFlg[i] != null)
					model.setTnkCntrTpszFlg(tnkCntrTpszFlg[i]);
				if (msgAcceptRef[i] != null)
					model.setMsgAcceptRef(msgAcceptRef[i]);
				if (msgFax[i] != null)
					model.setMsgFax(msgFax[i]);
				if (msgAckRslt[i] != null)
					model.setMsgAckRslt(msgAckRslt[i]);
				if (cntrHndlKndCd[i] != null)
					model.setCntrHndlKndCd(cntrHndlKndCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (obVvdCd[i] != null)
					model.setObVvdCd(obVvdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPsaDGRcvMsgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PsaDGRcvMsgVO[]
	 */
	public PsaDGRcvMsgVO[] getPsaDGRcvMsgVOs(){
		PsaDGRcvMsgVO[] vos = (PsaDGRcvMsgVO[])models.toArray(new PsaDGRcvMsgVO[models.size()]);
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
		this.ibVvdCd = this.ibVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlPckTpNm = this.ttlPckTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsErrId = this.cstmsErrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgRcvNo = this.msgRcvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgTtlWgt = this.dgTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvLogErrSeq = this.rcvLogErrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgMsgCntr = this.orgMsgCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgMsgNm = this.orgMsgNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgApproveDt = this.msgApproveDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psaEdiMsgTpId = this.psaEdiMsgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.secFileNbr = this.secFileNbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvLogSeq = this.rcvLogSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgAckTp = this.msgAckTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgPhone = this.msgPhone .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgUdtFlg = this.msgUdtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgRErrorCode = this.msgRErrorCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsErrMsg = this.cstmsErrMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imoNo = this.imoNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgRRef1 = this.msgRRef1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgMsgTp = this.orgMsgTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTtlErrKnt = this.cntrTtlErrKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errCntrStsCd = this.errCntrStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgRRef2 = this.msgRRef2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgAckDt = this.msgAckDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgMsgBl = this.orgMsgBl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flshPntTempCtnt = this.flshPntTempCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlPckQty = this.ttlPckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTtlScsKnt = this.cntrTtlScsKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgRErrorMsg = this.msgRErrorMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keyVal = this.keyVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsErrRefNo2 = this.cstmsErrRefNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTtlKnt = this.cntrTtlKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgTpId = this.msgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsErrRefNo1 = this.cstmsErrRefNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psaVslName = this.psaVslName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tnkCntrTpszFlg = this.tnkCntrTpszFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgAcceptRef = this.msgAcceptRef .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgFax = this.msgFax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgAckRslt = this.msgAckRslt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHndlKndCd = this.cntrHndlKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obVvdCd = this.obVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
