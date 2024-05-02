/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSpaceControlInquiryConditionVO.java
*@FileTitle : SearchSpaceControlInquiryConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.08.12 한상훈
* 1.0 Creation
* 2011.05.16 이석준 [CHM-201110710-01] Daily F"cast Status 화면 조건 추가
*            rlane1,rlane2,rlane3 추가
* 2011.05.31 이석준 [CHM-201111306-01] 각 tab에  Area2 check box 추가
*            check_area1,check_area2,check_area3 추가
* 2011.06.03 김종준 [CHM-201110708-01] F"cast 입력 요청 메세지 송부 기능 contents 추가
* 2011.07.05 이행지 [CHM-201111946-01] Daily F"cast Status 화면 보완 - CheckBox-Dest.(IAS)추가
* 2012.06.14 김성훈 [CHM-201218360-01] Daily FCST Status 메뉴 개선	( 수기 AA김수정, 그룹리더이석준 )
* 2012.12.04 최윤성 [CHM-201221640-01] FCST&PFMC by ACCT 신규 탭 추가 - 관련 변수 추가
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2013.10.30 최윤성 [CHM-201327083-01] IPC Sector 판매 활성화 Tool 개발 - Space Utilization 화면 변수 추가
* 2014.10.10 Arie IM [CHM-201432357] Space utilization inquiry 메뉴 로직 수정
* 2014.10.27 [CHM-201432467] Daily FCST Inquiry 보완 요청(por_cd추가)
* 2014.11.04 박은주 [CHM-201432710]  [SPC : 사후CSR 진행] [CHM-201431980]Daily FCST -Dest/Local-IPI 조회기능 보완요청(checkIpiLocal2,checkDestCtrl2 추가)
* 2014.11.20 [CHM-201432864] Daily FCST보완
				- SUB Trade별 전체 실적 GUIDE추가(Acct)
				- SUB Trade, Trade 별 USMode/Account/Dest Sum 추가(HO/RHQ)
				- 체크박스 기능 재정의(HO/RHQ)
				- Excluding Sector(IAS) 추가 (HO/RHQ탭) ---->check_sector2, check_sector5추가
* 2014.12.16 박은주 [CHM-201433153] Daily FCST status 리포트 보완 요청(겹선)  check_vvd1,check_vvd2,check_vvd3,check_vvd4,check_vvd5
=========================================================*/

