/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PsaDGRcvMsgDtlVO.java
*@FileTitle : PsaDGRcvMsgDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.18
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2011.10.18 박성진 
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

public class PsaDGRcvMsgDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PsaDGRcvMsgDtlVO> models = new ArrayList<PsaDGRcvMsgDtlVO>();
	
	/* Column Info */
	private String eurEdiMsgTpId = null;
	/* Column Info */
	private String ibVvdCd = null;
	/* Column Info */
	private String imoNo = null;
	/* Column Info */
	private String ttlPckTpNm = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String cstmsErrId = null;
	/* Column Info */
	private String msgRcvNo = null;
	/* Column Info */
	private String dgTtlWgt = null;
	/* Column Info */
	private String rcvLogErrSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cntrTtlErrKnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String errCntrStsCd = null;
	/* Column Info */
	private String rcvLogSeq = null;
	/* Column Info */
	private String psaEdiMsgTpId = null;
	/* Column Info */
	private String ttlPckQty = null;
	/* Column Info */
	private String cntrTtlScsKnt = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String keyVal = null;
	/* Column Info */
	private String cntrTtlKnt = null;
	/* Column Info */
	private String cstmsErrRefNo2 = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String cstmsErrRefNo1 = null;
	/* Column Info */
	private String msgTpId = null;
	/* Column Info */
	private String psaVslName = null;
	/* Column Info */
	private String tnkCntrTpszFlg = null;
	/* Column Info */
	private String cstmsErrMsg = null;
	/* Column Info */
	private String creUsrId = null;
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
	
	public PsaDGRcvMsgDtlVO() {}

	public PsaDGRcvMsgDtlVO(String ibflag, String pagerows, String keyVal, String rcvLogSeq, String eurEdiMsgTpId, String msgRcvNo, String rcvLogErrSeq, String cstmsErrId, String cstmsErrMsg, String cstmsErrRefNo1, String cstmsErrRefNo2, String creUsrId, String creDt, String updUsrId, String updDt, String msgTpId, String psaEdiMsgTpId, String psaVslName, String ibVvdCd, String obVvdCd, String cntrNo, String cntrHndlKndCd, String errCntrStsCd, String tnkCntrTpszFlg, String ttlPckQty, String ttlPckTpNm, String dgTtlWgt, String imoNo, String imdgUnNo, String cntrTtlKnt, String cntrTtlErrKnt, String cntrTtlScsKnt) {
		this.eurEdiMsgTpId = eurEdiMsgTpId;
		this.ibVvdCd = ibVvdCd;
		this.imoNo = imoNo;
		this.ttlPckTpNm = ttlPckTpNm;
		this.creDt = creDt;
		this.cstmsErrId = cstmsErrId;
		this.msgRcvNo = msgRcvNo;
		this.dgTtlWgt = dgTtlWgt;
		this.rcvLogErrSeq = rcvLogErrSeq;
		this.pagerows = pagerows;
		this.cntrTtlErrKnt = cntrTtlErrKnt;
		this.ibflag = ibflag;
		this.errCntrStsCd = errCntrStsCd;
		this.rcvLogSeq = rcvLogSeq;
		this.psaEdiMsgTpId = psaEdiMsgTpId;
		this.ttlPckQty = ttlPckQty;
		this.cntrTtlScsKnt = cntrTtlScsKnt;
		this.imdgUnNo = imdgUnNo;
		this.updUsrId = updUsrId;
		this.keyVal = keyVal;
		this.cntrTtlKnt = cntrTtlKnt;
		this.cstmsErrRefNo2 = cstmsErrRefNo2;
		this.updDt = updDt;
		this.cstmsErrRefNo1 = cstmsErrRefNo1;
		this.msgTpId = msgTpId;
		this.psaVslName = psaVslName;
		this.tnkCntrTpszFlg = tnkCntrTpszFlg;
		this.cstmsErrMsg = cstmsErrMsg;
		this.creUsrId = creUsrId;
		this.cntrHndlKndCd = cntrHndlKndCd;
		this.cntrNo = cntrNo;
		this.obVvdCd = obVvdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eur_edi_msg_tp_id", getEurEdiMsgTpId());
		this.hashColumns.put("ib_vvd_cd", getIbVvdCd());
		this.hashColumns.put("imo_no", getImoNo());
		this.hashColumns.put("ttl_pck_tp_nm", getTtlPckTpNm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cstms_err_id", getCstmsErrId());
		this.hashColumns.put("msg_rcv_no", getMsgRcvNo());
		this.hashColumns.put("dg_ttl_wgt", getDgTtlWgt());
		this.hashColumns.put("rcv_log_err_seq", getRcvLogErrSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cntr_ttl_err_knt", getCntrTtlErrKnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("err_cntr_sts_cd", getErrCntrStsCd());
		this.hashColumns.put("rcv_log_seq", getRcvLogSeq());
		this.hashColumns.put("psa_edi_msg_tp_id", getPsaEdiMsgTpId());
		this.hashColumns.put("ttl_pck_qty", getTtlPckQty());
		this.hashColumns.put("cntr_ttl_scs_knt", getCntrTtlScsKnt());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("key_val", getKeyVal());
		this.hashColumns.put("cntr_ttl_knt", getCntrTtlKnt());
		this.hashColumns.put("cstms_err_ref_no2", getCstmsErrRefNo2());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cstms_err_ref_no1", getCstmsErrRefNo1());
		this.hashColumns.put("msg_tp_id", getMsgTpId());
		this.hashColumns.put("psa_vsl_name", getPsaVslName());
		this.hashColumns.put("tnk_cntr_tpsz_flg", getTnkCntrTpszFlg());
		this.hashColumns.put("cstms_err_msg", getCstmsErrMsg());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
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
		this.hashFields.put("eur_edi_msg_tp_id", "eurEdiMsgTpId");
		this.hashFields.put("ib_vvd_cd", "ibVvdCd");
		this.hashFields.put("imo_no", "imoNo");
		this.hashFields.put("ttl_pck_tp_nm", "ttlPckTpNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cstms_err_id", "cstmsErrId");
		this.hashFields.put("msg_rcv_no", "msgRcvNo");
		this.hashFields.put("dg_ttl_wgt", "dgTtlWgt");
		this.hashFields.put("rcv_log_err_seq", "rcvLogErrSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cntr_ttl_err_knt", "cntrTtlErrKnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("err_cntr_sts_cd", "errCntrStsCd");
		this.hashFields.put("rcv_log_seq", "rcvLogSeq");
		this.hashFields.put("psa_edi_msg_tp_id", "psaEdiMsgTpId");
		this.hashFields.put("ttl_pck_qty", "ttlPckQty");
		this.hashFields.put("cntr_ttl_scs_knt", "cntrTtlScsKnt");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("key_val", "keyVal");
		this.hashFields.put("cntr_ttl_knt", "cntrTtlKnt");
		this.hashFields.put("cstms_err_ref_no2", "cstmsErrRefNo2");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cstms_err_ref_no1", "cstmsErrRefNo1");
		this.hashFields.put("msg_tp_id", "msgTpId");
		this.hashFields.put("psa_vsl_name", "psaVslName");
		this.hashFields.put("tnk_cntr_tpsz_flg", "tnkCntrTpszFlg");
		this.hashFields.put("cstms_err_msg", "cstmsErrMsg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cntr_hndl_knd_cd", "cntrHndlKndCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("ob_vvd_cd", "obVvdCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return eurEdiMsgTpId
	 */
	public String getEurEdiMsgTpId() {
		return this.eurEdiMsgTpId;
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
	 * @return imoNo
	 */
	public String getImoNo() {
		return this.imoNo;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return rcvLogSeq
	 */
	public String getRcvLogSeq() {
		return this.rcvLogSeq;
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
	 * @return imdgUnNo
	 */
	public String getImdgUnNo() {
		return this.imdgUnNo;
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
	 * @return keyVal
	 */
	public String getKeyVal() {
		return this.keyVal;
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
	 * @return cstmsErrRefNo1
	 */
	public String getCstmsErrRefNo1() {
		return this.cstmsErrRefNo1;
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
	 * @param eurEdiMsgTpId
	 */
	public void setEurEdiMsgTpId(String eurEdiMsgTpId) {
		this.eurEdiMsgTpId = eurEdiMsgTpId;
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
	 * @param imoNo
	 */
	public void setImoNo(String imoNo) {
		this.imoNo = imoNo;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param rcvLogSeq
	 */
	public void setRcvLogSeq(String rcvLogSeq) {
		this.rcvLogSeq = rcvLogSeq;
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
	 * @param imdgUnNo
	 */
	public void setImdgUnNo(String imdgUnNo) {
		this.imdgUnNo = imdgUnNo;
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
	 * @param keyVal
	 */
	public void setKeyVal(String keyVal) {
		this.keyVal = keyVal;
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
	 * @param cstmsErrRefNo1
	 */
	public void setCstmsErrRefNo1(String cstmsErrRefNo1) {
		this.cstmsErrRefNo1 = cstmsErrRefNo1;
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
		setEurEdiMsgTpId(JSPUtil.getParameter(request, prefix + "eur_edi_msg_tp_id", ""));
		setIbVvdCd(JSPUtil.getParameter(request, prefix + "ib_vvd_cd", ""));
		setImoNo(JSPUtil.getParameter(request, prefix + "imo_no", ""));
		setTtlPckTpNm(JSPUtil.getParameter(request, prefix + "ttl_pck_tp_nm", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCstmsErrId(JSPUtil.getParameter(request, prefix + "cstms_err_id", ""));
		setMsgRcvNo(JSPUtil.getParameter(request, prefix + "msg_rcv_no", ""));
		setDgTtlWgt(JSPUtil.getParameter(request, prefix + "dg_ttl_wgt", ""));
		setRcvLogErrSeq(JSPUtil.getParameter(request, prefix + "rcv_log_err_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCntrTtlErrKnt(JSPUtil.getParameter(request, prefix + "cntr_ttl_err_knt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setErrCntrStsCd(JSPUtil.getParameter(request, prefix + "err_cntr_sts_cd", ""));
		setRcvLogSeq(JSPUtil.getParameter(request, prefix + "rcv_log_seq", ""));
		setPsaEdiMsgTpId(JSPUtil.getParameter(request, prefix + "psa_edi_msg_tp_id", ""));
		setTtlPckQty(JSPUtil.getParameter(request, prefix + "ttl_pck_qty", ""));
		setCntrTtlScsKnt(JSPUtil.getParameter(request, prefix + "cntr_ttl_scs_knt", ""));
		setImdgUnNo(JSPUtil.getParameter(request, prefix + "imdg_un_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setKeyVal(JSPUtil.getParameter(request, prefix + "key_val", ""));
		setCntrTtlKnt(JSPUtil.getParameter(request, prefix + "cntr_ttl_knt", ""));
		setCstmsErrRefNo2(JSPUtil.getParameter(request, prefix + "cstms_err_ref_no2", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCstmsErrRefNo1(JSPUtil.getParameter(request, prefix + "cstms_err_ref_no1", ""));
		setMsgTpId(JSPUtil.getParameter(request, prefix + "msg_tp_id", ""));
		setPsaVslName(JSPUtil.getParameter(request, prefix + "psa_vsl_name", ""));
		setTnkCntrTpszFlg(JSPUtil.getParameter(request, prefix + "tnk_cntr_tpsz_flg", ""));
		setCstmsErrMsg(JSPUtil.getParameter(request, prefix + "cstms_err_msg", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCntrHndlKndCd(JSPUtil.getParameter(request, prefix + "cntr_hndl_knd_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setObVvdCd(JSPUtil.getParameter(request, prefix + "ob_vvd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PsaDGRcvMsgDtlVO[]
	 */
	public PsaDGRcvMsgDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PsaDGRcvMsgDtlVO[]
	 */
	public PsaDGRcvMsgDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PsaDGRcvMsgDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] eurEdiMsgTpId = (JSPUtil.getParameter(request, prefix	+ "eur_edi_msg_tp_id", length));
			String[] ibVvdCd = (JSPUtil.getParameter(request, prefix	+ "ib_vvd_cd", length));
			String[] imoNo = (JSPUtil.getParameter(request, prefix	+ "imo_no", length));
			String[] ttlPckTpNm = (JSPUtil.getParameter(request, prefix	+ "ttl_pck_tp_nm", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] cstmsErrId = (JSPUtil.getParameter(request, prefix	+ "cstms_err_id", length));
			String[] msgRcvNo = (JSPUtil.getParameter(request, prefix	+ "msg_rcv_no", length));
			String[] dgTtlWgt = (JSPUtil.getParameter(request, prefix	+ "dg_ttl_wgt", length));
			String[] rcvLogErrSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_log_err_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cntrTtlErrKnt = (JSPUtil.getParameter(request, prefix	+ "cntr_ttl_err_knt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] errCntrStsCd = (JSPUtil.getParameter(request, prefix	+ "err_cntr_sts_cd", length));
			String[] rcvLogSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_log_seq", length));
			String[] psaEdiMsgTpId = (JSPUtil.getParameter(request, prefix	+ "psa_edi_msg_tp_id", length));
			String[] ttlPckQty = (JSPUtil.getParameter(request, prefix	+ "ttl_pck_qty", length));
			String[] cntrTtlScsKnt = (JSPUtil.getParameter(request, prefix	+ "cntr_ttl_scs_knt", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] keyVal = (JSPUtil.getParameter(request, prefix	+ "key_val", length));
			String[] cntrTtlKnt = (JSPUtil.getParameter(request, prefix	+ "cntr_ttl_knt", length));
			String[] cstmsErrRefNo2 = (JSPUtil.getParameter(request, prefix	+ "cstms_err_ref_no2", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] cstmsErrRefNo1 = (JSPUtil.getParameter(request, prefix	+ "cstms_err_ref_no1", length));
			String[] msgTpId = (JSPUtil.getParameter(request, prefix	+ "msg_tp_id", length));
			String[] psaVslName = (JSPUtil.getParameter(request, prefix	+ "psa_vsl_name", length));
			String[] tnkCntrTpszFlg = (JSPUtil.getParameter(request, prefix	+ "tnk_cntr_tpsz_flg", length));
			String[] cstmsErrMsg = (JSPUtil.getParameter(request, prefix	+ "cstms_err_msg", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cntrHndlKndCd = (JSPUtil.getParameter(request, prefix	+ "cntr_hndl_knd_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] obVvdCd = (JSPUtil.getParameter(request, prefix	+ "ob_vvd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new PsaDGRcvMsgDtlVO();
				if (eurEdiMsgTpId[i] != null)
					model.setEurEdiMsgTpId(eurEdiMsgTpId[i]);
				if (ibVvdCd[i] != null)
					model.setIbVvdCd(ibVvdCd[i]);
				if (imoNo[i] != null)
					model.setImoNo(imoNo[i]);
				if (ttlPckTpNm[i] != null)
					model.setTtlPckTpNm(ttlPckTpNm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (cstmsErrId[i] != null)
					model.setCstmsErrId(cstmsErrId[i]);
				if (msgRcvNo[i] != null)
					model.setMsgRcvNo(msgRcvNo[i]);
				if (dgTtlWgt[i] != null)
					model.setDgTtlWgt(dgTtlWgt[i]);
				if (rcvLogErrSeq[i] != null)
					model.setRcvLogErrSeq(rcvLogErrSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cntrTtlErrKnt[i] != null)
					model.setCntrTtlErrKnt(cntrTtlErrKnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (errCntrStsCd[i] != null)
					model.setErrCntrStsCd(errCntrStsCd[i]);
				if (rcvLogSeq[i] != null)
					model.setRcvLogSeq(rcvLogSeq[i]);
				if (psaEdiMsgTpId[i] != null)
					model.setPsaEdiMsgTpId(psaEdiMsgTpId[i]);
				if (ttlPckQty[i] != null)
					model.setTtlPckQty(ttlPckQty[i]);
				if (cntrTtlScsKnt[i] != null)
					model.setCntrTtlScsKnt(cntrTtlScsKnt[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (keyVal[i] != null)
					model.setKeyVal(keyVal[i]);
				if (cntrTtlKnt[i] != null)
					model.setCntrTtlKnt(cntrTtlKnt[i]);
				if (cstmsErrRefNo2[i] != null)
					model.setCstmsErrRefNo2(cstmsErrRefNo2[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (cstmsErrRefNo1[i] != null)
					model.setCstmsErrRefNo1(cstmsErrRefNo1[i]);
				if (msgTpId[i] != null)
					model.setMsgTpId(msgTpId[i]);
				if (psaVslName[i] != null)
					model.setPsaVslName(psaVslName[i]);
				if (tnkCntrTpszFlg[i] != null)
					model.setTnkCntrTpszFlg(tnkCntrTpszFlg[i]);
				if (cstmsErrMsg[i] != null)
					model.setCstmsErrMsg(cstmsErrMsg[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
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
		return getPsaDGRcvMsgDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PsaDGRcvMsgDtlVO[]
	 */
	public PsaDGRcvMsgDtlVO[] getPsaDGRcvMsgDtlVOs(){
		PsaDGRcvMsgDtlVO[] vos = (PsaDGRcvMsgDtlVO[])models.toArray(new PsaDGRcvMsgDtlVO[models.size()]);
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
		this.eurEdiMsgTpId = this.eurEdiMsgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibVvdCd = this.ibVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imoNo = this.imoNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlPckTpNm = this.ttlPckTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsErrId = this.cstmsErrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgRcvNo = this.msgRcvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgTtlWgt = this.dgTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvLogErrSeq = this.rcvLogErrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTtlErrKnt = this.cntrTtlErrKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errCntrStsCd = this.errCntrStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvLogSeq = this.rcvLogSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psaEdiMsgTpId = this.psaEdiMsgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlPckQty = this.ttlPckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTtlScsKnt = this.cntrTtlScsKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keyVal = this.keyVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTtlKnt = this.cntrTtlKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsErrRefNo2 = this.cstmsErrRefNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsErrRefNo1 = this.cstmsErrRefNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgTpId = this.msgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psaVslName = this.psaVslName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tnkCntrTpszFlg = this.tnkCntrTpszFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsErrMsg = this.cstmsErrMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHndlKndCd = this.cntrHndlKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obVvdCd = this.obVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
