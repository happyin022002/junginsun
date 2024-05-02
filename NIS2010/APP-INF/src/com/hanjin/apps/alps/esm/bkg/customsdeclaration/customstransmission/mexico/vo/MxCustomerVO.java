/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MxCustomerVO.java
*@FileTitle : MxCustomerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.02
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.02  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.vo;

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

public class MxCustomerVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MxCustomerVO> models = new ArrayList<MxCustomerVO>();
	
	/* Column Info */
	private String ffwdcd = null;
	/* Column Info */
	private String remark = null;
	/* Column Info */
	private String ntfy25 = null;
	/* Column Info */
	private String ntfy21 = null;
	/* Column Info */
	private String blpkgu = null;
	/* Column Info */
	private String ntfy22 = null;
	/* Column Info */
	private String ntfy23 = null;
	/* Column Info */
	private String ntfy24 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ntfytaxid = null;
	/* Column Info */
	private String cctofc = null;
	/* Column Info */
	private String ffwdcn = null;
	/* Column Info */
	private String blmea = null;
	/* Column Info */
	private String expo5 = null;
	/* Column Info */
	private String expo4 = null;
	/* Column Info */
	private String expo3 = null;
	/* Column Info */
	private String expo2 = null;
	/* Column Info */
	private String udCd = null;
	/* Column Info */
	private String expocd = null;
	/* Column Info */
	private String expocn = null;
	/* Column Info */
	private String ntfycn = null;
	/* Column Info */
	private String blWgtUnit = null;
	/* Column Info */
	private String ntfy2nm = null;
	/* Column Info */
	private String ppdofc = null;
	/* Column Info */
	private String eqpickdt = null;
	/* Column Info */
	private String blpkg = null;
	/* Column Info */
	private String ausQuar = null;
	/* Column Info */
	private String blMeaUnit = null;
	/* Column Info */
	private String cargotype = null;
	/* Column Info */
	private String ntfycd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ffwd5 = null;
	/* Column Info */
	private String blrepcmdcd = null;
	/* Column Info */
	private String ffwd2 = null;
	/* Column Info */
	private String ffwd1 = null;
	/* Column Info */
	private String ffwd4 = null;
	/* Column Info */
	private String ffwd3 = null;
	/* Column Info */
	private String rdtype = null;
	/* Column Info */
	private String thdofc = null;
	/* Column Info */
	private String rgnBkgnbr = null;
	/* Column Info */
	private String blwgt = null;
	/* Column Info */
	private String scno = null;
	/* Column Info */
	private String expo1 = null;
	/* Column Info */
	private String eqrel = null;
	/* Column Info */
	private String ntfy5 = null;
	/* Column Info */
	private String ntfy4 = null;
	/* Column Info */
	private String commodity = null;
	/* Column Info */
	private String ntfy3 = null;
	/* Column Info */
	private String ntfy2 = null;
	/* Column Info */
	private String ntfy1 = null;
	/* Column Info */
	private String eqrtn = null;
	/* Column Info */
	private String ntfy2cn = null;
	/* Column Info */
	private String bkgnbr = null;
	/* Column Info */
	private String blcopy = null;
	/* Column Info */
	private String rfano = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MxCustomerVO() {}

	public MxCustomerVO(String ibflag, String pagerows, String ntfycn, String ntfycd, String ntfy1, String ntfy2, String ntfy3, String ntfy4, String ntfy5, String ntfytaxid, String ntfy2cn, String ntfy2nm, String ntfy21, String ntfy22, String ntfy23, String ntfy24, String ntfy25, String ffwdcn, String ffwdcd, String ffwd1, String ffwd2, String ffwd3, String ffwd4, String ffwd5, String expocn, String expocd, String expo1, String expo2, String expo3, String expo4, String expo5, String blcopy, String blpkg, String blpkgu, String blwgt, String blmea, String blWgtUnit, String blMeaUnit, String rdtype, String cargotype, String commodity, String blrepcmdcd, String remark, String ausQuar, String bkgnbr, String rgnBkgnbr, String ppdofc, String cctofc, String thdofc, String scno, String rfano, String eqrel, String eqpickdt, String eqrtn, String udCd) {
		this.ffwdcd = ffwdcd;
		this.remark = remark;
		this.ntfy25 = ntfy25;
		this.ntfy21 = ntfy21;
		this.blpkgu = blpkgu;
		this.ntfy22 = ntfy22;
		this.ntfy23 = ntfy23;
		this.ntfy24 = ntfy24;
		this.pagerows = pagerows;
		this.ntfytaxid = ntfytaxid;
		this.cctofc = cctofc;
		this.ffwdcn = ffwdcn;
		this.blmea = blmea;
		this.expo5 = expo5;
		this.expo4 = expo4;
		this.expo3 = expo3;
		this.expo2 = expo2;
		this.udCd = udCd;
		this.expocd = expocd;
		this.expocn = expocn;
		this.ntfycn = ntfycn;
		this.blWgtUnit = blWgtUnit;
		this.ntfy2nm = ntfy2nm;
		this.ppdofc = ppdofc;
		this.eqpickdt = eqpickdt;
		this.blpkg = blpkg;
		this.ausQuar = ausQuar;
		this.blMeaUnit = blMeaUnit;
		this.cargotype = cargotype;
		this.ntfycd = ntfycd;
		this.ibflag = ibflag;
		this.ffwd5 = ffwd5;
		this.blrepcmdcd = blrepcmdcd;
		this.ffwd2 = ffwd2;
		this.ffwd1 = ffwd1;
		this.ffwd4 = ffwd4;
		this.ffwd3 = ffwd3;
		this.rdtype = rdtype;
		this.thdofc = thdofc;
		this.rgnBkgnbr = rgnBkgnbr;
		this.blwgt = blwgt;
		this.scno = scno;
		this.expo1 = expo1;
		this.eqrel = eqrel;
		this.ntfy5 = ntfy5;
		this.ntfy4 = ntfy4;
		this.commodity = commodity;
		this.ntfy3 = ntfy3;
		this.ntfy2 = ntfy2;
		this.ntfy1 = ntfy1;
		this.eqrtn = eqrtn;
		this.ntfy2cn = ntfy2cn;
		this.bkgnbr = bkgnbr;
		this.blcopy = blcopy;
		this.rfano = rfano;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ffwdcd", getFfwdcd());
		this.hashColumns.put("remark", getRemark());
		this.hashColumns.put("ntfy25", getNtfy25());
		this.hashColumns.put("ntfy21", getNtfy21());
		this.hashColumns.put("blpkgu", getBlpkgu());
		this.hashColumns.put("ntfy22", getNtfy22());
		this.hashColumns.put("ntfy23", getNtfy23());
		this.hashColumns.put("ntfy24", getNtfy24());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ntfytaxid", getNtfytaxid());
		this.hashColumns.put("cctofc", getCctofc());
		this.hashColumns.put("ffwdcn", getFfwdcn());
		this.hashColumns.put("blmea", getBlmea());
		this.hashColumns.put("expo5", getExpo5());
		this.hashColumns.put("expo4", getExpo4());
		this.hashColumns.put("expo3", getExpo3());
		this.hashColumns.put("expo2", getExpo2());
		this.hashColumns.put("ud_cd", getUdCd());
		this.hashColumns.put("expocd", getExpocd());
		this.hashColumns.put("expocn", getExpocn());
		this.hashColumns.put("ntfycn", getNtfycn());
		this.hashColumns.put("bl_wgt_unit", getBlWgtUnit());
		this.hashColumns.put("ntfy2nm", getNtfy2nm());
		this.hashColumns.put("ppdofc", getPpdofc());
		this.hashColumns.put("eqpickdt", getEqpickdt());
		this.hashColumns.put("blpkg", getBlpkg());
		this.hashColumns.put("aus_quar", getAusQuar());
		this.hashColumns.put("bl_mea_unit", getBlMeaUnit());
		this.hashColumns.put("cargotype", getCargotype());
		this.hashColumns.put("ntfycd", getNtfycd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ffwd5", getFfwd5());
		this.hashColumns.put("blrepcmdcd", getBlrepcmdcd());
		this.hashColumns.put("ffwd2", getFfwd2());
		this.hashColumns.put("ffwd1", getFfwd1());
		this.hashColumns.put("ffwd4", getFfwd4());
		this.hashColumns.put("ffwd3", getFfwd3());
		this.hashColumns.put("rdtype", getRdtype());
		this.hashColumns.put("thdofc", getThdofc());
		this.hashColumns.put("rgn_bkgnbr", getRgnBkgnbr());
		this.hashColumns.put("blwgt", getBlwgt());
		this.hashColumns.put("scno", getScno());
		this.hashColumns.put("expo1", getExpo1());
		this.hashColumns.put("eqrel", getEqrel());
		this.hashColumns.put("ntfy5", getNtfy5());
		this.hashColumns.put("ntfy4", getNtfy4());
		this.hashColumns.put("commodity", getCommodity());
		this.hashColumns.put("ntfy3", getNtfy3());
		this.hashColumns.put("ntfy2", getNtfy2());
		this.hashColumns.put("ntfy1", getNtfy1());
		this.hashColumns.put("eqrtn", getEqrtn());
		this.hashColumns.put("ntfy2cn", getNtfy2cn());
		this.hashColumns.put("bkgnbr", getBkgnbr());
		this.hashColumns.put("blcopy", getBlcopy());
		this.hashColumns.put("rfano", getRfano());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ffwdcd", "ffwdcd");
		this.hashFields.put("remark", "remark");
		this.hashFields.put("ntfy25", "ntfy25");
		this.hashFields.put("ntfy21", "ntfy21");
		this.hashFields.put("blpkgu", "blpkgu");
		this.hashFields.put("ntfy22", "ntfy22");
		this.hashFields.put("ntfy23", "ntfy23");
		this.hashFields.put("ntfy24", "ntfy24");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ntfytaxid", "ntfytaxid");
		this.hashFields.put("cctofc", "cctofc");
		this.hashFields.put("ffwdcn", "ffwdcn");
		this.hashFields.put("blmea", "blmea");
		this.hashFields.put("expo5", "expo5");
		this.hashFields.put("expo4", "expo4");
		this.hashFields.put("expo3", "expo3");
		this.hashFields.put("expo2", "expo2");
		this.hashFields.put("ud_cd", "udCd");
		this.hashFields.put("expocd", "expocd");
		this.hashFields.put("expocn", "expocn");
		this.hashFields.put("ntfycn", "ntfycn");
		this.hashFields.put("bl_wgt_unit", "blWgtUnit");
		this.hashFields.put("ntfy2nm", "ntfy2nm");
		this.hashFields.put("ppdofc", "ppdofc");
		this.hashFields.put("eqpickdt", "eqpickdt");
		this.hashFields.put("blpkg", "blpkg");
		this.hashFields.put("aus_quar", "ausQuar");
		this.hashFields.put("bl_mea_unit", "blMeaUnit");
		this.hashFields.put("cargotype", "cargotype");
		this.hashFields.put("ntfycd", "ntfycd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ffwd5", "ffwd5");
		this.hashFields.put("blrepcmdcd", "blrepcmdcd");
		this.hashFields.put("ffwd2", "ffwd2");
		this.hashFields.put("ffwd1", "ffwd1");
		this.hashFields.put("ffwd4", "ffwd4");
		this.hashFields.put("ffwd3", "ffwd3");
		this.hashFields.put("rdtype", "rdtype");
		this.hashFields.put("thdofc", "thdofc");
		this.hashFields.put("rgn_bkgnbr", "rgnBkgnbr");
		this.hashFields.put("blwgt", "blwgt");
		this.hashFields.put("scno", "scno");
		this.hashFields.put("expo1", "expo1");
		this.hashFields.put("eqrel", "eqrel");
		this.hashFields.put("ntfy5", "ntfy5");
		this.hashFields.put("ntfy4", "ntfy4");
		this.hashFields.put("commodity", "commodity");
		this.hashFields.put("ntfy3", "ntfy3");
		this.hashFields.put("ntfy2", "ntfy2");
		this.hashFields.put("ntfy1", "ntfy1");
		this.hashFields.put("eqrtn", "eqrtn");
		this.hashFields.put("ntfy2cn", "ntfy2cn");
		this.hashFields.put("bkgnbr", "bkgnbr");
		this.hashFields.put("blcopy", "blcopy");
		this.hashFields.put("rfano", "rfano");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ffwdcd
	 */
	public String getFfwdcd() {
		return this.ffwdcd;
	}
	
	/**
	 * Column Info
	 * @return remark
	 */
	public String getRemark() {
		return this.remark;
	}
	
	/**
	 * Column Info
	 * @return ntfy25
	 */
	public String getNtfy25() {
		return this.ntfy25;
	}
	
	/**
	 * Column Info
	 * @return ntfy21
	 */
	public String getNtfy21() {
		return this.ntfy21;
	}
	
	/**
	 * Column Info
	 * @return blpkgu
	 */
	public String getBlpkgu() {
		return this.blpkgu;
	}
	
	/**
	 * Column Info
	 * @return ntfy22
	 */
	public String getNtfy22() {
		return this.ntfy22;
	}
	
	/**
	 * Column Info
	 * @return ntfy23
	 */
	public String getNtfy23() {
		return this.ntfy23;
	}
	
	/**
	 * Column Info
	 * @return ntfy24
	 */
	public String getNtfy24() {
		return this.ntfy24;
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
	 * @return ntfytaxid
	 */
	public String getNtfytaxid() {
		return this.ntfytaxid;
	}
	
	/**
	 * Column Info
	 * @return cctofc
	 */
	public String getCctofc() {
		return this.cctofc;
	}
	
	/**
	 * Column Info
	 * @return ffwdcn
	 */
	public String getFfwdcn() {
		return this.ffwdcn;
	}
	
	/**
	 * Column Info
	 * @return blmea
	 */
	public String getBlmea() {
		return this.blmea;
	}
	
	/**
	 * Column Info
	 * @return expo5
	 */
	public String getExpo5() {
		return this.expo5;
	}
	
	/**
	 * Column Info
	 * @return expo4
	 */
	public String getExpo4() {
		return this.expo4;
	}
	
	/**
	 * Column Info
	 * @return expo3
	 */
	public String getExpo3() {
		return this.expo3;
	}
	
	/**
	 * Column Info
	 * @return expo2
	 */
	public String getExpo2() {
		return this.expo2;
	}
	
	/**
	 * Column Info
	 * @return udCd
	 */
	public String getUdCd() {
		return this.udCd;
	}
	
	/**
	 * Column Info
	 * @return expocd
	 */
	public String getExpocd() {
		return this.expocd;
	}
	
	/**
	 * Column Info
	 * @return expocn
	 */
	public String getExpocn() {
		return this.expocn;
	}
	
	/**
	 * Column Info
	 * @return ntfycn
	 */
	public String getNtfycn() {
		return this.ntfycn;
	}
	
	/**
	 * Column Info
	 * @return blWgtUnit
	 */
	public String getBlWgtUnit() {
		return this.blWgtUnit;
	}
	
	/**
	 * Column Info
	 * @return ntfy2nm
	 */
	public String getNtfy2nm() {
		return this.ntfy2nm;
	}
	
	/**
	 * Column Info
	 * @return ppdofc
	 */
	public String getPpdofc() {
		return this.ppdofc;
	}
	
	/**
	 * Column Info
	 * @return eqpickdt
	 */
	public String getEqpickdt() {
		return this.eqpickdt;
	}
	
	/**
	 * Column Info
	 * @return blpkg
	 */
	public String getBlpkg() {
		return this.blpkg;
	}
	
	/**
	 * Column Info
	 * @return ausQuar
	 */
	public String getAusQuar() {
		return this.ausQuar;
	}
	
	/**
	 * Column Info
	 * @return blMeaUnit
	 */
	public String getBlMeaUnit() {
		return this.blMeaUnit;
	}
	
	/**
	 * Column Info
	 * @return cargotype
	 */
	public String getCargotype() {
		return this.cargotype;
	}
	
	/**
	 * Column Info
	 * @return ntfycd
	 */
	public String getNtfycd() {
		return this.ntfycd;
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
	 * @return ffwd5
	 */
	public String getFfwd5() {
		return this.ffwd5;
	}
	
	/**
	 * Column Info
	 * @return blrepcmdcd
	 */
	public String getBlrepcmdcd() {
		return this.blrepcmdcd;
	}
	
	/**
	 * Column Info
	 * @return ffwd2
	 */
	public String getFfwd2() {
		return this.ffwd2;
	}
	
	/**
	 * Column Info
	 * @return ffwd1
	 */
	public String getFfwd1() {
		return this.ffwd1;
	}
	
	/**
	 * Column Info
	 * @return ffwd4
	 */
	public String getFfwd4() {
		return this.ffwd4;
	}
	
	/**
	 * Column Info
	 * @return ffwd3
	 */
	public String getFfwd3() {
		return this.ffwd3;
	}
	
	/**
	 * Column Info
	 * @return rdtype
	 */
	public String getRdtype() {
		return this.rdtype;
	}
	
	/**
	 * Column Info
	 * @return thdofc
	 */
	public String getThdofc() {
		return this.thdofc;
	}
	
	/**
	 * Column Info
	 * @return rgnBkgnbr
	 */
	public String getRgnBkgnbr() {
		return this.rgnBkgnbr;
	}
	
	/**
	 * Column Info
	 * @return blwgt
	 */
	public String getBlwgt() {
		return this.blwgt;
	}
	
	/**
	 * Column Info
	 * @return scno
	 */
	public String getScno() {
		return this.scno;
	}
	
	/**
	 * Column Info
	 * @return expo1
	 */
	public String getExpo1() {
		return this.expo1;
	}
	
	/**
	 * Column Info
	 * @return eqrel
	 */
	public String getEqrel() {
		return this.eqrel;
	}
	
	/**
	 * Column Info
	 * @return ntfy5
	 */
	public String getNtfy5() {
		return this.ntfy5;
	}
	
	/**
	 * Column Info
	 * @return ntfy4
	 */
	public String getNtfy4() {
		return this.ntfy4;
	}
	
	/**
	 * Column Info
	 * @return commodity
	 */
	public String getCommodity() {
		return this.commodity;
	}
	
	/**
	 * Column Info
	 * @return ntfy3
	 */
	public String getNtfy3() {
		return this.ntfy3;
	}
	
	/**
	 * Column Info
	 * @return ntfy2
	 */
	public String getNtfy2() {
		return this.ntfy2;
	}
	
	/**
	 * Column Info
	 * @return ntfy1
	 */
	public String getNtfy1() {
		return this.ntfy1;
	}
	
	/**
	 * Column Info
	 * @return eqrtn
	 */
	public String getEqrtn() {
		return this.eqrtn;
	}
	
	/**
	 * Column Info
	 * @return ntfy2cn
	 */
	public String getNtfy2cn() {
		return this.ntfy2cn;
	}
	
	/**
	 * Column Info
	 * @return bkgnbr
	 */
	public String getBkgnbr() {
		return this.bkgnbr;
	}
	
	/**
	 * Column Info
	 * @return blcopy
	 */
	public String getBlcopy() {
		return this.blcopy;
	}
	
	/**
	 * Column Info
	 * @return rfano
	 */
	public String getRfano() {
		return this.rfano;
	}
	

	/**
	 * Column Info
	 * @param ffwdcd
	 */
	public void setFfwdcd(String ffwdcd) {
		this.ffwdcd = ffwdcd;
	}
	
	/**
	 * Column Info
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * Column Info
	 * @param ntfy25
	 */
	public void setNtfy25(String ntfy25) {
		this.ntfy25 = ntfy25;
	}
	
	/**
	 * Column Info
	 * @param ntfy21
	 */
	public void setNtfy21(String ntfy21) {
		this.ntfy21 = ntfy21;
	}
	
	/**
	 * Column Info
	 * @param blpkgu
	 */
	public void setBlpkgu(String blpkgu) {
		this.blpkgu = blpkgu;
	}
	
	/**
	 * Column Info
	 * @param ntfy22
	 */
	public void setNtfy22(String ntfy22) {
		this.ntfy22 = ntfy22;
	}
	
	/**
	 * Column Info
	 * @param ntfy23
	 */
	public void setNtfy23(String ntfy23) {
		this.ntfy23 = ntfy23;
	}
	
	/**
	 * Column Info
	 * @param ntfy24
	 */
	public void setNtfy24(String ntfy24) {
		this.ntfy24 = ntfy24;
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
	 * @param ntfytaxid
	 */
	public void setNtfytaxid(String ntfytaxid) {
		this.ntfytaxid = ntfytaxid;
	}
	
	/**
	 * Column Info
	 * @param cctofc
	 */
	public void setCctofc(String cctofc) {
		this.cctofc = cctofc;
	}
	
	/**
	 * Column Info
	 * @param ffwdcn
	 */
	public void setFfwdcn(String ffwdcn) {
		this.ffwdcn = ffwdcn;
	}
	
	/**
	 * Column Info
	 * @param blmea
	 */
	public void setBlmea(String blmea) {
		this.blmea = blmea;
	}
	
	/**
	 * Column Info
	 * @param expo5
	 */
	public void setExpo5(String expo5) {
		this.expo5 = expo5;
	}
	
	/**
	 * Column Info
	 * @param expo4
	 */
	public void setExpo4(String expo4) {
		this.expo4 = expo4;
	}
	
	/**
	 * Column Info
	 * @param expo3
	 */
	public void setExpo3(String expo3) {
		this.expo3 = expo3;
	}
	
	/**
	 * Column Info
	 * @param expo2
	 */
	public void setExpo2(String expo2) {
		this.expo2 = expo2;
	}
	
	/**
	 * Column Info
	 * @param udCd
	 */
	public void setUdCd(String udCd) {
		this.udCd = udCd;
	}
	
	/**
	 * Column Info
	 * @param expocd
	 */
	public void setExpocd(String expocd) {
		this.expocd = expocd;
	}
	
	/**
	 * Column Info
	 * @param expocn
	 */
	public void setExpocn(String expocn) {
		this.expocn = expocn;
	}
	
	/**
	 * Column Info
	 * @param ntfycn
	 */
	public void setNtfycn(String ntfycn) {
		this.ntfycn = ntfycn;
	}
	
	/**
	 * Column Info
	 * @param blWgtUnit
	 */
	public void setBlWgtUnit(String blWgtUnit) {
		this.blWgtUnit = blWgtUnit;
	}
	
	/**
	 * Column Info
	 * @param ntfy2nm
	 */
	public void setNtfy2nm(String ntfy2nm) {
		this.ntfy2nm = ntfy2nm;
	}
	
	/**
	 * Column Info
	 * @param ppdofc
	 */
	public void setPpdofc(String ppdofc) {
		this.ppdofc = ppdofc;
	}
	
	/**
	 * Column Info
	 * @param eqpickdt
	 */
	public void setEqpickdt(String eqpickdt) {
		this.eqpickdt = eqpickdt;
	}
	
	/**
	 * Column Info
	 * @param blpkg
	 */
	public void setBlpkg(String blpkg) {
		this.blpkg = blpkg;
	}
	
	/**
	 * Column Info
	 * @param ausQuar
	 */
	public void setAusQuar(String ausQuar) {
		this.ausQuar = ausQuar;
	}
	
	/**
	 * Column Info
	 * @param blMeaUnit
	 */
	public void setBlMeaUnit(String blMeaUnit) {
		this.blMeaUnit = blMeaUnit;
	}
	
	/**
	 * Column Info
	 * @param cargotype
	 */
	public void setCargotype(String cargotype) {
		this.cargotype = cargotype;
	}
	
	/**
	 * Column Info
	 * @param ntfycd
	 */
	public void setNtfycd(String ntfycd) {
		this.ntfycd = ntfycd;
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
	 * @param ffwd5
	 */
	public void setFfwd5(String ffwd5) {
		this.ffwd5 = ffwd5;
	}
	
	/**
	 * Column Info
	 * @param blrepcmdcd
	 */
	public void setBlrepcmdcd(String blrepcmdcd) {
		this.blrepcmdcd = blrepcmdcd;
	}
	
	/**
	 * Column Info
	 * @param ffwd2
	 */
	public void setFfwd2(String ffwd2) {
		this.ffwd2 = ffwd2;
	}
	
	/**
	 * Column Info
	 * @param ffwd1
	 */
	public void setFfwd1(String ffwd1) {
		this.ffwd1 = ffwd1;
	}
	
	/**
	 * Column Info
	 * @param ffwd4
	 */
	public void setFfwd4(String ffwd4) {
		this.ffwd4 = ffwd4;
	}
	
	/**
	 * Column Info
	 * @param ffwd3
	 */
	public void setFfwd3(String ffwd3) {
		this.ffwd3 = ffwd3;
	}
	
	/**
	 * Column Info
	 * @param rdtype
	 */
	public void setRdtype(String rdtype) {
		this.rdtype = rdtype;
	}
	
	/**
	 * Column Info
	 * @param thdofc
	 */
	public void setThdofc(String thdofc) {
		this.thdofc = thdofc;
	}
	
	/**
	 * Column Info
	 * @param rgnBkgnbr
	 */
	public void setRgnBkgnbr(String rgnBkgnbr) {
		this.rgnBkgnbr = rgnBkgnbr;
	}
	
	/**
	 * Column Info
	 * @param blwgt
	 */
	public void setBlwgt(String blwgt) {
		this.blwgt = blwgt;
	}
	
	/**
	 * Column Info
	 * @param scno
	 */
	public void setScno(String scno) {
		this.scno = scno;
	}
	
	/**
	 * Column Info
	 * @param expo1
	 */
	public void setExpo1(String expo1) {
		this.expo1 = expo1;
	}
	
	/**
	 * Column Info
	 * @param eqrel
	 */
	public void setEqrel(String eqrel) {
		this.eqrel = eqrel;
	}
	
	/**
	 * Column Info
	 * @param ntfy5
	 */
	public void setNtfy5(String ntfy5) {
		this.ntfy5 = ntfy5;
	}
	
	/**
	 * Column Info
	 * @param ntfy4
	 */
	public void setNtfy4(String ntfy4) {
		this.ntfy4 = ntfy4;
	}
	
	/**
	 * Column Info
	 * @param commodity
	 */
	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}
	
	/**
	 * Column Info
	 * @param ntfy3
	 */
	public void setNtfy3(String ntfy3) {
		this.ntfy3 = ntfy3;
	}
	
	/**
	 * Column Info
	 * @param ntfy2
	 */
	public void setNtfy2(String ntfy2) {
		this.ntfy2 = ntfy2;
	}
	
	/**
	 * Column Info
	 * @param ntfy1
	 */
	public void setNtfy1(String ntfy1) {
		this.ntfy1 = ntfy1;
	}
	
	/**
	 * Column Info
	 * @param eqrtn
	 */
	public void setEqrtn(String eqrtn) {
		this.eqrtn = eqrtn;
	}
	
	/**
	 * Column Info
	 * @param ntfy2cn
	 */
	public void setNtfy2cn(String ntfy2cn) {
		this.ntfy2cn = ntfy2cn;
	}
	
	/**
	 * Column Info
	 * @param bkgnbr
	 */
	public void setBkgnbr(String bkgnbr) {
		this.bkgnbr = bkgnbr;
	}
	
	/**
	 * Column Info
	 * @param blcopy
	 */
	public void setBlcopy(String blcopy) {
		this.blcopy = blcopy;
	}
	
	/**
	 * Column Info
	 * @param rfano
	 */
	public void setRfano(String rfano) {
		this.rfano = rfano;
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
		setFfwdcd(JSPUtil.getParameter(request, prefix + "ffwdcd", ""));
		setRemark(JSPUtil.getParameter(request, prefix + "remark", ""));
		setNtfy25(JSPUtil.getParameter(request, prefix + "ntfy25", ""));
		setNtfy21(JSPUtil.getParameter(request, prefix + "ntfy21", ""));
		setBlpkgu(JSPUtil.getParameter(request, prefix + "blpkgu", ""));
		setNtfy22(JSPUtil.getParameter(request, prefix + "ntfy22", ""));
		setNtfy23(JSPUtil.getParameter(request, prefix + "ntfy23", ""));
		setNtfy24(JSPUtil.getParameter(request, prefix + "ntfy24", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setNtfytaxid(JSPUtil.getParameter(request, prefix + "ntfytaxid", ""));
		setCctofc(JSPUtil.getParameter(request, prefix + "cctofc", ""));
		setFfwdcn(JSPUtil.getParameter(request, prefix + "ffwdcn", ""));
		setBlmea(JSPUtil.getParameter(request, prefix + "blmea", ""));
		setExpo5(JSPUtil.getParameter(request, prefix + "expo5", ""));
		setExpo4(JSPUtil.getParameter(request, prefix + "expo4", ""));
		setExpo3(JSPUtil.getParameter(request, prefix + "expo3", ""));
		setExpo2(JSPUtil.getParameter(request, prefix + "expo2", ""));
		setUdCd(JSPUtil.getParameter(request, prefix + "ud_cd", ""));
		setExpocd(JSPUtil.getParameter(request, prefix + "expocd", ""));
		setExpocn(JSPUtil.getParameter(request, prefix + "expocn", ""));
		setNtfycn(JSPUtil.getParameter(request, prefix + "ntfycn", ""));
		setBlWgtUnit(JSPUtil.getParameter(request, prefix + "bl_wgt_unit", ""));
		setNtfy2nm(JSPUtil.getParameter(request, prefix + "ntfy2nm", ""));
		setPpdofc(JSPUtil.getParameter(request, prefix + "ppdofc", ""));
		setEqpickdt(JSPUtil.getParameter(request, prefix + "eqpickdt", ""));
		setBlpkg(JSPUtil.getParameter(request, prefix + "blpkg", ""));
		setAusQuar(JSPUtil.getParameter(request, prefix + "aus_quar", ""));
		setBlMeaUnit(JSPUtil.getParameter(request, prefix + "bl_mea_unit", ""));
		setCargotype(JSPUtil.getParameter(request, prefix + "cargotype", ""));
		setNtfycd(JSPUtil.getParameter(request, prefix + "ntfycd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFfwd5(JSPUtil.getParameter(request, prefix + "ffwd5", ""));
		setBlrepcmdcd(JSPUtil.getParameter(request, prefix + "blrepcmdcd", ""));
		setFfwd2(JSPUtil.getParameter(request, prefix + "ffwd2", ""));
		setFfwd1(JSPUtil.getParameter(request, prefix + "ffwd1", ""));
		setFfwd4(JSPUtil.getParameter(request, prefix + "ffwd4", ""));
		setFfwd3(JSPUtil.getParameter(request, prefix + "ffwd3", ""));
		setRdtype(JSPUtil.getParameter(request, prefix + "rdtype", ""));
		setThdofc(JSPUtil.getParameter(request, prefix + "thdofc", ""));
		setRgnBkgnbr(JSPUtil.getParameter(request, prefix + "rgn_bkgnbr", ""));
		setBlwgt(JSPUtil.getParameter(request, prefix + "blwgt", ""));
		setScno(JSPUtil.getParameter(request, prefix + "scno", ""));
		setExpo1(JSPUtil.getParameter(request, prefix + "expo1", ""));
		setEqrel(JSPUtil.getParameter(request, prefix + "eqrel", ""));
		setNtfy5(JSPUtil.getParameter(request, prefix + "ntfy5", ""));
		setNtfy4(JSPUtil.getParameter(request, prefix + "ntfy4", ""));
		setCommodity(JSPUtil.getParameter(request, prefix + "commodity", ""));
		setNtfy3(JSPUtil.getParameter(request, prefix + "ntfy3", ""));
		setNtfy2(JSPUtil.getParameter(request, prefix + "ntfy2", ""));
		setNtfy1(JSPUtil.getParameter(request, prefix + "ntfy1", ""));
		setEqrtn(JSPUtil.getParameter(request, prefix + "eqrtn", ""));
		setNtfy2cn(JSPUtil.getParameter(request, prefix + "ntfy2cn", ""));
		setBkgnbr(JSPUtil.getParameter(request, prefix + "bkgnbr", ""));
		setBlcopy(JSPUtil.getParameter(request, prefix + "blcopy", ""));
		setRfano(JSPUtil.getParameter(request, prefix + "rfano", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MxCustomerVO[]
	 */
	public MxCustomerVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MxCustomerVO[]
	 */
	public MxCustomerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MxCustomerVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ffwdcd = (JSPUtil.getParameter(request, prefix	+ "ffwdcd", length));
			String[] remark = (JSPUtil.getParameter(request, prefix	+ "remark", length));
			String[] ntfy25 = (JSPUtil.getParameter(request, prefix	+ "ntfy25", length));
			String[] ntfy21 = (JSPUtil.getParameter(request, prefix	+ "ntfy21", length));
			String[] blpkgu = (JSPUtil.getParameter(request, prefix	+ "blpkgu", length));
			String[] ntfy22 = (JSPUtil.getParameter(request, prefix	+ "ntfy22", length));
			String[] ntfy23 = (JSPUtil.getParameter(request, prefix	+ "ntfy23", length));
			String[] ntfy24 = (JSPUtil.getParameter(request, prefix	+ "ntfy24", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ntfytaxid = (JSPUtil.getParameter(request, prefix	+ "ntfytaxid", length));
			String[] cctofc = (JSPUtil.getParameter(request, prefix	+ "cctofc", length));
			String[] ffwdcn = (JSPUtil.getParameter(request, prefix	+ "ffwdcn", length));
			String[] blmea = (JSPUtil.getParameter(request, prefix	+ "blmea", length));
			String[] expo5 = (JSPUtil.getParameter(request, prefix	+ "expo5", length));
			String[] expo4 = (JSPUtil.getParameter(request, prefix	+ "expo4", length));
			String[] expo3 = (JSPUtil.getParameter(request, prefix	+ "expo3", length));
			String[] expo2 = (JSPUtil.getParameter(request, prefix	+ "expo2", length));
			String[] udCd = (JSPUtil.getParameter(request, prefix	+ "ud_cd", length));
			String[] expocd = (JSPUtil.getParameter(request, prefix	+ "expocd", length));
			String[] expocn = (JSPUtil.getParameter(request, prefix	+ "expocn", length));
			String[] ntfycn = (JSPUtil.getParameter(request, prefix	+ "ntfycn", length));
			String[] blWgtUnit = (JSPUtil.getParameter(request, prefix	+ "bl_wgt_unit", length));
			String[] ntfy2nm = (JSPUtil.getParameter(request, prefix	+ "ntfy2nm", length));
			String[] ppdofc = (JSPUtil.getParameter(request, prefix	+ "ppdofc", length));
			String[] eqpickdt = (JSPUtil.getParameter(request, prefix	+ "eqpickdt", length));
			String[] blpkg = (JSPUtil.getParameter(request, prefix	+ "blpkg", length));
			String[] ausQuar = (JSPUtil.getParameter(request, prefix	+ "aus_quar", length));
			String[] blMeaUnit = (JSPUtil.getParameter(request, prefix	+ "bl_mea_unit", length));
			String[] cargotype = (JSPUtil.getParameter(request, prefix	+ "cargotype", length));
			String[] ntfycd = (JSPUtil.getParameter(request, prefix	+ "ntfycd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ffwd5 = (JSPUtil.getParameter(request, prefix	+ "ffwd5", length));
			String[] blrepcmdcd = (JSPUtil.getParameter(request, prefix	+ "blrepcmdcd", length));
			String[] ffwd2 = (JSPUtil.getParameter(request, prefix	+ "ffwd2", length));
			String[] ffwd1 = (JSPUtil.getParameter(request, prefix	+ "ffwd1", length));
			String[] ffwd4 = (JSPUtil.getParameter(request, prefix	+ "ffwd4", length));
			String[] ffwd3 = (JSPUtil.getParameter(request, prefix	+ "ffwd3", length));
			String[] rdtype = (JSPUtil.getParameter(request, prefix	+ "rdtype", length));
			String[] thdofc = (JSPUtil.getParameter(request, prefix	+ "thdofc", length));
			String[] rgnBkgnbr = (JSPUtil.getParameter(request, prefix	+ "rgn_bkgnbr", length));
			String[] blwgt = (JSPUtil.getParameter(request, prefix	+ "blwgt", length));
			String[] scno = (JSPUtil.getParameter(request, prefix	+ "scno", length));
			String[] expo1 = (JSPUtil.getParameter(request, prefix	+ "expo1", length));
			String[] eqrel = (JSPUtil.getParameter(request, prefix	+ "eqrel", length));
			String[] ntfy5 = (JSPUtil.getParameter(request, prefix	+ "ntfy5", length));
			String[] ntfy4 = (JSPUtil.getParameter(request, prefix	+ "ntfy4", length));
			String[] commodity = (JSPUtil.getParameter(request, prefix	+ "commodity", length));
			String[] ntfy3 = (JSPUtil.getParameter(request, prefix	+ "ntfy3", length));
			String[] ntfy2 = (JSPUtil.getParameter(request, prefix	+ "ntfy2", length));
			String[] ntfy1 = (JSPUtil.getParameter(request, prefix	+ "ntfy1", length));
			String[] eqrtn = (JSPUtil.getParameter(request, prefix	+ "eqrtn", length));
			String[] ntfy2cn = (JSPUtil.getParameter(request, prefix	+ "ntfy2cn", length));
			String[] bkgnbr = (JSPUtil.getParameter(request, prefix	+ "bkgnbr", length));
			String[] blcopy = (JSPUtil.getParameter(request, prefix	+ "blcopy", length));
			String[] rfano = (JSPUtil.getParameter(request, prefix	+ "rfano", length));
			
			for (int i = 0; i < length; i++) {
				model = new MxCustomerVO();
				if (ffwdcd[i] != null)
					model.setFfwdcd(ffwdcd[i]);
				if (remark[i] != null)
					model.setRemark(remark[i]);
				if (ntfy25[i] != null)
					model.setNtfy25(ntfy25[i]);
				if (ntfy21[i] != null)
					model.setNtfy21(ntfy21[i]);
				if (blpkgu[i] != null)
					model.setBlpkgu(blpkgu[i]);
				if (ntfy22[i] != null)
					model.setNtfy22(ntfy22[i]);
				if (ntfy23[i] != null)
					model.setNtfy23(ntfy23[i]);
				if (ntfy24[i] != null)
					model.setNtfy24(ntfy24[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ntfytaxid[i] != null)
					model.setNtfytaxid(ntfytaxid[i]);
				if (cctofc[i] != null)
					model.setCctofc(cctofc[i]);
				if (ffwdcn[i] != null)
					model.setFfwdcn(ffwdcn[i]);
				if (blmea[i] != null)
					model.setBlmea(blmea[i]);
				if (expo5[i] != null)
					model.setExpo5(expo5[i]);
				if (expo4[i] != null)
					model.setExpo4(expo4[i]);
				if (expo3[i] != null)
					model.setExpo3(expo3[i]);
				if (expo2[i] != null)
					model.setExpo2(expo2[i]);
				if (udCd[i] != null)
					model.setUdCd(udCd[i]);
				if (expocd[i] != null)
					model.setExpocd(expocd[i]);
				if (expocn[i] != null)
					model.setExpocn(expocn[i]);
				if (ntfycn[i] != null)
					model.setNtfycn(ntfycn[i]);
				if (blWgtUnit[i] != null)
					model.setBlWgtUnit(blWgtUnit[i]);
				if (ntfy2nm[i] != null)
					model.setNtfy2nm(ntfy2nm[i]);
				if (ppdofc[i] != null)
					model.setPpdofc(ppdofc[i]);
				if (eqpickdt[i] != null)
					model.setEqpickdt(eqpickdt[i]);
				if (blpkg[i] != null)
					model.setBlpkg(blpkg[i]);
				if (ausQuar[i] != null)
					model.setAusQuar(ausQuar[i]);
				if (blMeaUnit[i] != null)
					model.setBlMeaUnit(blMeaUnit[i]);
				if (cargotype[i] != null)
					model.setCargotype(cargotype[i]);
				if (ntfycd[i] != null)
					model.setNtfycd(ntfycd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ffwd5[i] != null)
					model.setFfwd5(ffwd5[i]);
				if (blrepcmdcd[i] != null)
					model.setBlrepcmdcd(blrepcmdcd[i]);
				if (ffwd2[i] != null)
					model.setFfwd2(ffwd2[i]);
				if (ffwd1[i] != null)
					model.setFfwd1(ffwd1[i]);
				if (ffwd4[i] != null)
					model.setFfwd4(ffwd4[i]);
				if (ffwd3[i] != null)
					model.setFfwd3(ffwd3[i]);
				if (rdtype[i] != null)
					model.setRdtype(rdtype[i]);
				if (thdofc[i] != null)
					model.setThdofc(thdofc[i]);
				if (rgnBkgnbr[i] != null)
					model.setRgnBkgnbr(rgnBkgnbr[i]);
				if (blwgt[i] != null)
					model.setBlwgt(blwgt[i]);
				if (scno[i] != null)
					model.setScno(scno[i]);
				if (expo1[i] != null)
					model.setExpo1(expo1[i]);
				if (eqrel[i] != null)
					model.setEqrel(eqrel[i]);
				if (ntfy5[i] != null)
					model.setNtfy5(ntfy5[i]);
				if (ntfy4[i] != null)
					model.setNtfy4(ntfy4[i]);
				if (commodity[i] != null)
					model.setCommodity(commodity[i]);
				if (ntfy3[i] != null)
					model.setNtfy3(ntfy3[i]);
				if (ntfy2[i] != null)
					model.setNtfy2(ntfy2[i]);
				if (ntfy1[i] != null)
					model.setNtfy1(ntfy1[i]);
				if (eqrtn[i] != null)
					model.setEqrtn(eqrtn[i]);
				if (ntfy2cn[i] != null)
					model.setNtfy2cn(ntfy2cn[i]);
				if (bkgnbr[i] != null)
					model.setBkgnbr(bkgnbr[i]);
				if (blcopy[i] != null)
					model.setBlcopy(blcopy[i]);
				if (rfano[i] != null)
					model.setRfano(rfano[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMxCustomerVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MxCustomerVO[]
	 */
	public MxCustomerVO[] getMxCustomerVOs(){
		MxCustomerVO[] vos = (MxCustomerVO[])models.toArray(new MxCustomerVO[models.size()]);
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
		this.ffwdcd = this.ffwdcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark = this.remark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy25 = this.ntfy25 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy21 = this.ntfy21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpkgu = this.blpkgu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy22 = this.ntfy22 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy23 = this.ntfy23 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy24 = this.ntfy24 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfytaxid = this.ntfytaxid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctofc = this.cctofc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffwdcn = this.ffwdcn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blmea = this.blmea .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expo5 = this.expo5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expo4 = this.expo4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expo3 = this.expo3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expo2 = this.expo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.udCd = this.udCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expocd = this.expocd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expocn = this.expocn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfycn = this.ntfycn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blWgtUnit = this.blWgtUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy2nm = this.ntfy2nm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdofc = this.ppdofc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqpickdt = this.eqpickdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpkg = this.blpkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ausQuar = this.ausQuar .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blMeaUnit = this.blMeaUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargotype = this.cargotype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfycd = this.ntfycd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffwd5 = this.ffwd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blrepcmdcd = this.blrepcmdcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffwd2 = this.ffwd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffwd1 = this.ffwd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffwd4 = this.ffwd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffwd3 = this.ffwd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdtype = this.rdtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.thdofc = this.thdofc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnBkgnbr = this.rgnBkgnbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blwgt = this.blwgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scno = this.scno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expo1 = this.expo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqrel = this.eqrel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy5 = this.ntfy5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy4 = this.ntfy4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commodity = this.commodity .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy3 = this.ntfy3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy2 = this.ntfy2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy1 = this.ntfy1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqrtn = this.eqrtn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy2cn = this.ntfy2cn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgnbr = this.bkgnbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blcopy = this.blcopy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfano = this.rfano .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
