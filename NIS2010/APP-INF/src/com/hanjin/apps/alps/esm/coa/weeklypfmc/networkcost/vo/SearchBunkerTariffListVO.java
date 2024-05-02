/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchBunkerTariffListVO.java
*@FileTitle : SearchBunkerTariffListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.22  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.vo;

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

public class SearchBunkerTariffListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchBunkerTariffListVO> models = new ArrayList<SearchBunkerTariffListVO>();
	
	/* Column Info */
	private String hulBndCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String flag = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String foilCsm = null;
	/* Column Info */
	private String foilUcAmt = null;
	/* Column Info */
	private String vslInfo = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String doilUcAmt = null;
	/* Column Info */
	private String vslClssCapa = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String doilCsm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchBunkerTariffListVO() {}

	public SearchBunkerTariffListVO(String ibflag, String pagerows, String flag, String costYrmon, String costWk, String slanCd, String rlaneCd, String vslClssCapa, String dirCd, String hulBndCd, String foilCsm, String foilUcAmt, String doilCsm, String doilUcAmt, String vslInfo) {
		this.hulBndCd = hulBndCd;
		this.rlaneCd = rlaneCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.flag = flag;
		this.costYrmon = costYrmon;
		this.slanCd = slanCd;
		this.foilCsm = foilCsm;
		this.foilUcAmt = foilUcAmt;
		this.vslInfo = vslInfo;
		this.costWk = costWk;
		this.doilUcAmt = doilUcAmt;
		this.vslClssCapa = vslClssCapa;
		this.dirCd = dirCd;
		this.doilCsm = doilCsm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("hul_bnd_cd", getHulBndCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("flag", getFlag());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("foil_csm", getFoilCsm());
		this.hashColumns.put("foil_uc_amt", getFoilUcAmt());
		this.hashColumns.put("vsl_info", getVslInfo());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("doil_uc_amt", getDoilUcAmt());
		this.hashColumns.put("vsl_clss_capa", getVslClssCapa());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("doil_csm", getDoilCsm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("hul_bnd_cd", "hulBndCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("flag", "flag");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("foil_csm", "foilCsm");
		this.hashFields.put("foil_uc_amt", "foilUcAmt");
		this.hashFields.put("vsl_info", "vslInfo");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("doil_uc_amt", "doilUcAmt");
		this.hashFields.put("vsl_clss_capa", "vslClssCapa");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("doil_csm", "doilCsm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return hulBndCd
	 */
	public String getHulBndCd() {
		return this.hulBndCd;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
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
	 * @return flag
	 */
	public String getFlag() {
		return this.flag;
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
	 * @return foilCsm
	 */
	public String getFoilCsm() {
		return this.foilCsm;
	}
	
	/**
	 * Column Info
	 * @return foilUcAmt
	 */
	public String getFoilUcAmt() {
		return this.foilUcAmt;
	}
	
	/**
	 * Column Info
	 * @return vslInfo
	 */
	public String getVslInfo() {
		return this.vslInfo;
	}
	
	/**
	 * Column Info
	 * @return costWk
	 */
	public String getCostWk() {
		return this.costWk;
	}
	
	/**
	 * Column Info
	 * @return doilUcAmt
	 */
	public String getDoilUcAmt() {
		return this.doilUcAmt;
	}
	
	/**
	 * Column Info
	 * @return vslClssCapa
	 */
	public String getVslClssCapa() {
		return this.vslClssCapa;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return doilCsm
	 */
	public String getDoilCsm() {
		return this.doilCsm;
	}
	

	/**
	 * Column Info
	 * @param hulBndCd
	 */
	public void setHulBndCd(String hulBndCd) {
		this.hulBndCd = hulBndCd;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
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
	 * @param flag
	 */
	public void setFlag(String flag) {
		this.flag = flag;
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
	 * @param foilCsm
	 */
	public void setFoilCsm(String foilCsm) {
		this.foilCsm = foilCsm;
	}
	
	/**
	 * Column Info
	 * @param foilUcAmt
	 */
	public void setFoilUcAmt(String foilUcAmt) {
		this.foilUcAmt = foilUcAmt;
	}
	
	/**
	 * Column Info
	 * @param vslInfo
	 */
	public void setVslInfo(String vslInfo) {
		this.vslInfo = vslInfo;
	}
	
	/**
	 * Column Info
	 * @param costWk
	 */
	public void setCostWk(String costWk) {
		this.costWk = costWk;
	}
	
	/**
	 * Column Info
	 * @param doilUcAmt
	 */
	public void setDoilUcAmt(String doilUcAmt) {
		this.doilUcAmt = doilUcAmt;
	}
	
	/**
	 * Column Info
	 * @param vslClssCapa
	 */
	public void setVslClssCapa(String vslClssCapa) {
		this.vslClssCapa = vslClssCapa;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param doilCsm
	 */
	public void setDoilCsm(String doilCsm) {
		this.doilCsm = doilCsm;
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
		setHulBndCd(JSPUtil.getParameter(request, prefix + "hul_bnd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFlag(JSPUtil.getParameter(request, prefix + "flag", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setFoilCsm(JSPUtil.getParameter(request, prefix + "foil_csm", ""));
		setFoilUcAmt(JSPUtil.getParameter(request, prefix + "foil_uc_amt", ""));
		setVslInfo(JSPUtil.getParameter(request, prefix + "vsl_info", ""));
		setCostWk(JSPUtil.getParameter(request, prefix + "cost_wk", ""));
		setDoilUcAmt(JSPUtil.getParameter(request, prefix + "doil_uc_amt", ""));
		setVslClssCapa(JSPUtil.getParameter(request, prefix + "vsl_clss_capa", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setDoilCsm(JSPUtil.getParameter(request, prefix + "doil_csm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchBunkerTariffListVO[]
	 */
	public SearchBunkerTariffListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchBunkerTariffListVO[]
	 */
	public SearchBunkerTariffListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchBunkerTariffListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] hulBndCd = (JSPUtil.getParameter(request, prefix	+ "hul_bnd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] flag = (JSPUtil.getParameter(request, prefix	+ "flag", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] foilCsm = (JSPUtil.getParameter(request, prefix	+ "foil_csm", length));
			String[] foilUcAmt = (JSPUtil.getParameter(request, prefix	+ "foil_uc_amt", length));
			String[] vslInfo = (JSPUtil.getParameter(request, prefix	+ "vsl_info", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] doilUcAmt = (JSPUtil.getParameter(request, prefix	+ "doil_uc_amt", length));
			String[] vslClssCapa = (JSPUtil.getParameter(request, prefix	+ "vsl_clss_capa", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] doilCsm = (JSPUtil.getParameter(request, prefix	+ "doil_csm", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchBunkerTariffListVO();
				if (hulBndCd[i] != null)
					model.setHulBndCd(hulBndCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (flag[i] != null)
					model.setFlag(flag[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (foilCsm[i] != null)
					model.setFoilCsm(foilCsm[i]);
				if (foilUcAmt[i] != null)
					model.setFoilUcAmt(foilUcAmt[i]);
				if (vslInfo[i] != null)
					model.setVslInfo(vslInfo[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (doilUcAmt[i] != null)
					model.setDoilUcAmt(doilUcAmt[i]);
				if (vslClssCapa[i] != null)
					model.setVslClssCapa(vslClssCapa[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (doilCsm[i] != null)
					model.setDoilCsm(doilCsm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchBunkerTariffListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchBunkerTariffListVO[]
	 */
	public SearchBunkerTariffListVO[] getSearchBunkerTariffListVOs(){
		SearchBunkerTariffListVO[] vos = (SearchBunkerTariffListVO[])models.toArray(new SearchBunkerTariffListVO[models.size()]);
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
		this.hulBndCd = this.hulBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flag = this.flag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilCsm = this.foilCsm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilUcAmt = this.foilUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslInfo = this.vslInfo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doilUcAmt = this.doilUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslClssCapa = this.vslClssCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doilCsm = this.doilCsm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
