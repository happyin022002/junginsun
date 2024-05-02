/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchMT4003CostListVO1.java
*@FileTitle : SearchMT4003CostListVO1
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.23
*@LastModifier : SJH
*@LastVersion : 1.0

=========================================================*/

package com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo;

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
 * @see AbstractValueObject
 */

public class EqRepoCostVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EqRepoCostVO> models = new ArrayList<EqRepoCostVO>();
	
	/* Column Info */
	private String costLocGrpCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String trdCd = null;	
	/* Column Info */
	private String sccCd = null;	
	/* Column Info */
	private String effFmYrmon = null;
	/* Column Info */
	private String effToYrmon = null;	
	/* Column Info */
	private String ibMtyAmt1 = null;
	/* Column Info */
	private String obMtyAmt1 = null;
	/* Column Info */
	private String ibMtyAmt2 = null;
	/* Column Info */
	private String obMtyAmt2 = null;
	/* Column Info */
	private String cntrIoVolStsCd = null;
	/* Column Info */
	private String cntrImbalRto = null;
	/* Column Info */
	private String cntrIbQty = null;
	/* Column Info */
	private String cntrObQty = null;	
	/* Column Info */
	private String mtyCostTpNm = null;
	/* Column Info */
	private String costSrcFmYrmon = null;	
	/* Column Info */
	private String costSrcToYrmon = null;
	/* 2번째 그리드 */
	/* Column Info */
	private String orgNodCd = null;	
	/* Column Info */
	private String destNodCd = null;	
	/* Column Info */
	private String mtyQty = null;	
	/* Column Info */
	private String trspMtyCostModNm = null;	
	/* Column Info */
	private String mtyUtAmt = null;		
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;	
	/* Column Info */
	private String creDt = null;	
	/* Column Info */
	private String updUsrId = null;	
	/* Column Info */
	private String updDt = null;		

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	/**
	 * SearchMT4003CostListVO1 생성자
	 */
	public  EqRepoCostVO() {}

	/**
	 * SearchMT4003CostListVO1 생성자
	 */
	public EqRepoCostVO(String ibflag, 
			                       String pagerows, 
			                       String costLocGrpCd, 
			                       String cntrTpszCd,
			                       String trdCd, 
			                       String sccCd, 
			                       String effFmYrmon, 
			                       String effToYrmon,	
			                       String ibMtyAmt1, 
			                       String obMtyAmt1,
			                       String ibMtyAmt2, 
			                       String obMtyAmt2,
			                       String cntrIoVolStsCd, 			                       
			                       String cntrImbalRto,
			                       String cntrIbQty,
			                       String cntrObQty,
			                       String mtyCostTpNm,
			                       String costSrcFmYrmon, 
			                       String costSrcToYrmon,
			                       String orgNodCd,	
			                       String destNodCd,	
			                       String mtyQty,	
			                       String trspMtyCostModNm,	
			                       String mtyUtAmt,	
			                       String creUsrId, 
				                   String creDt, 
				                   String updUsrId, 
				                   String updDt) {
		this.costLocGrpCd = costLocGrpCd;
		this.cntrTpszCd = cntrTpszCd;	
		this.trdCd = trdCd;
		this.sccCd = sccCd;
		this.effFmYrmon = effFmYrmon;
		this.effToYrmon = effToYrmon;	
		this.ibMtyAmt1 = ibMtyAmt1;
		this.obMtyAmt1 = obMtyAmt1;
		this.ibMtyAmt2 = ibMtyAmt2;
		this.obMtyAmt2 = obMtyAmt2;
		this.cntrIoVolStsCd = cntrIoVolStsCd;		
		this.cntrImbalRto = cntrImbalRto;
		this.cntrIbQty = cntrIbQty;
		this.cntrObQty = cntrObQty;
		this.mtyCostTpNm = mtyCostTpNm;
		this.costSrcFmYrmon = costSrcFmYrmon;
		this.costSrcToYrmon = costSrcToYrmon;			
		/* 2번째 그리드 */
		this.orgNodCd = orgNodCd;	
		this.destNodCd = destNodCd;	
		this.mtyQty = mtyQty;	
		this.trspMtyCostModNm = trspMtyCostModNm;	
		this.mtyUtAmt = mtyUtAmt;			
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.creDt = creDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cost_loc_grp_cd", getCostLocGrpCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("scc_cd", getSccCd());
		this.hashColumns.put("eff_fm_yrmon", getEffFmYrmon());
		this.hashColumns.put("eff_to_yrmon", getEffToYrmon());	
		this.hashColumns.put("ib_mty_amt1",  getIbMtyAmt1());
		this.hashColumns.put("ob_mty_amt1",  getObMtyAmt1());
		this.hashColumns.put("ib_mty_amt2",  getIbMtyAmt2());
		this.hashColumns.put("ob_mty_amt2",  getObMtyAmt2());
		this.hashColumns.put("cntr_io_vol_sts_cd", getCntrIoVolStsCd());		
		this.hashColumns.put("cntr_imbal_rto", getCntrImbalRto());
		this.hashColumns.put("cntr_ib_qty", getCntrIbQty());
		this.hashColumns.put("cntr_ob_qty", getCntrObQty());
		this.hashColumns.put("mty_cost_tp_nm", getMtyCostTpNm());
		this.hashColumns.put("cost_src_fm_yrmon", getCostSrcFmYrmon());
		this.hashColumns.put("cost_src_to_yrmon", getCostSrcToYrmon());		
		/* 2번째 그리드 */
		this.hashColumns.put("org_nod_cd", getOrgNodCd());
		this.hashColumns.put("dest_nod_cd", getDestNodCd());
		this.hashColumns.put("mty_qty", getMtyQty());
		this.hashColumns.put("trsp_mty_cost_mod_nm", getTrspMtyCostModNm());
		this.hashColumns.put("mty_ut_amt", getMtyUtAmt());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_dt", getCreDt());	
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cost_loc_grp_cd", "costLocGrpCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("scc_cd", "sccCd");
		this.hashFields.put("eff_fm_yrmon", "effFmYrmon");
		this.hashFields.put("eff_to_yrmon", "effToYrmon");
		this.hashFields.put("ib_mty_amt1", "ibMtyAmt1");
		this.hashFields.put("ob_mty_amt1", "obMtyAmt1");
		this.hashFields.put("ib_mty_amt2", "ibMtyAmt2");
		this.hashFields.put("ob_mty_amt2", "obMtyAmt2");
		this.hashFields.put("cntr_io_vol_sts_cd", "cntrIoVolStsCd");		
		this.hashFields.put("cntr_imbal_rto", "cntrImbalRto");
		this.hashFields.put("cntr_ib_qty", "cntrIbQty");
		this.hashFields.put("cntr_ob_qty", "cntrObQty");
		this.hashFields.put("mty_cost_tp_nm", "mtyCostTpNm");
		this.hashFields.put("cost_src_fm_yrmon", "costSrcFmYrmon");
		this.hashFields.put("cost_src_to_yrmon", "costSrcToYrmon");	
		/* 2번째 그리드 */
		this.hashFields.put("org_nod_cd", "orgNodCd");
		this.hashFields.put("dest_nod_cd", "destNodCd");
		this.hashFields.put("mty_qty", "mtyQty");
		this.hashFields.put("trsp_mty_cost_mod_nm", "trspMtyCostModNm");
		this.hashFields.put("mty_ut_amt", "mtyUtAmt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");		
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
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
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
	 * @return sccCd
	 */
	public String getSccCd() {
		return this.sccCd;
	}	
	
	/**
	 * Column Info
	 * @return effFmYrmon
	 */
	public String getEffFmYrmon() {
		return this.effFmYrmon;
	}	
	
	/**
	 * Column Info
	 * @return effToYrmon
	 */
	public String getEffToYrmon() {
		return this.effToYrmon;
	}	
	
	/**
	 * Column Info
	 * @return ibMtyAmt1
	 */
	public String getIbMtyAmt1() {
		return this.ibMtyAmt1;
	}	
	
	/**
	 * Column Info
	 * @return obMtyAmt1
	 */
	public String getObMtyAmt1() {
		return this.obMtyAmt1;
	}	
	
	/**
	 * Column Info
	 * @return ibMtyAmt2
	 */
	public String getIbMtyAmt2() {
		return this.ibMtyAmt2;
	}	
	
	/**
	 * Column Info
	 * @return obMtyAmt2
	 */
	public String getObMtyAmt2() {
		return this.obMtyAmt2;
	}	
	
	/**
	 * Column Info
	 * @return cntrIoVolStsCd
	 */
	public String getCntrIoVolStsCd() {
		return this.cntrIoVolStsCd;
	}		
	
	/**
	 * Column Info
	 * @return cntrImbalRto
	 */
	public String getCntrImbalRto() {
		return this.cntrImbalRto;
	}
	
	/**
	 * Column Info
	 * @return cntrImbalQty
	 */
	public String getCntrIbQty() {
		return this.cntrIbQty;
	}
	
	/**
	 * Column Info
	 * @return cntrObQty
	 */
	public String getCntrObQty() {
		return this.cntrObQty;
	}	
	
	/**
	 * Column Info
	 * @return mtyCostTpNm
	 */
	public String getMtyCostTpNm() {
		return this.mtyCostTpNm;
	}	
	
	/**
	 * Column Info
	 * @return costSrcFmYrmon
	 */
	public String getCostSrcFmYrmon() {
		return this.costSrcFmYrmon;
	}		
	
	/**
	 * Column Info
	 * @return costSrcToYrmon
	 */
	public String getCostSrcToYrmon() {
		return this.costSrcToYrmon;
	}	
	
	/**
	 * Column Info
	 * @return orgNodCd
	 */
	public String getOrgNodCd() {
		return this.orgNodCd;
	}
	
	/**
	 * Column Info
	 * @return destNodCd
	 */
	public String getDestNodCd() {
		return this.destNodCd;
	}
	
	/**
	 * Column Info
	 * @return mtyQty
	 */
	public String getMtyQty() {
		return this.mtyQty;
	}
	
	/**
	 * Column Info
	 * @return trspMtyCostModNm
	 */
	public String getTrspMtyCostModNm() {
		return this.trspMtyCostModNm;
	}
	
	/**
	 * Column Info
	 * @return mtyUtAmt
	 */
	public String getMtyUtAmt() {
		return this.mtyUtAmt;
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
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
	 * @param costLocGrpCd
	 */
	public void setCostLocGrpCd(String costLocGrpCd) {
		this.costLocGrpCd = costLocGrpCd;
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
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}	
	
	/**
	 * Column Info
	 * @param sccCd
	 */
	public void setSccCd(String sccCd) {
		this.sccCd = sccCd;
	}
	
	/**
	 * Column Info
	 * @param effFmYrmon
	 */
	public void setEffFmYrmon(String effFmYrmon) {
		this.effFmYrmon = effFmYrmon;
	}
	
	/**
	 * Column Info
	 * @param effToYrmon
	 */
	public void setEffToYrmon(String effToYrmon) {
		this.effToYrmon = effToYrmon;
	}	
	
	/**
	 * Column Info
	 * @param ibMtyAmt1
	 */
	public void setIbMtyAmt1(String ibMtyAmt1) {
		this.ibMtyAmt1 = ibMtyAmt1;
	}
	
	/**
	 * Column Info
	 * @param obMtyAmt1
	 */
	public void setObMtyAmt1(String obMtyAmt1) {
		this.obMtyAmt1 = obMtyAmt1;
	}
	
	/**
	 * Column Info
	 * @param ibMtyAmt2
	 */
	public void setIbMtyAmt2(String ibMtyAmt2) {
		this.ibMtyAmt2 = ibMtyAmt2;
	}
	
	/**
	 * Column Info
	 * @param obMtyAmt2
	 */
	public void setObMtyAmt2(String obMtyAmt2) {
		this.obMtyAmt2 = obMtyAmt2;
	}
	
	/**
	 * Column Info
	 * @param cntrIoVolStsCd
	 */
	public void setCntrIoVolStsCd(String cntrIoVolStsCd) {
		this.cntrIoVolStsCd = cntrIoVolStsCd;
	}	
	
	/**
	 * Column Info
	 * @param cntrImbalRto
	 */
	public void setCntrImbalRto(String cntrImbalRto) {
		this.cntrImbalRto = cntrImbalRto;
	}	
	
	/**
	 * Column Info
	 * @param cntrIbQty
	 */
	public void setCntrIbQty(String cntrIbQty) {
		this.cntrIbQty = cntrIbQty;
	}
	
	/**
	 * Column Info
	 * @param mtyTrspUcAmt
	 */
	public void setCntrObQty(String cntrObQty) {
		this.cntrObQty = cntrObQty;
	}	
	
	/**
	 * Column Info
	 * @param mtyCostTpNm
	 */
	public void setMtyCostTpNm(String mtyCostTpNm) {
		this.mtyCostTpNm = mtyCostTpNm;
	}
	
	/**
	 * Column Info
	 * @param costSrcFmYrmon
	 */
	public void setCostSrcFmYrmon(String costSrcFmYrmon) {
		this.costSrcFmYrmon = costSrcFmYrmon;
	}	
	
	/**
	 * Column Info
	 * @param costSrcToYrmon
	 */
	public void setCostSrcToYrmon(String costSrcToYrmon) {
		this.costSrcToYrmon = costSrcToYrmon;
	}		
	
	/**
	 * Column Info
	 * @param orgNodCd
	 */
	public void setOrgNodCd(String orgNodCd) {
		this.orgNodCd = orgNodCd;
	}
	
	/**
	 * Column Info
	 * @param destNodCd
	 */
	public void setDestNodCd(String destNodCd) {
		this.destNodCd = destNodCd;
	}
	
	/**
	 * Column Info
	 * @param mtyQty
	 */
	public void setMtyQty(String mtyQty) {
		this.mtyQty = mtyQty;
	}
	
	/**
	 * Column Info
	 * @param trspMtyCostModNm
	 */
	public void setTrspMtyCostModNm(String trspMtyCostModNm) {
		this.trspMtyCostModNm = trspMtyCostModNm;
	}
	
	/**
	 * Column Info
	 * @param mtyUtAmt
	 */
	public void setMtyUtAmt(String mtyUtAmt) {
		this.mtyUtAmt = mtyUtAmt;
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
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}	
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCostLocGrpCd(JSPUtil.getParameter(request, "cost_loc_grp_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setSccCd(JSPUtil.getParameter(request, "scc_cd", ""));
		setEffFmYrmon(JSPUtil.getParameter(request, "eff_fm_yrmon", ""));
		setEffToYrmon(JSPUtil.getParameter(request, "eff_to_yrmon", ""));	
		setIbMtyAmt1(JSPUtil.getParameter(request, "ib_mty_amt1", ""));
		setObMtyAmt1(JSPUtil.getParameter(request, "ob_mty_amt1", ""));
		setIbMtyAmt2(JSPUtil.getParameter(request, "ib_mty_amt2", ""));
		setObMtyAmt2(JSPUtil.getParameter(request, "ob_mty_amt2", ""));
		setCntrIoVolStsCd(JSPUtil.getParameter(request, "cntr_io_vol_sts_cd", ""));
		setCntrImbalRto(JSPUtil.getParameter(request, "cntr_imbal_rto", ""));
		setCntrIbQty(JSPUtil.getParameter(request, "cntr_ib_qty", ""));
		setCntrObQty(JSPUtil.getParameter(request, "cntr_ob_qty", ""));
		setMtyCostTpNm(JSPUtil.getParameter(request, "mty_cost_tp_nm", ""));
		setCostSrcFmYrmon(JSPUtil.getParameter(request, "cost_src_fm_yrmon", ""));
		setCostSrcToYrmon(JSPUtil.getParameter(request, "cost_src_to_yrmon", ""));	
		/* 2번째 그리드 */
		setOrgNodCd(JSPUtil.getParameter(request, "org_nod_cd", ""));		
		setDestNodCd(JSPUtil.getParameter(request, "dest_nod_cd", ""));		
		setMtyQty(JSPUtil.getParameter(request, "mty_qty", ""));		
		setTrspMtyCostModNm(JSPUtil.getParameter(request, "trsp_mty_cost_mod_nm", ""));		
		setMtyUtAmt(JSPUtil.getParameter(request, "mty_ut_amt", ""));		
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMT4003CostListVO1[]
	 */
	public EqRepoCostVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMT4003CostListVO1[]
	 */
	public EqRepoCostVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EqRepoCostVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] costLocGrpCd = (JSPUtil.getParameter(request, prefix	+ "cost_loc_grp_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] sccCd = (JSPUtil.getParameter(request, prefix	+ "scc_cd", length));
			String[] effFmYrmon = (JSPUtil.getParameter(request, prefix	+ "eff_fm_yrmon", length));
			String[] effToYrmon = (JSPUtil.getParameter(request, prefix	+ "eff_to_yrmon", length));
			String[] ibMtyAmt1 = (JSPUtil.getParameter(request, prefix	+ "ib_mty_amt1", length));
			String[] obMtyAmt1 = (JSPUtil.getParameter(request, prefix	+ "ob_mty_amt1", length));
			String[] ibMtyAmt2 = (JSPUtil.getParameter(request, prefix	+ "ib_mty_amt2", length));
			String[] obMtyAmt2 = (JSPUtil.getParameter(request, prefix	+ "ob_mty_amt2", length));
			String[] cntrIoVolStsCd = (JSPUtil.getParameter(request, prefix	+ "cntr_io_vol_sts_cd", length));			
			String[] cntrImbalRto = (JSPUtil.getParameter(request, prefix	+ "cntr_imbal_rto", length));
			String[] cntrIbQty = (JSPUtil.getParameter(request, prefix	+ "cntr_ib_qty", length));
			String[] cntrObQty = (JSPUtil.getParameter(request, prefix	+ "cntr_ob_qty", length));
			String[] mtyCostTpNm = (JSPUtil.getParameter(request, prefix	+ "mty_cost_tp_nm", length));
			String[] costSrcFmYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_src_fm_yrmon", length));
			String[] costSrcToYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_src_to_yrmon", length));		
			/* 2번째 그리드 */
			String[] orgNodCd = (JSPUtil.getParameter(request, prefix	+ "org_nod_cd", length));
			String[] destNodCd = (JSPUtil.getParameter(request, prefix	+ "dest_nod_cd", length));
			String[] mtyQty = (JSPUtil.getParameter(request, prefix	+ "mty_qty", length));
			String[] trspMtyCostModNm = (JSPUtil.getParameter(request, prefix	+ "trsp_mty_cost_mod_nm", length));
			String[] mtyUtAmt = (JSPUtil.getParameter(request, prefix	+ "mty_ut_amt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));	
			
			for (int i = 0; i < length; i++) { 
				model = new EqRepoCostVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (costLocGrpCd[i] != null)
					model.setCostLocGrpCd(costLocGrpCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);					
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (sccCd[i] != null)
					model.setSccCd(sccCd[i]);	
				if (effFmYrmon[i] != null)
					model.setEffFmYrmon(effFmYrmon[i]);
				if (effToYrmon[i] != null)
					model.setEffToYrmon(effToYrmon[i]);
				if (ibMtyAmt1[i] != null)
					model.setIbMtyAmt1(ibMtyAmt1[i]);
				if (obMtyAmt1[i] != null)
					model.setObMtyAmt1(obMtyAmt1[i]);
				if (ibMtyAmt2[i] != null)
					model.setIbMtyAmt2(ibMtyAmt2[i]);
				if (obMtyAmt2[i] != null)
					model.setObMtyAmt2(obMtyAmt2[i]);
				if (cntrIoVolStsCd[i] != null)
					model.setCntrIoVolStsCd(cntrIoVolStsCd[i]);				
				if (cntrImbalRto[i] != null)
					model.setCntrImbalRto(cntrImbalRto[i]);
				if (cntrIbQty[i] != null)
					model.setCntrIbQty(cntrIbQty[i]);
				if (cntrObQty[i] != null)
					model.setCntrObQty(cntrObQty[i]);
				if (mtyCostTpNm[i] != null)
					model.setMtyCostTpNm(mtyCostTpNm[i]);		
				if (costSrcFmYrmon[i] != null)
					model.setCostSrcFmYrmon(costSrcFmYrmon[i]);		
				if (costSrcToYrmon[i] != null)
					model.setCostSrcToYrmon(costSrcToYrmon[i]);	
				/* 2번째 그리드 */
				if (orgNodCd[i] != null)
					model.setOrgNodCd(orgNodCd[i]);	
				if (destNodCd[i] != null)
					model.setDestNodCd(destNodCd[i]);	
				if (mtyQty[i] != null)
					model.setMtyQty(mtyQty[i]);	
				if (trspMtyCostModNm[i] != null)
					model.setTrspMtyCostModNm(trspMtyCostModNm[i]);	
				if (mtyUtAmt[i] != null)
					model.setMtyUtAmt(mtyUtAmt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);				
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);	
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);				
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);					
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMT4003CostListVO1s();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMT4003CostListVO1[]
	 */
	public EqRepoCostVO[] getSearchMT4003CostListVO1s(){
		EqRepoCostVO[] vos = (EqRepoCostVO[])models.toArray(new EqRepoCostVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costLocGrpCd = this.costLocGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd = this.sccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effFmYrmon = this.effFmYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effToYrmon = this.effToYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibMtyAmt1 = this.ibMtyAmt1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obMtyAmt1 = this.obMtyAmt1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibMtyAmt2 = this.ibMtyAmt2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obMtyAmt2 = this.obMtyAmt2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrIoVolStsCd = this.cntrIoVolStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.cntrImbalRto = this.cntrImbalRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrIbQty = this.cntrIbQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrObQty = this.cntrObQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyCostTpNm = this.mtyCostTpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costSrcFmYrmon = this.costSrcFmYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costSrcToYrmon = this.costSrcToYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		/* 2번째 그리드 */
		this.orgNodCd = this.orgNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destNodCd = this.destNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyQty = this.mtyQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspMtyCostModNm = this.trspMtyCostModNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyUtAmt = this.mtyUtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

