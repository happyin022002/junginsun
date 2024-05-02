/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : NewZealandManifestErrorReportVO.java
*@FileTitle : NewZealandManifestErrorReportVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.05  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class NewZealandManifestErrorReportVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<NewZealandManifestErrorReportVO> models = new ArrayList<NewZealandManifestErrorReportVO>();
	
	/* Column Info */
	private String msgAckRslt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ediRcvMsgCtnt = null;
	/* Column Info */
	private String rcvKeyDatCtnt = null;
	/* Column Info */
	private String errCode = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public NewZealandManifestErrorReportVO() {}

	public NewZealandManifestErrorReportVO(String ibflag, String pagerows, String msgAckRslt, String errCode, String ediRcvMsgCtnt, String rcvKeyDatCtnt) {
		this.msgAckRslt = msgAckRslt;
		this.ibflag = ibflag;
		this.ediRcvMsgCtnt = ediRcvMsgCtnt;
		this.rcvKeyDatCtnt = rcvKeyDatCtnt;
		this.errCode = errCode;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("msg_ack_rslt", getMsgAckRslt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("edi_rcv_msg_ctnt", getEdiRcvMsgCtnt());
		this.hashColumns.put("rcv_key_dat_ctnt", getRcvKeyDatCtnt());
		this.hashColumns.put("err_code", getErrCode());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("msg_ack_rslt", "msgAckRslt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("edi_rcv_msg_ctnt", "ediRcvMsgCtnt");
		this.hashFields.put("rcv_key_dat_ctnt", "rcvKeyDatCtnt");
		this.hashFields.put("err_code", "errCode");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return msgAckRslt
	 */
	public String getMsgAckRslt() {
		return this.msgAckRslt;
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
	 * @return ediRcvMsgCtnt
	 */
	public String getEdiRcvMsgCtnt() {
		return this.ediRcvMsgCtnt;
	}
	
	/**
	 * Column Info
	 * @return rcvKeyDatCtnt
	 */
	public String getRcvKeyDatCtnt() {
		return this.rcvKeyDatCtnt;
	}
	
	/**
	 * Column Info
	 * @return errCode
	 */
	public String getErrCode() {
		return this.errCode;
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
	 * @param msgAckRslt
	 */
	public void setMsgAckRslt(String msgAckRslt) {
		this.msgAckRslt = msgAckRslt;
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
	 * @param ediRcvMsgCtnt
	 */
	public void setEdiRcvMsgCtnt(String ediRcvMsgCtnt) {
		this.ediRcvMsgCtnt = ediRcvMsgCtnt;
	}
	
	/**
	 * Column Info
	 * @param rcvKeyDatCtnt
	 */
	public void setRcvKeyDatCtnt(String rcvKeyDatCtnt) {
		this.rcvKeyDatCtnt = rcvKeyDatCtnt;
	}
	
	/**
	 * Column Info
	 * @param errCode
	 */
	public void setErrCode(String errCode) {
		this.errCode = errCode;
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
		setMsgAckRslt(JSPUtil.getParameter(request, prefix + "msg_ack_rslt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEdiRcvMsgCtnt(JSPUtil.getParameter(request, prefix + "edi_rcv_msg_ctnt", ""));
		setRcvKeyDatCtnt(JSPUtil.getParameter(request, prefix + "rcv_key_dat_ctnt", ""));
		setErrCode(JSPUtil.getParameter(request, prefix + "err_code", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return NewZealandManifestErrorReportVO[]
	 */
	public NewZealandManifestErrorReportVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return NewZealandManifestErrorReportVO[]
	 */
	public NewZealandManifestErrorReportVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		NewZealandManifestErrorReportVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] msgAckRslt = (JSPUtil.getParameter(request, prefix	+ "msg_ack_rslt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ediRcvMsgCtnt = (JSPUtil.getParameter(request, prefix	+ "edi_rcv_msg_ctnt", length));
			String[] rcvKeyDatCtnt = (JSPUtil.getParameter(request, prefix	+ "rcv_key_dat_ctnt", length));
			String[] errCode = (JSPUtil.getParameter(request, prefix	+ "err_code", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new NewZealandManifestErrorReportVO();
				if (msgAckRslt[i] != null)
					model.setMsgAckRslt(msgAckRslt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ediRcvMsgCtnt[i] != null)
					model.setEdiRcvMsgCtnt(ediRcvMsgCtnt[i]);
				if (rcvKeyDatCtnt[i] != null)
					model.setRcvKeyDatCtnt(rcvKeyDatCtnt[i]);
				if (errCode[i] != null)
					model.setErrCode(errCode[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getNewZealandManifestErrorReportVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return NewZealandManifestErrorReportVO[]
	 */
	public NewZealandManifestErrorReportVO[] getNewZealandManifestErrorReportVOs(){
		NewZealandManifestErrorReportVO[] vos = (NewZealandManifestErrorReportVO[])models.toArray(new NewZealandManifestErrorReportVO[models.size()]);
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
		this.msgAckRslt = this.msgAckRslt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRcvMsgCtnt = this.ediRcvMsgCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvKeyDatCtnt = this.rcvKeyDatCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errCode = this.errCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
