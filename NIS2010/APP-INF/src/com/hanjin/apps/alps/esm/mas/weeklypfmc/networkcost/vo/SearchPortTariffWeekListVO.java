/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchPortTariffWeekListVO.java
*@FileTitle : SearchPortTariffWeekListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.16
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.16  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo;

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

public class SearchPortTariffWeekListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchPortTariffWeekListVO> models = new ArrayList<SearchPortTariffWeekListVO>();
	
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String vslCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String portOrgAmt = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String wkVslRt = null;
	/* Column Info */
	private String wkVslDtrbAmt = null;
	/* Column Info */
	private String wkTtlAmt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchPortTariffWeekListVO() {}

	public SearchPortTariffWeekListVO(String ibflag, String pagerows, String costWk, String slanCd, String vvd, String vslCd, String skdVoyNo, String skdDirCd, String cntCd, String portOrgAmt, String wkVslRt, String wkVslDtrbAmt, String wkTtlAmt) {
		this.vvd = vvd;
		this.vslCd = vslCd;
		this.ibflag = ibflag;
		this.slanCd = slanCd;
		this.portOrgAmt = portOrgAmt;
		this.costWk = costWk;
		this.cntCd = cntCd;
		this.skdVoyNo = skdVoyNo;
		this.wkVslRt = wkVslRt;
		this.wkVslDtrbAmt = wkVslDtrbAmt;
		this.wkTtlAmt = wkTtlAmt;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("port_org_amt", getPortOrgAmt());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("wk_vsl_rt", getWkVslRt());
		this.hashColumns.put("wk_vsl_dtrb_amt", getWkVslDtrbAmt());
		this.hashColumns.put("wk_ttl_amt", getWkTtlAmt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("port_org_amt", "portOrgAmt");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("wk_vsl_rt", "wkVslRt");
		this.hashFields.put("wk_vsl_dtrb_amt", "wkVslDtrbAmt");
		this.hashFields.put("wk_ttl_amt", "wkTtlAmt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
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
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return portOrgAmt
	 */
	public String getPortOrgAmt() {
		return this.portOrgAmt;
	}
	
	/**
	 * Column Info
	 * @return costWk
	 */
	public String getCostWk() {
		return this.costWk;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return wkVslRt
	 */
	public String getWkVslRt() {
		return this.wkVslRt;
	}
	
	/**
	 * Column Info
	 * @return wkVslDtrbAmt
	 */
	public String getWkVslDtrbAmt() {
		return this.wkVslDtrbAmt;
	}
	
	/**
	 * Column Info
	 * @return wkTtlAmt
	 */
	public String getWkTtlAmt() {
		return this.wkTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
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
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param portOrgAmt
	 */
	public void setPortOrgAmt(String portOrgAmt) {
		this.portOrgAmt = portOrgAmt;
	}
	
	/**
	 * Column Info
	 * @param costWk
	 */
	public void setCostWk(String costWk) {
		this.costWk = costWk;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param wkVslRt
	 */
	public void setWkVslRt(String wkVslRt) {
		this.wkVslRt = wkVslRt;
	}
	
	/**
	 * Column Info
	 * @param wkVslDtrbAmt
	 */
	public void setWkVslDtrbAmt(String wkVslDtrbAmt) {
		this.wkVslDtrbAmt = wkVslDtrbAmt;
	}
	
	/**
	 * Column Info
	 * @param wkTtlAmt
	 */
	public void setWkTtlAmt(String wkTtlAmt) {
		this.wkTtlAmt = wkTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setPortOrgAmt(JSPUtil.getParameter(request, prefix + "port_org_amt", ""));
		setCostWk(JSPUtil.getParameter(request, prefix + "cost_wk", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setWkVslRt(JSPUtil.getParameter(request, prefix + "wk_vsl_rt", ""));
		setWkVslDtrbAmt(JSPUtil.getParameter(request, prefix + "wk_vsl_dtrb_amt", ""));
		setWkTtlAmt(JSPUtil.getParameter(request, prefix + "wk_ttl_amt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchPortTariffWeekListVO[]
	 */
	public SearchPortTariffWeekListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchPortTariffWeekListVO[]
	 */
	public SearchPortTariffWeekListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchPortTariffWeekListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] portOrgAmt = (JSPUtil.getParameter(request, prefix	+ "port_org_amt", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] wkVslRt = (JSPUtil.getParameter(request, prefix	+ "wk_vsl_rt", length));
			String[] wkVslDtrbAmt = (JSPUtil.getParameter(request, prefix	+ "wk_vsl_dtrb_amt", length));
			String[] wkTtlAmt = (JSPUtil.getParameter(request, prefix	+ "wk_ttl_amt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchPortTariffWeekListVO();
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (portOrgAmt[i] != null)
					model.setPortOrgAmt(portOrgAmt[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (wkVslRt[i] != null)
					model.setWkVslRt(wkVslRt[i]);
				if (wkVslDtrbAmt[i] != null)
					model.setWkVslDtrbAmt(wkVslDtrbAmt[i]);
				if (wkTtlAmt[i] != null)
					model.setWkTtlAmt(wkTtlAmt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchPortTariffWeekListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchPortTariffWeekListVO[]
	 */
	public SearchPortTariffWeekListVO[] getSearchPortTariffWeekListVOs(){
		SearchPortTariffWeekListVO[] vos = (SearchPortTariffWeekListVO[])models.toArray(new SearchPortTariffWeekListVO[models.size()]);
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
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portOrgAmt = this.portOrgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wkVslRt = this.wkVslRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wkVslDtrbAmt = this.wkVslDtrbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wkTtlAmt = this.wkTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
