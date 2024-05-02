/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorMrnInfoVO.java
*@FileTitle : KorMrnInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.07.03 박상훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo;

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
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorMrnInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorMrnInfoVO> models = new ArrayList<KorMrnInfoVO>();
	
	/* Column Info */
	private String inMrnMode = null;
	/* Column Info */
	private String mrnChkNo = null;
	/* Column Info */
	private String inSkdDirCd = null;
	/* Column Info */
	private String rsltDt = null;
	/* Column Info */
	private String rslt = null;
	/* Column Info */
	private String inVslCd = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String sndDt = null;
	/* Column Info */
	private String inSkdVoyageNo = null;
	/* Column Info */
	private String mrnNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sendInd = null;
	/* Column Info */
	private String inPort = null;
	/* Column Info */
	private String errMsg = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String inMrnNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KorMrnInfoVO() {}

	public KorMrnInfoVO(String ibflag, String pagerows, String mrnNo, String mrnChkNo, String vvd, String portCd, String ioBndCd, String sndDt, String rsltDt, String rslt, String errMsg, String sendInd, String inVslCd, String inSkdVoyageNo, String inSkdDirCd, String inPort, String inMrnMode, String inMrnNo) {
		this.inMrnMode = inMrnMode;
		this.mrnChkNo = mrnChkNo;
		this.inSkdDirCd = inSkdDirCd;
		this.rsltDt = rsltDt;
		this.rslt = rslt;
		this.inVslCd = inVslCd;
		this.ioBndCd = ioBndCd;
		this.sndDt = sndDt;
		this.inSkdVoyageNo = inSkdVoyageNo;
		this.mrnNo = mrnNo;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.sendInd = sendInd;
		this.inPort = inPort;
		this.errMsg = errMsg;
		this.portCd = portCd;
		this.inMrnNo = inMrnNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("in_mrn_mode", getInMrnMode());
		this.hashColumns.put("mrn_chk_no", getMrnChkNo());
		this.hashColumns.put("in_skd_dir_cd", getInSkdDirCd());
		this.hashColumns.put("rslt_dt", getRsltDt());
		this.hashColumns.put("rslt", getRslt());
		this.hashColumns.put("in_vsl_cd", getInVslCd());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("snd_dt", getSndDt());
		this.hashColumns.put("in_skd_voyage_no", getInSkdVoyageNo());
		this.hashColumns.put("mrn_no", getMrnNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("send_ind", getSendInd());
		this.hashColumns.put("in_port", getInPort());
		this.hashColumns.put("err_msg", getErrMsg());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("in_mrn_no", getInMrnNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("in_mrn_mode", "inMrnMode");
		this.hashFields.put("mrn_chk_no", "mrnChkNo");
		this.hashFields.put("in_skd_dir_cd", "inSkdDirCd");
		this.hashFields.put("rslt_dt", "rsltDt");
		this.hashFields.put("rslt", "rslt");
		this.hashFields.put("in_vsl_cd", "inVslCd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("snd_dt", "sndDt");
		this.hashFields.put("in_skd_voyage_no", "inSkdVoyageNo");
		this.hashFields.put("mrn_no", "mrnNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("send_ind", "sendInd");
		this.hashFields.put("in_port", "inPort");
		this.hashFields.put("err_msg", "errMsg");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("in_mrn_no", "inMrnNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return inMrnMode
	 */
	public String getInMrnMode() {
		return this.inMrnMode;
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
	 * @return inSkdDirCd
	 */
	public String getInSkdDirCd() {
		return this.inSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return rsltDt
	 */
	public String getRsltDt() {
		return this.rsltDt;
	}
	
	/**
	 * Column Info
	 * @return rslt
	 */
	public String getRslt() {
		return this.rslt;
	}
	
	/**
	 * Column Info
	 * @return inVslCd
	 */
	public String getInVslCd() {
		return this.inVslCd;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
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
	 * @return inSkdVoyageNo
	 */
	public String getInSkdVoyageNo() {
		return this.inSkdVoyageNo;
	}
	
	/**
	 * Column Info
	 * @return mrnNo
	 */
	public String getMrnNo() {
		return this.mrnNo;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return sendInd
	 */
	public String getSendInd() {
		return this.sendInd;
	}
	
	/**
	 * Column Info
	 * @return inPort
	 */
	public String getInPort() {
		return this.inPort;
	}
	
	/**
	 * Column Info
	 * @return errMsg
	 */
	public String getErrMsg() {
		return this.errMsg;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return inMrnNo
	 */
	public String getInMrnNo() {
		return this.inMrnNo;
	}
	

	/**
	 * Column Info
	 * @param inMrnMode
	 */
	public void setInMrnMode(String inMrnMode) {
		this.inMrnMode = inMrnMode;
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
	 * @param inSkdDirCd
	 */
	public void setInSkdDirCd(String inSkdDirCd) {
		this.inSkdDirCd = inSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param rsltDt
	 */
	public void setRsltDt(String rsltDt) {
		this.rsltDt = rsltDt;
	}
	
	/**
	 * Column Info
	 * @param rslt
	 */
	public void setRslt(String rslt) {
		this.rslt = rslt;
	}
	
	/**
	 * Column Info
	 * @param inVslCd
	 */
	public void setInVslCd(String inVslCd) {
		this.inVslCd = inVslCd;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
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
	 * @param inSkdVoyageNo
	 */
	public void setInSkdVoyageNo(String inSkdVoyageNo) {
		this.inSkdVoyageNo = inSkdVoyageNo;
	}
	
	/**
	 * Column Info
	 * @param mrnNo
	 */
	public void setMrnNo(String mrnNo) {
		this.mrnNo = mrnNo;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param sendInd
	 */
	public void setSendInd(String sendInd) {
		this.sendInd = sendInd;
	}
	
	/**
	 * Column Info
	 * @param inPort
	 */
	public void setInPort(String inPort) {
		this.inPort = inPort;
	}
	
	/**
	 * Column Info
	 * @param errMsg
	 */
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param inMrnNo
	 */
	public void setInMrnNo(String inMrnNo) {
		this.inMrnNo = inMrnNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setInMrnMode(JSPUtil.getParameter(request, "in_mrn_mode", ""));
		setMrnChkNo(JSPUtil.getParameter(request, "mrn_chk_no", ""));
		setInSkdDirCd(JSPUtil.getParameter(request, "in_skd_dir_cd", ""));
		setRsltDt(JSPUtil.getParameter(request, "rslt_dt", ""));
		setRslt(JSPUtil.getParameter(request, "rslt", ""));
		setInVslCd(JSPUtil.getParameter(request, "in_vsl_cd", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setSndDt(JSPUtil.getParameter(request, "snd_dt", ""));
		setInSkdVoyageNo(JSPUtil.getParameter(request, "in_skd_voyage_no", ""));
		setMrnNo(JSPUtil.getParameter(request, "mrn_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSendInd(JSPUtil.getParameter(request, "send_ind", ""));
		setInPort(JSPUtil.getParameter(request, "in_port", ""));
		setErrMsg(JSPUtil.getParameter(request, "err_msg", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setInMrnNo(JSPUtil.getParameter(request, "in_mrn_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorMrnInfoVO[]
	 */
	public KorMrnInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorMrnInfoVO[]
	 */
	public KorMrnInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorMrnInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] inMrnMode = (JSPUtil.getParameter(request, prefix	+ "in_mrn_mode", length));
			String[] mrnChkNo = (JSPUtil.getParameter(request, prefix	+ "mrn_chk_no", length));
			String[] inSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "in_skd_dir_cd", length));
			String[] rsltDt = (JSPUtil.getParameter(request, prefix	+ "rslt_dt", length));
			String[] rslt = (JSPUtil.getParameter(request, prefix	+ "rslt", length));
			String[] inVslCd = (JSPUtil.getParameter(request, prefix	+ "in_vsl_cd", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] sndDt = (JSPUtil.getParameter(request, prefix	+ "snd_dt", length));
			String[] inSkdVoyageNo = (JSPUtil.getParameter(request, prefix	+ "in_skd_voyage_no", length));
			String[] mrnNo = (JSPUtil.getParameter(request, prefix	+ "mrn_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sendInd = (JSPUtil.getParameter(request, prefix	+ "send_ind", length));
			String[] inPort = (JSPUtil.getParameter(request, prefix	+ "in_port", length));
			String[] errMsg = (JSPUtil.getParameter(request, prefix	+ "err_msg", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] inMrnNo = (JSPUtil.getParameter(request, prefix	+ "in_mrn_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorMrnInfoVO();
				if (inMrnMode[i] != null)
					model.setInMrnMode(inMrnMode[i]);
				if (mrnChkNo[i] != null)
					model.setMrnChkNo(mrnChkNo[i]);
				if (inSkdDirCd[i] != null)
					model.setInSkdDirCd(inSkdDirCd[i]);
				if (rsltDt[i] != null)
					model.setRsltDt(rsltDt[i]);
				if (rslt[i] != null)
					model.setRslt(rslt[i]);
				if (inVslCd[i] != null)
					model.setInVslCd(inVslCd[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (sndDt[i] != null)
					model.setSndDt(sndDt[i]);
				if (inSkdVoyageNo[i] != null)
					model.setInSkdVoyageNo(inSkdVoyageNo[i]);
				if (mrnNo[i] != null)
					model.setMrnNo(mrnNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sendInd[i] != null)
					model.setSendInd(sendInd[i]);
				if (inPort[i] != null)
					model.setInPort(inPort[i]);
				if (errMsg[i] != null)
					model.setErrMsg(errMsg[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (inMrnNo[i] != null)
					model.setInMrnNo(inMrnNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorMrnInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorMrnInfoVO[]
	 */
	public KorMrnInfoVO[] getKorMrnInfoVOs(){
		KorMrnInfoVO[] vos = (KorMrnInfoVO[])models.toArray(new KorMrnInfoVO[models.size()]);
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
		this.inMrnMode = this.inMrnMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnChkNo = this.mrnChkNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inSkdDirCd = this.inSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsltDt = this.rsltDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rslt = this.rslt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVslCd = this.inVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDt = this.sndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inSkdVoyageNo = this.inSkdVoyageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnNo = this.mrnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sendInd = this.sendInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPort = this.inPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errMsg = this.errMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inMrnNo = this.inMrnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
