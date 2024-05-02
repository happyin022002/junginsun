/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MASCreateMonitorVO.java
*@FileTitle : MASCreateMonitorVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.29
*@LastModifier : 유제량
*@LastVersion : 1.0
* 2015.06.29 유제량 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 유제량
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MASCreateMonitorVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MASCreateMonitorVO> models = new ArrayList<MASCreateMonitorVO>();
	
	/* Column Info */
	private String costQtr = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String fChkprd = null;
	/* Column Info */
	private String fFmWk = null;
	/* Column Info */
	private String fFmMon = null;
	/* Column Info */
	private String fToMon = null;
	/* Column Info */
	private String stndCostNm = null;
	/* Column Info */
	private String costCreStsCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fToWk = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String fChkcost = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String mgrpCostCdDesc = null;
	/* Column Info */
	private String fYear = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public MASCreateMonitorVO() {}

	public MASCreateMonitorVO(String ibflag, String pagerows, String costCreStsCd, String costYrmon, String costWk, String costQtr, String mgrpCostCdDesc, String stndCostNm, String updUsrId, String updDt, String fChkprd, String fYear, String fFmMon, String fToMon, String fFmWk, String fToWk, String fChkcost) {
		this.costQtr = costQtr;
		this.updDt = updDt;
		this.fChkprd = fChkprd;
		this.fFmWk = fFmWk;
		this.fFmMon = fFmMon;
		this.fToMon = fToMon;
		this.stndCostNm = stndCostNm;
		this.costCreStsCd = costCreStsCd;
		this.pagerows = pagerows;
		this.fToWk = fToWk;
		this.ibflag = ibflag;
		this.costYrmon = costYrmon;
		this.costWk = costWk;
		this.fChkcost = fChkcost;
		this.updUsrId = updUsrId;
		this.mgrpCostCdDesc = mgrpCostCdDesc;
		this.fYear = fYear;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cost_qtr", getCostQtr());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("f_chkprd", getFChkprd());
		this.hashColumns.put("f_fm_wk", getFFmWk());
		this.hashColumns.put("f_fm_mon", getFFmMon());
		this.hashColumns.put("f_to_mon", getFToMon());
		this.hashColumns.put("stnd_cost_nm", getStndCostNm());
		this.hashColumns.put("cost_cre_sts_cd", getCostCreStsCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("f_to_wk", getFToWk());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("f_chkcost", getFChkcost());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("mgrp_cost_cd_desc", getMgrpCostCdDesc());
		this.hashColumns.put("f_year", getFYear());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cost_qtr", "costQtr");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("f_chkprd", "fChkprd");
		this.hashFields.put("f_fm_wk", "fFmWk");
		this.hashFields.put("f_fm_mon", "fFmMon");
		this.hashFields.put("f_to_mon", "fToMon");
		this.hashFields.put("stnd_cost_nm", "stndCostNm");
		this.hashFields.put("cost_cre_sts_cd", "costCreStsCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("f_to_wk", "fToWk");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("f_chkcost", "fChkcost");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("mgrp_cost_cd_desc", "mgrpCostCdDesc");
		this.hashFields.put("f_year", "fYear");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return costQtr
	 */
	public String getCostQtr() {
		return this.costQtr;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return fChkprd
	 */
	public String getFChkprd() {
		return this.fChkprd;
	}
	
	/**
	 * Column Info
	 * @return fFmWk
	 */
	public String getFFmWk() {
		return this.fFmWk;
	}
	
	/**
	 * Column Info
	 * @return fFmMon
	 */
	public String getFFmMon() {
		return this.fFmMon;
	}
	
	/**
	 * Column Info
	 * @return fToMon
	 */
	public String getFToMon() {
		return this.fToMon;
	}
	
	/**
	 * Column Info
	 * @return stndCostNm
	 */
	public String getStndCostNm() {
		return this.stndCostNm;
	}
	
	/**
	 * Column Info
	 * @return costCreStsCd
	 */
	public String getCostCreStsCd() {
		return this.costCreStsCd;
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
	 * @return fToWk
	 */
	public String getFToWk() {
		return this.fToWk;
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
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
	}
	
	/**
	 * Column Info
	 * @return costWk
	 */
	public String getCostWk() {
		return this.costWk;
	}
	
	/**
	 * Column Info
	 * @return fChkcost
	 */
	public String getFChkcost() {
		return this.fChkcost;
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
	 * @return mgrpCostCdDesc
	 */
	public String getMgrpCostCdDesc() {
		return this.mgrpCostCdDesc;
	}
	
	/**
	 * Column Info
	 * @return fYear
	 */
	public String getFYear() {
		return this.fYear;
	}
	

	/**
	 * Column Info
	 * @param costQtr
	 */
	public void setCostQtr(String costQtr) {
		this.costQtr = costQtr;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param fChkprd
	 */
	public void setFChkprd(String fChkprd) {
		this.fChkprd = fChkprd;
	}
	
	/**
	 * Column Info
	 * @param fFmWk
	 */
	public void setFFmWk(String fFmWk) {
		this.fFmWk = fFmWk;
	}
	
	/**
	 * Column Info
	 * @param fFmMon
	 */
	public void setFFmMon(String fFmMon) {
		this.fFmMon = fFmMon;
	}
	
	/**
	 * Column Info
	 * @param fToMon
	 */
	public void setFToMon(String fToMon) {
		this.fToMon = fToMon;
	}
	
	/**
	 * Column Info
	 * @param stndCostNm
	 */
	public void setStndCostNm(String stndCostNm) {
		this.stndCostNm = stndCostNm;
	}
	
	/**
	 * Column Info
	 * @param costCreStsCd
	 */
	public void setCostCreStsCd(String costCreStsCd) {
		this.costCreStsCd = costCreStsCd;
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
	 * @param fToWk
	 */
	public void setFToWk(String fToWk) {
		this.fToWk = fToWk;
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
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
	}
	
	/**
	 * Column Info
	 * @param costWk
	 */
	public void setCostWk(String costWk) {
		this.costWk = costWk;
	}
	
	/**
	 * Column Info
	 * @param fChkcost
	 */
	public void setFChkcost(String fChkcost) {
		this.fChkcost = fChkcost;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param mgrpCostCdDesc
	 */
	public void setMgrpCostCdDesc(String mgrpCostCdDesc) {
		this.mgrpCostCdDesc = mgrpCostCdDesc;
	}
	
	/**
	 * Column Info
	 * @param fYear
	 */
	public void setFYear(String fYear) {
		this.fYear = fYear;
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
		setCostQtr(JSPUtil.getParameter(request, prefix + "cost_qtr", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setFChkprd(JSPUtil.getParameter(request, prefix + "f_chkprd", ""));
		setFFmWk(JSPUtil.getParameter(request, prefix + "f_fm_wk", ""));
		setFFmMon(JSPUtil.getParameter(request, prefix + "f_fm_mon", ""));
		setFToMon(JSPUtil.getParameter(request, prefix + "f_to_mon", ""));
		setStndCostNm(JSPUtil.getParameter(request, prefix + "stnd_cost_nm", ""));
		setCostCreStsCd(JSPUtil.getParameter(request, prefix + "cost_cre_sts_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFToWk(JSPUtil.getParameter(request, prefix + "f_to_wk", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setCostWk(JSPUtil.getParameter(request, prefix + "cost_wk", ""));
		setFChkcost(JSPUtil.getParameter(request, prefix + "f_chkcost", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setMgrpCostCdDesc(JSPUtil.getParameter(request, prefix + "mgrp_cost_cd_desc", ""));
		setFYear(JSPUtil.getParameter(request, prefix + "f_year", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MASCreateMonitorVO[]
	 */
	public MASCreateMonitorVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MASCreateMonitorVO[]
	 */
	public MASCreateMonitorVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MASCreateMonitorVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] costQtr = (JSPUtil.getParameter(request, prefix	+ "cost_qtr", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] fChkprd = (JSPUtil.getParameter(request, prefix	+ "f_chkprd", length));
			String[] fFmWk = (JSPUtil.getParameter(request, prefix	+ "f_fm_wk", length));
			String[] fFmMon = (JSPUtil.getParameter(request, prefix	+ "f_fm_mon", length));
			String[] fToMon = (JSPUtil.getParameter(request, prefix	+ "f_to_mon", length));
			String[] stndCostNm = (JSPUtil.getParameter(request, prefix	+ "stnd_cost_nm", length));
			String[] costCreStsCd = (JSPUtil.getParameter(request, prefix	+ "cost_cre_sts_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fToWk = (JSPUtil.getParameter(request, prefix	+ "f_to_wk", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] fChkcost = (JSPUtil.getParameter(request, prefix	+ "f_chkcost", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] mgrpCostCdDesc = (JSPUtil.getParameter(request, prefix	+ "mgrp_cost_cd_desc", length));
			String[] fYear = (JSPUtil.getParameter(request, prefix	+ "f_year", length));
			
			for (int i = 0; i < length; i++) {
				model = new MASCreateMonitorVO();
				if (costQtr[i] != null)
					model.setCostQtr(costQtr[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (fChkprd[i] != null)
					model.setFChkprd(fChkprd[i]);
				if (fFmWk[i] != null)
					model.setFFmWk(fFmWk[i]);
				if (fFmMon[i] != null)
					model.setFFmMon(fFmMon[i]);
				if (fToMon[i] != null)
					model.setFToMon(fToMon[i]);
				if (stndCostNm[i] != null)
					model.setStndCostNm(stndCostNm[i]);
				if (costCreStsCd[i] != null)
					model.setCostCreStsCd(costCreStsCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fToWk[i] != null)
					model.setFToWk(fToWk[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (fChkcost[i] != null)
					model.setFChkcost(fChkcost[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (mgrpCostCdDesc[i] != null)
					model.setMgrpCostCdDesc(mgrpCostCdDesc[i]);
				if (fYear[i] != null)
					model.setFYear(fYear[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMASCreateMonitorVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MASCreateMonitorVO[]
	 */
	public MASCreateMonitorVO[] getMASCreateMonitorVOs(){
		MASCreateMonitorVO[] vos = (MASCreateMonitorVO[])models.toArray(new MASCreateMonitorVO[models.size()]);
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
		this.costQtr = this.costQtr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fChkprd = this.fChkprd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFmWk = this.fFmWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFmMon = this.fFmMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fToMon = this.fToMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndCostNm = this.stndCostNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCreStsCd = this.costCreStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fToWk = this.fToWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fChkcost = this.fChkcost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgrpCostCdDesc = this.mgrpCostCdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fYear = this.fYear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
