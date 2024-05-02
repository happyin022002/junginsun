/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PriScgAplyDtRuleVO.java
*@FileTitle : PriScgAplyDtRuleVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.07
*@LastModifier : 
*@LastVersion : 1.0
* 2011.07.07  
* 1.0 Creation
=========================================================
* History
2011.07.07 김민아 [CHM-201112030-01] Application Date Rule Creation 시스템 개발 요청 (Pricing)
=========================================================*/

package com.hanjin.syscommon.common.table;

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

public class PriScgAplyDtRuleVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PriScgAplyDtRuleVO> models = new ArrayList<PriScgAplyDtRuleVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String podTpCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String porDefCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polDefCd = null;
	/* Column Info */
	private String delDefCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String podDefCd = null;
	/* Column Info */
	private String aplyDtRmk = null;
	/* Column Info */
	private String aplyDtRuleTpCd = null;
	/* Column Info */
	private String porTpCd = null;
	/* Column Info */
	private String scgAplyDtRuleSeq = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String polTpCd = null;
	/* Column Info */
	private String delTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PriScgAplyDtRuleVO() {}

	public PriScgAplyDtRuleVO(String ibflag, String pagerows, String scgAplyDtRuleSeq, String svcScpCd, String porTpCd, String porDefCd, String polTpCd, String polDefCd, String podTpCd, String podDefCd, String delTpCd, String delDefCd, String aplyDtRuleTpCd, String effDt, String expDt, String creDt, String creUsrId, String updDt, String updUsrId, String aplyDtRmk) {
		this.updDt = updDt;
		this.svcScpCd = svcScpCd;
		this.podTpCd = podTpCd;
		this.creDt = creDt;
		this.porDefCd = porDefCd;
		this.pagerows = pagerows;
		this.polDefCd = polDefCd;
		this.delDefCd = delDefCd;
		this.creUsrId = creUsrId;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.podDefCd = podDefCd;
		this.aplyDtRmk = aplyDtRmk;
		this.aplyDtRuleTpCd = aplyDtRuleTpCd;
		this.porTpCd = porTpCd;
		this.scgAplyDtRuleSeq = scgAplyDtRuleSeq;
		this.expDt = expDt;
		this.updUsrId = updUsrId;
		this.polTpCd = polTpCd;
		this.delTpCd = delTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("pod_tp_cd", getPodTpCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("por_def_cd", getPorDefCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_def_cd", getPolDefCd());
		this.hashColumns.put("del_def_cd", getDelDefCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pod_def_cd", getPodDefCd());
		this.hashColumns.put("aply_dt_rmk", getAplyDtRmk());
		this.hashColumns.put("aply_dt_rule_tp_cd", getAplyDtRuleTpCd());
		this.hashColumns.put("por_tp_cd", getPorTpCd());
		this.hashColumns.put("scg_aply_dt_rule_seq", getScgAplyDtRuleSeq());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pol_tp_cd", getPolTpCd());
		this.hashColumns.put("del_tp_cd", getDelTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("pod_tp_cd", "podTpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("por_def_cd", "porDefCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_def_cd", "polDefCd");
		this.hashFields.put("del_def_cd", "delDefCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pod_def_cd", "podDefCd");
		this.hashFields.put("aply_dt_rmk", "aplyDtRmk");
		this.hashFields.put("aply_dt_rule_tp_cd", "aplyDtRuleTpCd");
		this.hashFields.put("por_tp_cd", "porTpCd");
		this.hashFields.put("scg_aply_dt_rule_seq", "scgAplyDtRuleSeq");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pol_tp_cd", "polTpCd");
		this.hashFields.put("del_tp_cd", "delTpCd");
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
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return podTpCd
	 */
	public String getPodTpCd() {
		return this.podTpCd;
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
	 * @return porDefCd
	 */
	public String getPorDefCd() {
		return this.porDefCd;
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
	 * @return polDefCd
	 */
	public String getPolDefCd() {
		return this.polDefCd;
	}
	
	/**
	 * Column Info
	 * @return delDefCd
	 */
	public String getDelDefCd() {
		return this.delDefCd;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return podDefCd
	 */
	public String getPodDefCd() {
		return this.podDefCd;
	}
	
	/**
	 * Column Info
	 * @return aplyDtRmk
	 */
	public String getAplyDtRmk() {
		return this.aplyDtRmk;
	}
	
	/**
	 * Column Info
	 * @return aplyDtRuleTpCd
	 */
	public String getAplyDtRuleTpCd() {
		return this.aplyDtRuleTpCd;
	}
	
	/**
	 * Column Info
	 * @return porTpCd
	 */
	public String getPorTpCd() {
		return this.porTpCd;
	}
	
	/**
	 * Column Info
	 * @return scgAplyDtRuleSeq
	 */
	public String getScgAplyDtRuleSeq() {
		return this.scgAplyDtRuleSeq;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
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
	 * @return polTpCd
	 */
	public String getPolTpCd() {
		return this.polTpCd;
	}
	
	/**
	 * Column Info
	 * @return delTpCd
	 */
	public String getDelTpCd() {
		return this.delTpCd;
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
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param podTpCd
	 */
	public void setPodTpCd(String podTpCd) {
		this.podTpCd = podTpCd;
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
	 * @param porDefCd
	 */
	public void setPorDefCd(String porDefCd) {
		this.porDefCd = porDefCd;
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
	 * @param polDefCd
	 */
	public void setPolDefCd(String polDefCd) {
		this.polDefCd = polDefCd;
	}
	
	/**
	 * Column Info
	 * @param delDefCd
	 */
	public void setDelDefCd(String delDefCd) {
		this.delDefCd = delDefCd;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param podDefCd
	 */
	public void setPodDefCd(String podDefCd) {
		this.podDefCd = podDefCd;
	}
	
	/**
	 * Column Info
	 * @param aplyDtRmk
	 */
	public void setAplyDtRmk(String aplyDtRmk) {
		this.aplyDtRmk = aplyDtRmk;
	}
	
	/**
	 * Column Info
	 * @param aplyDtRuleTpCd
	 */
	public void setAplyDtRuleTpCd(String aplyDtRuleTpCd) {
		this.aplyDtRuleTpCd = aplyDtRuleTpCd;
	}
	
	/**
	 * Column Info
	 * @param porTpCd
	 */
	public void setPorTpCd(String porTpCd) {
		this.porTpCd = porTpCd;
	}
	
	/**
	 * Column Info
	 * @param scgAplyDtRuleSeq
	 */
	public void setScgAplyDtRuleSeq(String scgAplyDtRuleSeq) {
		this.scgAplyDtRuleSeq = scgAplyDtRuleSeq;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
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
	 * @param polTpCd
	 */
	public void setPolTpCd(String polTpCd) {
		this.polTpCd = polTpCd;
	}
	
	/**
	 * Column Info
	 * @param delTpCd
	 */
	public void setDelTpCd(String delTpCd) {
		this.delTpCd = delTpCd;
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
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setPodTpCd(JSPUtil.getParameter(request, prefix + "pod_tp_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPorDefCd(JSPUtil.getParameter(request, prefix + "por_def_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolDefCd(JSPUtil.getParameter(request, prefix + "pol_def_cd", ""));
		setDelDefCd(JSPUtil.getParameter(request, prefix + "del_def_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPodDefCd(JSPUtil.getParameter(request, prefix + "pod_def_cd", ""));
		setAplyDtRmk(JSPUtil.getParameter(request, prefix + "aply_dt_rmk", ""));
		setAplyDtRuleTpCd(JSPUtil.getParameter(request, prefix + "aply_dt_rule_tp_cd", ""));
		setPorTpCd(JSPUtil.getParameter(request, prefix + "por_tp_cd", ""));
		setScgAplyDtRuleSeq(JSPUtil.getParameter(request, prefix + "scg_aply_dt_rule_seq", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setPolTpCd(JSPUtil.getParameter(request, prefix + "pol_tp_cd", ""));
		setDelTpCd(JSPUtil.getParameter(request, prefix + "del_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PriScgAplyDtRuleVO[]
	 */
	public PriScgAplyDtRuleVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PriScgAplyDtRuleVO[]
	 */
	public PriScgAplyDtRuleVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PriScgAplyDtRuleVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] podTpCd = (JSPUtil.getParameter(request, prefix	+ "pod_tp_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] porDefCd = (JSPUtil.getParameter(request, prefix	+ "por_def_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polDefCd = (JSPUtil.getParameter(request, prefix	+ "pol_def_cd", length));
			String[] delDefCd = (JSPUtil.getParameter(request, prefix	+ "del_def_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] podDefCd = (JSPUtil.getParameter(request, prefix	+ "pod_def_cd", length));
			String[] aplyDtRmk = (JSPUtil.getParameter(request, prefix	+ "aply_dt_rmk", length));
			String[] aplyDtRuleTpCd = (JSPUtil.getParameter(request, prefix	+ "aply_dt_rule_tp_cd", length));
			String[] porTpCd = (JSPUtil.getParameter(request, prefix	+ "por_tp_cd", length));
			String[] scgAplyDtRuleSeq = (JSPUtil.getParameter(request, prefix	+ "scg_aply_dt_rule_seq", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] polTpCd = (JSPUtil.getParameter(request, prefix	+ "pol_tp_cd", length));
			String[] delTpCd = (JSPUtil.getParameter(request, prefix	+ "del_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new PriScgAplyDtRuleVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (podTpCd[i] != null)
					model.setPodTpCd(podTpCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (porDefCd[i] != null)
					model.setPorDefCd(porDefCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polDefCd[i] != null)
					model.setPolDefCd(polDefCd[i]);
				if (delDefCd[i] != null)
					model.setDelDefCd(delDefCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (podDefCd[i] != null)
					model.setPodDefCd(podDefCd[i]);
				if (aplyDtRmk[i] != null)
					model.setAplyDtRmk(aplyDtRmk[i]);
				if (aplyDtRuleTpCd[i] != null)
					model.setAplyDtRuleTpCd(aplyDtRuleTpCd[i]);
				if (porTpCd[i] != null)
					model.setPorTpCd(porTpCd[i]);
				if (scgAplyDtRuleSeq[i] != null)
					model.setScgAplyDtRuleSeq(scgAplyDtRuleSeq[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (polTpCd[i] != null)
					model.setPolTpCd(polTpCd[i]);
				if (delTpCd[i] != null)
					model.setDelTpCd(delTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPriScgAplyDtRuleVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PriScgAplyDtRuleVO[]
	 */
	public PriScgAplyDtRuleVO[] getPriScgAplyDtRuleVOs(){
		PriScgAplyDtRuleVO[] vos = (PriScgAplyDtRuleVO[])models.toArray(new PriScgAplyDtRuleVO[models.size()]);
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
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podTpCd = this.podTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porDefCd = this.porDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polDefCd = this.polDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delDefCd = this.delDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podDefCd = this.podDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aplyDtRmk = this.aplyDtRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aplyDtRuleTpCd = this.aplyDtRuleTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porTpCd = this.porTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgAplyDtRuleSeq = this.scgAplyDtRuleSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polTpCd = this.polTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delTpCd = this.delTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
