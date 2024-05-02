/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SearchMTCost3ListVO.java
*@FileTitle : SearchMTCost3ListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.12
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2011.07.12 최성민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.stdunitcost.mtcost.vo;

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
 * @author 최성민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchMTCost3ListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMTCost3ListVO> models = new ArrayList<SearchMTCost3ListVO>();
	
	/* Column Info */
	private String fOriDest = null;
	/* Column Info */
	private String fCostYrmon = null;
	/* Column Info */
	private String toEcc = null;
	/* Column Info */
	private String fEccCd2 = null;
	/* Column Info */
	private String mvmtDays = null;
	/* Column Info */
	private String contiSteve = null;
	/* Column Info */
	private String mvmtTrans = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String contiDays = null;
	/* Column Info */
	private String fromEcc = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vol = null;
	/* Column Info */
	private String mvmtSteve = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String contiTrans = null;
	/* Column Info */
	private String fCntrTpszCd2 = null;
	/* Column Info */
	private String contiSteveUc = null;
	/* Column Info */
	private String contiTransUc = null;
	/* Column Info */
	private String contiTtlUc = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchMTCost3ListVO() {}

	public SearchMTCost3ListVO(String ibflag, String pagerows, String costYrmon, String fromEcc, String toEcc, String cntrTpszCd, String vol, String contiSteve, String contiTrans, String contiDays, String mvmtSteve, String mvmtTrans, String mvmtDays, String fCntrTpszCd2, String fCostYrmon, String fEccCd2, String fOriDest, String contiSteveUc, String contiTransUc, String contiTtlUc) {
		this.fOriDest = fOriDest;
		this.fCostYrmon = fCostYrmon;
		this.toEcc = toEcc;
		this.fEccCd2 = fEccCd2;
		this.mvmtDays = mvmtDays;
		this.contiSteve = contiSteve;
		this.mvmtTrans = mvmtTrans;
		this.pagerows = pagerows;
		this.contiDays = contiDays;
		this.fromEcc = fromEcc;
		this.ibflag = ibflag;
		this.vol = vol;
		this.mvmtSteve = mvmtSteve;
		this.costYrmon = costYrmon;
		this.cntrTpszCd = cntrTpszCd;
		this.contiTrans = contiTrans;
		this.fCntrTpszCd2 = fCntrTpszCd2;
		this.contiSteveUc = contiSteveUc;
		this.contiTransUc = contiTransUc;
		this.contiTtlUc = contiTtlUc;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("f_ori_dest", getFOriDest());
		this.hashColumns.put("f_cost_yrmon", getFCostYrmon());
		this.hashColumns.put("to_ecc", getToEcc());
		this.hashColumns.put("f_ecc_cd2", getFEccCd2());
		this.hashColumns.put("mvmt_days", getMvmtDays());
		this.hashColumns.put("conti_steve", getContiSteve());
		this.hashColumns.put("mvmt_trans", getMvmtTrans());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("conti_days", getContiDays());
		this.hashColumns.put("from_ecc", getFromEcc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vol", getVol());
		this.hashColumns.put("mvmt_steve", getMvmtSteve());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("conti_trans", getContiTrans());
		this.hashColumns.put("f_cntr_tpsz_cd2", getFCntrTpszCd2());
		this.hashColumns.put("conti_steve_uc", getContiSteveUc());
		this.hashColumns.put("conti_trans_uc", getContiTransUc());;
		this.hashColumns.put("conti_ttl_uc", getContiTtlUc());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("f_ori_dest", "fOriDest");
		this.hashFields.put("f_cost_yrmon", "fCostYrmon");
		this.hashFields.put("to_ecc", "toEcc");
		this.hashFields.put("f_ecc_cd2", "fEccCd2");
		this.hashFields.put("mvmt_days", "mvmtDays");
		this.hashFields.put("conti_steve", "contiSteve");
		this.hashFields.put("mvmt_trans", "mvmtTrans");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("conti_days", "contiDays");
		this.hashFields.put("from_ecc", "fromEcc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vol", "vol");
		this.hashFields.put("mvmt_steve", "mvmtSteve");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("conti_trans", "contiTrans");
		this.hashFields.put("f_cntr_tpsz_cd2", "fCntrTpszCd2");
		this.hashFields.put("conti_steve_uc", "contiSteveUc");
		this.hashFields.put("conti_trans_uc", "contiTransUc");
		this.hashFields.put("conti_ttl_uc", "contiTtlUc");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fOriDest
	 */
	public String getFOriDest() {
		return this.fOriDest;
	}
	
	/**
	 * Column Info
	 * @return fCostYrmon
	 */
	public String getFCostYrmon() {
		return this.fCostYrmon;
	}
	
	/**
	 * Column Info
	 * @return toEcc
	 */
	public String getToEcc() {
		return this.toEcc;
	}
	
	/**
	 * Column Info
	 * @return fEccCd2
	 */
	public String getFEccCd2() {
		return this.fEccCd2;
	}
	
	/**
	 * Column Info
	 * @return mvmtDays
	 */
	public String getMvmtDays() {
		return this.mvmtDays;
	}
	
	/**
	 * Column Info
	 * @return contiSteve
	 */
	public String getContiSteve() {
		return this.contiSteve;
	}
	
	/**
	 * Column Info
	 * @return mvmtTrans
	 */
	public String getMvmtTrans() {
		return this.mvmtTrans;
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
	 * @return contiDays
	 */
	public String getContiDays() {
		return this.contiDays;
	}
	
	/**
	 * Column Info
	 * @return fromEcc
	 */
	public String getFromEcc() {
		return this.fromEcc;
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
	 * @return vol
	 */
	public String getVol() {
		return this.vol;
	}
	
	/**
	 * Column Info
	 * @return mvmtSteve
	 */
	public String getMvmtSteve() {
		return this.mvmtSteve;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return contiTrans
	 */
	public String getContiTrans() {
		return this.contiTrans;
	}
	
	/**
	 * Column Info
	 * @return fCntrTpszCd2
	 */
	public String getFCntrTpszCd2() {
		return this.fCntrTpszCd2;
	}
	
	/**
	 * Column Info
	 * @return contiSteveUc
	 */
	public String getContiSteveUc() {
		return this.contiSteveUc;
	}
	
	/**
	 * Column Info
	 * @return contiTransUc
	 */
	public String getContiTransUc() {
		return this.contiTransUc;
	}
	
	/**
	 * Column Info
	 * @return contiTtlUc
	 */
	public String getContiTtlUc() {
		return this.contiTtlUc;
	}
	

	/**
	 * Column Info
	 * @param fOriDest
	 */
	public void setFOriDest(String fOriDest) {
		this.fOriDest = fOriDest;
	}
	
	/**
	 * Column Info
	 * @param fCostYrmon
	 */
	public void setFCostYrmon(String fCostYrmon) {
		this.fCostYrmon = fCostYrmon;
	}
	
	/**
	 * Column Info
	 * @param toEcc
	 */
	public void setToEcc(String toEcc) {
		this.toEcc = toEcc;
	}
	
	/**
	 * Column Info
	 * @param fEccCd2
	 */
	public void setFEccCd2(String fEccCd2) {
		this.fEccCd2 = fEccCd2;
	}
	
	/**
	 * Column Info
	 * @param mvmtDays
	 */
	public void setMvmtDays(String mvmtDays) {
		this.mvmtDays = mvmtDays;
	}
	
	/**
	 * Column Info
	 * @param contiSteve
	 */
	public void setContiSteve(String contiSteve) {
		this.contiSteve = contiSteve;
	}
	
	/**
	 * Column Info
	 * @param mvmtTrans
	 */
	public void setMvmtTrans(String mvmtTrans) {
		this.mvmtTrans = mvmtTrans;
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
	 * @param contiDays
	 */
	public void setContiDays(String contiDays) {
		this.contiDays = contiDays;
	}
	
	/**
	 * Column Info
	 * @param fromEcc
	 */
	public void setFromEcc(String fromEcc) {
		this.fromEcc = fromEcc;
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
	 * @param vol
	 */
	public void setVol(String vol) {
		this.vol = vol;
	}
	
	/**
	 * Column Info
	 * @param mvmtSteve
	 */
	public void setMvmtSteve(String mvmtSteve) {
		this.mvmtSteve = mvmtSteve;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param contiTrans
	 */
	public void setContiTrans(String contiTrans) {
		this.contiTrans = contiTrans;
	}
	
	/**
	 * Column Info
	 * @param fCntrTpszCd2
	 */
	public void setFCntrTpszCd2(String fCntrTpszCd2) {
		this.fCntrTpszCd2 = fCntrTpszCd2;
	}
	
	/**
	 * Column Info
	 * @param contiSteveUc
	 */
	public void setContiSteveUc(String contiSteveUc) {
		this.contiSteveUc = contiSteveUc;
	}
	
	/**
	 * Column Info
	 * @param contiTransUc
	 */
	public void setContiTransUc(String contiTransUc) {
		this.contiTransUc = contiTransUc;
	}
	
	/**
	 * Column Info
	 * @param contiTtlUc
	 */
	public void setContiTtlUc(String contiTtlUc) {
		this.contiTtlUc = contiTtlUc;
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
		setFOriDest(JSPUtil.getParameter(request, prefix + "f_ori_dest", ""));
		setFCostYrmon(JSPUtil.getParameter(request, prefix + "f_cost_yrmon", ""));
		setToEcc(JSPUtil.getParameter(request, prefix + "to_ecc", ""));
		setFEccCd2(JSPUtil.getParameter(request, prefix + "f_ecc_cd2", ""));
		setMvmtDays(JSPUtil.getParameter(request, prefix + "mvmt_days", ""));
		setContiSteve(JSPUtil.getParameter(request, prefix + "conti_steve", ""));
		setMvmtTrans(JSPUtil.getParameter(request, prefix + "mvmt_trans", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setContiDays(JSPUtil.getParameter(request, prefix + "conti_days", ""));
		setFromEcc(JSPUtil.getParameter(request, prefix + "from_ecc", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVol(JSPUtil.getParameter(request, prefix + "vol", ""));
		setMvmtSteve(JSPUtil.getParameter(request, prefix + "mvmt_steve", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setContiTrans(JSPUtil.getParameter(request, prefix + "conti_trans", ""));
		setFCntrTpszCd2(JSPUtil.getParameter(request, prefix + "f_cntr_tpsz_cd2", ""));
		setContiSteveUc(JSPUtil.getParameter(request, prefix + "conti_steve_uc", ""));
		setContiTransUc(JSPUtil.getParameter(request, prefix + "conti_trans_uc", ""));
		setContiTtlUc(JSPUtil.getParameter(request, prefix + "conti_ttl_uc", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMTCost3ListVO[]
	 */
	public SearchMTCost3ListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMTCost3ListVO[]
	 */
	public SearchMTCost3ListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMTCost3ListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fOriDest = (JSPUtil.getParameter(request, prefix	+ "f_ori_dest", length));
			String[] fCostYrmon = (JSPUtil.getParameter(request, prefix	+ "f_cost_yrmon", length));
			String[] toEcc = (JSPUtil.getParameter(request, prefix	+ "to_ecc", length));
			String[] fEccCd2 = (JSPUtil.getParameter(request, prefix	+ "f_ecc_cd2", length));
			String[] mvmtDays = (JSPUtil.getParameter(request, prefix	+ "mvmt_days", length));
			String[] contiSteve = (JSPUtil.getParameter(request, prefix	+ "conti_steve", length));
			String[] mvmtTrans = (JSPUtil.getParameter(request, prefix	+ "mvmt_trans", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] contiDays = (JSPUtil.getParameter(request, prefix	+ "conti_days", length));
			String[] fromEcc = (JSPUtil.getParameter(request, prefix	+ "from_ecc", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vol = (JSPUtil.getParameter(request, prefix	+ "vol", length));
			String[] mvmtSteve = (JSPUtil.getParameter(request, prefix	+ "mvmt_steve", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] contiTrans = (JSPUtil.getParameter(request, prefix	+ "conti_trans", length));
			String[] fCntrTpszCd2 = (JSPUtil.getParameter(request, prefix	+ "f_cntr_tpsz_cd2", length));
			String[] contiSteveUc = (JSPUtil.getParameter(request, prefix	+ "conti_steve_uc", length));
			String[] contiTransUc = (JSPUtil.getParameter(request, prefix	+ "conti_trans_uc", length));
			String[] contiTtlUc = (JSPUtil.getParameter(request, prefix	+ "conti_ttl_uc", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMTCost3ListVO();
				if (fOriDest[i] != null)
					model.setFOriDest(fOriDest[i]);
				if (fCostYrmon[i] != null)
					model.setFCostYrmon(fCostYrmon[i]);
				if (toEcc[i] != null)
					model.setToEcc(toEcc[i]);
				if (fEccCd2[i] != null)
					model.setFEccCd2(fEccCd2[i]);
				if (mvmtDays[i] != null)
					model.setMvmtDays(mvmtDays[i]);
				if (contiSteve[i] != null)
					model.setContiSteve(contiSteve[i]);
				if (mvmtTrans[i] != null)
					model.setMvmtTrans(mvmtTrans[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (contiDays[i] != null)
					model.setContiDays(contiDays[i]);
				if (fromEcc[i] != null)
					model.setFromEcc(fromEcc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vol[i] != null)
					model.setVol(vol[i]);
				if (mvmtSteve[i] != null)
					model.setMvmtSteve(mvmtSteve[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (contiTrans[i] != null)
					model.setContiTrans(contiTrans[i]);
				if (fCntrTpszCd2[i] != null)
					model.setFCntrTpszCd2(fCntrTpszCd2[i]);
				if (contiSteveUc[i] != null)
					model.setContiSteveUc(contiSteveUc[i]);
				if (contiTransUc[i] != null)
					model.setContiTransUc(contiTransUc[i]);
				if (contiTtlUc[i] != null)
					model.setContiTtlUc(contiTtlUc[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMTCost3ListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMTCost3ListVO[]
	 */
	public SearchMTCost3ListVO[] getSearchMTCost3ListVOs(){
		SearchMTCost3ListVO[] vos = (SearchMTCost3ListVO[])models.toArray(new SearchMTCost3ListVO[models.size()]);
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
		this.fOriDest = this.fOriDest .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCostYrmon = this.fCostYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEcc = this.toEcc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fEccCd2 = this.fEccCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtDays = this.mvmtDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contiSteve = this.contiSteve .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtTrans = this.mvmtTrans .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contiDays = this.contiDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromEcc = this.fromEcc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vol = this.vol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtSteve = this.mvmtSteve .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contiTrans = this.contiTrans .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCntrTpszCd2 = this.fCntrTpszCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contiSteveUc = this.contiSteveUc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contiTransUc = this.contiTransUc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contiTtlUc = this.contiTtlUc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
