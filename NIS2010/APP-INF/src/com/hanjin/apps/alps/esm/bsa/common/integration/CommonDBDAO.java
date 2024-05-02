/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : CommonDBDAO.java
 *@FileTitle : BSA업무 공틍 
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
 * 2009.07.31 장영석 : checkBKGNo메서드에서  coa_bkg_info테이블에 bkg_no_split필드가 없기 때문에 필드 삭제        
 * 2009.09.17 남궁진호  CSR No.CHM-200900987 - searchBSAOpt : D3 Type추가에 따른 Order by 절 추가
 * 2010.06.21 이행지  - CHM-201004175 : 소스품질검토결과 적용(20100503)
 * 2010.10.04 이행지 [CHM-201005758-01] BSA  Architecture 위배사항 수정 (CommonSC)
 * 2011.07.15 이행지 [CHM-201112101-01] Currency Code 조회 추가
 * 2015.06.08 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
 =========================================================*/
package com.hanjin.apps.alps.esm.bsa.common.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import com.hanjin.apps.alps.esm.bsa.common.vo.ComboVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ENIS-BSA에 대한 DB 처리를 담당<br> - ENIS-BSA Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author eunju park
 * @see CommonBCImpl 참조
 * @since J2EE 1.4
 */
public class CommonDBDAO extends DBDAOSupport {	
	
	private static final long serialVersionUID = -6320099317281342613L;

	/**
	 * Trade콤보의 목록을 가져온다.<br>
	 * MDM_TRADE
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchTradeList() throws DAOException {
		DBRowSet dbRowset = new DBRowSet(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
				velParam.put("codeItem","trade");
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchComCodeListRSQL(), null, velParam);
			
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
	 * Sub Trade 정보를 가져온다.<br>
	 * MDM_SUB_TRD
	 * 
	 * @param String trdCd
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchSubTradeList(String trdCd) throws DAOException {
		DBRowSet dbRowset = new DBRowSet(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if (trdCd !=null){
				param.put("trd_cd",trdCd);
				velParam.put("codeItem","subTrade");
			}
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchComCodeListRSQL(), param, velParam);
			
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
	 * revenue lane의 정보를 가져온다.<br>
	 * MAS_LANE_RGST
	 * 
	 * @param String trdCd
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchRevLaneList(String trdCd) throws DAOException {
		DBRowSet dbRowset = new DBRowSet(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		String[] sTrd = null;
		String strTrdCd = "";
		String strSubTrdCd = "";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(trdCd != null){
				sTrd = trdCd.split(":", -1);
				
				strTrdCd = sTrd[0];
				
				if (sTrd.length > 1) {
					strSubTrdCd = sTrd[1];
				} else {
					strSubTrdCd = "";
				}	
				
				param.put("trd_cd",strTrdCd);
				param.put("sub_trd_cd",strSubTrdCd); 
				velParam.put("codeItem","rLane");
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchComCodeListRSQL(), param, velParam);
			
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
	 * IP를 제외한 revenue lane의 정보를 가져온다.<br>
	 * MAS_LANE_RGST
	 * 
	 * @param String trdCd
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchRLaneList4(String trdCd) throws DAOException {
		DBRowSet dbRowset = new DBRowSet(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if (trdCd !=null){
				param.put("trd_cd",trdCd);
				velParam.put("codeItem","rLane4");
			}
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchComCodeListRSQL(), param, velParam);
			
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
	 * BSA에서 사용하는 Option 항목을 가져온다.<br>
	 * MAS_BSA_OP_JB
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchBSAOpt() throws DAOException {
		DBRowSet dbRowset = new DBRowSet(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
				velParam.put("codeItem","optBSA");
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchComCodeListRSQL(), null, velParam);
			
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
	 * BSA Operation Job 목록을 조회한다..<br>
	 * BSA_OP_JB
	 * 
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchBsaOpJbList() throws DAOException {
		DBRowSet dbRowset = new DBRowSet(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			velParam.put("codeItem","bsaOpJb");
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchComCodeListRSQL(), null, velParam);
			
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
	 * Carrier(BSA) 항목을 가져온다.<br>
	 * 사용프로그램 : BSA시스템 사용 테이블 : BSA_CRR_RGST
	 * 
	 * @param String bsaOpCd
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchCarrierRgstBSA(String bsaOpCd) throws DAOException {
		DBRowSet dbRowset = new DBRowSet(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if (bsaOpCd !=null){
				param.put("bsa_op_cd",bsaOpCd);
				velParam.put("codeItem","BSACarrier");
			}
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchComCodeListRSQL(), param, velParam);
			
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
	 * 현재주보다 작은 주를 반환한다.<br>
	 * MAS_WK_PRD
	 * 
	 * @param String year
	 * @param String week
	 * @return String
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
				
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchBsaCommonRSQL(), param, velParam);
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
	 * VVD에 해당하는 etd date를 리턴한다.<br>
	 * vsk_vsl_port_skd
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchFirstEtd(String vslCd, String skdVoyNo, String skdDirCd) throws DAOException {
		String result = "";
		DBRowSet dbRowSet = null;
		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter

		try {
				param.put("vsl_cd"    ,vslCd);
				param.put("skd_voy_no"    ,skdVoyNo);
				param.put("skd_dir_cd"    ,skdDirCd);
				velParam.put("methodname", "searchFirstEtd");				
			
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchBsaCommonRSQL(), param, velParam);
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
	 * VSL CD에 해당하는 존재여부 리턴한다.<br>
	 * vsk_vsl_port_skd
	 * 
	 * @param String vslCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchVslCd(String vslCd) throws DAOException {
		String result = "";
		DBRowSet dbRowSet = null;
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		try {
			param.put("vsl_cd"    ,vslCd);
			velParam.put("methodname", "searchVslCd");				
			
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchBsaCommonRSQL(), param, velParam);
			if (dbRowSet != null) {
				while (dbRowSet.next()) {
					result = dbRowSet.getString("vsl_cd_cnt");
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
	 * @return String
	 * @throws DAOException
	 */
	public String searchPrevWkPrd() throws DAOException {
		String result = "";
		DBRowSet dbRowSet = null;

		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
				velParam.put("methodname", "searchPrevWkPrd");
				
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchBsaCommonRSQL(), null, velParam);
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
	 * Location Code 유무를 확인.<br>
	 * 
	 * @param String locCd
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet checkLocationCode(String locCd) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter		
			
