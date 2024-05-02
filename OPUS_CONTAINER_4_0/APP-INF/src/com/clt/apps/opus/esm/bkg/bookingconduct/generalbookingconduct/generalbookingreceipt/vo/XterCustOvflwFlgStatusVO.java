/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : XterCustOvflwFlgStatusVO.java
*@FileTitle : XterCustOvflwFlgStatusVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.27
*@LastModifier : Moon Hwan Choi
*@LastVersion : 1.0
* 2015.04.27 Moon Hwan Choi 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author Moon Hwan Choi
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class XterCustOvflwFlgStatusVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<XterCustOvflwFlgStatusVO> models = new ArrayList<XterCustOvflwFlgStatusVO>();
	
	/* Column Info */
	private String cnOvflwFlg = null;
	/* Column Info */
	private String anOvflwFlg = null;
	/* Column Info */
	private String exOvflwFlg = null;
	/* Column Info */
	private String nfOvflwFlg = null;
	/* Column Info */
	private String anOvflwChkFlg = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String cnCustAddr = null;
	/* Column Info */
	private String exCustNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cnOvflwChkFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String nfOvflwChkFlg = null;
	/* Column Info */
	private String ffCustNm = null;
	/* Column Info */
	private String shOvflwChkFlg = null;
	/* Column Info */
	private String exOvflwChkFlg = null;
	/* Column Info */
	private String custTpCd = null;
	/* Column Info */
	private String nfCustNm = null;
	/* Column Info */
	private String ffOvflwChkFlg = null;
	/* Column Info */
	private String nfCustAddr = null;
	/* Column Info */
	private String anCustNm = null;
	/* Column Info */
	private String shCustAddr = null;
	/* Column Info */
	private String ffOvflwFlg = null;
	/* Column Info */
	private String shCustNm = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String shOvflwFlg = null;
	/* Column Info */
	private String xterRqstSeq = null;
	/* Column Info */
	private String cnCustNm = null;
	/* Column Info */
	private String xterRqstNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public XterCustOvflwFlgStatusVO() {}

	public XterCustOvflwFlgStatusVO(String ibflag, String pagerows, String xterRqstNo, String xterRqstSeq, String shCustNm, String shCustAddr, String shOvflwFlg, String cnCustNm, String cnCustAddr, String cnOvflwFlg, String nfCustNm, String nfCustAddr, String nfOvflwFlg, String ffCustNm, String ffOvflwFlg, String anCustNm, String anOvflwFlg, String exCustNm, String exOvflwFlg, String bkgNo, String blNo, String custTpCd, String shOvflwChkFlg, String cnOvflwChkFlg, String nfOvflwChkFlg, String ffOvflwChkFlg, String anOvflwChkFlg, String exOvflwChkFlg) {
		this.cnOvflwFlg = cnOvflwFlg;
		this.anOvflwFlg = anOvflwFlg;
		this.exOvflwFlg = exOvflwFlg;
		this.nfOvflwFlg = nfOvflwFlg;
		this.anOvflwChkFlg = anOvflwChkFlg;
		this.blNo = blNo;
		this.cnCustAddr = cnCustAddr;
		this.exCustNm = exCustNm;
		this.pagerows = pagerows;
		this.cnOvflwChkFlg = cnOvflwChkFlg;
		this.ibflag = ibflag;
		this.nfOvflwChkFlg = nfOvflwChkFlg;
		this.ffCustNm = ffCustNm;
		this.shOvflwChkFlg = shOvflwChkFlg;
		this.exOvflwChkFlg = exOvflwChkFlg;
		this.custTpCd = custTpCd;
		this.nfCustNm = nfCustNm;
		this.ffOvflwChkFlg = ffOvflwChkFlg;
		this.nfCustAddr = nfCustAddr;
		this.anCustNm = anCustNm;
		this.shCustAddr = shCustAddr;
		this.ffOvflwFlg = ffOvflwFlg;
		this.shCustNm = shCustNm;
		this.bkgNo = bkgNo;
		this.shOvflwFlg = shOvflwFlg;
		this.xterRqstSeq = xterRqstSeq;
		this.cnCustNm = cnCustNm;
		this.xterRqstNo = xterRqstNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cn_ovflw_flg", getCnOvflwFlg());
		this.hashColumns.put("an_ovflw_flg", getAnOvflwFlg());
		this.hashColumns.put("ex_ovflw_flg", getExOvflwFlg());
		this.hashColumns.put("nf_ovflw_flg", getNfOvflwFlg());
		this.hashColumns.put("an_ovflw_chk_flg", getAnOvflwChkFlg());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("cn_cust_addr", getCnCustAddr());
		this.hashColumns.put("ex_cust_nm", getExCustNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cn_ovflw_chk_flg", getCnOvflwChkFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("nf_ovflw_chk_flg", getNfOvflwChkFlg());
		this.hashColumns.put("ff_cust_nm", getFfCustNm());
		this.hashColumns.put("sh_ovflw_chk_flg", getShOvflwChkFlg());
		this.hashColumns.put("ex_ovflw_chk_flg", getExOvflwChkFlg());
		this.hashColumns.put("cust_tp_cd", getCustTpCd());
		this.hashColumns.put("nf_cust_nm", getNfCustNm());
		this.hashColumns.put("ff_ovflw_chk_flg", getFfOvflwChkFlg());
		this.hashColumns.put("nf_cust_addr", getNfCustAddr());
		this.hashColumns.put("an_cust_nm", getAnCustNm());
		this.hashColumns.put("sh_cust_addr", getShCustAddr());
		this.hashColumns.put("ff_ovflw_flg", getFfOvflwFlg());
		this.hashColumns.put("sh_cust_nm", getShCustNm());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("sh_ovflw_flg", getShOvflwFlg());
		this.hashColumns.put("xter_rqst_seq", getXterRqstSeq());
		this.hashColumns.put("cn_cust_nm", getCnCustNm());
		this.hashColumns.put("xter_rqst_no", getXterRqstNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cn_ovflw_flg", "cnOvflwFlg");
		this.hashFields.put("an_ovflw_flg", "anOvflwFlg");
		this.hashFields.put("ex_ovflw_flg", "exOvflwFlg");
		this.hashFields.put("nf_ovflw_flg", "nfOvflwFlg");
		this.hashFields.put("an_ovflw_chk_flg", "anOvflwChkFlg");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("cn_cust_addr", "cnCustAddr");
		this.hashFields.put("ex_cust_nm", "exCustNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cn_ovflw_chk_flg", "cnOvflwChkFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("nf_ovflw_chk_flg", "nfOvflwChkFlg");
		this.hashFields.put("ff_cust_nm", "ffCustNm");
		this.hashFields.put("sh_ovflw_chk_flg", "shOvflwChkFlg");
		this.hashFields.put("ex_ovflw_chk_flg", "exOvflwChkFlg");
		this.hashFields.put("cust_tp_cd", "custTpCd");
		this.hashFields.put("nf_cust_nm", "nfCustNm");
		this.hashFields.put("ff_ovflw_chk_flg", "ffOvflwChkFlg");
		this.hashFields.put("nf_cust_addr", "nfCustAddr");
		this.hashFields.put("an_cust_nm", "anCustNm");
		this.hashFields.put("sh_cust_addr", "shCustAddr");
		this.hashFields.put("ff_ovflw_flg", "ffOvflwFlg");
		this.hashFields.put("sh_cust_nm", "shCustNm");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("sh_ovflw_flg", "shOvflwFlg");
		this.hashFields.put("xter_rqst_seq", "xterRqstSeq");
		this.hashFields.put("cn_cust_nm", "cnCustNm");
		this.hashFields.put("xter_rqst_no", "xterRqstNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cnOvflwFlg
	 */
	public String getCnOvflwFlg() {
		return this.cnOvflwFlg;
	}
	
	/**
	 * Column Info
	 * @return anOvflwFlg
	 */
	public String getAnOvflwFlg() {
		return this.anOvflwFlg;
	}
	
	/**
	 * Column Info
	 * @return exOvflwFlg
	 */
	public String getExOvflwFlg() {
		return this.exOvflwFlg;
	}
	
	/**
	 * Column Info
	 * @return nfOvflwFlg
	 */
	public String getNfOvflwFlg() {
		return this.nfOvflwFlg;
	}
	
	/**
	 * Column Info
	 * @return anOvflwChkFlg
	 */
	public String getAnOvflwChkFlg() {
		return this.anOvflwChkFlg;
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
	 * @return cnCustAddr
	 */
	public String getCnCustAddr() {
		return this.cnCustAddr;
	}
	
	/**
	 * Column Info
	 * @return exCustNm
	 */
	public String getExCustNm() {
		return this.exCustNm;
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
	 * @return cnOvflwChkFlg
	 */
	public String getCnOvflwChkFlg() {
		return this.cnOvflwChkFlg;
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
	 * @return nfOvflwChkFlg
	 */
	public String getNfOvflwChkFlg() {
		return this.nfOvflwChkFlg;
	}
	
	/**
	 * Column Info
	 * @return ffCustNm
	 */
	public String getFfCustNm() {
		return this.ffCustNm;
	}
	
	/**
	 * Column Info
	 * @return shOvflwChkFlg
	 */
	public String getShOvflwChkFlg() {
		return this.shOvflwChkFlg;
	}
	
	/**
	 * Column Info
	 * @return exOvflwChkFlg
	 */
	public String getExOvflwChkFlg() {
		return this.exOvflwChkFlg;
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
	 * @return nfCustNm
	 */
	public String getNfCustNm() {
		return this.nfCustNm;
	}
	
	/**
	 * Column Info
	 * @return ffOvflwChkFlg
	 */
	public String getFfOvflwChkFlg() {
		return this.ffOvflwChkFlg;
	}
	
	/**
	 * Column Info
	 * @return nfCustAddr
	 */
	public String getNfCustAddr() {
		return this.nfCustAddr;
	}
	
	/**
	 * Column Info
	 * @return anCustNm
	 */
	public String getAnCustNm() {
		return this.anCustNm;
	}
	
	/**
	 * Column Info
	 * @return shCustAddr
	 */
	public String getShCustAddr() {
		return this.shCustAddr;
	}
	
	/**
	 * Column Info
	 * @return ffOvflwFlg
	 */
	public String getFfOvflwFlg() {
		return this.ffOvflwFlg;
	}
	
	/**
	 * Column Info
	 * @return shCustNm
	 */
	public String getShCustNm() {
		return this.shCustNm;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return shOvflwFlg
	 */
	public String getShOvflwFlg() {
		return this.shOvflwFlg;
	}
	
	/**
	 * Column Info
	 * @return xterRqstSeq
	 */
	public String getXterRqstSeq() {
		return this.xterRqstSeq;
	}
	
	/**
	 * Column Info
	 * @return cnCustNm
	 */
	public String getCnCustNm() {
		return this.cnCustNm;
	}
	
	/**
	 * Column Info
	 * @return xterRqstNo
	 */
	public String getXterRqstNo() {
		return this.xterRqstNo;
	}
	

	/**
	 * Column Info
	 * @param cnOvflwFlg
	 */
	public void setCnOvflwFlg(String cnOvflwFlg) {
		this.cnOvflwFlg = cnOvflwFlg;
	}
	
	/**
	 * Column Info
	 * @param anOvflwFlg
	 */
	public void setAnOvflwFlg(String anOvflwFlg) {
		this.anOvflwFlg = anOvflwFlg;
	}
	
	/**
	 * Column Info
	 * @param exOvflwFlg
	 */
	public void setExOvflwFlg(String exOvflwFlg) {
		this.exOvflwFlg = exOvflwFlg;
	}
	
	/**
	 * Column Info
	 * @param nfOvflwFlg
	 */
	public void setNfOvflwFlg(String nfOvflwFlg) {
		this.nfOvflwFlg = nfOvflwFlg;
	}
	
	/**
	 * Column Info
	 * @param anOvflwChkFlg
	 */
	public void setAnOvflwChkFlg(String anOvflwChkFlg) {
		this.anOvflwChkFlg = anOvflwChkFlg;
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
	 * @param cnCustAddr
	 */
	public void setCnCustAddr(String cnCustAddr) {
		this.cnCustAddr = cnCustAddr;
	}
	
	/**
	 * Column Info
	 * @param exCustNm
	 */
	public void setExCustNm(String exCustNm) {
		this.exCustNm = exCustNm;
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
	 * @param cnOvflwChkFlg
	 */
	public void setCnOvflwChkFlg(String cnOvflwChkFlg) {
		this.cnOvflwChkFlg = cnOvflwChkFlg;
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
	 * @param nfOvflwChkFlg
	 */
	public void setNfOvflwChkFlg(String nfOvflwChkFlg) {
		this.nfOvflwChkFlg = nfOvflwChkFlg;
	}
	
	/**
	 * Column Info
	 * @param ffCustNm
	 */
	public void setFfCustNm(String ffCustNm) {
		this.ffCustNm = ffCustNm;
	}
	
	/**
	 * Column Info
	 * @param shOvflwChkFlg
	 */
	public void setShOvflwChkFlg(String shOvflwChkFlg) {
		this.shOvflwChkFlg = shOvflwChkFlg;
	}
	
	/**
	 * Column Info
	 * @param exOvflwChkFlg
	 */
	public void setExOvflwChkFlg(String exOvflwChkFlg) {
		this.exOvflwChkFlg = exOvflwChkFlg;
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
	 * @param nfCustNm
	 */
	public void setNfCustNm(String nfCustNm) {
		this.nfCustNm = nfCustNm;
	}
	
	/**
	 * Column Info
	 * @param ffOvflwChkFlg
	 */
	public void setFfOvflwChkFlg(String ffOvflwChkFlg) {
		this.ffOvflwChkFlg = ffOvflwChkFlg;
	}
	
	/**
	 * Column Info
	 * @param nfCustAddr
	 */
	public void setNfCustAddr(String nfCustAddr) {
		this.nfCustAddr = nfCustAddr;
	}
	
	/**
	 * Column Info
	 * @param anCustNm
	 */
	public void setAnCustNm(String anCustNm) {
		this.anCustNm = anCustNm;
	}
	
	/**
	 * Column Info
	 * @param shCustAddr
	 */
	public void setShCustAddr(String shCustAddr) {
		this.shCustAddr = shCustAddr;
	}
	
	/**
	 * Column Info
	 * @param ffOvflwFlg
	 */
	public void setFfOvflwFlg(String ffOvflwFlg) {
		this.ffOvflwFlg = ffOvflwFlg;
	}
	
	/**
	 * Column Info
	 * @param shCustNm
	 */
	public void setShCustNm(String shCustNm) {
		this.shCustNm = shCustNm;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param shOvflwFlg
	 */
	public void setShOvflwFlg(String shOvflwFlg) {
		this.shOvflwFlg = shOvflwFlg;
	}
	
	/**
	 * Column Info
	 * @param xterRqstSeq
	 */
	public void setXterRqstSeq(String xterRqstSeq) {
		this.xterRqstSeq = xterRqstSeq;
	}
	
	/**
	 * Column Info
	 * @param cnCustNm
	 */
	public void setCnCustNm(String cnCustNm) {
		this.cnCustNm = cnCustNm;
	}
	
	/**
	 * Column Info
	 * @param xterRqstNo
	 */
	public void setXterRqstNo(String xterRqstNo) {
		this.xterRqstNo = xterRqstNo;
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
		setCnOvflwFlg(JSPUtil.getParameter(request, prefix + "cn_ovflw_flg", ""));
		setAnOvflwFlg(JSPUtil.getParameter(request, prefix + "an_ovflw_flg", ""));
		setExOvflwFlg(JSPUtil.getParameter(request, prefix + "ex_ovflw_flg", ""));
		setNfOvflwFlg(JSPUtil.getParameter(request, prefix + "nf_ovflw_flg", ""));
		setAnOvflwChkFlg(JSPUtil.getParameter(request, prefix + "an_ovflw_chk_flg", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setCnCustAddr(JSPUtil.getParameter(request, prefix + "cn_cust_addr", ""));
		setExCustNm(JSPUtil.getParameter(request, prefix + "ex_cust_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCnOvflwChkFlg(JSPUtil.getParameter(request, prefix + "cn_ovflw_chk_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setNfOvflwChkFlg(JSPUtil.getParameter(request, prefix + "nf_ovflw_chk_flg", ""));
		setFfCustNm(JSPUtil.getParameter(request, prefix + "ff_cust_nm", ""));
		setShOvflwChkFlg(JSPUtil.getParameter(request, prefix + "sh_ovflw_chk_flg", ""));
		setExOvflwChkFlg(JSPUtil.getParameter(request, prefix + "ex_ovflw_chk_flg", ""));
		setCustTpCd(JSPUtil.getParameter(request, prefix + "cust_tp_cd", ""));
		setNfCustNm(JSPUtil.getParameter(request, prefix + "nf_cust_nm", ""));
		setFfOvflwChkFlg(JSPUtil.getParameter(request, prefix + "ff_ovflw_chk_flg", ""));
		setNfCustAddr(JSPUtil.getParameter(request, prefix + "nf_cust_addr", ""));
		setAnCustNm(JSPUtil.getParameter(request, prefix + "an_cust_nm", ""));
		setShCustAddr(JSPUtil.getParameter(request, prefix + "sh_cust_addr", ""));
		setFfOvflwFlg(JSPUtil.getParameter(request, prefix + "ff_ovflw_flg", ""));
		setShCustNm(JSPUtil.getParameter(request, prefix + "sh_cust_nm", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setShOvflwFlg(JSPUtil.getParameter(request, prefix + "sh_ovflw_flg", ""));
		setXterRqstSeq(JSPUtil.getParameter(request, prefix + "xter_rqst_seq", ""));
		setCnCustNm(JSPUtil.getParameter(request, prefix + "cn_cust_nm", ""));
		setXterRqstNo(JSPUtil.getParameter(request, prefix + "xter_rqst_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return XterCustOvflwFlgStatusVO[]
	 */
	public XterCustOvflwFlgStatusVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return XterCustOvflwFlgStatusVO[]
	 */
	public XterCustOvflwFlgStatusVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		XterCustOvflwFlgStatusVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cnOvflwFlg = (JSPUtil.getParameter(request, prefix	+ "cn_ovflw_flg", length));
			String[] anOvflwFlg = (JSPUtil.getParameter(request, prefix	+ "an_ovflw_flg", length));
			String[] exOvflwFlg = (JSPUtil.getParameter(request, prefix	+ "ex_ovflw_flg", length));
			String[] nfOvflwFlg = (JSPUtil.getParameter(request, prefix	+ "nf_ovflw_flg", length));
			String[] anOvflwChkFlg = (JSPUtil.getParameter(request, prefix	+ "an_ovflw_chk_flg", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] cnCustAddr = (JSPUtil.getParameter(request, prefix	+ "cn_cust_addr", length));
			String[] exCustNm = (JSPUtil.getParameter(request, prefix	+ "ex_cust_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cnOvflwChkFlg = (JSPUtil.getParameter(request, prefix	+ "cn_ovflw_chk_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] nfOvflwChkFlg = (JSPUtil.getParameter(request, prefix	+ "nf_ovflw_chk_flg", length));
			String[] ffCustNm = (JSPUtil.getParameter(request, prefix	+ "ff_cust_nm", length));
			String[] shOvflwChkFlg = (JSPUtil.getParameter(request, prefix	+ "sh_ovflw_chk_flg", length));
			String[] exOvflwChkFlg = (JSPUtil.getParameter(request, prefix	+ "ex_ovflw_chk_flg", length));
			String[] custTpCd = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd", length));
			String[] nfCustNm = (JSPUtil.getParameter(request, prefix	+ "nf_cust_nm", length));
			String[] ffOvflwChkFlg = (JSPUtil.getParameter(request, prefix	+ "ff_ovflw_chk_flg", length));
			String[] nfCustAddr = (JSPUtil.getParameter(request, prefix	+ "nf_cust_addr", length));
			String[] anCustNm = (JSPUtil.getParameter(request, prefix	+ "an_cust_nm", length));
			String[] shCustAddr = (JSPUtil.getParameter(request, prefix	+ "sh_cust_addr", length));
			String[] ffOvflwFlg = (JSPUtil.getParameter(request, prefix	+ "ff_ovflw_flg", length));
			String[] shCustNm = (JSPUtil.getParameter(request, prefix	+ "sh_cust_nm", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] shOvflwFlg = (JSPUtil.getParameter(request, prefix	+ "sh_ovflw_flg", length));
			String[] xterRqstSeq = (JSPUtil.getParameter(request, prefix	+ "xter_rqst_seq", length));
			String[] cnCustNm = (JSPUtil.getParameter(request, prefix	+ "cn_cust_nm", length));
			String[] xterRqstNo = (JSPUtil.getParameter(request, prefix	+ "xter_rqst_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new XterCustOvflwFlgStatusVO();
				if (cnOvflwFlg[i] != null)
					model.setCnOvflwFlg(cnOvflwFlg[i]);
				if (anOvflwFlg[i] != null)
					model.setAnOvflwFlg(anOvflwFlg[i]);
				if (exOvflwFlg[i] != null)
					model.setExOvflwFlg(exOvflwFlg[i]);
				if (nfOvflwFlg[i] != null)
					model.setNfOvflwFlg(nfOvflwFlg[i]);
				if (anOvflwChkFlg[i] != null)
					model.setAnOvflwChkFlg(anOvflwChkFlg[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (cnCustAddr[i] != null)
					model.setCnCustAddr(cnCustAddr[i]);
				if (exCustNm[i] != null)
					model.setExCustNm(exCustNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cnOvflwChkFlg[i] != null)
					model.setCnOvflwChkFlg(cnOvflwChkFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (nfOvflwChkFlg[i] != null)
					model.setNfOvflwChkFlg(nfOvflwChkFlg[i]);
				if (ffCustNm[i] != null)
					model.setFfCustNm(ffCustNm[i]);
				if (shOvflwChkFlg[i] != null)
					model.setShOvflwChkFlg(shOvflwChkFlg[i]);
				if (exOvflwChkFlg[i] != null)
					model.setExOvflwChkFlg(exOvflwChkFlg[i]);
				if (custTpCd[i] != null)
					model.setCustTpCd(custTpCd[i]);
				if (nfCustNm[i] != null)
					model.setNfCustNm(nfCustNm[i]);
				if (ffOvflwChkFlg[i] != null)
					model.setFfOvflwChkFlg(ffOvflwChkFlg[i]);
				if (nfCustAddr[i] != null)
					model.setNfCustAddr(nfCustAddr[i]);
				if (anCustNm[i] != null)
					model.setAnCustNm(anCustNm[i]);
				if (shCustAddr[i] != null)
					model.setShCustAddr(shCustAddr[i]);
				if (ffOvflwFlg[i] != null)
					model.setFfOvflwFlg(ffOvflwFlg[i]);
				if (shCustNm[i] != null)
					model.setShCustNm(shCustNm[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (shOvflwFlg[i] != null)
					model.setShOvflwFlg(shOvflwFlg[i]);
				if (xterRqstSeq[i] != null)
					model.setXterRqstSeq(xterRqstSeq[i]);
				if (cnCustNm[i] != null)
					model.setCnCustNm(cnCustNm[i]);
				if (xterRqstNo[i] != null)
					model.setXterRqstNo(xterRqstNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getXterCustOvflwFlgStatusVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return XterCustOvflwFlgStatusVO[]
	 */
	public XterCustOvflwFlgStatusVO[] getXterCustOvflwFlgStatusVOs(){
		XterCustOvflwFlgStatusVO[] vos = (XterCustOvflwFlgStatusVO[])models.toArray(new XterCustOvflwFlgStatusVO[models.size()]);
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
		this.cnOvflwFlg = this.cnOvflwFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anOvflwFlg = this.anOvflwFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exOvflwFlg = this.exOvflwFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfOvflwFlg = this.nfOvflwFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anOvflwChkFlg = this.anOvflwChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustAddr = this.cnCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exCustNm = this.exCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnOvflwChkFlg = this.cnOvflwChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfOvflwChkFlg = this.nfOvflwChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCustNm = this.ffCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shOvflwChkFlg = this.shOvflwChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exOvflwChkFlg = this.exOvflwChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCd = this.custTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustNm = this.nfCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffOvflwChkFlg = this.ffOvflwChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustAddr = this.nfCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anCustNm = this.anCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustAddr = this.shCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffOvflwFlg = this.ffOvflwFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustNm = this.shCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shOvflwFlg = this.shOvflwFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRqstSeq = this.xterRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustNm = this.cnCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRqstNo = this.xterRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
