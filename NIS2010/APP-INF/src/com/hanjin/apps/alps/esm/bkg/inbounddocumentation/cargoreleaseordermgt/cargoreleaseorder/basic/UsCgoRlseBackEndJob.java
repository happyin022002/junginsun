/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : CargoReleaseOrderBCImpl.java
*@FileTitle      :
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.04.30
*@LastModifier   : 임진영
*@LastVersion    : 1.0
* 2009.04.30 임진영
* 1.0 Creation
* History 
* 2011.07.15 김진승 [CHM-201111820] Split 03-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hanjin.apps.alps.esd.sce.edi315send.basic.Edi315SendBC;
import com.hanjin.apps.alps.esd.sce.edi315send.basic.Edi315SendBCImpl;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315AmsDataVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration.UsaCustomsTransmissionDBDAO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration.CargoReleaseOrderDBDAO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseBkbcBlVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseBkbcFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseBkbcFocVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseBkbcSceVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseSearchVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgCgoRlseVO;

/**
 * ALPS-CargoReleaseOrderMgt Business Logic Basic Command implementation<br>
 * - ALPS-CargoReleaseOrderMgt 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Lim Jin Young
 * @see ESM_BKG_1001EventResponse,FullReleaseOrderBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class UsCgoRlseBackEndJob extends BackEndCommandSupport {

	/**
	 * serializable ID
	 */
	private static final long serialVersionUID = -3584808021250066053L;


	/**
	 * SSO account
	 */
	private SignOnUserAccount account;
	private String blNo;
	private String newPodCd = "";
	private String oldPodCd = "";
	private String newPodYdCd = "";
	private String oldPodYdCd = "";
	private String eventId = "";
	
	public String getBlNo() {
		return blNo;
	}
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Backend job을 위한 DAO
	 */
	private CargoReleaseOrderDBDAO dbDao;
	
	/**
	 * 생성자
	 * @param CargoReleaseOrderDBDAO dbDao
	 * @param SignOnUserAccount account
	 * @param String blNo
	 */
	public UsCgoRlseBackEndJob(CargoReleaseOrderDBDAO dbDao,SignOnUserAccount account,String blNo){
		this.dbDao = dbDao;
		this.account = account;
		this.blNo = blNo;
		//this.account = account;
	}
	/**
	 * 생성자
	 * @param CargoReleaseOrderDBDAO dbDao
	 * @param SignOnUserAccount account
	 * @param BkgCgoRlseVO bkgCgoRlseVo
	 */
	public UsCgoRlseBackEndJob(CargoReleaseOrderDBDAO dbDao,SignOnUserAccount account,BkgCgoRlseVO bkgCgoRlseVo){
		this.dbDao = dbDao;
		this.account = account;
		this.blNo = bkgCgoRlseVo.getBlNo();
		this.newPodCd = bkgCgoRlseVo.getNewPodCd();
		this.oldPodCd = bkgCgoRlseVo.getOldPodCd();
		this.newPodYdCd = bkgCgoRlseVo.getNewPodYdCd();
		this.oldPodYdCd = bkgCgoRlseVo.getOldPodYdCd();
		this.eventId = bkgCgoRlseVo.getEventId();
		
	}
	/**
	 * doStart
	 * @return Object
	 * @exception Exception
	 */
	public Object doStart() throws Exception {
		this.bkbcUsCgoEdi(this.blNo);
		return null;
	}
	/**
	 * FOC 관리 시작
	 * @param blNo
	 * @exception Exception
	 */
	private void bkbcUsCgoEdi(String blNo) throws Exception{
		
		boolean sendCtFlag = false;
		long startTime1 = System.currentTimeMillis();
		/***************************
	   	  * 3. FOC 관리 시작
	   	  ****************************/
	   	 UsCgoRlseBkbcBlVO usCgoRlseBkbc = new UsCgoRlseBkbcBlVO();
	   	 usCgoRlseBkbc.setBlNo(blNo);
	   	 log.error("bkbcUsCgoEdi Start blNo: "+usCgoRlseBkbc.getBlNo());
	   	 log.debug("~~~~~~~~~~~~ his_seq : "+usCgoRlseBkbc.getHisSeq());
	   	
	   	// DO_HLD_FLG가 'Y'일 경우, 이하의 처리를 수행하지 않는다.
	   	UsCgoRlseSearchVO searchVo = new UsCgoRlseSearchVO();
	   	searchVo.setBlNo(blNo);
	   	List<UsCgoRlseListVO> list = dbDao.searchUsCgoRlseList(searchVo);
	   	if(list != null && list.size() > 0){
	   		// 1건만 비교한다.
	   		UsCgoRlseListVO usCgoRlseListVO = (UsCgoRlseListVO)list.get(0);
	   		if("Y".equals(usCgoRlseListVO.getDoHldFlg())){
		   		//전송 대상이 아닐 경우 : The B/L you selected for Carriers' Release is not applicable to transmit.
		   		throw new EventException(new ErrorHandler("BKG40085").getMessage());
	   		}
	   	}
	   	
	   	//------------------------------------------------------------
	   	//Cargo Release Check Data Setting
	    //------------------------------------------------------------
	   	usCgoRlseBkbc = this.getCheckData(usCgoRlseBkbc);
	   	
	   	
	   	 log.debug("------------------------------------------------------------");
	   	 //log.debug("----------- usCgoRlseBkbc "+usCgoRlseBkbc.getColumnValues());
	   	 log.debug("~~~~~~~~~~~getCheckData    "+ usCgoRlseBkbc.getColumnValues());
	   	 log.debug("------------------------------------------------------------");
	   	 
	   	 
	   	 String ipiLclCd = usCgoRlseBkbc.getIpiStatus()==null?"":usCgoRlseBkbc.getIpiStatus();
	   	 String crEdiCd = usCgoRlseBkbc.getCgorEdiSndCd()==null?"":usCgoRlseBkbc.getCgorEdiSndCd();
	   	 String cstmsFlg = usCgoRlseBkbc.getCValue()==null?"":usCgoRlseBkbc.getCValue();
	   	 String focYdCd = usCgoRlseBkbc.getFullRlseEdiCd()==null?"":usCgoRlseBkbc.getFullRlseEdiCd();
	   	 
	   	 String newFrtFlg = usCgoRlseBkbc.getNewFrtCltFlg()==null?"":usCgoRlseBkbc.getNewFrtCltFlg();
	   	 String newOblFlg = usCgoRlseBkbc.getNewOblRdemFlg()==null?"":usCgoRlseBkbc.getNewOblRdemFlg();
	   	 String newCstmsFlg = usCgoRlseBkbc.getNewCstmsClrCd()==null?"":usCgoRlseBkbc.getNewCstmsClrCd();
	   		
	   	 String oldFrtFlg = usCgoRlseBkbc.getOldFrtCltFlg()==null?"":usCgoRlseBkbc.getOldFrtCltFlg();
	   	 String oldOblFlg = usCgoRlseBkbc.getOldOblRdemFlg()==null?"":usCgoRlseBkbc.getOldOblRdemFlg();
	   	 String oldCstmsFlg = usCgoRlseBkbc.getOldCstmsClrCd()==null?"":usCgoRlseBkbc.getOldCstmsClrCd();
	   	 
	   	 String pltlCnt   = usCgoRlseBkbc.getPartialCnt()==null?"0":usCgoRlseBkbc.getPartialCnt();
	   	 String pltlClrCnt = usCgoRlseBkbc.getPartialClear()==null?"0":usCgoRlseBkbc.getPartialClear();
	   //	 String allCInd   = usCgoRlseBkbc.getAllCInd()==null?"0":usCgoRlseBkbc.getAllCInd();
	   	 
	   	 String cstmsDpFlg = usCgoRlseBkbc.getCstmsDspoCd()==null?"":usCgoRlseBkbc.getCstmsDspoCd();
	
	   	 
	   	log.debug("Model 8 값비교를 위한  전체값 출력 ");
	   	log.debug("--- ipiLclCd ==========> '" + ipiLclCd + "'");
	   	
	   	log.debug("--- crEdiCd ==========> '" + crEdiCd + "'");
	   	log.debug("--- cstmsFlg ==========> '" + cstmsFlg + "'");
	   	log.debug("--- focYdCd ==========> '" + focYdCd + "'");
	   	log.debug("--- setTermId ==========> '" + focYdCd + "'");
	   	
	   	log.debug("--- newFrtFlg ==========> '" + newFrtFlg + "'");
	   	log.debug("--- newOblFlg ==========> '" + newOblFlg + "'");
	   	log.debug("--- newCstmsFlg ==========> '" + newCstmsFlg + "'");
	   	
	   	log.debug("--- oldFrtFlg ==========> '" + oldFrtFlg + "'");
	   	log.debug("--- oldOblFlg ==========> '" + oldOblFlg + "'");
	   	
	   	log.debug("--- pltlCnt ==========> '" + pltlCnt + "'");
	   	log.debug("--- pltlClrCnt ==========> '" + pltlClrCnt + "'");
	   	
	   	log.debug("--- cstmsDpFlg ==========> '" + cstmsDpFlg + "'");	   	
	   	
	   	
	  //----------------------------------
	   	//해당 원 BL 이 Partial 인경우 나머지 BL 들을 찾는다.
	   	//나머지 BL들이 Customs Clear가 되지 않은경우 BackEnd 수행하지 않음.
	   	//----------------------------------
	  //2010.04.19. 현업에 의해 partial을 더이상 체크하지 않는다.
	  //----------------------------------
	   	/*
	   	if(Integer.parseInt(pltlCnt) > 0
	   			&& Integer.parseInt(pltlCnt) != Integer.parseInt(allCInd)
	   			&& !pltlClrCnt.equals("0")
	   	){
	   		throw new EventException(new ErrorHandler("BKG40108").getMessage());
	   	}
	   	*/
	   	
	   	
	   	
	   	 
	   	 //model No. 9
	   	 
	   	 //CR Case 1
	   	 //log.debug("------------ ipiLclCd = "+ipiLclCd);
	   	 //log.debug("------------ crEdiCd = "+crEdiCd);
	   	 //log.debug("------------ cstmsFlg = "+cstmsFlg);
	   	 //log.debug("------------ focYdCd = "+focYdCd);
	   	 //log.debug("------------ newFrtFlg = "+newFrtFlg);
	   	 //log.debug("------------ newOblFlg = "+newOblFlg);
	   	 //log.debug("------------ newCstmsFlg = "+newCstmsFlg);
	   	 //log.debug("------------ oldFrtFlg = "+oldFrtFlg);
	   	 //log.debug("------------ oldOblFlg = "+oldOblFlg);
	   	 //log.debug("------------ pltlCnt = "+pltlCnt);
	   	 //log.debug("------------ pltlClrCnt = "+pltlClrCnt);
	   	 
	   	UsCgoRlseBkbcFocVO focVO = new UsCgoRlseBkbcFocVO();
	   	
//	   	if((oldCstmsFlg.equals(newCstmsFlg) == false) ||
//	   			(oldFrtFlg.equals(newFrtFlg)     == false) ||
//	   			(oldOblFlg.equals(newOblFlg)     == false) )
//	   	{
	   		//SCE 로 EDI를 보내기 위함.	   		
	   		log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	   		log.debug("--------------------- SCE Start -----------");
	   		
	   		focVO.setBlNo(usCgoRlseBkbc.getBlNo());
	   		focVO.setHisSeq(usCgoRlseBkbc.getHisSeq());
	   		

		   	//SCE에 EDI 발생정보전송
		   	//Model No. 19
		   	//«» searchSceMsgIdCnt ( [in] blNo : String , [in] hisSeq : Number ) : usCgoRlseBkbcSceVO 
		   	
		   	UsCgoRlseBkbcSceVO sceVO = dbDao.searchSceMsgIdCnt(usCgoRlseBkbc);
		   	Edi315SendBC bc = new Edi315SendBCImpl();
		   	
		   	if(sceVO == null ){
		   		sceVO = new UsCgoRlseBkbcSceVO();
		   	}
		   	
		   	long startTime2 = System.currentTimeMillis();
		   	log.debug("--------------- startTime2 - startTime1 " + ((startTime2-startTime1)/1000));
		   
		   	try{
		   	//Model No. 20 ~ 28
		   	this.priLog("model No. 20 ~ 28", sceVO);
		   	if(sceVO.getSceCc() != null 
		   			&& sceVO.getSceCc().equals("Y") && Integer.parseInt(sceVO.getSceCcCnt()) == 0){	   		
		   		focVO.setSceMsgId("CC");
		   		log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			   	log.debug("------------------------SCE 비교 IF " + focVO.getSceMsgId()+" Start -----------------------");	   		
		   		this.printValue("sceVO.getSceCc()",sceVO.getSceCc());
		   		this.printValue("sceVO.getSceCcCnt()",sceVO.getSceCcCnt());
		   		this.printValue("focVO.getSceMsgId()",focVO.getSceMsgId());
		   		
		   		//focVO.setSceScsCd(bc.edi315AMSSend( focVO.getBlNo(), focVO.getSceMsgId()));	
		   		//SCE 호출
		   		//2010.02.04 SCE 모듈의 Method 변경건으로 인한 처리 Start
		   		
		   		Edi315AmsDataVO amsDataVO = new Edi315AmsDataVO();
		   		
		   		//amsDataVO.setBlNo(usCgoRlseBkbc.getBlNo());
		   		//amsDataVO.setEdiSts("CC");
		   		amsDataVO.setBlNo(focVO.getBlNo());
		   		amsDataVO.setEdiSts(focVO.getSceMsgId());
		   		amsDataVO.setEventDt(sceVO.getEventDt());
		   		amsDataVO.setEventYd(sceVO.getEventYd());
		   		
		   		focVO.setSceScsCd(bc.addSceEdiAmsIf( amsDataVO));
		   		
		   		//2010.02.04 SCE 모듈의 Method 변경건으로 인한 처리 End
		   		
		   		//focVO.setBlNo(usCgoRlseBkbc.getBlNo());
		   		//focVO.setHisSeq(usCgoRlseBkbc.getHisSeq());
		   		
		   		//Model No.29
		   		dbDao.addUsCgoRlsLogSceRslt(focVO,this.account);
		   		log.debug("------------------------SCE 비교 IF " + focVO.getSceMsgId()+" End -----------------------");
			   	log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		   	}
		   	if(sceVO.getSceCf() != null 
		   			&& sceVO.getSceCf().equals("Y") && Integer.parseInt(sceVO.getSceCfCnt()) == 0){   		
		   		focVO.setSceMsgId("CR");
		   		log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		   		log.debug("------------------------SCE 비교 IF " + focVO.getSceMsgId()+" Start -----------------------");
		   		this.printValue("sceVO.getSceCf()",sceVO.getSceCf());
		   		this.printValue("sceVO.getSceCfCnt()",sceVO.getSceCfCnt());
		   		this.printValue("focVO.getSceMsgId()",focVO.getSceMsgId());
		   		//SCE로 Message ID 송신시, BKG에서는 'CF', SCE는 'CR'로 관리한다.
		   		//focVO.setSceScsCd(bc.edi315AMSSend( focVO.getBlNo(), focVO.getSceMsgId()));	
		   		//SCE 호출
		   		//2010.02.04 SCE 모듈의 Method 변경건으로 인한 처리 Start
		   		
		   		Edi315AmsDataVO amsDataVO = new Edi315AmsDataVO();

		   		//amsDataVO.setBlNo(usCgoRlseBkbc.getBlNo());
		   		//amsDataVO.setEdiSts("CR");
		   		
		   		amsDataVO.setBlNo(focVO.getBlNo());
		   		amsDataVO.setEdiSts(focVO.getSceMsgId());
		   		amsDataVO.setEventDt(sceVO.getEventDt());
		   		amsDataVO.setEventYd(sceVO.getEventYd());
		   		focVO.setSceScsCd(bc.addSceEdiAmsIf( amsDataVO));
		   		
		   		//2010.02.04 SCE 모듈의 Method 변경건으로 인한 처리 End
		   		//focVO.setBlNo(usCgoRlseBkbc.getBlNo());
		   		//focVO.setHisSeq(usCgoRlseBkbc.getHisSeq());
		   		dbDao.addUsCgoRlsLogSceRslt(focVO,this.account);
		   		log.debug("------------------------SCE 비교 IF " + focVO.getSceMsgId()+" End -----------------------");
			   	log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		   	}
		   	
		   	if(sceVO.getSceCt() != null 
		   			&& sceVO.getSceCt().equals("Y") && Integer.parseInt(sceVO.getSceCtCnt()) == 0){	   		
		   		focVO.setSceMsgId("CT");
		   		log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		   		log.debug("------------------------SCE 비교 IF " + focVO.getSceMsgId()+" Start -----------------------");
		   		this.printValue("sceVO.getSceCt()",sceVO.getSceCt());
		   		this.printValue("sceVO.getSceCtCnt()",sceVO.getSceCtCnt());
		   		this.printValue("focVO.getSceMsgId()",focVO.getSceMsgId());	
		   		//SCE 호출
		   		//2010.04.09 SCE 모듈의 Method 변경건으로 인한 처리 Start
		   		
		   		Edi315AmsDataVO amsDataVO = new Edi315AmsDataVO();

		   		//amsDataVO.setBlNo(usCgoRlseBkbc.getBlNo());
		   		//amsDataVO.setEdiSts("CT");
		   		
		   		amsDataVO.setBlNo(focVO.getBlNo());
		   		amsDataVO.setEdiSts(focVO.getSceMsgId());
		   		amsDataVO.setEventDt(sceVO.getEventDt());
		   		amsDataVO.setEventYd(sceVO.getEventYd());
		   		focVO.setSceScsCd(bc.addSceEdiAmsIf( amsDataVO));
		   		
		   		//2010.02.04 SCE 모듈의 Method 변경건으로 인한 처리 End
		   		//focVO.setBlNo(usCgoRlseBkbc.getBlNo());
		   		//focVO.setHisSeq(usCgoRlseBkbc.getHisSeq());
		   		dbDao.addUsCgoRlsLogSceRslt(focVO,this.account);
		   		log.debug("------------------------SCE 비교 IF " + focVO.getSceMsgId()+" End -----------------------");
			   	log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		   	}
		   	
		   	
		   	if(sceVO.getSceCr() != null 
		   			&& sceVO.getSceCr().equals("Y") && Integer.parseInt(sceVO.getSceCrCnt()) == 0){		
		   		focVO.setSceMsgId("CU");
		   		log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		   		log.debug("------------------------SCE 비교 IF " + focVO.getSceMsgId()+" Start -----------------------");
		   		this.printValue("sceVO.getSceCr()",sceVO.getSceCr());
		   		this.printValue("sceVO.getSceCrCnt()",sceVO.getSceCrCnt());
		   		this.printValue("focVO.getSceMsgId()",focVO.getSceMsgId());
		   		this.printValue("sceVO.getEventDt()",sceVO.getEventDt());
		   		this.printValue("sceVO.getEventYd()",sceVO.getEventYd());
		   		//SCE로 Message ID 송신시, BKG에서는 'CR', SCE는 'CU'로 관리한다.
		   		//focVO.setSceScsCd(bc.edi315AMSSend( focVO.getBlNo(), focVO.getSceMsgId()));	
		   		//SCE 호출
		   		//2010.02.04 SCE 모듈의 Method 변경건으로 인한 처리 Start
		   		
		   		Edi315AmsDataVO amsDataVO = new Edi315AmsDataVO();

		   		//amsDataVO.setBlNo(usCgoRlseBkbc.getBlNo());
		   		//amsDataVO.setEdiSts("CU");
		   		
		   		amsDataVO.setBlNo(focVO.getBlNo());
		   		amsDataVO.setEdiSts(focVO.getSceMsgId());
		   		amsDataVO.setEventDt(sceVO.getEventDt());
		   		amsDataVO.setEventYd(sceVO.getEventYd());
		   		focVO.setSceScsCd(bc.addSceEdiAmsIf( amsDataVO));
		   		
		   		//2010.02.04 SCE 모듈의 Method 변경건으로 인한 처리 End
		   		//focVO.setBlNo(usCgoRlseBkbc.getBlNo());
		   		//focVO.setHisSeq(usCgoRlseBkbc.getHisSeq());
		   		dbDao.addUsCgoRlsLogSceRslt(focVO,this.account);
		   		log.debug("------------------------SCE 비교 IF " + focVO.getSceMsgId()+" End -----------------------");
			   	log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		   	}
		   	if(sceVO.getSceFr() != null
		   			&& sceVO.getSceFr().equals("Y") && Integer.parseInt(sceVO.getSceFrCnt()) == 0){   		
		   		focVO.setSceMsgId("FR");
		   		log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		   		log.debug("------------------------SCE 비교 IF " + focVO.getSceMsgId()+" Start -----------------------");
		   		this.printValue("sceVO.getSceFr()",sceVO.getSceFr());
		   		this.printValue("sceVO.getSceFrCnt()",sceVO.getSceFrCnt());
		   		this.printValue("focVO.getSceMsgId()",focVO.getSceMsgId());
		   		//focVO.setSceScsCd(bc.edi315AMSSend( focVO.getBlNo(), focVO.getSceMsgId()));	
		   		//SCE 호출
		   		//2010.02.04 SCE 모듈의 Method 변경건으로 인한 처리 Start
		   		
		   		Edi315AmsDataVO amsDataVO = new Edi315AmsDataVO();

		   		//amsDataVO.setBlNo(usCgoRlseBkbc.getBlNo());
		   		//amsDataVO.setEdiSts("FR");
		   		
		   		amsDataVO.setBlNo(focVO.getBlNo());
		   		amsDataVO.setEdiSts(focVO.getSceMsgId());
		   		amsDataVO.setEventDt(sceVO.getEventDt());
		   		amsDataVO.setEventYd(sceVO.getEventYd());
		   		focVO.setSceScsCd(bc.addSceEdiAmsIf( amsDataVO));
		   		
		   		//2010.02.04 SCE 모듈의 Method 변경건으로 인한 처리 End
		   		//focVO.setBlNo(usCgoRlseBkbc.getBlNo());
		   		//focVO.setHisSeq(usCgoRlseBkbc.getHisSeq());
		   		dbDao.addUsCgoRlsLogSceRslt(focVO,this.account);
		   		log.debug("------------------------SCE 비교 IF " + focVO.getSceMsgId()+" End -----------------------");
			   	log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		   	}
		   	if(sceVO.getSceHr() != null
		   			&& sceVO.getSceHr().equals("Y") && Integer.parseInt(sceVO.getSceHrCnt()) == 0){ 		
		   		focVO.setSceMsgId("HR");
		   		log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		   		log.debug("------------------------SCE 비교 IF " + focVO.getSceMsgId()+" Start -----------------------");
		   		this.printValue("sceVO.getSceHr()",sceVO.getSceHr());
		   		this.printValue("sceVO.getSceHrCnt()",sceVO.getSceHrCnt());
		   		this.printValue("focVO.getSceMsgId()",focVO.getSceMsgId());
		   		//focVO.setSceScsCd(bc.edi315AMSSend( focVO.getBlNo(), focVO.getSceMsgId()));	
		   		//SCE 호출
		   		//2010.02.04 SCE 모듈의 Method 변경건으로 인한 처리 Start
		   		
		   		Edi315AmsDataVO amsDataVO = new Edi315AmsDataVO();

		   		//amsDataVO.setBlNo(usCgoRlseBkbc.getBlNo());
		   		//amsDataVO.setEdiSts("HR");
		   		
		   		amsDataVO.setBlNo(focVO.getBlNo());
		   		amsDataVO.setEdiSts(focVO.getSceMsgId());
		   		amsDataVO.setEventDt(sceVO.getEventDt());
		   		amsDataVO.setEventYd(sceVO.getEventYd());
		   		focVO.setSceScsCd(bc.addSceEdiAmsIf( amsDataVO));
		   		
		   		//2010.02.04 SCE 모듈의 Method 변경건으로 인한 처리 End
		   		//focVO.setBlNo(usCgoRlseBkbc.getBlNo());
		   		//focVO.setHisSeq(usCgoRlseBkbc.getHisSeq());
		   		dbDao.addUsCgoRlsLogSceRslt(focVO,this.account);
		   		log.debug("------------------------SCE 비교 IF " + focVO.getSceMsgId()+" End -----------------------");
			   	log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		   	}
		   	if(sceVO.getSceOb() != null
		   			&& sceVO.getSceOb().equals("Y") && Integer.parseInt(sceVO.getSceObCnt()) == 0){	   		
		   		focVO.setSceMsgId("OB");
		   		log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		   		log.debug("------------------------SCE 비교 IF " + focVO.getSceMsgId()+" Start -----------------------");
		   		this.printValue("sceVO.getSceOb()",sceVO.getSceOb());
		   		this.printValue("sceVO.getSceObCnt()",sceVO.getSceObCnt());
		   		this.printValue("focVO.getSceMsgId()",focVO.getSceMsgId());
		   		//focVO.setSceScsCd(bc.edi315AMSSend( focVO.getBlNo(), focVO.getSceMsgId()));	
		   		//SCE 호출
		   		//2010.02.04 SCE 모듈의 Method 변경건으로 인한 처리 Start
		   		
		   		Edi315AmsDataVO amsDataVO = new Edi315AmsDataVO();

		   		//amsDataVO.setBlNo(usCgoRlseBkbc.getBlNo());
		   		//amsDataVO.setEdiSts("OB");
		   		
		   		amsDataVO.setBlNo(focVO.getBlNo());
		   		amsDataVO.setEdiSts(focVO.getSceMsgId());
		   		amsDataVO.setEventDt(sceVO.getEventDt());
		   		amsDataVO.setEventYd(sceVO.getEventYd());
		   		focVO.setSceScsCd(bc.addSceEdiAmsIf( amsDataVO));
		   		
		   		//2010.02.04 SCE 모듈의 Method 변경건으로 인한 처리 End
		   		//focVO.setBlNo(usCgoRlseBkbc.getBlNo());
		   		//focVO.setHisSeq(usCgoRlseBkbc.getHisSeq());
		   		dbDao.addUsCgoRlsLogSceRslt(focVO,this.account);
		   		log.debug("------------------------SCE 비교 IF " + focVO.getSceMsgId()+" End -----------------------");
			   	log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		   	}
		   	if(sceVO.getScePa() != null
		   			&& sceVO.getScePa().equals("Y") && Integer.parseInt(sceVO.getScePaCnt()) == 0){		
		   		focVO.setSceMsgId("PA");
		   		log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		   		log.debug("------------------------SCE 비교 IF " + focVO.getSceMsgId()+" Start -----------------------");
		   		this.printValue("sceVO.getScePa()",sceVO.getScePa());
		   		this.printValue("sceVO.getScePaCnt()",sceVO.getScePaCnt());
		   		this.printValue("focVO.getSceMsgId()",focVO.getSceMsgId());
		   		//focVO.setSceScsCd(bc.edi315AMSSend( focVO.getBlNo(), focVO.getSceMsgId()));	
		   		//SCE 호출
		   		//2010.02.04 SCE 모듈의 Method 변경건으로 인한 처리 Start
		   		
		   		Edi315AmsDataVO amsDataVO = new Edi315AmsDataVO();

		   		//amsDataVO.setBlNo(usCgoRlseBkbc.getBlNo());
		   		//amsDataVO.setEdiSts("PA");
		   		
		   		amsDataVO.setBlNo(focVO.getBlNo());
		   		amsDataVO.setEdiSts(focVO.getSceMsgId());
		   		amsDataVO.setEventDt(sceVO.getEventDt());
		   		amsDataVO.setEventYd(sceVO.getEventYd());
		   		focVO.setSceScsCd(bc.addSceEdiAmsIf( amsDataVO));
		   		
		   		//2010.02.04 SCE 모듈의 Method 변경건으로 인한 처리 End
		   		//focVO.setBlNo(usCgoRlseBkbc.getBlNo());
		   		//focVO.setHisSeq(usCgoRlseBkbc.getHisSeq());
		   		dbDao.addUsCgoRlsLogSceRslt(focVO,this.account);
		   		log.debug("------------------------SCE 비교 IF " + focVO.getSceMsgId()+" End -----------------------");
			   	log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		   	}
		   	if(sceVO.getScePq() != null
		   			&& sceVO.getScePq().equals("Y") && Integer.parseInt(sceVO.getScePqCnt()) == 0){	   		
		   		focVO.setSceMsgId("PQ");
		   		log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		   		log.debug("------------------------SCE 비교 IF " + focVO.getSceMsgId()+" Start -----------------------");
		   		this.printValue("sceVO.getScePq()",sceVO.getScePq());
		   		this.printValue("sceVO.getScePqCnt()",sceVO.getScePqCnt());
		   		this.printValue("focVO.getSceMsgId()",focVO.getSceMsgId());
		   		//focVO.setSceScsCd(bc.edi315AMSSend( focVO.getBlNo(), focVO.getSceMsgId()));	
		   		//SCE 호출
		   		//2010.02.04 SCE 모듈의 Method 변경건으로 인한 처리 Start
		   		
		   		Edi315AmsDataVO amsDataVO = new Edi315AmsDataVO();

		   		//amsDataVO.setBlNo(usCgoRlseBkbc.getBlNo());
		   		//amsDataVO.setEdiSts("PQ");
		   		
		   		amsDataVO.setBlNo(focVO.getBlNo());
		   		amsDataVO.setEdiSts(focVO.getSceMsgId());
		   		amsDataVO.setEventDt(sceVO.getEventDt());
		   		amsDataVO.setEventYd(sceVO.getEventYd());
		   		focVO.setSceScsCd(bc.addSceEdiAmsIf( amsDataVO));
		   		
		   		//2010.02.04 SCE 모듈의 Method 변경건으로 인한 처리 End
		   		//focVO.setBlNo(usCgoRlseBkbc.getBlNo());
		   		//focVO.setHisSeq(usCgoRlseBkbc.getHisSeq());
		   		dbDao.addUsCgoRlsLogSceRslt(focVO,this.account);
		   		log.debug("------------------------SCE 비교 IF " + focVO.getSceMsgId()+" End -----------------------");
			   	log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		   	}
		   	long endTime = System.currentTimeMillis();
		   	log.debug("---------------- SCE 실행시간은 "+ ((endTime - startTime2)/ 1000));
		   	}catch(Exception e){
		   	//Business Logic 상 Exception 처리불가.
	            //곽영범수석 문의
		   		long endTime = System.currentTimeMillis();
		   		log.error(e.getMessage()); // 2011.07.15
			   	log.debug("---------------- SCE 실행시간은 "+ ((endTime - startTime2)/ 1000));
		   	}
		   	
		    //Model No. 30
		   	this.priLog("model No. 30", focVO);
		   	dbDao.modifyUsCgoRlsHisSceRslt(focVO,this.account);
		   	
	   		
   			
	   		log.debug("--------------------- SCE End -----------");
   			log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	   		
	   	//}	   	
	   	
	   	
   	    		
	   	if (newCstmsFlg.equals("X")){
	   	    //AMS DOWNLOAD대상만  가능.
	   		if ( !"".equals(eventId)) dbDao.receiveOtsLog("BKG_US_CGO_POD", "X==>"+ eventId + ":" + blNo, "CR2/blNo:"+blNo+"/oldPod="+oldPodCd+"/newPod:"+newPodCd );
	   		throw new EventException(new ErrorHandler("BKG40085").getMessage());
	   	}
	   	
	   	//2014.12.19 CHM-201432690 [SR 관련 문의] CR (Carrrier Release) event 전송 관련
	   	//신규 터미널에 CR 전송, 기존 터미널에 Cancellation 전송인 CA 전송 진행

	   	//[0156] COD Application POD 변경시 CgoRlse
	   	//if( newPodCd != null && oldPodCd != null){
	   	if( !"".equals(newPodCd) && !"".equals(oldPodCd)){

        	BkgCgoRlseVO bkgCgoRlseVo = new BkgCgoRlseVO();
            UsCgoRlseBkbcBlVO tmpVO = null;
            String eventNm = "COD_APP";
            if ( "K".equals(eventId)) eventNm = "BOOKING"; 
            
	   		//기존 터미널에 CA 전송            
        	bkgCgoRlseVo.setBlNo(blNo);
            dbDao.addUsCgoRlseHisEdi(bkgCgoRlseVo, account, eventId , eventNm );

   	   	    tmpVO = dbDao.searchCrEdiResult(usCgoRlseBkbc);
	   	   	usCgoRlseBkbc.setHisSeq(tmpVO.getHisSeq());
	   	    usCgoRlseBkbc.setPodCd(oldPodCd); //기존포트 CA
	   	    usCgoRlseBkbc.setBkgPodYdCd(oldPodYdCd);
	   	    dbDao.receiveOtsLog("BKG_US_CGO_POD", eventId + ":" + blNo, "CA1/blNo:"+blNo+"/oldPod="+oldPodCd+"/newPod:"+newPodCd+"/oldPodYdCd:"+oldPodYdCd+"/newPodYdCd:"+newPodYdCd );
	   		focVO = this.sendEventCA(usCgoRlseBkbc,"CA1");
	   		
	   		//신규 터미널에 CR 전송
            dbDao.addUsCgoRlseHisEdi(bkgCgoRlseVo, account , eventId , eventNm );
   	   	    tmpVO = dbDao.searchCrEdiResult(usCgoRlseBkbc);
	   	   	usCgoRlseBkbc.setHisSeq(tmpVO.getHisSeq());
	   	   	usCgoRlseBkbc.setPodCd(newPodCd); //신규포트 CR
	   	   	usCgoRlseBkbc.setBkgPodYdCd(newPodYdCd);
	   	   	dbDao.receiveOtsLog("BKG_US_CGO_POD", eventId + ":" + blNo, "CR2/blNo:"+blNo+"/oldPod="+oldPodCd+"/newPod:"+newPodCd+"/oldPodYdCd:"+oldPodYdCd+"/newPodYdCd:"+newPodYdCd );
	   	   	focVO = this.sendEventCR(usCgoRlseBkbc,"CR2");
	   	}	   	 
	   	
	   	else {
	   		dbDao.receiveOtsLog("BKG_US_CGO_SWB", blNo, "31.DATA newCstmsFlg:"+newCstmsFlg+"/ipiLclCd:"+ipiLclCd+"/crEdiCd:"+crEdiCd+"/cstmsFlg:"+cstmsFlg+"/focYdCd:"+focYdCd+"/oldFrtFlg:"+oldFrtFlg+"/newFrtFlg:"+newFrtFlg+"/oldOblFlg:"+oldOblFlg+"/newOblFlg:"+newOblFlg+"/pltlCnt:"+pltlCnt+"/cstmsDpFlg:"+cstmsDpFlg+"/oldCstmsFlg:"+oldCstmsFlg);
	  //ipiLclCd='I' and «» crEdiCd={'A',Null} and cstmsFlg='J' and focYdCd={'1','2'}
	   		//@ I-보세운송/"",A - CR을 보낸적이 없거나 Cancel한 상태/J-세관에서 1J(보세운송허가를 받음)/FO 또는 FOC 조건:focYdCd == 1,2   
		   	if(        (ipiLclCd.equals("I"))
		   			 && (crEdiCd.equals("")     || crEdiCd.equals("A"))
		   			 && (cstmsFlg.equals("J"))
		   			 && (focYdCd.equals("1") || focYdCd.equals("2"))         
		   			 ){
		   		dbDao.receiveOtsLog("BKG_US_CGO_SWB", blNo, "32.CR1");
		   		log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		   		log.debug("--------------------- CR Case 1 Start -----------");
		   		this.printValue("ipiLclCd",ipiLclCd);
		   		this.printValue("crEdiCd",crEdiCd);
		   		this.printValue("cstmsFlg",cstmsFlg);
		   		this.printValue("focYdCd",focYdCd);
		   		focVO = this.sendEventCR(usCgoRlseBkbc,"CR1");
		   		log.debug("--------------------- CR Case 1 End -----------");
		   		log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		   		 
		   		 
		   	 }	 
		   	 //[] ipiLclCd='L' and crEdiCd={'A','J',Null} and focYdCd={'1','2'} and {newFrtFlg='Y' and newOblFlg='Y'}
			 //CR Case 2
             //@ L-로컬화물/"",A - CR을 보낸적이 없거나 Cancel한 상태,J-세관에서 1J(보세운송허가를 받음)/FO 또는 FOC 조건:focYdCd == 1,2
		   	//   운임 및 OBL 이 회수가 'Y'/ Partial 개수가 0
		   	 else if(   (ipiLclCd.equals("L"))
			   			 && (crEdiCd.equals("")       || crEdiCd.equals("A")	|| crEdiCd.equals("J"))	   			 
			   			 && (focYdCd.equals("1")   || focYdCd.equals("2"))
			   			 && (newFrtFlg.equals("Y") && newOblFlg.equals("Y"))
			   			 && (pltlCnt.equals("0"))
		   			 ){
		   		
			   		dbDao.receiveOtsLog("BKG_US_CGO_SWB", blNo, "32.CR2-1");
			   		log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			   		log.debug("--------------------- CR Case 2 Start (pltlCnt == 0) -----------");
			   		this.printValue("ipiLclCd",ipiLclCd);
			   		this.printValue("crEdiCd",crEdiCd);
			   		this.printValue("focYdCd",focYdCd);
			   		this.printValue("newFrtFlg",newFrtFlg);
			   		this.printValue("pltlCnt",pltlCnt);
		   			focVO = this.sendEventCR(usCgoRlseBkbc,"CR2");
		   			log.debug("--------------------- CR Case 2 End (pltlCnt == 0)-----------");
		   			log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		   	 }	
		   	 else if(   (ipiLclCd.equals("L"))
		   			 && (crEdiCd.equals("")       || crEdiCd.equals("A")	|| crEdiCd.equals("J"))	   			 
		   			 && (focYdCd.equals("1")   || focYdCd.equals("2"))
		   			 && (newFrtFlg.equals("Y") && newOblFlg.equals("Y"))
		   			 && (Integer.parseInt(pltlCnt) > 0 )
		   			){
			   		dbDao.receiveOtsLog("BKG_US_CGO_SWB", blNo, "32.CR2-2");		   		 
		   		 	log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			   		log.debug("--------------------- CR Case 3 Start (Integer.parseInt(pltlCnt) > 0 and pltlClrCnt == 0)-----------");
			   		this.printValue("ipiLclCd",ipiLclCd);
			   		this.printValue("crEdiCd",crEdiCd);
			   		this.printValue("focYdCd",focYdCd);
			   		this.printValue("newFrtFlg",newFrtFlg);
			   		this.printValue("pltlCnt",pltlCnt);
			   		this.printValue("pltlClrCnt",pltlClrCnt);
			   		
			   		//2010.04.19. 기존 Partial B/L인 경우 다른 B/L의 C값의 Clearance여부를 따졌으나, 로직 해제한다. CR2로 한다.
		   			focVO = this.sendEventCR(usCgoRlseBkbc,"CR2");
		   			log.debug("--------------------- CR Case 3 End (Integer.parseInt(pltlCnt) > 0 and pltlClrCnt == 0)-----------");
		   			log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		   	 
		   		 
		   	}	 
		   	//[] newFrtFlg='Y' and newOblFlg='Y' and focYdCd='1'
		   	//CR Case 3
		   	//Model No.13
		   	//2010.04.22 CR 전송 Case중, F/O가 모두 'Y'이고, 과거CR전송기록이 없으면 CR나가도록 추가.
		   	else if( 
		   			  (
		   			   (newFrtFlg.equals("Y")) && (newOblFlg.equals("Y"))   && 
		   			   ((oldFrtFlg.equals("N")) || (oldOblFlg.equals("N"))) && 
		   			   (focYdCd.equals("1"))
		   			  ) ||
		   			  (
		  	   		    newFrtFlg.equals("Y") && newOblFlg.equals("Y") && newCstmsFlg.equals("Y") && 
		  	   		    !crEdiCd.equals("R")  && focYdCd.equals("1")
		   			  ) ||
		   			  (
		   				//2015.04.02 New F='Y', O ='Y' 일 경우 , old F,O 값이 모두 Y 더라도 CR 기록이 없으면 CR 을 전송하도록 		   					  
		  	   		    newFrtFlg.equals("Y") && newOblFlg.equals("Y") && 
		  	   		    !crEdiCd.equals("R")  && focYdCd.equals("1")
		  	   		  )
		   	       )
		   	{
		   		dbDao.receiveOtsLog("BKG_US_CGO_SWB", blNo, "32.CR4");		   		
		   		log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		   		log.debug("--------------------- CR Case 4 Start -----------");
		   		this.log.debug("----------- usCgoRlseBkbc "+usCgoRlseBkbc.getColumnValues());
		   		this.printValue("newFrtFlg",newFrtFlg);
		   		this.printValue("newOblFlg",newOblFlg);	   		
		   		focVO = this.sendEventCR(usCgoRlseBkbc,"CR4");
	   			log.debug("--------------------- CR Case 4 End -----------");
	   			log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		   		 
			
		   	} 
		   	//[] crEdiCd ={'R','J'} 
	   		//	and {{oldFrtFlg='Y' and newFrtFlg='N'} or {oldOblFlg='Y' and newOblFlg='N'}} 
	   		//	and {ipiLclCd<>'I' or newCsmtsFlg<>'J'}
		   	//CA Case 1
	   		//Model No.14
		   	else if(     (crEdiCd.equals("R") || crEdiCd.equals("J"))
		   			&&    ( (oldFrtFlg.equals("Y") && newFrtFlg.equals("N")) 
		   					|| (oldOblFlg.equals("Y") && newOblFlg.equals("N")))
		   			&&    (!ipiLclCd.equals("I") || !newCstmsFlg.equals("J"))      
		   		){
		   		log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		   		log.debug("--------------------- CA Case 1 Start -----------");
		   		this.printValue("crEdiCd",crEdiCd);
		   		this.printValue("oldFrtFlg",oldFrtFlg);	   		
		   		this.printValue("oldOblFlg",oldOblFlg);
		   		this.printValue("newOblFlg",newOblFlg);
		   		this.printValue("ipiLclCd",ipiLclCd);
		   		this.printValue("newCstmsFlg",newCstmsFlg);
		   		focVO = this.sendEventCA(usCgoRlseBkbc,"CA1");
	   			log.debug("--------------------- CA Case 1 End -----------");
	   			log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		   		
		   		
		   		
		   	}	
		   	//[] crEdiCd={'R','J'} and focYdCd = '2' and newCstmsFlg = {'H','N'}
		   	//CA Case 2
		   	//Model No. 15
		   	else if(   (crEdiCd.equals("R") || crEdiCd.equals("J"))
		   			&& focYdCd.equals("2")
		   			&&  (newCstmsFlg.equals("H") || newCstmsFlg.equals("J"))
		   			
		   		){
		   		log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		   		this.printValue("crEdiCd",crEdiCd);
		   		this.printValue("focYdCd",focYdCd);	   		
		   		this.printValue("newCstmsFlg",newCstmsFlg);	   	
		   		log.debug("--------------------- CA Case 2 Start -----------");
		   		focVO = this.sendEventCA(usCgoRlseBkbc,"CA2");
	   			log.debug("--------------------- CA Case 2 End -----------");
	   			log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		   	}
		   	 
		   	 
		   	//[] cstmsDpCd=6H
		   	//PA
		   	//Model No. 16
		   	else if( cstmsDpFlg.equals("6H")){
		   		log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		   		log.debug("--------------------- PA Start -----------");
		   		this.printValue("cstmsDpFlg",cstmsDpFlg);
		   		focVO = this.sendEventPA(usCgoRlseBkbc,"PA1");
	   			log.debug("--------------------- PA End -----------");
	   			log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		   	}
		   	 
		   	//[] cstmsDpCd={1H,2H,3H,4H,5H,1A,4A,1X,71,72,73}
		   	//PQ
			//Model No. 17
		   	else if(	cstmsDpFlg.equals("1H")
		   			||  cstmsDpFlg.equals("2H")
		   			||  cstmsDpFlg.equals("3H")
		   			||  cstmsDpFlg.equals("4H")
		   			||  cstmsDpFlg.equals("5H")
		   			||  cstmsDpFlg.equals("1A")
		   			||  cstmsDpFlg.equals("4A")
		   			||  cstmsDpFlg.equals("1X")
		   			||  cstmsDpFlg.equals("71")
		   			||  cstmsDpFlg.equals("72")
		   			||  cstmsDpFlg.equals("73")
		   			
		   		){
		   		log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		   		log.debug("--------------------- PQ Start -----------");
		   		this.printValue("cstmsDpFlg",cstmsDpFlg);
		   		focVO = this.sendEventPQ(usCgoRlseBkbc,"PQ1");
	   			log.debug("--------------------- PQ End -----------");
	   			log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		   	}
		   	
		   	else if(
		   			(cstmsFlg.equals("J") && oldCstmsFlg.equals(newCstmsFlg) == false) ||
			   		 (newCstmsFlg.equals("Y") && oldCstmsFlg.equals(newCstmsFlg) == false) ) { //CT 일경우의 조건 
		   			dbDao.receiveOtsLog("BKG_US_CGO_SWB", blNo, "32.CT1-1");		   		
			   		log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			   		log.debug("--------------------- CT Case 1 Start -----------");
			   		this.printValue("oldCstmsFlg",oldCstmsFlg);
			   		this.printValue("newCstmsFlg",newCstmsFlg);
			   		focVO = this.sendEventCT(usCgoRlseBkbc,"CT1");
			   		sendCtFlag = true;
			   		log.debug("--------------------- CT Case 1 End -----------");
			   		log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
			   		 }
		   	 
		   	else{
		   		dbDao.receiveOtsLog("BKG_US_CGO_SWB", blNo, "32.ERROR");		   		
		   		log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		   		log.debug("전송 대상이 아닐 경우 THROW: The B/L you selected for Carriers' Release is not applicable to transmit.");
		   		log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		   		
		   		//모두 해당 사항이 없을경우
		   		//전송 대상이 아닐 경우 : The B/L you selected for Carriers' Release is not applicable to transmit.
		   		if ( !"".equals(eventId)) dbDao.receiveOtsLog("BKG_US_CGO_POD", "else==>"+ eventId + ":" + blNo, "CR2/blNo:"+blNo+"/oldPod="+oldPodCd+"/newPod:"+newPodCd );
		   		throw new EventException(new ErrorHandler("BKG40085").getMessage());
		   	}
		   		
		   	 //-----------------------------------------------------------------
		   	 //2010.04.19 ; 추가 EDI 전송요건 시작
		   	 if( !sendCtFlag && ( (cstmsFlg.equals("J") && oldCstmsFlg.equals(newCstmsFlg) == false) ||
		   		 (newCstmsFlg.equals("Y") && oldCstmsFlg.equals(newCstmsFlg) == false) ) ) { //CT 일경우의 조건
			   	dbDao.receiveOtsLog("BKG_US_CGO_SWB", blNo, "32.CT-2");		   		 
		   		log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		   		log.debug("--------------------- CT Case 1 Start -----------");
		   		this.printValue("oldCstmsFlg",oldCstmsFlg);
		   		this.printValue("newCstmsFlg",newCstmsFlg);
		   		focVO = this.sendEventCT(usCgoRlseBkbc,"CT1");
		   		log.debug("--------------------- CT Case 1 End -----------");
		   		log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		   	 }	
			 //2010.04.19 ; 추가 EDI 전송요건 끝	   	 
		   	 //-----------------------------------------------------------------
		   	 
	   	} //End podChange !='Y'
	   	 
	}
	/**
	 * Check를 위한 값 설정
	 * @param usCgoRlseBkbc
	 * @return UsCgoRlseBkbcFocVO
	 * @exception Exception
	 */
	private UsCgoRlseBkbcBlVO getCheckData(UsCgoRlseBkbcBlVO usCgoRlseBkbc) throws Exception {
		//model No. 1
	   	 UsCgoRlseBkbcBlVO tmpVO = dbDao.searchBLInfo(usCgoRlseBkbc);
	   	 usCgoRlseBkbc.setVvd(tmpVO.getVvd());
	   	 usCgoRlseBkbc.setPodCd(tmpVO.getPodCd());
	   	 usCgoRlseBkbc.setDelCd(tmpVO.getDelCd());
	   	 usCgoRlseBkbc.setFincCtrlOfcCd(tmpVO.getFincCtrlOfcCd());
	   	 this.priLog("model No. 1", usCgoRlseBkbc);
	   	 
	   	 //model No. 2
	   	 tmpVO = dbDao.searchLocalIpiStatus(usCgoRlseBkbc);
	   	 usCgoRlseBkbc.setIpiStatus(tmpVO.getIpiStatus());
	   	this.priLog("model No. 2", usCgoRlseBkbc);
	   	 
	   	
	   	 //model No. 4
	     tmpVO = dbDao.searchYdTmlnfo(usCgoRlseBkbc);
	   	 usCgoRlseBkbc.setFullRlseEdiCd(tmpVO.getFullRlseEdiCd());
	   	 usCgoRlseBkbc.setTermId(tmpVO.getTermId());
	   	this.priLog("model No. 4", usCgoRlseBkbc);
	   	
	   	 
	   	 //model No. 5
	   	 tmpVO = dbDao.searchCstmsDpCd(usCgoRlseBkbc);
	   	 usCgoRlseBkbc.setCValue(tmpVO.getCValue());
	   	 usCgoRlseBkbc.setCstmsDspoCd(tmpVO.getCstmsDspoCd());
	   	this.priLog("model No. 5", usCgoRlseBkbc);
	   	 
	   	//model No. 6
	   	 tmpVO = dbDao.searchCrEdiResult(usCgoRlseBkbc);
	   	 usCgoRlseBkbc.setCgorEdiSndCd(tmpVO.getCgorEdiSndCd());
	   	 usCgoRlseBkbc.setHisSeq(tmpVO.getHisSeq());
	   	this.priLog("model No. 6", usCgoRlseBkbc);
	   	 
	   	//model No. 7
	   	 tmpVO = dbDao.searchPrtlBl(usCgoRlseBkbc);
	   	 usCgoRlseBkbc.setPartialCnt(tmpVO.getPartialCnt());
	   	 usCgoRlseBkbc.setAllCInd(tmpVO.getAllCInd());
	   	 usCgoRlseBkbc.setPartialClear(tmpVO.getPartialClear());
	   	this.priLog("model No. 7", usCgoRlseBkbc);
	   	 
	   	//model No. 8
	   	 tmpVO = dbDao.searchOldNewFocFlg(usCgoRlseBkbc);
	        usCgoRlseBkbc.setOldFrtCltFlg(tmpVO.getOldFrtCltFlg());
	   	 usCgoRlseBkbc.setOldOblRdemFlg(tmpVO.getOldOblRdemFlg());
	   	 usCgoRlseBkbc.setOldCstmsClrCd(tmpVO.getOldCstmsClrCd());
	   	 usCgoRlseBkbc.setNewFrtCltFlg(tmpVO.getNewFrtCltFlg());
	   	 usCgoRlseBkbc.setNewOblRdemFlg(tmpVO.getNewOblRdemFlg());
	   	 usCgoRlseBkbc.setNewCstmsClrCd(tmpVO.getNewCstmsClrCd());
	   	this.priLog("model No. 8", usCgoRlseBkbc);
	   	
	   	return usCgoRlseBkbc;
	}

	/** Event1 CR_CASE 으로 분기
	 * @param usCgoRlseBkbc
	 * @return UsCgoRlseBkbcFocVO
	 * @exception DAOException
	 * @exception EventException 
	 */
	private UsCgoRlseBkbcFocVO sendEventCR(UsCgoRlseBkbcBlVO usCgoRlseBkbc,String ediKnd) throws DAOException, EventException {
		UsCgoRlseBkbcFocVO focVO = new UsCgoRlseBkbcFocVO();
		//UsCgoRlseBkbcFocVO tmpFocVO = new UsCgoRlseBkbcFocVO();
		focVO.setBlNo(usCgoRlseBkbc.getBlNo());		
		focVO.setEdiKnd(ediKnd);
		focVO.setHisSeq(usCgoRlseBkbc.getHisSeq());
		focVO.setCstmsDspoCd(usCgoRlseBkbc.getCstmsDspoCd());
		focVO.setPodCd(usCgoRlseBkbc.getPodCd());
		focVO.setNewPodCd(newPodCd); //신규 터미널
		focVO.setBkgPodYdCd(newPodYdCd);
		
		
		//Event_1 model No. 2
		focVO = this.searchEdiRcvSndIdCr(focVO);
		this.priLog("Event_1 model No. 2", focVO);
		
		//Event_1 model No. 5
		focVO = this.searchCustCode(focVO);
		log.debug("----------------- focVO.getBkgNo()   "+focVO.getBkgNo());
		this.priLog("Event_1 model No. 5", focVO);
		
		//Event_1 model No. 6
		//ibd_bkg_ind,bkg_no,vsk_vvd_cd,VSL_CD,SKD_VOY_NO,SKD_DIR_CD
		//,pol_cd,pod_Cd,del_cd,edi_snp_snd_id,edi_snp_rcv_id,edi_add_ind
		focVO = this.searchIbdBkgInfo(focVO);
		 //신규 터미널에 CR 전송에 따른 POD 변경
		this.priLog("Event_1 model No. 6", focVO);
		
		//Event_1 model No. 7
		//VPS_ETD_DT,VPS_ETD_DT_GMT....
		focVO.setPodCd(getChangePod(focVO.getPodCd())); //신규 터미널 정보가 있을 경우		
		focVO = this.searchVskInfo(focVO);
		this.priLog("Event_1 model No. 7", focVO);
		
		//Event_1 model No. 9
		//OLD_FRT_CLT_FLG,OLD_OBL_RDEM_FLG,OLD_CSTMS_CLR_CD
		//,NEW_FRT_CLT_FLG,NEW_OBL_RDEM_FLG,NEW_CSTMS_CLR_CD
		focVO = this.searchOldNewFocFlg(focVO);
		this.priLog("Event_1 model No. 9", focVO);
		
		//Event_1 model No. 12
		//po_no,LOC_CD,VSL_SLAN_NM
		focVO = this.searchPoLocSlan(focVO);
		this.priLog("Event_1 model No. 12", focVO);
		
		//세관데이터가 있는 경우 { ibdBkgInd = 'I' }
		String ibdBkgInd = focVO.getIbdBkgInd();
		//String ediBlCntrInd = focVO.getEdiBlCntrInd();
		//Event_1 model No. 17 ; model No. 14 ~ 15
		this.sendFlatFile(focVO,ibdBkgInd);
		this.priLog("Event_1 model No. 17, 세관데이터가 있는경우", focVO);
		
		
		
		
		return focVO;
	}

	
	/** Event1 CA_CASE 으로 분기
	 * @param usCgoRlseBkbc
	 * @param String ediKnd
	 * @return UsCgoRlseBkbcFocVO
	 * @exception DAOException
	 * @exception EventException 
	 */
	private UsCgoRlseBkbcFocVO sendEventCA(UsCgoRlseBkbcBlVO usCgoRlseBkbc,String ediKnd)
			throws DAOException, EventException {
		UsCgoRlseBkbcFocVO focVO = new UsCgoRlseBkbcFocVO();
		//UsCgoRlseBkbcFocVO tmpFocVO = new UsCgoRlseBkbcFocVO();
		focVO.setBlNo(usCgoRlseBkbc.getBlNo());		
		focVO.setEdiKnd(ediKnd);
		focVO.setHisSeq(usCgoRlseBkbc.getHisSeq());
		focVO.setPodCd(usCgoRlseBkbc.getPodCd());
		focVO.setNewPodCd("");		
		focVO.setBkgPodYdCd(oldPodYdCd);
		
		log.debug("~~~~~~~~~~~~~~ focVO.getHisSeq()   "+focVO.getHisSeq());
		
		//Event_1 model No. 3
		//VSK_VSL_PORT_SKD 
		focVO = this.searchEdiRcvSndIdCa(focVO);
		this.priLog("Event_1 model No. 3", focVO);
		
		//Event_1 model No. 5
		focVO = this.searchCustCode(focVO);
		//log.debug("----------------- focVO.getBkgNo()   "+focVO.getBkgNo());
		if(focVO.getBkgNo() == null){
			throw new EventException(new ErrorHandler("BKG40086").getMessage());
		}
		this.priLog("Event_1 model No. 5", focVO);
		
		//Event_1 model No. 6
		focVO = this.searchIbdBkgInfo(focVO);
		this.priLog("Event_1 model No. 6", focVO);
		
		//Event_1 model No. 7
		focVO = this.searchVskInfo(focVO);
		this.priLog("Event_1 model No. 7", focVO);
		
		//Event_1 model No. 9
		focVO = this.searchOldNewFocFlg(focVO);
		this.priLog("Event_1 model No. 9", focVO);
		
		//Event_1 model No. 12
		focVO = this.searchPoLocSlan(focVO);
		this.priLog("Event_1 model No. 12", focVO);
		
		//세관데이터가 있는 경우 { ibdBkgInd = 'I' }
		String ibdBkgInd = focVO.getIbdBkgInd();
		//String ediBlCntrInd = focVO.getEdiBlCntrInd();
			
		//Event_1 model No. 17
		this.sendFlatFile(focVO,ibdBkgInd);
		this.priLog("Event_1 model No. 17", focVO);
		
		
		return focVO;
	}	
	/** Event1 PA_CASE 으로 분기
	 * @param usCgoRlseBkbc
	 * @param String ediKnd
	 * @return UsCgoRlseBkbcFocVO
	 * @exception DAOException
	 * @exception EventException 
	 */
	private UsCgoRlseBkbcFocVO sendEventPA(UsCgoRlseBkbcBlVO usCgoRlseBkbc,String ediKnd)
			throws DAOException, EventException {
		UsCgoRlseBkbcFocVO focVO = new UsCgoRlseBkbcFocVO();
		//UsCgoRlseBkbcFocVO tmpFocVO = new UsCgoRlseBkbcFocVO();
		focVO.setBlNo(usCgoRlseBkbc.getBlNo());		
		focVO.setEdiKnd(ediKnd);
		focVO.setHisSeq(usCgoRlseBkbc.getHisSeq());
		
		//Event_1 model No. 4
		focVO = this.searchEdiRcvSndIdHld(focVO);
		this.priLog("Event_1 model No. 4", focVO);
		
		//Event_1 model No. 5
		focVO = this.searchCustCode(focVO);
		log.debug("----------------- focVO.getBkgNo()   "+focVO.getBkgNo());
		if(focVO.getBkgNo() == null){
			throw new EventException(new ErrorHandler("BKG40086").getMessage());
		}
		this.priLog("Event_1 model No. 5", focVO);
		
		
		//Event_1 model No. 6
		focVO = this.searchIbdBkgInfo(focVO);
		this.priLog("Event_1 model No. 6", focVO);
		
		//Event_1 model No. 7
		focVO = this.searchVskInfo(focVO);
		this.priLog("Event_1 model No. 7", focVO);
		
		//Event_1 model No. 9
		focVO = this.searchOldNewFocFlg(focVO);
		this.priLog("Event_1 model No. 9", focVO);
		
		//Event_1 model No. 12
		focVO = this.searchPoLocSlan(focVO);
		this.priLog("Event_1 model No. 12", focVO);
		
		//세관데이터가 있는 경우 { ibdBkgInd = 'I' }
		String ibdBkgInd = focVO.getIbdBkgInd();
		//String ediBlCntrInd = focVO.getEdiBlCntrInd();
		
		//Event_1 model No. 17
		this.sendFlatFile(focVO,ibdBkgInd);
		this.priLog("Event_1 model No. 17", focVO);
		
		
		
		return focVO;
	}
	/** Event1 PQ_CASE 으로 분기
	 * @param usCgoRlseBkbc
	 * @param String ediKnd
	 * @return UsCgoRlseBkbcFocVO
	 * @exception DAOException
	 * @exception EventException 
	 */
	private UsCgoRlseBkbcFocVO sendEventPQ(UsCgoRlseBkbcBlVO usCgoRlseBkbc,String ediKnd)
			throws DAOException, EventException {
		UsCgoRlseBkbcFocVO focVO = new UsCgoRlseBkbcFocVO();
		//UsCgoRlseBkbcFocVO tmpFocVO = new UsCgoRlseBkbcFocVO();
		focVO.setBlNo(usCgoRlseBkbc.getBlNo());
		focVO.setHisSeq(usCgoRlseBkbc.getHisSeq());
		focVO.setEdiKnd(ediKnd);
		
		//Event_1 model No. 3
		focVO = this.searchEdiRcvSndIdCa(focVO);
		this.priLog("Event_1 model No. 3", focVO);
		
		//Event_1 model No. 5
		focVO = this.searchCustCode(focVO);
		//log.debug("----------------- focVO.getBkgNo()   "+focVO.getBkgNo());
		if(focVO.getBkgNo() == null){
			throw new EventException(new ErrorHandler("BKG40086").getMessage());
		}
		this.priLog("Event_1 model No. 5", focVO);
		
		//Event_1 model No. 6
		focVO = this.searchIbdBkgInfo(focVO);
		this.priLog("Event_1 model No. 6", focVO);
		
		//Event_1 model No. 7
		focVO = this.searchVskInfo(focVO);
		this.priLog("Event_1 model No. 7", focVO);
		
		//Event_1 model No. 9
		focVO = this.searchOldNewFocFlg(focVO);
		this.priLog("Event_1 model No. 9", focVO);
		
		//Event_1 model No. 12
		focVO = this.searchPoLocSlan(focVO);
		this.priLog("Event_1 model No. 12", focVO);
		
		//세관데이터가 있는 경우 { ibdBkgInd = 'I' }
		String ibdBkgInd = focVO.getIbdBkgInd();
		//String ediBlCntrInd = focVO.getEdiBlCntrInd();
		
		//Event_1 model No. 17
		this.sendFlatFile(focVO,ibdBkgInd);
		this.priLog("Event_1 model No. 17", focVO);
		
		return focVO;
	}	
	
	/** Event1 CT_CASE 으로 분기
	 * @param usCgoRlseBkbc
	 * @return UsCgoRlseBkbcFocVO
	 * @exception DAOException
	 * @exception EventException 
	 */
	private UsCgoRlseBkbcFocVO sendEventCT(UsCgoRlseBkbcBlVO usCgoRlseBkbc,String ediKnd)
			throws DAOException, EventException {
		UsCgoRlseBkbcFocVO focVO = new UsCgoRlseBkbcFocVO();
		//UsCgoRlseBkbcFocVO tmpFocVO = new UsCgoRlseBkbcFocVO();
		focVO.setBlNo(usCgoRlseBkbc.getBlNo());		
		focVO.setEdiKnd(ediKnd);
		focVO.setHisSeq(usCgoRlseBkbc.getHisSeq());
		focVO.setCstmsDspoCd(usCgoRlseBkbc.getCstmsDspoCd());
		focVO.setPodCd(usCgoRlseBkbc.getPodCd());
		
		
		//Event_1 model No. 2
		focVO = this.searchEdiRcvSndIdCt(focVO);
		this.priLog("Add CT Event_1 model No. 2", focVO);
		
		//Event_1 model No. 5
		focVO = this.searchCustCode(focVO);
		log.debug("----------------- focVO.getBkgNo()   "+focVO.getBkgNo());
		if(focVO.getBkgNo() == null){
			throw new EventException(new ErrorHandler("BKG40086").getMessage());
		}
		this.priLog("Add CT Event_1 model No. 5", focVO);
		
		//Event_1 model No. 6
		//ibd_bkg_ind,bkg_no,vsk_vvd_cd,VSL_CD,SKD_VOY_NO,SKD_DIR_CD
		//,pol_cd,pod_Cd,del_cd,edi_snp_snd_id,edi_snp_rcv_id,edi_add_ind
		focVO = this.searchIbdBkgInfo(focVO);
		this.priLog("Add CT Event_1 model No. 6", focVO);
		
		//Event_1 model No. 7
		//VPS_ETD_DT,VPS_ETD_DT_GMT....
		focVO = this.searchVskInfo(focVO);
		this.priLog("Add CT Event_1 model No. 7", focVO);
		
		//Event_1 model No. 9
		//OLD_FRT_CLT_FLG,OLD_OBL_RDEM_FLG,OLD_CSTMS_CLR_CD
		//,NEW_FRT_CLT_FLG,NEW_OBL_RDEM_FLG,NEW_CSTMS_CLR_CD
		focVO = this.searchOldNewFocFlg(focVO);
		this.priLog("Add CT Event_1 model No. 9", focVO);
		
		//Event_1 model No. 12
		//po_no,LOC_CD,VSL_SLAN_NM
		focVO = this.searchPoLocSlan(focVO);
		this.priLog("Add CT Event_1 model No. 12", focVO);
		
		//세관데이터가 있는 경우 { ibdBkgInd = 'I' }
		String ibdBkgInd = focVO.getIbdBkgInd();
		//String ediBlCntrInd = focVO.getEdiBlCntrInd();
		//Event_1 model No. 17 ; model No. 14 ~ 15
		this.sendFlatFile(focVO,ibdBkgInd);
		this.priLog("Add CT Event_1 model No. 17, 세관데이터가 있는경우", focVO);
		
		
		
		
		return focVO;
	}
	
	
	/**
	 * Event_1 model No. 14 ~ 17
	 * @param focVO
	 * @param String flg
	 * @return UsCgoRlseBkbcFocVO
	 * @exception EventException 
	 * @exception DAOException 
	 */
	private UsCgoRlseBkbcFocVO sendFlatFile(UsCgoRlseBkbcFocVO focVO,String flg) throws EventException, DAOException {
		//Event_1 model No. 14
		List<UsCgoRlseBkbcFlatFileVO> flatFileVOs = new ArrayList<UsCgoRlseBkbcFlatFileVO>();
		
		//세관데이터 유무에 따라 내부에서 분기
		flatFileVOs = this.searchMkFile(focVO,flg);
		this.priLog("Event_1 model No. 14", focVO);
		
		//Event_1 model No. 15
		String flatFileVvd = this.searchMkVvdFile(focVO);
		this.priLog("Event_1 model No. 15", focVO);
		
		StringBuffer flatFile = new StringBuffer();
		String ediSnpRtnVal = "";
		
		/**
		 * Flat File 의 종류
		 * 1. Flat File ;
		 * 2. Snp File  ; 
		 */
		//log.debug("~~~~~~~~~~~~~~ flatFileVOs.size()   "+flatFileVOs.size());
		//log.debug("~~~~~~~~~~~~~~ focVO.getEdiBlCntrInd() " + focVO.getEdiBlCntrInd());
	
		for(int i=0;i<flatFileVOs.size();i++){
			UsCgoRlseBkbcFlatFileVO flatFileVO = flatFileVOs.get(i);
			//log.debug("----------------------------------------------");
			//log.debug(flatFileVO.getFlatFileHeader());
			flatFileVO.getSnpFileHeader();
			//log.debug("----------------------------------------------");
			
			flatFile.append(flatFileVO.getFlatFileHeader());
			flatFile.append(flatFileVO.getFlatFileBody());
			flatFile.append(flatFileVvd);
			
			ediSnpRtnVal = this.comSendFlatFile(focVO, flatFile);//Flat File 전송후 리턴되는 결과값
			
			if(!"".equalsIgnoreCase(flatFileVO.getDupFlatFileHeader())){
				flatFile = new StringBuffer();
				
				flatFile.append(flatFileVO.getDupFlatFileHeader());
				flatFile.append(flatFileVO.getFlatFileBody());
				flatFile.append(flatFileVvd);
				
				this.comSendFlatFile(focVO, flatFile);//Duplicate Flat File 전송후 리턴되는 결과값
			}
			
			focVO.setEdiSnpRtnVal(ediSnpRtnVal);
			//Model No. 27
			focVO.setEdiRcvId(focVO.getEdiRcvId());
			focVO.setEdiSndId(focVO.getEdiSndId());
			this.priLog("model No. 27", focVO);
			log.debug("-------------- focVO "+ focVO.getColumnValues());
	    	dbDao.addUsCgoRlsLogRslt(focVO,this.account);
			
			flatFile = new StringBuffer();
		}
		
        
        
        //-----------------------------------------------------------------------------
        //SND Flat File 전송
        //-----------------------------------------------------------------------------
        String snpEdiAddInd = focVO.getEdiAddInd();
        //log.debug("~~~~~~~~~~~~~~~~~~~ snpEdiAddInd "+ snpEdiAddInd);
        if(snpEdiAddInd.equals("Y")){
        	for(int i=0;i<flatFileVOs.size();i++){
    			UsCgoRlseBkbcFlatFileVO flatFileVO = flatFileVOs.get(i);
    			//log.debug("----------------------------------------------");
    			//log.debug(flatFileVO.getFlatFileHeader());
    			flatFileVO.getSnpFileHeader();
    			//log.debug("----------------------------------------------");
    			
    			flatFile.append(flatFileVO.getSnpFileHeader());
    			flatFile.append(flatFileVO.getFlatFileBody());
    			flatFile.append(flatFileVvd);
    			if(i == 0 ){
    				break;
    			}
    		}
        	ediSnpRtnVal = this.comSendFlatFile(focVO, flatFile);//Flat File 전송후 리턴되는 결과값
        	
        	//String ediRcvId = focVO.getEdiRcvId();
        	//String ediSnpRcvId = focVO.getEdiSnpRcvId();
        	//Model No. 28
        	//if(ediRcvId.equals(ediSnpRcvId)){
	            //Model No. 29
    		focVO.setEdiSnpRtnVal(ediSnpRtnVal);
    		focVO.setEdiRcvId(focVO.getEdiSnpRcvId());
    		focVO.setEdiSndId(focVO.getEdiSnpSndId());
    		this.priLog("model No. 29", focVO);
    		log.debug("-------------- focVO "+ focVO.getColumnValues());
            dbDao.addUsCgoRlsLogRslt(focVO,this.account);
        	//}
            
        }
        
        //Model No. 30
        dbDao.modifyUsCgoRlsHisRslt(focVO,this.account);
        this.priLog("model No. 30", focVO);
        log.debug("-------------- focVO "+ focVO.getColumnValues());
        //Model No. 31
        dbDao.modifyUsCgoRlsRslt(focVO,this.account);
        this.priLog("model No. 31", focVO);
        log.debug("-------------- focVO "+ focVO.getColumnValues());
        
        
        return focVO;
		
	}
	/**
	 * Flat File 공용전송
	 * @param focVO
	 * @param flatFile
	 * @return String
	 * @exception EventException
	 * @exception DAOException
	 */
	private String comSendFlatFile(UsCgoRlseBkbcFocVO focVO,
			StringBuffer flatFile) throws EventException, DAOException {
		SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
        sendFlatFileVO.setFlatFile(flatFile.toString());

        //QueueNm 세팅
        //sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_NACCS.IBMMQ.QUEUE"));
        sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_CUSTOMER.IBMMQ.QUEUE"));
        BookingUtil command = new BookingUtil();

        FlatFileAckVO flatFileAckVO = new FlatFileAckVO();
        flatFileAckVO = command.sendFlatFile(sendFlatFileVO);

        //EDI ERROR 발생 시
        if ( flatFileAckVO.getAckStsCd().equals("E")){
            throw new EventException(new ErrorHandler("BKG40087").getMessage());
        }
        
        return flatFileAckVO.getAckStsCd();
		
	}
	/**
	 * Event_1 model No. 15
	 * @param focVO
	 * @return String
	 * @exception DAOException
	 */
	private String searchMkVvdFile(UsCgoRlseBkbcFocVO focVO) throws DAOException {
		List<UsCgoRlseBkbcFlatFileVO> flatFileVO;
		String retVvd = "";
		
		flatFileVO = dbDao.searchVvdMkFile(focVO);
		
		for(int i=0;i<flatFileVO.size();i++){	
			StringBuffer tmpBuffer = new StringBuffer(retVvd).append(flatFileVO.get(i).getFlatFileVvd());
			retVvd = tmpBuffer.toString();
		}
		
		return retVvd;
	}
	/**
	 * Event_1 model No. 14
	 * @param focVO
	 * @param flg
	 * @return UsCgoRlseBkbcFocVO
	 * @exception DAOException
	 * @exception EventException 
	 */
	private List<UsCgoRlseBkbcFlatFileVO> searchMkFile(UsCgoRlseBkbcFocVO focVO,String flg) throws DAOException, EventException {
		List<UsCgoRlseBkbcFlatFileVO> flatFileVO = null;
		
		//2010.03.15 by sungho ; Send ID, Receive ID의 값이 둘다 있어야지 실행됨. 
		if(focVO.getEdiSndId() == null 
				|| focVO.getEdiSndId().trim().equals("")
				|| focVO.getEdiRcvId() == null 
				|| focVO.getEdiRcvId().trim().equals("")				
			){
			//전송 대상이 아닐 경우 : The B/L you selected for Carriers' Release is not applicable to transmit.
			if ( !"".equals(eventId)) dbDao.receiveOtsLog("BKG_US_CGO_POD", "searchMkFile==>"+ eventId + ":" + blNo, "CR2/blNo:"+blNo+"/oldPod="+oldPodCd+"/newPod:"+newPodCd );
	   		throw new EventException(new ErrorHandler("BKG40085").getMessage());
		}
			
		if(flg.equals("I")){
			flatFileVO = dbDao.searchCstmsMkFile(focVO);
		}else if(flg.equals("B")){
			flatFileVO = dbDao.searchBkgMkFile(focVO);
		}else{
			//The B/L you selected for Carriers' Release doesn't have sufficient data to transmit
			dbDao.receiveOtsLog("BKG_US_CGO_POD", blNo, "searchMkFile :"+flg);
			throw new EventException(new ErrorHandler("BKG40086").getMessage());
		}
		
		dbDao.receiveOtsLog("BKG_US_CGO_POD", blNo, flatFileVO.toString());
		return flatFileVO;
	}
	/**
	 * Event_1 model No. 12
	 * @param focVO
	 * @return UsCgoRlseBkbcFocVO
	 * @exception DAOException
	 */
	private UsCgoRlseBkbcFocVO searchPoLocSlan(UsCgoRlseBkbcFocVO focVO) throws DAOException {
		UsCgoRlseBkbcFocVO tmpFocVO;
		tmpFocVO = dbDao.searchPoLocSlan(focVO,this.account);		
		
	    focVO.setPoNo(tmpFocVO.getPoNo());    
		focVO.setLocCd(tmpFocVO.getLocCd());
		focVO.setVslSlanNm(tmpFocVO.getVslSlanNm());
	    
		
		return focVO;
	}
	/**
	 * Event_1 model No. 9
	 * @param focVO
	 * @return UsCgoRlseBkbcFocVO
	 * @exception DAOException
	 */
	private UsCgoRlseBkbcFocVO searchOldNewFocFlg(UsCgoRlseBkbcFocVO focVO) throws DAOException {
		UsCgoRlseBkbcFocVO tmpFocVO;
		tmpFocVO = dbDao.searchOldNewFocFlg(focVO);
		
	    focVO.setOldFrtCltFlg(tmpFocVO.getOldFrtCltFlg());
		focVO.setOldOblRdemFlg(tmpFocVO.getOldOblRdemFlg());
		focVO.setOldCstmsClrCd(tmpFocVO.getOldCstmsClrCd());
		focVO.setNewFrtCltFlg(tmpFocVO.getNewFrtCltFlg());
		focVO.setNewOblRdemFlg(tmpFocVO.getNewOblRdemFlg());
		focVO.setNewCstmsClrCd(tmpFocVO.getNewCstmsClrCd());
		
		
		
		return focVO;
	}
	/**
	 * Event_1 model No. 7
	 * @param focVO
	 * @return UsCgoRlseBkbcFocVO
	 * @exception DAOException
	 */
	private UsCgoRlseBkbcFocVO searchVskInfo(UsCgoRlseBkbcFocVO focVO) throws DAOException {
		UsCgoRlseBkbcFocVO tmpFocVO;
		tmpFocVO = dbDao.searchVskInfo(focVO);
		focVO.setVpsEtdDt(tmpFocVO.getVpsEtdDt());
		focVO.setVpsEtdDtGmt(tmpFocVO.getVpsEtdDtGmt());
		focVO.setInitEtdDt(tmpFocVO.getInitEtdDt());
		focVO.setInitEtdDtGmt(tmpFocVO.getInitEtdDtGmt());
		focVO.setVpsEtaDt(tmpFocVO.getVpsEtaDt());
		focVO.setVpsEtaDtGmt(tmpFocVO.getVpsEtaDtGmt());
		focVO.setInitEtaDt(tmpFocVO.getInitEtaDt());
		focVO.setInitEtaDtGmt(tmpFocVO.getInitEtaDtGmt());
		focVO.setFinalEtaDt(tmpFocVO.getFinalEtaDt());
		focVO.setFinalEtaDtGmt(tmpFocVO.getFinalEtaDtGmt());
		
		return focVO;
	}
	/**
	 * Event_1 model No. 6
	 * @param focVO
	 * @return UsCgoRlseBkbcFocVO
	 * @exception DAOException
	 */
	private UsCgoRlseBkbcFocVO searchIbdBkgInfo(UsCgoRlseBkbcFocVO focVO) throws DAOException {
		UsCgoRlseBkbcFocVO tmpFocVO;
		tmpFocVO = dbDao.searchIbdBkgInfo(focVO);
		focVO.setIbdBkgInd(tmpFocVO.getIbdBkgInd());		
		focVO.setVskVvdCd(tmpFocVO.getVskVvdCd());
		focVO.setVslCd(tmpFocVO.getVslCd());		
		focVO.setSkdVoyNo(tmpFocVO.getSkdVoyNo());
		focVO.setSkdDirCd(tmpFocVO.getSkdDirCd());
		focVO.setPolCd(tmpFocVO.getPolCd());
		focVO.setPodCd(tmpFocVO.getPodCd());
		focVO.setDelCd(tmpFocVO.getDelCd());
		focVO.setEdiSnpSndId(JSPUtil.getNullNoTrim(tmpFocVO.getEdiSnpSndId()));
		focVO.setEdiSnpRcvId(JSPUtil.getNullNoTrim(tmpFocVO.getEdiSnpRcvId()));		
		focVO.setEdiAddInd(tmpFocVO.getEdiAddInd());
		
		return focVO;
	}
	/**
	 * Event_1 model No. 5
	 * @param focVO
	 * @return UsCgoRlseBkbcFocVO
	 * @exception DAOException
	 */
	private UsCgoRlseBkbcFocVO searchCustCode(UsCgoRlseBkbcFocVO focVO) throws DAOException {
		UsCgoRlseBkbcFocVO tmpFocVO;
		tmpFocVO = dbDao.searchCustCode(focVO);
		focVO.setCustCntCd(tmpFocVO.getCustCntCd());
		focVO.setCustSeq(tmpFocVO.getCustSeq());
		focVO.setCustCd(tmpFocVO.getCustCd());
		focVO.setEdiBlCntrInd(tmpFocVO.getEdiBlCntrInd());
		focVO.setBkgNo(tmpFocVO.getBkgNo());

		
		return focVO;
	}
	/**
	 * Event_1 model No. 2
	 * @param focVO
	 * @return UsCgoRlseBkbcFocVO
	 * @exception DAOException
	 */
	private UsCgoRlseBkbcFocVO searchEdiRcvSndIdCr(UsCgoRlseBkbcFocVO focVO)
			throws DAOException {
		UsCgoRlseBkbcFocVO tmpFocVO;
		tmpFocVO = dbDao.searchEdiRcvSndIdCr(focVO);
		focVO.setEdiMsgId(tmpFocVO.getEdiMsgId());
		focVO.setEdiRcvId(tmpFocVO.getEdiRcvId());
		focVO.setEdiSndId(tmpFocVO.getEdiSndId());
		focVO.setYdCd(tmpFocVO.getYdCd());
		
		return focVO;
	} 
	/**
	 * Event_1 model No. 3
	 * @param focVO
	 * @return UsCgoRlseBkbcFocVO
	 * @exception DAOException
	 */
	private UsCgoRlseBkbcFocVO searchEdiRcvSndIdCa(UsCgoRlseBkbcFocVO focVO)
			throws DAOException {
		UsCgoRlseBkbcFocVO tmpFocVO;
		tmpFocVO = dbDao.searchEdiRcvSndIdCa(focVO);
		focVO.setEdiMsgId(tmpFocVO.getEdiMsgId());
		focVO.setEdiRcvId(tmpFocVO.getEdiRcvId());
		focVO.setEdiSndId(tmpFocVO.getEdiSndId());
		focVO.setYdCd(tmpFocVO.getYdCd());
		
		return focVO;
	}	
	/**
	 * Event_1 model No. 4
	 * @param focVO
	 * @return UsCgoRlseBkbcFocVO
	 * @exception DAOException
	 */
	private UsCgoRlseBkbcFocVO searchEdiRcvSndIdHld(UsCgoRlseBkbcFocVO focVO)
			throws DAOException {
		UsCgoRlseBkbcFocVO tmpFocVO;
		tmpFocVO = dbDao.searchEdiRcvSndIdHld(focVO);
		focVO.setEdiMsgId(tmpFocVO.getEdiMsgId());
		focVO.setEdiRcvId(tmpFocVO.getEdiRcvId());
		focVO.setEdiSndId(tmpFocVO.getEdiSndId());
		focVO.setYdCd(tmpFocVO.getYdCd());
		
		return focVO;
	}
	
	
	/**
	 * Add CT Event_1 model No. 2
	 * @param focVO
	 * @return UsCgoRlseBkbcFocVO
	 * @exception DAOException
	 */
	private UsCgoRlseBkbcFocVO searchEdiRcvSndIdCt(UsCgoRlseBkbcFocVO focVO)
			throws DAOException {
		UsCgoRlseBkbcFocVO tmpFocVO;
		tmpFocVO = dbDao.searchEdiRcvSndIdCt(focVO);
		focVO.setEdiMsgId(tmpFocVO.getEdiMsgId());
		focVO.setEdiRcvId(tmpFocVO.getEdiRcvId());
		focVO.setEdiSndId(tmpFocVO.getEdiSndId());
		focVO.setYdCd(tmpFocVO.getYdCd());
		
		return focVO;
	} 	
	/**
	 * 로컬만 사용되는 로그
	 * @param obj
	 */
	private void priLog(String name, AbstractValueObject obj){
		log.debug("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	   	/*log.debug("[   " + name + "   ]"); */
	   	/* log.debug(obj.getColumnValues()); */
	   	Map map = obj.getColumnValues();
	   	Set s = map.keySet();
	   	Iterator iter = s.iterator();
	   	
	   	while(iter.hasNext()){
	   		Object n = iter.next();
	   		if(map.get(n) != null){
	   			log.debug("~~~~~~ "+ n + "     => " + map.get(n));
	   		}
	   		
	   	}
	   	
	   	log.debug("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
	/**
	 * 로컬에서만 사용
	 * 값을 출력
	 * @param name
	 * @param value
	 */
	private void printValue(String name,Object value){
		log.debug(name + " ===================> '"+value +"'");
	}
	
	/**
	 * ############
	 * 값을 출력
	 * @param name
	 * @param value
	 */
	private String getChangePod(String podCd){
		
		String returnPodCd = newPodCd;
		
		if( "".equals(newPodCd)) returnPodCd = podCd;
		
		return returnPodCd;
		
	}	
}