			try {
				if(locCd != null){
					param.put("loccd"    ,locCd);
					velParam.put("methodname", "checkLocationCode");
				}
				
				dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchBsaCommonRSQL(), param, velParam);
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
	 * 
	 * @param ComboVO vo
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchDatePeriod(ComboVO vo) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		String gubun ="";
		String year = vo.getYear();
		String fmweek = vo.getFmWk();
		String fmmonth = vo.getFmMon();
		String toweek = vo.getToWk();
		String tomonth = vo.getToMon();
		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter	
		
		try {
			year = (year != null) ? year : "";
			fmweek = (fmweek != null) ? fmweek : "";
			fmmonth = (fmmonth != null) ? fmmonth : "";
			toweek = (toweek != null) ? toweek : "";
			tomonth = (tomonth != null) ? tomonth : "";
			gubun ="";
			
			if(vo != null){
				if(!year.equals("") && !fmmonth.equals("") && !tomonth.equals("") && !fmmonth.equals("") && !toweek.equals("")) {
					gubun = "4";
				}else if (!year.equals("") && !fmmonth.equals("") && !tomonth.equals("")) {
					gubun ="5";
				}else if(!year.equals("") && !fmweek.equals("") && !toweek.equals("")) {				
					gubun = "6";
				}
				param.put("year"    ,year);
				param.put("frmweek"    ,fmweek);
				param.put("frmmonth"    ,fmmonth);
				param.put("toweek"    ,toweek);
				param.put("tomonth"    ,tomonth);
				velParam.put("methodname", "searchDatePeriod");				
				velParam.put("gubun", gubun);
			}		
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchBsaCommonRSQL(), param, velParam);
		
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
	 * service lane의 정보를 가져온다.<br>
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
				velParam.put("codeItem", "sLane");
			}
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchComCodeListRSQL(), param, velParam);
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
	 * Currency의 정보를 가져온다.<br>
	 * 
	 * @param String curr_cd
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchCurrencyList(String curr_cd) throws DAOException {		
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter

		try {
			if(curr_cd != null){
				param.put("curr_cd"    ,curr_cd);
				velParam.put("curr_cd" ,curr_cd);
			}
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchCurrencyListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return dRs;
	}
}
