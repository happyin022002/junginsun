/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DemDetCostRepbyBKGVO.java
*@FileTitle : DemDetCostRepbyBKGVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 유제량
*@LastVersion : 1.0
* 2015.02.09 유제량 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo;

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
 * @author 유제량
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class DemDetCostRepbyBKGVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DemDetCostRepbyBKGVO> models = new ArrayList<DemDetCostRepbyBKGVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String sccCdOrg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String costYrmonOrg = null;
	/* Column Info */
	private String poolCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bzcRt = null;
	/* Column Info */
	private String fSccno = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String sccCd = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String taxPct = null;
	/* Column Info */
	private String fPoolno = null;
	/* Column Info */
	private String fYearmonth = null;
	/* Column Info */
	private String poolCdOrg = null;
	/* Column Info */
	private String rtAmt = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public DemDetCostRepbyBKGVO() {}

	public DemDetCostRepbyBKGVO(String ibflag, String pagerows, String poolCd, String sccCd, String bzcRt, String taxPct, String rtAmt, String costYrmon, String creUsrId, String creDt, String updUsrId, String updDt, String fYearmonth, String fPoolno, String fSccno, String poolCdOrg, String sccCdOrg, String costYrmonOrg) {
		this.updDt = updDt;
		this.sccCdOrg = sccCdOrg;
		this.creDt = creDt;
		this.costYrmonOrg = costYrmonOrg;
		this.poolCd = poolCd;
		this.pagerows = pagerows;
		this.bzcRt = bzcRt;
		this.fSccno = fSccno;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.sccCd = sccCd;
		this.costYrmon = costYrmon;
		this.taxPct = taxPct;
		this.fPoolno = fPoolno;
		this.fYearmonth = fYearmonth;
		this.poolCdOrg = poolCdOrg;
		this.rtAmt = rtAmt;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("scc_cd_org", getSccCdOrg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cost_yrmon_org", getCostYrmonOrg());
		this.hashColumns.put("pool_cd", getPoolCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bzc_rt", getBzcRt());
		this.hashColumns.put("f_sccno", getFSccno());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("scc_cd", getSccCd());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("tax_pct", getTaxPct());
		this.hashColumns.put("f_poolno", getFPoolno());
		this.hashColumns.put("f_yearmonth", getFYearmonth());
		this.hashColumns.put("pool_cd_org", getPoolCdOrg());
		this.hashColumns.put("rt_amt", getRtAmt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("scc_cd_org", "sccCdOrg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cost_yrmon_org", "costYrmonOrg");
		this.hashFields.put("pool_cd", "poolCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bzc_rt", "bzcRt");
		this.hashFields.put("f_sccno", "fSccno");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("scc_cd", "sccCd");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("tax_pct", "taxPct");
		this.hashFields.put("f_poolno", "fPoolno");
		this.hashFields.put("f_yearmonth", "fYearmonth");
		this.hashFields.put("pool_cd_org", "poolCdOrg");
		this.hashFields.put("rt_amt", "rtAmt");
		this.hashFields.put("upd_usr_id", "updUsrId");
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
	 * @return sccCdOrg
	 */
	public String getSccCdOrg() {
		return this.sccCdOrg;
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
	 * @return costYrmonOrg
	 */
	public String getCostYrmonOrg() {
		return this.costYrmonOrg;
	}
	
	/**
	 * Column Info
	 * @return poolCd
	 */
	public String getPoolCd() {
		return this.poolCd;
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
	 * @return bzcRt
	 */
	public String getBzcRt() {
		return this.bzcRt;
	}
	
	/**
	 * Column Info
	 * @return fSccno
	 */
	public String getFSccno() {
		return this.fSccno;
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
	 * @return sccCd
	 */
	public String getSccCd() {
		return this.sccCd;
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
	 * @return taxPct
	 */
	public String getTaxPct() {
		return this.taxPct;
	}
	
	/**
	 * Column Info
	 * @return fPoolno
	 */
	public String getFPoolno() {
		return this.fPoolno;
	}
	
	/**
	 * Column Info
	 * @return fYearmonth
	 */
	public String getFYearmonth() {
		return this.fYearmonth;
	}
	
	/**
	 * Column Info
	 * @return poolCdOrg
	 */
	public String getPoolCdOrg() {
		return this.poolCdOrg;
	}
	
	/**
	 * Column Info
	 * @return rtAmt
	 */
	public String getRtAmt() {
		return this.rtAmt;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param sccCdOrg
	 */
	public void setSccCdOrg(String sccCdOrg) {
		this.sccCdOrg = sccCdOrg;
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
	 * @param costYrmonOrg
	 */
	public void setCostYrmonOrg(String costYrmonOrg) {
		this.costYrmonOrg = costYrmonOrg;
	}
	
	/**
	 * Column Info
	 * @param poolCd
	 */
	public void setPoolCd(String poolCd) {
		this.poolCd = poolCd;
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
	 * @param bzcRt
	 */
	public void setBzcRt(String bzcRt) {
		this.bzcRt = bzcRt;
	}
	
	/**
	 * Column Info
	 * @param fSccno
	 */
	public void setFSccno(String fSccno) {
		this.fSccno = fSccno;
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
	 * @param sccCd
	 */
	public void setSccCd(String sccCd) {
		this.sccCd = sccCd;
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
	 * @param taxPct
	 */
	public void setTaxPct(String taxPct) {
		this.taxPct = taxPct;
	}
	
	/**
	 * Column Info
	 * @param fPoolno
	 */
	public void setFPoolno(String fPoolno) {
		this.fPoolno = fPoolno;
	}
	
	/**
	 * Column Info
	 * @param fYearmonth
	 */
	public void setFYearmonth(String fYearmonth) {
		this.fYearmonth = fYearmonth;
	}
	
	/**
	 * Column Info
	 * @param poolCdOrg
	 */
	public void setPoolCdOrg(String poolCdOrg) {
		this.poolCdOrg = poolCdOrg;
	}
	
	/**
	 * Column Info
	 * @param rtAmt
	 */
	public void setRtAmt(String rtAmt) {
		this.rtAmt = rtAmt;
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
		setSccCdOrg(JSPUtil.getParameter(request, prefix + "scc_cd_org", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCostYrmonOrg(JSPUtil.getParameter(request, prefix + "cost_yrmon_org", ""));
		setPoolCd(JSPUtil.getParameter(request, prefix + "pool_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBzcRt(JSPUtil.getParameter(request, prefix + "bzc_rt", ""));
		setFSccno(JSPUtil.getParameter(request, prefix + "f_sccno", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setSccCd(JSPUtil.getParameter(request, prefix + "scc_cd", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setTaxPct(JSPUtil.getParameter(request, prefix + "tax_pct", ""));
		setFPoolno(JSPUtil.getParameter(request, prefix + "f_poolno", ""));
		setFYearmonth(JSPUtil.getParameter(request, prefix + "f_yearmonth", ""));
		setPoolCdOrg(JSPUtil.getParameter(request, prefix + "pool_cd_org", ""));
		setRtAmt(JSPUtil.getParameter(request, prefix + "rt_amt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DemDetCostRepbyBKGVO[]
	 */
	public DemDetCostRepbyBKGVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DemDetCostRepbyBKGVO[]
	 */
	public DemDetCostRepbyBKGVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DemDetCostRepbyBKGVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] sccCdOrg = (JSPUtil.getParameter(request, prefix	+ "scc_cd_org", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] costYrmonOrg = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon_org", length));
			String[] poolCd = (JSPUtil.getParameter(request, prefix	+ "pool_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bzcRt = (JSPUtil.getParameter(request, prefix	+ "bzc_rt", length));
			String[] fSccno = (JSPUtil.getParameter(request, prefix	+ "f_sccno", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] sccCd = (JSPUtil.getParameter(request, prefix	+ "scc_cd", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] taxPct = (JSPUtil.getParameter(request, prefix	+ "tax_pct", length));
			String[] fPoolno = (JSPUtil.getParameter(request, prefix	+ "f_poolno", length));
			String[] fYearmonth = (JSPUtil.getParameter(request, prefix	+ "f_yearmonth", length));
			String[] poolCdOrg = (JSPUtil.getParameter(request, prefix	+ "pool_cd_org", length));
			String[] rtAmt = (JSPUtil.getParameter(request, prefix	+ "rt_amt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new DemDetCostRepbyBKGVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (sccCdOrg[i] != null)
					model.setSccCdOrg(sccCdOrg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (costYrmonOrg[i] != null)
					model.setCostYrmonOrg(costYrmonOrg[i]);
				if (poolCd[i] != null)
					model.setPoolCd(poolCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bzcRt[i] != null)
					model.setBzcRt(bzcRt[i]);
				if (fSccno[i] != null)
					model.setFSccno(fSccno[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (sccCd[i] != null)
					model.setSccCd(sccCd[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (taxPct[i] != null)
					model.setTaxPct(taxPct[i]);
				if (fPoolno[i] != null)
					model.setFPoolno(fPoolno[i]);
				if (fYearmonth[i] != null)
					model.setFYearmonth(fYearmonth[i]);
				if (poolCdOrg[i] != null)
					model.setPoolCdOrg(poolCdOrg[i]);
				if (rtAmt[i] != null)
					model.setRtAmt(rtAmt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDemDetCostRepbyBKGVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DemDetCostRepbyBKGVO[]
	 */
	public DemDetCostRepbyBKGVO[] getDemDetCostRepbyBKGVOs(){
		DemDetCostRepbyBKGVO[] vos = (DemDetCostRepbyBKGVO[])models.toArray(new DemDetCostRepbyBKGVO[models.size()]);
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
		this.sccCdOrg = this.sccCdOrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmonOrg = this.costYrmonOrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poolCd = this.poolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcRt = this.bzcRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSccno = this.fSccno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd = this.sccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxPct = this.taxPct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fPoolno = this.fPoolno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fYearmonth = this.fYearmonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poolCdOrg = this.poolCdOrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAmt = this.rtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
