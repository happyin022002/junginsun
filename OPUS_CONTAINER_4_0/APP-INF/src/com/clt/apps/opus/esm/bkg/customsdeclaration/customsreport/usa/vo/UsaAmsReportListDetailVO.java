/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaAmsReportListDetailVO.java
*@FileTitle : UsaAmsReportListDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.19
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.05.19 김민정 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.AmsReportListDetailVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UsaAmsReportListDetailVO extends AmsReportListDetailVO {
	private static final long serialVersionUID = 1L;
	
	private Collection<UsaAmsReportListDetailVO> models = new ArrayList<UsaAmsReportListDetailVO>();
	
	/* Column Info */
	private String total = null;
	/* Column Info */
	private String pkupReleased = null;
	/* Column Info */
	private String ibdTrspXptAcptDt = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String ibdTrspArrDt = null;
	/* Column Info */
	private String ibdTrspArrAcptDt = null;
	/* Column Info */
	private String arrDt = null;
	/* Column Info */
	private String mfStsCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pkupDate = null;
	/* Column Info */
	private String cstmsMfTpCd = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ibdTrspAcptDt = null;
	/* Column Info */
	private String frtCltFlg = null;
	/* Column Info */
	private String rnum = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String bkgCustTpCd = null;
	/* Column Info */
	private String freeTrdZnFlg = null;
	/* Column Info */
	private String ibdTrspIssDt = null;
	/* Column Info */
	private String filer = null;
	/* Column Info */
	private String amsFileNo = null;
	/* Column Info */
	private String ibdTrspNo = null;
	/* Column Info */
	private String ibdTrspTpCd = null;
	/* Column Info */
	private String cstmsClrCd = null;
	/* Column Info */
	private String usaIbTrspNo = null;
	/* Column Info */
	private String ibdTrspXptDt = null;
	/* Column Info */
	private String railCrrRefNo = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String oblRdemFlg = null;
	/* Column Info */
	private String dspoCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String mblNo = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String cstmsDspoNm = null;
	/* Column Info */
	private String blCnt = null;
	/* Column Info */
	private String hubLocCd = null;
	/* Column Info */
	private String pkupNo = null;
	/* Column Info */
	private String cntrPrtFlg = null;
	/* Column Info */
	private String master = null;
	/* Column Info */
	private String rlseEdi = null;
	/* Column Info */
	private String sumCmQty = null;
	/* Column Info */
	private String rQty = null;
	/* Column Info */
	private String rlseQty = null;
	/* Column Info */
	private String rBilling = null;
	/* Column Info */
	private String feu = null;
	/* Column Info */
	private String teu = null;
	/* Column Info */
	private String cFlag = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsaAmsReportListDetailVO() {}

	public UsaAmsReportListDetailVO(String ibflag, String pagerows, String cntCd, String dspoCd, String mblNo, String amsFileNo, String filer, String mfStsCd, String cstmsMfTpCd, String podCd, String delCd, String hubLocCd, String cntrNo, String cntrTpszCd, String frtCltFlg, String oblRdemFlg, String ibdTrspNo, String ibdTrspTpCd, String freeTrdZnFlg, String ibdTrspIssDt, String ibdTrspAcptDt, String ibdTrspArrDt, String ibdTrspArrAcptDt, String ibdTrspXptDt, String ibdTrspXptAcptDt, String rcvTermCd, String deTermCd, String arrDt, String scNo, String cstmsDspoNm, String polCd, String bkgNo, String vvd, String railCrrRefNo, String usaIbTrspNo, String pkupNo, String pkupReleased, String pkupDate, String cstmsClrCd, String rnum, String total, String bkgCustTpCd, String seq, String blCnt, String custNm, String cntrPrtFlg, String master, String rlseEdi, String sumCmQty, String rQty, String rlseQty, String rBilling, String feu, String teu, String cFlag) {
		this.total = total;
		this.pkupReleased = pkupReleased;
		this.ibdTrspXptAcptDt = ibdTrspXptAcptDt;
		this.custNm = custNm;
		this.ibdTrspArrDt = ibdTrspArrDt;
		this.ibdTrspArrAcptDt = ibdTrspArrAcptDt;
		this.arrDt = arrDt;
		this.mfStsCd = mfStsCd;
		this.pagerows = pagerows;
		this.pkupDate = pkupDate;
		this.cstmsMfTpCd = cstmsMfTpCd;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.ibdTrspAcptDt = ibdTrspAcptDt;
		this.frtCltFlg = frtCltFlg;
		this.rnum = rnum;
		this.scNo = scNo;
		this.cntCd = cntCd;
		this.cntrTpszCd = cntrTpszCd;
		this.rcvTermCd = rcvTermCd;
		this.bkgCustTpCd = bkgCustTpCd;
		this.freeTrdZnFlg = freeTrdZnFlg;
		this.ibdTrspIssDt = ibdTrspIssDt;
		this.filer = filer;
		this.amsFileNo = amsFileNo;
		this.ibdTrspNo = ibdTrspNo;
		this.ibdTrspTpCd = ibdTrspTpCd;
		this.cstmsClrCd = cstmsClrCd;
		this.usaIbTrspNo = usaIbTrspNo;
		this.ibdTrspXptDt = ibdTrspXptDt;
		this.railCrrRefNo = railCrrRefNo;
		this.delCd = delCd;
		this.oblRdemFlg = oblRdemFlg;
		this.dspoCd = dspoCd;
		this.vvd = vvd;
		this.podCd = podCd;
		this.deTermCd = deTermCd;
		this.bkgNo = bkgNo;
		this.cntrNo = cntrNo;
		this.mblNo = mblNo;
		this.seq = seq;
		this.cstmsDspoNm = cstmsDspoNm;
		this.blCnt = blCnt;
		this.hubLocCd = hubLocCd;
		this.pkupNo = pkupNo;
		this.cntrPrtFlg = cntrPrtFlg;
		this.master = master;
		this.rlseEdi = rlseEdi;
		this.sumCmQty = sumCmQty;
		this.rQty = rQty;
		this.rlseQty = rlseQty;
		this.rBilling = rBilling;
		this.feu = feu;
		this.teu = teu;
		this.cFlag = cFlag;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("total", getTotal());
		this.hashColumns.put("pkup_released", getPkupReleased());
		this.hashColumns.put("ibd_trsp_xpt_acpt_dt", getIbdTrspXptAcptDt());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("ibd_trsp_arr_dt", getIbdTrspArrDt());
		this.hashColumns.put("ibd_trsp_arr_acpt_dt", getIbdTrspArrAcptDt());
		this.hashColumns.put("arr_dt", getArrDt());
		this.hashColumns.put("mf_sts_cd", getMfStsCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pkup_date", getPkupDate());
		this.hashColumns.put("cstms_mf_tp_cd", getCstmsMfTpCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ibd_trsp_acpt_dt", getIbdTrspAcptDt());
		this.hashColumns.put("frt_clt_flg", getFrtCltFlg());
		this.hashColumns.put("rnum", getRnum());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("bkg_cust_tp_cd", getBkgCustTpCd());
		this.hashColumns.put("free_trd_zn_flg", getFreeTrdZnFlg());
		this.hashColumns.put("ibd_trsp_iss_dt", getIbdTrspIssDt());
		this.hashColumns.put("filer", getFiler());
		this.hashColumns.put("ams_file_no", getAmsFileNo());
		this.hashColumns.put("ibd_trsp_no", getIbdTrspNo());
		this.hashColumns.put("ibd_trsp_tp_cd", getIbdTrspTpCd());
		this.hashColumns.put("cstms_clr_cd", getCstmsClrCd());
		this.hashColumns.put("usa_ib_trsp_no", getUsaIbTrspNo());
		this.hashColumns.put("ibd_trsp_xpt_dt", getIbdTrspXptDt());
		this.hashColumns.put("rail_crr_ref_no", getRailCrrRefNo());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("obl_rdem_flg", getOblRdemFlg());
		this.hashColumns.put("dspo_cd", getDspoCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("mbl_no", getMblNo());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("cstms_dspo_nm", getCstmsDspoNm());
		this.hashColumns.put("bl_cnt", getBlCnt());
		this.hashColumns.put("hub_loc_cd", getHubLocCd());
		this.hashColumns.put("pkup_no", getPkupNo());
		this.hashColumns.put("cntr_prt_flg", getCntrPrtFlg());
		this.hashColumns.put("master", getMaster());
		this.hashColumns.put("rlse_edi", getRlseEdi());
		this.hashColumns.put("sum_cm_qty", getSumCmQty());
		this.hashColumns.put("r_qty", getRQty());
		this.hashColumns.put("rlse_qty", getRlseQty());
		this.hashColumns.put("r_billing", getRBilling());
		this.hashColumns.put("feu", getFeu());
		this.hashColumns.put("teu", getTeu());
		this.hashColumns.put("c_flag", getCFlag());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("total", "total");
		this.hashFields.put("pkup_released", "pkupReleased");
		this.hashFields.put("ibd_trsp_xpt_acpt_dt", "ibdTrspXptAcptDt");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("ibd_trsp_arr_dt", "ibdTrspArrDt");
		this.hashFields.put("ibd_trsp_arr_acpt_dt", "ibdTrspArrAcptDt");
		this.hashFields.put("arr_dt", "arrDt");
		this.hashFields.put("mf_sts_cd", "mfStsCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pkup_date", "pkupDate");
		this.hashFields.put("cstms_mf_tp_cd", "cstmsMfTpCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ibd_trsp_acpt_dt", "ibdTrspAcptDt");
		this.hashFields.put("frt_clt_flg", "frtCltFlg");
		this.hashFields.put("rnum", "rnum");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("bkg_cust_tp_cd", "bkgCustTpCd");
		this.hashFields.put("free_trd_zn_flg", "freeTrdZnFlg");
		this.hashFields.put("ibd_trsp_iss_dt", "ibdTrspIssDt");
		this.hashFields.put("filer", "filer");
		this.hashFields.put("ams_file_no", "amsFileNo");
		this.hashFields.put("ibd_trsp_no", "ibdTrspNo");
		this.hashFields.put("ibd_trsp_tp_cd", "ibdTrspTpCd");
		this.hashFields.put("cstms_clr_cd", "cstmsClrCd");
		this.hashFields.put("usa_ib_trsp_no", "usaIbTrspNo");
		this.hashFields.put("ibd_trsp_xpt_dt", "ibdTrspXptDt");
		this.hashFields.put("rail_crr_ref_no", "railCrrRefNo");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("obl_rdem_flg", "oblRdemFlg");
		this.hashFields.put("dspo_cd", "dspoCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("mbl_no", "mblNo");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("cstms_dspo_nm", "cstmsDspoNm");
		this.hashFields.put("bl_cnt", "blCnt");
		this.hashFields.put("hub_loc_cd", "hubLocCd");
		this.hashFields.put("pkup_no", "pkupNo");
		this.hashFields.put("cntr_prt_flg", "cntrPrtFlg");
		this.hashFields.put("master", "master");
		this.hashFields.put("rlse_edi", "rlseEdi");
		this.hashFields.put("sum_cm_qty", "sumCmQty");
		this.hashFields.put("r_qty", "rQty");
		this.hashFields.put("rlse_qty", "rlseQty");
		this.hashFields.put("r_billing", "rBilling");
		this.hashFields.put("feu", "feu");
		this.hashFields.put("teu", "teu");
		this.hashFields.put("c_flag", "cFlag");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return total
	 */
	public String getTotal() {
		return this.total;
	}
	
	/**
	 * Column Info
	 * @return pkupReleased
	 */
	public String getPkupReleased() {
		return this.pkupReleased;
	}
	
	/**
	 * Column Info
	 * @return ibdTrspXptAcptDt
	 */
	public String getIbdTrspXptAcptDt() {
		return this.ibdTrspXptAcptDt;
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
	 * @return ibdTrspArrDt
	 */
	public String getIbdTrspArrDt() {
		return this.ibdTrspArrDt;
	}
	
	/**
	 * Column Info
	 * @return ibdTrspArrAcptDt
	 */
	public String getIbdTrspArrAcptDt() {
		return this.ibdTrspArrAcptDt;
	}
	
	/**
	 * Column Info
	 * @return arrDt
	 */
	public String getArrDt() {
		return this.arrDt;
	}
	
	/**
	 * Column Info
	 * @return mfStsCd
	 */
	public String getMfStsCd() {
		return this.mfStsCd;
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
	 * @return pkupDate
	 */
	public String getPkupDate() {
		return this.pkupDate;
	}
	
	/**
	 * Column Info
	 * @return cstmsMfTpCd
	 */
	public String getCstmsMfTpCd() {
		return this.cstmsMfTpCd;
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
	 * @return ibdTrspAcptDt
	 */
	public String getIbdTrspAcptDt() {
		return this.ibdTrspAcptDt;
	}
	
	/**
	 * Column Info
	 * @return frtCltFlg
	 */
	public String getFrtCltFlg() {
		return this.frtCltFlg;
	}
	
	/**
	 * Column Info
	 * @return rnum
	 */
	public String getRnum() {
		return this.rnum;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return bkgCustTpCd
	 */
	public String getBkgCustTpCd() {
		return this.bkgCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return freeTrdZnFlg
	 */
	public String getFreeTrdZnFlg() {
		return this.freeTrdZnFlg;
	}
	
	/**
	 * Column Info
	 * @return ibdTrspIssDt
	 */
	public String getIbdTrspIssDt() {
		return this.ibdTrspIssDt;
	}
	
	/**
	 * Column Info
	 * @return filer
	 */
	public String getFiler() {
		return this.filer;
	}
	
	/**
	 * Column Info
	 * @return amsFileNo
	 */
	public String getAmsFileNo() {
		return this.amsFileNo;
	}
	
	/**
	 * Column Info
	 * @return ibdTrspNo
	 */
	public String getIbdTrspNo() {
		return this.ibdTrspNo;
	}
	
	/**
	 * Column Info
	 * @return ibdTrspTpCd
	 */
	public String getIbdTrspTpCd() {
		return this.ibdTrspTpCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsClrCd
	 */
	public String getCstmsClrCd() {
		return this.cstmsClrCd;
	}
	
	/**
	 * Column Info
	 * @return usaIbTrspNo
	 */
	public String getUsaIbTrspNo() {
		return this.usaIbTrspNo;
	}
	
	/**
	 * Column Info
	 * @return ibdTrspXptDt
	 */
	public String getIbdTrspXptDt() {
		return this.ibdTrspXptDt;
	}
	
	/**
	 * Column Info
	 * @return railCrrRefNo
	 */
	public String getRailCrrRefNo() {
		return this.railCrrRefNo;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return oblRdemFlg
	 */
	public String getOblRdemFlg() {
		return this.oblRdemFlg;
	}
	
	/**
	 * Column Info
	 * @return dspoCd
	 */
	public String getDspoCd() {
		return this.dspoCd;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return mblNo
	 */
	public String getMblNo() {
		return this.mblNo;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return cstmsDspoNm
	 */
	public String getCstmsDspoNm() {
		return this.cstmsDspoNm;
	}
	
	/**
	 * Column Info
	 * @return blCnt
	 */
	public String getBlCnt() {
		return this.blCnt;
	}
	
	/**
	 * Column Info
	 * @return hubLocCd
	 */
	public String getHubLocCd() {
		return this.hubLocCd;
	}
	
	/**
	 * Column Info
	 * @return pkupNo
	 */
	public String getPkupNo() {
		return this.pkupNo;
	}
	
	public String getCntrPrtFlg(){
		return this.cntrPrtFlg;
	}

	/**
	 * Column Info
	 * @param total
	 */
	public void setTotal(String total) {
		this.total = total;
	}
	
	/**
	 * Column Info
	 * @param pkupReleased
	 */
	public void setPkupReleased(String pkupReleased) {
		this.pkupReleased = pkupReleased;
	}
	
	/**
	 * Column Info
	 * @param ibdTrspXptAcptDt
	 */
	public void setIbdTrspXptAcptDt(String ibdTrspXptAcptDt) {
		this.ibdTrspXptAcptDt = ibdTrspXptAcptDt;
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
	 * @param ibdTrspArrDt
	 */
	public void setIbdTrspArrDt(String ibdTrspArrDt) {
		this.ibdTrspArrDt = ibdTrspArrDt;
	}
	
	/**
	 * Column Info
	 * @param ibdTrspArrAcptDt
	 */
	public void setIbdTrspArrAcptDt(String ibdTrspArrAcptDt) {
		this.ibdTrspArrAcptDt = ibdTrspArrAcptDt;
	}
	
	/**
	 * Column Info
	 * @param arrDt
	 */
	public void setArrDt(String arrDt) {
		this.arrDt = arrDt;
	}
	
	/**
	 * Column Info
	 * @param mfStsCd
	 */
	public void setMfStsCd(String mfStsCd) {
		this.mfStsCd = mfStsCd;
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
	 * @param pkupDate
	 */
	public void setPkupDate(String pkupDate) {
		this.pkupDate = pkupDate;
	}
	
	/**
	 * Column Info
	 * @param cstmsMfTpCd
	 */
	public void setCstmsMfTpCd(String cstmsMfTpCd) {
		this.cstmsMfTpCd = cstmsMfTpCd;
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
	 * @param ibdTrspAcptDt
	 */
	public void setIbdTrspAcptDt(String ibdTrspAcptDt) {
		this.ibdTrspAcptDt = ibdTrspAcptDt;
	}
	
	/**
	 * Column Info
	 * @param frtCltFlg
	 */
	public void setFrtCltFlg(String frtCltFlg) {
		this.frtCltFlg = frtCltFlg;
	}
	
	/**
	 * Column Info
	 * @param rnum
	 */
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param bkgCustTpCd
	 */
	public void setBkgCustTpCd(String bkgCustTpCd) {
		this.bkgCustTpCd = bkgCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param freeTrdZnFlg
	 */
	public void setFreeTrdZnFlg(String freeTrdZnFlg) {
		this.freeTrdZnFlg = freeTrdZnFlg;
	}
	
	/**
	 * Column Info
	 * @param ibdTrspIssDt
	 */
	public void setIbdTrspIssDt(String ibdTrspIssDt) {
		this.ibdTrspIssDt = ibdTrspIssDt;
	}
	
	/**
	 * Column Info
	 * @param filer
	 */
	public void setFiler(String filer) {
		this.filer = filer;
	}
	
	/**
	 * Column Info
	 * @param amsFileNo
	 */
	public void setAmsFileNo(String amsFileNo) {
		this.amsFileNo = amsFileNo;
	}
	
	/**
	 * Column Info
	 * @param ibdTrspNo
	 */
	public void setIbdTrspNo(String ibdTrspNo) {
		this.ibdTrspNo = ibdTrspNo;
	}
	
	/**
	 * Column Info
	 * @param ibdTrspTpCd
	 */
	public void setIbdTrspTpCd(String ibdTrspTpCd) {
		this.ibdTrspTpCd = ibdTrspTpCd;
	}
	
	/**
	 * Column Info
	 * @param cstmsClrCd
	 */
	public void setCstmsClrCd(String cstmsClrCd) {
		this.cstmsClrCd = cstmsClrCd;
	}
	
	/**
	 * Column Info
	 * @param usaIbTrspNo
	 */
	public void setUsaIbTrspNo(String usaIbTrspNo) {
		this.usaIbTrspNo = usaIbTrspNo;
	}
	
	/**
	 * Column Info
	 * @param ibdTrspXptDt
	 */
	public void setIbdTrspXptDt(String ibdTrspXptDt) {
		this.ibdTrspXptDt = ibdTrspXptDt;
	}
	
	/**
	 * Column Info
	 * @param railCrrRefNo
	 */
	public void setRailCrrRefNo(String railCrrRefNo) {
		this.railCrrRefNo = railCrrRefNo;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param oblRdemFlg
	 */
	public void setOblRdemFlg(String oblRdemFlg) {
		this.oblRdemFlg = oblRdemFlg;
	}
	
	/**
	 * Column Info
	 * @param dspoCd
	 */
	public void setDspoCd(String dspoCd) {
		this.dspoCd = dspoCd;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param mblNo
	 */
	public void setMblNo(String mblNo) {
		this.mblNo = mblNo;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param cstmsDspoNm
	 */
	public void setCstmsDspoNm(String cstmsDspoNm) {
		this.cstmsDspoNm = cstmsDspoNm;
	}
	
	/**
	 * Column Info
	 * @param blCnt
	 */
	public void setBlCnt(String blCnt) {
		this.blCnt = blCnt;
	}
	
	/**
	 * Column Info
	 * @param hubLocCd
	 */
	public void setHubLocCd(String hubLocCd) {
		this.hubLocCd = hubLocCd;
	}
	
	/**
	 * Column Info
	 * @param pkupNo
	 */
	public void setPkupNo(String pkupNo) {
		this.pkupNo = pkupNo;
	}
	
	/**
	 * Column Info
	 * @param pkupNo
	 */
	public void setCntrPrtFlg(String cntrPrtFlg) {
		this.cntrPrtFlg = cntrPrtFlg;
	}
	
	/**
	 * Column Info
	 * @return master
	 */
	public String getMaster() {
		return master;
	}
	
	/**
	 * Column Info
	 * @param master
	 */
	public void setMaster(String master) {
		this.master = master;
	}
	
	/**
	 * Column Info
	 * @return rlseEdi
	 */
	public String getRlseEdi() {
		return rlseEdi;
	}
	
	/**
	 * Column Info
	 * @param rlseEdi
	 */
	public void setRlseEdi(String rlseEdi) {
		this.rlseEdi = rlseEdi;
	}
	
	/**
	 * Column Info
	 * @return sumCmQty
	 */
	public String getSumCmQty() {
		return sumCmQty;
	}
	
	/**
	 * Column Info
	 * @param sumCmQty
	 */
	public void setSumCmQty(String sumCmQty) {
		this.sumCmQty = sumCmQty;
	}
	
	/**
	 * Column Info
	 * @return rQty
	 */
	public String getRQty() {
		return rQty;
	}
	
	/**
	 * Column Info
	 * @param rQty
	 */
	public void setRQty(String qty) {
		rQty = qty;
	}
	
	/**
	 * Column Info
	 * @return rlseQty
	 */
	public String getRlseQty() {
		return rlseQty;
	}
	
	/**
	 * Column Info
	 * @param rlseQty
	 */
	public void setRlseQty(String rlseQty) {
		rlseQty = rlseQty;
	}
	
	/**
	 * Column Info
	 * @return rBilling
	 */
	public String getRBilling() {
		return rBilling;
	}
	
	/**
	 * Column Info
	 * @param rBilling
	 */
	public void setRBilling(String billing) {
		rBilling = billing;
	}
	
	/**
	 * Column Info
	 * @return feu
	 */
	public String getFeu() {
		return feu;
	}
	
	/**
	 * Column Info
	 * @param feu
	 */
	public void setFeu(String feu) {
		this.feu = feu;
	}
	
	/**
	 * Column Info
	 * @return teu
	 */
	public String getTeu() {
		return teu;
	}
	
	/**
	 * Column Info
	 * @param teu
	 */
	public void setTeu(String teu) {
		this.teu = teu;
	}

	/**
	 * Column Info
	 * @return cFlag
	 */
	public String getCFlag() {
		return cFlag;
	}

	/**
	 * Column Info
	 * @param cFlag
	 */
	public void setCFlag(String flag) {
		cFlag = flag;
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
		setTotal(JSPUtil.getParameter(request, prefix + "total", ""));
		setPkupReleased(JSPUtil.getParameter(request, prefix + "pkup_released", ""));
		setIbdTrspXptAcptDt(JSPUtil.getParameter(request, prefix + "ibd_trsp_xpt_acpt_dt", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setIbdTrspArrDt(JSPUtil.getParameter(request, prefix + "ibd_trsp_arr_dt", ""));
		setIbdTrspArrAcptDt(JSPUtil.getParameter(request, prefix + "ibd_trsp_arr_acpt_dt", ""));
		setArrDt(JSPUtil.getParameter(request, prefix + "arr_dt", ""));
		setMfStsCd(JSPUtil.getParameter(request, prefix + "mf_sts_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPkupDate(JSPUtil.getParameter(request, prefix + "pkup_date", ""));
		setCstmsMfTpCd(JSPUtil.getParameter(request, prefix + "cstms_mf_tp_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setIbdTrspAcptDt(JSPUtil.getParameter(request, prefix + "ibd_trsp_acpt_dt", ""));
		setFrtCltFlg(JSPUtil.getParameter(request, prefix + "frt_clt_flg", ""));
		setRnum(JSPUtil.getParameter(request, prefix + "rnum", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
		setBkgCustTpCd(JSPUtil.getParameter(request, prefix + "bkg_cust_tp_cd", ""));
		setFreeTrdZnFlg(JSPUtil.getParameter(request, prefix + "free_trd_zn_flg", ""));
		setIbdTrspIssDt(JSPUtil.getParameter(request, prefix + "ibd_trsp_iss_dt", ""));
		setFiler(JSPUtil.getParameter(request, prefix + "filer", ""));
		setAmsFileNo(JSPUtil.getParameter(request, prefix + "ams_file_no", ""));
		setIbdTrspNo(JSPUtil.getParameter(request, prefix + "ibd_trsp_no", ""));
		setIbdTrspTpCd(JSPUtil.getParameter(request, prefix + "ibd_trsp_tp_cd", ""));
		setCstmsClrCd(JSPUtil.getParameter(request, prefix + "cstms_clr_cd", ""));
		setUsaIbTrspNo(JSPUtil.getParameter(request, prefix + "usa_ib_trsp_no", ""));
		setIbdTrspXptDt(JSPUtil.getParameter(request, prefix + "ibd_trsp_xpt_dt", ""));
		setRailCrrRefNo(JSPUtil.getParameter(request, prefix + "rail_crr_ref_no", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setOblRdemFlg(JSPUtil.getParameter(request, prefix + "obl_rdem_flg", ""));
		setDspoCd(JSPUtil.getParameter(request, prefix + "dspo_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setMblNo(JSPUtil.getParameter(request, prefix + "mbl_no", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setCstmsDspoNm(JSPUtil.getParameter(request, prefix + "cstms_dspo_nm", ""));
		setBlCnt(JSPUtil.getParameter(request, prefix + "bl_cnt", ""));
		setHubLocCd(JSPUtil.getParameter(request, prefix + "hub_loc_cd", ""));
		setPkupNo(JSPUtil.getParameter(request, prefix + "pkup_no", ""));
		setCntrPrtFlg(JSPUtil.getParameter(request, prefix + "cntr_prt_flg", ""));
		setMaster(JSPUtil.getParameter(request, prefix + "master", ""));
		setRlseEdi(JSPUtil.getParameter(request, prefix + "rlse_edi", ""));
		setSumCmQty(JSPUtil.getParameter(request, prefix + "sum_cm_qty", ""));
		setRQty(JSPUtil.getParameter(request, prefix + "r_qty,", ""));
		setRlseQty(JSPUtil.getParameter(request, prefix + "rlse_qty,", ""));
		setRBilling(JSPUtil.getParameter(request, prefix + "r_billing", ""));
		setFeu(JSPUtil.getParameter(request, prefix + "feu", ""));
		setTeu(JSPUtil.getParameter(request, prefix + "teu", ""));
		setCFlag(JSPUtil.getParameter(request, prefix + "c_flag", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaAmsReportListDetailVO[]
	 */
	public UsaAmsReportListDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaAmsReportListDetailVO[]
	 */
	public UsaAmsReportListDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaAmsReportListDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] total = (JSPUtil.getParameter(request, prefix	+ "total", length));
			String[] pkupReleased = (JSPUtil.getParameter(request, prefix	+ "pkup_released", length));
			String[] ibdTrspXptAcptDt = (JSPUtil.getParameter(request, prefix	+ "ibd_trsp_xpt_acpt_dt", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] ibdTrspArrDt = (JSPUtil.getParameter(request, prefix	+ "ibd_trsp_arr_dt", length));
			String[] ibdTrspArrAcptDt = (JSPUtil.getParameter(request, prefix	+ "ibd_trsp_arr_acpt_dt", length));
			String[] arrDt = (JSPUtil.getParameter(request, prefix	+ "arr_dt", length));
			String[] mfStsCd = (JSPUtil.getParameter(request, prefix	+ "mf_sts_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pkupDate = (JSPUtil.getParameter(request, prefix	+ "pkup_date", length));
			String[] cstmsMfTpCd = (JSPUtil.getParameter(request, prefix	+ "cstms_mf_tp_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ibdTrspAcptDt = (JSPUtil.getParameter(request, prefix	+ "ibd_trsp_acpt_dt", length));
			String[] frtCltFlg = (JSPUtil.getParameter(request, prefix	+ "frt_clt_flg", length));
			String[] rnum = (JSPUtil.getParameter(request, prefix	+ "rnum", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] bkgCustTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cust_tp_cd", length));
			String[] freeTrdZnFlg = (JSPUtil.getParameter(request, prefix	+ "free_trd_zn_flg", length));
			String[] ibdTrspIssDt = (JSPUtil.getParameter(request, prefix	+ "ibd_trsp_iss_dt", length));
			String[] filer = (JSPUtil.getParameter(request, prefix	+ "filer", length));
			String[] amsFileNo = (JSPUtil.getParameter(request, prefix	+ "ams_file_no", length));
			String[] ibdTrspNo = (JSPUtil.getParameter(request, prefix	+ "ibd_trsp_no", length));
			String[] ibdTrspTpCd = (JSPUtil.getParameter(request, prefix	+ "ibd_trsp_tp_cd", length));
			String[] cstmsClrCd = (JSPUtil.getParameter(request, prefix	+ "cstms_clr_cd", length));
			String[] usaIbTrspNo = (JSPUtil.getParameter(request, prefix	+ "usa_ib_trsp_no", length));
			String[] ibdTrspXptDt = (JSPUtil.getParameter(request, prefix	+ "ibd_trsp_xpt_dt", length));
			String[] railCrrRefNo = (JSPUtil.getParameter(request, prefix	+ "rail_crr_ref_no", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] oblRdemFlg = (JSPUtil.getParameter(request, prefix	+ "obl_rdem_flg", length));
			String[] dspoCd = (JSPUtil.getParameter(request, prefix	+ "dspo_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] mblNo = (JSPUtil.getParameter(request, prefix	+ "mbl_no", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] cstmsDspoNm = (JSPUtil.getParameter(request, prefix	+ "cstms_dspo_nm", length));
			String[] blCnt = (JSPUtil.getParameter(request, prefix	+ "bl_cnt", length));
			String[] hubLocCd = (JSPUtil.getParameter(request, prefix	+ "hub_loc_cd", length));
			String[] pkupNo = (JSPUtil.getParameter(request, prefix	+ "pkup_no", length));
			String[] cntrPrtFlg = (JSPUtil.getParameter(request, prefix	+ "cntrPrtFlg", length));
			String[] master = (JSPUtil.getParameter(request, prefix	+ "master", length));
			String[] rlseEdi = (JSPUtil.getParameter(request, prefix	+ "rlse_edi", length));
			String[] sumCmQty = (JSPUtil.getParameter(request, prefix	+ "sum_cm_qty", length));
			String[] rQty = (JSPUtil.getParameter(request, prefix	+ "r_qty", length));
			String[] rlseQty = (JSPUtil.getParameter(request, prefix	+ "rlse_qty", length));
			String[] rBilling = (JSPUtil.getParameter(request, prefix	+ "r_billing", length));
			String[] feu = (JSPUtil.getParameter(request, prefix	+ "feu", length));
			String[] teu = (JSPUtil.getParameter(request, prefix	+ "teu", length));
			String[] cFlag = (JSPUtil.getParameter(request, prefix	+ "c_flag", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsaAmsReportListDetailVO();
				if (total[i] != null)
					model.setTotal(total[i]);
				if (pkupReleased[i] != null)
					model.setPkupReleased(pkupReleased[i]);
				if (ibdTrspXptAcptDt[i] != null)
					model.setIbdTrspXptAcptDt(ibdTrspXptAcptDt[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (ibdTrspArrDt[i] != null)
					model.setIbdTrspArrDt(ibdTrspArrDt[i]);
				if (ibdTrspArrAcptDt[i] != null)
					model.setIbdTrspArrAcptDt(ibdTrspArrAcptDt[i]);
				if (arrDt[i] != null)
					model.setArrDt(arrDt[i]);
				if (mfStsCd[i] != null)
					model.setMfStsCd(mfStsCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pkupDate[i] != null)
					model.setPkupDate(pkupDate[i]);
				if (cstmsMfTpCd[i] != null)
					model.setCstmsMfTpCd(cstmsMfTpCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ibdTrspAcptDt[i] != null)
					model.setIbdTrspAcptDt(ibdTrspAcptDt[i]);
				if (frtCltFlg[i] != null)
					model.setFrtCltFlg(frtCltFlg[i]);
				if (rnum[i] != null)
					model.setRnum(rnum[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (bkgCustTpCd[i] != null)
					model.setBkgCustTpCd(bkgCustTpCd[i]);
				if (freeTrdZnFlg[i] != null)
					model.setFreeTrdZnFlg(freeTrdZnFlg[i]);
				if (ibdTrspIssDt[i] != null)
					model.setIbdTrspIssDt(ibdTrspIssDt[i]);
				if (filer[i] != null)
					model.setFiler(filer[i]);
				if (amsFileNo[i] != null)
					model.setAmsFileNo(amsFileNo[i]);
				if (ibdTrspNo[i] != null)
					model.setIbdTrspNo(ibdTrspNo[i]);
				if (ibdTrspTpCd[i] != null)
					model.setIbdTrspTpCd(ibdTrspTpCd[i]);
				if (cstmsClrCd[i] != null)
					model.setCstmsClrCd(cstmsClrCd[i]);
				if (usaIbTrspNo[i] != null)
					model.setUsaIbTrspNo(usaIbTrspNo[i]);
				if (ibdTrspXptDt[i] != null)
					model.setIbdTrspXptDt(ibdTrspXptDt[i]);
				if (railCrrRefNo[i] != null)
					model.setRailCrrRefNo(railCrrRefNo[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (oblRdemFlg[i] != null)
					model.setOblRdemFlg(oblRdemFlg[i]);
				if (dspoCd[i] != null)
					model.setDspoCd(dspoCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (mblNo[i] != null)
					model.setMblNo(mblNo[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (cstmsDspoNm[i] != null)
					model.setCstmsDspoNm(cstmsDspoNm[i]);
				if (blCnt[i] != null)
					model.setBlCnt(blCnt[i]);
				if (hubLocCd[i] != null)
					model.setHubLocCd(hubLocCd[i]);
				if (pkupNo[i] != null)
					model.setPkupNo(pkupNo[i]);
				if (cntrPrtFlg[i] != null)
					model.setCntrPrtFlg(cntrPrtFlg[i]);
				if (master[i] != null)
					model.setMaster(master[i]);
				if (rlseEdi[i] != null)
					model.setRlseEdi(rlseEdi[i]);
				if (sumCmQty[i] != null)
					model.setSumCmQty(sumCmQty[i]);
				if (rQty[i] != null)
					model.setRQty(rQty[i]);
				if (rlseQty[i] != null)
					model.setRlseQty(rlseQty[i]);
				if (rBilling[i] != null)
					model.setRBilling(rBilling[i]);
				if (feu[i] != null)
					model.setFeu(feu[i]);
				if (teu[i] != null)
					model.setTeu(teu[i]);
				if (cFlag[i] != null)
					model.setCFlag(cFlag[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaAmsReportListDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaAmsReportListDetailVO[]
	 */
	public UsaAmsReportListDetailVO[] getUsaAmsReportListDetailVOs(){
		UsaAmsReportListDetailVO[] vos = (UsaAmsReportListDetailVO[])models.toArray(new UsaAmsReportListDetailVO[models.size()]);
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
		this.total = this.total.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupReleased = this.pkupReleased.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdTrspXptAcptDt = this.ibdTrspXptAcptDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdTrspArrDt = this.ibdTrspArrDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdTrspArrAcptDt = this.ibdTrspArrAcptDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrDt = this.arrDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfStsCd = this.mfStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupDate = this.pkupDate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsMfTpCd = this.cstmsMfTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdTrspAcptDt = this.ibdTrspAcptDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtCltFlg = this.frtCltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rnum = this.rnum.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustTpCd = this.bkgCustTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.freeTrdZnFlg = this.freeTrdZnFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdTrspIssDt = this.ibdTrspIssDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.filer = this.filer.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amsFileNo = this.amsFileNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdTrspNo = this.ibdTrspNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdTrspTpCd = this.ibdTrspTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsClrCd = this.cstmsClrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaIbTrspNo = this.usaIbTrspNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdTrspXptDt = this.ibdTrspXptDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railCrrRefNo = this.railCrrRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRdemFlg = this.oblRdemFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dspoCd = this.dspoCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mblNo = this.mblNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDspoNm = this.cstmsDspoNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCnt = this.blCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hubLocCd = this.hubLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupNo = this.pkupNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.master = this.master .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlseEdi = this.rlseEdi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumCmQty = this.sumCmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rQty = this.rQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlseQty = this.rlseQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rBilling = this.rBilling .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.feu = this.feu.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teu = this.teu.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cFlag = this.cFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
