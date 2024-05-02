/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpacecontrolinquiryDBDAO.java
*@FileTitle : spacecontrolinquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 한상훈 
*@LastVersion : 1.0
* 2009.08.10 한상훈
* 1.0 Creation
* 2010.08.25 최윤성 [CHM-201005492-01] RDR 실적 Summary 기능 개발 - 2010년 시스템 개발 계획
* 2010.08.26 김민아 [CHM-201005553-01] RDR 실적 중 POL/POD 세부 Data Download 기능 개발 - 메소드 추가
* 2010.11.01 최윤성 [CHM-201006585-01] 2010년 연간개발계획 - full+empty L/F summary 화면 개발
* 2011.11.22 김종준 [CHM-201007116] Weekly L/F by POL/POD 화면 - 기능추가 개발
* 2011.05.20 이석준[CHM-201110710-01] Daily F"cast Status 화면 조건 추가
*                                    multi lane값이 선택되었을태 , 구분자를 query에 맞게 수정
* 2011.06.03 김종준 [CHM-201110708-01] F"cast 입력 요청 메세지 송부 기능 searchSendMessageList,searchSendMessageAddrList 추가
* 2011.08.26 이행지 [선처리] Change Office의 Allocation이 아니라 Orgin Office Data가 보여지도록 login id넘겨서 Org Office 사용하도록 쿼리 변경
* 2011.10.12 김종준 [CHM-201113896-01] Login Office가 ISTSC인 경우에는 Origin Office가 아닌 Login Office가 Loading Office와 일치할 경우 Alloc 이 조회될 수 있도록 수정 요청
* 2012.12.04 최윤성 [CHM-201221640-01] FCST&PFMC by ACCT 신규 탭 추가 
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2013.10.30 최윤성 [CHM-201327083-01] IPC Sector 판매 활성화 Tool 개발 - Space Utilization 화면 신규 개발 
* 2014.10.27 박은주 [CHM-201432467] Daily FCST Inquiry 보완 요청(BKG Status(RHQ)에 POR 추가)
* 2015.08.18 김성욱 소스품질보안 수정
* 2015.11.10 이혜민 [CHM-201538774] NON SMP account FCST 의 Daily FCST 보완 요청
* 2016.01.12 이혜민 [CHM-201539227] Daily FCST status _ Allocation status(HO) & Allocation status(RHQ) 기능추가
* 2016.05.27 이혜민 SELSC, TYOSC RHQ 독립분리
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.basic.SpacecontrolinquiryBCImpl;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.ETCVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.ExcelDownSpaceUtilizationLaneListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.ExcelDownSpaceUtilizationPortListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceAllocationControlFlagListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiry021AllocPortViewList5BySRepVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiry021AllocPortViewListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiry021FcastPortViewListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiry021PfmcRatioVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiry021SusrLaneViewListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiry058QtyListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiry058VVDInfoVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiry058VVDListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryConditionVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryContractorVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryCustomerListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryOfficeCustomerListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryOfficeListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryOfficeSalesOrgListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryPolPodListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryRDRDetailListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquirySalesOrgListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryTradeListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlLFSummaryDownVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlLFSummaryListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlRDRSummaryDownVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlRDRSummaryListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlTsVolumnListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceUtilizationListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchWeeklyLfByPolPodListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SendMailAddrListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SendMailListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchTsPlanGuideListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.SpcBsaMgmtVO;
import com.hanjin.syscommon.common.table.SpcTeamQtaRtoVO;
import com.hanjin.syscommon.common.table.SpcTgtVvdVO;


/**
 * ALPS SpacecontrolinquiryDBDAO <br>
 * - ALPS-Spacecontrolinquiry system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Han Sang Hoon
 * @see SpacecontrolinquiryBCImpl 참조 
 * @since J2EE 1.6
 */
