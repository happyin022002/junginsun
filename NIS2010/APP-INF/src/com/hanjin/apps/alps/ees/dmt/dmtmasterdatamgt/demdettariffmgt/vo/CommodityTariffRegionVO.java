/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommodityTariffRegionVO.java
*@FileTitle : CommodityTariffRegionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.08.18 김태균 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo;

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
 * @author 김태균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CommodityTariffRegionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CommodityTariffRegionVO> models = new ArrayList<CommodityTariffRegionVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String xcldSunFlg = null;
	/* Column Info */
	private String xcldSatFlg = null;
	/* Column Info */
	private String orgDest = null;
	/* Column Info */
	private String cfmFlg = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cmdtAddDys = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String wknd2 = null;
	/* Column Info */
	private String expireChk = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String wknd1 = null;
	/* Column Info */
	private String xcldHolFlg = null;
	/* Column Info */
	private String updUsrNm = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String repCmdtCd = null;
	/* Column Info */
	private String cmdtTtlDys = null;
	/* Column Info */
	private String covrg = null;
	/* Page Number */
	private String trfMngUsrId = null;
	/* Page Number */
	private String trfMngUsrNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CommodityTariffRegionVO() {}

	public CommodityTariffRegionVO(String ibflag, String pagerows, String cfmFlg, String dmdtTrfCd, String covrg, String orgDest, String cmdtCd, String cmdtNm, String repCmdtCd, String effDt, String expDt, String cmdtAddDys, String cmdtTtlDys, String xcldSatFlg, String xcldSunFlg, String xcldHolFlg, String updDt, String updOfcCd, String updUsrNm, String expireChk, String wknd1, String wknd2, String trfMngUsrId, String trfMngUsrNm) {
		this.updDt = updDt;
		this.xcldSunFlg = xcldSunFlg;
		this.xcldSatFlg = xcldSatFlg;
		this.orgDest = orgDest;
		this.cfmFlg = cfmFlg;
		this.cmdtNm = cmdtNm;
		this.pagerows = pagerows;
		this.cmdtAddDys = cmdtAddDys;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.wknd2 = wknd2;
		this.expireChk = expireChk;
		this.cmdtCd = cmdtCd;
		this.expDt = expDt;
		this.wknd1 = wknd1;
		this.xcldHolFlg = xcldHolFlg;
		this.updUsrNm = updUsrNm;
		this.updOfcCd = updOfcCd;
		this.dmdtTrfCd = dmdtTrfCd;
		this.repCmdtCd = repCmdtCd;
		this.cmdtTtlDys = cmdtTtlDys;
		this.covrg = covrg;
		this.trfMngUsrId = trfMngUsrId;
		this.trfMngUsrNm = trfMngUsrNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("xcld_sun_flg", getXcldSunFlg());
		this.hashColumns.put("xcld_sat_flg", getXcldSatFlg());
		this.hashColumns.put("org_dest", getOrgDest());
		this.hashColumns.put("cfm_flg", getCfmFlg());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cmdt_add_dys", getCmdtAddDys());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("wknd2", getWknd2());
		this.hashColumns.put("expire_chk", getExpireChk());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("wknd1", getWknd1());
		this.hashColumns.put("xcld_hol_flg", getXcldHolFlg());
		this.hashColumns.put("upd_usr_nm", getUpdUsrNm());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("rep_cmdt_cd", getRepCmdtCd());
		this.hashColumns.put("cmdt_ttl_dys", getCmdtTtlDys());
		this.hashColumns.put("covrg", getCovrg());
		this.hashColumns.put("trf_mng_usr_id", getTrfMngUsrId());
		this.hashColumns.put("trf_mng_usr_nm", getTrfMngUsrNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("xcld_sun_flg", "xcldSunFlg");
		this.hashFields.put("xcld_sat_flg", "xcldSatFlg");
		this.hashFields.put("org_dest", "orgDest");
		this.hashFields.put("cfm_flg", "cfmFlg");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cmdt_add_dys", "cmdtAddDys");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("wknd2", "wknd2");
		this.hashFields.put("expire_chk", "expireChk");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("wknd1", "wknd1");
		this.hashFields.put("xcld_hol_flg", "xcldHolFlg");
		this.hashFields.put("upd_usr_nm", "updUsrNm");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("rep_cmdt_cd", "repCmdtCd");
		this.hashFields.put("cmdt_ttl_dys", "cmdtTtlDys");
		this.hashFields.put("covrg", "covrg");
		this.hashFields.put("trf_mng_usr_id", "trfMngUsrId");
		this.hashFields.put("trf_mng_usr_nm", "trfMngUsrNm");
		return this.hashFields;
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
	 * @return xcldSunFlg
	 */
	public String getXcldSunFlg() {
		return this.xcldSunFlg;
	}
	
	/**
	 * Column Info
	 * @return xcldSatFlg
	 */
	public String getXcldSatFlg() {
		return this.xcldSatFlg;
	}
	
	/**
	 * Column Info
	 * @return orgDest
	 */
	public String getOrgDest() {
		return this.orgDest;
	}
	
	/**
	 * Column Info
	 * @return cfmFlg
	 */
	public String getCfmFlg() {
		return this.cfmFlg;
	}
	
	/**
	 * Column Info
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
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
	 * @return cmdtAddDys
	 */
	public String getCmdtAddDys() {
		return this.cmdtAddDys;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return wknd2
	 */
	public String getWknd2() {
		return this.wknd2;
	}
	
	/**
	 * Column Info
	 * @return expireChk
	 */
	public String getExpireChk() {
		return this.expireChk;
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
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return wknd1
	 */
	public String getWknd1() {
		return this.wknd1;
	}
	
	/**
	 * Column Info
	 * @return xcldHolFlg
	 */
	public String getXcldHolFlg() {
		return this.xcldHolFlg;
	}
	
	/**
	 * Column Info
	 * @return updUsrNm
	 */
	public String getUpdUsrNm() {
		return this.updUsrNm;
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
	 * @return dmdtTrfCd
	 */
	public String getDmdtTrfCd() {
		return this.dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @return repCmdtCd
	 */
	public String getRepCmdtCd() {
		return this.repCmdtCd;
	}
	
	/**
	 * Column Info
	 * @return cmdtTtlDys
	 */
	public String getCmdtTtlDys() {
		return this.cmdtTtlDys;
	}
	
	/**
	 * Column Info
	 * @return covrg
	 */
	public String getCovrg() {
		return this.covrg;
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
	 * @param xcldSunFlg
	 */
	public void setXcldSunFlg(String xcldSunFlg) {
		this.xcldSunFlg = xcldSunFlg;
	}
	
	/**
	 * Column Info
	 * @param xcldSatFlg
	 */
	public void setXcldSatFlg(String xcldSatFlg) {
		this.xcldSatFlg = xcldSatFlg;
	}
	
	/**
	 * Column Info
	 * @param orgDest
	 */
	public void setOrgDest(String orgDest) {
		this.orgDest = orgDest;
	}
	
	/**
	 * Column Info
	 * @param cfmFlg
	 */
	public void setCfmFlg(String cfmFlg) {
		this.cfmFlg = cfmFlg;
	}
	
	/**
	 * Column Info
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
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
	 * @param cmdtAddDys
	 */
	public void setCmdtAddDys(String cmdtAddDys) {
		this.cmdtAddDys = cmdtAddDys;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param wknd2
	 */
	public void setWknd2(String wknd2) {
		this.wknd2 = wknd2;
	}
	
	/**
	 * Column Info
	 * @param expireChk
	 */
	public void setExpireChk(String expireChk) {
		this.expireChk = expireChk;
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
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param wknd1
	 */
	public void setWknd1(String wknd1) {
		this.wknd1 = wknd1;
	}
	
	/**
	 * Column Info
	 * @param xcldHolFlg
	 */
	public void setXcldHolFlg(String xcldHolFlg) {
		this.xcldHolFlg = xcldHolFlg;
	}
	
	/**
	 * Column Info
	 * @param updUsrNm
	 */
	public void setUpdUsrNm(String updUsrNm) {
		this.updUsrNm = updUsrNm;
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
	 * @param dmdtTrfCd
	 */
	public void setDmdtTrfCd(String dmdtTrfCd) {
		this.dmdtTrfCd = dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @param repCmdtCd
	 */
	public void setRepCmdtCd(String repCmdtCd) {
		this.repCmdtCd = repCmdtCd;
	}
	
	/**
	 * Column Info
	 * @param cmdtTtlDys
	 */
	public void setCmdtTtlDys(String cmdtTtlDys) {
		this.cmdtTtlDys = cmdtTtlDys;
	}
	
	/**
	 * Column Info
	 * @param covrg
	 */
	public void setCovrg(String covrg) {
		this.covrg = covrg;
	}
	
	public String getTrfMngUsrId() {
		return trfMngUsrId;
	}

	public void setTrfMngUsrId(String trfMngUsrId) {
		this.trfMngUsrId = trfMngUsrId;
	}

	public String getTrfMngUsrNm() {
		return trfMngUsrNm;
	}

	public void setTrfMngUsrNm(String trfMngUsrNm) {
		this.trfMngUsrNm = trfMngUsrNm;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setXcldSunFlg(JSPUtil.getParameter(request, "xcld_sun_flg", ""));
		setXcldSatFlg(JSPUtil.getParameter(request, "xcld_sat_flg", ""));
		setOrgDest(JSPUtil.getParameter(request, "org_dest", ""));
		setCfmFlg(JSPUtil.getParameter(request, "cfm_flg", ""));
		setCmdtNm(JSPUtil.getParameter(request, "cmdt_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCmdtAddDys(JSPUtil.getParameter(request, "cmdt_add_dys", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setWknd2(JSPUtil.getParameter(request, "wknd2", ""));
		setExpireChk(JSPUtil.getParameter(request, "expire_chk", ""));
		setCmdtCd(JSPUtil.getParameter(request, "cmdt_cd", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setWknd1(JSPUtil.getParameter(request, "wknd1", ""));
		setXcldHolFlg(JSPUtil.getParameter(request, "xcld_hol_flg", ""));
		setUpdUsrNm(JSPUtil.getParameter(request, "upd_usr_nm", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, "upd_ofc_cd", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, "dmdt_trf_cd", ""));
		setRepCmdtCd(JSPUtil.getParameter(request, "rep_cmdt_cd", ""));
		setCmdtTtlDys(JSPUtil.getParameter(request, "cmdt_ttl_dys", ""));
		setCovrg(JSPUtil.getParameter(request, "covrg", ""));
		setTrfMngUsrId(JSPUtil.getParameter(request, "trf_mng_usr_id", ""));
		setTrfMngUsrNm(JSPUtil.getParameter(request, "trf_mng_usr_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CommodityTariffRegionVO[]
	 */
	public CommodityTariffRegionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CommodityTariffRegionVO[]
	 */
	public CommodityTariffRegionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CommodityTariffRegionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] xcldSunFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_sun_flg", length));
			String[] xcldSatFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_sat_flg", length));
			String[] orgDest = (JSPUtil.getParameter(request, prefix	+ "org_dest", length));
			String[] cfmFlg = (JSPUtil.getParameter(request, prefix	+ "cfm_flg", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cmdtAddDys = (JSPUtil.getParameter(request, prefix	+ "cmdt_add_dys", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] wknd2 = (JSPUtil.getParameter(request, prefix	+ "wknd2", length));
			String[] expireChk = (JSPUtil.getParameter(request, prefix	+ "expire_chk", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] wknd1 = (JSPUtil.getParameter(request, prefix	+ "wknd1", length));
			String[] xcldHolFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_hol_flg", length));
			String[] updUsrNm = (JSPUtil.getParameter(request, prefix	+ "upd_usr_nm", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] repCmdtCd = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt_cd", length));
			String[] cmdtTtlDys = (JSPUtil.getParameter(request, prefix	+ "cmdt_ttl_dys", length));
			String[] covrg = (JSPUtil.getParameter(request, prefix	+ "covrg", length));
			String[] trfMngUsrId = (JSPUtil.getParameter(request, prefix	+ "trf_mng_usr_id", length));
			String[] trfMngUsrNm = (JSPUtil.getParameter(request, prefix	+ "trf_mng_usr_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new CommodityTariffRegionVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (xcldSunFlg[i] != null)
					model.setXcldSunFlg(xcldSunFlg[i]);
				if (xcldSatFlg[i] != null)
					model.setXcldSatFlg(xcldSatFlg[i]);
				if (orgDest[i] != null)
					model.setOrgDest(orgDest[i]);
				if (cfmFlg[i] != null)
					model.setCfmFlg(cfmFlg[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cmdtAddDys[i] != null)
					model.setCmdtAddDys(cmdtAddDys[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (wknd2[i] != null)
					model.setWknd2(wknd2[i]);
				if (expireChk[i] != null)
					model.setExpireChk(expireChk[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (wknd1[i] != null)
					model.setWknd1(wknd1[i]);
				if (xcldHolFlg[i] != null)
					model.setXcldHolFlg(xcldHolFlg[i]);
				if (updUsrNm[i] != null)
					model.setUpdUsrNm(updUsrNm[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (repCmdtCd[i] != null)
					model.setRepCmdtCd(repCmdtCd[i]);
				if (cmdtTtlDys[i] != null)
					model.setCmdtTtlDys(cmdtTtlDys[i]);
				if (covrg[i] != null)
					model.setCovrg(covrg[i]);
				if (trfMngUsrId[i] != null)
					model.setTrfMngUsrId(trfMngUsrId[i]);
				if (trfMngUsrNm[i] != null)
					model.setTrfMngUsrNm(trfMngUsrNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCommodityTariffRegionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CommodityTariffRegionVO[]
	 */
	public CommodityTariffRegionVO[] getCommodityTariffRegionVOs(){
		CommodityTariffRegionVO[] vos = (CommodityTariffRegionVO[])models.toArray(new CommodityTariffRegionVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xcldSunFlg = this.xcldSunFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xcldSatFlg = this.xcldSatFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDest = this.orgDest .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmFlg = this.cfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtAddDys = this.cmdtAddDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wknd2 = this.wknd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expireChk = this.expireChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wknd1 = this.wknd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xcldHolFlg = this.xcldHolFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrNm = this.updUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtCd = this.repCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtTtlDys = this.cmdtTtlDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.covrg = this.covrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfMngUsrId = this.trfMngUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfMngUsrNm = this.trfMngUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
