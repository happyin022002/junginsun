/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RdrCreatInfoVO.java
*@FileTitle : RdrCreatInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.11
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.03.11 장강철 
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
 * @author 장강철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RdrCreatInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RdrCreatInfoVO> models = new ArrayList<RdrCreatInfoVO>();
	
	/* Column Info */
	private String eta = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String hc40Qty = null;
	/* Column Info */
	private String remark = null;
	/* Column Info */
	private String segment = null;
	/* Column Info */
	private String hc40Rat = null;
	/* Column Info */
	private String type = null;
	/* Column Info */
	private String rdrDate = null;
	/* Column Info */
	private String podIso = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String hc45 = null;
	/* Column Info */
	private String unRat45 = null;
	/* Column Info */
	private String bsa45 = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String empty = null;
	/* Column Info */
	private String arrTime = null;
	/* Column Info */
	private String slotHc = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String nextPort = null;
	/* Column Info */
	private String depTime = null;
	/* Column Info */
	private String slotAdd = null;
	/* Column Info */
	private String nisDate = null;
	/* Column Info */
	private String ratioType = null;
	/* Column Info */
	private String updateTime = null;
	/* Column Info */
	private String totWgt = null;
	/* Column Info */
	private String qty = null;
	/* Column Info */
	private String qty40 = null;
	/* Column Info */
	private String akbb = null;
	/* Column Info */
	private String totalSlot = null;
	/* Column Info */
	private String etaCanal = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String add20 = null;
	/* Column Info */
	private String load20 = null;
	/* Column Info */
	private String hc20Rate = null;
	/* Column Info */
	private String unberthTime = null;
	/* Column Info */
	private String updateUser = null;
	/* Column Info */
	private String region = null;
	/* Column Info */
	private String weight = null;
	/* Column Info */
	private String totAlloc = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String swapSlot = null;
	/* Column Info */
	private String add45 = null;
	/* Column Info */
	private String slot45 = null;
	/* Column Info */
	private String releaseSlot = null;
	/* Column Info */
	private String updateSys = null;
	/* Column Info */
	private String callInd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String headPortCd = null;
	/* Column Info */
	private String slotHc20 = null;
	/* Column Info */
	private String full = null;
	/* Column Info */
	private String teuWgt = null;
	/* Column Info */
	private String berthTime = null;
	/* Column Info */
	private String nextCanal = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String totalWgt = null;
	/* Column Info */
	private String hc20Qty = null;
	/* Column Info */
	private String bsaType = null;
	/* Column Info */
	private String qty20 = null;
	/* Column Info */
	private String voyNo = null;
	/* Column Info */
	private String swapWgt = null;
	/* Column Info */
	private String releaseWgt = null;
	/* Column Info */
	private String basicSlot = null;
	/* Column Info */
	private String ovRat45 = null;
	/* Column Info */
	private String basicWgt = null;
	/* Column Info */
	private String slotQty = null;
	/* Column Info */
	private String rdrUser = null;
	/* Column Info */
	private String cntrType = null;
	/* Column Info */
	private String add40 = null;
	/* Column Info */
	private String cntrSize = null;
	/* Column Info */
	private String oprCd = null;
	/* Column Info */
	private String load40 = null;
	/* Column Info */
	private String load45 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RdrCreatInfoVO() {}

	public RdrCreatInfoVO(String ibflag, String pagerows, String portCd, String arrTime, String berthTime, String unberthTime, String depTime, String creUsrId, String creDt, String vslCd, String voyNo, String dirCd, String rdrDate, String rdrUser, String nisDate, String remark, String updateUser, String updateTime, String nextPort, String eta, String nextCanal, String etaCanal, String updateSys, String region, String callInd, String headPortCd, String oprCd, String type, String slotQty, String weight, String slotHc, String slot45, String slotAdd, String slotHc20, String full, String empty, String akbb, String hc45, String totalSlot, String totalWgt, String load20, String hc20Qty, String hc20Rate, String add20, String load40, String hc40Qty, String hc40Rat, String add40, String load45, String bsa45, String unRat45, String ovRat45, String add45, String ratioType, String pol, String pod, String qty20, String qty40, String cntrType, String cntrSize, String qty, String podIso, String basicSlot, String swapSlot, String releaseSlot, String totAlloc, String basicWgt, String releaseWgt, String swapWgt, String totWgt, String teuWgt, String bsaType, String segment) {
		this.eta = eta;
		this.vslCd = vslCd;
		this.hc40Qty = hc40Qty;
		this.remark = remark;
		this.segment = segment;
		this.hc40Rat = hc40Rat;
		this.type = type;
		this.rdrDate = rdrDate;
		this.podIso = podIso;
		this.pagerows = pagerows;
		this.hc45 = hc45;
		this.unRat45 = unRat45;
		this.bsa45 = bsa45;
		this.pol = pol;
		this.empty = empty;
		this.arrTime = arrTime;
		this.slotHc = slotHc;
		this.pod = pod;
		this.nextPort = nextPort;
		this.depTime = depTime;
		this.slotAdd = slotAdd;
		this.nisDate = nisDate;
		this.ratioType = ratioType;
		this.updateTime = updateTime;
		this.totWgt = totWgt;
		this.qty = qty;
		this.qty40 = qty40;
		this.akbb = akbb;
		this.totalSlot = totalSlot;
		this.etaCanal = etaCanal;
		this.creUsrId = creUsrId;
		this.add20 = add20;
		this.load20 = load20;
		this.hc20Rate = hc20Rate;
		this.unberthTime = unberthTime;
		this.updateUser = updateUser;
		this.region = region;
		this.weight = weight;
		this.totAlloc = totAlloc;
		this.creDt = creDt;
		this.swapSlot = swapSlot;
		this.add45 = add45;
		this.slot45 = slot45;
		this.releaseSlot = releaseSlot;
		this.updateSys = updateSys;
		this.callInd = callInd;
		this.ibflag = ibflag;
		this.headPortCd = headPortCd;
		this.slotHc20 = slotHc20;
		this.full = full;
		this.teuWgt = teuWgt;
		this.berthTime = berthTime;
		this.nextCanal = nextCanal;
		this.dirCd = dirCd;
		this.portCd = portCd;
		this.totalWgt = totalWgt;
		this.hc20Qty = hc20Qty;
		this.bsaType = bsaType;
		this.qty20 = qty20;
		this.voyNo = voyNo;
		this.swapWgt = swapWgt;
		this.releaseWgt = releaseWgt;
		this.basicSlot = basicSlot;
		this.ovRat45 = ovRat45;
		this.basicWgt = basicWgt;
		this.slotQty = slotQty;
		this.rdrUser = rdrUser;
		this.cntrType = cntrType;
		this.add40 = add40;
		this.cntrSize = cntrSize;
		this.oprCd = oprCd;
		this.load40 = load40;
		this.load45 = load45;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eta", getEta());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("hc40_qty", getHc40Qty());
		this.hashColumns.put("remark", getRemark());
		this.hashColumns.put("segment", getSegment());
		this.hashColumns.put("hc40_rat", getHc40Rat());
		this.hashColumns.put("type", getType());
		this.hashColumns.put("rdr_date", getRdrDate());
		this.hashColumns.put("pod_iso", getPodIso());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("hc45", getHc45());
		this.hashColumns.put("un_rat_45", getUnRat45());
		this.hashColumns.put("bsa_45", getBsa45());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("empty", getEmpty());
		this.hashColumns.put("arr_time", getArrTime());
		this.hashColumns.put("slot_hc", getSlotHc());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("next_port", getNextPort());
		this.hashColumns.put("dep_time", getDepTime());
		this.hashColumns.put("slot_add", getSlotAdd());
		this.hashColumns.put("nis_date", getNisDate());
		this.hashColumns.put("ratio_type", getRatioType());
		this.hashColumns.put("update_time", getUpdateTime());
		this.hashColumns.put("tot_wgt", getTotWgt());
		this.hashColumns.put("qty", getQty());
		this.hashColumns.put("qty_40", getQty40());
		this.hashColumns.put("akbb", getAkbb());
		this.hashColumns.put("total_slot", getTotalSlot());
		this.hashColumns.put("eta_canal", getEtaCanal());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("add_20", getAdd20());
		this.hashColumns.put("load_20", getLoad20());
		this.hashColumns.put("hc20_rate", getHc20Rate());
		this.hashColumns.put("unberth_time", getUnberthTime());
		this.hashColumns.put("update_user", getUpdateUser());
		this.hashColumns.put("region", getRegion());
		this.hashColumns.put("weight", getWeight());
		this.hashColumns.put("tot_alloc", getTotAlloc());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("swap_slot", getSwapSlot());
		this.hashColumns.put("add_45", getAdd45());
		this.hashColumns.put("slot_45", getSlot45());
		this.hashColumns.put("release_slot", getReleaseSlot());
		this.hashColumns.put("update_sys", getUpdateSys());
		this.hashColumns.put("call_ind", getCallInd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("head_port_cd", getHeadPortCd());
		this.hashColumns.put("slot_hc20", getSlotHc20());
		this.hashColumns.put("full", getFull());
		this.hashColumns.put("teu_wgt", getTeuWgt());
		this.hashColumns.put("berth_time", getBerthTime());
		this.hashColumns.put("next_canal", getNextCanal());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("total_wgt", getTotalWgt());
		this.hashColumns.put("hc20_qty", getHc20Qty());
		this.hashColumns.put("bsa_type", getBsaType());
		this.hashColumns.put("qty_20", getQty20());
		this.hashColumns.put("voy_no", getVoyNo());
		this.hashColumns.put("swap_wgt", getSwapWgt());
		this.hashColumns.put("release_wgt", getReleaseWgt());
		this.hashColumns.put("basic_slot", getBasicSlot());
		this.hashColumns.put("ov_rat_45", getOvRat45());
		this.hashColumns.put("basic_wgt", getBasicWgt());
		this.hashColumns.put("slot_qty", getSlotQty());
		this.hashColumns.put("rdr_user", getRdrUser());
		this.hashColumns.put("cntr_type", getCntrType());
		this.hashColumns.put("add_40", getAdd40());
		this.hashColumns.put("cntr_size", getCntrSize());
		this.hashColumns.put("opr_cd", getOprCd());
		this.hashColumns.put("load_40", getLoad40());
		this.hashColumns.put("load_45", getLoad45());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eta", "eta");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("hc40_qty", "hc40Qty");
		this.hashFields.put("remark", "remark");
		this.hashFields.put("segment", "segment");
		this.hashFields.put("hc40_rat", "hc40Rat");
		this.hashFields.put("type", "type");
		this.hashFields.put("rdr_date", "rdrDate");
		this.hashFields.put("pod_iso", "podIso");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("hc45", "hc45");
		this.hashFields.put("un_rat_45", "unRat45");
		this.hashFields.put("bsa_45", "bsa45");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("empty", "empty");
		this.hashFields.put("arr_time", "arrTime");
		this.hashFields.put("slot_hc", "slotHc");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("next_port", "nextPort");
		this.hashFields.put("dep_time", "depTime");
		this.hashFields.put("slot_add", "slotAdd");
		this.hashFields.put("nis_date", "nisDate");
		this.hashFields.put("ratio_type", "ratioType");
		this.hashFields.put("update_time", "updateTime");
		this.hashFields.put("tot_wgt", "totWgt");
		this.hashFields.put("qty", "qty");
		this.hashFields.put("qty_40", "qty40");
		this.hashFields.put("akbb", "akbb");
		this.hashFields.put("total_slot", "totalSlot");
		this.hashFields.put("eta_canal", "etaCanal");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("add_20", "add20");
		this.hashFields.put("load_20", "load20");
		this.hashFields.put("hc20_rate", "hc20Rate");
		this.hashFields.put("unberth_time", "unberthTime");
		this.hashFields.put("update_user", "updateUser");
		this.hashFields.put("region", "region");
		this.hashFields.put("weight", "weight");
		this.hashFields.put("tot_alloc", "totAlloc");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("swap_slot", "swapSlot");
		this.hashFields.put("add_45", "add45");
		this.hashFields.put("slot_45", "slot45");
		this.hashFields.put("release_slot", "releaseSlot");
		this.hashFields.put("update_sys", "updateSys");
		this.hashFields.put("call_ind", "callInd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("head_port_cd", "headPortCd");
		this.hashFields.put("slot_hc20", "slotHc20");
		this.hashFields.put("full", "full");
		this.hashFields.put("teu_wgt", "teuWgt");
		this.hashFields.put("berth_time", "berthTime");
		this.hashFields.put("next_canal", "nextCanal");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("total_wgt", "totalWgt");
		this.hashFields.put("hc20_qty", "hc20Qty");
		this.hashFields.put("bsa_type", "bsaType");
		this.hashFields.put("qty_20", "qty20");
		this.hashFields.put("voy_no", "voyNo");
		this.hashFields.put("swap_wgt", "swapWgt");
		this.hashFields.put("release_wgt", "releaseWgt");
		this.hashFields.put("basic_slot", "basicSlot");
		this.hashFields.put("ov_rat_45", "ovRat45");
		this.hashFields.put("basic_wgt", "basicWgt");
		this.hashFields.put("slot_qty", "slotQty");
		this.hashFields.put("rdr_user", "rdrUser");
		this.hashFields.put("cntr_type", "cntrType");
		this.hashFields.put("add_40", "add40");
		this.hashFields.put("cntr_size", "cntrSize");
		this.hashFields.put("opr_cd", "oprCd");
		this.hashFields.put("load_40", "load40");
		this.hashFields.put("load_45", "load45");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return eta
	 */
	public String getEta() {
		return this.eta;
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
	 * @return remark
	 */
	public String getRemark() {
		return this.remark;
	}
	
	/**
	 * Column Info
	 * @return segment
	 */
	public String getSegment() {
		return this.segment;
	}
	
	/**
	 * Column Info
	 * @return hc40Rat
	 */
	public String getHc40Rat() {
		return this.hc40Rat;
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
	 * @return rdrDate
	 */
	public String getRdrDate() {
		return this.rdrDate;
	}
	
	/**
	 * Column Info
	 * @return podIso
	 */
	public String getPodIso() {
		return this.podIso;
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
	 * @return hc45
	 */
	public String getHc45() {
		return this.hc45;
	}
	
	/**
	 * Column Info
	 * @return unRat45
	 */
	public String getUnRat45() {
		return this.unRat45;
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
	 * @return empty
	 */
	public String getEmpty() {
		return this.empty;
	}
	
	/**
	 * Column Info
	 * @return arrTime
	 */
	public String getArrTime() {
		return this.arrTime;
	}
	
	/**
	 * Column Info
	 * @return slotHc
	 */
	public String getSlotHc() {
		return this.slotHc;
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
	 * @return nextPort
	 */
	public String getNextPort() {
		return this.nextPort;
	}
	
	/**
	 * Column Info
	 * @return depTime
	 */
	public String getDepTime() {
		return this.depTime;
	}
	
	/**
	 * Column Info
	 * @return slotAdd
	 */
	public String getSlotAdd() {
		return this.slotAdd;
	}
	
	/**
	 * Column Info
	 * @return nisDate
	 */
	public String getNisDate() {
		return this.nisDate;
	}
	
	/**
	 * Column Info
	 * @return ratioType
	 */
	public String getRatioType() {
		return this.ratioType;
	}
	
	/**
	 * Column Info
	 * @return updateTime
	 */
	public String getUpdateTime() {
		return this.updateTime;
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
	 * @return qty
	 */
	public String getQty() {
		return this.qty;
	}
	
	/**
	 * Column Info
	 * @return qty40
	 */
	public String getQty40() {
		return this.qty40;
	}
	
	/**
	 * Column Info
	 * @return akbb
	 */
	public String getAkbb() {
		return this.akbb;
	}
	
	/**
	 * Column Info
	 * @return totalSlot
	 */
	public String getTotalSlot() {
		return this.totalSlot;
	}
	
	/**
	 * Column Info
	 * @return etaCanal
	 */
	public String getEtaCanal() {
		return this.etaCanal;
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
	 * @return add20
	 */
	public String getAdd20() {
		return this.add20;
	}
	
	/**
	 * Column Info
	 * @return load20
	 */
	public String getLoad20() {
		return this.load20;
	}
	
	/**
	 * Column Info
	 * @return hc20Rate
	 */
	public String getHc20Rate() {
		return this.hc20Rate;
	}
	
	/**
	 * Column Info
	 * @return unberthTime
	 */
	public String getUnberthTime() {
		return this.unberthTime;
	}
	
	/**
	 * Column Info
	 * @return updateUser
	 */
	public String getUpdateUser() {
		return this.updateUser;
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
	 * @return weight
	 */
	public String getWeight() {
		return this.weight;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return swapSlot
	 */
	public String getSwapSlot() {
		return this.swapSlot;
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
	 * @return slot45
	 */
	public String getSlot45() {
		return this.slot45;
	}
	
	/**
	 * Column Info
	 * @return releaseSlot
	 */
	public String getReleaseSlot() {
		return this.releaseSlot;
	}
	
	/**
	 * Column Info
	 * @return updateSys
	 */
	public String getUpdateSys() {
		return this.updateSys;
	}
	
	/**
	 * Column Info
	 * @return callInd
	 */
	public String getCallInd() {
		return this.callInd;
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
	 * @return headPortCd
	 */
	public String getHeadPortCd() {
		return this.headPortCd;
	}
	
	/**
	 * Column Info
	 * @return slotHc20
	 */
	public String getSlotHc20() {
		return this.slotHc20;
	}
	
	/**
	 * Column Info
	 * @return full
	 */
	public String getFull() {
		return this.full;
	}
	
	/**
	 * Column Info
	 * @return teuWgt
	 */
	public String getTeuWgt() {
		return this.teuWgt;
	}
	
	/**
	 * Column Info
	 * @return berthTime
	 */
	public String getBerthTime() {
		return this.berthTime;
	}
	
	/**
	 * Column Info
	 * @return nextCanal
	 */
	public String getNextCanal() {
		return this.nextCanal;
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
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return totalWgt
	 */
	public String getTotalWgt() {
		return this.totalWgt;
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
	 * @return bsaType
	 */
	public String getBsaType() {
		return this.bsaType;
	}
	
	/**
	 * Column Info
	 * @return qty20
	 */
	public String getQty20() {
		return this.qty20;
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
	 * @return swapWgt
	 */
	public String getSwapWgt() {
		return this.swapWgt;
	}
	
	/**
	 * Column Info
	 * @return releaseWgt
	 */
	public String getReleaseWgt() {
		return this.releaseWgt;
	}
	
	/**
	 * Column Info
	 * @return basicSlot
	 */
	public String getBasicSlot() {
		return this.basicSlot;
	}
	
	/**
	 * Column Info
	 * @return ovRat45
	 */
	public String getOvRat45() {
		return this.ovRat45;
	}
	
	/**
	 * Column Info
	 * @return basicWgt
	 */
	public String getBasicWgt() {
		return this.basicWgt;
	}
	
	/**
	 * Column Info
	 * @return slotQty
	 */
	public String getSlotQty() {
		return this.slotQty;
	}
	
	/**
	 * Column Info
	 * @return rdrUser
	 */
	public String getRdrUser() {
		return this.rdrUser;
	}
	
	/**
	 * Column Info
	 * @return cntrType
	 */
	public String getCntrType() {
		return this.cntrType;
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
	 * @return cntrSize
	 */
	public String getCntrSize() {
		return this.cntrSize;
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
	 * @return load40
	 */
	public String getLoad40() {
		return this.load40;
	}
	
	/**
	 * Column Info
	 * @return load45
	 */
	public String getLoad45() {
		return this.load45;
	}
	

	/**
	 * Column Info
	 * @param eta
	 */
	public void setEta(String eta) {
		this.eta = eta;
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
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * Column Info
	 * @param segment
	 */
	public void setSegment(String segment) {
		this.segment = segment;
	}
	
	/**
	 * Column Info
	 * @param hc40Rat
	 */
	public void setHc40Rat(String hc40Rat) {
		this.hc40Rat = hc40Rat;
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
	 * @param rdrDate
	 */
	public void setRdrDate(String rdrDate) {
		this.rdrDate = rdrDate;
	}
	
	/**
	 * Column Info
	 * @param podIso
	 */
	public void setPodIso(String podIso) {
		this.podIso = podIso;
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
	 * @param hc45
	 */
	public void setHc45(String hc45) {
		this.hc45 = hc45;
	}
	
	/**
	 * Column Info
	 * @param unRat45
	 */
	public void setUnRat45(String unRat45) {
		this.unRat45 = unRat45;
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
	 * @param empty
	 */
	public void setEmpty(String empty) {
		this.empty = empty;
	}
	
	/**
	 * Column Info
	 * @param arrTime
	 */
	public void setArrTime(String arrTime) {
		this.arrTime = arrTime;
	}
	
	/**
	 * Column Info
	 * @param slotHc
	 */
	public void setSlotHc(String slotHc) {
		this.slotHc = slotHc;
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
	 * @param nextPort
	 */
	public void setNextPort(String nextPort) {
		this.nextPort = nextPort;
	}
	
	/**
	 * Column Info
	 * @param depTime
	 */
	public void setDepTime(String depTime) {
		this.depTime = depTime;
	}
	
	/**
	 * Column Info
	 * @param slotAdd
	 */
	public void setSlotAdd(String slotAdd) {
		this.slotAdd = slotAdd;
	}
	
	/**
	 * Column Info
	 * @param nisDate
	 */
	public void setNisDate(String nisDate) {
		this.nisDate = nisDate;
	}
	
	/**
	 * Column Info
	 * @param ratioType
	 */
	public void setRatioType(String ratioType) {
		this.ratioType = ratioType;
	}
	
	/**
	 * Column Info
	 * @param updateTime
	 */
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
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
	 * @param qty
	 */
	public void setQty(String qty) {
		this.qty = qty;
	}
	
	/**
	 * Column Info
	 * @param qty40
	 */
	public void setQty40(String qty40) {
		this.qty40 = qty40;
	}
	
	/**
	 * Column Info
	 * @param akbb
	 */
	public void setAkbb(String akbb) {
		this.akbb = akbb;
	}
	
	/**
	 * Column Info
	 * @param totalSlot
	 */
	public void setTotalSlot(String totalSlot) {
		this.totalSlot = totalSlot;
	}
	
	/**
	 * Column Info
	 * @param etaCanal
	 */
	public void setEtaCanal(String etaCanal) {
		this.etaCanal = etaCanal;
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
	 * @param add20
	 */
	public void setAdd20(String add20) {
		this.add20 = add20;
	}
	
	/**
	 * Column Info
	 * @param load20
	 */
	public void setLoad20(String load20) {
		this.load20 = load20;
	}
	
	/**
	 * Column Info
	 * @param hc20Rate
	 */
	public void setHc20Rate(String hc20Rate) {
		this.hc20Rate = hc20Rate;
	}
	
	/**
	 * Column Info
	 * @param unberthTime
	 */
	public void setUnberthTime(String unberthTime) {
		this.unberthTime = unberthTime;
	}
	
	/**
	 * Column Info
	 * @param updateUser
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
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
	 * @param weight
	 */
	public void setWeight(String weight) {
		this.weight = weight;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param swapSlot
	 */
	public void setSwapSlot(String swapSlot) {
		this.swapSlot = swapSlot;
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
	 * @param slot45
	 */
	public void setSlot45(String slot45) {
		this.slot45 = slot45;
	}
	
	/**
	 * Column Info
	 * @param releaseSlot
	 */
	public void setReleaseSlot(String releaseSlot) {
		this.releaseSlot = releaseSlot;
	}
	
	/**
	 * Column Info
	 * @param updateSys
	 */
	public void setUpdateSys(String updateSys) {
		this.updateSys = updateSys;
	}
	
	/**
	 * Column Info
	 * @param callInd
	 */
	public void setCallInd(String callInd) {
		this.callInd = callInd;
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
	 * @param headPortCd
	 */
	public void setHeadPortCd(String headPortCd) {
		this.headPortCd = headPortCd;
	}
	
	/**
	 * Column Info
	 * @param slotHc20
	 */
	public void setSlotHc20(String slotHc20) {
		this.slotHc20 = slotHc20;
	}
	
	/**
	 * Column Info
	 * @param full
	 */
	public void setFull(String full) {
		this.full = full;
	}
	
	/**
	 * Column Info
	 * @param teuWgt
	 */
	public void setTeuWgt(String teuWgt) {
		this.teuWgt = teuWgt;
	}
	
	/**
	 * Column Info
	 * @param berthTime
	 */
	public void setBerthTime(String berthTime) {
		this.berthTime = berthTime;
	}
	
	/**
	 * Column Info
	 * @param nextCanal
	 */
	public void setNextCanal(String nextCanal) {
		this.nextCanal = nextCanal;
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
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param totalWgt
	 */
	public void setTotalWgt(String totalWgt) {
		this.totalWgt = totalWgt;
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
	 * @param bsaType
	 */
	public void setBsaType(String bsaType) {
		this.bsaType = bsaType;
	}
	
	/**
	 * Column Info
	 * @param qty20
	 */
	public void setQty20(String qty20) {
		this.qty20 = qty20;
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
	 * @param swapWgt
	 */
	public void setSwapWgt(String swapWgt) {
		this.swapWgt = swapWgt;
	}
	
	/**
	 * Column Info
	 * @param releaseWgt
	 */
	public void setReleaseWgt(String releaseWgt) {
		this.releaseWgt = releaseWgt;
	}
	
	/**
	 * Column Info
	 * @param basicSlot
	 */
	public void setBasicSlot(String basicSlot) {
		this.basicSlot = basicSlot;
	}
	
	/**
	 * Column Info
	 * @param ovRat45
	 */
	public void setOvRat45(String ovRat45) {
		this.ovRat45 = ovRat45;
	}
	
	/**
	 * Column Info
	 * @param basicWgt
	 */
	public void setBasicWgt(String basicWgt) {
		this.basicWgt = basicWgt;
	}
	
	/**
	 * Column Info
	 * @param slotQty
	 */
	public void setSlotQty(String slotQty) {
		this.slotQty = slotQty;
	}
	
	/**
	 * Column Info
	 * @param rdrUser
	 */
	public void setRdrUser(String rdrUser) {
		this.rdrUser = rdrUser;
	}
	
	/**
	 * Column Info
	 * @param cntrType
	 */
	public void setCntrType(String cntrType) {
		this.cntrType = cntrType;
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
	 * @param cntrSize
	 */
	public void setCntrSize(String cntrSize) {
		this.cntrSize = cntrSize;
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
	 * @param load40
	 */
	public void setLoad40(String load40) {
		this.load40 = load40;
	}
	
	/**
	 * Column Info
	 * @param load45
	 */
	public void setLoad45(String load45) {
		this.load45 = load45;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setEta(JSPUtil.getParameter(request, "eta", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setHc40Qty(JSPUtil.getParameter(request, "hc40_qty", ""));
		setRemark(JSPUtil.getParameter(request, "remark", ""));
		setSegment(JSPUtil.getParameter(request, "segment", ""));
		setHc40Rat(JSPUtil.getParameter(request, "hc40_rat", ""));
		setType(JSPUtil.getParameter(request, "type", ""));
		setRdrDate(JSPUtil.getParameter(request, "rdr_date", ""));
		setPodIso(JSPUtil.getParameter(request, "pod_iso", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setHc45(JSPUtil.getParameter(request, "hc45", ""));
		setUnRat45(JSPUtil.getParameter(request, "un_rat_45", ""));
		setBsa45(JSPUtil.getParameter(request, "bsa_45", ""));
		setPol(JSPUtil.getParameter(request, "pol", ""));
		setEmpty(JSPUtil.getParameter(request, "empty", ""));
		setArrTime(JSPUtil.getParameter(request, "arr_time", ""));
		setSlotHc(JSPUtil.getParameter(request, "slot_hc", ""));
		setPod(JSPUtil.getParameter(request, "pod", ""));
		setNextPort(JSPUtil.getParameter(request, "next_port", ""));
		setDepTime(JSPUtil.getParameter(request, "dep_time", ""));
		setSlotAdd(JSPUtil.getParameter(request, "slot_add", ""));
		setNisDate(JSPUtil.getParameter(request, "nis_date", ""));
		setRatioType(JSPUtil.getParameter(request, "ratio_type", ""));
		setUpdateTime(JSPUtil.getParameter(request, "update_time", ""));
		setTotWgt(JSPUtil.getParameter(request, "tot_wgt", ""));
		setQty(JSPUtil.getParameter(request, "qty", ""));
		setQty40(JSPUtil.getParameter(request, "qty_40", ""));
		setAkbb(JSPUtil.getParameter(request, "akbb", ""));
		setTotalSlot(JSPUtil.getParameter(request, "total_slot", ""));
		setEtaCanal(JSPUtil.getParameter(request, "eta_canal", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setAdd20(JSPUtil.getParameter(request, "add_20", ""));
		setLoad20(JSPUtil.getParameter(request, "load_20", ""));
		setHc20Rate(JSPUtil.getParameter(request, "hc20_rate", ""));
		setUnberthTime(JSPUtil.getParameter(request, "unberth_time", ""));
		setUpdateUser(JSPUtil.getParameter(request, "update_user", ""));
		setRegion(JSPUtil.getParameter(request, "region", ""));
		setWeight(JSPUtil.getParameter(request, "weight", ""));
		setTotAlloc(JSPUtil.getParameter(request, "tot_alloc", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setSwapSlot(JSPUtil.getParameter(request, "swap_slot", ""));
		setAdd45(JSPUtil.getParameter(request, "add_45", ""));
		setSlot45(JSPUtil.getParameter(request, "slot_45", ""));
		setReleaseSlot(JSPUtil.getParameter(request, "release_slot", ""));
		setUpdateSys(JSPUtil.getParameter(request, "update_sys", ""));
		setCallInd(JSPUtil.getParameter(request, "call_ind", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setHeadPortCd(JSPUtil.getParameter(request, "head_port_cd", ""));
		setSlotHc20(JSPUtil.getParameter(request, "slot_hc20", ""));
		setFull(JSPUtil.getParameter(request, "full", ""));
		setTeuWgt(JSPUtil.getParameter(request, "teu_wgt", ""));
		setBerthTime(JSPUtil.getParameter(request, "berth_time", ""));
		setNextCanal(JSPUtil.getParameter(request, "next_canal", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setTotalWgt(JSPUtil.getParameter(request, "total_wgt", ""));
		setHc20Qty(JSPUtil.getParameter(request, "hc20_qty", ""));
		setBsaType(JSPUtil.getParameter(request, "bsa_type", ""));
		setQty20(JSPUtil.getParameter(request, "qty_20", ""));
		setVoyNo(JSPUtil.getParameter(request, "voy_no", ""));
		setSwapWgt(JSPUtil.getParameter(request, "swap_wgt", ""));
		setReleaseWgt(JSPUtil.getParameter(request, "release_wgt", ""));
		setBasicSlot(JSPUtil.getParameter(request, "basic_slot", ""));
		setOvRat45(JSPUtil.getParameter(request, "ov_rat_45", ""));
		setBasicWgt(JSPUtil.getParameter(request, "basic_wgt", ""));
		setSlotQty(JSPUtil.getParameter(request, "slot_qty", ""));
		setRdrUser(JSPUtil.getParameter(request, "rdr_user", ""));
		setCntrType(JSPUtil.getParameter(request, "cntr_type", ""));
		setAdd40(JSPUtil.getParameter(request, "add_40", ""));
		setCntrSize(JSPUtil.getParameter(request, "cntr_size", ""));
		setOprCd(JSPUtil.getParameter(request, "opr_cd", ""));
		setLoad40(JSPUtil.getParameter(request, "load_40", ""));
		setLoad45(JSPUtil.getParameter(request, "load_45", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RdrCreatInfoVO[]
	 */
	public RdrCreatInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RdrCreatInfoVO[]
	 */
	public RdrCreatInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RdrCreatInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] eta = (JSPUtil.getParameter(request, prefix	+ "eta", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] hc40Qty = (JSPUtil.getParameter(request, prefix	+ "hc40_qty", length));
			String[] remark = (JSPUtil.getParameter(request, prefix	+ "remark", length));
			String[] segment = (JSPUtil.getParameter(request, prefix	+ "segment", length));
			String[] hc40Rat = (JSPUtil.getParameter(request, prefix	+ "hc40_rat", length));
			String[] type = (JSPUtil.getParameter(request, prefix	+ "type", length));
			String[] rdrDate = (JSPUtil.getParameter(request, prefix	+ "rdr_date", length));
			String[] podIso = (JSPUtil.getParameter(request, prefix	+ "pod_iso", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] hc45 = (JSPUtil.getParameter(request, prefix	+ "hc45", length));
			String[] unRat45 = (JSPUtil.getParameter(request, prefix	+ "un_rat_45", length));
			String[] bsa45 = (JSPUtil.getParameter(request, prefix	+ "bsa_45", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] empty = (JSPUtil.getParameter(request, prefix	+ "empty", length));
			String[] arrTime = (JSPUtil.getParameter(request, prefix	+ "arr_time", length));
			String[] slotHc = (JSPUtil.getParameter(request, prefix	+ "slot_hc", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] nextPort = (JSPUtil.getParameter(request, prefix	+ "next_port", length));
			String[] depTime = (JSPUtil.getParameter(request, prefix	+ "dep_time", length));
			String[] slotAdd = (JSPUtil.getParameter(request, prefix	+ "slot_add", length));
			String[] nisDate = (JSPUtil.getParameter(request, prefix	+ "nis_date", length));
			String[] ratioType = (JSPUtil.getParameter(request, prefix	+ "ratio_type", length));
			String[] updateTime = (JSPUtil.getParameter(request, prefix	+ "update_time", length));
			String[] totWgt = (JSPUtil.getParameter(request, prefix	+ "tot_wgt", length));
			String[] qty = (JSPUtil.getParameter(request, prefix	+ "qty", length));
			String[] qty40 = (JSPUtil.getParameter(request, prefix	+ "qty_40", length));
			String[] akbb = (JSPUtil.getParameter(request, prefix	+ "akbb", length));
			String[] totalSlot = (JSPUtil.getParameter(request, prefix	+ "total_slot", length));
			String[] etaCanal = (JSPUtil.getParameter(request, prefix	+ "eta_canal", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] add20 = (JSPUtil.getParameter(request, prefix	+ "add_20", length));
			String[] load20 = (JSPUtil.getParameter(request, prefix	+ "load_20", length));
			String[] hc20Rate = (JSPUtil.getParameter(request, prefix	+ "hc20_rate", length));
			String[] unberthTime = (JSPUtil.getParameter(request, prefix	+ "unberth_time", length));
			String[] updateUser = (JSPUtil.getParameter(request, prefix	+ "update_user", length));
			String[] region = (JSPUtil.getParameter(request, prefix	+ "region", length));
			String[] weight = (JSPUtil.getParameter(request, prefix	+ "weight", length));
			String[] totAlloc = (JSPUtil.getParameter(request, prefix	+ "tot_alloc", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] swapSlot = (JSPUtil.getParameter(request, prefix	+ "swap_slot", length));
			String[] add45 = (JSPUtil.getParameter(request, prefix	+ "add_45", length));
			String[] slot45 = (JSPUtil.getParameter(request, prefix	+ "slot_45", length));
			String[] releaseSlot = (JSPUtil.getParameter(request, prefix	+ "release_slot", length));
			String[] updateSys = (JSPUtil.getParameter(request, prefix	+ "update_sys", length));
			String[] callInd = (JSPUtil.getParameter(request, prefix	+ "call_ind", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] headPortCd = (JSPUtil.getParameter(request, prefix	+ "head_port_cd", length));
			String[] slotHc20 = (JSPUtil.getParameter(request, prefix	+ "slot_hc20", length));
			String[] full = (JSPUtil.getParameter(request, prefix	+ "full", length));
			String[] teuWgt = (JSPUtil.getParameter(request, prefix	+ "teu_wgt", length));
			String[] berthTime = (JSPUtil.getParameter(request, prefix	+ "berth_time", length));
			String[] nextCanal = (JSPUtil.getParameter(request, prefix	+ "next_canal", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] totalWgt = (JSPUtil.getParameter(request, prefix	+ "total_wgt", length));
			String[] hc20Qty = (JSPUtil.getParameter(request, prefix	+ "hc20_qty", length));
			String[] bsaType = (JSPUtil.getParameter(request, prefix	+ "bsa_type", length));
			String[] qty20 = (JSPUtil.getParameter(request, prefix	+ "qty_20", length));
			String[] voyNo = (JSPUtil.getParameter(request, prefix	+ "voy_no", length));
			String[] swapWgt = (JSPUtil.getParameter(request, prefix	+ "swap_wgt", length));
			String[] releaseWgt = (JSPUtil.getParameter(request, prefix	+ "release_wgt", length));
			String[] basicSlot = (JSPUtil.getParameter(request, prefix	+ "basic_slot", length));
			String[] ovRat45 = (JSPUtil.getParameter(request, prefix	+ "ov_rat_45", length));
			String[] basicWgt = (JSPUtil.getParameter(request, prefix	+ "basic_wgt", length));
			String[] slotQty = (JSPUtil.getParameter(request, prefix	+ "slot_qty", length));
			String[] rdrUser = (JSPUtil.getParameter(request, prefix	+ "rdr_user", length));
			String[] cntrType = (JSPUtil.getParameter(request, prefix	+ "cntr_type", length));
			String[] add40 = (JSPUtil.getParameter(request, prefix	+ "add_40", length));
			String[] cntrSize = (JSPUtil.getParameter(request, prefix	+ "cntr_size", length));
			String[] oprCd = (JSPUtil.getParameter(request, prefix	+ "opr_cd", length));
			String[] load40 = (JSPUtil.getParameter(request, prefix	+ "load_40", length));
			String[] load45 = (JSPUtil.getParameter(request, prefix	+ "load_45", length));
			
			for (int i = 0; i < length; i++) {
				model = new RdrCreatInfoVO();
				if (eta[i] != null)
					model.setEta(eta[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (hc40Qty[i] != null)
					model.setHc40Qty(hc40Qty[i]);
				if (remark[i] != null)
					model.setRemark(remark[i]);
				if (segment[i] != null)
					model.setSegment(segment[i]);
				if (hc40Rat[i] != null)
					model.setHc40Rat(hc40Rat[i]);
				if (type[i] != null)
					model.setType(type[i]);
				if (rdrDate[i] != null)
					model.setRdrDate(rdrDate[i]);
				if (podIso[i] != null)
					model.setPodIso(podIso[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (hc45[i] != null)
					model.setHc45(hc45[i]);
				if (unRat45[i] != null)
					model.setUnRat45(unRat45[i]);
				if (bsa45[i] != null)
					model.setBsa45(bsa45[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (empty[i] != null)
					model.setEmpty(empty[i]);
				if (arrTime[i] != null)
					model.setArrTime(arrTime[i]);
				if (slotHc[i] != null)
					model.setSlotHc(slotHc[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (nextPort[i] != null)
					model.setNextPort(nextPort[i]);
				if (depTime[i] != null)
					model.setDepTime(depTime[i]);
				if (slotAdd[i] != null)
					model.setSlotAdd(slotAdd[i]);
				if (nisDate[i] != null)
					model.setNisDate(nisDate[i]);
				if (ratioType[i] != null)
					model.setRatioType(ratioType[i]);
				if (updateTime[i] != null)
					model.setUpdateTime(updateTime[i]);
				if (totWgt[i] != null)
					model.setTotWgt(totWgt[i]);
				if (qty[i] != null)
					model.setQty(qty[i]);
				if (qty40[i] != null)
					model.setQty40(qty40[i]);
				if (akbb[i] != null)
					model.setAkbb(akbb[i]);
				if (totalSlot[i] != null)
					model.setTotalSlot(totalSlot[i]);
				if (etaCanal[i] != null)
					model.setEtaCanal(etaCanal[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (add20[i] != null)
					model.setAdd20(add20[i]);
				if (load20[i] != null)
					model.setLoad20(load20[i]);
				if (hc20Rate[i] != null)
					model.setHc20Rate(hc20Rate[i]);
				if (unberthTime[i] != null)
					model.setUnberthTime(unberthTime[i]);
				if (updateUser[i] != null)
					model.setUpdateUser(updateUser[i]);
				if (region[i] != null)
					model.setRegion(region[i]);
				if (weight[i] != null)
					model.setWeight(weight[i]);
				if (totAlloc[i] != null)
					model.setTotAlloc(totAlloc[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (swapSlot[i] != null)
					model.setSwapSlot(swapSlot[i]);
				if (add45[i] != null)
					model.setAdd45(add45[i]);
				if (slot45[i] != null)
					model.setSlot45(slot45[i]);
				if (releaseSlot[i] != null)
					model.setReleaseSlot(releaseSlot[i]);
				if (updateSys[i] != null)
					model.setUpdateSys(updateSys[i]);
				if (callInd[i] != null)
					model.setCallInd(callInd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (headPortCd[i] != null)
					model.setHeadPortCd(headPortCd[i]);
				if (slotHc20[i] != null)
					model.setSlotHc20(slotHc20[i]);
				if (full[i] != null)
					model.setFull(full[i]);
				if (teuWgt[i] != null)
					model.setTeuWgt(teuWgt[i]);
				if (berthTime[i] != null)
					model.setBerthTime(berthTime[i]);
				if (nextCanal[i] != null)
					model.setNextCanal(nextCanal[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (totalWgt[i] != null)
					model.setTotalWgt(totalWgt[i]);
				if (hc20Qty[i] != null)
					model.setHc20Qty(hc20Qty[i]);
				if (bsaType[i] != null)
					model.setBsaType(bsaType[i]);
				if (qty20[i] != null)
					model.setQty20(qty20[i]);
				if (voyNo[i] != null)
					model.setVoyNo(voyNo[i]);
				if (swapWgt[i] != null)
					model.setSwapWgt(swapWgt[i]);
				if (releaseWgt[i] != null)
					model.setReleaseWgt(releaseWgt[i]);
				if (basicSlot[i] != null)
					model.setBasicSlot(basicSlot[i]);
				if (ovRat45[i] != null)
					model.setOvRat45(ovRat45[i]);
				if (basicWgt[i] != null)
					model.setBasicWgt(basicWgt[i]);
				if (slotQty[i] != null)
					model.setSlotQty(slotQty[i]);
				if (rdrUser[i] != null)
					model.setRdrUser(rdrUser[i]);
				if (cntrType[i] != null)
					model.setCntrType(cntrType[i]);
				if (add40[i] != null)
					model.setAdd40(add40[i]);
				if (cntrSize[i] != null)
					model.setCntrSize(cntrSize[i]);
				if (oprCd[i] != null)
					model.setOprCd(oprCd[i]);
				if (load40[i] != null)
					model.setLoad40(load40[i]);
				if (load45[i] != null)
					model.setLoad45(load45[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRdrCreatInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RdrCreatInfoVO[]
	 */
	public RdrCreatInfoVO[] getRdrCreatInfoVOs(){
		RdrCreatInfoVO[] vos = (RdrCreatInfoVO[])models.toArray(new RdrCreatInfoVO[models.size()]);
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
		this.eta = this.eta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hc40Qty = this.hc40Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark = this.remark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.segment = this.segment .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hc40Rat = this.hc40Rat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.type = this.type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdrDate = this.rdrDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podIso = this.podIso .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hc45 = this.hc45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unRat45 = this.unRat45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa45 = this.bsa45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.empty = this.empty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrTime = this.arrTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slotHc = this.slotHc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextPort = this.nextPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depTime = this.depTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slotAdd = this.slotAdd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nisDate = this.nisDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratioType = this.ratioType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updateTime = this.updateTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totWgt = this.totWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty = this.qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty40 = this.qty40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.akbb = this.akbb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalSlot = this.totalSlot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaCanal = this.etaCanal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.add20 = this.add20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.load20 = this.load20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hc20Rate = this.hc20Rate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unberthTime = this.unberthTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updateUser = this.updateUser .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.region = this.region .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.weight = this.weight .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totAlloc = this.totAlloc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.swapSlot = this.swapSlot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.add45 = this.add45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slot45 = this.slot45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.releaseSlot = this.releaseSlot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updateSys = this.updateSys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callInd = this.callInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.headPortCd = this.headPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slotHc20 = this.slotHc20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.full = this.full .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teuWgt = this.teuWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.berthTime = this.berthTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextCanal = this.nextCanal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalWgt = this.totalWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hc20Qty = this.hc20Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaType = this.bsaType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty20 = this.qty20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voyNo = this.voyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.swapWgt = this.swapWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.releaseWgt = this.releaseWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.basicSlot = this.basicSlot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovRat45 = this.ovRat45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.basicWgt = this.basicWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slotQty = this.slotQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdrUser = this.rdrUser .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrType = this.cntrType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.add40 = this.add40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSize = this.cntrSize .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oprCd = this.oprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.load40 = this.load40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.load45 = this.load45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
