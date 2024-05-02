/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JapanManifestListTransmitHistDetailVO.java
*@FileTitle : JapanManifestListTransmitHistDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.07  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class JapanManifestListTransmitHistDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<JapanManifestListTransmitHistDetailVO> models = new ArrayList<JapanManifestListTransmitHistDetailVO>();
	
	/* Column Info */
	private String total = null;
	/* Column Info */
	private String rn = null;
	/* Column Info */
	private String sndDt2 = null;
	/* Column Info */
	private String sndDt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String logDt2 = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String logDt = null;
	/* Column Info */
	private String jpSndLogId = null;
	/* Column Info */
	private String logSeq = null;
	/* Column Info */
	private String logFlg = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public JapanManifestListTransmitHistDetailVO() {}

	public JapanManifestListTransmitHistDetailVO(String ibflag, String pagerows, String jpSndLogId, String sndDt, String sndDt2, String ofcCd, String updUsrId, String vvdCd, String podCd, String logFlg, String logDt, String logDt2, String logSeq, String blNo, String rn, String total) {
		this.total = total;
		this.rn = rn;
		this.sndDt2 = sndDt2;
		this.sndDt = sndDt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.logDt2 = logDt2;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.vvdCd = vvdCd;
		this.logDt = logDt;
		this.jpSndLogId = jpSndLogId;
		this.logSeq = logSeq;
		this.logFlg = logFlg;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("total", getTotal());
		this.hashColumns.put("rn", getRn());
		this.hashColumns.put("snd_dt2", getSndDt2());
		this.hashColumns.put("snd_dt", getSndDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("log_dt2", getLogDt2());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("log_dt", getLogDt());
		this.hashColumns.put("jp_snd_log_id", getJpSndLogId());
		this.hashColumns.put("log_seq", getLogSeq());
		this.hashColumns.put("log_flg", getLogFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("total", "total");
		this.hashFields.put("rn", "rn");
		this.hashFields.put("snd_dt2", "sndDt2");
		this.hashFields.put("snd_dt", "sndDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("log_dt2", "logDt2");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("log_dt", "logDt");
		this.hashFields.put("jp_snd_log_id", "jpSndLogId");
		this.hashFields.put("log_seq", "logSeq");
		this.hashFields.put("log_flg", "logFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return total
	 */
	public String getTotal() {
		return this.total;
	}
	
	/**
	 * Column Info
	 * @return rn
	 */
	public String getRn() {
		return this.rn;
	}
	
	/**
	 * Column Info
	 * @return sndDt2
	 */
	public String getSndDt2() {
		return this.sndDt2;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return logDt2
	 */
	public String getLogDt2() {
		return this.logDt2;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return logDt
	 */
	public String getLogDt() {
		return this.logDt;
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
	 * @return logSeq
	 */
	public String getLogSeq() {
		return this.logSeq;
	}
	
	/**
	 * Column Info
	 * @return logFlg
	 */
	public String getLogFlg() {
		return this.logFlg;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	

	/**
	 * Column Info
	 * @param total
	 */
	public void setTotal(String total) {
		this.total = total;
	}
	
	/**
	 * Column Info
	 * @param rn
	 */
	public void setRn(String rn) {
		this.rn = rn;
	}
	
	/**
	 * Column Info
	 * @param sndDt2
	 */
	public void setSndDt2(String sndDt2) {
		this.sndDt2 = sndDt2;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param logDt2
	 */
	public void setLogDt2(String logDt2) {
		this.logDt2 = logDt2;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param logDt
	 */
	public void setLogDt(String logDt) {
		this.logDt = logDt;
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
	 * @param logSeq
	 */
	public void setLogSeq(String logSeq) {
		this.logSeq = logSeq;
	}
	
	/**
	 * Column Info
	 * @param logFlg
	 */
	public void setLogFlg(String logFlg) {
		this.logFlg = logFlg;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTotal(JSPUtil.getParameter(request, "total", ""));
		setRn(JSPUtil.getParameter(request, "rn", ""));
		setSndDt2(JSPUtil.getParameter(request, "snd_dt2", ""));
		setSndDt(JSPUtil.getParameter(request, "snd_dt", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setLogDt2(JSPUtil.getParameter(request, "log_dt2", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setLogDt(JSPUtil.getParameter(request, "log_dt", ""));
		setJpSndLogId(JSPUtil.getParameter(request, "jp_snd_log_id", ""));
		setLogSeq(JSPUtil.getParameter(request, "log_seq", ""));
		setLogFlg(JSPUtil.getParameter(request, "log_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return JapanManifestListTransmitHistDetailVO[]
	 */
	public JapanManifestListTransmitHistDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return JapanManifestListTransmitHistDetailVO[]
	 */
	public JapanManifestListTransmitHistDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		JapanManifestListTransmitHistDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] total = (JSPUtil.getParameter(request, prefix	+ "total", length));
			String[] rn = (JSPUtil.getParameter(request, prefix	+ "rn", length));
			String[] sndDt2 = (JSPUtil.getParameter(request, prefix	+ "snd_dt2", length));
			String[] sndDt = (JSPUtil.getParameter(request, prefix	+ "snd_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] logDt2 = (JSPUtil.getParameter(request, prefix	+ "log_dt2", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] logDt = (JSPUtil.getParameter(request, prefix	+ "log_dt", length));
			String[] jpSndLogId = (JSPUtil.getParameter(request, prefix	+ "jp_snd_log_id", length));
			String[] logSeq = (JSPUtil.getParameter(request, prefix	+ "log_seq", length));
			String[] logFlg = (JSPUtil.getParameter(request, prefix	+ "log_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new JapanManifestListTransmitHistDetailVO();
				if (total[i] != null)
					model.setTotal(total[i]);
				if (rn[i] != null)
					model.setRn(rn[i]);
				if (sndDt2[i] != null)
					model.setSndDt2(sndDt2[i]);
				if (sndDt[i] != null)
					model.setSndDt(sndDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (logDt2[i] != null)
					model.setLogDt2(logDt2[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (logDt[i] != null)
					model.setLogDt(logDt[i]);
				if (jpSndLogId[i] != null)
					model.setJpSndLogId(jpSndLogId[i]);
				if (logSeq[i] != null)
					model.setLogSeq(logSeq[i]);
				if (logFlg[i] != null)
					model.setLogFlg(logFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getJapanManifestListTransmitHistDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return JapanManifestListTransmitHistDetailVO[]
	 */
	public JapanManifestListTransmitHistDetailVO[] getJapanManifestListTransmitHistDetailVOs(){
		JapanManifestListTransmitHistDetailVO[] vos = (JapanManifestListTransmitHistDetailVO[])models.toArray(new JapanManifestListTransmitHistDetailVO[models.size()]);
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
		this.total = this.total .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rn = this.rn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDt2 = this.sndDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDt = this.sndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.logDt2 = this.logDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.logDt = this.logDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jpSndLogId = this.jpSndLogId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.logSeq = this.logSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.logFlg = this.logFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
