package com.clt.apps.opus.esd.sce.copdetailreceive.vo;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.util.JSPUtil;

public class ActualDataVO {
	

	//private static final long serialVersionUID = 1L;
	
	private Collection<ActualDataVO> models = new ArrayList<ActualDataVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Actual Received Date */
	private String actRcvDt = null;  
	/* Actual Received Number */
	private String actRcvNo = null;
	/* Booking Number */
	private String bkgNo = null;
	/* Container Number */
	private String cntrNo = null;
	/* Actual Date */
	private String actDt = null;
	/* Actual Status Mapping Code */
	private String actStsMapgCd = null;
	/* Node Code */
	private String nodCd = null;
	/* Actual Receive Type Code */
	private String actRcvTpCd = null;
	/* COP Result Flag */
	private String copRltFlg = null;
	/* Actual Unmatched Type Code */
	private String actUmchTpCd = null;
	/* Creation Date */
	private String creDt = null;
	/* Unmatched Check Date */
	private String umchChkDt = null;
	/* Vessel Code */
	private String vslCd = null;
	/* Schedule Voyage Number */
	private String skdVoyNo = null;
	/* Schedule Direction Code */
	private String skdDirCd = null;
	/* VPS Port Code */
	private String vpsPortCd = null;
	/* Calling Port Indicator Sequence */
	private String clptIndSeq = null;

	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ActualDataVO() {}

