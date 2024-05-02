/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : COACommonDBDAO.java
 *@FileTitle : COA업무 공틍 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-09-18
 *@LastModifier : eunju park
 *@LastVersion : 1.0
 * 2006-08-25 eunju park
 * 1.0 최초 생성
 * 2008.05.29 전성진 CSR No.N200805200001
 * 					 물류 report Control Office 기준 변경으로 searchLogisticsOfficeCode를 변경함.
 * 2008.07.01 PEJ Office 조직 변경으로 인해 소스 변경
 * 2007-07-04 전성진 CSR No.N200807030011
 * 						- searchOtrCommLocList 추가 : Agency Other Commission에서 사용하는 Location
 * 2008.07.08 김태윤 CSR No.N200807077840
 *                   물류 report Control Office 기준 변경으로 searchLogisticsRhqCode
 *                                                        ,searchLogisticsOfficeCode를 변경함.
 * 2008.07.09 박칠서 N200807070014 searchSubOFCList 변경
 * 2008.07.09 박은주 N200807077840 searchSubOFCList 변경
 *                  NYCNA를 4Level 선택시 콤보에 보여 주도록 수정
 * 2008.07.23 전성진 CSR No.N200807230006 [117]
 *						- 조회조건 및 저장 기능 추가 
 *						- searchRevLaneList 조건에 sub trade 추가되게 쿼리 변경
 *						- searchSMUSubTradeList 추가 IP 제외됨.  
 * 2008.08.12 전윤주 CSR No.N200807170013 [115]
 *                      - searchPodEccList 추가 
 *                      - EMU POD 조회 조건 (Port가 있는 ECC만)                 
 * 2008.09.05 전성진 CSR No.N200809030003
 * 						- searchSubOFCList에 TORBS관련 예외처리함.              
 * 2008.09.05 전성진 CSR No.N200808228856
 * 						- Special Type Size 관련 변경           
 * 2008.10.01 전성진 CSR No.N200809059194 
 * 					 	- searchRLaneList4 생성 : IP 제외한 Rlane 생성
 * 2008.12.23 김태윤 CSR No.N200812230006 COA Office 월별관리 후 table 수정 (COA_OFC_LVL), coa_mon_vvd 와 조건 추가
 * 2009.02.02 임옥영 N200901190016   COA_조직개편 관련 기능 수정searchSubOFCList에 월관리 추가
 * 2009.02.04 임옥영 N200901190016   COA_조직개편 관련 기능 수정, 2009년 Area영역에 RHQ모두 추가
 * 2009.02.12 임옥영 N200902110080   SINWA 실적 조회 권한 관련
 * 2009.02 박은주 Project : Lane Simulation System 개선 요청
 * 2009.03.24 임옥영 N200903120170 Key Accont Group 추가 
 * 2009.03.25 임옥영 소스품질 searchMaxSimNo(String,String) 사용하지 않는 지역변수 처리
 * 2009.03.26 박은주 : 품질검토결과 수정사항 반영  
 * 2009.05.25 임옥영 N200905110236 Named Biz Customer 5145, 5698, 5764라인(nmd_cust_flg IS NULL OR nmd_cust_flg = 'N' 조건추가)                
 * 2009.06.01 박은주 CSR No.R200905280002 품질검토결과 수정사항 반영           
 * 2009.07.31 장영석 : 사용하지 않는 테이블(COA_IF_MGMT)삭제   
 * 2009.07.31 장영석 : checkBKGNo메서드?coa_rgst_BKGg_info테이블에 bkg_no_split필드가 없기 때문에 필드 삭제
 * 2009.09.07 박은주 : 쿼리 변경 [searchSubOFCList,searchTradeList]  
 * 2009.10.13 장영석 : 사용하지 않는 searchOFCList(H04) 메서드 삭제     
 * 2009.10.14 장영석 : 사용하지않는 searchActivityByYrmon(H08) 메서드 삭제
 * 2009.12.04 장영석 : searchActivityByKPI메서드 에서 searchLogisticsKpiList로 대체 되었기에 삭제
 * 2009.12.24 최인경 : Avg UC화면 필요함 sub group,coa code추가
 * 2010.02.04 임옥영 :품질검토결과 반영(주석)
 * 2010.02.05 임옥영 :품질검토결과 반영(사용하지 않는 지역변수 주석처리 rs)
                      searchLocationToOffice(지역변수는 소문자로 Result -> result)
 * 2010.02.12 임옥영  소스품질검토 결과 반영(2월 2주차)
 * 										Line No. 2906 :  : shall be matched with type of parameter(FMDATE|TODATE|TRADE|RLANE  vs String)
 *                                     Line No. 2945 :  : shall be matched with type of parameter(TRADE|RLANE|FMDATE|TODATE vs String)
 * 2010.02.19 임옥영 소스품질검토 결과 반영 Line No. 2908 :  : shall be matched with name of parameter(FMDATE|TODATE|TRADE|RLANE vs code)
 * 2010.09.01  김기종 CSR No. CHM-201005370-01 Inquiry by customized condition 기능 개선		
 * 2010.09.27 장영석 CHM-201005937 Inquiry by customized condition 기능추가																		 Line No. 2947 :  : shall be matched with name of parameter(TRADE|RLANE|FMDATE|TODATE vs code)
 * 2011.01.26 최윤성 [CHM-201108537-01] searchVslOwnerList 기능 추가
 * 2011.06.22 김민아 [CHM-201111640-01] searchMdmReeferCoreAcctList 기능 추가
 * 2011.07.20 최성민 [CHM-201112295-01] [COA] 내부거래단가 조건추가 : Actual Lane 정보
 * 2012.03.22 김종준 [CHM-201217091-01] EMU 관련 로직 보완/변경 검토 요청의 건 ESM_COA_0016화면에서 사용하는O/D 코드 searchCntrOrgDestCdList 추가 
 * 2012.08.29 이석준[CHM-201219872]   Inquiry by customized condition_MT Pick up Location 등 메뉴 추가
 * 2012.10.23 최성민 [CHM-201220825] [COA] CAM 조직 변경에 따른 COA 반영
 * 2012.10.25 김보배 [CHM-201220395] [COA] Add-on Tariff Management 개선 프로젝트
 * 2013.01.16 서미진 [CHM-201322375] Period 조회시, 주차만 셋팅하여 default 값에 년도와 주차 pair가 맞지 않는 부분 수정 
 * 2014.04.10 최성민 [CHM-201429154] Target VVD BSA Flag 처리 후 BSA 시스템 연동 로직 변경 요청
 * 2014.06.19 최덕우 [CHM-201430638] [COA] BU Other (계선/대선) 항목의 각 계정별 분리 반영 위한 CSR 
 * 2014.08.13 박은주 [CHM-201431516]  Logistics PFMC Report - KPI 3 추가 및 화면변경 요청사항
 =========================================================*/
package com.hanjin.apps.alps.esm.coa.common.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.coa.common.event.CodeInfo;
import com.hanjin.apps.alps.esm.coa.common.vo.BkgSokeupVO;
import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.common.vo.SearchSimNoDescVO;
import com.hanjin.apps.alps.esm.coa.common.vo.WeekCopyVO;
import com.hanjin.apps.alps.esm.coa.lanesimulation.basic.LaneSimulationBCImpl;
import com.hanjin.apps.alps.esm.coa.stdunitcost.costsetup.integration.CostSetUpDBDAOChkCostSetupRSQL;
import com.hanjin.apps.alps.esm.coa.stdunitcost.costsetup.integration.CostSetUpDBDAOInsertVslLayupTotCSQL;
import com.hanjin.apps.alps.esm.coa.stdunitcost.costsetup.integration.CostSetUpDBDAORemoveManualCostStupCopyDSQL;
import com.hanjin.apps.alps.esm.coa.stdunitcost.costsetup.integration.CostSetUpDBDAOUpdateVslLayupTotUSQL;
import com.hanjin.apps.alps.esm.coa.stdunitcost.costsetup.vo.VesselLayupVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.CoaUtCostCreStsVO;

/**
 * ENIS-COA에 대한 DB 처리를 담당<br> - ENIS-COA Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author eunju park 
 * @see LaneSimulationBCImpl 참조
 * @since J2EE 1.4
 */
