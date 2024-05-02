/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VslSkdRepeatErpIfVO.java
*@FileTitle : VslSkdRepeatErpIfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.20
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.12.20 김상수 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo;

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
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VslSkdRepeatErpIfVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VslSkdRepeatErpIfVO> models = new ArrayList<VslSkdRepeatErpIfVO>();
	
	/* Column Info */
	private String ifDt = null;
	/* Column Info */
	private String deltDt = null;	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String dateFm = null;
	/* Column Info */
	private String skdDirCombo = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String vpsEtbDt = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String dateTo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;

	private String vvdDeletedYn = null;
	/* Column Info */
	
	private String deletedVvdYn = null;
	/* Column Info */	
	
	/* Column Info */
	private String firstPortEtbFm = null;	
	/* Column Info */
	private String firstPortEtbTo = null;		
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VslSkdRepeatErpIfVO() {}

	public VslSkdRepeatErpIfVO(String ibflag, String pagerows, String skdDirCombo, String dateTo, String dateFm, String skdDirCd, String vslSlanCd, String vslCd, String skdVoyNo, String vvd, String creDt, String vpsPortCd, String vpsEtaDt, String vpsEtbDt, String vpsEtdDt, String updDt, String ifDt, String deltDt, String vvdDeletedYn, String deletedVvdYn, String firstPortEtbFm, String firstPortEtbTo) {
		this.ifDt 			= ifDt;
		this.deltDt 		= deltDt;
		this.updDt 			= updDt;
		this.dateFm 		= dateFm;
		this.skdDirCombo 	= skdDirCombo;
		this.vslCd 			= vslCd;
		this.vpsEtbDt 		= vpsEtbDt;
		this.vpsEtdDt 		= vpsEtdDt;
		this.dateTo 		= dateTo;
		this.creDt 			= creDt;
		this.skdVoyNo 		= skdVoyNo;
		this.vslSlanCd 		= vslSlanCd;
		this.vpsEtaDt 		= vpsEtaDt;
		this.skdDirCd 		= skdDirCd;
		this.pagerows 		= pagerows;
		this.vvd 			= vvd;
		this.vpsPortCd 		= vpsPortCd;
		this.ibflag 		= ibflag;
		
		this.vvdDeletedYn 	= vvdDeletedYn;
		this.deletedVvdYn 	= deletedVvdYn;
		this.firstPortEtbFm = firstPortEtbFm;
		this.firstPortEtbTo = firstPortEtbTo;
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("if_dt", getIfDt());
		this.hashColumns.put("delt_dt", getDeltDt());
		
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("date_fm", getDateFm());
		this.hashColumns.put("skd_dir_combo", getSkdDirCombo());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("vps_etb_dt", getVpsEtbDt());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("date_to", getDateTo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("ibflag", getIbflag());
		
		this.hashColumns.put("vvd_deleted_yn", getVvdDeletedYn());
		this.hashColumns.put("deleted_vvd_yn", getDeletedVvdYn());
		this.hashColumns.put("first_port_etb_fm", getFirstPortEtbFm());
		this.hashColumns.put("first_port_etb_to", getFirstPortEtbTo());
		
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("if_dt", "ifDt");
		this.hashFields.put("delt_dt", "deltDt");
		
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("date_fm", "dateFm");
		this.hashFields.put("skd_dir_combo", "skdDirCombo");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vps_etb_dt", "vpsEtbDt");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("date_to", "dateTo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("ibflag", "ibflag");
		
		this.hashFields.put("vvd_deleted_yn", "vvdDeletedYn");
		this.hashFields.put("deleted_vvd_yn", "deletedVvdYn");
		this.hashFields.put("first_port_etb_fm", "firstPortEtbFm");
		this.hashFields.put("first_port_etb_to", "firstPortEtbTo");
		
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ifDt
	 */
	public String getIfDt() {
		return this.ifDt;
	}
	
	/**
	 * Column Info
	 * @return deltDt
	 */
	public String getDeltDt() {
		return this.deltDt;
	}	
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return dateFm
	 */
	public String getDateFm() {
		return this.dateFm;
	}
	
	/**
	 * Column Info
	 * @return skdDirCombo
	 */
	public String getSkdDirCombo() {
		return this.skdDirCombo;
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
	 * @return vpsEtbDt
	 */
	public String getVpsEtbDt() {
		return this.vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @return vpsEtdDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @return dateTo
	 */
	public String getDateTo() {
		return this.dateTo;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return vpsEtaDt
	 */
	public String getVpsEtaDt() {
		return this.vpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return vvdDeletedYn
	 */
	public String getVvdDeletedYn() {
		return this.vvdDeletedYn;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return deletedVvdYn
	 */
	public String getDeletedVvdYn() {
		return this.deletedVvdYn;
	}	
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return firstPortEtbFm
	 */
	public String getFirstPortEtbFm() {
		return this.firstPortEtbFm;
	}	
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return deletedVvdYn
	 */
	public String getFirstPortEtbTo() {
		return this.firstPortEtbTo;
	}		
	

	/**
	 * Column Info
	 * @param ifDt
	 */
	public void setIfDt(String ifDt) {
		this.ifDt = ifDt;
	}
	
	/**
	 * Column Info
	 * @param deltDt
	 */
	public void setDeltDt(String deltDt) {
		this.deltDt = deltDt;
	}	
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param dateFm
	 */
	public void setDateFm(String dateFm) {
		this.dateFm = dateFm;
	}
	
	/**
	 * Column Info
	 * @param skdDirCombo
	 */
	public void setSkdDirCombo(String skdDirCombo) {
		this.skdDirCombo = skdDirCombo;
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
	 * @param vpsEtbDt
	 */
	public void setVpsEtbDt(String vpsEtbDt) {
		this.vpsEtbDt = vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @param vpsEtdDt
	 */
	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @param dateTo
	 */
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaDt
	 */
	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param vvdDeletedYn
	 */
	public void setVvdDeletedYn(String vvdDeletedYn) {
		this.vvdDeletedYn = vvdDeletedYn;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param deletedVvdYn
	 */
	public void setDeletedVvdYn(String deletedVvdYn) {
		this.deletedVvdYn = deletedVvdYn;
	}	

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param firstPortEtbFm 
	 */
	public void setFirstPortEtbFm(String firstPortEtbFm) {
		this.firstPortEtbFm = firstPortEtbFm;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param firstPortEtbTo 
	 */
	public void setFirstPortEtbTo(String firstPortEtbTo) {
		this.firstPortEtbTo = firstPortEtbTo;
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
		setIfDt(JSPUtil.getParameter(request, prefix + "if_dt", ""));
		setDeltDt(JSPUtil.getParameter(request, prefix + "delt_dt", ""));
		
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setDateFm(JSPUtil.getParameter(request, prefix + "date_fm", ""));
		setSkdDirCombo(JSPUtil.getParameter(request, prefix + "skd_dir_combo", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setVpsEtbDt(JSPUtil.getParameter(request, prefix + "vps_etb_dt", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setDateTo(JSPUtil.getParameter(request, prefix + "date_to", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, prefix + "vps_eta_dt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		
		setVvdDeletedYn(JSPUtil.getParameter(request, prefix + "vvd_deleted_yn", ""));
		setDeletedVvdYn(JSPUtil.getParameter(request, prefix + "deleted_vvd_yn", ""));
		setFirstPortEtbFm(JSPUtil.getParameter(request, prefix + "first_port_etb_fm", ""));
		setFirstPortEtbTo(JSPUtil.getParameter(request, prefix + "first_port_etb_to", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VslSkdRepeatErpIfVO[]
	 */
	public VslSkdRepeatErpIfVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VslSkdRepeatErpIfVO[]
	 */
	public VslSkdRepeatErpIfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VslSkdRepeatErpIfVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ifDt = (JSPUtil.getParameter(request, prefix	+ "if_dt", length));
			String[] deltDt = (JSPUtil.getParameter(request, prefix	+ "delt_dt", length));
			
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] dateFm = (JSPUtil.getParameter(request, prefix	+ "date_fm", length));
			String[] skdDirCombo = (JSPUtil.getParameter(request, prefix	+ "skd_dir_combo", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] vpsEtbDt = (JSPUtil.getParameter(request, prefix	+ "vps_etb_dt", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] dateTo = (JSPUtil.getParameter(request, prefix	+ "date_to", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			
			String[] vvdDeletedYn = (JSPUtil.getParameter(request, prefix	+ "vvd_deleted_yn", length));
			String[] deletedVvdYn = (JSPUtil.getParameter(request, prefix	+ "deleted_vvd_yn", length));
			String[] firstPortEtbFm = (JSPUtil.getParameter(request, prefix	+ "first_port_etb_fm", length));
			String[] firstPortEtbTo = (JSPUtil.getParameter(request, prefix	+ "first_port_etb_to", length));
			
			
			for (int i = 0; i < length; i++) {
				model = new VslSkdRepeatErpIfVO();
				if (ifDt[i] != null)
					model.setIfDt(ifDt[i]);
				if (deltDt[i] != null)
					model.setDeltDt(deltDt[i]);
				
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (dateFm[i] != null)
					model.setDateFm(dateFm[i]);
				if (skdDirCombo[i] != null)
					model.setSkdDirCombo(skdDirCombo[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (vpsEtbDt[i] != null)
					model.setVpsEtbDt(vpsEtbDt[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (dateTo[i] != null)
					model.setDateTo(dateTo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);

				if (vvdDeletedYn[i] != null)
					model.setVvdDeletedYn(vvdDeletedYn[i]);
				if (deletedVvdYn[i] != null)
					model.setDeletedVvdYn(deletedVvdYn[i]);
				if (firstPortEtbFm[i] != null)
					model.setFirstPortEtbFm(firstPortEtbFm[i]);
				if (firstPortEtbTo[i] != null)
					model.setFirstPortEtbTo(firstPortEtbTo[i]);				
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVslSkdRepeatErpIfVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VslSkdRepeatErpIfVO[]
	 */
	public VslSkdRepeatErpIfVO[] getVslSkdRepeatErpIfVOs(){
		VslSkdRepeatErpIfVO[] vos = (VslSkdRepeatErpIfVO[])models.toArray(new VslSkdRepeatErpIfVO[models.size()]);
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
		this.ifDt = this.ifDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltDt = this.deltDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateFm = this.dateFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCombo = this.skdDirCombo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtbDt = this.vpsEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateTo = this.dateTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.vvdDeletedYn = this.vvdDeletedYn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deletedVvdYn = this.deletedVvdYn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.firstPortEtbFm = this.firstPortEtbFm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.firstPortEtbTo = this.firstPortEtbTo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		
	}
}
