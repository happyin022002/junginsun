/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommodityTariffRegionParamVO.java
*@FileTitle : CommodityTariffRegionParamVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.08.03 김태균 
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

public class CommodityTariffRegionParamVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CommodityTariffRegionParamVO> models = new ArrayList<CommodityTariffRegionParamVO>();
	
	/* Column Info */
	private String validity3 = null;
	/* Column Info */
	private String validity2 = null;
	/* Column Info */
	private String dmdtTrfCdIn = null;
	/* Column Info */
	private String orgDestSteCd = null;
	/* Column Info */
	private String cfmFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cvrgRgnCd = null;
	/* Column Info */
	private String orgDestContiCd = null;
	/* Column Info */
	private String cvrgSteCd = null;
	/* Column Info */
	private String dmdtTrfCdList = null;
	/* Column Info */
	private String validity1 = null;
	/* Column Info */
	private String cvrgContiCd = null;
	/* Column Info */
	private String cvrgCntCd = null;
	/* Column Info */
	private String orgDestCntCd = null;
	/* Column Info */
	private String orgDestRgnCd = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String cvrgLocCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CommodityTariffRegionParamVO() {}

	public CommodityTariffRegionParamVO(String ibflag, String pagerows, String cvrgContiCd, String cvrgCntCd, String cvrgRgnCd, String cvrgSteCd, String cvrgLocCd, String orgDestContiCd, String orgDestCntCd, String orgDestRgnCd, String orgDestSteCd, String dmdtTrfCdIn, String dmdtTrfCdList, String dmdtTrfCd, String validity1, String validity2, String validity3, String cfmFlg) {
		this.validity3 = validity3;
		this.validity2 = validity2;
		this.dmdtTrfCdIn = dmdtTrfCdIn;
		this.orgDestSteCd = orgDestSteCd;
		this.cfmFlg = cfmFlg;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.cvrgRgnCd = cvrgRgnCd;
		this.orgDestContiCd = orgDestContiCd;
		this.cvrgSteCd = cvrgSteCd;
		this.dmdtTrfCdList = dmdtTrfCdList;
		this.validity1 = validity1;
		this.cvrgContiCd = cvrgContiCd;
		this.cvrgCntCd = cvrgCntCd;
		this.orgDestCntCd = orgDestCntCd;
		this.orgDestRgnCd = orgDestRgnCd;
		this.dmdtTrfCd = dmdtTrfCd;
		this.cvrgLocCd = cvrgLocCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("validity3", getValidity3());
		this.hashColumns.put("validity2", getValidity2());
		this.hashColumns.put("dmdt_trf_cd_in", getDmdtTrfCdIn());
		this.hashColumns.put("org_dest_ste_cd", getOrgDestSteCd());
		this.hashColumns.put("cfm_flg", getCfmFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cvrg_rgn_cd", getCvrgRgnCd());
		this.hashColumns.put("org_dest_conti_cd", getOrgDestContiCd());
		this.hashColumns.put("cvrg_ste_cd", getCvrgSteCd());
		this.hashColumns.put("dmdt_trf_cd_list", getDmdtTrfCdList());
		this.hashColumns.put("validity1", getValidity1());
		this.hashColumns.put("cvrg_conti_cd", getCvrgContiCd());
		this.hashColumns.put("cvrg_cnt_cd", getCvrgCntCd());
		this.hashColumns.put("org_dest_cnt_cd", getOrgDestCntCd());
		this.hashColumns.put("org_dest_rgn_cd", getOrgDestRgnCd());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("cvrg_loc_cd", getCvrgLocCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("validity3", "validity3");
		this.hashFields.put("validity2", "validity2");
		this.hashFields.put("dmdt_trf_cd_in", "dmdtTrfCdIn");
		this.hashFields.put("org_dest_ste_cd", "orgDestSteCd");
		this.hashFields.put("cfm_flg", "cfmFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cvrg_rgn_cd", "cvrgRgnCd");
		this.hashFields.put("org_dest_conti_cd", "orgDestContiCd");
		this.hashFields.put("cvrg_ste_cd", "cvrgSteCd");
		this.hashFields.put("dmdt_trf_cd_list", "dmdtTrfCdList");
		this.hashFields.put("validity1", "validity1");
		this.hashFields.put("cvrg_conti_cd", "cvrgContiCd");
		this.hashFields.put("cvrg_cnt_cd", "cvrgCntCd");
		this.hashFields.put("org_dest_cnt_cd", "orgDestCntCd");
		this.hashFields.put("org_dest_rgn_cd", "orgDestRgnCd");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("cvrg_loc_cd", "cvrgLocCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return validity3
	 */
	public String getValidity3() {
		return this.validity3;
	}
	
	/**
	 * Column Info
	 * @return validity2
	 */
	public String getValidity2() {
		return this.validity2;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfCdIn
	 */
	public String getDmdtTrfCdIn() {
		return this.dmdtTrfCdIn;
	}
	
	/**
	 * Column Info
	 * @return orgDestSteCd
	 */
	public String getOrgDestSteCd() {
		return this.orgDestSteCd;
	}
	
	/**
	 * Column Info
	 * @return cfmFlg
	 */
	public String getCfmFlg() {
		return this.cfmFlg;
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
	 * @return cvrgRgnCd
	 */
	public String getCvrgRgnCd() {
		return this.cvrgRgnCd;
	}
	
	/**
	 * Column Info
	 * @return orgDestContiCd
	 */
	public String getOrgDestContiCd() {
		return this.orgDestContiCd;
	}
	
	/**
	 * Column Info
	 * @return cvrgSteCd
	 */
	public String getCvrgSteCd() {
		return this.cvrgSteCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfCdList
	 */
	public String getDmdtTrfCdList() {
		return this.dmdtTrfCdList;
	}
	
	/**
	 * Column Info
	 * @return validity1
	 */
	public String getValidity1() {
		return this.validity1;
	}
	
	/**
	 * Column Info
	 * @return cvrgContiCd
	 */
	public String getCvrgContiCd() {
		return this.cvrgContiCd;
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
	 * @return orgDestCntCd
	 */
	public String getOrgDestCntCd() {
		return this.orgDestCntCd;
	}
	
	/**
	 * Column Info
	 * @return orgDestRgnCd
	 */
	public String getOrgDestRgnCd() {
		return this.orgDestRgnCd;
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
	 * @return cvrgLocCd
	 */
	public String getCvrgLocCd() {
		return this.cvrgLocCd;
	}
	

	/**
	 * Column Info
	 * @param validity3
	 */
	public void setValidity3(String validity3) {
		this.validity3 = validity3;
	}
	
	/**
	 * Column Info
	 * @param validity2
	 */
	public void setValidity2(String validity2) {
		this.validity2 = validity2;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfCdIn
	 */
	public void setDmdtTrfCdIn(String dmdtTrfCdIn) {
		this.dmdtTrfCdIn = dmdtTrfCdIn;
	}
	
	/**
	 * Column Info
	 * @param orgDestSteCd
	 */
	public void setOrgDestSteCd(String orgDestSteCd) {
		this.orgDestSteCd = orgDestSteCd;
	}
	
	/**
	 * Column Info
	 * @param cfmFlg
	 */
	public void setCfmFlg(String cfmFlg) {
		this.cfmFlg = cfmFlg;
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
	 * @param cvrgRgnCd
	 */
	public void setCvrgRgnCd(String cvrgRgnCd) {
		this.cvrgRgnCd = cvrgRgnCd;
	}
	
	/**
	 * Column Info
	 * @param orgDestContiCd
	 */
	public void setOrgDestContiCd(String orgDestContiCd) {
		this.orgDestContiCd = orgDestContiCd;
	}
	
	/**
	 * Column Info
	 * @param cvrgSteCd
	 */
	public void setCvrgSteCd(String cvrgSteCd) {
		this.cvrgSteCd = cvrgSteCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfCdList
	 */
	public void setDmdtTrfCdList(String dmdtTrfCdList) {
		this.dmdtTrfCdList = dmdtTrfCdList;
	}
	
	/**
	 * Column Info
	 * @param validity1
	 */
	public void setValidity1(String validity1) {
		this.validity1 = validity1;
	}
	
	/**
	 * Column Info
	 * @param cvrgContiCd
	 */
	public void setCvrgContiCd(String cvrgContiCd) {
		this.cvrgContiCd = cvrgContiCd;
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
	 * @param orgDestCntCd
	 */
	public void setOrgDestCntCd(String orgDestCntCd) {
		this.orgDestCntCd = orgDestCntCd;
	}
	
	/**
	 * Column Info
	 * @param orgDestRgnCd
	 */
	public void setOrgDestRgnCd(String orgDestRgnCd) {
		this.orgDestRgnCd = orgDestRgnCd;
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
	 * @param cvrgLocCd
	 */
	public void setCvrgLocCd(String cvrgLocCd) {
		this.cvrgLocCd = cvrgLocCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setValidity3(JSPUtil.getParameter(request, "validity3", ""));
		setValidity2(JSPUtil.getParameter(request, "validity2", ""));
		setDmdtTrfCdIn(JSPUtil.getParameter(request, "dmdt_trf_cd_in", ""));
		setOrgDestSteCd(JSPUtil.getParameter(request, "org_dest_ste_cd", ""));
		setCfmFlg(JSPUtil.getParameter(request, "cfm_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCvrgRgnCd(JSPUtil.getParameter(request, "cvrg_rgn_cd", ""));
		setOrgDestContiCd(JSPUtil.getParameter(request, "org_dest_conti_cd", ""));
		setCvrgSteCd(JSPUtil.getParameter(request, "cvrg_ste_cd", ""));
		setDmdtTrfCdList(JSPUtil.getParameter(request, "dmdt_trf_cd_list", ""));
		setValidity1(JSPUtil.getParameter(request, "validity1", ""));
		setCvrgContiCd(JSPUtil.getParameter(request, "cvrg_conti_cd", ""));
		setCvrgCntCd(JSPUtil.getParameter(request, "cvrg_cnt_cd", ""));
		setOrgDestCntCd(JSPUtil.getParameter(request, "org_dest_cnt_cd", ""));
		setOrgDestRgnCd(JSPUtil.getParameter(request, "org_dest_rgn_cd", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, "dmdt_trf_cd", ""));
		setCvrgLocCd(JSPUtil.getParameter(request, "cvrg_loc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CommodityTariffRegionParamVO[]
	 */
	public CommodityTariffRegionParamVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CommodityTariffRegionParamVO[]
	 */
	public CommodityTariffRegionParamVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CommodityTariffRegionParamVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] validity3 = (JSPUtil.getParameter(request, prefix	+ "validity3", length));
			String[] validity2 = (JSPUtil.getParameter(request, prefix	+ "validity2", length));
			String[] dmdtTrfCdIn = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd_in", length));
			String[] orgDestSteCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_ste_cd", length));
			String[] cfmFlg = (JSPUtil.getParameter(request, prefix	+ "cfm_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cvrgRgnCd = (JSPUtil.getParameter(request, prefix	+ "cvrg_rgn_cd", length));
			String[] orgDestContiCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_conti_cd", length));
			String[] cvrgSteCd = (JSPUtil.getParameter(request, prefix	+ "cvrg_ste_cd", length));
			String[] dmdtTrfCdList = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd_list", length));
			String[] validity1 = (JSPUtil.getParameter(request, prefix	+ "validity1", length));
			String[] cvrgContiCd = (JSPUtil.getParameter(request, prefix	+ "cvrg_conti_cd", length));
			String[] cvrgCntCd = (JSPUtil.getParameter(request, prefix	+ "cvrg_cnt_cd", length));
			String[] orgDestCntCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_cnt_cd", length));
			String[] orgDestRgnCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_rgn_cd", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] cvrgLocCd = (JSPUtil.getParameter(request, prefix	+ "cvrg_loc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CommodityTariffRegionParamVO();
				if (validity3[i] != null)
					model.setValidity3(validity3[i]);
				if (validity2[i] != null)
					model.setValidity2(validity2[i]);
				if (dmdtTrfCdIn[i] != null)
					model.setDmdtTrfCdIn(dmdtTrfCdIn[i]);
				if (orgDestSteCd[i] != null)
					model.setOrgDestSteCd(orgDestSteCd[i]);
				if (cfmFlg[i] != null)
					model.setCfmFlg(cfmFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cvrgRgnCd[i] != null)
					model.setCvrgRgnCd(cvrgRgnCd[i]);
				if (orgDestContiCd[i] != null)
					model.setOrgDestContiCd(orgDestContiCd[i]);
				if (cvrgSteCd[i] != null)
					model.setCvrgSteCd(cvrgSteCd[i]);
				if (dmdtTrfCdList[i] != null)
					model.setDmdtTrfCdList(dmdtTrfCdList[i]);
				if (validity1[i] != null)
					model.setValidity1(validity1[i]);
				if (cvrgContiCd[i] != null)
					model.setCvrgContiCd(cvrgContiCd[i]);
				if (cvrgCntCd[i] != null)
					model.setCvrgCntCd(cvrgCntCd[i]);
				if (orgDestCntCd[i] != null)
					model.setOrgDestCntCd(orgDestCntCd[i]);
				if (orgDestRgnCd[i] != null)
					model.setOrgDestRgnCd(orgDestRgnCd[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (cvrgLocCd[i] != null)
					model.setCvrgLocCd(cvrgLocCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCommodityTariffRegionParamVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CommodityTariffRegionParamVO[]
	 */
	public CommodityTariffRegionParamVO[] getCommodityTariffRegionParamVOs(){
		CommodityTariffRegionParamVO[] vos = (CommodityTariffRegionParamVO[])models.toArray(new CommodityTariffRegionParamVO[models.size()]);
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
		this.validity3 = this.validity3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.validity2 = this.validity2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCdIn = this.dmdtTrfCdIn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestSteCd = this.orgDestSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmFlg = this.cfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvrgRgnCd = this.cvrgRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestContiCd = this.orgDestContiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvrgSteCd = this.cvrgSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCdList = this.dmdtTrfCdList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.validity1 = this.validity1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvrgContiCd = this.cvrgContiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvrgCntCd = this.cvrgCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestCntCd = this.orgDestCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestRgnCd = this.orgDestRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvrgLocCd = this.cvrgLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
