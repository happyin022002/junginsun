/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PortLimitsUnNoVO.java
*@FileTitle : PortLimitsUnNoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.23  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PortLimitsUnNoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PortLimitsUnNoVO> models = new ArrayList<PortLimitsUnNoVO>();
	
	/* Column Info */
	private String pptExploFlg = null;
	/* Column Info */
	private String imdgPckGrpCd = null;
	/* Column Info */
	private String flshPntTemp = null;
	/* Column Info */
	private String seqNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String pierTpCd = null;
	/* Column Info */
	private String lodMaxQty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String imdgCompGrpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String arrDepProhiFlg = null;
	/* Column Info */
	private String cntrTpCd = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String portLmtSeq = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String ldisAplyTgtFlg = null;
	/* Column Info */
	private String imdgSubsRskLblCd = null;
	/* Column Info */
	private String portLmtSubPptCd = null;
	/* Column Info */
	private String lmtWgtTpCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String depMaxQty = null;
	/* Column Info */
	private String arrMaxQty = null;
	/* Column Info */
	private String dchgMaxQty = null;
	/* Column Info */
	private String vClssInfo = null;
	/* Column Info */
	private String portLmtRepDesc = null;
	/* Column Info */
	private String portLmtClssSeq = null;
	/* Column Info */
	private String pptProhiFlg = null;
	/* Column Info */
	private String imdgClssCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PortLimitsUnNoVO() {}

	public PortLimitsUnNoVO(String ibflag, String pagerows, String portCd, String lmtWgtTpCd, String portLmtSeq, String pierTpCd, String portLmtRepDesc, String imdgSubsRskLblCd, String imdgPckGrpCd, String flshPntTemp, String portLmtSubPptCd, String cntrTpCd, String cmdtCd, String arrDepProhiFlg, String ldisAplyTgtFlg, String arrMaxQty, String lodMaxQty, String dchgMaxQty, String depMaxQty, String pptExploFlg, String pptProhiFlg, String seqNo, String portLmtClssSeq, String imdgClssCd, String imdgCompGrpCd, String imdgUnNo, String vClssInfo, String creOfcCd, String updOfcCd, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.pptExploFlg = pptExploFlg;
		this.imdgPckGrpCd = imdgPckGrpCd;
		this.flshPntTemp = flshPntTemp;
		this.seqNo = seqNo;
		this.creDt = creDt;
		this.pierTpCd = pierTpCd;
		this.lodMaxQty = lodMaxQty;
		this.pagerows = pagerows;
		this.imdgCompGrpCd = imdgCompGrpCd;
		this.ibflag = ibflag;
		this.arrDepProhiFlg = arrDepProhiFlg;
		this.cntrTpCd = cntrTpCd;
		this.cmdtCd = cmdtCd;
		this.creOfcCd = creOfcCd;
		this.portLmtSeq = portLmtSeq;
		this.portCd = portCd;
		this.updUsrId = updUsrId;
		this.updOfcCd = updOfcCd;
		this.imdgUnNo = imdgUnNo;
		this.updDt = updDt;
		this.ldisAplyTgtFlg = ldisAplyTgtFlg;
		this.imdgSubsRskLblCd = imdgSubsRskLblCd;
		this.portLmtSubPptCd = portLmtSubPptCd;
		this.lmtWgtTpCd = lmtWgtTpCd;
		this.creUsrId = creUsrId;
		this.depMaxQty = depMaxQty;
		this.arrMaxQty = arrMaxQty;
		this.dchgMaxQty = dchgMaxQty;
		this.vClssInfo = vClssInfo;
		this.portLmtRepDesc = portLmtRepDesc;
		this.portLmtClssSeq = portLmtClssSeq;
		this.pptProhiFlg = pptProhiFlg;
		this.imdgClssCd = imdgClssCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ppt_explo_flg", getPptExploFlg());
		this.hashColumns.put("imdg_pck_grp_cd", getImdgPckGrpCd());
		this.hashColumns.put("flsh_pnt_temp", getFlshPntTemp());
		this.hashColumns.put("seq_no", getSeqNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pier_tp_cd", getPierTpCd());
		this.hashColumns.put("lod_max_qty", getLodMaxQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("imdg_comp_grp_cd", getImdgCompGrpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("arr_dep_prohi_flg", getArrDepProhiFlg());
		this.hashColumns.put("cntr_tp_cd", getCntrTpCd());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("port_lmt_seq", getPortLmtSeq());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ldis_aply_tgt_flg", getLdisAplyTgtFlg());
		this.hashColumns.put("imdg_subs_rsk_lbl_cd", getImdgSubsRskLblCd());
		this.hashColumns.put("port_lmt_sub_ppt_cd", getPortLmtSubPptCd());
		this.hashColumns.put("lmt_wgt_tp_cd", getLmtWgtTpCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("dep_max_qty", getDepMaxQty());
		this.hashColumns.put("arr_max_qty", getArrMaxQty());
		this.hashColumns.put("dchg_max_qty", getDchgMaxQty());
		this.hashColumns.put("v_clss_info", getVClssInfo());
		this.hashColumns.put("port_lmt_rep_desc", getPortLmtRepDesc());
		this.hashColumns.put("port_lmt_clss_seq", getPortLmtClssSeq());
		this.hashColumns.put("ppt_prohi_flg", getPptProhiFlg());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ppt_explo_flg", "pptExploFlg");
		this.hashFields.put("imdg_pck_grp_cd", "imdgPckGrpCd");
		this.hashFields.put("flsh_pnt_temp", "flshPntTemp");
		this.hashFields.put("seq_no", "seqNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pier_tp_cd", "pierTpCd");
		this.hashFields.put("lod_max_qty", "lodMaxQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("imdg_comp_grp_cd", "imdgCompGrpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("arr_dep_prohi_flg", "arrDepProhiFlg");
		this.hashFields.put("cntr_tp_cd", "cntrTpCd");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("port_lmt_seq", "portLmtSeq");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ldis_aply_tgt_flg", "ldisAplyTgtFlg");
		this.hashFields.put("imdg_subs_rsk_lbl_cd", "imdgSubsRskLblCd");
		this.hashFields.put("port_lmt_sub_ppt_cd", "portLmtSubPptCd");
		this.hashFields.put("lmt_wgt_tp_cd", "lmtWgtTpCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("dep_max_qty", "depMaxQty");
		this.hashFields.put("arr_max_qty", "arrMaxQty");
		this.hashFields.put("dchg_max_qty", "dchgMaxQty");
		this.hashFields.put("v_clss_info", "vClssInfo");
		this.hashFields.put("port_lmt_rep_desc", "portLmtRepDesc");
		this.hashFields.put("port_lmt_clss_seq", "portLmtClssSeq");
		this.hashFields.put("ppt_prohi_flg", "pptProhiFlg");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return pptExploFlg
	 */
	public String getPptExploFlg() {
		return this.pptExploFlg;
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
	 * @return flshPntTemp
	 */
	public String getFlshPntTemp() {
		return this.flshPntTemp;
	}
	
	/**
	 * Column Info
	 * @return seqNo
	 */
	public String getSeqNo() {
		return this.seqNo;
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
	 * @return pierTpCd
	 */
	public String getPierTpCd() {
		return this.pierTpCd;
	}
	
	/**
	 * Column Info
	 * @return lodMaxQty
	 */
	public String getLodMaxQty() {
		return this.lodMaxQty;
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
	 * @return arrDepProhiFlg
	 */
	public String getArrDepProhiFlg() {
		return this.arrDepProhiFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrTpCd
	 */
	public String getCntrTpCd() {
		return this.cntrTpCd;
	}
	
	/**
	 * Column Info
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
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
	 * @return portLmtSeq
	 */
	public String getPortLmtSeq() {
		return this.portLmtSeq;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
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
	 * @return updOfcCd
	 */
	public String getUpdOfcCd() {
		return this.updOfcCd;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return ldisAplyTgtFlg
	 */
	public String getLdisAplyTgtFlg() {
		return this.ldisAplyTgtFlg;
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
	 * @return portLmtSubPptCd
	 */
	public String getPortLmtSubPptCd() {
		return this.portLmtSubPptCd;
	}
	
	/**
	 * Column Info
	 * @return lmtWgtTpCd
	 */
	public String getLmtWgtTpCd() {
		return this.lmtWgtTpCd;
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
	 * @return depMaxQty
	 */
	public String getDepMaxQty() {
		return this.depMaxQty;
	}
	
	/**
	 * Column Info
	 * @return arrMaxQty
	 */
	public String getArrMaxQty() {
		return this.arrMaxQty;
	}
	
	/**
	 * Column Info
	 * @return dchgMaxQty
	 */
	public String getDchgMaxQty() {
		return this.dchgMaxQty;
	}
	
	/**
	 * Column Info
	 * @return vClssInfo
	 */
	public String getVClssInfo() {
		return this.vClssInfo;
	}
	
	/**
	 * Column Info
	 * @return portLmtRepDesc
	 */
	public String getPortLmtRepDesc() {
		return this.portLmtRepDesc;
	}
	
	/**
	 * Column Info
	 * @return portLmtClssSeq
	 */
	public String getPortLmtClssSeq() {
		return this.portLmtClssSeq;
	}
	
	/**
	 * Column Info
	 * @return pptProhiFlg
	 */
	public String getPptProhiFlg() {
		return this.pptProhiFlg;
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
	 * @param pptExploFlg
	 */
	public void setPptExploFlg(String pptExploFlg) {
		this.pptExploFlg = pptExploFlg;
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
	 * @param flshPntTemp
	 */
	public void setFlshPntTemp(String flshPntTemp) {
		this.flshPntTemp = flshPntTemp;
	}
	
	/**
	 * Column Info
	 * @param seqNo
	 */
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
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
	 * @param pierTpCd
	 */
	public void setPierTpCd(String pierTpCd) {
		this.pierTpCd = pierTpCd;
	}
	
	/**
	 * Column Info
	 * @param lodMaxQty
	 */
	public void setLodMaxQty(String lodMaxQty) {
		this.lodMaxQty = lodMaxQty;
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
	 * @param arrDepProhiFlg
	 */
	public void setArrDepProhiFlg(String arrDepProhiFlg) {
		this.arrDepProhiFlg = arrDepProhiFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrTpCd
	 */
	public void setCntrTpCd(String cntrTpCd) {
		this.cntrTpCd = cntrTpCd;
	}
	
	/**
	 * Column Info
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
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
	 * @param portLmtSeq
	 */
	public void setPortLmtSeq(String portLmtSeq) {
		this.portLmtSeq = portLmtSeq;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
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
	 * @param updOfcCd
	 */
	public void setUpdOfcCd(String updOfcCd) {
		this.updOfcCd = updOfcCd;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param ldisAplyTgtFlg
	 */
	public void setLdisAplyTgtFlg(String ldisAplyTgtFlg) {
		this.ldisAplyTgtFlg = ldisAplyTgtFlg;
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
	 * @param portLmtSubPptCd
	 */
	public void setPortLmtSubPptCd(String portLmtSubPptCd) {
		this.portLmtSubPptCd = portLmtSubPptCd;
	}
	
	/**
	 * Column Info
	 * @param lmtWgtTpCd
	 */
	public void setLmtWgtTpCd(String lmtWgtTpCd) {
		this.lmtWgtTpCd = lmtWgtTpCd;
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
	 * @param depMaxQty
	 */
	public void setDepMaxQty(String depMaxQty) {
		this.depMaxQty = depMaxQty;
	}
	
	/**
	 * Column Info
	 * @param arrMaxQty
	 */
	public void setArrMaxQty(String arrMaxQty) {
		this.arrMaxQty = arrMaxQty;
	}
	
	/**
	 * Column Info
	 * @param dchgMaxQty
	 */
	public void setDchgMaxQty(String dchgMaxQty) {
		this.dchgMaxQty = dchgMaxQty;
	}
	
	/**
	 * Column Info
	 * @param vClssInfo
	 */
	public void setVClssInfo(String vClssInfo) {
		this.vClssInfo = vClssInfo;
	}
	
	/**
	 * Column Info
	 * @param portLmtRepDesc
	 */
	public void setPortLmtRepDesc(String portLmtRepDesc) {
		this.portLmtRepDesc = portLmtRepDesc;
	}
	
	/**
	 * Column Info
	 * @param portLmtClssSeq
	 */
	public void setPortLmtClssSeq(String portLmtClssSeq) {
		this.portLmtClssSeq = portLmtClssSeq;
	}
	
	/**
	 * Column Info
	 * @param pptProhiFlg
	 */
	public void setPptProhiFlg(String pptProhiFlg) {
		this.pptProhiFlg = pptProhiFlg;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setPptExploFlg(JSPUtil.getParameter(request, prefix + "ppt_explo_flg", ""));
		setImdgPckGrpCd(JSPUtil.getParameter(request, prefix + "imdg_pck_grp_cd", ""));
		setFlshPntTemp(JSPUtil.getParameter(request, prefix + "flsh_pnt_temp", ""));
		setSeqNo(JSPUtil.getParameter(request, prefix + "seq_no", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPierTpCd(JSPUtil.getParameter(request, prefix + "pier_tp_cd", ""));
		setLodMaxQty(JSPUtil.getParameter(request, prefix + "lod_max_qty", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setImdgCompGrpCd(JSPUtil.getParameter(request, prefix + "imdg_comp_grp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setArrDepProhiFlg(JSPUtil.getParameter(request, prefix + "arr_dep_prohi_flg", ""));
		setCntrTpCd(JSPUtil.getParameter(request, prefix + "cntr_tp_cd", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setPortLmtSeq(JSPUtil.getParameter(request, prefix + "port_lmt_seq", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, prefix + "upd_ofc_cd", ""));
		setImdgUnNo(JSPUtil.getParameter(request, prefix + "imdg_un_no", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setLdisAplyTgtFlg(JSPUtil.getParameter(request, prefix + "ldis_aply_tgt_flg", ""));
		setImdgSubsRskLblCd(JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_cd", ""));
		setPortLmtSubPptCd(JSPUtil.getParameter(request, prefix + "port_lmt_sub_ppt_cd", ""));
		setLmtWgtTpCd(JSPUtil.getParameter(request, prefix + "lmt_wgt_tp_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setDepMaxQty(JSPUtil.getParameter(request, prefix + "dep_max_qty", ""));
		setArrMaxQty(JSPUtil.getParameter(request, prefix + "arr_max_qty", ""));
		setDchgMaxQty(JSPUtil.getParameter(request, prefix + "dchg_max_qty", ""));
		setVClssInfo(JSPUtil.getParameter(request, prefix + "v_clss_info", ""));
		setPortLmtRepDesc(JSPUtil.getParameter(request, prefix + "port_lmt_rep_desc", ""));
		setPortLmtClssSeq(JSPUtil.getParameter(request, prefix + "port_lmt_clss_seq", ""));
		setPptProhiFlg(JSPUtil.getParameter(request, prefix + "ppt_prohi_flg", ""));
		setImdgClssCd(JSPUtil.getParameter(request, prefix + "imdg_clss_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PortLimitsUnNoVO[]
	 */
	public PortLimitsUnNoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PortLimitsUnNoVO[]
	 */
	public PortLimitsUnNoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PortLimitsUnNoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pptExploFlg = (JSPUtil.getParameter(request, prefix	+ "ppt_explo_flg", length));
			String[] imdgPckGrpCd = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_grp_cd", length));
			String[] flshPntTemp = (JSPUtil.getParameter(request, prefix	+ "flsh_pnt_temp", length));
			String[] seqNo = (JSPUtil.getParameter(request, prefix	+ "seq_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pierTpCd = (JSPUtil.getParameter(request, prefix	+ "pier_tp_cd", length));
			String[] lodMaxQty = (JSPUtil.getParameter(request, prefix	+ "lod_max_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] imdgCompGrpCd = (JSPUtil.getParameter(request, prefix	+ "imdg_comp_grp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] arrDepProhiFlg = (JSPUtil.getParameter(request, prefix	+ "arr_dep_prohi_flg", length));
			String[] cntrTpCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tp_cd", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] portLmtSeq = (JSPUtil.getParameter(request, prefix	+ "port_lmt_seq", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] ldisAplyTgtFlg = (JSPUtil.getParameter(request, prefix	+ "ldis_aply_tgt_flg", length));
			String[] imdgSubsRskLblCd = (JSPUtil.getParameter(request, prefix	+ "imdg_subs_rsk_lbl_cd", length));
			String[] portLmtSubPptCd = (JSPUtil.getParameter(request, prefix	+ "port_lmt_sub_ppt_cd", length));
			String[] lmtWgtTpCd = (JSPUtil.getParameter(request, prefix	+ "lmt_wgt_tp_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] depMaxQty = (JSPUtil.getParameter(request, prefix	+ "dep_max_qty", length));
			String[] arrMaxQty = (JSPUtil.getParameter(request, prefix	+ "arr_max_qty", length));
			String[] dchgMaxQty = (JSPUtil.getParameter(request, prefix	+ "dchg_max_qty", length));
			String[] vClssInfo = (JSPUtil.getParameter(request, prefix	+ "v_clss_info", length));
			String[] portLmtRepDesc = (JSPUtil.getParameter(request, prefix	+ "port_lmt_rep_desc", length));
			String[] portLmtClssSeq = (JSPUtil.getParameter(request, prefix	+ "port_lmt_clss_seq", length));
			String[] pptProhiFlg = (JSPUtil.getParameter(request, prefix	+ "ppt_prohi_flg", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new PortLimitsUnNoVO();
				if (pptExploFlg[i] != null)
					model.setPptExploFlg(pptExploFlg[i]);
				if (imdgPckGrpCd[i] != null)
					model.setImdgPckGrpCd(imdgPckGrpCd[i]);
				if (flshPntTemp[i] != null)
					model.setFlshPntTemp(flshPntTemp[i]);
				if (seqNo[i] != null)
					model.setSeqNo(seqNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pierTpCd[i] != null)
					model.setPierTpCd(pierTpCd[i]);
				if (lodMaxQty[i] != null)
					model.setLodMaxQty(lodMaxQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (imdgCompGrpCd[i] != null)
					model.setImdgCompGrpCd(imdgCompGrpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (arrDepProhiFlg[i] != null)
					model.setArrDepProhiFlg(arrDepProhiFlg[i]);
				if (cntrTpCd[i] != null)
					model.setCntrTpCd(cntrTpCd[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (portLmtSeq[i] != null)
					model.setPortLmtSeq(portLmtSeq[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ldisAplyTgtFlg[i] != null)
					model.setLdisAplyTgtFlg(ldisAplyTgtFlg[i]);
				if (imdgSubsRskLblCd[i] != null)
					model.setImdgSubsRskLblCd(imdgSubsRskLblCd[i]);
				if (portLmtSubPptCd[i] != null)
					model.setPortLmtSubPptCd(portLmtSubPptCd[i]);
				if (lmtWgtTpCd[i] != null)
					model.setLmtWgtTpCd(lmtWgtTpCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (depMaxQty[i] != null)
					model.setDepMaxQty(depMaxQty[i]);
				if (arrMaxQty[i] != null)
					model.setArrMaxQty(arrMaxQty[i]);
				if (dchgMaxQty[i] != null)
					model.setDchgMaxQty(dchgMaxQty[i]);
				if (vClssInfo[i] != null)
					model.setVClssInfo(vClssInfo[i]);
				if (portLmtRepDesc[i] != null)
					model.setPortLmtRepDesc(portLmtRepDesc[i]);
				if (portLmtClssSeq[i] != null)
					model.setPortLmtClssSeq(portLmtClssSeq[i]);
				if (pptProhiFlg[i] != null)
					model.setPptProhiFlg(pptProhiFlg[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPortLimitsUnNoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PortLimitsUnNoVO[]
	 */
	public PortLimitsUnNoVO[] getPortLimitsUnNoVOs(){
		PortLimitsUnNoVO[] vos = (PortLimitsUnNoVO[])models.toArray(new PortLimitsUnNoVO[models.size()]);
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
		this.pptExploFlg = this.pptExploFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckGrpCd = this.imdgPckGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flshPntTemp = this.flshPntTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seqNo = this.seqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pierTpCd = this.pierTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodMaxQty = this.lodMaxQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgCompGrpCd = this.imdgCompGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrDepProhiFlg = this.arrDepProhiFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpCd = this.cntrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portLmtSeq = this.portLmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ldisAplyTgtFlg = this.ldisAplyTgtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSubsRskLblCd = this.imdgSubsRskLblCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portLmtSubPptCd = this.portLmtSubPptCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lmtWgtTpCd = this.lmtWgtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depMaxQty = this.depMaxQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrMaxQty = this.arrMaxQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dchgMaxQty = this.dchgMaxQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vClssInfo = this.vClssInfo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portLmtRepDesc = this.portLmtRepDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portLmtClssSeq = this.portLmtClssSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pptProhiFlg = this.pptProhiFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
