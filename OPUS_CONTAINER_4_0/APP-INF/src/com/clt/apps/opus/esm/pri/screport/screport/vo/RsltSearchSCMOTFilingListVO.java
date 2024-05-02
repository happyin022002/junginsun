/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RsltSearchSCMOTFilingListVO.java
*@FileTitle : RsltSearchSCMOTFilingListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.23
*@LastModifier : 강효진
*@LastVersion : 1.0
* 2010.04.23 강효진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.screport.screport.vo;

import java.lang.reflect.Field;
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
 * @author 강효진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltSearchSCMOTFilingListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltSearchSCMOTFilingListVO> models = new ArrayList<RsltSearchSCMOTFilingListVO>();
	
	/* Column Info */
	private String toFileDt = null;
	/* Column Info */
	private String remark = null;
	/* Column Info */
	private String cntrSz = null;
	/* Column Info */
	private String oftRt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String lane = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ctrtPtyNm = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String cntrTp = null;
	/* Column Info */
	private String surRt = null;
	/* Column Info */
	private String cmdtTp = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String carrier = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String mqc1 = null;
	/* Column Info */
	private String fromFileDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltSearchSCMOTFilingListVO() {}

	public RsltSearchSCMOTFilingListVO(String ibflag, String pagerows, String carrier, String scNo, String ctrtPtyNm, String lane, String polCd, String podCd, String cntrTp, String cmdtTp, String cntrSz, String mqc1, String oftRt, String surRt, String effDt, String expDt, String remark, String fromFileDt, String toFileDt) {
		this.toFileDt = toFileDt;
		this.remark = remark;
		this.cntrSz = cntrSz;
		this.oftRt = oftRt;
		this.pagerows = pagerows;
		this.lane = lane;
		this.podCd = podCd;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.ctrtPtyNm = ctrtPtyNm;
		this.polCd = polCd;
		this.cntrTp = cntrTp;
		this.surRt = surRt;
		this.cmdtTp = cmdtTp;
		this.scNo = scNo;
		this.carrier = carrier;
		this.expDt = expDt;
		this.mqc1 = mqc1;
		this.fromFileDt = fromFileDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_file_dt", getToFileDt());
		this.hashColumns.put("remark", getRemark());
		this.hashColumns.put("cntr_sz", getCntrSz());
		this.hashColumns.put("oft_rt", getOftRt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ctrt_pty_nm", getCtrtPtyNm());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("cntr_tp", getCntrTp());
		this.hashColumns.put("sur_rt", getSurRt());
		this.hashColumns.put("cmdt_tp", getCmdtTp());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("carrier", getCarrier());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("mqc_1", getMqc1());
		this.hashColumns.put("from_file_dt", getFromFileDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_file_dt", "toFileDt");
		this.hashFields.put("remark", "remark");
		this.hashFields.put("cntr_sz", "cntrSz");
		this.hashFields.put("oft_rt", "oftRt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ctrt_pty_nm", "ctrtPtyNm");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("cntr_tp", "cntrTp");
		this.hashFields.put("sur_rt", "surRt");
		this.hashFields.put("cmdt_tp", "cmdtTp");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("carrier", "carrier");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("mqc_1", "mqc1");
		this.hashFields.put("from_file_dt", "fromFileDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toFileDt
	 */
	public String getToFileDt() {
		return this.toFileDt;
	}
	
	/**
	 * Column Info
	 * @return remark
	 */
	public String getRemark() {
		return this.remark;
	}
	
	/**
	 * Column Info
	 * @return cntrSz
	 */
	public String getCntrSz() {
		return this.cntrSz;
	}
	
	/**
	 * Column Info
	 * @return oftRt
	 */
	public String getOftRt() {
		return this.oftRt;
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
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return ctrtPtyNm
	 */
	public String getCtrtPtyNm() {
		return this.ctrtPtyNm;
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
	 * @return cntrTp
	 */
	public String getCntrTp() {
		return this.cntrTp;
	}
	
	/**
	 * Column Info
	 * @return surRt
	 */
	public String getSurRt() {
		return this.surRt;
	}
	
	/**
	 * Column Info
	 * @return cmdtTp
	 */
	public String getCmdtTp() {
		return this.cmdtTp;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return carrier
	 */
	public String getCarrier() {
		return this.carrier;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return mqc1
	 */
	public String getMqc1() {
		return this.mqc1;
	}
	
	/**
	 * Column Info
	 * @return fromFileDt
	 */
	public String getFromFileDt() {
		return this.fromFileDt;
	}
	

	/**
	 * Column Info
	 * @param toFileDt
	 */
	public void setToFileDt(String toFileDt) {
		this.toFileDt = toFileDt;
	}
	
	/**
	 * Column Info
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * Column Info
	 * @param cntrSz
	 */
	public void setCntrSz(String cntrSz) {
		this.cntrSz = cntrSz;
	}
	
	/**
	 * Column Info
	 * @param oftRt
	 */
	public void setOftRt(String oftRt) {
		this.oftRt = oftRt;
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
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param ctrtPtyNm
	 */
	public void setCtrtPtyNm(String ctrtPtyNm) {
		this.ctrtPtyNm = ctrtPtyNm;
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
	 * @param cntrTp
	 */
	public void setCntrTp(String cntrTp) {
		this.cntrTp = cntrTp;
	}
	
	/**
	 * Column Info
	 * @param surRt
	 */
	public void setSurRt(String surRt) {
		this.surRt = surRt;
	}
	
	/**
	 * Column Info
	 * @param cmdtTp
	 */
	public void setCmdtTp(String cmdtTp) {
		this.cmdtTp = cmdtTp;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param carrier
	 */
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param mqc1
	 */
	public void setMqc1(String mqc1) {
		this.mqc1 = mqc1;
	}
	
	/**
	 * Column Info
	 * @param fromFileDt
	 */
	public void setFromFileDt(String fromFileDt) {
		this.fromFileDt = fromFileDt;
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
		setToFileDt(JSPUtil.getParameter(request, prefix + "to_file_dt", ""));
		setRemark(JSPUtil.getParameter(request, prefix + "remark", ""));
		setCntrSz(JSPUtil.getParameter(request, prefix + "cntr_sz", ""));
		setOftRt(JSPUtil.getParameter(request, prefix + "oft_rt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setLane(JSPUtil.getParameter(request, prefix + "lane", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCtrtPtyNm(JSPUtil.getParameter(request, prefix + "ctrt_pty_nm", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setCntrTp(JSPUtil.getParameter(request, prefix + "cntr_tp", ""));
		setSurRt(JSPUtil.getParameter(request, prefix + "sur_rt", ""));
		setCmdtTp(JSPUtil.getParameter(request, prefix + "cmdt_tp", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setCarrier(JSPUtil.getParameter(request, prefix + "carrier", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setMqc1(JSPUtil.getParameter(request, prefix + "mqc_1", ""));
		setFromFileDt(JSPUtil.getParameter(request, prefix + "from_file_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltSearchSCMOTFilingListVO[]
	 */
	public RsltSearchSCMOTFilingListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltSearchSCMOTFilingListVO[]
	 */
	public RsltSearchSCMOTFilingListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltSearchSCMOTFilingListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toFileDt = (JSPUtil.getParameter(request, prefix	+ "to_file_dt", length));
			String[] remark = (JSPUtil.getParameter(request, prefix	+ "remark", length));
			String[] cntrSz = (JSPUtil.getParameter(request, prefix	+ "cntr_sz", length));
			String[] oftRt = (JSPUtil.getParameter(request, prefix	+ "oft_rt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ctrtPtyNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_pty_nm", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] cntrTp = (JSPUtil.getParameter(request, prefix	+ "cntr_tp", length));
			String[] surRt = (JSPUtil.getParameter(request, prefix	+ "sur_rt", length));
			String[] cmdtTp = (JSPUtil.getParameter(request, prefix	+ "cmdt_tp", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] carrier = (JSPUtil.getParameter(request, prefix	+ "carrier", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] mqc1 = (JSPUtil.getParameter(request, prefix	+ "mqc_1", length));
			String[] fromFileDt = (JSPUtil.getParameter(request, prefix	+ "from_file_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltSearchSCMOTFilingListVO();
				if (toFileDt[i] != null)
					model.setToFileDt(toFileDt[i]);
				if (remark[i] != null)
					model.setRemark(remark[i]);
				if (cntrSz[i] != null)
					model.setCntrSz(cntrSz[i]);
				if (oftRt[i] != null)
					model.setOftRt(oftRt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ctrtPtyNm[i] != null)
					model.setCtrtPtyNm(ctrtPtyNm[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (cntrTp[i] != null)
					model.setCntrTp(cntrTp[i]);
				if (surRt[i] != null)
					model.setSurRt(surRt[i]);
				if (cmdtTp[i] != null)
					model.setCmdtTp(cmdtTp[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (carrier[i] != null)
					model.setCarrier(carrier[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (mqc1[i] != null)
					model.setMqc1(mqc1[i]);
				if (fromFileDt[i] != null)
					model.setFromFileDt(fromFileDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltSearchSCMOTFilingListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltSearchSCMOTFilingListVO[]
	 */
	public RsltSearchSCMOTFilingListVO[] getRsltSearchSCMOTFilingListVOs(){
		RsltSearchSCMOTFilingListVO[] vos = (RsltSearchSCMOTFilingListVO[])models.toArray(new RsltSearchSCMOTFilingListVO[models.size()]);
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
		this.toFileDt = this.toFileDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark = this.remark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSz = this.cntrSz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oftRt = this.oftRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtPtyNm = this.ctrtPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTp = this.cntrTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.surRt = this.surRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtTp = this.cmdtTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.carrier = this.carrier .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mqc1 = this.mqc1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromFileDt = this.fromFileDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
