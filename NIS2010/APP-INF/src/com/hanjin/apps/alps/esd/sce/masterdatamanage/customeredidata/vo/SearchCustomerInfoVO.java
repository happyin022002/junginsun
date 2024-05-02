/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SearchCustomerInfoVO.java
*@FileTitle : SearchCustomerInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.14
*@LastModifier : 
*@LastVersion : 1.0
* 2012.08.14  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo;

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

public class SearchCustomerInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchCustomerInfoVO> models = new ArrayList<SearchCustomerInfoVO>();
	
	/* Column Info */
	private String ediCgoRmk = null;
	/* Column Info */
	private String ediSts = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String ediGrpDesc = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ediGrpCd = null;
	/* Column Info */
	private String custTrdPrnrId = null;
	/* Column Info */
	private String bzcCol = null;
	/* Column Info */
	private String ediStsSeq = null;
	/* Column Info */
	private String mycust = null;
	/* Column Info */
	private String csGrpId = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ediStsCon = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchCustomerInfoVO() {}

	public SearchCustomerInfoVO(String ibflag, String pagerows, String ediCgoRmk, String ediGrpDesc, String creUsrId, String ediGrpCd, String custTrdPrnrId, String ediStsSeq, String csGrpId, String bzcCol, String ediSts, String mycust, String ediStsCon) {
		this.ediCgoRmk = ediCgoRmk;
		this.ediSts = ediSts;
		this.ediStsCon = ediStsCon;
		this.creUsrId = creUsrId;
		this.ediGrpDesc = ediGrpDesc;
		this.ibflag = ibflag;
		this.ediGrpCd = ediGrpCd;
		this.custTrdPrnrId = custTrdPrnrId;
		this.bzcCol = bzcCol;
		this.ediStsSeq = ediStsSeq;
		this.mycust = mycust;
		this.csGrpId = csGrpId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("edi_cgo_rmk", getEdiCgoRmk());
		this.hashColumns.put("edi_sts", getEdiSts());
		this.hashColumns.put("edi_sts_con", getEdiStsCon());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("edi_grp_desc", getEdiGrpDesc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("edi_grp_cd", getEdiGrpCd());
		this.hashColumns.put("cust_trd_prnr_id", getCustTrdPrnrId());
		this.hashColumns.put("bzc_col", getBzcCol());
		this.hashColumns.put("edi_sts_seq", getEdiStsSeq());
		this.hashColumns.put("mycust", getMycust());
		this.hashColumns.put("cs_grp_id", getCsGrpId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("edi_cgo_rmk", "ediCgoRmk");
		this.hashFields.put("edi_sts", "ediSts");
		this.hashFields.put("edi_sts_con", "ediStsCon");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("edi_grp_desc", "ediGrpDesc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("edi_grp_cd", "ediGrpCd");
		this.hashFields.put("cust_trd_prnr_id", "custTrdPrnrId");
		this.hashFields.put("bzc_col", "bzcCol");
		this.hashFields.put("edi_sts_seq", "ediStsSeq");
		this.hashFields.put("mycust", "mycust");
		this.hashFields.put("cs_grp_id", "csGrpId");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ediCgoRmk
	 */
	public String getEdiCgoRmk() {
		return this.ediCgoRmk;
	}
	
	/**
	 * Column Info
	 * @return ediSts
	 */
	public String getEdiSts() {
		return this.ediSts;
	}
	
	/**
	 * Column Info
	 * @return ediStsCon
	 */
	public String getEdiStsCon() {
		return this.ediStsCon;
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
	 * Column Info
	 * @return bzcCol
	 */
	public String getBzcCol() {
		return this.bzcCol;
	}
	
	/**
	 * Column Info
	 * @return ediStsSeq
	 */
	public String getEdiStsSeq() {
		return this.ediStsSeq;
	}
	
	/**
	 * Column Info
	 * @return mycust
	 */
	public String getMycust() {
		return this.mycust;
	}
	
	/**
	 * Column Info
	 * @return csGrpId
	 */
	public String getCsGrpId() {
		return this.csGrpId;
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
	 * @param ediCgoRmk
	 */
	public void setEdiCgoRmk(String ediCgoRmk) {
		this.ediCgoRmk = ediCgoRmk;
	}
	
	/**
	 * Column Info
	 * @param ediSts
	 */
	public void setEdiSts(String ediSts) {
		this.ediSts = ediSts;
	}
	
	/**
	 * Column Info
	 * @param ediStsCon
	 */
	public void setEdiStsCon(String ediStsCon) {
		this.ediStsCon = ediStsCon;
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
	 * Column Info
	 * @param bzcCol
	 */
	public void setBzcCol(String bzcCol) {
		this.bzcCol = bzcCol;
	}
	
	/**
	 * Column Info
	 * @param ediStsSeq
	 */
	public void setEdiStsSeq(String ediStsSeq) {
		this.ediStsSeq = ediStsSeq;
	}
	
	/**
	 * Column Info
	 * @param mycust
	 */
	public void setMycust(String mycust) {
		this.mycust = mycust;
	}
	
	/**
	 * Column Info
	 * @param csGrpId
	 */
	public void setCsGrpId(String csGrpId) {
		this.csGrpId = csGrpId;
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
		setEdiCgoRmk(JSPUtil.getParameter(request, prefix + "edi_cgo_rmk", ""));
		setEdiSts(JSPUtil.getParameter(request, prefix + "edi_sts", ""));
		setEdiStsCon(JSPUtil.getParameter(request, prefix + "edi_sts_con", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setEdiGrpDesc(JSPUtil.getParameter(request, prefix + "edi_grp_desc", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEdiGrpCd(JSPUtil.getParameter(request, prefix + "edi_grp_cd", ""));
		setCustTrdPrnrId(JSPUtil.getParameter(request, prefix + "cust_trd_prnr_id", ""));
		setBzcCol(JSPUtil.getParameter(request, prefix + "bzc_col", ""));
		setEdiStsSeq(JSPUtil.getParameter(request, prefix + "edi_sts_seq", ""));
		setMycust(JSPUtil.getParameter(request, prefix + "mycust", ""));
		setCsGrpId(JSPUtil.getParameter(request, prefix + "cs_grp_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCustomerInfoVO[]
	 */
	public SearchCustomerInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCustomerInfoVO[]
	 */
	public SearchCustomerInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchCustomerInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ediCgoRmk = (JSPUtil.getParameter(request, prefix	+ "edi_cgo_rmk", length));
			String[] ediSts = (JSPUtil.getParameter(request, prefix	+ "edi_sts", length));
			String[] ediStsCon = (JSPUtil.getParameter(request, prefix	+ "edi_sts_con", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ediGrpDesc = (JSPUtil.getParameter(request, prefix	+ "edi_grp_desc", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ediGrpCd = (JSPUtil.getParameter(request, prefix	+ "edi_grp_cd", length));
			String[] custTrdPrnrId = (JSPUtil.getParameter(request, prefix	+ "cust_trd_prnr_id", length));
			String[] bzcCol = (JSPUtil.getParameter(request, prefix	+ "bzc_col", length));
			String[] ediStsSeq = (JSPUtil.getParameter(request, prefix	+ "edi_sts_seq", length));
			String[] mycust = (JSPUtil.getParameter(request, prefix	+ "mycust", length));
			String[] csGrpId = (JSPUtil.getParameter(request, prefix	+ "cs_grp_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchCustomerInfoVO();
				if (ediCgoRmk[i] != null)
					model.setEdiCgoRmk(ediCgoRmk[i]);
				if (ediSts[i] != null)
					model.setEdiSts(ediSts[i]);
				if (ediStsCon[i] != null)
					model.setEdiStsCon(ediStsCon[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ediGrpDesc[i] != null)
					model.setEdiGrpDesc(ediGrpDesc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ediGrpCd[i] != null)
					model.setEdiGrpCd(ediGrpCd[i]);
				if (custTrdPrnrId[i] != null)
					model.setCustTrdPrnrId(custTrdPrnrId[i]);
				if (bzcCol[i] != null)
					model.setBzcCol(bzcCol[i]);
				if (ediStsSeq[i] != null)
					model.setEdiStsSeq(ediStsSeq[i]);
				if (mycust[i] != null)
					model.setMycust(mycust[i]);
				if (csGrpId[i] != null)
					model.setCsGrpId(csGrpId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchCustomerInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchCustomerInfoVO[]
	 */
	public SearchCustomerInfoVO[] getSearchCustomerInfoVOs(){
		SearchCustomerInfoVO[] vos = (SearchCustomerInfoVO[])models.toArray(new SearchCustomerInfoVO[models.size()]);
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
		this.ediCgoRmk = this.ediCgoRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSts = this.ediSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediStsCon = this.ediStsCon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediGrpDesc = this.ediGrpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediGrpCd = this.ediGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTrdPrnrId = this.custTrdPrnrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcCol = this.bzcCol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediStsSeq = this.ediStsSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mycust = this.mycust .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csGrpId = this.csGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
