/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BrcsCustomsTransmissionDBDAO.java
 *@FileTitle : CustomsTransmission
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.14
 *@LastModifier : 김도완
 *@LastVersion : 1.0
 * 2009.09.14 김도완
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.mexico.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration.UsaCustomsTransmissionDBDAOselectSysdateRSQL;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CargoManifestCondForEdiVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.mexico.basic.MexCustomsTransmissionBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.mexico.vo.MxBkgVvdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.mexico.vo.MxBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.mexico.vo.MxChargeTotalVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.mexico.vo.MxChgVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.mexico.vo.MxCmDetailInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.mexico.vo.MxCntrVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.mexico.vo.MxCommodityVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.mexico.vo.MxCustomerVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.mexico.vo.MxDgInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.mexico.vo.MxEtaInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.mexico.vo.MxManifestListByVvdCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.mexico.vo.MxManifestListByVvdDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.mexico.vo.MxMndDescInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.mexico.vo.MxQtyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.mexico.vo.MxTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.mexico.vo.MxUsaCustomsVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.mexico.vo.MxUsaLocVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.mexico.vo.MxUsaNycVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.mexico.vo.MxVslResultVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.mexico.vo.MxVvdModeVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.mexico.vo.VslCondVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.integration.TransshipmentMgtDBDAOsearchTSVvdFor1st2ndRSQL;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TsVvdFor1st2ndInputVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS BrcsCustomsTransmissionDBDAO <br>
 * - ALPS-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim, Do-Wan
 * @see MexCustomsTransmissionBCImpl 참조
 * @since J2EE 1.6
 */
