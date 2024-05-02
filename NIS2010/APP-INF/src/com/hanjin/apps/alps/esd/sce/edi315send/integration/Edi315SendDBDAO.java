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
* 2011.02.18 김영철 [] getCgoRlsHubLoc, getCopActCd 메세드 @param 보완
* 2011.04.08 김진승 [CHM-201109186-01] USA00094에 한 해 OA 발생 전송 시에, VA값이 없을 경우 OA 발생 당시 마이너스 48시간 하여 VA값을 강제 발송 처리
* 2011.04.15~19 김진승 [CHM-201109186-01] USA00094에 한 해 OA 발생 전송 시에, VA값이 없을 경우 OA 발생 당시 마이너스 48시간 하여 VA값을 강제 발송 처리.. 수정
* 2011.05.30 채창호  CHM-201110991-01]  GAP 315 logic 보완 및 오류 사항 확인 요청
* 2011.06.01 황효근 [CHM-201110581-01] Item Addition On 315 FFLayout
* 2011.06.16 채창호 [CHM-201111121-01] : (BASF) VE 로직 보완 요청
* 2011.06.30 채창호 [CHM-201111915-01]: [HP] 315 Event GMT 계산 오류 수정
* 2011.08.26 이경원 [CHM-201112879-01] (BASF) OAN값 로직 보완요청 메소드 추가
* 2011.08.25 이경원 [CHM-201112880-01] 삼성전자 315 Event 코드 추가 및 정의변경 FLAT FILE에 PODETB, PODETB_GMT, PODATB, PODATB_GMT 항목 추가
* 2011.10.24 이경원 [CHM-201113905-01] INVALID LOCATION CODE 문의 관련 처리 요청
* 2011.10.27 이경원 [] PKUP_FIRMS 가져오기
* 2012.06.29 박찬민 [CHM-201218754] BASF 315 최초 VE status 전송 지연 요청 
* 2013.07.05 최덕우 [CHM-201325106] [SCEM] Pseudo Yard EDI 발송 로직 변경 개발 요청
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.integration; 

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.sce.edi315send.basic.Edi315SendBCImpl;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.AddSceEdiSndRsltVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.AddSceFltFileNoGenVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.CurrEventDtYdVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.CurrVvdVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315AmsDataVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315CurrInfoIsCurrVvdVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315DetailVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315MasterVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315PrefixBkgVvdVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315PrefixIrgInfoVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315PrefixMainBkgCustInfoVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315PrefixMainCOPInfoDelDtVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315PrefixMainCOPInfoDelVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315PrefixMainCOPInfoPodDtVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315PrefixMainCOPInfoPodVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315PrefixMainCOPInfoPolDtVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315PrefixMainCOPInfoPolVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315PrefixMainCOPInfoPorDtVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315PrefixMainCOPInfoPorVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315PrefixMainCOPInfoVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315SendOptionsVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315SendVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315XterRqstNoVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.GetEvntDtVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.GetRailTermVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.RlyPortVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.SearchBoundRoutSeqVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.SearchCntrWeightInfoVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.SearchCredataMetInformationVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.SearchTIExistInformationVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.SearchVvdTimeInformationVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.SceCopDtlVO;
import com.hanjin.syscommon.common.table.SceFltFileMsgDtlVslVO;
import com.hanjin.syscommon.common.table.SceFltFileMsgVO;
/**
 * ENIS-SCE Business Logic ServiceCommand<br>
 * - ENIS-SCE에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author YJLEE
 * @see Edi315SendBCImpl 참조
 * @since J2EE 1.4
 */
