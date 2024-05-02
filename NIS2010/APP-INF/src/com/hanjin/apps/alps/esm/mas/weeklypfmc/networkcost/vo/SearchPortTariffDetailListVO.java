/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SearchPortTariffDetailListVO.java
*@FileTitle : SearchPortTariffDetailListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.08
*@LastModifier : 
*@LastVersion : 1.0
* 2011.07.08  
* 1.0 Creation
* 2011.07.07 이석준 [CHM-201111498-01] PSO와 연계하여 VVD,TERMINAL별로 TARIFF 직접 수정및 PSO I/F 추가
=========================================================*/

package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo;

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

public class SearchPortTariffDetailListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchPortTariffDetailListVO> models = new ArrayList<SearchPortTariffDetailListVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String cnlUsdAmt = null;
	/* Column Info */
	private String portUsdAmt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String cnlPsoAmt = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String cyCd = null;
	/* Column Info */
	private String portPsoAmt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String portRatio = null;
	/* Column Info */
	private String cnlRatio = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchPortTariffDetailListVO() {}

	public SearchPortTariffDetailListVO(String ibflag, String pagerows, String costYrmon, String slanCd, String vslCd, String skdVoyNo, String skdDirCd, String portCd, String cyCd, String currCd, String portUsdAmt, String portPsoAmt, String cnlUsdAmt, String cnlPsoAmt, String creUsrId, String updUsrId, String creDt, String updDt, String portRatio, String cnlRatio) {
		this.updDt = updDt;
		this.vslCd = vslCd;
		this.currCd = currCd;
		this.creDt = creDt;
		this.skdVoyNo = skdVoyNo;
		this.cnlUsdAmt = cnlUsdAmt;
		this.portUsdAmt = portUsdAmt;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.costYrmon = costYrmon;
		this.slanCd = slanCd;
		this.cnlPsoAmt = cnlPsoAmt;
		this.portCd = portCd;
		this.cyCd = cyCd;
		this.portPsoAmt = portPsoAmt;
		this.updUsrId = updUsrId;
		this.portRatio = portRatio;
		this.cnlRatio = cnlRatio;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("cnl_usd_amt", getCnlUsdAmt());
		this.hashColumns.put("port_usd_amt", getPortUsdAmt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("cnl_pso_amt", getCnlPsoAmt());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("cy_cd", getCyCd());
		this.hashColumns.put("port_pso_amt", getPortPsoAmt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("port_ratio", getPortRatio());
		this.hashColumns.put("cnl_ratio", getCnlRatio());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("cnl_usd_amt", "cnlUsdAmt");
		this.hashFields.put("port_usd_amt", "portUsdAmt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("cnl_pso_amt", "cnlPsoAmt");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("cy_cd", "cyCd");
		this.hashFields.put("port_pso_amt", "portPsoAmt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("port_ratio", "portRatio");
		this.hashFields.put("cnl_ratio", "cnlRatio");
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
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
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
	 * @return cnlUsdAmt
	 */
	public String getCnlUsdAmt() {
		return this.cnlUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return portUsdAmt
	 */
	public String getPortUsdAmt() {
		return this.portUsdAmt;
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
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
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
	 * @return cnlPsoAmt
	 */
	public String getCnlPsoAmt() {
		return this.cnlPsoAmt;
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
	 * @return cyCd
	 */
	public String getCyCd() {
		return this.cyCd;
	}
	
	/**
	 * Column Info
	 * @return portPsoAmt
	 */
	public String getPortPsoAmt() {
		return this.portPsoAmt;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	

	/**
	 * @return the portRatio
	 */
	public String getPortRatio() {
		return portRatio;
	}

	/**
	 * @param portRatio the portRatio to set
	 */
	public void setPortRatio(String portRatio) {
		this.portRatio = portRatio;
	}

	/**
	 * @return the cnlRatio
	 */
	public String getCnlRatio() {
		return cnlRatio;
	}

	/**
	 * @param cnlRatio the cnlRatio to set
	 */
	public void setCnlRatio(String cnlRatio) {
		this.cnlRatio = cnlRatio;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
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
	 * @param cnlUsdAmt
	 */
	public void setCnlUsdAmt(String cnlUsdAmt) {
		this.cnlUsdAmt = cnlUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param portUsdAmt
	 */
	public void setPortUsdAmt(String portUsdAmt) {
		this.portUsdAmt = portUsdAmt;
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
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
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
	 * @param cnlPsoAmt
	 */
	public void setCnlPsoAmt(String cnlPsoAmt) {
		this.cnlPsoAmt = cnlPsoAmt;
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
	 * @param cyCd
	 */
	public void setCyCd(String cyCd) {
		this.cyCd = cyCd;
	}
	
	/**
	 * Column Info
	 * @param portPsoAmt
	 */
	public void setPortPsoAmt(String portPsoAmt) {
		this.portPsoAmt = portPsoAmt;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setCnlUsdAmt(JSPUtil.getParameter(request, prefix + "cnl_usd_amt", ""));
		setPortUsdAmt(JSPUtil.getParameter(request, prefix + "port_usd_amt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setCnlPsoAmt(JSPUtil.getParameter(request, prefix + "cnl_pso_amt", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setCyCd(JSPUtil.getParameter(request, prefix + "cy_cd", ""));
		setPortPsoAmt(JSPUtil.getParameter(request, prefix + "port_pso_amt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setPortRatio(JSPUtil.getParameter(request, prefix + "port_ratio", ""));
		setCnlRatio(JSPUtil.getParameter(request, prefix + "cnl_ratio", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchPortTariffDetailListVO[]
	 */
	public SearchPortTariffDetailListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchPortTariffDetailListVO[]
	 */
	public SearchPortTariffDetailListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchPortTariffDetailListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] cnlUsdAmt = (JSPUtil.getParameter(request, prefix	+ "cnl_usd_amt", length));
			String[] portUsdAmt = (JSPUtil.getParameter(request, prefix	+ "port_usd_amt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] cnlPsoAmt = (JSPUtil.getParameter(request, prefix	+ "cnl_pso_amt", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] cyCd = (JSPUtil.getParameter(request, prefix	+ "cy_cd", length));
			String[] portPsoAmt = (JSPUtil.getParameter(request, prefix	+ "port_pso_amt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] portRatio = (JSPUtil.getParameter(request, prefix	+ "port_ratio", length));
			String[] cnlRatio = (JSPUtil.getParameter(request, prefix	+ "cnl_ratio", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchPortTariffDetailListVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (cnlUsdAmt[i] != null)
					model.setCnlUsdAmt(cnlUsdAmt[i]);
				if (portUsdAmt[i] != null)
					model.setPortUsdAmt(portUsdAmt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (cnlPsoAmt[i] != null)
					model.setCnlPsoAmt(cnlPsoAmt[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (cyCd[i] != null)
					model.setCyCd(cyCd[i]);
				if (portPsoAmt[i] != null)
					model.setPortPsoAmt(portPsoAmt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (portRatio[i] != null)
					model.setPortRatio(portRatio[i]);
				if (cnlRatio[i] != null)
					model.setCnlRatio(cnlRatio[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchPortTariffDetailListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchPortTariffDetailListVO[]
	 */
	public SearchPortTariffDetailListVO[] getSearchPortTariffDetailListVOs(){
		SearchPortTariffDetailListVO[] vos = (SearchPortTariffDetailListVO[])models.toArray(new SearchPortTariffDetailListVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnlUsdAmt = this.cnlUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portUsdAmt = this.portUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnlPsoAmt = this.cnlPsoAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cyCd = this.cyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portPsoAmt = this.portPsoAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portRatio = this.portRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnlRatio = this.cnlRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
