/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SearchMovementListByEqrRefInfoVO.java
*@FileTitle : SearchMovementListByEqrRefInfoVO
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

public class SearchMovementListByEqrRefInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMovementListByEqrRefInfoVO> models = new ArrayList<SearchMovementListByEqrRefInfoVO>();
	
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
	private String mtyPlnNo = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String toYd = null;
	/* Column Info */
	private String repoPlnId = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String refId = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String eqType = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchMovementListByEqrRefInfoVO() {}

	public SearchMovementListByEqrRefInfoVO(String ibflag, String pagerows, String repoPlnId, String refId, String mtyPlnNo, String plnYrwk, String eqType, String item, String fmYd, String fmDt, String toYd, String toDt, String bkgNo) {
		this.pagerows = pagerows;
		this.plnYrwk = plnYrwk;
		this.item = item;
		this.fmYd = fmYd;
		this.ibflag = ibflag;
		this.mtyPlnNo = mtyPlnNo;
		this.bkgNo = bkgNo;
		this.toYd = toYd;
		this.repoPlnId = repoPlnId;
		this.fmDt = fmDt;
		this.refId = refId;
		this.toDt = toDt;
		this.eqType = eqType;
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
		this.hashColumns.put("mty_pln_no", getMtyPlnNo());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("to_yd", getToYd());
		this.hashColumns.put("repo_pln_id", getRepoPlnId());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("ref_id", getRefId());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("eq_type", getEqType());
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
		this.hashFields.put("mty_pln_no", "mtyPlnNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("to_yd", "toYd");
		this.hashFields.put("repo_pln_id", "repoPlnId");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("ref_id", "refId");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("eq_type", "eqType");
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
	 * @return mtyPlnNo
	 */
	public String getMtyPlnNo() {
		return this.mtyPlnNo;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return fmDt
	 */
	public String getFmDt() {
		return this.fmDt;
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
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return eqType
	 */
	public String getEqType() {
		return this.eqType;
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
	 * @param mtyPlnNo
	 */
	public void setMtyPlnNo(String mtyPlnNo) {
		this.mtyPlnNo = mtyPlnNo;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param fmDt
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
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
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param eqType
	 */
	public void setEqType(String eqType) {
		this.eqType = eqType;
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
		setMtyPlnNo(JSPUtil.getParameter(request, prefix + "mty_pln_no", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setToYd(JSPUtil.getParameter(request, prefix + "to_yd", ""));
		setRepoPlnId(JSPUtil.getParameter(request, prefix + "repo_pln_id", ""));
		setFmDt(JSPUtil.getParameter(request, prefix + "fm_dt", ""));
		setRefId(JSPUtil.getParameter(request, prefix + "ref_id", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setEqType(JSPUtil.getParameter(request, prefix + "eq_type", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMovementListByEqrRefInfoVO[]
	 */
	public SearchMovementListByEqrRefInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMovementListByEqrRefInfoVO[]
	 */
	public SearchMovementListByEqrRefInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMovementListByEqrRefInfoVO model = null;
		
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
			String[] mtyPlnNo = (JSPUtil.getParameter(request, prefix	+ "mty_pln_no", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] toYd = (JSPUtil.getParameter(request, prefix	+ "to_yd", length));
			String[] repoPlnId = (JSPUtil.getParameter(request, prefix	+ "repo_pln_id", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] refId = (JSPUtil.getParameter(request, prefix	+ "ref_id", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] eqType = (JSPUtil.getParameter(request, prefix	+ "eq_type", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMovementListByEqrRefInfoVO();
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
				if (mtyPlnNo[i] != null)
					model.setMtyPlnNo(mtyPlnNo[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (toYd[i] != null)
					model.setToYd(toYd[i]);
				if (repoPlnId[i] != null)
					model.setRepoPlnId(repoPlnId[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (refId[i] != null)
					model.setRefId(refId[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (eqType[i] != null)
					model.setEqType(eqType[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMovementListByEqrRefInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMovementListByEqrRefInfoVO[]
	 */
	public SearchMovementListByEqrRefInfoVO[] getSearchMovementListByEqrRefInfoVOs(){
		SearchMovementListByEqrRefInfoVO[] vos = (SearchMovementListByEqrRefInfoVO[])models.toArray(new SearchMovementListByEqrRefInfoVO[models.size()]);
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
		this.mtyPlnNo = this.mtyPlnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toYd = this.toYd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPlnId = this.repoPlnId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refId = this.refId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqType = this.eqType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
