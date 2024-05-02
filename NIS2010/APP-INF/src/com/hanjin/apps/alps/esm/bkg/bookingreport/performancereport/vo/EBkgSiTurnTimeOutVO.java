/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EBkgSiTurnTimeOutVO.java
*@FileTitle : EBkgSiTurnTimeOutVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.17
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.17  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo;

import java.lang.reflect.Field;
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EBkgSiTurnTimeOutVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EBkgSiTurnTimeOutVO> models = new ArrayList<EBkgSiTurnTimeOutVO>();
	
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String rqstDt = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String turnTm = null;
	/* Column Info */
	private String siCnt = null;
	/* Column Info */
	private String ntcDt = null;
	/* Column Info */
	private String bkgCnt = null;
	/* Column Info */
	private String avgTurnTm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String gsoCd = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String upldTm = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String usrCnt = null;
	/* Column Info */
	private String xterRqstSeq = null;
	/* Column Info */
	private String xterRqstNo = null;
	/* Column Info */
	private String avgUpldTm = null;
	/* Column Info */
	private String xterRqstViaCd = null;
	/* Column Info */
	private String upldDt = null;
	/* Column Info */
	private String turnHh = null;
    /* Column Info */
	private String avgTurnHh = null;
	/* Column Info */
	private String upldHh = null;
	/* Column Info */
	private String avgUpldHh = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EBkgSiTurnTimeOutVO() {}

	public EBkgSiTurnTimeOutVO(String ibflag, String pagerows, String upldHh, String avgUpldHh, String bkgOfcCd, String rhqCd, String gsoCd, String bkgCnt, String siCnt, String usrCnt, String turnHh, String turnTm, String avgTurnHh, String avgTurnTm, String upldTm, String avgUpldTm, String bkgNo, String xterRqstNo, String xterRqstSeq, String xterRqstViaCd, String vvd, String polCd, String podCd, String rqstDt, String ntcDt, String upldDt) {
		this.bkgOfcCd = bkgOfcCd;
		this.rqstDt = rqstDt;
		this.rhqCd = rhqCd;
		this.turnTm = turnTm;
		this.siCnt = siCnt;
		this.ntcDt = ntcDt;
		this.bkgCnt = bkgCnt;
		this.avgTurnTm = avgTurnTm;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.vvd = vvd;
		this.gsoCd = gsoCd;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.upldTm = upldTm;
		this.bkgNo = bkgNo;
		this.usrCnt = usrCnt;
		this.xterRqstSeq = xterRqstSeq;
		this.xterRqstNo = xterRqstNo;
		this.avgUpldTm = avgUpldTm;
		this.xterRqstViaCd = xterRqstViaCd;
		this.upldDt = upldDt;
		this.turnHh = turnHh;
		this.avgTurnHh = avgTurnHh;
		this.upldHh = upldHh;
		this.avgUpldHh = avgUpldHh;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("rqst_dt", getRqstDt());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("turn_tm", getTurnTm());
		this.hashColumns.put("si_cnt", getSiCnt());
		this.hashColumns.put("ntc_dt", getNtcDt());
		this.hashColumns.put("bkg_cnt", getBkgCnt());
		this.hashColumns.put("avg_turn_tm", getAvgTurnTm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("gso_cd", getGsoCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("upld_tm", getUpldTm());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("usr_cnt", getUsrCnt());
		this.hashColumns.put("xter_rqst_seq", getXterRqstSeq());
		this.hashColumns.put("xter_rqst_no", getXterRqstNo());
		this.hashColumns.put("avg_upld_tm", getAvgUpldTm());
		this.hashColumns.put("xter_rqst_via_cd", getXterRqstViaCd());
		this.hashColumns.put("upld_dt", getUpldDt());
		this.hashColumns.put("turn_hh", getTurnHh());
		this.hashColumns.put("avg_turn_hh", getAvgTurnHh());
		this.hashColumns.put("upld_hh", getUpldHh());
		this.hashColumns.put("avg_upld_hh", getAvgUpldHh());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("turn_tm", "turnTm");
		this.hashFields.put("si_cnt", "siCnt");
		this.hashFields.put("ntc_dt", "ntcDt");
		this.hashFields.put("bkg_cnt", "bkgCnt");
		this.hashFields.put("avg_turn_tm", "avgTurnTm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("gso_cd", "gsoCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("upld_tm", "upldTm");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("usr_cnt", "usrCnt");
		this.hashFields.put("xter_rqst_seq", "xterRqstSeq");
		this.hashFields.put("xter_rqst_no", "xterRqstNo");
		this.hashFields.put("avg_upld_tm", "avgUpldTm");
		this.hashFields.put("xter_rqst_via_cd", "xterRqstViaCd");
		this.hashFields.put("upld_dt", "upldDt");
		this.hashFields.put("turn_hh", "turnHh");
		this.hashFields.put("avg_turn_hh", "avgTurnHh");
		this.hashFields.put("upld_hh", "upldHh");
		this.hashFields.put("avg_upld_hh", "avgUpldHh");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rqstDt
	 */
	public String getRqstDt() {
		return this.rqstDt;
	}
	
	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return turnTm
	 */
	public String getTurnTm() {
		return this.turnTm;
	}
	
	/**
	 * Column Info
	 * @return siCnt
	 */
	public String getSiCnt() {
		return this.siCnt;
	}
	
	/**
	 * Column Info
	 * @return ntcDt
	 */
	public String getNtcDt() {
		return this.ntcDt;
	}
	
	/**
	 * Column Info
	 * @return bkgCnt
	 */
	public String getBkgCnt() {
		return this.bkgCnt;
	}
	
	/**
	 * Column Info
	 * @return avgTurnTm
	 */
	public String getAvgTurnTm() {
		return this.avgTurnTm;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return gsoCd
	 */
	public String getGsoCd() {
		return this.gsoCd;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return upldTm
	 */
	public String getUpldTm() {
		return this.upldTm;
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
	 * @return usrCnt
	 */
	public String getUsrCnt() {
		return this.usrCnt;
	}
	
	/**
	 * Column Info
	 * @return xterRqstSeq
	 */
	public String getXterRqstSeq() {
		return this.xterRqstSeq;
	}
	
	/**
	 * Column Info
	 * @return xterRqstNo
	 */
	public String getXterRqstNo() {
		return this.xterRqstNo;
	}
	
	/**
	 * Column Info
	 * @return avgUpldTm
	 */
	public String getAvgUpldTm() {
		return this.avgUpldTm;
	}
	
	/**
	 * Column Info
	 * @return upldHh
	 */
	public String getUpldHh() {
		return this.upldHh;
	}	
	
	/**
	 * Column Info
	 * @return avgUpldHh
	 */
	public String getAvgUpldHh() {
		return this.avgUpldHh;
	}	
	
	/**
	 * Column Info
	 * @return xterRqstViaCd
	 */
	public String getXterRqstViaCd() {
		return this.xterRqstViaCd;
	}
	
	/**
	 * Column Info
	 * @return upldDt
	 */
	public String getUpldDt() {
		return this.upldDt;
	}
	
	/**
	 * Column Info
	 * @return turnHh
	 */
	public String getTurnHh() {
		return this.turnHh;
	}
	
	/**
	 * Column Info
	 * @return avgTurnHh
	 */
	public String getAvgTurnHh() {
		return this.avgTurnHh;
	}	
	

	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rqstDt
	 */
	public void setRqstDt(String rqstDt) {
		this.rqstDt = rqstDt;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param turnTm
	 */
	public void setTurnTm(String turnTm) {
		this.turnTm = turnTm;
	}
	
	/**
	 * Column Info
	 * @param siCnt
	 */
	public void setSiCnt(String siCnt) {
		this.siCnt = siCnt;
	}
	
	/**
	 * Column Info
	 * @param ntcDt
	 */
	public void setNtcDt(String ntcDt) {
		this.ntcDt = ntcDt;
	}
	
	/**
	 * Column Info
	 * @param bkgCnt
	 */
	public void setBkgCnt(String bkgCnt) {
		this.bkgCnt = bkgCnt;
	}
	
	/**
	 * Column Info
	 * @param avgTurnTm
	 */
	public void setAvgTurnTm(String avgTurnTm) {
		this.avgTurnTm = avgTurnTm;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param gsoCd
	 */
	public void setGsoCd(String gsoCd) {
		this.gsoCd = gsoCd;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param upldTm
	 */
	public void setUpldTm(String upldTm) {
		this.upldTm = upldTm;
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
	 * @param usrCnt
	 */
	public void setUsrCnt(String usrCnt) {
		this.usrCnt = usrCnt;
	}
	
	/**
	 * Column Info
	 * @param xterRqstSeq
	 */
	public void setXterRqstSeq(String xterRqstSeq) {
		this.xterRqstSeq = xterRqstSeq;
	}
	
	/**
	 * Column Info
	 * @param xterRqstNo
	 */
	public void setXterRqstNo(String xterRqstNo) {
		this.xterRqstNo = xterRqstNo;
	}
	
	/**
	 * Column Info
	 * @param avgUpldTm
	 */
	public void setAvgUpldTm(String avgUpldTm) {
		this.avgUpldTm = avgUpldTm;
	}
	
	/**
	 * Column Info
	 * @param xterRqstViaCd
	 */
	public void setXterRqstViaCd(String xterRqstViaCd) {
		this.xterRqstViaCd = xterRqstViaCd;
	}
	
	/**
	 * Column Info
	 * @param upldDt
	 */
	public void setUpldDt(String upldDt) {
		this.upldDt = upldDt;
	}
	
	/**
	 * Column Info
	 * @param turnHh
	 */
	public void setTurnHh(String turnHh) {
		this.turnHh = turnHh;
	}
	
	/**
	 * Column Info
	 * @param avgTurnHh
	 */
	public void setAvgTurnHh(String avgTurnHh) {
		this.avgTurnHh = avgTurnHh;
	}	
	
	/**
	 * Column Info
	 * @param upldHh
	 */
	public void setUpldHh(String upldHh) {
		this.upldHh = upldHh;
	}	
	
	/**
	 * Column Info
	 * @param avgUpldHh
	 */
	public void setAvgUpldHh(String avgUpldHh) {
		this.avgUpldHh = avgUpldHh;
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
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setRqstDt(JSPUtil.getParameter(request, prefix + "rqst_dt", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setTurnTm(JSPUtil.getParameter(request, prefix + "turn_tm", ""));
		setSiCnt(JSPUtil.getParameter(request, prefix + "si_cnt", ""));
		setNtcDt(JSPUtil.getParameter(request, prefix + "ntc_dt", ""));
		setBkgCnt(JSPUtil.getParameter(request, prefix + "bkg_cnt", ""));
		setAvgTurnTm(JSPUtil.getParameter(request, prefix + "avg_turn_tm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setGsoCd(JSPUtil.getParameter(request, prefix + "gso_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUpldTm(JSPUtil.getParameter(request, prefix + "upld_tm", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setUsrCnt(JSPUtil.getParameter(request, prefix + "usr_cnt", ""));
		setXterRqstSeq(JSPUtil.getParameter(request, prefix + "xter_rqst_seq", ""));
		setXterRqstNo(JSPUtil.getParameter(request, prefix + "xter_rqst_no", ""));
		setAvgUpldTm(JSPUtil.getParameter(request, prefix + "avg_upld_tm", ""));
		setXterRqstViaCd(JSPUtil.getParameter(request, prefix + "xter_rqst_via_cd", ""));
		setUpldDt(JSPUtil.getParameter(request, prefix + "upld_dt", ""));
		setTurnHh(JSPUtil.getParameter(request, prefix + "turn_hh", ""));
		setAvgTurnHh(JSPUtil.getParameter(request, prefix + "avg_turn_hh", ""));
		setUpldHh(JSPUtil.getParameter(request, prefix + "upld_hh", ""));
		setAvgUpldHh(JSPUtil.getParameter(request, prefix + "avg_upld_hh", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EBkgSiTurnTimeOutVO[]
	 */
	public EBkgSiTurnTimeOutVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EBkgSiTurnTimeOutVO[]
	 */
	public EBkgSiTurnTimeOutVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EBkgSiTurnTimeOutVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] rqstDt = (JSPUtil.getParameter(request, prefix	+ "rqst_dt", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] turnTm = (JSPUtil.getParameter(request, prefix	+ "turn_tm", length));
			String[] siCnt = (JSPUtil.getParameter(request, prefix	+ "si_cnt", length));
			String[] ntcDt = (JSPUtil.getParameter(request, prefix	+ "ntc_dt", length));
			String[] bkgCnt = (JSPUtil.getParameter(request, prefix	+ "bkg_cnt", length));
			String[] avgTurnTm = (JSPUtil.getParameter(request, prefix	+ "avg_turn_tm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] gsoCd = (JSPUtil.getParameter(request, prefix	+ "gso_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] upldTm = (JSPUtil.getParameter(request, prefix	+ "upld_tm", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] usrCnt = (JSPUtil.getParameter(request, prefix	+ "usr_cnt", length));
			String[] xterRqstSeq = (JSPUtil.getParameter(request, prefix	+ "xter_rqst_seq", length));
			String[] xterRqstNo = (JSPUtil.getParameter(request, prefix	+ "xter_rqst_no", length));
			String[] avgUpldTm = (JSPUtil.getParameter(request, prefix	+ "avg_upld_tm", length));
			String[] xterRqstViaCd = (JSPUtil.getParameter(request, prefix	+ "xter_rqst_via_cd", length));
			String[] upldDt = (JSPUtil.getParameter(request, prefix	+ "upld_dt", length));
			String[] turnHh = (JSPUtil.getParameter(request, prefix	+ "turn_hh", length));
			String[] avgTurnHh = (JSPUtil.getParameter(request, prefix	+ "avg_turn_hh", length));
			String[] upldHh = (JSPUtil.getParameter(request, prefix	+ "upld_hh", length));
			String[] avgUpldHh = (JSPUtil.getParameter(request, prefix	+ "avg_upld_hh", length));
			
			for (int i = 0; i < length; i++) {
				model = new EBkgSiTurnTimeOutVO();
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (rqstDt[i] != null)
					model.setRqstDt(rqstDt[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (turnTm[i] != null)
					model.setTurnTm(turnTm[i]);
				if (siCnt[i] != null)
					model.setSiCnt(siCnt[i]);
				if (ntcDt[i] != null)
					model.setNtcDt(ntcDt[i]);
				if (bkgCnt[i] != null)
					model.setBkgCnt(bkgCnt[i]);
				if (avgTurnTm[i] != null)
					model.setAvgTurnTm(avgTurnTm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (gsoCd[i] != null)
					model.setGsoCd(gsoCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (upldTm[i] != null)
					model.setUpldTm(upldTm[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (usrCnt[i] != null)
					model.setUsrCnt(usrCnt[i]);
				if (xterRqstSeq[i] != null)
					model.setXterRqstSeq(xterRqstSeq[i]);
				if (xterRqstNo[i] != null)
					model.setXterRqstNo(xterRqstNo[i]);
				if (avgUpldTm[i] != null)
					model.setAvgUpldTm(avgUpldTm[i]);
				if (xterRqstViaCd[i] != null)
					model.setXterRqstViaCd(xterRqstViaCd[i]);
				if (upldDt[i] != null)
					model.setUpldDt(upldDt[i]);
				if (turnHh[i] != null)
					model.setTurnHh(turnHh[i]);
				if (avgTurnHh[i] != null)
					model.setAvgTurnHh(avgTurnHh[i]);
				if (upldHh[i] != null)
					model.setUpldHh(upldHh[i]);
				if (avgUpldHh[i] != null)
					model.setAvgUpldHh(avgUpldHh[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEBkgSiTurnTimeOutVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EBkgSiTurnTimeOutVO[]
	 */
	public EBkgSiTurnTimeOutVO[] getEBkgSiTurnTimeOutVOs(){
		EBkgSiTurnTimeOutVO[] vos = (EBkgSiTurnTimeOutVO[])models.toArray(new EBkgSiTurnTimeOutVO[models.size()]);
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
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDt = this.rqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnTm = this.turnTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siCnt = this.siCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcDt = this.ntcDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCnt = this.bkgCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgTurnTm = this.avgTurnTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gsoCd = this.gsoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.upldTm = this.upldTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrCnt = this.usrCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRqstSeq = this.xterRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRqstNo = this.xterRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgUpldTm = this.avgUpldTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRqstViaCd = this.xterRqstViaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.upldDt = this.upldDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnHh = this.turnHh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgTurnHh = this.avgTurnHh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.upldHh = this.upldHh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgUpldHh = this.avgUpldHh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
