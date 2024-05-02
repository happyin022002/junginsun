/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : Eu24EnsListVO.java
*@FileTitle : Eu24EnsListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.13
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.09.13 김보배 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo;

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
 * @author 김보배
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class Eu24EnsListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<Eu24EnsListVO> models = new ArrayList<Eu24EnsListVO>();
	
	/* Column Info */
	private String ediRcvDt = null;
	/* Column Info */
	private String pFromMt = null;
	/* Column Info */
	private String pAckStatus = null;
	/* Column Info */
	private String pLane = null;
	/* Column Info */
	private String ediRcvSeq = null;
	/* Column Info */
	private String nrcvBlCnt = null;
	/* Column Info */
	private String totalEnsAmt = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String mrnNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String caCnt = null;
	/* Column Info */
	private String totalHamurMcf = null;
	/* Column Info */
	private String pPofeYd = null;
	/* Column Info */
	private String totalNycnaEns = null;
	/* Column Info */
	private String pBlNo = null;
	/* Column Info */
	private String totalVvdCnt = null;
	/* Column Info */
	private String polOfcCd = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String unsentBlCnt = null;
	/* Column Info */
	private String condLane = null;
	/* Column Info */
	private String totalShaasEns = null;
	/* Column Info */
	private String ensSendGmtDt = null;
	/* Column Info */
	private String totalShaasMcf = null;
	/* Column Info */
	private String pBOfcCd = null;
	/* Column Info */
	private String totalMcfAmt = null;
	/* Column Info */
	private String ackRcvDt = null;
	/* Column Info */
	private String pRhqGb = null;
	/* Column Info */
	private String rhq = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String podYd = null;
	/* Column Info */
	private String pVvd = null;
	/* Column Info */
	private String pDateGb = null;
	/* Column Info */
	private String ensSntAcc = null;
	/* Column Info */
	private String pToMt = null;
	/* Column Info */
	private String ct = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String pPol = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String ensUnsntCnt = null;
	/* Column Info */
	private String donldBlCnt = null;
	/* Column Info */
	private String goodsItemNo = null;
	/* Column Info */
	private String pType = null;
	/* Column Info */
	private String result = null;
	/* Column Info */
	private String pStatus = null;
	/* Column Info */
	private String vpsEtbDt = null;
	/* Column Info */
	private String totalSinwaMcf = null;
	/* Column Info */
	private String pofe = null;
	/* Column Info */
	private String dnlCnt = null;
	/* Column Info */
	private String ensAmt = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String pCancelYn = null;
	/* Column Info */
	private String alCnt = null;
	/* Column Info */
	private String sentBlCnt = null;
	/* Column Info */
	private String ensSendDt = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Column Info */
	private String ensSntDonld = null;
	/* Column Info */
	private String lane = null;
	/* Column Info */
	private String totalHamurEns = null;
	/* Column Info */
	private String ackRcvGmtDt = null;
	/* Column Info */
	private String delYd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String result2 = null;
	/* Column Info */
	private String blTotCnt = null;
	/* Column Info */
	private String rejBlCnt = null;
	/* Column Info */
	private String ensSntNrcv = null;
	/* Column Info */
	private String pofeYd = null;
	/* Column Info */
	private String ensAmdCnt = null;
	/* Column Info */
	private String accBlCnt = null;
	/* Column Info */
	private String del = null;
	/* Column Info */
	private String sentSuccessCnt = null;
	/* Column Info */
	private String pSearchPofeYardCd = null;
	/* Column Info */
	private String pSentType = null;
	/* Column Info */
	private String totalAmdCnt = null;
	/* Column Info */
	private String ensSntRej = null;
	/* Column Info */
	private String sentFailCnt = null;
	/* Column Info */
	private String rCnt = null;
	/* Column Info */
	private String aCnt = null;
	/* Column Info */
	private String ack = null;
	/* Column Info */
	private String pMultiPopeYn = null;
	/* Column Info */
	private String pToDt = null;
	/* Column Info */
	private String totalSinwaEns = null;
	/* Column Info */
	private String pPofe = null;
	/* Column Info */
	private String totalNycnaMcf = null;
	/* Column Info */
	private String cntrs = null;
	/* Column Info */
	private String ensSntCnt = null;
	/* Column Info */
	private String mcfAmt = null;
	/* Column Info */
	private String totalBlCnt = null;
	/* Column Info */
	private String polYd = null;
	/* Column Info */
	private String pFromDt = null;
	/* Column Info */
	private String pFdrYn = null;
	/* Column Info */
	private String nrCnt = null;
	/* Column Info */
	private String pPolYd = null;
	/* Column Info */
	private String sentType = null;
	/* Column Info */
	private String ensTosndCnt = null;
	/* Column Info */
	private String tosendBlCnt = null;
	/* Column Info */
	private String eu1stPortClptSeq = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public Eu24EnsListVO() {}

	public Eu24EnsListVO(String ibflag, String pagerows, String aCnt, String accBlCnt, String ack, String ackRcvDt, String ackRcvGmtDt, String bkgNo, String bkgOfcCd, String bkgStsCd, String blNo, String blTotCnt, String cntrs, String condLane, String ct, String caCnt, String del, String delYd, String dnlCnt, String donldBlCnt, String ediRcvDt, String ediRcvSeq, String ensAmdCnt, String ensAmt, String ensSendDt, String ensSendGmtDt, String ensSntAcc, String ensSntCnt, String ensSntDonld, String ensSntNrcv, String ensSntRej, String ensUnsntCnt, String lane, String mcfAmt, String mrnNo, String nrCnt, String nrcvBlCnt, String pAckStatus, String pBOfcCd, String pBlNo, String pCancelYn, String pDateGb, String pFdrYn, String pFromDt, String pFromMt, String pLane, String pMultiPopeYn, String pPofe, String pPofeYd, String pPol, String pPolYd, String pRhqGb, String pSearchPofeYardCd, String pSentType, String pStatus, String pToDt, String pToMt, String pType, String pVvd, String pod, String podYd, String pofe, String pofeYd, String pol, String polOfcCd, String polYd, String rCnt, String rejBlCnt, String result, String result2, String rhq, String sentBlCnt, String sentFailCnt, String sentSuccessCnt, String sentType, String totalAmdCnt, String totalBlCnt, String totalEnsAmt, String totalHamurEns, String totalHamurMcf, String totalMcfAmt, String totalNycnaEns, String totalNycnaMcf, String totalShaasEns, String totalShaasMcf, String totalSinwaEns, String totalSinwaMcf, String totalVvdCnt, String unsentBlCnt, String vpsEtaDt, String vpsEtbDt, String vvd, String goodsItemNo, String alCnt, String ensTosndCnt, String tosendBlCnt, String eu1stPortClptSeq) {
		this.ediRcvDt = ediRcvDt;
		this.pFromMt = pFromMt;
		this.pAckStatus = pAckStatus;
		this.pLane = pLane;
		this.ediRcvSeq = ediRcvSeq;
		this.nrcvBlCnt = nrcvBlCnt;
		this.totalEnsAmt = totalEnsAmt;
		this.blNo = blNo;
		this.mrnNo = mrnNo;
		this.pagerows = pagerows;
		this.caCnt = caCnt;
		this.totalHamurMcf = totalHamurMcf;
		this.pPofeYd = pPofeYd;
		this.totalNycnaEns = totalNycnaEns;
		this.pBlNo = pBlNo;
		this.totalVvdCnt = totalVvdCnt;
		this.polOfcCd = polOfcCd;
		this.pol = pol;
		this.unsentBlCnt = unsentBlCnt;
		this.condLane = condLane;
		this.totalShaasEns = totalShaasEns;
		this.ensSendGmtDt = ensSendGmtDt;
		this.totalShaasMcf = totalShaasMcf;
		this.pBOfcCd = pBOfcCd;
		this.totalMcfAmt = totalMcfAmt;
		this.ackRcvDt = ackRcvDt;
		this.pRhqGb = pRhqGb;
		this.rhq = rhq;
		this.pod = pod;
		this.bkgOfcCd = bkgOfcCd;
		this.podYd = podYd;
		this.pVvd = pVvd;
		this.pDateGb = pDateGb;
		this.ensSntAcc = ensSntAcc;
		this.pToMt = pToMt;
		this.ct = ct;
		this.vvd = vvd;
		this.pPol = pPol;
		this.bkgNo = bkgNo;
		this.ensUnsntCnt = ensUnsntCnt;
		this.donldBlCnt = donldBlCnt;
		this.goodsItemNo = goodsItemNo;
		this.pType = pType;
		this.result = result;
		this.pStatus = pStatus;
		this.vpsEtbDt = vpsEtbDt;
		this.totalSinwaMcf = totalSinwaMcf;
		this.pofe = pofe;
		this.dnlCnt = dnlCnt;
		this.ensAmt = ensAmt;
		this.bkgStsCd = bkgStsCd;
		this.pCancelYn = pCancelYn;
		this.alCnt = alCnt;
		this.sentBlCnt = sentBlCnt;
		this.ensSendDt = ensSendDt;
		this.vpsEtaDt = vpsEtaDt;
		this.ensSntDonld = ensSntDonld;
		this.lane = lane;
		this.totalHamurEns = totalHamurEns;
		this.ackRcvGmtDt = ackRcvGmtDt;
		this.delYd = delYd;
		this.ibflag = ibflag;
		this.result2 = result2;
		this.blTotCnt = blTotCnt;
		this.rejBlCnt = rejBlCnt;
		this.ensSntNrcv = ensSntNrcv;
		this.pofeYd = pofeYd;
		this.ensAmdCnt = ensAmdCnt;
		this.accBlCnt = accBlCnt;
		this.del = del;
		this.sentSuccessCnt = sentSuccessCnt;
		this.pSearchPofeYardCd = pSearchPofeYardCd;
		this.pSentType = pSentType;
		this.totalAmdCnt = totalAmdCnt;
		this.ensSntRej = ensSntRej;
		this.sentFailCnt = sentFailCnt;
		this.rCnt = rCnt;
		this.aCnt = aCnt;
		this.ack = ack;
		this.pMultiPopeYn = pMultiPopeYn;
		this.pToDt = pToDt;
		this.totalSinwaEns = totalSinwaEns;
		this.pPofe = pPofe;
		this.totalNycnaMcf = totalNycnaMcf;
		this.cntrs = cntrs;
		this.ensSntCnt = ensSntCnt;
		this.mcfAmt = mcfAmt;
		this.totalBlCnt = totalBlCnt;
		this.polYd = polYd;
		this.pFromDt = pFromDt;
		this.pFdrYn = pFdrYn;
		this.nrCnt = nrCnt;
		this.pPolYd = pPolYd;
		this.sentType = sentType;
		this.ensTosndCnt = ensTosndCnt;
		this.tosendBlCnt = tosendBlCnt;
		this.eu1stPortClptSeq = eu1stPortClptSeq;
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("edi_rcv_dt", getEdiRcvDt());
		this.hashColumns.put("p_from_mt", getPFromMt());
		this.hashColumns.put("p_ack_status", getPAckStatus());
		this.hashColumns.put("p_lane", getPLane());
		this.hashColumns.put("edi_rcv_seq", getEdiRcvSeq());
		this.hashColumns.put("nrcv_bl_cnt", getNrcvBlCnt());
		this.hashColumns.put("total_ens_amt", getTotalEnsAmt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("mrn_no", getMrnNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ca_cnt", getCaCnt());
		this.hashColumns.put("total_hamur_mcf", getTotalHamurMcf());
		this.hashColumns.put("p_pofe_yd", getPPofeYd());
		this.hashColumns.put("total_nycna_ens", getTotalNycnaEns());
		this.hashColumns.put("p_bl_no", getPBlNo());
		this.hashColumns.put("total_vvd_cnt", getTotalVvdCnt());
		this.hashColumns.put("pol_ofc_cd", getPolOfcCd());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("unsent_bl_cnt", getUnsentBlCnt());
		this.hashColumns.put("cond_lane", getCondLane());
		this.hashColumns.put("total_shaas_ens", getTotalShaasEns());
		this.hashColumns.put("ens_send_gmt_dt", getEnsSendGmtDt());
		this.hashColumns.put("total_shaas_mcf", getTotalShaasMcf());
		this.hashColumns.put("p_b_ofc_cd", getPBOfcCd());
		this.hashColumns.put("total_mcf_amt", getTotalMcfAmt());
		this.hashColumns.put("ack_rcv_dt", getAckRcvDt());
		this.hashColumns.put("p_rhq_gb", getPRhqGb());
		this.hashColumns.put("rhq", getRhq());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("pod_yd", getPodYd());
		this.hashColumns.put("p_vvd", getPVvd());
		this.hashColumns.put("p_date_gb", getPDateGb());
		this.hashColumns.put("ens_snt_acc", getEnsSntAcc());
		this.hashColumns.put("p_to_mt", getPToMt());
		this.hashColumns.put("ct", getCt());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("p_pol", getPPol());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ens_unsnt_cnt", getEnsUnsntCnt());
		this.hashColumns.put("donld_bl_cnt", getDonldBlCnt());
		this.hashColumns.put("goods_item_no", getGoodsItemNo());
		this.hashColumns.put("p_type", getPType());
		this.hashColumns.put("result", getResult());
		this.hashColumns.put("p_status", getPStatus());
		this.hashColumns.put("vps_etb_dt", getVpsEtbDt());
		this.hashColumns.put("total_sinwa_mcf", getTotalSinwaMcf());
		this.hashColumns.put("pofe", getPofe());
		this.hashColumns.put("dnl_cnt", getDnlCnt());
		this.hashColumns.put("ens_amt", getEnsAmt());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("p_cancel_yn", getPCancelYn());
		this.hashColumns.put("al_cnt", getAlCnt());
		this.hashColumns.put("sent_bl_cnt", getSentBlCnt());
		this.hashColumns.put("ens_send_dt", getEnsSendDt());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("ens_snt_donld", getEnsSntDonld());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("total_hamur_ens", getTotalHamurEns());
		this.hashColumns.put("ack_rcv_gmt_dt", getAckRcvGmtDt());
		this.hashColumns.put("del_yd", getDelYd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("result2", getResult2());
		this.hashColumns.put("bl_tot_cnt", getBlTotCnt());
		this.hashColumns.put("rej_bl_cnt", getRejBlCnt());
		this.hashColumns.put("ens_snt_nrcv", getEnsSntNrcv());
		this.hashColumns.put("pofe_yd", getPofeYd());
		this.hashColumns.put("ens_amd_cnt", getEnsAmdCnt());
		this.hashColumns.put("acc_bl_cnt", getAccBlCnt());
		this.hashColumns.put("del", getDel());
		this.hashColumns.put("sent_success_cnt", getSentSuccessCnt());
		this.hashColumns.put("p_search_pofe_yard_cd", getPSearchPofeYardCd());
		this.hashColumns.put("p_sent_type", getPSentType());
		this.hashColumns.put("total_amd_cnt", getTotalAmdCnt());
		this.hashColumns.put("ens_snt_rej", getEnsSntRej());
		this.hashColumns.put("sent_fail_cnt", getSentFailCnt());
		this.hashColumns.put("r_cnt", getRCnt());
		this.hashColumns.put("a_cnt", getACnt());
		this.hashColumns.put("ack", getAck());
		this.hashColumns.put("p_multi_pope_yn", getPMultiPopeYn());
		this.hashColumns.put("p_to_dt", getPToDt());
		this.hashColumns.put("total_sinwa_ens", getTotalSinwaEns());
		this.hashColumns.put("p_pofe", getPPofe());
		this.hashColumns.put("total_nycna_mcf", getTotalNycnaMcf());
		this.hashColumns.put("cntrs", getCntrs());
		this.hashColumns.put("ens_snt_cnt", getEnsSntCnt());
		this.hashColumns.put("mcf_amt", getMcfAmt());
		this.hashColumns.put("total_bl_cnt", getTotalBlCnt());
		this.hashColumns.put("pol_yd", getPolYd());
		this.hashColumns.put("p_from_dt", getPFromDt());
		this.hashColumns.put("p_fdr_yn", getPFdrYn());
		this.hashColumns.put("nr_cnt", getNrCnt());
		this.hashColumns.put("p_pol_yd", getPPolYd());
		this.hashColumns.put("sent_type", getSentType());
		this.hashColumns.put("ens_tosnd_cnt", getEnsTosndCnt());
		this.hashColumns.put("tosend_bl_cnt", getTosendBlCnt());
		this.hashColumns.put("eu_1st_port_clpt_seq", getEu1stPortClptSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("edi_rcv_dt", "ediRcvDt");
		this.hashFields.put("p_from_mt", "pFromMt");
		this.hashFields.put("p_ack_status", "pAckStatus");
		this.hashFields.put("p_lane", "pLane");
		this.hashFields.put("edi_rcv_seq", "ediRcvSeq");
		this.hashFields.put("nrcv_bl_cnt", "nrcvBlCnt");
		this.hashFields.put("total_ens_amt", "totalEnsAmt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("mrn_no", "mrnNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ca_cnt", "caCnt");
		this.hashFields.put("total_hamur_mcf", "totalHamurMcf");
		this.hashFields.put("p_pofe_yd", "pPofeYd");
		this.hashFields.put("total_nycna_ens", "totalNycnaEns");
		this.hashFields.put("p_bl_no", "pBlNo");
		this.hashFields.put("total_vvd_cnt", "totalVvdCnt");
		this.hashFields.put("pol_ofc_cd", "polOfcCd");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("unsent_bl_cnt", "unsentBlCnt");
		this.hashFields.put("cond_lane", "condLane");
		this.hashFields.put("total_shaas_ens", "totalShaasEns");
		this.hashFields.put("ens_send_gmt_dt", "ensSendGmtDt");
		this.hashFields.put("total_shaas_mcf", "totalShaasMcf");
		this.hashFields.put("p_b_ofc_cd", "pBOfcCd");
		this.hashFields.put("total_mcf_amt", "totalMcfAmt");
		this.hashFields.put("ack_rcv_dt", "ackRcvDt");
		this.hashFields.put("p_rhq_gb", "pRhqGb");
		this.hashFields.put("rhq", "rhq");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("pod_yd", "podYd");
		this.hashFields.put("p_vvd", "pVvd");
		this.hashFields.put("p_date_gb", "pDateGb");
		this.hashFields.put("ens_snt_acc", "ensSntAcc");
		this.hashFields.put("p_to_mt", "pToMt");
		this.hashFields.put("ct", "ct");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("p_pol", "pPol");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ens_unsnt_cnt", "ensUnsntCnt");
		this.hashFields.put("donld_bl_cnt", "donldBlCnt");
		this.hashFields.put("goods_item_no", "goodsItemNo");
		this.hashFields.put("p_type", "pType");
		this.hashFields.put("result", "result");
		this.hashFields.put("p_status", "pStatus");
		this.hashFields.put("vps_etb_dt", "vpsEtbDt");
		this.hashFields.put("total_sinwa_mcf", "totalSinwaMcf");
		this.hashFields.put("pofe", "pofe");
		this.hashFields.put("dnl_cnt", "dnlCnt");
		this.hashFields.put("ens_amt", "ensAmt");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("p_cancel_yn", "pCancelYn");
		this.hashFields.put("al_cnt", "alCnt");
		this.hashFields.put("sent_bl_cnt", "sentBlCnt");
		this.hashFields.put("ens_send_dt", "ensSendDt");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("ens_snt_donld", "ensSntDonld");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("total_hamur_ens", "totalHamurEns");
		this.hashFields.put("ack_rcv_gmt_dt", "ackRcvGmtDt");
		this.hashFields.put("del_yd", "delYd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("result2", "result2");
		this.hashFields.put("bl_tot_cnt", "blTotCnt");
		this.hashFields.put("rej_bl_cnt", "rejBlCnt");
		this.hashFields.put("ens_snt_nrcv", "ensSntNrcv");
		this.hashFields.put("pofe_yd", "pofeYd");
		this.hashFields.put("ens_amd_cnt", "ensAmdCnt");
		this.hashFields.put("acc_bl_cnt", "accBlCnt");
		this.hashFields.put("del", "del");
		this.hashFields.put("sent_success_cnt", "sentSuccessCnt");
		this.hashFields.put("p_search_pofe_yard_cd", "pSearchPofeYardCd");
		this.hashFields.put("p_sent_type", "pSentType");
		this.hashFields.put("total_amd_cnt", "totalAmdCnt");
		this.hashFields.put("ens_snt_rej", "ensSntRej");
		this.hashFields.put("sent_fail_cnt", "sentFailCnt");
		this.hashFields.put("r_cnt", "rCnt");
		this.hashFields.put("a_cnt", "aCnt");
		this.hashFields.put("ack", "ack");
		this.hashFields.put("p_multi_pope_yn", "pMultiPopeYn");
		this.hashFields.put("p_to_dt", "pToDt");
		this.hashFields.put("total_sinwa_ens", "totalSinwaEns");
		this.hashFields.put("p_pofe", "pPofe");
		this.hashFields.put("total_nycna_mcf", "totalNycnaMcf");
		this.hashFields.put("cntrs", "cntrs");
		this.hashFields.put("ens_snt_cnt", "ensSntCnt");
		this.hashFields.put("mcf_amt", "mcfAmt");
		this.hashFields.put("total_bl_cnt", "totalBlCnt");
		this.hashFields.put("pol_yd", "polYd");
		this.hashFields.put("p_from_dt", "pFromDt");
		this.hashFields.put("p_fdr_yn", "pFdrYn");
		this.hashFields.put("nr_cnt", "nrCnt");
		this.hashFields.put("p_pol_yd", "pPolYd");
		this.hashFields.put("sent_type", "sentType");
		this.hashFields.put("ens_tosnd_cnt", "ensTosndCnt");
		this.hashFields.put("tosend_bl_cnt", "tosendBlCnt");
		this.hashFields.put("eu_1st_port_clpt_seq", "eu1stPortClptSeq");
		return this.hashFields;
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
	 * @return pFromMt
	 */
	public String getPFromMt() {
		return this.pFromMt;
	}
	
	/**
	 * Column Info
	 * @return pAckStatus
	 */
	public String getPAckStatus() {
		return this.pAckStatus;
	}
	
	/**
	 * Column Info
	 * @return pLane
	 */
	public String getPLane() {
		return this.pLane;
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
	 * @return nrcvBlCnt
	 */
	public String getNrcvBlCnt() {
		return this.nrcvBlCnt;
	}
	
	/**
	 * Column Info
	 * @return totalEnsAmt
	 */
	public String getTotalEnsAmt() {
		return this.totalEnsAmt;
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
	 * @return mrnNo
	 */
	public String getMrnNo() {
		return this.mrnNo;
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
	 * @return caCnt
	 */
	public String getCaCnt() {
		return this.caCnt;
	}
	
	/**
	 * Column Info
	 * @return totalHamurMcf
	 */
	public String getTotalHamurMcf() {
		return this.totalHamurMcf;
	}
	
	/**
	 * Column Info
	 * @return pPofeYd
	 */
	public String getPPofeYd() {
		return this.pPofeYd;
	}
	
	/**
	 * Column Info
	 * @return totalNycnaEns
	 */
	public String getTotalNycnaEns() {
		return this.totalNycnaEns;
	}
	
	/**
	 * Column Info
	 * @return pBlNo
	 */
	public String getPBlNo() {
		return this.pBlNo;
	}
	
	/**
	 * Column Info
	 * @return totalVvdCnt
	 */
	public String getTotalVvdCnt() {
		return this.totalVvdCnt;
	}
	
	/**
	 * Column Info
	 * @return polOfcCd
	 */
	public String getPolOfcCd() {
		return this.polOfcCd;
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
	 * @return unsentBlCnt
	 */
	public String getUnsentBlCnt() {
		return this.unsentBlCnt;
	}
	
	/**
	 * Column Info
	 * @return condLane
	 */
	public String getCondLane() {
		return this.condLane;
	}
	
	/**
	 * Column Info
	 * @return totalShaasEns
	 */
	public String getTotalShaasEns() {
		return this.totalShaasEns;
	}
	
	/**
	 * Column Info
	 * @return ensSendGmtDt
	 */
	public String getEnsSendGmtDt() {
		return this.ensSendGmtDt;
	}
	
	/**
	 * Column Info
	 * @return totalShaasMcf
	 */
	public String getTotalShaasMcf() {
		return this.totalShaasMcf;
	}
	
	/**
	 * Column Info
	 * @return pBOfcCd
	 */
	public String getPBOfcCd() {
		return this.pBOfcCd;
	}
	
	/**
	 * Column Info
	 * @return totalMcfAmt
	 */
	public String getTotalMcfAmt() {
		return this.totalMcfAmt;
	}
	
	/**
	 * Column Info
	 * @return ackRcvDt
	 */
	public String getAckRcvDt() {
		return this.ackRcvDt;
	}
	
	/**
	 * Column Info
	 * @return pRhqGb
	 */
	public String getPRhqGb() {
		return this.pRhqGb;
	}
	
	/**
	 * Column Info
	 * @return rhq
	 */
	public String getRhq() {
		return this.rhq;
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
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return podYd
	 */
	public String getPodYd() {
		return this.podYd;
	}
	
	/**
	 * Column Info
	 * @return pVvd
	 */
	public String getPVvd() {
		return this.pVvd;
	}
	
	/**
	 * Column Info
	 * @return pDateGb
	 */
	public String getPDateGb() {
		return this.pDateGb;
	}
	
	/**
	 * Column Info
	 * @return ensSntAcc
	 */
	public String getEnsSntAcc() {
		return this.ensSntAcc;
	}
	
	/**
	 * Column Info
	 * @return pToMt
	 */
	public String getPToMt() {
		return this.pToMt;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return pPol
	 */
	public String getPPol() {
		return this.pPol;
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
	 * @return ensUnsntCnt
	 */
	public String getEnsUnsntCnt() {
		return this.ensUnsntCnt;
	}
	
	/**
	 * Column Info
	 * @return donldBlCnt
	 */
	public String getDonldBlCnt() {
		return this.donldBlCnt;
	}
	
	/**
	 * Column Info
	 * @return goodsItemNo
	 */
	public String getGoodsItemNo() {
		return this.goodsItemNo;
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
	 * @return result
	 */
	public String getResult() {
		return this.result;
	}
	
	/**
	 * Column Info
	 * @return pStatus
	 */
	public String getPStatus() {
		return this.pStatus;
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
	 * @return totalSinwaMcf
	 */
	public String getTotalSinwaMcf() {
		return this.totalSinwaMcf;
	}
	
	/**
	 * Column Info
	 * @return pofe
	 */
	public String getPofe() {
		return this.pofe;
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
	 * @return ensAmt
	 */
	public String getEnsAmt() {
		return this.ensAmt;
	}
	
	/**
	 * Column Info
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @return pCancelYn
	 */
	public String getPCancelYn() {
		return this.pCancelYn;
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
	 * @return sentBlCnt
	 */
	public String getSentBlCnt() {
		return this.sentBlCnt;
	}
	
	/**
	 * Column Info
	 * @return ensSendDt
	 */
	public String getEnsSendDt() {
		return this.ensSendDt;
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
	 * @return ensSntDonld
	 */
	public String getEnsSntDonld() {
		return this.ensSntDonld;
	}
	
	/**
	 * Column Info
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
	}
	
	/**
	 * Column Info
	 * @return totalHamurEns
	 */
	public String getTotalHamurEns() {
		return this.totalHamurEns;
	}
	
	/**
	 * Column Info
	 * @return ackRcvGmtDt
	 */
	public String getAckRcvGmtDt() {
		return this.ackRcvGmtDt;
	}
	
	/**
	 * Column Info
	 * @return delYd
	 */
	public String getDelYd() {
		return this.delYd;
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
	 * @return result2
	 */
	public String getResult2() {
		return this.result2;
	}
	
	/**
	 * Column Info
	 * @return blTotCnt
	 */
	public String getBlTotCnt() {
		return this.blTotCnt;
	}
	
	/**
	 * Column Info
	 * @return rejBlCnt
	 */
	public String getRejBlCnt() {
		return this.rejBlCnt;
	}
	
	/**
	 * Column Info
	 * @return ensSntNrcv
	 */
	public String getEnsSntNrcv() {
		return this.ensSntNrcv;
	}
	
	/**
	 * Column Info
	 * @return pofeYd
	 */
	public String getPofeYd() {
		return this.pofeYd;
	}
	
	/**
	 * Column Info
	 * @return ensAmdCnt
	 */
	public String getEnsAmdCnt() {
		return this.ensAmdCnt;
	}
	
	/**
	 * Column Info
	 * @return accBlCnt
	 */
	public String getAccBlCnt() {
		return this.accBlCnt;
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
	 * @return sentSuccessCnt
	 */
	public String getSentSuccessCnt() {
		return this.sentSuccessCnt;
	}
	
	/**
	 * Column Info
	 * @return pSearchPofeYardCd
	 */
	public String getPSearchPofeYardCd() {
		return this.pSearchPofeYardCd;
	}
	
	/**
	 * Column Info
	 * @return pSentType
	 */
	public String getPSentType() {
		return this.pSentType;
	}
	
	/**
	 * Column Info
	 * @return totalAmdCnt
	 */
	public String getTotalAmdCnt() {
		return this.totalAmdCnt;
	}
	
	/**
	 * Column Info
	 * @return ensSntRej
	 */
	public String getEnsSntRej() {
		return this.ensSntRej;
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
	 * @return rCnt
	 */
	public String getRCnt() {
		return this.rCnt;
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
	 * @return ack
	 */
	public String getAck() {
		return this.ack;
	}
	
	/**
	 * Column Info
	 * @return pMultiPopeYn
	 */
	public String getPMultiPopeYn() {
		return this.pMultiPopeYn;
	}
	
	/**
	 * Column Info
	 * @return pToDt
	 */
	public String getPToDt() {
		return this.pToDt;
	}
	
	/**
	 * Column Info
	 * @return totalSinwaEns
	 */
	public String getTotalSinwaEns() {
		return this.totalSinwaEns;
	}
	
	/**
	 * Column Info
	 * @return pPofe
	 */
	public String getPPofe() {
		return this.pPofe;
	}
	
	/**
	 * Column Info
	 * @return totalNycnaMcf
	 */
	public String getTotalNycnaMcf() {
		return this.totalNycnaMcf;
	}
	
	/**
	 * Column Info
	 * @return cntrs
	 */
	public String getCntrs() {
		return this.cntrs;
	}
	
	/**
	 * Column Info
	 * @return ensSntCnt
	 */
	public String getEnsSntCnt() {
		return this.ensSntCnt;
	}
	
	/**
	 * Column Info
	 * @return mcfAmt
	 */
	public String getMcfAmt() {
		return this.mcfAmt;
	}
	
	/**
	 * Column Info
	 * @return totalBlCnt
	 */
	public String getTotalBlCnt() {
		return this.totalBlCnt;
	}
	
	/**
	 * Column Info
	 * @return polYd
	 */
	public String getPolYd() {
		return this.polYd;
	}
	
	/**
	 * Column Info
	 * @return pFromDt
	 */
	public String getPFromDt() {
		return this.pFromDt;
	}
	
	/**
	 * Column Info
	 * @return pFdrYn
	 */
	public String getPFdrYn() {
		return this.pFdrYn;
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
	 * @return pPolYd
	 */
	public String getPPolYd() {
		return this.pPolYd;
	}
	
	/**
	 * Column Info
	 * @return sentType
	 */
	public String getSentType() {
		return this.sentType;
	}
	
	/**
	 * Column Info
	 * @return ensTosndCnt
	 */
	public String getEnsTosndCnt() {
		return this.ensTosndCnt;
	}
	
	/**
	 * Column Info
	 * @return tosendBlCnt
	 */
	public String getTosendBlCnt() {
		return this.tosendBlCnt;
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
	 * @param ediRcvDt
	 */
	public void setEdiRcvDt(String ediRcvDt) {
		this.ediRcvDt = ediRcvDt;
	}
	
	/**
	 * Column Info
	 * @param pFromMt
	 */
	public void setPFromMt(String pFromMt) {
		this.pFromMt = pFromMt;
	}
	
	/**
	 * Column Info
	 * @param pAckStatus
	 */
	public void setPAckStatus(String pAckStatus) {
		this.pAckStatus = pAckStatus;
	}
	
	/**
	 * Column Info
	 * @param pLane
	 */
	public void setPLane(String pLane) {
		this.pLane = pLane;
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
	 * @param nrcvBlCnt
	 */
	public void setNrcvBlCnt(String nrcvBlCnt) {
		this.nrcvBlCnt = nrcvBlCnt;
	}
	
	/**
	 * Column Info
	 * @param totalEnsAmt
	 */
	public void setTotalEnsAmt(String totalEnsAmt) {
		this.totalEnsAmt = totalEnsAmt;
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
	 * @param mrnNo
	 */
	public void setMrnNo(String mrnNo) {
		this.mrnNo = mrnNo;
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
	 * @param caCnt
	 */
	public void setCaCnt(String caCnt) {
		this.caCnt = caCnt;
	}
	
	/**
	 * Column Info
	 * @param totalHamurMcf
	 */
	public void setTotalHamurMcf(String totalHamurMcf) {
		this.totalHamurMcf = totalHamurMcf;
	}
	
	/**
	 * Column Info
	 * @param pPofeYd
	 */
	public void setPPofeYd(String pPofeYd) {
		this.pPofeYd = pPofeYd;
	}
	
	/**
	 * Column Info
	 * @param totalNycnaEns
	 */
	public void setTotalNycnaEns(String totalNycnaEns) {
		this.totalNycnaEns = totalNycnaEns;
	}
	
	/**
	 * Column Info
	 * @param pBlNo
	 */
	public void setPBlNo(String pBlNo) {
		this.pBlNo = pBlNo;
	}
	
	/**
	 * Column Info
	 * @param totalVvdCnt
	 */
	public void setTotalVvdCnt(String totalVvdCnt) {
		this.totalVvdCnt = totalVvdCnt;
	}
	
	/**
	 * Column Info
	 * @param polOfcCd
	 */
	public void setPolOfcCd(String polOfcCd) {
		this.polOfcCd = polOfcCd;
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
	 * @param unsentBlCnt
	 */
	public void setUnsentBlCnt(String unsentBlCnt) {
		this.unsentBlCnt = unsentBlCnt;
	}
	
	/**
	 * Column Info
	 * @param condLane
	 */
	public void setCondLane(String condLane) {
		this.condLane = condLane;
	}
	
	/**
	 * Column Info
	 * @param totalShaasEns
	 */
	public void setTotalShaasEns(String totalShaasEns) {
		this.totalShaasEns = totalShaasEns;
	}
	
	/**
	 * Column Info
	 * @param ensSendGmtDt
	 */
	public void setEnsSendGmtDt(String ensSendGmtDt) {
		this.ensSendGmtDt = ensSendGmtDt;
	}
	
	/**
	 * Column Info
	 * @param totalShaasMcf
	 */
	public void setTotalShaasMcf(String totalShaasMcf) {
		this.totalShaasMcf = totalShaasMcf;
	}
	
	/**
	 * Column Info
	 * @param pBOfcCd
	 */
	public void setPBOfcCd(String pBOfcCd) {
		this.pBOfcCd = pBOfcCd;
	}
	
	/**
	 * Column Info
	 * @param totalMcfAmt
	 */
	public void setTotalMcfAmt(String totalMcfAmt) {
		this.totalMcfAmt = totalMcfAmt;
	}
	
	/**
	 * Column Info
	 * @param ackRcvDt
	 */
	public void setAckRcvDt(String ackRcvDt) {
		this.ackRcvDt = ackRcvDt;
	}
	
	/**
	 * Column Info
	 * @param pRhqGb
	 */
	public void setPRhqGb(String pRhqGb) {
		this.pRhqGb = pRhqGb;
	}
	
	/**
	 * Column Info
	 * @param rhq
	 */
	public void setRhq(String rhq) {
		this.rhq = rhq;
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
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param podYd
	 */
	public void setPodYd(String podYd) {
		this.podYd = podYd;
	}
	
	/**
	 * Column Info
	 * @param pVvd
	 */
	public void setPVvd(String pVvd) {
		this.pVvd = pVvd;
	}
	
	/**
	 * Column Info
	 * @param pDateGb
	 */
	public void setPDateGb(String pDateGb) {
		this.pDateGb = pDateGb;
	}
	
	/**
	 * Column Info
	 * @param ensSntAcc
	 */
	public void setEnsSntAcc(String ensSntAcc) {
		this.ensSntAcc = ensSntAcc;
	}
	
	/**
	 * Column Info
	 * @param pToMt
	 */
	public void setPToMt(String pToMt) {
		this.pToMt = pToMt;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param pPol
	 */
	public void setPPol(String pPol) {
		this.pPol = pPol;
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
	 * @param ensUnsntCnt
	 */
	public void setEnsUnsntCnt(String ensUnsntCnt) {
		this.ensUnsntCnt = ensUnsntCnt;
	}
	
	/**
	 * Column Info
	 * @param donldBlCnt
	 */
	public void setDonldBlCnt(String donldBlCnt) {
		this.donldBlCnt = donldBlCnt;
	}
	
	/**
	 * Column Info
	 * @param goodsItemNo
	 */
	public void setGoodsItemNo(String goodsItemNo) {
		this.goodsItemNo = goodsItemNo;
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
	 * @param result
	 */
	public void setResult(String result) {
		this.result = result;
	}
	
	/**
	 * Column Info
	 * @param pStatus
	 */
	public void setPStatus(String pStatus) {
		this.pStatus = pStatus;
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
	 * @param totalSinwaMcf
	 */
	public void setTotalSinwaMcf(String totalSinwaMcf) {
		this.totalSinwaMcf = totalSinwaMcf;
	}
	
	/**
	 * Column Info
	 * @param pofe
	 */
	public void setPofe(String pofe) {
		this.pofe = pofe;
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
	 * @param ensAmt
	 */
	public void setEnsAmt(String ensAmt) {
		this.ensAmt = ensAmt;
	}
	
	/**
	 * Column Info
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @param pCancelYn
	 */
	public void setPCancelYn(String pCancelYn) {
		this.pCancelYn = pCancelYn;
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
	 * @param sentBlCnt
	 */
	public void setSentBlCnt(String sentBlCnt) {
		this.sentBlCnt = sentBlCnt;
	}
	
	/**
	 * Column Info
	 * @param ensSendDt
	 */
	public void setEnsSendDt(String ensSendDt) {
		this.ensSendDt = ensSendDt;
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
	 * @param ensSntDonld
	 */
	public void setEnsSntDonld(String ensSntDonld) {
		this.ensSntDonld = ensSntDonld;
	}
	
	/**
	 * Column Info
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
	}
	
	/**
	 * Column Info
	 * @param totalHamurEns
	 */
	public void setTotalHamurEns(String totalHamurEns) {
		this.totalHamurEns = totalHamurEns;
	}
	
	/**
	 * Column Info
	 * @param ackRcvGmtDt
	 */
	public void setAckRcvGmtDt(String ackRcvGmtDt) {
		this.ackRcvGmtDt = ackRcvGmtDt;
	}
	
	/**
	 * Column Info
	 * @param delYd
	 */
	public void setDelYd(String delYd) {
		this.delYd = delYd;
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
	 * @param result2
	 */
	public void setResult2(String result2) {
		this.result2 = result2;
	}
	
	/**
	 * Column Info
	 * @param blTotCnt
	 */
	public void setBlTotCnt(String blTotCnt) {
		this.blTotCnt = blTotCnt;
	}
	
	/**
	 * Column Info
	 * @param rejBlCnt
	 */
	public void setRejBlCnt(String rejBlCnt) {
		this.rejBlCnt = rejBlCnt;
	}
	
	/**
	 * Column Info
	 * @param ensSntNrcv
	 */
	public void setEnsSntNrcv(String ensSntNrcv) {
		this.ensSntNrcv = ensSntNrcv;
	}
	
	/**
	 * Column Info
	 * @param pofeYd
	 */
	public void setPofeYd(String pofeYd) {
		this.pofeYd = pofeYd;
	}
	
	/**
	 * Column Info
	 * @param ensAmdCnt
	 */
	public void setEnsAmdCnt(String ensAmdCnt) {
		this.ensAmdCnt = ensAmdCnt;
	}
	
	/**
	 * Column Info
	 * @param accBlCnt
	 */
	public void setAccBlCnt(String accBlCnt) {
		this.accBlCnt = accBlCnt;
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
	 * @param sentSuccessCnt
	 */
	public void setSentSuccessCnt(String sentSuccessCnt) {
		this.sentSuccessCnt = sentSuccessCnt;
	}
	
	/**
	 * Column Info
	 * @param pSearchPofeYardCd
	 */
	public void setPSearchPofeYardCd(String pSearchPofeYardCd) {
		this.pSearchPofeYardCd = pSearchPofeYardCd;
	}
	
	/**
	 * Column Info
	 * @param pSentType
	 */
	public void setPSentType(String pSentType) {
		this.pSentType = pSentType;
	}
	
	/**
	 * Column Info
	 * @param totalAmdCnt
	 */
	public void setTotalAmdCnt(String totalAmdCnt) {
		this.totalAmdCnt = totalAmdCnt;
	}
	
	/**
	 * Column Info
	 * @param ensSntRej
	 */
	public void setEnsSntRej(String ensSntRej) {
		this.ensSntRej = ensSntRej;
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
	 * @param rCnt
	 */
	public void setRCnt(String rCnt) {
		this.rCnt = rCnt;
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
	 * @param ack
	 */
	public void setAck(String ack) {
		this.ack = ack;
	}
	
	/**
	 * Column Info
	 * @param pMultiPopeYn
	 */
	public void setPMultiPopeYn(String pMultiPopeYn) {
		this.pMultiPopeYn = pMultiPopeYn;
	}
	
	/**
	 * Column Info
	 * @param pToDt
	 */
	public void setPToDt(String pToDt) {
		this.pToDt = pToDt;
	}
	
	/**
	 * Column Info
	 * @param totalSinwaEns
	 */
	public void setTotalSinwaEns(String totalSinwaEns) {
		this.totalSinwaEns = totalSinwaEns;
	}
	
	/**
	 * Column Info
	 * @param pPofe
	 */
	public void setPPofe(String pPofe) {
		this.pPofe = pPofe;
	}
	
	/**
	 * Column Info
	 * @param totalNycnaMcf
	 */
	public void setTotalNycnaMcf(String totalNycnaMcf) {
		this.totalNycnaMcf = totalNycnaMcf;
	}
	
	/**
	 * Column Info
	 * @param cntrs
	 */
	public void setCntrs(String cntrs) {
		this.cntrs = cntrs;
	}
	
	/**
	 * Column Info
	 * @param ensSntCnt
	 */
	public void setEnsSntCnt(String ensSntCnt) {
		this.ensSntCnt = ensSntCnt;
	}
	
	/**
	 * Column Info
	 * @param mcfAmt
	 */
	public void setMcfAmt(String mcfAmt) {
		this.mcfAmt = mcfAmt;
	}
	
	/**
	 * Column Info
	 * @param totalBlCnt
	 */
	public void setTotalBlCnt(String totalBlCnt) {
		this.totalBlCnt = totalBlCnt;
	}
	
	/**
	 * Column Info
	 * @param polYd
	 */
	public void setPolYd(String polYd) {
		this.polYd = polYd;
	}
	
	/**
	 * Column Info
	 * @param pFromDt
	 */
	public void setPFromDt(String pFromDt) {
		this.pFromDt = pFromDt;
	}
	
	/**
	 * Column Info
	 * @param pFdrYn
	 */
	public void setPFdrYn(String pFdrYn) {
		this.pFdrYn = pFdrYn;
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
	 * @param pPolYd
	 */
	public void setPPolYd(String pPolYd) {
		this.pPolYd = pPolYd;
	}
	
	/**
	 * Column Info
	 * @param sentType
	 */
	public void setSentType(String sentType) {
		this.sentType = sentType;
	}
	
	/**
	 * Column Info
	 * @param ensTosndCnt
	 */
	public void setEnsTosndCnt(String ensTosndCnt) {
		this.ensTosndCnt = ensTosndCnt;
	}
	
	/**
	 * Column Info
	 * @param tosendBlCnt
	 */
	public void setTosendBlCnt(String tosendBlCnt) {
		this.tosendBlCnt = tosendBlCnt;
	}

	/**
	 * Column Info
	 * @param eu1stPortClptSeq
	 */
	public void setEu1stPortClptSeq(String eu1stPortClptSeq) {
		this.eu1stPortClptSeq = eu1stPortClptSeq;
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
		setEdiRcvDt(JSPUtil.getParameter(request, prefix + "edi_rcv_dt", ""));
		setPFromMt(JSPUtil.getParameter(request, prefix + "p_from_mt", ""));
		setPAckStatus(JSPUtil.getParameter(request, prefix + "p_ack_status", ""));
		setPLane(JSPUtil.getParameter(request, prefix + "p_lane", ""));
		setEdiRcvSeq(JSPUtil.getParameter(request, prefix + "edi_rcv_seq", ""));
		setNrcvBlCnt(JSPUtil.getParameter(request, prefix + "nrcv_bl_cnt", ""));
		setTotalEnsAmt(JSPUtil.getParameter(request, prefix + "total_ens_amt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setMrnNo(JSPUtil.getParameter(request, prefix + "mrn_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCaCnt(JSPUtil.getParameter(request, prefix + "ca_cnt", ""));
		setTotalHamurMcf(JSPUtil.getParameter(request, prefix + "total_hamur_mcf", ""));
		setPPofeYd(JSPUtil.getParameter(request, prefix + "p_pofe_yd", ""));
		setTotalNycnaEns(JSPUtil.getParameter(request, prefix + "total_nycna_ens", ""));
		setPBlNo(JSPUtil.getParameter(request, prefix + "p_bl_no", ""));
		setTotalVvdCnt(JSPUtil.getParameter(request, prefix + "total_vvd_cnt", ""));
		setPolOfcCd(JSPUtil.getParameter(request, prefix + "pol_ofc_cd", ""));
		setPol(JSPUtil.getParameter(request, prefix + "pol", ""));
		setUnsentBlCnt(JSPUtil.getParameter(request, prefix + "unsent_bl_cnt", ""));
		setCondLane(JSPUtil.getParameter(request, prefix + "cond_lane", ""));
		setTotalShaasEns(JSPUtil.getParameter(request, prefix + "total_shaas_ens", ""));
		setEnsSendGmtDt(JSPUtil.getParameter(request, prefix + "ens_send_gmt_dt", ""));
		setTotalShaasMcf(JSPUtil.getParameter(request, prefix + "total_shaas_mcf", ""));
		setPBOfcCd(JSPUtil.getParameter(request, prefix + "p_b_ofc_cd", ""));
		setTotalMcfAmt(JSPUtil.getParameter(request, prefix + "total_mcf_amt", ""));
		setAckRcvDt(JSPUtil.getParameter(request, prefix + "ack_rcv_dt", ""));
		setPRhqGb(JSPUtil.getParameter(request, prefix + "p_rhq_gb", ""));
		setRhq(JSPUtil.getParameter(request, prefix + "rhq", ""));
		setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setPodYd(JSPUtil.getParameter(request, prefix + "pod_yd", ""));
		setPVvd(JSPUtil.getParameter(request, prefix + "p_vvd", ""));
		setPDateGb(JSPUtil.getParameter(request, prefix + "p_date_gb", ""));
		setEnsSntAcc(JSPUtil.getParameter(request, prefix + "ens_snt_acc", ""));
		setPToMt(JSPUtil.getParameter(request, prefix + "p_to_mt", ""));
		setCt(JSPUtil.getParameter(request, prefix + "ct", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPPol(JSPUtil.getParameter(request, prefix + "p_pol", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setEnsUnsntCnt(JSPUtil.getParameter(request, prefix + "ens_unsnt_cnt", ""));
		setDonldBlCnt(JSPUtil.getParameter(request, prefix + "donld_bl_cnt", ""));
		setGoodsItemNo(JSPUtil.getParameter(request, prefix + "goods_item_no", ""));
		setPType(JSPUtil.getParameter(request, prefix + "p_type", ""));
		setResult(JSPUtil.getParameter(request, prefix + "result", ""));
		setPStatus(JSPUtil.getParameter(request, prefix + "p_status", ""));
		setVpsEtbDt(JSPUtil.getParameter(request, prefix + "vps_etb_dt", ""));
		setTotalSinwaMcf(JSPUtil.getParameter(request, prefix + "total_sinwa_mcf", ""));
		setPofe(JSPUtil.getParameter(request, prefix + "pofe", ""));
		setDnlCnt(JSPUtil.getParameter(request, prefix + "dnl_cnt", ""));
		setEnsAmt(JSPUtil.getParameter(request, prefix + "ens_amt", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setPCancelYn(JSPUtil.getParameter(request, prefix + "p_cancel_yn", ""));
		setAlCnt(JSPUtil.getParameter(request, prefix + "al_cnt", ""));
		setSentBlCnt(JSPUtil.getParameter(request, prefix + "sent_bl_cnt", ""));
		setEnsSendDt(JSPUtil.getParameter(request, prefix + "ens_send_dt", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, prefix + "vps_eta_dt", ""));
		setEnsSntDonld(JSPUtil.getParameter(request, prefix + "ens_snt_donld", ""));
		setLane(JSPUtil.getParameter(request, prefix + "lane", ""));
		setTotalHamurEns(JSPUtil.getParameter(request, prefix + "total_hamur_ens", ""));
		setAckRcvGmtDt(JSPUtil.getParameter(request, prefix + "ack_rcv_gmt_dt", ""));
		setDelYd(JSPUtil.getParameter(request, prefix + "del_yd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setResult2(JSPUtil.getParameter(request, prefix + "result2", ""));
		setBlTotCnt(JSPUtil.getParameter(request, prefix + "bl_tot_cnt", ""));
		setRejBlCnt(JSPUtil.getParameter(request, prefix + "rej_bl_cnt", ""));
		setEnsSntNrcv(JSPUtil.getParameter(request, prefix + "ens_snt_nrcv", ""));
		setPofeYd(JSPUtil.getParameter(request, prefix + "pofe_yd", ""));
		setEnsAmdCnt(JSPUtil.getParameter(request, prefix + "ens_amd_cnt", ""));
		setAccBlCnt(JSPUtil.getParameter(request, prefix + "acc_bl_cnt", ""));
		setDel(JSPUtil.getParameter(request, prefix + "del", ""));
		setSentSuccessCnt(JSPUtil.getParameter(request, prefix + "sent_success_cnt", ""));
		setPSearchPofeYardCd(JSPUtil.getParameter(request, prefix + "p_search_pofe_yard_cd", ""));
		setPSentType(JSPUtil.getParameter(request, prefix + "p_sent_type", ""));
		setTotalAmdCnt(JSPUtil.getParameter(request, prefix + "total_amd_cnt", ""));
		setEnsSntRej(JSPUtil.getParameter(request, prefix + "ens_snt_rej", ""));
		setSentFailCnt(JSPUtil.getParameter(request, prefix + "sent_fail_cnt", ""));
		setRCnt(JSPUtil.getParameter(request, prefix + "r_cnt", ""));
		setACnt(JSPUtil.getParameter(request, prefix + "a_cnt", ""));
		setAck(JSPUtil.getParameter(request, prefix + "ack", ""));
		setPMultiPopeYn(JSPUtil.getParameter(request, prefix + "p_multi_pope_yn", ""));
		setPToDt(JSPUtil.getParameter(request, prefix + "p_to_dt", ""));
		setTotalSinwaEns(JSPUtil.getParameter(request, prefix + "total_sinwa_ens", ""));
		setPPofe(JSPUtil.getParameter(request, prefix + "p_pofe", ""));
		setTotalNycnaMcf(JSPUtil.getParameter(request, prefix + "total_nycna_mcf", ""));
		setCntrs(JSPUtil.getParameter(request, prefix + "cntrs", ""));
		setEnsSntCnt(JSPUtil.getParameter(request, prefix + "ens_snt_cnt", ""));
		setMcfAmt(JSPUtil.getParameter(request, prefix + "mcf_amt", ""));
		setTotalBlCnt(JSPUtil.getParameter(request, prefix + "total_bl_cnt", ""));
		setPolYd(JSPUtil.getParameter(request, prefix + "pol_yd", ""));
		setPFromDt(JSPUtil.getParameter(request, prefix + "p_from_dt", ""));
		setPFdrYn(JSPUtil.getParameter(request, prefix + "p_fdr_yn", ""));
		setNrCnt(JSPUtil.getParameter(request, prefix + "nr_cnt", ""));
		setPPolYd(JSPUtil.getParameter(request, prefix + "p_pol_yd", ""));
		setSentType(JSPUtil.getParameter(request, prefix + "sent_type", ""));
		setEnsTosndCnt(JSPUtil.getParameter(request, prefix + "ens_tosnd_cnt", ""));
		setTosendBlCnt(JSPUtil.getParameter(request, prefix + "tosend_bl_cnt", ""));
		setEu1stPortClptSeq(JSPUtil.getParameter(request, prefix + "eu_1st_port_clpt_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Eu24EnsListVO[]
	 */
	public Eu24EnsListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return Eu24EnsListVO[]
	 */
	public Eu24EnsListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Eu24EnsListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ediRcvDt = (JSPUtil.getParameter(request, prefix	+ "edi_rcv_dt", length));
			String[] pFromMt = (JSPUtil.getParameter(request, prefix	+ "p_from_mt", length));
			String[] pAckStatus = (JSPUtil.getParameter(request, prefix	+ "p_ack_status", length));
			String[] pLane = (JSPUtil.getParameter(request, prefix	+ "p_lane", length));
			String[] ediRcvSeq = (JSPUtil.getParameter(request, prefix	+ "edi_rcv_seq", length));
			String[] nrcvBlCnt = (JSPUtil.getParameter(request, prefix	+ "nrcv_bl_cnt", length));
			String[] totalEnsAmt = (JSPUtil.getParameter(request, prefix	+ "total_ens_amt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] mrnNo = (JSPUtil.getParameter(request, prefix	+ "mrn_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] caCnt = (JSPUtil.getParameter(request, prefix	+ "ca_cnt", length));
			String[] totalHamurMcf = (JSPUtil.getParameter(request, prefix	+ "total_hamur_mcf", length));
			String[] pPofeYd = (JSPUtil.getParameter(request, prefix	+ "p_pofe_yd", length));
			String[] totalNycnaEns = (JSPUtil.getParameter(request, prefix	+ "total_nycna_ens", length));
			String[] pBlNo = (JSPUtil.getParameter(request, prefix	+ "p_bl_no", length));
			String[] totalVvdCnt = (JSPUtil.getParameter(request, prefix	+ "total_vvd_cnt", length));
			String[] polOfcCd = (JSPUtil.getParameter(request, prefix	+ "pol_ofc_cd", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] unsentBlCnt = (JSPUtil.getParameter(request, prefix	+ "unsent_bl_cnt", length));
			String[] condLane = (JSPUtil.getParameter(request, prefix	+ "cond_lane", length));
			String[] totalShaasEns = (JSPUtil.getParameter(request, prefix	+ "total_shaas_ens", length));
			String[] ensSendGmtDt = (JSPUtil.getParameter(request, prefix	+ "ens_send_gmt_dt", length));
			String[] totalShaasMcf = (JSPUtil.getParameter(request, prefix	+ "total_shaas_mcf", length));
			String[] pBOfcCd = (JSPUtil.getParameter(request, prefix	+ "p_b_ofc_cd", length));
			String[] totalMcfAmt = (JSPUtil.getParameter(request, prefix	+ "total_mcf_amt", length));
			String[] ackRcvDt = (JSPUtil.getParameter(request, prefix	+ "ack_rcv_dt", length));
			String[] pRhqGb = (JSPUtil.getParameter(request, prefix	+ "p_rhq_gb", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix	+ "rhq", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] podYd = (JSPUtil.getParameter(request, prefix	+ "pod_yd", length));
			String[] pVvd = (JSPUtil.getParameter(request, prefix	+ "p_vvd", length));
			String[] pDateGb = (JSPUtil.getParameter(request, prefix	+ "p_date_gb", length));
			String[] ensSntAcc = (JSPUtil.getParameter(request, prefix	+ "ens_snt_acc", length));
			String[] pToMt = (JSPUtil.getParameter(request, prefix	+ "p_to_mt", length));
			String[] ct = (JSPUtil.getParameter(request, prefix	+ "ct", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] pPol = (JSPUtil.getParameter(request, prefix	+ "p_pol", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ensUnsntCnt = (JSPUtil.getParameter(request, prefix	+ "ens_unsnt_cnt", length));
			String[] donldBlCnt = (JSPUtil.getParameter(request, prefix	+ "donld_bl_cnt", length));
			String[] goodsItemNo = (JSPUtil.getParameter(request, prefix	+ "goods_item_no", length));
			String[] pType = (JSPUtil.getParameter(request, prefix	+ "p_type", length));
			String[] result = (JSPUtil.getParameter(request, prefix	+ "result", length));
			String[] pStatus = (JSPUtil.getParameter(request, prefix	+ "p_status", length));
			String[] vpsEtbDt = (JSPUtil.getParameter(request, prefix	+ "vps_etb_dt", length));
			String[] totalSinwaMcf = (JSPUtil.getParameter(request, prefix	+ "total_sinwa_mcf", length));
			String[] pofe = (JSPUtil.getParameter(request, prefix	+ "pofe", length));
			String[] dnlCnt = (JSPUtil.getParameter(request, prefix	+ "dnl_cnt", length));
			String[] ensAmt = (JSPUtil.getParameter(request, prefix	+ "ens_amt", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] pCancelYn = (JSPUtil.getParameter(request, prefix	+ "p_cancel_yn", length));
			String[] alCnt = (JSPUtil.getParameter(request, prefix	+ "al_cnt", length));
			String[] sentBlCnt = (JSPUtil.getParameter(request, prefix	+ "sent_bl_cnt", length));
			String[] ensSendDt = (JSPUtil.getParameter(request, prefix	+ "ens_send_dt", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] ensSntDonld = (JSPUtil.getParameter(request, prefix	+ "ens_snt_donld", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] totalHamurEns = (JSPUtil.getParameter(request, prefix	+ "total_hamur_ens", length));
			String[] ackRcvGmtDt = (JSPUtil.getParameter(request, prefix	+ "ack_rcv_gmt_dt", length));
			String[] delYd = (JSPUtil.getParameter(request, prefix	+ "del_yd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] result2 = (JSPUtil.getParameter(request, prefix	+ "result2", length));
			String[] blTotCnt = (JSPUtil.getParameter(request, prefix	+ "bl_tot_cnt", length));
			String[] rejBlCnt = (JSPUtil.getParameter(request, prefix	+ "rej_bl_cnt", length));
			String[] ensSntNrcv = (JSPUtil.getParameter(request, prefix	+ "ens_snt_nrcv", length));
			String[] pofeYd = (JSPUtil.getParameter(request, prefix	+ "pofe_yd", length));
			String[] ensAmdCnt = (JSPUtil.getParameter(request, prefix	+ "ens_amd_cnt", length));
			String[] accBlCnt = (JSPUtil.getParameter(request, prefix	+ "acc_bl_cnt", length));
			String[] del = (JSPUtil.getParameter(request, prefix	+ "del", length));
			String[] sentSuccessCnt = (JSPUtil.getParameter(request, prefix	+ "sent_success_cnt", length));
			String[] pSearchPofeYardCd = (JSPUtil.getParameter(request, prefix	+ "p_search_pofe_yard_cd", length));
			String[] pSentType = (JSPUtil.getParameter(request, prefix	+ "p_sent_type", length));
			String[] totalAmdCnt = (JSPUtil.getParameter(request, prefix	+ "total_amd_cnt", length));
			String[] ensSntRej = (JSPUtil.getParameter(request, prefix	+ "ens_snt_rej", length));
			String[] sentFailCnt = (JSPUtil.getParameter(request, prefix	+ "sent_fail_cnt", length));
			String[] rCnt = (JSPUtil.getParameter(request, prefix	+ "r_cnt", length));
			String[] aCnt = (JSPUtil.getParameter(request, prefix	+ "a_cnt", length));
			String[] ack = (JSPUtil.getParameter(request, prefix	+ "ack", length));
			String[] pMultiPopeYn = (JSPUtil.getParameter(request, prefix	+ "p_multi_pope_yn", length));
			String[] pToDt = (JSPUtil.getParameter(request, prefix	+ "p_to_dt", length));
			String[] totalSinwaEns = (JSPUtil.getParameter(request, prefix	+ "total_sinwa_ens", length));
			String[] pPofe = (JSPUtil.getParameter(request, prefix	+ "p_pofe", length));
			String[] totalNycnaMcf = (JSPUtil.getParameter(request, prefix	+ "total_nycna_mcf", length));
			String[] cntrs = (JSPUtil.getParameter(request, prefix	+ "cntrs", length));
			String[] ensSntCnt = (JSPUtil.getParameter(request, prefix	+ "ens_snt_cnt", length));
			String[] mcfAmt = (JSPUtil.getParameter(request, prefix	+ "mcf_amt", length));
			String[] totalBlCnt = (JSPUtil.getParameter(request, prefix	+ "total_bl_cnt", length));
			String[] polYd = (JSPUtil.getParameter(request, prefix	+ "pol_yd", length));
			String[] pFromDt = (JSPUtil.getParameter(request, prefix	+ "p_from_dt", length));
			String[] pFdrYn = (JSPUtil.getParameter(request, prefix	+ "p_fdr_yn", length));
			String[] nrCnt = (JSPUtil.getParameter(request, prefix	+ "nr_cnt", length));
			String[] pPolYd = (JSPUtil.getParameter(request, prefix	+ "p_pol_yd", length));
			String[] sentType = (JSPUtil.getParameter(request, prefix	+ "sent_type", length));
			String[] ensTosndCnt = (JSPUtil.getParameter(request, prefix	+ "ens_tosnd_cnt", length));
			String[] tosendBlCnt = (JSPUtil.getParameter(request, prefix	+ "tosend_bl_cnt", length));
			String[] eu1stPortClptSeq = (JSPUtil.getParameter(request, prefix	+ "eu_1st_port_clpt_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new Eu24EnsListVO();
				if (ediRcvDt[i] != null)
					model.setEdiRcvDt(ediRcvDt[i]);
				if (pFromMt[i] != null)
					model.setPFromMt(pFromMt[i]);
				if (pAckStatus[i] != null)
					model.setPAckStatus(pAckStatus[i]);
				if (pLane[i] != null)
					model.setPLane(pLane[i]);
				if (ediRcvSeq[i] != null)
					model.setEdiRcvSeq(ediRcvSeq[i]);
				if (nrcvBlCnt[i] != null)
					model.setNrcvBlCnt(nrcvBlCnt[i]);
				if (totalEnsAmt[i] != null)
					model.setTotalEnsAmt(totalEnsAmt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (mrnNo[i] != null)
					model.setMrnNo(mrnNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (caCnt[i] != null)
					model.setCaCnt(caCnt[i]);
				if (totalHamurMcf[i] != null)
					model.setTotalHamurMcf(totalHamurMcf[i]);
				if (pPofeYd[i] != null)
					model.setPPofeYd(pPofeYd[i]);
				if (totalNycnaEns[i] != null)
					model.setTotalNycnaEns(totalNycnaEns[i]);
				if (pBlNo[i] != null)
					model.setPBlNo(pBlNo[i]);
				if (totalVvdCnt[i] != null)
					model.setTotalVvdCnt(totalVvdCnt[i]);
				if (polOfcCd[i] != null)
					model.setPolOfcCd(polOfcCd[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (unsentBlCnt[i] != null)
					model.setUnsentBlCnt(unsentBlCnt[i]);
				if (condLane[i] != null)
					model.setCondLane(condLane[i]);
				if (totalShaasEns[i] != null)
					model.setTotalShaasEns(totalShaasEns[i]);
				if (ensSendGmtDt[i] != null)
					model.setEnsSendGmtDt(ensSendGmtDt[i]);
				if (totalShaasMcf[i] != null)
					model.setTotalShaasMcf(totalShaasMcf[i]);
				if (pBOfcCd[i] != null)
					model.setPBOfcCd(pBOfcCd[i]);
				if (totalMcfAmt[i] != null)
					model.setTotalMcfAmt(totalMcfAmt[i]);
				if (ackRcvDt[i] != null)
					model.setAckRcvDt(ackRcvDt[i]);
				if (pRhqGb[i] != null)
					model.setPRhqGb(pRhqGb[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (podYd[i] != null)
					model.setPodYd(podYd[i]);
				if (pVvd[i] != null)
					model.setPVvd(pVvd[i]);
				if (pDateGb[i] != null)
					model.setPDateGb(pDateGb[i]);
				if (ensSntAcc[i] != null)
					model.setEnsSntAcc(ensSntAcc[i]);
				if (pToMt[i] != null)
					model.setPToMt(pToMt[i]);
				if (ct[i] != null)
					model.setCt(ct[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (pPol[i] != null)
					model.setPPol(pPol[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ensUnsntCnt[i] != null)
					model.setEnsUnsntCnt(ensUnsntCnt[i]);
				if (donldBlCnt[i] != null)
					model.setDonldBlCnt(donldBlCnt[i]);
				if (goodsItemNo[i] != null)
					model.setGoodsItemNo(goodsItemNo[i]);
				if (pType[i] != null)
					model.setPType(pType[i]);
				if (result[i] != null)
					model.setResult(result[i]);
				if (pStatus[i] != null)
					model.setPStatus(pStatus[i]);
				if (vpsEtbDt[i] != null)
					model.setVpsEtbDt(vpsEtbDt[i]);
				if (totalSinwaMcf[i] != null)
					model.setTotalSinwaMcf(totalSinwaMcf[i]);
				if (pofe[i] != null)
					model.setPofe(pofe[i]);
				if (dnlCnt[i] != null)
					model.setDnlCnt(dnlCnt[i]);
				if (ensAmt[i] != null)
					model.setEnsAmt(ensAmt[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (pCancelYn[i] != null)
					model.setPCancelYn(pCancelYn[i]);
				if (alCnt[i] != null)
					model.setAlCnt(alCnt[i]);
				if (sentBlCnt[i] != null)
					model.setSentBlCnt(sentBlCnt[i]);
				if (ensSendDt[i] != null)
					model.setEnsSendDt(ensSendDt[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (ensSntDonld[i] != null)
					model.setEnsSntDonld(ensSntDonld[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (totalHamurEns[i] != null)
					model.setTotalHamurEns(totalHamurEns[i]);
				if (ackRcvGmtDt[i] != null)
					model.setAckRcvGmtDt(ackRcvGmtDt[i]);
				if (delYd[i] != null)
					model.setDelYd(delYd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (result2[i] != null)
					model.setResult2(result2[i]);
				if (blTotCnt[i] != null)
					model.setBlTotCnt(blTotCnt[i]);
				if (rejBlCnt[i] != null)
					model.setRejBlCnt(rejBlCnt[i]);
				if (ensSntNrcv[i] != null)
					model.setEnsSntNrcv(ensSntNrcv[i]);
				if (pofeYd[i] != null)
					model.setPofeYd(pofeYd[i]);
				if (ensAmdCnt[i] != null)
					model.setEnsAmdCnt(ensAmdCnt[i]);
				if (accBlCnt[i] != null)
					model.setAccBlCnt(accBlCnt[i]);
				if (del[i] != null)
					model.setDel(del[i]);
				if (sentSuccessCnt[i] != null)
					model.setSentSuccessCnt(sentSuccessCnt[i]);
				if (pSearchPofeYardCd[i] != null)
					model.setPSearchPofeYardCd(pSearchPofeYardCd[i]);
				if (pSentType[i] != null)
					model.setPSentType(pSentType[i]);
				if (totalAmdCnt[i] != null)
					model.setTotalAmdCnt(totalAmdCnt[i]);
				if (ensSntRej[i] != null)
					model.setEnsSntRej(ensSntRej[i]);
				if (sentFailCnt[i] != null)
					model.setSentFailCnt(sentFailCnt[i]);
				if (rCnt[i] != null)
					model.setRCnt(rCnt[i]);
				if (aCnt[i] != null)
					model.setACnt(aCnt[i]);
				if (ack[i] != null)
					model.setAck(ack[i]);
				if (pMultiPopeYn[i] != null)
					model.setPMultiPopeYn(pMultiPopeYn[i]);
				if (pToDt[i] != null)
					model.setPToDt(pToDt[i]);
				if (totalSinwaEns[i] != null)
					model.setTotalSinwaEns(totalSinwaEns[i]);
				if (pPofe[i] != null)
					model.setPPofe(pPofe[i]);
				if (totalNycnaMcf[i] != null)
					model.setTotalNycnaMcf(totalNycnaMcf[i]);
				if (cntrs[i] != null)
					model.setCntrs(cntrs[i]);
				if (ensSntCnt[i] != null)
					model.setEnsSntCnt(ensSntCnt[i]);
				if (mcfAmt[i] != null)
					model.setMcfAmt(mcfAmt[i]);
				if (totalBlCnt[i] != null)
					model.setTotalBlCnt(totalBlCnt[i]);
				if (polYd[i] != null)
					model.setPolYd(polYd[i]);
				if (pFromDt[i] != null)
					model.setPFromDt(pFromDt[i]);
				if (pFdrYn[i] != null)
					model.setPFdrYn(pFdrYn[i]);
				if (nrCnt[i] != null)
					model.setNrCnt(nrCnt[i]);
				if (pPolYd[i] != null)
					model.setPPolYd(pPolYd[i]);
				if (sentType[i] != null)
					model.setSentType(sentType[i]);
				if (ensTosndCnt[i] != null)
					model.setEnsTosndCnt(ensTosndCnt[i]);
				if (tosendBlCnt[i] != null)
					model.setTosendBlCnt(tosendBlCnt[i]);
				if (eu1stPortClptSeq[i] != null)
					model.setEu1stPortClptSeq(eu1stPortClptSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEu24EnsListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Eu24EnsListVO[]
	 */
	public Eu24EnsListVO[] getEu24EnsListVOs(){
		Eu24EnsListVO[] vos = (Eu24EnsListVO[])models.toArray(new Eu24EnsListVO[models.size()]);
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
		this.ediRcvDt = this.ediRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pFromMt = this.pFromMt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pAckStatus = this.pAckStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pLane = this.pLane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRcvSeq = this.ediRcvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nrcvBlCnt = this.nrcvBlCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalEnsAmt = this.totalEnsAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnNo = this.mrnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caCnt = this.caCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalHamurMcf = this.totalHamurMcf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pPofeYd = this.pPofeYd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalNycnaEns = this.totalNycnaEns .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pBlNo = this.pBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalVvdCnt = this.totalVvdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polOfcCd = this.polOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unsentBlCnt = this.unsentBlCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.condLane = this.condLane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalShaasEns = this.totalShaasEns .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ensSendGmtDt = this.ensSendGmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalShaasMcf = this.totalShaasMcf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pBOfcCd = this.pBOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalMcfAmt = this.totalMcfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackRcvDt = this.ackRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pRhqGb = this.pRhqGb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYd = this.podYd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pVvd = this.pVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDateGb = this.pDateGb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ensSntAcc = this.ensSntAcc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pToMt = this.pToMt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ct = this.ct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pPol = this.pPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ensUnsntCnt = this.ensUnsntCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.donldBlCnt = this.donldBlCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.goodsItemNo = this.goodsItemNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pType = this.pType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.result = this.result .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pStatus = this.pStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtbDt = this.vpsEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalSinwaMcf = this.totalSinwaMcf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pofe = this.pofe .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dnlCnt = this.dnlCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ensAmt = this.ensAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pCancelYn = this.pCancelYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alCnt = this.alCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sentBlCnt = this.sentBlCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ensSendDt = this.ensSendDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ensSntDonld = this.ensSntDonld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalHamurEns = this.totalHamurEns .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackRcvGmtDt = this.ackRcvGmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delYd = this.delYd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.result2 = this.result2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTotCnt = this.blTotCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rejBlCnt = this.rejBlCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ensSntNrcv = this.ensSntNrcv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pofeYd = this.pofeYd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ensAmdCnt = this.ensAmdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accBlCnt = this.accBlCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.del = this.del .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sentSuccessCnt = this.sentSuccessCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pSearchPofeYardCd = this.pSearchPofeYardCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pSentType = this.pSentType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalAmdCnt = this.totalAmdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ensSntRej = this.ensSntRej .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sentFailCnt = this.sentFailCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rCnt = this.rCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCnt = this.aCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ack = this.ack .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pMultiPopeYn = this.pMultiPopeYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pToDt = this.pToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalSinwaEns = this.totalSinwaEns .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pPofe = this.pPofe .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalNycnaMcf = this.totalNycnaMcf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrs = this.cntrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ensSntCnt = this.ensSntCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mcfAmt = this.mcfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalBlCnt = this.totalBlCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYd = this.polYd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pFromDt = this.pFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pFdrYn = this.pFdrYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nrCnt = this.nrCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pPolYd = this.pPolYd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sentType = this.sentType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ensTosndCnt = this.ensTosndCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tosendBlCnt = this.tosendBlCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eu1stPortClptSeq = this.eu1stPortClptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
