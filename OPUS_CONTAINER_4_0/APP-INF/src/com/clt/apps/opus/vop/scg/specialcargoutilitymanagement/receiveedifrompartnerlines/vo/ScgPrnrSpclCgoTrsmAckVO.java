/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ScgPrnrSpclCgoTrsmAckVO.java
 *@FileTitle : ScgPrnrSpclCgoTrsmAckVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.11.21
 *@LastModifier : dongsoo
 *@LastVersion : 1.0
 * 2014.11.21 dongsoo 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author dongsoo
 * @since J2EE 1.6
 * @see	..
 */
public class ScgPrnrSpclCgoTrsmAckVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<ScgPrnrSpclCgoTrsmAckVO> models = new ArrayList<ScgPrnrSpclCgoTrsmAckVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /*	Column Info	*/
    private String trsmBndCd = null;

    /*	Column Info	*/
    private String trsmDt = null;

    /*	Column Info	*/
    private String spclCgoCateCd = null;

    /*	Column Info	*/
    private String prnrSpclCgoSeq = null;

    /*	Column Info	*/
    private String ackSubSeq = null;

    /*	Column Info	*/
    private String ediMsgId = null;

    /*	Column Info	*/
    private String ediSndrId = null;

    /*	Column Info	*/
    private String ediRcvrId = null;

    /*	Column Info	*/
    private String ediIfId = null;

    /*	Column Info	*/
    private String trsmStsCd = null;

    /*	Column Info	*/
    private String ediHdrMsg = null;

    /*	Column Info	*/
    private String orgMsgRcvrNm = null;

    /*	Column Info	*/
    private String orgMsgKeyNo = null;

    /*	Column Info	*/
    private String orgMsgTpCd = null;

    /*	Column Info	*/
    private String msgUpdFlg = null;

    /*	Column Info	*/
    private String orgMsgNm = null;

    /*	Column Info	*/
    private String msgAckTpCd = null;

    /*	Column Info	*/
    private String msgAckRsltCd = null;

    /*	Column Info	*/
    private String msgAckLoclDt = null;

    /*	Column Info	*/
    private String msgAckGdt = null;

    /*	Column Info	*/
    private String msgRjctRsn = null;

    /*	Column Info	*/
    private String msgAcptRefNo = null;

    /*	Column Info	*/
    private String creUsrId = null;

    /*	Column Info	*/
    private String creDt = null;

    /*	Column Info	*/
    private String updUsrId = null;

    /*	Column Info	*/
    private String updDt = null;

    /*	Column Info	*/
    private String errDtlCd = null;

    /*	Column Info	*/
    private String msgRjctCd = null;

    /* Column Info */
    private String orgMsgRcvDt = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    /**	Constructor	*/
    public ScgPrnrSpclCgoTrsmAckVO() {
    }

    public ScgPrnrSpclCgoTrsmAckVO(String ibflag, String pagerows, String trsmBndCd, String trsmDt, String spclCgoCateCd, String prnrSpclCgoSeq, String ackSubSeq, String ediMsgId, String ediSndrId, String ediRcvrId, String ediIfId, String trsmStsCd, String ediHdrMsg, String orgMsgRcvrNm, String orgMsgKeyNo, String orgMsgTpCd, String msgUpdFlg, String orgMsgNm, String msgAckTpCd, String msgAckRsltCd, String msgAckLoclDt, String msgAckGdt, String msgRjctRsn, String msgAcptRefNo, String creUsrId, String creDt, String updUsrId, String updDt, String errDtlCd, String msgRjctCd, String orgMsgRcvDt) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.trsmBndCd = trsmBndCd;
        this.trsmDt = trsmDt;
        this.spclCgoCateCd = spclCgoCateCd;
        this.prnrSpclCgoSeq = prnrSpclCgoSeq;
        this.ackSubSeq = ackSubSeq;
        this.ediMsgId = ediMsgId;
        this.ediSndrId = ediSndrId;
        this.ediRcvrId = ediRcvrId;
        this.ediIfId = ediIfId;
        this.trsmStsCd = trsmStsCd;
        this.ediHdrMsg = ediHdrMsg;
        this.orgMsgRcvrNm = orgMsgRcvrNm;
        this.orgMsgKeyNo = orgMsgKeyNo;
        this.orgMsgTpCd = orgMsgTpCd;
        this.msgUpdFlg = msgUpdFlg;
        this.orgMsgNm = orgMsgNm;
        this.msgAckTpCd = msgAckTpCd;
        this.msgAckRsltCd = msgAckRsltCd;
        this.msgAckLoclDt = msgAckLoclDt;
        this.msgAckGdt = msgAckGdt;
        this.msgRjctRsn = msgRjctRsn;
        this.msgAcptRefNo = msgAcptRefNo;
        this.creUsrId = creUsrId;
        this.creDt = creDt;
        this.updUsrId = updUsrId;
        this.updDt = updDt;
        this.errDtlCd = errDtlCd;
        this.msgRjctCd = msgRjctCd;
        this.orgMsgRcvDt = orgMsgRcvDt;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("trsm_bnd_cd", getTrsmBndCd());
        this.hashColumns.put("trsm_dt", getTrsmDt());
        this.hashColumns.put("spcl_cgo_cate_cd", getSpclCgoCateCd());
        this.hashColumns.put("prnr_spcl_cgo_seq", getPrnrSpclCgoSeq());
        this.hashColumns.put("ack_sub_seq", getAckSubSeq());
        this.hashColumns.put("edi_msg_id", getEdiMsgId());
        this.hashColumns.put("edi_sndr_id", getEdiSndrId());
        this.hashColumns.put("edi_rcvr_id", getEdiRcvrId());
        this.hashColumns.put("edi_if_id", getEdiIfId());
        this.hashColumns.put("trsm_sts_cd", getTrsmStsCd());
        this.hashColumns.put("edi_hdr_msg", getEdiHdrMsg());
        this.hashColumns.put("org_msg_rcvr_nm", getOrgMsgRcvrNm());
        this.hashColumns.put("org_msg_key_no", getOrgMsgKeyNo());
        this.hashColumns.put("org_msg_tp_cd", getOrgMsgTpCd());
        this.hashColumns.put("msg_upd_flg", getMsgUpdFlg());
        this.hashColumns.put("org_msg_nm", getOrgMsgNm());
        this.hashColumns.put("msg_ack_tp_cd", getMsgAckTpCd());
        this.hashColumns.put("msg_ack_rslt_cd", getMsgAckRsltCd());
        this.hashColumns.put("msg_ack_locl_dt", getMsgAckLoclDt());
        this.hashColumns.put("msg_ack_gdt", getMsgAckGdt());
        this.hashColumns.put("msg_rjct_rsn", getMsgRjctRsn());
        this.hashColumns.put("msg_acpt_ref_no", getMsgAcptRefNo());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("err_dtl_cd", getErrDtlCd());
        this.hashColumns.put("msg_rjct_cd", getMsgRjctCd());
        this.hashColumns.put("org_msg_rcv_dt", getOrgMsgRcvDt());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("trsm_bnd_cd", "trsmBndCd");
        this.hashFields.put("trsm_dt", "trsmDt");
        this.hashFields.put("spcl_cgo_cate_cd", "spclCgoCateCd");
        this.hashFields.put("prnr_spcl_cgo_seq", "prnrSpclCgoSeq");
        this.hashFields.put("ack_sub_seq", "ackSubSeq");
        this.hashFields.put("edi_msg_id", "ediMsgId");
        this.hashFields.put("edi_sndr_id", "ediSndrId");
        this.hashFields.put("edi_rcvr_id", "ediRcvrId");
        this.hashFields.put("edi_if_id", "ediIfId");
        this.hashFields.put("trsm_sts_cd", "trsmStsCd");
        this.hashFields.put("edi_hdr_msg", "ediHdrMsg");
        this.hashFields.put("org_msg_rcvr_nm", "orgMsgRcvrNm");
        this.hashFields.put("org_msg_key_no", "orgMsgKeyNo");
        this.hashFields.put("org_msg_tp_cd", "orgMsgTpCd");
        this.hashFields.put("msg_upd_flg", "msgUpdFlg");
        this.hashFields.put("org_msg_nm", "orgMsgNm");
        this.hashFields.put("msg_ack_tp_cd", "msgAckTpCd");
        this.hashFields.put("msg_ack_rslt_cd", "msgAckRsltCd");
        this.hashFields.put("msg_ack_locl_dt", "msgAckLoclDt");
        this.hashFields.put("msg_ack_gdt", "msgAckGdt");
        this.hashFields.put("msg_rjct_rsn", "msgRjctRsn");
        this.hashFields.put("msg_acpt_ref_no", "msgAcptRefNo");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("err_dtl_cd", "errDtlCd");
        this.hashFields.put("msg_rjct_cd", "msgRjctCd");
        this.hashFields.put("org_msg_rcv_dt", "orgMsgRcvDt");
        return this.hashFields;
    }

    //	Getters	and	Setters
    /**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
    public String getIbflag() {
        return this.ibflag;
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
	 * @return trsmBndCd
	 */
    public String getTrsmBndCd() {
        return this.trsmBndCd;
    }

    /**
	 * Column Info
	 * @return trsmDt
	 */
    public String getTrsmDt() {
        return this.trsmDt;
    }

    /**
	 * Column Info
	 * @return spclCgoCateCd
	 */
    public String getSpclCgoCateCd() {
        return this.spclCgoCateCd;
    }

    /**
	 * Column Info
	 * @return prnrSpclCgoSeq
	 */
    public String getPrnrSpclCgoSeq() {
        return this.prnrSpclCgoSeq;
    }

    /**
	 * Column Info
	 * @return ackSubSeq
	 */
    public String getAckSubSeq() {
        return this.ackSubSeq;
    }

    /**
	 * Column Info
	 * @return ediMsgId
	 */
    public String getEdiMsgId() {
        return this.ediMsgId;
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
	 * @return ediRcvrId
	 */
    public String getEdiRcvrId() {
        return this.ediRcvrId;
    }

    /**
	 * Column Info
	 * @return ediIfId
	 */
    public String getEdiIfId() {
        return this.ediIfId;
    }

    /**
	 * Column Info
	 * @return trsmStsCd
	 */
    public String getTrsmStsCd() {
        return this.trsmStsCd;
    }

    /**
	 * Column Info
	 * @return ediHdrMsg
	 */
    public String getEdiHdrMsg() {
        return this.ediHdrMsg;
    }

    /**
	 * Column Info
	 * @return orgMsgRcvrNm
	 */
    public String getOrgMsgRcvrNm() {
        return this.orgMsgRcvrNm;
    }

    /**
	 * Column Info
	 * @return orgMsgKeyNo
	 */
    public String getOrgMsgKeyNo() {
        return this.orgMsgKeyNo;
    }

    /**
	 * Column Info
	 * @return orgMsgTpCd
	 */
    public String getOrgMsgTpCd() {
        return this.orgMsgTpCd;
    }

    /**
	 * Column Info
	 * @return msgUpdFlg
	 */
    public String getMsgUpdFlg() {
        return this.msgUpdFlg;
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
	 * @return msgAckTpCd
	 */
    public String getMsgAckTpCd() {
        return this.msgAckTpCd;
    }

    /**
	 * Column Info
	 * @return msgAckRsltCd
	 */
    public String getMsgAckRsltCd() {
        return this.msgAckRsltCd;
    }

    /**
	 * Column Info
	 * @return msgAckLoclDt
	 */
    public String getMsgAckLoclDt() {
        return this.msgAckLoclDt;
    }

    /**
	 * Column Info
	 * @return msgAckGdt
	 */
    public String getMsgAckGdt() {
        return this.msgAckGdt;
    }

    /**
	 * Column Info
	 * @return msgRjctRsn
	 */
    public String getMsgRjctRsn() {
        return this.msgRjctRsn;
    }

    /**
	 * Column Info
	 * @return msgAcptRefNo
	 */
    public String getMsgAcptRefNo() {
        return this.msgAcptRefNo;
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
	 * @return creDt
	 */
    public String getCreDt() {
        return this.creDt;
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
	 * @return errDtlCd
	 */
    public String getErrDtlCd() {
        return this.errDtlCd;
    }

    /**
	 * Column Info
	 * @return msgRjctCd
	 */
    public String getMsgRjctCd() {
        return this.msgRjctCd;
    }

    /**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param  ibflag
 	 */
    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
    }

    /**
	 * Page Number
	 * @param  pagerows
 	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    /**
	 * Column Info
	 * @param  trsmBndCd
 	 */
    public void setTrsmBndCd(String trsmBndCd) {
        this.trsmBndCd = trsmBndCd;
    }

    /**
	 * Column Info
	 * @param  trsmDt
 	 */
    public void setTrsmDt(String trsmDt) {
        this.trsmDt = trsmDt;
    }

    /**
	 * Column Info
	 * @param  spclCgoCateCd
 	 */
    public void setSpclCgoCateCd(String spclCgoCateCd) {
        this.spclCgoCateCd = spclCgoCateCd;
    }

    /**
	 * Column Info
	 * @param  prnrSpclCgoSeq
 	 */
    public void setPrnrSpclCgoSeq(String prnrSpclCgoSeq) {
        this.prnrSpclCgoSeq = prnrSpclCgoSeq;
    }

    /**
	 * Column Info
	 * @param  ackSubSeq
 	 */
    public void setAckSubSeq(String ackSubSeq) {
        this.ackSubSeq = ackSubSeq;
    }

    /**
	 * Column Info
	 * @param  ediMsgId
 	 */
    public void setEdiMsgId(String ediMsgId) {
        this.ediMsgId = ediMsgId;
    }

    /**
	 * Column Info
	 * @param  ediSndrId
 	 */
    public void setEdiSndrId(String ediSndrId) {
        this.ediSndrId = ediSndrId;
    }

    /**
	 * Column Info
	 * @param  ediRcvrId
 	 */
    public void setEdiRcvrId(String ediRcvrId) {
        this.ediRcvrId = ediRcvrId;
    }

    /**
	 * Column Info
	 * @param  ediIfId
 	 */
    public void setEdiIfId(String ediIfId) {
        this.ediIfId = ediIfId;
    }

    /**
	 * Column Info
	 * @param  trsmStsCd
 	 */
    public void setTrsmStsCd(String trsmStsCd) {
        this.trsmStsCd = trsmStsCd;
    }

    /**
	 * Column Info
	 * @param  ediHdrMsg
 	 */
    public void setEdiHdrMsg(String ediHdrMsg) {
        this.ediHdrMsg = ediHdrMsg;
    }

    /**
	 * Column Info
	 * @param  orgMsgRcvrNm
 	 */
    public void setOrgMsgRcvrNm(String orgMsgRcvrNm) {
        this.orgMsgRcvrNm = orgMsgRcvrNm;
    }

    /**
	 * Column Info
	 * @param  orgMsgKeyNo
 	 */
    public void setOrgMsgKeyNo(String orgMsgKeyNo) {
        this.orgMsgKeyNo = orgMsgKeyNo;
    }

    /**
	 * Column Info
	 * @param  orgMsgTpCd
 	 */
    public void setOrgMsgTpCd(String orgMsgTpCd) {
        this.orgMsgTpCd = orgMsgTpCd;
    }

    /**
	 * Column Info
	 * @param  msgUpdFlg
 	 */
    public void setMsgUpdFlg(String msgUpdFlg) {
        this.msgUpdFlg = msgUpdFlg;
    }

    /**
	 * Column Info
	 * @param  orgMsgNm
 	 */
    public void setOrgMsgNm(String orgMsgNm) {
        this.orgMsgNm = orgMsgNm;
    }

    /**
	 * Column Info
	 * @param  msgAckTpCd
 	 */
    public void setMsgAckTpCd(String msgAckTpCd) {
        this.msgAckTpCd = msgAckTpCd;
    }

    /**
	 * Column Info
	 * @param  msgAckRsltCd
 	 */
    public void setMsgAckRsltCd(String msgAckRsltCd) {
        this.msgAckRsltCd = msgAckRsltCd;
    }

    /**
	 * Column Info
	 * @param  msgAckLoclDt
 	 */
    public void setMsgAckLoclDt(String msgAckLoclDt) {
        this.msgAckLoclDt = msgAckLoclDt;
    }

    /**
	 * Column Info
	 * @param  msgAckGdt
 	 */
    public void setMsgAckGdt(String msgAckGdt) {
        this.msgAckGdt = msgAckGdt;
    }

    /**
	 * Column Info
	 * @param  msgRjctRsn
 	 */
    public void setMsgRjctRsn(String msgRjctRsn) {
        this.msgRjctRsn = msgRjctRsn;
    }

    /**
	 * Column Info
	 * @param  msgAcptRefNo
 	 */
    public void setMsgAcptRefNo(String msgAcptRefNo) {
        this.msgAcptRefNo = msgAcptRefNo;
    }

    /**
	 * Column Info
	 * @param  creUsrId
 	 */
    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
    }

    /**
	 * Column Info
	 * @param  creDt
 	 */
    public void setCreDt(String creDt) {
        this.creDt = creDt;
    }

    /**
	 * Column Info
	 * @param  updUsrId
 	 */
    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
    }

    /**
	 * Column Info
	 * @param  updDt
 	 */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    /**
	 * Column Info
	 * @param  errDtlCd
 	 */
    public void setErrDtlCd(String errDtlCd) {
        this.errDtlCd = errDtlCd;
    }

    /**
	 * Column Info
	 * @param  msgRjctCd
 	 */
    public void setMsgRjctCd(String msgRjctCd) {
        this.msgRjctCd = msgRjctCd;
    }

    public void setOrgMsgRcvDt(String orgMsgRcvDt) {
        this.orgMsgRcvDt = orgMsgRcvDt;
    }

    public String getOrgMsgRcvDt() {
        return this.orgMsgRcvDt;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        fromRequest(request, "");
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request, String prefix) {
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setTrsmBndCd(JSPUtil.getParameter(request, prefix + "trsm_bnd_cd", ""));
        setTrsmDt(JSPUtil.getParameter(request, prefix + "trsm_dt", ""));
        setSpclCgoCateCd(JSPUtil.getParameter(request, prefix + "spcl_cgo_cate_cd", ""));
        setPrnrSpclCgoSeq(JSPUtil.getParameter(request, prefix + "prnr_spcl_cgo_seq", ""));
        setAckSubSeq(JSPUtil.getParameter(request, prefix + "ack_sub_seq", ""));
        setEdiMsgId(JSPUtil.getParameter(request, prefix + "edi_msg_id", ""));
        setEdiSndrId(JSPUtil.getParameter(request, prefix + "edi_sndr_id", ""));
        setEdiRcvrId(JSPUtil.getParameter(request, prefix + "edi_rcvr_id", ""));
        setEdiIfId(JSPUtil.getParameter(request, prefix + "edi_if_id", ""));
        setTrsmStsCd(JSPUtil.getParameter(request, prefix + "trsm_sts_cd", ""));
        setEdiHdrMsg(JSPUtil.getParameter(request, prefix + "edi_hdr_msg", ""));
        setOrgMsgRcvrNm(JSPUtil.getParameter(request, prefix + "org_msg_rcvr_nm", ""));
        setOrgMsgKeyNo(JSPUtil.getParameter(request, prefix + "org_msg_key_no", ""));
        setOrgMsgTpCd(JSPUtil.getParameter(request, prefix + "org_msg_tp_cd", ""));
        setMsgUpdFlg(JSPUtil.getParameter(request, prefix + "msg_upd_flg", ""));
        setOrgMsgNm(JSPUtil.getParameter(request, prefix + "org_msg_nm", ""));
        setMsgAckTpCd(JSPUtil.getParameter(request, prefix + "msg_ack_tp_cd", ""));
        setMsgAckRsltCd(JSPUtil.getParameter(request, prefix + "msg_ack_rslt_cd", ""));
        setMsgAckLoclDt(JSPUtil.getParameter(request, prefix + "msg_ack_locl_dt", ""));
        setMsgAckGdt(JSPUtil.getParameter(request, prefix + "msg_ack_gdt", ""));
        setMsgRjctRsn(JSPUtil.getParameter(request, prefix + "msg_rjct_rsn", ""));
        setMsgAcptRefNo(JSPUtil.getParameter(request, prefix + "msg_acpt_ref_no", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setErrDtlCd(JSPUtil.getParameter(request, prefix + "err_dtl_cd", ""));
        setMsgRjctCd(JSPUtil.getParameter(request, prefix + "msg_rjct_cd", ""));
        setOrgMsgRcvDt(JSPUtil.getParameter(request, prefix + "org_msg_rcv_dt", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScgPrnrSpclCgoTrsmAckVO[]
	 */
    public ScgPrnrSpclCgoTrsmAckVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ScgPrnrSpclCgoTrsmAckVO[]
	 */
    public ScgPrnrSpclCgoTrsmAckVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        ScgPrnrSpclCgoTrsmAckVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] trsmBndCd = (JSPUtil.getParameter(request, prefix + "trsm_bnd_cd", length));
            String[] trsmDt = (JSPUtil.getParameter(request, prefix + "trsm_dt", length));
            String[] spclCgoCateCd = (JSPUtil.getParameter(request, prefix + "spcl_cgo_cate_cd", length));
            String[] prnrSpclCgoSeq = (JSPUtil.getParameter(request, prefix + "prnr_spcl_cgo_seq", length));
            String[] ackSubSeq = (JSPUtil.getParameter(request, prefix + "ack_sub_seq", length));
            String[] ediMsgId = (JSPUtil.getParameter(request, prefix + "edi_msg_id", length));
            String[] ediSndrId = (JSPUtil.getParameter(request, prefix + "edi_sndr_id", length));
            String[] ediRcvrId = (JSPUtil.getParameter(request, prefix + "edi_rcvr_id", length));
            String[] ediIfId = (JSPUtil.getParameter(request, prefix + "edi_if_id", length));
            String[] trsmStsCd = (JSPUtil.getParameter(request, prefix + "trsm_sts_cd", length));
            String[] ediHdrMsg = (JSPUtil.getParameter(request, prefix + "edi_hdr_msg", length));
            String[] orgMsgRcvrNm = (JSPUtil.getParameter(request, prefix + "org_msg_rcvr_nm", length));
            String[] orgMsgKeyNo = (JSPUtil.getParameter(request, prefix + "org_msg_key_no", length));
            String[] orgMsgTpCd = (JSPUtil.getParameter(request, prefix + "org_msg_tp_cd", length));
            String[] msgUpdFlg = (JSPUtil.getParameter(request, prefix + "msg_upd_flg", length));
            String[] orgMsgNm = (JSPUtil.getParameter(request, prefix + "org_msg_nm", length));
            String[] msgAckTpCd = (JSPUtil.getParameter(request, prefix + "msg_ack_tp_cd", length));
            String[] msgAckRsltCd = (JSPUtil.getParameter(request, prefix + "msg_ack_rslt_cd", length));
            String[] msgAckLoclDt = (JSPUtil.getParameter(request, prefix + "msg_ack_locl_dt", length));
            String[] msgAckGdt = (JSPUtil.getParameter(request, prefix + "msg_ack_gdt", length));
            String[] msgRjctRsn = (JSPUtil.getParameter(request, prefix + "msg_rjct_rsn", length));
            String[] msgAcptRefNo = (JSPUtil.getParameter(request, prefix + "msg_acpt_ref_no", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] errDtlCd = (JSPUtil.getParameter(request, prefix + "err_dtl_cd", length));
            String[] msgRjctCd = (JSPUtil.getParameter(request, prefix + "msg_rjct_cd", length));
            String[] orgMsgRcvDt = (JSPUtil.getParameter(request, prefix + "org_msg_rcv_dt", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new ScgPrnrSpclCgoTrsmAckVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (trsmBndCd[i] != null)
                    model.setTrsmBndCd(trsmBndCd[i]);
                if (trsmDt[i] != null)
                    model.setTrsmDt(trsmDt[i]);
                if (spclCgoCateCd[i] != null)
                    model.setSpclCgoCateCd(spclCgoCateCd[i]);
                if (prnrSpclCgoSeq[i] != null)
                    model.setPrnrSpclCgoSeq(prnrSpclCgoSeq[i]);
                if (ackSubSeq[i] != null)
                    model.setAckSubSeq(ackSubSeq[i]);
                if (ediMsgId[i] != null)
                    model.setEdiMsgId(ediMsgId[i]);
                if (ediSndrId[i] != null)
                    model.setEdiSndrId(ediSndrId[i]);
                if (ediRcvrId[i] != null)
                    model.setEdiRcvrId(ediRcvrId[i]);
                if (ediIfId[i] != null)
                    model.setEdiIfId(ediIfId[i]);
                if (trsmStsCd[i] != null)
                    model.setTrsmStsCd(trsmStsCd[i]);
                if (ediHdrMsg[i] != null)
                    model.setEdiHdrMsg(ediHdrMsg[i]);
                if (orgMsgRcvrNm[i] != null)
                    model.setOrgMsgRcvrNm(orgMsgRcvrNm[i]);
                if (orgMsgKeyNo[i] != null)
                    model.setOrgMsgKeyNo(orgMsgKeyNo[i]);
                if (orgMsgTpCd[i] != null)
                    model.setOrgMsgTpCd(orgMsgTpCd[i]);
                if (msgUpdFlg[i] != null)
                    model.setMsgUpdFlg(msgUpdFlg[i]);
                if (orgMsgNm[i] != null)
                    model.setOrgMsgNm(orgMsgNm[i]);
                if (msgAckTpCd[i] != null)
                    model.setMsgAckTpCd(msgAckTpCd[i]);
                if (msgAckRsltCd[i] != null)
                    model.setMsgAckRsltCd(msgAckRsltCd[i]);
                if (msgAckLoclDt[i] != null)
                    model.setMsgAckLoclDt(msgAckLoclDt[i]);
                if (msgAckGdt[i] != null)
                    model.setMsgAckGdt(msgAckGdt[i]);
                if (msgRjctRsn[i] != null)
                    model.setMsgRjctRsn(msgRjctRsn[i]);
                if (msgAcptRefNo[i] != null)
                    model.setMsgAcptRefNo(msgAcptRefNo[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (updDt[i] != null) 
                    model.setUpdDt(updDt[i]);
                if (errDtlCd[i] != null)
                    model.setErrDtlCd(errDtlCd[i]);
                if (msgRjctCd[i] != null)
                    model.setMsgRjctCd(msgRjctCd[i]);
                if (orgMsgRcvDt[i] != null) 
		    		model.setOrgMsgRcvDt(orgMsgRcvDt[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getScgPrnrSpclCgoTrsmAckVOs();
    }

    /**
	 *  VO 배열을 반환
	 * @return ScgPrnrSpclCgoTrsmAckVO[]
	 */
    public ScgPrnrSpclCgoTrsmAckVO[] getScgPrnrSpclCgoTrsmAckVOs() {
        ScgPrnrSpclCgoTrsmAckVO[] vos = (ScgPrnrSpclCgoTrsmAckVO[]) models.toArray(new ScgPrnrSpclCgoTrsmAckVO[models.size()]);
        return vos;
    }

    /**
	 * VO Class의 내용을 String으로 변환
	 */
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    /**
	 * 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	 */
    public void unDataFormat() {
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trsmBndCd = this.trsmBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trsmDt = this.trsmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoCateCd = this.spclCgoCateCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prnrSpclCgoSeq = this.prnrSpclCgoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ackSubSeq = this.ackSubSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediMsgId = this.ediMsgId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediSndrId = this.ediSndrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediRcvrId = this.ediRcvrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediIfId = this.ediIfId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trsmStsCd = this.trsmStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediHdrMsg = this.ediHdrMsg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orgMsgRcvrNm = this.orgMsgRcvrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orgMsgKeyNo = this.orgMsgKeyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orgMsgTpCd = this.orgMsgTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.msgUpdFlg = this.msgUpdFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orgMsgNm = this.orgMsgNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.msgAckTpCd = this.msgAckTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.msgAckRsltCd = this.msgAckRsltCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.msgAckLoclDt = this.msgAckLoclDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.msgAckGdt = this.msgAckGdt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.msgRjctRsn = this.msgRjctRsn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.msgAcptRefNo = this.msgAcptRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.errDtlCd = this.errDtlCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.msgRjctCd = this.msgRjctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orgMsgRcvDt = this.orgMsgRcvDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
