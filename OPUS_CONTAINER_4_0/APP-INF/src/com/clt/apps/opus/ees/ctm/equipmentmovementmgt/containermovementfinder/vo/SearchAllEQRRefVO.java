/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : searchAllEQRRefVO.java
*@FileTitle : searchAllEQRRefVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.15  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchAllEQRRefVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchAllEQRRefVO> models = new ArrayList<SearchAllEQRRefVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String plnYrwk = null;
	/* Column Info */
	private String item = null;
	/* Column Info */
	private String fmYd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fmLocCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String fmEccCd = null;
	/* Column Info */
	private String mtyBkgNo = null;
	/* Column Info */
	private String toYd = null;
	/* Column Info */
	private String repoPlnId = null;
	/* Column Info */
	private String etdEta = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String pDate1 = null;
	/* Column Info */
	private String toLocCd = null;
	/* Column Info */
	private String refId = null;
	/* Column Info */
	private String toEccCd = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String pDate2 = null;
	/* Column Info */
	private String eqType = null;
	/* Column Info */
	private String pEqType = null;
	/* Column Info */
	private String pItem = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchAllEQRRefVO() {}

	public SearchAllEQRRefVO(String ibflag, String pagerows, String repoPlnId, String mtyBkgNo, String refId, String vvd, String plnYrwk, String eqType, String pEqType, String pItem, String item, String fmYd, String fmDt, String toYd, String toDt, String pDate1, String pDate2, String etdEta, String fmEccCd, String toEccCd, String fmLocCd, String toLocCd) {
		this.pagerows = pagerows;
		this.plnYrwk = plnYrwk;
		this.item = item;
		this.fmYd = fmYd;
		this.ibflag = ibflag;
		this.fmLocCd = fmLocCd;
		this.vvd = vvd;
		this.fmEccCd = fmEccCd;
		this.mtyBkgNo = mtyBkgNo;
		this.toYd = toYd;
		this.repoPlnId = repoPlnId;
		this.etdEta = etdEta;
		this.fmDt = fmDt;
		this.pDate1 = pDate1;
		this.toLocCd = toLocCd;
		this.refId = refId;
		this.toEccCd = toEccCd;
		this.toDt = toDt;
		this.pDate2 = pDate2;
		this.eqType = eqType;
		this.pEqType = pEqType;
		this.pItem = pItem;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pln_yrwk", getPlnYrwk());
		this.hashColumns.put("item", getItem());
		this.hashColumns.put("fm_yd", getFmYd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fm_loc_cd", getFmLocCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("fm_ecc_cd", getFmEccCd());
		this.hashColumns.put("mty_bkg_no", getMtyBkgNo());
		this.hashColumns.put("to_yd", getToYd());
		this.hashColumns.put("repo_pln_id", getRepoPlnId());
		this.hashColumns.put("etd_eta", getEtdEta());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("p_date1", getPDate1());
		this.hashColumns.put("to_loc_cd", getToLocCd());
		this.hashColumns.put("ref_id", getRefId());
		this.hashColumns.put("to_ecc_cd", getToEccCd());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("p_date2", getPDate2());
		this.hashColumns.put("eq_type", getEqType());
		this.hashColumns.put("p_eq_type", getPEqType());
		this.hashColumns.put("p_item", getPItem());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pln_yrwk", "plnYrwk");
		this.hashFields.put("item", "item");
		this.hashFields.put("fm_yd", "fmYd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fm_loc_cd", "fmLocCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("fm_ecc_cd", "fmEccCd");
		this.hashFields.put("mty_bkg_no", "mtyBkgNo");
		this.hashFields.put("to_yd", "toYd");
		this.hashFields.put("repo_pln_id", "repoPlnId");
		this.hashFields.put("etd_eta", "etdEta");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("p_date1", "pDate1");
		this.hashFields.put("to_loc_cd", "toLocCd");
		this.hashFields.put("ref_id", "refId");
		this.hashFields.put("to_ecc_cd", "toEccCd");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("p_date2", "pDate2");
		this.hashFields.put("eq_type", "eqType");
		this.hashFields.put("p_eq_type", "pEqType");
		this.hashFields.put("p_item", "pItem");
		return this.hashFields;
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
	 * @return plnYrwk
	 */
	public String getPlnYrwk() {
		return this.plnYrwk;
	}
	
	/**
	 * Column Info
	 * @return item
	 */
	public String getItem() {
		return this.item;
	}
	
	/**
	 * Column Info
	 * @return fmYd
	 */
	public String getFmYd() {
		return this.fmYd;
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
	 * @return fmLocCd
	 */
	public String getFmLocCd() {
		return this.fmLocCd;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return fmEccCd
	 */
	public String getFmEccCd() {
		return this.fmEccCd;
	}
	
	/**
	 * Column Info
	 * @return mtyBkgNo
	 */
	public String getMtyBkgNo() {
		return this.mtyBkgNo;
	}
	
	/**
	 * Column Info
	 * @return toYd
	 */
	public String getToYd() {
		return this.toYd;
	}
	
	/**
	 * Column Info
	 * @return repoPlnId
	 */
	public String getRepoPlnId() {
		return this.repoPlnId;
	}
	
	/**
	 * Column Info
	 * @return etdEta
	 */
	public String getEtdEta() {
		return this.etdEta;
	}
	
	/**
	 * Column Info
	 * @return fmDt
	 */
	public String getFmDt() {
		return this.fmDt;
	}
	
	/**
	 * Column Info
	 * @return pDate1
	 */
	public String getPDate1() {
		return this.pDate1;
	}
	
	/**
	 * Column Info
	 * @return toLocCd
	 */
	public String getToLocCd() {
		return this.toLocCd;
	}
	
	/**
	 * Column Info
	 * @return refId
	 */
	public String getRefId() {
		return this.refId;
	}
	
	/**
	 * Column Info
	 * @return toEccCd
	 */
	public String getToEccCd() {
		return this.toEccCd;
	}
	
	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return pDate2
	 */
	public String getPDate2() {
		return this.pDate2;
	}
	
	/**
	 * Column Info
	 * @return eqType
	 */
	public String getEqType() {
		return this.eqType;
	}
	
	/**
	 * Column Info
	 * @return pEqType
	 */
	public String getPEqType() {
		return this.pEqType;
	}
	
	/**
	 * Column Info
	 * @return pItem
	 */
	public String getPItem() {
		return this.pItem;
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
	 * @param plnYrwk
	 */
	public void setPlnYrwk(String plnYrwk) {
		this.plnYrwk = plnYrwk;
	}
	
	/**
	 * Column Info
	 * @param item
	 */
	public void setItem(String item) {
		this.item = item;
	}
	
	/**
	 * Column Info
	 * @param fmYd
	 */
	public void setFmYd(String fmYd) {
		this.fmYd = fmYd;
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
	 * @param fmLocCd
	 */
	public void setFmLocCd(String fmLocCd) {
		this.fmLocCd = fmLocCd;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param fmEccCd
	 */
	public void setFmEccCd(String fmEccCd) {
		this.fmEccCd = fmEccCd;
	}
	
	/**
	 * Column Info
	 * @param mtyBkgNo
	 */
	public void setMtyBkgNo(String mtyBkgNo) {
		this.mtyBkgNo = mtyBkgNo;
	}
	
	/**
	 * Column Info
	 * @param toYd
	 */
	public void setToYd(String toYd) {
		this.toYd = toYd;
	}
	
	/**
	 * Column Info
	 * @param repoPlnId
	 */
	public void setRepoPlnId(String repoPlnId) {
		this.repoPlnId = repoPlnId;
	}
	
	/**
	 * Column Info
	 * @param etdEta
	 */
	public void setEtdEta(String etdEta) {
		this.etdEta = etdEta;
	}
	
	/**
	 * Column Info
	 * @param fmDt
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}
	
	/**
	 * Column Info
	 * @param pDate1
	 */
	public void setPDate1(String pDate1) {
		this.pDate1 = pDate1;
	}
	
	/**
	 * Column Info
	 * @param toLocCd
	 */
	public void setToLocCd(String toLocCd) {
		this.toLocCd = toLocCd;
	}
	
	/**
	 * Column Info
	 * @param refId
	 */
	public void setRefId(String refId) {
		this.refId = refId;
	}
	
	/**
	 * Column Info
	 * @param toEccCd
	 */
	public void setToEccCd(String toEccCd) {
		this.toEccCd = toEccCd;
	}
	
	/**
	 * Column Info
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param pDate2
	 */
	public void setPDate2(String pDate2) {
		this.pDate2 = pDate2;
	}
	
	/**
	 * Column Info
	 * @param eqType
	 */
	public void setEqType(String eqType) {
		this.eqType = eqType;
	}
	
	/**
	 * Column Info
	 * @param pEqType
	 */
	public void setPEqType(String pEqType) {
		this.pEqType = pEqType;
	}
	
	/**
	 * Column Info
	 * @param pItem
	 */
	public void setPItem(String pItem) {
		this.pItem = pItem;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPlnYrwk(JSPUtil.getParameter(request, prefix + "pln_yrwk", ""));
		setItem(JSPUtil.getParameter(request, prefix + "item", ""));
		setFmYd(JSPUtil.getParameter(request, prefix + "fm_yd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFmLocCd(JSPUtil.getParameter(request, prefix + "fm_loc_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setFmEccCd(JSPUtil.getParameter(request, prefix + "fm_ecc_cd", ""));
		setMtyBkgNo(JSPUtil.getParameter(request, prefix + "mty_bkg_no", ""));
		setToYd(JSPUtil.getParameter(request, prefix + "to_yd", ""));
		setRepoPlnId(JSPUtil.getParameter(request, prefix + "repo_pln_id", ""));
		setEtdEta(JSPUtil.getParameter(request, prefix + "etd_eta", ""));
		setFmDt(JSPUtil.getParameter(request, prefix + "fm_dt", ""));
		setPDate1(JSPUtil.getParameter(request, prefix + "p_date1", ""));
		setToLocCd(JSPUtil.getParameter(request, prefix + "to_loc_cd", ""));
		setRefId(JSPUtil.getParameter(request, prefix + "ref_id", ""));
		setToEccCd(JSPUtil.getParameter(request, prefix + "to_ecc_cd", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setPDate2(JSPUtil.getParameter(request, prefix + "p_date2", ""));
		setEqType(JSPUtil.getParameter(request, prefix + "eq_type", ""));
		setPEqType(JSPUtil.getParameter(request, prefix + "p_eq_type", ""));
		setPItem(JSPUtil.getParameter(request, prefix + "p_item", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return searchAllEQRRefVO[]
	 */
	public SearchAllEQRRefVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return searchAllEQRRefVO[]
	 */
	public SearchAllEQRRefVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchAllEQRRefVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] plnYrwk = (JSPUtil.getParameter(request, prefix	+ "pln_yrwk", length));
			String[] item = (JSPUtil.getParameter(request, prefix	+ "item", length));
			String[] fmYd = (JSPUtil.getParameter(request, prefix	+ "fm_yd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fmLocCd = (JSPUtil.getParameter(request, prefix	+ "fm_loc_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] fmEccCd = (JSPUtil.getParameter(request, prefix	+ "fm_ecc_cd", length));
			String[] mtyBkgNo = (JSPUtil.getParameter(request, prefix	+ "mty_bkg_no", length));
			String[] toYd = (JSPUtil.getParameter(request, prefix	+ "to_yd", length));
			String[] repoPlnId = (JSPUtil.getParameter(request, prefix	+ "repo_pln_id", length));
			String[] etdEta = (JSPUtil.getParameter(request, prefix	+ "etd_eta", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] pDate1 = (JSPUtil.getParameter(request, prefix	+ "p_date1", length));
			String[] toLocCd = (JSPUtil.getParameter(request, prefix	+ "to_loc_cd", length));
			String[] refId = (JSPUtil.getParameter(request, prefix	+ "ref_id", length));
			String[] toEccCd = (JSPUtil.getParameter(request, prefix	+ "to_ecc_cd", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] pDate2 = (JSPUtil.getParameter(request, prefix	+ "p_date2", length));
			String[] eqType = (JSPUtil.getParameter(request, prefix	+ "eq_type", length));
			String[] pEqType = (JSPUtil.getParameter(request, prefix	+ "p_eq_type", length));
			String[] pItem = (JSPUtil.getParameter(request, prefix	+ "p_item", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchAllEQRRefVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (plnYrwk[i] != null)
					model.setPlnYrwk(plnYrwk[i]);
				if (item[i] != null)
					model.setItem(item[i]);
				if (fmYd[i] != null)
					model.setFmYd(fmYd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fmLocCd[i] != null)
					model.setFmLocCd(fmLocCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (fmEccCd[i] != null)
					model.setFmEccCd(fmEccCd[i]);
				if (mtyBkgNo[i] != null)
					model.setMtyBkgNo(mtyBkgNo[i]);
				if (toYd[i] != null)
					model.setToYd(toYd[i]);
				if (repoPlnId[i] != null)
					model.setRepoPlnId(repoPlnId[i]);
				if (etdEta[i] != null)
					model.setEtdEta(etdEta[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (pDate1[i] != null)
					model.setPDate1(pDate1[i]);
				if (toLocCd[i] != null)
					model.setToLocCd(toLocCd[i]);
				if (refId[i] != null)
					model.setRefId(refId[i]);
				if (toEccCd[i] != null)
					model.setToEccCd(toEccCd[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (pDate2[i] != null)
					model.setPDate2(pDate2[i]);
				if (eqType[i] != null)
					model.setEqType(eqType[i]);
				if (pEqType[i] != null)
					model.setPEqType(pEqType[i]);
				if (pItem[i] != null)
					model.setPItem(pItem[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchAllEQRRefVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return searchAllEQRRefVO[]
	 */
	public SearchAllEQRRefVO[] getSearchAllEQRRefVOs(){
		SearchAllEQRRefVO[] vos = (SearchAllEQRRefVO[])models.toArray(new SearchAllEQRRefVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYrwk = this.plnYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.item = this.item .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmYd = this.fmYd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmLocCd = this.fmLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEccCd = this.fmEccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyBkgNo = this.mtyBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toYd = this.toYd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPlnId = this.repoPlnId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdEta = this.etdEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate1 = this.pDate1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toLocCd = this.toLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refId = this.refId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEccCd = this.toEccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate2 = this.pDate2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqType = this.eqType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pEqType = this.pEqType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pItem = this.pItem .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