package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo;

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
 * @author 한상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSpaceControlInquiryConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<SearchSpaceControlInquiryConditionVO> models = new ArrayList<SearchSpaceControlInquiryConditionVO>();

	/* Column Info */
	private String chkArea1 = null;
	/* Column Info */
	private String chkArea2 = null;
	/* Column Info */
	private String chkArea3 = null;
	/* Column Info */
	private String chkArea4 = null;
	/* Column Info */
	private String chkArea5 = null;
	/* Column Info */
	private String checkDest2 = null;
	/* Column Info */
	private String checkDest3 = null;
	/* Column Info */
	private String checkDest4 = null;
	/* Column Info */
	private String checkDest5 = null;

	/* Column Info */
	private String subtrade5 = null;
	/* Column Info */
	private String subtrade4 = null;
	/* Column Info */
	private String subtrade3 = null;
	/* Column Info */
	private String subtrade2 = null;
	/* Column Info */
	private String subtrade1 = null;
	/* Column Info */
	private String rlane1 = null;
	/* Column Info */
	private String rlane2 = null;
	/* Column Info */
	private String rlane3 = null;
	/* Column Info */
	private String rlane4 = null;
	/* Column Info */
	private String rlane5 = null;
	/* Column Info */
	private String trade = null;
	/* Column Info */
	private String salesOffice = null;
	/* Column Info */
	private String chkview = null;
	/* Column Info */
	private String week1 = null;
	private String week2 = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String duration = null;
	/* Column Info */
	private String duration2From = null;
	/* Column Info */
	private String duration2To = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String area = null;
	/* Column Info */
	private String year1 = null;
	private String year2 = null;
	/* Column Info */
	private String bound = null;
	/* Column Info */
	private String rhq = null;
	/* Column Info */
	private String rhq2 = null;
	/* Column Info */
	private String type = null;
	/* Column Info */
	private String month = null;
	/* Column Info */
	private String revMonth = null;
	/* Column Info */
	private String monFlg = null;
	/* Column Info */
	private String week = null;
	/* Column Info */
	private String office = null;
	/* Column Info */
	private String lane = null;
	/* Column Info */
	private String vvd = null;

	private String userOfc = null;
	private String subTrade = null;
	private String oncIpc = null;
	private String onlyVvd = null;
	private String rhqTxt = null;

	private String rhqGso = null;

	private String polPod = null;

	private String vslCd = null;
	private String skdVoyNo = null;
	private String skdDirCd = null;

	private String sDate = null;
	private String eDate = null;
	private String port = null;
	private String ioc = null;
	private String org = null;

	private String subOffice = null ;
	private String ofcCd = null ;
	private String contents = null ;

	// add
	private String portDiv = null ;

	/* Column Info */
	private String rlane6 = null;

	/* Column Info */
	private String subtrade6 = null;

	private String  viewDiv = null;

	private String  fromDt = null;
	private String  duration1 = null;
	private String  trade7 = null;
	private String  subtrade7 = null;
	private String  rlane7 = null;
	private String  bound1 = null;
	private String  rhq1 = null;
	private String  area1 = null;
	private String  salesOffice1 = null;
	private String  srepCd = null;

	/* Column Info */
	private String subtrade11 = null;
	/* Column Info */
	private String rlane11 = null;
	/* Column Info */
	private String viewType11 = null;
	/* Column Info */
	private String checkSmp = null;
	/* Column Info */
	private String acct = null;
	/* Column Info */
	private String grpAcct = null;
	/* Column Info */
	private String acctClss = null;

	private String vvd1 = null;

	private String vvd2 = null;

	/* Column Info */
	private String delCd = null;

	private String checkIpiLocal = null;
	private String checkDestCtrl = null;
	private String checkIpiLocal2 = null;
	private String checkDestCtrl2 = null;

	private String loginUserId = null;//[CHM-201432357]
	private String porCd = null; //

	private String checkSector2 = null;
	private String checkSector5 = null;
	
	private String checkVvd1 = null;
	private String checkVvd2 = null;
	private String checkVvd3 = null;
	private String checkVvd4 = null;
	private String checkVvd5 = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public SearchSpaceControlInquiryConditionVO() {}

	public SearchSpaceControlInquiryConditionVO(String sDate,String eDate,String port,String ioc,String org,String vslCd,String skdVoyNo,String skdDirCd,String polPod,String rhqGso,String rhqTxt,String onlyVvd,String oncIpc,String subTrade,String userOfc,String ibflag,String pagerows,String year1,String year2,String week1,String week2,String duration,String duration2From,String duration2To,String trade,String bound,String rhq,String rhq2,String area,String salesOffice,String polCd,String podCd, String subtrade1,String subtrade2,String subtrade3,String subtrade4,String subtrade5,String chkview,String type,String month,String revMonth,String monFlg, String week,String office,String lane,String vvd, String ofcCd,String rlane1,String rlane2,String rlane3,String rlane4,String rlane5,String chkArea1,String chkArea2,String chkArea3,String chkArea4,String chkArea5,String contents,String checkDest2, String checkDest3, String checkDest4, String checkDest5, String portDiv, String subOffice, String viewDiv, String trade7, String rlane7, String subtrade7, String rhq1, String area1, String salesOffice1, String srepCd, String fromDt, String bound1, String subtrade11, String rlane11, String viewType11, String checkSmp, String acct, String grpAcct, String acctClss, String vvd1, String vvd2, String delCd, String checkIpiLocal, String checkDestCtrl, String checkIpiLocal2, String checkDestCtrl2, String loginUserId, String por_cd, String checkSector2, String checkSector5
			                                   ,String checkVvd1,String checkVvd2,String checkVvd3,String checkVvd4,String checkVvd5) {

		this.sDate = sDate;
		this.eDate = eDate;
		this.port = port;
		this.ioc = ioc;
		this.org = org;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd = skdDirCd;
		this.vslCd = vslCd;
		this.polPod = polPod;
		this.rhqGso = rhqGso;
		this.rhqTxt = rhqTxt;
		this.userOfc = userOfc;
		this.subTrade = subTrade;
		this.oncIpc = oncIpc;
		this.onlyVvd = onlyVvd;
		this.subtrade5 = subtrade5;
		this.subtrade4 = subtrade4;
		this.subtrade3 = subtrade3;
		this.subtrade2 = subtrade2;
		this.subtrade1 = subtrade1;
		this.trade = trade;
		this.salesOffice = salesOffice;
		this.chkview = chkview;
		this.week1 = week1;
		this.week2 = week2;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.duration = duration;
		this.duration2From = duration2From;
		this.duration2To = duration2To;
		this.polCd = polCd;
		this.podCd = podCd;
		this.area = area;
		this.year1 = year1;
		this.year2 = year2;
		this.bound = bound;
		this.rhq = rhq;
		this.rhq2 = rhq2;
		this.type = type;
		this.month = month;
		this.revMonth = revMonth;
		this.monFlg = monFlg;
		this.week = week;
		this.office = office;
		this.lane = lane;
		this.vvd = vvd;
		this.subOffice = subOffice;
		this.ofcCd =ofcCd;
		this.rlane1 = rlane1;
		this.rlane2 = rlane2;
		this.rlane3 = rlane3;
		this.rlane4 = rlane4;
		this.rlane5 = rlane5;
		this.chkArea1 = chkArea1;
		this.chkArea2 = chkArea2;
		this.chkArea3 = chkArea3;
		this.chkArea4 = chkArea4;
		this.chkArea5 = chkArea5;
		this.contents = contents;
		this.checkDest2 = checkDest2;
		this.checkDest3 = checkDest3;
		this.checkDest4 = checkDest4;
		this.checkDest5 = checkDest5;

		this.portDiv =portDiv;
		this.viewDiv =viewDiv;


		this.fromDt = fromDt;
		this.trade7 = trade7;
		this.subtrade7 = subtrade7;
		this.rlane7 = rlane7;
		this.bound1 = bound1;
		this.rhq1 = rhq1;
		this.area1 = area1;
		this.salesOffice1 = salesOffice1;
		this.srepCd = srepCd;

		this.subtrade11 = subtrade11;
		this.rlane11 = rlane11;
		this.viewType11 = viewType11;
		this.checkSmp = checkSmp;

		this.acct = acct;
		this.grpAcct = grpAcct;
		this.acctClss = acctClss;

		this.vvd1 = vvd1;
		this.vvd2 = vvd2;

		this.delCd = delCd;

		this.checkIpiLocal = checkIpiLocal;
		this.checkDestCtrl = checkDestCtrl;
		this.checkIpiLocal2 = checkIpiLocal2;
		this.checkDestCtrl2 = checkDestCtrl2;

		this.loginUserId = loginUserId;
		this.porCd = por_cd;
		
		this.checkSector2 = checkSector2;
		this.checkSector5 = checkSector5;	

		this.checkVvd1 = checkVvd1;	
		this.checkVvd2 = checkVvd2;	
		this.checkVvd3 = checkVvd3;	
		this.checkVvd4 = checkVvd4;	
		this.checkVvd5 = checkVvd5;	
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){

		this.hashColumns.put("sDate", getSDate());
		this.hashColumns.put("eDate", getEDate());
		this.hashColumns.put("port", getPort());
		this.hashColumns.put("ioc", getIoc());
		this.hashColumns.put("org", getOrg());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pol_pod", getPolPod());
		this.hashColumns.put("rhq_gso", getRhqGso());
		this.hashColumns.put("rhq_txt", getRhqTxt());
		this.hashColumns.put("user_ofc", getUserOfc());
		this.hashColumns.put("subtrade", getSubTrade());
		this.hashColumns.put("onc_ipc", getOncIpc());
		this.hashColumns.put("only_vvd", getOnlyVvd());
		this.hashColumns.put("subtrade5", getSubtrade5());
		this.hashColumns.put("subtrade4", getSubtrade4());	// SHKIM 20120614
		this.hashColumns.put("subtrade3", getSubtrade3());
		this.hashColumns.put("subtrade2", getSubtrade2());
		this.hashColumns.put("subtrade1", getSubtrade1());
		this.hashColumns.put("trade", getTrade());
		this.hashColumns.put("sales_office", getSalesOffice());
		this.hashColumns.put("chkview", getChkview());
		if(getWeek1().equals("")){
			this.hashColumns.put("week", getWeek());
		}
		else{
			this.hashColumns.put("week", getWeek1());
		}
		this.hashColumns.put("week2", getWeek2());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("duration", getDuration());
		this.hashColumns.put("duration2_from", getDuration2From());
		this.hashColumns.put("duration2_to", getDuration2To());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("area", getArea());
		this.hashColumns.put("year", getYear1());
		this.hashColumns.put("year2", getYear2());
		this.hashColumns.put("bound", getBound());
		this.hashColumns.put("rhq", getRhq());
		this.hashColumns.put("rhq2", getRhq2());
		this.hashColumns.put("type", getType());
		this.hashColumns.put("month", getMonth());
		this.hashColumns.put("rev_month", getRevMonth());
		this.hashColumns.put("mon_flg", getMonFlg());
		this.hashColumns.put("office", getOffice());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("sub_office", getSubOffice());
		this.hashColumns.put("rlane1", getRlane1());
		this.hashColumns.put("rlane2", getRlane2());
		this.hashColumns.put("rlane3", getRlane3());
		this.hashColumns.put("rlane4", getRlane4());	// SHKIM 20120614
		this.hashColumns.put("rlane5", getRlane5());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("check_area1", getChkArea1());
		this.hashColumns.put("check_area2", getChkArea2());
		this.hashColumns.put("check_area3", getChkArea3());
		this.hashColumns.put("check_area4", getChkArea4());	// SHKIM 20120614
		this.hashColumns.put("check_area5", getChkArea5());
		this.hashColumns.put("contents", getContents());
		this.hashColumns.put("check_dest2", getCheckDest2());
		this.hashColumns.put("check_dest3", getCheckDest3());
		this.hashColumns.put("check_dest4", getCheckDest4());	// SHKIM 20120614
		this.hashColumns.put("check_dest5", getCheckDest5());


		// add 2012.08.08
		this.hashColumns.put("port_div", getPortDiv() );
		this.hashColumns.put("rlane6", getRlane6() );
		this.hashColumns.put("subtrade6", getSubtrade6() );

		this.hashColumns.put("trade7", getTrade7());
		this.hashColumns.put("subtrade7", getSubtrade7());
		this.hashColumns.put("rlane7", getRlane7());
		this.hashColumns.put("bound1", getBound1());
		this.hashColumns.put("rhq1", getRhq1());
		this.hashColumns.put("area1", getArea1());
		this.hashColumns.put("sales_office1", getSalesOffice1());
		this.hashColumns.put("srep_cd", getSrepCd());
		this.hashColumns.put("from_dt", getFromDt());
		this.hashColumns.put("duration1", getDuration1());

		this.hashColumns.put("subtrade11", getSubtrade11());
		this.hashColumns.put("rlane11", getRlane11());
		this.hashColumns.put("view_type11", getViewType11());
		this.hashColumns.put("check_smp", getCheckSmp());

		this.hashColumns.put("acct", getAcct());
		this.hashColumns.put("grp_acct", getGrpAcct());
		this.hashColumns.put("acct_clss", getAcctClss());

		this.hashColumns.put("vvd1", getVvd1());
		this.hashColumns.put("vvd2", getVvd2());

		this.hashColumns.put("delCd", getDelCd());

		this.hashColumns.put("check_ipi_local", getCheckIpiLocal());
		this.hashColumns.put("check_dest_ctrl", getCheckDestCtrl());
		this.hashColumns.put("check_ipi_local2", getCheckIpiLocal2());
		this.hashColumns.put("check_dest_ctrl2", getCheckDestCtrl2());

		this.hashColumns.put("login_user_id", getLoginUserId());
		this.hashColumns.put("por_cd", getPorCd());

		this.hashColumns.put("check_sector2", getCheckSector2());
		this.hashColumns.put("check_sector5", getCheckSector5());
		
		this.hashColumns.put("checkVvd1", getCheckVvd1());
		this.hashColumns.put("checkVvd2", getCheckVvd2());
		this.hashColumns.put("checkVvd3", getCheckVvd3());
		this.hashColumns.put("checkVvd4", getCheckVvd4());
		this.hashColumns.put("checkVvd5", getCheckVvd5());

		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){

		this.hashFields.put("sDate", "sDate");
		this.hashFields.put("eDate", "eDate");
		this.hashFields.put("port", "port");
		this.hashFields.put("ioc", "ioc");
		this.hashFields.put("org", "org");
		this.hashFields.put("subtrade5", "subtrade5");
		this.hashFields.put("subtrade4", "subtrade4");	// SHKIM 20120614
		this.hashFields.put("subtrade3", "subtrade3");
		this.hashFields.put("subtrade2", "subtrade2");
		this.hashFields.put("subtrade1", "subtrade1");
		this.hashFields.put("trade", "trade");
		this.hashFields.put("sales_office", "salesOffice");
		this.hashFields.put("chkview", "chkview");
		this.hashFields.put("week", "week");
		this.hashFields.put("week2", "week2");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("duration", "duration");
		this.hashFields.put("duration2_from", "duration2From");
		this.hashFields.put("duration2_to", "duration2To");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("area", "area");
		this.hashFields.put("year", "year");
		this.hashFields.put("year2", "year2");
		this.hashFields.put("bound", "bound");
		this.hashFields.put("rhq", "rhq");
		this.hashFields.put("rhq2", "rhq2");
		this.hashFields.put("type", "type");
		this.hashFields.put("month", "month");
		this.hashFields.put("rev_month", "revMonth");
		this.hashFields.put("mon_flg", "monFlg");
		this.hashFields.put("office", "office");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("sub_offcie", "sub_offcie");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("rlane1", "rlane1");
		this.hashFields.put("rlane2", "rlane2");
		this.hashFields.put("rlane3", "rlane3");
		this.hashFields.put("rlane4", "rlane4");	// SHKIM 20120614
		this.hashFields.put("rlane5", "rlane5");
		this.hashFields.put("check_area1", "chkArea1");
		this.hashFields.put("check_area2", "chkArea2");
		this.hashFields.put("check_area3", "chkArea3");
		this.hashFields.put("check_area4", "chkArea4");	// SHKIM 20120614
		this.hashFields.put("check_area5", "chkArea5");
		this.hashFields.put("contents", "contents");
		this.hashFields.put("check_dest2", "checkDest2");
		this.hashFields.put("check_dest3", "checkDest3");
		this.hashFields.put("check_dest4", "checkDest4");	// SHKIM 20120614
		this.hashFields.put("check_dest5", "checkDest5");

		// add 2012.08.08
		this.hashFields.put("port_div", "portDiv");
		this.hashFields.put("rlane6", "rlane6");
		this.hashFields.put("subtrade6", "subtrade6");


		this.hashFields.put("from_dt", "fromDt");
		this.hashFields.put("trade7", "trade7");
		this.hashFields.put("subtrade7", "subtrade7");
		this.hashFields.put("rlane7", "rlane7");
		this.hashFields.put("bound1", "bound1");
		this.hashFields.put("rhq1", "rhq1");
		this.hashFields.put("area1", "area1");
		this.hashFields.put("sales_office1", "salesOffice1");
		this.hashFields.put("srep_cd", "srepCd");

		this.hashFields.put("subtrade11", "subtrade11");
		this.hashFields.put("rlane11", "rlane11");
		this.hashFields.put("view_type11", "viewType11");
		this.hashFields.put("check_smp", "checkSmp");

		this.hashFields.put("acct", "acct");
		this.hashFields.put("grp_acct", "grpAcct");
		this.hashFields.put("acct_clss", "acctClss");

		this.hashFields.put("vvd1", "vvd1");
		this.hashFields.put("vvd2", "vvd2");

		this.hashFields.put("del_cd", "delCd");

		this.hashFields.put("check_ipi_local", "checkIpiLocal");
		this.hashFields.put("check_dest_ctrl", "checkDestCtrl");
		this.hashFields.put("check_ipi_local2", "checkIpiLocal2");
		this.hashFields.put("check_dest_ctrl2", "checkDestCtrl2");

		this.hashFields.put("login_user_id", "loginUserId");
		this.hashFields.put("por_cd", "porCd");
	
		this.hashFields.put("check_sector2", "checkSector2");
		this.hashFields.put("check_sector5", "checkSector5");

		this.hashFields.put("check_vvd1", "checkVvd1");
		this.hashFields.put("check_vvd2", "checkVvd2");
		this.hashFields.put("check_vvd3", "checkVvd3");
		this.hashFields.put("check_vvd4", "checkVvd4");
		this.hashFields.put("check_vvd5", "checkVvd5");
		return this.hashFields;
	}


	public String getPorCd() {
		return porCd;
	}

	public void setPorCd(String por_cd) {
		this.porCd = por_cd;
	}
	
	public String getChkArea1() {
		return chkArea1;
	}

	public void setChkArea1(String chkArea1) {
		this.chkArea1 = chkArea1;
	}

	public String getChkArea2() {
		return chkArea2;
	}

	public void setChkArea2(String chkArea2) {
		this.chkArea2 = chkArea2;
	}

	public String getChkArea3() {
		return chkArea3;
	}

	public void setChkArea3(String chkArea3) {
		this.chkArea3 = chkArea3;
	}

	public String getChkArea4() {
		return chkArea4;
	}

	public void setChkArea4(String chkArea4) {
		this.chkArea4 = chkArea4;
	}

	public String getSubOffice() {
		return subOffice;
	}

	public void setSubOffice(String subOffice) {
		this.subOffice = subOffice;
	}

	public String getOfcCd() {
		return ofcCd;
	}

	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	/**
	 * Column Info
	 * @return subtrade4
	 */
	public String getSubtrade4() {
		return this.subtrade4;
	}

	/**
	 * Column Info
	 * @return subtrade3
	 */
	public String getSubtrade3() {
		return this.subtrade3;
	}

	/**
	 * Column Info
	 * @return subtrade2
	 */
	public String getSubtrade2() {
		return this.subtrade2;
	}

	/**
	 * Column Info
	 * @return subtrade1
	 */
	public String getSubtrade1() {
		return this.subtrade1;
	}

	/**
	 * Column Info
	 * @return trade
	 */
	public String getTrade() {
		return this.trade;
	}

	/**
	 * Column Info
	 * @return salesOffice
	 */
	public String getSalesOffice() {
		return this.salesOffice;
	}

	/**
	 * Column Info
	 * @return chkview
	 */
	public String getChkview() {
		return this.chkview;
	}

	/**
	 * Column Info
	 * @return week1
	 */
	public String getWeek1() {
		return this.week1;
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
	 * @return duration
	 */
	public String getDuration() {
		return this.duration;
	}

	/**
	 * Column Info
	 * @return duration2From
	 */
	public String getDuration2From() {
		return this.duration2From;
	}

	/**
	 * Column Info
	 * @return duration2To
	 */
	public String getDuration2To() {
		return this.duration2To;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}

	/**
	 * Column Info
	 * @return area
	 */
	public String getArea() {
		return this.area;
	}

	/**
	 * Column Info
	 * @return year1
	 */
	public String getYear1() {
		return this.year1;
	}

	/**
	 * Column Info
	 * @return bound
	 */
	public String getBound() {
		return this.bound;
	}

	/**
	 * Column Info
	 * @return rhq
	 */
	public String getRhq() {
		return this.rhq;
	}


	public String getRhq2() {
		return rhq2;
	}

	/**
	 * Column Info
	 * @return rlane1
	 */
	public String getRlane1() {
		return this.rlane1;
	}
	/**
	 * Column Info
	 * @return rlane2
	 */
	public String getRlane2() {
		return this.rlane2;
	}
	/**
	 * Column Info
	 * @return rlane3
	 */
	public String getRlane3() {
		return this.rlane3;
	}

	/**
	 * Column Info
	 * @return rlane4
	 */
	public String getRlane4() {
		return this.rlane4;
	}

	/**
	 * @return the fromDt
	 */
	public String getFromDt() {
		return fromDt;
	}

	/**
	 * @param fromDt the fromDt to set
	 */
	public void setFromDt(String fromDt) {
		this.fromDt = fromDt;
	}

	/**
	 * @return the duration1
	 */
	public String getDuration1() {
		return duration1;
	}

	/**
	 * Column Info
	 * @return subtrade11
	 */
	public String getSubtrade11() {
		return this.subtrade11;
	}

	/**
	 * Column Info
	 * @return rlane11
	 */
	public String getRlane11() {
		return this.rlane11;
	}

	/**
	 * Column Info
	 * @return viewType11
	 */
	public String getViewType11() {
		return this.viewType11;
	}
	
	/**
	 * Column Info
	 * @return checkSmp
	 */
	public String getCheckSmp() {
		return this.checkSmp;
	}
	
	/**
	 * Column Info
	 * @return acct
	 */
	public String getAcct() {
		return this.acct;
	}

	/**
	 * Column Info
	 * @return grpAcct
	 */
	public String getGrpAcct() {
		return this.grpAcct;
	}

	/**
	 * Column Info
	 * @return acctClss
	 */
	public String getAcctClss() {
		return this.acctClss;
	}


	/**
	 * @param duration1 the duration1 to set
	 */
	public void setDuration1(String duration1) {
		this.duration1 = duration1;
	}

	/**
	 * @return the trade7
	 */
	public String getTrade7() {
		return trade7;
	}

	/**
	 * @param trade7 the trade7 to set
	 */
	public void setTrade7(String trade7) {
		this.trade7 = trade7;
	}

	/**
	 * @return the subtrade7
	 */
	public String getSubtrade7() {
		return subtrade7;
	}

	/**
	 * @param subtrade7 the subtrade7 to set
	 */
	public void setSubtrade7(String subtrade7) {
		this.subtrade7 = subtrade7;
	}

	/**
	 * @return the rlane7
	 */
	public String getRlane7() {
		return rlane7;
	}

	/**
	 * @param rlane7 the rlane7 to set
	 */
	public void setRlane7(String rlane7) {
		this.rlane7 = rlane7;
	}

	/**
	 * @return the rhq1
	 */
	public String getRhq1() {
		return rhq1;
	}

	/**
	 * @param rhq1 the rhq1 to set
	 */
	public void setRhq1(String rhq1) {
		this.rhq1 = rhq1;
	}

	/**
	 * @return the area1
	 */
	public String getArea1() {
		return area1;
	}

	/**
	 * @param area1 the area1 to set
	 */
	public void setArea1(String area1) {
		this.area1 = area1;
	}

	/**
	 * @return the salesOffice1
	 */
	public String getSalesOffice1() {
		return salesOffice1;
	}

	/**
	 * @param salesOffice1 the salesOffice1 to set
	 */
	public void setSalesOffice1(String salesOffice1) {
		this.salesOffice1 = salesOffice1;
	}

	/**
	 * @return the srepCd
	 */
	public String getSrepCd() {
		return srepCd;
	}

	/**
	 * @param srepCd the srepCd to set
	 */
	public void setSrepCd(String srepCd) {
		this.srepCd = srepCd;
	}

	public void setRhq2(String rhq2) {
		this.rhq2 = rhq2;
	}

	/**
	 * Column Info
	 * @param subtrade4
	 */
	public void setSubtrade4(String subtrade4) {
		this.subtrade4 = subtrade4;
	}

	/**
	 * Column Info
	 * @param subtrade3
	 */
	public void setSubtrade3(String subtrade3) {
		this.subtrade3 = subtrade3;
	}

	/**
	 * Column Info
	 * @param subtrade2
	 */
	public void setSubtrade2(String subtrade2) {
		this.subtrade2 = subtrade2;
	}

	/**
	 * Column Info
	 * @param subtrade1
	 */
	public void setSubtrade1(String subtrade1) {
		this.subtrade1 = subtrade1;
	}

	/**
	 * Column Info
	 * @param trade
	 */
	public void setTrade(String trade) {
		this.trade = trade;
	}

	/**
	 * Column Info
	 * @param salesOffice
	 */
	public void setSalesOffice(String salesOffice) {
		this.salesOffice = salesOffice;
	}

	/**
	 * Column Info
	 * @param chkview
	 */
	public void setChkview(String chkview) {
		this.chkview = chkview;
	}

	/**
	 * Column Info
	 * @param week1
	 */
	public void setWeek1(String week1) {
		this.week1 = week1;
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
	 * @param duration
	 */
	public void setDuration(String duration) {
		this.duration = duration;
	}

	/**
	 * Column Info
	 * @param duration2From
	 */
	public void setDuration2From(String duration2From) {
		this.duration2From = duration2From;
	}

	/**
	 * Column Info
	 * @param duration2To
	 */
	public void setDuration2To(String duration2To) {
		this.duration2To = duration2To;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}

	/**
	 * Column Info
	 * @param area
	 */
	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * Column Info
	 * @param year1
	 */
	public void setYear1(String year1) {
		this.year1 = year1;
	}

	/**
	 * Column Info
	 * @param bound
	 */
	public void setBound(String bound) {
		this.bound = bound;
	}

	/**
	 * Column Info
	 * @param rhq
	 */
	public void setRhq(String rhq) {
		this.rhq = rhq;
	}



	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMonth() {
		return month;
	}
	public String getRevMonth() {
		return revMonth;
	}
	public String getMonFlg() {
		return monFlg;
	}

	public void setMonth(String month) {
		this.month = month;
	}
	public void setRevMonth(String revMonth) {
		this.revMonth = revMonth;
	}
	public void setMonFlg(String monFlg) {
		this.monFlg = monFlg;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getLane() {
		return lane;
	}

	public void setLane(String lane) {
		this.lane = lane;
	}

	public String getVvd() {
		return vvd;
	}

	public void setVvd(String vvd) {
		this.vvd = vvd;
	}

	public String getWeek2() {
		return week2;
	}

	public void setWeek2(String week2) {
		this.week2 = week2;
	}

	public String getYear2() {
		return year2;
	}

	public void setYear2(String year2) {
		this.year2 = year2;
	}

	public String getUserOfc() {
		return userOfc;
	}

	public void setUserOfc(String userOfc) {
		this.userOfc = userOfc;
	}

	public String getSubTrade() {
		return subTrade;
	}

	public void setSubTrade(String subTrade) {
		this.subTrade = subTrade;
	}

	public String getOncIpc() {
		return oncIpc;
	}

	public void setOncIpc(String oncIpc) {
		this.oncIpc = oncIpc;
	}

	public String getOnlyVvd() {
		return onlyVvd;
	}

	public void setOnlyVvd(String onlyVvd) {
		this.onlyVvd = onlyVvd;
	}

	public String getRhqTxt() {
		return rhqTxt;
	}

	public void setRhqTxt(String rhqTxt) {
		this.rhqTxt = rhqTxt;
	}

	public String getRhqGso() {
		return rhqGso;
	}

	public void setRhqGso(String rhqGso) {
		this.rhqGso = rhqGso;
	}

	public String getPolPod() {
		return polPod;
	}

	public void setPolPod(String polPod) {
		this.polPod = polPod;
	}

	public String getVslCd() {
		return vslCd;
	}

	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}

	public String getSkdVoyNo() {
		return skdVoyNo;
	}

	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}

	public String getSkdDirCd() {
		return skdDirCd;
	}

	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}

	public String getSDate() {
		return sDate;
	}

	public void setSDate(String date) {
		sDate = date;
	}

	public String getEDate() {
		return eDate;
	}

	public void setEDate(String date) {
		eDate = date;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getIoc() {
		return ioc;
	}

	public void setIoc(String ioc) {
		this.ioc = ioc;
	}

	public String getOrg() {
		return org;
	}

	public void setOrg(String org) {
		this.org = org;
	}

	public void setRlane1(String rlane1) {
		this.rlane1 = rlane1;
	}
	public void setRlane2(String rlane2) {
		this.rlane2 = rlane2;
	}
	public void setRlane3(String rlane3) {
		this.rlane3 = rlane3;
	}
	public void setRlane4(String rlane4) {
		this.rlane4 = rlane4;
	}

	/**
	 * Column Info
	 * @return checkDest2
	 */
	public String getCheckDest2() {
		return this.checkDest2;
	}

	/**
	 * Column Info
	 * @param checkDest2
	 */
	public void setCheckDest2(String checkDest2) {
		this.checkDest2 = checkDest2;
	}

	/**
	 * Column Info
	 * @return checkDest3
	 */
	public String getCheckDest3() {
		return this.checkDest3;
	}

	/**
	 * Column Info
	 * @param checkDest3
	 */
	public void setCheckDest3(String checkDest3) {
		this.checkDest3 = checkDest3;
	}

	/**
	 * Column Info
	 * @return checkDest4
	 */
	public String getCheckDest4() {
		return this.checkDest4;
	}

	/**
	 * Column Info
	 * @param checkDest4
	 */
	public void setCheckDest4(String checkDest4) {
		this.checkDest4 = checkDest4;
	}


	/**
	 * @return the chkArea5
	 */
	public String getChkArea5() {
		return chkArea5;
	}

	/**
	 * @param chkArea5 the chkArea5 to set
	 */
	public void setChkArea5(String chkArea5) {
		this.chkArea5 = chkArea5;
	}

	/**
	 * @return the checkDest5
	 */
	public String getCheckDest5() {
		return checkDest5;
	}

	/**
	 * @param checkDest5 the checkDest5 to set
	 */
	public void setCheckDest5(String checkDest5) {
		this.checkDest5 = checkDest5;
	}

	/**
	 * @return the subtrade5
	 */
	public String getSubtrade5() {
		return subtrade5;
	}

	/**
	 * @param subtrade5 the subtrade5 to set
	 */
	public void setSubtrade5(String subtrade5) {
		this.subtrade5 = subtrade5;
	}

	/**
	 * @return the rlane5
	 */
	public String getRlane5() {
		return rlane5;
	}

	/**
	 * @param rlane5 the rlane5 to set
	 */
	public void setRlane5(String rlane5) {
		this.rlane5 = rlane5;
	}



	/**
	 * @return the portDiv
	 */
	public String getPortDiv() {
		return portDiv;
	}

	/**
	 * @param portDiv the portDiv to set
	 */
	public void setPortDiv(String portDiv) {
		this.portDiv = portDiv;
	}


	public String getRlane6() {
		return rlane6;
	}

	public void setRlane6(String rlane6) {
		this.rlane6 = rlane6;
	}

	public String getSubtrade6() {
		return subtrade6;
	}

	public void setSubtrade6(String subtrade6) {
		this.subtrade6 = subtrade6;
	}


	public String getViewDiv() {
		return viewDiv;
	}

	public void setViewDiv(String viewDiv) {
		this.viewDiv = viewDiv;
	}

	/**
	 * @return the bound1
	 */
	public String getBound1() {
		return bound1;
	}

	/**
	 * @param bound1 the bound1 to set
	 */
	public void setBound1(String bound1) {
		this.bound1 = bound1;
	}

	/**
	 * Column Info
	 * @param subtrade11
	 */
	public void setSubtrade11(String subtrade11) {
		this.subtrade11 = subtrade11;
	}

	/**
	 * Column Info
	 * @param rlane11
	 */
	public void setRlane11(String rlane11) {
		this.rlane11 = rlane11;
	}

	/**
	 * Column Info
	 * @param viewType11
	 */
	public void setViewType11(String viewType11) {
		this.viewType11 = viewType11;
	}

	/**
	 * Column Info
	 * @param checkSmp
	 */
	public void setCheckSmp(String checkSmp) {
		this.checkSmp = checkSmp;
	}
	
	/**
	 * Column Info
	 * @param acct
	 */
	public void setAcct(String acct) {
		this.acct = acct;
	}

	/**
	 * Column Info
	 * @param grpAcct
	 */
	public void setGrpAcct(String grpAcct) {
		this.grpAcct = grpAcct;
	}

	/**
	 * Column Info
	 * @param acctClss
	 */
	public void setAcctClss(String acctClss) {
		this.acctClss = acctClss;
	}

	public String getVvd1() {
		return vvd1;
	}

	public void setVvd1(String vvd1) {
		this.vvd1 = vvd1;
	}

	public String getVvd2() {
		return vvd2;
	}

	public void setVvd2(String vvd2) {
		this.vvd2 = vvd2;
	}



	/**
	 * @return the delCd
	 */
	public String getDelCd() {
		return delCd;
	}

	/**
	 * @param delCd the delCd to set
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}

	public String getCheckIpiLocal() {
		return checkIpiLocal;
	}

	public void setCheckIpiLocal(String checkIpiLocal) {
		this.checkIpiLocal = checkIpiLocal;
	}

	public String getCheckDestCtrl() {
		return checkDestCtrl;
	}

	public void setCheckDestCtrl(String checkDestCtrl) {
		this.checkDestCtrl = checkDestCtrl;
	}
	public String getCheckIpiLocal2() {
		return checkIpiLocal2;
	}
	
	public void setCheckIpiLocal2(String checkIpiLocal2) {
		this.checkIpiLocal2 = checkIpiLocal2;
	}
	
	public String getCheckDestCtrl2() {
		return checkDestCtrl2;
	}
	
	public void setCheckDestCtrl2(String checkDestCtrl2) {
		this.checkDestCtrl2 = checkDestCtrl2;
	}


	/**
	 * @return the checkSector2
	 */
	public String getCheckSector2() {
		return checkSector2;
	}

	/**
	 * @return the checkSector5
	 */
	public String getCheckSector5() {
		return checkSector5;
	}

	/**
	 * @param checkSector2 the checkSector2 to set
	 */
	public void setCheckSector2(String checkSector2) {
		this.checkSector2 = checkSector2;
	}

	/**
	 * @param checkSector5 the checkSector5 to set
	 */
	public void setCheckSector5(String checkSector5) {
		this.checkSector5 = checkSector5;
	}

	/**
	 * @return the loginUserId
	 */
	public String getLoginUserId() {
		return loginUserId;
	}

	/**
	 * @param loginUserId the loginUserId to set
	 */
	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	/**
	 * 
	 * @return
	 */
	public String getCheckVvd1() {
		return checkVvd1;
	}

	/**
	 * 
	 * @param checkVvd1
	 */
	public void setCheckVvd1(String checkVvd1) {
		this.checkVvd1 = checkVvd1;
	}

	/**
	 * 
	 * @return
	 */
	public String getCheckVvd2() {
		return checkVvd2;
	}

	/**
	 * 
	 * @param checkVvd2
	 */
	public void setCheckVvd2(String checkVvd2) {
		this.checkVvd2 = checkVvd2;
	}

	/**
	 * 
	 * @return
	 */
	public String getCheckVvd3() {
		return checkVvd3;
	}

	/**
	 * 
	 * @param checkVvd3
	 */
	public void setCheckVvd3(String checkVvd3) {
		this.checkVvd3 = checkVvd3;
	}

	/**
	 * 
	 * @return
	 */
	public String getCheckVvd4() {
		return checkVvd4;
	}

	/**
	 * 
	 * @param checkVvd4
	 */
	public void setCheckVvd4(String checkVvd4) {
		this.checkVvd4 = checkVvd4;
	}

	/**
	 * 
	 * @return
	 */
	public String getCheckVvd5() {
		return checkVvd5;
	}

	/**
	 * 
	 * @param checkVvd5
	 */
	public void setCheckVvd5(String checkVvd5) {
		this.checkVvd5 = checkVvd5;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSubtrade5(JSPUtil.getParameter(request, "subtrade5", ""));
		setSubtrade4(JSPUtil.getParameter(request, "subtrade4", ""));
		setSubtrade3(JSPUtil.getParameter(request, "subtrade3", ""));
		setSubtrade2(JSPUtil.getParameter(request, "subtrade2", ""));
		setSubtrade1(JSPUtil.getParameter(request, "subtrade1", ""));
		setTrade(JSPUtil.getParameter(request, "trade", ""));
		setSalesOffice(JSPUtil.getParameter(request, "sales_office", ""));
		setChkview(JSPUtil.getParameter(request, "chkview", ""));
		setWeek1(JSPUtil.getParameter(request, "week1", ""));
		setWeek2(JSPUtil.getParameter(request, "week2", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDuration(JSPUtil.getParameter(request, "duration", ""));
		setDuration2From(JSPUtil.getParameter(request, "duration2_from", ""));
		setDuration2To(JSPUtil.getParameter(request, "duration2_to", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setArea(JSPUtil.getParameter(request, "area", ""));
		setYear1(JSPUtil.getParameter(request, "year", ""));
		if(JSPUtil.getParameter(request, "year1", "") != "")
			setYear1(JSPUtil.getParameter(request, "year1", ""));
		setYear2(JSPUtil.getParameter(request, "year2", ""));
		setBound(JSPUtil.getParameter(request, "bound", ""));
		setRhq(JSPUtil.getParameter(request, "rhq", ""));
		setRhq2(JSPUtil.getParameter(request, "rhq2", ""));
		setType(JSPUtil.getParameter(request, "type", ""));
		setMonth(JSPUtil.getParameter(request, "month", ""));
		setRevMonth(JSPUtil.getParameter(request, "rev_month", ""));
		setMonFlg(JSPUtil.getParameter(request, "mon_flg", ""));
		setWeek(JSPUtil.getParameter(request, "week", ""));
		setOffice(JSPUtil.getParameter(request, "office", ""));
		setLane(JSPUtil.getParameter(request, "lane", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));

		setSubTrade(JSPUtil.getParameter(request, "subtrade", ""));
		setOncIpc(JSPUtil.getParameter(request, "onc_ipc", ""));
		setOnlyVvd(JSPUtil.getParameter(request, "only_vvd", ""));
		setRhqTxt(JSPUtil.getParameter(request, "rhq_txt", ""));
		setRhqGso(JSPUtil.getParameter(request, "rhq_gso", ""));
		setPolPod(JSPUtil.getParameter(request, "pol_pod", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));

		setSDate(JSPUtil.getParameter(request, "sDate", ""));
		setEDate(JSPUtil.getParameter(request, "eDate", ""));
		setPort(JSPUtil.getParameter(request, "port", ""));
		setIoc(JSPUtil.getParameter(request, "ioc", ""));
		setOrg(JSPUtil.getParameter(request, "org", ""));
		setSubOffice(JSPUtil.getParameter(request, "sub_office", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setRlane1(JSPUtil.getParameter(request, "rlane1", ""));
		setRlane2(JSPUtil.getParameter(request, "rlane2", ""));
		setRlane3(JSPUtil.getParameter(request, "rlane3", ""));
		setRlane4(JSPUtil.getParameter(request, "rlane4", ""));
		setRlane5(JSPUtil.getParameter(request, "rlane5", ""));
		setChkArea1(JSPUtil.getParameter(request, "check_area1", ""));
		setChkArea2(JSPUtil.getParameter(request, "check_area2", ""));
		setChkArea3(JSPUtil.getParameter(request, "check_area3", ""));
		setChkArea4(JSPUtil.getParameter(request, "check_area4", ""));
		setChkArea5(JSPUtil.getParameter(request, "check_area5", ""));
		setCheckDest2(JSPUtil.getParameter(request, "check_dest2", ""));
		setCheckDest3(JSPUtil.getParameter(request, "check_dest3", ""));
		setCheckDest4(JSPUtil.getParameter(request, "check_dest4", ""));
		setCheckDest5(JSPUtil.getParameter(request, "check_dest5", ""));

		setContents(JSPUtil.getParameter(request, "contents", ""));

		// add 2012.08.08
		setPortDiv(JSPUtil.getParameter(request, "port_div", ""));
		setRlane6(JSPUtil.getParameter(request, "rlane6", ""));
		setSubtrade6(JSPUtil.getParameter(request, "subtrade6", ""));

		setViewDiv(JSPUtil.getParameter(request, "viewDiv", ""));


		setTrade7(JSPUtil.getParameter(request, "trade7", ""));
		setSubtrade7(JSPUtil.getParameter(request, "subtrade7", ""));
		setRlane7(JSPUtil.getParameter(request, "rlane7", ""));
		setBound1(JSPUtil.getParameter(request, "bound1", ""));
		setRhq1(JSPUtil.getParameter(request, "rhq1", ""));
		setArea1(JSPUtil.getParameter(request, "area1", ""));
		setSalesOffice1(JSPUtil.getParameter(request, "sales_office1", ""));
		setFromDt(JSPUtil.getParameter(request, "from_dt", ""));
		setDuration1(JSPUtil.getParameter(request, "duration1", ""));
		setSrepCd(JSPUtil.getParameter(request, "srep_cd", ""));

		setSubtrade11(JSPUtil.getParameter(request, "subtrade11", ""));
		setRlane11(JSPUtil.getParameter(request, "rlane11", ""));
		setViewType11(JSPUtil.getParameter(request, "view_type11", ""));
		setCheckSmp(JSPUtil.getParameter(request, "check_smp", ""));

		setAcct(JSPUtil.getParameter(request, "acct", ""));
		setGrpAcct(JSPUtil.getParameter(request, "grp_acct", ""));
		setAcctClss(JSPUtil.getParameter(request, "acct_clss", ""));

		setVvd1(JSPUtil.getParameter(request, "vvd1", ""));
		setVvd2(JSPUtil.getParameter(request, "vvd2", ""));

		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));//

		setCheckIpiLocal(JSPUtil.getParameter(request, "check_ipi_local", ""));
		setCheckDestCtrl(JSPUtil.getParameter(request, "check_dest_ctrl", ""));
		setCheckIpiLocal2(JSPUtil.getParameter(request, "check_ipi_local2", ""));
		setCheckDestCtrl2(JSPUtil.getParameter(request, "check_dest_ctrl2", ""));

		setLoginUserId(JSPUtil.getParameter(request, "login_user_id", ""));
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));

		setCheckSector2(JSPUtil.getParameter(request, "check_sector2", ""));
		setCheckSector5(JSPUtil.getParameter(request, "check_sector5", ""));

		setCheckVvd1(JSPUtil.getParameter(request, "check_vvd1", ""));
		setCheckVvd2(JSPUtil.getParameter(request, "check_vvd2", ""));
		setCheckVvd3(JSPUtil.getParameter(request, "check_vvd3", ""));
		setCheckVvd4(JSPUtil.getParameter(request, "check_vvd4", ""));
		setCheckVvd5(JSPUtil.getParameter(request, "check_vvd5", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSpaceControlInquiryConditionVO[]
	 */
	public SearchSpaceControlInquiryConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return SearchSpaceControlInquiryConditionVO[]
	 */
	public SearchSpaceControlInquiryConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSpaceControlInquiryConditionVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] subtrade5 = (JSPUtil.getParameter(request, prefix	+ "subtrade5", length));
			String[] subtrade4 = (JSPUtil.getParameter(request, prefix	+ "subtrade4", length));
			String[] subtrade3 = (JSPUtil.getParameter(request, prefix	+ "subtrade3", length));
			String[] subtrade2 = (JSPUtil.getParameter(request, prefix	+ "subtrade2", length));
			String[] subtrade1 = (JSPUtil.getParameter(request, prefix	+ "subtrade1", length));
			String[] trade = (JSPUtil.getParameter(request, prefix	+ "trade", length));
			String[] salesOffice = (JSPUtil.getParameter(request, prefix	+ "sales_office", length));
			String[] chkview = (JSPUtil.getParameter(request, prefix	+ "chkview", length));
			String[] week1 = (JSPUtil.getParameter(request, prefix	+ "week1", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] duration = (JSPUtil.getParameter(request, prefix	+ "duration", length));
			String[] duration2From = (JSPUtil.getParameter(request, prefix	+ "duration2_from", length));
			String[] duration2To = (JSPUtil.getParameter(request, prefix	+ "duration2_to", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] area = (JSPUtil.getParameter(request, prefix	+ "area", length));
			String[] year1 = (JSPUtil.getParameter(request, prefix	+ "year1", length));
			String[] bound = (JSPUtil.getParameter(request, prefix	+ "bound", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix	+ "rhq", length));
			String[] rhq2 = (JSPUtil.getParameter(request, prefix	+ "rhq2", length));
			String[] type = (JSPUtil.getParameter(request, prefix	+ "type", length));
			String[] month = (JSPUtil.getParameter(request, prefix	+ "month", length));
			String[] revMonth = (JSPUtil.getParameter(request, prefix	+ "rev_month", length));
			String[] monFlg = (JSPUtil.getParameter(request, prefix	+ "mon_flg", length));
			String[] week = (JSPUtil.getParameter(request, prefix	+ "week", length));
			String[] office = (JSPUtil.getParameter(request, prefix	+ "office", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] subOffice = (JSPUtil.getParameter(request, prefix	+ "sub_office", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] rlane1 = (JSPUtil.getParameter(request, prefix	+ "rlane1", length));
			String[] rlane2 = (JSPUtil.getParameter(request, prefix	+ "rlane2", length));
			String[] rlane3 = (JSPUtil.getParameter(request, prefix	+ "rlane3", length));
			String[] rlane4 = (JSPUtil.getParameter(request, prefix	+ "rlane4", length));
			String[] rlane5 = (JSPUtil.getParameter(request, prefix	+ "rlane5", length));
			String[] chkArea1 = (JSPUtil.getParameter(request, prefix	+ "check_area1", length));
			String[] chkArea2 = (JSPUtil.getParameter(request, prefix	+ "check_area2", length));
			String[] chkArea3 = (JSPUtil.getParameter(request, prefix	+ "check_area3", length));
			String[] chkArea4 = (JSPUtil.getParameter(request, prefix	+ "check_area4", length));
			String[] chkArea5 = (JSPUtil.getParameter(request, prefix	+ "check_area5", length));
			String[] checkDest2 = (JSPUtil.getParameter(request, prefix	+ "check_dest2", length));
			String[] checkDest3 = (JSPUtil.getParameter(request, prefix	+ "check_dest3", length));
			String[] checkDest4 = (JSPUtil.getParameter(request, prefix	+ "check_dest4", length));
			String[] checkDest5 = (JSPUtil.getParameter(request, prefix	+ "check_dest5", length));
			String[] contents = (JSPUtil.getParameter(request, prefix	+ "contents", length));

			String[] portDiv = (JSPUtil.getParameter(request, prefix	+ "port_div", length));
			String[] rlane6 = (JSPUtil.getParameter(request, prefix	+ "rlane6", length));
			String[] subtrade6 = (JSPUtil.getParameter(request, prefix	+ "subtrade6", length));

			String[] viewDiv = (JSPUtil.getParameter(request, prefix	+ "viewDiv", length));

			String[] trade7 = (JSPUtil.getParameter(request, prefix	+ "trade7", length));
			String[] rlane7 = (JSPUtil.getParameter(request, prefix	+ "rlane7", length));
			String[] subtrade7 = (JSPUtil.getParameter(request, prefix	+ "subtrade7", length));
			String[] bound1 = (JSPUtil.getParameter(request, prefix	+ "bound1", length));
			String[] rhq1 = (JSPUtil.getParameter(request, prefix	+ "rhq1", length));
			String[] area1 = (JSPUtil.getParameter(request, prefix	+ "area1", length));
			String[] salesOffice1 = (JSPUtil.getParameter(request, prefix	+ "sales_office1", length));
			String[] fromDt = (JSPUtil.getParameter(request, prefix	+ "from_dt", length));
			String[] duration1 = (JSPUtil.getParameter(request, prefix	+ "duration1", length));
			String[] srepCd = (JSPUtil.getParameter(request, prefix	+ "srep_cd", length));

			String[] subtrade11 = (JSPUtil.getParameter(request, prefix	+ "subtrade11", length));
			String[] rlane11 = (JSPUtil.getParameter(request, prefix	+ "rlane11", length));
			String[] viewType11 = (JSPUtil.getParameter(request, prefix	+ "view_type11", length));
			String[] checkSmp = (JSPUtil.getParameter(request, prefix	+ "check_smp", length));

			String[] acct = (JSPUtil.getParameter(request, prefix	+ "acct", length));
			String[] grpAcct = (JSPUtil.getParameter(request, prefix	+ "grp_acct", length));
			String[] acctClss = (JSPUtil.getParameter(request, prefix	+ "acct_clss", length));

			String[] vvd1 = (JSPUtil.getParameter(request, prefix	+ "vvd1", length));
			String[] vvd2 = (JSPUtil.getParameter(request, prefix	+ "vvd2", length));

			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));

			String[] checkIpiLocal = (JSPUtil.getParameter(request, prefix	+ "check_ipi_local", length));
			String[] checkDestCtrl = (JSPUtil.getParameter(request, prefix	+ "check_dest_ctrl", length));
			String[] checkIpiLocal2 = (JSPUtil.getParameter(request, prefix	+ "check_ipi_local2", length));
			String[] checkDestCtrl2 = (JSPUtil.getParameter(request, prefix	+ "check_dest_ctrl2", length));
			String[] loginUserId = (JSPUtil.getParameter(request, prefix	+ "login_user_id", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] checkSector2 = (JSPUtil.getParameter(request, prefix	+ "check_sector2", length));
			String[] checkSector5 = (JSPUtil.getParameter(request, prefix	+ "check_sector5", length));

			String[] checkVvd1 = (JSPUtil.getParameter(request, prefix	+ "check_vvd1", length));
			String[] checkVvd2 = (JSPUtil.getParameter(request, prefix	+ "check_vvd2", length));
			String[] checkVvd3 = (JSPUtil.getParameter(request, prefix	+ "check_vvd3", length));
			String[] checkVvd4 = (JSPUtil.getParameter(request, prefix	+ "check_vvd4", length));
			String[] checkVvd5 = (JSPUtil.getParameter(request, prefix	+ "check_vvd5", length));

			for (int i = 0; i < length; i++) {
				model = new SearchSpaceControlInquiryConditionVO();
				if (subtrade5[i] != null)
					model.setSubtrade4(subtrade5[i]);
				if (subtrade4[i] != null)
					model.setSubtrade4(subtrade4[i]);
				if (subtrade3[i] != null)
					model.setSubtrade3(subtrade3[i]);
				if (subtrade2[i] != null)
					model.setSubtrade2(subtrade2[i]);
				if (subtrade1[i] != null)
					model.setSubtrade1(subtrade1[i]);
				if (trade[i] != null)
					model.setTrade(trade[i]);
				if (salesOffice[i] != null)
					model.setSalesOffice(salesOffice[i]);
				if (chkview[i] != null)
					model.setChkview(chkview[i]);
				if (week1[i] != null)
					model.setWeek1(week1[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (duration[i] != null)
					model.setDuration(duration[i]);
				if (duration2From[i] != null)
					model.setDuration2From(duration2From[i]);
				if (duration2To[i] != null)
					model.setDuration2To(duration2To[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (area[i] != null)
					model.setArea(area[i]);
				if (year1[i] != null)
					model.setYear1(year1[i]);
				if (bound[i] != null)
					model.setBound(bound[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				if (rhq2[i] != null)
					model.setRhq2(rhq2[i]);
				if (type[i] != null)
					model.setType(type[i]);
				if (month[i] != null)
					model.setMonth(month[i]);
				if (revMonth[i] != null)
					model.setRevMonth(revMonth[i]);
				if (monFlg[i] != null)
					model.setMonFlg(monFlg[i]);
				if (week[i] != null)
					model.setWeek(week[i]);
				if (office[i] != null)
					model.setOffice(office[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (subOffice[i] != null)
					model.setSubOffice(subOffice[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (rlane1[i] != null)
					model.setRlane1(rlane1[i]);
				if (rlane2[i] != null)
					model.setRlane2(rlane2[i]);
				if (rlane3[i] != null)
					model.setRlane3(rlane3[i]);
				if (rlane4[i] != null)
					model.setRlane4(rlane4[i]);
				if (rlane5[i] != null)
					model.setRlane4(rlane5[i]);
				if (chkArea1[i] != null)
					model.setChkArea1(chkArea1[i]);
				if (chkArea2[i] != null)
					model.setChkArea2(chkArea2[i]);
				if (chkArea3[i] != null)
					model.setChkArea3(chkArea3[i]);
				if (chkArea4[i] != null)
					model.setChkArea4(chkArea4[i]);
				if (chkArea5[i] != null)
					model.setChkArea4(chkArea5[i]);
				if (checkDest2[i] != null)
					model.setCheckDest2(checkDest2[i]);
				if (checkDest3[i] != null)
					model.setCheckDest3(checkDest3[i]);
				if (checkDest4[i] != null)
					model.setCheckDest4(checkDest4[i]);
				if (checkDest5[i] != null)
					model.setCheckDest4(checkDest5[i]);
				if (contents[i] != null)
					model.setContents(contents[i]);


				if (portDiv[i] != null)
					model.setPortDiv(portDiv[i]);
				if (rlane6[i] != null)
					model.setRlane6(rlane6[i]);
				if (subtrade6[i] != null)
					model.setSubtrade6(subtrade6[i]);
				if ( viewDiv[i] != null)
					model.setViewDiv(viewDiv[i]);

				if (trade7[i] != null)
					model.setTrade7(trade7[i]);
				if (rlane7[i] != null)
					model.setRlane7(rlane7[i]);
				if (subtrade7[i] != null)
					model.setSubtrade7(subtrade7[i]);
				if (bound1[i] != null)
					model.setBound1(bound1[i]);
				if ( fromDt[i] != null)
					model.setFromDt(fromDt[i]);
				if ( duration1[i] != null)
					model.setDuration1(duration1[i]);
				if ( rhq1[i] != null)
					model.setRhq1(rhq1[i]);
				if ( area1[i] != null)
					model.setArea1(area1[i]);
				if ( salesOffice1[i] != null)
					model.setSalesOffice1(salesOffice1[i]);
				if ( srepCd[i] != null)
					model.setSrepCd(srepCd[i]);

				if (subtrade11[i] != null)
					model.setSubtrade11(subtrade11[i]);
				if (rlane11[i] != null)
					model.setRlane11(rlane11[i]);
				if (viewType11[i] != null)
					model.setViewType11(viewType11[i]);
				if (checkSmp[i] != null)
					model.setCheckSmp(checkSmp[i]);
				if (acct[i] != null)
					model.setAcct(acct[i]);
				if (grpAcct[i] != null)
					model.setGrpAcct(grpAcct[i]);
				if (acctClss[i] != null)
					model.setAcctClss(acctClss[i]);

				if (vvd1[i] != null)
					model.setVvd1(vvd1[i]);
				if (vvd2[i] != null)
					model.setVvd2(vvd2[i]);

				if (delCd[i] != null)
					model.setDelCd(delCd[i]);

				if (checkIpiLocal[i] != null)
					model.setCheckIpiLocal(checkIpiLocal[i]);
				if (checkDestCtrl[i] != null)
					model.setCheckDestCtrl(checkDestCtrl[i]);
				if (checkIpiLocal2[i] != null)
					model.setCheckIpiLocal2(checkIpiLocal2[i]);
				if (checkDestCtrl2[i] != null)
					model.setCheckDestCtrl2(checkDestCtrl2[i]);
				if (loginUserId[i] != null)
					model.setLoginUserId(loginUserId[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
					
				if (checkSector2[i] != null)
					model.setCheckSector2(checkSector2[i]);
				if (checkSector5[i] != null)
					model.setCheckSector5(checkSector5[i]);

				if (checkVvd1[i] != null)
					model.setCheckVvd1(checkVvd1[i]);
				if (checkVvd2[i] != null)
					model.setCheckVvd2(checkVvd2[i]);
				if (checkVvd3[i] != null)
					model.setCheckVvd3(checkVvd3[i]);
				if (checkVvd4[i] != null)
					model.setCheckVvd4(checkVvd4[i]);
				if (checkVvd5[i] != null)
					model.setCheckVvd5(checkVvd5[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSpaceControlInquiryConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSpaceControlInquiryConditionVO[]
	 */
	public SearchSpaceControlInquiryConditionVO[] getSearchSpaceControlInquiryConditionVOs(){
		SearchSpaceControlInquiryConditionVO[] vos = (SearchSpaceControlInquiryConditionVO[])models.toArray(new SearchSpaceControlInquiryConditionVO[models.size()]);
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
		this.subtrade5 = this.subtrade5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subtrade4 = this.subtrade4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subtrade3 = this.subtrade3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subtrade2 = this.subtrade2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subtrade1 = this.subtrade1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trade = this.trade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.salesOffice = this.salesOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkview = this.chkview .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.week1 = this.week1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.week2 = this.week2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duration = this.duration .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duration2From = this.duration2From .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duration2To = this.duration2To .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.area = this.area .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.year1 = this.year1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.year2 = this.year2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bound = this.bound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq2 = this.rhq2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.type = this.type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.month = this.month .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revMonth = this.revMonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.monFlg = this.monFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.week = this.week .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.office = this.office .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.userOfc = this.userOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrade = this.subTrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oncIpc = this.oncIpc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onlyVvd = this.onlyVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqTxt = this.rhqTxt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqGso = this.rhqGso .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polPod = this.polPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.sDate = this.sDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eDate = this.eDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port = this.port .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioc = this.ioc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.org = this.org .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subOffice = this.subOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlane1 = this.rlane1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlane2 = this.rlane2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlane3 = this.rlane3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlane4 = this.rlane4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlane5 = this.rlane5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkArea1 = this.chkArea1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkArea2 = this.chkArea2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkArea3 = this.chkArea3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkArea4 = this.chkArea4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkArea5 = this.chkArea5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkDest2 = this.checkDest2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkDest3 = this.checkDest3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkDest4 = this.checkDest4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkDest5 = this.checkDest5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contents = this.contents .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");


		this.portDiv = this.portDiv.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlane6 = this.rlane6.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subtrade6 = this.subtrade6.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viewDiv = this.viewDiv.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.trade7 = this.trade7.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlane7 = this.rlane7.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subtrade7 = this.subtrade7.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bound1 = this.bound1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq1 = this.rhq1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.area1 = this.area1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.salesOffice1 = this.salesOffice1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDt = this.fromDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duration1 = this.duration1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCd = this.srepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.subtrade11 = this.subtrade11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlane11 = this.rlane11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viewType11 = this.viewType11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkSmp = this.checkSmp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.acct = this.acct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpAcct = this.grpAcct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctClss = this.acctClss .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.vvd1 = this.vvd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd2 = this.vvd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.checkIpiLocal = this.checkIpiLocal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkDestCtrl = this.checkDestCtrl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkIpiLocal2 = this.checkIpiLocal2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkDestCtrl2 = this.checkDestCtrl2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loginUserId = this.loginUserId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.checkSector2 = this.checkSector2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkSector5 = this.checkSector5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.checkVvd1 = this.checkVvd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkVvd2 = this.checkVvd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkVvd3 = this.checkVvd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkVvd4 = this.checkVvd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkVvd5 = this.checkVvd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
