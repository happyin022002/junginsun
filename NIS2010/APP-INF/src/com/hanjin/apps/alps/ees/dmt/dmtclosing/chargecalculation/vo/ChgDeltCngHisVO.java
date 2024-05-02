/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChgDeltChgHisVO.java
*@FileTitle : ChgDeltChgHisVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.29  
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

public class ChgDeltCngHisVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ChgDeltCngHisVO> models = new ArrayList<ChgDeltCngHisVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String dmdtChgLocDivCd = null;
	/* Column Info */
	private String cntrCycNo = null;
	/* Column Info */
	private String deltCngHisSeq = null;
	/* Column Info */
	private String deltSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String emlSndNo = null;
	/* Column Info */
	private String chgSeq = null;
	/* Column Info */
	private String sysAreaGrpId = null;
	/* Column Info */
	private String chgDeltPathCd = null;
	/* Column Info */
	private String chgDeltStsCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String chgDeltUsrId = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String chgOfcCd = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String inactRmk = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ChgDeltCngHisVO() {}

	public ChgDeltCngHisVO(String ibflag, String pagerows, String sysAreaGrpId, String cntrNo, String cntrCycNo, String dmdtTrfCd, String dmdtChgLocDivCd, String chgSeq, String chgOfcCd, String deltSeq, String deltCngHisSeq, String chgDeltPathCd, String chgDeltUsrId, String chgDeltStsCd, String emlSndNo, String creUsrId, String creDt, String creOfcCd, String updUsrId, String updDt, String updOfcCd, String inactRmk) {
		this.updDt = updDt;
		this.dmdtChgLocDivCd = dmdtChgLocDivCd;
		this.cntrCycNo = cntrCycNo;
		this.deltCngHisSeq = deltCngHisSeq;
		this.deltSeq = deltSeq;
		this.creDt = creDt;
		this.emlSndNo = emlSndNo;
		this.chgSeq = chgSeq;
		this.sysAreaGrpId = sysAreaGrpId;
		this.chgDeltPathCd = chgDeltPathCd;
		this.chgDeltStsCd = chgDeltStsCd;
		this.pagerows = pagerows;
		this.chgDeltUsrId = chgDeltUsrId;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.chgOfcCd = chgOfcCd;
		this.creOfcCd = creOfcCd;
		this.cntrNo = cntrNo;
		this.updOfcCd = updOfcCd;
		this.updUsrId = updUsrId;
		this.dmdtTrfCd = dmdtTrfCd;
		this.inactRmk = inactRmk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("dmdt_chg_loc_div_cd", getDmdtChgLocDivCd());
		this.hashColumns.put("cntr_cyc_no", getCntrCycNo());
		this.hashColumns.put("delt_cng_his_seq", getDeltCngHisSeq());
		this.hashColumns.put("delt_seq", getDeltSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("eml_snd_no", getEmlSndNo());
		this.hashColumns.put("chg_seq", getChgSeq());
		this.hashColumns.put("sys_area_grp_id", getSysAreaGrpId());
		this.hashColumns.put("chg_delt_path_cd", getChgDeltPathCd());
		this.hashColumns.put("chg_delt_sts_cd", getChgDeltStsCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("chg_delt_usr_id", getChgDeltUsrId());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("chg_ofc_cd", getChgOfcCd());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("inact_rmk", getInactRmk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("dmdt_chg_loc_div_cd", "dmdtChgLocDivCd");
		this.hashFields.put("cntr_cyc_no", "cntrCycNo");
		this.hashFields.put("delt_cng_his_seq", "deltCngHisSeq");
		this.hashFields.put("delt_seq", "deltSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("eml_snd_no", "emlSndNo");
		this.hashFields.put("chg_seq", "chgSeq");
		this.hashFields.put("sys_area_grp_id", "sysAreaGrpId");
		this.hashFields.put("chg_delt_path_cd", "chgDeltPathCd");
		this.hashFields.put("chg_delt_sts_cd", "chgDeltStsCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("chg_delt_usr_id", "chgDeltUsrId");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("chg_ofc_cd", "chgOfcCd");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("inact_rmk", "inactRmk");
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
	 * @return dmdtChgLocDivCd
	 */
	public String getDmdtChgLocDivCd() {
		return this.dmdtChgLocDivCd;
	}
	
	/**
	 * Column Info
	 * @return cntrCycNo
	 */
	public String getCntrCycNo() {
		return this.cntrCycNo;
	}
	
	/**
	 * Column Info
	 * @return deltCngHisSeq
	 */
	public String getDeltCngHisSeq() {
		return this.deltCngHisSeq;
	}
	
	/**
	 * Column Info
	 * @return deltSeq
	 */
	public String getDeltSeq() {
		return this.deltSeq;
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
	 * @return emlSndNo
	 */
	public String getEmlSndNo() {
		return this.emlSndNo;
	}
	
	/**
	 * Column Info
	 * @return chgSeq
	 */
	public String getChgSeq() {
		return this.chgSeq;
	}
	
	/**
	 * Column Info
	 * @return sysAreaGrpId
	 */
	public String getSysAreaGrpId() {
		return this.sysAreaGrpId;
	}
	
	/**
	 * Column Info
	 * @return chgDeltPathCd
	 */
	public String getChgDeltPathCd() {
		return this.chgDeltPathCd;
	}
	
	/**
	 * Column Info
	 * @return chgDeltStsCd
	 */
	public String getChgDeltStsCd() {
		return this.chgDeltStsCd;
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
	 * @return chgDeltUsrId
	 */
	public String getChgDeltUsrId() {
		return this.chgDeltUsrId;
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
	 * @return chgOfcCd
	 */
	public String getChgOfcCd() {
		return this.chgOfcCd;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfCd
	 */
	public String getDmdtTrfCd() {
		return this.dmdtTrfCd;
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
	 * @param dmdtChgLocDivCd
	 */
	public void setDmdtChgLocDivCd(String dmdtChgLocDivCd) {
		this.dmdtChgLocDivCd = dmdtChgLocDivCd;
	}
	
	/**
	 * Column Info
	 * @param cntrCycNo
	 */
	public void setCntrCycNo(String cntrCycNo) {
		this.cntrCycNo = cntrCycNo;
	}
	
	/**
	 * Column Info
	 * @param deltCngHisSeq
	 */
	public void setDeltCngHisSeq(String deltCngHisSeq) {
		this.deltCngHisSeq = deltCngHisSeq;
	}
	
	/**
	 * Column Info
	 * @param deltSeq
	 */
	public void setDeltSeq(String deltSeq) {
		this.deltSeq = deltSeq;
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
	 * @param emlSndNo
	 */
	public void setEmlSndNo(String emlSndNo) {
		this.emlSndNo = emlSndNo;
	}
	
	/**
	 * Column Info
	 * @param chgSeq
	 */
	public void setChgSeq(String chgSeq) {
		this.chgSeq = chgSeq;
	}
	
	/**
	 * Column Info
	 * @param sysAreaGrpId
	 */
	public void setSysAreaGrpId(String sysAreaGrpId) {
		this.sysAreaGrpId = sysAreaGrpId;
	}
	
	/**
	 * Column Info
	 * @param chgDeltPathCd
	 */
	public void setChgDeltPathCd(String chgDeltPathCd) {
		this.chgDeltPathCd = chgDeltPathCd;
	}
	
	/**
	 * Column Info
	 * @param chgDeltStsCd
	 */
	public void setChgDeltStsCd(String chgDeltStsCd) {
		this.chgDeltStsCd = chgDeltStsCd;
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
	 * @param chgDeltUsrId
	 */
	public void setChgDeltUsrId(String chgDeltUsrId) {
		this.chgDeltUsrId = chgDeltUsrId;
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
	 * @param chgOfcCd
	 */
	public void setChgOfcCd(String chgOfcCd) {
		this.chgOfcCd = chgOfcCd;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfCd
	 */
	public void setDmdtTrfCd(String dmdtTrfCd) {
		this.dmdtTrfCd = dmdtTrfCd;
	}
	
	public String getInactRmk() {
		return inactRmk;
	}

	public void setInactRmk(String inactRmk) {
		this.inactRmk = inactRmk;
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
		setDmdtChgLocDivCd(JSPUtil.getParameter(request, prefix + "dmdt_chg_loc_div_cd", ""));
		setCntrCycNo(JSPUtil.getParameter(request, prefix + "cntr_cyc_no", ""));
		setDeltCngHisSeq(JSPUtil.getParameter(request, prefix + "delt_cng_his_seq", ""));
		setDeltSeq(JSPUtil.getParameter(request, prefix + "delt_seq", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setEmlSndNo(JSPUtil.getParameter(request, prefix + "eml_snd_no", ""));
		setChgSeq(JSPUtil.getParameter(request, prefix + "chg_seq", ""));
		setSysAreaGrpId(JSPUtil.getParameter(request, prefix + "sys_area_grp_id", ""));
		setChgDeltPathCd(JSPUtil.getParameter(request, prefix + "chg_delt_path_cd", ""));
		setChgDeltStsCd(JSPUtil.getParameter(request, prefix + "chg_delt_sts_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setChgDeltUsrId(JSPUtil.getParameter(request, prefix + "chg_delt_usr_id", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setChgOfcCd(JSPUtil.getParameter(request, prefix + "chg_ofc_cd", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, prefix + "upd_ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, prefix + "dmdt_trf_cd", ""));
		setInactRmk(JSPUtil.getParameter(request, prefix + "inact_rmk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChgDeltChgHisVO[]
	 */
	public ChgDeltCngHisVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ChgDeltChgHisVO[]
	 */
	public ChgDeltCngHisVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChgDeltCngHisVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] dmdtChgLocDivCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_loc_div_cd", length));
			String[] cntrCycNo = (JSPUtil.getParameter(request, prefix	+ "cntr_cyc_no", length));
			String[] deltCngHisSeq = (JSPUtil.getParameter(request, prefix	+ "delt_cng_his_seq", length));
			String[] deltSeq = (JSPUtil.getParameter(request, prefix	+ "delt_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] emlSndNo = (JSPUtil.getParameter(request, prefix	+ "eml_snd_no", length));
			String[] chgSeq = (JSPUtil.getParameter(request, prefix	+ "chg_seq", length));
			String[] sysAreaGrpId = (JSPUtil.getParameter(request, prefix	+ "sys_area_grp_id", length));
			String[] chgDeltPathCd = (JSPUtil.getParameter(request, prefix	+ "chg_delt_path_cd", length));
			String[] chgDeltStsCd = (JSPUtil.getParameter(request, prefix	+ "chg_delt_sts_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] chgDeltUsrId = (JSPUtil.getParameter(request, prefix	+ "chg_delt_usr_id", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] chgOfcCd = (JSPUtil.getParameter(request, prefix	+ "chg_ofc_cd", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] inactRmk = (JSPUtil.getParameter(request, prefix	+ "inact_rmk", length));
			
			for (int i = 0; i < length; i++) {
				model = new ChgDeltCngHisVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (dmdtChgLocDivCd[i] != null)
					model.setDmdtChgLocDivCd(dmdtChgLocDivCd[i]);
				if (cntrCycNo[i] != null)
					model.setCntrCycNo(cntrCycNo[i]);
				if (deltCngHisSeq[i] != null)
					model.setDeltCngHisSeq(deltCngHisSeq[i]);
				if (deltSeq[i] != null)
					model.setDeltSeq(deltSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (emlSndNo[i] != null)
					model.setEmlSndNo(emlSndNo[i]);
				if (chgSeq[i] != null)
					model.setChgSeq(chgSeq[i]);
				if (sysAreaGrpId[i] != null)
					model.setSysAreaGrpId(sysAreaGrpId[i]);
				if (chgDeltPathCd[i] != null)
					model.setChgDeltPathCd(chgDeltPathCd[i]);
				if (chgDeltStsCd[i] != null)
					model.setChgDeltStsCd(chgDeltStsCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (chgDeltUsrId[i] != null)
					model.setChgDeltUsrId(chgDeltUsrId[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (chgOfcCd[i] != null)
					model.setChgOfcCd(chgOfcCd[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (inactRmk[i] != null)
					model.setInactRmk(inactRmk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChgDeltChgHisVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChgDeltChgHisVO[]
	 */
	public ChgDeltCngHisVO[] getChgDeltChgHisVOs(){
		ChgDeltCngHisVO[] vos = (ChgDeltCngHisVO[])models.toArray(new ChgDeltCngHisVO[models.size()]);
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
		this.dmdtChgLocDivCd = this.dmdtChgLocDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCycNo = this.cntrCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltCngHisSeq = this.deltCngHisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltSeq = this.deltSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndNo = this.emlSndNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSeq = this.chgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysAreaGrpId = this.sysAreaGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgDeltPathCd = this.chgDeltPathCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgDeltStsCd = this.chgDeltStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgDeltUsrId = this.chgDeltUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgOfcCd = this.chgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inactRmk = this.inactRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
