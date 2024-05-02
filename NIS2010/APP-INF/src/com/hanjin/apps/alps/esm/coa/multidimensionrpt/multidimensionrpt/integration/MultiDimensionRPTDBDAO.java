/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : MultiDimensionRPTDBDAO.java
 *@FileTitle : MultiDimensionRPTDBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
 * 2006-11-09 Sangwook_nam
 * 1.0 최초 생성
 * =========================================================
 * History
 * 2008.01.03 박은주 N200712280005 COA Report Error 수정 요청
 *                  1. Inquiry by Lane : TP/SZ 선택 후 SP2, SP4 조회 시 오류[060]
 *                  2. Inquiry by BKG : SP2, SP4의 GRPB, CMPB 계산 오류[061]
 *                  4. 각 Report를 새창에서 열 경우, 위에 보이는 Title을 Menu명과 동일하게 변경 요청
 * 2008.01.09 박은주 N200801070002 COA 2007년 Contract QTA 관련
 *                  COA내 2007년 Contract QTA가 0으로 나오도록 조치 바랍니다.[070]
 * 2008.02.15 박은주 N200801154874 주간 대상항차 기준 변경 관련 요청 
 *                  Month로 조회시 Cost_yrmon, Week 조회시 Sls_yrmon 으로 조회되도록 쿼리문 수정[060,062,070,071,078,147,148]
 * 2008.02.26 전성진 080,081,082 대상항차 조회시 WK로 조회하면 SLS_YRMON 사용하게 변경
 * 2008.02.28 전윤주 CSR No. N200801154876
 *                  063, 0632, 065, 067, 0672 대상항차 조회시 WK로 조회하면 SLS_YRMON 사용하게 변경
 * 2008.02.28 박은주 N200802250022 COA_RD 관련 수정 요청 
 *                화면에서 Excluding SOC Flag 체크시 SOC가 Y가 아닌것만 조회하도록 쿼리문 수정[060,062] 
 * 2008.03.07 박은주 N200802260011 STP Income 화면 수정 요청 
 *                화면에 Income/Cost 각각을 선택적으로 볼수 있는 옵션 추가 및 VVD 항차별로 조회
 *                할수 있도록 검색조건추가[135] 
 * 2008.03.21 박은주 N200802280015 COA_Report 관련 수정 요청_1,2번항목  
 *                1. Monthly Average U/C[057] 
 *                - RA 기준 추가, Term 조건 추가
 *                - Sheet 각각에 Total 값추가
 *                - Profit Level을 OP를 선택했을때 OP항목에 해당하는 컬럼을 보여줌(동적으로)
 *                2. Inquiry by Customized Condition[060] 
 *                - Cost 수식 수정 : Cost = G.RPB + DEM/DET - CMB
 *                - C.S.REP 수정 (현재 L.REP 정보를 보여주고 있음)
 *                - L.REP 추가
 *                - CN CD + CUST CD에 해당하는 SHPR NM과 B/L SHPR NM으로 이원화
 * 2008.03.21 박은주 R200803125390 P/L 화면 보완 요청_1,2번항목  
 *                Week선택시에 Month, Week를 입력할수 있도록 변경[060,062,070]
 * 2008.03.28 전성진 N200803240003 물류레포트에 Sale Vol.,Inland Vol. 추가 [081]
 * 					 Week 조회시 월 조건 추가[080, 081, 082]              
 * 2008.04.03 전성진 N200803310003 물류레포트 파일 분리      
 * 2008.04.04 박은주 N200803240008 COA Report 관련 수정(Daily BKG Creation 화면)[078]
 *                1. Sales Office 선택시, 최대 7일 검색 가능하나
 *                   월이 변경될 경우 7일 이상으로 인식
 *                   ex) 2008-1-30~20088-2-1 으로 조회시,
 *                        7일 이상 불가 메세지가 보임
 *                2. BKG CNFM Only -> Firm BKG Only로 표기 변경
 *                3. Branch View 오류 수정
 *                 - 조회 해당 Office의 STP Revenue 및 Oth Activity Cost, Net STP Income
 *                   ex) A Office 조회시, 해당 기간 동안 생성된 BKG 중
 *                       Contract Office<>A & Conduct Office = A BKG에 대하여 발생한
 *                       A Office의 STP Revenue 및 Oth Activity Cost, Net STP Income
 *                4. S.Rep Option 추가 (첨부파일 참조 바람)　
 *                 - S.Rep 입력란 삽입  
 *                 - Office View가 Contract 일 경우, S.Rep을 Contract S.Rep 정보와 연결하여 해당 Data 보여줌
 *                   Office View가 Loading 일 경우, S.Rep을 Loading S.Rep 정보와 연결하여 해당 Data 보여줌
 *                5. Data Grid 에 아래항목 추가
 *                 - Trade/Lane/BD/VVD/ Office / S.REP code/ Customer(shipper)....
 *                 : Trade/Lane/BD/VVD, S.REP Code, Shipper를 각 check option으로
 *                  (첨부파일 참조 바람)
 *                6. Branch View 위치 변경 (아래쪽) 및 버튼 누를 경우 data 볼 수 있도록 수정
 *                7. 기타 : File Download 시 Item 명 중 CM 아래 공란 삭제, BKG No를 한 칸으로해서 Split 까지 함께 기재
 *               = 추가 요청사항 =
 *               1. CM Cost가 맞지 않는다.
 *               2. BKG가 있을경우 Double Click 시 Inquiry by BKG 화면 Open시에 자동 조회 되도록 요청
 *               3. BKG가 있을경우 Double Click 시 Inquiry by BKG 화면 조회시 검색 조건 Profit View, Level도 넣어 줌
 *               4. Inquiry by Customized Condition의 Remark처럼 하단에 Remark 처리 요청
 *                  "If you want to check all costs related to the BKG, 
 *                   please mark on the "BKG Display" when retrieving the data and double click the BKG No."
 *               5. Branch View의 그리드의 타이틀 중  "Oth Vol Activity" 를 "Oth Vol Activity Cost" 로 변경 요청
 *               6. Branch View에 나오는 Office랑  S.Rep은 항상 Contract Office랑 Contract S.Rep이죠?
 *                  그럼 Contract Office랑 C.S.Rep으로 바꿔 주실수 있으세요?
 * 2008.04.07 박은주 N200804020018 COA Report 수정 요청  
 *                1. Inquiry by Customized Condition
 *                 - Pop-up 화면에 연결된 table 변경 : data 조회 가능하도록 변경
 *                    (첨부파일 참조)　
 *                 - 화면 하단에 아래 메세지 수정 및 추가
 *                    ▶ Please reset the report form - in the event that an error occurs.
 *                    ▶ If you want to check all costs related to the booking, please include 
 *                        the BKG number when retrieving the data and double click it.
 *                2. Office Report vs QTA
 *                 - 기간 표시 (타화면 참조)
 *                3. Inquiry by BKG
 *                 - Cost Detail 조회시 TP/SZ를 선택하고 조회할 경우 Error 발생  : 수정 요망    
 * 2008.04.18 박은주 N200804160003_QTA 검색 관련 보완 요청[070]
 *                SAQ의 정보를 가져올때 년도는 SLS_YRMON을 사용하고 분기 정보는 SAQ 중 최근 분기 정보를 가져오도록 수정
 * 2008.05.13 박은주 N200805070003 COA_조회권한 관련 & Customized Condition 오류 수정 요청
 *                B/L No 뒷 자리가 잘려서 나오는 오류 수정
 * 2008.05.21 임옥영 loop안에서 RS 관련 closing 처리               
 * 2008.05.30 박은주 N200805260011 COA Report REV 산출 수정 요청
 *                1) Rev에 해당하는 Data 확인 : Ocean Freight 계정 + 기타 Rev 계정 (현재 Misc OPR Rev로 산출되는 수입계정 제외)
 *                2) RPB 산출시 Misc OPR Rev 계정 제외
 *                3) CM 산출식 확인 : Rev(OFT + 기타Rev) + Misc OPR Rev + Dem/Det - Cost1(각 Profit View별)
 *                4) 대상 Report : P/L by Lane을 제외한 모든 화면 (COA live source와 연결되어 있는 모든 화면이 대상입니다.)
 *                   - Inquiry by customized condition[060]
 *                     - popup : Inquiry by BKG[131] 
 *                   - Inquiry by lane[062]
 *                     - popup : Inquiry by BKG[079]
 *                     - popup : Route Detail Inquiry[147]
 *                     - popup : BKG Detail Inquiry[148]
 *                   - Inquiry by BKG[061]
 *                   - Office report by QTA[070]
 *                   - Office report by graph[071]
 *                   - Office report by daily BKG creation[078]
 * 2008.06.03 박은주 N200805300001 COA_화면 개발 및 수정[Inquiry by BKG(ABC/STP) 화면개발] 
 * 2008.06.10 박은주 N200805307020 Split 01-COA_화면 개발 및 수정[070] 
 * 2008.06.16 박은주 N200805307021 Split 02-COA_화면 개발 및 수정[156] 
 * 2008.06.24 박은주 N200806120005 COA_Report 조회 오류[061] 
 * 2008.06.30 박은주 N200806127354 COA_조회권한 관련 요청[060,070,071,078]
 *            박칠서 N200806120004 COA_조회권한 관련 요청[072]
 *            박상희 N200806127354 COA_조회권한 관련 요청[062]
 *            coa_bkg_svc_trns_smry 테이블의 컬럼 변경으로 인해 소스 수정(oth_prc_amt->otr_prc_amt) 
 * 2008.07.01 박은주 N200807077840Office 조직 변경으로 인해 소스 변경  
 * 2008.07.15 PSH N200806277654 Office-Report by Daily BKG Creation Report 관련 수정
 *                1) S/C No, RFA No 조회조건 추가
 *                2) Check Box 사용하여 Field 추가
 *                   - Route : BKG POR, BKG POL, BKG POD, BKG DEL
 *                   - CMDT : CMDT, CMDT NM
 *                   - SC/RFA : S/C No, RFA No
 *                3) Office View에 따라 Field 이름이 다르게 보이도록 수정
 *                   - Contract View : C.Office, C.S.Rep
 *                   - Loading View : L.Office, L.Rep   
 * 2008.08.29 박상희 N200807298360 Expense Detail로 테이블 변경하면서 sales 디렉토리로 소스분리 
 *                   [035,059,060,061,062,070,071,135,144,147,148,149,156]   
 * 2008.10.10 박상희 N200808228859 Special CNTR 분리운영(cntr_tpsz_cd -> spcl_cntr_tpsz_cd) [057]  
 * 2008.10.15 전윤주 069번 화면 쿼리 정리 
 * 2008.10.20 전윤주 N200810200014 Expense Detail로 테이블 변경하면서 sales 디렉토리로 소스분리 [057]
 * 2008.10.21 박상희 N200810200009 Expense Detail로 테이블 변경하면서 sales 디렉토리로 소스분리 [078]
 * 2008.12.15 박은주 N200811270012 COA_BKG CM 기준 변경 [072]
 * 2008.12.22 박상희 N200812230009 조직체계 변경 관련 조회 기능 개선
 * 2008.12.22 전성진 N200812230007 조직체계 변경 관련 조회 기능 개선
 * 2009.01.05 박은주 조직체계 변경 후 속도가 느려진 쿼리문이 있어 튜닝함[072]_Hint 추가
 * 2009.02.04 김태윤 N200901210016 - COA_조직개편 관련 기능 수정 [063], [067]
 * 2009.02.04 박은주 CSR.NO:N200901210014 조직개편 관련 기능 수정[072]
 * 2009.02.05 박상희 N200901230003 BKG OP 항목 수정 [072] 
 * 2009.02.06 전윤주 N200901210015 COA_조직개편 관련 기능 수정 (ofc_lvl 테이블에 걸리는 join 조건 cost_yrmon, sls_yrmon 관련 수정) 
 * 2009.02.09 임옥영 N200901190016 조직개편 적용후 쿼리 튜닝
 * 2009.02.12 임옥영 N200902110080 SINWA 실적 조회 권한 관련
 * 2009.03.03 박은주 N200902260022 COA_조직 Code 변경 및 ABC/STP 관련[072]
 * 2009.03.26 박은주 : 품질검토결과 수정사항 반영                   
 * 2009.04.03 김종열 N200903170124 COA_Multi-dimension report 조회권한 변경 
              (searchMultiDimension063List,searchMultiDimension065List,searchMultiDimension067List)
 * 2009.04.03 배진환 N200903170122 COA_Multi-dimension report 조회권한 변경 searchWeeklySalesByOffice3TEUBased1List, searchWeeklySalesByOffice3TEUBased2List, searchWeeklySalesByOffice3TEUBased3List
 * 2009.04.22 박상희 N200904070094 CM 계산 수식 변경         
 * 2009.07.23 박수훈 New Framework 적용 [0130]   
 * 2009.09.21 김기식   New FrameWork 적용 [0063,0065,0066,0067]
 * 2010.09.01 김기종 CSR No. CHM-201005370-01 Inquiry by customized condition 기능 개선
 * 2012.06.25 이석준 [CHM-201218363-01] P&L by Lane Report data creation 기능 추가
 * 2012.10.15 이석준 [CHM-201220161-01] 실시간 영업현황 관련 UI
 * 2013.06.13 서미진 [CHM-201325024] 2주차씩 Creation 이 되고 완료 되었을때 완료 메세지가 뜨게 수정
 * 2014.01.02 김수정 [CHM-201327858] [COA] IAS P&L 추가
 =========================================================*/
