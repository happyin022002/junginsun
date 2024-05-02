/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DocQueueListOutVO.java
*@FileTitle : DocQueueListOutVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.30
*@LastModifier : 이일민
*@LastVersion : 1.0
* 2009.12.30 이일민 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo;

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
 * @author 이일민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DocQueueListOutVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DocQueueListOutVO> models = new ArrayList<DocQueueListOutVO>();
	
	/* Column Info */
	private String blAudFlg = null;
	/* Column Info */
	private String totalWorking = null;
	/* Column Info */
	private String totalQa = null;
	/* Column Info */
	private String totalCanceled = null;
	/* Column Info */
	private String totalBkg = null;
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
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String urgency = null;
	/* Column Info */
	private String rtnToUsrId = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String srCrntInfoCd = null;
	/* Column Info */
	private String rowsPerPage = null;
	/* Column Info */
	private String currPage = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String returnTo = null;
	/* Column Info */
	private String srDate = null;
	/* Column Info */
	private String totalCnt = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String totalFax = null;
	/* Column Info */
	private String messageYn = null;
	/* Column Info */
	private String srcCd = null;
	/* Column Info */
	private String rtnFmUsrId = null;
	/* Column Info */
	private String blDocInpFlg = null;
	/* Column Info */
	private String fax = null;
	/* Column Info */
	private String srStsCd = null;
	/* Column Info */
	private String maxSrNo = null;
	/* Column Info */
	private String totalNormal = null;
	/* Column Info */
	private String totalVip = null;
	/* Column Info */
	private String dpcsWrkGrpCd = null;
	/* Column Info */
	private String imgFileIp = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String queueStatus = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String imgFileNm = null;
	/* Column Info */
	private String totalSr = null;
	/* Column Info */
	private String pndFlg = null;
	/* Column Info */
	private String srCrntStsCd = null;
	/* Column Info */
	private String totalUrgent = null;
	/* Column Info */
	private String bdrFlg = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String rtnToRtnUsrId = null;
	/* Column Info */
	private String lastDate = null;
	/* Column Info */
	private String returnCd = null;
	/* Column Info */
	private String totalBdr = null;
	/* Column Info */
	private String imgFilePathCtnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String srWrkStsCd = null;
	/* Column Info */
	private String srWrkStsUsrId = null;
	/* Column Info */
	private String totalPct = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String src = null;
	/* Column Info */
	private String srNo = null;
	/* Column Info */
	private String totalPending = null;
	/* Column Info */
	private String blDrftFaxOutFlg = null;
	/* Column Info */
	private String crntUsrId = null;
	/* Column Info */
	private String rtnToRtnStsCd = null;
	/* Column Info */
	private String totalNa = null;
	/* Column Info */
	private String shipper = null;
	/* Column Info */
	private String srKind = null;
	/* Column Info */
	private String totalCompleted = null;
	/* Column Info */
	private String message = null;
	/* Column Info */
	private String totalInput = null;
	/* Column Info */
	private String returnSrc = null;
	/* Column Info */
	private String bdrDate = null;
	/* Column Info */
	private String pctDate = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DocQueueListOutVO() {}

	public DocQueueListOutVO(String ibflag, String pagerows, String usrId, String dpcsWrkGrpCd, String returnCd, String srKind, String src, String totalBdr, String totalUrgent, String totalVip, String totalBkg, String urgency, String srKindCd, String returnSrc, String srcCd, String bkgNo, String shipper, String vvdCd, String polCd, String podCd, String pctDate, String bdrDate, String srDate, String lastDate, String queueStatus, String fax, String messageYn, String message, String bdrFlg, String srCrntInfoCd, String maxSrNo, String crntUsrId, String imgFileIp, String imgFilePathCtnt, String imgFileNm, String bkgStsCd, String rtnFmUsrId, String rtnToUsrId, String rtnToRtnUsrId, String rtnToRtnStsCd, String srStsCd, String pndFlg, String srCrntStsCd, String picId, String totalCnt, String rowsPerPage, String currPage, String returnTo, String blDocInpFlg, String blRtFlg, String blAudFlg, String blDrftFaxOutFlg, String srWrkStsCd, String srWrkStsUsrId, String totalInput, String totalRate, String totalQa, String totalFax, String totalPending, String totalWorking, String totalCanceled, String totalCompleted, String totalNa, String totalPct, String imgFileRealPath, String bkgOfcCd, String srNo, String totalSr, String totalNormal) {
		this.blAudFlg = blAudFlg;
		this.totalWorking = totalWorking;
		this.totalQa = totalQa;
		this.totalCanceled = totalCanceled;
		this.totalBkg = totalBkg;
		this.imgFileRealPath = imgFileRealPath;
		this.blRtFlg = blRtFlg;
		this.totalRate = totalRate;
		this.picId = picId;
		this.srKindCd = srKindCd;
		this.pagerows = pagerows;
		this.urgency = urgency;
		this.rtnToUsrId = rtnToUsrId;
		this.polCd = polCd;
		this.srCrntInfoCd = srCrntInfoCd;
		this.rowsPerPage = rowsPerPage;
		this.currPage = currPage;
		this.vvdCd = vvdCd;
		this.returnTo = returnTo;
		this.srDate = srDate;
		this.totalCnt = totalCnt;
		this.bkgOfcCd = bkgOfcCd;
		this.totalFax = totalFax;
		this.messageYn = messageYn;
		this.srcCd = srcCd;
		this.rtnFmUsrId = rtnFmUsrId;
		this.blDocInpFlg = blDocInpFlg;
		this.fax = fax;
		this.srStsCd = srStsCd;
		this.maxSrNo = maxSrNo;
		this.totalNormal = totalNormal;
		this.totalVip = totalVip;
		this.dpcsWrkGrpCd = dpcsWrkGrpCd;
		this.imgFileIp = imgFileIp;
		this.podCd = podCd;
		this.queueStatus = queueStatus;
		this.bkgNo = bkgNo;
		this.imgFileNm = imgFileNm;
		this.totalSr = totalSr;
		this.pndFlg = pndFlg;
		this.srCrntStsCd = srCrntStsCd;
		this.totalUrgent = totalUrgent;
		this.bdrFlg = bdrFlg;
		this.bkgStsCd = bkgStsCd;
		this.rtnToRtnUsrId = rtnToRtnUsrId;
		this.lastDate = lastDate;
		this.returnCd = returnCd;
		this.totalBdr = totalBdr;
		this.imgFilePathCtnt = imgFilePathCtnt;
		this.ibflag = ibflag;
		this.srWrkStsCd = srWrkStsCd;
		this.srWrkStsUsrId = srWrkStsUsrId;
		this.totalPct = totalPct;
		this.usrId = usrId;
		this.src = src;
		this.srNo = srNo;
		this.totalPending = totalPending;
		this.blDrftFaxOutFlg = blDrftFaxOutFlg;
		this.crntUsrId = crntUsrId;
		this.rtnToRtnStsCd = rtnToRtnStsCd;
		this.totalNa = totalNa;
		this.shipper = shipper;
		this.srKind = srKind;
		this.totalCompleted = totalCompleted;
		this.message = message;
		this.totalInput = totalInput;
		this.returnSrc = returnSrc;
		this.bdrDate = bdrDate;
		this.pctDate = pctDate;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bl_aud_flg", getBlAudFlg());
		this.hashColumns.put("total_working", getTotalWorking());
		this.hashColumns.put("total_qa", getTotalQa());
		this.hashColumns.put("total_canceled", getTotalCanceled());
		this.hashColumns.put("total_bkg", getTotalBkg());
		this.hashColumns.put("img_file_real_path", getImgFileRealPath());
		this.hashColumns.put("bl_rt_flg", getBlRtFlg());
		this.hashColumns.put("total_rate", getTotalRate());
		this.hashColumns.put("pic_id", getPicId());
		this.hashColumns.put("sr_kind_cd", getSrKindCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("urgency", getUrgency());
		this.hashColumns.put("rtn_to_usr_id", getRtnToUsrId());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("sr_crnt_info_cd", getSrCrntInfoCd());
		this.hashColumns.put("rows_per_page", getRowsPerPage());
		this.hashColumns.put("curr_page", getCurrPage());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("return_to", getReturnTo());
		this.hashColumns.put("sr_date", getSrDate());
		this.hashColumns.put("total_cnt", getTotalCnt());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("total_fax", getTotalFax());
		this.hashColumns.put("message_yn", getMessageYn());
		this.hashColumns.put("src_cd", getSrcCd());
		this.hashColumns.put("rtn_fm_usr_id", getRtnFmUsrId());
		this.hashColumns.put("bl_doc_inp_flg", getBlDocInpFlg());
		this.hashColumns.put("fax", getFax());
		this.hashColumns.put("sr_sts_cd", getSrStsCd());
		this.hashColumns.put("max_sr_no", getMaxSrNo());
		this.hashColumns.put("total_normal", getTotalNormal());
		this.hashColumns.put("total_vip", getTotalVip());
		this.hashColumns.put("dpcs_wrk_grp_cd", getDpcsWrkGrpCd());
		this.hashColumns.put("img_file_ip", getImgFileIp());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("queue_status", getQueueStatus());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("img_file_nm", getImgFileNm());
		this.hashColumns.put("total_sr", getTotalSr());
		this.hashColumns.put("pnd_flg", getPndFlg());
		this.hashColumns.put("sr_crnt_sts_cd", getSrCrntStsCd());
		this.hashColumns.put("total_urgent", getTotalUrgent());
		this.hashColumns.put("bdr_flg", getBdrFlg());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("rtn_to_rtn_usr_id", getRtnToRtnUsrId());
		this.hashColumns.put("last_date", getLastDate());
		this.hashColumns.put("return_cd", getReturnCd());
		this.hashColumns.put("total_bdr", getTotalBdr());
		this.hashColumns.put("img_file_path_ctnt", getImgFilePathCtnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sr_wrk_sts_cd", getSrWrkStsCd());
		this.hashColumns.put("sr_wrk_sts_usr_id", getSrWrkStsUsrId());
		this.hashColumns.put("total_pct", getTotalPct());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("src", getSrc());
		this.hashColumns.put("sr_no", getSrNo());
		this.hashColumns.put("total_pending", getTotalPending());
		this.hashColumns.put("bl_drft_fax_out_flg", getBlDrftFaxOutFlg());
		this.hashColumns.put("crnt_usr_id", getCrntUsrId());
		this.hashColumns.put("rtn_to_rtn_sts_cd", getRtnToRtnStsCd());
		this.hashColumns.put("total_na", getTotalNa());
		this.hashColumns.put("shipper", getShipper());
		this.hashColumns.put("sr_kind", getSrKind());
		this.hashColumns.put("total_completed", getTotalCompleted());
		this.hashColumns.put("message", getMessage());
		this.hashColumns.put("total_input", getTotalInput());
		this.hashColumns.put("return_src", getReturnSrc());
		this.hashColumns.put("bdr_date", getBdrDate());
		this.hashColumns.put("pct_date", getPctDate());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bl_aud_flg", "blAudFlg");
		this.hashFields.put("total_working", "totalWorking");
		this.hashFields.put("total_qa", "totalQa");
		this.hashFields.put("total_canceled", "totalCanceled");
		this.hashFields.put("total_bkg", "totalBkg");
		this.hashFields.put("img_file_real_path", "imgFileRealPath");
		this.hashFields.put("bl_rt_flg", "blRtFlg");
		this.hashFields.put("total_rate", "totalRate");
		this.hashFields.put("pic_id", "picId");
		this.hashFields.put("sr_kind_cd", "srKindCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("urgency", "urgency");
		this.hashFields.put("rtn_to_usr_id", "rtnToUsrId");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("sr_crnt_info_cd", "srCrntInfoCd");
		this.hashFields.put("rows_per_page", "rowsPerPage");
		this.hashFields.put("curr_page", "currPage");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("return_to", "returnTo");
		this.hashFields.put("sr_date", "srDate");
		this.hashFields.put("total_cnt", "totalCnt");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("total_fax", "totalFax");
		this.hashFields.put("message_yn", "messageYn");
		this.hashFields.put("src_cd", "srcCd");
		this.hashFields.put("rtn_fm_usr_id", "rtnFmUsrId");
		this.hashFields.put("bl_doc_inp_flg", "blDocInpFlg");
		this.hashFields.put("fax", "fax");
		this.hashFields.put("sr_sts_cd", "srStsCd");
		this.hashFields.put("max_sr_no", "maxSrNo");
		this.hashFields.put("total_normal", "totalNormal");
		this.hashFields.put("total_vip", "totalVip");
		this.hashFields.put("dpcs_wrk_grp_cd", "dpcsWrkGrpCd");
		this.hashFields.put("img_file_ip", "imgFileIp");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("queue_status", "queueStatus");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("img_file_nm", "imgFileNm");
		this.hashFields.put("total_sr", "totalSr");
		this.hashFields.put("pnd_flg", "pndFlg");
		this.hashFields.put("sr_crnt_sts_cd", "srCrntStsCd");
		this.hashFields.put("total_urgent", "totalUrgent");
		this.hashFields.put("bdr_flg", "bdrFlg");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("rtn_to_rtn_usr_id", "rtnToRtnUsrId");
		this.hashFields.put("last_date", "lastDate");
		this.hashFields.put("return_cd", "returnCd");
		this.hashFields.put("total_bdr", "totalBdr");
		this.hashFields.put("img_file_path_ctnt", "imgFilePathCtnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sr_wrk_sts_cd", "srWrkStsCd");
		this.hashFields.put("sr_wrk_sts_usr_id", "srWrkStsUsrId");
		this.hashFields.put("total_pct", "totalPct");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("src", "src");
		this.hashFields.put("sr_no", "srNo");
		this.hashFields.put("total_pending", "totalPending");
		this.hashFields.put("bl_drft_fax_out_flg", "blDrftFaxOutFlg");
		this.hashFields.put("crnt_usr_id", "crntUsrId");
		this.hashFields.put("rtn_to_rtn_sts_cd", "rtnToRtnStsCd");
		this.hashFields.put("total_na", "totalNa");
		this.hashFields.put("shipper", "shipper");
		this.hashFields.put("sr_kind", "srKind");
		this.hashFields.put("total_completed", "totalCompleted");
		this.hashFields.put("message", "message");
		this.hashFields.put("total_input", "totalInput");
		this.hashFields.put("return_src", "returnSrc");
		this.hashFields.put("bdr_date", "bdrDate");
		this.hashFields.put("pct_date", "pctDate");
		return this.hashFields;
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
	 * @return totalCanceled
	 */
	public String getTotalCanceled() {
		return this.totalCanceled;
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
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return urgency
	 */
	public String getUrgency() {
		return this.urgency;
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
	 * @return srCrntInfoCd
	 */
	public String getSrCrntInfoCd() {
		return this.srCrntInfoCd;
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
	 * @return currPage
	 */
	public String getCurrPage() {
		return this.currPage;
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
	 * @return returnTo
	 */
	public String getReturnTo() {
		return this.returnTo;
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
	 * @return totalCnt
	 */
	public String getTotalCnt() {
		return this.totalCnt;
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
	 * @return totalFax
	 */
	public String getTotalFax() {
		return this.totalFax;
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
	 * @return srcCd
	 */
	public String getSrcCd() {
		return this.srcCd;
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
	 * @return blDocInpFlg
	 */
	public String getBlDocInpFlg() {
		return this.blDocInpFlg;
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
	 * @return srStsCd
	 */
	public String getSrStsCd() {
		return this.srStsCd;
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
	 * @return pndFlg
	 */
	public String getPndFlg() {
		return this.pndFlg;
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
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
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
	 * @return imgFilePathCtnt
	 */
	public String getImgFilePathCtnt() {
		return this.imgFilePathCtnt;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
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
	 * @return srNo
	 */
	public String getSrNo() {
		return this.srNo;
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
	 * @return blDrftFaxOutFlg
	 */
	public String getBlDrftFaxOutFlg() {
		return this.blDrftFaxOutFlg;
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
	 * @return message
	 */
	public String getMessage() {
		return this.message;
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
	 * @return returnSrc
	 */
	public String getReturnSrc() {
		return this.returnSrc;
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
	 * @return pctDate
	 */
	public String getPctDate() {
		return this.pctDate;
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
	 * @param totalCanceled
	 */
	public void setTotalCanceled(String totalCanceled) {
		this.totalCanceled = totalCanceled;
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
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param urgency
	 */
	public void setUrgency(String urgency) {
		this.urgency = urgency;
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
	 * @param srCrntInfoCd
	 */
	public void setSrCrntInfoCd(String srCrntInfoCd) {
		this.srCrntInfoCd = srCrntInfoCd;
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
	 * @param currPage
	 */
	public void setCurrPage(String currPage) {
		this.currPage = currPage;
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
	 * @param returnTo
	 */
	public void setReturnTo(String returnTo) {
		this.returnTo = returnTo;
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
	 * @param totalCnt
	 */
	public void setTotalCnt(String totalCnt) {
		this.totalCnt = totalCnt;
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
	 * @param totalFax
	 */
	public void setTotalFax(String totalFax) {
		this.totalFax = totalFax;
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
	 * @param srcCd
	 */
	public void setSrcCd(String srcCd) {
		this.srcCd = srcCd;
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
	 * @param blDocInpFlg
	 */
	public void setBlDocInpFlg(String blDocInpFlg) {
		this.blDocInpFlg = blDocInpFlg;
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
	 * @param srStsCd
	 */
	public void setSrStsCd(String srStsCd) {
		this.srStsCd = srStsCd;
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
	 * @param pndFlg
	 */
	public void setPndFlg(String pndFlg) {
		this.pndFlg = pndFlg;
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
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
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
	 * @param imgFilePathCtnt
	 */
	public void setImgFilePathCtnt(String imgFilePathCtnt) {
		this.imgFilePathCtnt = imgFilePathCtnt;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
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
	 * @param srNo
	 */
	public void setSrNo(String srNo) {
		this.srNo = srNo;
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
	 * @param blDrftFaxOutFlg
	 */
	public void setBlDrftFaxOutFlg(String blDrftFaxOutFlg) {
		this.blDrftFaxOutFlg = blDrftFaxOutFlg;
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
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
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
	 * @param returnSrc
	 */
	public void setReturnSrc(String returnSrc) {
		this.returnSrc = returnSrc;
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
	 * @param pctDate
	 */
	public void setPctDate(String pctDate) {
		this.pctDate = pctDate;
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
		setBlAudFlg(JSPUtil.getParameter(request, prefix + "bl_aud_flg", ""));
		setTotalWorking(JSPUtil.getParameter(request, prefix + "total_working", ""));
		setTotalQa(JSPUtil.getParameter(request, prefix + "total_qa", ""));
		setTotalCanceled(JSPUtil.getParameter(request, prefix + "total_canceled", ""));
		setTotalBkg(JSPUtil.getParameter(request, prefix + "total_bkg", ""));
		setImgFileRealPath(JSPUtil.getParameter(request, prefix + "img_file_real_path", ""));
		setBlRtFlg(JSPUtil.getParameter(request, prefix + "bl_rt_flg", ""));
		setTotalRate(JSPUtil.getParameter(request, prefix + "total_rate", ""));
		setPicId(JSPUtil.getParameter(request, prefix + "pic_id", ""));
		setSrKindCd(JSPUtil.getParameter(request, prefix + "sr_kind_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setUrgency(JSPUtil.getParameter(request, prefix + "urgency", ""));
		setRtnToUsrId(JSPUtil.getParameter(request, prefix + "rtn_to_usr_id", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setSrCrntInfoCd(JSPUtil.getParameter(request, prefix + "sr_crnt_info_cd", ""));
		setRowsPerPage(JSPUtil.getParameter(request, prefix + "rows_per_page", ""));
		setCurrPage(JSPUtil.getParameter(request, prefix + "curr_page", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setReturnTo(JSPUtil.getParameter(request, prefix + "return_to", ""));
		setSrDate(JSPUtil.getParameter(request, prefix + "sr_date", ""));
		setTotalCnt(JSPUtil.getParameter(request, prefix + "total_cnt", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setTotalFax(JSPUtil.getParameter(request, prefix + "total_fax", ""));
		setMessageYn(JSPUtil.getParameter(request, prefix + "message_yn", ""));
		setSrcCd(JSPUtil.getParameter(request, prefix + "src_cd", ""));
		setRtnFmUsrId(JSPUtil.getParameter(request, prefix + "rtn_fm_usr_id", ""));
		setBlDocInpFlg(JSPUtil.getParameter(request, prefix + "bl_doc_inp_flg", ""));
		setFax(JSPUtil.getParameter(request, prefix + "fax", ""));
		setSrStsCd(JSPUtil.getParameter(request, prefix + "sr_sts_cd", ""));
		setMaxSrNo(JSPUtil.getParameter(request, prefix + "max_sr_no", ""));
		setTotalNormal(JSPUtil.getParameter(request, prefix + "total_normal", ""));
		setTotalVip(JSPUtil.getParameter(request, prefix + "total_vip", ""));
		setDpcsWrkGrpCd(JSPUtil.getParameter(request, prefix + "dpcs_wrk_grp_cd", ""));
		setImgFileIp(JSPUtil.getParameter(request, prefix + "img_file_ip", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setQueueStatus(JSPUtil.getParameter(request, prefix + "queue_status", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setImgFileNm(JSPUtil.getParameter(request, prefix + "img_file_nm", ""));
		setTotalSr(JSPUtil.getParameter(request, prefix + "total_sr", ""));
		setPndFlg(JSPUtil.getParameter(request, prefix + "pnd_flg", ""));
		setSrCrntStsCd(JSPUtil.getParameter(request, prefix + "sr_crnt_sts_cd", ""));
		setTotalUrgent(JSPUtil.getParameter(request, prefix + "total_urgent", ""));
		setBdrFlg(JSPUtil.getParameter(request, prefix + "bdr_flg", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setRtnToRtnUsrId(JSPUtil.getParameter(request, prefix + "rtn_to_rtn_usr_id", ""));
		setLastDate(JSPUtil.getParameter(request, prefix + "last_date", ""));
		setReturnCd(JSPUtil.getParameter(request, prefix + "return_cd", ""));
		setTotalBdr(JSPUtil.getParameter(request, prefix + "total_bdr", ""));
		setImgFilePathCtnt(JSPUtil.getParameter(request, prefix + "img_file_path_ctnt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSrWrkStsCd(JSPUtil.getParameter(request, prefix + "sr_wrk_sts_cd", ""));
		setSrWrkStsUsrId(JSPUtil.getParameter(request, prefix + "sr_wrk_sts_usr_id", ""));
		setTotalPct(JSPUtil.getParameter(request, prefix + "total_pct", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setSrc(JSPUtil.getParameter(request, prefix + "src", ""));
		setSrNo(JSPUtil.getParameter(request, prefix + "sr_no", ""));
		setTotalPending(JSPUtil.getParameter(request, prefix + "total_pending", ""));
		setBlDrftFaxOutFlg(JSPUtil.getParameter(request, prefix + "bl_drft_fax_out_flg", ""));
		setCrntUsrId(JSPUtil.getParameter(request, prefix + "crnt_usr_id", ""));
		setRtnToRtnStsCd(JSPUtil.getParameter(request, prefix + "rtn_to_rtn_sts_cd", ""));
		setTotalNa(JSPUtil.getParameter(request, prefix + "total_na", ""));
		setShipper(JSPUtil.getParameter(request, prefix + "shipper", ""));
		setSrKind(JSPUtil.getParameter(request, prefix + "sr_kind", ""));
		setTotalCompleted(JSPUtil.getParameter(request, prefix + "total_completed", ""));
		setMessage(JSPUtil.getParameter(request, prefix + "message", ""));
		setTotalInput(JSPUtil.getParameter(request, prefix + "total_input", ""));
		setReturnSrc(JSPUtil.getParameter(request, prefix + "return_src", ""));
		setBdrDate(JSPUtil.getParameter(request, prefix + "bdr_date", ""));
		setPctDate(JSPUtil.getParameter(request, prefix + "pct_date", ""));
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
			String[] blAudFlg = (JSPUtil.getParameter(request, prefix	+ "bl_aud_flg", length));
			String[] totalWorking = (JSPUtil.getParameter(request, prefix	+ "total_working", length));
			String[] totalQa = (JSPUtil.getParameter(request, prefix	+ "total_qa", length));
			String[] totalCanceled = (JSPUtil.getParameter(request, prefix	+ "total_canceled", length));
			String[] totalBkg = (JSPUtil.getParameter(request, prefix	+ "total_bkg", length));
			String[] imgFileRealPath = (JSPUtil.getParameter(request, prefix	+ "img_file_real_path", length));
			String[] blRtFlg = (JSPUtil.getParameter(request, prefix	+ "bl_rt_flg", length));
			String[] totalRate = (JSPUtil.getParameter(request, prefix	+ "total_rate", length));
			String[] picId = (JSPUtil.getParameter(request, prefix	+ "pic_id", length));
			String[] srKindCd = (JSPUtil.getParameter(request, prefix	+ "sr_kind_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] urgency = (JSPUtil.getParameter(request, prefix	+ "urgency", length));
			String[] rtnToUsrId = (JSPUtil.getParameter(request, prefix	+ "rtn_to_usr_id", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] srCrntInfoCd = (JSPUtil.getParameter(request, prefix	+ "sr_crnt_info_cd", length));
			String[] rowsPerPage = (JSPUtil.getParameter(request, prefix	+ "rows_per_page", length));
			String[] currPage = (JSPUtil.getParameter(request, prefix	+ "curr_page", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] returnTo = (JSPUtil.getParameter(request, prefix	+ "return_to", length));
			String[] srDate = (JSPUtil.getParameter(request, prefix	+ "sr_date", length));
			String[] totalCnt = (JSPUtil.getParameter(request, prefix	+ "total_cnt", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] totalFax = (JSPUtil.getParameter(request, prefix	+ "total_fax", length));
			String[] messageYn = (JSPUtil.getParameter(request, prefix	+ "message_yn", length));
			String[] srcCd = (JSPUtil.getParameter(request, prefix	+ "src_cd", length));
			String[] rtnFmUsrId = (JSPUtil.getParameter(request, prefix	+ "rtn_fm_usr_id", length));
			String[] blDocInpFlg = (JSPUtil.getParameter(request, prefix	+ "bl_doc_inp_flg", length));
			String[] fax = (JSPUtil.getParameter(request, prefix	+ "fax", length));
			String[] srStsCd = (JSPUtil.getParameter(request, prefix	+ "sr_sts_cd", length));
			String[] maxSrNo = (JSPUtil.getParameter(request, prefix	+ "max_sr_no", length));
			String[] totalNormal = (JSPUtil.getParameter(request, prefix	+ "total_normal", length));
			String[] totalVip = (JSPUtil.getParameter(request, prefix	+ "total_vip", length));
			String[] dpcsWrkGrpCd = (JSPUtil.getParameter(request, prefix	+ "dpcs_wrk_grp_cd", length));
			String[] imgFileIp = (JSPUtil.getParameter(request, prefix	+ "img_file_ip", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] queueStatus = (JSPUtil.getParameter(request, prefix	+ "queue_status", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] imgFileNm = (JSPUtil.getParameter(request, prefix	+ "img_file_nm", length));
			String[] totalSr = (JSPUtil.getParameter(request, prefix	+ "total_sr", length));
			String[] pndFlg = (JSPUtil.getParameter(request, prefix	+ "pnd_flg", length));
			String[] srCrntStsCd = (JSPUtil.getParameter(request, prefix	+ "sr_crnt_sts_cd", length));
			String[] totalUrgent = (JSPUtil.getParameter(request, prefix	+ "total_urgent", length));
			String[] bdrFlg = (JSPUtil.getParameter(request, prefix	+ "bdr_flg", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] rtnToRtnUsrId = (JSPUtil.getParameter(request, prefix	+ "rtn_to_rtn_usr_id", length));
			String[] lastDate = (JSPUtil.getParameter(request, prefix	+ "last_date", length));
			String[] returnCd = (JSPUtil.getParameter(request, prefix	+ "return_cd", length));
			String[] totalBdr = (JSPUtil.getParameter(request, prefix	+ "total_bdr", length));
			String[] imgFilePathCtnt = (JSPUtil.getParameter(request, prefix	+ "img_file_path_ctnt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] srWrkStsCd = (JSPUtil.getParameter(request, prefix	+ "sr_wrk_sts_cd", length));
			String[] srWrkStsUsrId = (JSPUtil.getParameter(request, prefix	+ "sr_wrk_sts_usr_id", length));
			String[] totalPct = (JSPUtil.getParameter(request, prefix	+ "total_pct", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] src = (JSPUtil.getParameter(request, prefix	+ "src", length));
			String[] srNo = (JSPUtil.getParameter(request, prefix	+ "sr_no", length));
			String[] totalPending = (JSPUtil.getParameter(request, prefix	+ "total_pending", length));
			String[] blDrftFaxOutFlg = (JSPUtil.getParameter(request, prefix	+ "bl_drft_fax_out_flg", length));
			String[] crntUsrId = (JSPUtil.getParameter(request, prefix	+ "crnt_usr_id", length));
			String[] rtnToRtnStsCd = (JSPUtil.getParameter(request, prefix	+ "rtn_to_rtn_sts_cd", length));
			String[] totalNa = (JSPUtil.getParameter(request, prefix	+ "total_na", length));
			String[] shipper = (JSPUtil.getParameter(request, prefix	+ "shipper", length));
			String[] srKind = (JSPUtil.getParameter(request, prefix	+ "sr_kind", length));
			String[] totalCompleted = (JSPUtil.getParameter(request, prefix	+ "total_completed", length));
			String[] message = (JSPUtil.getParameter(request, prefix	+ "message", length));
			String[] totalInput = (JSPUtil.getParameter(request, prefix	+ "total_input", length));
			String[] returnSrc = (JSPUtil.getParameter(request, prefix	+ "return_src", length));
			String[] bdrDate = (JSPUtil.getParameter(request, prefix	+ "bdr_date", length));
			String[] pctDate = (JSPUtil.getParameter(request, prefix	+ "pct_date", length));
			
			for (int i = 0; i < length; i++) {
				model = new DocQueueListOutVO();
				if (blAudFlg[i] != null)
					model.setBlAudFlg(blAudFlg[i]);
				if (totalWorking[i] != null)
					model.setTotalWorking(totalWorking[i]);
				if (totalQa[i] != null)
					model.setTotalQa(totalQa[i]);
				if (totalCanceled[i] != null)
					model.setTotalCanceled(totalCanceled[i]);
				if (totalBkg[i] != null)
					model.setTotalBkg(totalBkg[i]);
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
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (urgency[i] != null)
					model.setUrgency(urgency[i]);
				if (rtnToUsrId[i] != null)
					model.setRtnToUsrId(rtnToUsrId[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (srCrntInfoCd[i] != null)
					model.setSrCrntInfoCd(srCrntInfoCd[i]);
				if (rowsPerPage[i] != null)
					model.setRowsPerPage(rowsPerPage[i]);
				if (currPage[i] != null)
					model.setCurrPage(currPage[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (returnTo[i] != null)
					model.setReturnTo(returnTo[i]);
				if (srDate[i] != null)
					model.setSrDate(srDate[i]);
				if (totalCnt[i] != null)
					model.setTotalCnt(totalCnt[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (totalFax[i] != null)
					model.setTotalFax(totalFax[i]);
				if (messageYn[i] != null)
					model.setMessageYn(messageYn[i]);
				if (srcCd[i] != null)
					model.setSrcCd(srcCd[i]);
				if (rtnFmUsrId[i] != null)
					model.setRtnFmUsrId(rtnFmUsrId[i]);
				if (blDocInpFlg[i] != null)
					model.setBlDocInpFlg(blDocInpFlg[i]);
				if (fax[i] != null)
					model.setFax(fax[i]);
				if (srStsCd[i] != null)
					model.setSrStsCd(srStsCd[i]);
				if (maxSrNo[i] != null)
					model.setMaxSrNo(maxSrNo[i]);
				if (totalNormal[i] != null)
					model.setTotalNormal(totalNormal[i]);
				if (totalVip[i] != null)
					model.setTotalVip(totalVip[i]);
				if (dpcsWrkGrpCd[i] != null)
					model.setDpcsWrkGrpCd(dpcsWrkGrpCd[i]);
				if (imgFileIp[i] != null)
					model.setImgFileIp(imgFileIp[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (queueStatus[i] != null)
					model.setQueueStatus(queueStatus[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (imgFileNm[i] != null)
					model.setImgFileNm(imgFileNm[i]);
				if (totalSr[i] != null)
					model.setTotalSr(totalSr[i]);
				if (pndFlg[i] != null)
					model.setPndFlg(pndFlg[i]);
				if (srCrntStsCd[i] != null)
					model.setSrCrntStsCd(srCrntStsCd[i]);
				if (totalUrgent[i] != null)
					model.setTotalUrgent(totalUrgent[i]);
				if (bdrFlg[i] != null)
					model.setBdrFlg(bdrFlg[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (rtnToRtnUsrId[i] != null)
					model.setRtnToRtnUsrId(rtnToRtnUsrId[i]);
				if (lastDate[i] != null)
					model.setLastDate(lastDate[i]);
				if (returnCd[i] != null)
					model.setReturnCd(returnCd[i]);
				if (totalBdr[i] != null)
					model.setTotalBdr(totalBdr[i]);
				if (imgFilePathCtnt[i] != null)
					model.setImgFilePathCtnt(imgFilePathCtnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (srWrkStsCd[i] != null)
					model.setSrWrkStsCd(srWrkStsCd[i]);
				if (srWrkStsUsrId[i] != null)
					model.setSrWrkStsUsrId(srWrkStsUsrId[i]);
				if (totalPct[i] != null)
					model.setTotalPct(totalPct[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (src[i] != null)
					model.setSrc(src[i]);
				if (srNo[i] != null)
					model.setSrNo(srNo[i]);
				if (totalPending[i] != null)
					model.setTotalPending(totalPending[i]);
				if (blDrftFaxOutFlg[i] != null)
					model.setBlDrftFaxOutFlg(blDrftFaxOutFlg[i]);
				if (crntUsrId[i] != null)
					model.setCrntUsrId(crntUsrId[i]);
				if (rtnToRtnStsCd[i] != null)
					model.setRtnToRtnStsCd(rtnToRtnStsCd[i]);
				if (totalNa[i] != null)
					model.setTotalNa(totalNa[i]);
				if (shipper[i] != null)
					model.setShipper(shipper[i]);
				if (srKind[i] != null)
					model.setSrKind(srKind[i]);
				if (totalCompleted[i] != null)
					model.setTotalCompleted(totalCompleted[i]);
				if (message[i] != null)
					model.setMessage(message[i]);
				if (totalInput[i] != null)
					model.setTotalInput(totalInput[i]);
				if (returnSrc[i] != null)
					model.setReturnSrc(returnSrc[i]);
				if (bdrDate[i] != null)
					model.setBdrDate(bdrDate[i]);
				if (pctDate[i] != null)
					model.setPctDate(pctDate[i]);
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
		this.blAudFlg = this.blAudFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalWorking = this.totalWorking .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalQa = this.totalQa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalCanceled = this.totalCanceled .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalBkg = this.totalBkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imgFileRealPath = this.imgFileRealPath .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blRtFlg = this.blRtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalRate = this.totalRate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.picId = this.picId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srKindCd = this.srKindCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.urgency = this.urgency .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnToUsrId = this.rtnToUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srCrntInfoCd = this.srCrntInfoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowsPerPage = this.rowsPerPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currPage = this.currPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.returnTo = this.returnTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srDate = this.srDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalCnt = this.totalCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalFax = this.totalFax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.messageYn = this.messageYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcCd = this.srcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnFmUsrId = this.rtnFmUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blDocInpFlg = this.blDocInpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fax = this.fax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srStsCd = this.srStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxSrNo = this.maxSrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalNormal = this.totalNormal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalVip = this.totalVip .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpcsWrkGrpCd = this.dpcsWrkGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imgFileIp = this.imgFileIp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.queueStatus = this.queueStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imgFileNm = this.imgFileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalSr = this.totalSr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pndFlg = this.pndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srCrntStsCd = this.srCrntStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalUrgent = this.totalUrgent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrFlg = this.bdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnToRtnUsrId = this.rtnToRtnUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastDate = this.lastDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.returnCd = this.returnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalBdr = this.totalBdr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imgFilePathCtnt = this.imgFilePathCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srWrkStsCd = this.srWrkStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srWrkStsUsrId = this.srWrkStsUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalPct = this.totalPct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.src = this.src .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srNo = this.srNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalPending = this.totalPending .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blDrftFaxOutFlg = this.blDrftFaxOutFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntUsrId = this.crntUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnToRtnStsCd = this.rtnToRtnStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalNa = this.totalNa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipper = this.shipper .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srKind = this.srKind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalCompleted = this.totalCompleted .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.message = this.message .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalInput = this.totalInput .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.returnSrc = this.returnSrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrDate = this.bdrDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctDate = this.pctDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
