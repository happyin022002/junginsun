/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchCustomerInqueryVO.java
*@FileTitle : SearchCustomerInqueryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 이중환
*@LastVersion : 1.0
* 2009.08.26 이중환 
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
 * @author 이중환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchCustomerInqueryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchCustomerInqueryVO> models = new ArrayList<SearchCustomerInqueryVO>();
	
	/* Column Info */
	private String ediGrpDesc = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ediGrpCd = null;
	/* Column Info */
	private String custTrdPrnrId = null;
	/* Page Number */
	private String pagerows = null;
	/* Cust_cnt_seq */
	private String custCntCd = null;
	/* cust seq */
	private String custSeq = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchCustomerInqueryVO() {}

	public SearchCustomerInqueryVO(String ibflag, String pagerows, String ediGrpCd, String custTrdPrnrId, String ediGrpDesc, String custCntCd, String custSeq) {
		this.ediGrpDesc = ediGrpDesc;
		this.ibflag = ibflag;
		this.ediGrpCd = ediGrpCd;
		this.custTrdPrnrId = custTrdPrnrId;
		this.pagerows = pagerows;
		this.custCntCd = custCntCd;
		this.custSeq = custSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("edi_grp_desc", getEdiGrpDesc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("edi_grp_cd", getEdiGrpCd());
		this.hashColumns.put("cust_trd_prnr_id", getCustTrdPrnrId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("edi_grp_desc", "ediGrpDesc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("edi_grp_cd", "ediGrpCd");
		this.hashFields.put("cust_trd_prnr_id", "custTrdPrnrId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cust_seq", "custSeq");
		return this.hashFields;
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
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * column lnfo
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * column lnfo
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
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
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setEdiGrpDesc(JSPUtil.getParameter(request, "edi_grp_desc", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEdiGrpCd(JSPUtil.getParameter(request, "edi_grp_cd", ""));
		setCustTrdPrnrId(JSPUtil.getParameter(request, "cust_trd_prnr_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCustTrdPrnrId(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setCustTrdPrnrId(JSPUtil.getParameter(request, "cust_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCustomerInqueryVO[]
	 */
	public SearchCustomerInqueryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCustomerInqueryVO[]
	 */
	public SearchCustomerInqueryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchCustomerInqueryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ediGrpDesc = (JSPUtil.getParameter(request, prefix	+ "edi_grp_desc", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ediGrpCd = (JSPUtil.getParameter(request, prefix	+ "edi_grp_cd", length));
			String[] custTrdPrnrId = (JSPUtil.getParameter(request, prefix	+ "cust_trd_prnr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchCustomerInqueryVO();
				if (ediGrpDesc[i] != null)
					model.setEdiGrpDesc(ediGrpDesc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ediGrpCd[i] != null)
					model.setEdiGrpCd(ediGrpCd[i]);
				if (custTrdPrnrId[i] != null)
					model.setCustTrdPrnrId(custTrdPrnrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (custTrdPrnrId[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (custTrdPrnrId[i] != null)
					model.setCustSeq(custSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchCustomerInqueryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchCustomerInqueryVO[]
	 */
	public SearchCustomerInqueryVO[] getSearchCustomerInqueryVOs(){
		SearchCustomerInqueryVO[] vos = (SearchCustomerInqueryVO[])models.toArray(new SearchCustomerInqueryVO[models.size()]);
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
		this.ediGrpDesc = this.ediGrpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediGrpCd = this.ediGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTrdPrnrId = this.custTrdPrnrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
