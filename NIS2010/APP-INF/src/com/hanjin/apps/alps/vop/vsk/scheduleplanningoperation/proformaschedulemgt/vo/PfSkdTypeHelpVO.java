/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PfSkdTypeHelpVO.java
*@FileTitle : PfSkdTypeHelpVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.04.30 서창열 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 서창열
 * @since J2EE 1.5
 */

public class PfSkdTypeHelpVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PfSkdTypeHelpVO> models = new ArrayList<PfSkdTypeHelpVO>();
	
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String vslSvcTpCd = null;
	/* Column Info */
	private String pfSvcTpCd = null;
	/* Column Info */
	private String slanStndFlg = null;
	/* Column Info */
	private String vslClass = null;
	/* Column Info */
	private String vslSlanNm = null;
	/* Column Info */
	private String creDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PfSkdTypeHelpVO() {}

	public PfSkdTypeHelpVO(String ibflag, String pagerows, String vslSlanCd, String pfSvcTpCd, String vslSlanNm, String vslClass, String slanStndFlg, String vslSvcTpCd, String creDt) {
		this.ibflag = ibflag;
		this.vslSlanCd = vslSlanCd;
		this.vslSvcTpCd = vslSvcTpCd;
		this.pfSvcTpCd = pfSvcTpCd;
		this.slanStndFlg = slanStndFlg;
		this.vslClass = vslClass;
		this.vslSlanNm = vslSlanNm;
		this.creDt = creDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("vsl_svc_tp_cd", getVslSvcTpCd());
		this.hashColumns.put("pf_svc_tp_cd", getPfSvcTpCd());
		this.hashColumns.put("slan_stnd_flg", getSlanStndFlg());
		this.hashColumns.put("vsl_class", getVslClass());
		this.hashColumns.put("vsl_slan_nm", getVslSlanNm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("vsl_svc_tp_cd", "vslSvcTpCd");
		this.hashFields.put("pf_svc_tp_cd", "pfSvcTpCd");
		this.hashFields.put("slan_stnd_flg", "slanStndFlg");
		this.hashFields.put("vsl_class", "vslClass");
		this.hashFields.put("vsl_slan_nm", "vslSlanNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getIbflag() {
		return this.ibflag;
	}
	public String getVslSlanCd() {
		return this.vslSlanCd;
	}
	public String getVslSvcTpCd() {
		return this.vslSvcTpCd;
	}
	public String getPfSvcTpCd() {
		return this.pfSvcTpCd;
	}
	public String getSlanStndFlg() {
		return this.slanStndFlg;
	}
	public String getVslClass() {
		return this.vslClass;
	}
	public String getVslSlanNm() {
		return this.vslSlanNm;
	}
	public String getCreDt() {
		return this.creDt;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
		//this.vslSlanCd=true;
	}
	public void setVslSvcTpCd(String vslSvcTpCd) {
		this.vslSvcTpCd = vslSvcTpCd;
		//this.vslSvcTpCd=true;
	}
	public void setPfSvcTpCd(String pfSvcTpCd) {
		this.pfSvcTpCd = pfSvcTpCd;
		//this.pfSvcTpCd=true;
	}
	public void setSlanStndFlg(String slanStndFlg) {
		this.slanStndFlg = slanStndFlg;
		//this.slanStndFlg=true;
	}
	public void setVslClass(String vslClass) {
		this.vslClass = vslClass;
		//this.vslClass=true;
	}
	public void setVslSlanNm(String vslSlanNm) {
		this.vslSlanNm = vslSlanNm;
		//this.vslSlanNm=true;
	}
	public void setCreDt(String creDt) {
		this.creDt = creDt;
		//this.vslSlanNm=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVslSlanCd(JSPUtil.getParameter(request, "vsl_slan_cd", ""));
		setVslSvcTpCd(JSPUtil.getParameter(request, "vsl_svc_tp_cd", ""));
		setPfSvcTpCd(JSPUtil.getParameter(request, "pf_svc_tp_cd", ""));
		setSlanStndFlg(JSPUtil.getParameter(request, "slan_stnd_flg", ""));
		setVslClass(JSPUtil.getParameter(request, "vsl_class", ""));
		setVslSlanNm(JSPUtil.getParameter(request, "vsl_slan_nm", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public PfSkdTypeHelpVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public PfSkdTypeHelpVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PfSkdTypeHelpVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd".trim(), length));
			String[] vslSvcTpCd = (JSPUtil.getParameter(request, prefix	+ "vsl_svc_tp_cd".trim(), length));
			String[] pfSvcTpCd = (JSPUtil.getParameter(request, prefix	+ "pf_svc_tp_cd".trim(), length));
			String[] slanStndFlg = (JSPUtil.getParameter(request, prefix	+ "slan_stnd_flg".trim(), length));
			String[] vslClass = (JSPUtil.getParameter(request, prefix	+ "vsl_class".trim(), length));
			String[] vslSlanNm = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_nm".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new PfSkdTypeHelpVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (vslSvcTpCd[i] != null)
					model.setVslSvcTpCd(vslSvcTpCd[i]);
				if (pfSvcTpCd[i] != null)
					model.setPfSvcTpCd(pfSvcTpCd[i]);
				if (slanStndFlg[i] != null)
					model.setSlanStndFlg(slanStndFlg[i]);
				if (vslClass[i] != null)
					model.setVslClass(vslClass[i]);
				if (vslSlanNm[i] != null)
					model.setVslSlanNm(vslSlanNm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getPfSkdTypeHelpVOs();
	}

	public PfSkdTypeHelpVO[] getPfSkdTypeHelpVOs(){
		PfSkdTypeHelpVO[] vos = (PfSkdTypeHelpVO[])models.toArray(new PfSkdTypeHelpVO[models.size()]);
		return vos;
	}
	
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
		} catch (Exception ex) {}
		return ret.toString();
	}
	
	/**
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 * @throws IllegalAccessException
	 */
	private String[] getField(Field[] field, int i) throws IllegalAccessException {
		String[] arr;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void onDataFormat(){
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSvcTpCd = this.vslSvcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfSvcTpCd = this.pfSvcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanStndFlg = this.slanStndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslClass = this.vslClass .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanNm = this.vslSlanNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
