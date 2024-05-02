/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchCostCodeListVO.java
*@FileTitle : SearchCostCodeListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.20
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.10.20 김기대 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo;

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
 * @author 김기대
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchCostCodeListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchCostCodeListVO> models = new ArrayList<SearchCostCodeListVO>();
	
	/* Column Info */
	private String mgrpCostCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String krnCostFullDesc = null;
	/* Column Info */
	private String raAcctCd = null;
	/* Column Info */
	private String sgrpCostCd = null;
	/* Column Info */
	private String raMnCostCd = null;
	/* Column Info */
	private String hirScpFlg = null;
	/* Column Info */
	private String stndCostNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String perfVwCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String raMnCostNm = null;
	/* Column Info */
	private String sgrpCostNm = null;
	/* Column Info */
	private String raSgrpCostCd = null;
	/* Column Info */
	private String raSgrpCostNm = null;
	/* Column Info */
	private String raPerfVwCd = null;
	/* Column Info */
	private String stndCostTpCd = null;
	/* Column Info */
	private String mgrpCostCdDesc = null;
	/* Column Info */
	private String stndCostCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchCostCodeListVO() {}

	public SearchCostCodeListVO(String ibflag, String pagerows, String deltFlg, String stndCostTpCd, String mgrpCostCd, String mgrpCostCdDesc, String sgrpCostCd, String sgrpCostNm, String stndCostCd, String stndCostNm, String perfVwCd, String hirScpFlg, String raMnCostCd, String raMnCostNm, String raSgrpCostCd, String raSgrpCostNm, String raAcctCd, String krnCostFullDesc, String raPerfVwCd) {
		this.mgrpCostCd = mgrpCostCd;
		this.deltFlg = deltFlg;
		this.krnCostFullDesc = krnCostFullDesc;
		this.raAcctCd = raAcctCd;
		this.sgrpCostCd = sgrpCostCd;
		this.raMnCostCd = raMnCostCd;
		this.hirScpFlg = hirScpFlg;
		this.stndCostNm = stndCostNm;
		this.pagerows = pagerows;
		this.perfVwCd = perfVwCd;
		this.ibflag = ibflag;
		this.raMnCostNm = raMnCostNm;
		this.sgrpCostNm = sgrpCostNm;
		this.raSgrpCostCd = raSgrpCostCd;
		this.raSgrpCostNm = raSgrpCostNm;
		this.raPerfVwCd = raPerfVwCd;
		this.stndCostTpCd = stndCostTpCd;
		this.mgrpCostCdDesc = mgrpCostCdDesc;
		this.stndCostCd = stndCostCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mgrp_cost_cd", getMgrpCostCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("krn_cost_full_desc", getKrnCostFullDesc());
		this.hashColumns.put("ra_acct_cd", getRaAcctCd());
		this.hashColumns.put("sgrp_cost_cd", getSgrpCostCd());
		this.hashColumns.put("ra_mn_cost_cd", getRaMnCostCd());
		this.hashColumns.put("hir_scp_flg", getHirScpFlg());
		this.hashColumns.put("stnd_cost_nm", getStndCostNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("perf_vw_cd", getPerfVwCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ra_mn_cost_nm", getRaMnCostNm());
		this.hashColumns.put("sgrp_cost_nm", getSgrpCostNm());
		this.hashColumns.put("ra_sgrp_cost_cd", getRaSgrpCostCd());
		this.hashColumns.put("ra_sgrp_cost_nm", getRaSgrpCostNm());
		this.hashColumns.put("ra_perf_vw_cd", getRaPerfVwCd());
		this.hashColumns.put("stnd_cost_tp_cd", getStndCostTpCd());
		this.hashColumns.put("mgrp_cost_cd_desc", getMgrpCostCdDesc());
		this.hashColumns.put("stnd_cost_cd", getStndCostCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mgrp_cost_cd", "mgrpCostCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("krn_cost_full_desc", "krnCostFullDesc");
		this.hashFields.put("ra_acct_cd", "raAcctCd");
		this.hashFields.put("sgrp_cost_cd", "sgrpCostCd");
		this.hashFields.put("ra_mn_cost_cd", "raMnCostCd");
		this.hashFields.put("hir_scp_flg", "hirScpFlg");
		this.hashFields.put("stnd_cost_nm", "stndCostNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("perf_vw_cd", "perfVwCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ra_mn_cost_nm", "raMnCostNm");
		this.hashFields.put("sgrp_cost_nm", "sgrpCostNm");
		this.hashFields.put("ra_sgrp_cost_cd", "raSgrpCostCd");
		this.hashFields.put("ra_sgrp_cost_nm", "raSgrpCostNm");
		this.hashFields.put("ra_perf_vw_cd", "raPerfVwCd");
		this.hashFields.put("stnd_cost_tp_cd", "stndCostTpCd");
		this.hashFields.put("mgrp_cost_cd_desc", "mgrpCostCdDesc");
		this.hashFields.put("stnd_cost_cd", "stndCostCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mgrpCostCd
	 */
	public String getMgrpCostCd() {
		return this.mgrpCostCd;
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
	 * @return krnCostFullDesc
	 */
	public String getKrnCostFullDesc() {
		return this.krnCostFullDesc;
	}
	
	/**
	 * Column Info
	 * @return raAcctCd
	 */
	public String getRaAcctCd() {
		return this.raAcctCd;
	}
	
	/**
	 * Column Info
	 * @return sgrpCostCd
	 */
	public String getSgrpCostCd() {
		return this.sgrpCostCd;
	}
	
	/**
	 * Column Info
	 * @return raMnCostCd
	 */
	public String getRaMnCostCd() {
		return this.raMnCostCd;
	}
	
	/**
	 * Column Info
	 * @return hirScpFlg
	 */
	public String getHirScpFlg() {
		return this.hirScpFlg;
	}
	
	/**
	 * Column Info
	 * @return stndCostNm
	 */
	public String getStndCostNm() {
		return this.stndCostNm;
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
	 * @return perfVwCd
	 */
	public String getPerfVwCd() {
		return this.perfVwCd;
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
	 * @return raMnCostNm
	 */
	public String getRaMnCostNm() {
		return this.raMnCostNm;
	}
	
	/**
	 * Column Info
	 * @return sgrpCostNm
	 */
	public String getSgrpCostNm() {
		return this.sgrpCostNm;
	}
	
	/**
	 * Column Info
	 * @return raSgrpCostCd
	 */
	public String getRaSgrpCostCd() {
		return this.raSgrpCostCd;
	}
	
	/**
	 * Column Info
	 * @return raSgrpCostNm
	 */
	public String getRaSgrpCostNm() {
		return this.raSgrpCostNm;
	}
	
	/**
	 * Column Info
	 * @return raPerfVwCd
	 */
	public String getRaPerfVwCd() {
		return this.raPerfVwCd;
	}
	
	/**
	 * Column Info
	 * @return stndCostTpCd
	 */
	public String getStndCostTpCd() {
		return this.stndCostTpCd;
	}
	
	/**
	 * Column Info
	 * @return mgrpCostCdDesc
	 */
	public String getMgrpCostCdDesc() {
		return this.mgrpCostCdDesc;
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
	 * @param mgrpCostCd
	 */
	public void setMgrpCostCd(String mgrpCostCd) {
		this.mgrpCostCd = mgrpCostCd;
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
	 * @param krnCostFullDesc
	 */
	public void setKrnCostFullDesc(String krnCostFullDesc) {
		this.krnCostFullDesc = krnCostFullDesc;
	}
	
	/**
	 * Column Info
	 * @param raAcctCd
	 */
	public void setRaAcctCd(String raAcctCd) {
		this.raAcctCd = raAcctCd;
	}
	
	/**
	 * Column Info
	 * @param sgrpCostCd
	 */
	public void setSgrpCostCd(String sgrpCostCd) {
		this.sgrpCostCd = sgrpCostCd;
	}
	
	/**
	 * Column Info
	 * @param raMnCostCd
	 */
	public void setRaMnCostCd(String raMnCostCd) {
		this.raMnCostCd = raMnCostCd;
	}
	
	/**
	 * Column Info
	 * @param hirScpFlg
	 */
	public void setHirScpFlg(String hirScpFlg) {
		this.hirScpFlg = hirScpFlg;
	}
	
	/**
	 * Column Info
	 * @param stndCostNm
	 */
	public void setStndCostNm(String stndCostNm) {
		this.stndCostNm = stndCostNm;
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
	 * @param perfVwCd
	 */
	public void setPerfVwCd(String perfVwCd) {
		this.perfVwCd = perfVwCd;
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
	 * @param raMnCostNm
	 */
	public void setRaMnCostNm(String raMnCostNm) {
		this.raMnCostNm = raMnCostNm;
	}
	
	/**
	 * Column Info
	 * @param sgrpCostNm
	 */
	public void setSgrpCostNm(String sgrpCostNm) {
		this.sgrpCostNm = sgrpCostNm;
	}
	
	/**
	 * Column Info
	 * @param raSgrpCostCd
	 */
	public void setRaSgrpCostCd(String raSgrpCostCd) {
		this.raSgrpCostCd = raSgrpCostCd;
	}
	
	/**
	 * Column Info
	 * @param raSgrpCostNm
	 */
	public void setRaSgrpCostNm(String raSgrpCostNm) {
		this.raSgrpCostNm = raSgrpCostNm;
	}
	
	/**
	 * Column Info
	 * @param raPerfVwCd
	 */
	public void setRaPerfVwCd(String raPerfVwCd) {
		this.raPerfVwCd = raPerfVwCd;
	}
	
	/**
	 * Column Info
	 * @param stndCostTpCd
	 */
	public void setStndCostTpCd(String stndCostTpCd) {
		this.stndCostTpCd = stndCostTpCd;
	}
	
	/**
	 * Column Info
	 * @param mgrpCostCdDesc
	 */
	public void setMgrpCostCdDesc(String mgrpCostCdDesc) {
		this.mgrpCostCdDesc = mgrpCostCdDesc;
	}
	
	/**
	 * Column Info
	 * @param stndCostCd
	 */
	public void setStndCostCd(String stndCostCd) {
		this.stndCostCd = stndCostCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setMgrpCostCd(JSPUtil.getParameter(request, "mgrp_cost_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setKrnCostFullDesc(JSPUtil.getParameter(request, "krn_cost_full_desc", ""));
		setRaAcctCd(JSPUtil.getParameter(request, "ra_acct_cd", ""));
		setSgrpCostCd(JSPUtil.getParameter(request, "sgrp_cost_cd", ""));
		setRaMnCostCd(JSPUtil.getParameter(request, "ra_mn_cost_cd", ""));
		setHirScpFlg(JSPUtil.getParameter(request, "hir_scp_flg", ""));
		setStndCostNm(JSPUtil.getParameter(request, "stnd_cost_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPerfVwCd(JSPUtil.getParameter(request, "perf_vw_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRaMnCostNm(JSPUtil.getParameter(request, "ra_mn_cost_nm", ""));
		setSgrpCostNm(JSPUtil.getParameter(request, "sgrp_cost_nm", ""));
		setRaSgrpCostCd(JSPUtil.getParameter(request, "ra_sgrp_cost_cd", ""));
		setRaSgrpCostNm(JSPUtil.getParameter(request, "ra_sgrp_cost_nm", ""));
		setRaPerfVwCd(JSPUtil.getParameter(request, "ra_perf_vw_cd", ""));
		setStndCostTpCd(JSPUtil.getParameter(request, "stnd_cost_tp_cd", ""));
		setMgrpCostCdDesc(JSPUtil.getParameter(request, "mgrp_cost_cd_desc", ""));
		setStndCostCd(JSPUtil.getParameter(request, "stnd_cost_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCostCodeListVO[]
	 */
	public SearchCostCodeListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCostCodeListVO[]
	 */
	public SearchCostCodeListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchCostCodeListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mgrpCostCd = (JSPUtil.getParameter(request, prefix	+ "mgrp_cost_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] krnCostFullDesc = (JSPUtil.getParameter(request, prefix	+ "krn_cost_full_desc", length));
			String[] raAcctCd = (JSPUtil.getParameter(request, prefix	+ "ra_acct_cd", length));
			String[] sgrpCostCd = (JSPUtil.getParameter(request, prefix	+ "sgrp_cost_cd", length));
			String[] raMnCostCd = (JSPUtil.getParameter(request, prefix	+ "ra_mn_cost_cd", length));
			String[] hirScpFlg = (JSPUtil.getParameter(request, prefix	+ "hir_scp_flg", length));
			String[] stndCostNm = (JSPUtil.getParameter(request, prefix	+ "stnd_cost_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] perfVwCd = (JSPUtil.getParameter(request, prefix	+ "perf_vw_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] raMnCostNm = (JSPUtil.getParameter(request, prefix	+ "ra_mn_cost_nm", length));
			String[] sgrpCostNm = (JSPUtil.getParameter(request, prefix	+ "sgrp_cost_nm", length));
			String[] raSgrpCostCd = (JSPUtil.getParameter(request, prefix	+ "ra_sgrp_cost_cd", length));
			String[] raSgrpCostNm = (JSPUtil.getParameter(request, prefix	+ "ra_sgrp_cost_nm", length));
			String[] raPerfVwCd = (JSPUtil.getParameter(request, prefix	+ "ra_perf_vw_cd", length));
			String[] stndCostTpCd = (JSPUtil.getParameter(request, prefix	+ "stnd_cost_tp_cd", length));
			String[] mgrpCostCdDesc = (JSPUtil.getParameter(request, prefix	+ "mgrp_cost_cd_desc", length));
			String[] stndCostCd = (JSPUtil.getParameter(request, prefix	+ "stnd_cost_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchCostCodeListVO();
				if (mgrpCostCd[i] != null)
					model.setMgrpCostCd(mgrpCostCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (krnCostFullDesc[i] != null)
					model.setKrnCostFullDesc(krnCostFullDesc[i]);
				if (raAcctCd[i] != null)
					model.setRaAcctCd(raAcctCd[i]);
				if (sgrpCostCd[i] != null)
					model.setSgrpCostCd(sgrpCostCd[i]);
				if (raMnCostCd[i] != null)
					model.setRaMnCostCd(raMnCostCd[i]);
				if (hirScpFlg[i] != null)
					model.setHirScpFlg(hirScpFlg[i]);
				if (stndCostNm[i] != null)
					model.setStndCostNm(stndCostNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (perfVwCd[i] != null)
					model.setPerfVwCd(perfVwCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (raMnCostNm[i] != null)
					model.setRaMnCostNm(raMnCostNm[i]);
				if (sgrpCostNm[i] != null)
					model.setSgrpCostNm(sgrpCostNm[i]);
				if (raSgrpCostCd[i] != null)
					model.setRaSgrpCostCd(raSgrpCostCd[i]);
				if (raSgrpCostNm[i] != null)
					model.setRaSgrpCostNm(raSgrpCostNm[i]);
				if (raPerfVwCd[i] != null)
					model.setRaPerfVwCd(raPerfVwCd[i]);
				if (stndCostTpCd[i] != null)
					model.setStndCostTpCd(stndCostTpCd[i]);
				if (mgrpCostCdDesc[i] != null)
					model.setMgrpCostCdDesc(mgrpCostCdDesc[i]);
				if (stndCostCd[i] != null)
					model.setStndCostCd(stndCostCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchCostCodeListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchCostCodeListVO[]
	 */
	public SearchCostCodeListVO[] getSearchCostCodeListVOs(){
		SearchCostCodeListVO[] vos = (SearchCostCodeListVO[])models.toArray(new SearchCostCodeListVO[models.size()]);
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
		this.mgrpCostCd = this.mgrpCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krnCostFullDesc = this.krnCostFullDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raAcctCd = this.raAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sgrpCostCd = this.sgrpCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raMnCostCd = this.raMnCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hirScpFlg = this.hirScpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndCostNm = this.stndCostNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perfVwCd = this.perfVwCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raMnCostNm = this.raMnCostNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sgrpCostNm = this.sgrpCostNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raSgrpCostCd = this.raSgrpCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raSgrpCostNm = this.raSgrpCostNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raPerfVwCd = this.raPerfVwCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndCostTpCd = this.stndCostTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgrpCostCdDesc = this.mgrpCostCdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndCostCd = this.stndCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
