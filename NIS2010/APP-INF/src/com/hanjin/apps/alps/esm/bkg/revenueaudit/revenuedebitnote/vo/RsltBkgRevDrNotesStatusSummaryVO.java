/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RsltBkgRevDrNotesStatusSummaryVO.java
*@FileTitle : RsltBkgRevDrNotesStatusSummaryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.02  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltBkgRevDrNotesStatusSummaryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltBkgRevDrNotesStatusSummaryVO> models = new ArrayList<RsltBkgRevDrNotesStatusSummaryVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String within20Dys = null;
	/* Column Info */
	private String over20Dys = null;
	/* Column Info */
	private String ttlCnt = null;
	/* Column Info */
	private String over20DysRto = null;
	/* Column Info */
	private String within10Dys = null;
	/* Column Info */
	private String ttlUsdAmt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RsltBkgRevDrNotesStatusSummaryVO() {}

	public RsltBkgRevDrNotesStatusSummaryVO(String ibflag, String pagerows, String ttlCnt, String ttlUsdAmt, String within10Dys, String within20Dys, String over20Dys, String over20DysRto) {
		this.ibflag = ibflag;
		this.within20Dys = within20Dys;
		this.over20Dys = over20Dys;
		this.ttlCnt = ttlCnt;
		this.over20DysRto = over20DysRto;
		this.within10Dys = within10Dys;
		this.ttlUsdAmt = ttlUsdAmt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("within_20_dys", getWithin20Dys());
		this.hashColumns.put("over_20_dys", getOver20Dys());
		this.hashColumns.put("ttl_cnt", getTtlCnt());
		this.hashColumns.put("over_20_dys_rto", getOver20DysRto());
		this.hashColumns.put("within_10_dys", getWithin10Dys());
		this.hashColumns.put("ttl_usd_amt", getTtlUsdAmt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("within_20_dys", "within20Dys");
		this.hashFields.put("over_20_dys", "over20Dys");
		this.hashFields.put("ttl_cnt", "ttlCnt");
		this.hashFields.put("over_20_dys_rto", "over20DysRto");
		this.hashFields.put("within_10_dys", "within10Dys");
		this.hashFields.put("ttl_usd_amt", "ttlUsdAmt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return within20Dys
	 */
	public String getWithin20Dys() {
		return this.within20Dys;
	}
	
	/**
	 * Column Info
	 * @return over20Dys
	 */
	public String getOver20Dys() {
		return this.over20Dys;
	}
	
	/**
	 * Column Info
	 * @return ttlCnt
	 */
	public String getTtlCnt() {
		return this.ttlCnt;
	}
	
	/**
	 * Column Info
	 * @return over20DysRto
	 */
	public String getOver20DysRto() {
		return this.over20DysRto;
	}
	
	/**
	 * Column Info
	 * @return within10Dys
	 */
	public String getWithin10Dys() {
		return this.within10Dys;
	}
	
	/**
	 * Column Info
	 * @return ttlUsdAmt
	 */
	public String getTtlUsdAmt() {
		return this.ttlUsdAmt;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param within20Dys
	 */
	public void setWithin20Dys(String within20Dys) {
		this.within20Dys = within20Dys;
	}
	
	/**
	 * Column Info
	 * @param over20Dys
	 */
	public void setOver20Dys(String over20Dys) {
		this.over20Dys = over20Dys;
	}
	
	/**
	 * Column Info
	 * @param ttlCnt
	 */
	public void setTtlCnt(String ttlCnt) {
		this.ttlCnt = ttlCnt;
	}
	
	/**
	 * Column Info
	 * @param over20DysRto
	 */
	public void setOver20DysRto(String over20DysRto) {
		this.over20DysRto = over20DysRto;
	}
	
	/**
	 * Column Info
	 * @param within10Dys
	 */
	public void setWithin10Dys(String within10Dys) {
		this.within10Dys = within10Dys;
	}
	
	/**
	 * Column Info
	 * @param ttlUsdAmt
	 */
	public void setTtlUsdAmt(String ttlUsdAmt) {
		this.ttlUsdAmt = ttlUsdAmt;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setWithin20Dys(JSPUtil.getParameter(request, prefix + "within_20_dys", ""));
		setOver20Dys(JSPUtil.getParameter(request, prefix + "over_20_dys", ""));
		setTtlCnt(JSPUtil.getParameter(request, prefix + "ttl_cnt", ""));
		setOver20DysRto(JSPUtil.getParameter(request, prefix + "over_20_dys_rto", ""));
		setWithin10Dys(JSPUtil.getParameter(request, prefix + "within_10_dys", ""));
		setTtlUsdAmt(JSPUtil.getParameter(request, prefix + "ttl_usd_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltBkgRevDrNotesStatusSummaryVO[]
	 */
	public RsltBkgRevDrNotesStatusSummaryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltBkgRevDrNotesStatusSummaryVO[]
	 */
	public RsltBkgRevDrNotesStatusSummaryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltBkgRevDrNotesStatusSummaryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] within20Dys = (JSPUtil.getParameter(request, prefix	+ "within_20_dys", length));
			String[] over20Dys = (JSPUtil.getParameter(request, prefix	+ "over_20_dys", length));
			String[] ttlCnt = (JSPUtil.getParameter(request, prefix	+ "ttl_cnt", length));
			String[] over20DysRto = (JSPUtil.getParameter(request, prefix	+ "over_20_dys_rto", length));
			String[] within10Dys = (JSPUtil.getParameter(request, prefix	+ "within_10_dys", length));
			String[] ttlUsdAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_usd_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltBkgRevDrNotesStatusSummaryVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (within20Dys[i] != null)
					model.setWithin20Dys(within20Dys[i]);
				if (over20Dys[i] != null)
					model.setOver20Dys(over20Dys[i]);
				if (ttlCnt[i] != null)
					model.setTtlCnt(ttlCnt[i]);
				if (over20DysRto[i] != null)
					model.setOver20DysRto(over20DysRto[i]);
				if (within10Dys[i] != null)
					model.setWithin10Dys(within10Dys[i]);
				if (ttlUsdAmt[i] != null)
					model.setTtlUsdAmt(ttlUsdAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltBkgRevDrNotesStatusSummaryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltBkgRevDrNotesStatusSummaryVO[]
	 */
	public RsltBkgRevDrNotesStatusSummaryVO[] getRsltBkgRevDrNotesStatusSummaryVOs(){
		RsltBkgRevDrNotesStatusSummaryVO[] vos = (RsltBkgRevDrNotesStatusSummaryVO[])models.toArray(new RsltBkgRevDrNotesStatusSummaryVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.within20Dys = this.within20Dys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.over20Dys = this.over20Dys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlCnt = this.ttlCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.over20DysRto = this.over20DysRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.within10Dys = this.within10Dys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlUsdAmt = this.ttlUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
