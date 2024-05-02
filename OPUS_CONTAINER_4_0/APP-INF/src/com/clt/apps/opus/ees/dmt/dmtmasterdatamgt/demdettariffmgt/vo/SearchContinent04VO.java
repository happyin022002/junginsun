/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchContinent04VO.java
*@FileTitle : SearchContinent04VO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.30
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.12.30 문중철 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 문중철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchContinent04VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchContinent04VO> models = new ArrayList<SearchContinent04VO>();
	
	/* Column Info */
	private String xcldSatFlg = null;
	/* Column Info */
	private String xcldSunFlg = null;
	/* Column Info */
	private String orgDest = null;
	/* Column Info */
	private String dmdtChgCmncTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String dmdtBzcTrfGrpNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String wknd2 = null;
	/* Column Info */
	private String expireChk = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String wknd1 = null;
	/* Column Info */
	private String xcldHolFlg = null;
	/* Column Info */
	private String trfGrpSeq = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String covrg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchContinent04VO() {}

	public SearchContinent04VO(String ibflag, String pagerows, String dmdtTrfCd, String covrg, String orgDest, String trfGrpSeq, String dmdtBzcTrfGrpNm, String effDt, String expDt, String dmdtChgCmncTpCd, String xcldSatFlg, String xcldSunFlg, String xcldHolFlg, String expireChk, String wknd1, String wknd2) {
		this.xcldSatFlg = xcldSatFlg;
		this.xcldSunFlg = xcldSunFlg;
		this.orgDest = orgDest;
		this.dmdtChgCmncTpCd = dmdtChgCmncTpCd;
		this.pagerows = pagerows;
		this.dmdtBzcTrfGrpNm = dmdtBzcTrfGrpNm;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.wknd2 = wknd2;
		this.expireChk = expireChk;
		this.expDt = expDt;
		this.wknd1 = wknd1;
		this.xcldHolFlg = xcldHolFlg;
		this.trfGrpSeq = trfGrpSeq;
		this.dmdtTrfCd = dmdtTrfCd;
		this.covrg = covrg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("xcld_sat_flg", getXcldSatFlg());
		this.hashColumns.put("xcld_sun_flg", getXcldSunFlg());
		this.hashColumns.put("org_dest", getOrgDest());
		this.hashColumns.put("dmdt_chg_cmnc_tp_cd", getDmdtChgCmncTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dmdt_bzc_trf_grp_nm", getDmdtBzcTrfGrpNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("wknd2", getWknd2());
		this.hashColumns.put("expire_chk", getExpireChk());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("wknd1", getWknd1());
		this.hashColumns.put("xcld_hol_flg", getXcldHolFlg());
		this.hashColumns.put("trf_grp_seq", getTrfGrpSeq());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("covrg", getCovrg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("xcld_sat_flg", "xcldSatFlg");
		this.hashFields.put("xcld_sun_flg", "xcldSunFlg");
		this.hashFields.put("org_dest", "orgDest");
		this.hashFields.put("dmdt_chg_cmnc_tp_cd", "dmdtChgCmncTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dmdt_bzc_trf_grp_nm", "dmdtBzcTrfGrpNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("wknd2", "wknd2");
		this.hashFields.put("expire_chk", "expireChk");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("wknd1", "wknd1");
		this.hashFields.put("xcld_hol_flg", "xcldHolFlg");
		this.hashFields.put("trf_grp_seq", "trfGrpSeq");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("covrg", "covrg");
		return this.hashFields;
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
	 * @return xcldSunFlg
	 */
	public String getXcldSunFlg() {
		return this.xcldSunFlg;
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
	 * @return dmdtChgCmncTpCd
	 */
	public String getDmdtChgCmncTpCd() {
		return this.dmdtChgCmncTpCd;
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
	 * @return dmdtBzcTrfGrpNm
	 */
	public String getDmdtBzcTrfGrpNm() {
		return this.dmdtBzcTrfGrpNm;
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
	 * @return trfGrpSeq
	 */
	public String getTrfGrpSeq() {
		return this.trfGrpSeq;
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
	 * @return covrg
	 */
	public String getCovrg() {
		return this.covrg;
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
	 * @param xcldSunFlg
	 */
	public void setXcldSunFlg(String xcldSunFlg) {
		this.xcldSunFlg = xcldSunFlg;
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
	 * @param dmdtChgCmncTpCd
	 */
	public void setDmdtChgCmncTpCd(String dmdtChgCmncTpCd) {
		this.dmdtChgCmncTpCd = dmdtChgCmncTpCd;
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
	 * @param dmdtBzcTrfGrpNm
	 */
	public void setDmdtBzcTrfGrpNm(String dmdtBzcTrfGrpNm) {
		this.dmdtBzcTrfGrpNm = dmdtBzcTrfGrpNm;
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
	 * @param trfGrpSeq
	 */
	public void setTrfGrpSeq(String trfGrpSeq) {
		this.trfGrpSeq = trfGrpSeq;
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
	 * @param covrg
	 */
	public void setCovrg(String covrg) {
		this.covrg = covrg;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setXcldSatFlg(JSPUtil.getParameter(request, "xcld_sat_flg", ""));
		setXcldSunFlg(JSPUtil.getParameter(request, "xcld_sun_flg", ""));
		setOrgDest(JSPUtil.getParameter(request, "org_dest", ""));
		setDmdtChgCmncTpCd(JSPUtil.getParameter(request, "dmdt_chg_cmnc_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDmdtBzcTrfGrpNm(JSPUtil.getParameter(request, "dmdt_bzc_trf_grp_nm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setWknd2(JSPUtil.getParameter(request, "wknd2", ""));
		setExpireChk(JSPUtil.getParameter(request, "expire_chk", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setWknd1(JSPUtil.getParameter(request, "wknd1", ""));
		setXcldHolFlg(JSPUtil.getParameter(request, "xcld_hol_flg", ""));
		setTrfGrpSeq(JSPUtil.getParameter(request, "trf_grp_seq", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, "dmdt_trf_cd", ""));
		setCovrg(JSPUtil.getParameter(request, "covrg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchContinent04VO[]
	 */
	public SearchContinent04VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchContinent04VO[]
	 */
	public SearchContinent04VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchContinent04VO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] xcldSatFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_sat_flg", length));
			String[] xcldSunFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_sun_flg", length));
			String[] orgDest = (JSPUtil.getParameter(request, prefix	+ "org_dest", length));
			String[] dmdtChgCmncTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_cmnc_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] dmdtBzcTrfGrpNm = (JSPUtil.getParameter(request, prefix	+ "dmdt_bzc_trf_grp_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] wknd2 = (JSPUtil.getParameter(request, prefix	+ "wknd2", length));
			String[] expireChk = (JSPUtil.getParameter(request, prefix	+ "expire_chk", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] wknd1 = (JSPUtil.getParameter(request, prefix	+ "wknd1", length));
			String[] xcldHolFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_hol_flg", length));
			String[] trfGrpSeq = (JSPUtil.getParameter(request, prefix	+ "trf_grp_seq", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] covrg = (JSPUtil.getParameter(request, prefix	+ "covrg", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchContinent04VO();
				if (xcldSatFlg[i] != null)
					model.setXcldSatFlg(xcldSatFlg[i]);
				if (xcldSunFlg[i] != null)
					model.setXcldSunFlg(xcldSunFlg[i]);
				if (orgDest[i] != null)
					model.setOrgDest(orgDest[i]);
				if (dmdtChgCmncTpCd[i] != null)
					model.setDmdtChgCmncTpCd(dmdtChgCmncTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (dmdtBzcTrfGrpNm[i] != null)
					model.setDmdtBzcTrfGrpNm(dmdtBzcTrfGrpNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (wknd2[i] != null)
					model.setWknd2(wknd2[i]);
				if (expireChk[i] != null)
					model.setExpireChk(expireChk[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (wknd1[i] != null)
					model.setWknd1(wknd1[i]);
				if (xcldHolFlg[i] != null)
					model.setXcldHolFlg(xcldHolFlg[i]);
				if (trfGrpSeq[i] != null)
					model.setTrfGrpSeq(trfGrpSeq[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (covrg[i] != null)
					model.setCovrg(covrg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchContinent04VOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchContinent04VO[]
	 */
	public SearchContinent04VO[] getSearchContinent04VOs(){
		SearchContinent04VO[] vos = (SearchContinent04VO[])models.toArray(new SearchContinent04VO[models.size()]);
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
		this.xcldSatFlg = this.xcldSatFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xcldSunFlg = this.xcldSunFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDest = this.orgDest .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtChgCmncTpCd = this.dmdtChgCmncTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtBzcTrfGrpNm = this.dmdtBzcTrfGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wknd2 = this.wknd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expireChk = this.expireChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wknd1 = this.wknd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xcldHolFlg = this.xcldHolFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfGrpSeq = this.trfGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.covrg = this.covrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
