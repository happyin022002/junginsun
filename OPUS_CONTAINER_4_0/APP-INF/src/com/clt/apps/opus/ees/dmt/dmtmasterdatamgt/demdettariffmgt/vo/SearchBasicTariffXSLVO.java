/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchBasicTariffXSLVO.java
*@FileTitle : SearchBasicTariffXSLVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.05
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2010.01.05 문중철 
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

public class SearchBasicTariffXSLVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchBasicTariffXSLVO> models = new ArrayList<SearchBasicTariffXSLVO>();
	
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String orgDest = null;
	/* Column Info */
	private String cmncHr = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String svrId = null;
	/* Column Info */
	private String dmdtBzcTrfGrpNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String trfGrpSeq = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String userOffice = null;
	/* Column Info */
	private String covrg = null;
	/* Column Info */
	private String trfSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchBasicTariffXSLVO() {}

	public SearchBasicTariffXSLVO(String ibflag, String pagerows, String svrId, String dmdtTrfCd, String covrg, String orgDest, String trfSeq, String trfGrpSeq, String dmdtBzcTrfGrpNm, String effDt, String expDt, String userOffice, String cmncHr, String currCd) {
		this.currCd = currCd;
		this.orgDest = orgDest;
		this.cmncHr = cmncHr;
		this.pagerows = pagerows;
		this.svrId = svrId;
		this.dmdtBzcTrfGrpNm = dmdtBzcTrfGrpNm;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.expDt = expDt;
		this.trfGrpSeq = trfGrpSeq;
		this.dmdtTrfCd = dmdtTrfCd;
		this.userOffice = userOffice;
		this.covrg = covrg;
		this.trfSeq = trfSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("org_dest", getOrgDest());
		this.hashColumns.put("cmnc_hr", getCmncHr());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("dmdt_bzc_trf_grp_nm", getDmdtBzcTrfGrpNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("trf_grp_seq", getTrfGrpSeq());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("user_office", getUserOffice());
		this.hashColumns.put("covrg", getCovrg());
		this.hashColumns.put("trf_seq", getTrfSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("org_dest", "orgDest");
		this.hashFields.put("cmnc_hr", "cmncHr");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("dmdt_bzc_trf_grp_nm", "dmdtBzcTrfGrpNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("trf_grp_seq", "trfGrpSeq");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("user_office", "userOffice");
		this.hashFields.put("covrg", "covrg");
		this.hashFields.put("trf_seq", "trfSeq");
		return this.hashFields;
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
	 * @return orgDest
	 */
	public String getOrgDest() {
		return this.orgDest;
	}
	
	/**
	 * Column Info
	 * @return cmncHr
	 */
	public String getCmncHr() {
		return this.cmncHr;
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
	 * @return svrId
	 */
	public String getSvrId() {
		return this.svrId;
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
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
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
	 * @return userOffice
	 */
	public String getUserOffice() {
		return this.userOffice;
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
	 * @return trfSeq
	 */
	public String getTrfSeq() {
		return this.trfSeq;
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
	 * @param orgDest
	 */
	public void setOrgDest(String orgDest) {
		this.orgDest = orgDest;
	}
	
	/**
	 * Column Info
	 * @param cmncHr
	 */
	public void setCmncHr(String cmncHr) {
		this.cmncHr = cmncHr;
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
	 * @param svrId
	 */
	public void setSvrId(String svrId) {
		this.svrId = svrId;
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
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
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
	 * @param userOffice
	 */
	public void setUserOffice(String userOffice) {
		this.userOffice = userOffice;
	}
	
	/**
	 * Column Info
	 * @param covrg
	 */
	public void setCovrg(String covrg) {
		this.covrg = covrg;
	}
	
	/**
	 * Column Info
	 * @param trfSeq
	 */
	public void setTrfSeq(String trfSeq) {
		this.trfSeq = trfSeq;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setOrgDest(JSPUtil.getParameter(request, "org_dest", ""));
		setCmncHr(JSPUtil.getParameter(request, "cmnc_hr", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSvrId(JSPUtil.getParameter(request, "svr_id", ""));
		setDmdtBzcTrfGrpNm(JSPUtil.getParameter(request, "dmdt_bzc_trf_grp_nm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setTrfGrpSeq(JSPUtil.getParameter(request, "trf_grp_seq", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, "dmdt_trf_cd", ""));
		setUserOffice(JSPUtil.getParameter(request, "user_office", ""));
		setCovrg(JSPUtil.getParameter(request, "covrg", ""));
		setTrfSeq(JSPUtil.getParameter(request, "trf_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchBasicTariffXSLVO[]
	 */
	public SearchBasicTariffXSLVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchBasicTariffXSLVO[]
	 */
	public SearchBasicTariffXSLVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchBasicTariffXSLVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] orgDest = (JSPUtil.getParameter(request, prefix	+ "org_dest", length));
			String[] cmncHr = (JSPUtil.getParameter(request, prefix	+ "cmnc_hr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id", length));
			String[] dmdtBzcTrfGrpNm = (JSPUtil.getParameter(request, prefix	+ "dmdt_bzc_trf_grp_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] trfGrpSeq = (JSPUtil.getParameter(request, prefix	+ "trf_grp_seq", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] userOffice = (JSPUtil.getParameter(request, prefix	+ "user_office", length));
			String[] covrg = (JSPUtil.getParameter(request, prefix	+ "covrg", length));
			String[] trfSeq = (JSPUtil.getParameter(request, prefix	+ "trf_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchBasicTariffXSLVO();
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (orgDest[i] != null)
					model.setOrgDest(orgDest[i]);
				if (cmncHr[i] != null)
					model.setCmncHr(cmncHr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (svrId[i] != null)
					model.setSvrId(svrId[i]);
				if (dmdtBzcTrfGrpNm[i] != null)
					model.setDmdtBzcTrfGrpNm(dmdtBzcTrfGrpNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (trfGrpSeq[i] != null)
					model.setTrfGrpSeq(trfGrpSeq[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (userOffice[i] != null)
					model.setUserOffice(userOffice[i]);
				if (covrg[i] != null)
					model.setCovrg(covrg[i]);
				if (trfSeq[i] != null)
					model.setTrfSeq(trfSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchBasicTariffXSLVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchBasicTariffXSLVO[]
	 */
	public SearchBasicTariffXSLVO[] getSearchBasicTariffXSLVOs(){
		SearchBasicTariffXSLVO[] vos = (SearchBasicTariffXSLVO[])models.toArray(new SearchBasicTariffXSLVO[models.size()]);
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
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDest = this.orgDest .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmncHr = this.cmncHr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtBzcTrfGrpNm = this.dmdtBzcTrfGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfGrpSeq = this.trfGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userOffice = this.userOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.covrg = this.covrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfSeq = this.trfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
