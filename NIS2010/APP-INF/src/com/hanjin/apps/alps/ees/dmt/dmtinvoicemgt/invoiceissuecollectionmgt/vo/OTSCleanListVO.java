/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : OTSCleanListVO.java
*@FileTitle : OTSCleanListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.30
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.30  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo;

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

public class OTSCleanListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OTSCleanListVO> models = new ArrayList<OTSCleanListVO>();
	
	/* Column Info */
	private String cticyn = null;
	/* Column Info */
	private String dmofyn = null;
	/* Column Info */
	private String payern = null;
	/* Column Info */
	private String invChgAmt = null;
	/* Column Info */
	private String dmdtPayrOtsRmk = null;
	/* Column Info */
	private String shCd = null;
	/* Column Info */
	private String netExptAmt = null;
	/* Column Info */
	private String bilAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String obSrepCd = null;
	/* Column Info */
	private String ctocyn = null;
	/* Column Info */
	private String otsRmk = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dcAmt = null;
	/* Column Info */
	private String taxAmt = null;
	/* Column Info */
	private String payerc = null;
	/* Column Info */
	private String dmdtExptAmt = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String dticyn = null;
	/* Column Info */
	private String shNm = null;
	/* Column Info */
	private String dtocyn = null;
	/* Column Info */
	private String orgChgAmt = null;
	/* Column Info */
	private String cmdtExptAmt = null;
	/* Column Info */
	private String dmifyn = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public OTSCleanListVO() {}

	public OTSCleanListVO(String ibflag, String pagerows, String payerc, String payern, String shCd, String shNm, String obSrepCd, String orgChgAmt, String cmdtExptAmt, String dmdtExptAmt, String netExptAmt, String dcAmt, String bilAmt, String taxAmt, String invChgAmt, String invAmt, String dmdtPayrOtsRmk, String otsRmk, String dmifyn, String dticyn, String dmofyn, String dtocyn, String cticyn, String ctocyn) {
		this.cticyn = cticyn;
		this.dmofyn = dmofyn;
		this.payern = payern;
		this.invChgAmt = invChgAmt;
		this.dmdtPayrOtsRmk = dmdtPayrOtsRmk;
		this.shCd = shCd;
		this.netExptAmt = netExptAmt;
		this.bilAmt = bilAmt;
		this.pagerows = pagerows;
		this.obSrepCd = obSrepCd;
		this.ctocyn = ctocyn;
		this.otsRmk = otsRmk;
		this.ibflag = ibflag;
		this.dcAmt = dcAmt;
		this.taxAmt = taxAmt;
		this.payerc = payerc;
		this.dmdtExptAmt = dmdtExptAmt;
		this.invAmt = invAmt;
		this.dticyn = dticyn;
		this.shNm = shNm;
		this.dtocyn = dtocyn;
		this.orgChgAmt = orgChgAmt;
		this.cmdtExptAmt = cmdtExptAmt;
		this.dmifyn = dmifyn;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cticyn", getCticyn());
		this.hashColumns.put("dmofyn", getDmofyn());
		this.hashColumns.put("payern", getPayern());
		this.hashColumns.put("inv_chg_amt", getInvChgAmt());
		this.hashColumns.put("dmdt_payr_ots_rmk", getDmdtPayrOtsRmk());
		this.hashColumns.put("sh_cd", getShCd());
		this.hashColumns.put("net_expt_amt", getNetExptAmt());
		this.hashColumns.put("bil_amt", getBilAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ob_srep_cd", getObSrepCd());
		this.hashColumns.put("ctocyn", getCtocyn());
		this.hashColumns.put("ots_rmk", getOtsRmk());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dc_amt", getDcAmt());
		this.hashColumns.put("tax_amt", getTaxAmt());
		this.hashColumns.put("payerc", getPayerc());
		this.hashColumns.put("dmdt_expt_amt", getDmdtExptAmt());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("dticyn", getDticyn());
		this.hashColumns.put("sh_nm", getShNm());
		this.hashColumns.put("dtocyn", getDtocyn());
		this.hashColumns.put("org_chg_amt", getOrgChgAmt());
		this.hashColumns.put("cmdt_expt_amt", getCmdtExptAmt());
		this.hashColumns.put("dmifyn", getDmifyn());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cticyn", "cticyn");
		this.hashFields.put("dmofyn", "dmofyn");
		this.hashFields.put("payern", "payern");
		this.hashFields.put("inv_chg_amt", "invChgAmt");
		this.hashFields.put("dmdt_payr_ots_rmk", "dmdtPayrOtsRmk");
		this.hashFields.put("sh_cd", "shCd");
		this.hashFields.put("net_expt_amt", "netExptAmt");
		this.hashFields.put("bil_amt", "bilAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ob_srep_cd", "obSrepCd");
		this.hashFields.put("ctocyn", "ctocyn");
		this.hashFields.put("ots_rmk", "otsRmk");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dc_amt", "dcAmt");
		this.hashFields.put("tax_amt", "taxAmt");
		this.hashFields.put("payerc", "payerc");
		this.hashFields.put("dmdt_expt_amt", "dmdtExptAmt");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("dticyn", "dticyn");
		this.hashFields.put("sh_nm", "shNm");
		this.hashFields.put("dtocyn", "dtocyn");
		this.hashFields.put("org_chg_amt", "orgChgAmt");
		this.hashFields.put("cmdt_expt_amt", "cmdtExptAmt");
		this.hashFields.put("dmifyn", "dmifyn");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cticyn
	 */
	public String getCticyn() {
		return this.cticyn;
	}
	
	/**
	 * Column Info
	 * @return dmofyn
	 */
	public String getDmofyn() {
		return this.dmofyn;
	}
	
	/**
	 * Column Info
	 * @return payern
	 */
	public String getPayern() {
		return this.payern;
	}
	
	/**
	 * Column Info
	 * @return invChgAmt
	 */
	public String getInvChgAmt() {
		return this.invChgAmt;
	}
	
	/**
	 * Column Info
	 * @return dmdtPayrOtsRmk
	 */
	public String getDmdtPayrOtsRmk() {
		return this.dmdtPayrOtsRmk;
	}
	
	/**
	 * Column Info
	 * @return shCd
	 */
	public String getShCd() {
		return this.shCd;
	}
	
	/**
	 * Column Info
	 * @return netExptAmt
	 */
	public String getNetExptAmt() {
		return this.netExptAmt;
	}
	
	/**
	 * Column Info
	 * @return bilAmt
	 */
	public String getBilAmt() {
		return this.bilAmt;
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
	 * @return obSrepCd
	 */
	public String getObSrepCd() {
		return this.obSrepCd;
	}
	
	/**
	 * Column Info
	 * @return ctocyn
	 */
	public String getCtocyn() {
		return this.ctocyn;
	}
	
	/**
	 * Column Info
	 * @return otsRmk
	 */
	public String getOtsRmk() {
		return this.otsRmk;
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
	 * @return dcAmt
	 */
	public String getDcAmt() {
		return this.dcAmt;
	}
	
	/**
	 * Column Info
	 * @return taxAmt
	 */
	public String getTaxAmt() {
		return this.taxAmt;
	}
	
	/**
	 * Column Info
	 * @return payerc
	 */
	public String getPayerc() {
		return this.payerc;
	}
	
	/**
	 * Column Info
	 * @return dmdtExptAmt
	 */
	public String getDmdtExptAmt() {
		return this.dmdtExptAmt;
	}
	
	/**
	 * Column Info
	 * @return invAmt
	 */
	public String getInvAmt() {
		return this.invAmt;
	}
	
	/**
	 * Column Info
	 * @return dticyn
	 */
	public String getDticyn() {
		return this.dticyn;
	}
	
	/**
	 * Column Info
	 * @return shNm
	 */
	public String getShNm() {
		return this.shNm;
	}
	
	/**
	 * Column Info
	 * @return dtocyn
	 */
	public String getDtocyn() {
		return this.dtocyn;
	}
	
	/**
	 * Column Info
	 * @return orgChgAmt
	 */
	public String getOrgChgAmt() {
		return this.orgChgAmt;
	}
	
	/**
	 * Column Info
	 * @return cmdtExptAmt
	 */
	public String getCmdtExptAmt() {
		return this.cmdtExptAmt;
	}
	
	/**
	 * Column Info
	 * @return dmifyn
	 */
	public String getDmifyn() {
		return this.dmifyn;
	}
	

	/**
	 * Column Info
	 * @param cticyn
	 */
	public void setCticyn(String cticyn) {
		this.cticyn = cticyn;
	}
	
	/**
	 * Column Info
	 * @param dmofyn
	 */
	public void setDmofyn(String dmofyn) {
		this.dmofyn = dmofyn;
	}
	
	/**
	 * Column Info
	 * @param payern
	 */
	public void setPayern(String payern) {
		this.payern = payern;
	}
	
	/**
	 * Column Info
	 * @param invChgAmt
	 */
	public void setInvChgAmt(String invChgAmt) {
		this.invChgAmt = invChgAmt;
	}
	
	/**
	 * Column Info
	 * @param dmdtPayrOtsRmk
	 */
	public void setDmdtPayrOtsRmk(String dmdtPayrOtsRmk) {
		this.dmdtPayrOtsRmk = dmdtPayrOtsRmk;
	}
	
	/**
	 * Column Info
	 * @param shCd
	 */
	public void setShCd(String shCd) {
		this.shCd = shCd;
	}
	
	/**
	 * Column Info
	 * @param netExptAmt
	 */
	public void setNetExptAmt(String netExptAmt) {
		this.netExptAmt = netExptAmt;
	}
	
	/**
	 * Column Info
	 * @param bilAmt
	 */
	public void setBilAmt(String bilAmt) {
		this.bilAmt = bilAmt;
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
	 * @param obSrepCd
	 */
	public void setObSrepCd(String obSrepCd) {
		this.obSrepCd = obSrepCd;
	}
	
	/**
	 * Column Info
	 * @param ctocyn
	 */
	public void setCtocyn(String ctocyn) {
		this.ctocyn = ctocyn;
	}
	
	/**
	 * Column Info
	 * @param otsRmk
	 */
	public void setOtsRmk(String otsRmk) {
		this.otsRmk = otsRmk;
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
	 * @param dcAmt
	 */
	public void setDcAmt(String dcAmt) {
		this.dcAmt = dcAmt;
	}
	
	/**
	 * Column Info
	 * @param taxAmt
	 */
	public void setTaxAmt(String taxAmt) {
		this.taxAmt = taxAmt;
	}
	
	/**
	 * Column Info
	 * @param payerc
	 */
	public void setPayerc(String payerc) {
		this.payerc = payerc;
	}
	
	/**
	 * Column Info
	 * @param dmdtExptAmt
	 */
	public void setDmdtExptAmt(String dmdtExptAmt) {
		this.dmdtExptAmt = dmdtExptAmt;
	}
	
	/**
	 * Column Info
	 * @param invAmt
	 */
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
	}
	
	/**
	 * Column Info
	 * @param dticyn
	 */
	public void setDticyn(String dticyn) {
		this.dticyn = dticyn;
	}
	
	/**
	 * Column Info
	 * @param shNm
	 */
	public void setShNm(String shNm) {
		this.shNm = shNm;
	}
	
	/**
	 * Column Info
	 * @param dtocyn
	 */
	public void setDtocyn(String dtocyn) {
		this.dtocyn = dtocyn;
	}
	
	/**
	 * Column Info
	 * @param orgChgAmt
	 */
	public void setOrgChgAmt(String orgChgAmt) {
		this.orgChgAmt = orgChgAmt;
	}
	
	/**
	 * Column Info
	 * @param cmdtExptAmt
	 */
	public void setCmdtExptAmt(String cmdtExptAmt) {
		this.cmdtExptAmt = cmdtExptAmt;
	}
	
	/**
	 * Column Info
	 * @param dmifyn
	 */
	public void setDmifyn(String dmifyn) {
		this.dmifyn = dmifyn;
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
		setCticyn(JSPUtil.getParameter(request, prefix + "cticyn", ""));
		setDmofyn(JSPUtil.getParameter(request, prefix + "dmofyn", ""));
		setPayern(JSPUtil.getParameter(request, prefix + "payern", ""));
		setInvChgAmt(JSPUtil.getParameter(request, prefix + "inv_chg_amt", ""));
		setDmdtPayrOtsRmk(JSPUtil.getParameter(request, prefix + "dmdt_payr_ots_rmk", ""));
		setShCd(JSPUtil.getParameter(request, prefix + "sh_cd", ""));
		setNetExptAmt(JSPUtil.getParameter(request, prefix + "net_expt_amt", ""));
		setBilAmt(JSPUtil.getParameter(request, prefix + "bil_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setObSrepCd(JSPUtil.getParameter(request, prefix + "ob_srep_cd", ""));
		setCtocyn(JSPUtil.getParameter(request, prefix + "ctocyn", ""));
		setOtsRmk(JSPUtil.getParameter(request, prefix + "ots_rmk", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDcAmt(JSPUtil.getParameter(request, prefix + "dc_amt", ""));
		setTaxAmt(JSPUtil.getParameter(request, prefix + "tax_amt", ""));
		setPayerc(JSPUtil.getParameter(request, prefix + "payerc", ""));
		setDmdtExptAmt(JSPUtil.getParameter(request, prefix + "dmdt_expt_amt", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setDticyn(JSPUtil.getParameter(request, prefix + "dticyn", ""));
		setShNm(JSPUtil.getParameter(request, prefix + "sh_nm", ""));
		setDtocyn(JSPUtil.getParameter(request, prefix + "dtocyn", ""));
		setOrgChgAmt(JSPUtil.getParameter(request, prefix + "org_chg_amt", ""));
		setCmdtExptAmt(JSPUtil.getParameter(request, prefix + "cmdt_expt_amt", ""));
		setDmifyn(JSPUtil.getParameter(request, prefix + "dmifyn", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OTSCleanListVO[]
	 */
	public OTSCleanListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OTSCleanListVO[]
	 */
	public OTSCleanListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OTSCleanListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cticyn = (JSPUtil.getParameter(request, prefix	+ "cticyn", length));
			String[] dmofyn = (JSPUtil.getParameter(request, prefix	+ "dmofyn", length));
			String[] payern = (JSPUtil.getParameter(request, prefix	+ "payern", length));
			String[] invChgAmt = (JSPUtil.getParameter(request, prefix	+ "inv_chg_amt", length));
			String[] dmdtPayrOtsRmk = (JSPUtil.getParameter(request, prefix	+ "dmdt_payr_ots_rmk", length));
			String[] shCd = (JSPUtil.getParameter(request, prefix	+ "sh_cd", length));
			String[] netExptAmt = (JSPUtil.getParameter(request, prefix	+ "net_expt_amt", length));
			String[] bilAmt = (JSPUtil.getParameter(request, prefix	+ "bil_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] obSrepCd = (JSPUtil.getParameter(request, prefix	+ "ob_srep_cd", length));
			String[] ctocyn = (JSPUtil.getParameter(request, prefix	+ "ctocyn", length));
			String[] otsRmk = (JSPUtil.getParameter(request, prefix	+ "ots_rmk", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dcAmt = (JSPUtil.getParameter(request, prefix	+ "dc_amt", length));
			String[] taxAmt = (JSPUtil.getParameter(request, prefix	+ "tax_amt", length));
			String[] payerc = (JSPUtil.getParameter(request, prefix	+ "payerc", length));
			String[] dmdtExptAmt = (JSPUtil.getParameter(request, prefix	+ "dmdt_expt_amt", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] dticyn = (JSPUtil.getParameter(request, prefix	+ "dticyn", length));
			String[] shNm = (JSPUtil.getParameter(request, prefix	+ "sh_nm", length));
			String[] dtocyn = (JSPUtil.getParameter(request, prefix	+ "dtocyn", length));
			String[] orgChgAmt = (JSPUtil.getParameter(request, prefix	+ "org_chg_amt", length));
			String[] cmdtExptAmt = (JSPUtil.getParameter(request, prefix	+ "cmdt_expt_amt", length));
			String[] dmifyn = (JSPUtil.getParameter(request, prefix	+ "dmifyn", length));
			
			for (int i = 0; i < length; i++) {
				model = new OTSCleanListVO();
				if (cticyn[i] != null)
					model.setCticyn(cticyn[i]);
				if (dmofyn[i] != null)
					model.setDmofyn(dmofyn[i]);
				if (payern[i] != null)
					model.setPayern(payern[i]);
				if (invChgAmt[i] != null)
					model.setInvChgAmt(invChgAmt[i]);
				if (dmdtPayrOtsRmk[i] != null)
					model.setDmdtPayrOtsRmk(dmdtPayrOtsRmk[i]);
				if (shCd[i] != null)
					model.setShCd(shCd[i]);
				if (netExptAmt[i] != null)
					model.setNetExptAmt(netExptAmt[i]);
				if (bilAmt[i] != null)
					model.setBilAmt(bilAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (obSrepCd[i] != null)
					model.setObSrepCd(obSrepCd[i]);
				if (ctocyn[i] != null)
					model.setCtocyn(ctocyn[i]);
				if (otsRmk[i] != null)
					model.setOtsRmk(otsRmk[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dcAmt[i] != null)
					model.setDcAmt(dcAmt[i]);
				if (taxAmt[i] != null)
					model.setTaxAmt(taxAmt[i]);
				if (payerc[i] != null)
					model.setPayerc(payerc[i]);
				if (dmdtExptAmt[i] != null)
					model.setDmdtExptAmt(dmdtExptAmt[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (dticyn[i] != null)
					model.setDticyn(dticyn[i]);
				if (shNm[i] != null)
					model.setShNm(shNm[i]);
				if (dtocyn[i] != null)
					model.setDtocyn(dtocyn[i]);
				if (orgChgAmt[i] != null)
					model.setOrgChgAmt(orgChgAmt[i]);
				if (cmdtExptAmt[i] != null)
					model.setCmdtExptAmt(cmdtExptAmt[i]);
				if (dmifyn[i] != null)
					model.setDmifyn(dmifyn[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOTSCleanListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OTSCleanListVO[]
	 */
	public OTSCleanListVO[] getOTSCleanListVOs(){
		OTSCleanListVO[] vos = (OTSCleanListVO[])models.toArray(new OTSCleanListVO[models.size()]);
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
		this.cticyn = this.cticyn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmofyn = this.dmofyn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payern = this.payern .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invChgAmt = this.invChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtPayrOtsRmk = this.dmdtPayrOtsRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCd = this.shCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netExptAmt = this.netExptAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilAmt = this.bilAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSrepCd = this.obSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctocyn = this.ctocyn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsRmk = this.otsRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcAmt = this.dcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxAmt = this.taxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payerc = this.payerc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtExptAmt = this.dmdtExptAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dticyn = this.dticyn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shNm = this.shNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtocyn = this.dtocyn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgChgAmt = this.orgChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtExptAmt = this.cmdtExptAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmifyn = this.dmifyn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
