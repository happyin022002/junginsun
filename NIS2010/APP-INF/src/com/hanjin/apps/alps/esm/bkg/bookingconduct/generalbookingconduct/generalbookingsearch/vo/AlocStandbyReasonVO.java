/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AlocStandbyReasonVO.java
*@FileTitle : AlocStandbyReasonVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.15
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2014.01.15 문동선 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo;

import java.lang.reflect.Field;
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
 * @author 문동선
 * @since J2EE 1.6
 * @see AbstractValueObject
 */ 

public class AlocStandbyReasonVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AlocStandbyReasonVO> models = new ArrayList<AlocStandbyReasonVO>();
	
	/* Column Info */
	private String delRemark = null;
	/* Column Info */
	private String tsPortRemark = null;
	/* Column Info */
	private String lRhq = null;
	/* Column Info */
	private String teuTtl = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String lRhqAlloc = null;
	/* Column Info */
	private String porFlag = null;
	/* Column Info */
	private String bkgLrhqVol = null;
	/* Column Info */
	private String type = null;
	/* Column Info */
	private String podFlag = null;
	/* Column Info */
	private String eqRemark = null;
	/* Column Info */
	private String tsPortFlag = null;
	/* Column Info */
	private String alocLodQty = null;
	/* Column Info */
	private String alocStsCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String commodityFlag = null;
	/* Column Info */
	private String eqFlag = null;
	/* Column Info */
	private String trunkVvdFlag = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ofcRatio = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String polRemark = null;
	/* Column Info */
	private String trnkSlanCd = null;
	/* Column Info */
	private String commodityRemark = null;
	/* Column Info */
	private String tsVvdRemark = null;
	/* Column Info */
	private String otherFlag = null;
	/* Column Info */
	private String obSlsOfcCd = null;
	/* Column Info */
	private String bkgAlocTpCd = null;
	/* Column Info */
	private String vvdSeq = null;
	/* Column Info */
	private String porRemark = null;
	/* Column Info */
	private String alocLodQtyRto = null;
	/* Column Info */
	private String alocSvcCd = null;
	/* Column Info */
	private String lOfcAlloc = null;
	/* Column Info */
	private String tsRatio = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String bkgLofcVol = null;
	/* Column Info */
	private String rhqRatio = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String polFlag = null;
	/* Column Info */
	private String item = null;
	/* Column Info */
	private String otherRemark = null;
	/* Column Info */
	private String podRemark = null;
	/* Column Info */
	private String trunkVvdRemark = null;
	/* Column Info */
	private String tsVvdFlag = null;
	/* Column Info */
	private String delFlag = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AlocStandbyReasonVO() {}

	public AlocStandbyReasonVO(String ibflag, String pagerows, String item, String trnkSlanCd, String vvd, String lRhq, String obSlsOfcCd, String lOfcAlloc, String bkgLofcVol, String alocLodQtyRto, String alocSvcCd, String lRhqAlloc, String bkgLrhqVol, String ofcRatio, String rhqRatio, String vvdSeq, String slanCd, String alocLodQty, String teuTtl, String tsRatio, String type, String porFlag, String polFlag, String podFlag, String delFlag, String tsPortFlag, String otherFlag, String porRemark, String polRemark, String podRemark, String delRemark, String tsPortRemark, String otherRemark, String bkgAlocTpCd, String custCd, String scNo, String custNm, String trunkVvdRemark, String tsVvdRemark, String eqRemark, String commodityRemark, String trunkVvdFlag, String tsVvdFlag, String eqFlag, String commodityFlag, String alocStsCd) {
		this.delRemark = delRemark;
		this.tsPortRemark = tsPortRemark;
		this.lRhq = lRhq;
		this.teuTtl = teuTtl;
		this.custNm = custNm;
		this.lRhqAlloc = lRhqAlloc;
		this.porFlag = porFlag;
		this.bkgLrhqVol = bkgLrhqVol;
		this.type = type;
		this.podFlag = podFlag;
		this.eqRemark = eqRemark;
		this.tsPortFlag = tsPortFlag;
		this.alocLodQty = alocLodQty;
		this.alocStsCd = alocStsCd;
		this.pagerows = pagerows;
		this.commodityFlag = commodityFlag;
		this.eqFlag = eqFlag;
		this.trunkVvdFlag = trunkVvdFlag;
		this.ibflag = ibflag;
		this.ofcRatio = ofcRatio;
		this.scNo = scNo;
		this.polRemark = polRemark;
		this.trnkSlanCd = trnkSlanCd;
		this.commodityRemark = commodityRemark;
		this.tsVvdRemark = tsVvdRemark;
		this.otherFlag = otherFlag;
		this.obSlsOfcCd = obSlsOfcCd;
		this.bkgAlocTpCd = bkgAlocTpCd;
		this.vvdSeq = vvdSeq;
		this.porRemark = porRemark;
		this.alocLodQtyRto = alocLodQtyRto;
		this.alocSvcCd = alocSvcCd;
		this.lOfcAlloc = lOfcAlloc;
		this.tsRatio = tsRatio;
		this.vvd = vvd;
		this.bkgLofcVol = bkgLofcVol;
		this.rhqRatio = rhqRatio;
		this.slanCd = slanCd;
		this.custCd = custCd;
		this.polFlag = polFlag;
		this.item = item;
		this.otherRemark = otherRemark;
		this.podRemark = podRemark;
		this.trunkVvdRemark = trunkVvdRemark;
		this.tsVvdFlag = tsVvdFlag;
		this.delFlag = delFlag;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("del_remark", getDelRemark());
		this.hashColumns.put("ts_port_remark", getTsPortRemark());
		this.hashColumns.put("l_rhq", getLRhq());
		this.hashColumns.put("teu_ttl", getTeuTtl());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("l_rhq_alloc", getLRhqAlloc());
		this.hashColumns.put("por_flag", getPorFlag());
		this.hashColumns.put("bkg_lrhq_vol", getBkgLrhqVol());
		this.hashColumns.put("type", getType());
		this.hashColumns.put("pod_flag", getPodFlag());
		this.hashColumns.put("eq_remark", getEqRemark());
		this.hashColumns.put("ts_port_flag", getTsPortFlag());
		this.hashColumns.put("aloc_lod_qty", getAlocLodQty());
		this.hashColumns.put("aloc_sts_cd", getAlocStsCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("commodity_flag", getCommodityFlag());
		this.hashColumns.put("eq_flag", getEqFlag());
		this.hashColumns.put("trunk_vvd_flag", getTrunkVvdFlag());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ofc_ratio", getOfcRatio());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("pol_remark", getPolRemark());
		this.hashColumns.put("trnk_slan_cd", getTrnkSlanCd());
		this.hashColumns.put("commodity_remark", getCommodityRemark());
		this.hashColumns.put("ts_vvd_remark", getTsVvdRemark());
		this.hashColumns.put("other_flag", getOtherFlag());
		this.hashColumns.put("ob_sls_ofc_cd", getObSlsOfcCd());
		this.hashColumns.put("bkg_aloc_tp_cd", getBkgAlocTpCd());
		this.hashColumns.put("vvd_seq", getVvdSeq());
		this.hashColumns.put("por_remark", getPorRemark());
		this.hashColumns.put("aloc_lod_qty_rto", getAlocLodQtyRto());
		this.hashColumns.put("aloc_svc_cd", getAlocSvcCd());
		this.hashColumns.put("l_ofc_alloc", getLOfcAlloc());
		this.hashColumns.put("ts_ratio", getTsRatio());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("bkg_lofc_vol", getBkgLofcVol());
		this.hashColumns.put("rhq_ratio", getRhqRatio());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("pol_flag", getPolFlag());
		this.hashColumns.put("item", getItem());
		this.hashColumns.put("other_remark", getOtherRemark());
		this.hashColumns.put("pod_remark", getPodRemark());
		this.hashColumns.put("trunk_vvd_remark", getTrunkVvdRemark());
		this.hashColumns.put("ts_vvd_flag", getTsVvdFlag());
		this.hashColumns.put("del_flag", getDelFlag());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("del_remark", "delRemark");
		this.hashFields.put("ts_port_remark", "tsPortRemark");
		this.hashFields.put("l_rhq", "lRhq");
		this.hashFields.put("teu_ttl", "teuTtl");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("l_rhq_alloc", "lRhqAlloc");
		this.hashFields.put("por_flag", "porFlag");
		this.hashFields.put("bkg_lrhq_vol", "bkgLrhqVol");
		this.hashFields.put("type", "type");
		this.hashFields.put("pod_flag", "podFlag");
		this.hashFields.put("eq_remark", "eqRemark");
		this.hashFields.put("ts_port_flag", "tsPortFlag");
		this.hashFields.put("aloc_lod_qty", "alocLodQty");
		this.hashFields.put("aloc_sts_cd", "alocStsCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("commodity_flag", "commodityFlag");
		this.hashFields.put("eq_flag", "eqFlag");
		this.hashFields.put("trunk_vvd_flag", "trunkVvdFlag");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ofc_ratio", "ofcRatio");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("pol_remark", "polRemark");
		this.hashFields.put("trnk_slan_cd", "trnkSlanCd");
		this.hashFields.put("commodity_remark", "commodityRemark");
		this.hashFields.put("ts_vvd_remark", "tsVvdRemark");
		this.hashFields.put("other_flag", "otherFlag");
		this.hashFields.put("ob_sls_ofc_cd", "obSlsOfcCd");
		this.hashFields.put("bkg_aloc_tp_cd", "bkgAlocTpCd");
		this.hashFields.put("vvd_seq", "vvdSeq");
		this.hashFields.put("por_remark", "porRemark");
		this.hashFields.put("aloc_lod_qty_rto", "alocLodQtyRto");
		this.hashFields.put("aloc_svc_cd", "alocSvcCd");
		this.hashFields.put("l_ofc_alloc", "lOfcAlloc");
		this.hashFields.put("ts_ratio", "tsRatio");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("bkg_lofc_vol", "bkgLofcVol");
		this.hashFields.put("rhq_ratio", "rhqRatio");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("pol_flag", "polFlag");
		this.hashFields.put("item", "item");
		this.hashFields.put("other_remark", "otherRemark");
		this.hashFields.put("pod_remark", "podRemark");
		this.hashFields.put("trunk_vvd_remark", "trunkVvdRemark");
		this.hashFields.put("ts_vvd_flag", "tsVvdFlag");
		this.hashFields.put("del_flag", "delFlag");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return delRemark
	 */
	public String getDelRemark() {
		return this.delRemark;
	}
	
	/**
	 * Column Info
	 * @return tsPortRemark
	 */
	public String getTsPortRemark() {
		return this.tsPortRemark;
	}
	
	/**
	 * Column Info
	 * @return lRhq
	 */
	public String getLRhq() {
		return this.lRhq;
	}
	
	/**
	 * Column Info
	 * @return teuTtl
	 */
	public String getTeuTtl() {
		return this.teuTtl;
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
	 * @return lRhqAlloc
	 */
	public String getLRhqAlloc() {
		return this.lRhqAlloc;
	}
	
	/**
	 * Column Info
	 * @return porFlag
	 */
	public String getPorFlag() {
		return this.porFlag;
	}
	
	/**
	 * Column Info
	 * @return bkgLrhqVol
	 */
	public String getBkgLrhqVol() {
		return this.bkgLrhqVol;
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
	 * @return podFlag
	 */
	public String getPodFlag() {
		return this.podFlag;
	}
	
	/**
	 * Column Info
	 * @return eqRemark
	 */
	public String getEqRemark() {
		return this.eqRemark;
	}
	
	/**
	 * Column Info
	 * @return tsPortFlag
	 */
	public String getTsPortFlag() {
		return this.tsPortFlag;
	}
	
	/**
	 * Column Info
	 * @return alocLodQty
	 */
	public String getAlocLodQty() {
		return this.alocLodQty;
	}
	
	/**
	 * Column Info
	 * @return alocStsCd
	 */
	public String getAlocStsCd() {
		return this.alocStsCd;
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
	 * @return commodityFlag
	 */
	public String getCommodityFlag() {
		return this.commodityFlag;
	}
	
	/**
	 * Column Info
	 * @return eqFlag
	 */
	public String getEqFlag() {
		return this.eqFlag;
	}
	
	/**
	 * Column Info
	 * @return trunkVvdFlag
	 */
	public String getTrunkVvdFlag() {
		return this.trunkVvdFlag;
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
	 * @return ofcRatio
	 */
	public String getOfcRatio() {
		return this.ofcRatio;
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
	 * @return polRemark
	 */
	public String getPolRemark() {
		return this.polRemark;
	}
	
	/**
	 * Column Info
	 * @return trnkSlanCd
	 */
	public String getTrnkSlanCd() {
		return this.trnkSlanCd;
	}
	
	/**
	 * Column Info
	 * @return commodityRemark
	 */
	public String getCommodityRemark() {
		return this.commodityRemark;
	}
	
	/**
	 * Column Info
	 * @return tsVvdRemark
	 */
	public String getTsVvdRemark() {
		return this.tsVvdRemark;
	}
	
	/**
	 * Column Info
	 * @return otherFlag
	 */
	public String getOtherFlag() {
		return this.otherFlag;
	}
	
	/**
	 * Column Info
	 * @return obSlsOfcCd
	 */
	public String getObSlsOfcCd() {
		return this.obSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return bkgAlocTpCd
	 */
	public String getBkgAlocTpCd() {
		return this.bkgAlocTpCd;
	}
	
	/**
	 * Column Info
	 * @return vvdSeq
	 */
	public String getVvdSeq() {
		return this.vvdSeq;
	}
	
	/**
	 * Column Info
	 * @return porRemark
	 */
	public String getPorRemark() {
		return this.porRemark;
	}
	
	/**
	 * Column Info
	 * @return alocLodQtyRto
	 */
	public String getAlocLodQtyRto() {
		return this.alocLodQtyRto;
	}
	
	/**
	 * Column Info
	 * @return alocSvcCd
	 */
	public String getAlocSvcCd() {
		return this.alocSvcCd;
	}
	
	/**
	 * Column Info
	 * @return lOfcAlloc
	 */
	public String getLOfcAlloc() {
		return this.lOfcAlloc;
	}
	
	/**
	 * Column Info
	 * @return tsRatio
	 */
	public String getTsRatio() {
		return this.tsRatio;
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
	 * @return bkgLofcVol
	 */
	public String getBkgLofcVol() {
		return this.bkgLofcVol;
	}
	
	/**
	 * Column Info
	 * @return rhqRatio
	 */
	public String getRhqRatio() {
		return this.rhqRatio;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
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
	 * @return polFlag
	 */
	public String getPolFlag() {
		return this.polFlag;
	}
	
	/**
	 * Column Info
	 * @return item
	 */
	public String getItem() {
		return this.item;
	}
	
	/**
	 * Column Info
	 * @return otherRemark
	 */
	public String getOtherRemark() {
		return this.otherRemark;
	}
	
	/**
	 * Column Info
	 * @return podRemark
	 */
	public String getPodRemark() {
		return this.podRemark;
	}
	
	/**
	 * Column Info
	 * @return trunkVvdRemark
	 */
	public String getTrunkVvdRemark() {
		return this.trunkVvdRemark;
	}
	
	/**
	 * Column Info
	 * @return tsVvdFlag
	 */
	public String getTsVvdFlag() {
		return this.tsVvdFlag;
	}
	
	/**
	 * Column Info
	 * @return delFlag
	 */
	public String getDelFlag() {
		return this.delFlag;
	}
	

	/**
	 * Column Info
	 * @param delRemark
	 */
	public void setDelRemark(String delRemark) {
		this.delRemark = delRemark;
	}
	
	/**
	 * Column Info
	 * @param tsPortRemark
	 */
	public void setTsPortRemark(String tsPortRemark) {
		this.tsPortRemark = tsPortRemark;
	}
	
	/**
	 * Column Info
	 * @param lRhq
	 */
	public void setLRhq(String lRhq) {
		this.lRhq = lRhq;
	}
	
	/**
	 * Column Info
	 * @param teuTtl
	 */
	public void setTeuTtl(String teuTtl) {
		this.teuTtl = teuTtl;
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
	 * @param lRhqAlloc
	 */
	public void setLRhqAlloc(String lRhqAlloc) {
		this.lRhqAlloc = lRhqAlloc;
	}
	
	/**
	 * Column Info
	 * @param porFlag
	 */
	public void setPorFlag(String porFlag) {
		this.porFlag = porFlag;
	}
	
	/**
	 * Column Info
	 * @param bkgLrhqVol
	 */
	public void setBkgLrhqVol(String bkgLrhqVol) {
		this.bkgLrhqVol = bkgLrhqVol;
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
	 * @param podFlag
	 */
	public void setPodFlag(String podFlag) {
		this.podFlag = podFlag;
	}
	
	/**
	 * Column Info
	 * @param eqRemark
	 */
	public void setEqRemark(String eqRemark) {
		this.eqRemark = eqRemark;
	}
	
	/**
	 * Column Info
	 * @param tsPortFlag
	 */
	public void setTsPortFlag(String tsPortFlag) {
		this.tsPortFlag = tsPortFlag;
	}
	
	/**
	 * Column Info
	 * @param alocLodQty
	 */
	public void setAlocLodQty(String alocLodQty) {
		this.alocLodQty = alocLodQty;
	}
	
	/**
	 * Column Info
	 * @param alocStsCd
	 */
	public void setAlocStsCd(String alocStsCd) {
		this.alocStsCd = alocStsCd;
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
	 * @param commodityFlag
	 */
	public void setCommodityFlag(String commodityFlag) {
		this.commodityFlag = commodityFlag;
	}
	
	/**
	 * Column Info
	 * @param eqFlag
	 */
	public void setEqFlag(String eqFlag) {
		this.eqFlag = eqFlag;
	}
	
	/**
	 * Column Info
	 * @param trunkVvdFlag
	 */
	public void setTrunkVvdFlag(String trunkVvdFlag) {
		this.trunkVvdFlag = trunkVvdFlag;
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
	 * @param ofcRatio
	 */
	public void setOfcRatio(String ofcRatio) {
		this.ofcRatio = ofcRatio;
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
	 * @param polRemark
	 */
	public void setPolRemark(String polRemark) {
		this.polRemark = polRemark;
	}
	
	/**
	 * Column Info
	 * @param trnkSlanCd
	 */
	public void setTrnkSlanCd(String trnkSlanCd) {
		this.trnkSlanCd = trnkSlanCd;
	}
	
	/**
	 * Column Info
	 * @param commodityRemark
	 */
	public void setCommodityRemark(String commodityRemark) {
		this.commodityRemark = commodityRemark;
	}
	
	/**
	 * Column Info
	 * @param tsVvdRemark
	 */
	public void setTsVvdRemark(String tsVvdRemark) {
		this.tsVvdRemark = tsVvdRemark;
	}
	
	/**
	 * Column Info
	 * @param otherFlag
	 */
	public void setOtherFlag(String otherFlag) {
		this.otherFlag = otherFlag;
	}
	
	/**
	 * Column Info
	 * @param obSlsOfcCd
	 */
	public void setObSlsOfcCd(String obSlsOfcCd) {
		this.obSlsOfcCd = obSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param bkgAlocTpCd
	 */
	public void setBkgAlocTpCd(String bkgAlocTpCd) {
		this.bkgAlocTpCd = bkgAlocTpCd;
	}
	
	/**
	 * Column Info
	 * @param vvdSeq
	 */
	public void setVvdSeq(String vvdSeq) {
		this.vvdSeq = vvdSeq;
	}
	
	/**
	 * Column Info
	 * @param porRemark
	 */
	public void setPorRemark(String porRemark) {
		this.porRemark = porRemark;
	}
	
	/**
	 * Column Info
	 * @param alocLodQtyRto
	 */
	public void setAlocLodQtyRto(String alocLodQtyRto) {
		this.alocLodQtyRto = alocLodQtyRto;
	}
	
	/**
	 * Column Info
	 * @param alocSvcCd
	 */
	public void setAlocSvcCd(String alocSvcCd) {
		this.alocSvcCd = alocSvcCd;
	}
	
	/**
	 * Column Info
	 * @param lOfcAlloc
	 */
	public void setLOfcAlloc(String lOfcAlloc) {
		this.lOfcAlloc = lOfcAlloc;
	}
	
	/**
	 * Column Info
	 * @param tsRatio
	 */
	public void setTsRatio(String tsRatio) {
		this.tsRatio = tsRatio;
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
	 * @param bkgLofcVol
	 */
	public void setBkgLofcVol(String bkgLofcVol) {
		this.bkgLofcVol = bkgLofcVol;
	}
	
	/**
	 * Column Info
	 * @param rhqRatio
	 */
	public void setRhqRatio(String rhqRatio) {
		this.rhqRatio = rhqRatio;
	}
	
	/**
	 * Column Info
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
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
	 * @param polFlag
	 */
	public void setPolFlag(String polFlag) {
		this.polFlag = polFlag;
	}
	
	/**
	 * Column Info
	 * @param item
	 */
	public void setItem(String item) {
		this.item = item;
	}
	
	/**
	 * Column Info
	 * @param otherRemark
	 */
	public void setOtherRemark(String otherRemark) {
		this.otherRemark = otherRemark;
	}
	
	/**
	 * Column Info
	 * @param podRemark
	 */
	public void setPodRemark(String podRemark) {
		this.podRemark = podRemark;
	}
	
	/**
	 * Column Info
	 * @param trunkVvdRemark
	 */
	public void setTrunkVvdRemark(String trunkVvdRemark) {
		this.trunkVvdRemark = trunkVvdRemark;
	}
	
	/**
	 * Column Info
	 * @param tsVvdFlag
	 */
	public void setTsVvdFlag(String tsVvdFlag) {
		this.tsVvdFlag = tsVvdFlag;
	}
	
	/**
	 * Column Info
	 * @param delFlag
	 */
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
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
		setDelRemark(JSPUtil.getParameter(request, prefix + "del_remark", ""));
		setTsPortRemark(JSPUtil.getParameter(request, prefix + "ts_port_remark", ""));
		setLRhq(JSPUtil.getParameter(request, prefix + "l_rhq", ""));
		setTeuTtl(JSPUtil.getParameter(request, prefix + "teu_ttl", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setLRhqAlloc(JSPUtil.getParameter(request, prefix + "l_rhq_alloc", ""));
		setPorFlag(JSPUtil.getParameter(request, prefix + "por_flag", ""));
		setBkgLrhqVol(JSPUtil.getParameter(request, prefix + "bkg_lrhq_vol", ""));
		setType(JSPUtil.getParameter(request, prefix + "type", ""));
		setPodFlag(JSPUtil.getParameter(request, prefix + "pod_flag", ""));
		setEqRemark(JSPUtil.getParameter(request, prefix + "eq_remark", ""));
		setTsPortFlag(JSPUtil.getParameter(request, prefix + "ts_port_flag", ""));
		setAlocLodQty(JSPUtil.getParameter(request, prefix + "aloc_lod_qty", ""));
		setAlocStsCd(JSPUtil.getParameter(request, prefix + "aloc_sts_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCommodityFlag(JSPUtil.getParameter(request, prefix + "commodity_flag", ""));
		setEqFlag(JSPUtil.getParameter(request, prefix + "eq_flag", ""));
		setTrunkVvdFlag(JSPUtil.getParameter(request, prefix + "trunk_vvd_flag", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOfcRatio(JSPUtil.getParameter(request, prefix + "ofc_ratio", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setPolRemark(JSPUtil.getParameter(request, prefix + "pol_remark", ""));
		setTrnkSlanCd(JSPUtil.getParameter(request, prefix + "trnk_slan_cd", ""));
		setCommodityRemark(JSPUtil.getParameter(request, prefix + "commodity_remark", ""));
		setTsVvdRemark(JSPUtil.getParameter(request, prefix + "ts_vvd_remark", ""));
		setOtherFlag(JSPUtil.getParameter(request, prefix + "other_flag", ""));
		setObSlsOfcCd(JSPUtil.getParameter(request, prefix + "ob_sls_ofc_cd", ""));
		setBkgAlocTpCd(JSPUtil.getParameter(request, prefix + "bkg_aloc_tp_cd", ""));
		setVvdSeq(JSPUtil.getParameter(request, prefix + "vvd_seq", ""));
		setPorRemark(JSPUtil.getParameter(request, prefix + "por_remark", ""));
		setAlocLodQtyRto(JSPUtil.getParameter(request, prefix + "aloc_lod_qty_rto", ""));
		setAlocSvcCd(JSPUtil.getParameter(request, prefix + "aloc_svc_cd", ""));
		setLOfcAlloc(JSPUtil.getParameter(request, prefix + "l_ofc_alloc", ""));
		setTsRatio(JSPUtil.getParameter(request, prefix + "ts_ratio", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setBkgLofcVol(JSPUtil.getParameter(request, prefix + "bkg_lofc_vol", ""));
		setRhqRatio(JSPUtil.getParameter(request, prefix + "rhq_ratio", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setPolFlag(JSPUtil.getParameter(request, prefix + "pol_flag", ""));
		setItem(JSPUtil.getParameter(request, prefix + "item", ""));
		setOtherRemark(JSPUtil.getParameter(request, prefix + "other_remark", ""));
		setPodRemark(JSPUtil.getParameter(request, prefix + "pod_remark", ""));
		setTrunkVvdRemark(JSPUtil.getParameter(request, prefix + "trunk_vvd_remark", ""));
		setTsVvdFlag(JSPUtil.getParameter(request, prefix + "ts_vvd_flag", ""));
		setDelFlag(JSPUtil.getParameter(request, prefix + "del_flag", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AlocStandbyReasonVO[]
	 */
	public AlocStandbyReasonVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AlocStandbyReasonVO[]
	 */
	public AlocStandbyReasonVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AlocStandbyReasonVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] delRemark = (JSPUtil.getParameter(request, prefix	+ "del_remark", length));
			String[] tsPortRemark = (JSPUtil.getParameter(request, prefix	+ "ts_port_remark", length));
			String[] lRhq = (JSPUtil.getParameter(request, prefix	+ "l_rhq", length));
			String[] teuTtl = (JSPUtil.getParameter(request, prefix	+ "teu_ttl", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] lRhqAlloc = (JSPUtil.getParameter(request, prefix	+ "l_rhq_alloc", length));
			String[] porFlag = (JSPUtil.getParameter(request, prefix	+ "por_flag", length));
			String[] bkgLrhqVol = (JSPUtil.getParameter(request, prefix	+ "bkg_lrhq_vol", length));
			String[] type = (JSPUtil.getParameter(request, prefix	+ "type", length));
			String[] podFlag = (JSPUtil.getParameter(request, prefix	+ "pod_flag", length));
			String[] eqRemark = (JSPUtil.getParameter(request, prefix	+ "eq_remark", length));
			String[] tsPortFlag = (JSPUtil.getParameter(request, prefix	+ "ts_port_flag", length));
			String[] alocLodQty = (JSPUtil.getParameter(request, prefix	+ "aloc_lod_qty", length));
			String[] alocStsCd = (JSPUtil.getParameter(request, prefix	+ "aloc_sts_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] commodityFlag = (JSPUtil.getParameter(request, prefix	+ "commodity_flag", length));
			String[] eqFlag = (JSPUtil.getParameter(request, prefix	+ "eq_flag", length));
			String[] trunkVvdFlag = (JSPUtil.getParameter(request, prefix	+ "trunk_vvd_flag", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ofcRatio = (JSPUtil.getParameter(request, prefix	+ "ofc_ratio", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] polRemark = (JSPUtil.getParameter(request, prefix	+ "pol_remark", length));
			String[] trnkSlanCd = (JSPUtil.getParameter(request, prefix	+ "trnk_slan_cd", length));
			String[] commodityRemark = (JSPUtil.getParameter(request, prefix	+ "commodity_remark", length));
			String[] tsVvdRemark = (JSPUtil.getParameter(request, prefix	+ "ts_vvd_remark", length));
			String[] otherFlag = (JSPUtil.getParameter(request, prefix	+ "other_flag", length));
			String[] obSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ob_sls_ofc_cd", length));
			String[] bkgAlocTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_aloc_tp_cd", length));
			String[] vvdSeq = (JSPUtil.getParameter(request, prefix	+ "vvd_seq", length));
			String[] porRemark = (JSPUtil.getParameter(request, prefix	+ "por_remark", length));
			String[] alocLodQtyRto = (JSPUtil.getParameter(request, prefix	+ "aloc_lod_qty_rto", length));
			String[] alocSvcCd = (JSPUtil.getParameter(request, prefix	+ "aloc_svc_cd", length));
			String[] lOfcAlloc = (JSPUtil.getParameter(request, prefix	+ "l_ofc_alloc", length));
			String[] tsRatio = (JSPUtil.getParameter(request, prefix	+ "ts_ratio", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] bkgLofcVol = (JSPUtil.getParameter(request, prefix	+ "bkg_lofc_vol", length));
			String[] rhqRatio = (JSPUtil.getParameter(request, prefix	+ "rhq_ratio", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] polFlag = (JSPUtil.getParameter(request, prefix	+ "pol_flag", length));
			String[] item = (JSPUtil.getParameter(request, prefix	+ "item", length));
			String[] otherRemark = (JSPUtil.getParameter(request, prefix	+ "other_remark", length));
			String[] podRemark = (JSPUtil.getParameter(request, prefix	+ "pod_remark", length));
			String[] trunkVvdRemark = (JSPUtil.getParameter(request, prefix	+ "trunk_vvd_remark", length));
			String[] tsVvdFlag = (JSPUtil.getParameter(request, prefix	+ "ts_vvd_flag", length));
			String[] delFlag = (JSPUtil.getParameter(request, prefix	+ "del_flag", length));
			
			for (int i = 0; i < length; i++) {
				model = new AlocStandbyReasonVO();
				if (delRemark[i] != null)
					model.setDelRemark(delRemark[i]);
				if (tsPortRemark[i] != null)
					model.setTsPortRemark(tsPortRemark[i]);
				if (lRhq[i] != null)
					model.setLRhq(lRhq[i]);
				if (teuTtl[i] != null)
					model.setTeuTtl(teuTtl[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (lRhqAlloc[i] != null)
					model.setLRhqAlloc(lRhqAlloc[i]);
				if (porFlag[i] != null)
					model.setPorFlag(porFlag[i]);
				if (bkgLrhqVol[i] != null)
					model.setBkgLrhqVol(bkgLrhqVol[i]);
				if (type[i] != null)
					model.setType(type[i]);
				if (podFlag[i] != null)
					model.setPodFlag(podFlag[i]);
				if (eqRemark[i] != null)
					model.setEqRemark(eqRemark[i]);
				if (tsPortFlag[i] != null)
					model.setTsPortFlag(tsPortFlag[i]);
				if (alocLodQty[i] != null)
					model.setAlocLodQty(alocLodQty[i]);
				if (alocStsCd[i] != null)
					model.setAlocStsCd(alocStsCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (commodityFlag[i] != null)
					model.setCommodityFlag(commodityFlag[i]);
				if (eqFlag[i] != null)
					model.setEqFlag(eqFlag[i]);
				if (trunkVvdFlag[i] != null)
					model.setTrunkVvdFlag(trunkVvdFlag[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ofcRatio[i] != null)
					model.setOfcRatio(ofcRatio[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (polRemark[i] != null)
					model.setPolRemark(polRemark[i]);
				if (trnkSlanCd[i] != null)
					model.setTrnkSlanCd(trnkSlanCd[i]);
				if (commodityRemark[i] != null)
					model.setCommodityRemark(commodityRemark[i]);
				if (tsVvdRemark[i] != null)
					model.setTsVvdRemark(tsVvdRemark[i]);
				if (otherFlag[i] != null)
					model.setOtherFlag(otherFlag[i]);
				if (obSlsOfcCd[i] != null)
					model.setObSlsOfcCd(obSlsOfcCd[i]);
				if (bkgAlocTpCd[i] != null)
					model.setBkgAlocTpCd(bkgAlocTpCd[i]);
				if (vvdSeq[i] != null)
					model.setVvdSeq(vvdSeq[i]);
				if (porRemark[i] != null)
					model.setPorRemark(porRemark[i]);
				if (alocLodQtyRto[i] != null)
					model.setAlocLodQtyRto(alocLodQtyRto[i]);
				if (alocSvcCd[i] != null)
					model.setAlocSvcCd(alocSvcCd[i]);
				if (lOfcAlloc[i] != null)
					model.setLOfcAlloc(lOfcAlloc[i]);
				if (tsRatio[i] != null)
					model.setTsRatio(tsRatio[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (bkgLofcVol[i] != null)
					model.setBkgLofcVol(bkgLofcVol[i]);
				if (rhqRatio[i] != null)
					model.setRhqRatio(rhqRatio[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (polFlag[i] != null)
					model.setPolFlag(polFlag[i]);
				if (item[i] != null)
					model.setItem(item[i]);
				if (otherRemark[i] != null)
					model.setOtherRemark(otherRemark[i]);
				if (podRemark[i] != null)
					model.setPodRemark(podRemark[i]);
				if (trunkVvdRemark[i] != null)
					model.setTrunkVvdRemark(trunkVvdRemark[i]);
				if (tsVvdFlag[i] != null)
					model.setTsVvdFlag(tsVvdFlag[i]);
				if (delFlag[i] != null)
					model.setDelFlag(delFlag[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAlocStandbyReasonVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AlocStandbyReasonVO[]
	 */
	public AlocStandbyReasonVO[] getAlocStandbyReasonVOs(){
		AlocStandbyReasonVO[] vos = (AlocStandbyReasonVO[])models.toArray(new AlocStandbyReasonVO[models.size()]);
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
		this.delRemark = this.delRemark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsPortRemark = this.tsPortRemark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lRhq = this.lRhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teuTtl = this.teuTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lRhqAlloc = this.lRhqAlloc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porFlag = this.porFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgLrhqVol = this.bkgLrhqVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.type = this.type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podFlag = this.podFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqRemark = this.eqRemark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsPortFlag = this.tsPortFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocLodQty = this.alocLodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocStsCd = this.alocStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commodityFlag = this.commodityFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqFlag = this.eqFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkVvdFlag = this.trunkVvdFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcRatio = this.ofcRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polRemark = this.polRemark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkSlanCd = this.trnkSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commodityRemark = this.commodityRemark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsVvdRemark = this.tsVvdRemark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otherFlag = this.otherFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSlsOfcCd = this.obSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAlocTpCd = this.bkgAlocTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdSeq = this.vvdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porRemark = this.porRemark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocLodQtyRto = this.alocLodQtyRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocSvcCd = this.alocSvcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lOfcAlloc = this.lOfcAlloc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsRatio = this.tsRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgLofcVol = this.bkgLofcVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqRatio = this.rhqRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polFlag = this.polFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.item = this.item .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otherRemark = this.otherRemark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podRemark = this.podRemark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkVvdRemark = this.trunkVvdRemark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsVvdFlag = this.tsVvdFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delFlag = this.delFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
