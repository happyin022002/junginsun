/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : Edi214ReceiveBCImpl.java
*@FileTitle : Service Scope
*Open Issues :
*Change history :
*@LastModifyDate : 2008-08-01
*@LastModifier : Y
*@LastVersion : 1.0
* 2008-08-01 Y
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.visibilitymanage.edi214receive.basic;

import java.util.HashMap;
import java.util.List;

//import com.hanjin.apps.alps.esd.sce.visibilitymanage.edi214Receive.event.EsdSce0085EventResponse;
import com.hanjin.apps.alps.esd.sce.copdetailreceive.basic.CopDetailReceiveBC;
import com.hanjin.apps.alps.esd.sce.copdetailreceive.basic.CopDetailReceiveBCImpl;

import com.hanjin.apps.alps.esd.sce.visibilitymanage.edi214receive.integration.Edi214ReceiveDBDAO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.edi214receive.vo.SearchActualDateInfoVO;
import com.hanjin.apps.alps.esd.trs.common.usa214cntrtrackingmanage.event.USA214CntrTrackingManageEvent;
import com.hanjin.apps.alps.esd.trs.common.usa214cntrtrackingmanage.basic.USA214CntrTrackingManageBC;
import com.hanjin.apps.alps.esd.trs.common.usa214cntrtrackingmanage.basic.USA214CntrTrackingManageBCImpl;
import com.hanjin.apps.alps.esd.sce.copdetailreceive.vo.CopDtlActMapgVO;

import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ENIS-SCEM EDI 214 Message
 * - ENIS-SCEM EDI 214 Message에 대한 비지니스 로직에 대한 인터페이스
 *
 * @author Yoonjung Lee
 * @see EsdSce0085Event 참조
 * @since J2EE 1.4
 */
public class Edi214ReceiveBCImpl   extends BasicCommandSupport implements Edi214ReceiveBC {
	
