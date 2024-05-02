/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BayPlanCntrDtlVO.java
*@FileTitle : BayPlanCntrDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.20  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.opf.opfstowagemgt.opfstowagemgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BayPlanCntrDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BayPlanCntrDtlVO> models = new ArrayList<BayPlanCntrDtlVO>();
	
	/* Column Info */
	private String shiftType = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String ovfSlot = null;
	/* Column Info */
	private String remark = null;
	/* Column Info */
	private String coFlashpoint = null;
	/* Column Info */
	private String coPackingGrp = null;
	/* Column Info */
	private String por = null;
	/* Column Info */
	private String tier = null;
	/* Column Info */
	private String prePosition = null;
	/* Column Info */
	private String fpod = null;
	/* Column Info */
	private String codRsn = null;
	/* Column Info */
	private String cargoLength = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String podIso = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String remark2 = null;
	/* Column Info */
	private String coLoaded = null;
	/* Column Info */
	private String planType = null;
	/* Column Info */
	private String actSlot = null;
	/* Column Info */
	private String shiftRes = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String shiftAcct = null;
	/* Column Info */
	private String pcod = null;
	/* Column Info */
	private String fdest = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String updateTime = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String sztpIso = null;
	/* Column Info */
	private String ovsSlot = null;
	/* Column Info */
	private String delvCd = null;
	/* Column Info */
	private String imdgGrp = null;
	/* Column Info */
	private String roww = null;
	/* Column Info */
	private String cargoBreadth = null;
	/* Column Info */
	private String pod2 = null;
	/* Column Info */
	private String coImdgGrp = null;
	/* Column Info */
	private String bay = null;
	/* Column Info */
	private String cargoUnit = null;
	/* Column Info */
	private String packingGrp = null;
	/* Column Info */
	private String temp = null;
	/* Column Info */
	private String ovaSlot = null;
	/* Column Info */
	private String imdgSeq = null;
	/* Column Info */
	private String slotOver = null;
	/* Column Info */
	private String hatch = null;
	/* Column Info */
	private String shiftLoc = null;
	/* Column Info */
	private String sztp = null;
	/* Column Info */
	private String updateUser = null;
	/* Column Info */
	private String groupCd = null;
	/* Column Info */
	private String weight = null;
	/* Column Info */
	private String ovpSlot = null;
	/* Column Info */
	private String coImdgSeq = null;
	/* Column Info */
	private String cargoHeight = null;
	/* Column Info */
	private String imdg = null;
	/* Column Info */
	private String ondeckChk = null;
	/* Column Info */
	private String id = null;
	/* Column Info */
	private String unno = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String callInd = null;
	/* Column Info */
	private String ovh = null;
	/* Column Info */
	private String polIso = null;
	/* Column Info */
	private String pod2Iso = null;
	/* Column Info */
	private String cargoType = null;
	/* Column Info */
	private String hi2 = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String ovp = null;
	/* Column Info */
	private String hi1 = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String shiftPort = null;
	/* Column Info */
	private String dgRemark = null;
	/* Column Info */
	private String ovs = null;
	/* Column Info */
	private String voyNo = null;
	/* Column Info */
	private String bookingNo = null;
	/* Column Info */
	private String ova = null;
	/* Column Info */
	private String shiftRsn = null;
	/* Column Info */
	private String fe = null;
	/* Column Info */
	private String cntrType = null;
	/* Column Info */
	private String ovf = null;
	/* Column Info */
	private String wgtGroup = null;
	/* Column Info */
	private String imdg2 = null;
	/* Column Info */
	private String cntrSize = null;
	/* Column Info */
	private String cod = null;
	/* Column Info */
	private String flashpoint = null;
	/* Column Info */
	private String oprCd = null;
	/* Column Info */
	private String ovhSlot = null;
	/* Column Info */
	private String imdg3 = null;
	/* Column Info */
	private String imdg4 = null;
	/* Column Info */
	private String special = null;
	/* Column Info */
	private String deckPsn = null;
	/* Column Info */
	private String cntrPsn = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BayPlanCntrDtlVO() {}

	public BayPlanCntrDtlVO(String ibflag, String pagerows, String vslCd, String voyNo, String dirCd, String portCd, String id, String callInd, String bay, String roww, String tier, String oprCd, String fe, String por, String pol, String pod, String pod2, String fpod, String fdest, String sztp, String sztpIso, String weight, String delvCd, String groupCd, String special, String temp, String imdg, String imdg2, String imdg3, String imdg4, String unno, String ovh, String ovf, String ova, String ovp, String ovs, String ovhSlot, String ovpSlot, String ovsSlot, String ovfSlot, String ovaSlot, String remark, String remark2, String cod, String codRsn, String prePosition, String shiftPort, String shiftRsn, String shiftAcct, String shiftRes, String shiftType, String shiftLoc, String blNo, String bookingNo, String hi1, String hi2, String cargoType, String cntrType, String cntrSize, String pcod, String ondeckChk, String hatch, String actSlot, String slotOver, String status, String wgtGroup, String planType, String updateUser, String updateTime, String coLoaded, String dgRemark, String podIso, String pod2Iso, String polIso, String packingGrp, String flashpoint, String coPackingGrp, String coFlashpoint, String cargoLength, String cargoBreadth, String cargoHeight, String cargoUnit, String imdgSeq, String imdgGrp, String coImdgSeq, String coImdgGrp, String deckPsn, String cntrPsn) {
		this.shiftType = shiftType;
		this.vslCd = vslCd;
		this.ovfSlot = ovfSlot;
		this.remark = remark;
		this.coFlashpoint = coFlashpoint;
		this.coPackingGrp = coPackingGrp;
		this.por = por;
		this.tier = tier;
		this.prePosition = prePosition;
		this.fpod = fpod;
		this.codRsn = codRsn;
		this.cargoLength = cargoLength;
		this.blNo = blNo;
		this.podIso = podIso;
		this.pagerows = pagerows;
		this.remark2 = remark2;
		this.coLoaded = coLoaded;
		this.planType = planType;
		this.actSlot = actSlot;
		this.shiftRes = shiftRes;
		this.pol = pol;
		this.shiftAcct = shiftAcct;
		this.pcod = pcod;
		this.fdest = fdest;
		this.pod = pod;
		this.updateTime = updateTime;
		this.status = status;
		this.sztpIso = sztpIso;
		this.ovsSlot = ovsSlot;
		this.delvCd = delvCd;
		this.imdgGrp = imdgGrp;
		this.roww = roww;
		this.cargoBreadth = cargoBreadth;
		this.pod2 = pod2;
		this.coImdgGrp = coImdgGrp;
		this.bay = bay;
		this.cargoUnit = cargoUnit;
		this.packingGrp = packingGrp;
		this.temp = temp;
		this.ovaSlot = ovaSlot;
		this.imdgSeq = imdgSeq;
		this.slotOver = slotOver;
		this.hatch = hatch;
		this.shiftLoc = shiftLoc;
		this.sztp = sztp;
		this.updateUser = updateUser;
		this.groupCd = groupCd;
		this.weight = weight;
		this.ovpSlot = ovpSlot;
		this.coImdgSeq = coImdgSeq;
		this.cargoHeight = cargoHeight;
		this.imdg = imdg;
		this.ondeckChk = ondeckChk;
		this.id = id;
		this.unno = unno;
		this.ibflag = ibflag;
		this.callInd = callInd;
		this.ovh = ovh;
		this.polIso = polIso;
		this.pod2Iso = pod2Iso;
		this.cargoType = cargoType;
		this.hi2 = hi2;
		this.dirCd = dirCd;
		this.ovp = ovp;
		this.hi1 = hi1;
		this.portCd = portCd;
		this.shiftPort = shiftPort;
		this.dgRemark = dgRemark;
		this.ovs = ovs;
		this.voyNo = voyNo;
		this.bookingNo = bookingNo;
		this.ova = ova;
		this.shiftRsn = shiftRsn;
		this.fe = fe;
		this.cntrType = cntrType;
		this.ovf = ovf;
		this.wgtGroup = wgtGroup;
		this.imdg2 = imdg2;
		this.cntrSize = cntrSize;
		this.cod = cod;
		this.flashpoint = flashpoint;
		this.oprCd = oprCd;
		this.ovhSlot = ovhSlot;
		this.imdg3 = imdg3;
		this.imdg4 = imdg4;
		this.special = special;
		this.deckPsn = deckPsn;
		this.cntrPsn = cntrPsn;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("shift_type", getShiftType());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("ovf_slot", getOvfSlot());
		this.hashColumns.put("remark", getRemark());
		this.hashColumns.put("co_flashpoint", getCoFlashpoint());
		this.hashColumns.put("co_packing_grp", getCoPackingGrp());
		this.hashColumns.put("por", getPor());
		this.hashColumns.put("tier", getTier());
		this.hashColumns.put("pre_position", getPrePosition());
		this.hashColumns.put("fpod", getFpod());
		this.hashColumns.put("cod_rsn", getCodRsn());
		this.hashColumns.put("cargo_length", getCargoLength());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pod_iso", getPodIso());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("remark2", getRemark2());
		this.hashColumns.put("co_loaded", getCoLoaded());
		this.hashColumns.put("plan_type", getPlanType());
		this.hashColumns.put("act_slot", getActSlot());
		this.hashColumns.put("shift_res", getShiftRes());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("shift_acct", getShiftAcct());
		this.hashColumns.put("pcod", getPcod());
		this.hashColumns.put("fdest", getFdest());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("update_time", getUpdateTime());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("sztp_iso", getSztpIso());
		this.hashColumns.put("ovs_slot", getOvsSlot());
		this.hashColumns.put("delv_cd", getDelvCd());
		this.hashColumns.put("imdg_grp", getImdgGrp());
		this.hashColumns.put("roww", getRoww());
		this.hashColumns.put("cargo_breadth", getCargoBreadth());
		this.hashColumns.put("pod2", getPod2());
		this.hashColumns.put("co_imdg_grp", getCoImdgGrp());
		this.hashColumns.put("bay", getBay());
		this.hashColumns.put("cargo_unit", getCargoUnit());
		this.hashColumns.put("packing_grp", getPackingGrp());
		this.hashColumns.put("temp", getTemp());
		this.hashColumns.put("ova_slot", getOvaSlot());
		this.hashColumns.put("imdg_seq", getImdgSeq());
		this.hashColumns.put("slot_over", getSlotOver());
		this.hashColumns.put("hatch", getHatch());
		this.hashColumns.put("shift_loc", getShiftLoc());
		this.hashColumns.put("sztp", getSztp());
		this.hashColumns.put("update_user", getUpdateUser());
		this.hashColumns.put("group_cd", getGroupCd());
		this.hashColumns.put("weight", getWeight());
		this.hashColumns.put("ovp_slot", getOvpSlot());
		this.hashColumns.put("co_imdg_seq", getCoImdgSeq());
		this.hashColumns.put("cargo_height", getCargoHeight());
		this.hashColumns.put("imdg", getImdg());
		this.hashColumns.put("ondeck_chk", getOndeckChk());
		this.hashColumns.put("id", getId());
		this.hashColumns.put("unno", getUnno());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("call_ind", getCallInd());
		this.hashColumns.put("ovh", getOvh());
		this.hashColumns.put("pol_iso", getPolIso());
		this.hashColumns.put("pod2_iso", getPod2Iso());
		this.hashColumns.put("cargo_type", getCargoType());
		this.hashColumns.put("hi2", getHi2());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("ovp", getOvp());
		this.hashColumns.put("hi1", getHi1());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("shift_port", getShiftPort());
		this.hashColumns.put("dg_remark", getDgRemark());
		this.hashColumns.put("ovs", getOvs());
		this.hashColumns.put("voy_no", getVoyNo());
		this.hashColumns.put("booking_no", getBookingNo());
		this.hashColumns.put("ova", getOva());
		this.hashColumns.put("shift_rsn", getShiftRsn());
		this.hashColumns.put("fe", getFe());
		this.hashColumns.put("cntr_type", getCntrType());
		this.hashColumns.put("ovf", getOvf());
		this.hashColumns.put("wgt_group", getWgtGroup());
		this.hashColumns.put("imdg2", getImdg2());
		this.hashColumns.put("cntr_size", getCntrSize());
		this.hashColumns.put("cod", getCod());
		this.hashColumns.put("flashpoint", getFlashpoint());
		this.hashColumns.put("opr_cd", getOprCd());
		this.hashColumns.put("ovh_slot", getOvhSlot());
		this.hashColumns.put("imdg3", getImdg3());
		this.hashColumns.put("imdg4", getImdg4());
		this.hashColumns.put("special", getSpecial());
		this.hashColumns.put("deck_psn", getDeckPsn());
		this.hashColumns.put("cntr_psn", getCntrPsn());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("shift_type", "shiftType");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("ovf_slot", "ovfSlot");
		this.hashFields.put("remark", "remark");
		this.hashFields.put("co_flashpoint", "coFlashpoint");
		this.hashFields.put("co_packing_grp", "coPackingGrp");
		this.hashFields.put("por", "por");
		this.hashFields.put("tier", "tier");
		this.hashFields.put("pre_position", "prePosition");
		this.hashFields.put("fpod", "fpod");
		this.hashFields.put("cod_rsn", "codRsn");
		this.hashFields.put("cargo_length", "cargoLength");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pod_iso", "podIso");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("remark2", "remark2");
		this.hashFields.put("co_loaded", "coLoaded");
		this.hashFields.put("plan_type", "planType");
		this.hashFields.put("act_slot", "actSlot");
		this.hashFields.put("shift_res", "shiftRes");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("shift_acct", "shiftAcct");
		this.hashFields.put("pcod", "pcod");
		this.hashFields.put("fdest", "fdest");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("update_time", "updateTime");
		this.hashFields.put("status", "status");
		this.hashFields.put("sztp_iso", "sztpIso");
		this.hashFields.put("ovs_slot", "ovsSlot");
		this.hashFields.put("delv_cd", "delvCd");
		this.hashFields.put("imdg_grp", "imdgGrp");
		this.hashFields.put("roww", "roww");
		this.hashFields.put("cargo_breadth", "cargoBreadth");
		this.hashFields.put("pod2", "pod2");
		this.hashFields.put("co_imdg_grp", "coImdgGrp");
		this.hashFields.put("bay", "bay");
		this.hashFields.put("cargo_unit", "cargoUnit");
		this.hashFields.put("packing_grp", "packingGrp");
		this.hashFields.put("temp", "temp");
		this.hashFields.put("ova_slot", "ovaSlot");
		this.hashFields.put("imdg_seq", "imdgSeq");
		this.hashFields.put("slot_over", "slotOver");
		this.hashFields.put("hatch", "hatch");
		this.hashFields.put("shift_loc", "shiftLoc");
		this.hashFields.put("sztp", "sztp");
		this.hashFields.put("update_user", "updateUser");
		this.hashFields.put("group_cd", "groupCd");
		this.hashFields.put("weight", "weight");
		this.hashFields.put("ovp_slot", "ovpSlot");
		this.hashFields.put("co_imdg_seq", "coImdgSeq");
		this.hashFields.put("cargo_height", "cargoHeight");
		this.hashFields.put("imdg", "imdg");
		this.hashFields.put("ondeck_chk", "ondeckChk");
		this.hashFields.put("id", "id");
		this.hashFields.put("unno", "unno");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("call_ind", "callInd");
		this.hashFields.put("ovh", "ovh");
		this.hashFields.put("pol_iso", "polIso");
		this.hashFields.put("pod2_iso", "pod2Iso");
		this.hashFields.put("cargo_type", "cargoType");
		this.hashFields.put("hi2", "hi2");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("ovp", "ovp");
		this.hashFields.put("hi1", "hi1");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("shift_port", "shiftPort");
		this.hashFields.put("dg_remark", "dgRemark");
		this.hashFields.put("ovs", "ovs");
		this.hashFields.put("voy_no", "voyNo");
		this.hashFields.put("booking_no", "bookingNo");
		this.hashFields.put("ova", "ova");
		this.hashFields.put("shift_rsn", "shiftRsn");
		this.hashFields.put("fe", "fe");
		this.hashFields.put("cntr_type", "cntrType");
		this.hashFields.put("ovf", "ovf");
		this.hashFields.put("wgt_group", "wgtGroup");
		this.hashFields.put("imdg2", "imdg2");
		this.hashFields.put("cntr_size", "cntrSize");
		this.hashFields.put("cod", "cod");
		this.hashFields.put("flashpoint", "flashpoint");
		this.hashFields.put("opr_cd", "oprCd");
		this.hashFields.put("ovh_slot", "ovhSlot");
		this.hashFields.put("imdg3", "imdg3");
		this.hashFields.put("imdg4", "imdg4");
		this.hashFields.put("special", "special");
		this.hashFields.put("deck_psn", "deckPsn");
		this.hashFields.put("cntr_psn", "cntrPsn");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return shiftType
	 */
	public String getShiftType() {
		return this.shiftType;
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
	 * @return ovfSlot
	 */
	public String getOvfSlot() {
		return this.ovfSlot;
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
	 * @return coFlashpoint
	 */
	public String getCoFlashpoint() {
		return this.coFlashpoint;
	}
	
	/**
	 * Column Info
	 * @return coPackingGrp
	 */
	public String getCoPackingGrp() {
		return this.coPackingGrp;
	}
	
	/**
	 * Column Info
	 * @return por
	 */
	public String getPor() {
		return this.por;
	}
	
	/**
	 * Column Info
	 * @return tier
	 */
	public String getTier() {
		return this.tier;
	}
	
	/**
	 * Column Info
	 * @return prePosition
	 */
	public String getPrePosition() {
		return this.prePosition;
	}
	
	/**
	 * Column Info
	 * @return fpod
	 */
	public String getFpod() {
		return this.fpod;
	}
	
	/**
	 * Column Info
	 * @return codRsn
	 */
	public String getCodRsn() {
		return this.codRsn;
	}
	
	/**
	 * Column Info
	 * @return cargoLength
	 */
	public String getCargoLength() {
		return this.cargoLength;
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
	 * @return remark2
	 */
	public String getRemark2() {
		return this.remark2;
	}
	
	/**
	 * Column Info
	 * @return coLoaded
	 */
	public String getCoLoaded() {
		return this.coLoaded;
	}
	
	/**
	 * Column Info
	 * @return planType
	 */
	public String getPlanType() {
		return this.planType;
	}
	
	/**
	 * Column Info
	 * @return actSlot
	 */
	public String getActSlot() {
		return this.actSlot;
	}
	
	/**
	 * Column Info
	 * @return shiftRes
	 */
	public String getShiftRes() {
		return this.shiftRes;
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
	 * @return shiftAcct
	 */
	public String getShiftAcct() {
		return this.shiftAcct;
	}
	
	/**
	 * Column Info
	 * @return pcod
	 */
	public String getPcod() {
		return this.pcod;
	}
	
	/**
	 * Column Info
	 * @return fdest
	 */
	public String getFdest() {
		return this.fdest;
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
	 * @return updateTime
	 */
	public String getUpdateTime() {
		return this.updateTime;
	}
	
	/**
	 * Column Info
	 * @return status
	 */
	public String getStatus() {
		return this.status;
	}
	
	/**
	 * Column Info
	 * @return sztpIso
	 */
	public String getSztpIso() {
		return this.sztpIso;
	}
	
	/**
	 * Column Info
	 * @return ovsSlot
	 */
	public String getOvsSlot() {
		return this.ovsSlot;
	}
	
	/**
	 * Column Info
	 * @return delvCd
	 */
	public String getDelvCd() {
		return this.delvCd;
	}
	
	/**
	 * Column Info
	 * @return imdgGrp
	 */
	public String getImdgGrp() {
		return this.imdgGrp;
	}
	
	/**
	 * Column Info
	 * @return roww
	 */
	public String getRoww() {
		return this.roww;
	}
	
	/**
	 * Column Info
	 * @return cargoBreadth
	 */
	public String getCargoBreadth() {
		return this.cargoBreadth;
	}
	
	/**
	 * Column Info
	 * @return pod2
	 */
	public String getPod2() {
		return this.pod2;
	}
	
	/**
	 * Column Info
	 * @return coImdgGrp
	 */
	public String getCoImdgGrp() {
		return this.coImdgGrp;
	}
	
	/**
	 * Column Info
	 * @return bay
	 */
	public String getBay() {
		return this.bay;
	}
	
	/**
	 * Column Info
	 * @return cargoUnit
	 */
	public String getCargoUnit() {
		return this.cargoUnit;
	}
	
	/**
	 * Column Info
	 * @return packingGrp
	 */
	public String getPackingGrp() {
		return this.packingGrp;
	}
	
	/**
	 * Column Info
	 * @return temp
	 */
	public String getTemp() {
		return this.temp;
	}
	
	/**
	 * Column Info
	 * @return ovaSlot
	 */
	public String getOvaSlot() {
		return this.ovaSlot;
	}
	
	/**
	 * Column Info
	 * @return imdgSeq
	 */
	public String getImdgSeq() {
		return this.imdgSeq;
	}
	
	/**
	 * Column Info
	 * @return slotOver
	 */
	public String getSlotOver() {
		return this.slotOver;
	}
	
	/**
	 * Column Info
	 * @return hatch
	 */
	public String getHatch() {
		return this.hatch;
	}
	
	/**
	 * Column Info
	 * @return shiftLoc
	 */
	public String getShiftLoc() {
		return this.shiftLoc;
	}
	
	/**
	 * Column Info
	 * @return sztp
	 */
	public String getSztp() {
		return this.sztp;
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
	 * @return groupCd
	 */
	public String getGroupCd() {
		return this.groupCd;
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
	 * @return ovpSlot
	 */
	public String getOvpSlot() {
		return this.ovpSlot;
	}
	
	/**
	 * Column Info
	 * @return coImdgSeq
	 */
	public String getCoImdgSeq() {
		return this.coImdgSeq;
	}
	
	/**
	 * Column Info
	 * @return cargoHeight
	 */
	public String getCargoHeight() {
		return this.cargoHeight;
	}
	
	/**
	 * Column Info
	 * @return imdg
	 */
	public String getImdg() {
		return this.imdg;
	}
	
	/**
	 * Column Info
	 * @return ondeckChk
	 */
	public String getOndeckChk() {
		return this.ondeckChk;
	}
	
	/**
	 * Column Info
	 * @return id
	 */
	public String getId() {
		return this.id;
	}
	
	/**
	 * Column Info
	 * @return unno
	 */
	public String getUnno() {
		return this.unno;
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
	 * @return callInd
	 */
	public String getCallInd() {
		return this.callInd;
	}
	
	/**
	 * Column Info
	 * @return ovh
	 */
	public String getOvh() {
		return this.ovh;
	}
	
	/**
	 * Column Info
	 * @return polIso
	 */
	public String getPolIso() {
		return this.polIso;
	}
	
	/**
	 * Column Info
	 * @return pod2Iso
	 */
	public String getPod2Iso() {
		return this.pod2Iso;
	}
	
	/**
	 * Column Info
	 * @return cargoType
	 */
	public String getCargoType() {
		return this.cargoType;
	}
	
	/**
	 * Column Info
	 * @return hi2
	 */
	public String getHi2() {
		return this.hi2;
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
	 * @return ovp
	 */
	public String getOvp() {
		return this.ovp;
	}
	
	/**
	 * Column Info
	 * @return hi1
	 */
	public String getHi1() {
		return this.hi1;
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
	 * @return shiftPort
	 */
	public String getShiftPort() {
		return this.shiftPort;
	}
	
	/**
	 * Column Info
	 * @return dgRemark
	 */
	public String getDgRemark() {
		return this.dgRemark;
	}
	
	/**
	 * Column Info
	 * @return ovs
	 */
	public String getOvs() {
		return this.ovs;
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
	 * @return bookingNo
	 */
	public String getBookingNo() {
		return this.bookingNo;
	}
	
	/**
	 * Column Info
	 * @return ova
	 */
	public String getOva() {
		return this.ova;
	}
	
	/**
	 * Column Info
	 * @return shiftRsn
	 */
	public String getShiftRsn() {
		return this.shiftRsn;
	}
	
	/**
	 * Column Info
	 * @return fe
	 */
	public String getFe() {
		return this.fe;
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
	 * @return ovf
	 */
	public String getOvf() {
		return this.ovf;
	}
	
	/**
	 * Column Info
	 * @return wgtGroup
	 */
	public String getWgtGroup() {
		return this.wgtGroup;
	}
	
	/**
	 * Column Info
	 * @return imdg2
	 */
	public String getImdg2() {
		return this.imdg2;
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
	 * @return cod
	 */
	public String getCod() {
		return this.cod;
	}
	
	/**
	 * Column Info
	 * @return flashpoint
	 */
	public String getFlashpoint() {
		return this.flashpoint;
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
	 * @return ovhSlot
	 */
	public String getOvhSlot() {
		return this.ovhSlot;
	}
	
	/**
	 * Column Info
	 * @return imdg3
	 */
	public String getImdg3() {
		return this.imdg3;
	}
	
	/**
	 * Column Info
	 * @return imdg4
	 */
	public String getImdg4() {
		return this.imdg4;
	}
	
	/**
	 * Column Info
	 * @return special
	 */
	public String getSpecial() {
		return this.special;
	}
	

	/**
	 * Column Info
	 * @param shiftType
	 */
	public void setShiftType(String shiftType) {
		this.shiftType = shiftType;
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
	 * @param ovfSlot
	 */
	public void setOvfSlot(String ovfSlot) {
		this.ovfSlot = ovfSlot;
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
	 * @param coFlashpoint
	 */
	public void setCoFlashpoint(String coFlashpoint) {
		this.coFlashpoint = coFlashpoint;
	}
	
	/**
	 * Column Info
	 * @param coPackingGrp
	 */
	public void setCoPackingGrp(String coPackingGrp) {
		this.coPackingGrp = coPackingGrp;
	}
	
	/**
	 * Column Info
	 * @param por
	 */
	public void setPor(String por) {
		this.por = por;
	}
	
	/**
	 * Column Info
	 * @param tier
	 */
	public void setTier(String tier) {
		this.tier = tier;
	}
	
	/**
	 * Column Info
	 * @param prePosition
	 */
	public void setPrePosition(String prePosition) {
		this.prePosition = prePosition;
	}
	
	/**
	 * Column Info
	 * @param fpod
	 */
	public void setFpod(String fpod) {
		this.fpod = fpod;
	}
	
	/**
	 * Column Info
	 * @param codRsn
	 */
	public void setCodRsn(String codRsn) {
		this.codRsn = codRsn;
	}
	
	/**
	 * Column Info
	 * @param cargoLength
	 */
	public void setCargoLength(String cargoLength) {
		this.cargoLength = cargoLength;
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
	 * @param remark2
	 */
	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}
	
	/**
	 * Column Info
	 * @param coLoaded
	 */
	public void setCoLoaded(String coLoaded) {
		this.coLoaded = coLoaded;
	}
	
	/**
	 * Column Info
	 * @param planType
	 */
	public void setPlanType(String planType) {
		this.planType = planType;
	}
	
	/**
	 * Column Info
	 * @param actSlot
	 */
	public void setActSlot(String actSlot) {
		this.actSlot = actSlot;
	}
	
	/**
	 * Column Info
	 * @param shiftRes
	 */
	public void setShiftRes(String shiftRes) {
		this.shiftRes = shiftRes;
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
	 * @param shiftAcct
	 */
	public void setShiftAcct(String shiftAcct) {
		this.shiftAcct = shiftAcct;
	}
	
	/**
	 * Column Info
	 * @param pcod
	 */
	public void setPcod(String pcod) {
		this.pcod = pcod;
	}
	
	/**
	 * Column Info
	 * @param fdest
	 */
	public void setFdest(String fdest) {
		this.fdest = fdest;
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
	 * @param updateTime
	 */
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	
	/**
	 * Column Info
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Column Info
	 * @param sztpIso
	 */
	public void setSztpIso(String sztpIso) {
		this.sztpIso = sztpIso;
	}
	
	/**
	 * Column Info
	 * @param ovsSlot
	 */
	public void setOvsSlot(String ovsSlot) {
		this.ovsSlot = ovsSlot;
	}
	
	/**
	 * Column Info
	 * @param delvCd
	 */
	public void setDelvCd(String delvCd) {
		this.delvCd = delvCd;
	}
	
	/**
	 * Column Info
	 * @param imdgGrp
	 */
	public void setImdgGrp(String imdgGrp) {
		this.imdgGrp = imdgGrp;
	}
	
	/**
	 * Column Info
	 * @param roww
	 */
	public void setRoww(String roww) {
		this.roww = roww;
	}
	
	/**
	 * Column Info
	 * @param cargoBreadth
	 */
	public void setCargoBreadth(String cargoBreadth) {
		this.cargoBreadth = cargoBreadth;
	}
	
	/**
	 * Column Info
	 * @param pod2
	 */
	public void setPod2(String pod2) {
		this.pod2 = pod2;
	}
	
	/**
	 * Column Info
	 * @param coImdgGrp
	 */
	public void setCoImdgGrp(String coImdgGrp) {
		this.coImdgGrp = coImdgGrp;
	}
	
	/**
	 * Column Info
	 * @param bay
	 */
	public void setBay(String bay) {
		this.bay = bay;
	}
	
	/**
	 * Column Info
	 * @param cargoUnit
	 */
	public void setCargoUnit(String cargoUnit) {
		this.cargoUnit = cargoUnit;
	}
	
	/**
	 * Column Info
	 * @param packingGrp
	 */
	public void setPackingGrp(String packingGrp) {
		this.packingGrp = packingGrp;
	}
	
	/**
	 * Column Info
	 * @param temp
	 */
	public void setTemp(String temp) {
		this.temp = temp;
	}
	
	/**
	 * Column Info
	 * @param ovaSlot
	 */
	public void setOvaSlot(String ovaSlot) {
		this.ovaSlot = ovaSlot;
	}
	
	/**
	 * Column Info
	 * @param imdgSeq
	 */
	public void setImdgSeq(String imdgSeq) {
		this.imdgSeq = imdgSeq;
	}
	
	/**
	 * Column Info
	 * @param slotOver
	 */
	public void setSlotOver(String slotOver) {
		this.slotOver = slotOver;
	}
	
	/**
	 * Column Info
	 * @param hatch
	 */
	public void setHatch(String hatch) {
		this.hatch = hatch;
	}
	
	/**
	 * Column Info
	 * @param shiftLoc
	 */
	public void setShiftLoc(String shiftLoc) {
		this.shiftLoc = shiftLoc;
	}
	
	/**
	 * Column Info
	 * @param sztp
	 */
	public void setSztp(String sztp) {
		this.sztp = sztp;
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
	 * @param groupCd
	 */
	public void setGroupCd(String groupCd) {
		this.groupCd = groupCd;
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
	 * @param ovpSlot
	 */
	public void setOvpSlot(String ovpSlot) {
		this.ovpSlot = ovpSlot;
	}
	
	/**
	 * Column Info
	 * @param coImdgSeq
	 */
	public void setCoImdgSeq(String coImdgSeq) {
		this.coImdgSeq = coImdgSeq;
	}
	
	/**
	 * Column Info
	 * @param cargoHeight
	 */
	public void setCargoHeight(String cargoHeight) {
		this.cargoHeight = cargoHeight;
	}
	
	/**
	 * Column Info
	 * @param imdg
	 */
	public void setImdg(String imdg) {
		this.imdg = imdg;
	}
	
	/**
	 * Column Info
	 * @param ondeckChk
	 */
	public void setOndeckChk(String ondeckChk) {
		this.ondeckChk = ondeckChk;
	}
	
	/**
	 * Column Info
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Column Info
	 * @param unno
	 */
	public void setUnno(String unno) {
		this.unno = unno;
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
	 * @param callInd
	 */
	public void setCallInd(String callInd) {
		this.callInd = callInd;
	}
	
	/**
	 * Column Info
	 * @param ovh
	 */
	public void setOvh(String ovh) {
		this.ovh = ovh;
	}
	
	/**
	 * Column Info
	 * @param polIso
	 */
	public void setPolIso(String polIso) {
		this.polIso = polIso;
	}
	
	/**
	 * Column Info
	 * @param pod2Iso
	 */
	public void setPod2Iso(String pod2Iso) {
		this.pod2Iso = pod2Iso;
	}
	
	/**
	 * Column Info
	 * @param cargoType
	 */
	public void setCargoType(String cargoType) {
		this.cargoType = cargoType;
	}
	
	/**
	 * Column Info
	 * @param hi2
	 */
	public void setHi2(String hi2) {
		this.hi2 = hi2;
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
	 * @param ovp
	 */
	public void setOvp(String ovp) {
		this.ovp = ovp;
	}
	
	/**
	 * Column Info
	 * @param hi1
	 */
	public void setHi1(String hi1) {
		this.hi1 = hi1;
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
	 * @param shiftPort
	 */
	public void setShiftPort(String shiftPort) {
		this.shiftPort = shiftPort;
	}
	
	/**
	 * Column Info
	 * @param dgRemark
	 */
	public void setDgRemark(String dgRemark) {
		this.dgRemark = dgRemark;
	}
	
	/**
	 * Column Info
	 * @param ovs
	 */
	public void setOvs(String ovs) {
		this.ovs = ovs;
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
	 * @param bookingNo
	 */
	public void setBookingNo(String bookingNo) {
		this.bookingNo = bookingNo;
	}
	
	/**
	 * Column Info
	 * @param ova
	 */
	public void setOva(String ova) {
		this.ova = ova;
	}
	
	/**
	 * Column Info
	 * @param shiftRsn
	 */
	public void setShiftRsn(String shiftRsn) {
		this.shiftRsn = shiftRsn;
	}
	
	/**
	 * Column Info
	 * @param fe
	 */
	public void setFe(String fe) {
		this.fe = fe;
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
	 * @param ovf
	 */
	public void setOvf(String ovf) {
		this.ovf = ovf;
	}
	
	/**
	 * Column Info
	 * @param wgtGroup
	 */
	public void setWgtGroup(String wgtGroup) {
		this.wgtGroup = wgtGroup;
	}
	
	/**
	 * Column Info
	 * @param imdg2
	 */
	public void setImdg2(String imdg2) {
		this.imdg2 = imdg2;
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
	 * @param cod
	 */
	public void setCod(String cod) {
		this.cod = cod;
	}
	
	/**
	 * Column Info
	 * @param flashpoint
	 */
	public void setFlashpoint(String flashpoint) {
		this.flashpoint = flashpoint;
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
	 * @param ovhSlot
	 */
	public void setOvhSlot(String ovhSlot) {
		this.ovhSlot = ovhSlot;
	}
	
	/**
	 * Column Info
	 * @param imdg3
	 */
	public void setImdg3(String imdg3) {
		this.imdg3 = imdg3;
	}
	
	/**
	 * Column Info
	 * @param imdg4
	 */
	public void setImdg4(String imdg4) {
		this.imdg4 = imdg4;
	}
	
	/**
	 * Column Info
	 * @param special
	 */
	public void setSpecial(String special) {
		this.special = special;
	}
	
	/**
	 * Column Info
	 * @param deckPsn
	 */
	public String getDeckPsn() {
		return deckPsn;
	}
	
	/**
	 * Column Info
	 * @param deckPsn
	 */
	public void setDeckPsn(String deckPsn) {
		this.deckPsn = deckPsn;
	}
	
	/**
	 * Column Info
	 * @param cntrPsn
	 */
	public String getCntrPsn() {
		return cntrPsn;
	}

	/**
	 * Column Info
	 * @param cntrPsn
	 */
	public void setCntrPsn(String cntrPsn) {
		this.cntrPsn = cntrPsn;
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
		setShiftType(JSPUtil.getParameter(request, prefix + "shift_type", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setOvfSlot(JSPUtil.getParameter(request, prefix + "ovf_slot", ""));
		setRemark(JSPUtil.getParameter(request, prefix + "remark", ""));
		setCoFlashpoint(JSPUtil.getParameter(request, prefix + "co_flashpoint", ""));
		setCoPackingGrp(JSPUtil.getParameter(request, prefix + "co_packing_grp", ""));
		setPor(JSPUtil.getParameter(request, prefix + "por", ""));
		setTier(JSPUtil.getParameter(request, prefix + "tier", ""));
		setPrePosition(JSPUtil.getParameter(request, prefix + "pre_position", ""));
		setFpod(JSPUtil.getParameter(request, prefix + "fpod", ""));
		setCodRsn(JSPUtil.getParameter(request, prefix + "cod_rsn", ""));
		setCargoLength(JSPUtil.getParameter(request, prefix + "cargo_length", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPodIso(JSPUtil.getParameter(request, prefix + "pod_iso", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRemark2(JSPUtil.getParameter(request, prefix + "remark2", ""));
		setCoLoaded(JSPUtil.getParameter(request, prefix + "co_loaded", ""));
		setPlanType(JSPUtil.getParameter(request, prefix + "plan_type", ""));
		setActSlot(JSPUtil.getParameter(request, prefix + "act_slot", ""));
		setShiftRes(JSPUtil.getParameter(request, prefix + "shift_res", ""));
		setPol(JSPUtil.getParameter(request, prefix + "pol", ""));
		setShiftAcct(JSPUtil.getParameter(request, prefix + "shift_acct", ""));
		setPcod(JSPUtil.getParameter(request, prefix + "pcod", ""));
		setFdest(JSPUtil.getParameter(request, prefix + "fdest", ""));
		setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
		setUpdateTime(JSPUtil.getParameter(request, prefix + "update_time", ""));
		setStatus(JSPUtil.getParameter(request, prefix + "status", ""));
		setSztpIso(JSPUtil.getParameter(request, prefix + "sztp_iso", ""));
		setOvsSlot(JSPUtil.getParameter(request, prefix + "ovs_slot", ""));
		setDelvCd(JSPUtil.getParameter(request, prefix + "delv_cd", ""));
		setImdgGrp(JSPUtil.getParameter(request, prefix + "imdg_grp", ""));
		setRoww(JSPUtil.getParameter(request, prefix + "roww", ""));
		setCargoBreadth(JSPUtil.getParameter(request, prefix + "cargo_breadth", ""));
		setPod2(JSPUtil.getParameter(request, prefix + "pod2", ""));
		setCoImdgGrp(JSPUtil.getParameter(request, prefix + "co_imdg_grp", ""));
		setBay(JSPUtil.getParameter(request, prefix + "bay", ""));
		setCargoUnit(JSPUtil.getParameter(request, prefix + "cargo_unit", ""));
		setPackingGrp(JSPUtil.getParameter(request, prefix + "packing_grp", ""));
		setTemp(JSPUtil.getParameter(request, prefix + "temp", ""));
		setOvaSlot(JSPUtil.getParameter(request, prefix + "ova_slot", ""));
		setImdgSeq(JSPUtil.getParameter(request, prefix + "imdg_seq", ""));
		setSlotOver(JSPUtil.getParameter(request, prefix + "slot_over", ""));
		setHatch(JSPUtil.getParameter(request, prefix + "hatch", ""));
		setShiftLoc(JSPUtil.getParameter(request, prefix + "shift_loc", ""));
		setSztp(JSPUtil.getParameter(request, prefix + "sztp", ""));
		setUpdateUser(JSPUtil.getParameter(request, prefix + "update_user", ""));
		setGroupCd(JSPUtil.getParameter(request, prefix + "group_cd", ""));
		setWeight(JSPUtil.getParameter(request, prefix + "weight", ""));
		setOvpSlot(JSPUtil.getParameter(request, prefix + "ovp_slot", ""));
		setCoImdgSeq(JSPUtil.getParameter(request, prefix + "co_imdg_seq", ""));
		setCargoHeight(JSPUtil.getParameter(request, prefix + "cargo_height", ""));
		setImdg(JSPUtil.getParameter(request, prefix + "imdg", ""));
		setOndeckChk(JSPUtil.getParameter(request, prefix + "ondeck_chk", ""));
		setId(JSPUtil.getParameter(request, prefix + "id", ""));
		setUnno(JSPUtil.getParameter(request, prefix + "unno", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCallInd(JSPUtil.getParameter(request, prefix + "call_ind", ""));
		setOvh(JSPUtil.getParameter(request, prefix + "ovh", ""));
		setPolIso(JSPUtil.getParameter(request, prefix + "pol_iso", ""));
		setPod2Iso(JSPUtil.getParameter(request, prefix + "pod2_iso", ""));
		setCargoType(JSPUtil.getParameter(request, prefix + "cargo_type", ""));
		setHi2(JSPUtil.getParameter(request, prefix + "hi2", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setOvp(JSPUtil.getParameter(request, prefix + "ovp", ""));
		setHi1(JSPUtil.getParameter(request, prefix + "hi1", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setShiftPort(JSPUtil.getParameter(request, prefix + "shift_port", ""));
		setDgRemark(JSPUtil.getParameter(request, prefix + "dg_remark", ""));
		setOvs(JSPUtil.getParameter(request, prefix + "ovs", ""));
		setVoyNo(JSPUtil.getParameter(request, prefix + "voy_no", ""));
		setBookingNo(JSPUtil.getParameter(request, prefix + "booking_no", ""));
		setOva(JSPUtil.getParameter(request, prefix + "ova", ""));
		setShiftRsn(JSPUtil.getParameter(request, prefix + "shift_rsn", ""));
		setFe(JSPUtil.getParameter(request, prefix + "fe", ""));
		setCntrType(JSPUtil.getParameter(request, prefix + "cntr_type", ""));
		setOvf(JSPUtil.getParameter(request, prefix + "ovf", ""));
		setWgtGroup(JSPUtil.getParameter(request, prefix + "wgt_group", ""));
		setImdg2(JSPUtil.getParameter(request, prefix + "imdg2", ""));
		setCntrSize(JSPUtil.getParameter(request, prefix + "cntr_size", ""));
		setCod(JSPUtil.getParameter(request, prefix + "cod", ""));
		setFlashpoint(JSPUtil.getParameter(request, prefix + "flashpoint", ""));
		setOprCd(JSPUtil.getParameter(request, prefix + "opr_cd", ""));
		setOvhSlot(JSPUtil.getParameter(request, prefix + "ovh_slot", ""));
		setImdg3(JSPUtil.getParameter(request, prefix + "imdg3", ""));
		setImdg4(JSPUtil.getParameter(request, prefix + "imdg4", ""));
		setSpecial(JSPUtil.getParameter(request, prefix + "special", ""));
		setDeckPsn(JSPUtil.getParameter(request, prefix + "deck_psn", ""));
		setCntrPsn(JSPUtil.getParameter(request, prefix + "cntr_psn", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BayPlanCntrDtlVO[]
	 */
	public BayPlanCntrDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BayPlanCntrDtlVO[]
	 */
	public BayPlanCntrDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BayPlanCntrDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] shiftType = (JSPUtil.getParameter(request, prefix	+ "shift_type", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] ovfSlot = (JSPUtil.getParameter(request, prefix	+ "ovf_slot", length));
			String[] remark = (JSPUtil.getParameter(request, prefix	+ "remark", length));
			String[] coFlashpoint = (JSPUtil.getParameter(request, prefix	+ "co_flashpoint", length));
			String[] coPackingGrp = (JSPUtil.getParameter(request, prefix	+ "co_packing_grp", length));
			String[] por = (JSPUtil.getParameter(request, prefix	+ "por", length));
			String[] tier = (JSPUtil.getParameter(request, prefix	+ "tier", length));
			String[] prePosition = (JSPUtil.getParameter(request, prefix	+ "pre_position", length));
			String[] fpod = (JSPUtil.getParameter(request, prefix	+ "fpod", length));
			String[] codRsn = (JSPUtil.getParameter(request, prefix	+ "cod_rsn", length));
			String[] cargoLength = (JSPUtil.getParameter(request, prefix	+ "cargo_length", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] podIso = (JSPUtil.getParameter(request, prefix	+ "pod_iso", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] remark2 = (JSPUtil.getParameter(request, prefix	+ "remark2", length));
			String[] coLoaded = (JSPUtil.getParameter(request, prefix	+ "co_loaded", length));
			String[] planType = (JSPUtil.getParameter(request, prefix	+ "plan_type", length));
			String[] actSlot = (JSPUtil.getParameter(request, prefix	+ "act_slot", length));
			String[] shiftRes = (JSPUtil.getParameter(request, prefix	+ "shift_res", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] shiftAcct = (JSPUtil.getParameter(request, prefix	+ "shift_acct", length));
			String[] pcod = (JSPUtil.getParameter(request, prefix	+ "pcod", length));
			String[] fdest = (JSPUtil.getParameter(request, prefix	+ "fdest", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] updateTime = (JSPUtil.getParameter(request, prefix	+ "update_time", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] sztpIso = (JSPUtil.getParameter(request, prefix	+ "sztp_iso", length));
			String[] ovsSlot = (JSPUtil.getParameter(request, prefix	+ "ovs_slot", length));
			String[] delvCd = (JSPUtil.getParameter(request, prefix	+ "delv_cd", length));
			String[] imdgGrp = (JSPUtil.getParameter(request, prefix	+ "imdg_grp", length));
			String[] roww = (JSPUtil.getParameter(request, prefix	+ "roww", length));
			String[] cargoBreadth = (JSPUtil.getParameter(request, prefix	+ "cargo_breadth", length));
			String[] pod2 = (JSPUtil.getParameter(request, prefix	+ "pod2", length));
			String[] coImdgGrp = (JSPUtil.getParameter(request, prefix	+ "co_imdg_grp", length));
			String[] bay = (JSPUtil.getParameter(request, prefix	+ "bay", length));
			String[] cargoUnit = (JSPUtil.getParameter(request, prefix	+ "cargo_unit", length));
			String[] packingGrp = (JSPUtil.getParameter(request, prefix	+ "packing_grp", length));
			String[] temp = (JSPUtil.getParameter(request, prefix	+ "temp", length));
			String[] ovaSlot = (JSPUtil.getParameter(request, prefix	+ "ova_slot", length));
			String[] imdgSeq = (JSPUtil.getParameter(request, prefix	+ "imdg_seq", length));
			String[] slotOver = (JSPUtil.getParameter(request, prefix	+ "slot_over", length));
			String[] hatch = (JSPUtil.getParameter(request, prefix	+ "hatch", length));
			String[] shiftLoc = (JSPUtil.getParameter(request, prefix	+ "shift_loc", length));
			String[] sztp = (JSPUtil.getParameter(request, prefix	+ "sztp", length));
			String[] updateUser = (JSPUtil.getParameter(request, prefix	+ "update_user", length));
			String[] groupCd = (JSPUtil.getParameter(request, prefix	+ "group_cd", length));
			String[] weight = (JSPUtil.getParameter(request, prefix	+ "weight", length));
			String[] ovpSlot = (JSPUtil.getParameter(request, prefix	+ "ovp_slot", length));
			String[] coImdgSeq = (JSPUtil.getParameter(request, prefix	+ "co_imdg_seq", length));
			String[] cargoHeight = (JSPUtil.getParameter(request, prefix	+ "cargo_height", length));
			String[] imdg = (JSPUtil.getParameter(request, prefix	+ "imdg", length));
			String[] ondeckChk = (JSPUtil.getParameter(request, prefix	+ "ondeck_chk", length));
			String[] id = (JSPUtil.getParameter(request, prefix	+ "id", length));
			String[] unno = (JSPUtil.getParameter(request, prefix	+ "unno", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] callInd = (JSPUtil.getParameter(request, prefix	+ "call_ind", length));
			String[] ovh = (JSPUtil.getParameter(request, prefix	+ "ovh", length));
			String[] polIso = (JSPUtil.getParameter(request, prefix	+ "pol_iso", length));
			String[] pod2Iso = (JSPUtil.getParameter(request, prefix	+ "pod2_iso", length));
			String[] cargoType = (JSPUtil.getParameter(request, prefix	+ "cargo_type", length));
			String[] hi2 = (JSPUtil.getParameter(request, prefix	+ "hi2", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] ovp = (JSPUtil.getParameter(request, prefix	+ "ovp", length));
			String[] hi1 = (JSPUtil.getParameter(request, prefix	+ "hi1", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] shiftPort = (JSPUtil.getParameter(request, prefix	+ "shift_port", length));
			String[] dgRemark = (JSPUtil.getParameter(request, prefix	+ "dg_remark", length));
			String[] ovs = (JSPUtil.getParameter(request, prefix	+ "ovs", length));
			String[] voyNo = (JSPUtil.getParameter(request, prefix	+ "voy_no", length));
			String[] bookingNo = (JSPUtil.getParameter(request, prefix	+ "booking_no", length));
			String[] ova = (JSPUtil.getParameter(request, prefix	+ "ova", length));
			String[] shiftRsn = (JSPUtil.getParameter(request, prefix	+ "shift_rsn", length));
			String[] fe = (JSPUtil.getParameter(request, prefix	+ "fe", length));
			String[] cntrType = (JSPUtil.getParameter(request, prefix	+ "cntr_type", length));
			String[] ovf = (JSPUtil.getParameter(request, prefix	+ "ovf", length));
			String[] wgtGroup = (JSPUtil.getParameter(request, prefix	+ "wgt_group", length));
			String[] imdg2 = (JSPUtil.getParameter(request, prefix	+ "imdg2", length));
			String[] cntrSize = (JSPUtil.getParameter(request, prefix	+ "cntr_size", length));
			String[] cod = (JSPUtil.getParameter(request, prefix	+ "cod", length));
			String[] flashpoint = (JSPUtil.getParameter(request, prefix	+ "flashpoint", length));
			String[] oprCd = (JSPUtil.getParameter(request, prefix	+ "opr_cd", length));
			String[] ovhSlot = (JSPUtil.getParameter(request, prefix	+ "ovh_slot", length));
			String[] imdg3 = (JSPUtil.getParameter(request, prefix	+ "imdg3", length));
			String[] imdg4 = (JSPUtil.getParameter(request, prefix	+ "imdg4", length));
			String[] special = (JSPUtil.getParameter(request, prefix	+ "special", length));
			String[] deckPsn = (JSPUtil.getParameter(request, prefix	+ "deck_psn", length));
			String[] cntrPsn = (JSPUtil.getParameter(request, prefix	+ "cntr_psn", length));
			
			for (int i = 0; i < length; i++) {
				model = new BayPlanCntrDtlVO();
				if (shiftType[i] != null)
					model.setShiftType(shiftType[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (ovfSlot[i] != null)
					model.setOvfSlot(ovfSlot[i]);
				if (remark[i] != null)
					model.setRemark(remark[i]);
				if (coFlashpoint[i] != null)
					model.setCoFlashpoint(coFlashpoint[i]);
				if (coPackingGrp[i] != null)
					model.setCoPackingGrp(coPackingGrp[i]);
				if (por[i] != null)
					model.setPor(por[i]);
				if (tier[i] != null)
					model.setTier(tier[i]);
				if (prePosition[i] != null)
					model.setPrePosition(prePosition[i]);
				if (fpod[i] != null)
					model.setFpod(fpod[i]);
				if (codRsn[i] != null)
					model.setCodRsn(codRsn[i]);
				if (cargoLength[i] != null)
					model.setCargoLength(cargoLength[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (podIso[i] != null)
					model.setPodIso(podIso[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (remark2[i] != null)
					model.setRemark2(remark2[i]);
				if (coLoaded[i] != null)
					model.setCoLoaded(coLoaded[i]);
				if (planType[i] != null)
					model.setPlanType(planType[i]);
				if (actSlot[i] != null)
					model.setActSlot(actSlot[i]);
				if (shiftRes[i] != null)
					model.setShiftRes(shiftRes[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (shiftAcct[i] != null)
					model.setShiftAcct(shiftAcct[i]);
				if (pcod[i] != null)
					model.setPcod(pcod[i]);
				if (fdest[i] != null)
					model.setFdest(fdest[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (updateTime[i] != null)
					model.setUpdateTime(updateTime[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (sztpIso[i] != null)
					model.setSztpIso(sztpIso[i]);
				if (ovsSlot[i] != null)
					model.setOvsSlot(ovsSlot[i]);
				if (delvCd[i] != null)
					model.setDelvCd(delvCd[i]);
				if (imdgGrp[i] != null)
					model.setImdgGrp(imdgGrp[i]);
				if (roww[i] != null)
					model.setRoww(roww[i]);
				if (cargoBreadth[i] != null)
					model.setCargoBreadth(cargoBreadth[i]);
				if (pod2[i] != null)
					model.setPod2(pod2[i]);
				if (coImdgGrp[i] != null)
					model.setCoImdgGrp(coImdgGrp[i]);
				if (bay[i] != null)
					model.setBay(bay[i]);
				if (cargoUnit[i] != null)
					model.setCargoUnit(cargoUnit[i]);
				if (packingGrp[i] != null)
					model.setPackingGrp(packingGrp[i]);
				if (temp[i] != null)
					model.setTemp(temp[i]);
				if (ovaSlot[i] != null)
					model.setOvaSlot(ovaSlot[i]);
				if (imdgSeq[i] != null)
					model.setImdgSeq(imdgSeq[i]);
				if (slotOver[i] != null)
					model.setSlotOver(slotOver[i]);
				if (hatch[i] != null)
					model.setHatch(hatch[i]);
				if (shiftLoc[i] != null)
					model.setShiftLoc(shiftLoc[i]);
				if (sztp[i] != null)
					model.setSztp(sztp[i]);
				if (updateUser[i] != null)
					model.setUpdateUser(updateUser[i]);
				if (groupCd[i] != null)
					model.setGroupCd(groupCd[i]);
				if (weight[i] != null)
					model.setWeight(weight[i]);
				if (ovpSlot[i] != null)
					model.setOvpSlot(ovpSlot[i]);
				if (coImdgSeq[i] != null)
					model.setCoImdgSeq(coImdgSeq[i]);
				if (cargoHeight[i] != null)
					model.setCargoHeight(cargoHeight[i]);
				if (imdg[i] != null)
					model.setImdg(imdg[i]);
				if (ondeckChk[i] != null)
					model.setOndeckChk(ondeckChk[i]);
				if (id[i] != null)
					model.setId(id[i]);
				if (unno[i] != null)
					model.setUnno(unno[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (callInd[i] != null)
					model.setCallInd(callInd[i]);
				if (ovh[i] != null)
					model.setOvh(ovh[i]);
				if (polIso[i] != null)
					model.setPolIso(polIso[i]);
				if (pod2Iso[i] != null)
					model.setPod2Iso(pod2Iso[i]);
				if (cargoType[i] != null)
					model.setCargoType(cargoType[i]);
				if (hi2[i] != null)
					model.setHi2(hi2[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (ovp[i] != null)
					model.setOvp(ovp[i]);
				if (hi1[i] != null)
					model.setHi1(hi1[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (shiftPort[i] != null)
					model.setShiftPort(shiftPort[i]);
				if (dgRemark[i] != null)
					model.setDgRemark(dgRemark[i]);
				if (ovs[i] != null)
					model.setOvs(ovs[i]);
				if (voyNo[i] != null)
					model.setVoyNo(voyNo[i]);
				if (bookingNo[i] != null)
					model.setBookingNo(bookingNo[i]);
				if (ova[i] != null)
					model.setOva(ova[i]);
				if (shiftRsn[i] != null)
					model.setShiftRsn(shiftRsn[i]);
				if (fe[i] != null)
					model.setFe(fe[i]);
				if (cntrType[i] != null)
					model.setCntrType(cntrType[i]);
				if (ovf[i] != null)
					model.setOvf(ovf[i]);
				if (wgtGroup[i] != null)
					model.setWgtGroup(wgtGroup[i]);
				if (imdg2[i] != null)
					model.setImdg2(imdg2[i]);
				if (cntrSize[i] != null)
					model.setCntrSize(cntrSize[i]);
				if (cod[i] != null)
					model.setCod(cod[i]);
				if (flashpoint[i] != null)
					model.setFlashpoint(flashpoint[i]);
				if (oprCd[i] != null)
					model.setOprCd(oprCd[i]);
				if (ovhSlot[i] != null)
					model.setOvhSlot(ovhSlot[i]);
				if (imdg3[i] != null)
					model.setImdg3(imdg3[i]);
				if (imdg4[i] != null)
					model.setImdg4(imdg4[i]);
				if (special[i] != null)
					model.setSpecial(special[i]);
				if (deckPsn[i] != null)
					model.setDeckPsn(deckPsn[i]);
				if (cntrPsn[i] != null)
					model.setCntrPsn(cntrPsn[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBayPlanCntrDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BayPlanCntrDtlVO[]
	 */
	public BayPlanCntrDtlVO[] getBayPlanCntrDtlVOs(){
		BayPlanCntrDtlVO[] vos = (BayPlanCntrDtlVO[])models.toArray(new BayPlanCntrDtlVO[models.size()]);
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
		this.shiftType = this.shiftType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovfSlot = this.ovfSlot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark = this.remark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coFlashpoint = this.coFlashpoint .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coPackingGrp = this.coPackingGrp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.por = this.por .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tier = this.tier .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prePosition = this.prePosition .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fpod = this.fpod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codRsn = this.codRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoLength = this.cargoLength .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podIso = this.podIso .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark2 = this.remark2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coLoaded = this.coLoaded .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.planType = this.planType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actSlot = this.actSlot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shiftRes = this.shiftRes .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shiftAcct = this.shiftAcct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pcod = this.pcod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdest = this.fdest .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updateTime = this.updateTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sztpIso = this.sztpIso .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovsSlot = this.ovsSlot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delvCd = this.delvCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgGrp = this.imdgGrp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.roww = this.roww .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoBreadth = this.cargoBreadth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod2 = this.pod2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coImdgGrp = this.coImdgGrp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bay = this.bay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoUnit = this.cargoUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.packingGrp = this.packingGrp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.temp = this.temp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovaSlot = this.ovaSlot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSeq = this.imdgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slotOver = this.slotOver .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hatch = this.hatch .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shiftLoc = this.shiftLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sztp = this.sztp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updateUser = this.updateUser .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.groupCd = this.groupCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.weight = this.weight .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovpSlot = this.ovpSlot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coImdgSeq = this.coImdgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoHeight = this.cargoHeight .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdg = this.imdg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ondeckChk = this.ondeckChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.id = this.id .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unno = this.unno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callInd = this.callInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovh = this.ovh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polIso = this.polIso .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod2Iso = this.pod2Iso .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoType = this.cargoType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hi2 = this.hi2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovp = this.ovp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hi1 = this.hi1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shiftPort = this.shiftPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgRemark = this.dgRemark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovs = this.ovs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voyNo = this.voyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bookingNo = this.bookingNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ova = this.ova .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shiftRsn = this.shiftRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fe = this.fe .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrType = this.cntrType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovf = this.ovf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtGroup = this.wgtGroup .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdg2 = this.imdg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSize = this.cntrSize .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cod = this.cod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flashpoint = this.flashpoint .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oprCd = this.oprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovhSlot = this.ovhSlot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdg3 = this.imdg3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdg4 = this.imdg4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.special = this.special .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deckPsn = this.deckPsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPsn = this.cntrPsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
