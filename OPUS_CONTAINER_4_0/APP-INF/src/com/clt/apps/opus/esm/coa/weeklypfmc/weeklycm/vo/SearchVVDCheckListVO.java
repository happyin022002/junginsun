/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchVVDCheckListVO.java
*@FileTitle : SearchVVDCheckListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 박수훈
*@LastVersion : 1.0
* 2009.10.16 박수훈 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박수훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchVVDCheckListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchVVDCheckListVO> models = new ArrayList<SearchVVDCheckListVO>();
	
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String slsYrmon = null;
	/* Column Info */
	private String lstLodgPortEtdDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String wkyMnlFlg = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String lstLodgPortCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchVVDCheckListVO() {}

	public SearchVVDCheckListVO(String ibflag, String pagerows, String costYrmon, String slsYrmon, String costWk, String trdCd, String rlaneCd, String iocCd, String vslCd, String skdVoyNo, String dirCd, String lstLodgPortCd, String lstLodgPortEtdDt, String wkyMnlFlg) {
		this.iocCd = iocCd;
		this.vslCd = vslCd;
		this.trdCd = trdCd;
		this.skdVoyNo = skdVoyNo;
		this.rlaneCd = rlaneCd;
		this.pagerows = pagerows;
		this.slsYrmon = slsYrmon;
		this.lstLodgPortEtdDt = lstLodgPortEtdDt;
		this.ibflag = ibflag;
		this.costYrmon = costYrmon;
		this.costWk = costWk;
		this.wkyMnlFlg = wkyMnlFlg;
		this.dirCd = dirCd;
		this.lstLodgPortCd = lstLodgPortCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sls_yrmon", getSlsYrmon());
		this.hashColumns.put("lst_lodg_port_etd_dt", getLstLodgPortEtdDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("wky_mnl_flg", getWkyMnlFlg());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("lst_lodg_port_cd", getLstLodgPortCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sls_yrmon", "slsYrmon");
		this.hashFields.put("lst_lodg_port_etd_dt", "lstLodgPortEtdDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("wky_mnl_flg", "wkyMnlFlg");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("lst_lodg_port_cd", "lstLodgPortCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return iocCd
	 */
	public String getIocCd() {
		return this.iocCd;
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
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
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
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
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
	 * @return slsYrmon
	 */
	public String getSlsYrmon() {
		return this.slsYrmon;
	}
	
	/**
	 * Column Info
	 * @return lstLodgPortEtdDt
	 */
	public String getLstLodgPortEtdDt() {
		return this.lstLodgPortEtdDt;
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
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
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
	 * @return wkyMnlFlg
	 */
	public String getWkyMnlFlg() {
		return this.wkyMnlFlg;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return lstLodgPortCd
	 */
	public String getLstLodgPortCd() {
		return this.lstLodgPortCd;
	}
	

	/**
	 * Column Info
	 * @param iocCd
	 */
	public void setIocCd(String iocCd) {
		this.iocCd = iocCd;
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
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
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
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
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
	 * @param slsYrmon
	 */
	public void setSlsYrmon(String slsYrmon) {
		this.slsYrmon = slsYrmon;
	}
	
	/**
	 * Column Info
	 * @param lstLodgPortEtdDt
	 */
	public void setLstLodgPortEtdDt(String lstLodgPortEtdDt) {
		this.lstLodgPortEtdDt = lstLodgPortEtdDt;
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
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
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
	 * @param wkyMnlFlg
	 */
	public void setWkyMnlFlg(String wkyMnlFlg) {
		this.wkyMnlFlg = wkyMnlFlg;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param lstLodgPortCd
	 */
	public void setLstLodgPortCd(String lstLodgPortCd) {
		this.lstLodgPortCd = lstLodgPortCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIocCd(JSPUtil.getParameter(request, "ioc_cd", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSlsYrmon(JSPUtil.getParameter(request, "sls_yrmon", ""));
		setLstLodgPortEtdDt(JSPUtil.getParameter(request, "lst_lodg_port_etd_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCostYrmon(JSPUtil.getParameter(request, "cost_yrmon", ""));
		setCostWk(JSPUtil.getParameter(request, "cost_wk", ""));
		setWkyMnlFlg(JSPUtil.getParameter(request, "wky_mnl_flg", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setLstLodgPortCd(JSPUtil.getParameter(request, "lst_lodg_port_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchVVDCheckListVO[]
	 */
	public SearchVVDCheckListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchVVDCheckListVO[]
	 */
	public SearchVVDCheckListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchVVDCheckListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] slsYrmon = (JSPUtil.getParameter(request, prefix	+ "sls_yrmon", length));
			String[] lstLodgPortEtdDt = (JSPUtil.getParameter(request, prefix	+ "lst_lodg_port_etd_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] wkyMnlFlg = (JSPUtil.getParameter(request, prefix	+ "wky_mnl_flg", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] lstLodgPortCd = (JSPUtil.getParameter(request, prefix	+ "lst_lodg_port_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchVVDCheckListVO();
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (slsYrmon[i] != null)
					model.setSlsYrmon(slsYrmon[i]);
				if (lstLodgPortEtdDt[i] != null)
					model.setLstLodgPortEtdDt(lstLodgPortEtdDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (wkyMnlFlg[i] != null)
					model.setWkyMnlFlg(wkyMnlFlg[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (lstLodgPortCd[i] != null)
					model.setLstLodgPortCd(lstLodgPortCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchVVDCheckListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchVVDCheckListVO[]
	 */
	public SearchVVDCheckListVO[] getSearchVVDCheckListVOs(){
		SearchVVDCheckListVO[] vos = (SearchVVDCheckListVO[])models.toArray(new SearchVVDCheckListVO[models.size()]);
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
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsYrmon = this.slsYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstLodgPortEtdDt = this.lstLodgPortEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wkyMnlFlg = this.wkyMnlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstLodgPortCd = this.lstLodgPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
