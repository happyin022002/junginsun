/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SceActRcvIfVO.java
*@FileTitle : SceActRcvIfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.09  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.copdetailreceive.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SceActRcvIfVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SceActRcvIfVO> models = new ArrayList<SceActRcvIfVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String cnmvSeq = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String trdCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String actRcvNo = null;
	/* Column Info */
	private String vndrNm = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* Column Info */
	private String ediSndRsltFlg = null;
	/* Column Info */
	private String vslDlayRsnDesc = null;
	/* Column Info */
	private String emlSndRsltFlg = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String actCd = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String actRcvTpCd = null;
	/* Column Info */
	private String vpsLocCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String ediMsgTpCd = null;
	/* Column Info */
	private String cnmvIdNo = null;
	/* Column Info */
	private String faxSndRsltFlg = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String callYdIndCngFlg = null;
	/* Column Info */
	private String errMsg = null;
	/* Column Info */
	private String copRltFlg = null;
	/* Column Info */
	private String nodCd = null;
	/* Column Info */
	private String preBkgNo = null;
	/* Column Info */
	private String actDatRcvDt = null;
	/* Column Info */
	private String vpsEtbDt = null;
	/* Column Info */
	private String actGdt = null;
	/* Column Info */
	private String cnmvCycNo = null;
	/* Column Info */
	private String bfActUmchTpCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String copUpdRmk = null;
	/* Column Info */
	private String actStsMapgCd = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Column Info */
	private String actUmchTpCd = null;
	/* Column Info */
	private String cnmvSplitNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vslDlayRsnCd = null;
	/* Column Info */
	private String bndVskdSeqCd = null;
	/* Column Info */
	private String callYdIndSeq = null;
	/* Column Info */
	private String railDestN1stEtaDt = null;
	/* Column Info */
	private String creTpCd = null;
	/* Column Info */
	private String rtyRsltFlg = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String beforeActUmchTpCd = null;
	/* Column Info */
	private String copDtlSeq = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String umchChkDt = null;
	/* Column Info */
	private String actDt = null;
	/* Column Info */
	private String copEvntSeq = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String imdtExtFlg = null;
	/* Column Info */
	private String cnmvYr = null;
	/* Column Info */
	private String actRcvDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SceActRcvIfVO() {}

	public SceActRcvIfVO(String ibflag, String pagerows, String vslCd, String cnmvSeq, String copNo, String trdCd, String actRcvNo, String vndrNm, String vpsPortCd, String ediSndRsltFlg, String vslDlayRsnDesc, String emlSndRsltFlg, String updUsrId, String actCd, String vpsEtdDt, String actRcvTpCd, String skdVoyNo, String vpsLocCd, String ediMsgTpCd, String faxSndRsltFlg, String cnmvIdNo, String bkgNo, String creUsrId, String vndrSeq, String errMsg, String copRltFlg, String nodCd, String preBkgNo, String actDatRcvDt, String vpsEtbDt, String actGdt, String cnmvCycNo, String creDt, String actStsMapgCd, String vpsEtaDt, String actUmchTpCd, String bfActUmchTpCd, String beforeActUmchTpCd, String cnmvSplitNo, String vslDlayRsnCd, String bndVskdSeqCd, String callYdIndSeq, String railDestN1stEtaDt, String creTpCd, String rtyRsltFlg, String updDt, String copDtlSeq, String skdDirCd, String copEvntSeq, String actDt, String umchChkDt, String cntrNo, String clptIndSeq, String imdtExtFlg, String actRcvDt, String cnmvYr, String callYdIndCngFlg, String copUpdRmk) {
		this.vslCd = vslCd;
		this.cnmvSeq = cnmvSeq;
		this.copNo = copNo;
		this.trdCd = trdCd;
		this.pagerows = pagerows;
		this.actRcvNo = actRcvNo;
		this.vndrNm = vndrNm;
		this.vpsPortCd = vpsPortCd;
		this.ediSndRsltFlg = ediSndRsltFlg;
		this.vslDlayRsnDesc = vslDlayRsnDesc;
		this.emlSndRsltFlg = emlSndRsltFlg;
		this.updUsrId = updUsrId;
		this.actCd = actCd;
		this.vpsEtdDt = vpsEtdDt;
		this.actRcvTpCd = actRcvTpCd;
		this.vpsLocCd = vpsLocCd;
		this.skdVoyNo = skdVoyNo;
		this.ediMsgTpCd = ediMsgTpCd;
		this.cnmvIdNo = cnmvIdNo;
		this.faxSndRsltFlg = faxSndRsltFlg;
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.vndrSeq = vndrSeq;
		this.callYdIndCngFlg = callYdIndCngFlg;
		this.errMsg = errMsg;
		this.copRltFlg = copRltFlg;
		this.nodCd = nodCd;
		this.preBkgNo = preBkgNo;
		this.actDatRcvDt = actDatRcvDt;
		this.vpsEtbDt = vpsEtbDt;
		this.actGdt = actGdt;
		this.cnmvCycNo = cnmvCycNo;
		this.bfActUmchTpCd = bfActUmchTpCd;
		this.creDt = creDt;
		this.copUpdRmk = copUpdRmk;
		this.actStsMapgCd = actStsMapgCd;
		this.vpsEtaDt = vpsEtaDt;
		this.actUmchTpCd = actUmchTpCd;
		this.cnmvSplitNo = cnmvSplitNo;
		this.ibflag = ibflag;
		this.vslDlayRsnCd = vslDlayRsnCd;
		this.bndVskdSeqCd = bndVskdSeqCd;
		this.callYdIndSeq = callYdIndSeq;
		this.railDestN1stEtaDt = railDestN1stEtaDt;
		this.creTpCd = creTpCd;
		this.rtyRsltFlg = rtyRsltFlg;
		this.updDt = updDt;
		this.beforeActUmchTpCd = beforeActUmchTpCd;
		this.copDtlSeq = copDtlSeq;
		this.skdDirCd = skdDirCd;
		this.umchChkDt = umchChkDt;
		this.actDt = actDt;
		this.copEvntSeq = copEvntSeq;
		this.cntrNo = cntrNo;
		this.clptIndSeq = clptIndSeq;
		this.imdtExtFlg = imdtExtFlg;
		this.cnmvYr = cnmvYr;
		this.actRcvDt = actRcvDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("cnmv_seq", getCnmvSeq());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("act_rcv_no", getActRcvNo());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("edi_snd_rslt_flg", getEdiSndRsltFlg());
		this.hashColumns.put("vsl_dlay_rsn_desc", getVslDlayRsnDesc());
		this.hashColumns.put("eml_snd_rslt_flg", getEmlSndRsltFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("act_cd", getActCd());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("act_rcv_tp_cd", getActRcvTpCd());
		this.hashColumns.put("vps_loc_cd", getVpsLocCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("edi_msg_tp_cd", getEdiMsgTpCd());
		this.hashColumns.put("cnmv_id_no", getCnmvIdNo());
		this.hashColumns.put("fax_snd_rslt_flg", getFaxSndRsltFlg());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("call_yd_ind_cng_flg", getCallYdIndCngFlg());
		this.hashColumns.put("err_msg", getErrMsg());
		this.hashColumns.put("cop_rlt_flg", getCopRltFlg());
		this.hashColumns.put("nod_cd", getNodCd());
		this.hashColumns.put("pre_bkg_no", getPreBkgNo());
		this.hashColumns.put("act_dat_rcv_dt", getActDatRcvDt());
		this.hashColumns.put("vps_etb_dt", getVpsEtbDt());
		this.hashColumns.put("act_gdt", getActGdt());
		this.hashColumns.put("cnmv_cyc_no", getCnmvCycNo());
		this.hashColumns.put("bf_act_umch_tp_cd", getBfActUmchTpCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cop_upd_rmk", getCopUpdRmk());
		this.hashColumns.put("act_sts_mapg_cd", getActStsMapgCd());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("act_umch_tp_cd", getActUmchTpCd());
		this.hashColumns.put("cnmv_split_no", getCnmvSplitNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_dlay_rsn_cd", getVslDlayRsnCd());
		this.hashColumns.put("bnd_vskd_seq_cd", getBndVskdSeqCd());
		this.hashColumns.put("call_yd_ind_seq", getCallYdIndSeq());
		this.hashColumns.put("rail_dest_n1st_eta_dt", getRailDestN1stEtaDt());
		this.hashColumns.put("cre_tp_cd", getCreTpCd());
		this.hashColumns.put("rty_rslt_flg", getRtyRsltFlg());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("before_act_umch_tp_cd", getBeforeActUmchTpCd());
		this.hashColumns.put("cop_dtl_seq", getCopDtlSeq());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("umch_chk_dt", getUmchChkDt());
		this.hashColumns.put("act_dt", getActDt());
		this.hashColumns.put("cop_evnt_seq", getCopEvntSeq());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("imdt_ext_flg", getImdtExtFlg());
		this.hashColumns.put("cnmv_yr", getCnmvYr());
		this.hashColumns.put("act_rcv_dt", getActRcvDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("cnmv_seq", "cnmvSeq");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("act_rcv_no", "actRcvNo");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("edi_snd_rslt_flg", "ediSndRsltFlg");
		this.hashFields.put("vsl_dlay_rsn_desc", "vslDlayRsnDesc");
		this.hashFields.put("eml_snd_rslt_flg", "emlSndRsltFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("act_cd", "actCd");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("act_rcv_tp_cd", "actRcvTpCd");
		this.hashFields.put("vps_loc_cd", "vpsLocCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("edi_msg_tp_cd", "ediMsgTpCd");
		this.hashFields.put("cnmv_id_no", "cnmvIdNo");
		this.hashFields.put("fax_snd_rslt_flg", "faxSndRsltFlg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("call_yd_ind_cng_flg", "callYdIndCngFlg");
		this.hashFields.put("err_msg", "errMsg");
		this.hashFields.put("cop_rlt_flg", "copRltFlg");
		this.hashFields.put("nod_cd", "nodCd");
		this.hashFields.put("pre_bkg_no", "preBkgNo");
		this.hashFields.put("act_dat_rcv_dt", "actDatRcvDt");
		this.hashFields.put("vps_etb_dt", "vpsEtbDt");
		this.hashFields.put("act_gdt", "actGdt");
		this.hashFields.put("cnmv_cyc_no", "cnmvCycNo");
		this.hashFields.put("bf_act_umch_tp_cd", "bfActUmchTpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cop_upd_rmk", "copUpdRmk");
		this.hashFields.put("act_sts_mapg_cd", "actStsMapgCd");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("act_umch_tp_cd", "actUmchTpCd");
		this.hashFields.put("cnmv_split_no", "cnmvSplitNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_dlay_rsn_cd", "vslDlayRsnCd");
		this.hashFields.put("bnd_vskd_seq_cd", "bndVskdSeqCd");
		this.hashFields.put("call_yd_ind_seq", "callYdIndSeq");
		this.hashFields.put("rail_dest_n1st_eta_dt", "railDestN1stEtaDt");
		this.hashFields.put("cre_tp_cd", "creTpCd");
		this.hashFields.put("rty_rslt_flg", "rtyRsltFlg");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("before_act_umch_tp_cd", "beforeActUmchTpCd");
		this.hashFields.put("cop_dtl_seq", "copDtlSeq");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("umch_chk_dt", "umchChkDt");
		this.hashFields.put("act_dt", "actDt");
		this.hashFields.put("cop_evnt_seq", "copEvntSeq");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("imdt_ext_flg", "imdtExtFlg");
		this.hashFields.put("cnmv_yr", "cnmvYr");
		this.hashFields.put("act_rcv_dt", "actRcvDt");
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
	 * @return cnmvSeq
	 */
	public String getCnmvSeq() {
		return this.cnmvSeq;
	}
	
	/**
	 * Column Info
	 * @return copNo
	 */
	public String getCopNo() {
		return this.copNo;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
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
	 * @return actRcvNo
	 */
	public String getActRcvNo() {
		return this.actRcvNo;
	}
	
	/**
	 * Column Info
	 * @return vndrNm
	 */
	public String getVndrNm() {
		return this.vndrNm;
	}
	
	/**
	 * Column Info
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @return ediSndRsltFlg
	 */
	public String getEdiSndRsltFlg() {
		return this.ediSndRsltFlg;
	}
	
	/**
	 * Column Info
	 * @return vslDlayRsnDesc
	 */
	public String getVslDlayRsnDesc() {
		return this.vslDlayRsnDesc;
	}
	
	/**
	 * Column Info
	 * @return emlSndRsltFlg
	 */
	public String getEmlSndRsltFlg() {
		return this.emlSndRsltFlg;
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
	 * @return actCd
	 */
	public String getActCd() {
		return this.actCd;
	}
	
	/**
	 * Column Info
	 * @return vpsEtdDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @return actRcvTpCd
	 */
	public String getActRcvTpCd() {
		return this.actRcvTpCd;
	}
	
	/**
	 * Column Info
	 * @return vpsLocCd
	 */
	public String getVpsLocCd() {
		return this.vpsLocCd;
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
	 * @return ediMsgTpCd
	 */
	public String getEdiMsgTpCd() {
		return this.ediMsgTpCd;
	}
	
	/**
	 * Column Info
	 * @return cnmvIdNo
	 */
	public String getCnmvIdNo() {
		return this.cnmvIdNo;
	}
	
	/**
	 * Column Info
	 * @return faxSndRsltFlg
	 */
	public String getFaxSndRsltFlg() {
		return this.faxSndRsltFlg;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return callYdIndCngFlg
	 */
	public String getCallYdIndCngFlg() {
		return this.callYdIndCngFlg;
	}
	
	/**
	 * Column Info
	 * @return errMsg
	 */
	public String getErrMsg() {
		return this.errMsg;
	}
	
	/**
	 * Column Info
	 * @return copRltFlg
	 */
	public String getCopRltFlg() {
		return this.copRltFlg;
	}
	
	/**
	 * Column Info
	 * @return nodCd
	 */
	public String getNodCd() {
		return this.nodCd;
	}
	
	/**
	 * Column Info
	 * @return preBkgNo
	 */
	public String getPreBkgNo() {
		return this.preBkgNo;
	}
	
	/**
	 * Column Info
	 * @return actDatRcvDt
	 */
	public String getActDatRcvDt() {
		return this.actDatRcvDt;
	}
	
	/**
	 * Column Info
	 * @return vpsEtbDt
	 */
	public String getVpsEtbDt() {
		return this.vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @return actGdt
	 */
	public String getActGdt() {
		return this.actGdt;
	}
	
	/**
	 * Column Info
	 * @return cnmvCycNo
	 */
	public String getCnmvCycNo() {
		return this.cnmvCycNo;
	}
	
	/**
	 * Column Info
	 * @return bfActUmchTpCd
	 */
	public String getBfActUmchTpCd() {
		return this.bfActUmchTpCd;
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
	 * @return copUpdRmk
	 */
	public String getCopUpdRmk() {
		return this.copUpdRmk;
	}
	
	/**
	 * Column Info
	 * @return actStsMapgCd
	 */
	public String getActStsMapgCd() {
		return this.actStsMapgCd;
	}
	
	/**
	 * Column Info
	 * @return vpsEtaDt
	 */
	public String getVpsEtaDt() {
		return this.vpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @return actUmchTpCd
	 */
	public String getActUmchTpCd() {
		return this.actUmchTpCd;
	}
	
	/**
	 * Column Info
	 * @return cnmvSplitNo
	 */
	public String getCnmvSplitNo() {
		return this.cnmvSplitNo;
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
	 * @return vslDlayRsnCd
	 */
	public String getVslDlayRsnCd() {
		return this.vslDlayRsnCd;
	}
	
	/**
	 * Column Info
	 * @return bndVskdSeqCd
	 */
	public String getBndVskdSeqCd() {
		return this.bndVskdSeqCd;
	}
	
	/**
	 * Column Info
	 * @return callYdIndSeq
	 */
	public String getCallYdIndSeq() {
		return this.callYdIndSeq;
	}
	
	/**
	 * Column Info
	 * @return railDestN1stEtaDt
	 */
	public String getRailDestN1stEtaDt() {
		return this.railDestN1stEtaDt;
	}
	
	/**
	 * Column Info
	 * @return creTpCd
	 */
	public String getCreTpCd() {
		return this.creTpCd;
	}
	
	/**
	 * Column Info
	 * @return rtyRsltFlg
	 */
	public String getRtyRsltFlg() {
		return this.rtyRsltFlg;
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
	 * @return beforeActUmchTpCd
	 */
	public String getBeforeActUmchTpCd() {
		return this.beforeActUmchTpCd;
	}
	
	/**
	 * Column Info
	 * @return copDtlSeq
	 */
	public String getCopDtlSeq() {
		return this.copDtlSeq;
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
	 * @return umchChkDt
	 */
	public String getUmchChkDt() {
		return this.umchChkDt;
	}
	
	/**
	 * Column Info
	 * @return actDt
	 */
	public String getActDt() {
		return this.actDt;
	}
	
	/**
	 * Column Info
	 * @return copEvntSeq
	 */
	public String getCopEvntSeq() {
		return this.copEvntSeq;
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
	 * @return clptIndSeq
	 */
	public String getClptIndSeq() {
		return this.clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return imdtExtFlg
	 */
	public String getImdtExtFlg() {
		return this.imdtExtFlg;
	}
	
	/**
	 * Column Info
	 * @return cnmvYr
	 */
	public String getCnmvYr() {
		return this.cnmvYr;
	}
	
	/**
	 * Column Info
	 * @return actRcvDt
	 */
	public String getActRcvDt() {
		return this.actRcvDt;
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
	 * @param cnmvSeq
	 */
	public void setCnmvSeq(String cnmvSeq) {
		this.cnmvSeq = cnmvSeq;
	}
	
	/**
	 * Column Info
	 * @param copNo
	 */
	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
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
	 * @param actRcvNo
	 */
	public void setActRcvNo(String actRcvNo) {
		this.actRcvNo = actRcvNo;
	}
	
	/**
	 * Column Info
	 * @param vndrNm
	 */
	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
	}
	
	/**
	 * Column Info
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @param ediSndRsltFlg
	 */
	public void setEdiSndRsltFlg(String ediSndRsltFlg) {
		this.ediSndRsltFlg = ediSndRsltFlg;
	}
	
	/**
	 * Column Info
	 * @param vslDlayRsnDesc
	 */
	public void setVslDlayRsnDesc(String vslDlayRsnDesc) {
		this.vslDlayRsnDesc = vslDlayRsnDesc;
	}
	
	/**
	 * Column Info
	 * @param emlSndRsltFlg
	 */
	public void setEmlSndRsltFlg(String emlSndRsltFlg) {
		this.emlSndRsltFlg = emlSndRsltFlg;
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
	 * @param actCd
	 */
	public void setActCd(String actCd) {
		this.actCd = actCd;
	}
	
	/**
	 * Column Info
	 * @param vpsEtdDt
	 */
	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @param actRcvTpCd
	 */
	public void setActRcvTpCd(String actRcvTpCd) {
		this.actRcvTpCd = actRcvTpCd;
	}
	
	/**
	 * Column Info
	 * @param vpsLocCd
	 */
	public void setVpsLocCd(String vpsLocCd) {
		this.vpsLocCd = vpsLocCd;
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
	 * @param ediMsgTpCd
	 */
	public void setEdiMsgTpCd(String ediMsgTpCd) {
		this.ediMsgTpCd = ediMsgTpCd;
	}
	
	/**
	 * Column Info
	 * @param cnmvIdNo
	 */
	public void setCnmvIdNo(String cnmvIdNo) {
		this.cnmvIdNo = cnmvIdNo;
	}
	
	/**
	 * Column Info
	 * @param faxSndRsltFlg
	 */
	public void setFaxSndRsltFlg(String faxSndRsltFlg) {
		this.faxSndRsltFlg = faxSndRsltFlg;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param callYdIndCngFlg
	 */
	public void setCallYdIndCngFlg(String callYdIndCngFlg) {
		this.callYdIndCngFlg = callYdIndCngFlg;
	}
	
	/**
	 * Column Info
	 * @param errMsg
	 */
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	
	/**
	 * Column Info
	 * @param copRltFlg
	 */
	public void setCopRltFlg(String copRltFlg) {
		this.copRltFlg = copRltFlg;
	}
	
	/**
	 * Column Info
	 * @param nodCd
	 */
	public void setNodCd(String nodCd) {
		this.nodCd = nodCd;
	}
	
	/**
	 * Column Info
	 * @param preBkgNo
	 */
	public void setPreBkgNo(String preBkgNo) {
		this.preBkgNo = preBkgNo;
	}
	
	/**
	 * Column Info
	 * @param actDatRcvDt
	 */
	public void setActDatRcvDt(String actDatRcvDt) {
		this.actDatRcvDt = actDatRcvDt;
	}
	
	/**
	 * Column Info
	 * @param vpsEtbDt
	 */
	public void setVpsEtbDt(String vpsEtbDt) {
		this.vpsEtbDt = vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @param actGdt
	 */
	public void setActGdt(String actGdt) {
		this.actGdt = actGdt;
	}
	
	/**
	 * Column Info
	 * @param cnmvCycNo
	 */
	public void setCnmvCycNo(String cnmvCycNo) {
		this.cnmvCycNo = cnmvCycNo;
	}
	
	/**
	 * Column Info
	 * @param bfActUmchTpCd
	 */
	public void setBfActUmchTpCd(String bfActUmchTpCd) {
		this.bfActUmchTpCd = bfActUmchTpCd;
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
	 * @param copUpdRmk
	 */
	public void setCopUpdRmk(String copUpdRmk) {
		this.copUpdRmk = copUpdRmk;
	}
	
	/**
	 * Column Info
	 * @param actStsMapgCd
	 */
	public void setActStsMapgCd(String actStsMapgCd) {
		this.actStsMapgCd = actStsMapgCd;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaDt
	 */
	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @param actUmchTpCd
	 */
	public void setActUmchTpCd(String actUmchTpCd) {
		this.actUmchTpCd = actUmchTpCd;
	}
	
	/**
	 * Column Info
	 * @param cnmvSplitNo
	 */
	public void setCnmvSplitNo(String cnmvSplitNo) {
		this.cnmvSplitNo = cnmvSplitNo;
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
	 * @param vslDlayRsnCd
	 */
	public void setVslDlayRsnCd(String vslDlayRsnCd) {
		this.vslDlayRsnCd = vslDlayRsnCd;
	}
	
	/**
	 * Column Info
	 * @param bndVskdSeqCd
	 */
	public void setBndVskdSeqCd(String bndVskdSeqCd) {
		this.bndVskdSeqCd = bndVskdSeqCd;
	}
	
	/**
	 * Column Info
	 * @param callYdIndSeq
	 */
	public void setCallYdIndSeq(String callYdIndSeq) {
		this.callYdIndSeq = callYdIndSeq;
	}
	
	/**
	 * Column Info
	 * @param railDestN1stEtaDt
	 */
	public void setRailDestN1stEtaDt(String railDestN1stEtaDt) {
		this.railDestN1stEtaDt = railDestN1stEtaDt;
	}
	
	/**
	 * Column Info
	 * @param creTpCd
	 */
	public void setCreTpCd(String creTpCd) {
		this.creTpCd = creTpCd;
	}
	
	/**
	 * Column Info
	 * @param rtyRsltFlg
	 */
	public void setRtyRsltFlg(String rtyRsltFlg) {
		this.rtyRsltFlg = rtyRsltFlg;
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
	 * @param beforeActUmchTpCd
	 */
	public void setBeforeActUmchTpCd(String beforeActUmchTpCd) {
		this.beforeActUmchTpCd = beforeActUmchTpCd;
	}
	
	/**
	 * Column Info
	 * @param copDtlSeq
	 */
	public void setCopDtlSeq(String copDtlSeq) {
		this.copDtlSeq = copDtlSeq;
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
	 * @param umchChkDt
	 */
	public void setUmchChkDt(String umchChkDt) {
		this.umchChkDt = umchChkDt;
	}
	
	/**
	 * Column Info
	 * @param actDt
	 */
	public void setActDt(String actDt) {
		this.actDt = actDt;
	}
	
	/**
	 * Column Info
	 * @param copEvntSeq
	 */
	public void setCopEvntSeq(String copEvntSeq) {
		this.copEvntSeq = copEvntSeq;
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
	 * @param clptIndSeq
	 */
	public void setClptIndSeq(String clptIndSeq) {
		this.clptIndSeq = clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param imdtExtFlg
	 */
	public void setImdtExtFlg(String imdtExtFlg) {
		this.imdtExtFlg = imdtExtFlg;
	}
	
	/**
	 * Column Info
	 * @param cnmvYr
	 */
	public void setCnmvYr(String cnmvYr) {
		this.cnmvYr = cnmvYr;
	}
	
	/**
	 * Column Info
	 * @param actRcvDt
	 */
	public void setActRcvDt(String actRcvDt) {
		this.actRcvDt = actRcvDt;
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
		setCnmvSeq(JSPUtil.getParameter(request, prefix + "cnmv_seq", ""));
		setCopNo(JSPUtil.getParameter(request, prefix + "cop_no", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setActRcvNo(JSPUtil.getParameter(request, prefix + "act_rcv_no", ""));
		setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
		setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
		setEdiSndRsltFlg(JSPUtil.getParameter(request, prefix + "edi_snd_rslt_flg", ""));
		setVslDlayRsnDesc(JSPUtil.getParameter(request, prefix + "vsl_dlay_rsn_desc", ""));
		setEmlSndRsltFlg(JSPUtil.getParameter(request, prefix + "eml_snd_rslt_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setActCd(JSPUtil.getParameter(request, prefix + "act_cd", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setActRcvTpCd(JSPUtil.getParameter(request, prefix + "act_rcv_tp_cd", ""));
		setVpsLocCd(JSPUtil.getParameter(request, prefix + "vps_loc_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setEdiMsgTpCd(JSPUtil.getParameter(request, prefix + "edi_msg_tp_cd", ""));
		setCnmvIdNo(JSPUtil.getParameter(request, prefix + "cnmv_id_no", ""));
		setFaxSndRsltFlg(JSPUtil.getParameter(request, prefix + "fax_snd_rslt_flg", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setCallYdIndCngFlg(JSPUtil.getParameter(request, prefix + "call_yd_ind_cng_flg", ""));
		setErrMsg(JSPUtil.getParameter(request, prefix + "err_msg", ""));
		setCopRltFlg(JSPUtil.getParameter(request, prefix + "cop_rlt_flg", ""));
		setNodCd(JSPUtil.getParameter(request, prefix + "nod_cd", ""));
		setPreBkgNo(JSPUtil.getParameter(request, prefix + "pre_bkg_no", ""));
		setActDatRcvDt(JSPUtil.getParameter(request, prefix + "act_dat_rcv_dt", ""));
		setVpsEtbDt(JSPUtil.getParameter(request, prefix + "vps_etb_dt", ""));
		setActGdt(JSPUtil.getParameter(request, prefix + "act_gdt", ""));
		setCnmvCycNo(JSPUtil.getParameter(request, prefix + "cnmv_cyc_no", ""));
		setBfActUmchTpCd(JSPUtil.getParameter(request, prefix + "bf_act_umch_tp_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCopUpdRmk(JSPUtil.getParameter(request, prefix + "cop_upd_rmk", ""));
		setActStsMapgCd(JSPUtil.getParameter(request, prefix + "act_sts_mapg_cd", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, prefix + "vps_eta_dt", ""));
		setActUmchTpCd(JSPUtil.getParameter(request, prefix + "act_umch_tp_cd", ""));
		setCnmvSplitNo(JSPUtil.getParameter(request, prefix + "cnmv_split_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVslDlayRsnCd(JSPUtil.getParameter(request, prefix + "vsl_dlay_rsn_cd", ""));
		setBndVskdSeqCd(JSPUtil.getParameter(request, prefix + "bnd_vskd_seq_cd", ""));
		setCallYdIndSeq(JSPUtil.getParameter(request, prefix + "call_yd_ind_seq", ""));
		setRailDestN1stEtaDt(JSPUtil.getParameter(request, prefix + "rail_dest_n1st_eta_dt", ""));
		setCreTpCd(JSPUtil.getParameter(request, prefix + "cre_tp_cd", ""));
		setRtyRsltFlg(JSPUtil.getParameter(request, prefix + "rty_rslt_flg", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setBeforeActUmchTpCd(JSPUtil.getParameter(request, prefix + "before_act_umch_tp_cd", ""));
		setCopDtlSeq(JSPUtil.getParameter(request, prefix + "cop_dtl_seq", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setUmchChkDt(JSPUtil.getParameter(request, prefix + "umch_chk_dt", ""));
		setActDt(JSPUtil.getParameter(request, prefix + "act_dt", ""));
		setCopEvntSeq(JSPUtil.getParameter(request, prefix + "cop_evnt_seq", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setClptIndSeq(JSPUtil.getParameter(request, prefix + "clpt_ind_seq", ""));
		setImdtExtFlg(JSPUtil.getParameter(request, prefix + "imdt_ext_flg", ""));
		setCnmvYr(JSPUtil.getParameter(request, prefix + "cnmv_yr", ""));
		setActRcvDt(JSPUtil.getParameter(request, prefix + "act_rcv_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SceActRcvIfVO[]
	 */
	public SceActRcvIfVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SceActRcvIfVO[]
	 */
	public SceActRcvIfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SceActRcvIfVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] cnmvSeq = (JSPUtil.getParameter(request, prefix	+ "cnmv_seq", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] actRcvNo = (JSPUtil.getParameter(request, prefix	+ "act_rcv_no", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] ediSndRsltFlg = (JSPUtil.getParameter(request, prefix	+ "edi_snd_rslt_flg", length));
			String[] vslDlayRsnDesc = (JSPUtil.getParameter(request, prefix	+ "vsl_dlay_rsn_desc", length));
			String[] emlSndRsltFlg = (JSPUtil.getParameter(request, prefix	+ "eml_snd_rslt_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] actCd = (JSPUtil.getParameter(request, prefix	+ "act_cd", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] actRcvTpCd = (JSPUtil.getParameter(request, prefix	+ "act_rcv_tp_cd", length));
			String[] vpsLocCd = (JSPUtil.getParameter(request, prefix	+ "vps_loc_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] ediMsgTpCd = (JSPUtil.getParameter(request, prefix	+ "edi_msg_tp_cd", length));
			String[] cnmvIdNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_id_no", length));
			String[] faxSndRsltFlg = (JSPUtil.getParameter(request, prefix	+ "fax_snd_rslt_flg", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] callYdIndCngFlg = (JSPUtil.getParameter(request, prefix	+ "call_yd_ind_cng_flg", length));
			String[] errMsg = (JSPUtil.getParameter(request, prefix	+ "err_msg", length));
			String[] copRltFlg = (JSPUtil.getParameter(request, prefix	+ "cop_rlt_flg", length));
			String[] nodCd = (JSPUtil.getParameter(request, prefix	+ "nod_cd", length));
			String[] preBkgNo = (JSPUtil.getParameter(request, prefix	+ "pre_bkg_no", length));
			String[] actDatRcvDt = (JSPUtil.getParameter(request, prefix	+ "act_dat_rcv_dt", length));
			String[] vpsEtbDt = (JSPUtil.getParameter(request, prefix	+ "vps_etb_dt", length));
			String[] actGdt = (JSPUtil.getParameter(request, prefix	+ "act_gdt", length));
			String[] cnmvCycNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_cyc_no", length));
			String[] bfActUmchTpCd = (JSPUtil.getParameter(request, prefix	+ "bf_act_umch_tp_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] copUpdRmk = (JSPUtil.getParameter(request, prefix	+ "cop_upd_rmk", length));
			String[] actStsMapgCd = (JSPUtil.getParameter(request, prefix	+ "act_sts_mapg_cd", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] actUmchTpCd = (JSPUtil.getParameter(request, prefix	+ "act_umch_tp_cd", length));
			String[] cnmvSplitNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_split_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vslDlayRsnCd = (JSPUtil.getParameter(request, prefix	+ "vsl_dlay_rsn_cd", length));
			String[] bndVskdSeqCd = (JSPUtil.getParameter(request, prefix	+ "bnd_vskd_seq_cd", length));
			String[] callYdIndSeq = (JSPUtil.getParameter(request, prefix	+ "call_yd_ind_seq", length));
			String[] railDestN1stEtaDt = (JSPUtil.getParameter(request, prefix	+ "rail_dest_n1st_eta_dt", length));
			String[] creTpCd = (JSPUtil.getParameter(request, prefix	+ "cre_tp_cd", length));
			String[] rtyRsltFlg = (JSPUtil.getParameter(request, prefix	+ "rty_rslt_flg", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] beforeActUmchTpCd = (JSPUtil.getParameter(request, prefix	+ "before_act_umch_tp_cd", length));
			String[] copDtlSeq = (JSPUtil.getParameter(request, prefix	+ "cop_dtl_seq", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] umchChkDt = (JSPUtil.getParameter(request, prefix	+ "umch_chk_dt", length));
			String[] actDt = (JSPUtil.getParameter(request, prefix	+ "act_dt", length));
			String[] copEvntSeq = (JSPUtil.getParameter(request, prefix	+ "cop_evnt_seq", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			String[] imdtExtFlg = (JSPUtil.getParameter(request, prefix	+ "imdt_ext_flg", length));
			String[] cnmvYr = (JSPUtil.getParameter(request, prefix	+ "cnmv_yr", length));
			String[] actRcvDt = (JSPUtil.getParameter(request, prefix	+ "act_rcv_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SceActRcvIfVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (cnmvSeq[i] != null)
					model.setCnmvSeq(cnmvSeq[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (actRcvNo[i] != null)
					model.setActRcvNo(actRcvNo[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (ediSndRsltFlg[i] != null)
					model.setEdiSndRsltFlg(ediSndRsltFlg[i]);
				if (vslDlayRsnDesc[i] != null)
					model.setVslDlayRsnDesc(vslDlayRsnDesc[i]);
				if (emlSndRsltFlg[i] != null)
					model.setEmlSndRsltFlg(emlSndRsltFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (actCd[i] != null)
					model.setActCd(actCd[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (actRcvTpCd[i] != null)
					model.setActRcvTpCd(actRcvTpCd[i]);
				if (vpsLocCd[i] != null)
					model.setVpsLocCd(vpsLocCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (ediMsgTpCd[i] != null)
					model.setEdiMsgTpCd(ediMsgTpCd[i]);
				if (cnmvIdNo[i] != null)
					model.setCnmvIdNo(cnmvIdNo[i]);
				if (faxSndRsltFlg[i] != null)
					model.setFaxSndRsltFlg(faxSndRsltFlg[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (callYdIndCngFlg[i] != null)
					model.setCallYdIndCngFlg(callYdIndCngFlg[i]);
				if (errMsg[i] != null)
					model.setErrMsg(errMsg[i]);
				if (copRltFlg[i] != null)
					model.setCopRltFlg(copRltFlg[i]);
				if (nodCd[i] != null)
					model.setNodCd(nodCd[i]);
				if (preBkgNo[i] != null)
					model.setPreBkgNo(preBkgNo[i]);
				if (actDatRcvDt[i] != null)
					model.setActDatRcvDt(actDatRcvDt[i]);
				if (vpsEtbDt[i] != null)
					model.setVpsEtbDt(vpsEtbDt[i]);
				if (actGdt[i] != null)
					model.setActGdt(actGdt[i]);
				if (cnmvCycNo[i] != null)
					model.setCnmvCycNo(cnmvCycNo[i]);
				if (bfActUmchTpCd[i] != null)
					model.setBfActUmchTpCd(bfActUmchTpCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (copUpdRmk[i] != null)
					model.setCopUpdRmk(copUpdRmk[i]);
				if (actStsMapgCd[i] != null)
					model.setActStsMapgCd(actStsMapgCd[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (actUmchTpCd[i] != null)
					model.setActUmchTpCd(actUmchTpCd[i]);
				if (cnmvSplitNo[i] != null)
					model.setCnmvSplitNo(cnmvSplitNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslDlayRsnCd[i] != null)
					model.setVslDlayRsnCd(vslDlayRsnCd[i]);
				if (bndVskdSeqCd[i] != null)
					model.setBndVskdSeqCd(bndVskdSeqCd[i]);
				if (callYdIndSeq[i] != null)
					model.setCallYdIndSeq(callYdIndSeq[i]);
				if (railDestN1stEtaDt[i] != null)
					model.setRailDestN1stEtaDt(railDestN1stEtaDt[i]);
				if (creTpCd[i] != null)
					model.setCreTpCd(creTpCd[i]);
				if (rtyRsltFlg[i] != null)
					model.setRtyRsltFlg(rtyRsltFlg[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (beforeActUmchTpCd[i] != null)
					model.setBeforeActUmchTpCd(beforeActUmchTpCd[i]);
				if (copDtlSeq[i] != null)
					model.setCopDtlSeq(copDtlSeq[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (umchChkDt[i] != null)
					model.setUmchChkDt(umchChkDt[i]);
				if (actDt[i] != null)
					model.setActDt(actDt[i]);
				if (copEvntSeq[i] != null)
					model.setCopEvntSeq(copEvntSeq[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (imdtExtFlg[i] != null)
					model.setImdtExtFlg(imdtExtFlg[i]);
				if (cnmvYr[i] != null)
					model.setCnmvYr(cnmvYr[i]);
				if (actRcvDt[i] != null)
					model.setActRcvDt(actRcvDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSceActRcvIfVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SceActRcvIfVO[]
	 */
	public SceActRcvIfVO[] getSceActRcvIfVOs(){
		SceActRcvIfVO[] vos = (SceActRcvIfVO[])models.toArray(new SceActRcvIfVO[models.size()]);
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
		this.cnmvSeq = this.cnmvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actRcvNo = this.actRcvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndRsltFlg = this.ediSndRsltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDlayRsnDesc = this.vslDlayRsnDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndRsltFlg = this.emlSndRsltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCd = this.actCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actRcvTpCd = this.actRcvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsLocCd = this.vpsLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediMsgTpCd = this.ediMsgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvIdNo = this.cnmvIdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndRsltFlg = this.faxSndRsltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callYdIndCngFlg = this.callYdIndCngFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errMsg = this.errMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copRltFlg = this.copRltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodCd = this.nodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preBkgNo = this.preBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDatRcvDt = this.actDatRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtbDt = this.vpsEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actGdt = this.actGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvCycNo = this.cnmvCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfActUmchTpCd = this.bfActUmchTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copUpdRmk = this.copUpdRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actStsMapgCd = this.actStsMapgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actUmchTpCd = this.actUmchTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvSplitNo = this.cnmvSplitNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDlayRsnCd = this.vslDlayRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bndVskdSeqCd = this.bndVskdSeqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callYdIndSeq = this.callYdIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railDestN1stEtaDt = this.railDestN1stEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creTpCd = this.creTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtyRsltFlg = this.rtyRsltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.beforeActUmchTpCd = this.beforeActUmchTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copDtlSeq = this.copDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.umchChkDt = this.umchChkDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDt = this.actDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copEvntSeq = this.copEvntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdtExtFlg = this.imdtExtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvYr = this.cnmvYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actRcvDt = this.actRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