package com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.basic.MultiDimensionRPTBCImpl;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.vo.MultiDimensionPfmcByOfficeListVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.vo.RepoPfmcConditionVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.vo.SearchAdjCostDtlListVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.vo.SearchIasSubCdListVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.vo.SearchMultiDimension068ListVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.vo.SearchReportViewListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.costsetup.vo.SearchCostSetUpListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.CoaRptAuthMgmtVO;
import com.hanjin.syscommon.common.table.CoaUtCostCreStsVO;


/**
 * ALPS-COA에 대한 DB 처리를 담당<br> - ALPS-COA Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Sangwook_nam
 * @see MultiDimensionRPTBCImpl 참조
 * @since J2EE 1.6  
 */ 
public class MultiDimensionRPTDBDAO extends DBDAOSupport {
		
     
	/**
	 * 
	 */
	private static final long serialVersionUID = -909354205729956666L;

	/**
	 * MultiDimension의 모든 목록을 가져온다.<br>
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @return List<MultiDimensionPfmcByOfficeListVO>
	 * @throws DAOException 
	 * 파라미터 f_sch_mode 값에따라 각각 쿼리 Dynamic 실행
	 *  - f_sch_mode '1': ENIS[ESM_COA_0063GS]
	 *  			 '2': ENIS[ESM_COA_0063GS2]
	 *  			 '3': ENIS[ESM_COA_0065GS, ESM_COA_0067GS2]
	 *  			 '4': ENIS[ESM_COA_0067GS]
	 */
	public List<MultiDimensionPfmcByOfficeListVO> searchMultiDimension0063List(RepoPfmcConditionVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<MultiDimensionPfmcByOfficeListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MultiDimensionRPTDBDAOSearchMultiDimensionOfcListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MultiDimensionPfmcByOfficeListVO .class);
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
	 * MultiDimension의 모든 목록을 가져온다.<br>
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @param List<String> cols
	 * @return DBRowSet 
	 * @throws DAOException
	 */
	public DBRowSet searchMultiDimension0066List(RepoPfmcConditionVO vo, List<String> cols) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				velParam.put("allcols", cols); // 가변컬럼	
			} 
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MultiDimensionRPTDBDAOSearchEqRepoCostDetailListRSQL(), param, velParam);
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
	 * 가변헤더를 가져온다.<br>
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchMultiDimension0066VarHeader(RepoPfmcConditionVO vo) throws DAOException {
		DBRowSet dbRowset = null; 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO); 
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MultiDimensionRPTDBDAOSearchEqRepoCostDetailHeaderRSQL(), param, velParam);
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
	 * booking의 Route정보를 가져온다.<br>
	 * (por, pol, lane, t/s, pod, del, t/time)
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @return List<SearchMultiDimension068ListVO>
	 * @throws DAOException
	 */
	public List<SearchMultiDimension068ListVO> searchMultiDimension0068List(RepoPfmcConditionVO vo) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<SearchMultiDimension068ListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MultiDimensionRPTDBDAOSearchMultiDimension068ListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMultiDimension068ListVO .class);
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
	 * MultiDimension의 모든 목록을 가져온다.<br>
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @return List<MultiDimensionPfmcByOfficeListVO>
	 * @throws DAOException
	 */
	public List<MultiDimensionPfmcByOfficeListVO> searchMultiDimension0069List(RepoPfmcConditionVO vo) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<MultiDimensionPfmcByOfficeListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MultiDimensionRPTDBDAOSearchMultiDimension069ListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MultiDimensionPfmcByOfficeListVO .class);
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
	 * MultiDimension의 모든 목록을 가져온다.<br>
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @param List<String> cols
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchMultiDimension00692List(RepoPfmcConditionVO vo, List<String> cols) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				velParam.put("allcols", cols); // 가변컬럼	
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MultiDimensionRPTDBDAOSearchMultiDimension069List2RSQL(), param, velParam);
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
	 * MultiDimensionRPT의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param e
	 * @return DBRowSet
	 * @throws DAOException
	 */
	/*
	 * public DBRowSet loadingCurrentVVD(Event e) throws DAOException { // Connection Interface Connection con = null; //
	 * 정적파싱을 지원하는 SQL Statement PreparedStatement ps = null; // DB ResultSet ResultSet rs = null; // 데이터 전송을 위해 DB
	 * ResultSet을 구현한 객체 DBRowSet dRs = null; // PreparedStatement에 bind 변수를 넣을시 증가되는 변수 int i = 0;
	 * 
	 * String currentYrmon = ""; String queryStr = "";
	 * 
	 * try { currentYrmon = DateTime.getFormatDate(new java.util.Date(), "yyyyMM");
	 * 
	 * queryStr = "\n" + "\n WITH vvd1 AS" //+ "\n (SELECT trd_cd" //+ "\n ,rlane_cd" //+ "\n ,ioc_cd" //+ "\n ,vsl_cd"
	 * //+ "\n ,skd_voy_no" //+ "\n ,dir_cd" //+ "\n ,cost_yrmon" //+ "\n ,cost_wk" //+ "\n FROM coa_mon_vvd" //+ "\n
	 * WHERE 1 = 1" //+ "\n AND delt_flg = 'N'" //+ "\n AND cost_yrmon BETWEEN ? AND ?" //+ "\n )" + "\n (SELECT trd_cd" +
	 * "\n ,rlane_cd" + "\n ,ioc_cd" + "\n ,vsl_cd" + "\n ,skd_voy_no" + "\n ,dir_cd" + "\n ,cost_yrmon" + "\n ,cost_wk" +
	 * "\n FROM coa_mon_vvd" + "\n WHERE 1 = 1" + "\n AND delt_flg = 'N'" + "\n AND SUBSTR (cost_yrmon, 0, 4) || cost_wk
	 * IN (" + "\n SELECT cost_yr || cost_wk" + "\n FROM coa_wk_prd" + "\n WHERE (cost_yr = TO_CHAR (SYSDATE, 'YYYY')" +
	 * "\n AND (TO_CHAR (SYSDATE - 70, 'YYYYMMDD') BETWEEN sls_fm_dt AND sls_to_dt))" + "\n OR (cost_yr = TO_CHAR
	 * (SYSDATE, 'YYYY')" + "\n AND (TO_CHAR (SYSDATE, 'YYYYMMDD') BETWEEN sls_fm_dt AND sls_to_dt)) " + "\n ))" + "\n
	 * SELECT trd_cd, rlane_cd, ioc_cd, vsl_cd, skd_voy_no, dir_cd, cost_yrmon, cost_wk FROM vvd1";
	 * 
	 * 
	 * con = getConnection(); // Loggable Statement 사용에 의해 추가 if
	 * (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) { ps = new
	 * LoggableStatement(con, queryStr); } else { ps = con.prepareStatement(queryStr); } // 쿼리에 변수 세팅. i = 1;
	 * //ps.setString(i++, DateTime.addMonths(currentYrmon, -1, "yyyyMM")); //ps.setString(i++, currentYrmon); //
	 * Loggable Statement 사용에 의해 추가 if
	 * (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) { log.info("\n SQL :" +
	 * ((LoggableStatement)ps).getQueryString()); } else { log.info("\n SQL :" + queryStr ); }
	 * 
	 * rs = ps.executeQuery(); // 결과를 DBRowset에 담는다. dRs = new DBRowSet(); //dRs.populate(rs); } catch (SQLException se) {
	 * log.error(se.getMessage(), se); throw new DAOException(new ErrorHandler(se).getMessage()); } catch (DAOException
	 * de) { log.error(de.getMessage(), de); throw de; } catch (Exception ex) { log.error(ex.getMessage(), ex); throw
	 * new DAOException(ex.getMessage()); } finally { closeResultSet(rs); closeStatement(ps); closeConnection(con); }
	 * return dRs; } 20070914임옥영
	 */
	
	/**
	 * MultiDimensionRPT의 데이타 모델에 해당되는 값을 불러온다.<br> - 사용 프로그램 : ESM_COA_072
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchLaneRgstList(RepoPfmcConditionVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MultiDimensionRPTDBDAOSearchLaneRgstListRSQL(), param, velParam);
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
	 * MultiDimensionRPT의 데이타 모델에 해당되는 값을 불러온다.<br> - 사용 프로그램 : ESM_COA_072
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchPfitLssRptItmList(RepoPfmcConditionVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();				
		
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MultiDimensionRPTDBDAOSearchPfitLssRptItmListRSQL(), param, velParam);
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
	 * P/L By Account<br>
	 * 사용 프로그램 : ESM_COA_072
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @param List<String> cols
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchWeeklySalesByOffice3TEUBased1List(RepoPfmcConditionVO vo, List<String> cols) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
						
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				//header 변수 세팅				
				velParam.put("allcols", cols);			
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MultiDimensionRPTDBDAOSearchWeeklySalesByOffice3TEUBased1ListRSQL(), param, velParam);
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
	 * P/L By Account<br>
	 * 사용 프로그램 : ESM_COA_072 - OP4
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @param List<String> cols
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchWeeklySalesByOffice3TEUBased1Op4List(RepoPfmcConditionVO vo, List<String> cols) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
						
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				//header 변수 세팅				
				velParam.put("allcols", cols);			
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MultiDimensionRPTDBDAOSearchWeeklySalesByOffice3TEUBased1Op4ListRSQL(), param, velParam);
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
	 * P/L By Account<br>
	 * 사용 프로그램 : ESM_COA_072 - OP5
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @param List<String> cols
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchWeeklySalesByOffice3TEUBased1Op5List(RepoPfmcConditionVO vo, List<String> cols) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
						
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				//header 변수 세팅				
				velParam.put("allcols", cols);			
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MultiDimensionRPTDBDAOSearchWeeklySalesByOffice3TEUBased1Op5ListRSQL(), param, velParam);
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
	 * P/L By Account<br>
	 * 사용 프로그램 : ESM_COA_072 - OP6
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @param List<String> cols
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchWeeklySalesByOffice3TEUBased1Op6List(RepoPfmcConditionVO vo, List<String> cols) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
						
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				//header 변수 세팅				
				velParam.put("allcols", cols);			
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MultiDimensionRPTDBDAOSearchWeeklySalesByOffice3TEUBased1Op6ListRSQL(), param, velParam);
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
	 * P/L By Lane/Bound <br>
	 * 사용 프로그램 : ESM_COA_072
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @param List<String> cols
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchWeeklySalesByOffice3TEUBased2List(RepoPfmcConditionVO vo, List<String> cols) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//header 변수 세팅				
				velParam.put("allcols", cols);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MultiDimensionRPTDBDAOSearchWeeklySalesByOffice3TEUBased2ListRSQL(), param, velParam);
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
	 * P/L By Lane/Bound <br>
	 * 사용 프로그램 : ESM_COA_072 - OP4
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @param List<String> cols
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchWeeklySalesByOffice3TEUBased2Op4List(RepoPfmcConditionVO vo, List<String> cols) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//header 변수 세팅				
				velParam.put("allcols", cols);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MultiDimensionRPTDBDAOSearchWeeklySalesByOffice3TEUBased2Op4ListRSQL(), param, velParam);
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
	 * P/L By Lane/Bound <br>
	 * 사용 프로그램 : ESM_COA_072 - OP5
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @param List<String> cols
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchWeeklySalesByOffice3TEUBased2Op5List(RepoPfmcConditionVO vo, List<String> cols) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//header 변수 세팅				
				velParam.put("allcols", cols);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MultiDimensionRPTDBDAOSearchWeeklySalesByOffice3TEUBased2Op5ListRSQL(), param, velParam);
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
	 * P/L By Lane/Bound <br>
	 * 사용 프로그램 : ESM_COA_072 - OP6
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @param List<String> cols
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchWeeklySalesByOffice3TEUBased2Op6List(RepoPfmcConditionVO vo, List<String> cols) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//header 변수 세팅				
				velParam.put("allcols", cols);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MultiDimensionRPTDBDAOSearchWeeklySalesByOffice3TEUBased2Op6ListRSQL(), param, velParam);
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
	 * P/L By Lane/Bound <br>
	 * 사용 프로그램 : ESM_COA_072
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @param List<String> cols
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchWeeklySalesByOffice3TEUBased3List(RepoPfmcConditionVO vo, List<String> cols) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//header 변수 세팅				
				velParam.put("allcols", cols);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MultiDimensionRPTDBDAOSearchWeeklySalesByOffice3TEUBased3ListRSQL(), param, velParam);
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
	 * P/L By Lane/Bound <br>
	 * 사용 프로그램 : ESM_COA_072 - OP4
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @param List<String> cols
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchWeeklySalesByOffice3TEUBased3Op4List(RepoPfmcConditionVO vo, List<String> cols) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//header 변수 세팅				
				velParam.put("allcols", cols);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MultiDimensionRPTDBDAOSearchWeeklySalesByOffice3TEUBased3Op4ListRSQL(), param, velParam);
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
	 * P/L By Lane/Bound <br>
	 * 사용 프로그램 : ESM_COA_072 - OP5
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @param List<String> cols
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchWeeklySalesByOffice3TEUBased3Op5List(RepoPfmcConditionVO vo, List<String> cols) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//header 변수 세팅				
				velParam.put("allcols", cols);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MultiDimensionRPTDBDAOSearchWeeklySalesByOffice3TEUBased3OP5ListRSQL(), param, velParam);
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
	 * P/L By Lane/Bound <br>
	 * 사용 프로그램 : ESM_COA_072 - OP6
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @param List<String> cols
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchWeeklySalesByOffice3TEUBased3Op6List(RepoPfmcConditionVO vo, List<String> cols) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//header 변수 세팅				
				velParam.put("allcols", cols);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MultiDimensionRPTDBDAOSearchWeeklySalesByOffice3TEUBased3Op6ListRSQL(), param, velParam);
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
	 * P/L By Lane/Bound <br>
	 * 사용 프로그램 : ESM_COA_072
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @param List<String> cols
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchWeeklySalesByOffice3TEUBased7List(RepoPfmcConditionVO vo, List<String> cols) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//header 변수 세팅				
				velParam.put("allcols", cols);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MultiDimensionRPTDBDAOSearchWeeklySalesByOffice3TEUBased7ListRSQL(), param, velParam);
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
	 * Adjusted P/L By VVD <br>
	 * 사용 프로그램 : ESM_COA_072
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @param List<String> cols
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchWeeklySalesByOffice3TEUBased8List(RepoPfmcConditionVO vo, List<String> cols) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//header 변수 세팅				
				velParam.put("allcols", cols);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MultiDimensionRPTDBDAOSearchWeeklySalesByOffice3TEUBased8ListRSQL(), param, velParam);
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
	 * Report view 의 목록을 가져온다.<br>
	 * ESM_COA_0130 조회
	 * @param SearchReportViewListVO searchReportViewListVO
	 * @return List<SearchReportViewListVO>
	 * @throws DAOException
	 */
	public List<SearchReportViewListVO> searchReportViewList(SearchReportViewListVO searchReportViewListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchReportViewListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchReportViewListVO != null){
				Map<String, String> mapVO = searchReportViewListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MultiDimensionRPTDBDAOSearchReportViewListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchReportViewListVO .class);
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
	 * COA_RPT_AUTH_MGMT 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(수정)<br>
	 * ESM_COA_0130 수정
	 * @param List<CoaRptAuthMgmtVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyMultiReportView(List<CoaRptAuthMgmtVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new MultiDimensionRPTDBDAOCoaRptAuthMgmtVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
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
		return updCnt;
	}
	
	/**
	 * IAS 협의체별 Scop 목록을 가져온다.<br>
	 * ESM_COA_0178 조회
	 * @param SearchIasSubCdListVO searchIasSubCdListVO
	 * @return List<SearchReportViewListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchIasSubCdListVO> searchIasSubCdList(SearchIasSubCdListVO searchIasSubCdListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchIasSubCdListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchIasSubCdListVO != null){
				Map<String, String> mapVO = searchIasSubCdListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MultiDimensionRPTDBDAOSearchIasSubCdListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchIasSubCdListVO .class);
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
	 * IAS 협의체별 Scop 수정한다.<br>
	 * ESM_COA_0178 수정
	 * @param SearchIasSubCdListVO vo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyIasSubCdList(SearchIasSubCdListVO vo) throws DAOException,Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new MultiDimensionRPTDBDAOSearchIasSubCdListVOUSQL(), param,velParam);
			if(updCnt== Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * IAS 협의체별 Scop 저장한다.<br>
	 * ESM_COA_0178 수정
	 * @param SearchIasSubCdListVO vo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addIasSubCdList(SearchIasSubCdListVO vo) throws DAOException,Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new MultiDimensionRPTDBDAOSearchIasSubCdListVOCSQL(), param,velParam);
			if(insCnt== Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * IAS 협의체별 Scop 삭제한다.<br>
	 * ESM_COA_0178 수정
	 * @param SearchIasSubCdListVO vo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeIasSubCdList(SearchIasSubCdListVO vo) throws DAOException,Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try { 
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int delCnt = sqlExe.executeUpdate((ISQLTemplate)new MultiDimensionRPTDBDAOSearchIasSubCdListVODSQL(), param,velParam);
			if(delCnt== Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * PL BATCH CREATE TABLE로부터 현재 BATCH의 STATUS를 알아본다.<br>

	 * @param  RepoPfmcConditionVO repoPfmcConditionVO
	 * @return List<CoaUtCostCreStsVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CoaUtCostCreStsVO> searchProfitLossCreationStatus(RepoPfmcConditionVO repoPfmcConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CoaUtCostCreStsVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(repoPfmcConditionVO != null){
				Map<String, String> mapVO = repoPfmcConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MultiDimensionRPTDBDAOsearchPLCreationStatusRSQL(), param, velParam);
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
	 * Adjusted P/L By Account<br>
	 * 사용 프로그램 : ESM_COA_072
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @param List<String> cols
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchWeeklySalesByOffice3TEUBased4List(RepoPfmcConditionVO vo, List<String> cols) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
						
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				//header 변수 세팅				
				velParam.put("allcols", cols);			
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MultiDimensionRPTDBDAOSearchWeeklySalesByOffice3TEUBased4ListRSQL(), param, velParam);
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
	 * Adjusted P/L By Account<br>
	 * 사용 프로그램 : ESM_COA_072
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @param List<String> cols
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchWeeklySalesByOffice3TEUBased4Op4List(RepoPfmcConditionVO vo, List<String> cols) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
						
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				//header 변수 세팅				
				velParam.put("allcols", cols);			
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MultiDimensionRPTDBDAOSearchWeeklySalesByOffice3TEUBased4Op4ListRSQL(), param, velParam);
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
	 * Adjusted P/L By Account<br>
	 * 사용 프로그램 : ESM_COA_072
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @param List<String> cols
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchWeeklySalesByOffice3TEUBased4Op5List(RepoPfmcConditionVO vo, List<String> cols) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
						
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				//header 변수 세팅				
				velParam.put("allcols", cols);			
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MultiDimensionRPTDBDAOSearchWeeklySalesByOffice3TEUBased4Op5ListRSQL(), param, velParam);
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
	 * Adjusted P/L By Account<br>
	 * 사용 프로그램 : ESM_COA_072
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @param List<String> cols
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchWeeklySalesByOffice3TEUBased4Op6List(RepoPfmcConditionVO vo, List<String> cols) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
						
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				//header 변수 세팅				
				velParam.put("allcols", cols);			
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MultiDimensionRPTDBDAOSearchWeeklySalesByOffice3TEUBased4Op6ListRSQL(), param, velParam);
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
	 * Adjusted P/L By Lane/Bound <br>
	 * 사용 프로그램 : ESM_COA_072
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @param List<String> cols
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchWeeklySalesByOffice3TEUBased5List(RepoPfmcConditionVO vo, List<String> cols) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//header 변수 세팅				
				velParam.put("allcols", cols);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MultiDimensionRPTDBDAOSearchWeeklySalesByOffice3TEUBased5ListRSQL(), param, velParam);
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
	 * Adjusted P/L By Lane/Bound <br>
	 * 사용 프로그램 : ESM_COA_072
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @param List<String> cols
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchWeeklySalesByOffice3TEUBased5Op4List(RepoPfmcConditionVO vo, List<String> cols) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//header 변수 세팅				
				velParam.put("allcols", cols);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MultiDimensionRPTDBDAOSearchWeeklySalesByOffice3TEUBased5Op4ListRSQL(), param, velParam);
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
	 * Adjusted P/L By Lane/Bound <br>
	 * 사용 프로그램 : ESM_COA_072
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @param List<String> cols
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchWeeklySalesByOffice3TEUBased5Op5List(RepoPfmcConditionVO vo, List<String> cols) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//header 변수 세팅				
				velParam.put("allcols", cols);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MultiDimensionRPTDBDAOSearchWeeklySalesByOffice3TEUBased5Op5ListRSQL(), param, velParam);
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
	 * Adjusted P/L By Lane/Bound <br>
	 * 사용 프로그램 : ESM_COA_072
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @param List<String> cols
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchWeeklySalesByOffice3TEUBased5Op6List(RepoPfmcConditionVO vo, List<String> cols) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//header 변수 세팅				
				velParam.put("allcols", cols);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MultiDimensionRPTDBDAOSearchWeeklySalesByOffice3TEUBased5Op6ListRSQL(), param, velParam);
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
	 * Adjusted P/L By Lane/Bound <br>
	 * 사용 프로그램 : ESM_COA_072
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @param List<String> cols
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchWeeklySalesByOffice3TEUBased6List(RepoPfmcConditionVO vo, List<String> cols) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//header 변수 세팅				
				velParam.put("allcols", cols);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MultiDimensionRPTDBDAOSearchWeeklySalesByOffice3TEUBased6ListRSQL(), param, velParam);
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
	 * Adjusted P/L By Lane/Bound <br>
	 * 사용 프로그램 : ESM_COA_072
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @param List<String> cols
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchWeeklySalesByOffice3TEUBased6Op4List(RepoPfmcConditionVO vo, List<String> cols) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//header 변수 세팅				
				velParam.put("allcols", cols);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MultiDimensionRPTDBDAOSearchWeeklySalesByOffice3TEUBased6Op4ListRSQL(), param, velParam);
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
	 * Adjusted P/L By Lane/Bound <br>
	 * 사용 프로그램 : ESM_COA_072
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @param List<String> cols
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchWeeklySalesByOffice3TEUBased6Op5List(RepoPfmcConditionVO vo, List<String> cols) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//header 변수 세팅				
				velParam.put("allcols", cols);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MultiDimensionRPTDBDAOSearchWeeklySalesByOffice3TEUBased6Op5ListRSQL(), param, velParam);
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
	 * Adjusted P/L By Lane/Bound <br>
	 * 사용 프로그램 : ESM_COA_072
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @param List<String> cols
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchWeeklySalesByOffice3TEUBased6Op6List(RepoPfmcConditionVO vo, List<String> cols) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//header 변수 세팅				
				velParam.put("allcols", cols);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MultiDimensionRPTDBDAOSearchWeeklySalesByOffice3TEUBased6Op6ListRSQL(), param, velParam);
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
	 * MultiDimensionRPT의 데이타 모델에 해당되는 값을 불러온다.<br> - 사용 프로그램 : ESM_COA_073
	 * 
	 * @param RepoPfmcConditionVO repoPfmcConditionVO
	 * @return List<SearchAdjCostDtlListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchAdjCostDtlListVO> searchAdjCostDetail(RepoPfmcConditionVO repoPfmcConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchAdjCostDtlListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(repoPfmcConditionVO != null){
				Map<String, String> mapVO = repoPfmcConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MultiDimensionRPTDBDAOSearchAdjCostDtlListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchAdjCostDtlListVO .class);
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
	 * MultiDimensionRPT의 데이타 모델에 해당되는 값을 불러온다.<br> - 사용 프로그램 : ESM_COA_073
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchCostSetUpListVO>
	 * @throws DAOException
	 */
	public List<SearchCostSetUpListVO> searchCostStupMTAbcList(SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchCostSetUpListVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MultiDimensionRPTDBDAOSearchCostStupMTAbcListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCostSetUpListVO .class);
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
	 * PNL BATCH status 를 생성한다. <br>
	 *
	 * @param RepoPfmcConditionVO repoPfmcConditionVO
	 * @throws DAOException
	 */
	public void addProfitLossSummaryBatchStatus(RepoPfmcConditionVO repoPfmcConditionVO) throws DAOException{
	     //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
        try{
        	if(repoPfmcConditionVO != null){
        		Map<String, String> mapVO = repoPfmcConditionVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
        	}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new MultiDimensionRPTDBDAOAddProfitLossSummaryBatchStatusCSQL(), param, velParam);
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
}
