/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : CustomerAddressIfVO.java
*@FileTitle : CustomerAddressIfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2018.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2018.03.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
public class CustomerAddressIfVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomerAddressIfVO> models = new ArrayList<CustomerAddressIfVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	
	/* Page Number */
	private String pagerows = null;

	/* Column Info */
	private String custMstRowId = null;

	/* Column Info */
	private String custAddrRowId = null;

	/* Column Info */
	private String custAddrStsCd = null;

	/* Column Info */
	private String custCntCd = null;

	/* Column Info */
	private String custSeq = null;

	/* Column Info */
	private String addrTpCd = null;

	/* Column Info */
	private String addrSeq = null;

	/* Column Info */
	private String prmryChkFlg = null;

	/* Column Info */
	private String bzetCntCd = null;

	/* Column Info */
	private String bzetSeq = null;

	/* Column Info */
	private String bzetNm = null;

	/* Column Info */
	private String bzetAddr = null;

	/* Column Info */
	private String ctyNm = null;

	/* Column Info */
	private String steCd = null;

	/* Column Info */
	private String zipCd = null;

	/* Column Info */
	private String cntCd = null;

	/* Column Info */
	private String cntcEml = null;

	/* Column Info */
	private String cntcPsonNm = null;

	/* Column Info */
	private String bzetRmk = null;

	/* Column Info */
	private String intlPhnNo = null;

	/* Column Info */
	private String arctPhnNo = null;

	/* Column Info */
	private String phnNo = null;

	/* Column Info */
	private String fullPhnNo = null;

	/* Column Info */
	private String intlFaxNo = null;

	/* Column Info */
	private String arctFaxNo = null;

	/* Column Info */
	private String faxNo = null;

	/* Column Info */
	private String fullFaxNo = null;

	/* Column Info */
	private String creUsrId = null;

	/* Column Info */
	private String creDt = null;

	/* Column Info */
	private String updUsrId = null;

	/* Column Info */
	private String updDt = null;

	/* Column Info */
	private String deltFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CustomerAddressIfVO() {}

	public CustomerAddressIfVO(String ibflag, String pagerows, String custMstRowId, String custAddrRowId, String custAddrStsCd, String custCntCd, String custSeq, String addrTpCd, String addrSeq, String prmryChkFlg, String bzetCntCd, String bzetSeq, String bzetNm, String bzetAddr, String ctyNm, String steCd, String zipCd, String cntCd, String cntcEml, String cntcPsonNm, String bzetRmk, String intlPhnNo, String arctPhnNo, String phnNo, String fullPhnNo, String intlFaxNo, String arctFaxNo, String faxNo, String fullFaxNo, String creUsrId, String creDt, String updUsrId, String updDt, String deltFlg) {
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.custMstRowId = custMstRowId;
		this.custAddrRowId = custAddrRowId;
		this.custAddrStsCd = custAddrStsCd;
		this.custCntCd = custCntCd;
		this.custSeq = custSeq;
		this.addrTpCd = addrTpCd;
		this.addrSeq = addrSeq;
		this.prmryChkFlg = prmryChkFlg;
		this.bzetCntCd = bzetCntCd;
		this.bzetSeq = bzetSeq;
		this.bzetNm = bzetNm;
		this.bzetAddr = bzetAddr;
		this.ctyNm = ctyNm;
		this.steCd = steCd;
		this.zipCd = zipCd;
		this.cntCd = cntCd;
		this.cntcEml = cntcEml;
		this.cntcPsonNm = cntcPsonNm;
		this.bzetRmk = bzetRmk;
		this.intlPhnNo = intlPhnNo;
		this.arctPhnNo = arctPhnNo;
		this.phnNo = phnNo;
		this.fullPhnNo = fullPhnNo;
		this.intlFaxNo = intlFaxNo;
		this.arctFaxNo = arctFaxNo;
		this.faxNo = faxNo;
		this.fullFaxNo = fullFaxNo;
		this.creUsrId = creUsrId;
		this.creDt = creDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.deltFlg = deltFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cust_mst_row_id", getCustMstRowId());
		this.hashColumns.put("cust_addr_row_id", getCustAddrRowId());
		this.hashColumns.put("cust_addr_sts_cd", getCustAddrStsCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("addr_tp_cd", getAddrTpCd());
		this.hashColumns.put("addr_seq", getAddrSeq());
		this.hashColumns.put("prmry_chk_flg", getPrmryChkFlg());
		this.hashColumns.put("bzet_cnt_cd", getBzetCntCd());
		this.hashColumns.put("bzet_seq", getBzetSeq());
		this.hashColumns.put("bzet_nm", getBzetNm());
		this.hashColumns.put("bzet_addr", getBzetAddr());
		this.hashColumns.put("cty_nm", getCtyNm());
		this.hashColumns.put("ste_cd", getSteCd());
		this.hashColumns.put("zip_cd", getZipCd());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("cntc_eml", getCntcEml());
		this.hashColumns.put("cntc_pson_nm", getCntcPsonNm());
		this.hashColumns.put("bzet_rmk", getBzetRmk());
		this.hashColumns.put("intl_phn_no", getIntlPhnNo());
		this.hashColumns.put("arct_phn_no", getArctPhnNo());
		this.hashColumns.put("phn_no", getPhnNo());
		this.hashColumns.put("full_phn_no", getFullPhnNo());
		this.hashColumns.put("intl_fax_no", getIntlFaxNo());
		this.hashColumns.put("arct_fax_no", getArctFaxNo());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("full_fax_no", getFullFaxNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("delt_flg", getDeltFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cust_mst_row_id", "custMstRowId");
		this.hashFields.put("cust_addr_row_id", "custAddrRowId");
		this.hashFields.put("cust_addr_sts_cd", "custAddrStsCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("addr_tp_cd", "addrTpCd");
		this.hashFields.put("addr_seq", "addrSeq");
		this.hashFields.put("prmry_chk_flg", "prmryChkFlg");
		this.hashFields.put("bzet_cnt_cd", "bzetCntCd");
		this.hashFields.put("bzet_seq", "bzetSeq");
		this.hashFields.put("bzet_nm", "bzetNm");
		this.hashFields.put("bzet_addr", "bzetAddr");
		this.hashFields.put("cty_nm", "ctyNm");
		this.hashFields.put("ste_cd", "steCd");
		this.hashFields.put("zip_cd", "zipCd");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("cntc_eml", "cntcEml");
		this.hashFields.put("cntc_pson_nm", "cntcPsonNm");
		this.hashFields.put("bzet_rmk", "bzetRmk");
		this.hashFields.put("intl_phn_no", "intlPhnNo");
		this.hashFields.put("arct_phn_no", "arctPhnNo");
		this.hashFields.put("phn_no", "phnNo");
		this.hashFields.put("full_phn_no", "fullPhnNo");
		this.hashFields.put("intl_fax_no", "intlFaxNo");
		this.hashFields.put("arct_fax_no", "arctFaxNo");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("full_fax_no", "fullFaxNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("delt_flg", "deltFlg");
		return this.hashFields;
	}
	
	/**
	 *
	 * @param String ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * 
	 * @return String ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 *
	 * @param String pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * 
	 * @return String pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 *
	 * @param String custMstRowId
	 */
	public void setCustMstRowId(String custMstRowId) {
		this.custMstRowId = custMstRowId;
	}
	
	/**
	 * 
	 * @return String custMstRowId
	 */
	public String getCustMstRowId() {
		return this.custMstRowId;
	}
	
	/**
	 *
	 * @param String custAddrRowId
	 */
	public void setCustAddrRowId(String custAddrRowId) {
		this.custAddrRowId = custAddrRowId;
	}
	
	/**
	 * 
	 * @return String custAddrRowId
	 */
	public String getCustAddrRowId() {
		return this.custAddrRowId;
	}
	
	/**
	 *
	 * @param String custAddrStsCd
	 */
	public void setCustAddrStsCd(String custAddrStsCd) {
		this.custAddrStsCd = custAddrStsCd;
	}
	
	/**
	 * 
	 * @return String custAddrStsCd
	 */
	public String getCustAddrStsCd() {
		return this.custAddrStsCd;
	}
	
	/**
	 *
	 * @param String custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * 
	 * @return String custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 *
	 * @param String custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * 
	 * @return String custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 *
	 * @param String addrTpCd
	 */
	public void setAddrTpCd(String addrTpCd) {
		this.addrTpCd = addrTpCd;
	}
	
	/**
	 * 
	 * @return String addrTpCd
	 */
	public String getAddrTpCd() {
		return this.addrTpCd;
	}
	
	/**
	 *
	 * @param String addrSeq
	 */
	public void setAddrSeq(String addrSeq) {
		this.addrSeq = addrSeq;
	}
	
	/**
	 * 
	 * @return String addrSeq
	 */
	public String getAddrSeq() {
		return this.addrSeq;
	}
	
	/**
	 *
	 * @param String prmryChkFlg
	 */
	public void setPrmryChkFlg(String prmryChkFlg) {
		this.prmryChkFlg = prmryChkFlg;
	}
	
	/**
	 * 
	 * @return String prmryChkFlg
	 */
	public String getPrmryChkFlg() {
		return this.prmryChkFlg;
	}
	
	/**
	 *
	 * @param String bzetCntCd
	 */
	public void setBzetCntCd(String bzetCntCd) {
		this.bzetCntCd = bzetCntCd;
	}
	
	/**
	 * 
	 * @return String bzetCntCd
	 */
	public String getBzetCntCd() {
		return this.bzetCntCd;
	}
	
	/**
	 *
	 * @param String bzetSeq
	 */
	public void setBzetSeq(String bzetSeq) {
		this.bzetSeq = bzetSeq;
	}
	
	/**
	 * 
	 * @return String bzetSeq
	 */
	public String getBzetSeq() {
		return this.bzetSeq;
	}
	
	/**
	 *
	 * @param String bzetNm
	 */
	public void setBzetNm(String bzetNm) {
		this.bzetNm = bzetNm;
	}
	
	/**
	 * 
	 * @return String bzetNm
	 */
	public String getBzetNm() {
		return this.bzetNm;
	}
	
	/**
	 *
	 * @param String bzetAddr
	 */
	public void setBzetAddr(String bzetAddr) {
		this.bzetAddr = bzetAddr;
	}
	
	/**
	 * 
	 * @return String bzetAddr
	 */
	public String getBzetAddr() {
		return this.bzetAddr;
	}
	
	/**
	 *
	 * @param String ctyNm
	 */
	public void setCtyNm(String ctyNm) {
		this.ctyNm = ctyNm;
	}
	
	/**
	 * 
	 * @return String ctyNm
	 */
	public String getCtyNm() {
		return this.ctyNm;
	}
	
	/**
	 *
	 * @param String steCd
	 */
	public void setSteCd(String steCd) {
		this.steCd = steCd;
	}
	
	/**
	 * 
	 * @return String steCd
	 */
	public String getSteCd() {
		return this.steCd;
	}
	
	/**
	 *
	 * @param String zipCd
	 */
	public void setZipCd(String zipCd) {
		this.zipCd = zipCd;
	}
	
	/**
	 * 
	 * @return String zipCd
	 */
	public String getZipCd() {
		return this.zipCd;
	}
	
	/**
	 *
	 * @param String cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * 
	 * @return String cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 *
	 * @param String cntcEml
	 */
	public void setCntcEml(String cntcEml) {
		this.cntcEml = cntcEml;
	}
	
	/**
	 * 
	 * @return String cntcEml
	 */
	public String getCntcEml() {
		return this.cntcEml;
	}
	
	/**
	 *
	 * @param String cntcPsonNm
	 */
	public void setCntcPsonNm(String cntcPsonNm) {
		this.cntcPsonNm = cntcPsonNm;
	}
	
	/**
	 * 
	 * @return String cntcPsonNm
	 */
	public String getCntcPsonNm() {
		return this.cntcPsonNm;
	}
	
	/**
	 *
	 * @param String bzetRmk
	 */
	public void setBzetRmk(String bzetRmk) {
		this.bzetRmk = bzetRmk;
	}
	
	/**
	 * 
	 * @return String bzetRmk
	 */
	public String getBzetRmk() {
		return this.bzetRmk;
	}
	
	/**
	 *
	 * @param String intlPhnNo
	 */
	public void setIntlPhnNo(String intlPhnNo) {
		this.intlPhnNo = intlPhnNo;
	}
	
	/**
	 * 
	 * @return String intlPhnNo
	 */
	public String getIntlPhnNo() {
		return this.intlPhnNo;
	}
	
	/**
	 *
	 * @param String arctPhnNo
	 */
	public void setArctPhnNo(String arctPhnNo) {
		this.arctPhnNo = arctPhnNo;
	}
	
	/**
	 * 
	 * @return String arctPhnNo
	 */
	public String getArctPhnNo() {
		return this.arctPhnNo;
	}
	
	/**
	 *
	 * @param String phnNo
	 */
	public void setPhnNo(String phnNo) {
		this.phnNo = phnNo;
	}
	
	/**
	 * 
	 * @return String phnNo
	 */
	public String getPhnNo() {
		return this.phnNo;
	}
	
	/**
	 *
	 * @param String fullPhnNo
	 */
	public void setFullPhnNo(String fullPhnNo) {
		this.fullPhnNo = fullPhnNo;
	}
	
	/**
	 * 
	 * @return String fullPhnNo
	 */
	public String getFullPhnNo() {
		return this.fullPhnNo;
	}
	
	/**
	 *
	 * @param String intlFaxNo
	 */
	public void setIntlFaxNo(String intlFaxNo) {
		this.intlFaxNo = intlFaxNo;
	}
	
	/**
	 * 
	 * @return String intlFaxNo
	 */
	public String getIntlFaxNo() {
		return this.intlFaxNo;
	}
	
	/**
	 *
	 * @param String arctFaxNo
	 */
	public void setArctFaxNo(String arctFaxNo) {
		this.arctFaxNo = arctFaxNo;
	}
	
	/**
	 * 
	 * @return String arctFaxNo
	 */
	public String getArctFaxNo() {
		return this.arctFaxNo;
	}
	
	/**
	 *
	 * @param String faxNo
	 */
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}
	
	/**
	 * 
	 * @return String faxNo
	 */
	public String getFaxNo() {
		return this.faxNo;
	}
	
	/**
	 *
	 * @param String fullFaxNo
	 */
	public void setFullFaxNo(String fullFaxNo) {
		this.fullFaxNo = fullFaxNo;
	}
	
	/**
	 * 
	 * @return String fullFaxNo
	 */
	public String getFullFaxNo() {
		return this.fullFaxNo;
	}
	
	/**
	 *
	 * @param String creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * 
	 * @return String creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 *
	 * @param String creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * 
	 * @return String creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 *
	 * @param String updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 
	 * @return String updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 *
	 * @param String updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * 
	 * @return String updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 *
	 * @param String deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * 
	 * @return String deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCustMstRowId(JSPUtil.getParameter(request, prefix + "cust_mst_row_id", ""));
		setCustAddrRowId(JSPUtil.getParameter(request, prefix + "cust_addr_row_id", ""));
		setCustAddrStsCd(JSPUtil.getParameter(request, prefix + "cust_addr_sts_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setAddrTpCd(JSPUtil.getParameter(request, prefix + "addr_tp_cd", ""));
		setAddrSeq(JSPUtil.getParameter(request, prefix + "addr_seq", ""));
		setPrmryChkFlg(JSPUtil.getParameter(request, prefix + "prmry_chk_flg", ""));
		setBzetCntCd(JSPUtil.getParameter(request, prefix + "bzet_cnt_cd", ""));
		setBzetSeq(JSPUtil.getParameter(request, prefix + "bzet_seq", ""));
		setBzetNm(JSPUtil.getParameter(request, prefix + "bzet_nm", ""));
		setBzetAddr(JSPUtil.getParameter(request, prefix + "bzet_addr", ""));
		setCtyNm(JSPUtil.getParameter(request, prefix + "cty_nm", ""));
		setSteCd(JSPUtil.getParameter(request, prefix + "ste_cd", ""));
		setZipCd(JSPUtil.getParameter(request, prefix + "zip_cd", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setCntcEml(JSPUtil.getParameter(request, prefix + "cntc_eml", ""));
		setCntcPsonNm(JSPUtil.getParameter(request, prefix + "cntc_pson_nm", ""));
		setBzetRmk(JSPUtil.getParameter(request, prefix + "bzet_rmk", ""));
		setIntlPhnNo(JSPUtil.getParameter(request, prefix + "intl_phn_no", ""));
		setArctPhnNo(JSPUtil.getParameter(request, prefix + "arct_phn_no", ""));
		setPhnNo(JSPUtil.getParameter(request, prefix + "phn_no", ""));
		setFullPhnNo(JSPUtil.getParameter(request, prefix + "full_phn_no", ""));
		setIntlFaxNo(JSPUtil.getParameter(request, prefix + "intl_fax_no", ""));
		setArctFaxNo(JSPUtil.getParameter(request, prefix + "arct_fax_no", ""));
		setFaxNo(JSPUtil.getParameter(request, prefix + "fax_no", ""));
		setFullFaxNo(JSPUtil.getParameter(request, prefix + "full_fax_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomerAddressIfVO[]
	 */
	public CustomerAddressIfVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomerAddressIfVO[]
	 */
	public CustomerAddressIfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomerAddressIfVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] custMstRowId = (JSPUtil.getParameter(request, prefix	+ "cust_mst_row_id", length));
			String[] custAddrRowId = (JSPUtil.getParameter(request, prefix	+ "cust_addr_row_id", length));
			String[] custAddrStsCd = (JSPUtil.getParameter(request, prefix	+ "cust_addr_sts_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] addrTpCd = (JSPUtil.getParameter(request, prefix	+ "addr_tp_cd", length));
			String[] addrSeq = (JSPUtil.getParameter(request, prefix	+ "addr_seq", length));
			String[] prmryChkFlg = (JSPUtil.getParameter(request, prefix	+ "prmry_chk_flg", length));
			String[] bzetCntCd = (JSPUtil.getParameter(request, prefix	+ "bzet_cnt_cd", length));
			String[] bzetSeq = (JSPUtil.getParameter(request, prefix	+ "bzet_seq", length));
			String[] bzetNm = (JSPUtil.getParameter(request, prefix	+ "bzet_nm", length));
			String[] bzetAddr = (JSPUtil.getParameter(request, prefix	+ "bzet_addr", length));
			String[] ctyNm = (JSPUtil.getParameter(request, prefix	+ "cty_nm", length));
			String[] steCd = (JSPUtil.getParameter(request, prefix	+ "ste_cd", length));
			String[] zipCd = (JSPUtil.getParameter(request, prefix	+ "zip_cd", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] cntcEml = (JSPUtil.getParameter(request, prefix	+ "cntc_eml", length));
			String[] cntcPsonNm = (JSPUtil.getParameter(request, prefix	+ "cntc_pson_nm", length));
			String[] bzetRmk = (JSPUtil.getParameter(request, prefix	+ "bzet_rmk", length));
			String[] intlPhnNo = (JSPUtil.getParameter(request, prefix	+ "intl_phn_no", length));
			String[] arctPhnNo = (JSPUtil.getParameter(request, prefix	+ "arct_phn_no", length));
			String[] phnNo = (JSPUtil.getParameter(request, prefix	+ "phn_no", length));
			String[] fullPhnNo = (JSPUtil.getParameter(request, prefix	+ "full_phn_no", length));
			String[] intlFaxNo = (JSPUtil.getParameter(request, prefix	+ "intl_fax_no", length));
			String[] arctFaxNo = (JSPUtil.getParameter(request, prefix	+ "arct_fax_no", length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no", length));
			String[] fullFaxNo = (JSPUtil.getParameter(request, prefix	+ "full_fax_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			/* Add a field line, do not delete */
			
			for (int i = 0; i < length; i++) {
				model = new CustomerAddressIfVO();
				if (ibflag[i] != null) 
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null) 
					model.setPagerows(pagerows[i]);
				if (custMstRowId[i] != null) 
					model.setCustMstRowId(custMstRowId[i]);
				if (custAddrRowId[i] != null) 
					model.setCustAddrRowId(custAddrRowId[i]);
				if (custAddrStsCd[i] != null) 
					model.setCustAddrStsCd(custAddrStsCd[i]);
				if (custCntCd[i] != null) 
					model.setCustCntCd(custCntCd[i]);
				if (custSeq[i] != null) 
					model.setCustSeq(custSeq[i]);
				if (addrTpCd[i] != null) 
					model.setAddrTpCd(addrTpCd[i]);
				if (addrSeq[i] != null) 
					model.setAddrSeq(addrSeq[i]);
				if (prmryChkFlg[i] != null) 
					model.setPrmryChkFlg(prmryChkFlg[i]);
				if (bzetCntCd[i] != null) 
					model.setBzetCntCd(bzetCntCd[i]);
				if (bzetSeq[i] != null) 
					model.setBzetSeq(bzetSeq[i]);
				if (bzetNm[i] != null) 
					model.setBzetNm(bzetNm[i]);
				if (bzetAddr[i] != null) 
					model.setBzetAddr(bzetAddr[i]);
				if (ctyNm[i] != null) 
					model.setCtyNm(ctyNm[i]);
				if (steCd[i] != null) 
					model.setSteCd(steCd[i]);
				if (zipCd[i] != null) 
					model.setZipCd(zipCd[i]);
				if (cntCd[i] != null) 
					model.setCntCd(cntCd[i]);
				if (cntcEml[i] != null) 
					model.setCntcEml(cntcEml[i]);
				if (cntcPsonNm[i] != null) 
					model.setCntcPsonNm(cntcPsonNm[i]);
				if (bzetRmk[i] != null) 
					model.setBzetRmk(bzetRmk[i]);
				if (intlPhnNo[i] != null) 
					model.setIntlPhnNo(intlPhnNo[i]);
				if (arctPhnNo[i] != null) 
					model.setArctPhnNo(arctPhnNo[i]);
				if (phnNo[i] != null) 
					model.setPhnNo(phnNo[i]);
				if (fullPhnNo[i] != null) 
					model.setFullPhnNo(fullPhnNo[i]);
				if (intlFaxNo[i] != null) 
					model.setIntlFaxNo(intlFaxNo[i]);
				if (arctFaxNo[i] != null) 
					model.setArctFaxNo(arctFaxNo[i]);
				if (faxNo[i] != null) 
					model.setFaxNo(faxNo[i]);
				if (fullFaxNo[i] != null) 
					model.setFullFaxNo(fullFaxNo[i]);
				if (creUsrId[i] != null) 
					model.setCreUsrId(creUsrId[i]);
				if (creDt[i] != null) 
					model.setCreDt(creDt[i]);
				if (updUsrId[i] != null) 
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null) 
					model.setUpdDt(updDt[i]);
				if (deltFlg[i] != null) 
					model.setDeltFlg(deltFlg[i]);
				/* Add a Method line, do not delete */
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomerAddressIfVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomerAddressIfVO[]
	 */
	public CustomerAddressIfVO[] getCustomerAddressIfVOs(){
		CustomerAddressIfVO[] vos = (CustomerAddressIfVO[])models.toArray(new CustomerAddressIfVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custMstRowId = this.custMstRowId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAddrRowId = this.custAddrRowId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAddrStsCd = this.custAddrStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addrTpCd = this.addrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addrSeq = this.addrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prmryChkFlg = this.prmryChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzetCntCd = this.bzetCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzetSeq = this.bzetSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzetNm = this.bzetNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzetAddr = this.bzetAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctyNm = this.ctyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steCd = this.steCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zipCd = this.zipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcEml = this.cntcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonNm = this.cntcPsonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzetRmk = this.bzetRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intlPhnNo = this.intlPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arctPhnNo = this.arctPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phnNo = this.phnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullPhnNo = this.fullPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intlFaxNo = this.intlFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arctFaxNo = this.arctFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullFaxNo = this.fullFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}