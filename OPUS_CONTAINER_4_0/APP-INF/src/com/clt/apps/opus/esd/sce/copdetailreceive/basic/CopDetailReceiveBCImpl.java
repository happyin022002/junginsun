/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CopDetailReceiveBCImpl.java
*@FileTitle : CopDetailReceived Actual Mapping implementation
*Open Issues : 
*@Created Date : 2009-08-24
*@FirstModifier : JeongSeon An
*Change history : 
*@LastModifyDate : 2010-05-30
*@LastModifier : JeongSeon An.
*@LastVersion : 1.0  
* 1.0 최초 생성
* Called Business Methodes **********************************************************************************
* 1.[CTM 외부인터페이스] createCOPMVMT(SceActRcvIfVO actVo)
* 2.[VSK 외부인터페이스] sendVslSkdSceIf(SceActRcvIfVO actVo) <<--act_dat_rcv_dt 보완할 것!!
* 3.[322 인터페이스] create322SceIf(SceActRcvIfVO actVo)
* 4.[COP Bound Scheduling] scheduleCopDetailBound(SceCopSkdHisVO skdVo)
* 		4-1.[COP Bound Scheduling By322] scheduleCopDetailBoundBy322P 
* 5.[COP Ocean Scheduling + old)SCE_EST_ETA_VSL_PRC] scheduleCopDetailOcean(SceVpsIfVO skdVo) 
*       <==ActualDataReceiveVsl Batch call 
* 6.[MVMT(CTM) & 322 Actual Mapping] copDetailReceiveMVMT(SceActRcvIfVO actVo, String pro_flg) 
*   <-- (include) scheduleCopDetailBoundBy322P 
*       <==ActualDataReceive Batch call 
* 7.[SPP Actual Mapping] copDetailReceiveSPP 
*       <==ActualDataReceive Batch call
* 8.[VSK Actual Mapping] copDetailReceiveVessel(SceActRcvIfVO actVo, String pro_flg) 
* 		<==ActualDataReceive Batch call
* 9.[MANUAL Actual Mapping] copDetailReceiveMANUAL(String cop_no, String cop_dtl_seq, String act_dt, String usr_id, String prc_flg, String act_sts_cd, String nod_cd, String act_cd)
*       <<--sce_act_rcv_if insert 보완, replan 관련 확인 할 것!!
* 10.[REPLAN관련  Actual Mapping] copDetailReceiveREPLAN 
* 		<==ReplanManageBCImpl call
* 11.[214 외부 인터페이스, Actual Mapping] create214SceIf(SceActRcvIfVO actVo)
*       <<--sce_act_rcv_if insert 보완, replan 관련 확인 할 것!!
* 12.[Door Delivery Update](신규화면)
* 		addSceActRcvIf(actVo)<== Actual Only
* 		copDetailReceiveSPP  <== Actual Only
* 		copDetailReceiveMANUAL <== Estimate Only
* 2010.10.29 김진승 [소스결함 보완] 중첩 try문장 private 메서드로 전환 ; DAO의 throw로 인하여 try/catch OOOUnit 등 추가
* 2011.04.05 김영철 [] 메소드 주석을 기술함. ( modifyCopHeaderStatus )
* 2011.07.19 채창호 [CHM-201111830]:Split 13-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 건
* 2011.08.09 황효근 [CHM-201111381-01]Dwell Notification Management 신규개발 요청
============================================================================================================*/
  
package com.clt.apps.opus.esd.sce.copdetailreceive.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.clt.apps.opus.esd.sce.common.util.basic.CodeUtilBCImpl;
import com.clt.apps.opus.esd.sce.copdetailreceive.integration.CopDetailReceiveDBDAO;
import com.clt.apps.opus.esd.sce.copdetailreceive.vo.CopDtlActMapgVO;
import com.clt.apps.opus.esd.sce.copdetailreceive.vo.Edi315SendCopVO;
import com.clt.apps.opus.esd.sce.copdetailreceive.vo.SceActRcvHisVO;
import com.clt.apps.opus.esd.sce.copdetailreceive.vo.SceActRcvIfVO;
import com.clt.apps.opus.esd.sce.copdetailreceive.vo.SceCopSkdHisVO;
import com.clt.apps.opus.esd.sce.copdetailreceive.vo.SceVpsIfVO;
import com.clt.apps.opus.esd.sce.edi315send.basic.Edi315SendBC;
import com.clt.apps.opus.esd.sce.edi315send.basic.Edi315SendBCImpl;
import com.clt.apps.opus.esd.sce.edi315send.vo.Edi315SendVO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.ScePodArrVslSkdHisVO;



/**
 * SCE Business Logic Basic Command implementation<br>
 * Cop Detail Received Actual Mapping <br>
 * 
 * @author JeongSeon An
 * @see CopDetailReceiveDBDAO 참조
 * @since J2EE 1.6
 */
	
public class CopDetailReceiveBCImpl extends BasicCommandSupport implements CopDetailReceiveBC {
	 private transient CopDetailReceiveDBDAO dbDao = null;
	 
	/**
	 * 클래스 변수
	 */	 

	 
	/**
	 * CopDetailReceiveBCImpl 생성자
	 */
	public CopDetailReceiveBCImpl() {
		dbDao = new CopDetailReceiveDBDAO();
	}

	
	/**
	 * INSERT INTO SCE_ACT_RCV_IF : From MVMT to SCE (1row)<br>
	 * 
	 * @param SceActRcvIfVO actVo
	 * @exception EventException
	 */
	public void createCOPMVMT(SceActRcvIfVO actVo) throws EventException{

		
		//Create 1Row Interface
		actVo.setActRcvTpCd("1"); 
		if(actVo.getEdiMsgTpCd()==null||actVo.getEdiMsgTpCd().equals("")){
			/* 20100517
			 * [[Auto Flag]]
				A : Missing status automatically created by system.
				C : (International) "TS,IC,MT" Status automatically created after "VD"
					(USA domestic) "CM" Status automatically created after "CD"
				N : Once automatically created status ("A") modified by manual, "A" changed to "N"
				M : Added status.
				U : Status updated due to next status
				E : Status created by Master/Lease	
			 */
			if("A".equals(actVo.getCreTpCd())||"C".equals(actVo.getCreTpCd())||"L".equals(actVo.getCreTpCd())
			 ||"N".equals(actVo.getCreTpCd())||"M".equals(actVo.getCreTpCd())||"U".equals(actVo.getCreTpCd())
			 ||"E".equals(actVo.getCreTpCd())){
				actVo.setEdiMsgTpCd("SYSTEM");
			}else if(actVo.getCreTpCd()==null||actVo.getCreTpCd().equals("")){
				if(actVo.getCreUsrId()==null || actVo.getCreUsrId().equals("")){
			    	actVo.setCreUsrId("scesys");	
			    }else{
					if(actVo.getCreUsrId().length()>10){
						actVo.setEdiMsgTpCd(actVo.getCreUsrId().substring(0, 10));
					}else{
						actVo.setEdiMsgTpCd(actVo.getCreUsrId());
					}
			    }	
			}	
		}
	
//		addSceActRcvIf(actVo);
//		addSceSvcPtalActIfVO(actVo);
//		addSceCntrStsMsgTgtVO(actVo);	

		//Check Auto MVMT Creation
		//if(!"SYSTEM".equals(actVo.getEdiMsgTpCd()) && "1".equals(actVo.getActRcvTpCd())){
			//Search Auto MVMT; 동일 container number 의 동일 cnmv_evnt_dt 인 movement 중에서 현재 수신된 이벤트와 다른 것을 찾아온다
			List<SceActRcvIfVO> actVos = searchMvmtInclAutoCase(actVo);
			
			//Create Auto Interface
			for(int i=0; i<actVos.size(); i++){
				
				SceActRcvIfVO autoActVo = actVos.get(i);
				
				autoActVo.setActRcvTpCd("1"); 
				//20100125: EDI_MSG_TP_CD는 수신 받는 값으로 사용하기; CopDetail화면에 MVMT수신지 정보가 표시됨
//				if(autoActVo.getEdiMsgTpCd()==null){
//					if(autoActVo.getCreTpCd().equals("A")||autoActVo.getCreTpCd().equals("C")||autoActVo.getCreTpCd().equals("L")){
//						autoActVo.setEdiMsgTpCd("SYSTEM");
//					}else{
//						autoActVo.setEdiMsgTpCd(autoActVo.getCreUsrId());
//					} 
//				}				
				
				addSceActRcvIf(autoActVo);
				addSceSvcPtalActIfVO(autoActVo);
				addSceCntrStsMsgTgtVO(autoActVo);
				addSceCSMTgtEurVO(autoActVo);
			}
		//}
		
	}

	
	/**
	 * INSERT INTO SCE_ACT_RCV_IF : From MVMT to SCE (many rows) <br>
	 * 
	 * @param List<SceActRcvIfVO> actVos
	 * @exception EventException
	 */
	public void createCOPMVMT(List<SceActRcvIfVO> actVos) throws EventException{
		
		//Create Many Rows Interface
		for(int i=0; i<actVos.size(); i++){

			SceActRcvIfVO actVo = actVos.get(i);
			
			//20100125: EDI_MSG_TP_CD는 수신 받는 값으로 사용하기; CopDetail화면에 MVMT수신지 정보가 표시됨
//			if(actVo.getEdiMsgTpCd()==null){
//				if(actVo.getCreTpCd().equals("A")||actVo.getCreTpCd().equals("C")||actVo.getCreTpCd().equals("L")){
//					actVo.setEdiMsgTpCd("SYSTEM");
//				}else{
//					actVo.setEdiMsgTpCd(actVo.getCreUsrId());
//				} 
//			}			
			
			addSceActRcvIf(actVo);
			addSceSvcPtalActIfVO(actVo);
			addSceCntrStsMsgTgtVO(actVo);	
			addSceCSMTgtEurVO(actVo); //추가
			
			//Check Auto MVMT Creation
			//if(!"SYSTEM".equals(actVo.getEdiMsgTpCd()) && "1".equals(actVo.getActRcvTpCd())){
				//Search Auto MVMT; 동일 container number 의 동일 cnmv_evnt_dt 인 movement 중에서 현재 수신된 이벤트와 다른 것을 찾아온다
				List<SceActRcvIfVO> autoActVos = searchMvmtInclAutoCase(actVo);
				
				//Create Auto Interface
				for(int j=0; j<autoActVos.size(); j++){
					
					SceActRcvIfVO autoActVo = autoActVos.get(i);
					
					addSceActRcvIf(autoActVo);
					addSceSvcPtalActIfVO(autoActVo);
					addSceCntrStsMsgTgtVO(autoActVo);
					addSceCSMTgtEurVO(autoActVo);
					
				}			
			//}
			
		}
		
	}
	