public class SpacecontrolinquiryDBDAO extends DBDAOSupport {

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<SearchSpaceControlInquiry021FcastPortViewListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceControlInquiry021FcastPortViewListVO> searchSpaceControlInquiry021AllocLaneWeekList2(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceControlInquiry021FcastPortViewListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSpaceControlInquiryConditionVO != null){
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
			 
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAO021FcastPortViewListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlInquiry021FcastPortViewListVO .class);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<SearchSpaceControlInquiry021FcastPortViewListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceControlInquiry021FcastPortViewListVO> searchSpaceControlInquiry021AllocLaneWeekList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceControlInquiry021FcastPortViewListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSpaceControlInquiryConditionVO != null){
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAO021FcastPortViewListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlInquiry021FcastPortViewListVO .class);
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
	 * [ESM_SPC_0021] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<ETCVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ETCVO> searchETC (SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ETCVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(searchSpaceControlInquiryConditionVO != null){
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceControlInquiryDBDAOETCRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ETCVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return list;
		//return dbRowset;
	}
	/**
	 * [ESM_SPC_0021] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchETC2 (SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(searchSpaceControlInquiryConditionVO != null){
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceControlInquiryDBDAOETCRSQL(), param, velParam);
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
	 * [ESM_SPC_0021] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @param int isSHA
	 * @param int isSEL
	 * @param int isTYO
	 * @return List<SearchSpaceControlInquiry021FcastPortViewListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceControlInquiry021FcastPortViewListVO> searchSpaceControlInquiry021FcastPortViewList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO, int isSHA, int isSEL, int isTYO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceControlInquiry021FcastPortViewListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String is_sha = "";
		String is_sel = "";
		String is_tyo = "";
		try{
			
			if(searchSpaceControlInquiryConditionVO != null){	
				String multi_rlane = searchSpaceControlInquiryConditionVO.getRlane1();
				if(multi_rlane != null && !multi_rlane.equals("")){
					multi_rlane = "'"+multi_rlane.replaceAll(",", "','")+"'";
					searchSpaceControlInquiryConditionVO.setRlane1(multi_rlane);
				}	
				if(isSHA >= 0){
					is_sha = "Y";
				}else{
					is_sha = "N";
				}
				if(isSEL >= 0){
					is_sel = "Y";
				}else{
					is_sel = "N";
				}
				if(isTYO >= 0){
					is_tyo = "Y";
				}else{
					is_tyo = "N";
				}
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("is_sha", is_sha);
				velParam.put("is_sel", is_sel);
				velParam.put("is_tyo", is_tyo);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAO021FcastPortViewListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlInquiry021FcastPortViewListVO .class);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<SearchSpaceControlInquiry021FcastPortViewListVO>
	 * @throws DAOException
	 */
	public DBRowSet searchSpaceControlInquiry021FcastPortViewList2(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(searchSpaceControlInquiryConditionVO != null){			
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAO021FcastPortViewListRSQL(), param, velParam);
		
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<SearchSpaceControlInquiry021FcastPortViewListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceControlInquiry021FcastPortViewListVO> searchSpaceControlInquriyOfficeCond(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceControlInquiry021FcastPortViewListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSpaceControlInquiryConditionVO != null){
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAO021FcastPortViewListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlInquiry021FcastPortViewListVO .class);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<SearchSpaceControlInquiry021FcastPortViewListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceControlInquiry021FcastPortViewListVO> searchSpaceControlInquiry021FcastLaneWeekList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceControlInquiry021FcastPortViewListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSpaceControlInquiryConditionVO != null){
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAO021FcastPortViewListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlInquiry021FcastPortViewListVO .class);
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
	 * [ESM_SPC_0021] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @param account SignOnUserAccount
	 * @param String ui_name
	 * @param int isSHA
	 * @param int isSEL
	 * @param int isTYO
	 * @return List<SearchSpaceControlInquiry021FcastPortViewListVO>
	 * @throws DAOException
	 */
	public DBRowSet searchSpaceControlInquiry021AllocPortViewList2(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO, SignOnUserAccount account, String ui_name, int isSHA, int isSEL, int isTYO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String is_sha = "";
		String is_sel = "";
		String is_tyo = "";
		try{
			
			if(searchSpaceControlInquiryConditionVO != null){
				String multi_rlane = searchSpaceControlInquiryConditionVO.getRlane1();
				if(multi_rlane != null && !multi_rlane.equals("")){
					multi_rlane = "'"+multi_rlane.replaceAll(",", "','")+"'";
					searchSpaceControlInquiryConditionVO.setRlane1(multi_rlane);
				}	
				if(isSHA >= 0){
					is_sha = "Y";
				}else{
					is_sha = "N";
				}
				if(isSEL >= 0){
					is_sel = "Y";
				}else{
					is_sel = "N";
				}
				if(isTYO >= 0){
					is_tyo = "Y";
				}else{
					is_tyo = "N";
				}				
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				String ofc_cd = account.getOfc_cd();
				
//				if ((ofc_cd.equals("SLCSC"))||(ofc_cd.equals("PHXSA"))||(ofc_cd.equals("ATLSA"))) {
//					ofc_cd = "NYCRA"; 
//				}
				
				param.put("ofc_cd", ofc_cd);
				param.put("login_id", account.getUsr_id());
				param.put("ui_name", ui_name);
				
				velParam.put("ofc_cd", ofc_cd);
				velParam.put("is_sha", is_sha);
				velParam.put("is_sel", is_sel);
				velParam.put("is_tyo", is_tyo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAO021AllocPortViewList2RSQL(), param, velParam);			
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
	 * [ESM_SPC_0021] 정보를 [행위] 합니다.<br>
	 * SHKIM 20120613
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @param account SignOnUserAccount
	 * @param String ui_name
	 * @param int isSHA
	 * @param int isSEL
	 * @param int isTYO
	 * @return List<SearchSpaceControlInquiry021FcastPortViewListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceControlInquiry021AllocPortViewListVO> searchSpaceControlInquiry021AllocPortViewList3(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO, SignOnUserAccount account, String ui_name, int isSHA, int isSEL, int isTYO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceControlInquiry021AllocPortViewListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String checkSubOfc = "N";
		String is_sha = "";
		String is_sel = "";
		String is_tyo = "";
		try{
			if(searchSpaceControlInquiryConditionVO != null){
				String multi_rlane = searchSpaceControlInquiryConditionVO.getRlane1();
				if(multi_rlane != null && !multi_rlane.equals("")){
					multi_rlane = "'"+multi_rlane.replaceAll(",", "','")+"'";
					searchSpaceControlInquiryConditionVO.setRlane1(multi_rlane);
				}	
				
				checkSubOfc = searchSpaceControlInquiryConditionVO.getSubOffice();
				if(isSHA >= 0){
					is_sha = "Y";
				}else{
					is_sha = "N";
				}
				if(isSEL >= 0){
					is_sel = "Y";
				}else{
					is_sel = "N";
				}
				if(isTYO >= 0){
					is_tyo = "Y";
				}else{
					is_tyo = "N";
				}
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				String ofc_cd = account.getOfc_cd();
				
//				if ((ofc_cd.equals("SLCSC"))||(ofc_cd.equals("PHXSA"))||(ofc_cd.equals("ATLSA"))) {
//					ofc_cd = "NYCRA"; 
//				}
				
				param.put("ofc_cd", ofc_cd);
				param.put("login_id", account.getUsr_id());
				param.put("ui_name", ui_name);
				
				velParam.put("ofc_cd", ofc_cd);
				velParam.put("is_sha", is_sha);
				velParam.put("is_sel", is_sel);
				velParam.put("is_tyo", is_tyo);
			}
			if(checkSubOfc.equals("N")){
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAO021AllocPortViewList3RSQL(), param, velParam);
			}else if(checkSubOfc.equals("Y")){
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAO021AllocPortViewListRHQSubOfcRSQL(), param, velParam);
			}			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlInquiry021AllocPortViewListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		} 
		return list;
//		return dbRowset;
	}
	/**
	 * [ESM_SPC_0021] 정보를 [행위] 합니다.<br>
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @param account SignOnUserAccount
	 * @param String ui_name
	 * @param int isSHA
	 * @param int isSEL
	 * @param int isTYO
	 * @return List<SearchSpaceControlInquiry021FcastPortViewListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceControlInquiry021PfmcRatioVO> searchSpaceControlInquiry021PfmcRatio(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO, SignOnUserAccount account, String ui_name , int isSHA, int isSEL, int isTYO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceControlInquiry021PfmcRatioVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String is_sha = "";
		String is_sel = "";
		String is_tyo = "";
		try{
			if(searchSpaceControlInquiryConditionVO != null){
				String multi_rlane = searchSpaceControlInquiryConditionVO.getRlane1();
				if(multi_rlane != null && !multi_rlane.equals("")){
					multi_rlane = "'"+multi_rlane.replaceAll(",", "','")+"'";
					searchSpaceControlInquiryConditionVO.setRlane1(multi_rlane);
				}	
				if(isSHA >= 0){
					is_sha = "Y";
				}else{
					is_sha = "N";
				}
				if(isSEL >= 0){
					is_sel = "Y";
				}else{
					is_sel = "N";
				}
				if(isTYO >= 0){
					is_tyo = "Y";
				}else{
					is_tyo = "N";
				}
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				String ofc_cd = account.getOfc_cd();
				
//				if ((ofc_cd.equals("SLCSC"))||(ofc_cd.equals("PHXSA"))||(ofc_cd.equals("ATLSA"))) {
//					ofc_cd = "NYCRA"; 
//				}
				
				param.put("ofc_cd", ofc_cd);
				param.put("login_id", account.getUsr_id());
				param.put("ui_name", ui_name);
				
				velParam.put("ofc_cd", ofc_cd);
				velParam.put("is_sha", is_sha);
				velParam.put("is_sel", is_sel);
				velParam.put("is_tyo", is_tyo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAO21PfmcRatioRSQL(), param, velParam);	
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlInquiry021PfmcRatioVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		} 
		return list;
//		return dbRowset;
	}
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<SearchSpaceControlInquiry021FcastPortViewListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceControlInquiry021FcastPortViewListVO> searchSpaceControlInquiry021TradeList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceControlInquiry021FcastPortViewListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSpaceControlInquiryConditionVO != null){
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAO021FcastPortViewListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlInquiry021FcastPortViewListVO .class);
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
	 * [ESM_SPC_0021] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @param account SignOnUserAccount
	 * @param String ui_name
	 * @param int isSHA
	 * @param int isSEL
	 * @param int isTYO
	 * @return List<SearchSpaceControlInquiry021FcastPortViewListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceControlInquiry021AllocPortViewListVO> searchSpaceControlInquiry021AllocPortViewList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO, SignOnUserAccount account, String ui_name, int isSHA, int isSEL, int isTYO) throws DAOException {
		DBRowSet dbRowset = null; 
		List<SearchSpaceControlInquiry021AllocPortViewListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String checkSubOfc = "N";
		String is_sha = "";
		String is_sel = "";
		String is_tyo = "";
		try{
			if(searchSpaceControlInquiryConditionVO != null){
				String multi_rlane = searchSpaceControlInquiryConditionVO.getRlane1();
				if(multi_rlane != null && !multi_rlane.equals("")){
					multi_rlane = "'"+multi_rlane.replaceAll(",", "','")+"'";
					searchSpaceControlInquiryConditionVO.setRlane1(multi_rlane);
				}
				checkSubOfc = searchSpaceControlInquiryConditionVO.getSubOffice();
				
				if(isSHA >= 0){
					is_sha = "Y";
				}else{
					is_sha = "N";
				}
				if(isSEL >= 0){
					is_sel = "Y";
				}else{
					is_sel = "N";
				}
				if(isTYO >= 0){
					is_tyo = "Y";
				}else{
					is_tyo = "N";
				}
				
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				String ofc_cd = account.getOfc_cd();
				
				param.put("ofc_cd", ofc_cd);
				param.put("login_id", account.getUsr_id());
				param.put("ui_name", ui_name);
				velParam.put("ofc_cd", ofc_cd);
				velParam.put("is_sha", is_sha);
				velParam.put("is_sel", is_sel);
				velParam.put("is_tyo", is_tyo);
			}
			if(checkSubOfc.equals("N")){
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAO021AllocPortViewListRSQL(), param, velParam);
			}else if(checkSubOfc.equals("Y")){
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAO021AllocPortViewListHOSubOfcRSQL(), param, velParam);
			}

			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlInquiry021AllocPortViewListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
		//return dbRowset;
	}
	 
	/**
	 * [ESM_SPC_0021-SPC_USR_LANE_INFO] 정보를 [조회] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiry021SusrLaneViewListVO search021SusrLaneViewListVO
	 * @param account SignOnUserAccount
	 * @param String ui_name
	 * @return List<SearchSpaceControlInquiry021SusrLaneViewListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceControlInquiry021SusrLaneViewListVO> searchSpaceControlInquiry021SusrLaneViewList(SearchSpaceControlInquiry021SusrLaneViewListVO search021SusrLaneViewListVO, SignOnUserAccount account, String ui_name) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceControlInquiry021SusrLaneViewListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			if(search021SusrLaneViewListVO != null){
				String multi_rlane = search021SusrLaneViewListVO.getRlaneCd();
				if(multi_rlane != null && !multi_rlane.equals("")){
					multi_rlane = "'"+multi_rlane.replaceAll(",", "','")+"'";
					search021SusrLaneViewListVO.setRlaneCd(multi_rlane);
				}				
				Map<String, String> mapVO = search021SusrLaneViewListVO .getColumnValues();
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAO021SusrLaneViewListRSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlInquiry021SusrLaneViewListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
		//return dbRowset;
	}
	
	/**
	 * [ESM_SPC_0021-SPC_USR_LANE_INFO] 정보를 [삭제] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiry021SusrLaneViewListVO vo
	 * @param account SignOnUserAccount
	 * @param String ui_name
	 * @throws DAOException
	 */
	public void searchSpaceControlInquiry021SusrLaneDelete(SearchSpaceControlInquiry021SusrLaneViewListVO vo, SignOnUserAccount account, String ui_name) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);
				String localUserId = vo.getUsrId();
				if(localUserId != null && !localUserId.equals("")){
					param.put("usr_id", localUserId);
				}	
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt = 0;
			updCnt = sqlExe.executeUpdate((ISQLTemplate)new SpacecontrolinquiryDBDAO021SusrLaneDSQL(), param, param);
			if(updCnt== Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	 
	 
	/**
	 * [ESM_SPC_0021-SPC_USR_LANE_INFO] 정보를 [저장] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiry021SusrLaneViewListVO vo
	 * @param account SignOnUserAccount
	 * @param String ui_name
	 * @throws DAOException
	 */
	public void searchSpaceControlInquiry021SusrLaneCreate(SearchSpaceControlInquiry021SusrLaneViewListVO vo, SignOnUserAccount account, String ui_name) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt = 0;
			updCnt = sqlExe.executeUpdate((ISQLTemplate)new SpacecontrolinquiryDBDAO021SusrLaneCSQL(), param, null);
			if(updCnt== Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to create");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_SPC_0022] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<SearchSpaceControlInquiryTradeListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceControlInquiryTradeListVO> searchSpaceControlInquiryTradeList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceControlInquiryTradeListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSpaceControlInquiryConditionVO != null){
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOSearchSpaceControlInquiryTradeListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlInquiryTradeListVO .class);
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
	 * [ESM_SPC_0022] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<SearchSpaceControlInquirySalesOrgListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceControlInquirySalesOrgListVO> searchSpaceControlInquirySalesOrgList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceControlInquirySalesOrgListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSpaceControlInquiryConditionVO != null){
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOSearchSpaceControlInquirySalesOrgListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlInquirySalesOrgListVO .class);
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
	 * [ESM_SPC_0022] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<SearchSpaceControlInquiryPolPodListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceControlInquiryPolPodListVO> searchSpaceControlInquiryPolPodList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceControlInquiryPolPodListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSpaceControlInquiryConditionVO != null){
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOSearchSpaceControlInquiryPolPodListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlInquiryPolPodListVO .class);
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
	 * [ESM_SPC_0022] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<SearchSpaceControlInquiryCustomerListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceControlInquiryCustomerListVO> searchSpaceControlInquiryCustomerList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceControlInquiryCustomerListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSpaceControlInquiryConditionVO != null){
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOSearchSpaceControlInquiryCustomerListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlInquiryCustomerListVO .class);
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
	 * [ESM_SPC_0022] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<SearchSpaceControlInquiryContractorVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceControlInquiryContractorVO> searchSpaceControlInquiryContractor(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceControlInquiryContractorVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSpaceControlInquiryConditionVO != null){
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOSearchSpaceControlInquiryContractorVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlInquiryContractorVO .class);
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
	 * [ESM_SPC_0024] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchSpaceControlInquiryNoShowSummaryList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSpaceControlInquiryConditionVO != null){
				String[] rhqArr = searchSpaceControlInquiryConditionVO.getRhq().split(",");
				if(rhqArr.length == 2){
					String rhq  = rhqArr[0];
					String rhq2 = rhqArr[1];
					searchSpaceControlInquiryConditionVO.setRhq(rhq);
					searchSpaceControlInquiryConditionVO.setRhq2(rhq2);
				}
				
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOsearchSpaceControlInquiryNoShowSummaryListRSQL(), param, velParam);
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
	 * [ESM_SPC_0024] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchSpaceControlInquiryNoShowTradeList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSpaceControlInquiryConditionVO != null){
				String[] rhqArr = searchSpaceControlInquiryConditionVO.getRhq().split(",");
				
				if(rhqArr.length == 2){
					String rhq  = rhqArr[0];
					String rhq2 = rhqArr[1];
					searchSpaceControlInquiryConditionVO.setRhq(rhq);
					searchSpaceControlInquiryConditionVO.setRhq2(rhq2);
				}
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOsearchSpaceControlInquiryNoShowTradeListRSQL(), param, velParam);
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
	 * [ESM_SPC_0024] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchSpaceControlInquiryNoShowOfficeLaneList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSpaceControlInquiryConditionVO != null){
				String[] rhqArr = searchSpaceControlInquiryConditionVO.getRhq().split(",");
				if(rhqArr.length == 2){
					String rhq  = rhqArr[0];
					String rhq2 = rhqArr[1];
					searchSpaceControlInquiryConditionVO.setRhq(rhq);
					searchSpaceControlInquiryConditionVO.setRhq2(rhq2);
				}
				
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOsearchSpaceControlInquiryNoShowOfficeLaneListRSQL(), param, velParam);
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
	 * [ESM_SPC_0024] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchSpaceControlInquiryNoShowLaneOfficeList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSpaceControlInquiryConditionVO != null){
				String[] rhqArr = searchSpaceControlInquiryConditionVO.getRhq().split(",");
				if(rhqArr.length == 2){
					String rhq  = rhqArr[0];
					String rhq2 = rhqArr[1];
					searchSpaceControlInquiryConditionVO.setRhq(rhq);
					searchSpaceControlInquiryConditionVO.setRhq2(rhq2);
				}
				
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOsearchSpaceControlInquiryNoShowLaneOfficeListRSQL(), param, velParam);
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
	 * [ESM_SPC_0024] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchSpaceControlInquiryNoShowSubOfficeList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSpaceControlInquiryConditionVO != null){
				String[] rhqArr = searchSpaceControlInquiryConditionVO.getRhq().split(",");
				if(rhqArr.length == 2){
					String rhq  = rhqArr[0];
					String rhq2 = rhqArr[1];
					searchSpaceControlInquiryConditionVO.setRhq(rhq);
					searchSpaceControlInquiryConditionVO.setRhq2(rhq2);
				}
				
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOsearchSpaceControlInquiryNoShowSubOfficeListRSQL(), param, velParam);
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
	 * [ESM_SPC_0028] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<SearchSpaceControlInquiryOfficeListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceControlInquiryOfficeListVO> searchSpaceControlInquiryOfficeList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceControlInquiryOfficeListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSpaceControlInquiryConditionVO != null){
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOSearchSpaceControlInquiryOfficeListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlInquiryOfficeListVO .class);
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
	 * [ESM_SPC_0028] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<SearchSpaceAllocationControlFlagListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceAllocationControlFlagListVO> searchSpaceAllocationControlFlagList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceAllocationControlFlagListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSpaceControlInquiryConditionVO != null){
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOSearchSpaceAllocationControlFlagListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceAllocationControlFlagListVO .class);
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
	 * [ESM_SPC_0028] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<SearchSpaceControlInquiryOfficeSalesOrgListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceControlInquiryOfficeSalesOrgListVO> searchSpaceControlInquiryOfficeSalesOrgList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceControlInquiryOfficeSalesOrgListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSpaceControlInquiryConditionVO != null){
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOSearchSpaceControlInquiryOfficeSalesOrgListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlInquiryOfficeSalesOrgListVO .class);
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
	 * [ESM_SPC_0028] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<SearchSpaceControlInquiryOfficeCustomerListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceControlInquiryOfficeCustomerListVO> searchSpaceControlInquiryOfficeCustomerList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceControlInquiryOfficeCustomerListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSpaceControlInquiryConditionVO != null){
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOSearchSpaceControlInquiryOfficeCustomerListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlInquiryOfficeCustomerListVO .class);
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
	 * [ESM_SPC_0056] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<SearchSpaceControlTsVolumnListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceControlTsVolumnListVO> searchSpaceControlTsVolumnList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceControlTsVolumnListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSpaceControlInquiryConditionVO != null){
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOSearchSpaceControlTsVolumnListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlTsVolumnListVO .class);
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
	 * [ESM_SPC_0026] 정보를 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO 
	 * @return List<SearchSpaceControlInquiryListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceControlInquiryListVO> searchSpaceControlInquiryList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceControlInquiryListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO.getColumnValues();
			
				String vsl_cd = "";
				String skd_voy_no = "";
				String skd_dir_cd = "";
				String mnl_aloc_rmk = "";
				String ioc_ts_cd = "";
				String tgt_table = "SPC_ALOC_HIS";
				
				String ioc = mapVO.get("ioc");
				String salesOffice = mapVO.get("salesoffice");
				String subOffice = mapVO.get("suboffice");
				String vvd = mapVO.get("vvd");
				String acct_ctrl_opt = mapVO.get("acct_clss");
				
				if (ioc.length() == 5) {
					mnl_aloc_rmk = "3";
					ioc_ts_cd = "T";
				}
				
				if(salesOffice.length() > 0 && subOffice.length() == 0){
					mnl_aloc_rmk = "3";
				}
			    
				if(subOffice.length() > 0 && salesOffice.length() == 0){
					mnl_aloc_rmk = "1";
				}
				
				if(salesOffice.length() > 0 && subOffice.length() > 0  ){
					mnl_aloc_rmk = "1";
				}
				
				if(acct_ctrl_opt.equals("Y"))
					tgt_table = "SPC_ALOC_CUST_HIS";
				
				
				vsl_cd = vvd.substring(0, 4);
				skd_voy_no = vvd.substring(4, 8);
				skd_dir_cd = vvd.substring(8);
				
				
				
				String cond1 ="";
				String cond2 ="";
				String cond3 ="";
				
				if(salesOffice.length() > 0 && subOffice.length() == 0 && ioc.length() < 5){
					cond1 ="TRUE";
				}		
	
				if(subOffice.length() > 0 && salesOffice.length() == 0 && ioc.length() < 5 ){
					cond2 ="TRUE";
				}		

				if(salesOffice.length() > 0 && subOffice.length() > 0 && ioc.length() < 5 ){
					cond3 ="TRUE";
				}		
				
				param.put("vsl_cd",vsl_cd);
				param.put("skd_voy_no",skd_voy_no);
				param.put("skd_dir_cd",skd_dir_cd);
				param.put("mnl_aloc_rmk",mnl_aloc_rmk);
				param.put("ioc_ts_cd",ioc_ts_cd);
				param.put("sales_office",salesOffice);
				param.put("sub_office",subOffice);
				param.put("ioc",ioc);
				param.put("table",tgt_table);
			
				velParam.put("sales_office",salesOffice);
				velParam.put("sub_office",subOffice);
				velParam.put("ioc",ioc);
				velParam.put("cond1",cond1);
				velParam.put("cond2",cond2);
				velParam.put("cond3",cond3);
				velParam.put("table",tgt_table);
				
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceControlInquiryDBDAOSearchSpaceControlInquiryListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlInquiryListVO.class);
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
	 * [ESM_SPC_0080] 정보를 [행위] 합니다.<br>
	 * 
	 * 2010.08.25 최윤성 [CHM-201005492-01] RDR 실적 Summary 기능 개발 관련 메소드 추가
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchSpaceControlRDRSummaryListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceControlRDRSummaryListVO> searchSpaceControlRDRSummaryList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceControlRDRSummaryListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceControlInquiryDBDAOSearchSpaceControlRDRSummaryListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlRDRSummaryListVO .class);
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
	 * [ESM_SPC_0080] 정보를 [행위] 합니다.<br>
	 * 
	 * 2010.08.25 최윤성 [CHM-201005492-01] RDR 실적 Summary 기능 개발 관련 메소드 추가
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchSpaceControlRDRSummaryDownVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceControlRDRSummaryDownVO> searchSpaceControlRDRSummaryDown(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceControlRDRSummaryDownVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceControlInquiryDBDAOSearchSpaceControlRDRSummaryDownRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlRDRSummaryDownVO .class);
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
	 * [ESM_SPC_0080] 정보를 [행위] 합니다.<br>
	 * 
	 * 2010.08.25 최윤성 [CHM-201005492-01] RDR 실적 Summary 기능 개발 관련 메소드 추가
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<ETCVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ETCVO> searchETC (ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ETCVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceControlInquiryDBDAOETCRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ETCVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return list;
		//return dbRowset;
	}
	
	/*=====================================================================================
	 * 2010.08.26 김민아 [CHM-201005553-01] RDR 실적 중 POL/POD 세부 Data Download 조회 메소드 추가
	 *=====================================================================================*/
	/**
	 * [ESM_SPC_0081] 정보를 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO 
	 * @return List<SearchSpaceControlInquiryRDRDetailListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceControlInquiryRDRDetailListVO> searchSpaceControlInquiryRDRDetailList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceControlInquiryRDRDetailListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOSearchSpaceControlInquiryRDRDetailListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlInquiryRDRDetailListVO.class);
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
	 * [ESM_SPC_0082] 정보를 [행위] 합니다.<br>
	 * 
	 * 2010.11.01 최윤성 [CHM-201006585-01] 2010년 연간개발계획 - full+empty L/F summary 화면 개발
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchSpaceControlLFSummaryListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceControlLFSummaryListVO> searchSpaceControlLFSummaryList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceControlLFSummaryListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceControlInquiryDBDAOSearchSpaceControlLFSummaryListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlLFSummaryListVO .class);
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
	 * [ESM_SPC_0082] 정보를 [행위] 합니다.<br>
	 * 
	 * 2010.11.02 최윤성 [CHM-201006585-01] 2010년 연간개발계획 - full+empty L/F summary 화면 개발
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchSpaceControlLFSummaryDownVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceControlLFSummaryDownVO> searchSpaceControlLFSummaryDown(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceControlLFSummaryDownVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceControlInquiryDBDAOSearchSpaceControlLFSummaryDownRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlLFSummaryDownVO .class);
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
	 * [ESM_SPC_0083] 정보를 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO 
	 * @return List<SearchSpaceControlInquiryRDRDetailListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchWeeklyLfByPolPodListVO> searchWeeklyLfByPolPodList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchWeeklyLfByPolPodListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOSearchWeeklyLfByPolPodListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchWeeklyLfByPolPodListVO.class);
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
	* 현재주차을 기준으로 주차와,년월을 조회<br>
	* 
	* @param ConditionVO conditionVO
	* @return String
	* @exception DAOException
	*/
	@SuppressWarnings("unchecked")
	public List<SearchWeeklyLfByPolPodListVO> searchMonthWeekList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchWeeklyLfByPolPodListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOSearchMonthWeekListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchWeeklyLfByPolPodListVO.class);
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
	* VVD에 해당하는 주차와,년월을 조회<br>
	* 
	* @param ConditionVO conditionVO
	* @return String
	* @exception DAOException
	*/
	public String searchVvdCostYrwk(ConditionVO conditionVO)  throws DAOException {
		DBRowSet dbRowset = null;
		String costWk = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String,String> mapVO = new HashMap<String,String>();
			mapVO.put("vvd",conditionVO.getVvd());
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOSearchVvdCostYrwkRSQL(), param, velParam);
            while(dbRowset.next()){
            	costWk = dbRowset.getString(1);
            }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return costWk;
	}
	
	/**
	 * [ESM_SPC_0084] BSA INPUT DATA 조회 합니다.<br> 
	 * @param SpcBsaMgmtVO spcBsaMgmtVO
	 * @return List<SpcBsaMgmtVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SpcBsaMgmtVO> searchSpaceContorlInquiryBSA(SpcBsaMgmtVO spcBsaMgmtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SpcBsaMgmtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(spcBsaMgmtVO != null){
				Map<String, String> mapVO = spcBsaMgmtVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceControlInquiryDBDAOsearchSpaceControlInquiryBSARSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SpcBsaMgmtVO .class);
			
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
     * BSA INPUT DATA를 저장 합니다.<br> 
     * @param  List<SpcBsaMgmtVO>  spcBsaMgmtVOs
     * @throws DAOException
     * @throws Exception
     */
    public void addSpaceContorlInquiryBSA(List<SpcBsaMgmtVO> spcBsaMgmtVOs) throws DAOException  {
        try {        
			SQLExecuter sqlExe = new SQLExecuter("");			
			
            int insCnt[] = null;
            if(spcBsaMgmtVOs.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new SpacecontrolinquiryDBDAOSpcBsaMgmtCSQL(), spcBsaMgmtVOs, null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to Insert No"+ i + " SQL");
                }
            }
 
        } catch (SQLException se) {
	        log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }
    
    /**
     * BSA INPUT DATA를 수정 합니다.<br> 
     * @param  List<SpcBsaMgmtVO>  spcBsaMgmtVOs
     * @throws DAOException
     * @throws Exception
     */
	public void modifySpaceContorlInquiryBSA(List<SpcBsaMgmtVO> spcBsaMgmtVOs) throws DAOException {
		try {
			if(spcBsaMgmtVOs != null && spcBsaMgmtVOs.size() > 0) {

				Map<String, String> mapVO = new HashMap<String, String>();
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
		        //velocity parameter
		        Map<String, Object> velParam = new HashMap<String, Object>();
		        
				SQLExecuter sqlExe = new SQLExecuter("");
				int updCnt[] = null;
				for (int k = 0; k < spcBsaMgmtVOs.size(); k++) {
	                mapVO = spcBsaMgmtVOs.get(k).getColumnValues();
	                param.putAll(mapVO);
	                velParam.putAll(mapVO);
				}
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpacecontrolinquiryDBDAOSpcBsaMgmtUSQL(), spcBsaMgmtVOs, param, velParam);
				for (int i = 0; i < updCnt.length; i++) {
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
            }
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
    /**
     * BSA INPUT DATA를 삭제 합니다.<br> 
     * @param  List<SpcBsaMgmtVO>  spcBsaMgmtVOs
     * @throws DAOException
     * @throws Exception
     */
	public void removeSpaceContorlInquiryBSA(List<SpcBsaMgmtVO> spcBsaMgmtVOs) throws DAOException {
		try {
			if(spcBsaMgmtVOs != null && spcBsaMgmtVOs.size() > 0) {

				Map<String, String> mapVO = new HashMap<String, String>();
		        //velocity parameter;
		        Map<String, Object> velParam = new HashMap<String, Object>();
		        
				SQLExecuter sqlExe = new SQLExecuter("");
				int updCnt[] = null;
				for (int k = 0; k < spcBsaMgmtVOs.size(); k++) {
	                mapVO = spcBsaMgmtVOs.get(k).getColumnValues();
	                velParam.putAll(mapVO);
				}
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpacecontrolinquiryDBDAOSpcBsaMgmtDSQL(), spcBsaMgmtVOs, velParam);
				for (int i = 0; i < updCnt.length; i++) {
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
            }
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_SPC_0029] Daily Forecast Status 팝업 메일 보내기 리스트 조회<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<SendMailListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SendMailListVO> searchSendMailList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SendMailListVO> list = null;
		//query parameter
		Map<String, Object> params = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSpaceControlInquiryConditionVO != null){
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();

				String rhq = searchSpaceControlInquiryConditionVO.getRhq();
				String trade = searchSpaceControlInquiryConditionVO.getTrade();
				String bound = searchSpaceControlInquiryConditionVO.getBound();
				String subTrade = searchSpaceControlInquiryConditionVO.getSubtrade1();
				String lane = searchSpaceControlInquiryConditionVO.getRlane1();
				
				String rhqs[] = rhq.split(",");
				List rhqlist = new ArrayList(); // 이 배열을 인덱스로 사용하여 값을  넣을 리스트 생성
				for ( int i = 0; i < rhqs.length; i++){
					rhqlist.add(rhqs[i]);		 // item 갯수만큼 itemList에 공간 생성 
				}
				velParam.put("ilist", rhqlist);

				String trdCd[] = trade.split(",");
				List trdCdList = new ArrayList(); // 이 배열을 인덱스로 사용하여 값을  넣을 리스트 생성
				for ( int i = 0; i < trdCd.length; i++){
					trdCdList.add(trdCd[i]);		 // item 갯수만큼 itemList에 공간 생성 
				}
				velParam.put("trdCdlist", trdCdList);
				String bounds[] = bound.split(",");
				List boundList = new ArrayList(); // 이 배열을 인덱스로 사용하여 값을  넣을 리스트 생성
				for ( int i = 0; i < bounds.length; i++){
					if ( bounds[i].isEmpty() == false ) {
						boundList.add(bounds[i]);		 // item 갯수만큼 itemList에 공간 생성 
						continue;
					}
				}
				velParam.put("boundList", boundList);
				
				String subTrdCd[] = subTrade.split(",");
				List subTrdCdList = new ArrayList(); // 이 배열을 인덱스로 사용하여 값을  넣을 리스트 생성
				for ( int i = 0; i < subTrdCd.length; i++){
					if ( subTrdCd[i].isEmpty() == false ) {
						subTrdCdList.add(subTrdCd[i]);		 // item 갯수만큼 itemList에 공간 생성 
						continue;
					}
				}
				velParam.put("subTrdCdlist", subTrdCdList);

				String rlane[] = lane.split(",");
				List rlaneList = new ArrayList(); // 이 배열을 인덱스로 사용하여 값을  넣을 리스트 생성
				for ( int i = 0; i < rlane.length; i++){
					if ( rlane[i].isEmpty() == false ) {
						rlaneList.add(rlane[i]);		 // item 갯수만큼 itemList에 공간 생성 
						continue;
					}					
				}
				velParam.put("rlaneList", rlaneList); 
				
				params.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOSendMailListRSQL(), params, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SendMailListVO .class);
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
	 * [ESM_SPC_0029] Daily Forecast Status 팝업 메일 보내기 리스트시 오피스별 메일주소 정보 조회.<br>
	 * 
	 * @param  String slsOfcCd
	 * @return List<SendMailAddrListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SendMailAddrListVO> searchSendMailAddrList(String slsOfcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SendMailAddrListVO> list = null;
		//query parameter
		Map<String, Object> params = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(slsOfcCd != null){
				params.put("slsOfcCd", slsOfcCd);
				velParam.put("slsOfcCd", slsOfcCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOSendMailAddrListRSQL(), params, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SendMailAddrListVO .class);
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
	 * [ESM_SPC_0021] 정보를 [행위] 합니다.<br>
	 * SHKIM 20120613
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @param account SignOnUserAccount
	 * @param String ui_name
	 * @param int isSHA
	 * @param int isSEL
	 * @param int isTYO
	 * @return List<SearchSpaceControlInquiry021FcastPortViewListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceControlInquiry021AllocPortViewListVO> searchSpaceControlInquiry021AllocPortViewList4(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO, SignOnUserAccount account, String ui_name , int isSHA, int isSEL, int isTYO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceControlInquiry021AllocPortViewListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String is_sha = "";
		String is_sel = "";
		String is_tyo = "";
		try{
			if(searchSpaceControlInquiryConditionVO != null){
				String multi_rlane = searchSpaceControlInquiryConditionVO.getRlane1();
				if(multi_rlane != null && !multi_rlane.equals("")){
					multi_rlane = "'"+multi_rlane.replaceAll(",", "','")+"'";
					searchSpaceControlInquiryConditionVO.setRlane1(multi_rlane);
				}	
				if(isSHA >= 0){
					is_sha = "Y";
				}else{
					is_sha = "N";
				}
				if(isSEL >= 0){
					is_sel = "Y";
				}else{
					is_sel = "N";
				}
				if(isTYO >= 0){
					is_tyo = "Y";
				}else{
					is_tyo = "N";
				}				
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				String ofc_cd = account.getOfc_cd();
								
				param.put("ofc_cd", ofc_cd);
				param.put("login_id", account.getUsr_id());
				param.put("ui_name", ui_name);
				
				velParam.put("ofc_cd", ofc_cd);
				velParam.put("is_sha", is_sha);
				velParam.put("is_sel", is_sel);
				velParam.put("is_tyo", is_tyo);
//				log.debug("\n dbdao searchSpaceControlInquiryConditionVO Viewdiv=" +  searchSpaceControlInquiryConditionVO.getViewDiv());			
				 if(searchSpaceControlInquiryConditionVO.getViewDiv() != null && "PORT".equals( searchSpaceControlInquiryConditionVO.getViewDiv())) {
//					 log.debug("\n dbdao searchSpaceControlInquiryConditionVO DelCd=" +  searchSpaceControlInquiryConditionVO.getDelCd());			
//					 log.debug("\n dbdao searchSpaceControlInquiryConditionVO PorCd=" +  searchSpaceControlInquiryConditionVO.getPorCd());
					 if( searchSpaceControlInquiryConditionVO.getDelCd() != null ) {
						 param.put("del_cd", searchSpaceControlInquiryConditionVO.getDelCd());
						 velParam.put("del_cd", searchSpaceControlInquiryConditionVO.getDelCd());
					 }
					 
					 if( searchSpaceControlInquiryConditionVO.getPorCd() != null ) {
						 param.put("por_cd", searchSpaceControlInquiryConditionVO.getPorCd());
						 velParam.put("por_cd", searchSpaceControlInquiryConditionVO.getPorCd());
					 }
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAO021AllocPortViewList4ByPortRSQL(),   param, velParam);	
				 }
				 else{
					 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAO021AllocPortViewList4ByOfficeRSQL(), param, velParam);	 
				 }
			}
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlInquiry021AllocPortViewListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		} 
		return list;
//		return dbRowset;
	}
	
	/**
	 * [ESM_SPC_0021] 정보를 [행위] 합니다.<br>
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @param account SignOnUserAccount
	 * @param String ui_name
	 * @return List<SearchSpaceControlInquiry021AllocPortViewList5BySRepVO>
	 * @throws DAOException
	 */
	public List<SearchSpaceControlInquiry021AllocPortViewList5BySRepVO> searchSpaceControlInquiry021AllocPortViewList5(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO,SignOnUserAccount account, String ui_name) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceControlInquiry021AllocPortViewList5BySRepVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSpaceControlInquiryConditionVO != null){
				String multi_trd = searchSpaceControlInquiryConditionVO.getTrade7();
				String multi_rlane = searchSpaceControlInquiryConditionVO.getRlane7();
				if(multi_trd != null && !multi_trd.equals("")){
					multi_trd = "'"+multi_trd.replaceAll(",", "','")+"'";
					searchSpaceControlInquiryConditionVO.setTrade7(multi_trd);
				}	
				if(multi_rlane != null && !multi_rlane.equals("")){
					multi_rlane = "'"+multi_rlane.replaceAll(",", "','")+"'";
					searchSpaceControlInquiryConditionVO.setRlane7(multi_rlane);
				}	
								
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				String ofc_cd = account.getOfc_cd();
				
				param.put("ofc_cd", ofc_cd);
				param.put("login_id", account.getUsr_id());
				param.put("ui_name", ui_name);
				
				velParam.put("ofc_cd", ofc_cd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAO021AllocPortViewList5BySRepRSQL(), param, velParam);	
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlInquiry021AllocPortViewList5BySRepVO .class);
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
	 * ESM_SPC_0086 : [Save] <br>
	 * 	Report에서 조회할 VVD List를 조회한다.
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<SpcTgtVvdVO>
	 * @throws DAOException
	 */
	public List<SpcTgtVvdVO> searchSpcTgtVvdList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SpcTgtVvdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSpaceControlInquiryConditionVO != null){
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAO021SpcTgtVvdListRSQL(), param, velParam);	
			log.debug("End Query");
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SpcTgtVvdVO .class);
			log.debug("End List - " + list.size());
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
	 * ESM_SPC_0086 : [Save] 
	 *  Report에서 조회할 VVD List를 저장한다.
	 *  
	 * @param List<SpcTgtVvdVO> spcTgtVvdVOs	 * 
	 * @throws DAOException
	 */
	public void addSpcTgtVvdList(List<SpcTgtVvdVO> spcTgtVvdVOs) throws DAOException {
		try {        
			SQLExecuter sqlExe = new SQLExecuter("");			
			
            int insCnt[] = null;
            if(spcTgtVvdVOs.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new SpacecontrolinquiryDBDAOSpcTgtVvdCSQL(), spcTgtVvdVOs, null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to Insert No"+ i + " SQL");
                }
            }
 
        } catch (SQLException se) {
	        log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
		
	}
	
	/**
	 * ESM_SPC_0086 : [Save] 
	 *  기존에 입력된 VVD List를 삭제한다.
	 *  
	 * @param List<SpcTgtVvdVO> spcTgtVvdVOs
	 * @throws DAOException
	 */
	public void removeSpcTgtVvdList(List<SpcTgtVvdVO> spcTgtVvdVOs) throws DAOException {
		try {  
			if(spcTgtVvdVOs != null && spcTgtVvdVOs.size() > 0) {
				Map<String, String> mapVO = new HashMap<String, String>();
				//velocity parameter
		        Map<String, Object> velParam = new HashMap<String, Object>();
	         
				SQLExecuter sqlExe = new SQLExecuter("");			
				int delCnt[] = null;
	            if(spcTgtVvdVOs.size() > 0){
	            	if (spcTgtVvdVOs.size() > 0) {
		                mapVO = spcTgtVvdVOs.get(0).getColumnValues();
		                //param.putAll(mapVO);
		                velParam.putAll(mapVO);
					}
	            	delCnt = sqlExe.executeBatch((ISQLTemplate)new SpacecontrolinquiryDBDAOSpcTgtVvdDSQL(), spcTgtVvdVOs, velParam);
	            	for (int i = 0; i < delCnt.length; i++) {
						if(delCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to update No"+ i + " SQL");
					} 
	            }
			}
 
        } catch (SQLException se) {
	        log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
	}
	

	/**
	 * ESM_SPC_0085 : [Save] 
	 *  한국지점 팀별 QTA RATIO를 생성한다.
	 *  
	 * @param List<SpcTeamQtaRtoVO> spcTeamQtaRtoVOs
	 * @throws DAOException
	 */
	public void addSpcTeamQtaRtos(List<SpcTeamQtaRtoVO> spcTeamQtaRtoVOs) throws DAOException {
		try {        
			SQLExecuter sqlExe = new SQLExecuter("");			
			
            int insCnt[] = null;
            if(spcTeamQtaRtoVOs.size() > 0){
            	insCnt = sqlExe.executeBatch((ISQLTemplate)new SpacecontrolinquiryDBDAOSpcTeamQtaRaioCSQL(), spcTeamQtaRtoVOs, null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to Insert No"+ i + " SQL");
                }
            }
 
        } catch (SQLException se) {
	        log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
	}
	
	/**
	 * ESM_SPC_0085 : [Save] 
	 *  한국지점 팀별 QTA RATIO를 수정한다.
	 *  
	 * @param List<SpcTeamQtaRtoVO> spcTeamQtaRtoVOs
	 * @throws DAOException
	 */
	public void modifySpcTeamQtaRtos(List<SpcTeamQtaRtoVO> spcTeamQtaRtoVOs) throws DAOException {
		try {   
			
			if(spcTeamQtaRtoVOs != null && spcTeamQtaRtoVOs.size() > 0) {

				Map<String, String> mapVO = new HashMap<String, String>();
				
				
		        //velocity parameter
		        Map<String, Object> velParam = new HashMap<String, Object>();
		        
				SQLExecuter sqlExe = new SQLExecuter("");
				int updCnt[] = null;
				
				if(spcTeamQtaRtoVOs.size() > 0) {
	                mapVO = spcTeamQtaRtoVOs.get(0).getColumnValues();
	                //param.putAll(mapVO);
	                velParam.putAll(mapVO);
				}
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpacecontrolinquiryDBDAOSpcTeamQtaRatioUSQL(), spcTeamQtaRtoVOs, velParam);
				for (int i = 0; i < updCnt.length; i++) {
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_SPC_0085 : [Save] 
	 *  한국지점 팀별 QTA RATIO를 삭제한다.
	 *  
	 * @param List<SpcTeamQtaRtoVO> spcTeamQtaRtoVOs
	 * @throws DAOException
	 */
	public void removeSpcTeamQtaRtos(List<SpcTeamQtaRtoVO> spcTeamQtaRtoVOs) throws DAOException {
		try {        
			if(spcTeamQtaRtoVOs != null && spcTeamQtaRtoVOs.size() > 0) {

				Map<String, String> mapVO = new HashMap<String, String>();
				
				
		        //velocity parameter
		        Map<String, Object> velParam = new HashMap<String, Object>();
		        
				SQLExecuter sqlExe = new SQLExecuter("");
				int delCnt[] = null;
				if (spcTeamQtaRtoVOs.size() > 0) {
	                mapVO = spcTeamQtaRtoVOs.get(0).getColumnValues();
	                //param.putAll(mapVO);
	                velParam.putAll(mapVO);
				}
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SpacecontrolinquiryDBDAOSpcTeamQtaRatioDSQL(), spcTeamQtaRtoVOs, velParam);
				for (int i = 0; i < delCnt.length; i++) {
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}  
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_SPC_0085 : [Retrieve] 
	 *  한국지점 팀별 QTA RATIO를 조회한다.
	 *  
	 * @param ConditionVO conditionVO
	 * @return List<SpcTeamQtaRtoVO>
	 * @throws DAOException
	 */
	public List<SpcTeamQtaRtoVO> searchSpcTeamQtaRtoList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SpcTeamQtaRtoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//소스 보안 관련 수정
				if( conditionVO.getType() != null )
					if( "Q".equals( conditionVO.getType()) )
						dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAO021SpcTeamQtaRtoRSQL(), param, velParam);
					else
						dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAO021SpcTeamQtaRtoByVvdRSQL(), param, velParam);
				else
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAO021SpcTeamQtaRtoByVvdRSQL(), param, velParam);	
			}
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SpcTeamQtaRtoVO .class);
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
	 * [ESM_SPC_0021] 정보를 [행위] 합니다.<br>
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @param account SignOnUserAccount
	 * @param String ui_name
	 * @return List<SearchSpaceControlInquiry021AllocPortViewListVO>
	 * @throws DAOException
	 */
	public List<SearchSpaceControlInquiry021AllocPortViewListVO> searchSpaceControlInquiry021AllocPortViewList6(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO,SignOnUserAccount account, String ui_name) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceControlInquiry021AllocPortViewListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSpaceControlInquiryConditionVO != null){
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				String ofc_cd = account.getOfc_cd();
				
				param.put("ofc_cd", ofc_cd);
				param.put("login_id", account.getUsr_id());
				param.put("ui_name", ui_name);
				
				velParam.put("ofc_cd", ofc_cd);
				
				//소스 보안 관련 수정
				if(searchSpaceControlInquiryConditionVO.getViewDiv()!=null ){
					if( "S".equals( searchSpaceControlInquiryConditionVO.getViewDiv()) )
						dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAO021AllocPortViewList6ByPreRSQL(), param, velParam);	
					else if("T".equals( searchSpaceControlInquiryConditionVO.getViewDiv()))
						dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAO021AllocPortViewList6ByTeamRSQL(), param, velParam);	
					else
						dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAO021AllocPortViewList6ByNextRSQL(), param, velParam);
				}else
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAO021AllocPortViewList6ByNextRSQL(), param, velParam);
			}
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlInquiry021AllocPortViewListVO .class);			
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
	 * [ESM_SPC_0021] 정보를 [행위] 합니다.<br>
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @param account SignOnUserAccount
	 * @param int isSHA
	 * @param int isSEL
	 * @param int isTYO
	 * @return List<SearchSpaceControlInquiry021AllocPortViewListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceControlInquiry021AllocPortViewListVO> searchSpaceControlInquiry021FcstPfmcAcctViewList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO,SignOnUserAccount account , int isSHA, int isSEL, int isTYO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceControlInquiry021AllocPortViewListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String is_sha = "";
		String is_sel = "";
		String is_tyo = "";
		try{
			if(searchSpaceControlInquiryConditionVO != null){
				String multi_rlane = searchSpaceControlInquiryConditionVO.getRlane1();
				if(multi_rlane != null && !multi_rlane.equals("")){
					multi_rlane = "'"+multi_rlane.replaceAll(",", "','")+"'";
					searchSpaceControlInquiryConditionVO.setRlane1(multi_rlane);
				}
				String multi_grp_acct = searchSpaceControlInquiryConditionVO.getGrpAcct();
				if(multi_grp_acct != null && !multi_grp_acct.equals("")){
					multi_grp_acct = "'"+multi_grp_acct.replaceAll(",", "','")+"'";
					searchSpaceControlInquiryConditionVO.setGrpAcct(multi_grp_acct);
				}
				String multi_acct = searchSpaceControlInquiryConditionVO.getAcct();
				if(multi_acct != null && !multi_acct.equals("")){
					multi_acct = "'"+multi_acct.replaceAll(",", "','")+"'";
					searchSpaceControlInquiryConditionVO.setAcct(multi_acct);
				}
				if(isSHA >= 0){
					is_sha = "Y";
				}else{
					is_sha = "N";
				}
				if(isSEL >= 0){
					is_sel = "Y";
				}else{
					is_sel = "N";
				}
				if(isTYO >= 0){
					is_tyo = "Y";
				}else{
					is_tyo = "N";
				}
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				String ofc_cd = account.getOfc_cd();
				
				param.put("ofc_cd", ofc_cd);
				param.put("login_id", account.getUsr_id());
				
				velParam.put("ofc_cd", ofc_cd);
				velParam.put("is_sha", is_sha);
				velParam.put("is_sel", is_sel);
				velParam.put("is_tyo", is_tyo);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolInquiryDBDAO021FcstPfmcAcctViewListRSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlInquiry021AllocPortViewListVO .class);
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
	 * [ESM_SPC_0021] 정보를 [조회] 합니다.FCAST&PFMC Status by ACCT 탭 Non SMP<br>
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @param account SignOnUserAccount
	 * @param int isSHA
	 * @param int isSEL
	 * @param int isTYO
	 * @return List<SearchSpaceControlInquiry021AllocPortViewListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceControlInquiry021AllocPortViewListVO> searchSpaceControlInquiry021FcstPfmcAcctViewNSmpList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO,SignOnUserAccount account , int isSHA, int isSEL, int isTYO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceControlInquiry021AllocPortViewListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String is_sha = "";
		String is_sel = "";
		String is_tyo = "";
		try{
			if(searchSpaceControlInquiryConditionVO != null){
				String multi_rlane = searchSpaceControlInquiryConditionVO.getRlane1();
				if(multi_rlane != null && !multi_rlane.equals("")){
					multi_rlane = "'"+multi_rlane.replaceAll(",", "','")+"'";
					searchSpaceControlInquiryConditionVO.setRlane1(multi_rlane);
				}
				String multi_grp_acct = searchSpaceControlInquiryConditionVO.getGrpAcct();
				if(multi_grp_acct != null && !multi_grp_acct.equals("")){
					multi_grp_acct = "'"+multi_grp_acct.replaceAll(",", "','")+"'";
					searchSpaceControlInquiryConditionVO.setGrpAcct(multi_grp_acct);
				}
				String multi_acct = searchSpaceControlInquiryConditionVO.getAcct();
				if(multi_acct != null && !multi_acct.equals("")){
					multi_acct = "'"+multi_acct.replaceAll(",", "','")+"'";
					searchSpaceControlInquiryConditionVO.setAcct(multi_acct);
				}
				if(isSHA >= 0){
					is_sha = "Y";
				}else{
					is_sha = "N";
				}
				if(isSEL >= 0){
					is_sel = "Y";
				}else{
					is_sel = "N";
				}
				if(isTYO >= 0){
					is_tyo = "Y";
				}else{
					is_tyo = "N";
				}
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				String ofc_cd = account.getOfc_cd();
				
				param.put("ofc_cd", ofc_cd);
				param.put("login_id", account.getUsr_id());
				
				velParam.put("ofc_cd", ofc_cd);
				velParam.put("is_sha", is_sha);
				velParam.put("is_sel", is_sel);
				velParam.put("is_tyo", is_tyo);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolInquiryDBDAO021FcstPfmcAcctViewNSmpListRSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlInquiry021AllocPortViewListVO .class);
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
	* 성수기용 ALLOC 대상인지 여부를 체크<br>
	* 
	* @param ConditionVO conditionVO
	* @return String
	* @exception DAOException
	*/
	public String checkControlOptionFlg(ConditionVO conditionVO)  throws DAOException {
		DBRowSet dbRowset = null;
		String ctrlFlg = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOCheckControlOptionFlgRSQL(), param, velParam);
            if(dbRowset.next()){
            	ctrlFlg = dbRowset.getString(1);
            }else{
            	ctrlFlg = "N";
            }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return ctrlFlg;
	}
	
	/**
	 * 성수기(control option에 의한)시 Inquiry by Trade의 Office별 data를 조회합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<SearchSpaceControlInquirySalesOrgListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceControlInquirySalesOrgListVO> searchSpaceControlInquirySalesOrgSMPList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceControlInquirySalesOrgListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSpaceControlInquiryConditionVO != null){
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOSearchSpaceControlInquirySalesOrgSMPListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlInquirySalesOrgListVO .class);
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
	 * [ESM_SPC_0028] 성수기 by OFC 정보를 조회합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<SearchSpaceControlInquiryOfficeSalesOrgListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceControlInquiryOfficeSalesOrgListVO> searchSpaceControlInquiryOfficeSalesOrgSMPList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceControlInquiryOfficeSalesOrgListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSpaceControlInquiryConditionVO != null){
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOSearchSpaceControlInquiryOfficeSalesOrgSMPListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlInquiryOfficeSalesOrgListVO .class);
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
	 * [ESM_SPC_0057] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<SearchSpaceUtilizationListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceUtilizationListVO> searchSpaceUtilizationList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceUtilizationListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSpaceControlInquiryConditionVO != null){
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//소스품질보안
				if ( searchSpaceControlInquiryConditionVO.getViewType11() != null ) {
					if( searchSpaceControlInquiryConditionVO.getViewType11().equals("P") )
						dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOSearchSpaceUtilizationPortListRSQL(), param, velParam);
					else
						dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOSearchSpaceUtilizationLaneListRSQL(), param, velParam);
				} else {
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOSearchSpaceUtilizationLaneListRSQL(), param, velParam);
				}				
			}
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceUtilizationListVO .class);
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
	 * [ESM_SPC_0057] : Raw Data Export 이벤트 처리<br>
	 * Sheet 에 보여주지 않고 필수 조회조건에 해당하는 전체 Data Excel Down 합니다.
	 * 
	 * @param SearchSpaceControlInquiryConditionVO	searchSpaceControlInquiryConditionVO
	 * @return List<ExcelDownSpaceUtilizationPortListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ExcelDownSpaceUtilizationPortListVO> excelDownSpaceUtilizationPort(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ExcelDownSpaceUtilizationPortListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(searchSpaceControlInquiryConditionVO != null){
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOExcelDownSpaceUtilizationPortListRSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ExcelDownSpaceUtilizationPortListVO .class);
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
	 * [ESM_SPC_0057] : Raw Data Export 이벤트 처리<br>
	 * Sheet 에 보여주지 않고 필수 조회조건에 해당하는 전체 Data Excel Down 합니다.
	 * 
	 * @param SearchSpaceControlInquiryConditionVO	searchSpaceControlInquiryConditionVO
	 * @return List<ExcelDownSpaceUtilizationLaneListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ExcelDownSpaceUtilizationLaneListVO> excelDownSpaceUtilizationLane(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ExcelDownSpaceUtilizationLaneListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(searchSpaceControlInquiryConditionVO != null){
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOExcelDownSpaceUtilizationLaneListRSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ExcelDownSpaceUtilizationLaneListVO .class);
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
	 * [ESM_SPC_0058] 정보를 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchSpaceControlInquiry058VVDListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchSpaceControlInquiry058VVDListVO> searchSpaceControlInquiry058VVDList(ConditionVO conditionVO) throws DAOException {
		 DBRowSet dbRowset = null;
		List<SearchSpaceControlInquiry058VVDListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOSearchSpaceControlInquiry058VVDListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlInquiry058VVDListVO .class);
			
			
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
		 * [ESM_SPC_0058] VVD Input 입력시 VVD의 Lane,Week 정보 조회.<br>
		 * 
		 * @param ConditionVO conditionVO
		 * @return List<SearchSpaceControlInquiry058VVDInfoVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<SearchSpaceControlInquiry058VVDInfoVO> searchSpaceControlInquiry058VVDInfo(ConditionVO conditionVO) throws DAOException {			                                                 
			 DBRowSet dbRowset = null;
			List<SearchSpaceControlInquiry058VVDInfoVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			try{
				if(conditionVO != null){
					Map<String, String> mapVO = conditionVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOSearchSpaceControlInquiry058VVDInfoRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlInquiry058VVDInfoVO .class);
				
				
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
		 * [ESM_SPC_0058] 정보를 [행위] 합니다.<br>
		 * 
		 * @param ConditionVO conditionVO
		 * @return List<SearchSpaceControlInquiry058QtyListVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<SearchSpaceControlInquiry058QtyListVO> searchSpaceControlInquiry058QtyList(ConditionVO conditionVO) throws DAOException {
			 DBRowSet dbRowset = null;
			List<SearchSpaceControlInquiry058QtyListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			try{
				if(conditionVO != null){
					Map<String, String> mapVO = conditionVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOSearchSpaceControlInquiry058QtyListVORSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlInquiry058QtyListVO .class);
				
				
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
		 * ESM_SPC_0087 : [Retrieve]<br>
		 * [T/S Plan & guide main list]을 [조회]합니다.<br>
		 * 
		 * @param ConditionVO conditionVO
		 * @return List<SearchTsPlanGuideListVO>
		 * @throws DAOException
		 */ 
		 @SuppressWarnings("unchecked")
		public List<SearchTsPlanGuideListVO> searchTsPlanGuideMainList(ConditionVO conditionVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchTsPlanGuideListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			try{
				if(conditionVO != null){
					Map<String, String> mapVO = conditionVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOSearchTsPlanGuideMainListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchTsPlanGuideListVO .class);
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
		 * ESM_SPC_0087 : [Save]전<br>
		 * [T/S Plan & guide Main]을 [저장] 전에 VSK 와 겹치는 목록이 있는지 확인한다.<br>
		 * 
		 * @param SearchTsPlanGuideListVO searchTsPlanGuideListVO
		 * @return String[]
		 * @throws DAOException
		 */ 
		 @SuppressWarnings("unchecked")
		public String[] searchTsPlanGuideDupVvd(SearchTsPlanGuideListVO searchTsPlanGuideListVO) throws DAOException {
			DBRowSet dbRowset = null;
			String[] dupData = new String[4];
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			try{
				if(searchTsPlanGuideListVO != null){
					Map<String, String> mapVO = searchTsPlanGuideListVO.getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOSearchTsPlanGuideDupVvdRSQL(), param, velParam);
				if(dbRowset != null){
					if(dbRowset.next()){
						dupData[0] = dbRowset.getString(1);
						dupData[1] = dbRowset.getString(2);
						dupData[2] = dbRowset.getString(3);
						dupData[3] = dbRowset.getString(4);
					}
				}
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return dupData;
		}  
	 
		/**
		 * ESM_SPC_0087 : [Save]<br>
		 * [T/S Plan & guide Main]을 [삭제]합니다.<br>
		 *  
		 * @param List<SearchTsPlanGuideListVO> deleteVoList 
		 * @throws DAOException
		 */
		public void removeTsPlanGuideMainList(List<SearchTsPlanGuideListVO> deleteVoList) throws DAOException {
			int delCnt[] = null;
			try {        
	            if(deleteVoList.size() > 0){
	            	delCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new SpacecontrolinquiryDBDAORemoveTsPlanGuideMainListDSQL(), deleteVoList, null);
	                for(int i = 0; i < delCnt.length; i++){
	                    if(delCnt[i]== Statement.EXECUTE_FAILED)
	                        throw new DAOException("Fail to Delete No"+ i + " SQL");
	                }
	            }
	        } catch (SQLException se) {
		        log.error(se.getMessage(),se);
		        throw new DAOException(new ErrorHandler(se).getMessage());
	        }catch(Exception ex){
	            log.error(ex.getMessage(),ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage());
	        }
			
		}
		
		/**
		 * ESM_SPC_0087 : [Save]<br>
		 * [T/S Plan & guide Main]을 [update]합니다.<br>
		 *  
		 * @param List<SearchTsPlanGuideListVO> updateVoList 
		 * @throws DAOException
		 */
		public void modifyTsPlanGuideMainList(List<SearchTsPlanGuideListVO> updateVoList) throws DAOException {
			int updCnt[] = null;
			try {        
	            if(updateVoList.size() > 0){
	            	updCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new SpacecontrolinquiryDBDAOModifyTsPlanGuideMainlListUSQL(), updateVoList, null);
	                for(int i = 0; i < updCnt.length; i++){
	                    if(updCnt[i]== Statement.EXECUTE_FAILED)
	                        throw new DAOException("Fail to Update No"+ i + " SQL");
	                }
	            }
	        } catch (SQLException se) {
		        log.error(se.getMessage(),se);
		        throw new DAOException(new ErrorHandler(se).getMessage());
	        }catch(Exception ex){
	            log.error(ex.getMessage(),ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage());
	        }
		}
		 
		/**
		 * ESM_SPC_0087 : [Save]<br>
		 * [T/S Plan & guide Main]을 [insert]합니다.<br>
		 *  
		 * @param List<SearchTsPlanGuideListVO> insertVoList 
		 * @throws DAOException
		 */
		public void addTsPlanGuideMainList(List<SearchTsPlanGuideListVO> insertVoList) throws DAOException {
			int insCnt[] = null;
			try {        
	            if(insertVoList.size() > 0){
	            	insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new SpacecontrolinquiryDBDAOAddTsPlanGuideMainlListCSQL(), insertVoList, null);
	                for(int i = 0; i < insCnt.length; i++){
	                    if(insCnt[i]== Statement.EXECUTE_FAILED)
	                        throw new DAOException("Fail to Insert No"+ i + " SQL");
	                }
	            }
	        } catch (SQLException se) {
		        log.error(se.getMessage(),se);
		        throw new DAOException(new ErrorHandler(se).getMessage());
	        }catch(Exception ex){
	            log.error(ex.getMessage(),ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage());
	        }
		}
	 
		/**
		 * ESM_SPC_0087 : [Save]<br>
		 * [Detail Sheet]저장 시 [T/S Plan & guide Main]을 [insert]합니다.<br>
		 *  
		 * @param SearchTsPlanGuideListVO searchTsPlanGuideListVO 
		 * @throws DAOException
		 */
		public void addTsPlanGuideMainList1(SearchTsPlanGuideListVO searchTsPlanGuideListVO) throws DAOException {
			int updCnt = 0;
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			try {        
				if(searchTsPlanGuideListVO != null){
					Map<String, String> mapVO = searchTsPlanGuideListVO .getColumnValues();
					param.putAll(mapVO);
				}
				
				updCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new SpacecontrolinquiryDBDAOAddTsPlanGuideMainlListCSQL(), param, param);
				if(updCnt== Statement.EXECUTE_FAILED)
	                throw new DAOException("Fail to Insert SQL");
	        } catch (SQLException se) {
		        log.error(se.getMessage(),se);
		        throw new DAOException(new ErrorHandler(se).getMessage());
	        }catch(Exception ex){
	            log.error(ex.getMessage(),ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage());
	        }
		}	
		
	/**
	 * ESM_SPC_0087 : [Sheet1 Dbl Click]<br>
	 * [T/S Plan & guide detail list]을 [조회]합니다.<br>
	 * 
	 * @param SearchTsPlanGuideListVO searchTsPlanGuideListVO
	 * @return List<SearchTsPlanGuideListVO>
	 * @throws DAOException
	 */ 
	 @SuppressWarnings("unchecked")
	public List<SearchTsPlanGuideListVO> searchTsPlanGuideDetailList(SearchTsPlanGuideListVO searchTsPlanGuideListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchTsPlanGuideListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(searchTsPlanGuideListVO != null){
				Map<String, String> mapVO = searchTsPlanGuideListVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOSearchTsPlanGuideDetailListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchTsPlanGuideListVO .class);
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
	 * ESM_SPC_0087 : [Sheet1,2 onChange]<br>
	 * [T/S Plan & guide vvd에 맞는 Sub trade, lane, BD, Week, Operator, Yard, ETD, Lane]을 [조회]합니다.<br>
	 * 
	 * @param SearchTsPlanGuideListVO searchTsPlanGuideListVO
	 * @return String[]
	 * @throws DAOException
	 */ 
	 @SuppressWarnings("unchecked")
	public String[] searchTsPlanGuideValidData(SearchTsPlanGuideListVO searchTsPlanGuideListVO) throws DAOException {
		DBRowSet dbRowset = null;
		String searchTp = searchTsPlanGuideListVO.getSearchTp();
		String[] validData = null;
		if(searchTp.equals("1")){
			validData = new String[5];		//query parameter
		}else if(searchTp.equals("2")){
			validData = new String[3];		//query parameter
		}
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(searchTsPlanGuideListVO != null){
				Map<String, String> mapVO = searchTsPlanGuideListVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOSearchTsPlanGuideValidDataRSQL(), param, velParam);
			
			if(dbRowset != null){
				if(dbRowset.next()){
					if(searchTp.equals("1")){
						validData[0] = dbRowset.getString(1);
						validData[1] = dbRowset.getString(2);
						validData[2] = dbRowset.getString(3);
						validData[3] = dbRowset.getString(4);
						validData[4] = dbRowset.getString(5);
					}else if(searchTp.equals("2")){
						validData[0] = dbRowset.getString(1);
						validData[1] = dbRowset.getString(2);
						validData[2] = dbRowset.getString(3);
					}
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return validData;
	}  
	 
	/**
	 * ESM_SPC_0087 : [Save]<br>
	 * [T/S Plan & guide Detail]을 [삭제]합니다.<br>
	 *  
	 * @param List<SearchTsPlanGuideListVO> deleteVoList 
	 * @throws DAOException
	 */
	public void removeTsPlanGuideDetailList(List<SearchTsPlanGuideListVO> deleteVoList) throws DAOException {
		int delCnt[] = null;
		try {        
            if(deleteVoList.size() > 0){
            	delCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new SpacecontrolinquiryDBDAORemoveTsPlanGuideDetailListDSQL(), deleteVoList, null);
                for(int i = 0; i < delCnt.length; i++){
                    if(delCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to Delete No"+ i + " SQL");
                }
            }
        } catch (SQLException se) {
	        log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
		
	}
	
	/**
	 * ESM_SPC_0087 : [Save]<br>
	 * [T/S Plan & guide Detail]을 [update]합니다.<br>
	 *  
	 * @param List<SearchTsPlanGuideListVO> updateVoList 
	 * @throws DAOException
	 */
	public void modifyTsPlanGuideDetailList(List<SearchTsPlanGuideListVO> updateVoList) throws DAOException {
		int updCnt[] = null;
		try {        
            if(updateVoList.size() > 0){
            	updCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new SpacecontrolinquiryDBDAOModifyTsPlanGuideDetailListUSQL(), updateVoList, null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to Update No"+ i + " SQL");
                }
            }
        } catch (SQLException se) {
	        log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
	}
	 
//	/**
//	 * ESM_SPC_0087 : [Save]<br>
//	 * [T/S Plan & guide Detail]을 [insert]합니다.<br>
//	 *  
//	 * @param List<SearchTsPlanGuideListVO> insertVoList 
//	 * @throws DAOException
//	 */
//	public void addTsPlanGuideDetailList(List<SearchTsPlanGuideListVO> insertVoList) throws DAOException {
//		int insCnt[] = null;
//		try {        
//            if(insertVoList.size() > 0){
//            	insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new SpacecontrolinquiryDBDAOAddTsPlanGuideDetailListCSQL(), insertVoList, null);
//                for(int i = 0; i < insCnt.length; i++){
//                    if(insCnt[i]== Statement.EXECUTE_FAILED)
//                        throw new DAOException("Fail to Insert No"+ i + " SQL");
//                }
//            }
//        } catch (SQLException se) {
//	        log.error(se.getMessage(),se);
//	        throw new DAOException(new ErrorHandler(se).getMessage());
//        }catch(Exception ex){
//            log.error(ex.getMessage(),ex);
//            throw new DAOException(new ErrorHandler(ex).getMessage());
//        }
//	}
	
	/**
	 * ESM_SPC_0087 : [Save]<br>
	 * [T/S Plan & guide Detail]을 [insert]합니다.<br>
	 *  
	 * @param SearchTsPlanGuideListVO searchTsPlanGuideListVO 
	 * @throws DAOException
	 */
	public void addTsPlanGuideDetailList(SearchTsPlanGuideListVO searchTsPlanGuideListVO) throws DAOException {
		int updCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {        
			if(searchTsPlanGuideListVO != null){
				Map<String, String> mapVO = searchTsPlanGuideListVO .getColumnValues();
				param.putAll(mapVO);
			}
			
			updCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new SpacecontrolinquiryDBDAOAddTsPlanGuideDetailListCSQL(), param, param);
			if(updCnt== Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to Insert SQL");
        } catch (SQLException se) {
	        log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
	}
	
	/**
	 * ESM_SPC_0087 : [Sheet1 onChange]<br>
	 * [T/S Plan & guide vvd에 맞는 RLane 목록]을 [조회]합니다.<br>
	 * 
	 * @param SearchTsPlanGuideListVO searchTsPlanGuideListVO
	 * @return List<SearchTsPlanGuideListVO>
	 * @throws DAOException
	 */ 
	 @SuppressWarnings("unchecked")
	public List<SearchTsPlanGuideListVO> searchTsPlanGuideVvdRlane(SearchTsPlanGuideListVO searchTsPlanGuideListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchTsPlanGuideListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(searchTsPlanGuideListVO != null){
				Map<String, String> mapVO = searchTsPlanGuideListVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOSearchTsPlanGuideVvdRlaneRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchTsPlanGuideListVO .class);
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
	 * ESM_SPC_0088 : [Load Page]<br>
	 * [T/S Plan & guide Attach list]을 [조회]합니다.<br>
	 * 
	 * @param SearchTsPlanGuideListVO searchTsPlanGuideListVO
	 * @return List<SearchTsPlanGuideListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchTsPlanGuideListVO> searchTsPlanGuideAtchList(SearchTsPlanGuideListVO searchTsPlanGuideListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchTsPlanGuideListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (searchTsPlanGuideListVO != null) {
				Map<String, String> mapVO = searchTsPlanGuideListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SpacecontrolinquiryDBDAOSearchTsPlanGuideAtchListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchTsPlanGuideListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * ESM_SPC_0088 : [upload]<br>
	 * [T/S Plan & guide Attach]을 [추가]합니다.<br>
	 * 
	 * @param List<SearchTsPlanGuideListVO> searchTsPlanGuideListVOs
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int addTsPlanGuideAtch(List<SearchTsPlanGuideListVO> searchTsPlanGuideListVOs) throws DAOException,Exception {
		SQLExecuter sqlExe = new SQLExecuter("");
        int size = searchTsPlanGuideListVOs.size();
		int insCnt = 0;

        try {

	        if(size > 0) {
	    		//query parameter
	    		Map<String, Object> param = new HashMap<String, Object>();
	    		//velocity parameter
	    		Map<String, Object> velParam = new HashMap<String, Object>();
	        	Iterator<SearchTsPlanGuideListVO> list = searchTsPlanGuideListVOs.iterator();
	        	while(list.hasNext()){
	        		SearchTsPlanGuideListVO searchTsPlanGuideListVO = (SearchTsPlanGuideListVO)list.next();
					Map<String, String> mapVO = searchTsPlanGuideListVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
	    			insCnt = sqlExe.executeUpdate((ISQLTemplate)new SpacecontrolinquiryDBDAOAddTsPlanGuideAtchCSQL(), param,velParam);
	    			if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
	        	}
	        }
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insCnt;
	}
	
	/**
	 * ESM_SPC_0088 : [upload]<br>
	 * [T/S Plan & guide Attach]을 [업데이트]합니다.<br>
	 * 
	 * @param List<SearchTsPlanGuideListVO> searchTsPlanGuideListVOs
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyTsPlanGuideAtch(List<SearchTsPlanGuideListVO> searchTsPlanGuideListVOs) throws DAOException,Exception {
		SQLExecuter sqlExe = new SQLExecuter("");
        int size = searchTsPlanGuideListVOs.size();
		int insCnt = 0;

        try {

	        if(size > 0) {
	    		//query parameter
	    		Map<String, Object> param = new HashMap<String, Object>();
	    		//velocity parameter
	    		Map<String, Object> velParam = new HashMap<String, Object>();
	        	Iterator<SearchTsPlanGuideListVO> list = searchTsPlanGuideListVOs.iterator();
	        	while(list.hasNext()){
	        		SearchTsPlanGuideListVO searchTsPlanGuideListVO = (SearchTsPlanGuideListVO)list.next();
					Map<String, String> mapVO = searchTsPlanGuideListVO .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
	    			insCnt = sqlExe.executeUpdate((ISQLTemplate)new SpacecontrolinquiryDBDAOModifyTsPlanGuideAtchUSQL(), param,velParam);
	    			if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
	        	}
	        }

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insCnt;
	}


	/**
	 * ESM_SPC_0088 : [upload]<br>
	 * [T/S Plan & guide Attach]을 [삭제]합니다.<br>
	 * 
	 * @param List<SearchTsPlanGuideListVO> searchTsPlanGuideListVOs
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeTsPlanGuideAtch(List<SearchTsPlanGuideListVO> searchTsPlanGuideListVOs) throws DAOException,Exception {
		SQLExecuter sqlExe = new SQLExecuter("");
        int size = searchTsPlanGuideListVOs.size();
		int insCnt = 0;

        try {
	        if(size > 0) {
	    		//query parameter
	    		Map<String, Object> param = new HashMap<String, Object>();
	    		//velocity parameter
	    		Map<String, Object> velParam = new HashMap<String, Object>();
	        	Iterator<SearchTsPlanGuideListVO> list = searchTsPlanGuideListVOs.iterator();
	        	while(list.hasNext()){
	        		SearchTsPlanGuideListVO searchTsPlanGuideListVO = (SearchTsPlanGuideListVO)list.next();
					Map<String, String> mapVO = searchTsPlanGuideListVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
	    			insCnt = sqlExe.executeUpdate((ISQLTemplate)new SpacecontrolinquiryDBDAORemoveTsPlanGuideAtchDSQL(), param,velParam);
	    			if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");
	        	}
	        }
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insCnt;
	}
	
}
