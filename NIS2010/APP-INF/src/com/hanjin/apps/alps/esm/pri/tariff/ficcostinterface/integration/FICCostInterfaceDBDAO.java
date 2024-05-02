/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : FICCostInterfaceDBDAO.java
 *@FileTitle : ADD-ON/IHC Process DBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.5.08
 *@LastModifier : 이은섭
 *@LastVersion : 1.0
 * 2012.5.08 이은섭
 * 1.0 Creation
 * ------------------------------------------------------
 * History
 * 2013.04.29 김보배 [CHM-201324375] Publish 기능 이전 요청
 * 2015.07.08 현성길 [CHM-201536782] EUR와 SHA/SIN 로직 분리
=========================================================*/

package com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.basic.FICCostInterfaceBCImpl;
import com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.vo.AddOnCostTraiffListVO;
import com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.vo.CheckCopyServiceScopeVO;
import com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.vo.CheckFDRCopyServiceScopeVO;
import com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.vo.CopyTariffFdrVO;
import com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.vo.CopyTariffIhcVO;
import com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.vo.IHCCostTariffInterfaceListVO;
import com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.vo.PriTrfFdrHdrVO;
import com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.vo.PriTrfIhcHdrVO;
import com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.vo.TariffCodeMappingVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.CheckUtils;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010 FICCostInterfaceDBDAO <br>
 * - Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Eun-Sup Lee
 * @see FICCostInterfaceBCImpl 참조
 * @since J2EE 1.4
 */
