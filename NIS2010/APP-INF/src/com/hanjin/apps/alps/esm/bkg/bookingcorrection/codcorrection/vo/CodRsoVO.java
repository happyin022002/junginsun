/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CodRsoVO.java
*@FileTitle : CodRsoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.30
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2009.12.30 류대영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 류대영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CodRsoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CodRsoVO> models = new ArrayList<CodRsoVO>();
	
	/* Column Info */
	private String vslSvcTpCd = null;
	/* Column Info */
	private String oldVslCd = null;
	/* Column Info */
	private String rso = null;
	/* Column Info */
	private String newVslCd = null;
	/* Column Info */
	private String oldPodYdCd = null;
	/* Column Info */
	private String rhndPortActArrDt = null;
	/* Column Info */
	private String oldSkdVoyNo = null;
	/* Column Info */
	private String newSkdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String newPolYdCd = null;
	/* Column Info */
	private String oldPolYdCd = null;
	/* Column Info */
	private String rhndPortActDepDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polActDepDt = null;
	/* Column Info */
	private String oldSkdDirCd = null;
	/* Column Info */
	private String newPodYdCd = null;
	/* Column Info */
	private String newSkdVoyNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CodRsoVO() {}

	public CodRsoVO(String ibflag, String pagerows, String newVslCd, String newSkdVoyNo, String newSkdDirCd, String newPolYdCd, String newPodYdCd, String oldVslCd, String oldSkdVoyNo, String oldSkdDirCd, String oldPolYdCd, String oldPodYdCd, String polActDepDt, String rhndPortActArrDt, String rhndPortActDepDt, String vslSvcTpCd, String rso) {
		this.vslSvcTpCd = vslSvcTpCd;
		this.oldVslCd = oldVslCd;
		this.rso = rso;
		this.newVslCd = newVslCd;
		this.oldPodYdCd = oldPodYdCd;
		this.rhndPortActArrDt = rhndPortActArrDt;
		this.oldSkdVoyNo = oldSkdVoyNo;
		this.newSkdDirCd = newSkdDirCd;
		this.pagerows = pagerows;
		this.newPolYdCd = newPolYdCd;
		this.oldPolYdCd = oldPolYdCd;
		this.rhndPortActDepDt = rhndPortActDepDt;
		this.ibflag = ibflag;
		this.polActDepDt = polActDepDt;
		this.oldSkdDirCd = oldSkdDirCd;
		this.newPodYdCd = newPodYdCd;
		this.newSkdVoyNo = newSkdVoyNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_svc_tp_cd", getVslSvcTpCd());
		this.hashColumns.put("old_vsl_cd", getOldVslCd());
		this.hashColumns.put("rso", getRso());
		this.hashColumns.put("new_vsl_cd", getNewVslCd());
		this.hashColumns.put("old_pod_yd_cd", getOldPodYdCd());
		this.hashColumns.put("rhnd_port_act_arr_dt", getRhndPortActArrDt());
		this.hashColumns.put("old_skd_voy_no", getOldSkdVoyNo());
		this.hashColumns.put("new_skd_dir_cd", getNewSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("new_pol_yd_cd", getNewPolYdCd());
		this.hashColumns.put("old_pol_yd_cd", getOldPolYdCd());
		this.hashColumns.put("rhnd_port_act_dep_dt", getRhndPortActDepDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_act_dep_dt", getPolActDepDt());
		this.hashColumns.put("old_skd_dir_cd", getOldSkdDirCd());
		this.hashColumns.put("new_pod_yd_cd", getNewPodYdCd());
		this.hashColumns.put("new_skd_voy_no", getNewSkdVoyNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_svc_tp_cd", "vslSvcTpCd");
		this.hashFields.put("old_vsl_cd", "oldVslCd");
		this.hashFields.put("rso", "rso");
		this.hashFields.put("new_vsl_cd", "newVslCd");
		this.hashFields.put("old_pod_yd_cd", "oldPodYdCd");
		this.hashFields.put("rhnd_port_act_arr_dt", "rhndPortActArrDt");
		this.hashFields.put("old_skd_voy_no", "oldSkdVoyNo");
		this.hashFields.put("new_skd_dir_cd", "newSkdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("new_pol_yd_cd", "newPolYdCd");
		this.hashFields.put("old_pol_yd_cd", "oldPolYdCd");
		this.hashFields.put("rhnd_port_act_dep_dt", "rhndPortActDepDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_act_dep_dt", "polActDepDt");
		this.hashFields.put("old_skd_dir_cd", "oldSkdDirCd");
		this.hashFields.put("new_pod_yd_cd", "newPodYdCd");
		this.hashFields.put("new_skd_voy_no", "newSkdVoyNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslSvcTpCd
	 */
	public String getVslSvcTpCd() {
		return this.vslSvcTpCd;
	}
	
	/**
	 * Column Info
	 * @return oldVslCd
	 */
	public String getOldVslCd() {
		return this.oldVslCd;
	}
	
	/**
	 * Column Info
	 * @return rso
	 */
	public String getRso() {
		return this.rso;
	}
	
	/**
	 * Column Info
	 * @return newVslCd
	 */
	public String getNewVslCd() {
		return this.newVslCd;
	}
	
	/**
	 * Column Info
	 * @return oldPodYdCd
	 */
	public String getOldPodYdCd() {
		return this.oldPodYdCd;
	}
	
	/**
	 * Column Info
	 * @return rhndPortActArrDt
	 */
	public String getRhndPortActArrDt() {
		return this.rhndPortActArrDt;
	}
	
	/**
	 * Column Info
	 * @return oldSkdVoyNo
	 */
	public String getOldSkdVoyNo() {
		return this.oldSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return newSkdDirCd
	 */
	public String getNewSkdDirCd() {
		return this.newSkdDirCd;
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
	 * @return newPolYdCd
	 */
	public String getNewPolYdCd() {
		return this.newPolYdCd;
	}
	
	/**
	 * Column Info
	 * @return oldPolYdCd
	 */
	public String getOldPolYdCd() {
		return this.oldPolYdCd;
	}
	
	/**
	 * Column Info
	 * @return rhndPortActDepDt
	 */
	public String getRhndPortActDepDt() {
		return this.rhndPortActDepDt;
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
	 * @return polActDepDt
	 */
	public String getPolActDepDt() {
		return this.polActDepDt;
	}
	
	/**
	 * Column Info
	 * @return oldSkdDirCd
	 */
	public String getOldSkdDirCd() {
		return this.oldSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return newPodYdCd
	 */
	public String getNewPodYdCd() {
		return this.newPodYdCd;
	}
	
	/**
	 * Column Info
	 * @return newSkdVoyNo
	 */
	public String getNewSkdVoyNo() {
		return this.newSkdVoyNo;
	}
	

	/**
	 * Column Info
	 * @param vslSvcTpCd
	 */
	public void setVslSvcTpCd(String vslSvcTpCd) {
		this.vslSvcTpCd = vslSvcTpCd;
	}
	
	/**
	 * Column Info
	 * @param oldVslCd
	 */
	public void setOldVslCd(String oldVslCd) {
		this.oldVslCd = oldVslCd;
	}
	
	/**
	 * Column Info
	 * @param rso
	 */
	public void setRso(String rso) {
		this.rso = rso;
	}
	
	/**
	 * Column Info
	 * @param newVslCd
	 */
	public void setNewVslCd(String newVslCd) {
		this.newVslCd = newVslCd;
	}
	
	/**
	 * Column Info
	 * @param oldPodYdCd
	 */
	public void setOldPodYdCd(String oldPodYdCd) {
		this.oldPodYdCd = oldPodYdCd;
	}
	
	/**
	 * Column Info
	 * @param rhndPortActArrDt
	 */
	public void setRhndPortActArrDt(String rhndPortActArrDt) {
		this.rhndPortActArrDt = rhndPortActArrDt;
	}
	
	/**
	 * Column Info
	 * @param oldSkdVoyNo
	 */
	public void setOldSkdVoyNo(String oldSkdVoyNo) {
		this.oldSkdVoyNo = oldSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param newSkdDirCd
	 */
	public void setNewSkdDirCd(String newSkdDirCd) {
		this.newSkdDirCd = newSkdDirCd;
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
	 * @param newPolYdCd
	 */
	public void setNewPolYdCd(String newPolYdCd) {
		this.newPolYdCd = newPolYdCd;
	}
	
	/**
	 * Column Info
	 * @param oldPolYdCd
	 */
	public void setOldPolYdCd(String oldPolYdCd) {
		this.oldPolYdCd = oldPolYdCd;
	}
	
	/**
	 * Column Info
	 * @param rhndPortActDepDt
	 */
	public void setRhndPortActDepDt(String rhndPortActDepDt) {
		this.rhndPortActDepDt = rhndPortActDepDt;
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
	 * @param polActDepDt
	 */
	public void setPolActDepDt(String polActDepDt) {
		this.polActDepDt = polActDepDt;
	}
	
	/**
	 * Column Info
	 * @param oldSkdDirCd
	 */
	public void setOldSkdDirCd(String oldSkdDirCd) {
		this.oldSkdDirCd = oldSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param newPodYdCd
	 */
	public void setNewPodYdCd(String newPodYdCd) {
		this.newPodYdCd = newPodYdCd;
	}
	
	/**
	 * Column Info
	 * @param newSkdVoyNo
	 */
	public void setNewSkdVoyNo(String newSkdVoyNo) {
		this.newSkdVoyNo = newSkdVoyNo;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setVslSvcTpCd(JSPUtil.getParameter(request, prefix + "vsl_svc_tp_cd", ""));
		setOldVslCd(JSPUtil.getParameter(request, prefix + "old_vsl_cd", ""));
		setRso(JSPUtil.getParameter(request, prefix + "rso", ""));
		setNewVslCd(JSPUtil.getParameter(request, prefix + "new_vsl_cd", ""));
		setOldPodYdCd(JSPUtil.getParameter(request, prefix + "old_pod_yd_cd", ""));
		setRhndPortActArrDt(JSPUtil.getParameter(request, prefix + "rhnd_port_act_arr_dt", ""));
		setOldSkdVoyNo(JSPUtil.getParameter(request, prefix + "old_skd_voy_no", ""));
		setNewSkdDirCd(JSPUtil.getParameter(request, prefix + "new_skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setNewPolYdCd(JSPUtil.getParameter(request, prefix + "new_pol_yd_cd", ""));
		setOldPolYdCd(JSPUtil.getParameter(request, prefix + "old_pol_yd_cd", ""));
		setRhndPortActDepDt(JSPUtil.getParameter(request, prefix + "rhnd_port_act_dep_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolActDepDt(JSPUtil.getParameter(request, prefix + "pol_act_dep_dt", ""));
		setOldSkdDirCd(JSPUtil.getParameter(request, prefix + "old_skd_dir_cd", ""));
		setNewPodYdCd(JSPUtil.getParameter(request, prefix + "new_pod_yd_cd", ""));
		setNewSkdVoyNo(JSPUtil.getParameter(request, prefix + "new_skd_voy_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CodRsoVO[]
	 */
	public CodRsoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CodRsoVO[]
	 */
	public CodRsoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CodRsoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslSvcTpCd = (JSPUtil.getParameter(request, prefix	+ "vsl_svc_tp_cd", length));
			String[] oldVslCd = (JSPUtil.getParameter(request, prefix	+ "old_vsl_cd", length));
			String[] rso = (JSPUtil.getParameter(request, prefix	+ "rso", length));
			String[] newVslCd = (JSPUtil.getParameter(request, prefix	+ "new_vsl_cd", length));
			String[] oldPodYdCd = (JSPUtil.getParameter(request, prefix	+ "old_pod_yd_cd", length));
			String[] rhndPortActArrDt = (JSPUtil.getParameter(request, prefix	+ "rhnd_port_act_arr_dt", length));
			String[] oldSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "old_skd_voy_no", length));
			String[] newSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "new_skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] newPolYdCd = (JSPUtil.getParameter(request, prefix	+ "new_pol_yd_cd", length));
			String[] oldPolYdCd = (JSPUtil.getParameter(request, prefix	+ "old_pol_yd_cd", length));
			String[] rhndPortActDepDt = (JSPUtil.getParameter(request, prefix	+ "rhnd_port_act_dep_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polActDepDt = (JSPUtil.getParameter(request, prefix	+ "pol_act_dep_dt", length));
			String[] oldSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "old_skd_dir_cd", length));
			String[] newPodYdCd = (JSPUtil.getParameter(request, prefix	+ "new_pod_yd_cd", length));
			String[] newSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "new_skd_voy_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new CodRsoVO();
				if (vslSvcTpCd[i] != null)
					model.setVslSvcTpCd(vslSvcTpCd[i]);
				if (oldVslCd[i] != null)
					model.setOldVslCd(oldVslCd[i]);
				if (rso[i] != null)
					model.setRso(rso[i]);
				if (newVslCd[i] != null)
					model.setNewVslCd(newVslCd[i]);
				if (oldPodYdCd[i] != null)
					model.setOldPodYdCd(oldPodYdCd[i]);
				if (rhndPortActArrDt[i] != null)
					model.setRhndPortActArrDt(rhndPortActArrDt[i]);
				if (oldSkdVoyNo[i] != null)
					model.setOldSkdVoyNo(oldSkdVoyNo[i]);
				if (newSkdDirCd[i] != null)
					model.setNewSkdDirCd(newSkdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (newPolYdCd[i] != null)
					model.setNewPolYdCd(newPolYdCd[i]);
				if (oldPolYdCd[i] != null)
					model.setOldPolYdCd(oldPolYdCd[i]);
				if (rhndPortActDepDt[i] != null)
					model.setRhndPortActDepDt(rhndPortActDepDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polActDepDt[i] != null)
					model.setPolActDepDt(polActDepDt[i]);
				if (oldSkdDirCd[i] != null)
					model.setOldSkdDirCd(oldSkdDirCd[i]);
				if (newPodYdCd[i] != null)
					model.setNewPodYdCd(newPodYdCd[i]);
				if (newSkdVoyNo[i] != null)
					model.setNewSkdVoyNo(newSkdVoyNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCodRsoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CodRsoVO[]
	 */
	public CodRsoVO[] getCodRsoVOs(){
		CodRsoVO[] vos = (CodRsoVO[])models.toArray(new CodRsoVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.vslSvcTpCd = this.vslSvcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldVslCd = this.oldVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rso = this.rso .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newVslCd = this.newVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldPodYdCd = this.oldPodYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhndPortActArrDt = this.rhndPortActArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldSkdVoyNo = this.oldSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newSkdDirCd = this.newSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPolYdCd = this.newPolYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldPolYdCd = this.oldPolYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhndPortActDepDt = this.rhndPortActDepDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polActDepDt = this.polActDepDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldSkdDirCd = this.oldSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPodYdCd = this.newPodYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newSkdVoyNo = this.newSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
