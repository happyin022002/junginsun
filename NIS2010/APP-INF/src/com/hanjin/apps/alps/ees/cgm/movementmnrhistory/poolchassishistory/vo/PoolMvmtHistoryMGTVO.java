/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PoolMvmtHistoryMGTVO.java
*@FileTitle : PoolMvmtHistoryMGTVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.04
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.11.04 최민회 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cgm.movementmnrhistory.poolchassishistory.vo;

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
 * @author 최민회
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PoolMvmtHistoryMGTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PoolMvmtHistoryMGTVO> models = new ArrayList<PoolMvmtHistoryMGTVO>();
	
	/* Column Info */
	private String chssPoolCd = null;
	/* Column Info */
	private String chssNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String poolUseCoCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String chssOwnrCoCd = null;
	/* Column Info */
	private String poolCoGateIoCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String eqTpszRepCd = null;
	/* Column Info */
	private String orgCoCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String cntrOwnrCoCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String ydComFlg = null;
	/* Column Info */
	private String chssTpszCd = null;
	/* Column Info */
	private String locNm = null;
	/* Column Info */
	private String mgstNo = null;
	/* Column Info */
	private String chssUseCoNm = null;
	/* Column Info */
	private String poolLocCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String poolChssCoCd = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String poolCoYdCd = null;
	/* Column Info */
	private String mvmtDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PoolMvmtHistoryMGTVO() {}

	public PoolMvmtHistoryMGTVO(String ibflag, String pagerows, String chssNo, String mvmtDt, String chssOwnrCoCd, String orgCoCd, String chssPoolCd, String chssTpszCd, String eqTpszRepCd, String ydCd, String ydComFlg, String locNm, String cntrNo, String cntrOwnrCoCd, String poolCoGateIoCd, String cntrTpszCd, String mgstNo, String chssUseCoNm, String poolCoYdCd, String creUsrId, String creDt, String updUsrId, String updDt, String poolUseCoCd, String poolChssCoCd, String poolLocCd) {
		this.chssPoolCd = chssPoolCd;
		this.chssNo = chssNo;
		this.creDt = creDt;
		this.poolUseCoCd = poolUseCoCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.chssOwnrCoCd = chssOwnrCoCd;
		this.poolCoGateIoCd = poolCoGateIoCd;
		this.cntrTpszCd = cntrTpszCd;
		this.eqTpszRepCd = eqTpszRepCd;
		this.orgCoCd = orgCoCd;
		this.updUsrId = updUsrId;
		this.cntrOwnrCoCd = cntrOwnrCoCd;
		this.updDt = updDt;
		this.ydComFlg = ydComFlg;
		this.chssTpszCd = chssTpszCd;
		this.locNm = locNm;
		this.mgstNo = mgstNo;
		this.chssUseCoNm = chssUseCoNm;
		this.poolLocCd = poolLocCd;
		this.creUsrId = creUsrId;
		this.poolChssCoCd = poolChssCoCd;
		this.ydCd = ydCd;
		this.cntrNo = cntrNo;
		this.poolCoYdCd = poolCoYdCd;
		this.mvmtDt = mvmtDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("chss_pool_cd", getChssPoolCd());
		this.hashColumns.put("chss_no", getChssNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pool_use_co_cd", getPoolUseCoCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("chss_ownr_co_cd", getChssOwnrCoCd());
		this.hashColumns.put("pool_co_gate_io_cd", getPoolCoGateIoCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("eq_tpsz_rep_cd", getEqTpszRepCd());
		this.hashColumns.put("org_co_cd", getOrgCoCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cntr_ownr_co_cd", getCntrOwnrCoCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("yd_com_flg", getYdComFlg());
		this.hashColumns.put("chss_tpsz_cd", getChssTpszCd());
		this.hashColumns.put("loc_nm", getLocNm());
		this.hashColumns.put("mgst_no", getMgstNo());
		this.hashColumns.put("chss_use_co_nm", getChssUseCoNm());
		this.hashColumns.put("pool_loc_cd", getPoolLocCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("pool_chss_co_cd", getPoolChssCoCd());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("pool_co_yd_cd", getPoolCoYdCd());
		this.hashColumns.put("mvmt_dt", getMvmtDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("chss_pool_cd", "chssPoolCd");
		this.hashFields.put("chss_no", "chssNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pool_use_co_cd", "poolUseCoCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("chss_ownr_co_cd", "chssOwnrCoCd");
		this.hashFields.put("pool_co_gate_io_cd", "poolCoGateIoCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("eq_tpsz_rep_cd", "eqTpszRepCd");
		this.hashFields.put("org_co_cd", "orgCoCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cntr_ownr_co_cd", "cntrOwnrCoCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("yd_com_flg", "ydComFlg");
		this.hashFields.put("chss_tpsz_cd", "chssTpszCd");
		this.hashFields.put("loc_nm", "locNm");
		this.hashFields.put("mgst_no", "mgstNo");
		this.hashFields.put("chss_use_co_nm", "chssUseCoNm");
		this.hashFields.put("pool_loc_cd", "poolLocCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("pool_chss_co_cd", "poolChssCoCd");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("pool_co_yd_cd", "poolCoYdCd");
		this.hashFields.put("mvmt_dt", "mvmtDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return chssPoolCd
	 */
	public String getChssPoolCd() {
		return this.chssPoolCd;
	}
	
	/**
	 * Column Info
	 * @return chssNo
	 */
	public String getChssNo() {
		return this.chssNo;
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
	 * @return poolUseCoCd
	 */
	public String getPoolUseCoCd() {
		return this.poolUseCoCd;
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
	 * @return chssOwnrCoCd
	 */
	public String getChssOwnrCoCd() {
		return this.chssOwnrCoCd;
	}
	
	/**
	 * Column Info
	 * @return poolCoGateIoCd
	 */
	public String getPoolCoGateIoCd() {
		return this.poolCoGateIoCd;
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
	 * @return eqTpszRepCd
	 */
	public String getEqTpszRepCd() {
		return this.eqTpszRepCd;
	}
	
	/**
	 * Column Info
	 * @return orgCoCd
	 */
	public String getOrgCoCd() {
		return this.orgCoCd;
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
	 * @return cntrOwnrCoCd
	 */
	public String getCntrOwnrCoCd() {
		return this.cntrOwnrCoCd;
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
	 * @return ydComFlg
	 */
	public String getYdComFlg() {
		return this.ydComFlg;
	}
	
	/**
	 * Column Info
	 * @return chssTpszCd
	 */
	public String getChssTpszCd() {
		return this.chssTpszCd;
	}
	
	/**
	 * Column Info
	 * @return locNm
	 */
	public String getLocNm() {
		return this.locNm;
	}
	
	/**
	 * Column Info
	 * @return mgstNo
	 */
	public String getMgstNo() {
		return this.mgstNo;
	}
	
	/**
	 * Column Info
	 * @return chssUseCoNm
	 */
	public String getChssUseCoNm() {
		return this.chssUseCoNm;
	}
	
	/**
	 * Column Info
	 * @return poolLocCd
	 */
	public String getPoolLocCd() {
		return this.poolLocCd;
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
	 * @return poolChssCoCd
	 */
	public String getPoolChssCoCd() {
		return this.poolChssCoCd;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return poolCoYdCd
	 */
	public String getPoolCoYdCd() {
		return this.poolCoYdCd;
	}
	
	/**
	 * Column Info
	 * @return mvmtDt
	 */
	public String getMvmtDt() {
		return this.mvmtDt;
	}
	

	/**
	 * Column Info
	 * @param chssPoolCd
	 */
	public void setChssPoolCd(String chssPoolCd) {
		this.chssPoolCd = chssPoolCd;
	}
	
	/**
	 * Column Info
	 * @param chssNo
	 */
	public void setChssNo(String chssNo) {
		this.chssNo = chssNo;
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
	 * @param poolUseCoCd
	 */
	public void setPoolUseCoCd(String poolUseCoCd) {
		this.poolUseCoCd = poolUseCoCd;
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
	 * @param chssOwnrCoCd
	 */
	public void setChssOwnrCoCd(String chssOwnrCoCd) {
		this.chssOwnrCoCd = chssOwnrCoCd;
	}
	
	/**
	 * Column Info
	 * @param poolCoGateIoCd
	 */
	public void setPoolCoGateIoCd(String poolCoGateIoCd) {
		this.poolCoGateIoCd = poolCoGateIoCd;
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
	 * @param eqTpszRepCd
	 */
	public void setEqTpszRepCd(String eqTpszRepCd) {
		this.eqTpszRepCd = eqTpszRepCd;
	}
	
	/**
	 * Column Info
	 * @param orgCoCd
	 */
	public void setOrgCoCd(String orgCoCd) {
		this.orgCoCd = orgCoCd;
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
	 * @param cntrOwnrCoCd
	 */
	public void setCntrOwnrCoCd(String cntrOwnrCoCd) {
		this.cntrOwnrCoCd = cntrOwnrCoCd;
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
	 * @param ydComFlg
	 */
	public void setYdComFlg(String ydComFlg) {
		this.ydComFlg = ydComFlg;
	}
	
	/**
	 * Column Info
	 * @param chssTpszCd
	 */
	public void setChssTpszCd(String chssTpszCd) {
		this.chssTpszCd = chssTpszCd;
	}
	
	/**
	 * Column Info
	 * @param locNm
	 */
	public void setLocNm(String locNm) {
		this.locNm = locNm;
	}
	
	/**
	 * Column Info
	 * @param mgstNo
	 */
	public void setMgstNo(String mgstNo) {
		this.mgstNo = mgstNo;
	}
	
	/**
	 * Column Info
	 * @param chssUseCoNm
	 */
	public void setChssUseCoNm(String chssUseCoNm) {
		this.chssUseCoNm = chssUseCoNm;
	}
	
	/**
	 * Column Info
	 * @param poolLocCd
	 */
	public void setPoolLocCd(String poolLocCd) {
		this.poolLocCd = poolLocCd;
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
	 * @param poolChssCoCd
	 */
	public void setPoolChssCoCd(String poolChssCoCd) {
		this.poolChssCoCd = poolChssCoCd;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param poolCoYdCd
	 */
	public void setPoolCoYdCd(String poolCoYdCd) {
		this.poolCoYdCd = poolCoYdCd;
	}
	
	/**
	 * Column Info
	 * @param mvmtDt
	 */
	public void setMvmtDt(String mvmtDt) {
		this.mvmtDt = mvmtDt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setChssPoolCd(JSPUtil.getParameter(request, "chss_pool_cd", ""));
		setChssNo(JSPUtil.getParameter(request, "chss_no", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setPoolUseCoCd(JSPUtil.getParameter(request, "pool_use_co_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setChssOwnrCoCd(JSPUtil.getParameter(request, "chss_ownr_co_cd", ""));
		setPoolCoGateIoCd(JSPUtil.getParameter(request, "pool_co_gate_io_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setEqTpszRepCd(JSPUtil.getParameter(request, "eq_tpsz_rep_cd", ""));
		setOrgCoCd(JSPUtil.getParameter(request, "org_co_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setCntrOwnrCoCd(JSPUtil.getParameter(request, "cntr_ownr_co_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setYdComFlg(JSPUtil.getParameter(request, "yd_com_flg", ""));
		setChssTpszCd(JSPUtil.getParameter(request, "chss_tpsz_cd", ""));
		setLocNm(JSPUtil.getParameter(request, "loc_nm", ""));
		setMgstNo(JSPUtil.getParameter(request, "mgst_no", ""));
		setChssUseCoNm(JSPUtil.getParameter(request, "chss_use_co_nm", ""));
		setPoolLocCd(JSPUtil.getParameter(request, "pool_loc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setPoolChssCoCd(JSPUtil.getParameter(request, "pool_chss_co_cd", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setPoolCoYdCd(JSPUtil.getParameter(request, "pool_co_yd_cd", ""));
		setMvmtDt(JSPUtil.getParameter(request, "mvmt_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PoolMvmtHistoryMGTVO[]
	 */
	public PoolMvmtHistoryMGTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PoolMvmtHistoryMGTVO[]
	 */
	public PoolMvmtHistoryMGTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PoolMvmtHistoryMGTVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] chssPoolCd = (JSPUtil.getParameter(request, prefix	+ "chss_pool_cd", length));
			String[] chssNo = (JSPUtil.getParameter(request, prefix	+ "chss_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] poolUseCoCd = (JSPUtil.getParameter(request, prefix	+ "pool_use_co_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] chssOwnrCoCd = (JSPUtil.getParameter(request, prefix	+ "chss_ownr_co_cd", length));
			String[] poolCoGateIoCd = (JSPUtil.getParameter(request, prefix	+ "pool_co_gate_io_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] eqTpszRepCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_rep_cd", length));
			String[] orgCoCd = (JSPUtil.getParameter(request, prefix	+ "org_co_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] cntrOwnrCoCd = (JSPUtil.getParameter(request, prefix	+ "cntr_ownr_co_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] ydComFlg = (JSPUtil.getParameter(request, prefix	+ "yd_com_flg", length));
			String[] chssTpszCd = (JSPUtil.getParameter(request, prefix	+ "chss_tpsz_cd", length));
			String[] locNm = (JSPUtil.getParameter(request, prefix	+ "loc_nm", length));
			String[] mgstNo = (JSPUtil.getParameter(request, prefix	+ "mgst_no", length));
			String[] chssUseCoNm = (JSPUtil.getParameter(request, prefix	+ "chss_use_co_nm", length));
			String[] poolLocCd = (JSPUtil.getParameter(request, prefix	+ "pool_loc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] poolChssCoCd = (JSPUtil.getParameter(request, prefix	+ "pool_chss_co_cd", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] poolCoYdCd = (JSPUtil.getParameter(request, prefix	+ "pool_co_yd_cd", length));
			String[] mvmtDt = (JSPUtil.getParameter(request, prefix	+ "mvmt_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new PoolMvmtHistoryMGTVO();
				if (chssPoolCd[i] != null)
					model.setChssPoolCd(chssPoolCd[i]);
				if (chssNo[i] != null)
					model.setChssNo(chssNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (poolUseCoCd[i] != null)
					model.setPoolUseCoCd(poolUseCoCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (chssOwnrCoCd[i] != null)
					model.setChssOwnrCoCd(chssOwnrCoCd[i]);
				if (poolCoGateIoCd[i] != null)
					model.setPoolCoGateIoCd(poolCoGateIoCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (eqTpszRepCd[i] != null)
					model.setEqTpszRepCd(eqTpszRepCd[i]);
				if (orgCoCd[i] != null)
					model.setOrgCoCd(orgCoCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (cntrOwnrCoCd[i] != null)
					model.setCntrOwnrCoCd(cntrOwnrCoCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ydComFlg[i] != null)
					model.setYdComFlg(ydComFlg[i]);
				if (chssTpszCd[i] != null)
					model.setChssTpszCd(chssTpszCd[i]);
				if (locNm[i] != null)
					model.setLocNm(locNm[i]);
				if (mgstNo[i] != null)
					model.setMgstNo(mgstNo[i]);
				if (chssUseCoNm[i] != null)
					model.setChssUseCoNm(chssUseCoNm[i]);
				if (poolLocCd[i] != null)
					model.setPoolLocCd(poolLocCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (poolChssCoCd[i] != null)
					model.setPoolChssCoCd(poolChssCoCd[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (poolCoYdCd[i] != null)
					model.setPoolCoYdCd(poolCoYdCd[i]);
				if (mvmtDt[i] != null)
					model.setMvmtDt(mvmtDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPoolMvmtHistoryMGTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PoolMvmtHistoryMGTVO[]
	 */
	public PoolMvmtHistoryMGTVO[] getPoolMvmtHistoryMGTVOs(){
		PoolMvmtHistoryMGTVO[] vos = (PoolMvmtHistoryMGTVO[])models.toArray(new PoolMvmtHistoryMGTVO[models.size()]);
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
		this.chssPoolCd = this.chssPoolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssNo = this.chssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poolUseCoCd = this.poolUseCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssOwnrCoCd = this.chssOwnrCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poolCoGateIoCd = this.poolCoGateIoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszRepCd = this.eqTpszRepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgCoCd = this.orgCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrOwnrCoCd = this.cntrOwnrCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydComFlg = this.ydComFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssTpszCd = this.chssTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locNm = this.locNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstNo = this.mgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssUseCoNm = this.chssUseCoNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poolLocCd = this.poolLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poolChssCoCd = this.poolChssCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poolCoYdCd = this.poolCoYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtDt = this.mvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
