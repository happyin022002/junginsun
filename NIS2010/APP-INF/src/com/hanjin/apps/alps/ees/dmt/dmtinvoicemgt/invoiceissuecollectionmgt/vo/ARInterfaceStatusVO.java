/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ARInterfaceStatusVO.java
*@FileTitle : ARInterfaceStatusVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.29
*@LastModifier : 임창빈
*@LastVersion : 1.0
* 2013.11.29 임창빈 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo;

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
 * @author 임창빈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class ARInterfaceStatusVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<ARInterfaceStatusVO> models = new ArrayList<ARInterfaceStatusVO>();

    /* Column Info */
    private String ifDt = null;

    /* Column Info */
    private String chrgOfc = null;

    /* Column Info */
    private String type = null;

    /* Column Info */
    private String blNo = null;

    /* Column Info */
    private String chgCd = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String fxFtOvrDys = null;

    /* Column Info */
    private String polCd = null;

    /* Column Info */
    private String shipperNm = null;

    /* Column Info */
    private String chrgDt = null;

    /* Column Info */
    private String vvdCd = null;

    /* Column Info */
    private String chgAmt = null;

    /* Column Info */
    private String arIfDt = null;

    /* Column Info */
    private String shipperCd = null;

    /* Column Info */
    private String notifyCd = null;

    /* Column Info */
    private String consigneeNm = null;

    /* Column Info */
    private String dmdtTrfCd = null;

    /* Column Info */
    private String payerCd = null;

    /* Column Info */
    private String ifNo = null;

    /* Column Info */
    private String subtot = null;

    /* Column Info */
    private String consigneeCd = null;

    /* Column Info */
    private String payerFlg = null;

    /* Column Info */
    private String frtTermCd = null;

    /* Column Info */
    private String ftCmncDt = null;

    /* Column Info */
    private String arIfOfcCd = null;

    /* Column Info */
    private String vvd = null;

    /* Column Info */
    private String podCd = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String bkgNo = null;

    /* Column Info */
    private String ratAsQty = null;

    /* Column Info */
    private String port = null;

    /* Column Info */
    private String currCd = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String notifyNm = null;

    /* Column Info */
    private String issDt = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String taxAmt = null;

    /* Column Info */
    private String erpIfOfcCd = null;

    /* Column Info */
    private String payerNm = null;

    /* Column Info */
    private String creOfcCd = null;

    /* Column Info */
    private String arIfNo = null;

    /* Column Info */
    private String invAmt = null;

    /* Column Info */
    private String portCd = null;

    /* Column Info */
    private String ftEndDt = null;

    /* Column Info */
    private String chgUtAmt = null;

    /* Column Info */
    private String invChgAmt = null;

    /* Column Info */
    private String dmdtInvNo = null;

    /* Column Info */
    private String chrgNm = null;

    /* Column Info */
    private String invCurrCd = null;

    /* Column Info */
    private String ioBndCd = null;

    /* Column Info */
    private String arOfcCd = null;

    /* Column Info */
    private String arIfUsrId = null;

    /* Column Info */
    private String invNo = null;

    /* Column Info */
    private String ofcCd = null;

    /* Column Info */
    private String cntrNo = null;

    /* Column Info */
    private String invPayOfcCd = null;

    /* Column Info */
    private String invPayDt = null;

    /* Column Info */
    private String dmdtOfcCd = null;

    /* Column Info */
    private String dmdtInvTpCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public ARInterfaceStatusVO() {
    }

    public ARInterfaceStatusVO(String ibflag, String pagerows, String ifDt, String chrgOfc, String type, String blNo, String chgCd, String polCd, String shipperNm, String chrgDt, String vvdCd, String chgAmt, String shipperCd, String arIfDt, String consigneeNm, String notifyCd, String dmdtTrfCd, String payerCd, String subtot, String ifNo, String consigneeCd, String payerFlg, String frtTermCd, String arIfOfcCd, String vvd, String podCd, String creUsrId, String bkgNo, String ratAsQty, String port, String currCd, String creDt, String notifyNm, String issDt, String taxAmt, String erpIfOfcCd, String payerNm, String creOfcCd, String arIfNo, String invAmt, String portCd, String chgUtAmt, String invChgAmt, String dmdtInvNo, String chrgNm, String invCurrCd, String ioBndCd, String arOfcCd, String invNo, String arIfUsrId, String ofcCd, String cntrNo, String ftCmncDt, String ftEndDt, String fxFtOvrDys, String invPayOfcCd, String invPayDt, String dmdtOfcCd, String dmdtInvTpCd) {
        this.ifDt = ifDt;
        this.chrgOfc = chrgOfc;
        this.type = type;
        this.blNo = blNo;
        this.chgCd = chgCd;
        this.pagerows = pagerows;
        this.fxFtOvrDys = fxFtOvrDys;
        this.polCd = polCd;
        this.shipperNm = shipperNm;
        this.chrgDt = chrgDt;
        this.vvdCd = vvdCd;
        this.chgAmt = chgAmt;
        this.arIfDt = arIfDt;
        this.shipperCd = shipperCd;
        this.notifyCd = notifyCd;
        this.consigneeNm = consigneeNm;
        this.dmdtTrfCd = dmdtTrfCd;
        this.payerCd = payerCd;
        this.ifNo = ifNo;
        this.subtot = subtot;
        this.consigneeCd = consigneeCd;
        this.payerFlg = payerFlg;
        this.frtTermCd = frtTermCd;
        this.ftCmncDt = ftCmncDt;
        this.arIfOfcCd = arIfOfcCd;
        this.vvd = vvd;
        this.podCd = podCd;
        this.creUsrId = creUsrId;
        this.bkgNo = bkgNo;
        this.ratAsQty = ratAsQty;
        this.port = port;
        this.currCd = currCd;
        this.creDt = creDt;
        this.notifyNm = notifyNm;
        this.issDt = issDt;
        this.ibflag = ibflag;
        this.taxAmt = taxAmt;
        this.erpIfOfcCd = erpIfOfcCd;
        this.payerNm = payerNm;
        this.creOfcCd = creOfcCd;
        this.arIfNo = arIfNo;
        this.invAmt = invAmt;
        this.portCd = portCd;
        this.ftEndDt = ftEndDt;
        this.chgUtAmt = chgUtAmt;
        this.invChgAmt = invChgAmt;
        this.dmdtInvNo = dmdtInvNo;
        this.chrgNm = chrgNm;
        this.invCurrCd = invCurrCd;
        this.ioBndCd = ioBndCd;
        this.arOfcCd = arOfcCd;
        this.arIfUsrId = arIfUsrId;
        this.invNo = invNo;
        this.ofcCd = ofcCd;
        this.cntrNo = cntrNo;
        this.invPayOfcCd = invPayOfcCd;
        this.invPayDt = invPayDt;
        this.dmdtOfcCd = dmdtOfcCd;
        this.dmdtInvTpCd = dmdtInvTpCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("if_dt", getIfDt());
        this.hashColumns.put("chrg_ofc", getChrgOfc());
        this.hashColumns.put("type", getType());
        this.hashColumns.put("bl_no", getBlNo());
        this.hashColumns.put("chg_cd", getChgCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("fx_ft_ovr_dys", getFxFtOvrDys());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("shipper_nm", getShipperNm());
        this.hashColumns.put("chrg_dt", getChrgDt());
        this.hashColumns.put("vvd_cd", getVvdCd());
        this.hashColumns.put("chg_amt", getChgAmt());
        this.hashColumns.put("ar_if_dt", getArIfDt());
        this.hashColumns.put("shipper_cd", getShipperCd());
        this.hashColumns.put("notify_cd", getNotifyCd());
        this.hashColumns.put("consignee_nm", getConsigneeNm());
        this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
        this.hashColumns.put("payer_cd", getPayerCd());
        this.hashColumns.put("if_no", getIfNo());
        this.hashColumns.put("subtot", getSubtot());
        this.hashColumns.put("consignee_cd", getConsigneeCd());
        this.hashColumns.put("payer_flg", getPayerFlg());
        this.hashColumns.put("frt_term_cd", getFrtTermCd());
        this.hashColumns.put("ft_cmnc_dt", getFtCmncDt());
        this.hashColumns.put("ar_if_ofc_cd", getArIfOfcCd());
        this.hashColumns.put("vvd", getVvd());
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("rat_as_qty", getRatAsQty());
        this.hashColumns.put("port", getPort());
        this.hashColumns.put("curr_cd", getCurrCd());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("notify_nm", getNotifyNm());
        this.hashColumns.put("iss_dt", getIssDt());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("tax_amt", getTaxAmt());
        this.hashColumns.put("erp_if_ofc_cd", getErpIfOfcCd());
        this.hashColumns.put("payer_nm", getPayerNm());
        this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
        this.hashColumns.put("ar_if_no", getArIfNo());
        this.hashColumns.put("inv_amt", getInvAmt());
        this.hashColumns.put("port_cd", getPortCd());
        this.hashColumns.put("ft_end_dt", getFtEndDt());
        this.hashColumns.put("chg_ut_amt", getChgUtAmt());
        this.hashColumns.put("inv_chg_amt", getInvChgAmt());
        this.hashColumns.put("dmdt_inv_no", getDmdtInvNo());
        this.hashColumns.put("chrg_nm", getChrgNm());
        this.hashColumns.put("inv_curr_cd", getInvCurrCd());
        this.hashColumns.put("io_bnd_cd", getIoBndCd());
        this.hashColumns.put("ar_ofc_cd", getArOfcCd());
        this.hashColumns.put("ar_if_usr_id", getArIfUsrId());
        this.hashColumns.put("inv_no", getInvNo());
        this.hashColumns.put("ofc_cd", getOfcCd());
        this.hashColumns.put("cntr_no", getCntrNo());
        this.hashColumns.put("inv_pay_ofc_cd", getInvPayOfcCd());
        this.hashColumns.put("inv_pay_dt", getInvPayDt());
        this.hashColumns.put("dmdt_ofc_cd", getDmdtOfcCd());
        this.hashColumns.put("dmdt_inv_tp_cd", getDmdtInvTpCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("if_dt", "ifDt");
        this.hashFields.put("chrg_ofc", "chrgOfc");
        this.hashFields.put("type", "type");
        this.hashFields.put("bl_no", "blNo");
        this.hashFields.put("chg_cd", "chgCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("fx_ft_ovr_dys", "fxFtOvrDys");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("shipper_nm", "shipperNm");
        this.hashFields.put("chrg_dt", "chrgDt");
        this.hashFields.put("vvd_cd", "vvdCd");
        this.hashFields.put("chg_amt", "chgAmt");
        this.hashFields.put("ar_if_dt", "arIfDt");
        this.hashFields.put("shipper_cd", "shipperCd");
        this.hashFields.put("notify_cd", "notifyCd");
        this.hashFields.put("consignee_nm", "consigneeNm");
        this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
        this.hashFields.put("payer_cd", "payerCd");
        this.hashFields.put("if_no", "ifNo");
        this.hashFields.put("subtot", "subtot");
        this.hashFields.put("consignee_cd", "consigneeCd");
        this.hashFields.put("payer_flg", "payerFlg");
        this.hashFields.put("frt_term_cd", "frtTermCd");
        this.hashFields.put("ft_cmnc_dt", "ftCmncDt");
        this.hashFields.put("ar_if_ofc_cd", "arIfOfcCd");
        this.hashFields.put("vvd", "vvd");
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("rat_as_qty", "ratAsQty");
        this.hashFields.put("port", "port");
        this.hashFields.put("curr_cd", "currCd");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("notify_nm", "notifyNm");
        this.hashFields.put("iss_dt", "issDt");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("tax_amt", "taxAmt");
        this.hashFields.put("erp_if_ofc_cd", "erpIfOfcCd");
        this.hashFields.put("payer_nm", "payerNm");
        this.hashFields.put("cre_ofc_cd", "creOfcCd");
        this.hashFields.put("ar_if_no", "arIfNo");
        this.hashFields.put("inv_amt", "invAmt");
        this.hashFields.put("port_cd", "portCd");
        this.hashFields.put("ft_end_dt", "ftEndDt");
        this.hashFields.put("chg_ut_amt", "chgUtAmt");
        this.hashFields.put("inv_chg_amt", "invChgAmt");
        this.hashFields.put("dmdt_inv_no", "dmdtInvNo");
        this.hashFields.put("chrg_nm", "chrgNm");
        this.hashFields.put("inv_curr_cd", "invCurrCd");
        this.hashFields.put("io_bnd_cd", "ioBndCd");
        this.hashFields.put("ar_ofc_cd", "arOfcCd");
        this.hashFields.put("ar_if_usr_id", "arIfUsrId");
        this.hashFields.put("inv_no", "invNo");
        this.hashFields.put("ofc_cd", "ofcCd");
        this.hashFields.put("cntr_no", "cntrNo");
        this.hashFields.put("inv_pay_ofc_cd", "invPayOfcCd");
        this.hashFields.put("inv_pay_dt", "invPayDt");
        this.hashFields.put("dmdt_ofc_cd", "dmdtOfcCd");
        this.hashFields.put("dmdt_inv_tp_cd", "dmdtInvTpCd");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return ifDt
	 */
    public String getIfDt() {
        return this.ifDt;
    }

    /**
	 * Column Info
	 * @return chrgOfc
	 */
    public String getChrgOfc() {
        return this.chrgOfc;
    }

    /**
	 * Column Info
	 * @return type
	 */
    public String getType() {
        return this.type;
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
	 * @return chgCd
	 */
    public String getChgCd() {
        return this.chgCd;
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
	 * @return fxFtOvrDys
	 */
    public String getFxFtOvrDys() {
        return this.fxFtOvrDys;
    }

    /**
	 * Column Info
	 * @return polCd
	 */
    public String getPolCd() {
        return this.polCd;
    }

    /**
	 * Column Info
	 * @return shipperNm
	 */
    public String getShipperNm() {
        return this.shipperNm;
    }

    /**
	 * Column Info
	 * @return chrgDt
	 */
    public String getChrgDt() {
        return this.chrgDt;
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
	 * @return chgAmt
	 */
    public String getChgAmt() {
        return this.chgAmt;
    }

    /**
	 * Column Info
	 * @return arIfDt
	 */
    public String getArIfDt() {
        return this.arIfDt;
    }

    /**
	 * Column Info
	 * @return shipperCd
	 */
    public String getShipperCd() {
        return this.shipperCd;
    }

    /**
	 * Column Info
	 * @return notifyCd
	 */
    public String getNotifyCd() {
        return this.notifyCd;
    }

    /**
	 * Column Info
	 * @return consigneeNm
	 */
    public String getConsigneeNm() {
        return this.consigneeNm;
    }

    /**
	 * Column Info
	 * @return dmdtTrfCd
	 */
    public String getDmdtTrfCd() {
        return this.dmdtTrfCd;
    }

    /**
	 * Column Info
	 * @return payerCd
	 */
    public String getPayerCd() {
        return this.payerCd;
    }

    /**
	 * Column Info
	 * @return ifNo
	 */
    public String getIfNo() {
        return this.ifNo;
    }

    /**
	 * Column Info
	 * @return subtot
	 */
    public String getSubtot() {
        return this.subtot;
    }

    /**
	 * Column Info
	 * @return consigneeCd
	 */
    public String getConsigneeCd() {
        return this.consigneeCd;
    }

    /**
	 * Column Info
	 * @return payerFlg
	 */
    public String getPayerFlg() {
        return this.payerFlg;
    }

    /**
	 * Column Info
	 * @return frtTermCd
	 */
    public String getFrtTermCd() {
        return this.frtTermCd;
    }

    /**
	 * Column Info
	 * @return ftCmncDt
	 */
    public String getFtCmncDt() {
        return this.ftCmncDt;
    }

    /**
	 * Column Info
	 * @return arIfOfcCd
	 */
    public String getArIfOfcCd() {
        return this.arIfOfcCd;
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
	 * @return creUsrId
	 */
    public String getCreUsrId() {
        return this.creUsrId;
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
	 * @return ratAsQty
	 */
    public String getRatAsQty() {
        return this.ratAsQty;
    }

    /**
	 * Column Info
	 * @return port
	 */
    public String getPort() {
        return this.port;
    }

    /**
	 * Column Info
	 * @return currCd
	 */
    public String getCurrCd() {
        return this.currCd;
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
	 * @return notifyNm
	 */
    public String getNotifyNm() {
        return this.notifyNm;
    }

    /**
	 * Column Info
	 * @return issDt
	 */
    public String getIssDt() {
        return this.issDt;
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
	 * @return taxAmt
	 */
    public String getTaxAmt() {
        return this.taxAmt;
    }

    /**
	 * Column Info
	 * @return erpIfOfcCd
	 */
    public String getErpIfOfcCd() {
        return this.erpIfOfcCd;
    }

    /**
	 * Column Info
	 * @return payerNm
	 */
    public String getPayerNm() {
        return this.payerNm;
    }

    /**
	 * Column Info
	 * @return creOfcCd
	 */
    public String getCreOfcCd() {
        return this.creOfcCd;
    }

    /**
	 * Column Info
	 * @return arIfNo
	 */
    public String getArIfNo() {
        return this.arIfNo;
    }

    /**
	 * Column Info
	 * @return invAmt
	 */
    public String getInvAmt() {
        return this.invAmt;
    }

    /**
	 * Column Info
	 * @return portCd
	 */
    public String getPortCd() {
        return this.portCd;
    }

    /**
	 * Column Info
	 * @return ftEndDt
	 */
    public String getFtEndDt() {
        return this.ftEndDt;
    }

    /**
	 * Column Info
	 * @return chgUtAmt
	 */
    public String getChgUtAmt() {
        return this.chgUtAmt;
    }

    /**
	 * Column Info
	 * @return invChgAmt
	 */
    public String getInvChgAmt() {
        return this.invChgAmt;
    }

    /**
	 * Column Info
	 * @return dmdtInvNo
	 */
    public String getDmdtInvNo() {
        return this.dmdtInvNo;
    }

    /**
	 * Column Info
	 * @return chrgNm
	 */
    public String getChrgNm() {
        return this.chrgNm;
    }

    /**
	 * Column Info
	 * @return invCurrCd
	 */
    public String getInvCurrCd() {
        return this.invCurrCd;
    }

    /**
	 * Column Info
	 * @return ioBndCd
	 */
    public String getIoBndCd() {
        return this.ioBndCd;
    }

    /**
	 * Column Info
	 * @return arOfcCd
	 */
    public String getArOfcCd() {
        return this.arOfcCd;
    }

    /**
	 * Column Info
	 * @return arIfUsrId
	 */
    public String getArIfUsrId() {
        return this.arIfUsrId;
    }

    /**
	 * Column Info
	 * @return invNo
	 */
    public String getInvNo() {
        return this.invNo;
    }

    /**
	 * Column Info
	 * @return ofcCd
	 */
    public String getOfcCd() {
        return this.ofcCd;
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
	 * @return invPayOfcCd
	 */
    public String getInvPayOfcCd() {
        return this.invPayOfcCd;
    }

    /**
	 * Column Info
	 * @return invPayDt
	 */
    public String getInvPayDt() {
        return this.invPayDt;
    }

    /**
	 * Column Info
	 * @param ifDt
	 */
    public void setIfDt(String ifDt) {
        this.ifDt = ifDt;
    }

    /**
	 * Column Info
	 * @param chrgOfc
	 */
    public void setChrgOfc(String chrgOfc) {
        this.chrgOfc = chrgOfc;
    }

    /**
	 * Column Info
	 * @param type
	 */
    public void setType(String type) {
        this.type = type;
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
	 * @param chgCd
	 */
    public void setChgCd(String chgCd) {
        this.chgCd = chgCd;
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
	 * @param fxFtOvrDys
	 */
    public void setFxFtOvrDys(String fxFtOvrDys) {
        this.fxFtOvrDys = fxFtOvrDys;
    }

    /**
	 * Column Info
	 * @param polCd
	 */
    public void setPolCd(String polCd) {
        this.polCd = polCd;
    }

    /**
	 * Column Info
	 * @param shipperNm
	 */
    public void setShipperNm(String shipperNm) {
        this.shipperNm = shipperNm;
    }

    /**
	 * Column Info
	 * @param chrgDt
	 */
    public void setChrgDt(String chrgDt) {
        this.chrgDt = chrgDt;
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
	 * @param chgAmt
	 */
    public void setChgAmt(String chgAmt) {
        this.chgAmt = chgAmt;
    }

    /**
	 * Column Info
	 * @param arIfDt
	 */
    public void setArIfDt(String arIfDt) {
        this.arIfDt = arIfDt;
    }

    /**
	 * Column Info
	 * @param shipperCd
	 */
    public void setShipperCd(String shipperCd) {
        this.shipperCd = shipperCd;
    }

    /**
	 * Column Info
	 * @param notifyCd
	 */
    public void setNotifyCd(String notifyCd) {
        this.notifyCd = notifyCd;
    }

    /**
	 * Column Info
	 * @param consigneeNm
	 */
    public void setConsigneeNm(String consigneeNm) {
        this.consigneeNm = consigneeNm;
    }

    /**
	 * Column Info
	 * @param dmdtTrfCd
	 */
    public void setDmdtTrfCd(String dmdtTrfCd) {
        this.dmdtTrfCd = dmdtTrfCd;
    }

    /**
	 * Column Info
	 * @param payerCd
	 */
    public void setPayerCd(String payerCd) {
        this.payerCd = payerCd;
    }

    /**
	 * Column Info
	 * @param ifNo
	 */
    public void setIfNo(String ifNo) {
        this.ifNo = ifNo;
    }

    /**
	 * Column Info
	 * @param subtot
	 */
    public void setSubtot(String subtot) {
        this.subtot = subtot;
    }

    /**
	 * Column Info
	 * @param consigneeCd
	 */
    public void setConsigneeCd(String consigneeCd) {
        this.consigneeCd = consigneeCd;
    }

    /**
	 * Column Info
	 * @param payerFlg
	 */
    public void setPayerFlg(String payerFlg) {
        this.payerFlg = payerFlg;
    }

    /**
	 * Column Info
	 * @param frtTermCd
	 */
    public void setFrtTermCd(String frtTermCd) {
        this.frtTermCd = frtTermCd;
    }

    /**
	 * Column Info
	 * @param ftCmncDt
	 */
    public void setFtCmncDt(String ftCmncDt) {
        this.ftCmncDt = ftCmncDt;
    }

    /**
	 * Column Info
	 * @param arIfOfcCd
	 */
    public void setArIfOfcCd(String arIfOfcCd) {
        this.arIfOfcCd = arIfOfcCd;
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
	 * @param creUsrId
	 */
    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
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
	 * @param ratAsQty
	 */
    public void setRatAsQty(String ratAsQty) {
        this.ratAsQty = ratAsQty;
    }

    /**
	 * Column Info
	 * @param port
	 */
    public void setPort(String port) {
        this.port = port;
    }

    /**
	 * Column Info
	 * @param currCd
	 */
    public void setCurrCd(String currCd) {
        this.currCd = currCd;
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
	 * @param notifyNm
	 */
    public void setNotifyNm(String notifyNm) {
        this.notifyNm = notifyNm;
    }

    /**
	 * Column Info
	 * @param issDt
	 */
    public void setIssDt(String issDt) {
        this.issDt = issDt;
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
	 * @param taxAmt
	 */
    public void setTaxAmt(String taxAmt) {
        this.taxAmt = taxAmt;
    }

    /**
	 * Column Info
	 * @param erpIfOfcCd
	 */
    public void setErpIfOfcCd(String erpIfOfcCd) {
        this.erpIfOfcCd = erpIfOfcCd;
    }

    /**
	 * Column Info
	 * @param payerNm
	 */
    public void setPayerNm(String payerNm) {
        this.payerNm = payerNm;
    }

    /**
	 * Column Info
	 * @param creOfcCd
	 */
    public void setCreOfcCd(String creOfcCd) {
        this.creOfcCd = creOfcCd;
    }

    /**
	 * Column Info
	 * @param arIfNo
	 */
    public void setArIfNo(String arIfNo) {
        this.arIfNo = arIfNo;
    }

    /**
	 * Column Info
	 * @param invAmt
	 */
    public void setInvAmt(String invAmt) {
        this.invAmt = invAmt;
    }

    /**
	 * Column Info
	 * @param portCd
	 */
    public void setPortCd(String portCd) {
        this.portCd = portCd;
    }

    /**
	 * Column Info
	 * @param ftEndDt
	 */
    public void setFtEndDt(String ftEndDt) {
        this.ftEndDt = ftEndDt;
    }

    /**
	 * Column Info
	 * @param chgUtAmt
	 */
    public void setChgUtAmt(String chgUtAmt) {
        this.chgUtAmt = chgUtAmt;
    }

    /**
	 * Column Info
	 * @param invChgAmt
	 */
    public void setInvChgAmt(String invChgAmt) {
        this.invChgAmt = invChgAmt;
    }

    /**
	 * Column Info
	 * @param dmdtInvNo
	 */
    public void setDmdtInvNo(String dmdtInvNo) {
        this.dmdtInvNo = dmdtInvNo;
    }

    /**
	 * Column Info
	 * @param chrgNm
	 */
    public void setChrgNm(String chrgNm) {
        this.chrgNm = chrgNm;
    }

    /**
	 * Column Info
	 * @param invCurrCd
	 */
    public void setInvCurrCd(String invCurrCd) {
        this.invCurrCd = invCurrCd;
    }

    /**
	 * Column Info
	 * @param ioBndCd
	 */
    public void setIoBndCd(String ioBndCd) {
        this.ioBndCd = ioBndCd;
    }

    /**
	 * Column Info
	 * @param arOfcCd
	 */
    public void setArOfcCd(String arOfcCd) {
        this.arOfcCd = arOfcCd;
    }

    /**
	 * Column Info
	 * @param arIfUsrId
	 */
    public void setArIfUsrId(String arIfUsrId) {
        this.arIfUsrId = arIfUsrId;
    }

    /**
	 * Column Info
	 * @param invNo
	 */
    public void setInvNo(String invNo) {
        this.invNo = invNo;
    }

    /**
	 * Column Info
	 * @param ofcCd
	 */
    public void setOfcCd(String ofcCd) {
        this.ofcCd = ofcCd;
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
	 * @param invPayOfcCd
	 */
    public void setInvPayOfcCd(String invPayOfcCd) {
        this.invPayOfcCd = invPayOfcCd;
    }

    /**
	 * Column Info
	 * @param invPayDt
	 */
    public void setInvPayDt(String invPayDt) {
        this.invPayDt = invPayDt;
    }

    public String getDmdtOfcCd() {
        return dmdtOfcCd;
    }

    public void setDmdtOfcCd(String dmdtOfcCd) {
        this.dmdtOfcCd = dmdtOfcCd;
    }

    public void setDmdtInvTpCd(String dmdtInvTpCd) {
        this.dmdtInvTpCd = dmdtInvTpCd;
    }

    public String getDmdtInvTpCd() {
        return this.dmdtInvTpCd;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        fromRequest(request, "");
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request, String prefix) {
        setIfDt(JSPUtil.getParameter(request, prefix + "if_dt", ""));
        setChrgOfc(JSPUtil.getParameter(request, prefix + "chrg_ofc", ""));
        setType(JSPUtil.getParameter(request, prefix + "type", ""));
        setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
        setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setFxFtOvrDys(JSPUtil.getParameter(request, prefix + "fx_ft_ovr_dys", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setShipperNm(JSPUtil.getParameter(request, prefix + "shipper_nm", ""));
        setChrgDt(JSPUtil.getParameter(request, prefix + "chrg_dt", ""));
        setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
        setChgAmt(JSPUtil.getParameter(request, prefix + "chg_amt", ""));
        setArIfDt(JSPUtil.getParameter(request, prefix + "ar_if_dt", ""));
        setShipperCd(JSPUtil.getParameter(request, prefix + "shipper_cd", ""));
        setNotifyCd(JSPUtil.getParameter(request, prefix + "notify_cd", ""));
        setConsigneeNm(JSPUtil.getParameter(request, prefix + "consignee_nm", ""));
        setDmdtTrfCd(JSPUtil.getParameter(request, prefix + "dmdt_trf_cd", ""));
        setPayerCd(JSPUtil.getParameter(request, prefix + "payer_cd", ""));
        setIfNo(JSPUtil.getParameter(request, prefix + "if_no", ""));
        setSubtot(JSPUtil.getParameter(request, prefix + "subtot", ""));
        setConsigneeCd(JSPUtil.getParameter(request, prefix + "consignee_cd", ""));
        setPayerFlg(JSPUtil.getParameter(request, prefix + "payer_flg", ""));
        setFrtTermCd(JSPUtil.getParameter(request, prefix + "frt_term_cd", ""));
        setFtCmncDt(JSPUtil.getParameter(request, prefix + "ft_cmnc_dt", ""));
        setArIfOfcCd(JSPUtil.getParameter(request, prefix + "ar_if_ofc_cd", ""));
        setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
        setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setRatAsQty(JSPUtil.getParameter(request, prefix + "rat_as_qty", ""));
        setPort(JSPUtil.getParameter(request, prefix + "port", ""));
        setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setNotifyNm(JSPUtil.getParameter(request, prefix + "notify_nm", ""));
        setIssDt(JSPUtil.getParameter(request, prefix + "iss_dt", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setTaxAmt(JSPUtil.getParameter(request, prefix + "tax_amt", ""));
        setErpIfOfcCd(JSPUtil.getParameter(request, prefix + "erp_if_ofc_cd", ""));
        setPayerNm(JSPUtil.getParameter(request, prefix + "payer_nm", ""));
        setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
        setArIfNo(JSPUtil.getParameter(request, prefix + "ar_if_no", ""));
        setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
        setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
        setFtEndDt(JSPUtil.getParameter(request, prefix + "ft_end_dt", ""));
        setChgUtAmt(JSPUtil.getParameter(request, prefix + "chg_ut_amt", ""));
        setInvChgAmt(JSPUtil.getParameter(request, prefix + "inv_chg_amt", ""));
        setDmdtInvNo(JSPUtil.getParameter(request, prefix + "dmdt_inv_no", ""));
        setChrgNm(JSPUtil.getParameter(request, prefix + "chrg_nm", ""));
        setInvCurrCd(JSPUtil.getParameter(request, prefix + "inv_curr_cd", ""));
        setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
        setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
        setArIfUsrId(JSPUtil.getParameter(request, prefix + "ar_if_usr_id", ""));
        setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
        setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
        setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
        setInvPayOfcCd(JSPUtil.getParameter(request, prefix + "inv_pay_ofc_cd", ""));
        setInvPayDt(JSPUtil.getParameter(request, prefix + "inv_pay_dt", ""));
        setDmdtOfcCd(JSPUtil.getParameter(request, prefix + "dmdt_ofc_cd", ""));
        setDmdtInvTpCd(JSPUtil.getParameter(request, prefix + "dmdt_inv_tp_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ARInterfaceStatusVO[]
	 */
    public ARInterfaceStatusVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ARInterfaceStatusVO[]
	 */
    public ARInterfaceStatusVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        ARInterfaceStatusVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ifDt = (JSPUtil.getParameter(request, prefix + "if_dt", length));
            String[] chrgOfc = (JSPUtil.getParameter(request, prefix + "chrg_ofc", length));
            String[] type = (JSPUtil.getParameter(request, prefix + "type", length));
            String[] blNo = (JSPUtil.getParameter(request, prefix + "bl_no", length));
            String[] chgCd = (JSPUtil.getParameter(request, prefix + "chg_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] fxFtOvrDys = (JSPUtil.getParameter(request, prefix + "fx_ft_ovr_dys", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] shipperNm = (JSPUtil.getParameter(request, prefix + "shipper_nm", length));
            String[] chrgDt = (JSPUtil.getParameter(request, prefix + "chrg_dt", length));
            String[] vvdCd = (JSPUtil.getParameter(request, prefix + "vvd_cd", length));
            String[] chgAmt = (JSPUtil.getParameter(request, prefix + "chg_amt", length));
            String[] arIfDt = (JSPUtil.getParameter(request, prefix + "ar_if_dt", length));
            String[] shipperCd = (JSPUtil.getParameter(request, prefix + "shipper_cd", length));
            String[] notifyCd = (JSPUtil.getParameter(request, prefix + "notify_cd", length));
            String[] consigneeNm = (JSPUtil.getParameter(request, prefix + "consignee_nm", length));
            String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix + "dmdt_trf_cd", length));
            String[] payerCd = (JSPUtil.getParameter(request, prefix + "payer_cd", length));
            String[] ifNo = (JSPUtil.getParameter(request, prefix + "if_no", length));
            String[] subtot = (JSPUtil.getParameter(request, prefix + "subtot", length));
            String[] consigneeCd = (JSPUtil.getParameter(request, prefix + "consignee_cd", length));
            String[] payerFlg = (JSPUtil.getParameter(request, prefix + "payer_flg", length));
            String[] frtTermCd = (JSPUtil.getParameter(request, prefix + "frt_term_cd", length));
            String[] ftCmncDt = (JSPUtil.getParameter(request, prefix + "ft_cmnc_dt", length));
            String[] arIfOfcCd = (JSPUtil.getParameter(request, prefix + "ar_if_ofc_cd", length));
            String[] vvd = (JSPUtil.getParameter(request, prefix + "vvd", length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] ratAsQty = (JSPUtil.getParameter(request, prefix + "rat_as_qty", length));
            String[] port = (JSPUtil.getParameter(request, prefix + "port", length));
            String[] currCd = (JSPUtil.getParameter(request, prefix + "curr_cd", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] notifyNm = (JSPUtil.getParameter(request, prefix + "notify_nm", length));
            String[] issDt = (JSPUtil.getParameter(request, prefix + "iss_dt", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] taxAmt = (JSPUtil.getParameter(request, prefix + "tax_amt", length));
            String[] erpIfOfcCd = (JSPUtil.getParameter(request, prefix + "erp_if_ofc_cd", length));
            String[] payerNm = (JSPUtil.getParameter(request, prefix + "payer_nm", length));
            String[] creOfcCd = (JSPUtil.getParameter(request, prefix + "cre_ofc_cd", length));
            String[] arIfNo = (JSPUtil.getParameter(request, prefix + "ar_if_no", length));
            String[] invAmt = (JSPUtil.getParameter(request, prefix + "inv_amt", length));
            String[] portCd = (JSPUtil.getParameter(request, prefix + "port_cd", length));
            String[] ftEndDt = (JSPUtil.getParameter(request, prefix + "ft_end_dt", length));
            String[] chgUtAmt = (JSPUtil.getParameter(request, prefix + "chg_ut_amt", length));
            String[] invChgAmt = (JSPUtil.getParameter(request, prefix + "inv_chg_amt", length));
            String[] dmdtInvNo = (JSPUtil.getParameter(request, prefix + "dmdt_inv_no", length));
            String[] chrgNm = (JSPUtil.getParameter(request, prefix + "chrg_nm", length));
            String[] invCurrCd = (JSPUtil.getParameter(request, prefix + "inv_curr_cd", length));
            String[] ioBndCd = (JSPUtil.getParameter(request, prefix + "io_bnd_cd", length));
            String[] arOfcCd = (JSPUtil.getParameter(request, prefix + "ar_ofc_cd", length));
            String[] arIfUsrId = (JSPUtil.getParameter(request, prefix + "ar_if_usr_id", length));
            String[] invNo = (JSPUtil.getParameter(request, prefix + "inv_no", length));
            String[] ofcCd = (JSPUtil.getParameter(request, prefix + "ofc_cd", length));
            String[] cntrNo = (JSPUtil.getParameter(request, prefix + "cntr_no", length));
            String[] invPayOfcCd = (JSPUtil.getParameter(request, prefix + "inv_pay_ofc_cd", length));
            String[] invPayDt = (JSPUtil.getParameter(request, prefix + "inv_pay_dt", length));
            String[] dmdtOfcCd = (JSPUtil.getParameter(request, prefix + "dmdt_ofc_cd", length));
            String[] dmdtInvTpCd = (JSPUtil.getParameter(request, prefix + "dmdt_inv_tp_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new ARInterfaceStatusVO();
                if (ifDt[i] != null)
                    model.setIfDt(ifDt[i]);
                if (chrgOfc[i] != null)
                    model.setChrgOfc(chrgOfc[i]);
                if (type[i] != null)
                    model.setType(type[i]);
                if (blNo[i] != null)
                    model.setBlNo(blNo[i]);
                if (chgCd[i] != null)
                    model.setChgCd(chgCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (fxFtOvrDys[i] != null)
                    model.setFxFtOvrDys(fxFtOvrDys[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (shipperNm[i] != null)
                    model.setShipperNm(shipperNm[i]);
                if (chrgDt[i] != null)
                    model.setChrgDt(chrgDt[i]);
                if (vvdCd[i] != null)
                    model.setVvdCd(vvdCd[i]);
                if (chgAmt[i] != null)
                    model.setChgAmt(chgAmt[i]);
                if (arIfDt[i] != null)
                    model.setArIfDt(arIfDt[i]);
                if (shipperCd[i] != null)
                    model.setShipperCd(shipperCd[i]);
                if (notifyCd[i] != null)
                    model.setNotifyCd(notifyCd[i]);
                if (consigneeNm[i] != null)
                    model.setConsigneeNm(consigneeNm[i]);
                if (dmdtTrfCd[i] != null)
                    model.setDmdtTrfCd(dmdtTrfCd[i]);
                if (payerCd[i] != null)
                    model.setPayerCd(payerCd[i]);
                if (ifNo[i] != null)
                    model.setIfNo(ifNo[i]);
                if (subtot[i] != null)
                    model.setSubtot(subtot[i]);
                if (consigneeCd[i] != null)
                    model.setConsigneeCd(consigneeCd[i]);
                if (payerFlg[i] != null)
                    model.setPayerFlg(payerFlg[i]);
                if (frtTermCd[i] != null)
                    model.setFrtTermCd(frtTermCd[i]);
                if (ftCmncDt[i] != null)
                    model.setFtCmncDt(ftCmncDt[i]);
                if (arIfOfcCd[i] != null)
                    model.setArIfOfcCd(arIfOfcCd[i]);
                if (vvd[i] != null)
                    model.setVvd(vvd[i]);
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (ratAsQty[i] != null)
                    model.setRatAsQty(ratAsQty[i]);
                if (port[i] != null)
                    model.setPort(port[i]);
                if (currCd[i] != null)
                    model.setCurrCd(currCd[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (notifyNm[i] != null)
                    model.setNotifyNm(notifyNm[i]);
                if (issDt[i] != null)
                    model.setIssDt(issDt[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (taxAmt[i] != null)
                    model.setTaxAmt(taxAmt[i]);
                if (erpIfOfcCd[i] != null)
                    model.setErpIfOfcCd(erpIfOfcCd[i]);
                if (payerNm[i] != null)
                    model.setPayerNm(payerNm[i]);
                if (creOfcCd[i] != null)
                    model.setCreOfcCd(creOfcCd[i]);
                if (arIfNo[i] != null)
                    model.setArIfNo(arIfNo[i]);
                if (invAmt[i] != null)
                    model.setInvAmt(invAmt[i]);
                if (portCd[i] != null)
                    model.setPortCd(portCd[i]);
                if (ftEndDt[i] != null)
                    model.setFtEndDt(ftEndDt[i]);
                if (chgUtAmt[i] != null)
                    model.setChgUtAmt(chgUtAmt[i]);
                if (invChgAmt[i] != null)
                    model.setInvChgAmt(invChgAmt[i]);
                if (dmdtInvNo[i] != null)
                    model.setDmdtInvNo(dmdtInvNo[i]);
                if (chrgNm[i] != null)
                    model.setChrgNm(chrgNm[i]);
                if (invCurrCd[i] != null)
                    model.setInvCurrCd(invCurrCd[i]);
                if (ioBndCd[i] != null)
                    model.setIoBndCd(ioBndCd[i]);
                if (arOfcCd[i] != null)
                    model.setArOfcCd(arOfcCd[i]);
                if (arIfUsrId[i] != null)
                    model.setArIfUsrId(arIfUsrId[i]);
                if (invNo[i] != null)
                    model.setInvNo(invNo[i]);
                if (ofcCd[i] != null)
                    model.setOfcCd(ofcCd[i]);
                if (cntrNo[i] != null)
                    model.setCntrNo(cntrNo[i]);
                if (invPayOfcCd[i] != null)
                    model.setInvPayOfcCd(invPayOfcCd[i]);
                if (invPayDt[i] != null)
                    model.setInvPayDt(invPayDt[i]);
                if (dmdtOfcCd[i] != null)
                    model.setDmdtOfcCd(dmdtOfcCd[i]);
                if (dmdtInvTpCd[i] != null) 
		    		model.setDmdtInvTpCd(dmdtInvTpCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getARInterfaceStatusVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return ARInterfaceStatusVO[]
	 */
    public ARInterfaceStatusVO[] getARInterfaceStatusVOs() {
        ARInterfaceStatusVO[] vos = (ARInterfaceStatusVO[]) models.toArray(new ARInterfaceStatusVO[models.size()]);
        return vos;
    }

    /**
	 * VO Class의 내용을 String으로 변환
	 */
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    /**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
    public void unDataFormat() {
        this.ifDt = this.ifDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chrgOfc = this.chrgOfc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.type = this.type.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blNo = this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chgCd = this.chgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fxFtOvrDys = this.fxFtOvrDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shipperNm = this.shipperNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chrgDt = this.chrgDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvdCd = this.vvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chgAmt = this.chgAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.arIfDt = this.arIfDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shipperCd = this.shipperCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.notifyCd = this.notifyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.consigneeNm = this.consigneeNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtTrfCd = this.dmdtTrfCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.payerCd = this.payerCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ifNo = this.ifNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.subtot = this.subtot.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.consigneeCd = this.consigneeCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.payerFlg = this.payerFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.frtTermCd = this.frtTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ftCmncDt = this.ftCmncDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.arIfOfcCd = this.arIfOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvd = this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ratAsQty = this.ratAsQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.port = this.port.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.currCd = this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.notifyNm = this.notifyNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.issDt = this.issDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.taxAmt = this.taxAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.erpIfOfcCd = this.erpIfOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.payerNm = this.payerNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creOfcCd = this.creOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.arIfNo = this.arIfNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invAmt = this.invAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.portCd = this.portCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ftEndDt = this.ftEndDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chgUtAmt = this.chgUtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invChgAmt = this.invChgAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtInvNo = this.dmdtInvNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chrgNm = this.chrgNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invCurrCd = this.invCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ioBndCd = this.ioBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.arOfcCd = this.arOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.arIfUsrId = this.arIfUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invNo = this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcCd = this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrNo = this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invPayOfcCd = this.invPayOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invPayDt = this.invPayDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtOfcCd = this.dmdtOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtInvTpCd = this.dmdtInvTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
