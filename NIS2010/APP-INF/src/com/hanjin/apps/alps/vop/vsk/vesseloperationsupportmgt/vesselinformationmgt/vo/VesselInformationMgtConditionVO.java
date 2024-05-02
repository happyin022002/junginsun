/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselInformationMgtConditionVO.java
*@FileTitle : VesselInformationMgtConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.26
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.06.26 김종옥 
* 1.0 Creation
* 
* 2014.03.17 박다은 [CHM-201428939-01] vessel particular - performance
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo;

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
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VesselInformationMgtConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VesselInformationMgtConditionVO> models = new ArrayList<VesselInformationMgtConditionVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String hVslSlanCd = null;
	/* Column Info */
	private String hPfSkdTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String year = null;
	/* Page Number */
	private String pagerows = null;
	/* Page Number */
	private String vslSlanCd = null;
	/* Page Number */
	private String crrCd = null;
	/* Page Number */
	private String vslSvcTpCd = null;
	/* Page Number */
	private String vpsEtaDt = null;
	/* Page Number */
	private String cntrVslClssCapa = null;
	
	
	/* Column Info */
	private String vslType = null;
	/* Column Info */
	private String toDate = null;
	/* Column Info */ 
	private String fmDate = null;  
	/* Column Info */ 
	private String vslOwnIndCd = null;
	/* Page Number */
	private String pageNo = null;

	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VesselInformationMgtConditionVO() {}

	public VesselInformationMgtConditionVO(String ibflag, String pagerows, String vslCd, String year, String hPfSkdTpCd, String hVslSlanCd, String crrCd, String vslSlanCd, String vslSvcTpCd, String vpsEtaDt, String cntrVslClssCapa) {
		this.vslCd = vslCd;
		this.ibflag = ibflag;
		this.year = year;
		this.pagerows = pagerows;
		this.hVslSlanCd = hVslSlanCd;
		this.hPfSkdTpCd = hPfSkdTpCd;
		this.crrCd           = crrCd          ;
		this.vslSlanCd       = vslSlanCd      ;
		this.vslSvcTpCd      = vslSvcTpCd     ;
		this.vpsEtaDt        = vpsEtaDt       ;
		this.cntrVslClssCapa = cntrVslClssCapa;
		this.vslType 		 = vslType; 
		this.toDate 		 = toDate; 
		this.fmDate 		 = fmDate; 
		this.vslOwnIndCd 	 = vslOwnIndCd;
		this.pageNo			 = pageNo;

	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("h_vsl_slan_cd", getHVslSlanCd());
		this.hashColumns.put("h_pf_skd_tp_cd", getHPfSkdTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("year", getYear());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("vsl_svc_tp_cd", getVslSvcTpCd());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("cntr_vsl_clss_capa", getCntrVslClssCapa());
		this.hashColumns.put("vsl_type", getVslType());
		this.hashColumns.put("to_date", getToDate());
		this.hashColumns.put("fm_date", getFmDate());
		this.hashColumns.put("vsl_own_ind_cd", getVslOwnIndCd());
		this.hashColumns.put("page_no", getPageNo());

		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("h_vsl_slan_cd", "hVslSlanCd");
		this.hashFields.put("h_pf_skd_tp_cd", "hPfSkdTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("year", "year");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("vsl_svc_tp_cd", "vslSvcTpCd");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("cntr_vsl_clss_capa", "cntrVslClssCapa");
		this.hashFields.put("vsl_type", "vslType");
		this.hashFields.put("to_date", "toDate");
		this.hashFields.put("fm_date", "fmDate");
		this.hashFields.put("vsl_own_ind_cd", "vslOwnIndCd");
		this.hashFields.put("page_no", "pageNo");

		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return hVslSlanCd
	 */
	public String getHVslSlanCd() {
		return this.hVslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return hPfSkdTpCd
	 */
	public String getHPfSkdTpCd() {
		return this.hPfSkdTpCd;
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
	 * @return year
	 */
	public String getYear() {
		return this.year;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Page Number
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
	}
	
	/**
	 * Page Number
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
	}
	
	/**
	 * Page Number
	 * @return vslSvcTpCd
	 */
	public String getVslSvcTpCd() {
		return this.vslSvcTpCd;
	}
	
	/**
	 * Page Number
	 * @return vpsEtaDt
	 */
	public String getVpsEtaDt() {
		return this.vpsEtaDt;
	}
	
	/**
	 * Page Number
	 * @return cntrVslClssCapa
	 */
	public String getCntrVslClssCapa() {
		return this.cntrVslClssCapa;
	}
	
	/**
	 * Column Info
	 * @return vslType
	 */
	public String getVslType() {
		return this.vslType;
	}
	
	/**
	 * Column Info
	 * @return toDate
	 */
	public String getToDate() {
		return this.toDate;
	}
	
	/**
	 * Column Info
	 * @return fmDate
	 */
	public String getFmDate() {
		return this.fmDate;
	}
	
	/**
	 * Column Info
	 * @return vslOwnIndCd
	 */
	public String getVslOwnIndCd() {
		return this.vslOwnIndCd;
	}
	
	/**
	 * Column Info
	 * @return pageNo
	 */
	public String getPageNo() {
		return this.pageNo;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param hVslSlanCd
	 */
	public void setHVslSlanCd(String hVslSlanCd) {
		this.hVslSlanCd = hVslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param hPfSkdTpCd
	 */
	public void setHPfSkdTpCd(String hPfSkdTpCd) {
		this.hPfSkdTpCd = hPfSkdTpCd;
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
	 * @param year
	 */
	public void setYear(String year) {
		this.year = year;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Page Number
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
	}
	
	/**
	 * Page Number
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}
	
	/**
	 * Page Number
	 * @param vslSvcTpCd
	 */
	public void setVslSvcTpCd(String vslSvcTpCd) {
		this.vslSvcTpCd = vslSvcTpCd;
	}
	
	/**
	 * Page Number
	 * @param vpsEtaDt
	 */
	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
	}
	
	/**
	 * Page Number
	 * @param cntrVslClssCapa
	 */
	public void setCntrVslClssCapa(String cntrVslClssCapa) {
		this.cntrVslClssCapa = cntrVslClssCapa;
	}
	
	/**
	 * Column Info
	 * @param vslType
	 */
	public void setVslType(String vslType) {
		this.vslType = vslType;
	}
	
	/**
	 * Column Info
	 * @param vslType
	 */
	public void setFmDate(String fmDate) {
		this.fmDate = fmDate;
	}
	
	/**
	 * Column Info
	 * @param toDate
	 */
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	
	/**
	 * Column Info
	 * @param vslOwnIndCd
	 */
	public void setVslOwnIndCd(String vslOwnIndCd) {
		this.vslOwnIndCd = vslOwnIndCd;
	}
	
	/**
	 * Column Info
	 * @param pageNo
	 */
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setHVslSlanCd(JSPUtil.getParameter(request, "h_vsl_slan_cd", ""));
		setHPfSkdTpCd(JSPUtil.getParameter(request, "h_pf_skd_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setYear(JSPUtil.getParameter(request, "year", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		
		setCrrCd(JSPUtil.getParameter(request, "crr_cd", ""));
		setVslSlanCd(JSPUtil.getParameter(request, "vsl_slan_cd", ""));
		setVslSvcTpCd(JSPUtil.getParameter(request, "vsl_svc_tp_cd", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, "vps_eta_dt", ""));
		setCntrVslClssCapa(JSPUtil.getParameter(request, "cntr_vsl_clss_capa", ""));
		
		setVslType(JSPUtil.getParameter(request, "vsl_type", ""));
		setFmDate(JSPUtil.getParameter(request, "fm_date", ""));
		setToDate(JSPUtil.getParameter(request, "to_date", ""));
		setVslOwnIndCd(JSPUtil.getParameter(request, "vsl_own_ind_cd", ""));
		setPageNo(JSPUtil.getParameter(request, "page_no", ""));

	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VesselInformationMgtConditionVO[]
	 */
	public VesselInformationMgtConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VesselInformationMgtConditionVO[]
	 */
	public VesselInformationMgtConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VesselInformationMgtConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] hVslSlanCd = (JSPUtil.getParameter(request, prefix	+ "h_vsl_slan_cd", length));
			String[] hPfSkdTpCd = (JSPUtil.getParameter(request, prefix	+ "h_pf_skd_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] year = (JSPUtil.getParameter(request, prefix	+ "year", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] vslSvcTpCd = (JSPUtil.getParameter(request, prefix	+ "vsl_svc_tp_cd", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] cntrVslClssCapa = (JSPUtil.getParameter(request, prefix	+ "cntr_vsl_clss_capa", length));
			
			String[] vslType = (JSPUtil.getParameter(request, prefix	+ "vsl_type", length));
			String[] toDate = (JSPUtil.getParameter(request, prefix	+ "to_date", length));
			String[] fmDate = (JSPUtil.getParameter(request, prefix	+ "fm_date", length));
			String[] vslOwnIndCd = (JSPUtil.getParameter(request, prefix	+ "vsl_own_ind_cd", length));
			String[] pageNo = (JSPUtil.getParameter(request, prefix	+ "page_no", length));

			
			
			for (int i = 0; i < length; i++) {
				model = new VesselInformationMgtConditionVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (hVslSlanCd[i] != null)
					model.setHVslSlanCd(hVslSlanCd[i]);
				if (hPfSkdTpCd[i] != null)
					model.setHPfSkdTpCd(hPfSkdTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (year[i] != null)
					model.setYear(year[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (crrCd[i] != null) 
					model.setCrrCd(crrCd[i]);
				if (vslSlanCd[i] != null) 
					model.setVslSlanCd(vslSlanCd[i]);
				if (vslSvcTpCd[i] != null) 
					model.setVslSvcTpCd(vslSvcTpCd[i]);
				if (vpsEtaDt[i] != null) 
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (cntrVslClssCapa[i] != null) 
					model.setCntrVslClssCapa(cntrVslClssCapa[i]);
				
				if (vslType[i] != null) 
					model.setVslType(vslType[i]);
				if (toDate[i] != null) 
					model.setFmDate(toDate[i]);
				if (fmDate[i] != null) 
					model.setToDate(fmDate[i]);
				if (vslOwnIndCd[i] != null) 
					model.setVslOwnIndCd(vslOwnIndCd[i]);
				if (pageNo[i] != null) 
					model.setPageNo(pageNo[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVesselInformationMgtConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VesselInformationMgtConditionVO[]
	 */
	public VesselInformationMgtConditionVO[] getVesselInformationMgtConditionVOs(){
		VesselInformationMgtConditionVO[] vos = (VesselInformationMgtConditionVO[])models.toArray(new VesselInformationMgtConditionVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hVslSlanCd = this.hVslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hPfSkdTpCd = this.hPfSkdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.year = this.year .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSvcTpCd = this.vslSvcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVslClssCapa = this.cntrVslClssCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.vslType = this.vslType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDate = this.toDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDate = this.fmDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslOwnIndCd = this.vslOwnIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pageNo = this.pageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");


	}
}
