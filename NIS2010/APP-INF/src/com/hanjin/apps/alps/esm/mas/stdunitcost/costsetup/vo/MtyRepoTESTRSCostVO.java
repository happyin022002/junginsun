/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MtyRepoTESTRSCostVO.java
*@FileTitle : MtyRepoTESTRSCostVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.28
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2015.05.28 이윤정 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.stdunitcost.costsetup.vo;

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
 * @author 이윤정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MtyRepoTESTRSCostVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MtyRepoTESTRSCostVO> models = new ArrayList<MtyRepoTESTRSCostVO>();
	
	/* Column Info */
	private String slsFmDt = null;
	/* Column Info */
	private String mtyTtlCreIfAmt = null;
	/* Column Info */
	private String mtyTrspMnlAmt = null;
	/* Column Info */
	private String ttlAmt = null;
	/* Column Info */
	private String mtyTrspCreBseIfAmt = null;
	/* Column Info */
	private String mtyTmlCreBseIfAmt = null;
	/* Column Info */
	private String mtyTmlMnlAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mtyRepoCreDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String aplyAdjPlFlg = null;
	/* Column Info */
	private String costYr = null;
	/* Column Info */
	private String mtyTrspIfAmt = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String mtTrans = null;
	/* Column Info */
	private String mtyTtlIfAmt = null;
	/* Column Info */
	private String mtyTmlIfAmt = null;
	/* Column Info */
	private String revMon = null;
	/* Column Info */
	private String selFlg = null;
	/* Column Info */
	private String mtSteve = null;
	/* Column Info */
	private String mtyTtlMnlAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public MtyRepoTESTRSCostVO() {}

	public MtyRepoTESTRSCostVO(String ibflag, String pagerows, String slsFmDt, String mtyTtlCreIfAmt, String mtyTrspMnlAmt, String mtyTrspCreBseIfAmt, String mtyTmlCreBseIfAmt, String mtyTmlMnlAmt, String costYrmon, String aplyAdjPlFlg, String mtyTrspIfAmt, String costWk, String userId, String mtyTtlIfAmt, String mtyTmlIfAmt, String selFlg, String mtyTtlMnlAmt, String costYr, String revMon, String mtSteve, String mtTrans, String ttlAmt, String mtyRepoCreDt) {
		this.slsFmDt = slsFmDt;
		this.mtyTtlCreIfAmt = mtyTtlCreIfAmt;
		this.mtyTrspMnlAmt = mtyTrspMnlAmt;
		this.ttlAmt = ttlAmt;
		this.mtyTrspCreBseIfAmt = mtyTrspCreBseIfAmt;
		this.mtyTmlCreBseIfAmt = mtyTmlCreBseIfAmt;
		this.mtyTmlMnlAmt = mtyTmlMnlAmt;
		this.pagerows = pagerows;
		this.mtyRepoCreDt = mtyRepoCreDt;
		this.ibflag = ibflag;
		this.costYrmon = costYrmon;
		this.aplyAdjPlFlg = aplyAdjPlFlg;
		this.costYr = costYr;
		this.mtyTrspIfAmt = mtyTrspIfAmt;
		this.costWk = costWk;
		this.userId = userId;
		this.mtTrans = mtTrans;
		this.mtyTtlIfAmt = mtyTtlIfAmt;
		this.mtyTmlIfAmt = mtyTmlIfAmt;
		this.revMon = revMon;
		this.selFlg = selFlg;
		this.mtSteve = mtSteve;
		this.mtyTtlMnlAmt = mtyTtlMnlAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sls_fm_dt", getSlsFmDt());
		this.hashColumns.put("mty_ttl_cre_if_amt", getMtyTtlCreIfAmt());
		this.hashColumns.put("mty_trsp_mnl_amt", getMtyTrspMnlAmt());
		this.hashColumns.put("ttl_amt", getTtlAmt());
		this.hashColumns.put("mty_trsp_cre_bse_if_amt", getMtyTrspCreBseIfAmt());
		this.hashColumns.put("mty_tml_cre_bse_if_amt", getMtyTmlCreBseIfAmt());
		this.hashColumns.put("mty_tml_mnl_amt", getMtyTmlMnlAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mty_repo_cre_dt", getMtyRepoCreDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("aply_adj_pl_flg", getAplyAdjPlFlg());
		this.hashColumns.put("cost_yr", getCostYr());
		this.hashColumns.put("mty_trsp_if_amt", getMtyTrspIfAmt());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("mt_trans", getMtTrans());
		this.hashColumns.put("mty_ttl_if_amt", getMtyTtlIfAmt());
		this.hashColumns.put("mty_tml_if_amt", getMtyTmlIfAmt());
		this.hashColumns.put("rev_mon", getRevMon());
		this.hashColumns.put("sel_flg", getSelFlg());
		this.hashColumns.put("mt_steve", getMtSteve());
		this.hashColumns.put("mty_ttl_mnl_amt", getMtyTtlMnlAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sls_fm_dt", "slsFmDt");
		this.hashFields.put("mty_ttl_cre_if_amt", "mtyTtlCreIfAmt");
		this.hashFields.put("mty_trsp_mnl_amt", "mtyTrspMnlAmt");
		this.hashFields.put("ttl_amt", "ttlAmt");
		this.hashFields.put("mty_trsp_cre_bse_if_amt", "mtyTrspCreBseIfAmt");
		this.hashFields.put("mty_tml_cre_bse_if_amt", "mtyTmlCreBseIfAmt");
		this.hashFields.put("mty_tml_mnl_amt", "mtyTmlMnlAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mty_repo_cre_dt", "mtyRepoCreDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("aply_adj_pl_flg", "aplyAdjPlFlg");
		this.hashFields.put("cost_yr", "costYr");
		this.hashFields.put("mty_trsp_if_amt", "mtyTrspIfAmt");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("mt_trans", "mtTrans");
		this.hashFields.put("mty_ttl_if_amt", "mtyTtlIfAmt");
		this.hashFields.put("mty_tml_if_amt", "mtyTmlIfAmt");
		this.hashFields.put("rev_mon", "revMon");
		this.hashFields.put("sel_flg", "selFlg");
		this.hashFields.put("mt_steve", "mtSteve");
		this.hashFields.put("mty_ttl_mnl_amt", "mtyTtlMnlAmt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return slsFmDt
	 */
	public String getSlsFmDt() {
		return this.slsFmDt;
	}
	
	/**
	 * Column Info
	 * @return mtyTtlCreIfAmt
	 */
	public String getMtyTtlCreIfAmt() {
		return this.mtyTtlCreIfAmt;
	}
	
	/**
	 * Column Info
	 * @return mtyTrspMnlAmt
	 */
	public String getMtyTrspMnlAmt() {
		return this.mtyTrspMnlAmt;
	}
	
	/**
	 * Column Info
	 * @return ttlAmt
	 */
	public String getTtlAmt() {
		return this.ttlAmt;
	}
	
	/**
	 * Column Info
	 * @return mtyTrspCreBseIfAmt
	 */
	public String getMtyTrspCreBseIfAmt() {
		return this.mtyTrspCreBseIfAmt;
	}
	
	/**
	 * Column Info
	 * @return mtyTmlCreBseIfAmt
	 */
	public String getMtyTmlCreBseIfAmt() {
		return this.mtyTmlCreBseIfAmt;
	}
	
	/**
	 * Column Info
	 * @return mtyTmlMnlAmt
	 */
	public String getMtyTmlMnlAmt() {
		return this.mtyTmlMnlAmt;
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
	 * @return mtyRepoCreDt
	 */
	public String getMtyRepoCreDt() {
		return this.mtyRepoCreDt;
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
	 * @return aplyAdjPlFlg
	 */
	public String getAplyAdjPlFlg() {
		return this.aplyAdjPlFlg;
	}
	
	/**
	 * Column Info
	 * @return costYr
	 */
	public String getCostYr() {
		return this.costYr;
	}
	
	/**
	 * Column Info
	 * @return mtyTrspIfAmt
	 */
	public String getMtyTrspIfAmt() {
		return this.mtyTrspIfAmt;
	}
	
	/**
	 * Column Info
	 * @return costWk
	 */
	public String getCostWk() {
		return this.costWk;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return mtTrans
	 */
	public String getMtTrans() {
		return this.mtTrans;
	}
	
	/**
	 * Column Info
	 * @return mtyTtlIfAmt
	 */
	public String getMtyTtlIfAmt() {
		return this.mtyTtlIfAmt;
	}
	
	/**
	 * Column Info
	 * @return mtyTmlIfAmt
	 */
	public String getMtyTmlIfAmt() {
		return this.mtyTmlIfAmt;
	}
	
	/**
	 * Column Info
	 * @return revMon
	 */
	public String getRevMon() {
		return this.revMon;
	}
	
	/**
	 * Column Info
	 * @return selFlg
	 */
	public String getSelFlg() {
		return this.selFlg;
	}
	
	/**
	 * Column Info
	 * @return mtSteve
	 */
	public String getMtSteve() {
		return this.mtSteve;
	}
	
	/**
	 * Column Info
	 * @return mtyTtlMnlAmt
	 */
	public String getMtyTtlMnlAmt() {
		return this.mtyTtlMnlAmt;
	}
	

	/**
	 * Column Info
	 * @param slsFmDt
	 */
	public void setSlsFmDt(String slsFmDt) {
		this.slsFmDt = slsFmDt;
	}
	
	/**
	 * Column Info
	 * @param mtyTtlCreIfAmt
	 */
	public void setMtyTtlCreIfAmt(String mtyTtlCreIfAmt) {
		this.mtyTtlCreIfAmt = mtyTtlCreIfAmt;
	}
	
	/**
	 * Column Info
	 * @param mtyTrspMnlAmt
	 */
	public void setMtyTrspMnlAmt(String mtyTrspMnlAmt) {
		this.mtyTrspMnlAmt = mtyTrspMnlAmt;
	}
	
	/**
	 * Column Info
	 * @param ttlAmt
	 */
	public void setTtlAmt(String ttlAmt) {
		this.ttlAmt = ttlAmt;
	}
	
	/**
	 * Column Info
	 * @param mtyTrspCreBseIfAmt
	 */
	public void setMtyTrspCreBseIfAmt(String mtyTrspCreBseIfAmt) {
		this.mtyTrspCreBseIfAmt = mtyTrspCreBseIfAmt;
	}
	
	/**
	 * Column Info
	 * @param mtyTmlCreBseIfAmt
	 */
	public void setMtyTmlCreBseIfAmt(String mtyTmlCreBseIfAmt) {
		this.mtyTmlCreBseIfAmt = mtyTmlCreBseIfAmt;
	}
	
	/**
	 * Column Info
	 * @param mtyTmlMnlAmt
	 */
	public void setMtyTmlMnlAmt(String mtyTmlMnlAmt) {
		this.mtyTmlMnlAmt = mtyTmlMnlAmt;
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
	 * @param mtyRepoCreDt
	 */
	public void setMtyRepoCreDt(String mtyRepoCreDt) {
		this.mtyRepoCreDt = mtyRepoCreDt;
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
	 * @param aplyAdjPlFlg
	 */
	public void setAplyAdjPlFlg(String aplyAdjPlFlg) {
		this.aplyAdjPlFlg = aplyAdjPlFlg;
	}
	
	/**
	 * Column Info
	 * @param costYr
	 */
	public void setCostYr(String costYr) {
		this.costYr = costYr;
	}
	
	/**
	 * Column Info
	 * @param mtyTrspIfAmt
	 */
	public void setMtyTrspIfAmt(String mtyTrspIfAmt) {
		this.mtyTrspIfAmt = mtyTrspIfAmt;
	}
	
	/**
	 * Column Info
	 * @param costWk
	 */
	public void setCostWk(String costWk) {
		this.costWk = costWk;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param mtTrans
	 */
	public void setMtTrans(String mtTrans) {
		this.mtTrans = mtTrans;
	}
	
	/**
	 * Column Info
	 * @param mtyTtlIfAmt
	 */
	public void setMtyTtlIfAmt(String mtyTtlIfAmt) {
		this.mtyTtlIfAmt = mtyTtlIfAmt;
	}
	
	/**
	 * Column Info
	 * @param mtyTmlIfAmt
	 */
	public void setMtyTmlIfAmt(String mtyTmlIfAmt) {
		this.mtyTmlIfAmt = mtyTmlIfAmt;
	}
	
	/**
	 * Column Info
	 * @param revMon
	 */
	public void setRevMon(String revMon) {
		this.revMon = revMon;
	}
	
	/**
	 * Column Info
	 * @param selFlg
	 */
	public void setSelFlg(String selFlg) {
		this.selFlg = selFlg;
	}
	
	/**
	 * Column Info
	 * @param mtSteve
	 */
	public void setMtSteve(String mtSteve) {
		this.mtSteve = mtSteve;
	}
	
	/**
	 * Column Info
	 * @param mtyTtlMnlAmt
	 */
	public void setMtyTtlMnlAmt(String mtyTtlMnlAmt) {
		this.mtyTtlMnlAmt = mtyTtlMnlAmt;
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
		setSlsFmDt(JSPUtil.getParameter(request, prefix + "sls_fm_dt", ""));
		setMtyTtlCreIfAmt(JSPUtil.getParameter(request, prefix + "mty_ttl_cre_if_amt", ""));
		setMtyTrspMnlAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_mnl_amt", ""));
		setTtlAmt(JSPUtil.getParameter(request, prefix + "ttl_amt", ""));
		setMtyTrspCreBseIfAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_cre_bse_if_amt", ""));
		setMtyTmlCreBseIfAmt(JSPUtil.getParameter(request, prefix + "mty_tml_cre_bse_if_amt", ""));
		setMtyTmlMnlAmt(JSPUtil.getParameter(request, prefix + "mty_tml_mnl_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setMtyRepoCreDt(JSPUtil.getParameter(request, prefix + "mty_repo_cre_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setAplyAdjPlFlg(JSPUtil.getParameter(request, prefix + "aply_adj_pl_flg", ""));
		setCostYr(JSPUtil.getParameter(request, prefix + "cost_yr", ""));
		setMtyTrspIfAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_if_amt", ""));
		setCostWk(JSPUtil.getParameter(request, prefix + "cost_wk", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setMtTrans(JSPUtil.getParameter(request, prefix + "mt_trans", ""));
		setMtyTtlIfAmt(JSPUtil.getParameter(request, prefix + "mty_ttl_if_amt", ""));
		setMtyTmlIfAmt(JSPUtil.getParameter(request, prefix + "mty_tml_if_amt", ""));
		setRevMon(JSPUtil.getParameter(request, prefix + "rev_mon", ""));
		setSelFlg(JSPUtil.getParameter(request, prefix + "sel_flg", ""));
		setMtSteve(JSPUtil.getParameter(request, prefix + "mt_steve", ""));
		setMtyTtlMnlAmt(JSPUtil.getParameter(request, prefix + "mty_ttl_mnl_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MtyRepoTESTRSCostVO[]
	 */
	public MtyRepoTESTRSCostVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MtyRepoTESTRSCostVO[]
	 */
	public MtyRepoTESTRSCostVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MtyRepoTESTRSCostVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] slsFmDt = (JSPUtil.getParameter(request, prefix	+ "sls_fm_dt", length));
			String[] mtyTtlCreIfAmt = (JSPUtil.getParameter(request, prefix	+ "mty_ttl_cre_if_amt", length));
			String[] mtyTrspMnlAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_mnl_amt", length));
			String[] ttlAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_amt", length));
			String[] mtyTrspCreBseIfAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_cre_bse_if_amt", length));
			String[] mtyTmlCreBseIfAmt = (JSPUtil.getParameter(request, prefix	+ "mty_tml_cre_bse_if_amt", length));
			String[] mtyTmlMnlAmt = (JSPUtil.getParameter(request, prefix	+ "mty_tml_mnl_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mtyRepoCreDt = (JSPUtil.getParameter(request, prefix	+ "mty_repo_cre_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] aplyAdjPlFlg = (JSPUtil.getParameter(request, prefix	+ "aply_adj_pl_flg", length));
			String[] costYr = (JSPUtil.getParameter(request, prefix	+ "cost_yr", length));
			String[] mtyTrspIfAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_if_amt", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] mtTrans = (JSPUtil.getParameter(request, prefix	+ "mt_trans", length));
			String[] mtyTtlIfAmt = (JSPUtil.getParameter(request, prefix	+ "mty_ttl_if_amt", length));
			String[] mtyTmlIfAmt = (JSPUtil.getParameter(request, prefix	+ "mty_tml_if_amt", length));
			String[] revMon = (JSPUtil.getParameter(request, prefix	+ "rev_mon", length));
			String[] selFlg = (JSPUtil.getParameter(request, prefix	+ "sel_flg", length));
			String[] mtSteve = (JSPUtil.getParameter(request, prefix	+ "mt_steve", length));
			String[] mtyTtlMnlAmt = (JSPUtil.getParameter(request, prefix	+ "mty_ttl_mnl_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new MtyRepoTESTRSCostVO();
				if (slsFmDt[i] != null)
					model.setSlsFmDt(slsFmDt[i]);
				if (mtyTtlCreIfAmt[i] != null)
					model.setMtyTtlCreIfAmt(mtyTtlCreIfAmt[i]);
				if (mtyTrspMnlAmt[i] != null)
					model.setMtyTrspMnlAmt(mtyTrspMnlAmt[i]);
				if (ttlAmt[i] != null)
					model.setTtlAmt(ttlAmt[i]);
				if (mtyTrspCreBseIfAmt[i] != null)
					model.setMtyTrspCreBseIfAmt(mtyTrspCreBseIfAmt[i]);
				if (mtyTmlCreBseIfAmt[i] != null)
					model.setMtyTmlCreBseIfAmt(mtyTmlCreBseIfAmt[i]);
				if (mtyTmlMnlAmt[i] != null)
					model.setMtyTmlMnlAmt(mtyTmlMnlAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mtyRepoCreDt[i] != null)
					model.setMtyRepoCreDt(mtyRepoCreDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (aplyAdjPlFlg[i] != null)
					model.setAplyAdjPlFlg(aplyAdjPlFlg[i]);
				if (costYr[i] != null)
					model.setCostYr(costYr[i]);
				if (mtyTrspIfAmt[i] != null)
					model.setMtyTrspIfAmt(mtyTrspIfAmt[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (mtTrans[i] != null)
					model.setMtTrans(mtTrans[i]);
				if (mtyTtlIfAmt[i] != null)
					model.setMtyTtlIfAmt(mtyTtlIfAmt[i]);
				if (mtyTmlIfAmt[i] != null)
					model.setMtyTmlIfAmt(mtyTmlIfAmt[i]);
				if (revMon[i] != null)
					model.setRevMon(revMon[i]);
				if (selFlg[i] != null)
					model.setSelFlg(selFlg[i]);
				if (mtSteve[i] != null)
					model.setMtSteve(mtSteve[i]);
				if (mtyTtlMnlAmt[i] != null)
					model.setMtyTtlMnlAmt(mtyTtlMnlAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMtyRepoTESTRSCostVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MtyRepoTESTRSCostVO[]
	 */
	public MtyRepoTESTRSCostVO[] getMtyRepoTESTRSCostVOs(){
		MtyRepoTESTRSCostVO[] vos = (MtyRepoTESTRSCostVO[])models.toArray(new MtyRepoTESTRSCostVO[models.size()]);
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
		this.slsFmDt = this.slsFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTtlCreIfAmt = this.mtyTtlCreIfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrspMnlAmt = this.mtyTrspMnlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlAmt = this.ttlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrspCreBseIfAmt = this.mtyTrspCreBseIfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTmlCreBseIfAmt = this.mtyTmlCreBseIfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTmlMnlAmt = this.mtyTmlMnlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyRepoCreDt = this.mtyRepoCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aplyAdjPlFlg = this.aplyAdjPlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYr = this.costYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrspIfAmt = this.mtyTrspIfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtTrans = this.mtTrans .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTtlIfAmt = this.mtyTtlIfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTmlIfAmt = this.mtyTmlIfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revMon = this.revMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selFlg = this.selFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtSteve = this.mtSteve .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTtlMnlAmt = this.mtyTtlMnlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
