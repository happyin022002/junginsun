/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EdoTransVO.java
*@FileTitle : EdoTransVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.19
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.19  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EdoTransVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EdoTransVO> models = new ArrayList<EdoTransVO>();

	private SignOnUserAccount acount = null;
	/* Column Info */
	private String rqstNo = null;
	/* Column Info */
	private String edoAckCd = null;
	/* Column Info */
	private String edoPtyCd = null;
	/* Column Info */
	private String selfInd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ntfyAddr3 = null;
	/* Column Info */
	private String ntfyAddr2 = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ackCd = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String cstmsDesc = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String ntfyAddr1 = null;
	/* Column Info */
	private String vslVd = null;
	/* Column Info */
	private String asphNm = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String edoTpCd = null;
	/* Column Info */
	private String ntfyNm = null;
	/* Column Info */
	private String cneeAddr1 = null;
	/* Column Info */
	private String cneeAddr2 = null;
	/* Column Info */
	private String cneeAddr3 = null;
	/* Column Info */
	private String actWgt = null;
	/* Column Info */
	private String brac = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cneeNm = null;
	/* Column Info */
	private String rejRmk = null;
	/* Column Info */
	private String cmdtDesc = null;
	/* Column Info */
	private String asphBizNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EdoTransVO() {}

	public EdoTransVO(String ibflag, String pagerows, String rqstNo, String edoAckCd, String edoPtyCd, String blNo, String ntfyAddr3, String ntfyAddr2, String polCd, String ackCd, String cstmsDesc, String measQty, String pckQty, String pckTpCd, String ntfyAddr1, String asphNm, String delCd, String edoTpCd, String ntfyNm, String cneeAddr1, String cneeAddr2, String cneeAddr3, String actWgt, String podCd, String cneeNm, String rejRmk, String asphBizNo, String brac, String cmdtDesc, String vslVd, String vslNm, String selfInd, String bkgNo, String ofcCd, String usrId) {
		this.rqstNo = rqstNo;
		this.edoAckCd = edoAckCd;
		this.edoPtyCd = edoPtyCd;
		this.selfInd = selfInd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.ntfyAddr3 = ntfyAddr3;
		this.ntfyAddr2 = ntfyAddr2;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.ackCd = ackCd;
		this.usrId = usrId;
		this.cstmsDesc = cstmsDesc;
		this.measQty = measQty;
		this.pckQty = pckQty;
		this.pckTpCd = pckTpCd;
		this.ntfyAddr1 = ntfyAddr1;
		this.vslVd = vslVd;
		this.asphNm = asphNm;
		this.delCd = delCd;
		this.vslNm = vslNm;
		this.edoTpCd = edoTpCd;
		this.ntfyNm = ntfyNm;
		this.cneeAddr1 = cneeAddr1;
		this.cneeAddr2 = cneeAddr2;
		this.cneeAddr3 = cneeAddr3;
		this.actWgt = actWgt;
		this.brac = brac;
		this.podCd = podCd;
		this.ofcCd = ofcCd;
		this.bkgNo = bkgNo;
		this.cneeNm = cneeNm;
		this.rejRmk = rejRmk;
		this.cmdtDesc = cmdtDesc;
		this.asphBizNo = asphBizNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rqst_no", getRqstNo());
		this.hashColumns.put("edo_ack_cd", getEdoAckCd());
		this.hashColumns.put("edo_pty_cd", getEdoPtyCd());
		this.hashColumns.put("self_ind", getSelfInd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ntfy_addr3", getNtfyAddr3());
		this.hashColumns.put("ntfy_addr2", getNtfyAddr2());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ack_cd", getAckCd());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("cstms_desc", getCstmsDesc());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("ntfy_addr1", getNtfyAddr1());
		this.hashColumns.put("vsl_vd", getVslVd());
		this.hashColumns.put("asph_nm", getAsphNm());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("edo_tp_cd", getEdoTpCd());
		this.hashColumns.put("ntfy_nm", getNtfyNm());
		this.hashColumns.put("cnee_addr1", getCneeAddr1());
		this.hashColumns.put("cnee_addr2", getCneeAddr2());
		this.hashColumns.put("cnee_addr3", getCneeAddr3());
		this.hashColumns.put("act_wgt", getActWgt());
		this.hashColumns.put("brac", getBrac());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cnee_nm", getCneeNm());
		this.hashColumns.put("rej_rmk", getRejRmk());
		this.hashColumns.put("cmdt_desc", getCmdtDesc());
		this.hashColumns.put("asph_biz_no", getAsphBizNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rqst_no", "rqstNo");
		this.hashFields.put("edo_ack_cd", "edoAckCd");
		this.hashFields.put("edo_pty_cd", "edoPtyCd");
		this.hashFields.put("self_ind", "selfInd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ntfy_addr3", "ntfyAddr3");
		this.hashFields.put("ntfy_addr2", "ntfyAddr2");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ack_cd", "ackCd");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("cstms_desc", "cstmsDesc");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("ntfy_addr1", "ntfyAddr1");
		this.hashFields.put("vsl_vd", "vslVd");
		this.hashFields.put("asph_nm", "asphNm");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("edo_tp_cd", "edoTpCd");
		this.hashFields.put("ntfy_nm", "ntfyNm");
		this.hashFields.put("cnee_addr1", "cneeAddr1");
		this.hashFields.put("cnee_addr2", "cneeAddr2");
		this.hashFields.put("cnee_addr3", "cneeAddr3");
		this.hashFields.put("act_wgt", "actWgt");
		this.hashFields.put("brac", "brac");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cnee_nm", "cneeNm");
		this.hashFields.put("rej_rmk", "rejRmk");
		this.hashFields.put("cmdt_desc", "cmdtDesc");
		this.hashFields.put("asph_biz_no", "asphBizNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rqstNo
	 */
	public String getRqstNo() {
		return this.rqstNo;
	}
	
	/**
	 * Column Info
	 * @return edoAckCd
	 */
	public String getEdoAckCd() {
		return this.edoAckCd;
	}
	
	/**
	 * Column Info
	 * @return edoPtyCd
	 */
	public String getEdoPtyCd() {
		return this.edoPtyCd;
	}
	
	/**
	 * Column Info
	 * @return selfInd
	 */
	public String getSelfInd() {
		return this.selfInd;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return ntfyAddr3
	 */
	public String getNtfyAddr3() {
		return this.ntfyAddr3;
	}
	
	/**
	 * Column Info
	 * @return ntfyAddr2
	 */
	public String getNtfyAddr2() {
		return this.ntfyAddr2;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return ackCd
	 */
	public String getAckCd() {
		return this.ackCd;
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
	 * @return cstmsDesc
	 */
	public String getCstmsDesc() {
		return this.cstmsDesc;
	}
	
	/**
	 * Column Info
	 * @return measQty
	 */
	public String getMeasQty() {
		return this.measQty;
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
	 * @return pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
	}
	
	/**
	 * Column Info
	 * @return ntfyAddr1
	 */
	public String getNtfyAddr1() {
		return this.ntfyAddr1;
	}
	
	/**
	 * Column Info
	 * @return vslVd
	 */
	public String getVslVd() {
		return this.vslVd;
	}
	
	/**
	 * Column Info
	 * @return asphNm
	 */
	public String getAsphNm() {
		return this.asphNm;
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
	 * @return vslNm
	 */
	public String getVslNm() {
		return this.vslNm;
	}
	
	/**
	 * Column Info
	 * @return edoTpCd
	 */
	public String getEdoTpCd() {
		return this.edoTpCd;
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
	 * @return cneeAddr1
	 */
	public String getCneeAddr1() {
		return this.cneeAddr1;
	}
	
	/**
	 * Column Info
	 * @return cneeAddr2
	 */
	public String getCneeAddr2() {
		return this.cneeAddr2;
	}
	
	/**
	 * Column Info
	 * @return cneeAddr3
	 */
	public String getCneeAddr3() {
		return this.cneeAddr3;
	}
	
	/**
	 * Column Info
	 * @return actWgt
	 */
	public String getActWgt() {
		return this.actWgt;
	}
	
	/**
	 * Column Info
	 * @return brac
	 */
	public String getBrac() {
		return this.brac;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return cneeNm
	 */
	public String getCneeNm() {
		return this.cneeNm;
	}
	
	/**
	 * Column Info
	 * @return rejRmk
	 */
	public String getRejRmk() {
		return this.rejRmk;
	}
	
	/**
	 * Column Info
	 * @return cmdtDesc
	 */
	public String getCmdtDesc() {
		return this.cmdtDesc;
	}
	
	/**
	 * Column Info
	 * @return asphBizNo
	 */
	public String getAsphBizNo() {
		return this.asphBizNo;
	}
	

	/**
	 * Column Info
	 * @param rqstNo
	 */
	public void setRqstNo(String rqstNo) {
		this.rqstNo = rqstNo;
	}
	
	/**
	 * Column Info
	 * @param edoAckCd
	 */
	public void setEdoAckCd(String edoAckCd) {
		this.edoAckCd = edoAckCd;
	}
	
	/**
	 * Column Info
	 * @param edoPtyCd
	 */
	public void setEdoPtyCd(String edoPtyCd) {
		this.edoPtyCd = edoPtyCd;
	}
	
	/**
	 * Column Info
	 * @param selfInd
	 */
	public void setSelfInd(String selfInd) {
		this.selfInd = selfInd;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param ntfyAddr3
	 */
	public void setNtfyAddr3(String ntfyAddr3) {
		this.ntfyAddr3 = ntfyAddr3;
	}
	
	/**
	 * Column Info
	 * @param ntfyAddr2
	 */
	public void setNtfyAddr2(String ntfyAddr2) {
		this.ntfyAddr2 = ntfyAddr2;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param ackCd
	 */
	public void setAckCd(String ackCd) {
		this.ackCd = ackCd;
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
	 * @param cstmsDesc
	 */
	public void setCstmsDesc(String cstmsDesc) {
		this.cstmsDesc = cstmsDesc;
	}
	
	/**
	 * Column Info
	 * @param measQty
	 */
	public void setMeasQty(String measQty) {
		this.measQty = measQty;
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
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}
	
	/**
	 * Column Info
	 * @param ntfyAddr1
	 */
	public void setNtfyAddr1(String ntfyAddr1) {
		this.ntfyAddr1 = ntfyAddr1;
	}
	
	/**
	 * Column Info
	 * @param vslVd
	 */
	public void setVslVd(String vslVd) {
		this.vslVd = vslVd;
	}
	
	/**
	 * Column Info
	 * @param asphNm
	 */
	public void setAsphNm(String asphNm) {
		this.asphNm = asphNm;
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
	 * @param vslNm
	 */
	public void setVslNm(String vslNm) {
		this.vslNm = vslNm;
	}
	
	/**
	 * Column Info
	 * @param edoTpCd
	 */
	public void setEdoTpCd(String edoTpCd) {
		this.edoTpCd = edoTpCd;
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
	 * @param cneeAddr1
	 */
	public void setCneeAddr1(String cneeAddr1) {
		this.cneeAddr1 = cneeAddr1;
	}
	
	/**
	 * Column Info
	 * @param cneeAddr2
	 */
	public void setCneeAddr2(String cneeAddr2) {
		this.cneeAddr2 = cneeAddr2;
	}
	
	/**
	 * Column Info
	 * @param cneeAddr3
	 */
	public void setCneeAddr3(String cneeAddr3) {
		this.cneeAddr3 = cneeAddr3;
	}
	
	/**
	 * Column Info
	 * @param actWgt
	 */
	public void setActWgt(String actWgt) {
		this.actWgt = actWgt;
	}
	
	/**
	 * Column Info
	 * @param brac
	 */
	public void setBrac(String brac) {
		this.brac = brac;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param cneeNm
	 */
	public void setCneeNm(String cneeNm) {
		this.cneeNm = cneeNm;
	}
	
	/**
	 * Column Info
	 * @param rejRmk
	 */
	public void setRejRmk(String rejRmk) {
		this.rejRmk = rejRmk;
	}
	
	/**
	 * Column Info
	 * @param cmdtDesc
	 */
	public void setCmdtDesc(String cmdtDesc) {
		this.cmdtDesc = cmdtDesc;
	}
	
	/**
	 * Column Info
	 * @param asphBizNo
	 */
	public void setAsphBizNo(String asphBizNo) {
		this.asphBizNo = asphBizNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRqstNo(JSPUtil.getParameter(request, "rqst_no", ""));
		setEdoAckCd(JSPUtil.getParameter(request, "edo_ack_cd", ""));
		setEdoPtyCd(JSPUtil.getParameter(request, "edo_pty_cd", ""));
		setSelfInd(JSPUtil.getParameter(request, "self_ind", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setNtfyAddr3(JSPUtil.getParameter(request, "ntfy_addr3", ""));
		setNtfyAddr2(JSPUtil.getParameter(request, "ntfy_addr2", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAckCd(JSPUtil.getParameter(request, "ack_cd", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setCstmsDesc(JSPUtil.getParameter(request, "cstms_desc", ""));
		setMeasQty(JSPUtil.getParameter(request, "meas_qty", ""));
		setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
		setPckTpCd(JSPUtil.getParameter(request, "pck_tp_cd", ""));
		setNtfyAddr1(JSPUtil.getParameter(request, "ntfy_addr1", ""));
		setVslVd(JSPUtil.getParameter(request, "vsl_vd", ""));
		setAsphNm(JSPUtil.getParameter(request, "asph_nm", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setVslNm(JSPUtil.getParameter(request, "vsl_nm", ""));
		setEdoTpCd(JSPUtil.getParameter(request, "edo_tp_cd", ""));
		setNtfyNm(JSPUtil.getParameter(request, "ntfy_nm", ""));
		setCneeAddr1(JSPUtil.getParameter(request, "cnee_addr1", ""));
		setCneeAddr2(JSPUtil.getParameter(request, "cnee_addr2", ""));
		setCneeAddr3(JSPUtil.getParameter(request, "cnee_addr3", ""));
		setActWgt(JSPUtil.getParameter(request, "act_wgt", ""));
		setBrac(JSPUtil.getParameter(request, "brac", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCneeNm(JSPUtil.getParameter(request, "cnee_nm", ""));
		setRejRmk(JSPUtil.getParameter(request, "rej_rmk", ""));
		setCmdtDesc(JSPUtil.getParameter(request, "cmdt_desc", ""));
		setAsphBizNo(JSPUtil.getParameter(request, "asph_biz_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EdoTransVO[]
	 */
	public EdoTransVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EdoTransVO[]
	 */
	public EdoTransVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EdoTransVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rqstNo = (JSPUtil.getParameter(request, prefix	+ "rqst_no", length));
			String[] edoAckCd = (JSPUtil.getParameter(request, prefix	+ "edo_ack_cd", length));
			String[] edoPtyCd = (JSPUtil.getParameter(request, prefix	+ "edo_pty_cd", length));
			String[] selfInd = (JSPUtil.getParameter(request, prefix	+ "self_ind", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ntfyAddr3 = (JSPUtil.getParameter(request, prefix	+ "ntfy_addr3", length));
			String[] ntfyAddr2 = (JSPUtil.getParameter(request, prefix	+ "ntfy_addr2", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ackCd = (JSPUtil.getParameter(request, prefix	+ "ack_cd", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] cstmsDesc = (JSPUtil.getParameter(request, prefix	+ "cstms_desc", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] ntfyAddr1 = (JSPUtil.getParameter(request, prefix	+ "ntfy_addr1", length));
			String[] vslVd = (JSPUtil.getParameter(request, prefix	+ "vsl_vd", length));
			String[] asphNm = (JSPUtil.getParameter(request, prefix	+ "asph_nm", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] edoTpCd = (JSPUtil.getParameter(request, prefix	+ "edo_tp_cd", length));
			String[] ntfyNm = (JSPUtil.getParameter(request, prefix	+ "ntfy_nm", length));
			String[] cneeAddr1 = (JSPUtil.getParameter(request, prefix	+ "cnee_addr1", length));
			String[] cneeAddr2 = (JSPUtil.getParameter(request, prefix	+ "cnee_addr2", length));
			String[] cneeAddr3 = (JSPUtil.getParameter(request, prefix	+ "cnee_addr3", length));
			String[] actWgt = (JSPUtil.getParameter(request, prefix	+ "act_wgt", length));
			String[] brac = (JSPUtil.getParameter(request, prefix	+ "brac", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cneeNm = (JSPUtil.getParameter(request, prefix	+ "cnee_nm", length));
			String[] rejRmk = (JSPUtil.getParameter(request, prefix	+ "rej_rmk", length));
			String[] cmdtDesc = (JSPUtil.getParameter(request, prefix	+ "cmdt_desc", length));
			String[] asphBizNo = (JSPUtil.getParameter(request, prefix	+ "asph_biz_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new EdoTransVO();
				if (rqstNo[i] != null)
					model.setRqstNo(rqstNo[i]);
				if (edoAckCd[i] != null)
					model.setEdoAckCd(edoAckCd[i]);
				if (edoPtyCd[i] != null)
					model.setEdoPtyCd(edoPtyCd[i]);
				if (selfInd[i] != null)
					model.setSelfInd(selfInd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ntfyAddr3[i] != null)
					model.setNtfyAddr3(ntfyAddr3[i]);
				if (ntfyAddr2[i] != null)
					model.setNtfyAddr2(ntfyAddr2[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ackCd[i] != null)
					model.setAckCd(ackCd[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (cstmsDesc[i] != null)
					model.setCstmsDesc(cstmsDesc[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (ntfyAddr1[i] != null)
					model.setNtfyAddr1(ntfyAddr1[i]);
				if (vslVd[i] != null)
					model.setVslVd(vslVd[i]);
				if (asphNm[i] != null)
					model.setAsphNm(asphNm[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (edoTpCd[i] != null)
					model.setEdoTpCd(edoTpCd[i]);
				if (ntfyNm[i] != null)
					model.setNtfyNm(ntfyNm[i]);
				if (cneeAddr1[i] != null)
					model.setCneeAddr1(cneeAddr1[i]);
				if (cneeAddr2[i] != null)
					model.setCneeAddr2(cneeAddr2[i]);
				if (cneeAddr3[i] != null)
					model.setCneeAddr3(cneeAddr3[i]);
				if (actWgt[i] != null)
					model.setActWgt(actWgt[i]);
				if (brac[i] != null)
					model.setBrac(brac[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cneeNm[i] != null)
					model.setCneeNm(cneeNm[i]);
				if (rejRmk[i] != null)
					model.setRejRmk(rejRmk[i]);
				if (cmdtDesc[i] != null)
					model.setCmdtDesc(cmdtDesc[i]);
				if (asphBizNo[i] != null)
					model.setAsphBizNo(asphBizNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEdoTransVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EdoTransVO[]
	 */
	public EdoTransVO[] getEdoTransVOs(){
		EdoTransVO[] vos = (EdoTransVO[])models.toArray(new EdoTransVO[models.size()]);
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
		this.rqstNo = this.rqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edoAckCd = this.edoAckCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edoPtyCd = this.edoPtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selfInd = this.selfInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyAddr3 = this.ntfyAddr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyAddr2 = this.ntfyAddr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackCd = this.ackCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDesc = this.cstmsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyAddr1 = this.ntfyAddr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslVd = this.vslVd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asphNm = this.asphNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edoTpCd = this.edoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyNm = this.ntfyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeAddr1 = this.cneeAddr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeAddr2 = this.cneeAddr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeAddr3 = this.cneeAddr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWgt = this.actWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brac = this.brac .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNm = this.cneeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rejRmk = this.rejRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDesc = this.cmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asphBizNo = this.asphBizNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

	/**
	 * @return the acount
	 */
	public SignOnUserAccount getAcount() {
		return acount;
	}

	/**
	 * @param acount the acount to set
	 */
	public void setAcount(SignOnUserAccount acount) {
		this.acount = acount;
	}
}
