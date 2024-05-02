/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MasterContainerListVO.java
*@FileTitle : MasterContainerListVO
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

public class MasterContainerListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MasterContainerListVO> models = new ArrayList<MasterContainerListVO>();
	
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
	private String cntrTpszCd = null;
	/* Column Info */
	private String cntrRefNo = null;
	/* Page Number */
	private String pagerows = null;

	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MasterContainerListVO() {}

	public MasterContainerListVO(String ibflag, String pagerows, String cntrRefNo, String cntrTpszCd, String polCd, String podCd, String bayNo, String xxx, String bkgNo) {
		this.bayNo = bayNo;
		this.podCd = podCd;
		this.xxx = xxx;
		this.bkgNo = bkgNo;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.cntrTpszCd = cntrTpszCd;
		this.cntrRefNo = cntrRefNo;
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
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cntr_ref_no", getCntrRefNo());
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
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cntr_ref_no", "cntrRefNo");
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return cntrRefNo
	 */
	public String getCntrRefNo() {
		return this.cntrRefNo;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param cntrRefNo
	 */
	public void setCntrRefNo(String cntrRefNo) {
		this.cntrRefNo = cntrRefNo;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Request --> VO 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBayNo(JSPUtil.getParameter(request, "bay_no", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setXxx(JSPUtil.getParameter(request, "xxx", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setCntrRefNo(JSPUtil.getParameter(request, "cntr_ref_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request --> VO array
	 * @param request
	 * @return MasterContainerListVO[]
	 */
	public MasterContainerListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request --> VO Class  
	 * @param request
	 * @param prefix
	 * @return MasterContainerListVO[]
	 */
	public MasterContainerListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MasterContainerListVO model = null;
		
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
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] cntrRefNo = (JSPUtil.getParameter(request, prefix	+ "cntr_ref_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new MasterContainerListVO();
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
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (cntrRefNo[i] != null)
					model.setCntrRefNo(cntrRefNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMasterContainerListVOs();
	}

	/**
	 * Return vo array
	 * @return MasterContainerListVO[]
	 */
	public MasterContainerListVO[] getMasterContainerListVOs(){
		MasterContainerListVO[] vos = (MasterContainerListVO[])models.toArray(new MasterContainerListVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class --> String
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
	 * Return string array
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
	* Remove special character("-","/",",",":")
	*/
	public void unDataFormat(){
		this.bayNo = this.bayNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xxx = this.xxx .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRefNo = this.cntrRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
