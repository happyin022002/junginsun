/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ResultChangeStatusVO.java
*@FileTitle : ResultChangeStatusVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.08.20 서창열 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 서창열
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ResultChangeStatusVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ResultChangeStatusVO> models = new ArrayList<ResultChangeStatusVO>();
	
	/* Column Info */
	private String port20 = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String ieFlg = null;
	/* Column Info */
	private String actInpToDt = null;
	/* Column Info */
	private String state20 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ontmCnt = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* Column Info */
	private String port18 = null;
	/* Column Info */
	private String port19 = null;
	/* Column Info */
	private String port16 = null;
	/* Column Info */
	private String port17 = null;
	/* Column Info */
	private String port14 = null;
	/* Column Info */
	private String port15 = null;
	/* Column Info */
	private String port12 = null;
	/* Column Info */
	private String port13 = null;
	/* Column Info */
	private String port10 = null;
	/* Column Info */
	private String port11 = null;
	/* Column Info */
	private String cntHrs = null;
	/* Column Info */
	private String callCnt = null;
	/* Column Info */
	private String actInpFmDt = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String state1 = null;
	/* Column Info */
	private String state2 = null;
	/* Column Info */
	private String state3 = null;
	/* Column Info */
	private String groupFlg = null;
	/* Column Info */
	private String state4 = null;
	/* Column Info */
	private String state5 = null;
	/* Column Info */
	private String grpFlg = null;
	/* Column Info */
	private String state6 = null;
	/* Column Info */
	private String state7 = null;
	/* Column Info */
	private String maxSeq = null;
	/* Column Info */
	private String state8 = null;
	/* Column Info */
	private String state9 = null;
	/* Column Info */
	private String grpFlgCd = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String arrDep = null;
	/* Column Info */
	private String lane = null;
	/* Column Info */
	private String intgCdId = null;
	/* Column Info */
	private String port4 = null;
	/* Column Info */
	private String port3 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String port2 = null;
	/* Column Info */
	private String port1 = null;
	/* Column Info */
	private String port8 = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String port7 = null;
	/* Column Info */
	private String laneGrpNm = null;
	/* Column Info */
	private String port6 = null;
	/* Column Info */
	private String port5 = null;
	/* Column Info */
	private String port9 = null;
	/* Column Info */
	private String laneGrp = null;
	/* Column Info */
	private String state18 = null;
	/* Column Info */
	private String state19 = null;
	/* Column Info */
	private String state12 = null;
	/* Column Info */
	private String state13 = null;
	/* Column Info */
	private String state10 = null;
	/* Column Info */
	private String state11 = null;
	/* Column Info */
	private String state16 = null;
	/* Column Info */
	private String state17 = null;
	/* Column Info */
	private String state14 = null;
	/* Column Info */
	private String state15 = null;
	/* Column Info */
	private String crrCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ResultChangeStatusVO() {}

	public ResultChangeStatusVO(String ibflag, String pagerows, String maxSeq, String groupFlg, String vvd, String port1, String state1, String port2, String state2, String port3, String state3, String port4, String state4, String port5, String state5, String port6, String state6, String port7, String state7, String port8, String state8, String port9, String state9, String port10, String state10, String port11, String state11, String port12, String state12, String port13, String state13, String port14, String state14, String port15, String state15, String port16, String state16, String port17, String state17, String port18, String state18, String port19, String state19, String port20, String state20, String vslCd, String ieFlg, String actInpToDt, String vpsPortCd, String ontmCnt, String cntHrs, String callCnt, String actInpFmDt, String grpFlg, String vslSlanCd, String arrDep, String lane, String usrId, String laneGrpNm, String laneGrp, String intgCdId, String grpFlgCd, String crrCd) {
		this.port20 = port20;
		this.vslCd = vslCd;
		this.ieFlg = ieFlg;
		this.actInpToDt = actInpToDt;
		this.state20 = state20;
		this.pagerows = pagerows;
		this.ontmCnt = ontmCnt;
		this.vpsPortCd = vpsPortCd;
		this.port18 = port18;
		this.port19 = port19;
		this.port16 = port16;
		this.port17 = port17;
		this.port14 = port14;
		this.port15 = port15;
		this.port12 = port12;
		this.port13 = port13;
		this.port10 = port10;
		this.port11 = port11;
		this.cntHrs = cntHrs;
		this.callCnt = callCnt;
		this.actInpFmDt = actInpFmDt;
		this.vvd = vvd;
		this.state1 = state1;
		this.state2 = state2;
		this.state3 = state3;
		this.groupFlg = groupFlg;
		this.state4 = state4;
		this.state5 = state5;
		this.grpFlg = grpFlg;
		this.state6 = state6;
		this.state7 = state7;
		this.maxSeq = maxSeq;
		this.state8 = state8;
		this.state9 = state9;
		this.grpFlgCd = grpFlgCd;
		this.vslSlanCd = vslSlanCd;
		this.arrDep = arrDep;
		this.lane = lane;
		this.intgCdId = intgCdId;
		this.port4 = port4;
		this.port3 = port3;
		this.ibflag = ibflag;
		this.port2 = port2;
		this.port1 = port1;
		this.port8 = port8;
		this.usrId = usrId;
		this.port7 = port7;
		this.laneGrpNm = laneGrpNm;
		this.port6 = port6;
		this.port5 = port5;
		this.port9 = port9;
		this.laneGrp = laneGrp;
		this.state18 = state18;
		this.state19 = state19;
		this.state12 = state12;
		this.state13 = state13;
		this.state10 = state10;
		this.state11 = state11;
		this.state16 = state16;
		this.state17 = state17;
		this.state14 = state14;
		this.state15 = state15;
		this.crrCd = crrCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("port20", getPort20());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("ie_flg", getIeFlg());
		this.hashColumns.put("act_inp_to_dt", getActInpToDt());
		this.hashColumns.put("state20", getState20());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ontm_cnt", getOntmCnt());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("port18", getPort18());
		this.hashColumns.put("port19", getPort19());
		this.hashColumns.put("port16", getPort16());
		this.hashColumns.put("port17", getPort17());
		this.hashColumns.put("port14", getPort14());
		this.hashColumns.put("port15", getPort15());
		this.hashColumns.put("port12", getPort12());
		this.hashColumns.put("port13", getPort13());
		this.hashColumns.put("port10", getPort10());
		this.hashColumns.put("port11", getPort11());
		this.hashColumns.put("cnt_hrs", getCntHrs());
		this.hashColumns.put("call_cnt", getCallCnt());
		this.hashColumns.put("act_inp_fm_dt", getActInpFmDt());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("state1", getState1());
		this.hashColumns.put("state2", getState2());
		this.hashColumns.put("state3", getState3());
		this.hashColumns.put("group_flg", getGroupFlg());
		this.hashColumns.put("state4", getState4());
		this.hashColumns.put("state5", getState5());
		this.hashColumns.put("grp_flg", getGrpFlg());
		this.hashColumns.put("state6", getState6());
		this.hashColumns.put("state7", getState7());
		this.hashColumns.put("max_seq", getMaxSeq());
		this.hashColumns.put("state8", getState8());
		this.hashColumns.put("state9", getState9());
		this.hashColumns.put("grp_flg_cd", getGrpFlgCd());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("arr_dep", getArrDep());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("intg_cd_id", getIntgCdId());
		this.hashColumns.put("port4", getPort4());
		this.hashColumns.put("port3", getPort3());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("port2", getPort2());
		this.hashColumns.put("port1", getPort1());
		this.hashColumns.put("port8", getPort8());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("port7", getPort7());
		this.hashColumns.put("lane_grp_nm", getLaneGrpNm());
		this.hashColumns.put("port6", getPort6());
		this.hashColumns.put("port5", getPort5());
		this.hashColumns.put("port9", getPort9());
		this.hashColumns.put("lane_grp", getLaneGrp());
		this.hashColumns.put("state18", getState18());
		this.hashColumns.put("state19", getState19());
		this.hashColumns.put("state12", getState12());
		this.hashColumns.put("state13", getState13());
		this.hashColumns.put("state10", getState10());
		this.hashColumns.put("state11", getState11());
		this.hashColumns.put("state16", getState16());
		this.hashColumns.put("state17", getState17());
		this.hashColumns.put("state14", getState14());
		this.hashColumns.put("state15", getState15());
		this.hashColumns.put("crr_cd", getCrrCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("port20", "port20");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("ie_flg", "ieFlg");
		this.hashFields.put("act_inp_to_dt", "actInpToDt");
		this.hashFields.put("state20", "state20");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ontm_cnt", "ontmCnt");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("port18", "port18");
		this.hashFields.put("port19", "port19");
		this.hashFields.put("port16", "port16");
		this.hashFields.put("port17", "port17");
		this.hashFields.put("port14", "port14");
		this.hashFields.put("port15", "port15");
		this.hashFields.put("port12", "port12");
		this.hashFields.put("port13", "port13");
		this.hashFields.put("port10", "port10");
		this.hashFields.put("port11", "port11");
		this.hashFields.put("cnt_hrs", "cntHrs");
		this.hashFields.put("call_cnt", "callCnt");
		this.hashFields.put("act_inp_fm_dt", "actInpFmDt");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("state1", "state1");
		this.hashFields.put("state2", "state2");
		this.hashFields.put("state3", "state3");
		this.hashFields.put("group_flg", "groupFlg");
		this.hashFields.put("state4", "state4");
		this.hashFields.put("state5", "state5");
		this.hashFields.put("grp_flg", "grpFlg");
		this.hashFields.put("state6", "state6");
		this.hashFields.put("state7", "state7");
		this.hashFields.put("max_seq", "maxSeq");
		this.hashFields.put("state8", "state8");
		this.hashFields.put("state9", "state9");
		this.hashFields.put("grp_flg_cd", "grpFlgCd");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("arr_dep", "arrDep");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("intg_cd_id", "intgCdId");
		this.hashFields.put("port4", "port4");
		this.hashFields.put("port3", "port3");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("port2", "port2");
		this.hashFields.put("port1", "port1");
		this.hashFields.put("port8", "port8");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("port7", "port7");
		this.hashFields.put("lane_grp_nm", "laneGrpNm");
		this.hashFields.put("port6", "port6");
		this.hashFields.put("port5", "port5");
		this.hashFields.put("port9", "port9");
		this.hashFields.put("lane_grp", "laneGrp");
		this.hashFields.put("state18", "state18");
		this.hashFields.put("state19", "state19");
		this.hashFields.put("state12", "state12");
		this.hashFields.put("state13", "state13");
		this.hashFields.put("state10", "state10");
		this.hashFields.put("state11", "state11");
		this.hashFields.put("state16", "state16");
		this.hashFields.put("state17", "state17");
		this.hashFields.put("state14", "state14");
		this.hashFields.put("state15", "state15");
		this.hashFields.put("crr_cd", "crrCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return port20
	 */
	public String getPort20() {
		return this.port20;
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
	 * @return ieFlg
	 */
	public String getIeFlg() {
		return this.ieFlg;
	}
	
	/**
	 * Column Info
	 * @return actInpToDt
	 */
	public String getActInpToDt() {
		return this.actInpToDt;
	}
	
	/**
	 * Column Info
	 * @return state20
	 */
	public String getState20() {
		return this.state20;
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
	 * @return ontmCnt
	 */
	public String getOntmCnt() {
		return this.ontmCnt;
	}
	
	/**
	 * Column Info
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @return port18
	 */
	public String getPort18() {
		return this.port18;
	}
	
	/**
	 * Column Info
	 * @return port19
	 */
	public String getPort19() {
		return this.port19;
	}
	
	/**
	 * Column Info
	 * @return port16
	 */
	public String getPort16() {
		return this.port16;
	}
	
	/**
	 * Column Info
	 * @return port17
	 */
	public String getPort17() {
		return this.port17;
	}
	
	/**
	 * Column Info
	 * @return port14
	 */
	public String getPort14() {
		return this.port14;
	}
	
	/**
	 * Column Info
	 * @return port15
	 */
	public String getPort15() {
		return this.port15;
	}
	
	/**
	 * Column Info
	 * @return port12
	 */
	public String getPort12() {
		return this.port12;
	}
	
	/**
	 * Column Info
	 * @return port13
	 */
	public String getPort13() {
		return this.port13;
	}
	
	/**
	 * Column Info
	 * @return port10
	 */
	public String getPort10() {
		return this.port10;
	}
	
	/**
	 * Column Info
	 * @return port11
	 */
	public String getPort11() {
		return this.port11;
	}
	
	/**
	 * Column Info
	 * @return cntHrs
	 */
	public String getCntHrs() {
		return this.cntHrs;
	}
	
	/**
	 * Column Info
	 * @return callCnt
	 */
	public String getCallCnt() {
		return this.callCnt;
	}
	
	/**
	 * Column Info
	 * @return actInpFmDt
	 */
	public String getActInpFmDt() {
		return this.actInpFmDt;
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
	 * @return state1
	 */
	public String getState1() {
		return this.state1;
	}
	
	/**
	 * Column Info
	 * @return state2
	 */
	public String getState2() {
		return this.state2;
	}
	
	/**
	 * Column Info
	 * @return state3
	 */
	public String getState3() {
		return this.state3;
	}
	
	/**
	 * Column Info
	 * @return groupFlg
	 */
	public String getGroupFlg() {
		return this.groupFlg;
	}
	
	/**
	 * Column Info
	 * @return state4
	 */
	public String getState4() {
		return this.state4;
	}
	
	/**
	 * Column Info
	 * @return state5
	 */
	public String getState5() {
		return this.state5;
	}
	
	/**
	 * Column Info
	 * @return grpFlg
	 */
	public String getGrpFlg() {
		return this.grpFlg;
	}
	
	/**
	 * Column Info
	 * @return state6
	 */
	public String getState6() {
		return this.state6;
	}
	
	/**
	 * Column Info
	 * @return state7
	 */
	public String getState7() {
		return this.state7;
	}
	
	/**
	 * Column Info
	 * @return maxSeq
	 */
	public String getMaxSeq() {
		return this.maxSeq;
	}
	
	/**
	 * Column Info
	 * @return state8
	 */
	public String getState8() {
		return this.state8;
	}
	
	/**
	 * Column Info
	 * @return state9
	 */
	public String getState9() {
		return this.state9;
	}
	
	/**
	 * Column Info
	 * @return grpFlgCd
	 */
	public String getGrpFlgCd() {
		return this.grpFlgCd;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return arrDep
	 */
	public String getArrDep() {
		return this.arrDep;
	}
	
	/**
	 * Column Info
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
	}
	
	/**
	 * Column Info
	 * @return intgCdId
	 */
	public String getIntgCdId() {
		return this.intgCdId;
	}
	
	/**
	 * Column Info
	 * @return port4
	 */
	public String getPort4() {
		return this.port4;
	}
	
	/**
	 * Column Info
	 * @return port3
	 */
	public String getPort3() {
		return this.port3;
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
	 * @return port2
	 */
	public String getPort2() {
		return this.port2;
	}
	
	/**
	 * Column Info
	 * @return port1
	 */
	public String getPort1() {
		return this.port1;
	}
	
	/**
	 * Column Info
	 * @return port8
	 */
	public String getPort8() {
		return this.port8;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return port7
	 */
	public String getPort7() {
		return this.port7;
	}
	
	/**
	 * Column Info
	 * @return laneGrpNm
	 */
	public String getLaneGrpNm() {
		return this.laneGrpNm;
	}
	
	/**
	 * Column Info
	 * @return port6
	 */
	public String getPort6() {
		return this.port6;
	}
	
	/**
	 * Column Info
	 * @return port5
	 */
	public String getPort5() {
		return this.port5;
	}
	
	/**
	 * Column Info
	 * @return port9
	 */
	public String getPort9() {
		return this.port9;
	}
	
	/**
	 * Column Info
	 * @return laneGrp
	 */
	public String getLaneGrp() {
		return this.laneGrp;
	}
	
	/**
	 * Column Info
	 * @return state18
	 */
	public String getState18() {
		return this.state18;
	}
	
	/**
	 * Column Info
	 * @return state19
	 */
	public String getState19() {
		return this.state19;
	}
	
	/**
	 * Column Info
	 * @return state12
	 */
	public String getState12() {
		return this.state12;
	}
	
	/**
	 * Column Info
	 * @return state13
	 */
	public String getState13() {
		return this.state13;
	}
	
	/**
	 * Column Info
	 * @return state10
	 */
	public String getState10() {
		return this.state10;
	}
	
	/**
	 * Column Info
	 * @return state11
	 */
	public String getState11() {
		return this.state11;
	}
	
	/**
	 * Column Info
	 * @return state16
	 */
	public String getState16() {
		return this.state16;
	}
	
	/**
	 * Column Info
	 * @return state17
	 */
	public String getState17() {
		return this.state17;
	}
	
	/**
	 * Column Info
	 * @return state14
	 */
	public String getState14() {
		return this.state14;
	}
	
	/**
	 * Column Info
	 * @return state15
	 */
	public String getState15() {
		return this.state15;
	}
	
	/**
	 * Column Info
	 * @return crr_cd
	 */
	public String getCrrCd() {
		return this.crrCd;
	}
	

	/**
	 * Column Info
	 * @param port20
	 */
	public void setPort20(String port20) {
		this.port20 = port20;
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
	 * @param ieFlg
	 */
	public void setIeFlg(String ieFlg) {
		this.ieFlg = ieFlg;
	}
	
	/**
	 * Column Info
	 * @param actInpToDt
	 */
	public void setActInpToDt(String actInpToDt) {
		this.actInpToDt = actInpToDt;
	}
	
	/**
	 * Column Info
	 * @param state20
	 */
	public void setState20(String state20) {
		this.state20 = state20;
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
	 * @param ontmCnt
	 */
	public void setOntmCnt(String ontmCnt) {
		this.ontmCnt = ontmCnt;
	}
	
	/**
	 * Column Info
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @param port18
	 */
	public void setPort18(String port18) {
		this.port18 = port18;
	}
	
	/**
	 * Column Info
	 * @param port19
	 */
	public void setPort19(String port19) {
		this.port19 = port19;
	}
	
	/**
	 * Column Info
	 * @param port16
	 */
	public void setPort16(String port16) {
		this.port16 = port16;
	}
	
	/**
	 * Column Info
	 * @param port17
	 */
	public void setPort17(String port17) {
		this.port17 = port17;
	}
	
	/**
	 * Column Info
	 * @param port14
	 */
	public void setPort14(String port14) {
		this.port14 = port14;
	}
	
	/**
	 * Column Info
	 * @param port15
	 */
	public void setPort15(String port15) {
		this.port15 = port15;
	}
	
	/**
	 * Column Info
	 * @param port12
	 */
	public void setPort12(String port12) {
		this.port12 = port12;
	}
	
	/**
	 * Column Info
	 * @param port13
	 */
	public void setPort13(String port13) {
		this.port13 = port13;
	}
	
	/**
	 * Column Info
	 * @param port10
	 */
	public void setPort10(String port10) {
		this.port10 = port10;
	}
	
	/**
	 * Column Info
	 * @param port11
	 */
	public void setPort11(String port11) {
		this.port11 = port11;
	}
	
	/**
	 * Column Info
	 * @param cntHrs
	 */
	public void setCntHrs(String cntHrs) {
		this.cntHrs = cntHrs;
	}
	
	/**
	 * Column Info
	 * @param callCnt
	 */
	public void setCallCnt(String callCnt) {
		this.callCnt = callCnt;
	}
	
	/**
	 * Column Info
	 * @param actInpFmDt
	 */
	public void setActInpFmDt(String actInpFmDt) {
		this.actInpFmDt = actInpFmDt;
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
	 * @param state1
	 */
	public void setState1(String state1) {
		this.state1 = state1;
	}
	
	/**
	 * Column Info
	 * @param state2
	 */
	public void setState2(String state2) {
		this.state2 = state2;
	}
	
	/**
	 * Column Info
	 * @param state3
	 */
	public void setState3(String state3) {
		this.state3 = state3;
	}
	
	/**
	 * Column Info
	 * @param groupFlg
	 */
	public void setGroupFlg(String groupFlg) {
		this.groupFlg = groupFlg;
	}
	
	/**
	 * Column Info
	 * @param state4
	 */
	public void setState4(String state4) {
		this.state4 = state4;
	}
	
	/**
	 * Column Info
	 * @param state5
	 */
	public void setState5(String state5) {
		this.state5 = state5;
	}
	
	/**
	 * Column Info
	 * @param grpFlg
	 */
	public void setGrpFlg(String grpFlg) {
		this.grpFlg = grpFlg;
	}
	
	/**
	 * Column Info
	 * @param state6
	 */
	public void setState6(String state6) {
		this.state6 = state6;
	}
	
	/**
	 * Column Info
	 * @param state7
	 */
	public void setState7(String state7) {
		this.state7 = state7;
	}
	
	/**
	 * Column Info
	 * @param maxSeq
	 */
	public void setMaxSeq(String maxSeq) {
		this.maxSeq = maxSeq;
	}
	
	/**
	 * Column Info
	 * @param state8
	 */
	public void setState8(String state8) {
		this.state8 = state8;
	}
	
	/**
	 * Column Info
	 * @param state9
	 */
	public void setState9(String state9) {
		this.state9 = state9;
	}
	
	/**
	 * Column Info
	 * @param grpFlgCd
	 */
	public void setGrpFlgCd(String grpFlgCd) {
		this.grpFlgCd = grpFlgCd;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param arrDep
	 */
	public void setArrDep(String arrDep) {
		this.arrDep = arrDep;
	}
	
	/**
	 * Column Info
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
	}
	
	/**
	 * Column Info
	 * @param intgCdId
	 */
	public void setIntgCdId(String intgCdId) {
		this.intgCdId = intgCdId;
	}
	
	/**
	 * Column Info
	 * @param port4
	 */
	public void setPort4(String port4) {
		this.port4 = port4;
	}
	
	/**
	 * Column Info
	 * @param port3
	 */
	public void setPort3(String port3) {
		this.port3 = port3;
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
	 * @param port2
	 */
	public void setPort2(String port2) {
		this.port2 = port2;
	}
	
	/**
	 * Column Info
	 * @param port1
	 */
	public void setPort1(String port1) {
		this.port1 = port1;
	}
	
	/**
	 * Column Info
	 * @param port8
	 */
	public void setPort8(String port8) {
		this.port8 = port8;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param port7
	 */
	public void setPort7(String port7) {
		this.port7 = port7;
	}
	
	/**
	 * Column Info
	 * @param laneGrpNm
	 */
	public void setLaneGrpNm(String laneGrpNm) {
		this.laneGrpNm = laneGrpNm;
	}
	
	/**
	 * Column Info
	 * @param port6
	 */
	public void setPort6(String port6) {
		this.port6 = port6;
	}
	
	/**
	 * Column Info
	 * @param port5
	 */
	public void setPort5(String port5) {
		this.port5 = port5;
	}
	
	/**
	 * Column Info
	 * @param port9
	 */
	public void setPort9(String port9) {
		this.port9 = port9;
	}
	
	/**
	 * Column Info
	 * @param laneGrp
	 */
	public void setLaneGrp(String laneGrp) {
		this.laneGrp = laneGrp;
	}
	
	/**
	 * Column Info
	 * @param state18
	 */
	public void setState18(String state18) {
		this.state18 = state18;
	}
	
	/**
	 * Column Info
	 * @param state19
	 */
	public void setState19(String state19) {
		this.state19 = state19;
	}
	
	/**
	 * Column Info
	 * @param state12
	 */
	public void setState12(String state12) {
		this.state12 = state12;
	}
	
	/**
	 * Column Info
	 * @param state13
	 */
	public void setState13(String state13) {
		this.state13 = state13;
	}
	
	/**
	 * Column Info
	 * @param state10
	 */
	public void setState10(String state10) {
		this.state10 = state10;
	}
	
	/**
	 * Column Info
	 * @param state11
	 */
	public void setState11(String state11) {
		this.state11 = state11;
	}
	
	/**
	 * Column Info
	 * @param state16
	 */
	public void setState16(String state16) {
		this.state16 = state16;
	}
	
	/**
	 * Column Info
	 * @param state17
	 */
	public void setState17(String state17) {
		this.state17 = state17;
	}
	
	/**
	 * Column Info
	 * @param state14
	 */
	public void setState14(String state14) {
		this.state14 = state14;
	}
	
	/**
	 * Column Info
	 * @param state15
	 */
	public void setState15(String state15) {
		this.state15 = state15;
	}
	
	/**
	 * Column Info
	 * @param crr_cd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPort20(JSPUtil.getParameter(request, "port20", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setIeFlg(JSPUtil.getParameter(request, "ie_flg", ""));
		setActInpToDt(JSPUtil.getParameter(request, "act_inp_to_dt", ""));
		setState20(JSPUtil.getParameter(request, "state20", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOntmCnt(JSPUtil.getParameter(request, "ontm_cnt", ""));
		setVpsPortCd(JSPUtil.getParameter(request, "vps_port_cd", ""));
		setPort18(JSPUtil.getParameter(request, "port18", ""));
		setPort19(JSPUtil.getParameter(request, "port19", ""));
		setPort16(JSPUtil.getParameter(request, "port16", ""));
		setPort17(JSPUtil.getParameter(request, "port17", ""));
		setPort14(JSPUtil.getParameter(request, "port14", ""));
		setPort15(JSPUtil.getParameter(request, "port15", ""));
		setPort12(JSPUtil.getParameter(request, "port12", ""));
		setPort13(JSPUtil.getParameter(request, "port13", ""));
		setPort10(JSPUtil.getParameter(request, "port10", ""));
		setPort11(JSPUtil.getParameter(request, "port11", ""));
		setCntHrs(JSPUtil.getParameter(request, "cnt_hrs", ""));
		setCallCnt(JSPUtil.getParameter(request, "call_cnt", ""));
		setActInpFmDt(JSPUtil.getParameter(request, "act_inp_fm_dt", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setState1(JSPUtil.getParameter(request, "state1", ""));
		setState2(JSPUtil.getParameter(request, "state2", ""));
		setState3(JSPUtil.getParameter(request, "state3", ""));
		setGroupFlg(JSPUtil.getParameter(request, "group_flg", ""));
		setState4(JSPUtil.getParameter(request, "state4", ""));
		setState5(JSPUtil.getParameter(request, "state5", ""));
		setGrpFlg(JSPUtil.getParameter(request, "grp_flg", ""));
		setState6(JSPUtil.getParameter(request, "state6", ""));
		setState7(JSPUtil.getParameter(request, "state7", ""));
		setMaxSeq(JSPUtil.getParameter(request, "max_seq", ""));
		setState8(JSPUtil.getParameter(request, "state8", ""));
		setState9(JSPUtil.getParameter(request, "state9", ""));
		setGrpFlgCd(JSPUtil.getParameter(request, "grp_flg_cd", ""));
		setVslSlanCd(JSPUtil.getParameter(request, "vsl_slan_cd", ""));
		setArrDep(JSPUtil.getParameter(request, "arr_dep", ""));
		setLane(JSPUtil.getParameter(request, "lane", ""));
		setIntgCdId(JSPUtil.getParameter(request, "intg_cd_id", ""));
		setPort4(JSPUtil.getParameter(request, "port4", ""));
		setPort3(JSPUtil.getParameter(request, "port3", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPort2(JSPUtil.getParameter(request, "port2", ""));
		setPort1(JSPUtil.getParameter(request, "port1", ""));
		setPort8(JSPUtil.getParameter(request, "port8", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setPort7(JSPUtil.getParameter(request, "port7", ""));
		setLaneGrpNm(JSPUtil.getParameter(request, "lane_grp_nm", ""));
		setPort6(JSPUtil.getParameter(request, "port6", ""));
		setPort5(JSPUtil.getParameter(request, "port5", ""));
		setPort9(JSPUtil.getParameter(request, "port9", ""));
		setLaneGrp(JSPUtil.getParameter(request, "lane_grp", ""));
		setState18(JSPUtil.getParameter(request, "state18", ""));
		setState19(JSPUtil.getParameter(request, "state19", ""));
		setState12(JSPUtil.getParameter(request, "state12", ""));
		setState13(JSPUtil.getParameter(request, "state13", ""));
		setState10(JSPUtil.getParameter(request, "state10", ""));
		setState11(JSPUtil.getParameter(request, "state11", ""));
		setState16(JSPUtil.getParameter(request, "state16", ""));
		setState17(JSPUtil.getParameter(request, "state17", ""));
		setState14(JSPUtil.getParameter(request, "state14", ""));
		setState15(JSPUtil.getParameter(request, "state15", ""));
		setCrrCd(JSPUtil.getParameter(request, "crr_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ResultChangeStatusVO[]
	 */
	public ResultChangeStatusVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ResultChangeStatusVO[]
	 */
	public ResultChangeStatusVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ResultChangeStatusVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] port20 = (JSPUtil.getParameter(request, prefix	+ "port20", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] ieFlg = (JSPUtil.getParameter(request, prefix	+ "ie_flg", length));
			String[] actInpToDt = (JSPUtil.getParameter(request, prefix	+ "act_inp_to_dt", length));
			String[] state20 = (JSPUtil.getParameter(request, prefix	+ "state20", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ontmCnt = (JSPUtil.getParameter(request, prefix	+ "ontm_cnt", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] port18 = (JSPUtil.getParameter(request, prefix	+ "port18", length));
			String[] port19 = (JSPUtil.getParameter(request, prefix	+ "port19", length));
			String[] port16 = (JSPUtil.getParameter(request, prefix	+ "port16", length));
			String[] port17 = (JSPUtil.getParameter(request, prefix	+ "port17", length));
			String[] port14 = (JSPUtil.getParameter(request, prefix	+ "port14", length));
			String[] port15 = (JSPUtil.getParameter(request, prefix	+ "port15", length));
			String[] port12 = (JSPUtil.getParameter(request, prefix	+ "port12", length));
			String[] port13 = (JSPUtil.getParameter(request, prefix	+ "port13", length));
			String[] port10 = (JSPUtil.getParameter(request, prefix	+ "port10", length));
			String[] port11 = (JSPUtil.getParameter(request, prefix	+ "port11", length));
			String[] cntHrs = (JSPUtil.getParameter(request, prefix	+ "cnt_hrs", length));
			String[] callCnt = (JSPUtil.getParameter(request, prefix	+ "call_cnt", length));
			String[] actInpFmDt = (JSPUtil.getParameter(request, prefix	+ "act_inp_fm_dt", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] state1 = (JSPUtil.getParameter(request, prefix	+ "state1", length));
			String[] state2 = (JSPUtil.getParameter(request, prefix	+ "state2", length));
			String[] state3 = (JSPUtil.getParameter(request, prefix	+ "state3", length));
			String[] groupFlg = (JSPUtil.getParameter(request, prefix	+ "group_flg", length));
			String[] state4 = (JSPUtil.getParameter(request, prefix	+ "state4", length));
			String[] state5 = (JSPUtil.getParameter(request, prefix	+ "state5", length));
			String[] grpFlg = (JSPUtil.getParameter(request, prefix	+ "grp_flg", length));
			String[] state6 = (JSPUtil.getParameter(request, prefix	+ "state6", length));
			String[] state7 = (JSPUtil.getParameter(request, prefix	+ "state7", length));
			String[] maxSeq = (JSPUtil.getParameter(request, prefix	+ "max_seq", length));
			String[] state8 = (JSPUtil.getParameter(request, prefix	+ "state8", length));
			String[] state9 = (JSPUtil.getParameter(request, prefix	+ "state9", length));
			String[] grpFlgCd = (JSPUtil.getParameter(request, prefix	+ "grp_flg_cd", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] arrDep = (JSPUtil.getParameter(request, prefix	+ "arr_dep", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] intgCdId = (JSPUtil.getParameter(request, prefix	+ "intg_cd_id", length));
			String[] port4 = (JSPUtil.getParameter(request, prefix	+ "port4", length));
			String[] port3 = (JSPUtil.getParameter(request, prefix	+ "port3", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] port2 = (JSPUtil.getParameter(request, prefix	+ "port2", length));
			String[] port1 = (JSPUtil.getParameter(request, prefix	+ "port1", length));
			String[] port8 = (JSPUtil.getParameter(request, prefix	+ "port8", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] port7 = (JSPUtil.getParameter(request, prefix	+ "port7", length));
			String[] laneGrpNm = (JSPUtil.getParameter(request, prefix	+ "lane_grp_nm", length));
			String[] port6 = (JSPUtil.getParameter(request, prefix	+ "port6", length));
			String[] port5 = (JSPUtil.getParameter(request, prefix	+ "port5", length));
			String[] port9 = (JSPUtil.getParameter(request, prefix	+ "port9", length));
			String[] laneGrp = (JSPUtil.getParameter(request, prefix	+ "lane_grp", length));
			String[] state18 = (JSPUtil.getParameter(request, prefix	+ "state18", length));
			String[] state19 = (JSPUtil.getParameter(request, prefix	+ "state19", length));
			String[] state12 = (JSPUtil.getParameter(request, prefix	+ "state12", length));
			String[] state13 = (JSPUtil.getParameter(request, prefix	+ "state13", length));
			String[] state10 = (JSPUtil.getParameter(request, prefix	+ "state10", length));
			String[] state11 = (JSPUtil.getParameter(request, prefix	+ "state11", length));
			String[] state16 = (JSPUtil.getParameter(request, prefix	+ "state16", length));
			String[] state17 = (JSPUtil.getParameter(request, prefix	+ "state17", length));
			String[] state14 = (JSPUtil.getParameter(request, prefix	+ "state14", length));
			String[] state15 = (JSPUtil.getParameter(request, prefix	+ "state15", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new ResultChangeStatusVO();
				if (port20[i] != null)
					model.setPort20(port20[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (ieFlg[i] != null)
					model.setIeFlg(ieFlg[i]);
				if (actInpToDt[i] != null)
					model.setActInpToDt(actInpToDt[i]);
				if (state20[i] != null)
					model.setState20(state20[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ontmCnt[i] != null)
					model.setOntmCnt(ontmCnt[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (port18[i] != null)
					model.setPort18(port18[i]);
				if (port19[i] != null)
					model.setPort19(port19[i]);
				if (port16[i] != null)
					model.setPort16(port16[i]);
				if (port17[i] != null)
					model.setPort17(port17[i]);
				if (port14[i] != null)
					model.setPort14(port14[i]);
				if (port15[i] != null)
					model.setPort15(port15[i]);
				if (port12[i] != null)
					model.setPort12(port12[i]);
				if (port13[i] != null)
					model.setPort13(port13[i]);
				if (port10[i] != null)
					model.setPort10(port10[i]);
				if (port11[i] != null)
					model.setPort11(port11[i]);
				if (cntHrs[i] != null)
					model.setCntHrs(cntHrs[i]);
				if (callCnt[i] != null)
					model.setCallCnt(callCnt[i]);
				if (actInpFmDt[i] != null)
					model.setActInpFmDt(actInpFmDt[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (state1[i] != null)
					model.setState1(state1[i]);
				if (state2[i] != null)
					model.setState2(state2[i]);
				if (state3[i] != null)
					model.setState3(state3[i]);
				if (groupFlg[i] != null)
					model.setGroupFlg(groupFlg[i]);
				if (state4[i] != null)
					model.setState4(state4[i]);
				if (state5[i] != null)
					model.setState5(state5[i]);
				if (grpFlg[i] != null)
					model.setGrpFlg(grpFlg[i]);
				if (state6[i] != null)
					model.setState6(state6[i]);
				if (state7[i] != null)
					model.setState7(state7[i]);
				if (maxSeq[i] != null)
					model.setMaxSeq(maxSeq[i]);
				if (state8[i] != null)
					model.setState8(state8[i]);
				if (state9[i] != null)
					model.setState9(state9[i]);
				if (grpFlgCd[i] != null)
					model.setGrpFlgCd(grpFlgCd[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (arrDep[i] != null)
					model.setArrDep(arrDep[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (intgCdId[i] != null)
					model.setIntgCdId(intgCdId[i]);
				if (port4[i] != null)
					model.setPort4(port4[i]);
				if (port3[i] != null)
					model.setPort3(port3[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (port2[i] != null)
					model.setPort2(port2[i]);
				if (port1[i] != null)
					model.setPort1(port1[i]);
				if (port8[i] != null)
					model.setPort8(port8[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (port7[i] != null)
					model.setPort7(port7[i]);
				if (laneGrpNm[i] != null)
					model.setLaneGrpNm(laneGrpNm[i]);
				if (port6[i] != null)
					model.setPort6(port6[i]);
				if (port5[i] != null)
					model.setPort5(port5[i]);
				if (port9[i] != null)
					model.setPort9(port9[i]);
				if (laneGrp[i] != null)
					model.setLaneGrp(laneGrp[i]);
				if (state18[i] != null)
					model.setState18(state18[i]);
				if (state19[i] != null)
					model.setState19(state19[i]);
				if (state12[i] != null)
					model.setState12(state12[i]);
				if (state13[i] != null)
					model.setState13(state13[i]);
				if (state10[i] != null)
					model.setState10(state10[i]);
				if (state11[i] != null)
					model.setState11(state11[i]);
				if (state16[i] != null)
					model.setState16(state16[i]);
				if (state17[i] != null)
					model.setState17(state17[i]);
				if (state14[i] != null)
					model.setState14(state14[i]);
				if (state15[i] != null)
					model.setState15(state15[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getResultChangeStatusVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ResultChangeStatusVO[]
	 */
	public ResultChangeStatusVO[] getResultChangeStatusVOs(){
		ResultChangeStatusVO[] vos = (ResultChangeStatusVO[])models.toArray(new ResultChangeStatusVO[models.size()]);
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
		this.port20 = this.port20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ieFlg = this.ieFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actInpToDt = this.actInpToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.state20 = this.state20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ontmCnt = this.ontmCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port18 = this.port18 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port19 = this.port19 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port16 = this.port16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port17 = this.port17 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port14 = this.port14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port15 = this.port15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port12 = this.port12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port13 = this.port13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port10 = this.port10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port11 = this.port11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntHrs = this.cntHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callCnt = this.callCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actInpFmDt = this.actInpFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.state1 = this.state1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.state2 = this.state2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.state3 = this.state3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.groupFlg = this.groupFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.state4 = this.state4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.state5 = this.state5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpFlg = this.grpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.state6 = this.state6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.state7 = this.state7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxSeq = this.maxSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.state8 = this.state8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.state9 = this.state9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpFlgCd = this.grpFlgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrDep = this.arrDep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intgCdId = this.intgCdId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port4 = this.port4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port3 = this.port3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port2 = this.port2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port1 = this.port1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port8 = this.port8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port7 = this.port7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneGrpNm = this.laneGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port6 = this.port6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port5 = this.port5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port9 = this.port9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneGrp = this.laneGrp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.state18 = this.state18 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.state19 = this.state19 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.state12 = this.state12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.state13 = this.state13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.state10 = this.state10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.state11 = this.state11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.state16 = this.state16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.state17 = this.state17 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.state14 = this.state14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.state15 = this.state15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
