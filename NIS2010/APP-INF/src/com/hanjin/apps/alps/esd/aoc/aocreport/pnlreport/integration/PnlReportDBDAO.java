/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PnlReportDBDAO.java
*@FileTitle : PnL Report
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2012.07.17 변종건 [CHM-201217633] Profit & Loss Report for Inland BIZ 생성
* 2013.03.26 이재위 [CHM-201323626] AOC P&L Report 대상 확대 - BKG/TRS DATA 요청
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.aocreport.pnlreport.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.aoc.aocreport.pnlreport.basic.PnlReportBCImpl;
import com.hanjin.apps.alps.esd.aoc.aocreport.pnlreport.vo.PnLBkgDtlListVO;
import com.hanjin.apps.alps.esd.aoc.aocreport.pnlreport.vo.PnLBkgListVO;
import com.hanjin.apps.alps.esd.aoc.aocreport.pnlreport.vo.PnLRptOptionVO;
import com.hanjin.apps.alps.esd.aoc.aocreport.pnlreport.vo.PnLRptSmryListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ESD-AOC에 대한 DB 처리를 담당<br>
 * - ESD-AOC Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author 
 * @see PnlReportBCImpl 참조
 * @since J2EE 1.4
 */
public class PnlReportDBDAO extends DBDAOSupport {
	
	/**
	 * Profit & Loss Report for Inland BIZ - Sales View Summary 조회.<br>
	 * 
	 * @param inputVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PnLRptSmryListVO> searchPnLSlsVwList(PnLRptOptionVO inputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PnLRptSmryListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if( inputVO != null ){
				Map<String, String> mapVO = inputVO .getColumnValues();
				 
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PnlReportDBDAOSearchPnLSlsVwListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PnLRptSmryListVO .class);
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
	 * Profit & Loss Report for Inland BIZ - Operation View Summary 조회.<br>
	 * 
	 * @param inputVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PnLRptSmryListVO> searchPnLOpVwList(PnLRptOptionVO inputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PnLRptSmryListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if( inputVO != null ){
				Map<String, String> mapVO = inputVO .getColumnValues();
				 
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PnlReportDBDAOSearchPnLOpVwListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PnLRptSmryListVO .class);
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
	 * Profit & Loss Report for Inland BIZ - BKG List 조회.<br>
	 * 
	 * @param inputVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PnLBkgListVO> searchPnLBkgList(PnLRptOptionVO inputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PnLBkgListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if( inputVO != null ){
				Map<String, String> mapVO = inputVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PnlReportDBDAOSearchPnLBkgListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PnLBkgListVO .class);
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
	 * Profit & Loss Report for Inland BIZ - BKG List 조회.<br>
	 * 
	 * @param inputVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PnLBkgDtlListVO> searchPnLBkgDtlList(PnLBkgDtlListVO inputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PnLBkgDtlListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if( inputVO != null ){
				Map<String, String> mapVO = inputVO .getColumnValues();
				 
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PnlReportDBDAOSearchPnLBkgDtlListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PnLBkgDtlListVO .class);
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
	 * Service Scope 콤보리스트 조회
	 * 
	 * @param inputVO
	 * @return
	 * @throws DAOException
	 */
	public String[] searchSvcScp(PnLRptOptionVO inputVO) throws DAOException {
		String[] sResult = null;
		DBRowSet dbRowset = null;
		ArrayList<String> tmpList = new ArrayList<String>();
 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if( inputVO != null ){
				Map<String, String> mapVO = inputVO .getColumnValues();
				 
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PnlReportDBDAOSearchSvcScpRSQL(), param, velParam);
			
            while ( dbRowset.next() ) {
            	tmpList.add(dbRowset.getString("SVC_SCP_CD"));
            }
            
			if(!tmpList.isEmpty()) {
            	sResult = (String[])tmpList.toArray(new String[0]);
            }

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
        return sResult;
	}
	
	/**
	 * Customer Code를 조회한다<br>
	 * 
	 * @param inputVO
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchCustomerInfo(PnLRptOptionVO inputVO) throws DAOException{
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if( inputVO != null ){
				Map<String, String> mapVO = inputVO .getColumnValues();
				 
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(new PnlReportDBDAOSearchCustomerInfoRSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
		return dbRowset;
	}
}