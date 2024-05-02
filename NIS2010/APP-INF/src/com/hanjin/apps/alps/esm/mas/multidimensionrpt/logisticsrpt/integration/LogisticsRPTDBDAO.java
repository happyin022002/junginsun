/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : MultiDimensionRPTDBDAO.java
 *@FileTitle : LogisticsRPTDBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
 * 2006-11-09 Sangwook_nam
 * 1.0 최초 생성
 * =========================================================
 * History
 * 2008.01.29 전성진 CSR.No N200801104836 
 * 					 - 화면조회시 내부거래 단가 포함여부를 선택하여 조회하게 함. 
 * 					 - f_incld_TML 변수 사용하여 처리로 조회되도록 쿼리문 수정[060,062,070,071,078,147,148]
 * 2008.02.26 전성진 CSR.No R200802265273
 * 					 - 080,081,082 대상항차 조회시 WK로 조회하면 SLS_YRMON 사용하게 변경
 * 2008.03.28 전성진 CSR.No N200803240003 물류레포트에 Sale Vol.,Inland Vol. 추가 [081]
 * 					 - Week 조회시 월 조건 추가[080, 081, 082]        
 * 2008.04.03 전성진 CSR.No N200803310003 물류레포트 파일 분리     
 * 					 - [082] Split by Month/Week 기능 추가 - data양이 많은 관계로 split시 2M/2W로 기간 제한함. 
 * 2008.05.09 전성진 CSR No.N200804140007
 * 					 - load, void vol -> teu / vol -> box 기준으로 변경, Colume에도 단위 입력.
 * 					 - Box/TEU 선택옵션 삭제
 * 2008.05.29 전성진 CSR No.N200805200001 [081, 082]
 * 					 Control Office의 기준을 변경하여 mas_ofc_lvl의 4레벨 수준으로 함.
 * 2008.06.23 전성진 CSR No.N200806180007 [081, 082]
 * 2008.06.23 김태윤 CSR No.N200806187437 [081, 082]
 * 					 OFC_N2ND_LVL_CD => OFC_N3RD_LVL_CD으로 OFC_N4TH_LVL_CD=> OFC_N5TH_LVL_CD로 변경. 
 * 2008.07.21 김태윤 CSR No.R200807218166
 * 					 성능향상을 위한 물류레포트 변경 - 158 신규화면 생성. 
 * 2008.11.28 박은주 CSR No.N200810310004 US Route Cost Inquiry  신규화면 개발.
 * 2008.12.23 김태윤 CSR No.N200812230006 MAS Office 월별관리 후 table 수정 (MAS_OFC_LVL), mas_mon_vvd 와 조건 추가
 * 2009.02.09 전윤주 CSR No.N200901210015 MDM Office Level 변경 후 2009년 이후 data retrieve 시 쿼리 수정 (2007,2008 조건 추가)
 *                                       mas_mon_vvd, mas_ofc_lvl join 시 sls_yrmon와 cost_yrmon 구분 Logic [158, 081, 0812, 082]
 * 2009.03.26 박은주 품질검토결과 수정사항 반영                   
 * 2009.03.30 전윤주 CSR No.R200903310002 200903월 튜닝 리스트 선정 쿼리 튜닝 
 *                  Logistics Expense by Node & Link 화면 쿼리 튜닝 [082]
 *                  Logistics Expense by Office 화면 쿼리 튜닝 [081]
 * 2009.05.14 전윤주 CSR No.N200904160100 bound 에 in_out 제대로 나오도록 변수 setting 수정 [163]
 * 2009.10.07 장영석  New FrameWork 적용 [0163]
 * 2009.10.13 최인경  New FrameWork 적용 [0080]
 * 2009.10.14 최인경  New FrameWork 적용 [0081]
 * 2009.10.26 최인경  New FrameWork 적용 [0082]
 * 2009.10.29 최인경  New FrameWork 적용 [0158]
 * 2011.07.13 최성민 [CHM-201111826] R4J Rule Upgrade 관련 소스품질 향상을 위한 조치
 =========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.logisticsrpt.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.logisticsrpt.basic.LogisticsRPTBCImpl;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.logisticsrpt.vo.SearchLgstConditionVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0080ListVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT00802ListVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0081ListVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT00812ListVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0082ListVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT00822ListVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0158ListVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.logisticsrpt.vo.SearchUSInlandCost0163ListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ENIS-MAS에 대한 DB 처리를 담당<br> - ENIS-MAS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Sangwook_nam
 * @see LogisticsRPTBCImpl 참조
 * @since J2EE 1.4
 */
