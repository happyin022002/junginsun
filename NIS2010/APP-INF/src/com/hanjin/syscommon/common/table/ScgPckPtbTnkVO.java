/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScgPckPtbTnkVO.java
*@FileTitle : ScgPckPtbTnkVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.29
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2013.05.29 원종규 
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

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
 * @author 원종규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ScgPckPtbTnkVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ScgPckPtbTnkVO> models = new ArrayList<ScgPckPtbTnkVO>();
	
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String maxAlwWrkSunShldPrss = null;
	/* Column Info */
	private String refDivNo = null;
	/* Column Info */
	private String ctrlTempRefNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String maxFillDnstCtnt = null;
	/* Column Info */
	private String minShlThckCtnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pckRefCd = null;
	/* Column Info */
	private String subSeq = null;
	/* Column Info */
	private String imdgCtrlTemp = null;
	/* Column Info */
	private String maxAlwWrkBarePrss = null;
	/* Column Info */
	private String ptblTnkInstrCd = null;
	/* Column Info */
	private String maxAlwWrkSmlPrss = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Column Info */
	private String sbstDesc = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String btmOpnProviCtnt = null;
	/* Column Info */
	private String minTstPrss = null;
	/* Column Info */
	private String prsRlfProviCtnt = null;
	/* Column Info */
	private String maxAlwWrkInsltPrss = null;
	/* Column Info */
	private String sbstDescRefNo = null;
	/* Column Info */
	private String emerTempRefNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String imdgEmerTemp = null;
	/* Column Info */
	private String opnBlwLqdLvlCd = null;
	/* Column Info */
	private String prpShpNm = null;
	/* Column Info */
	private String fillDgrCtnt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ScgPckPtbTnkVO() {}

	public ScgPckPtbTnkVO(String ibflag, String pagerows, String ptblTnkInstrCd, String subSeq, String btmOpnProviCtnt, String creDt, String creUsrId, String ctrlTempRefNo, String deltFlg, String emerTempRefNo, String fillDgrCtnt, String imdgCtrlTemp, String imdgEmerTemp, String imdgUnNo, String maxAlwWrkBarePrss, String maxAlwWrkInsltPrss, String maxAlwWrkSmlPrss, String maxAlwWrkSunShldPrss, String maxFillDnstCtnt, String minShlThckCtnt, String minTstPrss, String opnBlwLqdLvlCd, String pckRefCd, String prsRlfProviCtnt, String refDivNo, String sbstDesc, String sbstDescRefNo, String updDt, String updUsrId, String prpShpNm) {
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.maxAlwWrkSunShldPrss = maxAlwWrkSunShldPrss;
		this.refDivNo = refDivNo;
		this.ctrlTempRefNo = ctrlTempRefNo;
		this.pagerows = pagerows;
		this.maxFillDnstCtnt = maxFillDnstCtnt;
		this.minShlThckCtnt = minShlThckCtnt;
		this.ibflag = ibflag;
		this.pckRefCd = pckRefCd;
		this.subSeq = subSeq;
		this.imdgCtrlTemp = imdgCtrlTemp;
		this.maxAlwWrkBarePrss = maxAlwWrkBarePrss;
		this.ptblTnkInstrCd = ptblTnkInstrCd;
		this.maxAlwWrkSmlPrss = maxAlwWrkSmlPrss;
		this.updUsrId = updUsrId;
		this.imdgUnNo = imdgUnNo;
		this.sbstDesc = sbstDesc;
		this.updDt = updDt;
		this.btmOpnProviCtnt = btmOpnProviCtnt;
		this.minTstPrss = minTstPrss;
		this.prsRlfProviCtnt = prsRlfProviCtnt;
		this.maxAlwWrkInsltPrss = maxAlwWrkInsltPrss;
		this.sbstDescRefNo = sbstDescRefNo;
		this.emerTempRefNo = emerTempRefNo;
		this.creUsrId = creUsrId;
		this.imdgEmerTemp = imdgEmerTemp;
		this.opnBlwLqdLvlCd = opnBlwLqdLvlCd;
		this.prpShpNm = prpShpNm;
		this.fillDgrCtnt = fillDgrCtnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("max_alw_wrk_sun_shld_prss", getMaxAlwWrkSunShldPrss());
		this.hashColumns.put("ref_div_no", getRefDivNo());
		this.hashColumns.put("ctrl_temp_ref_no", getCtrlTempRefNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("max_fill_dnst_ctnt", getMaxFillDnstCtnt());
		this.hashColumns.put("min_shl_thck_ctnt", getMinShlThckCtnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pck_ref_cd", getPckRefCd());
		this.hashColumns.put("sub_seq", getSubSeq());
		this.hashColumns.put("imdg_ctrl_temp", getImdgCtrlTemp());
		this.hashColumns.put("max_alw_wrk_bare_prss", getMaxAlwWrkBarePrss());
		this.hashColumns.put("ptbl_tnk_instr_cd", getPtblTnkInstrCd());
		this.hashColumns.put("max_alw_wrk_sml_prss", getMaxAlwWrkSmlPrss());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("sbst_desc", getSbstDesc());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("btm_opn_provi_ctnt", getBtmOpnProviCtnt());
		this.hashColumns.put("min_tst_prss", getMinTstPrss());
		this.hashColumns.put("prs_rlf_provi_ctnt", getPrsRlfProviCtnt());
		this.hashColumns.put("max_alw_wrk_inslt_prss", getMaxAlwWrkInsltPrss());
		this.hashColumns.put("sbst_desc_ref_no", getSbstDescRefNo());
		this.hashColumns.put("emer_temp_ref_no", getEmerTempRefNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("imdg_emer_temp", getImdgEmerTemp());
		this.hashColumns.put("opn_blw_lqd_lvl_cd", getOpnBlwLqdLvlCd());
		this.hashColumns.put("prp_shp_nm", getPrpShpNm());
		this.hashColumns.put("fill_dgr_ctnt", getFillDgrCtnt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("max_alw_wrk_sun_shld_prss", "maxAlwWrkSunShldPrss");
		this.hashFields.put("ref_div_no", "refDivNo");
		this.hashFields.put("ctrl_temp_ref_no", "ctrlTempRefNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("max_fill_dnst_ctnt", "maxFillDnstCtnt");
		this.hashFields.put("min_shl_thck_ctnt", "minShlThckCtnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pck_ref_cd", "pckRefCd");
		this.hashFields.put("sub_seq", "subSeq");
		this.hashFields.put("imdg_ctrl_temp", "imdgCtrlTemp");
		this.hashFields.put("max_alw_wrk_bare_prss", "maxAlwWrkBarePrss");
		this.hashFields.put("ptbl_tnk_instr_cd", "ptblTnkInstrCd");
		this.hashFields.put("max_alw_wrk_sml_prss", "maxAlwWrkSmlPrss");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("sbst_desc", "sbstDesc");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("btm_opn_provi_ctnt", "btmOpnProviCtnt");
		this.hashFields.put("min_tst_prss", "minTstPrss");
		this.hashFields.put("prs_rlf_provi_ctnt", "prsRlfProviCtnt");
		this.hashFields.put("max_alw_wrk_inslt_prss", "maxAlwWrkInsltPrss");
		this.hashFields.put("sbst_desc_ref_no", "sbstDescRefNo");
		this.hashFields.put("emer_temp_ref_no", "emerTempRefNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("imdg_emer_temp", "imdgEmerTemp");
		this.hashFields.put("opn_blw_lqd_lvl_cd", "opnBlwLqdLvlCd");
		this.hashFields.put("prp_shp_nm", "prpShpNm");
		this.hashFields.put("fill_dgr_ctnt", "fillDgrCtnt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
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
	 * @return maxAlwWrkSunShldPrss
	 */
	public String getMaxAlwWrkSunShldPrss() {
		return this.maxAlwWrkSunShldPrss;
	}
	
	/**
	 * Column Info
	 * @return refDivNo
	 */
	public String getRefDivNo() {
		return this.refDivNo;
	}
	
	/**
	 * Column Info
	 * @return ctrlTempRefNo
	 */
	public String getCtrlTempRefNo() {
		return this.ctrlTempRefNo;
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
	 * @return maxFillDnstCtnt
	 */
	public String getMaxFillDnstCtnt() {
		return this.maxFillDnstCtnt;
	}
	
	/**
	 * Column Info
	 * @return minShlThckCtnt
	 */
	public String getMinShlThckCtnt() {
		return this.minShlThckCtnt;
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
	 * @return pckRefCd
	 */
	public String getPckRefCd() {
		return this.pckRefCd;
	}
	
	/**
	 * Column Info
	 * @return subSeq
	 */
	public String getSubSeq() {
		return this.subSeq;
	}
	
	/**
	 * Column Info
	 * @return imdgCtrlTemp
	 */
	public String getImdgCtrlTemp() {
		return this.imdgCtrlTemp;
	}
	
	/**
	 * Column Info
	 * @return maxAlwWrkBarePrss
	 */
	public String getMaxAlwWrkBarePrss() {
		return this.maxAlwWrkBarePrss;
	}
	
	/**
	 * Column Info
	 * @return ptblTnkInstrCd
	 */
	public String getPtblTnkInstrCd() {
		return this.ptblTnkInstrCd;
	}
	
	/**
	 * Column Info
	 * @return maxAlwWrkSmlPrss
	 */
	public String getMaxAlwWrkSmlPrss() {
		return this.maxAlwWrkSmlPrss;
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
	 * @return imdgUnNo
	 */
	public String getImdgUnNo() {
		return this.imdgUnNo;
	}
	
	/**
	 * Column Info
	 * @return sbstDesc
	 */
	public String getSbstDesc() {
		return this.sbstDesc;
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
	 * @return btmOpnProviCtnt
	 */
	public String getBtmOpnProviCtnt() {
		return this.btmOpnProviCtnt;
	}
	
	/**
	 * Column Info
	 * @return minTstPrss
	 */
	public String getMinTstPrss() {
		return this.minTstPrss;
	}
	
	/**
	 * Column Info
	 * @return prsRlfProviCtnt
	 */
	public String getPrsRlfProviCtnt() {
		return this.prsRlfProviCtnt;
	}
	
	/**
	 * Column Info
	 * @return maxAlwWrkInsltPrss
	 */
	public String getMaxAlwWrkInsltPrss() {
		return this.maxAlwWrkInsltPrss;
	}
	
	/**
	 * Column Info
	 * @return sbstDescRefNo
	 */
	public String getSbstDescRefNo() {
		return this.sbstDescRefNo;
	}
	
	/**
	 * Column Info
	 * @return emerTempRefNo
	 */
	public String getEmerTempRefNo() {
		return this.emerTempRefNo;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return imdgEmerTemp
	 */
	public String getImdgEmerTemp() {
		return this.imdgEmerTemp;
	}
	
	/**
	 * Column Info
	 * @return opnBlwLqdLvlCd
	 */
	public String getOpnBlwLqdLvlCd() {
		return this.opnBlwLqdLvlCd;
	}
	
	/**
	 * Column Info
	 * @return prpShpNm
	 */
	public String getPrpShpNm() {
		return this.prpShpNm;
	}
	
	/**
	 * Column Info
	 * @return fillDgrCtnt
	 */
	public String getFillDgrCtnt() {
		return this.fillDgrCtnt;
	}
	

	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
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
	 * @param maxAlwWrkSunShldPrss
	 */
	public void setMaxAlwWrkSunShldPrss(String maxAlwWrkSunShldPrss) {
		this.maxAlwWrkSunShldPrss = maxAlwWrkSunShldPrss;
	}
	
	/**
	 * Column Info
	 * @param refDivNo
	 */
	public void setRefDivNo(String refDivNo) {
		this.refDivNo = refDivNo;
	}
	
	/**
	 * Column Info
	 * @param ctrlTempRefNo
	 */
	public void setCtrlTempRefNo(String ctrlTempRefNo) {
		this.ctrlTempRefNo = ctrlTempRefNo;
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
	 * @param maxFillDnstCtnt
	 */
	public void setMaxFillDnstCtnt(String maxFillDnstCtnt) {
		this.maxFillDnstCtnt = maxFillDnstCtnt;
	}
	
	/**
	 * Column Info
	 * @param minShlThckCtnt
	 */
	public void setMinShlThckCtnt(String minShlThckCtnt) {
		this.minShlThckCtnt = minShlThckCtnt;
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
	 * @param pckRefCd
	 */
	public void setPckRefCd(String pckRefCd) {
		this.pckRefCd = pckRefCd;
	}
	
	/**
	 * Column Info
	 * @param subSeq
	 */
	public void setSubSeq(String subSeq) {
		this.subSeq = subSeq;
	}
	
	/**
	 * Column Info
	 * @param imdgCtrlTemp
	 */
	public void setImdgCtrlTemp(String imdgCtrlTemp) {
		this.imdgCtrlTemp = imdgCtrlTemp;
	}
	
	/**
	 * Column Info
	 * @param maxAlwWrkBarePrss
	 */
	public void setMaxAlwWrkBarePrss(String maxAlwWrkBarePrss) {
		this.maxAlwWrkBarePrss = maxAlwWrkBarePrss;
	}
	
	/**
	 * Column Info
	 * @param ptblTnkInstrCd
	 */
	public void setPtblTnkInstrCd(String ptblTnkInstrCd) {
		this.ptblTnkInstrCd = ptblTnkInstrCd;
	}
	
	/**
	 * Column Info
	 * @param maxAlwWrkSmlPrss
	 */
	public void setMaxAlwWrkSmlPrss(String maxAlwWrkSmlPrss) {
		this.maxAlwWrkSmlPrss = maxAlwWrkSmlPrss;
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
	 * @param imdgUnNo
	 */
	public void setImdgUnNo(String imdgUnNo) {
		this.imdgUnNo = imdgUnNo;
	}
	
	/**
	 * Column Info
	 * @param sbstDesc
	 */
	public void setSbstDesc(String sbstDesc) {
		this.sbstDesc = sbstDesc;
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
	 * @param btmOpnProviCtnt
	 */
	public void setBtmOpnProviCtnt(String btmOpnProviCtnt) {
		this.btmOpnProviCtnt = btmOpnProviCtnt;
	}
	
	/**
	 * Column Info
	 * @param minTstPrss
	 */
	public void setMinTstPrss(String minTstPrss) {
		this.minTstPrss = minTstPrss;
	}
	
	/**
	 * Column Info
	 * @param prsRlfProviCtnt
	 */
	public void setPrsRlfProviCtnt(String prsRlfProviCtnt) {
		this.prsRlfProviCtnt = prsRlfProviCtnt;
	}
	
	/**
	 * Column Info
	 * @param maxAlwWrkInsltPrss
	 */
	public void setMaxAlwWrkInsltPrss(String maxAlwWrkInsltPrss) {
		this.maxAlwWrkInsltPrss = maxAlwWrkInsltPrss;
	}
	
	/**
	 * Column Info
	 * @param sbstDescRefNo
	 */
	public void setSbstDescRefNo(String sbstDescRefNo) {
		this.sbstDescRefNo = sbstDescRefNo;
	}
	
	/**
	 * Column Info
	 * @param emerTempRefNo
	 */
	public void setEmerTempRefNo(String emerTempRefNo) {
		this.emerTempRefNo = emerTempRefNo;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param imdgEmerTemp
	 */
	public void setImdgEmerTemp(String imdgEmerTemp) {
		this.imdgEmerTemp = imdgEmerTemp;
	}
	
	/**
	 * Column Info
	 * @param opnBlwLqdLvlCd
	 */
	public void setOpnBlwLqdLvlCd(String opnBlwLqdLvlCd) {
		this.opnBlwLqdLvlCd = opnBlwLqdLvlCd;
	}
	
	/**
	 * Column Info
	 * @param prpShpNm
	 */
	public void setPrpShpNm(String prpShpNm) {
		this.prpShpNm = prpShpNm;
	}
	
	/**
	 * Column Info
	 * @param fillDgrCtnt
	 */
	public void setFillDgrCtnt(String fillDgrCtnt) {
		this.fillDgrCtnt = fillDgrCtnt;
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
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setMaxAlwWrkSunShldPrss(JSPUtil.getParameter(request, prefix + "max_alw_wrk_sun_shld_prss", ""));
		setRefDivNo(JSPUtil.getParameter(request, prefix + "ref_div_no", ""));
		setCtrlTempRefNo(JSPUtil.getParameter(request, prefix + "ctrl_temp_ref_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setMaxFillDnstCtnt(JSPUtil.getParameter(request, prefix + "max_fill_dnst_ctnt", ""));
		setMinShlThckCtnt(JSPUtil.getParameter(request, prefix + "min_shl_thck_ctnt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPckRefCd(JSPUtil.getParameter(request, prefix + "pck_ref_cd", ""));
		setSubSeq(JSPUtil.getParameter(request, prefix + "sub_seq", ""));
		setImdgCtrlTemp(JSPUtil.getParameter(request, prefix + "imdg_ctrl_temp", ""));
		setMaxAlwWrkBarePrss(JSPUtil.getParameter(request, prefix + "max_alw_wrk_bare_prss", ""));
		setPtblTnkInstrCd(JSPUtil.getParameter(request, prefix + "ptbl_tnk_instr_cd", ""));
		setMaxAlwWrkSmlPrss(JSPUtil.getParameter(request, prefix + "max_alw_wrk_sml_prss", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setImdgUnNo(JSPUtil.getParameter(request, prefix + "imdg_un_no", ""));
		setSbstDesc(JSPUtil.getParameter(request, prefix + "sbst_desc", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setBtmOpnProviCtnt(JSPUtil.getParameter(request, prefix + "btm_opn_provi_ctnt", ""));
		setMinTstPrss(JSPUtil.getParameter(request, prefix + "min_tst_prss", ""));
		setPrsRlfProviCtnt(JSPUtil.getParameter(request, prefix + "prs_rlf_provi_ctnt", ""));
		setMaxAlwWrkInsltPrss(JSPUtil.getParameter(request, prefix + "max_alw_wrk_inslt_prss", ""));
		setSbstDescRefNo(JSPUtil.getParameter(request, prefix + "sbst_desc_ref_no", ""));
		setEmerTempRefNo(JSPUtil.getParameter(request, prefix + "emer_temp_ref_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setImdgEmerTemp(JSPUtil.getParameter(request, prefix + "imdg_emer_temp", ""));
		setOpnBlwLqdLvlCd(JSPUtil.getParameter(request, prefix + "opn_blw_lqd_lvl_cd", ""));
		setPrpShpNm(JSPUtil.getParameter(request, prefix + "prp_shp_nm", ""));
		setFillDgrCtnt(JSPUtil.getParameter(request, prefix + "fill_dgr_ctnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScgPckPtbTnkVO[]
	 */
	public ScgPckPtbTnkVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ScgPckPtbTnkVO[]
	 */
	public ScgPckPtbTnkVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ScgPckPtbTnkVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] maxAlwWrkSunShldPrss = (JSPUtil.getParameter(request, prefix	+ "max_alw_wrk_sun_shld_prss", length));
			String[] refDivNo = (JSPUtil.getParameter(request, prefix	+ "ref_div_no", length));
			String[] ctrlTempRefNo = (JSPUtil.getParameter(request, prefix	+ "ctrl_temp_ref_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] maxFillDnstCtnt = (JSPUtil.getParameter(request, prefix	+ "max_fill_dnst_ctnt", length));
			String[] minShlThckCtnt = (JSPUtil.getParameter(request, prefix	+ "min_shl_thck_ctnt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pckRefCd = (JSPUtil.getParameter(request, prefix	+ "pck_ref_cd", length));
			String[] subSeq = (JSPUtil.getParameter(request, prefix	+ "sub_seq", length));
			String[] imdgCtrlTemp = (JSPUtil.getParameter(request, prefix	+ "imdg_ctrl_temp", length));
			String[] maxAlwWrkBarePrss = (JSPUtil.getParameter(request, prefix	+ "max_alw_wrk_bare_prss", length));
			String[] ptblTnkInstrCd = (JSPUtil.getParameter(request, prefix	+ "ptbl_tnk_instr_cd", length));
			String[] maxAlwWrkSmlPrss = (JSPUtil.getParameter(request, prefix	+ "max_alw_wrk_sml_prss", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			String[] sbstDesc = (JSPUtil.getParameter(request, prefix	+ "sbst_desc", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] btmOpnProviCtnt = (JSPUtil.getParameter(request, prefix	+ "btm_opn_provi_ctnt", length));
			String[] minTstPrss = (JSPUtil.getParameter(request, prefix	+ "min_tst_prss", length));
			String[] prsRlfProviCtnt = (JSPUtil.getParameter(request, prefix	+ "prs_rlf_provi_ctnt", length));
			String[] maxAlwWrkInsltPrss = (JSPUtil.getParameter(request, prefix	+ "max_alw_wrk_inslt_prss", length));
			String[] sbstDescRefNo = (JSPUtil.getParameter(request, prefix	+ "sbst_desc_ref_no", length));
			String[] emerTempRefNo = (JSPUtil.getParameter(request, prefix	+ "emer_temp_ref_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] imdgEmerTemp = (JSPUtil.getParameter(request, prefix	+ "imdg_emer_temp", length));
			String[] opnBlwLqdLvlCd = (JSPUtil.getParameter(request, prefix	+ "opn_blw_lqd_lvl_cd", length));
			String[] prpShpNm = (JSPUtil.getParameter(request, prefix	+ "prp_shp_nm", length));
			String[] fillDgrCtnt = (JSPUtil.getParameter(request, prefix	+ "fill_dgr_ctnt", length));
			
			for (int i = 0; i < length; i++) {
				model = new ScgPckPtbTnkVO();
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (maxAlwWrkSunShldPrss[i] != null)
					model.setMaxAlwWrkSunShldPrss(maxAlwWrkSunShldPrss[i]);
				if (refDivNo[i] != null)
					model.setRefDivNo(refDivNo[i]);
				if (ctrlTempRefNo[i] != null)
					model.setCtrlTempRefNo(ctrlTempRefNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (maxFillDnstCtnt[i] != null)
					model.setMaxFillDnstCtnt(maxFillDnstCtnt[i]);
				if (minShlThckCtnt[i] != null)
					model.setMinShlThckCtnt(minShlThckCtnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pckRefCd[i] != null)
					model.setPckRefCd(pckRefCd[i]);
				if (subSeq[i] != null)
					model.setSubSeq(subSeq[i]);
				if (imdgCtrlTemp[i] != null)
					model.setImdgCtrlTemp(imdgCtrlTemp[i]);
				if (maxAlwWrkBarePrss[i] != null)
					model.setMaxAlwWrkBarePrss(maxAlwWrkBarePrss[i]);
				if (ptblTnkInstrCd[i] != null)
					model.setPtblTnkInstrCd(ptblTnkInstrCd[i]);
				if (maxAlwWrkSmlPrss[i] != null)
					model.setMaxAlwWrkSmlPrss(maxAlwWrkSmlPrss[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (sbstDesc[i] != null)
					model.setSbstDesc(sbstDesc[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (btmOpnProviCtnt[i] != null)
					model.setBtmOpnProviCtnt(btmOpnProviCtnt[i]);
				if (minTstPrss[i] != null)
					model.setMinTstPrss(minTstPrss[i]);
				if (prsRlfProviCtnt[i] != null)
					model.setPrsRlfProviCtnt(prsRlfProviCtnt[i]);
				if (maxAlwWrkInsltPrss[i] != null)
					model.setMaxAlwWrkInsltPrss(maxAlwWrkInsltPrss[i]);
				if (sbstDescRefNo[i] != null)
					model.setSbstDescRefNo(sbstDescRefNo[i]);
				if (emerTempRefNo[i] != null)
					model.setEmerTempRefNo(emerTempRefNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (imdgEmerTemp[i] != null)
					model.setImdgEmerTemp(imdgEmerTemp[i]);
				if (opnBlwLqdLvlCd[i] != null)
					model.setOpnBlwLqdLvlCd(opnBlwLqdLvlCd[i]);
				if (prpShpNm[i] != null)
					model.setPrpShpNm(prpShpNm[i]);
				if (fillDgrCtnt[i] != null)
					model.setFillDgrCtnt(fillDgrCtnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getScgPckPtbTnkVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ScgPckPtbTnkVO[]
	 */
	public ScgPckPtbTnkVO[] getScgPckPtbTnkVOs(){
		ScgPckPtbTnkVO[] vos = (ScgPckPtbTnkVO[])models.toArray(new ScgPckPtbTnkVO[models.size()]);
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
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxAlwWrkSunShldPrss = this.maxAlwWrkSunShldPrss .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refDivNo = this.refDivNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlTempRefNo = this.ctrlTempRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxFillDnstCtnt = this.maxFillDnstCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minShlThckCtnt = this.minShlThckCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckRefCd = this.pckRefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subSeq = this.subSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgCtrlTemp = this.imdgCtrlTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxAlwWrkBarePrss = this.maxAlwWrkBarePrss .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptblTnkInstrCd = this.ptblTnkInstrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxAlwWrkSmlPrss = this.maxAlwWrkSmlPrss .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sbstDesc = this.sbstDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.btmOpnProviCtnt = this.btmOpnProviCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minTstPrss = this.minTstPrss .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsRlfProviCtnt = this.prsRlfProviCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxAlwWrkInsltPrss = this.maxAlwWrkInsltPrss .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sbstDescRefNo = this.sbstDescRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emerTempRefNo = this.emerTempRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgEmerTemp = this.imdgEmerTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opnBlwLqdLvlCd = this.opnBlwLqdLvlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prpShpNm = this.prpShpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fillDgrCtnt = this.fillDgrCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
