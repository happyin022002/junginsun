/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DocQueueSummaryJITCompletenceVO.java
*@FileTitle : DocQueueSummaryJITCompletenceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.03
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2011.06.03 김상수 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo;

import java.lang.reflect.Field;
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
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DocQueueSummaryJITCompletenceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DocQueueSummaryJITCompletenceVO> models = new ArrayList<DocQueueSummaryJITCompletenceVO>();
	
	/* Column Info */
	private String region = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String total = null;
	/* Column Info */
	private String ratePer = null;
	/* Column Info */
	private String bdrPer = null;
	/* Column Info */
	private String comFlag = null;
	/* Column Info */
	private String bdrFlag = null;
	/* Column Info */
	private String pctPer = null;
	/* Column Info */
	private String comPer = null;
	/* Column Info */
	private String kind = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dctPer = null;
	/* Column Info */
	private String rateFlag = null;
	/* Column Info */
	private String pctFlag = null;
	/* Column Info */
	private String dctFlag = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DocQueueSummaryJITCompletenceVO() {}

	public DocQueueSummaryJITCompletenceVO(String ibflag, String pagerows, String region, String bkgOfcCd, String kind, String total, String dctFlag, String dctPer, String pctFlag, String pctPer, String bdrFlag, String bdrPer, String rateFlag, String ratePer, String comFlag, String comPer) {
		this.region = region;
		this.bkgOfcCd = bkgOfcCd;
		this.total = total;
		this.ratePer = ratePer;
		this.bdrPer = bdrPer;
		this.comFlag = comFlag;
		this.bdrFlag = bdrFlag;
		this.pctPer = pctPer;
		this.comPer = comPer;
		this.kind = kind;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.dctPer = dctPer;
		this.rateFlag = rateFlag;
		this.pctFlag = pctFlag;
		this.dctFlag = dctFlag;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("region", getRegion());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("total", getTotal());
		this.hashColumns.put("rate_per", getRatePer());
		this.hashColumns.put("bdr_per", getBdrPer());
		this.hashColumns.put("com_flag", getComFlag());
		this.hashColumns.put("bdr_flag", getBdrFlag());
		this.hashColumns.put("pct_per", getPctPer());
		this.hashColumns.put("com_per", getComPer());
		this.hashColumns.put("kind", getKind());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dct_per", getDctPer());
		this.hashColumns.put("rate_flag", getRateFlag());
		this.hashColumns.put("pct_flag", getPctFlag());
		this.hashColumns.put("dct_flag", getDctFlag());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("region", "region");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("total", "total");
		this.hashFields.put("rate_per", "ratePer");
		this.hashFields.put("bdr_per", "bdrPer");
		this.hashFields.put("com_flag", "comFlag");
		this.hashFields.put("bdr_flag", "bdrFlag");
		this.hashFields.put("pct_per", "pctPer");
		this.hashFields.put("com_per", "comPer");
		this.hashFields.put("kind", "kind");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dct_per", "dctPer");
		this.hashFields.put("rate_flag", "rateFlag");
		this.hashFields.put("pct_flag", "pctFlag");
		this.hashFields.put("dct_flag", "dctFlag");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return region
	 */
	public String getRegion() {
		return this.region;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return total
	 */
	public String getTotal() {
		return this.total;
	}
	
	/**
	 * Column Info
	 * @return ratePer
	 */
	public String getRatePer() {
		return this.ratePer;
	}
	
	/**
	 * Column Info
	 * @return bdrPer
	 */
	public String getBdrPer() {
		return this.bdrPer;
	}
	
	/**
	 * Column Info
	 * @return comFlag
	 */
	public String getComFlag() {
		return this.comFlag;
	}
	
	/**
	 * Column Info
	 * @return bdrFlag
	 */
	public String getBdrFlag() {
		return this.bdrFlag;
	}
	
	/**
	 * Column Info
	 * @return pctPer
	 */
	public String getPctPer() {
		return this.pctPer;
	}
	
	/**
	 * Column Info
	 * @return comPer
	 */
	public String getComPer() {
		return this.comPer;
	}
	
	/**
	 * Column Info
	 * @return kind
	 */
	public String getKind() {
		return this.kind;
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
	 * @return dctPer
	 */
	public String getDctPer() {
		return this.dctPer;
	}
	
	/**
	 * Column Info
	 * @return rateFlag
	 */
	public String getRateFlag() {
		return this.rateFlag;
	}
	
	/**
	 * Column Info
	 * @return pctFlag
	 */
	public String getPctFlag() {
		return this.pctFlag;
	}
	
	/**
	 * Column Info
	 * @return dctFlag
	 */
	public String getDctFlag() {
		return this.dctFlag;
	}
	

	/**
	 * Column Info
	 * @param region
	 */
	public void setRegion(String region) {
		this.region = region;
	}
	
	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param total
	 */
	public void setTotal(String total) {
		this.total = total;
	}
	
	/**
	 * Column Info
	 * @param ratePer
	 */
	public void setRatePer(String ratePer) {
		this.ratePer = ratePer;
	}
	
	/**
	 * Column Info
	 * @param bdrPer
	 */
	public void setBdrPer(String bdrPer) {
		this.bdrPer = bdrPer;
	}
	
	/**
	 * Column Info
	 * @param comFlag
	 */
	public void setComFlag(String comFlag) {
		this.comFlag = comFlag;
	}
	
	/**
	 * Column Info
	 * @param bdrFlag
	 */
	public void setBdrFlag(String bdrFlag) {
		this.bdrFlag = bdrFlag;
	}
	
	/**
	 * Column Info
	 * @param pctPer
	 */
	public void setPctPer(String pctPer) {
		this.pctPer = pctPer;
	}
	
	/**
	 * Column Info
	 * @param comPer
	 */
	public void setComPer(String comPer) {
		this.comPer = comPer;
	}
	
	/**
	 * Column Info
	 * @param kind
	 */
	public void setKind(String kind) {
		this.kind = kind;
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
	 * @param dctPer
	 */
	public void setDctPer(String dctPer) {
		this.dctPer = dctPer;
	}
	
	/**
	 * Column Info
	 * @param rateFlag
	 */
	public void setRateFlag(String rateFlag) {
		this.rateFlag = rateFlag;
	}
	
	/**
	 * Column Info
	 * @param pctFlag
	 */
	public void setPctFlag(String pctFlag) {
		this.pctFlag = pctFlag;
	}
	
	/**
	 * Column Info
	 * @param dctFlag
	 */
	public void setDctFlag(String dctFlag) {
		this.dctFlag = dctFlag;
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
		setRegion(JSPUtil.getParameter(request, prefix + "region", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setTotal(JSPUtil.getParameter(request, prefix + "total", ""));
		setRatePer(JSPUtil.getParameter(request, prefix + "rate_per", ""));
		setBdrPer(JSPUtil.getParameter(request, prefix + "bdr_per", ""));
		setComFlag(JSPUtil.getParameter(request, prefix + "com_flag", ""));
		setBdrFlag(JSPUtil.getParameter(request, prefix + "bdr_flag", ""));
		setPctPer(JSPUtil.getParameter(request, prefix + "pct_per", ""));
		setComPer(JSPUtil.getParameter(request, prefix + "com_per", ""));
		setKind(JSPUtil.getParameter(request, prefix + "kind", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDctPer(JSPUtil.getParameter(request, prefix + "dct_per", ""));
		setRateFlag(JSPUtil.getParameter(request, prefix + "rate_flag", ""));
		setPctFlag(JSPUtil.getParameter(request, prefix + "pct_flag", ""));
		setDctFlag(JSPUtil.getParameter(request, prefix + "dct_flag", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DocQueueSummaryJITCompletenceVO[]
	 */
	public DocQueueSummaryJITCompletenceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DocQueueSummaryJITCompletenceVO[]
	 */
	public DocQueueSummaryJITCompletenceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DocQueueSummaryJITCompletenceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] region = (JSPUtil.getParameter(request, prefix	+ "region", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] total = (JSPUtil.getParameter(request, prefix	+ "total", length));
			String[] ratePer = (JSPUtil.getParameter(request, prefix	+ "rate_per", length));
			String[] bdrPer = (JSPUtil.getParameter(request, prefix	+ "bdr_per", length));
			String[] comFlag = (JSPUtil.getParameter(request, prefix	+ "com_flag", length));
			String[] bdrFlag = (JSPUtil.getParameter(request, prefix	+ "bdr_flag", length));
			String[] pctPer = (JSPUtil.getParameter(request, prefix	+ "pct_per", length));
			String[] comPer = (JSPUtil.getParameter(request, prefix	+ "com_per", length));
			String[] kind = (JSPUtil.getParameter(request, prefix	+ "kind", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dctPer = (JSPUtil.getParameter(request, prefix	+ "dct_per", length));
			String[] rateFlag = (JSPUtil.getParameter(request, prefix	+ "rate_flag", length));
			String[] pctFlag = (JSPUtil.getParameter(request, prefix	+ "pct_flag", length));
			String[] dctFlag = (JSPUtil.getParameter(request, prefix	+ "dct_flag", length));
			
			for (int i = 0; i < length; i++) {
				model = new DocQueueSummaryJITCompletenceVO();
				if (region[i] != null)
					model.setRegion(region[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (total[i] != null)
					model.setTotal(total[i]);
				if (ratePer[i] != null)
					model.setRatePer(ratePer[i]);
				if (bdrPer[i] != null)
					model.setBdrPer(bdrPer[i]);
				if (comFlag[i] != null)
					model.setComFlag(comFlag[i]);
				if (bdrFlag[i] != null)
					model.setBdrFlag(bdrFlag[i]);
				if (pctPer[i] != null)
					model.setPctPer(pctPer[i]);
				if (comPer[i] != null)
					model.setComPer(comPer[i]);
				if (kind[i] != null)
					model.setKind(kind[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dctPer[i] != null)
					model.setDctPer(dctPer[i]);
				if (rateFlag[i] != null)
					model.setRateFlag(rateFlag[i]);
				if (pctFlag[i] != null)
					model.setPctFlag(pctFlag[i]);
				if (dctFlag[i] != null)
					model.setDctFlag(dctFlag[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDocQueueSummaryJITCompletenceVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DocQueueSummaryJITCompletenceVO[]
	 */
	public DocQueueSummaryJITCompletenceVO[] getDocQueueSummaryJITCompletenceVOs(){
		DocQueueSummaryJITCompletenceVO[] vos = (DocQueueSummaryJITCompletenceVO[])models.toArray(new DocQueueSummaryJITCompletenceVO[models.size()]);
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
		this.region = this.region .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.total = this.total .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratePer = this.ratePer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrPer = this.bdrPer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comFlag = this.comFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrFlag = this.bdrFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctPer = this.pctPer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comPer = this.comPer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kind = this.kind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dctPer = this.dctPer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateFlag = this.rateFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctFlag = this.pctFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dctFlag = this.dctFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
