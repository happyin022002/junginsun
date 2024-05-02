/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DominicanManifestListDetailVO.java
*@FileTitle : DominicanManifestListDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.11
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.11  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dominican.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
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

public class DominicanManifestListDetailVO extends ManifestListDetailVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<DominicanManifestListDetailVO> models = new ArrayList<DominicanManifestListDetailVO>();
	
	/* Column Info */
	private String awSpclCgoDesc = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String sealKndCd = null;
	/* Column Info */
	private String blckStwgCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String spclCgoDescType = null;
	/* Column Info */
	private String mdmTare = null;
	/* Column Info */
	private String aPodCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String woFlg = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String prctFlg = null;
	/* Column Info */
	private String stwgCd = null;
	/* Column Info */
	private String cmdtHsCd = null;
	/* Column Info */
	private String delNodCd = null;
	/* Column Info */
	private String custToOrdFlg = null;
	/* Column Info */
	private String pcSpclCgoDesc = null;
	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String dgSpclCgoDesc = null;
	/* Column Info */
	private String awkCgoFlg = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String cnmvEvntDt = null;
	/* Column Info */
	private String spclCgoDescTmp = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String podNodCd = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String cntrVolQty = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String rdCgoFlg = null;
	/* Column Info */
	private String tsCd = null;
	/* Column Info */
	private String aPolCd = null;
	/* Column Info */
	private String eCntrWgt = null;
	/* Column Info */
	private String rcSpclCgoDesc = null;
	/* Column Info */
	private String hotDeFlg = null;
	/* Column Info */
	private String spclCgoDesc = null;
	/* Column Info */
	private String aCntrWgt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sealPtyTpCd = null;
	/* Column Info */
	private String tot = null;
	/* Column Info */
	private String cstmsDesc = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String spclCgoDescTypeTmp = null;
	/* Column Info */
	private String hgSpclCgoDesc = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String podYdCd = null;
	/* Column Info */
	private String hamoTrfCd = null;
	/* Column Info */
	private String porNodCd = null;
	/* Column Info */
	private String polNodCd = null;
	/* Column Info */
	private String orgYdCd = null;
	/* Column Info */
	private String rdSpclCgoDesc = null;
	/* Column Info */
	private String actWgt = null;
	/* Column Info */
	private String socFlg = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String mstTare = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String polYdCd = null;
	/* Column Info */
	private String hngrFlg = null;
	/* Column Info */
	private String cntrSealNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DominicanManifestListDetailVO() {}

	public DominicanManifestListDetailVO(String ibflag, String pagerows, String cntrNo, String cntrTpszCd, String cntrSealNo, String sealKndCd, String sealPtyTpCd, String aCntrWgt, String cntrWgt, String actWgt, String pckQty, String bkgNo, String blNo, String porCd, String aPolCd, String aPodCd, String delCd, String blckStwgCd, String rcvTermCd, String deTermCd, String tsCd, String bkgCgoTpCd, String hotDeFlg, String custNm, String socFlg, String stwgCd, String hamoTrfCd, String cmdtHsCd, String cntrVolQty, String tot, String pckTpCd, String porNodCd, String polNodCd, String podNodCd, String delNodCd, String custToOrdFlg, String polCd, String polYdCd, String podCd, String podYdCd, String measQty, String dcgoFlg, String rcFlg, String awkCgoFlg, String rdCgoFlg, String prctFlg, String hngrFlg, String spclCgoDescTypeTmp, String dgSpclCgoDesc, String awSpclCgoDesc, String rcSpclCgoDesc, String pcSpclCgoDesc, String rdSpclCgoDesc, String hgSpclCgoDesc, String orgYdCd, String cnmvEvntDt, String cstmsDesc, String mstTare, String mdmTare, String spclCgoDescTmp, String woFlg, String eCntrWgt, String spclCgoDesc, String spclCgoDescType) {
		this.awSpclCgoDesc = awSpclCgoDesc;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.sealKndCd = sealKndCd;
		this.blckStwgCd = blckStwgCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.spclCgoDescType = spclCgoDescType;
		this.mdmTare = mdmTare;
		this.aPodCd = aPodCd;
		this.polCd = polCd;
		this.woFlg = woFlg;
		this.cntrTpszCd = cntrTpszCd;
		this.prctFlg = prctFlg;
		this.stwgCd = stwgCd;
		this.cmdtHsCd = cmdtHsCd;
		this.delNodCd = delNodCd;
		this.custToOrdFlg = custToOrdFlg;
		this.pcSpclCgoDesc = pcSpclCgoDesc;
		this.cntrWgt = cntrWgt;
		this.dgSpclCgoDesc = dgSpclCgoDesc;
		this.awkCgoFlg = awkCgoFlg;
		this.delCd = delCd;
		this.cnmvEvntDt = cnmvEvntDt;
		this.spclCgoDescTmp = spclCgoDescTmp;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.podNodCd = podNodCd;
		this.rcFlg = rcFlg;
		this.cntrVolQty = cntrVolQty;
		this.porCd = porCd;
		this.custNm = custNm;
		this.rdCgoFlg = rdCgoFlg;
		this.tsCd = tsCd;
		this.aPolCd = aPolCd;
		this.eCntrWgt = eCntrWgt;
		this.rcSpclCgoDesc = rcSpclCgoDesc;
		this.hotDeFlg = hotDeFlg;
		this.spclCgoDesc = spclCgoDesc;
		this.aCntrWgt = aCntrWgt;
		this.ibflag = ibflag;
		this.sealPtyTpCd = sealPtyTpCd;
		this.tot = tot;
		this.cstmsDesc = cstmsDesc;
		this.measQty = measQty;
		this.dcgoFlg = dcgoFlg;
		this.spclCgoDescTypeTmp = spclCgoDescTypeTmp;
		this.hgSpclCgoDesc = hgSpclCgoDesc;
		this.pckQty = pckQty;
		this.rcvTermCd = rcvTermCd;
		this.pckTpCd = pckTpCd;
		this.podYdCd = podYdCd;
		this.hamoTrfCd = hamoTrfCd;
		this.porNodCd = porNodCd;
		this.polNodCd = polNodCd;
		this.orgYdCd = orgYdCd;
		this.rdSpclCgoDesc = rdSpclCgoDesc;
		this.actWgt = actWgt;
		this.socFlg = socFlg;
		this.deTermCd = deTermCd;
		this.mstTare = mstTare;
		this.cntrNo = cntrNo;
		this.polYdCd = polYdCd;
		this.hngrFlg = hngrFlg;
		this.cntrSealNo = cntrSealNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("aw_spcl_cgo_desc", getAwSpclCgoDesc());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("seal_knd_cd", getSealKndCd());
		this.hashColumns.put("blck_stwg_cd", getBlckStwgCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("spcl_cgo_desc_type", getSpclCgoDescType());
		this.hashColumns.put("mdm_tare", getMdmTare());
		this.hashColumns.put("a_pod_cd", getAPodCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("wo_flg", getWoFlg());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("prct_flg", getPrctFlg());
		this.hashColumns.put("stwg_cd", getStwgCd());
		this.hashColumns.put("cmdt_hs_cd", getCmdtHsCd());
		this.hashColumns.put("del_nod_cd", getDelNodCd());
		this.hashColumns.put("cust_to_ord_flg", getCustToOrdFlg());
		this.hashColumns.put("pc_spcl_cgo_desc", getPcSpclCgoDesc());
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("dg_spcl_cgo_desc", getDgSpclCgoDesc());
		this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("cnmv_evnt_dt", getCnmvEvntDt());
		this.hashColumns.put("spcl_cgo_desc_tmp", getSpclCgoDescTmp());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pod_nod_cd", getPodNodCd());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("cntr_vol_qty", getCntrVolQty());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("rd_cgo_flg", getRdCgoFlg());
		this.hashColumns.put("ts_cd", getTsCd());
		this.hashColumns.put("a_pol_cd", getAPolCd());
		this.hashColumns.put("e_cntr_wgt", getECntrWgt());
		this.hashColumns.put("rc_spcl_cgo_desc", getRcSpclCgoDesc());
		this.hashColumns.put("hot_de_flg", getHotDeFlg());
		this.hashColumns.put("spcl_cgo_desc", getSpclCgoDesc());
		this.hashColumns.put("a_cntr_wgt", getACntrWgt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("seal_pty_tp_cd", getSealPtyTpCd());
		this.hashColumns.put("tot", getTot());
		this.hashColumns.put("cstms_desc", getCstmsDesc());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("spcl_cgo_desc_type_tmp", getSpclCgoDescTypeTmp());
		this.hashColumns.put("hg_spcl_cgo_desc", getHgSpclCgoDesc());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("pod_yd_cd", getPodYdCd());
		this.hashColumns.put("hamo_trf_cd", getHamoTrfCd());
		this.hashColumns.put("por_nod_cd", getPorNodCd());
		this.hashColumns.put("pol_nod_cd", getPolNodCd());
		this.hashColumns.put("org_yd_cd", getOrgYdCd());
		this.hashColumns.put("rd_spcl_cgo_desc", getRdSpclCgoDesc());
		this.hashColumns.put("act_wgt", getActWgt());
		this.hashColumns.put("soc_flg", getSocFlg());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("mst_tare", getMstTare());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("pol_yd_cd", getPolYdCd());
		this.hashColumns.put("hngr_flg", getHngrFlg());
		this.hashColumns.put("cntr_seal_no", getCntrSealNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("aw_spcl_cgo_desc", "awSpclCgoDesc");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("seal_knd_cd", "sealKndCd");
		this.hashFields.put("blck_stwg_cd", "blckStwgCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("spcl_cgo_desc_type", "spclCgoDescType");
		this.hashFields.put("mdm_tare", "mdmTare");
		this.hashFields.put("a_pod_cd", "aPodCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("wo_flg", "woFlg");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("prct_flg", "prctFlg");
		this.hashFields.put("stwg_cd", "stwgCd");
		this.hashFields.put("cmdt_hs_cd", "cmdtHsCd");
		this.hashFields.put("del_nod_cd", "delNodCd");
		this.hashFields.put("cust_to_ord_flg", "custToOrdFlg");
		this.hashFields.put("pc_spcl_cgo_desc", "pcSpclCgoDesc");
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("dg_spcl_cgo_desc", "dgSpclCgoDesc");
		this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("cnmv_evnt_dt", "cnmvEvntDt");
		this.hashFields.put("spcl_cgo_desc_tmp", "spclCgoDescTmp");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pod_nod_cd", "podNodCd");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("cntr_vol_qty", "cntrVolQty");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("rd_cgo_flg", "rdCgoFlg");
		this.hashFields.put("ts_cd", "tsCd");
		this.hashFields.put("a_pol_cd", "aPolCd");
		this.hashFields.put("e_cntr_wgt", "eCntrWgt");
		this.hashFields.put("rc_spcl_cgo_desc", "rcSpclCgoDesc");
		this.hashFields.put("hot_de_flg", "hotDeFlg");
		this.hashFields.put("spcl_cgo_desc", "spclCgoDesc");
		this.hashFields.put("a_cntr_wgt", "aCntrWgt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("seal_pty_tp_cd", "sealPtyTpCd");
		this.hashFields.put("tot", "tot");
		this.hashFields.put("cstms_desc", "cstmsDesc");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("spcl_cgo_desc_type_tmp", "spclCgoDescTypeTmp");
		this.hashFields.put("hg_spcl_cgo_desc", "hgSpclCgoDesc");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("pod_yd_cd", "podYdCd");
		this.hashFields.put("hamo_trf_cd", "hamoTrfCd");
		this.hashFields.put("por_nod_cd", "porNodCd");
		this.hashFields.put("pol_nod_cd", "polNodCd");
		this.hashFields.put("org_yd_cd", "orgYdCd");
		this.hashFields.put("rd_spcl_cgo_desc", "rdSpclCgoDesc");
		this.hashFields.put("act_wgt", "actWgt");
		this.hashFields.put("soc_flg", "socFlg");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("mst_tare", "mstTare");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("pol_yd_cd", "polYdCd");
		this.hashFields.put("hngr_flg", "hngrFlg");
		this.hashFields.put("cntr_seal_no", "cntrSealNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return awSpclCgoDesc
	 */
	public String getAwSpclCgoDesc() {
		return this.awSpclCgoDesc;
	}
	
	/**
	 * Column Info
	 * @return bkgCgoTpCd
	 */
	public String getBkgCgoTpCd() {
		return this.bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return sealKndCd
	 */
	public String getSealKndCd() {
		return this.sealKndCd;
	}
	
	/**
	 * Column Info
	 * @return blckStwgCd
	 */
	public String getBlckStwgCd() {
		return this.blckStwgCd;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return spclCgoDescType
	 */
	public String getSpclCgoDescType() {
		return this.spclCgoDescType;
	}
	
	/**
	 * Column Info
	 * @return mdmTare
	 */
	public String getMdmTare() {
		return this.mdmTare;
	}
	
	/**
	 * Column Info
	 * @return aPodCd
	 */
	public String getAPodCd() {
		return this.aPodCd;
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
	 * @return woFlg
	 */
	public String getWoFlg() {
		return this.woFlg;
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
	 * @return prctFlg
	 */
	public String getPrctFlg() {
		return this.prctFlg;
	}
	
	/**
	 * Column Info
	 * @return stwgCd
	 */
	public String getStwgCd() {
		return this.stwgCd;
	}
	
	/**
	 * Column Info
	 * @return cmdtHsCd
	 */
	public String getCmdtHsCd() {
		return this.cmdtHsCd;
	}
	
	/**
	 * Column Info
	 * @return delNodCd
	 */
	public String getDelNodCd() {
		return this.delNodCd;
	}
	
	/**
	 * Column Info
	 * @return custToOrdFlg
	 */
	public String getCustToOrdFlg() {
		return this.custToOrdFlg;
	}
	
	/**
	 * Column Info
	 * @return pcSpclCgoDesc
	 */
	public String getPcSpclCgoDesc() {
		return this.pcSpclCgoDesc;
	}
	
	/**
	 * Column Info
	 * @return cntrWgt
	 */
	public String getCntrWgt() {
		return this.cntrWgt;
	}
	
	/**
	 * Column Info
	 * @return dgSpclCgoDesc
	 */
	public String getDgSpclCgoDesc() {
		return this.dgSpclCgoDesc;
	}
	
	/**
	 * Column Info
	 * @return awkCgoFlg
	 */
	public String getAwkCgoFlg() {
		return this.awkCgoFlg;
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
	 * @return cnmvEvntDt
	 */
	public String getCnmvEvntDt() {
		return this.cnmvEvntDt;
	}
	
	/**
	 * Column Info
	 * @return spclCgoDescTmp
	 */
	public String getSpclCgoDescTmp() {
		return this.spclCgoDescTmp;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return podNodCd
	 */
	public String getPodNodCd() {
		return this.podNodCd;
	}
	
	/**
	 * Column Info
	 * @return rcFlg
	 */
	public String getRcFlg() {
		return this.rcFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrVolQty
	 */
	public String getCntrVolQty() {
		return this.cntrVolQty;
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
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return rdCgoFlg
	 */
	public String getRdCgoFlg() {
		return this.rdCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return tsCd
	 */
	public String getTsCd() {
		return this.tsCd;
	}
	
	/**
	 * Column Info
	 * @return aPolCd
	 */
	public String getAPolCd() {
		return this.aPolCd;
	}
	
	/**
	 * Column Info
	 * @return eCntrWgt
	 */
	public String getECntrWgt() {
		return this.eCntrWgt;
	}
	
	/**
	 * Column Info
	 * @return rcSpclCgoDesc
	 */
	public String getRcSpclCgoDesc() {
		return this.rcSpclCgoDesc;
	}
	
	/**
	 * Column Info
	 * @return hotDeFlg
	 */
	public String getHotDeFlg() {
		return this.hotDeFlg;
	}
	
	/**
	 * Column Info
	 * @return spclCgoDesc
	 */
	public String getSpclCgoDesc() {
		return this.spclCgoDesc;
	}
	
	/**
	 * Column Info
	 * @return aCntrWgt
	 */
	public String getACntrWgt() {
		return this.aCntrWgt;
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
	 * @return sealPtyTpCd
	 */
	public String getSealPtyTpCd() {
		return this.sealPtyTpCd;
	}
	
	/**
	 * Column Info
	 * @return tot
	 */
	public String getTot() {
		return this.tot;
	}
	
	/**
	 * Column Info
	 * @return cstmsDesc
	 */
	public String getCstmsDesc() {
		return this.cstmsDesc;
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
	 * @return dcgoFlg
	 */
	public String getDcgoFlg() {
		return this.dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @return spclCgoDescTypeTmp
	 */
	public String getSpclCgoDescTypeTmp() {
		return this.spclCgoDescTypeTmp;
	}
	
	/**
	 * Column Info
	 * @return hgSpclCgoDesc
	 */
	public String getHgSpclCgoDesc() {
		return this.hgSpclCgoDesc;
	}
	
	/**
	 * Column Info
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
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
	 * @return pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
	}
	
	/**
	 * Column Info
	 * @return podYdCd
	 */
	public String getPodYdCd() {
		return this.podYdCd;
	}
	
	/**
	 * Column Info
	 * @return hamoTrfCd
	 */
	public String getHamoTrfCd() {
		return this.hamoTrfCd;
	}
	
	/**
	 * Column Info
	 * @return porNodCd
	 */
	public String getPorNodCd() {
		return this.porNodCd;
	}
	
	/**
	 * Column Info
	 * @return polNodCd
	 */
	public String getPolNodCd() {
		return this.polNodCd;
	}
	
	/**
	 * Column Info
	 * @return orgYdCd
	 */
	public String getOrgYdCd() {
		return this.orgYdCd;
	}
	
	/**
	 * Column Info
	 * @return rdSpclCgoDesc
	 */
	public String getRdSpclCgoDesc() {
		return this.rdSpclCgoDesc;
	}
	
	/**
	 * Column Info
	 * @return actWgt
	 */
	public String getActWgt() {
		return this.actWgt;
	}
	
	/**
	 * Column Info
	 * @return socFlg
	 */
	public String getSocFlg() {
		return this.socFlg;
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
	 * @return mstTare
	 */
	public String getMstTare() {
		return this.mstTare;
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
	 * @return polYdCd
	 */
	public String getPolYdCd() {
		return this.polYdCd;
	}
	
	/**
	 * Column Info
	 * @return hngrFlg
	 */
	public String getHngrFlg() {
		return this.hngrFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrSealNo
	 */
	public String getCntrSealNo() {
		return this.cntrSealNo;
	}
	

	/**
	 * Column Info
	 * @param awSpclCgoDesc
	 */
	public void setAwSpclCgoDesc(String awSpclCgoDesc) {
		this.awSpclCgoDesc = awSpclCgoDesc;
	}
	
	/**
	 * Column Info
	 * @param bkgCgoTpCd
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param sealKndCd
	 */
	public void setSealKndCd(String sealKndCd) {
		this.sealKndCd = sealKndCd;
	}
	
	/**
	 * Column Info
	 * @param blckStwgCd
	 */
	public void setBlckStwgCd(String blckStwgCd) {
		this.blckStwgCd = blckStwgCd;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param spclCgoDescType
	 */
	public void setSpclCgoDescType(String spclCgoDescType) {
		this.spclCgoDescType = spclCgoDescType;
	}
	
	/**
	 * Column Info
	 * @param mdmTare
	 */
	public void setMdmTare(String mdmTare) {
		this.mdmTare = mdmTare;
	}
	
	/**
	 * Column Info
	 * @param aPodCd
	 */
	public void setAPodCd(String aPodCd) {
		this.aPodCd = aPodCd;
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
	 * @param woFlg
	 */
	public void setWoFlg(String woFlg) {
		this.woFlg = woFlg;
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
	 * @param prctFlg
	 */
	public void setPrctFlg(String prctFlg) {
		this.prctFlg = prctFlg;
	}
	
	/**
	 * Column Info
	 * @param stwgCd
	 */
	public void setStwgCd(String stwgCd) {
		this.stwgCd = stwgCd;
	}
	
	/**
	 * Column Info
	 * @param cmdtHsCd
	 */
	public void setCmdtHsCd(String cmdtHsCd) {
		this.cmdtHsCd = cmdtHsCd;
	}
	
	/**
	 * Column Info
	 * @param delNodCd
	 */
	public void setDelNodCd(String delNodCd) {
		this.delNodCd = delNodCd;
	}
	
	/**
	 * Column Info
	 * @param custToOrdFlg
	 */
	public void setCustToOrdFlg(String custToOrdFlg) {
		this.custToOrdFlg = custToOrdFlg;
	}
	
	/**
	 * Column Info
	 * @param pcSpclCgoDesc
	 */
	public void setPcSpclCgoDesc(String pcSpclCgoDesc) {
		this.pcSpclCgoDesc = pcSpclCgoDesc;
	}
	
	/**
	 * Column Info
	 * @param cntrWgt
	 */
	public void setCntrWgt(String cntrWgt) {
		this.cntrWgt = cntrWgt;
	}
	
	/**
	 * Column Info
	 * @param dgSpclCgoDesc
	 */
	public void setDgSpclCgoDesc(String dgSpclCgoDesc) {
		this.dgSpclCgoDesc = dgSpclCgoDesc;
	}
	
	/**
	 * Column Info
	 * @param awkCgoFlg
	 */
	public void setAwkCgoFlg(String awkCgoFlg) {
		this.awkCgoFlg = awkCgoFlg;
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
	 * @param cnmvEvntDt
	 */
	public void setCnmvEvntDt(String cnmvEvntDt) {
		this.cnmvEvntDt = cnmvEvntDt;
	}
	
	/**
	 * Column Info
	 * @param spclCgoDescTmp
	 */
	public void setSpclCgoDescTmp(String spclCgoDescTmp) {
		this.spclCgoDescTmp = spclCgoDescTmp;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param podNodCd
	 */
	public void setPodNodCd(String podNodCd) {
		this.podNodCd = podNodCd;
	}
	
	/**
	 * Column Info
	 * @param rcFlg
	 */
	public void setRcFlg(String rcFlg) {
		this.rcFlg = rcFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrVolQty
	 */
	public void setCntrVolQty(String cntrVolQty) {
		this.cntrVolQty = cntrVolQty;
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
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param rdCgoFlg
	 */
	public void setRdCgoFlg(String rdCgoFlg) {
		this.rdCgoFlg = rdCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param tsCd
	 */
	public void setTsCd(String tsCd) {
		this.tsCd = tsCd;
	}
	
	/**
	 * Column Info
	 * @param aPolCd
	 */
	public void setAPolCd(String aPolCd) {
		this.aPolCd = aPolCd;
	}
	
	/**
	 * Column Info
	 * @param eCntrWgt
	 */
	public void setECntrWgt(String eCntrWgt) {
		this.eCntrWgt = eCntrWgt;
	}
	
	/**
	 * Column Info
	 * @param rcSpclCgoDesc
	 */
	public void setRcSpclCgoDesc(String rcSpclCgoDesc) {
		this.rcSpclCgoDesc = rcSpclCgoDesc;
	}
	
	/**
	 * Column Info
	 * @param hotDeFlg
	 */
	public void setHotDeFlg(String hotDeFlg) {
		this.hotDeFlg = hotDeFlg;
	}
	
	/**
	 * Column Info
	 * @param spclCgoDesc
	 */
	public void setSpclCgoDesc(String spclCgoDesc) {
		this.spclCgoDesc = spclCgoDesc;
	}
	
	/**
	 * Column Info
	 * @param aCntrWgt
	 */
	public void setACntrWgt(String aCntrWgt) {
		this.aCntrWgt = aCntrWgt;
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
	 * @param sealPtyTpCd
	 */
	public void setSealPtyTpCd(String sealPtyTpCd) {
		this.sealPtyTpCd = sealPtyTpCd;
	}
	
	/**
	 * Column Info
	 * @param tot
	 */
	public void setTot(String tot) {
		this.tot = tot;
	}
	
	/**
	 * Column Info
	 * @param cstmsDesc
	 */
	public void setCstmsDesc(String cstmsDesc) {
		this.cstmsDesc = cstmsDesc;
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
	 * @param dcgoFlg
	 */
	public void setDcgoFlg(String dcgoFlg) {
		this.dcgoFlg = dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @param spclCgoDescTypeTmp
	 */
	public void setSpclCgoDescTypeTmp(String spclCgoDescTypeTmp) {
		this.spclCgoDescTypeTmp = spclCgoDescTypeTmp;
	}
	
	/**
	 * Column Info
	 * @param hgSpclCgoDesc
	 */
	public void setHgSpclCgoDesc(String hgSpclCgoDesc) {
		this.hgSpclCgoDesc = hgSpclCgoDesc;
	}
	
	/**
	 * Column Info
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
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
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}
	
	/**
	 * Column Info
	 * @param podYdCd
	 */
	public void setPodYdCd(String podYdCd) {
		this.podYdCd = podYdCd;
	}
	
	/**
	 * Column Info
	 * @param hamoTrfCd
	 */
	public void setHamoTrfCd(String hamoTrfCd) {
		this.hamoTrfCd = hamoTrfCd;
	}
	
	/**
	 * Column Info
	 * @param porNodCd
	 */
	public void setPorNodCd(String porNodCd) {
		this.porNodCd = porNodCd;
	}
	
	/**
	 * Column Info
	 * @param polNodCd
	 */
	public void setPolNodCd(String polNodCd) {
		this.polNodCd = polNodCd;
	}
	
	/**
	 * Column Info
	 * @param orgYdCd
	 */
	public void setOrgYdCd(String orgYdCd) {
		this.orgYdCd = orgYdCd;
	}
	
	/**
	 * Column Info
	 * @param rdSpclCgoDesc
	 */
	public void setRdSpclCgoDesc(String rdSpclCgoDesc) {
		this.rdSpclCgoDesc = rdSpclCgoDesc;
	}
	
	/**
	 * Column Info
	 * @param actWgt
	 */
	public void setActWgt(String actWgt) {
		this.actWgt = actWgt;
	}
	
	/**
	 * Column Info
	 * @param socFlg
	 */
	public void setSocFlg(String socFlg) {
		this.socFlg = socFlg;
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
	 * @param mstTare
	 */
	public void setMstTare(String mstTare) {
		this.mstTare = mstTare;
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
	 * @param polYdCd
	 */
	public void setPolYdCd(String polYdCd) {
		this.polYdCd = polYdCd;
	}
	
	/**
	 * Column Info
	 * @param hngrFlg
	 */
	public void setHngrFlg(String hngrFlg) {
		this.hngrFlg = hngrFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrSealNo
	 */
	public void setCntrSealNo(String cntrSealNo) {
		this.cntrSealNo = cntrSealNo;
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
		setAwSpclCgoDesc(JSPUtil.getParameter(request, prefix + "aw_spcl_cgo_desc", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
		setSealKndCd(JSPUtil.getParameter(request, prefix + "seal_knd_cd", ""));
		setBlckStwgCd(JSPUtil.getParameter(request, prefix + "blck_stwg_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSpclCgoDescType(JSPUtil.getParameter(request, prefix + "spcl_cgo_desc_type", ""));
		setMdmTare(JSPUtil.getParameter(request, prefix + "mdm_tare", ""));
		setAPodCd(JSPUtil.getParameter(request, prefix + "a_pod_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setWoFlg(JSPUtil.getParameter(request, prefix + "wo_flg", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setPrctFlg(JSPUtil.getParameter(request, prefix + "prct_flg", ""));
		setStwgCd(JSPUtil.getParameter(request, prefix + "stwg_cd", ""));
		setCmdtHsCd(JSPUtil.getParameter(request, prefix + "cmdt_hs_cd", ""));
		setDelNodCd(JSPUtil.getParameter(request, prefix + "del_nod_cd", ""));
		setCustToOrdFlg(JSPUtil.getParameter(request, prefix + "cust_to_ord_flg", ""));
		setPcSpclCgoDesc(JSPUtil.getParameter(request, prefix + "pc_spcl_cgo_desc", ""));
		setCntrWgt(JSPUtil.getParameter(request, prefix + "cntr_wgt", ""));
		setDgSpclCgoDesc(JSPUtil.getParameter(request, prefix + "dg_spcl_cgo_desc", ""));
		setAwkCgoFlg(JSPUtil.getParameter(request, prefix + "awk_cgo_flg", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setCnmvEvntDt(JSPUtil.getParameter(request, prefix + "cnmv_evnt_dt", ""));
		setSpclCgoDescTmp(JSPUtil.getParameter(request, prefix + "spcl_cgo_desc_tmp", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setPodNodCd(JSPUtil.getParameter(request, prefix + "pod_nod_cd", ""));
		setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
		setCntrVolQty(JSPUtil.getParameter(request, prefix + "cntr_vol_qty", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setRdCgoFlg(JSPUtil.getParameter(request, prefix + "rd_cgo_flg", ""));
		setTsCd(JSPUtil.getParameter(request, prefix + "ts_cd", ""));
		setAPolCd(JSPUtil.getParameter(request, prefix + "a_pol_cd", ""));
		setECntrWgt(JSPUtil.getParameter(request, prefix + "e_cntr_wgt", ""));
		setRcSpclCgoDesc(JSPUtil.getParameter(request, prefix + "rc_spcl_cgo_desc", ""));
		setHotDeFlg(JSPUtil.getParameter(request, prefix + "hot_de_flg", ""));
		setSpclCgoDesc(JSPUtil.getParameter(request, prefix + "spcl_cgo_desc", ""));
		setACntrWgt(JSPUtil.getParameter(request, prefix + "a_cntr_wgt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSealPtyTpCd(JSPUtil.getParameter(request, prefix + "seal_pty_tp_cd", ""));
		setTot(JSPUtil.getParameter(request, prefix + "tot", ""));
		setCstmsDesc(JSPUtil.getParameter(request, prefix + "cstms_desc", ""));
		setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
		setDcgoFlg(JSPUtil.getParameter(request, prefix + "dcgo_flg", ""));
		setSpclCgoDescTypeTmp(JSPUtil.getParameter(request, prefix + "spcl_cgo_desc_type_tmp", ""));
		setHgSpclCgoDesc(JSPUtil.getParameter(request, prefix + "hg_spcl_cgo_desc", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setPodYdCd(JSPUtil.getParameter(request, prefix + "pod_yd_cd", ""));
		setHamoTrfCd(JSPUtil.getParameter(request, prefix + "hamo_trf_cd", ""));
		setPorNodCd(JSPUtil.getParameter(request, prefix + "por_nod_cd", ""));
		setPolNodCd(JSPUtil.getParameter(request, prefix + "pol_nod_cd", ""));
		setOrgYdCd(JSPUtil.getParameter(request, prefix + "org_yd_cd", ""));
		setRdSpclCgoDesc(JSPUtil.getParameter(request, prefix + "rd_spcl_cgo_desc", ""));
		setActWgt(JSPUtil.getParameter(request, prefix + "act_wgt", ""));
		setSocFlg(JSPUtil.getParameter(request, prefix + "soc_flg", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setMstTare(JSPUtil.getParameter(request, prefix + "mst_tare", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setPolYdCd(JSPUtil.getParameter(request, prefix + "pol_yd_cd", ""));
		setHngrFlg(JSPUtil.getParameter(request, prefix + "hngr_flg", ""));
		setCntrSealNo(JSPUtil.getParameter(request, prefix + "cntr_seal_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DominicanManifestListDetailVO[]
	 */
	public DominicanManifestListDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DominicanManifestListDetailVO[]
	 */
	public DominicanManifestListDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DominicanManifestListDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] awSpclCgoDesc = (JSPUtil.getParameter(request, prefix	+ "aw_spcl_cgo_desc", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] sealKndCd = (JSPUtil.getParameter(request, prefix	+ "seal_knd_cd", length));
			String[] blckStwgCd = (JSPUtil.getParameter(request, prefix	+ "blck_stwg_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] spclCgoDescType = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_desc_type", length));
			String[] mdmTare = (JSPUtil.getParameter(request, prefix	+ "mdm_tare", length));
			String[] aPodCd = (JSPUtil.getParameter(request, prefix	+ "a_pod_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] woFlg = (JSPUtil.getParameter(request, prefix	+ "wo_flg", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] prctFlg = (JSPUtil.getParameter(request, prefix	+ "prct_flg", length));
			String[] stwgCd = (JSPUtil.getParameter(request, prefix	+ "stwg_cd", length));
			String[] cmdtHsCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_hs_cd", length));
			String[] delNodCd = (JSPUtil.getParameter(request, prefix	+ "del_nod_cd", length));
			String[] custToOrdFlg = (JSPUtil.getParameter(request, prefix	+ "cust_to_ord_flg", length));
			String[] pcSpclCgoDesc = (JSPUtil.getParameter(request, prefix	+ "pc_spcl_cgo_desc", length));
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] dgSpclCgoDesc = (JSPUtil.getParameter(request, prefix	+ "dg_spcl_cgo_desc", length));
			String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_flg", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] cnmvEvntDt = (JSPUtil.getParameter(request, prefix	+ "cnmv_evnt_dt", length));
			String[] spclCgoDescTmp = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_desc_tmp", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] podNodCd = (JSPUtil.getParameter(request, prefix	+ "pod_nod_cd", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] cntrVolQty = (JSPUtil.getParameter(request, prefix	+ "cntr_vol_qty", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] rdCgoFlg = (JSPUtil.getParameter(request, prefix	+ "rd_cgo_flg", length));
			String[] tsCd = (JSPUtil.getParameter(request, prefix	+ "ts_cd", length));
			String[] aPolCd = (JSPUtil.getParameter(request, prefix	+ "a_pol_cd", length));
			String[] eCntrWgt = (JSPUtil.getParameter(request, prefix	+ "e_cntr_wgt", length));
			String[] rcSpclCgoDesc = (JSPUtil.getParameter(request, prefix	+ "rc_spcl_cgo_desc", length));
			String[] hotDeFlg = (JSPUtil.getParameter(request, prefix	+ "hot_de_flg", length));
			String[] spclCgoDesc = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_desc", length));
			String[] aCntrWgt = (JSPUtil.getParameter(request, prefix	+ "a_cntr_wgt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sealPtyTpCd = (JSPUtil.getParameter(request, prefix	+ "seal_pty_tp_cd", length));
			String[] tot = (JSPUtil.getParameter(request, prefix	+ "tot", length));
			String[] cstmsDesc = (JSPUtil.getParameter(request, prefix	+ "cstms_desc", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] spclCgoDescTypeTmp = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_desc_type_tmp", length));
			String[] hgSpclCgoDesc = (JSPUtil.getParameter(request, prefix	+ "hg_spcl_cgo_desc", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] podYdCd = (JSPUtil.getParameter(request, prefix	+ "pod_yd_cd", length));
			String[] hamoTrfCd = (JSPUtil.getParameter(request, prefix	+ "hamo_trf_cd", length));
			String[] porNodCd = (JSPUtil.getParameter(request, prefix	+ "por_nod_cd", length));
			String[] polNodCd = (JSPUtil.getParameter(request, prefix	+ "pol_nod_cd", length));
			String[] orgYdCd = (JSPUtil.getParameter(request, prefix	+ "org_yd_cd", length));
			String[] rdSpclCgoDesc = (JSPUtil.getParameter(request, prefix	+ "rd_spcl_cgo_desc", length));
			String[] actWgt = (JSPUtil.getParameter(request, prefix	+ "act_wgt", length));
			String[] socFlg = (JSPUtil.getParameter(request, prefix	+ "soc_flg", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] mstTare = (JSPUtil.getParameter(request, prefix	+ "mst_tare", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] polYdCd = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd", length));
			String[] hngrFlg = (JSPUtil.getParameter(request, prefix	+ "hngr_flg", length));
			String[] cntrSealNo = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new DominicanManifestListDetailVO();
				if (awSpclCgoDesc[i] != null)
					model.setAwSpclCgoDesc(awSpclCgoDesc[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (sealKndCd[i] != null)
					model.setSealKndCd(sealKndCd[i]);
				if (blckStwgCd[i] != null)
					model.setBlckStwgCd(blckStwgCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (spclCgoDescType[i] != null)
					model.setSpclCgoDescType(spclCgoDescType[i]);
				if (mdmTare[i] != null)
					model.setMdmTare(mdmTare[i]);
				if (aPodCd[i] != null)
					model.setAPodCd(aPodCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (woFlg[i] != null)
					model.setWoFlg(woFlg[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (prctFlg[i] != null)
					model.setPrctFlg(prctFlg[i]);
				if (stwgCd[i] != null)
					model.setStwgCd(stwgCd[i]);
				if (cmdtHsCd[i] != null)
					model.setCmdtHsCd(cmdtHsCd[i]);
				if (delNodCd[i] != null)
					model.setDelNodCd(delNodCd[i]);
				if (custToOrdFlg[i] != null)
					model.setCustToOrdFlg(custToOrdFlg[i]);
				if (pcSpclCgoDesc[i] != null)
					model.setPcSpclCgoDesc(pcSpclCgoDesc[i]);
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (dgSpclCgoDesc[i] != null)
					model.setDgSpclCgoDesc(dgSpclCgoDesc[i]);
				if (awkCgoFlg[i] != null)
					model.setAwkCgoFlg(awkCgoFlg[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (cnmvEvntDt[i] != null)
					model.setCnmvEvntDt(cnmvEvntDt[i]);
				if (spclCgoDescTmp[i] != null)
					model.setSpclCgoDescTmp(spclCgoDescTmp[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (podNodCd[i] != null)
					model.setPodNodCd(podNodCd[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (cntrVolQty[i] != null)
					model.setCntrVolQty(cntrVolQty[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (rdCgoFlg[i] != null)
					model.setRdCgoFlg(rdCgoFlg[i]);
				if (tsCd[i] != null)
					model.setTsCd(tsCd[i]);
				if (aPolCd[i] != null)
					model.setAPolCd(aPolCd[i]);
				if (eCntrWgt[i] != null)
					model.setECntrWgt(eCntrWgt[i]);
				if (rcSpclCgoDesc[i] != null)
					model.setRcSpclCgoDesc(rcSpclCgoDesc[i]);
				if (hotDeFlg[i] != null)
					model.setHotDeFlg(hotDeFlg[i]);
				if (spclCgoDesc[i] != null)
					model.setSpclCgoDesc(spclCgoDesc[i]);
				if (aCntrWgt[i] != null)
					model.setACntrWgt(aCntrWgt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sealPtyTpCd[i] != null)
					model.setSealPtyTpCd(sealPtyTpCd[i]);
				if (tot[i] != null)
					model.setTot(tot[i]);
				if (cstmsDesc[i] != null)
					model.setCstmsDesc(cstmsDesc[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (spclCgoDescTypeTmp[i] != null)
					model.setSpclCgoDescTypeTmp(spclCgoDescTypeTmp[i]);
				if (hgSpclCgoDesc[i] != null)
					model.setHgSpclCgoDesc(hgSpclCgoDesc[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (podYdCd[i] != null)
					model.setPodYdCd(podYdCd[i]);
				if (hamoTrfCd[i] != null)
					model.setHamoTrfCd(hamoTrfCd[i]);
				if (porNodCd[i] != null)
					model.setPorNodCd(porNodCd[i]);
				if (polNodCd[i] != null)
					model.setPolNodCd(polNodCd[i]);
				if (orgYdCd[i] != null)
					model.setOrgYdCd(orgYdCd[i]);
				if (rdSpclCgoDesc[i] != null)
					model.setRdSpclCgoDesc(rdSpclCgoDesc[i]);
				if (actWgt[i] != null)
					model.setActWgt(actWgt[i]);
				if (socFlg[i] != null)
					model.setSocFlg(socFlg[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (mstTare[i] != null)
					model.setMstTare(mstTare[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (polYdCd[i] != null)
					model.setPolYdCd(polYdCd[i]);
				if (hngrFlg[i] != null)
					model.setHngrFlg(hngrFlg[i]);
				if (cntrSealNo[i] != null)
					model.setCntrSealNo(cntrSealNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDominicanManifestListDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DominicanManifestListDetailVO[]
	 */
	public DominicanManifestListDetailVO[] getDominicanManifestListDetailVOs(){
		DominicanManifestListDetailVO[] vos = (DominicanManifestListDetailVO[])models.toArray(new DominicanManifestListDetailVO[models.size()]);
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
		this.awSpclCgoDesc = this.awSpclCgoDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sealKndCd = this.sealKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blckStwgCd = this.blckStwgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoDescType = this.spclCgoDescType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdmTare = this.mdmTare .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aPodCd = this.aPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woFlg = this.woFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prctFlg = this.prctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwgCd = this.stwgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHsCd = this.cmdtHsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delNodCd = this.delNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custToOrdFlg = this.custToOrdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pcSpclCgoDesc = this.pcSpclCgoDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgSpclCgoDesc = this.dgSpclCgoDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoFlg = this.awkCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvEvntDt = this.cnmvEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoDescTmp = this.spclCgoDescTmp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podNodCd = this.podNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVolQty = this.cntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdCgoFlg = this.rdCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsCd = this.tsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aPolCd = this.aPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eCntrWgt = this.eCntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcSpclCgoDesc = this.rcSpclCgoDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hotDeFlg = this.hotDeFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoDesc = this.spclCgoDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCntrWgt = this.aCntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sealPtyTpCd = this.sealPtyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tot = this.tot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDesc = this.cstmsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoDescTypeTmp = this.spclCgoDescTypeTmp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hgSpclCgoDesc = this.hgSpclCgoDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd = this.podYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hamoTrfCd = this.hamoTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porNodCd = this.porNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polNodCd = this.polNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYdCd = this.orgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdSpclCgoDesc = this.rdSpclCgoDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWgt = this.actWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socFlg = this.socFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstTare = this.mstTare .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd = this.polYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hngrFlg = this.hngrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo = this.cntrSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