public class CommonDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3183123339435585247L;

	/**
	 * 날짜의 Max Simulation No를 조회한다. <br>
	 * coa_sim_info
	 * 
	 * @return String 처리 결과
	 * @throws DAOException
	 */
	public String searchMaxSimNo() throws DAOException {
		String rtnResult = "";
		DBRowSet dbRowSet = null;
		
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
				velParam.put("methodname", "searchMaxSimNo");
				
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
			if (dbRowSet != null) {
				while (dbRowSet.next()) {
					rtnResult = dbRowSet.getString("sim_no");
				}
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return rtnResult;		
	}

	
	/**
	 * S.Lane의 목록을 가져온다.<br>
	 * COA_SIM_INFO, COA_LANE_RGST
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchSimSLaneList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
			velParam.put("methodname", "searchSimSLaneList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
			} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
		
	}
	/**
	 * S.Lane의 목록을 가져온다.<br>
	 * MDM_VSL_SVC_LANE
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchSVCLaneList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
			velParam.put("methodname", "searchSVCLaneList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
			} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return dRs;
		
	}

	/**
	 * service lane의 정보를 가져온다.<br>
	 * MDM_REV_LANE
	 * 
	 * @param trd_cd
	 *            String
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchSLaneList(String trd_cd) throws DAOException {		
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter

		try {
			if(trd_cd != null){
				param.put("trd_cd"    ,trd_cd);
				velParam.put("methodname", "searchSLaneList");
			}
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return dRs;
	}

	/**
	 * Trade콤보의 목록을 가져온다.<br>
	 * MDM_TRADE
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchTradeList() throws DAOException {
		
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체		
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
				velParam.put("methodname", "searchTradeList");
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return dRs;		
	}	
		
	/**
	 * Sub Trade 정보를 가져온다.<br>
	 * MDM_SUB_TRD
	 * 
	 * @param trd_cd
	 *            String
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchSubTradeList(String trd_cd) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
		
				param.put("trd_cd" ,trd_cd);
				velParam.put("methodname", "searchSubTradeList");
	
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return dRs;
	}

	
	/**
	 * SMU Sub Trade 정보를 가져온다.<br>
	 * MDM_SUB_TRD
	 * 
	 * @param trd_cd
	 *            String
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchSMUSubTradeList(String trd_cd) throws DAOException {		
		
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
			if(trd_cd != null){
				param.put("trd_cd"    ,trd_cd);
				velParam.put("methodname", "searchSMUSubTradeList");
			}
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return dRs;
	}
	
	
	/**
	 * COA_VSL_SUB_TRADE 목록을 가져온다.<br>
	 * 
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchVSLSubTradeList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter

		try {
			velParam.put("methodname", "searchVSLSubTradeList");	
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
	}

	/**
	 * revenue lane의 정보를 가져온다.<br>
	 * COA_LANE_RGST
	 * 
	 * @param trd_cd
	 *            String
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchRevLaneList(String trd_cd) throws DAOException {
		
		String[] sTrd = null;		
		
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체

		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		String strTrdCd = "";
		String strSubTrdCd = "";		
		sTrd = trd_cd.split(":", -1);
		
		strTrdCd = sTrd[0];
		
		if (sTrd.length > 1) {
			strSubTrdCd = sTrd[1];
		} else {
			strSubTrdCd = "";
		}		
		try {
			if(trd_cd != null){
				param.put("str_trd_cd"    ,strTrdCd);
				param.put("str_sub_trd_cd",strSubTrdCd);
				velParam.put("methodname", "searchRevLaneList");
			}
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return dRs;
	}



	/**
	 * revenue lane의 정보를 가져온다.<br>
	 * COA_LANE_RGST
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchRevLaneList2() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체		
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
			velParam.put("methodname", "searchRevLaneList2");			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return dRs;		
	}
	
	/**
	 * revenue lane의 정보를 가져온다.<br>
	 * COA_LANE_RGST
	 * 
	 * @param  String trd_cd
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchRLaneList(String trd_cd) throws DAOException {
		
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체		
		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
				param.put("trd_cd"    ,trd_cd);
				velParam.put("methodname", "searchRLaneList");
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return dRs;		
	}
	
	/**
	 * IP를 제외한 revenue lane의 정보를 가져온다.<br>
	 * COA_LANE_RGST
	 * 
	 * @param trd_cd
	 *            String
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchRLaneList4(String trd_cd) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체		
		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
				param.put("trd_cd"    ,trd_cd);
				velParam.put("methodname", "searchRLaneList4");
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return dRs;		
	}
	
	/**
	 * Port Class 목록을 조회한다..<br>
	 * COA_VSL_RGST
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchPortClassList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		

		try {
			velParam.put("methodname", "searchPortClassList");			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
	}

	/**
	 * VESSEL CAPA 목록을 조회한다..<br>
	 * COA_VSL_RGST
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchVslCapaList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체		
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
				velParam.put("methodname", "searchVslCapaList");
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return dRs;		
	}	
	

	/**
	 * Vessel콤보의 목록을 가져온다.<br>
	 * COA_VSL_RGST
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchVesselList() throws DAOException {
		
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체		
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
				velParam.put("methodname", "searchVesselList");
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return dRs;		
	}	
	
	/**
	 * Vessel콤보의 목록을 가져온다.<br>
	 * COA_VSL_RGST
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchSimVesselList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter		
		
		try {
			velParam.put("methodname", "searchSimVesselList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return dRs;
	}
	
	/**
	 * Vessel Class 콤보의 목록을 가져온다.<br>
	 * COA_VSL_RGST
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchSimVslClssList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter		
		
		try {
			velParam.put("methodname", "searchSimVslClssList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
	}

	/**
	 * Vessel콤보의 목록을 가져온다.<br>
	 * COA_VSL_RGST
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchOwnVesselList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter		
		
		try {
			velParam.put("methodname", "searchOwnVesselList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return dRs;
	}

	/**
	 * Vessel콤보의 목록을 가져온다.<br>
	 * COA_VSL_RGST
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchHjsVesselList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter		
		
		try {
			velParam.put("methodname", "searchHjsVesselList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return dRs;
	}

	/**
	 * Vessel콤보의 목록을 가져온다.<br>
	 * COA_VSL_RGST
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchChtVesselList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter			

		try {
			velParam.put("methodname", "searchChtVesselList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
			} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
	}

	/**
	 * Simulation에서 사용한 vessel 목록을 가져온다.<br>
	 * COA_SIM_VSL_SET_INFO
	 * 
	 * @param code
	 *            String
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchSimVessel(String code) throws DAOException {
		
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		try {
				String[] codevalue = code.split("[|]");
				param.put("sim_dt"    ,codevalue[0].trim());
				param.put("sim_no"    ,codevalue[1].trim());
				velParam.put("methodname", "searchSimVessel");
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return dRs;
	}
    
	/**
	 * 화물변동비 항목을 가져온다.<br>
	 * COA_MN_GRP_COST, COA_SUB_GRP_COST
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchSIMCostItem() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter

		try {
			velParam.put("methodname", "searchSIMCostItem");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return dRs;
	}
	/**
	 * OP 계정코드를 조회한다.<br>
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchSimOpAcct() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter		
		
		try {
			velParam.put("methodname", "searchSimOpAcct");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return dRs;
	}

	/**
	 * COA Main Group 항목을 가져온다.<br>
	 * COA_MN_GRP_COST
	 * 
	 * @param code
	 *            String
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */	
	public DBRowSet searchMNGRPCostList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter	

		try {
			param.put("code", code);
			velParam.put("methodname", "searchMNGRPCostList");
			velParam.put("code", code);
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
			} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return dRs;
	}

	/**
	 * COA Sub Group 항목을 가져온다.<br>
	 * COA_SUB_GRP_COST
	 * 
	 * @param code
	 *            String
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchSubGRPCostList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter	

		try {
			param.put("code", code);
			velParam.put("code", code);
			velParam.put("methodname", "searchSubGRPCostList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
			} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return dRs;
	}

	//
	/**
	 * 현재주보다 작은 주를 반환한다.<br>
	 * COA_WK_PRD
	 * 
	 * @param year
	 *            String
	 * @param week
	 *            String
	 * @return String (06/53)
	 * @throws DAOException
	 */
	public String searchPreWeek(String year, String week) throws DAOException {
		
		String result = "";
		DBRowSet dbRowSet = null;
		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
			
		try {
				param.put("year"    ,year);
				param.put("week"    ,week);
				velParam.put("methodname", "searchPreWeek");
				
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
			if (dbRowSet != null) {
				while (dbRowSet.next()) {
					result = dbRowSet.getString(1);
				}
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return result;		
	}

	/**
	 * 검색 조건에 맞는 DatePriod을 가져온다.<br> - 입력파라메터의 경우의 수 1. Year, Month 2. Year, Week 3. Year, Month, Week : Week가 우선권을
	 * 가진다. 4. Year, FromMonth, ToMonth 5. Year, FromWeek, ToWeek 6. Year, FromMonth, ToMonth, FromWeek, ToWeek
	 * 
	 * @param SearchConditionVO vo
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchDatePeriod(SearchConditionVO vo) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		String year = vo.getFYear();
		String month = vo.getFYearmonth();
		String week = vo.getFYearweek();
		String frmweek = vo.getFFmWk();
		String frmmonth = vo.getFFmMon();
		String toweek = vo.getFToWk();
		String tomonth = vo.getFToMon();
		String gubun ="";
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter	
		
		try {

			year = (year != null) ? year : "";
			month = (month != null) ? month : "";
			week = (week != null) ? week : "";
			frmweek = (frmweek != null) ? frmweek : "";
			frmmonth = (frmmonth != null) ? frmmonth : "";
			toweek = (toweek != null) ? toweek : "";
			tomonth = (tomonth != null) ? tomonth : "";
			gubun ="";
			if(vo != null){
			 
				if(!year.equals("") && !month.equals("") && !week.equals("")) {
				gubun = "1";
			}else if (!year.equals("") && !month.equals("")) {
				gubun = "2";
			} else if (!year.equals("") && !week.equals("")) {
				gubun = "3";
			}
			 if(!year.equals("") && !frmmonth.equals("") && !tomonth.equals("") && !frmweek.equals("") && !toweek.equals("")) {
				gubun = "4";
			}else if (!year.equals("") && !frmmonth.equals("") && !tomonth.equals("")) {
				gubun ="5";
			}else if(!year.equals("") && !frmweek.equals("") && !toweek.equals("")) {				
				gubun = "6";
			}
			param.put("year"    ,year);
			param.put("month"    ,month);
			param.put("week"    ,week);
			param.put("frmweek"    ,frmweek);
			param.put("frmmonth"    ,frmmonth);
			param.put("toweek"    ,toweek);
			param.put("tomonth"    ,tomonth);
			velParam.put("methodname", "searchDatePeriod");				
			velParam.put("gubun", gubun);
			}		
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
		
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dRs;				
	}

	/**  
	 * Rcc 의 목록을 가져온다.<br>
	 * view : coa_location_v(mdm_location, mdm_eq_orz_cht)
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchRccList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter	

		try { 
			 velParam.put("methodname", "searchRccList");						
			 dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
		
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return dRs;

	}

	/**
	 * LCC의 목록을 가져온다.<br>
	 * view : coa_location_v(mdm_location, mdm_eq_orz_cht)
	 * 
	 * @param code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchLccList(String code) throws DAOException {		
		
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter		
		
			try {
				if(code != null){
					velParam.put("methodname", "searchLccList");
					velParam.put("code", code);
					param.put("code"    ,code);
				}
				
				dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());			
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}

			return dRs;
		}

	/**
	 * ECC의 목록을 가져온다.<br>
	 * view : coa_location_v(mdm_location, mdm_eq_orz_cht)
	 * 
	 * @param code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchEccList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		try {
			
			if(!code.equals("")){
				String[] value = code.split("[|]");
				param.put("rcc_cd"    ,value[0]);
				param.put("lcc_cd"    ,value[1]);
			}
			velParam.put("code"    ,code);
			velParam.put("methodname", "searchEccList");
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return dRs;
	}
	
	/**
	 * EMU Simulated Cost 계산시 사용 되는 POD ECC의 목록을 가져온다.(Port ECC만)<br>
	 * mdm_location, mdm_eq_orz_cht	  
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchPodEccList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
			velParam.put("methodname", "searchPodEccList");	
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return dRs;
	}

	/**
	 * SCC의 목록을 가져온다.<br>
	 * view : coa_location_v(mdm_location, mdm_eq_orz_cht)
	 * 
	 * @param code
	 *            String
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchSccList(String code) throws DAOException {
		
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter		
			
			try {
				if(code != null){
					param.put("code"    ,code);
					velParam.put("methodname", "searchSccList");
				}
				
				dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());			
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}

			return dRs;
		}

	/**
	 * Location Code 목록을 가져온다.<br>
	 * view : coa_location_v(mdm_location, mdm_eq_orz_cht)
	 * 
	 * @param code
	 *            String
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchLocList(String code) throws DAOException {
		
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity paramete
		String[] value = code.split("[|]");
		
		try {
			param.put("param1"    ,value[1].toUpperCase());
			velParam.put("param0"    ,value[0].toUpperCase());		
			velParam.put("methodname", "searchLocList");
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return dRs;
	}

	/**
	 * 지역본부 단위의 Office Code 목록을 조회한다..<br>
	 * MDM_ORGANIZATION
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchOFCHQList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity paramete

		try {
			velParam.put("methodname", "searchOFCHQList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
			} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return dRs;
	}

	/**
	 * 컨테이너 Type Size 목록을 조회한다..<br>
	 * COA_SPCL_REPO_CNTR_RGST
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchTpSzList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		try {
			velParam.put("methodname", "searchTpSzList");			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam); 			

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return dRs;
	}

	/**
	 * 컨테이너 Reposition Flag가 Y인 Type Size 목록을 조회한다..<br>
	 * COA_SPCL_REPO_CNTR_RGST [EQ Reposition Contribution 메뉴에서 사용하는 Type size]
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchEQRepoTpSzList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		try {
			velParam.put("methodname", "searchEQRepoTpSzList");			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam); 			

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
	}

	/**
	 * Currency 목록을 조회한다..<br>
	 * MDM_CURRENCY
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchCurrencyList() throws DAOException {
		
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체		
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
				velParam.put("methodname", "searchCurrencyList");
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return dRs;		
	}	

	/**
	 * Commodity List 목록을 조회한다..<br>
	 * MDM_REP_CMDT
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchRepCMDTList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter

		try {
			velParam.put("methodname", "searchRepCMDTList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return dRs;
	}

	/**
	 * 공통코드에서 목록을 조회한다..<br>
	 * COM_INTG_CD_DTL
	 * 
	 * @param code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchCommonCodeList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity paramete
		
		try {
			
			param.put("code"    ,code);
			velParam.put("methodname", "searchCommonCodeList");
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
		
	} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return dRs;
	}

	/**
	 * Report Item Infomation 목록을 조회한다..<br>
	 * COA_RPT_ITM_INFO_MST
	 * 
	 * @param code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchReportItem(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter		
			
			try {
				if(code != null){
					param.put("code"    ,code);
					velParam.put("methodname", "searchReportItem");
				}
				
				dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());			
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}

			return dRs;
		}

	/**
	 * Regional Headquarter: RHQ 목록을 조회한다..<br>
	 * MDM
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchRHQList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter	

		try { 
			velParam.put("methodname", "searchRHQList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
	}

	/**
	 * Report Authority 목록을 조회한다..<br>
	 * COA_RPT_AUTH_MGMT, COM_INTG_CD_DTL
	 * 
	 * @param code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchRPTAuthList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter	
		Map<String, Object> param = new HashMap<String, Object>();//velocity parameter	

		try {
			String[] ofc_lvl = code.split("[|]");
			param.put("ofclvl0", ofc_lvl[0]);
			param.put("ofclvl1", ofc_lvl[1]);
			velParam.put("methodname", "searchRPTAuthList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return dRs;
	}
	
	/**
	 * 목록을 조회한다..<br>
	 * COA_SVC_TRNS_PRC
	 * 
	 * @param code
	 *            String
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchActivityByYrmon(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter		

		try {
			if(code != null){
				param.put("code"    ,code);
				velParam.put("code", code);
				velParam.put("methodname", "searchActivityByYrmon");
				
			}
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dRs;
	}

	/**
	 * office Level List 목록을 조회한다..<br>
	 * COA_RPT_AUTH_MGMT
	 * 
	 * @param code
	 *            (office level)
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchOFCLevelList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter		

		try {
			if(code != null){
				param.put("code"    ,code);
				velParam.put("methodname", "searchOFCLevelList");
			}
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return dRs;
	}

	/**
	 * 선택한 office Level에 해당하는 office code목록을 조회한다..<br>
	 * coa_ofc_lvl
	 * 
	 * @param code (usr_ofc_cd|usr_ofc_lvl|selected ofc_lvl|cost_yrmon)
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchSubOFCList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter		
			
			try {
				if(code != null){
					
					String[] ofc = code.split("[|]");//0:usr_ofc_cd, 1:usr_ofc_lvl, 2:selected ofc_lvl, 3:cost_yrmon
					
					String usr_ofc_cd = ofc[0];
					String usr_ofc_lvl = ofc[1];
					String sel_ofc_lvl = ofc[2];
					String cost_yr = ofc[3];
					String cost_mon = ofc[4];
					
					param.put("usr_ofc_cd"    ,usr_ofc_cd);
					param.put("usr_ofc_lvl"    ,usr_ofc_lvl);
					param.put("sel_ofc_lvl"    ,sel_ofc_lvl);
					param.put("cost_yr"    ,cost_yr);
					param.put("cost_mon"    ,cost_mon);
					
					velParam.put("methodname", "searchSubOFCList");
					velParam.put("usr_ofc_cd", usr_ofc_cd);
					velParam.put("usr_ofc_lvl", usr_ofc_lvl);
					velParam.put("cost_yr", Integer.parseInt(cost_yr));
					velParam.put("cost_mon", Integer.parseInt(cost_yr));
				}
				
				dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());			
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}

			return dRs;
		}

	/**
	 * VVD에 해당하는 etd date를 리턴한다.<br>
	 * vsk_vsl_port_skd
	 * 
	 * @param String vsl_cd
	 * @param String skd_voy_no
	 * @param String skd_dir_cd
	 * @return String 처리 결과
	 * @throws DAOException
	 */
	public String searchFirstEtd(String vsl_cd, String skd_voy_no, String skd_dir_cd) throws DAOException {
		String result = "";
		DBRowSet dbRowSet = null;
		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter

		try {
				param.put("vsl_cd"    ,vsl_cd);
				param.put("skd_voy_no"    ,skd_voy_no);
				param.put("skd_dir_cd"    ,skd_dir_cd);
				velParam.put("methodname", "searchFirstEtd");				
			
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
			if (dbRowSet != null) {
				while (dbRowSet.next()) {
					result = dbRowSet.getString("etd_dt");
				}
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return result;
	}

	/**
	 * 전주를 구한다.<br>
	 * 
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public String searchPrevWkPrd() throws DAOException {
		String result = "";
		DBRowSet dbRowSet = null;

		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
				velParam.put("methodname", "searchPrevWkPrd");
				
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
			if (dbRowSet != null) {
				while (dbRowSet.next()) {
					result = dbRowSet.getString("cost_wk");
				}
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return result;		
	}
	
	/**
	 * office code에 해당하는 Level를 리턴한다.<br>
	 * COA_GET_OFC_LEVEL
	 * 
	 * @param ofc_cd
	 * @return String 처리 결과
	 * @throws DAOException
	 */
	public String searchOFCLevel(String ofc_cd) throws DAOException {
		String result = "";
		DBRowSet dbRowSet = null;
		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
				param.put("ofc_cd"    ,ofc_cd);
				velParam.put("methodname", "searchOFCLevel");
				
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
			if (dbRowSet != null) {
				while (dbRowSet.next()) {
					result = dbRowSet.getString("ofc_level");
				}
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return result;		
	}
		
	/**
	 * Parent가 HQ Level이고 해당 office가 HQ 직속이라면(ofc kind : 2) HQ의 level 부여됨  <br>
	 * 특정조건에 만족하는 경우 office code에 변경하여 반환한다.
	 * (HQ 산하의 조직이면서 Area가 아닌경우 HQ레벨의 office code를 리턴한다.)
	 * 
	 * @param ofc_cd
	 * @return String 처리 결과
	 * @throws DAOException
	 */
	public String searchChgOffice(String ofc_cd) throws DAOException {
		String result = "";
		DBRowSet dbRowSet = null;
		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
				param.put("ofc_cd"    ,ofc_cd);
				velParam.put("methodname", "searchChgOffice");
				
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
			if (dbRowSet != null) {
				while (dbRowSet.next()) {
					result = dbRowSet.getString("prnt_ofc_cd");
				}
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return result;		
	}

	/**
	 * Booking Number 유무를 확인.<br>
	 * 
	 * @param bkg_no String
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet checkBKGNo(String bkg_no) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter		
			
			try {
				if(!bkg_no.equals("")){
					param.put("bkgno"    ,bkg_no);
					velParam.put("methodname", "checkBKGNo");
				}
				
				dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());			
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}

			return dRs;
		}

	/**
	 * Location Code 유무를 확인.<br>
	 * 
	 * @param loc_cd String
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet checkLocationCode(String loc_cd) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter		
			
			try {
				if(!loc_cd.equals("")){
					param.put("loccd"    ,loc_cd);
					velParam.put("methodname", "checkLocationCode");
				}
				
				dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());			
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}

			return dRs;
		}

	/**
	 * Vessel Code 유무를 확인.<br>
	 * 
	 * @param vsl_cd String
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet checkVesselCode(String vsl_cd) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter		
			
			try {
				if(!vsl_cd.equals("")){
					param.put("vslcd"    ,vsl_cd);
					velParam.put("methodname", "checkVesselCode");
				}
				
				dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());			
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}

			return dRs;
		}

	/**
	 * VVD Code 유무를 확인.<br>
	 * 
	 * @param vsl_cd
	 * @param skd_voy_no
	 * @param dir_cd
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet checkVVDCode(String vsl_cd, String skd_voy_no, String dir_cd) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter		
			
			try {
				if(!vsl_cd.equals("")){
					param.put("vslcd"       ,vsl_cd);
					param.put("skdvoyno"    ,skd_voy_no);
					param.put("skddircd"    ,dir_cd);
					velParam.put("methodname", "checkVVDCode");
				}
				
				dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());			
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}

			return dRs;
		}

	/**
	 * Office Code 유무를 확인.<br>
	 * 
	 * @param ofc_cd
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet checkOfficeCode(String ofc_cd) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter		
			
			try {
				if(!ofc_cd.equals("")){
					param.put("ofc_cd"    ,ofc_cd);
					velParam.put("methodname", "checkOfficeCode");
				}
				
				dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());			
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}

			return dRs;
		}

	/**
	 * Revenue Lane Code 유무를 확인.<br>
	 * 
	 * @param rlane_cd
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet checkRevLaneCode(String rlane_cd) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter		
			
			try {
				if(!rlane_cd.equals("")){
					param.put("rlanecd"    ,rlane_cd);
					velParam.put("methodname", "checkRevLaneCode");
				}
				
				dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());			
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}

			return dRs;
		}

	

	/**
	 * Port or Node Code 유무를 확인.<br>
	 * 
	 * @param tml_cd String
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet checkNodeCode(String tml_cd) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter		

		try {
			if(!tml_cd.equals("")){
				param.put("tmnlcd"    ,tml_cd);
				velParam.put("methodname", "checkNodeCode");
			}
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		

		return dRs;
	}

	/**
	 * Service Lane Code 유무를 확인.<br>
	 * 
	 * @param slane_cd
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet checkSLaneCode(String slane_cd) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter		


		try {
			if(!slane_cd.equals("")){
				param.put("slancd"    ,slane_cd);
				velParam.put("methodname", "checkSLaneCode");
			}
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);

		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		

		return dRs;
	}

	/**
	 * Direction 항목을 세팅한다.<br>
	 * 
	 * @return Collection
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public Collection setDirList() throws DAOException {
		Collection codeList = new ArrayList();

		try {
			codeList.add(new CodeInfo("E", "E"));
			codeList.add(new CodeInfo("W", "W"));
			codeList.add(new CodeInfo("S", "S"));
			codeList.add(new CodeInfo("N", "N"));

			log.debug(" setDirList() END ");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return codeList;
	}

	/**
	 * Interport/Ocean 항목을 세팅한다.<br>
	 * 
	 * @return Collection
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public Collection setIOCList() throws DAOException {
		Collection codeList = new ArrayList();

		try {
			codeList.add(new CodeInfo("I", "I"));
			codeList.add(new CodeInfo("O", "O"));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return codeList;
	}

	/**
	 * Vessel lane type 항목을 세팅한다.<br>
	 * 
	 * @return Collection
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public Collection setLaneTPList() throws DAOException {
		Collection codeList = new ArrayList();

		try {
			codeList.add(new CodeInfo("JO", "JO"));
			codeList.add(new CodeInfo("SC", "SC"));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return codeList;
	}

	/**
	 * Owner Terminal List 목록을 조회한다..<br>
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchOwnTMLList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter		
		
		try {
			velParam.put("methodname", "searchOwnTMLList");
		dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return dRs;
	}

	/**
	 * RA Main Group 항목을 가져온다.<br>
	 * com_intg_cd_dtl
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchRAMainGroupList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
			velParam.put("methodname", "searchRAMainGroupList");			
		dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
			} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return dRs;
	}

	/**
	 * RA Sub Group 항목을 가져온다.<br>
	 * com_intg_cd_dtl
	 * 
	 * @param  String code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchRASubGroupList(String code) throws DAOException {

		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
			param.put("code", code);
			velParam.put("code", code);
			velParam.put("methodname", "searchRASubGroupList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return dRs;
	}

	/**
	 * Simulation number의 설명을 조회한다.
	 * 
	 * @param vo
	 * @return List<SearchSimNoDescVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSimNoDescVO> searchSimNoDesc(SearchConditionVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSimNoDescVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();				
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchSimNoDescRSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSimNoDescVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;		
	}
	
	/**
	 * Simulation dept code를 조회한다.
	 * 
	 * @param code
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchSimDeptList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
			if(code != null){
				param.put("code"    ,code);
			}			
			velParam.put("methodname", "searchSimDeptList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);				
				
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return dRs;
	}
	
	/**
	 * Simulation number의 설명을 조회한다.
	 * 
	 * @param code
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchSimList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		String[] p_code = (code+" ").split("[|]");	
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
			if(code != null){
				param.put("slan_cd"    ,p_code[0]);
				param.put("sim_dept_cd"    ,p_code[1].trim());
				velParam.put("methodname", "searchSimList");
			}			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return dRs;
	}	

    /**
     * Step2 P<br>
     * P/F SKD 의  Yard 정보를 가져올때 사
     * @param  code 
     * @return DBRowSet
     * @throws DAOException
     */
    public DBRowSet searchSimYardList2(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("code", code);
			velParam.put("methodname", "searchSimYardList2");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);		
		} catch (SQLException se) {
        	log.error("SQLException : " + se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error("DAOException : " + de.getMessage(), de);
            throw de;
        } catch (Exception e) {
            log.error("Exception : " + e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        return dRs;
    }

	/**
	 * COA_STND_ACCT에서 비용항목을 가져온다.<br>
	 * 36. Standard Cost Code : StndCost
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchStndCostList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			velParam.put("methodname", "searchStndCostList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());		
		}
		return dRs;
	}

	/**
	 * PRD_COST_ACT_GRP에서 활동그룹항목을 가져온다.<br>
	 * 41. activity group code : actgrp
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchActGrpList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			velParam.put("methodname", "searchActGrpList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return dRs;
	}

	/**
	 * mdm_county에서 국가코드항목을 가져온다.<br>
	 * 41. country group code : cnt
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchCntList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			velParam.put("methodname", "searchCntList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return dRs;
	}

	/**
	 * coa_office_level_v에서 본부코드를 가져온다.<br>
	 * 43. rhq code : rhqCode
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchRhqCode() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			velParam.put("methodname", "searchRhqCode");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return dRs;
	}

	/**
	 * LOC코드의 ECC를 가져온다.<br>
	 * view : coa_location_v(mdm_location, mdm_eq_orz_cht)
	 * 
	 * @param code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchLoc2EccList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("code", code);
			velParam.put("code", code);
			velParam.put("methodname", "searchLoc2EccList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);		
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return dRs;
	}

	/**
	 * Cost Srouce Code를 가져온다..<br>
	 * 45. Cost Source Code : srcCd(stnd_cost_cd)<br>
	 * 
	 * @param code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchCostSourceCodeList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter

		try {
			param.put("code", code);
			velParam.put("code", code);
			velParam.put("methodname", "searchCostSourceCodeList");	
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
			} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return dRs;
	}

	/**
	 * Terminal Triff Detail Codeㄹ를 가져온다<br>
	 * 46. TML Trf Dtl Code : tmlTrfCd <br>
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
//	COA_INTER_TML_IF_MGMT table 삭제에 의한 처리	
	/*
	public DBRowSet searchTerminalTriffDetailcList() throws DAOException {
		Connection con = null; // Connection Interface
		PreparedStatement ps = null; // 정적파싱을 지원하는 SQL Statement
		ResultSet rs = null; // DB ResultSet
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체

		String queryStr = "\n SELECT DISTINCT RPAD(tml_cd, 7, '#') || RPAD(expn_acct_cd, 8, '#') || RPAD(tml_trf_itm_cd, 4, '#') || RPAD(tml_trf_dtl_cd, 4, '#') code"
			+ "\n                , RPAD(tml_cd, 7, '#') || RPAD(expn_acct_cd, 8, '#') || RPAD(tml_trf_itm_cd, 4, '#') || RPAD(tml_trf_dtl_cd, 4, '#') NAME"
			+ "\n            FROM coa_inter_tml_if_mgmt"
			//+ "\n FROM coa_tml_trf_grp"
			+ "\n        ORDER BY RPAD(tml_cd, 7, '#') || RPAD(expn_acct_cd, 8, '#') || RPAD(tml_trf_itm_cd, 4, '#') || RPAD(tml_trf_dtl_cd, 4, '#')"
			;

		try {
			con = getConnection();
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				ps = new LoggableStatement(con, queryStr);
			} else {
				ps = con.prepareStatement(queryStr);
			}

			// Loggable Statement 사용에 의해 추가
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				log.info("\n searchTerminalTriffDetailcList SQL :\n" + ((LoggableStatement) ps).getQueryString());
			} else {
				log.info("\n searchTerminalTriffDetailcList SQL :\n" + queryStr);
			}

			rs = ps.executeQuery();

			// 결과를 DBRowset에 담는다.
			dRs = new DBRowSet();
			dRs.populate(rs);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} finally {
			closeResultSet(rs);
			closeStatement(ps);
			closeConnection(con);
		}
		return dRs;
	}
	*/

	/**
	 * Terminal Code를 가져온다<br>
	 * tmlCd : coa_inter_tml_if_mgmt 테이블의 terminal 코드 <br>
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
//	COA_INTER_TML_IF_MGMT table 삭제에 의한 처리
	/*
	public DBRowSet searchTerminalCodeList() throws DAOException {
		Connection con = null; // Connection Interface
		PreparedStatement ps = null; // 정적파싱을 지원하는 SQL Statement
		ResultSet rs = null; // DB ResultSet
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체

		String queryStr = "\n SELECT DISTINCT tml_cd code " 
				+ "\n       ,tml_cd name "
				+ "\n FROM coa_inter_tml_if_mgmt " 
				+ "\n ORDER BY tml_cd ";
		try {
			con = getConnection();
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				ps = new LoggableStatement(con, queryStr);
			} else {
				ps = con.prepareStatement(queryStr);
			}

			// Loggable Statement 사용에 의해 추가
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				log.info("\n searchTerminalCodecList SQL :\n" + ((LoggableStatement) ps).getQueryString());
			} else {
				log.info("\n searchTerminalCodecList SQL :\n" + queryStr);
			}

			rs = ps.executeQuery();

			// 결과를 DBRowset에 담는다.
			dRs = new DBRowSet();
			dRs.populate(rs);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} finally {
			closeResultSet(rs);
			closeStatement(ps);
			closeConnection(con);
		}
		return dRs;
	}
	*/

	/**
	 * Stndard Cost code를 가져온다..<br>
	 * 50. coaCode<br>
	 * 
	 * @param code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchCoaCodeList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
			
		try {
				param.put("code"    ,code);
				velParam.put("code", code);
				velParam.put("methodname", "searchCoaCodeList");
				
				dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());			
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}

			return dRs;
		}

	/**
	 * 공통코드에서 Lobistics KPI2 항목을 가져온다.<br>
	 * lgsKPI
	 * 
	 * @param code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchLogisticsKpiList(String code) throws DAOException {
		
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		try {
			param.put("code", code);
			velParam.put("code", code);
			velParam.put("methodname", "searchLogisticsKpi2List");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return dRs;
	}
	/**
	 * 공통코드에서 Lobistics KPI1 항목을 가져온다.<br>
	 * lgsKPI
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchLogisticsKpi1List() throws DAOException {
		
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		try {
			velParam.put("methodname", "searchLogisticsKpi1List");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return dRs;
	}
	/**
	 * 공통코드에서 Lobistics KPI3 항목을 가져온다.<br>
	 * lgsKPI
	 * 
	 * @param code 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchLogisticsKpi3List(String code) throws DAOException {
		
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		try {
			param.put("code", code);
			velParam.put("code", code);
			velParam.put("methodname", "searchLogisticsKpi3List");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return dRs;
	}

	
	/**
	 * Cost Srouce Code/Stnd Code를 가져온다..<br>
	 * 58. Cost Srouce Code/Stnd Code<br>
	 * 
	 * @param code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchCostSourceCodeStndCodeList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
			param.put("code", code);
			velParam.put("code", code);
			velParam.put("methodname", "searchCostSourceCodeStndCodeList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
	}

	/**
	 * 컨테이너 Reposition Flag가 Y인 Type Size 목록을 조회한다..<br>
	 * costTableTpsz Cost Table 메뉴에서 사용하는 Type size RD4 ->R4, RD2 -> R2로
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchCostTableCntrTpszList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter

		try {
			velParam.put("methodname", "searchCostTableCntrTpszList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
			} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return dRs;
	}

	/**
	 * key account 항목을 가져온다.<br>
	 * MDM_CUSTOMER
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchKeyAccountList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
			velParam.put("methodname", "searchKeyAccountList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
			} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
	}
	
	/**
	 * logistics 에서 사용하는 RHQ 목록을 조회한다..<br>
	 * LOGISTICT RHQ       : lgsRHQ (logistics 에서 사용하는 RHQ)
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchLogisticsRhqCode() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
			velParam.put("methodname", "searchLogisticsRhqCode");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
			} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
	}
	
	/**
	 * logistics 에서 사용하는 Office 목록을 조회한다..<br>
	 * LOGISTICT RHQ       : lgsOFC (logistics 에서 사용하는 Office)
	 * 
	 * @param code RHQ CODE
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchLogisticsOfficeCode(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		
		try {
			param.put("code", code);
			velParam.put("code", code);
			velParam.put("methodname", "searchLogisticsOfficeCode");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return dRs;
	}	
	
	/**
	 * ofc_cd에 해당하는 본사Team Code를 반환한다
	 * 
	 * @param String ofc_cd
	 * @return String 처리 결과
	 * @throws DAOException
	 */
	public String searchTeamCode(String ofc_cd) throws DAOException {
		
		String result = "";
		DBRowSet dbRowSet = null;
		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
			
		try {
				param.put("ofc_cd"    ,ofc_cd);
				velParam.put("methodname", "searchTeamCode");
				
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
			if (dbRowSet != null) {
				while (dbRowSet.next()) {
					result = dbRowSet.getString("team_code");
				}
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return result;		
	}

	/**
	 * 환율 변환
	 * 
	 * @param cost_yrmon
	 * @param locl_curr_cd
	 * @param lcl_amt
	 * @return usd_amt
	 * @throws DAOException
	 */
	public float getUSDAmt(String cost_yrmon, String locl_curr_cd, float lcl_amt) throws DAOException {
		float result = 0;
		DBRowSet dbRowSet = null;
		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
				param.put("cost_yrmon"    ,cost_yrmon);
				param.put("locl_curr_cd"    ,locl_curr_cd);
				param.put("lcl_amt"    ,lcl_amt);	
				velParam.put("methodname", "getUSDAmt");
			
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
			if (dbRowSet != null) {
				while (dbRowSet.next()) {
					result = dbRowSet.getFloat(1);
				}
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return result;
	}	

	/**
	 * Location Code를 이용해서 Office Code를 반환한다
	 * 
	 * @param loc_cd
	 * @return String 처리 결과
	 * @throws DAOException
	 */
	public String searchLocationToOffice(String loc_cd) throws DAOException {
		//ResultSet rs = null; // DB ResultSet
		String result = "";
		DBRowSet dbRowSet = null;
		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
			param.put("loc_cd"    ,loc_cd);
			velParam.put("methodname", "searchLocationToOffice");
			
		dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
		if (dbRowSet != null) {
			while (dbRowSet.next()) {
				result = dbRowSet.getString(1);
			}
		}
	} catch(SQLException se){
		log.error(se.getMessage(),se);
		throw new DAOException(new ErrorHandler(se).getMessage());			
	} catch(Exception ex){
		log.error(ex.getMessage(),ex);			
		throw new DAOException(new ErrorHandler(ex).getMessage());
	}

	return result;		
}

	
	/**
	 * 컨테이너 Type Size 목록을 조회한다..<br>
	 * COA_SPCL_REPO_CNTR_RGST
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchOriginalCntrTpszList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter		
		
		try {
			velParam.put("methodname", "searchOriginalCntrTpszList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
			} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return dRs;
	}
	
	
	/**
	 * 모든 Office Code를 반환한다.
	 * (Sales Office, Office 1, Office 2를 조회함)
	 * 
	 * @return String 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchAllOfficeCodeList() throws DAOException {
		
		
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체		
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
				velParam.put("methodname", "searchAllOfficeCodeList");
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return dRs;		
	}	
	
	/**
	 * Agency Other Commission이 사용하는 Location Code List를 반환.
	 * 
	 * @return String 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchOtrCommLocList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
			velParam.put("methodname", "searchOtrCommLocList");	
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return dRs;
	}
	
	/**
	 * Agency Other Commission이 사용하는 Location Code List를 반환.
	 * 
	 * @return String 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchCustGrpIdcList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
			velParam.put("methodname", "searchCustGrpIdcList");	
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
	}
	/**
	 * Agency Other Commission이 사용하는 Location Code List를 반환.
	 * 
	 * @return String 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchMltTrdGrpIdcList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
			velParam.put("methodname", "searchMltTrdGrpIdcList");	
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
	}
	/**
	 * Group ID = code인 Key Account List<br>
	 * mdm_customer
	 * 
	 * @param  String code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchKeyAcctInDvlList(String code) throws DAOException {
		String[] keyAcctGrp = null;		
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		String sKeyAcctGrp = "";		
		keyAcctGrp = code.split(":", -1);
		sKeyAcctGrp = keyAcctGrp[0];
		sKeyAcctGrp = sKeyAcctGrp.trim();
		try {
			if(sKeyAcctGrp != null){
				param.put("keyacctgrp"    ,sKeyAcctGrp);
				velParam.put("methodname", "searchKeyAcctInDvlList");
				velParam.put("keyacctgrp", sKeyAcctGrp);
			}
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
	}
	
	/**
	 * Group ID = code인 M/A Account List<br>
	 * mdm_customer
	 * 
	 * @param  String code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchMltTrdInDvlList(String code) throws DAOException {
		String[] keyAcctGrp = null;		
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		String sKeyAcctGrp = "";		
		keyAcctGrp = code.split(":", -1);
		sKeyAcctGrp = keyAcctGrp[0];
		sKeyAcctGrp = sKeyAcctGrp.trim();
		try {
			if(sKeyAcctGrp != null){
				param.put("mlttrdgrp"    ,sKeyAcctGrp);
				velParam.put("methodname", "searchMltTrdInDvlList");
				velParam.put("mlttrdgrp", sKeyAcctGrp);
			}
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
	}
	
	/**
	 * COA CODE ComboList항목을 가져온다.<br>
	 *            
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	
	public DBRowSet searchTotCoaCodeList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		try {
			velParam.put("methodname", "searchTotCoaCodeList");			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
	}
	
	/**
	 * Average SUB GROUP코드항목을 가져온다.<br>
	 * [Operation Fixed Cost , Operation Variable Cost]
	 *         
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchAvgSubGrpList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
				velParam.put("methodname", "searchAvgSubGrpList");			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
    }
	
	/**
	 * Average COA CODE항목을 가져온다.(ESM_COA_0174)<br>
	 * 
	 * @param String code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchAvgCoaCodeList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
			param.put("code"    ,code);
			velParam.put("methodname", "searchAvgCoaCodeList");
			velParam.put("svcGrpCd", code);
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
    }
	
	/**
	 * Loading Port List 항목을 가져온다.(ESM_COA_5113)<br>
	 * 2009.12.18[CHM-200901902] 메소드 추가
	 * 
	 * @param String code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchLoadingPortList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		String[] codeValue = null;
		codeValue = code.split("[|]");
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		try {
			if(codeValue.length==4) {
				param.put("fr_vps_etd_dt",codeValue[0]);
				param.put("to_vps_etd_dt",codeValue[1]);
				param.put("trd_cd",codeValue[2]);
				param.put("rlane_cd",codeValue[3]);
				velParam.put("methodname", "searchLoadingPortList");
				velParam.put("svcGrpCd", code);
			} else if(codeValue.length==5) {
				param.put("fr_vps_etd_dt",codeValue[0]);
				param.put("to_vps_etd_dt",codeValue[1]);
				param.put("trd_cd",codeValue[2]);
				param.put("rlane_cd",codeValue[3]);
				param.put("skd_dir_cd", codeValue[4]);
				velParam.put("methodname", "searchLoadingPortList");
				velParam.put("svcGrpCd", code);
				velParam.put("skddircd", codeValue[4]);
			}	else {
				param.put("fr_vps_etd_dt","");
				param.put("to_vps_etd_dt","");
				param.put("trd_cd","");
				param.put("rlane_cd","");
				velParam.put("methodname", "searchLoadingPortList");
				velParam.put("svcGrpCd", code);
			}
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
	}
	
	/**
	 * VVD List 항목을 가져온다.(ESM_COA_5113)<br>
	 * 2009.12.18[CHM-200901902] 메소드 추가
	 * TRADE|RLANE|FMDATE|TODATE
	 * @param String code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 * 
	 */
	public DBRowSet searchVvdList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		String[] codeValue = null;
		codeValue = code.split("[|]");
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
			if(codeValue.length==4) {			
				param.put("fr_vps_etd_dt",codeValue[0]);
				param.put("to_vps_etd_dt",codeValue[1]);
				param.put("trd_cd",codeValue[2]);
				param.put("rlane_cd",codeValue[3]);
				velParam.put("methodname", "searchVvdList");
				velParam.put("svcGrpCd", code);
			} else if(codeValue.length==5) {
				param.put("fr_vps_etd_dt",codeValue[0]);
				param.put("to_vps_etd_dt",codeValue[1]);
				param.put("trd_cd",codeValue[2]);
				param.put("rlane_cd",codeValue[3]);
				param.put("skd_dir_cd",codeValue[4]);
				velParam.put("methodname", "searchVvdList");
				velParam.put("svcGrpCd", code);
				velParam.put("skddircd", codeValue[4]);
			} else {
				param.put("fr_vps_etd_dt","");
				param.put("to_vps_etd_dt","");
				param.put("trd_cd","");
				param.put("rlane_cd","");
				velParam.put("methodname", "searchVvdList");
				velParam.put("svcGrpCd", code);
			}
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
	}		
	/**
	 * MDM_CHARGE CODE ComboList항목을 가져온다.<br>
	 *            
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	
	public DBRowSet searchMdmChargeList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		try {
			velParam.put("methodname", "searchMdmChargeList");			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
	}
	
	/**
	 * MDM_CHARGE TYPE CODE ComboList항목을 가져온다.<br>
	 *            
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	
	public DBRowSet searchMdmChargeTypeList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		try {
			velParam.put("methodname", "searchMdmChargeTypeList");			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
	}
	
	/**
	 * IAS SUB CODE ComboList항목을 가져온다.<br>
	 *            
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	
	public DBRowSet searchIasSubGrpCdList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		try {
			velParam.put("methodname", "searchIasSubGrpCdList");			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
	}
	
	/**
	 * Vessel 소유구분 항목을 가져온다.<br>
	 * 
	 * @param String code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	
	public DBRowSet searchVslOwnerList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		try {
			velParam.put("code"      , code);
			velParam.put("methodname", "searchVslOwnerList");
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
	}
	
	/**
	 * Reefer Core Account Code ComboList항목을 가져온다.<br>
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	
	public DBRowSet searchMdmReeferCoreAcctList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		try {
			velParam.put("methodname", "searchMdmReeferCoreAcctList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
	}
	

	/**
	 * Tariff Item, Tariff Detail 항목을 가져온다.<br>
	 * 
	 * @param String code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchCostSourceGroupCodeList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
			param.put("code"    ,code);
			velParam.put("methodname", "searchCostSourceGroupCodeList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
    }
	
	
	/**
	 * Tariff Item CODE항목을 가져온다.<br>
	 * 
	 * @param String code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchCostSourceItemCodeList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter

		try {
			String[] arr = code.split(",");			
			if(arr.length == 0) {
				param.put("code1", "");
				param.put("code2", "");
				velParam.put("code1", "");
				velParam.put("code2", "");
			} else if(arr.length == 1) {
				param.put("code1", arr[0]);
				param.put("code2", "");
				velParam.put("code1", arr[0]);
				velParam.put("code2", "");
			} else if(arr.length == 2) {
				param.put("code1", arr[0]);
				param.put("code2", arr[1]);
				velParam.put("code1", arr[0]);
				velParam.put("code2", arr[1]);
			}
			
			velParam.put("methodname", "searchCostSourceItemCodeList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
    }
	
	/**
	 * Tariff Detail CODE항목을 가져온다.<br>
	 * 
	 * @param String code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchCostSourceDetailCodeList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {			
			String[] arr = code.split(",");
			if(arr.length == 0) {
				param.put("code1", "");
				param.put("code2", "");
				param.put("code3", "");
				velParam.put("code1", "");
				velParam.put("code2", "");
				velParam.put("code3", "");
			} else if(arr.length == 1) {
				param.put("code1", arr[0]);
				param.put("code2", "");
				param.put("code3", "");
				velParam.put("code1", arr[0]);
				velParam.put("code2", "");
				velParam.put("code3", "");
			} else if(arr.length == 2) {
				param.put("code1", arr[0]);
				param.put("code2", arr[1]);
				param.put("code3", "");
				velParam.put("code1", arr[0]);
				velParam.put("code2", arr[1]);
				velParam.put("code3", "");
			} else if(arr.length == 3) {
				param.put("code1", arr[0]);
				param.put("code2", arr[1]);
				param.put("code3", arr[2]);
				velParam.put("code1", arr[0]);
				velParam.put("code2", arr[1]);
				velParam.put("code3", arr[2]);
			}
						
			velParam.put("methodname", "searchCostSourceDetailCodeList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
    }
		
	/**
	 * Service Lane CODE항목을 가져온다. - 0118화면에서 사용<br>
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchUnitCostSLaneList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {						
			velParam.put("methodname", "searchUnitCostSLaneList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
    }
	
	/**
	 * OrgDest CODE 항목을 가져온다. - 0016화면에서 사용<br>
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchCntrOrgDestCdList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {						
			velParam.put("methodname", "searchCntrOrgDestCdList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
    }	
	
	/**
	 * Mty Pick up location에 대한 yd 정보를 조회한다...<br>
	 * @param String code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchMtPickUpYdList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		
		try {
			param.put("code", code);
			velParam.put("code", code);
			velParam.put("methodname", "searchMtPickUpYdList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return dRs;
	}
	
	/**
	 * RA(Group) 리스트를 조회한다. - REGIONAL ACCOUNT FLAG
	 * 
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchRaAcctGroupList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
			velParam.put("methodname", "searchRaAcctGroupList");	
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
	}
	
	/**
	 * RA(individual) 리스트를 조회한다. - REGIONAL ACCOUNT FLAG
	 * 
	 * @param  String code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchRaAcctInDvlList(String code) throws DAOException {
		String[] keyAcctGrp = null;		
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		String sKeyAcctGrp = "";		
		keyAcctGrp = code.split(":", -1);
		sKeyAcctGrp = keyAcctGrp[0];
		sKeyAcctGrp = sKeyAcctGrp.trim();
		try {
			if(sKeyAcctGrp != null){
				param.put("mlttrdgrp"    ,sKeyAcctGrp);
				velParam.put("methodname", "searchRaAcctInDvlList");
				velParam.put("mlttrdgrp", sKeyAcctGrp);
			}
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
	}
	
	
	
	/**
	 * US ECC List 를 가져온다. - 0014화면에서 사용<br>
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchUsEccList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {						
			velParam.put("methodname", "searchUsEccList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
    }
	
	/**
	 * 전주차의 년도를 구한다.<br>
	 * 
	 * @return String
	 * @throws DAOException
	 */
	public String searchPrevYearPrd() throws DAOException {
		String result = "";
		DBRowSet dbRowSet = null;
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
				velParam.put("methodname", "searchPrevWkPrd");
				
				dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
				if (dbRowSet != null) {
					while (dbRowSet.next()) {
						result = dbRowSet.getString("cost_yr");
					}
				}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;		
	}
	
	/**
	 * US ECC List 를 가져온다. - 0014화면에서 사용<br>
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchSokeupCodeList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {						
			velParam.put("methodname", "searchSokeupCodeList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
    }
	
	/**
	 * ESM_COA_9000 : BKG 소급 리스트 조회<br>
	 *
	 * @param BkgSokeupVO bkgSokeupVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchBkgSokeupStatus(BkgSokeupVO bkgSokeupVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(bkgSokeupVO != null){
				Map<String, String> mapVO = bkgSokeupVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);					
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchBkgSokeupStatusRSQL(), param, velParam);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * ESM_COA_9000 소급 히스토리<br>
	 * 
	 * @param List<BkgSokeupVO> bkgSokeupVoList
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	 public int[] addBkgSokeupHistory(List<BkgSokeupVO> bkgSokeupVoList) throws DAOException, Exception {
			int insCnt[] = null;
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				if(bkgSokeupVoList.size() > 0){	
						insCnt = sqlExe.executeBatch((ISQLTemplate)new CommonDBDAOAddBkgSokeupHistoryCSQL(), bkgSokeupVoList,null);
						
				
					for(int i = 0; i < insCnt.length; i++){
						if(insCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No"+ i + " SQL");				
					}
				}
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return insCnt;
		}
	 
		/**
		 * ESM_COA_9000 소급 대상 정보 업데이트<br>
		 * @param List<BkgSokeupVO> bkgSokeupVoList
		 * @return int
		 * @throws DAOException
		 * @throws Exception
		 */
		@SuppressWarnings("unchecked")
		public int addBkgSokeupCalc(List<BkgSokeupVO> bkgSokeupVoList) throws DAOException, Exception {
				int insCnt = 0;
				List colNmList = new ArrayList();
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				try {
					if(bkgSokeupVoList!=null && bkgSokeupVoList.size()>0){
						for(int j=0 ; j<bkgSokeupVoList.size() ; j++){
							colNmList.add(bkgSokeupVoList.get(j).getBkgNo());
						}
						param.put("max_seq", bkgSokeupVoList.get(0).getMaxSeq());
						velParam.put("expVal", colNmList);
						insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new CommonDBDAOAddBkgSokeupCalcCSQL(), param, velParam);
					}
				} catch (SQLException se) {
					log.error(se.getMessage(),se);
					throw new DAOException(new ErrorHandler(se).getMessage());
				}catch(Exception ex){
					log.error(ex.getMessage(),ex);
					throw new DAOException(new ErrorHandler(ex).getMessage());
				}
				return insCnt;
			}
		
		/**
		 * ESM_COA_9000 소급 대상 정보 업데이트<br>
		 * @return String
		 * @throws DAOException
		 * @throws Exception
		 */
		public String checkMaxBatSeq() throws DAOException, Exception {
			String result = null;
			DBRowSet dbRowSet = null;
			
			try {
					dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOCheckMaxBatSeqRSQL(), null, null);
					if (dbRowSet != null) {
						while (dbRowSet.next()) {
							result = dbRowSet.getString("max_seq");
						}
					}				
				} catch (SQLException se) {
					log.error(se.getMessage(),se);
					throw new DAOException(new ErrorHandler(se).getMessage());
				}catch(Exception ex){
					log.error(ex.getMessage(),ex);
					throw new DAOException(new ErrorHandler(ex).getMessage());
				}
				return result;
			}
		
		/**
		 * Grp ID 에 해당하는 RHQ_CD 를 조회한다.
		 * 
		 * @param  String code
		 * @param  String codeItem
		 * @return DBRowSet DB 처리 결과
		 * @throws DAOException
		 */
		public DBRowSet searchRHQTeamByGrpIdList(String code, String codeItem) throws DAOException {
			String[] keyAcctGrp = null;		
			DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
			Map<String, Object> param = new HashMap<String, Object>();//parameter
			Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
			
			String sKeyCoreAcctGrp = "";
			String sKeyRegAcctGrp = "";
			
			if(codeItem.equalsIgnoreCase("RHQTeamByCoreGrpId")){
				keyAcctGrp = code.split(":", -1);
				sKeyCoreAcctGrp = keyAcctGrp[0].trim();
			}else if(codeItem.equalsIgnoreCase("RHQTeamByRegGrpId")){
				keyAcctGrp = code.split(":", -1);
				sKeyRegAcctGrp = keyAcctGrp[0].trim();
			}
			try {
				if(!sKeyCoreAcctGrp.equalsIgnoreCase("")){
					param.put("keyacctgrp"    ,sKeyCoreAcctGrp);
					velParam.put("methodname", "searchRHQTeamByGrpIdList");
					velParam.put("keyacctgrp", sKeyCoreAcctGrp);
				}else if(!sKeyRegAcctGrp.equalsIgnoreCase("")){
					param.put("mlttrdgrp"    ,sKeyRegAcctGrp);
					velParam.put("methodname", "searchRHQTeamByGrpIdList");
					velParam.put("mlttrdgrp", sKeyRegAcctGrp);
				}
				dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				throw new DAOException(e.getMessage());
			}
			return dRs;
		}
		
		/**
		 * Grp ID 에 해당하는 Team_Ofc_Cd 를 조회한다.
		 * 
		 * @param  String code
		 * @param  String codeItem
		 * @return DBRowSet DB 처리 결과
		 * @throws DAOException
		 */
		public DBRowSet searchHOTeamByGrpIdList(String code, String codeItem) throws DAOException {
			String[] keyAcctGrp = null;		
			DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
			Map<String, Object> param = new HashMap<String, Object>();//parameter
			Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
			
			String sKeyCoreAcctGrp = "";
			String sKeyRegAcctGrp = "";
			
			if(codeItem.equalsIgnoreCase("HOTeamByCoreGrpId")){
				keyAcctGrp = code.split(":", -1);
				sKeyCoreAcctGrp = keyAcctGrp[0].trim();
			}else if(codeItem.equalsIgnoreCase("HOTeamByRegGrpId")){
				keyAcctGrp = code.split(":", -1);
				sKeyRegAcctGrp = keyAcctGrp[0].trim();
			}
			try {
				if(!sKeyCoreAcctGrp.equalsIgnoreCase("")){
					param.put("keyacctgrp"    ,sKeyCoreAcctGrp);
					velParam.put("methodname", "searchHOTeamByGrpIdList");
					velParam.put("keyacctgrp", sKeyCoreAcctGrp);
				}else if(!sKeyRegAcctGrp.equalsIgnoreCase("")){
					param.put("mlttrdgrp"    ,sKeyRegAcctGrp);
					velParam.put("methodname", "searchHOTeamByGrpIdList");
					velParam.put("mlttrdgrp", sKeyRegAcctGrp);
				}
				dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				throw new DAOException(e.getMessage());
			}
			return dRs;
		}
		
		/**
		 * 선택한 Team Code 에 해당하는 Core Customer Group 목록을 조회한다..<br>
		 * 
		 * @param code (ofc_team_cd|cust_rhq_cd)
		 * @return DBRowSet DB 처리 결과
		 * @throws DAOException
		 */
		public DBRowSet searchCoreGrpIdByTeamCList(String code) throws DAOException {
			DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
			
			Map<String, Object> param = new HashMap<String, Object>();//parameter
			Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter		
				
				try {
					if(code != null){
						
						String[] inParam = code.split("[|]");//0:ofc_team_cd, 1:cust_rhq_cd
						String ofc_team_cd = "";
						String cust_rhq_cd = "";
						if(inParam.length>1){
							ofc_team_cd = inParam[1];
						}
						
						if(inParam.length>2){
							cust_rhq_cd = inParam[2];
						}
						
						param.put("ofc_team_cd"    ,ofc_team_cd);
						param.put("cust_rhq_cd"    ,cust_rhq_cd);
						
						velParam.put("methodname", "searchCoreGrpIdByTeamCList");
						velParam.put("ofc_team_cd", ofc_team_cd);
						velParam.put("cust_rhq_cd", cust_rhq_cd);
					}
					
					dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
				} catch(SQLException se){
					log.error(se.getMessage(),se);
					throw new DAOException(new ErrorHandler(se).getMessage());			
				} catch(Exception ex){
					log.error(ex.getMessage(),ex);			
					throw new DAOException(new ErrorHandler(ex).getMessage());
				}

				return dRs;
			}
		
		/**
		 * 선택한 Team Code 에 해당하는 Regional Customer Group 목록을 조회한다..<br>
		 * 
		 * @param code (ofc_team_cd|cust_rhq_cd)
		 * @return DBRowSet DB 처리 결과
		 * @throws DAOException
		 */
		public DBRowSet searchRegGrpIdByTeamCList(String code) throws DAOException {
			DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
			
			Map<String, Object> param = new HashMap<String, Object>();//parameter
			Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter		
				
				try {
					if(code != null){
						
						String[] inParam = code.split("[|]");//0: dummy 1:ofc_team_cd, 2:cust_rhq_cd
						String ofc_team_cd = "";
						String cust_rhq_cd = "";
						if(inParam.length>1){
							ofc_team_cd = inParam[1];
						}
						
						if(inParam.length>2){
							cust_rhq_cd = inParam[2];
						}
						
						param.put("ofc_team_cd"    ,ofc_team_cd);
						param.put("cust_rhq_cd"    ,cust_rhq_cd);
						
						velParam.put("methodname", "searchRegGrpIdRHQTeamCList");
						velParam.put("ofc_team_cd", ofc_team_cd);
						velParam.put("cust_rhq_cd", cust_rhq_cd);
					}
					
					dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
				} catch(SQLException se){
					log.error(se.getMessage(),se);
					throw new DAOException(new ErrorHandler(se).getMessage());			
				} catch(Exception ex){
					log.error(ex.getMessage(),ex);			
					throw new DAOException(new ErrorHandler(ex).getMessage());
				}

				return dRs;
			}

		/**
		 * 입력된 DEL Term, DEL Location, Node 에 따른 MT Return CY를 찾는다.
		 * 
		 * @param loc_cd
		 * @param tml_cd
		 * @param de_term
		 * @return String 처리 결과
		 * @throws DAOException
		 */
		public String searchMtyReturnCY(String loc_cd, String tml_cd, String de_term) throws DAOException {
			//ResultSet rs = null; // DB ResultSet
			String result = "";
			DBRowSet dbRowSet = null;
			
			Map<String, Object> param = new HashMap<String, Object>();//parameter
			Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
			
			try {
				param.put("loc_cd"    ,loc_cd);
				param.put("tml_cd"    ,tml_cd);
				param.put("de_term"   ,de_term);
				velParam.put("methodname", "searchMtyReturnCY");
				velParam.put("tml_cd"    ,tml_cd);
				velParam.put("de_term"   ,de_term);
				
				dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
				if (dbRowSet != null) {
					while (dbRowSet.next()) {
						result = dbRowSet.getString(1);
					}
				}
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());			
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
	
			return result;		
		}
		
		
		/**
		 * BATCH status 를 생성한다. <br>
		 *
		 * @param SearchConditionVO searchConditionVO
		 * @throws DAOException
		 */
		public void addBatchStatus(SearchConditionVO searchConditionVO) throws DAOException{
		     //query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			int result = 0;
	        try{
	        	if(searchConditionVO != null){
	        		Map<String, String> mapVO = searchConditionVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
	        	}
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new CommonDBDAOBatchStatusCSQL(), param, velParam);
				if (result == Statement.EXECUTE_FAILED) {
					throw new DAOException("Fail to update SQL");
				}
	        }catch(SQLException se){
	            log.error(se.getMessage(),se);
	            log.error("err " + se.toString(), se);
	            throw new DAOException(new ErrorHandler(se).getMessage());
	        }catch(Exception ex){
	            log.error(ex.getMessage(),ex);
	            log.error("err " + ex.toString(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage());
	        }
	    }
		
		
		/**
		 * BATCH CREATE TABLE로부터 현재 BATCH의 STATUS를 알아본다.<br>

		 * @param  SearchConditionVO searchConditionVO
		 * @return List<CoaUtCostCreStsVO>
		 * @throws DAOException
		 */
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public List<CoaUtCostCreStsVO> searchBatchStatus(SearchConditionVO searchConditionVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<CoaUtCostCreStsVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(searchConditionVO != null){
					Map<String, String> mapVO = searchConditionVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOBatchStatusRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, CoaUtCostCreStsVO .class);
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}
		
		/**
		 * 입력된 DEL Term, DEL Location, Node 에 따른 MT Return CY를 찾는다.
		 * 
		 * @param loc_cd
		 * @param f_pol_pod_cd
		 * @param f_spcl_cgo_cd
		 * @return String 처리 결과
		 * @throws DAOException
		 */
		public String searchExceptionMtyReturnCY(String loc_cd, String f_pol_pod_cd, String f_spcl_cgo_cd) throws DAOException {
			//ResultSet rs = null; // DB ResultSet
			String result = "";
			DBRowSet dbRowSet = null;
			
			Map<String, Object> param = new HashMap<String, Object>();//parameter
			Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
			
			try {
				param.put("loc_cd"    ,loc_cd);
				param.put("f_pol_pod_cd"    ,f_pol_pod_cd);
				param.put("f_spcl_cgo_cd"    ,f_spcl_cgo_cd);
				velParam.put("loc_cd"    ,loc_cd);
				velParam.put("f_pol_pod_cd"   ,f_pol_pod_cd);
				velParam.put("f_spcl_cgo_cd"   ,f_spcl_cgo_cd);
				
				dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOsearchExceptionMtyReturnCYRSQL(), param, velParam);
				if (dbRowSet != null) {
					while (dbRowSet.next()) {
						result = dbRowSet.getString(1);
					}
				}
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());			
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
	
			return result;		
		}
		
		/**
		 * Manual Detail Cost Table을 삭제 한다. 
		 *
		 * @param WeekCopyVO weekCopyVO
		 * @throws DAOException
		 */
		public void removeVslLayupWeekCopy(WeekCopyVO weekCopyVO) throws DAOException {
			Map<String, Object> param = new HashMap<String, Object>();//parameter
			int saveCnt = 0;			
			
	        try{
				//파라미터 세팅
				param.put("f_src_week"		, weekCopyVO.getFSrcWeek().replaceAll("-", ""));
				param.put("f_tar_week"		, weekCopyVO.getFTarWeek().replaceAll("-", ""));
	            param.put("user_id"   		, weekCopyVO.getUsrId());
	            param.put("rlane_cd"   	, weekCopyVO.getRlaneCd());
	            	
	        	saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new CommonDBDAORemoveVslLayupWeekCopyDSQL(), param, null);

	            if(saveCnt== Statement.EXECUTE_FAILED)
	                throw new DAOException("Fail to modify SQL");

	        }catch (SQLException se) {
	            log.error("err " + se.toString(), se);
	            log.error(se.getMessage(),se);
	            throw new DAOException(new ErrorHandler(se).getMessage());
	        }catch(Exception ex){
	            log.error("err " + ex.toString(), ex);
	            log.error(ex.getMessage(),ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage());
	        }
		}
		
		/**
		 * Manual Detail Cost Table에서 SOURCE 해당주를 복사해서  TARGET 데이타를 생성한다.
		 *
		 * @param WeekCopyVO weekCopyVO
		 * @throws DAOException
		 */
		public void createVslLayupWeekCopy(WeekCopyVO weekCopyVO) throws DAOException {
			Map<String, Object> param = new HashMap<String, Object>();//parameter
			int saveCnt = 0;			
			
	        try{
				//파라미터 세팅
				param.put("f_src_week"		, weekCopyVO.getFSrcWeek().replaceAll("-", ""));
				param.put("f_tar_week"		, weekCopyVO.getFTarWeek().replaceAll("-", ""));
	            param.put("user_id"   		, weekCopyVO.getUsrId());
	            param.put("rlane_cd"   		, weekCopyVO.getRlaneCd());
	            	
	        	saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new CommonDBDAOCreateVslLayupWeekCopyCSQL(), param, null);

	            if(saveCnt== Statement.EXECUTE_FAILED)
	                throw new DAOException("Fail to modify SQL");

	        }catch (SQLException se) {
	            log.error("err " + se.toString(), se);
	            log.error(se.getMessage(),se);
	            throw new DAOException(new ErrorHandler(se).getMessage());
	        }catch(Exception ex){
	            log.error("err " + ex.toString(), ex);
	            log.error(ex.getMessage(),ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage());
	        }
		}
		
		/**
		 * [ESM_COA_0024]<br>
		 * COA_MNL_DTL_COST 테이블에서 해당 데이타의 total값 가져오기<br>
		 *
		 * @param WeekCopyVO weekCopyVO
		 * @return int
		 * @exception DAOException
		 */
		public int getVslLayupTot(WeekCopyVO weekCopyVO) throws DAOException {
			DBRowSet dbRowset = null;
			int result = 0;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				//파라미터 세팅
				param.put("f_src_week"		, weekCopyVO.getFSrcWeek().replaceAll("-", ""));
				param.put("f_tar_week"		, weekCopyVO.getFTarWeek().replaceAll("-", ""));
	            param.put("user_id"   		, weekCopyVO.getUsrId());
	            param.put("rlane_cd"   		, weekCopyVO.getRlaneCd());

	            velParam.put("rlane_cd"   		, weekCopyVO.getRlaneCd());
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetVslLayupTotRSQL(), param, velParam);
				if(dbRowset.next()) {
					result = dbRowset.getInt("TOT");
				}
			} catch(SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return result;
		}
		
		/**
		 * [ESM_COA_0024]<br>
		 * COA_MNL_COST_STUP 테이블에 해당 데이타가 존재하는지 확인<br>
		 *
		 * @param WeekCopyVO weekCopyVO
		 * @return int
		 * @exception DAOException
		 */
		public int chkCostSetupCopy(WeekCopyVO weekCopyVO) throws DAOException {
			DBRowSet dbRowset = null;
			int result = 0;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();

			try{
				Map<String, String> mapVO = weekCopyVO.getColumnValues();

				param.putAll(mapVO);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOChkCostSetupCopyRSQL(), param, null);
				if(dbRowset.next()) {
					result = dbRowset.getInt("CNT");
				}
			} catch(SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return result;
		}
		
		/**
		 * [ESM_COA_0024]<br>
		 *  Total Amount값을 COA_MNL_COST_STUP 테이블에 업데이트 한다<br>
		 *
		 * @param WeekCopyVO weekCopyVO
		 * @param int totSum
		 * @exception DAOException
		 * @exception Exception
		 */
		public void updateVslLayupTotCopy(WeekCopyVO weekCopyVO, int totSum) throws DAOException, Exception {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();

			int result = 0;
			try {
				Map<String, String> mapVO = weekCopyVO.getColumnValues();

				param.putAll(mapVO);
				param.put("tot_sum", totSum);
				
				SQLExecuter sqlExe = new SQLExecuter("");						
				result = sqlExe.executeUpdate((ISQLTemplate)new CommonDBDAOUpdateVslLayupTotCopyUSQL(), param, null);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		
		/**
		 * [ESM_COA_0024]<br>
		 *  Total Amount값을 COA_MNL_COST_STUP 테이블에 신규입력 한다<br>
		 *
		 * @param WeekCopyVO weekCopyVO
		 * @param int totSum
		 * @exception DAOException
		 * @exception Exception
		 */
		public void insertVslLayupTotCopy(WeekCopyVO weekCopyVO, int totSum) throws DAOException, Exception {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();

			int result = 0;
			try {
				Map<String, String> mapVO = weekCopyVO.getColumnValues();

				param.putAll(mapVO);
				param.put("tot_sum", totSum);
				
				SQLExecuter sqlExe = new SQLExecuter("");						
				result = sqlExe.executeUpdate((ISQLTemplate)new CommonDBDAOInsertVslLayupTotCopyCSQL(), param, null);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		
}
