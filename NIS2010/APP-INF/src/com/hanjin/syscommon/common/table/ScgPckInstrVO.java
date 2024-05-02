/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScgPckInstrVO.java
*@FileTitle : ScgPckInstrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.05
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2013.06.05 원종규 
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

public class ScgPckInstrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ScgPckInstrVO> models = new ArrayList<ScgPckInstrVO>();
	
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String prssDesc = null;
	/* Column Info */
	private String spclPckReguUseFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String imdgPckInstrSeq = null;
	/* Column Info */
	private String outrPckMaxCapaFlg = null;
	/* Column Info */
	private String intmdPckUseFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String gasUseFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String imdgPckInstrCd = null;
	/* Column Info */
	private String pckReguUseFlg = null;
	/* Column Info */
	private String inrPckUseFlg = null;
	/* Column Info */
	private String outrPckUseFlg = null;
	/* Column Info */
	private String pckDescUseFlg = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String sglPckMaxCapaFlg = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String pckDesc = null;
	/* Column Info */
	private String addReguDesc = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String prssDescUseFlg = null;
	/* Column Info */
	private String addReguDescUseFlg = null;
	/* Column Info */
	private String pckExptFlg = null;
	/* Column Info */
	private String pckInstrTpCtnt = null;
	/* Column Info */
	private String sglPckUseFlg = null;
	/* Column Info */
	private String pckDivCd = null;
	/* Column Info */
	private String ptblTnkUseFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ScgPckInstrVO() {}

	public ScgPckInstrVO(String ibflag, String pagerows, String imdgPckInstrCd, String imdgPckInstrSeq, String addReguDesc, String addReguDescUseFlg, String creDt, String creUsrId, String deltFlg, String gasUseFlg, String inrPckUseFlg, String intmdPckUseFlg, String outrPckMaxCapaFlg, String outrPckUseFlg, String pckDesc, String pckDescUseFlg, String pckDivCd, String pckExptFlg, String pckInstrTpCtnt, String pckReguUseFlg, String prssDesc, String prssDescUseFlg, String ptblTnkUseFlg, String sglPckMaxCapaFlg, String sglPckUseFlg, String spclPckReguUseFlg, String updDt, String updUsrId) {
		this.deltFlg = deltFlg;
		this.prssDesc = prssDesc;
		this.spclPckReguUseFlg = spclPckReguUseFlg;
		this.creDt = creDt;
		this.imdgPckInstrSeq = imdgPckInstrSeq;
		this.outrPckMaxCapaFlg = outrPckMaxCapaFlg;
		this.intmdPckUseFlg = intmdPckUseFlg;
		this.pagerows = pagerows;
		this.gasUseFlg = gasUseFlg;
		this.ibflag = ibflag;
		this.imdgPckInstrCd = imdgPckInstrCd;
		this.pckReguUseFlg = pckReguUseFlg;
		this.inrPckUseFlg = inrPckUseFlg;
		this.outrPckUseFlg = outrPckUseFlg;
		this.pckDescUseFlg = pckDescUseFlg;
		this.updUsrId = updUsrId;
		this.sglPckMaxCapaFlg = sglPckMaxCapaFlg;
		this.updDt = updDt;
		this.pckDesc = pckDesc;
		this.addReguDesc = addReguDesc;
		this.creUsrId = creUsrId;
		this.prssDescUseFlg = prssDescUseFlg;
		this.addReguDescUseFlg = addReguDescUseFlg;
		this.pckExptFlg = pckExptFlg;
		this.pckInstrTpCtnt = pckInstrTpCtnt;
		this.sglPckUseFlg = sglPckUseFlg;
		this.pckDivCd = pckDivCd;
		this.ptblTnkUseFlg = ptblTnkUseFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("prss_desc", getPrssDesc());
		this.hashColumns.put("spcl_pck_regu_use_flg", getSpclPckReguUseFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("imdg_pck_instr_seq", getImdgPckInstrSeq());
		this.hashColumns.put("outr_pck_max_capa_flg", getOutrPckMaxCapaFlg());
		this.hashColumns.put("intmd_pck_use_flg", getIntmdPckUseFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("gas_use_flg", getGasUseFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("imdg_pck_instr_cd", getImdgPckInstrCd());
		this.hashColumns.put("pck_regu_use_flg", getPckReguUseFlg());
		this.hashColumns.put("inr_pck_use_flg", getInrPckUseFlg());
		this.hashColumns.put("outr_pck_use_flg", getOutrPckUseFlg());
		this.hashColumns.put("pck_desc_use_flg", getPckDescUseFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("sgl_pck_max_capa_flg", getSglPckMaxCapaFlg());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("pck_desc", getPckDesc());
		this.hashColumns.put("add_regu_desc", getAddReguDesc());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("prss_desc_use_flg", getPrssDescUseFlg());
		this.hashColumns.put("add_regu_desc_use_flg", getAddReguDescUseFlg());
		this.hashColumns.put("pck_expt_flg", getPckExptFlg());
		this.hashColumns.put("pck_instr_tp_ctnt", getPckInstrTpCtnt());
		this.hashColumns.put("sgl_pck_use_flg", getSglPckUseFlg());
		this.hashColumns.put("pck_div_cd", getPckDivCd());
		this.hashColumns.put("ptbl_tnk_use_flg", getPtblTnkUseFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("prss_desc", "prssDesc");
		this.hashFields.put("spcl_pck_regu_use_flg", "spclPckReguUseFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("imdg_pck_instr_seq", "imdgPckInstrSeq");
		this.hashFields.put("outr_pck_max_capa_flg", "outrPckMaxCapaFlg");
		this.hashFields.put("intmd_pck_use_flg", "intmdPckUseFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("gas_use_flg", "gasUseFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("imdg_pck_instr_cd", "imdgPckInstrCd");
		this.hashFields.put("pck_regu_use_flg", "pckReguUseFlg");
		this.hashFields.put("inr_pck_use_flg", "inrPckUseFlg");
		this.hashFields.put("outr_pck_use_flg", "outrPckUseFlg");
		this.hashFields.put("pck_desc_use_flg", "pckDescUseFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("sgl_pck_max_capa_flg", "sglPckMaxCapaFlg");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("pck_desc", "pckDesc");
		this.hashFields.put("add_regu_desc", "addReguDesc");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("prss_desc_use_flg", "prssDescUseFlg");
		this.hashFields.put("add_regu_desc_use_flg", "addReguDescUseFlg");
		this.hashFields.put("pck_expt_flg", "pckExptFlg");
		this.hashFields.put("pck_instr_tp_ctnt", "pckInstrTpCtnt");
		this.hashFields.put("sgl_pck_use_flg", "sglPckUseFlg");
		this.hashFields.put("pck_div_cd", "pckDivCd");
		this.hashFields.put("ptbl_tnk_use_flg", "ptblTnkUseFlg");
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
	 * @return prssDesc
	 */
	public String getPrssDesc() {
		return this.prssDesc;
	}
	
	/**
	 * Column Info
	 * @return spclPckReguUseFlg
	 */
	public String getSpclPckReguUseFlg() {
		return this.spclPckReguUseFlg;
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
	 * @return imdgPckInstrSeq
	 */
	public String getImdgPckInstrSeq() {
		return this.imdgPckInstrSeq;
	}
	
	/**
	 * Column Info
	 * @return outrPckMaxCapaFlg
	 */
	public String getOutrPckMaxCapaFlg() {
		return this.outrPckMaxCapaFlg;
	}
	
	/**
	 * Column Info
	 * @return intmdPckUseFlg
	 */
	public String getIntmdPckUseFlg() {
		return this.intmdPckUseFlg;
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
	 * @return gasUseFlg
	 */
	public String getGasUseFlg() {
		return this.gasUseFlg;
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
	 * @return imdgPckInstrCd
	 */
	public String getImdgPckInstrCd() {
		return this.imdgPckInstrCd;
	}
	
	/**
	 * Column Info
	 * @return pckReguUseFlg
	 */
	public String getPckReguUseFlg() {
		return this.pckReguUseFlg;
	}
	
	/**
	 * Column Info
	 * @return inrPckUseFlg
	 */
	public String getInrPckUseFlg() {
		return this.inrPckUseFlg;
	}
	
	/**
	 * Column Info
	 * @return outrPckUseFlg
	 */
	public String getOutrPckUseFlg() {
		return this.outrPckUseFlg;
	}
	
	/**
	 * Column Info
	 * @return pckDescUseFlg
	 */
	public String getPckDescUseFlg() {
		return this.pckDescUseFlg;
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
	 * @return sglPckMaxCapaFlg
	 */
	public String getSglPckMaxCapaFlg() {
		return this.sglPckMaxCapaFlg;
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
	 * @return pckDesc
	 */
	public String getPckDesc() {
		return this.pckDesc;
	}
	
	/**
	 * Column Info
	 * @return addReguDesc
	 */
	public String getAddReguDesc() {
		return this.addReguDesc;
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
	 * @return prssDescUseFlg
	 */
	public String getPrssDescUseFlg() {
		return this.prssDescUseFlg;
	}
	
	/**
	 * Column Info
	 * @return addReguDescUseFlg
	 */
	public String getAddReguDescUseFlg() {
		return this.addReguDescUseFlg;
	}
	
	/**
	 * Column Info
	 * @return pckExptFlg
	 */
	public String getPckExptFlg() {
		return this.pckExptFlg;
	}
	
	/**
	 * Column Info
	 * @return pckInstrTpCtnt
	 */
	public String getPckInstrTpCtnt() {
		return this.pckInstrTpCtnt;
	}
	
	/**
	 * Column Info
	 * @return sglPckUseFlg
	 */
	public String getSglPckUseFlg() {
		return this.sglPckUseFlg;
	}
	
	/**
	 * Column Info
	 * @return pckDivCd
	 */
	public String getPckDivCd() {
		return this.pckDivCd;
	}
	
	/**
	 * Column Info
	 * @return ptblTnkUseFlg
	 */
	public String getPtblTnkUseFlg() {
		return this.ptblTnkUseFlg;
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
	 * @param prssDesc
	 */
	public void setPrssDesc(String prssDesc) {
		this.prssDesc = prssDesc;
	}
	
	/**
	 * Column Info
	 * @param spclPckReguUseFlg
	 */
	public void setSpclPckReguUseFlg(String spclPckReguUseFlg) {
		this.spclPckReguUseFlg = spclPckReguUseFlg;
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
	 * @param imdgPckInstrSeq
	 */
	public void setImdgPckInstrSeq(String imdgPckInstrSeq) {
		this.imdgPckInstrSeq = imdgPckInstrSeq;
	}
	
	/**
	 * Column Info
	 * @param outrPckMaxCapaFlg
	 */
	public void setOutrPckMaxCapaFlg(String outrPckMaxCapaFlg) {
		this.outrPckMaxCapaFlg = outrPckMaxCapaFlg;
	}
	
	/**
	 * Column Info
	 * @param intmdPckUseFlg
	 */
	public void setIntmdPckUseFlg(String intmdPckUseFlg) {
		this.intmdPckUseFlg = intmdPckUseFlg;
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
	 * @param gasUseFlg
	 */
	public void setGasUseFlg(String gasUseFlg) {
		this.gasUseFlg = gasUseFlg;
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
	 * @param imdgPckInstrCd
	 */
	public void setImdgPckInstrCd(String imdgPckInstrCd) {
		this.imdgPckInstrCd = imdgPckInstrCd;
	}
	
	/**
	 * Column Info
	 * @param pckReguUseFlg
	 */
	public void setPckReguUseFlg(String pckReguUseFlg) {
		this.pckReguUseFlg = pckReguUseFlg;
	}
	
	/**
	 * Column Info
	 * @param inrPckUseFlg
	 */
	public void setInrPckUseFlg(String inrPckUseFlg) {
		this.inrPckUseFlg = inrPckUseFlg;
	}
	
	/**
	 * Column Info
	 * @param outrPckUseFlg
	 */
	public void setOutrPckUseFlg(String outrPckUseFlg) {
		this.outrPckUseFlg = outrPckUseFlg;
	}
	
	/**
	 * Column Info
	 * @param pckDescUseFlg
	 */
	public void setPckDescUseFlg(String pckDescUseFlg) {
		this.pckDescUseFlg = pckDescUseFlg;
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
	 * @param sglPckMaxCapaFlg
	 */
	public void setSglPckMaxCapaFlg(String sglPckMaxCapaFlg) {
		this.sglPckMaxCapaFlg = sglPckMaxCapaFlg;
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
	 * @param pckDesc
	 */
	public void setPckDesc(String pckDesc) {
		this.pckDesc = pckDesc;
	}
	
	/**
	 * Column Info
	 * @param addReguDesc
	 */
	public void setAddReguDesc(String addReguDesc) {
		this.addReguDesc = addReguDesc;
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
	 * @param prssDescUseFlg
	 */
	public void setPrssDescUseFlg(String prssDescUseFlg) {
		this.prssDescUseFlg = prssDescUseFlg;
	}
	
	/**
	 * Column Info
	 * @param addReguDescUseFlg
	 */
	public void setAddReguDescUseFlg(String addReguDescUseFlg) {
		this.addReguDescUseFlg = addReguDescUseFlg;
	}
	
	/**
	 * Column Info
	 * @param pckExptFlg
	 */
	public void setPckExptFlg(String pckExptFlg) {
		this.pckExptFlg = pckExptFlg;
	}
	
	/**
	 * Column Info
	 * @param pckInstrTpCtnt
	 */
	public void setPckInstrTpCtnt(String pckInstrTpCtnt) {
		this.pckInstrTpCtnt = pckInstrTpCtnt;
	}
	
	/**
	 * Column Info
	 * @param sglPckUseFlg
	 */
	public void setSglPckUseFlg(String sglPckUseFlg) {
		this.sglPckUseFlg = sglPckUseFlg;
	}
	
	/**
	 * Column Info
	 * @param pckDivCd
	 */
	public void setPckDivCd(String pckDivCd) {
		this.pckDivCd = pckDivCd;
	}
	
	/**
	 * Column Info
	 * @param ptblTnkUseFlg
	 */
	public void setPtblTnkUseFlg(String ptblTnkUseFlg) {
		this.ptblTnkUseFlg = ptblTnkUseFlg;
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
		setPrssDesc(JSPUtil.getParameter(request, prefix + "prss_desc", ""));
		setSpclPckReguUseFlg(JSPUtil.getParameter(request, prefix + "spcl_pck_regu_use_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setImdgPckInstrSeq(JSPUtil.getParameter(request, prefix + "imdg_pck_instr_seq", ""));
		setOutrPckMaxCapaFlg(JSPUtil.getParameter(request, prefix + "outr_pck_max_capa_flg", ""));
		setIntmdPckUseFlg(JSPUtil.getParameter(request, prefix + "intmd_pck_use_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setGasUseFlg(JSPUtil.getParameter(request, prefix + "gas_use_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setImdgPckInstrCd(JSPUtil.getParameter(request, prefix + "imdg_pck_instr_cd", ""));
		setPckReguUseFlg(JSPUtil.getParameter(request, prefix + "pck_regu_use_flg", ""));
		setInrPckUseFlg(JSPUtil.getParameter(request, prefix + "inr_pck_use_flg", ""));
		setOutrPckUseFlg(JSPUtil.getParameter(request, prefix + "outr_pck_use_flg", ""));
		setPckDescUseFlg(JSPUtil.getParameter(request, prefix + "pck_desc_use_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setSglPckMaxCapaFlg(JSPUtil.getParameter(request, prefix + "sgl_pck_max_capa_flg", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setPckDesc(JSPUtil.getParameter(request, prefix + "pck_desc", ""));
		setAddReguDesc(JSPUtil.getParameter(request, prefix + "add_regu_desc", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setPrssDescUseFlg(JSPUtil.getParameter(request, prefix + "prss_desc_use_flg", ""));
		setAddReguDescUseFlg(JSPUtil.getParameter(request, prefix + "add_regu_desc_use_flg", ""));
		setPckExptFlg(JSPUtil.getParameter(request, prefix + "pck_expt_flg", ""));
		setPckInstrTpCtnt(JSPUtil.getParameter(request, prefix + "pck_instr_tp_ctnt", ""));
		setSglPckUseFlg(JSPUtil.getParameter(request, prefix + "sgl_pck_use_flg", ""));
		setPckDivCd(JSPUtil.getParameter(request, prefix + "pck_div_cd", ""));
		setPtblTnkUseFlg(JSPUtil.getParameter(request, prefix + "ptbl_tnk_use_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScgPckInstrVO[]
	 */
	public ScgPckInstrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ScgPckInstrVO[]
	 */
	public ScgPckInstrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ScgPckInstrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] prssDesc = (JSPUtil.getParameter(request, prefix	+ "prss_desc", length));
			String[] spclPckReguUseFlg = (JSPUtil.getParameter(request, prefix	+ "spcl_pck_regu_use_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] imdgPckInstrSeq = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_instr_seq", length));
			String[] outrPckMaxCapaFlg = (JSPUtil.getParameter(request, prefix	+ "outr_pck_max_capa_flg", length));
			String[] intmdPckUseFlg = (JSPUtil.getParameter(request, prefix	+ "intmd_pck_use_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] gasUseFlg = (JSPUtil.getParameter(request, prefix	+ "gas_use_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] imdgPckInstrCd = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_instr_cd", length));
			String[] pckReguUseFlg = (JSPUtil.getParameter(request, prefix	+ "pck_regu_use_flg", length));
			String[] inrPckUseFlg = (JSPUtil.getParameter(request, prefix	+ "inr_pck_use_flg", length));
			String[] outrPckUseFlg = (JSPUtil.getParameter(request, prefix	+ "outr_pck_use_flg", length));
			String[] pckDescUseFlg = (JSPUtil.getParameter(request, prefix	+ "pck_desc_use_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] sglPckMaxCapaFlg = (JSPUtil.getParameter(request, prefix	+ "sgl_pck_max_capa_flg", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] pckDesc = (JSPUtil.getParameter(request, prefix	+ "pck_desc", length));
			String[] addReguDesc = (JSPUtil.getParameter(request, prefix	+ "add_regu_desc", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] prssDescUseFlg = (JSPUtil.getParameter(request, prefix	+ "prss_desc_use_flg", length));
			String[] addReguDescUseFlg = (JSPUtil.getParameter(request, prefix	+ "add_regu_desc_use_flg", length));
			String[] pckExptFlg = (JSPUtil.getParameter(request, prefix	+ "pck_expt_flg", length));
			String[] pckInstrTpCtnt = (JSPUtil.getParameter(request, prefix	+ "pck_instr_tp_ctnt", length));
			String[] sglPckUseFlg = (JSPUtil.getParameter(request, prefix	+ "sgl_pck_use_flg", length));
			String[] pckDivCd = (JSPUtil.getParameter(request, prefix	+ "pck_div_cd", length));
			String[] ptblTnkUseFlg = (JSPUtil.getParameter(request, prefix	+ "ptbl_tnk_use_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new ScgPckInstrVO();
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (prssDesc[i] != null)
					model.setPrssDesc(prssDesc[i]);
				if (spclPckReguUseFlg[i] != null)
					model.setSpclPckReguUseFlg(spclPckReguUseFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (imdgPckInstrSeq[i] != null)
					model.setImdgPckInstrSeq(imdgPckInstrSeq[i]);
				if (outrPckMaxCapaFlg[i] != null)
					model.setOutrPckMaxCapaFlg(outrPckMaxCapaFlg[i]);
				if (intmdPckUseFlg[i] != null)
					model.setIntmdPckUseFlg(intmdPckUseFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (gasUseFlg[i] != null)
					model.setGasUseFlg(gasUseFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (imdgPckInstrCd[i] != null)
					model.setImdgPckInstrCd(imdgPckInstrCd[i]);
				if (pckReguUseFlg[i] != null)
					model.setPckReguUseFlg(pckReguUseFlg[i]);
				if (inrPckUseFlg[i] != null)
					model.setInrPckUseFlg(inrPckUseFlg[i]);
				if (outrPckUseFlg[i] != null)
					model.setOutrPckUseFlg(outrPckUseFlg[i]);
				if (pckDescUseFlg[i] != null)
					model.setPckDescUseFlg(pckDescUseFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (sglPckMaxCapaFlg[i] != null)
					model.setSglPckMaxCapaFlg(sglPckMaxCapaFlg[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (pckDesc[i] != null)
					model.setPckDesc(pckDesc[i]);
				if (addReguDesc[i] != null)
					model.setAddReguDesc(addReguDesc[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (prssDescUseFlg[i] != null)
					model.setPrssDescUseFlg(prssDescUseFlg[i]);
				if (addReguDescUseFlg[i] != null)
					model.setAddReguDescUseFlg(addReguDescUseFlg[i]);
				if (pckExptFlg[i] != null)
					model.setPckExptFlg(pckExptFlg[i]);
				if (pckInstrTpCtnt[i] != null)
					model.setPckInstrTpCtnt(pckInstrTpCtnt[i]);
				if (sglPckUseFlg[i] != null)
					model.setSglPckUseFlg(sglPckUseFlg[i]);
				if (pckDivCd[i] != null)
					model.setPckDivCd(pckDivCd[i]);
				if (ptblTnkUseFlg[i] != null)
					model.setPtblTnkUseFlg(ptblTnkUseFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getScgPckInstrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ScgPckInstrVO[]
	 */
	public ScgPckInstrVO[] getScgPckInstrVOs(){
		ScgPckInstrVO[] vos = (ScgPckInstrVO[])models.toArray(new ScgPckInstrVO[models.size()]);
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
		this.prssDesc = this.prssDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclPckReguUseFlg = this.spclPckReguUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckInstrSeq = this.imdgPckInstrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outrPckMaxCapaFlg = this.outrPckMaxCapaFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intmdPckUseFlg = this.intmdPckUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gasUseFlg = this.gasUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckInstrCd = this.imdgPckInstrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckReguUseFlg = this.pckReguUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inrPckUseFlg = this.inrPckUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outrPckUseFlg = this.outrPckUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckDescUseFlg = this.pckDescUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sglPckMaxCapaFlg = this.sglPckMaxCapaFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckDesc = this.pckDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addReguDesc = this.addReguDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prssDescUseFlg = this.prssDescUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addReguDescUseFlg = this.addReguDescUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckExptFlg = this.pckExptFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckInstrTpCtnt = this.pckInstrTpCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sglPckUseFlg = this.sglPckUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckDivCd = this.pckDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptblTnkUseFlg = this.ptblTnkUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
