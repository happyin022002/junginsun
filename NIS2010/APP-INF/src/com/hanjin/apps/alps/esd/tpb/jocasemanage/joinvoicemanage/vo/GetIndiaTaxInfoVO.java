/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GetIndiaTaxInfoVO.java
*@FileTitle : GetIndiaTaxInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.10
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2009.11.10 박성진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.vo;

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
 * @author 박성진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class GetIndiaTaxInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GetIndiaTaxInfoVO> models = new ArrayList<GetIndiaTaxInfoVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String expnTax = null;
	/* Column Info */
	private String eduTax = null;
	/* Column Info */
	private String taxRgstNo = null;
	/* Column Info */
	private String highEduTax = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String idaTaxSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String svcCateRmk = null;
	/* Column Info */
	private String pmntAcctNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public GetIndiaTaxInfoVO() {}

	public GetIndiaTaxInfoVO(String ibflag, String pagerows, String updDt, String creDt, String expnTax, String eduTax, String taxRgstNo, String highEduTax, String ofcCd, String effDt, String creUsrId, String idaTaxSeq, String updUsrId, String svcCateRmk, String pmntAcctNo) {
		this.updDt = updDt;
		this.creDt = creDt;
		this.expnTax = expnTax;
		this.eduTax = eduTax;
		this.taxRgstNo = taxRgstNo;
		this.highEduTax = highEduTax;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.creUsrId = creUsrId;
		this.idaTaxSeq = idaTaxSeq;
		this.updUsrId = updUsrId;
		this.svcCateRmk = svcCateRmk;
		this.pmntAcctNo = pmntAcctNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("expn_tax", getExpnTax());
		this.hashColumns.put("edu_tax", getEduTax());
		this.hashColumns.put("tax_rgst_no", getTaxRgstNo());
		this.hashColumns.put("high_edu_tax", getHighEduTax());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ida_tax_seq", getIdaTaxSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("svc_cate_rmk", getSvcCateRmk());
		this.hashColumns.put("pmnt_acct_no", getPmntAcctNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("expn_tax", "expnTax");
		this.hashFields.put("edu_tax", "eduTax");
		this.hashFields.put("tax_rgst_no", "taxRgstNo");
		this.hashFields.put("high_edu_tax", "highEduTax");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ida_tax_seq", "idaTaxSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("svc_cate_rmk", "svcCateRmk");
		this.hashFields.put("pmnt_acct_no", "pmntAcctNo");
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return expnTax
	 */
	public String getExpnTax() {
		return this.expnTax;
	}
	
	/**
	 * Column Info
	 * @return eduTax
	 */
	public String getEduTax() {
		return this.eduTax;
	}
	
	/**
	 * Column Info
	 * @return taxRgstNo
	 */
	public String getTaxRgstNo() {
		return this.taxRgstNo;
	}
	
	/**
	 * Column Info
	 * @return highEduTax
	 */
	public String getHighEduTax() {
		return this.highEduTax;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return idaTaxSeq
	 */
	public String getIdaTaxSeq() {
		return this.idaTaxSeq;
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
	 * @return svcCateRmk
	 */
	public String getSvcCateRmk() {
		return this.svcCateRmk;
	}
	
	/**
	 * Column Info
	 * @return pmntAcctNo
	 */
	public String getPmntAcctNo() {
		return this.pmntAcctNo;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param expnTax
	 */
	public void setExpnTax(String expnTax) {
		this.expnTax = expnTax;
	}
	
	/**
	 * Column Info
	 * @param eduTax
	 */
	public void setEduTax(String eduTax) {
		this.eduTax = eduTax;
	}
	
	/**
	 * Column Info
	 * @param taxRgstNo
	 */
	public void setTaxRgstNo(String taxRgstNo) {
		this.taxRgstNo = taxRgstNo;
	}
	
	/**
	 * Column Info
	 * @param highEduTax
	 */
	public void setHighEduTax(String highEduTax) {
		this.highEduTax = highEduTax;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param idaTaxSeq
	 */
	public void setIdaTaxSeq(String idaTaxSeq) {
		this.idaTaxSeq = idaTaxSeq;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param svcCateRmk
	 */
	public void setSvcCateRmk(String svcCateRmk) {
		this.svcCateRmk = svcCateRmk;
	}
	
	/**
	 * Column Info
	 * @param pmntAcctNo
	 */
	public void setPmntAcctNo(String pmntAcctNo) {
		this.pmntAcctNo = pmntAcctNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setExpnTax(JSPUtil.getParameter(request, "expn_tax", ""));
		setEduTax(JSPUtil.getParameter(request, "edu_tax", ""));
		setTaxRgstNo(JSPUtil.getParameter(request, "tax_rgst_no", ""));
		setHighEduTax(JSPUtil.getParameter(request, "high_edu_tax", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIdaTaxSeq(JSPUtil.getParameter(request, "ida_tax_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setSvcCateRmk(JSPUtil.getParameter(request, "svc_cate_rmk", ""));
		setPmntAcctNo(JSPUtil.getParameter(request, "pmnt_acct_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GetIndiaTaxInfoVO[]
	 */
	public GetIndiaTaxInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GetIndiaTaxInfoVO[]
	 */
	public GetIndiaTaxInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GetIndiaTaxInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] expnTax = (JSPUtil.getParameter(request, prefix	+ "expn_tax", length));
			String[] eduTax = (JSPUtil.getParameter(request, prefix	+ "edu_tax", length));
			String[] taxRgstNo = (JSPUtil.getParameter(request, prefix	+ "tax_rgst_no", length));
			String[] highEduTax = (JSPUtil.getParameter(request, prefix	+ "high_edu_tax", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] idaTaxSeq = (JSPUtil.getParameter(request, prefix	+ "ida_tax_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] svcCateRmk = (JSPUtil.getParameter(request, prefix	+ "svc_cate_rmk", length));
			String[] pmntAcctNo = (JSPUtil.getParameter(request, prefix	+ "pmnt_acct_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new GetIndiaTaxInfoVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (expnTax[i] != null)
					model.setExpnTax(expnTax[i]);
				if (eduTax[i] != null)
					model.setEduTax(eduTax[i]);
				if (taxRgstNo[i] != null)
					model.setTaxRgstNo(taxRgstNo[i]);
				if (highEduTax[i] != null)
					model.setHighEduTax(highEduTax[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (idaTaxSeq[i] != null)
					model.setIdaTaxSeq(idaTaxSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (svcCateRmk[i] != null)
					model.setSvcCateRmk(svcCateRmk[i]);
				if (pmntAcctNo[i] != null)
					model.setPmntAcctNo(pmntAcctNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGetIndiaTaxInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GetIndiaTaxInfoVO[]
	 */
	public GetIndiaTaxInfoVO[] getGetIndiaTaxInfoVOs(){
		GetIndiaTaxInfoVO[] vos = (GetIndiaTaxInfoVO[])models.toArray(new GetIndiaTaxInfoVO[models.size()]);
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
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expnTax = this.expnTax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eduTax = this.eduTax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxRgstNo = this.taxRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.highEduTax = this.highEduTax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaTaxSeq = this.idaTaxSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcCateRmk = this.svcCateRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pmntAcctNo = this.pmntAcctNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