public class FICCostInterfaceDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * ESM_PRI_7021_01 : Cost Table Interface - Add-on Tariff TAB ==> Retrieve
	 * 
	 * @param svcScpCd
	 * @param rhq_cd
	 * @param org_dest_tp_cd
	 * @return List<AddOnCostTraiffListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<AddOnCostTraiffListVO> searchAddOnCostTariffList(String svcScpCd, String rhq_cd, String org_dest_tp_cd) throws DAOException {
		DBRowSet dbRowset = null;
		List<AddOnCostTraiffListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		Map<String, String> mapVO = new HashMap<String, String>();
		mapVO.put("svc_scp_cd", svcScpCd);
		mapVO.put("rhq_cd", rhq_cd);
		mapVO.put("org_dest_tp_cd", org_dest_tp_cd);
		param.putAll(mapVO);
		velParam.putAll(mapVO);

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new FICCostInterfaceDBDAOSearchAddOnCostTraiffListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, AddOnCostTraiffListVO.class);
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
	 * ESM_PRI_7021_02 : Cost Table Interface - IHC Tariff TAB ==> Retrieve
	 * 
	 * @param svcScpCd
	 * @param cntCd
	 * @param rhq_cd
	 * @param org_dest_tp_cd
	 * @return List<IHCCostTariffInterfaceListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<IHCCostTariffInterfaceListVO> searchIHCCostTariffList(String svcScpCd, String cntCd, String rhq_cd, String org_dest_tp_cd) throws DAOException {
		DBRowSet dbRowset = null;
		List<IHCCostTariffInterfaceListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		Map<String, String> mapVO = new HashMap<String, String>();
		mapVO.put("svc_scp_cd", svcScpCd);
		mapVO.put("rhq_cd", rhq_cd);
		mapVO.put("org_dest_tp_cd", org_dest_tp_cd);
		param.putAll(mapVO);

		String[] cntCds = cntCd.split(Pattern.quote(","));
		if (cntCds.length > 0) {
			List<String> cntCd_param = new ArrayList<String>();
			for (String country : cntCds) {
				if (!CheckUtils.isInBlank(country))
					cntCd_param.add(country);
			}
			if (cntCd_param.size() > 0)
				velParam.put("cnt_cd", cntCd_param);
				velParam.put("rhq_cd", rhq_cd);
				velParam.put("org_dest_tp_cd", org_dest_tp_cd);
		}
		velParam.putAll(mapVO);
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new FICCostInterfaceDBDAOSearchIhcCostTariffInterfaceListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, IHCCostTariffInterfaceListVO.class);
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
	 * INSERT - PRI_TRF_IHC_HDR
	 * 
	 * @param costTrfNo
	 * @throws DAOException
	 */
	public void addTariffIhcHeaderData(PriTrfIhcHdrVO priTrfIhcHdrVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			if (priTrfIhcHdrVO != null) {
				Map<String, String> mapVO = priTrfIhcHdrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				@SuppressWarnings("unused")
				int rslt = sqlExe.executeUpdate((ISQLTemplate) new FICCostInterfaceDBDAOAddTariffIhcHeaderDataCSQL(), param, velParam);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * INSERT - PRI_TRF_IHC_MN
	 * 
	 * @param costTrfNo
	 * @throws DAOException
	 */
	public void addTariffIhcMainData(PriTrfIhcHdrVO priTrfIhcHdrVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();
			if (priTrfIhcHdrVO != null) {
				Map<String, String> mapVO = priTrfIhcHdrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				@SuppressWarnings("unused")
				int rslt = sqlExe.executeUpdate((ISQLTemplate) new FICCostInterfaceDBDAOAddTariffIhcMainDataCSQL(), param, velParam);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * INSERT - PRI_TRF_IHC_RT (DR)
	 * 
	 * @param PriTrfIhcHdrVO priTrfIhcHdrVO
	 * @throws DAOException
	 */
	public void addTariffIhcRateData(PriTrfIhcHdrVO priTrfIhcHdrVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();
			if (priTrfIhcHdrVO != null) {
				Map<String, String> mapVO = priTrfIhcHdrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				@SuppressWarnings("unused")
				int rslt = sqlExe.executeUpdate((ISQLTemplate) new FICCostInterfaceDBDAOAddTariffIhcRateDataCSQL(), param, velParam);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * INSERT - PRI_TRF_IHC_RT (RF)
	 * 
	 * @param PriTrfIhcHdrVO priTrfIhcHdrVO
	 * @throws DAOException
	 */
	public void addTariffIhcRFRateData(PriTrfIhcHdrVO priTrfIhcHdrVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();
			if (priTrfIhcHdrVO != null) {
				Map<String, String> mapVO = priTrfIhcHdrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				@SuppressWarnings("unused")
				int rslt = sqlExe.executeUpdate((ISQLTemplate) new FICCostInterfaceDBDAOAddTariffIhcRFRateDataCSQL(), param, velParam);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Tariff Duration Data 추가
	 * 
	 * @param priTrfIhcHdrVO
	 * @throws DAOException
	 */
	public void addTariffIhcDurationData(PriTrfIhcHdrVO priTrfIhcHdrVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();
			if (priTrfIhcHdrVO != null) {
				Map<String, String> mapVO = priTrfIhcHdrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				@SuppressWarnings("unused")
				int rslt = sqlExe.executeUpdate((ISQLTemplate) new FICCostInterfaceDBDAOAddTariffIhcDurationDataCSQL(), param, velParam);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Special Cargo Rate Date 추가
	 * 
	 * @param priTrfIhcHdrVO
	 * @throws DAOException
	 */
	public void addTariffIhcSpecialCargoRateData(PriTrfIhcHdrVO priTrfIhcHdrVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();
			if (priTrfIhcHdrVO != null) {
				Map<String, String> mapVO = priTrfIhcHdrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				@SuppressWarnings("unused")
				int rslt = sqlExe.executeUpdate((ISQLTemplate) new FICCostInterfaceDBDAOAddTariffIhcSpecialCargoRateDataCSQL(), param, velParam);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * PRI_TRF_IHC_PROG 추가
	 * 
	 * @param priTrfIhcHdrVO
	 * @throws DAOException
	 */
	public void addTariffIhcProgressData(PriTrfIhcHdrVO priTrfIhcHdrVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();
			if (priTrfIhcHdrVO != null) {
				Map<String, String> mapVO = priTrfIhcHdrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				@SuppressWarnings("unused")
				int rslt = sqlExe.executeUpdate((ISQLTemplate) new FICCostInterfaceDBDAOAddTariffIhcProcressDataCSQL(), param, velParam);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * IHC_TRF_NO : SEQUENCE 조회
	 * 
	 * @param IHCCostTariffInterfaceListVO iHCCostTariffInterfaceListVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchIhcTariffNumber(IHCCostTariffInterfaceListVO iHCCostTariffInterfaceListVO) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		String ihcTrfNo = "";

		try {
			if(iHCCostTariffInterfaceListVO != null){
				Map<String, String> mapVO = iHCCostTariffInterfaceListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new FICCostInterfaceDBDAOSearchIhcTariffNoRSQL(), param, velParam);
			if (dbRowset.next())
				ihcTrfNo = dbRowset.getString(1);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return ihcTrfNo;
	}

	// Feeder 처리

	/**
	 * IHC_TRF_NO : SEQUENCE 조회
	 * 
	 * @param svcScpCd
	 * @param org_dest_tp_cd
	 * @param rhq_cd
	 * @return
	 * @throws DAOException
	 */
	public String searchFeederTariffNumber(String svcScpCd, String org_dest_tp_cd , String rhq_cd) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		String ihcTrfNo = "";

		Map<String, String> mapVO = new HashMap<String, String>();
		mapVO.put("svc_scp_cd", svcScpCd);
		mapVO.put("org_dest_tp_cd", org_dest_tp_cd);
		mapVO.put("rhq_cd", rhq_cd);
		param.putAll(mapVO);
		velParam.putAll(mapVO);
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new FICCostInterfaceDBDAOSearchFeederTariffNoRSQL(), param, velParam);
			if (dbRowset.next())
				ihcTrfNo = dbRowset.getString(1);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return ihcTrfNo;
	}

	/**
	 * 
	 * @param priTrfFdrHdrVO
	 * @throws DAOException
	 */
	public void addTariffFeederHeaderData(PriTrfFdrHdrVO priTrfFdrHdrVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			if (priTrfFdrHdrVO != null) {
				Map<String, String> mapVO = priTrfFdrHdrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				@SuppressWarnings("unused")
				int rslt = sqlExe.executeUpdate((ISQLTemplate) new FICCostInterfaceDBDAOAddTariffFeederHeaderDataCSQL(), param, velParam);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * insert - Pricing Tariff Feeder Main
	 * 
	 * @param priTrfFdrHdrVO
	 * @throws DAOException
	 */
	public void addTariffFeederMainData(PriTrfFdrHdrVO priTrfFdrHdrVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();
			if (priTrfFdrHdrVO != null) {
				Map<String, String> mapVO = priTrfFdrHdrVO.getColumnValues();
				param.putAll(mapVO);

				String[] costTrfNos = priTrfFdrHdrVO.getCostTrfNo().split(Pattern.quote(","));
				List<String> costTrfNo_param = new ArrayList<String>();
				for (String costTrfNo : costTrfNos) {
					if (!CheckUtils.isInBlank(costTrfNo))
						costTrfNo_param.add(costTrfNo);
				}
				if (costTrfNo_param.size() > 0)
					velParam.put("costtrfno", costTrfNo_param);
				velParam.putAll(mapVO);

				@SuppressWarnings("unused")
				int rslt = sqlExe.executeUpdate((ISQLTemplate) new FICCostInterfaceDBDAOAddTariffFeederMainDataCSQL(), param, velParam);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * insert - Pricing tariff Feeder Duration
	 * 
	 * @param priTrfFdrHdrVO
	 * @throws DAOException
	 */
	public void addTariffFeederDurationData(PriTrfFdrHdrVO priTrfFdrHdrVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();
			if (priTrfFdrHdrVO != null) {
				Map<String, String> mapVO = priTrfFdrHdrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				@SuppressWarnings("unused")
				int rslt = sqlExe.executeUpdate((ISQLTemplate) new FICCostInterfaceDBDAOAddTariffFeederDurationDataCSQL(), param, velParam);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * INSERT - Pricing tariff feeder rate
	 * 
	 * @param priTrfFdrHdrVO
	 * @throws DAOException
	 */
	public void addTariffFeederRateData(PriTrfFdrHdrVO priTrfFdrHdrVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();
			if (priTrfFdrHdrVO != null) {
				Map<String, String> mapVO = priTrfFdrHdrVO.getColumnValues();
				param.putAll(mapVO);

				String[] costTrfNos = priTrfFdrHdrVO.getCostTrfNo().split(Pattern.quote(","));
				List<String> costTrfNo_param = new ArrayList<String>();
				for (String costTrfNo : costTrfNos) {
					if (!CheckUtils.isInBlank(costTrfNo))
						costTrfNo_param.add(costTrfNo);
				}
				if (costTrfNo_param.size() > 0)
					velParam.put("costtrfno", costTrfNo_param);

				velParam.putAll(mapVO);

				@SuppressWarnings("unused")
				int rslt = sqlExe.executeUpdate((ISQLTemplate) new FICCostInterfaceDBDAOAddTariffFeederRateDataCSQL(), param, velParam);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Insert - Pricing Tariff Feeder Progress
	 * 
	 * @param priTrfFdrHdrVO
	 * @throws DAOException
	 */
	public void addTariffFeederProgressData(PriTrfFdrHdrVO priTrfFdrHdrVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();
			if (priTrfFdrHdrVO != null) {
				Map<String, String> mapVO = priTrfFdrHdrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				@SuppressWarnings("unused")
				int rslt = sqlExe.executeUpdate((ISQLTemplate) new FICCostInterfaceDBDAOAddTariffFeederProgressDataCSQL(), param, velParam);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Insert - Pricing Tariff Feeder Cost Version Mapping
	 * 
	 * @param priTrfFdrHdrVO
	 * @throws DAOException
	 */
	public void addTariffFeederCostVersionMappingData(PriTrfFdrHdrVO priTrfFdrHdrVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();
			if (priTrfFdrHdrVO != null) {
				Map<String, String> mapVO = priTrfFdrHdrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				@SuppressWarnings("unused")
				int rslt = sqlExe.executeUpdate((ISQLTemplate) new FICCostInterfaceDBDAOAddTariffFeederCostVersionMappingDataCSQL(), param, velParam);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_PRI_7006 : Check Copy Service Scope  ==> Copy to other service scope<br>
	 * 
	 * @param CheckCopyServiceScopeVO[] checkCopyServiceScopeVOs
	 * @return List<CheckCopyServiceScopeVO>
	 * @throws EventException
	 */
	public List<CheckCopyServiceScopeVO> checkCopyServiceScope(CheckCopyServiceScopeVO[] checkCopyServiceScopeVOs) throws DAOException {
		DBRowSet dbRowset = null;
		List<CheckCopyServiceScopeVO> list = null;
		List<CheckCopyServiceScopeVO> rsltlist = new ArrayList<CheckCopyServiceScopeVO>();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		CheckCopyServiceScopeVO checkCopyServiceScopeVO = new CheckCopyServiceScopeVO();
		try {
			if (checkCopyServiceScopeVOs != null) {
				String[] costCntCds = checkCopyServiceScopeVOs[0].getCostCntCd().split(Pattern.quote(","));	
				List<String> costCntCds_param = new ArrayList<String>();
				
				for (String costCntCd : costCntCds){
					if(!CheckUtils.isInBlank(costCntCd)){
						costCntCds_param.add(costCntCd);
					}
				}
				
				for (int i = 0; i < checkCopyServiceScopeVOs.length; i++ ){
					checkCopyServiceScopeVO.setSvcScpCd(checkCopyServiceScopeVOs[i].getSvcScpCd());
					checkCopyServiceScopeVO.setRhqCd(checkCopyServiceScopeVOs[i].getRhqCd());
					checkCopyServiceScopeVO.setOrgDestTpCd(checkCopyServiceScopeVOs[i].getOrgDestTpCd());
					
					Map<String, String> mapVO = checkCopyServiceScopeVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
					if(costCntCds_param.size() > 0){
					velParam.put("cost_cnt_cd", costCntCds_param);
					}
					
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new FICCostInterfaceDBDAOCheckCopyServiceScopeRSQL(), param, velParam);
					list = (List) RowSetUtil.rowSetToVOs(dbRowset, CheckCopyServiceScopeVO.class);	
					rsltlist.addAll(list);
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsltlist;
	}
	
	/**
	 * ESM_PRI_7006 : Check Copy Service Scope - SAVE validation 2 <br>
	 * check exist IHC tariff's status <br>
	 * 
	 * @param CheckCopyServiceScopeVO[] checkCopyServiceScopeVOs
	 * @return List<CheckCopyServiceScopeVO>
	 * @throws EventException
	 */
	public List<CheckCopyServiceScopeVO> checkCopyServiceScopeInitial(CheckCopyServiceScopeVO[] checkCopyServiceScopeVOs) throws DAOException {
		DBRowSet dbRowset = null;
		List<CheckCopyServiceScopeVO> list = null;
		List<CheckCopyServiceScopeVO> rsltlist = new ArrayList<CheckCopyServiceScopeVO>();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		CheckCopyServiceScopeVO checkCopyServiceScopeVO = new CheckCopyServiceScopeVO();
		try {
			if (checkCopyServiceScopeVOs != null) {
				for (int i = 0; i < checkCopyServiceScopeVOs.length; i++ ){
					
					String[] costCntCds = checkCopyServiceScopeVOs[i].getCostCntCd().split(Pattern.quote(","));	
					List<String> costCntCds_param = new ArrayList<String>();
					
					for (String costCntCd : costCntCds){
						if(!CheckUtils.isInBlank(costCntCd)){
							costCntCds_param.add(costCntCd);
						}
					}
					
					checkCopyServiceScopeVO.setSvcScpCd(checkCopyServiceScopeVOs[i].getSvcScpCd());
					checkCopyServiceScopeVO.setOrgDestTpCd(checkCopyServiceScopeVOs[i].getOrgDestTpCd());
					
					Map<String, String> mapVO = checkCopyServiceScopeVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
					if(costCntCds_param.size() > 0){
					velParam.put("cost_cnt_cd", costCntCds_param);
					}
					
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new FICCostInterfaceDBDAOCheckCopyServiceScopeInitialRSQL(), param, velParam);
					list = (List) RowSetUtil.rowSetToVOs(dbRowset, CheckCopyServiceScopeVO.class);
					rsltlist.addAll(list);
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsltlist;
	}
	
	/**
	 * ESM_PRI_7006 : Check Copy Service Scope - SAVE validation 3 <br>
	 * check exist IHC tariff's effective date <br>
	 * 
	 * @param CheckCopyServiceScopeVO[] checkCopyServiceScopeVOs
	 * @return List<CheckCopyServiceScopeVO>
	 * @throws EventException
	 */
	public List<CheckCopyServiceScopeVO> checkCopyServiceScopeEffdt(CheckCopyServiceScopeVO[] checkCopyServiceScopeVOs) throws DAOException {
		DBRowSet dbRowset = null;
		List<CheckCopyServiceScopeVO> list = null;
		List<CheckCopyServiceScopeVO> rsltlist = new ArrayList<CheckCopyServiceScopeVO>();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		CheckCopyServiceScopeVO checkCopyServiceScopeVO = new CheckCopyServiceScopeVO();
		try {
			if (checkCopyServiceScopeVOs != null) {
				for (int i = 0; i < checkCopyServiceScopeVOs.length; i++ ){
					String[] costCntCds = checkCopyServiceScopeVOs[i].getCostCntCd().split(Pattern.quote(","));	
					List<String> costCntCds_param = new ArrayList<String>();
					
					for (String costCntCd : costCntCds){
						if(!CheckUtils.isInBlank(costCntCd)){
							costCntCds_param.add(costCntCd);
						}
					}
					
					checkCopyServiceScopeVO.setSvcScpCd(checkCopyServiceScopeVOs[i].getSvcScpCd());
					checkCopyServiceScopeVO.setEffDt(checkCopyServiceScopeVOs[i].getEffDt());
					checkCopyServiceScopeVO.setOrgDestTpCd(checkCopyServiceScopeVOs[i].getOrgDestTpCd());
					
					Map<String, String> mapVO = checkCopyServiceScopeVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
					if(costCntCds_param.size() > 0){
					velParam.put("cost_cnt_cd", costCntCds_param);
					}
					
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new FICCostInterfaceDBDAOCheckCopyServiceScopeEffdtRSQL(), param, velParam);
					list = (List) RowSetUtil.rowSetToVOs(dbRowset, CheckCopyServiceScopeVO.class);
					rsltlist.addAll(list);
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsltlist;
	}
	
	/**
	 * ESM_PRI_7006 : Copy IHC - PRI_TRF_IHC_HDR
	 * 
	 * @param List<CopyTariffIhcVO> insertSheetVoList
	 * @throws DAOException
	 */
	public void copyTariffIhcHeaderData(List<CopyTariffIhcVO> insertSheetVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insertSheetVoList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new FICCostInterfaceDBDAOCopyTariffIhcHeaderDataCSQL(), insertSheetVoList, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_PRI_7006 : Copy IHC - PRI_TRF_IHC_MN
	 * 
	 * @param List<CopyTariffIhcVO> insertSheetVoList
	 * @throws DAOException
	 */
	public void copyTariffIhcMainData(List<CopyTariffIhcVO> insertSheetVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insertSheetVoList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new FICCostInterfaceDBDAOCopyTariffIhcMainDataCSQL(), insertSheetVoList, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_PRI_7006 : Copy IHC - PRI_TRF_IHC_RT   (DR)
	 * 
	 * @param List<CopyTariffIhcVO> insertSheetVoList
	 * @throws DAOException
	 */
	public void copyTariffIhcRateData(List<CopyTariffIhcVO> insertSheetVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insertSheetVoList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new FICCostInterfaceDBDAOCopyTariffIhcRateDataCSQL(), insertSheetVoList, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_PRI_7006 : Copy IHC - PRI_TRF_IHC_RT   (RF)
	 * 
	 * @param List<CopyTariffIhcVO> insertSheetVoList
	 * @throws DAOException
	 */
	public void copyTariffIhcRFRateData(List<CopyTariffIhcVO> insertSheetVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insertSheetVoList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new FICCostInterfaceDBDAOCopyTariffIhcRFRateDataCSQL(), insertSheetVoList, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_PRI_7006 : Copy IHC - PRI_TRF_IHC_PROG_TMP
	 * 
	 * @param List<CopyTariffIhcVO> insertSheetVoList
	 * @throws DAOException
	 */
	public void copyTariffIhcProgressData(List<CopyTariffIhcVO> insertSheetVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insertSheetVoList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new FICCostInterfaceDBDAOCopyTariffIhcProgressDataCSQL(), insertSheetVoList, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_PRI_7006 : Copy IHC - PRI_TRF_IHC_DUR_TMP
	 * 
	 * @param List<CopyTariffIhcVO> insertSheetVoList
	 * @throws DAOException
	 */
	public void copyTariffIhcDurationData(List<CopyTariffIhcVO> insertSheetVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insertSheetVoList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new FICCostInterfaceDBDAOCopyTariffIhcDurationDataCSQL(), insertSheetVoList, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_PRI_7006 : Copy IHC - PRI_TRF_IHC_SPCL_CGO_RT_TMP
	 * 
	 * @param List<CopyTariffIhcVO> insertSheetVoList
	 * @throws DAOException
	 */
	public void copyTariffIhcSpecialCargoRateData(List<CopyTariffIhcVO> insertSheetVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insertSheetVoList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new FICCostInterfaceDBDAOCopyTariffIhcSpecialCargoRateDataCSQL(), insertSheetVoList, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_PRI_7007 : Check Copy Service Scope - SAVE validation 1 <br>
	 * check exist FDR tariff's status <br>
	 * 
	 * @param CheckFDRCopyServiceScopeVO[] checkFDRCopyServiceScopeVOs
	 * @return List<CheckFDRCopyServiceScopeVO>
	 * @throws DAOException
	 */
	public List<CheckFDRCopyServiceScopeVO> checkFDRCopyServiceScopeInitial(CheckFDRCopyServiceScopeVO[] checkFDRCopyServiceScopeVOs) throws DAOException {
		DBRowSet dbRowset = null;
		List<CheckFDRCopyServiceScopeVO> list = null;
		List<CheckFDRCopyServiceScopeVO> rsltlist = new ArrayList<CheckFDRCopyServiceScopeVO>();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		CheckFDRCopyServiceScopeVO checkFDRCopyServiceScopeVO = new CheckFDRCopyServiceScopeVO();
		try {
			if (checkFDRCopyServiceScopeVOs != null) {
				for (int i = 0; i < checkFDRCopyServiceScopeVOs.length; i++ ){					
					checkFDRCopyServiceScopeVO.setSvcScpCd(checkFDRCopyServiceScopeVOs[i].getSvcScpCd());
					checkFDRCopyServiceScopeVO.setOrgDestTpCd(checkFDRCopyServiceScopeVOs[i].getOrgDestTpCd());
					checkFDRCopyServiceScopeVO.setRhqCd(checkFDRCopyServiceScopeVOs[i].getRhqCd());
					
					Map<String, String> mapVO = checkFDRCopyServiceScopeVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);

					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new FICCostInterfaceDBDAOCheckFDRCopyServiceScopeInitialRSQL(), param, velParam);
					list = (List) RowSetUtil.rowSetToVOs(dbRowset, CheckFDRCopyServiceScopeVO.class);
					rsltlist.addAll(list);
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsltlist;
	}
	
	/**
	 * ESM_PRI_7007 : Check Copy Service Scope - SAVE validation 2 <br>
	 * check exist FDR tariff's effective date <br>
	 * 
	 * @param CheckFDRCopyServiceScopeVO[] checkFDRCopyServiceScopeVOs
	 * @return List<CheckFDRCopyServiceScopeVO>
	 * @throws DAOException
	 */
	public List<CheckFDRCopyServiceScopeVO> checkFDRCopyServiceScopeEffdt(CheckFDRCopyServiceScopeVO[] checkFDRCopyServiceScopeVOs)  throws DAOException {
		DBRowSet dbRowset = null;
		List<CheckFDRCopyServiceScopeVO> list = null;
		List<CheckFDRCopyServiceScopeVO> rsltlist = new ArrayList<CheckFDRCopyServiceScopeVO>();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		CheckFDRCopyServiceScopeVO checkFDRCopyServiceScopeVO = new CheckFDRCopyServiceScopeVO();
		try {
			if (checkFDRCopyServiceScopeVOs != null) {
				for (int i = 0; i < checkFDRCopyServiceScopeVOs.length; i++ ){					
					checkFDRCopyServiceScopeVO.setSvcScpCd(checkFDRCopyServiceScopeVOs[i].getSvcScpCd());
					checkFDRCopyServiceScopeVO.setOrgDestTpCd(checkFDRCopyServiceScopeVOs[i].getOrgDestTpCd());
					checkFDRCopyServiceScopeVO.setEffDt(checkFDRCopyServiceScopeVOs[i].getEffDt());
					checkFDRCopyServiceScopeVO.setRhqCd(checkFDRCopyServiceScopeVOs[i].getRhqCd());
					
					Map<String, String> mapVO = checkFDRCopyServiceScopeVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);

					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new FICCostInterfaceDBDAOCheckFDRCopyServiceScopeEffdtRSQL(), param, velParam);
					list = (List) RowSetUtil.rowSetToVOs(dbRowset, CheckFDRCopyServiceScopeVO.class);
					rsltlist.addAll(list);
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsltlist;
	}
	
	/**
	 * ESM_PRI_7007 : Copy FDR - PRI_TRF_FDR_HDR
	 * 
	 * @param List<CopyTariffFdrVO> insertSheetVoList
	 * @throws DAOException
	 */
	public void copyTariffFdrHeaderData(List<CopyTariffFdrVO> insertSheetVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insertSheetVoList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new FICCostInterfaceDBDAOCopyTariffFdrHeaderDataCSQL(), insertSheetVoList, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_PRI_7007 : Copy FDR - PRI_TRF_FDR_MN
	 * 
	 * @param List<CopyTariffFdrVO> insertSheetVoList
	 * @throws DAOException
	 */
	public void copyTariffFdrMainData(List<CopyTariffFdrVO> insertSheetVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insertSheetVoList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new FICCostInterfaceDBDAOCopyTariffFdrMainDataCSQL(), insertSheetVoList, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_PRI_7007 : Copy FDR - PRI_TRF_FDR_DUR
	 * 
	 * @param List<CopyTariffFdrVO> insertSheetVoList
	 * @throws DAOException
	 */
	public void copyTariffFdrDurationData(List<CopyTariffFdrVO> insertSheetVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insertSheetVoList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new FICCostInterfaceDBDAOCopyTariffFdrDurationDataCSQL(), insertSheetVoList, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_PRI_7007 : Copy FDR - PRI_TRF_FDR_PROG
	 * 
	 * @param List<CopyTariffFdrVO> insertSheetVoList
	 * @throws DAOException
	 */
	public void copyTariffFdrProgressData(List<CopyTariffFdrVO> insertSheetVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insertSheetVoList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new FICCostInterfaceDBDAOCopyTariffFdrProgressDataCSQL(), insertSheetVoList, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_PRI_7007 : Copy FDR - PRI_TRF_FDR_COST_VER_MAPG
	 * 
	 * @param List<CopyTariffFdrVO> insertSheetVoList
	 * @throws DAOException
	 */
	public void copyTariffFeederCostVersionMappingData(List<CopyTariffFdrVO> insertSheetVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insertSheetVoList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new FICCostInterfaceDBDAOCopyTariffFeederCostVersionMappingDataCSQL(), insertSheetVoList, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_PRI_7007 : Copy FDR - PRI_TRF_FDR_RT
	 * 
	 * @param List<CopyTariffFdrVO> insertSheetVoList
	 * @throws DAOException
	 */
	public void copyTariffFdrRateData(List<CopyTariffFdrVO> insertSheetVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insertSheetVoList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new FICCostInterfaceDBDAOCopyTariffFdrRateDataCSQL(), insertSheetVoList, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * INSERT - PRI_TRF_IHC_RT (DR) - for US
	 * 
	 * @param PriTrfIhcHdrVO priTrfIhcHdrVO
	 * @throws DAOException
	 */
	public void addUsTariffIhcRateData(PriTrfIhcHdrVO priTrfIhcHdrVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();
			if (priTrfIhcHdrVO != null) {
				Map<String, String> mapVO = priTrfIhcHdrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				@SuppressWarnings("unused")
				int rslt = sqlExe.executeUpdate((ISQLTemplate) new FICCostInterfaceDBDAOAddUsTariffIhcRateDataCSQL(), param, velParam);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * ESM_PRI_7022 : 조회<br>
	 * 
	 * @return List<TariffCodeMappingVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TariffCodeMappingVO> searchTariffCodeMapping() throws DAOException {
		DBRowSet dbRowset = null;
		List<TariffCodeMappingVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new FICCostInterfaceDBDAOSearchTariffCodeMappingRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TariffCodeMappingVO.class);
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
	 * ESM_PRI_7022 : 저장 (추가)<br>
	 * 
	 * @param TariffCodeMappingVO tariffCodeMappingVO
	 * @throws DAOException
	 */
	public void addTariffCodeMapping(TariffCodeMappingVO tariffCodeMappingVO) throws DAOException {
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();                       
        try {
        	SQLExecuter sqlExe = new SQLExecuter("");
            Map<String, String> mapVO = tariffCodeMappingVO.getColumnValues();
            String trfCd = tariffCodeMappingVO.getTrfCd();
            log.debug("&&&&&&&&&&& trfCd : " + trfCd);
            if(trfCd !=null && trfCd.length() > 2){
                mapVO.put("trf_pfx_cd", trfCd.substring(0, 4));
                mapVO.put("trf_no", trfCd.substring(5));
            }
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
                   
            @SuppressWarnings("unused")
			int rslt = sqlExe.executeUpdate((ISQLTemplate) new FICCostInterfaceDBDAOAddTariffCodeMappingCSQL(), param, velParam);
            
        } catch (SQLException se) {
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        }catch(Exception ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }
	
	
	/**
	 * ESM_PRI_7022 : 저장 (삭제)<br>
	 * 
	 * @param TariffCodeMappingVO tariffCodeMappingVO
	 * @throws DAOException
	 */
	public void removeTariffCodeMapping(TariffCodeMappingVO tariffCodeMappingVO) throws DAOException {
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();                       
        try {
        	SQLExecuter sqlExe = new SQLExecuter("");
            Map<String, String> mapVO = tariffCodeMappingVO.getColumnValues();
            String trfCd = tariffCodeMappingVO.getTrfCd();
            log.debug("&&&&&&&&&&& trfCd : " + trfCd);
            if(trfCd !=null && trfCd.length() > 2){
                mapVO.put("trf_pfx_cd", trfCd.substring(0, 4));
                mapVO.put("trf_no", trfCd.substring(5));
            }
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
                   
            @SuppressWarnings("unused")
			int rslt = sqlExe.executeUpdate((ISQLTemplate) new FICCostInterfaceDBDAORemoveTariffCodeMappingDSQL(), param, velParam);
            
        } catch (SQLException se) {
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        }catch(Exception ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }
	
	/**
	 * INSERT - PRI_TRF_IHC_RT (DR) - CHN (SIN / SHA)
	 * 
	 * @param PriTrfIhcHdrVO priTrfIhcHdrVO
	 * @throws DAOException
	 */
	public void addChnTariffIhcRateData(PriTrfIhcHdrVO priTrfIhcHdrVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();
			if (priTrfIhcHdrVO != null) {
				Map<String, String> mapVO = priTrfIhcHdrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				@SuppressWarnings("unused")
				int rslt = sqlExe.executeUpdate((ISQLTemplate) new FICCostInterfaceDBDAOAddChnTariffIhcRateDataCSQL(), param, velParam);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * INSERT - Pricing tariff feeder rate - Asia (SIN,SHA)
	 * 
	 * @param priTrfFdrHdrVO
	 * @throws DAOException
	 */
	public void addChnTariffFeederRateData(PriTrfFdrHdrVO priTrfFdrHdrVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();
			if (priTrfFdrHdrVO != null) {
				Map<String, String> mapVO = priTrfFdrHdrVO.getColumnValues();
				param.putAll(mapVO);

				String[] costTrfNos = priTrfFdrHdrVO.getCostTrfNo().split(Pattern.quote(","));
				List<String> costTrfNo_param = new ArrayList<String>();
				for (String costTrfNo : costTrfNos) {
					if (!CheckUtils.isInBlank(costTrfNo))
						costTrfNo_param.add(costTrfNo);
				}
				if (costTrfNo_param.size() > 0)
					velParam.put("costtrfno", costTrfNo_param);

				velParam.putAll(mapVO);

				@SuppressWarnings("unused")
				int rslt = sqlExe.executeUpdate((ISQLTemplate) new FICCostInterfaceDBDAOAddChnTariffFeederRateDataCSQL(), param, velParam);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
}