	// Database Access Object
	private transient Edi214ReceiveDBDAO dbDao=null;
	/**
	 * Edi214ReceiveBCImpl 생성자
	 */	
    public Edi214ReceiveBCImpl(){
        dbDao = new Edi214ReceiveDBDAO();
    }
	/**
	 * 214 MSG를 FF에서 분리 
	 * @param String str
	 * @return SearchActualDateInfoVO
	 * @throws EventException
	 */
	@SuppressWarnings("unchecked")
	public SearchActualDateInfoVO getEDI214DataFormat(String str) throws EventException {
		log.debug("IMPL - getEDI214DataFormat 시작");
		
		java.io.BufferedReader br = null;
		
		try {

			str = str.trim();

			/**
			 * hdr, CNTR_LIST, DTL로 쪼개어 담을 배열의 크기 구하기 - Table명을 나중에 DB에서 불러오게 해도 된다.
			 */
			String[] arr_search_substr= {"{HDR","{CNTR","{LOC"};
			String msgStart = null; 
			HashMap hdr 	= null;
			HashMap cntr 	= null;
			HashMap loc 	= null;

			hdr 	= new HashMap();
			cntr 	= new HashMap();
			loc 	= new HashMap();

			SearchActualDateInfoVO msgVo = new SearchActualDateInfoVO();
			
			/**
			 * hdr, cntr, LOC로 쪼개어 response에 담기
			 */			
			String buffer = null;
			String curr_blk = null;
			br = new java.io.BufferedReader(new java.io.StringReader(str));
			buffer = null;
			String[] tmp = null;
			while ((buffer=br.readLine()) != null){
				if (buffer!=null && !buffer.trim().equals("")){
					if (buffer.trim().startsWith("$$$MSGSTART:")){
						msgStart = buffer!=null&&!buffer.trim().equals("")&&buffer.length()>=("$$$MSGSTART:".length()+20)?buffer.substring(12,32).trim():"";	
					} else if (buffer.trim().startsWith("{")){
						curr_blk = buffer.trim();
					} else {
						if (curr_blk!=null && curr_blk.equals(arr_search_substr[0])){
							if ((tmp = buffer.trim().split(":"))!=null){ // && tmp.length==2){
								hdr.put(tmp[0],tmp.length==2?tmp[1]:"");
							}
						} else if (curr_blk!=null && curr_blk.equals(arr_search_substr[1]) && buffer!=null && !buffer.trim().equals(arr_search_substr[1])){
							if ((tmp = buffer.trim().split(":"))!=null){ // && tmp.length==2){
								cntr.put(tmp[0],tmp.length==2?tmp[1]:"");
							}
						} else if (curr_blk!=null && curr_blk.equals(arr_search_substr[2]) && buffer!=null && !buffer.trim().equals(arr_search_substr[2])){
							if ((tmp = buffer.trim().split(":"))!=null){ // && tmp.length==2){
								cntr.put(tmp[0],tmp.length==2?tmp[1]:"");
							}
						}
					}
				}
			}
			log.error(" ::: 214 so# : "+hdr.get("SONO"));
			if(hdr.get("SONO") == null){
				log.error("\n==========Impl 214 FF START=================================\n" +
						" WONO: "+hdr.get("WONO") +"\n" +
						" SONO: "+hdr.get("SONO") +"\n" +
						" BLNO: "+hdr.get("BLNO") +"\n" +
						" BKGNO: "+hdr.get("BKGNO") +"\n" +
						" EQNO: "+cntr.get("EQNO") +"\n" +
						" STATUS: "+cntr.get("STATUS") +"\n" +
						" STATUS_REASON: "+cntr.get("STATUS_REASON") +"\n" +
						" APP_STATUS: "+cntr.get("APP_STATUS") +"\n" +
						" APP_STATUS_REASON: "+cntr.get("APP_STATUS_REASON") +"\n" +
						" STATUS_DATE: "+cntr.get("STATUS_DATE") +"\n" +
						" STATUS_TIME: "+cntr.get("STATUS_TIME") +"\n" +
						" STATUS_TIMECODE: "+cntr.get("STATUS_TIMECODE") +"\n" +
						" E_STATE: "+cntr.get("E_STATE") +"\n" +
						" E_COUNTRY: "+cntr.get("E_COUNTRY") +"\n" +
						" STOP_SEQ: "+cntr.get("STOP_SEQ") +"\n" +
						"==========214 FF END=================================" +"\n" +
						"\n" +
						"");				
			}
			log.info("\n==========Impl 214 FF START=================================\n" +
					" WONO: "+hdr.get("WONO") +"\n" +
					" SONO: "+hdr.get("SONO") +"\n" +
					" BLNO: "+hdr.get("BLNO") +"\n" +
					" BKGNO: "+hdr.get("BKGNO") +"\n" +
					" EQNO: "+cntr.get("EQNO") +"\n" +
					" STATUS: "+cntr.get("STATUS") +"\n" +
					" STATUS_REASON: "+cntr.get("STATUS_REASON") +"\n" +
					" APP_STATUS: "+cntr.get("APP_STATUS") +"\n" +
					" APP_STATUS_REASON: "+cntr.get("APP_STATUS_REASON") +"\n" +
					" STATUS_DATE: "+cntr.get("STATUS_DATE") +"\n" +
					" STATUS_TIME: "+cntr.get("STATUS_TIME") +"\n" +
					" STATUS_TIMECODE: "+cntr.get("STATUS_TIMECODE") +"\n" +
					" E_STATE: "+cntr.get("E_STATE") +"\n" +
					" E_COUNTRY: "+cntr.get("E_COUNTRY") +"\n" +
					" STOP_SEQ: "+cntr.get("STOP_SEQ") +"\n" +
					"==========214 FF END=================================" +"\n" +
					"\n" +
					"");
			
		
			
			msgVo.setTrspWoOfcCtyCd(JSPUtil.getNull((String)hdr.get("WONO")));
			// 2010-04-20  so no가 null로 들어오는 경우 에러 발생하여 아래 null처리 하는 로직 추가 by ohk
			if(msgVo.getTrspWoOfcCtyCd() != null && msgVo.getTrspWoOfcCtyCd().length() >= 3){
				msgVo.setTrspWoOfcCtyCd((msgVo.getTrspWoOfcCtyCd()).substring(0, 3));				
			}else{
				msgVo.setTrspWoOfcCtyCd("");
			}

			log.debug("msgVo.getTrspWoOfcCtyCd == " + msgVo.getTrspWoOfcCtyCd());
			msgVo.setTrspWoSeq(JSPUtil.getNull((String)hdr.get("WONO")).length() >3 ? JSPUtil.getNull((String)hdr.get("WONO")).substring(3) : "" );
			log.debug("msgVo.getTrspWoSeq() == " + msgVo.getTrspWoSeq());
			msgVo.setTrspSoOfcCtyCd(JSPUtil.getNull((String)hdr.get("SONO")));
			// 2010-04-20  so no가 null로 들어오는 경우 에러 발생하여 아래 null처리 하는 로직 추가 by ohk
			if(msgVo.getTrspSoOfcCtyCd() != null && msgVo.getTrspSoOfcCtyCd().length() >= 3){
				msgVo.setTrspSoOfcCtyCd((msgVo.getTrspSoOfcCtyCd()).substring(0, 3));				
			}else{
				msgVo.setTrspSoOfcCtyCd("");
			}

			log.debug("msgVo.getTrspSoOfcCtyCd() == " + msgVo.getTrspSoOfcCtyCd());
			msgVo.setTrspSoSeq(JSPUtil.getNull((String)hdr.get("SONO")).length() >3 ? JSPUtil.getNull((String)hdr.get("SONO")).substring(3) : "" );
			log.debug("msgVo.getTrspSoSeq() == " + msgVo.getTrspSoSeq());
			msgVo.setBlNo(JSPUtil.getNull((String)hdr.get("BLNO")));
			log.debug("msgVo.getBlNo() == " + msgVo.getBlNo());
			msgVo.setBkgNo(JSPUtil.getNull((String)hdr.get("BKGNO")));
			log.debug("msgVo.getBkgNo() == " + msgVo.getBkgNo());
			msgVo.setCntrNo(JSPUtil.getNull((String)cntr.get("EQNO")));
			log.debug("msgVo.getCntrNo() == " + msgVo.getCntrNo());
			msgVo.setDeCondCd(JSPUtil.getNull((String)cntr.get("STATUS")));
			log.debug("msgVo.getDeCondCd() == " + msgVo.getDeCondCd());
			msgVo.setApntStsCd(JSPUtil.getNull((String)cntr.get("APP_STATUS")));
			log.debug("msgVo.getApntStsCd() == " + msgVo.getApntStsCd());
			msgVo.setRcvDt(JSPUtil.getNull((String)cntr.get("STATUS_DATE")));
			log.debug("msgVo.getRcvDt() == " + msgVo.getRcvDt());
			
			log.debug("msgVo.getRcvHr() == " + msgVo.getRcvHr());
			// 2010-04-20  time 정보가 null로 들어오는 경우 에러 발생하여 아래 null처리 하는 로직 추가 by ohk			
			if(cntr.get("STATUS_TIME") != null && ((String)cntr.get("STATUS_TIME")).length() >= 2){
				msgVo.setRcvHr(JSPUtil.getNull((String)cntr.get("STATUS_TIME")).substring(0, 2));
				
				if (((String)cntr.get("STATUS_TIME")).substring(2).equals("00")) {
					msgVo.setRcvMnt("00");
				} else {
					msgVo.setRcvMnt(JSPUtil.getNull((String)cntr.get("STATUS_TIME")).substring(2));
				}				
			}

			log.debug("msgVo.getRcvMnt() == " + msgVo.getRcvMnt());
			msgVo.setBndSeq(JSPUtil.getNull((String)cntr.get("STOP_SEQ")));
			log.debug("msgVo.getBndSeq() == " + msgVo.getBndSeq());
			
			br.close();
			return msgVo;

		} catch (Exception e){
			log.error(e.getMessage());
			try {if (br!=null)br.close();
		} catch (java.io.IOException ie){
			log.error(ie.getMessage());
			throw new EventException(ie.getMessage());
		}
			throw new EventException(e.getMessage());
		}
	}

