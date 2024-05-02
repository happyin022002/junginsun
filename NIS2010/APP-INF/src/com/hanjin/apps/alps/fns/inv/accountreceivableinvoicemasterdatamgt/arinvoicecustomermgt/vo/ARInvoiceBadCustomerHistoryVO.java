/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ARInvoiceInquiryInPutVO.java
*@FileTitle : ARInvoiceInquiryInPutVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.07.30 박정진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ARInvoiceBadCustomerHistoryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ARInvoiceBadCustomerHistoryVO> models = new ArrayList<ARInvoiceBadCustomerHistoryVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String custCntCd       = null;
	/* Column Info */
	private String custSeq         = null;
	/* Column Info */
	private String custIfSeq       = null;
	/* Column Info */
	private String ofcCd           = null;
	/* Column Info */
	private String custLglEngNm    = null;
	/* Column Info */
	private String badCustKndCd    = null;
	/* Column Info */
	private String slsDeltEffDt    = null;
	/* Column Info */
	private String custRlseCtrlFlg = null;
	/* Column Info */
	private String badCustRsn      = null;
	/* Column Info */
	private String updOfcCd        = null;
	/* Column Info */
	private String srepCd          = null;
	/* Column Info */
	private String crCltOfcCd          = null;
	/* Column Info */
	private String updOfc          = null;
	/* Column Info */
	private String updDt          = null;
	/* Column Info */
	private String updUsrId          = null;
	/* Column Info */
	private String updUsrNm          = null;
	/* Column Info */
	private String arHdQtrOfcCd      = null;


	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ARInvoiceBadCustomerHistoryVO() {}

	public ARInvoiceBadCustomerHistoryVO(String ibflag, String pagerows, String custCntCd,String custSeq,String custIfSeq,String ofcCd,String custLglEngNm,String badCustKndCd,String slsDeltEffDt,String custRlseCtrlFlg,String badCustRsn,String updOfcCd,String srepCd,String crCltOfcCd, String updOfc, String updDt, String updUsrId, String updUsrNm, String arHdQtrOfcCd) {

		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.custCntCd = custCntCd;
		this.custSeq = custSeq;
		this.custIfSeq = custIfSeq;
		this.ofcCd = ofcCd; 
		this.custLglEngNm = custLglEngNm;
		this.badCustKndCd = badCustKndCd;
		this.slsDeltEffDt = slsDeltEffDt;
		this.custRlseCtrlFlg = custRlseCtrlFlg;
		this.badCustRsn = badCustRsn;
		this.updOfcCd = updOfcCd;
		this.srepCd = srepCd;
		this.crCltOfcCd = crCltOfcCd;
		this.updOfc = updOfc;
		this.updDt = updDt;
		this.updUsrId = updUsrId;
		this.updUsrNm = updUsrNm;
		this.arHdQtrOfcCd = arHdQtrOfcCd;
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cust_if_seq", getCustIfSeq());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("bad_cust_knd_cd", getBadCustKndCd());
		this.hashColumns.put("sls_delt_eff_dt", getSlsDeltEffDt());
		this.hashColumns.put("cust_rlse_ctrl_flg", getCustRlseCtrlFlg());
		this.hashColumns.put("bad_cust_rsn", getBadCustRsn());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("srep_cd", getSrepCd());
		this.hashColumns.put("cr_clt_ofc_cd", getCrCltOfcCd());
		this.hashColumns.put("upd_ofc", getUpdOfc());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_usr_nm", getUpdUsrNm());
		this.hashColumns.put("ar_hd_qtr_ofc_cd", getArHdQtrOfcCd());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cust_if_seq", "custIfSeq");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("bad_cust_knd_cd", "badCustKndCd");
		this.hashFields.put("sls_delt_eff_dt", "slsDeltEffDt");
		this.hashFields.put("cust_rlse_ctrl_flg", "custRlseCtrlFlg");
		this.hashFields.put("bad_cust_rsn", "badCustRsn");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("srep_cd", "srepCd");
		this.hashFields.put("cr_clt_ofc_cd", "crCltOfcCd");
		this.hashFields.put("upd_ofc", "updOfc");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_usr_nm", "updUsrNm");
		this.hashFields.put("ar_hd_qtr_ofc_cd", "arHdQtrOfcCd");
		return this.hashFields;
	}
	
	
	/**
	 * @return the models
	 */
	public Collection<ARInvoiceBadCustomerHistoryVO> getModels() {
		return models;
	}

	/**
	 * @param models the models to set
	 */
	public void setModels(Collection<ARInvoiceBadCustomerHistoryVO> models) {
		this.models = models;
	}

	/**
	 * @return the pagerows
	 */
	public String getPagerows() {
		return pagerows;
	}

	/**
	 * @param pagerows the pagerows to set
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	/**
	 * @return the ibflag
	 */
	public String getIbflag() {
		return ibflag;
	}

	/**
	 * @param ibflag the ibflag to set
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	/**
	 * @return the custCntCd
	 */
	public String getCustCntCd() {
		return custCntCd;
	}

	/**
	 * @param custCntCd the custCntCd to set
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}

	/**
	 * @return the custSeq
	 */
	public String getCustSeq() {
		return custSeq;
	}

	/**
	 * @param custSeq the custSeq to set
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}

	/**
	 * @return the custIfSeq
	 */
	public String getCustIfSeq() {
		return custIfSeq;
	}

	/**
	 * @param custIfSeq the custIfSeq to set
	 */
	public void setCustIfSeq(String custIfSeq) {
		this.custIfSeq = custIfSeq;
	}

	/**
	 * @return the ofcCd
	 */
	public String getOfcCd() {
		return ofcCd;
	}

	/**
	 * @param ofcCd the ofcCd to set
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	/**
	 * @return the custLglEngNm
	 */
	public String getCustLglEngNm() {
		return custLglEngNm;
	}

	/**
	 * @param custLglEngNm the custLglEngNm to set
	 */
	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
	}

	/**
	 * @return the badCustKndCd
	 */
	public String getBadCustKndCd() {
		return badCustKndCd;
	}

	/**
	 * @param badCustKndCd the badCustKndCd to set
	 */
	public void setBadCustKndCd(String badCustKndCd) {
		this.badCustKndCd = badCustKndCd;
	}

	/**
	 * @return the slsDeltEffDt
	 */
	public String getSlsDeltEffDt() {
		return slsDeltEffDt;
	}

	/**
	 * @param slsDeltEffDt the slsDeltEffDt to set
	 */
	public void setSlsDeltEffDt(String slsDeltEffDt) {
		this.slsDeltEffDt = slsDeltEffDt;
	}

	/**
	 * @return the custRlseCtrlFlg
	 */
	public String getCustRlseCtrlFlg() {
		return custRlseCtrlFlg;
	}

	/**
	 * @param custRlseCtrlFlg the custRlseCtrlFlg to set
	 */
	public void setCustRlseCtrlFlg(String custRlseCtrlFlg) {
		this.custRlseCtrlFlg = custRlseCtrlFlg;
	}

	/**
	 * @return the badCustRsn
	 */
	public String getBadCustRsn() {
		return badCustRsn;
	}

	/**
	 * @param badCustRsn the badCustRsn to set
	 */
	public void setBadCustRsn(String badCustRsn) {
		this.badCustRsn = badCustRsn;
	}

	/**
	 * @return the updOfcCd
	 */
	public String getUpdOfcCd() {
		return updOfcCd;
	}

	/**
	 * @param updOfcCd the updOfcCd to set
	 */
	public void setUpdOfcCd(String updOfcCd) {
		this.updOfcCd = updOfcCd;
	}

	/**
	 * @return the srepCd
	 */
	public String getSrepCd() {
		return srepCd;
	}

	/**
	 * @param srepCd the srepCd to set
	 */
	public void setSrepCd(String srepCd) {
		this.srepCd = srepCd;
	}
	
	
	/**
	 * @return the crCltOfcCd
	 */
	public String getCrCltOfcCd() {
		return crCltOfcCd;
	}

	/**
	 * @param crCltOfcCd the crCltOfcCd to set
	 */
	public void setCrCltOfcCd(String crCltOfcCd) {
		this.crCltOfcCd = crCltOfcCd;
	}

	/**
	 * @return the updOfc
	 */
	public String getUpdOfc() {
		return updOfc;
	}

	/**
	 * @param updOfc the updOfc to set
	 */
	public void setUpdOfc(String updOfc) {
		this.updOfc = updOfc;
	}
	
	
	/**
	 * @return the updDt
	 */
	public String getUpdDt() {
		return updDt;
	}

	/**
	 * @param updDt the updDt to set
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}

	/**
	 * @return the updUsrId
	 */
	public String getUpdUsrId() {
		return updUsrId;
	}

	/**
	 * @param updUsrId the updUsrId to set
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	/**
	 * @return the updUsrNm
	 */
	public String getUpdUsrNm() {
		return updUsrNm;
	}

	/**
	 * @param updUsrNm the updUsrNm to set
	 */
	public void setUpdUsrNm(String updUsrNm) {
		this.updUsrNm = updUsrNm;
	}

	
	/**
	 * @return the arHdQtrOfcCd
	 */
	public String getArHdQtrOfcCd() {
		return arHdQtrOfcCd;
	}

	/**
	 * @param arHdQtrOfcCd the arHdQtrOfcCd to set
	 */
	public void setArHdQtrOfcCd(String arHdQtrOfcCd) {
		this.arHdQtrOfcCd = arHdQtrOfcCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setCustIfSeq(JSPUtil.getParameter(request, "cust_if_seq", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, "cust_lgl_eng_nm", ""));
		setBadCustKndCd(JSPUtil.getParameter(request, "bad_cust_knd_cd", ""));
		setSlsDeltEffDt(JSPUtil.getParameter(request, "sls_delt_eff_dt", ""));
		setCustRlseCtrlFlg(JSPUtil.getParameter(request, "cust_rlse_ctrl_flg",""));
		setBadCustRsn(JSPUtil.getParameter(request, "bad_cust_rsn", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, "upd_ofc_cd", ""));
		setSrepCd(JSPUtil.getParameter(request, "srep_cd", ""));
		setCrCltOfcCd(JSPUtil.getParameter(request, "cr_clt_ofc_cd", ""));
		setUpdOfc(JSPUtil.getParameter(request, "upd_ofc", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdUsrNm(JSPUtil.getParameter(request, "upd_usr_nm", ""));
		setArHdQtrOfcCd(JSPUtil.getParameter(request, "ar_hd_qtr_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ARInvoiceInquiryInPutVO[]
	 */
	public ARInvoiceBadCustomerHistoryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ARInvoiceInquiryInPutVO[]
	 */
	public ARInvoiceBadCustomerHistoryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ARInvoiceBadCustomerHistoryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));			
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] custIfSeq = (JSPUtil.getParameter(request, prefix	+ "cust_if_seq", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] badCustKndCd = (JSPUtil.getParameter(request, prefix	+ "bad_cust_knd_cd", length));
			String[] slsDeltEffDt = (JSPUtil.getParameter(request, prefix	+ "sls_delt_eff_dt", length));
			String[] custRlseCtrlFlg = (JSPUtil.getParameter(request, prefix	+ "cust_rlse_ctrl_flg", length));
			String[] badCustRsn = (JSPUtil.getParameter(request, prefix	+ "bad_cust_rsn", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] srepCd = (JSPUtil.getParameter(request, prefix	+ "srep_cd", length));
			String[] crCltOfcCd = (JSPUtil.getParameter(request, prefix	+ "cr_clt_ofc_cd", length));
			String[] updOfc = (JSPUtil.getParameter(request, prefix	+ "upd_ofc", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updUsrNm = (JSPUtil.getParameter(request, prefix	+ "upd_usr_nm", length));
			String[] arHdQtrOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_hd_qtr_ofc_cd", length));
			
			
			
			for (int i = 0; i < length; i++) {
				model = new ARInvoiceBadCustomerHistoryVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (custIfSeq[i] != null)
					model.setCustIfSeq(custIfSeq[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (badCustKndCd[i] != null)
					model.setBadCustKndCd(badCustKndCd[i]);
				if (slsDeltEffDt[i] != null)
					model.setSlsDeltEffDt(slsDeltEffDt[i]);
				if (custRlseCtrlFlg[i] != null)
					model.setCustRlseCtrlFlg(custRlseCtrlFlg[i]);
				if (badCustRsn[i] != null)
					model.setBadCustRsn(badCustRsn[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (srepCd[i] != null)
					model.setSrepCd(srepCd[i]);
				if (crCltOfcCd[i] != null)
					model.setCrCltOfcCd(crCltOfcCd[i]);
				if (updOfc[i] != null)
					model.setUpdOfc(updOfc[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updUsrNm[i] != null)
					model.setUpdUsrNm(updUsrNm[i]);
				if (arHdQtrOfcCd[i] != null)
					model.setArHdQtrOfcCd(arHdQtrOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getARInvoiceInquiryInPutVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ARInvoiceInquiryInPutVO[]
	 */
	public ARInvoiceBadCustomerHistoryVO[] getARInvoiceInquiryInPutVOs(){
		ARInvoiceBadCustomerHistoryVO[] vos = (ARInvoiceBadCustomerHistoryVO[])models.toArray(new ARInvoiceBadCustomerHistoryVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custIfSeq = this.custIfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.badCustKndCd = this.badCustKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsDeltEffDt = this.slsDeltEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRlseCtrlFlg = this.custRlseCtrlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.badCustRsn = this.badCustRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCd = this.srepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crCltOfcCd = this.crCltOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfc = this.updOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrNm = this.updUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arHdQtrOfcCd = this.arHdQtrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
