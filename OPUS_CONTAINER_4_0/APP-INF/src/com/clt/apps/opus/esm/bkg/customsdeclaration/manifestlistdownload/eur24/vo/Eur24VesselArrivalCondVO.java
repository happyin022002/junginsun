/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : Eur24VesselArrivalCondVO.java
*@FileTitle : Eur24VesselArrivalCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.10
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2013.09.10 조원주 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalCondVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 조원주
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class Eur24VesselArrivalCondVO extends VesselArrivalCondVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<Eur24VesselArrivalCondVO> models = new ArrayList<Eur24VesselArrivalCondVO>();
	
	/* Column Info */
	private String eurEdiMsgTpId = null;
	/* Column Info */
	private String ediRcvDt = null;
	/* Column Info */
	private String cstmsYdCd = null;
	/* Column Info */
	private String pAckStatus = null;
	/* Column Info */
	private String ediRcvSeq = null;
	/* Column Info */
	private String cvyRefNo = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String chkAll = null;
	/* Column Info */
	private String cstmsPortCd = null;
	/* Column Info */
	private String formBlNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public Eur24VesselArrivalCondVO() {}

	public Eur24VesselArrivalCondVO(String ibflag, String pagerows, String chkAll, String pAckStatus, String eurEdiMsgTpId, String ediRcvDt, String vvd, String cstmsYdCd, String cntrNo, String ediRcvSeq, String cvyRefNo, String blNo, String cstmsPortCd, String formBlNo) {
		this.eurEdiMsgTpId = eurEdiMsgTpId;
		this.ediRcvDt = ediRcvDt;
		this.cstmsYdCd = cstmsYdCd;
		this.pAckStatus = pAckStatus;
		this.ediRcvSeq = ediRcvSeq;
		this.cvyRefNo = cvyRefNo;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.cntrNo = cntrNo;
		this.chkAll = chkAll;
		this.cstmsPortCd = cstmsPortCd;
		this.formBlNo = formBlNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eur_edi_msg_tp_id", getEurEdiMsgTpId());
		this.hashColumns.put("edi_rcv_dt", getEdiRcvDt());
		this.hashColumns.put("cstms_yd_cd", getCstmsYdCd());
		this.hashColumns.put("p_ack_status", getPAckStatus());
		this.hashColumns.put("edi_rcv_seq", getEdiRcvSeq());
		this.hashColumns.put("cvy_ref_no", getCvyRefNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("chk_all", getChkAll());
		this.hashColumns.put("cstms_port_cd", getCstmsPortCd());
		this.hashColumns.put("form_bl_no", getFormBlNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eur_edi_msg_tp_id", "eurEdiMsgTpId");
		this.hashFields.put("edi_rcv_dt", "ediRcvDt");
		this.hashFields.put("cstms_yd_cd", "cstmsYdCd");
		this.hashFields.put("p_ack_status", "pAckStatus");
		this.hashFields.put("edi_rcv_seq", "ediRcvSeq");
		this.hashFields.put("cvy_ref_no", "cvyRefNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("chk_all", "chkAll");
		this.hashFields.put("cstms_port_cd", "cstmsPortCd");
		this.hashFields.put("form_bl_no", "formBlNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return eurEdiMsgTpId
	 */
	public String getEurEdiMsgTpId() {
		return this.eurEdiMsgTpId;
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
	 * @return cstmsYdCd
	 */
	public String getCstmsYdCd() {
		return this.cstmsYdCd;
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
	 * @return ediRcvSeq
	 */
	public String getEdiRcvSeq() {
		return this.ediRcvSeq;
	}
	
	/**
	 * Column Info
	 * @return cvyRefNo
	 */
	public String getCvyRefNo() {
		return this.cvyRefNo;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return chkAll
	 */
	public String getChkAll() {
		return this.chkAll;
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
	 * @return formBlNo
	 */
	public String getFormBlNo() {
		return this.formBlNo;
	}
	

	/**
	 * Column Info
	 * @param eurEdiMsgTpId
	 */
	public void setEurEdiMsgTpId(String eurEdiMsgTpId) {
		this.eurEdiMsgTpId = eurEdiMsgTpId;
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
	 * @param cstmsYdCd
	 */
	public void setCstmsYdCd(String cstmsYdCd) {
		this.cstmsYdCd = cstmsYdCd;
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
	 * @param ediRcvSeq
	 */
	public void setEdiRcvSeq(String ediRcvSeq) {
		this.ediRcvSeq = ediRcvSeq;
	}
	
	/**
	 * Column Info
	 * @param cvyRefNo
	 */
	public void setCvyRefNo(String cvyRefNo) {
		this.cvyRefNo = cvyRefNo;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param chkAll
	 */
	public void setChkAll(String chkAll) {
		this.chkAll = chkAll;
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
	 * @param formBlNo
	 */
	public void setFormBlNo(String formBlNo) {
		this.formBlNo = formBlNo;
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
		setEurEdiMsgTpId(JSPUtil.getParameter(request, prefix + "eur_edi_msg_tp_id", ""));
		setEdiRcvDt(JSPUtil.getParameter(request, prefix + "edi_rcv_dt", ""));
		setCstmsYdCd(JSPUtil.getParameter(request, prefix + "cstms_yd_cd", ""));
		setPAckStatus(JSPUtil.getParameter(request, prefix + "p_ack_status", ""));
		setEdiRcvSeq(JSPUtil.getParameter(request, prefix + "edi_rcv_seq", ""));
		setCvyRefNo(JSPUtil.getParameter(request, prefix + "cvy_ref_no", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setChkAll(JSPUtil.getParameter(request, prefix + "chk_all", ""));
		setCstmsPortCd(JSPUtil.getParameter(request, prefix + "cstms_port_cd", ""));
		setFormBlNo(JSPUtil.getParameter(request, prefix + "form_bl_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Eur24VesselArrivalCondVO[]
	 */
	public Eur24VesselArrivalCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return Eur24VesselArrivalCondVO[]
	 */
	public Eur24VesselArrivalCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Eur24VesselArrivalCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] eurEdiMsgTpId = (JSPUtil.getParameter(request, prefix	+ "eur_edi_msg_tp_id", length));
			String[] ediRcvDt = (JSPUtil.getParameter(request, prefix	+ "edi_rcv_dt", length));
			String[] cstmsYdCd = (JSPUtil.getParameter(request, prefix	+ "cstms_yd_cd", length));
			String[] pAckStatus = (JSPUtil.getParameter(request, prefix	+ "p_ack_status", length));
			String[] ediRcvSeq = (JSPUtil.getParameter(request, prefix	+ "edi_rcv_seq", length));
			String[] cvyRefNo = (JSPUtil.getParameter(request, prefix	+ "cvy_ref_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] chkAll = (JSPUtil.getParameter(request, prefix	+ "chk_all", length));
			String[] cstmsPortCd = (JSPUtil.getParameter(request, prefix	+ "cstms_port_cd", length));
			String[] formBlNo = (JSPUtil.getParameter(request, prefix	+ "form_bl_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new Eur24VesselArrivalCondVO();
				if (eurEdiMsgTpId[i] != null)
					model.setEurEdiMsgTpId(eurEdiMsgTpId[i]);
				if (ediRcvDt[i] != null)
					model.setEdiRcvDt(ediRcvDt[i]);
				if (cstmsYdCd[i] != null)
					model.setCstmsYdCd(cstmsYdCd[i]);
				if (pAckStatus[i] != null)
					model.setPAckStatus(pAckStatus[i]);
				if (ediRcvSeq[i] != null)
					model.setEdiRcvSeq(ediRcvSeq[i]);
				if (cvyRefNo[i] != null)
					model.setCvyRefNo(cvyRefNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (chkAll[i] != null)
					model.setChkAll(chkAll[i]);
				if (cstmsPortCd[i] != null)
					model.setCstmsPortCd(cstmsPortCd[i]);
				if (formBlNo[i] != null)
					model.setFormBlNo(formBlNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEur24VesselArrivalCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Eur24VesselArrivalCondVO[]
	 */
	public Eur24VesselArrivalCondVO[] getEur24VesselArrivalCondVOs(){
		Eur24VesselArrivalCondVO[] vos = (Eur24VesselArrivalCondVO[])models.toArray(new Eur24VesselArrivalCondVO[models.size()]);
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
		this.eurEdiMsgTpId = this.eurEdiMsgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRcvDt = this.ediRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsYdCd = this.cstmsYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pAckStatus = this.pAckStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRcvSeq = this.ediRcvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvyRefNo = this.cvyRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkAll = this.chkAll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsPortCd = this.cstmsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.formBlNo = this.formBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
