/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : CommonDBDAO.java
 *@FileTitle : Common
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-10-11
 *@LastModifier : 김원섭 
 *@LastVersion : 1.0
 * 2006-10-11 김원섭
 * 1.0 최초 생성
 * 2008-06-03 서관영  
 * CSR : N200805290010 - Daily f'cast status 권한 조정 (SLCSC = > NYCRA레벨 상향)
 * UI별로 권한 부여로 인해서 searchOfficeCond 로직 수정 - SPC_SCR_OFC_CONV_FNC포함
 * 2008-09-22 임옥영 CSR:N200809109296
 *   -SPC_ORG_V를 SPC_ORGANIZATION_V로 변경(OFFICE적용완료)
 * 2008-10-10 임옥영 CSR:N200810070001
 *   -SINRS에 SELCDO와 동일한 권한 부여
 * 2008-12-22 서관영 CSR:N200812080001
 *   - SELSC시 SUB Office 팀코드별 조정
 * 2009-02-02 최윤성 CSR:N200901220015, N200901230007, N200901230010
 * - 조직 개편에 따른 로직 수정
 * 2009-04-13 최윤성 CSR:R200904100001
 * - SPC_SLS_REP_TEAM_IF 테이블 컬럼명 변경에 따른 로직 수정
 * 2010.08.23 최윤성 [CHM-201005492-01]RDR 실적 Summary 기능 개발 - Operator List 쿼리 추가
 * 2011.04.11 김종준 [CHM-201110033-01] ALPS/SPC의 TS booking status 기능보완 요청 
			 -searchContiCdComboList 메소드 추가 			 
* 2011.05.19 최성민 [CHM-201110711-01] Inquiry by Trade 화면 보완
* - TAGLIB를 MULTICOMBO로 변경작업하기 위한 메소드 추가
 * 2011.05.16 이석준 [CHM-201110710-01] Daily F"cast Status 화면 조건 추가
 *           - searchRhqComboList,searchRevLaneComboList Method 추가
 * 2011.06.07 김종준 [CHM-201110708-01] Daily F"cast Status Send Mail 화면 조건 추가
 *           - searchTradeComboList Method 추가 ,searchRevLaneComboList trdCd = in 조건으로 수정
 * 2011.07.1 Kim jong jun :[CHM-201111824] 소스 품질검토 결과 적용 .
 * 2011.07.26 김종준 [SRM-201118467] Daily F"cast Status 화면 alloc display 보완 searchUserRoleYn 메소드 추가       
 * 2011.11.10 김종준 [CHM-201114445-01] f"cast history 화면 RGN Office 창 활성화 searchUserRoleYn 화면명 세팅     
 * 2011.11.21 김종준 [CLT-111121290-01] R4J 패치 이후 발생한 결함 건 수정(Null dereference)
 * 2012.01.24 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
 * 2014.01.03 진마리아 [SRM-201341166] Yield Group의 확대
 * 2014.11.13 박은주 [CHM-201432794] SMP 사용 편의기능 보완 요청(RHQ 유효성 체크)
 * 2015.09.15 이혜민 [CHM-201537538] SMP 오류 수정 건 및 Sub Trade Add 기능 추가
 * 2015.11.10 이혜민 [CHM-201538774] NON SMP account FCST 의 Daily FCST 보완 요청
 =========================================================*/

package com.hanjin.apps.alps.esm.spc.common.common.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.spc.common.common.basic.CommonBCImpl;
import com.hanjin.apps.alps.esm.spc.common.common.vo.CommonCodeVO;
import com.hanjin.apps.alps.esm.spc.common.common.vo.SearchOfficeCondVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * alps-Common에 대한 DB 처리를 담당<br> - alps-Common Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 김원섭
 * @see CommonBCImpl 참조
 * @since J2EE 1.4
 */

public class CommonDBDAO extends DBDAOSupport {

