/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchCustomerNameVO.java
*@FileTitle : SearchCustomerNameVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.14
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.08.14 박정진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박정진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchCustomerNameVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchCustomerNameVO> models = new ArrayList<SearchCustomerNameVO>();
	
	/* Column Info */
	private String bzctNm = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String bztpNm = null;
	/* Column Info */
	private String custRgstNo = null;
	/* Column Info */
	private String obCrTermDys = null;
	/* Column Info */
	private String crCltOfcCd = null;
	/* Column Info */
	private String obFaxNo = null;
	/* Column Info */
	private String ibFaxNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ibCrTermDys = null;
	/* Column Info */
	private String obPhnNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String crAmt = null;
	/* Column Info */
	private String cntcPsonNm = null;
	/* Column Info */
	private String ibPhnNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchCustomerNameVO() {}

	public SearchCustomerNameVO(String ibflag, String pagerows, String crAmt, String ibCrTermDys, String obCrTermDys, String crCltOfcCd, String custNm, String obPhnNo, String ibPhnNo, String obFaxNo, String ibFaxNo, String cntcPsonNm, String bzctNm, String bztpNm, String custRgstNo, String deltFlg) {
		this.bzctNm = bzctNm;
		this.custNm = custNm;
		this.deltFlg = deltFlg;
		this.bztpNm = bztpNm;
		this.custRgstNo = custRgstNo;
		this.obCrTermDys = obCrTermDys;
		this.crCltOfcCd = crCltOfcCd;
		this.obFaxNo = obFaxNo;
		this.ibFaxNo = ibFaxNo;
		this.pagerows = pagerows;
		this.ibCrTermDys = ibCrTermDys;
		this.obPhnNo = obPhnNo;
		this.ibflag = ibflag;
		this.crAmt = crAmt;
		this.cntcPsonNm = cntcPsonNm;
		this.ibPhnNo = ibPhnNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bzct_nm", getBzctNm());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("bztp_nm", getBztpNm());
		this.hashColumns.put("cust_rgst_no", getCustRgstNo());
		this.hashColumns.put("ob_cr_term_dys", getObCrTermDys());
		this.hashColumns.put("cr_clt_ofc_cd", getCrCltOfcCd());
		this.hashColumns.put("ob_fax_no", getObFaxNo());
		this.hashColumns.put("ib_fax_no", getIbFaxNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ib_cr_term_dys", getIbCrTermDys());
		this.hashColumns.put("ob_phn_no", getObPhnNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cr_amt", getCrAmt());
		this.hashColumns.put("cntc_pson_nm", getCntcPsonNm());
		this.hashColumns.put("ib_phn_no", getIbPhnNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bzct_nm", "bzctNm");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("bztp_nm", "bztpNm");
		this.hashFields.put("cust_rgst_no", "custRgstNo");
		this.hashFields.put("ob_cr_term_dys", "obCrTermDys");
		this.hashFields.put("cr_clt_ofc_cd", "crCltOfcCd");
		this.hashFields.put("ob_fax_no", "obFaxNo");
		this.hashFields.put("ib_fax_no", "ibFaxNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ib_cr_term_dys", "ibCrTermDys");
		this.hashFields.put("ob_phn_no", "obPhnNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cr_amt", "crAmt");
		this.hashFields.put("cntc_pson_nm", "cntcPsonNm");
		this.hashFields.put("ib_phn_no", "ibPhnNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bzctNm
	 */
	public String getBzctNm() {
		return this.bzctNm;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
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
	 * @return bztpNm
	 */
	public String getBztpNm() {
		return this.bztpNm;
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
	 * @return obCrTermDys
	 */
	public String getObCrTermDys() {
		return this.obCrTermDys;
	}
	
	/**
	 * Column Info
	 * @return crCltOfcCd
	 */
	public String getCrCltOfcCd() {
		return this.crCltOfcCd;
	}
	
	/**
	 * Column Info
	 * @return obFaxNo
	 */
	public String getObFaxNo() {
		return this.obFaxNo;
	}
	
	/**
	 * Column Info
	 * @return ibFaxNo
	 */
	public String getIbFaxNo() {
		return this.ibFaxNo;
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
	 * @return ibCrTermDys
	 */
	public String getIbCrTermDys() {
		return this.ibCrTermDys;
	}
	
	/**
	 * Column Info
	 * @return obPhnNo
	 */
	public String getObPhnNo() {
		return this.obPhnNo;
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
	 * @return crAmt
	 */
	public String getCrAmt() {
		return this.crAmt;
	}
	
	/**
	 * Column Info
	 * @return cntcPsonNm
	 */
	public String getCntcPsonNm() {
		return this.cntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @return ibPhnNo
	 */
	public String getIbPhnNo() {
		return this.ibPhnNo;
	}
	

	/**
	 * Column Info
	 * @param bzctNm
	 */
	public void setBzctNm(String bzctNm) {
		this.bzctNm = bzctNm;
	}
	
	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
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
	 * @param bztpNm
	 */
	public void setBztpNm(String bztpNm) {
		this.bztpNm = bztpNm;
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
	 * @param obCrTermDys
	 */
	public void setObCrTermDys(String obCrTermDys) {
		this.obCrTermDys = obCrTermDys;
	}
	
	/**
	 * Column Info
	 * @param crCltOfcCd
	 */
	public void setCrCltOfcCd(String crCltOfcCd) {
		this.crCltOfcCd = crCltOfcCd;
	}
	
	/**
	 * Column Info
	 * @param obFaxNo
	 */
	public void setObFaxNo(String obFaxNo) {
		this.obFaxNo = obFaxNo;
	}
	
	/**
	 * Column Info
	 * @param ibFaxNo
	 */
	public void setIbFaxNo(String ibFaxNo) {
		this.ibFaxNo = ibFaxNo;
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
	 * @param ibCrTermDys
	 */
	public void setIbCrTermDys(String ibCrTermDys) {
		this.ibCrTermDys = ibCrTermDys;
	}
	
	/**
	 * Column Info
	 * @param obPhnNo
	 */
	public void setObPhnNo(String obPhnNo) {
		this.obPhnNo = obPhnNo;
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
	 * @param crAmt
	 */
	public void setCrAmt(String crAmt) {
		this.crAmt = crAmt;
	}
	
	/**
	 * Column Info
	 * @param cntcPsonNm
	 */
	public void setCntcPsonNm(String cntcPsonNm) {
		this.cntcPsonNm = cntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @param ibPhnNo
	 */
	public void setIbPhnNo(String ibPhnNo) {
		this.ibPhnNo = ibPhnNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBzctNm(JSPUtil.getParameter(request, "bzct_nm", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setBztpNm(JSPUtil.getParameter(request, "bztp_nm", ""));
		setCustRgstNo(JSPUtil.getParameter(request, "cust_rgst_no", ""));
		setObCrTermDys(JSPUtil.getParameter(request, "ob_cr_term_dys", ""));
		setCrCltOfcCd(JSPUtil.getParameter(request, "cr_clt_ofc_cd", ""));
		setObFaxNo(JSPUtil.getParameter(request, "ob_fax_no", ""));
		setIbFaxNo(JSPUtil.getParameter(request, "ib_fax_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbCrTermDys(JSPUtil.getParameter(request, "ib_cr_term_dys", ""));
		setObPhnNo(JSPUtil.getParameter(request, "ob_phn_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCrAmt(JSPUtil.getParameter(request, "cr_amt", ""));
		setCntcPsonNm(JSPUtil.getParameter(request, "cntc_pson_nm", ""));
		setIbPhnNo(JSPUtil.getParameter(request, "ib_phn_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCustomerNameVO[]
	 */
	public SearchCustomerNameVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCustomerNameVO[]
	 */
	public SearchCustomerNameVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchCustomerNameVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bzctNm = (JSPUtil.getParameter(request, prefix	+ "bzct_nm", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] bztpNm = (JSPUtil.getParameter(request, prefix	+ "bztp_nm", length));
			String[] custRgstNo = (JSPUtil.getParameter(request, prefix	+ "cust_rgst_no", length));
			String[] obCrTermDys = (JSPUtil.getParameter(request, prefix	+ "ob_cr_term_dys", length));
			String[] crCltOfcCd = (JSPUtil.getParameter(request, prefix	+ "cr_clt_ofc_cd", length));
			String[] obFaxNo = (JSPUtil.getParameter(request, prefix	+ "ob_fax_no", length));
			String[] ibFaxNo = (JSPUtil.getParameter(request, prefix	+ "ib_fax_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibCrTermDys = (JSPUtil.getParameter(request, prefix	+ "ib_cr_term_dys", length));
			String[] obPhnNo = (JSPUtil.getParameter(request, prefix	+ "ob_phn_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] crAmt = (JSPUtil.getParameter(request, prefix	+ "cr_amt", length));
			String[] cntcPsonNm = (JSPUtil.getParameter(request, prefix	+ "cntc_pson_nm", length));
			String[] ibPhnNo = (JSPUtil.getParameter(request, prefix	+ "ib_phn_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchCustomerNameVO();
				if (bzctNm[i] != null)
					model.setBzctNm(bzctNm[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (bztpNm[i] != null)
					model.setBztpNm(bztpNm[i]);
				if (custRgstNo[i] != null)
					model.setCustRgstNo(custRgstNo[i]);
				if (obCrTermDys[i] != null)
					model.setObCrTermDys(obCrTermDys[i]);
				if (crCltOfcCd[i] != null)
					model.setCrCltOfcCd(crCltOfcCd[i]);
				if (obFaxNo[i] != null)
					model.setObFaxNo(obFaxNo[i]);
				if (ibFaxNo[i] != null)
					model.setIbFaxNo(ibFaxNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibCrTermDys[i] != null)
					model.setIbCrTermDys(ibCrTermDys[i]);
				if (obPhnNo[i] != null)
					model.setObPhnNo(obPhnNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (crAmt[i] != null)
					model.setCrAmt(crAmt[i]);
				if (cntcPsonNm[i] != null)
					model.setCntcPsonNm(cntcPsonNm[i]);
				if (ibPhnNo[i] != null)
					model.setIbPhnNo(ibPhnNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchCustomerNameVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchCustomerNameVO[]
	 */
	public SearchCustomerNameVO[] getSearchCustomerNameVOs(){
		SearchCustomerNameVO[] vos = (SearchCustomerNameVO[])models.toArray(new SearchCustomerNameVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.bzctNm = this.bzctNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bztpNm = this.bztpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRgstNo = this.custRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obCrTermDys = this.obCrTermDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crCltOfcCd = this.crCltOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obFaxNo = this.obFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibFaxNo = this.ibFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibCrTermDys = this.ibCrTermDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obPhnNo = this.obPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crAmt = this.crAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonNm = this.cntcPsonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibPhnNo = this.ibPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
