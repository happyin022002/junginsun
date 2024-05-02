/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchNodLnkCostCodeVO.java
*@FileTitle : SearchNodLnkCostCodeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.27
*@LastModifier : 임옥영
*@LastVersion : 1.0
* 2009.08.27 임옥영 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 임옥영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class NodLnkCostCodeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<NodLnkCostCodeVO> models = new ArrayList<NodLnkCostCodeVO>();
	
	/* Column Info */
	private String coCd = null;
	/* Column Info */
	private String coaCostSrcCd = null;
	/* Column Info */
	private String nodTtlAmt = null;
	/* Column Info */
	private String loclCurrCd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String costActGrpCd = null;
	/* Column Info */
	private String costVolCd = null;
	/* Column Info */
	private String costFxFlg = null;
	/* Column Info */
	private String lnkFmNodCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String lnkTtlAmt = null;
	/* Column Info */
	private String coaCostSrcCdV = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String nodTtlQty = null;
	/* Column Info */
	private String nodCd = null;
	/* Column Info */
	private String fullMtyCd = null;
	/* Column Info */
	private String lnkTtlQty = null;
	/* Column Info */
	private String costLocGrpCd = null;
	/* Column Info */
	private String stndCostUsdAmt = null;
	/* Column Info */
	private String mtyUcAmt = null;
	/* Column Info */
	private String lnkToNodCd = null;
	/* Column Info */
	private String stndCostCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String updUsrId = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public NodLnkCostCodeVO() {}

	public NodLnkCostCodeVO(String ibflag, String pagerows, String costYrmon, String fullMtyCd, String cntrTpszCd, String costLocGrpCd, String lnkFmNodCd, String lnkToNodCd, String stndCostCd, String coaCostSrcCdV, String coaCostSrcCd, String coCd, String loclCurrCd, String costFxFlg, String stndCostUsdAmt, String lnkTtlQty, String lnkTtlAmt, String costVolCd, String mtyUcAmt, String nodCd, String trdCd, String costActGrpCd, String nodTtlQty, String nodTtlAmt, String creUsrId, String updUsrId) {
		this.coCd = coCd;
		this.coaCostSrcCd = coaCostSrcCd;
		this.nodTtlAmt = nodTtlAmt;
		this.loclCurrCd = loclCurrCd;
		this.trdCd = trdCd;
		this.costActGrpCd = costActGrpCd;
		this.costVolCd = costVolCd;
		this.costFxFlg = costFxFlg;
		this.lnkFmNodCd = lnkFmNodCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.costYrmon = costYrmon;
		this.lnkTtlAmt = lnkTtlAmt;
		this.coaCostSrcCdV = coaCostSrcCdV;
		this.cntrTpszCd = cntrTpszCd;
		this.nodTtlQty = nodTtlQty;
		this.nodCd = nodCd;
		this.fullMtyCd = fullMtyCd;
		this.lnkTtlQty = lnkTtlQty;
		this.costLocGrpCd = costLocGrpCd;
		this.stndCostUsdAmt = stndCostUsdAmt;
		this.mtyUcAmt = mtyUcAmt;
		this.lnkToNodCd = lnkToNodCd;
		this.stndCostCd = stndCostCd;
		this.creUsrId = creUsrId;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("co_cd", getCoCd());
		this.hashColumns.put("coa_cost_src_cd", getCoaCostSrcCd());
		this.hashColumns.put("nod_ttl_amt", getNodTtlAmt());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("cost_act_grp_cd", getCostActGrpCd());
		this.hashColumns.put("cost_vol_cd", getCostVolCd());
		this.hashColumns.put("cost_fx_flg", getCostFxFlg());
		this.hashColumns.put("lnk_fm_nod_cd", getLnkFmNodCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("lnk_ttl_amt", getLnkTtlAmt());
		this.hashColumns.put("coa_cost_src_cd_v", getCoaCostSrcCdV());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("nod_ttl_qty", getNodTtlQty());
		this.hashColumns.put("nod_cd", getNodCd());
		this.hashColumns.put("full_mty_cd", getFullMtyCd());
		this.hashColumns.put("lnk_ttl_qty", getLnkTtlQty());
		this.hashColumns.put("cost_loc_grp_cd", getCostLocGrpCd());
		this.hashColumns.put("stnd_cost_usd_amt", getStndCostUsdAmt());
		this.hashColumns.put("mty_uc_amt", getMtyUcAmt());
		this.hashColumns.put("lnk_to_nod_cd", getLnkToNodCd());
		this.hashColumns.put("stnd_cost_cd", getStndCostCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("co_cd", "coCd");
		this.hashFields.put("coa_cost_src_cd", "coaCostSrcCd");
		this.hashFields.put("nod_ttl_amt", "nodTtlAmt");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("cost_act_grp_cd", "costActGrpCd");
		this.hashFields.put("cost_vol_cd", "costVolCd");
		this.hashFields.put("cost_fx_flg", "costFxFlg");
		this.hashFields.put("lnk_fm_nod_cd", "lnkFmNodCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("lnk_ttl_amt", "lnkTtlAmt");
		this.hashFields.put("coa_cost_src_cd_v", "coaCostSrcCdV");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("nod_ttl_qty", "nodTtlQty");
		this.hashFields.put("nod_cd", "nodCd");
		this.hashFields.put("full_mty_cd", "fullMtyCd");
		this.hashFields.put("lnk_ttl_qty", "lnkTtlQty");
		this.hashFields.put("cost_loc_grp_cd", "costLocGrpCd");
		this.hashFields.put("stnd_cost_usd_amt", "stndCostUsdAmt");
		this.hashFields.put("mty_uc_amt", "mtyUcAmt");
		this.hashFields.put("lnk_to_nod_cd", "lnkToNodCd");
		this.hashFields.put("stnd_cost_cd", "stndCostCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return coCd
	 */
	public String getCoCd() {
		return this.coCd;
	}
	
	/**
	 * Column Info
	 * @return coaCostSrcCd
	 */
	public String getCoaCostSrcCd() {
		return this.coaCostSrcCd;
	}
	
	/**
	 * Column Info
	 * @return nodTtlAmt
	 */
	public String getNodTtlAmt() {
		return this.nodTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return loclCurrCd
	 */
	public String getLoclCurrCd() {
		return this.loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
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
	 * @return costVolCd
	 */
	public String getCostVolCd() {
		return this.costVolCd;
	}
	
	/**
	 * Column Info
	 * @return costFxFlg
	 */
	public String getCostFxFlg() {
		return this.costFxFlg;
	}
	
	/**
	 * Column Info
	 * @return lnkFmNodCd
	 */
	public String getLnkFmNodCd() {
		return this.lnkFmNodCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return lnkTtlAmt
	 */
	public String getLnkTtlAmt() {
		return this.lnkTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return coaCostSrcCdV
	 */
	public String getCoaCostSrcCdV() {
		return this.coaCostSrcCdV;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return nodTtlQty
	 */
	public String getNodTtlQty() {
		return this.nodTtlQty;
	}
	
	/**
	 * Column Info
	 * @return nodCd
	 */
	public String getNodCd() {
		return this.nodCd;
	}
	
	/**
	 * Column Info
	 * @return fullMtyCd
	 */
	public String getFullMtyCd() {
		return this.fullMtyCd;
	}
	
	/**
	 * Column Info
	 * @return lnkTtlQty
	 */
	public String getLnkTtlQty() {
		return this.lnkTtlQty;
	}
	
	/**
	 * Column Info
	 * @return costLocGrpCd
	 */
	public String getCostLocGrpCd() {
		return this.costLocGrpCd;
	}
	
	/**
	 * Column Info
	 * @return stndCostUsdAmt
	 */
	public String getStndCostUsdAmt() {
		return this.stndCostUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return mtyUcAmt
	 */
	public String getMtyUcAmt() {
		return this.mtyUcAmt;
	}
	
	/**
	 * Column Info
	 * @return lnkToNodCd
	 */
	public String getLnkToNodCd() {
		return this.lnkToNodCd;
	}
	
	/**
	 * Column Info
	 * @return stndCostCd
	 */
	public String getStndCostCd() {
		return this.stndCostCd;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @param coCd
	 */
	public void setCoCd(String coCd) {
		this.coCd = coCd;
	}
	
	/**
	 * Column Info
	 * @param coaCostSrcCd
	 */
	public void setCoaCostSrcCd(String coaCostSrcCd) {
		this.coaCostSrcCd = coaCostSrcCd;
	}
	
	/**
	 * Column Info
	 * @param nodTtlAmt
	 */
	public void setNodTtlAmt(String nodTtlAmt) {
		this.nodTtlAmt = nodTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param loclCurrCd
	 */
	public void setLoclCurrCd(String loclCurrCd) {
		this.loclCurrCd = loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
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
	 * @param costVolCd
	 */
	public void setCostVolCd(String costVolCd) {
		this.costVolCd = costVolCd;
	}
	
	/**
	 * Column Info
	 * @param costFxFlg
	 */
	public void setCostFxFlg(String costFxFlg) {
		this.costFxFlg = costFxFlg;
	}
	
	/**
	 * Column Info
	 * @param lnkFmNodCd
	 */
	public void setLnkFmNodCd(String lnkFmNodCd) {
		this.lnkFmNodCd = lnkFmNodCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param lnkTtlAmt
	 */
	public void setLnkTtlAmt(String lnkTtlAmt) {
		this.lnkTtlAmt = lnkTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param coaCostSrcCdV
	 */
	public void setCoaCostSrcCdV(String coaCostSrcCdV) {
		this.coaCostSrcCdV = coaCostSrcCdV;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param nodTtlQty
	 */
	public void setNodTtlQty(String nodTtlQty) {
		this.nodTtlQty = nodTtlQty;
	}
	
	/**
	 * Column Info
	 * @param nodCd
	 */
	public void setNodCd(String nodCd) {
		this.nodCd = nodCd;
	}
	
	/**
	 * Column Info
	 * @param fullMtyCd
	 */
	public void setFullMtyCd(String fullMtyCd) {
		this.fullMtyCd = fullMtyCd;
	}
	
	/**
	 * Column Info
	 * @param lnkTtlQty
	 */
	public void setLnkTtlQty(String lnkTtlQty) {
		this.lnkTtlQty = lnkTtlQty;
	}
	
	/**
	 * Column Info
	 * @param costLocGrpCd
	 */
	public void setCostLocGrpCd(String costLocGrpCd) {
		this.costLocGrpCd = costLocGrpCd;
	}
	
	/**
	 * Column Info
	 * @param stndCostUsdAmt
	 */
	public void setStndCostUsdAmt(String stndCostUsdAmt) {
		this.stndCostUsdAmt = stndCostUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param mtyUcAmt
	 */
	public void setMtyUcAmt(String mtyUcAmt) {
		this.mtyUcAmt = mtyUcAmt;
	}
	
	/**
	 * Column Info
	 * @param lnkToNodCd
	 */
	public void setLnkToNodCd(String lnkToNodCd) {
		this.lnkToNodCd = lnkToNodCd;
	}
	
	/**
	 * Column Info
	 * @param stndCostCd
	 */
	public void setStndCostCd(String stndCostCd) {
		this.stndCostCd = stndCostCd;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCoCd(JSPUtil.getParameter(request, "co_cd", ""));
		setCoaCostSrcCd(JSPUtil.getParameter(request, "coa_cost_src_cd", ""));
		setNodTtlAmt(JSPUtil.getParameter(request, "nod_ttl_amt", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, "locl_curr_cd", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setCostActGrpCd(JSPUtil.getParameter(request, "costActGrpCd", ""));
		setCostVolCd(JSPUtil.getParameter(request, "cost_vol_cd", ""));
		setCostFxFlg(JSPUtil.getParameter(request, "cost_fx_flg", ""));
		setLnkFmNodCd(JSPUtil.getParameter(request, "lnk_fm_nod_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCostYrmon(JSPUtil.getParameter(request, "cost_yrmon", ""));
		setLnkTtlAmt(JSPUtil.getParameter(request, "lnk_ttl_amt", ""));
		setCoaCostSrcCdV(JSPUtil.getParameter(request, "coa_cost_src_cd_v", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setNodTtlQty(JSPUtil.getParameter(request, "nod_ttl_qty", ""));
		setNodCd(JSPUtil.getParameter(request, "nod_cd", ""));
		setFullMtyCd(JSPUtil.getParameter(request, "full_mty_cd", ""));
		setLnkTtlQty(JSPUtil.getParameter(request, "lnk_ttl_qty", ""));
		setCostLocGrpCd(JSPUtil.getParameter(request, "cost_loc_grp_cd", ""));
		setStndCostUsdAmt(JSPUtil.getParameter(request, "stnd_cost_usd_amt", ""));
		setMtyUcAmt(JSPUtil.getParameter(request, "mty_uc_amt", ""));
		setLnkToNodCd(JSPUtil.getParameter(request, "lnk_to_nod_cd", ""));
		setStndCostCd(JSPUtil.getParameter(request, "stnd_cost_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return NodLnkCostCodeVO[]
	 */
	public NodLnkCostCodeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return NodLnkCostCodeVO[]
	 */
	public NodLnkCostCodeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		NodLnkCostCodeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] coCd = (JSPUtil.getParameter(request, prefix	+ "co_cd", length));
			String[] coaCostSrcCd = (JSPUtil.getParameter(request, prefix	+ "coa_cost_src_cd", length));
			String[] nodTtlAmt = (JSPUtil.getParameter(request, prefix	+ "nod_ttl_amt", length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] costActGrpCd = (JSPUtil.getParameter(request, prefix	+ "cost_act_grp_cd", length));
			String[] costVolCd = (JSPUtil.getParameter(request, prefix	+ "cost_vol_cd", length));
			String[] costFxFlg = (JSPUtil.getParameter(request, prefix	+ "cost_fx_flg", length));
			String[] lnkFmNodCd = (JSPUtil.getParameter(request, prefix	+ "lnk_fm_nod_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] lnkTtlAmt = (JSPUtil.getParameter(request, prefix	+ "lnk_ttl_amt", length));
			String[] coaCostSrcCdV = (JSPUtil.getParameter(request, prefix	+ "coa_cost_src_cd_v", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] nodTtlQty = (JSPUtil.getParameter(request, prefix	+ "nod_ttl_qty", length));
			String[] nodCd = (JSPUtil.getParameter(request, prefix	+ "nod_cd", length));
			String[] fullMtyCd = (JSPUtil.getParameter(request, prefix	+ "full_mty_cd", length));
			String[] lnkTtlQty = (JSPUtil.getParameter(request, prefix	+ "lnk_ttl_qty", length));
			String[] costLocGrpCd = (JSPUtil.getParameter(request, prefix	+ "cost_loc_grp_cd", length));
			String[] stndCostUsdAmt = (JSPUtil.getParameter(request, prefix	+ "stnd_cost_usd_amt", length));
			String[] mtyUcAmt = (JSPUtil.getParameter(request, prefix	+ "mty_uc_amt", length));
			String[] lnkToNodCd = (JSPUtil.getParameter(request, prefix	+ "lnk_to_nod_cd", length));
			String[] stndCostCd = (JSPUtil.getParameter(request, prefix	+ "stnd_cost_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new NodLnkCostCodeVO();
				if (coCd[i] != null)
					model.setCoCd(coCd[i]);
				if (coaCostSrcCd[i] != null)
					model.setCoaCostSrcCd(coaCostSrcCd[i]);
				if (nodTtlAmt[i] != null)
					model.setNodTtlAmt(nodTtlAmt[i]);
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (costActGrpCd[i] != null)
					model.setCostActGrpCd(costActGrpCd[i]);
				if (costVolCd[i] != null)
					model.setCostVolCd(costVolCd[i]);
				if (costFxFlg[i] != null)
					model.setCostFxFlg(costFxFlg[i]);
				if (lnkFmNodCd[i] != null)
					model.setLnkFmNodCd(lnkFmNodCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (lnkTtlAmt[i] != null)
					model.setLnkTtlAmt(lnkTtlAmt[i]);
				if (coaCostSrcCdV[i] != null)
					model.setCoaCostSrcCdV(coaCostSrcCdV[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (nodTtlQty[i] != null)
					model.setNodTtlQty(nodTtlQty[i]);
				if (nodCd[i] != null)
					model.setNodCd(nodCd[i]);
				if (fullMtyCd[i] != null)
					model.setFullMtyCd(fullMtyCd[i]);
				if (lnkTtlQty[i] != null)
					model.setLnkTtlQty(lnkTtlQty[i]);
				if (costLocGrpCd[i] != null)
					model.setCostLocGrpCd(costLocGrpCd[i]);
				if (stndCostUsdAmt[i] != null)
					model.setStndCostUsdAmt(stndCostUsdAmt[i]);
				if (mtyUcAmt[i] != null)
					model.setMtyUcAmt(mtyUcAmt[i]);
				if (lnkToNodCd[i] != null)
					model.setLnkToNodCd(lnkToNodCd[i]);
				if (stndCostCd[i] != null)
					model.setStndCostCd(stndCostCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getNodLnkCostCodeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return NodLnkCostCodeVO[]
	 */
	public NodLnkCostCodeVO[] getNodLnkCostCodeVOs(){
		NodLnkCostCodeVO[] vos = (NodLnkCostCodeVO[])models.toArray(new NodLnkCostCodeVO[models.size()]);
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
		this.coCd = this.coCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaCostSrcCd = this.coaCostSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodTtlAmt = this.nodTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costActGrpCd = this.costActGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costVolCd = this.costVolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costFxFlg = this.costFxFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkFmNodCd = this.lnkFmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkTtlAmt = this.lnkTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaCostSrcCdV = this.coaCostSrcCdV .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodTtlQty = this.nodTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodCd = this.nodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullMtyCd = this.fullMtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkTtlQty = this.lnkTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costLocGrpCd = this.costLocGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndCostUsdAmt = this.stndCostUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyUcAmt = this.mtyUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkToNodCd = this.lnkToNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndCostCd = this.stndCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
