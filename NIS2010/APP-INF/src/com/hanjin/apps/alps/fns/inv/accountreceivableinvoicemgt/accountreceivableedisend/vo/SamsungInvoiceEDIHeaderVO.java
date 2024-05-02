/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SamsungInvoiceEDIHeaderVO.java
*@FileTitle : SamsungInvoiceEDIHeaderVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.13
*@LastModifier : 김상현
*@LastVersion : 1.1
* 2009.10.05 박정진 1.0 Creation
* 2012.07.13 김상현 1.1 (Korea) Samsung Invoice EDI > Invoice No. Numbering 요청
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo;

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
 * @author 박정진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SamsungInvoiceEDIHeaderVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SamsungInvoiceEDIHeaderVO> models = new ArrayList<SamsungInvoiceEDIHeaderVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String vldChkFlg = null;
	/* Column Info */
	private String buyrCoNm = null;
	/* Column Info */
	private String rcvrId = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String buyrAddr2 = null;
	/* Column Info */
	private String bilKrwAmt = null;
	/* Column Info */
	private String buyrAddr1 = null;
	/* Column Info */
	private String sndDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String msgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String msgNm = null;
	/* Column Info */
	private String buyrCeoNm = null;
	/* Column Info */
	private String bilKrwCurrCd = null;
	/* Column Info */
	private String buyrRgstNo = null;
	/* Column Info */
	private String invXchRtDt = null;
	/* Column Info */
	private String sndrId = null;
	/* Column Info */
	private String msgId = null;
	/* Column Info */
	private String ediHdrRmk = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String invXchRt = null;
	/* Column Info */
	private String bilUsdAmt = null;
	/* Column Info */
	private String bilDt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String sndFlg = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String bilTaxCurrCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bilUsdCurrCd = null;
	/* Column Info */
	private String bilTaxAmt = null;
	/* Column Info */
	private String invMsgFuncCd = null;
	/* Column Info */
	private String sndrNm = null;
	/* Column Info */
	private String rcvrNm = null;
	/* Column Info */
	private String loclNm = null;
	/* Column Info */
	private String custRgstNo = null;
	/* Column Info */
	private String loclAddr1 = null;
	/* Column Info */
	private String loclAddr2 = null;
	/* Column Info */
	private String ownrNm = null;
	/* Column Info */
	private String srepNm = null;
	/* Column Info */
	private String rcvrPhnNo = null;
	/* Column Info */
	private String sailArrDt = null;
	/* Column Info */
	private String eSign = null;
	/* Column Info */
	private String gerpValFlg = null;
	/* Column Info */
	private String forceToSave = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SamsungInvoiceEDIHeaderVO() {}

	public SamsungInvoiceEDIHeaderVO(String ibflag, String pagerows, String msgId, String msgNo, String sndrId, String sndrNm, String rcvrId, String rcvrNm, String msgNm, String invMsgFuncCd, String vslCd, String skdVoyNo, String skdDirCd, String buyrRgstNo, String buyrCoNm, String buyrCeoNm, String buyrAddr1, String buyrAddr2, String bilDt, String bilKrwAmt, String bilKrwCurrCd, String bilUsdAmt, String bilUsdCurrCd, String bilTaxAmt, String bilTaxCurrCd, String invXchRt, String invXchRtDt, String custCntCd, String custSeq, String ediHdrRmk, String vldChkFlg, String sndFlg, String sndDt, String creUsrId, String creDt, String updUsrId, String updDt, String loclNm, String custRgstNo, String loclAddr1, String loclAddr2, String ownrNm, String srepNm, String rcvrPhnNo, String sailArrDt, String eSign, String gerpValFlg, String forceToSave) {
		this.vslCd = vslCd;
		this.vldChkFlg = vldChkFlg;
		this.buyrCoNm = buyrCoNm;
		this.rcvrId = rcvrId;
		this.creDt = creDt;
		this.buyrAddr2 = buyrAddr2;
		this.bilKrwAmt = bilKrwAmt;
		this.buyrAddr1 = buyrAddr1;
		this.sndDt = sndDt;
		this.pagerows = pagerows;
		this.msgNo = msgNo;
		this.ibflag = ibflag;
		this.msgNm = msgNm;
		this.buyrCeoNm = buyrCeoNm;
		this.bilKrwCurrCd = bilKrwCurrCd;
		this.buyrRgstNo = buyrRgstNo;
		this.invXchRtDt = invXchRtDt;
		this.sndrId = sndrId;
		this.msgId = msgId;
		this.ediHdrRmk = ediHdrRmk;
		this.updUsrId = updUsrId;
		this.custCntCd = custCntCd;
		this.invXchRt = invXchRt;
		this.bilUsdAmt = bilUsdAmt;
		this.bilDt = bilDt;
		this.updDt = updDt;
		this.sndFlg = sndFlg;
		this.skdVoyNo = skdVoyNo;
		this.bilTaxCurrCd = bilTaxCurrCd;
		this.custSeq = custSeq;
		this.skdDirCd = skdDirCd;
		this.creUsrId = creUsrId;
		this.bilUsdCurrCd = bilUsdCurrCd;
		this.bilTaxAmt = bilTaxAmt;
		this.invMsgFuncCd = invMsgFuncCd;
		this.sndrNm = sndrNm;
		this.rcvrNm = rcvrNm;
		this.loclNm = loclNm;
		this.custRgstNo = custRgstNo;
		this.loclAddr1 = loclAddr1;
		this.loclAddr2 = loclAddr2;
		this.ownrNm = ownrNm;
		this.srepNm = srepNm;
		this.rcvrPhnNo = rcvrPhnNo;
		this.sailArrDt = sailArrDt;
		this.eSign = eSign;
		this.gerpValFlg = gerpValFlg;
		this.forceToSave = forceToSave;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("vld_chk_flg", getVldChkFlg());
		this.hashColumns.put("buyr_co_nm", getBuyrCoNm());
		this.hashColumns.put("rcvr_id", getRcvrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("buyr_addr2", getBuyrAddr2());
		this.hashColumns.put("bil_krw_amt", getBilKrwAmt());
		this.hashColumns.put("buyr_addr1", getBuyrAddr1());
		this.hashColumns.put("snd_dt", getSndDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("msg_no", getMsgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("msg_nm", getMsgNm());
		this.hashColumns.put("buyr_ceo_nm", getBuyrCeoNm());
		this.hashColumns.put("bil_krw_curr_cd", getBilKrwCurrCd());
		this.hashColumns.put("buyr_rgst_no", getBuyrRgstNo());
		this.hashColumns.put("inv_xch_rt_dt", getInvXchRtDt());
		this.hashColumns.put("sndr_id", getSndrId());
		this.hashColumns.put("msg_id", getMsgId());
		this.hashColumns.put("edi_hdr_rmk", getEdiHdrRmk());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("inv_xch_rt", getInvXchRt());
		this.hashColumns.put("bil_usd_amt", getBilUsdAmt());
		this.hashColumns.put("bil_dt", getBilDt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("snd_flg", getSndFlg());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("bil_tax_curr_cd", getBilTaxCurrCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bil_usd_curr_cd", getBilUsdCurrCd());
		this.hashColumns.put("bil_tax_amt", getBilTaxAmt());
		this.hashColumns.put("inv_msg_func_cd", getInvMsgFuncCd());
		this.hashColumns.put("sndr_nm", getSndrNm());
		this.hashColumns.put("rcvr_nm", getRcvrNm());
		this.hashColumns.put("locl_nm", getLoclNm());
		this.hashColumns.put("cust_rgst_no", getCustRgstNo());
		this.hashColumns.put("locl_addr1", getLoclAddr1());
		this.hashColumns.put("locl_addr2", getLoclAddr2());
		this.hashColumns.put("ownr_nm", getOwnrNm());
		this.hashColumns.put("srep_nm", getSrepNm());
		this.hashColumns.put("rcvr_phn_no", getRcvrPhnNo());
		this.hashColumns.put("sail_arr_dt", getSailArrDt());
		this.hashColumns.put("e_sign", getESign());
		this.hashColumns.put("gerp_val_flg", getGerpValFlg());
		this.hashColumns.put("force_to_save", getForceToSave());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vld_chk_flg", "vldChkFlg");
		this.hashFields.put("buyr_co_nm", "buyrCoNm");
		this.hashFields.put("rcvr_id", "rcvrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("buyr_addr2", "buyrAddr2");
		this.hashFields.put("bil_krw_amt", "bilKrwAmt");
		this.hashFields.put("buyr_addr1", "buyrAddr1");
		this.hashFields.put("snd_dt", "sndDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("msg_no", "msgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("msg_nm", "msgNm");
		this.hashFields.put("buyr_ceo_nm", "buyrCeoNm");
		this.hashFields.put("bil_krw_curr_cd", "bilKrwCurrCd");
		this.hashFields.put("buyr_rgst_no", "buyrRgstNo");
		this.hashFields.put("inv_xch_rt_dt", "invXchRtDt");
		this.hashFields.put("sndr_id", "sndrId");
		this.hashFields.put("msg_id", "msgId");
		this.hashFields.put("edi_hdr_rmk", "ediHdrRmk");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("bil_usd_amt", "bilUsdAmt");
		this.hashFields.put("bil_dt", "bilDt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("snd_flg", "sndFlg");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("bil_tax_curr_cd", "bilTaxCurrCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bil_usd_curr_cd", "bilUsdCurrCd");
		this.hashFields.put("bil_tax_amt", "bilTaxAmt");
		this.hashFields.put("inv_msg_func_cd", "invMsgFuncCd");
		this.hashFields.put("sndr_nm", "sndrNm");
		this.hashFields.put("rcvr_nm", "rcvrNm");
		this.hashFields.put("locl_nm", "loclNm");
		this.hashFields.put("cust_rgst_no", "custRgstNo");
		this.hashFields.put("locl_addr1", "loclAddr1");
		this.hashFields.put("locl_addr2", "loclAddr2");
		this.hashFields.put("ownr_nm", "ownrNm");
		this.hashFields.put("srep_nm", "srepNm");
		this.hashFields.put("rcvr_phn_no", "rcvrPhnNo");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("e_sign", "eSign");
		this.hashFields.put("gerp_val_flg", "gerpValFlg");
		this.hashFields.put("force_to_save", "forceToSave");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return vldChkFlg
	 */
	public String getVldChkFlg() {
		return this.vldChkFlg;
	}
	
	/**
	 * Column Info
	 * @return buyrCoNm
	 */
	public String getBuyrCoNm() {
		return this.buyrCoNm;
	}
	
	/**
	 * Column Info
	 * @return rcvrId
	 */
	public String getRcvrId() {
		return this.rcvrId;
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
	 * @return buyrAddr2
	 */
	public String getBuyrAddr2() {
		return this.buyrAddr2;
	}
	
	/**
	 * Column Info
	 * @return bilKrwAmt
	 */
	public String getBilKrwAmt() {
		return this.bilKrwAmt;
	}
	
	/**
	 * Column Info
	 * @return buyrAddr1
	 */
	public String getBuyrAddr1() {
		return this.buyrAddr1;
	}
	
	/**
	 * Column Info
	 * @return sndDt
	 */
	public String getSndDt() {
		return this.sndDt;
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
	 * @return msgNo
	 */
	public String getMsgNo() {
		return this.msgNo;
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
	 * @return msgNm
	 */
	public String getMsgNm() {
		return this.msgNm;
	}
	
	/**
	 * Column Info
	 * @return buyrCeoNm
	 */
	public String getBuyrCeoNm() {
		return this.buyrCeoNm;
	}
	
	/**
	 * Column Info
	 * @return bilKrwCurrCd
	 */
	public String getBilKrwCurrCd() {
		return this.bilKrwCurrCd;
	}
	
	/**
	 * Column Info
	 * @return buyrRgstNo
	 */
	public String getBuyrRgstNo() {
		return this.buyrRgstNo;
	}
	
	/**
	 * Column Info
	 * @return invXchRtDt
	 */
	public String getInvXchRtDt() {
		return this.invXchRtDt;
	}
	
	/**
	 * Column Info
	 * @return sndrId
	 */
	public String getSndrId() {
		return this.sndrId;
	}
	
	/**
	 * Column Info
	 * @return msgId
	 */
	public String getMsgId() {
		return this.msgId;
	}
	
	/**
	 * Column Info
	 * @return ediHdrRmk
	 */
	public String getEdiHdrRmk() {
		return this.ediHdrRmk;
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
	 * @return invXchRt
	 */
	public String getInvXchRt() {
		return this.invXchRt;
	}
	
	/**
	 * Column Info
	 * @return bilUsdAmt
	 */
	public String getBilUsdAmt() {
		return this.bilUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return bilDt
	 */
	public String getBilDt() {
		return this.bilDt;
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
	 * @return sndFlg
	 */
	public String getSndFlg() {
		return this.sndFlg;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return bilTaxCurrCd
	 */
	public String getBilTaxCurrCd() {
		return this.bilTaxCurrCd;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return bilUsdCurrCd
	 */
	public String getBilUsdCurrCd() {
		return this.bilUsdCurrCd;
	}
	
	/**
	 * Column Info
	 * @return bilTaxAmt
	 */
	public String getBilTaxAmt() {
		return this.bilTaxAmt;
	}
	
	/**
	 * Column Info
	 * @return invMsgFuncCd
	 */
	public String getInvMsgFuncCd() {
		return this.invMsgFuncCd;
	}
	
	/**
	 * Column Info
	 * @return sndrNm
	 */
	public String getSndrNm() {
		return this.sndrNm;
	}
	
	/**
	 * Column Info
	 * @return rcvrNm
	 */
	public String getRcvrNm() {
		return this.rcvrNm;
	}
	

	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param vldChkFlg
	 */
	public void setVldChkFlg(String vldChkFlg) {
		this.vldChkFlg = vldChkFlg;
	}
	
	/**
	 * Column Info
	 * @param buyrCoNm
	 */
	public void setBuyrCoNm(String buyrCoNm) {
		this.buyrCoNm = buyrCoNm;
	}
	
	/**
	 * Column Info
	 * @param rcvrId
	 */
	public void setRcvrId(String rcvrId) {
		this.rcvrId = rcvrId;
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
	 * @param buyrAddr2
	 */
	public void setBuyrAddr2(String buyrAddr2) {
		this.buyrAddr2 = buyrAddr2;
	}
	
	/**
	 * Column Info
	 * @param bilKrwAmt
	 */
	public void setBilKrwAmt(String bilKrwAmt) {
		this.bilKrwAmt = bilKrwAmt;
	}
	
	/**
	 * Column Info
	 * @param buyrAddr1
	 */
	public void setBuyrAddr1(String buyrAddr1) {
		this.buyrAddr1 = buyrAddr1;
	}
	
	/**
	 * Column Info
	 * @param sndDt
	 */
	public void setSndDt(String sndDt) {
		this.sndDt = sndDt;
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
	 * @param msgNo
	 */
	public void setMsgNo(String msgNo) {
		this.msgNo = msgNo;
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
	 * @param msgNm
	 */
	public void setMsgNm(String msgNm) {
		this.msgNm = msgNm;
	}
	
	/**
	 * Column Info
	 * @param buyrCeoNm
	 */
	public void setBuyrCeoNm(String buyrCeoNm) {
		this.buyrCeoNm = buyrCeoNm;
	}
	
	/**
	 * Column Info
	 * @param bilKrwCurrCd
	 */
	public void setBilKrwCurrCd(String bilKrwCurrCd) {
		this.bilKrwCurrCd = bilKrwCurrCd;
	}
	
	/**
	 * Column Info
	 * @param buyrRgstNo
	 */
	public void setBuyrRgstNo(String buyrRgstNo) {
		this.buyrRgstNo = buyrRgstNo;
	}
	
	/**
	 * Column Info
	 * @param invXchRtDt
	 */
	public void setInvXchRtDt(String invXchRtDt) {
		this.invXchRtDt = invXchRtDt;
	}
	
	/**
	 * Column Info
	 * @param sndrId
	 */
	public void setSndrId(String sndrId) {
		this.sndrId = sndrId;
	}
	
	/**
	 * Column Info
	 * @param msgId
	 */
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	
	/**
	 * Column Info
	 * @param ediHdrRmk
	 */
	public void setEdiHdrRmk(String ediHdrRmk) {
		this.ediHdrRmk = ediHdrRmk;
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
	 * @param invXchRt
	 */
	public void setInvXchRt(String invXchRt) {
		this.invXchRt = invXchRt;
	}
	
	/**
	 * Column Info
	 * @param bilUsdAmt
	 */
	public void setBilUsdAmt(String bilUsdAmt) {
		this.bilUsdAmt = bilUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param bilDt
	 */
	public void setBilDt(String bilDt) {
		this.bilDt = bilDt;
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
	 * @param sndFlg
	 */
	public void setSndFlg(String sndFlg) {
		this.sndFlg = sndFlg;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param bilTaxCurrCd
	 */
	public void setBilTaxCurrCd(String bilTaxCurrCd) {
		this.bilTaxCurrCd = bilTaxCurrCd;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param bilUsdCurrCd
	 */
	public void setBilUsdCurrCd(String bilUsdCurrCd) {
		this.bilUsdCurrCd = bilUsdCurrCd;
	}
	
	/**
	 * Column Info
	 * @param bilTaxAmt
	 */
	public void setBilTaxAmt(String bilTaxAmt) {
		this.bilTaxAmt = bilTaxAmt;
	}
	
	/**
	 * Column Info
	 * @param invMsgFuncCd
	 */
	public void setInvMsgFuncCd(String invMsgFuncCd) {
		this.invMsgFuncCd = invMsgFuncCd;
	}
	
	/**
	 * Column Info
	 * @param sndrNm
	 */
	public void setSndrNm(String sndrNm) {
		this.sndrNm = sndrNm;
	}
	
	/**
	 * Column Info
	 * @param rcvrNm
	 */
	public void setRcvrNm(String rcvrNm) {
		this.rcvrNm = rcvrNm;
	}
	
	public String getSailArrDt() {
		return sailArrDt;
	}

	public void setSailArrDt(String sailArrDt) {
		this.sailArrDt = sailArrDt;
	}

	public String getLoclNm() {
		return loclNm;
	}

	public void setLoclNm(String loclNm) {
		this.loclNm = loclNm;
	}

	public String getCustRgstNo() {
		return custRgstNo;
	}

	public void setCustRgstNo(String custRgstNo) {
		this.custRgstNo = custRgstNo;
	}

	public String getLoclAddr1() {
		return loclAddr1;
	}

	public void setLoclAddr1(String loclAddr1) {
		this.loclAddr1 = loclAddr1;
	}

	public String getLoclAddr2() {
		return loclAddr2;
	}

	public void setLoclAddr2(String loclAddr2) {
		this.loclAddr2 = loclAddr2;
	}

	public String getOwnrNm() {
		return ownrNm;
	}

	public void setOwnrNm(String ownrNm) {
		this.ownrNm = ownrNm;
	}

	public String getSrepNm() {
		return srepNm;
	}

	public void setSrepNm(String srepNm) {
		this.srepNm = srepNm;
	}

	public String getRcvrPhnNo() {
		return rcvrPhnNo;
	}

	public void setRcvrPhnNo(String rcvrPhnNo) {
		this.rcvrPhnNo = rcvrPhnNo;
	}

	public String getESign() {
		return eSign;
	}

	public void setESign(String sign) {
		eSign = sign;
	}

	public String getGerpValFlg() {
		return gerpValFlg;
	}

	public void setGerpValFlg(String gerpValFlg) {
		this.gerpValFlg = gerpValFlg;
	}

	/**
	 * @return the forceToSave
	 */
	public String getForceToSave() {
		return forceToSave;
	}

	/**
	 * @param forceToSave the forceToSave to set
	 */
	public void setForceToSave(String forceToSave) {
		this.forceToSave = forceToSave;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setVldChkFlg(JSPUtil.getParameter(request, "vld_chk_flg", ""));
		setBuyrCoNm(JSPUtil.getParameter(request, "buyr_co_nm", ""));
		setRcvrId(JSPUtil.getParameter(request, "rcvr_id", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setBuyrAddr2(JSPUtil.getParameter(request, "buyr_addr2", ""));
		setBilKrwAmt(JSPUtil.getParameter(request, "bil_krw_amt", ""));
		setBuyrAddr1(JSPUtil.getParameter(request, "buyr_addr1", ""));
		setSndDt(JSPUtil.getParameter(request, "snd_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setMsgNo(JSPUtil.getParameter(request, "msg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMsgNm(JSPUtil.getParameter(request, "msg_nm", ""));
		setBuyrCeoNm(JSPUtil.getParameter(request, "buyr_ceo_nm", ""));
		setBilKrwCurrCd(JSPUtil.getParameter(request, "bil_krw_curr_cd", ""));
		setBuyrRgstNo(JSPUtil.getParameter(request, "buyr_rgst_no", ""));
		setInvXchRtDt(JSPUtil.getParameter(request, "inv_xch_rt_dt", ""));
		setSndrId(JSPUtil.getParameter(request, "sndr_id", ""));
		setMsgId(JSPUtil.getParameter(request, "msg_id", ""));
		setEdiHdrRmk(JSPUtil.getParameter(request, "edi_hdr_rmk", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setInvXchRt(JSPUtil.getParameter(request, "inv_xch_rt", ""));
		setBilUsdAmt(JSPUtil.getParameter(request, "bil_usd_amt", ""));
		setBilDt(JSPUtil.getParameter(request, "bil_dt", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setSndFlg(JSPUtil.getParameter(request, "snd_flg", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setBilTaxCurrCd(JSPUtil.getParameter(request, "bil_tax_curr_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setBilUsdCurrCd(JSPUtil.getParameter(request, "bil_usd_curr_cd", ""));
		setBilTaxAmt(JSPUtil.getParameter(request, "bil_tax_amt", ""));
		setInvMsgFuncCd(JSPUtil.getParameter(request, "inv_msg_func_cd", ""));
		setSndrNm(JSPUtil.getParameter(request, "sndr_nm", ""));
		setLoclNm(JSPUtil.getParameter(request, "locl_nm", ""));
		setCustRgstNo(JSPUtil.getParameter(request, "cust_rgst_no", ""));
		setLoclAddr1(JSPUtil.getParameter(request, "locl_addr1", ""));
		setLoclAddr2(JSPUtil.getParameter(request, "locl_addr2", ""));
		setOwnrNm(JSPUtil.getParameter(request, "ownr_nm", ""));
		setSrepNm(JSPUtil.getParameter(request, "srep_nm", ""));
		setRcvrPhnNo(JSPUtil.getParameter(request, "rcvr_phn_no", ""));
		setSailArrDt(JSPUtil.getParameter(request, "sail_arr_dt", ""));
		setESign(JSPUtil.getParameter(request, "e_sign", ""));
		setGerpValFlg(JSPUtil.getParameter(request, "gerp_val_flg", ""));
		setForceToSave(JSPUtil.getParameter(request, "force_to_save", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SamsungInvoiceEDIHeaderVO[]
	 */
	public SamsungInvoiceEDIHeaderVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SamsungInvoiceEDIHeaderVO[]
	 */
	public SamsungInvoiceEDIHeaderVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SamsungInvoiceEDIHeaderVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] vldChkFlg = (JSPUtil.getParameter(request, prefix	+ "vld_chk_flg", length));
			String[] buyrCoNm = (JSPUtil.getParameter(request, prefix	+ "buyr_co_nm", length));
			String[] rcvrId = (JSPUtil.getParameter(request, prefix	+ "rcvr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] buyrAddr2 = (JSPUtil.getParameter(request, prefix	+ "buyr_addr2", length));
			String[] bilKrwAmt = (JSPUtil.getParameter(request, prefix	+ "bil_krw_amt", length));
			String[] buyrAddr1 = (JSPUtil.getParameter(request, prefix	+ "buyr_addr1", length));
			String[] sndDt = (JSPUtil.getParameter(request, prefix	+ "snd_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] msgNo = (JSPUtil.getParameter(request, prefix	+ "msg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] msgNm = (JSPUtil.getParameter(request, prefix	+ "msg_nm", length));
			String[] buyrCeoNm = (JSPUtil.getParameter(request, prefix	+ "buyr_ceo_nm", length));
			String[] bilKrwCurrCd = (JSPUtil.getParameter(request, prefix	+ "bil_krw_curr_cd", length));
			String[] buyrRgstNo = (JSPUtil.getParameter(request, prefix	+ "buyr_rgst_no", length));
			String[] invXchRtDt = (JSPUtil.getParameter(request, prefix	+ "inv_xch_rt_dt", length));
			String[] sndrId = (JSPUtil.getParameter(request, prefix	+ "sndr_id", length));
			String[] msgId = (JSPUtil.getParameter(request, prefix	+ "msg_id", length));
			String[] ediHdrRmk = (JSPUtil.getParameter(request, prefix	+ "edi_hdr_rmk", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] invXchRt = (JSPUtil.getParameter(request, prefix	+ "inv_xch_rt", length));
			String[] bilUsdAmt = (JSPUtil.getParameter(request, prefix	+ "bil_usd_amt", length));
			String[] bilDt = (JSPUtil.getParameter(request, prefix	+ "bil_dt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] sndFlg = (JSPUtil.getParameter(request, prefix	+ "snd_flg", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] bilTaxCurrCd = (JSPUtil.getParameter(request, prefix	+ "bil_tax_curr_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bilUsdCurrCd = (JSPUtil.getParameter(request, prefix	+ "bil_usd_curr_cd", length));
			String[] bilTaxAmt = (JSPUtil.getParameter(request, prefix	+ "bil_tax_amt", length));
			String[] invMsgFuncCd = (JSPUtil.getParameter(request, prefix	+ "inv_msg_func_cd", length));
			String[] sndrNm = (JSPUtil.getParameter(request, prefix	+ "sndr_nm", length));
			String[] rcvrNm = (JSPUtil.getParameter(request, prefix	+ "rcvr_nm", length));
			String[] loclNm = (JSPUtil.getParameter(request, prefix	+ "locl_nm", length));
			String[] custRgstNo = (JSPUtil.getParameter(request, prefix	+ "cust_rgst_no", length));
			String[] loclAddr1 = (JSPUtil.getParameter(request, prefix	+ "locl_addr1", length));
			String[] loclAddr2 = (JSPUtil.getParameter(request, prefix	+ "locl_addr2", length));
			String[] ownrNm = (JSPUtil.getParameter(request, prefix	+ "ownr_nm", length));
			String[] srepNm = (JSPUtil.getParameter(request, prefix	+ "srep_nm", length));
			String[] rcvrPhnNo = (JSPUtil.getParameter(request, prefix	+ "rcvr_phn_no", length));
			String[] sailArrDt = (JSPUtil.getParameter(request, prefix	+ "sail_arr_dt", length));
			String[] eSign = (JSPUtil.getParameter(request, prefix	+ "e_sign", length));
			String[] gerpValFlg = (JSPUtil.getParameter(request, prefix	+ "gerp_val_flg", length));
			String[] forceToSave = (JSPUtil.getParameter(request, prefix + "force_to_save", length));
			
			for (int i = 0; i < length; i++) {
				model = new SamsungInvoiceEDIHeaderVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (vldChkFlg[i] != null)
					model.setVldChkFlg(vldChkFlg[i]);
				if (buyrCoNm[i] != null)
					model.setBuyrCoNm(buyrCoNm[i]);
				if (rcvrId[i] != null)
					model.setRcvrId(rcvrId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (buyrAddr2[i] != null)
					model.setBuyrAddr2(buyrAddr2[i]);
				if (bilKrwAmt[i] != null)
					model.setBilKrwAmt(bilKrwAmt[i]);
				if (buyrAddr1[i] != null)
					model.setBuyrAddr1(buyrAddr1[i]);
				if (sndDt[i] != null)
					model.setSndDt(sndDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (msgNo[i] != null)
					model.setMsgNo(msgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (msgNm[i] != null)
					model.setMsgNm(msgNm[i]);
				if (buyrCeoNm[i] != null)
					model.setBuyrCeoNm(buyrCeoNm[i]);
				if (bilKrwCurrCd[i] != null)
					model.setBilKrwCurrCd(bilKrwCurrCd[i]);
				if (buyrRgstNo[i] != null)
					model.setBuyrRgstNo(buyrRgstNo[i]);
				if (invXchRtDt[i] != null)
					model.setInvXchRtDt(invXchRtDt[i]);
				if (sndrId[i] != null)
					model.setSndrId(sndrId[i]);
				if (msgId[i] != null)
					model.setMsgId(msgId[i]);
				if (ediHdrRmk[i] != null)
					model.setEdiHdrRmk(ediHdrRmk[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (invXchRt[i] != null)
					model.setInvXchRt(invXchRt[i]);
				if (bilUsdAmt[i] != null)
					model.setBilUsdAmt(bilUsdAmt[i]);
				if (bilDt[i] != null)
					model.setBilDt(bilDt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (sndFlg[i] != null)
					model.setSndFlg(sndFlg[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (bilTaxCurrCd[i] != null)
					model.setBilTaxCurrCd(bilTaxCurrCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bilUsdCurrCd[i] != null)
					model.setBilUsdCurrCd(bilUsdCurrCd[i]);
				if (bilTaxAmt[i] != null)
					model.setBilTaxAmt(bilTaxAmt[i]);
				if (invMsgFuncCd[i] != null)
					model.setInvMsgFuncCd(invMsgFuncCd[i]);
				if (sndrNm[i] != null)
					model.setSndrNm(sndrNm[i]);
				if (rcvrNm[i] != null)
					model.setRcvrNm(rcvrNm[i]);
				if (loclNm[i] != null)
					model.setLoclNm(loclNm[i]);
				if (custRgstNo[i] != null)
					model.setCustRgstNo(custRgstNo[i]);
				if (loclAddr1[i] != null)
					model.setLoclAddr1(loclAddr1[i]);
				if (loclAddr2[i] != null)
					model.setLoclAddr2(loclAddr2[i]);
				if (ownrNm[i] != null)
					model.setOwnrNm(ownrNm[i]);
				if (srepNm[i] != null)
					model.setSrepNm(srepNm[i]);
				if (rcvrPhnNo[i] != null)
					model.setRcvrPhnNo(rcvrPhnNo[i]);
				if (sailArrDt[i] != null)
					model.setSailArrDt(sailArrDt[i]);
				if (eSign[i] != null)
					model.setESign(eSign[i]);
				if (gerpValFlg[i] != null)
					model.setGerpValFlg(gerpValFlg[i]);
				if (forceToSave[i] != null)
					model.setForceToSave(forceToSave[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSamsungInvoiceEDIHeaderVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SamsungInvoiceEDIHeaderVO[]
	 */
	public SamsungInvoiceEDIHeaderVO[] getSamsungInvoiceEDIHeaderVOs(){
		SamsungInvoiceEDIHeaderVO[] vos = (SamsungInvoiceEDIHeaderVO[])models.toArray(new SamsungInvoiceEDIHeaderVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vldChkFlg = this.vldChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.buyrCoNm = this.buyrCoNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrId = this.rcvrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.buyrAddr2 = this.buyrAddr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilKrwAmt = this.bilKrwAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.buyrAddr1 = this.buyrAddr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDt = this.sndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgNo = this.msgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgNm = this.msgNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.buyrCeoNm = this.buyrCeoNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilKrwCurrCd = this.bilKrwCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.buyrRgstNo = this.buyrRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRtDt = this.invXchRtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndrId = this.sndrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgId = this.msgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediHdrRmk = this.ediHdrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt = this.invXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilUsdAmt = this.bilUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilDt = this.bilDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndFlg = this.sndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilTaxCurrCd = this.bilTaxCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilUsdCurrCd = this.bilUsdCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilTaxAmt = this.bilTaxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invMsgFuncCd = this.invMsgFuncCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndrNm = this.sndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrNm = this.rcvrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclNm = this.loclNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRgstNo = this.custRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclAddr1 = this.loclAddr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclAddr2 = this.loclAddr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrNm = this.ownrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepNm = this.srepNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrPhnNo = this.rcvrPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt = this.sailArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eSign = this.eSign .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gerpValFlg = this.gerpValFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.forceToSave = this.forceToSave.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
