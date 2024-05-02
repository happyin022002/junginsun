/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReeferSparePartMgtDBDAO.java
*@FileTitle : Reefer Spare Part
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 권영법
*@LastVersion : 1.0
* 2009.09.02 권영법
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.reefersparepartmgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.mnr.generalmanage.reefersparepartmgt.vo.MnrReeferSparePartCodeVO;
import com.clt.apps.opus.ees.mnr.generalmanage.reefersparepartmgt.vo.RFSparePartCodeMgtINVO;
import com.clt.apps.opus.ees.mnr.generalmanage.reefersparepartmgt.vo.RFSparePartInventoryListVO;
import com.clt.apps.opus.ees.mnr.generalmanage.reefersparepartmgt.vo.RFSparePartInventoryMgtINVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


   
/** 
 * COM GeneralCodeMgtDBDAO <br>
 * - COM-GeneralManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 권영법
 * @see GeneralCodeMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class ReeferSparePartMgtDBDAO extends DBDAOSupport {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * [EES_MNR_0214]Vessel Reefer Spare Part Purchase W/O Creation의 정보를 조회 합니다. <br>
	 *
	 * @param RFSparePartCodeMgtINVO rfSparePartCodeMgtINVO
	 * @return List<MnrReeferSparePartCodeVO>
	 * @exception DAOException
	 */
		 @SuppressWarnings("unchecked")
		 public List<MnrReeferSparePartCodeVO> searchRFsparePartCodeListData(RFSparePartCodeMgtINVO rfSparePartCodeMgtINVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<MnrReeferSparePartCodeVO> list = null;

			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(rfSparePartCodeMgtINVO != null){
					if (rfSparePartCodeMgtINVO.getSprUtTpNm() != null && rfSparePartCodeMgtINVO.getSprTpCd()!= null) {
					     param.put("spr_prt_no", rfSparePartCodeMgtINVO.getSprPrtNo());    
					     velParam.put("spr_prt_no", rfSparePartCodeMgtINVO.getSprPrtNo());
						param.put("spr_ut_tp_nm", rfSparePartCodeMgtINVO.getSprUtTpNm());    
					     velParam.put("spr_ut_tp_nm", rfSparePartCodeMgtINVO.getSprUtTpNm());
					     param.put("spr_tp_cd", rfSparePartCodeMgtINVO.getSprTpCd());    
					     velParam.put("spr_tp_cd", rfSparePartCodeMgtINVO.getSprTpCd());
					     param.put("spr_prt_spl_tp_cd", rfSparePartCodeMgtINVO.getSprPrtSplTpCd());    
					     velParam.put("spr_prt_spl_tp_cd", rfSparePartCodeMgtINVO.getSprPrtSplTpCd());
					     velParam.put("spr_work_type", rfSparePartCodeMgtINVO.getSprWorkType());
					} 
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReeferSparePartMgtDBDAOsearchRFsparePartCodeListDataRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, MnrReeferSparePartCodeVO .class);
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
		  * [EES_MNR_0137]Standard Reefer Spare Parts List of the vsl의 정보를 체크 합니다. <br>
		  *
		  * @param List<MnrReeferSparePartCodeVO> mnrReeferSparePartCodeVOs
		  * @return List<MnrReeferSparePartCodeVO>
		  * @exception DAOException
		  */
			 @SuppressWarnings("unchecked")
			 public List<MnrReeferSparePartCodeVO> checkRFsparePartCodeData(List<MnrReeferSparePartCodeVO> mnrReeferSparePartCodeVOs) throws DAOException {
				DBRowSet dbRowset = null;
				List<MnrReeferSparePartCodeVO> list = null;
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				try{
					if(mnrReeferSparePartCodeVOs.size() > 0){
					    param.put("spr_prt_no",mnrReeferSparePartCodeVOs.get(0).getSprPrtNo());    
						velParam.put("spr_prt_no", mnrReeferSparePartCodeVOs.get(0).getSprPrtNo());

					}
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReeferSparePartMgtDBDAOcheckRFsparePartCodeDataRSQL(), param, velParam);
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, MnrReeferSparePartCodeVO .class);
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
			  * [EES_MNR_0137]Standard Reefer Spare Parts List of the vsl의 정보를 추가 합니다. <br>
			  *
			  * @param List<MnrReeferSparePartCodeVO> mnrReeferSparePartCodeVOs
			  * @exception DAOException
			  */
			public void addRFsparePartCodeData(List<MnrReeferSparePartCodeVO> mnrReeferSparePartCodeVOs) throws DAOException,Exception {
				try {
					SQLExecuter sqlExe = new SQLExecuter("");
					int insCnt[] = null;
					if(mnrReeferSparePartCodeVOs.size() > 0){ 
						insCnt = sqlExe.executeBatch((ISQLTemplate)new ReeferSparePartMgtDBDAOaddRFsparePartCodeDataCSQL(), mnrReeferSparePartCodeVOs,null);
						for(int i = 0; i < insCnt.length; i++){
							if(insCnt[i]== Statement.EXECUTE_FAILED)
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
			 * [EES_MNR_0137]Standard Reefer Spare Parts List of the vsl의 정보를 수정 합니다. <br>
			 *
			 * @param List<MnrReeferSparePartCodeVO> mnrReeferSparePartCodeVOs
			 * @exception DAOException
			 */
			public void modifyRFsparePartCodeData(List<MnrReeferSparePartCodeVO> mnrReeferSparePartCodeVOs) throws DAOException,Exception {
				try {
					
					SQLExecuter sqlExe = new SQLExecuter("");
					int updCnt[] = null;
					if(mnrReeferSparePartCodeVOs.size() > 0){
						updCnt = sqlExe.executeBatch((ISQLTemplate)new ReeferSparePartMgtDBDAOmodifyRFsparePartCodeDataUSQL(), mnrReeferSparePartCodeVOs,null);
						for(int i = 0; i < updCnt.length; i++){
							if(updCnt[i]== Statement.EXECUTE_FAILED)
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
			 * [EES_MNR_0137]Standard Reefer Spare Parts List of the vsl의 정보를 삭제 합니다. <br>
			 *
			 * @param List<MnrReeferSparePartCodeVO> mnrReeferSparePartCodeVOs
			 * @exception DAOException
			 */
			public void removeRFsparePartCodeData(List<MnrReeferSparePartCodeVO> mnrReeferSparePartCodeVOs) throws DAOException,Exception {
				
				try {
					//velocity parameter
					Map<String, Object> velParam = new HashMap<String, Object>();

					SQLExecuter sqlExe = new SQLExecuter("");
					int delCnt[] = null;
					if(mnrReeferSparePartCodeVOs.size() > 0){
						velParam.put("spr_prt_no", mnrReeferSparePartCodeVOs.get(0).getSprPrtNo());
						delCnt = sqlExe.executeBatch((ISQLTemplate)new ReeferSparePartMgtDBDAOremoveRFsparePartCodeDataDSQL(), mnrReeferSparePartCodeVOs,velParam);
						for(int i = 0; i < delCnt.length; i++){
							if(delCnt[i]== Statement.EXECUTE_FAILED)
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
			 * [EES_MNR_0056]VSL Reefer Spare part Inventory의 정보를 조회 합니다. <br>
			 *
			 * @param RFSparePartInventoryMgtINVO rfSparePartInventoryMgtINVO
			 * @return List<RFSparePartInventoryListVO>
			 * @exception DAOException
			 */
			 @SuppressWarnings("unchecked")
			 public List<RFSparePartInventoryListVO> searchRFSparePartInventoryListData(RFSparePartInventoryMgtINVO rfSparePartInventoryMgtINVO) throws DAOException {
				DBRowSet dbRowset = null;
				List<RFSparePartInventoryListVO> list = null;

				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();

				try{ 
					if(rfSparePartInventoryMgtINVO != null){
						if (rfSparePartInventoryMgtINVO.getVslSlanCd() != null ) {
						     param.put("vsl_slan_cd", rfSparePartInventoryMgtINVO.getVslSlanCd());    
						     velParam.put("vsl_slan_cd", rfSparePartInventoryMgtINVO.getVslSlanCd());
							 param.put("date_gubun", rfSparePartInventoryMgtINVO.getDateGubun());    
						     velParam.put("date_gubun", rfSparePartInventoryMgtINVO.getDateGubun());
							 param.put("fromcal", rfSparePartInventoryMgtINVO.getFromcal());    
							 velParam.put("fromcal", rfSparePartInventoryMgtINVO.getFromcal());
							 param.put("tocal", rfSparePartInventoryMgtINVO.getTocal());    
						     velParam.put("spr_ut_tp_nm", rfSparePartInventoryMgtINVO.getTocal());
						     param.put("spr_tp_cd", rfSparePartInventoryMgtINVO.getSprTpCd());    
						     velParam.put("spr_tp_cd", rfSparePartInventoryMgtINVO.getSprTpCd());
						     if(!rfSparePartInventoryMgtINVO.getVslCd().equals(""))
						     {
							     param.put("vsl_cd", rfSparePartInventoryMgtINVO.getVslCd());    
							     velParam.put("vsl_cd", rfSparePartInventoryMgtINVO.getVslCd());
						     }else{
							     param.put("vsl_cd", "");    
							     velParam.put("vsl_cd", "");
						     }
						} 
					}
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReeferSparePartMgtDBDAOsearchRFSparePartInventoryListDataRSQL(), param, velParam);
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, RFSparePartInventoryListVO .class);
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
			  * [EES_MNR_0056]VSL Reefer Spare part Inventory의 정보를 체크 합니다. <br>
			  *
			  * @param List<RFSparePartInventoryListVO> rFSparePartInventoryListVOs
			  * @return List<RFSparePartInventoryListVO>
			  * @exception DAOException
			  */
			 @SuppressWarnings("unchecked")
			 public List<RFSparePartInventoryListVO> checkRFSparePartInventoryData(List<RFSparePartInventoryListVO> rFSparePartInventoryListVOs) throws DAOException {
				DBRowSet dbRowset = null;
				List<RFSparePartInventoryListVO> list = null;
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				try{
					if(rFSparePartInventoryListVOs.size() > 0){
					    param.put("vsl_cd",rFSparePartInventoryListVOs.get(0).getVslSlanCd());    
						velParam.put("vsl_cd", rFSparePartInventoryListVOs.get(0).getVslSlanCd());

					}
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReeferSparePartMgtDBDAOcheckRFSparePartInventoryDataRSQL(), param, velParam);
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, RFSparePartInventoryListVO .class);
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
			  * [EES_MNR_0056]VSL Reefer Spare part Inventory의 정보를 추가 합니다. <br>
			  *
			  * @param List<RFSparePartInventoryListVO> rFSparePartInventoryListVOs
			  * @exception DAOException
			  */
			public void addRFSparePartInventoryData(List<RFSparePartInventoryListVO> rFSparePartInventoryListVOs) throws DAOException,Exception {
				try {
					SQLExecuter sqlExe = new SQLExecuter("");
					int insCnt[] = null;
					if(rFSparePartInventoryListVOs.size() > 0){ 
						insCnt = sqlExe.executeBatch((ISQLTemplate)new ReeferSparePartMgtDBDAOaddRFSparePartInventoryDataCSQL(), rFSparePartInventoryListVOs,null);
						for(int i = 0; i < insCnt.length; i++){
							if(insCnt[i]== Statement.EXECUTE_FAILED)
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
			 * [EES_MNR_0056]VSL Reefer Spare part Inventory의 정보를 수정 합니다. <br>
			 *
			 * @param List<RFSparePartInventoryListVO> rFSparePartInventoryListVOs
			 * @exception DAOException
			 */
			public void modifyRFSparePartInventoryData(List<RFSparePartInventoryListVO> rFSparePartInventoryListVOs) throws DAOException,Exception {
				try {
					
					SQLExecuter sqlExe = new SQLExecuter("");
					int updCnt[] = null;
					if(rFSparePartInventoryListVOs.size() > 0){
						updCnt = sqlExe.executeBatch((ISQLTemplate)new ReeferSparePartMgtDBDAOmodifyRFSparePartInventoryDataUSQL(), rFSparePartInventoryListVOs,null);
						for(int i = 0; i < updCnt.length; i++){
							if(updCnt[i]== Statement.EXECUTE_FAILED)
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
			 * [EES_MNR_0056]VSL Reefer Spare part Inventory의 정보를 삭제 합니다. <br>
			 *
			 * @param List<RFSparePartInventoryListVO> rFSparePartInventoryListVOs
			 * @exception DAOException
			 */
			public void removeRFSparePartInventoryData(List<RFSparePartInventoryListVO> rFSparePartInventoryListVOs) throws DAOException,Exception {
				
				try {
					//velocity parameter
					Map<String, Object> velParam = new HashMap<String, Object>();

					SQLExecuter sqlExe = new SQLExecuter("");
					int delCnt[] = null;
					if(rFSparePartInventoryListVOs.size() > 0){
						velParam.put("vsl_cd", rFSparePartInventoryListVOs.get(0).getVslCd());
						delCnt = sqlExe.executeBatch((ISQLTemplate)new ReeferSparePartMgtDBDAOremoveRFSparePartInventoryDataDSQL(), rFSparePartInventoryListVOs,velParam);
						for(int i = 0; i < delCnt.length; i++){
							if(delCnt[i]== Statement.EXECUTE_FAILED)
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
