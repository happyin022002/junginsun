/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JapanTransmitHistCondVO.java
*@FileTitle : JapanTransmitHistCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.29
*@LastModifier :
*@LastVersion : 1.0
* 2009.06.29
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.japan.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.TransmitHistCondVO;
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

public class JapanTransmitHistCondVO extends TransmitHistCondVO {

	private static final long serialVersionUID = 1L;

	private Collection<JapanTransmitHistCondVO> models = new ArrayList<JapanTransmitHistCondVO>();

	/* Column Info */
	private String startSndDt = null;
	/* Column Info */
	private String errorCheck = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String endSndDt2 = null;
	/* Column Info */
	private String endSndDt = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String jpSndLogId = null;
	/* Column Info */
	private String startSndDt2 = null;
	/* Column Info */
	private String dateCheck = null;
	/* Page Number */
	private String pagerows = null;

	private String iPage = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public JapanTransmitHistCondVO() {}

	public JapanTransmitHistCondVO(String ibflag, String pagerows, String jpSndLogId, String vvdCd, String ofcCd, String usrId, String errorCheck, String dateCheck, String startSndDt, String startSndDt2, String endSndDt, String endSndDt2) {
		this.startSndDt = startSndDt;
		this.errorCheck = errorCheck;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.endSndDt2 = endSndDt2;
		this.endSndDt = endSndDt;
		this.vvdCd = vvdCd;
		this.usrId = usrId;
		this.jpSndLogId = jpSndLogId;
		this.startSndDt2 = startSndDt2;
		this.dateCheck = dateCheck;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("start_snd_dt", getStartSndDt());
		this.hashColumns.put("error_check", getErrorCheck());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("end_snd_dt2", getEndSndDt2());
		this.hashColumns.put("end_snd_dt", getEndSndDt());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("jp_snd_log_id", getJpSndLogId());
		this.hashColumns.put("start_snd_dt2", getStartSndDt2());
		this.hashColumns.put("date_check", getDateCheck());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("start_snd_dt", "startSndDt");
		this.hashFields.put("error_check", "errorCheck");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("end_snd_dt2", "endSndDt2");
		this.hashFields.put("end_snd_dt", "endSndDt");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("jp_snd_log_id", "jpSndLogId");
		this.hashFields.put("start_snd_dt2", "startSndDt2");
		this.hashFields.put("date_check", "dateCheck");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return startSndDt
	 */
	public String getStartSndDt() {
		return this.startSndDt;
	}

	/**
	 * Column Info
	 * @return errorCheck
	 */
	public String getErrorCheck() {
		return this.errorCheck;
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
	 * @return endSndDt2
	 */
	public String getEndSndDt2() {
		return this.endSndDt2;
	}

	/**
	 * Column Info
	 * @return endSndDt
	 */
	public String getEndSndDt() {
		return this.endSndDt;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}

	/**
	 * Column Info
	 * @return jpSndLogId
	 */
	public String getJpSndLogId() {
		return this.jpSndLogId;
	}

	/**
	 * Column Info
	 * @return startSndDt2
	 */
	public String getStartSndDt2() {
		return this.startSndDt2;
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

	public String getIPage() {
		return iPage;
	}


	/**
	 * Column Info
	 * @param startSndDt
	 */
	public void setStartSndDt(String startSndDt) {
		this.startSndDt = startSndDt;
	}

	/**
	 * Column Info
	 * @param errorCheck
	 */
	public void setErrorCheck(String errorCheck) {
		this.errorCheck = errorCheck;
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
	 * @param endSndDt2
	 */
	public void setEndSndDt2(String endSndDt2) {
		this.endSndDt2 = endSndDt2;
	}

	/**
	 * Column Info
	 * @param endSndDt
	 */
	public void setEndSndDt(String endSndDt) {
		this.endSndDt = endSndDt;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	/**
	 * Column Info
	 * @param jpSndLogId
	 */
	public void setJpSndLogId(String jpSndLogId) {
		this.jpSndLogId = jpSndLogId;
	}

	/**
	 * Column Info
	 * @param startSndDt2
	 */
	public void setStartSndDt2(String startSndDt2) {
		this.startSndDt2 = startSndDt2;
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

	public void setIPage(String iPage) {
		this.iPage = iPage;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setStartSndDt(JSPUtil.getParameter(request, "start_snd_dt", ""));
		setErrorCheck(JSPUtil.getParameter(request, "error_check", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEndSndDt2(JSPUtil.getParameter(request, "end_snd_dt2", ""));
		setEndSndDt(JSPUtil.getParameter(request, "end_snd_dt", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setJpSndLogId(JSPUtil.getParameter(request, "jp_snd_log_id", ""));
		setStartSndDt2(JSPUtil.getParameter(request, "start_snd_dt2", ""));
		setDateCheck(JSPUtil.getParameter(request, "date_check", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIPage( JSPUtil.getParameter(request, "iPage", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return JapanTransmitHistCondVO[]
	 */
	public JapanTransmitHistCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return JapanTransmitHistCondVO[]
	 */
	public JapanTransmitHistCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		JapanTransmitHistCondVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] startSndDt = (JSPUtil.getParameter(request, prefix	+ "start_snd_dt", length));
			String[] errorCheck = (JSPUtil.getParameter(request, prefix	+ "error_check", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] endSndDt2 = (JSPUtil.getParameter(request, prefix	+ "end_snd_dt2", length));
			String[] endSndDt = (JSPUtil.getParameter(request, prefix	+ "end_snd_dt", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] jpSndLogId = (JSPUtil.getParameter(request, prefix	+ "jp_snd_log_id", length));
			String[] startSndDt2 = (JSPUtil.getParameter(request, prefix	+ "start_snd_dt2", length));
			String[] dateCheck = (JSPUtil.getParameter(request, prefix	+ "date_check", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new JapanTransmitHistCondVO();
				if (startSndDt[i] != null)
					model.setStartSndDt(startSndDt[i]);
				if (errorCheck[i] != null)
					model.setErrorCheck(errorCheck[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (endSndDt2[i] != null)
					model.setEndSndDt2(endSndDt2[i]);
				if (endSndDt[i] != null)
					model.setEndSndDt(endSndDt[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (jpSndLogId[i] != null)
					model.setJpSndLogId(jpSndLogId[i]);
				if (startSndDt2[i] != null)
					model.setStartSndDt2(startSndDt2[i]);
				if (dateCheck[i] != null)
					model.setDateCheck(dateCheck[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getJapanTransmitHistCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return JapanTransmitHistCondVO[]
	 */
	public JapanTransmitHistCondVO[] getJapanTransmitHistCondVOs(){
		JapanTransmitHistCondVO[] vos = (JapanTransmitHistCondVO[])models.toArray(new JapanTransmitHistCondVO[models.size()]);
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
		this.startSndDt = this.startSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errorCheck = this.errorCheck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endSndDt2 = this.endSndDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endSndDt = this.endSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jpSndLogId = this.jpSndLogId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.startSndDt2 = this.startSndDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateCheck = this.dateCheck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
