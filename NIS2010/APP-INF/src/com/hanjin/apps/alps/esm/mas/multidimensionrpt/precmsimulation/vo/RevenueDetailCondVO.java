/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RevenueDetailCondVO.java
*@FileTitle : RevenueDetailCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.27  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.multidimensionrpt.precmsimulation.vo;

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

public class RevenueDetailCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RevenueDetailCondVO> models = new ArrayList<RevenueDetailCondVO>();
	
	/* Column Info */
	private String prcCgoTpCd = null;
	/* Column Info */
	private String prcDeTermCd = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String porDefCd = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polDefCd = null;
	/* Column Info */
	private String prcRcvTermCd = null;
	/* Column Info */
	private String delDefCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String podDefCd = null;
	/* Column Info */
	private String cntrQty = null;
	/* Column Info */
	private String expDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RevenueDetailCondVO() {}

	public RevenueDetailCondVO(String ibflag, String pagerows, String porDefCd, String polDefCd, String podDefCd, String delDefCd, String svcScpCd, String effDt, String expDt, String ratUtCd, String prcRcvTermCd, String prcDeTermCd, String prcCgoTpCd, String cntrQty) {
		this.prcCgoTpCd = prcCgoTpCd;
		this.prcDeTermCd = prcDeTermCd;
		this.svcScpCd = svcScpCd;
		this.porDefCd = porDefCd;
		this.ratUtCd = ratUtCd;
		this.pagerows = pagerows;
		this.polDefCd = polDefCd;
		this.prcRcvTermCd = prcRcvTermCd;
		this.delDefCd = delDefCd;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.podDefCd = podDefCd;
		this.cntrQty = cntrQty;
		this.expDt = expDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("prc_cgo_tp_cd", getPrcCgoTpCd());
		this.hashColumns.put("prc_de_term_cd", getPrcDeTermCd());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("por_def_cd", getPorDefCd());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_def_cd", getPolDefCd());
		this.hashColumns.put("prc_rcv_term_cd", getPrcRcvTermCd());
		this.hashColumns.put("del_def_cd", getDelDefCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("pod_def_cd", getPodDefCd());
		this.hashColumns.put("cntr_qty", getCntrQty());
		this.hashColumns.put("exp_dt", getExpDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("prc_cgo_tp_cd", "prcCgoTpCd");
		this.hashFields.put("prc_de_term_cd", "prcDeTermCd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("por_def_cd", "porDefCd");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_def_cd", "polDefCd");
		this.hashFields.put("prc_rcv_term_cd", "prcRcvTermCd");
		this.hashFields.put("del_def_cd", "delDefCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("pod_def_cd", "podDefCd");
		this.hashFields.put("cntr_qty", "cntrQty");
		this.hashFields.put("exp_dt", "expDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return prcCgoTpCd
	 */
	public String getPrcCgoTpCd() {
		return this.prcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return prcDeTermCd
	 */
	public String getPrcDeTermCd() {
		return this.prcDeTermCd;
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
	 * @return porDefCd
	 */
	public String getPorDefCd() {
		return this.porDefCd;
	}
	
	/**
	 * Column Info
	 * @return ratUtCd
	 */
	public String getRatUtCd() {
		return this.ratUtCd;
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
	 * @return prcRcvTermCd
	 */
	public String getPrcRcvTermCd() {
		return this.prcRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return delDefCd
	 */
	public String getDelDefCd() {
		return this.delDefCd;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return cntrQty
	 */
	public String getCntrQty() {
		return this.cntrQty;
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
	 * @param prcCgoTpCd
	 */
	public void setPrcCgoTpCd(String prcCgoTpCd) {
		this.prcCgoTpCd = prcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param prcDeTermCd
	 */
	public void setPrcDeTermCd(String prcDeTermCd) {
		this.prcDeTermCd = prcDeTermCd;
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
	 * @param porDefCd
	 */
	public void setPorDefCd(String porDefCd) {
		this.porDefCd = porDefCd;
	}
	
	/**
	 * Column Info
	 * @param ratUtCd
	 */
	public void setRatUtCd(String ratUtCd) {
		this.ratUtCd = ratUtCd;
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
	 * @param prcRcvTermCd
	 */
	public void setPrcRcvTermCd(String prcRcvTermCd) {
		this.prcRcvTermCd = prcRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param delDefCd
	 */
	public void setDelDefCd(String delDefCd) {
		this.delDefCd = delDefCd;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param cntrQty
	 */
	public void setCntrQty(String cntrQty) {
		this.cntrQty = cntrQty;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
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
		setPrcCgoTpCd(JSPUtil.getParameter(request, prefix + "prc_cgo_tp_cd", ""));
		setPrcDeTermCd(JSPUtil.getParameter(request, prefix + "prc_de_term_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setPorDefCd(JSPUtil.getParameter(request, prefix + "por_def_cd", ""));
		setRatUtCd(JSPUtil.getParameter(request, prefix + "rat_ut_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolDefCd(JSPUtil.getParameter(request, prefix + "pol_def_cd", ""));
		setPrcRcvTermCd(JSPUtil.getParameter(request, prefix + "prc_rcv_term_cd", ""));
		setDelDefCd(JSPUtil.getParameter(request, prefix + "del_def_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setPodDefCd(JSPUtil.getParameter(request, prefix + "pod_def_cd", ""));
		setCntrQty(JSPUtil.getParameter(request, prefix + "cntr_qty", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RevenueDetailCondVO[]
	 */
	public RevenueDetailCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RevenueDetailCondVO[]
	 */
	public RevenueDetailCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RevenueDetailCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] prcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_cgo_tp_cd", length));
			String[] prcDeTermCd = (JSPUtil.getParameter(request, prefix	+ "prc_de_term_cd", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] porDefCd = (JSPUtil.getParameter(request, prefix	+ "por_def_cd", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polDefCd = (JSPUtil.getParameter(request, prefix	+ "pol_def_cd", length));
			String[] prcRcvTermCd = (JSPUtil.getParameter(request, prefix	+ "prc_rcv_term_cd", length));
			String[] delDefCd = (JSPUtil.getParameter(request, prefix	+ "del_def_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] podDefCd = (JSPUtil.getParameter(request, prefix	+ "pod_def_cd", length));
			String[] cntrQty = (JSPUtil.getParameter(request, prefix	+ "cntr_qty", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new RevenueDetailCondVO();
				if (prcCgoTpCd[i] != null)
					model.setPrcCgoTpCd(prcCgoTpCd[i]);
				if (prcDeTermCd[i] != null)
					model.setPrcDeTermCd(prcDeTermCd[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (porDefCd[i] != null)
					model.setPorDefCd(porDefCd[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polDefCd[i] != null)
					model.setPolDefCd(polDefCd[i]);
				if (prcRcvTermCd[i] != null)
					model.setPrcRcvTermCd(prcRcvTermCd[i]);
				if (delDefCd[i] != null)
					model.setDelDefCd(delDefCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (podDefCd[i] != null)
					model.setPodDefCd(podDefCd[i]);
				if (cntrQty[i] != null)
					model.setCntrQty(cntrQty[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRevenueDetailCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RevenueDetailCondVO[]
	 */
	public RevenueDetailCondVO[] getRevenueDetailCondVOs(){
		RevenueDetailCondVO[] vos = (RevenueDetailCondVO[])models.toArray(new RevenueDetailCondVO[models.size()]);
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
		this.prcCgoTpCd = this.prcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcDeTermCd = this.prcDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porDefCd = this.porDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polDefCd = this.polDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcRcvTermCd = this.prcRcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delDefCd = this.delDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podDefCd = this.podDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrQty = this.cntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