	/**
	 * Trade List를 조회한다. <br>
	 * 
	 * @param del
	 * @param isRepTrade
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchTradeComboList(String del, boolean isRepTrade) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			velParam.put("methodname", "searchTradeComboList");
			
			param.put("del", del);
			velParam.put("isRepTrade", isRepTrade);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
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
	 * Sub Trade List를 조회한다. <br>
	 * 
	 * @param del
	 * @param isRepTrade
	 * @param isAll
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchSubTradeComboList(String del, boolean isRepTrade, boolean isAll) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			velParam.put("methodname", "searchSubTradeComboList");
			
			param.put("del", del);
			velParam.put("isRepTrade", isRepTrade);
			velParam.put("isAll", isAll);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
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
	 * Common의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param del
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchRLaneComboList(String del) throws DAOException {
		return searchRLaneComboList(del, false);
	}
	
	/**
	 * Lane List를 조회한다. <br>
	 * 
	 * @param del
	 * @param ipc
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchRLaneComboList(String del, boolean ipc) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			velParam.put("methodname", "searchRLaneComboList");
			
			param.put("del", del);
			velParam.put("ipc", ipc);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
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
	 * Lane List를 조회한다. <br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked") 
	public DBRowSet searchRLaneComboList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String del = (String) params.get("del");
		String ipc = (String) params.get("ipc");
		String isPus = params.get("isPus")==null?"":((String[])params.get("isPus"))[0];
		// 0207 SHKIM S
		String locSubTrdCd 	= params.get("locSubTrdCd")==null?"":((String[])params.get("locSubTrdCd"))[0];
		String locTrdCd 	= params.get("locTrdCd")   ==null?"":((String[])params.get("locTrdCd"))[0];
		// 0207 SHKIM E
		try {
			velParam.put("methodname", "searchRLaneComboList");
			param.put("del", del);
			// 0207 SHKIM S
			if(!locTrdCd.equals("")){
				param.put("locTrdCd", locTrdCd);
				velParam.put("locTrdCd", locTrdCd);
			}
			if(!locSubTrdCd.equals("")){
				param.put("locSubTrdCd", locSubTrdCd);
				velParam.put("locSubTrdCd", locSubTrdCd);
			}
			// 0207 SHKIM e
			velParam.put("ipc", ipc);
			velParam.put("isPus", isPus);
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
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
	 * Common의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param del
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchVesselSizeList(String del) throws DAOException {
		HashMap table = new HashMap();
		table.put("del", del);
		return searchVesselSizeList(table);
	}
	
	/**
	 * VesselSize List를 조회한다. <br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchVesselSizeList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String lane = getParameterValue(params, "lane");
		
		try {
			velParam.put("methodname", "searchVesselSizeList");
			
			param.put("lane", lane);
			velParam.put("lane", lane);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
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
	 * Customer List를 조회한다. <br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchCustAbbrNmList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String custCntCd = getParameterValue(params, "cust_cnt_cd");
		String custSeq   = getParameterValue(params, "cust_seq");
		
		try {
			velParam.put("methodname", "searchCustAbbrNmList");
			
			param.put("custCntCd", custCntCd);
			param.put("custSeq", custSeq);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
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
	 * Salse Office List를 조회한다. <br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchOfficeList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String ofcCd = getParameterValue(params, "ofc_cd");
		
		try {
			velParam.put("methodname", "searchOfficeList");
			
			param.put("ofcCd", ofcCd);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
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
	 * VVD List를 조회한다. <br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchVVDList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String vvdCd = getParameterValue(params, "vvd_cd");
		
		try {
			velParam.put("methodname", "searchVVDList");
			
			param.put("vvdCd", vvdCd);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
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
	 * Common Code List를 조회한다. <br>
	 * 
	 * @param code
	 * @param del
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchCommonCodeList(String code, String del) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			velParam.put("methodname", "searchCommonCodeList");
			
			param.put("code", code);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
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
	 * Common Code List를 조회한다. <br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchCommonCodeList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String code = getParameterValue(params, "codeNo");
		
		try {
			velParam.put("methodname", "searchCommonCodeList");
			
			param.put("code", code);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
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
	 * HashMap에 있는 key값을 조회한다.<br>
	 * 
	 * @param param
	 * @param key
	 * @param idx
	 * @return String
	 */
	@SuppressWarnings("unchecked")
	private String getParameterValue(HashMap param, String key, int idx) {
		String[] strs = ((String[]) param.get(key));
		if (strs == null)
			return "";
		if (strs.length <= idx)
			return "";
		return strs[idx];
	}

