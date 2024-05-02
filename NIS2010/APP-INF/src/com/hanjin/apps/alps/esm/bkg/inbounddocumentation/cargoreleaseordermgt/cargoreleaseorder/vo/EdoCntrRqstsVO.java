/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EdoCntrRqstsVO.java
*@FileTitle : EdoCntrRqstsVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.18
*@LastModifier : 
*@LastVersion : 1.0
* 2010.06.18  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EdoCntrRqstsVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EdoCntrRqstsVO> models = new ArrayList<EdoCntrRqstsVO>();
	
	/* Column Info */
	private String ibdtEdoRctDt = null;
	/* Column Info */
	private String seltEdoAckCd = null;
	/* Column Info */
	private String ptyNm = null;
	/* Column Info */
	private String ptyAsNm = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String hndlOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String phnAsNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String edoRqstSeq5jn = null;
	/* Column Info */
	private String phnNo = null;
	/* Column Info */
	private String rqstEdoIssDt = null;
	/* Column Info */
	private String edoRqstSeq5jm = null;
	/* Column Info */
	private String edoFuncCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String ibdtEdoAckCd = null;
	/* Column Info */
	private String edoTpCd = null;
	/* Column Info */
	private String edoRqstSeq5jk = null;
	/* Column Info */
	private String vslArrDt = null;
	/* Column Info */
	private String doEdoRctLocCd = null;
	/* Column Info */
	private String whNm = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String seltEdoRctDt = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String edoRqstNo = null;
	/* Column Info */
	private String opCntrQty = null;
	/* Column Info */
	private String doEdoAckCd = null;
	/* Column Info */
	private String doEdoRctDt = null;
	/* Column Info */
	private String deltUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EdoCntrRqstsVO() {}

	public EdoCntrRqstsVO(String ibflag, String pagerows, String edoRqstNo, String edoRqstSeq5jn, String edoRqstSeq5jm, String edoRqstSeq5jk, String blNo, String podCd, String delCd, String whNm, String edoFuncCd, String doEdoAckCd, String doEdoRctDt, String doEdoRctLocCd, String rqstEdoIssDt, String hndlOfcCd, String seltEdoAckCd, String seltEdoRctDt, String ibdtEdoAckCd, String ibdtEdoRctDt, String vslArrDt, String deltUsrId, String edoTpCd, String bkgNo, String ptyNm, String phnNo, String ptyAsNm, String phnAsNo, String cntrTpszCd, String opCntrQty) {
		this.ibdtEdoRctDt = ibdtEdoRctDt;
		this.seltEdoAckCd = seltEdoAckCd;
		this.ptyNm = ptyNm;
		this.ptyAsNm = ptyAsNm;
		this.blNo = blNo;
		this.hndlOfcCd = hndlOfcCd;
		this.pagerows = pagerows;
		this.phnAsNo = phnAsNo;
		this.ibflag = ibflag;
		this.cntrTpszCd = cntrTpszCd;
		this.edoRqstSeq5jn = edoRqstSeq5jn;
		this.phnNo = phnNo;
		this.rqstEdoIssDt = rqstEdoIssDt;
		this.edoRqstSeq5jm = edoRqstSeq5jm;
		this.edoFuncCd = edoFuncCd;
		this.delCd = delCd;
		this.ibdtEdoAckCd = ibdtEdoAckCd;
		this.edoTpCd = edoTpCd;
		this.edoRqstSeq5jk = edoRqstSeq5jk;
		this.vslArrDt = vslArrDt;
		this.doEdoRctLocCd = doEdoRctLocCd;
		this.whNm = whNm;
		this.podCd = podCd;
		this.seltEdoRctDt = seltEdoRctDt;
		this.bkgNo = bkgNo;
		this.edoRqstNo = edoRqstNo;
		this.opCntrQty = opCntrQty;
		this.doEdoAckCd = doEdoAckCd;
		this.doEdoRctDt = doEdoRctDt;
		this.deltUsrId = deltUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibdt_edo_rct_dt", getIbdtEdoRctDt());
		this.hashColumns.put("selt_edo_ack_cd", getSeltEdoAckCd());
		this.hashColumns.put("pty_nm", getPtyNm());
		this.hashColumns.put("pty_as_nm", getPtyAsNm());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("hndl_ofc_cd", getHndlOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("phn_as_no", getPhnAsNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("edo_rqst_seq_5jn", getEdoRqstSeq5jn());
		this.hashColumns.put("phn_no", getPhnNo());
		this.hashColumns.put("rqst_edo_iss_dt", getRqstEdoIssDt());
		this.hashColumns.put("edo_rqst_seq_5jm", getEdoRqstSeq5jm());
		this.hashColumns.put("edo_func_cd", getEdoFuncCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("ibdt_edo_ack_cd", getIbdtEdoAckCd());
		this.hashColumns.put("edo_tp_cd", getEdoTpCd());
		this.hashColumns.put("edo_rqst_seq_5jk", getEdoRqstSeq5jk());
		this.hashColumns.put("vsl_arr_dt", getVslArrDt());
		this.hashColumns.put("do_edo_rct_loc_cd", getDoEdoRctLocCd());
		this.hashColumns.put("wh_nm", getWhNm());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("selt_edo_rct_dt", getSeltEdoRctDt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("edo_rqst_no", getEdoRqstNo());
		this.hashColumns.put("op_cntr_qty", getOpCntrQty());
		this.hashColumns.put("do_edo_ack_cd", getDoEdoAckCd());
		this.hashColumns.put("do_edo_rct_dt", getDoEdoRctDt());
		this.hashColumns.put("delt_usr_id", getDeltUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibdt_edo_rct_dt", "ibdtEdoRctDt");
		this.hashFields.put("selt_edo_ack_cd", "seltEdoAckCd");
		this.hashFields.put("pty_nm", "ptyNm");
		this.hashFields.put("pty_as_nm", "ptyAsNm");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("hndl_ofc_cd", "hndlOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("phn_as_no", "phnAsNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("edo_rqst_seq_5jn", "edoRqstSeq5jn");
		this.hashFields.put("phn_no", "phnNo");
		this.hashFields.put("rqst_edo_iss_dt", "rqstEdoIssDt");
		this.hashFields.put("edo_rqst_seq_5jm", "edoRqstSeq5jm");
		this.hashFields.put("edo_func_cd", "edoFuncCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("ibdt_edo_ack_cd", "ibdtEdoAckCd");
		this.hashFields.put("edo_tp_cd", "edoTpCd");
		this.hashFields.put("edo_rqst_seq_5jk", "edoRqstSeq5jk");
		this.hashFields.put("vsl_arr_dt", "vslArrDt");
		this.hashFields.put("do_edo_rct_loc_cd", "doEdoRctLocCd");
		this.hashFields.put("wh_nm", "whNm");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("selt_edo_rct_dt", "seltEdoRctDt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("edo_rqst_no", "edoRqstNo");
		this.hashFields.put("op_cntr_qty", "opCntrQty");
		this.hashFields.put("do_edo_ack_cd", "doEdoAckCd");
		this.hashFields.put("do_edo_rct_dt", "doEdoRctDt");
		this.hashFields.put("delt_usr_id", "deltUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ibdtEdoRctDt
	 */
	public String getIbdtEdoRctDt() {
		return this.ibdtEdoRctDt;
	}
	
	/**
	 * Column Info
	 * @return seltEdoAckCd
	 */
	public String getSeltEdoAckCd() {
		return this.seltEdoAckCd;
	}
	
	/**
	 * Column Info
	 * @return ptyNm
	 */
	public String getPtyNm() {
		return this.ptyNm;
	}
	
	/**
	 * Column Info
	 * @return ptyAsNm
	 */
	public String getPtyAsNm() {
		return this.ptyAsNm;
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
	 * @return hndlOfcCd
	 */
	public String getHndlOfcCd() {
		return this.hndlOfcCd;
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
	 * @return phnAsNo
	 */
	public String getPhnAsNo() {
		return this.phnAsNo;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return edoRqstSeq5jn
	 */
	public String getEdoRqstSeq5jn() {
		return this.edoRqstSeq5jn;
	}
	
	/**
	 * Column Info
	 * @return phnNo
	 */
	public String getPhnNo() {
		return this.phnNo;
	}
	
	/**
	 * Column Info
	 * @return rqstEdoIssDt
	 */
	public String getRqstEdoIssDt() {
		return this.rqstEdoIssDt;
	}
	
	/**
	 * Column Info
	 * @return edoRqstSeq5jm
	 */
	public String getEdoRqstSeq5jm() {
		return this.edoRqstSeq5jm;
	}
	
	/**
	 * Column Info
	 * @return edoFuncCd
	 */
	public String getEdoFuncCd() {
		return this.edoFuncCd;
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
	 * @return ibdtEdoAckCd
	 */
	public String getIbdtEdoAckCd() {
		return this.ibdtEdoAckCd;
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
	 * @return edoRqstSeq5jk
	 */
	public String getEdoRqstSeq5jk() {
		return this.edoRqstSeq5jk;
	}
	
	/**
	 * Column Info
	 * @return vslArrDt
	 */
	public String getVslArrDt() {
		return this.vslArrDt;
	}
	
	/**
	 * Column Info
	 * @return doEdoRctLocCd
	 */
	public String getDoEdoRctLocCd() {
		return this.doEdoRctLocCd;
	}
	
	/**
	 * Column Info
	 * @return whNm
	 */
	public String getWhNm() {
		return this.whNm;
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
	 * @return seltEdoRctDt
	 */
	public String getSeltEdoRctDt() {
		return this.seltEdoRctDt;
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
	 * @return edoRqstNo
	 */
	public String getEdoRqstNo() {
		return this.edoRqstNo;
	}
	
	/**
	 * Column Info
	 * @return opCntrQty
	 */
	public String getOpCntrQty() {
		return this.opCntrQty;
	}
	
	/**
	 * Column Info
	 * @return doEdoAckCd
	 */
	public String getDoEdoAckCd() {
		return this.doEdoAckCd;
	}
	
	/**
	 * Column Info
	 * @return doEdoRctDt
	 */
	public String getDoEdoRctDt() {
		return this.doEdoRctDt;
	}
	
	/**
	 * Column Info
	 * @return deltUsrId
	 */
	public String getDeltUsrId() {
		return this.deltUsrId;
	}
	

	/**
	 * Column Info
	 * @param ibdtEdoRctDt
	 */
	public void setIbdtEdoRctDt(String ibdtEdoRctDt) {
		this.ibdtEdoRctDt = ibdtEdoRctDt;
	}
	
	/**
	 * Column Info
	 * @param seltEdoAckCd
	 */
	public void setSeltEdoAckCd(String seltEdoAckCd) {
		this.seltEdoAckCd = seltEdoAckCd;
	}
	
	/**
	 * Column Info
	 * @param ptyNm
	 */
	public void setPtyNm(String ptyNm) {
		this.ptyNm = ptyNm;
	}
	
	/**
	 * Column Info
	 * @param ptyAsNm
	 */
	public void setPtyAsNm(String ptyAsNm) {
		this.ptyAsNm = ptyAsNm;
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
	 * @param hndlOfcCd
	 */
	public void setHndlOfcCd(String hndlOfcCd) {
		this.hndlOfcCd = hndlOfcCd;
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
	 * @param phnAsNo
	 */
	public void setPhnAsNo(String phnAsNo) {
		this.phnAsNo = phnAsNo;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param edoRqstSeq5jn
	 */
	public void setEdoRqstSeq5jn(String edoRqstSeq5jn) {
		this.edoRqstSeq5jn = edoRqstSeq5jn;
	}
	
	/**
	 * Column Info
	 * @param phnNo
	 */
	public void setPhnNo(String phnNo) {
		this.phnNo = phnNo;
	}
	
	/**
	 * Column Info
	 * @param rqstEdoIssDt
	 */
	public void setRqstEdoIssDt(String rqstEdoIssDt) {
		this.rqstEdoIssDt = rqstEdoIssDt;
	}
	
	/**
	 * Column Info
	 * @param edoRqstSeq5jm
	 */
	public void setEdoRqstSeq5jm(String edoRqstSeq5jm) {
		this.edoRqstSeq5jm = edoRqstSeq5jm;
	}
	
	/**
	 * Column Info
	 * @param edoFuncCd
	 */
	public void setEdoFuncCd(String edoFuncCd) {
		this.edoFuncCd = edoFuncCd;
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
	 * @param ibdtEdoAckCd
	 */
	public void setIbdtEdoAckCd(String ibdtEdoAckCd) {
		this.ibdtEdoAckCd = ibdtEdoAckCd;
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
	 * @param edoRqstSeq5jk
	 */
	public void setEdoRqstSeq5jk(String edoRqstSeq5jk) {
		this.edoRqstSeq5jk = edoRqstSeq5jk;
	}
	
	/**
	 * Column Info
	 * @param vslArrDt
	 */
	public void setVslArrDt(String vslArrDt) {
		this.vslArrDt = vslArrDt;
	}
	
	/**
	 * Column Info
	 * @param doEdoRctLocCd
	 */
	public void setDoEdoRctLocCd(String doEdoRctLocCd) {
		this.doEdoRctLocCd = doEdoRctLocCd;
	}
	
	/**
	 * Column Info
	 * @param whNm
	 */
	public void setWhNm(String whNm) {
		this.whNm = whNm;
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
	 * @param seltEdoRctDt
	 */
	public void setSeltEdoRctDt(String seltEdoRctDt) {
		this.seltEdoRctDt = seltEdoRctDt;
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
	 * @param edoRqstNo
	 */
	public void setEdoRqstNo(String edoRqstNo) {
		this.edoRqstNo = edoRqstNo;
	}
	
	/**
	 * Column Info
	 * @param opCntrQty
	 */
	public void setOpCntrQty(String opCntrQty) {
		this.opCntrQty = opCntrQty;
	}
	
	/**
	 * Column Info
	 * @param doEdoAckCd
	 */
	public void setDoEdoAckCd(String doEdoAckCd) {
		this.doEdoAckCd = doEdoAckCd;
	}
	
	/**
	 * Column Info
	 * @param doEdoRctDt
	 */
	public void setDoEdoRctDt(String doEdoRctDt) {
		this.doEdoRctDt = doEdoRctDt;
	}
	
	/**
	 * Column Info
	 * @param deltUsrId
	 */
	public void setDeltUsrId(String deltUsrId) {
		this.deltUsrId = deltUsrId;
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
		setIbdtEdoRctDt(JSPUtil.getParameter(request, prefix + "ibdt_edo_rct_dt", ""));
		setSeltEdoAckCd(JSPUtil.getParameter(request, prefix + "selt_edo_ack_cd", ""));
		setPtyNm(JSPUtil.getParameter(request, prefix + "pty_nm", ""));
		setPtyAsNm(JSPUtil.getParameter(request, prefix + "pty_as_nm", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setHndlOfcCd(JSPUtil.getParameter(request, prefix + "hndl_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPhnAsNo(JSPUtil.getParameter(request, prefix + "phn_as_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setEdoRqstSeq5jn(JSPUtil.getParameter(request, prefix + "edo_rqst_seq_5jn", ""));
		setPhnNo(JSPUtil.getParameter(request, prefix + "phn_no", ""));
		setRqstEdoIssDt(JSPUtil.getParameter(request, prefix + "rqst_edo_iss_dt", ""));
		setEdoRqstSeq5jm(JSPUtil.getParameter(request, prefix + "edo_rqst_seq_5jm", ""));
		setEdoFuncCd(JSPUtil.getParameter(request, prefix + "edo_func_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setIbdtEdoAckCd(JSPUtil.getParameter(request, prefix + "ibdt_edo_ack_cd", ""));
		setEdoTpCd(JSPUtil.getParameter(request, prefix + "edo_tp_cd", ""));
		setEdoRqstSeq5jk(JSPUtil.getParameter(request, prefix + "edo_rqst_seq_5jk", ""));
		setVslArrDt(JSPUtil.getParameter(request, prefix + "vsl_arr_dt", ""));
		setDoEdoRctLocCd(JSPUtil.getParameter(request, prefix + "do_edo_rct_loc_cd", ""));
		setWhNm(JSPUtil.getParameter(request, prefix + "wh_nm", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setSeltEdoRctDt(JSPUtil.getParameter(request, prefix + "selt_edo_rct_dt", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setEdoRqstNo(JSPUtil.getParameter(request, prefix + "edo_rqst_no", ""));
		setOpCntrQty(JSPUtil.getParameter(request, prefix + "op_cntr_qty", ""));
		setDoEdoAckCd(JSPUtil.getParameter(request, prefix + "do_edo_ack_cd", ""));
		setDoEdoRctDt(JSPUtil.getParameter(request, prefix + "do_edo_rct_dt", ""));
		setDeltUsrId(JSPUtil.getParameter(request, prefix + "delt_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EdoCntrRqstsVO[]
	 */
	public EdoCntrRqstsVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EdoCntrRqstsVO[]
	 */
	public EdoCntrRqstsVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EdoCntrRqstsVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibdtEdoRctDt = (JSPUtil.getParameter(request, prefix	+ "ibdt_edo_rct_dt", length));
			String[] seltEdoAckCd = (JSPUtil.getParameter(request, prefix	+ "selt_edo_ack_cd", length));
			String[] ptyNm = (JSPUtil.getParameter(request, prefix	+ "pty_nm", length));
			String[] ptyAsNm = (JSPUtil.getParameter(request, prefix	+ "pty_as_nm", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] hndlOfcCd = (JSPUtil.getParameter(request, prefix	+ "hndl_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] phnAsNo = (JSPUtil.getParameter(request, prefix	+ "phn_as_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] edoRqstSeq5jn = (JSPUtil.getParameter(request, prefix	+ "edo_rqst_seq_5jn", length));
			String[] phnNo = (JSPUtil.getParameter(request, prefix	+ "phn_no", length));
			String[] rqstEdoIssDt = (JSPUtil.getParameter(request, prefix	+ "rqst_edo_iss_dt", length));
			String[] edoRqstSeq5jm = (JSPUtil.getParameter(request, prefix	+ "edo_rqst_seq_5jm", length));
			String[] edoFuncCd = (JSPUtil.getParameter(request, prefix	+ "edo_func_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] ibdtEdoAckCd = (JSPUtil.getParameter(request, prefix	+ "ibdt_edo_ack_cd", length));
			String[] edoTpCd = (JSPUtil.getParameter(request, prefix	+ "edo_tp_cd", length));
			String[] edoRqstSeq5jk = (JSPUtil.getParameter(request, prefix	+ "edo_rqst_seq_5jk", length));
			String[] vslArrDt = (JSPUtil.getParameter(request, prefix	+ "vsl_arr_dt", length));
			String[] doEdoRctLocCd = (JSPUtil.getParameter(request, prefix	+ "do_edo_rct_loc_cd", length));
			String[] whNm = (JSPUtil.getParameter(request, prefix	+ "wh_nm", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] seltEdoRctDt = (JSPUtil.getParameter(request, prefix	+ "selt_edo_rct_dt", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] edoRqstNo = (JSPUtil.getParameter(request, prefix	+ "edo_rqst_no", length));
			String[] opCntrQty = (JSPUtil.getParameter(request, prefix	+ "op_cntr_qty", length));
			String[] doEdoAckCd = (JSPUtil.getParameter(request, prefix	+ "do_edo_ack_cd", length));
			String[] doEdoRctDt = (JSPUtil.getParameter(request, prefix	+ "do_edo_rct_dt", length));
			String[] deltUsrId = (JSPUtil.getParameter(request, prefix	+ "delt_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new EdoCntrRqstsVO();
				if (ibdtEdoRctDt[i] != null)
					model.setIbdtEdoRctDt(ibdtEdoRctDt[i]);
				if (seltEdoAckCd[i] != null)
					model.setSeltEdoAckCd(seltEdoAckCd[i]);
				if (ptyNm[i] != null)
					model.setPtyNm(ptyNm[i]);
				if (ptyAsNm[i] != null)
					model.setPtyAsNm(ptyAsNm[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (hndlOfcCd[i] != null)
					model.setHndlOfcCd(hndlOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (phnAsNo[i] != null)
					model.setPhnAsNo(phnAsNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (edoRqstSeq5jn[i] != null)
					model.setEdoRqstSeq5jn(edoRqstSeq5jn[i]);
				if (phnNo[i] != null)
					model.setPhnNo(phnNo[i]);
				if (rqstEdoIssDt[i] != null)
					model.setRqstEdoIssDt(rqstEdoIssDt[i]);
				if (edoRqstSeq5jm[i] != null)
					model.setEdoRqstSeq5jm(edoRqstSeq5jm[i]);
				if (edoFuncCd[i] != null)
					model.setEdoFuncCd(edoFuncCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (ibdtEdoAckCd[i] != null)
					model.setIbdtEdoAckCd(ibdtEdoAckCd[i]);
				if (edoTpCd[i] != null)
					model.setEdoTpCd(edoTpCd[i]);
				if (edoRqstSeq5jk[i] != null)
					model.setEdoRqstSeq5jk(edoRqstSeq5jk[i]);
				if (vslArrDt[i] != null)
					model.setVslArrDt(vslArrDt[i]);
				if (doEdoRctLocCd[i] != null)
					model.setDoEdoRctLocCd(doEdoRctLocCd[i]);
				if (whNm[i] != null)
					model.setWhNm(whNm[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (seltEdoRctDt[i] != null)
					model.setSeltEdoRctDt(seltEdoRctDt[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (edoRqstNo[i] != null)
					model.setEdoRqstNo(edoRqstNo[i]);
				if (opCntrQty[i] != null)
					model.setOpCntrQty(opCntrQty[i]);
				if (doEdoAckCd[i] != null)
					model.setDoEdoAckCd(doEdoAckCd[i]);
				if (doEdoRctDt[i] != null)
					model.setDoEdoRctDt(doEdoRctDt[i]);
				if (deltUsrId[i] != null)
					model.setDeltUsrId(deltUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEdoCntrRqstsVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EdoCntrRqstsVO[]
	 */
	public EdoCntrRqstsVO[] getEdoCntrRqstsVOs(){
		EdoCntrRqstsVO[] vos = (EdoCntrRqstsVO[])models.toArray(new EdoCntrRqstsVO[models.size()]);
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
		this.ibdtEdoRctDt = this.ibdtEdoRctDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seltEdoAckCd = this.seltEdoAckCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptyNm = this.ptyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptyAsNm = this.ptyAsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hndlOfcCd = this.hndlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phnAsNo = this.phnAsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edoRqstSeq5jn = this.edoRqstSeq5jn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phnNo = this.phnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstEdoIssDt = this.rqstEdoIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edoRqstSeq5jm = this.edoRqstSeq5jm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edoFuncCd = this.edoFuncCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdtEdoAckCd = this.ibdtEdoAckCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edoTpCd = this.edoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edoRqstSeq5jk = this.edoRqstSeq5jk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslArrDt = this.vslArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doEdoRctLocCd = this.doEdoRctLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whNm = this.whNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seltEdoRctDt = this.seltEdoRctDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edoRqstNo = this.edoRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCntrQty = this.opCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doEdoAckCd = this.doEdoAckCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doEdoRctDt = this.doEdoRctDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltUsrId = this.deltUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
