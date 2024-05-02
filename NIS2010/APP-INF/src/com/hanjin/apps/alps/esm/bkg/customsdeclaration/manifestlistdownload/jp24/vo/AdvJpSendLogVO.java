/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : AdvJpSendLogVO.java
*@FileTitle : AdvJpSendLogVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.15
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2013.10.15 김상수 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AdvJpSendLogVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AdvJpSendLogVO> models = new ArrayList<AdvJpSendLogVO>();
	
	/* Column Info */
	private String cntcPsonEml = null;
	/* Column Info */
	private String msgSndDiv = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String podSplitNo = null;
	/* Column Info */
	private String polSplitNo = null;
	/* Column Info */
	private String msgSndSeq = null;
	/* Column Info */
	private String sndDt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String tSType = null;
	/* Column Info */
	private String logSeq = null;
	/* Column Info */
	private String flatFile = null;
	/* Column Info */
	private String emlSndRsltFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AdvJpSendLogVO() {}

	public AdvJpSendLogVO(String ibflag, String pagerows, String tSType, String msgSndSeq, String msgSndDiv, String blNo, String sndDt, String ofcCd, String logSeq, String vvd, String podCd, String podSplitNo, String polCd, String polSplitNo, String delCd, String flatFile, String cntcPsonEml, String emlSndRsltFlg, String usrId) {
		this.cntcPsonEml = cntcPsonEml;
		this.msgSndDiv = msgSndDiv;
		this.delCd = delCd;
		this.podSplitNo = podSplitNo;
		this.polSplitNo = polSplitNo;
		this.msgSndSeq = msgSndSeq;
		this.sndDt = sndDt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.podCd = podCd;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.usrId = usrId;
		this.tSType = tSType;
		this.logSeq = logSeq;
		this.flatFile = flatFile;
		this.emlSndRsltFlg = emlSndRsltFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntc_pson_eml", getCntcPsonEml());
		this.hashColumns.put("msg_snd_div", getMsgSndDiv());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("pod_split_no", getPodSplitNo());
		this.hashColumns.put("pol_split_no", getPolSplitNo());
		this.hashColumns.put("msg_snd_seq", getMsgSndSeq());
		this.hashColumns.put("snd_dt", getSndDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("t_s_type", getTSType());
		this.hashColumns.put("log_seq", getLogSeq());
		this.hashColumns.put("flat_file", getFlatFile());
		this.hashColumns.put("eml_snd_rslt_flg", getEmlSndRsltFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntc_pson_eml", "cntcPsonEml");
		this.hashFields.put("msg_snd_div", "msgSndDiv");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("pod_split_no", "podSplitNo");
		this.hashFields.put("pol_split_no", "polSplitNo");
		this.hashFields.put("msg_snd_seq", "msgSndSeq");
		this.hashFields.put("snd_dt", "sndDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("t_s_type", "tSType");
		this.hashFields.put("log_seq", "logSeq");
		this.hashFields.put("flat_file", "flatFile");
		this.hashFields.put("eml_snd_rslt_flg", "emlSndRsltFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntcPsonEml
	 */
	public String getCntcPsonEml() {
		return this.cntcPsonEml;
	}
	
	/**
	 * Column Info
	 * @return msgSndDiv
	 */
	public String getMsgSndDiv() {
		return this.msgSndDiv;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return podSplitNo
	 */
	public String getPodSplitNo() {
		return this.podSplitNo;
	}
	
	/**
	 * Column Info
	 * @return polSplitNo
	 */
	public String getPolSplitNo() {
		return this.polSplitNo;
	}
	
	/**
	 * Column Info
	 * @return msgSndSeq
	 */
	public String getMsgSndSeq() {
		return this.msgSndSeq;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return tSType
	 */
	public String getTSType() {
		return this.tSType;
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
	 * @return flatFile
	 */
	public String getFlatFile() {
		return this.flatFile;
	}
	
	/**
	 * Column Info
	 * @return emlSndRsltFlg
	 */
	public String getEmlSndRsltFlg() {
		return this.emlSndRsltFlg;
	}
	

	/**
	 * Column Info
	 * @param cntcPsonEml
	 */
	public void setCntcPsonEml(String cntcPsonEml) {
		this.cntcPsonEml = cntcPsonEml;
	}
	
	/**
	 * Column Info
	 * @param msgSndDiv
	 */
	public void setMsgSndDiv(String msgSndDiv) {
		this.msgSndDiv = msgSndDiv;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param podSplitNo
	 */
	public void setPodSplitNo(String podSplitNo) {
		this.podSplitNo = podSplitNo;
	}
	
	/**
	 * Column Info
	 * @param polSplitNo
	 */
	public void setPolSplitNo(String polSplitNo) {
		this.polSplitNo = polSplitNo;
	}
	
	/**
	 * Column Info
	 * @param msgSndSeq
	 */
	public void setMsgSndSeq(String msgSndSeq) {
		this.msgSndSeq = msgSndSeq;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param tSType
	 */
	public void setTSType(String tSType) {
		this.tSType = tSType;
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
	 * @param flatFile
	 */
	public void setFlatFile(String flatFile) {
		this.flatFile = flatFile;
	}
	
	/**
	 * Column Info
	 * @param emlSndRsltFlg
	 */
	public void setEmlSndRsltFlg(String emlSndRsltFlg) {
		this.emlSndRsltFlg = emlSndRsltFlg;
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
		setCntcPsonEml(JSPUtil.getParameter(request, prefix + "cntc_pson_eml", ""));
		setMsgSndDiv(JSPUtil.getParameter(request, prefix + "msg_snd_div", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setPodSplitNo(JSPUtil.getParameter(request, prefix + "pod_split_no", ""));
		setPolSplitNo(JSPUtil.getParameter(request, prefix + "pol_split_no", ""));
		setMsgSndSeq(JSPUtil.getParameter(request, prefix + "msg_snd_seq", ""));
		setSndDt(JSPUtil.getParameter(request, prefix + "snd_dt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setTSType(JSPUtil.getParameter(request, prefix + "t_s_type", ""));
		setLogSeq(JSPUtil.getParameter(request, prefix + "log_seq", ""));
		setFlatFile(JSPUtil.getParameter(request, prefix + "flat_file", ""));
		setEmlSndRsltFlg(JSPUtil.getParameter(request, prefix + "eml_snd_rslt_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AdvJpSendLogVO[]
	 */
	public AdvJpSendLogVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AdvJpSendLogVO[]
	 */
	public AdvJpSendLogVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AdvJpSendLogVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntcPsonEml = (JSPUtil.getParameter(request, prefix	+ "cntc_pson_eml", length));
			String[] msgSndDiv = (JSPUtil.getParameter(request, prefix	+ "msg_snd_div", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] podSplitNo = (JSPUtil.getParameter(request, prefix	+ "pod_split_no", length));
			String[] polSplitNo = (JSPUtil.getParameter(request, prefix	+ "pol_split_no", length));
			String[] msgSndSeq = (JSPUtil.getParameter(request, prefix	+ "msg_snd_seq", length));
			String[] sndDt = (JSPUtil.getParameter(request, prefix	+ "snd_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] tSType = (JSPUtil.getParameter(request, prefix	+ "t_s_type", length));
			String[] logSeq = (JSPUtil.getParameter(request, prefix	+ "log_seq", length));
			String[] flatFile = (JSPUtil.getParameter(request, prefix	+ "flat_file", length));
			String[] emlSndRsltFlg = (JSPUtil.getParameter(request, prefix	+ "eml_snd_rslt_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new AdvJpSendLogVO();
				if (cntcPsonEml[i] != null)
					model.setCntcPsonEml(cntcPsonEml[i]);
				if (msgSndDiv[i] != null)
					model.setMsgSndDiv(msgSndDiv[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (podSplitNo[i] != null)
					model.setPodSplitNo(podSplitNo[i]);
				if (polSplitNo[i] != null)
					model.setPolSplitNo(polSplitNo[i]);
				if (msgSndSeq[i] != null)
					model.setMsgSndSeq(msgSndSeq[i]);
				if (sndDt[i] != null)
					model.setSndDt(sndDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (tSType[i] != null)
					model.setTSType(tSType[i]);
				if (logSeq[i] != null)
					model.setLogSeq(logSeq[i]);
				if (flatFile[i] != null)
					model.setFlatFile(flatFile[i]);
				if (emlSndRsltFlg[i] != null)
					model.setEmlSndRsltFlg(emlSndRsltFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAdvJpSendLogVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AdvJpSendLogVO[]
	 */
	public AdvJpSendLogVO[] getAdvJpSendLogVOs(){
		AdvJpSendLogVO[] vos = (AdvJpSendLogVO[])models.toArray(new AdvJpSendLogVO[models.size()]);
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
		this.cntcPsonEml = this.cntcPsonEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgSndDiv = this.msgSndDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podSplitNo = this.podSplitNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polSplitNo = this.polSplitNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgSndSeq = this.msgSndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDt = this.sndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tSType = this.tSType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.logSeq = this.logSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flatFile = this.flatFile .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndRsltFlg = this.emlSndRsltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
