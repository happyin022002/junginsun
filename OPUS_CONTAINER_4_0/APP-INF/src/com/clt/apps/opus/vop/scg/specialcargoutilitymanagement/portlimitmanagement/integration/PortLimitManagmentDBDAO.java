/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SpecialCargoMasterDataMgtDBDAO.java
*@FileTitle : SPCL CGO RSO (Creation)
*Open Issues :
*Change history : 2014.11.21
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.basic.SpecialCargoMasterDataMgtBCImpl;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.vo.PortLimitsDataVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.vo.PortLimitsDgTotalWeightVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.vo.PortLimitsUnNoVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.vo.PortLimitsBkgVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.vo.PortLmtSubsRskVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS SpecialCargoMasterDataMgtDBDAO <br>
 * - OPUS-SpecialCargoMasterDataMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Un Jeong
 * @see SpecialCargoMasterDataMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class PortLimitManagmentDBDAO extends DBDAOSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2339168704433090379L;

	/**
	 * VOP_SCG_5021 : Retrieve <br>
	 * Retrieve Port Limit Info
	 * @category VOP_SCG_5021
	 * @category PortLimitManagmentDBDAO 
	 * @param PortLimitsDataVO portLimitsDataVO
	 * @return List<PortLimitsDataVO> 
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<PortLimitsDataVO> searchPortLimitsData(PortLimitsDataVO portLimitsDataVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<PortLimitsDataVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(portLimitsDataVO != null){
				Map<String, String> mapVO = portLimitsDataVO.getColumnValues();
		            
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortLimitManagmentDBDAOSearchPortLimitsDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PortLimitsDataVO .class);
			
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;		
	}
	
	/**
	 * VOP_SCG_5023 : Retrieve <br>
	 * Retrieve Port Limit Class Info
	 * @category VOP_SCG_5023
	 * @category PortLimitManagmentDBDAO 
	 * @param PortLimitsDataVO portLimitsDataVO
	 * @return List<PortLimitsDataVO> 
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<PortLimitsDataVO> searchPortLimitsClass(PortLimitsDataVO portLimitsDataVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<PortLimitsDataVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(portLimitsDataVO != null){
				Map<String, String> mapVO = portLimitsDataVO.getColumnValues();
		            
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortLimitManagmentDBDAOSearchPortLimitsClassRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PortLimitsDataVO .class);
			
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;		
	}
	
	/**
	 * VOP_SCG_5024 : Retrieve <br>
	 * Retrieve Port Limit Class Info
	 * @category VOP_SCG_5024
	 * @category PortLimitManagmentDBDAO 
	 * @param PortLimitsBkgVO portLimitsBkgVO
	 * @return List<PortLimitsBkgVO> 
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<PortLimitsBkgVO> searchPortLimitsBkg(PortLimitsBkgVO portLimitsBkgVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<PortLimitsBkgVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(portLimitsBkgVO != null){
				Map<String, String> mapVO = portLimitsBkgVO.getColumnValues();
		            
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				String bkgNosList = portLimitsBkgVO.getBkgNos();
//				String imdgClssCdList = portLimitsBkgVO.getImdgClssCd();
//				String imdgUnNoList   = portLimitsBkgVO.getImdgUnNo();
//				String imdgCompGrpCdList = portLimitsBkgVO.getImdgCompGrpCd();
				//String portCd = portLimitsBkgVO.getPortCd();
				//String kind = "";
//				if(portCd != null && !"".equals(portCd)) {
//					String bkgSch = portCd.substring(0,1);
//					if(bkgSch.equals("1") || bkgSch.equals("2")) {
//						kind = "POD";
//					} else if(bkgSch.equals("3") || bkgSch.equals("4")) {
//						kind = "POL";
//					}
//					portCd = portCd.substring(1);
//				}
				
				if( bkgNosList != null &&  bkgNosList.length() != 0 ){
					List<String> bkgNosListArr = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(bkgNosList, ",");
					while(st.hasMoreTokens()){
						bkgNosListArr.add(st.nextToken());
					}
					param.put("bkg_nos", bkgNosListArr);
					velParam.put("bkg_nos", bkgNosListArr);
					
					//List<String> imdgClssCdListArr = new ArrayList<String>();
					//List<String> imdgUnNoListArr   = new ArrayList<String>();
					//List<String> imdgCompGrpCdListArr = new ArrayList<String>();
					
					//st = new StringTokenizer(imdgClssCdList, ",");
					//while(st.hasMoreTokens()){
					//	imdgClssCdListArr.add(st.nextToken());
					//}
					//st = new StringTokenizer(imdgUnNoList, ",");
					//while(st.hasMoreTokens()){
					//	imdgUnNoListArr.add(st.nextToken());
					//}
					//st = new StringTokenizer(imdgCompGrpCdList, ",");
					//while(st.hasMoreTokens()){
					//	imdgCompGrpCdListArr.add(st.nextToken());
					//}
					
					//if(imdgClssCdListArr.size() > 0){
					//	param.put("imdg_clss_cd", imdgClssCdListArr);
					//	velParam.put("imdg_clss_cd", imdgClssCdListArr);
					//}else{
					//	param.put("imdg_clss_cd", "");
					//	velParam.put("imdg_clss_cd", "");
					//}
					//if(imdgUnNoListArr.size() > 0){
					//	param.put("imdg_un_no",   imdgUnNoListArr);
					//	velParam.put("imdg_un_no", imdgUnNoListArr);
					//}else{
					//	param.put("imdg_un_no",   "");
					//	velParam.put("imdg_un_no", "");
					//}
					
					//if(imdgCompGrpCdListArr.size() > 0){
					//	param.put("imdg_comp_grp_cd", imdgCompGrpCdListArr);
					//	velParam.put("imdg_comp_grp_cd", imdgCompGrpCdListArr);
					//}else{
					//	param.put("imdg_comp_grp_cd", "");
					//	velParam.put("imdg_comp_grp_cd", "");
					//}

					//param.put("plmt_port_cd", portLimitsBkgVO.get());
					
					//param.put("vsl_cd", portLimitsBkgVO.getVslCd());
					//param.put("skd_voy_no", portLimitsBkgVO.getSkdVoyNo());
					//param.put("skd_dir_cd", portLimitsBkgVO.getSkdDirCd());
					
					//param.put("port_cd", portCd);
					//velParam.put("kind", kind);
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortLimitManagmentDBDAOSearchPortLimitsBkgRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PortLimitsBkgVO .class);
			
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;		
	}
	
	/**
	 * VOP_SCG_5922 : Retrieve <br>
	 * Retrieve Port Limit Un No Info
	 * @category VOP_SCG_5922
	 * @category PortLimitManagmentDBDAO 
	 * @param PortLimitsDataVO portLimitsDataVO
	 * @return List<PortLimitsDataVO> 
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<PortLimitsDataVO> searchPortLimitsUnNo(PortLimitsDataVO portLimitsDataVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<PortLimitsDataVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(portLimitsDataVO != null){
				Map<String, String> mapVO = portLimitsDataVO.getColumnValues();
		            
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortLimitManagmentDBDAOSearchPortLimitsUnNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PortLimitsDataVO .class);
			
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;		
	}
	
	/**
	 * VOP_SCG_5923 : Retrieve <br>
	 * Retrieve Port Limit Un No Info
	 * @category VOP_SCG_5923
	 * @category PortLimitManagmentDBDAO 
	 * @param PortLmtSubsRskVO portLmtSubsRskVO
	 * @return List<PortLimitsDataVO> 
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<PortLmtSubsRskVO> searchPortLimitsSubRsk(PortLmtSubsRskVO portLmtSubsRskVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<PortLmtSubsRskVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(portLmtSubsRskVO != null){
				Map<String, String> mapVO = portLmtSubsRskVO.getColumnValues();
		            
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortLimitManagmentDBDAOSearchPortLimitsSubRskRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PortLimitsDataVO .class);
			
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;		
	}

	/**
	 * VOP_SCG_5021 : Add <br>
	 * Manage Port Limit Info
	 * @category VOP_SCG_5021
	 * @category PortLimitManagmentDBDAO 
	 * @param List<PortLimitsDataVO> portLimitsDataVOs
	 * @exception EventException
	 */
	public void addPortLimitsData(List<PortLimitsDataVO> portLimitsDataVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int addCnt[] = null;
			if (portLimitsDataVOs.size() > 0) {
				addCnt = sqlExe.executeBatch((ISQLTemplate) new PortLimitManagmentDBDAOAddPortLimitsDataCSQL(), portLimitsDataVOs, null);
				for (int i = 0; i < addCnt.length; i++) {
					if (addCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
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
	 * VOP_SCG_5021 : Add <br>
	 * Manage Port Limit Info
	 * @category VOP_SCG_5021
	 * @category PortLimitManagmentDBDAO 
	 * @param List<PortLimitsDataVO> portLimitsDataVOs
	 * @exception EventException
	 */
	public void addPortLimitsDataPop(List<PortLimitsDataVO> portLimitsDataVOs) throws DAOException {
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int addCnt[] = null;
			if (portLimitsDataVOs.size() > 0) {
				if(portLimitsDataVOs != null){
					Map<String, String> mapVO = portLimitsDataVOs.get(0).getColumnValues();
			            
					velParam.putAll(mapVO);
					
					addCnt = sqlExe.executeBatch((ISQLTemplate) new PortLimitManagmentDBDAOAddPortLimitsDataCSQL(), portLimitsDataVOs, velParam);
					for (int i = 0; i < addCnt.length; i++) {
						if (addCnt[i] == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No" + i + " SQL");
					}
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
	 * VOP_SCG_5023 : Add <br>
	 * Manage Port Limit Info
	 * @category VOP_SCG_5023
	 * @category PortLimitManagmentDBDAO 
	 * @param PortLimitsDataVO portLimitsDataVO
	 * @exception EventException
	 */
	public void addPortLimitsClass(PortLimitsDataVO portLimitsDataVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = 0;
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, String> mapVO =  new HashMap<String, String>();
			mapVO.put("port_cd", 	   portLimitsDataVO.getPortCd());
			//mapVO.put("lmt_wgt_tp_cd", portLimitsDataVO.getLmtWgtTpCd());
			mapVO.put("port_lmt_seq",  portLimitsDataVO.getPortLmtSeq());
			mapVO.put("imdg_clss_cd",  portLimitsDataVO.getImdgClssCd());
			mapVO.put("cre_usr_id",    portLimitsDataVO.getCreUsrId());
			mapVO.put("upd_usr_id",    portLimitsDataVO.getUpdUsrId());
			param.putAll(mapVO);
			
			result = sqlExe.executeUpdate((ISQLTemplate) new PortLimitManagmentDBDAOAddPortLimitsClassCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");
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
	 * VOP_SCG_5023 : Add <br>
	 * Manage Port Limit Info
	 * @category VOP_SCG_5023
	 * @category PortLimitManagmentDBDAO 
	 * @param PortLimitsDataVO portLimitsDataVO
	 * @exception EventException
	 */
	public void addPortLimitsComp(PortLimitsDataVO portLimitsDataVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = 0;
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, String> mapVO =  new HashMap<String, String>();
			mapVO.put("port_cd", 	   portLimitsDataVO.getPortCd());
			//mapVO.put("lmt_wgt_tp_cd", portLimitsDataVO.getLmtWgtTpCd());
			mapVO.put("port_lmt_seq",  portLimitsDataVO.getPortLmtSeq());
			mapVO.put("imdg_clss_cd",  portLimitsDataVO.getImdgClssCd());
			mapVO.put("imdg_comp_grp_cd",  portLimitsDataVO.getImdgCompGrpCd());
			mapVO.put("cre_usr_id",    portLimitsDataVO.getCreUsrId());
			mapVO.put("upd_usr_id",    portLimitsDataVO.getUpdUsrId());
			param.putAll(mapVO);

			result = sqlExe.executeUpdate((ISQLTemplate) new PortLimitManagmentDBDAOAddPortLimitsCompCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");
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
	 * VOP_SCG_5922 : Add <br>
	 * Manage Port Limit UnNo Save
	 * @category VOP_SCG_5922
	 * @category PortLimitManagmentDBDAO 
	 * @param PortLimitsUnNoVO portLimitsUnNoVO
	 * @exception EventException
	 */
	public void addPortLimitsUnNo(PortLimitsUnNoVO portLimitsUnNoVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = 0;
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, String> mapVO =  new HashMap<String, String>();
			mapVO.put("port_cd", 	   portLimitsUnNoVO.getPortCd());
			mapVO.put("lmt_wgt_tp_cd", portLimitsUnNoVO.getLmtWgtTpCd());
			mapVO.put("port_lmt_seq",  portLimitsUnNoVO.getPortLmtSeq());
			mapVO.put("imdg_clss_cd",  portLimitsUnNoVO.getImdgClssCd());
			mapVO.put("imdg_un_no",    portLimitsUnNoVO.getImdgUnNo());
			mapVO.put("cre_usr_id",    portLimitsUnNoVO.getCreUsrId());
			mapVO.put("upd_usr_id",    portLimitsUnNoVO.getUpdUsrId());
			param.putAll(mapVO);

			result = sqlExe.executeUpdate((ISQLTemplate) new PortLimitManagmentDBDAOAddPortLimitsUnNoCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");
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
	 * VOP_SCG_5923 : Add <br>
	 * Manage Port Limit SubRsk Save
	 * @category VOP_SCG_5923
	 * @category PortLimitManagmentDBDAO 
	 * @param PortLmtSubsRskVO portLmtSubsRskVO
	 * @exception EventException
	 */
	public void addPortLimitsSubRsk(PortLmtSubsRskVO portLmtSubsRskVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = 0;
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, String> mapVO =  new HashMap<String, String>();
			mapVO.put("port_cd", 	   portLmtSubsRskVO.getPortCd());
			mapVO.put("port_lmt_seq",  portLmtSubsRskVO.getPortLmtSeq());
			mapVO.put("imdg_subs_rsk_lbl_cd",  portLmtSubsRskVO.getImdgSubsRskLblCd());
			mapVO.put("cre_usr_id",    portLmtSubsRskVO.getCreUsrId());
			mapVO.put("upd_usr_id",    portLmtSubsRskVO.getUpdUsrId());
			param.putAll(mapVO);

			result = sqlExe.executeUpdate((ISQLTemplate) new PortLimitManagmentDBDAOAddPortLimitsSubRskCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");
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
	 * VOP_SCG_5021 : Update <br>
	 * Manage Port Limit Info
	 * @category VOP_SCG_5021
	 * @category PortLimitManagmentDBDAO 
	 * @param List<PortLimitsDataVO> portLimitsDataVOs
	 * @exception EventException
	 */
	public void modifyPortLimitsData(List<PortLimitsDataVO> portLimitsDataVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (portLimitsDataVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new PortLimitManagmentDBDAOModifyPortLimitsDataUSQL(), portLimitsDataVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
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
	 * VOP_SCG_5021 : Remove <br>
	 * Manage Port Limit Info
	 * @category VOP_SCG_5021
	 * @category PortLimitManagmentDBDAO 
	 * @param List<PortLimitsDataVO> portLimitsDataVOs
	 * @exception EventException
	 */
	public void removePortLimitsData(List<PortLimitsDataVO> portLimitsDataVOs) throws DAOException {
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			
			//velocity parameter
			if (portLimitsDataVOs.size() > 0) {
				Map<String, String> mapVO = portLimitsDataVOs.get(0).getColumnValues();
	            
				velParam.putAll(mapVO);
				delCnt = sqlExe.executeBatch((ISQLTemplate) new PortLimitManagmentDBDAODeletePortLimitsDataDSQL(), portLimitsDataVOs, velParam);
				
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
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
	 * VOP_SCG_5023 : Remove <br>
	 * Manage Port Limit Info
	 * @category VOP_SCG_5023
	 * @category PortLimitManagmentDBDAO 
	 * @param List<PortLimitsDataVO> portLimitsDataVOs
	 * @exception EventException
	 */
	public void removePortLimitsClass(List<PortLimitsDataVO> portLimitsDataVOs) throws DAOException {
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			
			//velocity parameter
			if (portLimitsDataVOs.size() > 0) {

				delCnt = sqlExe.executeBatch((ISQLTemplate) new PortLimitManagmentDBDAODeletePortLimitsClassDSQL(), portLimitsDataVOs, velParam);
				
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
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
	 * VOP_SCG_5023 : Remove <br>
	 * Manage Port Limit Info
	 * @category VOP_SCG_5023
	 * @category PortLimitManagmentDBDAO 
	 * @param List<PortLimitsDataVO> portLimitsDataVOs
	 * @exception EventException
	 */
	public void removePortLimitsComp(List<PortLimitsDataVO> portLimitsDataVOs) throws DAOException {
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			
			//velocity parameter
			if (portLimitsDataVOs.size() > 0) {

				delCnt = sqlExe.executeBatch((ISQLTemplate) new PortLimitManagmentDBDAODeletePortLimitsCompDSQL(), portLimitsDataVOs, velParam);
				
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
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
	 * VOP_SCG_5922 : Remove <br>
	 * Manage Port Limit Info
	 * @category VOP_SCG_5922
	 * @category PortLimitManagmentDBDAO 
	 * @param List<PortLimitsDataVO> portLimitsUnNoVOs
	 * @exception EventException
	 */
	public void removePortLimitsUnNo(List<PortLimitsDataVO> portLimitsUnNoVOs) throws DAOException {
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			
			//velocity parameter
			if (portLimitsUnNoVOs.size() > 0) {

				delCnt = sqlExe.executeBatch((ISQLTemplate) new PortLimitManagmentDBDAODeletePortLimitsUnNoDSQL(), portLimitsUnNoVOs, velParam);
				
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
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
	 * VOP_SCG_5923 : Remove <br>
	 * Manage Port Limit Info
	 * @category VOP_SCG_5923
	 * @category PortLimitManagmentDBDAO 
	 * @param List<PortLmtSubsRskVO> portLmtSubsRskVOs
	 * @exception EventException
	 */
	public void removePortLimitsSubRsk(List<PortLmtSubsRskVO> portLmtSubsRskVOs) throws DAOException {
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			
			//velocity parameter
			if (portLmtSubsRskVOs.size() > 0) {

				delCnt = sqlExe.executeBatch((ISQLTemplate) new PortLimitManagmentDBDAODeletePortLimitsSubRskDSQL(), portLmtSubsRskVOs, velParam);
				
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
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
	 * VOP_SCG_5022 : Retrieve <br>
	 * Retrieve Port Limits DG Total Weight
	 * @category VOP_SCG_5022
	 * @category PortLimitManagmentDBDAO
	 * @param PortLimitsDgTotalWeightVO portLimitsDgTotalWeightVO
	 * @return List<PortLimitsDgTotalWeightVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<PortLimitsDgTotalWeightVO> searchPortLimitsDgTotalWeightCheck(PortLimitsDgTotalWeightVO portLimitsDgTotalWeightVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<PortLimitsDgTotalWeightVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(portLimitsDgTotalWeightVO != null){
				Map<String, String> mapVO = portLimitsDgTotalWeightVO.getColumnValues();
		            
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortLimitManagmentDBDAOSearchPortLimitsDgTtlWgtRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PortLimitsDgTotalWeightVO .class);
			
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;		
	}
	
	/**
	 * VOP_SCG_5022 : Retrieve <br>
	 * Retrieve Port Limits DG Total Weight(CNSHA)
	 * @category VOP_SCG_5022
	 * @category PortLimitManagmentDBDAO
	 * @param PortLimitsDgTotalWeightVO portLimitsDgTotalWeightVO
	 * @return List<PortLimitsDgTotalWeightVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<PortLimitsDgTotalWeightVO> searchPortLimitsDgTotalWeightCheckSha(PortLimitsDgTotalWeightVO portLimitsDgTotalWeightVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<PortLimitsDgTotalWeightVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(portLimitsDgTotalWeightVO != null){
				Map<String, String> mapVO = portLimitsDgTotalWeightVO.getColumnValues();
		            
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortLimitManagmentDBDAOSearchPortLimitsDgTtlWgtShaRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PortLimitsDgTotalWeightVO .class);
			
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;		
	}
	
	/**
	 * VOP_SCG_5021 : Remove Port Limits Data For renumbering "port_lmt_seq" <br>
	 * Manage Port Limit Info
	 * @category VOP_SCG_5021
	 * @category PortLimitManagmentDBDAO 
	 * @param String PortCd
	 * @exception EventException
	 */
	public void removePortLimitsDataForSeq(String PortCd) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = 0;
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, String> mapVO =  new HashMap<String, String>();
			 
			mapVO.put("port_cd", PortCd);
			param.putAll(mapVO);

			result = sqlExe.executeUpdate((ISQLTemplate)new PortLimitManagmentDBDAODeletePortLimitsDataForSeqDSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");
			}
		}catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}
      
	/**
	 * VOP_SCG_5921 : PortLmtSeq Search & Setting
	 * @param portLimitsDataVO
	 * @return
	 * @throws DAOException
	 */
	public String srchPortLmtSeq(PortLimitsDataVO portLimitsDataVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(portLimitsDataVO != null){
				Map<String, String> mapVO = portLimitsDataVO.getColumnValues();
		            
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PortLimitManagmentDBDAOSearchPortLimitSeqRSQL(),param, null);
			if (dbRowset.next()) {
				return dbRowset.getString("port_lmt_seq");
			} else return "";

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
}
