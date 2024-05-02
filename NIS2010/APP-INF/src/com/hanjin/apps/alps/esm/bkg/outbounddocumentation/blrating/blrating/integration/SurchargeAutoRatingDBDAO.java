/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BlRatingDBDAO.java
 *@FileTitle : Exchange Rate
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.18
 *@LastModifier : 김영출
 *@LastVersion : 1.0
 * 2009.06.18 김영출
 * 1.0 Creation
 * 
 * 2013.03.25 김진주 [CHM-201323559] Split 01-BCC Auto-Interface 기능 구현 요청
 * 2013.05.27 김진주 [CHM-201324374] [TMO - Surcharge 종합 시스템 구축 ] Surcharge tariff 오토레이팅 배치 로직 요청
 * 2013.10.10 김진주 [CHM-201326749] 3rd party office 관련 surcharge 부과 (TPF) auto interface 로직 개발 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import oracle.jdbc.OracleTypes;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.RfaOftAutoRatingBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgObsSurchargeRateVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgSurchargeRateVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScNoteOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScOftAutoratingListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchChgRateByLBPVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchScOftAutoratingListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchSurchargeAutoratingListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ThirdPartyOfcByLbpVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgChgRateVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * NIS2010 SurchargeAutoRatingDBDAO <br>
 * - NIS2010-SurchargeAutoRatingDBDAO system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author LEE JINSEO
 * @see RfaOftAutoRatingBCImpl 참조
 * @since J2EE 1.6
 */
public class SurchargeAutoRatingDBDAO extends DBDAOSupport {



