/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EU24EDIHistoryOBVO.java
*@FileTitle : EU24EDIHistoryOBVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.18
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2011.07.18 박성진 
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
 * @author 박성진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EU24EDIHistoryOBVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EU24EDIHistoryOBVO> models = new ArrayList<EU24EDIHistoryOBVO>();
	
	/* Column Info */
	private String ediRcvDt = null;
	/* Column Info */
	private String byOfcCd = null;
	/* Column Info */
	private String result = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String ediRcvSeq = null;
	/* Column Info */
	private String byName = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String mrnNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bndTpCd = null;
	/* Column Info */
	private String rcvMsg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String byId = null;
	/* Column Info */
	private String pBlNo = null;
	/* Column Info */
	private String pSkdDirCd = null;
	/* Column Info */
	private String cstmsPortCd = null;
	/* Column Info */
	private String pVslCd = null;
	/* Column Info */
	private String pVvd = null;
	/* Column Info */
	private String gmtTime = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String pSkdVoyNo = null;
	/* Column Info */
	private String pCstmsPortCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String localTime = null;
	/* Column Info */
	private String msgType = null;
	/* Column Info */
	private String msgSndNo = null;
	/* Column Info */
	private String msgImg = null;
	/* Column Info */
	private String typeCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EU24EDIHistoryOBVO() {}

	public EU24EDIHistoryOBVO(String ibflag, String pagerows, String ediRcvDt, String vslCd, String result, String byOfcCd, String ediRcvSeq, String byName, String mrnNo, String blNo, String rcvMsg, String pBlNo, String byId, String pSkdDirCd, String cstmsPortCd, String pVslCd, String pVvd, String gmtTime, String skdVoyNo, String skdDirCd, String pSkdVoyNo, String pCstmsPortCd, String vvd, String localTime, String msgType, String msgSndNo, String msgImg, String typeCd, String bndTpCd) {
		this.ediRcvDt = ediRcvDt;
		this.byOfcCd = byOfcCd;
		this.result = result;
		this.vslCd = vslCd;
		this.ediRcvSeq = ediRcvSeq;
		this.byName = byName;
		this.blNo = blNo;
		this.mrnNo = mrnNo;
		this.pagerows = pagerows;
		this.bndTpCd = bndTpCd;
		this.rcvMsg = rcvMsg;
		this.ibflag = ibflag;
		this.byId = byId;
		this.pBlNo = pBlNo;
		this.pSkdDirCd = pSkdDirCd;
		this.cstmsPortCd = cstmsPortCd;
		this.pVslCd = pVslCd;
		this.pVvd = pVvd;
		this.gmtTime = gmtTime;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd = skdDirCd;
		this.pSkdVoyNo = pSkdVoyNo;
		this.pCstmsPortCd = pCstmsPortCd;
		this.vvd = vvd;
		this.localTime = localTime;
		this.msgType = msgType;
		this.msgSndNo = msgSndNo;
		this.msgImg = msgImg;
		this.typeCd = typeCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("edi_rcv_dt", getEdiRcvDt());
		this.hashColumns.put("by_ofc_cd", getByOfcCd());
		this.hashColumns.put("result", getResult());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("edi_rcv_seq", getEdiRcvSeq());
		this.hashColumns.put("by_name", getByName());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("mrn_no", getMrnNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bnd_tp_cd", getBndTpCd());
		this.hashColumns.put("rcv_msg", getRcvMsg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("by_id", getById());
		this.hashColumns.put("p_bl_no", getPBlNo());
		this.hashColumns.put("p_skd_dir_cd", getPSkdDirCd());
		this.hashColumns.put("cstms_port_cd", getCstmsPortCd());
		this.hashColumns.put("p_vsl_cd", getPVslCd());
		this.hashColumns.put("p_vvd", getPVvd());
		this.hashColumns.put("gmt_time", getGmtTime());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("p_skd_voy_no", getPSkdVoyNo());
		this.hashColumns.put("p_cstms_port_cd", getPCstmsPortCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("local_time", getLocalTime());
		this.hashColumns.put("msg_type", getMsgType());
		this.hashColumns.put("msg_snd_no", getMsgSndNo());
		this.hashColumns.put("msg_img", getMsgImg());
		this.hashColumns.put("type_cd", getTypeCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("edi_rcv_dt", "ediRcvDt");
		this.hashFields.put("by_ofc_cd", "byOfcCd");
		this.hashFields.put("result", "result");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("edi_rcv_seq", "ediRcvSeq");
		this.hashFields.put("by_name", "byName");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("mrn_no", "mrnNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bnd_tp_cd", "bndTpCd");
		this.hashFields.put("rcv_msg", "rcvMsg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("by_id", "byId");
		this.hashFields.put("p_bl_no", "pBlNo");
		this.hashFields.put("p_skd_dir_cd", "pSkdDirCd");
		this.hashFields.put("cstms_port_cd", "cstmsPortCd");
		this.hashFields.put("p_vsl_cd", "pVslCd");
		this.hashFields.put("p_vvd", "pVvd");
		this.hashFields.put("gmt_time", "gmtTime");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("p_skd_voy_no", "pSkdVoyNo");
		this.hashFields.put("p_cstms_port_cd", "pCstmsPortCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("local_time", "localTime");
		this.hashFields.put("msg_type", "msgType");
		this.hashFields.put("msg_snd_no", "msgSndNo");
		this.hashFields.put("msg_img", "msgImg");
		this.hashFields.put("type_cd", "typeCd");
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
	 * @return byOfcCd
	 */
	public String getByOfcCd() {
		return this.byOfcCd;
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
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
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
	 * @return byName
	 */
	public String getByName() {
		return this.byName;
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
	 * @return bndTpCd
	 */
	public String getBndTpCd() {
		return this.bndTpCd;
	}
	
	/**
	 * Column Info
	 * @return rcvMsg
	 */
	public String getRcvMsg() {
		return this.rcvMsg;
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
	 * @return byId
	 */
	public String getById() {
		return this.byId;
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
	 * @return pSkdDirCd
	 */
	public String getPSkdDirCd() {
		return this.pSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsPortCd
	 */
	public String getCstmsPortCd() {
		return this.cstmsPortCd;
	}
	
	/**
	 * Column Info
	 * @return pVslCd
	 */
	public String getPVslCd() {
		return this.pVslCd;
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
	 * @return gmtTime
	 */
	public String getGmtTime() {
		return this.gmtTime;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return pSkdVoyNo
	 */
	public String getPSkdVoyNo() {
		return this.pSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return pCstmsPortCd
	 */
	public String getPCstmsPortCd() {
		return this.pCstmsPortCd;
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
	 * @return localTime
	 */
	public String getLocalTime() {
		return this.localTime;
	}
	
	/**
	 * Column Info
	 * @return msgType
	 */
	public String getMsgType() {
		return this.msgType;
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
	 * @return msgImg
	 */
	public String getMsgImg() {
		return this.msgImg;
	}
	
	/**
	 * Column Info
	 * @return typeCd
	 */
	public String getTypeCd() {
		return this.typeCd;
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
	 * @param byOfcCd
	 */
	public void setByOfcCd(String byOfcCd) {
		this.byOfcCd = byOfcCd;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
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
	 * @param byName
	 */
	public void setByName(String byName) {
		this.byName = byName;
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
	 * @param bndTpCd
	 */
	public void setBndTpCd(String bndTpCd) {
		this.bndTpCd = bndTpCd;
	}
	
	/**
	 * Column Info
	 * @param rcvMsg
	 */
	public void setRcvMsg(String rcvMsg) {
		this.rcvMsg = rcvMsg;
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
	 * @param byId
	 */
	public void setById(String byId) {
		this.byId = byId;
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
	 * @param pSkdDirCd
	 */
	public void setPSkdDirCd(String pSkdDirCd) {
		this.pSkdDirCd = pSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param cstmsPortCd
	 */
	public void setCstmsPortCd(String cstmsPortCd) {
		this.cstmsPortCd = cstmsPortCd;
	}
	
	/**
	 * Column Info
	 * @param pVslCd
	 */
	public void setPVslCd(String pVslCd) {
		this.pVslCd = pVslCd;
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
	 * @param gmtTime
	 */
	public void setGmtTime(String gmtTime) {
		this.gmtTime = gmtTime;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param pSkdVoyNo
	 */
	public void setPSkdVoyNo(String pSkdVoyNo) {
		this.pSkdVoyNo = pSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param pCstmsPortCd
	 */
	public void setPCstmsPortCd(String pCstmsPortCd) {
		this.pCstmsPortCd = pCstmsPortCd;
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
	 * @param localTime
	 */
	public void setLocalTime(String localTime) {
		this.localTime = localTime;
	}
	
	/**
	 * Column Info
	 * @param msgType
	 */
	public void setMsgType(String msgType) {
		this.msgType = msgType;
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
	 * @param msgImg
	 */
	public void setMsgImg(String msgImg) {
		this.msgImg = msgImg;
	}
	
	/**
	 * Column Info
	 * @param typeCd
	 */
	public void setTypeCd(String typeCd) {
		this.typeCd = typeCd;
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
		setByOfcCd(JSPUtil.getParameter(request, prefix + "by_ofc_cd", ""));
		setResult(JSPUtil.getParameter(request, prefix + "result", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setEdiRcvSeq(JSPUtil.getParameter(request, prefix + "edi_rcv_seq", ""));
		setByName(JSPUtil.getParameter(request, prefix + "by_name", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setMrnNo(JSPUtil.getParameter(request, prefix + "mrn_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBndTpCd(JSPUtil.getParameter(request, prefix + "bnd_tp_cd", ""));
		setRcvMsg(JSPUtil.getParameter(request, prefix + "rcv_msg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setById(JSPUtil.getParameter(request, prefix + "by_id", ""));
		setPBlNo(JSPUtil.getParameter(request, prefix + "p_bl_no", ""));
		setPSkdDirCd(JSPUtil.getParameter(request, prefix + "p_skd_dir_cd", ""));
		setCstmsPortCd(JSPUtil.getParameter(request, prefix + "cstms_port_cd", ""));
		setPVslCd(JSPUtil.getParameter(request, prefix + "p_vsl_cd", ""));
		setPVvd(JSPUtil.getParameter(request, prefix + "p_vvd", ""));
		setGmtTime(JSPUtil.getParameter(request, prefix + "gmt_time", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPSkdVoyNo(JSPUtil.getParameter(request, prefix + "p_skd_voy_no", ""));
		setPCstmsPortCd(JSPUtil.getParameter(request, prefix + "p_cstms_port_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setLocalTime(JSPUtil.getParameter(request, prefix + "local_time", ""));
		setMsgType(JSPUtil.getParameter(request, prefix + "msg_type", ""));
		setMsgSndNo(JSPUtil.getParameter(request, prefix + "msg_snd_no", ""));
		setMsgImg(JSPUtil.getParameter(request, prefix + "msg_img", ""));
		setTypeCd(JSPUtil.getParameter(request, prefix + "type_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EU24EDIHistoryOBVO[]
	 */
	public EU24EDIHistoryOBVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EU24EDIHistoryOBVO[]
	 */
	public EU24EDIHistoryOBVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EU24EDIHistoryOBVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ediRcvDt = (JSPUtil.getParameter(request, prefix	+ "edi_rcv_dt", length));
			String[] byOfcCd = (JSPUtil.getParameter(request, prefix	+ "by_ofc_cd", length));
			String[] result = (JSPUtil.getParameter(request, prefix	+ "result", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] ediRcvSeq = (JSPUtil.getParameter(request, prefix	+ "edi_rcv_seq", length));
			String[] byName = (JSPUtil.getParameter(request, prefix	+ "by_name", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] mrnNo = (JSPUtil.getParameter(request, prefix	+ "mrn_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bndTpCd = (JSPUtil.getParameter(request, prefix	+ "bnd_tp_cd", length));
			String[] rcvMsg = (JSPUtil.getParameter(request, prefix	+ "rcv_msg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] byId = (JSPUtil.getParameter(request, prefix	+ "by_id", length));
			String[] pBlNo = (JSPUtil.getParameter(request, prefix	+ "p_bl_no", length));
			String[] pSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "p_skd_dir_cd", length));
			String[] cstmsPortCd = (JSPUtil.getParameter(request, prefix	+ "cstms_port_cd", length));
			String[] pVslCd = (JSPUtil.getParameter(request, prefix	+ "p_vsl_cd", length));
			String[] pVvd = (JSPUtil.getParameter(request, prefix	+ "p_vvd", length));
			String[] gmtTime = (JSPUtil.getParameter(request, prefix	+ "gmt_time", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "p_skd_voy_no", length));
			String[] pCstmsPortCd = (JSPUtil.getParameter(request, prefix	+ "p_cstms_port_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] localTime = (JSPUtil.getParameter(request, prefix	+ "local_time", length));
			String[] msgType = (JSPUtil.getParameter(request, prefix	+ "msg_type", length));
			String[] msgSndNo = (JSPUtil.getParameter(request, prefix	+ "msg_snd_no", length));
			String[] msgImg = (JSPUtil.getParameter(request, prefix	+ "msg_img", length));
			String[] typeCd = (JSPUtil.getParameter(request, prefix	+ "type_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new EU24EDIHistoryOBVO();
				if (ediRcvDt[i] != null)
					model.setEdiRcvDt(ediRcvDt[i]);
				if (byOfcCd[i] != null)
					model.setByOfcCd(byOfcCd[i]);
				if (result[i] != null)
					model.setResult(result[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (ediRcvSeq[i] != null)
					model.setEdiRcvSeq(ediRcvSeq[i]);
				if (byName[i] != null)
					model.setByName(byName[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (mrnNo[i] != null)
					model.setMrnNo(mrnNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bndTpCd[i] != null)
					model.setBndTpCd(bndTpCd[i]);
				if (rcvMsg[i] != null)
					model.setRcvMsg(rcvMsg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (byId[i] != null)
					model.setById(byId[i]);
				if (pBlNo[i] != null)
					model.setPBlNo(pBlNo[i]);
				if (pSkdDirCd[i] != null)
					model.setPSkdDirCd(pSkdDirCd[i]);
				if (cstmsPortCd[i] != null)
					model.setCstmsPortCd(cstmsPortCd[i]);
				if (pVslCd[i] != null)
					model.setPVslCd(pVslCd[i]);
				if (pVvd[i] != null)
					model.setPVvd(pVvd[i]);
				if (gmtTime[i] != null)
					model.setGmtTime(gmtTime[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pSkdVoyNo[i] != null)
					model.setPSkdVoyNo(pSkdVoyNo[i]);
				if (pCstmsPortCd[i] != null)
					model.setPCstmsPortCd(pCstmsPortCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (localTime[i] != null)
					model.setLocalTime(localTime[i]);
				if (msgType[i] != null)
					model.setMsgType(msgType[i]);
				if (msgSndNo[i] != null)
					model.setMsgSndNo(msgSndNo[i]);
				if (msgImg[i] != null)
					model.setMsgImg(msgImg[i]);
				if (typeCd[i] != null)
					model.setTypeCd(typeCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEU24EDIHistoryOBVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EU24EDIHistoryOBVO[]
	 */
	public EU24EDIHistoryOBVO[] getEU24EDIHistoryOBVOs(){
		EU24EDIHistoryOBVO[] vos = (EU24EDIHistoryOBVO[])models.toArray(new EU24EDIHistoryOBVO[models.size()]);
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
		this.byOfcCd = this.byOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.result = this.result .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRcvSeq = this.ediRcvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.byName = this.byName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnNo = this.mrnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bndTpCd = this.bndTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvMsg = this.rcvMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.byId = this.byId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pBlNo = this.pBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pSkdDirCd = this.pSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsPortCd = this.cstmsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pVslCd = this.pVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pVvd = this.pVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gmtTime = this.gmtTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pSkdVoyNo = this.pSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pCstmsPortCd = this.pCstmsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.localTime = this.localTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgType = this.msgType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgSndNo = this.msgSndNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgImg = this.msgImg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.typeCd = this.typeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
