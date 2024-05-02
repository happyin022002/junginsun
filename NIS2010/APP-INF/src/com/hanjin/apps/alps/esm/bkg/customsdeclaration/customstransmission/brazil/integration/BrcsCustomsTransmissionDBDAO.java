/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BrcsCustomsTransmissionDBDAO.java
 *@FileTitle : CustomsTransmission
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.25
 *@LastModifier : 경종윤
 *@LastVersion : 1.0
 * 2009.05.25 경종윤
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.brazil.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.brazil.basic.BrcsCustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.brazil.vo.BkgQtyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.brazil.vo.BrBlLocInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.brazil.vo.BrCmVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.brazil.vo.BrCntrRfAkBrCgoInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.brazil.vo.BrDgInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.brazil.vo.BrEtaInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.brazil.vo.BrMndDescInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.brazil.vo.BrRateInfoTTLVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.brazil.vo.BrRateInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.brazil.vo.BrVslCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.brazil.vo.BrVvdSkdInfoVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * NIS2010 BrcsCustomsTransmissionDBDAO <br>
 * - NIS2010-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kyoung Jong Yun
 * @see BrcsCustomsTransmissionBCImpl 참조
 * @since J2EE 1.6
 */
public class BrcsCustomsTransmissionDBDAO extends DBDAOSupport {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 헤더정보를 조회한다.
	 * 
	 * @return String
	 * @throws DAOException
	 */
	public String searchHeader() throws DAOException {
		String retVal = "";
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new BrcsCustomsTransmissionDBDAOsearchHeaderRSQL(), param, velParam);

