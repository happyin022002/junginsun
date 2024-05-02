/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DamageRevenueEmptyListVO01.java
*@FileTitle : DamageRevenueEmptyListVO01
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/

package com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DamageRevenueEmptyList01VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DamageRevenueEmptyList01VO> models = new ArrayList<DamageRevenueEmptyList01VO>();
	
	/* Column Info */
	private String bayNo = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String xxx = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DamageRevenueEmptyList01VO() {}

	/**
	 * DamageRevenueEmptyListVO01 
	 * @param String ibflag
	 * @param String pagerows
	 * @param String cntrNo
	 * @param String cntrTpszCd
	 * @param String polCd
	 * @param String podCd
	 * @param String bayNo
	 * @param String xxx
	 * @param String bkgNo
	 */
	public DamageRevenueEmptyList01VO(String ibflag, String pagerows, String cntrNo, String cntrTpszCd, String polCd, String podCd, String bayNo, String xxx, String bkgNo) {
		this.bayNo = bayNo;
		this.podCd = podCd;
		this.xxx = xxx;
		this.bkgNo = bkgNo;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.cntrNo = cntrNo;
		this.cntrTpszCd = cntrTpszCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * Hashtable<"column_name", "value">
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bay_no", getBayNo()); 
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("xxx", getXxx());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * Hashtable<"column_name", "variable">    
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bay_no", "bayNo");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("xxx", "xxx");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bayNo
	 */
	public String getBayNo() {
		return this.bayNo;
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
	 * @return xxx
	 */
	public String getXxx() {
		return this.xxx;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
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
	 * @param bayNo
	 */
	public void setBayNo(String bayNo) {
		this.bayNo = bayNo;
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
	 * @param xxx
	 */
	public void setXxx(String xxx) {
		this.xxx = xxx;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Request  VO .
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBayNo(JSPUtil.getParameter(request, "bay_no", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setXxx(JSPUtil.getParameter(request, "xxx", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request  VO 
	 * @param request
	 * @return DamageRevenueEmptyListVO01[]
	 */
	public DamageRevenueEmptyList01VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * @param request
	 * @param prefix
	 * @return DamageRevenueEmptyListVO01[]
	 */
	public DamageRevenueEmptyList01VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DamageRevenueEmptyList01VO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bayNo = (JSPUtil.getParameter(request, prefix	+ "bay_no", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] xxx = (JSPUtil.getParameter(request, prefix	+ "xxx", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new DamageRevenueEmptyList01VO();
				if (bayNo[i] != null)
					model.setBayNo(bayNo[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (xxx[i] != null)
					model.setXxx(xxx[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDamageRevenueEmptyListVO01s();
	}

	/**
	 * @return DamageRevenueEmptyListVO01[]
	 */
	public DamageRevenueEmptyList01VO[] getDamageRevenueEmptyListVO01s(){
		DamageRevenueEmptyList01VO[] vos = (DamageRevenueEmptyList01VO[])models.toArray(new DamageRevenueEmptyList01VO[models.size()]);
		return vos;
	}
	
	/**
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
	*/
	public void unDataFormat(){
		this.bayNo = this.bayNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xxx = this.xxx .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
