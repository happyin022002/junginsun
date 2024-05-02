/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchBasicCmcbCoaUcPfmcVO.java
*@FileTitle : SearchBasicCmcbCoaUcPfmcVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.10
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2014.02.10 이혜민 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.csq.datamanage.costmanage.vo;

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
 * @author 이혜민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchBasicCmcbCoaUcPfmcVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchBasicCmcbCoaUcPfmcVO> models = new ArrayList<SearchBasicCmcbCoaUcPfmcVO>();
	
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String bseYr = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String iasRgnCd = null;
	/* Column Info */
	private String coaPaCmUcAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bseQtrCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String podCallSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String polCallSeq = null;
	/* Column Info */
	private String raCmUcAmt = null;
	/* Column Info */
	private String coaRaCmUcAmt = null;
	/* Column Info */
	private String bseTpCd = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String paCmUcAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchBasicCmcbCoaUcPfmcVO() {}

	public SearchBasicCmcbCoaUcPfmcVO(String ibflag, String pagerows, String bseTpCd, String bseYr, String bseQtrCd, String trdCd, String subTrdCd, String rlaneCd, String dirCd, String polCd, String podCd, String iasRgnCd, String coaPaCmUcAmt, String coaRaCmUcAmt, String paCmUcAmt, String raCmUcAmt, String polCallSeq, String podCallSeq) {
		this.trdCd = trdCd;
		this.bseYr = bseYr;
		this.rlaneCd = rlaneCd;
		this.iasRgnCd = iasRgnCd;
		this.coaPaCmUcAmt = coaPaCmUcAmt;
		this.pagerows = pagerows;
		this.bseQtrCd = bseQtrCd;
		this.podCd = podCd;
		this.podCallSeq = podCallSeq;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.polCallSeq = polCallSeq;
		this.raCmUcAmt = raCmUcAmt;
		this.coaRaCmUcAmt = coaRaCmUcAmt;
		this.bseTpCd = bseTpCd;
		this.dirCd = dirCd;
		this.subTrdCd = subTrdCd;
		this.paCmUcAmt = paCmUcAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("bse_yr", getBseYr());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("ias_rgn_cd", getIasRgnCd());
		this.hashColumns.put("coa_pa_cm_uc_amt", getCoaPaCmUcAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bse_qtr_cd", getBseQtrCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("pod_call_seq", getPodCallSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("pol_call_seq", getPolCallSeq());
		this.hashColumns.put("ra_cm_uc_amt", getRaCmUcAmt());
		this.hashColumns.put("coa_ra_cm_uc_amt", getCoaRaCmUcAmt());
		this.hashColumns.put("bse_tp_cd", getBseTpCd());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("pa_cm_uc_amt", getPaCmUcAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("bse_yr", "bseYr");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("ias_rgn_cd", "iasRgnCd");
		this.hashFields.put("coa_pa_cm_uc_amt", "coaPaCmUcAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bse_qtr_cd", "bseQtrCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("pod_call_seq", "podCallSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("pol_call_seq", "polCallSeq");
		this.hashFields.put("ra_cm_uc_amt", "raCmUcAmt");
		this.hashFields.put("coa_ra_cm_uc_amt", "coaRaCmUcAmt");
		this.hashFields.put("bse_tp_cd", "bseTpCd");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("pa_cm_uc_amt", "paCmUcAmt");
		return this.hashFields;
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
	 * @return bseYr
	 */
	public String getBseYr() {
		return this.bseYr;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return iasRgnCd
	 */
	public String getIasRgnCd() {
		return this.iasRgnCd;
	}
	
	/**
	 * Column Info
	 * @return coaPaCmUcAmt
	 */
	public String getCoaPaCmUcAmt() {
		return this.coaPaCmUcAmt;
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
	 * @return bseQtrCd
	 */
	public String getBseQtrCd() {
		return this.bseQtrCd;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return podCallSeq
	 */
	public String getPodCallSeq() {
		return this.podCallSeq;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return polCallSeq
	 */
	public String getPolCallSeq() {
		return this.polCallSeq;
	}
	
	/**
	 * Column Info
	 * @return raCmUcAmt
	 */
	public String getRaCmUcAmt() {
		return this.raCmUcAmt;
	}
	
	/**
	 * Column Info
	 * @return coaRaCmUcAmt
	 */
	public String getCoaRaCmUcAmt() {
		return this.coaRaCmUcAmt;
	}
	
	/**
	 * Column Info
	 * @return bseTpCd
	 */
	public String getBseTpCd() {
		return this.bseTpCd;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	
	/**
	 * Column Info
	 * @return paCmUcAmt
	 */
	public String getPaCmUcAmt() {
		return this.paCmUcAmt;
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
	 * @param bseYr
	 */
	public void setBseYr(String bseYr) {
		this.bseYr = bseYr;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param iasRgnCd
	 */
	public void setIasRgnCd(String iasRgnCd) {
		this.iasRgnCd = iasRgnCd;
	}
	
	/**
	 * Column Info
	 * @param coaPaCmUcAmt
	 */
	public void setCoaPaCmUcAmt(String coaPaCmUcAmt) {
		this.coaPaCmUcAmt = coaPaCmUcAmt;
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
	 * @param bseQtrCd
	 */
	public void setBseQtrCd(String bseQtrCd) {
		this.bseQtrCd = bseQtrCd;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param podCallSeq
	 */
	public void setPodCallSeq(String podCallSeq) {
		this.podCallSeq = podCallSeq;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param polCallSeq
	 */
	public void setPolCallSeq(String polCallSeq) {
		this.polCallSeq = polCallSeq;
	}
	
	/**
	 * Column Info
	 * @param raCmUcAmt
	 */
	public void setRaCmUcAmt(String raCmUcAmt) {
		this.raCmUcAmt = raCmUcAmt;
	}
	
	/**
	 * Column Info
	 * @param coaRaCmUcAmt
	 */
	public void setCoaRaCmUcAmt(String coaRaCmUcAmt) {
		this.coaRaCmUcAmt = coaRaCmUcAmt;
	}
	
	/**
	 * Column Info
	 * @param bseTpCd
	 */
	public void setBseTpCd(String bseTpCd) {
		this.bseTpCd = bseTpCd;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Column Info
	 * @param paCmUcAmt
	 */
	public void setPaCmUcAmt(String paCmUcAmt) {
		this.paCmUcAmt = paCmUcAmt;
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
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setBseYr(JSPUtil.getParameter(request, prefix + "bse_yr", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setIasRgnCd(JSPUtil.getParameter(request, prefix + "ias_rgn_cd", ""));
		setCoaPaCmUcAmt(JSPUtil.getParameter(request, prefix + "coa_pa_cm_uc_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBseQtrCd(JSPUtil.getParameter(request, prefix + "bse_qtr_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setPodCallSeq(JSPUtil.getParameter(request, prefix + "pod_call_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setPolCallSeq(JSPUtil.getParameter(request, prefix + "pol_call_seq", ""));
		setRaCmUcAmt(JSPUtil.getParameter(request, prefix + "ra_cm_uc_amt", ""));
		setCoaRaCmUcAmt(JSPUtil.getParameter(request, prefix + "coa_ra_cm_uc_amt", ""));
		setBseTpCd(JSPUtil.getParameter(request, prefix + "bse_tp_cd", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setPaCmUcAmt(JSPUtil.getParameter(request, prefix + "pa_cm_uc_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchBasicCmcbCoaUcPfmcVO[]
	 */
	public SearchBasicCmcbCoaUcPfmcVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchBasicCmcbCoaUcPfmcVO[]
	 */
	public SearchBasicCmcbCoaUcPfmcVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchBasicCmcbCoaUcPfmcVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] bseYr = (JSPUtil.getParameter(request, prefix	+ "bse_yr", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] iasRgnCd = (JSPUtil.getParameter(request, prefix	+ "ias_rgn_cd", length));
			String[] coaPaCmUcAmt = (JSPUtil.getParameter(request, prefix	+ "coa_pa_cm_uc_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bseQtrCd = (JSPUtil.getParameter(request, prefix	+ "bse_qtr_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] podCallSeq = (JSPUtil.getParameter(request, prefix	+ "pod_call_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] polCallSeq = (JSPUtil.getParameter(request, prefix	+ "pol_call_seq", length));
			String[] raCmUcAmt = (JSPUtil.getParameter(request, prefix	+ "ra_cm_uc_amt", length));
			String[] coaRaCmUcAmt = (JSPUtil.getParameter(request, prefix	+ "coa_ra_cm_uc_amt", length));
			String[] bseTpCd = (JSPUtil.getParameter(request, prefix	+ "bse_tp_cd", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] paCmUcAmt = (JSPUtil.getParameter(request, prefix	+ "pa_cm_uc_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchBasicCmcbCoaUcPfmcVO();
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (bseYr[i] != null)
					model.setBseYr(bseYr[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (iasRgnCd[i] != null)
					model.setIasRgnCd(iasRgnCd[i]);
				if (coaPaCmUcAmt[i] != null)
					model.setCoaPaCmUcAmt(coaPaCmUcAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bseQtrCd[i] != null)
					model.setBseQtrCd(bseQtrCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (podCallSeq[i] != null)
					model.setPodCallSeq(podCallSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (polCallSeq[i] != null)
					model.setPolCallSeq(polCallSeq[i]);
				if (raCmUcAmt[i] != null)
					model.setRaCmUcAmt(raCmUcAmt[i]);
				if (coaRaCmUcAmt[i] != null)
					model.setCoaRaCmUcAmt(coaRaCmUcAmt[i]);
				if (bseTpCd[i] != null)
					model.setBseTpCd(bseTpCd[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (paCmUcAmt[i] != null)
					model.setPaCmUcAmt(paCmUcAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchBasicCmcbCoaUcPfmcVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchBasicCmcbCoaUcPfmcVO[]
	 */
	public SearchBasicCmcbCoaUcPfmcVO[] getSearchBasicCmcbCoaUcPfmcVOs(){
		SearchBasicCmcbCoaUcPfmcVO[] vos = (SearchBasicCmcbCoaUcPfmcVO[])models.toArray(new SearchBasicCmcbCoaUcPfmcVO[models.size()]);
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
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYr = this.bseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iasRgnCd = this.iasRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaPaCmUcAmt = this.coaPaCmUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseQtrCd = this.bseQtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCallSeq = this.podCallSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCallSeq = this.polCallSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raCmUcAmt = this.raCmUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaRaCmUcAmt = this.coaRaCmUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseTpCd = this.bseTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paCmUcAmt = this.paCmUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
