/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommodityGroupCodeManageDBDAO.java
*@FileTitle : Commodity Group Code Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009-07-16
*@LastModifier : KIMJIN
*@LastVersion : 1.0
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.commoditygroupcodemanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.esd.trs.codemanage.commoditygroupcodemanage.basic.CommodityGroupCodeManageBCImpl;
import com.hanjin.apps.alps.esd.trs.codemanage.commoditygroupcodemanage.event.EsdTrs0075Event;
import com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.integration.CSRIssueTransferSlipManageDBDAOCreateApInvKRDtrbCSQL;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.TrsCmdtGrpCzVO;
import com.hanjin.syscommon.common.table.TrsTrspCmdtGrpVO;


/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author kimjin
 * @see CommodityGroupCodeManageBCImpl 참조
 * @since J2EE 1.6
 */
public class CommodityGroupCodeManageDBDAO extends DBDAOSupport {

	/**
	 * CommodityGroupCodeManage의 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchCommodityGroupCodeManageList(EsdTrs0075Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		param.put("vndr_cd", event.getVndrCd());
		param.put("vndr_commoodity_cd", event.getVndrCommoodityCd());
		param.put("vndr_commoodity_nm", event.getVndrCommoodityNm());
		
		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new CommodityGroupCodeManageDBDAOSearchCommodityGroupCodeManageListRSQL(), param,param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return dRs;
	}
	
	/**
	 * CommodityGroupCodeManage의 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchMdm_commodity(EsdTrs0075Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		param.put("rep_cmdt_cd", 	event.getRepCmdtCd());
		param.put("cmdt_cd", 		event.getCmdtCd());

		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new CommodityGroupCodeManageDBDAOSearchMdmCommodityRSQL(), param,param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return dRs;
	}	
	
	/**
	 * CommodityGroupCodeManage의 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchrep_commodity(EsdTrs0075Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		param.put("rep_cmdt_cd", event.getRepCmdtCd());

		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new CommodityGroupCodeManageDBDAOSearchRepCommodityRSQL(), param,param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return dRs;
	}		
	
	/**
	 * CommodityGroupCodeManage의 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet search_commodity(EsdTrs0075Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		param.put("cmdt_cd", event.getCmdtCd());

		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new CommodityGroupCodeManageDBDAOSearchCommodityRSQL(), param,param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return dRs;
	}			
	
	/**
	 * CommodityGroupCodeManage의 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet search_vndr(EsdTrs0075Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		param.put("vndr_seq", event.getVndrCd());

		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new CommodityGroupCodeManageDBDAOSearchVndrCommodityBySeqRSQL(), param,param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return dRs;
	}	
	
	/**
	 * CommodityGroupCodeManage의 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet search_vndr_commodity(EsdTrs0075Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		param.put("vndr_nm", event.getVndrNm());
		
		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new CommodityGroupCodeManageDBDAOSearchVndrCommodityRSQL(), param,param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return dRs;
	}	
	
	/**
	 * CommodityGroupCodeManage의 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet search_sub_commodity(EsdTrs0075Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		param.put("trsp_grp_cmdt_cd", 	event.getTrspGrpCmdtCd());
		param.put("vndr_seq", 			event.getVndrSeq());
		
		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new CommodityGroupCodeManageDBDAOSearchSubCommodityRSQL(), param,param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return dRs;
	}	
	
	/**
	 * CommodityGroupCodeManage의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void multi_vndr_commodity(EsdTrs0075Event event) throws DAOException {
		try {
			TrsTrspCmdtGrpVO model_01 = event.getTrsTrspCmdtGrpVO();
			
			Collection<TrsTrspCmdtGrpVO> insModels =new ArrayList<TrsTrspCmdtGrpVO>();
			insModels.add(model_01);
			
			int[] insCnt = null;
			Map<String,Object> param = new HashMap<String,Object>();

			if(insModels.size()>0){
				if (model_01.getIbflag().equals("I")) {
					param.put("trsp_grp_cmdt_cd", 	model_01.getTrspGrpCmdtCd());
					param.put("vndr_seq", 			model_01.getVndrSeq());
					param.put("trsp_cmdt_grp_nm", 	model_01.getTrspCmdtGrpNm());
					param.put("cre_usr_id", 		event.getCreUsrId());
					param.put("cre_dt", 			event.getCreDt());
					param.put("upd_usr_id", 		event.getUpdUsrId());
					param.put("upd_dt", 			event.getUpdDt());
					param.put("delt_flg", 			event.getDeltFlag());
					
					insCnt = new SQLExecuter("DEFAULT").executeBatch(new CommodityGroupCodeManageDBDAOMultiVndrCommodityCSQL(), insModels, param, param);					
				} else if (model_01.getIbflag().equals("U")) {
					param.put("trsp_cmdt_grp_nm", 	model_01.getTrspCmdtGrpNm());
					param.put("upd_usr_id", 		event.getUpdUsrId());
					param.put("upd_dt", 			event.getUpdDt());
					param.put("trsp_grp_cmdt_cd", 	model_01.getTrspGrpCmdtCd());
					param.put("vndr_seq", 			model_01.getVndrSeq());
					param.put("delt_flg", 			model_01.getDeltFlg());

					insCnt = new SQLExecuter("DEFAULT").executeBatch(new CommodityGroupCodeManageDBDAOMultiVndrCommodityUSQL(), insModels, param, param);					
				} else if (model_01.getIbflag().equals("D")) {
					param.put("upd_usr_id", 		event.getUpdUsrId());
					param.put("upd_dt", 			event.getUpdDt());
					param.put("trsp_grp_cmdt_cd", 	model_01.getTrspGrpCmdtCd());
					param.put("vndr_seq", 			model_01.getVndrSeq());

					//insCnt = new SQLExecuter("DEFAULT").executeBatch(new CommodityGroupCodeManageDBDAOMultiVndrCommodityDelUSQL(), insModels, param, param);
					insCnt = new SQLExecuter("DEFAULT").executeBatch(new CommodityGroupCodeManageDAOMultiDeleteCommodityDSQL(), insModels, param, param);
					insCnt = new SQLExecuter("DEFAULT").executeBatch(new CommodityGroupCodeManageDAOMultiVndrCommodityDelDSQL(), insModels, param, param);					
				}
			}

			for(int i=0;i<insCnt.length;i++){
				if(insCnt[i]== Statement.EXECUTE_FAILED){
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
	 * CommodityGroupCodeManage의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void multi_delete_commodity(EsdTrs0075Event event) throws DAOException {
		try {
			TrsCmdtGrpCzVO model_01 	= event.getTrsCmdtGrpCzVO();
			TrsCmdtGrpCzVO[] model_02 	= null;

			Collection<TrsCmdtGrpCzVO> insModels 	= new ArrayList<TrsCmdtGrpCzVO>();
			Collection<TrsCmdtGrpCzVO> insModels_01 = new ArrayList<TrsCmdtGrpCzVO>();
//			int[] insCnt = null;
			Map<String,Object> param = new HashMap<String,Object>();

			if(event.getTrsCmdtGrpCzVOS() != null){
				model_02 = event.getTrsCmdtGrpCzVOS();
				for(int i=0;i<model_02.length;i++){
					if (model_02[i].getIbflag().equals("I")) {
						param.put("trsp_grp_cmdt_cd", 	model_02[i].getTrspGrpCmdtCd());
						param.put("cmdt_cd", 	model_02[i].getCmdtCd());
						param.put("vndr_seq", 	model_02[i].getVndrSeq());
						param.put("cre_usr_id", 		event.getCreUsrId());
						param.put("cre_dt", 			event.getCreDt());

						new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new CommodityGroupCodeManageDBDAOMultiDeleteCommodityCSQL(), param, param);
//						insCnt = new SQLExecuter("DEFAULT").executeBatch(new CommodityGroupCodeManageDBDAOMultiDeleteCommodityCSQL(), insModels, param, param);					
					} else if (model_02[i].getIbflag().equals("U")) {
						param.put("trsp_grp_cmdt_cd", 	model_02[i].getTrspGrpCmdtCd());
						param.put("cmdt_cd", 	model_02[i].getCmdtCd());
						param.put("vndr_seq", 	model_02[i].getVndrSeq());
						
						param.put("upd_usr_id", 		event.getUpdUsrId());
						param.put("upd_dt", 			event.getUpdDt());

						new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new CommodityGroupCodeManageDBDAOMultiDeleteCommodityUSQL(), param, param);
//						insCnt = new SQLExecuter("DEFAULT").executeBatch(new CommodityGroupCodeManageDBDAOMultiDeleteCommodityUSQL(), insModels, param, param);
					} else if (model_02[i].getIbflag().equals("D")) {
						param.put("trsp_grp_cmdt_cd", 	model_02[i].getTrspGrpCmdtCd());
						param.put("cmdt_cd", 	model_02[i].getCmdtCd());
						param.put("vndr_seq", 	model_02[i].getVndrSeq());
						
						param.put("upd_usr_id", 		event.getUpdUsrId());
						param.put("upd_dt", 			event.getUpdDt());
						
						new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new CommodityGroupCodeManageDBDAOMultiDeleteCommodityDelUSQL(), param, param);
//						insCnt = new SQLExecuter("DEFAULT").executeBatch(new CommodityGroupCodeManageDBDAOMultiDeleteCommodityDelUSQL(), insModels_01, param, param);
					}
					
					insModels.add(model_02[i]);
				}
			}			
			
			insModels_01.add(model_01);
			


		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	

	/**
	 * CommodityGroupCodeManage의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void multi_part_commodity(EsdTrs0075Event event) throws DAOException {
		try {
			TrsCmdtGrpCzVO[] model_02 = event.getTrsCmdtGrpCzVOS();

			Collection<TrsCmdtGrpCzVO> insModels = new ArrayList<TrsCmdtGrpCzVO>();
			
			for(int i=0;i<model_02.length;i++){
				insModels.add(model_02[i]);
			}
						
			int[] insCnt = null;
			Map<String,Object> param = new HashMap<String,Object>();

			if(model_02.length>0){
				if (model_02[0].getIbflag().equals("I")) {
					param.put("cre_usr_id", 		event.getCreUsrId());
					param.put("cre_dt", 			event.getCreDt());
					
					insCnt = new SQLExecuter("DEFAULT").executeBatch(new CommodityGroupCodeManageDBDAOMultiPartCommodityCSQL(), insModels, param, param);
				} else if (model_02[0].getIbflag().equals("U")) {
					param.put("upd_usr_id", 		event.getUpdUsrId());
					param.put("upd_dt", 			event.getUpdDt());

					insCnt = new SQLExecuter("DEFAULT").executeBatch(new CommodityGroupCodeManageDBDAOMultiPartCommodityUSQL(), insModels, param, param);
				} else if (model_02[0].getIbflag().equals("D")) {
					param.put("upd_usr_id", 		event.getUpdUsrId());
					param.put("upd_dt", 			event.getUpdDt());

					//insCnt = new SQLExecuter("DEFAULT").executeBatch(new CommodityGroupCodeManageDBDAOMultiPartCommodityDelUSQL(), insModels, param, param);
					insCnt = new SQLExecuter("DEFAULT").executeBatch(new CommodityGroupCodeManageDAOMultiPartCommodityDelDSQL(), insModels, param, param);
				}
			}

			for(int i=0;i<insCnt.length;i++){
				if(insCnt[i]== Statement.EXECUTE_FAILED){
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
}