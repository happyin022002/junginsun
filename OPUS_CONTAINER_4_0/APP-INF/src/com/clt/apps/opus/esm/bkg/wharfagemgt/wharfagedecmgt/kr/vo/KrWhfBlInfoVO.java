/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KrWhfBlInfoVO.java
*@FileTitle : KrWhfBlInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.10.06 정재엽 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo;

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
 * @author 정재엽
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KrWhfBlInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KrWhfBlInfoVO> models = new ArrayList<KrWhfBlInfoVO>();
	
	/* Column Info */
	private String wfgExptCd = null;
	/* Column Info */
	private String whfCntr45ftQty = null;
	/* Column Info */
	private String blkMeasQty = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String rtonWgt = null;
	/* Column Info */
	private String custRgstNo = null;
	/* Column Info */
	private String taxFeuQty = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String whfCntr40ftQty = null;
	/* Column Info */
	private String whfCntr20ftQty = null;
	/* Column Info */
	private String whfAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String exptFeuQty = null;
	/* Column Info */
	private String taxTeuQty = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String xptRefNo = null;
	/* Column Info */
	private String tax45ftQty = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String expt45ftQty = null;
	/* Column Info */
	private String whfBkg40ftQty = null;
	/* Column Info */
	private String measUtCd = null;
	/* Column Info */
	private String exptTeuQty = null;
	/* Column Info */
	private String whfBlk40ftQty = null;
	/* Column Info */
	private String dcFlg = null;
	/* Column Info */
	private String blkWgtQty = null;
	/* Column Info */
	private String whfBkg20ftQty = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String t = null;
	/* Column Info */
	private String whfBkg45ftQty = null;
	/* Column Info */
	private String whfBlk45ftQty = null;
	/* Column Info */
	private String whfPckTpCd = null;
	/* Column Info */
	private String whfBlk20ftQty = null;
	/* Column Info */
	private String wgtQty = null;
	/* Column Info */
	private String wfgExptDesc = null;
	/* Column Info */
	private String whfRt = null;

	private String bulkRton = null;

	private String bulkRtonApplType = null;
	
	private String bulkWharfageAmount = null;
	
	private String whfBndCd = null;
	
	private String measQty2 = null;
	
	private String wgtQty2 = null;
	
	private String blkWgtQty2 = null;
	
	private String blkMeasQty2 = null;
	
	/* Column Info */
	private String whfAmtTemp = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KrWhfBlInfoVO() {}

	public KrWhfBlInfoVO(String ibflag, String pagerows, String wfgExptCd, String blkMeasQty, String whfCntr45ftQty, 
			String custNm, String rtonWgt, String custRgstNo, String blNo, String whfCntr20ftQty, String whfCntr40ftQty, 
			String whfAmt, String polCd, String cmdtCd, String xptRefNo, String measQty, String wgtUtCd, String whfBkg40ftQty, 
			String measUtCd, String whfBlk40ftQty, String dcFlg, String blkWgtQty, String whfBkg20ftQty, String podCd, String vvd, 
			String whfBkg45ftQty, String t, String whfPckTpCd, String whfBlk45ftQty, String whfBlk20ftQty, String wgtQty, String whfRt, 
			String wfgExptDesc, String bkgNo, String taxTeuQty, String taxFeuQty, String tax45ftQty, String exptTeuQty, String exptFeuQty, 
			String expt45ftQty, String bulkRton, String bulkRtonApplType, String bulkWharfageAmount, String whfBndCd, 
			String measQty2, String wgtQty2, String blkWgtQty2, String blkMeasQty2, String whfAmtTemp) {
		this.wfgExptCd = wfgExptCd;
		this.whfCntr45ftQty = whfCntr45ftQty;
		this.blkMeasQty = blkMeasQty;
		this.custNm = custNm;
		this.rtonWgt = rtonWgt;
		this.custRgstNo = custRgstNo;
		this.taxFeuQty = taxFeuQty;
		this.blNo = blNo;
		this.whfCntr40ftQty = whfCntr40ftQty;
		this.whfCntr20ftQty = whfCntr20ftQty;
		this.whfAmt = whfAmt;
		this.pagerows = pagerows;
		this.exptFeuQty = exptFeuQty;
		this.taxTeuQty = taxTeuQty;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.cmdtCd = cmdtCd;
		this.xptRefNo = xptRefNo;
		this.tax45ftQty = tax45ftQty;
		this.measQty = measQty;
		this.wgtUtCd = wgtUtCd;
		this.expt45ftQty = expt45ftQty;
		this.whfBkg40ftQty = whfBkg40ftQty;
		this.measUtCd = measUtCd;
		this.exptTeuQty = exptTeuQty;
		this.whfBlk40ftQty = whfBlk40ftQty;
		this.dcFlg = dcFlg;
		this.blkWgtQty = blkWgtQty;
		this.whfBkg20ftQty = whfBkg20ftQty;
		this.podCd = podCd;
		this.vvd = vvd;
		this.bkgNo = bkgNo;
		this.t = t;
		this.whfBkg45ftQty = whfBkg45ftQty;
		this.whfBlk45ftQty = whfBlk45ftQty;
		this.whfPckTpCd = whfPckTpCd;
		this.whfBlk20ftQty = whfBlk20ftQty;
		this.wgtQty = wgtQty;
		this.wfgExptDesc = wfgExptDesc;
		this.whfRt = whfRt;
		this.bulkRton = bulkRton;
		this.bulkRtonApplType = bulkRtonApplType;
		this.bulkWharfageAmount = bulkWharfageAmount;
		this.whfBndCd = whfBndCd;
		this.measQty2 = measQty2;
		this.wgtQty2 = wgtQty2;
		this.blkWgtQty2 = blkWgtQty2;
		this.blkMeasQty2 = blkMeasQty2;
		this.whfAmtTemp = whfAmtTemp;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("wfg_expt_cd", getWfgExptCd());
		this.hashColumns.put("whf_cntr_45ft_qty", getWhfCntr45ftQty());
		this.hashColumns.put("blk_meas_qty", getBlkMeasQty());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("rton_wgt", getRtonWgt());
		this.hashColumns.put("cust_rgst_no", getCustRgstNo());
		this.hashColumns.put("tax_feu_qty", getTaxFeuQty());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("whf_cntr_40ft_qty", getWhfCntr40ftQty());
		this.hashColumns.put("whf_cntr_20ft_qty", getWhfCntr20ftQty());
		this.hashColumns.put("whf_amt", getWhfAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("expt_feu_qty", getExptFeuQty());
		this.hashColumns.put("tax_teu_qty", getTaxTeuQty());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("xpt_ref_no", getXptRefNo());
		this.hashColumns.put("tax_45ft_qty", getTax45ftQty());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("expt_45ft_qty", getExpt45ftQty());
		this.hashColumns.put("whf_bkg_40ft_qty", getWhfBkg40ftQty());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		this.hashColumns.put("expt_teu_qty", getExptTeuQty());
		this.hashColumns.put("whf_blk_40ft_qty", getWhfBlk40ftQty());
		this.hashColumns.put("dc_flg", getDcFlg());
		this.hashColumns.put("blk_wgt_qty", getBlkWgtQty());
		this.hashColumns.put("whf_bkg_20ft_qty", getWhfBkg20ftQty());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("t", getT());
		this.hashColumns.put("whf_bkg_45ft_qty", getWhfBkg45ftQty());
		this.hashColumns.put("whf_blk_45ft_qty", getWhfBlk45ftQty());
		this.hashColumns.put("whf_pck_tp_cd", getWhfPckTpCd());
		this.hashColumns.put("whf_blk_20ft_qty", getWhfBlk20ftQty());
		this.hashColumns.put("wgt_qty", getWgtQty());
		this.hashColumns.put("wfg_expt_desc", getWfgExptDesc());
		this.hashColumns.put("whf_rt", getWhfRt());
		this.hashColumns.put("bulk_rton", getBulkRton());
		this.hashColumns.put("bulk_rton_appl_type", getBulkRtonApplType());
		this.hashColumns.put("bulk_wharfage_amount", getBulkWharfageAmount());
		this.hashColumns.put("whf_bnd_cd", getWhfBndCd());
		this.hashColumns.put("meas_qty2", getMeasQty2());
		this.hashColumns.put("wgt_qty2", getWgtQty2());
		this.hashColumns.put("blk_wgt_qty2", getBlkWgtQty2());
		this.hashColumns.put("blk_meas_qty2", getBlkMeasQty2());
		this.hashColumns.put("whf_amt_temp", getWhfAmtTemp());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("wfg_expt_cd", "wfgExptCd");
		this.hashFields.put("whf_cntr_45ft_qty", "whfCntr45ftQty");
		this.hashFields.put("blk_meas_qty", "blkMeasQty");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("rton_wgt", "rtonWgt");
		this.hashFields.put("cust_rgst_no", "custRgstNo");
		this.hashFields.put("tax_feu_qty", "taxFeuQty");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("whf_cntr_40ft_qty", "whfCntr40ftQty");
		this.hashFields.put("whf_cntr_20ft_qty", "whfCntr20ftQty");
		this.hashFields.put("whf_amt", "whfAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("expt_feu_qty", "exptFeuQty");
		this.hashFields.put("tax_teu_qty", "taxTeuQty");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("xpt_ref_no", "xptRefNo");
		this.hashFields.put("tax_45ft_qty", "tax45ftQty");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("expt_45ft_qty", "expt45ftQty");
		this.hashFields.put("whf_bkg_40ft_qty", "whfBkg40ftQty");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("expt_teu_qty", "exptTeuQty");
		this.hashFields.put("whf_blk_40ft_qty", "whfBlk40ftQty");
		this.hashFields.put("dc_flg", "dcFlg");
		this.hashFields.put("blk_wgt_qty", "blkWgtQty");
		this.hashFields.put("whf_bkg_20ft_qty", "whfBkg20ftQty");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("t", "t");
		this.hashFields.put("whf_bkg_45ft_qty", "whfBkg45ftQty");
		this.hashFields.put("whf_blk_45ft_qty", "whfBlk45ftQty");
		this.hashFields.put("whf_pck_tp_cd", "whfPckTpCd");
		this.hashFields.put("whf_blk_20ft_qty", "whfBlk20ftQty");
		this.hashFields.put("wgt_qty", "wgtQty");
		this.hashFields.put("wfg_expt_desc", "wfgExptDesc");
		this.hashFields.put("whf_rt", "whfRt");
		this.hashFields.put("bulk_rton", "bulkRton");
		this.hashFields.put("bulk_rton_appl_type", "bulkRtonApplType");
		this.hashFields.put("bulk_wharfage_amount", "bulkWharfageAmount");
		this.hashFields.put("whf_bnd_cd", "whfBndCd");
		this.hashFields.put("meas_qty2", "measQty2");
		this.hashFields.put("wgt_qty2", "wgtQty2");
		this.hashFields.put("blk_wgt_qty2", "blkWgtQty2");
		this.hashFields.put("blk_meas_qty2", "blkMeasQty2");
		this.hashFields.put("whf_amt_temp", "whfAmtTemp");
		return this.hashFields;
	}
	
	
	
	public String getWhfAmtTemp() {
		return whfAmtTemp;
	}

	public void setWhfAmtTemp(String whfAmtTemp) {
		this.whfAmtTemp = whfAmtTemp;
	}

	public String getBlkWgtQty2() {
		return blkWgtQty2;
	}

	public void setBlkWgtQty2(String blkWgtQty2) {
		this.blkWgtQty2 = blkWgtQty2;
	}

	public String getBlkMeasQty2() {
		return blkMeasQty2;
	}

	public void setBlkMeasQty2(String blkMeasQty2) {
		this.blkMeasQty2 = blkMeasQty2;
	}

	public String getMeasQty2() {
		return measQty2;
	}

	public void setMeasQty2(String measQty2) {
		this.measQty2 = measQty2;
	}

	public String getWgtQty2() {
		return wgtQty2;
	}

	public void setWgtQty2(String wgtQty2) {
		this.wgtQty2 = wgtQty2;
	}

	public String getWhfBndCd() {
		return whfBndCd;
	}

	public void setWhfBndCd(String whfBndCd) {
		this.whfBndCd = whfBndCd;
	}

	public String getBulkWharfageAmount() {
		return bulkWharfageAmount;
	}

	public void setBulkWharfageAmount(String bulkWharfageAmount) {
		this.bulkWharfageAmount = bulkWharfageAmount;
	}

	public String getBulkRtonApplType() {
		return bulkRtonApplType;
	}

	public void setBulkRtonApplType(String bulkRtonApplType) {
		this.bulkRtonApplType = bulkRtonApplType;
	}

	public String getBulkRton() {
		return bulkRton;
	}

	public void setBulkRton(String bulkRton) {
		this.bulkRton = bulkRton;
	}

	/**
	 * Column Info
	 * @return wfgExptCd
	 */
	public String getWfgExptCd() {
		return this.wfgExptCd;
	}
	
	/**
	 * Column Info
	 * @return whfCntr45ftQty
	 */
	public String getWhfCntr45ftQty() {
		return this.whfCntr45ftQty;
	}
	
	/**
	 * Column Info
	 * @return blkMeasQty
	 */
	public String getBlkMeasQty() {
		return this.blkMeasQty;
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
	 * @return rtonWgt
	 */
	public String getRtonWgt() {
		return this.rtonWgt;
	}
	
	/**
	 * Column Info
	 * @return custRgstNo
	 */
	public String getCustRgstNo() {
		return this.custRgstNo;
	}
	
	/**
	 * Column Info
	 * @return taxFeuQty
	 */
	public String getTaxFeuQty() {
		return this.taxFeuQty;
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
	 * @return whfCntr40ftQty
	 */
	public String getWhfCntr40ftQty() {
		return this.whfCntr40ftQty;
	}
	
	/**
	 * Column Info
	 * @return whfCntr20ftQty
	 */
	public String getWhfCntr20ftQty() {
		return this.whfCntr20ftQty;
	}
	
	/**
	 * Column Info
	 * @return whfAmt
	 */
	public String getWhfAmt() {
		return this.whfAmt;
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
	 * @return exptFeuQty
	 */
	public String getExptFeuQty() {
		return this.exptFeuQty;
	}
	
	/**
	 * Column Info
	 * @return taxTeuQty
	 */
	public String getTaxTeuQty() {
		return this.taxTeuQty;
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
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}
	
	/**
	 * Column Info
	 * @return xptRefNo
	 */
	public String getXptRefNo() {
		return this.xptRefNo;
	}
	
	/**
	 * Column Info
	 * @return tax45ftQty
	 */
	public String getTax45ftQty() {
		return this.tax45ftQty;
	}
	
	/**
	 * Column Info
	 * @return measQty
	 */
	public String getMeasQty() {
		return this.measQty;
	}
	
	/**
	 * Column Info
	 * @return wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return expt45ftQty
	 */
	public String getExpt45ftQty() {
		return this.expt45ftQty;
	}
	
	/**
	 * Column Info
	 * @return whfBkg40ftQty
	 */
	public String getWhfBkg40ftQty() {
		return this.whfBkg40ftQty;
	}
	
	/**
	 * Column Info
	 * @return measUtCd
	 */
	public String getMeasUtCd() {
		return this.measUtCd;
	}
	
	/**
	 * Column Info
	 * @return exptTeuQty
	 */
	public String getExptTeuQty() {
		return this.exptTeuQty;
	}
	
	/**
	 * Column Info
	 * @return whfBlk40ftQty
	 */
	public String getWhfBlk40ftQty() {
		return this.whfBlk40ftQty;
	}
	
	/**
	 * Column Info
	 * @return dcFlg
	 */
	public String getDcFlg() {
		return this.dcFlg;
	}
	
	/**
	 * Column Info
	 * @return blkWgtQty
	 */
	public String getBlkWgtQty() {
		return this.blkWgtQty;
	}
	
	/**
	 * Column Info
	 * @return whfBkg20ftQty
	 */
	public String getWhfBkg20ftQty() {
		return this.whfBkg20ftQty;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return t
	 */
	public String getT() {
		return this.t;
	}
	
	/**
	 * Column Info
	 * @return whfBkg45ftQty
	 */
	public String getWhfBkg45ftQty() {
		return this.whfBkg45ftQty;
	}
	
	/**
	 * Column Info
	 * @return whfBlk45ftQty
	 */
	public String getWhfBlk45ftQty() {
		return this.whfBlk45ftQty;
	}
	
	/**
	 * Column Info
	 * @return whfPckTpCd
	 */
	public String getWhfPckTpCd() {
		return this.whfPckTpCd;
	}
	
	/**
	 * Column Info
	 * @return whfBlk20ftQty
	 */
	public String getWhfBlk20ftQty() {
		return this.whfBlk20ftQty;
	}
	
	/**
	 * Column Info
	 * @return wgtQty
	 */
	public String getWgtQty() {
		return this.wgtQty;
	}
	
	/**
	 * Column Info
	 * @return wfgExptDesc
	 */
	public String getWfgExptDesc() {
		return this.wfgExptDesc;
	}
	
	/**
	 * Column Info
	 * @return whfRt
	 */
	public String getWhfRt() {
		return this.whfRt;
	}
	

	/**
	 * Column Info
	 * @param wfgExptCd
	 */
	public void setWfgExptCd(String wfgExptCd) {
		this.wfgExptCd = wfgExptCd;
	}
	
	/**
	 * Column Info
	 * @param whfCntr45ftQty
	 */
	public void setWhfCntr45ftQty(String whfCntr45ftQty) {
		this.whfCntr45ftQty = whfCntr45ftQty;
	}
	
	/**
	 * Column Info
	 * @param blkMeasQty
	 */
	public void setBlkMeasQty(String blkMeasQty) {
		this.blkMeasQty = blkMeasQty;
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
	 * @param rtonWgt
	 */
	public void setRtonWgt(String rtonWgt) {
		this.rtonWgt = rtonWgt;
	}
	
	/**
	 * Column Info
	 * @param custRgstNo
	 */
	public void setCustRgstNo(String custRgstNo) {
		this.custRgstNo = custRgstNo;
	}
	
	/**
	 * Column Info
	 * @param taxFeuQty
	 */
	public void setTaxFeuQty(String taxFeuQty) {
		this.taxFeuQty = taxFeuQty;
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
	 * @param whfCntr40ftQty
	 */
	public void setWhfCntr40ftQty(String whfCntr40ftQty) {
		this.whfCntr40ftQty = whfCntr40ftQty;
	}
	
	/**
	 * Column Info
	 * @param whfCntr20ftQty
	 */
	public void setWhfCntr20ftQty(String whfCntr20ftQty) {
		this.whfCntr20ftQty = whfCntr20ftQty;
	}
	
	/**
	 * Column Info
	 * @param whfAmt
	 */
	public void setWhfAmt(String whfAmt) {
		this.whfAmt = whfAmt;
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
	 * @param exptFeuQty
	 */
	public void setExptFeuQty(String exptFeuQty) {
		this.exptFeuQty = exptFeuQty;
	}
	
	/**
	 * Column Info
	 * @param taxTeuQty
	 */
	public void setTaxTeuQty(String taxTeuQty) {
		this.taxTeuQty = taxTeuQty;
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
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}
	
	/**
	 * Column Info
	 * @param xptRefNo
	 */
	public void setXptRefNo(String xptRefNo) {
		this.xptRefNo = xptRefNo;
	}
	
	/**
	 * Column Info
	 * @param tax45ftQty
	 */
	public void setTax45ftQty(String tax45ftQty) {
		this.tax45ftQty = tax45ftQty;
	}
	
	/**
	 * Column Info
	 * @param measQty
	 */
	public void setMeasQty(String measQty) {
		this.measQty = measQty;
	}
	
	/**
	 * Column Info
	 * @param wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param expt45ftQty
	 */
	public void setExpt45ftQty(String expt45ftQty) {
		this.expt45ftQty = expt45ftQty;
	}
	
	/**
	 * Column Info
	 * @param whfBkg40ftQty
	 */
	public void setWhfBkg40ftQty(String whfBkg40ftQty) {
		this.whfBkg40ftQty = whfBkg40ftQty;
	}
	
	/**
	 * Column Info
	 * @param measUtCd
	 */
	public void setMeasUtCd(String measUtCd) {
		this.measUtCd = measUtCd;
	}
	
	/**
	 * Column Info
	 * @param exptTeuQty
	 */
	public void setExptTeuQty(String exptTeuQty) {
		this.exptTeuQty = exptTeuQty;
	}
	
	/**
	 * Column Info
	 * @param whfBlk40ftQty
	 */
	public void setWhfBlk40ftQty(String whfBlk40ftQty) {
		this.whfBlk40ftQty = whfBlk40ftQty;
	}
	
	/**
	 * Column Info
	 * @param dcFlg
	 */
	public void setDcFlg(String dcFlg) {
		this.dcFlg = dcFlg;
	}
	
	/**
	 * Column Info
	 * @param blkWgtQty
	 */
	public void setBlkWgtQty(String blkWgtQty) {
		this.blkWgtQty = blkWgtQty;
	}
	
	/**
	 * Column Info
	 * @param whfBkg20ftQty
	 */
	public void setWhfBkg20ftQty(String whfBkg20ftQty) {
		this.whfBkg20ftQty = whfBkg20ftQty;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param t
	 */
	public void setT(String t) {
		this.t = t;
	}
	
	/**
	 * Column Info
	 * @param whfBkg45ftQty
	 */
	public void setWhfBkg45ftQty(String whfBkg45ftQty) {
		this.whfBkg45ftQty = whfBkg45ftQty;
	}
	
	/**
	 * Column Info
	 * @param whfBlk45ftQty
	 */
	public void setWhfBlk45ftQty(String whfBlk45ftQty) {
		this.whfBlk45ftQty = whfBlk45ftQty;
	}
	
	/**
	 * Column Info
	 * @param whfPckTpCd
	 */
	public void setWhfPckTpCd(String whfPckTpCd) {
		this.whfPckTpCd = whfPckTpCd;
	}
	
	/**
	 * Column Info
	 * @param whfBlk20ftQty
	 */
	public void setWhfBlk20ftQty(String whfBlk20ftQty) {
		this.whfBlk20ftQty = whfBlk20ftQty;
	}
	
	/**
	 * Column Info
	 * @param wgtQty
	 */
	public void setWgtQty(String wgtQty) {
		this.wgtQty = wgtQty;
	}
	
	/**
	 * Column Info
	 * @param wfgExptDesc
	 */
	public void setWfgExptDesc(String wfgExptDesc) {
		this.wfgExptDesc = wfgExptDesc;
	}
	
	/**
	 * Column Info
	 * @param whfRt
	 */
	public void setWhfRt(String whfRt) {
		this.whfRt = whfRt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setWfgExptCd(JSPUtil.getParameter(request, "wfg_expt_cd", ""));
		setWhfCntr45ftQty(JSPUtil.getParameter(request, "whf_cntr_45ft_qty", ""));
		setBlkMeasQty(JSPUtil.getParameter(request, "blk_meas_qty", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setRtonWgt(JSPUtil.getParameter(request, "rton_wgt", ""));
		setCustRgstNo(JSPUtil.getParameter(request, "cust_rgst_no", ""));
		setTaxFeuQty(JSPUtil.getParameter(request, "tax_feu_qty", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setWhfCntr40ftQty(JSPUtil.getParameter(request, "whf_cntr_40ft_qty", ""));
		setWhfCntr20ftQty(JSPUtil.getParameter(request, "whf_cntr_20ft_qty", ""));
		setWhfAmt(JSPUtil.getParameter(request, "whf_amt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setExptFeuQty(JSPUtil.getParameter(request, "expt_feu_qty", ""));
		setTaxTeuQty(JSPUtil.getParameter(request, "tax_teu_qty", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCmdtCd(JSPUtil.getParameter(request, "cmdt_cd", ""));
		setXptRefNo(JSPUtil.getParameter(request, "xpt_ref_no", ""));
		setTax45ftQty(JSPUtil.getParameter(request, "tax_45ft_qty", ""));
		setMeasQty(JSPUtil.getParameter(request, "meas_qty", ""));
		setWgtUtCd(JSPUtil.getParameter(request, "wgt_ut_cd", ""));
		setExpt45ftQty(JSPUtil.getParameter(request, "expt_45ft_qty", ""));
		setWhfBkg40ftQty(JSPUtil.getParameter(request, "whf_bkg_40ft_qty", ""));
		setMeasUtCd(JSPUtil.getParameter(request, "meas_ut_cd", ""));
		setExptTeuQty(JSPUtil.getParameter(request, "expt_teu_qty", ""));
		setWhfBlk40ftQty(JSPUtil.getParameter(request, "whf_blk_40ft_qty", ""));
		setDcFlg(JSPUtil.getParameter(request, "dc_flg", ""));
		setBlkWgtQty(JSPUtil.getParameter(request, "blk_wgt_qty", ""));
		setWhfBkg20ftQty(JSPUtil.getParameter(request, "whf_bkg_20ft_qty", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setT(JSPUtil.getParameter(request, "t", ""));
		setWhfBkg45ftQty(JSPUtil.getParameter(request, "whf_bkg_45ft_qty", ""));
		setWhfBlk45ftQty(JSPUtil.getParameter(request, "whf_blk_45ft_qty", ""));
		setWhfPckTpCd(JSPUtil.getParameter(request, "whf_pck_tp_cd", ""));
		setWhfBlk20ftQty(JSPUtil.getParameter(request, "whf_blk_20ft_qty", ""));
		setWgtQty(JSPUtil.getParameter(request, "wgt_qty", ""));
		setWfgExptDesc(JSPUtil.getParameter(request, "wfg_expt_desc", ""));
		setWhfRt(JSPUtil.getParameter(request, "whf_rt", ""));
		setBulkRton(JSPUtil.getParameter(request, "bulk_rton", ""));
		setBulkRtonApplType(JSPUtil.getParameter(request, "bulk_rton_appl_type", ""));
		setBulkWharfageAmount(JSPUtil.getParameter(request, "bulk_wharfage_amount", ""));
		setWhfBndCd(JSPUtil.getParameter(request, "whf_bnd_cd", ""));
		setMeasQty2(JSPUtil.getParameter(request, "meas_qty2", ""));
		setWgtQty2(JSPUtil.getParameter(request, "wgt_qty2", ""));
		setBlkWgtQty2(JSPUtil.getParameter(request, "blk_wgt_qty2", ""));
		setBlkMeasQty2(JSPUtil.getParameter(request, "blk_meas_qty2", ""));
		setWhfAmtTemp(JSPUtil.getParameter(request, "whf_amt_temp", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KrWhfBlInfoVO[]
	 */
	public KrWhfBlInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KrWhfBlInfoVO[]
	 */
	public KrWhfBlInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KrWhfBlInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] wfgExptCd = (JSPUtil.getParameter(request, prefix	+ "wfg_expt_cd", length));
			String[] whfCntr45ftQty = (JSPUtil.getParameter(request, prefix	+ "whf_cntr_45ft_qty", length));
			String[] blkMeasQty = (JSPUtil.getParameter(request, prefix	+ "blk_meas_qty", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] rtonWgt = (JSPUtil.getParameter(request, prefix	+ "rton_wgt", length));
			String[] custRgstNo = (JSPUtil.getParameter(request, prefix	+ "cust_rgst_no", length));
			String[] taxFeuQty = (JSPUtil.getParameter(request, prefix	+ "tax_feu_qty", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] whfCntr40ftQty = (JSPUtil.getParameter(request, prefix	+ "whf_cntr_40ft_qty", length));
			String[] whfCntr20ftQty = (JSPUtil.getParameter(request, prefix	+ "whf_cntr_20ft_qty", length));
			String[] whfAmt = (JSPUtil.getParameter(request, prefix	+ "whf_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] exptFeuQty = (JSPUtil.getParameter(request, prefix	+ "expt_feu_qty", length));
			String[] taxTeuQty = (JSPUtil.getParameter(request, prefix	+ "tax_teu_qty", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] xptRefNo = (JSPUtil.getParameter(request, prefix	+ "xpt_ref_no", length));
			String[] tax45ftQty = (JSPUtil.getParameter(request, prefix	+ "tax_45ft_qty", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] expt45ftQty = (JSPUtil.getParameter(request, prefix	+ "expt_45ft_qty", length));
			String[] whfBkg40ftQty = (JSPUtil.getParameter(request, prefix	+ "whf_bkg_40ft_qty", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			String[] exptTeuQty = (JSPUtil.getParameter(request, prefix	+ "expt_teu_qty", length));
			String[] whfBlk40ftQty = (JSPUtil.getParameter(request, prefix	+ "whf_blk_40ft_qty", length));
			String[] dcFlg = (JSPUtil.getParameter(request, prefix	+ "dc_flg", length));
			String[] blkWgtQty = (JSPUtil.getParameter(request, prefix	+ "blk_wgt_qty", length));
			String[] whfBkg20ftQty = (JSPUtil.getParameter(request, prefix	+ "whf_bkg_20ft_qty", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] t = (JSPUtil.getParameter(request, prefix	+ "t", length));
			String[] whfBkg45ftQty = (JSPUtil.getParameter(request, prefix	+ "whf_bkg_45ft_qty", length));
			String[] whfBlk45ftQty = (JSPUtil.getParameter(request, prefix	+ "whf_blk_45ft_qty", length));
			String[] whfPckTpCd = (JSPUtil.getParameter(request, prefix	+ "whf_pck_tp_cd", length));
			String[] whfBlk20ftQty = (JSPUtil.getParameter(request, prefix	+ "whf_blk_20ft_qty", length));
			String[] wgtQty = (JSPUtil.getParameter(request, prefix	+ "wgt_qty", length));
			String[] wfgExptDesc = (JSPUtil.getParameter(request, prefix	+ "wfg_expt_desc", length));
			String[] whfRt = (JSPUtil.getParameter(request, prefix	+ "whf_rt", length));
			String[] bulkRton = (JSPUtil.getParameter(request, prefix	+ "bulk_rton", length));
			String[] bulkRtonApplType = (JSPUtil.getParameter(request, prefix	+ "bulk_rton_appl_type", length));
			String[] bulkWharfageAmount = (JSPUtil.getParameter(request, prefix	+ "bulk_wharfage_amount", length));
			String[] whfBndCd = (JSPUtil.getParameter(request, prefix	+ "whf_bnd_cd", length));
			String[] measQty2 = (JSPUtil.getParameter(request, prefix	+ "meas_qty2", length));
			String[] wgtQty2 = (JSPUtil.getParameter(request, prefix	+ "wgt_qty2", length));
			String[] blkWgtQty2 = (JSPUtil.getParameter(request, prefix	+ "blk_wgt_qty2", length));
			String[] blkMeasQty2 = (JSPUtil.getParameter(request, prefix	+ "blk_meas_qty2", length));
			String[] whfAmtTemp = (JSPUtil.getParameter(request, prefix	+ "whf_amt_temp", length));
			
			for (int i = 0; i < length; i++) {
				model = new KrWhfBlInfoVO();
				if (wfgExptCd[i] != null)
					model.setWfgExptCd(wfgExptCd[i]);
				if (whfCntr45ftQty[i] != null)
					model.setWhfCntr45ftQty(whfCntr45ftQty[i]);
				if (blkMeasQty[i] != null)
					model.setBlkMeasQty(blkMeasQty[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (rtonWgt[i] != null)
					model.setRtonWgt(rtonWgt[i]);
				if (custRgstNo[i] != null)
					model.setCustRgstNo(custRgstNo[i]);
				if (taxFeuQty[i] != null)
					model.setTaxFeuQty(taxFeuQty[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (whfCntr40ftQty[i] != null)
					model.setWhfCntr40ftQty(whfCntr40ftQty[i]);
				if (whfCntr20ftQty[i] != null)
					model.setWhfCntr20ftQty(whfCntr20ftQty[i]);
				if (whfAmt[i] != null)
					model.setWhfAmt(whfAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (exptFeuQty[i] != null)
					model.setExptFeuQty(exptFeuQty[i]);
				if (taxTeuQty[i] != null)
					model.setTaxTeuQty(taxTeuQty[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (xptRefNo[i] != null)
					model.setXptRefNo(xptRefNo[i]);
				if (tax45ftQty[i] != null)
					model.setTax45ftQty(tax45ftQty[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (expt45ftQty[i] != null)
					model.setExpt45ftQty(expt45ftQty[i]);
				if (whfBkg40ftQty[i] != null)
					model.setWhfBkg40ftQty(whfBkg40ftQty[i]);
				if (measUtCd[i] != null)
					model.setMeasUtCd(measUtCd[i]);
				if (exptTeuQty[i] != null)
					model.setExptTeuQty(exptTeuQty[i]);
				if (whfBlk40ftQty[i] != null)
					model.setWhfBlk40ftQty(whfBlk40ftQty[i]);
				if (dcFlg[i] != null)
					model.setDcFlg(dcFlg[i]);
				if (blkWgtQty[i] != null)
					model.setBlkWgtQty(blkWgtQty[i]);
				if (whfBkg20ftQty[i] != null)
					model.setWhfBkg20ftQty(whfBkg20ftQty[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (t[i] != null)
					model.setT(t[i]);
				if (whfBkg45ftQty[i] != null)
					model.setWhfBkg45ftQty(whfBkg45ftQty[i]);
				if (whfBlk45ftQty[i] != null)
					model.setWhfBlk45ftQty(whfBlk45ftQty[i]);
				if (whfPckTpCd[i] != null)
					model.setWhfPckTpCd(whfPckTpCd[i]);
				if (whfBlk20ftQty[i] != null)
					model.setWhfBlk20ftQty(whfBlk20ftQty[i]);
				if (wgtQty[i] != null)
					model.setWgtQty(wgtQty[i]);
				if (wfgExptDesc[i] != null)
					model.setWfgExptDesc(wfgExptDesc[i]);
				if (whfRt[i] != null)
					model.setWhfRt(whfRt[i]);
				if (bulkRton[i] != null)
					model.setBulkRton(bulkRton[i]);
				if (bulkRtonApplType[i] != null)
					model.setBulkRtonApplType(bulkRtonApplType[i]);
				if (bulkWharfageAmount[i] != null)
					model.setBulkWharfageAmount(bulkWharfageAmount[i]);
				if (whfBndCd[i] != null)
					model.setWhfBndCd(whfBndCd[i]);
				if (measQty2[i] != null)
					model.setMeasQty2(measQty2[i]);
				if (wgtQty2[i] != null)
					model.setWgtQty2(wgtQty2[i]);
				if (blkWgtQty2[i] != null)
					model.setBlkWgtQty2(blkWgtQty2[i]);
				if (blkMeasQty2[i] != null)
					model.setBlkMeasQty2(blkMeasQty2[i]);
				if (whfAmtTemp[i] != null)
					model.setWhfAmtTemp(whfAmtTemp[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKrWhfBlInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KrWhfBlInfoVO[]
	 */
	public KrWhfBlInfoVO[] getKrWhfBlInfoVOs(){
		KrWhfBlInfoVO[] vos = (KrWhfBlInfoVO[])models.toArray(new KrWhfBlInfoVO[models.size()]);
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
		this.wfgExptCd = this.wfgExptCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfCntr45ftQty = this.whfCntr45ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blkMeasQty = this.blkMeasQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtonWgt = this.rtonWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRgstNo = this.custRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxFeuQty = this.taxFeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfCntr40ftQty = this.whfCntr40ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfCntr20ftQty = this.whfCntr20ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfAmt = this.whfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptFeuQty = this.exptFeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxTeuQty = this.taxTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xptRefNo = this.xptRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tax45ftQty = this.tax45ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expt45ftQty = this.expt45ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfBkg40ftQty = this.whfBkg40ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptTeuQty = this.exptTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfBlk40ftQty = this.whfBlk40ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcFlg = this.dcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blkWgtQty = this.blkWgtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfBkg20ftQty = this.whfBkg20ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.t = this.t .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfBkg45ftQty = this.whfBkg45ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfBlk45ftQty = this.whfBlk45ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfPckTpCd = this.whfPckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfBlk20ftQty = this.whfBlk20ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtQty = this.wgtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wfgExptDesc = this.wfgExptDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfRt = this.whfRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bulkRton = this.bulkRton .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bulkRtonApplType = this.bulkRtonApplType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bulkWharfageAmount = this.bulkWharfageAmount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfBndCd = this.whfBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty2 = this.measQty2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtQty2 = this.wgtQty2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blkWgtQty2 = this.blkWgtQty2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blkMeasQty2 = this.blkMeasQty2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfAmtTemp = this.whfAmtTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
