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
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi324send.integration; 

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.eqr.common.Constants;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.codsimulate.integration.CodSimulateDBDAOInsertToCodTempCSQL;
import com.hanjin.apps.alps.esd.sce.copdetailreceive.integration.CopDetailReceiveDBDAOSearchPodArrVslSkdHisTgtRSQL;
import com.hanjin.apps.alps.esd.sce.edi324send.basic.Edi324SendBCImpl;
import com.hanjin.apps.alps.esd.sce.edi324send.vo.SearchEdi324SendVO;
import com.hanjin.apps.alps.esd.sce.edi324send.vo.Edi324SendVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.vesselreport.integration.VesselReportDBDAOSearchUSIORListRSQL;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.vesselreport.vo.SearchUSIORListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.SceEdi324SndRsltVO;
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
public class Edi324SendDBDAO extends DBDAOSupport{
	
 
		

	/**
	 * searchEdi324SendTarget
    * @param SearchEdi324SendVO searchEdi324SendVO
    * @return String[]
    * @throws DAOException
    */
	public String[] searchEdi324SendTarget(SearchEdi324SendVO searchEdi324SendVO) throws DAOException {
		   String[] snddetail_info = new String[14];
		   DBRowSet dbRowset = null;
		   Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
		   Map<String, Object> velParam = new HashMap<String, Object>();
	        
	        try {
	        	if (searchEdi324SendVO != null) {
	        		Map<String, String> mapVO = searchEdi324SendVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				    log.debug("PARAM:"+ param);
				    log.debug("velParam:"+ velParam);
				}
				dbRowset = new SQLExecuter("").executeQuery(
						(ISQLTemplate) new Edi324SendDBDAOSearchEdi324SendTargetRSQL(),
						param, velParam);
				//TEST 위해서 따로 만든쿼리
//				dbRowset = new SQLExecuter("").executeQuery(
//						(ISQLTemplate) new Edi324SendDBDAOSearchEdi324SendTarget01RSQL(),
//						param, velParam);
			//	list = (List) RowSetUtil.rowSetToVOs(dbRowset,Edi324SendVO.class);
				if(dbRowset.next()){
					snddetail_info[0] = dbRowset.getString("VNDR_SEQ"); //LLOYD_VSL_NO
					snddetail_info[1] = dbRowset.getString("COP_NO");
					snddetail_info[2] = dbRowset.getString("COP_DTL_SEQ");
					snddetail_info[3] = dbRowset.getString("POL_DEP_ACT_DT");
					snddetail_info[4] = dbRowset.getString("POL_YD_CD");
					snddetail_info[5] = dbRowset.getString("VSL_CD");
					snddetail_info[6] = dbRowset.getString("SKD_VOY_NO");
					snddetail_info[7] = dbRowset.getString("SKD_DIR_CD");
					snddetail_info[8] = dbRowset.getString("BKG_NO");
					snddetail_info[9] = dbRowset.getString("CNTR_NO");
					snddetail_info[10] = dbRowset.getString("ORG_YD_CD");
					snddetail_info[11] = dbRowset.getString("DEST_YD_CD");
					snddetail_info[12] = dbRowset.getString("CRE_USR_ID");
					snddetail_info[13] = dbRowset.getString("UPD_USR_ID");
				
				}
			} catch (SQLException se) {
			
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler("select gettarget:",new String[]{}).getMessage());
			} catch (Exception ex) {
				
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler("select gettarget:",new String[]{}).getMessage());
			}
		return snddetail_info;
	}
	/**
	 * 이미 발송된 내역이 있는지 횟수를 가져온다.
	 * searchEdi324SendCount
    * @param String vndrSeq
    * @param String bkgNo
    * @param String cntrNo
    * @param String vslCd
    * @param String skdVoyNo
    * @param String skdDirCd
    * @return int
    * @throws DAOException
    */

	public int searchEdi324SendCount(String vndrSeq , String bkgNo ,String cntrNo
		    ,String vslCd ,String skdVoyNo ,String skdDirCd ) throws DAOException {
		   int max_seq  = 0;
		   DBRowSet dbRowset = null;
		   Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
		   Map<String, Object> velParam = new HashMap<String, Object>();
	        
	        try {
	        	param.put("vndr_seq", vndrSeq);
				param.put("bkg_no", bkgNo);
				param.put("cntr_no", cntrNo);	
				param.put("vsl_cd", vslCd);	
				param.put("skd_voy_no", skdVoyNo);	
				param.put("skd_dir_cd", skdDirCd);	
		
				dbRowset = new SQLExecuter("").executeQuery(
						(ISQLTemplate) new Edi324SendDBDAOSearchEdi324SendCountRSQL(),
						param, velParam);
				if(dbRowset.next()){
					max_seq = dbRowset.getInt(1);
				}
			} catch (SQLException se) {
			
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler("select gettarget:",new String[]{}).getMessage());
			} catch (Exception ex) {
				
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler("select gettarget:",new String[]{}).getMessage());
			}
		return max_seq;
	}

	/**
	 * EDI_SND_ID의 ID를 가져온다.
	 * 
    * @return String
    * @throws DAOException
    */
	public String searchEdi324EdiSndId() throws DAOException {
		   String edi_snd_id  = null;
		   String edi_current_day = null;
		   String send_count = "";
		   DBRowSet dbRowset = null;
		   DBRowSet dbRowset1 = null;
		   Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
		   Map<String, Object> velParam = new HashMap<String, Object>();
	        
	        try {
	        	dbRowset = new SQLExecuter("").executeQuery(
						(ISQLTemplate) new Edi324SendDBDAOSearchEdi324CurrnetDayRSQL(),
						param, velParam);
				if(dbRowset.next()){
					edi_current_day = dbRowset.getString(1).trim();
				}
				
				param.put("edi_current_day", edi_current_day);
				
				dbRowset = new SQLExecuter("").executeQuery(
						(ISQLTemplate) new Edi324SendDBDAOSearchEdi324EdiSndIdRSQL(),
						param, velParam);
				if(dbRowset.next()){
					send_count = dbRowset.getString(1).trim();
				}
				if (send_count.equals("")){
					send_count = "0001";
				}else {
					dbRowset1 = new SQLExecuter("").executeQuery(
							(ISQLTemplate) new Edi324SendDBDAOSearchEdi324EdiMaxSndIdRSQL(),
							param, velParam);
					
					if(dbRowset1.next()){
						log.debug("==DB 값===="  +dbRowset1.getString("MAXSNDID") );
						send_count = dbRowset1.getString("MAXSNDID").trim();
					}
					    log.debug("=====조회된 count ===" + send_count);
					 	if (send_count.length() == 1){
							send_count = "000" + send_count;
						}else if (send_count.length() == 2){
							send_count = "00" + send_count;
						}else if (send_count.length() == 3){
							send_count = "0" + send_count;
						}
				}
					
				edi_snd_id  = edi_current_day+ "-" + send_count;
			} catch (SQLException se) {
			
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler("select gettarget:",new String[]{}).getMessage());
			} catch (Exception ex) {
				
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler("select gettarget:",new String[]{}).getMessage());
			}
		return edi_snd_id;
	}

	/**
	 * EDI_324 발송을 위한 상세 정보를 가져온다.
	 * @param String copNo
	 * @param String orgYdCd
	 * @param String destYdCd
    * @return String[]
    * @throws DAOException
    */
	public String[] searchEdi324EdiSendDetailInfo(String copNo ,String orgYdCd , String destYdCd) throws DAOException {
		   String[] detail_info = new String[24];
		   DBRowSet dbRowset = null;
		   Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
		   Map<String, Object> velParam = new HashMap<String, Object>();
	        
	        try {
	        	param.put("cop_no", copNo);
	        	param.put ("org_yd_cd" , orgYdCd);
	        	param.put("dest_yd_cd", destYdCd);
				dbRowset = new SQLExecuter("").executeQuery(
						(ISQLTemplate) new Edi324SendDBDAOSearchEdi324EdiSendDetailInfoRSQL(),
						param, velParam);
				if(dbRowset.next()){
					detail_info[0] = dbRowset.getString("LLOYD_VSL_NO"); //LLOYD_VSL_NO
					detail_info[1] = dbRowset.getString("VSL_NM");
					detail_info[2] = dbRowset.getString("POD_YD_CD");
					detail_info[3] = dbRowset.getString("POD_NM");
					detail_info[4] = dbRowset.getString("ACT_CD");
					detail_info[5] = dbRowset.getString("POD_ESTM_ARR_DT");
					detail_info[6] = dbRowset.getString("POD_ESTM_ARR_GDT");
					detail_info[7] = dbRowset.getString("BL_NO");
					detail_info[8] = dbRowset.getString("CNTR_WGT");
					detail_info[9] = dbRowset.getString("CNTR_WGT_UT_CD");
					detail_info[10] = dbRowset.getString("CNTR_LBS_WGT");
					detail_info[11] = dbRowset.getString("CNTR_TPSZ_CD");
					detail_info[12] = dbRowset.getString("CNTR_LEN");
					detail_info[13] = dbRowset.getString("CNTR_HGT");
					detail_info[14] = dbRowset.getString("CNTR_SEAL_NO");
					detail_info[15] = dbRowset.getString("DG_FLG");
					detail_info[16] = dbRowset.getString("CNTR_NO");
					
					detail_info[17] = dbRowset.getString("ORG_YD_LOC_CTY_NM");
					detail_info[18] = dbRowset.getString("ORG_YD_LOC_STE_CD");
					detail_info[19] = dbRowset.getString("ORG_LOC_NM");
					detail_info[20] = dbRowset.getString("DST_YD_LOC_CTY_NM");
					detail_info[21] = dbRowset.getString("DST_YD_LOC_STE_CD");
					detail_info[22] = dbRowset.getString("DST_LOC_NM");
					
					log.debug ("=====detail_info[17]==========" + detail_info[17]);
					log.debug ("=====detail_info[17]==========" + detail_info[18]);
					log.debug ("=====detail_info[17]==========" + detail_info[19]);
					log.debug ("=====detail_info[17]==========" + detail_info[20]);
				}
			} catch (SQLException se) {
			
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler("select gettarget:",new String[]{}).getMessage());
			} catch (Exception ex) {
				
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler("select gettarget:",new String[]{}).getMessage());
			}
		return detail_info;
	}
    
	/**
	 * EDI_324 발송을 위한 상세 정보를 저장을 한다.
	 * @param SceEdi324SndRsltVO sceEdi324SndRsltVo
     * @throws DAOException
    */

	public void addSceEdi324SndRslt(SceEdi324SndRsltVO sceEdi324SndRsltVo) throws DAOException {
		int result = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if (sceEdi324SndRsltVo != null) {
        		Map<String, String> mapVO = sceEdi324SndRsltVo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			    log.debug("PARAM:"+ param);
			    log.debug("velParam:"+ velParam);
			}
			result = new SQLExecuter("").executeUpdate((ISQLTemplate)new Edi324SendDBDAOAddSceEdi324SndRsltCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert No SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
	}

	/**
	 * EDI_324 발송을 위한 상세 정보를 저장을 한다.
	 * @param SceEdi324SndRsltVO sceEdi324SndRsltVo
	 * @param String sndEdiId
	 * @param String fltFileRefNo
    * @throws DAOException
    */

	public void modifySceEdi324SndRslt(SceEdi324SndRsltVO sceEdi324SndRsltVo ,String sndEdiId, String fltFileRefNo) throws DAOException {
		int result = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if (sceEdi324SndRsltVo != null) {
        		Map<String, String> mapVO = sceEdi324SndRsltVo.getColumnValues();
        		param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("edi_snd_id1", sndEdiId);
				param.put("flt_file_ref_no", fltFileRefNo);
			    log.debug("PARAM:"+ param);
			    log.debug("velParam:"+ velParam);
			}
			result = new SQLExecuter("").executeUpdate((ISQLTemplate)new Edi324SendDBDAOModifySceEdi324SndRsltUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert No SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
	}

	/**
	 * 발송이 될 정보를 VVD 별로 정보를 가져온다.
 	* searchGetTagretVVD
    * @return List<SceEdi324SndRsltVO>
    * @throws DAOException
    */
	public List<SceEdi324SndRsltVO> searchGetTagretVVD() throws DAOException {
		 
		   List<SceEdi324SndRsltVO> list = null;
		   DBRowSet dbRowset = null;
		   Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
		   Map<String, Object> velParam = new HashMap<String, Object>();
	        
	        try {
//	        	if (searchEdi324SendVO != null) {
//	        		Map<String, String> mapVO = searchEdi324SendVO.getColumnValues();
//					param.putAll(mapVO);
//					velParam.putAll(mapVO);
//				    log.debug("PARAM:"+ param);
//				    log.debug("velParam:"+ velParam);
//				}
				dbRowset = new SQLExecuter("").executeQuery(
						(ISQLTemplate) new Edi324SendDBDAOSearchGetTagretVVDRSQL(),
						param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset,SceEdi324SndRsltVO.class);
			} catch (SQLException se) {
			
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler("select gettarget:",new String[]{}).getMessage());
			} catch (Exception ex) {
				
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler("select gettarget:",new String[]{}).getMessage());
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
					(ISQLTemplate) new Edi324SendDBDAOGetSndSeqRSQL(),
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

	/**getSndSeq 조회
	 * @param String vndrSeq
     * @return String
     * @throws DAOException
     */      
    public String searchEdi324PrnrId(String vndrSeq) throws DAOException{
    	DBRowSet dbRowset = null;
		//query parameter
    	String custTrdPrnrId = "";
		Map<String, Object> param = new HashMap<String, Object>();

        try{        	
        	param.put("vndr_seq", vndrSeq);
        	log.debug("=====조회된 count ===" + vndrSeq);
        	dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi324SendDBDAOSearchEdi324PrnrIdRSQL(),
					param, null);
        	if(dbRowset.next()){
	        	custTrdPrnrId = dbRowset.getString("CUST_TRD_PRNR_ID");
	        	log.debug("=====조회된 count ===" + custTrdPrnrId);
        	}
			return custTrdPrnrId;
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    }

}