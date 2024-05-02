/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MdmCustomerVO.java
*@FileTitle : MdmCustomerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 
*@LastVersion : 1.0
* 2009.05.28  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo;

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
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MdmCustomerVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MdmCustomerVO> models = new ArrayList<MdmCustomerVO>();
	
	/* Column Info */
	private String phnNo = null;
	/* Column Info */
	private String bookingAlertToDate = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String custStsCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String bzetAddr = null;
	/* Column Info */
	private String srepCd = null;
	/* Column Info */
	private String custEml = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String faxNo = null;
	/* Column Info */
	private String ctyNm = null;
	/* Column Info */
	private String custCntCd = null;
	
	// BKG_CUST_CD_VAL을 위해서 추가
	private String nmdCustFlg = null;
	private String deltFlg = null;
	private String creUsrId = null;
	private String updUsrId = null;
	private String updDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MdmCustomerVO() {}
/**
 * 
 * @param ibflag
 * @param pagerows
 * @param custCd
 * @param custLglEngNm
 * @param custCntCd
 * @param ctyNm
 * @param bzetAddr
 * @param phnNo
 * @param faxNo
 * @param custEml
 * @param custStsCd
 * @param bookingAlertToDate
 * @param creDt
 * @param srepCd
 * @param ofcCd
 * @param custSeq
 */
	public MdmCustomerVO(String ibflag, String pagerows, String custCd, String custLglEngNm, String custCntCd, String ctyNm, String bzetAddr, String phnNo, String faxNo, String custEml, String custStsCd, String bookingAlertToDate, String creDt, String srepCd, String ofcCd, String custSeq, String nmdCustFlg, String deltFlg, String creUsrId, String updUsrId, String updDt) {
		this.phnNo = phnNo;
		this.bookingAlertToDate = bookingAlertToDate;
		this.creDt = creDt;
		this.custStsCd = custStsCd;
		this.custSeq = custSeq;
		this.bzetAddr = bzetAddr;
		this.srepCd = srepCd;
		this.custEml = custEml;
		this.pagerows = pagerows;
		this.custLglEngNm = custLglEngNm;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.custCd = custCd;
		this.faxNo = faxNo;
		this.ctyNm = ctyNm;
		this.custCntCd = custCntCd;
		this.nmdCustFlg = nmdCustFlg;
		this.deltFlg = deltFlg;
		this.creUsrId = creUsrId;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
			
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("phn_no", getPhnNo());
		this.hashColumns.put("booking_alert_to_date", getBookingAlertToDate());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cust_sts_cd", getCustStsCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("bzet_addr", getBzetAddr());
		this.hashColumns.put("srep_cd", getSrepCd());
		this.hashColumns.put("cust_eml", getCustEml());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("cty_nm", getCtyNm());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		
		this.hashColumns.put("nmd_cust_flg", getNmdCustFlg());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("phn_no", "phnNo");
		this.hashFields.put("booking_alert_to_date", "bookingAlertToDate");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cust_sts_cd", "custStsCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("bzet_addr", "bzetAddr");
		this.hashFields.put("srep_cd", "srepCd");
		this.hashFields.put("cust_eml", "custEml");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("cty_nm", "ctyNm");
		this.hashFields.put("cust_cnt_cd", "custCntCd");

		this.hashFields.put("nmd_cust_flg", "nmdCustFlg");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return phnNo
	 */
	public String getPhnNo() {
		return this.phnNo;
	}
	
	/**
	 * Column Info
	 * @return bookingAlertToDate
	 */
	public String getBookingAlertToDate() {
		return this.bookingAlertToDate;
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
	 * @return custStsCd
	 */
	public String getCustStsCd() {
		return this.custStsCd;
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
	 * @return bzetAddr
	 */
	public String getBzetAddr() {
		return this.bzetAddr;
	}
	
	/**
	 * Column Info
	 * @return srepCd
	 */
	public String getSrepCd() {
		return this.srepCd;
	}
	
	/**
	 * Column Info
	 * @return custEml
	 */
	public String getCustEml() {
		return this.custEml;
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
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return faxNo
	 */
	public String getFaxNo() {
		return this.faxNo;
	}
	
	/**
	 * Column Info
	 * @return ctyNm
	 */
	public String getCtyNm() {
		return this.ctyNm;
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
	 * @return nmdCustFlg
	 */
	public String getNmdCustFlg() {
		return this.nmdCustFlg;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}

	/**
	 * Column Info
	 * @param phnNo
	 */
	public void setPhnNo(String phnNo) {
		this.phnNo = phnNo;
	}
	
	/**
	 * Column Info
	 * @param bookingAlertToDate
	 */
	public void setBookingAlertToDate(String bookingAlertToDate) {
		this.bookingAlertToDate = bookingAlertToDate;
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
	 * @param custStsCd
	 */
	public void setCustStsCd(String custStsCd) {
		this.custStsCd = custStsCd;
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
	 * @param bzetAddr
	 */
	public void setBzetAddr(String bzetAddr) {
		this.bzetAddr = bzetAddr;
	}
	
	/**
	 * Column Info
	 * @param srepCd
	 */
	public void setSrepCd(String srepCd) {
		this.srepCd = srepCd;
	}
	
	/**
	 * Column Info
	 * @param custEml
	 */
	public void setCustEml(String custEml) {
		this.custEml = custEml;
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
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param faxNo
	 */
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}
	
	/**
	 * Column Info
	 * @param ctyNm
	 */
	public void setCtyNm(String ctyNm) {
		this.ctyNm = ctyNm;
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
	 * @param nmdCustFlg
	 */
	public void setNmdCustFlg(String nmdCustFlg) {
		this.nmdCustFlg = nmdCustFlg;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPhnNo(JSPUtil.getParameter(request, "phn_no", ""));
		setBookingAlertToDate(JSPUtil.getParameter(request, "booking_alert_to_date", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setCustStsCd(JSPUtil.getParameter(request, "cust_sts_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setBzetAddr(JSPUtil.getParameter(request, "bzet_addr", ""));
		setSrepCd(JSPUtil.getParameter(request, "srep_cd", ""));
		setCustEml(JSPUtil.getParameter(request, "cust_eml", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, "cust_lgl_eng_nm", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCustCd(JSPUtil.getParameter(request, "cust_cd", ""));
		setFaxNo(JSPUtil.getParameter(request, "fax_no", ""));
		setCtyNm(JSPUtil.getParameter(request, "cty_nm", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		
		setNmdCustFlg(JSPUtil.getParameter(request,"nmd_cust_flg", ""));
		setDeltFlg(JSPUtil.getParameter(request,"delt_flg", ""));
		setCreUsrId(JSPUtil.getParameter(request,"cre_usr_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request,"upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request,"upd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MdmCustomerVO[]
	 */
	public MdmCustomerVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MdmCustomerVO[]
	 */
	public MdmCustomerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MdmCustomerVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] phnNo = (JSPUtil.getParameter(request, prefix	+ "phn_no".trim(), length));
			String[] bookingAlertToDate = (JSPUtil.getParameter(request, prefix	+ "booking_alert_to_date".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] custStsCd = (JSPUtil.getParameter(request, prefix	+ "cust_sts_cd".trim(), length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq".trim(), length));
			String[] bzetAddr = (JSPUtil.getParameter(request, prefix	+ "bzet_addr".trim(), length));
			String[] srepCd = (JSPUtil.getParameter(request, prefix	+ "srep_cd".trim(), length));
			String[] custEml = (JSPUtil.getParameter(request, prefix	+ "cust_eml".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm".trim(), length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd".trim(), length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no".trim(), length));
			String[] ctyNm = (JSPUtil.getParameter(request, prefix	+ "cty_nm".trim(), length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd".trim(), length));
			
			String[] nmdCustFlg = (JSPUtil.getParameter(request, prefix	+ "nmd_cust_flg".trim(), length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));

			for (int i = 0; i < length; i++) {
				model = new MdmCustomerVO();
				if (phnNo[i] != null)
					model.setPhnNo(phnNo[i]);
				if (bookingAlertToDate[i] != null)
					model.setBookingAlertToDate(bookingAlertToDate[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (custStsCd[i] != null)
					model.setCustStsCd(custStsCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (bzetAddr[i] != null)
					model.setBzetAddr(bzetAddr[i]);
				if (srepCd[i] != null)
					model.setSrepCd(srepCd[i]);
				if (custEml[i] != null)
					model.setCustEml(custEml[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (faxNo[i] != null)
					model.setFaxNo(faxNo[i]);
				if (ctyNm[i] != null)
					model.setCtyNm(ctyNm[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);

				if (nmdCustFlg[i] != null)
					model.setNmdCustFlg(nmdCustFlg[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMdmCustomerVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MdmCustomerVO[]
	 */
	public MdmCustomerVO[] getMdmCustomerVOs(){
		MdmCustomerVO[] vos = (MdmCustomerVO[])models.toArray(new MdmCustomerVO[models.size()]);
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
		this.phnNo = this.phnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bookingAlertToDate = this.bookingAlertToDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custStsCd = this.custStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzetAddr = this.bzetAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCd = this.srepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custEml = this.custEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctyNm = this.ctyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.nmdCustFlg = this.nmdCustFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
