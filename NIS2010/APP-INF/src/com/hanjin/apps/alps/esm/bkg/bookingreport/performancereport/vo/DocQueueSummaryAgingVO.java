/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DocQueueSummaryAgingVO.java
*@FileTitle : DocQueueSummaryAgingVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.15
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2011.06.15 김상수 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo;

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

public class DocQueueSummaryAgingVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DocQueueSummaryAgingVO> models = new ArrayList<DocQueueSummaryAgingVO>();
	
	/* Column Info */
	private String region = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String total = null;
	/* Column Info */
	private String pD1Per = null;
	/* Column Info */
	private String fD5Per = null;
	/* Column Info */
	private String pD5Per = null;
	/* Column Info */
	private String pD5 = null;
	/* Column Info */
	private String kind = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pD3 = null;
	/* Column Info */
	private String fD1 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pD1 = null;
	/* Column Info */
	private String fD5 = null;
	/* Column Info */
	private String fD3Per = null;
	/* Column Info */
	private String fD3 = null;
	/* Column Info */
	private String pD3Per = null;
	/* Column Info */
	private String fD1Per = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DocQueueSummaryAgingVO() {}

	public DocQueueSummaryAgingVO(String ibflag, String pagerows, String region, String bkgOfcCd, String total, String kind, String pD1, String pD1Per, String pD3, String pD3Per, String pD5, String pD5Per, String fD1, String fD1Per, String fD3, String fD3Per, String fD5, String fD5Per) {
		this.region = region;
		this.bkgOfcCd = bkgOfcCd;
		this.total = total;
		this.pD1Per = pD1Per;
		this.fD5Per = fD5Per;
		this.pD5Per = pD5Per;
		this.pD5 = pD5;
		this.kind = kind;
		this.pagerows = pagerows;
		this.pD3 = pD3;
		this.fD1 = fD1;
		this.ibflag = ibflag;
		this.pD1 = pD1;
		this.fD5 = fD5;
		this.fD3Per = fD3Per;
		this.fD3 = fD3;
		this.pD3Per = pD3Per;
		this.fD1Per = fD1Per;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("region", getRegion());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("total", getTotal());
		this.hashColumns.put("p_d1_per", getPD1Per());
		this.hashColumns.put("f_d5_per", getFD5Per());
		this.hashColumns.put("p_d5_per", getPD5Per());
		this.hashColumns.put("p_d5", getPD5());
		this.hashColumns.put("kind", getKind());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("p_d3", getPD3());
		this.hashColumns.put("f_d1", getFD1());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("p_d1", getPD1());
		this.hashColumns.put("f_d5", getFD5());
		this.hashColumns.put("f_d3_per", getFD3Per());
		this.hashColumns.put("f_d3", getFD3());
		this.hashColumns.put("p_d3_per", getPD3Per());
		this.hashColumns.put("f_d1_per", getFD1Per());
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
		this.hashFields.put("p_d1_per", "pD1Per");
		this.hashFields.put("f_d5_per", "fD5Per");
		this.hashFields.put("p_d5_per", "pD5Per");
		this.hashFields.put("p_d5", "pD5");
		this.hashFields.put("kind", "kind");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("p_d3", "pD3");
		this.hashFields.put("f_d1", "fD1");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("p_d1", "pD1");
		this.hashFields.put("f_d5", "fD5");
		this.hashFields.put("f_d3_per", "fD3Per");
		this.hashFields.put("f_d3", "fD3");
		this.hashFields.put("p_d3_per", "pD3Per");
		this.hashFields.put("f_d1_per", "fD1Per");
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
	 * @return pD1Per
	 */
	public String getPD1Per() {
		return this.pD1Per;
	}
	
	/**
	 * Column Info
	 * @return fD5Per
	 */
	public String getFD5Per() {
		return this.fD5Per;
	}
	
	/**
	 * Column Info
	 * @return pD5Per
	 */
	public String getPD5Per() {
		return this.pD5Per;
	}
	
	/**
	 * Column Info
	 * @return pD5
	 */
	public String getPD5() {
		return this.pD5;
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
	 * Column Info
	 * @return pD3
	 */
	public String getPD3() {
		return this.pD3;
	}
	
	/**
	 * Column Info
	 * @return fD1
	 */
	public String getFD1() {
		return this.fD1;
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
	 * @return pD1
	 */
	public String getPD1() {
		return this.pD1;
	}
	
	/**
	 * Column Info
	 * @return fD5
	 */
	public String getFD5() {
		return this.fD5;
	}
	
	/**
	 * Column Info
	 * @return fD3Per
	 */
	public String getFD3Per() {
		return this.fD3Per;
	}
	
	/**
	 * Column Info
	 * @return fD3
	 */
	public String getFD3() {
		return this.fD3;
	}
	
	/**
	 * Column Info
	 * @return pD3Per
	 */
	public String getPD3Per() {
		return this.pD3Per;
	}
	
	/**
	 * Column Info
	 * @return fD1Per
	 */
	public String getFD1Per() {
		return this.fD1Per;
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
	 * @param pD1Per
	 */
	public void setPD1Per(String pD1Per) {
		this.pD1Per = pD1Per;
	}
	
	/**
	 * Column Info
	 * @param fD5Per
	 */
	public void setFD5Per(String fD5Per) {
		this.fD5Per = fD5Per;
	}
	
	/**
	 * Column Info
	 * @param pD5Per
	 */
	public void setPD5Per(String pD5Per) {
		this.pD5Per = pD5Per;
	}
	
	/**
	 * Column Info
	 * @param pD5
	 */
	public void setPD5(String pD5) {
		this.pD5 = pD5;
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
	 * Column Info
	 * @param pD3
	 */
	public void setPD3(String pD3) {
		this.pD3 = pD3;
	}
	
	/**
	 * Column Info
	 * @param fD1
	 */
	public void setFD1(String fD1) {
		this.fD1 = fD1;
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
	 * @param pD1
	 */
	public void setPD1(String pD1) {
		this.pD1 = pD1;
	}
	
	/**
	 * Column Info
	 * @param fD5
	 */
	public void setFD5(String fD5) {
		this.fD5 = fD5;
	}
	
	/**
	 * Column Info
	 * @param fD3Per
	 */
	public void setFD3Per(String fD3Per) {
		this.fD3Per = fD3Per;
	}
	
	/**
	 * Column Info
	 * @param fD3
	 */
	public void setFD3(String fD3) {
		this.fD3 = fD3;
	}
	
	/**
	 * Column Info
	 * @param pD3Per
	 */
	public void setPD3Per(String pD3Per) {
		this.pD3Per = pD3Per;
	}
	
	/**
	 * Column Info
	 * @param fD1Per
	 */
	public void setFD1Per(String fD1Per) {
		this.fD1Per = fD1Per;
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
		setPD1Per(JSPUtil.getParameter(request, prefix + "p_d1_per", ""));
		setFD5Per(JSPUtil.getParameter(request, prefix + "f_d5_per", ""));
		setPD5Per(JSPUtil.getParameter(request, prefix + "p_d5_per", ""));
		setPD5(JSPUtil.getParameter(request, prefix + "p_d5", ""));
		setKind(JSPUtil.getParameter(request, prefix + "kind", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPD3(JSPUtil.getParameter(request, prefix + "p_d3", ""));
		setFD1(JSPUtil.getParameter(request, prefix + "f_d1", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPD1(JSPUtil.getParameter(request, prefix + "p_d1", ""));
		setFD5(JSPUtil.getParameter(request, prefix + "f_d5", ""));
		setFD3Per(JSPUtil.getParameter(request, prefix + "f_d3_per", ""));
		setFD3(JSPUtil.getParameter(request, prefix + "f_d3", ""));
		setPD3Per(JSPUtil.getParameter(request, prefix + "p_d3_per", ""));
		setFD1Per(JSPUtil.getParameter(request, prefix + "f_d1_per", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DocQueueSummaryAgingVO[]
	 */
	public DocQueueSummaryAgingVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DocQueueSummaryAgingVO[]
	 */
	public DocQueueSummaryAgingVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DocQueueSummaryAgingVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] region = (JSPUtil.getParameter(request, prefix	+ "region", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] total = (JSPUtil.getParameter(request, prefix	+ "total", length));
			String[] pD1Per = (JSPUtil.getParameter(request, prefix	+ "p_d1_per", length));
			String[] fD5Per = (JSPUtil.getParameter(request, prefix	+ "f_d5_per", length));
			String[] pD5Per = (JSPUtil.getParameter(request, prefix	+ "p_d5_per", length));
			String[] pD5 = (JSPUtil.getParameter(request, prefix	+ "p_d5", length));
			String[] kind = (JSPUtil.getParameter(request, prefix	+ "kind", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pD3 = (JSPUtil.getParameter(request, prefix	+ "p_d3", length));
			String[] fD1 = (JSPUtil.getParameter(request, prefix	+ "f_d1", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pD1 = (JSPUtil.getParameter(request, prefix	+ "p_d1", length));
			String[] fD5 = (JSPUtil.getParameter(request, prefix	+ "f_d5", length));
			String[] fD3Per = (JSPUtil.getParameter(request, prefix	+ "f_d3_per", length));
			String[] fD3 = (JSPUtil.getParameter(request, prefix	+ "f_d3", length));
			String[] pD3Per = (JSPUtil.getParameter(request, prefix	+ "p_d3_per", length));
			String[] fD1Per = (JSPUtil.getParameter(request, prefix	+ "f_d1_per", length));
			
			for (int i = 0; i < length; i++) {
				model = new DocQueueSummaryAgingVO();
				if (region[i] != null)
					model.setRegion(region[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (total[i] != null)
					model.setTotal(total[i]);
				if (pD1Per[i] != null)
					model.setPD1Per(pD1Per[i]);
				if (fD5Per[i] != null)
					model.setFD5Per(fD5Per[i]);
				if (pD5Per[i] != null)
					model.setPD5Per(pD5Per[i]);
				if (pD5[i] != null)
					model.setPD5(pD5[i]);
				if (kind[i] != null)
					model.setKind(kind[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pD3[i] != null)
					model.setPD3(pD3[i]);
				if (fD1[i] != null)
					model.setFD1(fD1[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pD1[i] != null)
					model.setPD1(pD1[i]);
				if (fD5[i] != null)
					model.setFD5(fD5[i]);
				if (fD3Per[i] != null)
					model.setFD3Per(fD3Per[i]);
				if (fD3[i] != null)
					model.setFD3(fD3[i]);
				if (pD3Per[i] != null)
					model.setPD3Per(pD3Per[i]);
				if (fD1Per[i] != null)
					model.setFD1Per(fD1Per[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDocQueueSummaryAgingVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DocQueueSummaryAgingVO[]
	 */
	public DocQueueSummaryAgingVO[] getDocQueueSummaryAgingVOs(){
		DocQueueSummaryAgingVO[] vos = (DocQueueSummaryAgingVO[])models.toArray(new DocQueueSummaryAgingVO[models.size()]);
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
		this.pD1Per = this.pD1Per .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fD5Per = this.fD5Per .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pD5Per = this.pD5Per .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pD5 = this.pD5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kind = this.kind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pD3 = this.pD3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fD1 = this.fD1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pD1 = this.pD1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fD5 = this.fD5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fD3Per = this.fD3Per .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fD3 = this.fD3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pD3Per = this.pD3Per .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fD1Per = this.fD1Per .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
