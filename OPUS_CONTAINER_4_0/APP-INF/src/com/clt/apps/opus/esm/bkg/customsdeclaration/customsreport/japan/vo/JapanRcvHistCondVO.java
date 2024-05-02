/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : JapanRcvHistCondVO.java
*@FileTitle : JapanRcvHistCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.13
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2014.03.13 김상수
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.japan.vo;

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
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class JapanRcvHistCondVO extends com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.RcvHistCondVO {

	private static final long serialVersionUID = 1L;

	private Collection<JapanRcvHistCondVO> models = new ArrayList<JapanRcvHistCondVO>();

	/* Column Info */
	private String endRcvDt = null;
	/* Column Info */
	private String startRcvDt = null;
	/* Column Info */
	private String dateCheck = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String errorCheck = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String jpMsgTpCd = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String iPage = null;
	/* Column Info */
	private String inVvdCd = null;
	/* Column Info */
	private String startRcvDt2 = null;
	/* Column Info */
	private String jp24Check = null;
	/* Column Info */
	private String inPodCd = null;
	/* Column Info */
	private String endRcvDt2 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

	public JapanRcvHistCondVO() {}

	public JapanRcvHistCondVO(String ibflag, String pagerows, String errorCheck, String jpMsgTpCd, String jp24Check, String endRcvDt, String usrId, String inVvdCd, String startRcvDt2, String startRcvDt, String inPodCd, String dateCheck, String endRcvDt2, String iPage) {
		this.endRcvDt = endRcvDt;
		this.startRcvDt = startRcvDt;
		this.dateCheck = dateCheck;
		this.pagerows = pagerows;
		this.errorCheck = errorCheck;
		this.ibflag = ibflag;
		this.jpMsgTpCd = jpMsgTpCd;
		this.usrId = usrId;
		this.iPage = iPage;
		this.inVvdCd = inVvdCd;
		this.startRcvDt2 = startRcvDt2;
		this.jp24Check = jp24Check;
		this.inPodCd = inPodCd;
		this.endRcvDt2 = endRcvDt2;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("end_rcv_dt", getEndRcvDt());
		this.hashColumns.put("start_rcv_dt", getStartRcvDt());
		this.hashColumns.put("date_check", getDateCheck());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("error_check", getErrorCheck());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("jp_msg_tp_cd", getJpMsgTpCd());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("i_page", getIPage());
		this.hashColumns.put("in_vvd_cd", getInVvdCd());
		this.hashColumns.put("start_rcv_dt2", getStartRcvDt2());
		this.hashColumns.put("jp24_check", getJp24Check());
		this.hashColumns.put("in_pod_cd", getInPodCd());
		this.hashColumns.put("end_rcv_dt2", getEndRcvDt2());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("end_rcv_dt", "endRcvDt");
		this.hashFields.put("start_rcv_dt", "startRcvDt");
		this.hashFields.put("date_check", "dateCheck");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("error_check", "errorCheck");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("jp_msg_tp_cd", "jpMsgTpCd");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("i_page", "iPage");
		this.hashFields.put("in_vvd_cd", "inVvdCd");
		this.hashFields.put("start_rcv_dt2", "startRcvDt2");
		this.hashFields.put("jp24_check", "jp24Check");
		this.hashFields.put("in_pod_cd", "inPodCd");
		this.hashFields.put("end_rcv_dt2", "endRcvDt2");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return endRcvDt
	 */
	public String getEndRcvDt() {
		return this.endRcvDt;
	}

	/**
	 * Column Info
	 * @return startRcvDt
	 */
	public String getStartRcvDt() {
		return this.startRcvDt;
	}

	/**
	 * Column Info
	 * @return dateCheck
	 */
	public String getDateCheck() {
		return this.dateCheck;
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
	 * @return errorCheck
	 */
	public String getErrorCheck() {
		return this.errorCheck;
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
	 * @return jpMsgTpCd
	 */
	public String getJpMsgTpCd() {
		return this.jpMsgTpCd;
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
	 * @return iPage
	 */
	public String getIPage() {
		return this.iPage;
	}

	/**
	 * Column Info
	 * @return inVvdCd
	 */
	public String getInVvdCd() {
		return this.inVvdCd;
	}

	/**
	 * Column Info
	 * @return startRcvDt2
	 */
	public String getStartRcvDt2() {
		return this.startRcvDt2;
	}

	/**
	 * Column Info
	 * @return jp24Check
	 */
	public String getJp24Check() {
		return this.jp24Check;
	}

	/**
	 * Column Info
	 * @return inPodCd
	 */
	public String getInPodCd() {
		return this.inPodCd;
	}

	/**
	 * Column Info
	 * @return endRcvDt2
	 */
	public String getEndRcvDt2() {
		return this.endRcvDt2;
	}


	/**
	 * Column Info
	 * @param endRcvDt
	 */
	public void setEndRcvDt(String endRcvDt) {
		this.endRcvDt = endRcvDt;
	}

	/**
	 * Column Info
	 * @param startRcvDt
	 */
	public void setStartRcvDt(String startRcvDt) {
		this.startRcvDt = startRcvDt;
	}

	/**
	 * Column Info
	 * @param dateCheck
	 */
	public void setDateCheck(String dateCheck) {
		this.dateCheck = dateCheck;
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
	 * @param errorCheck
	 */
	public void setErrorCheck(String errorCheck) {
		this.errorCheck = errorCheck;
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
	 * @param jpMsgTpCd
	 */
	public void setJpMsgTpCd(String jpMsgTpCd) {
		this.jpMsgTpCd = jpMsgTpCd;
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
	 * @param iPage
	 */
	public void setIPage(String iPage) {
		this.iPage = iPage;
	}

	/**
	 * Column Info
	 * @param inVvdCd
	 */
	public void setInVvdCd(String inVvdCd) {
		this.inVvdCd = inVvdCd;
	}

	/**
	 * Column Info
	 * @param startRcvDt2
	 */
	public void setStartRcvDt2(String startRcvDt2) {
		this.startRcvDt2 = startRcvDt2;
	}

	/**
	 * Column Info
	 * @param jp24Check
	 */
	public void setJp24Check(String jp24Check) {
		this.jp24Check = jp24Check;
	}

	/**
	 * Column Info
	 * @param inPodCd
	 */
	public void setInPodCd(String inPodCd) {
		this.inPodCd = inPodCd;
	}

	/**
	 * Column Info
	 * @param endRcvDt2
	 */
	public void setEndRcvDt2(String endRcvDt2) {
		this.endRcvDt2 = endRcvDt2;
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
		setEndRcvDt(JSPUtil.getParameter(request, prefix + "end_rcv_dt", ""));
		setStartRcvDt(JSPUtil.getParameter(request, prefix + "start_rcv_dt", ""));
		setDateCheck(JSPUtil.getParameter(request, prefix + "date_check", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setErrorCheck(JSPUtil.getParameter(request, prefix + "error_check", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setJpMsgTpCd(JSPUtil.getParameter(request, prefix + "jp_msg_tp_cd", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setIPage(JSPUtil.getParameter(request, prefix + "i_page", ""));
		setInVvdCd(JSPUtil.getParameter(request, prefix + "in_vvd_cd", ""));
		setStartRcvDt2(JSPUtil.getParameter(request, prefix + "start_rcv_dt2", ""));
		setJp24Check(JSPUtil.getParameter(request, prefix + "jp24_check", ""));
		setInPodCd(JSPUtil.getParameter(request, prefix + "in_pod_cd", ""));
		setEndRcvDt2(JSPUtil.getParameter(request, prefix + "end_rcv_dt2", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return JapanRcvHistCondVO[]
	 */
	public JapanRcvHistCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return JapanRcvHistCondVO[]
	 */
	public JapanRcvHistCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		JapanRcvHistCondVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] endRcvDt = (JSPUtil.getParameter(request, prefix	+ "end_rcv_dt", length));
			String[] startRcvDt = (JSPUtil.getParameter(request, prefix	+ "start_rcv_dt", length));
			String[] dateCheck = (JSPUtil.getParameter(request, prefix	+ "date_check", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] errorCheck = (JSPUtil.getParameter(request, prefix	+ "error_check", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] jpMsgTpCd = (JSPUtil.getParameter(request, prefix	+ "jp_msg_tp_cd", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] iPage = (JSPUtil.getParameter(request, prefix	+ "i_page", length));
			String[] inVvdCd = (JSPUtil.getParameter(request, prefix	+ "in_vvd_cd", length));
			String[] startRcvDt2 = (JSPUtil.getParameter(request, prefix	+ "start_rcv_dt2", length));
			String[] jp24Check = (JSPUtil.getParameter(request, prefix	+ "jp24_check", length));
			String[] inPodCd = (JSPUtil.getParameter(request, prefix	+ "in_pod_cd", length));
			String[] endRcvDt2 = (JSPUtil.getParameter(request, prefix	+ "end_rcv_dt2", length));

			for (int i = 0; i < length; i++) {
				model = new JapanRcvHistCondVO();
				if (endRcvDt[i] != null)
					model.setEndRcvDt(endRcvDt[i]);
				if (startRcvDt[i] != null)
					model.setStartRcvDt(startRcvDt[i]);
				if (dateCheck[i] != null)
					model.setDateCheck(dateCheck[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (errorCheck[i] != null)
					model.setErrorCheck(errorCheck[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (jpMsgTpCd[i] != null)
					model.setJpMsgTpCd(jpMsgTpCd[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (iPage[i] != null)
					model.setIPage(iPage[i]);
				if (inVvdCd[i] != null)
					model.setInVvdCd(inVvdCd[i]);
				if (startRcvDt2[i] != null)
					model.setStartRcvDt2(startRcvDt2[i]);
				if (jp24Check[i] != null)
					model.setJp24Check(jp24Check[i]);
				if (inPodCd[i] != null)
					model.setInPodCd(inPodCd[i]);
				if (endRcvDt2[i] != null)
					model.setEndRcvDt2(endRcvDt2[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getJapanRcvHistCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return JapanRcvHistCondVO[]
	 */
	public JapanRcvHistCondVO[] getJapanRcvHistCondVOs(){
		JapanRcvHistCondVO[] vos = (JapanRcvHistCondVO[])models.toArray(new JapanRcvHistCondVO[models.size()]);
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
		this.endRcvDt = this.endRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.startRcvDt = this.startRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateCheck = this.dateCheck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errorCheck = this.errorCheck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jpMsgTpCd = this.jpMsgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iPage = this.iPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVvdCd = this.inVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.startRcvDt2 = this.startRcvDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jp24Check = this.jp24Check .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPodCd = this.inPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endRcvDt2 = this.endRcvDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
