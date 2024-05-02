/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorTransmitHistDtlCondVO.java
*@FileTitle : KorTransmitHistDtlCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.15
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.07.15 박상훈
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.TransmitHistDtlCondVO;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorTransmitHistDtlCondVO extends TransmitHistDtlCondVO {

	private static final long serialVersionUID = 1L;

	private Collection<KorTransmitHistDtlCondVO> models = new ArrayList<KorTransmitHistDtlCondVO>();

	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sndDt = null;
	/* Column Info */
	private String msgLogTpId = null;
	/* Column Info */
	private String mfSndSeq = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public KorTransmitHistDtlCondVO() {}

	public KorTransmitHistDtlCondVO(String ibflag, String pagerows, String msgLogTpId, String sndDt, String ofcCd, String mfSndSeq) {
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.sndDt = sndDt;
		this.msgLogTpId = msgLogTpId;
		this.pagerows = pagerows;
		this.mfSndSeq = mfSndSeq;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("snd_dt", getSndDt());
		this.hashColumns.put("msg_log_tp_id", getMsgLogTpId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mf_snd_seq", getMfSndSeq());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("snd_dt", "sndDt");
		this.hashFields.put("msg_log_tp_id", "msgLogTpId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mf_snd_seq", "mfSndSeq");
		return this.hashFields;
	}

	/**
	 * @return the mfSndSeq
	 */
	public String getMfSndSeq() {
		return mfSndSeq;
	}

	/**
	 * @param mfSndSeq the mfSndSeq to set
	 */
	public void setMfSndSeq(String mfSndSeq) {
		this.mfSndSeq = mfSndSeq;
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
	 * @return sndDt
	 */
	public String getSndDt() {
		return this.sndDt;
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
	 * @param sndDt
	 */
	public void setSndDt(String sndDt) {
		this.sndDt = sndDt;
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
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSndDt(JSPUtil.getParameter(request, "snd_dt", ""));
		setMsgLogTpId(JSPUtil.getParameter(request, "msg_log_tp_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setMfSndSeq(JSPUtil.getParameter(request, "mf_snd_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorTransmitHistDtlCondVO[]
	 */
	public KorTransmitHistDtlCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return KorTransmitHistDtlCondVO[]
	 */
	public KorTransmitHistDtlCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorTransmitHistDtlCondVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sndDt = (JSPUtil.getParameter(request, prefix	+ "snd_dt", length));
			String[] msgLogTpId = (JSPUtil.getParameter(request, prefix	+ "msg_log_tp_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mfSndSeq = (JSPUtil.getParameter(request, prefix	+ "mf_snd_seq", length));

			for (int i = 0; i < length; i++) {
				model = new KorTransmitHistDtlCondVO();
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sndDt[i] != null)
					model.setSndDt(sndDt[i]);
				if (msgLogTpId[i] != null)
					model.setMsgLogTpId(msgLogTpId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mfSndSeq[i] != null)
					model.setMfSndSeq(mfSndSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorTransmitHistDtlCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorTransmitHistDtlCondVO[]
	 */
	public KorTransmitHistDtlCondVO[] getKorTransmitHistDtlCondVOs(){
		KorTransmitHistDtlCondVO[] vos = (KorTransmitHistDtlCondVO[])models.toArray(new KorTransmitHistDtlCondVO[models.size()]);
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
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDt = this.sndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgLogTpId = this.msgLogTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfSndSeq = this.mfSndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
