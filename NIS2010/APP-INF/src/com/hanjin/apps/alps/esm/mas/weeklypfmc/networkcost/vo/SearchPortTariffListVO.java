/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SearchPortTariffListVO.java
*@FileTitle : SearchPortTariffListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.07
*@LastModifier : 
*@LastVersion : 1.0
* 2011.07.07  
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

public class SearchPortTariffListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchPortTariffListVO> models = new ArrayList<SearchPortTariffListVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String psoCostPsoTtlAmt = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String psoCostTtlAmt = null;
	/* Column Info */
	private String chkFlag = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String costSts = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Page Number */
	private String userId = null;
	/* PSO MAX SEQ */
	private String psoMaxSeq = null;
	/*	Column Info	*/
	private	String	 hulBndCd ;
	/*	Column Info	*/
	private	String	 psoCostOrgAmt = null ;
	/*	Column Info	*/
	private	String	 psoCostAddAmt = null ;
	/*	Column Info	*/
	private	String	 preVvdAmt ;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchPortTariffListVO() {}

	public SearchPortTariffListVO(String vslCd,String ibflag,String slanCd,String costYrmon,String psoCostPsoTtlAmt,String costWk,String psoCostTtlAmt,String chkFlag,String skdVoyNo,String costSts,String skdDirCd,String pagerows,String userId,String psoMaxSeq,String hulBndCd, String psoCostOrgAmt, String psoCostAddAmt, String preVvdAmt)	{
		this.vslCd  = vslCd ;
		this.ibflag  = ibflag ;
		this.slanCd  = slanCd ;
		this.costYrmon  = costYrmon ;
		this.psoCostPsoTtlAmt  = psoCostPsoTtlAmt ;
		this.costWk  = costWk ;
		this.psoCostTtlAmt  = psoCostTtlAmt ;
		this.chkFlag  = chkFlag ;
		this.skdVoyNo  = skdVoyNo ;
		this.costSts  = costSts ;
		this.skdDirCd  = skdDirCd ;
		this.pagerows  = pagerows ;
		this.userId  = userId ;
		this.psoMaxSeq  = psoMaxSeq ;
		this.hulBndCd  = hulBndCd ;
		this.psoCostOrgAmt  = psoCostOrgAmt ;
		this.psoCostAddAmt  = psoCostAddAmt ;
		this.preVvdAmt  = preVvdAmt ;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("pso_cost_pso_ttl_amt", getPsoCostPsoTtlAmt());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("pso_cost_ttl_amt", getPsoCostTtlAmt());
		this.hashColumns.put("chk_flag", getChkFlag());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("cost_sts", getCostSts());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("pso_max_seq", getPsoMaxSeq());
		this.hashColumns.put("hul_bnd_cd", getHulBndCd());	
		this.hashColumns.put("pso_cost_org_amt", getPsoCostOrgAmt());	
		this.hashColumns.put("pso_cost_add_amt", getPsoCostAddAmt());	
		this.hashColumns.put("pre_vvd_amt", getPreVvdAmt());	
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("pso_cost_pso_ttl_amt", "psoCostPsoTtlAmt");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("pso_cost_ttl_amt", "psoCostTtlAmt");
		this.hashFields.put("chk_flag", "chkFlag");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("cost_sts", "costSts");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("pso_max_seq", "psoMaxSeq");
		this.hashFields.put("hul_bnd_cd", "hulBndCd");
		this.hashFields.put("pso_cost_org_amt", "psoCostOrgAmt");
		this.hashFields.put("pso_cost_add_amt", "psoCostAddAmt");
		this.hashFields.put("pre_vvd_amt", "preVvdAmt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
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
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
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
	 * @return psoCostPsoTtlAmt
	 */
	public String getPsoCostPsoTtlAmt() {
		return this.psoCostPsoTtlAmt;
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
	 * @return psoCostTtlAmt
	 */
	public String getPsoCostTtlAmt() {
		return this.psoCostTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return chkFlag
	 */
	public String getChkFlag() {
		return this.chkFlag;
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
	 * @return costSts
	 */
	public String getCostSts() {
		return this.costSts;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
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
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
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
	 * @param psoCostPsoTtlAmt
	 */
	public void setPsoCostPsoTtlAmt(String psoCostPsoTtlAmt) {
		this.psoCostPsoTtlAmt = psoCostPsoTtlAmt;
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
	 * @param psoCostTtlAmt
	 */
	public void setPsoCostTtlAmt(String psoCostTtlAmt) {
		this.psoCostTtlAmt = psoCostTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param chkFlag
	 */
	public void setChkFlag(String chkFlag) {
		this.chkFlag = chkFlag;
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
	 * @param costSts
	 */
	public void setCostSts(String costSts) {
		this.costSts = costSts;
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
	
    public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	

public String getPsoMaxSeq() {
		return psoMaxSeq;
	}

	public void setPsoMaxSeq(String psoMaxSeq) {
		this.psoMaxSeq = psoMaxSeq;
	}
	
	/**
	* Column Info
	* @param  hulBndCd
	*/
	public void	setHulBndCd( String	hulBndCd ) {
		this.hulBndCd =	hulBndCd;
	}
 
	/**
	 * Column Info
	 * @return	hulBndCd
	 */
	 public	String	getHulBndCd() {
		 return	this.hulBndCd;
	 } 
	 
	 /**
	 * @return the psoCostOrgAmt
	 */
	public String getPsoCostOrgAmt() {
		return psoCostOrgAmt;
	}

	/**
	 * @param psoCostOrgAmt the psoCostOrgAmt to set
	 */
	public void setPsoCostOrgAmt(String psoCostOrgAmt) {
		this.psoCostOrgAmt = psoCostOrgAmt;
	}

	/**
	 * @return the psoCostAddAmt
	 */
	public String getPsoCostAddAmt() {
		return psoCostAddAmt;
	}

	/**
	 * @param psoCostAddAmt the psoCostAddAmt to set
	 */
	public void setPsoCostAddAmt(String psoCostAddAmt) {
		this.psoCostAddAmt = psoCostAddAmt;
	}

	/**
	 * @return the preVvdAmt
	 */
	public String getPreVvdAmt() {
		return preVvdAmt;
	}

	/**
	 * @param preVvdAmt the preVvdAmt to set
	 */
	public void setPreVvdAmt(String preVvdAmt) {
		this.preVvdAmt = preVvdAmt;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setPsoCostPsoTtlAmt(JSPUtil.getParameter(request, prefix + "pso_cost_pso_ttl_amt", ""));
		setCostWk(JSPUtil.getParameter(request, prefix + "cost_wk", ""));
		setPsoCostTtlAmt(JSPUtil.getParameter(request, prefix + "pso_cost_ttl_amt", ""));
		setChkFlag(JSPUtil.getParameter(request, prefix + "chk_flag", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setCostSts(JSPUtil.getParameter(request, prefix + "cost_sts", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setPsoMaxSeq(JSPUtil.getParameter(request, prefix + "pso_max_seq", ""));
		setHulBndCd(JSPUtil.getParameter(request,	prefix + "hul_bnd_cd", ""));
		setPsoCostOrgAmt(JSPUtil.getParameter(request,	prefix + "pso_cost_org_amt", ""));
		setPsoCostAddAmt(JSPUtil.getParameter(request,	prefix + "pso_cost_add_amt", ""));
		setPreVvdAmt(JSPUtil.getParameter(request,	prefix + "pre_vvd_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchPortTariffListVO[]
	 */
	public SearchPortTariffListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchPortTariffListVO[]
	 */
	public SearchPortTariffListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchPortTariffListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] psoCostPsoTtlAmt = (JSPUtil.getParameter(request, prefix	+ "pso_cost_pso_ttl_amt", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] psoCostTtlAmt = (JSPUtil.getParameter(request, prefix	+ "pso_cost_ttl_amt", length));
			String[] chkFlag = (JSPUtil.getParameter(request, prefix	+ "chk_flag", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] costSts = (JSPUtil.getParameter(request, prefix	+ "cost_sts", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] psoMaxSeq = (JSPUtil.getParameter(request, prefix	+ "pso_max_seq", length));
			String[] hulBndCd =	(JSPUtil.getParameter(request, prefix +	"hul_bnd_cd".trim(),	length));
			String[] psoCostOrgAmt =	(JSPUtil.getParameter(request, prefix +	"pso_cost_org_amt".trim(),	length));
			String[] psoCostAddAmt =	(JSPUtil.getParameter(request, prefix +	"pso_cost_add_amt".trim(),	length));
			String[] preVvdAmt =	(JSPUtil.getParameter(request, prefix +	"pre_vvd_amt".trim(),	length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchPortTariffListVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (psoCostPsoTtlAmt[i] != null)
					model.setPsoCostPsoTtlAmt(psoCostPsoTtlAmt[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (psoCostTtlAmt[i] != null)
					model.setPsoCostTtlAmt(psoCostTtlAmt[i]);
				if (chkFlag[i] != null)
					model.setChkFlag(chkFlag[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (costSts[i] != null)
					model.setCostSts(costSts[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (psoMaxSeq[i] != null)
					model.setPsoMaxSeq(psoMaxSeq[i]);
				if ( hulBndCd[i] !=	null)
					model.setHulBndCd( hulBndCd[i]);
				if ( psoCostOrgAmt[i] !=	null)
					model.setPsoCostOrgAmt( psoCostOrgAmt[i]);
				if ( psoCostAddAmt[i] !=	null)
					model.setPsoCostAddAmt( psoCostAddAmt[i]);
				if ( preVvdAmt[i] !=	null)
					model.setPreVvdAmt( preVvdAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchPortTariffListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchPortTariffListVO[]
	 */
	public SearchPortTariffListVO[] getSearchPortTariffListVOs(){
		SearchPortTariffListVO[] vos = (SearchPortTariffListVO[])models.toArray(new SearchPortTariffListVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psoCostPsoTtlAmt = this.psoCostPsoTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psoCostTtlAmt = this.psoCostTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkFlag = this.chkFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costSts = this.costSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psoMaxSeq = this.psoMaxSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hulBndCd =	this.hulBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psoCostOrgAmt =	this.psoCostOrgAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psoCostAddAmt =	this.psoCostAddAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preVvdAmt =	this.preVvdAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
