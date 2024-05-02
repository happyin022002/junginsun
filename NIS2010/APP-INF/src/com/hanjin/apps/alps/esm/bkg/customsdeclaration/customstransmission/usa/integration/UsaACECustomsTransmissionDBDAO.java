/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UsaACECustomsTransmissionDBDAO.java
 *@FileTitle : UsaCustomsTransmissionDBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.25
 *@LastModifier : 경종윤
 *@LastVersion : 1.0
 * 2009.05.25 경종윤
 * 1.0 Creation
 * --------------------------------------------------------
 * History                       
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.basic.UsaCustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.CstmsNtcSndInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaContainerInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaMiHiHeadFootCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaMiHiHeaderFooterVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/** 
 * ALPS BrcsCustomsTransmissionDBDAO <br>
 * - ALPS-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kyoung Jong Yun
 * @see UsaCustomsTransmissionBCImpl 참조
 * @since J2EE 1.6
 */
public class UsaACECustomsTransmissionDBDAO extends DBDAOSupport {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
		
	/**
	 * 헤더, footer 정보를 조회한다.<br>
	 * 
	 * @param UsaMiHiHeadFootCondVO usaMiHiHeadFootCondVO
	 * @return UsaMiHiHeaderFooterVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public UsaMiHiHeaderFooterVO searchMiHiHeaderFooter(UsaMiHiHeadFootCondVO usaMiHiHeadFootCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<UsaMiHiHeaderFooterVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = usaMiHiHeadFootCondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaACECustomsTransmissionDBDAOsearchMiHiHeaderFooterRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaMiHiHeaderFooterVO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list.get(0);
	}	

	/**
	 * 헤더, footer 정보를 조회한다.<br>
	 * 
	 * @param UsaMiHiHeadFootCondVO usaMiHiHeadFootCondVO
	 * @return UsaMiHiHeaderFooterVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public UsaMiHiHeaderFooterVO searchMiHiHeaderFooterOB(UsaMiHiHeadFootCondVO usaMiHiHeadFootCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<UsaMiHiHeaderFooterVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = usaMiHiHeadFootCondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaACECustomsTransmissionDBDAOsearchMiHiHeaderFooterOBRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaMiHiHeaderFooterVO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list.get(0);
	}	
	
	
	/**
	 * Container 정보를 조회한다.
	 * 
	 * @param String blNo
	 * @param String gubun
	 * @return List<UsaContainerInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UsaContainerInfoVO> searchContainerInfo(String blNo, String gubun) throws DAOException {
		// UsaContainerInfoVO
		List<UsaContainerInfoVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);

			if(gubun == null){
				gubun = "N";
			}
			log.debug("gubun = "+gubun);
						
			param.put("gubun", gubun);
			velParam.put("gubun", gubun);								
									
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaACECustomsTransmissionDBDAOsearchCntrLineRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaContainerInfoVO.class);
			/*
			 * if(list != null && list.size() > 0 ){ UsaContainerInfoVO = list.get(0); }
			 */
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	
	

	/**
	 * Export Container 정보를 조회한다.
	 * 
	 * @param String blNo
	 * @param String gubun
	 * @param String vvd
	 * @return List<UsaContainerInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UsaContainerInfoVO> searchContainerInfoOB(String blNo, String gubun, String vvd) throws DAOException {
		// UsaContainerInfoVO
		List<UsaContainerInfoVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);

			if(gubun == null){
				gubun = "N";
			}
			log.debug("gubun = "+gubun);
						
			param.put("gubun", gubun);
			velParam.put("gubun", gubun);								
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);			
									
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaACECustomsTransmissionDBDAOsearchCntrLineOBRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaContainerInfoVO.class);
			/*
			 * if(list != null && list.size() > 0 ){ UsaContainerInfoVO = list.get(0); }
			 */
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	

	/**
	 * HI H01 정보를 조회한다.
	 * 
	 * @param String vpsEtdDt
	 * @param String polLoc
	 * @param String podAmsPortcd
	 * @param String vpsEtaDtA
	 * @param String fieldName
	 * @return String
	 * @throws DAOException
	 */
	public String searchH01(String vpsEtdDt, String polLoc, String podAmsPortcd, String vpsEtaDtA, String fieldName) throws DAOException {
		String retVal = "";
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{						
			if(vpsEtdDt.length() == 10){
				String vpsEtdDt2 = vpsEtdDt.substring(0,6);
				String vpsEtdDt3 = vpsEtdDt.substring(6,10);
												
				if(("H01".equals(fieldName) || "H02".equals(fieldName))  && "0000".equals(vpsEtdDt3)){
					vpsEtdDt3 = "0001";
					vpsEtdDt = vpsEtdDt2 + vpsEtdDt3;
				}			
			}

			param.put("vps_etd_dt", vpsEtdDt);
			velParam.put("vps_etd_dt", vpsEtdDt);
			param.put("pol_loc", polLoc);
			velParam.put("pol_loc", polLoc);
			param.put("pod_ams_port_cd", podAmsPortcd);
			velParam.put("pod_ams_port_cd", podAmsPortcd);
			param.put("vps_eta_dt_a", vpsEtaDtA);
			velParam.put("vps_eta_dt_a", vpsEtaDtA);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaACECustomsTransmissionDBDAOsearchH01RSQL(), param, velParam);
			if (dbRowset.next())
			{
				retVal = dbRowset.getString(fieldName);
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return retVal;
	}	
	
	/**
	 * cstms notice 대상 e-mail 정보 조회
	 * 
	 * @param CstmsNtcSndInfoVO cstmsNtcSndInfoVO
	 * @return List<CstmsNtcSndInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CstmsNtcSndInfoVO> searhCstmsNtcSndInfo(CstmsNtcSndInfoVO cstmsNtcSndInfoVO) throws DAOException {
		// UsaContainerInfoVO
		List<CstmsNtcSndInfoVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = cstmsNtcSndInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);							
									
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaACECustomsTransmissionDBDAOsearhCstmsNtcSndInfoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CstmsNtcSndInfoVO.class);

		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	
}