	public ActualDataVO(String ibflag, String actRcvDt, String actRcvNo, String bkgNo, String cntrNo, String actDt, String actStsMapgCd, String nodCd, String actRcvTpCd, String copRltFlg, String actUmchTpCd,String creDt, String umchChkDt, String vslCd, String skdVoyNo, String skdDirCd, String vpsPortCd, String clptIndSeq) {
		this.ibflag = ibflag;
		this.actRcvDt = actRcvDt;
		this.actRcvNo = actRcvNo;
		this.bkgNo = bkgNo;
		this.cntrNo = cntrNo;
		this.actDt = actDt;
		this.actStsMapgCd = actStsMapgCd;
		this.nodCd = nodCd;
		this.actRcvTpCd = actRcvTpCd;
		this.copRltFlg = copRltFlg;
		this.actUmchTpCd = actUmchTpCd;
		this.creDt = creDt;
		this.umchChkDt = umchChkDt;
		this.vslCd = vslCd;
		this.vslCd = vslCd;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd = skdDirCd;
		this.vpsPortCd = vpsPortCd;
		this.clptIndSeq = clptIndSeq;

	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("actRcvDt", getActRcvDt());
		this.hashColumns.put("actRcvNo", getActRcvNo());
		this.hashColumns.put("bkgNo", getBkgNo());
		this.hashColumns.put("cntrNo", getCntrNo());
		this.hashColumns.put("actDt", getActDt());
		this.hashColumns.put("actStsMapgCd", getActStsMapgCd());
		this.hashColumns.put("nodCd", getNodCd());
		this.hashColumns.put("actRcvTpCd", getActRcvTpCd());
		this.hashColumns.put("copRltFlg", getCopRltFlg());
		this.hashColumns.put("actUmchTpCd", getActUmchTpCd());
		this.hashColumns.put("creDt", getCreDt());
		this.hashColumns.put("umchChkDt", getUmchChkDt());
		this.hashColumns.put("vslCd", getVslCd());
		this.hashColumns.put("skdVoyNo", getSkdVoyNo());
		this.hashColumns.put("skdDirCd", getSkdDirCd());
		this.hashColumns.put("vpsPortCd", getVpsPortCd());
		this.hashColumns.put("clptIndSeq", getClptIndSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("actRcvDt", "actRcvDt");
		this.hashFields.put("actRcvNo", "actRcvNo");
		this.hashFields.put("bkgNo", "bkgNo");
		this.hashFields.put("cntrNo", "cntrNo");
		this.hashFields.put("actDt", "actDt");
		this.hashFields.put("actStsMapgCd", "actStsMapgCd");
		this.hashFields.put("nodCd", "nodCd");
		this.hashFields.put("actRcvTpCd", "actRcvTpCd");
		this.hashFields.put("copRltFlg", "copRltFlg");
		this.hashFields.put("actUmchTpCd", "actUmchTpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("umchChkDt", "umchChkDt");
		this.hashFields.put("vslCd", "vslCd");
		this.hashFields.put("skdVoyNo", "skdVoyNo");
		this.hashFields.put("skdDirCd", "skdDirCd");
		this.hashFields.put("vpsPortCd", "vpsPortCd");
		this.hashFields.put("clptIndSeq", "clptIndSeq");
		return this.hashFields;
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
	 * @return actRcvDt
	 */
	public String getActRcvDt() {
		return this.actRcvDt;
	}
	
	/**
	 * Column Info
	 * @return actRcvNo
	 */
	public String getActRcvNo() {
		return this.actRcvNo;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return actDt
	 */
	public String getActDt() {
		return this.actDt;
	}
	
	/**
	 * Column Info
	 * @return actStsMapgCd
	 */
	public String getActStsMapgCd() {
		return this.actStsMapgCd;
	}
	
	/**
	 * Column Info
	 * @return nodCd
	 */
	public String getNodCd() {
		return this.nodCd;
	}
	
	/**
	 * Column Info
	 * @return actRcvTpCd
	 */
	public String getActRcvTpCd() {
		return this.actRcvTpCd;
	}
	
	/**
	 * Column Info
	 * @return copRltFlg
	 */
	public String getCopRltFlg() {
		return this.copRltFlg;
	}
	
	/**
	 * Column Info
	 * @return actUmchTpCd
	 */
	public String getActUmchTpCd() {
		return this.actUmchTpCd;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return umchChkDt
	 */
	public String getUmchChkDt() {
		return this.umchChkDt;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @return clptIndSeq
	 */
	public String getClptIndSeq() {
		return this.clptIndSeq;
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
	 * @param actRcvDt
	 */
	public void setActRcvDt(String actRcvDt) {
		this.actRcvDt = actRcvDt;
	}
	
	/**
	 * Column Info
	 * @param actRcvNo
	 */
	public void setActRcvNo(String actRcvNo) {
		this.actRcvNo = actRcvNo;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param actDt
	 */
	public void setActDt(String actDt) {
		this.actDt = actDt;
	}
	
	/**
	 * Column Info
	 * @param actStsMapgCd
	 */
	public void setActStsMapgCd(String actStsMapgCd) {
		this.actStsMapgCd = actStsMapgCd;
	}
	
	/**
	 * Column Info
	 * @param nodCd
	 */
	public void setNodCd(String nodCd) {
		this.nodCd = nodCd;
	}
	
	/**
	 * Column Info
	 * @param actRcvTpCd
	 */
	public void setActRcvTpCd(String actRcvTpCd) {
		this.actRcvTpCd = actRcvTpCd;
	}
	
	/**
	 * Column Info
	 * @param copRltFlg
	 */
	public void setCopRltFlg(String copRltFlg) {
		this.copRltFlg = copRltFlg;
	}
	
	/**
	 * Column Info
	 * @param actUmchTpCd
	 */
	public void setActUmchTpCd(String actUmchTpCd) {
		this.actUmchTpCd = actUmchTpCd;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param umchChkDt
	 */
	public void setUmchChkDt(String umchChkDt) {
		this.umchChkDt = umchChkDt;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @param clptIndSeq
	 */
	public void setClptIndSeq(String clptIndSeq) {
		this.clptIndSeq = clptIndSeq;
	}
	
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setActRcvDt(JSPUtil.getParameter(request, "actRcvDt", ""));
		setActRcvNo(JSPUtil.getParameter(request, "actRcvNo", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkgNo", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntrNo", ""));
		setActDt(JSPUtil.getParameter(request, "actDt", ""));
		setActStsMapgCd(JSPUtil.getParameter(request, "actStsMapgCd", ""));
		setNodCd(JSPUtil.getParameter(request, "nodCd", ""));
		setActRcvTpCd(JSPUtil.getParameter(request, "actRcvTpCd", ""));
		setCopRltFlg(JSPUtil.getParameter(request, "copRltFlg", ""));
		setActUmchTpCd(JSPUtil.getParameter(request, "actUmchTpCd", ""));
		setCreDt(JSPUtil.getParameter(request, "creDt", ""));
		setUmchChkDt(JSPUtil.getParameter(request, "eqDestCd", ""));
		setVslCd(JSPUtil.getParameter(request, "vslCd", ""));
		setVslCd(JSPUtil.getParameter(request, "vslCd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skdVoyNo", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skdDirCd", ""));
		setVpsPortCd(JSPUtil.getParameter(request, "vpsPortCd", ""));
		setClptIndSeq(JSPUtil.getParameter(request, "clptIndSeq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EDI322MSGVO[]
	 */
	public ActualDataVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EDI322MSGVO[]
	 */
	public ActualDataVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ActualDataVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] actRcvDt = (JSPUtil.getParameter(request, prefix	+ "actRcvDt", length));
			String[] actRcvNo = (JSPUtil.getParameter(request, prefix	+ "actRcvNo", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkgNo", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntrNo", length));
			String[] actDt = (JSPUtil.getParameter(request, prefix	+ "actDt", length));
			String[] actStsMapgCd = (JSPUtil.getParameter(request, prefix	+ "actStsMapgCd", length));
			String[] nodCd = (JSPUtil.getParameter(request, prefix	+ "nodCd", length));
			String[] actRcvTpCd = (JSPUtil.getParameter(request, prefix	+ "actRcvTpCd", length));
			String[] copRltFlg = (JSPUtil.getParameter(request, prefix	+ "copRltFlg", length));
			String[] actUmchTpCd = (JSPUtil.getParameter(request, prefix	+ "actUmchTpCd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "creDt", length));
			String[] umchChkDt = (JSPUtil.getParameter(request, prefix	+ "umchChkDt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vslCd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skdVoyNo", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skdDirCd", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vpsPortCd", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clptIndSeq", length));

			
			for (int i = 0; i < length; i++) {
				model = new ActualDataVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (actRcvDt[i] != null)
					model.setActRcvDt(actRcvDt[i]);
				if (actRcvNo[i] != null)
					model.setActRcvNo(actRcvNo[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (actDt[i] != null)
					model.setActDt(actDt[i]);
				if (actStsMapgCd[i] != null)
					model.setActStsMapgCd(actStsMapgCd[i]);
				if (nodCd[i] != null)
					model.setNodCd(nodCd[i]);
				if (actRcvTpCd[i] != null)
					model.setActRcvTpCd(actRcvTpCd[i]);
				if (copRltFlg[i] != null)
					model.setCopRltFlg(copRltFlg[i]);
				if (actUmchTpCd[i] != null)
					model.setActUmchTpCd(actUmchTpCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (umchChkDt[i] != null)
					model.setUmchChkDt(umchChkDt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEDI322MSGVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EDI322MSGVO[]
	 */
	public ActualDataVO[] getEDI322MSGVOs(){
		ActualDataVO[] vos = (ActualDataVO[])models.toArray(new ActualDataVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actRcvDt = this.actRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actRcvNo = this.actRcvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDt = this.actDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actStsMapgCd = this.actStsMapgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodCd = this.nodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actRcvTpCd = this.actRcvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copRltFlg = this.copRltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actUmchTpCd = this.actUmchTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.umchChkDt = this.umchChkDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
	
}
	