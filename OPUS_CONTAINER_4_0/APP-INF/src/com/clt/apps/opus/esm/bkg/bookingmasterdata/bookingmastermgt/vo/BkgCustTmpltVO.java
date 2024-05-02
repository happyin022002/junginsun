/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgCustTmpltVO.java
*@FileTitle : BkgCustTmpltVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.21
*@LastModifier : 
*@LastVersion : 1.0
* 2010.06.21  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgCustTmpltVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgCustTmpltVO> models = new ArrayList<BkgCustTmpltVO>();
	
	/* Column Info */
	private String eurCstmsStNm = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String cstmsDeclCntCd = null;
	/* Column Info */
	private String custAddr = null;
	/* Column Info */
	private String pic = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String custEml = null;
	/* Column Info */
	private String custCtyNm = null;
	/* Column Info */
	private String custZipCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tmpltSeq = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String tmpltRmk = null;
	/* Column Info */
	private String custFaxNo = null;
	/* Column Info */
	private String custPhnNo = null;
	/* Column Info */
	private String eoriNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String custSteCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgCustTmpltVO() {}

	public BkgCustTmpltVO(String ibflag, String pagerows, String custCntCd, String custSeq, String tmpltSeq, String custNm, String custAddr, String custPhnNo, String pic, String creUsrId, String custFaxNo, String custCtyNm, String custSteCd, String custZipCd, String custEml, String tmpltRmk, String updUsrId, String cstmsDeclCntCd, String eurCstmsStNm, String eoriNo) {
		this.eurCstmsStNm = eurCstmsStNm;
		this.custNm = custNm;
		this.cstmsDeclCntCd = cstmsDeclCntCd;
		this.custAddr = custAddr;
		this.pic = pic;
		this.custSeq = custSeq;
		this.custEml = custEml;
		this.custCtyNm = custCtyNm;
		this.custZipCd = custZipCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.tmpltSeq = tmpltSeq;
		this.creUsrId = creUsrId;
		this.tmpltRmk = tmpltRmk;
		this.custFaxNo = custFaxNo;
		this.custPhnNo = custPhnNo;
		this.eoriNo = eoriNo;
		this.updUsrId = updUsrId;
		this.custCntCd = custCntCd;
		this.custSteCd = custSteCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eur_cstms_st_nm", getEurCstmsStNm());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("cstms_decl_cnt_cd", getCstmsDeclCntCd());
		this.hashColumns.put("cust_addr", getCustAddr());
		this.hashColumns.put("pic", getPic());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cust_eml", getCustEml());
		this.hashColumns.put("cust_cty_nm", getCustCtyNm());
		this.hashColumns.put("cust_zip_cd", getCustZipCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tmplt_seq", getTmpltSeq());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("tmplt_rmk", getTmpltRmk());
		this.hashColumns.put("cust_fax_no", getCustFaxNo());
		this.hashColumns.put("cust_phn_no", getCustPhnNo());
		this.hashColumns.put("eori_no", getEoriNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cust_ste_cd", getCustSteCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eur_cstms_st_nm", "eurCstmsStNm");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("cstms_decl_cnt_cd", "cstmsDeclCntCd");
		this.hashFields.put("cust_addr", "custAddr");
		this.hashFields.put("pic", "pic");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cust_eml", "custEml");
		this.hashFields.put("cust_cty_nm", "custCtyNm");
		this.hashFields.put("cust_zip_cd", "custZipCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tmplt_seq", "tmpltSeq");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("tmplt_rmk", "tmpltRmk");
		this.hashFields.put("cust_fax_no", "custFaxNo");
		this.hashFields.put("cust_phn_no", "custPhnNo");
		this.hashFields.put("eori_no", "eoriNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cust_ste_cd", "custSteCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return eurCstmsStNm
	 */
	public String getEurCstmsStNm() {
		return this.eurCstmsStNm;
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
	 * @return cstmsDeclCntCd
	 */
	public String getCstmsDeclCntCd() {
		return this.cstmsDeclCntCd;
	}
	
	/**
	 * Column Info
	 * @return custAddr
	 */
	public String getCustAddr() {
		return this.custAddr;
	}
	
	/**
	 * Column Info
	 * @return pic
	 */
	public String getPic() {
		return this.pic;
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
	 * @return custEml
	 */
	public String getCustEml() {
		return this.custEml;
	}
	
	/**
	 * Column Info
	 * @return custCtyNm
	 */
	public String getCustCtyNm() {
		return this.custCtyNm;
	}
	
	/**
	 * Column Info
	 * @return custZipCd
	 */
	public String getCustZipCd() {
		return this.custZipCd;
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
	 * @return tmpltSeq
	 */
	public String getTmpltSeq() {
		return this.tmpltSeq;
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
	 * @return tmpltRmk
	 */
	public String getTmpltRmk() {
		return this.tmpltRmk;
	}
	
	/**
	 * Column Info
	 * @return custFaxNo
	 */
	public String getCustFaxNo() {
		return this.custFaxNo;
	}
	
	/**
	 * Column Info
	 * @return custPhnNo
	 */
	public String getCustPhnNo() {
		return this.custPhnNo;
	}
	
	/**
	 * Column Info
	 * @return eoriNo
	 */
	public String getEoriNo() {
		return this.eoriNo;
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
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return custSteCd
	 */
	public String getCustSteCd() {
		return this.custSteCd;
	}
	

	/**
	 * Column Info
	 * @param eurCstmsStNm
	 */
	public void setEurCstmsStNm(String eurCstmsStNm) {
		this.eurCstmsStNm = eurCstmsStNm;
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
	 * @param cstmsDeclCntCd
	 */
	public void setCstmsDeclCntCd(String cstmsDeclCntCd) {
		this.cstmsDeclCntCd = cstmsDeclCntCd;
	}
	
	/**
	 * Column Info
	 * @param custAddr
	 */
	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
	}
	
	/**
	 * Column Info
	 * @param pic
	 */
	public void setPic(String pic) {
		this.pic = pic;
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
	 * @param custEml
	 */
	public void setCustEml(String custEml) {
		this.custEml = custEml;
	}
	
	/**
	 * Column Info
	 * @param custCtyNm
	 */
	public void setCustCtyNm(String custCtyNm) {
		this.custCtyNm = custCtyNm;
	}
	
	/**
	 * Column Info
	 * @param custZipCd
	 */
	public void setCustZipCd(String custZipCd) {
		this.custZipCd = custZipCd;
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
	 * @param tmpltSeq
	 */
	public void setTmpltSeq(String tmpltSeq) {
		this.tmpltSeq = tmpltSeq;
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
	 * @param tmpltRmk
	 */
	public void setTmpltRmk(String tmpltRmk) {
		this.tmpltRmk = tmpltRmk;
	}
	
	/**
	 * Column Info
	 * @param custFaxNo
	 */
	public void setCustFaxNo(String custFaxNo) {
		this.custFaxNo = custFaxNo;
	}
	
	/**
	 * Column Info
	 * @param custPhnNo
	 */
	public void setCustPhnNo(String custPhnNo) {
		this.custPhnNo = custPhnNo;
	}
	
	/**
	 * Column Info
	 * @param eoriNo
	 */
	public void setEoriNo(String eoriNo) {
		this.eoriNo = eoriNo;
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
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param custSteCd
	 */
	public void setCustSteCd(String custSteCd) {
		this.custSteCd = custSteCd;
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
		setEurCstmsStNm(JSPUtil.getParameter(request, prefix + "eur_cstms_st_nm", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setCstmsDeclCntCd(JSPUtil.getParameter(request, prefix + "cstms_decl_cnt_cd", ""));
		setCustAddr(JSPUtil.getParameter(request, prefix + "cust_addr", ""));
		setPic(JSPUtil.getParameter(request, prefix + "pic", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setCustEml(JSPUtil.getParameter(request, prefix + "cust_eml", ""));
		setCustCtyNm(JSPUtil.getParameter(request, prefix + "cust_cty_nm", ""));
		setCustZipCd(JSPUtil.getParameter(request, prefix + "cust_zip_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTmpltSeq(JSPUtil.getParameter(request, prefix + "tmplt_seq", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setTmpltRmk(JSPUtil.getParameter(request, prefix + "tmplt_rmk", ""));
		setCustFaxNo(JSPUtil.getParameter(request, prefix + "cust_fax_no", ""));
		setCustPhnNo(JSPUtil.getParameter(request, prefix + "cust_phn_no", ""));
		setEoriNo(JSPUtil.getParameter(request, prefix + "eori_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setCustSteCd(JSPUtil.getParameter(request, prefix + "cust_ste_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCustTmpltVO[]
	 */
	public BkgCustTmpltVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgCustTmpltVO[]
	 */
	public BkgCustTmpltVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgCustTmpltVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] eurCstmsStNm = (JSPUtil.getParameter(request, prefix	+ "eur_cstms_st_nm", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] cstmsDeclCntCd = (JSPUtil.getParameter(request, prefix	+ "cstms_decl_cnt_cd", length));
			String[] custAddr = (JSPUtil.getParameter(request, prefix	+ "cust_addr", length));
			String[] pic = (JSPUtil.getParameter(request, prefix	+ "pic", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] custEml = (JSPUtil.getParameter(request, prefix	+ "cust_eml", length));
			String[] custCtyNm = (JSPUtil.getParameter(request, prefix	+ "cust_cty_nm", length));
			String[] custZipCd = (JSPUtil.getParameter(request, prefix	+ "cust_zip_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tmpltSeq = (JSPUtil.getParameter(request, prefix	+ "tmplt_seq", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] tmpltRmk = (JSPUtil.getParameter(request, prefix	+ "tmplt_rmk", length));
			String[] custFaxNo = (JSPUtil.getParameter(request, prefix	+ "cust_fax_no", length));
			String[] custPhnNo = (JSPUtil.getParameter(request, prefix	+ "cust_phn_no", length));
			String[] eoriNo = (JSPUtil.getParameter(request, prefix	+ "eori_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] custSteCd = (JSPUtil.getParameter(request, prefix	+ "cust_ste_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgCustTmpltVO();
				if (eurCstmsStNm[i] != null)
					model.setEurCstmsStNm(eurCstmsStNm[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (cstmsDeclCntCd[i] != null)
					model.setCstmsDeclCntCd(cstmsDeclCntCd[i]);
				if (custAddr[i] != null)
					model.setCustAddr(custAddr[i]);
				if (pic[i] != null)
					model.setPic(pic[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (custEml[i] != null)
					model.setCustEml(custEml[i]);
				if (custCtyNm[i] != null)
					model.setCustCtyNm(custCtyNm[i]);
				if (custZipCd[i] != null)
					model.setCustZipCd(custZipCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tmpltSeq[i] != null)
					model.setTmpltSeq(tmpltSeq[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (tmpltRmk[i] != null)
					model.setTmpltRmk(tmpltRmk[i]);
				if (custFaxNo[i] != null)
					model.setCustFaxNo(custFaxNo[i]);
				if (custPhnNo[i] != null)
					model.setCustPhnNo(custPhnNo[i]);
				if (eoriNo[i] != null)
					model.setEoriNo(eoriNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (custSteCd[i] != null)
					model.setCustSteCd(custSteCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgCustTmpltVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgCustTmpltVO[]
	 */
	public BkgCustTmpltVO[] getBkgCustTmpltVOs(){
		BkgCustTmpltVO[] vos = (BkgCustTmpltVO[])models.toArray(new BkgCustTmpltVO[models.size()]);
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
		this.eurCstmsStNm = this.eurCstmsStNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDeclCntCd = this.cstmsDeclCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAddr = this.custAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pic = this.pic .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custEml = this.custEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCtyNm = this.custCtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custZipCd = this.custZipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpltSeq = this.tmpltSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpltRmk = this.tmpltRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custFaxNo = this.custFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custPhnNo = this.custPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eoriNo = this.eoriNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSteCd = this.custSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
