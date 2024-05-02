/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PriRqRtCmdtRoutVO.java
*@FileTitle : PriRqRtCmdtRoutVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.29
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.10.29 이은섭 
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
 * @author 이은섭
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PriRqRtCmdtRoutVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PriRqRtCmdtRoutVO> models = new ArrayList<PriRqRtCmdtRoutVO>();
	
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String destCyDorRtTpCd = null;
	/* Column Info */
	private String prsPreLodQty = null;
	/* Column Info */
	private String orgCyDorRtTpCd = null;
	/* Column Info */
	private String prsUpdDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String prsPreRespbOpbAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String prsRatUtCd = null;
	/* Column Info */
	private String prsEstmRespbOpbAmt = null;
	/* Column Info */
	private String prsEstmLodQty = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String dirCallFlg = null;
	/* Column Info */
	private String cmdtHdrSeq = null;
	/* Column Info */
	private String prsEstmRespbCmpbAmt = null;
	/* Column Info */
	private String srcInfoCd = null;
	/* Column Info */
	private String routSeq = null;
	/* Column Info */
	private String prsPrePfitCmpbAmt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String qttnVerNo = null;
	/* Column Info */
	private String qttnNo = null;
	/* Column Info */
	private String prsEstmPfitCmpbAmt = null;
	/* Column Info */
	private String prsCgoTpCd = null;
	/* Column Info */
	private String prsPreRespbCmpbAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PriRqRtCmdtRoutVO() {}

	public PriRqRtCmdtRoutVO(String ibflag, String pagerows, String qttnNo, String qttnVerNo, String cmdtHdrSeq, String routSeq, String dirCallFlg, String prsPreLodQty, String prsPreRespbCmpbAmt, String prsPrePfitCmpbAmt, String prsPreRespbOpbAmt, String prsEstmLodQty, String prsEstmRespbCmpbAmt, String prsEstmPfitCmpbAmt, String prsEstmRespbOpbAmt, String prsRatUtCd, String prsCgoTpCd, String prsUpdDt, String srcInfoCd, String creUsrId, String creDt, String updUsrId, String updDt, String orgCyDorRtTpCd, String destCyDorRtTpCd) {
		this.creDt = creDt;
		this.destCyDorRtTpCd = destCyDorRtTpCd;
		this.prsPreLodQty = prsPreLodQty;
		this.orgCyDorRtTpCd = orgCyDorRtTpCd;
		this.prsUpdDt = prsUpdDt;
		this.pagerows = pagerows;
		this.prsPreRespbOpbAmt = prsPreRespbOpbAmt;
		this.ibflag = ibflag;
		this.prsRatUtCd = prsRatUtCd;
		this.prsEstmRespbOpbAmt = prsEstmRespbOpbAmt;
		this.prsEstmLodQty = prsEstmLodQty;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.dirCallFlg = dirCallFlg;
		this.cmdtHdrSeq = cmdtHdrSeq;
		this.prsEstmRespbCmpbAmt = prsEstmRespbCmpbAmt;
		this.srcInfoCd = srcInfoCd;
		this.routSeq = routSeq;
		this.prsPrePfitCmpbAmt = prsPrePfitCmpbAmt;
		this.creUsrId = creUsrId;
		this.qttnVerNo = qttnVerNo;
		this.qttnNo = qttnNo;
		this.prsEstmPfitCmpbAmt = prsEstmPfitCmpbAmt;
		this.prsCgoTpCd = prsCgoTpCd;
		this.prsPreRespbCmpbAmt = prsPreRespbCmpbAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("dest_cy_dor_rt_tp_cd", getDestCyDorRtTpCd());
		this.hashColumns.put("prs_pre_lod_qty", getPrsPreLodQty());
		this.hashColumns.put("org_cy_dor_rt_tp_cd", getOrgCyDorRtTpCd());
		this.hashColumns.put("prs_upd_dt", getPrsUpdDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("prs_pre_respb_opb_amt", getPrsPreRespbOpbAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("prs_rat_ut_cd", getPrsRatUtCd());
		this.hashColumns.put("prs_estm_respb_opb_amt", getPrsEstmRespbOpbAmt());
		this.hashColumns.put("prs_estm_lod_qty", getPrsEstmLodQty());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("dir_call_flg", getDirCallFlg());
		this.hashColumns.put("cmdt_hdr_seq", getCmdtHdrSeq());
		this.hashColumns.put("prs_estm_respb_cmpb_amt", getPrsEstmRespbCmpbAmt());
		this.hashColumns.put("src_info_cd", getSrcInfoCd());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("prs_pre_pfit_cmpb_amt", getPrsPrePfitCmpbAmt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("qttn_ver_no", getQttnVerNo());
		this.hashColumns.put("qttn_no", getQttnNo());
		this.hashColumns.put("prs_estm_pfit_cmpb_amt", getPrsEstmPfitCmpbAmt());
		this.hashColumns.put("prs_cgo_tp_cd", getPrsCgoTpCd());
		this.hashColumns.put("prs_pre_respb_cmpb_amt", getPrsPreRespbCmpbAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("dest_cy_dor_rt_tp_cd", "destCyDorRtTpCd");
		this.hashFields.put("prs_pre_lod_qty", "prsPreLodQty");
		this.hashFields.put("org_cy_dor_rt_tp_cd", "orgCyDorRtTpCd");
		this.hashFields.put("prs_upd_dt", "prsUpdDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("prs_pre_respb_opb_amt", "prsPreRespbOpbAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("prs_rat_ut_cd", "prsRatUtCd");
		this.hashFields.put("prs_estm_respb_opb_amt", "prsEstmRespbOpbAmt");
		this.hashFields.put("prs_estm_lod_qty", "prsEstmLodQty");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("dir_call_flg", "dirCallFlg");
		this.hashFields.put("cmdt_hdr_seq", "cmdtHdrSeq");
		this.hashFields.put("prs_estm_respb_cmpb_amt", "prsEstmRespbCmpbAmt");
		this.hashFields.put("src_info_cd", "srcInfoCd");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("prs_pre_pfit_cmpb_amt", "prsPrePfitCmpbAmt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("qttn_ver_no", "qttnVerNo");
		this.hashFields.put("qttn_no", "qttnNo");
		this.hashFields.put("prs_estm_pfit_cmpb_amt", "prsEstmPfitCmpbAmt");
		this.hashFields.put("prs_cgo_tp_cd", "prsCgoTpCd");
		this.hashFields.put("prs_pre_respb_cmpb_amt", "prsPreRespbCmpbAmt");
		return this.hashFields;
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
	 * @return destCyDorRtTpCd
	 */
	public String getDestCyDorRtTpCd() {
		return this.destCyDorRtTpCd;
	}
	
	/**
	 * Column Info
	 * @return prsPreLodQty
	 */
	public String getPrsPreLodQty() {
		return this.prsPreLodQty;
	}
	
	/**
	 * Column Info
	 * @return orgCyDorRtTpCd
	 */
	public String getOrgCyDorRtTpCd() {
		return this.orgCyDorRtTpCd;
	}
	
	/**
	 * Column Info
	 * @return prsUpdDt
	 */
	public String getPrsUpdDt() {
		return this.prsUpdDt;
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
	 * @return prsPreRespbOpbAmt
	 */
	public String getPrsPreRespbOpbAmt() {
		return this.prsPreRespbOpbAmt;
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
	 * @return prsRatUtCd
	 */
	public String getPrsRatUtCd() {
		return this.prsRatUtCd;
	}
	
	/**
	 * Column Info
	 * @return prsEstmRespbOpbAmt
	 */
	public String getPrsEstmRespbOpbAmt() {
		return this.prsEstmRespbOpbAmt;
	}
	
	/**
	 * Column Info
	 * @return prsEstmLodQty
	 */
	public String getPrsEstmLodQty() {
		return this.prsEstmLodQty;
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
	 * @return dirCallFlg
	 */
	public String getDirCallFlg() {
		return this.dirCallFlg;
	}
	
	/**
	 * Column Info
	 * @return cmdtHdrSeq
	 */
	public String getCmdtHdrSeq() {
		return this.cmdtHdrSeq;
	}
	
	/**
	 * Column Info
	 * @return prsEstmRespbCmpbAmt
	 */
	public String getPrsEstmRespbCmpbAmt() {
		return this.prsEstmRespbCmpbAmt;
	}
	
	/**
	 * Column Info
	 * @return srcInfoCd
	 */
	public String getSrcInfoCd() {
		return this.srcInfoCd;
	}
	
	/**
	 * Column Info
	 * @return routSeq
	 */
	public String getRoutSeq() {
		return this.routSeq;
	}
	
	/**
	 * Column Info
	 * @return prsPrePfitCmpbAmt
	 */
	public String getPrsPrePfitCmpbAmt() {
		return this.prsPrePfitCmpbAmt;
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
	 * @return qttnVerNo
	 */
	public String getQttnVerNo() {
		return this.qttnVerNo;
	}
	
	/**
	 * Column Info
	 * @return qttnNo
	 */
	public String getQttnNo() {
		return this.qttnNo;
	}
	
	/**
	 * Column Info
	 * @return prsEstmPfitCmpbAmt
	 */
	public String getPrsEstmPfitCmpbAmt() {
		return this.prsEstmPfitCmpbAmt;
	}
	
	/**
	 * Column Info
	 * @return prsCgoTpCd
	 */
	public String getPrsCgoTpCd() {
		return this.prsCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return prsPreRespbCmpbAmt
	 */
	public String getPrsPreRespbCmpbAmt() {
		return this.prsPreRespbCmpbAmt;
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
	 * @param destCyDorRtTpCd
	 */
	public void setDestCyDorRtTpCd(String destCyDorRtTpCd) {
		this.destCyDorRtTpCd = destCyDorRtTpCd;
	}
	
	/**
	 * Column Info
	 * @param prsPreLodQty
	 */
	public void setPrsPreLodQty(String prsPreLodQty) {
		this.prsPreLodQty = prsPreLodQty;
	}
	
	/**
	 * Column Info
	 * @param orgCyDorRtTpCd
	 */
	public void setOrgCyDorRtTpCd(String orgCyDorRtTpCd) {
		this.orgCyDorRtTpCd = orgCyDorRtTpCd;
	}
	
	/**
	 * Column Info
	 * @param prsUpdDt
	 */
	public void setPrsUpdDt(String prsUpdDt) {
		this.prsUpdDt = prsUpdDt;
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
	 * @param prsPreRespbOpbAmt
	 */
	public void setPrsPreRespbOpbAmt(String prsPreRespbOpbAmt) {
		this.prsPreRespbOpbAmt = prsPreRespbOpbAmt;
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
	 * @param prsRatUtCd
	 */
	public void setPrsRatUtCd(String prsRatUtCd) {
		this.prsRatUtCd = prsRatUtCd;
	}
	
	/**
	 * Column Info
	 * @param prsEstmRespbOpbAmt
	 */
	public void setPrsEstmRespbOpbAmt(String prsEstmRespbOpbAmt) {
		this.prsEstmRespbOpbAmt = prsEstmRespbOpbAmt;
	}
	
	/**
	 * Column Info
	 * @param prsEstmLodQty
	 */
	public void setPrsEstmLodQty(String prsEstmLodQty) {
		this.prsEstmLodQty = prsEstmLodQty;
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
	 * @param dirCallFlg
	 */
	public void setDirCallFlg(String dirCallFlg) {
		this.dirCallFlg = dirCallFlg;
	}
	
	/**
	 * Column Info
	 * @param cmdtHdrSeq
	 */
	public void setCmdtHdrSeq(String cmdtHdrSeq) {
		this.cmdtHdrSeq = cmdtHdrSeq;
	}
	
	/**
	 * Column Info
	 * @param prsEstmRespbCmpbAmt
	 */
	public void setPrsEstmRespbCmpbAmt(String prsEstmRespbCmpbAmt) {
		this.prsEstmRespbCmpbAmt = prsEstmRespbCmpbAmt;
	}
	
	/**
	 * Column Info
	 * @param srcInfoCd
	 */
	public void setSrcInfoCd(String srcInfoCd) {
		this.srcInfoCd = srcInfoCd;
	}
	
	/**
	 * Column Info
	 * @param routSeq
	 */
	public void setRoutSeq(String routSeq) {
		this.routSeq = routSeq;
	}
	
	/**
	 * Column Info
	 * @param prsPrePfitCmpbAmt
	 */
	public void setPrsPrePfitCmpbAmt(String prsPrePfitCmpbAmt) {
		this.prsPrePfitCmpbAmt = prsPrePfitCmpbAmt;
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
	 * @param qttnVerNo
	 */
	public void setQttnVerNo(String qttnVerNo) {
		this.qttnVerNo = qttnVerNo;
	}
	
	/**
	 * Column Info
	 * @param qttnNo
	 */
	public void setQttnNo(String qttnNo) {
		this.qttnNo = qttnNo;
	}
	
	/**
	 * Column Info
	 * @param prsEstmPfitCmpbAmt
	 */
	public void setPrsEstmPfitCmpbAmt(String prsEstmPfitCmpbAmt) {
		this.prsEstmPfitCmpbAmt = prsEstmPfitCmpbAmt;
	}
	
	/**
	 * Column Info
	 * @param prsCgoTpCd
	 */
	public void setPrsCgoTpCd(String prsCgoTpCd) {
		this.prsCgoTpCd = prsCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param prsPreRespbCmpbAmt
	 */
	public void setPrsPreRespbCmpbAmt(String prsPreRespbCmpbAmt) {
		this.prsPreRespbCmpbAmt = prsPreRespbCmpbAmt;
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
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setDestCyDorRtTpCd(JSPUtil.getParameter(request, prefix + "dest_cy_dor_rt_tp_cd", ""));
		setPrsPreLodQty(JSPUtil.getParameter(request, prefix + "prs_pre_lod_qty", ""));
		setOrgCyDorRtTpCd(JSPUtil.getParameter(request, prefix + "org_cy_dor_rt_tp_cd", ""));
		setPrsUpdDt(JSPUtil.getParameter(request, prefix + "prs_upd_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPrsPreRespbOpbAmt(JSPUtil.getParameter(request, prefix + "prs_pre_respb_opb_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPrsRatUtCd(JSPUtil.getParameter(request, prefix + "prs_rat_ut_cd", ""));
		setPrsEstmRespbOpbAmt(JSPUtil.getParameter(request, prefix + "prs_estm_respb_opb_amt", ""));
		setPrsEstmLodQty(JSPUtil.getParameter(request, prefix + "prs_estm_lod_qty", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setDirCallFlg(JSPUtil.getParameter(request, prefix + "dir_call_flg", ""));
		setCmdtHdrSeq(JSPUtil.getParameter(request, prefix + "cmdt_hdr_seq", ""));
		setPrsEstmRespbCmpbAmt(JSPUtil.getParameter(request, prefix + "prs_estm_respb_cmpb_amt", ""));
		setSrcInfoCd(JSPUtil.getParameter(request, prefix + "src_info_cd", ""));
		setRoutSeq(JSPUtil.getParameter(request, prefix + "rout_seq", ""));
		setPrsPrePfitCmpbAmt(JSPUtil.getParameter(request, prefix + "prs_pre_pfit_cmpb_amt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setQttnVerNo(JSPUtil.getParameter(request, prefix + "qttn_ver_no", ""));
		setQttnNo(JSPUtil.getParameter(request, prefix + "qttn_no", ""));
		setPrsEstmPfitCmpbAmt(JSPUtil.getParameter(request, prefix + "prs_estm_pfit_cmpb_amt", ""));
		setPrsCgoTpCd(JSPUtil.getParameter(request, prefix + "prs_cgo_tp_cd", ""));
		setPrsPreRespbCmpbAmt(JSPUtil.getParameter(request, prefix + "prs_pre_respb_cmpb_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PriRqRtCmdtRoutVO[]
	 */
	public PriRqRtCmdtRoutVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PriRqRtCmdtRoutVO[]
	 */
	public PriRqRtCmdtRoutVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PriRqRtCmdtRoutVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] destCyDorRtTpCd = (JSPUtil.getParameter(request, prefix	+ "dest_cy_dor_rt_tp_cd", length));
			String[] prsPreLodQty = (JSPUtil.getParameter(request, prefix	+ "prs_pre_lod_qty", length));
			String[] orgCyDorRtTpCd = (JSPUtil.getParameter(request, prefix	+ "org_cy_dor_rt_tp_cd", length));
			String[] prsUpdDt = (JSPUtil.getParameter(request, prefix	+ "prs_upd_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] prsPreRespbOpbAmt = (JSPUtil.getParameter(request, prefix	+ "prs_pre_respb_opb_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] prsRatUtCd = (JSPUtil.getParameter(request, prefix	+ "prs_rat_ut_cd", length));
			String[] prsEstmRespbOpbAmt = (JSPUtil.getParameter(request, prefix	+ "prs_estm_respb_opb_amt", length));
			String[] prsEstmLodQty = (JSPUtil.getParameter(request, prefix	+ "prs_estm_lod_qty", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] dirCallFlg = (JSPUtil.getParameter(request, prefix	+ "dir_call_flg", length));
			String[] cmdtHdrSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_hdr_seq", length));
			String[] prsEstmRespbCmpbAmt = (JSPUtil.getParameter(request, prefix	+ "prs_estm_respb_cmpb_amt", length));
			String[] srcInfoCd = (JSPUtil.getParameter(request, prefix	+ "src_info_cd", length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix	+ "rout_seq", length));
			String[] prsPrePfitCmpbAmt = (JSPUtil.getParameter(request, prefix	+ "prs_pre_pfit_cmpb_amt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] qttnVerNo = (JSPUtil.getParameter(request, prefix	+ "qttn_ver_no", length));
			String[] qttnNo = (JSPUtil.getParameter(request, prefix	+ "qttn_no", length));
			String[] prsEstmPfitCmpbAmt = (JSPUtil.getParameter(request, prefix	+ "prs_estm_pfit_cmpb_amt", length));
			String[] prsCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "prs_cgo_tp_cd", length));
			String[] prsPreRespbCmpbAmt = (JSPUtil.getParameter(request, prefix	+ "prs_pre_respb_cmpb_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new PriRqRtCmdtRoutVO();
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (destCyDorRtTpCd[i] != null)
					model.setDestCyDorRtTpCd(destCyDorRtTpCd[i]);
				if (prsPreLodQty[i] != null)
					model.setPrsPreLodQty(prsPreLodQty[i]);
				if (orgCyDorRtTpCd[i] != null)
					model.setOrgCyDorRtTpCd(orgCyDorRtTpCd[i]);
				if (prsUpdDt[i] != null)
					model.setPrsUpdDt(prsUpdDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (prsPreRespbOpbAmt[i] != null)
					model.setPrsPreRespbOpbAmt(prsPreRespbOpbAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (prsRatUtCd[i] != null)
					model.setPrsRatUtCd(prsRatUtCd[i]);
				if (prsEstmRespbOpbAmt[i] != null)
					model.setPrsEstmRespbOpbAmt(prsEstmRespbOpbAmt[i]);
				if (prsEstmLodQty[i] != null)
					model.setPrsEstmLodQty(prsEstmLodQty[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (dirCallFlg[i] != null)
					model.setDirCallFlg(dirCallFlg[i]);
				if (cmdtHdrSeq[i] != null)
					model.setCmdtHdrSeq(cmdtHdrSeq[i]);
				if (prsEstmRespbCmpbAmt[i] != null)
					model.setPrsEstmRespbCmpbAmt(prsEstmRespbCmpbAmt[i]);
				if (srcInfoCd[i] != null)
					model.setSrcInfoCd(srcInfoCd[i]);
				if (routSeq[i] != null)
					model.setRoutSeq(routSeq[i]);
				if (prsPrePfitCmpbAmt[i] != null)
					model.setPrsPrePfitCmpbAmt(prsPrePfitCmpbAmt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (qttnVerNo[i] != null)
					model.setQttnVerNo(qttnVerNo[i]);
				if (qttnNo[i] != null)
					model.setQttnNo(qttnNo[i]);
				if (prsEstmPfitCmpbAmt[i] != null)
					model.setPrsEstmPfitCmpbAmt(prsEstmPfitCmpbAmt[i]);
				if (prsCgoTpCd[i] != null)
					model.setPrsCgoTpCd(prsCgoTpCd[i]);
				if (prsPreRespbCmpbAmt[i] != null)
					model.setPrsPreRespbCmpbAmt(prsPreRespbCmpbAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPriRqRtCmdtRoutVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PriRqRtCmdtRoutVO[]
	 */
	public PriRqRtCmdtRoutVO[] getPriRqRtCmdtRoutVOs(){
		PriRqRtCmdtRoutVO[] vos = (PriRqRtCmdtRoutVO[])models.toArray(new PriRqRtCmdtRoutVO[models.size()]);
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
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destCyDorRtTpCd = this.destCyDorRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsPreLodQty = this.prsPreLodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgCyDorRtTpCd = this.orgCyDorRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsUpdDt = this.prsUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsPreRespbOpbAmt = this.prsPreRespbOpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsRatUtCd = this.prsRatUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsEstmRespbOpbAmt = this.prsEstmRespbOpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsEstmLodQty = this.prsEstmLodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCallFlg = this.dirCallFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHdrSeq = this.cmdtHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsEstmRespbCmpbAmt = this.prsEstmRespbCmpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcInfoCd = this.srcInfoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq = this.routSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsPrePfitCmpbAmt = this.prsPrePfitCmpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qttnVerNo = this.qttnVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qttnNo = this.qttnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsEstmPfitCmpbAmt = this.prsEstmPfitCmpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsCgoTpCd = this.prsCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsPreRespbCmpbAmt = this.prsPreRespbCmpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
