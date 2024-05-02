/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChargeDeltSpecRsnRmkVO.java
*@FileTitle : ChargeDeltSpecRsnRmkVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.14  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo;

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
 * @author  
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ChargeDeltSpecRsnRmkVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ChargeDeltSpecRsnRmkVO> models = new ArrayList<ChargeDeltSpecRsnRmkVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String deltRmkLvl = null;
	/* Column Info */
	private String deltSpecRsnRmkSeq = null;
	/* Column Info */
	private String deltRmk = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String dmdtChgDeltSpecRsnCd = null;
	/* Column Info */
	private String deltSpecRsnRmk = null;	
	
	/* Column Info */
	private String svrId = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrCycNo = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String dmdtChgLocDivCd = null;
	/* Column Info */
	private String chgSeq = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String chgType = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ChargeDeltSpecRsnRmkVO() {}

	public ChargeDeltSpecRsnRmkVO(String ibflag, String pagerows, String deltSpecRsnRmkSeq, String deltRmkLvl, String creUsrId, String creDt, String updUsrId, String updDt, String deltRmk, String creOfcCd, String updOfcCd, String dmdtChgDeltSpecRsnCd, String deltSpecRsnRmk, String svrId, String cntrNo, String cntrCycNo, String dmdtTrfCd, String dmdtChgLocDivCd, String chgSeq, String bkgNo, String chgType, String ofcCd) {
		this.updDt = updDt;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.deltRmkLvl = deltRmkLvl;
		this.deltSpecRsnRmkSeq = deltSpecRsnRmkSeq;
		this.deltRmk = deltRmk;
		this.creDt = creDt;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
		this.creOfcCd = creOfcCd;
		this.updOfcCd = updOfcCd;
		this.dmdtChgDeltSpecRsnCd = dmdtChgDeltSpecRsnCd;
		this.deltSpecRsnRmk = deltSpecRsnRmk;
		this.svrId = svrId;
		this.cntrNo = cntrNo;
		this.cntrCycNo = cntrCycNo;
		this.dmdtTrfCd = dmdtTrfCd;
		this.dmdtChgLocDivCd = dmdtChgLocDivCd;
		this.chgSeq = chgSeq;
		this.ofcCd = ofcCd;
		this.bkgNo = bkgNo;
		this.chgType = chgType;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("delt_rmk_lvl", getDeltRmkLvl());
		this.hashColumns.put("delt_spec_rsn_rmk_seq", getDeltSpecRsnRmkSeq());
		this.hashColumns.put("delt_rmk", getDeltRmk());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("dmdt_chg_delt_spec_rsn_cd", getDmdtChgDeltSpecRsnCd());
		this.hashColumns.put("delt_spec_rsn_rmk", getDeltSpecRsnRmk());
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_cyc_no", getCntrCycNo());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("dmdt_chg_loc_div_cd", getDmdtChgLocDivCd());
		this.hashColumns.put("chg_seq", getChgSeq());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("chg_type", getChgType());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("delt_rmk_lvl", "deltRmkLvl");
		this.hashFields.put("delt_spec_rsn_rmk_seq", "deltSpecRsnRmkSeq");
		this.hashFields.put("delt_rmk", "deltRmk");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("dmdt_chg_delt_spec_rsn_cd", "dmdtChgDeltSpecRsnCd");
		this.hashFields.put("delt_spec_rsn_rmk", "deltSpecRsnRmk");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_cyc_no", "cntrCycNo");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("dmdt_chg_loc_div_cd", "dmdtChgLocDivCd");
		this.hashFields.put("chg_seq", "chgSeq");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("chg_type", "chgType");
		return this.hashFields;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return deltRmkLvl
	 */
	public String getDeltRmkLvl() {
		return this.deltRmkLvl;
	}
	
	/**
	 * Column Info
	 * @return deltSpecRsnRmkSeq
	 */
	public String getDeltSpecRsnRmkSeq() {
		return this.deltSpecRsnRmkSeq;
	}
	
	/**
	 * Column Info
	 * @return deltRmk
	 */
	public String getDeltRmk() {
		return this.deltRmk;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return updOfcCd
	 */
	public String getUpdOfcCd() {
		return this.updOfcCd;
	}	
	
	/**
	 * Column Info
	 * @return dmdtChgDeltSpecRsnCd
	 */
	public String getDmdtChgDeltSpecRsnCd() {
		return this.dmdtChgDeltSpecRsnCd;
	}
	
	/**
	 * Column Info
	 * @return deltSpecRsnRmk
	 */
	public String getDeltSpecRsnRmk() {
		return this.deltSpecRsnRmk;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param deltRmkLvl
	 */
	public void setDeltRmkLvl(String deltRmkLvl) {
		this.deltRmkLvl = deltRmkLvl;
	}
	
	/**
	 * Column Info
	 * @param deltSpecRsnRmkSeq
	 */
	public void setDeltSpecRsnRmkSeq(String deltSpecRsnRmkSeq) {
		this.deltSpecRsnRmkSeq = deltSpecRsnRmkSeq;
	}
	
	/**
	 * Column Info
	 * @param deltRmk
	 */
	public void setDeltRmk(String deltRmk) {
		this.deltRmk = deltRmk;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param updOfcCd
	 */
	public void setUpdOfcCd(String updOfcCd) {
		this.updOfcCd = updOfcCd;
	}	
	
	/**
	 * Column Info
	 * @param dmdtChgDeltSpecRsnCd
	 */
	public void setDmdtChgDeltSpecRsnCd(String dmdtChgDeltSpecRsnCd) {
		this.dmdtChgDeltSpecRsnCd = dmdtChgDeltSpecRsnCd;
	}	
	
	/**
	 * Column Info
	 * @param deltSpecRsnRmk
	 */
	public void setDeltSpecRsnRmk(String deltSpecRsnRmk) {
		this.deltSpecRsnRmk = deltSpecRsnRmk;
	}	
	
	public String getSvrId() {
		return svrId;
	}

	public void setSvrId(String svrId) {
		this.svrId = svrId;
	}

	public String getCntrNo() {
		return cntrNo;
	}

	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	public String getCntrCycNo() {
		return cntrCycNo;
	}

	public void setCntrCycNo(String cntrCycNo) {
		this.cntrCycNo = cntrCycNo;
	}

	public String getDmdtTrfCd() {
		return dmdtTrfCd;
	}

	public void setDmdtTrfCd(String dmdtTrfCd) {
		this.dmdtTrfCd = dmdtTrfCd;
	}

	public String getDmdtChgLocDivCd() {
		return dmdtChgLocDivCd;
	}

	public void setDmdtChgLocDivCd(String dmdtChgLocDivCd) {
		this.dmdtChgLocDivCd = dmdtChgLocDivCd;
	}

	public String getChgSeq() {
		return chgSeq;
	}

	public void setChgSeq(String chgSeq) {
		this.chgSeq = chgSeq;
	}

	public String getBkgNo() {
		return bkgNo;
	}

	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	public String getChgType() {
		return chgType;
	}

	public void setChgType(String chgType) {
		this.chgType = chgType;
	}

	public String getOfcCd() {
		return ofcCd;
	}

	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDeltRmkLvl(JSPUtil.getParameter(request, prefix + "delt_rmk_lvl", ""));
		setDeltSpecRsnRmkSeq(JSPUtil.getParameter(request, prefix + "delt_spec_rsn_rmk_seq", ""));
		setDeltRmk(JSPUtil.getParameter(request, prefix + "delt_rmk", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, prefix + "upd_ofc_cd", ""));
		setDmdtChgDeltSpecRsnCd(JSPUtil.getParameter(request, prefix + "dmdt_chg_delt_spec_rsn_cd", ""));
		setDeltSpecRsnRmk(JSPUtil.getParameter(request, prefix + "delt_spec_rsn_rmk", ""));
		

		setSvrId(JSPUtil.getParameter(request, prefix + "svr_id", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCntrCycNo(JSPUtil.getParameter(request, prefix + "cntr_cyc_no", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, prefix + "dmdt_trf_cd", ""));
		setDmdtChgLocDivCd(JSPUtil.getParameter(request, prefix + "dmdt_chg_loc_div_cd", ""));
		setChgSeq(JSPUtil.getParameter(request, prefix + "chg_seq", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setChgType(JSPUtil.getParameter(request, prefix + "chg_type", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChargeDeltSpecRsnRmkVO[]
	 */
	public ChargeDeltSpecRsnRmkVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ChargeDeltSpecRsnRmkVO[]
	 */
	public ChargeDeltSpecRsnRmkVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChargeDeltSpecRsnRmkVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] deltRmkLvl = (JSPUtil.getParameter(request, prefix	+ "delt_rmk_lvl", length));
			String[] deltSpecRsnRmkSeq = (JSPUtil.getParameter(request, prefix	+ "delt_spec_rsn_rmk_seq", length));
			String[] deltRmk = (JSPUtil.getParameter(request, prefix	+ "delt_rmk", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] dmdtChgDeltSpecRsnCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_delt_spec_rsn_cd", length));
			String[] deltSpecRsnRmk = (JSPUtil.getParameter(request, prefix	+ "delt_spec_rsn_rmk", length));

			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrCycNo = (JSPUtil.getParameter(request, prefix	+ "cntr_cyc_no", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] dmdtChgLocDivCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_loc_div_cd", length));
			String[] chgSeq = (JSPUtil.getParameter(request, prefix	+ "chg_seq", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] chgType = (JSPUtil.getParameter(request, prefix	+ "chg_type", length));
			
			for (int i = 0; i < length; i++) {
				model = new ChargeDeltSpecRsnRmkVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (deltRmkLvl[i] != null)
					model.setDeltRmkLvl(deltRmkLvl[i]);
				if (deltSpecRsnRmkSeq[i] != null)
					model.setDeltSpecRsnRmkSeq(deltSpecRsnRmkSeq[i]);
				if (deltRmk[i] != null)
					model.setDeltRmk(deltRmk[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);		
				if (dmdtChgDeltSpecRsnCd[i] != null)
					model.setDmdtChgDeltSpecRsnCd(dmdtChgDeltSpecRsnCd[i]);	
				if (deltSpecRsnRmk[i] != null)
					model.setDeltSpecRsnRmk(deltSpecRsnRmk[i]);			

				if (svrId[i] != null)
					model.setSvrId(svrId[i]);		
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);		
				if (cntrCycNo[i] != null)
					model.setCntrCycNo(cntrCycNo[i]);		
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);		
				if (dmdtChgLocDivCd[i] != null)
					model.setDmdtChgLocDivCd(dmdtChgLocDivCd[i]);		
				if (chgSeq[i] != null)
					model.setChgSeq(chgSeq[i]);		
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);		
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);		
				if (chgType[i] != null)
					model.setChgType(chgType[i]);		
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChargeDeltSpecRsnRmkVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChargeDeltSpecRsnRmkVO[]
	 */
	public ChargeDeltSpecRsnRmkVO[] getChargeDeltSpecRsnRmkVOs(){
		ChargeDeltSpecRsnRmkVO[] vos = (ChargeDeltSpecRsnRmkVO[])models.toArray(new ChargeDeltSpecRsnRmkVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltRmkLvl = this.deltRmkLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltSpecRsnRmkSeq = this.deltSpecRsnRmkSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltRmk = this.deltRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtChgDeltSpecRsnCd = this.dmdtChgDeltSpecRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltSpecRsnRmk = this.deltSpecRsnRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCycNo = this.cntrCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtChgLocDivCd = this.dmdtChgLocDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSeq = this.chgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgType = this.chgType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
