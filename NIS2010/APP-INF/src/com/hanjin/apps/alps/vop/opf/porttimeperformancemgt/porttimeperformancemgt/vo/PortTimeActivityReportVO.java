/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PortTimeActivityReportVO.java
*@FileTitle : PortTimeActivityReportVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.28
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2013.08.28 원종규 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo;

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

public class PortTimeActivityReportVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PortTimeActivityReportVO> models = new ArrayList<PortTimeActivityReportVO>();
	
	/* Column Info */
	private String tdrMvs = null;
	/* Column Info */
	private String pltInDt = null;
	/* Column Info */
	private String lashingSingedOffRmk = null;
	/* Column Info */
	private String gangMoveToBerthRmk = null;
	/* Column Info */
	private String dualCycle = null;
	/* Column Info */
	private String stwDifHrsFlg = null;
	/* Column Info */
	private String driftingStartBbo = null;
	/* Column Info */
	private String customsInspectionOnBoard = null;
	/* Column Info */
	private String mooringAllLinesFastRmk = null;
	/* Column Info */
	private String pilotOnBoardArr = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String lashingSingedOff = null;
	/* Column Info */
	private String operation = null;
	/* Column Info */
	private String anchorDropBbo = null;
	/* Column Info */
	private String anchorDropVms = null;
	/* Column Info */
	private String unmooringAllLinesRelease = null;
	/* Column Info */
	private String unmooringReleaseRmk = null;
	/* Column Info */
	private String driftingEndBbo = null;
	/* Column Info */
	private String safetyNetRmk = null;
	/* Column Info */
	private String customsOnBoardRmk = null;
	/* Column Info */
	private String immigrationAgentOnBoard = null;
	/* Column Info */
	private String rhq = null;
	/* Column Info */
	private String restowRmk = null;
	/* Column Info */
	private String immigrationAgentOnBoardRmk = null;
	/* Column Info */
	private String pltOutDt = null;
	/* Column Info */
	private String pilotOnBoardDepRmk = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String restow = null;
	/* Column Info */
	private String lasherOnBoard = null;
	/* Column Info */
	private String twinLift = null;
	/* Column Info */
	private String portTmActUpdDt = null;
	/* Column Info */
	private String operationRmk = null;
	/* Column Info */
	private String anchorAwayVms = null;
	/* Column Info */
	private String sailingIn = null;
	/* Column Info */
	private String twinLiftRmk = null;
	/* Column Info */
	private String gangwayDown = null;
	/* Column Info */
	private String agentOffBoard = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pilotOnBoardArrRmk = null;
	/* Column Info */
	private String stwDifHrs = null;
	/* Column Info */
	private String dualCycleRmk = null;
	/* Column Info */
	private String quarantineOnBoardRmk = null;
	/* Column Info */
	private String quarantineOnBoard = null;
	/* Column Info */
	private String gantryCraneReadyRmk = null;
	/* Column Info */
	private String lasherOnBoardRmk = null;
	/* Column Info */
	private String anchorAwayBbo = null;
	/* Column Info */
	private String tugBoatReady = null;
	/* Column Info */
	private String agentOffBoardRmk = null;
	/* Column Info */
	private String safetyNet = null;
	/* Column Info */
	private String gangwayDownRmk = null;
	/* Column Info */
	private String tugBoatReadyRmk = null;
	/* Column Info */
	private String mooringAllLinesFast = null;
	/* Column Info */
	private String gangMoveToBerth = null;
	/* Column Info */
	private String pilotOnBoardDep = null;
	/* Column Info */
	private String sailingInRmk = null;
	/* Column Info */
	private String gangwayUpRmk = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String gangwayUp = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String gantryCraneReady = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PortTimeActivityReportVO() {}

	public PortTimeActivityReportVO(String ibflag, String pagerows, String tdrMvs, String pltInDt, String lashingSingedOffRmk, String gangMoveToBerthRmk, String dualCycle, String customsInspectionOnBoard, String mooringAllLinesFastRmk, String pilotOnBoardArr, String lashingSingedOff, String operation, String unmooringAllLinesRelease, String unmooringReleaseRmk, String safetyNetRmk, String customsOnBoardRmk, String immigrationAgentOnBoard, String rhq, String restowRmk, String pltOutDt, String immigrationAgentOnBoardRmk, String pilotOnBoardDepRmk, String vvd, String restow, String lasherOnBoard, String twinLift, String portTmActUpdDt, String operationRmk, String sailingIn, String twinLiftRmk, String gangwayDown, String agentOffBoard, String pilotOnBoardArrRmk, String dualCycleRmk, String quarantineOnBoardRmk, String quarantineOnBoard, String gantryCraneReadyRmk, String lasherOnBoardRmk, String tugBoatReady, String agentOffBoardRmk, String safetyNet, String gangwayDownRmk, String tugBoatReadyRmk, String mooringAllLinesFast, String gangMoveToBerth, String pilotOnBoardDep, String sailingInRmk, String gangwayUpRmk, String slanCd, String ydCd, String clptIndSeq, String gangwayUp, String gantryCraneReady, String driftingStartBbo, String driftingEndBbo, String anchorDropVms, String anchorAwayVms, String anchorDropBbo, String anchorAwayBbo, String stwDifHrsFlg, String stwDifHrs) {
		this.tdrMvs = tdrMvs;
		this.pltInDt = pltInDt;
		this.lashingSingedOffRmk = lashingSingedOffRmk;
		this.gangMoveToBerthRmk = gangMoveToBerthRmk;
		this.dualCycle = dualCycle;
		this.stwDifHrsFlg = stwDifHrsFlg;
		this.driftingStartBbo = driftingStartBbo;
		this.customsInspectionOnBoard = customsInspectionOnBoard;
		this.mooringAllLinesFastRmk = mooringAllLinesFastRmk;
		this.pilotOnBoardArr = pilotOnBoardArr;
		this.pagerows = pagerows;
		this.lashingSingedOff = lashingSingedOff;
		this.operation = operation;
		this.anchorDropBbo = anchorDropBbo;
		this.anchorDropVms = anchorDropVms;
		this.unmooringAllLinesRelease = unmooringAllLinesRelease;
		this.unmooringReleaseRmk = unmooringReleaseRmk;
		this.driftingEndBbo = driftingEndBbo;
		this.safetyNetRmk = safetyNetRmk;
		this.customsOnBoardRmk = customsOnBoardRmk;
		this.immigrationAgentOnBoard = immigrationAgentOnBoard;
		this.rhq = rhq;
		this.restowRmk = restowRmk;
		this.immigrationAgentOnBoardRmk = immigrationAgentOnBoardRmk;
		this.pltOutDt = pltOutDt;
		this.pilotOnBoardDepRmk = pilotOnBoardDepRmk;
		this.vvd = vvd;
		this.restow = restow;
		this.lasherOnBoard = lasherOnBoard;
		this.twinLift = twinLift;
		this.portTmActUpdDt = portTmActUpdDt;
		this.operationRmk = operationRmk;
		this.anchorAwayVms = anchorAwayVms;
		this.sailingIn = sailingIn;
		this.twinLiftRmk = twinLiftRmk;
		this.gangwayDown = gangwayDown;
		this.agentOffBoard = agentOffBoard;
		this.ibflag = ibflag;
		this.pilotOnBoardArrRmk = pilotOnBoardArrRmk;
		this.stwDifHrs = stwDifHrs;
		this.dualCycleRmk = dualCycleRmk;
		this.quarantineOnBoardRmk = quarantineOnBoardRmk;
		this.quarantineOnBoard = quarantineOnBoard;
		this.gantryCraneReadyRmk = gantryCraneReadyRmk;
		this.lasherOnBoardRmk = lasherOnBoardRmk;
		this.anchorAwayBbo = anchorAwayBbo;
		this.tugBoatReady = tugBoatReady;
		this.agentOffBoardRmk = agentOffBoardRmk;
		this.safetyNet = safetyNet;
		this.gangwayDownRmk = gangwayDownRmk;
		this.tugBoatReadyRmk = tugBoatReadyRmk;
		this.mooringAllLinesFast = mooringAllLinesFast;
		this.gangMoveToBerth = gangMoveToBerth;
		this.pilotOnBoardDep = pilotOnBoardDep;
		this.sailingInRmk = sailingInRmk;
		this.gangwayUpRmk = gangwayUpRmk;
		this.slanCd = slanCd;
		this.ydCd = ydCd;
		this.gangwayUp = gangwayUp;
		this.clptIndSeq = clptIndSeq;
		this.gantryCraneReady = gantryCraneReady;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tdr_mvs", getTdrMvs());
		this.hashColumns.put("plt_in_dt", getPltInDt());
		this.hashColumns.put("lashing_singed_off_rmk", getLashingSingedOffRmk());
		this.hashColumns.put("gang_move_to_berth_rmk", getGangMoveToBerthRmk());
		this.hashColumns.put("dual_cycle", getDualCycle());
		this.hashColumns.put("stw_dif_hrs_flg", getStwDifHrsFlg());
		this.hashColumns.put("drifting_start_bbo", getDriftingStartBbo());
		this.hashColumns.put("customs_inspection_on_board", getCustomsInspectionOnBoard());
		this.hashColumns.put("mooring_all_lines_fast_rmk", getMooringAllLinesFastRmk());
		this.hashColumns.put("pilot_on_board_arr", getPilotOnBoardArr());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("lashing_singed_off", getLashingSingedOff());
		this.hashColumns.put("operation", getOperation());
		this.hashColumns.put("anchor_drop_bbo", getAnchorDropBbo());
		this.hashColumns.put("anchor_drop_vms", getAnchorDropVms());
		this.hashColumns.put("unmooring_all_lines_release", getUnmooringAllLinesRelease());
		this.hashColumns.put("unmooring_release_rmk", getUnmooringReleaseRmk());
		this.hashColumns.put("drifting_end_bbo", getDriftingEndBbo());
		this.hashColumns.put("safety_net_rmk", getSafetyNetRmk());
		this.hashColumns.put("customs_on_board_rmk", getCustomsOnBoardRmk());
		this.hashColumns.put("immigration_agent_on_board", getImmigrationAgentOnBoard());
		this.hashColumns.put("rhq", getRhq());
		this.hashColumns.put("restow_rmk", getRestowRmk());
		this.hashColumns.put("immigration_agent_on_board_rmk", getImmigrationAgentOnBoardRmk());
		this.hashColumns.put("plt_out_dt", getPltOutDt());
		this.hashColumns.put("pilot_on_board_dep_rmk", getPilotOnBoardDepRmk());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("restow", getRestow());
		this.hashColumns.put("lasher_on_board", getLasherOnBoard());
		this.hashColumns.put("twin_lift", getTwinLift());
		this.hashColumns.put("port_tm_act_upd_dt", getPortTmActUpdDt());
		this.hashColumns.put("operation_rmk", getOperationRmk());
		this.hashColumns.put("anchor_away_vms", getAnchorAwayVms());
		this.hashColumns.put("sailing_in", getSailingIn());
		this.hashColumns.put("twin_lift_rmk", getTwinLiftRmk());
		this.hashColumns.put("gangway_down", getGangwayDown());
		this.hashColumns.put("agent_off_board", getAgentOffBoard());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pilot_on_board_arr_rmk", getPilotOnBoardArrRmk());
		this.hashColumns.put("stw_dif_hrs", getStwDifHrs());
		this.hashColumns.put("dual_cycle_rmk", getDualCycleRmk());
		this.hashColumns.put("quarantine_on_board_rmk", getQuarantineOnBoardRmk());
		this.hashColumns.put("quarantine_on_board", getQuarantineOnBoard());
		this.hashColumns.put("gantry_crane_ready_rmk", getGantryCraneReadyRmk());
		this.hashColumns.put("lasher_on_board_rmk", getLasherOnBoardRmk());
		this.hashColumns.put("anchor_away_bbo", getAnchorAwayBbo());
		this.hashColumns.put("tug_boat_ready", getTugBoatReady());
		this.hashColumns.put("agent_off_board_rmk", getAgentOffBoardRmk());
		this.hashColumns.put("safety_net", getSafetyNet());
		this.hashColumns.put("gangway_down_rmk", getGangwayDownRmk());
		this.hashColumns.put("tug_boat_ready_rmk", getTugBoatReadyRmk());
		this.hashColumns.put("mooring_all_lines_fast", getMooringAllLinesFast());
		this.hashColumns.put("gang_move_to_berth", getGangMoveToBerth());
		this.hashColumns.put("pilot_on_board_dep", getPilotOnBoardDep());
		this.hashColumns.put("sailing_in_rmk", getSailingInRmk());
		this.hashColumns.put("gangway_up_rmk", getGangwayUpRmk());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("gangway_up", getGangwayUp());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("gantry_crane_ready", getGantryCraneReady());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tdr_mvs", "tdrMvs");
		this.hashFields.put("plt_in_dt", "pltInDt");
		this.hashFields.put("lashing_singed_off_rmk", "lashingSingedOffRmk");
		this.hashFields.put("gang_move_to_berth_rmk", "gangMoveToBerthRmk");
		this.hashFields.put("dual_cycle", "dualCycle");
		this.hashFields.put("stw_dif_hrs_flg", "stwDifHrsFlg");
		this.hashFields.put("drifting_start_bbo", "driftingStartBbo");
		this.hashFields.put("customs_inspection_on_board", "customsInspectionOnBoard");
		this.hashFields.put("mooring_all_lines_fast_rmk", "mooringAllLinesFastRmk");
		this.hashFields.put("pilot_on_board_arr", "pilotOnBoardArr");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lashing_singed_off", "lashingSingedOff");
		this.hashFields.put("operation", "operation");
		this.hashFields.put("anchor_drop_bbo", "anchorDropBbo");
		this.hashFields.put("anchor_drop_vms", "anchorDropVms");
		this.hashFields.put("unmooring_all_lines_release", "unmooringAllLinesRelease");
		this.hashFields.put("unmooring_release_rmk", "unmooringReleaseRmk");
		this.hashFields.put("drifting_end_bbo", "driftingEndBbo");
		this.hashFields.put("safety_net_rmk", "safetyNetRmk");
		this.hashFields.put("customs_on_board_rmk", "customsOnBoardRmk");
		this.hashFields.put("immigration_agent_on_board", "immigrationAgentOnBoard");
		this.hashFields.put("rhq", "rhq");
		this.hashFields.put("restow_rmk", "restowRmk");
		this.hashFields.put("immigration_agent_on_board_rmk", "immigrationAgentOnBoardRmk");
		this.hashFields.put("plt_out_dt", "pltOutDt");
		this.hashFields.put("pilot_on_board_dep_rmk", "pilotOnBoardDepRmk");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("restow", "restow");
		this.hashFields.put("lasher_on_board", "lasherOnBoard");
		this.hashFields.put("twin_lift", "twinLift");
		this.hashFields.put("port_tm_act_upd_dt", "portTmActUpdDt");
		this.hashFields.put("operation_rmk", "operationRmk");
		this.hashFields.put("anchor_away_vms", "anchorAwayVms");
		this.hashFields.put("sailing_in", "sailingIn");
		this.hashFields.put("twin_lift_rmk", "twinLiftRmk");
		this.hashFields.put("gangway_down", "gangwayDown");
		this.hashFields.put("agent_off_board", "agentOffBoard");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pilot_on_board_arr_rmk", "pilotOnBoardArrRmk");
		this.hashFields.put("stw_dif_hrs", "stwDifHrs");
		this.hashFields.put("dual_cycle_rmk", "dualCycleRmk");
		this.hashFields.put("quarantine_on_board_rmk", "quarantineOnBoardRmk");
		this.hashFields.put("quarantine_on_board", "quarantineOnBoard");
		this.hashFields.put("gantry_crane_ready_rmk", "gantryCraneReadyRmk");
		this.hashFields.put("lasher_on_board_rmk", "lasherOnBoardRmk");
		this.hashFields.put("anchor_away_bbo", "anchorAwayBbo");
		this.hashFields.put("tug_boat_ready", "tugBoatReady");
		this.hashFields.put("agent_off_board_rmk", "agentOffBoardRmk");
		this.hashFields.put("safety_net", "safetyNet");
		this.hashFields.put("gangway_down_rmk", "gangwayDownRmk");
		this.hashFields.put("tug_boat_ready_rmk", "tugBoatReadyRmk");
		this.hashFields.put("mooring_all_lines_fast", "mooringAllLinesFast");
		this.hashFields.put("gang_move_to_berth", "gangMoveToBerth");
		this.hashFields.put("pilot_on_board_dep", "pilotOnBoardDep");
		this.hashFields.put("sailing_in_rmk", "sailingInRmk");
		this.hashFields.put("gangway_up_rmk", "gangwayUpRmk");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("gangway_up", "gangwayUp");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("gantry_crane_ready", "gantryCraneReady");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return tdrMvs
	 */
	public String getTdrMvs() {
		return this.tdrMvs;
	}
	
	/**
	 * Column Info
	 * @return pltInDt
	 */
	public String getPltInDt() {
		return this.pltInDt;
	}
	
	/**
	 * Column Info
	 * @return lashingSingedOffRmk
	 */
	public String getLashingSingedOffRmk() {
		return this.lashingSingedOffRmk;
	}
	
	/**
	 * Column Info
	 * @return gangMoveToBerthRmk
	 */
	public String getGangMoveToBerthRmk() {
		return this.gangMoveToBerthRmk;
	}
	
	/**
	 * Column Info
	 * @return dualCycle
	 */
	public String getDualCycle() {
		return this.dualCycle;
	}
	
	/**
	 * Column Info
	 * @return stwDifHrsFlg
	 */
	public String getStwDifHrsFlg() {
		return this.stwDifHrsFlg;
	}
	
	/**
	 * Column Info
	 * @return driftingStartBbo
	 */
	public String getDriftingStartBbo() {
		return this.driftingStartBbo;
	}
	
	/**
	 * Column Info
	 * @return customsInspectionOnBoard
	 */
	public String getCustomsInspectionOnBoard() {
		return this.customsInspectionOnBoard;
	}
	
	/**
	 * Column Info
	 * @return mooringAllLinesFastRmk
	 */
	public String getMooringAllLinesFastRmk() {
		return this.mooringAllLinesFastRmk;
	}
	
	/**
	 * Column Info
	 * @return pilotOnBoardArr
	 */
	public String getPilotOnBoardArr() {
		return this.pilotOnBoardArr;
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
	 * @return lashingSingedOff
	 */
	public String getLashingSingedOff() {
		return this.lashingSingedOff;
	}
	
	/**
	 * Column Info
	 * @return operation
	 */
	public String getOperation() {
		return this.operation;
	}
	
	/**
	 * Column Info
	 * @return anchorDropBbo
	 */
	public String getAnchorDropBbo() {
		return this.anchorDropBbo;
	}
	
	/**
	 * Column Info
	 * @return anchorDropVms
	 */
	public String getAnchorDropVms() {
		return this.anchorDropVms;
	}
	
	/**
	 * Column Info
	 * @return unmooringAllLinesRelease
	 */
	public String getUnmooringAllLinesRelease() {
		return this.unmooringAllLinesRelease;
	}
	
	/**
	 * Column Info
	 * @return unmooringReleaseRmk
	 */
	public String getUnmooringReleaseRmk() {
		return this.unmooringReleaseRmk;
	}
	
	/**
	 * Column Info
	 * @return driftingEndBbo
	 */
	public String getDriftingEndBbo() {
		return this.driftingEndBbo;
	}
	
	/**
	 * Column Info
	 * @return safetyNetRmk
	 */
	public String getSafetyNetRmk() {
		return this.safetyNetRmk;
	}
	
	/**
	 * Column Info
	 * @return customsOnBoardRmk
	 */
	public String getCustomsOnBoardRmk() {
		return this.customsOnBoardRmk;
	}
	
	/**
	 * Column Info
	 * @return immigrationAgentOnBoard
	 */
	public String getImmigrationAgentOnBoard() {
		return this.immigrationAgentOnBoard;
	}
	
	/**
	 * Column Info
	 * @return rhq
	 */
	public String getRhq() {
		return this.rhq;
	}
	
	/**
	 * Column Info
	 * @return restowRmk
	 */
	public String getRestowRmk() {
		return this.restowRmk;
	}
	
	/**
	 * Column Info
	 * @return immigrationAgentOnBoardRmk
	 */
	public String getImmigrationAgentOnBoardRmk() {
		return this.immigrationAgentOnBoardRmk;
	}
	
	/**
	 * Column Info
	 * @return pltOutDt
	 */
	public String getPltOutDt() {
		return this.pltOutDt;
	}
	
	/**
	 * Column Info
	 * @return pilotOnBoardDepRmk
	 */
	public String getPilotOnBoardDepRmk() {
		return this.pilotOnBoardDepRmk;
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
	 * @return restow
	 */
	public String getRestow() {
		return this.restow;
	}
	
	/**
	 * Column Info
	 * @return lasherOnBoard
	 */
	public String getLasherOnBoard() {
		return this.lasherOnBoard;
	}
	
	/**
	 * Column Info
	 * @return twinLift
	 */
	public String getTwinLift() {
		return this.twinLift;
	}
	
	/**
	 * Column Info
	 * @return portTmActUpdDt
	 */
	public String getPortTmActUpdDt() {
		return this.portTmActUpdDt;
	}
	
	/**
	 * Column Info
	 * @return operationRmk
	 */
	public String getOperationRmk() {
		return this.operationRmk;
	}
	
	/**
	 * Column Info
	 * @return anchorAwayVms
	 */
	public String getAnchorAwayVms() {
		return this.anchorAwayVms;
	}
	
	/**
	 * Column Info
	 * @return sailingIn
	 */
	public String getSailingIn() {
		return this.sailingIn;
	}
	
	/**
	 * Column Info
	 * @return twinLiftRmk
	 */
	public String getTwinLiftRmk() {
		return this.twinLiftRmk;
	}
	
	/**
	 * Column Info
	 * @return gangwayDown
	 */
	public String getGangwayDown() {
		return this.gangwayDown;
	}
	
	/**
	 * Column Info
	 * @return agentOffBoard
	 */
	public String getAgentOffBoard() {
		return this.agentOffBoard;
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
	 * @return pilotOnBoardArrRmk
	 */
	public String getPilotOnBoardArrRmk() {
		return this.pilotOnBoardArrRmk;
	}
	
	/**
	 * Column Info
	 * @return stwDifHrs
	 */
	public String getStwDifHrs() {
		return this.stwDifHrs;
	}
	
	/**
	 * Column Info
	 * @return dualCycleRmk
	 */
	public String getDualCycleRmk() {
		return this.dualCycleRmk;
	}
	
	/**
	 * Column Info
	 * @return quarantineOnBoardRmk
	 */
	public String getQuarantineOnBoardRmk() {
		return this.quarantineOnBoardRmk;
	}
	
	/**
	 * Column Info
	 * @return quarantineOnBoard
	 */
	public String getQuarantineOnBoard() {
		return this.quarantineOnBoard;
	}
	
	/**
	 * Column Info
	 * @return gantryCraneReadyRmk
	 */
	public String getGantryCraneReadyRmk() {
		return this.gantryCraneReadyRmk;
	}
	
	/**
	 * Column Info
	 * @return lasherOnBoardRmk
	 */
	public String getLasherOnBoardRmk() {
		return this.lasherOnBoardRmk;
	}
	
	/**
	 * Column Info
	 * @return anchorAwayBbo
	 */
	public String getAnchorAwayBbo() {
		return this.anchorAwayBbo;
	}
	
	/**
	 * Column Info
	 * @return tugBoatReady
	 */
	public String getTugBoatReady() {
		return this.tugBoatReady;
	}
	
	/**
	 * Column Info
	 * @return agentOffBoardRmk
	 */
	public String getAgentOffBoardRmk() {
		return this.agentOffBoardRmk;
	}
	
	/**
	 * Column Info
	 * @return safetyNet
	 */
	public String getSafetyNet() {
		return this.safetyNet;
	}
	
	/**
	 * Column Info
	 * @return gangwayDownRmk
	 */
	public String getGangwayDownRmk() {
		return this.gangwayDownRmk;
	}
	
	/**
	 * Column Info
	 * @return tugBoatReadyRmk
	 */
	public String getTugBoatReadyRmk() {
		return this.tugBoatReadyRmk;
	}
	
	/**
	 * Column Info
	 * @return mooringAllLinesFast
	 */
	public String getMooringAllLinesFast() {
		return this.mooringAllLinesFast;
	}
	
	/**
	 * Column Info
	 * @return gangMoveToBerth
	 */
	public String getGangMoveToBerth() {
		return this.gangMoveToBerth;
	}
	
	/**
	 * Column Info
	 * @return pilotOnBoardDep
	 */
	public String getPilotOnBoardDep() {
		return this.pilotOnBoardDep;
	}
	
	/**
	 * Column Info
	 * @return sailingInRmk
	 */
	public String getSailingInRmk() {
		return this.sailingInRmk;
	}
	
	/**
	 * Column Info
	 * @return gangwayUpRmk
	 */
	public String getGangwayUpRmk() {
		return this.gangwayUpRmk;
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
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return gangwayUp
	 */
	public String getGangwayUp() {
		return this.gangwayUp;
	}
	
	/**
	 * Column Info
	 * @return clptIndSeq
	 */
	public String getClptIndSeq() {
		return this.clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return gantryCraneReady
	 */
	public String getGantryCraneReady() {
		return this.gantryCraneReady;
	}
	

	/**
	 * Column Info
	 * @param tdrMvs
	 */
	public void setTdrMvs(String tdrMvs) {
		this.tdrMvs = tdrMvs;
	}
	
	/**
	 * Column Info
	 * @param pltInDt
	 */
	public void setPltInDt(String pltInDt) {
		this.pltInDt = pltInDt;
	}
	
	/**
	 * Column Info
	 * @param lashingSingedOffRmk
	 */
	public void setLashingSingedOffRmk(String lashingSingedOffRmk) {
		this.lashingSingedOffRmk = lashingSingedOffRmk;
	}
	
	/**
	 * Column Info
	 * @param gangMoveToBerthRmk
	 */
	public void setGangMoveToBerthRmk(String gangMoveToBerthRmk) {
		this.gangMoveToBerthRmk = gangMoveToBerthRmk;
	}
	
	/**
	 * Column Info
	 * @param dualCycle
	 */
	public void setDualCycle(String dualCycle) {
		this.dualCycle = dualCycle;
	}
	
	/**
	 * Column Info
	 * @param stwDifHrsFlg
	 */
	public void setStwDifHrsFlg(String stwDifHrsFlg) {
		this.stwDifHrsFlg = stwDifHrsFlg;
	}
	
	/**
	 * Column Info
	 * @param driftingStartBbo
	 */
	public void setDriftingStartBbo(String driftingStartBbo) {
		this.driftingStartBbo = driftingStartBbo;
	}
	
	/**
	 * Column Info
	 * @param customsInspectionOnBoard
	 */
	public void setCustomsInspectionOnBoard(String customsInspectionOnBoard) {
		this.customsInspectionOnBoard = customsInspectionOnBoard;
	}
	
	/**
	 * Column Info
	 * @param mooringAllLinesFastRmk
	 */
	public void setMooringAllLinesFastRmk(String mooringAllLinesFastRmk) {
		this.mooringAllLinesFastRmk = mooringAllLinesFastRmk;
	}
	
	/**
	 * Column Info
	 * @param pilotOnBoardArr
	 */
	public void setPilotOnBoardArr(String pilotOnBoardArr) {
		this.pilotOnBoardArr = pilotOnBoardArr;
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
	 * @param lashingSingedOff
	 */
	public void setLashingSingedOff(String lashingSingedOff) {
		this.lashingSingedOff = lashingSingedOff;
	}
	
	/**
	 * Column Info
	 * @param operation
	 */
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	/**
	 * Column Info
	 * @param anchorDropBbo
	 */
	public void setAnchorDropBbo(String anchorDropBbo) {
		this.anchorDropBbo = anchorDropBbo;
	}
	
	/**
	 * Column Info
	 * @param anchorDropVms
	 */
	public void setAnchorDropVms(String anchorDropVms) {
		this.anchorDropVms = anchorDropVms;
	}
	
	/**
	 * Column Info
	 * @param unmooringAllLinesRelease
	 */
	public void setUnmooringAllLinesRelease(String unmooringAllLinesRelease) {
		this.unmooringAllLinesRelease = unmooringAllLinesRelease;
	}
	
	/**
	 * Column Info
	 * @param unmooringReleaseRmk
	 */
	public void setUnmooringReleaseRmk(String unmooringReleaseRmk) {
		this.unmooringReleaseRmk = unmooringReleaseRmk;
	}
	
	/**
	 * Column Info
	 * @param driftingEndBbo
	 */
	public void setDriftingEndBbo(String driftingEndBbo) {
		this.driftingEndBbo = driftingEndBbo;
	}
	
	/**
	 * Column Info
	 * @param safetyNetRmk
	 */
	public void setSafetyNetRmk(String safetyNetRmk) {
		this.safetyNetRmk = safetyNetRmk;
	}
	
	/**
	 * Column Info
	 * @param customsOnBoardRmk
	 */
	public void setCustomsOnBoardRmk(String customsOnBoardRmk) {
		this.customsOnBoardRmk = customsOnBoardRmk;
	}
	
	/**
	 * Column Info
	 * @param immigrationAgentOnBoard
	 */
	public void setImmigrationAgentOnBoard(String immigrationAgentOnBoard) {
		this.immigrationAgentOnBoard = immigrationAgentOnBoard;
	}
	
	/**
	 * Column Info
	 * @param rhq
	 */
	public void setRhq(String rhq) {
		this.rhq = rhq;
	}
	
	/**
	 * Column Info
	 * @param restowRmk
	 */
	public void setRestowRmk(String restowRmk) {
		this.restowRmk = restowRmk;
	}
	
	/**
	 * Column Info
	 * @param immigrationAgentOnBoardRmk
	 */
	public void setImmigrationAgentOnBoardRmk(String immigrationAgentOnBoardRmk) {
		this.immigrationAgentOnBoardRmk = immigrationAgentOnBoardRmk;
	}
	
	/**
	 * Column Info
	 * @param pltOutDt
	 */
	public void setPltOutDt(String pltOutDt) {
		this.pltOutDt = pltOutDt;
	}
	
	/**
	 * Column Info
	 * @param pilotOnBoardDepRmk
	 */
	public void setPilotOnBoardDepRmk(String pilotOnBoardDepRmk) {
		this.pilotOnBoardDepRmk = pilotOnBoardDepRmk;
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
	 * @param restow
	 */
	public void setRestow(String restow) {
		this.restow = restow;
	}
	
	/**
	 * Column Info
	 * @param lasherOnBoard
	 */
	public void setLasherOnBoard(String lasherOnBoard) {
		this.lasherOnBoard = lasherOnBoard;
	}
	
	/**
	 * Column Info
	 * @param twinLift
	 */
	public void setTwinLift(String twinLift) {
		this.twinLift = twinLift;
	}
	
	/**
	 * Column Info
	 * @param portTmActUpdDt
	 */
	public void setPortTmActUpdDt(String portTmActUpdDt) {
		this.portTmActUpdDt = portTmActUpdDt;
	}
	
	/**
	 * Column Info
	 * @param operationRmk
	 */
	public void setOperationRmk(String operationRmk) {
		this.operationRmk = operationRmk;
	}
	
	/**
	 * Column Info
	 * @param anchorAwayVms
	 */
	public void setAnchorAwayVms(String anchorAwayVms) {
		this.anchorAwayVms = anchorAwayVms;
	}
	
	/**
	 * Column Info
	 * @param sailingIn
	 */
	public void setSailingIn(String sailingIn) {
		this.sailingIn = sailingIn;
	}
	
	/**
	 * Column Info
	 * @param twinLiftRmk
	 */
	public void setTwinLiftRmk(String twinLiftRmk) {
		this.twinLiftRmk = twinLiftRmk;
	}
	
	/**
	 * Column Info
	 * @param gangwayDown
	 */
	public void setGangwayDown(String gangwayDown) {
		this.gangwayDown = gangwayDown;
	}
	
	/**
	 * Column Info
	 * @param agentOffBoard
	 */
	public void setAgentOffBoard(String agentOffBoard) {
		this.agentOffBoard = agentOffBoard;
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
	 * @param pilotOnBoardArrRmk
	 */
	public void setPilotOnBoardArrRmk(String pilotOnBoardArrRmk) {
		this.pilotOnBoardArrRmk = pilotOnBoardArrRmk;
	}
	
	/**
	 * Column Info
	 * @param stwDifHrs
	 */
	public void setStwDifHrs(String stwDifHrs) {
		this.stwDifHrs = stwDifHrs;
	}
	
	/**
	 * Column Info
	 * @param dualCycleRmk
	 */
	public void setDualCycleRmk(String dualCycleRmk) {
		this.dualCycleRmk = dualCycleRmk;
	}
	
	/**
	 * Column Info
	 * @param quarantineOnBoardRmk
	 */
	public void setQuarantineOnBoardRmk(String quarantineOnBoardRmk) {
		this.quarantineOnBoardRmk = quarantineOnBoardRmk;
	}
	
	/**
	 * Column Info
	 * @param quarantineOnBoard
	 */
	public void setQuarantineOnBoard(String quarantineOnBoard) {
		this.quarantineOnBoard = quarantineOnBoard;
	}
	
	/**
	 * Column Info
	 * @param gantryCraneReadyRmk
	 */
	public void setGantryCraneReadyRmk(String gantryCraneReadyRmk) {
		this.gantryCraneReadyRmk = gantryCraneReadyRmk;
	}
	
	/**
	 * Column Info
	 * @param lasherOnBoardRmk
	 */
	public void setLasherOnBoardRmk(String lasherOnBoardRmk) {
		this.lasherOnBoardRmk = lasherOnBoardRmk;
	}
	
	/**
	 * Column Info
	 * @param anchorAwayBbo
	 */
	public void setAnchorAwayBbo(String anchorAwayBbo) {
		this.anchorAwayBbo = anchorAwayBbo;
	}
	
	/**
	 * Column Info
	 * @param tugBoatReady
	 */
	public void setTugBoatReady(String tugBoatReady) {
		this.tugBoatReady = tugBoatReady;
	}
	
	/**
	 * Column Info
	 * @param agentOffBoardRmk
	 */
	public void setAgentOffBoardRmk(String agentOffBoardRmk) {
		this.agentOffBoardRmk = agentOffBoardRmk;
	}
	
	/**
	 * Column Info
	 * @param safetyNet
	 */
	public void setSafetyNet(String safetyNet) {
		this.safetyNet = safetyNet;
	}
	
	/**
	 * Column Info
	 * @param gangwayDownRmk
	 */
	public void setGangwayDownRmk(String gangwayDownRmk) {
		this.gangwayDownRmk = gangwayDownRmk;
	}
	
	/**
	 * Column Info
	 * @param tugBoatReadyRmk
	 */
	public void setTugBoatReadyRmk(String tugBoatReadyRmk) {
		this.tugBoatReadyRmk = tugBoatReadyRmk;
	}
	
	/**
	 * Column Info
	 * @param mooringAllLinesFast
	 */
	public void setMooringAllLinesFast(String mooringAllLinesFast) {
		this.mooringAllLinesFast = mooringAllLinesFast;
	}
	
	/**
	 * Column Info
	 * @param gangMoveToBerth
	 */
	public void setGangMoveToBerth(String gangMoveToBerth) {
		this.gangMoveToBerth = gangMoveToBerth;
	}
	
	/**
	 * Column Info
	 * @param pilotOnBoardDep
	 */
	public void setPilotOnBoardDep(String pilotOnBoardDep) {
		this.pilotOnBoardDep = pilotOnBoardDep;
	}
	
	/**
	 * Column Info
	 * @param sailingInRmk
	 */
	public void setSailingInRmk(String sailingInRmk) {
		this.sailingInRmk = sailingInRmk;
	}
	
	/**
	 * Column Info
	 * @param gangwayUpRmk
	 */
	public void setGangwayUpRmk(String gangwayUpRmk) {
		this.gangwayUpRmk = gangwayUpRmk;
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
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param gangwayUp
	 */
	public void setGangwayUp(String gangwayUp) {
		this.gangwayUp = gangwayUp;
	}
	
	/**
	 * Column Info
	 * @param clptIndSeq
	 */
	public void setClptIndSeq(String clptIndSeq) {
		this.clptIndSeq = clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param gantryCraneReady
	 */
	public void setGantryCraneReady(String gantryCraneReady) {
		this.gantryCraneReady = gantryCraneReady;
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
		setTdrMvs(JSPUtil.getParameter(request, prefix + "tdr_mvs", ""));
		setPltInDt(JSPUtil.getParameter(request, prefix + "plt_in_dt", ""));
		setLashingSingedOffRmk(JSPUtil.getParameter(request, prefix + "lashing_singed_off_rmk", ""));
		setGangMoveToBerthRmk(JSPUtil.getParameter(request, prefix + "gang_move_to_berth_rmk", ""));
		setDualCycle(JSPUtil.getParameter(request, prefix + "dual_cycle", ""));
		setStwDifHrsFlg(JSPUtil.getParameter(request, prefix + "stw_dif_hrs_flg", ""));
		setDriftingStartBbo(JSPUtil.getParameter(request, prefix + "drifting_start_bbo", ""));
		setCustomsInspectionOnBoard(JSPUtil.getParameter(request, prefix + "customs_inspection_on_board", ""));
		setMooringAllLinesFastRmk(JSPUtil.getParameter(request, prefix + "mooring_all_lines_fast_rmk", ""));
		setPilotOnBoardArr(JSPUtil.getParameter(request, prefix + "pilot_on_board_arr", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setLashingSingedOff(JSPUtil.getParameter(request, prefix + "lashing_singed_off", ""));
		setOperation(JSPUtil.getParameter(request, prefix + "operation", ""));
		setAnchorDropBbo(JSPUtil.getParameter(request, prefix + "anchor_drop_bbo", ""));
		setAnchorDropVms(JSPUtil.getParameter(request, prefix + "anchor_drop_vms", ""));
		setUnmooringAllLinesRelease(JSPUtil.getParameter(request, prefix + "unmooring_all_lines_release", ""));
		setUnmooringReleaseRmk(JSPUtil.getParameter(request, prefix + "unmooring_release_rmk", ""));
		setDriftingEndBbo(JSPUtil.getParameter(request, prefix + "drifting_end_bbo", ""));
		setSafetyNetRmk(JSPUtil.getParameter(request, prefix + "safety_net_rmk", ""));
		setCustomsOnBoardRmk(JSPUtil.getParameter(request, prefix + "customs_on_board_rmk", ""));
		setImmigrationAgentOnBoard(JSPUtil.getParameter(request, prefix + "immigration_agent_on_board", ""));
		setRhq(JSPUtil.getParameter(request, prefix + "rhq", ""));
		setRestowRmk(JSPUtil.getParameter(request, prefix + "restow_rmk", ""));
		setImmigrationAgentOnBoardRmk(JSPUtil.getParameter(request, prefix + "immigration_agent_on_board_rmk", ""));
		setPltOutDt(JSPUtil.getParameter(request, prefix + "plt_out_dt", ""));
		setPilotOnBoardDepRmk(JSPUtil.getParameter(request, prefix + "pilot_on_board_dep_rmk", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setRestow(JSPUtil.getParameter(request, prefix + "restow", ""));
		setLasherOnBoard(JSPUtil.getParameter(request, prefix + "lasher_on_board", ""));
		setTwinLift(JSPUtil.getParameter(request, prefix + "twin_lift", ""));
		setPortTmActUpdDt(JSPUtil.getParameter(request, prefix + "port_tm_act_upd_dt", ""));
		setOperationRmk(JSPUtil.getParameter(request, prefix + "operation_rmk", ""));
		setAnchorAwayVms(JSPUtil.getParameter(request, prefix + "anchor_away_vms", ""));
		setSailingIn(JSPUtil.getParameter(request, prefix + "sailing_in", ""));
		setTwinLiftRmk(JSPUtil.getParameter(request, prefix + "twin_lift_rmk", ""));
		setGangwayDown(JSPUtil.getParameter(request, prefix + "gangway_down", ""));
		setAgentOffBoard(JSPUtil.getParameter(request, prefix + "agent_off_board", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPilotOnBoardArrRmk(JSPUtil.getParameter(request, prefix + "pilot_on_board_arr_rmk", ""));
		setStwDifHrs(JSPUtil.getParameter(request, prefix + "stw_dif_hrs", ""));
		setDualCycleRmk(JSPUtil.getParameter(request, prefix + "dual_cycle_rmk", ""));
		setQuarantineOnBoardRmk(JSPUtil.getParameter(request, prefix + "quarantine_on_board_rmk", ""));
		setQuarantineOnBoard(JSPUtil.getParameter(request, prefix + "quarantine_on_board", ""));
		setGantryCraneReadyRmk(JSPUtil.getParameter(request, prefix + "gantry_crane_ready_rmk", ""));
		setLasherOnBoardRmk(JSPUtil.getParameter(request, prefix + "lasher_on_board_rmk", ""));
		setAnchorAwayBbo(JSPUtil.getParameter(request, prefix + "anchor_away_bbo", ""));
		setTugBoatReady(JSPUtil.getParameter(request, prefix + "tug_boat_ready", ""));
		setAgentOffBoardRmk(JSPUtil.getParameter(request, prefix + "agent_off_board_rmk", ""));
		setSafetyNet(JSPUtil.getParameter(request, prefix + "safety_net", ""));
		setGangwayDownRmk(JSPUtil.getParameter(request, prefix + "gangway_down_rmk", ""));
		setTugBoatReadyRmk(JSPUtil.getParameter(request, prefix + "tug_boat_ready_rmk", ""));
		setMooringAllLinesFast(JSPUtil.getParameter(request, prefix + "mooring_all_lines_fast", ""));
		setGangMoveToBerth(JSPUtil.getParameter(request, prefix + "gang_move_to_berth", ""));
		setPilotOnBoardDep(JSPUtil.getParameter(request, prefix + "pilot_on_board_dep", ""));
		setSailingInRmk(JSPUtil.getParameter(request, prefix + "sailing_in_rmk", ""));
		setGangwayUpRmk(JSPUtil.getParameter(request, prefix + "gangway_up_rmk", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setGangwayUp(JSPUtil.getParameter(request, prefix + "gangway_up", ""));
		setClptIndSeq(JSPUtil.getParameter(request, prefix + "clpt_ind_seq", ""));
		setGantryCraneReady(JSPUtil.getParameter(request, prefix + "gantry_crane_ready", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PortTimeActivityReportVO[]
	 */
	public PortTimeActivityReportVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PortTimeActivityReportVO[]
	 */
	public PortTimeActivityReportVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PortTimeActivityReportVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] tdrMvs = (JSPUtil.getParameter(request, prefix	+ "tdr_mvs", length));
			String[] pltInDt = (JSPUtil.getParameter(request, prefix	+ "plt_in_dt", length));
			String[] lashingSingedOffRmk = (JSPUtil.getParameter(request, prefix	+ "lashing_singed_off_rmk", length));
			String[] gangMoveToBerthRmk = (JSPUtil.getParameter(request, prefix	+ "gang_move_to_berth_rmk", length));
			String[] dualCycle = (JSPUtil.getParameter(request, prefix	+ "dual_cycle", length));
			String[] stwDifHrsFlg = (JSPUtil.getParameter(request, prefix	+ "stw_dif_hrs_flg", length));
			String[] driftingStartBbo = (JSPUtil.getParameter(request, prefix	+ "drifting_start_bbo", length));
			String[] customsInspectionOnBoard = (JSPUtil.getParameter(request, prefix	+ "customs_inspection_on_board", length));
			String[] mooringAllLinesFastRmk = (JSPUtil.getParameter(request, prefix	+ "mooring_all_lines_fast_rmk", length));
			String[] pilotOnBoardArr = (JSPUtil.getParameter(request, prefix	+ "pilot_on_board_arr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] lashingSingedOff = (JSPUtil.getParameter(request, prefix	+ "lashing_singed_off", length));
			String[] operation = (JSPUtil.getParameter(request, prefix	+ "operation", length));
			String[] anchorDropBbo = (JSPUtil.getParameter(request, prefix	+ "anchor_drop_bbo", length));
			String[] anchorDropVms = (JSPUtil.getParameter(request, prefix	+ "anchor_drop_vms", length));
			String[] unmooringAllLinesRelease = (JSPUtil.getParameter(request, prefix	+ "unmooring_all_lines_release", length));
			String[] unmooringReleaseRmk = (JSPUtil.getParameter(request, prefix	+ "unmooring_release_rmk", length));
			String[] driftingEndBbo = (JSPUtil.getParameter(request, prefix	+ "drifting_end_bbo", length));
			String[] safetyNetRmk = (JSPUtil.getParameter(request, prefix	+ "safety_net_rmk", length));
			String[] customsOnBoardRmk = (JSPUtil.getParameter(request, prefix	+ "customs_on_board_rmk", length));
			String[] immigrationAgentOnBoard = (JSPUtil.getParameter(request, prefix	+ "immigration_agent_on_board", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix	+ "rhq", length));
			String[] restowRmk = (JSPUtil.getParameter(request, prefix	+ "restow_rmk", length));
			String[] immigrationAgentOnBoardRmk = (JSPUtil.getParameter(request, prefix	+ "immigration_agent_on_board_rmk", length));
			String[] pltOutDt = (JSPUtil.getParameter(request, prefix	+ "plt_out_dt", length));
			String[] pilotOnBoardDepRmk = (JSPUtil.getParameter(request, prefix	+ "pilot_on_board_dep_rmk", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] restow = (JSPUtil.getParameter(request, prefix	+ "restow", length));
			String[] lasherOnBoard = (JSPUtil.getParameter(request, prefix	+ "lasher_on_board", length));
			String[] twinLift = (JSPUtil.getParameter(request, prefix	+ "twin_lift", length));
			String[] portTmActUpdDt = (JSPUtil.getParameter(request, prefix	+ "port_tm_act_upd_dt", length));
			String[] operationRmk = (JSPUtil.getParameter(request, prefix	+ "operation_rmk", length));
			String[] anchorAwayVms = (JSPUtil.getParameter(request, prefix	+ "anchor_away_vms", length));
			String[] sailingIn = (JSPUtil.getParameter(request, prefix	+ "sailing_in", length));
			String[] twinLiftRmk = (JSPUtil.getParameter(request, prefix	+ "twin_lift_rmk", length));
			String[] gangwayDown = (JSPUtil.getParameter(request, prefix	+ "gangway_down", length));
			String[] agentOffBoard = (JSPUtil.getParameter(request, prefix	+ "agent_off_board", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pilotOnBoardArrRmk = (JSPUtil.getParameter(request, prefix	+ "pilot_on_board_arr_rmk", length));
			String[] stwDifHrs = (JSPUtil.getParameter(request, prefix	+ "stw_dif_hrs", length));
			String[] dualCycleRmk = (JSPUtil.getParameter(request, prefix	+ "dual_cycle_rmk", length));
			String[] quarantineOnBoardRmk = (JSPUtil.getParameter(request, prefix	+ "quarantine_on_board_rmk", length));
			String[] quarantineOnBoard = (JSPUtil.getParameter(request, prefix	+ "quarantine_on_board", length));
			String[] gantryCraneReadyRmk = (JSPUtil.getParameter(request, prefix	+ "gantry_crane_ready_rmk", length));
			String[] lasherOnBoardRmk = (JSPUtil.getParameter(request, prefix	+ "lasher_on_board_rmk", length));
			String[] anchorAwayBbo = (JSPUtil.getParameter(request, prefix	+ "anchor_away_bbo", length));
			String[] tugBoatReady = (JSPUtil.getParameter(request, prefix	+ "tug_boat_ready", length));
			String[] agentOffBoardRmk = (JSPUtil.getParameter(request, prefix	+ "agent_off_board_rmk", length));
			String[] safetyNet = (JSPUtil.getParameter(request, prefix	+ "safety_net", length));
			String[] gangwayDownRmk = (JSPUtil.getParameter(request, prefix	+ "gangway_down_rmk", length));
			String[] tugBoatReadyRmk = (JSPUtil.getParameter(request, prefix	+ "tug_boat_ready_rmk", length));
			String[] mooringAllLinesFast = (JSPUtil.getParameter(request, prefix	+ "mooring_all_lines_fast", length));
			String[] gangMoveToBerth = (JSPUtil.getParameter(request, prefix	+ "gang_move_to_berth", length));
			String[] pilotOnBoardDep = (JSPUtil.getParameter(request, prefix	+ "pilot_on_board_dep", length));
			String[] sailingInRmk = (JSPUtil.getParameter(request, prefix	+ "sailing_in_rmk", length));
			String[] gangwayUpRmk = (JSPUtil.getParameter(request, prefix	+ "gangway_up_rmk", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] gangwayUp = (JSPUtil.getParameter(request, prefix	+ "gangway_up", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			String[] gantryCraneReady = (JSPUtil.getParameter(request, prefix	+ "gantry_crane_ready", length));
			
			for (int i = 0; i < length; i++) {
				model = new PortTimeActivityReportVO();
				if (tdrMvs[i] != null)
					model.setTdrMvs(tdrMvs[i]);
				if (pltInDt[i] != null)
					model.setPltInDt(pltInDt[i]);
				if (lashingSingedOffRmk[i] != null)
					model.setLashingSingedOffRmk(lashingSingedOffRmk[i]);
				if (gangMoveToBerthRmk[i] != null)
					model.setGangMoveToBerthRmk(gangMoveToBerthRmk[i]);
				if (dualCycle[i] != null)
					model.setDualCycle(dualCycle[i]);
				if (stwDifHrsFlg[i] != null)
					model.setStwDifHrsFlg(stwDifHrsFlg[i]);
				if (driftingStartBbo[i] != null)
					model.setDriftingStartBbo(driftingStartBbo[i]);
				if (customsInspectionOnBoard[i] != null)
					model.setCustomsInspectionOnBoard(customsInspectionOnBoard[i]);
				if (mooringAllLinesFastRmk[i] != null)
					model.setMooringAllLinesFastRmk(mooringAllLinesFastRmk[i]);
				if (pilotOnBoardArr[i] != null)
					model.setPilotOnBoardArr(pilotOnBoardArr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lashingSingedOff[i] != null)
					model.setLashingSingedOff(lashingSingedOff[i]);
				if (operation[i] != null)
					model.setOperation(operation[i]);
				if (anchorDropBbo[i] != null)
					model.setAnchorDropBbo(anchorDropBbo[i]);
				if (anchorDropVms[i] != null)
					model.setAnchorDropVms(anchorDropVms[i]);
				if (unmooringAllLinesRelease[i] != null)
					model.setUnmooringAllLinesRelease(unmooringAllLinesRelease[i]);
				if (unmooringReleaseRmk[i] != null)
					model.setUnmooringReleaseRmk(unmooringReleaseRmk[i]);
				if (driftingEndBbo[i] != null)
					model.setDriftingEndBbo(driftingEndBbo[i]);
				if (safetyNetRmk[i] != null)
					model.setSafetyNetRmk(safetyNetRmk[i]);
				if (customsOnBoardRmk[i] != null)
					model.setCustomsOnBoardRmk(customsOnBoardRmk[i]);
				if (immigrationAgentOnBoard[i] != null)
					model.setImmigrationAgentOnBoard(immigrationAgentOnBoard[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				if (restowRmk[i] != null)
					model.setRestowRmk(restowRmk[i]);
				if (immigrationAgentOnBoardRmk[i] != null)
					model.setImmigrationAgentOnBoardRmk(immigrationAgentOnBoardRmk[i]);
				if (pltOutDt[i] != null)
					model.setPltOutDt(pltOutDt[i]);
				if (pilotOnBoardDepRmk[i] != null)
					model.setPilotOnBoardDepRmk(pilotOnBoardDepRmk[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (restow[i] != null)
					model.setRestow(restow[i]);
				if (lasherOnBoard[i] != null)
					model.setLasherOnBoard(lasherOnBoard[i]);
				if (twinLift[i] != null)
					model.setTwinLift(twinLift[i]);
				if (portTmActUpdDt[i] != null)
					model.setPortTmActUpdDt(portTmActUpdDt[i]);
				if (operationRmk[i] != null)
					model.setOperationRmk(operationRmk[i]);
				if (anchorAwayVms[i] != null)
					model.setAnchorAwayVms(anchorAwayVms[i]);
				if (sailingIn[i] != null)
					model.setSailingIn(sailingIn[i]);
				if (twinLiftRmk[i] != null)
					model.setTwinLiftRmk(twinLiftRmk[i]);
				if (gangwayDown[i] != null)
					model.setGangwayDown(gangwayDown[i]);
				if (agentOffBoard[i] != null)
					model.setAgentOffBoard(agentOffBoard[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pilotOnBoardArrRmk[i] != null)
					model.setPilotOnBoardArrRmk(pilotOnBoardArrRmk[i]);
				if (stwDifHrs[i] != null)
					model.setStwDifHrs(stwDifHrs[i]);
				if (dualCycleRmk[i] != null)
					model.setDualCycleRmk(dualCycleRmk[i]);
				if (quarantineOnBoardRmk[i] != null)
					model.setQuarantineOnBoardRmk(quarantineOnBoardRmk[i]);
				if (quarantineOnBoard[i] != null)
					model.setQuarantineOnBoard(quarantineOnBoard[i]);
				if (gantryCraneReadyRmk[i] != null)
					model.setGantryCraneReadyRmk(gantryCraneReadyRmk[i]);
				if (lasherOnBoardRmk[i] != null)
					model.setLasherOnBoardRmk(lasherOnBoardRmk[i]);
				if (anchorAwayBbo[i] != null)
					model.setAnchorAwayBbo(anchorAwayBbo[i]);
				if (tugBoatReady[i] != null)
					model.setTugBoatReady(tugBoatReady[i]);
				if (agentOffBoardRmk[i] != null)
					model.setAgentOffBoardRmk(agentOffBoardRmk[i]);
				if (safetyNet[i] != null)
					model.setSafetyNet(safetyNet[i]);
				if (gangwayDownRmk[i] != null)
					model.setGangwayDownRmk(gangwayDownRmk[i]);
				if (tugBoatReadyRmk[i] != null)
					model.setTugBoatReadyRmk(tugBoatReadyRmk[i]);
				if (mooringAllLinesFast[i] != null)
					model.setMooringAllLinesFast(mooringAllLinesFast[i]);
				if (gangMoveToBerth[i] != null)
					model.setGangMoveToBerth(gangMoveToBerth[i]);
				if (pilotOnBoardDep[i] != null)
					model.setPilotOnBoardDep(pilotOnBoardDep[i]);
				if (sailingInRmk[i] != null)
					model.setSailingInRmk(sailingInRmk[i]);
				if (gangwayUpRmk[i] != null)
					model.setGangwayUpRmk(gangwayUpRmk[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (gangwayUp[i] != null)
					model.setGangwayUp(gangwayUp[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (gantryCraneReady[i] != null)
					model.setGantryCraneReady(gantryCraneReady[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPortTimeActivityReportVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PortTimeActivityReportVO[]
	 */
	public PortTimeActivityReportVO[] getPortTimeActivityReportVOs(){
		PortTimeActivityReportVO[] vos = (PortTimeActivityReportVO[])models.toArray(new PortTimeActivityReportVO[models.size()]);
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
		this.tdrMvs = this.tdrMvs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pltInDt = this.pltInDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lashingSingedOffRmk = this.lashingSingedOffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gangMoveToBerthRmk = this.gangMoveToBerthRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dualCycle = this.dualCycle .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwDifHrsFlg = this.stwDifHrsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.driftingStartBbo = this.driftingStartBbo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customsInspectionOnBoard = this.customsInspectionOnBoard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mooringAllLinesFastRmk = this.mooringAllLinesFastRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pilotOnBoardArr = this.pilotOnBoardArr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lashingSingedOff = this.lashingSingedOff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.operation = this.operation .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anchorDropBbo = this.anchorDropBbo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anchorDropVms = this.anchorDropVms .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unmooringAllLinesRelease = this.unmooringAllLinesRelease .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unmooringReleaseRmk = this.unmooringReleaseRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.driftingEndBbo = this.driftingEndBbo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.safetyNetRmk = this.safetyNetRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customsOnBoardRmk = this.customsOnBoardRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.immigrationAgentOnBoard = this.immigrationAgentOnBoard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.restowRmk = this.restowRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.immigrationAgentOnBoardRmk = this.immigrationAgentOnBoardRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pltOutDt = this.pltOutDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pilotOnBoardDepRmk = this.pilotOnBoardDepRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.restow = this.restow .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lasherOnBoard = this.lasherOnBoard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.twinLift = this.twinLift .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portTmActUpdDt = this.portTmActUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.operationRmk = this.operationRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anchorAwayVms = this.anchorAwayVms .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailingIn = this.sailingIn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.twinLiftRmk = this.twinLiftRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gangwayDown = this.gangwayDown .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agentOffBoard = this.agentOffBoard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pilotOnBoardArrRmk = this.pilotOnBoardArrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwDifHrs = this.stwDifHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dualCycleRmk = this.dualCycleRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.quarantineOnBoardRmk = this.quarantineOnBoardRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.quarantineOnBoard = this.quarantineOnBoard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gantryCraneReadyRmk = this.gantryCraneReadyRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lasherOnBoardRmk = this.lasherOnBoardRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anchorAwayBbo = this.anchorAwayBbo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tugBoatReady = this.tugBoatReady .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agentOffBoardRmk = this.agentOffBoardRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.safetyNet = this.safetyNet .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gangwayDownRmk = this.gangwayDownRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tugBoatReadyRmk = this.tugBoatReadyRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mooringAllLinesFast = this.mooringAllLinesFast .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gangMoveToBerth = this.gangMoveToBerth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pilotOnBoardDep = this.pilotOnBoardDep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailingInRmk = this.sailingInRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gangwayUpRmk = this.gangwayUpRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gangwayUp = this.gangwayUp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gantryCraneReady = this.gantryCraneReady .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
