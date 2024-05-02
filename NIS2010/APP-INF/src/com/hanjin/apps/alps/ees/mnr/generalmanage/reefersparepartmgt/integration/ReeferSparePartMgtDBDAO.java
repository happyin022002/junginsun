/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReeferSparePartMgtDBDAO.java
*@FileTitle : Reefer Spare Part
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 亦낅슣�븃린占�
*@LastVersion : 1.0
* 2009.09.02 亦낅슣�븃린占�
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.mnr.generalmanage.generalcodemgt.basic.GeneralCodeMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.vo.MnrReeferSparePartCodeVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.vo.MnrVslSprPrtInvtVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.vo.RFSparePartCodeMgtINVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.vo.RFSparePartInventoryListVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.vo.RFSparePartInventoryMgtINVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.vo.RFVessleSparePartCodeVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
   
/** 
 * alps GeneralCodeMgtDBDAO <br>
 * - alps-GeneralManage system Business Logic占쏙옙筌ｌ꼶�곻옙�띾┛ 占쎄쑵釉�JDBC 占쎈쵐毓쏙옙�묐뻬.<br>
 * 
 * @author 亦낅슣�븃린占�
 * @see GeneralCodeMgtBCImpl 筌〓챷��
 * @since J2EE 1.4
 */
public class ReeferSparePartMgtDBDAO extends DBDAOSupport {
	/**
	 * [EES_MNR_0214]Vessel Reefer Spare Part Purchase W/O Creation占쏙옙占쎈베�ョ몴占썼�怨좎돳 占썩뫖�뀐옙占�<br>
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
		  * [EES_MNR_0137]Standard Reefer Spare Parts List of the vsl占쏙옙占쎈베�ョ몴占쏙㎗�꾧쾿 占썩뫖�뀐옙占�<br>
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
			  * [EES_MNR_0137]Standard Reefer Spare Parts List of the vsl占쏙옙占쎈베�ョ몴占썹빊遺쏙옙 占썩뫖�뀐옙占�<br>
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
			 * [EES_MNR_0137]Standard Reefer Spare Parts List of the vsl占쏙옙占쎈베�ョ몴占쏙옙�륁젟 占썩뫖�뀐옙占�<br>
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
			 * [EES_MNR_0137]Standard Reefer Spare Parts List of the vsl占쏙옙占쎈베�ョ몴占쏙옙占쎌젫 占썩뫖�뀐옙占�<br>
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
			 * [EES_MNR_0056]VSL Reefer Spare part Inventory占쏙옙占쎈베�ョ몴占썼�怨좎돳 占썩뫖�뀐옙占�<br>
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
			  * [EES_MNR_0056]VSL Reefer Spare part Inventory占쏙옙占쎈베�ョ몴占쏙㎗�꾧쾿 占썩뫖�뀐옙占�<br>
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
			  * [EES_MNR_0056]VSL Reefer Spare part Inventory占쏙옙占쎈베�ョ몴占썹빊遺쏙옙 占썩뫖�뀐옙占�<br>
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
			 * [EES_MNR_0056]VSL Reefer Spare part Inventory占쏙옙占쎈베�ョ몴占쏙옙�륁젟 占썩뫖�뀐옙占�<br>
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
			 * [EES_MNR_0056]VSL Reefer Spare part Inventory占쏙옙占쎈베�ョ몴占쏙옙占쎌젫 占썩뫖�뀐옙占�<br>
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
			
			/**
			 * [EES_MNR_0266]VSL Reefer Spare vessel part Inventory占쏙옙占쎈베�ョ몴占썼�怨좎돳 占썩뫖�뀐옙占�<br>
			 *
			 * @param RFVessleSparePartCodeVO rfVessleSparePartCodeVO
			 * @return List<RFVessleSparePartCodeVO>
			 * @exception DAOException
			 */
			@SuppressWarnings("unchecked")
			 public List<RFVessleSparePartCodeVO> searchVessleSparePartCodeListData(RFVessleSparePartCodeVO rfVessleSparePartCodeVO) throws DAOException {
				DBRowSet dbRowset = null;
				List<RFVessleSparePartCodeVO> list = null;

				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();

				try{
					if(rfVessleSparePartCodeVO != null) {						
						if (rfVessleSparePartCodeVO.getSprPrtVerSeq()!= null) {
						     param.put("spr_prt_ver_seq", rfVessleSparePartCodeVO.getSprPrtVerSeq());    
						     velParam.put("spr_prt_ver_seq", rfVessleSparePartCodeVO.getSprPrtVerSeq());							
						}						
					}
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReeferSparePartMgtDBDAOsearchVesselSparePartCodeListDataRSQL(), param, velParam);
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, RFVessleSparePartCodeVO .class);
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
			 * [EES_MNR_0266]VSL Reefer Spare vessel part Inventory占쏙옙占썬끇已�VER SEQ�쒙옙鈺곌퀬��占썩뫖�뀐옙占�<br>
			 *
			 * @return String verSeq
			 * @exception DAOException
			 */
			 public String searchNewVesselSparePartVer() throws DAOException {
				DBRowSet dbRowset = null;
				String 	verSeq = "";

				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();

				try{
					
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReeferSparePartMgtDBDAOsearchNewVesselSparePartVerRSQL(), param, velParam);
					
					if(dbRowset.next()){
						verSeq = dbRowset.getString("VER_SEQ");
					}
						
				}catch(SQLException se){
					log.error(se.getMessage(),se); 
					throw new DAOException(new ErrorHandler(se).getMessage());
				}catch(Exception ex){
					log.error(ex.getMessage(),ex);
					throw new DAOException(new ErrorHandler(ex).getMessage());
				}
				
