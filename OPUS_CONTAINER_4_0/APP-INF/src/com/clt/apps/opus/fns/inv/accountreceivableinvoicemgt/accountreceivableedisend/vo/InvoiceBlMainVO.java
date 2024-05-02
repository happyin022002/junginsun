/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InvoiceBlMainVO.java
*@FileTitle : InvoiceBlMainVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.23  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo;

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

public class InvoiceBlMainVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvoiceBlMainVO> models = new ArrayList<InvoiceBlMainVO>();
	
	/* Column Info */
	private String podTrafficMd = null;
	/* Column Info */
	private String remark = null;
	/* Column Info */
	private String invCurrTtl = null;
	/* Column Info */
	private String invExRate = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String invTpCd = null;
	/* Column Info */
	private String appDt = null;
	/* Column Info */
	private String payDueDt = null;
	/* Column Info */
	private String invCurr = null;
	/* Column Info */
	private String invStatus = null;
	/* Column Info */
	private String porTrafficMd = null;
	/* Column Info */
	private String invPaytermClus = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public InvoiceBlMainVO() {}

	public InvoiceBlMainVO(String ibflag, String pagerows, String invTpCd, String invStatus, String porTrafficMd, String podTrafficMd, String payDueDt, String invCurr, String invCurrTtl, String invExRate, String invPaytermClus, String remark, String appDt) {
		this.podTrafficMd = podTrafficMd;
		this.remark = remark;
		this.invCurrTtl = invCurrTtl;
		this.invExRate = invExRate;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.invTpCd = invTpCd;
		this.appDt = appDt;
		this.payDueDt = payDueDt;
		this.invCurr = invCurr;
		this.invStatus = invStatus;
		this.porTrafficMd = porTrafficMd;
		this.invPaytermClus = invPaytermClus;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pod_traffic_md", getPodTrafficMd());
		this.hashColumns.put("remark", getRemark());
		this.hashColumns.put("inv_curr_ttl", getInvCurrTtl());
		this.hashColumns.put("inv_ex_rate", getInvExRate());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("inv_tp_cd", getInvTpCd());
		this.hashColumns.put("app_dt", getAppDt());
		this.hashColumns.put("pay_due_dt", getPayDueDt());
		this.hashColumns.put("inv_curr", getInvCurr());
		this.hashColumns.put("inv_status", getInvStatus());
		this.hashColumns.put("por_traffic_md", getPorTrafficMd());
		this.hashColumns.put("inv_payterm_clus", getInvPaytermClus());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pod_traffic_md", "podTrafficMd");
		this.hashFields.put("remark", "remark");
		this.hashFields.put("inv_curr_ttl", "invCurrTtl");
		this.hashFields.put("inv_ex_rate", "invExRate");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inv_tp_cd", "invTpCd");
		this.hashFields.put("app_dt", "appDt");
		this.hashFields.put("pay_due_dt", "payDueDt");
		this.hashFields.put("inv_curr", "invCurr");
		this.hashFields.put("inv_status", "invStatus");
		this.hashFields.put("por_traffic_md", "porTrafficMd");
		this.hashFields.put("inv_payterm_clus", "invPaytermClus");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return podTrafficMd
	 */
	public String getPodTrafficMd() {
		return this.podTrafficMd;
	}
	
	/**
	 * Column Info
	 * @return remark
	 */
	public String getRemark() {
		return this.remark;
	}
	
	/**
	 * Column Info
	 * @return invCurrTtl
	 */
	public String getInvCurrTtl() {
		return this.invCurrTtl;
	}
	
	/**
	 * Column Info
	 * @return invExRate
	 */
	public String getInvExRate() {
		return this.invExRate;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return invTpCd
	 */
	public String getInvTpCd() {
		return this.invTpCd;
	}
	
	/**
	 * Column Info
	 * @return appDt
	 */
	public String getAppDt() {
		return this.appDt;
	}
	
	/**
	 * Column Info
	 * @return payDueDt
	 */
	public String getPayDueDt() {
		return this.payDueDt;
	}
	
	/**
	 * Column Info
	 * @return invCurr
	 */
	public String getInvCurr() {
		return this.invCurr;
	}
	
	/**
	 * Column Info
	 * @return invStatus
	 */
	public String getInvStatus() {
		return this.invStatus;
	}
	
	/**
	 * Column Info
	 * @return porTrafficMd
	 */
	public String getPorTrafficMd() {
		return this.porTrafficMd;
	}
	
	/**
	 * Column Info
	 * @return invPaytermClus
	 */
	public String getInvPaytermClus() {
		return this.invPaytermClus;
	}
	

	/**
	 * Column Info
	 * @param podTrafficMd
	 */
	public void setPodTrafficMd(String podTrafficMd) {
		this.podTrafficMd = podTrafficMd;
	}
	
	/**
	 * Column Info
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * Column Info
	 * @param invCurrTtl
	 */
	public void setInvCurrTtl(String invCurrTtl) {
		this.invCurrTtl = invCurrTtl;
	}
	
	/**
	 * Column Info
	 * @param invExRate
	 */
	public void setInvExRate(String invExRate) {
		this.invExRate = invExRate;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param invTpCd
	 */
	public void setInvTpCd(String invTpCd) {
		this.invTpCd = invTpCd;
	}
	
	/**
	 * Column Info
	 * @param appDt
	 */
	public void setAppDt(String appDt) {
		this.appDt = appDt;
	}
	
	/**
	 * Column Info
	 * @param payDueDt
	 */
	public void setPayDueDt(String payDueDt) {
		this.payDueDt = payDueDt;
	}
	
	/**
	 * Column Info
	 * @param invCurr
	 */
	public void setInvCurr(String invCurr) {
		this.invCurr = invCurr;
	}
	
	/**
	 * Column Info
	 * @param invStatus
	 */
	public void setInvStatus(String invStatus) {
		this.invStatus = invStatus;
	}
	
	/**
	 * Column Info
	 * @param porTrafficMd
	 */
	public void setPorTrafficMd(String porTrafficMd) {
		this.porTrafficMd = porTrafficMd;
	}
	
	/**
	 * Column Info
	 * @param invPaytermClus
	 */
	public void setInvPaytermClus(String invPaytermClus) {
		this.invPaytermClus = invPaytermClus;
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
		setPodTrafficMd(JSPUtil.getParameter(request, prefix + "pod_traffic_md", ""));
		setRemark(JSPUtil.getParameter(request, prefix + "remark", ""));
		setInvCurrTtl(JSPUtil.getParameter(request, prefix + "inv_curr_ttl", ""));
		setInvExRate(JSPUtil.getParameter(request, prefix + "inv_ex_rate", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setInvTpCd(JSPUtil.getParameter(request, prefix + "inv_tp_cd", ""));
		setAppDt(JSPUtil.getParameter(request, prefix + "app_dt", ""));
		setPayDueDt(JSPUtil.getParameter(request, prefix + "pay_due_dt", ""));
		setInvCurr(JSPUtil.getParameter(request, prefix + "inv_curr", ""));
		setInvStatus(JSPUtil.getParameter(request, prefix + "inv_status", ""));
		setPorTrafficMd(JSPUtil.getParameter(request, prefix + "por_traffic_md", ""));
		setInvPaytermClus(JSPUtil.getParameter(request, prefix + "inv_payterm_clus", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvoiceBlMainVO[]
	 */
	public InvoiceBlMainVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvoiceBlMainVO[]
	 */
	public InvoiceBlMainVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvoiceBlMainVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] podTrafficMd = (JSPUtil.getParameter(request, prefix	+ "pod_traffic_md", length));
			String[] remark = (JSPUtil.getParameter(request, prefix	+ "remark", length));
			String[] invCurrTtl = (JSPUtil.getParameter(request, prefix	+ "inv_curr_ttl", length));
			String[] invExRate = (JSPUtil.getParameter(request, prefix	+ "inv_ex_rate", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] invTpCd = (JSPUtil.getParameter(request, prefix	+ "inv_tp_cd", length));
			String[] appDt = (JSPUtil.getParameter(request, prefix	+ "app_dt", length));
			String[] payDueDt = (JSPUtil.getParameter(request, prefix	+ "pay_due_dt", length));
			String[] invCurr = (JSPUtil.getParameter(request, prefix	+ "inv_curr", length));
			String[] invStatus = (JSPUtil.getParameter(request, prefix	+ "inv_status", length));
			String[] porTrafficMd = (JSPUtil.getParameter(request, prefix	+ "por_traffic_md", length));
			String[] invPaytermClus = (JSPUtil.getParameter(request, prefix	+ "inv_payterm_clus", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvoiceBlMainVO();
				if (podTrafficMd[i] != null)
					model.setPodTrafficMd(podTrafficMd[i]);
				if (remark[i] != null)
					model.setRemark(remark[i]);
				if (invCurrTtl[i] != null)
					model.setInvCurrTtl(invCurrTtl[i]);
				if (invExRate[i] != null)
					model.setInvExRate(invExRate[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (invTpCd[i] != null)
					model.setInvTpCd(invTpCd[i]);
				if (appDt[i] != null)
					model.setAppDt(appDt[i]);
				if (payDueDt[i] != null)
					model.setPayDueDt(payDueDt[i]);
				if (invCurr[i] != null)
					model.setInvCurr(invCurr[i]);
				if (invStatus[i] != null)
					model.setInvStatus(invStatus[i]);
				if (porTrafficMd[i] != null)
					model.setPorTrafficMd(porTrafficMd[i]);
				if (invPaytermClus[i] != null)
					model.setInvPaytermClus(invPaytermClus[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvoiceBlMainVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvoiceBlMainVO[]
	 */
	public InvoiceBlMainVO[] getInvoiceBlMainVOs(){
		InvoiceBlMainVO[] vos = (InvoiceBlMainVO[])models.toArray(new InvoiceBlMainVO[models.size()]);
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
		this.podTrafficMd = this.podTrafficMd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark = this.remark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrTtl = this.invCurrTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invExRate = this.invExRate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTpCd = this.invTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.appDt = this.appDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payDueDt = this.payDueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurr = this.invCurr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invStatus = this.invStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porTrafficMd = this.porTrafficMd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invPaytermClus = this.invPaytermClus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
