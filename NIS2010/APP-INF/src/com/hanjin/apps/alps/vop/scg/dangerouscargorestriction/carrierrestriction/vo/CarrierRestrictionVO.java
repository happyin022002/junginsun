/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CarrierRestrictionVO.java
*@FileTitle : CarrierRestrictionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.09.23 장강철 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 장강철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CarrierRestrictionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CarrierRestrictionVO> models = new ArrayList<CarrierRestrictionVO>();
	
	/* Column Info */
	private String imdgCrrRstrSeq = null;
	/* Column Info */
	private String imdgPckGrpCd = null;
	/* Column Info */
	private String polPortCd = null;
	/* Column Info */
	private String imdgUnNoSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String optclass = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String crrReguDesc = null;
	/* Column Info */
	private String imdgCompGrpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String podPortCd = null;
	/* Column Info */
	private String imdgClssCdDesc = null;
	/* Column Info */
	private String vslOprTpCd = null;
	/* Column Info */
	private String imdgCrrRstrExptCd = null;
	/* Column Info */
	private String polVpsPortCd = null;
	/* Column Info */
	private String imdgTecNm = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String imdgTekNmCheck = null;
	/* Column Info */
	private String imdgUnNoNull = null;
	/* Column Info */
	private String imdgSubsRskLblCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String rowSeq = null;
	/* Column Info */
	private String podVpsPortCd = null;
	/* Column Info */
	private String prpShpNm = null;
	/* Column Info */
	private String imdgClssCdTxt = null;
	/* Column Info */
	private String imdgClssCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CarrierRestrictionVO() {}

	public CarrierRestrictionVO(String ibflag, String pagerows, String imdgSubsRskLblCd, String imdgTekNmCheck, String rowSeq, String optclass, String polVpsPortCd, String podVpsPortCd, String imdgUnNoNull, String polPortCd, String podPortCd, String vslOprTpCd, String imdgCrrRstrSeq, String imdgUnNo, String imdgUnNoSeq, String imdgClssCd, String imdgClssCdTxt, String imdgCrrRstrExptCd, String slanCd, String crrReguDesc, String creUsrId, String creDt, String updUsrId, String updDt, String imdgCompGrpCd, String imdgClssCdDesc, String prpShpNm, String imdgPckGrpCd, String imdgTecNm) {
		this.imdgCrrRstrSeq = imdgCrrRstrSeq;
		this.imdgPckGrpCd = imdgPckGrpCd;
		this.polPortCd = polPortCd;
		this.imdgUnNoSeq = imdgUnNoSeq;
		this.creDt = creDt;
		this.optclass = optclass;
		this.pagerows = pagerows;
		this.crrReguDesc = crrReguDesc;
		this.imdgCompGrpCd = imdgCompGrpCd;
		this.ibflag = ibflag;
		this.podPortCd = podPortCd;
		this.imdgClssCdDesc = imdgClssCdDesc;
		this.vslOprTpCd = vslOprTpCd;
		this.imdgCrrRstrExptCd = imdgCrrRstrExptCd;
		this.polVpsPortCd = polVpsPortCd;
		this.imdgTecNm = imdgTecNm;
		this.imdgUnNo = imdgUnNo;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.imdgTekNmCheck = imdgTekNmCheck;
		this.imdgUnNoNull = imdgUnNoNull;
		this.imdgSubsRskLblCd = imdgSubsRskLblCd;
		this.creUsrId = creUsrId;
		this.slanCd = slanCd;
		this.rowSeq = rowSeq;
		this.podVpsPortCd = podVpsPortCd;
		this.prpShpNm = prpShpNm;
		this.imdgClssCdTxt = imdgClssCdTxt;
		this.imdgClssCd = imdgClssCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("imdg_crr_rstr_seq", getImdgCrrRstrSeq());
		this.hashColumns.put("imdg_pck_grp_cd", getImdgPckGrpCd());
		this.hashColumns.put("pol_port_cd", getPolPortCd());
		this.hashColumns.put("imdg_un_no_seq", getImdgUnNoSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("optclass", getOptclass());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("crr_regu_desc", getCrrReguDesc());
		this.hashColumns.put("imdg_comp_grp_cd", getImdgCompGrpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pod_port_cd", getPodPortCd());
		this.hashColumns.put("imdg_clss_cd_desc", getImdgClssCdDesc());
		this.hashColumns.put("vsl_opr_tp_cd", getVslOprTpCd());
		this.hashColumns.put("imdg_crr_rstr_expt_cd", getImdgCrrRstrExptCd());
		this.hashColumns.put("pol_vps_port_cd", getPolVpsPortCd());
		this.hashColumns.put("imdg_tec_nm", getImdgTecNm());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("imdg_tek_nm_check", getImdgTekNmCheck());
		this.hashColumns.put("imdg_un_no_null", getImdgUnNoNull());
		this.hashColumns.put("imdg_subs_rsk_lbl_cd", getImdgSubsRskLblCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("row_seq", getRowSeq());
		this.hashColumns.put("pod_vps_port_cd", getPodVpsPortCd());
		this.hashColumns.put("prp_shp_nm", getPrpShpNm());
		this.hashColumns.put("imdg_clss_cd_txt", getImdgClssCdTxt());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("imdg_crr_rstr_seq", "imdgCrrRstrSeq");
		this.hashFields.put("imdg_pck_grp_cd", "imdgPckGrpCd");
		this.hashFields.put("pol_port_cd", "polPortCd");
		this.hashFields.put("imdg_un_no_seq", "imdgUnNoSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("optclass", "optclass");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("crr_regu_desc", "crrReguDesc");
		this.hashFields.put("imdg_comp_grp_cd", "imdgCompGrpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pod_port_cd", "podPortCd");
		this.hashFields.put("imdg_clss_cd_desc", "imdgClssCdDesc");
		this.hashFields.put("vsl_opr_tp_cd", "vslOprTpCd");
		this.hashFields.put("imdg_crr_rstr_expt_cd", "imdgCrrRstrExptCd");
		this.hashFields.put("pol_vps_port_cd", "polVpsPortCd");
		this.hashFields.put("imdg_tec_nm", "imdgTecNm");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("imdg_tek_nm_check", "imdgTekNmCheck");
		this.hashFields.put("imdg_un_no_null", "imdgUnNoNull");
		this.hashFields.put("imdg_subs_rsk_lbl_cd", "imdgSubsRskLblCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("row_seq", "rowSeq");
		this.hashFields.put("pod_vps_port_cd", "podVpsPortCd");
		this.hashFields.put("prp_shp_nm", "prpShpNm");
		this.hashFields.put("imdg_clss_cd_txt", "imdgClssCdTxt");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return imdgCrrRstrSeq
	 */
	public String getImdgCrrRstrSeq() {
		return this.imdgCrrRstrSeq;
	}
	
	/**
	 * Column Info
	 * @return imdgPckGrpCd
	 */
	public String getImdgPckGrpCd() {
		return this.imdgPckGrpCd;
	}
	
	/**
	 * Column Info
	 * @return polPortCd
	 */
	public String getPolPortCd() {
		return this.polPortCd;
	}
	
	/**
	 * Column Info
	 * @return imdgUnNoSeq
	 */
	public String getImdgUnNoSeq() {
		return this.imdgUnNoSeq;
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
	 * @return optclass
	 */
	public String getOptclass() {
		return this.optclass;
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
	 * @return crrReguDesc
	 */
	public String getCrrReguDesc() {
		return this.crrReguDesc;
	}
	
	/**
	 * Column Info
	 * @return imdgCompGrpCd
	 */
	public String getImdgCompGrpCd() {
		return this.imdgCompGrpCd;
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
	 * @return podPortCd
	 */
	public String getPodPortCd() {
		return this.podPortCd;
	}
	
	/**
	 * Column Info
	 * @return imdgClssCdDesc
	 */
	public String getImdgClssCdDesc() {
		return this.imdgClssCdDesc;
	}
	
	/**
	 * Column Info
	 * @return vslOprTpCd
	 */
	public String getVslOprTpCd() {
		return this.vslOprTpCd;
	}
	
	/**
	 * Column Info
	 * @return imdgCrrRstrExptCd
	 */
	public String getImdgCrrRstrExptCd() {
		return this.imdgCrrRstrExptCd;
	}
	
	/**
	 * Column Info
	 * @return polVpsPortCd
	 */
	public String getPolVpsPortCd() {
		return this.polVpsPortCd;
	}
	
	/**
	 * Column Info
	 * @return imdgTecNm
	 */
	public String getImdgTecNm() {
		return this.imdgTecNm;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @return imdgTekNmCheck
	 */
	public String getImdgTekNmCheck() {
		return this.imdgTekNmCheck;
	}
	
	/**
	 * Column Info
	 * @return imdgUnNoNull
	 */
	public String getImdgUnNoNull() {
		return this.imdgUnNoNull;
	}
	
	/**
	 * Column Info
	 * @return imdgSubsRskLblCd
	 */
	public String getImdgSubsRskLblCd() {
		return this.imdgSubsRskLblCd;
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
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return rowSeq
	 */
	public String getRowSeq() {
		return this.rowSeq;
	}
	
	/**
	 * Column Info
	 * @return podVpsPortCd
	 */
	public String getPodVpsPortCd() {
		return this.podVpsPortCd;
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
	 * @return imdgClssCdTxt
	 */
	public String getImdgClssCdTxt() {
		return this.imdgClssCdTxt;
	}
	
	/**
	 * Column Info
	 * @return imdgClssCd
	 */
	public String getImdgClssCd() {
		return this.imdgClssCd;
	}
	

	/**
	 * Column Info
	 * @param imdgCrrRstrSeq
	 */
	public void setImdgCrrRstrSeq(String imdgCrrRstrSeq) {
		this.imdgCrrRstrSeq = imdgCrrRstrSeq;
	}
	
	/**
	 * Column Info
	 * @param imdgPckGrpCd
	 */
	public void setImdgPckGrpCd(String imdgPckGrpCd) {
		this.imdgPckGrpCd = imdgPckGrpCd;
	}
	
	/**
	 * Column Info
	 * @param polPortCd
	 */
	public void setPolPortCd(String polPortCd) {
		this.polPortCd = polPortCd;
	}
	
	/**
	 * Column Info
	 * @param imdgUnNoSeq
	 */
	public void setImdgUnNoSeq(String imdgUnNoSeq) {
		this.imdgUnNoSeq = imdgUnNoSeq;
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
	 * @param optclass
	 */
	public void setOptclass(String optclass) {
		this.optclass = optclass;
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
	 * @param crrReguDesc
	 */
	public void setCrrReguDesc(String crrReguDesc) {
		this.crrReguDesc = crrReguDesc;
	}
	
	/**
	 * Column Info
	 * @param imdgCompGrpCd
	 */
	public void setImdgCompGrpCd(String imdgCompGrpCd) {
		this.imdgCompGrpCd = imdgCompGrpCd;
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
	 * @param podPortCd
	 */
	public void setPodPortCd(String podPortCd) {
		this.podPortCd = podPortCd;
	}
	
	/**
	 * Column Info
	 * @param imdgClssCdDesc
	 */
	public void setImdgClssCdDesc(String imdgClssCdDesc) {
		this.imdgClssCdDesc = imdgClssCdDesc;
	}
	
	/**
	 * Column Info
	 * @param vslOprTpCd
	 */
	public void setVslOprTpCd(String vslOprTpCd) {
		this.vslOprTpCd = vslOprTpCd;
	}
	
	/**
	 * Column Info
	 * @param imdgCrrRstrExptCd
	 */
	public void setImdgCrrRstrExptCd(String imdgCrrRstrExptCd) {
		this.imdgCrrRstrExptCd = imdgCrrRstrExptCd;
	}
	
	/**
	 * Column Info
	 * @param polVpsPortCd
	 */
	public void setPolVpsPortCd(String polVpsPortCd) {
		this.polVpsPortCd = polVpsPortCd;
	}
	
	/**
	 * Column Info
	 * @param imdgTecNm
	 */
	public void setImdgTecNm(String imdgTecNm) {
		this.imdgTecNm = imdgTecNm;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
	 * @param imdgTekNmCheck
	 */
	public void setImdgTekNmCheck(String imdgTekNmCheck) {
		this.imdgTekNmCheck = imdgTekNmCheck;
	}
	
	/**
	 * Column Info
	 * @param imdgUnNoNull
	 */
	public void setImdgUnNoNull(String imdgUnNoNull) {
		this.imdgUnNoNull = imdgUnNoNull;
	}
	
	/**
	 * Column Info
	 * @param imdgSubsRskLblCd
	 */
	public void setImdgSubsRskLblCd(String imdgSubsRskLblCd) {
		this.imdgSubsRskLblCd = imdgSubsRskLblCd;
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
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param rowSeq
	 */
	public void setRowSeq(String rowSeq) {
		this.rowSeq = rowSeq;
	}
	
	/**
	 * Column Info
	 * @param podVpsPortCd
	 */
	public void setPodVpsPortCd(String podVpsPortCd) {
		this.podVpsPortCd = podVpsPortCd;
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
	 * @param imdgClssCdTxt
	 */
	public void setImdgClssCdTxt(String imdgClssCdTxt) {
		this.imdgClssCdTxt = imdgClssCdTxt;
	}
	
	/**
	 * Column Info
	 * @param imdgClssCd
	 */
	public void setImdgClssCd(String imdgClssCd) {
		this.imdgClssCd = imdgClssCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setImdgCrrRstrSeq(JSPUtil.getParameter(request, "imdg_crr_rstr_seq", ""));
		setImdgPckGrpCd(JSPUtil.getParameter(request, "imdg_pck_grp_cd", ""));
		setPolPortCd(JSPUtil.getParameter(request, "pol_port_cd", ""));
		setImdgUnNoSeq(JSPUtil.getParameter(request, "imdg_un_no_seq", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setOptclass(JSPUtil.getParameter(request, "optclass", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCrrReguDesc(JSPUtil.getParameter(request, "crr_regu_desc", ""));
		setImdgCompGrpCd(JSPUtil.getParameter(request, "imdg_comp_grp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPodPortCd(JSPUtil.getParameter(request, "pod_port_cd", ""));
		setImdgClssCdDesc(JSPUtil.getParameter(request, "imdg_clss_cd_desc", ""));
		setVslOprTpCd(JSPUtil.getParameter(request, "vsl_opr_tp_cd", ""));
		setImdgCrrRstrExptCd(JSPUtil.getParameter(request, "imdg_crr_rstr_expt_cd", ""));
		setPolVpsPortCd(JSPUtil.getParameter(request, "pol_vps_port_cd", ""));
		setImdgTecNm(JSPUtil.getParameter(request, "imdg_tec_nm", ""));
		setImdgUnNo(JSPUtil.getParameter(request, "imdg_un_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setImdgTekNmCheck(JSPUtil.getParameter(request, "imdg_tek_nm_check", ""));
		setImdgUnNoNull(JSPUtil.getParameter(request, "imdg_un_no_null", ""));
		setImdgSubsRskLblCd(JSPUtil.getParameter(request, "imdg_subs_rsk_lbl_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setRowSeq(JSPUtil.getParameter(request, "row_seq", ""));
		setPodVpsPortCd(JSPUtil.getParameter(request, "pod_vps_port_cd", ""));
		setPrpShpNm(JSPUtil.getParameter(request, "prp_shp_nm", ""));
		setImdgClssCdTxt(JSPUtil.getParameter(request, "imdg_clss_cd_txt", ""));
		setImdgClssCd(JSPUtil.getParameter(request, "imdg_clss_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CarrierRestrictionVO[]
	 */
	public CarrierRestrictionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CarrierRestrictionVO[]
	 */
	public CarrierRestrictionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CarrierRestrictionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] imdgCrrRstrSeq = (JSPUtil.getParameter(request, prefix	+ "imdg_crr_rstr_seq", length));
			String[] imdgPckGrpCd = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_grp_cd", length));
			String[] polPortCd = (JSPUtil.getParameter(request, prefix	+ "pol_port_cd", length));
			String[] imdgUnNoSeq = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] optclass = (JSPUtil.getParameter(request, prefix	+ "optclass", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] crrReguDesc = (JSPUtil.getParameter(request, prefix	+ "crr_regu_desc", length));
			String[] imdgCompGrpCd = (JSPUtil.getParameter(request, prefix	+ "imdg_comp_grp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] podPortCd = (JSPUtil.getParameter(request, prefix	+ "pod_port_cd", length));
			String[] imdgClssCdDesc = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd_desc", length));
			String[] vslOprTpCd = (JSPUtil.getParameter(request, prefix	+ "vsl_opr_tp_cd", length));
			String[] imdgCrrRstrExptCd = (JSPUtil.getParameter(request, prefix	+ "imdg_crr_rstr_expt_cd", length));
			String[] polVpsPortCd = (JSPUtil.getParameter(request, prefix	+ "pol_vps_port_cd", length));
			String[] imdgTecNm = (JSPUtil.getParameter(request, prefix	+ "imdg_tec_nm", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] imdgTekNmCheck = (JSPUtil.getParameter(request, prefix	+ "imdg_tek_nm_check", length));
			String[] imdgUnNoNull = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no_null", length));
			String[] imdgSubsRskLblCd = (JSPUtil.getParameter(request, prefix	+ "imdg_subs_rsk_lbl_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] rowSeq = (JSPUtil.getParameter(request, prefix	+ "row_seq", length));
			String[] podVpsPortCd = (JSPUtil.getParameter(request, prefix	+ "pod_vps_port_cd", length));
			String[] prpShpNm = (JSPUtil.getParameter(request, prefix	+ "prp_shp_nm", length));
			String[] imdgClssCdTxt = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd_txt", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CarrierRestrictionVO();
				if (imdgCrrRstrSeq[i] != null)
					model.setImdgCrrRstrSeq(imdgCrrRstrSeq[i]);
				if (imdgPckGrpCd[i] != null)
					model.setImdgPckGrpCd(imdgPckGrpCd[i]);
				if (polPortCd[i] != null)
					model.setPolPortCd(polPortCd[i]);
				if (imdgUnNoSeq[i] != null)
					model.setImdgUnNoSeq(imdgUnNoSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (optclass[i] != null)
					model.setOptclass(optclass[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (crrReguDesc[i] != null)
					model.setCrrReguDesc(crrReguDesc[i]);
				if (imdgCompGrpCd[i] != null)
					model.setImdgCompGrpCd(imdgCompGrpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (podPortCd[i] != null)
					model.setPodPortCd(podPortCd[i]);
				if (imdgClssCdDesc[i] != null)
					model.setImdgClssCdDesc(imdgClssCdDesc[i]);
				if (vslOprTpCd[i] != null)
					model.setVslOprTpCd(vslOprTpCd[i]);
				if (imdgCrrRstrExptCd[i] != null)
					model.setImdgCrrRstrExptCd(imdgCrrRstrExptCd[i]);
				if (polVpsPortCd[i] != null)
					model.setPolVpsPortCd(polVpsPortCd[i]);
				if (imdgTecNm[i] != null)
					model.setImdgTecNm(imdgTecNm[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (imdgTekNmCheck[i] != null)
					model.setImdgTekNmCheck(imdgTekNmCheck[i]);
				if (imdgUnNoNull[i] != null)
					model.setImdgUnNoNull(imdgUnNoNull[i]);
				if (imdgSubsRskLblCd[i] != null)
					model.setImdgSubsRskLblCd(imdgSubsRskLblCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (rowSeq[i] != null)
					model.setRowSeq(rowSeq[i]);
				if (podVpsPortCd[i] != null)
					model.setPodVpsPortCd(podVpsPortCd[i]);
				if (prpShpNm[i] != null)
					model.setPrpShpNm(prpShpNm[i]);
				if (imdgClssCdTxt[i] != null)
					model.setImdgClssCdTxt(imdgClssCdTxt[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCarrierRestrictionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CarrierRestrictionVO[]
	 */
	public CarrierRestrictionVO[] getCarrierRestrictionVOs(){
		CarrierRestrictionVO[] vos = (CarrierRestrictionVO[])models.toArray(new CarrierRestrictionVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.imdgCrrRstrSeq = this.imdgCrrRstrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckGrpCd = this.imdgPckGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polPortCd = this.polPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNoSeq = this.imdgUnNoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optclass = this.optclass .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrReguDesc = this.crrReguDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgCompGrpCd = this.imdgCompGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podPortCd = this.podPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCdDesc = this.imdgClssCdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslOprTpCd = this.vslOprTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgCrrRstrExptCd = this.imdgCrrRstrExptCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polVpsPortCd = this.polVpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgTecNm = this.imdgTecNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgTekNmCheck = this.imdgTekNmCheck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNoNull = this.imdgUnNoNull .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSubsRskLblCd = this.imdgSubsRskLblCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowSeq = this.rowSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podVpsPortCd = this.podVpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prpShpNm = this.prpShpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCdTxt = this.imdgClssCdTxt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
