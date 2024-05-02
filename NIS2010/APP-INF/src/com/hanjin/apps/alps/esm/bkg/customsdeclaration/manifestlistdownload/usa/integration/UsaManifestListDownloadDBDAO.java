/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UsaManifestListDownloadDAO.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.23
 *@LastModifier : 이수빈
 *@LastVersion : 1.0
 * 2009.04.23 이수빈
 * 1.0 Creation
 * 
 * 2011.06.01 민정호 [CHM-201111028] AMS - Customs Data Download (D/L) 화면 validation추가
 * 2011.10.12 윤태승 [CHM-201113684-01][ESM_BKG] US AMS 의 MI 중복전송 기능 요청 - IDhjsedlee
 * 2012.01.31 민정호 [CHM-201215726-01] AMS 전송시 Customs 로직 추가 요청 
 * 2012.03.26 김현화 [CHM-201216918]SNP/Broker Nomination 
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration.BookingUtilDBDAOSearchSplitMstBlNoRSQL;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlDocCustVO;
import com.hanjin.apps.alps.esm.bkg.common.CountryCode;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.integration.KoreaCustomsReportDBDAOaddCstmEntryTpListCSQL;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaRcvMsgVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.ClearanceTypeCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.ClearanceTypeDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.InBondNumberVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.UsaInbondDataVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.UsaInbondManifestDetailListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.basic.UsaManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.ExpRuleSetupVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.ImpRuleSetupVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.RuleSetupCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsCustomsStatusNoticeVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaAiBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaBkgCmVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaBkgCntrSealNoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaBkgCntrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaBkgCustomerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaBlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaBlCustVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaBlCustomerSecondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaBlCustomsResultVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaBlDetailContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaBlHblListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaBlHistoryVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaBlMultiBlListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaBlRemarkVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaCntrListRsltVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaCntrSealNoListRsltVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaContainerListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaContainerManifestInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaContainerManifestListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaDownloadSummaryVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaHblCheckCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaHblCheckDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaManifestListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaManifestListDownloadCntrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaManifestSearchCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaManifestSearchDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaManifestSummaryVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaOldCntrModiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaOldInbondModiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaSearchBlStatusVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaSetupKeyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaSetupListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaVesselCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaVesselVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UserAuthListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UserAuthListModiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UserInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.OrgPartyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.AuthSetupListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ContainerListRsltVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.DispoCdDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.DispoCdListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.HouseBlDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.SetupListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgCstmsAdvIbdVO;
import com.hanjin.syscommon.common.table.BkgCstmsIbdHisDtlVO;
import com.hanjin.syscommon.common.table.BkgCstmsIbdHisVO;
import com.hanjin.syscommon.common.table.MdmCountryVO;
import com.hanjin.syscommon.common.table.MdmPortVO;
import com.hanjin.framework.component.util.JSPUtil;

/** 
 * ALPS UsaManifestListDownloadDAO <br>
 * - ALPS-manifestlistdownload system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Lee Subin
 * @see UsaManifestListDownloadBCImpl 참조
 * @since J2EE 1.4
 */
