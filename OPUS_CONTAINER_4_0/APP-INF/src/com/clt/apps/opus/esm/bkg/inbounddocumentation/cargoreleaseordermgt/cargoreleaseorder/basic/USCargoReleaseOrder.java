/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : CargoReleaseOrderBCImpl.java
*@FileTitle      :
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.04.30
*@LastModifier   :
*@LastVersion    : 1.0
* 2009.04.30
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.clt.apps.opus.esd.sce.edi315send.basic.Edi315SendBC;
import com.clt.apps.opus.esd.sce.edi315send.basic.Edi315SendBCImpl;
import com.clt.apps.opus.esd.sce.edi315send.vo.Edi315AmsDataVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration.CargoReleaseOrderDBDAO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseBkbcBlVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseBkbcFlatFileVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseBkbcFocVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseBkbcSceVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseSearchVO;
import com.clt.bizcommon.edi.broker.ReferenceNumberGeneratorBroker;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 *   CargoReleaseOrderMgt for US Business Logic<br>
 * - CargoReleaseOrderMgt for US 대한 비지니스 로직을 처리한다.<br>
 *
 * @author
 * @see Related DAO Class
 * @since J2EE 1.6
 */
public class USCargoReleaseOrder extends BasicCommandSupport {

	private SignOnUserAccount account;
	private transient CargoReleaseOrderDBDAO dbDao = new CargoReleaseOrderDBDAO();