				return verSeq;
			}
		 
			 /**
			  * [EES_MNR_0266]VSL Reefer Spare part Inventory占쏙옙占쎈베�ョ몴占썹빊遺쏙옙 占썩뫖�뀐옙占�<br>
			  *
			  * @param List<RFVessleSparePartCodeVO> rfVessleSparePartCodeVOs
			  * @exception DAOException
			  */
			public void addVesselSparePartCdData(List<RFVessleSparePartCodeVO> rfVessleSparePartCodeVOs) throws DAOException,Exception {
				try {
					SQLExecuter sqlExe = new SQLExecuter("");
					int insCnt[] = null;
					if(rfVessleSparePartCodeVOs.size() > 0){ 
						insCnt = sqlExe.executeBatch((ISQLTemplate)new ReeferSparePartMgtDBDAOaddVesselSparePartCdDataCSQL(), rfVessleSparePartCodeVOs,null);
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
			 * [EES_MNR_0266]VSL Reefer Spare part Inventory占쏙옙占쎈베�ョ몴占�占쎌꼷��占썩뫖�뀐옙占�<br>
			 *
			 * @param List<RFVessleSparePartCodeVO> rfVessleSparePartCodeVOs
			 * @exception DAOException
			 */
			public void modifyVesselSparePartCdData(List<RFVessleSparePartCodeVO> rfVessleSparePartCodeVOs) throws DAOException,Exception {
				try {
					
					SQLExecuter sqlExe = new SQLExecuter("");
					int updCnt[] = null;
					if(rfVessleSparePartCodeVOs.size() > 0){
						updCnt = sqlExe.executeBatch((ISQLTemplate)new ReeferSparePartMgtDBDAOmodifyVesselSparePartCdDataUSQL(), rfVessleSparePartCodeVOs,null);
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
			 * [EES_MNR_0268]Spare Part VSL Inventory Inquiry 占쏙옙占쎈베�ョ몴占썼�怨좎돳 占썩뫖�뀐옙占�<br>
			 *
			 * @param MnrVslSprPrtInvtVO mnrVslSprPrtInvtVO
			 * @return List<MnrVslSprPrtInvtVO>
			 * @exception DAOException
			 */
			@SuppressWarnings("unchecked")
			 public List<MnrVslSprPrtInvtVO> searchVesselSparePartInventoryList(MnrVslSprPrtInvtVO mnrVslSprPrtInvtVO) throws DAOException {
				DBRowSet dbRowset = null;
				List<MnrVslSprPrtInvtVO> list = null;

				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();

				try{
					if(mnrVslSprPrtInvtVO != null){		
						if(mnrVslSprPrtInvtVO.getFromDt() != null) {
						     param.put("from_dt", mnrVslSprPrtInvtVO.getFromDt());    
						     param.put("to_dt", mnrVslSprPrtInvtVO.getToDt());    
						     velParam.put("from_dt", mnrVslSprPrtInvtVO.getFromDt());	
						     velParam.put("to_dt", mnrVslSprPrtInvtVO.getToDt());	
						}
						if (mnrVslSprPrtInvtVO.getLaneCd()!= null) {
						     param.put("lane_cd", mnrVslSprPrtInvtVO.getLaneCd());    
						     velParam.put("lane_cd", mnrVslSprPrtInvtVO.getLaneCd());							
						}
						if (mnrVslSprPrtInvtVO.getVslCd()!= null) {
						     param.put("vsl_cd", mnrVslSprPrtInvtVO.getVslCd());    
						     velParam.put("vsl_cd", mnrVslSprPrtInvtVO.getVslCd());							
						}
						if (mnrVslSprPrtInvtVO.getSprPrtTpCd()!= null) {
						     param.put("spr_prt_tp_cd", mnrVslSprPrtInvtVO.getSprPrtTpCd());    
						     velParam.put("spr_prt_tp_cd", mnrVslSprPrtInvtVO.getSprPrtTpCd());							
						}						
						if (mnrVslSprPrtInvtVO.getSprPrtVndrSeq()!= null) {
						     param.put("spr_prt_vndr_seq", mnrVslSprPrtInvtVO.getSprPrtVndrSeq());    
						     velParam.put("spr_prt_vndr_seq", mnrVslSprPrtInvtVO.getSprPrtVndrSeq());							
						}							
						
					}
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReeferSparePartMgtDBDAOsearchVesselSparePartInventoryListRSQL(), param, velParam);
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, MnrVslSprPrtInvtVO .class);
					
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
			 * [EES_MNR_0067]VSL Reefer Spare part Inventory 紐⑸줉 議고쉶<br>
			 *
			 * @param List<MnrVslSprPrtInvtVO> mnrVslSprPrtInvtVOs
			 * @return DBRowSet
			 * @exception DAOException
			 */
			public DBRowSet searchVessleInventoryListData(
					MnrVslSprPrtInvtVO mnrVslSprPrtInvtVO) throws DAOException,Exception {
				DBRowSet dbRowset = null;
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				try{
					if(mnrVslSprPrtInvtVO != null){
						if (mnrVslSprPrtInvtVO.getSprPrtInvtNo() != null) {
							param.put("spr_prt_invt_no",mnrVslSprPrtInvtVO.getSprPrtInvtNo());    
							velParam.put("spr_prt_invt_no", mnrVslSprPrtInvtVO.getSprPrtInvtNo());
						}
					}
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReeferSparePartMgtDBDAOsearchVesselInventoryListDataRSQL(), param, velParam);

				}catch(SQLException se){
					log.error(se.getMessage(),se); 
					throw new DAOException(new ErrorHandler(se).getMessage());
				}catch(Exception ex){
					log.error(ex.getMessage(),ex);
					throw new DAOException(new ErrorHandler(ex).getMessage());
				}
				return dbRowset;
			}
			/**
			 * [EES_MNR_0067]VSL Reefer Spare part Inventory 紐⑸줉 議고쉶 <br>
			 *
			 * @param MnrVslSprPrtInvtVO mnrVslSprPrtInvtVO
			 * @return List<MnrVslSprPrtInvtVO>
			 * @exception DAOException
			 */
			public List<MnrVslSprPrtInvtVO> searchVessleInventoryListDataByVOs(
					MnrVslSprPrtInvtVO mnrVslSprPrtInvtVO) throws DAOException,Exception {
				DBRowSet dbRowset = null;
				List<MnrVslSprPrtInvtVO> list = null;
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				try{
					if(mnrVslSprPrtInvtVO != null){
						if (mnrVslSprPrtInvtVO.getSprPrtInvtNo() != null) {
							param.put("spr_prt_invt_no",mnrVslSprPrtInvtVO.getSprPrtInvtNo());    
							velParam.put("spr_prt_invt_no", mnrVslSprPrtInvtVO.getSprPrtInvtNo());
						}
					}
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReeferSparePartMgtDBDAOsearchVesselInventoryListDataRSQL(), param, velParam);
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, MnrVslSprPrtInvtVO .class);
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
			 * [EES_MNR_0067]VSL Reefer Spare vessel part Inventory No 議고쉶 <br>
			 *
			 * @param MnrVslSprPrtInvtVO mnrVslSprPrtInvtVO
			 * @return String
			 * @exception DAOException
			 */
			 public String checkVesselSparePartInventoryNo(MnrVslSprPrtInvtVO mnrVslSprPrtInvtVO) throws DAOException {
					DBRowSet dbRowset = null;
					String rtnVal = "";
			 
					//query parameter
					Map<String, Object> param = new HashMap<String, Object>();
					//velocity parameter
					Map<String, Object> velParam = new HashMap<String, Object>();
			 
					try{
						param.put("spr_prt_invt_no", mnrVslSprPrtInvtVO.getSprPrtInvtNo());
						velParam.put("spr_prt_invt_no", mnrVslSprPrtInvtVO.getSprPrtInvtNo());
					    param.put("ofc_cd", mnrVslSprPrtInvtVO.getOfcCd());    
					    velParam.put("ofc_cd", mnrVslSprPrtInvtVO.getOfcCd());							
			 	    				 
						dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReeferSparePartMgtDBDAOcheckVesselSparePartInventoryMaxDataRSQL(), param, velParam);
				 
						if(dbRowset.next()){
							rtnVal = dbRowset.getString("SPR_PRT_INVT_NO");
						}
					}catch(SQLException se){
						log.error(se.getMessage(),se);
						throw new DAOException(new ErrorHandler(se).getMessage());
					}catch(Exception ex){
						log.error(ex.getMessage(),ex);
						throw new DAOException(new ErrorHandler(ex).getMessage());
					}
					return rtnVal;				
			}

			 /**
				 * [EES_MNR_0067]VSL Reefer Spare vessel part Inventory 愿�━ <br>
				 * - 疫꿸퀣��占쎄낱源�몴占�D'嚥∽옙獄쏅떽���占쏙쭗�ㅻ군 Row�쒙옙'I'嚥∽옙Insert
				 * @param List<MnrVslSprPrtInvtVO> mnrVslSprPrtInvtVOs
				 * @exception DAOException
				 */
			public void modifyVesselSparePartInventoryData(	List<MnrVslSprPrtInvtVO> mnrVslSprPrtInvtVOs) throws DAOException {
				try {
					
					SQLExecuter sqlExe = new SQLExecuter("");
					int updCnt[] = null;
					if(mnrVslSprPrtInvtVOs.size() > 0){
						updCnt = sqlExe.executeBatch((ISQLTemplate)new ReeferSparePartMgtDBDAOmodifyVesselSparePartInventoryDataUSQL(), mnrVslSprPrtInvtVOs,null);
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
			 * [EES_MNR_0067]VSL Reefer Spare vessel part Inventory Version 議고쉶 <br>
			 *
			 * @param MnrVslSprPrtInvtVO mnrVslSprPrtInvtVO
			 * @return String
			 * @exception DAOException
			 */
			public String checkVesselSparePartInventoryVerSeq(MnrVslSprPrtInvtVO mnrVslSprPrtInvtVO) throws DAOException {
				DBRowSet dbRowset = null;
				String rtnVal = "";
		 
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
		 
				try{
					
				    param.put("spr_prt_invt_no", mnrVslSprPrtInvtVO.getSprPrtInvtNo());    
				    velParam.put("spr_prt_invt_no", mnrVslSprPrtInvtVO.getSprPrtInvtNo());
				    
				    param.put("spr_prt_invt_ver_seq", mnrVslSprPrtInvtVO.getSprPrtInvtVerSeq());    
				    velParam.put("spr_prt_invt_ver_seq", mnrVslSprPrtInvtVO.getSprPrtInvtVerSeq());
		 	    				 
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReeferSparePartMgtDBDAOcheckVesselSparePartInventoryVersionMaxDataRSQL(), param, velParam);
			 
					if(dbRowset.next()){
						rtnVal = dbRowset.getString("SPR_PRT_INVT_VER_SEQ");
					}
				}catch(SQLException se){
					log.error(se.getMessage(),se);
					throw new DAOException(new ErrorHandler(se).getMessage());
				}catch(Exception ex){
					log.error(ex.getMessage(),ex);
					throw new DAOException(new ErrorHandler(ex).getMessage());
				}
				return rtnVal;
			}

			/**
			 * [EES_MNR_0067]VSL Reefer Spare vessel part Inventory 異붽� <br>
			 * 
			 * @param List<MnrVslSprPrtInvtVO> mnrVslSprPrtInvtVOs
			 * @exception DAOException
			 */
			public void addVesselSparePartInventoryData(
					List<MnrVslSprPrtInvtVO> mnrVslSprPrtInvtVOs) throws DAOException {
				try {
					SQLExecuter sqlExe = new SQLExecuter("");
					int insCnt[] = null;
					if(mnrVslSprPrtInvtVOs.size() > 0){ 
						insCnt = sqlExe.executeBatch((ISQLTemplate)new ReeferSparePartMgtDBDAOaddVesselSparePartlInventoryDataCSQL(), mnrVslSprPrtInvtVOs,null);
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
			 * [EES_MNR_0067]VSL Reefer Spare vessel part Inventory占쏙옙占쏙옙��占썩뫖�뀐옙占�<br>
			 * 
			 * @param List<MnrVslSprPrtInvtVO> mnrVslSprPrtInvtVOs
			 * @exception DAOException
			 */
			public void removeVesselSparePartInventoryData(
					List<MnrVslSprPrtInvtVO> mnrVslSprPrtInvtVOs) throws DAOException {
				try {					
					SQLExecuter sqlExe = new SQLExecuter("");
					int updCnt[] = null;
					if(mnrVslSprPrtInvtVOs.size() > 0){
						updCnt = sqlExe.executeBatch((ISQLTemplate)new ReeferSparePartMgtDBDAOremoveVesselSparePartCdDataDSQL(), mnrVslSprPrtInvtVOs,null);
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
			 * [EES_MNR_0067]VSL Reefer Spare vessel part Inventory header筌뤴뫖以�鈺곌퀬��<br>
			 * 
			 * @param RFVessleSparePartCodeVO rfVessleSparePartCodeVO
			 * @exception DAOException
			 * @return List<RFVessleSparePartCodeVO>
			 */
			public List<MnrVslSprPrtInvtVO> searchVesselSparePartInventoryHeaderListData(
					MnrVslSprPrtInvtVO mnrVslSprPrtInvtVO) throws DAOException {
				DBRowSet dbRowset = null;
				List<MnrVslSprPrtInvtVO> list = null;
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				try{
					
					param.put("spr_prt_invt_no", mnrVslSprPrtInvtVO.getSprPrtInvtNo());    
				    velParam.put("spr_prt_invt_no", mnrVslSprPrtInvtVO.getSprPrtInvtNo());
				    
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReeferSparePartMgtDBDAOsearchVesselInventoryHeaderListDataRSQL(), param, velParam);
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, MnrVslSprPrtInvtVO .class);
				}catch(SQLException se){
					log.error(se.getMessage(),se); 
					throw new DAOException(new ErrorHandler(se).getMessage());
					
				}catch(Exception ex){
					log.error(ex.getMessage(),ex);
					throw new DAOException(new ErrorHandler(ex).getMessage());
				}
				return list;
			}
			
}
