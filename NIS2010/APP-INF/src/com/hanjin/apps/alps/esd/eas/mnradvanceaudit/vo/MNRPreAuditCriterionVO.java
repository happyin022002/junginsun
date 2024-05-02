/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MNRPreAuditCriterionVO.java
*@FileTitle : MNRPreAuditCriterionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.05  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo;

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

public class MNRPreAuditCriterionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MNRPreAuditCriterionVO> models = new ArrayList<MNRPreAuditCriterionVO>();
	
	/* Column Info */
	private String mnrVrfyTpCd = null;
	/* Column Info */
	private String sRhqOfcCd = null;
	/* Column Info */
	private String module = null;
	/* Column Info */
	private String objPreAud = null;
	/* Column Info */
	private String expnVrfyTpCd = null;
	/* Column Info */
	private String uptOfcCd = null;
	/* Column Info */
	private String sOfcCd = null;
	/* Column Info */
	private String iOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rhqOfcCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mnrVrfyTpCdNm = null;
	/* Column Info */
	private String ratio = null;
	/* Column Info */
	private String sType = null;
	/* Column Info */
	private String autRmk = null;
	/* Column Info */
	private String eas0362 = null;
	/* Column Info */
	private String eas0363 = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String maxRatio = null;
	/* Column Info */
	private String uptDt = null;
	/* Column Info */
	private String sSetDataOnly = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public MNRPreAuditCriterionVO() {}

	public MNRPreAuditCriterionVO(String ibflag, String pagerows, String module, String rhqOfcCd, String ofcCd, String expnVrfyTpCd, String mnrVrfyTpCd, String mnrVrfyTpCdNm, String objPreAud, String uptOfcCd, String uptDt, String autRmk, String sRhqOfcCd, String sOfcCd, String sType, String iOfcCd, String creUsrId, String updUsrId, String maxRatio, String ratio, String eas0363, String eas0362, String sSetDataOnly) {
		this.mnrVrfyTpCd = mnrVrfyTpCd;
		this.sRhqOfcCd = sRhqOfcCd;
		this.module = module;
		this.objPreAud = objPreAud;
		this.expnVrfyTpCd = expnVrfyTpCd;
		this.uptOfcCd = uptOfcCd;
		this.sOfcCd = sOfcCd;
		this.iOfcCd = iOfcCd;
		this.pagerows = pagerows;
		this.rhqOfcCd = rhqOfcCd;
		this.ofcCd = ofcCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.mnrVrfyTpCdNm = mnrVrfyTpCdNm;
		this.ratio = ratio;
		this.sType = sType;
		this.autRmk = autRmk;
		this.eas0362 = eas0362;
		this.eas0363 = eas0363;
		this.updUsrId = updUsrId;
		this.maxRatio = maxRatio;
		this.uptDt = uptDt;
		this.sSetDataOnly = sSetDataOnly;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mnr_vrfy_tp_cd", getMnrVrfyTpCd());
		this.hashColumns.put("s_rhq_ofc_cd", getSRhqOfcCd());
		this.hashColumns.put("module", getModule());
		this.hashColumns.put("obj_pre_aud", getObjPreAud());
		this.hashColumns.put("expn_vrfy_tp_cd", getExpnVrfyTpCd());
		this.hashColumns.put("upt_ofc_cd", getUptOfcCd());
		this.hashColumns.put("s_ofc_cd", getSOfcCd());
		this.hashColumns.put("i_ofc_cd", getIOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rhq_ofc_cd", getRhqOfcCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mnr_vrfy_tp_cd_nm", getMnrVrfyTpCdNm());
		this.hashColumns.put("ratio", getRatio());
		this.hashColumns.put("s_type", getSType());
		this.hashColumns.put("aut_rmk", getAutRmk());
		this.hashColumns.put("eas_0362", getEas0362());
		this.hashColumns.put("eas_0363", getEas0363());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("max_ratio", getMaxRatio());
		this.hashColumns.put("upt_dt", getUptDt());
		this.hashColumns.put("s_set_data_only", getsSetDataOnly());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mnr_vrfy_tp_cd", "mnrVrfyTpCd");
		this.hashFields.put("s_rhq_ofc_cd", "sRhqOfcCd");
		this.hashFields.put("module", "module");
		this.hashFields.put("obj_pre_aud", "objPreAud");
		this.hashFields.put("expn_vrfy_tp_cd", "expnVrfyTpCd");
		this.hashFields.put("upt_ofc_cd", "uptOfcCd");
		this.hashFields.put("s_ofc_cd", "sOfcCd");
		this.hashFields.put("i_ofc_cd", "iOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rhq_ofc_cd", "rhqOfcCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mnr_vrfy_tp_cd_nm", "mnrVrfyTpCdNm");
		this.hashFields.put("ratio", "ratio");
		this.hashFields.put("s_type", "sType");
		this.hashFields.put("aut_rmk", "autRmk");
		this.hashFields.put("eas_0362", "eas0362");
		this.hashFields.put("eas_0363", "eas0363");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("max_ratio", "maxRatio");
		this.hashFields.put("upt_dt", "uptDt");
		this.hashFields.put("s_set_data_only", "sSetDataOnly");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mnrVrfyTpCd
	 */
	public String getMnrVrfyTpCd() {
		return this.mnrVrfyTpCd;
	}
	
	/**
	 * Column Info
	 * @return sRhqOfcCd
	 */
	public String getSRhqOfcCd() {
		return this.sRhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @return module
	 */
	public String getModule() {
		return this.module;
	}
	
	/**
	 * Column Info
	 * @return objPreAud
	 */
	public String getObjPreAud() {
		return this.objPreAud;
	}
	
	/**
	 * Column Info
	 * @return expnVrfyTpCd
	 */
	public String getExpnVrfyTpCd() {
		return this.expnVrfyTpCd;
	}
	
	/**
	 * Column Info
	 * @return uptOfcCd
	 */
	public String getUptOfcCd() {
		return this.uptOfcCd;
	}
	
	/**
	 * Column Info
	 * @return sOfcCd
	 */
	public String getSOfcCd() {
		return this.sOfcCd;
	}
	
	/**
	 * Column Info
	 * @return iOfcCd
	 */
	public String getIOfcCd() {
		return this.iOfcCd;
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
	 * @return rhqOfcCd
	 */
	public String getRhqOfcCd() {
		return this.rhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return mnrVrfyTpCdNm
	 */
	public String getMnrVrfyTpCdNm() {
		return this.mnrVrfyTpCdNm;
	}
	
	/**
	 * Column Info
	 * @return ratio
	 */
	public String getRatio() {
		return this.ratio;
	}
	
	/**
	 * Column Info
	 * @return sType
	 */
	public String getSType() {
		return this.sType;
	}
	
	/**
	 * Column Info
	 * @return autRmk
	 */
	public String getAutRmk() {
		return this.autRmk;
	}
	
	/**
	 * Column Info
	 * @return eas0362
	 */
	public String getEas0362() {
		return this.eas0362;
	}
	
	/**
	 * Column Info
	 * @return eas0363
	 */
	public String getEas0363() {
		return this.eas0363;
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
	 * @return maxRatio
	 */
	public String getMaxRatio() {
		return this.maxRatio;
	}
	
	/**
	 * Column Info
	 * @return uptDt
	 */
	public String getUptDt() {
		return this.uptDt;
	}
	
	/**
	 * Column Info
	 * @return uptDt
	 */
	public String getsSetDataOnly() {
		return this.sSetDataOnly;
	}
	
	
	/**
	 * Column Info
	 * @param mnrVrfyTpCd
	 */
	public void setMnrVrfyTpCd(String mnrVrfyTpCd) {
		this.mnrVrfyTpCd = mnrVrfyTpCd;
	}
	
	/**
	 * Column Info
	 * @param sRhqOfcCd
	 */
	public void setSRhqOfcCd(String sRhqOfcCd) {
		this.sRhqOfcCd = sRhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @param module
	 */
	public void setModule(String module) {
		this.module = module;
	}
	
	/**
	 * Column Info
	 * @param objPreAud
	 */
	public void setObjPreAud(String objPreAud) {
		this.objPreAud = objPreAud;
	}
	
	/**
	 * Column Info
	 * @param expnVrfyTpCd
	 */
	public void setExpnVrfyTpCd(String expnVrfyTpCd) {
		this.expnVrfyTpCd = expnVrfyTpCd;
	}
	
	/**
	 * Column Info
	 * @param uptOfcCd
	 */
	public void setUptOfcCd(String uptOfcCd) {
		this.uptOfcCd = uptOfcCd;
	}
	
	/**
	 * Column Info
	 * @param sOfcCd
	 */
	public void setSOfcCd(String sOfcCd) {
		this.sOfcCd = sOfcCd;
	}
	
	/**
	 * Column Info
	 * @param iOfcCd
	 */
	public void setIOfcCd(String iOfcCd) {
		this.iOfcCd = iOfcCd;
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
	 * @param rhqOfcCd
	 */
	public void setRhqOfcCd(String rhqOfcCd) {
		this.rhqOfcCd = rhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param mnrVrfyTpCdNm
	 */
	public void setMnrVrfyTpCdNm(String mnrVrfyTpCdNm) {
		this.mnrVrfyTpCdNm = mnrVrfyTpCdNm;
	}
	
	/**
	 * Column Info
	 * @param ratio
	 */
	public void setRatio(String ratio) {
		this.ratio = ratio;
	}
	
	/**
	 * Column Info
	 * @param sType
	 */
	public void setSType(String sType) {
		this.sType = sType;
	}
	
	/**
	 * Column Info
	 * @param autRmk
	 */
	public void setAutRmk(String autRmk) {
		this.autRmk = autRmk;
	}
	
	/**
	 * Column Info
	 * @param eas0362
	 */
	public void setEas0362(String eas0362) {
		this.eas0362 = eas0362;
	}
	
	/**
	 * Column Info
	 * @param eas0363
	 */
	public void setEas0363(String eas0363) {
		this.eas0363 = eas0363;
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
	 * @param maxRatio
	 */
	public void setMaxRatio(String maxRatio) {
		this.maxRatio = maxRatio;
	}
	
	/**
	 * Column Info
	 * @param uptDt
	 */
	public void setUptDt(String uptDt) {
		this.uptDt = uptDt;
	}
	
	/**
	 * Column Info
	 * @return sSetDataOnly
	 */
	public void setsSetDataOnly(String sSetDataOnly) {
		this.sSetDataOnly = sSetDataOnly;
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
		setMnrVrfyTpCd(JSPUtil.getParameter(request, prefix + "mnr_vrfy_tp_cd", ""));
		setSRhqOfcCd(JSPUtil.getParameter(request, prefix + "s_rhq_ofc_cd", ""));
		setModule(JSPUtil.getParameter(request, prefix + "module", ""));
		setObjPreAud(JSPUtil.getParameter(request, prefix + "obj_pre_aud", ""));
		setExpnVrfyTpCd(JSPUtil.getParameter(request, prefix + "expn_vrfy_tp_cd", ""));
		setUptOfcCd(JSPUtil.getParameter(request, prefix + "upt_ofc_cd", ""));
		setSOfcCd(JSPUtil.getParameter(request, prefix + "s_ofc_cd", ""));
		setIOfcCd(JSPUtil.getParameter(request, prefix + "i_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRhqOfcCd(JSPUtil.getParameter(request, prefix + "rhq_ofc_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMnrVrfyTpCdNm(JSPUtil.getParameter(request, prefix + "mnr_vrfy_tp_cd_nm", ""));
		setRatio(JSPUtil.getParameter(request, prefix + "ratio", ""));
		setSType(JSPUtil.getParameter(request, prefix + "s_type", ""));
		setAutRmk(JSPUtil.getParameter(request, prefix + "aut_rmk", ""));
		setEas0362(JSPUtil.getParameter(request, prefix + "eas_0362", ""));
		setEas0363(JSPUtil.getParameter(request, prefix + "eas_0363", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setMaxRatio(JSPUtil.getParameter(request, prefix + "max_ratio", ""));
		setUptDt(JSPUtil.getParameter(request, prefix + "upt_dt", ""));
		setsSetDataOnly(JSPUtil.getParameter(request, prefix + "s_set_data_only", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MNRPreAuditCriterionVO[]
	 */
	public MNRPreAuditCriterionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MNRPreAuditCriterionVO[]
	 */
	public MNRPreAuditCriterionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MNRPreAuditCriterionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mnrVrfyTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_vrfy_tp_cd", length));
			String[] sRhqOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_rhq_ofc_cd", length));
			String[] module = (JSPUtil.getParameter(request, prefix	+ "module", length));
			String[] objPreAud = (JSPUtil.getParameter(request, prefix	+ "obj_pre_aud", length));
			String[] expnVrfyTpCd = (JSPUtil.getParameter(request, prefix	+ "expn_vrfy_tp_cd", length));
			String[] uptOfcCd = (JSPUtil.getParameter(request, prefix	+ "upt_ofc_cd", length));
			String[] sOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_ofc_cd", length));
			String[] iOfcCd = (JSPUtil.getParameter(request, prefix	+ "i_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rhqOfcCd = (JSPUtil.getParameter(request, prefix	+ "rhq_ofc_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mnrVrfyTpCdNm = (JSPUtil.getParameter(request, prefix	+ "mnr_vrfy_tp_cd_nm", length));
			String[] ratio = (JSPUtil.getParameter(request, prefix	+ "ratio", length));
			String[] sType = (JSPUtil.getParameter(request, prefix	+ "s_type", length));
			String[] autRmk = (JSPUtil.getParameter(request, prefix	+ "aut_rmk", length));
			String[] eas0362 = (JSPUtil.getParameter(request, prefix	+ "eas_0362", length));
			String[] eas0363 = (JSPUtil.getParameter(request, prefix	+ "eas_0363", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] maxRatio = (JSPUtil.getParameter(request, prefix	+ "max_ratio", length));
			String[] uptDt = (JSPUtil.getParameter(request, prefix	+ "upt_dt", length));
			String[] sSetDataOnly = (JSPUtil.getParameter(request, prefix	+ "s_set_data_only", length));
			
			for (int i = 0; i < length; i++) {
				model = new MNRPreAuditCriterionVO();
				if (mnrVrfyTpCd[i] != null)
					model.setMnrVrfyTpCd(mnrVrfyTpCd[i]);
				if (sRhqOfcCd[i] != null)
					model.setSRhqOfcCd(sRhqOfcCd[i]);
				if (module[i] != null)
					model.setModule(module[i]);
				if (objPreAud[i] != null)
					model.setObjPreAud(objPreAud[i]);
				if (expnVrfyTpCd[i] != null)
					model.setExpnVrfyTpCd(expnVrfyTpCd[i]);
				if (uptOfcCd[i] != null)
					model.setUptOfcCd(uptOfcCd[i]);
				if (sOfcCd[i] != null)
					model.setSOfcCd(sOfcCd[i]);
				if (iOfcCd[i] != null)
					model.setIOfcCd(iOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rhqOfcCd[i] != null)
					model.setRhqOfcCd(rhqOfcCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mnrVrfyTpCdNm[i] != null)
					model.setMnrVrfyTpCdNm(mnrVrfyTpCdNm[i]);
				if (ratio[i] != null)
					model.setRatio(ratio[i]);
				if (sType[i] != null)
					model.setSType(sType[i]);
				if (autRmk[i] != null)
					model.setAutRmk(autRmk[i]);
				if (eas0362[i] != null)
					model.setEas0362(eas0362[i]);
				if (eas0363[i] != null)
					model.setEas0363(eas0363[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (maxRatio[i] != null)
					model.setMaxRatio(maxRatio[i]);
				if (uptDt[i] != null)
					model.setUptDt(uptDt[i]);
				if (sSetDataOnly[i] != null)
					model.setsSetDataOnly(sSetDataOnly[i]);
				models.add(model);
				
				
			}

		} catch (Exception e) {
			return null;
		}
		return getMNRPreAuditCriterionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MNRPreAuditCriterionVO[]
	 */
	public MNRPreAuditCriterionVO[] getMNRPreAuditCriterionVOs(){
		MNRPreAuditCriterionVO[] vos = (MNRPreAuditCriterionVO[])models.toArray(new MNRPreAuditCriterionVO[models.size()]);
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
		this.mnrVrfyTpCd = this.mnrVrfyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRhqOfcCd = this.sRhqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.module = this.module .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.objPreAud = this.objPreAud .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expnVrfyTpCd = this.expnVrfyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uptOfcCd = this.uptOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOfcCd = this.sOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iOfcCd = this.iOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqOfcCd = this.rhqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrVrfyTpCdNm = this.mnrVrfyTpCdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratio = this.ratio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sType = this.sType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autRmk = this.autRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eas0362 = this.eas0362 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eas0363 = this.eas0363 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxRatio = this.maxRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uptDt = this.uptDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSetDataOnly = this.sSetDataOnly .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
