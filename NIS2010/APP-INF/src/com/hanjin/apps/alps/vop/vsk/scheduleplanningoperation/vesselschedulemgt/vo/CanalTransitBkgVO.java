/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CanalTransitBkgVO.java
*@FileTitle : CanalTransitBkgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.23  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo;

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

public class CanalTransitBkgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CanalTransitBkgVO> models = new ArrayList<CanalTransitBkgVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String cnlTzBkgPrdCd = null;
	/* Column Info */
	private String cnlPortCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */ 
	private String cnlBkgTzDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String cnlTzBkgYrmon = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String cnlTzBkgProcStsCd = null;
	/* Column Info */
	private String cnlOtSvcAproFlg = null;
	/* Column Info */
	private String svcScpBndCd = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String startMonth = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String bound = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CanalTransitBkgVO() {}

	public CanalTransitBkgVO(String ibflag, String pagerows, String startMonth, String bound, String portCd, String vpsPortCd, String vslSlanCd, String vndrSeq, String cnlTzBkgYrmon, String vslCd, String skdVoyNo, String skdDirCd, String cnlPortCd, String svcScpBndCd, String cnlTzBkgPrdCd, String cnlTzBkgProcStsCd, String cnlBkgTzDt, String cnlOtSvcAproFlg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.cnlTzBkgPrdCd = cnlTzBkgPrdCd;
		this.cnlPortCd = cnlPortCd;
		this.vslCd = vslCd;
		this.cnlBkgTzDt = cnlBkgTzDt;
		this.creDt = creDt;
		this.skdVoyNo = skdVoyNo;
		this.cnlTzBkgYrmon = cnlTzBkgYrmon;
		this.vslSlanCd = vslSlanCd;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.vpsPortCd = vpsPortCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.vndrSeq = vndrSeq;
		this.cnlTzBkgProcStsCd = cnlTzBkgProcStsCd;
		this.cnlOtSvcAproFlg = cnlOtSvcAproFlg;
		this.svcScpBndCd = svcScpBndCd;
		this.portCd = portCd;
		this.startMonth = startMonth;
		this.updUsrId = updUsrId;
		this.bound = bound;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cnl_tz_bkg_prd_cd", getCnlTzBkgPrdCd());
		this.hashColumns.put("cnl_port_cd", getCnlPortCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("cnl_bkg_tz_dt", getCnlBkgTzDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("cnl_tz_bkg_yrmon", getCnlTzBkgYrmon());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("cnl_tz_bkg_proc_sts_cd", getCnlTzBkgProcStsCd());
		this.hashColumns.put("cnl_ot_svc_apro_flg", getCnlOtSvcAproFlg());
		this.hashColumns.put("svc_scp_bnd_cd", getSvcScpBndCd());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("start_month", getStartMonth());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("bound", getBound());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cnl_tz_bkg_prd_cd", "cnlTzBkgPrdCd");
		this.hashFields.put("cnl_port_cd", "cnlPortCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("cnl_bkg_tz_dt", "cnlBkgTzDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("cnl_tz_bkg_yrmon", "cnlTzBkgYrmon");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("cnl_tz_bkg_proc_sts_cd", "cnlTzBkgProcStsCd");
		this.hashFields.put("cnl_ot_svc_apro_flg", "cnlOtSvcAproFlg");
		this.hashFields.put("svc_scp_bnd_cd", "svcScpBndCd");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("start_month", "startMonth");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("bound", "bound");
		return this.hashFields;
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
	 * @return cnlTzBkgPrdCd
	 */
	public String getCnlTzBkgPrdCd() {
		return this.cnlTzBkgPrdCd;
	}
	
	/**
	 * Column Info
	 * @return cnlPortCd
	 */
	public String getCnlPortCd() {
		return this.cnlPortCd;
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
	 * @return cnlBkgTzDt
	 */
	public String getCnlBkgTzDt() {
		return this.cnlBkgTzDt;
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
	 * @return cnlTzBkgYrmon
	 */
	public String getCnlTzBkgYrmon() {
		return this.cnlTzBkgYrmon;
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
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return cnlTzBkgProcStsCd
	 */
	public String getCnlTzBkgProcStsCd() {
		return this.cnlTzBkgProcStsCd;
	}
	
	/**
	 * Column Info
	 * @return cnlOtSvcAproFlg
	 */
	public String getCnlOtSvcAproFlg() {
		return this.cnlOtSvcAproFlg;
	}
	
	/**
	 * Column Info
	 * @return svcScpBndCd
	 */
	public String getSvcScpBndCd() {
		return this.svcScpBndCd;
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
	 * @return startMonth
	 */
	public String getStartMonth() {
		return this.startMonth;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return bound
	 */
	public String getBound() {
		return this.bound;
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
	 * @param cnlTzBkgPrdCd
	 */
	public void setCnlTzBkgPrdCd(String cnlTzBkgPrdCd) {
		this.cnlTzBkgPrdCd = cnlTzBkgPrdCd;
	}
	
	/**
	 * Column Info
	 * @param cnlPortCd
	 */
	public void setCnlPortCd(String cnlPortCd) {
		this.cnlPortCd = cnlPortCd;
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
	 * @param cnlBkgTzDt
	 */
	public void setCnlBkgTzDt(String cnlBkgTzDt) {
		this.cnlBkgTzDt = cnlBkgTzDt;
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
	 * @param cnlTzBkgYrmon
	 */
	public void setCnlTzBkgYrmon(String cnlTzBkgYrmon) {
		this.cnlTzBkgYrmon = cnlTzBkgYrmon;
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
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param cnlTzBkgProcStsCd
	 */
	public void setCnlTzBkgProcStsCd(String cnlTzBkgProcStsCd) {
		this.cnlTzBkgProcStsCd = cnlTzBkgProcStsCd;
	}
	
	/**
	 * Column Info
	 * @param cnlOtSvcAproFlg
	 */
	public void setCnlOtSvcAproFlg(String cnlOtSvcAproFlg) {
		this.cnlOtSvcAproFlg = cnlOtSvcAproFlg;
	}
	
	/**
	 * Column Info
	 * @param svcScpBndCd
	 */
	public void setSvcScpBndCd(String svcScpBndCd) {
		this.svcScpBndCd = svcScpBndCd;
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
	 * @param startMonth
	 */
	public void setStartMonth(String startMonth) {
		this.startMonth = startMonth;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param bound
	 */
	public void setBound(String bound) {
		this.bound = bound;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCnlTzBkgPrdCd(JSPUtil.getParameter(request, prefix + "cnl_tz_bkg_prd_cd", ""));
		setCnlPortCd(JSPUtil.getParameter(request, prefix + "cnl_port_cd", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setCnlBkgTzDt(JSPUtil.getParameter(request, prefix + "cnl_bkg_tz_dt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setCnlTzBkgYrmon(JSPUtil.getParameter(request, prefix + "cnl_tz_bkg_yrmon", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setCnlTzBkgProcStsCd(JSPUtil.getParameter(request, prefix + "cnl_tz_bkg_proc_sts_cd", ""));
		setCnlOtSvcAproFlg(JSPUtil.getParameter(request, prefix + "cnl_ot_svc_apro_flg", ""));
		setSvcScpBndCd(JSPUtil.getParameter(request, prefix + "svc_scp_bnd_cd", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setStartMonth(JSPUtil.getParameter(request, prefix + "start_month", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setBound(JSPUtil.getParameter(request, prefix + "bound", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CanalTransitBkgVO[]
	 */
	public CanalTransitBkgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CanalTransitBkgVO[]
	 */
	public CanalTransitBkgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CanalTransitBkgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] cnlTzBkgPrdCd = (JSPUtil.getParameter(request, prefix	+ "cnl_tz_bkg_prd_cd", length));
			String[] cnlPortCd = (JSPUtil.getParameter(request, prefix	+ "cnl_port_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] cnlBkgTzDt = (JSPUtil.getParameter(request, prefix	+ "cnl_bkg_tz_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] cnlTzBkgYrmon = (JSPUtil.getParameter(request, prefix	+ "cnl_tz_bkg_yrmon", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] cnlTzBkgProcStsCd = (JSPUtil.getParameter(request, prefix	+ "cnl_tz_bkg_proc_sts_cd", length));
			String[] cnlOtSvcAproFlg = (JSPUtil.getParameter(request, prefix	+ "cnl_ot_svc_apro_flg", length));
			String[] svcScpBndCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_bnd_cd", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] startMonth = (JSPUtil.getParameter(request, prefix	+ "start_month", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] bound = (JSPUtil.getParameter(request, prefix	+ "bound", length));
			
			for (int i = 0; i < length; i++) {
				model = new CanalTransitBkgVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (cnlTzBkgPrdCd[i] != null)
					model.setCnlTzBkgPrdCd(cnlTzBkgPrdCd[i]);
				if (cnlPortCd[i] != null)
					model.setCnlPortCd(cnlPortCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (cnlBkgTzDt[i] != null)
					model.setCnlBkgTzDt(cnlBkgTzDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (cnlTzBkgYrmon[i] != null)
					model.setCnlTzBkgYrmon(cnlTzBkgYrmon[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (cnlTzBkgProcStsCd[i] != null)
					model.setCnlTzBkgProcStsCd(cnlTzBkgProcStsCd[i]);
				if (cnlOtSvcAproFlg[i] != null)
					model.setCnlOtSvcAproFlg(cnlOtSvcAproFlg[i]);
				if (svcScpBndCd[i] != null)
					model.setSvcScpBndCd(svcScpBndCd[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (startMonth[i] != null)
					model.setStartMonth(startMonth[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (bound[i] != null)
					model.setBound(bound[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCanalTransitBkgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CanalTransitBkgVO[]
	 */
	public CanalTransitBkgVO[] getCanalTransitBkgVOs(){
		CanalTransitBkgVO[] vos = (CanalTransitBkgVO[])models.toArray(new CanalTransitBkgVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnlTzBkgPrdCd = this.cnlTzBkgPrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnlPortCd = this.cnlPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnlBkgTzDt = this.cnlBkgTzDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnlTzBkgYrmon = this.cnlTzBkgYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnlTzBkgProcStsCd = this.cnlTzBkgProcStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnlOtSvcAproFlg = this.cnlOtSvcAproFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpBndCd = this.svcScpBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.startMonth = this.startMonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bound = this.bound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
