/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : Eu24ManifestListVO.java
*@FileTitle : Eu24ManifestListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.29
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.02.29 이종길 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이종길
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class Eu24ManifestListVO extends ManifestListDetailVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<Eu24ManifestListVO> models = new ArrayList<Eu24ManifestListVO>();
	
	/* Column Info */
	private String dnlCnt = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String shZip = null;
	/* Column Info */
	private String del = null;
	/* Column Info */
	private String ediSent = null;
	/* Column Info */
	private String searchEu1stPortYdCd = null;
	/* Column Info */
	private String delYdCd = null;
	/* Column Info */
	private String dtSeq = null;
	/* Column Info */
	private String shStr = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String ensEdiSvcFlg = null;
	/* Column Info */
	private String cstmsClptIndSeq = null;
	/* Column Info */
	private String ntfyCn = null;
	/* Column Info */
	private String anEdiSvcFlg = null;
	/* Column Info */
	private String nlErrMsg = null;
	/* Column Info */
	private String pFiPolYardCd = null;
	/* Column Info */
	private String sentFailCnt = null;
	/* Column Info */
	private String polClptIndSeq = null;
	/* Column Info */
	private String cmPk = null;
	/* Column Info */
	private String vvdCnt = null;
	/* Column Info */
	private String ntfyCt = null;
	/* Column Info */
	private String cntrPk = null;
	/* Column Info */
	private String cneeCt = null;
	/* Column Info */
	private String downloadYn = null;
	/* Column Info */
	private String cntrList = null;
	/* Column Info */
	private String cneeCn = null;
	/* Column Info */
	private String eu1stPortYdCd = null;
	/* Column Info */
	private String shEori = null;
	/* Column Info */
	private String rfsYn = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String cntrPkLmtFlg = null;
	/* Column Info */
	private String ensResult = null;
	/* Column Info */
	private String cneeEori = null;
	/* Column Info */
	private String cneeNm = null;
	/* Column Info */
	private String nrCnt = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String eu1stPortClptSeq = null;
	/* Column Info */
	private String sentBlCnt = null;
	/* Column Info */
	private String result = null;
	/* Column Info */
	private String ediMrn = null;
	/* Column Info */
	private String blStatus = null;
	/* Column Info */
	private String ntfyAd = null;
	/* Column Info */
	private String ttlCntr = null;
	/* Column Info */
	private String aCnt = null;
	/* Column Info */
	private String trsmBlckFlg = null;
	/* Column Info */
	private String drYn = null;
	/* Column Info */
	private String downYnFirstOfMultiPofe = null;
	/* Column Info */
	private String shAd = null;
	/* Column Info */
	private String etaErrMsg = null;
	/* Column Info */
	private String ct = null;
	/* Column Info */
	private String ktsSendDt = null;
	/* Column Info */
	private String receivedTime = null;
	/* Column Info */
	private String portOfcCd = null;
	/* Column Info */
	private String sentSuccessCnt = null;
	/* Column Info */
	private String podYdCd = null;
	/* Column Info */
	private String eu1stPort = null;
	/* Column Info */
	private String eu1stPortName = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String bpol = null;
	/* Column Info */
	private String cmMk = null;
	/* Column Info */
	private String polYdCd = null;
	/* Column Info */
	private String lt = null;
	/* Column Info */
	private String euStfFlg = null;
	/* Column Info */
	private String caCnt = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Column Info */
	private String bpod = null;
	/* Column Info */
	private String ediRefNo = null;
	/* Column Info */
	private String shCt = null;
	/* Column Info */
	private String shCn = null;
	/* Column Info */
	private String vpsPortYdCd = null;
	/* Column Info */
	private String pType = null;
	/* Column Info */
	private String cneeStr = null;
	/* Column Info */
	private String dtCheck = null;
	/* Column Info */
	private String cntrMs = null;
	/* Column Info */
	private String cmMs = null;
	/* Column Info */
	private String errYn = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rCnt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String cntrCntrNo = null;
	/* Column Info */
	private String cntrSeal = null;
	/* Column Info */
	private String cneeZip = null;
	/* Column Info */
	private String ttlErrBl = null;
	/* Column Info */
	private String cmDs = null;
	/* Column Info */
	private String alCnt = null;
	/* Column Info */
	private String cmHts = null;
	/* Column Info */
	private String sentTime = null;
	/* Column Info */
	private String pFiPolCd = null;
	/* Column Info */
	private String blMs = null;
	/* Column Info */
	private String shNm = null;
	/* Column Info */
	private String dvsRqstEdiSvcFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cmWt = null;
	/* Column Info */
	private String blPk = null;
	/* Column Info */
	private String trsmVal = null;
	/* Column Info */
	private String ataYn = null;
	/* Column Info */
	private String ttlBl = null;
	/* Column Info */
	private String cntrWt = null;
	/* Column Info */
	private String unsentBlCnt = null;
	/* Column Info */
	private String cstmsEstmArrDt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String podClptIndSeq = null;
	/* Column Info */
	private String msgSndNo = null;
	/* Column Info */
	private String arnYn = null;
	/* Column Info */
	private String result2 = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String cneeAd = null;
	/* Column Info */
	private String blWt = null;
	/* Column Info */
	private String ntfyStr = null;
	/* Column Info */
	private String rcvMsg = null;
	/* Column Info */
	private String ediRcvDt = null;
	/* Column Info */
	private String ntfyEori = null;
	/* Column Info */
	private String ntfyZip = null;
	/* Column Info */
	private String ediTime = null;
	/* Column Info */
	private String ntfyNm = null;
	/* Column Info */
	private String ediRcvSeq = null;
	/* Column Info */
	private String clptIndSeq = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public Eu24ManifestListVO() {}

	public Eu24ManifestListVO(String ibflag, String pagerows, String dtSeq, String drYn, String eu1stPort, String delYdCd, String cmMs, String cneeCt, String pFiPolYardCd, String cntrMs, String arnYn, String cmMk, String pol, String polClptIndSeq, String ensResult, String cneeCn, String cneeStr, String pod, String searchEu1stPortYdCd, String cmWt, String cntrPkLmtFlg, String dtCheck, String skdVoyNo, String ntfyAd, String cneeZip, String bkgNo, String downYnFirstOfMultiPofe, String ntfyStr, String eu1stPortName, String cmDs, String shCt, String cntrSeal, String shCn, String cstmsClptIndSeq, String pType, String anEdiSvcFlg, String cntrList, String alCnt, String lt, String rcvMsg, String sentTime, String ntfyCn, String errYn, String del, String shEori, String shNm, String ntfyCt, String ktsSendDt, String cneeEori, String ataYn, String ntfyNm, String ttlErrBl, String cneeNm, String receivedTime, String slanCd, String ediRefNo, String shStr, String nrCnt, String cntrPk, String msgSndNo, String cstmsEstmArrDt, String blStatus, String ediRcvDt, String ntfyZip, String vslCd, String ediRcvSeq, String blNo, String cmHts, String caCnt, String vpsPortYdCd, String cntrWt, String blWt, String unsentBlCnt, String pFiPolCd, String cntrCntrNo, String vpsEtdDt, String rfsYn, String ediTime, String podClptIndSeq, String ediSent, String portOfcCd, String ct, String cneeAd, String creUsrId, String blMs, String ensEdiSvcFlg, String eu1stPortYdCd, String result, String ediMrn, String shZip, String dnlCnt, String eu1stPortClptSeq, String blPk, String shAd, String trsmBlckFlg, String sentBlCnt, String vpsEtaDt, String cmPk, String result2, String ntfyEori, String ttlCntr, String sentSuccessCnt, String trsmVal, String podYdCd, String dvsRqstEdiSvcFlg, String sentFailCnt, String rCnt, String aCnt, String skdDirCd, String bpol, String ttlBl, String polYdCd, String vvdCnt, String downloadYn, String bpod, String nlErrMsg, String etaErrMsg, String euStfFlg, String clptIndSeq) {
		this.dnlCnt = dnlCnt;
		this.bkgNo = bkgNo;
		this.shZip = shZip;
		this.del = del;
		this.ediSent = ediSent;
		this.searchEu1stPortYdCd = searchEu1stPortYdCd;
		this.delYdCd = delYdCd;
		this.dtSeq = dtSeq;
		this.shStr = shStr;
		this.slanCd = slanCd;
		this.ensEdiSvcFlg = ensEdiSvcFlg;
		this.cstmsClptIndSeq = cstmsClptIndSeq;
		this.ntfyCn = ntfyCn;
		this.anEdiSvcFlg = anEdiSvcFlg;
		this.nlErrMsg = nlErrMsg;
		this.pFiPolYardCd = pFiPolYardCd;
		this.sentFailCnt = sentFailCnt;
		this.polClptIndSeq = polClptIndSeq;
		this.cmPk = cmPk;
		this.vvdCnt = vvdCnt;
		this.ntfyCt = ntfyCt;
		this.cntrPk = cntrPk;
		this.cneeCt = cneeCt;
		this.downloadYn = downloadYn;
		this.cntrList = cntrList;
		this.cneeCn = cneeCn;
		this.eu1stPortYdCd = eu1stPortYdCd;
		this.shEori = shEori;
		this.rfsYn = rfsYn;
		this.pod = pod;
		this.cntrPkLmtFlg = cntrPkLmtFlg;
		this.ensResult = ensResult;
		this.cneeEori = cneeEori;
		this.cneeNm = cneeNm;
		this.nrCnt = nrCnt;
		this.vpsEtdDt = vpsEtdDt;
		this.pol = pol;
		this.creUsrId = creUsrId;
		this.eu1stPortClptSeq = eu1stPortClptSeq;
		this.sentBlCnt = sentBlCnt;
		this.result = result;
		this.ediMrn = ediMrn;
		this.blStatus = blStatus;
		this.ntfyAd = ntfyAd;
		this.ttlCntr = ttlCntr;
		this.aCnt = aCnt;
		this.trsmBlckFlg = trsmBlckFlg;
		this.drYn = drYn;
		this.downYnFirstOfMultiPofe = downYnFirstOfMultiPofe;
		this.shAd = shAd;
		this.etaErrMsg = etaErrMsg;
		this.ct = ct;
		this.ktsSendDt = ktsSendDt;
		this.receivedTime = receivedTime;
		this.portOfcCd = portOfcCd;
		this.sentSuccessCnt = sentSuccessCnt;
		this.podYdCd = podYdCd;
		this.eu1stPort = eu1stPort;
		this.eu1stPortName = eu1stPortName;
		this.blNo = blNo;
		this.bpol = bpol;
		this.cmMk = cmMk;
		this.polYdCd = polYdCd;
		this.lt = lt;
		this.euStfFlg = euStfFlg;
		this.caCnt = caCnt;
		this.vpsEtaDt = vpsEtaDt;
		this.bpod = bpod;
		this.ediRefNo = ediRefNo;
		this.shCt = shCt;
		this.shCn = shCn;
		this.vpsPortYdCd = vpsPortYdCd;
		this.pType = pType;
		this.cneeStr = cneeStr;
		this.dtCheck = dtCheck;
		this.cntrMs = cntrMs;
		this.cmMs = cmMs;
		this.errYn = errYn;
		this.pagerows = pagerows;
		this.rCnt = rCnt;
		this.vslCd = vslCd;
		this.cntrCntrNo = cntrCntrNo;
		this.cntrSeal = cntrSeal;
		this.cneeZip = cneeZip;
		this.ttlErrBl = ttlErrBl;
		this.cmDs = cmDs;
		this.alCnt = alCnt;
		this.cmHts = cmHts;
		this.sentTime = sentTime;
		this.pFiPolCd = pFiPolCd;
		this.blMs = blMs;
		this.shNm = shNm;
		this.dvsRqstEdiSvcFlg = dvsRqstEdiSvcFlg;
		this.ibflag = ibflag;
		this.cmWt = cmWt;
		this.blPk = blPk;
		this.trsmVal = trsmVal;
		this.ataYn = ataYn;
		this.ttlBl = ttlBl;
		this.cntrWt = cntrWt;
		this.unsentBlCnt = unsentBlCnt;
		this.cstmsEstmArrDt = cstmsEstmArrDt;
		this.skdDirCd = skdDirCd;
		this.podClptIndSeq = podClptIndSeq;
		this.msgSndNo = msgSndNo;
		this.arnYn = arnYn;
		this.result2 = result2;
		this.skdVoyNo = skdVoyNo;
		this.cneeAd = cneeAd;
		this.blWt = blWt;
		this.ntfyStr = ntfyStr;
		this.rcvMsg = rcvMsg;
		this.ediRcvDt = ediRcvDt;
		this.ntfyEori = ntfyEori;
		this.ntfyZip = ntfyZip;
		this.ediTime = ediTime;
		this.ntfyNm = ntfyNm;
		this.ediRcvSeq = ediRcvSeq;
		this.clptIndSeq = clptIndSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dnl_cnt", getDnlCnt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("sh_zip", getShZip());
		this.hashColumns.put("del", getDel());
		this.hashColumns.put("edi_sent", getEdiSent());
		this.hashColumns.put("search_eu_1st_port_yd_cd", getSearchEu1stPortYdCd());
		this.hashColumns.put("del_yd_cd", getDelYdCd());
		this.hashColumns.put("dt_seq", getDtSeq());
		this.hashColumns.put("sh_str", getShStr());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("ens_edi_svc_flg", getEnsEdiSvcFlg());
		this.hashColumns.put("cstms_clpt_ind_seq", getCstmsClptIndSeq());
		this.hashColumns.put("ntfy_cn", getNtfyCn());
		this.hashColumns.put("an_edi_svc_flg", getAnEdiSvcFlg());
		this.hashColumns.put("nl_err_msg", getNlErrMsg());
		this.hashColumns.put("p_fi_pol_yard_cd", getPFiPolYardCd());
		this.hashColumns.put("sent_fail_cnt", getSentFailCnt());
		this.hashColumns.put("pol_clpt_ind_seq", getPolClptIndSeq());
		this.hashColumns.put("cm_pk", getCmPk());
		this.hashColumns.put("vvd_cnt", getVvdCnt());
		this.hashColumns.put("ntfy_ct", getNtfyCt());
		this.hashColumns.put("cntr_pk", getCntrPk());
		this.hashColumns.put("cnee_ct", getCneeCt());
		this.hashColumns.put("download_yn", getDownloadYn());
		this.hashColumns.put("cntr_list", getCntrList());
		this.hashColumns.put("cnee_cn", getCneeCn());
		this.hashColumns.put("eu_1st_port_yd_cd", getEu1stPortYdCd());
		this.hashColumns.put("sh_eori", getShEori());
		this.hashColumns.put("rfs_yn", getRfsYn());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("cntr_pk_lmt_flg", getCntrPkLmtFlg());
		this.hashColumns.put("ens_result", getEnsResult());
		this.hashColumns.put("cnee_eori", getCneeEori());
		this.hashColumns.put("cnee_nm", getCneeNm());
		this.hashColumns.put("nr_cnt", getNrCnt());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("eu_1st_port_clpt_seq", getEu1stPortClptSeq());
		this.hashColumns.put("sent_bl_cnt", getSentBlCnt());
		this.hashColumns.put("result", getResult());
		this.hashColumns.put("edi_mrn", getEdiMrn());
		this.hashColumns.put("bl_status", getBlStatus());
		this.hashColumns.put("ntfy_ad", getNtfyAd());
		this.hashColumns.put("ttl_cntr", getTtlCntr());
		this.hashColumns.put("a_cnt", getACnt());
		this.hashColumns.put("trsm_blck_flg", getTrsmBlckFlg());
		this.hashColumns.put("dr_yn", getDrYn());
		this.hashColumns.put("down_yn_first_of_multi_pofe", getDownYnFirstOfMultiPofe());
		this.hashColumns.put("sh_ad", getShAd());
		this.hashColumns.put("eta_err_msg", getEtaErrMsg());
		this.hashColumns.put("ct", getCt());
		this.hashColumns.put("kts_send_dt", getKtsSendDt());
		this.hashColumns.put("received_time", getReceivedTime());
		this.hashColumns.put("port_ofc_cd", getPortOfcCd());
		this.hashColumns.put("sent_success_cnt", getSentSuccessCnt());
		this.hashColumns.put("pod_yd_cd", getPodYdCd());
		this.hashColumns.put("eu_1st_port", getEu1stPort());
		this.hashColumns.put("eu_1st_port_name", getEu1stPortName());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("bpol", getBpol());
		this.hashColumns.put("cm_mk", getCmMk());
		this.hashColumns.put("pol_yd_cd", getPolYdCd());
		this.hashColumns.put("lt", getLt());
		this.hashColumns.put("eu_stf_flg", getEuStfFlg());
		this.hashColumns.put("ca_cnt", getCaCnt());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("bpod", getBpod());
		this.hashColumns.put("edi_ref_no", getEdiRefNo());
		this.hashColumns.put("sh_ct", getShCt());
		this.hashColumns.put("sh_cn", getShCn());
		this.hashColumns.put("vps_port_yd_cd", getVpsPortYdCd());
		this.hashColumns.put("p_type", getPType());
		this.hashColumns.put("cnee_str", getCneeStr());
		this.hashColumns.put("dt_check", getDtCheck());
		this.hashColumns.put("cntr_ms", getCntrMs());
		this.hashColumns.put("cm_ms", getCmMs());
		this.hashColumns.put("err_yn", getErrYn());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("r_cnt", getRCnt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("cntr_cntr_no", getCntrCntrNo());
		this.hashColumns.put("cntr_seal", getCntrSeal());
		this.hashColumns.put("cnee_zip", getCneeZip());
		this.hashColumns.put("ttl_err_bl", getTtlErrBl());
		this.hashColumns.put("cm_ds", getCmDs());
		this.hashColumns.put("al_cnt", getAlCnt());
		this.hashColumns.put("cm_hts", getCmHts());
		this.hashColumns.put("sent_time", getSentTime());
		this.hashColumns.put("p_fi_pol_cd", getPFiPolCd());
		this.hashColumns.put("bl_ms", getBlMs());
		this.hashColumns.put("sh_nm", getShNm());
		this.hashColumns.put("dvs_rqst_edi_svc_flg", getDvsRqstEdiSvcFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cm_wt", getCmWt());
		this.hashColumns.put("bl_pk", getBlPk());
		this.hashColumns.put("trsm_val", getTrsmVal());
		this.hashColumns.put("ata_yn", getAtaYn());
		this.hashColumns.put("ttl_bl", getTtlBl());
		this.hashColumns.put("cntr_wt", getCntrWt());
		this.hashColumns.put("unsent_bl_cnt", getUnsentBlCnt());
		this.hashColumns.put("cstms_estm_arr_dt", getCstmsEstmArrDt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pod_clpt_ind_seq", getPodClptIndSeq());
		this.hashColumns.put("msg_snd_no", getMsgSndNo());
		this.hashColumns.put("arn_yn", getArnYn());
		this.hashColumns.put("result2", getResult2());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("cnee_ad", getCneeAd());
		this.hashColumns.put("bl_wt", getBlWt());
		this.hashColumns.put("ntfy_str", getNtfyStr());
		this.hashColumns.put("rcv_msg", getRcvMsg());
		this.hashColumns.put("edi_rcv_dt", getEdiRcvDt());
		this.hashColumns.put("ntfy_eori", getNtfyEori());
		this.hashColumns.put("ntfy_zip", getNtfyZip());
		this.hashColumns.put("edi_time", getEdiTime());
		this.hashColumns.put("ntfy_nm", getNtfyNm());
		this.hashColumns.put("edi_rcv_seq", getEdiRcvSeq());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dnl_cnt", "dnlCnt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("sh_zip", "shZip");
		this.hashFields.put("del", "del");
		this.hashFields.put("edi_sent", "ediSent");
		this.hashFields.put("search_eu_1st_port_yd_cd", "searchEu1stPortYdCd");
		this.hashFields.put("del_yd_cd", "delYdCd");
		this.hashFields.put("dt_seq", "dtSeq");
		this.hashFields.put("sh_str", "shStr");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("ens_edi_svc_flg", "ensEdiSvcFlg");
		this.hashFields.put("cstms_clpt_ind_seq", "cstmsClptIndSeq");
		this.hashFields.put("ntfy_cn", "ntfyCn");
		this.hashFields.put("an_edi_svc_flg", "anEdiSvcFlg");
		this.hashFields.put("nl_err_msg", "nlErrMsg");
		this.hashFields.put("p_fi_pol_yard_cd", "pFiPolYardCd");
		this.hashFields.put("sent_fail_cnt", "sentFailCnt");
		this.hashFields.put("pol_clpt_ind_seq", "polClptIndSeq");
		this.hashFields.put("cm_pk", "cmPk");
		this.hashFields.put("vvd_cnt", "vvdCnt");
		this.hashFields.put("ntfy_ct", "ntfyCt");
		this.hashFields.put("cntr_pk", "cntrPk");
		this.hashFields.put("cnee_ct", "cneeCt");
		this.hashFields.put("download_yn", "downloadYn");
		this.hashFields.put("cntr_list", "cntrList");
		this.hashFields.put("cnee_cn", "cneeCn");
		this.hashFields.put("eu_1st_port_yd_cd", "eu1stPortYdCd");
		this.hashFields.put("sh_eori", "shEori");
		this.hashFields.put("rfs_yn", "rfsYn");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("cntr_pk_lmt_flg", "cntrPkLmtFlg");
		this.hashFields.put("ens_result", "ensResult");
		this.hashFields.put("cnee_eori", "cneeEori");
		this.hashFields.put("cnee_nm", "cneeNm");
		this.hashFields.put("nr_cnt", "nrCnt");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("eu_1st_port_clpt_seq", "eu1stPortClptSeq");
		this.hashFields.put("sent_bl_cnt", "sentBlCnt");
		this.hashFields.put("result", "result");
		this.hashFields.put("edi_mrn", "ediMrn");
		this.hashFields.put("bl_status", "blStatus");
		this.hashFields.put("ntfy_ad", "ntfyAd");
		this.hashFields.put("ttl_cntr", "ttlCntr");
		this.hashFields.put("a_cnt", "aCnt");
		this.hashFields.put("trsm_blck_flg", "trsmBlckFlg");
		this.hashFields.put("dr_yn", "drYn");
		this.hashFields.put("down_yn_first_of_multi_pofe", "downYnFirstOfMultiPofe");
		this.hashFields.put("sh_ad", "shAd");
		this.hashFields.put("eta_err_msg", "etaErrMsg");
		this.hashFields.put("ct", "ct");
		this.hashFields.put("kts_send_dt", "ktsSendDt");
		this.hashFields.put("received_time", "receivedTime");
		this.hashFields.put("port_ofc_cd", "portOfcCd");
		this.hashFields.put("sent_success_cnt", "sentSuccessCnt");
		this.hashFields.put("pod_yd_cd", "podYdCd");
		this.hashFields.put("eu_1st_port", "eu1stPort");
		this.hashFields.put("eu_1st_port_name", "eu1stPortName");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("bpol", "bpol");
		this.hashFields.put("cm_mk", "cmMk");
		this.hashFields.put("pol_yd_cd", "polYdCd");
		this.hashFields.put("lt", "lt");
		this.hashFields.put("eu_stf_flg", "euStfFlg");
		this.hashFields.put("ca_cnt", "caCnt");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("bpod", "bpod");
		this.hashFields.put("edi_ref_no", "ediRefNo");
		this.hashFields.put("sh_ct", "shCt");
		this.hashFields.put("sh_cn", "shCn");
		this.hashFields.put("vps_port_yd_cd", "vpsPortYdCd");
		this.hashFields.put("p_type", "pType");
		this.hashFields.put("cnee_str", "cneeStr");
		this.hashFields.put("dt_check", "dtCheck");
		this.hashFields.put("cntr_ms", "cntrMs");
		this.hashFields.put("cm_ms", "cmMs");
		this.hashFields.put("err_yn", "errYn");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("r_cnt", "rCnt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("cntr_cntr_no", "cntrCntrNo");
		this.hashFields.put("cntr_seal", "cntrSeal");
		this.hashFields.put("cnee_zip", "cneeZip");
		this.hashFields.put("ttl_err_bl", "ttlErrBl");
		this.hashFields.put("cm_ds", "cmDs");
		this.hashFields.put("al_cnt", "alCnt");
		this.hashFields.put("cm_hts", "cmHts");
		this.hashFields.put("sent_time", "sentTime");
		this.hashFields.put("p_fi_pol_cd", "pFiPolCd");
		this.hashFields.put("bl_ms", "blMs");
		this.hashFields.put("sh_nm", "shNm");
		this.hashFields.put("dvs_rqst_edi_svc_flg", "dvsRqstEdiSvcFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cm_wt", "cmWt");
		this.hashFields.put("bl_pk", "blPk");
		this.hashFields.put("trsm_val", "trsmVal");
		this.hashFields.put("ata_yn", "ataYn");
		this.hashFields.put("ttl_bl", "ttlBl");
		this.hashFields.put("cntr_wt", "cntrWt");
		this.hashFields.put("unsent_bl_cnt", "unsentBlCnt");
		this.hashFields.put("cstms_estm_arr_dt", "cstmsEstmArrDt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pod_clpt_ind_seq", "podClptIndSeq");
		this.hashFields.put("msg_snd_no", "msgSndNo");
		this.hashFields.put("arn_yn", "arnYn");
		this.hashFields.put("result2", "result2");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("cnee_ad", "cneeAd");
		this.hashFields.put("bl_wt", "blWt");
		this.hashFields.put("ntfy_str", "ntfyStr");
		this.hashFields.put("rcv_msg", "rcvMsg");
		this.hashFields.put("edi_rcv_dt", "ediRcvDt");
		this.hashFields.put("ntfy_eori", "ntfyEori");
		this.hashFields.put("ntfy_zip", "ntfyZip");
		this.hashFields.put("edi_time", "ediTime");
		this.hashFields.put("ntfy_nm", "ntfyNm");
		this.hashFields.put("edi_rcv_seq", "ediRcvSeq");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dnlCnt
	 */
	public String getDnlCnt() {
		return this.dnlCnt;
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
	 * @return shZip
	 */
	public String getShZip() {
		return this.shZip;
	}
	
	/**
	 * Column Info
	 * @return del
	 */
	public String getDel() {
		return this.del;
	}
	
	/**
	 * Column Info
	 * @return ediSent
	 */
	public String getEdiSent() {
		return this.ediSent;
	}
	
	/**
	 * Column Info
	 * @return searchEu1stPortYdCd
	 */
	public String getSearchEu1stPortYdCd() {
		return this.searchEu1stPortYdCd;
	}
	
	/**
	 * Column Info
	 * @return delYdCd
	 */
	public String getDelYdCd() {
		return this.delYdCd;
	}
	
	/**
	 * Column Info
	 * @return dtSeq
	 */
	public String getDtSeq() {
		return this.dtSeq;
	}
	
	/**
	 * Column Info
	 * @return shStr
	 */
	public String getShStr() {
		return this.shStr;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return ensEdiSvcFlg
	 */
	public String getEnsEdiSvcFlg() {
		return this.ensEdiSvcFlg;
	}
	
	/**
	 * Column Info
	 * @return cstmsClptIndSeq
	 */
	public String getCstmsClptIndSeq() {
		return this.cstmsClptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return ntfyCn
	 */
	public String getNtfyCn() {
		return this.ntfyCn;
	}
	
	/**
	 * Column Info
	 * @return anEdiSvcFlg
	 */
	public String getAnEdiSvcFlg() {
		return this.anEdiSvcFlg;
	}
	
	/**
	 * Column Info
	 * @return nlErrMsg
	 */
	public String getNlErrMsg() {
		return this.nlErrMsg;
	}
	
	/**
	 * Column Info
	 * @return pFiPolYardCd
	 */
	public String getPFiPolYardCd() {
		return this.pFiPolYardCd;
	}
	
	/**
	 * Column Info
	 * @return sentFailCnt
	 */
	public String getSentFailCnt() {
		return this.sentFailCnt;
	}
	
	/**
	 * Column Info
	 * @return polClptIndSeq
	 */
	public String getPolClptIndSeq() {
		return this.polClptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return cmPk
	 */
	public String getCmPk() {
		return this.cmPk;
	}
	
	/**
	 * Column Info
	 * @return vvdCnt
	 */
	public String getVvdCnt() {
		return this.vvdCnt;
	}
	
	/**
	 * Column Info
	 * @return ntfyCt
	 */
	public String getNtfyCt() {
		return this.ntfyCt;
	}
	
	/**
	 * Column Info
	 * @return cntrPk
	 */
	public String getCntrPk() {
		return this.cntrPk;
	}
	
	/**
	 * Column Info
	 * @return cneeCt
	 */
	public String getCneeCt() {
		return this.cneeCt;
	}
	
	/**
	 * Column Info
	 * @return downloadYn
	 */
	public String getDownloadYn() {
		return this.downloadYn;
	}
	
	/**
	 * Column Info
	 * @return cntrList
	 */
	public String getCntrList() {
		return this.cntrList;
	}
	
	/**
	 * Column Info
	 * @return cneeCn
	 */
	public String getCneeCn() {
		return this.cneeCn;
	}
	
	/**
	 * Column Info
	 * @return eu1stPortYdCd
	 */
	public String getEu1stPortYdCd() {
		return this.eu1stPortYdCd;
	}
	
	/**
	 * Column Info
	 * @return shEori
	 */
	public String getShEori() {
		return this.shEori;
	}
	
	/**
	 * Column Info
	 * @return rfsYn
	 */
	public String getRfsYn() {
		return this.rfsYn;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}
	
	/**
	 * Column Info
	 * @return cntrPkLmtFlg
	 */
	public String getCntrPkLmtFlg() {
		return this.cntrPkLmtFlg;
	}
	
	/**
	 * Column Info
	 * @return ensResult
	 */
	public String getEnsResult() {
		return this.ensResult;
	}
	
	/**
	 * Column Info
	 * @return cneeEori
	 */
	public String getCneeEori() {
		return this.cneeEori;
	}
	
	/**
	 * Column Info
	 * @return cneeNm
	 */
	public String getCneeNm() {
		return this.cneeNm;
	}
	
	/**
	 * Column Info
	 * @return nrCnt
	 */
	public String getNrCnt() {
		return this.nrCnt;
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
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
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
	 * @return eu1stPortClptSeq
	 */
	public String getEu1stPortClptSeq() {
		return this.eu1stPortClptSeq;
	}
	
	/**
	 * Column Info
	 * @return sentBlCnt
	 */
	public String getSentBlCnt() {
		return this.sentBlCnt;
	}
	
	/**
	 * Column Info
	 * @return result
	 */
	public String getResult() {
		return this.result;
	}
	
	/**
	 * Column Info
	 * @return ediMrn
	 */
	public String getEdiMrn() {
		return this.ediMrn;
	}
	
	/**
	 * Column Info
	 * @return blStatus
	 */
	public String getBlStatus() {
		return this.blStatus;
	}
	
	/**
	 * Column Info
	 * @return ntfyAd
	 */
	public String getNtfyAd() {
		return this.ntfyAd;
	}
	
	/**
	 * Column Info
	 * @return ttlCntr
	 */
	public String getTtlCntr() {
		return this.ttlCntr;
	}
	
	/**
	 * Column Info
	 * @return aCnt
	 */
	public String getACnt() {
		return this.aCnt;
	}
	
	/**
	 * Column Info
	 * @return trsmBlckFlg
	 */
	public String getTrsmBlckFlg() {
		return this.trsmBlckFlg;
	}
	
	/**
	 * Column Info
	 * @return drYn
	 */
	public String getDrYn() {
		return this.drYn;
	}
	
	/**
	 * Column Info
	 * @return downYnFirstOfMultiPofe
	 */
	public String getDownYnFirstOfMultiPofe() {
		return this.downYnFirstOfMultiPofe;
	}
	
	/**
	 * Column Info
	 * @return shAd
	 */
	public String getShAd() {
		return this.shAd;
	}
	
	/**
	 * Column Info
	 * @return etaErrMsg
	 */
	public String getEtaErrMsg() {
		return this.etaErrMsg;
	}
	
	/**
	 * Column Info
	 * @return ct
	 */
	public String getCt() {
		return this.ct;
	}
	
	/**
	 * Column Info
	 * @return ktsSendDt
	 */
	public String getKtsSendDt() {
		return this.ktsSendDt;
	}
	
	/**
	 * Column Info
	 * @return receivedTime
	 */
	public String getReceivedTime() {
		return this.receivedTime;
	}
	
	/**
	 * Column Info
	 * @return portOfcCd
	 */
	public String getPortOfcCd() {
		return this.portOfcCd;
	}
	
	/**
	 * Column Info
	 * @return sentSuccessCnt
	 */
	public String getSentSuccessCnt() {
		return this.sentSuccessCnt;
	}
	
	/**
	 * Column Info
	 * @return podYdCd
	 */
	public String getPodYdCd() {
		return this.podYdCd;
	}
	
	/**
	 * Column Info
	 * @return eu1stPort
	 */
	public String getEu1stPort() {
		return this.eu1stPort;
	}
	
	/**
	 * Column Info
	 * @return eu1stPortName
	 */
	public String getEu1stPortName() {
		return this.eu1stPortName;
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
	 * @return bpol
	 */
	public String getBpol() {
		return this.bpol;
	}
	
	/**
	 * Column Info
	 * @return cmMk
	 */
	public String getCmMk() {
		return this.cmMk;
	}
	
	/**
	 * Column Info
	 * @return polYdCd
	 */
	public String getPolYdCd() {
		return this.polYdCd;
	}
	
	/**
	 * Column Info
	 * @return lt
	 */
	public String getLt() {
		return this.lt;
	}
	
	/**
	 * Column Info
	 * @return euStfFlg
	 */
	public String getEuStfFlg() {
		return this.euStfFlg;
	}
	
	/**
	 * Column Info
	 * @return caCnt
	 */
	public String getCaCnt() {
		return this.caCnt;
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
	 * @return bpod
	 */
	public String getBpod() {
		return this.bpod;
	}
	
	/**
	 * Column Info
	 * @return ediRefNo
	 */
	public String getEdiRefNo() {
		return this.ediRefNo;
	}
	
	/**
	 * Column Info
	 * @return shCt
	 */
	public String getShCt() {
		return this.shCt;
	}
	
	/**
	 * Column Info
	 * @return shCn
	 */
	public String getShCn() {
		return this.shCn;
	}
	
	/**
	 * Column Info
	 * @return vpsPortYdCd
	 */
	public String getVpsPortYdCd() {
		return this.vpsPortYdCd;
	}
	
	/**
	 * Column Info
	 * @return pType
	 */
	public String getPType() {
		return this.pType;
	}
	
	/**
	 * Column Info
	 * @return cneeStr
	 */
	public String getCneeStr() {
		return this.cneeStr;
	}
	
	/**
	 * Column Info
	 * @return dtCheck
	 */
	public String getDtCheck() {
		return this.dtCheck;
	}
	
	/**
	 * Column Info
	 * @return cntrMs
	 */
	public String getCntrMs() {
		return this.cntrMs;
	}
	
	/**
	 * Column Info
	 * @return cmMs
	 */
	public String getCmMs() {
		return this.cmMs;
	}
	
	/**
	 * Column Info
	 * @return errYn
	 */
	public String getErrYn() {
		return this.errYn;
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
	 * @return rCnt
	 */
	public String getRCnt() {
		return this.rCnt;
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
	 * @return cntrCntrNo
	 */
	public String getCntrCntrNo() {
		return this.cntrCntrNo;
	}
	
	/**
	 * Column Info
	 * @return cntrSeal
	 */
	public String getCntrSeal() {
		return this.cntrSeal;
	}
	
	/**
	 * Column Info
	 * @return cneeZip
	 */
	public String getCneeZip() {
		return this.cneeZip;
	}
	
	/**
	 * Column Info
	 * @return ttlErrBl
	 */
	public String getTtlErrBl() {
		return this.ttlErrBl;
	}
	
	/**
	 * Column Info
	 * @return cmDs
	 */
	public String getCmDs() {
		return this.cmDs;
	}
	
	/**
	 * Column Info
	 * @return alCnt
	 */
	public String getAlCnt() {
		return this.alCnt;
	}
	
	/**
	 * Column Info
	 * @return cmHts
	 */
	public String getCmHts() {
		return this.cmHts;
	}
	
	/**
	 * Column Info
	 * @return sentTime
	 */
	public String getSentTime() {
		return this.sentTime;
	}
	
	/**
	 * Column Info
	 * @return pFiPolCd
	 */
	public String getPFiPolCd() {
		return this.pFiPolCd;
	}
	
	/**
	 * Column Info
	 * @return blMs
	 */
	public String getBlMs() {
		return this.blMs;
	}
	
	/**
	 * Column Info
	 * @return shNm
	 */
	public String getShNm() {
		return this.shNm;
	}
	
	/**
	 * Column Info
	 * @return dvsRqstEdiSvcFlg
	 */
	public String getDvsRqstEdiSvcFlg() {
		return this.dvsRqstEdiSvcFlg;
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
	 * @return cmWt
	 */
	public String getCmWt() {
		return this.cmWt;
	}
	
	/**
	 * Column Info
	 * @return blPk
	 */
	public String getBlPk() {
		return this.blPk;
	}
	
	/**
	 * Column Info
	 * @return trsmVal
	 */
	public String getTrsmVal() {
		return this.trsmVal;
	}
	
	/**
	 * Column Info
	 * @return ataYn
	 */
	public String getAtaYn() {
		return this.ataYn;
	}
	
	/**
	 * Column Info
	 * @return ttlBl
	 */
	public String getTtlBl() {
		return this.ttlBl;
	}
	
	/**
	 * Column Info
	 * @return cntrWt
	 */
	public String getCntrWt() {
		return this.cntrWt;
	}
	
	/**
	 * Column Info
	 * @return unsentBlCnt
	 */
	public String getUnsentBlCnt() {
		return this.unsentBlCnt;
	}
	
	/**
	 * Column Info
	 * @return cstmsEstmArrDt
	 */
	public String getCstmsEstmArrDt() {
		return this.cstmsEstmArrDt;
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
	 * @return podClptIndSeq
	 */
	public String getPodClptIndSeq() {
		return this.podClptIndSeq;
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
	 * @return arnYn
	 */
	public String getArnYn() {
		return this.arnYn;
	}
	
	/**
	 * Column Info
	 * @return result2
	 */
	public String getResult2() {
		return this.result2;
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
	 * @return cneeAd
	 */
	public String getCneeAd() {
		return this.cneeAd;
	}
	
	/**
	 * Column Info
	 * @return blWt
	 */
	public String getBlWt() {
		return this.blWt;
	}
	
	/**
	 * Column Info
	 * @return ntfyStr
	 */
	public String getNtfyStr() {
		return this.ntfyStr;
	}
	
	/**
	 * Column Info
	 * @return rcvMsg
	 */
	public String getRcvMsg() {
		return this.rcvMsg;
	}
	
	/**
	 * Column Info
	 * @return ediRcvDt
	 */
	public String getEdiRcvDt() {
		return this.ediRcvDt;
	}
	
	/**
	 * Column Info
	 * @return ntfyEori
	 */
	public String getNtfyEori() {
		return this.ntfyEori;
	}
	
	/**
	 * Column Info
	 * @return ntfyZip
	 */
	public String getNtfyZip() {
		return this.ntfyZip;
	}
	
	/**
	 * Column Info
	 * @return ediTime
	 */
	public String getEdiTime() {
		return this.ediTime;
	}
	
	/**
	 * Column Info
	 * @return ntfyNm
	 */
	public String getNtfyNm() {
		return this.ntfyNm;
	}
	
	/**
	 * Column Info
	 * @return ediRcvSeq
	 */
	public String getEdiRcvSeq() {
		return this.ediRcvSeq;
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
	 * @param dnlCnt
	 */
	public void setDnlCnt(String dnlCnt) {
		this.dnlCnt = dnlCnt;
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
	 * @param shZip
	 */
	public void setShZip(String shZip) {
		this.shZip = shZip;
	}
	
	/**
	 * Column Info
	 * @param del
	 */
	public void setDel(String del) {
		this.del = del;
	}
	
	/**
	 * Column Info
	 * @param ediSent
	 */
	public void setEdiSent(String ediSent) {
		this.ediSent = ediSent;
	}
	
	/**
	 * Column Info
	 * @param searchEu1stPortYdCd
	 */
	public void setSearchEu1stPortYdCd(String searchEu1stPortYdCd) {
		this.searchEu1stPortYdCd = searchEu1stPortYdCd;
	}
	
	/**
	 * Column Info
	 * @param delYdCd
	 */
	public void setDelYdCd(String delYdCd) {
		this.delYdCd = delYdCd;
	}
	
	/**
	 * Column Info
	 * @param dtSeq
	 */
	public void setDtSeq(String dtSeq) {
		this.dtSeq = dtSeq;
	}
	
	/**
	 * Column Info
	 * @param shStr
	 */
	public void setShStr(String shStr) {
		this.shStr = shStr;
	}
	
	/**
	 * Column Info
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param ensEdiSvcFlg
	 */
	public void setEnsEdiSvcFlg(String ensEdiSvcFlg) {
		this.ensEdiSvcFlg = ensEdiSvcFlg;
	}
	
	/**
	 * Column Info
	 * @param cstmsClptIndSeq
	 */
	public void setCstmsClptIndSeq(String cstmsClptIndSeq) {
		this.cstmsClptIndSeq = cstmsClptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param ntfyCn
	 */
	public void setNtfyCn(String ntfyCn) {
		this.ntfyCn = ntfyCn;
	}
	
	/**
	 * Column Info
	 * @param anEdiSvcFlg
	 */
	public void setAnEdiSvcFlg(String anEdiSvcFlg) {
		this.anEdiSvcFlg = anEdiSvcFlg;
	}
	
	/**
	 * Column Info
	 * @param nlErrMsg
	 */
	public void setNlErrMsg(String nlErrMsg) {
		this.nlErrMsg = nlErrMsg;
	}
	
	/**
	 * Column Info
	 * @param pFiPolYardCd
	 */
	public void setPFiPolYardCd(String pFiPolYardCd) {
		this.pFiPolYardCd = pFiPolYardCd;
	}
	
	/**
	 * Column Info
	 * @param sentFailCnt
	 */
	public void setSentFailCnt(String sentFailCnt) {
		this.sentFailCnt = sentFailCnt;
	}
	
	/**
	 * Column Info
	 * @param polClptIndSeq
	 */
	public void setPolClptIndSeq(String polClptIndSeq) {
		this.polClptIndSeq = polClptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param cmPk
	 */
	public void setCmPk(String cmPk) {
		this.cmPk = cmPk;
	}
	
	/**
	 * Column Info
	 * @param vvdCnt
	 */
	public void setVvdCnt(String vvdCnt) {
		this.vvdCnt = vvdCnt;
	}
	
	/**
	 * Column Info
	 * @param ntfyCt
	 */
	public void setNtfyCt(String ntfyCt) {
		this.ntfyCt = ntfyCt;
	}
	
	/**
	 * Column Info
	 * @param cntrPk
	 */
	public void setCntrPk(String cntrPk) {
		this.cntrPk = cntrPk;
	}
	
	/**
	 * Column Info
	 * @param cneeCt
	 */
	public void setCneeCt(String cneeCt) {
		this.cneeCt = cneeCt;
	}
	
	/**
	 * Column Info
	 * @param downloadYn
	 */
	public void setDownloadYn(String downloadYn) {
		this.downloadYn = downloadYn;
	}
	
	/**
	 * Column Info
	 * @param cntrList
	 */
	public void setCntrList(String cntrList) {
		this.cntrList = cntrList;
	}
	
	/**
	 * Column Info
	 * @param cneeCn
	 */
	public void setCneeCn(String cneeCn) {
		this.cneeCn = cneeCn;
	}
	
	/**
	 * Column Info
	 * @param eu1stPortYdCd
	 */
	public void setEu1stPortYdCd(String eu1stPortYdCd) {
		this.eu1stPortYdCd = eu1stPortYdCd;
	}
	
	/**
	 * Column Info
	 * @param shEori
	 */
	public void setShEori(String shEori) {
		this.shEori = shEori;
	}
	
	/**
	 * Column Info
	 * @param rfsYn
	 */
	public void setRfsYn(String rfsYn) {
		this.rfsYn = rfsYn;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}
	
	/**
	 * Column Info
	 * @param cntrPkLmtFlg
	 */
	public void setCntrPkLmtFlg(String cntrPkLmtFlg) {
		this.cntrPkLmtFlg = cntrPkLmtFlg;
	}
	
	/**
	 * Column Info
	 * @param ensResult
	 */
	public void setEnsResult(String ensResult) {
		this.ensResult = ensResult;
	}
	
	/**
	 * Column Info
	 * @param cneeEori
	 */
	public void setCneeEori(String cneeEori) {
		this.cneeEori = cneeEori;
	}
	
	/**
	 * Column Info
	 * @param cneeNm
	 */
	public void setCneeNm(String cneeNm) {
		this.cneeNm = cneeNm;
	}
	
	/**
	 * Column Info
	 * @param nrCnt
	 */
	public void setNrCnt(String nrCnt) {
		this.nrCnt = nrCnt;
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
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
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
	 * @param eu1stPortClptSeq
	 */
	public void setEu1stPortClptSeq(String eu1stPortClptSeq) {
		this.eu1stPortClptSeq = eu1stPortClptSeq;
	}
	
	/**
	 * Column Info
	 * @param sentBlCnt
	 */
	public void setSentBlCnt(String sentBlCnt) {
		this.sentBlCnt = sentBlCnt;
	}
	
	/**
	 * Column Info
	 * @param result
	 */
	public void setResult(String result) {
		this.result = result;
	}
	
	/**
	 * Column Info
	 * @param ediMrn
	 */
	public void setEdiMrn(String ediMrn) {
		this.ediMrn = ediMrn;
	}
	
	/**
	 * Column Info
	 * @param blStatus
	 */
	public void setBlStatus(String blStatus) {
		this.blStatus = blStatus;
	}
	
	/**
	 * Column Info
	 * @param ntfyAd
	 */
	public void setNtfyAd(String ntfyAd) {
		this.ntfyAd = ntfyAd;
	}
	
	/**
	 * Column Info
	 * @param ttlCntr
	 */
	public void setTtlCntr(String ttlCntr) {
		this.ttlCntr = ttlCntr;
	}
	
	/**
	 * Column Info
	 * @param aCnt
	 */
	public void setACnt(String aCnt) {
		this.aCnt = aCnt;
	}
	
	/**
	 * Column Info
	 * @param trsmBlckFlg
	 */
	public void setTrsmBlckFlg(String trsmBlckFlg) {
		this.trsmBlckFlg = trsmBlckFlg;
	}
	
	/**
	 * Column Info
	 * @param drYn
	 */
	public void setDrYn(String drYn) {
		this.drYn = drYn;
	}
	
	/**
	 * Column Info
	 * @param downYnFirstOfMultiPofe
	 */
	public void setDownYnFirstOfMultiPofe(String downYnFirstOfMultiPofe) {
		this.downYnFirstOfMultiPofe = downYnFirstOfMultiPofe;
	}
	
	/**
	 * Column Info
	 * @param shAd
	 */
	public void setShAd(String shAd) {
		this.shAd = shAd;
	}
	
	/**
	 * Column Info
	 * @param etaErrMsg
	 */
	public void setEtaErrMsg(String etaErrMsg) {
		this.etaErrMsg = etaErrMsg;
	}
	
	/**
	 * Column Info
	 * @param ct
	 */
	public void setCt(String ct) {
		this.ct = ct;
	}
	
	/**
	 * Column Info
	 * @param ktsSendDt
	 */
	public void setKtsSendDt(String ktsSendDt) {
		this.ktsSendDt = ktsSendDt;
	}
	
	/**
	 * Column Info
	 * @param receivedTime
	 */
	public void setReceivedTime(String receivedTime) {
		this.receivedTime = receivedTime;
	}
	
	/**
	 * Column Info
	 * @param portOfcCd
	 */
	public void setPortOfcCd(String portOfcCd) {
		this.portOfcCd = portOfcCd;
	}
	
	/**
	 * Column Info
	 * @param sentSuccessCnt
	 */
	public void setSentSuccessCnt(String sentSuccessCnt) {
		this.sentSuccessCnt = sentSuccessCnt;
	}
	
	/**
	 * Column Info
	 * @param podYdCd
	 */
	public void setPodYdCd(String podYdCd) {
		this.podYdCd = podYdCd;
	}
	
	/**
	 * Column Info
	 * @param eu1stPort
	 */
	public void setEu1stPort(String eu1stPort) {
		this.eu1stPort = eu1stPort;
	}
	
	/**
	 * Column Info
	 * @param eu1stPortName
	 */
	public void setEu1stPortName(String eu1stPortName) {
		this.eu1stPortName = eu1stPortName;
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
	 * @param bpol
	 */
	public void setBpol(String bpol) {
		this.bpol = bpol;
	}
	
	/**
	 * Column Info
	 * @param cmMk
	 */
	public void setCmMk(String cmMk) {
		this.cmMk = cmMk;
	}
	
	/**
	 * Column Info
	 * @param polYdCd
	 */
	public void setPolYdCd(String polYdCd) {
		this.polYdCd = polYdCd;
	}
	
	/**
	 * Column Info
	 * @param lt
	 */
	public void setLt(String lt) {
		this.lt = lt;
	}
	
	/**
	 * Column Info
	 * @param euStfFlg
	 */
	public void setEuStfFlg(String euStfFlg) {
		this.euStfFlg = euStfFlg;
	}
	
	/**
	 * Column Info
	 * @param caCnt
	 */
	public void setCaCnt(String caCnt) {
		this.caCnt = caCnt;
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
	 * @param bpod
	 */
	public void setBpod(String bpod) {
		this.bpod = bpod;
	}
	
	/**
	 * Column Info
	 * @param ediRefNo
	 */
	public void setEdiRefNo(String ediRefNo) {
		this.ediRefNo = ediRefNo;
	}
	
	/**
	 * Column Info
	 * @param shCt
	 */
	public void setShCt(String shCt) {
		this.shCt = shCt;
	}
	
	/**
	 * Column Info
	 * @param shCn
	 */
	public void setShCn(String shCn) {
		this.shCn = shCn;
	}
	
	/**
	 * Column Info
	 * @param vpsPortYdCd
	 */
	public void setVpsPortYdCd(String vpsPortYdCd) {
		this.vpsPortYdCd = vpsPortYdCd;
	}
	
	/**
	 * Column Info
	 * @param pType
	 */
	public void setPType(String pType) {
		this.pType = pType;
	}
	
	/**
	 * Column Info
	 * @param cneeStr
	 */
	public void setCneeStr(String cneeStr) {
		this.cneeStr = cneeStr;
	}
	
	/**
	 * Column Info
	 * @param dtCheck
	 */
	public void setDtCheck(String dtCheck) {
		this.dtCheck = dtCheck;
	}
	
	/**
	 * Column Info
	 * @param cntrMs
	 */
	public void setCntrMs(String cntrMs) {
		this.cntrMs = cntrMs;
	}
	
	/**
	 * Column Info
	 * @param cmMs
	 */
	public void setCmMs(String cmMs) {
		this.cmMs = cmMs;
	}
	
	/**
	 * Column Info
	 * @param errYn
	 */
	public void setErrYn(String errYn) {
		this.errYn = errYn;
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
	 * @param rCnt
	 */
	public void setRCnt(String rCnt) {
		this.rCnt = rCnt;
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
	 * @param cntrCntrNo
	 */
	public void setCntrCntrNo(String cntrCntrNo) {
		this.cntrCntrNo = cntrCntrNo;
	}
	
	/**
	 * Column Info
	 * @param cntrSeal
	 */
	public void setCntrSeal(String cntrSeal) {
		this.cntrSeal = cntrSeal;
	}
	
	/**
	 * Column Info
	 * @param cneeZip
	 */
	public void setCneeZip(String cneeZip) {
		this.cneeZip = cneeZip;
	}
	
	/**
	 * Column Info
	 * @param ttlErrBl
	 */
	public void setTtlErrBl(String ttlErrBl) {
		this.ttlErrBl = ttlErrBl;
	}
	
	/**
	 * Column Info
	 * @param cmDs
	 */
	public void setCmDs(String cmDs) {
		this.cmDs = cmDs;
	}
	
	/**
	 * Column Info
	 * @param alCnt
	 */
	public void setAlCnt(String alCnt) {
		this.alCnt = alCnt;
	}
	
	/**
	 * Column Info
	 * @param cmHts
	 */
	public void setCmHts(String cmHts) {
		this.cmHts = cmHts;
	}
	
	/**
	 * Column Info
	 * @param sentTime
	 */
	public void setSentTime(String sentTime) {
		this.sentTime = sentTime;
	}
	
	/**
	 * Column Info
	 * @param pFiPolCd
	 */
	public void setPFiPolCd(String pFiPolCd) {
		this.pFiPolCd = pFiPolCd;
	}
	
	/**
	 * Column Info
	 * @param blMs
	 */
	public void setBlMs(String blMs) {
		this.blMs = blMs;
	}
	
	/**
	 * Column Info
	 * @param shNm
	 */
	public void setShNm(String shNm) {
		this.shNm = shNm;
	}
	
	/**
	 * Column Info
	 * @param dvsRqstEdiSvcFlg
	 */
	public void setDvsRqstEdiSvcFlg(String dvsRqstEdiSvcFlg) {
		this.dvsRqstEdiSvcFlg = dvsRqstEdiSvcFlg;
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
	 * @param cmWt
	 */
	public void setCmWt(String cmWt) {
		this.cmWt = cmWt;
	}
	
	/**
	 * Column Info
	 * @param blPk
	 */
	public void setBlPk(String blPk) {
		this.blPk = blPk;
	}
	
	/**
	 * Column Info
	 * @param trsmVal
	 */
	public void setTrsmVal(String trsmVal) {
		this.trsmVal = trsmVal;
	}
	
	/**
	 * Column Info
	 * @param ataYn
	 */
	public void setAtaYn(String ataYn) {
		this.ataYn = ataYn;
	}
	
	/**
	 * Column Info
	 * @param ttlBl
	 */
	public void setTtlBl(String ttlBl) {
		this.ttlBl = ttlBl;
	}
	
	/**
	 * Column Info
	 * @param cntrWt
	 */
	public void setCntrWt(String cntrWt) {
		this.cntrWt = cntrWt;
	}
	
	/**
	 * Column Info
	 * @param unsentBlCnt
	 */
	public void setUnsentBlCnt(String unsentBlCnt) {
		this.unsentBlCnt = unsentBlCnt;
	}
	
	/**
	 * Column Info
	 * @param cstmsEstmArrDt
	 */
	public void setCstmsEstmArrDt(String cstmsEstmArrDt) {
		this.cstmsEstmArrDt = cstmsEstmArrDt;
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
	 * @param podClptIndSeq
	 */
	public void setPodClptIndSeq(String podClptIndSeq) {
		this.podClptIndSeq = podClptIndSeq;
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
	 * @param arnYn
	 */
	public void setArnYn(String arnYn) {
		this.arnYn = arnYn;
	}
	
	/**
	 * Column Info
	 * @param result2
	 */
	public void setResult2(String result2) {
		this.result2 = result2;
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
	 * @param cneeAd
	 */
	public void setCneeAd(String cneeAd) {
		this.cneeAd = cneeAd;
	}
	
	/**
	 * Column Info
	 * @param blWt
	 */
	public void setBlWt(String blWt) {
		this.blWt = blWt;
	}
	
	/**
	 * Column Info
	 * @param ntfyStr
	 */
	public void setNtfyStr(String ntfyStr) {
		this.ntfyStr = ntfyStr;
	}
	
	/**
	 * Column Info
	 * @param rcvMsg
	 */
	public void setRcvMsg(String rcvMsg) {
		this.rcvMsg = rcvMsg;
	}
	
	/**
	 * Column Info
	 * @param ediRcvDt
	 */
	public void setEdiRcvDt(String ediRcvDt) {
		this.ediRcvDt = ediRcvDt;
	}
	
	/**
	 * Column Info
	 * @param ntfyEori
	 */
	public void setNtfyEori(String ntfyEori) {
		this.ntfyEori = ntfyEori;
	}
	
	/**
	 * Column Info
	 * @param ntfyZip
	 */
	public void setNtfyZip(String ntfyZip) {
		this.ntfyZip = ntfyZip;
	}
	
	/**
	 * Column Info
	 * @param ediTime
	 */
	public void setEdiTime(String ediTime) {
		this.ediTime = ediTime;
	}
	
	/**
	 * Column Info
	 * @param ntfyNm
	 */
	public void setNtfyNm(String ntfyNm) {
		this.ntfyNm = ntfyNm;
	}
	
	/**
	 * Column Info
	 * @param ediRcvSeq
	 */
	public void setEdiRcvSeq(String ediRcvSeq) {
		this.ediRcvSeq = ediRcvSeq;
	}
	
	/**
	 * Column Info
	 * @param clptIndSeq
	 */
	public void setClptIndSeq(String clptIndSeq) {
		this.clptIndSeq = clptIndSeq;
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
		setDnlCnt(JSPUtil.getParameter(request, prefix + "dnl_cnt", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setShZip(JSPUtil.getParameter(request, prefix + "sh_zip", ""));
		setDel(JSPUtil.getParameter(request, prefix + "del", ""));
		setEdiSent(JSPUtil.getParameter(request, prefix + "edi_sent", ""));
		setSearchEu1stPortYdCd(JSPUtil.getParameter(request, prefix + "search_eu_1st_port_yd_cd", ""));
		setDelYdCd(JSPUtil.getParameter(request, prefix + "del_yd_cd", ""));
		setDtSeq(JSPUtil.getParameter(request, prefix + "dt_seq", ""));
		setShStr(JSPUtil.getParameter(request, prefix + "sh_str", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setEnsEdiSvcFlg(JSPUtil.getParameter(request, prefix + "ens_edi_svc_flg", ""));
		setCstmsClptIndSeq(JSPUtil.getParameter(request, prefix + "cstms_clpt_ind_seq", ""));
		setNtfyCn(JSPUtil.getParameter(request, prefix + "ntfy_cn", ""));
		setAnEdiSvcFlg(JSPUtil.getParameter(request, prefix + "an_edi_svc_flg", ""));
		setNlErrMsg(JSPUtil.getParameter(request, prefix + "nl_err_msg", ""));
		setPFiPolYardCd(JSPUtil.getParameter(request, prefix + "p_fi_pol_yard_cd", ""));
		setSentFailCnt(JSPUtil.getParameter(request, prefix + "sent_fail_cnt", ""));
		setPolClptIndSeq(JSPUtil.getParameter(request, prefix + "pol_clpt_ind_seq", ""));
		setCmPk(JSPUtil.getParameter(request, prefix + "cm_pk", ""));
		setVvdCnt(JSPUtil.getParameter(request, prefix + "vvd_cnt", ""));
		setNtfyCt(JSPUtil.getParameter(request, prefix + "ntfy_ct", ""));
		setCntrPk(JSPUtil.getParameter(request, prefix + "cntr_pk", ""));
		setCneeCt(JSPUtil.getParameter(request, prefix + "cnee_ct", ""));
		setDownloadYn(JSPUtil.getParameter(request, prefix + "download_yn", ""));
		setCntrList(JSPUtil.getParameter(request, prefix + "cntr_list", ""));
		setCneeCn(JSPUtil.getParameter(request, prefix + "cnee_cn", ""));
		setEu1stPortYdCd(JSPUtil.getParameter(request, prefix + "eu_1st_port_yd_cd", ""));
		setShEori(JSPUtil.getParameter(request, prefix + "sh_eori", ""));
		setRfsYn(JSPUtil.getParameter(request, prefix + "rfs_yn", ""));
		setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
		setCntrPkLmtFlg(JSPUtil.getParameter(request, prefix + "cntr_pk_lmt_flg", ""));
		setEnsResult(JSPUtil.getParameter(request, prefix + "ens_result", ""));
		setCneeEori(JSPUtil.getParameter(request, prefix + "cnee_eori", ""));
		setCneeNm(JSPUtil.getParameter(request, prefix + "cnee_nm", ""));
		setNrCnt(JSPUtil.getParameter(request, prefix + "nr_cnt", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setPol(JSPUtil.getParameter(request, prefix + "pol", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setEu1stPortClptSeq(JSPUtil.getParameter(request, prefix + "eu_1st_port_clpt_seq", ""));
		setSentBlCnt(JSPUtil.getParameter(request, prefix + "sent_bl_cnt", ""));
		setResult(JSPUtil.getParameter(request, prefix + "result", ""));
		setEdiMrn(JSPUtil.getParameter(request, prefix + "edi_mrn", ""));
		setBlStatus(JSPUtil.getParameter(request, prefix + "bl_status", ""));
		setNtfyAd(JSPUtil.getParameter(request, prefix + "ntfy_ad", ""));
		setTtlCntr(JSPUtil.getParameter(request, prefix + "ttl_cntr", ""));
		setACnt(JSPUtil.getParameter(request, prefix + "a_cnt", ""));
		setTrsmBlckFlg(JSPUtil.getParameter(request, prefix + "trsm_blck_flg", ""));
		setDrYn(JSPUtil.getParameter(request, prefix + "dr_yn", ""));
		setDownYnFirstOfMultiPofe(JSPUtil.getParameter(request, prefix + "down_yn_first_of_multi_pofe", ""));
		setShAd(JSPUtil.getParameter(request, prefix + "sh_ad", ""));
		setEtaErrMsg(JSPUtil.getParameter(request, prefix + "eta_err_msg", ""));
		setCt(JSPUtil.getParameter(request, prefix + "ct", ""));
		setKtsSendDt(JSPUtil.getParameter(request, prefix + "kts_send_dt", ""));
		setReceivedTime(JSPUtil.getParameter(request, prefix + "received_time", ""));
		setPortOfcCd(JSPUtil.getParameter(request, prefix + "port_ofc_cd", ""));
		setSentSuccessCnt(JSPUtil.getParameter(request, prefix + "sent_success_cnt", ""));
		setPodYdCd(JSPUtil.getParameter(request, prefix + "pod_yd_cd", ""));
		setEu1stPort(JSPUtil.getParameter(request, prefix + "eu_1st_port", ""));
		setEu1stPortName(JSPUtil.getParameter(request, prefix + "eu_1st_port_name", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setBpol(JSPUtil.getParameter(request, prefix + "bpol", ""));
		setCmMk(JSPUtil.getParameter(request, prefix + "cm_mk", ""));
		setPolYdCd(JSPUtil.getParameter(request, prefix + "pol_yd_cd", ""));
		setLt(JSPUtil.getParameter(request, prefix + "lt", ""));
		setEuStfFlg(JSPUtil.getParameter(request, prefix + "eu_stf_flg", ""));
		setCaCnt(JSPUtil.getParameter(request, prefix + "ca_cnt", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, prefix + "vps_eta_dt", ""));
		setBpod(JSPUtil.getParameter(request, prefix + "bpod", ""));
		setEdiRefNo(JSPUtil.getParameter(request, prefix + "edi_ref_no", ""));
		setShCt(JSPUtil.getParameter(request, prefix + "sh_ct", ""));
		setShCn(JSPUtil.getParameter(request, prefix + "sh_cn", ""));
		setVpsPortYdCd(JSPUtil.getParameter(request, prefix + "vps_port_yd_cd", ""));
		setPType(JSPUtil.getParameter(request, prefix + "p_type", ""));
		setCneeStr(JSPUtil.getParameter(request, prefix + "cnee_str", ""));
		setDtCheck(JSPUtil.getParameter(request, prefix + "dt_check", ""));
		setCntrMs(JSPUtil.getParameter(request, prefix + "cntr_ms", ""));
		setCmMs(JSPUtil.getParameter(request, prefix + "cm_ms", ""));
		setErrYn(JSPUtil.getParameter(request, prefix + "err_yn", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRCnt(JSPUtil.getParameter(request, prefix + "r_cnt", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setCntrCntrNo(JSPUtil.getParameter(request, prefix + "cntr_cntr_no", ""));
		setCntrSeal(JSPUtil.getParameter(request, prefix + "cntr_seal", ""));
		setCneeZip(JSPUtil.getParameter(request, prefix + "cnee_zip", ""));
		setTtlErrBl(JSPUtil.getParameter(request, prefix + "ttl_err_bl", ""));
		setCmDs(JSPUtil.getParameter(request, prefix + "cm_ds", ""));
		setAlCnt(JSPUtil.getParameter(request, prefix + "al_cnt", ""));
		setCmHts(JSPUtil.getParameter(request, prefix + "cm_hts", ""));
		setSentTime(JSPUtil.getParameter(request, prefix + "sent_time", ""));
		setPFiPolCd(JSPUtil.getParameter(request, prefix + "p_fi_pol_cd", ""));
		setBlMs(JSPUtil.getParameter(request, prefix + "bl_ms", ""));
		setShNm(JSPUtil.getParameter(request, prefix + "sh_nm", ""));
		setDvsRqstEdiSvcFlg(JSPUtil.getParameter(request, prefix + "dvs_rqst_edi_svc_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCmWt(JSPUtil.getParameter(request, prefix + "cm_wt", ""));
		setBlPk(JSPUtil.getParameter(request, prefix + "bl_pk", ""));
		setTrsmVal(JSPUtil.getParameter(request, prefix + "trsm_val", ""));
		setAtaYn(JSPUtil.getParameter(request, prefix + "ata_yn", ""));
		setTtlBl(JSPUtil.getParameter(request, prefix + "ttl_bl", ""));
		setCntrWt(JSPUtil.getParameter(request, prefix + "cntr_wt", ""));
		setUnsentBlCnt(JSPUtil.getParameter(request, prefix + "unsent_bl_cnt", ""));
		setCstmsEstmArrDt(JSPUtil.getParameter(request, prefix + "cstms_estm_arr_dt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPodClptIndSeq(JSPUtil.getParameter(request, prefix + "pod_clpt_ind_seq", ""));
		setMsgSndNo(JSPUtil.getParameter(request, prefix + "msg_snd_no", ""));
		setArnYn(JSPUtil.getParameter(request, prefix + "arn_yn", ""));
		setResult2(JSPUtil.getParameter(request, prefix + "result2", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setCneeAd(JSPUtil.getParameter(request, prefix + "cnee_ad", ""));
		setBlWt(JSPUtil.getParameter(request, prefix + "bl_wt", ""));
		setNtfyStr(JSPUtil.getParameter(request, prefix + "ntfy_str", ""));
		setRcvMsg(JSPUtil.getParameter(request, prefix + "rcv_msg", ""));
		setEdiRcvDt(JSPUtil.getParameter(request, prefix + "edi_rcv_dt", ""));
		setNtfyEori(JSPUtil.getParameter(request, prefix + "ntfy_eori", ""));
		setNtfyZip(JSPUtil.getParameter(request, prefix + "ntfy_zip", ""));
		setEdiTime(JSPUtil.getParameter(request, prefix + "edi_time", ""));
		setNtfyNm(JSPUtil.getParameter(request, prefix + "ntfy_nm", ""));
		setEdiRcvSeq(JSPUtil.getParameter(request, prefix + "edi_rcv_seq", ""));
		setClptIndSeq(JSPUtil.getParameter(request, prefix + "clpt_ind_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Eu24ManifestListVO[]
	 */
	public Eu24ManifestListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return Eu24ManifestListVO[]
	 */
	public Eu24ManifestListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Eu24ManifestListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dnlCnt = (JSPUtil.getParameter(request, prefix	+ "dnl_cnt", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] shZip = (JSPUtil.getParameter(request, prefix	+ "sh_zip", length));
			String[] del = (JSPUtil.getParameter(request, prefix	+ "del", length));
			String[] ediSent = (JSPUtil.getParameter(request, prefix	+ "edi_sent", length));
			String[] searchEu1stPortYdCd = (JSPUtil.getParameter(request, prefix	+ "search_eu_1st_port_yd_cd", length));
			String[] delYdCd = (JSPUtil.getParameter(request, prefix	+ "del_yd_cd", length));
			String[] dtSeq = (JSPUtil.getParameter(request, prefix	+ "dt_seq", length));
			String[] shStr = (JSPUtil.getParameter(request, prefix	+ "sh_str", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] ensEdiSvcFlg = (JSPUtil.getParameter(request, prefix	+ "ens_edi_svc_flg", length));
			String[] cstmsClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "cstms_clpt_ind_seq", length));
			String[] ntfyCn = (JSPUtil.getParameter(request, prefix	+ "ntfy_cn", length));
			String[] anEdiSvcFlg = (JSPUtil.getParameter(request, prefix	+ "an_edi_svc_flg", length));
			String[] nlErrMsg = (JSPUtil.getParameter(request, prefix	+ "nl_err_msg", length));
			String[] pFiPolYardCd = (JSPUtil.getParameter(request, prefix	+ "p_fi_pol_yard_cd", length));
			String[] sentFailCnt = (JSPUtil.getParameter(request, prefix	+ "sent_fail_cnt", length));
			String[] polClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "pol_clpt_ind_seq", length));
			String[] cmPk = (JSPUtil.getParameter(request, prefix	+ "cm_pk", length));
			String[] vvdCnt = (JSPUtil.getParameter(request, prefix	+ "vvd_cnt", length));
			String[] ntfyCt = (JSPUtil.getParameter(request, prefix	+ "ntfy_ct", length));
			String[] cntrPk = (JSPUtil.getParameter(request, prefix	+ "cntr_pk", length));
			String[] cneeCt = (JSPUtil.getParameter(request, prefix	+ "cnee_ct", length));
			String[] downloadYn = (JSPUtil.getParameter(request, prefix	+ "download_yn", length));
			String[] cntrList = (JSPUtil.getParameter(request, prefix	+ "cntr_list", length));
			String[] cneeCn = (JSPUtil.getParameter(request, prefix	+ "cnee_cn", length));
			String[] eu1stPortYdCd = (JSPUtil.getParameter(request, prefix	+ "eu_1st_port_yd_cd", length));
			String[] shEori = (JSPUtil.getParameter(request, prefix	+ "sh_eori", length));
			String[] rfsYn = (JSPUtil.getParameter(request, prefix	+ "rfs_yn", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] cntrPkLmtFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_pk_lmt_flg", length));
			String[] ensResult = (JSPUtil.getParameter(request, prefix	+ "ens_result", length));
			String[] cneeEori = (JSPUtil.getParameter(request, prefix	+ "cnee_eori", length));
			String[] cneeNm = (JSPUtil.getParameter(request, prefix	+ "cnee_nm", length));
			String[] nrCnt = (JSPUtil.getParameter(request, prefix	+ "nr_cnt", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] eu1stPortClptSeq = (JSPUtil.getParameter(request, prefix	+ "eu_1st_port_clpt_seq", length));
			String[] sentBlCnt = (JSPUtil.getParameter(request, prefix	+ "sent_bl_cnt", length));
			String[] result = (JSPUtil.getParameter(request, prefix	+ "result", length));
			String[] ediMrn = (JSPUtil.getParameter(request, prefix	+ "edi_mrn", length));
			String[] blStatus = (JSPUtil.getParameter(request, prefix	+ "bl_status", length));
			String[] ntfyAd = (JSPUtil.getParameter(request, prefix	+ "ntfy_ad", length));
			String[] ttlCntr = (JSPUtil.getParameter(request, prefix	+ "ttl_cntr", length));
			String[] aCnt = (JSPUtil.getParameter(request, prefix	+ "a_cnt", length));
			String[] trsmBlckFlg = (JSPUtil.getParameter(request, prefix	+ "trsm_blck_flg", length));
			String[] drYn = (JSPUtil.getParameter(request, prefix	+ "dr_yn", length));
			String[] downYnFirstOfMultiPofe = (JSPUtil.getParameter(request, prefix	+ "down_yn_first_of_multi_pofe", length));
			String[] shAd = (JSPUtil.getParameter(request, prefix	+ "sh_ad", length));
			String[] etaErrMsg = (JSPUtil.getParameter(request, prefix	+ "eta_err_msg", length));
			String[] ct = (JSPUtil.getParameter(request, prefix	+ "ct", length));
			String[] ktsSendDt = (JSPUtil.getParameter(request, prefix	+ "kts_send_dt", length));
			String[] receivedTime = (JSPUtil.getParameter(request, prefix	+ "received_time", length));
			String[] portOfcCd = (JSPUtil.getParameter(request, prefix	+ "port_ofc_cd", length));
			String[] sentSuccessCnt = (JSPUtil.getParameter(request, prefix	+ "sent_success_cnt", length));
			String[] podYdCd = (JSPUtil.getParameter(request, prefix	+ "pod_yd_cd", length));
			String[] eu1stPort = (JSPUtil.getParameter(request, prefix	+ "eu_1st_port", length));
			String[] eu1stPortName = (JSPUtil.getParameter(request, prefix	+ "eu_1st_port_name", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] bpol = (JSPUtil.getParameter(request, prefix	+ "bpol", length));
			String[] cmMk = (JSPUtil.getParameter(request, prefix	+ "cm_mk", length));
			String[] polYdCd = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd", length));
			String[] lt = (JSPUtil.getParameter(request, prefix	+ "lt", length));
			String[] euStfFlg = (JSPUtil.getParameter(request, prefix	+ "eu_stf_flg", length));
			String[] caCnt = (JSPUtil.getParameter(request, prefix	+ "ca_cnt", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] bpod = (JSPUtil.getParameter(request, prefix	+ "bpod", length));
			String[] ediRefNo = (JSPUtil.getParameter(request, prefix	+ "edi_ref_no", length));
			String[] shCt = (JSPUtil.getParameter(request, prefix	+ "sh_ct", length));
			String[] shCn = (JSPUtil.getParameter(request, prefix	+ "sh_cn", length));
			String[] vpsPortYdCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_yd_cd", length));
			String[] pType = (JSPUtil.getParameter(request, prefix	+ "p_type", length));
			String[] cneeStr = (JSPUtil.getParameter(request, prefix	+ "cnee_str", length));
			String[] dtCheck = (JSPUtil.getParameter(request, prefix	+ "dt_check", length));
			String[] cntrMs = (JSPUtil.getParameter(request, prefix	+ "cntr_ms", length));
			String[] cmMs = (JSPUtil.getParameter(request, prefix	+ "cm_ms", length));
			String[] errYn = (JSPUtil.getParameter(request, prefix	+ "err_yn", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rCnt = (JSPUtil.getParameter(request, prefix	+ "r_cnt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] cntrCntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_cntr_no", length));
			String[] cntrSeal = (JSPUtil.getParameter(request, prefix	+ "cntr_seal", length));
			String[] cneeZip = (JSPUtil.getParameter(request, prefix	+ "cnee_zip", length));
			String[] ttlErrBl = (JSPUtil.getParameter(request, prefix	+ "ttl_err_bl", length));
			String[] cmDs = (JSPUtil.getParameter(request, prefix	+ "cm_ds", length));
			String[] alCnt = (JSPUtil.getParameter(request, prefix	+ "al_cnt", length));
			String[] cmHts = (JSPUtil.getParameter(request, prefix	+ "cm_hts", length));
			String[] sentTime = (JSPUtil.getParameter(request, prefix	+ "sent_time", length));
			String[] pFiPolCd = (JSPUtil.getParameter(request, prefix	+ "p_fi_pol_cd", length));
			String[] blMs = (JSPUtil.getParameter(request, prefix	+ "bl_ms", length));
			String[] shNm = (JSPUtil.getParameter(request, prefix	+ "sh_nm", length));
			String[] dvsRqstEdiSvcFlg = (JSPUtil.getParameter(request, prefix	+ "dvs_rqst_edi_svc_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cmWt = (JSPUtil.getParameter(request, prefix	+ "cm_wt", length));
			String[] blPk = (JSPUtil.getParameter(request, prefix	+ "bl_pk", length));
			String[] trsmVal = (JSPUtil.getParameter(request, prefix	+ "trsm_val", length));
			String[] ataYn = (JSPUtil.getParameter(request, prefix	+ "ata_yn", length));
			String[] ttlBl = (JSPUtil.getParameter(request, prefix	+ "ttl_bl", length));
			String[] cntrWt = (JSPUtil.getParameter(request, prefix	+ "cntr_wt", length));
			String[] unsentBlCnt = (JSPUtil.getParameter(request, prefix	+ "unsent_bl_cnt", length));
			String[] cstmsEstmArrDt = (JSPUtil.getParameter(request, prefix	+ "cstms_estm_arr_dt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] podClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "pod_clpt_ind_seq", length));
			String[] msgSndNo = (JSPUtil.getParameter(request, prefix	+ "msg_snd_no", length));
			String[] arnYn = (JSPUtil.getParameter(request, prefix	+ "arn_yn", length));
			String[] result2 = (JSPUtil.getParameter(request, prefix	+ "result2", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] cneeAd = (JSPUtil.getParameter(request, prefix	+ "cnee_ad", length));
			String[] blWt = (JSPUtil.getParameter(request, prefix	+ "bl_wt", length));
			String[] ntfyStr = (JSPUtil.getParameter(request, prefix	+ "ntfy_str", length));
			String[] rcvMsg = (JSPUtil.getParameter(request, prefix	+ "rcv_msg", length));
			String[] ediRcvDt = (JSPUtil.getParameter(request, prefix	+ "edi_rcv_dt", length));
			String[] ntfyEori = (JSPUtil.getParameter(request, prefix	+ "ntfy_eori", length));
			String[] ntfyZip = (JSPUtil.getParameter(request, prefix	+ "ntfy_zip", length));
			String[] ediTime = (JSPUtil.getParameter(request, prefix	+ "edi_time", length));
			String[] ntfyNm = (JSPUtil.getParameter(request, prefix	+ "ntfy_nm", length));
			String[] ediRcvSeq = (JSPUtil.getParameter(request, prefix	+ "edi_rcv_seq", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new Eu24ManifestListVO();
				if (dnlCnt[i] != null)
					model.setDnlCnt(dnlCnt[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (shZip[i] != null)
					model.setShZip(shZip[i]);
				if (del[i] != null)
					model.setDel(del[i]);
				if (ediSent[i] != null)
					model.setEdiSent(ediSent[i]);
				if (searchEu1stPortYdCd[i] != null)
					model.setSearchEu1stPortYdCd(searchEu1stPortYdCd[i]);
				if (delYdCd[i] != null)
					model.setDelYdCd(delYdCd[i]);
				if (dtSeq[i] != null)
					model.setDtSeq(dtSeq[i]);
				if (shStr[i] != null)
					model.setShStr(shStr[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (ensEdiSvcFlg[i] != null)
					model.setEnsEdiSvcFlg(ensEdiSvcFlg[i]);
				if (cstmsClptIndSeq[i] != null)
					model.setCstmsClptIndSeq(cstmsClptIndSeq[i]);
				if (ntfyCn[i] != null)
					model.setNtfyCn(ntfyCn[i]);
				if (anEdiSvcFlg[i] != null)
					model.setAnEdiSvcFlg(anEdiSvcFlg[i]);
				if (nlErrMsg[i] != null)
					model.setNlErrMsg(nlErrMsg[i]);
				if (pFiPolYardCd[i] != null)
					model.setPFiPolYardCd(pFiPolYardCd[i]);
				if (sentFailCnt[i] != null)
					model.setSentFailCnt(sentFailCnt[i]);
				if (polClptIndSeq[i] != null)
					model.setPolClptIndSeq(polClptIndSeq[i]);
				if (cmPk[i] != null)
					model.setCmPk(cmPk[i]);
				if (vvdCnt[i] != null)
					model.setVvdCnt(vvdCnt[i]);
				if (ntfyCt[i] != null)
					model.setNtfyCt(ntfyCt[i]);
				if (cntrPk[i] != null)
					model.setCntrPk(cntrPk[i]);
				if (cneeCt[i] != null)
					model.setCneeCt(cneeCt[i]);
				if (downloadYn[i] != null)
					model.setDownloadYn(downloadYn[i]);
				if (cntrList[i] != null)
					model.setCntrList(cntrList[i]);
				if (cneeCn[i] != null)
					model.setCneeCn(cneeCn[i]);
				if (eu1stPortYdCd[i] != null)
					model.setEu1stPortYdCd(eu1stPortYdCd[i]);
				if (shEori[i] != null)
					model.setShEori(shEori[i]);
				if (rfsYn[i] != null)
					model.setRfsYn(rfsYn[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (cntrPkLmtFlg[i] != null)
					model.setCntrPkLmtFlg(cntrPkLmtFlg[i]);
				if (ensResult[i] != null)
					model.setEnsResult(ensResult[i]);
				if (cneeEori[i] != null)
					model.setCneeEori(cneeEori[i]);
				if (cneeNm[i] != null)
					model.setCneeNm(cneeNm[i]);
				if (nrCnt[i] != null)
					model.setNrCnt(nrCnt[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (eu1stPortClptSeq[i] != null)
					model.setEu1stPortClptSeq(eu1stPortClptSeq[i]);
				if (sentBlCnt[i] != null)
					model.setSentBlCnt(sentBlCnt[i]);
				if (result[i] != null)
					model.setResult(result[i]);
				if (ediMrn[i] != null)
					model.setEdiMrn(ediMrn[i]);
				if (blStatus[i] != null)
					model.setBlStatus(blStatus[i]);
				if (ntfyAd[i] != null)
					model.setNtfyAd(ntfyAd[i]);
				if (ttlCntr[i] != null)
					model.setTtlCntr(ttlCntr[i]);
				if (aCnt[i] != null)
					model.setACnt(aCnt[i]);
				if (trsmBlckFlg[i] != null)
					model.setTrsmBlckFlg(trsmBlckFlg[i]);
				if (drYn[i] != null)
					model.setDrYn(drYn[i]);
				if (downYnFirstOfMultiPofe[i] != null)
					model.setDownYnFirstOfMultiPofe(downYnFirstOfMultiPofe[i]);
				if (shAd[i] != null)
					model.setShAd(shAd[i]);
				if (etaErrMsg[i] != null)
					model.setEtaErrMsg(etaErrMsg[i]);
				if (ct[i] != null)
					model.setCt(ct[i]);
				if (ktsSendDt[i] != null)
					model.setKtsSendDt(ktsSendDt[i]);
				if (receivedTime[i] != null)
					model.setReceivedTime(receivedTime[i]);
				if (portOfcCd[i] != null)
					model.setPortOfcCd(portOfcCd[i]);
				if (sentSuccessCnt[i] != null)
					model.setSentSuccessCnt(sentSuccessCnt[i]);
				if (podYdCd[i] != null)
					model.setPodYdCd(podYdCd[i]);
				if (eu1stPort[i] != null)
					model.setEu1stPort(eu1stPort[i]);
				if (eu1stPortName[i] != null)
					model.setEu1stPortName(eu1stPortName[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (bpol[i] != null)
					model.setBpol(bpol[i]);
				if (cmMk[i] != null)
					model.setCmMk(cmMk[i]);
				if (polYdCd[i] != null)
					model.setPolYdCd(polYdCd[i]);
				if (lt[i] != null)
					model.setLt(lt[i]);
				if (euStfFlg[i] != null)
					model.setEuStfFlg(euStfFlg[i]);
				if (caCnt[i] != null)
					model.setCaCnt(caCnt[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (bpod[i] != null)
					model.setBpod(bpod[i]);
				if (ediRefNo[i] != null)
					model.setEdiRefNo(ediRefNo[i]);
				if (shCt[i] != null)
					model.setShCt(shCt[i]);
				if (shCn[i] != null)
					model.setShCn(shCn[i]);
				if (vpsPortYdCd[i] != null)
					model.setVpsPortYdCd(vpsPortYdCd[i]);
				if (pType[i] != null)
					model.setPType(pType[i]);
				if (cneeStr[i] != null)
					model.setCneeStr(cneeStr[i]);
				if (dtCheck[i] != null)
					model.setDtCheck(dtCheck[i]);
				if (cntrMs[i] != null)
					model.setCntrMs(cntrMs[i]);
				if (cmMs[i] != null)
					model.setCmMs(cmMs[i]);
				if (errYn[i] != null)
					model.setErrYn(errYn[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rCnt[i] != null)
					model.setRCnt(rCnt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (cntrCntrNo[i] != null)
					model.setCntrCntrNo(cntrCntrNo[i]);
				if (cntrSeal[i] != null)
					model.setCntrSeal(cntrSeal[i]);
				if (cneeZip[i] != null)
					model.setCneeZip(cneeZip[i]);
				if (ttlErrBl[i] != null)
					model.setTtlErrBl(ttlErrBl[i]);
				if (cmDs[i] != null)
					model.setCmDs(cmDs[i]);
				if (alCnt[i] != null)
					model.setAlCnt(alCnt[i]);
				if (cmHts[i] != null)
					model.setCmHts(cmHts[i]);
				if (sentTime[i] != null)
					model.setSentTime(sentTime[i]);
				if (pFiPolCd[i] != null)
					model.setPFiPolCd(pFiPolCd[i]);
				if (blMs[i] != null)
					model.setBlMs(blMs[i]);
				if (shNm[i] != null)
					model.setShNm(shNm[i]);
				if (dvsRqstEdiSvcFlg[i] != null)
					model.setDvsRqstEdiSvcFlg(dvsRqstEdiSvcFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cmWt[i] != null)
					model.setCmWt(cmWt[i]);
				if (blPk[i] != null)
					model.setBlPk(blPk[i]);
				if (trsmVal[i] != null)
					model.setTrsmVal(trsmVal[i]);
				if (ataYn[i] != null)
					model.setAtaYn(ataYn[i]);
				if (ttlBl[i] != null)
					model.setTtlBl(ttlBl[i]);
				if (cntrWt[i] != null)
					model.setCntrWt(cntrWt[i]);
				if (unsentBlCnt[i] != null)
					model.setUnsentBlCnt(unsentBlCnt[i]);
				if (cstmsEstmArrDt[i] != null)
					model.setCstmsEstmArrDt(cstmsEstmArrDt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (podClptIndSeq[i] != null)
					model.setPodClptIndSeq(podClptIndSeq[i]);
				if (msgSndNo[i] != null)
					model.setMsgSndNo(msgSndNo[i]);
				if (arnYn[i] != null)
					model.setArnYn(arnYn[i]);
				if (result2[i] != null)
					model.setResult2(result2[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (cneeAd[i] != null)
					model.setCneeAd(cneeAd[i]);
				if (blWt[i] != null)
					model.setBlWt(blWt[i]);
				if (ntfyStr[i] != null)
					model.setNtfyStr(ntfyStr[i]);
				if (rcvMsg[i] != null)
					model.setRcvMsg(rcvMsg[i]);
				if (ediRcvDt[i] != null)
					model.setEdiRcvDt(ediRcvDt[i]);
				if (ntfyEori[i] != null)
					model.setNtfyEori(ntfyEori[i]);
				if (ntfyZip[i] != null)
					model.setNtfyZip(ntfyZip[i]);
				if (ediTime[i] != null)
					model.setEdiTime(ediTime[i]);
				if (ntfyNm[i] != null)
					model.setNtfyNm(ntfyNm[i]);
				if (ediRcvSeq[i] != null)
					model.setEdiRcvSeq(ediRcvSeq[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEu24ManifestListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Eu24ManifestListVO[]
	 */
	public Eu24ManifestListVO[] getEu24ManifestListVOs(){
		Eu24ManifestListVO[] vos = (Eu24ManifestListVO[])models.toArray(new Eu24ManifestListVO[models.size()]);
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
		this.dnlCnt = this.dnlCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shZip = this.shZip .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.del = this.del .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSent = this.ediSent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchEu1stPortYdCd = this.searchEu1stPortYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delYdCd = this.delYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtSeq = this.dtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shStr = this.shStr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ensEdiSvcFlg = this.ensEdiSvcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsClptIndSeq = this.cstmsClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyCn = this.ntfyCn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anEdiSvcFlg = this.anEdiSvcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nlErrMsg = this.nlErrMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pFiPolYardCd = this.pFiPolYardCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sentFailCnt = this.sentFailCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polClptIndSeq = this.polClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmPk = this.cmPk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCnt = this.vvdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyCt = this.ntfyCt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPk = this.cntrPk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeCt = this.cneeCt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.downloadYn = this.downloadYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrList = this.cntrList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeCn = this.cneeCn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eu1stPortYdCd = this.eu1stPortYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shEori = this.shEori .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfsYn = this.rfsYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPkLmtFlg = this.cntrPkLmtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ensResult = this.ensResult .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeEori = this.cneeEori .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNm = this.cneeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nrCnt = this.nrCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eu1stPortClptSeq = this.eu1stPortClptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sentBlCnt = this.sentBlCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.result = this.result .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediMrn = this.ediMrn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blStatus = this.blStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyAd = this.ntfyAd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlCntr = this.ttlCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCnt = this.aCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmBlckFlg = this.trsmBlckFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drYn = this.drYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.downYnFirstOfMultiPofe = this.downYnFirstOfMultiPofe .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shAd = this.shAd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaErrMsg = this.etaErrMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ct = this.ct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ktsSendDt = this.ktsSendDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.receivedTime = this.receivedTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portOfcCd = this.portOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sentSuccessCnt = this.sentSuccessCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd = this.podYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eu1stPort = this.eu1stPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eu1stPortName = this.eu1stPortName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bpol = this.bpol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmMk = this.cmMk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd = this.polYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lt = this.lt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.euStfFlg = this.euStfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caCnt = this.caCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bpod = this.bpod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRefNo = this.ediRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCt = this.shCt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCn = this.shCn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortYdCd = this.vpsPortYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pType = this.pType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeStr = this.cneeStr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtCheck = this.dtCheck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMs = this.cntrMs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmMs = this.cmMs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errYn = this.errYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rCnt = this.rCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCntrNo = this.cntrCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSeal = this.cntrSeal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeZip = this.cneeZip .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlErrBl = this.ttlErrBl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmDs = this.cmDs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alCnt = this.alCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmHts = this.cmHts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sentTime = this.sentTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pFiPolCd = this.pFiPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blMs = this.blMs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shNm = this.shNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dvsRqstEdiSvcFlg = this.dvsRqstEdiSvcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmWt = this.cmWt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blPk = this.blPk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmVal = this.trsmVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ataYn = this.ataYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlBl = this.ttlBl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWt = this.cntrWt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unsentBlCnt = this.unsentBlCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsEstmArrDt = this.cstmsEstmArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podClptIndSeq = this.podClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgSndNo = this.msgSndNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arnYn = this.arnYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.result2 = this.result2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeAd = this.cneeAd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blWt = this.blWt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyStr = this.ntfyStr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvMsg = this.rcvMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRcvDt = this.ediRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyEori = this.ntfyEori .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyZip = this.ntfyZip .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediTime = this.ediTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyNm = this.ntfyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRcvSeq = this.ediRcvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
