/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingProcessMgtDBDAO.java
*@FileTitle : Arrival Notice: Destination Office (USA)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.04 
* 1.0 Creation
* 2011.11.29 정선용 [CHM-201113753-01] Split 01-Korea CLL 전송 후 변동사항 발생 시 SMS 자동 발송 기능 개발 요청
* 2012.10.29 윤태승 [CHM-201220903] [Office Setup] 추가시 로직보완
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.basic.BookingProcessMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCstmsAdvScacVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgDocPerfOfcVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgEsvcHndlOfcVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgUserSmsInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgUserSmsListVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgVvdBdrLogVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkganDestOfcStupVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.CgoClzTmStupVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.CodeDescVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS BookingProcessMgtDBDAO <br>
 * - ALPS-BookingMasterDataSC system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Gyoung Sub
 * @see BookingProcessMgtBCImpl 참조
 * @since J2EE 1.6
 */
public class BookingProcessMgtDBDAO extends DBDAOSupport {


	/**
	 * BookingMasterMgtDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @author Lee Jin Seo
	 * @param CodeDescVO codeDescVO
	 * @return List<CodeDescVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CodeDescVO> searchChargeCode (CodeDescVO codeDescVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CodeDescVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(codeDescVO != null){
				Map<String, String> mapVO = codeDescVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BookingMasterMgtDBDAOSearchChargeCodeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CodeDescVO .class);
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
	  * 0374  Arrival Notice의 Office Default  US Destination Office Setup 을 조회합니다.<br>
	  * 
	  * @param String officeCD
	  * @param String  handlingOfficeCD
	  * @return List<BkganDestOfcStupVO>
	  * @throws DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<BkganDestOfcStupVO> searchANDestOfcList(String officeCD,String  handlingOfficeCD) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<BkganDestOfcStupVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 Map<String, String> mapVO = new HashMap();
			 mapVO.put("p_eq_ctrl_ofc_cd", officeCD);
			 mapVO.put("p_hndl_ofc_cd", handlingOfficeCD);
			 
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BookingProcessMgtDBDAOSearchANDestOfcListRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkganDestOfcStupVO .class);
			 
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
	  * 0374  저장을 위한 조회. EQ OFC가 HQ OFC에 이미 등록되어 있으면 저장을 하지 못한다.<br>
	  * 단. EQ OFC와 HQ OFC가 같은 경우는 예외이다<br>
	  * 
	  * @param String officeCD
	  * @param String  handlingOfficeCD
	  * @return List<BkganDestOfcStupVO>
	  * @throws DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<BkganDestOfcStupVO> searchANDestOfcList2(String officeCD, String handlingOfficeCD) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<BkganDestOfcStupVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 Map<String, String> mapVO = new HashMap();
			 mapVO.put("p_eq_ctrl_ofc_cd", officeCD);
			 mapVO.put("p_hndl_ofc_cd", handlingOfficeCD);
			 
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BookingProcessMgtDBDAOSearchANDestOfcList2RSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkganDestOfcStupVO .class);
			 
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
	 *  0374  Arrival Notice의 Office Default  US Destination Office Setup 을 생성합니다.<br>
	 * 
	 * @param List<BkganDestOfcStupVO> bkganDestOfcStupVO
	 * @throws DAOException
	 */
	public void addANDestOfcList(List<BkganDestOfcStupVO> bkganDestOfcStupVO) throws DAOException,Exception {
		manageANDestOfcList(bkganDestOfcStupVO,"C");
	}
	
	
	/**
	 *  0374  Arrival Notice의 Office Default  US Destination Office Setup 을 수정합니다.<br>
	 * 
	 * @param List<BkganDestOfcStupVO> bkganDestOfcStupVO
	 * @throws DAOException
	 */
	public void modifyANDestOfcList(List<BkganDestOfcStupVO> bkganDestOfcStupVO) throws DAOException,Exception {
		manageANDestOfcList(bkganDestOfcStupVO,"U");
	}
	
