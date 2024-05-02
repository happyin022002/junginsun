/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeOfficeTransferMgtDBDAO.java
*@FileTitle : Office Transfer History
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.07.14 황효근
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeofficetransfermgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeofficetransfermgt.basic.ChargeOfficeTransferMgtBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeofficetransfermgt.vo.DmtOfcTrnsHisVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeofficetransfermgt.vo.OfficeTransferHistoryByContainerVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeofficetransfermgt.vo.OfficeTransferParmVO;


/**
 * ALPS ChargeOfficeTransferMgtDBDAO <br>
 * - ALPS-DMTClosing system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Hwang HyoKeun
 * @see ChargeOfficeTransferMgtBCImpl 참조
 * @since J2EE 1.6
 */
public class ChargeOfficeTransferMgtDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7682548417536291694L;


	/**
	 * Office/날짜별로 Office Transfer 내역 정보를 조회한다.
	 * 
	 * @param OfficeTransferParmVO officeTransferParmVO
	 * @return List<DmtOfcTrnsHisVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<DmtOfcTrnsHisVO> searchOfficeTransferHistoryList(OfficeTransferParmVO officeTransferParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DmtOfcTrnsHisVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(officeTransferParmVO != null){
				Map<String, String> mapVO = officeTransferParmVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				String trfCd = officeTransferParmVO.getDmdtTrfCd();
				List<String> trfCdList = new ArrayList<String>();
				StringTokenizer st1 = new StringTokenizer(trfCd, ",");
			    while (st1.hasMoreTokens()) {
			    	trfCdList.add(st1.nextToken());
			    }
				velParam.put("trf_cd_list", trfCdList);
				
				
				if(officeTransferParmVO.getCondType().equals("cntr")) {
					if(!officeTransferParmVO.getBkgNo().equals("")) {
						String bkgNo = officeTransferParmVO.getBkgNo();
						List<String> bkgNoList = new ArrayList<String>();
						StringTokenizer st3 = new StringTokenizer(bkgNo, ",");
					    while (st3.hasMoreTokens()) {
					    	bkgNoList.add(st3.nextToken());
					    }
						velParam.put("bkg_no_list", bkgNoList);
					}
					
					if(!officeTransferParmVO.getBlNo().equals("")) {
						String blNo = officeTransferParmVO.getBlNo();
						List<String> blNoList = new ArrayList<String>();
						StringTokenizer st4 = new StringTokenizer(blNo, ",");
					    while (st4.hasMoreTokens()) {
					    	blNoList.add(st4.nextToken());
					    }
						velParam.put("bl_no_list", blNoList);
					}
					
					if(!officeTransferParmVO.getCntrNo().equals("")) {
						String cntrNo = officeTransferParmVO.getCntrNo();
						List<String> cntrNoList = new ArrayList<String>();
						StringTokenizer st5 = new StringTokenizer(cntrNo, ",");
					    while (st5.hasMoreTokens()) {
					    	cntrNoList.add(st5.nextToken());
					    }
						velParam.put("cntr_no_list", cntrNoList);
					}
				}
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeOfficeTransferMgtDBDAODmtOfcTrnsHisVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DmtOfcTrnsHisVO .class);
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
	 * 해당 Office Code에 대한 SYS_ARER_GRP_ID 정보를 조회한다.
	 * 
	 * @param  String fmOfcCd
	 * @param  String toOfcCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchOfficeTransferToServerID(String fmOfcCd, String toOfcCd) throws DAOException {
		
		//List<ChargeCalculationContainerVO> list = null;
		//CalculationTypeParmVO calculationTypeParmVO = new CalculationTypeParmVO();
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("fm_ofc_cd", fmOfcCd);
			param.put("to_ofc_cd", toOfcCd);
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeOfficeTransferMgtDBDAOSearchOfficeTransferToServerIDRSQL(), param, null);
			
			String result = "Y";
			if(dbRowset.next())
				result = dbRowset.getString(1);
			
			return result;

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	 /**
	 * 현재 날짜와 To MVMT Date 사이의 기간차를 조회한다.
	 * 
	 * @param  ChargeArgumentVO chargeArgumentVO
	 * @return int
	 * @throws DAOException
	 */
	public int getFinishedGapDate(ChargeArgumentVO chargeArgumentVO) throws DAOException {
		
		//List<ChargeCalculationContainerVO> list = null;
		//CalculationTypeParmVO calculationTypeParmVO = new CalculationTypeParmVO();
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(chargeArgumentVO != null) {
				Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery(
						(ISQLTemplate)new ChargeOfficeTransferMgtDBDAOGetFinishedGapDateRSQL(), param, null);
			
			int result = 0;
			if(dbRowset.next())
				result = dbRowset.getInt(1);
			
			return result;

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	 /**
	 * 해당 Charge의 OFC_TRNS_SEQ 정보를 조회한다.
	 * 
	 * @param  ChargeArgumentVO chargeArgumentVO
	 * @return int
	 * @throws DAOException
	 */
	public int searchOfficeTransferMaxSEQ(ChargeArgumentVO chargeArgumentVO) throws DAOException {
		
		//List<ChargeCalculationContainerVO> list = null;
		//CalculationTypeParmVO calculationTypeParmVO = new CalculationTypeParmVO();
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(chargeArgumentVO != null) {
				Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery(
						(ISQLTemplate)new ChargeOfficeTransferMgtDBDAOSearchOfficeTransferMaxSEQRSQL(), param, null);
			
			int result = 0;
			if(dbRowset.next())
				result = dbRowset.getInt(1);
			
			return result;

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Office Transfer History 정보를 생성한다.
	 * 
	 * @param DmtOfcTrnsHisVO dmtOfcTrnsHisVO
	 * @throws DAOException
	 */
	public void addOfficeTransferHistory(DmtOfcTrnsHisVO dmtOfcTrnsHisVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = dmtOfcTrnsHisVO.getColumnValues();
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int result = 0;
			result = sqlExe.executeUpdate((ISQLTemplate)new ChargeOfficeTransferMgtDBDAODmtOfcTrnsHisVOCSQL(), param, null);
			
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
	 * Charge별 Office Transfer History 정보를 조회한다.
	 * 
	 * @param  OfficeTransferParmVO officeTransferParmVO
	 * @return List<OfficeTransferHistoryByContainerVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OfficeTransferHistoryByContainerVO> searchOfficeTransferHistoryListByContainer(OfficeTransferParmVO officeTransferParmVO) throws DAOException {
		
		List<OfficeTransferHistoryByContainerVO> list = null;
		//CalculationTypeParmVO calculationTypeParmVO = new CalculationTypeParmVO();
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(officeTransferParmVO != null) {
				Map<String, String> mapVO = officeTransferParmVO.getColumnValues();
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery(
						(ISQLTemplate)new ChargeOfficeTransferMgtDBDAOOfficeTransferHistoryByContainerVORSQL(), param, null);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OfficeTransferHistoryByContainerVO.class);
			return list;

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	 /**
	 * 해당 Charge에 대한 DMT_OFC_TRNS_HIS 정보의 존재여부를 조회한다.
	 * 
	 * @param  DmtOfcTrnsHisVO dmtOfcTrnsHisVO
	 * @return String
	 * @throws DAOException
	 */
	public String checkOfficeTransferHistoryByPartialPayment(DmtOfcTrnsHisVO dmtOfcTrnsHisVO) throws DAOException {
		
		//List<ChargeCalculationContainerVO> list = null;
		//CalculationTypeParmVO calculationTypeParmVO = new CalculationTypeParmVO();
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(dmtOfcTrnsHisVO != null) {
				Map<String, String> mapVO = dmtOfcTrnsHisVO.getColumnValues();
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery(
						(ISQLTemplate)new ChargeOfficeTransferMgtDBDAOCheckOfficeTransferHistoryByPartialPaymentRSQL(), param, null);
			
			String result = "N";
			if(dbRowset.next())
				result = dbRowset.getString(1);
			
			return result;

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Office Transfer된 Charge를 Partial 하는 경우, 새로 생성되는 Charge의 Office Transfer History 정보를 생성한다.
	 * 
	 * @param DmtOfcTrnsHisVO dmtOfcTrnsHisVO
	 * @throws DAOException
	 */
	public void addOfficeTransferHistoryByPartialPayment(DmtOfcTrnsHisVO dmtOfcTrnsHisVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = dmtOfcTrnsHisVO.getColumnValues();
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int result = 0;
			result = sqlExe.executeUpdate((ISQLTemplate)new ChargeOfficeTransferMgtDBDAOAddOfficeTransferHistoryByPartialPaymentCSQL(), param, null);
			
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