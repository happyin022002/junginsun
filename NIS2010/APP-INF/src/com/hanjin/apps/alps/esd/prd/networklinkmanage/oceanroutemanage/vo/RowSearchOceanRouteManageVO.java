/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RowSearchOceanRouteManageVO.java
*@FileTitle : RowSearchOceanRouteManageVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.31
*@LastModifier : 김귀진
*@LastVersion : 1.0
* 2009.08.31 김귀진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo;

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
 * @author 김귀진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RowSearchOceanRouteManageVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RowSearchOceanRouteManageVO> models = new ArrayList<RowSearchOceanRouteManageVO>();
	
	/* Column Info */
	private String n1stPodCd = null;
	/* Column Info */
	private String orgLocCd = null;
	/* Column Info */
	private String destLocCd = null;
	/* Column Info */
	private String n1stPolCd = null;
	/* Column Info */
	private String n2ndLaneCd = null;
	/* Column Info */
	private String n2ndPodCd = null;
	/* Column Info */
	private String n4thPolCd = null;
	/* Column Info */
	private String n1stLaneCd = null;
	/* Column Info */
	private String n4thPodCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String n3rdPodCd = null;
	/* Column Info */
	private String updIndCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String n2ndPolCd = null;
	/* Column Info */
	private String n3rdPolCd = null;
	/* Column Info */
	private String n4thLaneCd = null;
	/* Column Info */
	private String n3rdLaneCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RowSearchOceanRouteManageVO() {}

	public RowSearchOceanRouteManageVO(String ibflag, String pagerows, String updIndCd, String orgLocCd, String destLocCd, String n1stPolCd, String n1stPodCd, String n1stLaneCd, String n2ndPolCd, String n2ndPodCd, String n2ndLaneCd, String n3rdPolCd, String n3rdPodCd, String n3rdLaneCd, String n4thPolCd, String n4thPodCd, String n4thLaneCd) {
		this.n1stPodCd = n1stPodCd;
		this.orgLocCd = orgLocCd;
		this.destLocCd = destLocCd;
		this.n1stPolCd = n1stPolCd;
		this.n2ndLaneCd = n2ndLaneCd;
		this.n2ndPodCd = n2ndPodCd;
		this.n4thPolCd = n4thPolCd;
		this.n1stLaneCd = n1stLaneCd;
		this.n4thPodCd = n4thPodCd;
		this.pagerows = pagerows;
		this.n3rdPodCd = n3rdPodCd;
		this.updIndCd = updIndCd;
		this.ibflag = ibflag;
		this.n2ndPolCd = n2ndPolCd;
		this.n3rdPolCd = n3rdPolCd;
		this.n4thLaneCd = n4thLaneCd;
		this.n3rdLaneCd = n3rdLaneCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("n1st_pod_cd", getN1stPodCd());
		this.hashColumns.put("org_loc_cd", getOrgLocCd());
		this.hashColumns.put("dest_loc_cd", getDestLocCd());
		this.hashColumns.put("n1st_pol_cd", getN1stPolCd());
		this.hashColumns.put("n2nd_lane_cd", getN2ndLaneCd());
		this.hashColumns.put("n2nd_pod_cd", getN2ndPodCd());
		this.hashColumns.put("n4th_pol_cd", getN4thPolCd());
		this.hashColumns.put("n1st_lane_cd", getN1stLaneCd());
		this.hashColumns.put("n4th_pod_cd", getN4thPodCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("n3rd_pod_cd", getN3rdPodCd());
		this.hashColumns.put("upd_ind_cd", getUpdIndCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("n2nd_pol_cd", getN2ndPolCd());
		this.hashColumns.put("n3rd_pol_cd", getN3rdPolCd());
		this.hashColumns.put("n4th_lane_cd", getN4thLaneCd());
		this.hashColumns.put("n3rd_lane_cd", getN3rdLaneCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("n1st_pod_cd", "n1stPodCd");
		this.hashFields.put("org_loc_cd", "orgLocCd");
		this.hashFields.put("dest_loc_cd", "destLocCd");
		this.hashFields.put("n1st_pol_cd", "n1stPolCd");
		this.hashFields.put("n2nd_lane_cd", "n2ndLaneCd");
		this.hashFields.put("n2nd_pod_cd", "n2ndPodCd");
		this.hashFields.put("n4th_pol_cd", "n4thPolCd");
		this.hashFields.put("n1st_lane_cd", "n1stLaneCd");
		this.hashFields.put("n4th_pod_cd", "n4thPodCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("n3rd_pod_cd", "n3rdPodCd");
		this.hashFields.put("upd_ind_cd", "updIndCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("n2nd_pol_cd", "n2ndPolCd");
		this.hashFields.put("n3rd_pol_cd", "n3rdPolCd");
		this.hashFields.put("n4th_lane_cd", "n4thLaneCd");
		this.hashFields.put("n3rd_lane_cd", "n3rdLaneCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return n1stPodCd
	 */
	public String getN1stPodCd() {
		return this.n1stPodCd;
	}
	
	/**
	 * Column Info
	 * @return orgLocCd
	 */
	public String getOrgLocCd() {
		return this.orgLocCd;
	}
	
	/**
	 * Column Info
	 * @return destLocCd
	 */
	public String getDestLocCd() {
		return this.destLocCd;
	}
	
	/**
	 * Column Info
	 * @return n1stPolCd
	 */
	public String getN1stPolCd() {
		return this.n1stPolCd;
	}
	
	/**
	 * Column Info
	 * @return n2ndLaneCd
	 */
	public String getN2ndLaneCd() {
		return this.n2ndLaneCd;
	}
	
	/**
	 * Column Info
	 * @return n2ndPodCd
	 */
	public String getN2ndPodCd() {
		return this.n2ndPodCd;
	}
	
	/**
	 * Column Info
	 * @return n4thPolCd
	 */
	public String getN4thPolCd() {
		return this.n4thPolCd;
	}
	
	/**
	 * Column Info
	 * @return n1stLaneCd
	 */
	public String getN1stLaneCd() {
		return this.n1stLaneCd;
	}
	
	/**
	 * Column Info
	 * @return n4thPodCd
	 */
	public String getN4thPodCd() {
		return this.n4thPodCd;
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
	 * @return n3rdPodCd
	 */
	public String getN3rdPodCd() {
		return this.n3rdPodCd;
	}
	
	/**
	 * Column Info
	 * @return updIndCd
	 */
	public String getUpdIndCd() {
		return this.updIndCd;
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
	 * @return n2ndPolCd
	 */
	public String getN2ndPolCd() {
		return this.n2ndPolCd;
	}
	
	/**
	 * Column Info
	 * @return n3rdPolCd
	 */
	public String getN3rdPolCd() {
		return this.n3rdPolCd;
	}
	
	/**
	 * Column Info
	 * @return n4thLaneCd
	 */
	public String getN4thLaneCd() {
		return this.n4thLaneCd;
	}
	
	/**
	 * Column Info
	 * @return n3rdLaneCd
	 */
	public String getN3rdLaneCd() {
		return this.n3rdLaneCd;
	}
	

	/**
	 * Column Info
	 * @param n1stPodCd
	 */
	public void setN1stPodCd(String n1stPodCd) {
		this.n1stPodCd = n1stPodCd;
	}
	
	/**
	 * Column Info
	 * @param orgLocCd
	 */
	public void setOrgLocCd(String orgLocCd) {
		this.orgLocCd = orgLocCd;
	}
	
	/**
	 * Column Info
	 * @param destLocCd
	 */
	public void setDestLocCd(String destLocCd) {
		this.destLocCd = destLocCd;
	}
	
	/**
	 * Column Info
	 * @param n1stPolCd
	 */
	public void setN1stPolCd(String n1stPolCd) {
		this.n1stPolCd = n1stPolCd;
	}
	
	/**
	 * Column Info
	 * @param n2ndLaneCd
	 */
	public void setN2ndLaneCd(String n2ndLaneCd) {
		this.n2ndLaneCd = n2ndLaneCd;
	}
	
	/**
	 * Column Info
	 * @param n2ndPodCd
	 */
	public void setN2ndPodCd(String n2ndPodCd) {
		this.n2ndPodCd = n2ndPodCd;
	}
	
	/**
	 * Column Info
	 * @param n4thPolCd
	 */
	public void setN4thPolCd(String n4thPolCd) {
		this.n4thPolCd = n4thPolCd;
	}
	
	/**
	 * Column Info
	 * @param n1stLaneCd
	 */
	public void setN1stLaneCd(String n1stLaneCd) {
		this.n1stLaneCd = n1stLaneCd;
	}
	
	/**
	 * Column Info
	 * @param n4thPodCd
	 */
	public void setN4thPodCd(String n4thPodCd) {
		this.n4thPodCd = n4thPodCd;
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
	 * @param n3rdPodCd
	 */
	public void setN3rdPodCd(String n3rdPodCd) {
		this.n3rdPodCd = n3rdPodCd;
	}
	
	/**
	 * Column Info
	 * @param updIndCd
	 */
	public void setUpdIndCd(String updIndCd) {
		this.updIndCd = updIndCd;
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
	 * @param n2ndPolCd
	 */
	public void setN2ndPolCd(String n2ndPolCd) {
		this.n2ndPolCd = n2ndPolCd;
	}
	
	/**
	 * Column Info
	 * @param n3rdPolCd
	 */
	public void setN3rdPolCd(String n3rdPolCd) {
		this.n3rdPolCd = n3rdPolCd;
	}
	
	/**
	 * Column Info
	 * @param n4thLaneCd
	 */
	public void setN4thLaneCd(String n4thLaneCd) {
		this.n4thLaneCd = n4thLaneCd;
	}
	
	/**
	 * Column Info
	 * @param n3rdLaneCd
	 */
	public void setN3rdLaneCd(String n3rdLaneCd) {
		this.n3rdLaneCd = n3rdLaneCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setN1stPodCd(JSPUtil.getParameter(request, "n1st_pod_cd", ""));
		setOrgLocCd(JSPUtil.getParameter(request, "org_loc_cd", ""));
		setDestLocCd(JSPUtil.getParameter(request, "dest_loc_cd", ""));
		setN1stPolCd(JSPUtil.getParameter(request, "n1st_pol_cd", ""));
		setN2ndLaneCd(JSPUtil.getParameter(request, "n2nd_lane_cd", ""));
		setN2ndPodCd(JSPUtil.getParameter(request, "n2nd_pod_cd", ""));
		setN4thPolCd(JSPUtil.getParameter(request, "n4th_pol_cd", ""));
		setN1stLaneCd(JSPUtil.getParameter(request, "n1st_lane_cd", ""));
		setN4thPodCd(JSPUtil.getParameter(request, "n4th_pod_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setN3rdPodCd(JSPUtil.getParameter(request, "n3rd_pod_cd", ""));
		setUpdIndCd(JSPUtil.getParameter(request, "upd_ind_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setN2ndPolCd(JSPUtil.getParameter(request, "n2nd_pol_cd", ""));
		setN3rdPolCd(JSPUtil.getParameter(request, "n3rd_pol_cd", ""));
		setN4thLaneCd(JSPUtil.getParameter(request, "n4th_lane_cd", ""));
		setN3rdLaneCd(JSPUtil.getParameter(request, "n3rd_lane_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RowSearchOceanRouteManageVO[]
	 */
	public RowSearchOceanRouteManageVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RowSearchOceanRouteManageVO[]
	 */
	public RowSearchOceanRouteManageVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RowSearchOceanRouteManageVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] n1stPodCd = (JSPUtil.getParameter(request, prefix	+ "n1st_pod_cd", length));
			String[] orgLocCd = (JSPUtil.getParameter(request, prefix	+ "org_loc_cd", length));
			String[] destLocCd = (JSPUtil.getParameter(request, prefix	+ "dest_loc_cd", length));
			String[] n1stPolCd = (JSPUtil.getParameter(request, prefix	+ "n1st_pol_cd", length));
			String[] n2ndLaneCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_lane_cd", length));
			String[] n2ndPodCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_pod_cd", length));
			String[] n4thPolCd = (JSPUtil.getParameter(request, prefix	+ "n4th_pol_cd", length));
			String[] n1stLaneCd = (JSPUtil.getParameter(request, prefix	+ "n1st_lane_cd", length));
			String[] n4thPodCd = (JSPUtil.getParameter(request, prefix	+ "n4th_pod_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] n3rdPodCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_pod_cd", length));
			String[] updIndCd = (JSPUtil.getParameter(request, prefix	+ "upd_ind_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] n2ndPolCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_pol_cd", length));
			String[] n3rdPolCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_pol_cd", length));
			String[] n4thLaneCd = (JSPUtil.getParameter(request, prefix	+ "n4th_lane_cd", length));
			String[] n3rdLaneCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_lane_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new RowSearchOceanRouteManageVO();
				if (n1stPodCd[i] != null)
					model.setN1stPodCd(n1stPodCd[i]);
				if (orgLocCd[i] != null)
					model.setOrgLocCd(orgLocCd[i]);
				if (destLocCd[i] != null)
					model.setDestLocCd(destLocCd[i]);
				if (n1stPolCd[i] != null)
					model.setN1stPolCd(n1stPolCd[i]);
				if (n2ndLaneCd[i] != null)
					model.setN2ndLaneCd(n2ndLaneCd[i]);
				if (n2ndPodCd[i] != null)
					model.setN2ndPodCd(n2ndPodCd[i]);
				if (n4thPolCd[i] != null)
					model.setN4thPolCd(n4thPolCd[i]);
				if (n1stLaneCd[i] != null)
					model.setN1stLaneCd(n1stLaneCd[i]);
				if (n4thPodCd[i] != null)
					model.setN4thPodCd(n4thPodCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (n3rdPodCd[i] != null)
					model.setN3rdPodCd(n3rdPodCd[i]);
				if (updIndCd[i] != null)
					model.setUpdIndCd(updIndCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (n2ndPolCd[i] != null)
					model.setN2ndPolCd(n2ndPolCd[i]);
				if (n3rdPolCd[i] != null)
					model.setN3rdPolCd(n3rdPolCd[i]);
				if (n4thLaneCd[i] != null)
					model.setN4thLaneCd(n4thLaneCd[i]);
				if (n3rdLaneCd[i] != null)
					model.setN3rdLaneCd(n3rdLaneCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRowSearchOceanRouteManageVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RowSearchOceanRouteManageVO[]
	 */
	public RowSearchOceanRouteManageVO[] getRowSearchOceanRouteManageVOs(){
		RowSearchOceanRouteManageVO[] vos = (RowSearchOceanRouteManageVO[])models.toArray(new RowSearchOceanRouteManageVO[models.size()]);
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
		this.n1stPodCd = this.n1stPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgLocCd = this.orgLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destLocCd = this.destLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPolCd = this.n1stPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndLaneCd = this.n2ndLaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndPodCd = this.n2ndPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thPolCd = this.n4thPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stLaneCd = this.n1stLaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thPodCd = this.n4thPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdPodCd = this.n3rdPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updIndCd = this.updIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndPolCd = this.n2ndPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdPolCd = this.n3rdPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thLaneCd = this.n4thLaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdLaneCd = this.n3rdLaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
