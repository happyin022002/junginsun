/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Eur24BlCustVO.java
*@FileTitle : Eur24BlCustVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.02
*@LastModifier : 
*@LastVersion : 1.0
* 2010.12.02  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo;

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

public class Eur24BlCustVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<Eur24BlCustVO> models = new ArrayList<Eur24BlCustVO>();
	
	/* Column Info */
	private String nCustSeq = null;
	/* Column Info */
	private String sCstmsDeclCntCd = null;
	/* Column Info */
	private String cEoriNo = null;
	/* Column Info */
	private String sCustSeq = null;
	/* Column Info */
	private String fCustZipId = null;
	/* Column Info */
	private String fCustAddr = null;
	/* Column Info */
	private String cCustSeq = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String cEurCstmsStNm = null;
	/* Column Info */
	private String nCustCtyNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String sCustZipId = null;
	/* Column Info */
	private String fCustNm = null;
	/* Column Info */
	private String cCustCtyNm = null;
	/* Column Info */
	private String cCustCntCd = null;
	/* Column Info */
	private String cstmsPortCd = null;
	/* Column Info */
	private String sBkgCustTpCd = null;
	/* Column Info */
	private String sCustCntCd = null;
	/* Column Info */
	private String fEurCstmsStNm = null;
	/* Column Info */
	private String fCustCtyNm = null;
	/* Column Info */
	private String fEoriNo = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String nCustCntCd = null;
	/* Column Info */
	private String sCustAddr = null;
	/* Column Info */
	private String sEurCstmsStNm = null;
	/* Column Info */
	private String cBkgCustTpCd = null;
	/* Column Info */
	private String nBkgCustTpCd = null;
	/* Column Info */
	private String sIbflag = null;
	/* Column Info */
	private String nCustZipId = null;
	/* Column Info */
	private String cCustNm = null;
	/* Column Info */
	private String nCustAddr = null;
	/* Column Info */
	private String fCustSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cCustAddr = null;
	/* Column Info */
	private String nCstmsDeclCntCd = null;
	/* Column Info */
	private String nIbflag = null;
	/* Column Info */
	private String fCstmsDeclCntCd = null;
	/* Column Info */
	private String cCstmsDeclCntCd = null;
	/* Column Info */
	private String cIbflag = null;
	/* Column Info */
	private String nCustNm = null;
	/* Column Info */
	private String nEoriNo = null;
	/* Column Info */
	private String sCustCtyNm = null;
	/* Column Info */
	private String sCustNm = null;
	/* Column Info */
	private String fIbflag = null;
	/* Column Info */
	private String nEurCstmsStNm = null;
	/* Column Info */
	private String fCustCntCd = null;
	/* Column Info */
	private String sEoriNo = null;
	/* Column Info */
	private String cCustZipId = null;
	/* Column Info */
	private String fBkgCustTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public Eur24BlCustVO() {}

	public Eur24BlCustVO(String ibflag, String pagerows, String blNo, String vvd, String cstmsPortCd, String sBkgCustTpCd, String sCustCntCd, String sCustSeq, String sCustNm, String sCustAddr, String sCustCtyNm, String sCstmsDeclCntCd, String sCustZipId, String sEurCstmsStNm, String sEoriNo, String sIbflag, String fBkgCustTpCd, String fCustCntCd, String fCustSeq, String fCustNm, String fCustAddr, String fCustCtyNm, String fCstmsDeclCntCd, String fCustZipId, String fEurCstmsStNm, String fEoriNo, String fIbflag, String cBkgCustTpCd, String cCustCntCd, String cCustSeq, String cCustNm, String cCustAddr, String cCustCtyNm, String cCstmsDeclCntCd, String cCustZipId, String cEurCstmsStNm, String cEoriNo, String cIbflag, String nBkgCustTpCd, String nCustCntCd, String nCustSeq, String nCustNm, String nCustAddr, String nCustCtyNm, String nCstmsDeclCntCd, String nCustZipId, String nEurCstmsStNm, String nEoriNo, String nIbflag) {
		this.nCustSeq = nCustSeq;
		this.sCstmsDeclCntCd = sCstmsDeclCntCd;
		this.cEoriNo = cEoriNo;
		this.sCustSeq = sCustSeq;
		this.fCustZipId = fCustZipId;
		this.fCustAddr = fCustAddr;
		this.cCustSeq = cCustSeq;
		this.blNo = blNo;
		this.cEurCstmsStNm = cEurCstmsStNm;
		this.nCustCtyNm = nCustCtyNm;
		this.pagerows = pagerows;
		this.sCustZipId = sCustZipId;
		this.fCustNm = fCustNm;
		this.cCustCtyNm = cCustCtyNm;
		this.cCustCntCd = cCustCntCd;
		this.cstmsPortCd = cstmsPortCd;
		this.sBkgCustTpCd = sBkgCustTpCd;
		this.sCustCntCd = sCustCntCd;
		this.fEurCstmsStNm = fEurCstmsStNm;
		this.fCustCtyNm = fCustCtyNm;
		this.fEoriNo = fEoriNo;
		this.vvd = vvd;
		this.nCustCntCd = nCustCntCd;
		this.sCustAddr = sCustAddr;
		this.sEurCstmsStNm = sEurCstmsStNm;
		this.cBkgCustTpCd = cBkgCustTpCd;
		this.nBkgCustTpCd = nBkgCustTpCd;
		this.sIbflag = sIbflag;
		this.nCustZipId = nCustZipId;
		this.cCustNm = cCustNm;
		this.nCustAddr = nCustAddr;
		this.fCustSeq = fCustSeq;
		this.ibflag = ibflag;
		this.cCustAddr = cCustAddr;
		this.nCstmsDeclCntCd = nCstmsDeclCntCd;
		this.nIbflag = nIbflag;
		this.fCstmsDeclCntCd = fCstmsDeclCntCd;
		this.cCstmsDeclCntCd = cCstmsDeclCntCd;
		this.cIbflag = cIbflag;
		this.nCustNm = nCustNm;
		this.nEoriNo = nEoriNo;
		this.sCustCtyNm = sCustCtyNm;
		this.sCustNm = sCustNm;
		this.fIbflag = fIbflag;
		this.nEurCstmsStNm = nEurCstmsStNm;
		this.fCustCntCd = fCustCntCd;
		this.sEoriNo = sEoriNo;
		this.cCustZipId = cCustZipId;
		this.fBkgCustTpCd = fBkgCustTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("n_cust_seq", getNCustSeq());
		this.hashColumns.put("s_cstms_decl_cnt_cd", getSCstmsDeclCntCd());
		this.hashColumns.put("c_eori_no", getCEoriNo());
		this.hashColumns.put("s_cust_seq", getSCustSeq());
		this.hashColumns.put("f_cust_zip_id", getFCustZipId());
		this.hashColumns.put("f_cust_addr", getFCustAddr());
		this.hashColumns.put("c_cust_seq", getCCustSeq());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("c_eur_cstms_st_nm", getCEurCstmsStNm());
		this.hashColumns.put("n_cust_cty_nm", getNCustCtyNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("s_cust_zip_id", getSCustZipId());
		this.hashColumns.put("f_cust_nm", getFCustNm());
		this.hashColumns.put("c_cust_cty_nm", getCCustCtyNm());
		this.hashColumns.put("c_cust_cnt_cd", getCCustCntCd());
		this.hashColumns.put("cstms_port_cd", getCstmsPortCd());
		this.hashColumns.put("s_bkg_cust_tp_cd", getSBkgCustTpCd());
		this.hashColumns.put("s_cust_cnt_cd", getSCustCntCd());
		this.hashColumns.put("f_eur_cstms_st_nm", getFEurCstmsStNm());
		this.hashColumns.put("f_cust_cty_nm", getFCustCtyNm());
		this.hashColumns.put("f_eori_no", getFEoriNo());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("n_cust_cnt_cd", getNCustCntCd());
		this.hashColumns.put("s_cust_addr", getSCustAddr());
		this.hashColumns.put("s_eur_cstms_st_nm", getSEurCstmsStNm());
		this.hashColumns.put("c_bkg_cust_tp_cd", getCBkgCustTpCd());
		this.hashColumns.put("n_bkg_cust_tp_cd", getNBkgCustTpCd());
		this.hashColumns.put("s_ibflag", getSIbflag());
		this.hashColumns.put("n_cust_zip_id", getNCustZipId());
		this.hashColumns.put("c_cust_nm", getCCustNm());
		this.hashColumns.put("n_cust_addr", getNCustAddr());
		this.hashColumns.put("f_cust_seq", getFCustSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("c_cust_addr", getCCustAddr());
		this.hashColumns.put("n_cstms_decl_cnt_cd", getNCstmsDeclCntCd());
		this.hashColumns.put("n_ibflag", getNIbflag());
		this.hashColumns.put("f_cstms_decl_cnt_cd", getFCstmsDeclCntCd());
		this.hashColumns.put("c_cstms_decl_cnt_cd", getCCstmsDeclCntCd());
		this.hashColumns.put("c_ibflag", getCIbflag());
		this.hashColumns.put("n_cust_nm", getNCustNm());
		this.hashColumns.put("n_eori_no", getNEoriNo());
		this.hashColumns.put("s_cust_cty_nm", getSCustCtyNm());
		this.hashColumns.put("s_cust_nm", getSCustNm());
		this.hashColumns.put("f_ibflag", getFIbflag());
		this.hashColumns.put("n_eur_cstms_st_nm", getNEurCstmsStNm());
		this.hashColumns.put("f_cust_cnt_cd", getFCustCntCd());
		this.hashColumns.put("s_eori_no", getSEoriNo());
		this.hashColumns.put("c_cust_zip_id", getCCustZipId());
		this.hashColumns.put("f_bkg_cust_tp_cd", getFBkgCustTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("n_cust_seq", "nCustSeq");
		this.hashFields.put("s_cstms_decl_cnt_cd", "sCstmsDeclCntCd");
		this.hashFields.put("c_eori_no", "cEoriNo");
		this.hashFields.put("s_cust_seq", "sCustSeq");
		this.hashFields.put("f_cust_zip_id", "fCustZipId");
		this.hashFields.put("f_cust_addr", "fCustAddr");
		this.hashFields.put("c_cust_seq", "cCustSeq");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("c_eur_cstms_st_nm", "cEurCstmsStNm");
		this.hashFields.put("n_cust_cty_nm", "nCustCtyNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("s_cust_zip_id", "sCustZipId");
		this.hashFields.put("f_cust_nm", "fCustNm");
		this.hashFields.put("c_cust_cty_nm", "cCustCtyNm");
		this.hashFields.put("c_cust_cnt_cd", "cCustCntCd");
		this.hashFields.put("cstms_port_cd", "cstmsPortCd");
		this.hashFields.put("s_bkg_cust_tp_cd", "sBkgCustTpCd");
		this.hashFields.put("s_cust_cnt_cd", "sCustCntCd");
		this.hashFields.put("f_eur_cstms_st_nm", "fEurCstmsStNm");
		this.hashFields.put("f_cust_cty_nm", "fCustCtyNm");
		this.hashFields.put("f_eori_no", "fEoriNo");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("n_cust_cnt_cd", "nCustCntCd");
		this.hashFields.put("s_cust_addr", "sCustAddr");
		this.hashFields.put("s_eur_cstms_st_nm", "sEurCstmsStNm");
		this.hashFields.put("c_bkg_cust_tp_cd", "cBkgCustTpCd");
		this.hashFields.put("n_bkg_cust_tp_cd", "nBkgCustTpCd");
		this.hashFields.put("s_ibflag", "sIbflag");
		this.hashFields.put("n_cust_zip_id", "nCustZipId");
		this.hashFields.put("c_cust_nm", "cCustNm");
		this.hashFields.put("n_cust_addr", "nCustAddr");
		this.hashFields.put("f_cust_seq", "fCustSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("c_cust_addr", "cCustAddr");
		this.hashFields.put("n_cstms_decl_cnt_cd", "nCstmsDeclCntCd");
		this.hashFields.put("n_ibflag", "nIbflag");
		this.hashFields.put("f_cstms_decl_cnt_cd", "fCstmsDeclCntCd");
		this.hashFields.put("c_cstms_decl_cnt_cd", "cCstmsDeclCntCd");
		this.hashFields.put("c_ibflag", "cIbflag");
		this.hashFields.put("n_cust_nm", "nCustNm");
		this.hashFields.put("n_eori_no", "nEoriNo");
		this.hashFields.put("s_cust_cty_nm", "sCustCtyNm");
		this.hashFields.put("s_cust_nm", "sCustNm");
		this.hashFields.put("f_ibflag", "fIbflag");
		this.hashFields.put("n_eur_cstms_st_nm", "nEurCstmsStNm");
		this.hashFields.put("f_cust_cnt_cd", "fCustCntCd");
		this.hashFields.put("s_eori_no", "sEoriNo");
		this.hashFields.put("c_cust_zip_id", "cCustZipId");
		this.hashFields.put("f_bkg_cust_tp_cd", "fBkgCustTpCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return nCustSeq
	 */
	public String getNCustSeq() {
		return this.nCustSeq;
	}
	
	/**
	 * Column Info
	 * @return sCstmsDeclCntCd
	 */
	public String getSCstmsDeclCntCd() {
		return this.sCstmsDeclCntCd;
	}
	
	/**
	 * Column Info
	 * @return cEoriNo
	 */
	public String getCEoriNo() {
		return this.cEoriNo;
	}
	
	/**
	 * Column Info
	 * @return sCustSeq
	 */
	public String getSCustSeq() {
		return this.sCustSeq;
	}
	
	/**
	 * Column Info
	 * @return fCustZipId
	 */
	public String getFCustZipId() {
		return this.fCustZipId;
	}
	
	/**
	 * Column Info
	 * @return fCustAddr
	 */
	public String getFCustAddr() {
		return this.fCustAddr;
	}
	
	/**
	 * Column Info
	 * @return cCustSeq
	 */
	public String getCCustSeq() {
		return this.cCustSeq;
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
	 * @return cEurCstmsStNm
	 */
	public String getCEurCstmsStNm() {
		return this.cEurCstmsStNm;
	}
	
	/**
	 * Column Info
	 * @return nCustCtyNm
	 */
	public String getNCustCtyNm() {
		return this.nCustCtyNm;
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
	 * @return sCustZipId
	 */
	public String getSCustZipId() {
		return this.sCustZipId;
	}
	
	/**
	 * Column Info
	 * @return fCustNm
	 */
	public String getFCustNm() {
		return this.fCustNm;
	}
	
	/**
	 * Column Info
	 * @return cCustCtyNm
	 */
	public String getCCustCtyNm() {
		return this.cCustCtyNm;
	}
	
	/**
	 * Column Info
	 * @return cCustCntCd
	 */
	public String getCCustCntCd() {
		return this.cCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsPortCd
	 */
	public String getCstmsPortCd() {
		return this.cstmsPortCd;
	}
	
	/**
	 * Column Info
	 * @return sBkgCustTpCd
	 */
	public String getSBkgCustTpCd() {
		return this.sBkgCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return sCustCntCd
	 */
	public String getSCustCntCd() {
		return this.sCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return fEurCstmsStNm
	 */
	public String getFEurCstmsStNm() {
		return this.fEurCstmsStNm;
	}
	
	/**
	 * Column Info
	 * @return fCustCtyNm
	 */
	public String getFCustCtyNm() {
		return this.fCustCtyNm;
	}
	
	/**
	 * Column Info
	 * @return fEoriNo
	 */
	public String getFEoriNo() {
		return this.fEoriNo;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return nCustCntCd
	 */
	public String getNCustCntCd() {
		return this.nCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return sCustAddr
	 */
	public String getSCustAddr() {
		return this.sCustAddr;
	}
	
	/**
	 * Column Info
	 * @return sEurCstmsStNm
	 */
	public String getSEurCstmsStNm() {
		return this.sEurCstmsStNm;
	}
	
	/**
	 * Column Info
	 * @return cBkgCustTpCd
	 */
	public String getCBkgCustTpCd() {
		return this.cBkgCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return nBkgCustTpCd
	 */
	public String getNBkgCustTpCd() {
		return this.nBkgCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return sIbflag
	 */
	public String getSIbflag() {
		return this.sIbflag;
	}
	
	/**
	 * Column Info
	 * @return nCustZipId
	 */
	public String getNCustZipId() {
		return this.nCustZipId;
	}
	
	/**
	 * Column Info
	 * @return cCustNm
	 */
	public String getCCustNm() {
		return this.cCustNm;
	}
	
	/**
	 * Column Info
	 * @return nCustAddr
	 */
	public String getNCustAddr() {
		return this.nCustAddr;
	}
	
	/**
	 * Column Info
	 * @return fCustSeq
	 */
	public String getFCustSeq() {
		return this.fCustSeq;
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
	 * @return cCustAddr
	 */
	public String getCCustAddr() {
		return this.cCustAddr;
	}
	
	/**
	 * Column Info
	 * @return nCstmsDeclCntCd
	 */
	public String getNCstmsDeclCntCd() {
		return this.nCstmsDeclCntCd;
	}
	
	/**
	 * Column Info
	 * @return nIbflag
	 */
	public String getNIbflag() {
		return this.nIbflag;
	}
	
	/**
	 * Column Info
	 * @return fCstmsDeclCntCd
	 */
	public String getFCstmsDeclCntCd() {
		return this.fCstmsDeclCntCd;
	}
	
	/**
	 * Column Info
	 * @return cCstmsDeclCntCd
	 */
	public String getCCstmsDeclCntCd() {
		return this.cCstmsDeclCntCd;
	}
	
	/**
	 * Column Info
	 * @return cIbflag
	 */
	public String getCIbflag() {
		return this.cIbflag;
	}
	
	/**
	 * Column Info
	 * @return nCustNm
	 */
	public String getNCustNm() {
		return this.nCustNm;
	}
	
	/**
	 * Column Info
	 * @return nEoriNo
	 */
	public String getNEoriNo() {
		return this.nEoriNo;
	}
	
	/**
	 * Column Info
	 * @return sCustCtyNm
	 */
	public String getSCustCtyNm() {
		return this.sCustCtyNm;
	}
	
	/**
	 * Column Info
	 * @return sCustNm
	 */
	public String getSCustNm() {
		return this.sCustNm;
	}
	
	/**
	 * Column Info
	 * @return fIbflag
	 */
	public String getFIbflag() {
		return this.fIbflag;
	}
	
	/**
	 * Column Info
	 * @return nEurCstmsStNm
	 */
	public String getNEurCstmsStNm() {
		return this.nEurCstmsStNm;
	}
	
	/**
	 * Column Info
	 * @return fCustCntCd
	 */
	public String getFCustCntCd() {
		return this.fCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return sEoriNo
	 */
	public String getSEoriNo() {
		return this.sEoriNo;
	}
	
	/**
	 * Column Info
	 * @return cCustZipId
	 */
	public String getCCustZipId() {
		return this.cCustZipId;
	}
	
	/**
	 * Column Info
	 * @return fBkgCustTpCd
	 */
	public String getFBkgCustTpCd() {
		return this.fBkgCustTpCd;
	}
	

	/**
	 * Column Info
	 * @param nCustSeq
	 */
	public void setNCustSeq(String nCustSeq) {
		this.nCustSeq = nCustSeq;
	}
	
	/**
	 * Column Info
	 * @param sCstmsDeclCntCd
	 */
	public void setSCstmsDeclCntCd(String sCstmsDeclCntCd) {
		this.sCstmsDeclCntCd = sCstmsDeclCntCd;
	}
	
	/**
	 * Column Info
	 * @param cEoriNo
	 */
	public void setCEoriNo(String cEoriNo) {
		this.cEoriNo = cEoriNo;
	}
	
	/**
	 * Column Info
	 * @param sCustSeq
	 */
	public void setSCustSeq(String sCustSeq) {
		this.sCustSeq = sCustSeq;
	}
	
	/**
	 * Column Info
	 * @param fCustZipId
	 */
	public void setFCustZipId(String fCustZipId) {
		this.fCustZipId = fCustZipId;
	}
	
	/**
	 * Column Info
	 * @param fCustAddr
	 */
	public void setFCustAddr(String fCustAddr) {
		this.fCustAddr = fCustAddr;
	}
	
	/**
	 * Column Info
	 * @param cCustSeq
	 */
	public void setCCustSeq(String cCustSeq) {
		this.cCustSeq = cCustSeq;
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
	 * @param cEurCstmsStNm
	 */
	public void setCEurCstmsStNm(String cEurCstmsStNm) {
		this.cEurCstmsStNm = cEurCstmsStNm;
	}
	
	/**
	 * Column Info
	 * @param nCustCtyNm
	 */
	public void setNCustCtyNm(String nCustCtyNm) {
		this.nCustCtyNm = nCustCtyNm;
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
	 * @param sCustZipId
	 */
	public void setSCustZipId(String sCustZipId) {
		this.sCustZipId = sCustZipId;
	}
	
	/**
	 * Column Info
	 * @param fCustNm
	 */
	public void setFCustNm(String fCustNm) {
		this.fCustNm = fCustNm;
	}
	
	/**
	 * Column Info
	 * @param cCustCtyNm
	 */
	public void setCCustCtyNm(String cCustCtyNm) {
		this.cCustCtyNm = cCustCtyNm;
	}
	
	/**
	 * Column Info
	 * @param cCustCntCd
	 */
	public void setCCustCntCd(String cCustCntCd) {
		this.cCustCntCd = cCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param cstmsPortCd
	 */
	public void setCstmsPortCd(String cstmsPortCd) {
		this.cstmsPortCd = cstmsPortCd;
	}
	
	/**
	 * Column Info
	 * @param sBkgCustTpCd
	 */
	public void setSBkgCustTpCd(String sBkgCustTpCd) {
		this.sBkgCustTpCd = sBkgCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param sCustCntCd
	 */
	public void setSCustCntCd(String sCustCntCd) {
		this.sCustCntCd = sCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param fEurCstmsStNm
	 */
	public void setFEurCstmsStNm(String fEurCstmsStNm) {
		this.fEurCstmsStNm = fEurCstmsStNm;
	}
	
	/**
	 * Column Info
	 * @param fCustCtyNm
	 */
	public void setFCustCtyNm(String fCustCtyNm) {
		this.fCustCtyNm = fCustCtyNm;
	}
	
	/**
	 * Column Info
	 * @param fEoriNo
	 */
	public void setFEoriNo(String fEoriNo) {
		this.fEoriNo = fEoriNo;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param nCustCntCd
	 */
	public void setNCustCntCd(String nCustCntCd) {
		this.nCustCntCd = nCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param sCustAddr
	 */
	public void setSCustAddr(String sCustAddr) {
		this.sCustAddr = sCustAddr;
	}
	
	/**
	 * Column Info
	 * @param sEurCstmsStNm
	 */
	public void setSEurCstmsStNm(String sEurCstmsStNm) {
		this.sEurCstmsStNm = sEurCstmsStNm;
	}
	
	/**
	 * Column Info
	 * @param cBkgCustTpCd
	 */
	public void setCBkgCustTpCd(String cBkgCustTpCd) {
		this.cBkgCustTpCd = cBkgCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param nBkgCustTpCd
	 */
	public void setNBkgCustTpCd(String nBkgCustTpCd) {
		this.nBkgCustTpCd = nBkgCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param sIbflag
	 */
	public void setSIbflag(String sIbflag) {
		this.sIbflag = sIbflag;
	}
	
	/**
	 * Column Info
	 * @param nCustZipId
	 */
	public void setNCustZipId(String nCustZipId) {
		this.nCustZipId = nCustZipId;
	}
	
	/**
	 * Column Info
	 * @param cCustNm
	 */
	public void setCCustNm(String cCustNm) {
		this.cCustNm = cCustNm;
	}
	
	/**
	 * Column Info
	 * @param nCustAddr
	 */
	public void setNCustAddr(String nCustAddr) {
		this.nCustAddr = nCustAddr;
	}
	
	/**
	 * Column Info
	 * @param fCustSeq
	 */
	public void setFCustSeq(String fCustSeq) {
		this.fCustSeq = fCustSeq;
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
	 * @param cCustAddr
	 */
	public void setCCustAddr(String cCustAddr) {
		this.cCustAddr = cCustAddr;
	}
	
	/**
	 * Column Info
	 * @param nCstmsDeclCntCd
	 */
	public void setNCstmsDeclCntCd(String nCstmsDeclCntCd) {
		this.nCstmsDeclCntCd = nCstmsDeclCntCd;
	}
	
	/**
	 * Column Info
	 * @param nIbflag
	 */
	public void setNIbflag(String nIbflag) {
		this.nIbflag = nIbflag;
	}
	
	/**
	 * Column Info
	 * @param fCstmsDeclCntCd
	 */
	public void setFCstmsDeclCntCd(String fCstmsDeclCntCd) {
		this.fCstmsDeclCntCd = fCstmsDeclCntCd;
	}
	
	/**
	 * Column Info
	 * @param cCstmsDeclCntCd
	 */
	public void setCCstmsDeclCntCd(String cCstmsDeclCntCd) {
		this.cCstmsDeclCntCd = cCstmsDeclCntCd;
	}
	
	/**
	 * Column Info
	 * @param cIbflag
	 */
	public void setCIbflag(String cIbflag) {
		this.cIbflag = cIbflag;
	}
	
	/**
	 * Column Info
	 * @param nCustNm
	 */
	public void setNCustNm(String nCustNm) {
		this.nCustNm = nCustNm;
	}
	
	/**
	 * Column Info
	 * @param nEoriNo
	 */
	public void setNEoriNo(String nEoriNo) {
		this.nEoriNo = nEoriNo;
	}
	
	/**
	 * Column Info
	 * @param sCustCtyNm
	 */
	public void setSCustCtyNm(String sCustCtyNm) {
		this.sCustCtyNm = sCustCtyNm;
	}
	
	/**
	 * Column Info
	 * @param sCustNm
	 */
	public void setSCustNm(String sCustNm) {
		this.sCustNm = sCustNm;
	}
	
	/**
	 * Column Info
	 * @param fIbflag
	 */
	public void setFIbflag(String fIbflag) {
		this.fIbflag = fIbflag;
	}
	
	/**
	 * Column Info
	 * @param nEurCstmsStNm
	 */
	public void setNEurCstmsStNm(String nEurCstmsStNm) {
		this.nEurCstmsStNm = nEurCstmsStNm;
	}
	
	/**
	 * Column Info
	 * @param fCustCntCd
	 */
	public void setFCustCntCd(String fCustCntCd) {
		this.fCustCntCd = fCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param sEoriNo
	 */
	public void setSEoriNo(String sEoriNo) {
		this.sEoriNo = sEoriNo;
	}
	
	/**
	 * Column Info
	 * @param cCustZipId
	 */
	public void setCCustZipId(String cCustZipId) {
		this.cCustZipId = cCustZipId;
	}
	
	/**
	 * Column Info
	 * @param fBkgCustTpCd
	 */
	public void setFBkgCustTpCd(String fBkgCustTpCd) {
		this.fBkgCustTpCd = fBkgCustTpCd;
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
		setNCustSeq(JSPUtil.getParameter(request, prefix + "n_cust_seq", ""));
		setSCstmsDeclCntCd(JSPUtil.getParameter(request, prefix + "s_cstms_decl_cnt_cd", ""));
		setCEoriNo(JSPUtil.getParameter(request, prefix + "c_eori_no", ""));
		setSCustSeq(JSPUtil.getParameter(request, prefix + "s_cust_seq", ""));
		setFCustZipId(JSPUtil.getParameter(request, prefix + "f_cust_zip_id", ""));
		setFCustAddr(JSPUtil.getParameter(request, prefix + "f_cust_addr", ""));
		setCCustSeq(JSPUtil.getParameter(request, prefix + "c_cust_seq", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setCEurCstmsStNm(JSPUtil.getParameter(request, prefix + "c_eur_cstms_st_nm", ""));
		setNCustCtyNm(JSPUtil.getParameter(request, prefix + "n_cust_cty_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSCustZipId(JSPUtil.getParameter(request, prefix + "s_cust_zip_id", ""));
		setFCustNm(JSPUtil.getParameter(request, prefix + "f_cust_nm", ""));
		setCCustCtyNm(JSPUtil.getParameter(request, prefix + "c_cust_cty_nm", ""));
		setCCustCntCd(JSPUtil.getParameter(request, prefix + "c_cust_cnt_cd", ""));
		setCstmsPortCd(JSPUtil.getParameter(request, prefix + "cstms_port_cd", ""));
		setSBkgCustTpCd(JSPUtil.getParameter(request, prefix + "s_bkg_cust_tp_cd", ""));
		setSCustCntCd(JSPUtil.getParameter(request, prefix + "s_cust_cnt_cd", ""));
		setFEurCstmsStNm(JSPUtil.getParameter(request, prefix + "f_eur_cstms_st_nm", ""));
		setFCustCtyNm(JSPUtil.getParameter(request, prefix + "f_cust_cty_nm", ""));
		setFEoriNo(JSPUtil.getParameter(request, prefix + "f_eori_no", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setNCustCntCd(JSPUtil.getParameter(request, prefix + "n_cust_cnt_cd", ""));
		setSCustAddr(JSPUtil.getParameter(request, prefix + "s_cust_addr", ""));
		setSEurCstmsStNm(JSPUtil.getParameter(request, prefix + "s_eur_cstms_st_nm", ""));
		setCBkgCustTpCd(JSPUtil.getParameter(request, prefix + "c_bkg_cust_tp_cd", ""));
		setNBkgCustTpCd(JSPUtil.getParameter(request, prefix + "n_bkg_cust_tp_cd", ""));
		setSIbflag(JSPUtil.getParameter(request, prefix + "s_ibflag", ""));
		setNCustZipId(JSPUtil.getParameter(request, prefix + "n_cust_zip_id", ""));
		setCCustNm(JSPUtil.getParameter(request, prefix + "c_cust_nm", ""));
		setNCustAddr(JSPUtil.getParameter(request, prefix + "n_cust_addr", ""));
		setFCustSeq(JSPUtil.getParameter(request, prefix + "f_cust_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCCustAddr(JSPUtil.getParameter(request, prefix + "c_cust_addr", ""));
		setNCstmsDeclCntCd(JSPUtil.getParameter(request, prefix + "n_cstms_decl_cnt_cd", ""));
		setNIbflag(JSPUtil.getParameter(request, prefix + "n_ibflag", ""));
		setFCstmsDeclCntCd(JSPUtil.getParameter(request, prefix + "f_cstms_decl_cnt_cd", ""));
		setCCstmsDeclCntCd(JSPUtil.getParameter(request, prefix + "c_cstms_decl_cnt_cd", ""));
		setCIbflag(JSPUtil.getParameter(request, prefix + "c_ibflag", ""));
		setNCustNm(JSPUtil.getParameter(request, prefix + "n_cust_nm", ""));
		setNEoriNo(JSPUtil.getParameter(request, prefix + "n_eori_no", ""));
		setSCustCtyNm(JSPUtil.getParameter(request, prefix + "s_cust_cty_nm", ""));
		setSCustNm(JSPUtil.getParameter(request, prefix + "s_cust_nm", ""));
		setFIbflag(JSPUtil.getParameter(request, prefix + "f_ibflag", ""));
		setNEurCstmsStNm(JSPUtil.getParameter(request, prefix + "n_eur_cstms_st_nm", ""));
		setFCustCntCd(JSPUtil.getParameter(request, prefix + "f_cust_cnt_cd", ""));
		setSEoriNo(JSPUtil.getParameter(request, prefix + "s_eori_no", ""));
		setCCustZipId(JSPUtil.getParameter(request, prefix + "c_cust_zip_id", ""));
		setFBkgCustTpCd(JSPUtil.getParameter(request, prefix + "f_bkg_cust_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Eur24BlCustVO[]
	 */
	public Eur24BlCustVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return Eur24BlCustVO[]
	 */
	public Eur24BlCustVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Eur24BlCustVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] nCustSeq = (JSPUtil.getParameter(request, prefix	+ "n_cust_seq", length));
			String[] sCstmsDeclCntCd = (JSPUtil.getParameter(request, prefix	+ "s_cstms_decl_cnt_cd", length));
			String[] cEoriNo = (JSPUtil.getParameter(request, prefix	+ "c_eori_no", length));
			String[] sCustSeq = (JSPUtil.getParameter(request, prefix	+ "s_cust_seq", length));
			String[] fCustZipId = (JSPUtil.getParameter(request, prefix	+ "f_cust_zip_id", length));
			String[] fCustAddr = (JSPUtil.getParameter(request, prefix	+ "f_cust_addr", length));
			String[] cCustSeq = (JSPUtil.getParameter(request, prefix	+ "c_cust_seq", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] cEurCstmsStNm = (JSPUtil.getParameter(request, prefix	+ "c_eur_cstms_st_nm", length));
			String[] nCustCtyNm = (JSPUtil.getParameter(request, prefix	+ "n_cust_cty_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] sCustZipId = (JSPUtil.getParameter(request, prefix	+ "s_cust_zip_id", length));
			String[] fCustNm = (JSPUtil.getParameter(request, prefix	+ "f_cust_nm", length));
			String[] cCustCtyNm = (JSPUtil.getParameter(request, prefix	+ "c_cust_cty_nm", length));
			String[] cCustCntCd = (JSPUtil.getParameter(request, prefix	+ "c_cust_cnt_cd", length));
			String[] cstmsPortCd = (JSPUtil.getParameter(request, prefix	+ "cstms_port_cd", length));
			String[] sBkgCustTpCd = (JSPUtil.getParameter(request, prefix	+ "s_bkg_cust_tp_cd", length));
			String[] sCustCntCd = (JSPUtil.getParameter(request, prefix	+ "s_cust_cnt_cd", length));
			String[] fEurCstmsStNm = (JSPUtil.getParameter(request, prefix	+ "f_eur_cstms_st_nm", length));
			String[] fCustCtyNm = (JSPUtil.getParameter(request, prefix	+ "f_cust_cty_nm", length));
			String[] fEoriNo = (JSPUtil.getParameter(request, prefix	+ "f_eori_no", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] nCustCntCd = (JSPUtil.getParameter(request, prefix	+ "n_cust_cnt_cd", length));
			String[] sCustAddr = (JSPUtil.getParameter(request, prefix	+ "s_cust_addr", length));
			String[] sEurCstmsStNm = (JSPUtil.getParameter(request, prefix	+ "s_eur_cstms_st_nm", length));
			String[] cBkgCustTpCd = (JSPUtil.getParameter(request, prefix	+ "c_bkg_cust_tp_cd", length));
			String[] nBkgCustTpCd = (JSPUtil.getParameter(request, prefix	+ "n_bkg_cust_tp_cd", length));
			String[] sIbflag = (JSPUtil.getParameter(request, prefix	+ "s_ibflag", length));
			String[] nCustZipId = (JSPUtil.getParameter(request, prefix	+ "n_cust_zip_id", length));
			String[] cCustNm = (JSPUtil.getParameter(request, prefix	+ "c_cust_nm", length));
			String[] nCustAddr = (JSPUtil.getParameter(request, prefix	+ "n_cust_addr", length));
			String[] fCustSeq = (JSPUtil.getParameter(request, prefix	+ "f_cust_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cCustAddr = (JSPUtil.getParameter(request, prefix	+ "c_cust_addr", length));
			String[] nCstmsDeclCntCd = (JSPUtil.getParameter(request, prefix	+ "n_cstms_decl_cnt_cd", length));
			String[] nIbflag = (JSPUtil.getParameter(request, prefix	+ "n_ibflag", length));
			String[] fCstmsDeclCntCd = (JSPUtil.getParameter(request, prefix	+ "f_cstms_decl_cnt_cd", length));
			String[] cCstmsDeclCntCd = (JSPUtil.getParameter(request, prefix	+ "c_cstms_decl_cnt_cd", length));
			String[] cIbflag = (JSPUtil.getParameter(request, prefix	+ "c_ibflag", length));
			String[] nCustNm = (JSPUtil.getParameter(request, prefix	+ "n_cust_nm", length));
			String[] nEoriNo = (JSPUtil.getParameter(request, prefix	+ "n_eori_no", length));
			String[] sCustCtyNm = (JSPUtil.getParameter(request, prefix	+ "s_cust_cty_nm", length));
			String[] sCustNm = (JSPUtil.getParameter(request, prefix	+ "s_cust_nm", length));
			String[] fIbflag = (JSPUtil.getParameter(request, prefix	+ "f_ibflag", length));
			String[] nEurCstmsStNm = (JSPUtil.getParameter(request, prefix	+ "n_eur_cstms_st_nm", length));
			String[] fCustCntCd = (JSPUtil.getParameter(request, prefix	+ "f_cust_cnt_cd", length));
			String[] sEoriNo = (JSPUtil.getParameter(request, prefix	+ "s_eori_no", length));
			String[] cCustZipId = (JSPUtil.getParameter(request, prefix	+ "c_cust_zip_id", length));
			String[] fBkgCustTpCd = (JSPUtil.getParameter(request, prefix	+ "f_bkg_cust_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new Eur24BlCustVO();
				if (nCustSeq[i] != null)
					model.setNCustSeq(nCustSeq[i]);
				if (sCstmsDeclCntCd[i] != null)
					model.setSCstmsDeclCntCd(sCstmsDeclCntCd[i]);
				if (cEoriNo[i] != null)
					model.setCEoriNo(cEoriNo[i]);
				if (sCustSeq[i] != null)
					model.setSCustSeq(sCustSeq[i]);
				if (fCustZipId[i] != null)
					model.setFCustZipId(fCustZipId[i]);
				if (fCustAddr[i] != null)
					model.setFCustAddr(fCustAddr[i]);
				if (cCustSeq[i] != null)
					model.setCCustSeq(cCustSeq[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (cEurCstmsStNm[i] != null)
					model.setCEurCstmsStNm(cEurCstmsStNm[i]);
				if (nCustCtyNm[i] != null)
					model.setNCustCtyNm(nCustCtyNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (sCustZipId[i] != null)
					model.setSCustZipId(sCustZipId[i]);
				if (fCustNm[i] != null)
					model.setFCustNm(fCustNm[i]);
				if (cCustCtyNm[i] != null)
					model.setCCustCtyNm(cCustCtyNm[i]);
				if (cCustCntCd[i] != null)
					model.setCCustCntCd(cCustCntCd[i]);
				if (cstmsPortCd[i] != null)
					model.setCstmsPortCd(cstmsPortCd[i]);
				if (sBkgCustTpCd[i] != null)
					model.setSBkgCustTpCd(sBkgCustTpCd[i]);
				if (sCustCntCd[i] != null)
					model.setSCustCntCd(sCustCntCd[i]);
				if (fEurCstmsStNm[i] != null)
					model.setFEurCstmsStNm(fEurCstmsStNm[i]);
				if (fCustCtyNm[i] != null)
					model.setFCustCtyNm(fCustCtyNm[i]);
				if (fEoriNo[i] != null)
					model.setFEoriNo(fEoriNo[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (nCustCntCd[i] != null)
					model.setNCustCntCd(nCustCntCd[i]);
				if (sCustAddr[i] != null)
					model.setSCustAddr(sCustAddr[i]);
				if (sEurCstmsStNm[i] != null)
					model.setSEurCstmsStNm(sEurCstmsStNm[i]);
				if (cBkgCustTpCd[i] != null)
					model.setCBkgCustTpCd(cBkgCustTpCd[i]);
				if (nBkgCustTpCd[i] != null)
					model.setNBkgCustTpCd(nBkgCustTpCd[i]);
				if (sIbflag[i] != null)
					model.setSIbflag(sIbflag[i]);
				if (nCustZipId[i] != null)
					model.setNCustZipId(nCustZipId[i]);
				if (cCustNm[i] != null)
					model.setCCustNm(cCustNm[i]);
				if (nCustAddr[i] != null)
					model.setNCustAddr(nCustAddr[i]);
				if (fCustSeq[i] != null)
					model.setFCustSeq(fCustSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cCustAddr[i] != null)
					model.setCCustAddr(cCustAddr[i]);
				if (nCstmsDeclCntCd[i] != null)
					model.setNCstmsDeclCntCd(nCstmsDeclCntCd[i]);
				if (nIbflag[i] != null)
					model.setNIbflag(nIbflag[i]);
				if (fCstmsDeclCntCd[i] != null)
					model.setFCstmsDeclCntCd(fCstmsDeclCntCd[i]);
				if (cCstmsDeclCntCd[i] != null)
					model.setCCstmsDeclCntCd(cCstmsDeclCntCd[i]);
				if (cIbflag[i] != null)
					model.setCIbflag(cIbflag[i]);
				if (nCustNm[i] != null)
					model.setNCustNm(nCustNm[i]);
				if (nEoriNo[i] != null)
					model.setNEoriNo(nEoriNo[i]);
				if (sCustCtyNm[i] != null)
					model.setSCustCtyNm(sCustCtyNm[i]);
				if (sCustNm[i] != null)
					model.setSCustNm(sCustNm[i]);
				if (fIbflag[i] != null)
					model.setFIbflag(fIbflag[i]);
				if (nEurCstmsStNm[i] != null)
					model.setNEurCstmsStNm(nEurCstmsStNm[i]);
				if (fCustCntCd[i] != null)
					model.setFCustCntCd(fCustCntCd[i]);
				if (sEoriNo[i] != null)
					model.setSEoriNo(sEoriNo[i]);
				if (cCustZipId[i] != null)
					model.setCCustZipId(cCustZipId[i]);
				if (fBkgCustTpCd[i] != null)
					model.setFBkgCustTpCd(fBkgCustTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEur24BlCustVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Eur24BlCustVO[]
	 */
	public Eur24BlCustVO[] getEur24BlCustVOs(){
		Eur24BlCustVO[] vos = (Eur24BlCustVO[])models.toArray(new Eur24BlCustVO[models.size()]);
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
		this.nCustSeq = this.nCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCstmsDeclCntCd = this.sCstmsDeclCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cEoriNo = this.cEoriNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustSeq = this.sCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCustZipId = this.fCustZipId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCustAddr = this.fCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCustSeq = this.cCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cEurCstmsStNm = this.cEurCstmsStNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nCustCtyNm = this.nCustCtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustZipId = this.sCustZipId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCustNm = this.fCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCustCtyNm = this.cCustCtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCustCntCd = this.cCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsPortCd = this.cstmsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBkgCustTpCd = this.sBkgCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustCntCd = this.sCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fEurCstmsStNm = this.fEurCstmsStNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCustCtyNm = this.fCustCtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fEoriNo = this.fEoriNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nCustCntCd = this.nCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustAddr = this.sCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEurCstmsStNm = this.sEurCstmsStNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cBkgCustTpCd = this.cBkgCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nBkgCustTpCd = this.nBkgCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIbflag = this.sIbflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nCustZipId = this.nCustZipId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCustNm = this.cCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nCustAddr = this.nCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCustSeq = this.fCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCustAddr = this.cCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nCstmsDeclCntCd = this.nCstmsDeclCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nIbflag = this.nIbflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCstmsDeclCntCd = this.fCstmsDeclCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCstmsDeclCntCd = this.cCstmsDeclCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cIbflag = this.cIbflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nCustNm = this.nCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nEoriNo = this.nEoriNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustCtyNm = this.sCustCtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustNm = this.sCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fIbflag = this.fIbflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nEurCstmsStNm = this.nEurCstmsStNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCustCntCd = this.fCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEoriNo = this.sEoriNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCustZipId = this.cCustZipId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBkgCustTpCd = this.fBkgCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
