/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GRWEmailSalesRepVO.java
*@FileTitle : GRWEmailSalesRepVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.17  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtclosing.faxemail.vo;

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

public class GRWEmailSalesRepVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GRWEmailSalesRepVO> models = new ArrayList<GRWEmailSalesRepVO>();
	
	/* Column Info */
	private String srFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String ttl90Ots = null;
	/* Column Info */
	private String salRep = null;
	/* Column Info */
	private String ttlOts = null;
	/* Column Info */
	private String ttl30Ots = null;
	/* Column Info */
	private String ttl180Ots = null;
	/* Column Info */
	private String ttl15Ots = null;
	/* Column Info */
	private String ttlOver180Ots = null;
	/* Column Info */
	private String salRepNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Page Number */
	private String ofcCd = null;
	/* Column Info */
	private String ttl60Ots = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public GRWEmailSalesRepVO() {}

	public GRWEmailSalesRepVO(String ibflag, String pagerows, String srFlg, String salRep, String salRepNm, String custCd, String custNm, String ttlOts, String ttl15Ots, String ttl30Ots, String ttl90Ots, String ttl180Ots, String ttlOver180Ots, String ofcCd, String ttl60Ots) {
		this.srFlg = srFlg;
		this.ibflag = ibflag;
		this.custNm = custNm;
		this.custCd = custCd;
		this.ttl90Ots = ttl90Ots;
		this.salRep = salRep;
		this.ttlOts = ttlOts;
		this.ttl30Ots = ttl30Ots;
		this.ttl180Ots = ttl180Ots;
		this.ttl15Ots = ttl15Ots;
		this.ttlOver180Ots = ttlOver180Ots;
		this.salRepNm = salRepNm;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.ttl60Ots = ttl60Ots;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sr_flg", getSrFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("ttl_90_ots", getTtl90Ots());
		this.hashColumns.put("sal_rep", getSalRep());
		this.hashColumns.put("ttl_ots", getTtlOts());
		this.hashColumns.put("ttl_30_ots", getTtl30Ots());
		this.hashColumns.put("ttl_180_ots", getTtl180Ots());
		this.hashColumns.put("ttl_15_ots", getTtl15Ots());
		this.hashColumns.put("ttl_over_180_ots", getTtlOver180Ots());
		this.hashColumns.put("sal_rep_nm", getSalRepNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ttl_60_ots", getTtl60Ots());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sr_flg", "srFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("ttl_90_ots", "ttl90Ots");
		this.hashFields.put("sal_rep", "salRep");
		this.hashFields.put("ttl_ots", "ttlOts");
		this.hashFields.put("ttl_30_ots", "ttl30Ots");
		this.hashFields.put("ttl_180_ots", "ttl180Ots");
		this.hashFields.put("ttl_15_ots", "ttl15Ots");
		this.hashFields.put("ttl_over_180_ots", "ttlOver180Ots");
		this.hashFields.put("sal_rep_nm", "salRepNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "OfcCd");
		this.hashFields.put("ttl_60_ots", "ttl60Ots");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return srFlg
	 */
	public String getSrFlg() {
		return this.srFlg;
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
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return ttl90Ots
	 */
	public String getTtl90Ots() {
		return this.ttl90Ots;
	}
	
	/**
	 * Column Info
	 * @return salRep
	 */
	public String getSalRep() {
		return this.salRep;
	}
	
	/**
	 * Column Info
	 * @return ttlOts
	 */
	public String getTtlOts() {
		return this.ttlOts;
	}
	
	/**
	 * Column Info
	 * @return ttl30Ots
	 */
	public String getTtl30Ots() {
		return this.ttl30Ots;
	}
	
	/**
	 * Column Info
	 * @return ttl180Ots
	 */
	public String getTtl180Ots() {
		return this.ttl180Ots;
	}
	
	/**
	 * Column Info
	 * @return ttl15Ots
	 */
	public String getTtl15Ots() {
		return this.ttl15Ots;
	}
	
	/**
	 * Column Info
	 * @return ttlOver180Ots
	 */
	public String getTtlOver180Ots() {
		return this.ttlOver180Ots;
	}
	
	/**
	 * Column Info
	 * @return salRepNm
	 */
	public String getSalRepNm() {
		return this.salRepNm;
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
	 * @param srFlg
	 */
	public void setSrFlg(String srFlg) {
		this.srFlg = srFlg;
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
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param ttl90Ots
	 */
	public void setTtl90Ots(String ttl90Ots) {
		this.ttl90Ots = ttl90Ots;
	}
	
	/**
	 * Column Info
	 * @param salRep
	 */
	public void setSalRep(String salRep) {
		this.salRep = salRep;
	}
	
	/**
	 * Column Info
	 * @param ttlOts
	 */
	public void setTtlOts(String ttlOts) {
		this.ttlOts = ttlOts;
	}
	
	/**
	 * Column Info
	 * @param ttl30Ots
	 */
	public void setTtl30Ots(String ttl30Ots) {
		this.ttl30Ots = ttl30Ots;
	}
	
	/**
	 * Column Info
	 * @param ttl180Ots
	 */
	public void setTtl180Ots(String ttl180Ots) {
		this.ttl180Ots = ttl180Ots;
	}
	
	/**
	 * Column Info
	 * @param ttl15Ots
	 */
	public void setTtl15Ots(String ttl15Ots) {
		this.ttl15Ots = ttl15Ots;
	}
	
	/**
	 * Column Info
	 * @param ttlOver180Ots
	 */
	public void setTtlOver180Ots(String ttlOver180Ots) {
		this.ttlOver180Ots = ttlOver180Ots;
	}
	
	/**
	 * Column Info
	 * @param salRepNm
	 */
	public void setSalRepNm(String salRepNm) {
		this.salRepNm = salRepNm;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	public String getOfcCd() {
		return ofcCd;
	}

	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	public String getTtl60Ots() {
		return ttl60Ots;
	}

	public void setTtl60Ots(String ttl60Ots) {
		this.ttl60Ots = ttl60Ots;
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
		setSrFlg(JSPUtil.getParameter(request, prefix + "sr_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setTtl90Ots(JSPUtil.getParameter(request, prefix + "ttl_90_ots", ""));
		setSalRep(JSPUtil.getParameter(request, prefix + "sal_rep", ""));
		setTtlOts(JSPUtil.getParameter(request, prefix + "ttl_ots", ""));
		setTtl30Ots(JSPUtil.getParameter(request, prefix + "ttl_30_ots", ""));
		setTtl180Ots(JSPUtil.getParameter(request, prefix + "ttl_180_ots", ""));
		setTtl15Ots(JSPUtil.getParameter(request, prefix + "ttl_15_ots", ""));
		setTtlOver180Ots(JSPUtil.getParameter(request, prefix + "ttl_over_180_ots", ""));
		setSalRepNm(JSPUtil.getParameter(request, prefix + "sal_rep_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setTtl60Ots(JSPUtil.getParameter(request, prefix + "ttl_60_ots", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GRWEmailSalesRepVO[]
	 */
	public GRWEmailSalesRepVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GRWEmailSalesRepVO[]
	 */
	public GRWEmailSalesRepVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GRWEmailSalesRepVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] srFlg = (JSPUtil.getParameter(request, prefix	+ "sr_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] ttl90Ots = (JSPUtil.getParameter(request, prefix	+ "ttl_90_ots", length));
			String[] salRep = (JSPUtil.getParameter(request, prefix	+ "sal_rep", length));
			String[] ttlOts = (JSPUtil.getParameter(request, prefix	+ "ttl_ots", length));
			String[] ttl30Ots = (JSPUtil.getParameter(request, prefix	+ "ttl_30_ots", length));
			String[] ttl180Ots = (JSPUtil.getParameter(request, prefix	+ "ttl_180_ots", length));
			String[] ttl15Ots = (JSPUtil.getParameter(request, prefix	+ "ttl_15_ots", length));
			String[] ttlOver180Ots = (JSPUtil.getParameter(request, prefix	+ "ttl_over_180_ots", length));
			String[] salRepNm = (JSPUtil.getParameter(request, prefix	+ "sal_rep_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ttl60Ots = (JSPUtil.getParameter(request, prefix	+ "ttl_60_ots", length));
			
			for (int i = 0; i < length; i++) {
				model = new GRWEmailSalesRepVO();
				if (srFlg[i] != null)
					model.setSrFlg(srFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (ttl90Ots[i] != null)
					model.setTtl90Ots(ttl90Ots[i]);
				if (salRep[i] != null)
					model.setSalRep(salRep[i]);
				if (ttlOts[i] != null)
					model.setTtlOts(ttlOts[i]);
				if (ttl30Ots[i] != null)
					model.setTtl30Ots(ttl30Ots[i]);
				if (ttl180Ots[i] != null)
					model.setTtl180Ots(ttl180Ots[i]);
				if (ttl15Ots[i] != null)
					model.setTtl15Ots(ttl15Ots[i]);
				if (ttlOver180Ots[i] != null)
					model.setTtlOver180Ots(ttlOver180Ots[i]);
				if (salRepNm[i] != null)
					model.setSalRepNm(salRepNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ttl60Ots[i] != null)
					model.setTtl60Ots(ttl60Ots[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGRWEmailSalesRepVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GRWEmailSalesRepVO[]
	 */
	public GRWEmailSalesRepVO[] getGRWEmailSalesRepVOs(){
		GRWEmailSalesRepVO[] vos = (GRWEmailSalesRepVO[])models.toArray(new GRWEmailSalesRepVO[models.size()]);
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
		this.srFlg = this.srFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttl90Ots = this.ttl90Ots .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.salRep = this.salRep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlOts = this.ttlOts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttl30Ots = this.ttl30Ots .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttl180Ots = this.ttl180Ots .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttl15Ots = this.ttl15Ots .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlOver180Ots = this.ttlOver180Ots .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.salRepNm = this.salRepNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttl60Ots = this.ttl60Ots .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
