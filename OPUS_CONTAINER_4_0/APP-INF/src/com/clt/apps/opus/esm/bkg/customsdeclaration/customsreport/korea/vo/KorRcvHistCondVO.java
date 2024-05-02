/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorRcvHistCondVO.java
*@FileTitle : KorRcvHistCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.10.14 박상훈
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.RcvHistCondVO;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박상훈
 * @since J2EE 1.6
 * @see RcvHistCondVO
 */

public class KorRcvHistCondVO extends RcvHistCondVO {

	private static final long serialVersionUID = 1L;

	private Collection<KorRcvHistCondVO> models = new ArrayList<KorRcvHistCondVO>();

	/* Column Info */
	private String fromDt = null;
	/* Column Info */
	private String smtNo = null;
	/* Column Info */
	private String searchType = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String msgLogTpId = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String tpCd = null;
	/* Column Info */
	private String cboMsgTp = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public KorRcvHistCondVO() {}

	public KorRcvHistCondVO(String ibflag, String pagerows, String vvd, String blNo, String smtNo, String msgLogTpId, String tpCd, String polCd, String podCd, String ofcCd, String userId, String fromDt, String toDt, String searchType, String cboMsgTp) {
		this.fromDt = fromDt;
		this.smtNo = smtNo;
		this.searchType = searchType;
		this.blNo = blNo;
		this.msgLogTpId = msgLogTpId;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.podCd = podCd;
		this.toDt = toDt;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.userId = userId;
		this.tpCd = tpCd;
		this.cboMsgTp = cboMsgTp;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("from_dt", getFromDt());
		this.hashColumns.put("smt_no", getSmtNo());
		this.hashColumns.put("search_type", getSearchType());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("msg_log_tp_id", getMsgLogTpId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("tp_cd", getTpCd());
		this.hashColumns.put("cboMsgTp", getCboMsgTp());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("from_dt", "fromDt");
		this.hashFields.put("smt_no", "smtNo");
		this.hashFields.put("search_type", "searchType");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("msg_log_tp_id", "msgLogTpId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("tp_cd", "tpCd");
		this.hashFields.put("cboMsgTp", "cboMsgTp");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return fromDt
	 */
	public String getFromDt() {
		return this.fromDt;
	}

	/**
	 * Column Info
	 * @return smtNo
	 */
	public String getSmtNo() {
		return this.smtNo;
	}

	/**
	 * Column Info
	 * @return searchType
	 */
	public String getSearchType() {
		return this.searchType;
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
	 * @return msgLogTpId
	 */
	public String getMsgLogTpId() {
		return this.msgLogTpId;
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
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}

	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}

	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}

	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}

	/**
	 * Column Info
	 * @return tpCd
	 */
	public String getTpCd() {
		return this.tpCd;
	}

	/**
	 * Column Info
	 * @return cboMsgTp
	 */
	public String getCboMsgTp() {
		return this.cboMsgTp;
	}


	/**
	 * Column Info
	 * @param fromDt
	 */
	public void setFromDt(String fromDt) {
		this.fromDt = fromDt;
	}

	/**
	 * Column Info
	 * @param smtNo
	 */
	public void setSmtNo(String smtNo) {
		this.smtNo = smtNo;
	}

	/**
	 * Column Info
	 * @param searchType
	 */
	public void setSearchType(String searchType) {
		this.searchType = searchType;
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
	 * @param msgLogTpId
	 */
	public void setMsgLogTpId(String msgLogTpId) {
		this.msgLogTpId = msgLogTpId;
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
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}

	/**
	 * Column Info
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}

	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}

	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * Column Info
	 * @param tpCd
	 */
	public void setTpCd(String tpCd) {
		this.tpCd = tpCd;
	}

	/**
	 * Column Info
	 * @param cboMsgTp
	 */
	public void setCboMsgTp(String cboMsgTp) {
		this.cboMsgTp = cboMsgTp;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFromDt(JSPUtil.getParameter(request, "from_dt", ""));
		setSmtNo(JSPUtil.getParameter(request, "smt_no", ""));
		setSearchType(JSPUtil.getParameter(request, "search_type", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setMsgLogTpId(JSPUtil.getParameter(request, "msg_log_tp_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setToDt(JSPUtil.getParameter(request, "to_dt", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setTpCd(JSPUtil.getParameter(request, "tp_cd", ""));
		setCboMsgTp(JSPUtil.getParameter(request, "cboMsgTp", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorRcvHistCondVO[]
	 */
	public KorRcvHistCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return KorRcvHistCondVO[]
	 */
	public KorRcvHistCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorRcvHistCondVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] fromDt = (JSPUtil.getParameter(request, prefix	+ "from_dt", length));
			String[] smtNo = (JSPUtil.getParameter(request, prefix	+ "smt_no", length));
			String[] searchType = (JSPUtil.getParameter(request, prefix	+ "search_type", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] msgLogTpId = (JSPUtil.getParameter(request, prefix	+ "msg_log_tp_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] tpCd = (JSPUtil.getParameter(request, prefix	+ "tp_cd", length));
			String[] cboMsgTp = (JSPUtil.getParameter(request, prefix	+ "cboMsgTp", length));

			for (int i = 0; i < length; i++) {
				model = new KorRcvHistCondVO();
				if (fromDt[i] != null)
					model.setFromDt(fromDt[i]);
				if (smtNo[i] != null)
					model.setSmtNo(smtNo[i]);
				if (searchType[i] != null)
					model.setSearchType(searchType[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (msgLogTpId[i] != null)
					model.setMsgLogTpId(msgLogTpId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (tpCd[i] != null)
					model.setTpCd(tpCd[i]);
				if (cboMsgTp[i] != null)
					model.setCboMsgTp(cboMsgTp[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorRcvHistCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorRcvHistCondVO[]
	 */
	public KorRcvHistCondVO[] getKorRcvHistCondVOs(){
		KorRcvHistCondVO[] vos = (KorRcvHistCondVO[])models.toArray(new KorRcvHistCondVO[models.size()]);
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
		this.fromDt = this.fromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smtNo = this.smtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchType = this.searchType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgLogTpId = this.msgLogTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpCd = this.tpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cboMsgTp = this.cboMsgTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
