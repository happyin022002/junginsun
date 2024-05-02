/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InBoundReportInVO.java
*@FileTitle : InBoundReportInVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.09.29 김경섭 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo;

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
 * @author 김경섭
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InBoundReportInVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InBoundReportInVO> models = new ArrayList<InBoundReportInVO>();
	
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String laneCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String staffId = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String etaFromDt = null;
	/* Column Info */
	private String duraCd = null;
	/* Column Info */
	private String cntrCd = null;
	/* Column Info */
	private String etaToDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InBoundReportInVO() {}

	public InBoundReportInVO(String ibflag, String pagerows, String etaFromDt, String etaToDt, String cntrCd, String ofcCd, String staffId, String laneCd, String vvdCd, String podCd, String delCd, String duraCd) {
		this.podCd = podCd;
		this.laneCd = laneCd;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.staffId = staffId;
		this.vvdCd = vvdCd;
		this.delCd = delCd;
		this.etaFromDt = etaFromDt;
		this.duraCd = duraCd;
		this.cntrCd = cntrCd;
		this.etaToDt = etaToDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("lane_cd", getLaneCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("staff_id", getStaffId());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("eta_from_dt", getEtaFromDt());
		this.hashColumns.put("dura_cd", getDuraCd());
		this.hashColumns.put("cntr_cd", getCntrCd());
		this.hashColumns.put("eta_to_dt", getEtaToDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("lane_cd", "laneCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("staff_id", "staffId");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("eta_from_dt", "etaFromDt");
		this.hashFields.put("dura_cd", "duraCd");
		this.hashFields.put("cntr_cd", "cntrCd");
		this.hashFields.put("eta_to_dt", "etaToDt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return laneCd
	 */
	public String getLaneCd() {
		return this.laneCd;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return staffId
	 */
	public String getStaffId() {
		return this.staffId;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
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
	 * @return etaFromDt
	 */
	public String getEtaFromDt() {
		return this.etaFromDt;
	}
	
	/**
	 * Column Info
	 * @return duraCd
	 */
	public String getDuraCd() {
		return this.duraCd;
	}
	
	/**
	 * Column Info
	 * @return cntrCd
	 */
	public String getCntrCd() {
		return this.cntrCd;
	}
	
	/**
	 * Column Info
	 * @return etaToDt
	 */
	public String getEtaToDt() {
		return this.etaToDt;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param laneCd
	 */
	public void setLaneCd(String laneCd) {
		this.laneCd = laneCd;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param staffId
	 */
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
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
	 * @param etaFromDt
	 */
	public void setEtaFromDt(String etaFromDt) {
		this.etaFromDt = etaFromDt;
	}
	
	/**
	 * Column Info
	 * @param duraCd
	 */
	public void setDuraCd(String duraCd) {
		this.duraCd = duraCd;
	}
	
	/**
	 * Column Info
	 * @param cntrCd
	 */
	public void setCntrCd(String cntrCd) {
		this.cntrCd = cntrCd;
	}
	
	/**
	 * Column Info
	 * @param etaToDt
	 */
	public void setEtaToDt(String etaToDt) {
		this.etaToDt = etaToDt;
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
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setLaneCd(JSPUtil.getParameter(request, "lane_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setStaffId(JSPUtil.getParameter(request, "staff_id", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setEtaFromDt(JSPUtil.getParameter(request, "eta_from_dt", ""));
		setDuraCd(JSPUtil.getParameter(request, "dura_cd", ""));
		setCntrCd(JSPUtil.getParameter(request, "cntr_cd", ""));
		setEtaToDt(JSPUtil.getParameter(request, "eta_to_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InBoundReportInVO[]
	 */
	public InBoundReportInVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InBoundReportInVO[]
	 */
	public InBoundReportInVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InBoundReportInVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] laneCd = (JSPUtil.getParameter(request, prefix	+ "lane_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] staffId = (JSPUtil.getParameter(request, prefix	+ "staff_id", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] etaFromDt = (JSPUtil.getParameter(request, prefix	+ "eta_from_dt", length));
			String[] duraCd = (JSPUtil.getParameter(request, prefix	+ "dura_cd", length));
			String[] cntrCd = (JSPUtil.getParameter(request, prefix	+ "cntr_cd", length));
			String[] etaToDt = (JSPUtil.getParameter(request, prefix	+ "eta_to_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new InBoundReportInVO();
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (laneCd[i] != null)
					model.setLaneCd(laneCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (staffId[i] != null)
					model.setStaffId(staffId[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (etaFromDt[i] != null)
					model.setEtaFromDt(etaFromDt[i]);
				if (duraCd[i] != null)
					model.setDuraCd(duraCd[i]);
				if (cntrCd[i] != null)
					model.setCntrCd(cntrCd[i]);
				if (etaToDt[i] != null)
					model.setEtaToDt(etaToDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInBoundReportInVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InBoundReportInVO[]
	 */
	public InBoundReportInVO[] getInBoundReportInVOs(){
		InBoundReportInVO[] vos = (InBoundReportInVO[])models.toArray(new InBoundReportInVO[models.size()]);
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
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneCd = this.laneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.staffId = this.staffId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaFromDt = this.etaFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duraCd = this.duraCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCd = this.cntrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaToDt = this.etaToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
