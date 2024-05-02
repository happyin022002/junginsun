/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TrsSOHistoryVO.java
*@FileTitle : TrsSOHistoryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.23
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2012.02.23 김인수 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.common.trscommon.vo;

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
 * @author 김인수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TrsSOHistoryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TrsSOHistoryVO> models = new ArrayList<TrsSOHistoryVO>();
	
	/* Column Info */
	private String uplnSoFlg = null;
	/* Column Info */
	private String invVndrSeq = null;
	/* Column Info */
	private String trspSoSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String soRoutDesc = null;
	/* Column Info */
	private String trspSoOfcCtyCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rplnUmchFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String copPlnRoutDesc = null;
	/* Column Info */
	private String trspSoHisDesc = null;
	/* Column Info */
	private String trspSoStsCd = null;
	/* Column Info */
	private String trspSoEvntCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String copSoStsCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String srcCd = null;
	/* Column Info */
	private String routRplnFlg = null;
	/* Column Info */
	private String woIssNo = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String costActGrpCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String costActGrpSeq = null;
	/* Column Info */
	private String trspHisSeq = null;
	/* Column Info */
	private String hjlFlg = null;
	/* Column Info */
	private String woPrvGrpSeq = null;

	private String rqstSrcSysCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TrsSOHistoryVO() {}

	public TrsSOHistoryVO(String ibflag, String pagerows, String uplnSoFlg, String invVndrSeq, String trspSoSeq, String copNo, String creDt, String soRoutDesc, String trspSoOfcCtyCd, String rplnUmchFlg, String eqNo, String copPlnRoutDesc, String trspSoHisDesc, String trspSoStsCd, String trspSoEvntCd, String updUsrId, String copSoStsCd, String updDt, String routRplnFlg, String woIssNo, String invNo, String costActGrpCd, String creUsrId, String costActGrpSeq, String trspHisSeq, String woPrvGrpSeq, String hjlFlg, String creOfcCd, String srcCd, String rqstSrcSysCd) {
		this.uplnSoFlg = uplnSoFlg;
		this.invVndrSeq = invVndrSeq;
		this.trspSoSeq = trspSoSeq;
		this.creDt = creDt;
		this.copNo = copNo;
		this.soRoutDesc = soRoutDesc;
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
		this.pagerows = pagerows;
		this.rplnUmchFlg = rplnUmchFlg;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.creOfcCd = creOfcCd;
		this.copPlnRoutDesc = copPlnRoutDesc;
		this.trspSoHisDesc = trspSoHisDesc;
		this.trspSoStsCd = trspSoStsCd;
		this.trspSoEvntCd = trspSoEvntCd;
		this.updUsrId = updUsrId;
		this.copSoStsCd = copSoStsCd;
		this.updDt = updDt;
		this.srcCd = srcCd;
		this.routRplnFlg = routRplnFlg;
		this.woIssNo = woIssNo;
		this.invNo = invNo;
		this.costActGrpCd = costActGrpCd;
		this.creUsrId = creUsrId;
		this.costActGrpSeq = costActGrpSeq;
		this.trspHisSeq = trspHisSeq;
		this.hjlFlg = hjlFlg;
		this.woPrvGrpSeq = woPrvGrpSeq;
		this.rqstSrcSysCd = rqstSrcSysCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upln_so_flg", getUplnSoFlg());
		this.hashColumns.put("inv_vndr_seq", getInvVndrSeq());
		this.hashColumns.put("trsp_so_seq", getTrspSoSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("so_rout_desc", getSoRoutDesc());
		this.hashColumns.put("trsp_so_ofc_cty_cd", getTrspSoOfcCtyCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rpln_umch_flg", getRplnUmchFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("cop_pln_rout_desc", getCopPlnRoutDesc());
		this.hashColumns.put("trsp_so_his_desc", getTrspSoHisDesc());
		this.hashColumns.put("trsp_so_sts_cd", getTrspSoStsCd());
		this.hashColumns.put("trsp_so_evnt_cd", getTrspSoEvntCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cop_so_sts_cd", getCopSoStsCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("src_cd", getSrcCd());
		this.hashColumns.put("rout_rpln_flg", getRoutRplnFlg());
		this.hashColumns.put("wo_iss_no", getWoIssNo());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("cost_act_grp_cd", getCostActGrpCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cost_act_grp_seq", getCostActGrpSeq());
		this.hashColumns.put("trsp_his_seq", getTrspHisSeq());
		this.hashColumns.put("hjl_flg", getHjlFlg());
		this.hashColumns.put("wo_prv_grp_seq", getWoPrvGrpSeq());
		this.hashColumns.put("rqst_src_sys_cd", getRqstSrcSysCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upln_so_flg", "uplnSoFlg");
		this.hashFields.put("inv_vndr_seq", "invVndrSeq");
		this.hashFields.put("trsp_so_seq", "trspSoSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("so_rout_desc", "soRoutDesc");
		this.hashFields.put("trsp_so_ofc_cty_cd", "trspSoOfcCtyCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rpln_umch_flg", "rplnUmchFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("cop_pln_rout_desc", "copPlnRoutDesc");
		this.hashFields.put("trsp_so_his_desc", "trspSoHisDesc");
		this.hashFields.put("trsp_so_sts_cd", "trspSoStsCd");
		this.hashFields.put("trsp_so_evnt_cd", "trspSoEvntCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cop_so_sts_cd", "copSoStsCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("src_cd", "srcCd");
		this.hashFields.put("rout_rpln_flg", "routRplnFlg");
		this.hashFields.put("wo_iss_no", "woIssNo");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("cost_act_grp_cd", "costActGrpCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cost_act_grp_seq", "costActGrpSeq");
		this.hashFields.put("trsp_his_seq", "trspHisSeq");
		this.hashFields.put("hjl_flg", "hjlFlg");
		this.hashFields.put("wo_prv_grp_seq", "woPrvGrpSeq");
		this.hashFields.put("rqst_src_sys_cd", "rqstSrcSysCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return uplnSoFlg
	 */
	public String getUplnSoFlg() {
		return this.uplnSoFlg;
	}
	
	/**
	 * Column Info
	 * @return invVndrSeq
	 */
	public String getInvVndrSeq() {
		return this.invVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return trspSoSeq
	 */
	public String getTrspSoSeq() {
		return this.trspSoSeq;
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
	 * @return copNo
	 */
	public String getCopNo() {
		return this.copNo;
	}
	
	/**
	 * Column Info
	 * @return soRoutDesc
	 */
	public String getSoRoutDesc() {
		return this.soRoutDesc;
	}
	
	/**
	 * Column Info
	 * @return trspSoOfcCtyCd
	 */
	public String getTrspSoOfcCtyCd() {
		return this.trspSoOfcCtyCd;
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
	 * @return rplnUmchFlg
	 */
	public String getRplnUmchFlg() {
		return this.rplnUmchFlg;
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
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
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
	 * @return copPlnRoutDesc
	 */
	public String getCopPlnRoutDesc() {
		return this.copPlnRoutDesc;
	}
	
	/**
	 * Column Info
	 * @return trspSoHisDesc
	 */
	public String getTrspSoHisDesc() {
		return this.trspSoHisDesc;
	}
	
	/**
	 * Column Info
	 * @return trspSoStsCd
	 */
	public String getTrspSoStsCd() {
		return this.trspSoStsCd;
	}
	
	/**
	 * Column Info
	 * @return trspSoEvntCd
	 */
	public String getTrspSoEvntCd() {
		return this.trspSoEvntCd;
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
	 * @return copSoStsCd
	 */
	public String getCopSoStsCd() {
		return this.copSoStsCd;
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
	 * @return srcCd
	 */
	public String getSrcCd() {
		return this.srcCd;
	}
	
	/**
	 * Column Info
	 * @return routRplnFlg
	 */
	public String getRoutRplnFlg() {
		return this.routRplnFlg;
	}
	
	/**
	 * Column Info
	 * @return woIssNo
	 */
	public String getWoIssNo() {
		return this.woIssNo;
	}
	
	/**
	 * Column Info
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
	}
	
	/**
	 * Column Info
	 * @return costActGrpCd
	 */
	public String getCostActGrpCd() {
		return this.costActGrpCd;
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
	 * @return costActGrpSeq
	 */
	public String getCostActGrpSeq() {
		return this.costActGrpSeq;
	}
	
	/**
	 * Column Info
	 * @return trspHisSeq
	 */
	public String getTrspHisSeq() {
		return this.trspHisSeq;
	}
	
	/**
	 * Column Info
	 * @return hjlFlg
	 */
	public String getHjlFlg() {
		return this.hjlFlg;
	}
	
	/**
	 * Column Info
	 * @return woPrvGrpSeq
	 */
	public String getWoPrvGrpSeq() {
		return this.woPrvGrpSeq;
	}
	

	/**
	 * Column Info
	 * @param uplnSoFlg
	 */
	public void setUplnSoFlg(String uplnSoFlg) {
		this.uplnSoFlg = uplnSoFlg;
	}
	
	/**
	 * Column Info
	 * @param invVndrSeq
	 */
	public void setInvVndrSeq(String invVndrSeq) {
		this.invVndrSeq = invVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param trspSoSeq
	 */
	public void setTrspSoSeq(String trspSoSeq) {
		this.trspSoSeq = trspSoSeq;
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
	 * @param copNo
	 */
	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}
	
	/**
	 * Column Info
	 * @param soRoutDesc
	 */
	public void setSoRoutDesc(String soRoutDesc) {
		this.soRoutDesc = soRoutDesc;
	}
	
	/**
	 * Column Info
	 * @param trspSoOfcCtyCd
	 */
	public void setTrspSoOfcCtyCd(String trspSoOfcCtyCd) {
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
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
	 * @param rplnUmchFlg
	 */
	public void setRplnUmchFlg(String rplnUmchFlg) {
		this.rplnUmchFlg = rplnUmchFlg;
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
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
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
	 * @param copPlnRoutDesc
	 */
	public void setCopPlnRoutDesc(String copPlnRoutDesc) {
		this.copPlnRoutDesc = copPlnRoutDesc;
	}
	
	/**
	 * Column Info
	 * @param trspSoHisDesc
	 */
	public void setTrspSoHisDesc(String trspSoHisDesc) {
		this.trspSoHisDesc = trspSoHisDesc;
	}
	
	/**
	 * Column Info
	 * @param trspSoStsCd
	 */
	public void setTrspSoStsCd(String trspSoStsCd) {
		this.trspSoStsCd = trspSoStsCd;
	}
	
	/**
	 * Column Info
	 * @param trspSoEvntCd
	 */
	public void setTrspSoEvntCd(String trspSoEvntCd) {
		this.trspSoEvntCd = trspSoEvntCd;
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
	 * @param copSoStsCd
	 */
	public void setCopSoStsCd(String copSoStsCd) {
		this.copSoStsCd = copSoStsCd;
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
	 * @param srcCd
	 */
	public void setSrcCd(String srcCd) {
		this.srcCd = srcCd;
	}
	
	/**
	 * Column Info
	 * @param routRplnFlg
	 */
	public void setRoutRplnFlg(String routRplnFlg) {
		this.routRplnFlg = routRplnFlg;
	}
	
	/**
	 * Column Info
	 * @param woIssNo
	 */
	public void setWoIssNo(String woIssNo) {
		this.woIssNo = woIssNo;
	}
	
	/**
	 * Column Info
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	
	/**
	 * Column Info
	 * @param costActGrpCd
	 */
	public void setCostActGrpCd(String costActGrpCd) {
		this.costActGrpCd = costActGrpCd;
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
	 * @param costActGrpSeq
	 */
	public void setCostActGrpSeq(String costActGrpSeq) {
		this.costActGrpSeq = costActGrpSeq;
	}
	
	/**
	 * Column Info
	 * @param trspHisSeq
	 */
	public void setTrspHisSeq(String trspHisSeq) {
		this.trspHisSeq = trspHisSeq;
	}
	
	/**
	 * Column Info
	 * @param hjlFlg
	 */
	public void setHjlFlg(String hjlFlg) {
		this.hjlFlg = hjlFlg;
	}
	
	/**
	 * Column Info
	 * @param woPrvGrpSeq
	 */
	public void setWoPrvGrpSeq(String woPrvGrpSeq) {
		this.woPrvGrpSeq = woPrvGrpSeq;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * @return the rqstSrcSysCd
	 */
	public String getRqstSrcSysCd() {
		return rqstSrcSysCd;
	}
	
	/**
	 * @param rqstSrcSysCd the rqstSrcSysCd to set
	 */
	public void setRqstSrcSysCd(String rqstSrcSysCd) {
		this.rqstSrcSysCd = rqstSrcSysCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setUplnSoFlg(JSPUtil.getParameter(request, prefix + "upln_so_flg", ""));
		setInvVndrSeq(JSPUtil.getParameter(request, prefix + "inv_vndr_seq", ""));
		setTrspSoSeq(JSPUtil.getParameter(request, prefix + "trsp_so_seq", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCopNo(JSPUtil.getParameter(request, prefix + "cop_no", ""));
		setSoRoutDesc(JSPUtil.getParameter(request, prefix + "so_rout_desc", ""));
		setTrspSoOfcCtyCd(JSPUtil.getParameter(request, prefix + "trsp_so_ofc_cty_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRplnUmchFlg(JSPUtil.getParameter(request, prefix + "rpln_umch_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setCopPlnRoutDesc(JSPUtil.getParameter(request, prefix + "cop_pln_rout_desc", ""));
		setTrspSoHisDesc(JSPUtil.getParameter(request, prefix + "trsp_so_his_desc", ""));
		setTrspSoStsCd(JSPUtil.getParameter(request, prefix + "trsp_so_sts_cd", ""));
		setTrspSoEvntCd(JSPUtil.getParameter(request, prefix + "trsp_so_evnt_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCopSoStsCd(JSPUtil.getParameter(request, prefix + "cop_so_sts_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setSrcCd(JSPUtil.getParameter(request, prefix + "src_cd", ""));
		setRoutRplnFlg(JSPUtil.getParameter(request, prefix + "rout_rpln_flg", ""));
		setWoIssNo(JSPUtil.getParameter(request, prefix + "wo_iss_no", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setCostActGrpCd(JSPUtil.getParameter(request, prefix + "cost_act_grp_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCostActGrpSeq(JSPUtil.getParameter(request, prefix + "cost_act_grp_seq", ""));
		setTrspHisSeq(JSPUtil.getParameter(request, prefix + "trsp_his_seq", ""));
		setHjlFlg(JSPUtil.getParameter(request, prefix + "hjl_flg", ""));
		setWoPrvGrpSeq(JSPUtil.getParameter(request, prefix + "wo_prv_grp_seq", ""));
		setRqstSrcSysCd(JSPUtil.getParameter(request, prefix + "rqst_src_sys_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TrsSOHistoryVO[]
	 */
	public TrsSOHistoryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TrsSOHistoryVO[]
	 */
	public TrsSOHistoryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TrsSOHistoryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] uplnSoFlg = (JSPUtil.getParameter(request, prefix	+ "upln_so_flg", length));
			String[] invVndrSeq = (JSPUtil.getParameter(request, prefix	+ "inv_vndr_seq", length));
			String[] trspSoSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_so_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] soRoutDesc = (JSPUtil.getParameter(request, prefix	+ "so_rout_desc", length));
			String[] trspSoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_ofc_cty_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rplnUmchFlg = (JSPUtil.getParameter(request, prefix	+ "rpln_umch_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] copPlnRoutDesc = (JSPUtil.getParameter(request, prefix	+ "cop_pln_rout_desc", length));
			String[] trspSoHisDesc = (JSPUtil.getParameter(request, prefix	+ "trsp_so_his_desc", length));
			String[] trspSoStsCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_sts_cd", length));
			String[] trspSoEvntCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_evnt_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] copSoStsCd = (JSPUtil.getParameter(request, prefix	+ "cop_so_sts_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] srcCd = (JSPUtil.getParameter(request, prefix	+ "src_cd", length));
			String[] routRplnFlg = (JSPUtil.getParameter(request, prefix	+ "rout_rpln_flg", length));
			String[] woIssNo = (JSPUtil.getParameter(request, prefix	+ "wo_iss_no", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] costActGrpCd = (JSPUtil.getParameter(request, prefix	+ "cost_act_grp_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] costActGrpSeq = (JSPUtil.getParameter(request, prefix	+ "cost_act_grp_seq", length));
			String[] trspHisSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_his_seq", length));
			String[] hjlFlg = (JSPUtil.getParameter(request, prefix	+ "hjl_flg", length));
			String[] woPrvGrpSeq = (JSPUtil.getParameter(request, prefix	+ "wo_prv_grp_seq", length));
			String[] rqstSrcSysCd = (JSPUtil.getParameter(request, prefix	+ "rqst_src_sys_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new TrsSOHistoryVO();
				if (uplnSoFlg[i] != null)
					model.setUplnSoFlg(uplnSoFlg[i]);
				if (invVndrSeq[i] != null)
					model.setInvVndrSeq(invVndrSeq[i]);
				if (trspSoSeq[i] != null)
					model.setTrspSoSeq(trspSoSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (soRoutDesc[i] != null)
					model.setSoRoutDesc(soRoutDesc[i]);
				if (trspSoOfcCtyCd[i] != null)
					model.setTrspSoOfcCtyCd(trspSoOfcCtyCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rplnUmchFlg[i] != null)
					model.setRplnUmchFlg(rplnUmchFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (copPlnRoutDesc[i] != null)
					model.setCopPlnRoutDesc(copPlnRoutDesc[i]);
				if (trspSoHisDesc[i] != null)
					model.setTrspSoHisDesc(trspSoHisDesc[i]);
				if (trspSoStsCd[i] != null)
					model.setTrspSoStsCd(trspSoStsCd[i]);
				if (trspSoEvntCd[i] != null)
					model.setTrspSoEvntCd(trspSoEvntCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (copSoStsCd[i] != null)
					model.setCopSoStsCd(copSoStsCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (srcCd[i] != null)
					model.setSrcCd(srcCd[i]);
				if (routRplnFlg[i] != null)
					model.setRoutRplnFlg(routRplnFlg[i]);
				if (woIssNo[i] != null)
					model.setWoIssNo(woIssNo[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (costActGrpCd[i] != null)
					model.setCostActGrpCd(costActGrpCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (costActGrpSeq[i] != null)
					model.setCostActGrpSeq(costActGrpSeq[i]);
				if (trspHisSeq[i] != null)
					model.setTrspHisSeq(trspHisSeq[i]);
				if (hjlFlg[i] != null)
					model.setHjlFlg(hjlFlg[i]);
				if (woPrvGrpSeq[i] != null)
					model.setWoPrvGrpSeq(woPrvGrpSeq[i]);
				if (rqstSrcSysCd[i] != null)
					model.setRqstSrcSysCd(rqstSrcSysCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTrsSOHistoryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TrsSOHistoryVO[]
	 */
	public TrsSOHistoryVO[] getTrsSOHistoryVOs(){
		TrsSOHistoryVO[] vos = (TrsSOHistoryVO[])models.toArray(new TrsSOHistoryVO[models.size()]);
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
		this.uplnSoFlg = this.uplnSoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invVndrSeq = this.invVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoSeq = this.trspSoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soRoutDesc = this.soRoutDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoOfcCtyCd = this.trspSoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rplnUmchFlg = this.rplnUmchFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copPlnRoutDesc = this.copPlnRoutDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoHisDesc = this.trspSoHisDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoStsCd = this.trspSoStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoEvntCd = this.trspSoEvntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copSoStsCd = this.copSoStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcCd = this.srcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routRplnFlg = this.routRplnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woIssNo = this.woIssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costActGrpCd = this.costActGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costActGrpSeq = this.costActGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspHisSeq = this.trspHisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjlFlg = this.hjlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woPrvGrpSeq = this.woPrvGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstSrcSysCd = this.rqstSrcSysCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