			if(dbRowset.getRowCount() > 0) {
				
				if (dbRowset.next()) {
					retVal = dbRowset.getString(1);
				}
				
			}

			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return retVal;
	}
	
	
	/**
	 * BKG VVD 정보를 조회한다.<br>
	 * 
	 * @param brVslCondVO
	 * @return BrEtaInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public BrVvdSkdInfoVO searchBkgVvdByVvd(BrVslCondVO brVslCondVO) throws DAOException {
		BrVvdSkdInfoVO brVvdSkdInfoVO = new BrVvdSkdInfoVO();

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (brVslCondVO != null)
			{
				Map<String, String> mapVO = brVslCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new BrcsCustomsTransmissionDBDAOsearchBkgVvdByVvdRSQL(), param, velParam);
			
			List<BrVvdSkdInfoVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset,BrVvdSkdInfoVO.class);
			
			if (list != null && list.size() > 0) {
				brVvdSkdInfoVO = (BrVvdSkdInfoVO) list.get(list.size() - 1);
			}
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return brVvdSkdInfoVO;
	}
	
	
	/**
	 * Vessel 정보, Vessel ETA 정보를 조회한다.<br>
	 * 
	 * @param BrVslCondVO brVslCondVO
	 * @return List<BrEtaInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BrEtaInfoVO> searchVslInfoVsl(BrVslCondVO brVslCondVO) throws DAOException {
		List<BrEtaInfoVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (brVslCondVO != null)
			{
				Map<String, String> mapVO = brVslCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new BrcsCustomsTransmissionDBDAOsearchVslInfoVslRSQL(), param, velParam);
			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,BrEtaInfoVO.class);
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * CNTR_DESC 정보 조회한다.<br>
	 * 
	 * @param brVslCondVO
	 * @return List<BrCmVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BrCmVO> searchCM(BrVslCondVO brVslCondVO) throws DAOException {
		
		List<BrCmVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (brVslCondVO != null)
			{
				Map<String, String> mapVO = brVslCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new BrcsCustomsTransmissionDBDAOsearchCMRSQL(), param, velParam);
			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,BrCmVO.class);
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * NCM No 의 Detail 조회
	 * 
	 * @param brVslCondVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BrCmVO> searchCMdtl(BrVslCondVO brVslCondVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<BrCmVO> list = null;
		
		try
		{
			if (brVslCondVO != null)
			{
				Map<String, String> mapVO = brVslCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new BrcsCustomsTransmissionDBDAOSearchCMdtlRSQL(), param, velParam);
			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,BrCmVO.class);
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	
	/**
	 * BKG의 Mark/Desc 정보를 조회한다.<br>
	 * 
	 * @param BrVslCondVO brVslCondVO
	 * @return BrMndDescInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public BrMndDescInfoVO searchMarkDescInfo(BrVslCondVO brVslCondVO) throws DAOException {
		BrMndDescInfoVO brMndDescInfoVO = new BrMndDescInfoVO();

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (brVslCondVO != null)
			{
				Map<String, String> mapVO = brVslCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new BrcsCustomsTransmissionDBDAOsearchMarkDescInfoRSQL(), param, velParam);
			
			List<BrMndDescInfoVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset,BrMndDescInfoVO.class);
			
			if (list != null && list.size() > 0) {
				brMndDescInfoVO = (BrMndDescInfoVO) list.get(list.size() - 1);
			}
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return brMndDescInfoVO;
	}
	
	/**
	 * BKG Qty를 조회한다.<br>
	 * 
	 * @param BrVslCondVO brVslCondVO
	 * @return List<BkgQtyVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgQtyVO> searchBkgQty(BrVslCondVO brVslCondVO) throws DAOException {
		List<BkgQtyVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (brVslCondVO != null)
			{
				Map<String, String> mapVO = brVslCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new BrcsCustomsTransmissionDBDAOsearchBkgQtyRSQL(), param, velParam);
			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,BkgQtyVO.class);
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * Container 정보 및 Reefer, Break bulk, Akward정보를 조회한다.<br>
	 * 
	 * @param BrVslCondVO brVslCondVO
	 * @return BrCntrRfAkBrCgoInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BrCntrRfAkBrCgoInfoVO> searchCntrRfAkBrCgo(BrVslCondVO brVslCondVO) throws DAOException {
		List<BrCntrRfAkBrCgoInfoVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (brVslCondVO != null)
			{
				Map<String, String> mapVO = brVslCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new BrcsCustomsTransmissionDBDAOsearchCntrRfAkBrCgoRSQL(), param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset,BrCntrRfAkBrCgoInfoVO.class);
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * LCL/FCL 여부를 확인한다.
	 * 
	 * @param BrVslCondVO brVslCondVO
	 * @return
	 * @throws DAOException
	 */
	public String checkLclFcl(BrVslCondVO brVslCondVO) throws DAOException {
		String retVal = "";
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (brVslCondVO != null)
			{
				Map<String, String> mapVO = brVslCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new BrcsCustomsTransmissionDBDAOcheckLclFclRSQL(), param, velParam);

			if (dbRowset.getRowCount() > 0) {
				retVal = "L";
			} else {
				retVal = "F";
			}
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return retVal;
	}
	
	/**
	 * BrDgInfoVO -> 위험물 정보를 조회한다.
	 * 
	 * @param brVslCondVO
	 * @return List<BrDgInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BrDgInfoVO> searchDangerCgo(BrVslCondVO brVslCondVO) throws DAOException {
		
		List<BrDgInfoVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (brVslCondVO != null)
			{
				Map<String, String> mapVO = brVslCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new BrcsCustomsTransmissionDBDAOsearchDangerCgoRSQL(), param, velParam);
			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,BrDgInfoVO.class);
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * Rate 정보를 조회한다.<br>
	 * 
	 * @param BrVslCondVO brVslCondVO
	 * @return List<BrRateInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BrRateInfoVO> searchRateAmount(BrVslCondVO brVslCondVO) throws DAOException {

		List<BrRateInfoVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (brVslCondVO != null)
			{
				Map<String, String> mapVO = brVslCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new BrcsCustomsTransmissionDBDAOsearchRateAmountRSQL(), param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset,BrRateInfoVO.class);
			
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
		
	}

	/**
	 * Rate TOTAL 정보를 조회한다.<br>
	 * 
	 * @param BrVslCondVO brVslCondVO
	 * @return List<BrRateInfoTTLVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BrRateInfoTTLVO> searchRateAmountTTL(BrVslCondVO brVslCondVO) throws DAOException {

		List<BrRateInfoTTLVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (brVslCondVO != null)
			{
				Map<String, String> mapVO = brVslCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new BrcsCustomsTransmissionDBDAOsearchRateAmountTTLRSQL(), param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset,BrRateInfoTTLVO.class);
			
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
		
	}
	
	/**
	 * BL 일반 정보 및 location 정보를 조회한다.<br>
	 * 
	 * @param BrVslCondVO brVslCondVO
	 * @return BrBlLocInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public BrBlLocInfoVO searchBlLocInfo(BrVslCondVO brVslCondVO) throws DAOException {
		
		BrBlLocInfoVO brBlLocInfoVO = new BrBlLocInfoVO();

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (brVslCondVO != null)
			{
				Map<String, String> mapVO = brVslCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new BrcsCustomsTransmissionDBDAOsearchBlLocInfoRSQL(), param, velParam);

			List<BrBlLocInfoVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset,BrBlLocInfoVO.class);
			
			if (list != null && list.size() > 0) {
				brBlLocInfoVO = (BrBlLocInfoVO) list.get(list.size() - 1);
			}
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return brBlLocInfoVO;
	}
	
}
