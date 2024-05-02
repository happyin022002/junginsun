/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SdmsDamageClaimSendMailContentVO.java
*@FileTitle : SdmsDamageClaimSendMailContentVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.21
*@LastModifier : 
*@LastVersion : 1.0
* 2011.10.21  
* 1.0 Creation
* 2011.10.21 김민아 [CHM-201113609-01] SDMS 신속 처리를 위한 Auto mailing 기능 추가 - 담당자 선택 기능 추가 및 Auto mailing 기능 추가
=========================================================*/

package com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SdmsDamageClaimSendMailContentVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SdmsDamageClaimSendMailContentVO> models = new ArrayList<SdmsDamageClaimSendMailContentVO>();
	
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* Column Info */
	private String stvDmgTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String clmHndlOfcCd = null;
	/* Column Info */
	private String stvDmgEvntDt = null;
	/* Column Info */
	private String today = null;
	/* Column Info */
	private String dtlInfo = null;
	/* Column Info */
	private String stvDmgRespbPtyKwnCd = null;
	/* Column Info */
	private String stvDmgNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SdmsDamageClaimSendMailContentVO() {}

	public SdmsDamageClaimSendMailContentVO(String ibflag, String pagerows, String slanCd, String vvd, String vpsPortCd, String stvDmgNo, String clmHndlOfcCd, String stvDmgEvntDt, String stvDmgTpCd, String stvDmgRespbPtyKwnCd, String dtlInfo, String today) {
		this.vvd = vvd;
		this.vpsPortCd = vpsPortCd;
		this.stvDmgTpCd = stvDmgTpCd;
		this.ibflag = ibflag;
		this.slanCd = slanCd;
		this.clmHndlOfcCd = clmHndlOfcCd;
		this.stvDmgEvntDt = stvDmgEvntDt;
		this.today = today;
		this.dtlInfo = dtlInfo;
		this.stvDmgRespbPtyKwnCd = stvDmgRespbPtyKwnCd;
		this.stvDmgNo = stvDmgNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("stv_dmg_tp_cd", getStvDmgTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("clm_hndl_ofc_cd", getClmHndlOfcCd());
		this.hashColumns.put("stv_dmg_evnt_dt", getStvDmgEvntDt());
		this.hashColumns.put("today", getToday());
		this.hashColumns.put("dtl_info", getDtlInfo());
		this.hashColumns.put("stv_dmg_respb_pty_kwn_cd", getStvDmgRespbPtyKwnCd());
		this.hashColumns.put("stv_dmg_no", getStvDmgNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("stv_dmg_tp_cd", "stvDmgTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("clm_hndl_ofc_cd", "clmHndlOfcCd");
		this.hashFields.put("stv_dmg_evnt_dt", "stvDmgEvntDt");
		this.hashFields.put("today", "today");
		this.hashFields.put("dtl_info", "dtlInfo");
		this.hashFields.put("stv_dmg_respb_pty_kwn_cd", "stvDmgRespbPtyKwnCd");
		this.hashFields.put("stv_dmg_no", "stvDmgNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * Column Info
	 * @return stvDmgTpCd
	 */
	public String getStvDmgTpCd() {
		return this.stvDmgTpCd;
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
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return clmHndlOfcCd
	 */
	public String getClmHndlOfcCd() {
		return this.clmHndlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return stvDmgEvntDt
	 */
	public String getStvDmgEvntDt() {
		return this.stvDmgEvntDt;
	}
	
	/**
	 * Column Info
	 * @return today
	 */
	public String getToday() {
		return this.today;
	}
	
	/**
	 * Column Info
	 * @return dtlInfo
	 */
	public String getDtlInfo() {
		return this.dtlInfo;
	}
	
	/**
	 * Column Info
	 * @return stvDmgRespbPtyKwnCd
	 */
	public String getStvDmgRespbPtyKwnCd() {
		return this.stvDmgRespbPtyKwnCd;
	}
	
	/**
	 * Column Info
	 * @return stvDmgNo
	 */
	public String getStvDmgNo() {
		return this.stvDmgNo;
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
	 * Column Info
	 * @param stvDmgTpCd
	 */
	public void setStvDmgTpCd(String stvDmgTpCd) {
		this.stvDmgTpCd = stvDmgTpCd;
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
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param clmHndlOfcCd
	 */
	public void setClmHndlOfcCd(String clmHndlOfcCd) {
		this.clmHndlOfcCd = clmHndlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param stvDmgEvntDt
	 */
	public void setStvDmgEvntDt(String stvDmgEvntDt) {
		this.stvDmgEvntDt = stvDmgEvntDt;
	}
	
	/**
	 * Column Info
	 * @param today
	 */
	public void setToday(String today) {
		this.today = today;
	}
	
	/**
	 * Column Info
	 * @param dtlInfo
	 */
	public void setDtlInfo(String dtlInfo) {
		this.dtlInfo = dtlInfo;
	}
	
	/**
	 * Column Info
	 * @param stvDmgRespbPtyKwnCd
	 */
	public void setStvDmgRespbPtyKwnCd(String stvDmgRespbPtyKwnCd) {
		this.stvDmgRespbPtyKwnCd = stvDmgRespbPtyKwnCd;
	}
	
	/**
	 * Column Info
	 * @param stvDmgNo
	 */
	public void setStvDmgNo(String stvDmgNo) {
		this.stvDmgNo = stvDmgNo;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
		setStvDmgTpCd(JSPUtil.getParameter(request, prefix + "stv_dmg_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setClmHndlOfcCd(JSPUtil.getParameter(request, prefix + "clm_hndl_ofc_cd", ""));
		setStvDmgEvntDt(JSPUtil.getParameter(request, prefix + "stv_dmg_evnt_dt", ""));
		setToday(JSPUtil.getParameter(request, prefix + "today", ""));
		setDtlInfo(JSPUtil.getParameter(request, prefix + "dtl_info", ""));
		setStvDmgRespbPtyKwnCd(JSPUtil.getParameter(request, prefix + "stv_dmg_respb_pty_kwn_cd", ""));
		setStvDmgNo(JSPUtil.getParameter(request, prefix + "stv_dmg_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SdmsDamageClaimSendMailContentVO[]
	 */
	public SdmsDamageClaimSendMailContentVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SdmsDamageClaimSendMailContentVO[]
	 */
	public SdmsDamageClaimSendMailContentVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SdmsDamageClaimSendMailContentVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] stvDmgTpCd = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] clmHndlOfcCd = (JSPUtil.getParameter(request, prefix	+ "clm_hndl_ofc_cd", length));
			String[] stvDmgEvntDt = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_evnt_dt", length));
			String[] today = (JSPUtil.getParameter(request, prefix	+ "today", length));
			String[] dtlInfo = (JSPUtil.getParameter(request, prefix	+ "dtl_info", length));
			String[] stvDmgRespbPtyKwnCd = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_respb_pty_kwn_cd", length));
			String[] stvDmgNo = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SdmsDamageClaimSendMailContentVO();
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (stvDmgTpCd[i] != null)
					model.setStvDmgTpCd(stvDmgTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (clmHndlOfcCd[i] != null)
					model.setClmHndlOfcCd(clmHndlOfcCd[i]);
				if (stvDmgEvntDt[i] != null)
					model.setStvDmgEvntDt(stvDmgEvntDt[i]);
				if (today[i] != null)
					model.setToday(today[i]);
				if (dtlInfo[i] != null)
					model.setDtlInfo(dtlInfo[i]);
				if (stvDmgRespbPtyKwnCd[i] != null)
					model.setStvDmgRespbPtyKwnCd(stvDmgRespbPtyKwnCd[i]);
				if (stvDmgNo[i] != null)
					model.setStvDmgNo(stvDmgNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSdmsDamageClaimSendMailContentVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SdmsDamageClaimSendMailContentVO[]
	 */
	public SdmsDamageClaimSendMailContentVO[] getSdmsDamageClaimSendMailContentVOs(){
		SdmsDamageClaimSendMailContentVO[] vos = (SdmsDamageClaimSendMailContentVO[])models.toArray(new SdmsDamageClaimSendMailContentVO[models.size()]);
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
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgTpCd = this.stvDmgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmHndlOfcCd = this.clmHndlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgEvntDt = this.stvDmgEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.today = this.today .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlInfo = this.dtlInfo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgRespbPtyKwnCd = this.stvDmgRespbPtyKwnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgNo = this.stvDmgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
