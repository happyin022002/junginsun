/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RouteDtlInfoVO.java
*@FileTitle : RouteDtlInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.06
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2010.01.06 김병규 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo;

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
 * @author 김병규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RouteDtlInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RouteDtlInfoVO> models = new ArrayList<RouteDtlInfoVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String destTrnsModCd = null;
	/* Column Info */
	private String porNodCd = null;
	/* Column Info */
	private String orgTrnsModCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String polNodCd = null;
	/* Column Info */
	private String delEtaTime = null;
	/* Column Info */
	private String delEta = null;
	/* Column Info */
	private String vpsEtaDtTime = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String podNodCd = null;
	/* Column Info */
	private String delEtaDay = null;
	/* Column Info */
	private String vpsEtaDtDate = null;
	/* Column Info */
	private String delNodCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RouteDtlInfoVO() {}

	public RouteDtlInfoVO(String ibflag, String pagerows, String porCd, String porNodCd, String polCd, String polNodCd, String orgTrnsModCd, String podCd, String podNodCd, String delCd, String delNodCd, String destTrnsModCd, String vpsEtaDtDate, String vpsEtaDtTime, String delEta, String delEtaDay, String delEtaTime) {
		this.porCd = porCd;
		this.destTrnsModCd = destTrnsModCd;
		this.porNodCd = porNodCd;
		this.orgTrnsModCd = orgTrnsModCd;
		this.delCd = delCd;
		this.polNodCd = polNodCd;
		this.delEtaTime = delEtaTime;
		this.delEta = delEta;
		this.vpsEtaDtTime = vpsEtaDtTime;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.podNodCd = podNodCd;
		this.delEtaDay = delEtaDay;
		this.vpsEtaDtDate = vpsEtaDtDate;
		this.delNodCd = delNodCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("dest_trns_mod_cd", getDestTrnsModCd());
		this.hashColumns.put("por_nod_cd", getPorNodCd());
		this.hashColumns.put("org_trns_mod_cd", getOrgTrnsModCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("pol_nod_cd", getPolNodCd());
		this.hashColumns.put("del_eta_time", getDelEtaTime());
		this.hashColumns.put("del_eta", getDelEta());
		this.hashColumns.put("vps_eta_dt_time", getVpsEtaDtTime());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("pod_nod_cd", getPodNodCd());
		this.hashColumns.put("del_eta_day", getDelEtaDay());
		this.hashColumns.put("vps_eta_dt_date", getVpsEtaDtDate());
		this.hashColumns.put("del_nod_cd", getDelNodCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("dest_trns_mod_cd", "destTrnsModCd");
		this.hashFields.put("por_nod_cd", "porNodCd");
		this.hashFields.put("org_trns_mod_cd", "orgTrnsModCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("pol_nod_cd", "polNodCd");
		this.hashFields.put("del_eta_time", "delEtaTime");
		this.hashFields.put("del_eta", "delEta");
		this.hashFields.put("vps_eta_dt_time", "vpsEtaDtTime");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("pod_nod_cd", "podNodCd");
		this.hashFields.put("del_eta_day", "delEtaDay");
		this.hashFields.put("vps_eta_dt_date", "vpsEtaDtDate");
		this.hashFields.put("del_nod_cd", "delNodCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return destTrnsModCd
	 */
	public String getDestTrnsModCd() {
		return this.destTrnsModCd;
	}
	
	/**
	 * Column Info
	 * @return porNodCd
	 */
	public String getPorNodCd() {
		return this.porNodCd;
	}
	
	/**
	 * Column Info
	 * @return orgTrnsModCd
	 */
	public String getOrgTrnsModCd() {
		return this.orgTrnsModCd;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return polNodCd
	 */
	public String getPolNodCd() {
		return this.polNodCd;
	}
	
	/**
	 * Column Info
	 * @return delEtaTime
	 */
	public String getDelEtaTime() {
		return this.delEtaTime;
	}
	
	/**
	 * Column Info
	 * @return delEta
	 */
	public String getDelEta() {
		return this.delEta;
	}
	
	/**
	 * Column Info
	 * @return vpsEtaDtTime
	 */
	public String getVpsEtaDtTime() {
		return this.vpsEtaDtTime;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return podNodCd
	 */
	public String getPodNodCd() {
		return this.podNodCd;
	}
	
	/**
	 * Column Info
	 * @return delEtaDay
	 */
	public String getDelEtaDay() {
		return this.delEtaDay;
	}
	
	/**
	 * Column Info
	 * @return vpsEtaDtDate
	 */
	public String getVpsEtaDtDate() {
		return this.vpsEtaDtDate;
	}
	
	/**
	 * Column Info
	 * @return delNodCd
	 */
	public String getDelNodCd() {
		return this.delNodCd;
	}
	

	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param destTrnsModCd
	 */
	public void setDestTrnsModCd(String destTrnsModCd) {
		this.destTrnsModCd = destTrnsModCd;
	}
	
	/**
	 * Column Info
	 * @param porNodCd
	 */
	public void setPorNodCd(String porNodCd) {
		this.porNodCd = porNodCd;
	}
	
	/**
	 * Column Info
	 * @param orgTrnsModCd
	 */
	public void setOrgTrnsModCd(String orgTrnsModCd) {
		this.orgTrnsModCd = orgTrnsModCd;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param polNodCd
	 */
	public void setPolNodCd(String polNodCd) {
		this.polNodCd = polNodCd;
	}
	
	/**
	 * Column Info
	 * @param delEtaTime
	 */
	public void setDelEtaTime(String delEtaTime) {
		this.delEtaTime = delEtaTime;
	}
	
	/**
	 * Column Info
	 * @param delEta
	 */
	public void setDelEta(String delEta) {
		this.delEta = delEta;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaDtTime
	 */
	public void setVpsEtaDtTime(String vpsEtaDtTime) {
		this.vpsEtaDtTime = vpsEtaDtTime;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param podNodCd
	 */
	public void setPodNodCd(String podNodCd) {
		this.podNodCd = podNodCd;
	}
	
	/**
	 * Column Info
	 * @param delEtaDay
	 */
	public void setDelEtaDay(String delEtaDay) {
		this.delEtaDay = delEtaDay;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaDtDate
	 */
	public void setVpsEtaDtDate(String vpsEtaDtDate) {
		this.vpsEtaDtDate = vpsEtaDtDate;
	}
	
	/**
	 * Column Info
	 * @param delNodCd
	 */
	public void setDelNodCd(String delNodCd) {
		this.delNodCd = delNodCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setDestTrnsModCd(JSPUtil.getParameter(request, "dest_trns_mod_cd", ""));
		setPorNodCd(JSPUtil.getParameter(request, "por_nod_cd", ""));
		setOrgTrnsModCd(JSPUtil.getParameter(request, "org_trns_mod_cd", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setPolNodCd(JSPUtil.getParameter(request, "pol_nod_cd", ""));
		setDelEtaTime(JSPUtil.getParameter(request, "del_eta_time", ""));
		setDelEta(JSPUtil.getParameter(request, "del_eta", ""));
		setVpsEtaDtTime(JSPUtil.getParameter(request, "vps_eta_dt_time", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setPodNodCd(JSPUtil.getParameter(request, "pod_nod_cd", ""));
		setDelEtaDay(JSPUtil.getParameter(request, "del_eta_day", ""));
		setVpsEtaDtDate(JSPUtil.getParameter(request, "vps_eta_dt_date", ""));
		setDelNodCd(JSPUtil.getParameter(request, "del_nod_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RouteDtlInfoVO[]
	 */
	public RouteDtlInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RouteDtlInfoVO[]
	 */
	public RouteDtlInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RouteDtlInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] destTrnsModCd = (JSPUtil.getParameter(request, prefix	+ "dest_trns_mod_cd", length));
			String[] porNodCd = (JSPUtil.getParameter(request, prefix	+ "por_nod_cd", length));
			String[] orgTrnsModCd = (JSPUtil.getParameter(request, prefix	+ "org_trns_mod_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] polNodCd = (JSPUtil.getParameter(request, prefix	+ "pol_nod_cd", length));
			String[] delEtaTime = (JSPUtil.getParameter(request, prefix	+ "del_eta_time", length));
			String[] delEta = (JSPUtil.getParameter(request, prefix	+ "del_eta", length));
			String[] vpsEtaDtTime = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt_time", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] podNodCd = (JSPUtil.getParameter(request, prefix	+ "pod_nod_cd", length));
			String[] delEtaDay = (JSPUtil.getParameter(request, prefix	+ "del_eta_day", length));
			String[] vpsEtaDtDate = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt_date", length));
			String[] delNodCd = (JSPUtil.getParameter(request, prefix	+ "del_nod_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new RouteDtlInfoVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (destTrnsModCd[i] != null)
					model.setDestTrnsModCd(destTrnsModCd[i]);
				if (porNodCd[i] != null)
					model.setPorNodCd(porNodCd[i]);
				if (orgTrnsModCd[i] != null)
					model.setOrgTrnsModCd(orgTrnsModCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (polNodCd[i] != null)
					model.setPolNodCd(polNodCd[i]);
				if (delEtaTime[i] != null)
					model.setDelEtaTime(delEtaTime[i]);
				if (delEta[i] != null)
					model.setDelEta(delEta[i]);
				if (vpsEtaDtTime[i] != null)
					model.setVpsEtaDtTime(vpsEtaDtTime[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (podNodCd[i] != null)
					model.setPodNodCd(podNodCd[i]);
				if (delEtaDay[i] != null)
					model.setDelEtaDay(delEtaDay[i]);
				if (vpsEtaDtDate[i] != null)
					model.setVpsEtaDtDate(vpsEtaDtDate[i]);
				if (delNodCd[i] != null)
					model.setDelNodCd(delNodCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRouteDtlInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RouteDtlInfoVO[]
	 */
	public RouteDtlInfoVO[] getRouteDtlInfoVOs(){
		RouteDtlInfoVO[] vos = (RouteDtlInfoVO[])models.toArray(new RouteDtlInfoVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destTrnsModCd = this.destTrnsModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porNodCd = this.porNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgTrnsModCd = this.orgTrnsModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polNodCd = this.polNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delEtaTime = this.delEtaTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delEta = this.delEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDtTime = this.vpsEtaDtTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podNodCd = this.podNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delEtaDay = this.delEtaDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDtDate = this.vpsEtaDtDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delNodCd = this.delNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
