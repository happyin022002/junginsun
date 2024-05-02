/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DocQueueListOutVO.java
*@FileTitle : DocQueueListOutVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.03  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo;

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
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DocQueueListOutVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DocQueueListOutVO> models = new ArrayList<DocQueueListOutVO>();
	
	/* Column Info */
	private String totalWorking = null;
	/* Column Info */
	private String totalQa = null;
	/* Column Info */
	private String picCngId = null;
	/* Column Info */
	private String imgFileRealPath = null;
	/* Column Info */
	private String blRtFlg = null;
	/* Column Info */
	private String totalRate = null;
	/* Column Info */
	private String picId = null;
	/* Column Info */
	private String srKindCd = null;
	/* Column Info */
	private String urgency = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String obSrepCd = null;
	/* Column Info */
	private String rowsPerPage = null;
	/* Column Info */
	private String srCrntInfoCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String pndUsrNm = null;
	/* Column Info */
	private String returnTo = null;
	/* Column Info */
	private String contractNo = null;
	/* Column Info */
	private String blFntOfcFlg = null;
	/* Column Info */
	private String totalCnt = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String totalRtnCust = null;
	/* Column Info */
	private String totalFax = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String rtnFmUsrId = null;
	/* Column Info */
	private String srStsCd = null;
	/* Column Info */
	private String rtnToUsrEml = null;
	/* Column Info */
	private String maxSrNo = null;
	/* Column Info */
	private String rtnFreq = null;
	/* Column Info */
	private String imgFileIp = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String queueStatus = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String totalRtnFo = null;
	/* Column Info */
	private String rtnToUsrRemark = null;
	/* Column Info */
	private String totalCutoff = null;
	/* Column Info */
	private String vbsClssNm = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String consignee = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String srAmdSeq = null;
	/* Column Info */
	private String returnCd = null;
	/* Column Info */
	private String totalBdr = null;
	/* Column Info */
	private String cstmsMfTpCd = null;
	/* Column Info */
	private String srKndCd = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String srAmdTpCd = null;
	/* Column Info */
	private String src = null;
	/* Column Info */
	private String rgnOfcCd = null;
	/* Column Info */
	private String totalPending = null;
	/* Column Info */
	private String crntUsrId = null;
	/* Column Info */
	private String rtnToRtnStsCd = null;
	/* Column Info */
	private String totalNa = null;
	/* Column Info */
	private String shipper = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String totalInput = null;
	/* Column Info */
	private String rcInpFlg = null;
	/* Column Info */
	private String xterRqstSeq = null;
	/* Column Info */
	private String pctDate = null;
	/* Column Info */
	private String emlSubjCtnt = null;
	/* Column Info */
	private String bkgStaff = null;
	/* Column Info */
	private String blAudFlg = null;
	/* Column Info */
	private String totalCanceled = null;
	/* Column Info */
	private String blNoCtnt = null;
	/* Column Info */
	private String totalBkg = null;
	/* Column Info */
	private String splitStsCd = null;
	/* Column Info */
	private String srepCd = null;
	/* Column Info */
	private String actSrAmdSeq = null;
	/* Column Info */
	private String docTpCd = null;
	/* Column Info */
	private String rtnToUsrId = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String currPage = null;
	/* Column Info */
	private String srDate = null;
	/* Column Info */
	private String obSlsOfcCd = null;
	/* Column Info */
	private String bkgCustTpCd = null;
	/* Column Info */
	private String xterSiCd = null;
	/* Column Info */
	private String messageYn = null;
	/* Column Info */
	private String xterSndrId = null;
	/* Column Info */
	private String blDocInpFlg = null;
	/* Column Info */
	private String srcCd = null;
	/* Column Info */
	private String fax = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String bkgCzDesc = null;
	/* Column Info */
	private String totalNormal = null;
	/* Column Info */
	private String totalVip = null;
	/* Column Info */
	private String dpcsWrkGrpCd = null;
	/* Column Info */
	private String pndUsrId = null;
	/* Column Info */
	private String imgFileNm = null;
	/* Column Info */
	private String totalSr = null;
	/* Column Info */
	private String splitFlg = null;
	/* Column Info */
	private String srCrntStsCd = null;
	/* Column Info */
	private String pndFlg = null;
	/* Column Info */
	private String totalUrgent = null;
	/* Column Info */
	private String bdrFlg = null;
	/* Column Info */
	private String rtnToRtnUsrId = null;
	/* Column Info */
	private String lastDate = null;
	/* Column Info */
	private String bkgUpldStsCd = null;
	/* Column Info */
	private String imgFilePathCtnt = null;
	/* Column Info */
	private String srWrkStsUsrNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vbsClssCd = null;
	/* Column Info */
	private String splitOnlyFlg = null;
	/* Column Info */
	private String srWrkStsCd = null;
	/* Column Info */
	private String srWrkStsUsrId = null;
	/* Column Info */
	private String totalPct = null;
	/* Column Info */
	private String faxLogRefNo = null;
	/* Column Info */
	private String inpPicUsrId = null;
	/* Column Info */
	private String bkgCtrtTpCd = null;
	/* Column Info */
	private String blDrftFaxOutFlg = null;
	/* Column Info */
	private String srNo = null;
	/* Column Info */
	private String docCct = null;
	/* Column Info */
	private String totalRtn = null;
	/* Column Info */
	private String srKind = null;
	/* Column Info */
	private String totalCompleted = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String rtPicUsrId = null;
	/* Column Info */
	private String message = null;
	/* Column Info */
	private String returnSrc = null;
	/* Column Info */
	private String delContiCd = null;
	/* Column Info */
	private String bdrDate = null;
	/* Column Info */
	private String totalEml = null;
	/* Column Info */
	private String xterRqstNo = null;
	/* Column Info */
	private String vol40 = null;
	/* Column Info */
	private String vol20 = null;
	/* Column Info */
	private String vgmFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public DocQueueListOutVO() {}

	public DocQueueListOutVO(String ibflag, String pagerows, String totalWorking, String totalQa, String imgFileRealPath, String blRtFlg, String picId, String totalRate, String srKindCd, String urgency, String obSrepCd, String rowsPerPage, String srCrntInfoCd, String vvdCd, String returnTo, String totalCnt, String custCntCd, String totalFax, String bkgOfcCd, String rtnFmUsrId, String srStsCd, String rtnToUsrEml, String maxSrNo, String imgFileIp, String rtnFreq, String podCd, String bkgNo, String queueStatus, String rtnToUsrRemark, String totalCutoff, String vbsClssNm, String custNm, String bkgStsCd, String srAmdSeq, String returnCd, String totalBdr, String cstmsMfTpCd, String srKndCd, String usrId, String srAmdTpCd, String src, String totalPending, String crntUsrId, String rtnToRtnStsCd, String shipper, String totalNa, String totalInput, String slanCd, String rcInpFlg, String xterRqstSeq, String pctDate, String emlSubjCtnt, String blAudFlg, String totalCanceled, String totalBkg, String splitStsCd, String srepCd, String docTpCd, String rtnToUsrId, String polCd, String delCd, String currPage, String srDate, String obSlsOfcCd, String bkgCustTpCd, String xterSiCd, String messageYn, String xterSndrId, String blDocInpFlg, String srcCd, String fax, String vpsEtdDt, String totalNormal, String totalVip, String dpcsWrkGrpCd, String imgFileNm, String totalSr, String splitFlg, String srCrntStsCd, String pndFlg, String totalUrgent, String bdrFlg, String rtnToRtnUsrId, String lastDate, String bkgUpldStsCd, String imgFilePathCtnt, String srWrkStsUsrNm, String vbsClssCd, String splitOnlyFlg, String srWrkStsCd, String srWrkStsUsrId, String totalPct, String faxLogRefNo, String blDrftFaxOutFlg, String srNo, String docCct, String srKind, String totalRtn, String totalCompleted, String custSeq, String message, String returnSrc, String bdrDate, String xterRqstNo, String totalEml, String picCngId, String totalRtnCust, String totalRtnFo, String rgnOfcCd, String blFntOfcFlg, String pndUsrId, String pndUsrNm, String bkgCtrtTpCd, String contractNo, String bkgCzDesc, String consignee, String blNoCtnt, String inpPicUsrId, String rtPicUsrId, String delContiCd, String actSrAmdSeq, String bkgStaff, String vol20, String vol40, String vgmFlg) {
		this.totalWorking = totalWorking;
		this.totalQa = totalQa;
		this.picCngId = picCngId;
		this.imgFileRealPath = imgFileRealPath;
		this.blRtFlg = blRtFlg;
		this.totalRate = totalRate;
		this.picId = picId;
		this.srKindCd = srKindCd;
		this.urgency = urgency;
		this.pagerows = pagerows;
		this.obSrepCd = obSrepCd;
		this.rowsPerPage = rowsPerPage;
		this.srCrntInfoCd = srCrntInfoCd;
		this.vvdCd = vvdCd;
		this.pndUsrNm = pndUsrNm;
		this.returnTo = returnTo;
		this.contractNo = contractNo;
		this.blFntOfcFlg = blFntOfcFlg;
		this.totalCnt = totalCnt;
		this.custCntCd = custCntCd;
		this.totalRtnCust = totalRtnCust;
		this.totalFax = totalFax;
		this.bkgOfcCd = bkgOfcCd;
		this.rtnFmUsrId = rtnFmUsrId;
		this.srStsCd = srStsCd;
		this.rtnToUsrEml = rtnToUsrEml;
		this.maxSrNo = maxSrNo;
		this.rtnFreq = rtnFreq;
		this.imgFileIp = imgFileIp;
		this.podCd = podCd;
		this.queueStatus = queueStatus;
		this.bkgNo = bkgNo;
		this.totalRtnFo = totalRtnFo;
		this.rtnToUsrRemark = rtnToUsrRemark;
		this.totalCutoff = totalCutoff;
		this.vbsClssNm = vbsClssNm;
		this.custNm = custNm;
		this.consignee = consignee;
		this.bkgStsCd = bkgStsCd;
		this.srAmdSeq = srAmdSeq;
		this.returnCd = returnCd;
		this.totalBdr = totalBdr;
		this.cstmsMfTpCd = cstmsMfTpCd;
		this.srKndCd = srKndCd;
		this.usrId = usrId;
		this.srAmdTpCd = srAmdTpCd;
		this.src = src;
		this.rgnOfcCd = rgnOfcCd;
		this.totalPending = totalPending;
		this.crntUsrId = crntUsrId;
		this.rtnToRtnStsCd = rtnToRtnStsCd;
		this.totalNa = totalNa;
		this.shipper = shipper;
		this.slanCd = slanCd;
		this.totalInput = totalInput;
		this.rcInpFlg = rcInpFlg;
		this.xterRqstSeq = xterRqstSeq;
		this.pctDate = pctDate;
		this.emlSubjCtnt = emlSubjCtnt;
		this.bkgStaff = bkgStaff;
		this.blAudFlg = blAudFlg;
		this.totalCanceled = totalCanceled;
		this.blNoCtnt = blNoCtnt;
		this.totalBkg = totalBkg;
		this.splitStsCd = splitStsCd;
		this.srepCd = srepCd;
		this.actSrAmdSeq = actSrAmdSeq;
		this.docTpCd = docTpCd;
		this.rtnToUsrId = rtnToUsrId;
		this.polCd = polCd;
		this.currPage = currPage;
		this.srDate = srDate;
		this.obSlsOfcCd = obSlsOfcCd;
		this.bkgCustTpCd = bkgCustTpCd;
		this.xterSiCd = xterSiCd;
		this.messageYn = messageYn;
		this.xterSndrId = xterSndrId;
		this.blDocInpFlg = blDocInpFlg;
		this.srcCd = srcCd;
		this.fax = fax;
		this.vpsEtdDt = vpsEtdDt;
		this.delCd = delCd;
		this.bkgCzDesc = bkgCzDesc;
		this.totalNormal = totalNormal;
		this.totalVip = totalVip;
		this.dpcsWrkGrpCd = dpcsWrkGrpCd;
		this.pndUsrId = pndUsrId;
		this.imgFileNm = imgFileNm;
		this.totalSr = totalSr;
		this.splitFlg = splitFlg;
		this.srCrntStsCd = srCrntStsCd;
		this.pndFlg = pndFlg;
		this.totalUrgent = totalUrgent;
		this.bdrFlg = bdrFlg;
		this.rtnToRtnUsrId = rtnToRtnUsrId;
		this.lastDate = lastDate;
		this.bkgUpldStsCd = bkgUpldStsCd;
		this.imgFilePathCtnt = imgFilePathCtnt;
		this.srWrkStsUsrNm = srWrkStsUsrNm;
		this.ibflag = ibflag;
		this.vbsClssCd = vbsClssCd;
		this.splitOnlyFlg = splitOnlyFlg;
		this.srWrkStsCd = srWrkStsCd;
		this.srWrkStsUsrId = srWrkStsUsrId;
		this.totalPct = totalPct;
		this.faxLogRefNo = faxLogRefNo;
		this.inpPicUsrId = inpPicUsrId;
		this.bkgCtrtTpCd = bkgCtrtTpCd;
		this.blDrftFaxOutFlg = blDrftFaxOutFlg;
		this.srNo = srNo;
		this.docCct = docCct;
		this.totalRtn = totalRtn;
		this.srKind = srKind;
		this.totalCompleted = totalCompleted;
		this.custSeq = custSeq;
		this.rtPicUsrId = rtPicUsrId;
		this.message = message;
		this.returnSrc = returnSrc;
		this.delContiCd = delContiCd;
		this.bdrDate = bdrDate;
		this.totalEml = totalEml;
		this.xterRqstNo = xterRqstNo;
		this.vol20 = vol20;
		this.vol40 = vol40;
		this.vgmFlg = vgmFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("total_working", getTotalWorking());
		this.hashColumns.put("total_qa", getTotalQa());
		this.hashColumns.put("pic_cng_id", getPicCngId());
		this.hashColumns.put("img_file_real_path", getImgFileRealPath());
		this.hashColumns.put("bl_rt_flg", getBlRtFlg());
		this.hashColumns.put("total_rate", getTotalRate());
		this.hashColumns.put("pic_id", getPicId());
		this.hashColumns.put("sr_kind_cd", getSrKindCd());
		this.hashColumns.put("urgency", getUrgency());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ob_srep_cd", getObSrepCd());
		this.hashColumns.put("rows_per_page", getRowsPerPage());
		this.hashColumns.put("sr_crnt_info_cd", getSrCrntInfoCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("pnd_usr_nm", getPndUsrNm());
		this.hashColumns.put("return_to", getReturnTo());
		this.hashColumns.put("contract_no", getContractNo());
		this.hashColumns.put("bl_fnt_ofc_flg", getBlFntOfcFlg());
		this.hashColumns.put("total_cnt", getTotalCnt());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("total_rtn_cust", getTotalRtnCust());
		this.hashColumns.put("total_fax", getTotalFax());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("rtn_fm_usr_id", getRtnFmUsrId());
		this.hashColumns.put("sr_sts_cd", getSrStsCd());
		this.hashColumns.put("rtn_to_usr_eml", getRtnToUsrEml());
		this.hashColumns.put("max_sr_no", getMaxSrNo());
		this.hashColumns.put("rtn_freq", getRtnFreq());
		this.hashColumns.put("img_file_ip", getImgFileIp());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("queue_status", getQueueStatus());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("total_rtn_fo", getTotalRtnFo());
		this.hashColumns.put("rtn_to_usr_remark", getRtnToUsrRemark());
		this.hashColumns.put("total_cutoff", getTotalCutoff());
		this.hashColumns.put("vbs_clss_nm", getVbsClssNm());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("consignee", getConsignee());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("sr_amd_seq", getSrAmdSeq());
		this.hashColumns.put("return_cd", getReturnCd());
		this.hashColumns.put("total_bdr", getTotalBdr());
		this.hashColumns.put("cstms_mf_tp_cd", getCstmsMfTpCd());
		this.hashColumns.put("sr_knd_cd", getSrKndCd());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("sr_amd_tp_cd", getSrAmdTpCd());
		this.hashColumns.put("src", getSrc());
		this.hashColumns.put("rgn_ofc_cd", getRgnOfcCd());
		this.hashColumns.put("total_pending", getTotalPending());
		this.hashColumns.put("crnt_usr_id", getCrntUsrId());
		this.hashColumns.put("rtn_to_rtn_sts_cd", getRtnToRtnStsCd());
		this.hashColumns.put("total_na", getTotalNa());
		this.hashColumns.put("shipper", getShipper());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("total_input", getTotalInput());
		this.hashColumns.put("rc_inp_flg", getRcInpFlg());
		this.hashColumns.put("xter_rqst_seq", getXterRqstSeq());
		this.hashColumns.put("pct_date", getPctDate());
		this.hashColumns.put("eml_subj_ctnt", getEmlSubjCtnt());
		this.hashColumns.put("bkg_staff", getBkgStaff());
		this.hashColumns.put("bl_aud_flg", getBlAudFlg());
		this.hashColumns.put("total_canceled", getTotalCanceled());
		this.hashColumns.put("bl_no_ctnt", getBlNoCtnt());
		this.hashColumns.put("total_bkg", getTotalBkg());
		this.hashColumns.put("split_sts_cd", getSplitStsCd());
		this.hashColumns.put("srep_cd", getSrepCd());
		this.hashColumns.put("act_sr_amd_seq", getActSrAmdSeq());
		this.hashColumns.put("doc_tp_cd", getDocTpCd());
		this.hashColumns.put("rtn_to_usr_id", getRtnToUsrId());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("curr_page", getCurrPage());
		this.hashColumns.put("sr_date", getSrDate());
		this.hashColumns.put("ob_sls_ofc_cd", getObSlsOfcCd());
		this.hashColumns.put("bkg_cust_tp_cd", getBkgCustTpCd());
		this.hashColumns.put("xter_si_cd", getXterSiCd());
		this.hashColumns.put("message_yn", getMessageYn());
		this.hashColumns.put("xter_sndr_id", getXterSndrId());
		this.hashColumns.put("bl_doc_inp_flg", getBlDocInpFlg());
		this.hashColumns.put("src_cd", getSrcCd());
		this.hashColumns.put("fax", getFax());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("bkg_cz_desc", getBkgCzDesc());
		this.hashColumns.put("total_normal", getTotalNormal());
		this.hashColumns.put("total_vip", getTotalVip());
		this.hashColumns.put("dpcs_wrk_grp_cd", getDpcsWrkGrpCd());
		this.hashColumns.put("pnd_usr_id", getPndUsrId());
		this.hashColumns.put("img_file_nm", getImgFileNm());
		this.hashColumns.put("total_sr", getTotalSr());
		this.hashColumns.put("split_flg", getSplitFlg());
		this.hashColumns.put("sr_crnt_sts_cd", getSrCrntStsCd());
		this.hashColumns.put("pnd_flg", getPndFlg());
		this.hashColumns.put("total_urgent", getTotalUrgent());
		this.hashColumns.put("bdr_flg", getBdrFlg());
		this.hashColumns.put("rtn_to_rtn_usr_id", getRtnToRtnUsrId());
		this.hashColumns.put("last_date", getLastDate());
		this.hashColumns.put("bkg_upld_sts_cd", getBkgUpldStsCd());
		this.hashColumns.put("img_file_path_ctnt", getImgFilePathCtnt());
		this.hashColumns.put("sr_wrk_sts_usr_nm", getSrWrkStsUsrNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vbs_clss_cd", getVbsClssCd());
		this.hashColumns.put("split_only_flg", getSplitOnlyFlg());
		this.hashColumns.put("sr_wrk_sts_cd", getSrWrkStsCd());
		this.hashColumns.put("sr_wrk_sts_usr_id", getSrWrkStsUsrId());
		this.hashColumns.put("total_pct", getTotalPct());
		this.hashColumns.put("fax_log_ref_no", getFaxLogRefNo());
		this.hashColumns.put("inp_pic_usr_id", getInpPicUsrId());
		this.hashColumns.put("bkg_ctrt_tp_cd", getBkgCtrtTpCd());
		this.hashColumns.put("bl_drft_fax_out_flg", getBlDrftFaxOutFlg());
		this.hashColumns.put("sr_no", getSrNo());
		this.hashColumns.put("doc_cct", getDocCct());
		this.hashColumns.put("total_rtn", getTotalRtn());
		this.hashColumns.put("sr_kind", getSrKind());
		this.hashColumns.put("total_completed", getTotalCompleted());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("rt_pic_usr_id", getRtPicUsrId());
		this.hashColumns.put("message", getMessage());
		this.hashColumns.put("return_src", getReturnSrc());
		this.hashColumns.put("del_conti_cd", getDelContiCd());
		this.hashColumns.put("bdr_date", getBdrDate());
		this.hashColumns.put("total_eml", getTotalEml());
		this.hashColumns.put("xter_rqst_no", getXterRqstNo());
		this.hashColumns.put("vol20", getVol20());
		this.hashColumns.put("vol40", getVol40());
		this.hashColumns.put("vgm_flg", getVgmFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("total_working", "totalWorking");
		this.hashFields.put("total_qa", "totalQa");
		this.hashFields.put("pic_cng_id", "picCngId");
		this.hashFields.put("img_file_real_path", "imgFileRealPath");
		this.hashFields.put("bl_rt_flg", "blRtFlg");
		this.hashFields.put("total_rate", "totalRate");
		this.hashFields.put("pic_id", "picId");
		this.hashFields.put("sr_kind_cd", "srKindCd");
		this.hashFields.put("urgency", "urgency");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ob_srep_cd", "obSrepCd");
		this.hashFields.put("rows_per_page", "rowsPerPage");
		this.hashFields.put("sr_crnt_info_cd", "srCrntInfoCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("pnd_usr_nm", "pndUsrNm");
		this.hashFields.put("return_to", "returnTo");
		this.hashFields.put("contract_no", "contractNo");
		this.hashFields.put("bl_fnt_ofc_flg", "blFntOfcFlg");
		this.hashFields.put("total_cnt", "totalCnt");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("total_rtn_cust", "totalRtnCust");
		this.hashFields.put("total_fax", "totalFax");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("rtn_fm_usr_id", "rtnFmUsrId");
		this.hashFields.put("sr_sts_cd", "srStsCd");
		this.hashFields.put("rtn_to_usr_eml", "rtnToUsrEml");
		this.hashFields.put("max_sr_no", "maxSrNo");
		this.hashFields.put("rtn_freq", "rtnFreq");
		this.hashFields.put("img_file_ip", "imgFileIp");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("queue_status", "queueStatus");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("total_rtn_fo", "totalRtnFo");
		this.hashFields.put("rtn_to_usr_remark", "rtnToUsrRemark");
		this.hashFields.put("total_cutoff", "totalCutoff");
		this.hashFields.put("vbs_clss_nm", "vbsClssNm");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("consignee", "consignee");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("sr_amd_seq", "srAmdSeq");
		this.hashFields.put("return_cd", "returnCd");
		this.hashFields.put("total_bdr", "totalBdr");
		this.hashFields.put("cstms_mf_tp_cd", "cstmsMfTpCd");
		this.hashFields.put("sr_knd_cd", "srKndCd");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("sr_amd_tp_cd", "srAmdTpCd");
		this.hashFields.put("src", "src");
		this.hashFields.put("rgn_ofc_cd", "rgnOfcCd");
		this.hashFields.put("total_pending", "totalPending");
		this.hashFields.put("crnt_usr_id", "crntUsrId");
		this.hashFields.put("rtn_to_rtn_sts_cd", "rtnToRtnStsCd");
		this.hashFields.put("total_na", "totalNa");
		this.hashFields.put("shipper", "shipper");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("total_input", "totalInput");
		this.hashFields.put("rc_inp_flg", "rcInpFlg");
		this.hashFields.put("xter_rqst_seq", "xterRqstSeq");
		this.hashFields.put("pct_date", "pctDate");
		this.hashFields.put("eml_subj_ctnt", "emlSubjCtnt");
		this.hashFields.put("bkg_staff", "bkgStaff");
		this.hashFields.put("bl_aud_flg", "blAudFlg");
		this.hashFields.put("total_canceled", "totalCanceled");
		this.hashFields.put("bl_no_ctnt", "blNoCtnt");
		this.hashFields.put("total_bkg", "totalBkg");
		this.hashFields.put("split_sts_cd", "splitStsCd");
		this.hashFields.put("srep_cd", "srepCd");
		this.hashFields.put("act_sr_amd_seq", "actSrAmdSeq");
		this.hashFields.put("doc_tp_cd", "docTpCd");
		this.hashFields.put("rtn_to_usr_id", "rtnToUsrId");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("curr_page", "currPage");
		this.hashFields.put("sr_date", "srDate");
		this.hashFields.put("ob_sls_ofc_cd", "obSlsOfcCd");
		this.hashFields.put("bkg_cust_tp_cd", "bkgCustTpCd");
		this.hashFields.put("xter_si_cd", "xterSiCd");
		this.hashFields.put("message_yn", "messageYn");
		this.hashFields.put("xter_sndr_id", "xterSndrId");
		this.hashFields.put("bl_doc_inp_flg", "blDocInpFlg");
		this.hashFields.put("src_cd", "srcCd");
		this.hashFields.put("fax", "fax");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("bkg_cz_desc", "bkgCzDesc");
		this.hashFields.put("total_normal", "totalNormal");
		this.hashFields.put("total_vip", "totalVip");
		this.hashFields.put("dpcs_wrk_grp_cd", "dpcsWrkGrpCd");
		this.hashFields.put("pnd_usr_id", "pndUsrId");
		this.hashFields.put("img_file_nm", "imgFileNm");
		this.hashFields.put("total_sr", "totalSr");
		this.hashFields.put("split_flg", "splitFlg");
		this.hashFields.put("sr_crnt_sts_cd", "srCrntStsCd");
		this.hashFields.put("pnd_flg", "pndFlg");
		this.hashFields.put("total_urgent", "totalUrgent");
		this.hashFields.put("bdr_flg", "bdrFlg");
		this.hashFields.put("rtn_to_rtn_usr_id", "rtnToRtnUsrId");
		this.hashFields.put("last_date", "lastDate");
		this.hashFields.put("bkg_upld_sts_cd", "bkgUpldStsCd");
		this.hashFields.put("img_file_path_ctnt", "imgFilePathCtnt");
		this.hashFields.put("sr_wrk_sts_usr_nm", "srWrkStsUsrNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vbs_clss_cd", "vbsClssCd");
		this.hashFields.put("split_only_flg", "splitOnlyFlg");
		this.hashFields.put("sr_wrk_sts_cd", "srWrkStsCd");
		this.hashFields.put("sr_wrk_sts_usr_id", "srWrkStsUsrId");
		this.hashFields.put("total_pct", "totalPct");
		this.hashFields.put("fax_log_ref_no", "faxLogRefNo");
		this.hashFields.put("inp_pic_usr_id", "inpPicUsrId");
		this.hashFields.put("bkg_ctrt_tp_cd", "bkgCtrtTpCd");
		this.hashFields.put("bl_drft_fax_out_flg", "blDrftFaxOutFlg");
		this.hashFields.put("sr_no", "srNo");
		this.hashFields.put("doc_cct", "docCct");
		this.hashFields.put("total_rtn", "totalRtn");
		this.hashFields.put("sr_kind", "srKind");
		this.hashFields.put("total_completed", "totalCompleted");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("rt_pic_usr_id", "rtPicUsrId");
		this.hashFields.put("message", "message");
		this.hashFields.put("return_src", "returnSrc");
		this.hashFields.put("del_conti_cd", "delContiCd");
		this.hashFields.put("bdr_date", "bdrDate");
		this.hashFields.put("total_eml", "totalEml");
		this.hashFields.put("xter_rqst_no", "xterRqstNo");
		this.hashFields.put("vol20", "vol20");
		this.hashFields.put("vol40", "vol40");
		this.hashFields.put("vgm_flg", "vgmFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return totalWorking
	 */
	public String getTotalWorking() {
		return this.totalWorking;
	}
	
	/**
	 * Column Info
	 * @return totalQa
	 */
	public String getTotalQa() {
		return this.totalQa;
	}
	
	/**
	 * Column Info
	 * @return picCngId
	 */
	public String getPicCngId() {
		return this.picCngId;
	}
	
	/**
	 * Column Info
	 * @return imgFileRealPath
	 */
	public String getImgFileRealPath() {
		return this.imgFileRealPath;
	}
	
	/**
	 * Column Info
	 * @return blRtFlg
	 */
	public String getBlRtFlg() {
		return this.blRtFlg;
	}
	
	/**
	 * Column Info
	 * @return totalRate
	 */
	public String getTotalRate() {
		return this.totalRate;
	}
	
	/**
	 * Column Info
	 * @return picId
	 */
	public String getPicId() {
		return this.picId;
	}
	
	/**
	 * Column Info
	 * @return srKindCd
	 */
	public String getSrKindCd() {
		return this.srKindCd;
	}
	
	/**
	 * Column Info
	 * @return urgency
	 */
	public String getUrgency() {
		return this.urgency;
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
	 * @return obSrepCd
	 */
	public String getObSrepCd() {
		return this.obSrepCd;
	}
	
	/**
	 * Column Info
	 * @return rowsPerPage
	 */
	public String getRowsPerPage() {
		return this.rowsPerPage;
	}
	
	/**
	 * Column Info
	 * @return srCrntInfoCd
	 */
	public String getSrCrntInfoCd() {
		return this.srCrntInfoCd;
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
	 * @return pndUsrNm
	 */
	public String getPndUsrNm() {
		return this.pndUsrNm;
	}
	
	/**
	 * Column Info
	 * @return returnTo
	 */
	public String getReturnTo() {
		return this.returnTo;
	}
	
	/**
	 * Column Info
	 * @return contractNo
	 */
	public String getContractNo() {
		return this.contractNo;
	}
	
	/**
	 * Column Info
	 * @return blFntOfcFlg
	 */
	public String getBlFntOfcFlg() {
		return this.blFntOfcFlg;
	}
	
	/**
	 * Column Info
	 * @return totalCnt
	 */
	public String getTotalCnt() {
		return this.totalCnt;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return totalRtnCust
	 */
	public String getTotalRtnCust() {
		return this.totalRtnCust;
	}
	
	/**
	 * Column Info
	 * @return totalFax
	 */
	public String getTotalFax() {
		return this.totalFax;
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
	 * @return rtnFmUsrId
	 */
	public String getRtnFmUsrId() {
		return this.rtnFmUsrId;
	}
	
	/**
	 * Column Info
	 * @return srStsCd
	 */
	public String getSrStsCd() {
		return this.srStsCd;
	}
	
	/**
	 * Column Info
	 * @return rtnToUsrEml
	 */
	public String getRtnToUsrEml() {
		return this.rtnToUsrEml;
	}
	
	/**
	 * Column Info
	 * @return maxSrNo
	 */
	public String getMaxSrNo() {
		return this.maxSrNo;
	}
	
	/**
	 * Column Info
	 * @return rtnFreq
	 */
	public String getRtnFreq() {
		return this.rtnFreq;
	}
	
	/**
	 * Column Info
	 * @return imgFileIp
	 */
	public String getImgFileIp() {
		return this.imgFileIp;
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
	 * @return queueStatus
	 */
	public String getQueueStatus() {
		return this.queueStatus;
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
	 * @return totalRtnFo
	 */
	public String getTotalRtnFo() {
		return this.totalRtnFo;
	}
	
	/**
	 * Column Info
	 * @return rtnToUsrRemark
	 */
	public String getRtnToUsrRemark() {
		return this.rtnToUsrRemark;
	}
	
	/**
	 * Column Info
	 * @return totalCutoff
	 */
	public String getTotalCutoff() {
		return this.totalCutoff;
	}
	
	/**
	 * Column Info
	 * @return vbsClssNm
	 */
	public String getVbsClssNm() {
		return this.vbsClssNm;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return consignee
	 */
	public String getConsignee() {
		return this.consignee;
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
	 * @return srAmdSeq
	 */
	public String getSrAmdSeq() {
		return this.srAmdSeq;
	}
	
	/**
	 * Column Info
	 * @return returnCd
	 */
	public String getReturnCd() {
		return this.returnCd;
	}
	
	/**
	 * Column Info
	 * @return totalBdr
	 */
	public String getTotalBdr() {
		return this.totalBdr;
	}
	
	/**
	 * Column Info
	 * @return cstmsMfTpCd
	 */
	public String getCstmsMfTpCd() {
		return this.cstmsMfTpCd;
	}
	
	/**
	 * Column Info
	 * @return srKndCd
	 */
	public String getSrKndCd() {
		return this.srKndCd;
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
	 * @return srAmdTpCd
	 */
	public String getSrAmdTpCd() {
		return this.srAmdTpCd;
	}
	
	/**
	 * Column Info
	 * @return src
	 */
	public String getSrc() {
		return this.src;
	}
	
	/**
	 * Column Info
	 * @return rgnOfcCd
	 */
	public String getRgnOfcCd() {
		return this.rgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @return totalPending
	 */
	public String getTotalPending() {
		return this.totalPending;
	}
	
	/**
	 * Column Info
	 * @return crntUsrId
	 */
	public String getCrntUsrId() {
		return this.crntUsrId;
	}
	
	/**
	 * Column Info
	 * @return rtnToRtnStsCd
	 */
	public String getRtnToRtnStsCd() {
		return this.rtnToRtnStsCd;
	}
	
	/**
	 * Column Info
	 * @return totalNa
	 */
	public String getTotalNa() {
		return this.totalNa;
	}
	
	/**
	 * Column Info
	 * @return shipper
	 */
	public String getShipper() {
		return this.shipper;
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
	 * @return totalInput
	 */
	public String getTotalInput() {
		return this.totalInput;
	}
	
	/**
	 * Column Info
	 * @return rcInpFlg
	 */
	public String getRcInpFlg() {
		return this.rcInpFlg;
	}
	
	/**
	 * Column Info
	 * @return xterRqstSeq
	 */
	public String getXterRqstSeq() {
		return this.xterRqstSeq;
	}
	
	/**
	 * Column Info
	 * @return pctDate
	 */
	public String getPctDate() {
		return this.pctDate;
	}
	
	/**
	 * Column Info
	 * @return emlSubjCtnt
	 */
	public String getEmlSubjCtnt() {
		return this.emlSubjCtnt;
	}
	
	/**
	 * Column Info
	 * @return bkgStaff
	 */
	public String getBkgStaff() {
		return this.bkgStaff;
	}
	
	/**
	 * Column Info
	 * @return blAudFlg
	 */
	public String getBlAudFlg() {
		return this.blAudFlg;
	}
	
	/**
	 * Column Info
	 * @return totalCanceled
	 */
	public String getTotalCanceled() {
		return this.totalCanceled;
	}
	
	/**
	 * Column Info
	 * @return blNoCtnt
	 */
	public String getBlNoCtnt() {
		return this.blNoCtnt;
	}
	
	/**
	 * Column Info
	 * @return totalBkg
	 */
	public String getTotalBkg() {
		return this.totalBkg;
	}
	
	/**
	 * Column Info
	 * @return splitStsCd
	 */
	public String getSplitStsCd() {
		return this.splitStsCd;
	}
	
	/**
	 * Column Info
	 * @return srepCd
	 */
	public String getSrepCd() {
		return this.srepCd;
	}
	
	/**
	 * Column Info
	 * @return actSrAmdSeq
	 */
	public String getActSrAmdSeq() {
		return this.actSrAmdSeq;
	}
	
	/**
	 * Column Info
	 * @return docTpCd
	 */
	public String getDocTpCd() {
		return this.docTpCd;
	}
	
	/**
	 * Column Info
	 * @return rtnToUsrId
	 */
	public String getRtnToUsrId() {
		return this.rtnToUsrId;
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
	 * @return currPage
	 */
	public String getCurrPage() {
		return this.currPage;
	}
	
	/**
	 * Column Info
	 * @return srDate
	 */
	public String getSrDate() {
		return this.srDate;
	}
	
	/**
	 * Column Info
	 * @return obSlsOfcCd
	 */
	public String getObSlsOfcCd() {
		return this.obSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return bkgCustTpCd
	 */
	public String getBkgCustTpCd() {
		return this.bkgCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return xterSiCd
	 */
	public String getXterSiCd() {
		return this.xterSiCd;
	}
	
	/**
	 * Column Info
	 * @return messageYn
	 */
	public String getMessageYn() {
		return this.messageYn;
	}
	
	/**
	 * Column Info
	 * @return xterSndrId
	 */
	public String getXterSndrId() {
		return this.xterSndrId;
	}
	
	/**
	 * Column Info
	 * @return blDocInpFlg
	 */
	public String getBlDocInpFlg() {
		return this.blDocInpFlg;
	}
	
	/**
	 * Column Info
	 * @return srcCd
	 */
	public String getSrcCd() {
		return this.srcCd;
	}
	
	/**
	 * Column Info
	 * @return fax
	 */
	public String getFax() {
		return this.fax;
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
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return bkgCzDesc
	 */
	public String getBkgCzDesc() {
		return this.bkgCzDesc;
	}
	
	/**
	 * Column Info
	 * @return totalNormal
	 */
	public String getTotalNormal() {
		return this.totalNormal;
	}
	
	/**
	 * Column Info
	 * @return totalVip
	 */
	public String getTotalVip() {
		return this.totalVip;
	}
	
	/**
	 * Column Info
	 * @return dpcsWrkGrpCd
	 */
	public String getDpcsWrkGrpCd() {
		return this.dpcsWrkGrpCd;
	}
	
	/**
	 * Column Info
	 * @return pndUsrId
	 */
	public String getPndUsrId() {
		return this.pndUsrId;
	}
	
	/**
	 * Column Info
	 * @return imgFileNm
	 */
	public String getImgFileNm() {
		return this.imgFileNm;
	}
	
	/**
	 * Column Info
	 * @return totalSr
	 */
	public String getTotalSr() {
		return this.totalSr;
	}
	
	/**
	 * Column Info
	 * @return splitFlg
	 */
	public String getSplitFlg() {
		return this.splitFlg;
	}
	
	/**
	 * Column Info
	 * @return srCrntStsCd
	 */
	public String getSrCrntStsCd() {
		return this.srCrntStsCd;
	}
	
	/**
	 * Column Info
	 * @return pndFlg
	 */
	public String getPndFlg() {
		return this.pndFlg;
	}
	
	/**
	 * Column Info
	 * @return totalUrgent
	 */
	public String getTotalUrgent() {
		return this.totalUrgent;
	}
	
	/**
	 * Column Info
	 * @return bdrFlg
	 */
	public String getBdrFlg() {
		return this.bdrFlg;
	}
	
	/**
	 * Column Info
	 * @return rtnToRtnUsrId
	 */
	public String getRtnToRtnUsrId() {
		return this.rtnToRtnUsrId;
	}
	
	/**
	 * Column Info
	 * @return lastDate
	 */
	public String getLastDate() {
		return this.lastDate;
	}
	
	/**
	 * Column Info
	 * @return bkgUpldStsCd
	 */
	public String getBkgUpldStsCd() {
		return this.bkgUpldStsCd;
	}
	
	/**
	 * Column Info
	 * @return imgFilePathCtnt
	 */
	public String getImgFilePathCtnt() {
		return this.imgFilePathCtnt;
	}
	
	/**
	 * Column Info
	 * @return srWrkStsUsrNm
	 */
	public String getSrWrkStsUsrNm() {
		return this.srWrkStsUsrNm;
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
	 * @return vbsClssCd
	 */
	public String getVbsClssCd() {
		return this.vbsClssCd;
	}
	
	/**
	 * Column Info
	 * @return splitOnlyFlg
	 */
	public String getSplitOnlyFlg() {
		return this.splitOnlyFlg;
	}
	
	/**
	 * Column Info
	 * @return srWrkStsCd
	 */
	public String getSrWrkStsCd() {
		return this.srWrkStsCd;
	}
	
	/**
	 * Column Info
	 * @return srWrkStsUsrId
	 */
	public String getSrWrkStsUsrId() {
		return this.srWrkStsUsrId;
	}
	
	/**
	 * Column Info
	 * @return totalPct
	 */
	public String getTotalPct() {
		return this.totalPct;
	}
	
	/**
	 * Column Info
	 * @return faxLogRefNo
	 */
	public String getFaxLogRefNo() {
		return this.faxLogRefNo;
	}
	
	/**
	 * Column Info
	 * @return inpPicUsrId
	 */
	public String getInpPicUsrId() {
		return this.inpPicUsrId;
	}
	
	/**
	 * Column Info
	 * @return bkgCtrtTpCd
	 */
	public String getBkgCtrtTpCd() {
		return this.bkgCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @return blDrftFaxOutFlg
	 */
	public String getBlDrftFaxOutFlg() {
		return this.blDrftFaxOutFlg;
	}
	
	/**
	 * Column Info
	 * @return srNo
	 */
	public String getSrNo() {
		return this.srNo;
	}
	
	/**
	 * Column Info
	 * @return docCct
	 */
	public String getDocCct() {
		return this.docCct;
	}
	
	/**
	 * Column Info
	 * @return totalRtn
	 */
	public String getTotalRtn() {
		return this.totalRtn;
	}
	
	/**
	 * Column Info
	 * @return srKind
	 */
	public String getSrKind() {
		return this.srKind;
	}
	
	/**
	 * Column Info
	 * @return totalCompleted
	 */
	public String getTotalCompleted() {
		return this.totalCompleted;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return rtPicUsrId
	 */
	public String getRtPicUsrId() {
		return this.rtPicUsrId;
	}
	
	/**
	 * Column Info
	 * @return message
	 */
	public String getMessage() {
		return this.message;
	}
	
	/**
	 * Column Info
	 * @return returnSrc
	 */
	public String getReturnSrc() {
		return this.returnSrc;
	}
	
	/**
	 * Column Info
	 * @return delContiCd
	 */
	public String getDelContiCd() {
		return this.delContiCd;
	}
	
	/**
	 * Column Info
	 * @return bdrDate
	 */
	public String getBdrDate() {
		return this.bdrDate;
	}
	
	/**
	 * Column Info
	 * @return totalEml
	 */
	public String getTotalEml() {
		return this.totalEml;
	}
	
	/**
	 * Column Info
	 * @return xterRqstNo
	 */
	public String getXterRqstNo() {
		return this.xterRqstNo;
	}
	

	public String getVol40() {
		return vol40;
	}

	public void setVol40(String vol40) {
		this.vol40 = vol40;
	}

	public String getVol20() {
		return vol20;
	}

	public void setVol20(String vol20) {
		this.vol20 = vol20;
	}

	public String getVgmFlg() {
		return vgmFlg;
	}

	public void setVgmFlg(String vgmFlg) {
		this.vgmFlg = vgmFlg;
	}

	/**
	 * Column Info
	 * @param totalWorking
	 */
	public void setTotalWorking(String totalWorking) {
		this.totalWorking = totalWorking;
	}
	
	/**
	 * Column Info
	 * @param totalQa
	 */
	public void setTotalQa(String totalQa) {
		this.totalQa = totalQa;
	}
	
	/**
	 * Column Info
	 * @param picCngId
	 */
	public void setPicCngId(String picCngId) {
		this.picCngId = picCngId;
	}
	
	/**
	 * Column Info
	 * @param imgFileRealPath
	 */
	public void setImgFileRealPath(String imgFileRealPath) {
		this.imgFileRealPath = imgFileRealPath;
	}
	
	/**
	 * Column Info
	 * @param blRtFlg
	 */
	public void setBlRtFlg(String blRtFlg) {
		this.blRtFlg = blRtFlg;
	}
	
	/**
	 * Column Info
	 * @param totalRate
	 */
	public void setTotalRate(String totalRate) {
		this.totalRate = totalRate;
	}
	
	/**
	 * Column Info
	 * @param picId
	 */
	public void setPicId(String picId) {
		this.picId = picId;
	}
	
	/**
	 * Column Info
	 * @param srKindCd
	 */
	public void setSrKindCd(String srKindCd) {
		this.srKindCd = srKindCd;
	}
	
	/**
	 * Column Info
	 * @param urgency
	 */
	public void setUrgency(String urgency) {
		this.urgency = urgency;
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
	 * @param obSrepCd
	 */
	public void setObSrepCd(String obSrepCd) {
		this.obSrepCd = obSrepCd;
	}
	
	/**
	 * Column Info
	 * @param rowsPerPage
	 */
	public void setRowsPerPage(String rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}
	
	/**
	 * Column Info
	 * @param srCrntInfoCd
	 */
	public void setSrCrntInfoCd(String srCrntInfoCd) {
		this.srCrntInfoCd = srCrntInfoCd;
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
	 * @param pndUsrNm
	 */
	public void setPndUsrNm(String pndUsrNm) {
		this.pndUsrNm = pndUsrNm;
	}
	
	/**
	 * Column Info
	 * @param returnTo
	 */
	public void setReturnTo(String returnTo) {
		this.returnTo = returnTo;
	}
	
	/**
	 * Column Info
	 * @param contractNo
	 */
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	
	/**
	 * Column Info
	 * @param blFntOfcFlg
	 */
	public void setBlFntOfcFlg(String blFntOfcFlg) {
		this.blFntOfcFlg = blFntOfcFlg;
	}
	
	/**
	 * Column Info
	 * @param totalCnt
	 */
	public void setTotalCnt(String totalCnt) {
		this.totalCnt = totalCnt;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param totalRtnCust
	 */
	public void setTotalRtnCust(String totalRtnCust) {
		this.totalRtnCust = totalRtnCust;
	}
	
	/**
	 * Column Info
	 * @param totalFax
	 */
	public void setTotalFax(String totalFax) {
		this.totalFax = totalFax;
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
	 * @param rtnFmUsrId
	 */
	public void setRtnFmUsrId(String rtnFmUsrId) {
		this.rtnFmUsrId = rtnFmUsrId;
	}
	
	/**
	 * Column Info
	 * @param srStsCd
	 */
	public void setSrStsCd(String srStsCd) {
		this.srStsCd = srStsCd;
	}
	
	/**
	 * Column Info
	 * @param rtnToUsrEml
	 */
	public void setRtnToUsrEml(String rtnToUsrEml) {
		this.rtnToUsrEml = rtnToUsrEml;
	}
	
	/**
	 * Column Info
	 * @param maxSrNo
	 */
	public void setMaxSrNo(String maxSrNo) {
		this.maxSrNo = maxSrNo;
	}
	
	/**
	 * Column Info
	 * @param rtnFreq
	 */
	public void setRtnFreq(String rtnFreq) {
		this.rtnFreq = rtnFreq;
	}
	
	/**
	 * Column Info
	 * @param imgFileIp
	 */
	public void setImgFileIp(String imgFileIp) {
		this.imgFileIp = imgFileIp;
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
	 * @param queueStatus
	 */
	public void setQueueStatus(String queueStatus) {
		this.queueStatus = queueStatus;
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
	 * @param totalRtnFo
	 */
	public void setTotalRtnFo(String totalRtnFo) {
		this.totalRtnFo = totalRtnFo;
	}
	
	/**
	 * Column Info
	 * @param rtnToUsrRemark
	 */
	public void setRtnToUsrRemark(String rtnToUsrRemark) {
		this.rtnToUsrRemark = rtnToUsrRemark;
	}
	
	/**
	 * Column Info
	 * @param totalCutoff
	 */
	public void setTotalCutoff(String totalCutoff) {
		this.totalCutoff = totalCutoff;
	}
	
	/**
	 * Column Info
	 * @param vbsClssNm
	 */
	public void setVbsClssNm(String vbsClssNm) {
		this.vbsClssNm = vbsClssNm;
	}
	
	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param consignee
	 */
	public void setConsignee(String consignee) {
		this.consignee = consignee;
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
	 * @param srAmdSeq
	 */
	public void setSrAmdSeq(String srAmdSeq) {
		this.srAmdSeq = srAmdSeq;
	}
	
	/**
	 * Column Info
	 * @param returnCd
	 */
	public void setReturnCd(String returnCd) {
		this.returnCd = returnCd;
	}
	
	/**
	 * Column Info
	 * @param totalBdr
	 */
	public void setTotalBdr(String totalBdr) {
		this.totalBdr = totalBdr;
	}
	
	/**
	 * Column Info
	 * @param cstmsMfTpCd
	 */
	public void setCstmsMfTpCd(String cstmsMfTpCd) {
		this.cstmsMfTpCd = cstmsMfTpCd;
	}
	
	/**
	 * Column Info
	 * @param srKndCd
	 */
	public void setSrKndCd(String srKndCd) {
		this.srKndCd = srKndCd;
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
	 * @param srAmdTpCd
	 */
	public void setSrAmdTpCd(String srAmdTpCd) {
		this.srAmdTpCd = srAmdTpCd;
	}
	
	/**
	 * Column Info
	 * @param src
	 */
	public void setSrc(String src) {
		this.src = src;
	}
	
	/**
	 * Column Info
	 * @param rgnOfcCd
	 */
	public void setRgnOfcCd(String rgnOfcCd) {
		this.rgnOfcCd = rgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @param totalPending
	 */
	public void setTotalPending(String totalPending) {
		this.totalPending = totalPending;
	}
	
	/**
	 * Column Info
	 * @param crntUsrId
	 */
	public void setCrntUsrId(String crntUsrId) {
		this.crntUsrId = crntUsrId;
	}
	
	/**
	 * Column Info
	 * @param rtnToRtnStsCd
	 */
	public void setRtnToRtnStsCd(String rtnToRtnStsCd) {
		this.rtnToRtnStsCd = rtnToRtnStsCd;
	}
	
	/**
	 * Column Info
	 * @param totalNa
	 */
	public void setTotalNa(String totalNa) {
		this.totalNa = totalNa;
	}
	
	/**
	 * Column Info
	 * @param shipper
	 */
	public void setShipper(String shipper) {
		this.shipper = shipper;
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
	 * @param totalInput
	 */
	public void setTotalInput(String totalInput) {
		this.totalInput = totalInput;
	}
	
	/**
	 * Column Info
	 * @param rcInpFlg
	 */
	public void setRcInpFlg(String rcInpFlg) {
		this.rcInpFlg = rcInpFlg;
	}
	
	/**
	 * Column Info
	 * @param xterRqstSeq
	 */
	public void setXterRqstSeq(String xterRqstSeq) {
		this.xterRqstSeq = xterRqstSeq;
	}
	
	/**
	 * Column Info
	 * @param pctDate
	 */
	public void setPctDate(String pctDate) {
		this.pctDate = pctDate;
	}
	
	/**
	 * Column Info
	 * @param emlSubjCtnt
	 */
	public void setEmlSubjCtnt(String emlSubjCtnt) {
		this.emlSubjCtnt = emlSubjCtnt;
	}
	
	/**
	 * Column Info
	 * @param bkgStaff
	 */
	public void setBkgStaff(String bkgStaff) {
		this.bkgStaff = bkgStaff;
	}
	
	/**
	 * Column Info
	 * @param blAudFlg
	 */
	public void setBlAudFlg(String blAudFlg) {
		this.blAudFlg = blAudFlg;
	}
	
	/**
	 * Column Info
	 * @param totalCanceled
	 */
	public void setTotalCanceled(String totalCanceled) {
		this.totalCanceled = totalCanceled;
	}
	
	/**
	 * Column Info
	 * @param blNoCtnt
	 */
	public void setBlNoCtnt(String blNoCtnt) {
		this.blNoCtnt = blNoCtnt;
	}
	
	/**
	 * Column Info
	 * @param totalBkg
	 */
	public void setTotalBkg(String totalBkg) {
		this.totalBkg = totalBkg;
	}
	
	/**
	 * Column Info
	 * @param splitStsCd
	 */
	public void setSplitStsCd(String splitStsCd) {
		this.splitStsCd = splitStsCd;
	}
	
	/**
	 * Column Info
	 * @param srepCd
	 */
	public void setSrepCd(String srepCd) {
		this.srepCd = srepCd;
	}
	
	/**
	 * Column Info
	 * @param actSrAmdSeq
	 */
	public void setActSrAmdSeq(String actSrAmdSeq) {
		this.actSrAmdSeq = actSrAmdSeq;
	}
	
	/**
	 * Column Info
	 * @param docTpCd
	 */
	public void setDocTpCd(String docTpCd) {
		this.docTpCd = docTpCd;
	}
	
	/**
	 * Column Info
	 * @param rtnToUsrId
	 */
	public void setRtnToUsrId(String rtnToUsrId) {
		this.rtnToUsrId = rtnToUsrId;
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
	 * @param currPage
	 */
	public void setCurrPage(String currPage) {
		this.currPage = currPage;
	}
	
	/**
	 * Column Info
	 * @param srDate
	 */
	public void setSrDate(String srDate) {
		this.srDate = srDate;
	}
	
	/**
	 * Column Info
	 * @param obSlsOfcCd
	 */
	public void setObSlsOfcCd(String obSlsOfcCd) {
		this.obSlsOfcCd = obSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param bkgCustTpCd
	 */
	public void setBkgCustTpCd(String bkgCustTpCd) {
		this.bkgCustTpCd = bkgCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param xterSiCd
	 */
	public void setXterSiCd(String xterSiCd) {
		this.xterSiCd = xterSiCd;
	}
	
	/**
	 * Column Info
	 * @param messageYn
	 */
	public void setMessageYn(String messageYn) {
		this.messageYn = messageYn;
	}
	
	/**
	 * Column Info
	 * @param xterSndrId
	 */
	public void setXterSndrId(String xterSndrId) {
		this.xterSndrId = xterSndrId;
	}
	
	/**
	 * Column Info
	 * @param blDocInpFlg
	 */
	public void setBlDocInpFlg(String blDocInpFlg) {
		this.blDocInpFlg = blDocInpFlg;
	}
	
	/**
	 * Column Info
	 * @param srcCd
	 */
	public void setSrcCd(String srcCd) {
		this.srcCd = srcCd;
	}
	
	/**
	 * Column Info
	 * @param fax
	 */
	public void setFax(String fax) {
		this.fax = fax;
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
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param bkgCzDesc
	 */
	public void setBkgCzDesc(String bkgCzDesc) {
		this.bkgCzDesc = bkgCzDesc;
	}
	
	/**
	 * Column Info
	 * @param totalNormal
	 */
	public void setTotalNormal(String totalNormal) {
		this.totalNormal = totalNormal;
	}
	
	/**
	 * Column Info
	 * @param totalVip
	 */
	public void setTotalVip(String totalVip) {
		this.totalVip = totalVip;
	}
	
	/**
	 * Column Info
	 * @param dpcsWrkGrpCd
	 */
	public void setDpcsWrkGrpCd(String dpcsWrkGrpCd) {
		this.dpcsWrkGrpCd = dpcsWrkGrpCd;
	}
	
	/**
	 * Column Info
	 * @param pndUsrId
	 */
	public void setPndUsrId(String pndUsrId) {
		this.pndUsrId = pndUsrId;
	}
	
	/**
	 * Column Info
	 * @param imgFileNm
	 */
	public void setImgFileNm(String imgFileNm) {
		this.imgFileNm = imgFileNm;
	}
	
	/**
	 * Column Info
	 * @param totalSr
	 */
	public void setTotalSr(String totalSr) {
		this.totalSr = totalSr;
	}
	
	/**
	 * Column Info
	 * @param splitFlg
	 */
	public void setSplitFlg(String splitFlg) {
		this.splitFlg = splitFlg;
	}
	
	/**
	 * Column Info
	 * @param srCrntStsCd
	 */
	public void setSrCrntStsCd(String srCrntStsCd) {
		this.srCrntStsCd = srCrntStsCd;
	}
	
	/**
	 * Column Info
	 * @param pndFlg
	 */
	public void setPndFlg(String pndFlg) {
		this.pndFlg = pndFlg;
	}
	
	/**
	 * Column Info
	 * @param totalUrgent
	 */
	public void setTotalUrgent(String totalUrgent) {
		this.totalUrgent = totalUrgent;
	}
	
	/**
	 * Column Info
	 * @param bdrFlg
	 */
	public void setBdrFlg(String bdrFlg) {
		this.bdrFlg = bdrFlg;
	}
	
	/**
	 * Column Info
	 * @param rtnToRtnUsrId
	 */
	public void setRtnToRtnUsrId(String rtnToRtnUsrId) {
		this.rtnToRtnUsrId = rtnToRtnUsrId;
	}
	
	/**
	 * Column Info
	 * @param lastDate
	 */
	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}
	
	/**
	 * Column Info
	 * @param bkgUpldStsCd
	 */
	public void setBkgUpldStsCd(String bkgUpldStsCd) {
		this.bkgUpldStsCd = bkgUpldStsCd;
	}
	
	/**
	 * Column Info
	 * @param imgFilePathCtnt
	 */
	public void setImgFilePathCtnt(String imgFilePathCtnt) {
		this.imgFilePathCtnt = imgFilePathCtnt;
	}
	
	/**
	 * Column Info
	 * @param srWrkStsUsrNm
	 */
	public void setSrWrkStsUsrNm(String srWrkStsUsrNm) {
		this.srWrkStsUsrNm = srWrkStsUsrNm;
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
	 * @param vbsClssCd
	 */
	public void setVbsClssCd(String vbsClssCd) {
		this.vbsClssCd = vbsClssCd;
	}
	
	/**
	 * Column Info
	 * @param splitOnlyFlg
	 */
	public void setSplitOnlyFlg(String splitOnlyFlg) {
		this.splitOnlyFlg = splitOnlyFlg;
	}
	
	/**
	 * Column Info
	 * @param srWrkStsCd
	 */
	public void setSrWrkStsCd(String srWrkStsCd) {
		this.srWrkStsCd = srWrkStsCd;
	}
	
	/**
	 * Column Info
	 * @param srWrkStsUsrId
	 */
	public void setSrWrkStsUsrId(String srWrkStsUsrId) {
		this.srWrkStsUsrId = srWrkStsUsrId;
	}
	
	/**
	 * Column Info
	 * @param totalPct
	 */
	public void setTotalPct(String totalPct) {
		this.totalPct = totalPct;
	}
	
	/**
	 * Column Info
	 * @param faxLogRefNo
	 */
	public void setFaxLogRefNo(String faxLogRefNo) {
		this.faxLogRefNo = faxLogRefNo;
	}
	
	/**
	 * Column Info
	 * @param inpPicUsrId
	 */
	public void setInpPicUsrId(String inpPicUsrId) {
		this.inpPicUsrId = inpPicUsrId;
	}
	
	/**
	 * Column Info
	 * @param bkgCtrtTpCd
	 */
	public void setBkgCtrtTpCd(String bkgCtrtTpCd) {
		this.bkgCtrtTpCd = bkgCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @param blDrftFaxOutFlg
	 */
	public void setBlDrftFaxOutFlg(String blDrftFaxOutFlg) {
		this.blDrftFaxOutFlg = blDrftFaxOutFlg;
	}
	
	/**
	 * Column Info
	 * @param srNo
	 */
	public void setSrNo(String srNo) {
		this.srNo = srNo;
	}
	
	/**
	 * Column Info
	 * @param docCct
	 */
	public void setDocCct(String docCct) {
		this.docCct = docCct;
	}
	
	/**
	 * Column Info
	 * @param totalRtn
	 */
	public void setTotalRtn(String totalRtn) {
		this.totalRtn = totalRtn;
	}
	
	/**
	 * Column Info
	 * @param srKind
	 */
	public void setSrKind(String srKind) {
		this.srKind = srKind;
	}
	
	/**
	 * Column Info
	 * @param totalCompleted
	 */
	public void setTotalCompleted(String totalCompleted) {
		this.totalCompleted = totalCompleted;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param rtPicUsrId
	 */
	public void setRtPicUsrId(String rtPicUsrId) {
		this.rtPicUsrId = rtPicUsrId;
	}
	
	/**
	 * Column Info
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * Column Info
	 * @param returnSrc
	 */
	public void setReturnSrc(String returnSrc) {
		this.returnSrc = returnSrc;
	}
	
	/**
	 * Column Info
	 * @param delContiCd
	 */
	public void setDelContiCd(String delContiCd) {
		this.delContiCd = delContiCd;
	}
	
	/**
	 * Column Info
	 * @param bdrDate
	 */
	public void setBdrDate(String bdrDate) {
		this.bdrDate = bdrDate;
	}
	
	/**
	 * Column Info
	 * @param totalEml
	 */
	public void setTotalEml(String totalEml) {
		this.totalEml = totalEml;
	}
	
	/**
	 * Column Info
	 * @param xterRqstNo
	 */
	public void setXterRqstNo(String xterRqstNo) {
		this.xterRqstNo = xterRqstNo;
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
		setTotalWorking(JSPUtil.getParameter(request, prefix + "total_working", ""));
		setTotalQa(JSPUtil.getParameter(request, prefix + "total_qa", ""));
		setPicCngId(JSPUtil.getParameter(request, prefix + "pic_cng_id", ""));
		setImgFileRealPath(JSPUtil.getParameter(request, prefix + "img_file_real_path", ""));
		setBlRtFlg(JSPUtil.getParameter(request, prefix + "bl_rt_flg", ""));
		setTotalRate(JSPUtil.getParameter(request, prefix + "total_rate", ""));
		setPicId(JSPUtil.getParameter(request, prefix + "pic_id", ""));
		setSrKindCd(JSPUtil.getParameter(request, prefix + "sr_kind_cd", ""));
		setUrgency(JSPUtil.getParameter(request, prefix + "urgency", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setObSrepCd(JSPUtil.getParameter(request, prefix + "ob_srep_cd", ""));
		setRowsPerPage(JSPUtil.getParameter(request, prefix + "rows_per_page", ""));
		setSrCrntInfoCd(JSPUtil.getParameter(request, prefix + "sr_crnt_info_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setPndUsrNm(JSPUtil.getParameter(request, prefix + "pnd_usr_nm", ""));
		setReturnTo(JSPUtil.getParameter(request, prefix + "return_to", ""));
		setContractNo(JSPUtil.getParameter(request, prefix + "contract_no", ""));
		setBlFntOfcFlg(JSPUtil.getParameter(request, prefix + "bl_fnt_ofc_flg", ""));
		setTotalCnt(JSPUtil.getParameter(request, prefix + "total_cnt", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setTotalRtnCust(JSPUtil.getParameter(request, prefix + "total_rtn_cust", ""));
		setTotalFax(JSPUtil.getParameter(request, prefix + "total_fax", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setRtnFmUsrId(JSPUtil.getParameter(request, prefix + "rtn_fm_usr_id", ""));
		setSrStsCd(JSPUtil.getParameter(request, prefix + "sr_sts_cd", ""));
		setRtnToUsrEml(JSPUtil.getParameter(request, prefix + "rtn_to_usr_eml", ""));
		setMaxSrNo(JSPUtil.getParameter(request, prefix + "max_sr_no", ""));
		setRtnFreq(JSPUtil.getParameter(request, prefix + "rtn_freq", ""));
		setImgFileIp(JSPUtil.getParameter(request, prefix + "img_file_ip", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setQueueStatus(JSPUtil.getParameter(request, prefix + "queue_status", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setTotalRtnFo(JSPUtil.getParameter(request, prefix + "total_rtn_fo", ""));
		setRtnToUsrRemark(JSPUtil.getParameter(request, prefix + "rtn_to_usr_remark", ""));
		setTotalCutoff(JSPUtil.getParameter(request, prefix + "total_cutoff", ""));
		setVbsClssNm(JSPUtil.getParameter(request, prefix + "vbs_clss_nm", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setConsignee(JSPUtil.getParameter(request, prefix + "consignee", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setSrAmdSeq(JSPUtil.getParameter(request, prefix + "sr_amd_seq", ""));
		setReturnCd(JSPUtil.getParameter(request, prefix + "return_cd", ""));
		setTotalBdr(JSPUtil.getParameter(request, prefix + "total_bdr", ""));
		setCstmsMfTpCd(JSPUtil.getParameter(request, prefix + "cstms_mf_tp_cd", ""));
		setSrKndCd(JSPUtil.getParameter(request, prefix + "sr_knd_cd", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setSrAmdTpCd(JSPUtil.getParameter(request, prefix + "sr_amd_tp_cd", ""));
		setSrc(JSPUtil.getParameter(request, prefix + "src", ""));
		setRgnOfcCd(JSPUtil.getParameter(request, prefix + "rgn_ofc_cd", ""));
		setTotalPending(JSPUtil.getParameter(request, prefix + "total_pending", ""));
		setCrntUsrId(JSPUtil.getParameter(request, prefix + "crnt_usr_id", ""));
		setRtnToRtnStsCd(JSPUtil.getParameter(request, prefix + "rtn_to_rtn_sts_cd", ""));
		setTotalNa(JSPUtil.getParameter(request, prefix + "total_na", ""));
		setShipper(JSPUtil.getParameter(request, prefix + "shipper", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setTotalInput(JSPUtil.getParameter(request, prefix + "total_input", ""));
		setRcInpFlg(JSPUtil.getParameter(request, prefix + "rc_inp_flg", ""));
		setXterRqstSeq(JSPUtil.getParameter(request, prefix + "xter_rqst_seq", ""));
		setPctDate(JSPUtil.getParameter(request, prefix + "pct_date", ""));
		setEmlSubjCtnt(JSPUtil.getParameter(request, prefix + "eml_subj_ctnt", ""));
		setBkgStaff(JSPUtil.getParameter(request, prefix + "bkg_staff", ""));
		setBlAudFlg(JSPUtil.getParameter(request, prefix + "bl_aud_flg", ""));
		setTotalCanceled(JSPUtil.getParameter(request, prefix + "total_canceled", ""));
		setBlNoCtnt(JSPUtil.getParameter(request, prefix + "bl_no_ctnt", ""));
		setTotalBkg(JSPUtil.getParameter(request, prefix + "total_bkg", ""));
		setSplitStsCd(JSPUtil.getParameter(request, prefix + "split_sts_cd", ""));
		setSrepCd(JSPUtil.getParameter(request, prefix + "srep_cd", ""));
		setActSrAmdSeq(JSPUtil.getParameter(request, prefix + "act_sr_amd_seq", ""));
		setDocTpCd(JSPUtil.getParameter(request, prefix + "doc_tp_cd", ""));
		setRtnToUsrId(JSPUtil.getParameter(request, prefix + "rtn_to_usr_id", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setCurrPage(JSPUtil.getParameter(request, prefix + "curr_page", ""));
		setSrDate(JSPUtil.getParameter(request, prefix + "sr_date", ""));
		setObSlsOfcCd(JSPUtil.getParameter(request, prefix + "ob_sls_ofc_cd", ""));
		setBkgCustTpCd(JSPUtil.getParameter(request, prefix + "bkg_cust_tp_cd", ""));
		setXterSiCd(JSPUtil.getParameter(request, prefix + "xter_si_cd", ""));
		setMessageYn(JSPUtil.getParameter(request, prefix + "message_yn", ""));
		setXterSndrId(JSPUtil.getParameter(request, prefix + "xter_sndr_id", ""));
		setBlDocInpFlg(JSPUtil.getParameter(request, prefix + "bl_doc_inp_flg", ""));
		setSrcCd(JSPUtil.getParameter(request, prefix + "src_cd", ""));
		setFax(JSPUtil.getParameter(request, prefix + "fax", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setBkgCzDesc(JSPUtil.getParameter(request, prefix + "bkg_cz_desc", ""));
		setTotalNormal(JSPUtil.getParameter(request, prefix + "total_normal", ""));
		setTotalVip(JSPUtil.getParameter(request, prefix + "total_vip", ""));
		setDpcsWrkGrpCd(JSPUtil.getParameter(request, prefix + "dpcs_wrk_grp_cd", ""));
		setPndUsrId(JSPUtil.getParameter(request, prefix + "pnd_usr_id", ""));
		setImgFileNm(JSPUtil.getParameter(request, prefix + "img_file_nm", ""));
		setTotalSr(JSPUtil.getParameter(request, prefix + "total_sr", ""));
		setSplitFlg(JSPUtil.getParameter(request, prefix + "split_flg", ""));
		setSrCrntStsCd(JSPUtil.getParameter(request, prefix + "sr_crnt_sts_cd", ""));
		setPndFlg(JSPUtil.getParameter(request, prefix + "pnd_flg", ""));
		setTotalUrgent(JSPUtil.getParameter(request, prefix + "total_urgent", ""));
		setBdrFlg(JSPUtil.getParameter(request, prefix + "bdr_flg", ""));
		setRtnToRtnUsrId(JSPUtil.getParameter(request, prefix + "rtn_to_rtn_usr_id", ""));
		setLastDate(JSPUtil.getParameter(request, prefix + "last_date", ""));
		setBkgUpldStsCd(JSPUtil.getParameter(request, prefix + "bkg_upld_sts_cd", ""));
		setImgFilePathCtnt(JSPUtil.getParameter(request, prefix + "img_file_path_ctnt", ""));
		setSrWrkStsUsrNm(JSPUtil.getParameter(request, prefix + "sr_wrk_sts_usr_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVbsClssCd(JSPUtil.getParameter(request, prefix + "vbs_clss_cd", ""));
		setSplitOnlyFlg(JSPUtil.getParameter(request, prefix + "split_only_flg", ""));
		setSrWrkStsCd(JSPUtil.getParameter(request, prefix + "sr_wrk_sts_cd", ""));
		setSrWrkStsUsrId(JSPUtil.getParameter(request, prefix + "sr_wrk_sts_usr_id", ""));
		setTotalPct(JSPUtil.getParameter(request, prefix + "total_pct", ""));
		setFaxLogRefNo(JSPUtil.getParameter(request, prefix + "fax_log_ref_no", ""));
		setInpPicUsrId(JSPUtil.getParameter(request, prefix + "inp_pic_usr_id", ""));
		setBkgCtrtTpCd(JSPUtil.getParameter(request, prefix + "bkg_ctrt_tp_cd", ""));
		setBlDrftFaxOutFlg(JSPUtil.getParameter(request, prefix + "bl_drft_fax_out_flg", ""));
		setSrNo(JSPUtil.getParameter(request, prefix + "sr_no", ""));
		setDocCct(JSPUtil.getParameter(request, prefix + "doc_cct", ""));
		setTotalRtn(JSPUtil.getParameter(request, prefix + "total_rtn", ""));
		setSrKind(JSPUtil.getParameter(request, prefix + "sr_kind", ""));
		setTotalCompleted(JSPUtil.getParameter(request, prefix + "total_completed", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setRtPicUsrId(JSPUtil.getParameter(request, prefix + "rt_pic_usr_id", ""));
		setMessage(JSPUtil.getParameter(request, prefix + "message", ""));
		setReturnSrc(JSPUtil.getParameter(request, prefix + "return_src", ""));
		setDelContiCd(JSPUtil.getParameter(request, prefix + "del_conti_cd", ""));
		setBdrDate(JSPUtil.getParameter(request, prefix + "bdr_date", ""));
		setTotalEml(JSPUtil.getParameter(request, prefix + "total_eml", ""));
		setXterRqstNo(JSPUtil.getParameter(request, prefix + "xter_rqst_no", ""));
		setVol20(JSPUtil.getParameter(request, prefix + "vol20", ""));
		setVol40(JSPUtil.getParameter(request, prefix + "vol40", ""));
		setVgmFlg(JSPUtil.getParameter(request, prefix + "vgm_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DocQueueListOutVO[]
	 */
	public DocQueueListOutVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DocQueueListOutVO[]
	 */
	public DocQueueListOutVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DocQueueListOutVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] totalWorking = (JSPUtil.getParameter(request, prefix	+ "total_working", length));
			String[] totalQa = (JSPUtil.getParameter(request, prefix	+ "total_qa", length));
			String[] picCngId = (JSPUtil.getParameter(request, prefix	+ "pic_cng_id", length));
			String[] imgFileRealPath = (JSPUtil.getParameter(request, prefix	+ "img_file_real_path", length));
			String[] blRtFlg = (JSPUtil.getParameter(request, prefix	+ "bl_rt_flg", length));
			String[] totalRate = (JSPUtil.getParameter(request, prefix	+ "total_rate", length));
			String[] picId = (JSPUtil.getParameter(request, prefix	+ "pic_id", length));
			String[] srKindCd = (JSPUtil.getParameter(request, prefix	+ "sr_kind_cd", length));
			String[] urgency = (JSPUtil.getParameter(request, prefix	+ "urgency", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] obSrepCd = (JSPUtil.getParameter(request, prefix	+ "ob_srep_cd", length));
			String[] rowsPerPage = (JSPUtil.getParameter(request, prefix	+ "rows_per_page", length));
			String[] srCrntInfoCd = (JSPUtil.getParameter(request, prefix	+ "sr_crnt_info_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] pndUsrNm = (JSPUtil.getParameter(request, prefix	+ "pnd_usr_nm", length));
			String[] returnTo = (JSPUtil.getParameter(request, prefix	+ "return_to", length));
			String[] contractNo = (JSPUtil.getParameter(request, prefix	+ "contract_no", length));
			String[] blFntOfcFlg = (JSPUtil.getParameter(request, prefix	+ "bl_fnt_ofc_flg", length));
			String[] totalCnt = (JSPUtil.getParameter(request, prefix	+ "total_cnt", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] totalRtnCust = (JSPUtil.getParameter(request, prefix	+ "total_rtn_cust", length));
			String[] totalFax = (JSPUtil.getParameter(request, prefix	+ "total_fax", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] rtnFmUsrId = (JSPUtil.getParameter(request, prefix	+ "rtn_fm_usr_id", length));
			String[] srStsCd = (JSPUtil.getParameter(request, prefix	+ "sr_sts_cd", length));
			String[] rtnToUsrEml = (JSPUtil.getParameter(request, prefix	+ "rtn_to_usr_eml", length));
			String[] maxSrNo = (JSPUtil.getParameter(request, prefix	+ "max_sr_no", length));
			String[] rtnFreq = (JSPUtil.getParameter(request, prefix	+ "rtn_freq", length));
			String[] imgFileIp = (JSPUtil.getParameter(request, prefix	+ "img_file_ip", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] queueStatus = (JSPUtil.getParameter(request, prefix	+ "queue_status", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] totalRtnFo = (JSPUtil.getParameter(request, prefix	+ "total_rtn_fo", length));
			String[] rtnToUsrRemark = (JSPUtil.getParameter(request, prefix	+ "rtn_to_usr_remark", length));
			String[] totalCutoff = (JSPUtil.getParameter(request, prefix	+ "total_cutoff", length));
			String[] vbsClssNm = (JSPUtil.getParameter(request, prefix	+ "vbs_clss_nm", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] consignee = (JSPUtil.getParameter(request, prefix	+ "consignee", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] srAmdSeq = (JSPUtil.getParameter(request, prefix	+ "sr_amd_seq", length));
			String[] returnCd = (JSPUtil.getParameter(request, prefix	+ "return_cd", length));
			String[] totalBdr = (JSPUtil.getParameter(request, prefix	+ "total_bdr", length));
			String[] cstmsMfTpCd = (JSPUtil.getParameter(request, prefix	+ "cstms_mf_tp_cd", length));
			String[] srKndCd = (JSPUtil.getParameter(request, prefix	+ "sr_knd_cd", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] srAmdTpCd = (JSPUtil.getParameter(request, prefix	+ "sr_amd_tp_cd", length));
			String[] src = (JSPUtil.getParameter(request, prefix	+ "src", length));
			String[] rgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "rgn_ofc_cd", length));
			String[] totalPending = (JSPUtil.getParameter(request, prefix	+ "total_pending", length));
			String[] crntUsrId = (JSPUtil.getParameter(request, prefix	+ "crnt_usr_id", length));
			String[] rtnToRtnStsCd = (JSPUtil.getParameter(request, prefix	+ "rtn_to_rtn_sts_cd", length));
			String[] totalNa = (JSPUtil.getParameter(request, prefix	+ "total_na", length));
			String[] shipper = (JSPUtil.getParameter(request, prefix	+ "shipper", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] totalInput = (JSPUtil.getParameter(request, prefix	+ "total_input", length));
			String[] rcInpFlg = (JSPUtil.getParameter(request, prefix	+ "rc_inp_flg", length));
			String[] xterRqstSeq = (JSPUtil.getParameter(request, prefix	+ "xter_rqst_seq", length));
			String[] pctDate = (JSPUtil.getParameter(request, prefix	+ "pct_date", length));
			String[] emlSubjCtnt = (JSPUtil.getParameter(request, prefix	+ "eml_subj_ctnt", length));
			String[] bkgStaff = (JSPUtil.getParameter(request, prefix	+ "bkg_staff", length));
			String[] blAudFlg = (JSPUtil.getParameter(request, prefix	+ "bl_aud_flg", length));
			String[] totalCanceled = (JSPUtil.getParameter(request, prefix	+ "total_canceled", length));
			String[] blNoCtnt = (JSPUtil.getParameter(request, prefix	+ "bl_no_ctnt", length));
			String[] totalBkg = (JSPUtil.getParameter(request, prefix	+ "total_bkg", length));
			String[] splitStsCd = (JSPUtil.getParameter(request, prefix	+ "split_sts_cd", length));
			String[] srepCd = (JSPUtil.getParameter(request, prefix	+ "srep_cd", length));
			String[] actSrAmdSeq = (JSPUtil.getParameter(request, prefix	+ "act_sr_amd_seq", length));
			String[] docTpCd = (JSPUtil.getParameter(request, prefix	+ "doc_tp_cd", length));
			String[] rtnToUsrId = (JSPUtil.getParameter(request, prefix	+ "rtn_to_usr_id", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] currPage = (JSPUtil.getParameter(request, prefix	+ "curr_page", length));
			String[] srDate = (JSPUtil.getParameter(request, prefix	+ "sr_date", length));
			String[] obSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ob_sls_ofc_cd", length));
			String[] bkgCustTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cust_tp_cd", length));
			String[] xterSiCd = (JSPUtil.getParameter(request, prefix	+ "xter_si_cd", length));
			String[] messageYn = (JSPUtil.getParameter(request, prefix	+ "message_yn", length));
			String[] xterSndrId = (JSPUtil.getParameter(request, prefix	+ "xter_sndr_id", length));
			String[] blDocInpFlg = (JSPUtil.getParameter(request, prefix	+ "bl_doc_inp_flg", length));
			String[] srcCd = (JSPUtil.getParameter(request, prefix	+ "src_cd", length));
			String[] fax = (JSPUtil.getParameter(request, prefix	+ "fax", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] bkgCzDesc = (JSPUtil.getParameter(request, prefix	+ "bkg_cz_desc", length));
			String[] totalNormal = (JSPUtil.getParameter(request, prefix	+ "total_normal", length));
			String[] totalVip = (JSPUtil.getParameter(request, prefix	+ "total_vip", length));
			String[] dpcsWrkGrpCd = (JSPUtil.getParameter(request, prefix	+ "dpcs_wrk_grp_cd", length));
			String[] pndUsrId = (JSPUtil.getParameter(request, prefix	+ "pnd_usr_id", length));
			String[] imgFileNm = (JSPUtil.getParameter(request, prefix	+ "img_file_nm", length));
			String[] totalSr = (JSPUtil.getParameter(request, prefix	+ "total_sr", length));
			String[] splitFlg = (JSPUtil.getParameter(request, prefix	+ "split_flg", length));
			String[] srCrntStsCd = (JSPUtil.getParameter(request, prefix	+ "sr_crnt_sts_cd", length));
			String[] pndFlg = (JSPUtil.getParameter(request, prefix	+ "pnd_flg", length));
			String[] totalUrgent = (JSPUtil.getParameter(request, prefix	+ "total_urgent", length));
			String[] bdrFlg = (JSPUtil.getParameter(request, prefix	+ "bdr_flg", length));
			String[] rtnToRtnUsrId = (JSPUtil.getParameter(request, prefix	+ "rtn_to_rtn_usr_id", length));
			String[] lastDate = (JSPUtil.getParameter(request, prefix	+ "last_date", length));
			String[] bkgUpldStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_upld_sts_cd", length));
			String[] imgFilePathCtnt = (JSPUtil.getParameter(request, prefix	+ "img_file_path_ctnt", length));
			String[] srWrkStsUsrNm = (JSPUtil.getParameter(request, prefix	+ "sr_wrk_sts_usr_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vbsClssCd = (JSPUtil.getParameter(request, prefix	+ "vbs_clss_cd", length));
			String[] splitOnlyFlg = (JSPUtil.getParameter(request, prefix	+ "split_only_flg", length));
			String[] srWrkStsCd = (JSPUtil.getParameter(request, prefix	+ "sr_wrk_sts_cd", length));
			String[] srWrkStsUsrId = (JSPUtil.getParameter(request, prefix	+ "sr_wrk_sts_usr_id", length));
			String[] totalPct = (JSPUtil.getParameter(request, prefix	+ "total_pct", length));
			String[] faxLogRefNo = (JSPUtil.getParameter(request, prefix	+ "fax_log_ref_no", length));
			String[] inpPicUsrId = (JSPUtil.getParameter(request, prefix	+ "inp_pic_usr_id", length));
			String[] bkgCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrt_tp_cd", length));
			String[] blDrftFaxOutFlg = (JSPUtil.getParameter(request, prefix	+ "bl_drft_fax_out_flg", length));
			String[] srNo = (JSPUtil.getParameter(request, prefix	+ "sr_no", length));
			String[] docCct = (JSPUtil.getParameter(request, prefix	+ "doc_cct", length));
			String[] totalRtn = (JSPUtil.getParameter(request, prefix	+ "total_rtn", length));
			String[] srKind = (JSPUtil.getParameter(request, prefix	+ "sr_kind", length));
			String[] totalCompleted = (JSPUtil.getParameter(request, prefix	+ "total_completed", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] rtPicUsrId = (JSPUtil.getParameter(request, prefix	+ "rt_pic_usr_id", length));
			String[] message = (JSPUtil.getParameter(request, prefix	+ "message", length));
			String[] returnSrc = (JSPUtil.getParameter(request, prefix	+ "return_src", length));
			String[] delContiCd = (JSPUtil.getParameter(request, prefix	+ "del_conti_cd", length));
			String[] bdrDate = (JSPUtil.getParameter(request, prefix	+ "bdr_date", length));
			String[] totalEml = (JSPUtil.getParameter(request, prefix	+ "total_eml", length));
			String[] xterRqstNo = (JSPUtil.getParameter(request, prefix	+ "xter_rqst_no", length));
			String[] vol20 = (JSPUtil.getParameter(request, prefix	+ "vol20", length));
			String[] vol40 = (JSPUtil.getParameter(request, prefix	+ "vol40", length));
			String[] vgmFlg = (JSPUtil.getParameter(request, prefix	+ "vgm_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new DocQueueListOutVO();
				if (totalWorking[i] != null)
					model.setTotalWorking(totalWorking[i]);
				if (totalQa[i] != null)
					model.setTotalQa(totalQa[i]);
				if (picCngId[i] != null)
					model.setPicCngId(picCngId[i]);
				if (imgFileRealPath[i] != null)
					model.setImgFileRealPath(imgFileRealPath[i]);
				if (blRtFlg[i] != null)
					model.setBlRtFlg(blRtFlg[i]);
				if (totalRate[i] != null)
					model.setTotalRate(totalRate[i]);
				if (picId[i] != null)
					model.setPicId(picId[i]);
				if (srKindCd[i] != null)
					model.setSrKindCd(srKindCd[i]);
				if (urgency[i] != null)
					model.setUrgency(urgency[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (obSrepCd[i] != null)
					model.setObSrepCd(obSrepCd[i]);
				if (rowsPerPage[i] != null)
					model.setRowsPerPage(rowsPerPage[i]);
				if (srCrntInfoCd[i] != null)
					model.setSrCrntInfoCd(srCrntInfoCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (pndUsrNm[i] != null)
					model.setPndUsrNm(pndUsrNm[i]);
				if (returnTo[i] != null)
					model.setReturnTo(returnTo[i]);
				if (contractNo[i] != null)
					model.setContractNo(contractNo[i]);
				if (blFntOfcFlg[i] != null)
					model.setBlFntOfcFlg(blFntOfcFlg[i]);
				if (totalCnt[i] != null)
					model.setTotalCnt(totalCnt[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (totalRtnCust[i] != null)
					model.setTotalRtnCust(totalRtnCust[i]);
				if (totalFax[i] != null)
					model.setTotalFax(totalFax[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (rtnFmUsrId[i] != null)
					model.setRtnFmUsrId(rtnFmUsrId[i]);
				if (srStsCd[i] != null)
					model.setSrStsCd(srStsCd[i]);
				if (rtnToUsrEml[i] != null)
					model.setRtnToUsrEml(rtnToUsrEml[i]);
				if (maxSrNo[i] != null)
					model.setMaxSrNo(maxSrNo[i]);
				if (rtnFreq[i] != null)
					model.setRtnFreq(rtnFreq[i]);
				if (imgFileIp[i] != null)
					model.setImgFileIp(imgFileIp[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (queueStatus[i] != null)
					model.setQueueStatus(queueStatus[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (totalRtnFo[i] != null)
					model.setTotalRtnFo(totalRtnFo[i]);
				if (rtnToUsrRemark[i] != null)
					model.setRtnToUsrRemark(rtnToUsrRemark[i]);
				if (totalCutoff[i] != null)
					model.setTotalCutoff(totalCutoff[i]);
				if (vbsClssNm[i] != null)
					model.setVbsClssNm(vbsClssNm[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (consignee[i] != null)
					model.setConsignee(consignee[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (srAmdSeq[i] != null)
					model.setSrAmdSeq(srAmdSeq[i]);
				if (returnCd[i] != null)
					model.setReturnCd(returnCd[i]);
				if (totalBdr[i] != null)
					model.setTotalBdr(totalBdr[i]);
				if (cstmsMfTpCd[i] != null)
					model.setCstmsMfTpCd(cstmsMfTpCd[i]);
				if (srKndCd[i] != null)
					model.setSrKndCd(srKndCd[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (srAmdTpCd[i] != null)
					model.setSrAmdTpCd(srAmdTpCd[i]);
				if (src[i] != null)
					model.setSrc(src[i]);
				if (rgnOfcCd[i] != null)
					model.setRgnOfcCd(rgnOfcCd[i]);
				if (totalPending[i] != null)
					model.setTotalPending(totalPending[i]);
				if (crntUsrId[i] != null)
					model.setCrntUsrId(crntUsrId[i]);
				if (rtnToRtnStsCd[i] != null)
					model.setRtnToRtnStsCd(rtnToRtnStsCd[i]);
				if (totalNa[i] != null)
					model.setTotalNa(totalNa[i]);
				if (shipper[i] != null)
					model.setShipper(shipper[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (totalInput[i] != null)
					model.setTotalInput(totalInput[i]);
				if (rcInpFlg[i] != null)
					model.setRcInpFlg(rcInpFlg[i]);
				if (xterRqstSeq[i] != null)
					model.setXterRqstSeq(xterRqstSeq[i]);
				if (pctDate[i] != null)
					model.setPctDate(pctDate[i]);
				if (emlSubjCtnt[i] != null)
					model.setEmlSubjCtnt(emlSubjCtnt[i]);
				if (bkgStaff[i] != null)
					model.setBkgStaff(bkgStaff[i]);
				if (blAudFlg[i] != null)
					model.setBlAudFlg(blAudFlg[i]);
				if (totalCanceled[i] != null)
					model.setTotalCanceled(totalCanceled[i]);
				if (blNoCtnt[i] != null)
					model.setBlNoCtnt(blNoCtnt[i]);
				if (totalBkg[i] != null)
					model.setTotalBkg(totalBkg[i]);
				if (splitStsCd[i] != null)
					model.setSplitStsCd(splitStsCd[i]);
				if (srepCd[i] != null)
					model.setSrepCd(srepCd[i]);
				if (actSrAmdSeq[i] != null)
					model.setActSrAmdSeq(actSrAmdSeq[i]);
				if (docTpCd[i] != null)
					model.setDocTpCd(docTpCd[i]);
				if (rtnToUsrId[i] != null)
					model.setRtnToUsrId(rtnToUsrId[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (currPage[i] != null)
					model.setCurrPage(currPage[i]);
				if (srDate[i] != null)
					model.setSrDate(srDate[i]);
				if (obSlsOfcCd[i] != null)
					model.setObSlsOfcCd(obSlsOfcCd[i]);
				if (bkgCustTpCd[i] != null)
					model.setBkgCustTpCd(bkgCustTpCd[i]);
				if (xterSiCd[i] != null)
					model.setXterSiCd(xterSiCd[i]);
				if (messageYn[i] != null)
					model.setMessageYn(messageYn[i]);
				if (xterSndrId[i] != null)
					model.setXterSndrId(xterSndrId[i]);
				if (blDocInpFlg[i] != null)
					model.setBlDocInpFlg(blDocInpFlg[i]);
				if (srcCd[i] != null)
					model.setSrcCd(srcCd[i]);
				if (fax[i] != null)
					model.setFax(fax[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (bkgCzDesc[i] != null)
					model.setBkgCzDesc(bkgCzDesc[i]);
				if (totalNormal[i] != null)
					model.setTotalNormal(totalNormal[i]);
				if (totalVip[i] != null)
					model.setTotalVip(totalVip[i]);
				if (dpcsWrkGrpCd[i] != null)
					model.setDpcsWrkGrpCd(dpcsWrkGrpCd[i]);
				if (pndUsrId[i] != null)
					model.setPndUsrId(pndUsrId[i]);
				if (imgFileNm[i] != null)
					model.setImgFileNm(imgFileNm[i]);
				if (totalSr[i] != null)
					model.setTotalSr(totalSr[i]);
				if (splitFlg[i] != null)
					model.setSplitFlg(splitFlg[i]);
				if (srCrntStsCd[i] != null)
					model.setSrCrntStsCd(srCrntStsCd[i]);
				if (pndFlg[i] != null)
					model.setPndFlg(pndFlg[i]);
				if (totalUrgent[i] != null)
					model.setTotalUrgent(totalUrgent[i]);
				if (bdrFlg[i] != null)
					model.setBdrFlg(bdrFlg[i]);
				if (rtnToRtnUsrId[i] != null)
					model.setRtnToRtnUsrId(rtnToRtnUsrId[i]);
				if (lastDate[i] != null)
					model.setLastDate(lastDate[i]);
				if (bkgUpldStsCd[i] != null)
					model.setBkgUpldStsCd(bkgUpldStsCd[i]);
				if (imgFilePathCtnt[i] != null)
					model.setImgFilePathCtnt(imgFilePathCtnt[i]);
				if (srWrkStsUsrNm[i] != null)
					model.setSrWrkStsUsrNm(srWrkStsUsrNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vbsClssCd[i] != null)
					model.setVbsClssCd(vbsClssCd[i]);
				if (splitOnlyFlg[i] != null)
					model.setSplitOnlyFlg(splitOnlyFlg[i]);
				if (srWrkStsCd[i] != null)
					model.setSrWrkStsCd(srWrkStsCd[i]);
				if (srWrkStsUsrId[i] != null)
					model.setSrWrkStsUsrId(srWrkStsUsrId[i]);
				if (totalPct[i] != null)
					model.setTotalPct(totalPct[i]);
				if (faxLogRefNo[i] != null)
					model.setFaxLogRefNo(faxLogRefNo[i]);
				if (inpPicUsrId[i] != null)
					model.setInpPicUsrId(inpPicUsrId[i]);
				if (bkgCtrtTpCd[i] != null)
					model.setBkgCtrtTpCd(bkgCtrtTpCd[i]);
				if (blDrftFaxOutFlg[i] != null)
					model.setBlDrftFaxOutFlg(blDrftFaxOutFlg[i]);
				if (srNo[i] != null)
					model.setSrNo(srNo[i]);
				if (docCct[i] != null)
					model.setDocCct(docCct[i]);
				if (totalRtn[i] != null)
					model.setTotalRtn(totalRtn[i]);
				if (srKind[i] != null)
					model.setSrKind(srKind[i]);
				if (totalCompleted[i] != null)
					model.setTotalCompleted(totalCompleted[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (rtPicUsrId[i] != null)
					model.setRtPicUsrId(rtPicUsrId[i]);
				if (message[i] != null)
					model.setMessage(message[i]);
				if (returnSrc[i] != null)
					model.setReturnSrc(returnSrc[i]);
				if (delContiCd[i] != null)
					model.setDelContiCd(delContiCd[i]);
				if (bdrDate[i] != null)
					model.setBdrDate(bdrDate[i]);
				if (totalEml[i] != null)
					model.setTotalEml(totalEml[i]);
				if (xterRqstNo[i] != null)
					model.setXterRqstNo(xterRqstNo[i]);
				if (vol20[i] != null) model.setVol20(vol20[i]);
				if (vol40[i] != null) model.setVol40(vol40[i]);
				if (vgmFlg[i] != null) model.setVgmFlg(vgmFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDocQueueListOutVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DocQueueListOutVO[]
	 */
	public DocQueueListOutVO[] getDocQueueListOutVOs(){
		DocQueueListOutVO[] vos = (DocQueueListOutVO[])models.toArray(new DocQueueListOutVO[models.size()]);
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
		this.totalWorking = this.totalWorking .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalQa = this.totalQa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.picCngId = this.picCngId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imgFileRealPath = this.imgFileRealPath .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blRtFlg = this.blRtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalRate = this.totalRate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.picId = this.picId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srKindCd = this.srKindCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.urgency = this.urgency .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSrepCd = this.obSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowsPerPage = this.rowsPerPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srCrntInfoCd = this.srCrntInfoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pndUsrNm = this.pndUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.returnTo = this.returnTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contractNo = this.contractNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blFntOfcFlg = this.blFntOfcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalCnt = this.totalCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalRtnCust = this.totalRtnCust .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalFax = this.totalFax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnFmUsrId = this.rtnFmUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srStsCd = this.srStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnToUsrEml = this.rtnToUsrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxSrNo = this.maxSrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnFreq = this.rtnFreq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imgFileIp = this.imgFileIp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.queueStatus = this.queueStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalRtnFo = this.totalRtnFo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnToUsrRemark = this.rtnToUsrRemark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalCutoff = this.totalCutoff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vbsClssNm = this.vbsClssNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consignee = this.consignee .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srAmdSeq = this.srAmdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.returnCd = this.returnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalBdr = this.totalBdr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsMfTpCd = this.cstmsMfTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srKndCd = this.srKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srAmdTpCd = this.srAmdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.src = this.src .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnOfcCd = this.rgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalPending = this.totalPending .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntUsrId = this.crntUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnToRtnStsCd = this.rtnToRtnStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalNa = this.totalNa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipper = this.shipper .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalInput = this.totalInput .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcInpFlg = this.rcInpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRqstSeq = this.xterRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctDate = this.pctDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSubjCtnt = this.emlSubjCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStaff = this.bkgStaff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blAudFlg = this.blAudFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalCanceled = this.totalCanceled .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNoCtnt = this.blNoCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalBkg = this.totalBkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splitStsCd = this.splitStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCd = this.srepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actSrAmdSeq = this.actSrAmdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docTpCd = this.docTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnToUsrId = this.rtnToUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currPage = this.currPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srDate = this.srDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSlsOfcCd = this.obSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustTpCd = this.bkgCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterSiCd = this.xterSiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.messageYn = this.messageYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterSndrId = this.xterSndrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blDocInpFlg = this.blDocInpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcCd = this.srcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fax = this.fax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCzDesc = this.bkgCzDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalNormal = this.totalNormal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalVip = this.totalVip .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpcsWrkGrpCd = this.dpcsWrkGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pndUsrId = this.pndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imgFileNm = this.imgFileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalSr = this.totalSr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splitFlg = this.splitFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srCrntStsCd = this.srCrntStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pndFlg = this.pndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalUrgent = this.totalUrgent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrFlg = this.bdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnToRtnUsrId = this.rtnToRtnUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastDate = this.lastDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgUpldStsCd = this.bkgUpldStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imgFilePathCtnt = this.imgFilePathCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srWrkStsUsrNm = this.srWrkStsUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vbsClssCd = this.vbsClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splitOnlyFlg = this.splitOnlyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srWrkStsCd = this.srWrkStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srWrkStsUsrId = this.srWrkStsUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalPct = this.totalPct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxLogRefNo = this.faxLogRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpPicUsrId = this.inpPicUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrtTpCd = this.bkgCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blDrftFaxOutFlg = this.blDrftFaxOutFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srNo = this.srNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docCct = this.docCct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalRtn = this.totalRtn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srKind = this.srKind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalCompleted = this.totalCompleted .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtPicUsrId = this.rtPicUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.message = this.message .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.returnSrc = this.returnSrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delContiCd = this.delContiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrDate = this.bdrDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalEml = this.totalEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRqstNo = this.xterRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vol20 = this.vol20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vol40 = this.vol40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmFlg = this.vgmFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
