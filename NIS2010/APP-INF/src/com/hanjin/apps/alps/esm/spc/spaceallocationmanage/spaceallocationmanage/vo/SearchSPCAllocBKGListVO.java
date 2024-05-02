/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SearchSPCAllocBKGListVO.java
*@FileTitle : SearchSPCAllocBKGListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.15
*@LastModifier : Kim sung wook
*@LastVersion : 1.0
* 2015.05.15 Kim sung wook 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author Kim sung wook
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSPCAllocBKGListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSPCAllocBKGListVO> models = new ArrayList<SearchSPCAllocBKGListVO>();
	
	/* Column Info */
	private String bkgRdQty = null;
	/* Column Info */
	private String bkgTtlQty = null;
	/* Column Info */
	private String bkgSbWgt = null;
	/* Column Info */
	private String bkg20ftQty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bkgD4ftQty = null;
	/* Column Info */
	private String bkgTtlWgt = null;
	/* Column Info */
	private String bkgD2ftQty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkg45ftHcQty = null;
	/* Column Info */
	private String bkgSbQty = null;
	/* Column Info */
	private String bkg53ftQty = null;
	/* Column Info */
	private String bkg40ftQty = null;
	/* Column Info */
	private String bkgRfQty = null;
	/* Column Info */
	private String bkg40ftHcQty = null;
	/* Column Info */
	private String rowNum = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchSPCAllocBKGListVO() {}

	public SearchSPCAllocBKGListVO(String ibflag, String pagerows, String bkgTtlQty, String bkg20ftQty, String bkg40ftQty, String bkgD2ftQty, String bkgD4ftQty, String bkg40ftHcQty, String bkg45ftHcQty, String bkg53ftQty, String bkgRfQty, String bkgRdQty, String bkgTtlWgt, String bkgSbQty, String bkgSbWgt, String rowNum) {
		this.bkgRdQty = bkgRdQty;
		this.bkgTtlQty = bkgTtlQty;
		this.bkgSbWgt = bkgSbWgt;
		this.bkg20ftQty = bkg20ftQty;
		this.pagerows = pagerows;
		this.bkgD4ftQty = bkgD4ftQty;
		this.bkgTtlWgt = bkgTtlWgt;
		this.bkgD2ftQty = bkgD2ftQty;
		this.ibflag = ibflag;
		this.bkg45ftHcQty = bkg45ftHcQty;
		this.bkgSbQty = bkgSbQty;
		this.bkg53ftQty = bkg53ftQty;
		this.bkg40ftQty = bkg40ftQty;
		this.bkgRfQty = bkgRfQty;
		this.bkg40ftHcQty = bkg40ftHcQty;
		this.rowNum = rowNum;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_rd_qty", getBkgRdQty());
		this.hashColumns.put("bkg_ttl_qty", getBkgTtlQty());
		this.hashColumns.put("bkg_sb_wgt", getBkgSbWgt());
		this.hashColumns.put("bkg_20ft_qty", getBkg20ftQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bkg_d4ft_qty", getBkgD4ftQty());
		this.hashColumns.put("bkg_ttl_wgt", getBkgTtlWgt());
		this.hashColumns.put("bkg_d2ft_qty", getBkgD2ftQty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_45ft_hc_qty", getBkg45ftHcQty());
		this.hashColumns.put("bkg_sb_qty", getBkgSbQty());
		this.hashColumns.put("bkg_53ft_qty", getBkg53ftQty());
		this.hashColumns.put("bkg_40ft_qty", getBkg40ftQty());
		this.hashColumns.put("bkg_rf_qty", getBkgRfQty());
		this.hashColumns.put("bkg_40ft_hc_qty", getBkg40ftHcQty());
		this.hashColumns.put("row_num", getRowNum());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_rd_qty", "bkgRdQty");
		this.hashFields.put("bkg_ttl_qty", "bkgTtlQty");
		this.hashFields.put("bkg_sb_wgt", "bkgSbWgt");
		this.hashFields.put("bkg_20ft_qty", "bkg20ftQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bkg_d4ft_qty", "bkgD4ftQty");
		this.hashFields.put("bkg_ttl_wgt", "bkgTtlWgt");
		this.hashFields.put("bkg_d2ft_qty", "bkgD2ftQty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_45ft_hc_qty", "bkg45ftHcQty");
		this.hashFields.put("bkg_sb_qty", "bkgSbQty");
		this.hashFields.put("bkg_53ft_qty", "bkg53ftQty");
		this.hashFields.put("bkg_40ft_qty", "bkg40ftQty");
		this.hashFields.put("bkg_rf_qty", "bkgRfQty");
		this.hashFields.put("bkg_40ft_hc_qty", "bkg40ftHcQty");
		this.hashFields.put("row_num", "rowNum");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgRdQty
	 */
	public String getBkgRdQty() {
		return this.bkgRdQty;
	}
	
	/**
	 * Column Info
	 * @return bkgTtlQty
	 */
	public String getBkgTtlQty() {
		return this.bkgTtlQty;
	}
	
	/**
	 * Column Info
	 * @return bkgSbWgt
	 */
	public String getBkgSbWgt() {
		return this.bkgSbWgt;
	}
	
	/**
	 * Column Info
	 * @return bkg20ftQty
	 */
	public String getBkg20ftQty() {
		return this.bkg20ftQty;
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
	 * @return bkgD4ftQty
	 */
	public String getBkgD4ftQty() {
		return this.bkgD4ftQty;
	}
	
	/**
	 * Column Info
	 * @return bkgTtlWgt
	 */
	public String getBkgTtlWgt() {
		return this.bkgTtlWgt;
	}
	
	/**
	 * Column Info
	 * @return bkgD2ftQty
	 */
	public String getBkgD2ftQty() {
		return this.bkgD2ftQty;
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
	 * @return bkg45ftHcQty
	 */
	public String getBkg45ftHcQty() {
		return this.bkg45ftHcQty;
	}
	
	/**
	 * Column Info
	 * @return bkgSbQty
	 */
	public String getBkgSbQty() {
		return this.bkgSbQty;
	}
	
	/**
	 * Column Info
	 * @return bkg53ftQty
	 */
	public String getBkg53ftQty() {
		return this.bkg53ftQty;
	}
	
	/**
	 * Column Info
	 * @return bkg40ftQty
	 */
	public String getBkg40ftQty() {
		return this.bkg40ftQty;
	}
	
	/**
	 * Column Info
	 * @return bkgRfQty
	 */
	public String getBkgRfQty() {
		return this.bkgRfQty;
	}
	
	/**
	 * Column Info
	 * @return bkg40ftHcQty
	 */
	public String getBkg40ftHcQty() {
		return this.bkg40ftHcQty;
	}
	
	/**
	 * Column Info
	 * @return rowNum
	 */
	public String getRowNum() {
		return this.rowNum;
	}
	

	/**
	 * Column Info
	 * @param bkgRdQty
	 */
	public void setBkgRdQty(String bkgRdQty) {
		this.bkgRdQty = bkgRdQty;
	}
	
	/**
	 * Column Info
	 * @param bkgTtlQty
	 */
	public void setBkgTtlQty(String bkgTtlQty) {
		this.bkgTtlQty = bkgTtlQty;
	}
	
	/**
	 * Column Info
	 * @param bkgSbWgt
	 */
	public void setBkgSbWgt(String bkgSbWgt) {
		this.bkgSbWgt = bkgSbWgt;
	}
	
	/**
	 * Column Info
	 * @param bkg20ftQty
	 */
	public void setBkg20ftQty(String bkg20ftQty) {
		this.bkg20ftQty = bkg20ftQty;
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
	 * @param bkgD4ftQty
	 */
	public void setBkgD4ftQty(String bkgD4ftQty) {
		this.bkgD4ftQty = bkgD4ftQty;
	}
	
	/**
	 * Column Info
	 * @param bkgTtlWgt
	 */
	public void setBkgTtlWgt(String bkgTtlWgt) {
		this.bkgTtlWgt = bkgTtlWgt;
	}
	
	/**
	 * Column Info
	 * @param bkgD2ftQty
	 */
	public void setBkgD2ftQty(String bkgD2ftQty) {
		this.bkgD2ftQty = bkgD2ftQty;
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
	 * @param bkg45ftHcQty
	 */
	public void setBkg45ftHcQty(String bkg45ftHcQty) {
		this.bkg45ftHcQty = bkg45ftHcQty;
	}
	
	/**
	 * Column Info
	 * @param bkgSbQty
	 */
	public void setBkgSbQty(String bkgSbQty) {
		this.bkgSbQty = bkgSbQty;
	}
	
	/**
	 * Column Info
	 * @param bkg53ftQty
	 */
	public void setBkg53ftQty(String bkg53ftQty) {
		this.bkg53ftQty = bkg53ftQty;
	}
	
	/**
	 * Column Info
	 * @param bkg40ftQty
	 */
	public void setBkg40ftQty(String bkg40ftQty) {
		this.bkg40ftQty = bkg40ftQty;
	}
	
	/**
	 * Column Info
	 * @param bkgRfQty
	 */
	public void setBkgRfQty(String bkgRfQty) {
		this.bkgRfQty = bkgRfQty;
	}
	
	/**
	 * Column Info
	 * @param bkg40ftHcQty
	 */
	public void setBkg40ftHcQty(String bkg40ftHcQty) {
		this.bkg40ftHcQty = bkg40ftHcQty;
	}
	
	/**
	 * Column Info
	 * @param rowNum
	 */
	public void setRowNum(String rowNum) {
		this.rowNum = rowNum;
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
		setBkgRdQty(JSPUtil.getParameter(request, prefix + "bkg_rd_qty", ""));
		setBkgTtlQty(JSPUtil.getParameter(request, prefix + "bkg_ttl_qty", ""));
		setBkgSbWgt(JSPUtil.getParameter(request, prefix + "bkg_sb_wgt", ""));
		setBkg20ftQty(JSPUtil.getParameter(request, prefix + "bkg_20ft_qty", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBkgD4ftQty(JSPUtil.getParameter(request, prefix + "bkg_d4ft_qty", ""));
		setBkgTtlWgt(JSPUtil.getParameter(request, prefix + "bkg_ttl_wgt", ""));
		setBkgD2ftQty(JSPUtil.getParameter(request, prefix + "bkg_d2ft_qty", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkg45ftHcQty(JSPUtil.getParameter(request, prefix + "bkg_45ft_hc_qty", ""));
		setBkgSbQty(JSPUtil.getParameter(request, prefix + "bkg_sb_qty", ""));
		setBkg53ftQty(JSPUtil.getParameter(request, prefix + "bkg_53ft_qty", ""));
		setBkg40ftQty(JSPUtil.getParameter(request, prefix + "bkg_40ft_qty", ""));
		setBkgRfQty(JSPUtil.getParameter(request, prefix + "bkg_rf_qty", ""));
		setBkg40ftHcQty(JSPUtil.getParameter(request, prefix + "bkg_40ft_hc_qty", ""));
		setRowNum(JSPUtil.getParameter(request, prefix + "row_num", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSPCAllocBKGListVO[]
	 */
	public SearchSPCAllocBKGListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSPCAllocBKGListVO[]
	 */
	public SearchSPCAllocBKGListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSPCAllocBKGListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgRdQty = (JSPUtil.getParameter(request, prefix	+ "bkg_rd_qty", length));
			String[] bkgTtlQty = (JSPUtil.getParameter(request, prefix	+ "bkg_ttl_qty", length));
			String[] bkgSbWgt = (JSPUtil.getParameter(request, prefix	+ "bkg_sb_wgt", length));
			String[] bkg20ftQty = (JSPUtil.getParameter(request, prefix	+ "bkg_20ft_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bkgD4ftQty = (JSPUtil.getParameter(request, prefix	+ "bkg_d4ft_qty", length));
			String[] bkgTtlWgt = (JSPUtil.getParameter(request, prefix	+ "bkg_ttl_wgt", length));
			String[] bkgD2ftQty = (JSPUtil.getParameter(request, prefix	+ "bkg_d2ft_qty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkg45ftHcQty = (JSPUtil.getParameter(request, prefix	+ "bkg_45ft_hc_qty", length));
			String[] bkgSbQty = (JSPUtil.getParameter(request, prefix	+ "bkg_sb_qty", length));
			String[] bkg53ftQty = (JSPUtil.getParameter(request, prefix	+ "bkg_53ft_qty", length));
			String[] bkg40ftQty = (JSPUtil.getParameter(request, prefix	+ "bkg_40ft_qty", length));
			String[] bkgRfQty = (JSPUtil.getParameter(request, prefix	+ "bkg_rf_qty", length));
			String[] bkg40ftHcQty = (JSPUtil.getParameter(request, prefix	+ "bkg_40ft_hc_qty", length));
			String[] rowNum = (JSPUtil.getParameter(request, prefix	+ "row_num", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSPCAllocBKGListVO();
				if (bkgRdQty[i] != null)
					model.setBkgRdQty(bkgRdQty[i]);
				if (bkgTtlQty[i] != null)
					model.setBkgTtlQty(bkgTtlQty[i]);
				if (bkgSbWgt[i] != null)
					model.setBkgSbWgt(bkgSbWgt[i]);
				if (bkg20ftQty[i] != null)
					model.setBkg20ftQty(bkg20ftQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bkgD4ftQty[i] != null)
					model.setBkgD4ftQty(bkgD4ftQty[i]);
				if (bkgTtlWgt[i] != null)
					model.setBkgTtlWgt(bkgTtlWgt[i]);
				if (bkgD2ftQty[i] != null)
					model.setBkgD2ftQty(bkgD2ftQty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkg45ftHcQty[i] != null)
					model.setBkg45ftHcQty(bkg45ftHcQty[i]);
				if (bkgSbQty[i] != null)
					model.setBkgSbQty(bkgSbQty[i]);
				if (bkg53ftQty[i] != null)
					model.setBkg53ftQty(bkg53ftQty[i]);
				if (bkg40ftQty[i] != null)
					model.setBkg40ftQty(bkg40ftQty[i]);
				if (bkgRfQty[i] != null)
					model.setBkgRfQty(bkgRfQty[i]);
				if (bkg40ftHcQty[i] != null)
					model.setBkg40ftHcQty(bkg40ftHcQty[i]);
				if (rowNum[i] != null)
					model.setRowNum(rowNum[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSPCAllocBKGListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSPCAllocBKGListVO[]
	 */
	public SearchSPCAllocBKGListVO[] getSearchSPCAllocBKGListVOs(){
		SearchSPCAllocBKGListVO[] vos = (SearchSPCAllocBKGListVO[])models.toArray(new SearchSPCAllocBKGListVO[models.size()]);
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
		this.bkgRdQty = this.bkgRdQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTtlQty = this.bkgTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSbWgt = this.bkgSbWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg20ftQty = this.bkg20ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgD4ftQty = this.bkgD4ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTtlWgt = this.bkgTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgD2ftQty = this.bkgD2ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg45ftHcQty = this.bkg45ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSbQty = this.bkgSbQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg53ftQty = this.bkg53ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg40ftQty = this.bkg40ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRfQty = this.bkgRfQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg40ftHcQty = this.bkg40ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowNum = this.rowNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