	/**
	 * EsmBkg0269 조회 이벤트 처리<br>
	 * Booking RfaAmericaOft AutoRating  화면에 대한  booking에 대해 운임을 표기해주며,INV System에 중간 Table에 넣어준다 <br>
	 * Booking no에 해당되는 각 지역별 특화된 Surcharge (추가[특별] 요금, 할증료, 추징금, 부가금[세] )를 찾아오는 서비스
	 * @author LEE JIN SEO
	 * @param String bkgNo
	 * @param String caFlag
	 * @param String scpCd 
	 * @param String CMDTCd
	 * @param String ctrtTpCd
	 * @return List<SearchSurchargeAutoratingListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSurchargeAutoratingListVO> searchSurchargeAutoratingList(String bkgNo, String caFlag, String scpCd , String CMDTCd, String ctrtTpCd ) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSurchargeAutoratingListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			param.put("ca_flag", caFlag);
			param.put("svc_scp_cd", scpCd);
			param.put("cmdt_cd", CMDTCd);
			param.put("ctrt_tp_cd", ctrtTpCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SurchargeAutoRatingDBDAOSearchSurchargeAutoratingListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ScNoteOutVO.class);

		} catch (SQLException ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * OBS Charge 정보를 조회한다.
	 * ESM_BKG-0400	Bkg System	
	 * @param String bkgNo
	 * @param String ofcCd
	 * @return BkgObsSurchargeRateVO
	 * @exception DAOException
	 */ 
	public BkgObsSurchargeRateVO searchSurchargeRatingByObs(String bkgNo, String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		BkgObsSurchargeRateVO bkgObsSurchargeRateVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			param.put("login_office", ofcCd); //2011.07.01 SQL문 오피스 코드 추가
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SurchargeAutoRatingDBDAOSearchChgRateByOBSRSQL(), param, velParam);
			List<BkgObsSurchargeRateVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgObsSurchargeRateVO .class);
			if(list.size() > 0){
				bkgObsSurchargeRateVO = list.get(0);
            }
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return bkgObsSurchargeRateVO;
	}

	/**
	 * M(Merchant Request)에 의한 CA Issue 시 Surcharge Table의 조건에 따라 BCC 조회
	 * ESM_BKG-0400	Bkg System	
	 * @param String bkgNo
	 * @param String caFlg
	 * @param String ofcCd
	 * @return BkgSurchargeRateVO
	 * @exception DAOException
	 */ 
	public BkgSurchargeRateVO searchSurchargeRatingByBcc(String bkgNo, String caFlg, String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		BkgSurchargeRateVO bkgSurchargeRateVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlg);
			param.put("login_office", ofcCd); //2011.07.01 SQL문 오피스 코드 추가
			velParam.put("ca_flg", caFlg);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SurchargeAutoRatingDBDAOSearchChgRateByBccRSQL(), param, velParam);
			List<BkgSurchargeRateVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgSurchargeRateVO .class);
			if(list.size() > 0){
				bkgSurchargeRateVO = list.get(0);
            }
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return bkgSurchargeRateVO;
	}	
	
	/**
	 * LBP Charge 정보를 조회한다.
	 * ESM_BKG-007909	Bkg System	
	 * @param String bkgNo
	 * @param String ofcCd
	 * @return SearchChgRateByLBPVO
	 * @exception DAOException
	 */ 
	public SearchChgRateByLBPVO searchSurchargeRatingByLbp(String bkgNo, String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		SearchChgRateByLBPVO searchChgRateByLBPVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			param.put("login_office", ofcCd); //2011.07.01 SQL문 오피스 코드 추가
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SurchargeAutoRatingDBDAOSearchChgRateByLBPRSQL(), param, velParam);
			List<SearchChgRateByLBPVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchChgRateByLBPVO .class);
			if(list.size() > 0){
				searchChgRateByLBPVO = list.get(0);
            }
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchChgRateByLBPVO;
	}

	/**
	 * O/BL Surrender 처리시 OBS Charge 정보가 존재하는지 체크한다.
	 * ESM_BKG-0400	Bkg System	
	 * @param String bkgNo
	 * @return String
	 * @exception DAOException
	 */ 
	public String checkObsSurchargeRating(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			dbRowset = new SQLExecuter("").executeQuery(new SurchargeAutoRatingDBDAOCheckObsSurchargeRatingUSQL(), param,velParam);
			
            if(dbRowset.next()){
                result = dbRowset.getString(1);
            }
			
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return result;
	}
	
	/**
	 * O/BL Surrender 처리시 OBS Charge 항목을 추가한다.
	 * ESM_BKG-0400	Bkg System	
	 * @param BkgObsSurchargeRateVO bkgObsSurchargeRateVO
	 * @exception DAOException
	 */ 
	public void addObsSurchargeRating(BkgObsSurchargeRateVO bkgObsSurchargeRateVO) throws DAOException {
		int insCnt = 0;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> fmapVO = bkgObsSurchargeRateVO.getColumnValues();
			param.putAll(fmapVO);
			velParam.putAll(fmapVO);
			insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new SurchargeAutoRatingDBDAOAddObsChgCSQL(), param,velParam);
			
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
			
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * M(Merchant Request)에 의한 CA Issue 시 Surcharge Table의 조건에 따라 BCC 반영
	 * @param BkgSurchargeRateVO bkgSurchargeRateVO
	 * @exception DAOException
	 */ 
	public void addSurchargeRating(BkgSurchargeRateVO bkgSurchargeRateVO) throws DAOException {
		int insCnt = 0;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> fmapVO = bkgSurchargeRateVO.getColumnValues();
			param.putAll(fmapVO);
			velParam.putAll(fmapVO);
			insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new SurchargeAutoRatingDBDAOAddSurchargeRateCSQL(), param,velParam);
			
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
			
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * O/BL Release 처리시 LBP Charge 항목을 추가한다.
	 * ESM_BKG-007909	Bkg System	
	 * @param SearchChgRateByLBPVO searchChgRateByLBPVO
	 * @exception DAOException
	 */ 
	public void addLbpSurchargeRating(SearchChgRateByLBPVO searchChgRateByLBPVO) throws DAOException {
		int insCnt = 0;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> fmapVO = searchChgRateByLBPVO.getColumnValues();
			param.putAll(fmapVO);
			velParam.putAll(fmapVO);
			insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new SurchargeAutoRatingDBDAOAddLbpChgCSQL(), param,velParam);
			
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
			
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * LBP Surcharge 정보에 해당하는 Third Party Office 정보를 구한다.
	 * ESM_BKG-007909	Bkg System	
	 * @param String bkgNo
	 * @param String ofcCd
	 * @return ThirdPartyOfcByLbpVO
	 * @exception DAOException
	 */ 
	public ThirdPartyOfcByLbpVO searchThirdPartyOfcByLbp(String bkgNo, String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		ThirdPartyOfcByLbpVO thirdPartyOfcByLbpVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			param.put("login_office", ofcCd); //2011.07.01 SQL문 오피스 코드 추가
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SurchargeAutoRatingDBDAOSearchThirdPartyOfcByLbpRSQL(), param, velParam);
			List<ThirdPartyOfcByLbpVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, ThirdPartyOfcByLbpVO .class);
			if(list.size() > 0){
				thirdPartyOfcByLbpVO = list.get(0);
            }
			
			
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return thirdPartyOfcByLbpVO;
		
	}
	
	/**
	 * TPF Surcharge 정보를 조회한다.
	 * ESM_BKG-007908	Bkg System	
	 * @param String bkgNo
	 * @param String caFlag
	 * @return BkgChgRateVO
	 * @exception DAOException
	 */ 
	public BkgChgRateVO searchTPFSurcharge(String bkgNo, String caFlag) throws DAOException {
		DBRowSet dbRowset = null;
		BkgChgRateVO bkgChgRateVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			param.put("ca_flag", caFlag);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SurchargeAutoRatingDBDAOSearchTPFSurchargeRSQL(), param, velParam);
			List<BkgChgRateVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgChgRateVO .class);
			if(list.size() > 0){
				bkgChgRateVO = list.get(0);
            }
			
			
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return bkgChgRateVO;
		
	}
	
	
    /**
	 * KOREA WHF - BB의 Charge Rate 정보 삭제<br>
	 * 
	 * @author 
	 * @param List<BkgChgRateVO> listVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
    public void modifyWhfChgRate(List<BkgChgRateVO> listVO) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			int size = listVO.size();
			if (size > 0) {
				
				// query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				// velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				Iterator list = listVO.iterator();
				while (list.hasNext()) {
					BkgChgRateVO bkgChgRateVO = (BkgChgRateVO) list.next();
					Map<String, String> mapVO = bkgChgRateVO.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
					int insCnt = 0 ;
					
					insCnt = sqlExe.executeUpdate((ISQLTemplate) new SurchargeAutoRatingDBDAOModifyWhfChgRateUSQL(), param, velParam);
					
					if (insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
				}
			}
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
}
