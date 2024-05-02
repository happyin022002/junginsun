/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TransKeyVO.java
*@FileTitle : TransKeyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier :
*@LastVersion : 1.0
* 2009.09.23
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TransKeyVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<TransKeyVO> models = new ArrayList<TransKeyVO>();

	/* Column Info */
	private String blFlag = null;
	/* Column Info */
	private String bkgPolCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String sendDate = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String transMode = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String bkgPodCd = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String msgType = null;
	/* Column Info */
	private String blType = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public TransKeyVO() {}

	public TransKeyVO(String ibflag, String pagerows, String blNo, String transMode, String vvd, String bkgNo, String locCd, String bkgPolCd, String bkgPodCd, String msgType, String blType, String sendDate, String usrId, String ofcCd, String blFlag) {
		this.blFlag = blFlag;
		this.bkgPolCd = bkgPolCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.sendDate = sendDate;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.transMode = transMode;
		this.bkgNo = bkgNo;
		this.locCd = locCd;
		this.bkgPodCd = bkgPodCd;
		this.usrId = usrId;
		this.msgType = msgType;
		this.blType = blType;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bl_flag", getBlFlag());
		this.hashColumns.put("bkg_pol_cd", getBkgPolCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("send_date", getSendDate());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("trans_mode", getTransMode());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("bkg_pod_cd", getBkgPodCd());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("msg_type", getMsgType());
		this.hashColumns.put("bl_type", getBlType());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bl_flag", "blFlag");
		this.hashFields.put("bkg_pol_cd", "bkgPolCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("send_date", "sendDate");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("trans_mode", "transMode");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("bkg_pod_cd", "bkgPodCd");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("msg_type", "msgType");
		this.hashFields.put("bl_type", "blType");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return blFlag
	 */
	public String getBlFlag() {
		return this.blFlag;
	}

	/**
	 * Column Info
	 * @return bkgPolCd
	 */
	public String getBkgPolCd() {
		return this.bkgPolCd;
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
	 * Column Info
	 * @return sendDate
	 */
	public String getSendDate() {
		return this.sendDate;
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
	 * @return transMode
	 */
	public String getTransMode() {
		return this.transMode;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}

	/**
	 * Column Info
	 * @return bkgPodCd
	 */
	public String getBkgPodCd() {
		return this.bkgPodCd;
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
	 * @return msgType
	 */
	public String getMsgType() {
		return this.msgType;
	}

	/**
	 * Column Info
	 * @return blType
	 */
	public String getBlType() {
		return this.blType;
	}


	/**
	 * Column Info
	 * @param blFlag
	 */
	public void setBlFlag(String blFlag) {
		this.blFlag = blFlag;
	}

	/**
	 * Column Info
	 * @param bkgPolCd
	 */
	public void setBkgPolCd(String bkgPolCd) {
		this.bkgPolCd = bkgPolCd;
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
	 * Column Info
	 * @param sendDate
	 */
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
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
	 * @param transMode
	 */
	public void setTransMode(String transMode) {
		this.transMode = transMode;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}

	/**
	 * Column Info
	 * @param bkgPodCd
	 */
	public void setBkgPodCd(String bkgPodCd) {
		this.bkgPodCd = bkgPodCd;
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
	 * @param msgType
	 */
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	/**
	 * Column Info
	 * @param blType
	 */
	public void setBlType(String blType) {
		this.blType = blType;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBlFlag(JSPUtil.getParameter(request, "bl_flag", ""));
		setBkgPolCd(JSPUtil.getParameter(request, "bkg_pol_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setSendDate(JSPUtil.getParameter(request, "send_date", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTransMode(JSPUtil.getParameter(request, "trans_mode", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setBkgPodCd(JSPUtil.getParameter(request, "bkg_pod_cd", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setMsgType(JSPUtil.getParameter(request, "msg_type", ""));
		setBlType(JSPUtil.getParameter(request, "bl_type", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TransKeyVO[]
	 */
	public TransKeyVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return TransKeyVO[]
	 */
	public TransKeyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TransKeyVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] blFlag = (JSPUtil.getParameter(request, prefix	+ "bl_flag", length));
			String[] bkgPolCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pol_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] sendDate = (JSPUtil.getParameter(request, prefix	+ "send_date", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] transMode = (JSPUtil.getParameter(request, prefix	+ "trans_mode", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] bkgPodCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pod_cd", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] msgType = (JSPUtil.getParameter(request, prefix	+ "msg_type", length));
			String[] blType = (JSPUtil.getParameter(request, prefix	+ "bl_type", length));

			for (int i = 0; i < length; i++) {
				model = new TransKeyVO();
				if (blFlag[i] != null)
					model.setBlFlag(blFlag[i]);
				if (bkgPolCd[i] != null)
					model.setBkgPolCd(bkgPolCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (sendDate[i] != null)
					model.setSendDate(sendDate[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (transMode[i] != null)
					model.setTransMode(transMode[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (bkgPodCd[i] != null)
					model.setBkgPodCd(bkgPodCd[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (msgType[i] != null)
					model.setMsgType(msgType[i]);
				if (blType[i] != null)
					model.setBlType(blType[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTransKeyVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TransKeyVO[]
	 */
	public TransKeyVO[] getTransKeyVOs(){
		TransKeyVO[] vos = (TransKeyVO[])models.toArray(new TransKeyVO[models.size()]);
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
		this.blFlag = this.blFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPolCd = this.bkgPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sendDate = this.sendDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transMode = this.transMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPodCd = this.bkgPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgType = this.msgType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blType = this.blType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