public class UsaManifestListDownloadDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Rule setup 정보를 조회 한다.<br>
	 * 
	 * @param RuleSetupCondVO ruleSetupCondVO
	 * @return List<SetupListDetailVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SetupListDetailVO> searchRuleSetupList(RuleSetupCondVO ruleSetupCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SetupListDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (ruleSetupCondVO != null)
			{
				Map<String, String> mapVO = ruleSetupCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchRuleSetupListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaSetupListDetailVO.class);
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Country 리스트를 조회한다.<br>
	 * 
	 * @return List<MdmCountryVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MdmCountryVO> searchCountryCodeList() throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmCountryVO> list = null;

		try
		{
			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchCountryCodeListRSQL(), null, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MdmCountryVO.class);
			list.size();
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * 선택한 Country 에 해당하는 Port 리스트를 조회한다.<br>
	 * 
	 * @param String cntCd
	 * @return List<MdmPortVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MdmPortVO> searchFiterPortList(String cntCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmPortVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			param.put("cnt_cd", cntCd);
			velParam.put("cnt_cd", cntCd);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchPortCodeListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MdmPortVO.class);
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Export Rule setup 정보를 생성한다.<br>
	 * 
	 * @param ExpRuleSetupVO expRuleSetupVO
	 * @exception DAOException
	 */
	public void addExportRuleSetup(ExpRuleSetupVO expRuleSetupVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = expRuleSetupVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new UsaManifestListDownloadDBDAOaddExportRuleSetupCSQL(),
					param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Import Rule setup 정보를 생성한다.<br>
	 * 
	 * @param ImpRuleSetupVO impRuleSetupVO
	 * @exception DAOException
	 */
	public void addImportRuleSetup(ImpRuleSetupVO impRuleSetupVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = impRuleSetupVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new UsaManifestListDownloadDBDAOaddImportRuleSetupCSQL(),
					param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Export Rule setup 정보를 업데이트 한다.<br>
	 * 
	 * @param ExpRuleSetupVO expRuleSetupVO
	 * @return Integer
	 * @exception DAOException
	 */
	public int modifyExportRuleSetup(ExpRuleSetupVO expRuleSetupVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try
		{
			Map<String, String> mapVO = expRuleSetupVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			result = new SQLExecuter("").executeUpdate(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOmodifyExportRuleSetupUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * Import Rule setup 정보를 업데이트 한다.<br>
	 * 
	 * @param ImpRuleSetupVO impRuleSetupVO
	 * @return Integer
	 * @exception DAOException
	 */
	public int modifyImportRuleSetup(ImpRuleSetupVO impRuleSetupVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try
		{
			Map<String, String> mapVO = impRuleSetupVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new UsaManifestListDownloadDBDAOmodifyImportRuleSetupUSQL(),
					param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * SetupList의 상태를 변경한다.(삭제처리)<br>
	 * 
	 * @param UsaSetupKeyVO vo
	 * @return Integer
	 * @exception DAOException
	 */
	public int modifySetupStatusForDelete(UsaSetupKeyVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try
		{
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new UsaManifestListDownloadDBDAOmodifySetupStatusUSQL(),
					param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * B/L Inquiry 화면의 해당 B/L 정보를 조회한다.<br>
	 * 
	 * @param UsaBlCondVO blCondVO
	 * @return UsaAiBlInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public UsaAiBlInfoVO searchAiBl(UsaBlCondVO blCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<UsaAiBlInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (blCondVO != null)
			{
				Map<String, String> mapVO = blCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchAiBlRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaAiBlInfoVO.class);

			if (list.size() > 0)
			{
				return list.get(0);
			}
			else
			{
				return null;
			}
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * B/L정보를 수정한다.<br>
	 * 
	 * @param UsaAiBlInfoVO usaAiBlInfoVO
	 * @param String usrId
	 * @return Integer
	 * @exception DAOException
	 */
	public int modifyBl(UsaAiBlInfoVO usaAiBlInfoVO, String usrId) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try
		{
			Map<String, String> mapVO = usaAiBlInfoVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			param.put("cnt_cd", CountryCode.US);
			velParam.put("cnt_cd", CountryCode.US);
			param.put("cre_usr_id", usrId);
			velParam.put("cre_usr_id", usrId);
			param.put("upd_usr_id", usrId);
			velParam.put("upd_usr_id", usrId);

			param.put("origin_bl_flag", usaAiBlInfoVO.getIbflag());
			velParam.put("origin_bl_flag", usaAiBlInfoVO.getIbflag());
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new UsaManifestListDownloadDBDAOmodifyBlUSQL(), param,
						velParam);
			if (result > 0)
			{
				result = sqlExe.executeUpdate((ISQLTemplate) new UsaManifestListDownloadDBDAOmodifyBl2USQL(), param,
						velParam);
			}
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * 화주정보를 조회한다.(Shipper,Consinee,Notify)<br>
	 * 
	 * @param UsaBlCondVO blCondVO
	 * @return List<UsaBlCustVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UsaBlCustVO> searchCustomer(UsaBlCondVO blCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<UsaBlCustVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (blCondVO != null)
			{
				Map<String, String> mapVO = blCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchCustomerRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaBlCustVO.class);

		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return list;
	}

	/**
	 * Name,Address 등 고객정보를 업데이트 한다.<br>
	 * 
	 * @param UsaBlCustVO blCustVO
	 * @param String usrId
	 * @return Integer
	 * @exception DAOException
	 */
	public int modifyCustomer(UsaBlCustVO blCustVO, String usrId) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try
		{
			Map<String, String> mapVO = blCustVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			param.put("cnt_cd", CountryCode.US);
			velParam.put("cnt_cd", CountryCode.US);
			param.put("cre_usr_id", usrId);
			velParam.put("cre_usr_id", usrId);
			param.put("upd_usr_id", usrId);
			velParam.put("upd_usr_id", usrId);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new UsaManifestListDownloadDBDAOmodifyCustomerUSQL(), param,
					velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * 화주정보를 조회한다.(Also Notify, Freight forwarder)<br>
	 * 
	 * @param UsaBlCondVO blCondVO
	 * @return List<UsaBlCustomerSecondVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UsaBlCustomerSecondVO> searchCustomerSecond(UsaBlCondVO blCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<UsaBlCustomerSecondVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (blCondVO != null)
			{
				Map<String, String> mapVO = blCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchCustomer2RSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaBlCustomerSecondVO.class);

		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return list;
	}

	/**
	 * Name,Address 등 고객정보를 업데이트 한다.<br>
	 * 
	 * @param UsaBlCustomerSecondVO blCustomerSecondVO
	 * @param String usrId
	 * @return Integer
	 * @exception DAOException
	 */
	public int modifyCustomer2(UsaBlCustomerSecondVO blCustomerSecondVO, String usrId) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try
		{
			Map<String, String> mapVO = blCustomerSecondVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			param.put("cnt_cd", CountryCode.US);
			velParam.put("cnt_cd", CountryCode.US);
			param.put("cre_usr_id", usrId);
			velParam.put("cre_usr_id", usrId);
			param.put("upd_usr_id", usrId);
			velParam.put("upd_usr_id", usrId);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new UsaManifestListDownloadDBDAOmodifyCustomerUSQL(), param,
					velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * 세관에서 준 응답메시지 내역을 조회한다.<br>
	 * 
	 * @param UsaBlCondVO blCondVO
	 * @return List<UsaBlCustomsResultVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UsaBlCustomsResultVO> searchCustomsResult(UsaBlCondVO blCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<UsaBlCustomsResultVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (blCondVO != null)
			{
				Map<String, String> mapVO = blCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				int pageNo = Integer.parseInt("".equals(blCondVO.getPageNo()) ? "1" : blCondVO.getPageNo());
				int pageRows = Integer.parseInt("".equals(blCondVO.getPagerows()) ? "100" : blCondVO.getPagerows());

				int startNo = (pageNo - 1) * pageRows + 1;
				int endNo = pageNo * pageRows;

				param.put("start_no", startNo);
				param.put("end_no", endNo);
				velParam.put("start_no", startNo);
				velParam.put("end_no", endNo);
			}

			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchCustomsResultRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaBlCustomsResultVO.class);

		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * B/L의 Remark정보를 조회한다.<br>
	 * 
	 * @param UsaBlCondVO blCondVO
	 * @return List<UsaBlRemarkVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UsaBlRemarkVO> searchRemarks(UsaBlCondVO blCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<UsaBlRemarkVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (blCondVO != null)
			{
				Map<String, String> mapVO = blCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchRemarksRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaBlRemarkVO.class);

		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return list;
	}

	/**
	 * 다운로드 후 B/L의 수정 내역을 조회한다.<br>
	 * 
	 * @param UsaBlCondVO blCondVO
	 * @return List<UsaBlHistoryVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UsaBlHistoryVO> searchHistory(UsaBlCondVO blCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<UsaBlHistoryVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		UsaBlCondVO condVO = null;
		try
		{
			if (blCondVO != null)
			{
				condVO = (UsaBlCondVO) blCondVO;
				Map<String, String> mapVO = condVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				int pageNo = Integer.parseInt("".equals(condVO.getPageNo()) ? "1" : condVO.getPageNo());
				int pageRows = Integer.parseInt("".equals(condVO.getPagerows()) ? "100" : condVO.getPagerows());

				int startNo = (pageNo - 1) * pageRows + 1;
				int endNo = pageNo * pageRows;

				param.put("start_no", startNo);
				param.put("end_no", endNo);
				velParam.put("start_no", startNo);
				velParam.put("end_no", endNo);
			}

			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchHistoryRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaBlHistoryVO.class);
			if (list != null && list.size() > 0)
			{
				list.get(0).setMaxRows(Integer.parseInt(list.get(0).getTotal()));
			}

		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * B/L별 H/BL 목록을 조회한다.<br>
	 * 
	 * @param UsaBlCondVO blCondVO
	 * @return List<UsaBlHblListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UsaBlHblListVO> searchHblList(UsaBlCondVO blCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<UsaBlHblListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (blCondVO != null)
			{
				Map<String, String> mapVO = blCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchHblListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaBlHblListVO.class);

		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Multi B/L 의 내역을 조회한다.<br>
	 * 
	 * @param UsaBlCondVO blCondVO
	 * @return List<UsaBlMultiBlListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UsaBlMultiBlListVO> searchMultiBlList(UsaBlCondVO blCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<UsaBlMultiBlListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (blCondVO != null)
			{
				Map<String, String> mapVO = blCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchMultiBlListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaBlMultiBlListVO.class);

		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * User 권한 부여한 리스트를 조회해 온다.<br>
	 * 
	 * @param UserAuthListCondVO condVO
	 * @return List<AuthSetupListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AuthSetupListVO> searchUserAuthList(UserAuthListCondVO condVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AuthSetupListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (condVO != null)
			{
				Map<String, String> mapVO = condVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchAuthSetupListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UserAuthListModiVO.class);
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Disposition Code Description 조회해 온다.<br>
	 * 
	 * @param UsaBlCondVO condVO
	 * @return List<DispoCdDetailVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<DispoCdDetailVO> searchCodeDesc(UsaBlCondVO condVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DispoCdDetailVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (condVO != null)
			{
				Map<String, String> mapVO = condVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchCodeDescRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, DispoCdDetailVO.class);
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * 유져의 버튼별 권한을 조회한다.<br>
	 * 
	 * @param String userId
	 * @return List<UserInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UserInfoVO> searchUserAuthInfo(String userId) throws DAOException {
		DBRowSet dbRowset = null;
		List<UserInfoVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (userId != null)
			{
				param.put("usr_id", userId);
				velParam.put("usr_id", userId);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchUserAuthInfoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UserInfoVO.class);
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * 유져의 버튼 권한을 조회한다.<br>
	 * 
	 * @param String userId
	 * @param String pgmNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchUserAuthYn(String userId, String pgmNo) throws DAOException {
		DBRowSet dbRowset = null;
		String retVal = "N";

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (userId != null && pgmNo != null)
			{
				param.put("usr_id", userId);
				velParam.put("usr_id", userId);
				param.put("pgm_no", pgmNo);
				velParam.put("pgm_no", pgmNo);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchUserAuthYnRSQL(), param, velParam);

			if (dbRowset.getRowCount() > 0)
			{
				if (dbRowset.next())
				{
					retVal = dbRowset.getString(1);
				}
			}
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retVal;
	}
	
	/**
	 * 유져의 MI - MULTI 권한을 조회한다.<br>
	 * 
	 * @param String userId
	 * @return String
	 * @exception DAOException
	 */
	public String searchUserAuthMiMultiYn(String userId) throws DAOException {
		DBRowSet dbRowset = null;
		String retVal = "N";

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (userId != null)
			{
				param.put("usr_id", userId);
				velParam.put("usr_id", userId);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchUserAuthMiMultiYnRSQL(), param, velParam);

			if (dbRowset.getRowCount() > 0)
			{
				if (dbRowset.next())
				{
					retVal = dbRowset.getString(1);
				}
			}
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retVal;
	}

	/**
	 * 로그인 한 사용자의 권한을 조회한다.<br>
	 * 
	 * @param String userId
	 * @param String ofcCd
	 * @return AuthSetupListVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public AuthSetupListVO searchUserAuthInfo(String userId, String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<AuthSetupListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			param.put("usr_id", userId);
			velParam.put("usr_id", userId);
			param.put("ofc_cd", ofcCd);
			velParam.put("ofc_cd", ofcCd);

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchUserAuthInfo2RSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UserAuthListModiVO.class);

			if (list.size() > 0)
			{
				return list.get(0);
			}
			else
			{
				return null;
			}
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 유저 권한 정보를 생성한다.<br>
	 * 
	 * @param userAuthListModiVOs List<UserAuthListModiVO>
	 * @exception DAOException
	 */
	public void addUserAuthSetup(List<UserAuthListModiVO> userAuthListModiVOs) throws DAOException {
		try
		{
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (userAuthListModiVOs.size() > 0)
			{
				Map<String, String> mapVO = userAuthListModiVOs.get(0).getColumnValues();
				velParam.putAll(mapVO);
				updCnt = sqlExe.executeBatch((ISQLTemplate) new UsaManifestListDownloadDBDAOaddUserAuthSetupCSQL(),
						userAuthListModiVOs, velParam);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
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
	}

	/**
	 * 유저 권한 정보를 수정한다.<br>
	 * 사용안함.
	 * 
	 * @param userAuthListModiVOs List<UserAuthListModiVO>
	 * @exception DAOException
	 */
	public void modifyUserAuthSetup(List<UserAuthListModiVO> userAuthListModiVOs) throws DAOException {
		try
		{
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (userAuthListModiVOs.size() > 0)
			{
				Map<String, String> mapVO = userAuthListModiVOs.get(0).getColumnValues();
				velParam.putAll(mapVO);
				updCnt = sqlExe.executeBatch((ISQLTemplate) new UsaManifestListDownloadDBDAOmodifyUserAuthSetupUSQL(),
						userAuthListModiVOs, velParam);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
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
	}

	/**
	 * 유저 권한 정보를 삭제한다.<br>
	 * 
	 * @param userAuthListModiVOs List<UserAuthListModiVO>
	 * @exception DAOException
	 */
	public void removeUserAuthSetup(List<UserAuthListModiVO> userAuthListModiVOs) throws DAOException {
		try
		{
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (userAuthListModiVOs.size() > 0)
			{
				Map<String, String> mapVO = userAuthListModiVOs.get(0).getColumnValues();
				velParam.putAll(mapVO);
				updCnt = sqlExe.executeBatch((ISQLTemplate) new UsaManifestListDownloadDBDAOremoveUserAuthSetupDSQL(),
						userAuthListModiVOs, velParam);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
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
	}

	/**
	 * 대상 B/L 조회<br>
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return List<UsaDownloadSummaryVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UsaDownloadSummaryVO> searchDownloadSummaryList(ManifestListCondVO manifestListCondVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<UsaDownloadSummaryVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (manifestListCondVO != null)
			{
				Map<String, String> mapVO = manifestListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchManifestListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaDownloadSummaryVO.class);
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * 대상 B/L 상세 조회<br>
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return List<UsaManifestListDetailVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UsaManifestListDetailVO> searchDownloadDetailList(ManifestListCondVO manifestListCondVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<UsaManifestListDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		UsaManifestListCondVO condVO = null;

		try
		{
			if (manifestListCondVO != null)
			{

				condVO = (UsaManifestListCondVO) manifestListCondVO;
				Map<String, String> mapVO = condVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("cnt_cd", CountryCode.US);
				velParam.put("cnt_cd", CountryCode.US);

			}

			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchManifestList2RSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaManifestListDetailVO.class);

		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * 대상 Container 상세 조회<br>
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return List<UsaManifestListDownloadCntrVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UsaManifestListDownloadCntrVO> searchDownloadContainerList(ManifestListCondVO manifestListCondVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<UsaManifestListDownloadCntrVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		UsaManifestListCondVO condVO = null;

		try
		{
			if (manifestListCondVO != null)
			{

				condVO = (UsaManifestListCondVO) manifestListCondVO;
				Map<String, String> mapVO = condVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

			}

			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchDownloadContainerListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaManifestListDownloadCntrVO.class);

		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * CSTMS_PORT_CD 조회<br>
	 * 
	 * @param UsaManifestListDetailVO vo
	 * @return String
	 * @exception DAOException
	 */
	public String searchCstmsPortCd(UsaManifestListDetailVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		String cstmsPortCd = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = vo.getColumnValues();
			mapVO.put("pre_pol_cd", vo.getPolCd().substring(0,2));
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchCstmsPortCdRSQL(), param, velParam);
			if (dbRowset.next())
				cstmsPortCd = dbRowset.getString(1);
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return cstmsPortCd;
	}
	
	/**
	 * CSTMS_PORT_CD 조회<br>
	 * 
	 * @param UsaAiBlInfoVO vo
	 * @return String
	 * @exception DAOException
	 */
	public String searchCstmsPortCd(UsaAiBlInfoVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		String cstmsPortCd = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = vo.getColumnValues();
			mapVO.put("pre_pol_cd", vo.getPolCd().substring(0,2));
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchCstmsPortCdRSQL(), param, velParam);
			if (dbRowset.next())
				cstmsPortCd = dbRowset.getString(1);
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return cstmsPortCd;
	}	
	
	

	/**
	 * M.B/L 한건의 정보를 조회한다.<br>
	 * 
	 * @param UsaManifestListCondVO condVO
	 * @return UsaBlInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public UsaBlInfoVO searchBl(UsaManifestListCondVO condVO) throws DAOException {
		DBRowSet dbRowset = null;
		UsaBlInfoVO usaBlInfoVO = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = condVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchBlRSQL(), param, velParam);
			List<UsaBlInfoVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaBlInfoVO.class);

			if (list.size() > 0)
			{
				usaBlInfoVO = (UsaBlInfoVO) list.get(0);
			}
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return usaBlInfoVO;
	}

	
	// /**
	// * BKG Container에서 B/L로 Package Qty, Weight Qty의 Sum을 찾아온다.<br>
	// *
	// * @param UsaManifestListCondVO condVO
	// * @return UsaSumWgtPkgVO
	// * @exception DAOException
	// */
	// @SuppressWarnings("unchecked")
	// public UsaSumWgtPkgVO searchSumWgtPkgInCntrByBl ( UsaManifestListCondVO condVO ) throws DAOException {
	// DBRowSet dbRowset = null;
	// UsaSumWgtPkgVO usaSumWgtPkgVO = null;
	//    	
	// //query parameter
	// Map<String, Object> param = new HashMap<String, Object>();
	// //velocity parameter
	// Map<String, Object> velParam = new HashMap<String, Object>();
	//
	// try{
	// Map<String, String> mapVO = condVO.getColumnValues();
	//            
	// param.putAll(mapVO);
	// velParam.putAll(mapVO);
	//            
	// dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new
	// UsaManifestListDownloadDBDAOsearchSumWgtPkgInCntrByBlRSQL(), param, velParam);
	// List<UsaSumWgtPkgVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, UsaSumWgtPkgVO.class);
	//            
	// if(list.size() > 0){
	// usaSumWgtPkgVO = (UsaSumWgtPkgVO)list.get(0);
	// }
	// }catch(SQLException se){
	// log.error(se.getMessage(),se);
	// throw new DAOException(new ErrorHandler(se).getMessage());
	// }catch(Exception ex){
	// log.error(ex.getMessage(),ex);
	// throw new DAOException(new ErrorHandler(ex).getMessage());
	// }
	//
	// return usaSumWgtPkgVO;
	// }

	// /**
	// * VVD 테이블 정보를 조회해 온다.<br>
	// *
	// * @param UsaManifestListCondVO condVO
	// * @return UsaVVDInfoVO
	// * @exception DAOException
	// */
	// @SuppressWarnings("unchecked")
	// public UsaVVDInfoVO searchVVDByPod ( UsaManifestListCondVO condVO ) throws DAOException {
	// DBRowSet dbRowset = null;
	// UsaVVDInfoVO usaVVDInfoVO = null;
	//    	
	// //query parameter
	// Map<String, Object> param = new HashMap<String, Object>();
	// //velocity parameter
	// Map<String, Object> velParam = new HashMap<String, Object>();
	//
	// try{
	// Map<String, String> mapVO = condVO.getColumnValues();
	//            
	// param.putAll(mapVO);
	// velParam.putAll(mapVO);
	//            
	// dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new
	// UsaManifestListDownloadDBDAOsearchVVDByPodRSQL(), param, velParam);
	// List<UsaVVDInfoVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, UsaCAInfoVO.class);
	//            
	// if(list.size() > 0){
	// usaVVDInfoVO = (UsaVVDInfoVO)list.get(0);
	// }
	// }catch(SQLException se){
	// log.error(se.getMessage(),se);
	// throw new DAOException(new ErrorHandler(se).getMessage());
	// }catch(Exception ex){
	// log.error(ex.getMessage(),ex);
	// throw new DAOException(new ErrorHandler(ex).getMessage());
	// }
	//
	// return usaVVDInfoVO;
	// }

	/**
	 * 기 등록된 Inbond 정보를 조회해 온다.<br>
	 * 
	 * @param UsaManifestListCondVO condVO
	 * @return UsaOldInbondModiVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public UsaOldInbondModiVO searchOldInbondInfoByBl(UsaManifestListCondVO condVO) throws DAOException {
		DBRowSet dbRowset = null;
		UsaOldInbondModiVO oldInbondModiVO = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = condVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("cnt_cd", CountryCode.US);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchOldInbondInfoByBlRSQL(), param, velParam);
			List<UsaOldInbondModiVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaOldInbondModiVO.class);

			if (list.size() > 0)
			{
				oldInbondModiVO = (UsaOldInbondModiVO) list.get(0);
			}
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return oldInbondModiVO;
	}

	/**
	 * 63의 경우, 기존 B/L 정보로 업데이트 한다.<br>
	 * 
	 * @param List<UsaOldInbondModiVO> modiVOs
	 * @exception DAOException
	 */
	public void modifyOldInbondByBl(List<UsaOldInbondModiVO> modiVOs) throws DAOException {
		int addCnt[] = null;
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			addCnt = sqlExe.executeBatch((ISQLTemplate) new UsaManifestListDownloadDBDAOmodifyOldInbondByBlUSQL(),
					modiVOs, null);

			for (int i = 0; i < addCnt.length; i++)
			{
				if (addCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No" + i + " SQL");
			}
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 기 등록된 Container 정보를 조회해 온다.<br>
	 * 
	 * @param UsaManifestListCondVO condVO
	 * @return UsaOldCntrModiVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public UsaOldCntrModiVO searchOldInbondInfoByCntr(UsaManifestListCondVO condVO) throws DAOException {
		DBRowSet dbRowset = null;
		UsaOldCntrModiVO oldCntrModiVO = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = condVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("cnt_cd", CountryCode.US);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchOldInbondInfoByCntrRSQL(), param, velParam);
			List<UsaOldCntrModiVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaOldCntrModiVO.class);

			if (list.size() > 0)
			{
				oldCntrModiVO = (UsaOldCntrModiVO) list.get(0);
			}
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return oldCntrModiVO;
	}

	/**
	 * 63의 경우, 기존 Container 정보로 업데이트 한다.<br>
	 * 
	 * @param List<UsaOldCntrModiVO> modiVOs
	 * @exception DAOException
	 */
	public void modifyOldCntrByCntr(List<UsaOldCntrModiVO> modiVOs) throws DAOException {
		int addCnt[] = null;
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			addCnt = sqlExe.executeBatch((ISQLTemplate) new UsaManifestListDownloadDBDAOmodifyOldCntrByCntrUSQL(),
					modiVOs, null);

			for (int i = 0; i < addCnt.length; i++)
			{
				if (addCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No" + i + " SQL");
			}
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	// /**
	// * C/A정보를 조회해 온다.(날짜,Number)<br>
	// *
	// * @param UsaManifestListCondVO condVO
	// * @return UsaCAInfoVO
	// * @exception DAOException
	// */
	// @SuppressWarnings("unchecked")
	// public UsaCAInfoVO searchCAInfoByBl ( UsaManifestListCondVO condVO ) throws DAOException {
	// DBRowSet dbRowset = null;
	// UsaCAInfoVO usaCAInfoVO = null;
	//    	
	// //query parameter
	// Map<String, Object> param = new HashMap<String, Object>();
	// //velocity parameter
	// Map<String, Object> velParam = new HashMap<String, Object>();
	//
	// try{
	// Map<String, String> mapVO = condVO.getColumnValues();
	//            
	// param.putAll(mapVO);
	// velParam.putAll(mapVO);
	//            
	// dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new
	// UsaManifestListDownloadDBDAOsearchCAInfoByBlRSQL(), param, velParam);
	// List<UsaCAInfoVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, UsaCAInfoVO.class);
	//            
	// if(list.size() > 0){
	// usaCAInfoVO = (UsaCAInfoVO)list.get(0);
	// }
	// }catch(SQLException se){
	// log.error(se.getMessage(),se);
	// throw new DAOException(new ErrorHandler(se).getMessage());
	// }catch(Exception ex){
	// log.error(ex.getMessage(),ex);
	// throw new DAOException(new ErrorHandler(ex).getMessage());
	// }
	//
	// return usaCAInfoVO;
	// }

	// /**
	// * Del 지역의 State code 정보를 조회해 온다.<br>
	// *
	// * @param String delCd
	// * @return String
	// * @exception DAOException
	// */
	// public String searchDelStateByLocCd ( String delCd ) throws DAOException {
	// DBRowSet dbRowset = null;
	// String steCd = null;
	//    	
	// //query parameter
	// Map<String, Object> param = new HashMap<String, Object>();
	// //velocity parameter
	// Map<String, Object> velParam = new HashMap<String, Object>();
	//
	// try{
	// param.put("del_cd",delCd);
	// velParam.put("del_cd",delCd);
	//            
	// dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new
	// UsaManifestListDownloadDBDAOsearchDelStateByLocCdRSQL(), param, velParam);
	// if(dbRowset.next()) {
	// steCd = dbRowset.getString(1);
	// }
	//            
	// }catch(SQLException se){
	// log.error(se.getMessage(),se);
	// throw new DAOException(new ErrorHandler(se).getMessage());
	// }catch(Exception ex){
	// log.error(ex.getMessage(),ex);
	// throw new DAOException(new ErrorHandler(ex).getMessage());
	// }
	//
	// return steCd;
	// }

	/**
	 * HUB_LOC_CD 을 조회해 온다.<br>
	 * 
	 * @param UsaManifestListCondVO condVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchHubLoc(UsaManifestListCondVO condVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnData = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			param.put("bl_no", condVO.getBlNo());
			param.put("pod_nod_cd", condVO.getPodNodCd());
			param.put("del_nod_cd", condVO.getDelNodCd());

			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchHubLocRSQL(), param, velParam);
			if (dbRowset.next())
			{
				rtnData = dbRowset.getString(1);
			}

		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return rtnData;
	}

	/**
	 * USA_LST_LOC_CD 을 조회해 온다.<br>
	 * 
	 * @param UsaManifestListCondVO condVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchLastUsaLoc(UsaManifestListCondVO condVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnData = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			param.put("pod_cd", condVO.getPodCd());
			param.put("del_cd", condVO.getDelCd());

			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchLastUsaLocRSQL(), param, velParam);
			if (dbRowset.next())
			{
				rtnData = dbRowset.getString(1);
			}

		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return rtnData;
	}

	/**
	 * 미세관테이블의 B/L 정보를 수정한다.<br>
	 * 
	 * @param UsaBlInfoVO usaBlInfoVO
	 * @return Integer
	 * @exception DAOException
	 */
	public int modifyAdvancedBlByBl(UsaBlInfoVO usaBlInfoVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;
		try
		{
			Map<String, String> mapVO = usaBlInfoVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new UsaManifestListDownloadDBDAOmodifyAdvancedBlByBlUSQL(),
					param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * 미세관테이블로 B/L 정보를 신규 생성한다.<br>
	 * 
	 * @param List<UsaBlInfoVO> usaBlInfoVOs
	 * @exception DAOException
	 */
	public void addAdvancedBlByBl(List<UsaBlInfoVO> usaBlInfoVOs) throws DAOException {
		int addCnt[] = null;
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			addCnt = sqlExe.executeBatch((ISQLTemplate) new UsaManifestListDownloadDBDAOaddAdvancedBlByBlCSQL(),
					usaBlInfoVOs, null);

			for (int i = 0; i < addCnt.length; i++)
			{
				if (addCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No" + i + " SQL");
			}
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Customer 정보를 조회한다.<br>
	 * 
	 * @param List<UsaManifestListCondVO> condVOs
	 * @param SignOnUserAccount account
	 * @return List<UsaBkgCustomerVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UsaBkgCustomerVO> searchBkgCustomerByBl(List<UsaManifestListCondVO> condVOs, SignOnUserAccount account)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<UsaBkgCustomerVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (condVOs != null)
			{
				Map<String, String> mapVO = condVOs.get(0).getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("usr_id", account.getUsr_id());

				String strBkgNo = null;
				List<String> arrString = new ArrayList(); // BKG_NO
				for (int i = 0; i < condVOs.size(); i++)
				{
					strBkgNo = condVOs.get(i).getBkgNo();
					arrString.add(strBkgNo);
				}
				velParam.put("field_list", arrString);
			}

			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchBkgCustomerByBlRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaBkgCustomerVO.class);

		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return list;
	}

	/**
	 * 미세관테이블로 Customer 정보를 수정한다.<br>
	 * 
	 * @param UsaBkgCustomerVO customerAddVO
	 * @param SignOnUserAccount account
	 * @return Integer
	 * @exception DAOException
	 */
	public int modifyAdvancedCustomerByBl(UsaBkgCustomerVO customerAddVO, SignOnUserAccount account)
			throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;
		try
		{
			Map<String, String> mapVO = customerAddVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			param.put("cnt_cd", CountryCode.US);
			velParam.put("cnt_cd", CountryCode.US);
			param.put("upd_usr_id", account.getUsr_id());
			velParam.put("upd_usr_id", account.getUsr_id());

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOmodifyAdvancedCustomerByBlUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * 미세관테이블로 Customer 정보를 신규 생성한다.<br>
	 * 
	 * @param List<UsaBkgCustomerVO> customerAddVOs
	 * @exception DAOException
	 */
	public void addAdvancedCustomerByBl(List<UsaBkgCustomerVO> customerAddVOs) throws DAOException {
		int addCnt[] = null;
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			addCnt = sqlExe.executeBatch((ISQLTemplate) new UsaManifestListDownloadDBDAOaddAdvancedCustomerByBlCSQL(),
					customerAddVOs, null);

			for (int i = 0; i < addCnt.length; i++)
			{
				if (addCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No" + i + " SQL");
			}
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Container 정보를 조회한다.<br>
	 * 
	 * @param List<UsaManifestListCondVO> condVOs
	 * @param SignOnUserAccount account
	 * @return List<UsaBkgCntrVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UsaBkgCntrVO> searchBkgContainerByBl(List<UsaManifestListCondVO> condVOs, SignOnUserAccount account)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<UsaBkgCntrVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (condVOs != null)
			{
				Map<String, String> mapVO = condVOs.get(0).getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("usr_id", account.getUsr_id());

				String strBkgNo = null;
				List<String> arrString = new ArrayList(); // BKG_NO
				for (int i = 0; i < condVOs.size(); i++)
				{
					strBkgNo = condVOs.get(i).getBkgNo();
					arrString.add(strBkgNo);
				}
				velParam.put("field_list", arrString);
			}

			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchBkgContainerByBlRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaBkgCntrVO.class);

		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return list;
	}

	// /**
	// * 미세관테이블로 Container 정보를 수정한다.<br>
	// *
	// * @param UsaBkgCntrVO cntrAddVO
	// * @param SignOnUserAccount account
	// * @return Integer
	// * @exception DAOException
	// */
	// public int modifyAdvancedCntrByCntr ( UsaBkgCntrVO cntrAddVO, SignOnUserAccount account ) throws DAOException {
	// //query parameter
	// Map<String, Object> param = new HashMap<String, Object>();
	// //velocity parameter
	// Map<String, Object> velParam = new HashMap<String, Object>();
	//
	// int result = -1;
	// try{
	// Map<String, String> mapVO = cntrAddVO.getColumnValues();
	//    		
	// param.putAll(mapVO);
	// velParam.putAll(mapVO);
	//			
	// param.put("cnt_cd", CountryCode.US);
	// velParam.put("cnt_cd", CountryCode.US);
	// param.put("upd_usr_id", account.getUsr_id());
	// velParam.put("upd_usr_id", account.getUsr_id());
	//            
	// SQLExecuter sqlExe = new SQLExecuter("");
	// result = sqlExe.executeUpdate((ISQLTemplate)new UsaManifestListDownloadDBDAOmodifyAdvancedCntrByCntrUSQL(),
	// param, velParam);
	// if(result == Statement.EXECUTE_FAILED)
	// throw new DAOException("Fail to insert SQL");
	// }catch(SQLException se){
	// log.error(se.getMessage(),se);
	// throw new DAOException(new ErrorHandler(se).getMessage());
	// }catch(Exception ex){
	// log.error(ex.getMessage(),ex);
	// throw new DAOException(new ErrorHandler(ex).getMessage());
	// }
	//        
	// return result;
	// }

	/**
	 * 미세관테이블로 Container 정보를 신규 생성한다.<br>
	 * 
	 * @param List<UsaBkgCntrVO> cntrAddVOs
	 * @exception DAOException
	 */
	public void addAdvancedCntrByCntr(List<UsaBkgCntrVO> cntrAddVOs) throws DAOException {
		int addCnt[] = null;
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			addCnt = sqlExe.executeBatch((ISQLTemplate) new UsaManifestListDownloadDBDAOaddAdvancedCntrByCntrCSQL(),
					cntrAddVOs, null);

			for (int i = 0; i < addCnt.length; i++)
			{
				if (addCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No" + i + " SQL");
			}
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Container Seal No 정보를 조회한다.<br>
	 * 
	 * @param List<UsaManifestListCondVO> condVOs
	 * @param SignOnUserAccount account
	 * @return List<UsaBkgCntrSealNoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UsaBkgCntrSealNoVO> searchBkgContainerSealNoByBl(List<UsaManifestListCondVO> condVOs,
			SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		List<UsaBkgCntrSealNoVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (condVOs != null)
			{
				Map<String, String> mapVO = condVOs.get(0).getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("usr_id", account.getUsr_id());

				String strBkgNo = null;
				List<String> arrString = new ArrayList(); // BKG_NO
				for (int i = 0; i < condVOs.size(); i++)
				{
					strBkgNo = condVOs.get(i).getBkgNo();
					arrString.add(strBkgNo);
				}
				velParam.put("field_list", arrString);
			}

			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchBkgContainerSealNoByBlRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaBkgCntrSealNoVO.class);

		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return list;
	}

	/**
	 * 미세관테이블로 Container Seal No 정보를 신규 생성한다.<br>
	 * 
	 * @param List<UsaBkgCntrSealNoVO> cntrSealNoAddVOs
	 * @exception DAOException
	 */
	public void addAdvancedCntrSealNoByCntr(List<UsaBkgCntrSealNoVO> cntrSealNoAddVOs) throws DAOException {
		int addCnt[] = null;
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			addCnt = sqlExe.executeBatch(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOaddAdvancedCntrSealNoByCntrCSQL(), cntrSealNoAddVOs,
					null);

			for (int i = 0; i < addCnt.length; i++)
			{
				if (addCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No" + i + " SQL");
			}
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * BKG쪽 C/M정보를 조회한다.<br>
	 * 
	 * @param List<UsaManifestListCondVO> condVOs
	 * @param SignOnUserAccount account
	 * @return List<UsaBkgCmVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UsaBkgCmVO> searchBkgCmByCntr(List<UsaManifestListCondVO> condVOs, SignOnUserAccount account)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<UsaBkgCmVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (condVOs != null)
			{
				Map<String, String> mapVO = condVOs.get(0).getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("usr_id", account.getUsr_id());

				String strBkgNo = null;
				List<String> arrString = new ArrayList(); // BKG_NO
				for (int i = 0; i < condVOs.size(); i++)
				{
					strBkgNo = condVOs.get(i).getBkgNo();
					arrString.add(strBkgNo);
				}
				velParam.put("field_list", arrString);
			}

			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchBkgCmByCntrRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaBkgCmVO.class);

		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return list;
	}

	// /**
	// * Commodity Code로 Commodity Info를 가져온다.<br>
	// *
	// * @param String cmdtCd
	// * @return String
	// * @exception DAOException
	// */
	// public String searchCommodityInfoByCmdtCd ( String cmdtCd ) throws DAOException {
	// DBRowSet dbRowset = null;
	// String cmdtDesc = null;
	//    	
	// //query parameter
	// Map<String, Object> param = new HashMap<String, Object>();
	// //velocity parameter
	// Map<String, Object> velParam = new HashMap<String, Object>();
	//
	// try{
	// param.put("cmdt_cd",cmdtCd);
	// velParam.put("cmdt_cd",cmdtCd);
	//            
	// dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new
	// UsaManifestListDownloadDBDAOsearchCommodityInfoByCmdtCdRSQL(), param, velParam);
	// if(dbRowset.next()) {
	// cmdtDesc = dbRowset.getString(1);
	// }
	//            
	// }catch(SQLException se){
	// log.error(se.getMessage(),se);
	// throw new DAOException(new ErrorHandler(se).getMessage());
	// }catch(Exception ex){
	// log.error(ex.getMessage(),ex);
	// throw new DAOException(new ErrorHandler(ex).getMessage());
	// }
	//
	// return cmdtDesc;
	// }

	/**
	 * 미세관테이블로 CM 정보를 신규 생성한다.<br>
	 * 
	 * @param List<UsaBkgCmVO> cmAddVOs
	 * @exception DAOException
	 */
	public void addAdvancedCmByCntr(List<UsaBkgCmVO> cmAddVOs) throws DAOException {
		int addCnt[] = null;
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			addCnt = sqlExe.executeBatch((ISQLTemplate) new UsaManifestListDownloadDBDAOaddAdvancedCmByCntrCSQL(),
					cmAddVOs, null);

			for (int i = 0; i < addCnt.length; i++)
			{
				if (addCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No" + i + " SQL");
			}
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * House B/L 일반정보를 조회한다.<br>
	 * 
	 * @param UsaManifestListCondVO condVO
	 * @return UsaBlInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public UsaBlInfoVO searchHblInfoByRefNo(UsaManifestListCondVO condVO) throws DAOException {
		DBRowSet dbRowset = null;
		UsaBlInfoVO usaBlInfoVO = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = condVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchHblInfoByRefNoRSQL(), param, velParam);
			List<UsaBlInfoVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaBlInfoVO.class);

			if (list.size() > 0)
			{
				usaBlInfoVO = (UsaBlInfoVO) list.get(0);
			}
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return usaBlInfoVO;
	}

	/**
	 * 기 생성된 컨테이너 정보를 삭제한다.<br>
	 * 
	 * @param List<UsaManifestListCondVO> condVOs
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void removeContainer(List<UsaManifestListCondVO> condVOs) throws DAOException {
		int addCnt[] = null;
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			String strBlNo = null;
			List<String> arrString = new ArrayList(); // BL_NO
			for (int i = 0; i < condVOs.size(); i++)
			{
				strBlNo = condVOs.get(i).getBlNo();
				arrString.add(strBlNo);
			}
			velParam.put("field_list", arrString);

			SQLExecuter sqlExe = new SQLExecuter("");
			addCnt = sqlExe.executeBatch((ISQLTemplate) new UsaManifestListDownloadDBDAOremoveContainerDSQL(), condVOs,
					velParam);

			for (int i = 0; i < addCnt.length; i++)
			{
				if (addCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No" + i + " SQL");
			}
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 기 생성된 CM 정보를 삭제한다.<br>
	 * 
	 * @param List<UsaManifestListCondVO> condVOs
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void removeCMByBl(List<UsaManifestListCondVO> condVOs) throws DAOException {
		int addCnt[] = null;
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			String strBlNo = null;
			List<String> arrString = new ArrayList(); // BL_NO
			for (int i = 0; i < condVOs.size(); i++)
			{
				strBlNo = condVOs.get(i).getBlNo();
				arrString.add(strBlNo);
			}
			velParam.put("field_list", arrString);

			SQLExecuter sqlExe = new SQLExecuter("");
			addCnt = sqlExe.executeBatch((ISQLTemplate) new UsaManifestListDownloadDBDAOremoveCMByBlDSQL(), condVOs,
					velParam);

			for (int i = 0; i < addCnt.length; i++)
			{
				if (addCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No" + i + " SQL");
			}
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 기 생성된 컨테이너 Seal No. 정보를 삭제한다.<br>
	 * 
	 * @param List<UsaManifestListCondVO> condVOs
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void removeContainerSealNo(List<UsaManifestListCondVO> condVOs) throws DAOException {
		int addCnt[] = null;
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			String strBlNo = null;
			List<String> arrString = new ArrayList(); // BL_NO
			for (int i = 0; i < condVOs.size(); i++)
			{
				strBlNo = condVOs.get(i).getBlNo();
				arrString.add(strBlNo);
			}
			velParam.put("field_list", arrString);

			SQLExecuter sqlExe = new SQLExecuter("");
			addCnt = sqlExe.executeBatch((ISQLTemplate) new UsaManifestListDownloadDBDAOremoveContainerSealNoDSQL(),
					condVOs, velParam);

			for (int i = 0; i < addCnt.length; i++)
			{
				if (addCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No" + i + " SQL");
			}
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 기 생성된 B/L 정보를 삭제한다.<br>
	 * 
	 * @param List<UsaManifestListCondVO> condVOs
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void removeAdvancedBlByBl(List<UsaManifestListCondVO> condVOs) throws DAOException {
		int addCnt[] = null;
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			String strBlNo = null;
			List<String> arrString = new ArrayList(); // BL_NO
			for (int i = 0; i < condVOs.size(); i++)
			{
				strBlNo = condVOs.get(i).getBlNo();
				arrString.add(strBlNo);
			}
			velParam.put("field_list", arrString);

			SQLExecuter sqlExe = new SQLExecuter("");
			addCnt = sqlExe.executeBatch((ISQLTemplate) new UsaManifestListDownloadDBDAOremoveAdvancedBlByBlDSQL(),
					condVOs, velParam);

			for (int i = 0; i < addCnt.length; i++)
			{
				if (addCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No" + i + " SQL");
			}
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 기 생성된 화주정보를 삭제한다.<br>
	 * 
	 * @param List<UsaManifestListCondVO> condVOs
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void removeCustomerByBl(List<UsaManifestListCondVO> condVOs) throws DAOException {
		int addCnt[] = null;
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			String strBlNo = null;
			List<String> arrString = new ArrayList(); // BL_NO
			for (int i = 0; i < condVOs.size(); i++)
			{
				strBlNo = condVOs.get(i).getBlNo();
				arrString.add(strBlNo);
			}
			velParam.put("field_list", arrString);

			SQLExecuter sqlExe = new SQLExecuter("");
			addCnt = sqlExe.executeBatch((ISQLTemplate) new UsaManifestListDownloadDBDAOremoveCustomerByBlDSQL(),
					condVOs, velParam);

			for (int i = 0; i < addCnt.length; i++)
			{
				if (addCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No" + i + " SQL");
			}
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * B/L No.로 House B/L의 화주정보를 조회한다. <br>
	 * 
	 * @param List<UsaManifestListCondVO> condVOs
	 * @param SignOnUserAccount account
	 * @return List<UsaBkgCustomerVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UsaBkgCustomerVO> searchHblCustomer(List<UsaManifestListCondVO> condVOs, SignOnUserAccount account)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<UsaBkgCustomerVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (condVOs != null)
			{
				Map<String, String> mapVO = condVOs.get(0).getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("usr_id", account.getUsr_id());

				String strBlNo = null;
				List<String> arrString = new ArrayList(); // BL_NO
				for (int i = 0; i < condVOs.size(); i++)
				{
					strBlNo = condVOs.get(i).getBlNo();
					arrString.add(strBlNo);
				}
				velParam.put("field_list", arrString);
			}

			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchHblCustomerRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaBkgCustomerVO.class);

		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return list;
	}

	/**
	 * H.B/L의 컨테이너 정보를 조회한다. <br>
	 * 
	 * @param List<UsaManifestListCondVO> condVOs
	 * @param SignOnUserAccount account
	 * @return List<UsaBkgCntrVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UsaBkgCntrVO> searchContainerByBl(List<UsaManifestListCondVO> condVOs, SignOnUserAccount account)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<UsaBkgCntrVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (condVOs != null)
			{
				Map<String, String> mapVO = condVOs.get(0).getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("usr_id", account.getUsr_id());

				String strBlNo = null;
				List<String> arrString = new ArrayList(); // BL_NO
				for (int i = 0; i < condVOs.size(); i++)
				{
					strBlNo = condVOs.get(i).getBlNo();
					arrString.add(strBlNo);
				}
				velParam.put("field_list", arrString);
			}

			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchContainerByBlRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaBkgCntrVO.class);

		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return list;
	}

	/**
	 * H.B/L의 Container Seal No 정보를 조회한다.<br>
	 * 
	 * @param List<UsaManifestListCondVO> condVOs
	 * @param SignOnUserAccount account
	 * @return List<UsaBkgCntrSealNoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UsaBkgCntrSealNoVO> searchContainerSealNoByBl(List<UsaManifestListCondVO> condVOs,
			SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		List<UsaBkgCntrSealNoVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (condVOs != null)
			{
				Map<String, String> mapVO = condVOs.get(0).getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("usr_id", account.getUsr_id());

				String strBlNo = null;
				List<String> arrString = new ArrayList(); // BL_NO
				for (int i = 0; i < condVOs.size(); i++)
				{
					strBlNo = condVOs.get(i).getBlNo();
					arrString.add(strBlNo);
				}
				velParam.put("field_list", arrString);
			}

			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchContainerSealNoByBlRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaBkgCntrSealNoVO.class);

		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return list;
	}

	/**
	 * B/L No.로 House B/L의 Package/Weight 정보를 조회한다. <br>
	 * 
	 * @param List<UsaManifestListCondVO> condVOs
	 * @param SignOnUserAccount account
	 * @return List<UsaBkgCmVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UsaBkgCmVO> searchHblCmPkgWgtByBl(List<UsaManifestListCondVO> condVOs, SignOnUserAccount account)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<UsaBkgCmVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (condVOs != null)
			{
				Map<String, String> mapVO = condVOs.get(0).getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("usr_id", account.getUsr_id());

				String strBlNo = null;
				List<String> arrString = new ArrayList(); // BL_NO
				for (int i = 0; i < condVOs.size(); i++)
				{
					strBlNo = condVOs.get(i).getBlNo();
					arrString.add(strBlNo);
				}
				velParam.put("field_list", arrString);
			}

			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchHblCmPkgWgtByBlRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaBkgCmVO.class);

		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return list;
	}

	/**
	 * BL의 컨테이너 정보를 조회한다.<br>
	 * 
	 * @param String cntCd
	 * @param String blNo
	 * @return List<ContainerListRsltVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ContainerListRsltVO> searchContainerByBl(String cntCd, String blNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<ContainerListRsltVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			param.put("cnt_cd", cntCd);
			velParam.put("cnt_cd", cntCd);
			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchContainerByBl2RSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaCntrListRsltVO.class);

		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return list;
	}

	/**
	 * BL의 컨테이너 Seal No. 정보를 조회한다.<br>
	 * 
	 * @param String cntCd
	 * @param String blNo
	 * @return List<ContainerListRsltVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ContainerListRsltVO> searchContainerSealNoByBl(String cntCd, String blNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<ContainerListRsltVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			param.put("cnt_cd", cntCd);
			velParam.put("cnt_cd", cntCd);
			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchContainerSealNoByBl2RSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaCntrSealNoListRsltVO.class);

		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return list;
	}

	/**
	 * BL의 컨테이너 정보를 수정한다.<br>
	 * 
	 * @param UsaCntrListRsltVO usaCntrListRsltVO
	 * @param SignOnUserAccount account
	 * @return Integer
	 * @exception DAOException
	 */
	public int modifyContainer(UsaCntrListRsltVO usaCntrListRsltVO, SignOnUserAccount account) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;
		try
		{
			Map<String, String> mapVO = usaCntrListRsltVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("cre_usr_id", account.getUsr_id());
			velParam.put("cre_usr_id", account.getUsr_id());
			param.put("upd_usr_id", account.getUsr_id());
			velParam.put("upd_usr_id", account.getUsr_id());
			param.put("cnt_cd", usaCntrListRsltVO.getCntCd());
			velParam.put("cnt_cd", usaCntrListRsltVO.getCntCd());

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new UsaManifestListDownloadDBDAOmodifyContainerUSQL(), param,
					velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return result;
	}

	/**
	 * BL의 컨테이너 Seal No. 정보를 수정한다.<br>
	 * 
	 * @param UsaCntrSealNoListRsltVO usaCntrSealListRsltVO
	 * @param SignOnUserAccount account
	 * @return Integer
	 * @exception DAOException
	 */
	public int modifyContainerSealNo(UsaCntrSealNoListRsltVO usaCntrSealListRsltVO, SignOnUserAccount account)
			throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;
		try
		{
			Map<String, String> mapVO = usaCntrSealListRsltVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("usr_id", account.getUsr_id());
			velParam.put("usr_id", account.getUsr_id());
			param.put("cnt_cd", usaCntrSealListRsltVO.getCntCd());
			velParam.put("cnt_cd", usaCntrSealListRsltVO.getCntCd());

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new UsaManifestListDownloadDBDAOmodifyContainerSealNoUSQL(),
					param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return result;
	}

	/**
	 * BL의 컨테이너 Seal No. 정보를 삭제한다.<br>
	 * 
	 * @param UsaCntrSealNoListRsltVO usaCntrSealListRsltVO
	 * @return Integer
	 * @exception DAOException
	 */
	public int removeContainerSealNo(UsaCntrSealNoListRsltVO usaCntrSealListRsltVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;
		try
		{
			Map<String, String> mapVO = usaCntrSealListRsltVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("cnt_cd", usaCntrSealListRsltVO.getCntCd());
			velParam.put("cnt_cd", usaCntrSealListRsltVO.getCntCd());

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new UsaManifestListDownloadDBDAOremoveContainerSealNo2DSQL(),
					param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return result;
	}

	// /**
	// * BL의 컨테이너 Seal No. 정보를 삭제한다.<br>
	// *
	// * @param List<UsaManifestListCondVO> condVOs
	// * @exception DAOException
	// */
	// public void removeContainerSealNo( List<UsaManifestListCondVO> condVOs ) throws DAOException {
	// int addCnt[] = null;
	// try{
	// SQLExecuter sqlExe = new SQLExecuter("");
	// addCnt = sqlExe.executeBatch((ISQLTemplate) new UsaManifestListDownloadDBDAOremoveContainerSealNoDSQL(), condVOs,
	// null);
	//
	// for (int i = 0; i < addCnt.length; i++) {
	// if (addCnt[i] == Statement.EXECUTE_FAILED)
	// throw new DAOException("Fail to insert No" + i + " SQL");
	// }
	// }catch(SQLException se){
	// log.error(se.getMessage(),se);
	// throw new DAOException(new ErrorHandler(se).getMessage());
	// }catch(Exception ex){
	// log.error(ex.getMessage(),ex);
	// throw new DAOException(new ErrorHandler(ex).getMessage());
	// }
	// }

	/**
	 * 컨테이너 Type Size Code(D2, D4...)를 가져온다.<br>
	 * 
	 * @param String cntrNo
	 * @return List<ContainerListRsltVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ContainerListRsltVO> searchCntrTySzCd(String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<ContainerListRsltVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			param.put("cntr_no", cntrNo);
			velParam.put("cntr_no", cntrNo);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchCntrTySzCdRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaCntrListRsltVO.class);

		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return list;
	}

	/**
	 * Container가 활성화 상태인지 Delete상태인지를 업데이트 한다.<br>
	 * 
	 * @param UsaCntrListRsltVO usaCntrListRsltVO
	 * @return Integer
	 * @exception DAOException
	 */
	public int modifyContainerStatus(UsaCntrListRsltVO usaCntrListRsltVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;
		try
		{
			Map<String, String> mapVO = usaCntrListRsltVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("cnt_cd", usaCntrListRsltVO.getCntCd());
			velParam.put("cnt_cd", usaCntrListRsltVO.getCntCd());

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new UsaManifestListDownloadDBDAOmodifyContainerStatusUSQL(),
					param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return result;
	}

	/**
	 * BL의 컨테이너 정보를 조회한다.<br>
	 * 
	 * @param String cntCd
	 * @param String blNo
	 * @return List<UsaContainerManifestInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UsaContainerManifestInfoVO> searchContainerManifestInfo(String cntCd, String blNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<UsaContainerManifestInfoVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			param.put("cnt_cd", cntCd);
			velParam.put("cnt_cd", cntCd);
			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchContainerManifestInfoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaContainerManifestInfoVO.class);

		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * BL의 컨테이너 목록을 조회한다.<br>
	 * 
	 * @param String cntCd
	 * @param String blNo
	 * @return List<UsaContainerListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UsaContainerListVO> searchContainerList(String cntCd, String blNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<UsaContainerListVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			param.put("cnt_cd", cntCd);
			velParam.put("cnt_cd", cntCd);
			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchContainerListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaContainerListVO.class);

		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * BL의 컨테이너 CM 목록을 조회한다.<br>
	 * 
	 * @param String cntCd
	 * @param String blNo
	 * @param String cntrNo
	 * @return List<UsaContainerManifestListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UsaContainerManifestListVO> searchContainerManifestList(String cntCd, String blNo, String cntrNo)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<UsaContainerManifestListVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			param.put("cnt_cd", cntCd);
			velParam.put("cnt_cd", cntCd);
			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);
			param.put("cntr_no", cntrNo);
			velParam.put("cntr_no", cntrNo);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchContainerManifestListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaContainerManifestListVO.class);

		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * BL의 컨테이너 CM 정보를 수정 또는 등록한다.<br>
	 * 
	 * @param UsaContainerManifestListVO usaCmVO
	 * @param SignOnUserAccount account
	 * @return Integer
	 * @exception DAOException
	 */
	public int modifyCM(UsaContainerManifestListVO usaCmVO, SignOnUserAccount account) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;
		try
		{
			Map<String, String> mapVO = usaCmVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("usr_id", account.getUsr_id());
			velParam.put("usr_id", account.getUsr_id());
			param.put("cnt_cd", usaCmVO.getCntCd());
			velParam.put("cnt_cd", usaCmVO.getCntCd());

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new UsaManifestListDownloadDBDAOmodifyCMUSQL(), param,
					velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return result;
	}

	/**
	 * BL의 컨테이너 CM 정보를 삭제한다.<br>
	 * 
	 * @param UsaContainerManifestListVO usaCmVO
	 * @return Integer
	 * @exception DAOException
	 */
	public int removeCM(UsaContainerManifestListVO usaCmVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;
		try
		{
			Map<String, String> mapVO = usaCmVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("cnt_cd", usaCmVO.getCntCd());
			velParam.put("cnt_cd", usaCmVO.getCntCd());

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new UsaManifestListDownloadDBDAOremoveCMDSQL(), param,
					velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return result;
	}

	/**
	 * US Comtoms로 Manifest를 신고하는 기능화면(0613)의 상세조회<br>
	 * 
	 * @param UsaManifestSearchCondVO usaManifestSearchCondVO
	 * @return List<UsaManifestSearchDetailVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UsaManifestSearchDetailVO> searchManifestList(UsaManifestSearchCondVO usaManifestSearchCondVO)
			throws DAOException {

		DBRowSet dbRowset = null;
		List<UsaManifestSearchDetailVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = usaManifestSearchCondVO.getColumnValues();
			param.putAll(mapVO);

			velParam.put("full_empty", usaManifestSearchCondVO.getFullEmpty());
			velParam.put("all_err", usaManifestSearchCondVO.getAllErr());

			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOUsaManifestSearchDetailRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaManifestSearchDetailVO.class);

		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return list;
	}

	/**
	 * Export US Comtoms로 Manifest를 신고하는 기능화면(0613)의 상세조회<br>
	 * 
	 * @param UsaManifestSearchCondVO usaManifestSearchCondVO
	 * @return List<UsaManifestSearchDetailVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UsaManifestSearchDetailVO> searchManifestListOB(UsaManifestSearchCondVO usaManifestSearchCondVO)
			throws DAOException {

		DBRowSet dbRowset = null;
		List<UsaManifestSearchDetailVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = usaManifestSearchCondVO.getColumnValues();
			param.putAll(mapVO);

			velParam.put("full_empty", usaManifestSearchCondVO.getFullEmpty());
			velParam.put("all_err", usaManifestSearchCondVO.getAllErr());

			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOUsaManifestSearchDetailOBRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaManifestSearchDetailVO.class);

		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return list;
	}
	
	/**
	 * US Comtoms로 Manifest를 신고하는 기능화면(0613)의 요약조회<br>
	 * 
	 * @param UsaManifestSearchCondVO condVO
	 * @return List<UsaManifestSummaryVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UsaManifestSummaryVO> searchManifestSummary(UsaManifestSearchCondVO condVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<UsaManifestSummaryVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = condVO.getColumnValues();
			param.putAll(mapVO);

			// velParam.put("full_empty", condVO.getFullEmpty());
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchManifestSummaryRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaManifestSummaryVO.class);

		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return list;
	}

	/**
	 * US Comtoms로 Export Manifest를 신고하는 기능화면(0615)의 요약조회<br>
	 * 
	 * @param UsaManifestSearchCondVO condVO
	 * @return List<UsaManifestSummaryVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UsaManifestSummaryVO> searchManifestSummaryOB(UsaManifestSearchCondVO condVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<UsaManifestSummaryVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = condVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new UsaManifestListDownloadDBDAOsearchManifestSummaryOBRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaManifestSummaryVO.class);

		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return list;
	}	
	/**
	 * BKG_CSTMS_ADV_BL bl_key(bl_no||bl_no_tp||bl_no_chk) 에 대한 MF_STS_CD 를 조회하여 반환<br>
	 * 
	 * @param String bl_key
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchBlStatus(String bl_key) throws DAOException {
		DBRowSet dbRowset = null;
		List<UsaSearchBlStatusVO> list = null;
		String rtn = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{

			param.put("bl_key", bl_key);
			velParam.put("bl_key", bl_key);
			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchBlStatusRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaSearchBlStatusVO.class);
			if (!list.isEmpty())
			{
				rtn = list.get(0).getMfStsCd();
			}

		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return rtn;
	}

	/**
	 * BKG_CSTMS_ADV_BL bl_key(bl_no||bl_no_tp||bl_no_chk) 에 대한 MF_STS_CD 를 수정하여 결과값 반환<br>
	 * 
	 * @param String bl_key
	 * @param String user_id
	 * @param String stat
	 * @return Integer
	 * @exception DAOException
	 */
	public int modifyBlStatus(String bl_key, String user_id, String stat) throws DAOException {

		int result = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{

			param.put("bl_key", bl_key);
			param.put("user", user_id);
			param.put("stat", stat);
			velParam.put("bl_key", bl_key);
			velParam.put("user", user_id);
			velParam.put("stat", stat);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new UsaManifestListDownloadDBDAOmodifyBlStatusUSQL(), param,
					velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * 새로 등록할 History Master 의 Seq를 조회한다.<br>
	 * 
	 * @param String bl_key String
	 * @return Integer
	 * @exception DAOException
	 */
	public int addBlHistorySeq(String bl_key) throws DAOException {
		DBRowSet dbRowset = null;
		int seq = 0;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			param.put("cnt_cd", bl_key.substring(0, 2));
			velParam.put("cnt_cd", bl_key.substring(0, 2));
			param.put("bl_no", bl_key.substring(2));
			velParam.put("bl_no", bl_key.substring(2));

			SQLExecuter sqlExe = new SQLExecuter("");
			dbRowset = sqlExe.executeQuery((ISQLTemplate) new UsaManifestListDownloadDBDAOcreateBlHistorySeqRSQL(),
					param, velParam);
			if (dbRowset.next())
			{
				seq = dbRowset.getInt(1);
			}
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return seq;
	}

	/**
	 * History Master 정보를 저장한다.<br>
	 * 
	 * @param BkgCstmsIbdHisVO bkgCstmsIbdHisVO
	 * @return Integer
	 * @exception DAOException
	 */
	public int addBlHistory(BkgCstmsIbdHisVO bkgCstmsIbdHisVO) throws DAOException {

		int result = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = bkgCstmsIbdHisVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new UsaManifestListDownloadDBDAOaddBlHistoryCSQL(), param,
					velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

			return result;
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * History 상세 내역을 저장한다.<br>
	 * 
	 * @param BkgCstmsIbdHisDtlVO bkgCstmsIbdHisDtlVO
	 * @exception DAOException
	 */
	public void addBlDetailHistory(BkgCstmsIbdHisDtlVO bkgCstmsIbdHisDtlVO) throws DAOException {

		int result = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = bkgCstmsIbdHisDtlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new UsaManifestListDownloadDBDAOaddBlDetailHistoryCSQL(),
					param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Hold Notice를 송부를 위하여 Customs에서 받는 특정 Code를 등록 및 조회 한다<br>
	 * 
	 * @param DispoCdListCondVO dispoCdListCondVO
	 * @return List<DispoCdDetailVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<DispoCdDetailVO> searchUsaDispositionCdList(DispoCdListCondVO dispoCdListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DispoCdDetailVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (dispoCdListCondVO != null)
			{
				Map<String, String> mapVO = dispoCdListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchDispositionCdListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, DispoCdDetailVO.class);

		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return list;
	}

	/**
	 * Hold Notice를 송부를 위하여 Customs에서 받는 특정 Code를 등록한다.<br>
	 * 
	 * @param DispoCdDetailVO detailVO
	 * @exception DAOException
	 */
	public void addDispositonCode(DispoCdDetailVO detailVO) throws DAOException {

		int result = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = detailVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new UsaManifestListDownloadDBDAOaddDispositonCodeCSQL(),
					param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Hold Notice를 송부를 위하여 Customs에서 받는 특정 Code를 수정한다.<br>
	 * 
	 * @param DispoCdDetailVO detailVO
	 * @exception DAOException
	 */
	public void modifyDispositionCode(DispoCdDetailVO detailVO) throws DAOException {

		int result = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = detailVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new UsaManifestListDownloadDBDAOmodifyDispositionCodeUSQL(),
					param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Hold Notice를 송부를 위하여 Customs에서 받는 특정 Code를 삭제한다.<br>
	 * 
	 * @param DispoCdDetailVO detailVO
	 * @exception DAOException
	 */
	public void removeDispositionCode(DispoCdDetailVO detailVO) throws DAOException {

		int result = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = detailVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new UsaManifestListDownloadDBDAOremoveDispositionCodeDSQL(),
					param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * House B/L정보가 정확히 입력되었는지 확인하기 위해 관련 정보를 조회한다.<br>
	 * 
	 * @param UsaHblCheckCondVO usaHblCheckCondVO
	 * @return List<HouseBlDetailVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<HouseBlDetailVO> searchHblCheckList(UsaHblCheckCondVO usaHblCheckCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<HouseBlDetailVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (usaHblCheckCondVO != null)
			{
				Map<String, String> mapVO = usaHblCheckCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchHblCheckListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaHblCheckDetailVO.class);

		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return list;
	}

	/**
	 * 0533화면에서 Cntr의 Arrival, Exp Date를 갱신하기 위해 작성.<br>
	 * 
	 * @param UsaInbondDataVO usaInbondDataVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyGeneralArrivalbyCntr(UsaInbondDataVO usaInbondDataVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try
		{
			Map<String, String> mapVO = usaInbondDataVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOmodifyGeneralArrivalbyCntrUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		}
		catch (DAOException de)
		{
			log.error(de.getMessage(), de);
			throw de;
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * 0533화면에서 BL의 Arrival, Exp Date를 갱신하기 위해 작성.<br>
	 * 
	 * @param UsaInbondDataVO usaInbondDataVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyGeneralArrivalbyBl(UsaInbondDataVO usaInbondDataVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try
		{
			Map<String, String> mapVO = usaInbondDataVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOmodifyGeneralArrivalbyBlUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		}
		catch (DAOException de)
		{
			log.error(de.getMessage(), de);
			throw de;
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * 0408화면에서 IBD의 trsp_tp_cd등을 갱신하기 위해 작성.<br>
	 * 
	 * @param UsaInbondManifestDetailListVO usaInbondManifestDetailListVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyMIBList(UsaInbondManifestDetailListVO usaInbondManifestDetailListVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try
		{
			Map<String, String> mapVO = usaInbondManifestDetailListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("origin_bl_flag", usaInbondManifestDetailListVO.getIbflag());
			velParam.put("origin_bl_flag", usaInbondManifestDetailListVO.getIbflag());

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new UsaManifestListDownloadDBDAOmodifyMIBListUSQL(), param,
					velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		}
		catch (DAOException de)
		{
			log.error(de.getMessage(), de);
			throw de;
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * 0408화면에서 BL의 usa_lst_loc_cd 를 갱신하기 위해 작성.<br>
	 * 
	 * @param UsaInbondManifestDetailListVO usaInbondManifestDetailListVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyMIBAdvList(UsaInbondManifestDetailListVO usaInbondManifestDetailListVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try
		{
			Map<String, String> mapVO = usaInbondManifestDetailListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			param.put("origin_bl_flag", usaInbondManifestDetailListVO.getIbflag());
			velParam.put("origin_bl_flag", usaInbondManifestDetailListVO.getIbflag());

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new UsaManifestListDownloadDBDAOmodifyMIBAdvListUSQL(), param,
					velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		}
		catch (DAOException de)
		{
			log.error(de.getMessage(), de);
			throw de;
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * 0408화면에서 IBD의 PMIB 를 갱신하기 위해 작성.<br>
	 * 
	 * @param InBondNumberVO inBondNumberVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyMibNumberByBl(InBondNumberVO inBondNumberVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try
		{
			Map<String, String> mapVO = inBondNumberVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new UsaManifestListDownloadDBDAOmodifyMibNumberByBlUSQL(),
					param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		}
		catch (DAOException de)
		{
			log.error(de.getMessage(), de);
			throw de;
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * BKG_CSTMS_ADV_BL에 MI, AI 전송일자를 갱신한다.<br>
	 * 
	 * @param String blNo
	 * @param String command
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyTransStage(String blNo, String command) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{

			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);
			param.put("command", command);
			velParam.put("command", command);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new UsaManifestListDownloadDBDAOmodifyTransStageUSQL(),
					param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * BKG_CSTMS_ADV_BL에 MI, AI 전송일자를 갱신한다.<br>
	 * 
	 * @param String blNo
	 * @param String cstmsMfTpCd
	 * @param String cstmsTrsmStsCd
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyTransStage(String blNo, String cstmsMfTpCd, String cstmsTrsmStsCd) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try
		{
			param.put("bl_no", blNo);
			param.put("cstms_mf_tp_cd", cstmsMfTpCd);
			param.put("cstms_trsm_sts_cd", cstmsTrsmStsCd);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new UsaManifestListDownloadDBDAOmodifyTransStage2USQL(),
					param, null);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * TI전송 기록을 BKG_CSTMS_ADV_IBD에 갱신한다.<br>
	 * 
	 * @param String blNo
	 * @param String usrId
	 * @param String ofcCd
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyTiInfo(String blNo, String usrId, String ofcCd) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{

			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);
			param.put("usr_id", usrId);
			velParam.put("usr_id", usrId);
			param.put("ofc_cd", ofcCd);
			velParam.put("ofc_cd", ofcCd);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new UsaManifestListDownloadDBDAOmodifyTiInfoUSQL(), param,
					velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

			return result;
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * modifyInbondArrFlagByBl 정보를 생성한다.<br>
	 * backEndJob으로 구동하므로, 책임테이블 예외로 한다.<br>
	 * 
	 * @param String blNo
	 * @param String transGubun
	 * @exception DAOException
	 */
	public void modifyInbondArrFlagByBl(String blNo, String transGubun) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{

			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);
			param.put("trans_gubun", transGubun);
			velParam.put("trans_gubun", transGubun);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOmodifyInbondArrFlagByBlUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		}
		catch (DAOException de)
		{
			log.error(de.getMessage(), de);
			throw de;
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * updateCntrArrExpByBlCntr 컨테이너별로 Arr, Exp 정보를 갱신한다.<br>
	 * 
	 * @param String blNo
	 * @param String cntrNo
	 * @param String transGubun
	 * @exception DAOException
	 */
	public void updateCntrArrExpByBlCntr(String blNo, String cntrNo, String transGubun) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{

			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);
			param.put("cntr_no", cntrNo);
			velParam.put("cntr_no", cntrNo);
			param.put("trans_gubun", transGubun);
			velParam.put("trans_gubun", transGubun);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOupdateCntrArrExpByBlCntrUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		}
		catch (DAOException de)
		{
			log.error(de.getMessage(), de);
			throw de;
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 미세관 응답메세지 수신 Cancus_cntr 결과를 추가한다.<br>
	 * 
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 * @throws DAOException
	 */
	public int addCNRUInfoAtCanada(UsaRcvMsgVO usaRcvMsgVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new UsaManifestListDownloadDBDAOaddCNRUInfoAtCanadaCSQL(),
					param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to UPDATE SQL");
			return result;
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 미세관 응답메세지 수신 Cancus_cntr 결과를 갱신한다.<br>
	 * 
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 * @throws DAOException
	 */
	public int modifyCNRUInfoAtCanada(UsaRcvMsgVO usaRcvMsgVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOmodifyCNRUInfoAtCanadaUSQL(), param, velParam);
			return result;
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 미세관 응답메세지 수신 NVOCC 중 BKG_CSTMS_ADV_IBD 를 갱신한다.<br>
	 * 
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 * @throws DAOException
	 */
	public int modifyExpAccpDtAtBl(UsaRcvMsgVO usaRcvMsgVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new UsaManifestListDownloadDBDAOmodifyExpAccpDtAtBlUSQL(),
					param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to UPDATE SQL");
			return result;
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 미세관 응답메세지 수신 NVOCC 중 BKG_CSTMS_ADV_CNTR 를 갱신한다.<br>
	 * 
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 * @throws DAOException
	 */
	public int modifyExpAccpDtAtCntr(UsaRcvMsgVO usaRcvMsgVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOmodifyExpAccpDtAtCntrUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to UPDATE SQL");
			return result;
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 미세관 응답메세지 수신 Nak 결과를 IBD 테이블에 갱신한다.<br>
	 * 
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 * @throws DAOException
	 */
	public int modifyResultCdByBl(UsaRcvMsgVO usaRcvMsgVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new UsaManifestListDownloadDBDAOmodifyResultCdByBlUSQL(),
					param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to UPDATE SQL");
			return result;
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 미세관 응답메세지 수신 결과를 IBD 테이블에 갱신한다.(CSTMS_CLR_CNG_FLG)<br>
	 * 
	 * @param bkgCstmsAdvIbdVOs List<BkgCstmsAdvIbdVO>
	 * @throws DAOException
	 */
	public void modifyIbdCstmsClrCngFlg(List<BkgCstmsAdvIbdVO> bkgCstmsAdvIbdVOs) throws DAOException {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgCstmsAdvIbdVOs.size() > 0)
			{
				updCnt = sqlExe.executeBatch(
						(ISQLTemplate) new UsaManifestListDownloadDBDAOmodifyIbdCstmsClrCngFlgUSQL(),
						bkgCstmsAdvIbdVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Update No" + i + " SQL");
				}
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
	}

	/**
	 * Actual Vvd 조회
	 * 
	 * @param usaVesselCondVO usaVesselCondVO
	 * @return List<VesselVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<VesselVO>  searchActVvd(UsaVesselCondVO usaVesselCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VesselVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (usaVesselCondVO != null)
			{
				Map<String, String> mapVO = usaVesselCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchActVvdRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaVesselVO.class);
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * bl_no로 house bl_no 리스트를 구한다.
	 * 
	 * @param String cntCd
	 * @param String masterBlNo
	 * @return List<String>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<String>  searchBlListbyMasterBl(String cntCd, String masterBlNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<String> list = new ArrayList();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (masterBlNo != null) {
				
				param.put("cnt_cd", cntCd);
				velParam.put("cnt_cd", cntCd);
				param.put("bl_no", masterBlNo);
				velParam.put("bl_no", masterBlNo);
				
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchBlListbyMasterBlRSQL(), param, velParam);
			
			while (dbRowset.next()) {
				list.add(dbRowset.getString(1));
			}
			
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
	 * 기 등록된 HUB_LOC_CD 정보를 조회해 온다.<br>
	 * 
	 * @param UsaManifestListCondVO condVO
	 * @return String
	 * @exception DAOException
	 */
	public UsaBlInfoVO searchClrHubLocCd(UsaManifestListCondVO condVO) throws DAOException {
		DBRowSet dbRowset = null;
		UsaBlInfoVO usaBlInfoVO = new UsaBlInfoVO();
		  String[] clr = new String[4];
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
       try
		{
			Map<String, String> mapVO = condVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("cnt_cd", CountryCode.US);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchClrHubLocCdRSQL(), param, velParam);
			if (dbRowset.next())
			{  
				 clr[0] = JSPUtil.getNull(dbRowset.getString(1),"");
				 clr[1] = JSPUtil.getNull(dbRowset.getString(2),"");
				 clr[2] = JSPUtil.getNull(dbRowset.getString(3),"");
				 clr[3] = JSPUtil.getNull(dbRowset.getString(4),"");
				
				usaBlInfoVO.setResultStrArray(clr);
			}
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return usaBlInfoVO;
	}
	
	/**
	 * 기 등록된 Entry Type Setup 정보를 조회해 온다.<br>
	 * 
	 * @param ClearanceTypeCondVO clrCondVO
	 * @return ClearanceTypeDetailVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ClearanceTypeDetailVO searchClrTpSetup(ClearanceTypeCondVO clrCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		ClearanceTypeDetailVO clearanceTypeDetailVO = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = clrCondVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchClrTpSetupRSQL(), param, velParam);
			List<ClearanceTypeDetailVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, ClearanceTypeDetailVO.class);

			if (list.size() > 0)
			{
				clearanceTypeDetailVO = (ClearanceTypeDetailVO) list.get(0);
			}
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return clearanceTypeDetailVO;
	}
	
	/**
	 * 대상 Container 상세 조회(CNTR_MF_WGT 추가)<br>
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return List<UsaManifestListDownloadCntrVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UsaBkgCmVO> searchDownloadCntrMFList(ManifestListCondVO manifestListCondVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<UsaBkgCmVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		ManifestListCondVO condVO = null;

		try
		{
			if (manifestListCondVO != null)
			{

				condVO = (ManifestListCondVO) manifestListCondVO;
				Map<String, String> mapVO = condVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

			}

			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchDownloadCntrMFListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsaBkgCmVO.class);

		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
   	/**
	 * SNP/Broker Nomination 조회 한다.<br>
	 * 
	 * @param OrgPartyVO orgPartyVO
	 * @return List<OrgPartyVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OrgPartyVO> searchOrgPartyList(OrgPartyVO orgPartyVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OrgPartyVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (orgPartyVO != null)
			{
				Map<String, String> mapVO = orgPartyVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new UsaManifestListDownloadDBDAOsearchOrgPartyListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, OrgPartyVO.class);
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * SNP/Broker Nomination 정보를 생성한다.<br>
	 * 
	 * @param OrgPartyVO orgPartyVO
	 * @exception DAOException
	 */

public void addOrgPartyList(OrgPartyVO orgPartyVO) throws DAOException {
	//	int addCnt[] = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = orgPartyVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new UsaManifestListDownloadDBDAOaddOrgPartyListCSQL(),
					param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");			
		}	
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * SNP/Broker Nomination 정보를 수정한다.<br>
	 * 
	 * @param OrgPartyVO orgPartyVO
	 * @exception DAOException
	 */
	public void modifyOrgPartyList(OrgPartyVO orgPartyVO) throws DAOException {

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try
		{
			Map<String, String> mapVO = orgPartyVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new UsaManifestListDownloadDBDAOmodifyOrgPartyListUSQL(), param,
					velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		}
		catch (DAOException de)
		{
			log.error(de.getMessage(), de);
			throw de;
		}		
			catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 미세관 응답메세지 수신 결과를 BL 테이블에 갱신한다.<br>
	 * - CUSTMS_LOC_CD
	 * 
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 * @throws DAOException
	 */
	public int modifyAdvancedBl(UsaRcvMsgVO usaRcvMsgVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = usaRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new UsaManifestListDownloadDBDAOmodifyAdvancedBlUSQL(),
					param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to UPDATE SQL");
			return result;
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	

	/**
	 * Customer Status Notice 정보 조회한다.<br>
	 * 
	 * @param hndlOfcCd
	 * @return UsCustomsStatusNoticeVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public UsCustomsStatusNoticeVO searchUsCustomsStatusNoticeInfo(String hndlOfcCd) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<UsCustomsStatusNoticeVO> list = null;
		UsCustomsStatusNoticeVO usCustomsVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			param.put("hndl_ofc_cd", hndlOfcCd); 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UsaManifestListDownloadDBDAOsearchUsCustomsStatusNoticeInfoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, UsCustomsStatusNoticeVO.class);
			if(list != null && list.size() > 0){
				usCustomsVO = list.get(0);
			}			
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return usCustomsVO;
	}
		
	
	/**
     * Customer Status Notice 정보 등록,수정<br>
	 * 
	 * @param usCustomsVO
	 * @return int
	 * @throws DAOException
	 */
	public int manageUsCustomsStatusNoticeInfo ( UsCustomsStatusNoticeVO usCustomsVO ) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = usCustomsVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new UsaManifestListDownloadDBDAOMergeUsCustomsStatusNoticeInfoCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to UPDATE SQL");
			return result;
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	
}