	/**
	 * HashMap에 있는 key값을 조회한다.<br>
	 * 
	 * @param param
	 * @param key
	 * @return String
	 */
	@SuppressWarnings("unchecked")
	private String getParameterValue(HashMap param, String key) {
		return getParameterValue(param, key, 0);
	}
	
	/**
	 * RHQ List를 조회한다. <br>
	 * 
	 * @param del
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchRHQComboList(String del) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			velParam.put("methodname", "searchRHQComboList");
			
			param.put("del", del);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
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
	 * AQ List를 조회한다. <br>
	 * 
	 * @param module
	 * @param rhq
	 * @param del
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchAQComboList(String module, String rhq, String del) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			velParam.put("methodname", "searchAQComboList");
			
			param.put("rhq", rhq);
			param.put("del", del);
			velParam.put("module", module);
			velParam.put("rhq", rhq);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
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
	 * Rgn Office List를 조회한다. <br>
	 * 
	 * @param module
	 * @param rhq
	 * @param del
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchRgnOfcComboList(String module, String rhq, String del) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			velParam.put("methodname", "searchRgnOfcComboList");
			
			param.put("rhq", rhq);
			param.put("del", del);
			velParam.put("module", module);
			velParam.put("rhq", rhq);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
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
	 * GAMer List를 조회한다. <br>
	 * 
	 * @param del
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchKAMerComboList(String del) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			velParam.put("methodname", "searchKAMerComboList");
			
			param.put("del", del);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
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
	 * Targer Group List를 조회한다. <br>
	 * 
	 * @param ofc
	 * @param del
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchTargetGroupComboList(String ofc, String del) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			velParam.put("methodname", "searchKAMerComboList");
			
			param.put("del", del);
			param.put("ofc", ofc);
			velParam.put("ofc", ofc);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
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
	 * Child Office List를 조회한다. <br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchChildOfficeList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String ofcCd         = getParameterValue(params, "ofc_cd");
		String loginUsrOfcCd = (String) params.get("login_usr_ofc_cd");
		Object level         = getParameterValue(params, "level");
		Object include       = getParameterValue(params, "include");
		
		try {
			velParam.put("methodname", "searchChildOfficeList");
			
			param.put("ofcCd", ofcCd);
			param.put("loginUsrOfcCd", loginUsrOfcCd);
			param.put("lvl", level);
			param.put("inc", include);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
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
	 * Contract Office List를 조회한다. <br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchCtrtOfficeList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String ofcCd         = getParameterValue(params, "ofc_cd");
		String loginUsrOfcCd = (String) params.get("login_usr_ofc_cd");
		String level         = getParameterValue(params, "level");
		String trade         = getParameterValue(params, "trade");
		String year          = getParameterValue(params, "year");
		String week          = getParameterValue(params, "week");
		String duration      = getParameterValue(params, "duration");
		
		try {
			velParam.put("methodname", "searchCtrtOfficeList");
			
			param.put("ofcCd", ofcCd);
			param.put("loginUsrOfcCd", loginUsrOfcCd);
			param.put("lvl", level);
			param.put("trade", trade);
			param.put("year", year);
			param.put("week", week);
			param.put("duration", duration);
			
			velParam.put("ofcCd", ofcCd);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
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
	 * Child Team Office List를 조회한다. <br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchChildTeamOfficeList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String ofcCd         = getParameterValue(params, "ofc_cd");
		String loginUsrOfcCd = (String) params.get("login_usr_ofc_cd");
		Object level         = getParameterValue(params, "level");
		Object include       = getParameterValue(params, "include");
		
		try {
			velParam.put("methodname", "searchChildTeamOfficeList");
			
			param.put("ofcCd", ofcCd);
			param.put("loginUsrOfcCd", loginUsrOfcCd);
			param.put("lvl", level);
			param.put("inc", include);
			velParam.put("ofcCd", ofcCd);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
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
	 * Salse Rep List를 조회한다. <br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchSalesRepList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String ofcCd         = getParameterValue(params, "ofc_cd");
		String loginUsrOfcCd = (String) params.get("login_usr_id");
		Object level         = getParameterValue(params, "level");
		
		try {
			velParam.put("methodname", "searchSalesRepList");
			
			param.put("ofcCd", ofcCd);
			param.put("loginUsrOfcCd", loginUsrOfcCd);
			param.put("lvl", level);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
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
	 * Team Salse Rep List를 조회한다. <br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchTeamSalesRepList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String ofcCd         = getParameterValue(params, "ofc_cd");
		String loginUsrOfcCd = (String) params.get("login_usr_id");
		Object level         = getParameterValue(params, "level");
		
		try {
			velParam.put("methodname", "searchTeamSalesRepList");
			
			param.put("ofcCd", ofcCd);
			param.put("loginUsrOfcCd", loginUsrOfcCd);
			param.put("lvl", level);
			velParam.put("ofcCd", ofcCd);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
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
	 * Contract Salse Rep List를 조회한다. <br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchCtrtSalesRepList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String trade    = getParameterValue(params, "trade");
		String ofcCd    = getParameterValue(params, "ofc_cd");
		String year     = getParameterValue(params, "year");
		String week     = getParameterValue(params, "week");
		String duration = getParameterValue(params, "duration");
		
		try {
			velParam.put("methodname", "searchCtrtSalesRepList");
			
			param.put("trade", trade);
			param.put("ofcCd", ofcCd);
			param.put("year", year);
			param.put("week", week);
			param.put("duration", duration);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
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
	 * Account List를 조회한다. <br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchAccountList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String srepCd   = getParameterValue(params, "srep_cd");
		String acctClss = getParameterValue(params, "acct_clss");
		String season   = getParameterValue(params, "season");
		String version  = getParameterValue(params, "version");
		String year     = getParameterValue(params, "year");
		String week     = getParameterValue(params, "week");
		String duration = getParameterValue(params, "duration");
		String trade    = getParameterValue(params, "trade");
		String grp      = getParameterValue(params, "grp");
		String ofcCd    = getParameterValue(params, "ofcCd");
		
		try {
			velParam.put("methodname", "searchAccountList");
			
			param.put("srepCd", srepCd);
			param.put("acctClss", acctClss);
			param.put("season", season);
			param.put("version", version);
			param.put("year", year);
			param.put("week", week);
			param.put("duration", duration);
			param.put("trade", trade);
			param.put("grp", grp);
			param.put("ofcCd", ofcCd);
			velParam.put("srepCd", srepCd);
			velParam.put("acctClss", acctClss);
			velParam.put("season", season);
			velParam.put("version", version);
			velParam.put("trade", trade);
			velParam.put("grp", grp);
			velParam.put("ofcCd", ofcCd);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
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
	 * Account List를 조회한다. <br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchNSmpAccountList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String year     = getParameterValue(params, "year");
		String week     = getParameterValue(params, "week");
		String duration = getParameterValue(params, "duration");
		String trade    = getParameterValue(params, "trade");
		String rhq		= getParameterValue(params, "rhqCd");
		String grp      = getParameterValue(params, "grp");
		
		try {
			velParam.put("methodname", "searchNSmpAccountList");
			
			param.put("rhq", rhq);
			param.put("year", year);
			param.put("week", week);
			param.put("duration", duration);
			param.put("trade", trade);
			param.put("grp", grp);
			velParam.put("rhq", rhq);
			velParam.put("trade", trade);
			velParam.put("grp", grp);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
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
	 * Account List를 조회한다. <br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchTradeAccountList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String srepCd   = getParameterValue(params, "srep_cd");
		String year     = getParameterValue(params, "year");
		String week     = getParameterValue(params, "week");
		String duration = getParameterValue(params, "duration");
		String trade    = getParameterValue(params, "trade");
		String grp      = getParameterValue(params, "grp");
		
		try {
			velParam.put("methodname", "searchTradeAccountList");
			
			param.put("srepCd", srepCd);
			param.put("year", year);
			param.put("week", week);
			param.put("duration", duration);
			param.put("trade", trade);
			param.put("grp", grp);
			velParam.put("srepCd", srepCd);
			velParam.put("trade", trade);
			velParam.put("grp", grp);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
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
	 * Port List를 조회한다. <br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchPortList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String portCd = getParameterValue(params, "port_cd");
		
		try {
			velParam.put("methodname", "searchPortList");
			
			param.put("portCd", portCd);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
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
	 * Yard List를 조회한다. <br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchYardList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String ofcCd  = getParameterValue(params, "ofc_cd");
		String yardCd = getParameterValue(params, "yard_cd");
		
		try {
			velParam.put("methodname", "searchYardList");
			
			param.put("ofcCd", ofcCd);
			param.put("yardCd", yardCd);
			velParam.put("ofcCd", ofcCd);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
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
	 * Operator List를 조회한다. <br>
	 * 
	 * 2010.08.23 최윤성 [CHM-201005492-01] RDR 실적 Summary 기능 개발 - Operator List 쿼리 추가
	 * 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchOperatorList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			velParam.put("methodname", "searchOperatorList");
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
			log.debug("Operator List : " + dRs.getRowCount());
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
	 * Season List를 조회한다. <br>
	 * 
	 * 2012.01.24 최윤성 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	 * 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchSeasonList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String trade  = getParameterValue(params, "trade");
		
		try {
			velParam.put("methodname", "searchSeasonList");
			
			param.put("trade", trade);
			velParam.put("trade", trade);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
			log.debug("Operator List : " + dRs.getRowCount());
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
	 * Season VersionList를 조회한다. <br>
	 * 
	 * 2012.01.24 최윤성 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	 * 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchSeasonVersionList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String season  = getParameterValue(params, "season");
		String trade  = getParameterValue(params, "trade");
		
		try {
			velParam.put("methodname", "searchSeasonVersionList");
			
			param.put("season", season);
			param.put("trade", trade);
			velParam.put("trade", trade);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
			log.debug("Operator List : " + dRs.getRowCount());
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param String ofc_cd
	 * @param String ui_name
	 * @return List<SearchOfficeCondVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchOfficeCondVO> searchOfficeCond(String ofc_cd, String ui_name) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchOfficeCondVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("ofc_cd", ofc_cd);
			param.put("ui_name", ui_name);
			velParam.put("ui_name", ui_name); 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchOfficeCondRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOfficeCondVO .class);
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
	 * ContiCd List를 조회한다. <br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException 
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchContiCdComboList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		
		try {
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchContiCdComboListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return dRs;
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * 콤보리스트를 조회한다. <br>
	 * 
	 * @param CommonCodeVO commonCodeVO
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchCommonComboList(CommonCodeVO commonCodeVO) throws DAOException {
		DBRowSet dbRowset = null;		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(commonCodeVO != null){
				Map<String, String> mapVO = commonCodeVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchComboListRSQL(), param, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dbRowset;
	}

	/**
	 * Revenue Lane List를 조회한다. <br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException 
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchRevLaneComboList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String multi_trdCd = params.get("trdCd").toString();
		String multi_subTrdCd = params.get("subTrdCd").toString();
		
		if(multi_trdCd != null && !multi_trdCd.equals("")){		// =포함 in 조건조회로 수정
			multi_trdCd = "'"+multi_trdCd.replaceAll(",", "','")+"'";
			params.put("trdCd", multi_trdCd);
		}	
		if(multi_subTrdCd != null && !multi_subTrdCd.equals("")){		// =포함 in 조건조회로 수정
			multi_subTrdCd = "'"+multi_subTrdCd.replaceAll(",", "','")+"'";
			params.put("subTrdCd", multi_subTrdCd);
		}	

		try {
			param.putAll(params);
			velParam.putAll(params);
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchRevLaneComboListRSQL(), param, velParam);
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
	 * RHQ List를 조회한다. <br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException 
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchRhqComboList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		 
		try {
			param.putAll(params);
			velParam.putAll(params);
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchRhqComboListRSQL(), param, velParam);
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
	 * Trade List를 조회한다. <br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException 
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchTradeComboList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			String isPus = params.get("isPus")==null?"":((String[])params.get("isPus"))[0];

			param.putAll(params);
			velParam.putAll(params);
			velParam.put("isPus", isPus);
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchTradeComboListRSQL(), param, velParam);
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
	 * Trade List를 조회한다. <br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException 
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchSubTradeComboList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String del        = (String) params.get("del");
		String isRepTrade = getParameterValue(params, "isRepTrade");
		String isAll      = getParameterValue(params, "isAll");
		String isPus      = getParameterValue(params, "isPus");
		String multi_trdCd = "";
		if ( params.get("trdCd") == null ) {
			multi_trdCd = "";
		} else {
			multi_trdCd = params.get("trdCd").toString();
		}
		String multi_subTrdCd = "";
		if ( params.get("multi_subTrdCd") == null ) {
			multi_subTrdCd = "";
		} else {
			params.get("subTrdCd").toString();
		}
		
		if(multi_trdCd != null && !multi_trdCd.equals("")){		// =포함 in 조건조회로 수정
			multi_trdCd = "'"+multi_trdCd.replaceAll(",", "','")+"'";
			params.put("trdCd", multi_trdCd);
			// 0207 SHKIM start
			if ( params.get("trdCd") != null && !params.get("trdCd").equals("")) {
				velParam.put("trdCd", multi_trdCd);	// SHKIM 
			}
			// 0207 SHKIM end
		}	
		if(multi_subTrdCd != null && !multi_subTrdCd.equals("")){		// =포함 in 조건조회로 수정
			multi_subTrdCd = "'"+multi_subTrdCd.replaceAll(",", "','")+"'";
			params.put("subTrdCd", multi_subTrdCd);
		}	
		param.put("del", del);
		velParam.put("isRepTrade", isRepTrade);
		velParam.put("isAll", isAll);
		velParam.put("isPus", isPus);
		try {
			param.putAll(params);
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchSubTradeComboListRSQL(), param, velParam);
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
	 * SPC01 유저 권한 체크한다.<br>
	 * 
	 * @param SignOnUserAccount account
	 * @param String ui_name
	 * @return List<SearchOfficeCondVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchOfficeCondVO> searchUserRoleYn(SignOnUserAccount account, String ui_name) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchOfficeCondVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("usr_id", account.getUsr_id());
			param.put("ofc_cd", account.getOfc_cd());
			param.put("usr_role_cd", "SPC01");
			param.put("ui_name", ui_name);
			
			velParam.put("usr_role_cd", "SPC01");
			velParam.put("ui_name", ui_name);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchUserRoleYnRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOfficeCondVO .class);
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
	 * Week List를 조회한다. <br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchWeekComboList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String year = getParameterValue(params, "year");
		
		try {
			velParam.put("methodname", "searchWeekComboList");
			
			param.put("year", year);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
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
	 * Week List를 조회한다. <br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchCurrWeekList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String date = getParameterValue(params, "date");
		
		try {
			velParam.put("methodname", "searchCurrWeekList");
			
			param.put("date", date);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
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
	 * Office Code 유무를 확인한다. <br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchCheckOfficeCodeList(HashMap params) throws DAOException {
		DBRowSet dRs   = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String ofcCd = getParameterValue(params, "ofc_cd");
		
		try {
			velParam.put("methodname", "searchCheckOfficeCodeList");
			
			param.put("ofcCd", ofcCd);
			velParam.put("ofcCd", ofcCd);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
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
	 * 입력된 항차 유무를 확인한다. <br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchCheckVVDList(HashMap params) throws DAOException {
		DBRowSet dRs   = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String vslCd    = getParameterValue(params, "vsl_cd");
		String skdVoyNo = getParameterValue(params, "skd_voy_no");
		String skdDirCd = getParameterValue(params, "skd_dir_cd");
		String iocCd    = getParameterValue(params, "ioc_cd");
		
		try {
			velParam.put("methodname", "searchCheckVVDList");
			
			param.put("vslCd", vslCd);
			param.put("skdVoyNo", skdVoyNo);
			param.put("skdDirCd", skdDirCd);
			param.put("iocCd", iocCd);
			velParam.put("vslCd", vslCd);
			velParam.put("skdVoyNo", skdVoyNo);
			velParam.put("skdDirCd", skdDirCd);
			velParam.put("iocCd", iocCd);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
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
	 * 입력된 항차의 Accout Group Control Option을 확인한다. <br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchCheckAcctGroupOptList(HashMap params) throws DAOException {
		DBRowSet dRs   = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String vslCd    = getParameterValue(params, "vsl_cd");
		String skdVoyNo = getParameterValue(params, "skd_voy_no");
		String skdDirCd = getParameterValue(params, "skd_dir_cd");
		
		try {
			velParam.put("methodname", "searchCheckAcctGroupOptList");
			
			param.put("vslCd", vslCd);
			param.put("skdVoyNo", skdVoyNo);
			param.put("skdDirCd", skdDirCd);
			velParam.put("vslCd", vslCd);
			velParam.put("skdVoyNo", skdVoyNo);
			velParam.put("skdDirCd", skdDirCd);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
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
	 * 입력된 VVD가 부산을 기항하는지 체크한다.
	 * @param vvd
	 * @return
	 * @throws EventException
	 */
	public boolean checkVvd(String vvd) throws DAOException {
		DBRowSet dbRowset = null;
		boolean chkVvd = false;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(vvd != null){
				param.put("vvd", vvd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOCheckVvdRSQL(), param, velParam);
			if(dbRowset.next()){
				String strRet = dbRowset.getString(1);
				chkVvd = strRet.equals("0") ? false : true;
			}
		} catch (SQLException ex) {
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return chkVvd;
	}	
	
	/**
	 * 입력한 OFC가 지정된 RHQ에 해당하는지 확인합니다.
	 * @param String slsRhqCd
	 * @param String slsRgnOfcCd
	 * @return 
	 * @throws EventException
	 */
	public boolean checkOfcRhq(String slsRhqCd, String slsRgnOfcCd) throws DAOException {
		DBRowSet dbRowset = null;
		boolean checkOfcRhq = false;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(slsRhqCd != null && slsRgnOfcCd != null){
				param.put("sls_rhq_cd", slsRhqCd);
				param.put("sls_rgn_ofc_cd", slsRgnOfcCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOCheckOfcRhqRSQL(), param, velParam);
			if(dbRowset.next()){
				String strRet = dbRowset.getString(1);
				checkOfcRhq = strRet.equals("0") ? false : true;
			}
		} catch (SQLException ex) {
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return checkOfcRhq;
	}
	
	/**
	 * 입력한 OFC가 지정된 RHQ에 해당하는지 확인합니다.
	 * @param String trdCd
	 * @param String subTrdCd
	 * @param String rlaneCd
	 * @return
	 * @throws EventException
	 */
	public boolean checkLaneTrd(String trdCd, String subTrdCd, String rlaneCd) throws DAOException {
		DBRowSet dbRowset = null;
		boolean checkOfcRhq = false;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(trdCd != null && subTrdCd != null && rlaneCd != null){
				param.put("trd_cd", trdCd);
				param.put("sub_trd_cd", subTrdCd);
				param.put("rlane_cd", rlaneCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOCheckLaneTrdRSQL(), param, velParam);
			if(dbRowset.next()){
				String strRet = dbRowset.getString(1);
				checkOfcRhq = strRet.equals("0") ? false : true;
			}
		} catch (SQLException ex) {
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return checkOfcRhq;
	}
	
	/**
	 * SMP용 role을 조회합니다.
	 * @param String usrId
	 * @return String[]
	 * @throws EventException
	 */
	public String[] searchSmpRole(String usrId) throws DAOException {
		DBRowSet dbRowset = null;
		String[] rtnArr = new String[3];
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			if(usrId != null){
				param.put("usr_id", usrId);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchSmpRoleRSQL(), param, null);
			if(dbRowset.next()){
				String spc01 = dbRowset.getString(1);
				String spc08 = dbRowset.getString(2);
				String spc09 = dbRowset.getString(3);
				rtnArr[0] = spc01;
				rtnArr[1] = spc08;
				rtnArr[2] = spc09;
			}
		} catch (SQLException ex) {
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return rtnArr;
	}
	
	/**
	 * 해당하는 Season의 customer control group을 확인한다. <br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchCustGrpList(HashMap params) throws DAOException {
		DBRowSet dRs   = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String trdCd    = getParameterValue(params, "trd_cd");
		String costYrwk = getParameterValue(params, "cost_yrwk");
		
		try {
			velParam.put("methodname", "searchCustGrpList");
			
			param.put("trdCd", trdCd);
			param.put("costYrwk", costYrwk);
			velParam.put("trdCd", trdCd);
			velParam.put("costYrwk", costYrwk);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
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
		 * Lane List를 조회한다. <br>
		 * 
		 * @param del
		 * @param isRepTrade
		 * @return DBRowSet
		 * @throws DAOException
		 */
		public DBRowSet searchSvcLaneComboList(String del, boolean isRepTrade) throws DAOException {
			DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			try {
				velParam.put("methodname", "searchSvcLaneComboList");
				
				param.put("del", del);
				velParam.put("isRepTrade", isRepTrade);
				
				dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
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
		 * Trade List를 조회한다. <br>
		 * 
		 * @param params
		 * @return DBRowSet
		 * @throws DAOException 
		 */
		@SuppressWarnings("unchecked")
		public DBRowSet searchSvcLaneComboList(HashMap params) throws DAOException {

			DBRowSet dRs   = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try {
				velParam.put("methodname", "searchSvcLaneComboList");

				dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
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
		 * RHQ의 유효성을 체크한다.
		 * @param String slsRhqCd
		 * @return boolean
		 * @throws EventException
		 */
		public boolean checkRhq(String slsRhqCd) throws DAOException {
			DBRowSet dbRowset = null;
			boolean checkRhq = false;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			try {
				if(slsRhqCd != null ){
					param.put("sls_rhq_cd", slsRhqCd);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOCheckRhqRSQL(), param, velParam);
				if(dbRowset.next()){
					String strRet = dbRowset.getString(1);
					checkRhq = strRet.equals("0") ? false : true;
				}
			} catch (SQLException ex) {
				//log.error(ex.getMessage(),ex);
				throw new DAOException(ex.getMessage(), ex);
			}catch(Exception ex){
				//log.error(ex.getMessage(),ex);
				throw new DAOException(ex.getMessage(), ex);
			}
			return checkRhq;
		}
		
		/**
		 * 입력한 Sub Trade의 유효성을 확인합니다.
		 * @param String trdCd
		 * @param String subTrdCd
		 * @return boolean
		 * @throws EventException
		 */
		public boolean checkSubTrdCd(String trdCd, String subTrdCd) throws DAOException {
			DBRowSet dbRowset = null;
			boolean checkSubTrdCd = false;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			try {
				if(trdCd != null ){
					param.put("trd_cd", trdCd);
					param.put("sub_trd_cd", subTrdCd);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOCheckSubTrdCdRSQL(), param, velParam);
				if(dbRowset.next()){
					String strRet = dbRowset.getString(1);
					checkSubTrdCd = strRet.equals("0") ? false : true;
				}
			} catch (SQLException ex) {
				//log.error(ex.getMessage(),ex);
				throw new DAOException(ex.getMessage(), ex);
			}catch(Exception ex){
				//log.error(ex.getMessage(),ex);
				throw new DAOException(ex.getMessage(), ex);
			}
			return checkSubTrdCd;
		}
}
