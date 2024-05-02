/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ModifyFromTrsOffHireReturnVO.java
*@FileTitle : ModifyFromTrsOffHireReturnVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.21
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.10.21 정은호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정은호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ModifyFromTrsOffHireReturnVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ModifyFromTrsOffHireReturnVO> models = new ArrayList<ModifyFromTrsOffHireReturnVO>();
	
	/* Column Info */
	private String repoPlnId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String chdToYdCd = null;
	/* Column Info */
	private String cntrNo	= null;
	/* Column Info */
	private List<String> cntrNoList = new ArrayList<String>();
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String refId = null;
	/* Column Info */
	private String chdCntrQty = null;
	/* Column Info */
	private String plnYrwk = null;
	/* Column Info */
	private String trspSoStsCd = null;
	/* Page Number */
	private String pagerows = null;
	/* return Column Info */
	private String returnCode = "";
	/* return Column Info */
	private String newRefId = "";
	/* modify Column Info */
	private String cntrQty = null;
	/* return Column Info */
	private List<String> refSeqList = new  ArrayList<String>();
	/* return Column Info */
	private List<String> oldRefSeqList = new  ArrayList<String>();
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ModifyFromTrsOffHireReturnVO() {}

	public ModifyFromTrsOffHireReturnVO(String ibflag, String pagerows, String repoPlnId, String plnYrwk, String refId, String cntrTpszCd, String cntrNo, String trspSoStsCd, String chdToYdCd , String chdCntrQty) {
		this.repoPlnId = repoPlnId;
		this.ibflag = ibflag;
		this.chdToYdCd = chdToYdCd;
		this.cntrNo = cntrNo;
		this.cntrTpszCd = cntrTpszCd;
		this.refId = refId;
		this.chdCntrQty = chdCntrQty;
		this.plnYrwk = plnYrwk;
		this.trspSoStsCd = trspSoStsCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("repo_pln_id", getRepoPlnId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("chd_to_yd_cd", getChdToYdCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("ref_id", getRefId());
		this.hashColumns.put("chd_cntr_qty", getChdCntrQty());
		this.hashColumns.put("pln_yrwk", getPlnYrwk());
		this.hashColumns.put("trsp_so_sts_cd", getTrspSoStsCd());
		this.hashColumns.put("cntr_qty", getCntrQty());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("repo_pln_id", "repoPlnId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("chd_to_yd_cd", "chdToYdCd");
		this.hashFields.put("chd_to_yd_dt", "chdToYdDt");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("ref_id", "refId");
		this.hashFields.put("chd_cntr_qty", "chdCntrQty");
		this.hashFields.put("pln_yrwk", "plnYrwk");
		this.hashFields.put("trsp_so_sts_cd", "trspSoStsCd");
		this.hashFields.put("cntr_qty", "cntrQty");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return repoPlnId
	 */
	public String getRepoPlnId() {
		return this.repoPlnId;
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
	 * @return chdToYdCd
	 */
	public String getChdToYdCd() {
		return this.chdToYdCd;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 * 사용하지 않음
	 */
	public String getCntrNo() {
		return this.cntrNo;
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
	 * @return refId
	 */
	public String getRefId() {
		return this.refId;
	}
	
	/**
	 * Column Info
	 * @return chdCntrQty
	 */
	public String getChdCntrQty() {
		return this.chdCntrQty;
	}
	
	/**
	 * Column Info
	 * @return plnYrwk
	 */
	public String getPlnYrwk() {
		return this.plnYrwk;
	}
	
	/**
	 * Column Info
	 * @return trspSoStsCd
	 */
	public String getTrspSoStsCd() {
		return this.trspSoStsCd;
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
	 * @param repoPlnId
	 */
	public void setRepoPlnId(String repoPlnId) {
		this.repoPlnId = repoPlnId;
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
	 * @param chdToYdCd
	 */
	public void setChdToYdCd(String chdToYdCd) {
		this.chdToYdCd = chdToYdCd;
	}

	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
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
	 * @param refId
	 */
	public void setRefId(String refId) {
		this.refId = refId;
	}
	
	/**
	 * Column Info
	 * @param chdCntrQty
	 */
	public void setChdCntrQty(String chdCntrQty) {
		this.chdCntrQty = chdCntrQty;
	}
	
	/**
	 * Column Info
	 * @param plnYrwk
	 */
	public void setPlnYrwk(String plnYrwk) {
		this.plnYrwk = plnYrwk;
	}
	
	/**
	 * Column Info
	 * @param trspSoStsCd
	 */
	public void setTrspSoStsCd(String trspSoStsCd) {
		this.trspSoStsCd = trspSoStsCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	public List<String> getCntrNoList() {
		return cntrNoList;
	}

	public void setCntrNoList(List<String> cntrNoList) {
		this.cntrNoList = cntrNoList;
	}
	
	public void addCntrNoList(String cntrNo){
		cntrNoList.add(cntrNo);
	}

	public void clearCntrNoList(){
		cntrNoList = new ArrayList<String>();
	}

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getNewRefId() {
		return newRefId;
	}

	public void setNewRefId(String newRefId) {
		this.newRefId = newRefId;
	}
	
	public String getCntrQty() {
		return cntrQty;
	}

	public void setCntrQty(String cntrQty) {
		this.cntrQty = cntrQty;
	}
	
	public List<String> getRefSeqList() {
		return refSeqList;
	}
	
	public void setRefSeqList(List<String> refSeqList) {
		this.refSeqList = refSeqList;
	}
	public void addRefSeqList(String refSeq){
		refSeqList.add(refSeq);
	}

	public List<String> getOldRefSeqList() {
		return oldRefSeqList;
	}

	public void setOldRefSeqList(List<String> oldRefSeqList) {
		this.oldRefSeqList = oldRefSeqList;
	}
	public void addOldRefSeqList(String oldRefSeq){
		oldRefSeqList.add(oldRefSeq);
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRepoPlnId(JSPUtil.getParameter(request, "repo_pln_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setChdToYdCd(JSPUtil.getParameter(request, "chd_to_yd_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setRefId(JSPUtil.getParameter(request, "ref_id", ""));
		setChdCntrQty(JSPUtil.getParameter(request, "chd_cntr_qty", ""));
		setPlnYrwk(JSPUtil.getParameter(request, "pln_yrwk", ""));
		setTrspSoStsCd(JSPUtil.getParameter(request, "trsp_so_sts_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ModifyFromTrsOffHireReturnVO[]
	 */
	public ModifyFromTrsOffHireReturnVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ModifyFromTrsOffHireReturnVO[]
	 */
	public ModifyFromTrsOffHireReturnVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ModifyFromTrsOffHireReturnVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] repoPlnId = (JSPUtil.getParameter(request, prefix	+ "repo_pln_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] chdToYdCd = (JSPUtil.getParameter(request, prefix	+ "chd_to_yd_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] refId = (JSPUtil.getParameter(request, prefix	+ "ref_id", length));
			String[] chdCntrQty = (JSPUtil.getParameter(request, prefix	+ "chd_cntr_qty", length));
			String[] plnYrwk = (JSPUtil.getParameter(request, prefix	+ "pln_yrwk", length));
			String[] trspSoStsCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_sts_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ModifyFromTrsOffHireReturnVO();
				if (repoPlnId[i] != null)
					model.setRepoPlnId(repoPlnId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (chdToYdCd[i] != null)
					model.setChdToYdCd(chdToYdCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (refId[i] != null)
					model.setRefId(refId[i]);
				if (chdCntrQty[i] != null)
					model.setChdCntrQty(chdCntrQty[i]);
				if (plnYrwk[i] != null)
					model.setPlnYrwk(plnYrwk[i]);
				if (trspSoStsCd[i] != null)
					model.setTrspSoStsCd(trspSoStsCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getModifyFromTrsOffHireReturnVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ModifyFromTrsOffHireReturnVO[]
	 */
	public ModifyFromTrsOffHireReturnVO[] getModifyFromTrsOffHireReturnVOs(){
		ModifyFromTrsOffHireReturnVO[] vos = (ModifyFromTrsOffHireReturnVO[])models.toArray(new ModifyFromTrsOffHireReturnVO[models.size()]);
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
		this.repoPlnId = this.repoPlnId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chdToYdCd = this.chdToYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refId = this.refId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chdCntrQty = this.chdCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYrwk = this.plnYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoStsCd = this.trspSoStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
