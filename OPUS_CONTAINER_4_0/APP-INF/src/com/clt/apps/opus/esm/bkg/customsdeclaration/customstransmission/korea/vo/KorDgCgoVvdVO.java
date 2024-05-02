/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorDgCgoVvdVO.java
*@FileTitle : KorDgCgoVvdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.28
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.08.28 박상훈
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo;

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
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorDgCgoVvdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<KorDgCgoVvdVO> models = new ArrayList<KorDgCgoVvdVO>();

	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String maxVvdSeq = null;
	/* Column Info */
	private String sndDt = null;
	/* Column Info */
	private String mrnNo = null;
	/* Column Info */
	private String ediSndMsg = null;
	/* Column Info */
	private String transCode = null;
	/* Column Info */
	private String fltFileRefNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public KorDgCgoVvdVO() {}

	public KorDgCgoVvdVO(String ibflag, String pagerows, String userId, String ediSndMsg, String maxVvdSeq, String vvd, String mrnNo, String transCode, String ofcCd, String sndDt, String fltFileRefNo) {
		this.vvd = vvd;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.userId = userId;
		this.maxVvdSeq = maxVvdSeq;
		this.sndDt = sndDt;
		this.mrnNo = mrnNo;
		this.ediSndMsg = ediSndMsg;
		this.transCode = transCode;
		this.fltFileRefNo = fltFileRefNo;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("max_vvd_seq", getMaxVvdSeq());
		this.hashColumns.put("snd_dt", getSndDt());
		this.hashColumns.put("mrn_no", getMrnNo());
		this.hashColumns.put("edi_snd_msg", getEdiSndMsg());
		this.hashColumns.put("trans_code", getTransCode());
		this.hashColumns.put("flt_file_ref_no", getFltFileRefNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("max_vvd_seq", "maxVvdSeq");
		this.hashFields.put("snd_dt", "sndDt");
		this.hashFields.put("mrn_no", "mrnNo");
		this.hashFields.put("edi_snd_msg", "ediSndMsg");
		this.hashFields.put("trans_code", "transCode");
		this.hashFields.put("flt_file_ref_no", "fltFileRefNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	/**
	 * @return the fltFileRefNo
	 */
	public String getFltFileRefNo() {
		return fltFileRefNo;
	}

	/**
	 * @param fltFileRefNo the fltFileRefNo to set
	 */
	public void setFltFileRefNo(String fltFileRefNo) {
		this.fltFileRefNo = fltFileRefNo;
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
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}

	/**
	 * Column Info
	 * @return maxVvdSeq
	 */
	public String getMaxVvdSeq() {
		return this.maxVvdSeq;
	}

	/**
	 * Column Info
	 * @return sndDt
	 */
	public String getSndDt() {
		return this.sndDt;
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
	 * @return ediSndMsg
	 */
	public String getEdiSndMsg() {
		return this.ediSndMsg;
	}

	/**
	 * Column Info
	 * @return transCode
	 */
	public String getTransCode() {
		return this.transCode;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * Column Info
	 * @param maxVvdSeq
	 */
	public void setMaxVvdSeq(String maxVvdSeq) {
		this.maxVvdSeq = maxVvdSeq;
	}

	/**
	 * Column Info
	 * @param sndDt
	 */
	public void setSndDt(String sndDt) {
		this.sndDt = sndDt;
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
	 * @param ediSndMsg
	 */
	public void setEdiSndMsg(String ediSndMsg) {
		this.ediSndMsg = ediSndMsg;
	}

	/**
	 * Column Info
	 * @param transCode
	 */
	public void setTransCode(String transCode) {
		this.transCode = transCode;
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
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setMaxVvdSeq(JSPUtil.getParameter(request, "max_vvd_seq", ""));
		setSndDt(JSPUtil.getParameter(request, "snd_dt", ""));
		setMrnNo(JSPUtil.getParameter(request, "mrn_no", ""));
		setEdiSndMsg(JSPUtil.getParameter(request, "edi_snd_msg", ""));
		setTransCode(JSPUtil.getParameter(request, "trans_code", ""));
		setFltFileRefNo(JSPUtil.getParameter(request, "flt_file_ref_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorDgCgoVvdVO[]
	 */
	public KorDgCgoVvdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return KorDgCgoVvdVO[]
	 */
	public KorDgCgoVvdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorDgCgoVvdVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] maxVvdSeq = (JSPUtil.getParameter(request, prefix	+ "max_vvd_seq", length));
			String[] sndDt = (JSPUtil.getParameter(request, prefix	+ "snd_dt", length));
			String[] mrnNo = (JSPUtil.getParameter(request, prefix	+ "mrn_no", length));
			String[] ediSndMsg = (JSPUtil.getParameter(request, prefix	+ "edi_snd_msg", length));
			String[] transCode = (JSPUtil.getParameter(request, prefix	+ "trans_code", length));
			String[] fltFileRefNo = (JSPUtil.getParameter(request, prefix	+ "flt_file_ref_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new KorDgCgoVvdVO();
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (maxVvdSeq[i] != null)
					model.setMaxVvdSeq(maxVvdSeq[i]);
				if (sndDt[i] != null)
					model.setSndDt(sndDt[i]);
				if (mrnNo[i] != null)
					model.setMrnNo(mrnNo[i]);
				if (ediSndMsg[i] != null)
					model.setEdiSndMsg(ediSndMsg[i]);
				if (transCode[i] != null)
					model.setTransCode(transCode[i]);
				if (fltFileRefNo[i] != null)
					model.setFltFileRefNo(fltFileRefNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorDgCgoVvdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorDgCgoVvdVO[]
	 */
	public KorDgCgoVvdVO[] getKorDgCgoVvdVOs(){
		KorDgCgoVvdVO[] vos = (KorDgCgoVvdVO[])models.toArray(new KorDgCgoVvdVO[models.size()]);
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
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxVvdSeq = this.maxVvdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDt = this.sndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnNo = this.mrnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndMsg = this.ediSndMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transCode = this.transCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fltFileRefNo = this.fltFileRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
