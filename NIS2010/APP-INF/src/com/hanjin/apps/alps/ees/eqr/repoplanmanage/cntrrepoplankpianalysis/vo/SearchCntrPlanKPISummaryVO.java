/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchCntrPlanKPISummaryVO.java
*@FileTitle : SearchCntrPlanKPISummaryVO
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	Lee Byoung Hun	2009.09.17		1.0 최초 생성
*
*@LastModifyDate : 2009.09.17
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.09.17  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplankpianalysis.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchCntrPlanKPISummaryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchCntrPlanKPISummaryVO> models = new ArrayList<SearchCntrPlanKPISummaryVO>();
	
	/* Column Info */
	private String repoPlnId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String utilization = null;
	/* Column Info */
	private String mb = null;
	/* Column Info */
	private String lf = null;
	/* Column Info */
	private String eccCd = null;
	/* Column Info */
	private String rcost = null;
	/* Column Info */
	private String offhire = null;
	/* Column Info */
	private String mty = null;
	/* Column Info */
	private String onhire = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchCntrPlanKPISummaryVO() {}

	public SearchCntrPlanKPISummaryVO(String ibflag, String pagerows, String eccCd, String repoPlnId, String utilization, String mty, String onhire, String offhire, String lf, String mb, String rcost) {
		this.repoPlnId = repoPlnId;
		this.ibflag = ibflag;
		this.utilization = utilization;
		this.mb = mb;
		this.lf = lf;
		this.eccCd = eccCd;
		this.rcost = rcost;
		this.offhire = offhire;
		this.mty = mty;
		this.onhire = onhire;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("repo_pln_id", getRepoPlnId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("utilization", getUtilization());
		this.hashColumns.put("mb", getMb());
		this.hashColumns.put("lf", getLf());
		this.hashColumns.put("ecc_cd", getEccCd());
		this.hashColumns.put("rcost", getRcost());
		this.hashColumns.put("offhire", getOffhire());
		this.hashColumns.put("mty", getMty());
		this.hashColumns.put("onhire", getOnhire());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("repo_pln_id", "repoPlnId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("utilization", "utilization");
		this.hashFields.put("mb", "mb");
		this.hashFields.put("lf", "lf");
		this.hashFields.put("ecc_cd", "eccCd");
		this.hashFields.put("rcost", "rcost");
		this.hashFields.put("offhire", "offhire");
		this.hashFields.put("mty", "mty");
		this.hashFields.put("onhire", "onhire");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return repoPlnId
	 */
	public String getRepoPlnId() {
		return this.repoPlnId;
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
	 * @return utilization
	 */
	public String getUtilization() {
		return this.utilization;
	}
	
	/**
	 * Column Info
	 * @return mb
	 */
	public String getMb() {
		return this.mb;
	}
	
	/**
	 * Column Info
	 * @return lf
	 */
	public String getLf() {
		return this.lf;
	}
	
	/**
	 * Column Info
	 * @return eccCd
	 */
	public String getEccCd() {
		return this.eccCd;
	}
	
	/**
	 * Column Info
	 * @return rcost
	 */
	public String getRcost() {
		return this.rcost;
	}
	
	/**
	 * Column Info
	 * @return offhire
	 */
	public String getOffhire() {
		return this.offhire;
	}
	
	/**
	 * Column Info
	 * @return mty
	 */
	public String getMty() {
		return this.mty;
	}
	
	/**
	 * Column Info
	 * @return onhire
	 */
	public String getOnhire() {
		return this.onhire;
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
	 * @param repoPlnId
	 */
	public void setRepoPlnId(String repoPlnId) {
		this.repoPlnId = repoPlnId;
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
	 * @param utilization
	 */
	public void setUtilization(String utilization) {
		this.utilization = utilization;
	}
	
	/**
	 * Column Info
	 * @param mb
	 */
	public void setMb(String mb) {
		this.mb = mb;
	}
	
	/**
	 * Column Info
	 * @param lf
	 */
	public void setLf(String lf) {
		this.lf = lf;
	}
	
	/**
	 * Column Info
	 * @param eccCd
	 */
	public void setEccCd(String eccCd) {
		this.eccCd = eccCd;
	}
	
	/**
	 * Column Info
	 * @param rcost
	 */
	public void setRcost(String rcost) {
		this.rcost = rcost;
	}
	
	/**
	 * Column Info
	 * @param offhire
	 */
	public void setOffhire(String offhire) {
		this.offhire = offhire;
	}
	
	/**
	 * Column Info
	 * @param mty
	 */
	public void setMty(String mty) {
		this.mty = mty;
	}
	
	/**
	 * Column Info
	 * @param onhire
	 */
	public void setOnhire(String onhire) {
		this.onhire = onhire;
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
		setRepoPlnId(JSPUtil.getParameter(request, "repo_pln_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setUtilization(JSPUtil.getParameter(request, "utilization", ""));
		setMb(JSPUtil.getParameter(request, "mb", ""));
		setLf(JSPUtil.getParameter(request, "lf", ""));
		setEccCd(JSPUtil.getParameter(request, "ecc_cd", ""));
		setRcost(JSPUtil.getParameter(request, "rcost", ""));
		setOffhire(JSPUtil.getParameter(request, "offhire", ""));
		setMty(JSPUtil.getParameter(request, "mty", ""));
		setOnhire(JSPUtil.getParameter(request, "onhire", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCntrPlanKPISummaryVO[]
	 */
	public SearchCntrPlanKPISummaryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCntrPlanKPISummaryVO[]
	 */
	public SearchCntrPlanKPISummaryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchCntrPlanKPISummaryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] repoPlnId = (JSPUtil.getParameter(request, prefix	+ "repo_pln_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] utilization = (JSPUtil.getParameter(request, prefix	+ "utilization", length));
			String[] mb = (JSPUtil.getParameter(request, prefix	+ "mb", length));
			String[] lf = (JSPUtil.getParameter(request, prefix	+ "lf", length));
			String[] eccCd = (JSPUtil.getParameter(request, prefix	+ "ecc_cd", length));
			String[] rcost = (JSPUtil.getParameter(request, prefix	+ "rcost", length));
			String[] offhire = (JSPUtil.getParameter(request, prefix	+ "offhire", length));
			String[] mty = (JSPUtil.getParameter(request, prefix	+ "mty", length));
			String[] onhire = (JSPUtil.getParameter(request, prefix	+ "onhire", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchCntrPlanKPISummaryVO();
				if (repoPlnId[i] != null)
					model.setRepoPlnId(repoPlnId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (utilization[i] != null)
					model.setUtilization(utilization[i]);
				if (mb[i] != null)
					model.setMb(mb[i]);
				if (lf[i] != null)
					model.setLf(lf[i]);
				if (eccCd[i] != null)
					model.setEccCd(eccCd[i]);
				if (rcost[i] != null)
					model.setRcost(rcost[i]);
				if (offhire[i] != null)
					model.setOffhire(offhire[i]);
				if (mty[i] != null)
					model.setMty(mty[i]);
				if (onhire[i] != null)
					model.setOnhire(onhire[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchCntrPlanKPISummaryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchCntrPlanKPISummaryVO[]
	 */
	public SearchCntrPlanKPISummaryVO[] getSearchCntrPlanKPISummaryVOs(){
		SearchCntrPlanKPISummaryVO[] vos = (SearchCntrPlanKPISummaryVO[])models.toArray(new SearchCntrPlanKPISummaryVO[models.size()]);
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
		this.repoPlnId = this.repoPlnId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.utilization = this.utilization .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mb = this.mb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lf = this.lf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eccCd = this.eccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcost = this.rcost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhire = this.offhire .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mty = this.mty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhire = this.onhire .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
