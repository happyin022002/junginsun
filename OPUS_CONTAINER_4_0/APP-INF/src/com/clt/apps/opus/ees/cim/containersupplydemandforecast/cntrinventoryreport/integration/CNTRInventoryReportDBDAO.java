/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CNTRInventoryReportDAO.java
*@FileTitle : EQ Operation Trend (Inventory Trend)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.05.04 김종준
* 1.0 Creation
* =========================================================
* 2010.09.07 남궁진호 [CHM-201005814-01] 소스품질 결함 조치.Warning 제거
=========================================================*/
package com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.basic.CNTRInventoryReportBCImpl;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtCntrListVO;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtCodeCommonVO;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtOptionVO;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtSmryVO;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.StockByCntrListVO;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.StockSmryVO;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.TrendListVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

 
/**
 *  CNTRInventoryReportDAO <br>
 *  ContainerSupplyDemandForecast system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author kim jong jun
 * @see CNTRInventoryReportBCImpl 참조
 * @since J2EE 1.4
 */
public class CNTRInventoryReportDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 지역기준의 CNTR 재고관리 운영지표인 Inventory Trend 조회 <br>
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<TrendListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<TrendListVO> searchTrendListByInvt(InvtOptionVO invtOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TrendListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(invtOptionVO != null){
				String fromBseDt = invtOptionVO.getFromBseDt().replaceAll("-", "");
				String toBseDt = invtOptionVO.getToBseDt().replaceAll("-", "");
				invtOptionVO.setFromBseDt(fromBseDt);
				invtOptionVO.setToBseDt(toBseDt);
				Map<String, String> mapVO = invtOptionVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CNTRInventoryReportDBDAOsearchTrendListByInvtRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TrendListVO.class);
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
	 * 지역별,EQ TY/SZ 별 Long Staying Ratio를 조회<br>
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<TrendListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<TrendListVO> searchTrendListByLongStaying(InvtOptionVO invtOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TrendListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(invtOptionVO != null){
				//invtOptionVO.onDataFormat();
				String cntrTpszCd = "'"+invtOptionVO.getCntrTpszCd()+"'";
				if ( cntrTpszCd.equals("''") ) {
					cntrTpszCd = "";
				}
				String fromBseDt = invtOptionVO.getFromBseDt().replaceAll("-", "");
				String toBseDt = invtOptionVO.getToBseDt().replaceAll("-", "");
			    String opTrndTpCd = "";
			    if ( invtOptionVO.getOpTrndTpCd().equals("IM") ) {
			    	opTrndTpCd = "LM";
			    } else if  ( invtOptionVO.getOpTrndTpCd().equals("IW") ) {
			    	opTrndTpCd = "LW";
			    }
			    invtOptionVO.setOpTrndTpCd(opTrndTpCd);
				invtOptionVO.setCntrTpszCd(cntrTpszCd);
				invtOptionVO.setFromBseDt(fromBseDt);
				invtOptionVO.setToBseDt(toBseDt);
				Map<String, String> mapVO = invtOptionVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CNTRInventoryReportDBDAOsearchTrendListByLongStayingRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TrendListVO.class);
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
	* 현재일을 기준으로 주차와,년월을 구해 주어진 기간의 주차와,년월을 조회<br>
	* 
	* @param InvtOptionVO invtOptionVO
	* @return InvtOptionVO
	* @exception DAOException
	*/
	@SuppressWarnings("unchecked")
	public InvtOptionVO searchDefaultMonthWeek(InvtOptionVO invtOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvtOptionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(invtOptionVO != null){
				Map<String, String> mapVO = invtOptionVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CNTRInventoryReportDBDAOsearchDefaultMonthWeekRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvtOptionVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list.get(0);
	}	

	/**
	 * 주어진 기간의 주차와,년월 목록을 조회<br>
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<TrendListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TrendListVO> searchMonthWeekList(InvtOptionVO invtOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TrendListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(invtOptionVO != null){
				invtOptionVO.unDataFormat();
				Map<String, String> mapVO = invtOptionVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CNTRInventoryReportDBDAOsearchMonthWeekListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TrendListVO.class);
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
	 * 컨테이너 TYPE/SIZE 목록을 조회<br>
	 * 
	 * @return List<InvtCodeCommonVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvtCodeCommonVO> searchCntrTypeSizeList() throws DAOException {
		DBRowSet dbRowset = null;
		List<InvtCodeCommonVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CNTRInventoryReportDBDAOsearchCntrTypeSizeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvtCodeCommonVO.class);
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
	 * Land 및 Sea 구간의 Full & MTY CNTR 재고를 Lease Term으로 구분하여 조회<br>
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<InvtSmryVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvtSmryVO> searchTotalInvtList(InvtOptionVO invtOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvtSmryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(invtOptionVO != null){
				if ( invtOptionVO.getCntrTpszCd().equals("") ) {
					if ( invtOptionVO.getD2PayldFlg().equals("Y") ) {
						invtOptionVO.setCntrTpszCd("D2");
					}			
				}
				StringTokenizer  st = new StringTokenizer(invtOptionVO.getHeadCntrTpszCd(),"|");
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd1  (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd2  (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd3  (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd4  (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd5  (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd6  (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd7  (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd8  (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd9  (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd10 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd11 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd12 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd13 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd14 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd15 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd16 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd17 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd18 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd19 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd20 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd21 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd22 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd23 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd24 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd25 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd26 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd27 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd28 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd29 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd30 (st.nextToken());
				invtOptionVO.setHeadCntrTpszCd(invtOptionVO.getHeadCntrTpszCd().replace("|", ","));
				
				Map<String, String> mapVO = invtOptionVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CNTRInventoryReportDBDAOsearchTotalInvtListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvtSmryVO.class);
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
	 * Land의 CNTR 재고를 Lease Term,Movement Status 별로 구분하여 조회<br>
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<InvtSmryVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvtSmryVO> searchLandInvtListByTerm(InvtOptionVO invtOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvtSmryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(invtOptionVO != null){
				if ( invtOptionVO.getCntrTpszCd().equals("") ) {
					if ( invtOptionVO.getD2PayldFlg().equals("Y") ) {
						invtOptionVO.setCntrTpszCd("D2");
					}
				}
				StringTokenizer  st = new StringTokenizer(invtOptionVO.getHeadCntrTpszCd(),"|");
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd1  (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd2  (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd3  (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd4  (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd5  (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd6  (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd7  (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd8  (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd9  (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd10 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd11 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd12 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd13 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd14 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd15 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd16 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd17 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd18 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd19 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd20 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd21 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd22 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd23 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd24 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd25 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd26 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd27 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd28 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd29 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd30 (st.nextToken());
				invtOptionVO.setHeadCntrTpszCd(invtOptionVO.getHeadCntrTpszCd().replace("|", ","));
				
				Map<String, String> mapVO = invtOptionVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CNTRInventoryReportDBDAOsearchLandInvtListByTermRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvtSmryVO.class);
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
	 * Land의 CNTR 재고를 Location별로 구분하여 조회<br> 
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<InvtSmryVO>
	 * @exception DAOException
	 */
	public InvtSmryVO[] searchLandInvtListByLoc(InvtOptionVO invtOptionVO) throws DAOException {
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		InvtSmryVO[] invtSmryVOs = null;
		try {
			if ( invtOptionVO.getCntrTpszCd().equals("") ) {
				if ( invtOptionVO.getD2PayldFlg().equals("Y") ) {
					invtOptionVO.setCntrTpszCd("D2");
				}
			}					
			StringTokenizer  st = new StringTokenizer(invtOptionVO.getHeadCntrTpszCd(),"|");
			if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd1  (st.nextToken());
			if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd2  (st.nextToken());
			if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd3  (st.nextToken());
			if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd4  (st.nextToken());
			if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd5  (st.nextToken());
			if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd6  (st.nextToken());
			if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd7  (st.nextToken());
			if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd8  (st.nextToken());
			if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd9  (st.nextToken());
			if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd10 (st.nextToken());
			if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd11 (st.nextToken());
			if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd12 (st.nextToken());
			if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd13 (st.nextToken());
			if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd14 (st.nextToken());
			if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd15 (st.nextToken());
			if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd16 (st.nextToken());
			if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd17 (st.nextToken());
			if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd18 (st.nextToken());
			if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd19 (st.nextToken());
			if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd20 (st.nextToken());
			if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd21 (st.nextToken());
			if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd22 (st.nextToken());
			if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd23 (st.nextToken());
			if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd24 (st.nextToken());
			if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd25 (st.nextToken());
			if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd26 (st.nextToken());
			if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd27 (st.nextToken());
			if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd28 (st.nextToken());
			if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd29 (st.nextToken());
			if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd30 (st.nextToken());
			invtOptionVO.setHeadCntrTpszCd(invtOptionVO.getHeadCntrTpszCd().replace("|", ","));
			
			List<AbstractValueObject> voList = new SQLExecuter("").executeQuery(new CNTRInventoryReportDBDAOsearchLandInvtListByLocRSQL(), invtOptionVO.getColumnValues(), invtOptionVO.getColumnValues(),InvtSmryVO.class);
			invtSmryVOs = (InvtSmryVO[])voList.toArray(new InvtSmryVO[voList.size()]);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return invtSmryVOs;
	} 

	/**
	 * 조회시점 기준, 해상에 VVD별로 소재하고 있는 컨테이너의 Lease Term 별,Style(FL/MTY) 수량 조회<br> 
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<InvtSmryVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvtSmryVO> searchSeaInvtListInvt(InvtOptionVO invtOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvtSmryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		List<String> arrLabelValueList = null;
		try{
			if(invtOptionVO != null){
				StringTokenizer  st = new StringTokenizer(invtOptionVO.getHeadCntrTpszCd(),"|");
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd1  (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd2  (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd3  (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd4  (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd5  (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd6  (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd7  (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd8  (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd9  (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd10 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd11 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd12 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd13 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd14 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd15 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd16 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd17 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd18 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd19 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd20 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd21 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd22 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd23 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd24 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd25 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd26 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd27 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd28 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd29 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd30 (st.nextToken());
				invtOptionVO.setHeadCntrTpszCd(invtOptionVO.getHeadCntrTpszCd().replace("|", ","));
				
				Map<String, String> mapVO = invtOptionVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				if ( !JSPUtil.getNull(invtOptionVO.getRstr_usg_lbl()).equals("") ) {
					arrLabelValueList = JSPUtil.convertStringToArrayList(JSPUtil.replace(invtOptionVO.getRstr_usg_lbl(),",","|"));
		        	param.put("labelvalue_list", arrLabelValueList);
		        	velParam.put("labelvalue_list", arrLabelValueList);        	
		        } 
				
				
				if("ALL".equals(invtOptionVO.getRu_lable_type())) {
					param.put("ru_lable_type", "");
					velParam.put("ru_lable_type", "");
				}
				
				
				if("ALL".equals(invtOptionVO.getRstr_usg_lbl())) {
					param.put("rstr_usg_lbl", "");
					velParam.put("rstr_usg_lbl", "");
				}
				
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CNTRInventoryReportDBDAOsearchSeaInvtListInvtRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvtSmryVO.class);
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
	 * 조회시점 기준, 해상에 VVD별로 소재하고 있는 컨테이너의 POL/POD 별 수량 조회<br> 
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<InvtSmryVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvtSmryVO> searchSeaInvtListByPolPod(InvtOptionVO invtOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvtSmryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<String> arrLabelValueList = null;
		try{
			if(invtOptionVO != null){

				StringTokenizer  st = new StringTokenizer(invtOptionVO.getHeadCntrTpszCd(),"|");
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd1  (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd2  (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd3  (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd4  (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd5  (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd6  (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd7  (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd8  (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd9  (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd10 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd11 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd12 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd13 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd14 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd15 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd16 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd17 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd18 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd19 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd20 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd21 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd22 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd23 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd24 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd25 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd26 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd27 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd28 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd29 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd30 (st.nextToken());
				invtOptionVO.setHeadCntrTpszCd(invtOptionVO.getHeadCntrTpszCd().replace("|", ","));
				
				Map<String, String> mapVO = invtOptionVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				if ( !JSPUtil.getNull(invtOptionVO.getRstr_usg_lbl()).equals("") ) {
					arrLabelValueList = JSPUtil.convertStringToArrayList(JSPUtil.replace(invtOptionVO.getRstr_usg_lbl(),",","|"));
		        	param.put("labelvalue_list", arrLabelValueList);
		        	velParam.put("labelvalue_list", arrLabelValueList);        	
		        } 
				
				
				if("ALL".equals(invtOptionVO.getRu_lable_type())) {
					param.put("ru_lable_type", "");
					velParam.put("ru_lable_type", "");
				}
				
				
				if("ALL".equals(invtOptionVO.getRstr_usg_lbl())) {
					param.put("rstr_usg_lbl", "");
					velParam.put("rstr_usg_lbl", "");
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CNTRInventoryReportDBDAOsearchSeaInvtListByPolPodRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvtSmryVO.class);
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
	 * 조회시점 기준, 지역별로 소재하고 있는 컨테이너 넘버 및 관련 Booking 및 장비관리 정보갯수<br>
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return int
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public int searchSeaInvtTotalByCntr(InvtOptionVO invtOptionVO) throws DAOException {
		int totalCnt = 0;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		List<String> arrLabelValueList = null;
		try{
			if(invtOptionVO != null){
				Map<String, String> mapVO = invtOptionVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				if ( !JSPUtil.getNull(invtOptionVO.getRstr_usg_lbl()).equals("") ) {
					arrLabelValueList = JSPUtil.convertStringToArrayList(JSPUtil.replace(invtOptionVO.getRstr_usg_lbl(),",","|"));
		        	param.put("labelvalue_list", arrLabelValueList);
		        	velParam.put("labelvalue_list", arrLabelValueList);        	
		        } 
				
				
				if("ALL".equals(invtOptionVO.getRu_lable_type())) {
					param.put("ru_lable_type", "");
					velParam.put("ru_lable_type", "");
				}
				
				
				if("ALL".equals(invtOptionVO.getRstr_usg_lbl())) {
					param.put("rstr_usg_lbl", "");
					velParam.put("rstr_usg_lbl", "");
				}
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CNTRInventoryReportDBDAOsearchSeaInvtTotalByCntrRSQL(), param, velParam);
			if(dbRowset.next()) {
	    		totalCnt = dbRowset.getInt("TOTAL_CNT");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return totalCnt;
	}
	
	/**
	 * 조회시점 기준, 해상에 VVD별로 소재하고 있는 컨테이너 번호,관련 Booking 및 장비관리 정보 조회 <br>
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<InvtCntrListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvtCntrListVO> searchSeaInvtListByCntr(InvtOptionVO invtOptionVO) throws DAOException {
		int currentPage = invtOptionVO.getIPage();
		int pageRow	  = Integer.parseInt(invtOptionVO.getPagerows());
   	  	int startNo = pageRow * (currentPage -1) +1;
   	  	int endNo   = pageRow *  currentPage;
   	  	
		DBRowSet dbRowset = null;
		List<InvtCntrListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		List<String> arrLabelValueList = null;
		try{
			if(invtOptionVO != null){
				Map<String, String> mapVO = invtOptionVO.getColumnValues();
				
				param.putAll(mapVO);
		        param.put("startno", startNo);
				param.put("endno", endNo);
		        velParam.putAll(mapVO);
		        velParam.put("startno", startNo);
		        velParam.put("endno", endNo);
				
				if ( !JSPUtil.getNull(invtOptionVO.getRstr_usg_lbl()).equals("") ) {
					arrLabelValueList = JSPUtil.convertStringToArrayList(JSPUtil.replace(invtOptionVO.getRstr_usg_lbl(),",","|"));
		        	param.put("labelvalue_list", arrLabelValueList);
		        	velParam.put("labelvalue_list", arrLabelValueList);        	
		        } 
				
				
				if("ALL".equals(invtOptionVO.getRu_lable_type())) {
					param.put("ru_lable_type", "");
					velParam.put("ru_lable_type", "");
				}
				
				
				if("ALL".equals(invtOptionVO.getRstr_usg_lbl())) {
					param.put("rstr_usg_lbl", "");
					velParam.put("rstr_usg_lbl", "");
				}
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CNTRInventoryReportDBDAOsearchSeaInvtListByCntrRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvtCntrListVO.class);
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
	 * 조회시점 기준, 지역별로 소재하고 있는 컨테이너 넘버 및 관련 Booking 및 장비관리 정보 갯수<br>
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return int
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public int searchCntrListEqWiseByTotalLoc(InvtOptionVO invtOptionVO) throws DAOException {
   	    int totalCnt = 0;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<String> arrLabelValueList = null;
		List<String> arrCdList = null;
		try{
			if(invtOptionVO != null){
				if ( invtOptionVO.getCntrTpszCd().equals("") ) {
					if ( invtOptionVO.getD2PayldFlg().equals("Y") ) {
						invtOptionVO.setCntrTpszCd("D2");
					}
				}		
				
				Map<String, String> mapVO = invtOptionVO.getColumnValues();
				
				 param.putAll(mapVO);
		         velParam.putAll(mapVO);
				
				if ( !JSPUtil.getNull(invtOptionVO.getRstr_usg_lbl()).equals("") ) {
					arrLabelValueList = JSPUtil.convertStringToArrayList(JSPUtil.replace(invtOptionVO.getRstr_usg_lbl(),",","|"));
		        	param.put("labelvalue_list", arrLabelValueList);
		        	velParam.put("labelvalue_list", arrLabelValueList);        	
		        } 
				
				
				if("ALL".equals(invtOptionVO.getRu_lable_type())) {
					param.put("ru_lable_type", "");
					velParam.put("ru_lable_type", "");
				}
				
				
				if("ALL".equals(invtOptionVO.getRstr_usg_lbl())) {
					param.put("rstr_usg_lbl", "");
					velParam.put("rstr_usg_lbl", "");
				}
				
				
				if ( "7".equals(invtOptionVO.getLocTypeCode()) || "8".equals(invtOptionVO.getLocTypeCode()) || "9".equals(invtOptionVO.getLocTypeCode()) ) {
					arrCdList = JSPUtil.convertStringToArrayList(JSPUtil.replace(invtOptionVO.getLocCd(),",","|"));
					param.put("loccd_list", arrCdList);
		        	velParam.put("loccd_list", arrCdList);        	
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CNTRInventoryReportDBDAOtotalCntEqWiseByLocRSQL(), param, velParam);
	         if(dbRowset.next()) {
		    		totalCnt = dbRowset.getInt("TOTAL_CNT");
	         }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return totalCnt;
	}
	
	
	
	/**
	 * 조회시점 기준, 지역별로 소재하고 있는 컨테이너 넘버 및 관련 Booking 및 장비관리 정보를 조회<br>
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<InvtCntrListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvtCntrListVO> searchCntrListEqWiseByLoc(InvtOptionVO invtOptionVO) throws DAOException {
		int currentPage = invtOptionVO.getIPage();
		int pageRow	  = Integer.parseInt(invtOptionVO.getPagerows());
   	  	int startNo = pageRow * (currentPage -1) +1;
   	  	int endNo   = pageRow *  currentPage;
   	  
		DBRowSet dbRowset = null;
		List<InvtCntrListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<String> arrLabelValueList = null;
		List<String> arrCdList = null;
		try{
			if(invtOptionVO != null){
				if ( invtOptionVO.getCntrTpszCd().equals("") ) {
					if ( invtOptionVO.getD2PayldFlg().equals("Y") ) {
						invtOptionVO.setCntrTpszCd("D2");
					}
				}		
				
				Map<String, String> mapVO = invtOptionVO.getColumnValues();
				
				 param.putAll(mapVO);
		         param.put("startno", startNo);
				 param.put("endno", endNo);
		         velParam.putAll(mapVO);
		         velParam.put("startno", startNo);
		         velParam.put("endno", endNo);
				
				if ( !JSPUtil.getNull(invtOptionVO.getRstr_usg_lbl()).equals("") ) {
					arrLabelValueList = JSPUtil.convertStringToArrayList(JSPUtil.replace(invtOptionVO.getRstr_usg_lbl(),",","|"));
		        	param.put("labelvalue_list", arrLabelValueList);
		        	velParam.put("labelvalue_list", arrLabelValueList);        	
		        } 
				
				
				if("ALL".equals(invtOptionVO.getRu_lable_type())) {
					param.put("ru_lable_type", "");
					velParam.put("ru_lable_type", "");
				}
				
				
				if("ALL".equals(invtOptionVO.getRstr_usg_lbl())) {
					param.put("rstr_usg_lbl", "");
					velParam.put("rstr_usg_lbl", "");
				}
				
				if ( "7".equals(invtOptionVO.getLocTypeCode()) || "8".equals(invtOptionVO.getLocTypeCode()) || "9".equals(invtOptionVO.getLocTypeCode()) ) {
					arrCdList = JSPUtil.convertStringToArrayList(JSPUtil.replace(invtOptionVO.getLocCd(),",","|"));
					param.put("loccd_list", arrCdList);
		        	velParam.put("loccd_list", arrCdList);        	
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CNTRInventoryReportDBDAOsearchCntrListEqWiseByLocRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvtCntrListVO.class);
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
	 * 조회시점 기준, 지역별로 소재하고 있는 컨테이너 넘버 및 관련 Booking 및 장비관리 정보갯수<br>
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return int
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public int searchCntrListBkgWiseByTotalLoc(InvtOptionVO invtOptionVO) throws DAOException {
		int totalCnt = 0;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		List<String> arrLabelValueList = null;
		List<String> arrCdList = null;
		try{
			if(invtOptionVO != null){
				if ( invtOptionVO.getCntrTpszCd().equals("") ) {
					if ( invtOptionVO.getD2PayldFlg().equals("Y") ) {
						invtOptionVO.setCntrTpszCd("D2");
					}			
					if ( !invtOptionVO.getRfTpCdC().equals("") 
							|| !invtOptionVO.getRfTpCdH().equals("") 
							|| !invtOptionVO.getRfCntr().equals("") 
							|| !invtOptionVO.getRdCgoFlg().equals("") 
					) {
						invtOptionVO.setCntrTpszCd("R2,R5");
					}			
				}					
				Map<String, String> mapVO = invtOptionVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				if ( !JSPUtil.getNull(invtOptionVO.getRstr_usg_lbl()).equals("") ) {
					arrLabelValueList = JSPUtil.convertStringToArrayList(JSPUtil.replace(invtOptionVO.getRstr_usg_lbl(),",","|"));
		        	param.put("labelvalue_list", arrLabelValueList);
		        	velParam.put("labelvalue_list", arrLabelValueList);        	
		        } 
				
				
				if("ALL".equals(invtOptionVO.getRu_lable_type())) {
					param.put("ru_lable_type", "");
					velParam.put("ru_lable_type", "");
				}
				
				
				if("ALL".equals(invtOptionVO.getRstr_usg_lbl())) {
					param.put("rstr_usg_lbl", "");
					velParam.put("rstr_usg_lbl", "");
				}
				
				if ( "7".equals(invtOptionVO.getLocTypeCode()) || "8".equals(invtOptionVO.getLocTypeCode()) || "9".equals(invtOptionVO.getLocTypeCode()) ) {
					arrCdList = JSPUtil.convertStringToArrayList(JSPUtil.replace(invtOptionVO.getLocCd(),",","|"));
					param.put("loccd_list", arrCdList);
		        	velParam.put("loccd_list", arrCdList);        	
				}
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CNTRInventoryReportDBDAOtotalCntBkgWiseByLocRSQL(), param, velParam);
			if(dbRowset.next()) {
	    		totalCnt = dbRowset.getInt("TOTAL_CNT");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return totalCnt;
	}

	/**
	 * 조회시점 기준, 지역별로 소재하고 있는 컨테이너 넘버 및 관련 Booking 및 장비관리 정보를 조회<br>
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<InvtCntrListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvtCntrListVO> searchCntrListBkgWiseByLoc(InvtOptionVO invtOptionVO) throws DAOException {
		int currentPage = invtOptionVO.getIPage();
		int pageRow	  = Integer.parseInt(invtOptionVO.getPagerows());
   	  	int startNo = pageRow * (currentPage -1) +1;
   	  	int endNo   = pageRow *  currentPage;
   	  
		DBRowSet dbRowset = null;
		List<InvtCntrListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		List<String> arrLabelValueList = null;
		List<String> arrCdList = null;
		
		try{
			if(invtOptionVO != null){
				if ( invtOptionVO.getCntrTpszCd().equals("") ) {
					if ( invtOptionVO.getD2PayldFlg().equals("Y") ) {
						invtOptionVO.setCntrTpszCd("D2");
					}			
					if ( !invtOptionVO.getRfTpCdC().equals("") 
							|| !invtOptionVO.getRfTpCdH().equals("") 
							|| !invtOptionVO.getRfCntr().equals("") 
							|| !invtOptionVO.getRdCgoFlg().equals("") 
					) {
						invtOptionVO.setCntrTpszCd("R2,R5");
					}			
				}					
				Map<String, String> mapVO = invtOptionVO.getColumnValues();
				
				param.putAll(mapVO);
		        param.put("startno", startNo);
				param.put("endno", endNo);
		        velParam.putAll(mapVO);
		        velParam.put("startno", startNo);
		        velParam.put("endno", endNo);
				
				if ( !JSPUtil.getNull(invtOptionVO.getRstr_usg_lbl()).equals("") ) {
					arrLabelValueList = JSPUtil.convertStringToArrayList(JSPUtil.replace(invtOptionVO.getRstr_usg_lbl(),",","|"));
		        	param.put("labelvalue_list", arrLabelValueList);
		        	velParam.put("labelvalue_list", arrLabelValueList);        	
		        } 
				
				
				if("ALL".equals(invtOptionVO.getRu_lable_type())) {
					param.put("ru_lable_type", "");
					velParam.put("ru_lable_type", "");
				}
				
				
				if("ALL".equals(invtOptionVO.getRstr_usg_lbl())) {
					param.put("rstr_usg_lbl", "");
					velParam.put("rstr_usg_lbl", "");
				}
				
				if ( "7".equals(invtOptionVO.getLocTypeCode()) || "8".equals(invtOptionVO.getLocTypeCode()) || "9".equals(invtOptionVO.getLocTypeCode()) ) {
					arrCdList = JSPUtil.convertStringToArrayList(JSPUtil.replace(invtOptionVO.getLocCd(),",","|"));
					param.put("loccd_list", arrCdList);
		        	velParam.put("loccd_list", arrCdList);        	
				}
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CNTRInventoryReportDBDAOsearchCntrListBkgWiseByLocRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvtCntrListVO.class);
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
	 * 구주지역내 장비수급 계획을 감안하여, 금일 기준의 Available 장비 대수를 조회한다. <br>
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<StockSmryVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<StockSmryVO> searchStockList(InvtOptionVO invtOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<StockSmryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(invtOptionVO != null){
				String fromBseDt = invtOptionVO.getFromBseDt().replaceAll("-", "");
				String toBseDt = invtOptionVO.getToBseDt().replaceAll("-", "");
				invtOptionVO.setFromBseDt(fromBseDt);
				invtOptionVO.setToBseDt(toBseDt);
				Map<String, String> mapVO = invtOptionVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CNTRInventoryReportDBDAOsearchStockListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, StockSmryVO.class);
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
	 * 구주지역내 SCC 또는 Yard별 MT 재고를 컨테이너별로 조회한다.(팝업)
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<StockByCntrListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<StockByCntrListVO> searchStockCntrList(InvtOptionVO invtOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<StockByCntrListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(invtOptionVO != null){
				String fromBseDt = invtOptionVO.getFromBseDt().replaceAll("-", "");
				String toBseDt = invtOptionVO.getToBseDt().replaceAll("-", "");
				invtOptionVO.setFromBseDt(fromBseDt);
				invtOptionVO.setToBseDt(toBseDt);

				StringTokenizer  st = new StringTokenizer(invtOptionVO.getObjCntrTpszCd(),"|");
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd1  (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd2  (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd3  (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd4  (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd5  (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd6  (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd7  (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd8  (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd9  (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd10 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd11 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd12 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd13 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd14 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd15 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd16 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd17 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd18 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd19 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd20 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd21 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd22 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd23 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd24 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd25 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd26 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd27 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd28 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd29 (st.nextToken());
				if ( st.hasMoreTokens() ) invtOptionVO.setCntrTpszCd30 (st.nextToken());
				
				Map<String, String> mapVO = invtOptionVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CNTRInventoryReportDBDAOsearchStockCntrListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, StockByCntrListVO.class);
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
	 * 구주지역내 MTY 컨테이너의 Release/ Redelivery Order 승인리스트를 확인하여, 해당야드에 반입/ 반출되는 컨테이너 정보를 조회한다.(팝업)
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<StockByCntrListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<StockByCntrListVO> searchStockDueDateList(InvtOptionVO invtOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<StockByCntrListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(invtOptionVO != null){
				String fromBseDt = invtOptionVO.getFromBseDt().replaceAll("-", "");
				String toBseDt = invtOptionVO.getToBseDt().replaceAll("-", "");
				invtOptionVO.setFromBseDt(fromBseDt);
				invtOptionVO.setToBseDt(toBseDt);

				Map<String, String> mapVO = invtOptionVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CNTRInventoryReportDBDAOsearchStockDueDateListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, StockByCntrListVO.class);
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
	 *  구주지역의 특정 LCC/ECC Level 내의 가용 MTY 재고를 Yard별로 생성,수정 여부를 체크.<br>
	 * 
	 * @param StockSmryVO stockSmryVO
	 * @return int
	 * @exception DAOException
	 */
	public int checkAddModifyStock(StockSmryVO stockSmryVO)  throws DAOException {
		DBRowSet dbRowset = null;
		int checkAddModifyCnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = stockSmryVO.getColumnValues();
		 
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CNTRInventoryReportDBDAOcheckAddModifyStockRSQL(), param, velParam);
            while(dbRowset.next()){
            	checkAddModifyCnt = dbRowset.getInt(1);
            }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return checkAddModifyCnt;
	}
	 
	/**
	 *지점별로 향후 2 weeks의 예상 MTY 장비 Supply & Demand를 항목별로 입력한 내용을 생성<br>
	 * 
	 * @param List<StockSmryVO> stockSmryVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addStock (List<StockSmryVO> stockSmryVOs) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(stockSmryVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CNTRInventoryReportDBDAOaddStockCSQL(), stockSmryVOs,null);
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
	} 

	/**
	 *지점별로 향후 2 weeks의 예상 MTY 장비 Supply & Demand를 항목별로 입력한 내용을 수정<br>
	 * 
	 * @param List<StockSmryVO> stockSmryVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyStock(List<StockSmryVO> stockSmryVOs) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(stockSmryVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CNTRInventoryReportDBDAOmodifyStockUSQL(), stockSmryVOs,null);
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
	} 	
	
	/**
	 * Full/ MTY 컨테이너의 장기체류 현황을 지역별,EQ TP&SZ별로 체류 기간조회를 위해 RCC의 Local 시간을 구함.<br>
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<InvtCntrListVO >
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvtCntrListVO> searchRccDateList(InvtOptionVO invtOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvtCntrListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(invtOptionVO  != null){
				Map<String, String> mapVO = invtOptionVO  .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CNTRInventoryReportDBDAOsearchRccDateListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvtCntrListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
}
