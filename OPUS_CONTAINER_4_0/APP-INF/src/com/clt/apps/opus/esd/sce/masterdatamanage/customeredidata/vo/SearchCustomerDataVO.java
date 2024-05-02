/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchCustomerDataVO.java
*@FileTitle : SearchCustomerDataVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.29
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.01.29 이윤정 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이윤정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchCustomerDataVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchCustomerDataVO> models = new ArrayList<SearchCustomerDataVO>();
	
	/* Column Info */
	private String custId = null;
	/* Column Info */
	private String rownum = null;
	/* Column Info */
	private String ediGrpDesc = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String scEffEndDt = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String ediGrpCd = null;
	/* Column Info */
	private String custTrdPrnrId = null;
	/* Column Info */
	private String provTrdPrnrId = null;
	/* Column Info */
	private String scEffStDt = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchCustomerDataVO() {}

	public SearchCustomerDataVO(String ibflag, String pagerows, String rownum, String ediGrpCd, String ediGrpDesc, String custTrdPrnrId, String provTrdPrnrId, String custId, String custLglEngNm, String scNo, String scEffStDt, String scEffEndDt) {
		this.custId = custId;
		this.rownum = rownum;
		this.ediGrpDesc = ediGrpDesc;
		this.ibflag = ibflag;
		this.scEffEndDt = scEffEndDt;
		this.scNo = scNo;
		this.ediGrpCd = ediGrpCd;
		this.custTrdPrnrId = custTrdPrnrId;
		this.provTrdPrnrId = provTrdPrnrId;
		this.scEffStDt = scEffStDt;
		this.custLglEngNm = custLglEngNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cust_id", getCustId());
		this.hashColumns.put("rownum", getRownum());
		this.hashColumns.put("edi_grp_desc", getEdiGrpDesc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sc_eff_end_dt", getScEffEndDt());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("edi_grp_cd", getEdiGrpCd());
		this.hashColumns.put("cust_trd_prnr_id", getCustTrdPrnrId());
		this.hashColumns.put("prov_trd_prnr_id", getProvTrdPrnrId());
		this.hashColumns.put("sc_eff_st_dt", getScEffStDt());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cust_id", "custId");
		this.hashFields.put("rownum", "rownum");
		this.hashFields.put("edi_grp_desc", "ediGrpDesc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sc_eff_end_dt", "scEffEndDt");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("edi_grp_cd", "ediGrpCd");
		this.hashFields.put("cust_trd_prnr_id", "custTrdPrnrId");
		this.hashFields.put("prov_trd_prnr_id", "provTrdPrnrId");
		this.hashFields.put("sc_eff_st_dt", "scEffStDt");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return custId
	 */
	public String getCustId() {
		return this.custId;
	}
	
	/**
	 * Column Info
	 * @return rownum
	 */
	public String getRownum() {
		return this.rownum;
	}
	
	/**
	 * Column Info
	 * @return ediGrpDesc
	 */
	public String getEdiGrpDesc() {
		return this.ediGrpDesc;
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
	 * @return scEffEndDt
	 */
	public String getScEffEndDt() {
		return this.scEffEndDt;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return ediGrpCd
	 */
	public String getEdiGrpCd() {
		return this.ediGrpCd;
	}
	
	/**
	 * Column Info
	 * @return custTrdPrnrId
	 */
	public String getCustTrdPrnrId() {
		return this.custTrdPrnrId;
	}
	
	/**
	 * Column Info
	 * @return provTrdPrnrId
	 */
	public String getProvTrdPrnrId() {
		return this.provTrdPrnrId;
	}
	
	/**
	 * Column Info
	 * @return scEffStDt
	 */
	public String getScEffStDt() {
		return this.scEffStDt;
	}
	
	/**
	 * Column Info
	 * @return custLglEngNm
	 */
	public String getCustLglEngNm() {
		return this.custLglEngNm;
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
	 * @param custId
	 */
	public void setCustId(String custId) {
		this.custId = custId;
	}
	
	/**
	 * Column Info
	 * @param rownum
	 */
	public void setRownum(String rownum) {
		this.rownum = rownum;
	}
	
	/**
	 * Column Info
	 * @param ediGrpDesc
	 */
	public void setEdiGrpDesc(String ediGrpDesc) {
		this.ediGrpDesc = ediGrpDesc;
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
	 * @param scEffEndDt
	 */
	public void setScEffEndDt(String scEffEndDt) {
		this.scEffEndDt = scEffEndDt;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param ediGrpCd
	 */
	public void setEdiGrpCd(String ediGrpCd) {
		this.ediGrpCd = ediGrpCd;
	}
	
	/**
	 * Column Info
	 * @param custTrdPrnrId
	 */
	public void setCustTrdPrnrId(String custTrdPrnrId) {
		this.custTrdPrnrId = custTrdPrnrId;
	}
	
	/**
	 * Column Info
	 * @param provTrdPrnrId
	 */
	public void setProvTrdPrnrId(String provTrdPrnrId) {
		this.provTrdPrnrId = provTrdPrnrId;
	}
	
	/**
	 * Column Info
	 * @param scEffStDt
	 */
	public void setScEffStDt(String scEffStDt) {
		this.scEffStDt = scEffStDt;
	}
	
	/**
	 * Column Info
	 * @param custLglEngNm
	 */
	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
		setCustId(JSPUtil.getParameter(request, prefix + "cust_id", ""));
		setRownum(JSPUtil.getParameter(request, prefix + "rownum", ""));
		setEdiGrpDesc(JSPUtil.getParameter(request, prefix + "edi_grp_desc", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setScEffEndDt(JSPUtil.getParameter(request, prefix + "sc_eff_end_dt", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setEdiGrpCd(JSPUtil.getParameter(request, prefix + "edi_grp_cd", ""));
		setCustTrdPrnrId(JSPUtil.getParameter(request, prefix + "cust_trd_prnr_id", ""));
		setProvTrdPrnrId(JSPUtil.getParameter(request, prefix + "prov_trd_prnr_id", ""));
		setScEffStDt(JSPUtil.getParameter(request, prefix + "sc_eff_st_dt", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCustomerDataVO[]
	 */
	public SearchCustomerDataVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCustomerDataVO[]
	 */
	public SearchCustomerDataVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchCustomerDataVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] custId = (JSPUtil.getParameter(request, prefix	+ "cust_id", length));
			String[] rownum = (JSPUtil.getParameter(request, prefix	+ "rownum", length));
			String[] ediGrpDesc = (JSPUtil.getParameter(request, prefix	+ "edi_grp_desc", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] scEffEndDt = (JSPUtil.getParameter(request, prefix	+ "sc_eff_end_dt", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] ediGrpCd = (JSPUtil.getParameter(request, prefix	+ "edi_grp_cd", length));
			String[] custTrdPrnrId = (JSPUtil.getParameter(request, prefix	+ "cust_trd_prnr_id", length));
			String[] provTrdPrnrId = (JSPUtil.getParameter(request, prefix	+ "prov_trd_prnr_id", length));
			String[] scEffStDt = (JSPUtil.getParameter(request, prefix	+ "sc_eff_st_dt", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchCustomerDataVO();
				if (custId[i] != null)
					model.setCustId(custId[i]);
				if (rownum[i] != null)
					model.setRownum(rownum[i]);
				if (ediGrpDesc[i] != null)
					model.setEdiGrpDesc(ediGrpDesc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (scEffEndDt[i] != null)
					model.setScEffEndDt(scEffEndDt[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (ediGrpCd[i] != null)
					model.setEdiGrpCd(ediGrpCd[i]);
				if (custTrdPrnrId[i] != null)
					model.setCustTrdPrnrId(custTrdPrnrId[i]);
				if (provTrdPrnrId[i] != null)
					model.setProvTrdPrnrId(provTrdPrnrId[i]);
				if (scEffStDt[i] != null)
					model.setScEffStDt(scEffStDt[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchCustomerDataVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchCustomerDataVO[]
	 */
	public SearchCustomerDataVO[] getSearchCustomerDataVOs(){
		SearchCustomerDataVO[] vos = (SearchCustomerDataVO[])models.toArray(new SearchCustomerDataVO[models.size()]);
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
		this.custId = this.custId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rownum = this.rownum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediGrpDesc = this.ediGrpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scEffEndDt = this.scEffEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediGrpCd = this.ediGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTrdPrnrId = this.custTrdPrnrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.provTrdPrnrId = this.provTrdPrnrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scEffStDt = this.scEffStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
