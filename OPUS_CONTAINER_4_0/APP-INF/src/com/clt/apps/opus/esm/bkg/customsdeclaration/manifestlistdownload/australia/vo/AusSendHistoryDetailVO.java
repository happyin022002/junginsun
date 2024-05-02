/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AusSendHistoryDetailVO.java
*@FileTitle : AusSendHistoryDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.25  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.vo;

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
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AusSendHistoryDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AusSendHistoryDetailVO> models = new ArrayList<AusSendHistoryDetailVO>();
	
	/* Column Info */
	private String ibVvdCd = null;
	/* Column Info */
	private String ttlPckTpNm = null;
	/* Column Info */
	private String eurPckDesc = null;
	/* Column Info */
	private String cstmsErrId = null;
	/* Column Info */
	private String msgRcvNo = null;
	/* Column Info */
	private String dgTtlWgt = null;
	/* Column Info */
	private String sndDt = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String rcvLogErrSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String eurDgDeclTpCd = null;
	/* Column Info */
	private String rcvLogSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Column Info */
	private String netWgt = null;
	/* Column Info */
	private String cstmsErrMsg = null;
	/* Column Info */
	private String aproDt = null;
	/* Column Info */
	private String cntrCgoSeq = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String sndUsrId = null;
	/* Column Info */
	private String ackRcvStsCd = null;
	/* Column Info */
	private String hzdDesc = null;
	/* Column Info */
	private String grsWgt = null;
	/* Column Info */
	private String imdgClssCd = null;
	/* Column Info */
	private String imdgPckGrpCd = null;
	/* Column Info */
	private String imoNo = null;
	/* Column Info */
	private String flshPntCdoTemp = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String cntrTtlErrKnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String errCntrStsCd = null;
	/* Column Info */
	private String msgFuncId = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String ttlPckQty = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String scrFileNo = null;
	/* Column Info */
	private String tranId = null;
	/* Column Info */
	private String cntrTtlScsKnt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String cstmsErrRefNo2 = null;
	/* Column Info */
	private String cntrTtlKnt = null;
	/* Column Info */
	private String cstmsErrRefNo1 = null;
	/* Column Info */
	private String ackDt = null;
	/* Column Info */
	private String ausEdiMsgTpId = null;
	/* Column Info */
	private String autoSndTpCd = null;
	/* Column Info */
	private String tnkCntrTpszFlg = null;
	/* Column Info */
	private String ausVslNm = null;
	/* Column Info */
	private String cntrHndlKndCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String obVvdCd = null;
	/* Column Info */
	private String prpShpNm = null;
	/* Column Info */
	private String psaDgDeclTpCd = null;
	/* Column Info */
	private String msgSndNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AusSendHistoryDetailVO() {}

	public AusSendHistoryDetailVO(String ibflag, String pagerows, String ackDt, String ackRcvStsCd, String aproDt, String ausEdiMsgTpId, String ausVslNm, String autoSndTpCd, String blNo, String cntrCgoSeq, String cntrHndlKndCd, String cntrNo, String cntrTtlErrKnt, String cntrTtlKnt, String cntrTtlScsKnt, String creDt, String creUsrId, String cstmsErrId, String cstmsErrMsg, String cstmsErrRefNo1, String cstmsErrRefNo2, String dgTtlWgt, String errCntrStsCd, String eurDgDeclTpCd, String eurPckDesc, String flshPntCdoTemp, String grsWgt, String hzdDesc, String ibVvdCd, String imdgClssCd, String imdgPckGrpCd, String imdgUnNo, String imoNo, String msgFuncId, String msgRcvNo, String msgSndNo, String netWgt, String obVvdCd, String pckQty, String portCd, String prpShpNm, String psaDgDeclTpCd, String rcvLogErrSeq, String rcvLogSeq, String scrFileNo, String sndDt, String sndUsrId, String tnkCntrTpszFlg, String tranId, String ttlPckQty, String ttlPckTpNm, String updDt, String updUsrId, String vvdCd) {
		this.ibVvdCd = ibVvdCd;
		this.ttlPckTpNm = ttlPckTpNm;
		this.eurPckDesc = eurPckDesc;
		this.cstmsErrId = cstmsErrId;
		this.msgRcvNo = msgRcvNo;
		this.dgTtlWgt = dgTtlWgt;
		this.sndDt = sndDt;
		this.blNo = blNo;
		this.rcvLogErrSeq = rcvLogErrSeq;
		this.pagerows = pagerows;
		this.vvdCd = vvdCd;
		this.eurDgDeclTpCd = eurDgDeclTpCd;
		this.rcvLogSeq = rcvLogSeq;
		this.updUsrId = updUsrId;
		this.imdgUnNo = imdgUnNo;
		this.netWgt = netWgt;
		this.cstmsErrMsg = cstmsErrMsg;
		this.aproDt = aproDt;
		this.cntrCgoSeq = cntrCgoSeq;
		this.creUsrId = creUsrId;
		this.sndUsrId = sndUsrId;
		this.ackRcvStsCd = ackRcvStsCd;
		this.hzdDesc = hzdDesc;
		this.grsWgt = grsWgt;
		this.imdgClssCd = imdgClssCd;
		this.imdgPckGrpCd = imdgPckGrpCd;
		this.imoNo = imoNo;
		this.flshPntCdoTemp = flshPntCdoTemp;
		this.creDt = creDt;
		this.cntrTtlErrKnt = cntrTtlErrKnt;
		this.ibflag = ibflag;
		this.errCntrStsCd = errCntrStsCd;
		this.msgFuncId = msgFuncId;
		this.pckQty = pckQty;
		this.ttlPckQty = ttlPckQty;
		this.portCd = portCd;
		this.scrFileNo = scrFileNo;
		this.tranId = tranId;
		this.cntrTtlScsKnt = cntrTtlScsKnt;
		this.updDt = updDt;
		this.cstmsErrRefNo2 = cstmsErrRefNo2;
		this.cntrTtlKnt = cntrTtlKnt;
		this.cstmsErrRefNo1 = cstmsErrRefNo1;
		this.ackDt = ackDt;
		this.ausEdiMsgTpId = ausEdiMsgTpId;
		this.autoSndTpCd = autoSndTpCd;
		this.tnkCntrTpszFlg = tnkCntrTpszFlg;
		this.ausVslNm = ausVslNm;
		this.cntrHndlKndCd = cntrHndlKndCd;
		this.cntrNo = cntrNo;
		this.obVvdCd = obVvdCd;
		this.prpShpNm = prpShpNm;
		this.psaDgDeclTpCd = psaDgDeclTpCd;
		this.msgSndNo = msgSndNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ib_vvd_cd", getIbVvdCd());
		this.hashColumns.put("ttl_pck_tp_nm", getTtlPckTpNm());
		this.hashColumns.put("eur_pck_desc", getEurPckDesc());
		this.hashColumns.put("cstms_err_id", getCstmsErrId());
		this.hashColumns.put("msg_rcv_no", getMsgRcvNo());
		this.hashColumns.put("dg_ttl_wgt", getDgTtlWgt());
		this.hashColumns.put("snd_dt", getSndDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("rcv_log_err_seq", getRcvLogErrSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("eur_dg_decl_tp_cd", getEurDgDeclTpCd());
		this.hashColumns.put("rcv_log_seq", getRcvLogSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("net_wgt", getNetWgt());
		this.hashColumns.put("cstms_err_msg", getCstmsErrMsg());
		this.hashColumns.put("apro_dt", getAproDt());
		this.hashColumns.put("cntr_cgo_seq", getCntrCgoSeq());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("snd_usr_id", getSndUsrId());
		this.hashColumns.put("ack_rcv_sts_cd", getAckRcvStsCd());
		this.hashColumns.put("hzd_desc", getHzdDesc());
		this.hashColumns.put("grs_wgt", getGrsWgt());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		this.hashColumns.put("imdg_pck_grp_cd", getImdgPckGrpCd());
		this.hashColumns.put("imo_no", getImoNo());
		this.hashColumns.put("flsh_pnt_cdo_temp", getFlshPntCdoTemp());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cntr_ttl_err_knt", getCntrTtlErrKnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("err_cntr_sts_cd", getErrCntrStsCd());
		this.hashColumns.put("msg_func_id", getMsgFuncId());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("ttl_pck_qty", getTtlPckQty());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("scr_file_no", getScrFileNo());
		this.hashColumns.put("tran_id", getTranId());
		this.hashColumns.put("cntr_ttl_scs_knt", getCntrTtlScsKnt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cstms_err_ref_no2", getCstmsErrRefNo2());
		this.hashColumns.put("cntr_ttl_knt", getCntrTtlKnt());
		this.hashColumns.put("cstms_err_ref_no1", getCstmsErrRefNo1());
		this.hashColumns.put("ack_dt", getAckDt());
		this.hashColumns.put("aus_edi_msg_tp_id", getAusEdiMsgTpId());
		this.hashColumns.put("auto_snd_tp_cd", getAutoSndTpCd());
		this.hashColumns.put("tnk_cntr_tpsz_flg", getTnkCntrTpszFlg());
		this.hashColumns.put("aus_vsl_nm", getAusVslNm());
		this.hashColumns.put("cntr_hndl_knd_cd", getCntrHndlKndCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("ob_vvd_cd", getObVvdCd());
		this.hashColumns.put("prp_shp_nm", getPrpShpNm());
		this.hashColumns.put("psa_dg_decl_tp_cd", getPsaDgDeclTpCd());
		this.hashColumns.put("msg_snd_no", getMsgSndNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ib_vvd_cd", "ibVvdCd");
		this.hashFields.put("ttl_pck_tp_nm", "ttlPckTpNm");
		this.hashFields.put("eur_pck_desc", "eurPckDesc");
		this.hashFields.put("cstms_err_id", "cstmsErrId");
		this.hashFields.put("msg_rcv_no", "msgRcvNo");
		this.hashFields.put("dg_ttl_wgt", "dgTtlWgt");
		this.hashFields.put("snd_dt", "sndDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("rcv_log_err_seq", "rcvLogErrSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("eur_dg_decl_tp_cd", "eurDgDeclTpCd");
		this.hashFields.put("rcv_log_seq", "rcvLogSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("net_wgt", "netWgt");
		this.hashFields.put("cstms_err_msg", "cstmsErrMsg");
		this.hashFields.put("apro_dt", "aproDt");
		this.hashFields.put("cntr_cgo_seq", "cntrCgoSeq");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("snd_usr_id", "sndUsrId");
		this.hashFields.put("ack_rcv_sts_cd", "ackRcvStsCd");
		this.hashFields.put("hzd_desc", "hzdDesc");
		this.hashFields.put("grs_wgt", "grsWgt");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("imdg_pck_grp_cd", "imdgPckGrpCd");
		this.hashFields.put("imo_no", "imoNo");
		this.hashFields.put("flsh_pnt_cdo_temp", "flshPntCdoTemp");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cntr_ttl_err_knt", "cntrTtlErrKnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("err_cntr_sts_cd", "errCntrStsCd");
		this.hashFields.put("msg_func_id", "msgFuncId");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("ttl_pck_qty", "ttlPckQty");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("scr_file_no", "scrFileNo");
		this.hashFields.put("tran_id", "tranId");
		this.hashFields.put("cntr_ttl_scs_knt", "cntrTtlScsKnt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cstms_err_ref_no2", "cstmsErrRefNo2");
		this.hashFields.put("cntr_ttl_knt", "cntrTtlKnt");
		this.hashFields.put("cstms_err_ref_no1", "cstmsErrRefNo1");
		this.hashFields.put("ack_dt", "ackDt");
		this.hashFields.put("aus_edi_msg_tp_id", "ausEdiMsgTpId");
		this.hashFields.put("auto_snd_tp_cd", "autoSndTpCd");
		this.hashFields.put("tnk_cntr_tpsz_flg", "tnkCntrTpszFlg");
		this.hashFields.put("aus_vsl_nm", "ausVslNm");
		this.hashFields.put("cntr_hndl_knd_cd", "cntrHndlKndCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("ob_vvd_cd", "obVvdCd");
		this.hashFields.put("prp_shp_nm", "prpShpNm");
		this.hashFields.put("psa_dg_decl_tp_cd", "psaDgDeclTpCd");
		this.hashFields.put("msg_snd_no", "msgSndNo");
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
	 * @return eurPckDesc
	 */
	public String getEurPckDesc() {
		return this.eurPckDesc;
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
	 * @return sndDt
	 */
	public String getSndDt() {
		return this.sndDt;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return eurDgDeclTpCd
	 */
	public String getEurDgDeclTpCd() {
		return this.eurDgDeclTpCd;
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
	 * @return netWgt
	 */
	public String getNetWgt() {
		return this.netWgt;
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
	 * @return aproDt
	 */
	public String getAproDt() {
		return this.aproDt;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return sndUsrId
	 */
	public String getSndUsrId() {
		return this.sndUsrId;
	}
	
	/**
	 * Column Info
	 * @return ackRcvStsCd
	 */
	public String getAckRcvStsCd() {
		return this.ackRcvStsCd;
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
	 * @return grsWgt
	 */
	public String getGrsWgt() {
		return this.grsWgt;
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
	 * @return imdgPckGrpCd
	 */
	public String getImdgPckGrpCd() {
		return this.imdgPckGrpCd;
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
	 * @return flshPntCdoTemp
	 */
	public String getFlshPntCdoTemp() {
		return this.flshPntCdoTemp;
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
	 * @return msgFuncId
	 */
	public String getMsgFuncId() {
		return this.msgFuncId;
	}
	
	/**
	 * Column Info
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
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
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
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
	 * @return tranId
	 */
	public String getTranId() {
		return this.tranId;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
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
	 * @return cntrTtlKnt
	 */
	public String getCntrTtlKnt() {
		return this.cntrTtlKnt;
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
	 * @return ackDt
	 */
	public String getAckDt() {
		return this.ackDt;
	}
	
	/**
	 * Column Info
	 * @return ausEdiMsgTpId
	 */
	public String getAusEdiMsgTpId() {
		return this.ausEdiMsgTpId;
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
	 * @return tnkCntrTpszFlg
	 */
	public String getTnkCntrTpszFlg() {
		return this.tnkCntrTpszFlg;
	}
	
	/**
	 * Column Info
	 * @return ausVslNm
	 */
	public String getAusVslNm() {
		return this.ausVslNm;
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
	 * @return prpShpNm
	 */
	public String getPrpShpNm() {
		return this.prpShpNm;
	}
	
	/**
	 * Column Info
	 * @return psaDgDeclTpCd
	 */
	public String getPsaDgDeclTpCd() {
		return this.psaDgDeclTpCd;
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
	 * @param eurPckDesc
	 */
	public void setEurPckDesc(String eurPckDesc) {
		this.eurPckDesc = eurPckDesc;
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
	 * @param sndDt
	 */
	public void setSndDt(String sndDt) {
		this.sndDt = sndDt;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param eurDgDeclTpCd
	 */
	public void setEurDgDeclTpCd(String eurDgDeclTpCd) {
		this.eurDgDeclTpCd = eurDgDeclTpCd;
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
	 * @param netWgt
	 */
	public void setNetWgt(String netWgt) {
		this.netWgt = netWgt;
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
	 * @param aproDt
	 */
	public void setAproDt(String aproDt) {
		this.aproDt = aproDt;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param sndUsrId
	 */
	public void setSndUsrId(String sndUsrId) {
		this.sndUsrId = sndUsrId;
	}
	
	/**
	 * Column Info
	 * @param ackRcvStsCd
	 */
	public void setAckRcvStsCd(String ackRcvStsCd) {
		this.ackRcvStsCd = ackRcvStsCd;
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
	 * @param grsWgt
	 */
	public void setGrsWgt(String grsWgt) {
		this.grsWgt = grsWgt;
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
	 * @param imdgPckGrpCd
	 */
	public void setImdgPckGrpCd(String imdgPckGrpCd) {
		this.imdgPckGrpCd = imdgPckGrpCd;
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
	 * @param flshPntCdoTemp
	 */
	public void setFlshPntCdoTemp(String flshPntCdoTemp) {
		this.flshPntCdoTemp = flshPntCdoTemp;
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
	 * @param msgFuncId
	 */
	public void setMsgFuncId(String msgFuncId) {
		this.msgFuncId = msgFuncId;
	}
	
	/**
	 * Column Info
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
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
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
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
	 * @param tranId
	 */
	public void setTranId(String tranId) {
		this.tranId = tranId;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param cntrTtlKnt
	 */
	public void setCntrTtlKnt(String cntrTtlKnt) {
		this.cntrTtlKnt = cntrTtlKnt;
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
	 * @param ackDt
	 */
	public void setAckDt(String ackDt) {
		this.ackDt = ackDt;
	}
	
	/**
	 * Column Info
	 * @param ausEdiMsgTpId
	 */
	public void setAusEdiMsgTpId(String ausEdiMsgTpId) {
		this.ausEdiMsgTpId = ausEdiMsgTpId;
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
	 * @param tnkCntrTpszFlg
	 */
	public void setTnkCntrTpszFlg(String tnkCntrTpszFlg) {
		this.tnkCntrTpszFlg = tnkCntrTpszFlg;
	}
	
	/**
	 * Column Info
	 * @param ausVslNm
	 */
	public void setAusVslNm(String ausVslNm) {
		this.ausVslNm = ausVslNm;
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
	 * Column Info
	 * @param prpShpNm
	 */
	public void setPrpShpNm(String prpShpNm) {
		this.prpShpNm = prpShpNm;
	}
	
	/**
	 * Column Info
	 * @param psaDgDeclTpCd
	 */
	public void setPsaDgDeclTpCd(String psaDgDeclTpCd) {
		this.psaDgDeclTpCd = psaDgDeclTpCd;
	}
	
	/**
	 * Column Info
	 * @param msgSndNo
	 */
	public void setMsgSndNo(String msgSndNo) {
		this.msgSndNo = msgSndNo;
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
		setEurPckDesc(JSPUtil.getParameter(request, prefix + "eur_pck_desc", ""));
		setCstmsErrId(JSPUtil.getParameter(request, prefix + "cstms_err_id", ""));
		setMsgRcvNo(JSPUtil.getParameter(request, prefix + "msg_rcv_no", ""));
		setDgTtlWgt(JSPUtil.getParameter(request, prefix + "dg_ttl_wgt", ""));
		setSndDt(JSPUtil.getParameter(request, prefix + "snd_dt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setRcvLogErrSeq(JSPUtil.getParameter(request, prefix + "rcv_log_err_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setEurDgDeclTpCd(JSPUtil.getParameter(request, prefix + "eur_dg_decl_tp_cd", ""));
		setRcvLogSeq(JSPUtil.getParameter(request, prefix + "rcv_log_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setImdgUnNo(JSPUtil.getParameter(request, prefix + "imdg_un_no", ""));
		setNetWgt(JSPUtil.getParameter(request, prefix + "net_wgt", ""));
		setCstmsErrMsg(JSPUtil.getParameter(request, prefix + "cstms_err_msg", ""));
		setAproDt(JSPUtil.getParameter(request, prefix + "apro_dt", ""));
		setCntrCgoSeq(JSPUtil.getParameter(request, prefix + "cntr_cgo_seq", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setSndUsrId(JSPUtil.getParameter(request, prefix + "snd_usr_id", ""));
		setAckRcvStsCd(JSPUtil.getParameter(request, prefix + "ack_rcv_sts_cd", ""));
		setHzdDesc(JSPUtil.getParameter(request, prefix + "hzd_desc", ""));
		setGrsWgt(JSPUtil.getParameter(request, prefix + "grs_wgt", ""));
		setImdgClssCd(JSPUtil.getParameter(request, prefix + "imdg_clss_cd", ""));
		setImdgPckGrpCd(JSPUtil.getParameter(request, prefix + "imdg_pck_grp_cd", ""));
		setImoNo(JSPUtil.getParameter(request, prefix + "imo_no", ""));
		setFlshPntCdoTemp(JSPUtil.getParameter(request, prefix + "flsh_pnt_cdo_temp", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCntrTtlErrKnt(JSPUtil.getParameter(request, prefix + "cntr_ttl_err_knt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setErrCntrStsCd(JSPUtil.getParameter(request, prefix + "err_cntr_sts_cd", ""));
		setMsgFuncId(JSPUtil.getParameter(request, prefix + "msg_func_id", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setTtlPckQty(JSPUtil.getParameter(request, prefix + "ttl_pck_qty", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setScrFileNo(JSPUtil.getParameter(request, prefix + "scr_file_no", ""));
		setTranId(JSPUtil.getParameter(request, prefix + "tran_id", ""));
		setCntrTtlScsKnt(JSPUtil.getParameter(request, prefix + "cntr_ttl_scs_knt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCstmsErrRefNo2(JSPUtil.getParameter(request, prefix + "cstms_err_ref_no2", ""));
		setCntrTtlKnt(JSPUtil.getParameter(request, prefix + "cntr_ttl_knt", ""));
		setCstmsErrRefNo1(JSPUtil.getParameter(request, prefix + "cstms_err_ref_no1", ""));
		setAckDt(JSPUtil.getParameter(request, prefix + "ack_dt", ""));
		setAusEdiMsgTpId(JSPUtil.getParameter(request, prefix + "aus_edi_msg_tp_id", ""));
		setAutoSndTpCd(JSPUtil.getParameter(request, prefix + "auto_snd_tp_cd", ""));
		setTnkCntrTpszFlg(JSPUtil.getParameter(request, prefix + "tnk_cntr_tpsz_flg", ""));
		setAusVslNm(JSPUtil.getParameter(request, prefix + "aus_vsl_nm", ""));
		setCntrHndlKndCd(JSPUtil.getParameter(request, prefix + "cntr_hndl_knd_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setObVvdCd(JSPUtil.getParameter(request, prefix + "ob_vvd_cd", ""));
		setPrpShpNm(JSPUtil.getParameter(request, prefix + "prp_shp_nm", ""));
		setPsaDgDeclTpCd(JSPUtil.getParameter(request, prefix + "psa_dg_decl_tp_cd", ""));
		setMsgSndNo(JSPUtil.getParameter(request, prefix + "msg_snd_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AusSendHistoryDetailVO[]
	 */
	public AusSendHistoryDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AusSendHistoryDetailVO[]
	 */
	public AusSendHistoryDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AusSendHistoryDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibVvdCd = (JSPUtil.getParameter(request, prefix	+ "ib_vvd_cd", length));
			String[] ttlPckTpNm = (JSPUtil.getParameter(request, prefix	+ "ttl_pck_tp_nm", length));
			String[] eurPckDesc = (JSPUtil.getParameter(request, prefix	+ "eur_pck_desc", length));
			String[] cstmsErrId = (JSPUtil.getParameter(request, prefix	+ "cstms_err_id", length));
			String[] msgRcvNo = (JSPUtil.getParameter(request, prefix	+ "msg_rcv_no", length));
			String[] dgTtlWgt = (JSPUtil.getParameter(request, prefix	+ "dg_ttl_wgt", length));
			String[] sndDt = (JSPUtil.getParameter(request, prefix	+ "snd_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] rcvLogErrSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_log_err_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] eurDgDeclTpCd = (JSPUtil.getParameter(request, prefix	+ "eur_dg_decl_tp_cd", length));
			String[] rcvLogSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_log_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			String[] netWgt = (JSPUtil.getParameter(request, prefix	+ "net_wgt", length));
			String[] cstmsErrMsg = (JSPUtil.getParameter(request, prefix	+ "cstms_err_msg", length));
			String[] aproDt = (JSPUtil.getParameter(request, prefix	+ "apro_dt", length));
			String[] cntrCgoSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_cgo_seq", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] sndUsrId = (JSPUtil.getParameter(request, prefix	+ "snd_usr_id", length));
			String[] ackRcvStsCd = (JSPUtil.getParameter(request, prefix	+ "ack_rcv_sts_cd", length));
			String[] hzdDesc = (JSPUtil.getParameter(request, prefix	+ "hzd_desc", length));
			String[] grsWgt = (JSPUtil.getParameter(request, prefix	+ "grs_wgt", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			String[] imdgPckGrpCd = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_grp_cd", length));
			String[] imoNo = (JSPUtil.getParameter(request, prefix	+ "imo_no", length));
			String[] flshPntCdoTemp = (JSPUtil.getParameter(request, prefix	+ "flsh_pnt_cdo_temp", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] cntrTtlErrKnt = (JSPUtil.getParameter(request, prefix	+ "cntr_ttl_err_knt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] errCntrStsCd = (JSPUtil.getParameter(request, prefix	+ "err_cntr_sts_cd", length));
			String[] msgFuncId = (JSPUtil.getParameter(request, prefix	+ "msg_func_id", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] ttlPckQty = (JSPUtil.getParameter(request, prefix	+ "ttl_pck_qty", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] scrFileNo = (JSPUtil.getParameter(request, prefix	+ "scr_file_no", length));
			String[] tranId = (JSPUtil.getParameter(request, prefix	+ "tran_id", length));
			String[] cntrTtlScsKnt = (JSPUtil.getParameter(request, prefix	+ "cntr_ttl_scs_knt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] cstmsErrRefNo2 = (JSPUtil.getParameter(request, prefix	+ "cstms_err_ref_no2", length));
			String[] cntrTtlKnt = (JSPUtil.getParameter(request, prefix	+ "cntr_ttl_knt", length));
			String[] cstmsErrRefNo1 = (JSPUtil.getParameter(request, prefix	+ "cstms_err_ref_no1", length));
			String[] ackDt = (JSPUtil.getParameter(request, prefix	+ "ack_dt", length));
			String[] ausEdiMsgTpId = (JSPUtil.getParameter(request, prefix	+ "aus_edi_msg_tp_id", length));
			String[] autoSndTpCd = (JSPUtil.getParameter(request, prefix	+ "auto_snd_tp_cd", length));
			String[] tnkCntrTpszFlg = (JSPUtil.getParameter(request, prefix	+ "tnk_cntr_tpsz_flg", length));
			String[] ausVslNm = (JSPUtil.getParameter(request, prefix	+ "aus_vsl_nm", length));
			String[] cntrHndlKndCd = (JSPUtil.getParameter(request, prefix	+ "cntr_hndl_knd_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] obVvdCd = (JSPUtil.getParameter(request, prefix	+ "ob_vvd_cd", length));
			String[] prpShpNm = (JSPUtil.getParameter(request, prefix	+ "prp_shp_nm", length));
			String[] psaDgDeclTpCd = (JSPUtil.getParameter(request, prefix	+ "psa_dg_decl_tp_cd", length));
			String[] msgSndNo = (JSPUtil.getParameter(request, prefix	+ "msg_snd_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new AusSendHistoryDetailVO();
				if (ibVvdCd[i] != null)
					model.setIbVvdCd(ibVvdCd[i]);
				if (ttlPckTpNm[i] != null)
					model.setTtlPckTpNm(ttlPckTpNm[i]);
				if (eurPckDesc[i] != null)
					model.setEurPckDesc(eurPckDesc[i]);
				if (cstmsErrId[i] != null)
					model.setCstmsErrId(cstmsErrId[i]);
				if (msgRcvNo[i] != null)
					model.setMsgRcvNo(msgRcvNo[i]);
				if (dgTtlWgt[i] != null)
					model.setDgTtlWgt(dgTtlWgt[i]);
				if (sndDt[i] != null)
					model.setSndDt(sndDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (rcvLogErrSeq[i] != null)
					model.setRcvLogErrSeq(rcvLogErrSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (eurDgDeclTpCd[i] != null)
					model.setEurDgDeclTpCd(eurDgDeclTpCd[i]);
				if (rcvLogSeq[i] != null)
					model.setRcvLogSeq(rcvLogSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (netWgt[i] != null)
					model.setNetWgt(netWgt[i]);
				if (cstmsErrMsg[i] != null)
					model.setCstmsErrMsg(cstmsErrMsg[i]);
				if (aproDt[i] != null)
					model.setAproDt(aproDt[i]);
				if (cntrCgoSeq[i] != null)
					model.setCntrCgoSeq(cntrCgoSeq[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (sndUsrId[i] != null)
					model.setSndUsrId(sndUsrId[i]);
				if (ackRcvStsCd[i] != null)
					model.setAckRcvStsCd(ackRcvStsCd[i]);
				if (hzdDesc[i] != null)
					model.setHzdDesc(hzdDesc[i]);
				if (grsWgt[i] != null)
					model.setGrsWgt(grsWgt[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				if (imdgPckGrpCd[i] != null)
					model.setImdgPckGrpCd(imdgPckGrpCd[i]);
				if (imoNo[i] != null)
					model.setImoNo(imoNo[i]);
				if (flshPntCdoTemp[i] != null)
					model.setFlshPntCdoTemp(flshPntCdoTemp[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (cntrTtlErrKnt[i] != null)
					model.setCntrTtlErrKnt(cntrTtlErrKnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (errCntrStsCd[i] != null)
					model.setErrCntrStsCd(errCntrStsCd[i]);
				if (msgFuncId[i] != null)
					model.setMsgFuncId(msgFuncId[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (ttlPckQty[i] != null)
					model.setTtlPckQty(ttlPckQty[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (scrFileNo[i] != null)
					model.setScrFileNo(scrFileNo[i]);
				if (tranId[i] != null)
					model.setTranId(tranId[i]);
				if (cntrTtlScsKnt[i] != null)
					model.setCntrTtlScsKnt(cntrTtlScsKnt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (cstmsErrRefNo2[i] != null)
					model.setCstmsErrRefNo2(cstmsErrRefNo2[i]);
				if (cntrTtlKnt[i] != null)
					model.setCntrTtlKnt(cntrTtlKnt[i]);
				if (cstmsErrRefNo1[i] != null)
					model.setCstmsErrRefNo1(cstmsErrRefNo1[i]);
				if (ackDt[i] != null)
					model.setAckDt(ackDt[i]);
				if (ausEdiMsgTpId[i] != null)
					model.setAusEdiMsgTpId(ausEdiMsgTpId[i]);
				if (autoSndTpCd[i] != null)
					model.setAutoSndTpCd(autoSndTpCd[i]);
				if (tnkCntrTpszFlg[i] != null)
					model.setTnkCntrTpszFlg(tnkCntrTpszFlg[i]);
				if (ausVslNm[i] != null)
					model.setAusVslNm(ausVslNm[i]);
				if (cntrHndlKndCd[i] != null)
					model.setCntrHndlKndCd(cntrHndlKndCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (obVvdCd[i] != null)
					model.setObVvdCd(obVvdCd[i]);
				if (prpShpNm[i] != null)
					model.setPrpShpNm(prpShpNm[i]);
				if (psaDgDeclTpCd[i] != null)
					model.setPsaDgDeclTpCd(psaDgDeclTpCd[i]);
				if (msgSndNo[i] != null)
					model.setMsgSndNo(msgSndNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAusSendHistoryDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AusSendHistoryDetailVO[]
	 */
	public AusSendHistoryDetailVO[] getAusSendHistoryDetailVOs(){
		AusSendHistoryDetailVO[] vos = (AusSendHistoryDetailVO[])models.toArray(new AusSendHistoryDetailVO[models.size()]);
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
		this.eurPckDesc = this.eurPckDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsErrId = this.cstmsErrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgRcvNo = this.msgRcvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgTtlWgt = this.dgTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDt = this.sndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvLogErrSeq = this.rcvLogErrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eurDgDeclTpCd = this.eurDgDeclTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvLogSeq = this.rcvLogSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netWgt = this.netWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsErrMsg = this.cstmsErrMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproDt = this.aproDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCgoSeq = this.cntrCgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndUsrId = this.sndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackRcvStsCd = this.ackRcvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hzdDesc = this.hzdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgt = this.grsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckGrpCd = this.imdgPckGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imoNo = this.imoNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flshPntCdoTemp = this.flshPntCdoTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTtlErrKnt = this.cntrTtlErrKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errCntrStsCd = this.errCntrStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgFuncId = this.msgFuncId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlPckQty = this.ttlPckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scrFileNo = this.scrFileNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tranId = this.tranId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTtlScsKnt = this.cntrTtlScsKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsErrRefNo2 = this.cstmsErrRefNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTtlKnt = this.cntrTtlKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsErrRefNo1 = this.cstmsErrRefNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackDt = this.ackDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ausEdiMsgTpId = this.ausEdiMsgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoSndTpCd = this.autoSndTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tnkCntrTpszFlg = this.tnkCntrTpszFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ausVslNm = this.ausVslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHndlKndCd = this.cntrHndlKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obVvdCd = this.obVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prpShpNm = this.prpShpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psaDgDeclTpCd = this.psaDgDeclTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgSndNo = this.msgSndNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
