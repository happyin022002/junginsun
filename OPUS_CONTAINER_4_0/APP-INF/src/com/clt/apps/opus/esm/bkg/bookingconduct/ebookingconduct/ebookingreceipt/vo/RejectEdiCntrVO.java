/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RejectEdiCntrVO.java
*@FileTitle : RejectEdiCntrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.08.03 전용진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

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
 * @author 전용진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RejectEdiCntrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RejectEdiCntrVO> models = new ArrayList<RejectEdiCntrVO>();
	
	/* Column Info */
	private String aCntrTrmHmode = null;
	/* Column Info */
	private String aCntrTempC = null;
	/* Column Info */
	private String aCntrBind = null;
	/* Column Info */
	private String aCntrTrmReturnCy = null;
	/* Column Info */
	private String aCntrOvh = null;
	/* Column Info */
	private String aCntrOvf = null;
	/* Column Info */
	private String aCntrTrmTranDt = null;
	/* Column Info */
	private String aCntrTtlDimLen = null;
	/* Column Info */
	private String aCntrGenset = null;
	/* Column Info */
	private String aCntrTrmInstruction = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String aCntrDind = null;
	/* Column Info */
	private String aCntrTemp = null;
	/* Column Info */
	private String aSealNo = null;
	/* Column Info */
	private String aCntrTun = null;
	/* Column Info */
	private String aCntrWgtTp = null;
	/* Column Info */
	private String aCntrAind = null;
	/* Column Info */
	private String aCntrRind = null;
	/* Column Info */
	private String aCntrVent = null;
	/* Column Info */
	private String aCntrUsrId = null;
	/* Column Info */
	private String aCntrRfdryInd = null;
	/* Column Info */
	private String aCntrTrmTranOffice = null;
	/* Column Info */
	private String aCntrWgtQty = null;
	/* Column Info */
	private String aCntrRfVoltage = null;
	/* Column Info */
	private String aCntrVoidSlot = null;
	/* Column Info */
	private String aCntrTrmWeight = null;
	/* Column Info */
	private String aCntrTrmTranNo = null;
	/* Column Info */
	private String aCntrOvrw = null;
	/* Column Info */
	private String aCntrTtlDimWdt = null;
	/* Column Info */
	private String aCntrTrmPickupCy = null;
	/* Column Info */
	private String aCntrTtlDimHgt = null;
	/* Column Info */
	private String aCntrOvwgt = null;
	/* Column Info */
	private String aCntrHumid = null;
	/* Column Info */
	private String aCntrTrmHaulage = null;
	/* Column Info */
	private String aCntrTunC = null;
	/* Column Info */
	private String aCntrOvlw = null;
	/* Column Info */
	private String aCntrNo = null;
	/* Column Info */
	private String aCntrStwgReq = null;
	/* Column Info */
	private String aCntrRfRemark = null;
	/* Column Info */
	private String aCntrTrmType = null;
	/* Column Info */
	private String aCntrOvr = null;
	/* Column Info */
	private String aCntrTpsz = null;
	/* Column Info */
	private String obHlgTpCd = null;
	/* Column Info */
	private String ibHlgTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RejectEdiCntrVO() {}

	public RejectEdiCntrVO(String ibflag, String pagerows, String aCntrNo, String aCntrTpsz, String aSealNo, String aCntrRind, String aCntrDind, String aCntrAind, String aCntrBind, String aCntrWgtQty, String aCntrWgtTp, String aCntrTemp, String aCntrTun, String aCntrTempC, String aCntrTunC, String aCntrRfVoltage, String aCntrVent, String aCntrHumid, String aCntrGenset, String aCntrRfRemark, String aCntrRfdryInd, String aCntrOvf, String aCntrOvr, String aCntrOvh, String aCntrOvlw, String aCntrOvrw, String aCntrOvwgt, String aCntrVoidSlot, String aCntrStwgReq, String aCntrTtlDimLen, String aCntrTtlDimWdt, String aCntrTtlDimHgt, String aCntrTrmType, String aCntrTrmWeight, String aCntrTrmHaulage, String aCntrTrmHmode, String aCntrTrmPickupCy, String aCntrTrmReturnCy, String aCntrTrmInstruction, String aCntrTrmTranDt, String aCntrTrmTranOffice, String aCntrTrmTranNo, String aCntrUsrId, String obHlgTpCd, String ibHlgTpCd) {
		this.aCntrTrmHmode = aCntrTrmHmode;
		this.aCntrTempC = aCntrTempC;
		this.aCntrBind = aCntrBind;
		this.aCntrTrmReturnCy = aCntrTrmReturnCy;
		this.aCntrOvh = aCntrOvh;
		this.aCntrOvf = aCntrOvf;
		this.aCntrTrmTranDt = aCntrTrmTranDt;
		this.aCntrTtlDimLen = aCntrTtlDimLen;
		this.aCntrGenset = aCntrGenset;
		this.aCntrTrmInstruction = aCntrTrmInstruction;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.aCntrDind = aCntrDind;
		this.aCntrTemp = aCntrTemp;
		this.aSealNo = aSealNo;
		this.aCntrTun = aCntrTun;
		this.aCntrWgtTp = aCntrWgtTp;
		this.aCntrAind = aCntrAind;
		this.aCntrRind = aCntrRind;
		this.aCntrVent = aCntrVent;
		this.aCntrUsrId = aCntrUsrId;
		this.aCntrRfdryInd = aCntrRfdryInd;
		this.aCntrTrmTranOffice = aCntrTrmTranOffice;
		this.aCntrWgtQty = aCntrWgtQty;
		this.aCntrRfVoltage = aCntrRfVoltage;
		this.aCntrVoidSlot = aCntrVoidSlot;
		this.aCntrTrmWeight = aCntrTrmWeight;
		this.aCntrTrmTranNo = aCntrTrmTranNo;
		this.aCntrOvrw = aCntrOvrw;
		this.aCntrTtlDimWdt = aCntrTtlDimWdt;
		this.aCntrTrmPickupCy = aCntrTrmPickupCy;
		this.aCntrTtlDimHgt = aCntrTtlDimHgt;
		this.aCntrOvwgt = aCntrOvwgt;
		this.aCntrHumid = aCntrHumid;
		this.aCntrTrmHaulage = aCntrTrmHaulage;
		this.aCntrTunC = aCntrTunC;
		this.aCntrOvlw = aCntrOvlw;
		this.aCntrNo = aCntrNo;
		this.aCntrStwgReq = aCntrStwgReq;
		this.aCntrRfRemark = aCntrRfRemark;
		this.aCntrTrmType = aCntrTrmType;
		this.aCntrOvr = aCntrOvr;
		this.aCntrTpsz = aCntrTpsz;
		this.obHlgTpCd = obHlgTpCd;
		this.ibHlgTpCd = ibHlgTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("a_cntr_trm_hmode", getACntrTrmHmode());
		this.hashColumns.put("a_cntr_temp_c", getACntrTempC());
		this.hashColumns.put("a_cntr_bind", getACntrBind());
		this.hashColumns.put("a_cntr_trm_return_cy", getACntrTrmReturnCy());
		this.hashColumns.put("a_cntr_ovh", getACntrOvh());
		this.hashColumns.put("a_cntr_ovf", getACntrOvf());
		this.hashColumns.put("a_cntr_trm_tran_dt", getACntrTrmTranDt());
		this.hashColumns.put("a_cntr_ttl_dim_len", getACntrTtlDimLen());
		this.hashColumns.put("a_cntr_genset", getACntrGenset());
		this.hashColumns.put("a_cntr_trm_instruction", getACntrTrmInstruction());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("a_cntr_dind", getACntrDind());
		this.hashColumns.put("a_cntr_temp", getACntrTemp());
		this.hashColumns.put("a_seal_no", getASealNo());
		this.hashColumns.put("a_cntr_tun", getACntrTun());
		this.hashColumns.put("a_cntr_wgt_tp", getACntrWgtTp());
		this.hashColumns.put("a_cntr_aind", getACntrAind());
		this.hashColumns.put("a_cntr_rind", getACntrRind());
		this.hashColumns.put("a_cntr_vent", getACntrVent());
		this.hashColumns.put("a_cntr_usr_id", getACntrUsrId());
		this.hashColumns.put("a_cntr_rfdry_ind", getACntrRfdryInd());
		this.hashColumns.put("a_cntr_trm_tran_office", getACntrTrmTranOffice());
		this.hashColumns.put("a_cntr_wgt_qty", getACntrWgtQty());
		this.hashColumns.put("a_cntr_rf_voltage", getACntrRfVoltage());
		this.hashColumns.put("a_cntr_void_slot", getACntrVoidSlot());
		this.hashColumns.put("a_cntr_trm_weight", getACntrTrmWeight());
		this.hashColumns.put("a_cntr_trm_tran_no", getACntrTrmTranNo());
		this.hashColumns.put("a_cntr_ovrw", getACntrOvrw());
		this.hashColumns.put("a_cntr_ttl_dim_wdt", getACntrTtlDimWdt());
		this.hashColumns.put("a_cntr_trm_pickup_cy", getACntrTrmPickupCy());
		this.hashColumns.put("a_cntr_ttl_dim_hgt", getACntrTtlDimHgt());
		this.hashColumns.put("a_cntr_ovwgt", getACntrOvwgt());
		this.hashColumns.put("a_cntr_humid", getACntrHumid());
		this.hashColumns.put("a_cntr_trm_haulage", getACntrTrmHaulage());
		this.hashColumns.put("a_cntr_tun_c", getACntrTunC());
		this.hashColumns.put("a_cntr_ovlw", getACntrOvlw());
		this.hashColumns.put("a_cntr_no", getACntrNo());
		this.hashColumns.put("a_cntr_stwg_req", getACntrStwgReq());
		this.hashColumns.put("a_cntr_rf_remark", getACntrRfRemark());
		this.hashColumns.put("a_cntr_trm_type", getACntrTrmType());
		this.hashColumns.put("a_cntr_ovr", getACntrOvr());
		this.hashColumns.put("a_cntr_tpsz", getACntrTpsz());
		this.hashColumns.put("ob_hlg_tp_cd", getObHlgTpCd());
		this.hashColumns.put("ib_hlg_tp_cd", getIbHlgTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("a_cntr_trm_hmode", "aCntrTrmHmode");
		this.hashFields.put("a_cntr_temp_c", "aCntrTempC");
		this.hashFields.put("a_cntr_bind", "aCntrBind");
		this.hashFields.put("a_cntr_trm_return_cy", "aCntrTrmReturnCy");
		this.hashFields.put("a_cntr_ovh", "aCntrOvh");
		this.hashFields.put("a_cntr_ovf", "aCntrOvf");
		this.hashFields.put("a_cntr_trm_tran_dt", "aCntrTrmTranDt");
		this.hashFields.put("a_cntr_ttl_dim_len", "aCntrTtlDimLen");
		this.hashFields.put("a_cntr_genset", "aCntrGenset");
		this.hashFields.put("a_cntr_trm_instruction", "aCntrTrmInstruction");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("a_cntr_dind", "aCntrDind");
		this.hashFields.put("a_cntr_temp", "aCntrTemp");
		this.hashFields.put("a_seal_no", "aSealNo");
		this.hashFields.put("a_cntr_tun", "aCntrTun");
		this.hashFields.put("a_cntr_wgt_tp", "aCntrWgtTp");
		this.hashFields.put("a_cntr_aind", "aCntrAind");
		this.hashFields.put("a_cntr_rind", "aCntrRind");
		this.hashFields.put("a_cntr_vent", "aCntrVent");
		this.hashFields.put("a_cntr_usr_id", "aCntrUsrId");
		this.hashFields.put("a_cntr_rfdry_ind", "aCntrRfdryInd");
		this.hashFields.put("a_cntr_trm_tran_office", "aCntrTrmTranOffice");
		this.hashFields.put("a_cntr_wgt_qty", "aCntrWgtQty");
		this.hashFields.put("a_cntr_rf_voltage", "aCntrRfVoltage");
		this.hashFields.put("a_cntr_void_slot", "aCntrVoidSlot");
		this.hashFields.put("a_cntr_trm_weight", "aCntrTrmWeight");
		this.hashFields.put("a_cntr_trm_tran_no", "aCntrTrmTranNo");
		this.hashFields.put("a_cntr_ovrw", "aCntrOvrw");
		this.hashFields.put("a_cntr_ttl_dim_wdt", "aCntrTtlDimWdt");
		this.hashFields.put("a_cntr_trm_pickup_cy", "aCntrTrmPickupCy");
		this.hashFields.put("a_cntr_ttl_dim_hgt", "aCntrTtlDimHgt");
		this.hashFields.put("a_cntr_ovwgt", "aCntrOvwgt");
		this.hashFields.put("a_cntr_humid", "aCntrHumid");
		this.hashFields.put("a_cntr_trm_haulage", "aCntrTrmHaulage");
		this.hashFields.put("a_cntr_tun_c", "aCntrTunC");
		this.hashFields.put("a_cntr_ovlw", "aCntrOvlw");
		this.hashFields.put("a_cntr_no", "aCntrNo");
		this.hashFields.put("a_cntr_stwg_req", "aCntrStwgReq");
		this.hashFields.put("a_cntr_rf_remark", "aCntrRfRemark");
		this.hashFields.put("a_cntr_trm_type", "aCntrTrmType");
		this.hashFields.put("a_cntr_ovr", "aCntrOvr");
		this.hashFields.put("a_cntr_tpsz", "aCntrTpsz");
		this.hashFields.put("ob_hlg_tp_cd", "obHlgTpCd");
		this.hashFields.put("ib_hlg_tp_cd", "ibHlgTpCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return aCntrTrmHmode
	 */
	public String getACntrTrmHmode() {
		return this.aCntrTrmHmode;
	}
	
	/**
	 * Column Info
	 * @return aCntrTempC
	 */
	public String getACntrTempC() {
		return this.aCntrTempC;
	}
	
	/**
	 * Column Info
	 * @return aCntrBind
	 */
	public String getACntrBind() {
		return this.aCntrBind;
	}
	
	/**
	 * Column Info
	 * @return aCntrTrmReturnCy
	 */
	public String getACntrTrmReturnCy() {
		return this.aCntrTrmReturnCy;
	}
	
	/**
	 * Column Info
	 * @return aCntrOvh
	 */
	public String getACntrOvh() {
		return this.aCntrOvh;
	}
	
	/**
	 * Column Info
	 * @return aCntrOvf
	 */
	public String getACntrOvf() {
		return this.aCntrOvf;
	}
	
	/**
	 * Column Info
	 * @return aCntrTrmTranDt
	 */
	public String getACntrTrmTranDt() {
		return this.aCntrTrmTranDt;
	}
	
	/**
	 * Column Info
	 * @return aCntrTtlDimLen
	 */
	public String getACntrTtlDimLen() {
		return this.aCntrTtlDimLen;
	}
	
	/**
	 * Column Info
	 * @return aCntrGenset
	 */
	public String getACntrGenset() {
		return this.aCntrGenset;
	}
	
	/**
	 * Column Info
	 * @return aCntrTrmInstruction
	 */
	public String getACntrTrmInstruction() {
		return this.aCntrTrmInstruction;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return aCntrDind
	 */
	public String getACntrDind() {
		return this.aCntrDind;
	}
	
	/**
	 * Column Info
	 * @return aCntrTemp
	 */
	public String getACntrTemp() {
		return this.aCntrTemp;
	}
	
	/**
	 * Column Info
	 * @return aSealNo
	 */
	public String getASealNo() {
		return this.aSealNo;
	}
	
	/**
	 * Column Info
	 * @return aCntrTun
	 */
	public String getACntrTun() {
		return this.aCntrTun;
	}
	
	/**
	 * Column Info
	 * @return aCntrWgtTp
	 */
	public String getACntrWgtTp() {
		return this.aCntrWgtTp;
	}
	
	/**
	 * Column Info
	 * @return aCntrAind
	 */
	public String getACntrAind() {
		return this.aCntrAind;
	}
	
	/**
	 * Column Info
	 * @return aCntrRind
	 */
	public String getACntrRind() {
		return this.aCntrRind;
	}
	
	/**
	 * Column Info
	 * @return aCntrVent
	 */
	public String getACntrVent() {
		return this.aCntrVent;
	}
	
	/**
	 * Column Info
	 * @return aCntrUsrId
	 */
	public String getACntrUsrId() {
		return this.aCntrUsrId;
	}
	
	/**
	 * Column Info
	 * @return aCntrRfdryInd
	 */
	public String getACntrRfdryInd() {
		return this.aCntrRfdryInd;
	}
	
	/**
	 * Column Info
	 * @return aCntrTrmTranOffice
	 */
	public String getACntrTrmTranOffice() {
		return this.aCntrTrmTranOffice;
	}
	
	/**
	 * Column Info
	 * @return aCntrWgtQty
	 */
	public String getACntrWgtQty() {
		return this.aCntrWgtQty;
	}
	
	/**
	 * Column Info
	 * @return aCntrRfVoltage
	 */
	public String getACntrRfVoltage() {
		return this.aCntrRfVoltage;
	}
	
	/**
	 * Column Info
	 * @return aCntrVoidSlot
	 */
	public String getACntrVoidSlot() {
		return this.aCntrVoidSlot;
	}
	
	/**
	 * Column Info
	 * @return aCntrTrmWeight
	 */
	public String getACntrTrmWeight() {
		return this.aCntrTrmWeight;
	}
	
	/**
	 * Column Info
	 * @return aCntrTrmTranNo
	 */
	public String getACntrTrmTranNo() {
		return this.aCntrTrmTranNo;
	}
	
	/**
	 * Column Info
	 * @return aCntrOvrw
	 */
	public String getACntrOvrw() {
		return this.aCntrOvrw;
	}
	
	/**
	 * Column Info
	 * @return aCntrTtlDimWdt
	 */
	public String getACntrTtlDimWdt() {
		return this.aCntrTtlDimWdt;
	}
	
	/**
	 * Column Info
	 * @return aCntrTrmPickupCy
	 */
	public String getACntrTrmPickupCy() {
		return this.aCntrTrmPickupCy;
	}
	
	/**
	 * Column Info
	 * @return aCntrTtlDimHgt
	 */
	public String getACntrTtlDimHgt() {
		return this.aCntrTtlDimHgt;
	}
	
	/**
	 * Column Info
	 * @return aCntrOvwgt
	 */
	public String getACntrOvwgt() {
		return this.aCntrOvwgt;
	}
	
	/**
	 * Column Info
	 * @return aCntrHumid
	 */
	public String getACntrHumid() {
		return this.aCntrHumid;
	}
	
	/**
	 * Column Info
	 * @return aCntrTrmHaulage
	 */
	public String getACntrTrmHaulage() {
		return this.aCntrTrmHaulage;
	}
	
	/**
	 * Column Info
	 * @return aCntrTunC
	 */
	public String getACntrTunC() {
		return this.aCntrTunC;
	}
	
	/**
	 * Column Info
	 * @return aCntrOvlw
	 */
	public String getACntrOvlw() {
		return this.aCntrOvlw;
	}
	
	/**
	 * Column Info
	 * @return aCntrNo
	 */
	public String getACntrNo() {
		return this.aCntrNo;
	}
	
	/**
	 * Column Info
	 * @return aCntrStwgReq
	 */
	public String getACntrStwgReq() {
		return this.aCntrStwgReq;
	}
	
	/**
	 * Column Info
	 * @return aCntrRfRemark
	 */
	public String getACntrRfRemark() {
		return this.aCntrRfRemark;
	}
	
	/**
	 * Column Info
	 * @return aCntrTrmType
	 */
	public String getACntrTrmType() {
		return this.aCntrTrmType;
	}
	
	/**
	 * Column Info
	 * @return aCntrOvr
	 */
	public String getACntrOvr() {
		return this.aCntrOvr;
	}
	
	/**
	 * Column Info
	 * @return aCntrTpsz
	 */
	public String getACntrTpsz() {
		return this.aCntrTpsz;
	}
	

	/**
	 * Column Info
	 * @return obHlgTpCd
	 */
	public String getObHlgTpCd() {
		return obHlgTpCd;
	}

	/**
	 * Column Info
	 * @return ibHlgTpCd
	 */
	public String getIbHlgTpCd() {
		return ibHlgTpCd;
	}

	/**
	 * Column Info
	 * @param aCntrTrmHmode
	 */
	public void setACntrTrmHmode(String aCntrTrmHmode) {
		this.aCntrTrmHmode = aCntrTrmHmode;
	}
	
	/**
	 * Column Info
	 * @param aCntrTempC
	 */
	public void setACntrTempC(String aCntrTempC) {
		this.aCntrTempC = aCntrTempC;
	}
	
	/**
	 * Column Info
	 * @param aCntrBind
	 */
	public void setACntrBind(String aCntrBind) {
		this.aCntrBind = aCntrBind;
	}
	
	/**
	 * Column Info
	 * @param aCntrTrmReturnCy
	 */
	public void setACntrTrmReturnCy(String aCntrTrmReturnCy) {
		this.aCntrTrmReturnCy = aCntrTrmReturnCy;
	}
	
	/**
	 * Column Info
	 * @param aCntrOvh
	 */
	public void setACntrOvh(String aCntrOvh) {
		this.aCntrOvh = aCntrOvh;
	}
	
	/**
	 * Column Info
	 * @param aCntrOvf
	 */
	public void setACntrOvf(String aCntrOvf) {
		this.aCntrOvf = aCntrOvf;
	}
	
	/**
	 * Column Info
	 * @param aCntrTrmTranDt
	 */
	public void setACntrTrmTranDt(String aCntrTrmTranDt) {
		this.aCntrTrmTranDt = aCntrTrmTranDt;
	}
	
	/**
	 * Column Info
	 * @param aCntrTtlDimLen
	 */
	public void setACntrTtlDimLen(String aCntrTtlDimLen) {
		this.aCntrTtlDimLen = aCntrTtlDimLen;
	}
	
	/**
	 * Column Info
	 * @param aCntrGenset
	 */
	public void setACntrGenset(String aCntrGenset) {
		this.aCntrGenset = aCntrGenset;
	}
	
	/**
	 * Column Info
	 * @param aCntrTrmInstruction
	 */
	public void setACntrTrmInstruction(String aCntrTrmInstruction) {
		this.aCntrTrmInstruction = aCntrTrmInstruction;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param aCntrDind
	 */
	public void setACntrDind(String aCntrDind) {
		this.aCntrDind = aCntrDind;
	}
	
	/**
	 * Column Info
	 * @param aCntrTemp
	 */
	public void setACntrTemp(String aCntrTemp) {
		this.aCntrTemp = aCntrTemp;
	}
	
	/**
	 * Column Info
	 * @param aSealNo
	 */
	public void setASealNo(String aSealNo) {
		this.aSealNo = aSealNo;
	}
	
	/**
	 * Column Info
	 * @param aCntrTun
	 */
	public void setACntrTun(String aCntrTun) {
		this.aCntrTun = aCntrTun;
	}
	
	/**
	 * Column Info
	 * @param aCntrWgtTp
	 */
	public void setACntrWgtTp(String aCntrWgtTp) {
		this.aCntrWgtTp = aCntrWgtTp;
	}
	
	/**
	 * Column Info
	 * @param aCntrAind
	 */
	public void setACntrAind(String aCntrAind) {
		this.aCntrAind = aCntrAind;
	}
	
	/**
	 * Column Info
	 * @param aCntrRind
	 */
	public void setACntrRind(String aCntrRind) {
		this.aCntrRind = aCntrRind;
	}
	
	/**
	 * Column Info
	 * @param aCntrVent
	 */
	public void setACntrVent(String aCntrVent) {
		this.aCntrVent = aCntrVent;
	}
	
	/**
	 * Column Info
	 * @param aCntrUsrId
	 */
	public void setACntrUsrId(String aCntrUsrId) {
		this.aCntrUsrId = aCntrUsrId;
	}
	
	/**
	 * Column Info
	 * @param aCntrRfdryInd
	 */
	public void setACntrRfdryInd(String aCntrRfdryInd) {
		this.aCntrRfdryInd = aCntrRfdryInd;
	}
	
	/**
	 * Column Info
	 * @param aCntrTrmTranOffice
	 */
	public void setACntrTrmTranOffice(String aCntrTrmTranOffice) {
		this.aCntrTrmTranOffice = aCntrTrmTranOffice;
	}
	
	/**
	 * Column Info
	 * @param aCntrWgtQty
	 */
	public void setACntrWgtQty(String aCntrWgtQty) {
		this.aCntrWgtQty = aCntrWgtQty;
	}
	
	/**
	 * Column Info
	 * @param aCntrRfVoltage
	 */
	public void setACntrRfVoltage(String aCntrRfVoltage) {
		this.aCntrRfVoltage = aCntrRfVoltage;
	}
	
	/**
	 * Column Info
	 * @param aCntrVoidSlot
	 */
	public void setACntrVoidSlot(String aCntrVoidSlot) {
		this.aCntrVoidSlot = aCntrVoidSlot;
	}
	
	/**
	 * Column Info
	 * @param aCntrTrmWeight
	 */
	public void setACntrTrmWeight(String aCntrTrmWeight) {
		this.aCntrTrmWeight = aCntrTrmWeight;
	}
	
	/**
	 * Column Info
	 * @param aCntrTrmTranNo
	 */
	public void setACntrTrmTranNo(String aCntrTrmTranNo) {
		this.aCntrTrmTranNo = aCntrTrmTranNo;
	}
	
	/**
	 * Column Info
	 * @param aCntrOvrw
	 */
	public void setACntrOvrw(String aCntrOvrw) {
		this.aCntrOvrw = aCntrOvrw;
	}
	
	/**
	 * Column Info
	 * @param aCntrTtlDimWdt
	 */
	public void setACntrTtlDimWdt(String aCntrTtlDimWdt) {
		this.aCntrTtlDimWdt = aCntrTtlDimWdt;
	}
	
	/**
	 * Column Info
	 * @param aCntrTrmPickupCy
	 */
	public void setACntrTrmPickupCy(String aCntrTrmPickupCy) {
		this.aCntrTrmPickupCy = aCntrTrmPickupCy;
	}
	
	/**
	 * Column Info
	 * @param aCntrTtlDimHgt
	 */
	public void setACntrTtlDimHgt(String aCntrTtlDimHgt) {
		this.aCntrTtlDimHgt = aCntrTtlDimHgt;
	}
	
	/**
	 * Column Info
	 * @param aCntrOvwgt
	 */
	public void setACntrOvwgt(String aCntrOvwgt) {
		this.aCntrOvwgt = aCntrOvwgt;
	}
	
	/**
	 * Column Info
	 * @param aCntrHumid
	 */
	public void setACntrHumid(String aCntrHumid) {
		this.aCntrHumid = aCntrHumid;
	}
	
	/**
	 * Column Info
	 * @param aCntrTrmHaulage
	 */
	public void setACntrTrmHaulage(String aCntrTrmHaulage) {
		this.aCntrTrmHaulage = aCntrTrmHaulage;
	}
	
	/**
	 * Column Info
	 * @param aCntrTunC
	 */
	public void setACntrTunC(String aCntrTunC) {
		this.aCntrTunC = aCntrTunC;
	}
	
	/**
	 * Column Info
	 * @param aCntrOvlw
	 */
	public void setACntrOvlw(String aCntrOvlw) {
		this.aCntrOvlw = aCntrOvlw;
	}
	
	/**
	 * Column Info
	 * @param aCntrNo
	 */
	public void setACntrNo(String aCntrNo) {
		this.aCntrNo = aCntrNo;
	}
	
	/**
	 * Column Info
	 * @param aCntrStwgReq
	 */
	public void setACntrStwgReq(String aCntrStwgReq) {
		this.aCntrStwgReq = aCntrStwgReq;
	}
	
	/**
	 * Column Info
	 * @param aCntrRfRemark
	 */
	public void setACntrRfRemark(String aCntrRfRemark) {
		this.aCntrRfRemark = aCntrRfRemark;
	}
	
	/**
	 * Column Info
	 * @param aCntrTrmType
	 */
	public void setACntrTrmType(String aCntrTrmType) {
		this.aCntrTrmType = aCntrTrmType;
	}
	
	/**
	 * Column Info
	 * @param aCntrOvr
	 */
	public void setACntrOvr(String aCntrOvr) {
		this.aCntrOvr = aCntrOvr;
	}
	
	/**
	 * Column Info
	 * @param aCntrTpsz
	 */
	public void setACntrTpsz(String aCntrTpsz) {
		this.aCntrTpsz = aCntrTpsz;
	}
	
	/**
	 * Column Info
	 * @param obHlgTpCd
	 */
	public void setObHlgTpCd(String obHlgTpCd) {
		this.obHlgTpCd = obHlgTpCd;
	}

	/**
	 * Column Info
	 * @param ibHlgTpCd
	 */
	public void setIbHlgTpCd(String ibHlgTpCd) {
		this.ibHlgTpCd = ibHlgTpCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setACntrTrmHmode(JSPUtil.getParameter(request, "a_cntr_trm_hmode", ""));
		setACntrTempC(JSPUtil.getParameter(request, "a_cntr_temp_c", ""));
		setACntrBind(JSPUtil.getParameter(request, "a_cntr_bind", ""));
		setACntrTrmReturnCy(JSPUtil.getParameter(request, "a_cntr_trm_return_cy", ""));
		setACntrOvh(JSPUtil.getParameter(request, "a_cntr_ovh", ""));
		setACntrOvf(JSPUtil.getParameter(request, "a_cntr_ovf", ""));
		setACntrTrmTranDt(JSPUtil.getParameter(request, "a_cntr_trm_tran_dt", ""));
		setACntrTtlDimLen(JSPUtil.getParameter(request, "a_cntr_ttl_dim_len", ""));
		setACntrGenset(JSPUtil.getParameter(request, "a_cntr_genset", ""));
		setACntrTrmInstruction(JSPUtil.getParameter(request, "a_cntr_trm_instruction", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setACntrDind(JSPUtil.getParameter(request, "a_cntr_dind", ""));
		setACntrTemp(JSPUtil.getParameter(request, "a_cntr_temp", ""));
		setASealNo(JSPUtil.getParameter(request, "a_seal_no", ""));
		setACntrTun(JSPUtil.getParameter(request, "a_cntr_tun", ""));
		setACntrWgtTp(JSPUtil.getParameter(request, "a_cntr_wgt_tp", ""));
		setACntrAind(JSPUtil.getParameter(request, "a_cntr_aind", ""));
		setACntrRind(JSPUtil.getParameter(request, "a_cntr_rind", ""));
		setACntrVent(JSPUtil.getParameter(request, "a_cntr_vent", ""));
		setACntrUsrId(JSPUtil.getParameter(request, "a_cntr_usr_id", ""));
		setACntrRfdryInd(JSPUtil.getParameter(request, "a_cntr_rfdry_ind", ""));
		setACntrTrmTranOffice(JSPUtil.getParameter(request, "a_cntr_trm_tran_office", ""));
		setACntrWgtQty(JSPUtil.getParameter(request, "a_cntr_wgt_qty", ""));
		setACntrRfVoltage(JSPUtil.getParameter(request, "a_cntr_rf_voltage", ""));
		setACntrVoidSlot(JSPUtil.getParameter(request, "a_cntr_void_slot", ""));
		setACntrTrmWeight(JSPUtil.getParameter(request, "a_cntr_trm_weight", ""));
		setACntrTrmTranNo(JSPUtil.getParameter(request, "a_cntr_trm_tran_no", ""));
		setACntrOvrw(JSPUtil.getParameter(request, "a_cntr_ovrw", ""));
		setACntrTtlDimWdt(JSPUtil.getParameter(request, "a_cntr_ttl_dim_wdt", ""));
		setACntrTrmPickupCy(JSPUtil.getParameter(request, "a_cntr_trm_pickup_cy", ""));
		setACntrTtlDimHgt(JSPUtil.getParameter(request, "a_cntr_ttl_dim_hgt", ""));
		setACntrOvwgt(JSPUtil.getParameter(request, "a_cntr_ovwgt", ""));
		setACntrHumid(JSPUtil.getParameter(request, "a_cntr_humid", ""));
		setACntrTrmHaulage(JSPUtil.getParameter(request, "a_cntr_trm_haulage", ""));
		setACntrTunC(JSPUtil.getParameter(request, "a_cntr_tun_c", ""));
		setACntrOvlw(JSPUtil.getParameter(request, "a_cntr_ovlw", ""));
		setACntrNo(JSPUtil.getParameter(request, "a_cntr_no", ""));
		setACntrStwgReq(JSPUtil.getParameter(request, "a_cntr_stwg_req", ""));
		setACntrRfRemark(JSPUtil.getParameter(request, "a_cntr_rf_remark", ""));
		setACntrTrmType(JSPUtil.getParameter(request, "a_cntr_trm_type", ""));
		setACntrOvr(JSPUtil.getParameter(request, "a_cntr_ovr", ""));
		setACntrTpsz(JSPUtil.getParameter(request, "a_cntr_tpsz", ""));
		setObHlgTpCd(JSPUtil.getParameter(request, "ob_hlg_tp_cd", ""));
		setIbHlgTpCd(JSPUtil.getParameter(request, "ib_hlg_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RejectEdiCntrVO[]
	 */
	public RejectEdiCntrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RejectEdiCntrVO[]
	 */
	public RejectEdiCntrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RejectEdiCntrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] aCntrTrmHmode = (JSPUtil.getParameter(request, prefix	+ "a_cntr_trm_hmode", length));
			String[] aCntrTempC = (JSPUtil.getParameter(request, prefix	+ "a_cntr_temp_c", length));
			String[] aCntrBind = (JSPUtil.getParameter(request, prefix	+ "a_cntr_bind", length));
			String[] aCntrTrmReturnCy = (JSPUtil.getParameter(request, prefix	+ "a_cntr_trm_return_cy", length));
			String[] aCntrOvh = (JSPUtil.getParameter(request, prefix	+ "a_cntr_ovh", length));
			String[] aCntrOvf = (JSPUtil.getParameter(request, prefix	+ "a_cntr_ovf", length));
			String[] aCntrTrmTranDt = (JSPUtil.getParameter(request, prefix	+ "a_cntr_trm_tran_dt", length));
			String[] aCntrTtlDimLen = (JSPUtil.getParameter(request, prefix	+ "a_cntr_ttl_dim_len", length));
			String[] aCntrGenset = (JSPUtil.getParameter(request, prefix	+ "a_cntr_genset", length));
			String[] aCntrTrmInstruction = (JSPUtil.getParameter(request, prefix	+ "a_cntr_trm_instruction", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] aCntrDind = (JSPUtil.getParameter(request, prefix	+ "a_cntr_dind", length));
			String[] aCntrTemp = (JSPUtil.getParameter(request, prefix	+ "a_cntr_temp", length));
			String[] aSealNo = (JSPUtil.getParameter(request, prefix	+ "a_seal_no", length));
			String[] aCntrTun = (JSPUtil.getParameter(request, prefix	+ "a_cntr_tun", length));
			String[] aCntrWgtTp = (JSPUtil.getParameter(request, prefix	+ "a_cntr_wgt_tp", length));
			String[] aCntrAind = (JSPUtil.getParameter(request, prefix	+ "a_cntr_aind", length));
			String[] aCntrRind = (JSPUtil.getParameter(request, prefix	+ "a_cntr_rind", length));
			String[] aCntrVent = (JSPUtil.getParameter(request, prefix	+ "a_cntr_vent", length));
			String[] aCntrUsrId = (JSPUtil.getParameter(request, prefix	+ "a_cntr_usr_id", length));
			String[] aCntrRfdryInd = (JSPUtil.getParameter(request, prefix	+ "a_cntr_rfdry_ind", length));
			String[] aCntrTrmTranOffice = (JSPUtil.getParameter(request, prefix	+ "a_cntr_trm_tran_office", length));
			String[] aCntrWgtQty = (JSPUtil.getParameter(request, prefix	+ "a_cntr_wgt_qty", length));
			String[] aCntrRfVoltage = (JSPUtil.getParameter(request, prefix	+ "a_cntr_rf_voltage", length));
			String[] aCntrVoidSlot = (JSPUtil.getParameter(request, prefix	+ "a_cntr_void_slot", length));
			String[] aCntrTrmWeight = (JSPUtil.getParameter(request, prefix	+ "a_cntr_trm_weight", length));
			String[] aCntrTrmTranNo = (JSPUtil.getParameter(request, prefix	+ "a_cntr_trm_tran_no", length));
			String[] aCntrOvrw = (JSPUtil.getParameter(request, prefix	+ "a_cntr_ovrw", length));
			String[] aCntrTtlDimWdt = (JSPUtil.getParameter(request, prefix	+ "a_cntr_ttl_dim_wdt", length));
			String[] aCntrTrmPickupCy = (JSPUtil.getParameter(request, prefix	+ "a_cntr_trm_pickup_cy", length));
			String[] aCntrTtlDimHgt = (JSPUtil.getParameter(request, prefix	+ "a_cntr_ttl_dim_hgt", length));
			String[] aCntrOvwgt = (JSPUtil.getParameter(request, prefix	+ "a_cntr_ovwgt", length));
			String[] aCntrHumid = (JSPUtil.getParameter(request, prefix	+ "a_cntr_humid", length));
			String[] aCntrTrmHaulage = (JSPUtil.getParameter(request, prefix	+ "a_cntr_trm_haulage", length));
			String[] aCntrTunC = (JSPUtil.getParameter(request, prefix	+ "a_cntr_tun_c", length));
			String[] aCntrOvlw = (JSPUtil.getParameter(request, prefix	+ "a_cntr_ovlw", length));
			String[] aCntrNo = (JSPUtil.getParameter(request, prefix	+ "a_cntr_no", length));
			String[] aCntrStwgReq = (JSPUtil.getParameter(request, prefix	+ "a_cntr_stwg_req", length));
			String[] aCntrRfRemark = (JSPUtil.getParameter(request, prefix	+ "a_cntr_rf_remark", length));
			String[] aCntrTrmType = (JSPUtil.getParameter(request, prefix	+ "a_cntr_trm_type", length));
			String[] aCntrOvr = (JSPUtil.getParameter(request, prefix	+ "a_cntr_ovr", length));
			String[] aCntrTpsz = (JSPUtil.getParameter(request, prefix	+ "a_cntr_tpsz", length));
			String[] obHlgTpCd = (JSPUtil.getParameter(request, prefix	+ "ob_hlg_tp_cd", length));
			String[] ibHlgTpCd = (JSPUtil.getParameter(request, prefix	+ "ib_hlg_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new RejectEdiCntrVO();
				if (aCntrTrmHmode[i] != null)
					model.setACntrTrmHmode(aCntrTrmHmode[i]);
				if (aCntrTempC[i] != null)
					model.setACntrTempC(aCntrTempC[i]);
				if (aCntrBind[i] != null)
					model.setACntrBind(aCntrBind[i]);
				if (aCntrTrmReturnCy[i] != null)
					model.setACntrTrmReturnCy(aCntrTrmReturnCy[i]);
				if (aCntrOvh[i] != null)
					model.setACntrOvh(aCntrOvh[i]);
				if (aCntrOvf[i] != null)
					model.setACntrOvf(aCntrOvf[i]);
				if (aCntrTrmTranDt[i] != null)
					model.setACntrTrmTranDt(aCntrTrmTranDt[i]);
				if (aCntrTtlDimLen[i] != null)
					model.setACntrTtlDimLen(aCntrTtlDimLen[i]);
				if (aCntrGenset[i] != null)
					model.setACntrGenset(aCntrGenset[i]);
				if (aCntrTrmInstruction[i] != null)
					model.setACntrTrmInstruction(aCntrTrmInstruction[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (aCntrDind[i] != null)
					model.setACntrDind(aCntrDind[i]);
				if (aCntrTemp[i] != null)
					model.setACntrTemp(aCntrTemp[i]);
				if (aSealNo[i] != null)
					model.setASealNo(aSealNo[i]);
				if (aCntrTun[i] != null)
					model.setACntrTun(aCntrTun[i]);
				if (aCntrWgtTp[i] != null)
					model.setACntrWgtTp(aCntrWgtTp[i]);
				if (aCntrAind[i] != null)
					model.setACntrAind(aCntrAind[i]);
				if (aCntrRind[i] != null)
					model.setACntrRind(aCntrRind[i]);
				if (aCntrVent[i] != null)
					model.setACntrVent(aCntrVent[i]);
				if (aCntrUsrId[i] != null)
					model.setACntrUsrId(aCntrUsrId[i]);
				if (aCntrRfdryInd[i] != null)
					model.setACntrRfdryInd(aCntrRfdryInd[i]);
				if (aCntrTrmTranOffice[i] != null)
					model.setACntrTrmTranOffice(aCntrTrmTranOffice[i]);
				if (aCntrWgtQty[i] != null)
					model.setACntrWgtQty(aCntrWgtQty[i]);
				if (aCntrRfVoltage[i] != null)
					model.setACntrRfVoltage(aCntrRfVoltage[i]);
				if (aCntrVoidSlot[i] != null)
					model.setACntrVoidSlot(aCntrVoidSlot[i]);
				if (aCntrTrmWeight[i] != null)
					model.setACntrTrmWeight(aCntrTrmWeight[i]);
				if (aCntrTrmTranNo[i] != null)
					model.setACntrTrmTranNo(aCntrTrmTranNo[i]);
				if (aCntrOvrw[i] != null)
					model.setACntrOvrw(aCntrOvrw[i]);
				if (aCntrTtlDimWdt[i] != null)
					model.setACntrTtlDimWdt(aCntrTtlDimWdt[i]);
				if (aCntrTrmPickupCy[i] != null)
					model.setACntrTrmPickupCy(aCntrTrmPickupCy[i]);
				if (aCntrTtlDimHgt[i] != null)
					model.setACntrTtlDimHgt(aCntrTtlDimHgt[i]);
				if (aCntrOvwgt[i] != null)
					model.setACntrOvwgt(aCntrOvwgt[i]);
				if (aCntrHumid[i] != null)
					model.setACntrHumid(aCntrHumid[i]);
				if (aCntrTrmHaulage[i] != null)
					model.setACntrTrmHaulage(aCntrTrmHaulage[i]);
				if (aCntrTunC[i] != null)
					model.setACntrTunC(aCntrTunC[i]);
				if (aCntrOvlw[i] != null)
					model.setACntrOvlw(aCntrOvlw[i]);
				if (aCntrNo[i] != null)
					model.setACntrNo(aCntrNo[i]);
				if (aCntrStwgReq[i] != null)
					model.setACntrStwgReq(aCntrStwgReq[i]);
				if (aCntrRfRemark[i] != null)
					model.setACntrRfRemark(aCntrRfRemark[i]);
				if (aCntrTrmType[i] != null)
					model.setACntrTrmType(aCntrTrmType[i]);
				if (aCntrOvr[i] != null)
					model.setACntrOvr(aCntrOvr[i]);
				if (aCntrTpsz[i] != null)
					model.setACntrTpsz(aCntrTpsz[i]);
				if (obHlgTpCd[i] != null)
					model.setObHlgTpCd(obHlgTpCd[i]);
				if (ibHlgTpCd[i] != null)
					model.setIbHlgTpCd(ibHlgTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRejectEdiCntrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RejectEdiCntrVO[]
	 */
	public RejectEdiCntrVO[] getRejectEdiCntrVOs(){
		RejectEdiCntrVO[] vos = (RejectEdiCntrVO[])models.toArray(new RejectEdiCntrVO[models.size()]);
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
		this.aCntrTrmHmode = this.aCntrTrmHmode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCntrTempC = this.aCntrTempC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCntrBind = this.aCntrBind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCntrTrmReturnCy = this.aCntrTrmReturnCy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCntrOvh = this.aCntrOvh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCntrOvf = this.aCntrOvf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCntrTrmTranDt = this.aCntrTrmTranDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCntrTtlDimLen = this.aCntrTtlDimLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCntrGenset = this.aCntrGenset .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCntrTrmInstruction = this.aCntrTrmInstruction .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCntrDind = this.aCntrDind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCntrTemp = this.aCntrTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aSealNo = this.aSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCntrTun = this.aCntrTun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCntrWgtTp = this.aCntrWgtTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCntrAind = this.aCntrAind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCntrRind = this.aCntrRind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCntrVent = this.aCntrVent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCntrUsrId = this.aCntrUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCntrRfdryInd = this.aCntrRfdryInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCntrTrmTranOffice = this.aCntrTrmTranOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCntrWgtQty = this.aCntrWgtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCntrRfVoltage = this.aCntrRfVoltage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCntrVoidSlot = this.aCntrVoidSlot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCntrTrmWeight = this.aCntrTrmWeight .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCntrTrmTranNo = this.aCntrTrmTranNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCntrOvrw = this.aCntrOvrw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCntrTtlDimWdt = this.aCntrTtlDimWdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCntrTrmPickupCy = this.aCntrTrmPickupCy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCntrTtlDimHgt = this.aCntrTtlDimHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCntrOvwgt = this.aCntrOvwgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCntrHumid = this.aCntrHumid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCntrTrmHaulage = this.aCntrTrmHaulage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCntrTunC = this.aCntrTunC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCntrOvlw = this.aCntrOvlw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCntrNo = this.aCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCntrStwgReq = this.aCntrStwgReq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCntrRfRemark = this.aCntrRfRemark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCntrTrmType = this.aCntrTrmType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCntrOvr = this.aCntrOvr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCntrTpsz = this.aCntrTpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obHlgTpCd = this.obHlgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibHlgTpCd = this.ibHlgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