	/**
	 * SEARCH AUTO MVMT : From Others MVMT <br>
	 * 
	 * @param SceActRcvIfVO searchActVo
	 * @return List<SceActRcvIfVO>
	 * @exception EventException
	 */
	public  List<SceActRcvIfVO>  searchMvmtInclAutoCase(SceActRcvIfVO searchActVo) throws EventException{
		List<SceActRcvIfVO> list = null;
		
		try {

			list=dbDao.searchMvmtInclAutoCase(searchActVo); 
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return list;		
	}	

	/**
	 * OP 가 누락된 case 에 대해 OC / VL 처리 시 OC / VL 의 movement cycle no 또는 이전 no 로 OP 를 찾는다.
	 * @param SceActRcvIfVO sceActRcvIfVO
	 * @return List<SceActRcvIfVO>
	 * @throws DAOException
	 */
	public List<SceActRcvIfVO> manageMissingOPByMvmt(SceActRcvIfVO sceActRcvIfVO) throws EventException {
		List<SceActRcvIfVO> list = null;

		try {
			list = dbDao.searchMissingOPByMvmt(sceActRcvIfVO);
			
			if (list != null && list.size() > 0) {
				for (int i = 0; i < list.size(); i ++) {
					SceActRcvIfVO tmpRow = list.get(i);
					
					tmpRow.setActRcvTpCd("1");
					
					addSceActRcvIfSetRcvDt(tmpRow);
					addSceSvcPtalActIfVO(tmpRow);
					addSceCntrStsMsgTgtVO(tmpRow);	
					addSceCSMTgtEurVO(tmpRow);
				}
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return list;
	}
	
	/**
	 * INSERT INTO SCE_ACT_RCV_IF : From MVMT to SCE (1row)<br>
	 * 
	 * @param SceActRcvIfVO actVo
	 * @return boolean
	 * @exception EventException
	 */
	public boolean addSceActRcvIf(SceActRcvIfVO actVo) throws EventException{
		boolean resultFlag=false;
		
		try {

			resultFlag=dbDao.addSceActRcvIf(actVo)>0?true:false; 
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}		
		
		return resultFlag;
	}
	
	/**
	 * INSERT INTO SCE_ACT_RCV_IF : From MVMT to SCE (1row) in case of Missing OP mapping <br>
	 * addSceActRcvIf method 와 act_dat_rcv_dt 를 parameter 로 받는지 차이만 있다.
	 * 
	 * @param SceActRcvIfVO actVo
	 * @return boolean
	 * @exception EventException
	 */
	public boolean addSceActRcvIfSetRcvDt(SceActRcvIfVO actVo) throws EventException{
		boolean resultFlag=false;
		
		try {

			resultFlag=dbDao.addSceActRcvIfSetRcvDt(actVo)>0?true:false; 
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}		
		
		return resultFlag;
	}

	/**
	 * INSERT INTO SCE_VPS_IF : From VSK to SCE (1row)<br>
	 * 
	 * @param SceActRcvIfVO actVo
	 * @return boolean
	 * @exception EventException
	 */
	public boolean addSceVpsIf(SceActRcvIfVO actVo) throws EventException{
		boolean resultFlag=false;
		
		try {

			resultFlag=dbDao.addSceVpsIf(actVo)>0?true:false; 
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}		
		
		return resultFlag;
	}
	
	/**
	 * INSERT INTO SCE_SVC_PTAL_VPS_IF : From VSK to SCE (1row)<br>
	 * 
	 * @param SceActRcvIfVO actVo
	 * @return boolean
	 * @exception EventException
	 */
	public boolean addSceSvcPtalVpsIf(SceActRcvIfVO actVo) throws EventException{
		boolean resultFlag=false;
		
		try {

			resultFlag=dbDao.addSceSvcPtalVpsIf(actVo)>0?true:false; 
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}		
		
		return resultFlag;
	}

	/**
	 * INSERT INTO SCE_ACT_TML_IF : From VSK to SCE (1row)<br>
	 * 
	 * @param SceActRcvIfVO actVo
	 * @return boolean
	 * @exception EventException
	 */
	public boolean addSceActTmlIf(SceActRcvIfVO actVo) throws EventException{
		boolean resultFlag=false;
		
		try {

			resultFlag=dbDao.addSceActTmlIf(actVo)>0?true:false; 
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}		
		
		return resultFlag;
	}
		
	/**
	 * INSERT INTO SCE_SVC_PTAL_ACT_IF : From MVMT to SCE (1row)<br>
	 * 
	 * @param SceActRcvIfVO actVo
	 * @return boolean
	 * @exception EventException
	 */
	public boolean addSceSvcPtalActIfVO(SceActRcvIfVO actVo) throws EventException{
		boolean resultFlag=false;
		
		try {

			resultFlag=dbDao.addSceSvcPtalActIfVO(actVo)>0?true:false; 
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}			
		
		return resultFlag;
	}

	/**
	 * INSERT INTO SCE_CNTR_STS_MSG_TGT : From MVMT to SCE (1row)<br>
	 * 꼭 POD / DEL 이 미국이 아니더라도, 실제 하역 / delivery 이전에 FROB (Foreign cargo Remaining On Board : 미국을 단순 경유해서 다른 나라로 가는 화물) 포함한 미국에 calling 하는
	 * VVD 를 가진 BKG 은 모두 CSM 전송 대상이 된다 : 20100623 iskim
	 * 
	 * @param SceActRcvIfVO actVo
	 * @return boolean
	 * @exception EventException
	 */
	public boolean addSceCntrStsMsgTgtVO(SceActRcvIfVO actVo) throws EventException{
		boolean resultFlag=false;
		
		try {
			if (dbDao.checkUSBndForCSM(actVo)) {
				resultFlag=dbDao.addSceCntrStsMsgTgtVO(actVo)>0?true:false;
			}	
			 
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}		
		
		return resultFlag;
	}	
	
	/**
	 * INSERT INTO SCE_ACT_RCV_IF : From VSK to SCE (1row)<br>
	 * 
	 * @param SceActRcvIfVO actVo
	 * @exception EventException
	 */
	public void sendVslSkdSceIf(SceActRcvIfVO actVo) throws EventException{

		if(actVo.getActRcvTpCd().equals("21")||actVo.getActRcvTpCd().equals("22")||actVo.getActRcvTpCd().equals("23")){

			//VSK Actual
//			addSceActRcvIf(actVo);
//			addSceSvcPtalActIfVO(actVo);
			// 20130121 By SBKIM [CHM-201222145] [SCEM] Actual Data Receiving Status 기능보완(ATA/ATB/ATD
			if ( !"".equals(actVo.getActDatRcvDt())) {
				addSceActRcvIfSetRcvDt(actVo);
			}
			else{
				addSceActRcvIf(actVo);
			}
			addSceSvcPtalActIfVO(actVo);
			
		}else if(actVo.getActRcvTpCd().equals("24")||actVo.getActRcvTpCd().equals("25")||actVo.getActRcvTpCd().equals("26")){	

			//VSK VPS IF	
			addSceVpsIf(actVo);
			addSceSvcPtalVpsIf(actVo);
			
		}else if(actVo.getActRcvTpCd().equals("27") || actVo.getActRcvTpCd().equals("72")){ /* [CHM-201323196] COP FInish 이후 315 전송방지 (actVo.getActRcvTpCd().equals("72") 추가)---------> */

			//COP TerminalChange IF
			addSceActTmlIf(actVo);

		}else if(actVo.getActRcvTpCd().equals("28")||actVo.getActRcvTpCd().equals("29")||actVo.getActRcvTpCd().equals("30")){
			
			//eSVC 최초 VPS IF 수신시
			addSceSvcPtalVpsIf(actVo);

		}	
		
		
		if(actVo.getActRcvTpCd().equals("23")) {
			// VSK 에서 ATD 가 발생하여 SCE 로 IF
			managePodArrVslSkdHis(actVo);
		}
		
	}
	
	/**
	 * TPS, TAS TRADE GROUP 에 대해서 BOOKING 에 지정된 PORT 일 경우, 미주 지역의 SKD 을 HISTORY 로 저장한다.(INSERT) - 2011.08.05
	 * @param actVo
	 */
	public void managePodArrVslSkdHis(SceActRcvIfVO actVo) {
		
		try {
			List<ScePodArrVslSkdHisVO> scePodArrVslSkdHisVO = null;
			scePodArrVslSkdHisVO = dbDao.searchPodArrVslSkdHisTgt(actVo);
			
			// 기 존재한  INTERFACEE 건 일 경우에는 SKIP
			if(scePodArrVslSkdHisVO != null && scePodArrVslSkdHisVO.size() != 0) {
				
//				dbDao.removePodArrVslSkdHis(sceActRcvIfList);
				
				for(int i=0; i < scePodArrVslSkdHisVO.size(); i++) {
					dbDao.addPodArrVslSkdHis(scePodArrVslSkdHisVO.get(i));
				}
			}
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			//throw new EventException(de.getMessage());
		}		
	}
	
	
	
	/**
	 * INSERT INTO SCE_ACT_RCV_IF : From 322 to SCE (1row)<br>
	 * 
	 * @param SceActRcvIfVO actVo
	 * @exception EventException
	 */
	public void create322SceIf(SceActRcvIfVO actVo) throws EventException{
		actVo.setActRcvTpCd("3");
		addSceActRcvIf(actVo);
		addSceSvcPtalActIfVO(actVo);
	}	
	
	/**
	 * INSERT INTO SCE_ACT_RCV_IF : From 322 to SCE (1row)<br>
	 * 
	 * @param SceActRcvIfVO actVo
	 * @param String bkgNo
	 * @exception EventException
	 */
	public void create322SceIf(SceActRcvIfVO actVo, String bkgNo) throws EventException{
		
		actVo.setActRcvTpCd("3");
//		log.error("\n==========    in create322SceIf actVo.getBkgNo()# ["+actVo.getBkgNo()+"]");
		actVo.setBkgNo(bkgNo);
//		log.error("==== after setup bkg# : ["+actVo.getBkgNo()+"]");
		addSceActRcvIf(actVo);
		addSceSvcPtalActIfVO(actVo);
		
	}	
	
	/**
	 * INSERT INTO SCE_COP_SKD_HIS : Scheduled COP Information (1row)<br>
	 * 
	 * @param SceCopSkdHisVO skdVo
	 * @exception EventException
	 */
	public void scheduleCopDetailBound(SceCopSkdHisVO skdVo)  throws EventException{
		SceCopSkdHisVO skdEditVo;
		
		try{
			//1.GAP구하기: 
			skdEditVo = searchGapDatetime(skdVo);
//			log.info("\n1.GAP구하기:["+skdEditVo.getRcvEvntGapDesc()+"]");
			if(skdEditVo.getRcvEvntGapDesc() != null && !("0").equals(skdEditVo.getRcvEvntGapDesc())){
				
				//****SetUp Scheduling Information******** 
				//2.Bound Schedule Duplication Check
				if(skdEditVo.getRcvEvntProcFlg().equals("OE") || skdEditVo.getRcvEvntProcFlg().equals("IE")){
					skdEditVo.setDupFlg("N");
				}
				//else{
				//	//skdEditVo.setDupFlg(checkDuplicationSchedule(skdEditVo));
				//}
				
	//			log.info("\n2.Bound Schedule Duplication Check :skdVo.getDupFlg():["+skdVo.getDupFlg()+"]");
				//3.Get COP Info. Before Schedule
				skdEditVo = searchCopDetailBeforeSchedule(skdEditVo);
				//4.Search Schedule Information
				if(!skdEditVo.getRcvEvntProcFlg().equals("OE") && !skdEditVo.getRcvEvntProcFlg().equals("IE")){
					if(skdEditVo.getRcvEvntProcFlg().substring(1, 1).equals("A")){
						skdEditVo = searchScheduleInformationByAct(skdEditVo);
					}else if(skdEditVo.getRcvEvntProcFlg().substring(1, 1).equals("E")){
						skdEditVo = searchScheduleInformationByVps(skdEditVo);
					}	
				}	
				//5.Search COP Header
				skdEditVo = searchCopHeader(skdEditVo);
				
				//6.Search SceCopHisKey
				if(skdEditVo.getRcvEvntProcFlg().equals("OE") || skdEditVo.getRcvEvntProcFlg().equals("IE") || skdEditVo.getDupFlg().equals("Y")){
					skdEditVo = searchSceCopSkdHisKey(skdEditVo);
				}
				
				//****CopDetail Scheduling*********
				//7.Bound의 마지막(MAX) COP Detail Seq구하기
				skdEditVo = searchMaxCopDetailByBound(skdEditVo);
				//8.Scheduling COP Detail	
				modifySceCopDetailEstmDtByBound(skdEditVo);
				
				//****Scheduling Logging*********
				//9.INSERT SCE_COP_SKD_HIS
				addSceCopSkdHis(skdEditVo);
				
			}
			/* 20121226 FX_PLN_DT Update By SBKIM------------------------------------------------------- */
			/*
			if(!"".equals(skdEditVo.getActCd())){
				if((skdEditVo.getActCd().equals("FUVMUD") || skdEditVo.getActCd().equals("FUWMUD"))){
					if("AA".equals(skdEditVo.getRcvEvntProcFlg())){
						//dbDao.updateFixPlanDate(skdEditVo);
						//dbDao.updateInlandDwellPod(skdEditVo);
						//dbDao.updateInlandDwellInboundNod(skdEditVo);
					}else{
//						log.info("FX_PLN_DT NOT UPDATE - RcvEvntProcFLG: "+skdEditVo.getRcvEvntProcFlg());
					}
				}else{
//					log.info("FX_PLN_DT NOT UPDATE - ActCd: "+skdEditVo.getActCd());
				}
			}else{
//				log.info("FX_PLN_DT NOT UPDATE - RcvEvntProcFLG: NULL");
			}
			*/	
//			log.info("\n scheduleCopDetailBound END====================================");
		}catch(Exception ee){
			log.error("\n scheduleCopDetailBound err "+ee.toString(),ee);
		}	
	}

	/**
	 * INSERT INTO SCE_COP_SKD_HIS : Scheduled COP Rail ETA Information (1row)<br>
	 * Received 322 Data
	 * 
	 * @param SceActRcvHisVO actHisVO
	 * @return String
	 * @exception EventException
	 */
	public String scheduleCopDetailBoundBy322P(SceActRcvHisVO actHisVO)  throws EventException{
		int copEvntpChk=0;;
		String rtnValue="10";
		
		try{
//			log.info("\n scheduleCopDetailBoundBy322P START====================================");
            // RTR테이블에  RR ETA컬럼 추가                                                  
            //    내용 : EDI 수신된 BNSF/UP/CN일때 COP가 Rail Interchange가 있는지 체크하여  
            //           FIRRAD가 1개이면 무조건 FIRRAD에 RAIL ETA를 COP ESTM_DT에 업데이트 하고 RR ETA at Interchange Point  
            //           FIRRAD가 2개이상 첫번째 FIRRAD에 RAIL ETA를 COP ESTM_DT에 업데이트 하고 RR ETA at Dest               
            // 2008.09.17 Outbound Rail ETA 도 처리하게 추가 2002701 ISKIM                                                    
            // 2008.10.24 BNSF/CN/UP의 EDI 322 Event "P" 추가 JSAN                                                            
			//
            //[322]P event 수신인 경우만 처리
            // P event라면; RL이벤트가 발생하고 AR이벤트가 아직 미수신 상태에서 P이벤트가 수신되었는지 체크하고 
            //              P이벤트의 RAIL ETA를 COP의 FIRRAD 및 FORRAD에 적용토록
			
			
			//1.[322]P event 수신인 경우 P이벤트의 I/B RAIL ETA를 검색
			copEvntpChk = dbDao.searchIbRailEta(actHisVO.getCopNo());
			
			//2.[322]P event 수신인 경우 P이벤트의 I/B RAIL ETA를 검색결과 없는지 체크
			if(copEvntpChk==0){
				//2-1.[322]P event 수신인 경우 P이벤트의 O/B RAIL ETA를 검색
				copEvntpChk = dbDao.searchObRailEta(actHisVO.getCopNo());
			}
			
			
			//3.Rail ETA처리
			if(copEvntpChk>0){
				if(copEvntpChk<4000 || copEvntpChk>6000){
					//3-1.[322]Actual 수신된 체크인 경우 작업변수 초기화
	                String railDestN1stEtaDt = "N";    
	                String railVndr = "NODATA";
					
//	                log.info("\n  actHisVO.getRailDestN1stEtaDt(): "+actHisVO.getRailDestN1stEtaDt()+"  actHisVO.getActCd():"+actHisVO.getActCd());
	                //EDI 수신된 Rail Company가 BNSF/UP/CN/NS인지
	                //ACT_CD = 'NS' 일 경우도 schedule 처리 추가 (20080917, iskim)
	                //3-2.[322]Actual 수신된 체크인 경우 Rail Company가 BNSF/UP/CN/NS인 수신 RAIL ETA 검색
	                if(actHisVO.getRailDestN1stEtaDt()!=null && !actHisVO.getRailDestN1stEtaDt().equals("")){
	                	railDestN1stEtaDt=actHisVO.getRailDestN1stEtaDt();
	                }
	                if(actHisVO.getActCd()!=null && !actHisVO.getActCd().equals("")){
	                	railVndr=actHisVO.getActCd();
	                }
	                
//	                log.info("\n 수신된 Rail Company = "+railVndr+" ETA = "+railDestN1stEtaDt);
	                
	                //EDI ETA 로직
                    int copItchgChk = 0;
                    int copActraChk = 0;
	                //3-3.[322]Actual 수신된 체크인 경우 Rail Company가 BNSF/UP/CN/NS인 수신 RAIL ETA 검색결과 있는지 체크
	                if(!railDestN1stEtaDt.equals("N") && !railVndr.equals("NODATA")){
	                	//3-3-1.[322]Actual 수신된 체크인 경우 Rail Company가 BNSF/UP/CN/NS인 수신 RAIL ETA 검색결과 있는 경우 COP I/B에 Rail Interchange가 있는지 체크
	                	copItchgChk = dbDao.searchCopRailItchg(actHisVO.getCopNo(),copEvntpChk);
	                	//3-3-2.[322]Actual 수신된 체크인 경우 Rail Company가 BNSF/UP/CN/NS인 수신 RAIL ETA 검색결과 있는 경우 COP FIRRAD Actual이 하나라도 있는지 체크 
	                	copActraChk = dbDao.searchCopRailActDt(actHisVO.getCopNo(),copEvntpChk);
	                	
//	                	log.info("\n Rail Interchange Count ["+copItchgChk+"] Actual Count ["+copActraChk+"]");	
	                	
	                    /* FIRRAD 또는 FORRAD 가 1개 이상이면 첫번째: COP에 Rail Interchange가 있을 때 */
	                    /* 즉 OB 이던 IB 이던 간에 Rail Ramp 에 도착한 이력이 없는 경우 : 첫번째 interchage 일 경우 만 */
	                    
	                    /* TODO : 2008.11.06 iskim : Vendor 별로 / Boundary 별로 actual date mappping
	                        OB : BNSF, UP, CN --> 마지막 FORRAD 에
	                             NS --> 최초 FORRAD 에  
	                        IB : BNSF, UP, CN --> 최초 FIRRAD 에
	                             NS --> 마지막 FIRRAD 에 
	                       RAIL ETA 를 mapping 하여 estimated date 를 재 산출 */
	             
	                    //마지막 
	                    //rail arrival activity 가 존재 (v_cop_itchg_chk >= 1) 하고 첫번째 interchange 도착 전 (v_cop_actra_chk = 0)
	                    //이거나 마지막 destination 도착 전 (v_cop_itchg_chk - 1 = v_cop_actra_chk :: 마지막 rail ramp 에 도착 이전)
	                    //3-3-5.[322]Actual 수신된 체크인 경우 Rail Company가 BNSF/UP/CN/NS인 수신 RAIL ETA 검색결과 있는 경우 F%RRAD가 1개 이상인지 체크
	                	if(copItchgChk>=1 && (copActraChk==0 || (copActraChk>0 && copItchgChk-1==copActraChk))){
//	                		log.info("\n Have Rail Interchange in cop=================");
	                        String copNoEta = "";
	                        
	                        //3-5-1.적용할 COP RAIL ETA 검색
	                        copNoEta = dbDao.searchCopRailEta(actHisVO.getCopNo(), copEvntpChk, railVndr);
//	                        log.info("\n copNoEta.substring(3,21):"+copNoEta.substring(3,21)+"  actHisVO.getCopNo():"+actHisVO.getCopNo()+"  Integer.toString(copEvntpChk):"+Integer.toString(copEvntpChk));

	                        /* EDI Actual이 Rail Interchange를 지났는지 체크 */
	                        if(copNoEta.substring(3,21).compareTo(actHisVO.getCopNo()+ Integer.toString(copEvntpChk)) > 0){
                   	
	                        	/* COP Bound Estimate Scheduling */
	                        	//6.cop detail 의 Bound Scheduling 호출
								CopDtlActMapgVO dtlMapgVO = new CopDtlActMapgVO();
								SceCopSkdHisVO skdVo = null;
//								log.info("\n  copNoEta:"+copNoEta);
//								log.info("\n  copNoEta.substring(3,17):"+copNoEta.substring(3,17)+"  copNoEta:"+copNoEta);
								dtlMapgVO.setCopNo(copNoEta.substring(3,17));
//								log.info("\n  copNoEta.substring(17, 21):"+copNoEta.substring(17, 21));
								dtlMapgVO.setCopDtlSeq(copNoEta.substring(17, 21));
//								log.info("\n  copNoEta.substring(21, 27):"+copNoEta.substring(21, 27));
								dtlMapgVO.setActCd(copNoEta.substring(21, 27));
//								log.info("\n  actHisVO.getNodCd():"+actHisVO.getNodCd());
								dtlMapgVO.setNodCd(actHisVO.getNodCd());
								skdVo = convertToSkdVo(actHisVO, dtlMapgVO);
								skdVo.setAftActDt(actHisVO.getRailDestN1stEtaDt());
								skdVo.setRcvEvntProcFlg("EE");
								scheduleCopDetailBound(skdVo);
								
//								log.info("\n railDestN1stEtaDt:"+railDestN1stEtaDt+"  actHisVO.getCntrNo():"+actHisVO.getCntrNo()+"  actHisVO.getBkgNo():"+actHisVO.getBkgNo()+"  copNoEta.substring(17, 21):"+copNoEta.substring(17, 21)+"  Integer.toString(copItchgChk):"+Integer.toString(copItchgChk)+"  copNoEta.substring(0, 3):"+copNoEta.substring(0, 3));
	                        	/* RTR ETA update rail_eta_dt,cntr_no,bkg_no,cop_dtl_seq*/
								// TARGET TABLE "SCE_RAIL_TZ_RPT" IS NOT EXIST
//								if(dbDao.modifyRtrEta(railDestN1stEtaDt, actHisVO.getCntrNo(), actHisVO.getBkgNo(), copNoEta.substring(17, 21), Integer.toString(copItchgChk),copNoEta.substring(0, 3))>0){
//									rtnValue="99";
//								}
	                        	
	                        	/* RAIL ETA HISTORY INSERT */
								//v_cntr_no_org,v_cop_itchg_chk,v_dtl_seq_tp,SUBSTR(TO_CHAR(LPAD(in_act_rcv_no, 7, 0)),1,5),SUBSTR(TO_CHAR(LPAD(in_act_rcv_no, 7, 0)),6,2)
								dbDao.addSceClmHis(railDestN1stEtaDt, actHisVO, copNoEta.substring(17, 21), Integer.toString(copItchgChk),copNoEta.substring(0, 3));
	                        	
	                        }

	                		
	                	}
	                	
	                	
	                }
	                
				}
			}
			
//			log.info("\n scheduleCopDetailBoundBy322P END====================================");
		}catch(Exception ee){
			log.error("\n scheduleCopDetailBoundBy322P err "+ee.toString(),ee);
		}	
		return rtnValue;
		
	}
	
	/**
	 * INSERT INTO SCE_COP_SKD_HIS : Scheduled COP Information (1row)<br>
	 * 
	 * @param ArrayList list
	 * @exception EventException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void scheduleCopDetailOcean(ArrayList list)  throws EventException{
//		log.info("\n 여기는 scheduleCopDetailOcean ====================================");
		
		try {		
	        if(list != null && list.size() >0){
				for(int i=0;i<list.size();i++){
					SceVpsIfVO vpsVO = new SceVpsIfVO();
					HashMap<String, Object> values = (HashMap<String, Object>)list.get(i);
					
//		          ams 중복 전송을 막기 위하여 고유의 key를 생성 한다. 080115 IHJANG
//		            Random random = new Random();
//		            long a = random.nextLong();
//		            String c = String.valueOf(a);					
	
					/*setting values into vo manually */
					vpsVO.setVpsRcvDt((String)values.get("VPS_RCV_DT"   ));
					vpsVO.setVpsRcvNo((String)values.get("VPS_RCV_NO"    ));
					vpsVO.setVslCd((String)values.get("VSL_CD"   ));
					vpsVO.setSkdVoyNo((String)values.get("SKD_VOY_NO"    ));
					vpsVO.setSkdDirCd((String)values.get("SKD_DIR_CD"   ));
					vpsVO.setVpsPortCd((String)values.get("VPS_PORT_CD"   ));
					vpsVO.setClptIndSeq((String)values.get("CLPT_IND_SEQ"    ));
					vpsVO.setVpsEvntTpCd((String)values.get("VPS_EVNT_TP_CD" ));
					vpsVO.setVpsEvntDt((String)values.get("VPS_EVNT_DT"    ));
					vpsVO.setVpsIfStsCd((String)values.get("VPS_IF_STS_CD" ));
					vpsVO.setCreUsrId((String)values.get("CRE_USR_ID"    ));
					vpsVO.setUpdUsrId((String)values.get("UPD_USR_ID" ));
					vpsVO.setDupFlg((String)values.get("DUP_FLG" ));
//					vpsVO.setEdiKeyCd(c);
					
					copDetailReceiveVSLSKD(vpsVO);
               
//	                tempVVD = vpsVO.getVslCd() + vpsVO.getSkdVoyNo() + vpsVO.getSkdDirCd();
//	                ediKey  = vpsVO.getEdiKeyCd();
	                
	                                   
	                // 20080110 EDI 전송 부분 호출
//	                if(resultV.equals("EDI_OK")){
//	                    log.info("\n VE EDI Test Start!! "); 
//	                    searchSendEDIList(tempVVD, "ETA", ediKey);
//	                }                    
//					log.info("\n VSL EVNT RESULT : " 
//							+vpsVO.getVslCd()
//							+vpsVO.getSkdVoyNo()
//							+vpsVO.getSkdDirCd()
//							+vpsVO.getClptIndSeq()
//							+"("+resultV+")");
				}
			}
			
		} catch (EventException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}

	}
	
	
	/**
	 * VSK Schedule Batch Logic
	 * 
	 * @param SceVpsIfVO vpsVO
	 * @return String
	 * @throws EventException
	 */
	public String copDetailReceiveVSLSKD(SceVpsIfVO vpsVO) throws EventException{
		String resultV ="AAAA";
		int    resultExe = 0;
		try{

			List<SceCopSkdHisVO> copSkdVOs = new ArrayList<SceCopSkdHisVO>();

			//1.Vsk Schedule을 가지고 COP Detail찾기, Gap구하기: SetUp//copNo,fmCopDtlSeq,nodCd,actCd,rcvEvntGapDesc,vlRow,trnkCop
//			log.info("\n 1.Vsk Schedule을 가지고 COP Detail찾기, Gap구하기");
			copSkdVOs = searchSceCopDetailByVVDUnit(vpsVO);

			if (copSkdVOs != null && copSkdVOs.size() != 0) {
//				log.info("\n copSkdVOs : "+copSkdVOs.size());

				vpsVO.setVpsIfStsCd("99");
				vpsVO.setErrMsg("");

				for (int i = 0; i < copSkdVOs.size(); i++) {
					SceCopSkdHisVO copSkdVO = copSkdVOs.get(i);
//					log.info("\n poong/"+i+"/:"+copSkdVO.getRcvEvntGapDesc()+"/");

					//****SetUp Scheduling Information********
					copSkdVO.setSkdRcvDt(vpsVO.getVpsRcvDt());
					copSkdVO.setActRcvNo(vpsVO.getVpsRcvNo());
					copSkdVO.setVslCd(vpsVO.getVslCd());
					copSkdVO.setSkdVoyNo(vpsVO.getSkdVoyNo());
					copSkdVO.setSkdDirCd(vpsVO.getSkdDirCd());
					copSkdVO.setSkdNodCd(vpsVO.getVpsPortCd());
					copSkdVO.setClptIndSeq(vpsVO.getClptIndSeq());
					copSkdVO.setSkdMapgCd(vpsVO.getVpsEvntTpCd());
					copSkdVO.setAftEstmDt(vpsVO.getVpsEvntDt());
					copSkdVO.setDupFlg(vpsVO.getDupFlg());
					copSkdVO.setRcvEvntProcFlg("2E");
					copSkdVO.setCreUsrId(vpsVO.getCreUsrId());
					copSkdVO.setUpdUsrId(vpsVO.getUpdUsrId());
					//Get COP Info. Before Schedule
					copSkdVO = searchCopDetailBeforeSchedule(copSkdVO);
					//Search Schedule Information
					copSkdVO = searchScheduleInformationByVps(copSkdVO);
					//Search COP Header
					copSkdVO = searchCopHeader(copSkdVO);
					//Mapping Result Init
					copSkdVO.setSkdRcvTpCd("97");
				

					//2.Cop Detail과  각Schedule(ETA/ETB/ETD) Mapping
//					log.info("\n 2.Cop Detail과  각Schedule(ETA/ETB/ETD) Mapping");
					resultExe = modifySceCopDetailEstmDtByOceanUnit(copSkdVO); 
					if(resultExe>0){
						copSkdVO.setSkdRcvTpCd("99");
					}else{
						copSkdVO.setSkdRcvTpCd("21");
						copSkdVO.setErrMsg("Mapping Fail");
					} 
					
					if(copSkdVO.getRcvEvntGapDesc() != null && !copSkdVO.getRcvEvntGapDesc().equals("")){

//						////@TO-BE TEST!!!//3.Estimate Vessel Schedule Delay Exception 호출; cop_no, cop_dtl_seq, estm_gap, skd_dt
//						dbDao.addSceExceptionVSL(copSkdVO.getCopNo(), copSkdVO.getFmCopDtlSeq(), copSkdVO.getRcvEvntGapDesc(), copSkdVO.getAftEstmDt());
					

						//4.Estimate GAP이 발생한  ETB or ETA 
						if(copSkdVO.getSkdMapgCd().equals("ETB")){
							
							if(copSkdVO.getTrnkCop().equals("N")){
							//4-1.현재 매핑할 VVD가 Trunk기준 nextVVD: I/B 끝까지 GAP만큼 밀기
								resultExe = modifySceCopDetailEstmDtToINBNDByOceanUnit(copSkdVO);; 
								if(resultExe<0) copSkdVO.setSkdRcvTpCd("92");
								
							}else if(copSkdVO.getTrnkCop().compareTo(copSkdVO.getCopNo()+copSkdVO.getFmCopDtlSeq())>0 ){
							//4-2.현재 매핑할 VVD가 Trunk기준 preVVD : Trunk VL전(before)까지 GAP만큼 밀기
								resultExe = modifySceCopDetailEstmDtToVLByOceanUnit(copSkdVO);
								if(resultExe<0) copSkdVO.setSkdRcvTpCd("91");
								
							}
						}
//						log.info("\n copSkdVO.getSkdMapgCd(): "+copSkdVO.getSkdMapgCd());
						//5.Estimate GAP이 발생한  ETD
						if(copSkdVO.getSkdMapgCd().equals("ETD")){
							//5-1.COP의 VL Activity를 찾아서 ETD기준의 시간으로 재Schedule sce_cop_skd_lgc_cal_fnc 함수를 참조
//							log.info("\n 5-1.COP의 VL Activity를 찾아서 ETD기준의 시간으로 재Schedule sce_cop_skd_lgc_cal_fnc 함수를 참조");
							resultExe = modifySceCopDetailVLScheduleByOceanUnit(copSkdVO);
//							log.info("\n modifySceCopDetailVLScheduleByOcean");
							if(resultExe<0) copSkdVO.setSkdRcvTpCd("93");
							
						}
						
					}	

			
					//6.COP Schedule History추가
					addSceCopSkdHisUnit(copSkdVO, vpsVO);

					//***SetUP Mapping Result***********************	
					vpsVO.setVpsIfStsCd(copSkdVO.getSkdRcvTpCd());
					
				}	//for	
				
			}else{
				//NO_DATA_FOUND
//				log.info("\n NO_DATA_FOUND :"+vpsVO.getVpsRcvDt()+", "+vpsVO.getVpsRcvNo());
				vpsVO.setVpsIfStsCd("20");
				vpsVO.setErrMsg("NO_DATA_FOUND");
				
			}
			
			//7.Mapping Result 저장
			modifySceVpsIfByResultUnit(vpsVO);
						
			
			/**------------------------------------------------------------------------------------------------------------------- **/ 
			/**--CURSOR 2 : COP POL Info  **/ 
			/** 1. I/F ETA VSL로 찾은 Rail Return Time이 존재하는 COP의                                                     **/ 
			/** 2. POL이 I/F ETA SKD의 LOCATION과 같은 것 찾아서                                                            **/ 
			/** 3. (MAX_IF_ETA_DT vs NOW_IF_ETA_DT)GAP을 구해서 더한 Rail Return Time의 'DD'날짜 변경이 생긴 경우만         **/ 
			/** 4. HDR테이블에 변경될 Rail Return Time을 리턴                                                               **/ 
			/**------------------------------------------------------------------------------------------------------------------- **/ 
			//8.Rail Receiving Date에 ETA 반영:20100426이전
			//dbDao.modifySceCopHdrRailRCVDT(vpsVO);			

			
		}catch (Exception de) {
			log.error("\n err "+de.toString(),de);
			//throw new EventException(de.getMessage());
		}
		
        if(vpsVO.getVpsEvntTpCd().equals("ETA")||vpsVO.getVpsEvntTpCd().equals("ETD")){

        	String checkLastVvdDt = "";
        	DBRowSet dbRowset = null;
	        
//	        log.info("\n  ");      
	        try {
	            	// POD 지역에 도착하는 ETA/ETD 경우에 EDI로 'VE' 전송이력을 확인
	        	    boolean ediSndRslt = dbDao.searchEdiSendRsltVeSts(vpsVO);
	        	
	            	//입력받은 vvd의 기받은 날짜를 비교하기 위해서 
	            	checkLastVvdDt = searchLastVvdDtUnit(vpsVO);
	            	
//	            	log.info("\n checkLastVvdDt ["+checkLastVvdDt+"]");
 
	            	if (!ediSndRslt	||
	            		(
	            				ediSndRslt && (checkLastVvdDt == null || checkLastVvdDt.compareTo(vpsVO.getVpsEvntDt().substring(0, 8))!= 0)
	            		)) {
	                	
						Edi315SendBC edi315 = new Edi315SendBCImpl();
	                	
	                	//POD 지역에 도착하는 ETA 정보를 EDI로 전송 하기 위한 보완 사항
	                	dbRowset = dbDao.searchEdiVED(vpsVO);
	                	
						while(dbRowset.next()){
							Edi315SendVO edi315VO = new Edi315SendVO();
						
							edi315VO.setCallFrom("COP");
							edi315VO.setCntrNo(dbRowset.getString("cntr_no"));
							edi315VO.setEdiStatus(dbRowset.getString("edi_sts"));
							edi315VO.setBlNo("");
							edi315VO.setBkgNo(dbRowset.getString("bkg_no"));
							//edi315VO.setCurrVvd(vpsVO.getVslCd()+vpsVO.getSkdVoyNo()+vpsVO.getSkdDirCd());
							if(vpsVO.getVslCd().length()>0 && vpsVO.getSkdVoyNo().length()>0 && vpsVO.getSkdDirCd().length()>0){
								edi315VO.setCurrVvd(vpsVO.getVslCd()+vpsVO.getSkdVoyNo()+vpsVO.getSkdDirCd());
							}else{
								edi315VO.setCurrVvd("");
							}
//							log.info("\n VSL SKD:: edi315VO.getCurrVvd()"+edi315VO.getCurrVvd()+"------------------------------");
							edi315VO.setEventDt(vpsVO.getVpsEvntDt());
							edi315VO.setEventYard(dbRowset.getString("nod_cd"));
//							log.info("\n VSL SKD:: edi315VO.getEventYard()"+edi315VO.getEventYard()+"------------------------------");
							edi315VO.setCreId(vpsVO.getCreUsrId());
							edi315VO.setUpdId(vpsVO.getUpdUsrId());
							edi315VO.setCopNo(dbRowset.getString("cop_no")); // yjlee추가 2010.02.25
							edi315VO.setCopDtlSeq(dbRowset.getString("cop_dtl_seq"));
//							log.info("\n VSL SKD:: edi315VO.getCopDtlSeq()"+edi315VO.getCopDtlSeq()+"------------------------------");
							
							edi315SendUnit(edi315, edi315VO);
							
							resultV = "EDI_OK";
	                	
						}
	                }

			} catch (DAOException de) {
				log.error("\n DAOException err "+de.toString(),de);
				//throw new EventException(de.getMessage());
			} catch (Exception de) {
				log.error("\n SQLException err "+de.toString(),de);
				//throw new EventException(e2.getMessage(),e2);				
			}
		}
        
		return resultV;
		
	}	

	/**
	 * 
	 * @param vpsVO
	 * @return
	 */
	private List<SceCopSkdHisVO> searchSceCopDetailByVVDUnit(SceVpsIfVO vpsVO) {
		List<SceCopSkdHisVO> copSkdVOs = null;
		try {
			copSkdVOs = dbDao.searchSceCopDetailByVVD(vpsVO);
		} catch (Exception e) {
			copSkdVOs = null;
			log.error("\n SQLException err "+e.toString(),e);
		}
		return copSkdVOs; 
	}


	/**
	 * 
	 * @param vpsVO
	 * @return
	 */
	private String searchLastVvdDtUnit(SceVpsIfVO vpsVO) {
		String checkLastVvdDt = null;
    	try { 
    		checkLastVvdDt = dbDao.searchLastVvdDt(vpsVO);
    	} catch (Exception e) {
    		checkLastVvdDt = null;
    		log.error("\n SQLException err "+e.toString(),e);
		}
		return checkLastVvdDt;
	}

	/**
	 * 
	 * @param vpsVO
	 */
	private void modifySceVpsIfByResultUnit(SceVpsIfVO vpsVO) {
		try {
			dbDao.modifySceVpsIfByResult(vpsVO);
		} catch (DAOException de) {
			log.error("error : " + de.getMessage()); 
		}
	}

	/**
	 * 
	 * @param copSkdVO
	 * @return
	 */
	private int modifySceCopDetailVLScheduleByOceanUnit(SceCopSkdHisVO copSkdVO) {
		int resultExe = 0;  
		try {
			resultExe = dbDao.modifySceCopDetailVLScheduleByOcean(copSkdVO);
		} catch (Exception e) {
			resultExe = 0; 
			log.error("\n SQLException err "+e.toString(),e);
		}
		return resultExe;
	}

	/**
	 * 
	 * @param copSkdVO
	 * @return
	 */
	private int modifySceCopDetailEstmDtToVLByOceanUnit(SceCopSkdHisVO copSkdVO) {
		int resultExe = 0;  
		try {
			resultExe = dbDao.modifySceCopDetailEstmDtToVLByOcean(copSkdVO);
		} catch (Exception de) {
			resultExe = 0;
			log.error("\n SQLException err "+de.toString(),de);
		}
		return resultExe;
	}

	/**
	 * 
	 * @param copSkdVO
	 * @return
	 */
	private int modifySceCopDetailEstmDtToINBNDByOceanUnit(SceCopSkdHisVO copSkdVO) {
		int resultExe = 0; 
		try { 
			resultExe = dbDao.modifySceCopDetailEstmDtToINBNDByOcean(copSkdVO);
		} catch (Exception de) {
			resultExe = 0;
			log.error("\n SQLException err "+de.toString(),de);
		}
		return resultExe;
	}

	/**
	 * 
	 * @param copSkdVO
	 * @return
	 */
	private int modifySceCopDetailEstmDtByOceanUnit(SceCopSkdHisVO copSkdVO) {
		int resultExe = 0; 
		try { 
			resultExe = dbDao.modifySceCopDetailEstmDtByOcean(copSkdVO);
		} catch (Exception de){
			resultExe = 0;
			log.error("\n SQLException err "+de.toString(),de);
		}
		return resultExe; 
	}

	/**
	 * 
	 * @param edi315
	 * @param edi315VO
	 */
	private void edi315SendUnit(Edi315SendBC edi315, Edi315SendVO edi315VO) {
		try{
			edi315.edi315Send(edi315VO);
		}catch(Exception e){
			log.error("\n [edi315.edi315Send(edi315VO)호출  에러]"+ e.getMessage());
		}
	}

	/**
	 * 
	 * @param copSkdVO
	 * @param vpsVO
	 */
    private void addSceCopSkdHisUnit(SceCopSkdHisVO copSkdVO, SceVpsIfVO vpsVO) {
		try{
			dbDao.addSceCopSkdHis(copSkdVO);
		}catch (Exception de) {
			log.error("\n COP Schedule History추가 error :"+vpsVO.getVpsRcvDt()+", "+vpsVO.getVpsRcvNo());
		}
	}

    /**
     * EDI 정보를 전송한다.
     * 
     * @param String ediDataString
     * @throws EventException
     */
    public void sendEDIInfo(String ediDataString) throws EventException{
    }
	
	/**
	 * Search EstimateDate GAP : From Before EstimateDate to After EstimateDate (1row)<br>
	 * 
	 * @param SceCopSkdHisVO skdVo
	 * @return SceCopSkdHisVO
	 * @exception EventException
	 */
	public SceCopSkdHisVO searchGapDatetime(SceCopSkdHisVO skdVo) throws EventException{
		String resultGap=null;
		
		try {
			resultGap = dbDao.searchGapDatetime(skdVo);
			skdVo.setRcvEvntGapDesc(resultGap);
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}		
		
		return skdVo;
	}

	/**
	 * SetUp Scheduling Information : Get COP Info. Before Schedule <br>
	 * 
	 * @param SceCopSkdHisVO skdVo
	 * @return SceCopSkdHisVO
	 * @exception EventException
	 */
	public SceCopSkdHisVO searchCopDetailBeforeSchedule(SceCopSkdHisVO skdVo) throws EventException{
		SceCopSkdHisVO skdEdtVo=null;
		
		try {

			skdEdtVo = dbDao.searchCopDetailBeforeSchedule(skdVo); 
			
		} catch (DAOException de) {
			log.error("\n searchCopDetailBeforeSchedule error: "+de.toString(),de);
			//throw new EventException(de.getMessage());
		}
		
		return skdEdtVo;
	}	

	/**
	 * SetUp Scheduling Information : By Actual Action (1row)<br>
	 * 
	 * @param SceCopSkdHisVO skdVo
	 * @return SceCopSkdHisVO
	 * @exception EventException
	 */
	public SceCopSkdHisVO searchScheduleInformationByAct(SceCopSkdHisVO skdVo) throws EventException{
		SceCopSkdHisVO skdEdtVo=null;
		
		try {

			skdEdtVo = dbDao.searchScheduleInformationByAct(skdVo); 
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}				
		
		return skdEdtVo;		
	}	

	/**
	 * SetUp Scheduling Information : By Vps Action (1row)<br>
	 * 
	 * @param SceCopSkdHisVO skdVo
	 * @return SceCopSkdHisVO
	 * @exception EventException
	 */
	public SceCopSkdHisVO searchScheduleInformationByVps(SceCopSkdHisVO skdVo) throws EventException{
		SceCopSkdHisVO skdEdtVo=null;
		
		try {

			skdEdtVo = dbDao.searchScheduleInformationByVps(skdVo); 
			
		} catch (DAOException de) {
			log.error("\n searchScheduleInformationByVps error: "+de.toString(),de);
			throw new EventException(de.getMessage());
		}				
		
		return skdEdtVo;				
	}	

	/**
	 * SetUp Scheduling Information : Search COP Header (1row)<br>
	 * 
	 * @param SceCopSkdHisVO skdVo
	 * @return SceCopSkdHisVO
	 * @exception EventException
	 */
	public SceCopSkdHisVO searchCopHeader(SceCopSkdHisVO skdVo) throws EventException{
		SceCopSkdHisVO skdEdtVo=null;
		
		try {

			skdEdtVo = dbDao.searchCopHeader(skdVo); 
			
		} catch (DAOException de) {
			log.error("\n searchCopHeader error: "+de.toString(),de);
			//throw new EventException(de.getMessage());
		}				
		
		return skdEdtVo;				
	}	

	/**
	 * SetUp Scheduling Information : Search SceCopHisKey (1row)<br>
	 * 
	 * @param SceCopSkdHisVO skdVo
	 * @return SceCopSkdHisVO
	 * @exception EventException
	 */
	public SceCopSkdHisVO searchSceCopSkdHisKey(SceCopSkdHisVO skdVo) throws EventException{
		SceCopSkdHisVO skdEdtVo=null;
		
		try {

			skdEdtVo = dbDao.searchSceCopSkdHisKey(skdVo); 
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}				
		
		return skdEdtVo;				
	}	

	/**
	 * CopDetail Scheduling : Bound의 마지막(MAX) COP Detail Seq구하기 <br>
	 * 
	 * @param SceCopSkdHisVO skdVo
	 * @return SceCopSkdHisVO
	 * @exception EventException
	 */
	public SceCopSkdHisVO searchMaxCopDetailByBound(SceCopSkdHisVO skdVo) throws EventException{
		SceCopSkdHisVO skdEdtVo=null;
		
		try {

			skdEdtVo = dbDao.searchMaxCopDetailByBound(skdVo); 
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}				
		
		return skdEdtVo;				
	}	

	/**
	 * CopDetail Scheduling : Scheduling COP Detail <br>
	 * 
	 * @param SceCopSkdHisVO skdVo
	 * @return boolean
	 * @exception EventException
	 */
	public boolean modifySceCopDetailEstmDtByBound(SceCopSkdHisVO skdVo) throws EventException{
		
		boolean resultFlag=false;
		
		try {

			resultFlag=dbDao.modifySceCopDetailEstmDtByBound(skdVo)>0?true:false; 
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}		
		
		return resultFlag;		
		
	}		
	
	/**
	 * INSERT INTO SCE_COP_SKD_HIS : Scheduling Log (1row)<br>
	 * 
	 * @param SceCopSkdHisVO skdVo
	 * @return boolean
	 * @exception EventException
	 */
	public boolean addSceCopSkdHis(SceCopSkdHisVO skdVo) throws EventException{
		boolean resultFlag=false;

		try {

			resultFlag=dbDao.addSceCopSkdHis(skdVo)>0?true:false; 
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}		
		
		return resultFlag;
	}	
	
	/**
	 * MVMT(CTM) & 322 Actual Mapping<br>
	 * [참고!!EDI_SND_RSLT_FLG='Y'는 SCE_EDI_DOCUMENT_PRC에서]
	 * 
	 * @param SceActRcvIfVO actVo
	 * @param String pro_flg
	 * @exception EventException
	 */
	public void copDetailReceiveMVMT(SceActRcvIfVO actVo, String pro_flg) throws EventException{
		Edi315SendBC edi315 = new Edi315SendBCImpl();
//		Edi315SendVO edi315VO = new Edi315SendVO();
		String errCd = "00";
		String copNos = null;
		String actSts = "";
		String dtlSeq = "";
		boolean resultUpd = false;
		actVo.setActUmchTpCd("99");
		String railInterchangeFlag  = "N"  ;	// CHM-201324593 : Added
		
		List<SceActRcvHisVO> actHisLists = new ArrayList<SceActRcvHisVO>(); // CHM-201324593 : Added : SceActRcvHisVO 에 Rail Interchage 관련 변수 추가  String railItchgFlg

		
		if(pro_flg.equals("BATCH")){
			/*참고)    --'MT REPO' 로 들어오는 322 DATA는 로직을 타지 않는다. 
    if  in_bkg_no = 'EMPTY REPO' then
        v_act_umch_tp_cd := '80';                
        v_message        := '로직 대상 아님(SKIP) ';
        DBMS_OUTPUT.PUT_LINE('로직 대상 아님(SKIP)');     
        raise user_define_error;
    end if;*/
			//0.미주 322 Rail 정보의 보정을 위한 logic<--Edi322Receive로직에서 처리하고 322Mapping시 에도 
			if(actVo.getActStsMapgCd().equals("RL")
			 ||actVo.getActStsMapgCd().equals("AR")
			 ||actVo.getActStsMapgCd().equals("UR")
			 ||actVo.getActStsMapgCd().equals("AL")
			 ||actVo.getActStsMapgCd().equals("P")
			 ||actVo.getActStsMapgCd().equals("A")		// CHM-201324593 : Added 
			 ||actVo.getActStsMapgCd().equals("J")		// CHM-201324593 : Added 
			 ||actVo.getActStsMapgCd().equals("P")		// CHM-201324593 : Added 
			 ||actVo.getActStsMapgCd().equals("R")		// CHM-201324593 : Added 
			 ){
				
				//actVo = searchUS322Moderate(actVo);
				
				if(actVo.getBkgNo()==null||actVo.getCntrNo()==null||actVo.getBkgNo().equals("")||actVo.getCntrNo().equals("")){
					//Error 코드 정리
					actVo.setActUmchTpCd("50");
					errCd = "02";
					actVo.setErrMsg("해당 CNTR 관련 COP 조회 결과 없음 (CNTR NO 12자리)");
					
					//Error 종료 처리+Sce Act Rcv If 결과 업데이트
					modifySceActRcvIfByError(actVo);
				}	
			}					
		}	
		
		if(!actVo.getActUmchTpCd().equals("50")||pro_flg.equals("REPLAN")){
		
		
			//1.관련 COP갯수 체크하여 FCL or LCL COP에 따른 BKG No.획득
			if (pro_flg != null && pro_flg.equals("REPLAN")){
				actHisLists = searchBkgNoByBkgNCntr(actVo);
			}else{
				actHisLists = searchBkgNoByLCLCOP(actVo);
			}
	
			if(actHisLists == null || actHisLists.size() == 0){
				
				actVo.setActUmchTpCd("10");
				errCd = "02";
				actVo.setErrMsg("CNTR 관련 COP 없음");
				
				//Error 종료 처리 : Sce Act Rcv If 결과 업데이트
				modifySceActRcvIfByError(actVo);
				
			}else{	// if(actHisLists != null || actHisLists.size() > 0){

				if (pro_flg.equals("REPLAN")) {
					SceActRcvHisVO tmpVO = actHisLists.get(0);
					actHisLists = new ArrayList <SceActRcvHisVO> ();
					actHisLists.add(tmpVO);
					
				}
				//COP NO 없을 경우하여, BKG No 대신 B/L No 로 재검색
				for(int i = 0; i < actHisLists.size(); i++){
					SceActRcvHisVO actHisVO = actHisLists.get(i);

					if(actHisVO.getCopNo()==null || actHisVO.getCopNo().equals("")){
						actHisVO = searchBlNoByLCLCOP(actHisVO.getBkgNo(), actHisVO.getCntrNo());
						actHisLists.set(i, actHisVO);
					}	
				}
								
				//LCL 화물의 경우, 여러 BKG별 Loop를 돌면서 각 상태값을 변경하는 작업을 시작한다
				for (int i = 0; i < actHisLists.size(); i++) {
					SceActRcvHisVO actHisVO = actHisLists.get(i);
					//h.bkg_no, h.cntr_no, h.cop_no, h.mst_cop_no, h.cntr_tpsz_cd, bl_no
					//1-1.***SetUP (FCL or LCL COP에 따른 BKG No.등)*************
					actHisVO.setActRcvDt(actVo.getActRcvDt());
					actHisVO.setActRcvNo(actVo.getActRcvNo());
					actHisVO.setActDt(actVo.getActDt());
					actHisVO.setActGdt(actVo.getActGdt());
					actHisVO.setActStsMapgCd(actVo.getActStsMapgCd());
					actHisVO.setNodCd(actVo.getNodCd());
					actHisVO.setActRcvTpCd(actVo.getActRcvTpCd());
					actHisVO.setVslCd(actVo.getVslCd());
					actHisVO.setSkdVoyNo(actVo.getSkdVoyNo());
					actHisVO.setSkdDirCd(actVo.getSkdDirCd());
					actHisVO.setClptIndSeq(actVo.getClptIndSeq());
					actHisVO.setVpsPortCd(actVo.getVpsPortCd());
					actHisVO.setEdiMsgTpCd(actVo.getEdiMsgTpCd());
					actHisVO.setErrMsg(actVo.getErrMsg());
					actHisVO.setEmlSndRsltFlg(actVo.getEmlSndRsltFlg());
					actHisVO.setEdiSndRsltFlg(actVo.getEdiSndRsltFlg());
					actHisVO.setFaxSndRsltFlg(actVo.getFaxSndRsltFlg());
					actHisVO.setVndrSeq(actVo.getVndrSeq());
					actHisVO.setActCd(actVo.getActCd());
					actHisVO.setActUmchTpCd(actVo.getActUmchTpCd());
					actHisVO.setUmchChkDt(actVo.getUmchChkDt());
					actHisVO.setRailDestN1stEtaDt(actVo.getRailDestN1stEtaDt());
					actHisVO.setBndVskdSeqCd(actVo.getBndVskdSeqCd());
					actHisVO.setCreTpCd(actVo.getCreTpCd());
					actHisVO.setCreUsrId(actVo.getCreUsrId());
					actHisVO.setCreDt(actVo.getCreDt());
					actHisVO.setUpdUsrId(actVo.getUpdUsrId());
					actHisVO.setUpdDt(actVo.getUpdDt());
					actHisVO.setCxSndFlg("N");
//					log.info("\n actVo.getActCd():"+actVo.getActCd());
//					log.info("\n actVo.getRailDestN1stEtaDt():"+actVo.getRailDestN1stEtaDt());
//					log.info("\n actHisVO.getActCd():"+actHisVO.getActCd());
//					log.info("\n actHisVO.getRailDestN1stEtaDt():"+actHisVO.getRailDestN1stEtaDt());
					actHisVO.setActCd(actVo.getActCd());
					actHisVO.setRailDestN1stEtaDt(actVo.getRailDestN1stEtaDt());
					// 2011.05.09 권상준 추가 CHM-201110244-01
					actHisVO.setPodNodCd(actHisLists.get(i).getPodNodCd());
					
					// 20130820 Inland Dwell 수정 
					actHisVO.setCntrTpszCd(actHisLists.get(i).getCntrTpszCd());
					// CHM-201324593 : Added 
					// Interchage Node 인지를 검사한다
					if( i == 0 ){
							
						if(
							( actHisVO.getCopNo() != null && !actHisVO.getCopNo().equals("") && actHisVO.getActRcvTpCd().equals("3") )
							&&
							(
							  actVo.getActStsMapgCd().equals("A") || actVo.getActStsMapgCd().equals("J") || actVo.getActStsMapgCd().equals("UR") ||   
						      actVo.getActStsMapgCd().equals("P") || actVo.getActStsMapgCd().equals("R") || actVo.getActStsMapgCd().equals("AL")   
							)
						)
						{
							railInterchangeFlag = checkRailInterchange(actHisVO) ;						
						}
						else
						{
							railInterchangeFlag = "N" ;
						}
					}

					actHisVO.setRailItchgFlg(railInterchangeFlag);  
					/* <______________________________________________________________ CHM-201324593 : Added */
					
					//획득한 BKG No.중 COP없는 것은 err 코드 정리<--이런 경우 없다!!Test 용******************
					if(actHisVO.getCopNo() == null || actHisVO.getCopNo().equals("")){
						actVo.setActUmchTpCd("10");
						errCd = "02";
						actVo.setErrMsg("CNTR 관련 COP 없음");
						actHisVO.setActUmchTpCd(actVo.getActUmchTpCd());
						actHisVO.setErrMsg(actVo.getErrMsg());
//						log.info("\n CNTR 관련 COP 없음===================== ");
					}
					//********************************************************************************
					else if(actHisVO.getActRcvTpCd().equals("3") && actVo.getActStsMapgCd().equals("P") && actHisVO.getRailItchgFlg().equals("N") ){ /* CHM-201324593 : Modified */
					

						//11.Rail ETA처리, P event 수신인지 체크
			            // P event라면; RL이벤트가 발생하고 AR이벤트가 아직 미수신 상태에서 P이벤트가 수신되었는지 체크하고
			            //              P이벤트의 RAIL ETA를 COP의 FIRRAD 및 FORRAD에 적용토록 						
							
						actHisVO.setActUmchTpCd(scheduleCopDetailBoundBy322P(actHisVO));
						
						actVo.setActUmchTpCd("30");
						actVo.setErrMsg("Node can not be found in COP");
						//Error 종료 처리 : Sce Act Rcv If 결과 업데이트
						modifySceActRcvIfByError(actVo);
					}
					// CHM-201324593 : Added _________________________________________________________________> 
					else if  
						( 
							( actHisVO.getRailItchgFlg().equals("N") )
							&&
							( actHisVO.getActRcvTpCd().equals("3") )
							&&
							(
							  actVo.getActStsMapgCd().equals("A") || actVo.getActStsMapgCd().equals("J") || 
						      actVo.getActStsMapgCd().equals("R")  
							)
						)
					{
						/* A,J,R 은 rail Intercahge 에서 만 사용 */
						
						actVo.setActUmchTpCd("31");
						actVo.setErrMsg("Non-rail interchage 322 (A,J,R)");
						modifySceActRcvIfByError(actVo);	
					} 
					// <______________________________________________________________ CHM-201324593 : Added 
					else if(actHisVO.getActRcvTpCd().equals("1")||actHisVO.getActRcvTpCd().equals("3")){
						
						// CHM-201324593 : Added ______________________________________________________________> 
						if( actHisVO.getActRcvTpCd().equals("3") && actVo.getActStsMapgCd().equals("P") ){
							actHisVO.setActUmchTpCd(scheduleCopDetailBoundBy322P(actHisVO));
						}
						// <______________________________________________________________ CHM-201324593 : Added 
						
						//3.MVMT 동일국가에서  OP,MT일 경우, COP Detail 의   Node 변경
						if(actHisVO.getActStsMapgCd().equals("OP")||((actHisVO.getActStsMapgCd().equals("MT")||actHisVO.getActStsMapgCd().equals("XX"))&& !actVo.getBkgNo().equals(""))){
							modifyCOPNodeByMVMT(actHisVO);
						}
						
						//4.DTL의 ACT STS가 'C'인 경우만 검색
						CopDtlActMapgVO dtlMapgVO = new CopDtlActMapgVO();
						dtlMapgVO = searchCopDetailCurrentStatus(actHisVO);  // CHM-201324593 : Modified  :  b.rail_itchg_flg	 = NVL(@[rail_itchg_flg],'N')  조건 추가 
						//log.info("\n dtlMapgVO.getCopNo():"+dtlMapgVO.getCopNo());
						//ACT STS가 'C'인 경우
						if(dtlMapgVO.getCopNo()!=null){
							log.info("\n ACT STS가 'C'인 경우");
							//@to-do dtlMapgVO-->actHisVO&actVO!!!!!!!!!!!!!!!!!!!!
							
							//4-1.US rail MVMT data skip 체크:EN/IC/OC/TN인 경우 ERR코드 정리
			                //[MVMT]US rail Mvmt data skip 체크:EN/IC/OC/TN인 경우 goto point_1
							if((dtlMapgVO.getActCd().endsWith("FORRDO")
									|| dtlMapgVO.getActCd().endsWith("FIRRDO")
									|| dtlMapgVO.getActCd().endsWith("FIRRAD")
									|| dtlMapgVO.getActCd().endsWith("FORRAD")) 
							&& (dtlMapgVO.getNodCd().substring(0, 2).equals("US") 
									|| dtlMapgVO.getNodCd().substring(0, 2).equals("CA"))
							&& !dtlMapgVO.getActDt().equals("")    // CHM-201325967 : 미주철도 EN TN OC IC Movement 매핑 로직 추가		
							&& (dtlMapgVO.getActStsMapgCd().equals("EN")
									|| dtlMapgVO.getActStsMapgCd().equals("IC")
									|| dtlMapgVO.getActStsMapgCd().equals("OC")
									|| dtlMapgVO.getActStsMapgCd().equals("TN"))){
									actVo.setActUmchTpCd("60");
									errCd = "02";
									actVo.setErrMsg("US Rail Movement Data(Skip)");
									modifySceActRcvIfByError(actVo);
									actHisVO.setActUmchTpCd(actVo.getActUmchTpCd());
									actHisVO.setErrMsg(actVo.getErrMsg());
							}
							// 2011.04.28  추가 - 황효근, CHM-201110244-01
							else if(dtlMapgVO.getActStsMapgCd() != null && actHisVO.getPodNodCd().equals(actHisVO.getNodCd()) && dtlMapgVO.getActStsMapgCd().equals("IC")){
//								if(actHisVO.getPodNodCd().equals(actHisVO.getNodCd()) && dtlMapgVO.getActStsMapgCd().equals("IC")) {
									actVo.setActUmchTpCd("61");
									errCd = "02";
									actVo.setErrMsg("IC 일때 POD Node 와 IC Node가 같으면 Skip");
									modifySceActRcvIfByError(actVo);
									actHisVO.setActUmchTpCd(actVo.getActUmchTpCd());
									actHisVO.setErrMsg(actVo.getErrMsg());
//								}								
							}
							// CHM-201324593 : Added ______________________________________________________________> 
							else if	( 
										( dtlMapgVO.getActStsMapgCd() != null )
										&& 
										( 
										  dtlMapgVO.getActStsMapgCd().equals("AR")|| dtlMapgVO.getActStsMapgCd().equals("A") || 
										  dtlMapgVO.getActStsMapgCd().equals("J") || dtlMapgVO.getActStsMapgCd().equals("UR") 
										)
										&&
										( dtlMapgVO.getActDt() != null && !dtlMapgVO.getActDt().equals(""))
										&&
										( actHisVO.getRailItchgFlg() != null && actHisVO.getRailItchgFlg().equals("Y") )
									){

									/* Rail Interchage 에서 이미 들어온 Arrival 이 있을때 뒤에 들어온것은 무시한다 */

									actVo.setActUmchTpCd("62");
									errCd = "02";
									actVo.setErrMsg("Late arrivals at the rail intercahge are ignored");
									modifySceActRcvIfByError(actVo);
									actHisVO.setActUmchTpCd(actVo.getActUmchTpCd());
									actHisVO.setErrMsg(actVo.getErrMsg());
							}
							// <______________________________________________________________ CHM-201324593 : Added 			
							else{
//								//6.cop detail 의 Bound Scheduling 호출
//								log.info("\n [cop detail 의 Bound Scheduling 호출] "+dtlMapgVO.getCopDtlSeq());
//								if(Integer.parseInt(dtlMapgVO.getCopDtlSeq())<4000||Integer.parseInt(dtlMapgVO.getCopDtlSeq())>6000){
//									log.info("\n [cop detail 의 Bound Scheduling 호출 yes] "+Integer.parseInt(dtlMapgVO.getCopDtlSeq()));
//									SceCopSkdHisVO skdVo = null;
//									skdVo = convertToSkdVo(actHisVO, dtlMapgVO);
//									scheduleCopDetailBound(skdVo);
//								}else{
//									log.info("\n [cop detail 의 Bound Scheduling 호출 no] "+Integer.parseInt(dtlMapgVO.getCopDtlSeq()));
//								}	
								
								resultUpd = false;
								
								//7.ACT STS 'C'를 'F'로 변경하고 ACT_DT 업데이트
								actHisVO.setCreDt(actVo.getActDatRcvDt());   //20100526
								resultUpd = modifyCopDetailCurrentStatus(dtlMapgVO, actHisVO);
							    
								//추가
								if(!resultUpd){
									actVo.setActUmchTpCd("40");
									actVo.setErrMsg("Duplicated Data");
									modifySceActRcvIfByError(actVo);	//Error 종료 처리 : Sce Act Rcv If 결과 업데이트
									actHisVO.setActUmchTpCd(actVo.getActUmchTpCd());
									actHisVO.setErrMsg(actVo.getErrMsg());								
								}else{

									//6.cop detail 의 Bound Scheduling 호출
//									log.info("\n [cop detail 의 Bound Scheduling 호출] "+dtlMapgVO.getCopDtlSeq());
									if(Integer.parseInt(dtlMapgVO.getCopDtlSeq())<4000||Integer.parseInt(dtlMapgVO.getCopDtlSeq())>6000){
//										log.info("\n [cop detail 의 Bound Scheduling 호출 yes] "+Integer.parseInt(dtlMapgVO.getCopDtlSeq()));
										SceCopSkdHisVO skdVo = null;
										skdVo = convertToSkdVo(actHisVO, dtlMapgVO);
										scheduleCopDetailBound(skdVo);
									}else{
//										log.info("\n [cop detail 의 Bound Scheduling 호출 no] "+Integer.parseInt(dtlMapgVO.getCopDtlSeq()));
									}
									actHisVO.setActUmchTpCd("99");
									actHisVO.setErrMsg("");									
									
								}
								
								//8.ACT STS 'N'를 'C'로 변경하고 ACT_DT 업데이트
								resultUpd = modifyCopDetailNextStatus(dtlMapgVO, actHisVO);

								
								//9-1.최초 or 최종 Actual Data 입력시 COP_FSH_DT,cop_sts_cd ='T' or 'F'로  업데이트
								//**'F'일때 CX전송용 flag set
								//9-2.CNTR MVMT 'XX' Status 발생 시, COP Closed 시킴
//								SceActRcvIfVO actVo
							    actHisVO = modifyCopHeaderStatus(actHisVO, dtlMapgVO.getCopDtlSeq(), actVo);
								
							    
							    /*EDI 315전송호출하기 전에 commit해야함!!*/
							    
								//10.EDI 315전송 메서드 호출  //v_act_stnd_edi_sts_cd

							    //EDI호출 Log추가
							    if(actVo.getCreUsrId()==null || actVo.getCreUsrId().equals("")){
							    	actVo.setCreUsrId("scesys");	
							    }
//							    else{
//								    if(actVo.getCreUsrId().equals("CrtBySplit")){
////								    	log.error("\n ["+actVo.getActStsMapgCd()+":Current]AddingLog EDI call::[actVo.getCreTpCd()"+actVo.getCreTpCd()+"]"+(actVo.getCreTpCd()==null?"isNull":"isNotNull")+"[errCd]"+errCd+"[dtlMapgVO.getStndEdiStsCd()]"+dtlMapgVO.getStndEdiStsCd()+"[pro_flg]"+pro_flg+" [BKG]"+actVo.getBkgNo()+" [CNTR]"+actVo.getCntrNo());
//								    }
//							    }

//							    log.info("\n 10-1.Actual Mapping 정상처리 stnd_edi_sts_cd====");
							    //10-1.Actual Mapping 정상처리 stnd_edi_sts_cd
							    if((actVo.getCreTpCd()==null || !actVo.getCreTpCd().equals("C")) && errCd.equals("00") && !dtlMapgVO.getStndEdiStsCd().equals("") && (pro_flg.equals("BATCH") || (dtlMapgVO.getRplnBatSndFlg().equals("Y") && pro_flg.equals("REPLAN")))){
							    
						            //EDI SEND PROCEDURE 호출(2007. 2. 12 14:23 추가) START
//						            String call_from = "COP";
					            
//						            if(actVo.getActStsMapgCd().equals("")){
//						            	call_from = "COPXX";
//						            }else{ 
//						            	call_from = "COP" + actVo.getActStsMapgCd().substring(0, 2);                
//						            }

//						            call_from_dir = call_from_dir + actVo.getActRcvDt() + actVo.getActRcvNo();        
									
//						            SCE_EDI_SEND_PRC(call_from_dir,         v_cntr_no,              out_edi_sts,    v_bl_no,
//						                            v_bkgno_list(cnt),      v_bkgnosplit_list(cnt), v_cop_grp_seq,  v_vsl_cd, 
//						                            v_skd_voy_no,           v_skd_dir_cd,           in_act_dt,      v_cop_nod_cd, 
//						                            in_usr_id,              in_usr_id,              v_cop_dtl_seq,  v_error_message2, 
//						                            v_err_cd2);
							    	
//									edi315VO = null;
									Edi315SendVO edi315VO = new Edi315SendVO();
									edi315VO.setCallFrom( "COP");
									edi315VO.setCntrNo(actHisVO.getCntrNo());
									edi315VO.setEdiStatus(dtlMapgVO.getStndEdiStsCd());
									edi315VO.setBlNo(actHisVO.getBlNo());
									edi315VO.setBkgNo(actHisVO.getBkgNo());
									//edi315VO.setCurrVvd(dtlMapgVO.getVslCd()+dtlMapgVO.getSkdVoyNo()+dtlMapgVO.getSkdDirCd());
									if(dtlMapgVO.getVslCd().length()>0 && dtlMapgVO.getSkdVoyNo().length()>0 && dtlMapgVO.getSkdDirCd().length()>0){
										edi315VO.setCurrVvd(dtlMapgVO.getVslCd()+dtlMapgVO.getSkdVoyNo()+dtlMapgVO.getSkdDirCd());
									}else{
										edi315VO.setCurrVvd("");
									}
//									log.info("\n ACT MAP 'C':: edi315VO.getCurrVvd()"+edi315VO.getCurrVvd()+"--------------------------");
									edi315VO.setEventDt(actHisVO.getActDt());
									edi315VO.setEventYard(dtlMapgVO.getNodCd());
//									log.info("\n ACT MAP 'C':: edi315VO.getEventYard()"+edi315VO.getEventYard()+"--------------------------");
									edi315VO.setCreId(actHisVO.getCreUsrId());
									edi315VO.setUpdId(actHisVO.getUpdUsrId());
									edi315VO.setCopNo(actHisVO.getCopNo());// yjlee추가 2010.02.25
									edi315VO.setCopDtlSeq(dtlMapgVO.getCopDtlSeq());
//									log.info("\n ACT MAP 'C':: edi315VO.gettCopDtlSeq()"+edi315VO.getCopDtlSeq()+"--------------------------");
									edi315VO.setActRcvIfKeyDt(actVo.getActRcvDt());
									edi315VO.setActRcvIfKeyNo(actVo.getActRcvNo());
									edi315VO.setMvmtSts(actVo.getActStsMapgCd());
									//edi315.edi315Send(edi315VO);
									try{
										edi315.edi315Send(edi315VO);
										//History 추가
										//actVo.setEdiSndRsltFlg("Y");   //<--edi315전송 로직에서 setting
										actHisVO.setEdiSndRsltFlg("Y");		//<--여기서는 calling edi315의미
									}catch(Exception e){
										log.error("\n [edi315.edi315Send(edi315VO)호출  에러]"+ e.getMessage());
										actVo.setEdiSndRsltFlg("N");
										actHisVO.setEdiSndRsltFlg("N");
									}
									
							    }							    
							    
								//10-2.CX전송의 경우
							    if((actVo.getCreTpCd()==null || !actVo.getCreTpCd().equals("C"))  && !actVo.getActStsMapgCd().equals("MT") && actHisVO.getCxSndFlg().equals("Y") && pro_flg.equals("BATCH")){
							    	
//						            String call_from = "COP";
//						            String edi_sts_cx = "CX";
						            
//						            if(actVo.getActStsMapgCd().equals("")){
//						            	call_from_dir_cx = "COPXX";
//						            }else{ 
//						            	call_from_dir_cx = "COP" + actVo.getActStsMapgCd().substring(0, 2);                
//						            }

//						            call_from_dir_cx = call_from_dir_cx + actVo.getActRcvDt() + actVo.getActRcvNo();  
//						            edi_sts_cx = "CX" + dtlMapgVO.getStndEdiStsCd().substring(0, 2);
						            
//						            SCE_EDI_SEND_PRC
//		                            (call_from_dir_cx,      v_cntr_no,                  edi_sts_cx,         v_bl_no, 
//		                             v_bkgno_list(cnt),     v_bkgnosplit_list(cnt),     v_cop_grp_seq,      v_vsl_cd, 
//		                             v_skd_voy_no,          v_skd_dir_cd,               in_act_dt,          in_nod_cd,          
//		                             in_usr_id,             in_usr_id,                  v_cop_dtl_seq,      v_error_message2,   
//		                             v_err_cd2
//		                             );                                     
//		            
//		            				cx_snd_flg := 'N' ;						            
							    	
//									edi315VO = null;
									Edi315SendVO edi315VO = new Edi315SendVO();
									edi315VO.setCallFrom("COP");
									edi315VO.setCntrNo(actHisVO.getCntrNo());
									edi315VO.setEdiStatus("CX");
									edi315VO.setBlNo(actHisVO.getBlNo());
									edi315VO.setBkgNo(actHisVO.getBkgNo());
									//edi315VO.setCurrVvd(dtlMapgVO.getVslCd()+dtlMapgVO.getSkdVoyNo()+dtlMapgVO.getSkdDirCd());
									if(dtlMapgVO.getVslCd().length()>0 && dtlMapgVO.getSkdVoyNo().length()>0 && dtlMapgVO.getSkdDirCd().length()>0){
										edi315VO.setCurrVvd(dtlMapgVO.getVslCd()+dtlMapgVO.getSkdVoyNo()+dtlMapgVO.getSkdDirCd());
									}else{
										edi315VO.setCurrVvd("");
									}
//									log.info("\n CX::  edi315VO.getCurrVvd()"+edi315VO.getCurrVvd()+"---------------------------");
									edi315VO.setEventDt(actHisVO.getActDt());
									edi315VO.setEventYard(dtlMapgVO.getNodCd());
//									log.info("\n CX::  edi315VO.getEventYard()"+edi315VO.getEventYard()+"---------------------------");
									edi315VO.setCreId(actHisVO.getCreUsrId());
									edi315VO.setUpdId(actHisVO.getUpdUsrId());
									edi315VO.setCopNo(actHisVO.getCopNo()); // yjlee추가 2010.02.25
									edi315VO.setCopDtlSeq(dtlMapgVO.getCopDtlSeq());
//									log.info("\n CX::  edi315VO.getCopDtlSeq()"+edi315VO.getCopDtlSeq()+"---------------------------");
									edi315VO.setMvmtSts(actVo.getActStsMapgCd());
									
									try{
										edi315.edi315Send(edi315VO);
										//actVo.setEdiSndRsltFlg("Y");   //<--edi315전송 로직에서 setting
										actHisVO.setEdiSndRsltFlg("Y");		//<--여기서는 calling edi315의미
									}catch(Exception e){
										log.error("\n [edi315.edi315Send(edi315VO)호출  에러]"+ e.getMessage());
										actVo.setEdiSndRsltFlg("N");
										actHisVO.setEdiSndRsltFlg("N");
									}
									actHisVO.setCxSndFlg("N");
									
							    }
								
							}
						
							copNos = dtlMapgVO.getStndEdiStsCd();
							actSts = dtlMapgVO.getActStsCd();
							dtlSeq = dtlMapgVO.getCopDtlSeq();
							
						//ACT STS가 'C'가 아닌 경우	
						}else{
							
							int updResult = 0;
							
							//4.DTL의 ACT STS가 'C'가 아닌 경우 검색
							//try{ 
								//CopDtlActMapgVO dtlMapgVO = new CopDtlActMapgVO();
								dtlMapgVO = searchCopDetailNotCurrentStatus(actHisVO);      // CHM-201324593 : 
								                                                            //    (1). select 절에 ACT_DT 추가
								                                                            //    (2).  AND	   b.rail_itchg_flg	 = NVL(@[rail_itchg_flg],'N')  조건 추가 
							//}catch(Exception e){
//								log.info("\n err: 8");
							//}								

							//4-1.US rail MVMT data skip 체크:EN/IC/OC/TN인 경우 ERR코드 정리
			                //[MVMT]US rail Mvmt data skip 체크:EN/IC/OC/TN인 경우 goto point_1
							log.info("\n CopDetailReceiveDBDAOSearchCopDetailNotCurrentStatusRSQL	333:[" + dtlMapgVO.getActDt()+"]" );
							log.info("\n dtlMapgVO.getActStsMapgCd() : "+dtlMapgVO.getActStsMapgCd());
							log.info("\n actHisVO.getRailItchgFlg() : "+actHisVO.getRailItchgFlg());
							log.info("\n dtlMapgVO.getActStsMapgCd() : "+dtlMapgVO.getActStsMapgCd());
							log.info("\n 1111111");
							if((dtlMapgVO.getCopNo() != null)
							&& (dtlMapgVO.getActCd().endsWith("FORRDO")
									|| dtlMapgVO.getActCd().endsWith("FIRRDO")
									|| dtlMapgVO.getActCd().endsWith("FIRRAD")
									|| dtlMapgVO.getActCd().endsWith("FORRAD")) 
							&& (dtlMapgVO.getNodCd().substring(0, 2).equals("US") 
									|| dtlMapgVO.getNodCd().substring(0, 2).equals("CA"))
							&& !dtlMapgVO.getActDt().equals("")    // CHM-201325967 : 미주철도 EN TN OC IC Movement 매핑 로직 추가		
							&& (dtlMapgVO.getActStsMapgCd().equals("EN")
									|| dtlMapgVO.getActStsMapgCd().equals("IC")
									|| dtlMapgVO.getActStsMapgCd().equals("OC")
									|| dtlMapgVO.getActStsMapgCd().equals("TN"))){
									actVo.setActUmchTpCd("60");
									errCd = "02";
									actVo.setErrMsg("US Rail Movement Data(Skip)");
									modifySceActRcvIfByError(actVo);
									actHisVO.setActUmchTpCd(actVo.getActUmchTpCd());
									actHisVO.setErrMsg(actVo.getErrMsg());
									log.info("\n 1111111");
							}
							// 2011.04.28  추가 - 황효근, CHM-201110244-01
							else if(dtlMapgVO.getActStsMapgCd() != null && actHisVO.getPodNodCd().equals(actHisVO.getNodCd()) && dtlMapgVO.getActStsMapgCd().equals("IC")){
//								if(actHisVO.getPodNodCd().equals(actHisVO.getNodCd()) && dtlMapgVO.getActStsMapgCd().equals("IC")) {
									actVo.setActUmchTpCd("61");
									errCd = "02";
									actVo.setErrMsg("IC 일때 POD Node 와 IC Node가 같으면 Skip");
									modifySceActRcvIfByError(actVo);
									actHisVO.setActUmchTpCd(actVo.getActUmchTpCd());
									actHisVO.setErrMsg(actVo.getErrMsg());									
//								}
									log.info("\n 222222222");
							}
							// CHM-201324593 : Added ______________________________________________________________> 
							else if	( 
										(dtlMapgVO.getCopNo() != null) 
										&&
										( dtlMapgVO.getActStsMapgCd() != null )
										&&
										( 
										  dtlMapgVO.getActStsMapgCd().equals("AR")|| dtlMapgVO.getActStsMapgCd().equals("A") || 
										  dtlMapgVO.getActStsMapgCd().equals("J") || dtlMapgVO.getActStsMapgCd().equals("UR") 
										)
										&&
										( dtlMapgVO.getActDt() != null && !dtlMapgVO.getActDt().equals(""))
										&&
										( actHisVO.getRailItchgFlg() != null && actHisVO.getRailItchgFlg().equals("Y") )
									){

									/* Rail Interchage 에서 이미 들어온 Arrival 이 있을때 뒤에 들어온것은 무시한다 */

									actVo.setActUmchTpCd("62");
									errCd = "02";
									actVo.setErrMsg("Late arrivals at the rail intercahge are ignored");
									modifySceActRcvIfByError(actVo);
									actHisVO.setActUmchTpCd(actVo.getActUmchTpCd());
									actHisVO.setErrMsg(actVo.getErrMsg());

							}
							// <______________________________________________________________ CHM-201324593 : Added 
							else{							
//									if(dtlMapgVO.getCopNo() != null){ 	
//										//6.cop detail 의 Bound Scheduling 호출
//										log.info("\n [cop detail 의 Bound Scheduling 호출] "+dtlMapgVO.getCopDtlSeq());
//										if(Integer.parseInt(dtlMapgVO.getCopDtlSeq())<4000||Integer.parseInt(dtlMapgVO.getCopDtlSeq())>6000){
//											log.info("\n [cop detail 의 Bound Scheduling 호출 yes] "+Integer.parseInt(dtlMapgVO.getCopDtlSeq()));
//											SceCopSkdHisVO skdVo = null;
//											skdVo = convertToSkdVo(actHisVO, dtlMapgVO);
//											scheduleCopDetailBound(skdVo);
//										}else{
//											log.info("\n [cop detail 의 Bound Scheduling 호출 no] "+Integer.parseInt(dtlMapgVO.getCopDtlSeq()));
//										}									
//									}
									
									//5.DTL의 ACT STS가 'C'가 아닌것에서  검색결과 없을때 CNTR교환 시도
									//As-Is 에서는 OC의 경우 CNTR교환처리하였지만 
									//To-Be 에서는 CNTR교환 제거 하기로 하였음!
									resultUpd = false;									
									if(dtlMapgVO.getCopNo()==null){

										log.info("\n dtlMapgVO == null: 9");
										//6.TL의 ACT STS가 'C'가 아닌것에서  검색결과 없을때 ERR코드 정리
										actVo.setActUmchTpCd("30");
										actVo.setErrMsg("Node can not be found in COP");
										modifySceActRcvIfByError(actVo);	//Error 종료 처리 : Sce Act Rcv If 결과 업데이트
										log.info("\n modifySceActRcvIfByError: 13");
										actHisVO.setActUmchTpCd(actVo.getActUmchTpCd());
										log.info("\n modifySceActRcvIfByError: 14");
										actHisVO.setErrMsg(actVo.getErrMsg());	
										log.info("\n modifySceActRcvIfByError: 15");
										actHisVO.setActUmchTpCd(actVo.getActUmchTpCd());
										actHisVO.setErrMsg(actVo.getErrMsg());
									    
									}else if(dtlMapgVO.getCopNo() != null && dtlMapgVO.getActStsCd().equals("N")){
										log.info("\n dtlMapgVO.getActStsCd().equals(N): 10");
										//7.값이 건너 뛰고 들어온 경우('N'), 입력된 DTL을 'C'로 변경 후 중간을 'F'로 변경
										updResult = modifyCopDetailNextStatusNotInCurrent(dtlMapgVO.getCopNo(),dtlMapgVO.getCopDtlSeq());
										log.info("\n 7.값이 건너 뛰고 들어온 경우('N'), 입력된 DTL을 'C'로 변경 후 중간을 'F'로 변경: 01 updResult:"+updResult);
										//updResult = modifyCopDetailFinishStatus(dtlMapgVO,actHisVO);

										//ACT STS 'C'를 'F'로 변경하고 ACT_DT 업데이트
										actHisVO.setCreDt(actVo.getActDatRcvDt());   //20100526
										resultUpd = modifyCopDetailCurrentStatus(dtlMapgVO, actHisVO);
										log.info("\n 7.값이 건너 뛰고 들어온 경우('N'), ACT STS 'C'를 'F'로 변경하고 ACT_DT 업데이트: 02 resultUpd:"+resultUpd);
										if(!resultUpd){
											actVo.setActUmchTpCd("40");
											actVo.setErrMsg("Duplicated Data");
											modifySceActRcvIfByError(actVo);	//Error 종료 처리 : Sce Act Rcv If 결과 업데이트
											actHisVO.setActUmchTpCd(actVo.getActUmchTpCd());
											actHisVO.setErrMsg(actVo.getErrMsg());								
										}else{
											actHisVO.setActUmchTpCd("99");
											actHisVO.setErrMsg("");		
										}	
										//ACT STS 'N'를 'C'로 변경하고 ACT_DT 업데이트
										resultUpd = modifyCopDetailNextStatus(dtlMapgVO, actHisVO);		
										log.info("\n 7.값이 건너 뛰고 들어온 경우('N'), ACT STS 'N'를 'C'로 변경하고 ACT_DT 업데이트: 02 resultUpd:"+resultUpd);
										
										
										//9-1.최초 or 최종 Actual Data 입력시 COP_FSH_DT,cop_sts_cd ='T' or 'F'로  업데이트
										//**'F'일때 CX전송용 flag set
										//9-2.CNTR MVMT 'XX' Status 발생 시, COP Closed 시킴
									    actHisVO = modifyCopHeaderStatus(actHisVO, dtlMapgVO.getCopDtlSeq(), actVo);										
										
									}else if(dtlMapgVO.getCopNo() != null && dtlMapgVO.getActStsCd().equals("F")){
										log.info("\n dtlMapgVO.getActStsCd().equals(F): 11");
										//8.'F'인 경우 ACT_DT가 Null 인 것에 ACT_DT만 변경
										actHisVO.setCreDt(actVo.getActDatRcvDt());		//20100526
										updResult = modifyCopDetailFinishStatus(dtlMapgVO,actHisVO);
										log.info("\n dtlMapgVO.getActStsCd().equals(F): 12 updResult["+updResult+"]");
										if(updResult==0){
											actVo.setActUmchTpCd("40");
											actVo.setErrMsg("Duplicated Data");
											modifySceActRcvIfByError(actVo);	//Error 종료 처리 : Sce Act Rcv If 결과 업데이트
											actHisVO.setActUmchTpCd(actVo.getActUmchTpCd());
											actHisVO.setErrMsg(actVo.getErrMsg());								
										}else{
											resultUpd = true;
											actHisVO.setActUmchTpCd("99");
											actHisVO.setErrMsg("");		
										}	   								
										
									}
									
									if(dtlMapgVO.getCopNo() != null && resultUpd){ 	
								
										//6.cop detail 의 Bound Scheduling 호출
										log.info("\n [cop detail 의 Bound Scheduling 호출] "+dtlMapgVO.getCopDtlSeq());
										if(Integer.parseInt(dtlMapgVO.getCopDtlSeq())<4000||Integer.parseInt(dtlMapgVO.getCopDtlSeq())>6000){
											log.info("\n [cop detail 의 Bound Scheduling 호출 yes] "+Integer.parseInt(dtlMapgVO.getCopDtlSeq()));
											SceCopSkdHisVO skdVo = null;
											skdVo = convertToSkdVo(actHisVO, dtlMapgVO);
											scheduleCopDetailBound(skdVo);
										}else{
											log.info("\n [cop detail 의 Bound Scheduling 호출 no] "+Integer.parseInt(dtlMapgVO.getCopDtlSeq()));
										}			

									}									
				 					

									
									
								    //EDI호출 Log추가
									if(actVo.getCreUsrId()==null || actVo.getCreUsrId().equals("")){
								    	actVo.setCreUsrId("scesys");	
								    }
//									else{
//									    if(actVo.getCreUsrId().equals("CrtBySplit")){
//									 //   	log.error("\n ["+actVo.getActStsMapgCd()+":NotCurrent]AddingLog EDI call::[actVo.getCreTpCd()"+actVo.getCreTpCd()+"]"+(actVo.getCreTpCd()==null?"isNull":"isNotNull")+"[errCd]"+errCd+"[dtlMapgVO.getStndEdiStsCd()]"+dtlMapgVO.getStndEdiStsCd()+"[pro_flg]"+pro_flg+" [BKG]"+actVo.getBkgNo()+" [CNTR]"+actVo.getCntrNo());
//									    }
//									}
									
									/*send edi추가해야함!20100212*/
								    log.info("\n 10-1.Actual Mapping 정상처리 stnd_edi_sts_cd====[actVo.getActUmchTpCd()]"+actVo.getActUmchTpCd()+"[dtlMapgVO.getStndEdiStsCd()]"+dtlMapgVO.getStndEdiStsCd()+"[errCd]"+errCd);
								    //10-1.Actual Mapping 정상처리 stnd_edi_sts_cd
								    if((actVo.getCreTpCd()==null || !actVo.getCreTpCd().equals("C")) && actVo.getActUmchTpCd().equals("99") && errCd.equals("00") && !dtlMapgVO.getStndEdiStsCd().equals("") && (pro_flg.equals("BATCH") || (dtlMapgVO.getRplnBatSndFlg().equals("Y") && pro_flg.equals("REPLAN")))){
								    
										Edi315SendVO edi315VO = new Edi315SendVO();
										edi315VO.setCallFrom( "COP");
										edi315VO.setCntrNo(actHisVO.getCntrNo());
										edi315VO.setEdiStatus(dtlMapgVO.getStndEdiStsCd());
										edi315VO.setBlNo(actHisVO.getBlNo());
										edi315VO.setBkgNo(actHisVO.getBkgNo());
										//edi315VO.setCurrVvd(dtlMapgVO.getVslCd()+dtlMapgVO.getSkdVoyNo()+dtlMapgVO.getSkdDirCd());
										if(dtlMapgVO.getVslCd().length()>0 && dtlMapgVO.getSkdVoyNo().length()>0 && dtlMapgVO.getSkdDirCd().length()>0){
											edi315VO.setCurrVvd(dtlMapgVO.getVslCd()+dtlMapgVO.getSkdVoyNo()+dtlMapgVO.getSkdDirCd());
										}else{
											edi315VO.setCurrVvd("");
										}
										log.info("\n ACT MAP NOT'C':: edi315VO.getCurrVvd()"+edi315VO.getCurrVvd()+"----------------");
										edi315VO.setEventDt(actHisVO.getActDt());
										edi315VO.setEventYard(dtlMapgVO.getNodCd());
										log.info("\n ACT MAP NOT'C':: edi315VO.getEventYard()"+edi315VO.getEventYard()+"----------------");
										edi315VO.setCreId(actHisVO.getCreUsrId());
										edi315VO.setUpdId(actHisVO.getUpdUsrId());
										edi315VO.setCopNo(actHisVO.getCopNo()); // yjlee추가 2010.02.25
										edi315VO.setCopDtlSeq(dtlMapgVO.getCopDtlSeq());
										log.info("\n ACT MAP NOT'C':: edi315VO.getCopDtlSeq()"+edi315VO.getCopDtlSeq()+"----------------");
										edi315VO.setActRcvIfKeyDt(actVo.getActRcvDt());
										edi315VO.setActRcvIfKeyNo(actVo.getActRcvNo());
										edi315VO.setMvmtSts(actVo.getActStsMapgCd());
										//edi315.edi315Send(edi315VO);
										try{
											edi315.edi315Send(edi315VO);
											//History 추가
											//actVo.setEdiSndRsltFlg("Y");   //<--edi315전송 로직에서 setting
											actHisVO.setEdiSndRsltFlg("Y");		//<--여기서는 calling edi315의미
										}catch(Exception e){
											log.error("\n [edi315.edi315Send(edi315VO)호출  에러]"+ e.getMessage());
											actVo.setEdiSndRsltFlg("N");
											actHisVO.setEdiSndRsltFlg("N");
										}
										
								    }							    									
									
							}		
							
							
							if(dtlMapgVO.getCopNo() != null){
								copNos = dtlMapgVO.getStndEdiStsCd();
								actSts = dtlMapgVO.getActStsCd();
								dtlSeq = dtlMapgVO.getCopDtlSeq();
							}
							
							
							
						}
						
					}//Rail ETA처리, P이벤트 끝 
					//12.Actual Unmatch시 EDI 전송 
			        /********************************************************************/
			        /* 정상적인 COP Creation 이 아닌 예외로 EDI만 전송 될 수 있도록 처리                     */
			        /* 1, node 불일치에 대한 Actual 전송                                                                                           */
			        /* 2, Finish 된 dtl 의 Actual 이 Null 일 경우 update 후 EDI 전송                       */ 
			        /* 3, Finish 된 cop 에 대해서도 edi 전송                                                                                  */
					/********************************************************************/

			        if(!actVo.getActUmchTpCd().equals("60") && !actVo.getActUmchTpCd().equals("62") && !actVo.getActUmchTpCd().equals("31") && pro_flg.equals("BATCH")){
			        	// CHM-201324593 : 62, 31 추가
			        	
			        	String call_from = "";
			        	String act_stnd_edi_sts_cd = "";
			        	
			        	CopDtlActMapgVO dtlMapgVO = new CopDtlActMapgVO();
						dtlMapgVO = searchCopDetailNotCurrentStatus(actHisVO);

			            if(actVo.getActUmchTpCd().equals("30") || actSts.equals("F")){
			                
			                if(actVo.getActUmchTpCd().equals("30")){
			                	call_from = "DIR";
			                }else{
			                	call_from = "COP";
			                }
			                
//			                call_from_dir = call_from_dir + actVo.getActRcvDt() + actVo.getActRcvNo();
			                
			                if(actVo.getActUmchTpCd().equals("30")){   
                                if(actVo.getActStsMapgCd().equals("EN")||actVo.getActStsMapgCd().equals("TN")||actVo.getActStsMapgCd().equals("ID")){			                	
			                        act_stnd_edi_sts_cd = "OA";
                                }else if(actVo.getActStsMapgCd().equals("IC")){
			                		act_stnd_edi_sts_cd = "IN";          
                                }else if(actVo.getActStsMapgCd().equals("OC")){
			                    	act_stnd_edi_sts_cd = "IO";
                                }else if(actVo.getActStsMapgCd().equals("OP")){
			                    	act_stnd_edi_sts_cd = "EE";
                                }else if(actVo.getActStsMapgCd().equals("MT")){
			                    	act_stnd_edi_sts_cd = "MT";
			            		}
                                
                         
                                copNos = act_stnd_edi_sts_cd;
			                }
			                log.info("\n modifySceActRcvIfByError: 16:"+actVo.getCreTpCd());
			                if(!act_stnd_edi_sts_cd.equals("") && (actVo.getCreTpCd()==null || !actVo.getCreTpCd().equals("C"))  && (pro_flg.equals("BATCH") || (dtlMapgVO.getRplnBatSndFlg().equals("Y") && pro_flg.equals("REPLAN")))){
			                    if(copNos != null){    
//			                        SCE_EDI_SEND_PRC(call_from_dir,         v_cntr_no,                  out_edi_sts,        v_bl_no, 
//			                                         v_bkgno_list(cnt),     v_bkgnosplit_list(cnt),     v_cop_grp_seq,      v_vsl_cd, 
//			                                         v_skd_voy_no,          v_skd_dir_cd,               in_act_dt,          in_nod_cd,          
//			                                         in_usr_id,             in_usr_id,                  v_cop_dtl_seq,      v_error_message2,   
//			                                         v_err_cd2
//			                                         );
			                    	
//									edi315VO = null;
			                    	Edi315SendVO edi315VO = new Edi315SendVO();
									edi315VO.setCallFrom(call_from);
									edi315VO.setCntrNo(actVo.getCntrNo());
									edi315VO.setEdiStatus(act_stnd_edi_sts_cd);
									edi315VO.setBlNo(actHisVO.getBlNo());
									edi315VO.setBkgNo(actHisVO.getBkgNo());
									//edi315VO.setCurrVvd(actVo.getVslCd()+actVo.getSkdVoyNo()+actVo.getSkdDirCd());
									if(actVo.getVslCd().length()>0 && actVo.getSkdVoyNo().length()>0 && actVo.getSkdDirCd().length()>0){
										edi315VO.setCurrVvd(actVo.getVslCd()+actVo.getSkdVoyNo()+actVo.getSkdDirCd());
									}else{
										edi315VO.setCurrVvd("");
									}
									log.info("\n Actual Unmatch:: edi315VO.getCurrVvd()"+edi315VO.getCurrVvd()+"------------------");
									edi315VO.setEventDt(actVo.getActDt());
									edi315VO.setEventYard(actVo.getNodCd());
									log.info("\n Actual Unmatch:: edi315VO.getEventYard()"+edi315VO.getEventYard()+"------------------");
									edi315VO.setCreId(actVo.getCreUsrId());
									edi315VO.setUpdId(actVo.getUpdUsrId());
									edi315VO.setCopNo(actHisVO.getCopNo()); // yjlee추가 2010.02.25
									edi315VO.setCopDtlSeq(dtlSeq);
									log.info("\n Actual Unmatch:: edi315VO.getCopDtlSeq()"+edi315VO.getCopDtlSeq()+"------------------");
									edi315VO.setActRcvIfKeyDt(actVo.getActRcvDt());
									edi315VO.setActRcvIfKeyNo(actVo.getActRcvNo());
									edi315VO.setMvmtSts(actVo.getActStsMapgCd());
									//edi315.edi315Send(edi315VO);
									try{
										edi315.edi315Send(edi315VO);
										//History 추가
										//actVo.setEdiSndRsltFlg("Y");   //<--edi315전송 로직에서 setting
										actHisVO.setEdiSndRsltFlg("Y");		//<--여기서는 calling edi315의미
									}catch(Exception e){
										log.error("\n [edi315.edi315Send(edi315VO)호출  에러]"+ e.getMessage());
										actVo.setEdiSndRsltFlg("N");
										actHisVO.setEdiSndRsltFlg("N");										
									}


			                    }
			                    
			                }
			                
			            } 
			        } //12.Actual Unmatch시 EDI 전송 끝  					
					
			        
					//13.미주Rail S/O의 VD Port, VD정보 업데이트 
				    modifyTrsRailSo(actHisVO);	

					//14.SCE ACTUAL RECEIVE HISTORY
			        addSceActRcvHis(actHisVO);
					
			        //Sce Act Rcv If 결과 업데이트
					if(actVo.getActUmchTpCd().equals("99")){
						modifySceActRcvIfByError(actVo);
						//20100420 RL ETA 보완
						if("RL".equals(actVo.getActStsMapgCd())){
							actHisVO.setActUmchTpCd(scheduleCopDetailBoundBy322P(actHisVO));
//							skdVo = convertToSkdVo(actHisVO, dtlMapgVO);
//							skdVo.setAftActDt(actHisVO.getRailDestN1stEtaDt());
//							skdVo.setRcvEvntProcFlg("EE");
//							scheduleCopDetailBound(skdVo);
						}
					}
			        
					//Actual Mapping 완료 후
//			        if(copNos != null && pro_flg.equals("BATCH")){
//			            searchSendEDIList(actHisVO.getCntrNo()+"", "MVMT", copNos);
//			        }	
			        
					
				}	//for
			}	//if
			
		}	
			
	}
		
	/**
	 * 미주 322 Rail 정보의 보정을 위한 logic <br>
	 * 
	 * @param SceActRcvIfVO actVo
	 * @return SceActRcvIfVO
	 * @exception EventException
	 */
	public SceActRcvIfVO searchUS322Moderate(SceActRcvIfVO actVo) throws EventException{
		SceActRcvIfVO actEdtVo=null;
		
		try {

			actEdtVo = dbDao.searchUS322Moderate(actVo); 
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}				
		
		return actEdtVo;				
	}		
	
	/**
	 * MVMT 동일국가에서  OP,MT일 경우, COP Node 변경 <br>
	 * 
	 * @param SceActRcvHisVO actHisVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean modifyCOPNodeByMVMT(SceActRcvHisVO actHisVO) throws EventException{
		boolean resultFlag=false;
		
		try {

			resultFlag=dbDao.modifyCOPNodeByMVMT(actHisVO)>0?true:false; 
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}				
		
		return resultFlag;			
	}
	
	/**
	 * DTL의 ACT STS가 'C'인 경우만 검색 <br>
	 * 
	 * @param SceActRcvHisVO actHisVO
	 * @return CopDtlActMapgVO
	 * @exception EventException
	 */
	public CopDtlActMapgVO searchCopDetailCurrentStatus(SceActRcvHisVO actHisVO) throws EventException{
		CopDtlActMapgVO dtlVO = null;
		
		try {

			dtlVO=dbDao.searchCopDetailCurrentStatus(actHisVO); 
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}				
		
		return dtlVO;			
	}
	
	/**
	 * DTL의 ACT STS가 'C'가 아닌것에서 검색결과 없을때 <br>
	 * 
	 * @param SceActRcvHisVO actHisVO
	 * @return CopDtlActMapgVO
	 * @exception EventException
	 */
	public CopDtlActMapgVO searchCopDetailNotCurrentStatus(SceActRcvHisVO actHisVO) throws EventException{
		CopDtlActMapgVO dtlVO = null;
		
		try {

			dtlVO=dbDao.searchCopDetailNotCurrentStatus(actHisVO); 
			log.info("\n searchCopDetailNotCurrentStatus 6");
			
		} catch (DAOException de) {
			log.error("\n err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}				
		log.info("\n searchCopDetailNotCurrentStatus 7");
		return dtlVO;			
	}
	
	/**
	 * ACT STS 'C'를 'F'로 변경하고 ACT_DT 업데이트[ACT STS가 'C'인 경우] <br>
	 * 
	 * @param CopDtlActMapgVO dtlMapgVO
	 * @param SceActRcvHisVO actHisVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean  modifyCopDetailCurrentStatus(CopDtlActMapgVO dtlMapgVO, SceActRcvHisVO actHisVO) throws EventException{
		boolean resultFlag=false;
		
		try {

			resultFlag=dbDao.modifyCopDetailCurrentStatus(dtlMapgVO, actHisVO)>0?true:false;  
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}				
		
		return resultFlag;			
	}
	
	/**
	 * Modify Actual Data Receive Date By Temp Role
	 * 
	 * @param CopDtlActMapgVO dtlMapgVO
	 * @param SceActRcvHisVO actHisVO
	 * @return boolean
	 * @throws EventException
	 */
	private boolean modifyActDatRcvDtTmpRole(CopDtlActMapgVO dtlMapgVO, SceActRcvHisVO actHisVO) throws EventException{
		boolean resultFlag=false;
		
		try {
			resultFlag=dbDao.modifyActDatRcvDtTmpRole(dtlMapgVO, actHisVO)>0?true:false;  
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}				
		return resultFlag;			
	}
	
	/**
	 * Modify Actual Data Receive Date By Temp Role
	 * 
	 * @param CopDtlActMapgVO dtlMapgVO
	 * @param SceActRcvIfVO actVO
	 * @return boolean
	 * @throws EventException
	 */
	public boolean modifyActDatRcvDtTmpRole(CopDtlActMapgVO dtlMapgVO, SceActRcvIfVO actVO) throws EventException{
		boolean resultFlag=false;
		
		try {
			resultFlag=dbDao.modifyActDatRcvDtTmpRole(dtlMapgVO, actVO)>0?true:false;  
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}				
		return resultFlag;			
	}
	
	
	/**
	 * ESTM_DT 업데이트[Manual Input Data of ESD_SCE_B153 Door Deliver Update ] <br>
	 * 
	 * @param CopDtlActMapgVO dtlMapgVO
	 * @param SceActRcvHisVO actHisVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean  modifyCopDetailEstimate(CopDtlActMapgVO dtlMapgVO, SceActRcvHisVO actHisVO) throws EventException{
		boolean resultFlag=false;
		
		try {

			resultFlag=dbDao.modifyCopDetailEstimate(dtlMapgVO, actHisVO)>0?true:false;  
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}				
		
		return resultFlag;			
	}
	
	/**
	 * ACT STS 'N'를 'C'로 변경하고 ACT_DT 업데이트[ACT STS가 'C'인 경우] <br>
	 * 
	 * @param CopDtlActMapgVO dtlMapgVO
	 * @param SceActRcvHisVO actHisVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean  modifyCopDetailNextStatus(CopDtlActMapgVO dtlMapgVO, SceActRcvHisVO actHisVO) throws EventException{
		boolean resultFlag=false;
		
		try {

			resultFlag=dbDao.modifyCopDetailNextStatus(dtlMapgVO, actHisVO)>0?true:false;  
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}				
		
		return resultFlag;			
	}
	
	/**
	 * [DTL의 ACT STS가 'C'인 경우]
	 * 7.값이 건너 뛰고 들어온 경우('N'), 입력된 DTL을 'C'로 변경 후 중간을 'F'로 변경
	 * 관련: copDetailReceiveMVMT, copDetailReceiveSPP
	 * 
	 * @param String cop_no
	 * @param String cop_dtl_seq
	 * @return int
	 * @exception EventException
	 */
	public int  modifyCopDetailNextStatusNotInCurrent(String cop_no, String cop_dtl_seq) throws EventException{
		int updateResult=0;
		
		try {

			updateResult=dbDao.modifyCopDetailNextStatusNotInCurrent(cop_no, cop_dtl_seq);  
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}				
		
		return updateResult;			
	}	
	
	/**
	 * [DTL의 ACT STS가 'C'인 경우]
	 * 8.'F'인 경우 ACT_DT가 Null 인 것에 ACT_DT만 변경
	 * 
	 * @param CopDtlActMapgVO dtlMapgVO
	 * @param SceActRcvHisVO actHisVO
	 * @return int
	 * @exception EventException
	 */
	public int  modifyCopDetailFinishStatus(CopDtlActMapgVO dtlMapgVO, SceActRcvHisVO actHisVO) throws EventException{
		int updateResult=0;
		
		try {
			
			//MVMT/322 & REPLAN MVMT/322
			if(actHisVO.getActRcvTpCd().equals("1")||actHisVO.getActRcvTpCd().equals("3")){

				updateResult=dbDao.modifyCopDetailFinishStatus(dtlMapgVO, actHisVO);  
				
			//SPP & REPLAN SPP	
			}else if(actHisVO.getActRcvTpCd().equals("9")){

				updateResult=dbDao.modifyCopDetailFinish2Status(dtlMapgVO, actHisVO);  
							
			//MVMT ONLINE	
			}else if(actHisVO.getActRcvTpCd().equals("4")){

				updateResult=dbDao.modifyCopDetailFinish3Status(dtlMapgVO, actHisVO);  
				
			}
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}				
		
		return updateResult;			
	}	
		
	/**
	 * 1.최초 or 최종 Actual Data 입력시 COP_FSH_DT,cop_sts_cd ='T' or 'F'로  업데이트 <br>
	 * ***'F'일때 CX전송용 flag set
	 * 2.CNTR MVMT 'XX' Status 발생 시, COP Closed 시킴
	 * 
	 * @param SceActRcvHisVO actHisVO
	 * @param String copDtlSeq
	 * @param SceActRcvIfVO actVO
	 * @return SceActRcvHisVO
	 * @exception EventException
	 */
	public SceActRcvHisVO  modifyCopHeaderStatus(SceActRcvHisVO actHisVO, String copDtlSeq, SceActRcvIfVO actVO) throws EventException{
		boolean resultFlag=false;
		String  lstmCd=null;
		String imdtExitFlg = (actVO!=null?actVO.getImdtExtFlg():"");
		CodeUtilBCImpl utlcomm = new CodeUtilBCImpl();
		
		try {
			
			//0.최종 Actual Data 입력 체크
			resultFlag=dbDao.searchCopDetailMax(actHisVO.getCopNo(), copDtlSeq)>0?true:false;
			
			//1.최종 Actual Data 입력 시 COP Close Status Update
			if(resultFlag){
				resultFlag=dbDao.modifyCopHeaderStatusClose(actHisVO)>0?true:false;
				if(resultFlag)utlcomm.addSceCopHistory(actHisVO.getCopNo(), "MF", "SysCop","SySMvmt","N");
				//SCE_COP_HIST_PRC( v_cop_no, 'MF','SysCop','SySMvmt','N');
				//1-1.CX전송용  flag set
				if(actHisVO.getActRcvTpCd().equals("1")) actHisVO.setCxSndFlg("Y");
			}else{
			//1.최초 Actual Data 입력시 COP In-Transit Status Update	
				resultFlag=dbDao.modifyCopHeaderStatusInTransit(actHisVO)>0?true:false;
				if(resultFlag)utlcomm.addSceCopHistory(actHisVO.getCopNo(), "MS", "SysCop", "SySMvmt", "N");
				//SCE_COP_HIST_PRC( v_cop_no, 'MS','SysCop','SySMvmt','N');
			}
			
			if(actHisVO.getActRcvTpCd().equals("1")){
				//2.CNTR MVMT 'XX' Status 발생 시, COP Closed 시킴
				//2-1.SUB LSTM 검색				
				lstmCd=dbDao.searchMstContainerLstmCd(actHisVO.getCntrNo());
				//2-2.
				//- 'ID' Movement Status를 가진 Container의 Lease Term이 One Way Free Lease(OF)인 경우.
				//- 해당 Container의 Current Status가 'Immediate Exit'일 경우.
				if ((actHisVO.getActStsMapgCd().equals("ID") &&  lstmCd.equals("OF"))||"Y".equals(imdtExitFlg)){
					//COP STS 'F' 업데이트 
					resultFlag=dbDao.modifyCopHeaderStatusClose(actHisVO)>0?true:false;  
					//ACT STS 'F' 및 ACT DT업데이트
					resultFlag=dbDao.modifyCopDetailActStsFinish(actHisVO, copDtlSeq)>0?true:false; 
					//eNis에는 없지만 ALPS에 추가
					if(resultFlag)utlcomm.addSceCopHistory(actHisVO.getCopNo(), "MF", "SysCop","SySMvmt","N");
				}	
			}
		
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}				
		
		return actHisVO;			
	}
		
	/**
	 * 관련 COP갯수 체크하여 FCL or LCL COP에 따른 BKG No.획득 (1row)<br>
	 * 
	 * @param SceActRcvIfVO actVo
	 * @return List<SceActRcvHisVO>
	 * @exception EventException
	 */
	public List<SceActRcvHisVO> searchBkgNoByLCLCOP(SceActRcvIfVO actVo) throws EventException{
		List<SceActRcvHisVO>  lists = new ArrayList <SceActRcvHisVO> ();

		try {

			lists=dbDao.searchBkgNoByLCLCOP(actVo); 
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}		
		
		return lists;
	}
	
	/**
	 * Partial CNTR을 제외한 BKG No.획득 (1row)<br>
	 * 
	 * @param SceActRcvIfVO actVo
	 * @return List<SceActRcvHisVO>
	 * @exception EventException
	 */
	private List<SceActRcvHisVO> searchBkgNoByBkgNCntr(SceActRcvIfVO actVo) throws EventException{
		List<SceActRcvHisVO>  lists = new ArrayList <SceActRcvHisVO> ();

		try {

			lists=dbDao.searchBkgNoByBkgNCntr(actVo); 
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}		
		
		return lists;
	}	
	
	/**
	 * Error 종료 처리 : Sce Act Rcv If 결과 업데이트 <br>
	 * 
	 * @param SceActRcvIfVO actVo
	 * @return boolean
	 * @exception EventException
	 */
	public boolean modifySceActRcvIfByError(SceActRcvIfVO actVO) throws EventException{
		boolean resultFlag=false;
		
		try {

			resultFlag=dbDao.modifySceActRcvIfByError(actVO)>0?true:false; 
			
			
		} catch (DAOException de) {
			log.error("\n modifySceActRcvIfByError err: "+de.toString(),de);
			//throw new EventException(de.getMessage());
		}				
		log.info("\n modifySceActRcvIfByError: 12");
		return resultFlag;			
	}
	
	/**
	 * COP NO 없을 경우하여, BKG No 대신 B/L No 로 재검색 <br>
	 * 
	 * @param String bkgNo
	 * @param String cntrNo
	 * @return SceActRcvHisVO
	 * @exception EventException
	 */
	public SceActRcvHisVO searchBlNoByLCLCOP(String bkgNo, String cntrNo) throws EventException{
		SceActRcvHisVO  editHisVO=null;

		try {

			editHisVO=dbDao.searchBlNoByLCLCOP(bkgNo, cntrNo); 
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}		
		
		return editHisVO;
	}			
	
	/**
	 * SPP Actual Mapping <br>
	 * 
	 * @param SceActRcvIfVO actVo
	 * @param String pro_flg
	 * @exception EventException
	 */
	public void copDetailReceiveSPP(SceActRcvIfVO actVo, String pro_flg) throws EventException{
		
		Edi315SendBC edi315 = new Edi315SendBCImpl();
		//Edi315SendVO edi315VO = null;
//		String errCd = "00";
		String mappingCop = "";
		int updResult = 9;

		
		List<CopDtlActMapgVO> copLists = new ArrayList<CopDtlActMapgVO>();
			
		
		//1.SPP Actual 이 매핑될 COP찾는다
		mappingCop = searchCopNoSpp(actVo);

		if(mappingCop == null || mappingCop.equals("")){
			
			actVo.setActUmchTpCd("02");
			actVo.setErrMsg("search_copno_cursor DATA NOTFOUND");
			//Error 종료 처리 : Sce Act Rcv If 결과 업데이트
			modifySceActRcvIfByError(actVo);
			
		}else{	

			//2.ACTIVITY/NODE까지 체크하여 COP찾는다
			copLists = searchCopVVD(actVo);

			//2-1.NODE없는 경우 COP Detail 대상이 없을 경우 Error코드 정리
			if(copLists.size()<1){
				actVo.setActUmchTpCd("20");
				actVo.setErrMsg("search cop dtl node DATA NOTFOUND");
				//Error 종료 처리 : Sce Act Rcv If 결과 업데이트
				modifySceActRcvIfByError(actVo);				
				
			}else{
					//Initialize
					actVo.setActUmchTpCd("99");
				    log.info("\n----------spp     1");
					//3.Cop Detail Mapping
					for(int i = 0; i < copLists.size(); i++){
						log.info("\n----------spp     1");
						CopDtlActMapgVO copMapgVO = copLists.get(i);
						log.info("\n----------spp     2");
						SceActRcvHisVO actHisVO = null;
						//***Set Up************************************************
						actHisVO = setupActualHistory(actVo,copMapgVO);
						actHisVO.setCreUsrId(actVo.getCreUsrId());
						actHisVO.setUpdUsrId(actVo.getUpdUsrId());
						actHisVO.setCreDt(actVo.getActDatRcvDt()); // 2011.03.10 김인수[] spp 의 door actual 입력시 receive date (lcl) 누락으로 보완
						//*********************************************************
						log.info("\n----------spp     3");

						//if(copMapgVO.equals("C")) <-- Scheduling
						if(copMapgVO.getActStsCd().equals("N")){
							//3-1.값이 건너 뛰고 들어온 경우('N'), 입력된 DTL을 'C'로 변경 후 중간을 'F'로 변경
							updResult = modifyCopDetailNextStatusNotInCurrent(copMapgVO.getCopNo(),copMapgVO.getCopDtlSeq());
							log.info("\n----------spp     3-1");
						}else if(copMapgVO.getActStsCd().equals("F")){
							//3-2.'F'인 경우 ACT_DT가 Null 인 것에 ACT_DT만 변경
							actHisVO.setCreDt(actVo.getActDatRcvDt());		//20100526
							updResult = modifyCopDetailFinishStatus(copMapgVO,actHisVO);
							log.info("\n----------spp     3-2");
							if(updResult==0){
								actVo.setActUmchTpCd("40");
								actVo.setErrMsg("Duplicated Data");
								modifySceActRcvIfByError(actVo);	//Error 종료 처리 : Sce Act Rcv If 결과 업데이트
								log.info("\n----------spp     3-3");

							}	
							
						}
						log.info("\n----------spp     4");
						if(updResult!=0){
							log.info("\n----------spp     5");
							//3-3~3-4.cop detail 의 Bound Scheduling 호출
							SceCopSkdHisVO skdVo = null;
							skdVo = convertToSkdVo(actHisVO, copMapgVO);

							scheduleCopDetailBound(skdVo);
							log.info("\n----------spp     6");
							
							//3-5.ACT STS 'C'를 'F'로 변경하고 ACT_DT 업데이트
							modifyCopDetailCurrentStatus(copMapgVO, actHisVO);
							log.info("\n----------spp     7");
								
							//3-6.ACT STS 'N'를 'C'로 변경하고 ACT_DT 업데이트
						    modifyCopDetailNextStatus(copMapgVO, actHisVO);
						    log.info("\n----------spp     8");
							//3-7~3-8.최초 or 최종 Actual Data 입력시 COP_FSH_DT,cop_sts_cd ='T' or 'F'로  업데이트
						    actHisVO = modifyCopHeaderStatus(actHisVO, copMapgVO.getCopDtlSeq(), null);
						    log.info("\n----------spp     9");
							
						    //3-10.EDI SEND 호출
						    if(!pro_flg.equals("REPLAN")){
							    if(copMapgVO.getStndEdiStsCd()!=null && !copMapgVO.getStndEdiStsCd().equals("")){
							    
	//					            String call_from_dir = "";
	//				            
	//					            if(actVo.getActStsMapgCd().equals("")){
	//					                call_from_dir = "COPXX";
	//					            }else{ 
	//					                call_from_dir = "COP" + actVo.getActStsMapgCd().substring(0, 2);                
	//					            }
	//
	//					            call_from_dir = call_from_dir + actVo.getActRcvDt() + actVo.getActRcvNo();        
									
	//					                        SCE_EDI_SEND_PRC(call_from_dir, in_cntr_no, v_stnd_edi_sts_cd
	//					                            , '', in_bkg_no
	//					                            , v_vsl_cd
	//					                            , v_skd_voy_no, v_skd_dir_cd, in_act_dt
	//					                            , v_nod_cd, in_usr_id, in_usr_id, v_cop_dtl_seq
	//					                            , v_error_message2, v_err_cd2);
							    	
							    	Edi315SendVO edi315VO = new Edi315SendVO();
									edi315VO.setCallFrom("COP");
									edi315VO.setCntrNo(actHisVO.getCntrNo());
									edi315VO.setEdiStatus(copMapgVO.getStndEdiStsCd());
									edi315VO.setBlNo(actHisVO.getBlNo());
									edi315VO.setBkgNo(actHisVO.getBkgNo());
									//edi315VO.setCurrVvd(copMapgVO.getVslCd()+copMapgVO.getSkdVoyNo()+copMapgVO.getSkdDirCd());
									if(copMapgVO.getVslCd().length()>0 && copMapgVO.getSkdVoyNo().length()>0 && copMapgVO.getSkdDirCd().length()>0){
										edi315VO.setCurrVvd(copMapgVO.getVslCd()+copMapgVO.getSkdVoyNo()+copMapgVO.getSkdDirCd());
									}else{
										edi315VO.setCurrVvd(copMapgVO.getVslCd()+copMapgVO.getSkdVoyNo()+copMapgVO.getSkdDirCd());
									}
									log.info("\n SPP:: edi315VO.getCurrVvd()"+edi315VO.getCurrVvd()+"--------------------------");
									edi315VO.setEventDt(actHisVO.getActDt());
									edi315VO.setEventYard(actHisVO.getNodCd());
									log.info("\n SPP:: edi315VO.getEventYard()"+edi315VO.getEventYard()+"--------------------------");
									edi315VO.setCreId(actHisVO.getCreUsrId());
									edi315VO.setUpdId(actHisVO.getUpdUsrId());
									edi315VO.setCopNo(actHisVO.getCopNo());// yjlee추가 2010.02.25
									edi315VO.setCopDtlSeq(copMapgVO.getCopDtlSeq());
									log.info("\n SPP:: edi315VO.getCopDtlSeq()"+edi315VO.getCopDtlSeq()+"--------------------------");
									edi315VO.setActRcvIfKeyDt(actVo.getActRcvDt());
									edi315VO.setActRcvIfKeyNo(actVo.getActRcvNo());
									edi315VO.setMvmtSts(actVo.getActStsMapgCd());
									//edi315.edi315Send(edi315VO);
									try{
										edi315.edi315Send(edi315VO);
										//History 추가
										//actVo.setEdiSndRsltFlg("Y");   //<--edi315전송 로직에서 setting
										actHisVO.setEdiSndRsltFlg("Y");		//<--여기서는 calling edi315의미
									}catch(Exception e){
										log.error("\n [edi315.edi315Send(edi315VO)호출  에러]"+ e.getMessage());
										actVo.setEdiSndRsltFlg("N");
										actHisVO.setEdiSndRsltFlg("N");										
									}								
	
									
							    }
						    }
						    
						    //3-12.SCE ACTUAL RECEIVE IF에 저장
							modifySceActRcvIfByError(actVo);	//Error 종료 처리 : Sce Act Rcv If 결과 업데이트
						    //3-11.SCE ACTUAL RECEIVE HISTORY에 저장
						    addSceActRcvHis(actHisVO);							

						    
						}else{
							
							//Exit Cop Detail Mapping 
							i = copLists.size();
						}
					}
			
			}		
			
		}


	}
	
	/**
	 * 214 외부 인터페이스, Actual Mapping <br>
	 * 
	 * @param CopDtlActMapgVO dtlMapgVO
	 * @param String callType
	 * @exception EventException
	 */
	public void create214SceIf(CopDtlActMapgVO dtlMapgVO, String callType) throws EventException{
//		String mappingCop = "";
		Edi315SendBC edi315 = new Edi315SendBCImpl();
		int updResult = 0;
		
//		List<CopDtlActMapgVO> copLists = new ArrayList<CopDtlActMapgVO>();
		SceActRcvIfVO actVo = new SceActRcvIfVO();
		SceActRcvHisVO actHisVo = new SceActRcvHisVO();
		
		
		//1.SetUp정보 Read
		try {

			if(dtlMapgVO.getUpdUsrId()==null||dtlMapgVO.getUpdUsrId().equals("")){
				dtlMapgVO.setUpdUsrId("EDI_214_PoD");
			}	
			actHisVo=dbDao.searchCopDetail(dtlMapgVO); 
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
		}		
		
		if(actHisVo.getCopNo()!=null && !actHisVo.getCopNo().equals("")){
			
			//Sce I/F *** Set Up ***************************
			actVo.setActDt(dtlMapgVO.getActDt());
			actVo.setActCd("FITZAD");
			actVo.setActStsMapgCd("FITZAD");
			//actVo.setBkgNo(dtlMapgVO.getSoCd()+dtlMapgVO.getSoSeq());  			//so정보 저장  0429 이전
			actVo.setVslDlayRsnDesc("so#"+dtlMapgVO.getSoCd()+dtlMapgVO.getSoSeq()+"cop#"+actHisVo.getCopNo()+"dtlseq#"+actHisVo.getMstBkgNo());	//so정보 저장  0429 이후
			actVo.setActRcvTpCd("0");
			actVo.setActUmchTpCd("99");
			//20100429추가 : CNTR_NO,COP_NO,VNDR_SEQ(=COP_DTL_SEQ),NOD_CD
			actVo.setBkgNo(actHisVo.getBkgNo());
			actVo.setCntrNo(actHisVo.getCntrNo());
			actVo.setNodCd(actHisVo.getNodCd());
			log.info("\n create214SceIf	: Sce I/F *** Set Up");
			
			//2.cop detail 의 Bound Scheduling 호출
			SceCopSkdHisVO skdVo = null;
			skdVo = convertToSkdVo(actHisVo, dtlMapgVO);
//			scheduleCopDetailBound(skdVo);	
			
			log.info("\n create214SceIf	: cop detail 의 Bound Scheduling 호출");
			
			//3.Actrual Date Update	
			try {
	
				updResult=dbDao.modifyCopDetailBy214EDI(dtlMapgVO);

			} catch (DAOException de) {
				log.error("err "+de.toString(),de);
			}

			log.info("\n create214SceIf	: Actrual Date Update	");

			if(callType != null && callType.equals("edi214")){
				
				//4.SCE I/F SetUp  &&  INSERT
				if(updResult>0){
					actVo.setActUmchTpCd("99");
					actVo.setErrMsg("");
					actHisVo.setActUmchTpCd("99");
					actHisVo.setErrMsg("");
					scheduleCopDetailBound(skdVo);
				}else{
					actVo.setActUmchTpCd("20");
					actVo.setErrMsg("214Mappingfail");
					actHisVo.setActUmchTpCd("20");
					actHisVo.setErrMsg("214Mappingfail");
				}
		
				actVo.setCreUsrId("214");//(dtlMapgVO.getCreUsrId());
				actVo.setUpdUsrId("214");//dtlMapgVO.getUpdUsrId());
				
				//5.Sce I/F  Insert
				addSceActRcvIf(actVo);		
				
				log.info("\n create214SceIf	: Sce I/F  Insert");
				
				actHisVo.setCreUsrId("214");//(dtlMapgVO.getCreUsrId());
				actHisVo.setUpdUsrId("214");//(dtlMapgVO.getUpdUsrId());
				
				//6.Sce Cop Schedule History 저장
				addSceActRcvHis(actHisVo);
	
				//Error 종료 처리+Sce Act Rcv If 결과 업데이트
				//modifySceActRcvIfByError(actVo);
				
				// [CHM-201324128] 315 D status 관련 Logic 변경 요청 (214 Actual 매핑 후 315 전송) START
				if(callType != null && callType.equals("edi214")){
			    	Edi315SendVO edi315VO = new Edi315SendVO();
					edi315VO.setCallFrom("COP");
					edi315VO.setCntrNo(actHisVo.getCntrNo());
					edi315VO.setEdiStatus("D");
					edi315VO.setBlNo(actHisVo.getBkgNo());
					edi315VO.setBkgNo(actHisVo.getBkgNo());
					//edi315VO.setCurrVvd(copMapgVO.getVslCd()+copMapgVO.getSkdVoyNo()+copMapgVO.getSkdDirCd());
					if(actHisVo.getVslCd().length()>0 && actHisVo.getSkdVoyNo().length()>0 && actHisVo.getSkdDirCd().length()>0){
						edi315VO.setCurrVvd(actHisVo.getVslCd()+actHisVo.getSkdVoyNo()+actHisVo.getSkdDirCd());
					}else{
						edi315VO.setCurrVvd(actHisVo.getVslCd()+actHisVo.getSkdVoyNo()+actHisVo.getSkdDirCd());
					}
					log.info("\n SPP:: edi315VO.getCurrVvd()"+edi315VO.getCurrVvd()+"--------------------------");
					edi315VO.setEventDt(actHisVo.getActDt());
					edi315VO.setEventYard(actHisVo.getNodCd());
					log.info("\n SPP:: edi315VO.getEventYard()"+edi315VO.getEventYard()+"--------------------------");
					edi315VO.setCreId("214");
					edi315VO.setUpdId("214");
					edi315VO.setCopNo(dtlMapgVO.getCopNo());// yjlee추가 2010.02.25
					edi315VO.setCopDtlSeq(dtlMapgVO.getCopDtlSeq());
					log.info("\n SPP:: edi315VO.getCopDtlSeq()"+edi315VO.getCopDtlSeq()+"--------------------------");
					edi315VO.setActRcvIfKeyDt(actVo.getActRcvDt());
					edi315VO.setActRcvIfKeyNo(actVo.getActRcvNo());
					edi315VO.setMvmtSts(actVo.getActStsMapgCd());
					//edi315.edi315Send(edi315VO);
					try{

						edi315.edi315Send(edi315VO);
					
					}catch(Exception e){
						log.error("\n [edi315.edi315Send(edi315VO)호출  에러]"+ e.getMessage());
					}								
			    }
	
				log.info("\n create214SceIf	: Sce Cop Schedule History 저장");
			}
			
		}	

	}
	
	
	/**
	 * Actual History 정보를 설정한다.
	 * 
	 * @param SceActRcvIfVO actVo
	 * @param CopDtlActMapgVO dtlMapgVO
	 * @return SceActRcvHisVO
	 * @throws EventException
	 */
	public SceActRcvHisVO setupActualHistory(SceActRcvIfVO actVo,CopDtlActMapgVO dtlMapgVO) throws EventException{
		SceActRcvHisVO actHisVO = new SceActRcvHisVO();
		String boundCd = "";
		
		//***SetUP Start*********************************
		//addSceActRcvHis 처리에서 actHistVo<--actVo매핑!!
		actHisVO.setActRcvDt(actVo.getActRcvDt());
		actHisVO.setActRcvNo(actVo.getActRcvNo());
		actHisVO.setCntrNo(actVo.getCntrNo());
		actHisVO.setBkgNo(actVo.getBkgNo());
		actHisVO.setActDt(actVo.getActDt());
		actHisVO.setActGdt(actVo.getActGdt());
		actHisVO.setActStsMapgCd(actVo.getActStsMapgCd());
		actHisVO.setNodCd(actVo.getNodCd());
		actHisVO.setActRcvTpCd(actVo.getActRcvTpCd());
		actHisVO.setVslCd(actVo.getVslCd());
		actHisVO.setSkdVoyNo(actVo.getSkdVoyNo());
		actHisVO.setSkdDirCd(actVo.getSkdDirCd());
		actHisVO.setClptIndSeq(actVo.getClptIndSeq());
		actHisVO.setVpsPortCd(actVo.getVpsPortCd());
		actHisVO.setEdiMsgTpCd(actVo.getEdiMsgTpCd());
		actHisVO.setErrMsg(actVo.getErrMsg());
		actHisVO.setCopNo(dtlMapgVO.getCopNo());
		actHisVO.setEmlSndRsltFlg("N");
		actHisVO.setEdiSndRsltFlg("N");
		actHisVO.setFaxSndRsltFlg("N");
		actHisVO.setVndrSeq(actVo.getVndrSeq());
		//actHisVO.setMstBkgNo("");
		actHisVO.setTrspClzFlg("");
		actHisVO.setActCd(dtlMapgVO.getActCd());
		actHisVO.setActUmchTpCd(actVo.getActUmchTpCd());
		actHisVO.setUmchChkDt(actVo.getUmchChkDt());
		actHisVO.setRailDestN1stEtaDt(actVo.getRailDestN1stEtaDt());
		boundCd=dtlMapgVO.getCopDtlSeq().compareTo("6000")>0?"I":(dtlMapgVO.getCopDtlSeq().compareTo("4000")<0?"O":"T");
		actHisVO.setBndVskdSeqCd(boundCd);
		actHisVO.setCreTpCd(actVo.getCreTpCd());
		//actHisVO.setCreUsrId(actVo.getCreUsrId());
		//actHisVO.setUpdUsrId(actVo.getUpdUsrId());
		actHisVO.setActGapDesc((dtlMapgVO.getActDt()!=null)?dtlMapgVO.getActDt():actVo.getActDt());		//insert시에 수신Actual과 DtlActual을 비교한다.
		actHisVO.setMstCopNo("");
		actHisVO.setDupFlg("N");
		
		
		return actHisVO;
	}
	
		
	/**
	 * VSL Actual 을 매핑할 COP찾기 <br>
	 * 
	 * @param SceActRcvIfVO actVo
	 * @return String 
	 * @exception EventException
	 */
	public String searchCopNoSpp(SceActRcvIfVO actVo) throws EventException{
		String searchCop=null;

		try {

			searchCop=dbDao.searchCopNoSpp(actVo); 
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}		
		
		return searchCop;
	}			
	
	/**
	 * ACTIVITY/NODE까지 체크하여 COP찾는다 <br>
	 * 
	 * @param SceActRcvIfVO actVo
	 * @return List<CopDtlActMapgVO>
	 * @exception EventException
	 */
	public List<CopDtlActMapgVO> searchCopVVD(SceActRcvIfVO actVo) throws EventException{
		List<CopDtlActMapgVO>  lists=null;

		try {

			lists=dbDao.searchCopVVD(actVo); 
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}		
		
		return lists;
	}				
		
		
//		hashMap = addActualDataReceiveSPP(event);   //outcopNo
//
//		searchSendEDIList((String)hashMap.get("cntr_no")+"", "SPP", "");		
		
//	    /**
//	     * Service Provider Portal Actual 관련 data인 경우 COP에 적용 한다.
//	     * @param act_rcv_dt
//	     * @param act_rcv_no
//	     * @param nod_cd
//	     * @param cntr_no
//	     * @param act_rcv_tp_cd
//	     * @param act_sts_mapg_cd
//	     * @param act_cd
//	     * @param act_dt
//	     * @param usr_id
//	     * @return
//	     * @throws DAOException
//	     */
//	    public HashMap  addActualDataReceiveSPP(String act_rcv_dt     	,
//	    										String act_rcv_no     	,
//	    										String nod_cd         	,
//	    										String cntr_no     		,
//	    										String bkg_no           ,
//	    										String bkg_no_split     ,
//	    										String act_rcv_tp_cd   	,
//	    										String act_sts_mapg_cd 	,
//	    										String act_cd			,
//	    										String act_dt         	,
//	    										String usr_id) throws DAOException {
//
//	    	Connection con = null;
//	    	CallableStatement cs = null;
//	    	PreparedStatement ps = null;
//	    	String resultCd = "";
//	    	String outcopNo = "";
//	    	String queryStr = "{call sce_act_rcv_spp_prc(?,?,?,?,?,?,?,?,?,?,?,?,?)}";			//20070423
//
//	    	HashMap hashMap = new HashMap();
//
//	    	try {
//	    		log.info("\n--------------------------------------------------------- " +
//	    			      "\n             Actual Receive SPP DAO                 	   " +
//	    				  "\n--------------------------------------------------------- ");
//
//
//	    		log.info(": queryString is: " + queryStr);
//	    		log.info("\n act_rcv_dt     	[" + act_rcv_dt 		+"]");
//	    		log.info("\n act_rcv_no     	[" + act_rcv_no      	+"]");
//	    		log.info("\n nod_cd         	[" + nod_cd          	+"]");
//	    		log.info("\n cntr_no     		[" + cntr_no      		+"]");
//	    		log.info("\n bkg_no     		[" + bkg_no      		+"]");
//	    		log.info("\n bkg_no_split     		[" + bkg_no_split      		+"]");
//	    		log.info("\n act_rcv_tp_cd   	[" + act_rcv_tp_cd      +"]");
//	    		log.info("\n act_sts_mapg_cd 	[" + act_sts_mapg_cd   	+"]");
//	    		log.info("\n act_cd   		[" + act_cd    			+"]");
//	    		log.info("\n act_dt   		[" + act_dt    			+"]");
//	    		log.info("\n usr_id			[" + usr_id 			+"]");
//
//	    		con = getConnection();
//
//
//	    		cs = con.prepareCall(queryStr);
//
//	    		cs.setString(1, act_rcv_dt      	);
//	    		cs.setString(2, act_rcv_no      	);
//	    		cs.setString(3, nod_cd          	);
//	    		cs.setString(4, cntr_no      		);
//	    		cs.setString(5, bkg_no      		);
//	    		cs.setString(6, bkg_no_split      		);
//	    		cs.setString(7, act_rcv_tp_cd   	);
//	    		cs.setString(8, act_sts_mapg_cd  	);
//	    		cs.setString(9, act_cd   			);
//	    		cs.setString(10, act_dt    			);
//	    		cs.setString(11, usr_id          	);
//	    		cs.setString(12, ""          		);
//	    		cs.setString(13, ""          		);				//20070423
//
//	    		cs.registerOutParameter(12 ,Types.VARCHAR);
//	    		cs.registerOutParameter(13 ,Types.VARCHAR); 		//20070423
//
//	    		cs.executeUpdate();
//
//	    		resultCd = cs.getString(12);
//	    		outcopNo = cs.getString(13);
//
//	    		hashMap.put("resultCd" , resultCd);
//	    		hashMap.put("outcopNo" , outcopNo);
//	    		//2007.08.31 cntr_no 빠진 값 넣기.
//	    		hashMap.put("cntr_no" , cntr_no);
//	    		log.info("\n outcopNo:"+outcopNo);

	    		/* 20070429. YCSHIN */		
		//Actual Mapping 완료 후
		////searchSendEDIList((String)hashMap.get("cntr_no")+"", "SPP", "");

	/**
	 * VSK Actual Mapping <br>
	 * 
	 * @param SceActRcvIfVO actVo
	 * @param String pro_flg
	 * @param CopDtlActMapgVO copMapgVO
	 * @param int cntCopAll
	 * @param int currCop
	 * @exception EventException
	 */
	public void copDetailReceiveVessel(SceActRcvIfVO actVo, String pro_flg, CopDtlActMapgVO copMapgVO, int cntCopAll, int currCop) throws EventException{
		Edi315SendBC edi315 = new Edi315SendBCImpl();
		
		String errCd = "000000";
		int mappingCopCount = 0;
		int sendingEdiCount = 0;
		int loopCount = 0;
		
		//String tempVVD = "";
		//String outCopNo = "";

		//List<SceActRcvHisVO> actHisLists = new ArrayList<SceActRcvHisVO>();
		List<CopDtlActMapgVO> copMapgLists = new ArrayList<CopDtlActMapgVO>();
		List<Edi315SendCopVO> ediSendLists = new ArrayList<Edi315SendCopVO>();
		
		
		//1.New COP만 해당: VSL Actual 재매핑을 위한 보완
		//actVO = searchSceActRcvIf(actVO);  <--To-Be 에서 필요 없겠네!! <--/NIS2010_BATCH/xml/sce/ActualReceive.xml 참조
		
		//2.VSL Actual을 매핑할 COP찾기
		if(pro_flg.equals("REPLAN")){
			copMapgLists = searchMappingCOP(actVo);
			loopCount = copMapgLists.size();
		}else{
			loopCount=1;
		}
		
		//VSL Actual이 매핑할 COP 찾기 실패
		if(cntCopAll == 0){
			
			actVo.setActUmchTpCd("20");
			errCd = "000002";
			actVo.setErrMsg("getCOPInfoFromVSL IS NO DATA");
			
			//Error 종료 처리 : Sce Act Rcv If 결과 업데이트
			modifySceActRcvIfByError(actVo);
			
		}else{
			//Initialize
			actVo.setActUmchTpCd("99");
			actVo.setErrMsg("");

			//COP 에 VSL Actual을 매핑
			//for(int i = 0; i < copMapgLists.size(); i++){		//20100519. cop단위 트랜잭션을 위해 삭제
			for(int i = 0; i < loopCount; i++){
				mappingCopCount++;
				errCd = "000000";
				
				if(pro_flg.equals("REPLAN")){
					//CopDtlActMapgVO copMapgVOByRPN = copMapgLists.get(i);	//20100519. cop단위 트랜잭션을 위해 삭제
					copMapgVO = copMapgLists.get(i);
				}
//				SceActRcvHisVO actHistVO = new SceActRcvHisVO();
				
				
				//3.현재 Mapping대상의 Status가 'C'or'N'인 경우
				if(copMapgVO.getActStsCd().equals("C") || copMapgVO.getActStsCd().equals("N")){
					//3-1.현재 대상인 COP Detail에 Actual매핑 & 'F' Status로 업데이트
					//3-2.중간 COP의 Status만 모두 'F'로 업데이트
					//3-3.Next COP의 Status만  'C' Status로 업데이트 
					errCd = modifyCopDetailNextStatusByVSK(copMapgVO,actVo);
					
				//4.Mapping대상 COP Status가 'F'인 경우 Actual만 변경	
				}else if(copMapgVO.getActStsCd().equals("F")){
					//4-1.현재 대상인 COP Detail만 Actual 매핑 UPDATE, 추가적으로 Actual의 재업데이트 가능.
					//4-2.Pre COP의 Status만 모두 'F'로 UPDATE(Pre COP이전은 모두 'F'로)
					errCd = modifyCopDetailFinishStatusByVSK(copMapgVO,actVo);

				}
				
				//5-1.Actual Mapping History 저장
				addSceActRcvHisByVSK(copMapgVO,actVo,errCd,pro_flg);

			}	
			
			if(mappingCopCount > 0 && (cntCopAll==(currCop+1) || pro_flg.equals("REPLAN"))){
				
				//7.EDI315전송 
				//7-1.EDI315전송 대상 찾기
				ediSendLists = searchEdi315SendCOP(actVo);
				
				if(!pro_flg.equals("REPLAN") || (ediSendLists != null && ediSendLists.size() > 0 && ediSendLists.get(0).getRplnBatSndFlg().equals("Y") && pro_flg.equals("REPLAN"))){ 
						//7-2.EDI315전송 메서드 호출
						//Edi315SendBC edi315 = new Edi315SendBCImpl();
						//Edi315SendVO edi315VO = null;
						sendingEdiCount = ediSendLists.size();
						log.info("\n Edi315SendVO sendingEdiCount:["+sendingEdiCount+"]========================");
						for(int i = 0; i < ediSendLists.size(); i++){
							Edi315SendVO edi315VO = new Edi315SendVO();
							Edi315SendCopVO edi315CopVO = ediSendLists.get(i);
							
							//7-2-1.Actual Mapping 정상처리의 경우
							
		//					v_cop_no         := getVslDetail.cop_no;
		//					v_cop_dtl_seq	 := getVslDetail.cop_dtl_seq;
		//					v_cntr_no		 := getVslDetail.cntr_no;
		//					v_edi_sts        := getVslDetail.act_stnd_edi_sts_cd;
		//					v_bkg_no         := getVslDetail.bkg_no;
		//					v_nod            := getVslDetail.nod_cd;
		//		            
		//		------            if v_edi_sts is not null then
		//		------    			SCE_EDI_SEND_PRC(v_call_from,    v_cntr_no,  v_edi_sts,      v_bl_no,        v_bkg_no,    
		//		------    			                 in_vsl_cd,  in_skd_voy_no,  in_skd_dir_cd,  in_act_dt,  v_nod, in_usr_id, 
		//		------    			                 in_usr_id,      v_cop_dtl_seq,  v_error_message2, v_err_cd2);
		//		------            end if;  					
							
								edi315VO.setCallFrom("COP");
								edi315VO.setCntrNo(edi315CopVO.getCntrNo());
								edi315VO.setEdiStatus(edi315CopVO.getActStndEdiStsCd());
								edi315VO.setBlNo("");
								edi315VO.setBkgNo(edi315CopVO.getBkgNo());
								//edi315VO.setCurrVvd(actVo.getVslCd()+actVo.getSkdVoyNo()+actVo.getSkdDirCd());
								if(actVo.getVslCd().length()>0 && actVo.getSkdVoyNo().length()>0 && actVo.getSkdDirCd().length()>0){
									edi315VO.setCurrVvd(actVo.getVslCd()+actVo.getSkdVoyNo()+actVo.getSkdDirCd());
								}else{
									edi315VO.setCurrVvd("");
								}
								log.info("\n VSL ACT:: edi315VO.getCurrVvd()"+edi315VO.getCurrVvd()+"------------------");
								//tempVVD = actVo.getVslCd()+actVo.getSkdVoyNo()+actVo.getSkdDirCd();
								edi315VO.setEventDt(actVo.getActDt());
								edi315VO.setEventYard(actVo.getNodCd());
								log.info("\n VSL ACT:: edi315VO.getEventYard()"+edi315VO.getEventYard()+"------------------");
								edi315VO.setCreId(actVo.getCreUsrId());
								edi315VO.setUpdId(actVo.getUpdUsrId());
								edi315VO.setCopNo(edi315CopVO.getCopNo()); // yjlee추가 2010.02.25
								edi315VO.setCopDtlSeq(edi315CopVO.getCopDtlSeq());
								log.info("\n VSL ACT:: edi315VO.getCopDtlSeq()"+edi315VO.getCopDtlSeq()+"------------------");
								//if(edi315VO.getEdiStatus()!=null) edi315.edi315Send(edi315VO);
								if(edi315VO.getEdiStatus()!=null) {
									try{
										edi315.edi315Send(edi315VO);
										//History 추가
										//actVo.setEdiSndRsltFlg("Y");   //<--edi315전송 로직에서 setting
										
									}catch(Exception e){
										log.error("\n [edi315.edi315Send(edi315VO)호출  에러]"+ e.getMessage());
										actVo.setEdiSndRsltFlg("N");
									}
								}
								
								//outCopNo = 	edi315VO.getEdiStatus().substring(0, 2);
						}
			
				}	//if(!pro_flg.equals("REPLAN")){ 끝
				
				
				//Sce Act Rcv If 결과 업데이트
				if(cntCopAll==(currCop+1) || pro_flg.equals("REPLAN")){
					modifySceActRcvIfByError(actVo);
				}
				
				
			}	//mappingCopCount>0 인 경우 끝
			

			
//			//Actual Mapping 완료 후
//			if(!pro_flg.equals("REPLAN") && sendingEdiCount>0) searchSendEDIList(tempVVD+"", "VVD", outCopNo);
			
		}
		

		
	}	
	
	
	
	
//	/**
//	 * New COP만 해당: VSL Actual 재매핑을 위한 보완 <br>  <--To-Be 에서 필요 없겠네!!
//	 * @param SceActRcvIfVO
//	 * @return SceActRcvIfVO
//	 * @exception EventException
//	 */
//	public SceActRcvIfVO searchSceActRcvIf(SceActRcvIfVO actVO) throws EventException{
//		SceActRcvIfVO actEdtVo=null;
//		
//		try {
//
//			actEdtVo = dbDao.searchSceActRcvIf(actVO); 
//			
//		} catch (DAOException de) {
//			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
//		}				
//		
//		return actEdtVo;				
//	}	
	
	
	
	/**
	 * VSL Actual을 매핑할 COP찾기 <br>
	 * 
	 * @param SceActRcvIfVO actVo
	 * @return List<CopDtlActMapgVO>
	 * @exception EventException
	 */
	public List<CopDtlActMapgVO> searchMappingCOP(SceActRcvIfVO actVo) throws EventException{
		List<CopDtlActMapgVO>  lists=null;

		try {

			lists=dbDao.searchMappingCOP(actVo); 
			
		} catch (DAOException de) {
			log.error("\n searchMappingCOP error: "+de.toString(),de);
			//throw new EventException(de.getMessage());
		}		
		
		return lists;
	}			
	
	/**
	 * Current or Next ACT Status의 경우 VSK Actual Mapping & ACT Status 정리
	 * 3-1.현재 대상인 COP Detail에 Actual매핑 & 'F' Status로 업데이트 <br>
	 * 3-2.중간 COP의 Status만 모두 'F'로 업데이트
	 * 3-3.Next COP의 Status만  'C' Status로 업데이트
	 * 
	 * @param CopDtlActMapgVO dtlMapgVO
	 * @param SceActRcvIfVO actVo
	 * @return String
	 * @exception EventException
	 */
	public String  modifyCopDetailNextStatusByVSK(CopDtlActMapgVO dtlMapgVO, SceActRcvIfVO actVo) throws EventException{
		String errCode="";
		
		try {

			errCode=dbDao.modifyCopDetailNextStatusByVSK(dtlMapgVO, actVo);  
			
		} catch (DAOException de) {
			log.error("\n err "+de.toString(),de);
			//throw new EventException(de.getMessage());
		}				
		
		return errCode;			
	}
		
	
	/**
	 * Finish  ACT Status의 경우 VSK Actual Mapping & ACT Status 정리
	 * 4-1.현재 대상인 COP Detail만 Actual 매핑 UPDATE, 추가적으로 Actual의 재업데이트 가능. <br>
	 * 4-2.Pre COP의 Status만 모두 'F'로 UPDATE(Pre COP이전은 모두 'F'로)
	 * 
	 * @param CopDtlActMapgVO dtlMapgVO
	 * @param SceActRcvIfVO actVo
	 * @return String
	 * @exception EventException
	 */
	public String  modifyCopDetailFinishStatusByVSK(CopDtlActMapgVO dtlMapgVO, SceActRcvIfVO actVo) throws EventException{
		String errCode="";
		
		try {

			errCode=dbDao.modifyCopDetailFinishStatusByVSK(dtlMapgVO, actVo);  
			
		} catch (DAOException de) {
			log.error("modifyCopDetailFinishStatusByVSK err: "+de.toString(),de);
			//throw new EventException(de.getMessage());
		}				
		
		return errCode;			
	}

	/**
	 * DTL에 있는 Expt Resolve
	 * 
	 * @param CopDtlActMapgVO dtlMapgVO
	 * @param SceActRcvIfVO actVo
	 * @param String errCd
	 * @param String pro_flg
	 * @return String
	 * @exception EventException
	 */
	public String  addSceActRcvHisByVSK(CopDtlActMapgVO dtlMapgVO, SceActRcvIfVO actVo, String errCd, String pro_flg) throws EventException{
		String errCode="";
		SceActRcvHisVO actHisVO = new SceActRcvHisVO(); 
		String boundCd = "X";

		//***SetUP Start*********************************
			//addSceActRcvHis 처리에서 actHistVo<--actVo매핑!!
			actHisVO.setActRcvDt(actVo.getActRcvDt());
			actHisVO.setActRcvNo(actVo.getActRcvNo());
			actHisVO.setCntrNo(dtlMapgVO.getCntrNo());
			actHisVO.setBkgNo(dtlMapgVO.getBkgNo());
			actHisVO.setMstCopNo(dtlMapgVO.getMstCopNo());
			actHisVO.setActDt(actVo.getActDt());
			actHisVO.setActCd(dtlMapgVO.getActCd());
			actHisVO.setActGdt(actVo.getActGdt());
			actHisVO.setActStsMapgCd(actVo.getActStsMapgCd());
			actHisVO.setNodCd(actVo.getNodCd());
			actHisVO.setActRcvTpCd(actVo.getActRcvTpCd());
			actHisVO.setVslCd(actVo.getVslCd());
			actHisVO.setSkdVoyNo(actVo.getSkdVoyNo());
			actHisVO.setSkdDirCd(actVo.getSkdDirCd());
			actHisVO.setClptIndSeq(actVo.getClptIndSeq());
			actHisVO.setVpsPortCd(actVo.getVpsPortCd());
			actHisVO.setEdiMsgTpCd(actVo.getEdiMsgTpCd());
			actHisVO.setErrMsg(actVo.getErrMsg());
			actHisVO.setCopNo(dtlMapgVO.getCopNo());
			actHisVO.setMstBkgNo(dtlMapgVO.getCopDtlSeq());		//mst_bkg_no컬럼 필요없으니까 cop_dtl_seq값으로 대체 사용, 컬럼 정리 해야겠지?!!
			actHisVO.setEmlSndRsltFlg("N");
			//actHisVO.setEdiSndRsltFlg("N");
			actHisVO.setFaxSndRsltFlg("N");
			actHisVO.setVndrSeq(actVo.getVndrSeq());
			actHisVO.setTrspClzFlg(dtlMapgVO.getCopStsCd());
			actHisVO.setActUmchTpCd(errCd);
			actHisVO.setUmchChkDt(actVo.getUmchChkDt());	//act I/F를  'XX'로 업데이트 한 시간. 즉, 매핑 시작시간
			actHisVO.setRailDestN1stEtaDt(actVo.getRailDestN1stEtaDt());
			boundCd=dtlMapgVO.getCopDtlSeq().compareTo("6000")>0?"I":(dtlMapgVO.getCopDtlSeq().compareTo("4000")<0?"O":"T");
			actHisVO.setBndVskdSeqCd(boundCd);
			actHisVO.setCreTpCd(actVo.getCreTpCd());
			actHisVO.setCreUsrId(actVo.getCreUsrId());
			actHisVO.setUpdUsrId(actVo.getUpdUsrId());
			actHisVO.setUpdDt((dtlMapgVO.getActDt()!=null&&!dtlMapgVO.getActDt().equals(""))?dtlMapgVO.getActDt():actVo.getActDt());  //insert시에 수신Actual과 DtlActual을 비교한다. actgapdesc계산을위해
			actHisVO.setActGapDesc("");		
			
			if(dtlMapgVO.getActDt().equals("") || dtlMapgVO.getActDt()==null) 
				actHisVO.setDupFlg("N");
			else 
				actHisVO.setDupFlg("Y");
			
			if(!pro_flg.equals("REPLAN")){ 
				actHisVO.setEdiSndRsltFlg("Y");		//<--여기서는 calling edi315의미
			}else{
				actHisVO.setEdiSndRsltFlg("N");		//<--여기서는 REPLAN시 'N'으로 setup키로:20100420 
			}	
			
			//***SetUP End***********************************
		    errCode = !addSceActRcvHis(actHisVO)?"000000":"000001";  
		    
			//9-1.최초 or 최종 Actual Data 입력시 COP_FSH_DT,cop_sts_cd ='T' or 'F'로  업데이트: 20100421 
		    actHisVO = modifyCopHeaderStatus(actHisVO, dtlMapgVO.getCopDtlSeq(), null);
		
		return errCode;			
	}

	/**
	 * EDI315전송  <br>
	 * EDI315전송 대상 찾기
	 * 
	 * @param SceActRcvIfVO actVo
	 * @return List<Edi315SendCopVO>
	 * @exception EventException
	 */
	public List<Edi315SendCopVO> searchEdi315SendCOP(SceActRcvIfVO actVo) throws EventException{
		List<Edi315SendCopVO>  ediLists=null;

		try {

			ediLists=dbDao.searchEdi315SendCOP(actVo); 
			
		} catch (DAOException de) {
			log.error("searchEdi315SendCOP err: "+de.toString(),de);
			//throw new EventException(de.getMessage());
		}		
		
		return ediLists;
	}			
	
	/**
	 * MANUAL Actual Mapping<br>
	 * prc_flg : Process Flag (ex. if 'A' then Actual Process else if 'E' then Estimate Process(Door Delivery Update화면에서만 사용)
	 *
	 * @param String cop_no
	 * @param String cop_dtl_seq
	 * @param String act_dt
	 * @param String usr_id
	 * @param String prc_flg
	 * @param String act_sts_cd
	 * @param String nod_cd
	 * @param String act_cd
	 * @exception EventException
	 */
	public void copDetailReceiveMANUAL(String cop_no, String cop_dtl_seq, String act_dt, String usr_id, String prc_flg, String act_sts_cd, String nod_cd, String act_cd) throws EventException{
		//dopdtl.copDetailReceiveMANUAL("CSEL9B26003112","1011", "20091210110000", "system1", "A", "N", "KRPUSYG", "MOTYDO");
		
//		Edi315SendBC edi315 = new Edi315SendBCImpl();
//		Edi315SendVO edi315VO = null;
//		String errCd = "00";
//		String mappingCop = "";
		int updResult = 0;

		
		CopDtlActMapgVO copMapgVO = new CopDtlActMapgVO();
		SceActRcvHisVO actHisVO = new SceActRcvHisVO();
			
		
		//1.Manual Actual 매핑될 COP찾는다
		//mappingCop = searchCopNoSpp(actVo); <--매핑대상이 없을 경우가 없겠죠~!
		
		//1-1.Key생성 및 SetUp************************************************
		//actHisVO = searchSceActRcvHisKey(actHisVO); 
		actHisVO.setCopNo(cop_no);		
		actHisVO.setMstBkgNo(cop_dtl_seq);
		actHisVO.setActDt(act_dt);
		actHisVO.setNodCd(nod_cd);
		actHisVO.setActStsMapgCd(act_cd);
		actHisVO.setActCd(act_cd);
		actHisVO.setActRcvTpCd("4");
		actHisVO.setActUmchTpCd("99");
		actHisVO.setCreUsrId(usr_id);
		actHisVO.setUpdUsrId(usr_id);
		copMapgVO.setCopNo(cop_no);
		copMapgVO.setCopDtlSeq(cop_dtl_seq);
//		copMapgVO.setActDt(act_dt);
		copMapgVO.setActStsCd(act_sts_cd);
		copMapgVO.setNodCd(nod_cd);
		copMapgVO.setActCd(act_cd);
		//******************************************************************
		
		if(prc_flg.equals("E")){
			updResult=1;
		}else{
			//2.값이 건너 뛰고 들어온 경우('N')
			if(act_sts_cd.equals("N")){
				log.info("\n 값이 건너 뛰고 들어온 경우('N') ");
				updResult = modifyCopDetailNextStatusNotInCurrent(copMapgVO.getCopNo(),copMapgVO.getCopDtlSeq());
			}else if(act_sts_cd.equals("F")){	
				//3.'F'인 경우 ACT_DT가 Null 인 것에 ACT_DT만 변경
				log.info("\n 'F'인 경우  ");
				updResult = modifyCopDetailFinishStatus(copMapgVO,actHisVO);
				
				if(updResult==0){
					actHisVO.setActUmchTpCd("02");
					actHisVO.setErrMsg("Duplicated Data");
					//Error 종료 처리 : GOTO point_1
	
				}
				
			}else if(act_sts_cd.equals("C")){	
				updResult=1;
			}
		}
		
		if(updResult>0){
			
			//5.cop detail 의 Bound Scheduling 호출
			if(Integer.parseInt(copMapgVO.getCopDtlSeq())<4000||Integer.parseInt(copMapgVO.getCopDtlSeq())>6000){
				SceCopSkdHisVO skdVo = null;
				skdVo = convertToSkdVo(actHisVO, copMapgVO);
				scheduleCopDetailBound(skdVo);	
			}	
			
			if(prc_flg.equals("A")){
				//7.ACT STS 'C'를 'F'로 변경하고 ACT_DT 업데이트
				modifyCopDetailCurrentStatus(copMapgVO, actHisVO);
					
				//8.ACT STS 'N'를 'C'로 변경하고 ACT_DT 업데이트
			    modifyCopDetailNextStatus(copMapgVO, actHisVO);
				
				//9.최초 or 최종 Actual Data 입력시 COP_FSH_DT,cop_sts_cd ='T' or 'F'로  업데이트
			    actHisVO = modifyCopHeaderStatus(actHisVO, copMapgVO.getCopDtlSeq(), null);
	
			    //13.미주Rail S/O의 VD Port, VD정보 업데이트 
			    modifyTrsRailSo(actHisVO);	
	
				//14.SCE ACTUAL RECEIVE HISTORY
		        addSceActRcvHis(actHisVO);
			}else if(prc_flg.equals("E")){
				//7.ESTM_DT 업데이트
				modifyCopDetailEstimate(copMapgVO, actHisVO);
			}     
		}	
	}	
	

	/**
	 * Search SceActRcvHisKey (1row)<br>
	 * 
	 * @param SceActRcvHisVO actVo
	 * @return SceActRcvHisVO
	 * @exception EventException
	 */
	public SceActRcvHisVO searchSceActRcvHisKey(SceActRcvHisVO actVo) throws EventException{
		SceActRcvHisVO actEdtVo=null;
		
		try {

			actEdtVo = dbDao.searchSceActRcvHisKey(actVo); 
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}				
		
		return actEdtVo;				
	}		
	
	
	/**
	 * Modify Actual Data Receive Date By Temp Role
	 * 
	 * @param SceActRcvIfVO actVo
	 * @throws EventException
	 */
	public void modifyActDatRcvDtByTmpRole(SceActRcvIfVO actVo) throws EventException {
		boolean resultUpd = false;
		actVo.setActUmchTpCd("99");

		List<SceActRcvHisVO> actHisLists = new ArrayList<SceActRcvHisVO>();

		// 1.관련 COP갯수 체크하여 FCL or LCL COP에 따른 BKG No.획득
		actHisLists = searchBkgNoByLCLCOP(actVo);
		
		if( actHisLists != null && actHisLists.size() > 0){
			// COP NO 없을 경우하여, BKG No 대신 B/L No 로 재검색
			for (int i = 0; i < actHisLists.size(); i++) {
				SceActRcvHisVO actHisVO = actHisLists.get(i);

				if (actHisVO.getCopNo() == null || actHisVO.getCopNo().equals("")) {
					actHisVO = searchBlNoByLCLCOP(actHisVO.getBkgNo(), actHisVO.getCntrNo());
					actHisLists.set(i, actHisVO);
				}

			}

			// LCL 화물의 경우, 여러 BKG별 Loop를 돌면서 각 상태값을 변경하는 작업을 시작한다
			for (int i = 0; i < actHisLists.size(); i++) {
				SceActRcvHisVO actHisVO = actHisLists.get(i);
				// h.bkg_no, h.cntr_no, h.cop_no, h.mst_cop_no, h.cntr_tpsz_cd,
				// bl_no
				// 1-1.***SetUP (FCL or LCL COP에 따른 BKG No.등)*************
				actHisVO.setActRcvDt(actVo.getActRcvDt());
				actHisVO.setActRcvNo(actVo.getActRcvNo());
				actHisVO.setActDt(actVo.getActDt());
				actHisVO.setActGdt(actVo.getActGdt());
				actHisVO.setActStsMapgCd(actVo.getActStsMapgCd());
				actHisVO.setNodCd(actVo.getNodCd());
				actHisVO.setActRcvTpCd(actVo.getActRcvTpCd());
				actHisVO.setVslCd(actVo.getVslCd());
				actHisVO.setSkdVoyNo(actVo.getSkdVoyNo());
				actHisVO.setSkdDirCd(actVo.getSkdDirCd());
				actHisVO.setClptIndSeq(actVo.getClptIndSeq());
				actHisVO.setVpsPortCd(actVo.getVpsPortCd());
				actHisVO.setEdiMsgTpCd(actVo.getEdiMsgTpCd());
				actHisVO.setErrMsg(actVo.getErrMsg());
				actHisVO.setEmlSndRsltFlg(actVo.getEmlSndRsltFlg());
				actHisVO.setEdiSndRsltFlg(actVo.getEdiSndRsltFlg());
				actHisVO.setFaxSndRsltFlg(actVo.getFaxSndRsltFlg());
				actHisVO.setVndrSeq(actVo.getVndrSeq());
				actHisVO.setActCd(actVo.getActCd());
				actHisVO.setActUmchTpCd(actVo.getActUmchTpCd());
				actHisVO.setUmchChkDt(actVo.getUmchChkDt());
				actHisVO.setRailDestN1stEtaDt(actVo.getRailDestN1stEtaDt());
				actHisVO.setBndVskdSeqCd(actVo.getBndVskdSeqCd());
				actHisVO.setCreTpCd(actVo.getCreTpCd());
				actHisVO.setCreUsrId(actVo.getCreUsrId());
				actHisVO.setCreDt(actVo.getCreDt());
				actHisVO.setUpdUsrId(actVo.getUpdUsrId());
				actHisVO.setUpdDt(actVo.getUpdDt());
				actHisVO.setCxSndFlg("N");
				actHisVO.setActCd(actVo.getActCd());
				actHisVO.setRailDestN1stEtaDt(actVo.getRailDestN1stEtaDt());
				
				// 2011.05.09 권상준 추가 CHM-201110244-01
				actHisVO.setPodNodCd(actHisLists.get(i).getPodNodCd());
				
				// 획득한 BKG No.중 COP없는 것은 err 코드 정리<--이런 경우 없다!!Test
				// 용******************
				if (actHisVO.getCopNo() == null || actHisVO.getCopNo().equals("")) {
					actVo.setActUmchTpCd("10");
					actVo.setErrMsg("CNTR 관련 COP 없음");
					actHisVO.setActUmchTpCd(actVo.getActUmchTpCd());
					actHisVO.setErrMsg(actVo.getErrMsg());
				}
				// ********************************************************************************
				else if (actHisVO.getActRcvTpCd().equals("3") && actVo.getActStsMapgCd().equals("P")) {

					// 11.Rail ETA처리, P event 수신인지 체크
					/*
					 * P event라면; RL이벤트가 발생하고 AR이벤트가 아직 미수신 상태에서 P이벤트가 수신되었는지
					 * 체크하고
					 */
					/* P이벤트의 RAIL ETA를 COP의 FIRRAD 및 FORRAD에 적용토록 */

					actHisVO.setActUmchTpCd(scheduleCopDetailBoundBy322P(actHisVO));

					actVo.setActUmchTpCd("30");
					actVo.setErrMsg("Node can not be found in COP");
					// Error 종료 처리 : Sce Act Rcv If 결과 업데이트
					// modifySceActRcvIfByError(actVo);

				} else if (actHisVO.getActRcvTpCd().equals("1") || actHisVO.getActRcvTpCd().equals("3")) {
					// 4.DTL의 ACT STS가 'C'인 경우만 검색
					CopDtlActMapgVO dtlMapgVO = new CopDtlActMapgVO();
					dtlMapgVO = searchCopDetailCurrentStatus(actHisVO);
					// log.info("\n dtlMapgVO.getCopNo():"+dtlMapgVO.getCopNo());
					// ACT STS가 'C'인 경우
					if (dtlMapgVO.getCopNo() != null) {
						log.info("\n ACT STS가 'C'인 경우");
						// @to-do dtlMapgVO-->actHisVO&actVO!!!!!!!!!!!!!!!!!!!!

						// 4-1.US rail MVMT data skip 체크:EN/IC/OC/TN인 경우 ERR코드
						// 정리
						// [MVMT]US rail Mvmt data skip 체크:EN/IC/OC/TN인 경우 goto
						// point_1
						if ((dtlMapgVO.getActCd().endsWith("FORRDO") || dtlMapgVO.getActCd().endsWith("FIRRDO")
								|| dtlMapgVO.getActCd().endsWith("FIRRAD") || dtlMapgVO.getActCd().endsWith("FORRAD"))
								&& (dtlMapgVO.getNodCd().substring(0, 2).equals("US") || dtlMapgVO.getNodCd()
										.substring(0, 2).equals("CA"))
								&& (dtlMapgVO.getActStsMapgCd().equals("EN")
										|| dtlMapgVO.getActStsMapgCd().equals("IC")
										|| dtlMapgVO.getActStsMapgCd().equals("OC") || dtlMapgVO.getActStsMapgCd()
										.equals("TN"))) {
							actVo.setActUmchTpCd("60");
							actVo.setErrMsg("US Rail Movement Data(Skip)");
							// modifySceActRcvIfByError(actVo);
							actHisVO.setActUmchTpCd(actVo.getActUmchTpCd());
							actHisVO.setErrMsg(actVo.getErrMsg());
						}
						// 2011.04.28  추가 - 황효근, CHM-201110244-01
						else if(dtlMapgVO.getActStsMapgCd() != null && actHisVO.getPodNodCd().equals(actHisVO.getNodCd()) && dtlMapgVO.getActStsMapgCd().equals("IC")){
//							if(actHisVO.getPodNodCd().equals(actHisVO.getNodCd()) && dtlMapgVO.getActStsMapgCd().equals("IC")) {
								actVo.setActUmchTpCd("61");
								//errCd = "02";
								actVo.setErrMsg("IC 일때 POD Node 와 IC Node가 같으면 Skip");
								modifySceActRcvIfByError(actVo);
								actHisVO.setActUmchTpCd(actVo.getActUmchTpCd());
								actHisVO.setErrMsg(actVo.getErrMsg());
//							}
								
						} else {
							resultUpd = false;

							// 7.ACT STS 'C'를 'F'로 변경하고 ACT_DT 업데이트
							actHisVO.setCreDt(actVo.getActDatRcvDt()); // 20100526
							// resultUpd =
							// modifyCopDetailCurrentStatus(dtlMapgVO,
							// actHisVO);
							resultUpd = modifyActDatRcvDtTmpRole(dtlMapgVO, actHisVO);

							// EDI호출 Log추가
							log.info("\n 10-1.Actual Mapping 정상처리 stnd_edi_sts_cd====");

							// 10-2.CX전송의 경우

						}
						// ACT STS가 'C'가 아닌 경우
					} else {

						int updResult = 0;

						// 4.DTL의 ACT STS가 'C'가 아닌 경우 검색
						// try{
						// CopDtlActMapgVO dtlMapgVO = new CopDtlActMapgVO();
						dtlMapgVO = searchCopDetailNotCurrentStatus(actHisVO);
						// }catch(Exception e){
						log.info("\n err: 8");
						// }

						// 4-1.US rail MVMT data skip 체크:EN/IC/OC/TN인 경우 ERR코드
						// 정리
						// [MVMT]US rail Mvmt data skip 체크:EN/IC/OC/TN인 경우 goto
						// point_1
						if ((dtlMapgVO.getCopNo() != null)
								&& (dtlMapgVO.getActCd().endsWith("FORRDO") || dtlMapgVO.getActCd().endsWith("FIRRDO")
										|| dtlMapgVO.getActCd().endsWith("FIRRAD") || dtlMapgVO.getActCd().endsWith(
										"FORRAD"))
								&& (dtlMapgVO.getNodCd().substring(0, 2).equals("US") || dtlMapgVO.getNodCd()
										.substring(0, 2).equals("CA"))
								&& (dtlMapgVO.getActStsMapgCd().equals("EN")
										|| dtlMapgVO.getActStsMapgCd().equals("IC")
										|| dtlMapgVO.getActStsMapgCd().equals("OC") || dtlMapgVO.getActStsMapgCd()
										.equals("TN"))) {
							actVo.setActUmchTpCd("60");
							actVo.setErrMsg("US Rail Movement Data(Skip)");
//							modifySceActRcvIfByError(actVo);
							actHisVO.setActUmchTpCd(actVo.getActUmchTpCd());
							actHisVO.setErrMsg(actVo.getErrMsg());
						} 
						// 2011.04.28  추가 - 황효근, CHM-201110244-01
						else if(dtlMapgVO.getActStsMapgCd() != null && actHisVO.getPodNodCd().equals(actHisVO.getNodCd()) && dtlMapgVO.getActStsMapgCd().equals("IC")){
//							if(actHisVO.getPodNodCd().equals(actHisVO.getNodCd()) && dtlMapgVO.getActStsMapgCd().equals("IC")) {
								actVo.setActUmchTpCd("61");
								//errCd = "02";
								actVo.setErrMsg("IC 일때 POD Node 와 IC Node가 같으면 Skip");
								modifySceActRcvIfByError(actVo);
								actHisVO.setActUmchTpCd(actVo.getActUmchTpCd());
								actHisVO.setErrMsg(actVo.getErrMsg());
//							}	 
						} else {
							// 5.DTL의 ACT STS가 'C'가 아닌것에서 검색결과 없을때 CNTR교환 시도
							// As-Is 에서는 OC의 경우 CNTR교환처리하였지만
							// To-Be 에서는 CNTR교환 제거 하기로 하였음!
							resultUpd = false;
							if (dtlMapgVO.getCopNo() == null) {
								log.info("\n dtlMapgVO == null: 9");
								// 6.TL의 ACT STS가 'C'가 아닌것에서 검색결과 없을때 ERR코드 정리
								actVo.setActUmchTpCd("30");
								actVo.setErrMsg("Node can not be found in COP");
//								modifySceActRcvIfByError(actVo); // Error 종료 처리
																	// : Sce Act
																	// Rcv If 결과
																	// 업데이트
								log.info("\n modifySceActRcvIfByError: 13");
								actHisVO.setActUmchTpCd(actVo.getActUmchTpCd());
								log.info("\n modifySceActRcvIfByError: 14");
								actHisVO.setErrMsg(actVo.getErrMsg());
								log.info("\n modifySceActRcvIfByError: 15");
								actHisVO.setActUmchTpCd(actVo.getActUmchTpCd());
								actHisVO.setErrMsg(actVo.getErrMsg());

							} else if (dtlMapgVO.getCopNo() != null && dtlMapgVO.getActStsCd().equals("N")) {
								log.info("\n dtlMapgVO.getActStsCd().equals(N): 10");
								// 7.값이 건너 뛰고 들어온 경우('N'), 입력된 DTL을 'C'로 변경 후
								// 중간을 'F'로 변경
								// updResult =
								// modifyCopDetailNextStatusNotInCurrent(dtlMapgVO.getCopNo(),dtlMapgVO.getCopDtlSeq());
								log.info("\n 7.값이 건너 뛰고 들어온 경우('N'), 입력된 DTL을 'C'로 변경 후 중간을 'F'로 변경: 01 updResult:"
										+ updResult);
								// updResult =
								// modifyCopDetailFinishStatus(dtlMapgVO,actHisVO);

								// ACT STS 'C'를 'F'로 변경하고 ACT_DT 업데이트
								actHisVO.setCreDt(actVo.getActDatRcvDt()); // 20100526
								boolean rsltFlg = modifyActDatRcvDtTmpRole(dtlMapgVO, actHisVO);
								log.info("\n 7.값이 건너 뛰고 들어온 경우('N'), ACT STS 'C'를 'F'로 변경하고 ACT_DT 업데이트: 02 rsltFlg:"
										+ rsltFlg);
								if (!resultUpd) {
									actVo.setActUmchTpCd("40");
									actVo.setErrMsg("Duplicated Data");
//									modifySceActRcvIfByError(actVo); // Error 종료
																		// 처리 :
																		// Sce
																		// Act
																		// Rcv
																		// If 결과
																		// 업데이트
									actHisVO.setActUmchTpCd(actVo.getActUmchTpCd());
									actHisVO.setErrMsg(actVo.getErrMsg());
								} else {
									actHisVO.setActUmchTpCd("99");
									actHisVO.setErrMsg("");
								}
								// ACT STS 'N'를 'C'로 변경하고 ACT_DT 업데이트
								// resultUpd =
								// modifyCopDetailNextStatus(dtlMapgVO,
								// actHisVO);
								log.info("\n 7.값이 건너 뛰고 들어온 경우('N'), ACT STS 'N'를 'C'로 변경하고 ACT_DT 업데이트: 02 resultUpd:"
										+ resultUpd);

								// 9-1.최초 or 최종 Actual Data 입력시
								// COP_FSH_DT,cop_sts_cd ='T' or 'F'로 업데이트
								// **'F'일때 CX전송용 flag set
								// 9-2.CNTR MVMT 'XX' Status 발생 시, COP Closed 시킴
								// actHisVO = modifyCopHeaderStatus(actHisVO,
								// dtlMapgVO.getCopDtlSeq());

							} else if (dtlMapgVO.getCopNo() != null && dtlMapgVO.getActStsCd().equals("F")) {
								log.info("\n dtlMapgVO.getActStsCd().equals(F): 11");
								// 8.'F'인 경우 ACT_DT가 Null 인 것에 ACT_DT만 변경
								actHisVO.setCreDt(actVo.getActDatRcvDt()); // 20100526
								boolean rslt =
									 modifyActDatRcvDtTmpRole(dtlMapgVO,actHisVO);
								log.info("\n dtlMapgVO.getActStsCd().equals(F): 12 updResult[" + rslt + "]");
								if (rslt) {
									actVo.setActUmchTpCd("40");
									actVo.setErrMsg("Duplicated Data");
									// modifySceActRcvIfByError(actVo); //Error
									// 종료 처리 : Sce Act Rcv If 결과 업데이트
									actHisVO.setActUmchTpCd(actVo.getActUmchTpCd());
									actHisVO.setErrMsg(actVo.getErrMsg());
								} else {
									resultUpd = true;
									actHisVO.setActUmchTpCd("99");
									actHisVO.setErrMsg("");
								}

							}

							// 10-1.Actual Mapping 정상처리 stnd_edi_sts_cd

						}
					}

				}// Rail ETA처리, P이벤트 끝

				// 12.Actual Unmatch시 EDI 전송
				/********************************************************************/
				/* 정상적인 COP Creation 이 아닌 예외로 EDI만 전송 될 수 있도록 처리 */
				/* 1, node 불일치에 대한 Actual 전송 */
				/* 2, Finish 된 dtl 의 Actual 이 Null 일 경우 update 후 EDI 전송 */
				/* 3, Finish 된 cop 에 대해서도 edi 전송 */
				/********************************************************************/

				// 13.미주Rail S/O의 VD Port, VD정보 업데이트
			} // for
		}

	}
	
	
	/**
	 * Modify Actual Data Receive Date By Temp VSK
	 * 
	 * @param SceActRcvIfVO actVo
	 * @throws EventException
	 */
	public void modifyActDatRcvDtByTmpVSK(SceActRcvIfVO actVo) throws EventException {
//		Edi315SendBC edi315 = new Edi315SendBCImpl();
		
//		int mappingCopCount = 0;
//		int sendingEdiCount = 0;
		int loopCount = 0;
		
//		String errCd = "000000";
//		String tempVVD = "";
//		String outCopNo = "";

		String pro_flg= "REPLAN";
		CopDtlActMapgVO copMapgVO = null;
		int cntCopAll = 1;
//		int currCop = 1;

//		SceActRcvHisVO tmpActHisVO = new SceActRcvHisVO();
//		ObjectCloner.build(actVo, tmpActHisVO);
			
		//List<SceActRcvHisVO> actHisLists = new ArrayList<SceActRcvHisVO>();
		List<CopDtlActMapgVO> copMapgLists = new ArrayList<CopDtlActMapgVO>();
//		List<Edi315SendCopVO> ediSendLists = new ArrayList<Edi315SendCopVO>();
		
		
		//1.New COP만 해당: VSL Actual 재매핑을 위한 보완
		//actVO = searchSceActRcvIf(actVO);  <--To-Be 에서 필요 없겠네!! <--/NIS2010_BATCH/xml/sce/ActualReceive.xml 참조
		
		//2.VSL Actual을 매핑할 COP찾기
		if(pro_flg.equals("REPLAN")){
			copMapgLists = searchMappingCOP(actVo);
			loopCount = copMapgLists.size();
		}else{
			loopCount=1;
		}
		
		
		//VSL Actual이 매핑할 COP 찾기 실패
		if(cntCopAll == 0){
			
			actVo.setActUmchTpCd("20");
			//errCd = "000002";
			actVo.setErrMsg("getCOPInfoFromVSL IS NO DATA");
			
			//Error 종료 처리 : Sce Act Rcv If 결과 업데이트
//			modifySceActRcvIfByError(actVo);
			
		}else{
			//Initialize
			actVo.setActUmchTpCd("99");
			actVo.setErrMsg("");

			//COP 에 VSL Actual을 매핑
			//for(int i = 0; i < copMapgLists.size(); i++){		//20100519. cop단위 트랜잭션을 위해 삭제
			for(int i = 0; i < loopCount; i++){
//				mappingCopCount++;
				//errCd = "000000";
				
				if(pro_flg.equals("REPLAN")){
					//CopDtlActMapgVO copMapgVOByRPN = copMapgLists.get(i);	//20100519. cop단위 트랜잭션을 위해 삭제
					copMapgVO = copMapgLists.get(i);
				}
//				SceActRcvHisVO actHistVO = new SceActRcvHisVO();
				
				
				//3.현재 Mapping대상의 Status가 'C'or'N'인 경우
				if(copMapgVO.getActStsCd().equals("C") || copMapgVO.getActStsCd().equals("N")){
					//3-1.현재 대상인 COP Detail에 Actual매핑 & 'F' Status로 업데이트
					//3-2.중간 COP의 Status만 모두 'F'로 업데이트
					//3-3.Next COP의 Status만  'C' Status로 업데이트 
//					errCd = modifyCopDetailNextStatusByVSK(copMapgVO,actVo);
					
					modifyActDatRcvDtTmpRole(copMapgVO, actVo);
				//4.Mapping대상 COP Status가 'F'인 경우 Actual만 변경	
				}else if(copMapgVO.getActStsCd().equals("F")){
					//4-1.현재 대상인 COP Detail만 Actual 매핑 UPDATE, 추가적으로 Actual의 재업데이트 가능.
					//4-2.Pre COP의 Status만 모두 'F'로 UPDATE(Pre COP이전은 모두 'F'로)
//					errCd = modifyCopDetailFinishStatusByVSK(copMapgVO,actVo);
					modifyActDatRcvDtTmpRole(copMapgVO, actVo);
				}
				
				//5-1.Actual Mapping History 저장
//				addSceActRcvHisByVSK(copMapgVO,actVo,errCd,pro_flg);
				
			}
			
//			//Actual Mapping 완료 후
//			if(!pro_flg.equals("REPLAN") && sendingEdiCount>0) searchSendEDIList(tempVVD+"", "VVD", outCopNo);
			
		}
	
	}
	
	/**
	 * REPLAN관련  Actual Mapping<br>
	 * 
	 * @param SceActRcvIfVO actVo
	 * @exception EventException
	 */
	public void copDetailReceiveREPLAN(SceActRcvIfVO actVo) throws EventException{
		
		if(actVo.getActRcvTpCd().equals("1")||actVo.getActRcvTpCd().equals("3")){
			
			copDetailReceiveMVMT(actVo,"REPLAN"); 
			
		}else if(actVo.getActRcvTpCd().equals("2")){
			
			copDetailReceiveVessel(actVo,"REPLAN",null,1,1);
			
		//}else if(actVo.getActRcvTpCd().equals("4")){
			
			//4 TYPE은 DTL에서 바로 COPY만 하겠지?
		//	if(false) actVo = null;

		}else if(actVo.getActRcvTpCd().equals("9")){	
			
			copDetailReceiveSPP(actVo,"REPLAN"); 
			
		}else if(actVo.getActRcvTpCd().equals("0")){
			
			CopDtlActMapgVO mapgVo = new CopDtlActMapgVO();
			
			mapgVo.setCopNo(actVo.getCopNo());			//copNo  
			mapgVo.setCopDtlSeq(actVo.getCopDtlSeq());	//copDtlSeq
			mapgVo.setActDt(actVo.getActDt());			//일자
			mapgVo.setUpdUsrId(actVo.getUpdUsrId());	//usrid	
			//mapgVo.setSoCd(msgVo.getTrspSoOfcCtyCd());
			//mapgVo.setSoSeq(msgVo.getTrspSoSeq());
			log.info("214 copNo == " + mapgVo.getCopNo());
			log.info("214 copDtlSeq == " + mapgVo.getCopDtlSeq());
			log.info("214 inDate == " + mapgVo.getActDt());
			log.info("214 UPDUSRID == " + mapgVo.getUpdUsrId()+" actVo.getUpdUsrId():"+actVo.getUpdUsrId());
			
			create214SceIf(mapgVo, "replan");
		}
	}
	
	/**
	 * DTL의 ACT STS가 'C'인 경우만 검색 <br>
	 * 
	 * @param SceActRcvHisVO actHisVO
	 * @param CopDtlActMapgVO dtlMapgVO
	 * @return SceCopSkdHisVO
	 * @exception EventException
	 */
	private SceCopSkdHisVO convertToSkdVo(SceActRcvHisVO actHisVO, CopDtlActMapgVO dtlMapgVO) throws EventException{
		SceCopSkdHisVO skdVO = new SceCopSkdHisVO();
		String skdBndCd = Integer.parseInt(dtlMapgVO.getCopDtlSeq())>6000?"IB":(Integer.parseInt(dtlMapgVO.getCopDtlSeq())<4000?"OB":"TS");

		skdVO.setSkdRcvDt(actHisVO.getActRcvDt());
		skdVO.setActRcvNo(actHisVO.getActRcvNo());
		skdVO.setSkdBndCd(skdBndCd);
		skdVO.setCopNo(dtlMapgVO.getCopNo());
		skdVO.setFmCopDtlSeq(dtlMapgVO.getCopDtlSeq());
		skdVO.setActCd(dtlMapgVO.getActCd());
		skdVO.setAftActDt(actHisVO.getActDt());
		skdVO.setNodCd(dtlMapgVO.getNodCd());
		skdVO.setRcvEvntProcFlg("AA");
		
		skdVO.setSkdMapgCd(actHisVO.getActStsMapgCd());
		skdVO.setSkdNodCd(actHisVO.getNodCd());
		skdVO.setSkdRcvTpCd(actHisVO.getActRcvTpCd());
		skdVO.setVslCd(dtlMapgVO.getVslCd());
		skdVO.setSkdVoyNo(dtlMapgVO.getSkdVoyNo());
		skdVO.setSkdDirCd(dtlMapgVO.getSkdDirCd());
		skdVO.setClptCd(actHisVO.getVpsPortCd());
		skdVO.setClptIndSeq(actHisVO.getClptIndSeq());
		skdVO.setEdiMsgTpCd(actHisVO.getEdiMsgTpCd());
		skdVO.setErrMsg(actHisVO.getErrMsg());
		
		skdVO.setBkgNo(actHisVO.getBkgNo());
		skdVO.setCntrNo(actHisVO.getCntrNo());
		skdVO.setMstCopNo(actHisVO.getMstCopNo());
		skdVO.setCreUsrId(actHisVO.getCreUsrId());
		skdVO.setUpdUsrId(actHisVO.getUpdUsrId());
		
		skdVO.setCntrTpszCd(actHisVO.getCntrTpszCd());  // 20130820 Inland Dwell 수정 
		
		skdVO.setDupFlg(dtlMapgVO.getActDt()!=null&&!dtlMapgVO.getActDt().equals("")?"Y":"N");
		
		skdVO.setBfrActDt(dtlMapgVO.getActDt());
		
		return skdVO;			
	}
	
	/**
	 * 미주Rail S/O의 VD Port, VD정보 업데이트  <br>
	 * 
	 * @param SceActRcvHisVO actHisVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean modifyTrsRailSo(SceActRcvHisVO actHisVO) throws EventException{
		boolean resultFlag=false;
		
		try {

			resultFlag=dbDao.modifyTrsRailSo(actHisVO)>0?true:false; 
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}				
		
		return resultFlag;			
	}
	

	/**
	 * INSERT INTO SCE_ACT_RCV_HIS : SCE ACTUAL RECEIVE HISTORY (1row)<br>
	 * 
	 * @param SceActRcvHisVO actHisVo
	 * @return boolean
	 * @exception EventException
	 */
	public boolean addSceActRcvHis(SceActRcvHisVO actHisVo) throws EventException{
		boolean resultFlag=false;
		
		try {

			resultFlag=dbDao.addSceActRcvHis(actHisVo)>0?true:false; 
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			//throw new EventException(de.getMessage());
		}		
		
		return resultFlag;
	}	
	
	/**
	 * COP Detail 의 Rail Interchange 구간 유무 <br>
	 * @param SceActRcvHisVO actHisVO
	 * @return String
	 * @exception DAOException
	 */	
	public String checkRailInterchange(SceActRcvHisVO actHisVO) throws EventException {

		String chkYn = "N";
		try {
			
			chkYn = dbDao.checkRailInterchange(actHisVO);
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			//throw new EventException(de.getMessage());
		}
		
		return chkYn;
	}

	/**
	 * INSERT INTO SCE_CSM_TGT_EUR : From MVMT to SCE (1row)<br>
	 * 구주 POL, POD 실제 하역 VVD 를 가진 BKG 은 모두 CSM 전송 대상이 된다
	 * 
	 * @param SceActRcvIfVO actVo
	 * @return boolean
	 * @exception EventException
	 */
	private boolean addSceCSMTgtEurVO(SceActRcvIfVO actVo) throws EventException{
		boolean resultFlag=false;
		try {
			if (dbDao.checkEurBndForCSM(actVo)) {
				if(!dbDao.checkEurCmdtForCSM(actVo)){ // Exclude Not EU Commodity (Outbound Only)
					resultFlag=dbDao.addSceCSMTgtEurVO(actVo)>0?true:false;
				}
			}	
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}		
		return resultFlag;
	}
}