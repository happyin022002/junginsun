/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VslSkdYardCngNoticeVO.java
*@FileTitle : VslSkdYardCngNoticeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.12
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.12  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VslSkdYardCngNoticeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VslSkdYardCngNoticeVO> models = new ArrayList<VslSkdYardCngNoticeVO>();
	
	/* Column Info */
	private String eml = null;
	/* Column Info */
	private String dblCallYdList = null;
	/* Column Info */
	private String bkgList = null;
	/* Column Info */
	private String oldEtdDt = null;
	/* Column Info */
	private String oldEtaDt = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String oldClptIndSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String oldYdCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String newYdCd = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String newClptIndSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public VslSkdYardCngNoticeVO() {}

	public VslSkdYardCngNoticeVO(String ibflag, String pagerows, String vslSlanCd, String vvd, String oldYdCd, String newYdCd, String portCd, String oldClptIndSeq, String newClptIndSeq, String oldEtdDt, String oldEtaDt, String eml, String bkgList, String dblCallYdList) {
		this.eml = eml;
		this.dblCallYdList = dblCallYdList;
		this.bkgList = bkgList;
		this.oldEtdDt = oldEtdDt;
		this.oldEtaDt = oldEtaDt;
		this.vslSlanCd = vslSlanCd;
		this.oldClptIndSeq = oldClptIndSeq;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.oldYdCd = oldYdCd;
		this.ibflag = ibflag;
		this.newYdCd = newYdCd;
		this.portCd = portCd;
		this.newClptIndSeq = newClptIndSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eml", getEml());
		this.hashColumns.put("dbl_call_yd_list", getDblCallYdList());
		this.hashColumns.put("bkg_list", getBkgList());
		this.hashColumns.put("old_etd_dt", getOldEtdDt());
		this.hashColumns.put("old_eta_dt", getOldEtaDt());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("old_clpt_ind_seq", getOldClptIndSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("old_yd_cd", getOldYdCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("new_yd_cd", getNewYdCd());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("new_clpt_ind_seq", getNewClptIndSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eml", "eml");
		this.hashFields.put("dbl_call_yd_list", "dblCallYdList");
		this.hashFields.put("bkg_list", "bkgList");
		this.hashFields.put("old_etd_dt", "oldEtdDt");
		this.hashFields.put("old_eta_dt", "oldEtaDt");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("old_clpt_ind_seq", "oldClptIndSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("old_yd_cd", "oldYdCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("new_yd_cd", "newYdCd");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("new_clpt_ind_seq", "newClptIndSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return eml
	 */
	public String getEml() {
		return this.eml;
	}
	
	/**
	 * Column Info
	 * @return dblCallYdList
	 */
	public String getDblCallYdList() {
		return this.dblCallYdList;
	}
	
	/**
	 * Column Info
	 * @return bkgList
	 */
	public String getBkgList() {
		return this.bkgList;
	}
	
	/**
	 * Column Info
	 * @return oldEtdDt
	 */
	public String getOldEtdDt() {
		return this.oldEtdDt;
	}
	
	/**
	 * Column Info
	 * @return oldEtaDt
	 */
	public String getOldEtaDt() {
		return this.oldEtaDt;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return oldClptIndSeq
	 */
	public String getOldClptIndSeq() {
		return this.oldClptIndSeq;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return oldYdCd
	 */
	public String getOldYdCd() {
		return this.oldYdCd;
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
	 * @return newYdCd
	 */
	public String getNewYdCd() {
		return this.newYdCd;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return newClptIndSeq
	 */
	public String getNewClptIndSeq() {
		return this.newClptIndSeq;
	}
	

	/**
	 * Column Info
	 * @param eml
	 */
	public void setEml(String eml) {
		this.eml = eml;
	}
	
	/**
	 * Column Info
	 * @param dblCallYdList
	 */
	public void setDblCallYdList(String dblCallYdList) {
		this.dblCallYdList = dblCallYdList;
	}
	
	/**
	 * Column Info
	 * @param bkgList
	 */
	public void setBkgList(String bkgList) {
		this.bkgList = bkgList;
	}
	
	/**
	 * Column Info
	 * @param oldEtdDt
	 */
	public void setOldEtdDt(String oldEtdDt) {
		this.oldEtdDt = oldEtdDt;
	}
	
	/**
	 * Column Info
	 * @param oldEtaDt
	 */
	public void setOldEtaDt(String oldEtaDt) {
		this.oldEtaDt = oldEtaDt;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param oldClptIndSeq
	 */
	public void setOldClptIndSeq(String oldClptIndSeq) {
		this.oldClptIndSeq = oldClptIndSeq;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param oldYdCd
	 */
	public void setOldYdCd(String oldYdCd) {
		this.oldYdCd = oldYdCd;
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
	 * @param newYdCd
	 */
	public void setNewYdCd(String newYdCd) {
		this.newYdCd = newYdCd;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param newClptIndSeq
	 */
	public void setNewClptIndSeq(String newClptIndSeq) {
		this.newClptIndSeq = newClptIndSeq;
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
		setEml(JSPUtil.getParameter(request, prefix + "eml", ""));
		setDblCallYdList(JSPUtil.getParameter(request, prefix + "dbl_call_yd_list", ""));
		setBkgList(JSPUtil.getParameter(request, prefix + "bkg_list", ""));
		setOldEtdDt(JSPUtil.getParameter(request, prefix + "old_etd_dt", ""));
		setOldEtaDt(JSPUtil.getParameter(request, prefix + "old_eta_dt", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setOldClptIndSeq(JSPUtil.getParameter(request, prefix + "old_clpt_ind_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setOldYdCd(JSPUtil.getParameter(request, prefix + "old_yd_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setNewYdCd(JSPUtil.getParameter(request, prefix + "new_yd_cd", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setNewClptIndSeq(JSPUtil.getParameter(request, prefix + "new_clpt_ind_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VslSkdYardCngNoticeVO[]
	 */
	public VslSkdYardCngNoticeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VslSkdYardCngNoticeVO[]
	 */
	public VslSkdYardCngNoticeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VslSkdYardCngNoticeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] eml = (JSPUtil.getParameter(request, prefix	+ "eml", length));
			String[] dblCallYdList = (JSPUtil.getParameter(request, prefix	+ "dbl_call_yd_list", length));
			String[] bkgList = (JSPUtil.getParameter(request, prefix	+ "bkg_list", length));
			String[] oldEtdDt = (JSPUtil.getParameter(request, prefix	+ "old_etd_dt", length));
			String[] oldEtaDt = (JSPUtil.getParameter(request, prefix	+ "old_eta_dt", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] oldClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "old_clpt_ind_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] oldYdCd = (JSPUtil.getParameter(request, prefix	+ "old_yd_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] newYdCd = (JSPUtil.getParameter(request, prefix	+ "new_yd_cd", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] newClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "new_clpt_ind_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new VslSkdYardCngNoticeVO();
				if (eml[i] != null)
					model.setEml(eml[i]);
				if (dblCallYdList[i] != null)
					model.setDblCallYdList(dblCallYdList[i]);
				if (bkgList[i] != null)
					model.setBkgList(bkgList[i]);
				if (oldEtdDt[i] != null)
					model.setOldEtdDt(oldEtdDt[i]);
				if (oldEtaDt[i] != null)
					model.setOldEtaDt(oldEtaDt[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (oldClptIndSeq[i] != null)
					model.setOldClptIndSeq(oldClptIndSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (oldYdCd[i] != null)
					model.setOldYdCd(oldYdCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (newYdCd[i] != null)
					model.setNewYdCd(newYdCd[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (newClptIndSeq[i] != null)
					model.setNewClptIndSeq(newClptIndSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVslSkdYardCngNoticeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VslSkdYardCngNoticeVO[]
	 */
	public VslSkdYardCngNoticeVO[] getVslSkdYardCngNoticeVOs(){
		VslSkdYardCngNoticeVO[] vos = (VslSkdYardCngNoticeVO[])models.toArray(new VslSkdYardCngNoticeVO[models.size()]);
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
		this.eml = this.eml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dblCallYdList = this.dblCallYdList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgList = this.bkgList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldEtdDt = this.oldEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldEtaDt = this.oldEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldClptIndSeq = this.oldClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldYdCd = this.oldYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newYdCd = this.newYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newClptIndSeq = this.newClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
