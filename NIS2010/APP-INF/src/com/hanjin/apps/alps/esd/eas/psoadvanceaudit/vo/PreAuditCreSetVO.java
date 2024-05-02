/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PreAuditCreSetVO.java
*@FileTitle : PreAuditCreSetVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.11
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.06.11 백형인 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.psoadvanceaudit.vo;

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
 * @author 백형인
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PreAuditCreSetVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PreAuditCreSetVO> models = new ArrayList<PreAuditCreSetVO>();
	
	/* Column Info */
	private String acctNm = null;
	/* Column Info */
	private String sAutoAcd = null;
	/* Column Info */
	private String costNm = null;
	/* Column Info */
	private String sAudOfcCd = null;
	/* Column Info */
	private String chgTpNm = null;
	/* Column Info */
	private String expnPrmtRtoRsn = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String lgsCostAudFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costCd = null;
	/* Column Info */
	private String expnMaxPrmtRto = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String audOfcCd = null;
	/* Column Info */
	private String sChgTpCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String uptDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PreAuditCreSetVO() {}

	public PreAuditCreSetVO(String ibflag, String pagerows, String chgTpNm, String acctCd, String acctNm, String costCd, String costNm, String lgsCostAudFlg, String expnMaxPrmtRto, String expnPrmtRtoRsn, String sChgTpCd, String updUsrId, String audOfcCd, String sAudOfcCd, String sAutoAcd, String uptDt) {
		this.acctNm = acctNm;
		this.sAutoAcd = sAutoAcd;
		this.costNm = costNm;
		this.sAudOfcCd = sAudOfcCd;
		this.chgTpNm = chgTpNm;
		this.expnPrmtRtoRsn = expnPrmtRtoRsn;
		this.pagerows = pagerows;
		this.lgsCostAudFlg = lgsCostAudFlg;
		this.ibflag = ibflag;
		this.costCd = costCd;
		this.expnMaxPrmtRto = expnMaxPrmtRto;
		this.acctCd = acctCd;
		this.audOfcCd = audOfcCd;
		this.sChgTpCd = sChgTpCd;
		this.updUsrId = updUsrId;
		this.uptDt = uptDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("acct_nm", getAcctNm());
		this.hashColumns.put("s_auto_acd", getSAutoAcd());
		this.hashColumns.put("cost_nm", getCostNm());
		this.hashColumns.put("s_aud_ofc_cd", getSAudOfcCd());
		this.hashColumns.put("chg_tp_nm", getChgTpNm());
		this.hashColumns.put("expn_prmt_rto_rsn", getExpnPrmtRtoRsn());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("lgs_cost_aud_flg", getLgsCostAudFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_cd", getCostCd());
		this.hashColumns.put("expn_max_prmt_rto", getExpnMaxPrmtRto());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("aud_ofc_cd", getAudOfcCd());
		this.hashColumns.put("s_chg_tp_cd", getSChgTpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upt_dt", getUptDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("acct_nm", "acctNm");
		this.hashFields.put("s_auto_acd", "sAutoAcd");
		this.hashFields.put("cost_nm", "costNm");
		this.hashFields.put("s_aud_ofc_cd", "sAudOfcCd");
		this.hashFields.put("chg_tp_nm", "chgTpNm");
		this.hashFields.put("expn_prmt_rto_rsn", "expnPrmtRtoRsn");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lgs_cost_aud_flg", "lgsCostAudFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_cd", "costCd");
		this.hashFields.put("expn_max_prmt_rto", "expnMaxPrmtRto");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("aud_ofc_cd", "audOfcCd");
		this.hashFields.put("s_chg_tp_cd", "sChgTpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upt_dt", "uptDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return acctNm
	 */
	public String getAcctNm() {
		return this.acctNm;
	}
	
	/**
	 * Column Info
	 * @return sAutoAcd
	 */
	public String getSAutoAcd() {
		return this.sAutoAcd;
	}
	
	/**
	 * Column Info
	 * @return costNm
	 */
	public String getCostNm() {
		return this.costNm;
	}
	
	/**
	 * Column Info
	 * @return sAudOfcCd
	 */
	public String getSAudOfcCd() {
		return this.sAudOfcCd;
	}
	
	/**
	 * Column Info
	 * @return chgTpNm
	 */
	public String getChgTpNm() {
		return this.chgTpNm;
	}
	
	/**
	 * Column Info
	 * @return expnPrmtRtoRsn
	 */
	public String getExpnPrmtRtoRsn() {
		return this.expnPrmtRtoRsn;
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
	 * @return lgsCostAudFlg
	 */
	public String getLgsCostAudFlg() {
		return this.lgsCostAudFlg;
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
	 * @return costCd
	 */
	public String getCostCd() {
		return this.costCd;
	}
	
	/**
	 * Column Info
	 * @return expnMaxPrmtRto
	 */
	public String getExpnMaxPrmtRto() {
		return this.expnMaxPrmtRto;
	}
	
	/**
	 * Column Info
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
	}
	
	/**
	 * Column Info
	 * @return audOfcCd
	 */
	public String getAudOfcCd() {
		return this.audOfcCd;
	}
	
	/**
	 * Column Info
	 * @return sChgTpCd
	 */
	public String getSChgTpCd() {
		return this.sChgTpCd;
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
	 * @param acctNm
	 */
	public void setAcctNm(String acctNm) {
		this.acctNm = acctNm;
	}
	
	/**
	 * Column Info
	 * @param sAutoAcd
	 */
	public void setSAutoAcd(String sAutoAcd) {
		this.sAutoAcd = sAutoAcd;
	}
	
	/**
	 * Column Info
	 * @param costNm
	 */
	public void setCostNm(String costNm) {
		this.costNm = costNm;
	}
	
	/**
	 * Column Info
	 * @param sAudOfcCd
	 */
	public void setSAudOfcCd(String sAudOfcCd) {
		this.sAudOfcCd = sAudOfcCd;
	}
	
	/**
	 * Column Info
	 * @param chgTpNm
	 */
	public void setChgTpNm(String chgTpNm) {
		this.chgTpNm = chgTpNm;
	}
	
	/**
	 * Column Info
	 * @param expnPrmtRtoRsn
	 */
	public void setExpnPrmtRtoRsn(String expnPrmtRtoRsn) {
		this.expnPrmtRtoRsn = expnPrmtRtoRsn;
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
	 * @param lgsCostAudFlg
	 */
	public void setLgsCostAudFlg(String lgsCostAudFlg) {
		this.lgsCostAudFlg = lgsCostAudFlg;
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
	 * @param costCd
	 */
	public void setCostCd(String costCd) {
		this.costCd = costCd;
	}
	
	/**
	 * Column Info
	 * @param expnMaxPrmtRto
	 */
	public void setExpnMaxPrmtRto(String expnMaxPrmtRto) {
		this.expnMaxPrmtRto = expnMaxPrmtRto;
	}
	
	/**
	 * Column Info
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	
	/**
	 * Column Info
	 * @param audOfcCd
	 */
	public void setAudOfcCd(String audOfcCd) {
		this.audOfcCd = audOfcCd;
	}
	
	/**
	 * Column Info
	 * @param sChgTpCd
	 */
	public void setSChgTpCd(String sChgTpCd) {
		this.sChgTpCd = sChgTpCd;
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
	 * @param uptDt
	 */
	public String getUptDt() {
		return uptDt;
	}

	/**
	 * Column Info
	 * @param uptDt
	 */
	public void setUptDt(String uptDt) {
		this.uptDt = uptDt;
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
		setAcctNm(JSPUtil.getParameter(request, prefix + "acct_nm", ""));
		setSAutoAcd(JSPUtil.getParameter(request, prefix + "s_auto_acd", ""));
		setCostNm(JSPUtil.getParameter(request, prefix + "cost_nm", ""));
		setSAudOfcCd(JSPUtil.getParameter(request, prefix + "s_aud_ofc_cd", ""));
		setChgTpNm(JSPUtil.getParameter(request, prefix + "chg_tp_nm", ""));
		setExpnPrmtRtoRsn(JSPUtil.getParameter(request, prefix + "expn_prmt_rto_rsn", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setLgsCostAudFlg(JSPUtil.getParameter(request, prefix + "lgs_cost_aud_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCostCd(JSPUtil.getParameter(request, prefix + "cost_cd", ""));
		setExpnMaxPrmtRto(JSPUtil.getParameter(request, prefix + "expn_max_prmt_rto", ""));
		setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
		setAudOfcCd(JSPUtil.getParameter(request, prefix + "aud_ofc_cd", ""));
		setSChgTpCd(JSPUtil.getParameter(request, prefix + "s_chg_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUptDt(JSPUtil.getParameter(request, prefix + "upt_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PreAuditCreSetVO[]
	 */
	public PreAuditCreSetVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PreAuditCreSetVO[]
	 */
	public PreAuditCreSetVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PreAuditCreSetVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] acctNm = (JSPUtil.getParameter(request, prefix	+ "acct_nm", length));
			String[] sAutoAcd = (JSPUtil.getParameter(request, prefix	+ "s_auto_acd", length));
			String[] costNm = (JSPUtil.getParameter(request, prefix	+ "cost_nm", length));
			String[] sAudOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_aud_ofc_cd", length));
			String[] chgTpNm = (JSPUtil.getParameter(request, prefix	+ "chg_tp_nm", length));
			String[] expnPrmtRtoRsn = (JSPUtil.getParameter(request, prefix	+ "expn_prmt_rto_rsn", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] lgsCostAudFlg = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_aud_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costCd = (JSPUtil.getParameter(request, prefix	+ "cost_cd", length));
			String[] expnMaxPrmtRto = (JSPUtil.getParameter(request, prefix	+ "expn_max_prmt_rto", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] audOfcCd = (JSPUtil.getParameter(request, prefix	+ "aud_ofc_cd", length));
			String[] sChgTpCd = (JSPUtil.getParameter(request, prefix	+ "s_chg_tp_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] uptDt = (JSPUtil.getParameter(request, prefix	+ "upt_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new PreAuditCreSetVO();
				if (acctNm[i] != null)
					model.setAcctNm(acctNm[i]);
				if (sAutoAcd[i] != null)
					model.setSAutoAcd(sAutoAcd[i]);
				if (costNm[i] != null)
					model.setCostNm(costNm[i]);
				if (sAudOfcCd[i] != null)
					model.setSAudOfcCd(sAudOfcCd[i]);
				if (chgTpNm[i] != null)
					model.setChgTpNm(chgTpNm[i]);
				if (expnPrmtRtoRsn[i] != null)
					model.setExpnPrmtRtoRsn(expnPrmtRtoRsn[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lgsCostAudFlg[i] != null)
					model.setLgsCostAudFlg(lgsCostAudFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costCd[i] != null)
					model.setCostCd(costCd[i]);
				if (expnMaxPrmtRto[i] != null)
					model.setExpnMaxPrmtRto(expnMaxPrmtRto[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (audOfcCd[i] != null)
					model.setAudOfcCd(audOfcCd[i]);
				if (sChgTpCd[i] != null)
					model.setSChgTpCd(sChgTpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (uptDt[i] != null)
					model.setUptDt(uptDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPreAuditCreSetVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PreAuditCreSetVO[]
	 */
	public PreAuditCreSetVO[] getPreAuditCreSetVOs(){
		PreAuditCreSetVO[] vos = (PreAuditCreSetVO[])models.toArray(new PreAuditCreSetVO[models.size()]);
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
		this.acctNm = this.acctNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sAutoAcd = this.sAutoAcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costNm = this.costNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sAudOfcCd = this.sAudOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgTpNm = this.chgTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expnPrmtRtoRsn = this.expnPrmtRtoRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostAudFlg = this.lgsCostAudFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCd = this.costCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expnMaxPrmtRto = this.expnMaxPrmtRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.audOfcCd = this.audOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sChgTpCd = this.sChgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uptDt = this.uptDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