	/**
	 *  0374  Arrival Notice의 Office Default  US Destination Office Setup 을 삭제합니다.<br>
	 * 
	 * @param List<BkganDestOfcStupVO> bkganDestOfcStupVO
	 * @throws DAOException
	 */
	public void removeANDestOfcList(List<BkganDestOfcStupVO> bkganDestOfcStupVO) throws DAOException,Exception {
		manageANDestOfcList(bkganDestOfcStupVO,"D");
	}
	
	/**
	 *  0374  Arrival Notice의 Office Default  US Destination Office Setup 을 트랜잭션 처리합니다.<br>
	 * 
	 * @param List<BkganDestOfcStupVO> bkganDestOfcStupVO
	 * @param String cudGubun
	 * @throws DAOException
	 */
	public void manageANDestOfcList(List<BkganDestOfcStupVO> bkganDestOfcStupVO,String cudGubun) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(bkganDestOfcStupVO.size() > 0){
				
				if (cudGubun.equals("C") || cudGubun.equals("U")){
					updCnt = sqlExe.executeBatch((ISQLTemplate)new BookingProcessMgtDBDAOManageANDestOfcListUSQL(), bkganDestOfcStupVO,null);
					
				}else if (cudGubun.equals("D")){
					updCnt = sqlExe.executeBatch((ISQLTemplate)new BookingProcessMgtDBDAORemoveANDestOfcListDSQL(), bkganDestOfcStupVO,null);
				}
				
				for(int i = 0; updCnt != null && i < updCnt.length; i++){
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
	  * Office Setup 에 정보를 조회합니다.<br>
	  * 
	  * @param BkgDocPerfOfcVO bkgDocPerfOfcVO
	  * @return List<BkgDocPerfOfcVO>
	  * @exception  DAOException
	  */
	@SuppressWarnings("unchecked")
	public List<BkgDocPerfOfcVO> searchOfficePfmc(BkgDocPerfOfcVO bkgDocPerfOfcVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgDocPerfOfcVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String[] temp  = bkgDocPerfOfcVO.getChkOp().split(":");
		String   ofcCd = bkgDocPerfOfcVO.getOfcCd();

		try{
			if(ofcCd != null){
				param.put("chk_op", temp[1]);
				param.put("ofc_cd", ofcCd);

				velParam.put("chk_op", temp[1]);
				velParam.put("ofc_cd", ofcCd);
						}

			if (temp[0].equals("A")){
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BookingProcessMgtDBDAOBkgDocPerfOfcVORSQL(), param, velParam);
			}else{
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BookingProcessMgtDBDAOBkgEsvcHndlOfcVORSQL(), param, velParam);
			}
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgDocPerfOfcVO .class);
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
	  * Office Setup 에 Office 를 입력 합니다.<br>
	  * 
	  * @param BkgEsvcHndlOfcVO bkgEsvcHndlOfcVO
	  * @exception  DAOException
	  */
	 public void addPfmcOfficeCd(BkgEsvcHndlOfcVO bkgEsvcHndlOfcVO) throws DAOException {
		 	//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();			
			
			String option 		= bkgEsvcHndlOfcVO.getChkOp();
			String ctrlOfcCd	= bkgEsvcHndlOfcVO.getCtrlOfcCd();
			
			String[] tempOP 	= option.split(":");
			String[] tempCtrl	= ctrlOfcCd.split(":");
			
			 try{
				 if(bkgEsvcHndlOfcVO != null){
						Map<String, String> mapVO = bkgEsvcHndlOfcVO .getColumnValues();
					
						param.putAll(mapVO);
						velParam.putAll(mapVO);
					}							
					SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
					
					int insCnt = 0;
					
					//Doc Performance 
					if (tempOP[0].equals("A")){
					
						insCnt = sqlExe.executeUpdate((ISQLTemplate)new BookingProcessMgtDBDAOBkgDocPerfOfcVOCSQL(), param,velParam);
					}else{//e-Service Handling Office
						
						insCnt = sqlExe.executeUpdate((ISQLTemplate)new BookingProcessMgtDBDAOBkgEsvcHndlOfcVOCSQL(), param,velParam);
						
						if(insCnt != Statement.EXECUTE_FAILED){
														
							insCnt = sqlExe.executeUpdate((ISQLTemplate)new BookingProcessMgtDBDAOBkgEsvcHndlOfc3VOCSQL(), param,velParam);
							
							for (int i = 0 ; i < tempCtrl.length ; i++){
									
								if (tempCtrl[i] != null && !tempCtrl[i].equals("")){
									log.debug("temp ctrlOfcCd = " + tempCtrl[i]);
									bkgEsvcHndlOfcVO.setCtrlOfcCd(tempCtrl[i]);
										
									Map<String, String> mapVO = bkgEsvcHndlOfcVO .getColumnValues();
										
									param.putAll(mapVO);
									velParam.putAll(mapVO);
									
									insCnt = sqlExe.executeUpdate((ISQLTemplate)new BookingProcessMgtDBDAOBkgEsvcHndlOfc2VOCSQL(), param,velParam);
								}
							}											

						}else{
							
							throw new DAOException("Fail to update SQL");
						}				
					}
										
					if(insCnt == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to update SQL");

			 }catch(SQLException se){
				 log.error(se.getMessage(),se);
				 throw new DAOException(new ErrorHandler(se).getMessage());
			 }catch(Exception ex){
				 log.error(ex.getMessage(),ex);
				 throw new DAOException(new ErrorHandler(ex).getMessage());
			 }

	 }
	
	 /**
	  * Office Setup 에 Office 를 수정 합니다.<br>
	  * 
	  * @param BkgEsvcHndlOfcVO bkgEsvcHndlOfcVO
	  * @exception  DAOException
	  */
	 public void modifyPfmcOfficeCd(BkgEsvcHndlOfcVO bkgEsvcHndlOfcVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();			
		
		String option 		= bkgEsvcHndlOfcVO.getChkOp();
		String ctrlOfcCd	= bkgEsvcHndlOfcVO.getCtrlOfcCd();
		log.debug("option >>>>>>>> " + option);
		String[] tempOP 	= option.split(":");
		String[] tempCtrl	= ctrlOfcCd.split(":");
		
		 try{
			    if(bkgEsvcHndlOfcVO != null){
					Map<String, String> mapVO = bkgEsvcHndlOfcVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}							
				SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
				
				int insCnt = 0;

				//Doc Performance 
				if (tempOP[0].equals("A")){
				
					insCnt = sqlExe.executeUpdate((ISQLTemplate)new BookingProcessMgtDBDAOBkgDocPerfOfcVOUSQL(), param,velParam);
				}else{//e-Service Handling Office
					
					insCnt = sqlExe.executeUpdate((ISQLTemplate)new BookingProcessMgtDBDAOBkgEsvcHndlOfcVOUSQL(), param,velParam);
					
					if(insCnt != Statement.EXECUTE_FAILED){
						
						insCnt = sqlExe.executeUpdate((ISQLTemplate)new BookingProcessMgtDBDAOBkgEsvcHndlOfc3VOUSQL(), param,velParam);
						
						
						insCnt = sqlExe.executeUpdate((ISQLTemplate)new BookingProcessmgtDBDAOBkgEsvcHndlOfc2VODSQL(), param,velParam);
						
						if(insCnt != Statement.EXECUTE_FAILED){
							
							for (int i = 0 ; i < tempCtrl.length ; i++){
								
								if (tempCtrl[i] != null && !tempCtrl[i].equals("")){
									log.debug("temp ctrlOfcCd = " + tempCtrl[i]);
									bkgEsvcHndlOfcVO.setCtrlOfcCd(tempCtrl[i]);
									
									Map<String, String> mapVO = bkgEsvcHndlOfcVO .getColumnValues();
									
									param.putAll(mapVO);
									velParam.putAll(mapVO);
								
									insCnt = sqlExe.executeUpdate((ISQLTemplate)new BookingProcessMgtDBDAOBkgEsvcHndlOfc2VOCSQL(), param,velParam);
								}
							}
						}												

					}else{
						
						throw new DAOException("Fail to update SQL");
					}				
				}
									
				if(insCnt == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to update SQL");

		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }

	 }
	 
	 /**
	  * Office Setup 에 Office 를 삭제 합니다.<br>
	  * 
	  * @param BkgEsvcHndlOfcVO bkgEsvcHndlOfcVO
	  * @exception  DAOException
	  */
	 public void removePfmcOfficeCd(BkgEsvcHndlOfcVO bkgEsvcHndlOfcVO) throws DAOException {
		 	//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();			
			
			String option 		= bkgEsvcHndlOfcVO.getChkOp();
			//String ctrlOfcCd	= bkgEsvcHndlOfcVO.getCtrlOfcCd();
			
			String[] tempOP 	= option.split(":");
			//String[] tempCtrl	= ctrlOfcCd.split(":");
			
			 try{
				 if(bkgEsvcHndlOfcVO != null){
						Map<String, String> mapVO = bkgEsvcHndlOfcVO .getColumnValues();
					
						param.putAll(mapVO);
						velParam.putAll(mapVO);
					}							
					SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
					
					int insCnt = 0;
					
					//Doc Performance 
					if (tempOP[0].equals("A")){
					
						insCnt = sqlExe.executeUpdate((ISQLTemplate)new BookingProcessMgtDBDAOBkgDocPerfOfcVODSQL(), param,velParam);
					}else{//e-Service Handling Office																						
						
						insCnt = sqlExe.executeUpdate((ISQLTemplate)new BookingProcessMgtDBDAOBkgEsvcHndlOfc3VODSQL(), param,velParam);
						
						insCnt = sqlExe.executeUpdate((ISQLTemplate)new BookingProcessmgtDBDAOBkgEsvcHndlOfc2VODSQL(), param,velParam);
						
						if(insCnt != Statement.EXECUTE_FAILED){

							insCnt = sqlExe.executeUpdate((ISQLTemplate)new BookingProcessMgtDBDAOBkgEsvcHndlOfcVODSQL(), param,velParam);
						}else{
							
							throw new DAOException("Fail to update SQL");
						}	
											
					}
										
					if(insCnt == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to update SQL");

			 }catch(SQLException se){
				 log.error(se.getMessage(),se);
				 throw new DAOException(new ErrorHandler(se).getMessage());
			 }catch(Exception ex){
				 log.error(ex.getMessage(),ex);
				 throw new DAOException(new ErrorHandler(ex).getMessage());
			 }

	 }
	 
	 /**
	 * Office Setup 에 등록된 Office code 인지 여부를 체크합니다.<br>
	 * 
	 * @param BkgDocPerfOfcVO bkgDocPerfOfcVO
	 * @return List<BkgDocPerfOfcVO>
	 * @exception  DAOException
	 */
 
	 @SuppressWarnings("unchecked")
	public List<BkgDocPerfOfcVO> checkOfficePfmc(BkgDocPerfOfcVO bkgDocPerfOfcVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgDocPerfOfcVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//String ofcCd = bkgDocPerfOfcVO.getOfcCd();
		
		try{
			if(bkgDocPerfOfcVO != null){
				Map<String, String> mapVO = bkgDocPerfOfcVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BookingProcessMgtDBDAOBkgDocPerfOfc2VORSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgDocPerfOfcVO .class);
			
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
	 * NVOCC SCAC (Standard Carrier Alpha Code 정보를 조회한다.<br>
	 * @param BkgCstmsAdvScacVO bkgCstmsAdvScacVO
	 * @return List<BkgCstmsAdvScacVO>
	 * @exception  DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<BkgCstmsAdvScacVO> searchScacNumber(BkgCstmsAdvScacVO bkgCstmsAdvScacVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<BkgCstmsAdvScacVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(bkgCstmsAdvScacVO != null){
				Map<String, String> mapVO = bkgCstmsAdvScacVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BookingMasterMgtDBDAOBkgCstmsAdvScacVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsAdvScacVO .class);
			
			return list;
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * NVOCC SCAC (Standard Carrier Alpha Code) 정보를 입력 한다.<br>
	 * @param BkgCstmsAdvScacVO bkgCstmsAdvScacVO
	 * @exception  DAOException
	 */
	public void addScacNumber(BkgCstmsAdvScacVO bkgCstmsAdvScacVO) throws DAOException,Exception {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();						
		try {
			if(bkgCstmsAdvScacVO != null){
				Map<String, String> mapVO = bkgCstmsAdvScacVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new BookingMasterMgtDBDAOBkgCstmsAdvScacVOCSQL(), param,velParam);			    
			
			if(insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * NVOCC SCAC (Standard Carrier Alpha Code) 정보를 입력 한다.<br>
	 * @param BkgCstmsAdvScacVO bkgCstmsAdvScacVO
	 * @exception  DAOException
	 */
	public void addScacByCSTMS(BkgCstmsAdvScacVO bkgCstmsAdvScacVO) throws DAOException,Exception {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();						
		try {
			if(bkgCstmsAdvScacVO != null){
				Map<String, String> mapVO = bkgCstmsAdvScacVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new BookingMasterMgtDBDAOBkgCstmsAdvScacVO2CSQL(), param,velParam);
			
			if(insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * NVOCC SCAC (Standard Carrier Alpha Code) 정보를 수정 한다.<br>
	 * @param BkgCstmsAdvScacVO bkgCstmsAdvScacVO
	 * @exception  DAOException
	 */
	public void modifyScacNumber(BkgCstmsAdvScacVO bkgCstmsAdvScacVO) throws DAOException,Exception {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();						
		try {
			if(bkgCstmsAdvScacVO != null){
				Map<String, String> mapVO = bkgCstmsAdvScacVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new BookingMasterMgtDBDAOBkgCstmsAdvScacVOUSQL(), param,velParam);
			
			if(insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * NVOCC SCAC (Standard Carrier Alpha Code) 정보를 삭제 한다.<br>
	 * @param BkgCstmsAdvScacVO bkgCstmsAdvScacVO
	 * @exception  DAOException
	 */
	public void removeScacNumber(BkgCstmsAdvScacVO bkgCstmsAdvScacVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();						
		try {
			if(bkgCstmsAdvScacVO != null){
				Map<String, String> mapVO = bkgCstmsAdvScacVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new BookingMasterMgtDBDAOBkgCstmsAdvScacVODSQL(), param,velParam);
			
			if(insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * NVOCC SCAC (Standard Carrier Alpha Code) 정보를 삭제 한다.<br>
	 * @param BkgCstmsAdvScacVO bkgCstmsAdvScacVO
	 * @exception  DAOException
	 */
	public void removeScacByCSTMS(BkgCstmsAdvScacVO bkgCstmsAdvScacVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();						
		try {
			if(bkgCstmsAdvScacVO != null){
				Map<String, String> mapVO = bkgCstmsAdvScacVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new BookingMasterMgtDBDAOBkgCstmsAdvScacVO2DSQL(), param,velParam);
			
			if(insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Controlled Office 에 등록된 Office 가 H/OFC에 등록 되지 않도록 Office code 를 체크합니다.<br>
	 * 
	 * @param BkgDocPerfOfcVO bkgDocPerfOfcVO
	 * @return List<BkgDocPerfOfcVO>
	 * @exception  DAOException
	 */
 
	 @SuppressWarnings("unchecked")
	public List<BkgDocPerfOfcVO> checkCtrlOffice(BkgDocPerfOfcVO bkgDocPerfOfcVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgDocPerfOfcVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(bkgDocPerfOfcVO != null){
				Map<String, String> mapVO = bkgDocPerfOfcVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BookingProcessMgtDBDAOBkgEsvcHndlOfc2VORSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgDocPerfOfcVO .class);
			
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
	 * Activate 시점에 처음 만들어 Booking을 받을 수 있는 최종 시점을 관리 하는 BDR LOG 테이블을<br>
	 * 관리할 목적. SKD를 Update될 때마다 항상 조건을 확인한 후 VBL_ESTBDR_DT, VBL_FESTBDR_DT를<br>
	 * 수정하도록 한다.<br>
	 * 
	 * @param BkgVvdBdrLogVO bkgVvdBdrLogVO
	 * @return BkgVvdBdrLogVO
	 * @exception  DAOException
	 */
 
	 @SuppressWarnings("unchecked")
	public BkgVvdBdrLogVO manageBKGBDRLOG(BkgVvdBdrLogVO bkgVvdBdrLogVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		try{
			if(bkgVvdBdrLogVO != null){
				param.put("in_vsl_cd", bkgVvdBdrLogVO.getVslCd());
				param.put("in_skd_voy_no", bkgVvdBdrLogVO.getSkdVoyNo());
				param.put("in_skd_dir_cd", bkgVvdBdrLogVO.getSkdDirCd());
				param.put("in_upd_user_id", bkgVvdBdrLogVO.getUpdUsrId());
				param.put("o_result", "");
				param.put("o_err_msg", "");
			}
			log.debug("param:" + param);
			
			rtnMap = new SQLExecuter("DEFAULT") .executeSP( (ISQLTemplate) new BookingProcessMgtDBDAOManageBKGBDRLOGCSQL(), param, null);
			log.debug("---------------------------------------------------------");
			log.debug("rtnMap:" + rtnMap);
			
			bkgVvdBdrLogVO.setOResult(rtnMap.get("o_result")==null?"":(String)rtnMap.get("o_result"));
			bkgVvdBdrLogVO.setOErrMsg(rtnMap.get("o_err_msg")==null?"":(String)rtnMap.get("o_err_msg"));
            
			log.debug("---------------------------------------------------------");
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return bkgVvdBdrLogVO;
	}

	/**
	 * @param BkgUserSmsInputVO bkgUserSmsInputVO
	 * @return List<BkgUserSmsListVO>
	 * @exception  DAOException
	 */
	public List<BkgUserSmsListVO> searchSmsRcvList(BkgUserSmsInputVO bkgUserSmsInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgUserSmsListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(bkgUserSmsInputVO != null){
				Map<String, String> mapVO = bkgUserSmsInputVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BookingMasterMgtDBDAOsearchSmsRcvListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgUserSmsListVO .class);
			
			return list;
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * @param BkgUserSmsListVO bkgUserSmsListVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void addSmsRcvList(BkgUserSmsListVO bkgUserSmsListVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();						
		try {
			if(bkgUserSmsListVO != null){
				Map<String, String> mapVO = bkgUserSmsListVO .getColumnValues();
			
				param.putAll(mapVO);
				param.put("cre_usr_id", account.getUsr_id());
				param.put("upd_usr_id", account.getUsr_id());
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new BookingMasterMgtDBDAOaddSmsRcvListCSQL(), param,velParam);
			
			if(insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
	}

	/**
	 * @param BkgUserSmsListVO bkgUserSmsListVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void modifytSmsRcvList(BkgUserSmsListVO bkgUserSmsListVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();						
		try {
			if(bkgUserSmsListVO != null){
				Map<String, String> mapVO = bkgUserSmsListVO .getColumnValues();
			
				param.putAll(mapVO);
				param.put("upd_usr_id", account.getUsr_id());
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new BookingMasterMgtDBDAOmodifytSmsRcvListUSQL(), param,velParam);
			
			if(insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
	}

	/**
	 * @param BkgUserSmsListVO bkgUserSmsListVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void removeSmsRcvList(BkgUserSmsListVO bkgUserSmsListVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();						
		try {
			if(bkgUserSmsListVO != null){
				Map<String, String> mapVO = bkgUserSmsListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new BookingMasterMgtDBDAOremoveSmsRcvListDSQL(), param,velParam);
			
			if(insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * @param SignOnUserAccount account
	 * @param String slanCd
	 * @param String dirCd
	 * @return String
	 * @throws DAOException
	 */
	public String chkOfcCnt(SignOnUserAccount account, String slanCd, String dirCd) throws DAOException {
		DBRowSet dbRowset = null;
		String ofcCnt = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			
			param.put("ofc_cd", account.getOfc_cd());
			param.put("slan_cd", slanCd);
			param.put("dir_cd", dirCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BookingMasterMgtDBDAOchkOfcCntRSQL(), param, null);
			if(dbRowset.next()) {
				ofcCnt = dbRowset.getString("OFC_CNT");
			}
			
			return ofcCnt;
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * @param CgoClzTmStupVO cgoClzTmStupVO
	 * @return List<CgoClzTmStupVO>
	 * @exception  DAOException
	 */
	public List<CgoClzTmStupVO> searchCgoClzTmStupList(CgoClzTmStupVO cgoClzTmStupVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CgoClzTmStupVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(cgoClzTmStupVO != null){
				Map<String, String> mapVO = cgoClzTmStupVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BookingProcessMgtDBDAOSearchCgoClzTmRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CgoClzTmStupVO .class);
			
			return list;
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * @param CgoClzTmStupVO cgoClzTmStupVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void addCgoClzTmList(CgoClzTmStupVO cgoClzTmStupVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();						
		try {
			if(cgoClzTmStupVO != null){
				Map<String, String> mapVO = cgoClzTmStupVO.getColumnValues();
			
				param.putAll(mapVO);
				param.put("cre_usr_id", account.getUsr_id());
				param.put("upd_usr_id", account.getUsr_id());
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new BookingProcessMgtDBDAOAddCgoClzTmCSQL(), param,velParam);
			
			if(insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
	}

	/**
	 * @param CgoClzTmStupVO cgoClzTmStupVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void modifytCgoClzTmList(CgoClzTmStupVO cgoClzTmStupVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();						
		try {
			if(cgoClzTmStupVO != null){
				Map<String, String> mapVO = cgoClzTmStupVO .getColumnValues();
			
				param.putAll(mapVO);
				param.put("upd_usr_id", account.getUsr_id());
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new BookingProcessMgtDBDAOModifyCgoClzTmUSQL(), param,velParam);
			
			if(insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
	}

	/**
	 * @param CgoClzTmStupVO cgoClzTmStupVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void removeCgoClzTmList(CgoClzTmStupVO cgoClzTmStupVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();						
		try {
			if(cgoClzTmStupVO != null){
				Map<String, String> mapVO = cgoClzTmStupVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new BookingProcessMgtDBDAORemoveCgoClzTmDSQL(), param,velParam);
			
			if(insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * @param SignOnUserAccount account
	 * @param String polCd
	 * @param String laneCd
	 * @param String dirCd
	 * @return List<CgoClzTmStupVO>
	 * @throws DAOException
	 */
	public List<CgoClzTmStupVO> chkSetUpCnt(SignOnUserAccount account, String polCd, String laneCd, String dirCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<CgoClzTmStupVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			
			param.put("pol_cd", polCd);
			param.put("lane_cd", laneCd);
			param.put("dir_cd", dirCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BookingProcessMgtDBDAOSearchCgoClzTmCntRSQL(), param, null);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CgoClzTmStupVO .class);
			
//			
//			for(int i = 0 ; i < dbRowset.getRowCount(); i++){
//				setUpCnt = dbRowset.get
//			}
//			if(dbRowset.next()) {
//				setUpCnt = dbRowset.getString("SETUP_CNT");
//			}
			
//			return setUpCnt;
			
			return list;
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	 /**
	 * 이미 등록된 POR 인지 여부를 체크합니다.<br>
	 * 
	 * @param BkgDocPerfOfcVO bkgDocPerfOfcVO
	 * @return List<BkgDocPerfOfcVO>
	 * @exception  DAOException
	 */
 
	 @SuppressWarnings("unchecked")
	public List<BkgDocPerfOfcVO> checkPorPfmc(BkgDocPerfOfcVO bkgDocPerfOfcVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgDocPerfOfcVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//String ofcCd = bkgDocPerfOfcVO.getOfcCd();
		
		try{
			if(bkgDocPerfOfcVO != null){
				Map<String, String> mapVO = bkgDocPerfOfcVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BookingProcessMgtDBDAOsearchPorCheckRSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgDocPerfOfcVO .class);
			
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
	 * 이미 등록된 BGK OFF CD & POR 인지(동시) 여부를 체크합니다.<br>
	 * 
	 * @param BkgDocPerfOfcVO bkgDocPerfOfcVO
	 * @return List<BkgDocPerfOfcVO>
	 * @exception  DAOException
	 */
 
	 @SuppressWarnings("unchecked")
	public List<BkgDocPerfOfcVO> checkBkgOfcPorPfmc(BkgDocPerfOfcVO bkgDocPerfOfcVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgDocPerfOfcVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//String ofcCd = bkgDocPerfOfcVO.getOfcCd();
		
		try{
			if(bkgDocPerfOfcVO != null){
				Map<String, String> mapVO = bkgDocPerfOfcVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BookingProcessMgtDBDAOsearchBkgOfcPorCheckRSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgDocPerfOfcVO .class);
			
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


