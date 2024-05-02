/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchBasicTariffSummaryListVO.java
*@FileTitle : SearchBasicTariffSummaryListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.17
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.06.17 김태균 
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

public class SearchBasicTariffSummaryListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchBasicTariffSummaryListVO> models = new ArrayList<SearchBasicTariffSummaryListVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String orgDest = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String creUsrNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String dmdtBzcTrfGrpNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String expireChk = null;
	/* Column Info */
	private String cntrCgoCnt = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String cvrgCntCd = null;
	/* Column Info */
	private String updUsrNm = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String covrg = null;
	/* Column Info */
	private String dmdtDeTermCd = null;
	/* Column Info */
	private String dmdtDeTermNm = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchBasicTariffSummaryListVO() {}

	public SearchBasicTariffSummaryListVO(String ibflag, String pagerows, String cvrgCntCd, String covrg, String dmdtTrfCd, String orgDest, String dmdtBzcTrfGrpNm, String effDt, String expDt, String cntrCgoCnt, String creDt, String creOfcCd, String creUsrNm, String updDt, String updOfcCd, String updUsrNm, String expireChk, String dmdtDeTermCd, String dmdtDeTermNm) {
		this.updDt = updDt;
		this.orgDest = orgDest;
		this.creDt = creDt;
		this.creUsrNm = creUsrNm;
		this.pagerows = pagerows;
		this.dmdtBzcTrfGrpNm = dmdtBzcTrfGrpNm;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.expireChk = expireChk;
		this.cntrCgoCnt = cntrCgoCnt;
		this.creOfcCd = creOfcCd;
		this.expDt = expDt;
		this.cvrgCntCd = cvrgCntCd;
		this.updUsrNm = updUsrNm;
		this.updOfcCd = updOfcCd;
		this.dmdtTrfCd = dmdtTrfCd;
		this.covrg = covrg;
		this.dmdtDeTermCd = dmdtDeTermCd;
		this.dmdtDeTermNm = dmdtDeTermNm;
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("org_dest", getOrgDest());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cre_usr_nm", getCreUsrNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dmdt_bzc_trf_grp_nm", getDmdtBzcTrfGrpNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("expire_chk", getExpireChk());
		this.hashColumns.put("cntr_cgo_cnt", getCntrCgoCnt());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("cvrg_cnt_cd", getCvrgCntCd());
		this.hashColumns.put("upd_usr_nm", getUpdUsrNm());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("covrg", getCovrg());
		this.hashColumns.put("dmdt_de_term_cd", getDmdtDeTermCd());
		this.hashColumns.put("dmdt_de_term_nm", getDmdtDeTermNm());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("org_dest", "orgDest");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cre_usr_nm", "creUsrNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dmdt_bzc_trf_grp_nm", "dmdtBzcTrfGrpNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("expire_chk", "expireChk");
		this.hashFields.put("cntr_cgo_cnt", "cntrCgoCnt");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("cvrg_cnt_cd", "cvrgCntCd");
		this.hashFields.put("upd_usr_nm", "updUsrNm");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("covrg", "covrg");
		this.hashFields.put("dmdt_de_term_cd", "dmdtDeTermCd");
		this.hashFields.put("dmdt_de_term_nm", "dmdtDeTermNm");
		
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
	 * @return orgDest
	 */
	public String getOrgDest() {
		return this.orgDest;
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
	 * @return creUsrNm
	 */
	public String getCreUsrNm() {
		return this.creUsrNm;
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
	 * @return expireChk
	 */
	public String getExpireChk() {
		return this.expireChk;
	}
	
	/**
	 * Column Info
	 * @return cntrCgoCnt
	 */
	public String getCntrCgoCnt() {
		return this.cntrCgoCnt;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
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
	 * @return cvrgCntCd
	 */
	public String getCvrgCntCd() {
		return this.cvrgCntCd;
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
	 * @return covrg
	 */
	public String getCovrg() {
		return this.covrg;
	}
	
	/**
	 * Column Info
	 * @return dmdtDeTermCd
	 */
	public String getDmdtDeTermCd() {
		return this.dmdtDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtDeTermNm
	 */
	public String getDmdtDeTermNm() {
		return this.dmdtDeTermNm;
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
	 * @param orgDest
	 */
	public void setOrgDest(String orgDest) {
		this.orgDest = orgDest;
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
	 * @param creUsrNm
	 */
	public void setCreUsrNm(String creUsrNm) {
		this.creUsrNm = creUsrNm;
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
	 * @param expireChk
	 */
	public void setExpireChk(String expireChk) {
		this.expireChk = expireChk;
	}
	
	/**
	 * Column Info
	 * @param cntrCgoCnt
	 */
	public void setCntrCgoCnt(String cntrCgoCnt) {
		this.cntrCgoCnt = cntrCgoCnt;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
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
	 * @param cvrgCntCd
	 */
	public void setCvrgCntCd(String cvrgCntCd) {
		this.cvrgCntCd = cvrgCntCd;
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
	 * @param covrg
	 */
	public void setCovrg(String covrg) {
		this.covrg = covrg;
	}
	
	/**
	 * Column Info
	 * @param dmdtDeTermCd
	 */
	public void setDmdtDeTermCd(String dmdtDeTermCd) {
		this.dmdtDeTermCd = dmdtDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtDeTermNm
	 */
	public void setDmdtDeTermNm(String dmdtDeTermNm) {
		this.dmdtDeTermNm = dmdtDeTermNm;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setOrgDest(JSPUtil.getParameter(request, "org_dest", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setCreUsrNm(JSPUtil.getParameter(request, "cre_usr_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDmdtBzcTrfGrpNm(JSPUtil.getParameter(request, "dmdt_bzc_trf_grp_nm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setExpireChk(JSPUtil.getParameter(request, "expire_chk", ""));
		setCntrCgoCnt(JSPUtil.getParameter(request, "cntr_cgo_cnt", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setCvrgCntCd(JSPUtil.getParameter(request, "cvrg_cnt_cd", ""));
		setUpdUsrNm(JSPUtil.getParameter(request, "upd_usr_nm", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, "upd_ofc_cd", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, "dmdt_trf_cd", ""));
		setCovrg(JSPUtil.getParameter(request, "covrg", ""));
		setDmdtDeTermCd(JSPUtil.getParameter(request, "dmdt_de_term_cd", ""));
		setDmdtDeTermNm(JSPUtil.getParameter(request, "dmdt_de_term_cd", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchBasicTariffSummaryListVO[]
	 */
	public SearchBasicTariffSummaryListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchBasicTariffSummaryListVO[]
	 */
	public SearchBasicTariffSummaryListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchBasicTariffSummaryListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] orgDest = (JSPUtil.getParameter(request, prefix	+ "org_dest", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] creUsrNm = (JSPUtil.getParameter(request, prefix	+ "cre_usr_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] dmdtBzcTrfGrpNm = (JSPUtil.getParameter(request, prefix	+ "dmdt_bzc_trf_grp_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] expireChk = (JSPUtil.getParameter(request, prefix	+ "expire_chk", length));
			String[] cntrCgoCnt = (JSPUtil.getParameter(request, prefix	+ "cntr_cgo_cnt", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] cvrgCntCd = (JSPUtil.getParameter(request, prefix	+ "cvrg_cnt_cd", length));
			String[] updUsrNm = (JSPUtil.getParameter(request, prefix	+ "upd_usr_nm", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] covrg = (JSPUtil.getParameter(request, prefix	+ "covrg", length));
			String[] dmdtDeTermCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_de_term_cd", length));
			String[] dmdtDeTermNm = (JSPUtil.getParameter(request, prefix	+ "dmdt_de_term_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchBasicTariffSummaryListVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (orgDest[i] != null)
					model.setOrgDest(orgDest[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (creUsrNm[i] != null)
					model.setCreUsrNm(creUsrNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (dmdtBzcTrfGrpNm[i] != null)
					model.setDmdtBzcTrfGrpNm(dmdtBzcTrfGrpNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (expireChk[i] != null)
					model.setExpireChk(expireChk[i]);
				if (cntrCgoCnt[i] != null)
					model.setCntrCgoCnt(cntrCgoCnt[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (cvrgCntCd[i] != null)
					model.setCvrgCntCd(cvrgCntCd[i]);
				if (updUsrNm[i] != null)
					model.setUpdUsrNm(updUsrNm[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (covrg[i] != null)
					model.setCovrg(covrg[i]);
				if (dmdtDeTermCd[i] != null)
					model.setDmdtDeTermCd(dmdtDeTermCd[i]);
				if (dmdtDeTermNm[i] != null)
					model.setDmdtDeTermNm(dmdtDeTermNm[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchBasicTariffSummaryListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchBasicTariffSummaryListVO[]
	 */
	public SearchBasicTariffSummaryListVO[] getSearchBasicTariffSummaryListVOs(){
		SearchBasicTariffSummaryListVO[] vos = (SearchBasicTariffSummaryListVO[])models.toArray(new SearchBasicTariffSummaryListVO[models.size()]);
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
		this.orgDest = this.orgDest .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrNm = this.creUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtBzcTrfGrpNm = this.dmdtBzcTrfGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expireChk = this.expireChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCgoCnt = this.cntrCgoCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvrgCntCd = this.cvrgCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrNm = this.updUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.covrg = this.covrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtDeTermCd = this.dmdtDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtDeTermNm = this.dmdtDeTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
}
