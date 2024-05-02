/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PopCustomerListVO.java
*@FileTitle : PopCustomerListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.16
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.12.16 한동훈 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo;

import java.lang.reflect.Field;
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
 * @author 한동훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PopCustomerListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PopCustomerListVO> models = new ArrayList<PopCustomerListVO>();
	
	/* Column Info */
	private String slsDeltEffDt = null;
	/* Column Info */
	private String loclNm = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String custRgstNo = null;
	/* Column Info */
	private String bzetAddr = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String crCltOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String zipCd = null;
	/* Column Info */
	private String custCode = null;
	/* Column Info */
	private String actCustCntCd = null;
	/* Column Info */
	private String custCntCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PopCustomerListVO() {}

	public PopCustomerListVO(String ibflag, String pagerows, String custCode, String actCustCntCd, String custLglEngNm, String bzetAddr, String zipCd, String crCltOfcCd, String custCntCd, String custSeq, String loclNm, String custRgstNo, String deltFlg, String slsDeltEffDt) {
		this.slsDeltEffDt = slsDeltEffDt;
		this.loclNm = loclNm;
		this.deltFlg = deltFlg;
		this.custRgstNo = custRgstNo;
		this.bzetAddr = bzetAddr;
		this.custSeq = custSeq;
		this.crCltOfcCd = crCltOfcCd;
		this.pagerows = pagerows;
		this.custLglEngNm = custLglEngNm;
		this.ibflag = ibflag;
		this.zipCd = zipCd;
		this.custCode = custCode;
		this.actCustCntCd = actCustCntCd;
		this.custCntCd = custCntCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sls_delt_eff_dt", getSlsDeltEffDt());
		this.hashColumns.put("locl_nm", getLoclNm());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cust_rgst_no", getCustRgstNo());
		this.hashColumns.put("bzet_addr", getBzetAddr());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cr_clt_ofc_cd", getCrCltOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("zip_cd", getZipCd());
		this.hashColumns.put("cust_code", getCustCode());
		this.hashColumns.put("act_cust_cnt_cd", getActCustCntCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sls_delt_eff_dt", "slsDeltEffDt");
		this.hashFields.put("locl_nm", "loclNm");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cust_rgst_no", "custRgstNo");
		this.hashFields.put("bzet_addr", "bzetAddr");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cr_clt_ofc_cd", "crCltOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("zip_cd", "zipCd");
		this.hashFields.put("cust_code", "custCode");
		this.hashFields.put("act_cust_cnt_cd", "actCustCntCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return slsDeltEffDt
	 */
	public String getSlsDeltEffDt() {
		return this.slsDeltEffDt;
	}
	
	/**
	 * Column Info
	 * @return loclNm
	 */
	public String getLoclNm() {
		return this.loclNm;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return custRgstNo
	 */
	public String getCustRgstNo() {
		return this.custRgstNo;
	}
	
	/**
	 * Column Info
	 * @return bzetAddr
	 */
	public String getBzetAddr() {
		return this.bzetAddr;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return crCltOfcCd
	 */
	public String getCrCltOfcCd() {
		return this.crCltOfcCd;
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
	 * @return custLglEngNm
	 */
	public String getCustLglEngNm() {
		return this.custLglEngNm;
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
	 * @return zipCd
	 */
	public String getZipCd() {
		return this.zipCd;
	}
	
	/**
	 * Column Info
	 * @return custCode
	 */
	public String getCustCode() {
		return this.custCode;
	}
	
	/**
	 * Column Info
	 * @return actCustCntCd
	 */
	public String getActCustCntCd() {
		return this.actCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	

	/**
	 * Column Info
	 * @param slsDeltEffDt
	 */
	public void setSlsDeltEffDt(String slsDeltEffDt) {
		this.slsDeltEffDt = slsDeltEffDt;
	}
	
	/**
	 * Column Info
	 * @param loclNm
	 */
	public void setLoclNm(String loclNm) {
		this.loclNm = loclNm;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param custRgstNo
	 */
	public void setCustRgstNo(String custRgstNo) {
		this.custRgstNo = custRgstNo;
	}
	
	/**
	 * Column Info
	 * @param bzetAddr
	 */
	public void setBzetAddr(String bzetAddr) {
		this.bzetAddr = bzetAddr;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param crCltOfcCd
	 */
	public void setCrCltOfcCd(String crCltOfcCd) {
		this.crCltOfcCd = crCltOfcCd;
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
	 * @param custLglEngNm
	 */
	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
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
	 * @param zipCd
	 */
	public void setZipCd(String zipCd) {
		this.zipCd = zipCd;
	}
	
	/**
	 * Column Info
	 * @param custCode
	 */
	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}
	
	/**
	 * Column Info
	 * @param actCustCntCd
	 */
	public void setActCustCntCd(String actCustCntCd) {
		this.actCustCntCd = actCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSlsDeltEffDt(JSPUtil.getParameter(request, "sls_delt_eff_dt", ""));
		setLoclNm(JSPUtil.getParameter(request, "locl_nm", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setCustRgstNo(JSPUtil.getParameter(request, "cust_rgst_no", ""));
		setBzetAddr(JSPUtil.getParameter(request, "bzet_addr", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setCrCltOfcCd(JSPUtil.getParameter(request, "cr_clt_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, "cust_lgl_eng_nm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setZipCd(JSPUtil.getParameter(request, "zip_cd", ""));
		setCustCode(JSPUtil.getParameter(request, "cust_code", ""));
		setActCustCntCd(JSPUtil.getParameter(request, "act_cust_cnt_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PopCustomerListVO[]
	 */
	public PopCustomerListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PopCustomerListVO[]
	 */
	public PopCustomerListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PopCustomerListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] slsDeltEffDt = (JSPUtil.getParameter(request, prefix	+ "sls_delt_eff_dt", length));
			String[] loclNm = (JSPUtil.getParameter(request, prefix	+ "locl_nm", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] custRgstNo = (JSPUtil.getParameter(request, prefix	+ "cust_rgst_no", length));
			String[] bzetAddr = (JSPUtil.getParameter(request, prefix	+ "bzet_addr", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] crCltOfcCd = (JSPUtil.getParameter(request, prefix	+ "cr_clt_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] zipCd = (JSPUtil.getParameter(request, prefix	+ "zip_cd", length));
			String[] custCode = (JSPUtil.getParameter(request, prefix	+ "cust_code", length));
			String[] actCustCntCd = (JSPUtil.getParameter(request, prefix	+ "act_cust_cnt_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new PopCustomerListVO();
				if (slsDeltEffDt[i] != null)
					model.setSlsDeltEffDt(slsDeltEffDt[i]);
				if (loclNm[i] != null)
					model.setLoclNm(loclNm[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (custRgstNo[i] != null)
					model.setCustRgstNo(custRgstNo[i]);
				if (bzetAddr[i] != null)
					model.setBzetAddr(bzetAddr[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (crCltOfcCd[i] != null)
					model.setCrCltOfcCd(crCltOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (zipCd[i] != null)
					model.setZipCd(zipCd[i]);
				if (custCode[i] != null)
					model.setCustCode(custCode[i]);
				if (actCustCntCd[i] != null)
					model.setActCustCntCd(actCustCntCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPopCustomerListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PopCustomerListVO[]
	 */
	public PopCustomerListVO[] getPopCustomerListVOs(){
		PopCustomerListVO[] vos = (PopCustomerListVO[])models.toArray(new PopCustomerListVO[models.size()]);
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
		this.slsDeltEffDt = this.slsDeltEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclNm = this.loclNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRgstNo = this.custRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzetAddr = this.bzetAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crCltOfcCd = this.crCltOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zipCd = this.zipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCode = this.custCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCntCd = this.actCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