public class LogisticsRPTDBDAO extends DBDAOSupport {
	 	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1924751065590872564L;

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchUSInlandCost0163ListVO searchUSInlandCost0163ListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchUSInlandCost0163ListVO>
	 * @throws DAOException
	 */
	public List<SearchUSInlandCost0163ListVO> searchUSInlandCost0163List(SearchUSInlandCost0163ListVO searchUSInlandCost0163ListVO, SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchUSInlandCost0163ListVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LogisticsRPTDBDAOSearchUSInlandCost0163ListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchUSInlandCost0163ListVO .class);
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
	 * @param SearchLgstConditionVO searchLgstConditionVO
	 * @return List<SearchLogisticsRPT0080ListVO>
	 * @throws DAOException
	*/
	public List<SearchLogisticsRPT0080ListVO> searchLogisticsRPT0080List(SearchLgstConditionVO searchLgstConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchLogisticsRPT0080ListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchLgstConditionVO != null){
				Map<String, String> mapVO = searchLgstConditionVO .getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LogisticsRPTDBDAOSearchLogisticsRPT0080ListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchLogisticsRPT0080ListVO .class);
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
	 * @param SearchLgstConditionVO searchLgstConditionVO
	 * @return List<SearchLogisticsRPT00802ListVO>
	 * @throws DAOException
	*/
	public List<SearchLogisticsRPT00802ListVO> searchLogisticsRPT00802List(SearchLgstConditionVO searchLgstConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchLogisticsRPT00802ListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchLgstConditionVO != null){
				Map<String, String> mapVO = searchLgstConditionVO .getColumnValues();
						
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
					
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LogisticsRPTDBDAOSearchLogisticsRPT00802ListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchLogisticsRPT00802ListVO .class);
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
	 * @param SearchLgstConditionVO searchLgstConditionVO
	 * @return List<SearchLogisticsRPT0081ListVO>
	 * @throws DAOException
	*/
	public List<SearchLogisticsRPT0081ListVO> searchLogisticsRPT0081List(SearchLgstConditionVO searchLgstConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchLogisticsRPT0081ListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchLgstConditionVO != null){
				Map<String, String> mapVO = searchLgstConditionVO .getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LogisticsRPTDBDAOSearchLogisticsRPT0081ListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchLogisticsRPT0081ListVO .class);
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
	 * @param SearchLgstConditionVO searchLgstConditionVO
	 * @return List<SearchLogisticsRPT00812ListVO>
	 * @throws DAOException
	*/
	public List<SearchLogisticsRPT00812ListVO> searchLogisticsRPT00812List(SearchLgstConditionVO searchLgstConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchLogisticsRPT00812ListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchLgstConditionVO != null){
				Map<String, String> mapVO = searchLgstConditionVO .getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LogisticsRPTDBDAOSearchLogisticsRPT00812ListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchLogisticsRPT00812ListVO .class);
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
	 * @param SearchLgstConditionVO searchLgstConditionVO
	 * @return List<SearchLogisticsRPT0082ListVO>
	 * @throws DAOException
	*/
	public List<SearchLogisticsRPT0082ListVO> searchLogisticsRPT0082List(SearchLgstConditionVO searchLgstConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchLogisticsRPT0082ListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchLgstConditionVO != null){
				Map<String, String> mapVO = searchLgstConditionVO .getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LogisticsRPTDBDAOSearchLogisticsRPT0082ListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchLogisticsRPT0082ListVO .class);
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
	 * @param SearchLgstConditionVO searchLgstConditionVO
	 * @return List<SearchLogisticsRPT00822ListVO>
	 * @throws DAOException
	*/
	public List<SearchLogisticsRPT00822ListVO> searchLogisticsRPT00822List(SearchLgstConditionVO searchLgstConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchLogisticsRPT00822ListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchLgstConditionVO != null){
				Map<String, String> mapVO = searchLgstConditionVO .getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LogisticsRPTDBDAOSearchLogisticsRPT00822ListVORSQL(), param, velParam);

			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchLogisticsRPT00822ListVO .class);
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
	 * Logistics Vol. by Offic를 조회한다.<br>
	 * 
	 * @param SearchLgstConditionVO searchLgstConditionVO
	 * @return List<SearchLogisticsRPT0158ListVO>
	 * @throws DAOException
	*/
	public List<SearchLogisticsRPT0158ListVO> searchLogisticsRPT0158List(SearchLgstConditionVO searchLgstConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchLogisticsRPT0158ListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchLgstConditionVO != null){
				Map<String, String> mapVO = searchLgstConditionVO .getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LogisticsRPTDBDAOSearchLogisticsRPT0158ListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchLogisticsRPT0158ListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
}