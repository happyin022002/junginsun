/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : RDRSummaryVO.java
*@FileTitle : RDRSummaryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.06
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2013.12.06 원종규 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo;

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
 * @author 원종규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RDRSummaryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RDRSummaryVO> models = new ArrayList<RDRSummaryVO>();
	
	/* Column Info */
	private String region = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String hc40Qty = null;
	/* Column Info */
	private String deadSlot = null;
	/* Column Info */
	private String fTotalTeu = null;
	/* Column Info */
	private String weekNo = null;
	/* Column Info */
	private String toWeekNo = null;
	/* Column Info */
	private String totAlloc = null;
	/* Column Info */
	private String frDt = null;
	/* Column Info */
	private String add45 = null;
	/* Column Info */
	private String type = null;
	/* Column Info */
	private String vpsDt = null;
	/* Column Info */
	private String lane = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String f4h = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bsa45 = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String frWeekNo = null;
	/* Column Info */
	private String e2h = null;
	/* Column Info */
	private String eQty = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String f2h = null;
	/* Column Info */
	private String hc20Qty = null;
	/* Column Info */
	private String e4h = null;
	/* Column Info */
	private String fQty = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String voyNo = null;
	/* Column Info */
	private String e40 = null;
	/* Column Info */
	private String f45 = null;
	/* Column Info */
	private String eWeight = null;
	/* Column Info */
	private String f20 = null;
	/* Column Info */
	private String eTotalTeu = null;
	/* Column Info */
	private String e45 = null;
	/* Column Info */
	private String f40 = null;
	/* Column Info */
	private String totWgt = null;
	/* Column Info */
	private String grandTotal = null;
	/* Column Info */
	private String addAkbb = null;
	/* Column Info */
	private String e20 = null;
	/* Column Info */
	private String add40 = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String oprCd = null;
	/* Column Info */
	private String add20 = null;
	/* Column Info */
	private String fWeight = null;
	/* Column Info */
	private String tWeight = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RDRSummaryVO() {}

	public RDRSummaryVO(String ibflag, String pagerows, String region, String vvd, String vslCd, String hc40Qty, String weekNo, String totAlloc, String frDt, String type, String add45, String vpsDt, String lane, String f4h, String bsa45, String pol, String e2h, String eQty, String dirCd, String f2h, String hc20Qty, String e4h, String fQty, String pod, String e40, String voyNo, String f45, String eWeight, String f20, String e45, String totWgt, String f40, String e20, String toDt, String add40, String slanCd, String oprCd, String add20, String fWeight, String frWeekNo, String toWeekNo, String addAkbb, String fTotalTeu, String eTotalTeu, String deadSlot, String grandTotal, String tWeight) {
		this.region = region;
		this.vslCd = vslCd;
		this.hc40Qty = hc40Qty;
		this.deadSlot = deadSlot;
		this.fTotalTeu = fTotalTeu;
		this.weekNo = weekNo;
		this.toWeekNo = toWeekNo;
		this.totAlloc = totAlloc;
		this.frDt = frDt;
		this.add45 = add45;
		this.type = type;
		this.vpsDt = vpsDt;
		this.lane = lane;
		this.pagerows = pagerows;
		this.f4h = f4h;
		this.ibflag = ibflag;
		this.bsa45 = bsa45;
		this.pol = pol;
		this.frWeekNo = frWeekNo;
		this.e2h = e2h;
		this.eQty = eQty;
		this.dirCd = dirCd;
		this.f2h = f2h;
		this.hc20Qty = hc20Qty;
		this.e4h = e4h;
		this.fQty = fQty;
		this.pod = pod;
		this.voyNo = voyNo;
		this.e40 = e40;
		this.f45 = f45;
		this.eWeight = eWeight;
		this.f20 = f20;
		this.eTotalTeu = eTotalTeu;
		this.e45 = e45;
		this.f40 = f40;
		this.totWgt = totWgt;
		this.grandTotal = grandTotal;
		this.addAkbb = addAkbb;
		this.e20 = e20;
		this.add40 = add40;
		this.toDt = toDt;
		this.vvd = vvd;
		this.slanCd = slanCd;
		this.oprCd = oprCd;
		this.add20 = add20;
		this.fWeight = fWeight;
		this.tWeight = tWeight;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("region", getRegion());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("hc40_qty", getHc40Qty());
		this.hashColumns.put("dead_slot", getDeadSlot());
		this.hashColumns.put("f_total_teu", getFTotalTeu());
		this.hashColumns.put("week_no", getWeekNo());
		this.hashColumns.put("to_week_no", getToWeekNo());
		this.hashColumns.put("tot_alloc", getTotAlloc());
		this.hashColumns.put("fr_dt", getFrDt());
		this.hashColumns.put("add_45", getAdd45());
		this.hashColumns.put("type", getType());
		this.hashColumns.put("vps_dt", getVpsDt());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("f_4h", getF4h());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bsa_45", getBsa45());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("fr_week_no", getFrWeekNo());
		this.hashColumns.put("e_2h", getE2h());
		this.hashColumns.put("e_qty", getEQty());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("f_2h", getF2h());
		this.hashColumns.put("hc20_qty", getHc20Qty());
		this.hashColumns.put("e_4h", getE4h());
		this.hashColumns.put("f_qty", getFQty());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("voy_no", getVoyNo());
		this.hashColumns.put("e_40", getE40());
		this.hashColumns.put("f_45", getF45());
		this.hashColumns.put("e_weight", getEWeight());
		this.hashColumns.put("f_20", getF20());
		this.hashColumns.put("e_total_teu", getETotalTeu());
		this.hashColumns.put("e_45", getE45());
		this.hashColumns.put("f_40", getF40());
		this.hashColumns.put("tot_wgt", getTotWgt());
		this.hashColumns.put("grand_total", getGrandTotal());
		this.hashColumns.put("add_akbb", getAddAkbb());
		this.hashColumns.put("e_20", getE20());
		this.hashColumns.put("add_40", getAdd40());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("opr_cd", getOprCd());
		this.hashColumns.put("add_20", getAdd20());
		this.hashColumns.put("f_weight", getFWeight());
		this.hashColumns.put("t_weight", getTWeight());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("region", "region");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("hc40_qty", "hc40Qty");
		this.hashFields.put("dead_slot", "deadSlot");
		this.hashFields.put("f_total_teu", "fTotalTeu");
		this.hashFields.put("week_no", "weekNo");
		this.hashFields.put("to_week_no", "toWeekNo");
		this.hashFields.put("tot_alloc", "totAlloc");
		this.hashFields.put("fr_dt", "frDt");
		this.hashFields.put("add_45", "add45");
		this.hashFields.put("type", "type");
		this.hashFields.put("vps_dt", "vpsDt");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("f_4h", "f4h");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bsa_45", "bsa45");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("fr_week_no", "frWeekNo");
		this.hashFields.put("e_2h", "e2h");
		this.hashFields.put("e_qty", "eQty");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("f_2h", "f2h");
		this.hashFields.put("hc20_qty", "hc20Qty");
		this.hashFields.put("e_4h", "e4h");
		this.hashFields.put("f_qty", "fQty");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("voy_no", "voyNo");
		this.hashFields.put("e_40", "e40");
		this.hashFields.put("f_45", "f45");
		this.hashFields.put("e_weight", "eWeight");
		this.hashFields.put("f_20", "f20");
		this.hashFields.put("e_total_teu", "eTotalTeu");
		this.hashFields.put("e_45", "e45");
		this.hashFields.put("f_40", "f40");
		this.hashFields.put("tot_wgt", "totWgt");
		this.hashFields.put("grand_total", "grandTotal");
		this.hashFields.put("add_akbb", "addAkbb");
		this.hashFields.put("e_20", "e20");
		this.hashFields.put("add_40", "add40");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("opr_cd", "oprCd");
		this.hashFields.put("add_20", "add20");
		this.hashFields.put("f_weight", "fWeight");
		this.hashFields.put("t_weight", "tWeight");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return region
	 */
	public String getRegion() {
		return this.region;
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
	 * @return hc40Qty
	 */
	public String getHc40Qty() {
		return this.hc40Qty;
	}
	
	/**
	 * Column Info
	 * @return deadSlot
	 */
	public String getDeadSlot() {
		return this.deadSlot;
	}
	
	/**
	 * Column Info
	 * @return fTotalTeu
	 */
	public String getFTotalTeu() {
		return this.fTotalTeu;
	}
	
	/**
	 * Column Info
	 * @return weekNo
	 */
	public String getWeekNo() {
		return this.weekNo;
	}
	
	/**
	 * Column Info
	 * @return toWeekNo
	 */
	public String getToWeekNo() {
		return this.toWeekNo;
	}
	
	/**
	 * Column Info
	 * @return totAlloc
	 */
	public String getTotAlloc() {
		return this.totAlloc;
	}
	
	/**
	 * Column Info
	 * @return frDt
	 */
	public String getFrDt() {
		return this.frDt;
	}
	
	/**
	 * Column Info
	 * @return add45
	 */
	public String getAdd45() {
		return this.add45;
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
	 * @return vpsDt
	 */
	public String getVpsDt() {
		return this.vpsDt;
	}
	
	/**
	 * Column Info
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
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
	 * @return f4h
	 */
	public String getF4h() {
		return this.f4h;
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
	 * @return bsa45
	 */
	public String getBsa45() {
		return this.bsa45;
	}
	
	/**
	 * Column Info
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}
	
	/**
	 * Column Info
	 * @return frWeekNo
	 */
	public String getFrWeekNo() {
		return this.frWeekNo;
	}
	
	/**
	 * Column Info
	 * @return e2h
	 */
	public String getE2h() {
		return this.e2h;
	}
	
	/**
	 * Column Info
	 * @return eQty
	 */
	public String getEQty() {
		return this.eQty;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return f2h
	 */
	public String getF2h() {
		return this.f2h;
	}
	
	/**
	 * Column Info
	 * @return hc20Qty
	 */
	public String getHc20Qty() {
		return this.hc20Qty;
	}
	
	/**
	 * Column Info
	 * @return e4h
	 */
	public String getE4h() {
		return this.e4h;
	}
	
	/**
	 * Column Info
	 * @return fQty
	 */
	public String getFQty() {
		return this.fQty;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}
	
	/**
	 * Column Info
	 * @return voyNo
	 */
	public String getVoyNo() {
		return this.voyNo;
	}
	
	/**
	 * Column Info
	 * @return e40
	 */
	public String getE40() {
		return this.e40;
	}
	
	/**
	 * Column Info
	 * @return f45
	 */
	public String getF45() {
		return this.f45;
	}
	
	/**
	 * Column Info
	 * @return eWeight
	 */
	public String getEWeight() {
		return this.eWeight;
	}
	
	/**
	 * Column Info
	 * @return f20
	 */
	public String getF20() {
		return this.f20;
	}
	
	/**
	 * Column Info
	 * @return eTotalTeu
	 */
	public String getETotalTeu() {
		return this.eTotalTeu;
	}
	
	/**
	 * Column Info
	 * @return e45
	 */
	public String getE45() {
		return this.e45;
	}
	
	/**
	 * Column Info
	 * @return f40
	 */
	public String getF40() {
		return this.f40;
	}
	
	/**
	 * Column Info
	 * @return totWgt
	 */
	public String getTotWgt() {
		return this.totWgt;
	}
	
	/**
	 * Column Info
	 * @return grandTotal
	 */
	public String getGrandTotal() {
		return this.grandTotal;
	}
	
	/**
	 * Column Info
	 * @return addAkbb
	 */
	public String getAddAkbb() {
		return this.addAkbb;
	}
	
	/**
	 * Column Info
	 * @return e20
	 */
	public String getE20() {
		return this.e20;
	}
	
	/**
	 * Column Info
	 * @return add40
	 */
	public String getAdd40() {
		return this.add40;
	}
	
	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
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
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return oprCd
	 */
	public String getOprCd() {
		return this.oprCd;
	}
	
	/**
	 * Column Info
	 * @return add20
	 */
	public String getAdd20() {
		return this.add20;
	}
	
	/**
	 * Column Info
	 * @return fWeight
	 */
	public String getFWeight() {
		return this.fWeight;
	}
	
	/**
	 * Column Info
	 * @return tWeight
	 */
	public String getTWeight() {
		return this.tWeight;
	}
	

	/**
	 * Column Info
	 * @param region
	 */
	public void setRegion(String region) {
		this.region = region;
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
	 * @param hc40Qty
	 */
	public void setHc40Qty(String hc40Qty) {
		this.hc40Qty = hc40Qty;
	}
	
	/**
	 * Column Info
	 * @param deadSlot
	 */
	public void setDeadSlot(String deadSlot) {
		this.deadSlot = deadSlot;
	}
	
	/**
	 * Column Info
	 * @param fTotalTeu
	 */
	public void setFTotalTeu(String fTotalTeu) {
		this.fTotalTeu = fTotalTeu;
	}
	
	/**
	 * Column Info
	 * @param weekNo
	 */
	public void setWeekNo(String weekNo) {
		this.weekNo = weekNo;
	}
	
	/**
	 * Column Info
	 * @param toWeekNo
	 */
	public void setToWeekNo(String toWeekNo) {
		this.toWeekNo = toWeekNo;
	}
	
	/**
	 * Column Info
	 * @param totAlloc
	 */
	public void setTotAlloc(String totAlloc) {
		this.totAlloc = totAlloc;
	}
	
	/**
	 * Column Info
	 * @param frDt
	 */
	public void setFrDt(String frDt) {
		this.frDt = frDt;
	}
	
	/**
	 * Column Info
	 * @param add45
	 */
	public void setAdd45(String add45) {
		this.add45 = add45;
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
	 * @param vpsDt
	 */
	public void setVpsDt(String vpsDt) {
		this.vpsDt = vpsDt;
	}
	
	/**
	 * Column Info
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
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
	 * @param f4h
	 */
	public void setF4h(String f4h) {
		this.f4h = f4h;
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
	 * @param bsa45
	 */
	public void setBsa45(String bsa45) {
		this.bsa45 = bsa45;
	}
	
	/**
	 * Column Info
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	/**
	 * Column Info
	 * @param frWeekNo
	 */
	public void setFrWeekNo(String frWeekNo) {
		this.frWeekNo = frWeekNo;
	}
	
	/**
	 * Column Info
	 * @param e2h
	 */
	public void setE2h(String e2h) {
		this.e2h = e2h;
	}
	
	/**
	 * Column Info
	 * @param eQty
	 */
	public void setEQty(String eQty) {
		this.eQty = eQty;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param f2h
	 */
	public void setF2h(String f2h) {
		this.f2h = f2h;
	}
	
	/**
	 * Column Info
	 * @param hc20Qty
	 */
	public void setHc20Qty(String hc20Qty) {
		this.hc20Qty = hc20Qty;
	}
	
	/**
	 * Column Info
	 * @param e4h
	 */
	public void setE4h(String e4h) {
		this.e4h = e4h;
	}
	
	/**
	 * Column Info
	 * @param fQty
	 */
	public void setFQty(String fQty) {
		this.fQty = fQty;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}
	
	/**
	 * Column Info
	 * @param voyNo
	 */
	public void setVoyNo(String voyNo) {
		this.voyNo = voyNo;
	}
	
	/**
	 * Column Info
	 * @param e40
	 */
	public void setE40(String e40) {
		this.e40 = e40;
	}
	
	/**
	 * Column Info
	 * @param f45
	 */
	public void setF45(String f45) {
		this.f45 = f45;
	}
	
	/**
	 * Column Info
	 * @param eWeight
	 */
	public void setEWeight(String eWeight) {
		this.eWeight = eWeight;
	}
	
	/**
	 * Column Info
	 * @param f20
	 */
	public void setF20(String f20) {
		this.f20 = f20;
	}
	
	/**
	 * Column Info
	 * @param eTotalTeu
	 */
	public void setETotalTeu(String eTotalTeu) {
		this.eTotalTeu = eTotalTeu;
	}
	
	/**
	 * Column Info
	 * @param e45
	 */
	public void setE45(String e45) {
		this.e45 = e45;
	}
	
	/**
	 * Column Info
	 * @param f40
	 */
	public void setF40(String f40) {
		this.f40 = f40;
	}
	
	/**
	 * Column Info
	 * @param totWgt
	 */
	public void setTotWgt(String totWgt) {
		this.totWgt = totWgt;
	}
	
	/**
	 * Column Info
	 * @param grandTotal
	 */
	public void setGrandTotal(String grandTotal) {
		this.grandTotal = grandTotal;
	}
	
	/**
	 * Column Info
	 * @param addAkbb
	 */
	public void setAddAkbb(String addAkbb) {
		this.addAkbb = addAkbb;
	}
	
	/**
	 * Column Info
	 * @param e20
	 */
	public void setE20(String e20) {
		this.e20 = e20;
	}
	
	/**
	 * Column Info
	 * @param add40
	 */
	public void setAdd40(String add40) {
		this.add40 = add40;
	}
	
	/**
	 * Column Info
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
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
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param oprCd
	 */
	public void setOprCd(String oprCd) {
		this.oprCd = oprCd;
	}
	
	/**
	 * Column Info
	 * @param add20
	 */
	public void setAdd20(String add20) {
		this.add20 = add20;
	}
	
	/**
	 * Column Info
	 * @param fWeight
	 */
	public void setFWeight(String fWeight) {
		this.fWeight = fWeight;
	}
	
	/**
	 * Column Info
	 * @param tWeight
	 */
	public void setTWeight(String tWeight) {
		this.tWeight = tWeight;
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
		setRegion(JSPUtil.getParameter(request, prefix + "region", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setHc40Qty(JSPUtil.getParameter(request, prefix + "hc40_qty", ""));
		setDeadSlot(JSPUtil.getParameter(request, prefix + "dead_slot", ""));
		setFTotalTeu(JSPUtil.getParameter(request, prefix + "f_total_teu", ""));
		setWeekNo(JSPUtil.getParameter(request, prefix + "week_no", ""));
		setToWeekNo(JSPUtil.getParameter(request, prefix + "to_week_no", ""));
		setTotAlloc(JSPUtil.getParameter(request, prefix + "tot_alloc", ""));
		setFrDt(JSPUtil.getParameter(request, prefix + "fr_dt", ""));
		setAdd45(JSPUtil.getParameter(request, prefix + "add_45", ""));
		setType(JSPUtil.getParameter(request, prefix + "type", ""));
		setVpsDt(JSPUtil.getParameter(request, prefix + "vps_dt", ""));
		setLane(JSPUtil.getParameter(request, prefix + "lane", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setF4h(JSPUtil.getParameter(request, prefix + "f_4h", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBsa45(JSPUtil.getParameter(request, prefix + "bsa_45", ""));
		setPol(JSPUtil.getParameter(request, prefix + "pol", ""));
		setFrWeekNo(JSPUtil.getParameter(request, prefix + "fr_week_no", ""));
		setE2h(JSPUtil.getParameter(request, prefix + "e_2h", ""));
		setEQty(JSPUtil.getParameter(request, prefix + "e_qty", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setF2h(JSPUtil.getParameter(request, prefix + "f_2h", ""));
		setHc20Qty(JSPUtil.getParameter(request, prefix + "hc20_qty", ""));
		setE4h(JSPUtil.getParameter(request, prefix + "e_4h", ""));
		setFQty(JSPUtil.getParameter(request, prefix + "f_qty", ""));
		setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
		setVoyNo(JSPUtil.getParameter(request, prefix + "voy_no", ""));
		setE40(JSPUtil.getParameter(request, prefix + "e_40", ""));
		setF45(JSPUtil.getParameter(request, prefix + "f_45", ""));
		setEWeight(JSPUtil.getParameter(request, prefix + "e_weight", ""));
		setF20(JSPUtil.getParameter(request, prefix + "f_20", ""));
		setETotalTeu(JSPUtil.getParameter(request, prefix + "e_total_teu", ""));
		setE45(JSPUtil.getParameter(request, prefix + "e_45", ""));
		setF40(JSPUtil.getParameter(request, prefix + "f_40", ""));
		setTotWgt(JSPUtil.getParameter(request, prefix + "tot_wgt", ""));
		setGrandTotal(JSPUtil.getParameter(request, prefix + "grand_total", ""));
		setAddAkbb(JSPUtil.getParameter(request, prefix + "add_akbb", ""));
		setE20(JSPUtil.getParameter(request, prefix + "e_20", ""));
		setAdd40(JSPUtil.getParameter(request, prefix + "add_40", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setOprCd(JSPUtil.getParameter(request, prefix + "opr_cd", ""));
		setAdd20(JSPUtil.getParameter(request, prefix + "add_20", ""));
		setFWeight(JSPUtil.getParameter(request, prefix + "f_weight", ""));
		setTWeight(JSPUtil.getParameter(request, prefix + "t_weight", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RDRSummaryVO[]
	 */
	public RDRSummaryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RDRSummaryVO[]
	 */
	public RDRSummaryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RDRSummaryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] region = (JSPUtil.getParameter(request, prefix	+ "region", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] hc40Qty = (JSPUtil.getParameter(request, prefix	+ "hc40_qty", length));
			String[] deadSlot = (JSPUtil.getParameter(request, prefix	+ "dead_slot", length));
			String[] fTotalTeu = (JSPUtil.getParameter(request, prefix	+ "f_total_teu", length));
			String[] weekNo = (JSPUtil.getParameter(request, prefix	+ "week_no", length));
			String[] toWeekNo = (JSPUtil.getParameter(request, prefix	+ "to_week_no", length));
			String[] totAlloc = (JSPUtil.getParameter(request, prefix	+ "tot_alloc", length));
			String[] frDt = (JSPUtil.getParameter(request, prefix	+ "fr_dt", length));
			String[] add45 = (JSPUtil.getParameter(request, prefix	+ "add_45", length));
			String[] type = (JSPUtil.getParameter(request, prefix	+ "type", length));
			String[] vpsDt = (JSPUtil.getParameter(request, prefix	+ "vps_dt", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] f4h = (JSPUtil.getParameter(request, prefix	+ "f_4h", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bsa45 = (JSPUtil.getParameter(request, prefix	+ "bsa_45", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] frWeekNo = (JSPUtil.getParameter(request, prefix	+ "fr_week_no", length));
			String[] e2h = (JSPUtil.getParameter(request, prefix	+ "e_2h", length));
			String[] eQty = (JSPUtil.getParameter(request, prefix	+ "e_qty", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] f2h = (JSPUtil.getParameter(request, prefix	+ "f_2h", length));
			String[] hc20Qty = (JSPUtil.getParameter(request, prefix	+ "hc20_qty", length));
			String[] e4h = (JSPUtil.getParameter(request, prefix	+ "e_4h", length));
			String[] fQty = (JSPUtil.getParameter(request, prefix	+ "f_qty", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] voyNo = (JSPUtil.getParameter(request, prefix	+ "voy_no", length));
			String[] e40 = (JSPUtil.getParameter(request, prefix	+ "e_40", length));
			String[] f45 = (JSPUtil.getParameter(request, prefix	+ "f_45", length));
			String[] eWeight = (JSPUtil.getParameter(request, prefix	+ "e_weight", length));
			String[] f20 = (JSPUtil.getParameter(request, prefix	+ "f_20", length));
			String[] eTotalTeu = (JSPUtil.getParameter(request, prefix	+ "e_total_teu", length));
			String[] e45 = (JSPUtil.getParameter(request, prefix	+ "e_45", length));
			String[] f40 = (JSPUtil.getParameter(request, prefix	+ "f_40", length));
			String[] totWgt = (JSPUtil.getParameter(request, prefix	+ "tot_wgt", length));
			String[] grandTotal = (JSPUtil.getParameter(request, prefix	+ "grand_total", length));
			String[] addAkbb = (JSPUtil.getParameter(request, prefix	+ "add_akbb", length));
			String[] e20 = (JSPUtil.getParameter(request, prefix	+ "e_20", length));
			String[] add40 = (JSPUtil.getParameter(request, prefix	+ "add_40", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] oprCd = (JSPUtil.getParameter(request, prefix	+ "opr_cd", length));
			String[] add20 = (JSPUtil.getParameter(request, prefix	+ "add_20", length));
			String[] fWeight = (JSPUtil.getParameter(request, prefix	+ "f_weight", length));
			String[] tWeight = (JSPUtil.getParameter(request, prefix	+ "t_weight", length));
			
			for (int i = 0; i < length; i++) {
				model = new RDRSummaryVO();
				if (region[i] != null)
					model.setRegion(region[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (hc40Qty[i] != null)
					model.setHc40Qty(hc40Qty[i]);
				if (deadSlot[i] != null)
					model.setDeadSlot(deadSlot[i]);
				if (fTotalTeu[i] != null)
					model.setFTotalTeu(fTotalTeu[i]);
				if (weekNo[i] != null)
					model.setWeekNo(weekNo[i]);
				if (toWeekNo[i] != null)
					model.setToWeekNo(toWeekNo[i]);
				if (totAlloc[i] != null)
					model.setTotAlloc(totAlloc[i]);
				if (frDt[i] != null)
					model.setFrDt(frDt[i]);
				if (add45[i] != null)
					model.setAdd45(add45[i]);
				if (type[i] != null)
					model.setType(type[i]);
				if (vpsDt[i] != null)
					model.setVpsDt(vpsDt[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (f4h[i] != null)
					model.setF4h(f4h[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bsa45[i] != null)
					model.setBsa45(bsa45[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (frWeekNo[i] != null)
					model.setFrWeekNo(frWeekNo[i]);
				if (e2h[i] != null)
					model.setE2h(e2h[i]);
				if (eQty[i] != null)
					model.setEQty(eQty[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (f2h[i] != null)
					model.setF2h(f2h[i]);
				if (hc20Qty[i] != null)
					model.setHc20Qty(hc20Qty[i]);
				if (e4h[i] != null)
					model.setE4h(e4h[i]);
				if (fQty[i] != null)
					model.setFQty(fQty[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (voyNo[i] != null)
					model.setVoyNo(voyNo[i]);
				if (e40[i] != null)
					model.setE40(e40[i]);
				if (f45[i] != null)
					model.setF45(f45[i]);
				if (eWeight[i] != null)
					model.setEWeight(eWeight[i]);
				if (f20[i] != null)
					model.setF20(f20[i]);
				if (eTotalTeu[i] != null)
					model.setETotalTeu(eTotalTeu[i]);
				if (e45[i] != null)
					model.setE45(e45[i]);
				if (f40[i] != null)
					model.setF40(f40[i]);
				if (totWgt[i] != null)
					model.setTotWgt(totWgt[i]);
				if (grandTotal[i] != null)
					model.setGrandTotal(grandTotal[i]);
				if (addAkbb[i] != null)
					model.setAddAkbb(addAkbb[i]);
				if (e20[i] != null)
					model.setE20(e20[i]);
				if (add40[i] != null)
					model.setAdd40(add40[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (oprCd[i] != null)
					model.setOprCd(oprCd[i]);
				if (add20[i] != null)
					model.setAdd20(add20[i]);
				if (fWeight[i] != null)
					model.setFWeight(fWeight[i]);
				if (tWeight[i] != null)
					model.setTWeight(tWeight[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRDRSummaryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RDRSummaryVO[]
	 */
	public RDRSummaryVO[] getRDRSummaryVOs(){
		RDRSummaryVO[] vos = (RDRSummaryVO[])models.toArray(new RDRSummaryVO[models.size()]);
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
		this.region = this.region .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hc40Qty = this.hc40Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deadSlot = this.deadSlot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fTotalTeu = this.fTotalTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.weekNo = this.weekNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toWeekNo = this.toWeekNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totAlloc = this.totAlloc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frDt = this.frDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.add45 = this.add45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.type = this.type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsDt = this.vpsDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f4h = this.f4h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa45 = this.bsa45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frWeekNo = this.frWeekNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.e2h = this.e2h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eQty = this.eQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f2h = this.f2h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hc20Qty = this.hc20Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.e4h = this.e4h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fQty = this.fQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voyNo = this.voyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.e40 = this.e40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f45 = this.f45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eWeight = this.eWeight .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f20 = this.f20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eTotalTeu = this.eTotalTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.e45 = this.e45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f40 = this.f40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totWgt = this.totWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grandTotal = this.grandTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addAkbb = this.addAkbb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.e20 = this.e20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.add40 = this.add40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oprCd = this.oprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.add20 = this.add20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fWeight = this.fWeight .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tWeight = this.tWeight .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
