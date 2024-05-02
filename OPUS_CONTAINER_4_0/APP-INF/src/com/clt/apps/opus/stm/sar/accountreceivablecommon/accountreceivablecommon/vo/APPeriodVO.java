/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : APPeriodVO.java
*@FileTitle : APPeriodVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.12
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.12  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class APPeriodVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<APPeriodVO> models = new ArrayList<APPeriodVO>();
	
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String sysDivCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String eaiEvntDt = null;
	/* Column Info */
	private String clzStsCd = null;
	/* Column Info */
	private String sysDesc = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String arApDivCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String effYrmon = null;
	/* Column Info */
	private String lstUpdDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public APPeriodVO() {}

	public APPeriodVO(String ibflag, String pagerows, String sysDivCd, String effYrmon, String ofcCd, String arApDivCd, String clzStsCd, String sysDesc, String rhqCd, String eaiEvntDt, String lstUpdDt, String creUsrId, String creDt, String updUsrId) {
		this.rhqCd = rhqCd;
		this.sysDivCd = sysDivCd;
		this.creDt = creDt;
		this.eaiEvntDt = eaiEvntDt;
		this.clzStsCd = clzStsCd;
		this.sysDesc = sysDesc;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.arApDivCd = arApDivCd;
		this.updUsrId = updUsrId;
		this.effYrmon = effYrmon;
		this.lstUpdDt = lstUpdDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("sys_div_cd", getSysDivCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("eai_evnt_dt", getEaiEvntDt());
		this.hashColumns.put("clz_sts_cd", getClzStsCd());
		this.hashColumns.put("sys_desc", getSysDesc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ar_ap_div_cd", getArApDivCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("eff_yrmon", getEffYrmon());
		this.hashColumns.put("lst_upd_dt", getLstUpdDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("sys_div_cd", "sysDivCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("eai_evnt_dt", "eaiEvntDt");
		this.hashFields.put("clz_sts_cd", "clzStsCd");
		this.hashFields.put("sys_desc", "sysDesc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ar_ap_div_cd", "arApDivCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("eff_yrmon", "effYrmon");
		this.hashFields.put("lst_upd_dt", "lstUpdDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return sysDivCd
	 */
	public String getSysDivCd() {
		return this.sysDivCd;
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
	 * @return eaiEvntDt
	 */
	public String getEaiEvntDt() {
		return this.eaiEvntDt;
	}
	
	/**
	 * Column Info
	 * @return clzStsCd
	 */
	public String getClzStsCd() {
		return this.clzStsCd;
	}
	
	/**
	 * Column Info
	 * @return sysDesc
	 */
	public String getSysDesc() {
		return this.sysDesc;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return arApDivCd
	 */
	public String getArApDivCd() {
		return this.arApDivCd;
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
	 * @return effYrmon
	 */
	public String getEffYrmon() {
		return this.effYrmon;
	}
	
	/**
	 * Column Info
	 * @return lstUpdDt
	 */
	public String getLstUpdDt() {
		return this.lstUpdDt;
	}
	

	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param sysDivCd
	 */
	public void setSysDivCd(String sysDivCd) {
		this.sysDivCd = sysDivCd;
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
	 * @param eaiEvntDt
	 */
	public void setEaiEvntDt(String eaiEvntDt) {
		this.eaiEvntDt = eaiEvntDt;
	}
	
	/**
	 * Column Info
	 * @param clzStsCd
	 */
	public void setClzStsCd(String clzStsCd) {
		this.clzStsCd = clzStsCd;
	}
	
	/**
	 * Column Info
	 * @param sysDesc
	 */
	public void setSysDesc(String sysDesc) {
		this.sysDesc = sysDesc;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param arApDivCd
	 */
	public void setArApDivCd(String arApDivCd) {
		this.arApDivCd = arApDivCd;
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
	 * @param effYrmon
	 */
	public void setEffYrmon(String effYrmon) {
		this.effYrmon = effYrmon;
	}
	
	/**
	 * Column Info
	 * @param lstUpdDt
	 */
	public void setLstUpdDt(String lstUpdDt) {
		this.lstUpdDt = lstUpdDt;
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
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setSysDivCd(JSPUtil.getParameter(request, prefix + "sys_div_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setEaiEvntDt(JSPUtil.getParameter(request, prefix + "eai_evnt_dt", ""));
		setClzStsCd(JSPUtil.getParameter(request, prefix + "clz_sts_cd", ""));
		setSysDesc(JSPUtil.getParameter(request, prefix + "sys_desc", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setArApDivCd(JSPUtil.getParameter(request, prefix + "ar_ap_div_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setEffYrmon(JSPUtil.getParameter(request, prefix + "eff_yrmon", ""));
		setLstUpdDt(JSPUtil.getParameter(request, prefix + "lst_upd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return APPeriodVO[]
	 */
	public APPeriodVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return APPeriodVO[]
	 */
	public APPeriodVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		APPeriodVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] sysDivCd = (JSPUtil.getParameter(request, prefix	+ "sys_div_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] eaiEvntDt = (JSPUtil.getParameter(request, prefix	+ "eai_evnt_dt", length));
			String[] clzStsCd = (JSPUtil.getParameter(request, prefix	+ "clz_sts_cd", length));
			String[] sysDesc = (JSPUtil.getParameter(request, prefix	+ "sys_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] arApDivCd = (JSPUtil.getParameter(request, prefix	+ "ar_ap_div_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] effYrmon = (JSPUtil.getParameter(request, prefix	+ "eff_yrmon", length));
			String[] lstUpdDt = (JSPUtil.getParameter(request, prefix	+ "lst_upd_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new APPeriodVO();
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (sysDivCd[i] != null)
					model.setSysDivCd(sysDivCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (eaiEvntDt[i] != null)
					model.setEaiEvntDt(eaiEvntDt[i]);
				if (clzStsCd[i] != null)
					model.setClzStsCd(clzStsCd[i]);
				if (sysDesc[i] != null)
					model.setSysDesc(sysDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (arApDivCd[i] != null)
					model.setArApDivCd(arApDivCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (effYrmon[i] != null)
					model.setEffYrmon(effYrmon[i]);
				if (lstUpdDt[i] != null)
					model.setLstUpdDt(lstUpdDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAPPeriodVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return APPeriodVO[]
	 */
	public APPeriodVO[] getAPPeriodVOs(){
		APPeriodVO[] vos = (APPeriodVO[])models.toArray(new APPeriodVO[models.size()]);
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
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysDivCd = this.sysDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiEvntDt = this.eaiEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clzStsCd = this.clzStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysDesc = this.sysDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arApDivCd = this.arApDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effYrmon = this.effYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstUpdDt = this.lstUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
