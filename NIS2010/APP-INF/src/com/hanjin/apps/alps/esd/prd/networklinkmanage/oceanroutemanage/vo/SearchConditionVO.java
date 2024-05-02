/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchConditionVO.java
*@FileTitle : SearchConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 김귀진
*@LastVersion : 1.0
* 2009.08.20 김귀진 
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

public class SearchConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchConditionVO> models = new ArrayList<SearchConditionVO>();
	
	/* Column Info */
	private String podContCd = null;
	/* Column Info */
	private String tsLaneCd = null;
	/* Column Info */
	private String polContCd = null;
	/* Column Info */
	private String tnkLaneCd = null;
	/* Column Info */
	private String tsPortCd = null;
	/* Column Info */
	private String polPortCd = null;
	/* Column Info */
	private String polCntyCd = null;
	/* Column Info */
	private String podCntyCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String podPortCd = null;
	/* Column Info */
	private String tsType = null;
	/* Column Info */
	private String stayTime = null;
	/* Column Info */
	private String iDelFlag = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchConditionVO() {}

	public SearchConditionVO(String ibflag, String pagerows, String polContCd, String polCntyCd, String polPortCd, String podContCd, String podCntyCd, String podPortCd, String tnkLaneCd, String tsPortCd, String tsLaneCd, String tsType, String stayTime, String iDelFlag) {
		this.podContCd = podContCd;
		this.tsLaneCd = tsLaneCd;
		this.polContCd = polContCd;
		this.tnkLaneCd = tnkLaneCd;
		this.tsPortCd = tsPortCd;
		this.polPortCd = polPortCd;
		this.polCntyCd = polCntyCd;
		this.podCntyCd = podCntyCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.podPortCd = podPortCd;
		this.tsType = tsType;
		this.stayTime = stayTime;
		this.iDelFlag = iDelFlag;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pod_cont_cd", getPodContCd());
		this.hashColumns.put("ts_lane_cd", getTsLaneCd());
		this.hashColumns.put("pol_cont_cd", getPolContCd());
		this.hashColumns.put("tnk_lane_cd", getTnkLaneCd());
		this.hashColumns.put("ts_port_cd", getTsPortCd());
		this.hashColumns.put("pol_port_cd", getPolPortCd());
		this.hashColumns.put("pol_cnty_cd", getPolCntyCd());
		this.hashColumns.put("pod_cnty_cd", getPodCntyCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pod_port_cd", getPodPortCd());
		this.hashColumns.put("ts_type", getTsType());
		this.hashColumns.put("stay_time", getStayTime());
		this.hashColumns.put("i_del_flag", getIDelFlag());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pod_cont_cd", "podContCd");
		this.hashFields.put("ts_lane_cd", "tsLaneCd");
		this.hashFields.put("pol_cont_cd", "polContCd");
		this.hashFields.put("tnk_lane_cd", "tnkLaneCd");
		this.hashFields.put("ts_port_cd", "tsPortCd");
		this.hashFields.put("pol_port_cd", "polPortCd");
		this.hashFields.put("pol_cnty_cd", "polCntyCd");
		this.hashFields.put("pod_cnty_cd", "podCntyCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pod_port_cd", "podPortCd");
		this.hashFields.put("ts_type", "tsType");
		this.hashFields.put("stay_time", "stayTime");
		this.hashFields.put("i_del_flag", "iDelFlag");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return podContCd
	 */
	public String getPodContCd() {
		return this.podContCd;
	}
	
	/**
	 * Column Info
	 * @return tsLaneCd
	 */
	public String getTsLaneCd() {
		return this.tsLaneCd;
	}
	
	/**
	 * Column Info
	 * @return polContCd
	 */
	public String getPolContCd() {
		return this.polContCd;
	}
	
	/**
	 * Column Info
	 * @return tnkLaneCd
	 */
	public String getTnkLaneCd() {
		return this.tnkLaneCd;
	}
	
	/**
	 * Column Info
	 * @return tsPortCd
	 */
	public String getTsPortCd() {
		return this.tsPortCd;
	}
	
	/**
	 * Column Info
	 * @return polPortCd
	 */
	public String getPolPortCd() {
		return this.polPortCd;
	}
	
	/**
	 * Column Info
	 * @return polCntyCd
	 */
	public String getPolCntyCd() {
		return this.polCntyCd;
	}
	
	/**
	 * Column Info
	 * @return podCntyCd
	 */
	public String getPodCntyCd() {
		return this.podCntyCd;
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
	 * @return podPortCd
	 */
	public String getPodPortCd() {
		return this.podPortCd;
	}
	
	/**
	 * Column Info
	 * @return tsType
	 */
	public String getTsType() {
		return this.tsType;
	}
	
	/**
	 * Column Info
	 * @return stayTime
	 */
	public String getStayTime() {
		return this.stayTime;
	}
	
	/**
	 * Column Info
	 * @return iDelFlag
	 */
	public String getIDelFlag() {
		return this.iDelFlag;
	}
	

	/**
	 * Column Info
	 * @param podContCd
	 */
	public void setPodContCd(String podContCd) {
		this.podContCd = podContCd;
	}
	
	/**
	 * Column Info
	 * @param tsLaneCd
	 */
	public void setTsLaneCd(String tsLaneCd) {
		this.tsLaneCd = tsLaneCd;
	}
	
	/**
	 * Column Info
	 * @param polContCd
	 */
	public void setPolContCd(String polContCd) {
		this.polContCd = polContCd;
	}
	
	/**
	 * Column Info
	 * @param tnkLaneCd
	 */
	public void setTnkLaneCd(String tnkLaneCd) {
		this.tnkLaneCd = tnkLaneCd;
	}
	
	/**
	 * Column Info
	 * @param tsPortCd
	 */
	public void setTsPortCd(String tsPortCd) {
		this.tsPortCd = tsPortCd;
	}
	
	/**
	 * Column Info
	 * @param polPortCd
	 */
	public void setPolPortCd(String polPortCd) {
		this.polPortCd = polPortCd;
	}
	
	/**
	 * Column Info
	 * @param polCntyCd
	 */
	public void setPolCntyCd(String polCntyCd) {
		this.polCntyCd = polCntyCd;
	}
	
	/**
	 * Column Info
	 * @param podCntyCd
	 */
	public void setPodCntyCd(String podCntyCd) {
		this.podCntyCd = podCntyCd;
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
	 * @param podPortCd
	 */
	public void setPodPortCd(String podPortCd) {
		this.podPortCd = podPortCd;
	}
	
	/**
	 * Column Info
	 * @param tsType
	 */
	public void setTsType(String tsType) {
		this.tsType = tsType;
	}
	
	/**
	 * Column Info
	 * @param stayTime
	 */
	public void setStayTime(String stayTime) {
		this.stayTime = stayTime;
	}
	
	/**
	 * Column Info
	 * @param iDelFlag
	 */
	public void setIDelFlag(String iDelFlag) {
		this.iDelFlag = iDelFlag;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPodContCd(JSPUtil.getParameter(request, "pod_cont_cd", ""));
		setTsLaneCd(JSPUtil.getParameter(request, "ts_lane_cd", ""));
		setPolContCd(JSPUtil.getParameter(request, "pol_cont_cd", ""));
		setTnkLaneCd(JSPUtil.getParameter(request, "tnk_lane_cd", ""));
		setTsPortCd(JSPUtil.getParameter(request, "ts_port_cd", ""));
		setPolPortCd(JSPUtil.getParameter(request, "pol_port_cd", ""));
		setPolCntyCd(JSPUtil.getParameter(request, "pol_cnty_cd", ""));
		setPodCntyCd(JSPUtil.getParameter(request, "pod_cnty_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPodPortCd(JSPUtil.getParameter(request, "pod_port_cd", ""));
		setTsType(JSPUtil.getParameter(request, "ts_type", ""));
		setStayTime(JSPUtil.getParameter(request, "stay_time", ""));
		setIDelFlag(JSPUtil.getParameter(request, "i_del_flag", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchConditionVO[]
	 */
	public SearchConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchConditionVO[]
	 */
	public SearchConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] podContCd = (JSPUtil.getParameter(request, prefix	+ "pod_cont_cd", length));
			String[] tsLaneCd = (JSPUtil.getParameter(request, prefix	+ "ts_lane_cd", length));
			String[] polContCd = (JSPUtil.getParameter(request, prefix	+ "pol_cont_cd", length));
			String[] tnkLaneCd = (JSPUtil.getParameter(request, prefix	+ "tnk_lane_cd", length));
			String[] tsPortCd = (JSPUtil.getParameter(request, prefix	+ "ts_port_cd", length));
			String[] polPortCd = (JSPUtil.getParameter(request, prefix	+ "pol_port_cd", length));
			String[] polCntyCd = (JSPUtil.getParameter(request, prefix	+ "pol_cnty_cd", length));
			String[] podCntyCd = (JSPUtil.getParameter(request, prefix	+ "pod_cnty_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] podPortCd = (JSPUtil.getParameter(request, prefix	+ "pod_port_cd", length));
			String[] tsType = (JSPUtil.getParameter(request, prefix	+ "ts_type", length));
			String[] stayTime = (JSPUtil.getParameter(request, prefix	+ "stay_time", length));
			String[] iDelFlag = (JSPUtil.getParameter(request, prefix	+ "i_del_flag", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchConditionVO();
				if (podContCd[i] != null)
					model.setPodContCd(podContCd[i]);
				if (tsLaneCd[i] != null)
					model.setTsLaneCd(tsLaneCd[i]);
				if (polContCd[i] != null)
					model.setPolContCd(polContCd[i]);
				if (tnkLaneCd[i] != null)
					model.setTnkLaneCd(tnkLaneCd[i]);
				if (tsPortCd[i] != null)
					model.setTsPortCd(tsPortCd[i]);
				if (polPortCd[i] != null)
					model.setPolPortCd(polPortCd[i]);
				if (polCntyCd[i] != null)
					model.setPolCntyCd(polCntyCd[i]);
				if (podCntyCd[i] != null)
					model.setPodCntyCd(podCntyCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (podPortCd[i] != null)
					model.setPodPortCd(podPortCd[i]);
				if (tsType[i] != null)
					model.setTsType(tsType[i]);
				if (stayTime[i] != null)
					model.setStayTime(stayTime[i]);
				if (iDelFlag[i] != null)
					model.setIDelFlag(iDelFlag[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchConditionVO[]
	 */
	public SearchConditionVO[] getSearchConditionVOs(){
		SearchConditionVO[] vos = (SearchConditionVO[])models.toArray(new SearchConditionVO[models.size()]);
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
		this.podContCd = this.podContCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsLaneCd = this.tsLaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polContCd = this.polContCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tnkLaneCd = this.tnkLaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsPortCd = this.tsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polPortCd = this.polPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCntyCd = this.polCntyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCntyCd = this.podCntyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podPortCd = this.podPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsType = this.tsType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayTime = this.stayTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iDelFlag = this.iDelFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