public class Edi315SendDBDAO extends DBDAOSupport{
	
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
	
	

//	/**
//	 * searchCOPInfo 조회
//     * @param Edi315SendOptionsVO edi315SOpts
//     * @return List<Edi315PrefixMainCOPInfoVO>
//     * @throws DAOException
//     */   
//    public List<Edi315PrefixMainCOPInfoVO> searchCOPInfo(Edi315SendOptionsVO edi315SOpts) throws DAOException {
//    	//!!!!! !!"searchCOPInfo is started.");
//    	DBRowSet dbRowset = null;
//		List<Edi315PrefixMainCOPInfoVO> list = null;
//		// query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		// velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//        try {
//        	if (edi315SOpts != null) {
//				Map<String, String> mapVO = edi315SOpts.getColumnValues();
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//			}
//			dbRowset = new SQLExecuter("").executeQuery(
//					(ISQLTemplate) new Edi315SendDBDAOSearchCOPInfoRSQL(),
//					param, velParam);
//			list = (List) RowSetUtil.rowSetToVOs(dbRowset,Edi315PrefixMainCOPInfoVO.class);
//        } catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (Exception ex) {
//			log.error(ex.getMessage(), ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return list;
//    }
    
    
    
    
    
    
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
	/**searchTIExistInformation
     * @param String bvvd1
     * @param String vsl_callsign1
     * @param String vsl_lloydcode1
     * @param String vsl_fullname1
     * @param String blpol1
     * @param String pol_fullname1
     * @param String blpod1
     * @param String pod_fullname1
     * @param String poleta1
     * @param String poleta1_gmt
     * @param String polata1
     * @param String poletd1
     * @param String poletd1_gmt
     * @param String polatd1
     * @param String polatd1_gmt
     * @param String podeta1
     * @param String podeta1_gmt
     * @param String podata1
     * @param String podata1_gmt
     * @param String podetd1
     * @param String podetd1_gmt
     * @param String podatd1
     * @param String podatd1_gmt
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
              String podatd1 ,      String podatd1_gmt
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
    /**searchFrmsCdInformation 조회
     * @param String bkg_no
     * @param String nod_cd
     * @return DBRowSet
     * @throws DAOException
     */      
    public DBRowSet searchFrmsCdInformation(String bkg_no, String nod_cd) throws DAOException{
    	
    	DBRowSet dbRowset = null;
		 // query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		

	     /*파라미터 입력*/ 	
		 Map<String, String> mapVO = new HashMap();
			                 mapVO.put("bkg_no",bkg_no); 
			                 mapVO.put("nod_cd",nod_cd); 
	     param.putAll(mapVO);
	     velParam.putAll(mapVO);
	     
        try{        	

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOSearchFrmsCdInformationRSQL(),
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
		int rowCnt = 0;
		log.debug(rowCnt);
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
			

			
			rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new Edi315SendDBDAOAddSceFltFileMsgCSQL(),param, valParam);
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


//	/**getEdiEdiActInfo 조회
//     * @param   e_edi_sts1 String 
//     * @param   e_act_cd1  String  
//     * @return List<GetEdiEdiActInfoVO>
//     * @throws DAOException
//     */    
//    public List<GetEdiEdiActInfoVO> getEdiEdiActInfo(String e_edi_sts1, 
//    		                         String e_act_cd1) throws DAOException{
//    	DBRowSet dbRowset = null;
//    	List<GetEdiEdiActInfoVO> list = null;
//		 // query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		// velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();		
//		
//		String e_edi_sts1_1 = e_edi_sts1;
//		String e_act_cd1_2  = e_act_cd1;
//	     
//	    /*파라미터 입력*/ 	
//		  Map<String, String> mapVO = new HashMap();
//			                  mapVO.put("e_edi_sts1",e_edi_sts1_1); 
//			                  mapVO.put("e_act_cd1",e_act_cd1_2);       
//        try {
//        	if (mapVO != null) {
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);		
//			}
//        	
//			dbRowset = new SQLExecuter("").executeQuery(
//					(ISQLTemplate) new Edi315SendDBDAOGetEdiEdiActInfoRSQL(),
//					param, velParam);
//			list = (List) RowSetUtil.rowSetToVOs(dbRowset,GetEdiEdiActInfoVO.class);
//			return list;
//        } catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (Exception ex) {
//			log.error(ex.getMessage(), ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//    }
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
    	DBRowSet dbRowset = null;
    	String event_dt_gmt = "" ;
      try{        			
    	  
      	if (sendVo != null) {
			Map<String, String> params = sendVo.getColumnValues();
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Edi315SendDBDAOGetEventDtGmtRSQL(),params, params);
		}
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
     * @param     String e_edi_sts
     * @return int
     * @throws DAOException
     */     
   public int isVvdView(String e_cop_no, 
		                String e_cop_dtl_seq,
		                String e_edi_sts) throws DAOException{
   	DBRowSet dbRowset = null;
    try{        	
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		String e_cop_no_1       = e_cop_no;
		String e_cop_dtl_seq_2  = e_cop_dtl_seq;
		String e_edi_sts_3      = e_edi_sts;

	    /*파라미터 입력*/ 	
		  Map<String, String> mapVO = new HashMap();
			                  mapVO.put("e_cop_no",e_cop_no_1); 
			                  mapVO.put("e_cop_dtl_seq",e_cop_dtl_seq_2); 
			                  mapVO.put("e_edi_sts",e_edi_sts_3); 
    	
	    if (mapVO != null) {
			    			 param.putAll(mapVO);
			    			 velParam.putAll(mapVO);		
			    			}		                  
		dbRowset = new SQLExecuter("").executeQuery(
				(ISQLTemplate) new Edi315SendDBDAOSearchIsVvdViewRSQL(),
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

	/**isVvdView2 조회
	* 원하는 sequence 를 전송 하기 위해서 VIEW에 동일 status 가 존재하는지의 여부 판별
    * @param  String e_cop_no          
	* @param  String e_cop_dtl_seq   
    * @param  String e_edi_sts	         
    * @return int
    * @throws DAOException
    */     
  public int isVvdView2(String  e_cop_no , 
		                 String e_cop_dtl_seq , 
		                 String e_edi_sts )throws DAOException{
      DBRowSet dbRowset = null;
		try{        	
			 // query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();		
			
			String e_cop_no_1         = e_cop_no;
			String e_cop_dtl_seq_2    = e_cop_dtl_seq;
			String e_edi_sts_3        = e_edi_sts;
			
	
		    /*파라미터 입력*/ 	
			  Map<String, String> mapVO = new HashMap();
				                  mapVO.put("e_cop_no",e_cop_no_1); 
				                  mapVO.put("e_cop_dtl_seq",e_cop_dtl_seq_2); 
				                  mapVO.put("e_edi_sts",e_edi_sts_3); 
	    	
		    if (mapVO != null) {
				    			 param.putAll(mapVO);
				    			 velParam.putAll(mapVO);		
				    			}			
		  dbRowset = new SQLExecuter("").executeQuery(
	       (ISQLTemplate) new Edi315SendDBDAOSearchisVvdView2RSQL(),
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
				 // query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				// velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();		
				
				String cop_no_1           = cop_no;
				String v_edi_sts_2        = v_edi_sts;
				
			    /*파라미터 입력*/ 	
				  Map<String, String> mapVO = new HashMap();
					                  mapVO.put("cop_no",cop_no_1); 
					                  mapVO.put("v_edi_sts",v_edi_sts_2); 

		    	
			    if (mapVO != null) {
					    			 param.putAll(mapVO);
					    			 velParam.putAll(mapVO);		
					    			}			
			  dbRowset = new SQLExecuter("").executeQuery(
		       (ISQLTemplate) new Edi315SendDBDAOSearchIsDirLastViewRSQL(),
		       param,velParam);
			
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
	
	/**isMngLastSeq 조회
	* 원하는 sequence 를 전송 하기 위해서 VIEW에 동일 status 가 존재하는지의 여부 판별
    * @param  String ediStsCd          
	* @param  String ediGrpCd   
    * @param  String copNo
    * @param  String copDtlSeq	         
    * @return int
    * @throws DAOException
    */     
  public int isMngLastSeq(String ediStsCd,String ediGrpCd,String copNo, String copDtlSeq)throws DAOException{
	  DBRowSet dbRowset = null;
	  int count = 0;
	  try{
		  Map<String, Object> param = new HashMap<String, Object>();

		  param.put("edi_sts_cd",ediStsCd); 
		  param.put("edi_grp_cd",ediGrpCd); 
		  param.put("cop_no",copNo); 
		  param.put("cop_dtl_seq",copDtlSeq); 

		  dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Edi315SendDBDAOSearchIsMngLastSeqRSQL(),param,param);
		  if(dbRowset.next()) {
			  count = dbRowset.getInt("CNT");
		  }
	} catch (SQLException se) {
	  log.error(se.getMessage(), se);
	  throw new DAOException(new ErrorHandler(se).getMessage());
	} catch (Exception ex) {
	  log.error(ex.getMessage(), ex);
	  throw new DAOException(new ErrorHandler(ex).getMessage());
	}
	return count;
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
//    public List<Edi315MasterVO> search315MaterList(String cop_no) throws DAOException{
//    	//!!!!! !!"sarchSceCopHdr is started.");
//    	DBRowSet dbRowset = null;
//		List<Edi315MasterVO> list = null;
//		Map<String, String> argMap = new HashMap<String, String>();
//        //Parameter Binding with Velocity		
//		argMap.put("e_cop_no",     cop_no);
//		// query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		// velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//        try {
//        	if (argMap != null) {
//				Map<String, String> mapVO = argMap;
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);		
//			}
//        	
//			dbRowset = new SQLExecuter("").executeQuery(
//					(ISQLTemplate) new Edi315SendDBDAOSearch315MasterListRSQL(),
//					param, velParam);
//			
//			list = (List) RowSetUtil.rowSetToVOs(dbRowset,Edi315MasterVO.class);
//        } catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (Exception ex) {
//			log.error(ex.getMessage(), ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return list; 
//    }	
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
	/**
	 * getDateTime2
     * @param String event_dt
     * @param String edi_snd_itval_hr
     * @return String
	 * @throws DAOException
	 */   
    public String getDateTime2(String event_dt, String edi_snd_itval_hr)
			throws DAOException {
		DBRowSet dbRowset = null;
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			String event_dt_1 = event_dt;
			String edi_snd_itval_hr_2 = edi_snd_itval_hr;
			log.debug("\n dao.edi_snd_itval_hr : "+edi_snd_itval_hr);

			Map<String, String> mapVO = new HashMap();
			mapVO.put("event_dt", event_dt_1);
			mapVO.put("edi_snd_itval_hr", edi_snd_itval_hr_2);

			if (mapVO != null) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOGetDateTime2RSQL(),
					param, velParam);

			String temp = "0";
			if (dbRowset.next()) {
				temp = dbRowset.getString(1);
				log.debug("\n\n dao.temp : " + temp);
				return temp;
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
	 * partial 로 된 bkg / cntr 로 동일 status 전송 기록이 있을 경우 전송 skip
	 * 2010.10.11 현재 Target 만 해당이며 Edi315BCImpl 단에서 validating 한다.
	 * @param dtlVO - Edi315DetailVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkPartialSndRslt(Edi315DetailVO dtlVO) throws DAOException {
		DBRowSet dbRowset = null;
		
		boolean isChecked = false;
		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			param.putAll(dtlVO.getColumnValues());
			velParam.putAll(dtlVO.getColumnValues());
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Edi315SendDBDAOCheckPartialSndRsltRSQL() , param,
					velParam);
			
			isChecked = dbRowset.next();

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return isChecked;
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
    /**modifySceEdiHisDtlEdiRmk2 수정
     * @param   String edi_string
     * @param   String rcv_dt    
     * @param   String rcv_seq   
     * @param   String rcv_dtl_seq
     * @return boolean
	 * @throws DAOException
	 */   
	       
    public boolean modifySceEdiHisDtlEdiRmk2(
                              String edi_string,
                              String rcv_dt,
                              String rcv_seq,
                              String rcv_dtl_seq) throws DAOException{
	    boolean resultFlag = false;
		 // query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		

		
	     /*파라미터 입력*/ 	
		  Map<String, String> mapVO = new HashMap();
			        mapVO.put("edi_string" ,edi_string);       
					mapVO.put("rcv_dt"     ,rcv_dt     );       
					mapVO.put("rcv_seq"    ,rcv_seq    );    
					mapVO.put("rcv_dtl_seq",rcv_dtl_seq);   

	     param.putAll(mapVO);
	     velParam.putAll(mapVO);
		try {
			    int insCnt = 0;
				
	 			  if(mapVO.size() > 0){
	 					insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new Edi315SendDBDAOModifySceEdiHisDtlEdiRmk2USQL(), param, velParam);
	 						if(insCnt == Statement.EXECUTE_FAILED)
	 							throw new DAOException("Fail to Update at SQL: Edi315SendDBDAOModifySceEdiHisDtlEdiRmk2USQL");
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
    
	/**searchNodInformation2 조회
     * @param String event_yard
     * @return DBRowSet
	 * @throws DAOException
	 */    
    public DBRowSet searchNodInformation2(String event_yard) throws DAOException{
    	DBRowSet dbRowset = null;

		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();		
	
		 Map<String, String> mapVO = new HashMap();
		 mapVO.put("e_event_yard",event_yard); 
	     param.putAll(mapVO);
	     velParam.putAll(mapVO);
	     
       try{        	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOSearchNodInformation2RSQL(),
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
			                 mapVO.put("e_bkg_no",bkg_no_1); 
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
			else{
				temp = " ";
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
   
   /**getItemPoNo 조회
    * @param String bkg_no   
    * @return String
	 * @throws DAOException
	 */    
  public String[] getItemPoNo(String bkg_no, String cntr_no) throws DAOException{
	   	DBRowSet dbRowset = null;
		Map<String, Object> param    = new HashMap<String, Object>(); // query parameter		
		Map<String, Object> velParam = new HashMap<String, Object>(); // velocity parameter		
		String bkg_no_1          = bkg_no;
		String cntr_no_1 		 = cntr_no;
	    /*파라미터 입력*/ 	
		 Map<String, String> mapVO = new HashMap();
			                 mapVO.put("e_bkg_no", bkg_no_1); 	
			                 mapVO.put("e_cntr_no", cntr_no_1); 
	    param.putAll(mapVO);
	    velParam.putAll(mapVO);
	    
	    String[] multiResult = null;
	    
	    try{        	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Edi315SendDBDAOGetItemPoNoRSQL(),param,velParam);
			
			if (dbRowset != null) {
				multiResult = new String[dbRowset.getRowCount()];
				int i = 0;
				while (dbRowset.next()) {
					multiResult[i] = dbRowset.getString("ITEM_PO_NBR");
					i++;
				}
			}
		    dbRowset = null;
		    
	     return multiResult;
	     
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
			else{
				splitPantos = "";
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
			else{
				pantosBlNo = "";
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
   
	/**getReservedEventDtMin
	 * Reserved Case 에는 Event Date와 Send Date를 구해 하는데, Interval 을 더해 Date를 재 계산 함.
    * @param String event_dt
    * @param String edi_snd_itval_hr
    * @return String
	 * @throws DAOException
	 */   
  public String getReservedEventDtMin(String event_dt, String edi_snd_itval_hr)throws DAOException {
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
					(ISQLTemplate) new Edi315SendDBDAOGetReservedEventDtMinRSQL(),
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
   
	/**getEventDtForTRT
    * @param String cntr_no
    * @param String bkg_no
    * @param String edi_tp
    * @return String
	 * @throws DAOException
	 */   
  public String getEventDtForTRT(String delay_t, String edi_grp_cd, String edi_tp, String edi_sub_sts_cd, String cntr_no, String bkg_no)throws DAOException {
		DBRowSet dbRowset = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		Map<String, String> mapVO = new HashMap();
			mapVO.put("delay_t", delay_t);
			mapVO.put("edi_grp_cd", edi_grp_cd);
			mapVO.put("edi_tp", edi_tp);
			mapVO.put("edi_sub_sts_cd", edi_sub_sts_cd);
			mapVO.put("cntr_no", cntr_no);
			mapVO.put("bkg_no", bkg_no);
		param.putAll(mapVO);
		velParam.putAll(mapVO);
		String temp = "";
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOGetEventDtForTRTRSQL(),
					param, velParam);
			if (dbRowset != null && dbRowset.next()) {
				temp = dbRowset.getString("ACT_DT");
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
   
	/**getReservedSendDt
	 * Reserved Case 에는 Send Date를 구할 때, Interval 을 더해 Date를 재 계산 함.
    * @param String edi_snd_itval_hr
    * @return String
	 * @throws DAOException
	 */   
  public String getReservedSendDt(String edi_snd_itval_hr)throws DAOException {
		DBRowSet dbRowset = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		Map<String, String> mapVO = new HashMap();
			mapVO.put("edi_snd_itval_hr", edi_snd_itval_hr);
		param.putAll(mapVO);
		velParam.putAll(mapVO);
		String temp = "";
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOGetEdiSndRsvDtRSQL(),
					param, velParam);

			if (dbRowset != null && dbRowset.next()) {
				temp = dbRowset.getString("EDI_SND_RSV_DT");
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
  
	/**getReservedSendDtMin
	 * Reserved Case 에는 Send Date를 구할 때, Interval 을 더해 Date를 재 계산 함.
  * @param String edi_snd_itval_hr
  * @return String
	 * @throws DAOException
	 */   
public String getReservedSendDtMin(String edi_snd_itval_hr)throws DAOException {
		DBRowSet dbRowset = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		Map<String, String> mapVO = new HashMap();
			mapVO.put("edi_snd_itval_hr", edi_snd_itval_hr);
		param.putAll(mapVO);
		velParam.putAll(mapVO);
		String temp = "";
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOGetEdiSndRsvDtMinRSQL(),
					param, velParam);

			if (dbRowset != null && dbRowset.next()) {
				temp = dbRowset.getString("EDI_SND_RSV_DT");
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
  
	/**getReservedSendDtForVE
	 * Reserved Case 에는 Send Date를 구할 때, Interval 을 더해 Date를 재 계산 함. VE CASE
	 * @param   String edi_group_cd 
	 * @param   String edi_sts 
	 * @param   String cust_edi_sts
	 * @param   String cntr_no 
	 * @param   String bkg_no 
	 * @return String
	 * @throws DAOException
	 */   
public String getReservedSendDtForVE(String edi_group_cd, String edi_sts, String cust_edi_sts, String cntr_no, String bkg_no)throws DAOException {
		DBRowSet dbRowset = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		Map<String, String> mapVO = new HashMap();
            mapVO.put("edi_group_cd"	,edi_group_cd); 
            mapVO.put("edi_sts"     	,edi_sts); 
            mapVO.put("cust_edi_sts"	,cust_edi_sts); 
            mapVO.put("cntr_no"		,cntr_no); 
            mapVO.put("bkg_no"		,bkg_no); 
		param.putAll(mapVO);
		velParam.putAll(mapVO);
		String temp = "";
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOGetEdiSndRsvDtForVERSQL(),
					param, velParam);

			if (dbRowset != null && dbRowset.next()) {
				temp = dbRowset.getString("EDI_SND_RSV_DT");
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
  
  /**
   * VE 관련 EDI 발송 시간이 최초 Reserve 시간 보다 이전인지 확인
   * @param   String edi_group_cd 
   * @param   String edi_sts 
   * @param   String cust_edi_sts
   * @param   String cntr_no 
   * @param   String bkg_no     
   * @return int
   * @throws DAOException
   */  
	public int getRsvDtIndicator(
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
		       (ISQLTemplate) new Edi315SendDBDAOGetRsvDtIndicatorRSQL(),
		       param,velParam);
				int temp = -1;
				if(dbRowset.next()) {
				  temp = dbRowset.getInt(1);
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
   
	/**getCntrTareWeight 조회
    * @param String bkg_no   
    * @return String
	 * @throws DAOException
	 */    
  public String getCntrTareWeight(String cntr_no) throws DAOException{
	   	DBRowSet dbRowset = null;
		 // query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
	
	    /*파라미터 입력*/ 	
		 Map<String, String> mapVO = new HashMap();
			                 mapVO.put("cntr_no",cntr_no); 
	    param.putAll(mapVO);
	    velParam.putAll(mapVO);
	    String temp = "";
	    try{        	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOGetCntrTareWeightRSQL(),
					param,velParam);
			if(dbRowset != null && dbRowset.next()){
				temp = dbRowset.getString("CNTR_TWEIGHT");
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
//	/**getOnBoardDt 조회
//     * @param String bkg_no  
//     * @return String
//	 * @throws DAOException
//	 */    
//   public String getOnBoardDt(String bkg_no) throws DAOException{
//	   	DBRowSet dbRowset = null;
//		 // query parameter
//		Map<String, Object> param    = new HashMap<String, Object>();
//		// velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();		
//		
//		String bkg_no_1          = bkg_no;
//	
//	    /*파라미터 입력*/ 	
//		 Map<String, String> mapVO = new HashMap();
//			                 mapVO.put("e_bkg_no",bkg_no_1); 
//	    param.putAll(mapVO);
//	    velParam.putAll(mapVO);
//	    String temp = "";
//	    try{        	
//			dbRowset = new SQLExecuter("").executeQuery(
//					(ISQLTemplate) new Edi315SendDBDAOGetOnBoardDtRSQL(),
//					param,velParam);
//			if(dbRowset != null && dbRowset.next()){
//				temp = dbRowset.getString("PANTO_BL_OBRD_DT");
//			}			
//	     return temp;
//	    } catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (Exception ex) {
//			log.error(ex.getMessage(), ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//   }
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
   /** getCgoRlsHubLoc 조회
    * @param String bl_no
	* @param String event_yard    
    * @return DBRowSet
	* @throws DAOException
	*/      
  public DBRowSet getCgoRlsHubLoc(String bl_no, String event_yard) throws DAOException{
	   	DBRowSet dbRowset = null;
		 // query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
	    /*파라미터 입력*/ 	
		 Map<String, String> mapVO = new HashMap();
			                 mapVO.put("bl_no"  ,bl_no); 
			                 mapVO.put("event_yard"  ,event_yard); 
	    param.putAll(mapVO);
	    velParam.putAll(mapVO);
	    try{        	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOGetCgoRlsHubLocRSQL(),
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
  
    /**getCopActCd 조회
     * @param String cop_no
	 * @param String cop_dtl_seq    
     * @return DBRowSet
	 * @throws DAOException
	 */      
 public DBRowSet getCopActCd(String cop_no, String cop_dtl_seq) throws DAOException{
	   	DBRowSet dbRowset = null;
		 // query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
	    /*파라미터 입력*/ 	
		 Map<String, String> mapVO = new HashMap();
			                 mapVO.put("cop_no"  ,cop_no); 
			                 mapVO.put("cop_dtl_seq"  ,cop_dtl_seq); 
	    param.putAll(mapVO);
	    velParam.putAll(mapVO);
	    try{        	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOGetCopActCdRSQL(),
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
    * 발송 Status에 해당 하는 Event Date, Event Yard, sce_dtl_seq 등을 조회.
    * @param String event_yard
    * @param String cop_no
    * @param String edi_sts
    * @param String org_ediSts
    * @param String edi_grpcd
    * @return CurrEventDtYdVO
    * @exception DAOException
   */
   public CurrEventDtYdVO getCurrInfoVoWithIsCurrCopDtl(String event_yard, String cop_no, String edi_sts ,String org_ediSts ,String edi_grpcd) throws DAOException {
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
		mapVO.put("e_org_sts", org_ediSts);
		mapVO.put("e_edi_grpcd", edi_grpcd);
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
    * getCurrInfoVoWithIsCurrVvd
    * @param String event_yard
    * @param String cop_no
    * @param String edi_sts
    * @return Edi315CurrInfoIsCurrVvdVO
    * @exception DAOException
   */
   public Edi315CurrInfoIsCurrVvdVO getCurrInfoVoWithIsCurrVvd(String event_yard, 
																	String cop_no, 
																	String edi_sts
																	) throws DAOException{
	   	DBRowSet dbRowset                                   = null;
	   	List<Edi315CurrInfoIsCurrVvdVO> list                = null;
	   	Edi315CurrInfoIsCurrVvdVO edi315CurrInfoIsCurrVvdVO = null;
	   	
		 // query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		String event_yard_1       = event_yard;
		String cop_no_2           = cop_no;
		String edi_sts_3          = edi_sts;

	    /*파라미터 입력*/ 	
		 Map<String, String> mapVO = new HashMap();
			                 mapVO.put("e_event_yard",event_yard_1);
			                 mapVO.put("e_cop_no"    ,cop_no_2    );
			                 mapVO.put("e_edi_sts"   ,edi_sts_3   );
	    param.putAll(mapVO);
	    velParam.putAll(mapVO);
	   
	    try{        	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOSearchIsCurrVvdRSQL(),
					param,velParam);	
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,Edi315CurrInfoIsCurrVvdVO.class);
			if(list != null && list.size() >0){
				edi315CurrInfoIsCurrVvdVO = list.get(0);
			}
		return edi315CurrInfoIsCurrVvdVO;
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
     * 2011.06.01 황효근 [CHM-201110581-01] Item Addition On 315 FFLayout
	 * Get INBOND_NBR & INBOND_NBR_DT & IT_NBR_DT
	 * @param String bkg_no
	 * @return String[]
	 * @throws DAOException
     */
   public String[] getInbondNbrDtItNbrDt(String bkg_no) throws DAOException{
 	   	DBRowSet dbRowset = null;

 		Map<String, Object> param    = new HashMap<String, Object>();
// 		Map<String, Object> velParam = new HashMap<String, Object>();
 	
 		Map<String, String> mapVO = new HashMap();
 		mapVO.put("bkg_no", bkg_no);
 		
 	    param.putAll(mapVO);
// 	    velParam.putAll(mapVO);
 	    
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
   
	/**getFlagWithComparision 조회 
	 * @param Strin gargument1  
	 * @param String argument2  
     * @param String equation   
     * @return String
	 * @throws DAOException
	 */   
   public String getFlagWithComparision(String argument1,
		                                String argument2,
		                                String equation) throws DAOException{
	   	DBRowSet dbRowset = null;
		 // query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		String argument1_1       = argument1;
		String argument2_2       = argument2;
		String equation_3        = equation;
		
	    /*파라미터 입력*/ 	
		 Map<String, String> mapVO = new HashMap();
			                 mapVO.put("e_argument1"  ,argument1_1);  
			                 mapVO.put("e_argument2"  ,argument2_2);  
			                 mapVO.put("e_equation"   ,equation_3 );  
	    param.putAll(mapVO);
	    velParam.putAll(mapVO);
	    String temp = "";
	    try{        	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOGetFlagWithComparisonRSQL(),
					param,velParam);
			if(dbRowset != null && dbRowset.next()){
				temp = dbRowset.getString("FLAG");
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

   
   
	/**searchBkgLoc 조회 
	 * @param String bl_no   
    * @return DBRowSet
	 * @throws DAOException
	 */     
   public DBRowSet searchBkgLoc(String bl_no) throws DAOException{
	   	DBRowSet dbRowset = null;
		 // query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();			
		String bl_no_1       = bl_no;
	    /*파라미터 입력*/ 	
		 Map<String, String> mapVO = new HashMap();
			                 mapVO.put("e_bl_no",bl_no_1);   
	      param.putAll(mapVO);
	      velParam.putAll(mapVO);	   	
	    try{   
	    	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOSearchBkgLocRSQL(),
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
		    int insCnt = 0;
		    insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new Edi315SendDBDAOModifySceEdiSndRsltRSQL(), param, velParam);
				
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
   * NIKE 경우 RLN 발생시 OA 발생하므로 체크로직 추가
   * @param String edi_grp_cd
   * @param String bkg_no
   * @param String cntr_no
   * @param String chk_sts
   * @param String sub_sts_cd
   * @return int
   * @throws DAOException 
   */
  public int searchIsDirFirstView2( String edi_grp_cd, String bkg_no, String cntr_no, String chk_sts, String sub_sts_cd) throws DAOException {
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
					(ISQLTemplate) new Edi315SendDBDAOSearchIsDirFirstView2RSQL(), param,
					velParam);
			
			while(dbRowset.next()){
				cnt = dbRowset.getInt("send_cnt");
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
		int rowCnt = 0;
		try {


			Map<String, String> valParam = new HashMap<String, String>();
			Map<String, String> param = new HashMap<String, String>();
			param.putAll(ffMsgVo.getColumnValues());
			param.putAll(ffMsgVo.getColumnValues());

			rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new Edi315SendDBDAOAddSceFltFileMsgDtlVslCSQL(),param, valParam);
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
   
   /** getVEVBEValidationCount 조회<br>
	 * 2016.01.18 [CHM-201639643] Homedepot 315 : 개발요청 - VE/VBE block if VAD/VBD is sent<br>
	 * @param Edi315DetailVO dtlVo 
	 * @return int
	 * @throws DAOException
	 */
  public int getVEVBEValidationCount(Edi315DetailVO dtlVo, String edi_sts_cd) throws DAOException {
		DBRowSet dbRowset = null;

		try {
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			/*파라미터 입력*/
			Map<String, String> mapVO = dtlVo.getColumnValues();
			 	             mapVO.put("edi_sts_cd", edi_sts_cd); 

			if (mapVO != null) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Edi315SendDBDAOGetVEVBEValidationCountRSQL(),param, velParam);

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
    * @param bkgNo
    * @param cntrNo
    * @param custTrdPrnrIdArryList
    * @return DBRowSet
    * @throws DAOException
	* @since 2010.10.26
    */
	public DBRowSet searchPrtlBkgsForEdiGrp(String bkgNo, String cntrNo, ArrayList custTrdPrnrIdArryList) throws DAOException {
	   	DBRowSet dbRowset = null;
	    try{        	
	    	HashMap hashMap = new HashMap();
	    	hashMap.put("bkg_no", bkgNo);
	    	hashMap.put("cntr_no", cntrNo);

	    	HashMap velocityParam = null; 
			if(custTrdPrnrIdArryList!=null && custTrdPrnrIdArryList.size()>0){
				velocityParam = new HashMap();
				velocityParam.put("cust_trd_prnr_id", custTrdPrnrIdArryList);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Edi315SendDBDAOSearchPrtlBkgsForEdiGrpRSQL(), hashMap, velocityParam);
			
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
     * 2011.04.08 김진승 [CHM-201109186-01] USA00094에 한 해 OA 발생 전송 시에, VA값이 없을 경우 OA 발생 당시 마이너스 48시간 하여 VA값을 강제 발송 처리
     * @param String bkgNo
     * @param String cntrNo
     * @return DBRowSet
     * @since 2011.04.08
     */
	public DBRowSet searchUSA00094VAMissed(String bkgNo, String cntrNo) throws DAOException {

	   	DBRowSet dbRowset = null;
		try {
			HashMap hashMap = new HashMap();
			hashMap.put("bkg_no", bkgNo);
			hashMap.put("cntr_no", cntrNo);

			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new Edi315SendDBDAOSearchUSA00094VAMissedRSQL(),
							hashMap, null);

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
     * Bkg NO를 이용해서 POD,DEL의 SCC를 가져온다.
     * @param String bkgNo
     * @return DBRowSet
     * @since 2011.05.30
     */
	public DBRowSet getBkgRouteSccCd(String bkgNo) throws DAOException {

	   	DBRowSet dbRowset = null;
		try {
			HashMap hashMap = new HashMap();
			hashMap.put("bkg_no", bkgNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Edi315SendDBDAOGetBkgRouteSccCdRSQL(),	hashMap, null);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;

	}
	/**URN,OAN이고 A가 발송내역이 있는지 조회
	
     * @param     String edi_group_cd
     * @param     String cntr_no
     * @param     String bkg_no
     * @return int
     * @throws DAOException
     */     
   public int searchGapEdiSndRult (String edi_group_cd, 
		                           String cntr_no,
		                           String bkg_no) throws DAOException{
   	DBRowSet dbRowset = null;
   	int temp = 0;
    try{        	
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
	    param.put("edi_group_cd", edi_group_cd);
	    param.put("cntr_no", cntr_no);
	    param.put("bkg_no",bkg_no);
	                  
		dbRowset = new SQLExecuter("").executeQuery(
				(ISQLTemplate) new Edi315SendDBDAOSearchGapEdiSndRultRSQL(),
				param,velParam);
		
		
		if(dbRowset.next()) {
			temp = dbRowset.getInt(1);
	   	}
		
    } catch (SQLException se) {
		log.error(se.getMessage(), se);
		throw new DAOException(new ErrorHandler(se).getMessage());
	} catch (Exception ex) {
		log.error(ex.getMessage(), ex);
		throw new DAOException(new ErrorHandler(ex).getMessage());
	}
	return temp;
   }
   
	/**
	 * <br>
	 * 
	 * @param String eventDt
	 * @return String
	 * @exception DAOException
	 */	
	public String searchGapAvEventDt(String eventDt) throws DAOException {

		String onemin = "";
		DBRowSet dbRowset = null;
		try {
			Map<String, String> param = new HashMap<String, String>();
  		    param.put("event_dt" ,eventDt);
			
			dbRowset = new SQLExecuter("").executeQuery(
					 (ISQLTemplate) new Edi315SendDBDAOSearchGapAvEventDtRSQL(),param, null);
			
			if(dbRowset.next()){
				onemin = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return onemin;
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
			} else {
				coff_dt = "";
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
     * 2015.10.23 조풍연 김민정 ms_dwll_rsn_cd 조회
     * @param String cop_no
     * @return
     * @throws DAOException
     */
    
    public String searchMsDwllRsnCd(String cop_no) throws DAOException{
	   	DBRowSet dbRowset = null;
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();		
	    /*파라미터 입력*/ 	
		 Map<String, String> mapVO = new HashMap();
			                 mapVO.put("cop_no", cop_no); 
	    param.putAll(mapVO);
	    velParam.putAll(mapVO);
	    String ms_dwll_rsn_cd = "";
	    try{        	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOSearchMsDwllRsnCdRSQL(),
					param,velParam);
			
			if(dbRowset != null && dbRowset.next()){
				ms_dwll_rsn_cd = dbRowset.getString("ms_dwll_rsn_cd");
			} else {
				ms_dwll_rsn_cd = "";
			}
	     return ms_dwll_rsn_cd;
	    } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
   }
    
    /**
     * 2015.10.23 조풍연 김민정 ms_dwll_rmk  조회
     * @param String cop_no
     * @return
     * @throws DAOException
     */
    
    public String searchMsDwllRmk(String cop_no) throws DAOException{
	   	DBRowSet dbRowset = null;
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();		
	    /*파라미터 입력*/ 	
		 Map<String, String> mapVO = new HashMap();
			                 mapVO.put("cop_no", cop_no); 
	    param.putAll(mapVO);
	    velParam.putAll(mapVO);
	    String ms_dwll_rmk = "";
	    try{        	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOSearchMsDwllRmkRSQL(),
					param,velParam);
			
			if(dbRowset != null && dbRowset.next()){
				ms_dwll_rmk = dbRowset.getString("ms_dwll_rmk");
			} else {
				ms_dwll_rmk = "";
			}
	     return ms_dwll_rmk;
	    } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
   }
    
    /**
     * 2011.10.24 이경원 [CHM-201113905-01] INVALID LOCATION CODE 문의 관련 처리 요청
     * @param String bkg_no
     * @param String cntr_no
     * @param String event_yard
     * @param String edi_sts
     * @param String cop_dtl_seq
     * @return
     * @throws DAOException
     */
   public DBRowSet searchEventYardForReUse(String bkg_no, String cntr_no, String event_yard, String edi_sts, String cop_dtl_seq) throws DAOException {
		DBRowSet dbRowset = null;
		try {
			HashMap hashMap = new HashMap();
			hashMap.put("bkg_no", bkg_no);
			hashMap.put("cntr_no", cntr_no);
			hashMap.put("event_yard", event_yard);
			hashMap.put("edi_sts", edi_sts);
			hashMap.put("cop_dtl_seq", cop_dtl_seq);

			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new Edi315SendDBDAOSearchEventYardForReUseRSQL(),
							hashMap, null);

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
			} else {
				pkup_firms = "";
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

	/**searchDelCd 조회
    * @param String cop_no 
    * @return String
	 * @throws DAOException
	 */   
  public String searchDelCd(String cop_no) throws DAOException{
	   	DBRowSet dbRowset = null;
	   	String del_cd = "";
		 // query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		param.put("cop_no" ,cop_no); 
	     
	 
	    try{        	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOSearchDelCdRSQL(),param,velParam);
			if(dbRowset != null && dbRowset.next()){
				del_cd = dbRowset.getString(1);
			}
	     
	    } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		} 
		return del_cd;
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
  
	/**CNTR_PO_NBR  조회
   * @param String bkgNo 
   * @param String cntrNo
   * @return String
	 * @throws DAOException
	 */   
 public String searchCntrPoNbr (String bkgNo , String cntrNo) throws DAOException{
	   	DBRowSet dbRowset = null;
	   	String cntrPoBr = "";
		 // query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		param.put("bkg_no" ,bkgNo);
		param.put("cntr_no" ,cntrNo);
	     
	 
	    try{        	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOSearchCntrPoNbrRSQL(),param,velParam);
			if(dbRowset != null && dbRowset.next()){
				cntrPoBr = dbRowset.getString(1);
			}
	     
	    } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		} 
		return cntrPoBr;
 }
 
	/**LOAD_ID  조회
  * @param String bkgNo 
  * @param String cntrNo
  * @return String
	 * @throws DAOException
	 */   
public String searchLoadId (String bkgNo, String cntrNo) throws DAOException{
	   	DBRowSet dbRowset = null;
	   	String load_id = "";
		 // query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		param.put("bkg_no" , bkgNo);
		param.put("cntr_no", cntrNo);
	     
	 
	    try{        	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOSearchLoadIdRSQL(),param,velParam);
			if(dbRowset != null && dbRowset.next()){
				load_id = dbRowset.getString(1);
			}
	     
	    } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		} 
		return load_id;
   } 
 
 	/**기 발송 된 Status가 있는지 확인 한다.
	 * @param Edi315DetailVO dtlVo
	 * @return int
	 * @throws DAOException
	 */
 	public int getPreSentAvCnt(Edi315DetailVO dtlVo) throws DAOException {
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
							(ISQLTemplate) new Edi315SendDBDAOGetPreSentAvCntRSQL(),
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
 
	 /** MVMT Seal No  조회
	  * @param String bkgNo 
	  * @param String cntrNo
	  * @return String
	  * @throws DAOException
	*/   
 	public String searchMvmtSealNo (String bkgNo , String cntrNo) throws DAOException{
	   	DBRowSet dbRowset = null;
	   	String cntrSealNo = "";
		 // query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		param.put("e_bkg_no" ,bkgNo);
		param.put("e_cntr_no" ,cntrNo);
	     
	 
	    try{        	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOSearchMvmtSealNoRSQL(),param,velParam);
			if(dbRowset != null && dbRowset.next()){
				cntrSealNo = dbRowset.getString(1);
			}
	     
	    } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		} 
		return cntrSealNo;
 	}
 	
 	/**
	 * Container CM DESC정보를 조회한다.<br>
	 * EDI flat_file전송용 데이터
	 *
	 * @author 
	 * @param String bkgNo
	 * @return Edi315XterRqstNoVO
	 * @exception DAOException
	 */
	public Edi315XterRqstNoVO searchCust315XterInfo(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<Edi315XterRqstNoVO> list = null;
		Edi315XterRqstNoVO edi315XterRqstNoVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		param.put("bkg_no" ,bkgNo);

		try{

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Edi315SendDAOSearchBkgXterRqstNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Edi315XterRqstNoVO.class);

			if (list != null && list.size() > 0) {
				edi315XterRqstNoVO = list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return edi315XterRqstNoVO;
	}
	
	/**
	 * Container BKG Info정보를 조회한다.<br>
	 * EDI flat_file전송용 데이터
	 *
	 * @author Jun Yong Jin
	 * @param Edi315XterRqstNoVO edi315XterRqstNoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchCust315XterInfo(Edi315XterRqstNoVO edi315XterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnStr = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(edi315XterRqstNoVO != null){
				Map<String, String> mapVO = edi315XterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Edi315SendDAOSearchCust315XterInfoRSQL(), param, velParam);
			while (dbRowset.next()) {
				rtnStr = dbRowset.getString("I_BKG_INFO");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rtnStr;
	}
	
	/**
     * 2013.08.20 COP VE Plan_Date 조회
     * @param String bkg_no
     * @param String cntr_no
     * @param String stnd_edi_sts_cd
     * @return String
     * @throws DAOException
     */
    
    public String searchCopPlanDate(String bkg_no, String cntr_no, String stnd_edi_sts_cd) throws DAOException{
	   	
    	DBRowSet dbRowset = null;
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();		
	    /*파라미터 입력*/ 	
		Map<String, String> mapVO = new HashMap();
		
		mapVO.put("bkg_no",bkg_no); 
		mapVO.put("cntr_no",cntr_no);
		mapVO.put("stnd_edi_sts_cd",stnd_edi_sts_cd);
	    
		param.putAll(mapVO);
	    
	    velParam.putAll(mapVO);
	    
	    String pln_dt = "";
	    try{        	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EDI315SendDBDAOSearchCopPlanDateRSQL(),
					param,velParam);
			
			if(dbRowset != null && dbRowset.next()){
				pln_dt = dbRowset.getString("PLN_DT");
			} else {
				pln_dt = "";
			}
	     return pln_dt;
	     
	    } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
   }
    
   /**
   * URN,OAN이고 A가 발송내역이 있는지 조회
   * @param     String edi_group_cd
   * @param     String bkg_no
   * @param     String cntr_no
   * @param     String cust_edi_cd
   * @return int
   * @throws DAOException
   */     
   public int searchCustEdiCdSndRult (String edi_group_cd, String bkg_no, String cntr_no, String cust_edi_cd) throws DAOException{
	   DBRowSet dbRowset = null;
   		int temp = 0;
   		
	    try{        	
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();		
			
		    param.put("edi_group_cd", edi_group_cd);
		    param.put("cntr_no", cntr_no);
		    param.put("bkg_no",bkg_no);
		    param.put("cust_edi_cd",cust_edi_cd);
		                  
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOsearchCustEdiCdSndRsltRSQL(),
					param,velParam);
			
			
			if(dbRowset.next()) {
				temp = dbRowset.getInt(1);
		   	}
		
	    } catch (SQLException se) {
		log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
	    } catch (Exception ex) {
	    	log.error(ex.getMessage(), ex);
	    	throw new DAOException(new ErrorHandler(ex).getMessage());
	    }	    
	    return temp;
   }
   
// 2013.10.22 CHM-201327178 DEL Delivery Time 변경 시 자동 전송 로직 추가 요청(Live 미반영으로 주석처리)
   /**
    * 신규 Event EOAN(Estimated Time of I/B Ingate)을 가져온다.
    * @param String cop_no
    * @return CurrEventDtYdVO
    * @exception DAOException
   */
   public CurrEventDtYdVO getEoanEstimatedDate(String cop_no) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Edi315SendDBDAOgetEoanEstimatedDateRSQL(),param, velParam);
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
    * getIbTruckSoCnt
    * Nike Canada Event AOL 일때 I/B Truck 운송이 있는지 여부를 체크한다.
    * @param String cop_no
    * @return int
    * @exception DAOException
   */
   public int getIbTruckSoCnt(String cop_no) throws DAOException {
		DBRowSet dbRowset = null;
		int chkCnt = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();


		/* 파라미터 입력 */
		Map<String, String> mapVO = new HashMap();
		mapVO.put("cop_no", cop_no);
		param.putAll(mapVO);
		velParam.putAll(mapVO);
		
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Edi315SendDBDAOgetIbTruckSoCntRSQL(),param, velParam);

			if(dbRowset.next()) {
				chkCnt = dbRowset.getInt(1);
		   	}
			
			return chkCnt;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
   }
   
   /**getReservedSetDt
	* Reserved Case 에는 Send Date를 구할 때, SYSDATE를 GMT로 변환하여 Event Date가 나중일 경우 Gap 만큼 더해 Date를 재 계산 함.
    * @param String event_dt
    * @param String event_node
    * @return String
	* @throws DAOException
	*/   
   public String getReservedSetDt(String event_dt, String event_node)throws DAOException {
		DBRowSet dbRowset = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		Map<String, String> mapVO = new HashMap();
			mapVO.put("event_dt", event_dt);
			mapVO.put("event_node", event_node);
		param.putAll(mapVO);
		velParam.putAll(mapVO);
		String temp = "N";
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi315SendDBDAOgetReservedSetDtRSQL(),
					param, velParam);

			if (dbRowset != null && dbRowset.next()) {
				temp = dbRowset.getString("EDI_SND_RSV_DT");
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
   
   /** 해당 COP의 VVD, Port, Calling Port Seq가 같은지 확인한다. 
	 * @param Edi315SendVO sendVo
	 * @return int
	 * @throws DAOException
	 */
	public int searchVesselClptIndSeq(Edi315SendVO sendVo) throws DAOException {

		DBRowSet dbRowset = null;
		int temp = 0;
		
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			/* 파라미터 입력 */
			Map<String, String> mapVO = sendVo.getColumnValues();

			if (mapVO != null) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new Edi315SendDBDAOsearchVesselClptIndSeqRSQL(),
							param, velParam);

			
			if(dbRowset.next()) {
				temp = dbRowset.getInt(1);
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
	
	/**getBkgRefNo 
     * @param  String bkg_no
     * @param  String bkg_ref_tp
     * @return String
	 * @throws DAOException
	 */    
    public String getBkgRefNo(String bkg_no, String bkg_ref_tp) throws DAOException{
    	DBRowSet dbRowset = null;
		 // query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		String bkg_no_1		= bkg_no;
		String bkg_ref_tp_1	= bkg_ref_tp;

		/*파라미터 입력*/ 	
		Map<String, String> mapVO = new HashMap();
		mapVO.put("e_bkg_no",bkg_no_1); 
		mapVO.put("e_bkg_ref_tp",bkg_ref_tp_1); 
	    param.putAll(mapVO);
	    velParam.putAll(mapVO);
	    String temp = "";
	    
	    	try{        	
	    		dbRowset = new SQLExecuter("").executeQuery(
						(ISQLTemplate) new Edi315SendDBDAOGetBkgRefNoRSQL(),
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
}