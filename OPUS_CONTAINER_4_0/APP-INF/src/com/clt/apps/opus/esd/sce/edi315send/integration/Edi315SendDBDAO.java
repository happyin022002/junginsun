/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Edi315SendDBDAO.java
*@FileTitle :Edi315SendDBDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2009-11-19
*@LastModifier : 전병석
*@LastVersion : 1.42
* 2009-10-01 전병석 
* 1.0 Creation
* 2009-11-19 전병석
* 1.42 버전 커밋
* 2010.09.07 김진승 [CHM-201005667-01] Memo BL 315 전송 로직 변경 요청 - searchOriginBookingInformation(String bkgNo) 생성
* 2010.09.30 김진승 [CHM-201006003-01] AVN 전송 Error Logic 보완 - getAVNValidationCount 생성 
* 2010.10.13 김진승 [CHM-201006502-01] Adidas 관련 FLAT FILE에  BL_CRT_DT, BKG_CRT_DT, BKG_CFM_DT 항목 추가
* 2010.10.26 김진승 [CHM-NotSet] Customer Trade Partner ID가 '6111470101'일 경우에 대한 EDI Flat File에  Multi Booking No., BL No. 추가처리  
* 2010.10.29 김진승 [소스품질 보완] checkPartialSndRslt, searchOriginBookingInformation 메서드 @param 보완  
* 2010.11.30 김진승 [소스품질 보완] searchEdiStsForPrtlBkg 메서드 @param 보완  
* 2015.01.05 김인규 NYK ITEM 추가 및 보완 
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send.integration; 

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.sce.edi315send.basic.Edi315SendBCImpl;
import com.clt.apps.opus.esd.sce.edi315send.vo.AddSceEdiSndRsltVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.AddSceFltFileNoGenVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.CurrEventDtYdVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.CurrVvdVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.Edi315AmsDataVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.Edi315CurrInfoVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.Edi315DetailVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.Edi315MasterVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.Edi315PrefixBkgVvdVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.Edi315PrefixIrgInfoVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.Edi315PrefixMainBkgCustInfoVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.Edi315PrefixMainCOPInfoDelDtVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.Edi315PrefixMainCOPInfoDelVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.Edi315PrefixMainCOPInfoPodDtVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.Edi315PrefixMainCOPInfoPodVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.Edi315PrefixMainCOPInfoPolDtVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.Edi315PrefixMainCOPInfoPolVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.Edi315PrefixMainCOPInfoPorDtVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.Edi315PrefixMainCOPInfoPorVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.Edi315PrefixMainCOPInfoVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.Edi315SendOptionsVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.Edi315SendVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.GetEvntDtVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.GetRailTermVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.RlyPortVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.SearchBoundRoutSeqVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.SearchCntrWeightInfoVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.SearchCredataMetInformationVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.SearchTIExistInformationVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.SearchVvdTimeInformationVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.SceCopDtlVO;
import com.clt.syscommon.common.table.SceFltFileMsgDtlVslVO;
import com.clt.syscommon.common.table.SceFltFileMsgVO;
/**
 * SCE Business Logic ServiceCommand<br>
 * - SCE에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author YJLEE
 * @see Edi315SendBCImpl 참조 
 * @since J2EE 1.4
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class Edi315SendDBDAO extends DBDAOSupport{
	private static final long serialVersionUID = 1L;

	/**
	 * 발송시 필요한 기본 컬럼 값들 조회. BKG_BOOKING, SCE_COP_HDR 등의 정보.
	 * @param String cop_no
	 * @return List<Edi315MasterVO> 
	 * @exception DAOException
	 */
    public List<Edi315MasterVO> search315MasterList(String cop_no) throws DAOException{
    	//!!!!! !!"sarchSceCopHdr is started.");
    	DBRowSet dbRowset = null;
		List<Edi315MasterVO> list = null;
		Map<String, String> argMap = new HashMap<String, String>();
		argMap.put("e_cop_no",     cop_no);
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
        try {
        	if (argMap != null) {
				Map<String, String> mapVO = argMap;
				param.putAll(mapVO);
				velParam.putAll(mapVO);		
			}
        	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOSearch315MasterListRSQL(),
					param, velParam);
			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,Edi315MasterVO.class);
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
	 * addSceEdiAmsIf
     * @param Edi315AmsDataVO amsVos
     * @return String
     * @throws DAOException
     */  
	public String addSceEdiAmsIf(Edi315AmsDataVO amsVos) throws DAOException {
		//!!!!! !!"addEdi315Send is started.");
		String resultFlag = "N";
			try {
				 // query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				// velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();		
				
				  Map<String, String> mapVO = new HashMap();
					        mapVO.put("bl_no",amsVos.getBlNo()); 
					        mapVO.put("edi_sts",amsVos.getEdiSts());       
							mapVO.put("event_dt",amsVos.getEventDt());       
							mapVO.put("event_yd",amsVos.getEventYd());    
				param.putAll(mapVO);						
	
				new SQLExecuter("").executeUpdate((ISQLTemplate)new Edi315SendDBDAOAddSceEdiAmsIfCSQL(), param, velParam);
				
				resultFlag = "Y";
			} catch (SQLException se) {
				resultFlag = "N";
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler("Inserting into sce_edi_ams_if:",new String[]{}).getMessage());
			} catch (Exception ex) {
				resultFlag = "N";
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler("Inserting into sce_edi_ams_if:",new String[]{}).getMessage());
			}
		return resultFlag;
	}  

	/**
	 * addSceEdiLog
     * @param Edi315SendVO sendVo
     * @param String rmk
     * @return String
     * @throws DAOException
	 */  
	public String addSceEdiLog(Edi315SendVO sendVo,String rmk) throws DAOException {
		//!!!!! !!"addEdi315Send is started.");
		String resultFlag = "N";
			try {
				Map<String, Object> param = new HashMap<String, Object>();
				Map<String, Object> velParam = new HashMap<String, Object>();		
				
				Map<String, String> mapVO = new HashMap();
					        mapVO.put("bkg_no",sendVo.getBkgNo()); 
					        mapVO.put("cntr_no",sendVo.getCntrNo());       
							mapVO.put("edi_rcv_tp_cd",sendVo.getEdiStatus());       
							mapVO.put("edi_snd_rmk",rmk);    
				param.putAll(mapVO);						
	
				new SQLExecuter("").executeUpdate((ISQLTemplate)new Edi315SendDBDAOAddSceEdiLogCSQL(), param, velParam);
				
				resultFlag = "Y";
			} catch (SQLException se) {
				resultFlag = "N";
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler("Inserting into sce_edi_ams_if:",new String[]{}).getMessage());
			} catch (Exception ex) {
				resultFlag = "N";
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler("Inserting into sce_edi_ams_if:",new String[]{}).getMessage());
			}
		return resultFlag;
	} 

	/**
	 * addSceEdiHisDtl
     * @param List<Edi315DetailVO> edi315Cvos
     * @return boolean
     * @throws DAOException
     */   		
	public boolean addSceEdiHisDtl(List<Edi315DetailVO> edi315Cvos) throws DAOException {
		
		   boolean resultFlag = false;
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int insCnt[] = null;
				if (edi315Cvos.size() > 0) {
					insCnt = sqlExe.executeBatch((ISQLTemplate) new Edi315SendDBDAOAddSceEdiHisDtlCSQL(), edi315Cvos, null);
					for (int i = 0; i < insCnt.length; i++) {
						if (insCnt[i] == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No" + i + " SQL");
					}
				}
				resultFlag = true;
			} catch (SQLException se) {
				resultFlag = false;
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler("Inserting into sce_edi_send_if_dtl:",new String[]{}).getMessage());
			} catch (Exception ex) {
				resultFlag = false;
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler("Inserting into sce_edi_send_if_dtl:",new String[]{}).getMessage());
			}
		return resultFlag;
	}  	
	/**
	 * addSceEdiHis
     * @param List<Edi315SendVO> edi315SendVos
     * @return boolean
     * @throws DAOException
     */
	public boolean addSceEdiHis(List<Edi315SendVO> edi315SendVos) throws DAOException {
		   boolean resultFlag = false;
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int insCnt[] = null;
				if (edi315SendVos.size() > 0) {
					insCnt = sqlExe.executeBatch((ISQLTemplate) new Edi315SendDBDAOAddSceEdiHisCSQL(), edi315SendVos, null);
					for (int i = 0; i < insCnt.length; i++) {
						if (insCnt[i] == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No" + i + " SQL");
					}
				}
				resultFlag = true;
			} catch (SQLException se) {
				resultFlag = false;
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler("Inserting into sce_edi_send_if:",new String[]{}).getMessage());
			} catch (Exception ex) {
				resultFlag = false;
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler("Inserting into sce_edi_send_if:",new String[]{}).getMessage());
			}
		return resultFlag;
	}  


    
    
    
	/**
	 * searchCOPInfoPor
     * @param Edi315SendOptionsVO edi315SOpts
     * @return List<Edi315PrefixMainCOPInfoPolVO>
     * @throws DAOException
     */ 
    public List<Edi315PrefixMainCOPInfoPorVO> searchCOPInfoPor(Edi315SendOptionsVO edi315SOpts) throws DAOException {
     	DBRowSet dbRowset = null;
		List<Edi315PrefixMainCOPInfoPorVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
        try {
        	if (edi315SOpts != null) {
				Map<String, String> mapVO = edi315SOpts.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOSearchCOPInfoPorRSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,Edi315PrefixMainCOPInfoPorVO.class);
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
	 * searchCOPInfoPol
     * @param Edi315SendOptionsVO edi315SOpts
     * @return List<Edi315PrefixMainCOPInfoPolVO>
     * @throws DAOException
     */ 
    public List<Edi315PrefixMainCOPInfoPolVO> searchCOPInfoPol(Edi315SendOptionsVO edi315SOpts) throws DAOException {
     	DBRowSet dbRowset = null;
		List<Edi315PrefixMainCOPInfoPolVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
        try {
        	if (edi315SOpts != null) {
				Map<String, String> mapVO = edi315SOpts.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOSearchCOPInfoPolRSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,Edi315PrefixMainCOPInfoPolVO.class);
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
	 * searchCOPInfoPod
     * @param Edi315SendOptionsVO edi315SOpts
     * @return List<Edi315PrefixMainCOPInfoPodVO>
     * @throws DAOException
     */ 
    public List<Edi315PrefixMainCOPInfoPodVO> searchCOPInfoPod(Edi315SendOptionsVO edi315SOpts) throws DAOException {
     	DBRowSet dbRowset = null;
		List<Edi315PrefixMainCOPInfoPodVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
        try {
        	if (edi315SOpts != null) {
				Map<String, String> mapVO = edi315SOpts.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOSearchCOPInfoPodRSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,Edi315PrefixMainCOPInfoPodVO.class);
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
	 * searchCOPInfoDel
     * @param Edi315SendOptionsVO edi315SOpts
     * @return List<Edi315PrefixMainCOPInfoDelVO>
     * @throws DAOException
     */ 
    public List<Edi315PrefixMainCOPInfoDelVO> searchCOPInfoDel(Edi315SendOptionsVO edi315SOpts) throws DAOException {
     	DBRowSet dbRowset = null;
		List<Edi315PrefixMainCOPInfoDelVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
        try {
        	if (edi315SOpts != null) {
				Map<String, String> mapVO = edi315SOpts.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOSearchCOPInfoDelRSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,Edi315PrefixMainCOPInfoDelVO.class);
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
	 * searchCOPInfoPorDt
     * @param Edi315SendOptionsVO edi315SOpts
     * @return List<Edi315PrefixMainCOPInfoPorDtVO>
     * @throws DAOException
     */ 
    public List<Edi315PrefixMainCOPInfoPorDtVO> searchCOPInfoPorDt(Edi315SendOptionsVO edi315SOpts) throws DAOException {
     	DBRowSet dbRowset = null;
		List<Edi315PrefixMainCOPInfoPorDtVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
        try {
        	if (edi315SOpts != null) {
				Map<String, String> mapVO = edi315SOpts.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOSearchCOPInfoPorDtRSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,Edi315PrefixMainCOPInfoPorDtVO.class);
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
	 * searchCOPInfoPolDt
     * @param Edi315SendOptionsVO edi315SOpts
     * @return List<Edi315PrefixMainCOPInfoPolDtVO>
     * @throws DAOException
     */ 
    public List<Edi315PrefixMainCOPInfoPolDtVO> searchCOPInfoPolDt(Edi315SendOptionsVO edi315SOpts) throws DAOException {
     	DBRowSet dbRowset = null;
		List<Edi315PrefixMainCOPInfoPolDtVO> list = new ArrayList<Edi315PrefixMainCOPInfoPolDtVO>();
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
        try {
        	if (edi315SOpts != null) {
				Map<String, String> mapVO = edi315SOpts.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOSearchCOPInfoPolDtRSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,Edi315PrefixMainCOPInfoPolDtVO.class);
			
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
	 * searchCOPInfoPodDt
     * @param Edi315SendOptionsVO edi315SOpts
     * @return List<Edi315PrefixMainCOPInfoPodDtVO>
     * @throws DAOException
     */ 
    public List<Edi315PrefixMainCOPInfoPodDtVO> searchCOPInfoPodDt(Edi315SendOptionsVO edi315SOpts) throws DAOException {
     	DBRowSet dbRowset = null;
		List<Edi315PrefixMainCOPInfoPodDtVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
        try {
        	if (edi315SOpts != null) {
				Map<String, String> mapVO = edi315SOpts.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOSearchCOPInfoPodDtRSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,Edi315PrefixMainCOPInfoPodDtVO.class);
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
	 * searchCOPInfoDelDt
     * @param Edi315SendOptionsVO edi315SOpts
     * @return List<Edi315PrefixMainCOPInfoDelDtVO>
     * @throws DAOException
     */ 
    public List<Edi315PrefixMainCOPInfoDelDtVO> searchCOPInfoDelDt(Edi315SendOptionsVO edi315SOpts) throws DAOException {
     	DBRowSet dbRowset = null;
		List<Edi315PrefixMainCOPInfoDelDtVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
        try {
        	if (edi315SOpts != null) {
				Map<String, String> mapVO = edi315SOpts.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOSearchCOPInfoDelDtRSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,Edi315PrefixMainCOPInfoDelDtVO.class);
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
	 * getUvdCnt
     * @param String cop_no
     * @return int
     * @throws DAOException
     */ 
    public int getUvdCnt(String cop_no) throws DAOException{
    	DBRowSet dbRowset = null;
     try{        	

 		Map<String, Object> param = new HashMap<String, Object>();
 		Map<String, Object> velParam = new HashMap<String, Object>();		


 	    /*파라미터 입력*/ 	
 		  Map<String, String> mapVO = new HashMap();
 			                  mapVO.put("cop_no",cop_no); 
     	
 	    if (mapVO != null) {
 			    			 param.putAll(mapVO);
 			    			 velParam.putAll(mapVO);		
 			    			}		                  
 		dbRowset = new SQLExecuter("").executeQuery(
 				(ISQLTemplate) new Edi315SendDBDAOGetUvdCntRSQL(),
 				param,velParam);
 		
 		int temp = 0;
 		if(dbRowset.next()) {
 			temp = dbRowset.getInt(1);
 			return temp;
     	}
 		return -1;
     } catch (SQLException se) {
 		log.error(se.getMessage(), se);
 		throw new DAOException(new ErrorHandler(se).getMessage());
 	} catch (Exception ex) {
 		log.error(ex.getMessage(), ex);
 		throw new DAOException(new ErrorHandler(ex).getMessage());
 	}
    }

	/**
	 * searchCOPInfoDelDtIywd
     * @param Edi315SendOptionsVO edi315SOpts
     * @return List<Edi315PrefixMainCOPInfoDelDtVO>
     * @throws DAOException
     */ 
    public List<Edi315PrefixMainCOPInfoDelDtVO> searchCOPInfoDelDtIywd(Edi315SendOptionsVO edi315SOpts) throws DAOException {
     	DBRowSet dbRowset = null;
		List<Edi315PrefixMainCOPInfoDelDtVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
        try {
        	if (edi315SOpts != null) {
				Map<String, String> mapVO = edi315SOpts.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOSearchCOPInfoDelDtIywdRSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,Edi315PrefixMainCOPInfoDelDtVO.class);
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
    }




    
    
    
	/**searchBkgCustInfo 조회
     * @param Edi315SendOptionsVO edi315SOpts
     * @return List<Edi315PrefixMainBkgCustInfoVO>
     * @throws DAOException
     */   
    public List<Edi315PrefixMainBkgCustInfoVO> searchBkgCustInfo(Edi315SendOptionsVO edi315SOpts) throws DAOException {
 
    	DBRowSet dbRowset = null;
		List<Edi315PrefixMainBkgCustInfoVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
        try {
        	if (edi315SOpts != null) {
				Map<String, String> mapVO = edi315SOpts.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOSearchBkgCustInfoRSQL(),
					param, velParam);
			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,Edi315PrefixMainBkgCustInfoVO.class);
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
    }   
	/**searchVvdTimeInformation 조회
     * @param Edi315SendOptionsVO edi315SOpts
     * @return List<SearchVvdTimeInformationVO>
     * @throws DAOException
     */
    public List<SearchVvdTimeInformationVO> searchVvdTimeInformation(Edi315SendOptionsVO edi315SOpts)throws DAOException{
    	//!!!!! !!"searchVvdTimeInformation is started.");
    	DBRowSet dbRowset = null;
		List<SearchVvdTimeInformationVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        try {
        	if (edi315SOpts != null) {
				Map<String, String> mapVO = edi315SOpts.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);		
			}
        	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOSearchVvdTimeInformationRSQL(),
					param, velParam);
			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,SearchVvdTimeInformationVO.class);
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;   	
    }
	/**searchCredataMetInformation
     * @param String poleta1
     * @param String poleta1_gmt
     * @param String blpol1
     * @param String blpod1
     * @param String bv_lane
     * @return List<SearchCredataMetInformationVO>
     * @throws DAOException
     */   
    public List<SearchCredataMetInformationVO> searchCredataMetInformation(String poleta1, String poleta1_gmt, 
    										String blpol1, String blpod1, String bv_lane) throws DAOException{
    	//!!!!! !!"searchCredataMetInformation is started.");
    	DBRowSet dbRowset = null;
		List<SearchCredataMetInformationVO> list = null;
		Map<String, String> argMap = new HashMap<String, String>();
        //Parameter Binding with Velocity		
		argMap.put("e_poleta1",     poleta1);
		argMap.put("e_poleta1_gmt", poleta1_gmt);
		argMap.put("e_blpol1",      blpol1);
		argMap.put("e_blpod1",      blpod1);
		argMap.put("e_bv_lane",     bv_lane);
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        try {
        	if (argMap != null) {
				Map<String, String> mapVO = argMap;
				param.putAll(mapVO);
				velParam.putAll(mapVO);		
			}
        	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOSearchCredataMetInformationRSQL(),
					param, velParam);
			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,SearchCredataMetInformationVO.class);
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list; 
    }

	/**searchTIExistInformation
     * @param String blpol1
     * @param String blpod1
     * @param String poleta1
     * @param String poleta1_gmt
     * @return List<SearchTIExistInformationVO>
     * @throws DAOException
     */   
    public List<SearchTIExistInformationVO> searchTIExistInformation(String blpol1, String  blpod1, String poleta1,String poleta1_gmt)throws DAOException{
    	//!!!!! !!"searchTIsexistInformation is started.");
    	DBRowSet dbRowset = null;
		List<SearchTIExistInformationVO> list = null;
		Map<String, String> argMap = new HashMap<String, String>();
        //Parameter Binding with Velocity		
		argMap.put("e_blpol1",     blpol1);
		argMap.put("e_blpod1",     blpod1);
		argMap.put("e_poleta1",    poleta1);
		argMap.put("e_poleta1_gmt",poleta1_gmt);

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        try {
        	if (argMap != null) {
				Map<String, String> mapVO = argMap;
				param.putAll(mapVO);
				velParam.putAll(mapVO);		
			}
        	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOSearchTIExistInformationRSQL(),
					param, velParam);
			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,SearchTIExistInformationVO.class);
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
     * searchTIExistInformation
     * @param bvvd1 String
     * @param vsl_callsign1 String
     * @param vsl_lloydcode1 String
     * @param vsl_fullname1 String
     * @param blpol1 String
     * @param pol_fullname1 String
     * @param blpod1 String
     * @param pod_fullname1 String
     * @param poleta1 String
     * @param poleta1_gmt String
     * @param polata1 String
     * @param poletd1 String
     * @param poletd1_gmt String
     * @param polatd1 String
     * @param polatd1_gmt String
     * @param podeta1 String
     * @param podeta1_gmt String
     * @param podata1 String
     * @param podata1_gmt String
     * @param podetd1 String
     * @param podetd1_gmt String
     * @param podatd1 String
     * @param podatd1_gmt String
     * @param vsl_consort_voy_no String
     * @param vsl_cnt_cd String
     * @param pol_amsqual1 String
     * @param pol_amsport1 String
     * @param pod_amsqual1 String
     * @param pod_amsport1 String
     * @return List<Edi315PrefixBkgVvdVO>
     * @throws DAOException
     */
    public List<Edi315PrefixBkgVvdVO> searchStrInformation(
              String bvvd1,         String vsl_callsign1, String vsl_lloydcode1 ,
             String vsl_fullname1, String blpol1,        String pol_fullname1 , 
              String blpod1,        String pod_fullname1, String poleta1 ,
              String poleta1_gmt,   String polata1,       String poletd1,       
              String poletd1_gmt,   String polatd1,       String polatd1_gmt,   
              String podeta1 ,      String podeta1_gmt ,  String podata1,       
              String podata1_gmt ,  String podetd1,       String podetd1_gmt,   
              String podatd1 ,      String podatd1_gmt,   String vsl_consort_voy_no,
              String vsl_cnt_cd   , String pol_amsqual1 , String pol_amsport1  ,
              String pod_amsqual1 , String pod_amsport1
    )throws DAOException{
    	
    	//!!!!! !!"searchStrInformation is started.");
    	DBRowSet dbRowset = null;
		List<Edi315PrefixBkgVvdVO> list = null;
		Map<String, String> argMap = new HashMap<String, String>();
        //Parameter Binding with Velocity		
		argMap.put("e_bvvd1",          bvvd1           );
		argMap.put("e_vsl_fullname1" , vsl_fullname1   );
		argMap.put("e_blpod1",         blpod1  );
		argMap.put("e_poleta1_gmt",    poleta1_gmt   );
		argMap.put("e_poletd1_gmt",    poletd1_gmt          );
		argMap.put("e_podeta1",        podeta1   );
		argMap.put("e_podata1_gmt" ,   podata1_gmt          );
		argMap.put("e_podatd1" ,       podatd1   );
		argMap.put("e_vsl_callsign1",  vsl_callsign1         );
		argMap.put("e_blpol1",         blpol1     );
		argMap.put("e_pod_fullname1",  pod_fullname1         );
		argMap.put("e_polata1",        polata1     );
		argMap.put("e_polatd1",        polatd1         );
		argMap.put("e_podeta1_gmt" ,   podeta1_gmt     );
		argMap.put("e_podetd1",        podetd1         );
		argMap.put("e_podatd1_gmt",    podatd1_gmt     );
		argMap.put("e_vsl_lloydcode1" ,vsl_lloydcode1         );
		argMap.put("e_pol_fullname1" , pol_fullname1     );
		argMap.put("e_poleta1" ,       poleta1         );
		argMap.put("e_poletd1",        poletd1     );
		argMap.put("e_polatd1_gmt",    polatd1_gmt         );
		argMap.put("e_podata1",        podata1     );
		argMap.put("e_podetd1_gmt",    podetd1_gmt         );
		
		argMap.put("e_vsl_consort_voy_no",    vsl_consort_voy_no );
		argMap.put("e_vsl_cnt_cd",      vsl_cnt_cd         );
		argMap.put("e_pol_amsqual1",    pol_amsqual1         );
		argMap.put("e_pol_amsport1",    pol_amsport1         );
		argMap.put("e_pod_amsqual1",    pod_amsqual1         );
		argMap.put("e_pod_amsport1",    pod_amsport1         );

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        try {
        	if (argMap != null) {
				Map<String, String> mapVO = argMap;
				param.putAll(mapVO);
				velParam.putAll(mapVO);		
			}
        	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOEdi315PrefixBkgVvdRSQL(),
					param, velParam);
			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,Edi315PrefixBkgVvdVO.class);
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return list; 
    }
	/**searchCredataMetInformation 조회
     * @param String irg_rout_seq
     * @param String irg_rout_org
     * @param String irg_rout_dest
     * @param String cop_no
     * @return List<SearchCredataMetInformationVO>
     * @throws DAOException
     */   
    public List<Edi315PrefixIrgInfoVO> searchIrgTimeInformation(String irg_rout_seq,String irg_rout_org,String irg_rout_dest,String cop_no) throws DAOException{
    	//!!!!! !!"searchIrgTimeInformation is started.");
    	DBRowSet dbRowset = null;
		List<Edi315PrefixIrgInfoVO> list = null;
		Map<String, String> argMap = new HashMap<String, String>();
        //Parameter Binding with Velocity		
		argMap.put("e_irg_rout_seq",      irg_rout_seq);
		argMap.put("e_irg_rout_org",      irg_rout_org);
		argMap.put("e_irg_rout_dest",     irg_rout_dest);
		argMap.put("e_cop_no",            cop_no);

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        try {
        	if (argMap != null) {
				Map<String, String> mapVO = argMap;
				param.putAll(mapVO);
				velParam.putAll(mapVO);		
			}
        	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOSearchIrgTimeInformationRSQL(),
					param, velParam);
			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,Edi315PrefixIrgInfoVO.class);
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list; 
    }
	/**searchCredataMetInformation 조회
     * @param String cop_no
     * @return List<SearchBoundRoutSeqVO>
     * @throws DAOException
     */   
    public List<SearchBoundRoutSeqVO> searchBoundRoutSeq(String cop_no) throws DAOException{
    	//!!!!! !!"searchBoundRoutSeq is started.");
    	DBRowSet dbRowset = null;
		List<SearchBoundRoutSeqVO> list = null;
		Map<String, String> argMap = new HashMap<String, String>();
        //Parameter Binding with Velocity		
		argMap.put("e_cop_no",      cop_no);
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        try {
        	if (argMap != null) {
				Map<String, String> mapVO = argMap;
				param.putAll(mapVO);
				velParam.putAll(mapVO);		
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOSearchBoundRoutSeqRSQL(),
					param, velParam);
			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,SearchBoundRoutSeqVO.class);
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list; 
    }
	/**getSndSeq 조회
     * @return DBRowSet
     * @throws DAOException
     */      
    public DBRowSet getSndSeq() throws DAOException{
    	DBRowSet dbRowset = null;
		
        try{        	

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOGetSndSeqRSQL(),
					null,null);
			return dbRowset;
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    }    
	/**searchVesslenInformation 조회
     * @param String trunk_vvd_splited
     * @return DBRowSet
     * @throws DAOException
     */      
    public DBRowSet searchVesslenInformation(String trunk_vvd_splited) throws DAOException{
    	
    	DBRowSet dbRowset = null;
		 // query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		String trunk_vvd_splited_1       = trunk_vvd_splited;

	     /*파라미터 입력*/ 	
		 Map<String, String> mapVO = new HashMap();
			                 mapVO.put("e_trunk_vvd_splited",trunk_vvd_splited_1); 
	     param.putAll(mapVO);
	     velParam.putAll(mapVO);
	     
        try{        	

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOSearchVessleInformationRSQL(),
					param,velParam);
            return dbRowset;
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}      	
    }    
    /**addSceEdiSndRslt 입력 
     * @param  List<AddSceEdiSndRsltVO>  addVos
     * @return boolean
     * @throws DAOException
     */    
    public boolean addSceEdiSndRslt(List<AddSceEdiSndRsltVO> addVos) throws DAOException{
  		   boolean resultFlag = false;
  			try {
  				SQLExecuter sqlExe = new SQLExecuter("");
  				int insCnt[] = null;
  				if (addVos.size() > 0) {
  					log.debug("\n\n yj !!! addSceEdiSndRslt addVos.toString \n\n"+addVos.toString());
  					insCnt = sqlExe.executeBatch((ISQLTemplate) new Edi315SendDBDAOAddSceEdiSndRsltCSQL(), addVos, null);
  					for (int i = 0; i < insCnt.length; i++) {
  						if (insCnt[i] == Statement.EXECUTE_FAILED)
  							throw new DAOException("Fail to insert No" + i + " SQL");
  					}
  				}
  				resultFlag = true;
  			} catch (SQLException se) {
  				resultFlag = false;
  				log.error(se.getMessage(), se);
  				throw new DAOException(new ErrorHandler("Inserting into Sce_Edi_Snd_Rslt:",new String[]{}).getMessage());
  			} catch (Exception ex) {
  				resultFlag = false;
  				log.error(ex.getMessage(), ex);
  				throw new DAOException(new ErrorHandler("Inserting into Sce_Edi_Snd_Rslt:",new String[]{}).getMessage());
  			}
  		return resultFlag; 
    }
	/**addSceFltFileNoGen 인서트
     * @param  List<AddSceFltFileNoGenVO> adcggNgVos
     * @return boolean
     * @throws DAOException
     */        
	public boolean addSceFltFileNoGen(List<AddSceFltFileNoGenVO> adcggNgVos) throws DAOException {
		   boolean resultFlag = false;
			try {
				
				SQLExecuter sqlExe = new SQLExecuter("");
				int insCnt[] = null;
				if (adcggNgVos.size() > 0) {
					insCnt = sqlExe.executeBatch((ISQLTemplate) new Edi315SendDBDAOAddSceFltFileNoGenCSQL(), adcggNgVos, null);
					for (int i = 0; i < insCnt.length; i++) {
						if (insCnt[i] == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No" + i + " SQL");
					}
				}
				resultFlag = true;
			} catch (SQLException se) {
				resultFlag = false;
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler("Inserting into SCE_FLT_FILE_NO_GEN:",new String[]{}).getMessage());
			} catch (Exception ex) {
				resultFlag = false;
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler("Inserting into SCE_FLT_FILE_NO_GEN:",new String[]{}).getMessage());
			}
		return resultFlag;
	}   
	/**addSceFltFileNoGen 인서트
     * @param  String flt_file_ref_no
     * @param  Edi315PrefixMainCOPInfoVO mVo
     * @param  Edi315DetailVO dtlVo
     * @param  SceFltFileMsgVO ffMsgVo
     * @return boolean
     * @throws DAOException
     */  
	public String addSceFltFileMsg(String flt_file_ref_no
			, Edi315PrefixMainCOPInfoVO mVo, Edi315DetailVO dtlVo, SceFltFileMsgVO ffMsgVo)throws DAOException {
		String resultFlag = "N";
		//int rowCnt = 0;
		try {

			
			
			Map<String, String> valParam = new HashMap<String, String>();
			Map<String, String> param = new HashMap<String, String>();
			param.putAll(mVo.getColumnValues());
			param.putAll(ffMsgVo.getColumnValues());

			param.put("flt_file_ref_no"		,flt_file_ref_no);
			param.put("bkg_no"				,dtlVo.getBkgNo());
//			param.put("bl_no"				,dtlVo.getBlNo());
			param.put("cust_edi_sts_cd"		,dtlVo.getCustEdiStsCd());
			param.put("edi_stnd_sts_cd"		,dtlVo.getEdiSts());
			param.put("edi_grp_cd"			,dtlVo.getEdiGrpCd());
			param.put("cop_no"				,dtlVo.getCopNo());
			param.put("cntr_no"				,dtlVo.getCntrNo());
			

			
			new SQLExecuter("").executeUpdate((ISQLTemplate) new Edi315SendDBDAOAddSceFltFileMsgCSQL(),param, valParam);
			resultFlag = "Y";
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(
					"Inserting into SCE_FLT_FILE_MSG:", new String[] {})
					.getMessage());
		}
		return resultFlag;
	}   
	/**addSceFltFileNoGen 수정
     * @param   stnd_edi_sts_cd String 
     * @param   event_dt String 
     * @param   cop_no String 
     * @param   cop_dtl_seq String 
     * @return boolean
     * @throws DAOException
     */  	
    public boolean modifySceCopDtl(
    		                       String stnd_edi_sts_cd,
    		                       String event_dt,
    		                       String cop_no,
    		                       String cop_dtl_seq
                                   )throws DAOException{
		    boolean resultFlag = false;
			 // query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();		
			
			String stnd_edi_sts_cd_1 = stnd_edi_sts_cd ;
			String event_dt_2        = event_dt;
			String cop_no_3          = cop_no;
			String cop_dtl_seq_4     = cop_dtl_seq;

			
			  Map<String, String> mapVO = new HashMap();
				        mapVO.put("stnd_edi_sts_cd",stnd_edi_sts_cd_1); 
				        mapVO.put("event_dt",event_dt_2);       
						mapVO.put("cop_no",cop_no_3);       
						mapVO.put("cop_dtl_seq",cop_dtl_seq_4);        
   
						
		     param.putAll(mapVO);
		     velParam.putAll(mapVO);
			try {
				    int insCnt = 0;
		 			  if(mapVO.size() > 0){
		 					insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new Edi315SendDBDAOModifySceCopDtlUSQL(), param, velParam);
		 						if(insCnt == Statement.EXECUTE_FAILED)
		 							throw new DAOException("Fail to Update at SQL: Edi315SendDBDAOModifySceCopDtlUSQL");
		 			  }	
				resultFlag = true;
			} catch (SQLException se) {
				resultFlag = false;
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler("Updating into SCE_COP_DTL:",new String[]{}).getMessage());
			} catch (Exception ex) {
				resultFlag = false;
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler("Updating into SCE_COP_DTL:",new String[]{}).getMessage());
			}
		
		return resultFlag;   	
    }	


	/**
	 * search315DetailList
	 * 발송 대상이 되는 모든 화주/Status를 조회 하는 Keq 쿼리.
     * @param  Edi315SendVO ediSendVo
     * @return List<Edi315DetailVO>
     * @throws DAOException
     */  
    public List<Edi315DetailVO> search315DetailList(Edi315SendVO ediSendVo) throws DAOException {
    	//!!!!! !!"sarchCommonList is started.");
    	DBRowSet dbRowset = null;
		List<Edi315DetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        try {
        	if (ediSendVo != null) {
				Map<String, String> mapVO = ediSendVo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);	
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOSearch315DetailListRSQL(),
					param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset,Edi315DetailVO.class);
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
    }
	/**getEventDtGmt 조회
     * @param  Edi315SendVO sendVo
     * @return String
     * @throws DAOException
     */  
    public String getEventDtGmt(Edi315SendVO sendVo) throws DAOException{
    	String event_dt_gmt = "" ;
      	if (sendVo != null) {
			event_dt_gmt = getEventDtGmt(sendVo.getEventDt(), sendVo.getEventYard());
		}
      	return event_dt_gmt;
   } 
	/**getEventDtGmt 조회
     * @param  String event_dt
     * @param  String event_yard
     * @return String
     * @throws DAOException
     */  
    public String getEventDtGmt(String event_dt, String event_yard) throws DAOException{
    	DBRowSet dbRowset = null;
    	String event_dt_gmt = "" ;
      try{
    	  Map<String, String> params = new HashMap<String, String>();
    	  params.put("event_dt", event_dt);
    	  params.put("event_yard", event_yard);
    	  dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Edi315SendDBDAOGetEventDtGmtRSQL(), params, params);
    	  if(dbRowset != null && dbRowset.next()){
    		  event_dt_gmt = dbRowset.getString(1);
    	  }
    	  
          return event_dt_gmt;
      } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}     	
   } 
	/**isVvdView 조회
	 * e_cop_dtl_seq 기준으로 동일 e_edi_sts 가 존재 하는지 판별.
	 * 20070905 - DIR로 interface된 data에 대하여 순서를 check 하여 전송 
     * @param     String e_cop_no
     * @param     String e_cop_dtl_seq
     * @param     String e_edi_cgo_rmk
     * @param     String e_edi_grp_cd
     * @return int
     * @throws DAOException
     */     
   public int isVvdView(String e_cop_no, String e_cop_dtl_seq, String e_edi_cgo_rmk, String e_edi_grp_cd) throws DAOException{
   	DBRowSet dbRowset = null;
    try{        	
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		String e_cop_no_1       = e_cop_no;
		String e_cop_dtl_seq_2  = e_cop_dtl_seq;
		String e_edi_cgo_rmk_3    = e_edi_cgo_rmk;
		String e_edi_grp_cd_4     = e_edi_grp_cd;

	    /*파라미터 입력*/ 	
		  Map<String, String> mapVO = new HashMap<String, String>();
			                  mapVO.put("e_cop_no",e_cop_no_1); 
			                  mapVO.put("e_cop_dtl_seq",e_cop_dtl_seq_2); 
			      			  mapVO.put("e_edi_cgo_rmk",e_edi_cgo_rmk_3); 
			    			  mapVO.put("e_edi_grp_cd",e_edi_grp_cd_4); 
    	
	    if (mapVO != null) {
			    			 param.putAll(mapVO);
			    			 velParam.putAll(mapVO);		
			    			}		                  
		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Edi315SendDBDAOSearchIsVvdViewRSQL(),param,velParam);
		
		int temp = 0;
		if(dbRowset.next()) {
			temp = dbRowset.getInt(1);
			return temp;
    	}
		return -1;
    } catch (SQLException se) {
		log.error(se.getMessage(), se);
		throw new DAOException(new ErrorHandler(se).getMessage());
	} catch (Exception ex) {
		log.error(ex.getMessage(), ex);
		throw new DAOException(new ErrorHandler(ex).getMessage());
	}
   }

	/**isVvdView2 조회
	* 원하는 sequence 를 전송 하기 위해서 VIEW에 동일 status 가 존재하는지의 여부 판별
    * @param  String e_cop_no
	* @param  String e_cop_dtl_seq
    * @param  String e_edi_cgo_rmk
    * @param  String e_edi_grp_cd
    * @return int
    * @throws DAOException
    */     
   public int isVvdView2(String  e_cop_no, String e_cop_dtl_seq, String e_edi_cgo_rmk, String e_edi_grp_cd )throws DAOException{
	  DBRowSet dbRowset = null;
	  try{
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();		
			
			String e_cop_no_1         = e_cop_no;
			String e_cop_dtl_seq_2    = e_cop_dtl_seq;
			String e_edi_cgo_rmk_3    = e_edi_cgo_rmk;
			String e_edi_grp_cd_4     = e_edi_grp_cd;
			 	
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("e_cop_no",e_cop_no_1); 
			mapVO.put("e_cop_dtl_seq",e_cop_dtl_seq_2); 
			mapVO.put("e_edi_cgo_rmk",e_edi_cgo_rmk_3); 
			mapVO.put("e_edi_grp_cd",e_edi_grp_cd_4); 
				
			if (mapVO != null) {
				 param.putAll(mapVO);
		   		 velParam.putAll(mapVO);		
			}			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Edi315SendDBDAOSearchisVvdView2RSQL(), param, velParam);
			
			int temp = 0;
			if(dbRowset.next()) {
				temp = dbRowset.getInt(1);
				return temp;
			}
			
			return -1;
		} catch (SQLException se) {
		  log.error(se.getMessage(), se);
		  throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
		  log.error(ex.getMessage(), ex);
		  throw new DAOException(new ErrorHandler(ex).getMessage());
		}	   
  	}
  /**
   * SCE_EDI_SND_RSLT 테이블에 발송 History있는지 판별.
   * 2008-11-20 - COP상의 첫번째 Status라도 기전송여부를 Check하여 기전송시 SKIP 
   * @param   String edi_group_cd 
   * @param   String edi_sts 
   * @param   String cust_edi_sts
   * @param   String cntr_no 
   * @param   String bkg_no     
   * @return int
   * @throws DAOException
   */  
	public int isdirfirstView(
			                   String edi_group_cd,
			                   String edi_sts,
			                   String cust_edi_sts,
			                   String cntr_no,
			                   String bkg_no) throws DAOException{
	       DBRowSet dbRowset = null;
			try{        	
				Map<String, Object> param = new HashMap<String, Object>();
				Map<String, Object> velParam = new HashMap<String, Object>();		

		
			    /*파라미터 입력*/ 	
				  Map<String, String> mapVO = new HashMap();
					                  mapVO.put("edi_group_cd"	,edi_group_cd); 
					                  mapVO.put("edi_sts"     	,edi_sts); 
					                  mapVO.put("cust_edi_sts"	,cust_edi_sts); 
					                  mapVO.put("cntr_no"		,cntr_no); 
					                  mapVO.put("bkg_no"		,bkg_no); 
		    	
			    if (mapVO != null) {
					    			 param.putAll(mapVO);
					    			 velParam.putAll(mapVO);		
					    			}			
			  dbRowset = new SQLExecuter("").executeQuery(
		       (ISQLTemplate) new Edi315SendDBDAOSearchIsDirFirstViewRSQL(),
		       param,velParam);
			
				int temp = 0;
				if(dbRowset.next()) {
				  temp = dbRowset.getInt(1);
				  return temp;
				}
			      return -1;
			} catch (SQLException se) {
			  log.error(se.getMessage(), se);
			  throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
			  log.error(ex.getMessage(), ex);
			  throw new DAOException(new ErrorHandler(ex).getMessage());
			}
	} 
	  /**isdirlastView 조회
	   * OUTbound GateOut, Inbound GateOut, Inbound GateOut 정보의 마지막은 
	   * COP DTL의 해당 sts의 마지막 location 5자리와 일치 할 경우만 전송 한다.
	   * @param   String cop_no  
	   * @param   String v_edi_sts    
	   * @return String
	   * @throws DAOException
	   */  	
	public String isdirlastView(String cop_no, String v_edi_sts) throws DAOException{
	       DBRowSet dbRowset = null;
			try{
					Map<String, Object> param = new HashMap<String, Object>();
					Map<String, Object> velParam = new HashMap<String, Object>();		
					
					String cop_no_1           = cop_no;
					String v_edi_sts_2        = v_edi_sts;
					 	
					Map<String, String> mapVO = new HashMap();
					mapVO.put("cop_no",cop_no_1); 
					mapVO.put("v_edi_sts",v_edi_sts_2); 
			    	
				    if (mapVO != null) {
		    			 param.putAll(mapVO);
		    			 velParam.putAll(mapVO);		
	    			}
				    dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Edi315SendDBDAOSearchIsDirLastViewRSQL(),param,velParam);
					
					String temp = "";
					if(dbRowset.next()) {
						temp = dbRowset.getString(1);
						return temp;
					}
					
					return null;
			} catch (SQLException se) {
			  log.error(se.getMessage(), se);
			  throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
			  log.error(ex.getMessage(), ex);
			  throw new DAOException(new ErrorHandler(ex).getMessage());
			}
	}

	  /**cop detail node 조회
	   * @param   String cop_no
	   * @param   String v_edi_sts
	   * @param   String cop_dtl_seq
	   * @return String
	   * @throws DAOException
	   */  	
	public String searchCopDtlNod(String cop_no, String v_edi_sts, String cop_dtl_seq) throws DAOException{
	       DBRowSet dbRowset = null;
			try{        	
					Map<String, Object> param = new HashMap<String, Object>();
					Map<String, Object> velParam = new HashMap<String, Object>();		
					
					String cop_no_1           = cop_no;
					String v_edi_sts_2        = v_edi_sts;
					String cop_dtl_seq_1      = cop_dtl_seq;
					
					Map<String, String> mapVO = new HashMap<String, String>();
					mapVO.put("e_cop_no",cop_no_1); 
					mapVO.put("e_edi_sts",v_edi_sts_2); 
					mapVO.put("e_cop_dtl_seq",cop_dtl_seq_1); 
					
					if (mapVO != null) {
						param.putAll(mapVO);
						velParam.putAll(mapVO);		
					}
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Edi315SendDBDAOSearchCopDtlNodRSQL(),param,velParam);
					
					String temp = "";
					if(dbRowset.next()) {
						temp = dbRowset.getString(1);
						return temp;
					}
					
					return null;
			} catch (SQLException se) {
			  log.error(se.getMessage(), se);
			  throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
			  log.error(ex.getMessage(), ex);
			  throw new DAOException(new ErrorHandler(ex).getMessage());
			}
	}
	
	  /**getCopVeVd 조회
       * @param String e_edi_group_cd  
	   * @param	String e_bkg_no        
	   * @param String e_cntr_no	    
	   * @param	String e_chk_sts        
	   * @return int
	   * @throws DAOException
	   */  		
	public int getCopVeVd(String e_edi_group_cd, 
			              String e_bkg_no, 
			              String e_cntr_no, 
			              String e_chk_sts) throws DAOException{
	       DBRowSet dbRowset = null;
			try{        	
				 // query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				// velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();		
				
				String e_edi_group_cd_1   = e_edi_group_cd;
				String e_bkg_no_2         = e_bkg_no;
				String e_cntr_no_3        = e_cntr_no;
				String e_chk_sts_4        = e_chk_sts;				
				
			    /*파라미터 입력*/ 	
				  Map<String, String> mapVO = new HashMap();
					                  mapVO.put("e_edi_group_cd",e_edi_group_cd_1); 
					                  mapVO.put("e_bkg_no",e_bkg_no_2); 
					                  mapVO.put("e_cntr_no",e_cntr_no_3); 
					                  mapVO.put("e_chk_sts",e_chk_sts_4); 
		    	
			    if (mapVO != null) {
					    			 param.putAll(mapVO);
					    			 velParam.putAll(mapVO);		
					    			}			
			  dbRowset = new SQLExecuter("").executeQuery(
		       (ISQLTemplate) new Edi315SendDBDAOGetCopVeVdRSQL(),
		       param,velParam);
			
				int temp = -1;
				if(dbRowset.next()) {
				  temp = dbRowset.getInt(1);
				  return temp;
				}
			      return -1;
			} catch (SQLException se) {
			  log.error(se.getMessage(), se);
			  throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
			  log.error(ex.getMessage(), ex);
			  throw new DAOException(new ErrorHandler(ex).getMessage());
			}
	}

	/**
	 * isDupSndEdi 조회
	 * 
	 * @param String e_edi_group_cd 	
	 * @param String e_edi_sts 		
	 * @param String e_cust_edi_sts_cd 
	 * @param String e_bkg_no 			
	 * @param String e_cntr_no 		
	 * @param String e_evnet_yard 		
	 * @param String e_event_dt 		
	 * @param String e_log_flg 		 <- 단순 로깅인 경우 Duplication Check 안하기 위한 조건에 쓰이는 Flag
	 * @return String
	 * @throws DAOException
	 */
	public String isDupSndEdi(String e_edi_group_cd, String e_edi_sts, String e_cust_edi_sts_cd 
							 ,String e_bkg_no, String e_cntr_no,String e_evnet_yard, String e_event_dt
							 ,String e_log_flg 
							 )
			throws DAOException {
		DBRowSet dbRowset = null;
		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			/* 파라미터 입력 */
			Map<String, String> mapVO = new HashMap();
			mapVO.put("e_edi_group_cd"		, e_edi_group_cd);
			mapVO.put("e_edi_sts"			, e_edi_sts);
			mapVO.put("e_cust_edi_sts_cd"	, e_cust_edi_sts_cd);
			mapVO.put("e_bkg_no"			, e_bkg_no);
			mapVO.put("e_cntr_no"			, e_cntr_no);
			mapVO.put("e_evnet_yard"		, e_evnet_yard);
			mapVO.put("e_event_dt"			, e_event_dt);
			mapVO.put("e_log_flg"			, e_log_flg);

			if (mapVO != null) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOSearchIsDupSndEdiRSQL(), param, velParam);

			String temp = null;
			if (dbRowset.next()) {
				temp = dbRowset.getString(1);
				return temp;
			}
			return null;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	

	/**isInvNbrValue 조회
     * @param String e_bkg_no  
     * @return String
	 * @throws DAOException
	 */ 	
	public String isInvNbrValue(String e_bkg_no) throws DAOException{
	       DBRowSet dbRowset = null;
			try{        	
				 // query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				// velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();		
				
				   String e_bkg_no_1    = e_bkg_no; 			
				
			    /*파라미터 입력*/ 	
				  Map<String, String> mapVO = new HashMap();
					                  mapVO.put("e_bkg_no",e_bkg_no_1); 				                  
		    	
			    if (mapVO != null) {
					    			 param.putAll(mapVO);
					    			 velParam.putAll(mapVO);		
					    			}			
			  dbRowset = new SQLExecuter("").executeQuery(
		       (ISQLTemplate) new Edi315SendDBDAOSearchIsInvNbrValueRSQL(),
		       param,velParam);
			
				String temp = null;
				if(dbRowset.next()) {
				  temp = dbRowset.getString(1);
				  return temp;
				}
			      return null;
			} catch (SQLException se) {
			  log.error(se.getMessage(), se);
			  throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
			  log.error(ex.getMessage(), ex);
			  throw new DAOException(new ErrorHandler(ex).getMessage());
			}		

	}

	/**uvdConvEdiSndRslt 조회
	 * UVD_CONV_EDI_SND_RSLT
     * @param String v_org_yd_cd   
     * @param String v_bkg_no   
     * @param String v_cntr_no   
     * @param String v_edi_group_cd   
     * @param String v_cust_edi_sts_cd  
     * @return int
	 * @throws DAOException
	 */ 	
    public int uvdConvEdiSndRslt(String v_org_yd_cd , 
    		                     String v_bkg_no , 
    		                     String v_cntr_no , 
    		                     String v_edi_group_cd , 
    		                     String v_cust_edi_sts_cd )throws DAOException{
	       DBRowSet dbRowset = null;
			try{        	
				 // query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				// velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();		
				
				String v_org_yd_cd_1        = v_org_yd_cd;
				String v_bkg_no_2           = v_bkg_no;
				String v_cntr_no_3          = v_cntr_no;
				String v_edi_group_cd_4     = v_edi_group_cd;
				String v_cust_edi_sts_cd_5  = v_cust_edi_sts_cd;
				
		
			    /*파라미터 입력*/ 	
				  Map<String, String> mapVO = new HashMap();
					                  mapVO.put("v_org_yd_cd",v_org_yd_cd_1); 
					                  mapVO.put("v_bkg_no",v_bkg_no_2); 
					                  mapVO.put("v_cntr_no",v_cntr_no_3); 
					                  mapVO.put("v_edi_group_cd",v_edi_group_cd_4); 
					                  mapVO.put("v_cust_edi_sts_cd",v_cust_edi_sts_cd_5);              
		    	
			    if (mapVO != null) {
					    			 param.putAll(mapVO);
					    			 velParam.putAll(mapVO);		
					    			}			
			  dbRowset = new SQLExecuter("").executeQuery(
		       (ISQLTemplate) new Edi315SendDBDAOSearchUvdConvEdiSndRsltRSQL(),
		       param,velParam);
			
				int temp = 0;
				if(dbRowset.next()) {
				  temp = dbRowset.getInt(1);
				  return temp;
				}
			      return -1;
			} catch (SQLException se) {
			  log.error(se.getMessage(), se);
			  throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
			  log.error(ex.getMessage(), ex);
			  throw new DAOException(new ErrorHandler(ex).getMessage());
			}    	
    }
	/**getCopVadChk 조회
     * @param String e_bkg_no  
     * @param String e_cntr_no   
     * @param String e_pod_cd  
     * @return int
	 * @throws DAOException
	 */ 	
    public int getCopVadChk(String e_bkg_no , 
    		                String e_cntr_no , 
    		                String e_pod_cd ) throws DAOException{
	       DBRowSet dbRowset = null;
			try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			/* 파라미터 입력 */
			Map<String, String> mapVO = new HashMap();
			mapVO.put("bkg_no", e_bkg_no);
			mapVO.put("cntr_no", e_cntr_no);
			mapVO.put("pod_cd", e_pod_cd);

			if (mapVO != null) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOGetCopVadChkRSQL(),
					param, velParam);

			int temp = 0;
			if (dbRowset.next()) {
				temp = dbRowset.getInt(1);
				return temp;
			}
			return -1;
		} catch (SQLException se) {
			  log.error(se.getMessage(), se);
			  throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
			  log.error(ex.getMessage(), ex);
			  throw new DAOException(new ErrorHandler(ex).getMessage());
			}     	
    }
	/**getDateTime 조회
     * @param String event_dt  
     * @param String postfix   
     * @return String
	 * @throws DAOException
	 */     
    public String getHobbyLobbyDateTime(String event_dt,String postfix) throws DAOException{
	       DBRowSet dbRowset = null;
			try{        	
				 // query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				// velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();		
				
				   String event_dt_1    = event_dt; 
				   String postfix_2     = postfix;
				
			    /*파라미터 입력*/ 	
				  Map<String, String> mapVO = new HashMap();
					                  mapVO.put("event_dt",event_dt_1); 
					                  mapVO.put("postfix",postfix_2); 
		    	
			    if (mapVO != null) {
					    			 param.putAll(mapVO);
					    			 velParam.putAll(mapVO);		
					    			}			
			  dbRowset = new SQLExecuter("").executeQuery(
		       (ISQLTemplate) new Edi315SendDBDAOGetHobbyLobbyDateTimeRSQL(),
		       param,velParam);
			
				String temp = null;
				if(dbRowset.next()) {
				  temp = dbRowset.getString(1);
				  return temp;
				}
			      return null;
			} catch (SQLException se) {
			  log.error(se.getMessage(), se);
			  throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
			  log.error(ex.getMessage(), ex);
			  throw new DAOException(new ErrorHandler(ex).getMessage());
			}   	
    }
    
    

	/**getGmtDt 조회
	 * @param String event_dt  
	 * @param String nod_cd   
	 * @return String
	 * @throws DAOException
	 */
    public String getGmtDt(String event_dt, String nod_cd) throws DAOException {
		DBRowSet dbRowset = null;
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			/* 파라미터 입력 */
			Map<String, String> mapVO = new HashMap();
			mapVO.put("event_dt", event_dt);
			mapVO.put("nod_cd", nod_cd);

			if (mapVO != null) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new Edi315SendDBDAOGetGmtDtRSQL(),
							param, velParam);

			String temp = null;
			if (dbRowset.next()) {
				temp = dbRowset.getString(1);
				return temp;
			}
			return null;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

    
    
	/**getEvntDt 조회
	 * @param Edi315DetailVO dtlVo
	 * @return List<GetEvntDtVO>
	 * @throws DAOException
	 */
    public List<GetEvntDtVO> getEvntDt(Edi315DetailVO dtlVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<GetEvntDtVO> list = null;
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			/* 파라미터 입력 */
			Map<String, String> mapVO = new HashMap();
			mapVO.put("edi_sts", dtlVo.getEdiSts());
			mapVO.put("cop_no", dtlVo.getCopNo());

			if (mapVO != null) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new Edi315SendDBDAOGetEvntDtRSQL(),
							param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset,GetEvntDtVO.class);
			return list;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
    
	/**getEvntDt 조회
	 * @param Edi315DetailVO dtlVo
	 * @return int
	 * @throws DAOException
	 */
    public int getPreSentCnt(Edi315DetailVO dtlVo) throws DAOException {
		DBRowSet dbRowset = null;
//		List<GetEvntDtVO> list = null;
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			/* 파라미터 입력 */

			Map<String, String> mapVO = dtlVo.getColumnValues();


			if (mapVO != null) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new Edi315SendDBDAOGetPreSentCntRSQL(),
							param, velParam);

			int temp = 0;
			if(dbRowset.next()) {
				temp = dbRowset.getInt(1);
				return temp;
			}
			return -1;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * getConvInToUVDFlg
     * @param String edi_grp_cd
     * @param String bkg_no
     * @param String cntr_no
     * @param String cop_no
     * @return String
	 * @throws DAOException
	 */     
    public String getConvInToUVDFlg(String edi_grp_cd
    		                      , String bkg_no
    		                      , String cntr_no
    		                      , String cop_no )throws DAOException {
    	DBRowSet dbRowset = null;
    	String temp = "N";
    	try {
    		
    		Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			Map<String, String> mapVO = new HashMap();
			mapVO.put("edi_grp_cd", edi_grp_cd);
			mapVO.put("bkg_no", bkg_no);
			mapVO.put("cntr_no", cntr_no);
			mapVO.put("cop_no", cop_no);
			
			if (mapVO != null) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOGetConvInToUVDFlgRSQL(),
					param, velParam);
			if (dbRowset.next()) {
				temp = dbRowset.getString(1);
				return temp;
			}
			return temp;
    	} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    }

    
	/**getDateTime2 조회
	 * getCOP_ALN_OAN
     * @param  String e_edi_group_cd   
     * @param  String e_bkg_no         
     * @param  String e_cntr_no        
     * @param  String e_org_yard_cd   
     * @param  String e_chk_sts         
     * @return int 
	 * @throws DAOException
	 */        
    public int getCopAlnOan(String e_edi_group_cd, 
    		                String e_bkg_no, 
    		                String e_cntr_no,   
    		                String e_event_yard,
    		                String e_chk_sts) throws DAOException{
	       DBRowSet dbRowset = null;
			try{        	
				Map<String, Object> param = new HashMap<String, Object>();
				Map<String, Object> velParam = new HashMap<String, Object>();		
				
				String e_edi_group_cd_1   = e_edi_group_cd;
				String e_bkg_no_2         = e_bkg_no;
				String e_cntr_no_3        = e_cntr_no;
				String e_event_yard_4     = e_event_yard;
				String e_chk_sts_5        = e_chk_sts;

				
		
			    /*파라미터 입력*/ 	
				  Map<String, String> mapVO = new HashMap();
					                  mapVO.put("e_edi_group_cd",e_edi_group_cd_1); 
					                  mapVO.put("e_bkg_no",e_bkg_no_2); 
					                  mapVO.put("e_event_yard",e_event_yard_4); 
					                  mapVO.put("e_cntr_no",e_cntr_no_3);             
					                  mapVO.put("e_chk_sts",e_chk_sts_5); 
			    if (mapVO != null) {
					    			 param.putAll(mapVO);
					    			 velParam.putAll(mapVO);		
					    			}			
			  dbRowset = new SQLExecuter("").executeQuery(
		       (ISQLTemplate) new Edi315SendDBDAOGetCopAlnOanRSQL(),
		       param,velParam);
			
				int temp = 0;
				if(dbRowset.next()) {
				  temp = dbRowset.getInt(1);
				  return temp;
				}
			      return -1;
			} catch (SQLException se) {
			  log.error(se.getMessage(), se);
			  throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
			  log.error(ex.getMessage(), ex);
			  throw new DAOException(new ErrorHandler(ex).getMessage());
			}
    	
    }

	/**getCopOanRln 조회
	 * getCOP_OAN_RLN
     * @param String e_edi_group_cd   
	 * @param String e_bkg_no   
	 * @param String e_cntr_no  
	 * @param String e_chk_sts    
     * @return int
	 * @throws DAOException
	 */        
	public int getCopOanRln(String e_edi_group_cd , 
			                String e_bkg_no , 
			                String e_cntr_no , 
			                String e_chk_sts ) throws DAOException{

	       DBRowSet dbRowset = null;
			try{        	
				 // query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				// velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();		
				
				String e_edi_group_cd_1   = e_edi_group_cd;
				String e_bkg_no_2         = e_bkg_no;
				String e_cntr_no_3        = e_cntr_no;
				String e_chk_sts_4        = e_chk_sts;

				
		
			    /*파라미터 입력*/ 	
				  Map<String, String> mapVO = new HashMap();
					                  mapVO.put("e_edi_group_cd",e_edi_group_cd_1); 
					                  mapVO.put("e_bkg_no",e_bkg_no_2); 
					                  mapVO.put("e_cntr_no",e_cntr_no_3);               
					                  mapVO.put("e_chk_sts",e_chk_sts_4); 
					                  
			    if (mapVO != null) {
					    			 param.putAll(mapVO);
					    			 velParam.putAll(mapVO);		
					    			}			
			  dbRowset = new SQLExecuter("").executeQuery(
		       (ISQLTemplate) new Edi315SendDBDAOGetCopOanRlnRSQL(),
		       param,velParam);
			
				int temp = 0;
				if(dbRowset.next()) {
				  temp = dbRowset.getInt(1);
				  return temp;
				}
			      return -1;
			} catch (SQLException se) {
			  log.error(se.getMessage(), se);
			  throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
			  log.error(ex.getMessage(), ex);
			  throw new DAOException(new ErrorHandler(ex).getMessage());
			}
	}
	
	/**
	 * TRS에서 콜한 'WO' Status의 경우 COP_NO 만 넘어오므로 기본 BKG_NO, CNTR_NO등의 정보.
	 Edi Flage File create 및 Send 부분을 구현한다.(Work order가 들어왔을때)

     EventResponse createWOEdiSend(String TRSP_SO_OFC_CTY_CD, String TRSP_SO_SEQ) 
    	DBRowSet dRs = new DBRowSet();
    	HashMap paramHash = new HashMap();
        EventResponse eventResponse = null;
        EdiSendEvent event = null;
        try {
            dRs = searchSOEdiDetailData(TRSP_SO_OFC_CTY_CD, TRSP_SO_SEQ);
            if(dRs.next()){
            	paramHash.put("bkg_no", dRs.getString("bkg_no"));
            	paramHash.put("bkg_no_split", dRs.getString("bkg_no_split"));
            	paramHash.put("bl_no", dRs.getString("bl_no"));
            	paramHash.put("cntr_no", dRs.getString("cntr_no"));
            	paramHash.put("nod", dRs.getString("nod"));
            	paramHash.put("event_dt", dRs.getString("event_dt"));
            	paramHash.put("edi_sts", dRs.getString("edi_sts"));
            	paramHash.put("cnmv_full_flg", dRs.getString("cnmv_full_flg"));
            	paramHash.put("call_from", dRs.getString("call_from"));
            	event = new EdiSendEvent(paramHash);//EDI Send Method 호출
                eventResponse = createEdiSend(event);
            }else{
            	eventResponse = new EdiSendEventResponse("SUCCESS");
            }
            
     *  } catch (EventException de) {
	 * 
     * @param Edi315SendVO sendVo
     * @return Edi315SendVO
	 * @throws DAOException
	 */       
    public Edi315SendVO checkCallTRS(Edi315SendVO sendVo) throws DAOException{
	       DBRowSet dbRowset = null;
			try{        	
				 // query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				// velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();		
				
				   String cop_no_1               = sendVo.getCopNo(); 
				   String cost_act_grp_seq_2     = sendVo.getCostActGrpSeq();
				
			    /*파라미터 입력*/ 	
				  Map<String, String> mapVO = new HashMap();
					                  mapVO.put("e_cop_no",cop_no_1); 
					                  mapVO.put("e_cost_act_grp_seq",cost_act_grp_seq_2); 
		    	
			    if (mapVO != null) {
					    			 param.putAll(mapVO);
					    			 velParam.putAll(mapVO);		
					    			}			
			  dbRowset = new SQLExecuter("").executeQuery(
		       (ISQLTemplate) new Edi315SendDBDAOSearchTrsCallRSQL(),
		       param,velParam);
			
				if(dbRowset.next()) {
				  /*BKG_NO	CNTR_NO	EVENT_YARD	EVENT_DT*/
				  sendVo.setBkgNo    (dbRowset.getString("BKG_NO"    ));
				  sendVo.setBlNo     (dbRowset.getString("BL_NO"     ));
				  sendVo.setCntrNo   (dbRowset.getString("CNTR_NO"   ));
				  sendVo.setEventYard(dbRowset.getString("EVENT_YARD"));
				  sendVo.setEventDt  (dbRowset.getString("EVENT_DT"  ));
				  sendVo.setCopDtlSeq(dbRowset.getString("COP_DTL_SEQ"  ));
				  sendVo.setCallFrom ("COP");
				  return sendVo;
				}else{
				  /*In the case of Number of Row being 0*/	
			      return null;
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
	 * getRailTerm
     * @param  String cop_no  
     * @return GetRailTermVO
	 * @throws DAOException
	 */ 
    public GetRailTermVO getRailTerm(String cop_no) throws DAOException {
		DBRowSet dbRowset = null;
		GetRailTermVO getRailTermVO = new GetRailTermVO();
		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			/* 파라미터 입력 */
			Map<String, String> mapVO = new HashMap();
			mapVO.put("cop_no", cop_no);
			

			if (mapVO != null) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}// if
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOGetRailTermRSQL(),
					param, velParam);

			
			
			if (dbRowset.next()) {
				/* BKG_NO CNTR_NO EVENT_YARD EVENT_DT */
				getRailTermVO.setRailCnt(dbRowset.getString("rail_cnt"));
				getRailTermVO.setOanTermSeq(dbRowset.getString("oan_term_seq"));
				
				return getRailTermVO;
			} else {
				/* In the case of Number of Row being 0 */
				return null;
			}
			

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}// try
	}
    
	/**modifySceEdiHisDtl 
     * @param  String e_rslt_flag  
     * @param  String e_rslt_remark  
     * @param  String e_rcv_dt  
     * @param  String e_rcv_seq  
     * @param  String e_rcv_dtl_seq   
     * @return boolean
	 * @throws DAOException
	 */       
    public boolean modifySceEdiHisDtl(
    		                  String e_rslt_flag,
                              String e_rslt_remark,
                              String e_rcv_dt,
                              String e_rcv_seq,
                              String e_rcv_dtl_seq) throws DAOException{
	    boolean resultFlag = false;
		 // query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		String e_rslt_flag_1     = e_rslt_flag;
		String e_rslt_remark_2   = e_rslt_remark;
		String e_rcv_dt_3        = e_rcv_dt;
		String e_rcv_seq_4       = e_rcv_seq;
		String e_rcv_dtl_seq_5   = e_rcv_dtl_seq;
		
		
	     /*파라미터 입력*/ 	
		  Map<String, String> mapVO = new HashMap();
			        mapVO.put("e_rslt_flag"  ,e_rslt_flag_1  ); 
			        mapVO.put("e_rslt_remark",e_rslt_remark_2);       
					mapVO.put("e_rcv_dt"     ,e_rcv_dt_3     );       
					mapVO.put("e_rcv_seq"    ,e_rcv_seq_4    );    
					mapVO.put("e_rcv_dtl_seq",e_rcv_dtl_seq_5);   

					
	     param.putAll(mapVO);
	     velParam.putAll(mapVO);
		try {
			    int insCnt = 0;
				
	 			  if(mapVO.size() > 0){
	 					insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new Edi315SendDBDAOModifySceEdiHisDtlUSQL(), param, velParam);
	 						if(insCnt == Statement.EXECUTE_FAILED)
	 							throw new DAOException("Fail to Update at SQL: Edi315SendDBDAOModifySceEdiHisDtlUSQL");
	 			  }	
			resultFlag = true;
		} catch (SQLException se) {
			resultFlag = false;
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("Updating into SCE_EDI_HIS_DTL:",new String[]{}).getMessage());
		} catch (Exception ex) {
			resultFlag = false;
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler("Updating into SCE_EDI_HIS_DTL:",new String[]{}).getMessage());
		}
	
	return resultFlag;      	
    	
    }

    /**modifySceEdiHisEdiRmk 수정
     * @param  String cust_rmk
     * @param  String rcv_dt
     * @param  String rcv_seq
     * @return boolean
	 * @throws DAOException 
	 */       
    public boolean modifySceEdiHisCustRmk(
                              String cust_rmk,
                              String rcv_dt,
                              String rcv_seq) throws DAOException{
	    boolean resultFlag = false;
		 // query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		

		
	     /*파라미터 입력*/ 	
		  Map<String, String> mapVO = new HashMap();
			        mapVO.put("cust_rmk" ,cust_rmk);       
					mapVO.put("rcv_dt"  ,rcv_dt );       
					mapVO.put("rcv_seq" ,rcv_seq);     

	     param.putAll(mapVO);
	     velParam.putAll(mapVO);
		try {
			    int insCnt = 0;
				
	 			  if(mapVO.size() > 0){
	 					insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new Edi315SendDBDAOModifySceEdiHisCustRmkUSQL(), param, velParam);
	 						if(insCnt == Statement.EXECUTE_FAILED)
	 							throw new DAOException("Fail to Update at SQL: Edi315SendDBDAOModifySceEdiHisCustRmkUSQL");
	 			  }
			resultFlag = true;
		} catch (SQLException se) {
			resultFlag = false;
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("Updating into SCE_EDI_HIS_DTL:",new String[]{}).getMessage());
		} catch (Exception ex) {
			resultFlag = false;
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler("Updating into SCE_EDI_HIS_DTL:",new String[]{}).getMessage());
		}
	
	return resultFlag;      	
    	
    } 
    /**modifySceEdiHisEdiRmk 수정
     * @param  String edi_rmk  
     * @param  String rcv_dt  
     * @param  String rcv_seq  
     * @return boolean
	 * @throws DAOException 
	 */       
    public boolean modifySceEdiHisEdiRmk(
                              String edi_rmk,
                              String rcv_dt,
                              String rcv_seq) throws DAOException{
	    boolean resultFlag = false;
		 // query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		

		
	     /*파라미터 입력*/ 	
		  Map<String, String> mapVO = new HashMap();
			        mapVO.put("edi_rmk" ,edi_rmk);       
					mapVO.put("rcv_dt"  ,rcv_dt );       
					mapVO.put("rcv_seq" ,rcv_seq);     

	     param.putAll(mapVO);
	     velParam.putAll(mapVO);
		try {
			    int insCnt = 0;
				
	 			  if(mapVO.size() > 0){
	 					insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new Edi315SendDBDAOModifySceEdiHisEdiRmkUSQL(), param, velParam);
	 						if(insCnt == Statement.EXECUTE_FAILED)
	 							throw new DAOException("Fail to Update at SQL: Edi315SendDBDAOModifySceEdiHisEdiRmkUSQL");
	 			  }
			resultFlag = true;
		} catch (SQLException se) {
			resultFlag = false;
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("Updating into SCE_EDI_HIS_DTL:",new String[]{}).getMessage());
		} catch (Exception ex) {
			resultFlag = false;
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler("Updating into SCE_EDI_HIS_DTL:",new String[]{}).getMessage());
		}
	
	return resultFlag;      	
    	
    } 


    /**modifySceEdiHisDtlEdiRmk1 수정
     * @param  String edi_rmk1  
     * @param  String rcv_dt  
     * @param  String rcv_seq  
     * @param  String rcv_dtl_seq   
     * @return boolean
	 * @throws DAOException
	 */       
    public boolean modifySceEdiHisDtlEdiRmk1(
                              String edi_rmk1,
                              String rcv_dt,
                              String rcv_seq,
                              String rcv_dtl_seq) throws DAOException{
	    boolean resultFlag = false;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();		

		
	     /*파라미터 입력*/ 	
		  Map<String, String> mapVO = new HashMap();
			        mapVO.put("edi_rmk1"   ,edi_rmk1   );       
					mapVO.put("rcv_dt"     ,rcv_dt     );       
					mapVO.put("rcv_seq"    ,rcv_seq    );    
					mapVO.put("rcv_dtl_seq",rcv_dtl_seq);   

	     param.putAll(mapVO);
	     velParam.putAll(mapVO);
		try {
			    int insCnt = 0;
				
	 			  if(mapVO.size() > 0){
	 					insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new Edi315SendDBDAOModifySceEdiHisDtlEdiRmk1USQL(), param, velParam);
	 						if(insCnt == Statement.EXECUTE_FAILED)
	 							throw new DAOException("Fail to Update at SQL: Edi315SendDBDAOModifySceEdiHisDtlEdiRmk1USQL");
	 			  }	
			resultFlag = true;
		} catch (SQLException se) {
			resultFlag = false;
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("Updating into SCE_EDI_HIS_DTL:",new String[]{}).getMessage());
		} catch (Exception ex) {
			resultFlag = false;
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler("Updating into SCE_EDI_HIS_DTL:",new String[]{}).getMessage());
		}
	
	return resultFlag;      	
    	
    }     
    
    /**modifySceActRcvIf 수정
     * @param  String e_rslt_flag  
     * @param  String e_rcv_dt  
     * @param  String e_rcv_seq   
     * @return boolean
	 * @throws DAOException
	 */    
    public boolean modifySceActRcvIf(String e_rslt_flag, String e_rcv_dt, String e_rcv_seq)
			throws DAOException {
		boolean resultFlag = false;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		/* 파라미터 입력 */
		Map<String, String> mapVO = new HashMap();
		mapVO.put("e_rslt_flag", e_rslt_flag);
		mapVO.put("e_rcv_dt", e_rcv_dt);
		mapVO.put("e_rcv_seq", e_rcv_seq);
		

		param.putAll(mapVO);
		velParam.putAll(mapVO);
		try {
			int insCnt = 0;

			if (mapVO.size() > 0) {
				insCnt = new SQLExecuter("")
						.executeUpdate(
								(ISQLTemplate) new Edi315SendDBDAOModifySceActRcvIfUSQL(),
								param, velParam);
				if (insCnt == Statement.EXECUTE_FAILED)
					throw new DAOException(
							"Fail to Update at SQL: Edi315SendDBDAOModifySceActRcvIfUSQL");
			}// if
			resultFlag = true;
		} catch (SQLException se) {
			resultFlag = false;
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(
					"Updating into SCE_EDI_HIS_DTL:", new String[] {})
					.getMessage());
		} catch (Exception ex) {
			resultFlag = false;
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(
					"Updating into SCE_EDI_HIS_DTL:", new String[] {})
					.getMessage());
		}// try

		return resultFlag;

	}
    
    
    
    
    
	/**searchNodInformation 조회
     * @param String event_yard
     * @return DBRowSet
	 * @throws DAOException
	 */    
    public DBRowSet searchNodInformation(String event_yard) throws DAOException{
    	DBRowSet dbRowset = null;

		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();		
	
		 Map<String, String> mapVO = new HashMap();
			                 mapVO.put("e_event_yard",event_yard); 
	     param.putAll(mapVO);
	     velParam.putAll(mapVO);
	     
       try{        	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOSearchNodInformationRSQL(),
					param,velParam);
           return dbRowset;
       } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}     	
    }
    
	/**getBkgTerm 조회
     * @param  String bkg_no
     * @return DBRowSet
	 * @throws DAOException
	 */      
    public DBRowSet getBkgTerm(String bkg_no) throws DAOException{
    	DBRowSet dbRowset = null;
		 // query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		String bkg_no_1       = bkg_no;

	     /*파라미터 입력*/ 	
		 Map<String, String> mapVO = new HashMap();
			                 mapVO.put("e_bkg_no",bkg_no_1); 
	     param.putAll(mapVO);
	     velParam.putAll(mapVO);
      try{        	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOGetBkgTermRSQL(),
					param,velParam);

          return dbRowset;
      } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}     	
   }
	/**searchPonsealInformation 조회
     * @param  String bkg_no 
     * @param  String cntr_no  
     * @return DBRowSet
	 * @throws DAOException
	 */         
    public DBRowSet searchPonsealInformation(String bkg_no, String cntr_no) throws DAOException{
    	DBRowSet dbRowset = null;
		 // query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		String bkg_no_1        = bkg_no;
		String cntr_no_2       = cntr_no;

	     /*파라미터 입력*/ 	
		 Map<String, String> mapVO = new HashMap();
		                     mapVO.put("e_bkg_no",bkg_no_1); 
			                 mapVO.put("e_cntr_no",cntr_no_2); 
	     param.putAll(mapVO);
	     velParam.putAll(mapVO);
     try{        	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOSearchPonsealInformationRSQL(),
					param,velParam);
         return dbRowset;
     } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}     	
    }
	/**getCustRefNo 조회
     * @param  String bkg_no  
     * @return String
	 * @throws DAOException
	 */ 
    public String getCustRefNo(String bkg_no) throws DAOException{
    	DBRowSet dbRowset = null;
		 // query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		String bkg_no_1       = bkg_no;

	     /*파라미터 입력*/ 	
		 Map<String, String> mapVO = new HashMap();
			                 mapVO.put("bkg_no",bkg_no_1); 
	     param.putAll(mapVO);
	     velParam.putAll(mapVO);
	     String temp = "";
      try{        	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOGetCustRefNoRSQL(),
					param,velParam);
			if(dbRowset != null && dbRowset.next()){
				temp = dbRowset.getString("CUST_REF_NO_CTNT");
			}
          return temp;
      } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}     	
   }    
	/**getCustRefNo 조회
     * @param  String cop_no  
     * @return String
	 * @throws DAOException
	 */ 
    public String getCnmv322Rail(String cop_no) throws DAOException{
    	DBRowSet dbRowset = null;
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();		
		

	     /*파라미터 입력*/ 	
		 Map<String, String> mapVO = new HashMap();
			                 mapVO.put("cop_no",cop_no); 
	     param.putAll(mapVO);
	     velParam.putAll(mapVO);
	     String temp = "";
      try{        	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOGetCnmv322RailRSQL(),
					param,velParam);
			if(dbRowset != null && dbRowset.next()){
				temp = dbRowset.getString("NT_LOC_CD");
			}
          return temp;
      } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}     	
   }   

	/**getShipperRefno 
     * @param  String bkg_no
     * @return String
	 * @throws DAOException
	 */    
    public String getShipperRefno(String bkg_no) throws DAOException{
    	DBRowSet dbRowset = null;
		 // query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		String bkg_no_1       = bkg_no;

	     /*파라미터 입력*/ 	
		 Map<String, String> mapVO = new HashMap();
			                 mapVO.put("e_bkg_no",bkg_no_1); 
	     param.putAll(mapVO);
	     velParam.putAll(mapVO);
	     String temp = "";
      try{        	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOGetShipperRefnoRSQL(),
					param,velParam);
			if(dbRowset != null && dbRowset.next()){
				temp = dbRowset.getString("SH_REF_NBR");
			}
          return temp;
      } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}     	
   }  
	/**getForwardRefno 조회
     * @param  String bkg_no  
     * @return String
	 * @throws DAOException
	 */       
    public String getForwardRefno(String bkg_no) throws DAOException{
    	DBRowSet dbRowset = null;
		 // query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		String bkg_no_1       = bkg_no;

	     /*파라미터 입력*/ 	
		 Map<String, String> mapVO = new HashMap();
			                 mapVO.put("e_bkg_no",bkg_no_1); 
	     param.putAll(mapVO);
	     velParam.putAll(mapVO);
	     String temp = "";
      try{        	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOGetForwardRefnoRSQL(),
					param,velParam);
			if(dbRowset != null && dbRowset.next()){
				temp = dbRowset.getString("FW_REF_NBR");
			}
          return temp;
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}     	
   }     
	/**getLocPodEta 조회
     * @param String cop_no 
     * @return String
	 * @throws DAOException
	 */   
   public String getLocPodEta(String cop_no) throws DAOException{
	   	DBRowSet dbRowset = null;
		 // query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		String cop_no_1       = cop_no;
	
	    /*파라미터 입력*/ 	
		 Map<String, String> mapVO = new HashMap();
			                 mapVO.put("e_cop_no",cop_no_1); 
	    param.putAll(mapVO);
	    velParam.putAll(mapVO);
	    String temp = "";
	    try{        	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOGetLocPodEtaRSQL(),param,velParam);
			if(dbRowset != null && dbRowset.next()){
				temp = dbRowset.getString(1);
			}
	     return temp;
	    } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		} 
   }
	/**getRailPodEta 조회
     * @param String cop_no  
     * @return DBRowSet
	 * @throws DAOException
	 */    
   public DBRowSet getRailPodEta(String cop_no) throws DAOException{
	   	DBRowSet dbRowset = null;
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
	    /*파라미터 입력*/ 	
		 Map<String, String> mapVO = new HashMap();
			                 mapVO.put("e_cop_no",cop_no); 
	    param.putAll(mapVO);
	    velParam.putAll(mapVO);
	    try{        	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOGetRailPodEtaRSQL(),
					param,velParam);
	     return dbRowset;
	    } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		} 	   
   }

   
   
	/**getRsltPickNoInfo 조회
     * @param String edi_grp_cd  
     * @param String cntr_no  
     * @param String bkg_no   
     * @return String
	 * @throws DAOException
	 */    
   public String getRsltPickNoInfo(String edi_grp_cd, 
                                   String cntr_no,
                                   String bkg_no)throws DAOException{
	   	DBRowSet dbRowset = null;
		 // query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		String edi_grp_cd_1            = edi_grp_cd;
		String cntr_no_2               = cntr_no;
		String bkg_no_3                = bkg_no;
	
	    /*파라미터 입력*/ 	
		 Map<String, String> mapVO = new HashMap();
			                 mapVO.put("e_edi_grp_cd",edi_grp_cd_1); 
			                 mapVO.put("e_cntr_no"   ,cntr_no_2); 
			                 mapVO.put("e_bkg_no"    ,bkg_no_3); 
	    param.putAll(mapVO);
	    velParam.putAll(mapVO);
	    String temp = "";
	    try{        	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOGetRsltPickNoInfoRSQL(),
					param,velParam);
			if(dbRowset != null && dbRowset.next()){
				temp = dbRowset.getString("PKUP_EDI_322_NO");
			}			
	     return temp;
	    } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		} 
   }
	/**searchPickupNumInformation 조회
     * @param String cntr_no  
     * @param String bkg_no    
     * @return String
	 * @throws DAOException
	 */     
   public String searchPickupNumInformation(String cntr_no,String bkg_no) throws DAOException{
	   	DBRowSet dbRowset = null;
		 // query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		String cntr_no_1              = cntr_no;
		String bkg_no_2               = bkg_no;
	
	    /*파라미터 입력*/ 	
		 Map<String, String> mapVO = new HashMap();
			                 mapVO.put("e_cntr_no"  ,cntr_no_1); 
			                 mapVO.put("e_bkg_no"   ,bkg_no_2 ); 
	    param.putAll(mapVO);
	    velParam.putAll(mapVO);
	    String temp = "";
	    try{        	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOSearchPickupNumInformationRSQL(),
					param,velParam);
			if(dbRowset != null && dbRowset.next()){
				temp = dbRowset.getString("PKUP_NO");
			}			
	     return temp;
	    } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		} 
   }
	/**get322PickNoInfo 조회
     * @param String cntr_no  
     * @param String event_dt    
     * @return String
	 * @throws DAOException
	 */       
   public String get322PickNoInfo(String cntr_no ,
                                  String event_dt
                                  ) throws DAOException{
	   	DBRowSet dbRowset = null;
		 // query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		String cntr_no_1              = cntr_no;
		String event_dt_2               = event_dt;
	
	    /*파라미터 입력*/ 	
		 Map<String, String> mapVO = new HashMap();
			                 mapVO.put("e_cntr_no"  ,cntr_no_1 ); 
			                 mapVO.put("e_event_dt" ,event_dt_2); 
	    param.putAll(mapVO);
	    velParam.putAll(mapVO);
	    String temp = "";
	    try{        	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOGet322PickNoInfoRSQL(),
					param,velParam);
			if(dbRowset != null && dbRowset.next()){
				temp = dbRowset.getString("PICK_NO");
			}			
	     return temp;
	    } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
   }
	/**searchCuSts 조회
     * @param String edi_grp_cd  
     * @param String cntr_no   
     * @param String bkg_no    
     * @return String
	 * @throws DAOException
	 */       
   public String searchCuSts(String edi_grp_cd ,String cntr_no,String bkg_no) throws DAOException{   
	   	DBRowSet dbRowset = null;
		 // query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		String edi_grp_cd_1          = edi_grp_cd;
		String cntr_no_2             = cntr_no;
		String bkg_no_3              = bkg_no;
	
	    /*파라미터 입력*/ 	
		 Map<String, String> mapVO = new HashMap();
			                 mapVO.put("e_edi_grp_cd",edi_grp_cd_1); 
			                 mapVO.put("e_cntr_no"   ,cntr_no_2   ); 
			                 mapVO.put("e_bkg_no"    ,bkg_no_3    ); 
	    param.putAll(mapVO);
	    velParam.putAll(mapVO);
	    String temp = "";
	    try{        	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOSearchCuStsRSQL(),
					param,velParam);
			if(dbRowset != null && dbRowset.next()){
				temp = dbRowset.getString(1);
			}			
	     return temp;
	    } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
   }
   
	/**searchCnmv322RailInfo 조회
     * @param String cop_no  
     * @param String edi_grp_cd    
     * @return DBRowSet
	 * @throws DAOException
	 */   
   public DBRowSet searchCnmv322RailInfo(String cop_no , String edi_grp_cd) throws DAOException{
	   	DBRowSet dbRowset = null;
		 // query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		

	
	    /*파라미터 입력*/ 	
		 Map<String, String> mapVO = new HashMap();
			                 mapVO.put("cop_no",cop_no); 
			                 mapVO.put("edi_grp_cd",edi_grp_cd); 
	    param.putAll(mapVO);
	    velParam.putAll(mapVO);
	    try{        	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOSearchCnmv322RailInfoRSQL(),
					param,velParam);
	     return dbRowset;
	    } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		} 
  }

	/**searchBkgqtyInformation 조회
     * @param String bkg_no   
     * @return DBRowSet
	 * @throws DAOException
	 */     
   public DBRowSet searchBkgqtyInformation(String bkg_no) throws DAOException{
	   	DBRowSet dbRowset = null;
		 // query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		String bkg_no_1            = bkg_no;
	
	    /*파라미터 입력*/ 	
		 Map<String, String> mapVO = new HashMap();
			                 mapVO.put("e_bkg_no",bkg_no_1); 
	    param.putAll(mapVO);
	    velParam.putAll(mapVO);
	    try{        	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOSearchBkgqtyInformationRSQL(),
					param,velParam);
	     return dbRowset;
	    } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		} 
  }
	/**getBkgPoNo 조회
     * @param String bkg_no   
     * @return String
	 * @throws DAOException
	 */    
   public String getBkgPoNo(String bkg_no) throws DAOException{
	   	DBRowSet dbRowset = null;
		 // query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		String bkg_no_1          = bkg_no;
	
	    /*파라미터 입력*/ 	
		 Map<String, String> mapVO = new HashMap();
			                 mapVO.put("e_bkg_no",bkg_no_1); 
	    param.putAll(mapVO);
	    velParam.putAll(mapVO);
	    String temp = "";
	    try{        	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOGetBkgPoNoRSQL(),
					param,velParam);
			
			if(dbRowset != null && dbRowset.next()){
				temp = dbRowset.getString("BL_PO_NBR");
			}
	     return temp;
	    } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
   }
   
   
   
	/**getSplitBkgPantosCase
    * @param String bkg_no
    * @return String
	* @throws DAOException
	*/    
   public String getSplitBkgPantosCase(String bkg_no) throws DAOException{
	   	DBRowSet dbRowset = null;
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();		
	    /*파라미터 입력*/ 	
		 Map<String, String> mapVO = new HashMap();
			                 mapVO.put("bkg_no",bkg_no); 
	    param.putAll(mapVO);
	    velParam.putAll(mapVO);
	    String splitPantos = "";
	    try{        	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOGetSplitBkgPantosCaseRSQL(),
					param,velParam);
			
			if(dbRowset != null && dbRowset.next()){
				splitPantos = dbRowset.getString("SPLIT_PANTOS_CASE");
			}
	     return splitPantos;
	    } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
   }
	/**getSplitBkgPantosBlNo
    * @param String bkg_no
    * @return String
	* @throws DAOException
	*/    
   public String getSplitBkgPantosBlNo(String bkg_no) throws DAOException{
	   	DBRowSet dbRowset = null;
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();		
	    /*파라미터 입력*/ 	
		 Map<String, String> mapVO = new HashMap();
			                 mapVO.put("bkg_no",bkg_no); 
	    param.putAll(mapVO);
	    velParam.putAll(mapVO);
	    String pantosBlNo = "";
	    try{        	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOGetSplitBkgPantosBlNoRSQL(),
					param,velParam);
			
			if(dbRowset != null && dbRowset.next()){
				pantosBlNo = dbRowset.getString("PANTOS_BL_NO");
			}
	     return pantosBlNo;
	    } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
   }   
   
	/**getReservedEventDt
	 * Reserved Case 에는 Event Date와 Send Date를 구해 하는데, Interval 을 더해 Date를 재 계산 함.
     * @param String bkg_no
     * @return String
	 * @throws DAOException
	 */   
   public String getReservedEventDt(String event_dt, String edi_snd_itval_hr)throws DAOException {
		DBRowSet dbRowset = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		Map<String, String> mapVO = new HashMap();
			mapVO.put("event_dt", event_dt);
			mapVO.put("edi_snd_itval_hr", edi_snd_itval_hr);
		param.putAll(mapVO);
		velParam.putAll(mapVO);
		String temp = "";
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOGetReservedEventDtRSQL(),
					param, velParam);

			if (dbRowset != null && dbRowset.next()) {
				temp = dbRowset.getString("RSV_EVENT_DT");
			} else {
				temp = event_dt;
			}
			return temp;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}// try
	}
	/**getSonyInvNo 조회
     * @param String bkg_no   
     * @return String
	 * @throws DAOException
	 */    
   public String getSonyInvNo(String bkg_no) throws DAOException{
	   	DBRowSet dbRowset = null;
		 // query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		String bkg_no_1          = bkg_no;
	
	    /*파라미터 입력*/ 	
		 Map<String, String> mapVO = new HashMap();
			                 mapVO.put("e_bkg_no",bkg_no_1); 
	    param.putAll(mapVO);
	    velParam.putAll(mapVO);
	    String temp = "";
	    try{        	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOGetSonyInvNoRSQL(),
					param,velParam);
			if(dbRowset != null && dbRowset.next()){
				temp = dbRowset.getString("CUST_REF_NO_CTNT");
			}			
	     return temp;
	    } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
   }

   
	/**getWallPoNbr 조회
     * @param String bkg_no    
     * @param String cntr_no   
     * @return List<String>
	 * @throws DAOException
	 */    
   public List<String> getWallPoNbr(String bkg_no,String cntr_no) throws DAOException{
	   	DBRowSet dbRowset = null;
	   	List<String> list =  new ArrayList<String>();
		 // query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		String bkg_no_1          = bkg_no;
		String cntr_no_2         = cntr_no;
	
	    /*파라미터 입력*/ 	
		 Map<String, String> mapVO = new HashMap();
			                 mapVO.put("e_bkg_no" ,bkg_no_1 ); 
			                 mapVO.put("e_cntr_no",cntr_no_2); 
	    param.putAll(mapVO);
	    velParam.putAll(mapVO);
	    try{        	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOGetWallPoNbrRSQL(),
					param,velParam);
			while(dbRowset.next()){
				 list.add(dbRowset.getString("WAL_PO_NBR"));
			}//while
	      return list;
	    } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
   }

   
   
   
	/**getBkgEDIHPRef 조회
     * @param String bkg_no    
     * @return DBRowSet
	 * @throws DAOException
	 */      
   public DBRowSet getBkgEDIHPRef(String bkg_no) throws DAOException{
	   	DBRowSet dbRowset = null;
		 // query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		String bkg_no_1          = bkg_no;

	    /*파라미터 입력*/ 	
		 Map<String, String> mapVO = new HashMap();
			                 mapVO.put("e_bkg_no"  ,bkg_no_1); 
	    param.putAll(mapVO);
	    velParam.putAll(mapVO);
	    try{        	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOGetBkgEDIHPRefRSQL(),
					param,velParam);			
	     return dbRowset;
	    } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
   }

   
   /**
    * VE -> VDL,VDT인 경우 COP_DTL_SEQ, EVENT YARD, EVENT DT 등을 조회.
    * @param String cop_no
    * @return CurrEventDtYdVO
    * @exception DAOException
   */
   public CurrEventDtYdVO getAutoVdSend(String cop_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<CurrEventDtYdVO> list = null;
		CurrEventDtYdVO currEventDtYdVO = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();


		/* 파라미터 입력 */
		Map<String, String> mapVO = new HashMap();
		mapVO.put("cop_no", cop_no);
		param.putAll(mapVO);
		velParam.putAll(mapVO);
		
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Edi315SendDBDAOGetAutoVdSendRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,CurrEventDtYdVO.class);
			if (list != null && list.size() > 0) {
				currEventDtYdVO = list.get(0);
			}
			
			return currEventDtYdVO;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
   }
   
   /**
    * AV인 경우 POD(POD_NOD_CD.SCE_COP_HDR)와 SCE_COP_DTL에서 ACT_CD가 FIRRAD,FIWMAD 인 NOD_CD 앞 다섯자리가 다르면 FIRRAD,FIWMAD의 EVENT YARD, EVENT DT 등을 조회.
    * AVL – Should be enabled when LIBH=DP
    * AVN – Should be enabled when LIBH<>DP
    * @param String org_sts_cd
    * @param String org_event_yd
    * @param String org_event_dt
    * @param String bkg_no
    * @param String cop_no
    * @param String edi_sts_cd
    * @return Edi315CurrInfoVO
    * @exception DAOException
   */
   public Edi315CurrInfoVO getAVEventDtYard(String org_sts_cd, String org_event_yd, String org_event_dt, String bkg_no, String cop_no, String edi_sts_cd) throws DAOException {
		DBRowSet dbRowset = null;
		List<Edi315CurrInfoVO> list = null;
		Edi315CurrInfoVO currInfoVO = null;
		Map<String, Object> param = new HashMap<String, Object>();

		Map<String, String> mapVO = new HashMap();
		mapVO.put("org_sts_cd", org_sts_cd);
		mapVO.put("org_event_yd", org_event_yd);
		mapVO.put("org_event_dt", org_event_dt);
		mapVO.put("bkg_no", bkg_no);
		mapVO.put("cop_no", cop_no);
		mapVO.put("edi_sts_cd", edi_sts_cd);
		param.putAll(mapVO);
		
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Edi315SendDBDAOGetAVEventDtYardRSQL(), param, param);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,Edi315CurrInfoVO.class);
			if (list != null && list.size() > 0) {
				currInfoVO = list.get(0);
			}
			
			return currInfoVO;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
   }
   
   /**
    * AG인 경우 
    * DLV Term 이 'Y' 이면 MAX(FI%%DO) 직전 Sequence의 EVENT YARD, EVENT DT 등을 조회.
    * DLV Term 이 'D' 이면 MAX(FI%%DO)  Sequence의 EVENT YARD, EVENT DT 등을 조회.
    * DLV Term은 BKG_BOOKING의 DE_TERM_CD 으로 비교.
    * 
    * @param String cop_no
    * @return Edi315CurrInfoVO
    * @exception DAOException
   */
   public Edi315CurrInfoVO getAGEventDtYard(String cop_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<Edi315CurrInfoVO> list = null;
		Edi315CurrInfoVO currInfoVO = null;
		Map<String, Object> param = new HashMap<String, Object>();

		Map<String, String> mapVO = new HashMap();
		mapVO.put("cop_no", cop_no);
		param.putAll(mapVO);
		
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Edi315SendDBDAOGetAGEventDtYardRSQL(), param, param);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,Edi315CurrInfoVO.class);
			if (list != null && list.size() > 0) {
				currInfoVO = list.get(0);
			}
			
			return currInfoVO;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
   }

   

   /**
    * 발송 Status에 해당 하는 Event Date, Event Yard, sce_dtl_seq 등을 조회.
    * @param String event_yard
    * @param String cop_no
    * @param String edi_sts
    * @return CurrEventDtYdVO
    * @exception DAOException
   */
   public CurrEventDtYdVO getCurrInfoVoWithIsCurrCopDtl(String event_yard, String cop_no, String edi_sts) throws DAOException {
		DBRowSet dbRowset = null;
		List<CurrEventDtYdVO> list = null;
		CurrEventDtYdVO currEventDtYdVO = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		String event_yard_1 = event_yard;
		String cop_no_2 = cop_no;
		String edi_sts_3 = edi_sts;

		/* 파라미터 입력 */
		Map<String, String> mapVO = new HashMap();
		mapVO.put("e_event_yard", event_yard_1);
		mapVO.put("e_cop_no", cop_no_2);
		mapVO.put("e_edi_sts", edi_sts_3);
		param.putAll(mapVO);
		velParam.putAll(mapVO);
		
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Edi315SendDBDAOSearchIsCurrCopDtlRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,CurrEventDtYdVO.class);
			if (list != null && list.size() > 0) {
				currEventDtYdVO = list.get(0);
				log.debug(" \n dao. currEventDtYdVO.toString() : "+currEventDtYdVO.toString());
			}
			
			return currEventDtYdVO;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
   }
   
   
   /**
    * getObRlyPortInfo
    * @param String bkg_no
    * @return RlyPortVO
    * @exception DAOException
   */
   public RlyPortVO getObRlyPortInfo(String bkg_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<RlyPortVO> list = null;
		RlyPortVO rlyPortVO = new RlyPortVO();
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();


		/* 파라미터 입력 */
		Map<String, String> mapVO = new HashMap();
		mapVO.put("bkg_no", bkg_no);
		param.putAll(mapVO);

		
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOGetObRlyPortInfoRSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,RlyPortVO.class);
			if (list != null && list.size() > 0) {
				rlyPortVO = list.get(0);
			}
			return rlyPortVO;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
   }
   

   /**
    * getIbRlyPortInfo
    * @param String bkg_no
    * @return RlyPortVO
    * @exception DAOException
   */
   public RlyPortVO getIbRlyPortInfo(String bkg_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<RlyPortVO> list = null;
		RlyPortVO rlyPortVO = new RlyPortVO();
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();


		/* 파라미터 입력 */
		Map<String, String> mapVO = new HashMap();
		mapVO.put("bkg_no", bkg_no);
		param.putAll(mapVO);

		
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOGetIbRlyPortInfoRSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,RlyPortVO.class);
			if (list != null && list.size() > 0) {
				rlyPortVO = list.get(0);
			}
			return rlyPortVO;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
   }

   /**
    * getOcRlyPortInfo
    * @param String edi_sts
    * @param String cop_no
    * @param String dtl_seq
    * @param String org_yd_cd
    * @return RlyPortVO
    * @exception DAOException
   */
   public RlyPortVO getOcRlyPortInfo(String edi_sts, String cop_no, String dtl_seq, String org_yd_cd) throws DAOException {
		DBRowSet dbRowset = null;
		List<RlyPortVO> list = null;
		RlyPortVO rlyPortVO = new RlyPortVO();
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();


		/* 파라미터 입력 */
		Map<String, String> mapVO = new HashMap();
		mapVO.put("cop_no", cop_no);
		mapVO.put("dtl_seq", dtl_seq);
		mapVO.put("edi_sts", edi_sts);
		mapVO.put("org_yd_cd", org_yd_cd);
		param.putAll(mapVO);

		
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOGetOcRlyPortInfoRSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,RlyPortVO.class);
			if (list != null && list.size() > 0) {
				rlyPortVO = list.get(0);
			}
			return rlyPortVO;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
   }
   
   
   /**
    * searchCntrWeightInfo
    * @param String bkg_no
    * @param String cntr_no
    * @return cntr_no
    * @exception DAOException
   */
   public SearchCntrWeightInfoVO searchCntrWeightInfo(String bkg_no, 
		                                             String cntr_no) throws DAOException{
	   	DBRowSet dbRowset                 = null;
	   	List<SearchCntrWeightInfoVO> list       = null;
	   	SearchCntrWeightInfoVO searchCntrWeightInfoVO = null; 
		
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();		


		Map<String, String> mapVO = new HashMap();
			                mapVO.put("bkg_no" ,bkg_no);
			                mapVO.put("cntr_no",cntr_no);
			                 
	    param.putAll(mapVO);
	    velParam.putAll(mapVO);

	    try{        	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOSearchCntrWeightInfoRSQL(),
					param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,SearchCntrWeightInfoVO.class);
			if(list != null && list.size() >0){
				searchCntrWeightInfoVO = list.get(0);
			}
			
	     return searchCntrWeightInfoVO;
	    } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}



   
   /**
    * 발송 Status 에 해당 하는 Current VVD 정보를 가져옴.
    * @param String event_yard
    * @param String cop_no
    * @param String edi_sts
    * @return CurrVvdVO
    * @exception DAOException
   */
   public CurrVvdVO getCurrVvdInfo(String event_yard, String cop_no, String edi_sts) throws DAOException {
	   DBRowSet dbRowset = null;
	   List<CurrVvdVO> list = null;
	   CurrVvdVO currVvdVO = null;

		
	   Map<String, Object> param = new HashMap<String, Object>();
	   Map<String, Object> velParam = new HashMap<String, Object>();


		/* 파라미터 입력 */
	   Map<String, String> mapVO = new HashMap();
	   mapVO.put("org_nod", event_yard);
	   mapVO.put("cop_no" , cop_no);
	   mapVO.put("edi_sts", edi_sts);
	   param.putAll(mapVO);
	   velParam.putAll(mapVO);
	   
	   try {
		   dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Edi315SendDBDAOSearchCurrVvdRSQL(),param, velParam);
		   list = (List) RowSetUtil.rowSetToVOs(dbRowset,CurrVvdVO.class);
			
		   if (list != null && list.size() > 0) {
			   currVvdVO = list.get(0);
			   }
		   return currVvdVO;
		   
		}catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
   }


		
		
	/**getCustAdateNewVersion 조회
     * @param String event_yard   
	 * @param String bl_no  
     * @return DBRowSet
	 * @throws DAOException
	 */      
	public DBRowSet getCustAdateNewVersion(String event_yard,String bl_no) throws DAOException{
	   	DBRowSet dbRowset                 = null;
	   	
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		String event_yard_1       = event_yard;
		String bl_no_2            = bl_no;

	    /*파라미터 입력*/ 	
		 Map<String, String> mapVO = new HashMap();
			                 mapVO.put("e_event_yard",event_yard_1);
			                 mapVO.put("e_bl_no"     ,bl_no_2     );
	    param.putAll(mapVO);
	    velParam.putAll(mapVO);
	    try{        	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOGetCustAdateRSQL(),
					param,velParam);	
	     return dbRowset;
	    } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**getItNoTemp 조회 
	 * @param String bl_no   
     * @param String curr_evnet_yd   
     * @return String
	 * @throws DAOException
	 */   
   public String getItNoTemp(String bl_no, String curr_evnet_yd) throws DAOException{
	   	DBRowSet dbRowset = null;

		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();		
	
		 Map<String, String> mapVO = new HashMap();
			                 mapVO.put("bl_no"        ,bl_no);  
			                 mapVO.put("curr_evnet_yd",curr_evnet_yd);  
	    param.putAll(mapVO);
	    velParam.putAll(mapVO);
	    String temp = "";
	    try{        	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOGetItNoTempRSQL(),
					param,velParam);
			if(dbRowset != null && dbRowset.next()){
				temp = dbRowset.getString("IT_NO_TEMP");
			}		
			
	     return temp;
	    } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
   }

   


   /**
    * SCE_EDI_HIS 테이블의 Key Return.
    * @return DBRowSet
    * @throws DAOException
    */        
   public DBRowSet searchKeysForAddSceEdiHis() throws DAOException{
	   	DBRowSet dbRowset = null;
	    try{        	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOSearchKeysForAddSceEdiHisRSQL(),
					null,null);		
	     return dbRowset;
	    } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}  
   }

  /**get322PickupNo 조회
   * @param String curr_event_dt 
   * @param String cntr_no    
   * @return String
   * @throws DAOException
   */     
  public String get322PickupNo(String curr_event_dt,String cntr_no) throws DAOException{
  	DBRowSet dbRowset = null;
	 // query parameter
	Map<String, Object> param = new HashMap<String, Object>();
	// velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();		
	
	String curr_event_dt_1   = curr_event_dt ;
	String cntr_no_2         = cntr_no;
	
	  Map<String, String> mapVO = new HashMap();
		        mapVO.put("e_curr_event_dt" ,curr_event_dt_1); 
		        mapVO.put("e_cntr_no"       ,cntr_no_2      );       

     param   .putAll(mapVO);
     velParam.putAll(mapVO);	
    try{        	
		dbRowset = new SQLExecuter("").executeQuery(
				(ISQLTemplate) new Edi315SendDBDAOGet322PickupNoRSQL(),
				param,velParam);
		
		String temp = null;
		if(dbRowset.next()) {
			temp = dbRowset.getString("PICK_NO");
			return temp;
    	}
		return null;
    } catch (SQLException se) {
		log.error(se.getMessage(), se);
		throw new DAOException(new ErrorHandler(se).getMessage());
	} catch (Exception ex) {
		log.error(ex.getMessage(), ex);
		throw new DAOException(new ErrorHandler(ex).getMessage());
	}
  }
  /**getVipSndCount 조회
   * @param	String edi_grp_cd  
   * @param	String edi_sts  
   * @param	String cust_edi_sts_cd  
   * @param	String bkg_no  
   * @param	String cntr_no  
   * @param	String po_no	 
   * @return String
   * @throws DAOException
   */      
  public String getVipSndCount(
						    String edi_grp_cd,
						    String edi_sts,
						    String cust_edi_sts_cd,
						    String bkg_no,
						    String cntr_no,
						    String po_no	  
                           ) throws DAOException{
	  	DBRowSet dbRowset = null;
		 // query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		String edi_grp_cd_1      = edi_grp_cd ;
		String edi_sts_2         = edi_sts;
		String cust_edi_sts_cd_3 = cust_edi_sts_cd ;
		String bkg_no_4          = bkg_no;
		String cntr_no_5         = cntr_no ;
		String po_no_6     = po_no;

	    Map<String, String> mapVO = new HashMap();
					        mapVO.put("e_edi_grp_cd"      ,edi_grp_cd_1     ); 
					        mapVO.put("e_edi_sts"         ,edi_sts_2        ); 
					        mapVO.put("e_cust_edi_sts_cd" ,cust_edi_sts_cd_3); 
					        mapVO.put("e_bkg_no"          ,bkg_no_4         ); 
					        mapVO.put("e_cntr_no"         ,cntr_no_5        ); 
					        mapVO.put("e_po_no"    		  ,po_no_6    ); 

	       param   .putAll(mapVO);
	       velParam.putAll(mapVO);	
	    try{        	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOGetVipSndCountRSQL(),
					param,velParam);
			
			String temp = "0";
			if(dbRowset.next()) {
				temp = dbRowset.getString("VIP_SND_CNT");
				return temp;
	    	}
			return "0";
	    } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}	  
  }


  /**searchIsCargoSmart 조회
   * @param String edi_grp_cd  
   * @param String bkg_no  
   * @return String
   * @throws DAOException
   */      
  public String searchIsCargoSmart(String edi_grp_cd,String bkg_no) throws DAOException{
	  	DBRowSet dbRowset = null;
		 // query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		String edi_grp_cd_1      = edi_grp_cd ;
		String bkg_no_2          = bkg_no;

	    Map<String, String> mapVO = new HashMap();
					        mapVO.put("e_edi_grp_cd" ,edi_grp_cd_1 ); 
					        mapVO.put("e_bkg_no"     ,bkg_no_2     ); 

	       param   .putAll(mapVO);
	       velParam.putAll(mapVO);	
	    try{        	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOSearchIsCargoSmartRSQL(),
					param,velParam);
			
			String temp = "";
			if(dbRowset.next()) {
				temp = dbRowset.getString("V_BLOCKED");
				return temp;
	    	}
	    } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return "";
  }
  
  /**
   * Booking 의 315 발송 대상 화주 조회.
   * @param bkg_no - String
   * @return String
   * @throws DAOException
   */   
  public String searchEdiGrpCd(String bkg_no) throws DAOException{
	  	DBRowSet dbRowset = null;
		 // query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		


	    Map<String, String> mapVO = new HashMap();
					        mapVO.put("bkg_no"    ,bkg_no    ); 				        
	       param   .putAll(mapVO);
	       velParam.putAll(mapVO);	
	    try{        	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOSearchEdiGrpCdRSQL(),
					param,velParam);
			
			String temp = "NoDataCust!!";
			if(dbRowset != null && dbRowset.next()) {
				temp = dbRowset.getString("EDI_GRP_CD");
	    	}
			return temp;
	    } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
  }  
  
  
  
  /**searchFindMtEdiSndRslt 조회
   * @param String edi_grp_cd  
   * @param String bkg_no  
   * @param String cntr_no  
   * @return String
   * @throws DAOException
   */   
  public String searchFindMtEdiSndRslt(String edi_grp_cd,
		                               String bkg_no,
		                               String cntr_no
                                       ) throws DAOException{
	  	DBRowSet dbRowset = null;
		 // query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		String edi_grp_cd_1      = edi_grp_cd ;
		String bkg_no_2          = bkg_no;
		String cntr_no_3         = cntr_no;

	    Map<String, String> mapVO = new HashMap();
					        mapVO.put("e_edi_grp_cd",edi_grp_cd_1); 
					        mapVO.put("e_bkg_no"    ,bkg_no_2    ); 
					        mapVO.put("e_cntr_no"   ,cntr_no_3   ); 					        
	       param   .putAll(mapVO);
	       velParam.putAll(mapVO);	
	    try{        	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOSearchFindMtEdiSndRsltRSQL(),
					param,velParam);
			
			String temp = "";
			if(dbRowset.next()) {
				temp = dbRowset.getString("CNT");
				return temp;
	    	}
	    } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return "";
  }  
  
  /**searchFindEdiSndRslt 조회
   * @param String edi_grp_cd
   * @param String eid_sts_cd
   * @param String eid_sub_sts_cd
   * @param String bkg_no
   * @param String cntr_no  
   * @return int
   * @throws DAOException
   */   
  public int searchFindEdiSndRslt(String edi_grp_cd, String eid_sts_cd, String eid_sub_sts_cd, String bkg_no, String cntr_no) throws DAOException {
	  	DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String edi_grp_cd_1      = edi_grp_cd;
		String eid_sts_cd_1      = eid_sts_cd;
		String eid_sub_sts_cd_1  = eid_sub_sts_cd;
		String bkg_no_2          = bkg_no;
		String cntr_no_3         = cntr_no;

	    Map<String, String> mapVO = new HashMap();
					        mapVO.put("e_edi_grp_cd"    ,edi_grp_cd_1);
					        mapVO.put("e_edi_sts_cd"    ,eid_sts_cd_1);
					        mapVO.put("e_edi_sub_sts_cd",eid_sub_sts_cd_1);
					        mapVO.put("e_bkg_no"        ,bkg_no_2    );
					        mapVO.put("e_cntr_no"       ,cntr_no_3   );
        param   .putAll(mapVO);
        velParam.putAll(mapVO);	
	    try{
			int temp = 0;
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Edi315SendDBDAOSearchFindEdiSndRsltRSQL(), param, velParam);			
			if(dbRowset.next()) {
				temp = dbRowset.getInt("CNT");
				return temp;
	    	}
	    } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return 0;
  }
  
  /**getBaseNos 조회
   * EDI 는 여러 모듈에서 Call 하기 때문에 경우에 따라 bkg_no, bl_no, cop_no, cntr_no 등의 정보가 부족 할 수 있어서
   * 기본 적인 정보를 Setting 해주는 Method.
   * @param String bkg_no   
   * @param String cntr_no  
   * @param String bl_no    
   * @param String cop_no   
   * @return DBRowSet
   * @throws DAOException
   */   
  public DBRowSet getBaseNos(String bkg_no,String cntr_no,String bl_no,String cop_no) throws DAOException{
	   	 DBRowSet dbRowset = null;
	     try{        
				 // query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				// velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();		
				String bkg_no_1      = bkg_no ;
				String cntr_no_2     = cntr_no;
				String bl_no_3       = bl_no;
				String cop_no_4       = cop_no;
	
			    Map<String, String> mapVO = new HashMap();
							        mapVO.put("e_bkg_no" ,bkg_no_1 ); 
							        mapVO.put("e_cntr_no",cntr_no_2); 
							        mapVO.put("e_bl_no"  ,bl_no_3  ); 	
							        mapVO.put("e_cop_no"  ,cop_no_4  ); 
			       param   .putAll(mapVO);
			       velParam.putAll(mapVO);	
			       
				   dbRowset = new SQLExecuter("").executeQuery(
						     (ISQLTemplate) new Edi315SendDBDAOGetBaseNosRSQL(),
						      param,velParam);		
		     return dbRowset;
		 } catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
		 }  
   }
  /**getOA_value
   * @param String cop_no   
   * @return String
   * @throws DAOException
   */   
  public String getOA_value(String cop_no) throws DAOException {
		DBRowSet dbRowset = null;
		String temp = "";
		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			Map<String, String> mapVO = new HashMap();
			mapVO.put("e_cop_no", cop_no);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOGetOAStatusRSQL(), param,
					velParam);
			
			if (dbRowset.next()) {
				temp = dbRowset.getString(1);
			}
			return temp;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

 
  /**
   * getVADActualMappingInfo
   * @param String cop_no
   * @return SceCopDtlVO
   * @throws DAOException 
   */
  public SceCopDtlVO getVADActualMappingInfo(String cop_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<SceCopDtlVO> list = null;
		SceCopDtlVO retValue = null;
		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			Map<String, String> mapVO = new HashMap();
			mapVO.put("e_cop_no", cop_no);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOGetVADActualMappingInfoRSQL(), param,
					velParam);
			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,SceCopDtlVO.class);
			if(list != null && list.size() > 0){
				retValue = (SceCopDtlVO)list.get(0);
			}
			return retValue;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
  /**
   * POD, DEL, T/S되는 PORT, 2ND VVD가 없는 건인지 확인
   * @param Edi315SendOptionsVO optVo
   * @return SceCopDtlVO
   * @throws DAOException 
   */
  public SceCopDtlVO searchICtoVADsendValidation(Edi315SendOptionsVO optVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SceCopDtlVO> list = null;
		SceCopDtlVO retValue = null;
		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			
			param.putAll(optVo.getColumnValues());

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOSearchICtoVADsendValidationRSQL(), param,
					velParam);
			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,SceCopDtlVO.class);
			if(list != null && list.size() > 0){
				retValue = (SceCopDtlVO)list.get(0);
			}
			return retValue;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}    
  /**
   * POD, DEL, T/S되는 PORT, 2ND VVD가 없는 건인지 확인
   * @param Edi315DetailVO dtlVo
   * @return boolean
   * @throws DAOException 
   */
  public boolean modifySceEdiSndRslt(Edi315DetailVO dtlVo) throws DAOException {

		
//		SceCopDtlVO retValue = null;
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			Map<String, String> mapVO = new HashMap();
//			param.putAll(dtlVo.getColumnValues());
			mapVO.put("trunk_vvd", dtlVo.getTrunkVvd());
			mapVO.put("edi_grp_cd", dtlVo.getEdiGrpCd());
			mapVO.put("bkg_no", dtlVo.getBkgNo());
			mapVO.put("cntr_no", dtlVo.getCntrNo());
		    if (mapVO != null) {
		    	param.putAll(mapVO);
				velParam.putAll(mapVO);		
   			}
		    //int insCnt = 0;
		    new SQLExecuter("").executeUpdate((ISQLTemplate)new Edi315SendDBDAOModifySceEdiSndRsltRSQL(), param, velParam);
				
			return true;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

  /**
   * POD에서의 OAN 발송 건수 조회
   * @param String edi_grp_cd
   * @param String bkg_no
   * @param String cntr_no
   * @param String chk_sts
   * @param String sub_sts_cd
   * @return int
   * @throws DAOException 
   */
  public int searchPodOanCnt( String edi_grp_cd, String bkg_no, String cntr_no, String chk_sts, String sub_sts_cd) throws DAOException {
		DBRowSet dbRowset = null;
		int cnt = -1;
//		SceCopDtlVO retValue = null;
		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
	
		    /*파라미터 입력*/ 	
			  Map<String, String> mapVO = new HashMap();
				                  mapVO.put("edi_group_cd",edi_grp_cd); 
				                  mapVO.put("bkg_no",bkg_no); 
				                  mapVO.put("cntr_no",cntr_no); 
				                  mapVO.put("chk_sts",chk_sts);              
				                  mapVO.put("sub_sts_cd",sub_sts_cd); 
				                  
		    if (mapVO != null) {
				    			 param.putAll(mapVO);
				    			 velParam.putAll(mapVO);		
				    			}
		    

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOGetPodOanCntRSQL(), param,
					velParam);
			
			while(dbRowset.next()){
				cnt = dbRowset.getInt("oan_cnt");
			}
			return cnt;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}    
  	

	 
  /**
   * SCE_FLT_FILE_MSG 테이블의 PK 조회
   * @return SceFltFileMsgVO
   * @throws DAOException
   */
  public SceFltFileMsgVO searchEdi315FlatFileKey( ) throws DAOException {
		DBRowSet dbRowset = null;
//		int cnt = -1;
		SceFltFileMsgVO retValue = null;
		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
	


			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOSearchEdi315FlatFileKeyRSQL(), param,
					velParam);
			
			retValue = new SceFltFileMsgVO();
			while(dbRowset.next()){
				retValue.setEdiSndDt(dbRowset.getString("edi_snd_dt"));
				retValue.setEdiSndHr(dbRowset.getString("edi_snd_hr"));				
				retValue.setEdiSndSeq(dbRowset.getString("edi_snd_seq"));				
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retValue;
	}      
	/**
	 * sce_flt_file_msg_dtl_vsl 테이블에 vessel정보 등록
	 * @param SceFltFileMsgDtlVslVO ffMsgVo
	 * @return String
	 * @throws DAOException
	 */
	public String addSceFltFileMsgDtl(SceFltFileMsgDtlVslVO ffMsgVo)throws DAOException {
		String resultFlag = "N";
		//int rowCnt = 0;
		try {


			Map<String, String> valParam = new HashMap<String, String>();
			Map<String, String> param = new HashMap<String, String>();
			param.putAll(ffMsgVo.getColumnValues());
			param.putAll(ffMsgVo.getColumnValues());

			new SQLExecuter("").executeUpdate((ISQLTemplate) new Edi315SendDBDAOAddSceFltFileMsgDtlVslCSQL(),param, valParam);
			resultFlag = "Y";
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(
					"Inserting into SCE_FLT_FILE_MSG_DTL_VSL:", new String[] {})
					.getMessage());
		}
		return resultFlag;
	}
	
   /**
	* Booking이 Memo Split인지, Origin Booking 정보가 무엇인지 조회
	* @param bkgNo
    * @return DBRowSet
    * @throws DAOException
    * @since 2010.09.07 김진승 [CHM-201005667-01] Memo BL 315 전송 로직 변경 요청
    */        
   public DBRowSet searchOriginBookingInformation(String bkgNo) throws DAOException{
	   	DBRowSet dbRowset = null;
	    try{        	
	    	HashMap hashMap = new HashMap();
	    	hashMap.put("bkg_no", bkgNo);
	    	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Edi315SendDBDAOSearchOriginBookingInformationRSQL(), hashMap, null);		
	     return dbRowset;
	    } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}  
   }

	/** getAVNValidationCount 조회<br>
	 * 2010.09.30 김진승 [CHM-201006003-01] AVN 전송 Error Logic 보완<br>
	 * @param Edi315DetailVO dtlVo
	 * @return int
	 * @throws DAOException
	 */
   public int getAVNValidationCount(Edi315DetailVO dtlVo) throws DAOException {
		DBRowSet dbRowset = null;

		try {
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			Map<String, String> mapVO = dtlVo.getColumnValues();

			if (mapVO != null) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Edi315SendDBDAOGetAVNValidationCountRSQL(),param, velParam);

			int temp = 0;
			if(dbRowset.next()) {
				temp = dbRowset.getInt(1);
				return temp;
			}
			return -1;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

   /**
	 * Adidas 관련 FLAT FILE에 BL_CRT_DT, BKG_CRT_DT, BKG_CFM_DT 항목 조회
	 * 
	 * @param bkgNo
	 * @return DBRowSet
	 * @throws DAOException
	 * @since 2010.10.13 김진승 [CHM-201006502-01] Adidas 관련 FLAT FILE에 BL_CRT_DT,
	 *        BKG_CRT_DT, BKG_CFM_DT 항목 추가
	 */        
  public DBRowSet searchAdidasBlBkgDate(String bkgNo) throws DAOException{
	   	DBRowSet dbRowset = null;
	    try{        	
	    	HashMap hashMap = new HashMap();
	    	hashMap.put("bkg_no", bkgNo);
	    	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Edi315SendDBDAOSearchAdidasBlBkgDateRSQL(), hashMap, null);		
	     return dbRowset;
	    } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}  
  }

   /**
	* Customer Trade Partner ID가 '6111470101'일 경우에 대한 EDI Flat File에 처리할 Multi Booking No., BL No. 조회
    * @param String bkgNo
    * @param String cntrNo
    * @return DBRowSet dbRowset
    * @throws DAOException
	* @since 2010.10.26
    */
	public DBRowSet searchPrtlBkgsForEdiGrp(String bkgNo, String cntrNo) throws DAOException {
	   	DBRowSet dbRowset = null;
	    try{        	
	    	HashMap hashMap = new HashMap();
	    	hashMap.put("bkg_no", bkgNo);
	    	hashMap.put("cntr_no", cntrNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Edi315SendDBDAOSearchPrtlBkgsForEdiGrpRSQL(), hashMap, hashMap);
			
	    } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}  
	     return dbRowset;
	}
	
	/** uvdConvEdiSndRslt 조회
	 * UVD_CONV_EDI_SND_RSLT
     * @param dtlVo Edi315DetailVO   
     * @return int
	 * @throws DAOException
	 */ 	
    public int searchEdiStsForPrtlBkg(Edi315DetailVO dtlVo)throws DAOException{
	       DBRowSet dbRowset = null;
			try{        	
				 // query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				// velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();				
		
			    /*파라미터 입력*/ 	
				  Map<String, String> mapVO = new HashMap();
					                  mapVO.put("v_edi_grp_cd",dtlVo.getEdiGrpCd());
					                  mapVO.put("v_bkg_no",dtlVo.getBkgNo()); 
					                  mapVO.put("v_cntr_no",dtlVo.getCntrNo());             
		    	
			    if (mapVO != null) {
					    			 param.putAll(mapVO);
					    			 velParam.putAll(mapVO);		
					    			}			
			  dbRowset = new SQLExecuter("").executeQuery(
		       (ISQLTemplate) new Edi315SendDBDAOSearchEdiStsForPrtlBkgRSQL(),
		       param,velParam);
			
				int resultCnt = 0;
				if(dbRowset.next()) {
					resultCnt = dbRowset.getInt(1);
				}
			    return resultCnt;
			} catch (SQLException se) {
			  log.error(se.getMessage(), se);
			  throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
			  log.error(ex.getMessage(), ex);
			  throw new DAOException(new ErrorHandler(ex).getMessage());
			}    	
    }
 	
    /**
     * searchCopVadChk 조회<br>
     * 2014.11.27 김인규
     * 
     * @param vsl_cd String
     * @param skd_dir_cd String
     * @param skd_voy_no String
     * @param vps_port_cd String
     * @return DBRowSet
     * @throws DAOException
     */
    public DBRowSet searchCssmVoyNo(String vsl_cd , 
    		                String skd_dir_cd , 
    		                String skd_voy_no ,
    		                String vps_port_cd) throws DAOException{
	       DBRowSet dbRowset = null;
			try {
				HashMap hashMap = new HashMap();
		    	
		    	hashMap.put("vsl_cd", vsl_cd);
		    	hashMap.put("skd_dir_cd", skd_dir_cd);
		    	hashMap.put("skd_voy_no", skd_voy_no);
		    	hashMap.put("vps_port_cd", vps_port_cd);

		    	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Edi315SendDBDAOSearchCssmVoyNoRSQL(), hashMap, null);		
		    	return dbRowset;
		    } catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}  
	   }
    
	/**getCustRefNoCtnt 조회
     * @param  String bkg_no  
     * @param  String bkg_ref_tp_cd
     * @return String
	 * @throws DAOException
	 * @since  2014.11.27 김인규
	 */ 
    public String getCustRefNoCtnt(String bkg_no, String bkg_ref_tp_cd) throws DAOException{
    	DBRowSet dbRowset = null;
		 // query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
	     /*파라미터 입력*/ 	
		 Map<String, String> mapVO = new HashMap();
			                 mapVO.put("bkg_no",bkg_no); 
			                 mapVO.put("bkg_ref_tp_cd",bkg_ref_tp_cd); 
	     param.putAll(mapVO);
	     velParam.putAll(mapVO);
	     String temp = "";
      try{        	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOGetCustRefNoRSQL(),
					param,velParam);
			if(dbRowset != null && dbRowset.next()){
				temp = dbRowset.getString("CUST_REF_NO_CTNT");
			}
          return temp;
      } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}     	
   }    
    
    /**
 	* HBL NO MULTI 조회 nyk new item
     * @param bkgNo 
     * @return DBRowSet
     * @throws DAOException
     * @since 2014.11.27 igkim 
     */
 	public DBRowSet searchBkgHblNo(String bkgNo) throws DAOException {
 	   	DBRowSet dbRowset = null;
 	    try{        	
 	    	HashMap hashMap = new HashMap();
 	    	hashMap.put("bkg_no", bkgNo);
 	    	
 			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Edi315SendDBDAOSearchBkgHblNoRSQL(), hashMap, null);
 			
 	    } catch (SQLException se) {
 			log.error(se.getMessage(), se);
 			throw new DAOException(new ErrorHandler(se).getMessage());
 		} catch (Exception ex) {
 			log.error(ex.getMessage(), ex);
 			throw new DAOException(new ErrorHandler(ex).getMessage());
 		}  
 	     return dbRowset;
 	}    
 	
    /**
 	*  Multi  CNTR_SEAL_NO, SEAL_PTY_TP_CD  조회 
     * @param bkgNo
     * @param cntrNo
     * @return DBRowSet
     * @throws DAOException
 	 * @since 2014.11.28 igkim
     */
 	public DBRowSet searchCntrSealNo(String bkgNo, String cntrNo) throws DAOException {
 	   	DBRowSet dbRowset = null;
 	    try{        	
 	    	HashMap hashMap = new HashMap();
 	    	hashMap.put("bkg_no", bkgNo);
 	    	hashMap.put("cntr_no", cntrNo);

 	    	//HashMap velocityParam = null; //2015.04.14 Modify Critical
 	    	HashMap velocityParam = new HashMap(); 
 			
 			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Edi315SendDBDAOSearchCntrSealNoRSQL(), hashMap, velocityParam);
 			
 	    } catch (SQLException se) {
 			log.error(se.getMessage(), se);
 			throw new DAOException(new ErrorHandler(se).getMessage());
 		} catch (Exception ex) {
 			log.error(ex.getMessage(), ex);
 			throw new DAOException(new ErrorHandler(ex).getMessage());
 		}  
 	     return dbRowset;
 	} 	
 	
	/**getBkgEDICustInfo 조회
     * @param String bkg_no    
     * @return DBRowSet
	 * @throws DAOException
	 * @since 20141201 igkim add
	 */      
   public DBRowSet getBkgEDICustInfo(String bkg_no) throws DAOException{
	   	DBRowSet dbRowset = null;
		 // query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		String bkg_no_1          = bkg_no;

	    /*파라미터 입력*/ 	
		 Map<String, String> mapVO = new HashMap();
			                 mapVO.put("e_bkg_no"  ,bkg_no_1); 
	    param.putAll(mapVO);
	    velParam.putAll(mapVO);
	    try{        	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOGetBkgEDICustInfoRSQL(),
					param,velParam);			
	     return dbRowset;
	    } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
   } 	
   
	/**getBkgEDIBkgInfo 조회
    * @param String bkg_no    
    * @return DBRowSet
	 * @throws DAOException
	 * @since 20141201 igkim add
	 */      
  public DBRowSet getBkgEDIBkgInfo(String bkg_no) throws DAOException{
	   	DBRowSet dbRowset = null;
		 // query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		String bkg_no_1          = bkg_no;

	    /*파라미터 입력*/ 	
		 Map<String, String> mapVO = new HashMap();
			                 mapVO.put("e_bkg_no"  ,bkg_no_1); 
	    param.putAll(mapVO);
	    velParam.putAll(mapVO);
	    try{        	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOGetBkgEDIBkgInfoRSQL(),
					param,velParam);			
	     return dbRowset;
	    } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
  }
  
  /**
   * Multi  trans info  조회 
   * @param bkgNo String
   * @param cntrNo String
   * @param copNo String
   * @param transTpCd String
   * @param ediStsCd String
   * @param eventYardCd String
   * @param vvd String
   * @param nodCd String
   * @param copDtlSeq String
   * @return DBRowSet
   * @throws DAOException
   */
  public DBRowSet searchTransInfo(String bkgNo, String cntrNo,String copNo,String transTpCd, String ediStsCd, String eventYardCd, String vvd, String nodCd, String copDtlSeq) throws DAOException {
	   	DBRowSet dbRowset = null;
	    try{        	
	    	HashMap hashMap = new HashMap();
	    	hashMap.put("bkg_no", bkgNo);
	    	hashMap.put("cntr_no", cntrNo);
	    	hashMap.put("cop_no", copNo);
	    	hashMap.put("trans_tp_cd", transTpCd);
	    	hashMap.put("edi_sts_cd", ediStsCd);
	    	hashMap.put("event_yard_cd", eventYardCd);
	    	hashMap.put("vvd", vvd);
	    	hashMap.put("nod_cd", nodCd);
	    	hashMap.put("cop_dtl_seq", copDtlSeq);

	    	HashMap velocityParam  = new HashMap();
	    	
	    	velocityParam.put("trans_tp_cd", transTpCd);
	 //   	velocityParam.put("loc_tp_cd", locTpCd);
	    	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Edi315SendDBDAOSearchTransInfoRSQL(), hashMap, velocityParam);
			
	    } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}  
	     return dbRowset;
	}
	/**
	 * searchLocationInfo
	 * @param bkgNo String
	 * @param copNo String
	 * @param transTpCd String
	 * @param locTpCd String
	 * @param locYdCd String
	 * @param copDtlSeq String
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchLocationInfo(String bkgNo, String copNo,String transTpCd,String locTpCd, String locYdCd, String copDtlSeq) throws DAOException {
	   	DBRowSet dbRowset = null;
	    try{        	
	    	HashMap hashMap = new HashMap();
	    	hashMap.put("bkg_no", bkgNo);
	    	hashMap.put("cop_no", copNo);
	    	hashMap.put("loc_tp_cd", locTpCd);
	    	hashMap.put("loc_yd_cd", locYdCd);
	    	hashMap.put("cop_dtl_seq", copDtlSeq);
	    	
	    	HashMap velocityParam  = new HashMap();
	    	
	    	velocityParam.put("trans_tp_cd", transTpCd);
	    	velocityParam.put("loc_tp_cd", locTpCd);
	    	velocityParam.put("loc_yd_cd", locYdCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Edi315SendDBDAOSearchLocationInfoRSQL(), hashMap, velocityParam);
			
	    } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}  
	     return dbRowset;
	} 

		
    /**
     * 
     * @param bkgNo
     * @param dateTpCd
     * @param copNo
     * @param transTpCd
     * @param locTpCd
     * @param locYdCd
     * @param copDtlSeq
     * @return
     * @throws DAOException
     */
	public DBRowSet searchDateTpCdInfo(String bkgNo, String dateTpCd, String copNo,String transTpCd,String locTpCd, String locYdCd, String copDtlSeq) throws DAOException {
	   	DBRowSet dbRowset = null;
	    try{        	
	    	HashMap hashMap = new HashMap();
	    	hashMap.put("bkg_no", bkgNo);
	    	hashMap.put("date_tp_cd", dateTpCd);
	    	hashMap.put("cop_no", copNo);
	    	hashMap.put("loc_yd_cd", locYdCd);
	    	hashMap.put("cop_dtl_seq", copDtlSeq);
	    	
	    	HashMap velocityParam = new HashMap();
	    	
	    	velocityParam.put("trans_tp_cd", transTpCd);
	    	velocityParam.put("loc_tp_cd", locTpCd);
	    	velocityParam.put("date_tp_cd", dateTpCd);
	    	velocityParam.put("loc_yd_cd", locYdCd);
	    	velocityParam.put("cop_dtl_seq", copDtlSeq);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Edi315SendDBDAOSearchDateTpCdInfoRSQL(), hashMap, velocityParam);
			
	    } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}  
	     return dbRowset;
	} 

  /**
   * 
   * @param bkgNo
   * @param copNo
   * @return
   * @throws DAOException
   */
  public boolean getVslPrePstCd(String bkgNo, String copNo,String transTpCd,String locTpCd) throws DAOException{
	  	DBRowSet dbRowset = null;
	  	boolean chkVslPrePstCd = false ;
	    try{        			
	    	HashMap hashMap = new HashMap();
	    	hashMap.put("bkg_no", bkgNo);
	    	hashMap.put("cop_no", copNo);
	    	
	    	HashMap velocityParam  = new HashMap();
	    	
	    	velocityParam.put("trans_tp_cd", transTpCd);
	    	velocityParam.put("loc_tp_cd", locTpCd);
	    	
	    	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Edi315SendDBDAOSearchVslPrePstCdRSQL(),hashMap, velocityParam);
			
			if(dbRowset != null && dbRowset.next()){
				if(dbRowset.getInt(1) > 0){
					chkVslPrePstCd = true;
				}
				else{
					chkVslPrePstCd = false;
				}
		    }
	        return chkVslPrePstCd;
	    } catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}     	
	 }	

		
	
	/**getYdNm 조회
	   * @param  Edi315SendVO dtlVo
	   * @return String
	   * @throws DAOException
	   */  
	  public String getYdNm(Edi315DetailVO dtlVo) throws DAOException{
	  	DBRowSet dbRowset = null;
	  	String yd_nm = "" ;
	    try{        			
	  	  
	    	if (dtlVo != null) {
				Map<String, String> params = dtlVo.getColumnValues();
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Edi315SendDBDAOGetYdNmRSQL(),params, params);
			}
			if(dbRowset != null && dbRowset.next()){
				yd_nm = dbRowset.getString(1);
		    }
	        return yd_nm;
	    } catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}     	
	 }	

		/**
		 * 2011.08.25 이경원 [CHM-201112880-01] 삼성전자 315 Event 코드 추가 및 정의변경 FLAT FILE에 PODETB, PODETB_GMT, PODATB, PODATB_GMT 항목 추가
		 * searchCOPInfoPod
	     * @param Edi315SendOptionsVO edi315SOpts
	     * @return Edi315PrefixMainCOPInfoVO
	     * @throws DAOException
	     */ 
	    public Edi315PrefixMainCOPInfoVO searchPodEtbAtbDate(Edi315SendOptionsVO edi315SOpts) throws DAOException {
	     	DBRowSet dbRowset = null;
	     	List<Edi315PrefixMainCOPInfoVO> list = null;
			Edi315PrefixMainCOPInfoVO vo = null;
			
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();
	        try {
	        	if (edi315SOpts != null) {
					Map<String, String> mapVO = edi315SOpts.getColumnValues();
					// query parameter
					param.putAll(mapVO);
					// velocity parameter
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery(
						(ISQLTemplate) new Edi315SendDBDAOSearchPodEtbAtbDateRSQL(),
						param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset,Edi315PrefixMainCOPInfoVO.class);
				
				if(list != null && list.size() > 0) {
					vo = list.get(0);
				}
				
	        } catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return vo;
	    }	 
	    
	    /**
	     * 2011.06.01 황효근 [CHM-201110581-01] Item Addition On 315 FFLayout
		 * Get INBOND_NBR & INBOND_NBR_DT & IT_NBR_DT
		 * @param String bkg_no
		 * @return String[]
		 * @throws DAOException
	     */
	   public String[] getInbondNbrDtItNbrDt(String bkg_no) throws DAOException{
	 	   	DBRowSet dbRowset = null;

	 		Map<String, Object> param    = new HashMap<String, Object>();
//	 		Map<String, Object> velParam = new HashMap<String, Object>();
	 	
	 		Map<String, String> mapVO = new HashMap();
	 		mapVO.put("bkg_no", bkg_no);
	 		
	 	    param.putAll(mapVO);
//	 	    velParam.putAll(mapVO);
	 	    
	 	    String[] temp = new String[3];
	 	    temp[0] = "";
	 	    temp[1] = "";
	 	    temp[2] = "";
	 	    
	 	    try{        	
	 			dbRowset = new SQLExecuter("").executeQuery(
	 					(ISQLTemplate) new Edi315SendDBDADAOGetInbondNbrDtItNbrDtRSQL(),
	 					param,null);
	 			if(dbRowset != null && dbRowset.next()){
	 				temp[0] = dbRowset.getString("INBOND_NBR");
	 				temp[1] = dbRowset.getString("INBOND_NBR_DT");
	 				temp[2] = dbRowset.getString("IT_NBR_DT");
	 			}
	 			
	 	     return temp;
	 	    } catch (SQLException se) {
	 			log.error(se.getMessage(), se);
	 			throw new DAOException(new ErrorHandler(se).getMessage());
	 		} catch (Exception ex) {
	 			log.error(ex.getMessage(), ex);
	 			throw new DAOException(new ErrorHandler(ex).getMessage());
	 		}
	   }
	   
	   /**
	    * 2011.10.27 이경원 PKUP_FIRMS 조회
	    * @param String bkg_no
	    * @return String
	    * @throws DAOException
	    */
	   
	   public String getPickUpFirmsCode(String bkg_no) throws DAOException{
		   	DBRowSet dbRowset = null;
			Map<String, Object> param    = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();		
		    /*파라미터 입력*/
			 Map<String, String> mapVO = new HashMap();
				                 mapVO.put("bkg_no",bkg_no); 
		    param.putAll(mapVO);
		    velParam.putAll(mapVO);
		    String pkup_firms = "";
		    try{        	
				dbRowset = new SQLExecuter("").executeQuery(
						(ISQLTemplate) new Edi315SendDBDAOgetPickUpFirmsCodeRSQL(),
						param,velParam);
				
				if(dbRowset != null && dbRowset.next()){
					pkup_firms = dbRowset.getString("pkup_firms");
				}
		     return pkup_firms;
		    } catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
	  }
	   
	    /**
	     * 2011.10.05 이경원 coff_dt 조회
	     * @param String bkg_no
	     * @return
	     * @throws DAOException
	     */
	    
	    public String searchCutOffTime(String bkg_no) throws DAOException{
		   	DBRowSet dbRowset = null;
			Map<String, Object> param    = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();		
		    /*파라미터 입력*/ 	
			 Map<String, String> mapVO = new HashMap();
				                 mapVO.put("bkg_no",bkg_no); 
		    param.putAll(mapVO);
		    velParam.putAll(mapVO);
		    String coff_dt = "";
		    try{        	
				dbRowset = new SQLExecuter("").executeQuery(
						(ISQLTemplate) new Edi315SendDBDAOSearchCutOffTimeRSQL(),
						param,velParam);
				
				if(dbRowset != null && dbRowset.next()){
					coff_dt = dbRowset.getString("coff_dt");
				}
		     return coff_dt;
		    } catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
	   }	   
	    
	    /**
	     * 2015.01.05 Item Addition On 315 FFLayout
		 * Get CANADIAN NATIONAL RAILROAD INBOND NBR & CANADIAN NATIONAL RAILROAD RAIL BILL NBR
		 * @param String bkg_no
		 * @param String cntr_no
		 * @return String[]
		 * @throws DAOException
	     */
	   public String[] getCNRailInbondAndBillNbr(String bkg_no, String cntr_no) throws DAOException{
	 	   	DBRowSet dbRowset = null;

	 		Map<String, Object> param    = new HashMap<String, Object>();
//	 		Map<String, Object> velParam = new HashMap<String, Object>();
	 	
	 		Map<String, String> mapVO = new HashMap();
	 		mapVO.put("bkg_no", bkg_no);
	 		mapVO.put("cntr_no", cntr_no);
	 		
	 	    param.putAll(mapVO);
//	 	    velParam.putAll(mapVO);
	 	    
	 	    String[] temp = new String[2];
	 	    temp[0] = "";
	 	    temp[1] = "";
	 	    
	 	    try{        	
	 			dbRowset = new SQLExecuter("").executeQuery(
	 					(ISQLTemplate) new Edi315SendDBDAOGetCNRailInbondAndBillNbrRSQL(),
	 					param,null);
	 			if(dbRowset != null && dbRowset.next()){
	 				temp[0] = dbRowset.getString("IBD_NO");
	 				temp[1] = dbRowset.getString("RAIL_CRR_REF_NO"); //2015.04.16 Modify.
	 				//temp[1] = dbRowset.getString("WBL_NO");
	 			}
	 			
	 	     return temp;
	 	    } catch (SQLException se) {
	 			log.error(se.getMessage(), se);
	 			throw new DAOException(new ErrorHandler(se).getMessage());
	 		} catch (Exception ex) {
	 			log.error(ex.getMessage(), ex);
	 			throw new DAOException(new ErrorHandler(ex).getMessage());
	 		}
	   }
	   
	   /**
	    * 
	    * @param params
	    * @return
	    * @throws DAOException
	    */
	   public int updateSceCopDtlActualDateByTrs(HashMap<String, Object> params) throws DAOException{
		    try{        	
		     return new SQLExecuter("").executeUpdate((ISQLTemplate) new Edi315SendDBDAOUpdateSceCopDtlActualDateByTrsUSQL(),params, params);
		    } catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
	   }
	   
	   /**
	    * Multi  trans info  조회 
	    * @param copNo String
	    * @return DBRowSet
	    * @throws DAOException
	    */
	   public DBRowSet searchDynamicTransInfo(String copNo) throws DAOException {
	 	   	DBRowSet dbRowset = null;
	 	    try{        	
	 	    	HashMap hashMap = new HashMap();
	 	    	hashMap.put("cop_no", copNo);

	 	    	HashMap velocityParam  = new HashMap();
	 	    	
	 	    	velocityParam.put("cop_no", copNo);
	 	    	
	 			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Edi315SendDBDAOSearchDynamicTransInfoRSQL(), hashMap, velocityParam);
	 			
	 	    } catch (SQLException se) {
	 			log.error(se.getMessage(), se);
	 			throw new DAOException(new ErrorHandler(se).getMessage());
	 		} catch (Exception ex) {
	 			log.error(ex.getMessage(), ex);
	 			throw new DAOException(new ErrorHandler(ex).getMessage());
	 		}  
	 	     return dbRowset;
	   }
	   
	   /**
	    * trans mode info  조회 
	    * @param bkgNo String
	    * @param cntrNo String
	    * @param copNo String
	    * @param ediStsCd String
	    * @param eventYardCd String
	    * @return DBRowSet
	    * @throws DAOException
	    */
	   public DBRowSet searchTransModeInfo(String bkgNo, String cntrNo,String copNo,String ediStsCd, String eventYardCd) throws DAOException {
	 	   	DBRowSet dbRowset = null;
	 	    try{        	
	 	    	HashMap hashMap = new HashMap();
	 	    	hashMap.put("bkg_no", bkgNo);
	 	    	hashMap.put("cntr_no", cntrNo);
	 	    	hashMap.put("cop_no", copNo);
	 	    	hashMap.put("edi_sts_cd", ediStsCd);
	 	    	hashMap.put("event_yard_cd", eventYardCd);

	 	    	HashMap velocityParam  = new HashMap();
	 	    	
	 	 //   	velocityParam.put("loc_tp_cd", locTpCd);
	 	    	
	 			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Edi315SendDBDAOSearchTransModeInfoRSQL(), hashMap, velocityParam);
	 			
	 	    } catch (SQLException se) {
	 			log.error(se.getMessage(), se);
	 			throw new DAOException(new ErrorHandler(se).getMessage());
	 		} catch (Exception ex) {
	 			log.error(ex.getMessage(), ex);
	 			throw new DAOException(new ErrorHandler(ex).getMessage());
	 		}  
	 	     return dbRowset;
	 	}
	   
	   /**
	    * trsp leg nm  조회 
	    * @param bkgNo String
	    * @param cntrNo String
	    * @param copNo String
	    * @param ediStsCd String
	    * @param eventYardCd String
	    * @return DBRowSet
	    * @throws DAOException
	    */
	   public DBRowSet searchTrspLegNmInfo(String bkgNo, String cntrNo,String copNo,String ediStsCd, String eventYardCd) throws DAOException {
	 	   	DBRowSet dbRowset = null;
	 	    try{        	
	 	    	HashMap hashMap = new HashMap();
	 	    	hashMap.put("bkg_no", bkgNo);
	 	    	hashMap.put("cntr_no", cntrNo);
	 	    	hashMap.put("cop_no", copNo);
	 	    	hashMap.put("edi_sts_cd", ediStsCd);
	 	    	hashMap.put("event_yard_cd", eventYardCd);

	 	    	HashMap velocityParam  = new HashMap();
	 	    	
	 	 //   	velocityParam.put("loc_tp_cd", locTpCd);
	 	    	
	 			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Edi315SendDBDAOSearchTrspLegNmInfoRSQL(), hashMap, velocityParam);
	 			
	 	    } catch (SQLException se) {
	 			log.error(se.getMessage(), se);
	 			throw new DAOException(new ErrorHandler(se).getMessage());
	 		} catch (Exception ex) {
	 			log.error(ex.getMessage(), ex);
	 			throw new DAOException(new ErrorHandler(ex).getMessage());
	 		}  
	 	     return dbRowset;
	 	}
	   
	   /**
	    * cop_dtl_seq  조회 
	    * @param cop_no String
	    * @param edi_sts String
	    * @param event_yd_cd String
	    * @return String
	    * @throws DAOException
	    */
	   public String getCopDtlSeq(String cop_no, String edi_sts, String event_yd_cd) throws DAOException {
	 	   	DBRowSet dbRowset = null;
	 	   	String copDtlSeq = "";
	 	    try{        	
	 	    	HashMap hashMap = new HashMap();
	 	    	hashMap.put("cop_no", cop_no);
	 	    	hashMap.put("edi_sts_cd", edi_sts);
	 	    	hashMap.put("event_yd_cd", event_yd_cd);

	 	    	HashMap velocityParam  = new HashMap();
	 	    	
	 			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Edi315SendDBDAOGetCopDtlSeqRSQL(), hashMap, velocityParam);

	 			if(dbRowset != null && dbRowset.next()){
	 				copDtlSeq = dbRowset.getString("COP_DTL_SEQ");
	 			}
	 	    } catch (SQLException se) {
	 			log.error(se.getMessage(), se);
	 			throw new DAOException(new ErrorHandler(se).getMessage());
	 		} catch (Exception ex) {
	 			log.error(ex.getMessage(), ex);
	 			throw new DAOException(new ErrorHandler(ex).getMessage());
	 		}  
	 	     return copDtlSeq;
	 	}
	   
	   /**
	    * COP Detail의 Activity Code 조회 
	    * @param cop_no String
	    * @param edi_sts String
	    * @param event_yd_cd String
	    * @return String
	    * @throws DAOException
	    */
	   public String getCopDtlActCd(String cop_no, String edi_sts, String event_yd_cd) throws DAOException {
	 	   	DBRowSet dbRowset = null;
	 	   	String copDtlSeq = "";
	 	    try{        	
	 	    	HashMap hashMap = new HashMap();
	 	    	hashMap.put("cop_no", cop_no);
	 	    	hashMap.put("edi_sts_cd", edi_sts);
	 	    	hashMap.put("event_yd_cd", event_yd_cd);

	 	    	HashMap velocityParam  = new HashMap();
	 	    	
	 			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Edi315SendDBDAOGetCopDtlActCdRSQL(), hashMap, velocityParam);

	 			if(dbRowset != null && dbRowset.next()){
	 				copDtlSeq = dbRowset.getString("ACT_CD");
	 			}
	 	    } catch (SQLException se) {
	 			log.error(se.getMessage(), se);
	 			throw new DAOException(new ErrorHandler(se).getMessage());
	 		} catch (Exception ex) {
	 			log.error(ex.getMessage(), ex);
	 			throw new DAOException(new ErrorHandler(ex).getMessage());
	 		}  
	 	     return copDtlSeq;
	 	}

	/**isVvdViewExceptZone 조회
	 * e_cop_dtl_seq 기준으로 동일 e_edi_sts 가 존재 하는지 판별.
	 * 20070905 - DIR로 interface된 data에 대하여 순서를 check 하여 전송 
     * @param     String e_cop_no
     * @param     String e_cop_dtl_seq
     * @param     String e_edi_cgo_rmk
     * @param     String e_edi_grp_cd
     * @return int
     * @throws DAOException
     */     
	public int isVvdViewExceptZone(String e_cop_no, String e_cop_dtl_seq, String e_edi_cgo_rmk, String e_edi_grp_cd) throws DAOException{
	   	DBRowSet dbRowset = null;
	    try{        	
			Map<String, Object> param = new HashMap<String, Object>();		
			
			String e_cop_no_1       = e_cop_no;
			String e_cop_dtl_seq_2  = e_cop_dtl_seq;
			String e_edi_cgo_rmk_3    = e_edi_cgo_rmk;
			String e_edi_grp_cd_4     = e_edi_grp_cd;
	
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("e_cop_no",e_cop_no_1); 
			mapVO.put("e_cop_dtl_seq",e_cop_dtl_seq_2); 
			mapVO.put("e_edi_cgo_rmk",e_edi_cgo_rmk_3); 
			mapVO.put("e_edi_grp_cd",e_edi_grp_cd_4); 
	    	
		    if (mapVO != null) {
		    	param.putAll(mapVO);		
			}		                  
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Edi315SendDBDAOSearchIsVvdViewExceptZoneRSQL(), param, param);
			
			int temp = 0;
			if(dbRowset.next()) {
				temp = dbRowset.getInt(1);
				return temp;
	    	}
			return -1;
	    } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}


	/**isVvdViewExceptZone 조회
	 * 원하는 sequence 를 전송 하기 위해서 VIEW에 동일 status 가 존재하는지의 여부 판별
	 * @param  String e_cop_no
	 * @param  String e_cop_dtl_seq
	 * @param  String e_edi_cgo_rmk
	 * @param  String e_edi_grp_cd
	 * @return int
	 * @throws DAOException
	 */     
	public int isVvdView2ExcepZone(String  e_cop_no, String e_cop_dtl_seq, String e_edi_cgo_rmk, String e_edi_grp_cd )throws DAOException{
	  DBRowSet dbRowset = null;
	  try{
			Map<String, Object> param = new HashMap<String, Object>();	
			
			String e_cop_no_1         = e_cop_no;
			String e_cop_dtl_seq_2    = e_cop_dtl_seq;
			String e_edi_cgo_rmk_3    = e_edi_cgo_rmk;
			String e_edi_grp_cd_4     = e_edi_grp_cd;
			 	
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("e_cop_no",e_cop_no_1); 
			mapVO.put("e_cop_dtl_seq",e_cop_dtl_seq_2); 
			mapVO.put("e_edi_cgo_rmk",e_edi_cgo_rmk_3); 
			mapVO.put("e_edi_grp_cd",e_edi_grp_cd_4); 
				
			if (mapVO != null) {
				 param.putAll(mapVO);		
			}			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Edi315SendDBDAOSearchisVvdView2ExceptZoneRSQL(), param, param);
			
			int temp = 0;
			if(dbRowset.next()) {
				temp = dbRowset.getInt(1);
				return temp;
			}
			
			return -1;
		} catch (SQLException se) {
		  log.error(se.getMessage(), se);
		  throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
		  log.error(ex.getMessage(), ex);
		  throw new DAOException(new ErrorHandler(ex).getMessage());
		}	
	}

	/** getPreSendRsltCountByNod 조회<br>
	 * 2010.09.30 김진승 [CHM-201006003-01] AVN 전송 Error Logic 보완<br>
	 * @param String sts_cd
	 * @param String bkg_no
	 * @param String cntr_no
	 * @param String nod_cd
	 * @return int temp
	 * @throws DAOException
	 */
   public int getPreSendRsltCountByNod(String sts_cd, String bkg_no, String cntr_no, String nod_cd) throws DAOException {
		DBRowSet dbRowset = null;

		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("sts_cd", sts_cd);
			param.put("bkg_no", bkg_no);
			param.put("cntr_no", cntr_no);
			param.put("nod_cd", nod_cd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Edi315SendDBDAOGetPreSendRsltCountByNodRSQL(),param, param);

			int temp = 0;
			if(dbRowset.next()) {
				temp = dbRowset.getInt(1);
				return temp;
			}
			return -1;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
   /**
	* GRP ID가 GV00000001 일때  BL_NBR 조회
	* @param bkgNo
    * @return DBRowSet
    * @throws DAOException
    * @since 2016.08.23 GLOVIS BL NO 315 전송 로직 변경 요청
    */        
   public DBRowSet searchGlovisBlNo(String bkgNo) throws DAOException {
	   	DBRowSet dbRowset = null;
	    try{        	
	    	HashMap hashMap = new HashMap();
	    	hashMap.put("bkg_no", bkgNo);
	    	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Edi315SendDBDAOSearchGlovisBlNoRSQL(), hashMap, null);		
	     return dbRowset;
	    } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}  
   }
   
   /**
    * AV인 경우 POD(SCE_COP_HDR.POD_NOD_CD)와 SCE_COP_DTL에서 ACT_CD가 FI%DO 인 마지막 NOD_CD 앞 다섯자리가 다르면 AVL이벤트가 발송되어야 함.
    * @param String cop_no
    * @return Edi315CurrInfoVO
    * @exception DAOException
   */
   public Edi315CurrInfoVO getAVEventPodCheck(String cop_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<Edi315CurrInfoVO> list = null;
		Edi315CurrInfoVO currInfoVO = null;
		Map<String, Object> param = new HashMap<String, Object>();

		Map<String, String> mapVO = new HashMap();
		mapVO.put("cop_no", cop_no);
		param.putAll(mapVO);
		
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Edi315SendDBDAOGetAVEventPodCheckRSQL(), param, param);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,Edi315CurrInfoVO.class);
			if (list != null && list.size() > 0) {
				currInfoVO = list.get(0);
			}
			
			return currInfoVO;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
   }
}