	/**
	 * FOC 관리 시작
	 *
	 * @param String blNo
	 * @param String multiSnd
	 * @param SignOnUserAccount account
	 * @exception Exception
	 */
	public void bkbcUsCgoEdi(String blNo, String multiSnd, SignOnUserAccount account) throws Exception {

		this.account = account;

		long startTime1 = System.currentTimeMillis();
		/***************************
		  * 3. FOC 관리 시작
		  ****************************/
		 UsCgoRlseBkbcBlVO usCgoRlseBkbc = new UsCgoRlseBkbcBlVO();
		 usCgoRlseBkbc.setBlNo(blNo);
		 log.debug("~~~~~~~~~~~~ 3. FOC 관리 시작 bl_no : "+usCgoRlseBkbc.getBlNo());
		 log.debug("~~~~~~~~~~~~ his_seq : "+usCgoRlseBkbc.getHisSeq());

			// DO_HLD_FLG가 'Y'일 경우, 이하의 처리를 수행하지 않는다.
			UsCgoRlseSearchVO searchVo = new UsCgoRlseSearchVO();
			searchVo.setBlNo(blNo);
			List<UsCgoRlseListVO> list = dbDao.searchUsCgoRlseList(searchVo);
			if(list != null && list.size() > 0){
				// 1건만 비교한다.
				UsCgoRlseListVO usCgoRlseListVO = (UsCgoRlseListVO)list.get(0);
				if("Y".equals(usCgoRlseListVO.getDoHldFlg()) && "N".equals(multiSnd)){
					//전송 대상이 아닐 경우 : The B/L you selected for Carriers' Release is not applicable to transmit.
					throw new EventException(new ErrorHandler("BKG40085").getMessage());
				}
			}



		//------------------------------------------------------------
		//Cargo Release Check Data Setting
		//------------------------------------------------------------
		usCgoRlseBkbc = this.getCheckData(usCgoRlseBkbc);



		 log.debug("------------------------------------------------------------");
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

		 String cstmsDpFlg = usCgoRlseBkbc.getCstmsDspoCd()==null?"":usCgoRlseBkbc.getCstmsDspoCd();

		 //multi sending을 위한 추가
		 String crntFrtCltFlg = usCgoRlseBkbc.getCrntFrtCltFlg()==null?"":usCgoRlseBkbc.getCrntFrtCltFlg();
		 String crntOblRdemFlg = usCgoRlseBkbc.getCrntOblRdemFlg()==null?"":usCgoRlseBkbc.getCrntOblRdemFlg();
		 String crntCstmsClrCd = usCgoRlseBkbc.getCrntCstmsClrCd()==null?"":usCgoRlseBkbc.getCrntCstmsClrCd();

		 String focInlndYdCd = usCgoRlseBkbc.getInlndFullRlseEdiCd()==null?"":usCgoRlseBkbc.getInlndFullRlseEdiCd();
		 String inlndCd = usCgoRlseBkbc.getInlndCd()==null?"":usCgoRlseBkbc.getInlndCd();

		 String inlndYdEdiSndCd = usCgoRlseBkbc.getInlndYdEdiSndCd() == null?"":usCgoRlseBkbc.getInlndYdEdiSndCd();
		 
		 String ipiMvmt = usCgoRlseBkbc.getIpiMvmt() == null?"":usCgoRlseBkbc.getIpiMvmt();

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

		log.debug("--- crntFrtCltFlg ==========> '" + crntFrtCltFlg + "'");
		log.debug("--- crntOblRdemFlg ==========> '" + crntOblRdemFlg + "'");
		log.debug("--- crntCstmsClrCd ==========> '" + crntCstmsClrCd + "'");
		log.debug("--- focInlndYdCd ==========> '" + focInlndYdCd + "'");
		log.debug("--- inlndCd ==========> '" + inlndCd + "'");
		log.debug("--- inlndYdEdiSndCd ==========> '" + inlndYdEdiSndCd + "'");
		log.debug("--- ipiMvmt ==========> '" + ipiMvmt + "'");


	  //----------------------------------
		//해당 원 BL 이 Partial 인경우 나머지 BL 들을 찾는다.
		//나머지 BL들이 Customs Clear가 되지 않은경우 BackEnd 수행하지 않음.
		//----------------------------------
	  // partial을 더이상 체크하지 않는다.




		 //model No. 9

		UsCgoRlseBkbcFocVO focVO = new UsCgoRlseBkbcFocVO();

			//SCE 로 EDI를 보내기 위함.
			log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			log.debug("--------------------- SCE Start -----------");

			focVO.setBlNo(usCgoRlseBkbc.getBlNo());
			focVO.setHisSeq(usCgoRlseBkbc.getHisSeq());
			focVO.setMultiSnd(multiSnd);

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

				//SCE 호출
				// SCE 모듈의 Method 변경건으로 인한 처리 Start

				Edi315AmsDataVO amsDataVO = new Edi315AmsDataVO();

				amsDataVO.setBlNo(focVO.getBlNo());
				amsDataVO.setEdiSts(focVO.getSceMsgId());
				amsDataVO.setEventDt(sceVO.getEventDt());
				amsDataVO.setEventYd(sceVO.getEventYd());

				focVO.setSceScsCd(bc.addSceEdiAmsIf( amsDataVO));

				// SCE 모듈의 Method 변경건으로 인한 처리 End

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
				// SCE 모듈의 Method 변경건으로 인한 처리 Start

				Edi315AmsDataVO amsDataVO = new Edi315AmsDataVO();

				amsDataVO.setBlNo(focVO.getBlNo());
				amsDataVO.setEdiSts(focVO.getSceMsgId());
				amsDataVO.setEventDt(sceVO.getEventDt());
				amsDataVO.setEventYd(sceVO.getEventYd());
				focVO.setSceScsCd(bc.addSceEdiAmsIf( amsDataVO));

				// SCE 모듈의 Method 변경건으로 인한 처리 End
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
				//SCE 모듈의 Method 변경건으로 인한 처리 Start

				Edi315AmsDataVO amsDataVO = new Edi315AmsDataVO();

				//amsDataVO.setBlNo(usCgoRlseBkbc.getBlNo());
				//amsDataVO.setEdiSts("CT");

				amsDataVO.setBlNo(focVO.getBlNo());
				amsDataVO.setEdiSts(focVO.getSceMsgId());
				amsDataVO.setEventDt(sceVO.getEventDt());
				amsDataVO.setEventYd(sceVO.getEventYd());
				focVO.setSceScsCd(bc.addSceEdiAmsIf( amsDataVO));

				//SCE 모듈의 Method 변경건으로 인한 처리 End
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
				// SCE 모듈의 Method 변경건으로 인한 처리 Start

				Edi315AmsDataVO amsDataVO = new Edi315AmsDataVO();

				amsDataVO.setBlNo(focVO.getBlNo());
				amsDataVO.setEdiSts(focVO.getSceMsgId());
				amsDataVO.setEventDt(sceVO.getEventDt());
				amsDataVO.setEventYd(sceVO.getEventYd());
				focVO.setSceScsCd(bc.addSceEdiAmsIf( amsDataVO));

				// SCE 모듈의 Method 변경건으로 인한 처리 End
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
				// SCE 모듈의 Method 변경건으로 인한 처리 Start

				Edi315AmsDataVO amsDataVO = new Edi315AmsDataVO();

				amsDataVO.setBlNo(focVO.getBlNo());
				amsDataVO.setEdiSts(focVO.getSceMsgId());
				amsDataVO.setEventDt(sceVO.getEventDt());
				amsDataVO.setEventYd(sceVO.getEventYd());
				focVO.setSceScsCd(bc.addSceEdiAmsIf( amsDataVO));

				// SCE 모듈의 Method 변경건으로 인한 처리 End
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
				//SCE 호출
				// SCE 모듈의 Method 변경건으로 인한 처리 Start

				Edi315AmsDataVO amsDataVO = new Edi315AmsDataVO();

				amsDataVO.setBlNo(focVO.getBlNo());
				amsDataVO.setEdiSts(focVO.getSceMsgId());
				amsDataVO.setEventDt(sceVO.getEventDt());
				amsDataVO.setEventYd(sceVO.getEventYd());
				focVO.setSceScsCd(bc.addSceEdiAmsIf( amsDataVO));

				// SCE 모듈의 Method 변경건으로 인한 처리 End
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
				//SCE 호출
				// SCE 모듈의 Method 변경건으로 인한 처리 Start

				Edi315AmsDataVO amsDataVO = new Edi315AmsDataVO();

				amsDataVO.setBlNo(focVO.getBlNo());
				amsDataVO.setEdiSts(focVO.getSceMsgId());
				amsDataVO.setEventDt(sceVO.getEventDt());
				amsDataVO.setEventYd(sceVO.getEventYd());
				focVO.setSceScsCd(bc.addSceEdiAmsIf( amsDataVO));

				// SCE 모듈의 Method 변경건으로 인한 처리 End
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
				//SCE 호출
				// SCE 모듈의 Method 변경건으로 인한 처리 Start

				Edi315AmsDataVO amsDataVO = new Edi315AmsDataVO();

				amsDataVO.setBlNo(focVO.getBlNo());
				amsDataVO.setEdiSts(focVO.getSceMsgId());
				amsDataVO.setEventDt(sceVO.getEventDt());
				amsDataVO.setEventYd(sceVO.getEventYd());
				focVO.setSceScsCd(bc.addSceEdiAmsIf( amsDataVO));

				// SCE 모듈의 Method 변경건으로 인한 처리 End
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
				//SCE 호출
				// SCE 모듈의 Method 변경건으로 인한 처리 Start

				Edi315AmsDataVO amsDataVO = new Edi315AmsDataVO();

				amsDataVO.setBlNo(focVO.getBlNo());
				amsDataVO.setEdiSts(focVO.getSceMsgId());
				amsDataVO.setEventDt(sceVO.getEventDt());
				amsDataVO.setEventYd(sceVO.getEventYd());
				focVO.setSceScsCd(bc.addSceEdiAmsIf( amsDataVO));

				// SCE 모듈의 Method 변경건으로 인한 처리 End
				dbDao.addUsCgoRlsLogSceRslt(focVO,this.account);
				log.debug("------------------------SCE 비교 IF " + focVO.getSceMsgId()+" End -----------------------");
				log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
			}
			long endTime = System.currentTimeMillis();
			log.debug("---------------- SCE 실행시간은 "+ ((endTime - startTime2)/ 1000));
			}catch(Exception e){
			//Business Logic 상 Exception 처리불가.
				long endTime = System.currentTimeMillis();
				log.error("---------------- SCE 실행시간은 "+ ((endTime - startTime2)/ 1000));
			}

			//Model No. 30
			this.priLog("model No. 30", focVO);
			dbDao.modifyUsCgoRlsHisSceRslt(focVO,this.account);



			log.debug("--------------------- SCE End -----------");
			log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

		//}


		/***************************1. 멀티 BL TDC315 보낼 경우******************/
		if("Y".equals(multiSnd)){
			/*********************111. Inland BL Multi 이벤트 전송*************************/
		   if(inlndCd.equals("Y")){
			//CT case : Customs Clearance flag가 Y 라면 CT 전송
			//BKG CGO HIS 에 찍을 때 T 먼저 update 되고 다음 R이 업데이트 될수있게 앞에 배치
			 if((crntCstmsClrCd.equals("Y")) && (focInlndYdCd.equals("2"))){
				log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				log.debug("--------------------- Multi BL Inland CT Case 1 Start -----------");
				this.printValue("oldCstmsFlg",oldCstmsFlg);
				this.printValue("newCstmsFlg",newCstmsFlg);
				focVO = this.sendEventInlndCT(usCgoRlseBkbc,"CT1");
				log.debug("--------------------- Multi BL Inland CT Case 1 End -----------");
				log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
			 }


			   if((  (crntFrtCltFlg.equals("Y")) && (crntOblRdemFlg.equals("Y"))   &&
					   ((focInlndYdCd.equals("1")) ||(focInlndYdCd.equals("2")))
					  )
					  ){
				log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				log.debug("--------------------- Multi BL Inland CR Case 4 Start -----------");
				this.log.debug("----------- usCgoRlseBkbc "+usCgoRlseBkbc.getColumnValues());
				this.printValue("crntFrtCltFlg",crntFrtCltFlg);
				this.printValue("crntOblRdemFlg",crntOblRdemFlg);
				focVO = this.sendEventInlndCR(usCgoRlseBkbc,"CR4");
				log.debug("--------------------- Multi BL Inland CR Case 4 End -----------");
				log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
			 }
//Pushkar #7504  (2016-01-15 20:51)   CA is not needed on Inbound Voyage Control.
//	   		   else if(( crntFrtCltFlg.equals("N")
//		   					|| crntOblRdemFlg.equals("N")) &&
//			 	   			   ((focInlndYdCd.equals("1")) ||(focInlndYdCd.equals("2")))
//		   			 ){
//	   			log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//		   		log.debug("--------------------- Multi BL Inland CA Case 1 Start -----------");
//
//		   		this.printValue("crntOblRdemFlg",crntOblRdemFlg);
//		   		this.printValue("ipiLclCd",ipiLclCd);
//		   		this.printValue("crntCstmsClrCd",crntCstmsClrCd);
//		   		focVO = this.sendEventInlndCA(usCgoRlseBkbc,"CA1");
//		   		log.debug("---------------------Multi BL Inland CA Case 1 End -----------");
//	   			log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
//	   		 }else if(focInlndYdCd.equals("2")
//		   		   	&&  (crntCstmsClrCd.equals("H") || crntCstmsClrCd.equals("J"))){
//	   			log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//	   		   	log.debug("--------------------- Multi BL Inland CA Case 2 Start -----------");
//	   		    this.printValue("crEdiCd",crEdiCd);
//	   		    this.printValue("focInlndYdCd",focInlndYdCd);
//	   		    this.printValue("newCstmsFlg",newCstmsFlg);
//	   		    focVO = this.sendEventInlndCA(usCgoRlseBkbc,"CA2");
//	   		    log.debug("--------------------- Multi BL Inland CA Case 2 End -----------");
//	   			log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
//	   		 }

			 else if( cstmsDpFlg.equals("6H")){
					log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
					log.debug("--------------------- Multi BL Inland PA Start -----------");
					this.printValue("cstmsDpFlg",cstmsDpFlg);
					focVO = this.sendEventInlndPA(usCgoRlseBkbc,"PA1");


					log.debug("--------------------- Multi BL Inland PA End -----------");
					log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
				}

		   }

		   /*********************222. Terminal BL Multi 이벤트 전송*************************/
			
			if ((crntCstmsClrCd.equals("Y")) && focYdCd.equals("2"))
					{ //CT 일경우의 조건
					log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
					log.debug("--------------------- CT Case 1 Start -----------");
					this.printValue("oldCstmsFlg",oldCstmsFlg);
					this.printValue("newCstmsFlg",newCstmsFlg);

						focVO = this.sendEventCT(usCgoRlseBkbc,"CT1");

					log.debug("--------------------- CT Case 1 End -----------");
					log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
					}else if ((ipiLclCd.equals("I"))
							   &&  crntCstmsClrCd.equals("J")
							   && (focYdCd.equals("2"))//#13900 FO 조건에서는 CT 필요없음 focYdCd.equals("1") ||
							){//CT 일경우의 조건
						log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
						log.debug("--------------------- CT Case 2 Start -----------");
						this.printValue("oldCstmsFlg",oldCstmsFlg);
						this.printValue("newCstmsFlg",newCstmsFlg);

							focVO = this.sendEventCT(usCgoRlseBkbc,"CT1");

						log.debug("--------------------- CT Case 2 End -----------");
						log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
						
					}
		   
		   
		   //1. CR1 case
			if ((ipiLclCd.equals("I"))
				   &&  (crntCstmsClrCd.equals("J") ||crntCstmsClrCd.equals("Y")) //#13900 1C full quantity CR
				   && (focYdCd.equals("1") || focYdCd.equals("2")))
			  {
				log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				log.debug("---------------------Multi BL CR Case 1 Start -----------");
				this.printValue("ipiLclCd",ipiLclCd);
				this.printValue("crEdiCd",crEdiCd);
				this.printValue("cstmsFlg",cstmsFlg);
				this.printValue("focYdCd",focYdCd);
				focVO = this.sendEventCR(usCgoRlseBkbc,"CR1");
				log.debug("---------------------Multi BL CR Case 1 End -----------");
				log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
			   }

			//2. CR2 case
			 else if   ((focYdCd.equals("1")   || focYdCd.equals("2")) //#13900 ipiLclCd='L'에 한정되어있던 로직 삭제
					 && (crntFrtCltFlg.equals("Y") && crntOblRdemFlg.equals("Y"))
					 && (pltlCnt.equals("0")))
				 {

				log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				log.debug("--------------------- CR Case 2 Start (pltlCnt == 0) -----------");
				this.printValue("ipiLclCd",ipiLclCd);
				this.printValue("crEdiCd",crEdiCd);
				this.printValue("focYdCd",focYdCd);
				this.printValue("crntFrtCltFlg",crntFrtCltFlg);
				this.printValue("pltlCnt",pltlCnt);
				focVO = this.sendEventCR(usCgoRlseBkbc,"CR2");

				log.debug("--------------------- CR Case 2 End (pltlCnt == 0)-----------");
				log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		 }
		 else if  ((ipiLclCd.equals("L"))
				 && (focYdCd.equals("1")   || focYdCd.equals("2"))
				 && (crntFrtCltFlg.equals("Y") && crntOblRdemFlg.equals("Y"))
				 && (Integer.parseInt(pltlCnt) > 0 ))
				{
				log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				log.debug("--------------------- CR Case 3 Start (Integer.parseInt(pltlCnt) > 0 and pltlClrCnt == 0)-----------");
				this.printValue("ipiLclCd",ipiLclCd);
				this.printValue("crEdiCd",crEdiCd);
				this.printValue("focYdCd",focYdCd);
				this.printValue("crntFrtCltFlg",newFrtFlg);
				this.printValue("pltlCnt",pltlCnt);
				this.printValue("pltlClrCnt",pltlClrCnt);

				//기존 Partial B/L인 경우 다른 B/L의 C값의 Clearance여부를 따졌으나, 로직 해제한다. CR2로 한다.
				focVO = this.sendEventCR(usCgoRlseBkbc,"CR2");

				log.debug("--------------------- CR Case 3 End (Integer.parseInt(pltlCnt) > 0 and pltlClrCnt == 0)-----------");
				log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		}
		//3. CR4 case
		else if  ((
				   (crntFrtCltFlg.equals("Y")) && (crntOblRdemFlg.equals("Y"))   &&
				   (focYdCd.equals("1"))
				  ) ||
				  (
					crntFrtCltFlg.equals("Y") && crntOblRdemFlg.equals("Y") && crntCstmsClrCd.equals("Y") &&
					focYdCd.equals("1")
				  ))
		{
			log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			log.debug("--------------------- CR Case 4 Start -----------");
			this.log.debug("----------- usCgoRlseBkbc "+usCgoRlseBkbc.getColumnValues());
			this.printValue("crntFrtCltFlg",crntFrtCltFlg);
			this.printValue("crntOblRdemFlg",crntOblRdemFlg);
			focVO = this.sendEventCR(usCgoRlseBkbc,"CR4");
			log.debug("--------------------- CR Case 4 End -----------");
			log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

		}
	    
	     //#13489 NSA - BKG - TDC 315 not triggered when we get 1C and container is moving on rail 20160523 Pushkar 요청
		// CR 전송 Case 중, Local clearance 이지만 IPI Movement 이고, customs Flag 가 Y이면 F/O check 없이 CR 전송(Marine terminal 에서 Rail 바로 싣기위해)
		//4. CR5 case
		 else if   ((ipiLclCd.equals("L")) && (ipiMvmt.equals("I"))
				 && (focYdCd.equals("1")   || focYdCd.equals("2"))
				 && (crntCstmsClrCd.equals("Y"))
				  )
			 {

			log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			log.debug("--------------------- CR Case 5 Start -----------");
			this.printValue("ipiLclCd",ipiLclCd);
			this.printValue("ipiMvmt",ipiMvmt);
			this.printValue("focYdCd",focYdCd);
			this.printValue("crntCstmsClrCd",crntCstmsClrCd);
			focVO = this.sendEventCR(usCgoRlseBkbc,"CR4");

			log.debug("--------------------- CR Case 5 End -----------");
			log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	 }

//Pushkar #7504  (2016-01-15 20:51)   CA is not needed on Inbound Voyage Control.
//	    //4. CA1 case
//	   	else if((crEdiCd.equals("R") || crEdiCd.equals("J") || crEdiCd.equals("A"))
//	   			&& ( crntFrtCltFlg.equals("N")
//	   					|| crntOblRdemFlg.equals("N"))
//	   			&&    (!ipiLclCd.equals("I") || !crntCstmsClrCd.equals("J"))
//	   		){
//	   		log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//	   		log.debug("--------------------- CA Case 1 Start -----------");
//
//	   		this.printValue("crntOblRdemFlg",crntOblRdemFlg);
//	   		this.printValue("ipiLclCd",ipiLclCd);
//	   		this.printValue("crntCstmsClrCd",crntCstmsClrCd);
//	   		focVO = this.sendEventCA(usCgoRlseBkbc,"CA1");
//
//   			log.debug("--------------------- CA Case 1 End -----------");
//   			log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
//	   	}
//	   	//5. CA2 case
//	   	else if   ((crEdiCd.equals("R") || crEdiCd.equals("J") || crEdiCd.equals("A"))
//	   			&& focYdCd.equals("2")
//	   			&&  (crntCstmsClrCd.equals("H") || crntCstmsClrCd.equals("J")))
//	   		{
//	   		log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//	   		log.debug("--------------------- CA Case 2 Start -----------");
//	   		this.printValue("crEdiCd",crEdiCd);
//	   		this.printValue("focYdCd",focYdCd);
//	   		this.printValue("newCstmsFlg",newCstmsFlg);
//
//	   		focVO = this.sendEventCA(usCgoRlseBkbc,"CA2");
//
//   			log.debug("--------------------- CA Case 2 End -----------");
//   			log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
//	   	}


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

			else{
				log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				log.debug("전송 대상이 아닐 경우 defect소스 아님 THROW: The B/L you selected for Carriers' Release is not applicable to transmit.");
				log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

			 }

		}else{
			/***************************2. BL 한 건만 TDC315 보낼 경우******************/
			/*************************************************************************/

		if (newCstmsFlg.equals("X")){
			//AMS DOWNLOAD대상만  가능.
			throw new EventException(new ErrorHandler("BKG40085").getMessage());
		}

		/*********************333. Inland BL 개별 이벤트 전송*************************/
		//inlndSnd : Inland에 보내진 것이 있다면 Port Terminal에 보낸 것이 없어도 Exception message를 띄우지 않기 위함 -> 요거(throw new EventException(new ErrorHandler("BKG40085").getMessage());)
	  String inlndSnd = "N";
		//Inland 전송
	   if(inlndCd.equals("Y")){

		//CT case : Customs Clearance flag가 Y로 바뀐다면 CT 전송
		//BKG CGO HIS 에 찍을 때 T 먼저 update 되고 다음 R이 업데이트 될수있게 앞에 배치
		if((newCstmsFlg.equals("Y") && oldCstmsFlg.equals(newCstmsFlg) == false) && focInlndYdCd.equals("2")){
				log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				this.printValue("oldCstmsFlg",oldCstmsFlg);
				this.printValue("newCstmsFlg",newCstmsFlg);
				log.debug("---------------------Inland CT Case 1 Start -----------");
				focVO = this.sendEventInlndCT(usCgoRlseBkbc,"CT1");
				inlndSnd = "Y";
				log.debug("---------------------Inland CT Case 1 End -----------");
				log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
			}

		 //CR case : 이전에 inland에 전송된 값이 CR이 아니고, F/O Y/Y 로 바뀌었거나(Old Flag 체크로직 뺌_#13900), F/O/C 모두 Y 인경우
		 if(     (!(inlndYdEdiSndCd.equals("R"))) &&
				 ((newFrtFlg.equals("Y")) && (newOblFlg.equals("Y"))) ||
				  (newFrtFlg.equals("Y") && newOblFlg.equals("Y") && newCstmsFlg.equals("Y") && focInlndYdCd.equals("2") )
			){
			log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			log.debug("--------------------- Inland CR Case 4 Start -----------");
			this.log.debug("----------- usCgoRlseBkbc "+usCgoRlseBkbc.getColumnValues());
			this.printValue("newFrtFlg",newFrtFlg);
			this.printValue("newOblFlg",newOblFlg);
			focVO = this.sendEventInlndCR(usCgoRlseBkbc,"CR4");
			inlndSnd = "Y";
			log.debug("---------------------Inland CR Case 4 End -----------");
			log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		}
		//CA case : 이전에 CR이 나갔고, 새로 변경된 F/O flag가 N 이면 CA
		else if( ((inlndYdEdiSndCd.equals("R")))
				&&  ( (oldFrtFlg.equals("Y") && newFrtFlg.equals("N"))
						|| (oldOblFlg.equals("Y") && newOblFlg.equals("N")))
//	   			&&    (!ipiLclCd.equals("I") || !newCstmsFlg.equals("J"))
				){
		   log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		   log.debug("---------------------Inland CA Case 1 Start -----------");
		   this.printValue("crEdiCd",crEdiCd);
		   this.printValue("oldFrtFlg",oldFrtFlg);
		   this.printValue("oldOblFlg",oldOblFlg);
		   this.printValue("newOblFlg",newOblFlg);
		   this.printValue("ipiLclCd",ipiLclCd);
		   this.printValue("newCstmsFlg",newCstmsFlg);

		   focVO = this.sendEventInlndCA(usCgoRlseBkbc,"CA1");
		   inlndSnd = "Y";
		   log.debug("---------------------Inland CA Case 1 End -----------");
		   log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		}
		//이전에 CT가 나갔고 6H를 받았을 경우 PA가 나간다.
		else if( (oldCstmsFlg.equals("Y")) && cstmsDpFlg.equals("6H")){
			log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			log.debug("---------------------Inland PA Start -----------");
			this.printValue("cstmsDpFlg",cstmsDpFlg);
			focVO = this.sendEventInlndPA(usCgoRlseBkbc,"PA1");
			inlndSnd = "Y";
			log.debug("---------------------Inland PA End -----------");
			log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		}

	   }

          
	      /*********************444. Terminal BL 개별 이벤트 전송*************************/
	     
	   String ctSnd = "N";
	   //#13900 CT sending together If Local and 1C on full quantity
	     if((ipiLclCd.equals("L") && (newCstmsFlg.equals("Y") && oldCstmsFlg.equals(newCstmsFlg) == false) && focYdCd.equals("2")) ||
	        (ipiLclCd.equals("I") && (newCstmsFlg.equals("Y") && oldCstmsFlg.equals(newCstmsFlg) == false) && focYdCd.equals("2")) ||
	        (ipiLclCd.equals("I") && (newCstmsFlg.equals("J") && oldCstmsFlg.equals(newCstmsFlg) == false) && focYdCd.equals("2"))){
	    	 focVO = this.sendEventCT(usCgoRlseBkbc,"CT1");
	    	 
	    	 ctSnd = "Y"; // CT 전송됨
	     }
	   
		//ipiLclCd='I' and «» crEdiCd={'A',Null} and cstmsFlg='J' and focYdCd={'1','2'}
		 if(        (ipiLclCd.equals("I"))
//				 && (crEdiCd.equals("")     || crEdiCd.equals("A")) //#13900 1C full quantity CR
				 && (cstmsFlg.equals("J") || (newCstmsFlg.equals("Y") && oldCstmsFlg.equals(newCstmsFlg) == false)) //#13900 1C full quantity CR
				 && (focYdCd.equals("1") || focYdCd.equals("2"))
				 ){
			log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			log.debug("--------------------- CR Case 1 Start -----------");
			this.printValue("ipiLclCd",ipiLclCd);
			this.printValue("crEdiCd",crEdiCd);
			this.printValue("cstmsFlg",cstmsFlg);
			this.printValue("focYdCd",focYdCd);
//			focVO = this.sendEventCT(usCgoRlseBkbc,"CT1");
			focVO = this.sendEventCR(usCgoRlseBkbc,"CR1");

			log.debug("--------------------- CR Case 1 End -----------");
			log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");


		 }
		 //[]crEdiCd={'A','J',Null} and focYdCd={'1','2'} and {newFrtFlg='Y' and newOblFlg='Y'}  #13900 ipiLclCd='L'에 한정되어있던 로직 삭제
		 //CR Case 2
		 else if   ((crEdiCd.equals("")       || crEdiCd.equals("A")	|| crEdiCd.equals("J"))
					 && (focYdCd.equals("1")   || focYdCd.equals("2"))
					 && (newFrtFlg.equals("Y") && newOblFlg.equals("Y"))
					 && (pltlCnt.equals("0")))
				 {
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
		 else if   ((ipiLclCd.equals("L"))
				 && (crEdiCd.equals("")       || crEdiCd.equals("A")	|| crEdiCd.equals("J"))
				 && (focYdCd.equals("1")   || focYdCd.equals("2"))
				 && (newFrtFlg.equals("Y") && newOblFlg.equals("Y"))
				 && (Integer.parseInt(pltlCnt) > 0 ))
				{
				log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				log.debug("--------------------- CR Case 3 Start (Integer.parseInt(pltlCnt) > 0 and pltlClrCnt == 0)-----------");
				this.printValue("ipiLclCd",ipiLclCd);
				this.printValue("crEdiCd",crEdiCd);
				this.printValue("focYdCd",focYdCd);
				this.printValue("newFrtFlg",newFrtFlg);
				this.printValue("pltlCnt",pltlCnt);
				this.printValue("pltlClrCnt",pltlClrCnt);

				//기존 Partial B/L인 경우 다른 B/L의 C값의 Clearance여부를 따졌으나, 로직 해제한다. CR2로 한다.
				focVO = this.sendEventCR(usCgoRlseBkbc,"CR2");


				log.debug("--------------------- CR Case 3 End (Integer.parseInt(pltlCnt) > 0 and pltlClrCnt == 0)-----------");
				log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

		}
		//[] newFrtFlg='Y' and newOblFlg='Y' and focYdCd='1'
		//CR Case 3
		//Model No.13
		// CR 전송 Case중, F/O가 모두 'Y'이고, 과거CR전송기록이 없으면 CR나가도록 추가.
		else if((
				   (newFrtFlg.equals("Y")) && (newOblFlg.equals("Y"))   &&
				   ((oldFrtFlg.equals("N")) || (oldOblFlg.equals("N"))) &&
				   (focYdCd.equals("1"))
				  ) ||
				  (
					newFrtFlg.equals("Y") && newOblFlg.equals("Y") && newCstmsFlg.equals("Y") &&
					!crEdiCd.equals("R")  && focYdCd.equals("1")
				  ))
		{
			log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			log.debug("--------------------- CR Case 4 Start -----------");
			this.log.debug("----------- usCgoRlseBkbc "+usCgoRlseBkbc.getColumnValues());
			this.printValue("newFrtFlg",newFrtFlg);
			this.printValue("newOblFlg",newOblFlg);
			focVO = this.sendEventCR(usCgoRlseBkbc,"CR4");
			log.debug("--------------------- CR Case 4 End -----------");
			log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

		}
		
		//#13489 NSA - BKG - TDC 315 not triggered when we get 1C and container is moving on rail 20160523 Pushkar 요청
	    // CR 전송 Case 중, Local clearance 이지만 IPI Movement 이고, customs Flag 가 Y이면 F/O check 없이 CR 전송(Marine terminal 에서 Rail 바로 싣기위해)
		else if   ((ipiLclCd.equals("L"))
				 && (focYdCd.equals("1")   || focYdCd.equals("2"))
				 && (ipiMvmt.equals("I"))
				 && (newCstmsFlg.equals("Y"))
				  )
				{
				log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				log.debug("--------------------- CR Case 5 Start -----------");
				this.printValue("ipiLclCd",ipiLclCd);
				this.printValue("crEdiCd",crEdiCd);
				this.printValue("focYdCd",focYdCd);
				this.printValue("newFrtFlg",newFrtFlg);

				//기존 Partial B/L인 경우 다른 B/L의 C값의 Clearance여부를 따졌으나, 로직 해제한다. CR2로 한다.
				focVO = this.sendEventCR(usCgoRlseBkbc,"CR4");


				log.debug("--------------------- CR Case 5 End -----------");
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
		else if   ((crEdiCd.equals("R") || crEdiCd.equals("J"))
				&& focYdCd.equals("2")
				&&  ((oldCstmsFlg.equals("Y") && newCstmsFlg.equals("N")) || (newCstmsFlg.equals("H"))))  // CA조건 추가 #13900 newCstmsFlg N 일때 추가  newCstmsFlg.equals("J") 뺌
			{
			log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			log.debug("--------------------- CA Case 2 Start -----------");
			this.printValue("crEdiCd",crEdiCd);
			this.printValue("focYdCd",focYdCd);
			this.printValue("newCstmsFlg",newCstmsFlg);
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

			//20151015 안진응 inlnd
//   			if ("Y".equals(inlndCd)) {
//   				focVO = this.sendEventPA(usCgoRlseBkbc,"PA1");
//   			}
			log.debug("--------------------- PA End -----------");
			log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		}

        //CT 전송이 없었고, Cflag 상태가 J 인경우 
		else if (ctSnd.equals("N") && (cstmsFlg.equals("J") && oldCstmsFlg.equals(newCstmsFlg) == false) && focYdCd.equals("2"))
				 { //CT 일경우의 조건
				log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				this.printValue("oldCstmsFlg",oldCstmsFlg);
				this.printValue("newCstmsFlg",newCstmsFlg);
					log.debug("--------------------- CT Case 1 Start -----------");
					focVO = this.sendEventCT(usCgoRlseBkbc,"CT1");
				log.debug("--------------------- CT Case 1 End -----------");
				log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
				 }

		else{
			log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			log.debug("전송 대상이 아닐 경우 THROW: The B/L you selected for Carriers' Release is not applicable to transmit.");
			log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

			//모두 해당 사항이 없을경우
			//전송 대상이 아닐 경우 : The B/L you selected for Carriers' Release is not applicable to transmit.
			if(inlndSnd.equals("N")){
			throw new EventException(new ErrorHandler("BKG40085").getMessage());
			}else{
				log.debug(">>>>>>>>>Inland Sent>>>>>>>>>");
			}
		 }

		}//Multi 전송이 아닌 경우


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

		//Multi BL 선택 후 TDC315 전송 시에 필요한 0909화면 grid에 있는 F O C 값 가져옴
		 tmpVO = dbDao.searchFocFlgForBlMultiSnd(usCgoRlseBkbc);
		 usCgoRlseBkbc.setCrntFrtCltFlg(tmpVO.getCrntFrtCltFlg());
		 usCgoRlseBkbc.setCrntOblRdemFlg(tmpVO.getCrntOblRdemFlg());
		 usCgoRlseBkbc.setCrntCstmsClrCd(tmpVO.getCrntCstmsClrCd());

		this.priLog("model No. Multisend", usCgoRlseBkbc);

		 //20151015 안진응 inlnd
		 tmpVO = dbDao.searchInlndYdInfo(usCgoRlseBkbc);
		 usCgoRlseBkbc.setInlndFullRlseEdiCd(tmpVO.getInlndFullRlseEdiCd());
		 usCgoRlseBkbc.setInlndCd(tmpVO.getInlndCd());
		this.priLog("inlnd info", usCgoRlseBkbc);

		tmpVO = dbDao.searchInlndEdiResult(usCgoRlseBkbc);
		 usCgoRlseBkbc.setInlndYdEdiSndCd(tmpVO.getInlndYdEdiSndCd());

		this.priLog("inlnd info", usCgoRlseBkbc);
		
		
		 //실제 세관에서 Download 시에 P/MIB (IPI movement)인지 Local 인지 값을 가져옴.
		 //#13489 NSA - BKG - TDC 315 not triggered when we get 1C and container is moving on rail 
		 tmpVO = dbDao.searchIpiMvmt(usCgoRlseBkbc);
		 usCgoRlseBkbc.setIpiMvmt(tmpVO.getIpiMvmt());
		this.priLog("model No. 3", usCgoRlseBkbc);

		return usCgoRlseBkbc;
	}

	/** Event1 CR_CASE 으로 분기
	 * @param usCgoRlseBkbc
	 * @return UsCgoRlseBkbcFocVO
	 * @exception DAOException
	 * @exception EventException
	 */
	private UsCgoRlseBkbcFocVO sendEventCR(UsCgoRlseBkbcBlVO usCgoRlseBkbc,String ediKnd)
			throws DAOException, EventException {
		UsCgoRlseBkbcFocVO focVO = new UsCgoRlseBkbcFocVO();
		//UsCgoRlseBkbcFocVO tmpFocVO = new UsCgoRlseBkbcFocVO();
		focVO.setBlNo(usCgoRlseBkbc.getBlNo());
		focVO.setEdiKnd(ediKnd);
		focVO.setHisSeq(usCgoRlseBkbc.getHisSeq());
		focVO.setCstmsDspoCd(usCgoRlseBkbc.getCstmsDspoCd());
		focVO.setPodCd(usCgoRlseBkbc.getPodCd());
		//20151015 안진응 inlnd
		focVO.setInlndCd("N");
		focVO.setInlndFullRlseEdiCd("");


		//Event_1 model No. 2
		focVO = this.searchEdiRcvSndIdCr(focVO);
		this.priLog("Event_1 model No. 2", focVO);

		//Event_1 model No. 5
		focVO = this.searchCustCode(focVO);
		log.debug("----------------- focVO.getBkgNo()   "+focVO.getBkgNo());
		if(focVO.getBkgNo() == null && "N".equals(focVO.getMultiSnd())){
			throw new EventException(new ErrorHandler("BKG40086").getMessage());
		}
		this.priLog("Event_1 model No. 5", focVO);

		//Event_1 model No. 6
		//ibd_bkg_ind,bkg_no,vsk_vvd_cd,VSL_CD,SKD_VOY_NO,SKD_DIR_CD
		//,pol_cd,pod_Cd,del_cd,edi_snp_snd_id,edi_snp_rcv_id,edi_add_ind
		focVO = this.searchIbdBkgInfo(focVO);
		this.priLog("Event_1 model No. 6", focVO);

		//Event_1 model No. 7
		//VPS_ETD_DT,VPS_ETD_DT_GMT....
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


	/** Event1 CR_CASE 으로 분기
	 * @param usCgoRlseBkbc
	 * @return UsCgoRlseBkbcFocVO
	 * @exception DAOException
	 * @exception EventException
	 */
	private UsCgoRlseBkbcFocVO sendEventInlndCR(UsCgoRlseBkbcBlVO usCgoRlseBkbc,String ediKnd)
			throws DAOException, EventException {
		UsCgoRlseBkbcFocVO focVO = new UsCgoRlseBkbcFocVO();
		//UsCgoRlseBkbcFocVO tmpFocVO = new UsCgoRlseBkbcFocVO();
		focVO.setBlNo(usCgoRlseBkbc.getBlNo());
		focVO.setEdiKnd(ediKnd);
		focVO.setHisSeq(usCgoRlseBkbc.getHisSeq());
		focVO.setCstmsDspoCd(usCgoRlseBkbc.getCstmsDspoCd());
		focVO.setPodCd(usCgoRlseBkbc.getPodCd());
		//20151015 안진응 inlnd
		focVO.setInlndCd(usCgoRlseBkbc.getInlndCd());
		focVO.setInlndFullRlseEdiCd(usCgoRlseBkbc.getInlndFullRlseEdiCd());


		//Event_1 model No. 2
		focVO = this.searchEdiRcvSndIdInlndCr(focVO);
		log.debug("================Inland transmit CR==============================" + focVO);

		//Event_1 model No. 5
		focVO = this.searchCustCode(focVO);
		log.debug("----------------- focVO.getBkgNo()   "+focVO.getBkgNo());
		if(focVO.getBkgNo() == null && "N".equals(focVO.getMultiSnd())){
			throw new EventException(new ErrorHandler("BKG40086").getMessage());
		}
		this.priLog("Event_1 model No. 5", focVO);

		//Event_1 model No. 6
		//ibd_bkg_ind,bkg_no,vsk_vvd_cd,VSL_CD,SKD_VOY_NO,SKD_DIR_CD
		//,pol_cd,pod_Cd,del_cd,edi_snp_snd_id,edi_snp_rcv_id,edi_add_ind
		focVO = this.searchIbdBkgInfo(focVO);
		this.priLog("Event_1 model No. 6", focVO);

		//Event_1 model No. 7
		//VPS_ETD_DT,VPS_ETD_DT_GMT....
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
		//20151015 안진응 inlnd
		focVO.setInlndCd("N");
		focVO.setInlndFullRlseEdiCd("");



		log.debug("~~~~~~~~~~~~~~ focVO.getHisSeq()   "+focVO.getHisSeq());

		//Event_1 model No. 3
		focVO = this.searchEdiRcvSndIdCa(focVO);
		this.priLog("Event_1 model No. 3", focVO);

		//Event_1 model No. 5
		focVO = this.searchCustCode(focVO);
		//log.debug("----------------- focVO.getBkgNo()   "+focVO.getBkgNo());
		if(focVO.getBkgNo() == null && "N".equals(focVO.getMultiSnd())){
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

	/** Event1 CA_CASE 으로 분기
	 * @param usCgoRlseBkbc
	 * @param String ediKnd
	 * @return UsCgoRlseBkbcFocVO
	 * @exception DAOException
	 * @exception EventException
	 */
	private UsCgoRlseBkbcFocVO sendEventInlndCA(UsCgoRlseBkbcBlVO usCgoRlseBkbc,String ediKnd)
			throws DAOException, EventException {
		UsCgoRlseBkbcFocVO focVO = new UsCgoRlseBkbcFocVO();
		//UsCgoRlseBkbcFocVO tmpFocVO = new UsCgoRlseBkbcFocVO();
		focVO.setBlNo(usCgoRlseBkbc.getBlNo());
		focVO.setEdiKnd(ediKnd);
		focVO.setHisSeq(usCgoRlseBkbc.getHisSeq());
		focVO.setPodCd(usCgoRlseBkbc.getPodCd());
		//20151015 안진응 inlnd
		focVO.setInlndCd(usCgoRlseBkbc.getInlndCd());
		focVO.setInlndFullRlseEdiCd(usCgoRlseBkbc.getInlndFullRlseEdiCd());



		log.debug("~~~~~~~~~~~~~~ focVO.getHisSeq()   "+focVO.getHisSeq());

		//Event_1 model No. 3
		focVO = this.searchEdiRcvSndIdInlndCa(focVO);
		log.debug("================Inland transmit CA==============================" + focVO);

		//Event_1 model No. 5
		focVO = this.searchCustCode(focVO);
		//log.debug("----------------- focVO.getBkgNo()   "+focVO.getBkgNo());
		if(focVO.getBkgNo() == null && "N".equals(focVO.getMultiSnd())){
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
		//20151015 안진응 inlnd
		focVO.setInlndCd("N");
		focVO.setInlndFullRlseEdiCd("");

		//Event_1 model No. 4
		focVO = this.searchEdiRcvSndIdHld(focVO);
		this.priLog("Event_1 model No. 4", focVO);

		//Event_1 model No. 5
		focVO = this.searchCustCode(focVO);
		log.debug("----------------- focVO.getBkgNo()   "+focVO.getBkgNo());
		if(focVO.getBkgNo() == null && "N".equals(focVO.getMultiSnd())){
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
	private UsCgoRlseBkbcFocVO sendEventInlndPA(UsCgoRlseBkbcBlVO usCgoRlseBkbc,String ediKnd)
			throws DAOException, EventException {
		UsCgoRlseBkbcFocVO focVO = new UsCgoRlseBkbcFocVO();
		//UsCgoRlseBkbcFocVO tmpFocVO = new UsCgoRlseBkbcFocVO();
		focVO.setBlNo(usCgoRlseBkbc.getBlNo());
		focVO.setEdiKnd(ediKnd);
		focVO.setHisSeq(usCgoRlseBkbc.getHisSeq());
		focVO.setPodCd(usCgoRlseBkbc.getPodCd());
		//20151015 안진응 inlnd
		focVO.setInlndCd(usCgoRlseBkbc.getInlndCd());
		focVO.setInlndFullRlseEdiCd(usCgoRlseBkbc.getInlndFullRlseEdiCd());

		//Event_1 model No. 4
		focVO = this.searchEdiRcvSndIdInlndHld(focVO);
		this.priLog("Event_1 model No. 4", focVO);

		//Event_1 model No. 5
		focVO = this.searchCustCode(focVO);
		log.debug("----------------- focVO.getBkgNo()   "+focVO.getBkgNo());
		if(focVO.getBkgNo() == null && "N".equals(focVO.getMultiSnd())){
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
//	/** Event1 PQ_CASE 으로 분기
//	 * @param usCgoRlseBkbc
//	 * @param String ediKnd
//	 * @return UsCgoRlseBkbcFocVO
//	 * @exception DAOException
//	 * @exception EventException
//	 */
//	private UsCgoRlseBkbcFocVO sendEventPQ(UsCgoRlseBkbcBlVO usCgoRlseBkbc,String ediKnd)
//			throws DAOException, EventException {
//		UsCgoRlseBkbcFocVO focVO = new UsCgoRlseBkbcFocVO();
//		//UsCgoRlseBkbcFocVO tmpFocVO = new UsCgoRlseBkbcFocVO();
//		focVO.setBlNo(usCgoRlseBkbc.getBlNo());
//		focVO.setHisSeq(usCgoRlseBkbc.getHisSeq());
//		focVO.setEdiKnd(ediKnd);
//		//20151015 안진응 inlnd
//		focVO.setInlndCd(usCgoRlseBkbc.getInlndCd());
//		focVO.setInlndFullRlseEdiCd(usCgoRlseBkbc.getInlndFullRlseEdiCd());
//
//		//Event_1 model No. 3
//		focVO = this.searchEdiRcvSndIdCa(focVO);
//		this.priLog("Event_1 model No. 3", focVO);
//
//		//Event_1 model No. 5
//		focVO = this.searchCustCode(focVO);
//		//log.debug("----------------- focVO.getBkgNo()   "+focVO.getBkgNo());
//		if(focVO.getBkgNo() == null && "N".equals(focVO.getMultiSnd())){
//			throw new EventException(new ErrorHandler("BKG40086").getMessage());
//		}
//		this.priLog("Event_1 model No. 5", focVO);
//
//		//Event_1 model No. 6
//		focVO = this.searchIbdBkgInfo(focVO);
//		this.priLog("Event_1 model No. 6", focVO);
//
//		//Event_1 model No. 7
//		focVO = this.searchVskInfo(focVO);
//		this.priLog("Event_1 model No. 7", focVO);
//
//		//Event_1 model No. 9
//		focVO = this.searchOldNewFocFlg(focVO);
//		this.priLog("Event_1 model No. 9", focVO);
//
//		//Event_1 model No. 12
//		focVO = this.searchPoLocSlan(focVO);
//		this.priLog("Event_1 model No. 12", focVO);
//
//		//세관데이터가 있는 경우 { ibdBkgInd = 'I' }
//		String ibdBkgInd = focVO.getIbdBkgInd();
//
//		//Event_1 model No. 17
//		this.sendFlatFile(focVO,ibdBkgInd);
//		this.priLog("Event_1 model No. 17", focVO);
//
//		return focVO;
//	}

	/** Event1 CT_CASE 으로 분기
	 * @param usCgoRlseBkbc
	 * @return UsCgoRlseBkbcFocVO
	 * @exception DAOException
	 * @exception EventException
	 */
	private UsCgoRlseBkbcFocVO sendEventCT(UsCgoRlseBkbcBlVO usCgoRlseBkbc,String ediKnd)
			throws DAOException, EventException {
		UsCgoRlseBkbcFocVO focVO = new UsCgoRlseBkbcFocVO();
		focVO.setBlNo(usCgoRlseBkbc.getBlNo());
		focVO.setEdiKnd(ediKnd);
		focVO.setHisSeq(usCgoRlseBkbc.getHisSeq());
		focVO.setCstmsDspoCd(usCgoRlseBkbc.getCstmsDspoCd());
		focVO.setPodCd(usCgoRlseBkbc.getPodCd());
		//20151015 안진응 inlnd
		focVO.setInlndCd("N");
		focVO.setInlndFullRlseEdiCd("");


		//Event_1 model No. 2
		focVO = this.searchEdiRcvSndIdCt(focVO);
		this.priLog("Add CT Event_1 model No. 2", focVO);

		//Event_1 model No. 5
		focVO = this.searchCustCode(focVO);
		log.debug("----------------- focVO.getBkgNo()   "+focVO.getBkgNo());
		if(focVO.getBkgNo() == null && "N".equals(focVO.getMultiSnd())){
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

	/** Event1 CT_CASE 으로 분기
	 * @param usCgoRlseBkbc
	 * @return UsCgoRlseBkbcFocVO
	 * @exception DAOException
	 * @exception EventException
	 */
	private UsCgoRlseBkbcFocVO sendEventInlndCT(UsCgoRlseBkbcBlVO usCgoRlseBkbc,String ediKnd)
			throws DAOException, EventException {
		UsCgoRlseBkbcFocVO focVO = new UsCgoRlseBkbcFocVO();
		focVO.setBlNo(usCgoRlseBkbc.getBlNo());
		focVO.setEdiKnd(ediKnd);
		focVO.setHisSeq(usCgoRlseBkbc.getHisSeq());
		focVO.setCstmsDspoCd(usCgoRlseBkbc.getCstmsDspoCd());
		focVO.setPodCd(usCgoRlseBkbc.getPodCd());
		//20151015 안진응 inlnd
		focVO.setInlndCd(usCgoRlseBkbc.getInlndCd());
		focVO.setInlndFullRlseEdiCd(usCgoRlseBkbc.getInlndFullRlseEdiCd());


		//Event_1 model No. 2
		focVO = this.searchEdiRcvSndIdInlndCt(focVO);
		log.debug("================Inland transmit CT==============================" + focVO);

		//Event_1 model No. 5
		focVO = this.searchCustCode(focVO);
		log.debug("----------------- focVO.getBkgNo()   "+focVO.getBkgNo());
		if(focVO.getBkgNo() == null && "N".equals(focVO.getMultiSnd())){
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
	private UsCgoRlseBkbcFocVO sendFlatFile(UsCgoRlseBkbcFocVO focVO, String flg) throws EventException, DAOException {
		//Event_1 model No. 14
		List<UsCgoRlseBkbcFlatFileVO> flatFileVOs = new ArrayList<UsCgoRlseBkbcFlatFileVO>();

		if(focVO.getEdiSndId() != null
				&& !focVO.getEdiSndId().trim().equals("")
				&& focVO.getEdiRcvId() != null
				&& !focVO.getEdiRcvId().trim().equals("")){


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

		for(int i=0;i<flatFileVOs.size();i++){
			UsCgoRlseBkbcFlatFileVO flatFileVO = flatFileVOs.get(i);
			flatFileVO.getSnpFileHeader();

			flatFile.append(flatFileVO.getFlatFileHeader());
			flatFile.append(flatFileVO.getFlatFileBody());
			flatFile.append(flatFileVvd);

			ediSnpRtnVal = this.comSendFlatFile(focVO, flatFile);//Flat File 전송후 리턴되는 결과값
			focVO.setEdiSnpRtnVal(ediSnpRtnVal);
			//Model No. 27
			focVO.setEdiRcvId(focVO.getEdiRcvId());
			focVO.setEdiSndId(focVO.getEdiSndId());
			this.priLog("model No. 27", focVO);
			log.debug("-------------- focVO "+ focVO.getColumnValues());
			if((!focVO.getInlndCd().equals("Y"))){
				dbDao.addUsCgoRlsLogRslt(focVO, this.account);
			}

			flatFile = new StringBuffer();
		}

		if((!focVO.getInlndCd().equals("Y"))){
	   //-----------------------------------------------------------------------------
	   //SND Flat File 전송
	   //-----------------------------------------------------------------------------
	   String snpEdiAddInd = focVO.getEdiAddInd();
	   //log.debug("~~~~~~~~~~~~~~~~~~~ snpEdiAddInd "+ snpEdiAddInd);
	   if(snpEdiAddInd.equals("Y")){
		for(int i=0;i<flatFileVOs.size();i++){
			UsCgoRlseBkbcFlatFileVO flatFileVO = flatFileVOs.get(i);
			flatFileVO.getSnpFileHeader();

			flatFile.append(flatFileVO.getSnpFileHeader());
			flatFile.append(flatFileVO.getFlatFileBody());
			flatFile.append(flatFileVvd);
			if(i == 0 ){
				break;
			}
		}
		ediSnpRtnVal = this.comSendFlatFile(focVO, flatFile);//Flat File 전송후 리턴되는 결과값

				//Model No. 29
		focVO.setEdiSnpRtnVal(ediSnpRtnVal);
		focVO.setEdiRcvId(focVO.getEdiSnpRcvId());
		focVO.setEdiSndId(focVO.getEdiSnpSndId());
		this.priLog("model No. 29", focVO);
		log.debug("-------------- focVO "+ focVO.getColumnValues());
		   dbDao.addUsCgoRlsLogRslt(focVO, this.account);
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

		}else{ //inland 전송 history 관리
			log.debug(">>>>>>>>>>>>>Inland Hitory start>>>>>>>>>>>");
			//Model No. 32  BKG_CGO_RLSE_HIS 테이블에 Inland 전송시에 update 됨
			dbDao.modifyUsCgoRlsInlndHisRslt(focVO,this.account);
			this.priLog("model No. 32", focVO);
			log.debug("-------------- focVO "+ focVO.getColumnValues());
			//Model No. 33 BKG_CGO_RLSE 테이블에 Inland 전송시에 update 됨

			dbDao.modifyUsCgoRlsInlndRslt(focVO, this.account);
			this.priLog("model No. 33", focVO);
			log.debug("-------------- focVO "+ focVO.getColumnValues());


		}
	}
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
	   sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_CUSTOMER.IBMMQ.QUEUE"));
	   BookingUtil command = new BookingUtil();

	   FlatFileAckVO flatFileAckVO = new FlatFileAckVO();
	   flatFileAckVO = command.sendFlatFile(sendFlatFileVO);

	   //EDI ERROR 발생 시
	   if ( flatFileAckVO.getAckStsCd().equals("E") && "N".equals(focVO.getMultiSnd())){
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
//			retVvd = retVvd + flatFileVO.get(i).getFlatFileVvd();
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

		// Send ID, Receive ID의 값이 둘다 있어야지 실행됨.
		if(focVO.getEdiSndId() == null
				|| focVO.getEdiSndId().trim().equals("")
				|| focVO.getEdiRcvId() == null
				|| focVO.getEdiRcvId().trim().equals("")
			){
			//전송 대상이 아닐 경우 : The B/L you selected for Carriers' Release is not applicable to transmit.
			if( "N".equals(focVO.getMultiSnd())){
			throw new EventException(new ErrorHandler("BKG40085").getMessage());
			}
		}

	   String referenceNumber;
		try {
			referenceNumber = ReferenceNumberGeneratorBroker.getKey("BKG","BKG_EDI_SEQ");
			focVO.setRefNumber(referenceNumber);
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
		}

		if(flg.equals("I")){
			flatFileVO = dbDao.searchCstmsMkFile(focVO);
		}else if(flg.equals("B")){
			flatFileVO = dbDao.searchBkgMkFile(focVO);
		}else{
			//The B/L you selected for Carriers' Release doesn't have sufficient data to transmit
			if( "N".equals(focVO.getMultiSnd())){
			throw new EventException(new ErrorHandler("BKG40086").getMessage());
			}
		}
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
		tmpFocVO = dbDao.searchPoLocSlan(focVO, this.account);

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

		return focVO;
	}

	/**
	 * Event_1 model No. 2
	 * @param focVO
	 * @return UsCgoRlseBkbcFocVO
	 * @exception DAOException
	 */
	private UsCgoRlseBkbcFocVO searchEdiRcvSndIdInlndCr(UsCgoRlseBkbcFocVO focVO)
			throws DAOException {
		UsCgoRlseBkbcFocVO tmpFocVO;
		tmpFocVO = dbDao.searchEdiRcvSndIdInlndCr(focVO);
		focVO.setEdiMsgId(tmpFocVO.getEdiMsgId());
		focVO.setEdiRcvId(tmpFocVO.getEdiRcvId());
		focVO.setEdiSndId(tmpFocVO.getEdiSndId());

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

		return focVO;
	}

	/**
	 * Event_1 model No. 3
	 * @param focVO
	 * @return UsCgoRlseBkbcFocVO
	 * @exception DAOException
	 */
	private UsCgoRlseBkbcFocVO searchEdiRcvSndIdInlndCa(UsCgoRlseBkbcFocVO focVO)
			throws DAOException {
		UsCgoRlseBkbcFocVO tmpFocVO;
		tmpFocVO = dbDao.searchEdiRcvSndIdInlndCa(focVO);
		focVO.setEdiMsgId(tmpFocVO.getEdiMsgId());
		focVO.setEdiRcvId(tmpFocVO.getEdiRcvId());
		focVO.setEdiSndId(tmpFocVO.getEdiSndId());

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


		return focVO;
	}

	/**
	 * Event_1 model No. 4
	 * @param focVO
	 * @return UsCgoRlseBkbcFocVO
	 * @exception DAOException
	 */
	private UsCgoRlseBkbcFocVO searchEdiRcvSndIdInlndHld(UsCgoRlseBkbcFocVO focVO)
			throws DAOException {
		UsCgoRlseBkbcFocVO tmpFocVO;
		tmpFocVO = dbDao.searchEdiRcvSndIdInlndHld(focVO);
		focVO.setEdiMsgId(tmpFocVO.getEdiMsgId());
		focVO.setEdiRcvId(tmpFocVO.getEdiRcvId());
		focVO.setEdiSndId(tmpFocVO.getEdiSndId());


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

		return focVO;
	}

	/**
	 * Add CT Event_1 model No. 2
	 * @param focVO
	 * @return UsCgoRlseBkbcFocVO
	 * @exception DAOException
	 */
	private UsCgoRlseBkbcFocVO searchEdiRcvSndIdInlndCt(UsCgoRlseBkbcFocVO focVO)
			throws DAOException {
		UsCgoRlseBkbcFocVO tmpFocVO;
		tmpFocVO = dbDao.searchEdiRcvSndIdInlndCt(focVO);
		focVO.setEdiMsgId(tmpFocVO.getEdiMsgId());
		focVO.setEdiRcvId(tmpFocVO.getEdiRcvId());
		focVO.setEdiSndId(tmpFocVO.getEdiSndId());

		return focVO;
	}
	/**
	 * 로컬만 사용되는 로그
	 * @param obj
	 */
	@SuppressWarnings("rawtypes")
	private void priLog(String name, AbstractValueObject obj){
		log.debug("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
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
}