/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : UpdateRatioDetailVO.java
*@FileTitle : UpdateRatioDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.07
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2011.03.07 김상수 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo;

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
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UpdateRatioDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UpdateRatioDetailVO> models = new ArrayList<UpdateRatioDetailVO>();
	
	/* Column Info */
	private String offsetDt = null;
	/* Column Info */
	private String pYard = null;
	/* Column Info */
	private String mvmtInpTpCd = null;
	/* Column Info */
	private String cnmvEvntDt = null;
	/* Column Info */
	private String rccCd = null;
	/* Column Info */
	private String orgYdCd = null;
	/* Column Info */
	private String fcntrFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String obCntrFlg = null;
	/* Column Info */
	private String stsCd = null;
	/* Column Info */
	private String lccCd = null;
	/* Column Info */
	private String pDate1 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mvmtStsCd = null;
	/* Column Info */
	private String pDate2 = null;
	/* Column Info */
	private String creLoclDt = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String timeOff = null;
	/* Column Info */
	private String pYard1 = null;
	/* Column Info */
	private String ediType = null;
	/* Column Info */
	private String gap = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UpdateRatioDetailVO() {}

	public UpdateRatioDetailVO(String ibflag, String pagerows, String cnmvEvntDt, String cntrNo, String cntrTpszCd, String creLoclDt, String ediType, String fcntrFlg, String gap, String lccCd, String mvmtInpTpCd, String mvmtStsCd, String obCntrFlg, String offsetDt, String orgYdCd, String pDate1, String pDate2, String pYard, String pYard1, String rccCd, String stsCd, String timeOff) {
		this.offsetDt = offsetDt;
		this.pYard = pYard;
		this.mvmtInpTpCd = mvmtInpTpCd;
		this.cnmvEvntDt = cnmvEvntDt;
		this.rccCd = rccCd;
		this.orgYdCd = orgYdCd;
		this.fcntrFlg = fcntrFlg;
		this.pagerows = pagerows;
		this.obCntrFlg = obCntrFlg;
		this.stsCd = stsCd;
		this.lccCd = lccCd;
		this.pDate1 = pDate1;
		this.ibflag = ibflag;
		this.mvmtStsCd = mvmtStsCd;
		this.pDate2 = pDate2;
		this.creLoclDt = creLoclDt;
		this.cntrNo = cntrNo;
		this.cntrTpszCd = cntrTpszCd;
		this.timeOff = timeOff;
		this.pYard1 = pYard1;
		this.ediType = ediType;
		this.gap = gap;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("offset_dt", getOffsetDt());
		this.hashColumns.put("p_yard", getPYard());
		this.hashColumns.put("mvmt_inp_tp_cd", getMvmtInpTpCd());
		this.hashColumns.put("cnmv_evnt_dt", getCnmvEvntDt());
		this.hashColumns.put("rcc_cd", getRccCd());
		this.hashColumns.put("org_yd_cd", getOrgYdCd());
		this.hashColumns.put("fcntr_flg", getFcntrFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ob_cntr_flg", getObCntrFlg());
		this.hashColumns.put("sts_cd", getStsCd());
		this.hashColumns.put("lcc_cd", getLccCd());
		this.hashColumns.put("p_date1", getPDate1());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mvmt_sts_cd", getMvmtStsCd());
		this.hashColumns.put("p_date2", getPDate2());
		this.hashColumns.put("cre_locl_dt", getCreLoclDt());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("time_off", getTimeOff());
		this.hashColumns.put("p_yard1", getPYard1());
		this.hashColumns.put("edi_type", getEdiType());
		this.hashColumns.put("gap", getGap());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("offset_dt", "offsetDt");
		this.hashFields.put("p_yard", "pYard");
		this.hashFields.put("mvmt_inp_tp_cd", "mvmtInpTpCd");
		this.hashFields.put("cnmv_evnt_dt", "cnmvEvntDt");
		this.hashFields.put("rcc_cd", "rccCd");
		this.hashFields.put("org_yd_cd", "orgYdCd");
		this.hashFields.put("fcntr_flg", "fcntrFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ob_cntr_flg", "obCntrFlg");
		this.hashFields.put("sts_cd", "stsCd");
		this.hashFields.put("lcc_cd", "lccCd");
		this.hashFields.put("p_date1", "pDate1");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mvmt_sts_cd", "mvmtStsCd");
		this.hashFields.put("p_date2", "pDate2");
		this.hashFields.put("cre_locl_dt", "creLoclDt");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("time_off", "timeOff");
		this.hashFields.put("p_yard1", "pYard1");
		this.hashFields.put("edi_type", "ediType");
		this.hashFields.put("gap", "gap");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return offsetDt
	 */
	public String getOffsetDt() {
		return this.offsetDt;
	}
	
	/**
	 * Column Info
	 * @return pYard
	 */
	public String getPYard() {
		return this.pYard;
	}
	
	/**
	 * Column Info
	 * @return mvmtInpTpCd
	 */
	public String getMvmtInpTpCd() {
		return this.mvmtInpTpCd;
	}
	
	/**
	 * Column Info
	 * @return cnmvEvntDt
	 */
	public String getCnmvEvntDt() {
		return this.cnmvEvntDt;
	}
	
	/**
	 * Column Info
	 * @return rccCd
	 */
	public String getRccCd() {
		return this.rccCd;
	}
	
	/**
	 * Column Info
	 * @return orgYdCd
	 */
	public String getOrgYdCd() {
		return this.orgYdCd;
	}
	
	/**
	 * Column Info
	 * @return fcntrFlg
	 */
	public String getFcntrFlg() {
		return this.fcntrFlg;
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
	 * @return obCntrFlg
	 */
	public String getObCntrFlg() {
		return this.obCntrFlg;
	}
	
	/**
	 * Column Info
	 * @return stsCd
	 */
	public String getStsCd() {
		return this.stsCd;
	}
	
	/**
	 * Column Info
	 * @return lccCd
	 */
	public String getLccCd() {
		return this.lccCd;
	}
	
	/**
	 * Column Info
	 * @return pDate1
	 */
	public String getPDate1() {
		return this.pDate1;
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
	 * @return mvmtStsCd
	 */
	public String getMvmtStsCd() {
		return this.mvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @return pDate2
	 */
	public String getPDate2() {
		return this.pDate2;
	}
	
	/**
	 * Column Info
	 * @return creLoclDt
	 */
	public String getCreLoclDt() {
		return this.creLoclDt;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return timeOff
	 */
	public String getTimeOff() {
		return this.timeOff;
	}
	
	/**
	 * Column Info
	 * @return pYard1
	 */
	public String getPYard1() {
		return this.pYard1;
	}
	
	/**
	 * Column Info
	 * @return ediType
	 */
	public String getEdiType() {
		return this.ediType;
	}
	
	/**
	 * Column Info
	 * @return gap
	 */
	public String getGap() {
		return this.gap;
	}
	

	/**
	 * Column Info
	 * @param offsetDt
	 */
	public void setOffsetDt(String offsetDt) {
		this.offsetDt = offsetDt;
	}
	
	/**
	 * Column Info
	 * @param pYard
	 */
	public void setPYard(String pYard) {
		this.pYard = pYard;
	}
	
	/**
	 * Column Info
	 * @param mvmtInpTpCd
	 */
	public void setMvmtInpTpCd(String mvmtInpTpCd) {
		this.mvmtInpTpCd = mvmtInpTpCd;
	}
	
	/**
	 * Column Info
	 * @param cnmvEvntDt
	 */
	public void setCnmvEvntDt(String cnmvEvntDt) {
		this.cnmvEvntDt = cnmvEvntDt;
	}
	
	/**
	 * Column Info
	 * @param rccCd
	 */
	public void setRccCd(String rccCd) {
		this.rccCd = rccCd;
	}
	
	/**
	 * Column Info
	 * @param orgYdCd
	 */
	public void setOrgYdCd(String orgYdCd) {
		this.orgYdCd = orgYdCd;
	}
	
	/**
	 * Column Info
	 * @param fcntrFlg
	 */
	public void setFcntrFlg(String fcntrFlg) {
		this.fcntrFlg = fcntrFlg;
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
	 * @param obCntrFlg
	 */
	public void setObCntrFlg(String obCntrFlg) {
		this.obCntrFlg = obCntrFlg;
	}
	
	/**
	 * Column Info
	 * @param stsCd
	 */
	public void setStsCd(String stsCd) {
		this.stsCd = stsCd;
	}
	
	/**
	 * Column Info
	 * @param lccCd
	 */
	public void setLccCd(String lccCd) {
		this.lccCd = lccCd;
	}
	
	/**
	 * Column Info
	 * @param pDate1
	 */
	public void setPDate1(String pDate1) {
		this.pDate1 = pDate1;
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
	 * @param mvmtStsCd
	 */
	public void setMvmtStsCd(String mvmtStsCd) {
		this.mvmtStsCd = mvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @param pDate2
	 */
	public void setPDate2(String pDate2) {
		this.pDate2 = pDate2;
	}
	
	/**
	 * Column Info
	 * @param creLoclDt
	 */
	public void setCreLoclDt(String creLoclDt) {
		this.creLoclDt = creLoclDt;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param timeOff
	 */
	public void setTimeOff(String timeOff) {
		this.timeOff = timeOff;
	}
	
	/**
	 * Column Info
	 * @param pYard1
	 */
	public void setPYard1(String pYard1) {
		this.pYard1 = pYard1;
	}
	
	/**
	 * Column Info
	 * @param ediType
	 */
	public void setEdiType(String ediType) {
		this.ediType = ediType;
	}
	
	/**
	 * Column Info
	 * @param gap
	 */
	public void setGap(String gap) {
		this.gap = gap;
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
		setOffsetDt(JSPUtil.getParameter(request, prefix + "offset_dt", ""));
		setPYard(JSPUtil.getParameter(request, prefix + "p_yard", ""));
		setMvmtInpTpCd(JSPUtil.getParameter(request, prefix + "mvmt_inp_tp_cd", ""));
		setCnmvEvntDt(JSPUtil.getParameter(request, prefix + "cnmv_evnt_dt", ""));
		setRccCd(JSPUtil.getParameter(request, prefix + "rcc_cd", ""));
		setOrgYdCd(JSPUtil.getParameter(request, prefix + "org_yd_cd", ""));
		setFcntrFlg(JSPUtil.getParameter(request, prefix + "fcntr_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setObCntrFlg(JSPUtil.getParameter(request, prefix + "ob_cntr_flg", ""));
		setStsCd(JSPUtil.getParameter(request, prefix + "sts_cd", ""));
		setLccCd(JSPUtil.getParameter(request, prefix + "lcc_cd", ""));
		setPDate1(JSPUtil.getParameter(request, prefix + "p_date1", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMvmtStsCd(JSPUtil.getParameter(request, prefix + "mvmt_sts_cd", ""));
		setPDate2(JSPUtil.getParameter(request, prefix + "p_date2", ""));
		setCreLoclDt(JSPUtil.getParameter(request, prefix + "cre_locl_dt", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setTimeOff(JSPUtil.getParameter(request, prefix + "time_off", ""));
		setPYard1(JSPUtil.getParameter(request, prefix + "p_yard1", ""));
		setEdiType(JSPUtil.getParameter(request, prefix + "edi_type", ""));
		setGap(JSPUtil.getParameter(request, prefix + "gap", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UpdateRatioDetailVO[]
	 */
	public UpdateRatioDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UpdateRatioDetailVO[]
	 */
	public UpdateRatioDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UpdateRatioDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] offsetDt = (JSPUtil.getParameter(request, prefix	+ "offset_dt", length));
			String[] pYard = (JSPUtil.getParameter(request, prefix	+ "p_yard", length));
			String[] mvmtInpTpCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_inp_tp_cd", length));
			String[] cnmvEvntDt = (JSPUtil.getParameter(request, prefix	+ "cnmv_evnt_dt", length));
			String[] rccCd = (JSPUtil.getParameter(request, prefix	+ "rcc_cd", length));
			String[] orgYdCd = (JSPUtil.getParameter(request, prefix	+ "org_yd_cd", length));
			String[] fcntrFlg = (JSPUtil.getParameter(request, prefix	+ "fcntr_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] obCntrFlg = (JSPUtil.getParameter(request, prefix	+ "ob_cntr_flg", length));
			String[] stsCd = (JSPUtil.getParameter(request, prefix	+ "sts_cd", length));
			String[] lccCd = (JSPUtil.getParameter(request, prefix	+ "lcc_cd", length));
			String[] pDate1 = (JSPUtil.getParameter(request, prefix	+ "p_date1", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_sts_cd", length));
			String[] pDate2 = (JSPUtil.getParameter(request, prefix	+ "p_date2", length));
			String[] creLoclDt = (JSPUtil.getParameter(request, prefix	+ "cre_locl_dt", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] timeOff = (JSPUtil.getParameter(request, prefix	+ "time_off", length));
			String[] pYard1 = (JSPUtil.getParameter(request, prefix	+ "p_yard1", length));
			String[] ediType = (JSPUtil.getParameter(request, prefix	+ "edi_type", length));
			String[] gap = (JSPUtil.getParameter(request, prefix	+ "gap", length));
			
			for (int i = 0; i < length; i++) {
				model = new UpdateRatioDetailVO();
				if (offsetDt[i] != null)
					model.setOffsetDt(offsetDt[i]);
				if (pYard[i] != null)
					model.setPYard(pYard[i]);
				if (mvmtInpTpCd[i] != null)
					model.setMvmtInpTpCd(mvmtInpTpCd[i]);
				if (cnmvEvntDt[i] != null)
					model.setCnmvEvntDt(cnmvEvntDt[i]);
				if (rccCd[i] != null)
					model.setRccCd(rccCd[i]);
				if (orgYdCd[i] != null)
					model.setOrgYdCd(orgYdCd[i]);
				if (fcntrFlg[i] != null)
					model.setFcntrFlg(fcntrFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (obCntrFlg[i] != null)
					model.setObCntrFlg(obCntrFlg[i]);
				if (stsCd[i] != null)
					model.setStsCd(stsCd[i]);
				if (lccCd[i] != null)
					model.setLccCd(lccCd[i]);
				if (pDate1[i] != null)
					model.setPDate1(pDate1[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mvmtStsCd[i] != null)
					model.setMvmtStsCd(mvmtStsCd[i]);
				if (pDate2[i] != null)
					model.setPDate2(pDate2[i]);
				if (creLoclDt[i] != null)
					model.setCreLoclDt(creLoclDt[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (timeOff[i] != null)
					model.setTimeOff(timeOff[i]);
				if (pYard1[i] != null)
					model.setPYard1(pYard1[i]);
				if (ediType[i] != null)
					model.setEdiType(ediType[i]);
				if (gap[i] != null)
					model.setGap(gap[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUpdateRatioDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UpdateRatioDetailVO[]
	 */
	public UpdateRatioDetailVO[] getUpdateRatioDetailVOs(){
		UpdateRatioDetailVO[] vos = (UpdateRatioDetailVO[])models.toArray(new UpdateRatioDetailVO[models.size()]);
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
		this.offsetDt = this.offsetDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pYard = this.pYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtInpTpCd = this.mvmtInpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvEvntDt = this.cnmvEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccCd = this.rccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYdCd = this.orgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcntrFlg = this.fcntrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obCntrFlg = this.obCntrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsCd = this.stsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lccCd = this.lccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate1 = this.pDate1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCd = this.mvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate2 = this.pDate2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creLoclDt = this.creLoclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.timeOff = this.timeOff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pYard1 = this.pYard1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediType = this.ediType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gap = this.gap .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
