/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AusSendHistoryCondVO.java
*@FileTitle : AusSendHistoryCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.18
*@LastModifier :
*@LastVersion : 1.0
* 2011.10.18
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.vo;

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
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AusSendHistoryCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<AusSendHistoryCondVO> models = new ArrayList<AusSendHistoryCondVO>();

	/* Column Info */
	private String callGubun = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String dType = null;
	/* Column Info */
	private String msgType = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String sndDtTo = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String sndDtFrom = null;
	/* Column Info */
	private String rcvData = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public AusSendHistoryCondVO() {}

	public AusSendHistoryCondVO(String ibflag, String pagerows, String dType, String vvdCd, String portCd, String sndDtFrom, String sndDtTo, String blNo, String cntrNo, String msgType, String callGubun, String rcvData) {
		this.callGubun = callGubun;
		this.ibflag = ibflag;
		this.vvdCd = vvdCd;
		this.cntrNo = cntrNo;
		this.dType = dType;
		this.msgType = msgType;
		this.portCd = portCd;
		this.sndDtTo = sndDtTo;
		this.blNo = blNo;
		this.sndDtFrom = sndDtFrom;
		this.rcvData = rcvData;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("call_gubun", getCallGubun());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("d_type", getDType());
		this.hashColumns.put("msg_type", getMsgType());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("snd_dt_to", getSndDtTo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("snd_dt_from", getSndDtFrom());
		this.hashColumns.put("rcv_data", getRcvData());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("call_gubun", "callGubun");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("d_type", "dType");
		this.hashFields.put("msg_type", "msgType");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("snd_dt_to", "sndDtTo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("snd_dt_from", "sndDtFrom");
		this.hashFields.put("rcv_data", "rcvData");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return callGubun
	 */
	public String getCallGubun() {
		return this.callGubun;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
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
	 * @return dType
	 */
	public String getDType() {
		return this.dType;
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
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}

	/**
	 * Column Info
	 * @return sndDtTo
	 */
	public String getSndDtTo() {
		return this.sndDtTo;
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
	 * @return sndDtFrom
	 */
	public String getSndDtFrom() {
		return this.sndDtFrom;
	}

	/**
	 * Column Info
	 * @return rcvData
	 */
	public String getRcvData() {
		return this.rcvData;
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
	 * @param callGubun
	 */
	public void setCallGubun(String callGubun) {
		this.callGubun = callGubun;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
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
	 * @param dType
	 */
	public void setDType(String dType) {
		this.dType = dType;
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
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}

	/**
	 * Column Info
	 * @param sndDtTo
	 */
	public void setSndDtTo(String sndDtTo) {
		this.sndDtTo = sndDtTo;
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
	 * @param sndDtFrom
	 */
	public void setSndDtFrom(String sndDtFrom) {
		this.sndDtFrom = sndDtFrom;
	}

	/**
	 * Column Info
	 * @param rcvData
	 */
	public void setRcvData(String rcvData) {
		this.rcvData = rcvData;
	}

	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
		setCallGubun(JSPUtil.getParameter(request, prefix + "call_gubun", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setDType(JSPUtil.getParameter(request, prefix + "d_type", ""));
		setMsgType(JSPUtil.getParameter(request, prefix + "msg_type", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setSndDtTo(JSPUtil.getParameter(request, prefix + "snd_dt_to", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setSndDtFrom(JSPUtil.getParameter(request, prefix + "snd_dt_from", ""));
		setRcvData(JSPUtil.getParameter(request, prefix + "rcv_data", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AusSendHistoryCondVO[]
	 */
	public AusSendHistoryCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return AusSendHistoryCondVO[]
	 */
	public AusSendHistoryCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AusSendHistoryCondVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] callGubun = (JSPUtil.getParameter(request, prefix	+ "call_gubun", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] dType = (JSPUtil.getParameter(request, prefix	+ "d_type", length));
			String[] msgType = (JSPUtil.getParameter(request, prefix	+ "msg_type", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] sndDtTo = (JSPUtil.getParameter(request, prefix	+ "snd_dt_to", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] sndDtFrom = (JSPUtil.getParameter(request, prefix	+ "snd_dt_from", length));
			String[] rcvData = (JSPUtil.getParameter(request, prefix	+ "rcv_data", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new AusSendHistoryCondVO();
				if (callGubun[i] != null)
					model.setCallGubun(callGubun[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (dType[i] != null)
					model.setDType(dType[i]);
				if (msgType[i] != null)
					model.setMsgType(msgType[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (sndDtTo[i] != null)
					model.setSndDtTo(sndDtTo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (sndDtFrom[i] != null)
					model.setSndDtFrom(sndDtFrom[i]);
				if (rcvData[i] != null)
					model.setRcvData(rcvData[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAusSendHistoryCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AusSendHistoryCondVO[]
	 */
	public AusSendHistoryCondVO[] getAusSendHistoryCondVOs(){
		AusSendHistoryCondVO[] vos = (AusSendHistoryCondVO[])models.toArray(new AusSendHistoryCondVO[models.size()]);
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
		this.callGubun = this.callGubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dType = this.dType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgType = this.msgType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDtTo = this.sndDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDtFrom = this.sndDtFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvData = this.rcvData .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
