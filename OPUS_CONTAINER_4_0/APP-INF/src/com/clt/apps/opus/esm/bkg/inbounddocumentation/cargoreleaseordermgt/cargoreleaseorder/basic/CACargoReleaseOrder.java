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
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.CaCgoRlseBkbcBlVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.CaCgoRlseBkbcFlatFileVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.CaCgoRlseBkbcFocVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.CaCgoRlseListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.CaCgoRlseSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.CaCgoRlseSndIdVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseBkbcBlVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseBkbcFocVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseBkbcSceVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 *   CargoReleaseOrderMgt Business Logic Basic Command implementation<br>
 * - CargoReleaseOrderMgt 대한 비지니스 로직을 처리한다.<br>
 *
 * @author
 * @see ESM_BKG_1001EventResponse,FullReleaseOrderBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class CACargoReleaseOrder extends BasicCommandSupport {

	private transient CargoReleaseOrderDBDAO dbDao = new CargoReleaseOrderDBDAO();

	/**
	 * ESM_BKG_1167 Partial 정보가져오기
	 *
	 * @param String blNo
	 * @param String multiSnd
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void caCgoRlse(String blNo, String multiSnd, SignOnUserAccount account) throws Exception {

		CaCgoRlseSearchVO searchVo = new CaCgoRlseSearchVO();
		CaCgoRlseBkbcFocVO caCgoRlseBkbcFocVO = new CaCgoRlseBkbcFocVO();
		CaCgoRlseBkbcFocVO tmpCaCgoRlseBkbcFocVO = new CaCgoRlseBkbcFocVO();
		CaCgoRlseBkbcFocVO tmpCaCgoPoLocSlanVO = new CaCgoRlseBkbcFocVO();
		CaCgoRlseBkbcBlVO caCgoFocBlVO = new CaCgoRlseBkbcBlVO();
		List<CaCgoRlseBkbcFlatFileVO> flatFileVOs = new ArrayList<CaCgoRlseBkbcFlatFileVO>();
		List<CaCgoRlseBkbcFlatFileVO> flatFileVvdVO;
		searchVo.setBlNo(blNo);
		
		
		//SCE에 EDI 발생정보전송   Canada 도 customer 315 추가 #14498 [NBSA - EDI] Carrier Release not triggered
		UsCgoRlseBkbcFocVO focVO = new UsCgoRlseBkbcFocVO();

		//SCE 로 EDI를 보내기 위함.
		log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		log.debug("--------------------- SCE Start -----------");
		long startTime1 = System.currentTimeMillis();
		UsCgoRlseBkbcBlVO usCgoRlseBkbc = new UsCgoRlseBkbcBlVO();
		
		usCgoRlseBkbc.setBlNo(blNo);
		
		UsCgoRlseBkbcBlVO tmpVO = dbDao.searchCrEdiResult(usCgoRlseBkbc);
		
		 usCgoRlseBkbc.setHisSeq(tmpVO.getHisSeq());
		
		UsCgoRlseBkbcSceVO sceVO = dbDao.searchSceMsgIdCntForCa(usCgoRlseBkbc);
		Edi315SendBC bc = new Edi315SendBCImpl();
		
		focVO.setBlNo(usCgoRlseBkbc.getBlNo());
		focVO.setHisSeq(usCgoRlseBkbc.getHisSeq());

		if(sceVO == null ){
			sceVO = new UsCgoRlseBkbcSceVO();
		}
		

		long startTime2 = System.currentTimeMillis();
		log.debug("--------------- startTime2 - startTime1 " + ((startTime2-startTime1)/1000));
		try{ 
			//Model No. 20 ~ 28
			this.priLog("model No. 20 ~ 28", sceVO);

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
				dbDao.addUsCgoRlsLogSceRslt(focVO,account);
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
				dbDao.addUsCgoRlsLogSceRslt(focVO,account);
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
				dbDao.addUsCgoRlsLogSceRslt(focVO,account);
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
			dbDao.modifyUsCgoRlsHisSceRslt(focVO,account);



			log.debug("--------------------- SCE End -----------");
			log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
			
		
		
		
		try {
			List<CaCgoRlseListVO> list = dbDao.searchCaCgoRlseList(searchVo);

			if(list == null || list.size() == 0){
				//전송 대상이 아닐 경우 : The B/L you selected for Carriers' Release is not applicable to transmit.
				throw new EventException(new ErrorHandler("BKG40085").getMessage());
			}

			CaCgoRlseListVO caCgoRlseListVO = (CaCgoRlseListVO)list.get(0);
			// 1건만 비교한다.
			if("Y".equals(caCgoRlseListVO.getDoHldFlg()) && "N".equals(multiSnd)){
				//전송 대상이 아닐 경우 : The B/L you selected for Carriers' Release is not applicable to transmit.
				throw new EventException(new ErrorHandler("BKG40085").getMessage());
			}

			CaCgoRlseSndIdVO caCgoRlseSndIdVO = new CaCgoRlseSndIdVO();

			caCgoRlseSndIdVO = dbDao.searchCaCgoSndId(searchVo);

			log.debug("caCgoRlseSndIdVO.getEdiSndId() : " + caCgoRlseSndIdVO.getEdiSndId());
			log.debug("caCgoRlseSndIdVO.getEdiRcvId() : " + caCgoRlseSndIdVO.getEdiRcvId());
			log.debug("caCgoRlseSndIdVO.getMsgTp() : " + caCgoRlseSndIdVO.getMsgTp());

			// Send ID, Receive ID의 값이 둘다 있어야지 실행됨.
			if(caCgoRlseSndIdVO.getEdiSndId() == null || "".equals(caCgoRlseSndIdVO.getEdiSndId())||
			   caCgoRlseSndIdVO.getEdiRcvId() == null || "".equals(caCgoRlseSndIdVO.getEdiRcvId())||
			   caCgoRlseSndIdVO.getMsgTp() == null || "".equals(caCgoRlseSndIdVO.getMsgTp())|| "0".equals(caCgoRlseSndIdVO.getMsgTp())){
			   if("N".equals(multiSnd)){ //Multi send 아닐 때만
				// 전송 대상이 아닐경우 : The B/L you selected for Carriers' Release is not applicable to transmit.
			   throw new EventException(new ErrorHandler("BKG40085").getMessage());
			   }
			}


//				caCgoRlseSndIdVO 에서 MSG_TP 에 에 따라 미주, 캐나다 I/B Cargo release 를 진행 한다.
//				0:Blank
//				1:FO
//				2:FOC
//				3:FOCD
//				9:Others"	"F:freight (운임징수 확인: Y)
//				O:OBL(OBL 회수  확인: Y)
//				C:Customs (통관절차 확인:Y)
//				D:Demmurgae(DEM 징수 확인:Y)
			//F/O 확인
			caCgoFocBlVO = dbDao.searchCaFocFlg(searchVo);

			if(("Y".equals(caCgoFocBlVO.getNewFrtCltFlg()) && "Y".equals(caCgoFocBlVO.getNewOblRdemFlg())) && "1".equals(caCgoRlseSndIdVO.getMsgTp())||"2".equals(caCgoRlseSndIdVO.getMsgTp())||"3".equals(caCgoRlseSndIdVO.getMsgTp())){
				// CaCgoRlseBkbcFlatFileVO 에 대한 Set up
				caCgoRlseBkbcFocVO = dbDao.searchCaCgoBkgInfo(caCgoRlseListVO);
				caCgoRlseBkbcFocVO.setEdiSndId(caCgoRlseSndIdVO.getEdiSndId());
				caCgoRlseBkbcFocVO.setEdiRcvId(caCgoRlseSndIdVO.getEdiRcvId());

				tmpCaCgoRlseBkbcFocVO = dbDao.searchCaCgoVskInfo(caCgoRlseBkbcFocVO);
				caCgoRlseBkbcFocVO.setVpsEtdDt(tmpCaCgoRlseBkbcFocVO.getVpsEtdDt());
				caCgoRlseBkbcFocVO.setVpsEtdDtGmt(tmpCaCgoRlseBkbcFocVO.getVpsEtdDtGmt());
				caCgoRlseBkbcFocVO.setInitEtdDt(tmpCaCgoRlseBkbcFocVO.getInitEtdDt());
				caCgoRlseBkbcFocVO.setInitEtdDtGmt(tmpCaCgoRlseBkbcFocVO.getInitEtdDtGmt());
				caCgoRlseBkbcFocVO.setVpsEtaDt(tmpCaCgoRlseBkbcFocVO.getVpsEtaDt());
				caCgoRlseBkbcFocVO.setVpsEtaDtGmt(tmpCaCgoRlseBkbcFocVO.getVpsEtaDtGmt());
				caCgoRlseBkbcFocVO.setInitEtaDt(tmpCaCgoRlseBkbcFocVO.getInitEtaDt());
				caCgoRlseBkbcFocVO.setInitEtaDtGmt(tmpCaCgoRlseBkbcFocVO.getInitEtaDtGmt());
				caCgoRlseBkbcFocVO.setFinalEtaDt(tmpCaCgoRlseBkbcFocVO.getFinalEtaDt());
				caCgoRlseBkbcFocVO.setFinalEtaDtGmt(tmpCaCgoRlseBkbcFocVO.getFinalEtaDtGmt());
				//EDI Kind 를 CR 로 셋팅
				caCgoRlseBkbcFocVO.setEdiKnd("CR");

				tmpCaCgoPoLocSlanVO = dbDao.searchCaCgoPoLocSlan(caCgoRlseBkbcFocVO, account);

				caCgoRlseBkbcFocVO.setPoNo(tmpCaCgoPoLocSlanVO.getPoNo());
				caCgoRlseBkbcFocVO.setLocCd(tmpCaCgoPoLocSlanVO.getLocCd());
				caCgoRlseBkbcFocVO.setVslSlanNm(tmpCaCgoPoLocSlanVO.getVslSlanNm());
				caCgoRlseBkbcFocVO.setBlNo(blNo);
				CaCgoRlseBkbcBlVO caCgoRlseBkbcBlVO = new CaCgoRlseBkbcBlVO();
				caCgoRlseBkbcBlVO = dbDao.searchCaCrEdiResult(caCgoRlseBkbcFocVO);
				caCgoRlseBkbcFocVO.setHisSeq(caCgoRlseBkbcBlVO.getHisSeq());


				this.priLog("model  CR", caCgoRlseBkbcFocVO);

				String BlCntrInd = "";
				BlCntrInd = dbDao.searchCaCgoBlCntrInd(caCgoRlseBkbcFocVO);
				caCgoRlseBkbcFocVO.setEdiBlCntrInd(BlCntrInd);

				// search Canada Flat File
				flatFileVOs = dbDao.searchCaCgoMkFile(caCgoRlseBkbcFocVO);

				flatFileVvdVO = dbDao.searchCaCgoVvdMkFile(caCgoRlseBkbcFocVO);
				String retVvd = "";

				for(int i=0;i<flatFileVvdVO.size();i++){
					StringBuffer tmpBuffer = new StringBuffer(retVvd).append(flatFileVvdVO.get(i).getFlatFileVvd());
					retVvd = tmpBuffer.toString();
				}

				StringBuffer flatFile = new StringBuffer();
				String ediSnpRtnVal = "";



				BookingUtil command = new BookingUtil();


				for(int i=0;i<flatFileVOs.size();i++){
					CaCgoRlseBkbcFlatFileVO flatFileVO = flatFileVOs.get(i);
					flatFileVO.getSnpFileHeader();
					flatFile.append(flatFileVO.getFlatFileHeader());
					flatFile.append(flatFileVO.getFlatFileBody());
					flatFile.append(retVvd);

					SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();

					sendFlatFileVO.setFlatFile(flatFile.toString());
					sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_CUSTOMER.IBMMQ.QUEUE"));

					FlatFileAckVO flatFileAckVO = command.sendFlatFile(sendFlatFileVO);

					if ( flatFileAckVO.getAckStsCd().equals("E") && "N".equals(multiSnd)){
						throw new EventException(new ErrorHandler("BKG40087").getMessage());
					}
					if(null != flatFileAckVO.getAckStsCd()){
						ediSnpRtnVal = flatFileAckVO.getAckStsCd();
					}
					caCgoRlseBkbcFocVO.setEdiSnpRtnVal(ediSnpRtnVal);
					//Canada Cargo Release EDI Sent 내역을 저장
					dbDao.addCaCgoRlsLogRslt(caCgoRlseBkbcFocVO,account);
					ediSnpRtnVal = "";
					if(!"".equalsIgnoreCase(flatFileVO.getDupFlatFileHeader())){
						flatFile = new StringBuffer();

						flatFile.append(flatFileVO.getDupFlatFileHeader());
						flatFile.append(flatFileVO.getFlatFileBody());
						flatFile.append(flatFileVvdVO);

						SendFlatFileVO dupSendFlatFileVO = new SendFlatFileVO();
						dupSendFlatFileVO.setFlatFile(flatFile.toString());
						dupSendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_CUSTOMER.IBMMQ.QUEUE"));

						FlatFileAckVO dupflatFileAckVO = command.sendFlatFile(dupSendFlatFileVO);

						if ( dupflatFileAckVO.getAckStsCd().equals("E") && "N".equals(multiSnd)){
							throw new EventException(new ErrorHandler("BKG40087").getMessage());
						}
						if(null != dupflatFileAckVO.getAckStsCd()){
							ediSnpRtnVal = dupflatFileAckVO.getAckStsCd();
						}
						caCgoRlseBkbcFocVO.setEdiSnpRtnVal(ediSnpRtnVal);
						//Canada Cargo Release EDI Sent 내역을 저장
						dbDao.addCaCgoRlsLogRslt(caCgoRlseBkbcFocVO,account);
					}
				}
				//Canada Cargo Release History 내역을 저장
				dbDao.modifyCaCgoRlsHisRslt(caCgoRlseBkbcFocVO,account);
				//Canada Cargo Release 내역을 저장
				dbDao.modifyCaCgoRlsRslt(caCgoRlseBkbcFocVO,account);
			}

			CaCgoRlseBkbcBlVO caCgoRlseSndFlgVO = new CaCgoRlseBkbcBlVO();
			caCgoRlseBkbcFocVO.setBlNo(blNo);
			caCgoRlseSndFlgVO = dbDao.searchCaCrEdiResult(caCgoRlseBkbcFocVO);

			if(("N".equals(multiSnd)) && (null != caCgoRlseSndFlgVO.getCgorEdiSndCd() && "R".equals(caCgoRlseSndFlgVO.getCgorEdiSndCd())) && (!"Y".equals(caCgoFocBlVO.getNewFrtCltFlg()) || !"Y".equals(caCgoFocBlVO.getNewOblRdemFlg()))){
				// CaCgoRlseBkbcFlatFileVO 에 대한 Set up
				caCgoRlseBkbcFocVO = dbDao.searchCaCgoBkgInfo(caCgoRlseListVO);
				caCgoRlseBkbcFocVO.setEdiSndId(caCgoRlseSndIdVO.getEdiSndId());
				caCgoRlseBkbcFocVO.setEdiRcvId(caCgoRlseSndIdVO.getEdiRcvId());

				tmpCaCgoRlseBkbcFocVO = dbDao.searchCaCgoVskInfo(caCgoRlseBkbcFocVO);
				caCgoRlseBkbcFocVO.setVpsEtdDt(tmpCaCgoRlseBkbcFocVO.getVpsEtdDt());
				caCgoRlseBkbcFocVO.setVpsEtdDtGmt(tmpCaCgoRlseBkbcFocVO.getVpsEtdDtGmt());
				caCgoRlseBkbcFocVO.setInitEtdDt(tmpCaCgoRlseBkbcFocVO.getInitEtdDt());
				caCgoRlseBkbcFocVO.setInitEtdDtGmt(tmpCaCgoRlseBkbcFocVO.getInitEtdDtGmt());
				caCgoRlseBkbcFocVO.setVpsEtaDt(tmpCaCgoRlseBkbcFocVO.getVpsEtaDt());
				caCgoRlseBkbcFocVO.setVpsEtaDtGmt(tmpCaCgoRlseBkbcFocVO.getVpsEtaDtGmt());
				caCgoRlseBkbcFocVO.setInitEtaDt(tmpCaCgoRlseBkbcFocVO.getInitEtaDt());
				caCgoRlseBkbcFocVO.setInitEtaDtGmt(tmpCaCgoRlseBkbcFocVO.getInitEtaDtGmt());
				caCgoRlseBkbcFocVO.setFinalEtaDt(tmpCaCgoRlseBkbcFocVO.getFinalEtaDt());
				caCgoRlseBkbcFocVO.setFinalEtaDtGmt(tmpCaCgoRlseBkbcFocVO.getFinalEtaDtGmt());
				//EDI Kind 를 CR 로 셋팅
				caCgoRlseBkbcFocVO.setEdiKnd("CA");

				tmpCaCgoPoLocSlanVO = dbDao.searchCaCgoPoLocSlan(caCgoRlseBkbcFocVO, account);

				caCgoRlseBkbcFocVO.setPoNo(tmpCaCgoPoLocSlanVO.getPoNo());
				caCgoRlseBkbcFocVO.setLocCd(tmpCaCgoPoLocSlanVO.getLocCd());
				caCgoRlseBkbcFocVO.setVslSlanNm(tmpCaCgoPoLocSlanVO.getVslSlanNm());
				caCgoRlseBkbcFocVO.setBlNo(blNo);
				CaCgoRlseBkbcBlVO caCgoRlseBkbcBlVO = new CaCgoRlseBkbcBlVO();
				caCgoRlseBkbcBlVO = dbDao.searchCaCrEdiResult(caCgoRlseBkbcFocVO);
				caCgoRlseBkbcFocVO.setHisSeq(caCgoRlseBkbcBlVO.getHisSeq());

				String BlCntrInd = "";
				BlCntrInd = dbDao.searchCaCgoBlCntrInd(caCgoRlseBkbcFocVO);
				caCgoRlseBkbcFocVO.setEdiBlCntrInd(BlCntrInd);

				this.priLog("model  CA", caCgoRlseBkbcFocVO);

				// search Canada Flat File
				flatFileVOs = dbDao.searchCaCgoMkFile(caCgoRlseBkbcFocVO);

				flatFileVvdVO = dbDao.searchCaCgoVvdMkFile(caCgoRlseBkbcFocVO);
//					String flatFileVvd = this.searchMkVvdFile(focVO);
				String retVvd = "";

				for(int i=0;i<flatFileVvdVO.size();i++){
					StringBuffer tmpBuffer = new StringBuffer(retVvd).append(flatFileVvdVO.get(i).getFlatFileVvd());
					retVvd = tmpBuffer.toString();
				}

				StringBuffer flatFile = new StringBuffer();
				String ediSnpRtnVal = "";

				BookingUtil command = new BookingUtil();

				for(int i=0;i<flatFileVOs.size();i++){
					CaCgoRlseBkbcFlatFileVO flatFileVO = flatFileVOs.get(i);
					flatFileVO.getSnpFileHeader();
					flatFile.append(flatFileVO.getFlatFileHeader());
					flatFile.append(flatFileVO.getFlatFileBody());
					flatFile.append(retVvd);

					SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();

					sendFlatFileVO.setFlatFile(flatFile.toString());
					sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_CUSTOMER.IBMMQ.QUEUE"));

					FlatFileAckVO flatFileAckVO = command.sendFlatFile(sendFlatFileVO);

					if ( flatFileAckVO.getAckStsCd().equals("E") && "N".equals(multiSnd)){
						throw new EventException(new ErrorHandler("BKG40087").getMessage());
					}
					if(null != flatFileAckVO.getAckStsCd()){
						ediSnpRtnVal = flatFileAckVO.getAckStsCd();
					}
					caCgoRlseBkbcFocVO.setEdiSnpRtnVal(ediSnpRtnVal);
					//Canada Cargo Release EDI Sent 내역을 저장
					dbDao.addCaCgoRlsLogRslt(caCgoRlseBkbcFocVO,account);
					ediSnpRtnVal = "";
					if(!"".equalsIgnoreCase(flatFileVO.getDupFlatFileHeader())){
						flatFile = new StringBuffer();

						flatFile.append(flatFileVO.getDupFlatFileHeader());
						flatFile.append(flatFileVO.getFlatFileBody());
						flatFile.append(flatFileVvdVO);

						SendFlatFileVO dupSendFlatFileVO = new SendFlatFileVO();
						dupSendFlatFileVO.setFlatFile(flatFile.toString());
						dupSendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_CUSTOMER.IBMMQ.QUEUE"));

						FlatFileAckVO dupflatFileAckVO = command.sendFlatFile(dupSendFlatFileVO);

						if ( dupflatFileAckVO.getAckStsCd().equals("E") && "N".equals(multiSnd)){
							throw new EventException(new ErrorHandler("BKG40087").getMessage());
						}
						if(null != dupflatFileAckVO.getAckStsCd()){
							ediSnpRtnVal = dupflatFileAckVO.getAckStsCd();
						}
						caCgoRlseBkbcFocVO.setEdiSnpRtnVal(ediSnpRtnVal);
						//Canada Cargo Release EDI Sent 내역을 저장
						dbDao.addCaCgoRlsLogRslt(caCgoRlseBkbcFocVO,account);
					}
				}
				//Canada Cargo Release History 내역을 저장
				dbDao.modifyCaCgoRlsHisRslt(caCgoRlseBkbcFocVO,account);
				//Canada Cargo Release 내역을 저장
				dbDao.modifyCaCgoRlsRslt(caCgoRlseBkbcFocVO,account);

		   //multi 전송시 CA (cancel) 전송은 그 전에 나간 EDI 값이 Release인지 아닌지는 체크하지 않고 나감.

			}else if(("Y".equals(multiSnd)) && (!"".equals(caCgoRlseSndFlgVO.getCgorEdiSndCd())) && (!"Y".equals(caCgoFocBlVO.getNewFrtCltFlg()) || !"Y".equals(caCgoFocBlVO.getNewOblRdemFlg()))){

				// CaCgoRlseBkbcFlatFileVO 에 대한 Set up
				caCgoRlseBkbcFocVO = dbDao.searchCaCgoBkgInfo(caCgoRlseListVO);
				caCgoRlseBkbcFocVO.setEdiSndId(caCgoRlseSndIdVO.getEdiSndId());
				caCgoRlseBkbcFocVO.setEdiRcvId(caCgoRlseSndIdVO.getEdiRcvId());

				tmpCaCgoRlseBkbcFocVO = dbDao.searchCaCgoVskInfo(caCgoRlseBkbcFocVO);
				caCgoRlseBkbcFocVO.setVpsEtdDt(tmpCaCgoRlseBkbcFocVO.getVpsEtdDt());
				caCgoRlseBkbcFocVO.setVpsEtdDtGmt(tmpCaCgoRlseBkbcFocVO.getVpsEtdDtGmt());
				caCgoRlseBkbcFocVO.setInitEtdDt(tmpCaCgoRlseBkbcFocVO.getInitEtdDt());
				caCgoRlseBkbcFocVO.setInitEtdDtGmt(tmpCaCgoRlseBkbcFocVO.getInitEtdDtGmt());
				caCgoRlseBkbcFocVO.setVpsEtaDt(tmpCaCgoRlseBkbcFocVO.getVpsEtaDt());
				caCgoRlseBkbcFocVO.setVpsEtaDtGmt(tmpCaCgoRlseBkbcFocVO.getVpsEtaDtGmt());
				caCgoRlseBkbcFocVO.setInitEtaDt(tmpCaCgoRlseBkbcFocVO.getInitEtaDt());
				caCgoRlseBkbcFocVO.setInitEtaDtGmt(tmpCaCgoRlseBkbcFocVO.getInitEtaDtGmt());
				caCgoRlseBkbcFocVO.setFinalEtaDt(tmpCaCgoRlseBkbcFocVO.getFinalEtaDt());
				caCgoRlseBkbcFocVO.setFinalEtaDtGmt(tmpCaCgoRlseBkbcFocVO.getFinalEtaDtGmt());
				//EDI Kind 를 CR 로 셋팅
				caCgoRlseBkbcFocVO.setEdiKnd("CA");

				tmpCaCgoPoLocSlanVO = dbDao.searchCaCgoPoLocSlan(caCgoRlseBkbcFocVO, account);

				caCgoRlseBkbcFocVO.setPoNo(tmpCaCgoPoLocSlanVO.getPoNo());
				caCgoRlseBkbcFocVO.setLocCd(tmpCaCgoPoLocSlanVO.getLocCd());
				caCgoRlseBkbcFocVO.setVslSlanNm(tmpCaCgoPoLocSlanVO.getVslSlanNm());
				caCgoRlseBkbcFocVO.setBlNo(blNo);
				CaCgoRlseBkbcBlVO caCgoRlseBkbcBlVO = new CaCgoRlseBkbcBlVO();
				caCgoRlseBkbcBlVO = dbDao.searchCaCrEdiResult(caCgoRlseBkbcFocVO);
				caCgoRlseBkbcFocVO.setHisSeq(caCgoRlseBkbcBlVO.getHisSeq());

				String BlCntrInd = "";
				BlCntrInd = dbDao.searchCaCgoBlCntrInd(caCgoRlseBkbcFocVO);
				caCgoRlseBkbcFocVO.setEdiBlCntrInd(BlCntrInd);

				this.priLog("model  CA", caCgoRlseBkbcFocVO);

				// search Canada Flat File
				flatFileVOs = dbDao.searchCaCgoMkFile(caCgoRlseBkbcFocVO);

				flatFileVvdVO = dbDao.searchCaCgoVvdMkFile(caCgoRlseBkbcFocVO);
//					String flatFileVvd = this.searchMkVvdFile(focVO);
				String retVvd = "";

				for(int i=0;i<flatFileVvdVO.size();i++){
					StringBuffer tmpBuffer = new StringBuffer(retVvd).append(flatFileVvdVO.get(i).getFlatFileVvd());
					retVvd = tmpBuffer.toString();
				}

				StringBuffer flatFile = new StringBuffer();
				String ediSnpRtnVal = "";

				BookingUtil command = new BookingUtil();

				for(int i=0;i<flatFileVOs.size();i++){
					CaCgoRlseBkbcFlatFileVO flatFileVO = flatFileVOs.get(i);
					flatFileVO.getSnpFileHeader();
					flatFile.append(flatFileVO.getFlatFileHeader());
					flatFile.append(flatFileVO.getFlatFileBody());
					flatFile.append(retVvd);

					SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();

					sendFlatFileVO.setFlatFile(flatFile.toString());
					sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_CUSTOMER.IBMMQ.QUEUE"));

					FlatFileAckVO flatFileAckVO = command.sendFlatFile(sendFlatFileVO);

					if ( flatFileAckVO.getAckStsCd().equals("E") && "N".equals(multiSnd)){
						throw new EventException(new ErrorHandler("BKG40087").getMessage());
					}
					if(null != flatFileAckVO.getAckStsCd()){
						ediSnpRtnVal = flatFileAckVO.getAckStsCd();
					}
					caCgoRlseBkbcFocVO.setEdiSnpRtnVal(ediSnpRtnVal);
					//Canada Cargo Release EDI Sent 내역을 저장
					dbDao.addCaCgoRlsLogRslt(caCgoRlseBkbcFocVO,account);
					ediSnpRtnVal = "";
					if(!"".equalsIgnoreCase(flatFileVO.getDupFlatFileHeader())){
						flatFile = new StringBuffer();

						flatFile.append(flatFileVO.getDupFlatFileHeader());
						flatFile.append(flatFileVO.getFlatFileBody());
						flatFile.append(flatFileVvdVO);

						SendFlatFileVO dupSendFlatFileVO = new SendFlatFileVO();
						dupSendFlatFileVO.setFlatFile(flatFile.toString());
						dupSendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_CUSTOMER.IBMMQ.QUEUE"));

						FlatFileAckVO dupflatFileAckVO = command.sendFlatFile(dupSendFlatFileVO);

						if ( dupflatFileAckVO.getAckStsCd().equals("E") && "N".equals(multiSnd)){
							throw new EventException(new ErrorHandler("BKG40087").getMessage());
						}
						if(null != dupflatFileAckVO.getAckStsCd()){
							ediSnpRtnVal = dupflatFileAckVO.getAckStsCd();
						}
						caCgoRlseBkbcFocVO.setEdiSnpRtnVal(ediSnpRtnVal);
						//Canada Cargo Release EDI Sent 내역을 저장
						dbDao.addCaCgoRlsLogRslt(caCgoRlseBkbcFocVO,account);
					}
				}
				//Canada Cargo Release History 내역을 저장
				dbDao.modifyCaCgoRlsHisRslt(caCgoRlseBkbcFocVO,account);
				//Canada Cargo Release 내역을 저장
				dbDao.modifyCaCgoRlsRslt(caCgoRlseBkbcFocVO,account);


			}
		 } catch (DAOException de) {
			 throw new EventException(new ErrorHandler(de).getMessage());
		 } catch (Exception ex) {
			 log.error("err " + ex.toString(), ex);
			 throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		 }
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
