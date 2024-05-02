/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BkgJapanTerminalEdiVO.java
*@FileTitle : BkgJapanTerminalEdiVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.17
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2012.04.17 김종옥
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo;

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
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgJapanTerminalEdiVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<BkgJapanTerminalEdiVO> models = new ArrayList<BkgJapanTerminalEdiVO>();

	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String ediSndUsrId = null;
	/* Column Info */
	private String batSkdPrdFmDt = null;
	/* Column Info */
	private String snaccsTmlEdiStsCngFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String porYdCd = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String beBkrbkc = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String ediSndTm = null;
	/* Column Info */
	private String cntrVolQty5 = null;
	/* Column Info */
	private String cntrVolQty4 = null;
	/* Column Info */
	private String callSgnNo = null;
	/* Column Info */
	private String ediSndOfcCd = null;
	/* Column Info */
	private String cntrVolQty1 = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String bkrbkc = null;
	/* Column Info */
	private String cntrVolQty3 = null;
	/* Column Info */
	private String cntrVolQty2 = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String otrNtfyYdCd = null;
	/* Column Info */
	private String cntrTpszCd5 = null;
	/* Column Info */
	private String batSkdPrdToDt = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String polYdCd = null;
	/* Column Info */
	private String cntrTpszCd2 = null;
	/* Column Info */
	private String cntrTpszCd1 = null;
	/* Column Info */
	private String ediSndDt = null;
	/* Column Info */
	private String cntrTpszCd4 = null;
	/* Column Info */
	private String cntrTpszCd3 = null;
	/* Column Info */
	private String jpTmlVslNo = null;
	/* Column Info */
	private String bkgSkdDeltFlg = null;


	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public BkgJapanTerminalEdiVO() {}

	public BkgJapanTerminalEdiVO(String ibflag, String pagerows, String bkgSkdDeltFlg, String jpTmlVslNo, String porCd, String vslCd, String ediSndUsrId, String batSkdPrdFmDt, String porYdCd, String polCd, String vvdCd, String updUsrId, String ediSndTm, String cntrVolQty5, String cntrVolQty4, String callSgnNo, String ediSndOfcCd, String cntrVolQty1, String skdVoyNo, String bkrbkc, String cntrVolQty3, String cntrVolQty2, String skdDirCd, String otrNtfyYdCd, String cntrTpszCd5, String batSkdPrdToDt, String bkgNo, String polYdCd, String cntrTpszCd2, String cntrTpszCd1, String cntrTpszCd4, String ediSndDt, String cntrTpszCd3, String beBkrbkc, String snaccsTmlEdiStsCngFlg) {
		this.porCd = porCd;
		this.vslCd = vslCd;
		this.ediSndUsrId = ediSndUsrId;
		this.batSkdPrdFmDt = batSkdPrdFmDt;
		this.snaccsTmlEdiStsCngFlg = snaccsTmlEdiStsCngFlg;
		this.pagerows = pagerows;
		this.porYdCd = porYdCd;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.vvdCd = vvdCd;
		this.beBkrbkc = beBkrbkc;
		this.updUsrId = updUsrId;
		this.ediSndTm = ediSndTm;
		this.cntrVolQty5 = cntrVolQty5;
		this.cntrVolQty4 = cntrVolQty4;
		this.callSgnNo = callSgnNo;
		this.ediSndOfcCd = ediSndOfcCd;
		this.cntrVolQty1 = cntrVolQty1;
		this.skdVoyNo = skdVoyNo;
		this.bkrbkc = bkrbkc;
		this.cntrVolQty3 = cntrVolQty3;
		this.cntrVolQty2 = cntrVolQty2;
		this.skdDirCd = skdDirCd;
		this.otrNtfyYdCd = otrNtfyYdCd;
		this.cntrTpszCd5 = cntrTpszCd5;
		this.batSkdPrdToDt = batSkdPrdToDt;
		this.bkgNo = bkgNo;
		this.polYdCd = polYdCd;
		this.cntrTpszCd2 = cntrTpszCd2;
		this.cntrTpszCd1 = cntrTpszCd1;
		this.ediSndDt = ediSndDt;
		this.cntrTpszCd4 = cntrTpszCd4;
		this.cntrTpszCd3 = cntrTpszCd3;
		this.jpTmlVslNo = jpTmlVslNo;
		this.bkgSkdDeltFlg = bkgSkdDeltFlg;


	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("edi_snd_usr_id", getEdiSndUsrId());
		this.hashColumns.put("bat_skd_prd_fm_dt", getBatSkdPrdFmDt());
		this.hashColumns.put("snaccs_tml_edi_sts_cng_flg", getSnaccsTmlEdiStsCngFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("por_yd_cd", getPorYdCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("be_bkrbkc", getBeBkrbkc());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("edi_snd_tm", getEdiSndTm());
		this.hashColumns.put("cntr_vol_qty5", getCntrVolQty5());
		this.hashColumns.put("cntr_vol_qty4", getCntrVolQty4());
		this.hashColumns.put("call_sgn_no", getCallSgnNo());
		this.hashColumns.put("edi_snd_ofc_cd", getEdiSndOfcCd());
		this.hashColumns.put("cntr_vol_qty1", getCntrVolQty1());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("bkrbkc", getBkrbkc());
		this.hashColumns.put("cntr_vol_qty3", getCntrVolQty3());
		this.hashColumns.put("cntr_vol_qty2", getCntrVolQty2());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("otr_ntfy_yd_cd", getOtrNtfyYdCd());
		this.hashColumns.put("cntr_tpsz_cd5", getCntrTpszCd5());
		this.hashColumns.put("bat_skd_prd_to_dt", getBatSkdPrdToDt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pol_yd_cd", getPolYdCd());
		this.hashColumns.put("cntr_tpsz_cd2", getCntrTpszCd2());
		this.hashColumns.put("cntr_tpsz_cd1", getCntrTpszCd1());
		this.hashColumns.put("edi_snd_dt", getEdiSndDt());
		this.hashColumns.put("cntr_tpsz_cd4", getCntrTpszCd4());
		this.hashColumns.put("cntr_tpsz_cd3", getCntrTpszCd3());
		this.hashColumns.put("jp_tml_vsl_no", getJpTmlVslNo());
		this.hashColumns.put("bkg_skd_delt_flg", getBkgSkdDeltFlg());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("edi_snd_usr_id", "ediSndUsrId");
		this.hashFields.put("bat_skd_prd_fm_dt", "batSkdPrdFmDt");
		this.hashFields.put("snaccs_tml_edi_sts_cng_flg", "snaccsTmlEdiStsCngFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("por_yd_cd", "porYdCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("be_bkrbkc", "beBkrbkc");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("edi_snd_tm", "ediSndTm");
		this.hashFields.put("cntr_vol_qty5", "cntrVolQty5");
		this.hashFields.put("cntr_vol_qty4", "cntrVolQty4");
		this.hashFields.put("call_sgn_no", "callSgnNo");
		this.hashFields.put("edi_snd_ofc_cd", "ediSndOfcCd");
		this.hashFields.put("cntr_vol_qty1", "cntrVolQty1");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("bkrbkc", "bkrbkc");
		this.hashFields.put("cntr_vol_qty3", "cntrVolQty3");
		this.hashFields.put("cntr_vol_qty2", "cntrVolQty2");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("otr_ntfy_yd_cd", "otrNtfyYdCd");
		this.hashFields.put("cntr_tpsz_cd5", "cntrTpszCd5");
		this.hashFields.put("bat_skd_prd_to_dt", "batSkdPrdToDt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pol_yd_cd", "polYdCd");
		this.hashFields.put("cntr_tpsz_cd2", "cntrTpszCd2");
		this.hashFields.put("cntr_tpsz_cd1", "cntrTpszCd1");
		this.hashFields.put("edi_snd_dt", "ediSndDt");
		this.hashFields.put("cntr_tpsz_cd4", "cntrTpszCd4");
		this.hashFields.put("cntr_tpsz_cd3", "cntrTpszCd3");
		this.hashFields.put("jp_tml_vsl_no", "jpTmlVslNo");
		this.hashFields.put("bkg_skd_delt_flg", "bkgSkdDeltFlg");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
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
	 * @return ediSndUsrId
	 */
	public String getEdiSndUsrId() {
		return this.ediSndUsrId;
	}

	/**
	 * Column Info
	 * @return batSkdPrdFmDt
	 */
	public String getBatSkdPrdFmDt() {
		return this.batSkdPrdFmDt;
	}

	/**
	 * Column Info
	 * @return snaccsTmlEdiStsCngFlg
	 */
	public String getSnaccsTmlEdiStsCngFlg() {
		return this.snaccsTmlEdiStsCngFlg;
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
	 * @return porYdCd
	 */
	public String getPorYdCd() {
		return this.porYdCd;
	}

	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}

	/**
	 * Column Info
	 * @return beBkrbkc
	 */
	public String getBeBkrbkc() {
		return this.beBkrbkc;
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
	 * @return ediSndTm
	 */
	public String getEdiSndTm() {
		return this.ediSndTm;
	}

	/**
	 * Column Info
	 * @return cntrVolQty5
	 */
	public String getCntrVolQty5() {
		return this.cntrVolQty5;
	}

	/**
	 * Column Info
	 * @return cntrVolQty4
	 */
	public String getCntrVolQty4() {
		return this.cntrVolQty4;
	}

	/**
	 * Column Info
	 * @return callSgnNo
	 */
	public String getCallSgnNo() {
		return this.callSgnNo;
	}

	/**
	 * Column Info
	 * @return ediSndOfcCd
	 */
	public String getEdiSndOfcCd() {
		return this.ediSndOfcCd;
	}

	/**
	 * Column Info
	 * @return cntrVolQty1
	 */
	public String getCntrVolQty1() {
		return this.cntrVolQty1;
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
	 * @return bkrbkc
	 */
	public String getBkrbkc() {
		return this.bkrbkc;
	}

	/**
	 * Column Info
	 * @return cntrVolQty3
	 */
	public String getCntrVolQty3() {
		return this.cntrVolQty3;
	}

	/**
	 * Column Info
	 * @return cntrVolQty2
	 */
	public String getCntrVolQty2() {
		return this.cntrVolQty2;
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
	 * @return otrNtfyYdCd
	 */
	public String getOtrNtfyYdCd() {
		return this.otrNtfyYdCd;
	}

	/**
	 * Column Info
	 * @return cntrTpszCd5
	 */
	public String getCntrTpszCd5() {
		return this.cntrTpszCd5;
	}

	/**
	 * Column Info
	 * @return batSkdPrdToDt
	 */
	public String getBatSkdPrdToDt() {
		return this.batSkdPrdToDt;
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
	 * @return polYdCd
	 */
	public String getPolYdCd() {
		return this.polYdCd;
	}

	/**
	 * Column Info
	 * @return cntrTpszCd2
	 */
	public String getCntrTpszCd2() {
		return this.cntrTpszCd2;
	}

	/**
	 * Column Info
	 * @return cntrTpszCd1
	 */
	public String getCntrTpszCd1() {
		return this.cntrTpszCd1;
	}

	/**
	 * Column Info
	 * @return ediSndDt
	 */
	public String getEdiSndDt() {
		return this.ediSndDt;
	}

	/**
	 * Column Info
	 * @return cntrTpszCd4
	 */
	public String getCntrTpszCd4() {
		return this.cntrTpszCd4;
	}

	/**
	 * Column Info
	 * @return cntrTpszCd3
	 */
	public String getCntrTpszCd3() {
		return this.cntrTpszCd3;
	}

	/**
	 * Column Info
	 * @return jpTmlVslNo
	 */
	public String getJpTmlVslNo() {
		return this.jpTmlVslNo;
	}

	/**
	 * Column Info
	 * @return bkgSkdDeltFlg
	 */
	public String getBkgSkdDeltFlg() {
		return this.bkgSkdDeltFlg;
	}



	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
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
	 * @param ediSndUsrId
	 */
	public void setEdiSndUsrId(String ediSndUsrId) {
		this.ediSndUsrId = ediSndUsrId;
	}

	/**
	 * Column Info
	 * @param batSkdPrdFmDt
	 */
	public void setBatSkdPrdFmDt(String batSkdPrdFmDt) {
		this.batSkdPrdFmDt = batSkdPrdFmDt;
	}

	/**
	 * Column Info
	 * @param snaccsTmlEdiStsCngFlg
	 */
	public void setSnaccsTmlEdiStsCngFlg(String snaccsTmlEdiStsCngFlg) {
		this.snaccsTmlEdiStsCngFlg = snaccsTmlEdiStsCngFlg;
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
	 * @param porYdCd
	 */
	public void setPorYdCd(String porYdCd) {
		this.porYdCd = porYdCd;
	}

	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}

	/**
	 * Column Info
	 * @param beBkrbkc
	 */
	public void setBeBkrbkc(String beBkrbkc) {
		this.beBkrbkc = beBkrbkc;
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
	 * @param ediSndTm
	 */
	public void setEdiSndTm(String ediSndTm) {
		this.ediSndTm = ediSndTm;
	}

	/**
	 * Column Info
	 * @param cntrVolQty5
	 */
	public void setCntrVolQty5(String cntrVolQty5) {
		this.cntrVolQty5 = cntrVolQty5;
	}

	/**
	 * Column Info
	 * @param cntrVolQty4
	 */
	public void setCntrVolQty4(String cntrVolQty4) {
		this.cntrVolQty4 = cntrVolQty4;
	}

	/**
	 * Column Info
	 * @param callSgnNo
	 */
	public void setCallSgnNo(String callSgnNo) {
		this.callSgnNo = callSgnNo;
	}

	/**
	 * Column Info
	 * @param ediSndOfcCd
	 */
	public void setEdiSndOfcCd(String ediSndOfcCd) {
		this.ediSndOfcCd = ediSndOfcCd;
	}

	/**
	 * Column Info
	 * @param cntrVolQty1
	 */
	public void setCntrVolQty1(String cntrVolQty1) {
		this.cntrVolQty1 = cntrVolQty1;
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
	 * @param bkrbkc
	 */
	public void setBkrbkc(String bkrbkc) {
		this.bkrbkc = bkrbkc;
	}

	/**
	 * Column Info
	 * @param cntrVolQty3
	 */
	public void setCntrVolQty3(String cntrVolQty3) {
		this.cntrVolQty3 = cntrVolQty3;
	}

	/**
	 * Column Info
	 * @param cntrVolQty2
	 */
	public void setCntrVolQty2(String cntrVolQty2) {
		this.cntrVolQty2 = cntrVolQty2;
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
	 * @param otrNtfyYdCd
	 */
	public void setOtrNtfyYdCd(String otrNtfyYdCd) {
		this.otrNtfyYdCd = otrNtfyYdCd;
	}

	/**
	 * Column Info
	 * @param cntrTpszCd5
	 */
	public void setCntrTpszCd5(String cntrTpszCd5) {
		this.cntrTpszCd5 = cntrTpszCd5;
	}

	/**
	 * Column Info
	 * @param batSkdPrdToDt
	 */
	public void setBatSkdPrdToDt(String batSkdPrdToDt) {
		this.batSkdPrdToDt = batSkdPrdToDt;
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
	 * @param polYdCd
	 */
	public void setPolYdCd(String polYdCd) {
		this.polYdCd = polYdCd;
	}

	/**
	 * Column Info
	 * @param cntrTpszCd2
	 */
	public void setCntrTpszCd2(String cntrTpszCd2) {
		this.cntrTpszCd2 = cntrTpszCd2;
	}

	/**
	 * Column Info
	 * @param cntrTpszCd1
	 */
	public void setCntrTpszCd1(String cntrTpszCd1) {
		this.cntrTpszCd1 = cntrTpszCd1;
	}

	/**
	 * Column Info
	 * @param ediSndDt
	 */
	public void setEdiSndDt(String ediSndDt) {
		this.ediSndDt = ediSndDt;
	}

	/**
	 * Column Info
	 * @param cntrTpszCd4
	 */
	public void setCntrTpszCd4(String cntrTpszCd4) {
		this.cntrTpszCd4 = cntrTpszCd4;
	}

	/**
	 * Column Info
	 * @param sSkdVoyNo
	 */
	public void setJpTmlVslNo(String jpTmlVslNo) {
		this.jpTmlVslNo = jpTmlVslNo;
	}

	/**
	 * Column Info
	 * @param bkgSkdDeltFlg
	 */
	public void setBkgSkdDeltFlg(String bkgSkdDeltFlg) {
		this.bkgSkdDeltFlg = bkgSkdDeltFlg;
	}



	/**
	 * Column Info
	 * @param cntrTpszCd3
	 */
	public void setCntrTpszCd3(String cntrTpszCd3) {
		this.cntrTpszCd3 = cntrTpszCd3;
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
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setEdiSndUsrId(JSPUtil.getParameter(request, prefix + "edi_snd_usr_id", ""));
		setBatSkdPrdFmDt(JSPUtil.getParameter(request, prefix + "bat_skd_prd_fm_dt", ""));
		setSnaccsTmlEdiStsCngFlg(JSPUtil.getParameter(request, prefix + "snaccs_tml_edi_sts_cng_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPorYdCd(JSPUtil.getParameter(request, prefix + "por_yd_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setBeBkrbkc(JSPUtil.getParameter(request, prefix + "be_bkrbkc", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setEdiSndTm(JSPUtil.getParameter(request, prefix + "edi_snd_tm", ""));
		setCntrVolQty5(JSPUtil.getParameter(request, prefix + "cntr_vol_qty5", ""));
		setCntrVolQty4(JSPUtil.getParameter(request, prefix + "cntr_vol_qty4", ""));
		setCallSgnNo(JSPUtil.getParameter(request, prefix + "call_sgn_no", ""));
		setEdiSndOfcCd(JSPUtil.getParameter(request, prefix + "edi_snd_ofc_cd", ""));
		setCntrVolQty1(JSPUtil.getParameter(request, prefix + "cntr_vol_qty1", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setBkrbkc(JSPUtil.getParameter(request, prefix + "bkrbkc", ""));
		setCntrVolQty3(JSPUtil.getParameter(request, prefix + "cntr_vol_qty3", ""));
		setCntrVolQty2(JSPUtil.getParameter(request, prefix + "cntr_vol_qty2", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setOtrNtfyYdCd(JSPUtil.getParameter(request, prefix + "otr_ntfy_yd_cd", ""));
		setCntrTpszCd5(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd5", ""));
		setBatSkdPrdToDt(JSPUtil.getParameter(request, prefix + "bat_skd_prd_to_dt", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setPolYdCd(JSPUtil.getParameter(request, prefix + "pol_yd_cd", ""));
		setCntrTpszCd2(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd2", ""));
		setCntrTpszCd1(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd1", ""));
		setEdiSndDt(JSPUtil.getParameter(request, prefix + "edi_snd_dt", ""));
		setCntrTpszCd4(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd4", ""));
		setCntrTpszCd3(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd3", ""));
		setJpTmlVslNo(JSPUtil.getParameter(request, prefix + "jp_tml_vsl_no", ""));
		setBkgSkdDeltFlg(JSPUtil.getParameter(request, prefix + "bkg_skd_delt_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgJapanTerminalEdiVO[]
	 */
	public BkgJapanTerminalEdiVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return BkgJapanTerminalEdiVO[]
	 */
	public BkgJapanTerminalEdiVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgJapanTerminalEdiVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] ediSndUsrId = (JSPUtil.getParameter(request, prefix	+ "edi_snd_usr_id", length));
			String[] batSkdPrdFmDt = (JSPUtil.getParameter(request, prefix	+ "bat_skd_prd_fm_dt", length));
			String[] snaccsTmlEdiStsCngFlg = (JSPUtil.getParameter(request, prefix	+ "snaccs_tml_edi_sts_cng_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] porYdCd = (JSPUtil.getParameter(request, prefix	+ "por_yd_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] beBkrbkc = (JSPUtil.getParameter(request, prefix	+ "be_bkrbkc", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] ediSndTm = (JSPUtil.getParameter(request, prefix	+ "edi_snd_tm", length));
			String[] cntrVolQty5 = (JSPUtil.getParameter(request, prefix	+ "cntr_vol_qty5", length));
			String[] cntrVolQty4 = (JSPUtil.getParameter(request, prefix	+ "cntr_vol_qty4", length));
			String[] callSgnNo = (JSPUtil.getParameter(request, prefix	+ "call_sgn_no", length));
			String[] ediSndOfcCd = (JSPUtil.getParameter(request, prefix	+ "edi_snd_ofc_cd", length));
			String[] cntrVolQty1 = (JSPUtil.getParameter(request, prefix	+ "cntr_vol_qty1", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] bkrbkc = (JSPUtil.getParameter(request, prefix	+ "bkrbkc", length));
			String[] cntrVolQty3 = (JSPUtil.getParameter(request, prefix	+ "cntr_vol_qty3", length));
			String[] cntrVolQty2 = (JSPUtil.getParameter(request, prefix	+ "cntr_vol_qty2", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] otrNtfyYdCd = (JSPUtil.getParameter(request, prefix	+ "otr_ntfy_yd_cd", length));
			String[] cntrTpszCd5 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd5", length));
			String[] batSkdPrdToDt = (JSPUtil.getParameter(request, prefix	+ "bat_skd_prd_to_dt", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] polYdCd = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd", length));
			String[] cntrTpszCd2 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd2", length));
			String[] cntrTpszCd1 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd1", length));
			String[] ediSndDt = (JSPUtil.getParameter(request, prefix	+ "edi_snd_dt", length));
			String[] cntrTpszCd4 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd4", length));
			String[] cntrTpszCd3 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd3", length));
			String[] jpTmlVslNo = (JSPUtil.getParameter(request, prefix	+ "jp_tml_vsl_no", length));
			String[] bkgSkdDeltFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_skd_delt_flg", length));


			for (int i = 0; i < length; i++) {
				model = new BkgJapanTerminalEdiVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (ediSndUsrId[i] != null)
					model.setEdiSndUsrId(ediSndUsrId[i]);
				if (batSkdPrdFmDt[i] != null)
					model.setBatSkdPrdFmDt(batSkdPrdFmDt[i]);
				if (snaccsTmlEdiStsCngFlg[i] != null)
					model.setSnaccsTmlEdiStsCngFlg(snaccsTmlEdiStsCngFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (porYdCd[i] != null)
					model.setPorYdCd(porYdCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (beBkrbkc[i] != null)
					model.setBeBkrbkc(beBkrbkc[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (ediSndTm[i] != null)
					model.setEdiSndTm(ediSndTm[i]);
				if (cntrVolQty5[i] != null)
					model.setCntrVolQty5(cntrVolQty5[i]);
				if (cntrVolQty4[i] != null)
					model.setCntrVolQty4(cntrVolQty4[i]);
				if (callSgnNo[i] != null)
					model.setCallSgnNo(callSgnNo[i]);
				if (ediSndOfcCd[i] != null)
					model.setEdiSndOfcCd(ediSndOfcCd[i]);
				if (cntrVolQty1[i] != null)
					model.setCntrVolQty1(cntrVolQty1[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (bkrbkc[i] != null)
					model.setBkrbkc(bkrbkc[i]);
				if (cntrVolQty3[i] != null)
					model.setCntrVolQty3(cntrVolQty3[i]);
				if (cntrVolQty2[i] != null)
					model.setCntrVolQty2(cntrVolQty2[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (otrNtfyYdCd[i] != null)
					model.setOtrNtfyYdCd(otrNtfyYdCd[i]);
				if (cntrTpszCd5[i] != null)
					model.setCntrTpszCd5(cntrTpszCd5[i]);
				if (batSkdPrdToDt[i] != null)
					model.setBatSkdPrdToDt(batSkdPrdToDt[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (polYdCd[i] != null)
					model.setPolYdCd(polYdCd[i]);
				if (cntrTpszCd2[i] != null)
					model.setCntrTpszCd2(cntrTpszCd2[i]);
				if (cntrTpszCd1[i] != null)
					model.setCntrTpszCd1(cntrTpszCd1[i]);
				if (ediSndDt[i] != null)
					model.setEdiSndDt(ediSndDt[i]);
				if (cntrTpszCd4[i] != null)
					model.setCntrTpszCd4(cntrTpszCd4[i]);
				if (cntrTpszCd3[i] != null)
					model.setCntrTpszCd3(cntrTpszCd3[i]);
				if (jpTmlVslNo[i] != null)
					model.setJpTmlVslNo(jpTmlVslNo[i]);
				if (bkgSkdDeltFlg[i] != null)
					model.setBkgSkdDeltFlg(bkgSkdDeltFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgJapanTerminalEdiVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgJapanTerminalEdiVO[]
	 */
	public BkgJapanTerminalEdiVO[] getBkgJapanTerminalEdiVOs(){
		BkgJapanTerminalEdiVO[] vos = (BkgJapanTerminalEdiVO[])models.toArray(new BkgJapanTerminalEdiVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndUsrId = this.ediSndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batSkdPrdFmDt = this.batSkdPrdFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.snaccsTmlEdiStsCngFlg = this.snaccsTmlEdiStsCngFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porYdCd = this.porYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.beBkrbkc = this.beBkrbkc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndTm = this.ediSndTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVolQty5 = this.cntrVolQty5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVolQty4 = this.cntrVolQty4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSgnNo = this.callSgnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndOfcCd = this.ediSndOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVolQty1 = this.cntrVolQty1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkrbkc = this.bkrbkc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVolQty3 = this.cntrVolQty3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVolQty2 = this.cntrVolQty2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otrNtfyYdCd = this.otrNtfyYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd5 = this.cntrTpszCd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batSkdPrdToDt = this.batSkdPrdToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd = this.polYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd2 = this.cntrTpszCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd1 = this.cntrTpszCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndDt = this.ediSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd4 = this.cntrTpszCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd3 = this.cntrTpszCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jpTmlVslNo = this.jpTmlVslNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSkdDeltFlg = this.bkgSkdDeltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
