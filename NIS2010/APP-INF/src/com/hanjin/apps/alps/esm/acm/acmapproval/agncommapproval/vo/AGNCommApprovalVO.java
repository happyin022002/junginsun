/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommApprovalVO.java
*@FileTitle : AGNCommApprovalVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.05
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.04.05 김상수 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.vo;

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

public class AGNCommApprovalVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AGNCommApprovalVO> models = new ArrayList<AGNCommApprovalVO>();
	
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String toEffDt = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String agnCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ofcGrpId = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String xchRtDivLvl = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String ofcChrCd = null;
	/* Column Info */
	private String toEffDtDivCd = null;
	/* Column Info */
	private String fmEffDtDivCd = null;
	/* Column Info */
	private String fmEffDt = null;
	/* Column Info */
	private String dpGrpNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AGNCommApprovalVO() {}

	public AGNCommApprovalVO(String ibflag, String pagerows, String rhqCd, String agnCd, String ofcCd, String ofcGrpId, String dpGrpNm, String ofcChrCd, String fmEffDtDivCd, String fmEffDt, String toEffDtDivCd, String toEffDt, String vndrSeq, String xchRtDivLvl, String currCd, String arOfcCd, String usrId) {
		this.currCd = currCd;
		this.rhqCd = rhqCd;
		this.toEffDt = toEffDt;
		this.arOfcCd = arOfcCd;
		this.pagerows = pagerows;
		this.agnCd = agnCd;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.ofcGrpId = ofcGrpId;
		this.usrId = usrId;
		this.xchRtDivLvl = xchRtDivLvl;
		this.vndrSeq = vndrSeq;
		this.ofcChrCd = ofcChrCd;
		this.toEffDtDivCd = toEffDtDivCd;
		this.fmEffDtDivCd = fmEffDtDivCd;
		this.fmEffDt = fmEffDt;
		this.dpGrpNm = dpGrpNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("to_eff_dt", getToEffDt());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("agn_cd", getAgnCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ofc_grp_id", getOfcGrpId());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("xch_rt_div_lvl", getXchRtDivLvl());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("ofc_chr_cd", getOfcChrCd());
		this.hashColumns.put("to_eff_dt_div_cd", getToEffDtDivCd());
		this.hashColumns.put("fm_eff_dt_div_cd", getFmEffDtDivCd());
		this.hashColumns.put("fm_eff_dt", getFmEffDt());
		this.hashColumns.put("dp_grp_nm", getDpGrpNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("to_eff_dt", "toEffDt");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("agn_cd", "agnCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ofc_grp_id", "ofcGrpId");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("xch_rt_div_lvl", "xchRtDivLvl");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("ofc_chr_cd", "ofcChrCd");
		this.hashFields.put("to_eff_dt_div_cd", "toEffDtDivCd");
		this.hashFields.put("fm_eff_dt_div_cd", "fmEffDtDivCd");
		this.hashFields.put("fm_eff_dt", "fmEffDt");
		this.hashFields.put("dp_grp_nm", "dpGrpNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
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
	 * @return toEffDt
	 */
	public String getToEffDt() {
		return this.toEffDt;
	}
	
	/**
	 * Column Info
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
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
	 * @return agnCd
	 */
	public String getAgnCd() {
		return this.agnCd;
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
	 * @return ofcGrpId
	 */
	public String getOfcGrpId() {
		return this.ofcGrpId;
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
	 * @return xchRtDivLvl
	 */
	public String getXchRtDivLvl() {
		return this.xchRtDivLvl;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return ofcChrCd
	 */
	public String getOfcChrCd() {
		return this.ofcChrCd;
	}
	
	/**
	 * Column Info
	 * @return toEffDtDivCd
	 */
	public String getToEffDtDivCd() {
		return this.toEffDtDivCd;
	}
	
	/**
	 * Column Info
	 * @return fmEffDtDivCd
	 */
	public String getFmEffDtDivCd() {
		return this.fmEffDtDivCd;
	}
	
	/**
	 * Column Info
	 * @return fmEffDt
	 */
	public String getFmEffDt() {
		return this.fmEffDt;
	}
	
	/**
	 * Column Info
	 * @return dpGrpNm
	 */
	public String getDpGrpNm() {
		return this.dpGrpNm;
	}
	

	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
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
	 * @param toEffDt
	 */
	public void setToEffDt(String toEffDt) {
		this.toEffDt = toEffDt;
	}
	
	/**
	 * Column Info
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
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
	 * @param agnCd
	 */
	public void setAgnCd(String agnCd) {
		this.agnCd = agnCd;
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
	 * @param ofcGrpId
	 */
	public void setOfcGrpId(String ofcGrpId) {
		this.ofcGrpId = ofcGrpId;
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
	 * @param xchRtDivLvl
	 */
	public void setXchRtDivLvl(String xchRtDivLvl) {
		this.xchRtDivLvl = xchRtDivLvl;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param ofcChrCd
	 */
	public void setOfcChrCd(String ofcChrCd) {
		this.ofcChrCd = ofcChrCd;
	}
	
	/**
	 * Column Info
	 * @param toEffDtDivCd
	 */
	public void setToEffDtDivCd(String toEffDtDivCd) {
		this.toEffDtDivCd = toEffDtDivCd;
	}
	
	/**
	 * Column Info
	 * @param fmEffDtDivCd
	 */
	public void setFmEffDtDivCd(String fmEffDtDivCd) {
		this.fmEffDtDivCd = fmEffDtDivCd;
	}
	
	/**
	 * Column Info
	 * @param fmEffDt
	 */
	public void setFmEffDt(String fmEffDt) {
		this.fmEffDt = fmEffDt;
	}
	
	/**
	 * Column Info
	 * @param dpGrpNm
	 */
	public void setDpGrpNm(String dpGrpNm) {
		this.dpGrpNm = dpGrpNm;
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
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setToEffDt(JSPUtil.getParameter(request, prefix + "to_eff_dt", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAgnCd(JSPUtil.getParameter(request, prefix + "agn_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOfcGrpId(JSPUtil.getParameter(request, prefix + "ofc_grp_id", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setXchRtDivLvl(JSPUtil.getParameter(request, prefix + "xch_rt_div_lvl", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setOfcChrCd(JSPUtil.getParameter(request, prefix + "ofc_chr_cd", ""));
		setToEffDtDivCd(JSPUtil.getParameter(request, prefix + "to_eff_dt_div_cd", ""));
		setFmEffDtDivCd(JSPUtil.getParameter(request, prefix + "fm_eff_dt_div_cd", ""));
		setFmEffDt(JSPUtil.getParameter(request, prefix + "fm_eff_dt", ""));
		setDpGrpNm(JSPUtil.getParameter(request, prefix + "dp_grp_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AGNCommApprovalVO[]
	 */
	public AGNCommApprovalVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AGNCommApprovalVO[]
	 */
	public AGNCommApprovalVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AGNCommApprovalVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] toEffDt = (JSPUtil.getParameter(request, prefix	+ "to_eff_dt", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] agnCd = (JSPUtil.getParameter(request, prefix	+ "agn_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ofcGrpId = (JSPUtil.getParameter(request, prefix	+ "ofc_grp_id", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] xchRtDivLvl = (JSPUtil.getParameter(request, prefix	+ "xch_rt_div_lvl", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] ofcChrCd = (JSPUtil.getParameter(request, prefix	+ "ofc_chr_cd", length));
			String[] toEffDtDivCd = (JSPUtil.getParameter(request, prefix	+ "to_eff_dt_div_cd", length));
			String[] fmEffDtDivCd = (JSPUtil.getParameter(request, prefix	+ "fm_eff_dt_div_cd", length));
			String[] fmEffDt = (JSPUtil.getParameter(request, prefix	+ "fm_eff_dt", length));
			String[] dpGrpNm = (JSPUtil.getParameter(request, prefix	+ "dp_grp_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new AGNCommApprovalVO();
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (toEffDt[i] != null)
					model.setToEffDt(toEffDt[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (agnCd[i] != null)
					model.setAgnCd(agnCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ofcGrpId[i] != null)
					model.setOfcGrpId(ofcGrpId[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (xchRtDivLvl[i] != null)
					model.setXchRtDivLvl(xchRtDivLvl[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (ofcChrCd[i] != null)
					model.setOfcChrCd(ofcChrCd[i]);
				if (toEffDtDivCd[i] != null)
					model.setToEffDtDivCd(toEffDtDivCd[i]);
				if (fmEffDtDivCd[i] != null)
					model.setFmEffDtDivCd(fmEffDtDivCd[i]);
				if (fmEffDt[i] != null)
					model.setFmEffDt(fmEffDt[i]);
				if (dpGrpNm[i] != null)
					model.setDpGrpNm(dpGrpNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAGNCommApprovalVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AGNCommApprovalVO[]
	 */
	public AGNCommApprovalVO[] getAGNCommApprovalVOs(){
		AGNCommApprovalVO[] vos = (AGNCommApprovalVO[])models.toArray(new AGNCommApprovalVO[models.size()]);
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
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEffDt = this.toEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCd = this.agnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcGrpId = this.ofcGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtDivLvl = this.xchRtDivLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcChrCd = this.ofcChrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEffDtDivCd = this.toEffDtDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEffDtDivCd = this.fmEffDtDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEffDt = this.fmEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpGrpNm = this.dpGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