public class MexCustomsTransmissionDBDAO extends DBDAOSupport {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 0370화면, Vessel info를 조회한다.
	 * 
	 * @param VslCondVO vslCondVO
	 * @return MxVslResultVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public MxVslResultVO searchVslEta(VslCondVO vslCondVO) throws DAOException {
	
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List <MxVslResultVO> list = null;
		MxVslResultVO rtnvo = null;
		try
		{			
			Map<String, String> mapVO = vslCondVO.getColumnValues();            
			param.putAll(mapVO);
			velParam.putAll(mapVO);
            
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new MexCustomsTransmissionDBDAOsearchVslEtaRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MxVslResultVO.class);
			if(list != null && list.size() > 0){
				rtnvo = list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnvo;
	}
	
	/**
	 * 0370화면, Mexico Manifest Transmit 내역을 조회한다.
	 * 
	 * @param MxManifestListByVvdCondVO mxManifestListByVvdCondVO
	 * @return List<MxManifestListByVvdDetailVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MxManifestListByVvdDetailVO> searchManifestByVvdPort(MxManifestListByVvdCondVO mxManifestListByVvdCondVO) throws DAOException {
	
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List <MxManifestListByVvdDetailVO> list = null;
		try
		{			
			Map<String, String> mapVO = mxManifestListByVvdCondVO.getColumnValues();            
			param.putAll(mapVO);
			velParam.putAll(mapVO);
            
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new MexCustomsTransmissionDBDAOsearchManifestByVvdPortRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MxManifestListByVvdDetailVO.class);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * BKG VVD 정보를 조회한다.<br>
	 * 
	 * @param MxTransmitVO mxTransmitVO
	 * @return MxEtaInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public MxEtaInfoVO searchVslEtaInfo(MxTransmitVO mxTransmitVO) throws DAOException {
		MxEtaInfoVO rtnvo = new MxEtaInfoVO();

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (mxTransmitVO != null)
			{
				Map<String, String> mapVO = mxTransmitVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new MexCustomsTransmissionDBDAOsearchVslEtaInfoRSQL(), param, velParam);
			
			List<MxEtaInfoVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset,MxEtaInfoVO.class);
			
			if (list != null && list.size() > 0) {
				rtnvo = (MxEtaInfoVO) list.get(list.size() - 1);
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnvo;
	}
	
	/**
	 * Vessel 정보를 조회한다.<br>
	 * 
	 * @param MxTransmitVO mxTransmitVO
	 * @return MxEtaInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public MxEtaInfoVO searchVslInfoVsl(MxTransmitVO mxTransmitVO) throws DAOException {
		MxEtaInfoVO rtnvo = new MxEtaInfoVO();

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (mxTransmitVO != null)
			{
				Map<String, String> mapVO = mxTransmitVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new MexCustomsTransmissionDBDAOsearchVslInfoVslRSQL(), param, velParam);
			
			List<MxEtaInfoVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset,MxEtaInfoVO.class);
			
			if (list != null && list.size() > 0) {
				rtnvo = (MxEtaInfoVO) list.get(list.size() - 1);
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnvo;
	}	

	/**
	 * Commodity 정보를 조회한다.<br>
	 * 
	 * @param MxTransmitVO mxTransmitVO
	 * @return MxCommodityVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public MxCommodityVO searchCommodity(MxTransmitVO mxTransmitVO) throws DAOException {
		MxCommodityVO rtnvo = new MxCommodityVO();

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (mxTransmitVO != null)
			{
				Map<String, String> mapVO = mxTransmitVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new MexCustomsTransmissionDBDAOsearchCommodityRSQL(), param, velParam);
			
			List<MxCommodityVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset,MxCommodityVO.class);
			
			if (list != null && list.size() > 0) {
				rtnvo = (MxCommodityVO) list.get(list.size() - 1);
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnvo;
	}
	

	/**
	 * Usa Loc Info 정보를 조회한다.<br>
	 * 
	 * @param MxTransmitVO mxTransmitVO
	 * @return MxUsaLocVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public MxUsaLocVO searchUsaLocInfo(MxTransmitVO mxTransmitVO) throws DAOException {
		MxUsaLocVO rtnvo = new MxUsaLocVO();

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if ( mxTransmitVO != null )
			{
				Map<String, String> mapVO = mxTransmitVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new MexCustomsTransmissionDBDAOsearchUsaLocInfoRSQL(), param, velParam);
			
			List<MxUsaLocVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset,MxUsaLocVO.class);
			
			if (list != null && list.size() > 0) {
				rtnvo = (MxUsaLocVO) list.get(list.size() - 1);
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnvo;
	}

	/** SCC가 USNYC 인지 여부를 조회한다. 
	 * 
	 * @param MxTransmitVO mxTransmitVO
	 * @return MxUsaNycVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public MxUsaNycVO searchSccUsNyc(MxTransmitVO mxTransmitVO) throws DAOException {
		MxUsaNycVO rtnvo = new MxUsaNycVO();

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if ( mxTransmitVO != null )
			{
				Map<String, String> mapVO = mxTransmitVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new MexCustomsTransmissionDBDAOsearchSccUsNycRSQL(), param, velParam);
			
			List<MxUsaNycVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset,MxUsaNycVO.class);
			
			if (list != null && list.size() > 0) {
				rtnvo = (MxUsaNycVO) list.get(list.size() - 1);
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnvo;
	}
	

	/** EDI 전송 여부를 조회한다. 
	 * 
	 * @param MxTransmitVO mxTransmitVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchEdiSendFlag(MxTransmitVO mxTransmitVO) throws DAOException {
		String rtn = "";

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if ( mxTransmitVO != null )
			{
				Map<String, String> mapVO = mxTransmitVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new MexCustomsTransmissionDBDAOsearchEdiSendFlagRSQL(), param, velParam);
			
			if(dbRowset.getRowCount() > 0) {
				if(dbRowset.next()){
					rtn = dbRowset.getString(1);
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtn;
	}

	/** VVD MODE 를 조회한다. 
	 * 
	 * @param MxTransmitVO mxTransmitVO
	 * @return MxVvdModeVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public MxVvdModeVO searchVvdMode(MxTransmitVO mxTransmitVO) throws DAOException {
		MxVvdModeVO rtnvo = new MxVvdModeVO();

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if ( mxTransmitVO != null )
			{
				Map<String, String> mapVO = mxTransmitVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new MexCustomsTransmissionDBDAOsearchVvdModeRSQL(), param, velParam);
			
			List<MxVvdModeVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset,MxVvdModeVO.class);
			
			if (list != null && list.size() > 0) {
				rtnvo = (MxVvdModeVO) list.get(list.size() - 1);
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnvo;
	}

	/** Feeder 여부를 조회한다. 
	 * 
	 * @param MxTransmitVO mxTransmitVO
	 * @return int
	 * @exception DAOException
	 */
	public int validatePostVvd(MxTransmitVO mxTransmitVO) throws DAOException {
		int rtn = 0;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if ( mxTransmitVO != null )
			{
				Map<String, String> mapVO = mxTransmitVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new MexCustomsTransmissionDBDAOvalidatePostVvdRSQL(), param, velParam);
			
			if(dbRowset.getRowCount() > 0) {
				if(dbRowset.next()){
					rtn = dbRowset.getInt(1);
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtn;
	}

	/** IT_ITNO(IBD_TRSP_NO) 를 조회한다. 
	 * 
	 * @param MxTransmitVO mxTransmitVO
	 * @return MxUsaCustomsVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public MxUsaCustomsVO searchUsaCustoms(MxTransmitVO mxTransmitVO) throws DAOException {
		MxUsaCustomsVO rtnvo = new MxUsaCustomsVO();

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if ( mxTransmitVO != null )
			{
				Map<String, String> mapVO = mxTransmitVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new MexCustomsTransmissionDBDAOsearchUsaCustomsRSQL(), param, velParam);
			
			List<MxUsaCustomsVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset,MxUsaCustomsVO.class);
			
			if (list != null && list.size() > 0) {
				rtnvo = (MxUsaCustomsVO) list.get(list.size() - 1);
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnvo;
	}
	
	/** BL INFO 를 조회한다. 
	 * 
	 * @param MxTransmitVO mxTransmitVO
	 * @return MxBlInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public MxBlInfoVO searchBl(MxTransmitVO mxTransmitVO) throws DAOException {
		MxBlInfoVO rtnvo = new MxBlInfoVO();

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if ( mxTransmitVO != null )
			{
				Map<String, String> mapVO = mxTransmitVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new MexCustomsTransmissionDBDAOsearchBlRSQL(), param, velParam);
			
			List<MxBlInfoVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset,MxBlInfoVO.class);
			
			if (list != null && list.size() > 0) {
				rtnvo = (MxBlInfoVO) list.get(list.size() - 1);
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnvo;
	}

	/** BL INFO 를 조회한다. 
	 * 
	 * @param MxTransmitVO mxTransmitVO
	 * @return MxCustomerVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public MxCustomerVO searchCustomer(MxTransmitVO mxTransmitVO) throws DAOException {
		MxCustomerVO rtnvo = new MxCustomerVO();

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if ( mxTransmitVO != null )
			{
				Map<String, String> mapVO = mxTransmitVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new MexCustomsTransmissionDBDAOsearchCustomerRSQL(), param, velParam);
			
			List<MxCustomerVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset,MxCustomerVO.class);
			
			if (list != null && list.size() > 0) {
				rtnvo = (MxCustomerVO) list.get(list.size() - 1);
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnvo;
	}
	

	/**
	 * Charge Info 내역을 조회한다.
	 * 
	 * @param MxTransmitVO mxTransmitVO
	 * @return List<MxChgVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MxChgVO> searchChargeInfo(MxTransmitVO mxTransmitVO) throws DAOException {
	
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List <MxChgVO> list = null;
		try
		{			
			Map<String, String> mapVO = mxTransmitVO.getColumnValues();            
			param.putAll(mapVO);
			velParam.putAll(mapVO);
            
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new MexCustomsTransmissionDBDAOsearchChargeInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MxChgVO.class);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * Total Charge Info 내역을 조회한다.
	 * 
	 * @param MxTransmitVO mxTransmitVO
	 * @return List<MxChargeTotalVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MxChargeTotalVO> searchChargeTotal(MxTransmitVO mxTransmitVO) throws DAOException {
	
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List <MxChargeTotalVO> list = null;
		try
		{			
			Map<String, String> mapVO = mxTransmitVO.getColumnValues();            
			param.putAll(mapVO);
			velParam.putAll(mapVO);
            
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new MexCustomsTransmissionDBDAOsearchChargeTotalRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MxChargeTotalVO.class);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/** DESC, MARK 를 조회한다. 
	 * 
	 * @param MxTransmitVO mxTransmitVO
	 * @return MxMndDescInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public MxMndDescInfoVO searchMarkDescInfo(MxTransmitVO mxTransmitVO) throws DAOException {
		MxMndDescInfoVO rtnvo = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if ( mxTransmitVO != null )
			{
				Map<String, String> mapVO = mxTransmitVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new MexCustomsTransmissionDBDAOsearchMarkDescInfoRSQL(), param, velParam);
			
			List<MxMndDescInfoVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset,MxMndDescInfoVO.class);
			
			if (list != null && list.size() > 0) {
				rtnvo = (MxMndDescInfoVO) list.get(list.size() - 1);
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnvo;
	}
	
	/**
	 * Cntr Info 내역을 조회한다.
	 * 
	 * @param MxTransmitVO mxTransmitVO
	 * @return List<MxCntrVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MxCntrVO> searchContainerInfo(MxTransmitVO mxTransmitVO) throws DAOException {
	
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List <MxCntrVO> list = null;
		try
		{			
			Map<String, String> mapVO = mxTransmitVO.getColumnValues();            
			param.putAll(mapVO);
			velParam.putAll(mapVO);
            
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new MexCustomsTransmissionDBDAOsearchContainerInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MxCntrVO.class);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	

	/**
	 * Danger Cgo 내역을 조회한다.
	 * 
	 * @param MxTransmitVO mxTransmitVO
	 * @return List<MxDgInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MxDgInfoVO> searchDangerCgo(MxTransmitVO mxTransmitVO) throws DAOException {
	
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List <MxDgInfoVO> list = null;
		try
		{			
			Map<String, String> mapVO = mxTransmitVO.getColumnValues();            
			param.putAll(mapVO);
			velParam.putAll(mapVO);
            
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new MexCustomsTransmissionDBDAOsearchDangerCgoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MxDgInfoVO.class);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * CNTR Desc 내역을 조회한다.
	 * 
	 * @param MxTransmitVO mxTransmitVO
	 * @return List<MxCmDetailInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MxCmDetailInfoVO> searchCmByCntr(MxTransmitVO mxTransmitVO) throws DAOException {
	
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List <MxCmDetailInfoVO> list = null;
		try
		{			
			Map<String, String> mapVO = mxTransmitVO.getColumnValues();            
			param.putAll(mapVO);
			velParam.putAll(mapVO);
            
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new MexCustomsTransmissionDBDAOsearchCmByCntrRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MxCmDetailInfoVO.class);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	

	/**
	 * CNTR Desc 내역을 OUTBOUND 에서 조회한다.
	 * 
	 * @param MxTransmitVO mxTransmitVO
	 * @return List<MxCmDetailInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MxCmDetailInfoVO> searchCmByCntrAtOutBound(MxTransmitVO mxTransmitVO) throws DAOException {
	
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List <MxCmDetailInfoVO> list = null;
		try
		{			
			Map<String, String> mapVO = mxTransmitVO.getColumnValues();            
			param.putAll(mapVO);
			velParam.putAll(mapVO);
            
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new MexCustomsTransmissionDBDAOsearchCmByCntrAtOutBoundRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MxCmDetailInfoVO.class);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	

	/**
	 * CNTR Qty 내역을 조회한다.
	 * 
	 * @param MxTransmitVO mxTransmitVO
	 * @return List<MxQtyVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MxQtyVO> searchQty(MxTransmitVO mxTransmitVO) throws DAOException {
	
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List <MxQtyVO> list = null;
		try
		{			
			Map<String, String> mapVO = mxTransmitVO.getColumnValues();            
			param.putAll(mapVO);
			velParam.putAll(mapVO);
            
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new MexCustomsTransmissionDBDAOsearchQtyRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MxQtyVO.class);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * CNTR Qty 내역을 조회한다.
	 * 
	 * @param MxTransmitVO mxTransmitVO
	 * @return List<MxBkgVvdVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MxBkgVvdVO> searchBkgVvd(MxTransmitVO mxTransmitVO) throws DAOException {
	
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List <MxBkgVvdVO> list = null;
		try
		{			
			Map<String, String> mapVO = mxTransmitVO.getColumnValues();            
			param.putAll(mapVO);
			velParam.putAll(mapVO);
            
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new MexCustomsTransmissionDBDAOsearchBkgVvdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MxBkgVvdVO.class);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * Sysdate 를 조회한다.
	 * 
	 * @return String
	 * @throws DAOException
	 */
	public String searchSysdate() throws DAOException {
		String retVal = "";
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			param.put("format", "YYYYMMDD HH24MISS");
			velParam.put("format", "YYYYMMDD HH24MISS");
			
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaCustomsTransmissionDBDAOselectSysdateRSQL(), param, velParam);

			if(dbRowset.getRowCount() > 0) {
				
				if (dbRowset.next()) {
					retVal = dbRowset.getString(1);
				}
				
			}

			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retVal;
	}
	
	/**
	 * pod를 drop down으로 조회한다.<br>
	 * 
	 * @param  CargoManifestCondForEdiVO cond
	 * @return List<BkgComboVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgComboVO> searchManifestPodList(CargoManifestCondForEdiVO cond) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgComboVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cond != null){
				Map<String, String> mapVO = cond.getColumnValues();
			    
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				 
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MexCustomsTransmissionDBDAOsearchManifestPodListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgComboVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	} 
}
