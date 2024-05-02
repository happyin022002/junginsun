/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : AllocResultCommitListVO.java
*@FileTitle : AllocResultCommitListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.20
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2013.12.20 최성민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.vo;

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
 * @author 최성민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AllocResultCommitListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AllocResultCommitListVO> models = new ArrayList<AllocResultCommitListVO>();
	
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String n1stAsgnAmt = null;
	/* Column Info */
	private String totalNetworkCost = null;
	/* Column Info */
	private String hjsSalesFinal = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String n2stAsgnAmt = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String iptAsgnAmt = null;
	/* Column Info */
	private String coAmt = null;
	/* Column Info */
	private String hjsSlsAmt = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String subTrdCd = null;
	/*	Column Info	*/
	private	String	 hulBndCd ;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AllocResultCommitListVO() {}

	public AllocResultCommitListVO(String iocCd,String vslCd,String n1stAsgnAmt,String totalNetworkCost,String hjsSalesFinal,String trdCd,String skdVoyNo,String n2stAsgnAmt,String rlaneCd,String pagerows,String ibflag,String costYrmon,String vvdCd,String costWk,String iptAsgnAmt,String coAmt,String hjsSlsAmt,String dirCd,String subTrdCd,String hulBndCd)	{
		this.iocCd  = iocCd ;
		this.vslCd  = vslCd ;
		this.n1stAsgnAmt  = n1stAsgnAmt ;
		this.totalNetworkCost  = totalNetworkCost ;
		this.hjsSalesFinal  = hjsSalesFinal ;
		this.trdCd  = trdCd ;
		this.skdVoyNo  = skdVoyNo ;
		this.n2stAsgnAmt  = n2stAsgnAmt ;
		this.rlaneCd  = rlaneCd ;
		this.pagerows  = pagerows ;
		this.ibflag  = ibflag ;
		this.costYrmon  = costYrmon ;
		this.vvdCd  = vvdCd ;
		this.costWk  = costWk ;
		this.iptAsgnAmt  = iptAsgnAmt ;
		this.coAmt  = coAmt ;
		this.hjsSlsAmt  = hjsSlsAmt ;
		this.dirCd  = dirCd ;
		this.subTrdCd  = subTrdCd ;
		this.hulBndCd  = hulBndCd ;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("n1st_asgn_amt", getN1stAsgnAmt());
		this.hashColumns.put("total_network_cost", getTotalNetworkCost());
		this.hashColumns.put("hjs_sales_final", getHjsSalesFinal());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("n2st_asgn_amt", getN2stAsgnAmt());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("ipt_asgn_amt", getIptAsgnAmt());
		this.hashColumns.put("co_amt", getCoAmt());
		this.hashColumns.put("hjs_sls_amt", getHjsSlsAmt());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("hul_bnd_cd", getHulBndCd());	
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("n1st_asgn_amt", "n1stAsgnAmt");
		this.hashFields.put("total_network_cost", "totalNetworkCost");
		this.hashFields.put("hjs_sales_final", "hjsSalesFinal");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("n2st_asgn_amt", "n2stAsgnAmt");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("ipt_asgn_amt", "iptAsgnAmt");
		this.hashFields.put("co_amt", "coAmt");
		this.hashFields.put("hjs_sls_amt", "hjsSlsAmt");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("hul_bnd_cd", "hulBndCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return iocCd
	 */
	public String getIocCd() {
		return this.iocCd;
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
	 * @return n1stAsgnAmt
	 */
	public String getN1stAsgnAmt() {
		return this.n1stAsgnAmt;
	}
	
	/**
	 * Column Info
	 * @return totalNetworkCost
	 */
	public String getTotalNetworkCost() {
		return this.totalNetworkCost;
	}
	
	/**
	 * Column Info
	 * @return hjsSalesFinal
	 */
	public String getHjsSalesFinal() {
		return this.hjsSalesFinal;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
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
	 * @return n2stAsgnAmt
	 */
	public String getN2stAsgnAmt() {
		return this.n2stAsgnAmt;
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
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
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
	 * @return iptAsgnAmt
	 */
	public String getIptAsgnAmt() {
		return this.iptAsgnAmt;
	}
	
	/**
	 * Column Info
	 * @return coAmt
	 */
	public String getCoAmt() {
		return this.coAmt;
	}
	
	/**
	 * Column Info
	 * @return hjsSlsAmt
	 */
	public String getHjsSlsAmt() {
		return this.hjsSlsAmt;
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
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	

	/**
	 * Column Info
	 * @param iocCd
	 */
	public void setIocCd(String iocCd) {
		this.iocCd = iocCd;
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
	 * @param n1stAsgnAmt
	 */
	public void setN1stAsgnAmt(String n1stAsgnAmt) {
		this.n1stAsgnAmt = n1stAsgnAmt;
	}
	
	/**
	 * Column Info
	 * @param totalNetworkCost
	 */
	public void setTotalNetworkCost(String totalNetworkCost) {
		this.totalNetworkCost = totalNetworkCost;
	}
	
	/**
	 * Column Info
	 * @param hjsSalesFinal
	 */
	public void setHjsSalesFinal(String hjsSalesFinal) {
		this.hjsSalesFinal = hjsSalesFinal;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
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
	 * @param n2stAsgnAmt
	 */
	public void setN2stAsgnAmt(String n2stAsgnAmt) {
		this.n2stAsgnAmt = n2stAsgnAmt;
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
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
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
	 * @param iptAsgnAmt
	 */
	public void setIptAsgnAmt(String iptAsgnAmt) {
		this.iptAsgnAmt = iptAsgnAmt;
	}
	
	/**
	 * Column Info
	 * @param coAmt
	 */
	public void setCoAmt(String coAmt) {
		this.coAmt = coAmt;
	}
	
	/**
	 * Column Info
	 * @param hjsSlsAmt
	 */
	public void setHjsSlsAmt(String hjsSlsAmt) {
		this.hjsSlsAmt = hjsSlsAmt;
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
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
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
		setIocCd(JSPUtil.getParameter(request, prefix + "ioc_cd", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setN1stAsgnAmt(JSPUtil.getParameter(request, prefix + "n1st_asgn_amt", ""));
		setTotalNetworkCost(JSPUtil.getParameter(request, prefix + "total_network_cost", ""));
		setHjsSalesFinal(JSPUtil.getParameter(request, prefix + "hjs_sales_final", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setN2stAsgnAmt(JSPUtil.getParameter(request, prefix + "n2st_asgn_amt", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setCostWk(JSPUtil.getParameter(request, prefix + "cost_wk", ""));
		setIptAsgnAmt(JSPUtil.getParameter(request, prefix + "ipt_asgn_amt", ""));
		setCoAmt(JSPUtil.getParameter(request, prefix + "co_amt", ""));
		setHjsSlsAmt(JSPUtil.getParameter(request, prefix + "hjs_sls_amt", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setHulBndCd(JSPUtil.getParameter(request,	prefix + "hul_bnd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AllocResultCommitListVO[]
	 */
	public AllocResultCommitListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AllocResultCommitListVO[]
	 */
	public AllocResultCommitListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AllocResultCommitListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] n1stAsgnAmt = (JSPUtil.getParameter(request, prefix	+ "n1st_asgn_amt", length));
			String[] totalNetworkCost = (JSPUtil.getParameter(request, prefix	+ "total_network_cost", length));
			String[] hjsSalesFinal = (JSPUtil.getParameter(request, prefix	+ "hjs_sales_final", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] n2stAsgnAmt = (JSPUtil.getParameter(request, prefix	+ "n2st_asgn_amt", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] iptAsgnAmt = (JSPUtil.getParameter(request, prefix	+ "ipt_asgn_amt", length));
			String[] coAmt = (JSPUtil.getParameter(request, prefix	+ "co_amt", length));
			String[] hjsSlsAmt = (JSPUtil.getParameter(request, prefix	+ "hjs_sls_amt", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] hulBndCd =	(JSPUtil.getParameter(request, prefix +	"hul_bnd_cd".trim(),	length));
			
			for (int i = 0; i < length; i++) {
				model = new AllocResultCommitListVO();
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (n1stAsgnAmt[i] != null)
					model.setN1stAsgnAmt(n1stAsgnAmt[i]);
				if (totalNetworkCost[i] != null)
					model.setTotalNetworkCost(totalNetworkCost[i]);
				if (hjsSalesFinal[i] != null)
					model.setHjsSalesFinal(hjsSalesFinal[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (n2stAsgnAmt[i] != null)
					model.setN2stAsgnAmt(n2stAsgnAmt[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (iptAsgnAmt[i] != null)
					model.setIptAsgnAmt(iptAsgnAmt[i]);
				if (coAmt[i] != null)
					model.setCoAmt(coAmt[i]);
				if (hjsSlsAmt[i] != null)
					model.setHjsSlsAmt(hjsSlsAmt[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if ( hulBndCd[i] !=	null)
					model.setHulBndCd( hulBndCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAllocResultCommitListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AllocResultCommitListVO[]
	 */
	public AllocResultCommitListVO[] getAllocResultCommitListVOs(){
		AllocResultCommitListVO[] vos = (AllocResultCommitListVO[])models.toArray(new AllocResultCommitListVO[models.size()]);
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
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stAsgnAmt = this.n1stAsgnAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalNetworkCost = this.totalNetworkCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjsSalesFinal = this.hjsSalesFinal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2stAsgnAmt = this.n2stAsgnAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iptAsgnAmt = this.iptAsgnAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coAmt = this.coAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjsSlsAmt = this.hjsSlsAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hulBndCd =	this.hulBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
