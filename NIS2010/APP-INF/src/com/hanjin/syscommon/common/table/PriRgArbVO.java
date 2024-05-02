/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : PriRgArbVO.java
*@FileTitle : PriRgArbVO
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.09
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.08.09 송민석 
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

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
 * @author 송민석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PriRgArbVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PriRgArbVO> models = new ArrayList<PriRgArbVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String maxCgoWgt = null;
	/* Column Info */
	private String optmTrspModFlg = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String orgDestTpCd = null;
	/* Column Info */
	private String bsePortDefCd = null;
	/* Column Info */
	private String routPntLocDefCd = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String rcvDeTermCd = null;
	/* Column Info */
	private String ficGlineUpdDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String glineSeq = null;
	/* Column Info */
	private String routPntLocTpCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String prcTrspModCd = null;
	/* Column Info */
	private String minCgoWgt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String prcCgoTpCd = null;
	/* Column Info */
	private String ficGlineRtAmt = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String ficRtUseStsCd = null;
	/* Column Info */
	private String arbSeq = null;
	/* Column Info */
	private String frtRtAmt = null;
	/* Column Info */
	private String bsePortTpCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String ficRoutCmbTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PriRgArbVO() {}

	public PriRgArbVO(String ibflag, String pagerows, String svcScpCd, String glineSeq, String orgDestTpCd, String arbSeq, String bsePortTpCd, String bsePortDefCd, String routPntLocTpCd, String routPntLocDefCd, String ratUtCd, String prcCgoTpCd, String prcTrspModCd, String rcvDeTermCd, String minCgoWgt, String maxCgoWgt, String currCd, String frtRtAmt, String creUsrId, String creDt, String updUsrId, String updDt, String ficGlineRtAmt, String ficGlineUpdDt, String optmTrspModFlg, String ficRoutCmbTpCd, String ficRtUseStsCd) {
		this.ibflag = ibflag;
		this.maxCgoWgt = maxCgoWgt;
		this.optmTrspModFlg = optmTrspModFlg;
		this.updUsrId = updUsrId;
		this.creUsrId = creUsrId;
		this.orgDestTpCd = orgDestTpCd;
		this.bsePortDefCd = bsePortDefCd;
		this.routPntLocDefCd = routPntLocDefCd;
		this.svcScpCd = svcScpCd;
		this.rcvDeTermCd = rcvDeTermCd;
		this.ficGlineUpdDt = ficGlineUpdDt;
		this.pagerows = pagerows;
		this.glineSeq = glineSeq;
		this.routPntLocTpCd = routPntLocTpCd;
		this.currCd = currCd;
		this.prcTrspModCd = prcTrspModCd;
		this.minCgoWgt = minCgoWgt;
		this.creDt = creDt;
		this.prcCgoTpCd = prcCgoTpCd;
		this.ficGlineRtAmt = ficGlineRtAmt;
		this.ratUtCd = ratUtCd;
		this.ficRtUseStsCd = ficRtUseStsCd;
		this.arbSeq = arbSeq;
		this.frtRtAmt = frtRtAmt;
		this.bsePortTpCd = bsePortTpCd;
		this.updDt = updDt;
		this.ficRoutCmbTpCd = ficRoutCmbTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("max_cgo_wgt", getMaxCgoWgt());
		this.hashColumns.put("optm_trsp_mod_flg", getOptmTrspModFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("org_dest_tp_cd", getOrgDestTpCd());
		this.hashColumns.put("bse_port_def_cd", getBsePortDefCd());
		this.hashColumns.put("rout_pnt_loc_def_cd", getRoutPntLocDefCd());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("rcv_de_term_cd", getRcvDeTermCd());
		this.hashColumns.put("fic_gline_upd_dt", getFicGlineUpdDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("gline_seq", getGlineSeq());
		this.hashColumns.put("rout_pnt_loc_tp_cd", getRoutPntLocTpCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("prc_trsp_mod_cd", getPrcTrspModCd());
		this.hashColumns.put("min_cgo_wgt", getMinCgoWgt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("prc_cgo_tp_cd", getPrcCgoTpCd());
		this.hashColumns.put("fic_gline_rt_amt", getFicGlineRtAmt());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("fic_rt_use_sts_cd", getFicRtUseStsCd());
		this.hashColumns.put("arb_seq", getArbSeq());
		this.hashColumns.put("frt_rt_amt", getFrtRtAmt());
		this.hashColumns.put("bse_port_tp_cd", getBsePortTpCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("fic_rout_cmb_tp_cd", getFicRoutCmbTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("max_cgo_wgt", "maxCgoWgt");
		this.hashFields.put("optm_trsp_mod_flg", "optmTrspModFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("org_dest_tp_cd", "orgDestTpCd");
		this.hashFields.put("bse_port_def_cd", "bsePortDefCd");
		this.hashFields.put("rout_pnt_loc_def_cd", "routPntLocDefCd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("rcv_de_term_cd", "rcvDeTermCd");
		this.hashFields.put("fic_gline_upd_dt", "ficGlineUpdDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("gline_seq", "glineSeq");
		this.hashFields.put("rout_pnt_loc_tp_cd", "routPntLocTpCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("prc_trsp_mod_cd", "prcTrspModCd");
		this.hashFields.put("min_cgo_wgt", "minCgoWgt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("prc_cgo_tp_cd", "prcCgoTpCd");
		this.hashFields.put("fic_gline_rt_amt", "ficGlineRtAmt");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("fic_rt_use_sts_cd", "ficRtUseStsCd");
		this.hashFields.put("arb_seq", "arbSeq");
		this.hashFields.put("frt_rt_amt", "frtRtAmt");
		this.hashFields.put("bse_port_tp_cd", "bsePortTpCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("fic_rout_cmb_tp_cd", "ficRoutCmbTpCd");
		return this.hashFields;
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
	 * @return maxCgoWgt
	 */
	public String getMaxCgoWgt() {
		return this.maxCgoWgt;
	}
	
	/**
	 * Column Info
	 * @return optmTrspModFlg
	 */
	public String getOptmTrspModFlg() {
		return this.optmTrspModFlg;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return orgDestTpCd
	 */
	public String getOrgDestTpCd() {
		return this.orgDestTpCd;
	}
	
	/**
	 * Column Info
	 * @return bsePortDefCd
	 */
	public String getBsePortDefCd() {
		return this.bsePortDefCd;
	}
	
	/**
	 * Column Info
	 * @return routPntLocDefCd
	 */
	public String getRoutPntLocDefCd() {
		return this.routPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return rcvDeTermCd
	 */
	public String getRcvDeTermCd() {
		return this.rcvDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return ficGlineUpdDt
	 */
	public String getFicGlineUpdDt() {
		return this.ficGlineUpdDt;
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
	 * @return glineSeq
	 */
	public String getGlineSeq() {
		return this.glineSeq;
	}
	
	/**
	 * Column Info
	 * @return routPntLocTpCd
	 */
	public String getRoutPntLocTpCd() {
		return this.routPntLocTpCd;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return prcTrspModCd
	 */
	public String getPrcTrspModCd() {
		return this.prcTrspModCd;
	}
	
	/**
	 * Column Info
	 * @return minCgoWgt
	 */
	public String getMinCgoWgt() {
		return this.minCgoWgt;
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
	 * @return prcCgoTpCd
	 */
	public String getPrcCgoTpCd() {
		return this.prcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return ficGlineRtAmt
	 */
	public String getFicGlineRtAmt() {
		return this.ficGlineRtAmt;
	}
	
	/**
	 * Column Info
	 * @return ratUtCd
	 */
	public String getRatUtCd() {
		return this.ratUtCd;
	}
	
	/**
	 * Column Info
	 * @return ficRtUseStsCd
	 */
	public String getFicRtUseStsCd() {
		return this.ficRtUseStsCd;
	}
	
	/**
	 * Column Info
	 * @return arbSeq
	 */
	public String getArbSeq() {
		return this.arbSeq;
	}
	
	/**
	 * Column Info
	 * @return frtRtAmt
	 */
	public String getFrtRtAmt() {
		return this.frtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return bsePortTpCd
	 */
	public String getBsePortTpCd() {
		return this.bsePortTpCd;
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
	 * @return ficRoutCmbTpCd
	 */
	public String getFicRoutCmbTpCd() {
		return this.ficRoutCmbTpCd;
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
	 * @param maxCgoWgt
	 */
	public void setMaxCgoWgt(String maxCgoWgt) {
		this.maxCgoWgt = maxCgoWgt;
	}
	
	/**
	 * Column Info
	 * @param optmTrspModFlg
	 */
	public void setOptmTrspModFlg(String optmTrspModFlg) {
		this.optmTrspModFlg = optmTrspModFlg;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param orgDestTpCd
	 */
	public void setOrgDestTpCd(String orgDestTpCd) {
		this.orgDestTpCd = orgDestTpCd;
	}
	
	/**
	 * Column Info
	 * @param bsePortDefCd
	 */
	public void setBsePortDefCd(String bsePortDefCd) {
		this.bsePortDefCd = bsePortDefCd;
	}
	
	/**
	 * Column Info
	 * @param routPntLocDefCd
	 */
	public void setRoutPntLocDefCd(String routPntLocDefCd) {
		this.routPntLocDefCd = routPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param rcvDeTermCd
	 */
	public void setRcvDeTermCd(String rcvDeTermCd) {
		this.rcvDeTermCd = rcvDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param ficGlineUpdDt
	 */
	public void setFicGlineUpdDt(String ficGlineUpdDt) {
		this.ficGlineUpdDt = ficGlineUpdDt;
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
	 * @param glineSeq
	 */
	public void setGlineSeq(String glineSeq) {
		this.glineSeq = glineSeq;
	}
	
	/**
	 * Column Info
	 * @param routPntLocTpCd
	 */
	public void setRoutPntLocTpCd(String routPntLocTpCd) {
		this.routPntLocTpCd = routPntLocTpCd;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param prcTrspModCd
	 */
	public void setPrcTrspModCd(String prcTrspModCd) {
		this.prcTrspModCd = prcTrspModCd;
	}
	
	/**
	 * Column Info
	 * @param minCgoWgt
	 */
	public void setMinCgoWgt(String minCgoWgt) {
		this.minCgoWgt = minCgoWgt;
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
	 * @param prcCgoTpCd
	 */
	public void setPrcCgoTpCd(String prcCgoTpCd) {
		this.prcCgoTpCd = prcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param ficGlineRtAmt
	 */
	public void setFicGlineRtAmt(String ficGlineRtAmt) {
		this.ficGlineRtAmt = ficGlineRtAmt;
	}
	
	/**
	 * Column Info
	 * @param ratUtCd
	 */
	public void setRatUtCd(String ratUtCd) {
		this.ratUtCd = ratUtCd;
	}
	
	/**
	 * Column Info
	 * @param ficRtUseStsCd
	 */
	public void setFicRtUseStsCd(String ficRtUseStsCd) {
		this.ficRtUseStsCd = ficRtUseStsCd;
	}
	
	/**
	 * Column Info
	 * @param arbSeq
	 */
	public void setArbSeq(String arbSeq) {
		this.arbSeq = arbSeq;
	}
	
	/**
	 * Column Info
	 * @param frtRtAmt
	 */
	public void setFrtRtAmt(String frtRtAmt) {
		this.frtRtAmt = frtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param bsePortTpCd
	 */
	public void setBsePortTpCd(String bsePortTpCd) {
		this.bsePortTpCd = bsePortTpCd;
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
	 * @param ficRoutCmbTpCd
	 */
	public void setFicRoutCmbTpCd(String ficRoutCmbTpCd) {
		this.ficRoutCmbTpCd = ficRoutCmbTpCd;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMaxCgoWgt(JSPUtil.getParameter(request, prefix + "max_cgo_wgt", ""));
		setOptmTrspModFlg(JSPUtil.getParameter(request, prefix + "optm_trsp_mod_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setOrgDestTpCd(JSPUtil.getParameter(request, prefix + "org_dest_tp_cd", ""));
		setBsePortDefCd(JSPUtil.getParameter(request, prefix + "bse_port_def_cd", ""));
		setRoutPntLocDefCd(JSPUtil.getParameter(request, prefix + "rout_pnt_loc_def_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setRcvDeTermCd(JSPUtil.getParameter(request, prefix + "rcv_de_term_cd", ""));
		setFicGlineUpdDt(JSPUtil.getParameter(request, prefix + "fic_gline_upd_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setGlineSeq(JSPUtil.getParameter(request, prefix + "gline_seq", ""));
		setRoutPntLocTpCd(JSPUtil.getParameter(request, prefix + "rout_pnt_loc_tp_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setPrcTrspModCd(JSPUtil.getParameter(request, prefix + "prc_trsp_mod_cd", ""));
		setMinCgoWgt(JSPUtil.getParameter(request, prefix + "min_cgo_wgt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPrcCgoTpCd(JSPUtil.getParameter(request, prefix + "prc_cgo_tp_cd", ""));
		setFicGlineRtAmt(JSPUtil.getParameter(request, prefix + "fic_gline_rt_amt", ""));
		setRatUtCd(JSPUtil.getParameter(request, prefix + "rat_ut_cd", ""));
		setFicRtUseStsCd(JSPUtil.getParameter(request, prefix + "fic_rt_use_sts_cd", ""));
		setArbSeq(JSPUtil.getParameter(request, prefix + "arb_seq", ""));
		setFrtRtAmt(JSPUtil.getParameter(request, prefix + "frt_rt_amt", ""));
		setBsePortTpCd(JSPUtil.getParameter(request, prefix + "bse_port_tp_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setFicRoutCmbTpCd(JSPUtil.getParameter(request, prefix + "fic_rout_cmb_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PriRgArbVO[]
	 */
	public PriRgArbVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PriRgArbVO[]
	 */
	public PriRgArbVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PriRgArbVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] maxCgoWgt = (JSPUtil.getParameter(request, prefix	+ "max_cgo_wgt", length));
			String[] optmTrspModFlg = (JSPUtil.getParameter(request, prefix	+ "optm_trsp_mod_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] orgDestTpCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_tp_cd", length));
			String[] bsePortDefCd = (JSPUtil.getParameter(request, prefix	+ "bse_port_def_cd", length));
			String[] routPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "rout_pnt_loc_def_cd", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] rcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_de_term_cd", length));
			String[] ficGlineUpdDt = (JSPUtil.getParameter(request, prefix	+ "fic_gline_upd_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] glineSeq = (JSPUtil.getParameter(request, prefix	+ "gline_seq", length));
			String[] routPntLocTpCd = (JSPUtil.getParameter(request, prefix	+ "rout_pnt_loc_tp_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] prcTrspModCd = (JSPUtil.getParameter(request, prefix	+ "prc_trsp_mod_cd", length));
			String[] minCgoWgt = (JSPUtil.getParameter(request, prefix	+ "min_cgo_wgt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] prcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_cgo_tp_cd", length));
			String[] ficGlineRtAmt = (JSPUtil.getParameter(request, prefix	+ "fic_gline_rt_amt", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] ficRtUseStsCd = (JSPUtil.getParameter(request, prefix	+ "fic_rt_use_sts_cd", length));
			String[] arbSeq = (JSPUtil.getParameter(request, prefix	+ "arb_seq", length));
			String[] frtRtAmt = (JSPUtil.getParameter(request, prefix	+ "frt_rt_amt", length));
			String[] bsePortTpCd = (JSPUtil.getParameter(request, prefix	+ "bse_port_tp_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] ficRoutCmbTpCd = (JSPUtil.getParameter(request, prefix	+ "fic_rout_cmb_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new PriRgArbVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (maxCgoWgt[i] != null)
					model.setMaxCgoWgt(maxCgoWgt[i]);
				if (optmTrspModFlg[i] != null)
					model.setOptmTrspModFlg(optmTrspModFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (orgDestTpCd[i] != null)
					model.setOrgDestTpCd(orgDestTpCd[i]);
				if (bsePortDefCd[i] != null)
					model.setBsePortDefCd(bsePortDefCd[i]);
				if (routPntLocDefCd[i] != null)
					model.setRoutPntLocDefCd(routPntLocDefCd[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (rcvDeTermCd[i] != null)
					model.setRcvDeTermCd(rcvDeTermCd[i]);
				if (ficGlineUpdDt[i] != null)
					model.setFicGlineUpdDt(ficGlineUpdDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (glineSeq[i] != null)
					model.setGlineSeq(glineSeq[i]);
				if (routPntLocTpCd[i] != null)
					model.setRoutPntLocTpCd(routPntLocTpCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (prcTrspModCd[i] != null)
					model.setPrcTrspModCd(prcTrspModCd[i]);
				if (minCgoWgt[i] != null)
					model.setMinCgoWgt(minCgoWgt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (prcCgoTpCd[i] != null)
					model.setPrcCgoTpCd(prcCgoTpCd[i]);
				if (ficGlineRtAmt[i] != null)
					model.setFicGlineRtAmt(ficGlineRtAmt[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (ficRtUseStsCd[i] != null)
					model.setFicRtUseStsCd(ficRtUseStsCd[i]);
				if (arbSeq[i] != null)
					model.setArbSeq(arbSeq[i]);
				if (frtRtAmt[i] != null)
					model.setFrtRtAmt(frtRtAmt[i]);
				if (bsePortTpCd[i] != null)
					model.setBsePortTpCd(bsePortTpCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ficRoutCmbTpCd[i] != null)
					model.setFicRoutCmbTpCd(ficRoutCmbTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPriRgArbVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PriRgArbVO[]
	 */
	public PriRgArbVO[] getPriRgArbVOs(){
		PriRgArbVO[] vos = (PriRgArbVO[])models.toArray(new PriRgArbVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxCgoWgt = this.maxCgoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optmTrspModFlg = this.optmTrspModFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestTpCd = this.orgDestTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsePortDefCd = this.bsePortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routPntLocDefCd = this.routPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDeTermCd = this.rcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficGlineUpdDt = this.ficGlineUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineSeq = this.glineSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routPntLocTpCd = this.routPntLocTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcTrspModCd = this.prcTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minCgoWgt = this.minCgoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCgoTpCd = this.prcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficGlineRtAmt = this.ficGlineRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficRtUseStsCd = this.ficRtUseStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arbSeq = this.arbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtRtAmt = this.frtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsePortTpCd = this.bsePortTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficRoutCmbTpCd = this.ficRoutCmbTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
