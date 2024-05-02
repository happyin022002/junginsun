/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ArrNtcCustCodeErrSearchVO.java
*@FileTitle : ArrNtcCustCodeErrSearchVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.12
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.12  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo;

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

public class ArrNtcCustCodeErrSearchVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ArrNtcCustCodeErrSearchVO> models = new ArrayList<ArrNtcCustCodeErrSearchVO>();
	
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String docUsrId = null;
	/* Column Info */
	private String valUsrId = null;
	/* Column Info */
	private String ibEvCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String bkgCreDtE = null;
	/* Column Info */
	private String hqEvCd = null;
	/* Column Info */
	private String valDtS = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String obEvCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String valOfcCd = null;
	/* Column Info */
	private String excelFlg = null;
	/* Column Info */
	private String pageNo = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String bkgCreDtS = null;
	/* Column Info */
	private String mtchFlg = null;
	/* Column Info */
	private String valDtE = null;
	/* Column Info */
	private String custTpCd = null;
	/* Column Info */
	private String valCd = null;
	/* Column Info */
	private String codeOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ArrNtcCustCodeErrSearchVO() {}

	public ArrNtcCustCodeErrSearchVO(String ibflag, String pagerows, String bkgCreDtS, String bkgCreDtE, String bkgOfcCd, String valCd, String docUsrId, String custTpCd, String valDtS, String valDtE, String valOfcCd, String custCd, String valUsrId, String blNo, String mtchFlg, String obEvCd, String ibEvCd, String hqEvCd, String excelFlg, String pageNo, String codeOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
		this.docUsrId = docUsrId;
		this.valUsrId = valUsrId;
		this.ibEvCd = ibEvCd;
		this.blNo = blNo;
		this.bkgCreDtE = bkgCreDtE;
		this.hqEvCd = hqEvCd;
		this.valDtS = valDtS;
		this.pagerows = pagerows;
		this.obEvCd = obEvCd;
		this.ibflag = ibflag;
		this.valOfcCd = valOfcCd;
		this.excelFlg = excelFlg;
		this.pageNo = pageNo;
		this.custCd = custCd;
		this.bkgCreDtS = bkgCreDtS;
		this.mtchFlg = mtchFlg;
		this.valDtE = valDtE;
		this.custTpCd = custTpCd;
		this.valCd = valCd;
		this.codeOfcCd = codeOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("doc_usr_id", getDocUsrId());
		this.hashColumns.put("val_usr_id", getValUsrId());
		this.hashColumns.put("ib_ev_cd", getIbEvCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("bkg_cre_dt_e", getBkgCreDtE());
		this.hashColumns.put("hq_ev_cd", getHqEvCd());
		this.hashColumns.put("val_dt_s", getValDtS());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ob_ev_cd", getObEvCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("val_ofc_cd", getValOfcCd());
		this.hashColumns.put("excel_flg", getExcelFlg());
		this.hashColumns.put("page_no", getPageNo());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("bkg_cre_dt_s", getBkgCreDtS());
		this.hashColumns.put("mtch_flg", getMtchFlg());
		this.hashColumns.put("val_dt_e", getValDtE());
		this.hashColumns.put("cust_tp_cd", getCustTpCd());
		this.hashColumns.put("val_cd", getValCd());
		this.hashColumns.put("code_ofc_cd", getCodeOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("doc_usr_id", "docUsrId");
		this.hashFields.put("val_usr_id", "valUsrId");
		this.hashFields.put("ib_ev_cd", "ibEvCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("bkg_cre_dt_e", "bkgCreDtE");
		this.hashFields.put("hq_ev_cd", "hqEvCd");
		this.hashFields.put("val_dt_s", "valDtS");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ob_ev_cd", "obEvCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("val_ofc_cd", "valOfcCd");
		this.hashFields.put("excel_flg", "excelFlg");
		this.hashFields.put("page_no", "pageNo");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("bkg_cre_dt_s", "bkgCreDtS");
		this.hashFields.put("mtch_flg", "mtchFlg");
		this.hashFields.put("val_dt_e", "valDtE");
		this.hashFields.put("cust_tp_cd", "custTpCd");
		this.hashFields.put("val_cd", "valCd");
		this.hashFields.put("code_ofc_cd", "codeOfcCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return docUsrId
	 */
	public String getDocUsrId() {
		return this.docUsrId;
	}
	
	/**
	 * Column Info
	 * @return valUsrId
	 */
	public String getValUsrId() {
		return this.valUsrId;
	}
	
	/**
	 * Column Info
	 * @return ibEvCd
	 */
	public String getIbEvCd() {
		return this.ibEvCd;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return bkgCreDtE
	 */
	public String getBkgCreDtE() {
		return this.bkgCreDtE;
	}
	
	/**
	 * Column Info
	 * @return hqEvCd
	 */
	public String getHqEvCd() {
		return this.hqEvCd;
	}
	
	/**
	 * Column Info
	 * @return valDtS
	 */
	public String getValDtS() {
		return this.valDtS;
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
	 * @return obEvCd
	 */
	public String getObEvCd() {
		return this.obEvCd;
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
	 * @return valOfcCd
	 */
	public String getValOfcCd() {
		return this.valOfcCd;
	}
	
	/**
	 * Column Info
	 * @return excelFlg
	 */
	public String getExcelFlg() {
		return this.excelFlg;
	}
	
	/**
	 * Column Info
	 * @return pageNo
	 */
	public String getPageNo() {
		return this.pageNo;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return bkgCreDtS
	 */
	public String getBkgCreDtS() {
		return this.bkgCreDtS;
	}
	
	/**
	 * Column Info
	 * @return mtchFlg
	 */
	public String getMtchFlg() {
		return this.mtchFlg;
	}
	
	/**
	 * Column Info
	 * @return valDtE
	 */
	public String getValDtE() {
		return this.valDtE;
	}
	
	/**
	 * Column Info
	 * @return custTpCd
	 */
	public String getCustTpCd() {
		return this.custTpCd;
	}
	
	/**
	 * Column Info
	 * @return valCd
	 */
	public String getValCd() {
		return this.valCd;
	}
	
	/**
	 * Column Info
	 * @return codeOfcCd
	 */
	public String getCodeOfcCd() {
		return this.codeOfcCd;
	}
	

	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param docUsrId
	 */
	public void setDocUsrId(String docUsrId) {
		this.docUsrId = docUsrId;
	}
	
	/**
	 * Column Info
	 * @param valUsrId
	 */
	public void setValUsrId(String valUsrId) {
		this.valUsrId = valUsrId;
	}
	
	/**
	 * Column Info
	 * @param ibEvCd
	 */
	public void setIbEvCd(String ibEvCd) {
		this.ibEvCd = ibEvCd;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param bkgCreDtE
	 */
	public void setBkgCreDtE(String bkgCreDtE) {
		this.bkgCreDtE = bkgCreDtE;
	}
	
	/**
	 * Column Info
	 * @param hqEvCd
	 */
	public void setHqEvCd(String hqEvCd) {
		this.hqEvCd = hqEvCd;
	}
	
	/**
	 * Column Info
	 * @param valDtS
	 */
	public void setValDtS(String valDtS) {
		this.valDtS = valDtS;
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
	 * @param obEvCd
	 */
	public void setObEvCd(String obEvCd) {
		this.obEvCd = obEvCd;
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
	 * @param valOfcCd
	 */
	public void setValOfcCd(String valOfcCd) {
		this.valOfcCd = valOfcCd;
	}
	
	/**
	 * Column Info
	 * @param excelFlg
	 */
	public void setExcelFlg(String excelFlg) {
		this.excelFlg = excelFlg;
	}
	
	/**
	 * Column Info
	 * @param pageNo
	 */
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param bkgCreDtS
	 */
	public void setBkgCreDtS(String bkgCreDtS) {
		this.bkgCreDtS = bkgCreDtS;
	}
	
	/**
	 * Column Info
	 * @param mtchFlg
	 */
	public void setMtchFlg(String mtchFlg) {
		this.mtchFlg = mtchFlg;
	}
	
	/**
	 * Column Info
	 * @param valDtE
	 */
	public void setValDtE(String valDtE) {
		this.valDtE = valDtE;
	}
	
	/**
	 * Column Info
	 * @param custTpCd
	 */
	public void setCustTpCd(String custTpCd) {
		this.custTpCd = custTpCd;
	}
	
	/**
	 * Column Info
	 * @param valCd
	 */
	public void setValCd(String valCd) {
		this.valCd = valCd;
	}
	
	/**
	 * Column Info
	 * @param codeOfcCd
	 */
	public void setCodeOfcCd(String codeOfcCd) {
		this.codeOfcCd = codeOfcCd;
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
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setDocUsrId(JSPUtil.getParameter(request, prefix + "doc_usr_id", ""));
		setValUsrId(JSPUtil.getParameter(request, prefix + "val_usr_id", ""));
		setIbEvCd(JSPUtil.getParameter(request, prefix + "ib_ev_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setBkgCreDtE(JSPUtil.getParameter(request, prefix + "bkg_cre_dt_e", ""));
		setHqEvCd(JSPUtil.getParameter(request, prefix + "hq_ev_cd", ""));
		setValDtS(JSPUtil.getParameter(request, prefix + "val_dt_s", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setObEvCd(JSPUtil.getParameter(request, prefix + "ob_ev_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setValOfcCd(JSPUtil.getParameter(request, prefix + "val_ofc_cd", ""));
		setExcelFlg(JSPUtil.getParameter(request, prefix + "excel_flg", ""));
		setPageNo(JSPUtil.getParameter(request, prefix + "page_no", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setBkgCreDtS(JSPUtil.getParameter(request, prefix + "bkg_cre_dt_s", ""));
		setMtchFlg(JSPUtil.getParameter(request, prefix + "mtch_flg", ""));
		setValDtE(JSPUtil.getParameter(request, prefix + "val_dt_e", ""));
		setCustTpCd(JSPUtil.getParameter(request, prefix + "cust_tp_cd", ""));
		setValCd(JSPUtil.getParameter(request, prefix + "val_cd", ""));
		setCodeOfcCd(JSPUtil.getParameter(request, prefix + "code_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ArrNtcCustCodeErrSearchVO[]
	 */
	public ArrNtcCustCodeErrSearchVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ArrNtcCustCodeErrSearchVO[]
	 */
	public ArrNtcCustCodeErrSearchVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ArrNtcCustCodeErrSearchVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] docUsrId = (JSPUtil.getParameter(request, prefix	+ "doc_usr_id", length));
			String[] valUsrId = (JSPUtil.getParameter(request, prefix	+ "val_usr_id", length));
			String[] ibEvCd = (JSPUtil.getParameter(request, prefix	+ "ib_ev_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] bkgCreDtE = (JSPUtil.getParameter(request, prefix	+ "bkg_cre_dt_e", length));
			String[] hqEvCd = (JSPUtil.getParameter(request, prefix	+ "hq_ev_cd", length));
			String[] valDtS = (JSPUtil.getParameter(request, prefix	+ "val_dt_s", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] obEvCd = (JSPUtil.getParameter(request, prefix	+ "ob_ev_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] valOfcCd = (JSPUtil.getParameter(request, prefix	+ "val_ofc_cd", length));
			String[] excelFlg = (JSPUtil.getParameter(request, prefix	+ "excel_flg", length));
			String[] pageNo = (JSPUtil.getParameter(request, prefix	+ "page_no", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] bkgCreDtS = (JSPUtil.getParameter(request, prefix	+ "bkg_cre_dt_s", length));
			String[] mtchFlg = (JSPUtil.getParameter(request, prefix	+ "mtch_flg", length));
			String[] valDtE = (JSPUtil.getParameter(request, prefix	+ "val_dt_e", length));
			String[] custTpCd = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd", length));
			String[] valCd = (JSPUtil.getParameter(request, prefix	+ "val_cd", length));
			String[] codeOfcCd = (JSPUtil.getParameter(request, prefix	+ "code_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new ArrNtcCustCodeErrSearchVO();
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (docUsrId[i] != null)
					model.setDocUsrId(docUsrId[i]);
				if (valUsrId[i] != null)
					model.setValUsrId(valUsrId[i]);
				if (ibEvCd[i] != null)
					model.setIbEvCd(ibEvCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (bkgCreDtE[i] != null)
					model.setBkgCreDtE(bkgCreDtE[i]);
				if (hqEvCd[i] != null)
					model.setHqEvCd(hqEvCd[i]);
				if (valDtS[i] != null)
					model.setValDtS(valDtS[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (obEvCd[i] != null)
					model.setObEvCd(obEvCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (valOfcCd[i] != null)
					model.setValOfcCd(valOfcCd[i]);
				if (excelFlg[i] != null)
					model.setExcelFlg(excelFlg[i]);
				if (pageNo[i] != null)
					model.setPageNo(pageNo[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (bkgCreDtS[i] != null)
					model.setBkgCreDtS(bkgCreDtS[i]);
				if (mtchFlg[i] != null)
					model.setMtchFlg(mtchFlg[i]);
				if (valDtE[i] != null)
					model.setValDtE(valDtE[i]);
				if (custTpCd[i] != null)
					model.setCustTpCd(custTpCd[i]);
				if (valCd[i] != null)
					model.setValCd(valCd[i]);
				if (codeOfcCd[i] != null)
					model.setCodeOfcCd(codeOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getArrNtcCustCodeErrSearchVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ArrNtcCustCodeErrSearchVO[]
	 */
	public ArrNtcCustCodeErrSearchVO[] getArrNtcCustCodeErrSearchVOs(){
		ArrNtcCustCodeErrSearchVO[] vos = (ArrNtcCustCodeErrSearchVO[])models.toArray(new ArrNtcCustCodeErrSearchVO[models.size()]);
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
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docUsrId = this.docUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.valUsrId = this.valUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibEvCd = this.ibEvCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCreDtE = this.bkgCreDtE .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hqEvCd = this.hqEvCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.valDtS = this.valDtS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obEvCd = this.obEvCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.valOfcCd = this.valOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.excelFlg = this.excelFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pageNo = this.pageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCreDtS = this.bkgCreDtS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtchFlg = this.mtchFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.valDtE = this.valDtE .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCd = this.custTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.valCd = this.valCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codeOfcCd = this.codeOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