	/**
	 * 214 Message 를 분해하여 Temp table에 Insert한다.
	 * @param SearchActualDateInfoVO msgVo
	 * @throws EventException
	 */
	public void createEDI214TmpData(SearchActualDateInfoVO msgVo) throws EventException {
		log.debug(" IMPL - createEDI214TmpData 시작");
		try {
			dbDao.createEDI214TmpData(msgVo);	
		} catch(DAOException e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		} catch(Exception e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		}
	}	

	/**
	 * 214 로직에 의해 Message 의 Validation check 후 Update 한다.
	 * @param SearchActualDateInfoVO msgVo
	 * @throws EventException
	 */
	public void confirmEDI214(SearchActualDateInfoVO msgVo) throws EventException {
		log.debug(" IMPL - confirmEDI214 시작");
		
		USA214CntrTrackingManageEvent event 	= new USA214CntrTrackingManageEvent() ;
		USA214CntrTrackingManageBC trsCommand	= new USA214CntrTrackingManageBCImpl();
		
//		String cop_seq 	= "0000"; 	// SCE_COP_DTL 의 seq. ( COP_GRP_SEQ + COP_DTL_SEQ )
		
		/* trs Event 넘기는 data start */
		String podDt 	= ""; 		// Actual 의미의 Proof of Delivery 
		String apntDt 	= ""; 		// Appointment Date TRS, SPP에서 쓰임. TRS에 Update
		String soNo 	= ""; 		// TRSP_SO_OFC_CTY_CD + TRSP_SO_SEQ
		String woNo 	= ""; 		// TRSP_WO_OFC_CTY_CD + TRSP_WO_SEQ
		String cntrNo 	= "";		// cntr#
		/* trs Event 넘기는 data end   */
		
		
		
		String podStatus 	= "";
		String appStatus 	= "";
		String stopSeq 		= "";
		String inDate 		= "";
		
		soNo 		= msgVo.getTrspSoOfcCtyCd().trim() + "" + msgVo.getTrspSoSeq().trim();
		woNo 		= msgVo.getTrspWoOfcCtyCd().trim() + "" + msgVo.getTrspWoSeq().trim();
		cntrNo 		= msgVo.getCntrNo();
		log.debug("soNo == " + soNo);
		log.debug("woNo == " + woNo);
		log.debug("cntrNo == " + cntrNo);
		
		podStatus 	= msgVo.getDeCondCd();//JSPUtil.getNull((String)cntr.get("STATUS"));
		appStatus 	= msgVo.getApntStsCd();//JSPUtil.getNull((String)cntr.get("APP_STATUS"));	// AA, AB,AC
		stopSeq		= msgVo.getBndSeq();//JSPUtil.getNull((String)cntr.get("STOP_SEQ"));
		inDate		= msgVo.getRcvDt() + "" + msgVo.getRcvHr() + "" + msgVo.getRcvMnt() + "00"; //JSPUtil.getNull((String)cntr.get("STATUS_DATE"))+JSPUtil.getNull((String)cntr.get("STATUS_TIME")).concat("00");
		log.debug("podStatus == " + podStatus);
		log.debug("appStatus == " + appStatus);
		log.debug("stopSeq == " + stopSeq);
		log.debug("inDate == " + inDate);
		
		event.setDeDt(podDt);
		event.setApntDt(apntDt);
		event.setSoNo(soNo);
		event.setWoNo(woNo);
		event.setCntrNo(cntrNo);

		
		try {


			/****  (2009-01-15)  ***************************************************
			 * 
			 * COP : sce_cop_dtl의 act_dt
			 * TRS : trs_trsp_svc_ord의 apnt_dt, de_dt 컬럼 Update.
			 * 
			 * Logic 정리
			 * --------------------------------------------------
			 * 			  	cop		trs_ApntDt	trs_DeDt 
			 * --------------------------------------------------
			 * stop_seq		2		2,3,4		2
			 * status		X1		X1
			 * app_status						AB,AC
			 * --------------------------------------------------
			 * 
			 * 만약 FlatFile에 다음과 같이 들어오면,
			 * 		.................................
			 * 		: stop_seq   : 2				:
			 * 		: status	 : X1				:
			 * 		: app_status : AB				:
			 * 		.................................
			 * cop Act_dt & TRS ApntDt,DeDt 모두 업데이트 됨.
			 * 
			 ***********************************************************************/
			
			
			/**
			 *  PoD Update 경우 
			 *   - IF 		: I/B [x1 2]- 이 경우만 SCE_COP_DTL의 ACT_DT컬럼 Update !
			 *   - ELSE IF 	: O/B [x1 3,4]
			 **/
			if(!podStatus.equalsIgnoreCase("") && podStatus.equalsIgnoreCase("X1") && stopSeq.equalsIgnoreCase("2")){
				podDt 	= inDate;
				event.setDeDt(podDt);
				
				
				//++++ COP Actual date Update로직 start !! ++++
				/*
				 * 단 하나의 cop update case
				 * SO# 로 COP# 검색하여 'FITZAD'의 Activity를 골라 copNo, copGrpSeq, copDtlSeq를 한 string으로 묶어 Return
				 *   */
				DBRowSet rowSet = new DBRowSet();
				rowSet = dbDao.validateEDI214(msgVo);					// <<<<------ 여기가 cop seq를  string으로 묶어 Return하는 method
				int cnt = rowSet.getRowCount();
				log.debug("cnt == " + cnt);
				
				String copNo = "";
				String copDtlSeq = "";
				if (rowSet.getRowCount() > 0) {
					copNo = rowSet.getString("COP_NO");
					copDtlSeq = rowSet.getString("COP_DTL_SEQ");
				}
				log.error("\n 214->create214SceIf " 
						+"\n copNo:" + copNo+" , copDtlSeq:" + copDtlSeq
						+"\n podStatus:"+podStatus+", appStatus:"+appStatus+", stopSeq:"+stopSeq+", inDate:"+inDate);

				/* CopDetailReceiveBC의 함수를 이용해 update */
				CopDetailReceiveBC receive = new CopDetailReceiveBCImpl();
				CopDtlActMapgVO mapgVo = new CopDtlActMapgVO();
				
				mapgVo.setCopNo(copNo);  
				mapgVo.setCopDtlSeq(copDtlSeq);
				mapgVo.setActDt(inDate);//일자
				mapgVo.setSoCd(msgVo.getTrspSoOfcCtyCd());
				mapgVo.setSoSeq(msgVo.getTrspSoSeq());
				log.debug("copNo == " + mapgVo.getCopNo());
				log.debug("copDtlSeq == " + mapgVo.getCopDtlSeq());
				log.debug("inDate == " + mapgVo.getActDt());
				log.debug("TrspSoOfcCtyCd == " + mapgVo.getSoCd());
				log.debug("TrspSoSeq == " + mapgVo.getSoSeq());
				
				receive.create214SceIf(mapgVo, "edi214");

				//++++ COP Actual date Update로직 end !!   ++++
				
				
			} else if(!podStatus.equalsIgnoreCase("") && podStatus.equalsIgnoreCase("X1") && (stopSeq.equalsIgnoreCase("3")||stopSeq.equalsIgnoreCase("4"))){
				podDt 	= inDate;
				event.setDeDt(podDt);
			}
			
			/**
			 *  Apnt_Dt Update 경우
			 *   - Bound 구분 현재 없음 : [ab,ac 2]
			 **/
			if(!appStatus.equalsIgnoreCase("") && stopSeq.equalsIgnoreCase("2") 
					&& (appStatus.equalsIgnoreCase("AB") || appStatus.equalsIgnoreCase("AC"))){
				// notDoor 
				apntDt 	= inDate;
				event.setApntDt(apntDt);
			} 
			
			log.info("\n\n ++++++++ edi214 ---->>>> TRS Interface Data start +++++++++++" +
					"\n getApntDt :: "+event.getApntDt() +
					"\n getDeDt   :: "+event.getDeDt() +
					"\n getSoNo   :: "+event.getSoNo() +
					"\n getWoNo   :: "+event.getWoNo() +
					"\n getCntrNo   :: "+event.getCntrNo() +
					"\n ++++++++ edi214 ---->>>> TRS Interface Data end   +++++++++++\n" +
					"");

			
			trsCommand.usa214CntrTracking(event);
			
		} catch(DAOException e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		} catch(Exception e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		}
	}	
}
