/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FaxEmailSentResultVO.java
*@FileTitle : FaxEmailSentResultVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.14
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.08.14 박정진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박정진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FaxEmailSentResultVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FaxEmailSentResultVO> models = new ArrayList<FaxEmailSentResultVO>();
	
	/* Column Info */
	private String autoInvIssFlg = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String chgAmt = null;
	/* Column Info */
	private String result = null;
	/* Column Info */
	private String blSrcNo = null;
	/* Column Info */
	private String issOfcCd = null;
	/* Column Info */
	private String sndDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String custCode = null;
	/* Column Info */
	private String receivedNo = null;
	/* Column Info */
	private String sentBy = null;
	/* Column Info */
	private String timeSent = null;
	/* Column Info */
	private String timeRequested = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String port = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FaxEmailSentResultVO() {}

	public FaxEmailSentResultVO(String ibflag, String pagerows, String autoInvIssFlg, String currCd, String chgAmt, String issOfcCd, String creUsrId, String sentBy, String result, String invNo, String blSrcNo, String custCode, String vvd, String receivedNo, String timeRequested, String timeSent, String sndDt, String ioBndCd, String port) {
		this.autoInvIssFlg = autoInvIssFlg;
		this.currCd = currCd;
		this.chgAmt = chgAmt;
		this.result = result;
		this.blSrcNo = blSrcNo;
		this.issOfcCd = issOfcCd;
		this.sndDt = sndDt;
		this.pagerows = pagerows;
		this.invNo = invNo;
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.custCode = custCode;
		this.receivedNo = receivedNo;
		this.sentBy = sentBy;
		this.timeSent = timeSent;
		this.timeRequested = timeRequested;
		this.ioBndCd = ioBndCd;
		this.port = port;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("auto_inv_iss_flg", getAutoInvIssFlg());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("chg_amt", getChgAmt());
		this.hashColumns.put("result", getResult());
		this.hashColumns.put("bl_src_no", getBlSrcNo());
		this.hashColumns.put("iss_ofc_cd", getIssOfcCd());
		this.hashColumns.put("snd_dt", getSndDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cust_code", getCustCode());
		this.hashColumns.put("received_no", getReceivedNo());
		this.hashColumns.put("sent_by", getSentBy());
		this.hashColumns.put("time_sent", getTimeSent());
		this.hashColumns.put("time_requested", getTimeRequested());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("port", getPort());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("auto_inv_iss_flg", "autoInvIssFlg");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("result", "result");
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("iss_ofc_cd", "issOfcCd");
		this.hashFields.put("snd_dt", "sndDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cust_code", "custCode");
		this.hashFields.put("received_no", "receivedNo");
		this.hashFields.put("sent_by", "sentBy");
		this.hashFields.put("time_sent", "timeSent");
		this.hashFields.put("time_requested", "timeRequested");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("port", "port");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return autoInvIssFlg
	 */
	public String getAutoInvIssFlg() {
		return this.autoInvIssFlg;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return chgAmt
	 */
	public String getChgAmt() {
		return this.chgAmt;
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
	 * @return blSrcNo
	 */
	public String getBlSrcNo() {
		return this.blSrcNo;
	}
	
	/**
	 * Column Info
	 * @return issOfcCd
	 */
	public String getIssOfcCd() {
		return this.issOfcCd;
	}
	
	/**
	 * Column Info
	 * @return sndDt
	 */
	public String getSndDt() {
		return this.sndDt;
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
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return custCode
	 */
	public String getCustCode() {
		return this.custCode;
	}
	
	/**
	 * Column Info
	 * @return receivedNo
	 */
	public String getReceivedNo() {
		return this.receivedNo;
	}
	
	/**
	 * Column Info
	 * @return sentBy
	 */
	public String getSentBy() {
		return this.sentBy;
	}
	
	/**
	 * Column Info
	 * @return timeSent
	 */
	public String getTimeSent() {
		return this.timeSent;
	}
	
	/**
	 * Column Info
	 * @return timeRequested
	 */
	public String getTimeRequested() {
		return this.timeRequested;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return ioBndCd;
	}

	/**
	 * Column Info
	 * @return autoInvIssFlg
	 */
	public void setAutoInvIssFlg(String autoInvIssFlg) {
		this.autoInvIssFlg = autoInvIssFlg;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @return chgAmt
	 */
	public void setChgAmt(String chgAmt) {
		this.chgAmt = chgAmt;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}

	/**
	 * Column Info
	 * @return port
	 */
	public String getPort() {
		return port;
	}

	/**
	 * Column Info
	 * @return port
	 */
	public void setPort(String port) {
		this.port = port;
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
	 * @param blSrcNo
	 */
	public void setBlSrcNo(String blSrcNo) {
		this.blSrcNo = blSrcNo;
	}
	
	/**
	 * Column Info
	 * @param issOfcCd
	 */
	public void setIssOfcCd(String issOfcCd) {
		this.issOfcCd = issOfcCd;
	}
	
	/**
	 * Column Info
	 * @param sndDt
	 */
	public void setSndDt(String sndDt) {
		this.sndDt = sndDt;
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
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param custCode
	 */
	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}
	
	/**
	 * Column Info
	 * @param receivedNo
	 */
	public void setReceivedNo(String receivedNo) {
		this.receivedNo = receivedNo;
	}
	
	/**
	 * Column Info
	 * @param sentBy
	 */
	public void setSentBy(String sentBy) {
		this.sentBy = sentBy;
	}
	
	/**
	 * Column Info
	 * @param timeSent
	 */
	public void setTimeSent(String timeSent) {
		this.timeSent = timeSent;
	}
	
	/**
	 * Column Info
	 * @param timeRequested
	 */
	public void setTimeRequested(String timeRequested) {
		this.timeRequested = timeRequested;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setAutoInvIssFlg(JSPUtil.getParameter(request, "auto_inv_iss_flg", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setChgAmt(JSPUtil.getParameter(request, "chg_amt", ""));
		setResult(JSPUtil.getParameter(request, "result", ""));
		setBlSrcNo(JSPUtil.getParameter(request, "bl_src_no", ""));
		setIssOfcCd(JSPUtil.getParameter(request, "iss_ofc_cd", ""));
		setSndDt(JSPUtil.getParameter(request, "snd_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setInvNo(JSPUtil.getParameter(request, "inv_no", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setCustCode(JSPUtil.getParameter(request, "cust_code", ""));
		setReceivedNo(JSPUtil.getParameter(request, "received_no", ""));
		setSentBy(JSPUtil.getParameter(request, "sent_by", ""));
		setTimeSent(JSPUtil.getParameter(request, "time_sent", ""));
		setTimeRequested(JSPUtil.getParameter(request, "time_requested", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setPort(JSPUtil.getParameter(request, "port", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FaxEmailSentResultVO[]
	 */
	public FaxEmailSentResultVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FaxEmailSentResultVO[]
	 */
	public FaxEmailSentResultVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FaxEmailSentResultVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] autoInvIssFlg = (JSPUtil.getParameter(request, prefix	+ "auto_inv_iss_flg", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] chgAmt = (JSPUtil.getParameter(request, prefix	+ "chg_amt", length));
			String[] result = (JSPUtil.getParameter(request, prefix	+ "result", length));
			String[] blSrcNo = (JSPUtil.getParameter(request, prefix	+ "bl_src_no", length));
			String[] issOfcCd = (JSPUtil.getParameter(request, prefix	+ "iss_ofc_cd", length));
			String[] sndDt = (JSPUtil.getParameter(request, prefix	+ "snd_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] custCode = (JSPUtil.getParameter(request, prefix	+ "cust_code", length));
			String[] receivedNo = (JSPUtil.getParameter(request, prefix	+ "received_no", length));
			String[] sentBy = (JSPUtil.getParameter(request, prefix	+ "sent_by", length));
			String[] timeSent = (JSPUtil.getParameter(request, prefix	+ "time_sent", length));
			String[] timeRequested = (JSPUtil.getParameter(request, prefix	+ "time_requested", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] port = (JSPUtil.getParameter(request, prefix	+ "port", length));
			
			for (int i = 0; i < length; i++) {
				model = new FaxEmailSentResultVO();
				if (autoInvIssFlg[i] != null)
					model.setAutoInvIssFlg(autoInvIssFlg[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (chgAmt[i] != null)
					model.setChgAmt(chgAmt[i]);
				if (result[i] != null)
					model.setResult(result[i]);
				if (blSrcNo[i] != null)
					model.setBlSrcNo(blSrcNo[i]);
				if (issOfcCd[i] != null)
					model.setIssOfcCd(issOfcCd[i]);
				if (sndDt[i] != null)
					model.setSndDt(sndDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (custCode[i] != null)
					model.setCustCode(custCode[i]);
				if (receivedNo[i] != null)
					model.setReceivedNo(receivedNo[i]);
				if (sentBy[i] != null)
					model.setSentBy(sentBy[i]);
				if (timeSent[i] != null)
					model.setTimeSent(timeSent[i]);
				if (timeRequested[i] != null)
					model.setTimeRequested(timeRequested[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (port[i] != null)
					model.setPort(port[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFaxEmailSentResultVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FaxEmailSentResultVO[]
	 */
	public FaxEmailSentResultVO[] getFaxEmailSentResultVOs(){
		FaxEmailSentResultVO[] vos = (FaxEmailSentResultVO[])models.toArray(new FaxEmailSentResultVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/ 
	public void unDataFormat(){
		this.autoInvIssFlg = this.autoInvIssFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt = this.chgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.result = this.result .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrcNo = this.blSrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issOfcCd = this.issOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDt = this.sndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCode = this.custCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.receivedNo = this.receivedNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sentBy = this.sentBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.timeSent = this.timeSent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.timeRequested = this.timeRequested .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port = this.port .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
