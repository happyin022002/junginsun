/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorMrnVslSysEtaEtdVO.java
*@FileTitle : KorMrnVslSysEtaEtdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.01
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.12.01 박상훈
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo;

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
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorMrnVslSysEtaEtdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<KorMrnVslSysEtaEtdVO> models = new ArrayList<KorMrnVslSysEtaEtdVO>();

	/* Column Info */
	private String inVvd = null;
	/* Column Info */
	private String inPod = null;
	/* Column Info */
	private String mrnChkNo = null;
	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String vslFlag = null;
	/* Column Info */
	private String inBound = null;
	/* Column Info */
	private String inPol = null;
	/* Column Info */
	private String etdDt = null;
	/* Column Info */
	private String mrnNo = null;
	/* Column Info */
	private String actionTime = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vslCallSign = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String curdate = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public KorMrnVslSysEtaEtdVO() {}

	public KorMrnVslSysEtaEtdVO(String ibflag, String pagerows, String mrnNo, String mrnChkNo, String actionTime, String etaDt, String etdDt, String vslFlag, String vslEngNm, String vslCallSign, String curdate, String inVvd, String inBound, String inPol, String inPod) {
		this.inVvd = inVvd;
		this.inPod = inPod;
		this.mrnChkNo = mrnChkNo;
		this.etaDt = etaDt;
		this.vslFlag = vslFlag;
		this.inBound = inBound;
		this.inPol = inPol;
		this.etdDt = etdDt;
		this.mrnNo = mrnNo;
		this.actionTime = actionTime;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.vslCallSign = vslCallSign;
		this.vslEngNm = vslEngNm;
		this.curdate = curdate;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("in_vvd", getInVvd());
		this.hashColumns.put("in_pod", getInPod());
		this.hashColumns.put("mrn_chk_no", getMrnChkNo());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("vsl_flag", getVslFlag());
		this.hashColumns.put("in_bound", getInBound());
		this.hashColumns.put("in_pol", getInPol());
		this.hashColumns.put("etd_dt", getEtdDt());
		this.hashColumns.put("mrn_no", getMrnNo());
		this.hashColumns.put("action_time", getActionTime());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_call_sign", getVslCallSign());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("curdate", getCurdate());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("in_vvd", "inVvd");
		this.hashFields.put("in_pod", "inPod");
		this.hashFields.put("mrn_chk_no", "mrnChkNo");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("vsl_flag", "vslFlag");
		this.hashFields.put("in_bound", "inBound");
		this.hashFields.put("in_pol", "inPol");
		this.hashFields.put("etd_dt", "etdDt");
		this.hashFields.put("mrn_no", "mrnNo");
		this.hashFields.put("action_time", "actionTime");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_call_sign", "vslCallSign");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("curdate", "curdate");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return inVvd
	 */
	public String getInVvd() {
		return this.inVvd;
	}

	/**
	 * Column Info
	 * @return inPod
	 */
	public String getInPod() {
		return this.inPod;
	}

	/**
	 * Column Info
	 * @return mrnChkNo
	 */
	public String getMrnChkNo() {
		return this.mrnChkNo;
	}

	/**
	 * Column Info
	 * @return etaDt
	 */
	public String getEtaDt() {
		return this.etaDt;
	}

	/**
	 * Column Info
	 * @return vslFlag
	 */
	public String getVslFlag() {
		return this.vslFlag;
	}

	/**
	 * Column Info
	 * @return inBound
	 */
	public String getInBound() {
		return this.inBound;
	}

	/**
	 * Column Info
	 * @return inPol
	 */
	public String getInPol() {
		return this.inPol;
	}

	/**
	 * Column Info
	 * @return etdDt
	 */
	public String getEtdDt() {
		return this.etdDt;
	}

	/**
	 * Column Info
	 * @return mrnNo
	 */
	public String getMrnNo() {
		return this.mrnNo;
	}

	/**
	 * Column Info
	 * @return actionTime
	 */
	public String getActionTime() {
		return this.actionTime;
	}

	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return vslCallSign
	 */
	public String getVslCallSign() {
		return this.vslCallSign;
	}

	/**
	 * Column Info
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
	}

	/**
	 * Column Info
	 * @return curdate
	 */
	public String getCurdate() {
		return this.curdate;
	}


	/**
	 * Column Info
	 * @param inVvd
	 */
	public void setInVvd(String inVvd) {
		this.inVvd = inVvd;
	}

	/**
	 * Column Info
	 * @param inPod
	 */
	public void setInPod(String inPod) {
		this.inPod = inPod;
	}

	/**
	 * Column Info
	 * @param mrnChkNo
	 */
	public void setMrnChkNo(String mrnChkNo) {
		this.mrnChkNo = mrnChkNo;
	}

	/**
	 * Column Info
	 * @param etaDt
	 */
	public void setEtaDt(String etaDt) {
		this.etaDt = etaDt;
	}

	/**
	 * Column Info
	 * @param vslFlag
	 */
	public void setVslFlag(String vslFlag) {
		this.vslFlag = vslFlag;
	}

	/**
	 * Column Info
	 * @param inBound
	 */
	public void setInBound(String inBound) {
		this.inBound = inBound;
	}

	/**
	 * Column Info
	 * @param inPol
	 */
	public void setInPol(String inPol) {
		this.inPol = inPol;
	}

	/**
	 * Column Info
	 * @param etdDt
	 */
	public void setEtdDt(String etdDt) {
		this.etdDt = etdDt;
	}

	/**
	 * Column Info
	 * @param mrnNo
	 */
	public void setMrnNo(String mrnNo) {
		this.mrnNo = mrnNo;
	}

	/**
	 * Column Info
	 * @param actionTime
	 */
	public void setActionTime(String actionTime) {
		this.actionTime = actionTime;
	}

	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param vslCallSign
	 */
	public void setVslCallSign(String vslCallSign) {
		this.vslCallSign = vslCallSign;
	}

	/**
	 * Column Info
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}

	/**
	 * Column Info
	 * @param curdate
	 */
	public void setCurdate(String curdate) {
		this.curdate = curdate;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setInVvd(JSPUtil.getParameter(request, "in_vvd", ""));
		setInPod(JSPUtil.getParameter(request, "in_pod", ""));
		setMrnChkNo(JSPUtil.getParameter(request, "mrn_chk_no", ""));
		setEtaDt(JSPUtil.getParameter(request, "eta_dt", ""));
		setVslFlag(JSPUtil.getParameter(request, "vsl_flag", ""));
		setInBound(JSPUtil.getParameter(request, "in_bound", ""));
		setInPol(JSPUtil.getParameter(request, "in_pol", ""));
		setEtdDt(JSPUtil.getParameter(request, "etd_dt", ""));
		setMrnNo(JSPUtil.getParameter(request, "mrn_no", ""));
		setActionTime(JSPUtil.getParameter(request, "action_time", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVslCallSign(JSPUtil.getParameter(request, "vsl_call_sign", ""));
		setVslEngNm(JSPUtil.getParameter(request, "vsl_eng_nm", ""));
		setCurdate(JSPUtil.getParameter(request, "curdate", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorMrnVslSysEtaEtdVO[]
	 */
	public KorMrnVslSysEtaEtdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return KorMrnVslSysEtaEtdVO[]
	 */
	public KorMrnVslSysEtaEtdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorMrnVslSysEtaEtdVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] inVvd = (JSPUtil.getParameter(request, prefix	+ "in_vvd", length));
			String[] inPod = (JSPUtil.getParameter(request, prefix	+ "in_pod", length));
			String[] mrnChkNo = (JSPUtil.getParameter(request, prefix	+ "mrn_chk_no", length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] vslFlag = (JSPUtil.getParameter(request, prefix	+ "vsl_flag", length));
			String[] inBound = (JSPUtil.getParameter(request, prefix	+ "in_bound", length));
			String[] inPol = (JSPUtil.getParameter(request, prefix	+ "in_pol", length));
			String[] etdDt = (JSPUtil.getParameter(request, prefix	+ "etd_dt", length));
			String[] mrnNo = (JSPUtil.getParameter(request, prefix	+ "mrn_no", length));
			String[] actionTime = (JSPUtil.getParameter(request, prefix	+ "action_time", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vslCallSign = (JSPUtil.getParameter(request, prefix	+ "vsl_call_sign", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] curdate = (JSPUtil.getParameter(request, prefix	+ "curdate", length));

			for (int i = 0; i < length; i++) {
				model = new KorMrnVslSysEtaEtdVO();
				if (inVvd[i] != null)
					model.setInVvd(inVvd[i]);
				if (inPod[i] != null)
					model.setInPod(inPod[i]);
				if (mrnChkNo[i] != null)
					model.setMrnChkNo(mrnChkNo[i]);
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (vslFlag[i] != null)
					model.setVslFlag(vslFlag[i]);
				if (inBound[i] != null)
					model.setInBound(inBound[i]);
				if (inPol[i] != null)
					model.setInPol(inPol[i]);
				if (etdDt[i] != null)
					model.setEtdDt(etdDt[i]);
				if (mrnNo[i] != null)
					model.setMrnNo(mrnNo[i]);
				if (actionTime[i] != null)
					model.setActionTime(actionTime[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslCallSign[i] != null)
					model.setVslCallSign(vslCallSign[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (curdate[i] != null)
					model.setCurdate(curdate[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorMrnVslSysEtaEtdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorMrnVslSysEtaEtdVO[]
	 */
	public KorMrnVslSysEtaEtdVO[] getKorMrnVslSysEtaEtdVOs(){
		KorMrnVslSysEtaEtdVO[] vos = (KorMrnVslSysEtaEtdVO[])models.toArray(new KorMrnVslSysEtaEtdVO[models.size()]);
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
		this.inVvd = this.inVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPod = this.inPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnChkNo = this.mrnChkNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslFlag = this.vslFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inBound = this.inBound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPol = this.inPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDt = this.etdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnNo = this.mrnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actionTime = this.actionTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCallSign = this.vslCallSign .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.curdate = this.curdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
