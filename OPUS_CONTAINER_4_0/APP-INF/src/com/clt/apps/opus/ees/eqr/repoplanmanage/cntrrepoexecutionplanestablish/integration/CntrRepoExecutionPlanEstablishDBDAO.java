/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoExecutionPlanEstablishDBDAO.java
*@FileTitle : Execution Plan
*Open Issues :
*Change history :
* No.	Ver.		Modifier           					modifier date    explanation
* 1      	1.0      	이행지								2009.08.13		1.0 최초 생성
* 2		1.1		Lee Byoung Hun				2010.05.11		CSR No : CHM-201003779 - EES_EQR_0143(EQR All-Weeks' Plan Access Grant) 이벤트 처리 추가
*
*@LastModifyDate : 2009.08.13
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.08.13 이행지
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.eqr.common.Constants;
import com.clt.apps.opus.ees.eqr.common.Utils;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.event.EesCommonEvent;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.integration.CommonDBDAOSearchLocYardInfoRSQL;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.integration.CommonDBDAOSearchSubContinentRSQL;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.CommonVO;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.EqrCommonVO;
import com.clt.apps.opus.ees.eqr.common.vo.CommonRsVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.basic.CntrRepoExecutionPlanEstablishBCImpl;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.CheckBkgVolumeTargetVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0059ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0059MultiVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0080MultiVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0094ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0112ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0113ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0130ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0143MultiVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.ModifyFromTrsOffHireReturnVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.MtyBkgCntrVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.MtyBkgVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchBeforeCntrInfoVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchCheckCntrInfoVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchCntrRepoExecutionPlanEstablishVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchEqrAllWeeksPlanAccessGrantVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchEqrOnfHirExePlnByOffHireReturnVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchEqrOrganizationVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchExecutionPlanBkgNoVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchExecutionPlanCntrInfoExcelVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchExecutionPlanCntrInfoVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchExecutionPlanCntrListVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchExecutionPlanSplitCntrVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchInlandRouteVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchSendHistoryVO;
import com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.integration.CodSimulateDBDAODeleteEqrPlnCodQtyDSQL;
import com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.integration.CodSimulateDBDAODeleteRepoPlanIdDSQL;
import com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.integration.CodSimulateDBDAODuplicateCreateRepoPlanCheckRSQL;
import com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.integration.CodSimulateDBDAODuplicateCreateRepoPlanViewCheckRSQL;
import com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.EqrEccInterExePlnQtyVO;
import com.clt.syscommon.common.table.EqrEccInterExePlnVO;
import com.clt.syscommon.common.table.EqrExePlnCntrVO;
import com.clt.syscommon.common.table.EqrInlndTrspExePlnQtyVO;
import com.clt.syscommon.common.table.EqrInlndTrspExePlnVO;
import com.clt.syscommon.common.table.EqrInlndTrspPlnQtyVO;
import com.clt.syscommon.common.table.EqrInlndTrspPlnVO;
import com.clt.syscommon.common.table.EqrOnfHirExePlnQtyVO;
import com.clt.syscommon.common.table.EqrOnfHirExePlnVO;
import com.clt.syscommon.common.table.EqrOnfHirPlnQtyVO;
import com.clt.syscommon.common.table.EqrOnfHirPlnVO;
import com.clt.syscommon.common.table.EqrRepoExeSoIfVO;
import com.clt.syscommon.common.table.EqrVslExePlnQtyVO;
import com.clt.syscommon.common.table.EqrVslLodgDchgExePlnVO;
import com.clt.syscommon.common.table.EqrVslLodgDchgPlnQtyVO;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/** 
 *  CntrRepoExecutionPlanEstablishDBDAO <br>
 * - -RepoPlanManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Haeng-ji,Lee
 * @see CntrRepoExecutionPlanEstablishBCImpl 참조
 * @since J2EE 1.6
 */
public class CntrRepoExecutionPlanEstablishDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * [ EES_EQR_0059 ]<br>
	 * 
	 * @param EesEqr0059ConditionVO eesEqr0059ConditionVO
	 * @param account SignOnUserAccount
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CommonRsVO searchTrunkVesselAndFeederCntrRepoPlan(EesEqr0059ConditionVO eesEqr0059ConditionVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<CommonVO> tpszArr = new ArrayList<CommonVO>(); 
		
		
		try{
			if(eesEqr0059ConditionVO != null){
				Map<String, String> mapVO = eesEqr0059ConditionVO .getColumnValues();
				
				String offCd = account.getOfc_cd();
				
				String tpsztype = eesEqr0059ConditionVO.getTpsztype();
				String tpszText = Utils.convertStr(tpsztype);
				String laneText = Utils.convertStr(eesEqr0059ConditionVO.getLane());
				String vvdText	= Utils.convertStr(eesEqr0059ConditionVO.getVvd());
				String itemText	= Utils.convertStr(eesEqr0059ConditionVO.getItemname());
				String reasonText	= Utils.convertStr(eesEqr0059ConditionVO.getReason());
				ArrayList arrtpsz = (ArrayList) Utils.replaceStrToList(tpsztype);
				ArrayList arrtpsz2= (ArrayList) Utils.convertTpsz(tpsztype);
				String fm_plnyrwk = eesEqr0059ConditionVO.getFmplnyr() + eesEqr0059ConditionVO.getFmplnwk();
				String to_plnyrwk = eesEqr0059ConditionVO.getToplnyr() + eesEqr0059ConditionVO.getToplnwk();
				
				String userEccText	= Utils.convertStr(eesEqr0059ConditionVO.getUserEcc(), true);
				String fromEccText	= Utils.convertStr(eesEqr0059ConditionVO.getFromEcc(), true);
				String toEccText	= Utils.convertStr(eesEqr0059ConditionVO.getToEcc(), true);
				
				String userEcc		= eesEqr0059ConditionVO.getUserEcc();
				String fromEcc		= eesEqr0059ConditionVO.getFromEcc();
				String toEcc		= eesEqr0059ConditionVO.getToEcc();
				String fromLoc		= eesEqr0059ConditionVO.getFromlocation();
				String toLoc		= eesEqr0059ConditionVO.getTolocation();
				
				for(int i = 0 ; i < arrtpsz.size() ; i++){
					CommonVO commonVO = new CommonVO();
					commonVO.setField1((String) arrtpsz.get(i));
					commonVO.setField2((String) arrtpsz2.get(i));
					tpszArr.add(commonVO);
				}
				param.putAll(mapVO);
				param.put("fm_plnyrwk", fm_plnyrwk);
				param.put("to_plnyrwk", to_plnyrwk);
				param.put("from_loc", fromLoc);
				param.put("to_loc", toLoc);
				param.put("off_cd", offCd);
				
				velParam.putAll(mapVO);
				velParam.put("arrtpsz", arrtpsz);
				velParam.put("tpszText", tpszText);
				velParam.put("laneText", laneText);
				velParam.put("vvdText", vvdText);
				velParam.put("itemText", itemText);
				velParam.put("reasonText", reasonText);
				velParam.put("tpszArr", tpszArr);
				velParam.put("userEccText", userEccText);
				velParam.put("fromEccText", fromEccText);
				velParam.put("toEccText", toEccText);
				velParam.put("userEcc", userEcc);
				velParam.put("fromEcc", fromEcc);
				velParam.put("toEcc", toEcc);
				
				velParam.put("from_loc", fromLoc);
				velParam.put("to_loc", toLoc);
				velParam.put("off_cd", offCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOSearchTrunkVesselAndFeederCntrRepoPlanRSQL(), param, velParam, true);
			commonRsVO.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonRsVO;
	}
	
	/**
	 * [ EES_EQR_0059 ]<br>
	 * 
	 * @param EesEqr0059ConditionVO eesEqr0059ConditionVO
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CommonRsVO searchTrunkVesselAndFeederCntrRepoPlanBKGNOInfo(EesEqr0059ConditionVO eesEqr0059ConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(eesEqr0059ConditionVO != null){
				Map<String, String> mapVO = eesEqr0059ConditionVO .getColumnValues();
				
				String tpsztype = eesEqr0059ConditionVO.getTpsztype();
				ArrayList arrtpsz = (ArrayList) Utils.replaceStrToList(tpsztype);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("arrtpsz", arrtpsz);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOSearchTrunkVesselAndFeederCntrRepoPlanBKGINFORSQL(), param, velParam);
			commonRsVO.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonRsVO;
	}
	
	/**
	 * [ EES_EQR_0059 ]<br>
	 * 
	 * @param EesEqr0059ConditionVO eesEqr0059ConditionVO
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	public CommonRsVO searchTrunkVesselAndFeederCntrRepoPlanBKGNO(EesEqr0059ConditionVO eesEqr0059ConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			if(eesEqr0059ConditionVO != null){
				Map<String, String> mapVO = eesEqr0059ConditionVO .getColumnValues();

				param.putAll(mapVO);

			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOSearchTrunkVesselAndFeederCntrRepoPlanBKGNORSQL(), param, null);
			commonRsVO.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonRsVO;
	}
	
	/**
	 * [ EES_EQR_0059 ]<br>
	 * 
	 * @param rcc_name String
	 * @param action String
	 * @return CommonVO
	 * @exception DAOException
	 */
	public CommonVO searchServerName(String rcc_name, String action) throws DAOException {
		DBRowSet dbRowset = null;
		CommonVO commonVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		String serverName = "";
		
		try{
			if(rcc_name != null && action != null){
				param.put("rcc_name", rcc_name);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOSearchRCCServerNameRSQL(), param, null);
			
			while( dbRowset.next()){
				serverName = dbRowset.getString(1);
			}
			
			if(action != null) {
				if(serverName==null || serverName.equals("")) {
					if(action.equals("REPO"))  // REPO BOOKING
						throw new DAOException(new ErrorHandler("EQR10031", "Target server").getMessage());
					else                       // SO SEND
						throw new DAOException(new ErrorHandler("EQR10030", "Target server").getMessage());
				}
			}
			
			commonVO.setField1(serverName);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonVO;
	}
	
	/**
	 * [ EES_EQR_0059 : EQR_VSL_LODG_DCHG_EXE_PLN 실행테이블 Insert, Update, Delete]<br>
	 * 
	 * @param String ibFlag
	 * @param EqrVslLodgDchgExePlnVO eqrVslLodgDchgExePlnVO
	 * @exception DAOException
	 */
	public void modifyTrunkVesselAndFeederCntrRepoPlan(String ibFlag, EqrVslLodgDchgExePlnVO eqrVslLodgDchgExePlnVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.putAll(eqrVslLodgDchgExePlnVO.getColumnValues());
			velParam.put("repo_mty_bkg_flg", eqrVslLodgDchgExePlnVO.getRepoMtyBkgFlg());
			if ( ibFlag.equals("I") ){
				new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOInsertTrunkVesselAndFeederCntrRepoPlanCSQL(), param, null);
			} else if ( ibFlag.equals("U") ){
				new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOModifyTrunkVesselAndFeederCntrRepoPlanUSQL(), param, velParam);
			} else if ( ibFlag.equals("D") ){
				new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAODeleteTrunkVesselAndFeederCntrRepoPlanDSQL(), param, null);
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
	}
	/**
	 * [ EES_EQR_0059 : EQR_VSL_EXE_PLN_QTY 테이블 Insert, Update, Delete]<br>
	 * 
	 * @param String ibFlag
	 * @param EqrVslExePlnQtyVO eqrVslExePlnQtyVO
	 * @exception DAOException
	 */
	public void modifyTrunkVesselAndFeederCntrRepoPlanQty(String ibFlag, EqrVslExePlnQtyVO eqrVslExePlnQtyVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.putAll(eqrVslExePlnQtyVO.getColumnValues());
			if ( ibFlag.equals("I") ){
				new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOInsertTrunkVesselAndFeederCntrRepoPlanQtyCSQL(), param, null);
			} else if ( ibFlag.equals("U") ){
				new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOModifyTrunkVesselAndFeederCntrRepoPlanQtyUSQL(), param, null);
			} else if ( ibFlag.equals("M") ){
				new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOMergeTrunkVesselAndFeederCntrRepoPlanQtyCSQL(), param, null);
			} else if ( ibFlag.equals("D") ){
				new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAODeleteTrunkVesselAndFeederCntrRepoPlanQtyDSQL(), param, null);
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
	}
	
	/**
	 * [ EES_EQR_0059 ]<br>
	 * 
	 * @param commonVO CommonVO
	 * @return CommonVO
	 * @exception DAOException
	 */
	public CommonVO searchClptIndSEq(CommonVO commonVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		String gubun		= null;
		String vsl_cd		= null;
		String skd_voy_no	= null;
		String skd_dir_cd	= null;
		String vsl_lane_cd	= null;
		String vps_port_cd	= null;
		try{
			if(commonVO != null){
				gubun = commonVO.getGubun();
				
				if ( gubun.equals("V") ){
					EesEqr0059MultiVO eesEqr0059MultiVO = (EesEqr0059MultiVO) commonVO.getConditionVo();
					vsl_cd		= eesEqr0059MultiVO.getVslCd();
					skd_voy_no	= eesEqr0059MultiVO.getSkdVoyNo();
					skd_dir_cd	= eesEqr0059MultiVO.getSkdDirCd();
					vsl_lane_cd	= eesEqr0059MultiVO.getVslLaneCd();
					vps_port_cd	= eesEqr0059MultiVO.getVpsPort();
				} else if ( gubun.equals("W") ){
					EesEqr0080MultiVO eesEqr0080MultiVO = (EesEqr0080MultiVO) commonVO.getConditionVo();
					vsl_cd		= eesEqr0080MultiVO.getVvd().substring(0,4);
					skd_voy_no	= eesEqr0080MultiVO.getVvd().substring(4,8);
					skd_dir_cd	= eesEqr0080MultiVO.getVvd().substring(8,9);
					vsl_lane_cd	= eesEqr0080MultiVO.getVslLaneCd();
					vps_port_cd	= eesEqr0080MultiVO.getVpsPort();
				}
				if(vsl_cd != null) param.put("vsl_cd",		vsl_cd);
				if(skd_voy_no != null) param.put("skd_voy_no",	skd_voy_no);
				if(skd_dir_cd != null) param.put("skd_dir_cd",	skd_dir_cd);
				if(vsl_lane_cd != null) param.put("vsl_lane_cd",vsl_lane_cd);
				if(vps_port_cd != null) param.put("vps_port_cd",vps_port_cd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOSearchClptIndSeqRSQL(), param, null);
			
			if(dbRowset != null && commonVO != null) {
				while ( dbRowset.next() ){
					commonVO.setResultString(dbRowset.getString("CLPT_IND_SEQ"));
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonVO;
	}
	
	/**
	 * [ EES_EQR_0059 ]<br>
	 * 
	 * @param commonVO CommonVO
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	public CommonRsVO searchCntrNoTpSz(CommonVO commonVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		String gubun		= null;
		String repo_pln_id	= null;
		String pln_yrwk		= null;
		String pln_seq		= null;
		String ref_id		= null;
		
		String[] cntr_arr = null;
		List<String[]> cntrType_list = new ArrayList<String[]>();
		
		try{
			if(commonVO != null){
				gubun = commonVO.getGubun();
				
				if ( gubun.equals("V") ){
					EesEqr0059MultiVO eesEqr0059MultiVO = (EesEqr0059MultiVO) commonVO.getConditionVo();
					repo_pln_id	= eesEqr0059MultiVO.getRepoPlnId();
					pln_yrwk	= eesEqr0059MultiVO.getPlnYrwk();
					pln_seq		= eesEqr0059MultiVO.getPlnSeq();
					ref_id		= eesEqr0059MultiVO.getRefId();
				} else if ( gubun.equals("W") ){
					EesEqr0080MultiVO eesEqr0080MultiVO = (EesEqr0080MultiVO) commonVO.getConditionVo();
					repo_pln_id	= eesEqr0080MultiVO.getRepoPlnId();
					pln_yrwk	= eesEqr0080MultiVO.getPlnYrwk();
					pln_seq		= eesEqr0080MultiVO.getPlnSeq();
					ref_id		= eesEqr0080MultiVO.getRefId();
					
				}
				if(repo_pln_id != null) param.put("repo_pln_id",repo_pln_id);
				if(pln_yrwk != null) param.put("pln_yrwk",	pln_yrwk);
				if(pln_seq != null) param.put("pln_seq",	pln_seq);
				if(ref_id != null) param.put("ref_id",		ref_id);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOSearchCntrNoTpSzRSQL(), param, null);
			while(dbRowset.next()) {
				cntr_arr = new String[2];
				cntr_arr[0] = dbRowset.getString("CNTR_NO");
				cntr_arr[1] = dbRowset.getString("CNTR_TPSZ_CD");
				cntrType_list.add(cntr_arr);
			}
			commonRsVO.setResultVOList(cntrType_list);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonRsVO;
	}
	
	/**
	 * [EES_EQR_0059 & EES_EQR_0080 : MTY Booking Creation 후 각 테이블에 Bkg No. 업데이트 해주기. ]<br>
	 * 
	 * @param mtyBkgVO		MtyBkgVO
	 * @param updateVoList	List
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void modifyMtyBkgNo(MtyBkgVO mtyBkgVO, List updateVoList) throws DAOException,Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();
		int insCnt[] = null;
		try {
			velParam.put("table_name", mtyBkgVO.getTableName()[0]);
			velParam.put("gubun", mtyBkgVO.getGubun());
			
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updateVoList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOModifyMtyBkgNoUSQL(), updateVoList, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
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
	}
	
	/**
	 * [EES_EQR_0059 & EES_EQR_0080 : MTY Booking Creation 후 각 테이블에 Bkg No. 업데이트 해주기. ]<br>
	 * 
	 * @param mtyBkgVO		MtyBkgVO
	 * @param updateVoList	List
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void modifyMtyBkgNoForSoIf(MtyBkgVO mtyBkgVO, List updateVoList) throws DAOException,Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();
		int insCnt[] = null;
		try {
			velParam.put("table_name", mtyBkgVO.getTableName()[0]);
			velParam.put("gubun", mtyBkgVO.getGubun());
			
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updateVoList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOModifyMtyBkgNoForSoIfUSQL(), updateVoList, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
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
	}	
	
	/**
	 * [ Bkg No. 로 Vessel, Water인지 구분하기. ]<br>
	 * 
	 * @param mtykgVO MtyBkgVO
	 * @return CommonVO
	 * @exception DAOException
	 */
	public CommonVO checkTarget(MtyBkgVO mtykgVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonVO commonVO =new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("mty_bkg_no", mtykgVO.getMtyBkgNo());
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOCheckTargetRSQL(), param, null);
			commonVO.setDbRowset(dbRowset);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonVO;
	}	
	/**
	 * [ EES_EQR_0059 ]<br>
	 * 
	 * @param mtyBkgVO MtyBkgVO
	 * @param mtyBkgCntrVO MtyBkgCntrVO
	 * @return List<CheckBkgVolumeTargetVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CheckBkgVolumeTargetVO> checkBkgVolumeTarget(MtyBkgVO mtyBkgVO, MtyBkgCntrVO mtyBkgCntrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CheckBkgVolumeTargetVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if ( mtyBkgVO != null ){
				String[] table_name = mtyBkgVO.getTableName();
				velParam.put("table_name", table_name[0]);
				velParam.put("qty_table_name", table_name[1]);
				
				param.put("mty_bkg_no", mtyBkgVO.getMtyBkgNo());
				param.put("cntr_tpsz_cd", mtyBkgCntrVO.getCntrTpszCd());
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOCheckBkgVolumeTargetRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, CheckBkgVolumeTargetVO .class);
			}
			
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
	 * [ EES_EQR_0059 ]<br>
	 * 
	 * @param mtyBkgVO MtyBkgVO
	 * @param mtyBkgCntrVO MtyBkgCntrVO
	 * @return List<CheckBkgVolumeTargetVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CheckBkgVolumeTargetVO> checkBkgVolumeTargetExe(MtyBkgVO mtyBkgVO, MtyBkgCntrVO mtyBkgCntrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CheckBkgVolumeTargetVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if ( mtyBkgVO != null ){
				String[] table_name = mtyBkgVO.getTableName();
				velParam.put("table_name", table_name[0]);
				
				param.put("mty_bkg_no", mtyBkgVO.getMtyBkgNo());
				param.put("cntr_tpsz_cd", mtyBkgCntrVO.getCntrTpszCd());
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOChkBkgVolumeTargetExeRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, CheckBkgVolumeTargetVO .class);
			}
			
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
	 * [BOK/DOC InterFace : MTY Booking Cancel ]<br>
	 * 
	 * @param mtyBkgVO MtyBkgVO 
	 * @exception DAOException
	 */
	public void modifyBkgCancel(MtyBkgVO mtyBkgVO) throws DAOException,Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {			
			SQLExecuter sqlExe = new SQLExecuter("");
			if(mtyBkgVO != null){
				String[] table_name = mtyBkgVO.getTableName();
				param.putAll(mtyBkgVO.getColumnValues());
				velParam.put("table_name", table_name[0]);
				velParam.put("gubun", mtyBkgVO.getGubun());
				
				// EQR_BKG_CXL_HIS 테이블에 BKG Cancel History 입력
				sqlExe.executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOInsertBkgCancelHistoryCSQL(), param, velParam);

				// 실행 테이블의 Vol 수정(old)
				sqlExe.executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOModifyBkgCancelUSQL(), param, velParam);

				// 실행 테이블의 Vol 수정(new) 
				sqlExe.executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOModifyBkgCancelSQL(), param, velParam);
				
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
	}
	/**
	 * [BOK/DOC InterFace : MTY Booking Volume Change시 BKG_QUANTITY와 비교하기. ]<br>
	 *  
	 * @param MtyBkgVO mtyBkgVO 
	 * @return List<MtyBkgCntrVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MtyBkgCntrVO> checkBkgVolumeChange(MtyBkgVO mtyBkgVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MtyBkgCntrVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if(mtyBkgVO != null){
				String[] table_name = mtyBkgVO.getTableName();
				param.put("bkg_no", mtyBkgVO.getMtyBkgNo());
				velParam.put("exeTable", table_name[0]);
				velParam.put("qtyTable", table_name[1]);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOCheckBkgVolumeChangeRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, MtyBkgCntrVO .class);
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
		return list;
	}
	
	/**
	 * [Fixed Plan  Qty]<br>
	 * 
	 * @param eqrVslLodgDchgPlnQtyVO EqrVslLodgDchgPlnQtyVO
	 * @return CommonVO
	 * @exception DAOException
	 */
	public CommonVO searchFixedPlanQty(EqrVslLodgDchgPlnQtyVO eqrVslLodgDchgPlnQtyVO) throws DAOException,Exception {
		CommonVO commonVO = new CommonVO();
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if(eqrVslLodgDchgPlnQtyVO != null){
				param.putAll(eqrVslLodgDchgPlnQtyVO.getColumnValues());
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOSearchFixedPlanQtyRSQL(), param, velParam);
				
				if(dbRowset.getRowCount() == 0) {
					commonVO.setResultString("0");
				}
				while ( dbRowset.next() ){
					commonVO.setResultString(dbRowset.getString("CNTR_QTY"));
				}
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
		return commonVO;
	}
	
	/**
	 * [BOK/DOC InterFace : Original BKG VD Add한 다음 Split 실행시 Original BKG의 Fixed Plan찾기 ]<br>
	 *  
	 * @param EesEqr0059MultiVO eesEqr0059MultiVO
	 * @return List<EqrVslLodgDchgPlnQtyVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EqrVslLodgDchgPlnQtyVO> searchOrgFixedPlan(EesEqr0059MultiVO eesEqr0059MultiVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EqrVslLodgDchgPlnQtyVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if(eesEqr0059MultiVO != null){
				param.put("vsl_cd",		eesEqr0059MultiVO.getVslCd());
				param.put("skd_voy_no",	eesEqr0059MultiVO.getSkdVoyNo());
				param.put("skd_dir_cd",	eesEqr0059MultiVO.getSkdDirCd());
				param.put("fm_ecc",		eesEqr0059MultiVO.getFrlocEcc());
				param.put("to_ecc",		eesEqr0059MultiVO.getTolocEcc());
				param.put("cntr_tpsz_cd",eesEqr0059MultiVO.getCntrTpszCd());
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOSearchOrgFixedPlanRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, EqrVslLodgDchgPlnQtyVO .class);
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
		return list;
	}
	
	/**
	 * [Fixed Plan ]<br>
	 * 
	 * @param eqrVslLodgDchgPlnQtyVO EqrVslLodgDchgPlnQtyVO
	 * @exception DAOException
	 */
	public void modifyFixedPlanVolume(EqrVslLodgDchgPlnQtyVO eqrVslLodgDchgPlnQtyVO) throws DAOException,Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {			
			SQLExecuter sqlExe = new SQLExecuter("");
			if(eqrVslLodgDchgPlnQtyVO != null){
				param.putAll(eqrVslLodgDchgPlnQtyVO.getColumnValues());
				
				sqlExe.executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOMergeFixedPlanVolumeCSQL(), param, velParam);

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
	}
	/**
	 * [BKG/DOC InterFace : 변경된 수량 실행테이블에 적용하기. ]<br>
	 * 
	 * @param eqrVslExePlnQtyVOs List<EqrVslExePlnQtyVO>
	 * @exception DAOException
	 */
	public void modifyTrunkVesselAndFeederBkgVolDiff(List<EqrVslExePlnQtyVO> eqrVslExePlnQtyVOs) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			if(eqrVslExePlnQtyVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOMergeVesselBkgVolCSQL(), eqrVslExePlnQtyVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
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
	}
	/**
	 * [BKG/DOC InterFace : 변경된 수량 실행테이블에 적용하기. ]<br>
	 * 
	 * @param eqrInlndTrspExePlnQtyVOs List<EqrInlndTrspExePlnQtyVO>
	 * @exception DAOException
	 */
	public void modifyTruckAndRailAndBargeBkgVolDiff(List<EqrInlndTrspExePlnQtyVO> eqrInlndTrspExePlnQtyVOs) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			if(eqrInlndTrspExePlnQtyVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOMergeInlandBkgVolCSQL(), eqrInlndTrspExePlnQtyVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
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
	}
	/**
	 * CntrRepoExecutionPlanEstablish의 모든 목록을 가져온다.<br>
	 * 
	 * @param condiVO EesEqr0113ConditionVO
	 * @return List<SearchCntrRepoExecutionPlanEstablishVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchCntrRepoExecutionPlanEstablishVO> searchCntrRepoExecutionPlanEstablish(EesEqr0113ConditionVO condiVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchCntrRepoExecutionPlanEstablishVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List arrLocation = Utils.replaceStrToList(condiVO.getLocList());//locList.split(",");
		List arrLane = Utils.replaceStrToList(condiVO.getLane());//lane.split(",");
		List arrVvd = Utils.replaceStrToList(condiVO.getVvd());//vvd.split(",");
		String scnrId   = Constants.SCNR_WORD + condiVO.getYyyyww() + Constants.SCNR_WEEK + condiVO.getSeq();
		String frWeek   = condiVO.getFrdtYY() + condiVO.getFrdtMM();
		String toWeek   = condiVO.getTodtYY() + condiVO.getTodtMM();
		
		try {
			param.put("scnrId",scnrId);
			param.put("frWeek",frWeek);
			param.put("toWeek",toWeek);
			velParam.putAll(condiVO.getColumnValues());
			velParam.put("arrLocation", arrLocation);
			velParam.put("arrLane", arrLane);
			velParam.put("arrVvd", arrVvd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOSearchCntrRepoExecutionPlanEstablishRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCntrRepoExecutionPlanEstablishVO .class);
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
		return list;
	}

	/**
	 * CntrRepoExecutionPlanEstablish의 모든 목록을 가져온다.<br>
	 * 
	 * @param condiVO EesEqr0094ConditionVO
	 * @return List<SearchExecutionPlanCntrListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchExecutionPlanCntrListVO> searchCntrRepoExecutionPlanCntrList(EesEqr0094ConditionVO condiVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchExecutionPlanCntrListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		List<String> arrLabelValueList = null;
		
		String arrStrLocation 	= Utils.convertStr(condiVO.getLoclist());
		String arrStrTpsz		= Utils.convertStr(condiVO.getTpszs());
		String arrStrLease		= Utils.convertStr(condiVO.getLease());
		String arrStrMove		= Utils.convertStr(condiVO.getMove());

		String arrStrYard		= Utils.convertStr(condiVO.getYard());
		String arrStrAgmtNo		= Utils.convertStr(condiVO.getAgmtNo());
		
		try {
			param.putAll(condiVO.getColumnValues());
			velParam.putAll(condiVO.getColumnValues());
			velParam.put("arrStrLocation", arrStrLocation);
			velParam.put("arrStrTpsz", arrStrTpsz);
			velParam.put("arrStrLease", arrStrLease);
			velParam.put("arrStrMove", arrStrMove);
			velParam.put("arrStrYard", arrStrYard);
			velParam.put("arrStrAgmtNo", arrStrAgmtNo);
			
			if ( !JSPUtil.getNull(condiVO.getRstr_usg_lbl()).equals("") ) {
				arrLabelValueList = JSPUtil.convertStringToArrayList(JSPUtil.replace(condiVO.getRstr_usg_lbl(),",","|"));
	        	param.put("labelvalue_list", arrLabelValueList);
	        	velParam.put("labelvalue_list", arrLabelValueList);        	
	        } 
			
			
			if("ALL".equals(condiVO.getRu_lable_type())) {
				param.put("ru_lable_type", "");
				velParam.put("ru_lable_type", "");
			}
			
			
			if("ALL".equals(condiVO.getRstr_usg_lbl())) {
				param.put("rstr_usg_lbl", "");
				velParam.put("rstr_usg_lbl", "");
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOSearchExecutionPlanCntrListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchExecutionPlanCntrListVO .class);
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
		return list;
    	
	}

	/**
	 * EES_EQR_094Event CNTR_NO 의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param condiVO EesEqr0094ConditionVO
	 * @return List<SearchExecutionPlanCntrInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchExecutionPlanCntrInfoVO> searchCntrRepoExecutionPlanCntrInfo(EesEqr0094ConditionVO condiVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<SearchExecutionPlanCntrInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String arrStrCntrNo = Utils.convertStr(condiVO.getCntrNo());
	    			
		try {
			param.putAll(condiVO.getColumnValues());
			velParam.putAll(condiVO.getColumnValues());
			velParam.put("arrStrCntrNo", arrStrCntrNo);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOSearchExecutionPlanCntrInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchExecutionPlanCntrInfoVO .class);
			
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
		return list;
	}

	/**
	 * EES_EQR_094Event CNTR_NO 의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * Excel
	 * @param condiVO EesEqr0094ConditionVO
	 * @return List<SearchExecutionPlanCntrInfoExcelVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchExecutionPlanCntrInfoExcelVO> searchCntrRepoExecutionPlanCntrInfoExcel(EesEqr0094ConditionVO condiVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<SearchExecutionPlanCntrInfoExcelVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		/*
		 * EXCEL LOAD INFO SQL 튜닝 - 신용찬  - 201014 
		 * 'ABC','CDE' ==> LIST에 배열로 담음
		 */
		//String arrStrCntrNo = Utils.convertStr(condiVO.getCntrNo(),true , 10);
		List cntrNoArr	= Utils.replaceStrToList(condiVO.getCntrNo()); 
		
		try {
			
			param.putAll(condiVO.getColumnValues());
			velParam.putAll(condiVO.getColumnValues());
			//velParam.put("arrStrCntrNo", arrStrCntrNo);
			velParam.put("cntrNoArr", cntrNoArr);			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOSearchExecutionPlanCntrInfoExcelRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchExecutionPlanCntrInfoExcelVO .class);

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
		return list;
	}

	/**
	 * EES_EQR_094Event CNTR_NO 중복체크..<br>
	 * 
	 * @param condiVO EesEqr0094ConditionVO
	 * @return List<SearchCheckCntrInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchCheckCntrInfoVO> searchCheckCntrInfo(EesEqr0094ConditionVO condiVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<SearchCheckCntrInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String arrStrCntrNo = Utils.convertStr(condiVO.getCntrNo());
	    			
		try {
			param.put("repoplan_id" ,condiVO.getRepoplanId());
			velParam.put("cntr_no",condiVO.getCntrNo());
			velParam.put("arrStrCntrNo", arrStrCntrNo);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOSearchCheckCntrInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCheckCntrInfoVO .class);
			
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
		return list;
	}

	/**
	 * EES_EQR_094Event CNTR_NO 의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param condiVO EesEqr0094ConditionVO
	 * @return List<SearchBeforeCntrInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchBeforeCntrInfoVO> searchBeforeCntrInfo(EesEqr0094ConditionVO condiVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<SearchBeforeCntrInfoVO> list = null;
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String arrStrCntrNo = Utils.convertStr(condiVO.getCntrNo());
		
	    			
		try {
			velParam.put("trans_mode", condiVO.getTrspMode());
			velParam.put("cntr_no",condiVO.getCntrNo());
			velParam.put("arrStrCntrNo", arrStrCntrNo);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOSearchBeforeCntrInfoRSQL(), null, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchBeforeCntrInfoVO .class);
			
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
		return list;
	}
	

	/**
     * 컨테이너 이송 실행 계획 조회/수정 Truck And Rail And Barge (EES_EQR_080) 정보 조회
     * CSR No : R200901200004( Tuning 결과를 바탕으로 Query 재작업 ), modified by Haeng-Ji Lee 2009.01.21
	 * 기존 Query는 searchTruckAndRailAndBargeCntrRepoPlan_Old로 Rename후 주석처리.
	 * 
	 * @param condiVO EesEqr0059ConditionVO
	 * @param account SignOnUserAccount
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CommonRsVO searchTruckAndRailAndBargeCntrRepoPlan(EesEqr0059ConditionVO condiVO, SignOnUserAccount account) throws DAOException {
		
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String offCd = account.getOfc_cd();
		
		String fromECC		= condiVO.getFromEcc();
		String toECC		= condiVO.getToEcc();
		String userECC		= condiVO.getUserEcc();
		
		String repoPlanID = condiVO.getRepoPlnId();//.getRepoPlanId();
		String fromWeek   = condiVO.getFmplnyr()+condiVO.getFmplnwk();
		String toWeek     = condiVO.getToplnyr()+condiVO.getToplnwk();
		
    	String tpsz     = condiVO.getTpsz();      // TYPE SIZE 종류(ALL, DRY, RFR...)
 		String tpsztype = condiVO.getTpsztype();  // TYPE SIZE 선택값
 		List tpszArr	= Utils.replaceStrToList(tpsztype); 
 		
 		String fmtoat      = condiVO.getFmtoat();
 		String fromStatus  = condiVO.getFromstatus();
 		String toStatus    = condiVO.getTostatus();
 		String atStatus    = condiVO.getAtstatus();
 		
 		String reason   = condiVO.getReason();
 		String itemname = condiVO.getItemname();
 		String sosend   = condiVO.getSosend();
 		String mty      = condiVO.getMty();
 		
 		String lane     = condiVO.getLane();
 		String vvd      = condiVO.getVvd();
 		String fromLoc		= condiVO.getFromlocation();
		String toLoc		= condiVO.getTolocation();
 		
 		String userECCStrArr 	= "";
 		String fromECCStrArr 	= "";
 		String toECCStrArr 		= "";
 		String tpszStrArr		= "";
 		String reasonStrArr		= "";
 		String itemnameStrArr	= "";
 		String laneStrArr		= "";
 		String vvdStrArr		= "";

    	// user location 검색조건
    	if(!userECC.equals("")) {
    		userECCStrArr = Utils.convertStr(userECC , true);
    	}
    	
    	// from location 검색조건 ('','',''.....)
    	// CSR No:N200906040080 의거 Fm ETD, To ETA 조건 추가
    	// 추가 내역 : fmtoat = 3 이면 Fm ETD , 
    	//           fmtoat = 4 이면  To ETA 
    	// if((fmtoat.equals("1") || fmtoat.equals("2") ) && (!fromStatus.equals("") || !atStatus.equals(""))) { --원본 
    	if((fmtoat.equals("1") || fmtoat.equals("2") || fmtoat.equals("3") || fmtoat.equals("4") ) && (!fromStatus.equals("") || !atStatus.equals(""))) {
    		fromECCStrArr = Utils.convertStr(fromECC,true);
    	}
    	
    	// to location 검색조건 ('','',''.....)
        // CSR No:N200906040080 의거 Fm ETD, To ETA 조건 추가
    	// 추가 내역 : fmtoat = 3 이면 Fm ETD , 
    	//           fmtoat = 4 이면  To ETA 
    	//if(fmtoat.equals("1") && !toStatus.equals("")) { --원본 
    	if((fmtoat.equals("1") || fmtoat.equals("3") || fmtoat.equals("4") ) && !toStatus.equals("")) {	
    		toECCStrArr = Utils.convertStr(toECC,true);
    	}    	
    	
        // TP/SZ 에 따른 조건값을 넣어 준다.
        if(!tpsz.equals("") && !tpsztype.equals("")) {
        	tpszStrArr = Utils.convertStr(tpsztype);
    	}    	

        // REASON 에 따른 조건값을 넣어 준다.
        if(!reason.equals("")) {
        	reasonStrArr = Utils.convertStr(reason);
    	}    	

        // REASON 에 따른 조건값을 넣어 준다.
        if(!itemname.equals("")) {
        	itemnameStrArr = Utils.convertStr(itemname);
    	}    

        // LANE 에 따른 조건값을 넣어 준다.
        if(!lane.equals("")) {
        	laneStrArr = Utils.convertStr(lane);
    	}         
        
        // VVD 에 따른 조건값을 넣어 준다.
        if(!vvd.equals("")) {
        	vvdStrArr = Utils.convertStr(vvd);
    	}         
		
        try {
			
			param.put("sosend", sosend);
			param.put("mty", mty);
			param.put("repoPlanID", repoPlanID);
			param.put("fromWeek", fromWeek);
			param.put("toWeek", toWeek);
			param.put("from_loc", fromLoc);
			param.put("to_loc", toLoc);
			param.put("off_cd", offCd);
			
			velParam.put("tpsz", tpsz);
			velParam.put("tpsztype", tpsztype);
			velParam.put("tpszArr", tpszArr);
			velParam.put("tranTpsz", "");
			velParam.put("reason", reason);
			velParam.put("sosend", sosend);
			velParam.put("mty", mty);
			velParam.put("lane", lane);
			velParam.put("vvd", vvd);
			velParam.put("fmtoat", fmtoat);
			velParam.put("fromStatus", fromStatus);
			velParam.put("toStatus", toStatus);
			velParam.put("atStatus", atStatus);
			velParam.put("fromECC", fromECC);
			velParam.put("toECC", toECC);
			velParam.put("userECC", userECC);
			velParam.put("repoPlanID", repoPlanID);
			velParam.put("fromWeek", fromWeek);
			velParam.put("toWeek", toWeek);
			velParam.put("userECCStrArr",userECCStrArr);
			velParam.put("fromECCStrArr",fromECCStrArr);
			velParam.put("toECCStrArr",toECCStrArr);
			velParam.put("tpszStrArr",tpszStrArr);
			velParam.put("reasonStrArr",reasonStrArr);
			velParam.put("itemname",itemname);
			velParam.put("itemnameStrArr",itemnameStrArr);
			velParam.put("laneStrArr",laneStrArr);
			velParam.put("vvdStrArr",vvdStrArr);
			velParam.put("from_loc", fromLoc);
			velParam.put("to_loc", toLoc);
			velParam.put("off_cd", offCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOSearchInlandCntrRepoPlanRSQL(), param, velParam,true);
			commonRsVO.setDbRowset(dbRowset);

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
		
		return commonRsVO;
	}

	/**
     * 수정시 insert를 해야 할 값과 update 할 값이 공존하여  체크하여  insert, update를 수행한다. 
     * 결과값이 true 이면 insert를 하고 false 이면 update를 수행을 한다.
     * 
     * @param checkEqrInlndTrspPlnVO EqrInlndTrspPlnVO
     * @return boolean
     * @exception DAOException
     */
    public boolean inlandInsertCheck(EqrInlndTrspPlnVO  checkEqrInlndTrspPlnVO) throws DAOException {
    	DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
	    boolean key = true;
	                    
	    try {
	    	param.putAll(checkEqrInlndTrspPlnVO.getColumnValues());
	    	param.put("past_repo_pln_flg", "N");
	        
	    	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOSearchInlandInsertCheckRSQL(), param, null);
	        if(dbRowset.next()){
	        	int k = dbRowset.getInt("COUN");
	        	if(k == 0) {
	        		key = false;
	        	}
	        }
	
	    }catch (SQLException se) {
	        log.error(se.getMessage(), se);
	        throw new DAOException(new ErrorHandler(se).getMessage());
	    }catch (DAOException de) {
	        log.error(de.getMessage(), de);
	        throw de;
	    }catch (Exception e) {
	        log.error(e.getMessage(), e);
	        throw new DAOException(e.getMessage());
	    }
	    return key;
	}


	/**
     * 수정시 insert를 해야 할 값과 update 할 값이 공존하여  체크하여  insert, update를 수행한다. 
     * 결과값이 true 이면 insert를 하고 false 이면 update를 수행을 한다.
     * 
     * @param checkEqrInlndTrspPlnVO EqrInlndTrspPlnVO
     * @return boolean
     * @exception DAOException
     */
    public String searchPlnSeqinlandInsertCheck(EqrInlndTrspPlnVO  checkEqrInlndTrspPlnVO) throws DAOException {
    	DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
	    String plnSeq = "0";
	                    
	    try {
	    	param.putAll(checkEqrInlndTrspPlnVO.getColumnValues());
	    	param.put("past_repo_pln_flg", "N");
	        
	    	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOSearchPlnSeqinlandInsertCheckRSQL(), param, null);
	        if(dbRowset.next()){
	        	plnSeq = dbRowset.getString("PLN_SEQ");
	        }
	
	    }catch (SQLException se) {
	        log.error(se.getMessage(), se);
	        throw new DAOException(new ErrorHandler(se).getMessage());
	    }catch (DAOException de) {
	        log.error(de.getMessage(), de);
	        throw de;
	    }catch (Exception e) {
	        log.error(e.getMessage(), e);
	        throw new DAOException(e.getMessage());
	    }
	    return plnSeq;
	}

    /**
     * TRUCK & RAIL & WATER 에서 INSERT PLAN할때 EQR_SCNR_ECC_LNK 테이블에 존재하지 않으면 입력 불가능
     * 
     * @param fm_yd_cd
     * @param to_yd_cd
     * @param trsp_mod_cd
     * @return boolean
     * @exception DAOException
     */
    public boolean inlandInsertCheck_link(String fm_yd_cd, String to_yd_cd, String trsp_mod_cd) throws DAOException {
    	DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	    int k 		= 0;
	    boolean key = false;
	    
                 
	    try {
	    	param.put("fm_yd_cd", fm_yd_cd);
	    	param.put("to_yd_cd", to_yd_cd);
	    	param.put("trsp_mod_cd", trsp_mod_cd);
	    	param.put("delt_flg", "N");
	       
	    	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOSearchInlandInsertCheckLinkRSQL(), param, null);
	        if(dbRowset.next()) {
	        	k = dbRowset.getInt("COUN");
	        	if(k == 0) {
	        		key = true;  // 존재하지 않으면 insert 불가판정
	        	}
	        }
	
	    }catch (SQLException se) {
	        log.error(se.getMessage(), se);
	        throw new DAOException(new ErrorHandler(se).getMessage());
	    }catch (DAOException de) {
	        log.error(de.getMessage(), de);
	        throw de;
	    }catch (Exception e) {
	        log.error(e.getMessage(), e);
	        throw new DAOException(e.getMessage());
	    }
	    return key;
	}    

    
	/** 
	 * ADDED BY SHIN YONGCHAN - 20080430
	 * UNIT COST 정보를 취득합니다.
	 * COD, REPO PLAN, EXE PLAN 3군데 화면에서 사용합니다. (소스는 각각의 DAO에 존재함)
	 *
	 * 1) EQR_ECC_ADD_PLN_COST 에 UNIT COST 존재하는지 확인
	 * 2) 존재하면       EQR_ECC_ADD_PLN_COST 에서 UNIT COST 취득
	 * 3) 존재하지 않으면 EQR_LCC_ADD_PLN_COST 에서 UNIT COST 획득  
	 * 
	 * @param division 		: PLAN, EXEC, INTERNAL  구분( P, E, I)
	 * @param fm_ecc 		: FROM ECC (OR FROM YARD)
	 * @param to_ecc 		: TO ECC (OR TO YARD)
	 * @param trsp_mod_cd 	: trsp_mod_cd 구분(V,R,T,W,)
	 * @param cntr_tpsz_cd 	: cntr_tpsz_cd 구분
	 * @return CommonRsVO String[] (FROM UNIT COST, TO UNIT COST, UNIT COST)
	 * @exception DAOException
	 */	
	public CommonRsVO searchUnitCost(String division, String fm_ecc, String to_ecc, String trsp_mod_cd, String cntr_tpsz_cd) throws DAOException {

		DBRowSet dbRowsetChk = null;
		DBRowSet dbRowsetECC = null;
		DBRowSet dbRowsetLCC = null;
		CommonRsVO commonVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String[] returnStr = new String[3];
		int result = 0;
		
		
		try {
			SQLExecuter sQLExecuter = new SQLExecuter("");
			param.put("fm_ecc", fm_ecc);
			param.put("to_ecc", to_ecc);
			param.put("trsp_mod_cd", trsp_mod_cd);
			param.put("cntr_tpsz_cd", cntr_tpsz_cd);
			velParam.put("fm_ecc", fm_ecc);
			velParam.put("to_ecc", to_ecc);
			velParam.put("trsp_mod_cd", trsp_mod_cd);
			velParam.put("cntr_tpsz_cd", cntr_tpsz_cd);
			velParam.put("division", division);
			
			dbRowsetChk = sQLExecuter.executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOSearchUnitCostCheckRSQL(), param, velParam);
			
			while (dbRowsetChk.next()){
				result = dbRowsetChk.getInt(1);
				break;
			}		
			
			//-------------- ECC에 데이터 존재 
			if( result>0 ) {
				
				dbRowsetECC = sQLExecuter.executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOSearchUnitCostECCRSQL(), param, velParam);
				
				while(dbRowsetECC.next()) {
					returnStr[0]= dbRowsetECC.getString("FM_COST");
					returnStr[1]= dbRowsetECC.getString("TO_COST"); 
					returnStr[2]= dbRowsetECC.getString("UC_COST"); 				
				}		
				
			} else {
				
				dbRowsetLCC = sQLExecuter.executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOSearchUnitCostLCCRSQL(), param, velParam);
				
				while(dbRowsetLCC.next()) {
					returnStr[0]= dbRowsetLCC.getString("FM_COST");
					returnStr[1]= dbRowsetLCC.getString("TO_COST"); 
					returnStr[2]= dbRowsetLCC.getString("UC_COST"); 				
				}				
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

		commonVO.setResultStrArray(returnStr);
		return commonVO;
	}	
 	
	/**
     * 컨테이너 이송 실행 계획 조회/수정 On-Hire & Off-Hire (EES_EQR_081) SEQ 생성<br>
     * 
     * @param table_name : table_name
     * @param co_cd : company
     * @param repo_plan_id : repo_plan_id
     * @param from_location : from_location
     * @param onf_hir_div_cd : onf_hir_div_cd
     * @return String
     * @exception DAOException
    */
	public String makeRefIDCntrRepoPlan(String table_name, String co_cd, String repo_plan_id, String from_location, String onf_hir_div_cd) throws DAOException {
		  
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
	    //String seq  = "";
	    String ref_id = "";
	    
	    try {
	    	velParam.put("table_name",table_name);
	    	param.put("repo_plan_id",repo_plan_id);
	    	param.put("from_location",from_location.substring(0,5));
	    	param.put("repo_plan_id610",repo_plan_id.substring(6,10));
	    	param.put("onf_hir_div_cd",onf_hir_div_cd);

	    	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOMakeRefIDRepoPlanRSQL(), param, velParam);
	        
	        if(dbRowset.next()){
	        	ref_id = dbRowset.getString("SEQ");
	        } else {
	        	ref_id = "CHECK_REF_NO";
	        }
	        
	        /*
            H     : 
            KRPUS : FROM LOC 을 0,5 로 잘라서 사용
            0637W : REPO_PLAN_ID 를 잘라내서 + "W"
            002   : REPO_PLAN_ID 를 잘라낸(0637), SUBSTR(FM_YD_CD, 0,5) 중에 REF_ID 의 뒷 4자리중 앞3자리 MAX+1
            O     : TRSP MODE                    	        
	        */	        
	        // Old ref_id = co_cd + from_location.substring(0,5) + repo_plan_id.substring(6,10)+ "W" + seq + onf_hir_div_cd;
	        
	    }catch (SQLException se) {
	        log.error(se.getMessage(), se);
	        throw new DAOException(new ErrorHandler(se).getMessage());   
	    }catch (DAOException de) {
	        log.error(de.getMessage(), de);
	        throw de;
	    }catch (Exception e) {
	        log.error(e.getMessage(), e);
	        throw new DAOException(e.getMessage());
	    }
	    
	    return ref_id;
	}		

	/**
     * 컨테이너 이송실행계획 EQR_EXE_PLN_CNTR table 입력,삭제 <br>
     * 
     * @param actFlag 		: Insert, Delete 구분 (I,D)
     * @param eqrExePlnCntrVO 	: 입력 및 삭제 시 추가되는 VO 객체
     * @param user_id 		: user_id 
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
	public void modifyCntrRepoPlanDetail(String actFlag , EqrExePlnCntrVO eqrExePlnCntrVO , String user_id) throws DAOException {
   		
        boolean isInsert = false;
        boolean isDelete = false;
        List insModels = new ArrayList();
        List delModels = new ArrayList(); 
        int insCnt[] = null;
        int delCnt[] = null;
       
        try {
        	SQLExecuter sqlExe = new SQLExecuter("");
            
            if(actFlag.equals("I")) {            
            	 // 화면에서 입력된 정보 받기
    			String[] cntrNoArr = eqrExePlnCntrVO.getCntrNo().split(",");	
    			String[] cntrTpszArr = eqrExePlnCntrVO.getCntrTpszCd().split(",");
    			
    			int rowCount = (cntrNoArr==null) ? 0 : cntrNoArr.length;
            	
            	for(int k=0; k<rowCount; k++) {   
            		//query parameter
            		Map<String, Object> param = new HashMap<String, Object>();
            		param.putAll(eqrExePlnCntrVO.getColumnValues());
            		param.put("user_id", user_id);
            		param.put("cntr_no", cntrNoArr[k]);
            		param.put("cntr_tpsz_cd", cntrTpszArr[k]);
            		param.put("pln_seq", eqrExePlnCntrVO.getPlnSeq());
               	 	isInsert = true ; 
               	 	insModels.add(param);    
				}				    
				
    		}else if(actFlag.equals("D")) {    			
    			Map<String, Object> param = new HashMap<String, Object>();
        		param.putAll(eqrExePlnCntrVO.getColumnValues());
        		
                isDelete = true ;
                delModels.add(param);  
			}                  
          
            if(isInsert){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOInsertCntrRepoPlanDetailCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
            if(isDelete){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAODeleteCntrRepoPlanDetailDSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}

        } catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
        }
    }
	/**
	 * 컨테이너 이송 실행 계획 조회/수정 Truck/Rail/Barge (EES_EQR_080) DB에 반영한다.(추가)
	 * EQR_INLND_TRSP_PLN     입력
	 * 
	 * @param eqrInlndTrspPlnVO EqrInlndTrspPlnVO
	 * @param user_id			String
	 * @exception DAOException
	 */
	public void insertInlandPlan(EqrInlndTrspPlnVO eqrInlndTrspPlnVO , String user_id)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.putAll(eqrInlndTrspPlnVO.getColumnValues());
			param.put("user_id", user_id);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOInsertInlandPlanCSQL(), param, null);
			
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
	}

	/**
	 * 컨테이너 이송 실행 계획 조회/수정 Truck/Rail/Barge (EES_EQR_080) DB에 반영한다.(추가)
	 * EQR_INLND_TRSP_PLN_QTY     입력
	 * 
	 * @param eqrInlndTrspPlnQtyVO EqrInlndTrspPlnQtyVO
	 * @param user_id
	 * @exception DAOException
	 */
	public void insertInlandPlanQty(EqrInlndTrspPlnQtyVO eqrInlndTrspPlnQtyVO , String user_id)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.putAll(eqrInlndTrspPlnQtyVO.getColumnValues());
			param.put("user_id", user_id);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOInsertInlandPlanQtyCSQL(), param, null);
			
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
	}
	/**
	 * 컨테이너 이송 실행 계획 조회/수정 Truck/Rail/Barge (EES_EQR_080) DB에 반영한다.(추가)
	 * EQR_INLND_TRSP_PLN_EXE     입력
	 * 
	 * @param eqrInlndTrspExePlnVO EqrInlndTrspExePlnVO
	 * @param user_id
	 * @exception DAOException
	 */
	public void insertInlandExecute(EqrInlndTrspExePlnVO eqrInlndTrspExePlnVO , String user_id)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.putAll(eqrInlndTrspExePlnVO.getColumnValues());
			param.put("user_id", user_id);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOInsertInlandExecuteCSQL(), param, null);
			
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
	}
	/**
	 * 컨테이너 이송 실행 계획 조회/수정 Truck/Rail/Barge (EES_EQR_080) DB에 반영한다.(추가)
	 * EQR_INLND_TRSP_PLN_EXE_QTY     입력
	 * 
	 * @param eqrInlndTrspExePlnQtyVO EqrInlndTrspExePlnQtyVO
	 * @param user_id
	 * @exception DAOException
	 */
	public void insertInlandExecuteQty(EqrInlndTrspExePlnQtyVO eqrInlndTrspExePlnQtyVO , String user_id)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.putAll(eqrInlndTrspExePlnQtyVO.getColumnValues());
			param.put("user_id", user_id);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOInsertInlandExecuteQtyCSQL(), param, null);
			
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
	}
	

	/**
	 * 컨테이너 이송 실행 계획 조회/수정 Truck/Rail/Barge (EES_EQR_080) DB에 반영한다.(추가)
	 * EQR_INLND_TRSP_PLN_EXE_QTY     수정
	 * 
	 * @param eqrInlndTrspExePlnQtyVO EqrInlndTrspExePlnQtyVO
	 * @param user_id String
	 * @param soFlag String
	 * @exception DAOException
	 */
	public void mergeInlandExecuteQty(EqrInlndTrspExePlnQtyVO eqrInlndTrspExePlnQtyVO , String user_id , String soFlag )throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.putAll(eqrInlndTrspExePlnQtyVO.getColumnValues());
			param.put("user_id", user_id);
			velParam.put("soFlag", soFlag);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOMergeInlandExecuteCSQL(), param, velParam);
			
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
	}
	/**
	 * 컨테이너 이송 실행 계획 조회/수정 Truck/Rail/Barge (EES_EQR_080) DB에 반영한다.(추가)
	 * EQR_INLND_TRSP_PLN_EXE     입력
	 * 
	 * @param eqrInlndTrspExePlnVO EqrInlndTrspExePlnVO
	 * @param user_id String
	 * @param soFlag String
	 * @exception DAOException
	 */
	public void updateInlandExecute(EqrInlndTrspExePlnVO eqrInlndTrspExePlnVO , String user_id, String soFlag )throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.putAll(eqrInlndTrspExePlnVO.getColumnValues());
			param.put("user_id", user_id);
			velParam.put("soFlag", soFlag);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOUpdateInlandExecuteUSQL(), param, velParam);
			
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
	}

	/**
	 * 컨테이너 이송 실행 계획 조회/수정 Truck/Rail/Barge (EES_EQR_080) DB에 반영한다.(추가)
	 * EQR_INLND_TRSP_PLN_EXE     삭제
	 * 
	 * @param eqrInlndTrspExePlnVO EqrInlndTrspExePlnVO
	 * @exception DAOException
	 */
	public void deleteInlandExecute(EqrInlndTrspExePlnVO eqrInlndTrspExePlnVO  )throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.putAll(eqrInlndTrspExePlnVO.getColumnValues());
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAODeleteInlandExecuteDSQL(), param, null);
			
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
	}
	
	
	/**
	 * 컨테이너 이송 실행 계획 조회/수정 Truck/Rail/Barge (EES_EQR_080) DB에 반영한다.(추가)
	 * EQR_INLND_TRSP_PLN_QTY     삭제
	 * 
	 * @param EqrExePlnCntrVO eqrExePlnCntrVO
	 * @exception DAOException
	 */
	public void deleteEqrInlandTrspPlnQtyExecuteQty(EqrExePlnCntrVO eqrExePlnCntrVO )throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.putAll(eqrExePlnCntrVO.getColumnValues());
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAODeleteEqrInlndTrspPlnQtyDSQL(), param, null);
			
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
	}
	
	
	/**
	 * 컨테이너 이송 실행 계획 조회/수정 Truck/Rail/Barge (EES_EQR_080) DB에 반영한다.(추가)
	 * EQR_INLND_TRSP_PLN     삭제
	 * 
	 * @param EqrExePlnCntrVO eqrExePlnCntrVO
	 * @exception DAOException
	 */
	public void deleteEqrInlandTrspPlnExecuteQty(EqrExePlnCntrVO eqrExePlnCntrVO )throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.putAll(eqrExePlnCntrVO.getColumnValues());
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAODeleteEqrInlndTrspPlnDSQL(), param, null);
			
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
	}

	/**
	 * 컨테이너 이송 실행 계획 조회/수정 Truck/Rail/Barge (EES_EQR_080) DB에 반영한다.(추가)
	 * EQR_ONF_HIR_PLN     삭제
	 * 
	 * @param eqrInlndTrspExePlnQtyVO EqrInlndTrspExePlnQtyVO
	 * @exception DAOException
	 */
	public void deleteInlandExecuteQty(EqrInlndTrspExePlnQtyVO eqrInlndTrspExePlnQtyVO )throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.putAll(eqrInlndTrspExePlnQtyVO.getColumnValues());
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAODeleteInlandExecuteQtyDSQL(), param, null);
			
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
	}
	
	
	
	/**
	 * 컨테이너 이송 실행 계획 조회/수정 Truck/Rail/Barge (EES_EQR_081) DB에 반영한다.(추가)
	 * EQR_ONF_HIR_PLN_QTY     삭제
	 * 
	 * @param EqrOnfHirExePlnQtyVO eqrOnfHirExePlnQtyVO
	 * @exception DAOException
	 */
	public void deleteEqrOnfHirPlnQtyExecuteQty(EqrOnfHirExePlnQtyVO eqrOnfHirExePlnQtyVO )throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.putAll(eqrOnfHirExePlnQtyVO.getColumnValues());
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAODeleteEqrOnfHirPlnQtyDSQL(), param, null);
		 	 
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
	}
	
	
	
	
	
	/**
	 * 컨테이너 이송 실행 계획 조회/수정 Truck/Rail/Barge (EES_EQR_081) DB에 반영한다.(추가)
	 * EQR_INLND_TRSP_PLN     삭제
	 * 
	 * @param EqrOnfHirExePlnQtyVO eqrOnfHirExePlnQtyVO
	 * @exception DAOException
	 */
	public void deleteEqrOnfHirExecuteQty(EqrOnfHirExePlnQtyVO eqrOnfHirExePlnQtyVO )throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.putAll(eqrOnfHirExePlnQtyVO.getColumnValues());
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAODeleteEqrOnfHirPlnDSQL(), param, null);
			
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
	}
	
	
	
	/**
	 * EQR_INLND_TRSP_EXE_PLN
	 * EQR_ONF_HIR_EXE_PLN
	 * EQR_ECC_INTER_EXE_PLN
	 * 위의 3개 테이블에서 OFFICE CODE를 검색(CO_CD=H 만 해당됨)
	 * CNTR TPSZ 별로 검색
	 * 
	 * @param String target_table		
	 * @param String target_qty_table
	 * @param List<CommonVO> target_key_list
	 * @param String repo_plan_id
	 * @param String pln_yrwk
	 * @param String ref_id
	 * @param String pln_seq
	 * @param String cntr_tpsz_cd
	 * @return CommonVO
	 * @exception DAOException
	 */
  public CommonVO searchOfficeCode(String target_table,String target_qty_table, List<CommonVO> target_key_list, String repo_plan_id, String pln_yrwk, String ref_id, String pln_seq ,String cntr_tpsz_cd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String officeCode = "";
		CommonVO retVO = new CommonVO();
		try {
	    	velParam.put("target_table",target_table);
	    	velParam.put("target_qty_table",target_qty_table);
	    	velParam.put("target_key_list",target_key_list);
	    	param.put("repo_plan_id",repo_plan_id);
	    	param.put("pln_yrwk",pln_yrwk);
	    	param.put("ref_id",ref_id);
	    	param.put("pln_seq",pln_seq);
	    	param.put("cntr_tpsz_cd",cntr_tpsz_cd);
	    	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOSearchOfficeCodeRSQL(), param, velParam);
	        
	        if(dbRowset.next()){
	        	officeCode = dbRowset.getString("OFFICE_CODE");	        	
	        }
	        retVO.setResultString(officeCode);
	    }catch (SQLException se) {
	        log.error(se.getMessage(), se);
	        throw new DAOException(new ErrorHandler(se).getMessage());   
	    }catch (DAOException de) {
	        log.error(de.getMessage(), de);
	        throw de;
	    }catch (Exception e) {
	        log.error(e.getMessage(), e);
	        throw new DAOException(e.getMessage());
	    }
		return retVO;
	}

	/**
     * 컨테이너 이송 실행 계획 수정 -- Combine (EES_EQR_108) DB에 반영한다.(추가, 수정, 삭제)<br>
     * ECC1, ECC2, ECC3 정보에서 <br>
     * 같은것은 ECC INTERNAL <br>
     * 다른것은 VESSEL, TRUCK으로 입력 - TAB(1,2)로 구분<br>
     * 
	 * @param eqrVslLodgDcgExePlnVO EqrVslLodgDchgExePlnVO
	 * @param user_id String
	 * @exception DAOException
	 */
	public void insertCombineExecutionVessel(EqrVslLodgDchgExePlnVO eqrVslLodgDcgExePlnVO , String user_id)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			param.putAll(eqrVslLodgDcgExePlnVO.getColumnValues());
	    	param.put("user_id",user_id);
	    	new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOModifyCombineExecutionVesselCSQL(), param, null);
	        
	    }catch (SQLException se) {
	        log.error(se.getMessage(), se);
	        throw new DAOException(new ErrorHandler(se).getMessage());   
	    }catch (DAOException de) {
	        log.error(de.getMessage(), de);
	        throw de;
	    }catch (Exception e) {
	        log.error(e.getMessage(), e);
	        throw new DAOException(e.getMessage());
	    }
	}

	/**
     * 컨테이너 이송 실행 계획 수정 -- Combine (EES_EQR_108) DB에 반영한다.(추가, 수정, 삭제)<br>
     * ECC1, ECC2, ECC3 정보에서 <br>
     * 같은것은 ECC INTERNAL <br>
     * 다른것은 VESSEL, TRUCK으로 입력 - TAB(1,2)로 구분<br>
     * 
	 * @param eqrVslExePlnQtyVO EqrVslExePlnQtyVO
	 * @param user_id String
	 * @exception DAOException
	 */
	public void insertCombineExecutionVesselQty(EqrVslExePlnQtyVO eqrVslExePlnQtyVO , String user_id)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			param.putAll(eqrVslExePlnQtyVO.getColumnValues());
	    	param.put("user_id",user_id);
	    	new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOModifyCombineExecutionVesselQtyCSQL(), param, null);
	        
	    }catch (SQLException se) {
	        log.error(se.getMessage(), se);
	        throw new DAOException(new ErrorHandler(se).getMessage());   
	    }catch (DAOException de) {
	        log.error(de.getMessage(), de);
	        throw de;
	    }catch (Exception e) {
	        log.error(e.getMessage(), e);
	        throw new DAOException(e.getMessage());
	    }
	}

	/**
     * 컨테이너 이송 실행 계획 수정 -- Combine (EES_EQR_108) DB에 반영한다.(추가, 수정, 삭제)<br>
     * ECC1, ECC2, ECC3 정보에서 <br>
     * 같은것은 ECC INTERNAL <br>
     * 다른것은 VESSEL, TRUCK으로 입력 - TAB(1,2)로 구분<br>
     * 
	 * @param eqrEccInterExePlnVO EqrEccInterExePlnVO
	 * @param user_id String
	 * @exception DAOException
	 */
	public void insertCombineExecutionInternal(EqrEccInterExePlnVO eqrEccInterExePlnVO , String user_id)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			param.putAll(eqrEccInterExePlnVO.getColumnValues());
	    	param.put("user_id",user_id);
	    	new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOModifyCombineExecutionInternalCSQL(), param, null);
	        
	    }catch (SQLException se) {
	        log.error(se.getMessage(), se);
	        throw new DAOException(new ErrorHandler(se).getMessage());   
	    }catch (DAOException de) {
	        log.error(de.getMessage(), de);
	        throw de;
	    }catch (Exception e) {
	        log.error(e.getMessage(), e);
	        throw new DAOException(e.getMessage());
	    }
	}

	/**
     * 컨테이너 이송 실행 계획 수정 -- Combine (EES_EQR_108) DB에 반영한다.(추가, 수정, 삭제)<br>
     * ECC1, ECC2, ECC3 정보에서 <br>
     * 같은것은 ECC INTERNAL <br>
     * 다른것은 VESSEL, TRUCK으로 입력 - TAB(1,2)로 구분<br>
     * 
	 * @param eqrEccInterExePlnQtyVO EqrVslLodgDchgExePlnVO
	 * @param user_id String
	 * @exception DAOException
	 */
	public void insertCombineExecutionInternalQty(EqrEccInterExePlnQtyVO eqrEccInterExePlnQtyVO , String user_id)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			param.putAll(eqrEccInterExePlnQtyVO.getColumnValues());
	    	param.put("user_id",user_id);
	    	new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOModifyCombineExecutionInternalQtyCSQL(), param, null);
	        
	    }catch (SQLException se) {
	        log.error(se.getMessage(), se);
	        throw new DAOException(new ErrorHandler(se).getMessage());   
	    }catch (DAOException de) {
	        log.error(de.getMessage(), de);
	        throw de;
	    }catch (Exception e) {
	        log.error(e.getMessage(), e);
	        throw new DAOException(e.getMessage());
	    }
	}
	/**
	 * [ EES_EQR_0130 : BKG Split Create - Default, 화면 로딩시 Booking 정보 조회하여 보여주기.]<br>
	 * 
	 * @param bkg_no String
	 * @return List<SearchExecutionPlanBkgNoVO>
	 * @exception DAOException
	*/
	@SuppressWarnings("unchecked")
	public List<SearchExecutionPlanBkgNoVO> searchCntrRepoExecutionPlanBkgNoInfo(String bkg_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchExecutionPlanBkgNoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if(bkg_no != null){
				param.put("bkg_no", bkg_no);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOSearchExecutionPlanBkgNoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchExecutionPlanBkgNoVO .class);
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
	 * [ EES_EQR_0130 : BKG Split Create - Container List] <br>
	 * 
	 * @param eesEqr0130ConditionVO EesEqr0130ConditionVO
	 * @return List<SearchExecutionPlanSplitCntrVO>
	 * @exception DAOException
	*/
	@SuppressWarnings("unchecked")
	public List<SearchExecutionPlanSplitCntrVO> searchCntrRepoExecutionPlanSplitCntrList(EesEqr0130ConditionVO eesEqr0130ConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchExecutionPlanSplitCntrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(eesEqr0130ConditionVO != null){
				String bkg_no = eesEqr0130ConditionVO.getBkgNo();
				String bkg_pod = eesEqr0130ConditionVO.getBkgPod();				
				String cntr_no = eesEqr0130ConditionVO.getExcelCntrNo();
				String cntrNoText = Utils.convertStr(cntr_no);
				
				param.put("bkg_pod", bkg_pod);
				velParam.put("cntr_no",cntr_no);
				velParam.put("cntrNoText",cntrNoText);
				velParam.put("bkg_no", bkg_no);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOSearchExecutionPlanSplitCntrRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchExecutionPlanSplitCntrVO .class);
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
	 * [ EES_EQR_0139 : EQR Organization Chart - Default ] <br>
	 * 
	 * @return SearchEqrOrganizationVO
	 * @exception DAOException
	*/
	public SearchEqrOrganizationVO searchEqrOrganizationChartCount() throws DAOException {
		DBRowSet dbRowset = null;
		SearchEqrOrganizationVO vo = null;

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOSearchEqrOrganizationCountRSQL(), null, null);
			vo = (SearchEqrOrganizationVO) RowSetUtil.rowSetToVOs(dbRowset, SearchEqrOrganizationVO .class).get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return vo;
	}
	
	/**
	 * [ EES_EQR_0139 : EQR Organization Chart - List ] <br>
	 * 
	 * @return List<SearchEqrOrganizationVO>
	 * @exception DAOException
	*/
	@SuppressWarnings("unchecked")
	public List<SearchEqrOrganizationVO> searchEqrOrganizationChart() throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchEqrOrganizationVO> list = null;

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOSearchEqrOrganizationRSQL(), null, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchEqrOrganizationVO .class);
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
	 * 컨테이너 이송실행계획 [0080] SO SEND 버튼 클릭시 EQR_EXE_PLN_CNTR 에서 컨테이너 정보 조회
	 *          
	 * @param eqrExePlnCntrVO EqrExePlnCntrVO
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	public CommonRsVO searchInlandContainer( EqrExePlnCntrVO eqrExePlnCntrVO )	throws DAOException {
		CommonRsVO commonRsVO = new CommonRsVO();
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			param.putAll(eqrExePlnCntrVO.getColumnValues());
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOSearchInlandContainerRSQL(), param, null);
			commonRsVO.setDbRowset(dbRowset);
	    }catch (SQLException se) {
	        log.error(se.getMessage(), se);
	        throw new DAOException(new ErrorHandler(se).getMessage());   
	    }catch (DAOException de) {
	        log.error(de.getMessage(), de);
	        throw de;
	    }catch (Exception e) {
	        log.error(e.getMessage(), e);
	        throw new DAOException(e.getMessage());
	    }
	    return commonRsVO;
	}

	/**
	 * 컨테이너 이송실행계획 [0080] SO SEND 버튼 클릭시 EQR_REPO_EXE_SO_IF 에 soData 입력
	 *          
	 * @param eqrRepoExeSoIfVO EqrRepoExeSoIfVO
	 * @param user_id String
	 * @exception DAOException
	 */
	public void createInlandSoData(EqrRepoExeSoIfVO eqrRepoExeSoIfVO , String user_id)	throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.putAll(eqrRepoExeSoIfVO.getColumnValues());
			param.put("user_id",user_id);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOCreateInlandSoDataCSQL(), param, null);
	    }catch (SQLException se) {
	        log.error(se.getMessage(), se);
	        throw new DAOException(new ErrorHandler(se).getMessage());   
	    }catch (DAOException de) {
	        log.error(de.getMessage(), de);
	        throw de;
	    }catch (Exception e) {
	        log.error(e.getMessage(), e);
	        throw new DAOException(e.getMessage());
	    }
	}
	/**
     * SO Cancel 이 가능한지를 확인하는 쿼리임.<br>
      	-- 아래쿼리에서 결과값이 0 이어야지만 해당 REF_ID를 모두 삭제함<br>
        SELECT DECODE(COUNT(*), 0, 'Y', 'N') EXEFLG	  -- 'Y' 삭제가능 'N' 삭제불가능 <br>
        FROM EQR_REPO_EXE_SO_IF		 									<br>
		WHERE REPO_PLN_ID = 'REPO200637W000'							<br>
		AND   PLN_YRWK    = '200637'									<br>
		AND   REF_ID      = 'HKRPUS0637W001'							<br>
		AND   WO_EXE_FLG  = 'Y'		     								<br>
	 *
	 * @param repo_pln_id String
     * @param pln_yrwk String
     * @param pln_seq String
     * @param ref_id String
     * @return CommonRsVO
     * @exception DAOException
     */
	public CommonRsVO soCancelCheckCntrRepoPlan(String repo_pln_id, String pln_yrwk,String pln_seq , String ref_id) throws DAOException {
		CommonRsVO commonRsVO = new CommonRsVO();
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		String exeflag  = "N";
		try {
			param.put("repo_pln_id",repo_pln_id);
			param.put("pln_yrwk",pln_yrwk);
			param.put("pln_seq",pln_seq);
			param.put("ref_id",ref_id);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOSearchSoCancelCheckCntrRepoPlnRSQL(), param, null);
			if(dbRowset.next()){
	        	exeflag = dbRowset.getString("EXEFLG");
	        }
			commonRsVO.setResultString(exeflag);
	    }catch (SQLException se) {
	        log.error(se.getMessage(), se);
	        throw new DAOException(new ErrorHandler(se).getMessage());   
	    }catch (DAOException de) {
	        log.error(de.getMessage(), de);
	        throw de;
	    }catch (Exception e) {
	        log.error(e.getMessage(), e);
	        throw new DAOException(e.getMessage());
	    }
	    return commonRsVO;
	}
	/**
     *- W/O Issue 테이블로 Execute중에 REF_ID별로 S/O Send 체크박스 클릭한 것만 삭제<br>
      - EQR_REPO_EXE_SO_IF 테이블의 REF_ID중에 WO_EXE_FLG 가 'Y'가 1개도 업어야 함  <br>           
		
	   DELETE : REF_ID 별로 위의 검색요건을 만족하면 삭제 수행 <br>
	           - EQR_REPO_EXE_SO_IF       삭제   ( 해당 REF_ID )<br>		
	 *          
     * @param eqrRepoExeSoIfVO EqrRepoExeSoIfVO
     * @exception DAOException
     */
	public void deleteInlandSoData(EqrRepoExeSoIfVO eqrRepoExeSoIfVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.putAll(eqrRepoExeSoIfVO.getColumnValues());

			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAODeleteInlandSoDataDSQL(), param, null);
			
	    }catch (SQLException se) {
	        log.error(se.getMessage(), se);
	        throw new DAOException(new ErrorHandler(se).getMessage());   
	    }catch (DAOException de) {
	        log.error(de.getMessage(), de);
	        throw de;
	    }catch (Exception e) {
	        log.error(e.getMessage(), e);
	        throw new DAOException(e.getMessage());
	    }
	}

	/**
     *- W/O Issue 테이블로 Execute중에 REF_ID별로 S/O Send 체크박스 클릭한 것만 삭제<br>
      - EQR_REPO_EXE_SO_IF 테이블의 REF_ID중에 WO_EXE_FLG 가 'Y'가 1개도 업어야 함  <br>           
		
	   EQR_INLND_TRSP_EXE_PLN  SO FLAG 초기화
	 *          
     * @param eqrInlndTrspExePlnVO EqrInlndTrspExePlnVO
     * @param user_id 		: user_id     
     * @exception DAOException
     */
	public void updateInitInlandExecute(EqrInlndTrspExePlnVO eqrInlndTrspExePlnVO , String user_id)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.putAll(eqrInlndTrspExePlnVO.getColumnValues());
			param.put("user_id", user_id);

			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOUpdateInitInlandExecuteUSQL(), param, null);
			
	    }catch (SQLException se) {
	        log.error(se.getMessage(), se);
	        throw new DAOException(new ErrorHandler(se).getMessage());   
	    }catch (DAOException de) {
	        log.error(de.getMessage(), de);
	        throw de;
	    }catch (Exception e) {
	        log.error(e.getMessage(), e);
	        throw new DAOException(e.getMessage());
	    }
	}

	/**
	 * 
	 * @param eqrExePlnCntrVO
	 * @exception DAOException
	 */
	public void deleteInlandCntr(EqrExePlnCntrVO eqrExePlnCntrVO)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.putAll(eqrExePlnCntrVO.getColumnValues());

			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAODeleteInlandCntrDSQL(), param, null);
			
	    }catch (SQLException se) {
	        log.error(se.getMessage(), se);
	        throw new DAOException(new ErrorHandler(se).getMessage());   
	    }catch (DAOException de) {
	        log.error(de.getMessage(), de);
	        throw de;
	    }catch (Exception e) {
	        log.error(e.getMessage(), e);
	        throw new DAOException(e.getMessage());
	    }
	}
	
	/**
	 * 컨테이너 이송 실행 계획 조회/수정 On-Hire & Off-Hire (EES_EQR_081) 정보 조회
	 * 
	 * @param condiVO EesEqr0059ConditionVO
	 * @param account SignOnUserAccount
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CommonRsVO searchOnHireAndOffHireCntrRepoPlan(EesEqr0059ConditionVO condiVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String offCd = account.getOfc_cd();
		
		String fromECC    = condiVO.getFromEcc();
		String userECC	  = condiVO.getUserEcc();
		
		String repoPlanID = condiVO.getRepoPlnId();
		String fromWeek   = condiVO.getFmplnyr()+condiVO.getFmplnwk();
		String toWeek     = condiVO.getToplnyr()+condiVO.getToplnwk();
		
    	String tpsz     = condiVO.getTpsz();      // TYPE SIZE 종류(ALL, DRY, RFR...)
 		String tpsztype = condiVO.getTpsztype();  // TYPE SIZE 선택값
 		List tpszArr= Utils.replaceStrToList(tpsztype);
 		
 		String fmtoat      = condiVO.getFmtoat();
 		String fromStatus  = condiVO.getFromstatus();

 		String reason   = condiVO.getReason();
 		String itemname = condiVO.getItemname();
 		String sosend   = condiVO.getSosend();
 		String fromLoc		= condiVO.getFromlocation();
		String toLoc		= condiVO.getTolocation();
 		
        // 조건값 셋팅 변수 
 		String frLocWhere    = "";  // from location where condition
 		String tpszWhere     = "";  // tp size information
 		String reasonWhere   = "";
 		String itemnameWhere = "";
 		String userLocWhere = "";
 		// user location 검색조건 ('','',''.....)
    	if(!userECC.equals("")) {
    		userLocWhere = Utils.convertStr(userECC,true);
    	}
    	// from location 검색조건 ('','',''.....)
    	// CSR No:N200906040080 의거 Fm ETD, To ETA 조건 추가 
    	// fmtoat.equals("3")은 Fm ETD 조건 , fmtoat.equals("4") To ETA 조건 
    	//if(fmtoat.equals("1") && !fromStatus.equals("")) { --원본
    	if((fmtoat.equals("1") || fmtoat.equals("3") || fmtoat.equals("4")) && !fromStatus.equals("")) {	
    		frLocWhere = Utils.convertStr(fromECC,true);
    	}
    	// TP/SZ 에 따른 조건값을 넣어 준다.
        if(!tpsz.equals("") && !tpsztype.equals("")) {
        	tpszWhere = Utils.convertStr(tpsztype);
        }
        // REASON 에 따른 조건값을 넣어 준다.
        if(!reason.equals("")) {
        	reasonWhere = Utils.convertStr(reason);
        }
        // ITEMNAME 에 따른 조건값을 넣어 준다.
        if(!itemname.equals("")) {
        	itemnameWhere = Utils.convertStr(itemname);
        }
		try {
			param.put("repoPlanID",repoPlanID);
			param.put("fromWeek",fromWeek);
			param.put("toWeek",toWeek);
			param.put("sosend",sosend);
			param.put("from_loc", fromLoc);
			param.put("to_loc", toLoc);
			param.put("off_cd", offCd);
			
			velParam.put("repoPlanID",repoPlanID);
			velParam.put("fromWeek",fromWeek);
			velParam.put("toWeek",toWeek);
			velParam.put("sosend",sosend);
			velParam.put("userECC", userECC);
			velParam.put("userLocWhere", userLocWhere);
			velParam.put("fmtoat", fmtoat);
			velParam.put("fromStatus", fromStatus);
			velParam.put("frLocWhere", frLocWhere);
			velParam.put("fromECC", fromECC);
			velParam.put("tpsz", tpsz);
			velParam.put("tpsztype", tpsztype);
			velParam.put("tpszWhere", tpszWhere);
			velParam.put("reason", reason);
			velParam.put("reasonWhere", reasonWhere);
			velParam.put("itemname", itemname);
			velParam.put("itemnameWhere", itemnameWhere);
			velParam.put("fromECC", fromECC);
			velParam.put("tpszArr", tpszArr);
			velParam.put("from_loc", fromLoc);
			velParam.put("to_loc", toLoc);
			velParam.put("off_cd", offCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOSearchOnOffHireCntrRepoPlanRSQL(), param, velParam);
			commonRsVO.setDbRowset(dbRowset);

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
		
		return commonRsVO;
	}

    /**
     * 수정시 insert를 해야 할 값과 update 할 값이 공존하여  체크하여  insert, update를 수행한다. 
     * 결과값이 true 이면 insert를 하고 false 이면 update를 수행을 한다.       
     * 
     * @param repo_pln_id
     * @param pln_yrwk
     * @param onf_hir_div_cd
     * @param ecc_cd
     * @param lease_term
     * @return boolean
     * @exception DAOException
     */
    public boolean onOffHireInsertCheck(String repo_pln_id, String pln_yrwk, String onf_hir_div_cd, String ecc_cd, String lease_term) throws DAOException {
		  
    	DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	    boolean key = false;
	    
                 
	    try {
	    	param.put("repo_pln_id", repo_pln_id);
	    	param.put("pln_yrwk", pln_yrwk);
	    	param.put("onf_hir_div_cd", onf_hir_div_cd);
	    	param.put("ecc_cd", ecc_cd);
	    	param.put("lease_term", lease_term);
	        
	    	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOCheckOnOffHirePlanCountRSQL(), param, null);
	        
	        if(dbRowset.next()){
	        	int k = dbRowset.getInt("coun");
	        	if(k == 0) {
	        		key = true;
	        	}
	        }
	
	    }catch (SQLException se) {
	        log.error(se.getMessage(), se);
	        throw new DAOException(new ErrorHandler(se).getMessage());
	    }catch (DAOException de) {
	        log.error(de.getMessage(), de);
	        throw de;
	    }catch (Exception e) {
	        log.error(e.getMessage(), e);
	        throw new DAOException(e.getMessage());
	    }
	    return key;
	}

    /**
     * 컨테이너 이송 실행 계획 조회/수정 On-Hire & Off-Hire (EES_EQR_081) DB에 반영한다.(추가, 수정, 삭제)<br>
      - EQR_ONF_HIR_PLN 입력
     * 
	 * @param eqrOnfHirPlnVO EqrOnfHirPlnVO
	 * @param user_id String
	 * @exception DAOException
	 */
	public void insertOnOffHirePlan(EqrOnfHirPlnVO eqrOnfHirPlnVO , String user_id)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.putAll(eqrOnfHirPlnVO.getColumnValues());
			param.put("user_id", user_id);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOInsertOnOffHirePlanCSQL(), param, null);
			
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
	}

    /**
     * 컨테이너 이송 실행 계획 조회/수정 On-Hire & Off-Hire (EES_EQR_081) DB에 반영한다.(추가, 수정, 삭제)<br>
      - EQR_ONF_HIR_PLN_QTY 입력
     * 
	 * @param  eqrOnfHirPlnQtyVO EqrOnfHirPlnQtyVO
	 * @param user_id String
	 * @exception DAOException
	 */
	public void insertOnOffHirePlanQty(EqrOnfHirPlnQtyVO eqrOnfHirPlnQtyVO , String user_id)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.putAll(eqrOnfHirPlnQtyVO.getColumnValues());
			param.put("user_id", user_id);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOInsertOnOffHirePlanQtyCSQL(), param, null);
			
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
	}

    /**
     * 컨테이너 이송 실행 계획 조회/수정 On-Hire & Off-Hire (EES_EQR_081) DB에 반영한다.(추가, 수정, 삭제)<br>
      - EQR_ONF_HIR_EXE_PLN 입력
     * 
	 * @param eqrOnfHirExePlnVO EqrOnfHirExePlnVO
	 * @param user_id String
	 * @exception DAOException
	 */
	public void insertOnOffHireExecute(EqrOnfHirExePlnVO eqrOnfHirExePlnVO , String user_id)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.putAll(eqrOnfHirExePlnVO.getColumnValues());
			param.put("user_id", user_id);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOInsertOnOffHireExecuteCSQL(), param, null);
			
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
	}

    /**
     * 컨테이너 이송 실행 계획 조회/수정 On-Hire & Off-Hire (EES_EQR_081) DB에 반영한다.(추가, 수정, 삭제)<br>
      - EQR_ONF_HIR_EXE_PLN_QTY 입력
     * 
	 * @param eqrOnfHirExePlnQtyVO EqrOnfHirExePlnQtyVO
	 * @param user_id String
	 * @exception DAOException
	 */
	public void insertOnOffHireExecuteQty(EqrOnfHirExePlnQtyVO eqrOnfHirExePlnQtyVO , String user_id)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.putAll(eqrOnfHirExePlnQtyVO.getColumnValues());
			param.put("user_id", user_id);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOInsertOnOffHireExecuteQtyCSQL(), param, null);
			
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
	}

    /**
     * 컨테이너 이송 실행 계획 조회/수정 On-Hire & Off-Hire (EES_EQR_081) DB에 반영한다.(추가, 수정, 삭제)<br>
      - EQR_ONF_HIR_EXE_PLN_QTY 수정
     * 
	 * @param eqrOnfHirExePlnQtyVO EqrOnfHirExePlnQtyVO
	 * @param user_id String
	 * @exception DAOException
	 */
	public void mergeOnOffHireExecuteQty(EqrOnfHirExePlnQtyVO eqrOnfHirExePlnQtyVO , String user_id)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.putAll(eqrOnfHirExePlnQtyVO.getColumnValues());
			param.put("user_id", user_id);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOMergeOnOffHireExecuteQtyCSQL(), param, null);
			
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
	}

    /**
     * 컨테이너 이송 실행 계획 조회/수정 On-Hire & Off-Hire (EES_EQR_081) DB에 반영한다.(추가, 수정, 삭제)<br>
      - EQR_ONF_HIR_EXE_PLN 수정
     * 
	 * @param eqrOnfHirExePlnVO EqrOnfHirExePlnVO
	 * @param user_id String
	 * @param soFlag String
	 * @exception DAOException
	 */
	public void updateOnOffHireExecute(EqrOnfHirExePlnVO eqrOnfHirExePlnVO , String user_id , String soFlag )throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.putAll(eqrOnfHirExePlnVO.getColumnValues());
			param.put("user_id", user_id);
			velParam.put("soFlag", soFlag);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOUpdateOnOffHireExecuteUSQL(), param, velParam);
			
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
	}

    /**
     * 컨테이너 이송 실행 계획 조회/수정 On-Hire & Off-Hire (EES_EQR_081) DB에 반영한다.(추가, 수정, 삭제)<br>
      - EQR_ONF_HIR_EXE_PLN 삭제
     * 
	 * @param eqrOnfHirExePlnVO EqrOnfHirExePlnVO
	 * @exception DAOException
	 */
	public void deleteOnOffHireExecute(EqrOnfHirExePlnVO eqrOnfHirExePlnVO)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.putAll(eqrOnfHirExePlnVO.getColumnValues());
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAODeleteOnOffHireExecuteDSQL(), param, null);
			
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
	}

    /**
     * 컨테이너 이송 실행 계획 조회/수정 On-Hire & Off-Hire (EES_EQR_081) DB에 반영한다.(추가, 수정, 삭제)<br>
      - EQR_ONF_HIR_EXE_PLN_QTY 삭제
     * 
	 * @param eqrOnfHirExePlnQtyVO EqrOnfHirExePlnQtyVO
	 * @exception DAOException
	 */
	public void deleteOnOffHireExecuteQty(EqrOnfHirExePlnQtyVO eqrOnfHirExePlnQtyVO)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.putAll(eqrOnfHirExePlnQtyVO.getColumnValues());
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAODeleteOnOffHireExecuteQtyDSQL(), param, null);
			
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
	}
	
	/**
	 * 컨테이너 이송실행계획 [0081] SO SEND 버튼 클릭시 EQR_EXE_PLN_CNTR 에서 컨테이너 정보 조회
	 *          
	 * @param eqrExePlnCntrVO EqrExePlnCntrVO
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	public CommonRsVO searchOnOffHireContainer( EqrExePlnCntrVO eqrExePlnCntrVO )	throws DAOException {
		CommonRsVO commonRsVO = new CommonRsVO();
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			param.putAll(eqrExePlnCntrVO.getColumnValues());
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOSearchOnOffHireContainerRSQL(), param, null);
			commonRsVO.setDbRowset(dbRowset);
	    }catch (SQLException se) {
	        log.error(se.getMessage(), se);
	        throw new DAOException(new ErrorHandler(se).getMessage());   
	    }catch (DAOException de) {
	        log.error(de.getMessage(), de);
	        throw de;
	    }catch (Exception e) {
	        log.error(e.getMessage(), e);
	        throw new DAOException(e.getMessage());
	    }
	    return commonRsVO;
	}

	/**
     * 컨테이너 이송실행계획 SO SEND 버튼 클릭시 EQR_REPO_EXE_SO_IF 테이블에 입 <br>
      - W/O Issue 테이블로 Execute중에 S/O Send 체크박스 클릭한 것만 입력?     <br>
      - S/O 테이블에 입력시 각 TYPE SIZE별 VOL갯수만큼 ROW를 생성해 줘야 할것임. <br>
      - EQR_REPO_EXE_SO_IF 테이블의 REF_SEQ는 REF_ID별로 1부터 시작해서 1씩 증가함. <br>
      
      INSERT : - EQR_REPO_EXE_SO_IF  입력 <br>
               - REF_SEQ는 REF_ID별로 1부터 시작해서 1씩 증가<br>
               - TPSZ TYPE 별 VOL만큼 ROW를 입력합니다.<br>
     *          
     * @param eqrRepoExeSoIfVO EqrRepoExeSoIfVO
     * @param user_id 	String
     * @exception DAOException
     */
	public void createOnOffHireSoData(EqrRepoExeSoIfVO eqrRepoExeSoIfVO , String user_id)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.putAll(eqrRepoExeSoIfVO.getColumnValues());
			param.put("user_id", user_id);
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOCreateOnOffHireSoDataCSQL(), param, null);
			
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
	}
	/**
     *- W/O Issue 테이블로 Execute중에 REF_ID별로 S/O Send 체크박스 클릭한 것만 삭제<br>
      - EQR_REPO_EXE_SO_IF 테이블의 REF_ID중에 WO_EXE_FLG 가 'Y'가 1개도 업어야 함  <br>           
		
	   DELETE : REF_ID 별로 위의 검색요건을 만족하면 삭제 수행 <br>
	           - EQR_REPO_EXE_SO_IF       삭제   ( 해당 REF_ID )<br>		
	           - EQR_EXE_PLN_CNTR         삭제   ( 해당 REF_ID )<br>
	           - EQR_ONF_HIR_EXE_PLN      삭제   ( 해당 REF_ID )<br>
	 *          
     * @param eqrRepoExeSoIfVO EqrRepoExeSoIfVO
     * @exception DAOException
     */
	public void deleteOnOffHireSoData(EqrRepoExeSoIfVO eqrRepoExeSoIfVO)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.putAll(eqrRepoExeSoIfVO.getColumnValues());
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAODeleteOnOffHireSoDataDSQL(), param, null);
			
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
	}
	/**
     *- W/O Issue 테이블로 Execute중에 REF_ID별로 S/O Send 체크박스 클릭한 것만 삭제<br>
      - EQR_REPO_EXE_SO_IF 테이블의 REF_ID중에 WO_EXE_FLG 가 'Y'가 1개도 업어야 함  <br>           
		
	   DELETE : REF_ID 별로 위의 검색요건을 만족하면 삭제 수행 <br>
	           - EQR_REPO_EXE_SO_IF       삭제   ( 해당 REF_ID )<br>		
	           - EQR_EXE_PLN_CNTR         삭제   ( 해당 REF_ID )<br>
	           - EQR_ONF_HIR_EXE_PLN      삭제   ( 해당 REF_ID )<br>
	 *          
     * @param eqrOnfHirExePlnVO EqrOnfHirExePlnVO
     * @param user_id 	String
     * @exception DAOException
     */
	public void updateInitOnOffHireExecute(EqrOnfHirExePlnVO  eqrOnfHirExePlnVO , String user_id)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.putAll(eqrOnfHirExePlnVO.getColumnValues());
			param.put("user_id", user_id);
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOUpdateInitOnOffHireExecuteUSQL(), param, null);
			
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
	}	
	/**
     * WRS-->TRS--> EQR 로 전해진 SO IF PLAN 정보 입력 
     * 대상테이블 : EQR_INLND_TRSP_PLN
     * <br>
     * modify by Lee Byoung Hun - 20090330
     * CSR NO : R200903270008
     * 메소드 내부에서 사용하지 않는 파라미터 삭제(tpsz_cd)
     * 
	 * @param eqrInlndTrspPlnVO EqrInlndTrspPlnVO
	 * @param user_id String
	 * @exception DAOException
	 */
	public void insertInlandWrsTrsSOIFPlan(EqrInlndTrspPlnVO eqrInlndTrspPlnVO , String user_id)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.putAll(eqrInlndTrspPlnVO.getColumnValues());
			param.put("user_id", user_id);
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOInsertInlandWrsTrsSOIFPlanCSQL(), param, null);
			
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
	}

	/**
     * WRS-->TRS--> EQR 로 전해진 SO IF PLAN 정보 입력 
     * 대상테이블 : EQR_INLND_TRSP_PLN_QTY
     * <br>
     * modify by Lee Byoung Hun - 20090330
     * CSR NO : R200903270008
     * 메소드 내부에서 사용하지 않는 파라미터 삭제(tpsz_cd)
     * 
	 * @param eqrInlndTrspPlnQtyVO EqrInlndTrspPlnQtyVO
	 * @param user_id String
	 * @exception DAOException
	 */
	public void insertInlandWrsTrsSOIFPlanQty(EqrInlndTrspPlnQtyVO eqrInlndTrspPlnQtyVO , String user_id)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.putAll(eqrInlndTrspPlnQtyVO.getColumnValues());
			param.put("user_id", user_id);
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOInsertInlandWrsTrsSOIFPlanQtyCSQL(), param, null);
			
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
	}

	/**
	 * TRS에서 1개씩 S/O 입력되는 것중에 동일 ROUTE로 이동하는 것은 N개로 집합 
	 * TRS --> EQR SO IF 중에 EQR_INLND_TRSP_EXE_PLN 테이블에 출발-도착 YARD 날짜가 같은 경우가 없는지 확인
	 * 존재하는 경우 REF ID를 리턴 
	 * 	 * 
	 * @param eqrInlndTrspExePlnVO EqrInlndTrspExePlnVO
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	public CommonRsVO checkInlandWrsTrsSOIFDuplicate(EqrInlndTrspExePlnVO eqrInlndTrspExePlnVO) throws DAOException {
		CommonRsVO commonRsVO = new CommonRsVO();
		DBRowSet dbRowset = null;
		String[] result = new String[2];
		result[0] = "";
		result[1] = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			param.putAll(eqrInlndTrspExePlnVO.getColumnValues());
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOCheckInlandWrsTrsSOIFDuplicateRSQL(), param, null);
			while(dbRowset.next()) {
				result[0] = dbRowset.getString("REF_ID");   // ref id
				result[1] = dbRowset.getString("PLN_SEQ");   // pln_seq
			}
			commonRsVO.setResultStrArray(result);
	    }catch (SQLException se) {
	        log.error(se.getMessage(), se);
	        throw new DAOException(new ErrorHandler(se).getMessage());   
	    }catch (DAOException de) {
	        log.error(de.getMessage(), de);
	        throw de;
	    }catch (Exception e) {
	        log.error(e.getMessage(), e);
	        throw new DAOException(e.getMessage());
	    }
	    return commonRsVO;
	}		

	/**
	 * TRS에서 1개씩 S/O 입력되는 것중에 동일 ROUTE로 이동하는 것은 N개로 집합 
	 * 
	 * 해당 REF ID 의 최대 REQ SEQ 를 구한다.
	 * 
	 * @param exe_dup_refid
	 * @return int
	 * @exception DAOException
	 */
	public int searchInlandWrsTrsSOIFRefSeq(String exe_dup_refid) throws DAOException {
		DBRowSet dbRowset = null;
		int result    = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("ref_id",exe_dup_refid);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOSearchInlandWrsTrsSOIFRefSeqRSQL(), param, null);
			while(dbRowset.next()) {
				result = dbRowset.getInt("REF_SEQ");   // ref id
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
		return result;
	}	
	/**
	 * TRS에서 1개씩 S/O 입력되는 것중에 동일 ROUTE로 이동하는 것은 N개로 집합 
     * WRS-->TRS--> EQR 로 전해진 SO IF EXECUTE 정보 qty 수정 혹은 입력 
     * 중복되는 execute가 존재한다고 파단되는 경우 사용되는 메소드 
     * 대상테이블 : EQR_INLND_TRSP_EXE_PLN
     * 
	 * @param eqrInlndTrspExePlnQtyVO EqrInlndTrspExePlnQtyVO
	 * @param user_id String
	 * @exception DAOException
	 */
    public void mergeInlandWrsTrsSOIFExecuteQty(EqrInlndTrspExePlnQtyVO eqrInlndTrspExePlnQtyVO , String user_id)throws DAOException {
    	//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.putAll(eqrInlndTrspExePlnQtyVO.getColumnValues());
			param.put("user_id", user_id);
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOMergeInlandWrsTrsSOIFExecuteQtyCSQL(), param, null);
			
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
    }
    
    /**
     * WRS-->TRS--> EQR 로 전해진 SO IF 정보 입력 
     * 대상테이블 : EQR_REPO_EXE_SO_IF
     * 
	 * @param eqrRepoExeSoIfVO EqrRepoExeSoIfVO
	 * @param user_id String
	 * @exception DAOException
	 */
    public void insertInlandWrsTrsSOIF(EqrRepoExeSoIfVO eqrRepoExeSoIfVO , String user_id)throws DAOException {
    	//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.putAll(eqrRepoExeSoIfVO.getColumnValues());
			
			param.put("past_repo_pln_flg", "N");
			param.put("user_id", user_id);
			param.put("co_cd", "O");
			param.put("wo_rqst_flg", "Y");
			param.put("trsp_so_sts_cd", "P");
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOInsertInlandWrsTrsSOIFCSQL(), param, null);
			
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
    }
    /**
     * SO IF 정보 조회 
     * 대상테이블 : EQR_REPO_EXE_SO_IF
     * 
	 * @param repo_pln_id
	 * @param pln_yrwk
	 * @param pln_seq
	 * @param ref_id
	 * @return DBRowSet
	 * @exception DAOException
	 */
    public DBRowSet searchInlandWrsTrsSOIF(String repo_pln_id, String pln_yrwk , String pln_seq , String ref_id) throws DAOException {
   	
    	DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("repo_pln_id",repo_pln_id);
			param.put("pln_yrwk",pln_yrwk);
			param.put("pln_seq",pln_seq);
			param.put("ref_id",ref_id);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOSearchInlandWrsTrsSOIFRSQL(), param, null);

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
		return dbRowset;
    }	 
    /**
     * WRS-->TRS--> EQR 로 전해진 SO IF EXECUTE 정보 입력 
     * 대상테이블 : EQR_INLND_TRSP_EXE_PLN
     * 
	 * @param eqrInlndTrspExePlnVO EqrInlndTrspExePlnVO
	 * @param user_id String
	 * @exception DAOException
	 */
    public void insertInlandWrsTrsSOIFExecute(EqrInlndTrspExePlnVO eqrInlndTrspExePlnVO , String user_id) throws DAOException {
    	//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.putAll(eqrInlndTrspExePlnVO.getColumnValues());
			param.put("upd_usr_id", user_id);
			param.put("cre_usr_id", user_id);
			param.put("repo_mty_bkg_flg",  "N");
			param.put("past_repo_pln_flg", "N");
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOInsertInlandWrsTrsSOIFExecuteCSQL(), param, null);
			
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
    }

    /**
     * WRS-->TRS--> EQR 로 전해진 SO IF EXECUTE 정보 입력 
     * 대상테이블 : EQR_INLND_TRSP_EXE_PLN_QTY
     * 
	 * @param eqrInlndTrspExePlnQtyVO EqrInlndTrspExePlnQtyVO
	 * @param user_id String
	 * @exception DAOException
	 */
    public void insertInlandWrsTrsSOIFExecuteQty(EqrInlndTrspExePlnQtyVO eqrInlndTrspExePlnQtyVO , String user_id) throws DAOException {
    	//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.putAll(eqrInlndTrspExePlnQtyVO.getColumnValues());
			param.put("user_id", user_id);
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOInsertInlandWrsTrsSOIFExecuteQtyCSQL(), param, null);
			
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
    }


	/**
	 * CntrRepoExecutionPlanEstablish의 모든 목록을 가져온다.<br>
	 * 
	 * @param job_cd  String
	 * @param user_id String
	 * @return List<SearchSendHistoryVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public  List<SearchSendHistoryVO> searchFAXSenderHistory(String job_cd , String user_id) throws DAOException {
  		
		DBRowSet dbRowset = null;
		List<SearchSendHistoryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("rd_appl_cd",job_cd);
			param.put("user_id",user_id);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOSearchFAXSendHistoryRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSendHistoryVO.class);
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
		return list;
    	
	}
	/**
	 * CntrRepoExecutionPlanEstablish의 모든 목록을 가져온다.<br>
	 * 
	 * @param job_cd  String
	 * @param user_id String
	 * @return List<SearchSendHistoryVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public  List<SearchSendHistoryVO> searchMAILSenderHistory(String job_cd , String user_id) throws DAOException {
  		
		DBRowSet dbRowset = null;
		List<SearchSendHistoryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("rd_appl_cd",job_cd);
			param.put("user_id",user_id);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOSearchMAILSendHistoryRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSendHistoryVO.class);
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
		return list;
    	
	}
	/**
	 * 컨테이너 이송 실행 계획 조회/수정 Shuttle (EES_EQR_083) 정보 조회
	 * 
	 * @param eesEqr0059ConditionVO
	 * @param account SignOnUserAccount
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CommonRsVO searchShuttleCntrRepoPlan(EesEqr0059ConditionVO eesEqr0059ConditionVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String offCd = account.getOfc_cd();
		
		String repoPlanID = eesEqr0059ConditionVO.getRepoPlnId();
		String fromWeek   = eesEqr0059ConditionVO.getFmplnyr()+eesEqr0059ConditionVO.getFmplnwk();
		String toWeek     = eesEqr0059ConditionVO.getToplnyr()+eesEqr0059ConditionVO.getToplnwk();
		
		String tpsz     = eesEqr0059ConditionVO.getTpsz();      // TYPE SIZE 종류(ALL, DRY, RFR...)
		String tpsztype = eesEqr0059ConditionVO.getTpsztype();  // TYPE SIZE 선택값
		List tpszArr= 	Utils.replaceStrToList(tpsztype);//tpsztype.split(",");
		
		String fmtoat      = eesEqr0059ConditionVO.getFmtoat();
		String fromStatus  = eesEqr0059ConditionVO.getFromstatus();
		String toStatus    = eesEqr0059ConditionVO.getTostatus();
		String atStatus    = eesEqr0059ConditionVO.getAtstatus();
		
		String itemname = eesEqr0059ConditionVO.getItemname();
		String sosend   = eesEqr0059ConditionVO.getSosend();
		
		String userECC	= eesEqr0059ConditionVO.getUserEcc();
		String fromECC	= eesEqr0059ConditionVO.getFromEcc();
		String toECC	= eesEqr0059ConditionVO.getToEcc();
		String fromLoc		= eesEqr0059ConditionVO.getFromlocation();
		String toLoc		= eesEqr0059ConditionVO.getTolocation();
		
				
	    // 조건값 셋팅 변수 
		String userLocStrArr	= "";
		String fromLocStrArr	= "";
		String toLocStrArr		= "";
		String tpszStrArr		= "";
		String itemnameStrArr	= "";
		

		
		// user location 검색조건 ('','',''.....)
		if(!userECC.equals("")) {
			userLocStrArr = Utils.convertStr(userECC, true);
		}

        
		// from location 검색조건 ('','',''.....)
        // CSR No : N200906040080 의거 변경 
		// fmtoat.equals("3") : Fm ETD
		// fmtoat.equals("4") : To ETA
		//if((fmtoat.equals("1") || fmtoat.equals("2")) && (!fromStatus.equals("") || !atStatus.equals(""))) {
		if((fmtoat.equals("1") || fmtoat.equals("2") || fmtoat.equals("3") || fmtoat.equals("4")) && (!fromStatus.equals("") || !atStatus.equals(""))) {
			fromLocStrArr = Utils.convertStr(fromECC, true);
		}
		
		// to location 검색조건 ('','',''.....)
        // CSR No : N200906040080 의거 변경 
		// fmtoat.equals("3") : Fm ETD
		// fmtoat.equals("4") : To ETA
		//if(fmtoat.equals("1") && !toStatus.equals("")) { --원본 
		if((fmtoat.equals("1") || fmtoat.equals("3") || fmtoat.equals("4")) && !toStatus.equals("")) {	
			toLocStrArr = Utils.convertStr(toECC, true);
		}    	
		
	    // TP/SZ 에 따른 조건값을 넣어 준다.
	    if(!tpsz.equals("") && !tpsztype.equals("")) {
	    	tpszStrArr = Utils.convertStr(tpsztype, true);
		}    		
	
	    // ITEM 에 따른 조건값을 넣어 준다.
	    if(!itemname.equals("")) {
	    	itemnameStrArr = Utils.convertStr(itemname, true);
		}    
	    try {
			param.put("repoPlanID",repoPlanID);
			param.put("fromWeek",fromWeek);
			param.put("toWeek",toWeek);
			param.put("sosend",sosend);
			param.put("from_loc", fromLoc);
			param.put("to_loc", toLoc);
			param.put("off_cd", offCd);
			
			velParam.put("repoPlanID",repoPlanID);
			velParam.put("fromWeek",fromWeek);
			velParam.put("toWeek",toWeek);
			velParam.put("sosend",sosend);
			velParam.put("userECC", userECC);
			velParam.put("userLocStrArr", userLocStrArr);
			velParam.put("fmtoat", fmtoat);
			velParam.put("fromStatus", fromStatus);
			velParam.put("fromLocStrArr", fromLocStrArr);
			velParam.put("fromECC", fromECC);
			velParam.put("toECC", toECC);
			velParam.put("toLocStrArr", toLocStrArr);			
			velParam.put("tpsz", tpsz);
			velParam.put("tpsztype", tpsztype);
			velParam.put("tpszStrArr", tpszStrArr);
			velParam.put("itemname", itemname);
			velParam.put("itemnameStrArr", itemnameStrArr);
			velParam.put("fromECC", fromECC);
			velParam.put("tpszArr", tpszArr);
			velParam.put("atStatus", atStatus);
			velParam.put("toStatus", toStatus);
			velParam.put("from_loc", fromLoc);
			velParam.put("to_loc", toLoc);
			velParam.put("off_cd", offCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOSearchShuttleCntrRepoPlanRSQL(), param, velParam);
			commonRsVO.setDbRowset(dbRowset);

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
		
		return commonRsVO;
	    
	}
	/**
     * 컨테이너 이송 실행 계획 조회/수정 Shuttle (EES_EQR_083) DB에 반영한다.(추가, 수정, 삭제)<br>
      INSERT : - REF_ID 생성
               - EQR_ECC_INTER_EXE_PLN      입력
     * 
	 * @param eqrEccInterExePlnVO EqrEccInterExePlnVO
	 * @param user_id String
	 * @exception DAOException
	 */
	public void insertShuttleCntrRepoPlan(EqrEccInterExePlnVO eqrEccInterExePlnVO , String user_id )throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.putAll(eqrEccInterExePlnVO.getColumnValues());
			param.put("user_id", user_id);
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOInsertShuttleCntrRepoPlanCSQL(), param, null);
			
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
	}
	
	/**
     * 컨테이너 이송 실행 계획 조회/수정 Shuttle (EES_EQR_083) DB에 반영한다.(추가, 수정, 삭제)<br>
      INSERT : - REF_ID 생성
               - EQR_ECC_INTER_EXE_PLN_QTY      입력
     * 
	 * @param eqrEccInterExePlnQtyVO EqrEccInterExePlnQtyVO
	 * @param user_id String
	 * @exception DAOException
	 */
	public void insertShuttleCntrRepoPlanQty(EqrEccInterExePlnQtyVO eqrEccInterExePlnQtyVO , String user_id  )throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.putAll(eqrEccInterExePlnQtyVO.getColumnValues());
			param.put("user_id", user_id);
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOInsertShuttleCntrRepoPlanQtyCSQL(), param, null);
			
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
	}

	/**
     * 컨테이너 이송 실행 계획 조회/수정 Shuttle (EES_EQR_083) DB에 반영한다.(추가, 수정, 삭제)<br>
               
      MERGE : - EQR_ECC_INTER_EXE_PLN_QTY      VOL 수정 / 입력
     * 
	 * @param eqrEccInterExePlnQtyVO EqrEccInterExePlnQtyVO
	 * @param user_id String
	 * @param soFlag String
	 * @exception DAOException
	 */
	public void mergeShuttleCntrRepoPlan(EqrEccInterExePlnQtyVO eqrEccInterExePlnQtyVO , String user_id , String soFlag)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.putAll(eqrEccInterExePlnQtyVO.getColumnValues());
			param.put("user_id", user_id);
			velParam.put("soFlag", soFlag);
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOMergeShuttleCntrRepoPlanCSQL(), param, velParam);
			
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
	}

	/**
     * 컨테이너 이송 실행 계획 조회/수정 Shuttle (EES_EQR_083) DB에 반영한다.(추가, 수정, 삭제)<br>
      UPDATE : - EQR_ECC_INTER_EXE_PLN      VOL이외의 정보 수정  

	 * @param eqrEccInterExePlnVO EqrEccInterExePlnVO
	 * @param user_id String
	 * @param soFlag String
	 * @exception DAOException
	 */
	public void updateShuttleCntrRepoPlan(EqrEccInterExePlnVO eqrEccInterExePlnVO , String user_id ,  String soFlag )throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.putAll(eqrEccInterExePlnVO.getColumnValues());
			param.put("user_id", user_id);
			velParam.put("soFlag", soFlag);
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOUpdateShuttleCntrRepoPlanUSQL(), param, velParam);
			
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
	}

	/**
     * 컨테이너 이송 실행 계획 조회/수정 Shuttle (EES_EQR_083) DB에 반영한다.(추가, 수정, 삭제)<br>
      DELETE : - EQR_EXE_PLN_CNTR 			삭제 
     * 
	 * @param eqrEccInterExePlnVO EqrEccInterExePlnVO
	 * @exception DAOException
	 */
	public void deleteShuttleCntrRepoPlan(EqrEccInterExePlnVO eqrEccInterExePlnVO )throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.putAll(eqrEccInterExePlnVO.getColumnValues());
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAODeleteShuttleCntrRepoPlanDSQL(), param, null);
			
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
	}

	/**
     * 컨테이너 이송 실행 계획 조회/수정 Shuttle (EES_EQR_083) DB에 반영한다.(추가, 수정, 삭제)<br>
      DELETE : - EQR_EXE_PLN_CNTR_QTY 			삭제 
     * 
	 * @param eqrEccInterExePlnQtyVO EqrEccInterExePlnQtyVO
	 * @exception DAOException
	 */
	public void deleteShuttleCntrRepoPlanQty(EqrEccInterExePlnQtyVO eqrEccInterExePlnQtyVO )throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.putAll(eqrEccInterExePlnQtyVO.getColumnValues());
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAODeleteShuttleCntrRepoPlanQtyDSQL(), param, null);
			
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
	}
	/**
	 * 컨테이너 이송실행계획 SO SEND 버튼 클릭시 EQR_REPO_EXE_SO_IF 테이블에 입력 <br>
	  - W/O Issue 테이블로 Execute중에 S/O Send 체크박스 클릭한 것만 입력     <br>
	  - S/O 테이블에 입력시 각 TYPE SIZE별 VOL갯수만큼 ROW를 생성해 줘야 할것임. <br>
	  - EQR_REPO_EXE_SO_IF 테이블의 REF_SEQ는 REF_ID별로 1부터 ??작해서 1씩 증가함. <br>
	
	  INSERT : - EQR_REPO_EXE_SO_IF  입력 <br>
	           - REF_SEQ는 REF_ID별로 1부터 시작해서 1씩 증가<br>
	           - TPSZ TYPE 별 VOL만큼 ROW를 입력합니다.<br>
	 *          
	 * @param eqrExePlnCntrVO EqrExePlnCntrVO
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	public CommonRsVO searchEccInternalContainer(EqrExePlnCntrVO eqrExePlnCntrVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.putAll(eqrExePlnCntrVO.getColumnValues()); // pln_seq 는 기본값 0 으로 셋팅하여 받는다. 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOSearchEccInternalContainerRSQL(), param, null);
			commonRsVO.setDbRowset(dbRowset);

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
		
		return commonRsVO;
	}
	/**
	 * 컨테이너 이송실행계획 SO SEND 버튼 클릭시 EQR_REPO_EXE_SO_IF 테이블에 입력 <br>
	  - W/O Issue 테이블로 Execute중에 S/O Send 체크박스 클릭한 것만 입력     <br>
	  - S/O 테이블에 입력시 각 TYPE SIZE별 VOL갯수만큼 ROW를 생성해 줘야 할것임. <br>
	  - EQR_REPO_EXE_SO_IF 테이블의 REF_SEQ는 REF_ID별로 1부터 ??작해서 1씩 증가함. <br>
	
	  INSERT : - EQR_REPO_EXE_SO_IF  입력 <br>
	           - REF_SEQ는 REF_ID별로 1부터 시작해서 1씩 증가<br>
	           - TPSZ TYPE 별 VOL만큼 ROW를 입력합니다.<br>
	 *          
	 * @param eqrRepoExeSoIfVO EqrRepoExeSoIfVO
	 * @param user_id String
	 * @exception DAOException
	 */
	public void createEccInternalSoData(EqrRepoExeSoIfVO eqrRepoExeSoIfVO , String user_id) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.putAll(eqrRepoExeSoIfVO.getColumnValues()); // pln_seq 는 기본값 0 으로 셋팅하여 받는다. 
			param.put("user_id", user_id);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOCreateEccInternalSoDataCSQL(), param, null);
			

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
	}
	/**
     *- W/O Issue 테이블로 Execute중에 REF_ID별로 S/O Send 체크박스 클릭한 것만 삭제<br>
      - EQR_REPO_EXE_SO_IF 테이블의 REF_ID중에 WO_EXE_FLG 가 'Y'가 1개도 업어야 함  <br>           
		
	   DELETE : REF_ID 별로 위의 검색요건을 만족하면 삭제 수행 <br>
	           - EQR_REPO_EXE_SO_IF       삭제   ( 해당 REF_ID )<br>	
	 *          
     * @param eqrRepoExeSoIfVO EqrRepoExeSoIfVO
     * @exception DAOException
    */
	public void deleteShuttleSoData(EqrRepoExeSoIfVO eqrRepoExeSoIfVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.putAll(eqrRepoExeSoIfVO.getColumnValues()); // pln_seq 는 기본값 0 으로 셋팅하여 받는다. 
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAODeleteShuttleSoDataDSQL(), param, null);
			

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
	}

	/**
     *- W/O Issue 테이블로 Execute중에 REF_ID별로 S/O Send 체크박스 클릭한 것만 삭제<br>
      - EQR_REPO_EXE_SO_IF 테이블의 REF_ID중에 WO_EXE_FLG 가 'Y'가 1개도 업어야 함  <br>           
		
	   DELETE : REF_ID 별로 위의 검색요건을 만족하면 삭제 수행 <br>
	           - EQR_ECC_INTER_EXE_PLN    수정   ( 해당 REF_ID )) EXE_ISS_FLG , EXE_RQST_DT null 로 업데이트<br>
	 *          
     * @param eqrEccInterExePlnVO EqrEccInterExePlnVO
     * @param user_id String
     * @exception DAOException
    */
	public void deleteShuttleExecute(EqrEccInterExePlnVO eqrEccInterExePlnVO , String user_id) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.putAll(eqrEccInterExePlnVO.getColumnValues()); 
			param.put("user_id", user_id);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAODeleteShuttleExecuteDSQL(), param, null);
			

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
	}

	/**
     *- W/O Issue 테이블로 Execute중에 REF_ID별로 S/O Send 체크박스 클릭한 것만 삭제<br>
      - EQR_REPO_EXE_SO_IF 테이블의 REF_ID중에 WO_EXE_FLG 가 'Y'가 1개도 업어야 함  <br>           
		
	   DELETE : REF_ID 별로 위의 검색요건을 만족하면 삭제 수행 <br>
	           - EQR_ECC_INTER_EXE_PLN    수정   ( 해당 REF_ID )) EXE_ISS_FLG , EXE_RQST_DT null 로 업데이트<br>
	 *          
     * @param eqrEccInterExePlnQtyVO EqrEccInterExePlnQtyVO
     * @param user_id String
     * @exception DAOException
    */
	public void deleteShuttleExecuteQty(EqrEccInterExePlnQtyVO eqrEccInterExePlnQtyVO , String user_id) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.putAll(eqrEccInterExePlnQtyVO.getColumnValues()); 
			param.put("user_id", user_id);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAODeleteShuttleExecuteQtyDSQL(), param, null);
			

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
	}
	
	/**
	 * [ EES_EQR_0112 : Forecasted Land Inventory ]<br>
	 * 
	 * @param eesEqr0112ConditionVO EesEqr0112ConditionVO
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	public CommonRsVO searchLocalForecastedLandInv(EesEqr0112ConditionVO eesEqr0112ConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<CommonVO> tpszArr = new ArrayList<CommonVO>();
		
		try{
			if(eesEqr0112ConditionVO != null){
				Map<String, String> mapVO = eesEqr0112ConditionVO .getColumnValues();
				
				String tpsztype = eesEqr0112ConditionVO.getCntrtpszcd();
				String tpszText = Utils.convertStr(tpsztype);
				String laneText = Utils.convertStr(eesEqr0112ConditionVO.getLane());
				String vvdText	= Utils.convertStr(eesEqr0112ConditionVO.getVvd());
				String itemText	= Utils.convertStr(eesEqr0112ConditionVO.getItem());
				String eccText	= Utils.convertStr(eesEqr0112ConditionVO.getEcccd());
				List<String> arrtpsz =  Utils.replaceStrToList(tpsztype);
				String fm_plnyrwk = eesEqr0112ConditionVO.getFmplnyr() + eesEqr0112ConditionVO.getFmplnwk();
				String to_plnyrwk = eesEqr0112ConditionVO.getToplnyr() + eesEqr0112ConditionVO.getToplnwk();
				String repo_pln_id = Constants.REPO_WORD+eesEqr0112ConditionVO.getYyyyww()+Constants.REPO_WEEK+eesEqr0112ConditionVO.getSeq();
				
				String typeStr = Utils.locationType(eesEqr0112ConditionVO.getType());
				String typeByStr = Utils.locationType(eesEqr0112ConditionVO.getTypeby());
				String itemOffExist = ( eesEqr0112ConditionVO.getItem().indexOf("F") != -1 ) ? "Y" : "N";
				String itemOnExist = ( eesEqr0112ConditionVO.getItem().indexOf("O") != -1 ) ? "Y" : "N";
				
				param.putAll(mapVO);
				param.put("fm_plnyrwk", fm_plnyrwk);
				param.put("to_plnyrwk", to_plnyrwk);
				param.put("repo_pln_id", repo_pln_id);
				
				velParam.putAll(mapVO);
				velParam.put("arrtpsz", arrtpsz);
				velParam.put("tpszText", tpszText);
				velParam.put("laneText", laneText);
				velParam.put("vvdText", vvdText);
				velParam.put("itemText", itemText);
				velParam.put("eccText", eccText);
				velParam.put("tpszArr", tpszArr);
				velParam.put("type", typeStr);
				velParam.put("typeByStr", typeByStr);
				velParam.put("itemOffExist", itemOffExist);
				velParam.put("itemOnExist", itemOnExist);
				velParam.put("repo_pln_id", repo_pln_id);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOSearchLocalFcstLandInvRSQL(), param, velParam);
			commonRsVO.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonRsVO;
	}
	/**
	 * [ EES_EQR_0092 : Total ]<br>
	 * 
	 * @param eesEqr0059ConditionVO EesEqr0059ConditionVO 
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CommonRsVO searchTotalCntrRepoPlan(EesEqr0059ConditionVO eesEqr0059ConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<CommonVO> tpszArr = new ArrayList<CommonVO>();
		
		try{
			if(eesEqr0059ConditionVO != null){
				Map<String, String> mapVO = eesEqr0059ConditionVO .getColumnValues();
								
				String tpsztype = eesEqr0059ConditionVO.getTpsztype();
				String tpszText = Utils.convertStr(tpsztype);
				String laneText = Utils.convertStr(eesEqr0059ConditionVO.getLane());
				String itemText	= Utils.convertStr(eesEqr0059ConditionVO.getItemname());
				String reasonText = Utils.convertStr(eesEqr0059ConditionVO.getReason());
				String vvdText	= Utils.convertStr(eesEqr0059ConditionVO.getVvd());
				ArrayList arrtpsz = (ArrayList) Utils.replaceStrToList(tpsztype);
				ArrayList arrtpsz2= (ArrayList) Utils.convertTpsz(tpsztype);
				String fm_plnyrwk = eesEqr0059ConditionVO.getFmplnyr() + eesEqr0059ConditionVO.getFmplnwk();
				String to_plnyrwk = eesEqr0059ConditionVO.getToplnyr() + eesEqr0059ConditionVO.getToplnwk();
				
				String userEccText	= Utils.convertStr(eesEqr0059ConditionVO.getUserEcc(), true);
				String fromEccText	= Utils.convertStr(eesEqr0059ConditionVO.getFromEcc(), true);
				String toEccText	= Utils.convertStr(eesEqr0059ConditionVO.getToEcc(), true);
				
				String userEcc		= eesEqr0059ConditionVO.getUserEcc();
				String fromEcc		= eesEqr0059ConditionVO.getFromEcc();
				String toEcc		= eesEqr0059ConditionVO.getToEcc();
				
				for(int i = 0 ; i < arrtpsz.size() ; i++){
					CommonVO commonVO = new CommonVO();
					commonVO.setField1((String) arrtpsz.get(i));
					commonVO.setField2((String) arrtpsz2.get(i));
					tpszArr.add(commonVO);
				}
				param.putAll(mapVO);
				param.put("fm_plnyrwk", fm_plnyrwk);
				param.put("to_plnyrwk", to_plnyrwk);
				velParam.putAll(mapVO);
				velParam.put("arrtpsz", arrtpsz);
				velParam.put("tpszText", tpszText);
				velParam.put("laneText", laneText);
				velParam.put("itemText", itemText);
				velParam.put("reasonText", reasonText);
				velParam.put("vvdText", vvdText);
				velParam.put("tpszArr", tpszArr);
				velParam.put("userEccText", userEccText);
				velParam.put("fromEccText", fromEccText);
				velParam.put("toEccText", toEccText);
				velParam.put("userEcc", userEcc);
				velParam.put("fromEcc", fromEcc);
				velParam.put("toEcc", toEcc);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOSearchTotalCntrRepoPlanRSQL(), param, velParam, true);
			commonRsVO.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonRsVO;
	}
	/**
	 * added by ChungEunHo 09.10.15
	 * TRS에서 S/O 생성/수정/삭제시 EQR_REPO_EXE_SO_IF 테이블에 S/O상태 Field를 UPDATE
     * 
	 * @param singleTransportationVO SingleTransportationVO
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean modifyFromTrsSOIFPlanSoSts( SingleTransportationVO singleTransportationVO) throws DAOException {
		boolean retVal = false;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.putAll(singleTransportationVO.getColumnValues());
			int updcnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOModifyFromTrsSOIFPlanSoStsUSQL(), param, null);
			if(updcnt > 0){
				retVal = true;
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retVal;
	}
	/**
	 * added by ChungEunHo 09.10.21
	 * Off Hire 직반납 기존 데이터 조회 EQR_ONF_HIR_EXE_PLN
	 * @param vo ModifyFromTrsOffHireReturnVO
	 * @return SearchEqrOnfHirExePlnByOffHireReturnVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public SearchEqrOnfHirExePlnByOffHireReturnVO searchEqrOnfHirExePlnByOffHireReturn(ModifyFromTrsOffHireReturnVO vo)throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchEqrOnfHirExePlnByOffHireReturnVO> list = null;
		SearchEqrOnfHirExePlnByOffHireReturnVO retVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.putAll(vo.getColumnValues());
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOSearchEqrOnfHirExePlnByOffHireReturnRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchEqrOnfHirExePlnByOffHireReturnVO.class);
			
			if(list != null && list.size() > 0){
				retVO = list.get(0);
			}
			return retVO;
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * added by ChungEunHo 09.10.21
	 * Off Hire 직반납 기존 데이터 조회 EQR_ONF_HIR_EXE_PLN
	 * @param vo ModifyFromTrsOffHireReturnVO
	 * @return EqrOnfHirExePlnQtyVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public EqrOnfHirExePlnQtyVO searchEqrOnfHirExePlnQtyByOffHireReturn(ModifyFromTrsOffHireReturnVO vo)throws DAOException {
		DBRowSet dbRowset = null;
		List<EqrOnfHirExePlnQtyVO> list = null;
		EqrOnfHirExePlnQtyVO retVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.putAll(vo.getColumnValues());
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOSearchEqrOnfHirExePlnQtyByOffHireReturnRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EqrOnfHirExePlnQtyVO.class);
			
			if(list != null && list.size() > 0){
				retVO = list.get(0);
			}
			return retVO;
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * added by ChungEunHo 09.10.21
	 * Off Hire 직반납 기존 데이터 조회 EQR_REPO_EXE_SO_IF
	 * @param vo ModifyFromTrsOffHireReturnVO
	 * @return List<EqrRepoExeSoIfVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EqrRepoExeSoIfVO> searchEqrRepoExeSoIfByOffHireReturn(ModifyFromTrsOffHireReturnVO vo)throws DAOException {
		DBRowSet dbRowset = null;
		List<EqrRepoExeSoIfVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{

			param.putAll(vo.getColumnValues());
			velParam.put("oldRefSeqList", vo.getOldRefSeqList());
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOSearchEqrRepoExeSoIfByOffHireReturnRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EqrRepoExeSoIfVO.class);
			
			return list;
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * added by ChungEunHo 09.11.24
	 * Off Hire 직반납 중복 데이터 조회 EQR_ONF_HIR_EXE_PLN , EQR_ONF_HIR_EXE_PLN_QTY
	 * @param vo EqrOnfHirExePlnVO
	 * @return String[]
	 * @exception DAOException
	 */
	public String[] checkDuplicateOnfHirExePlnByOffHireReturn(EqrOnfHirExePlnVO vo )throws DAOException {
		DBRowSet dbRowset = null;
		String[] retVal = new String[2];
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{

			param.putAll(vo.getColumnValues());
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOCheckDuplicateOnfHirExePlnByOffHireReturnRSQL(), param, null);
			retVal[0] = "NaN";
			retVal[1] = "-1";
			
			if(dbRowset.next()){
				retVal[0] = dbRowset.getString("REF_ID");
				retVal[1] = dbRowset.getString("REF_SEQ");
			}
			
			return retVal;
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * added by ChungEunHo 09.11.24
	 * Off Hire 직반납 중복 데이터 조회 EQR_ONF_HIR_EXE_PLN , EQR_ONF_HIR_EXE_PLN_QTY
	 * @param vo EqrOnfHirExePlnVO
	 * @param cntrTpSz String
	 * @return String[]
	 * @exception DAOException
	 */
	public String[] checkDuplicateOnfHirExePlnQtyByOffHireReturn(EqrOnfHirExePlnVO vo , String cntrTpSz)throws DAOException {
		DBRowSet dbRowset = null;
		String[] retVal = new String[2];
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{

			param.putAll(vo.getColumnValues());
			param.put("cntr_tpsz_cd", cntrTpSz);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOCheckDuplicateOnfHirExePlnQtyByOffHireReturnRSQL(), param, null);
			retVal[0] = "NaN";
			retVal[1] = "0";
			
			if(dbRowset.next()){
				retVal[0] = dbRowset.getString("REF_ID");
				retVal[1] = dbRowset.getString("CNTR_QTY");
			}
			
			return retVal;
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * added by ChungEunHo 09.11.24
	 * Off Hire 직반납 관련 동일 ECC CHECK
	 * @param String fmYdCd
	 * @param String toYdCd
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean checkIdenticalEcc(String fmYdCd , String toYdCd)throws DAOException {
		DBRowSet dbRowset = null;
		boolean retVal = false;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{

			param.put("fm_yd_cd", fmYdCd);
			param.put("to_yd_cd", toYdCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOCheckIdenticalEccRSQL(), param, null);
			
			if(dbRowset.next()){
				int checkcnt = dbRowset.getInt(1);
				if(checkcnt > 0){
					retVal = true;
				}
			}
			
			return retVal;
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
	}	

	/**
	 * added by ChungEunHo 09.10.21
	 * Off Hire 직반납 기존 데이터 삭제 EQR_ONF_HIR_EXE_PLN_QTY
	 * tpsz 내의 전량 이동시 삭제함
	 * @param vo ModifyFromTrsOffHireReturnVO
	 * @exception DAOException
	 */
	public void deleteEqrOnfHirExePlnQtyByCntrTpSz(ModifyFromTrsOffHireReturnVO vo)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.putAll(vo.getColumnValues());
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAODeleteEqrOnfHirExePlnQtyByCntrTpSzDSQL(), param, null);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * added by ChungEunHo 09.10.21
	 * Off Hire 직반납 기존 데이터 삭제 EQR_ONF_HIR_EXE_PLN_QTY
	 * tpsz 내의 전량 이동시 삭제함
	 * @param vo EqrOnfHirExePlnQtyVO
	 * @param user_id
	 * @exception DAOException
	 */
	public void modifyCntrQtyOfEqrOnfHirExePlnQty(EqrOnfHirExePlnQtyVO vo , String user_id)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.putAll(vo.getColumnValues());
			param.put("user_id", user_id);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOModifyCntrQtyOfEqrOnfHirExePlnQtyUSQL(), param, null);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	

	/**
	 * added by ChungEunHo 09.10.21
	 * Off Hire 직반납 기존 데이터 수정 EQR_REPO_EXE_SO_IF
	 * 
	 * @param EqrRepoExeSoIfVO vo
	 * @param String new_ref_id
	 * @param String user_id
	 * @param String old_ref_seq
	 * @exception DAOException
	 */
	public void modifyFromTRSEqrRepoExeSoIf(EqrRepoExeSoIfVO vo , String new_ref_id , String user_id , String old_ref_seq)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.putAll(vo.getColumnValues());
			param.put("user_id", user_id);
			param.put("new_ref_id", new_ref_id);
			param.put("old_ref_seq", old_ref_seq);
			//param.put("chk_cntr_no", vo.getCntrNo());
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOModifyFromTRSEqrRepoExeSoIfUSQL(), param, null);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * added by ChungEunHo 09.10.21
	 * Off Hire 직반납 기존 데이터 ref_id 수정 EQR_EXE_PLN_CNTR
	 * 
	 * @param vo ModifyFromTrsOffHireReturnVO
	 * @param new_ref_id String
	 * @param user_id String
	 * @exception DAOException
	 */
	public void modifyFromTRSEqrExePlnCntr(ModifyFromTrsOffHireReturnVO vo, String new_ref_id , String user_id)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.putAll(vo.getColumnValues());
			param.put("user_id", user_id);
			param.put("new_ref_id", new_ref_id);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOModifyFromTRSEqrExePlnCntrUSQL(), param, null);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * EQR All-Weeks' Plan Access Grant 조회 이벤트 처리<br>
	 * 
	 * @return List<SearchEqrAllWeeksPlanAccessGrantVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchEqrAllWeeksPlanAccessGrantVO> searchEqrAllWeeksPlanAccessGrant() throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchEqrAllWeeksPlanAccessGrantVO> list = null;

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOSearchEqrAllWeeksPlanAccessGrantRSQL(), null, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchEqrAllWeeksPlanAccessGrantVO .class);
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
	 * 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * EQR All-Weeks' Plan Access Grant 수정<br>
	 * 
	 * @param List<EesEqr0143MultiVO> updModels
	 * @exception DAOException
	 */
	public void mergeEqrAllWeeksPlanAccessGrant(List<EesEqr0143MultiVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOMergeEqrAllWeeksPlanAccessGrantCSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
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
	 * 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * EQR All-Weeks' Plan Access Grant 삭제<br>
	 * 
	 * @param delModels List<EqrShrtTermOnhCondVO>
	 * @exception DAOException
	 */
	public void deleteEqrAllWeeksPlanAccessGrant(List<EesEqr0143MultiVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAODeleteEqrAllWeeksPlanAccessGrantDSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
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
	 * LOC Yard combo box 정보를 검색<br>
	 * 
	 * @param locyard_searchword String
	 * @return CommonVO
	 * @see EesCommonEvent
	 * @exception DAOException	 
	*/
public CommonVO searchLocYardInfo(String locyard_searchword) throws DAOException {
		
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String[] result     = new String[2];
		StringBuffer inStr  = new StringBuffer();	
		StringBuffer inStr1	= new StringBuffer();
		int j			= 0;
		
		// 5개 이상인 경우 잘라서 표현
		if(locyard_searchword.length() > 5) {			
			locyard_searchword = locyard_searchword.substring(0,5);
		}

		
		try {
			velParam.put("locyard_searchword", locyard_searchword);
			
			dbRowset = new SQLExecuter().executeQuery((ISQLTemplate)new CommonDBDAOSearchLocYardInfoRSQL(), null, velParam);
			
			while(dbRowset.next()) {
				inStr.append( ((j == 0) ? "" : "|") + dbRowset.getString("YD_CD").replaceAll("&","&amp;")+" \t " + dbRowset.getString("YD_NM").replaceAll("&","&amp;"));   // NAME
				inStr1.append(((j == 0) ? "" : "|") + dbRowset.getString("YD_CD"));                                                               // CODE
				j++;
			}
			
			result[0] = inStr.toString();
			result[1] = inStr1.toString();
			retVO.setResultStrArray(result);

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
		
		return retVO;
	}


	/**
	 * EES_EQR_0059_POP : retrieve <br>
	 * EES EQR 조회합니다.<br>	 
	 * @author Park Young Jin
	 * @category EES_EQR_0059_POP
	 * @category searchInlandRouteListData     
	 * @param SearchInlandRouteVO searchInlandRouteVO
	 * @return List<SearchInlandRouteVO> 
	 * @throws DAOException, Exception
	 */
	@SuppressWarnings("unchecked")
	public List<SearchInlandRouteVO> searchInlandRouteListData(SearchInlandRouteVO searchInlandRouteVO) throws DAOException,Exception {
		  	
		DBRowSet dbRowset = null;
		List<SearchInlandRouteVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(searchInlandRouteVO != null){
				
				Map<String, String> mapVO = searchInlandRouteVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				param.put("fm_yd_cd", searchInlandRouteVO.getFmYdCd());
		        velParam.put("to_yd_cd", searchInlandRouteVO.getToYdCd());
		        
		        param.put("fm_yd_cd", searchInlandRouteVO.getFmYdCd());
		        velParam.put("to_yd_cd", searchInlandRouteVO.getToYdCd());
		        
		        dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOInlandRouteListRSQL(), param, velParam);
		        list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchInlandRouteVO .class);
		        
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;		
	}
	
	
	/**
	 * VVD체크한다. <br>
	 * 
	 * @param param Map<String, Object>
	 * @param velparam Map<String, Object>
	 * @return strRepoId
	 * @exception DAOException
	 */
	public String duplicateCheckVvdLocationCheck(Map<String, Object> param , Map<String, Object> velparam) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		String strRepoId = "";
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOCheckDuplicateVvdFmToYardRSQL(), param, velparam);
			
			if(dbRowset.next()){
				strRepoId = dbRowset.getString("PLANCNT");
	        } else {
	        	strRepoId = "";
	        }
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRepoId;
	}
	
	
	/**
	 * VVD체크한다. <br>
	 * 
	 * @param param Map<String, Object>
	 * @param velparam Map<String, Object>
	 * @return strRepoId
	 * @exception DAOException
	 */
	public String duplicateCheckVvdLocationNewCheck(Map<String, Object> param , Map<String, Object> velparam) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		String strRepoId = "";
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOCheckNewDuplicateVvdFmToYardRSQL(), param, velparam);
			
			if(dbRowset.next()){
				strRepoId = dbRowset.getString("PLANCNT");
	        } else {
	        	strRepoId = "";
	        }
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRepoId;
	}
	
	
	/**
     * Repo Plan (EES_EQR_083) DB에 반영한다.(추가, 수정, 삭제)<br>
      INSERT : - REF_ID 생성
               - EQR_ECC_INTER_EXE_PLN      입력
     * 
	 * @param eqrInlndTrspExePlnVO EqrInlndTrspExePlnVO
	 * @param user_id String
	 * @exception DAOException
	 */
	public void insertCntrRepoExePlan(EqrInlndTrspExePlnVO eqrInlndTrspExePlnVO , String user_id )throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.putAll(eqrInlndTrspExePlnVO.getColumnValues());
			param.put("user_id", user_id);
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOInsertCntrRepoExePlanCSQL(), param, null);
			
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
	}
	
	
	/**
	 * 컨테이너 이송 실행 계획 조회/수정  DB에 반영한다.(추가)
	 * EQR_INLND_TRSP_PLN_EXE     입력
	 * 
	 * @param eqrInlndTrspExePlnVO EqrInlndTrspExePlnVO
	 * @param user_id String
	 * @param soFlag String
	 * @exception DAOException
	 */
	public void updateCntrRepoExePlan(EqrInlndTrspExePlnVO eqrInlndTrspExePlnVO , String user_id, String soFlag )throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.putAll(eqrInlndTrspExePlnVO.getColumnValues());
			param.put("user_id", user_id);
			velParam.put("soFlag", soFlag);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOUpdateCntrRepoExePlanUSQL(), param, velParam);
			
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
	}
	
	
	/**
	 * 컨테이너 이송 실행 계획 조회/수정  DB에 반영한다.(추가)
	 * EQR_INLND_TRSP_PLN_EXE     삭제
	 * 
	 * @param eqrInlndTrspExePlnVO EqrInlndTrspExePlnVO
	 * @exception DAOException
	 */
	public void deleteCntrRepoExePlan(EqrInlndTrspExePlnVO eqrInlndTrspExePlnVO  )throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.putAll(eqrInlndTrspExePlnVO.getColumnValues());
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAODeleteCntrRepoExePlanDSQL(), param, null);
			
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
	}
	
	
	/**
	 * 컨테이너 이송 실행 계획 조회/수정 Truck/Rail/Barge (EES_EQR_080) DB에 반영한다.(추가)
	 * EQR_INLND_TRSP_PLN_EXE_QTY     입력
	 * 
	 * @param eqrInlndTrspExePlnQtyVO EqrInlndTrspExePlnQtyVO
	 * @param user_id
	 * @exception DAOException
	 */
	public void insertCntrRepoExePlanQty(EqrInlndTrspExePlnQtyVO eqrInlndTrspExePlnQtyVO , String user_id)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.putAll(eqrInlndTrspExePlnQtyVO.getColumnValues());
			param.put("user_id", user_id);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOInsertCntrRepoExePlanQtyCSQL(), param, null);
			
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
	}
	
	
	/**
	 * 컨테이너 이송 실행 계획 조회/수정 DB에 반영한다.(추가)
	 * EQR_INLND_TRSP_PLN_EXE_QTY     수정
	 * 
	 * @param eqrInlndTrspExePlnQtyVO EqrInlndTrspExePlnQtyVO
	 * @param user_id String
	 * @param soFlag String
	 * @exception DAOException
	 */
	public void mergeCntrRepoExePlanQty(EqrInlndTrspExePlnQtyVO eqrInlndTrspExePlnQtyVO , String user_id , String soFlag )throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.putAll(eqrInlndTrspExePlnQtyVO.getColumnValues());
			param.put("user_id", user_id);
			velParam.put("soFlag", soFlag);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOMergeCntrRepoExePlanQtyCSQL(), param, velParam);
			
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
	}
	
	
	/**
	 * 컨테이너 이송 실행 계획 조회/수정 DB에 반영한다.(추가)
	 * EQR_ONF_HIR_PLN     삭제
	 * 
	 * @param eqrInlndTrspExePlnQtyVO EqrInlndTrspExePlnQtyVO
	 * @exception DAOException
	 */
	public void deleteCntrRepoExePlanQty(EqrInlndTrspExePlnQtyVO eqrInlndTrspExePlnQtyVO )throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.putAll(eqrInlndTrspExePlnQtyVO.getColumnValues());
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAODeleteCntrRepoExePlanQtyDSQL(), param, null);
			
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
	}
	
	/**
     * 컨테이너 이송 실행 계획 조회/수정 정보 조회
     * CSR No : R200901200004( Tuning 결과를 바탕으로 Query 재작업 ), modified by Haeng-Ji Lee 2009.01.21
	 * 기존 Query는 searchTruckAndRailAndBargeCntrRepoPlan_Old로 Rename후 주석처리.
	 * 
	 * @param condiVO EesEqr0059ConditionVO
	 * @param account SignOnUserAccount
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CommonRsVO searchRepoExePlanList(EesEqr0059ConditionVO condiVO, SignOnUserAccount account) throws DAOException {
		
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String offCd = account.getOfc_cd();
		
		String fromECC		= condiVO.getFromEcc();
		String toECC		= condiVO.getToEcc();
		String userECC		= condiVO.getUserEcc();
		
		String repoPlanID = condiVO.getRepoPlanId();//.getRepoPlanId();
		String fromWeek   = condiVO.getFmplnyr()+condiVO.getFmplnwk();
		String toWeek     = condiVO.getToplnyr()+condiVO.getToplnwk();
		
    	String tpsz     = condiVO.getTpsz();      // TYPE SIZE 종류(ALL, DRY, RFR...)
 		String tpsztype = condiVO.getTpsztype();  // TYPE SIZE 선택값
 		List tpszArr	= Utils.replaceStrToList(tpsztype); 
 		
 		
 		String reason   = condiVO.getReason();
 		String itemname = condiVO.getItemname();
 		String sosend   = condiVO.getSosend();
 		String mty      = condiVO.getMty();
 		
 		String lane     = condiVO.getLane();
 		String vvd      = condiVO.getVvd();
 		String fromLoc		= condiVO.getFromlocation();
		String toLoc		= condiVO.getTolocation();
		
		String mtyBkgNo		= condiVO.getMtyBkgNo();
		String refId		= condiVO.getRefId();
		
		String fromStatus  = condiVO.getFromstatus();
 		String toStatus    = condiVO.getTostatus();
 		String fromEccText	= Utils.convertStr(condiVO.getFromEcc(), true);
		String toEccText	= Utils.convertStr(condiVO.getToEcc(), true);
		
 		String volsec   = condiVO.getVolsec();
 		if("ALL".equals(volsec)) {
 			volsec = "";
 		}
 		String volsec1   = ""; 
 		String volsec2   = "";
 		String volsec3   = "";
 		volsec1 = Integer.toString(volsec.indexOf("A"));
 		volsec2 = Integer.toString(volsec.indexOf("W"));
 		volsec3 = Integer.toString(volsec.indexOf("M"));
 		
 		String userECCStrArr 	= "";
 		String fromECCStrArr 	= "";
 		String toECCStrArr 		= "";
 		String tpszStrArr		= "";
 		String reasonStrArr		= "";
 		String itemnameStrArr	= "";
 		String laneStrArr		= "";
 		String vvdStrArr		= "";

    	// user location 검색조건
    	if(!userECC.equals("")) {
    		userECCStrArr = Utils.convertStr(userECC , true);
    	}
    	
    	
        // TP/SZ 에 따른 조건값을 넣어 준다.
        if(!tpsz.equals("") && !tpsztype.equals("")) {
        	tpszStrArr = Utils.convertStr(tpsztype);
    	}    	

       /* // REASON 에 따른 조건값을 넣어 준다.
        if(!reason.equals("")) {
        	reasonStrArr = Utils.convertStr(reason);
    	}    	

        // REASON 에 따른 조건값을 넣어 준다.
        if(!itemname.equals("")) {
        	itemnameStrArr = Utils.convertStr(itemname);
    	}    

        // LANE 에 따른 조건값을 넣어 준다.
        if(!lane.equals("")) {
        	laneStrArr = Utils.convertStr(lane);
    	}         */
        
        // VVD 에 따른 조건값을 넣어 준다.
        if(!vvd.equals("")) {
        	vvdStrArr = Utils.convertStr(vvd);
    	}         
		
        try {
			
			param.put("sosend", sosend);
			param.put("mty", mty);
			param.put("repoPlanID", repoPlanID);
			param.put("fromWeek", fromWeek);
			param.put("toWeek", toWeek);
			param.put("from_loc", fromLoc);
			param.put("to_loc", toLoc);
			param.put("off_cd", offCd);
			param.put("mtyBkgNo", mtyBkgNo);
			param.put("refId", refId);
			
			velParam.put("tpsz", tpsz);
			velParam.put("tpsztype", tpsztype);
			velParam.put("tpszArr", tpszArr);
			velParam.put("tranTpsz", "");
			velParam.put("reason", reason);
			velParam.put("sosend", sosend);
			velParam.put("mty", mty);
			velParam.put("lane", lane);
			velParam.put("vvd", vvd);
			
			velParam.put("fromStatus", fromStatus);
			velParam.put("toStatus", toStatus);
			velParam.put("fromECC", fromECC);
			velParam.put("toECC", toECC);
			
			velParam.put("userECC", userECC);
			velParam.put("repoPlanID", repoPlanID);
			velParam.put("fromWeek", fromWeek);
			velParam.put("toWeek", toWeek);
			velParam.put("userECCStrArr",userECCStrArr);
			velParam.put("fromECCStrArr",fromECCStrArr);
			velParam.put("toECCStrArr",toECCStrArr);
			velParam.put("tpszStrArr",tpszStrArr);
			velParam.put("reasonStrArr",reasonStrArr);
			velParam.put("itemname",itemname);
			velParam.put("itemnameStrArr",itemnameStrArr);
			velParam.put("laneStrArr",laneStrArr);
			velParam.put("vvdStrArr",vvdStrArr);
			velParam.put("from_loc", fromLoc);
			velParam.put("to_loc", toLoc);
			velParam.put("off_cd", offCd);
			velParam.put("mtyBkgNo", mtyBkgNo);
			velParam.put("refId", refId);
			velParam.put("volsec", volsec);
			velParam.put("volsec1", volsec1);
			velParam.put("volsec2", volsec2);
			velParam.put("volsec3", volsec3);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOSearchRepoExePlanRSQL(), param, velParam, true);
			//dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOSearchInlandCntrRepoPlanRSQL(), param, velParam, true);
			commonRsVO.setDbRowset(dbRowset);

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
		
        return commonRsVO;
	}
	
	
	
	/**
	 * 컨테이너 이송실행계획 [0080] SO SEND 버튼 클릭시 EQR_REPO_EXE_SO_IF 에 soData 입력
	 *          
	 * @param eqrRepoExeSoIfVO EqrRepoExeSoIfVO
	 * @param user_id String
	 * @exception DAOException
	 */
	public void createRepoExePlanSoData(EqrRepoExeSoIfVO eqrRepoExeSoIfVO , String user_id)	throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.putAll(eqrRepoExeSoIfVO.getColumnValues());
			param.put("user_id",user_id);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOCreateRepoExePlanSoDataCSQL(), param, null);
	    }catch (SQLException se) {
	        log.error(se.getMessage(), se);
	        throw new DAOException(new ErrorHandler(se).getMessage());   
	    }catch (DAOException de) {
	        log.error(de.getMessage(), de);
	        throw de;
	    }catch (Exception e) {
	        log.error(e.getMessage(), e);
	        throw new DAOException(e.getMessage());
	    }
	}
	
	
	/**
     *- W/O Issue 테이블로 Execute중에 REF_ID별로 S/O Send 체크박스 클릭한 것만 삭제<br>
      - EQR_REPO_EXE_SO_IF 테이블의 REF_ID중에 WO_EXE_FLG 가 'Y'가 1개도 업어야 함  <br>           
		
	   EQR_INLND_TRSP_EXE_PLN  SO FLAG 초기화
	 *          
     * @param eqrInlndTrspExePlnVO EqrInlndTrspExePlnVO
     * @param user_id 		: user_id     
     * @exception DAOException
     */
	public void updateRepoExePlanExecute(EqrInlndTrspExePlnVO eqrInlndTrspExePlnVO , String user_id)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.putAll(eqrInlndTrspExePlnVO.getColumnValues());
			param.put("user_id", user_id);

			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOUpdateRepoExePlanExecuteUSQL(), param, null);
			
	    }catch (SQLException se) {
	        log.error(se.getMessage(), se);
	        throw new DAOException(new ErrorHandler(se).getMessage());   
	    }catch (DAOException de) {
	        log.error(de.getMessage(), de);
	        throw de;
	    }catch (Exception e) {
	        log.error(e.getMessage(), e);
	        throw new DAOException(e.getMessage());
	    }
	}
	
	
	/**
	 * 생성된 REPO_PLAN ID가 있는지 확인을 한다.<br>
	 * 
	 * @param param Map<String, Object>
	 * @param velparam Map<String, Object>
	 * @return resultCnt
	 * @exception DAOException
	 */
	public int duplicateCreateRepoExePlanCheck(Map<String, Object> param , Map<String, Object> velparam) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		int resultCnt = 0;
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodSimulateDBDAODuplicateCreateRepoPlanCheckRSQL(), param, velparam);
			
			while (dbRowset.next()) {
				resultCnt = dbRowset.getInt("CNT");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return resultCnt;
	}
	
	
	/**
	 * 생성된 PLAN이 있는지 확인을 한다.<br>
	 * 
	 * @param param Map<String, Object>
	 * @param velparam Map<String, Object>
	 * @return resultCnt
	 * @exception DAOException
	 */
	public int duplicateCreateRepoExePlanViewCheck(Map<String, Object> param , Map<String, Object> velparam) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		int resultCnt = 0; 
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodSimulateDBDAODuplicateCreateRepoPlanExeViewCheckRSQL(), param, velparam);
			
			while (dbRowset.next()) {
				resultCnt = dbRowset.getInt("PLANCNT");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return resultCnt;
	}
	
	
	/**
	 * TP/SZ별 Pln 삭제.<br>
	 * 
	 * @param param Map<String, Object>
	 * @param velparam Map<String, Object>
	 * @exception DAOException
	 */
	public void deleteRepoExePlanQty(Map<String, Object> param , Map<String, Object> velparam) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt = 0;
			    delCnt = sqlExe.executeUpdate((ISQLTemplate)new CodSimulateDBDAODeleteEqrPlnCodQtyDSQL(), param, velparam);
					if(delCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No SQL");
			
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Repo Plan Id 삭제 <br>
	 * 
	 * @param param Map<String, Object>
	 * @param velparam Map<String, Object>
	 * @exception DAOException
	 */
	public void deleteRepoExePlanId(Map<String, Object> param , Map<String, Object> velparam) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt = 0;
			    delCnt = sqlExe.executeUpdate((ISQLTemplate)new CodSimulateDBDAODeleteRepoPlanIdDSQL(), param, velparam);
					if(delCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No SQL");
			
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * 
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked" })
	public List<EqrCommonVO> searchRepoExePlanTypeSizeList(EesEqr0059ConditionVO condiVO, SignOnUserAccount account) throws DAOException {
		 
		DBRowSet dbRowset = null;
		List<EqrCommonVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		try {
			String repoPlanID = condiVO.getRepoPlanId();//.getRepoPlanId();
			
			param.put("repoPlanID", repoPlanID);
			velParam.put("repoPlanID", repoPlanID);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOSearchRepoExePlanTypeSizeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EqrCommonVO.class);
			
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
		return list;
	}
		
	
	/**
     * 컨테이너 이송 실행 계획 조회/수정 On-Hire & Off-Hire (EES_EQR_081) SEQ 생성<br>
     * 
     * @param table_name : table_name
     * @param co_cd : company
     * @param repo_plan_id : repo_plan_id
     * @param from_location : from_location
     * @param onf_hir_div_cd : onf_hir_div_cd
     * @param old_repo_plan_id : old_repo_plan_id
     * @return String
     * @exception DAOException
    */
	public String makeRefIDCntrRepoExePlan(String table_name, String co_cd, String repo_plan_id, String from_location, String onf_hir_div_cd, String old_repo_plan_id) throws DAOException {
		  
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
	    //String seq  = "";
	    String ref_id = "";
	    
	    try {	    	
	    	velParam.put("table_name",table_name);
	    	param.put("old_repo_plan_id",old_repo_plan_id);
	    	param.put("repo_plan_id",repo_plan_id);
	    	param.put("from_location",from_location.substring(0,5));
	    	param.put("repo_plan_id610",repo_plan_id.substring(6,10));
	    	param.put("onf_hir_div_cd",onf_hir_div_cd);
	    	
	    	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOMakeRefIDRepoExePlanRSQL(), param, velParam);
	        
	        if(dbRowset.next()){
	        	ref_id = dbRowset.getString("SEQ");
	        } else {
	        	ref_id = "CHECK_REF_NO";
	        }
	        
	        /*
            H     : 
            KRPUS : FROM LOC 을 0,5 로 잘라서 사용
            0637W : REPO_PLAN_ID 를 잘라내서 + "W"
            002   : REPO_PLAN_ID 를 잘라낸(0637), SUBSTR(FM_YD_CD, 0,5) 중에 REF_ID 의 뒷 4자리중 앞3자리 MAX+1
            O     : TRSP MODE                    	        
	        */	        
	        // Old ref_id = co_cd + from_location.substring(0,5) + repo_plan_id.substring(6,10)+ "W" + seq + onf_hir_div_cd;
	        
	    }catch (SQLException se) {
	        log.error(se.getMessage(), se);
	        throw new DAOException(new ErrorHandler(se).getMessage());   
	    }catch (DAOException de) {
	        log.error(de.getMessage(), de);
	        throw de;
	    }catch (Exception e) {
	        log.error(e.getMessage(), e);
	        throw new DAOException(e.getMessage());
	    }
	    
	    return ref_id;
	}		
}