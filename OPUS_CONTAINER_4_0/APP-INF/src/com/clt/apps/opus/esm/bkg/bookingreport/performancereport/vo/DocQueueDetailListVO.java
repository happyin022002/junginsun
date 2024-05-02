/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DocQueueDetailListVO.java
*@FileTitle : DocQueueDetailListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.12
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2010.04.12 김기종 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo;

import java.lang.reflect.Field;
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
 * @author 김기종
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DocQueueDetailListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DocQueueDetailListVO> models = new ArrayList<DocQueueDetailListVO>();
	
	/* Column Info */
	private String blAudFlg = null;
	/* Column Info */
	private String picOfcCd = null;
	/* Column Info */
	private String gmtDt = null;
	/* Column Info */
	private String comFlg = null;
	/* Column Info */
	private String imgFileRealPath = null;
	/* Column Info */
	private String blRtFlg = null;
	/* Column Info */
	private String messageAll = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String urgency = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String srCrntInfoCd = null;
	/* Column Info */
	private String rowsPerPage = null;
	/* Column Info */
	private String shipperSeq = null;
	/* Column Info */
	private String currPage = null;
	/* Column Info */
	private String shipperNm = null;
	/* Column Info */
	private String page = null;
	/* Column Info */
	private String urgencyCd = null;
	/* Column Info */
	private String shipperCntCd = null;
	/* Column Info */
	private String totalCnt = null;
	/* Column Info */
	private String srcCd = null;
	/* Column Info */
	private String blDocInpFlg = null;
	/* Column Info */
	private String srStsCd = null;
	/* Column Info */
	private String upDt = null;
	/* Column Info */
	private String wrkGrpCd = null;
	/* Column Info */
	private String maxSrNo = null;
	/* Column Info */
	private String picNm = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String imgFileNm = null;
	/* Column Info */
	private String pndFlg = null;
	/* Column Info */
	private String srSts = null;
	/* Column Info */
	private String returnCd = null;
	/* Column Info */
	private String imgFilePathCtnt = null;
	/* Column Info */
	private String srKndCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String srWrkStsCd = null;
	/* Column Info */
	private String srWrkStsUsrId = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String pSrKindCd = null;
	/* Column Info */
	private String srNo = null;
	/* Column Info */
	private String blDrftFaxOutFlg = null;
	/* Column Info */
	private String srKind = null;
	/* Column Info */
	private String pic = null;
	/* Column Info */
	private String srHisSeq = null;
	/* Column Info */
	private String message = null;
	/* Column Info */
	private String source = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String xterRqstSeq = null;
	/* Column Info */
	private String xterRqstNo = null;
	/* Column Info */
	private String sel = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DocQueueDetailListVO() {}

	public DocQueueDetailListVO(String ibflag, String pagerows, String bkgNo, String pSrKindCd, String srKind, String urgencyCd, String urgency, String source, String vvd, String srNo, String polCd, String podCd, String page, String shipperCntCd, String shipperSeq, String shipperNm, String seq, String srSts, String srStsCd, String returnCd, String upDt, String gmtDt, String pic, String message, String messageAll, String pndFlg, String usrId, String usrNm, String wrkGrpCd, String srcCd, String srCrntInfoCd, String picNm, String picOfcCd, String totalCnt, String rowsPerPage, String currPage, String blDocInpFlg, String blRtFlg, String blAudFlg, String blDrftFaxOutFlg, String comFlg, String maxSrNo, String xterRqstNo, String xterRqstSeq, String srWrkStsCd, String srWrkStsUsrId, String imgFileNm, String imgFilePathCtnt, String imgFileRealPath, String srHisSeq, String sel, String srKndCd) {
		this.blAudFlg = blAudFlg;
		this.picOfcCd = picOfcCd;
		this.gmtDt = gmtDt;
		this.comFlg = comFlg;
		this.imgFileRealPath = imgFileRealPath;
		this.blRtFlg = blRtFlg;
		this.messageAll = messageAll;
		this.pagerows = pagerows;
		this.urgency = urgency;
		this.polCd = polCd;
		this.srCrntInfoCd = srCrntInfoCd;
		this.rowsPerPage = rowsPerPage;
		this.shipperSeq = shipperSeq;
		this.currPage = currPage;
		this.shipperNm = shipperNm;
		this.page = page;
		this.urgencyCd = urgencyCd;
		this.shipperCntCd = shipperCntCd;
		this.totalCnt = totalCnt;
		this.srcCd = srcCd;
		this.blDocInpFlg = blDocInpFlg;
		this.srStsCd = srStsCd;
		this.upDt = upDt;
		this.wrkGrpCd = wrkGrpCd;
		this.maxSrNo = maxSrNo;
		this.picNm = picNm;
		this.vvd = vvd;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.imgFileNm = imgFileNm;
		this.pndFlg = pndFlg;
		this.srSts = srSts;
		this.returnCd = returnCd;
		this.imgFilePathCtnt = imgFilePathCtnt;
		this.srKndCd = srKndCd;
		this.ibflag = ibflag;
		this.srWrkStsCd = srWrkStsCd;
		this.srWrkStsUsrId = srWrkStsUsrId;
		this.usrId = usrId;
		this.usrNm = usrNm;
		this.pSrKindCd = pSrKindCd;
		this.srNo = srNo;
		this.blDrftFaxOutFlg = blDrftFaxOutFlg;
		this.srKind = srKind;
		this.pic = pic;
		this.srHisSeq = srHisSeq;
		this.message = message;
		this.source = source;
		this.seq = seq;
		this.xterRqstSeq = xterRqstSeq;
		this.xterRqstNo = xterRqstNo;
		this.sel = sel;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bl_aud_flg", getBlAudFlg());
		this.hashColumns.put("pic_ofc_cd", getPicOfcCd());
		this.hashColumns.put("gmt_dt", getGmtDt());
		this.hashColumns.put("com_flg", getComFlg());
		this.hashColumns.put("img_file_real_path", getImgFileRealPath());
		this.hashColumns.put("bl_rt_flg", getBlRtFlg());
		this.hashColumns.put("message_all", getMessageAll());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("urgency", getUrgency());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("sr_crnt_info_cd", getSrCrntInfoCd());
		this.hashColumns.put("rows_per_page", getRowsPerPage());
		this.hashColumns.put("shipper_seq", getShipperSeq());
		this.hashColumns.put("curr_page", getCurrPage());
		this.hashColumns.put("shipper_nm", getShipperNm());
		this.hashColumns.put("page", getPage());
		this.hashColumns.put("urgency_cd", getUrgencyCd());
		this.hashColumns.put("shipper_cnt_cd", getShipperCntCd());
		this.hashColumns.put("total_cnt", getTotalCnt());
		this.hashColumns.put("src_cd", getSrcCd());
		this.hashColumns.put("bl_doc_inp_flg", getBlDocInpFlg());
		this.hashColumns.put("sr_sts_cd", getSrStsCd());
		this.hashColumns.put("up_dt", getUpDt());
		this.hashColumns.put("wrk_grp_cd", getWrkGrpCd());
		this.hashColumns.put("max_sr_no", getMaxSrNo());
		this.hashColumns.put("pic_nm", getPicNm());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("img_file_nm", getImgFileNm());
		this.hashColumns.put("pnd_flg", getPndFlg());
		this.hashColumns.put("sr_sts", getSrSts());
		this.hashColumns.put("return_cd", getReturnCd());
		this.hashColumns.put("img_file_path_ctnt", getImgFilePathCtnt());
		this.hashColumns.put("sr_knd_cd", getSrKndCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sr_wrk_sts_cd", getSrWrkStsCd());
		this.hashColumns.put("sr_wrk_sts_usr_id", getSrWrkStsUsrId());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("p_sr_kind_cd", getPSrKindCd());
		this.hashColumns.put("sr_no", getSrNo());
		this.hashColumns.put("bl_drft_fax_out_flg", getBlDrftFaxOutFlg());
		this.hashColumns.put("sr_kind", getSrKind());
		this.hashColumns.put("pic", getPic());
		this.hashColumns.put("sr_his_seq", getSrHisSeq());
		this.hashColumns.put("message", getMessage());
		this.hashColumns.put("source", getSource());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("xter_rqst_seq", getXterRqstSeq());
		this.hashColumns.put("xter_rqst_no", getXterRqstNo());
		this.hashColumns.put("sel", getSel());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bl_aud_flg", "blAudFlg");
		this.hashFields.put("pic_ofc_cd", "picOfcCd");
		this.hashFields.put("gmt_dt", "gmtDt");
		this.hashFields.put("com_flg", "comFlg");
		this.hashFields.put("img_file_real_path", "imgFileRealPath");
		this.hashFields.put("bl_rt_flg", "blRtFlg");
		this.hashFields.put("message_all", "messageAll");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("urgency", "urgency");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("sr_crnt_info_cd", "srCrntInfoCd");
		this.hashFields.put("rows_per_page", "rowsPerPage");
		this.hashFields.put("shipper_seq", "shipperSeq");
		this.hashFields.put("curr_page", "currPage");
		this.hashFields.put("shipper_nm", "shipperNm");
		this.hashFields.put("page", "page");
		this.hashFields.put("urgency_cd", "urgencyCd");
		this.hashFields.put("shipper_cnt_cd", "shipperCntCd");
		this.hashFields.put("total_cnt", "totalCnt");
		this.hashFields.put("src_cd", "srcCd");
		this.hashFields.put("bl_doc_inp_flg", "blDocInpFlg");
		this.hashFields.put("sr_sts_cd", "srStsCd");
		this.hashFields.put("up_dt", "upDt");
		this.hashFields.put("wrk_grp_cd", "wrkGrpCd");
		this.hashFields.put("max_sr_no", "maxSrNo");
		this.hashFields.put("pic_nm", "picNm");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("img_file_nm", "imgFileNm");
		this.hashFields.put("pnd_flg", "pndFlg");
		this.hashFields.put("sr_sts", "srSts");
		this.hashFields.put("return_cd", "returnCd");
		this.hashFields.put("img_file_path_ctnt", "imgFilePathCtnt");
		this.hashFields.put("sr_knd_cd", "srKndCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sr_wrk_sts_cd", "srWrkStsCd");
		this.hashFields.put("sr_wrk_sts_usr_id", "srWrkStsUsrId");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("p_sr_kind_cd", "pSrKindCd");
		this.hashFields.put("sr_no", "srNo");
		this.hashFields.put("bl_drft_fax_out_flg", "blDrftFaxOutFlg");
		this.hashFields.put("sr_kind", "srKind");
		this.hashFields.put("pic", "pic");
		this.hashFields.put("sr_his_seq", "srHisSeq");
		this.hashFields.put("message", "message");
		this.hashFields.put("source", "source");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("xter_rqst_seq", "xterRqstSeq");
		this.hashFields.put("xter_rqst_no", "xterRqstNo");
		this.hashFields.put("sel", "sel");
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
	 * @return picOfcCd
	 */
	public String getPicOfcCd() {
		return this.picOfcCd;
	}
	
	/**
	 * Column Info
	 * @return gmtDt
	 */
	public String getGmtDt() {
		return this.gmtDt;
	}
	
	/**
	 * Column Info
	 * @return comFlg
	 */
	public String getComFlg() {
		return this.comFlg;
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
	 * @return messageAll
	 */
	public String getMessageAll() {
		return this.messageAll;
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
	 * @return shipperSeq
	 */
	public String getShipperSeq() {
		return this.shipperSeq;
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
	 * @return shipperNm
	 */
	public String getShipperNm() {
		return this.shipperNm;
	}
	
	/**
	 * Column Info
	 * @return page
	 */
	public String getPage() {
		return this.page;
	}
	
	/**
	 * Column Info
	 * @return urgencyCd
	 */
	public String getUrgencyCd() {
		return this.urgencyCd;
	}
	
	/**
	 * Column Info
	 * @return shipperCntCd
	 */
	public String getShipperCntCd() {
		return this.shipperCntCd;
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
	 * @return srcCd
	 */
	public String getSrcCd() {
		return this.srcCd;
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
	 * @return srStsCd
	 */
	public String getSrStsCd() {
		return this.srStsCd;
	}
	
	/**
	 * Column Info
	 * @return upDt
	 */
	public String getUpDt() {
		return this.upDt;
	}
	
	/**
	 * Column Info
	 * @return wrkGrpCd
	 */
	public String getWrkGrpCd() {
		return this.wrkGrpCd;
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
	 * @return picNm
	 */
	public String getPicNm() {
		return this.picNm;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return pndFlg
	 */
	public String getPndFlg() {
		return this.pndFlg;
	}
	
	/**
	 * Column Info
	 * @return srSts
	 */
	public String getSrSts() {
		return this.srSts;
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
	 * @return imgFilePathCtnt
	 */
	public String getImgFilePathCtnt() {
		return this.imgFilePathCtnt;
	}
	
	/**
	 * Column Info
	 * @return srKndCd
	 */
	public String getSrKndCd() {
		return this.srKndCd;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
	}
	
	/**
	 * Column Info
	 * @return pSrKindCd
	 */
	public String getPSrKindCd() {
		return this.pSrKindCd;
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
	 * @return blDrftFaxOutFlg
	 */
	public String getBlDrftFaxOutFlg() {
		return this.blDrftFaxOutFlg;
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
	 * @return pic
	 */
	public String getPic() {
		return this.pic;
	}
	
	/**
	 * Column Info
	 * @return srHisSeq
	 */
	public String getSrHisSeq() {
		return this.srHisSeq;
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
	 * @return source
	 */
	public String getSource() {
		return this.source;
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
	 * @return xterRqstSeq
	 */
	public String getXterRqstSeq() {
		return this.xterRqstSeq;
	}
	
	/**
	 * Column Info
	 * @return xterRqstNo
	 */
	public String getXterRqstNo() {
		return this.xterRqstNo;
	}
	
	/**
	 * Column Info
	 * @return sel
	 */
	public String getSel() {
		return this.sel;
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
	 * @param picOfcCd
	 */
	public void setPicOfcCd(String picOfcCd) {
		this.picOfcCd = picOfcCd;
	}
	
	/**
	 * Column Info
	 * @param gmtDt
	 */
	public void setGmtDt(String gmtDt) {
		this.gmtDt = gmtDt;
	}
	
	/**
	 * Column Info
	 * @param comFlg
	 */
	public void setComFlg(String comFlg) {
		this.comFlg = comFlg;
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
	 * @param messageAll
	 */
	public void setMessageAll(String messageAll) {
		this.messageAll = messageAll;
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
	 * @param shipperSeq
	 */
	public void setShipperSeq(String shipperSeq) {
		this.shipperSeq = shipperSeq;
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
	 * @param shipperNm
	 */
	public void setShipperNm(String shipperNm) {
		this.shipperNm = shipperNm;
	}
	
	/**
	 * Column Info
	 * @param page
	 */
	public void setPage(String page) {
		this.page = page;
	}
	
	/**
	 * Column Info
	 * @param urgencyCd
	 */
	public void setUrgencyCd(String urgencyCd) {
		this.urgencyCd = urgencyCd;
	}
	
	/**
	 * Column Info
	 * @param shipperCntCd
	 */
	public void setShipperCntCd(String shipperCntCd) {
		this.shipperCntCd = shipperCntCd;
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
	 * @param srcCd
	 */
	public void setSrcCd(String srcCd) {
		this.srcCd = srcCd;
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
	 * @param srStsCd
	 */
	public void setSrStsCd(String srStsCd) {
		this.srStsCd = srStsCd;
	}
	
	/**
	 * Column Info
	 * @param upDt
	 */
	public void setUpDt(String upDt) {
		this.upDt = upDt;
	}
	
	/**
	 * Column Info
	 * @param wrkGrpCd
	 */
	public void setWrkGrpCd(String wrkGrpCd) {
		this.wrkGrpCd = wrkGrpCd;
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
	 * @param picNm
	 */
	public void setPicNm(String picNm) {
		this.picNm = picNm;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param pndFlg
	 */
	public void setPndFlg(String pndFlg) {
		this.pndFlg = pndFlg;
	}
	
	/**
	 * Column Info
	 * @param srSts
	 */
	public void setSrSts(String srSts) {
		this.srSts = srSts;
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
	 * @param imgFilePathCtnt
	 */
	public void setImgFilePathCtnt(String imgFilePathCtnt) {
		this.imgFilePathCtnt = imgFilePathCtnt;
	}
	
	/**
	 * Column Info
	 * @param srKndCd
	 */
	public void setSrKndCd(String srKndCd) {
		this.srKndCd = srKndCd;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	
	/**
	 * Column Info
	 * @param pSrKindCd
	 */
	public void setPSrKindCd(String pSrKindCd) {
		this.pSrKindCd = pSrKindCd;
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
	 * @param blDrftFaxOutFlg
	 */
	public void setBlDrftFaxOutFlg(String blDrftFaxOutFlg) {
		this.blDrftFaxOutFlg = blDrftFaxOutFlg;
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
	 * @param pic
	 */
	public void setPic(String pic) {
		this.pic = pic;
	}
	
	/**
	 * Column Info
	 * @param srHisSeq
	 */
	public void setSrHisSeq(String srHisSeq) {
		this.srHisSeq = srHisSeq;
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
	 * @param source
	 */
	public void setSource(String source) {
		this.source = source;
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
	 * @param xterRqstSeq
	 */
	public void setXterRqstSeq(String xterRqstSeq) {
		this.xterRqstSeq = xterRqstSeq;
	}
	
	/**
	 * Column Info
	 * @param xterRqstNo
	 */
	public void setXterRqstNo(String xterRqstNo) {
		this.xterRqstNo = xterRqstNo;
	}
	
	/**
	 * Column Info
	 * @param sel
	 */
	public void setSel(String sel) {
		this.sel = sel;
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
		setPicOfcCd(JSPUtil.getParameter(request, prefix + "pic_ofc_cd", ""));
		setGmtDt(JSPUtil.getParameter(request, prefix + "gmt_dt", ""));
		setComFlg(JSPUtil.getParameter(request, prefix + "com_flg", ""));
		setImgFileRealPath(JSPUtil.getParameter(request, prefix + "img_file_real_path", ""));
		setBlRtFlg(JSPUtil.getParameter(request, prefix + "bl_rt_flg", ""));
		setMessageAll(JSPUtil.getParameter(request, prefix + "message_all", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setUrgency(JSPUtil.getParameter(request, prefix + "urgency", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setSrCrntInfoCd(JSPUtil.getParameter(request, prefix + "sr_crnt_info_cd", ""));
		setRowsPerPage(JSPUtil.getParameter(request, prefix + "rows_per_page", ""));
		setShipperSeq(JSPUtil.getParameter(request, prefix + "shipper_seq", ""));
		setCurrPage(JSPUtil.getParameter(request, prefix + "curr_page", ""));
		setShipperNm(JSPUtil.getParameter(request, prefix + "shipper_nm", ""));
		setPage(JSPUtil.getParameter(request, prefix + "page", ""));
		setUrgencyCd(JSPUtil.getParameter(request, prefix + "urgency_cd", ""));
		setShipperCntCd(JSPUtil.getParameter(request, prefix + "shipper_cnt_cd", ""));
		setTotalCnt(JSPUtil.getParameter(request, prefix + "total_cnt", ""));
		setSrcCd(JSPUtil.getParameter(request, prefix + "src_cd", ""));
		setBlDocInpFlg(JSPUtil.getParameter(request, prefix + "bl_doc_inp_flg", ""));
		setSrStsCd(JSPUtil.getParameter(request, prefix + "sr_sts_cd", ""));
		setUpDt(JSPUtil.getParameter(request, prefix + "up_dt", ""));
		setWrkGrpCd(JSPUtil.getParameter(request, prefix + "wrk_grp_cd", ""));
		setMaxSrNo(JSPUtil.getParameter(request, prefix + "max_sr_no", ""));
		setPicNm(JSPUtil.getParameter(request, prefix + "pic_nm", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setImgFileNm(JSPUtil.getParameter(request, prefix + "img_file_nm", ""));
		setPndFlg(JSPUtil.getParameter(request, prefix + "pnd_flg", ""));
		setSrSts(JSPUtil.getParameter(request, prefix + "sr_sts", ""));
		setReturnCd(JSPUtil.getParameter(request, prefix + "return_cd", ""));
		setImgFilePathCtnt(JSPUtil.getParameter(request, prefix + "img_file_path_ctnt", ""));
		setSrKndCd(JSPUtil.getParameter(request, prefix + "sr_knd_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSrWrkStsCd(JSPUtil.getParameter(request, prefix + "sr_wrk_sts_cd", ""));
		setSrWrkStsUsrId(JSPUtil.getParameter(request, prefix + "sr_wrk_sts_usr_id", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setUsrNm(JSPUtil.getParameter(request, prefix + "usr_nm", ""));
		setPSrKindCd(JSPUtil.getParameter(request, prefix + "p_sr_kind_cd", ""));
		setSrNo(JSPUtil.getParameter(request, prefix + "sr_no", ""));
		setBlDrftFaxOutFlg(JSPUtil.getParameter(request, prefix + "bl_drft_fax_out_flg", ""));
		setSrKind(JSPUtil.getParameter(request, prefix + "sr_kind", ""));
		setPic(JSPUtil.getParameter(request, prefix + "pic", ""));
		setSrHisSeq(JSPUtil.getParameter(request, prefix + "sr_his_seq", ""));
		setMessage(JSPUtil.getParameter(request, prefix + "message", ""));
		setSource(JSPUtil.getParameter(request, prefix + "source", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setXterRqstSeq(JSPUtil.getParameter(request, prefix + "xter_rqst_seq", ""));
		setXterRqstNo(JSPUtil.getParameter(request, prefix + "xter_rqst_no", ""));
		setSel(JSPUtil.getParameter(request, prefix + "sel", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DocQueueDetailListVO[]
	 */
	public DocQueueDetailListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DocQueueDetailListVO[]
	 */
	public DocQueueDetailListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DocQueueDetailListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] blAudFlg = (JSPUtil.getParameter(request, prefix	+ "bl_aud_flg", length));
			String[] picOfcCd = (JSPUtil.getParameter(request, prefix	+ "pic_ofc_cd", length));
			String[] gmtDt = (JSPUtil.getParameter(request, prefix	+ "gmt_dt", length));
			String[] comFlg = (JSPUtil.getParameter(request, prefix	+ "com_flg", length));
			String[] imgFileRealPath = (JSPUtil.getParameter(request, prefix	+ "img_file_real_path", length));
			String[] blRtFlg = (JSPUtil.getParameter(request, prefix	+ "bl_rt_flg", length));
			String[] messageAll = (JSPUtil.getParameter(request, prefix	+ "message_all", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] urgency = (JSPUtil.getParameter(request, prefix	+ "urgency", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] srCrntInfoCd = (JSPUtil.getParameter(request, prefix	+ "sr_crnt_info_cd", length));
			String[] rowsPerPage = (JSPUtil.getParameter(request, prefix	+ "rows_per_page", length));
			String[] shipperSeq = (JSPUtil.getParameter(request, prefix	+ "shipper_seq", length));
			String[] currPage = (JSPUtil.getParameter(request, prefix	+ "curr_page", length));
			String[] shipperNm = (JSPUtil.getParameter(request, prefix	+ "shipper_nm", length));
			String[] page = (JSPUtil.getParameter(request, prefix	+ "page", length));
			String[] urgencyCd = (JSPUtil.getParameter(request, prefix	+ "urgency_cd", length));
			String[] shipperCntCd = (JSPUtil.getParameter(request, prefix	+ "shipper_cnt_cd", length));
			String[] totalCnt = (JSPUtil.getParameter(request, prefix	+ "total_cnt", length));
			String[] srcCd = (JSPUtil.getParameter(request, prefix	+ "src_cd", length));
			String[] blDocInpFlg = (JSPUtil.getParameter(request, prefix	+ "bl_doc_inp_flg", length));
			String[] srStsCd = (JSPUtil.getParameter(request, prefix	+ "sr_sts_cd", length));
			String[] upDt = (JSPUtil.getParameter(request, prefix	+ "up_dt", length));
			String[] wrkGrpCd = (JSPUtil.getParameter(request, prefix	+ "wrk_grp_cd", length));
			String[] maxSrNo = (JSPUtil.getParameter(request, prefix	+ "max_sr_no", length));
			String[] picNm = (JSPUtil.getParameter(request, prefix	+ "pic_nm", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] imgFileNm = (JSPUtil.getParameter(request, prefix	+ "img_file_nm", length));
			String[] pndFlg = (JSPUtil.getParameter(request, prefix	+ "pnd_flg", length));
			String[] srSts = (JSPUtil.getParameter(request, prefix	+ "sr_sts", length));
			String[] returnCd = (JSPUtil.getParameter(request, prefix	+ "return_cd", length));
			String[] imgFilePathCtnt = (JSPUtil.getParameter(request, prefix	+ "img_file_path_ctnt", length));
			String[] srKndCd = (JSPUtil.getParameter(request, prefix	+ "sr_knd_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] srWrkStsCd = (JSPUtil.getParameter(request, prefix	+ "sr_wrk_sts_cd", length));
			String[] srWrkStsUsrId = (JSPUtil.getParameter(request, prefix	+ "sr_wrk_sts_usr_id", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] pSrKindCd = (JSPUtil.getParameter(request, prefix	+ "p_sr_kind_cd", length));
			String[] srNo = (JSPUtil.getParameter(request, prefix	+ "sr_no", length));
			String[] blDrftFaxOutFlg = (JSPUtil.getParameter(request, prefix	+ "bl_drft_fax_out_flg", length));
			String[] srKind = (JSPUtil.getParameter(request, prefix	+ "sr_kind", length));
			String[] pic = (JSPUtil.getParameter(request, prefix	+ "pic", length));
			String[] srHisSeq = (JSPUtil.getParameter(request, prefix	+ "sr_his_seq", length));
			String[] message = (JSPUtil.getParameter(request, prefix	+ "message", length));
			String[] source = (JSPUtil.getParameter(request, prefix	+ "source", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] xterRqstSeq = (JSPUtil.getParameter(request, prefix	+ "xter_rqst_seq", length));
			String[] xterRqstNo = (JSPUtil.getParameter(request, prefix	+ "xter_rqst_no", length));
			String[] sel = (JSPUtil.getParameter(request, prefix	+ "sel", length));
			
			for (int i = 0; i < length; i++) {
				model = new DocQueueDetailListVO();
				if (blAudFlg[i] != null)
					model.setBlAudFlg(blAudFlg[i]);
				if (picOfcCd[i] != null)
					model.setPicOfcCd(picOfcCd[i]);
				if (gmtDt[i] != null)
					model.setGmtDt(gmtDt[i]);
				if (comFlg[i] != null)
					model.setComFlg(comFlg[i]);
				if (imgFileRealPath[i] != null)
					model.setImgFileRealPath(imgFileRealPath[i]);
				if (blRtFlg[i] != null)
					model.setBlRtFlg(blRtFlg[i]);
				if (messageAll[i] != null)
					model.setMessageAll(messageAll[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (urgency[i] != null)
					model.setUrgency(urgency[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (srCrntInfoCd[i] != null)
					model.setSrCrntInfoCd(srCrntInfoCd[i]);
				if (rowsPerPage[i] != null)
					model.setRowsPerPage(rowsPerPage[i]);
				if (shipperSeq[i] != null)
					model.setShipperSeq(shipperSeq[i]);
				if (currPage[i] != null)
					model.setCurrPage(currPage[i]);
				if (shipperNm[i] != null)
					model.setShipperNm(shipperNm[i]);
				if (page[i] != null)
					model.setPage(page[i]);
				if (urgencyCd[i] != null)
					model.setUrgencyCd(urgencyCd[i]);
				if (shipperCntCd[i] != null)
					model.setShipperCntCd(shipperCntCd[i]);
				if (totalCnt[i] != null)
					model.setTotalCnt(totalCnt[i]);
				if (srcCd[i] != null)
					model.setSrcCd(srcCd[i]);
				if (blDocInpFlg[i] != null)
					model.setBlDocInpFlg(blDocInpFlg[i]);
				if (srStsCd[i] != null)
					model.setSrStsCd(srStsCd[i]);
				if (upDt[i] != null)
					model.setUpDt(upDt[i]);
				if (wrkGrpCd[i] != null)
					model.setWrkGrpCd(wrkGrpCd[i]);
				if (maxSrNo[i] != null)
					model.setMaxSrNo(maxSrNo[i]);
				if (picNm[i] != null)
					model.setPicNm(picNm[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (imgFileNm[i] != null)
					model.setImgFileNm(imgFileNm[i]);
				if (pndFlg[i] != null)
					model.setPndFlg(pndFlg[i]);
				if (srSts[i] != null)
					model.setSrSts(srSts[i]);
				if (returnCd[i] != null)
					model.setReturnCd(returnCd[i]);
				if (imgFilePathCtnt[i] != null)
					model.setImgFilePathCtnt(imgFilePathCtnt[i]);
				if (srKndCd[i] != null)
					model.setSrKndCd(srKndCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (srWrkStsCd[i] != null)
					model.setSrWrkStsCd(srWrkStsCd[i]);
				if (srWrkStsUsrId[i] != null)
					model.setSrWrkStsUsrId(srWrkStsUsrId[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (pSrKindCd[i] != null)
					model.setPSrKindCd(pSrKindCd[i]);
				if (srNo[i] != null)
					model.setSrNo(srNo[i]);
				if (blDrftFaxOutFlg[i] != null)
					model.setBlDrftFaxOutFlg(blDrftFaxOutFlg[i]);
				if (srKind[i] != null)
					model.setSrKind(srKind[i]);
				if (pic[i] != null)
					model.setPic(pic[i]);
				if (srHisSeq[i] != null)
					model.setSrHisSeq(srHisSeq[i]);
				if (message[i] != null)
					model.setMessage(message[i]);
				if (source[i] != null)
					model.setSource(source[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (xterRqstSeq[i] != null)
					model.setXterRqstSeq(xterRqstSeq[i]);
				if (xterRqstNo[i] != null)
					model.setXterRqstNo(xterRqstNo[i]);
				if (sel[i] != null)
					model.setSel(sel[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDocQueueDetailListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DocQueueDetailListVO[]
	 */
	public DocQueueDetailListVO[] getDocQueueDetailListVOs(){
		DocQueueDetailListVO[] vos = (DocQueueDetailListVO[])models.toArray(new DocQueueDetailListVO[models.size()]);
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
		this.picOfcCd = this.picOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gmtDt = this.gmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comFlg = this.comFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imgFileRealPath = this.imgFileRealPath .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blRtFlg = this.blRtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.messageAll = this.messageAll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.urgency = this.urgency .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srCrntInfoCd = this.srCrntInfoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowsPerPage = this.rowsPerPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipperSeq = this.shipperSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currPage = this.currPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipperNm = this.shipperNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.page = this.page .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.urgencyCd = this.urgencyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipperCntCd = this.shipperCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalCnt = this.totalCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcCd = this.srcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blDocInpFlg = this.blDocInpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srStsCd = this.srStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.upDt = this.upDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrkGrpCd = this.wrkGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxSrNo = this.maxSrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.picNm = this.picNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imgFileNm = this.imgFileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pndFlg = this.pndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srSts = this.srSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.returnCd = this.returnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imgFilePathCtnt = this.imgFilePathCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srKndCd = this.srKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srWrkStsCd = this.srWrkStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srWrkStsUsrId = this.srWrkStsUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pSrKindCd = this.pSrKindCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srNo = this.srNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blDrftFaxOutFlg = this.blDrftFaxOutFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srKind = this.srKind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pic = this.pic .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srHisSeq = this.srHisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.message = this.message .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.source = this.source .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRqstSeq = this.xterRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRqstNo = this.xterRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sel = this.sel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
