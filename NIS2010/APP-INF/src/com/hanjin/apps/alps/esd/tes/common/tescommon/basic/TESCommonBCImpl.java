/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TESCommonBCImpl.java
*@FileTitle : TES Common 관리
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-31
*@LastModifier : byungheeyoo
*@LastVersion : 1.0
* 2006-10-31 byungheeyoo
* 1.0 최초 생성
* 2009-03-03 : 성능측정 관련 기능 추가 
* 2009-05-08 : Office change기능 추가로 인해 session의 ofc_cd를 기준으로 (session이 아닌) MDM의 cnt_cd를 조회
* 2009-10-26 [ITM-200900174] : 미사용 변수 제거 
* 2011.08.08 윤태승 [CHM-201111829-1] Split 12-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 건
* 2011.08.08 윤태승 [CHM-201111118-1] MR Invoice Creation & Correction 의 Manual input 보완
* 2011-10-13: [CHM-201113119] [TES] HIT의 TES invoice eBilling 2단계(invoice PDF 수신) 개발 진행 요청
* 2015.01.20 김영신 [CHM-201430578]TMNL Invoice Manual 입력시 Vol validation 추가 
=========================================================*/
package com.hanjin.apps.alps.esd.tes.common.tescommon.basic;
 
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.esd.tes.common.tescommon.event.TESCommonEvent;
import com.hanjin.apps.alps.esd.tes.common.tescommon.integration.TESCommonDBDAO;
import com.hanjin.apps.alps.esd.tes.common.tesinterface.basic.TESInterfaceManageBC;
import com.hanjin.apps.alps.esd.tes.common.tesinterface.event.IfEsdTes0200Event;
import com.hanjin.apps.alps.esd.tes.common.tesinvoicecommon.event.TESInvoiceCommonEvent;
import com.hanjin.framework.component.attachment.file.support.UpdateFileMetaInfo;
import com.hanjin.framework.component.attachment.file.upload.FileUpload;
import com.hanjin.framework.component.attachment.file.upload.FileUploadException;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.syscommon.common.table.ComUpldFileVO;
import com.hanjin.syscommon.common.table.TesEdiSoFileVO;
import com.hanjin.syscommon.common.table.TesEdiSoHdrVO;
import com.hanjin.syscommon.common.table.TesJbExePerfLogVO;
import com.jf.transfer.TransferEAI;


/**
 * ALPS-ESD Business Logic Basic Command implementation<br>
 * - ALPS-ESD에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author byungheeyoo
 * @see TESCommonHTMLAction, TESCommonBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class TESCommonBCImpl   extends BasicCommandSupport implements TESCommonBC {

	// Database Access Object
	private transient TESCommonDBDAO dbDao=null;

	/**
	 * TESCommonBCImpl 객체 생성<br> 
	 * TESCommonDBDAO를 생성한다.<br>
	 */
	public TESCommonBCImpl(){
		dbDao = new TESCommonDBDAO();
	}
	
	/**
	 * [Container Bkg No]을 [Select] 합니다.<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCntrBkgNo(Event e) throws EventException {
		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try {
			eventResponse.setRs( dbDao.searchCntrBkgNo(event) );
			eventResponse.setETCData("ETC_KEY_NAME", event.getTesCommonVO().getCoid());
			eventResponse.setETCData("successFlag", "SUCCESS");
			return eventResponse;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [Container Bkg No]을 [Select] 합니다.<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCntrBkgNoOff(Event e) throws EventException {
		
		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try {
			eventResponse.setRs( dbDao.searchCntrBkgNoOff(event) );
			eventResponse.setETCData("ETC_KEY_NAME", event.getTesCommonVO().getCoid());
			eventResponse.setETCData("successFlag", "SUCCESS");
			return eventResponse;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 2009-05-08 : Office change기능 추가로 인해 session의 ofc_cd를 기준으로 (session이 아닌) MDM의 cnt_cd를 조회 
	 * @param ofc_cd
	 * @return String
	 * @throws EventException
	 */
	public String getMDMCnt_cd(String ofc_cd) throws EventException {
		
		try {
			return dbDao.getMDMCnt_cd(ofc_cd);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}	
		
	/**
	 * EDI 전송 원본 Invoice 조회만 (Invoice화면에서의 조회) 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse getEDIOriginInvoice(Event e) throws EventException {

		log.debug("\n\n BC.getEDIOriginInvoice \n");
		
		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try {
			eventResponse.setRs( dbDao.getEDIOriginInvoice(event.getTesEdiSoFileVO()) );
			eventResponse.setETCData("successFlag", "SUCCESS");
			
			return eventResponse;
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * 원본 EDI invoice file 정보를 DB에 입력
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse putEDIOriginInvoice(Event e) throws EventException {

		log.debug("\n\n BC.putEDIOriginInvoice \n");
		
//		[CHM-201111829] Split 12-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 건
//		DBRowSet rowSet= new DBRowSet();
		
		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		String					retval			= null;
		
		try {
			retval = dbDao.putEDIOriginInvoice( event );
//			[CHM-201111829] Split 12-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 건			
//			eventResponse.setRs(rowSet);
			eventResponse.setETCData("successFlag", retval);
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * EDI 원본 Invoice 정보 update
	 * @param fVo
	 * @return
	 * @throws EventException
	 */
	public EventResponse putEDIOriginInvoice(TesEdiSoFileVO fVo) throws EventException {

		log.debug("\n\n BC.putEDIOriginInvoice \n");
		
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		String					retval			= null;
		
		try {
			retval = dbDao.putEDIOriginInvoice(fVo);
			eventResponse.setETCData("successFlag", retval);
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * EDI invoice원본 PDF FILE을 해당 INVOICE를 찾아 MAPPING한다.
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse mapEDIOriginInvoice(Event e) throws EventException {

		log.debug("\n\n bbb BC.mapEDIOriginInvoice \n");
		
		IfEsdTes0200Event event = (IfEsdTes0200Event)e;
		TesEdiSoHdrVO tesEdiSoHdrVO = event.getTesEdiSoHdrVO();		
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try {
			dbDao.mapEDIOriginInvoice(tesEdiSoHdrVO);
			
			//eventResponse.setETCData("successFlag", retval);
			log.debug("\n\n eee BC.mapEDIOriginInvoice \n");	
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		
	}

	/**
	 * EDI invoice원본 PDF FILE을 저장
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse saveEDIPDFfile(Event e) throws EventException {
		log.debug("\n\n BC.saveEDIPDFfile \n");
		
		IfEsdTes0200Event event = (IfEsdTes0200Event)e;
		
		try{
			//String orgFileNm		= e!=null?((IfEsdTes0200Event)e).getFileNm():"";
			//TransferEAI eai 		= e!=null?(((IfEsdTes0200Event)e).getEai()!=null?((IfEsdTes0200Event)e).getEai():null):null;
			//byte[] flbuf			= ((IfEsdTes0200Event)e).getFileBuf()!=null?((IfEsdTes0200Event)e).getFileBuf():(eai!=null?(eai.getByteMessage()!=null?eai.getByteMessage():null):null);
		
			String orgFileNm = event.getFileNm();		
			TransferEAI eai = event.getEai();
			byte[] flbuf = event.getFileBuf();
			
			if(flbuf == null){
				if(eai != null){
					flbuf = eai.getByteMessage();
				}
			}
		
			return saveEDIPDFfile(orgFileNm, flbuf);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * EDI invoice원본 PDF FILE을 저장
	 * @param orgFileNm
	 * @param flbuf
	 * @return
	 * @throws EventException
	 */
	public EventResponse saveEDIPDFfile(String orgFileNm, byte[] flbuf) throws EventException {

		log.debug("\n\n BC.saveEDIPDFfile(String orgFileNm, byte[] flbuf) \n");
		
		EventResponse eventResponse = null;
		
		TesEdiSoFileVO fVo = null; 
		TesEdiSoHdrVO hVo = null;
		
		String usr_id 			= "ALPSTES";
		String[] orgFileNmSplit = null;
		String file_sav_id 		= null;
		boolean isVaildPDFNm 	= false;
		String tmp_vndr_seq 	= null;
		String tmp_inv_no 		= null;
		String[] valid_vndrs	= null;
		String rjctRmk			= null;
		DBRowSet dbRowset 		= null;

		try {
			log.error("\n orgFileNm:"+(orgFileNm!=null&&!orgFileNm.equals("")?orgFileNm:"")+"<<< \n");
			if (orgFileNm!=null && !orgFileNm.trim().equals("")){
				
				fVo = new TesEdiSoFileVO(); 
				
				orgFileNmSplit =  orgFileNm.split("_");

				if (orgFileNmSplit!=null && orgFileNmSplit.length>=2){
					if (flbuf!=null){
						
						//NAS에 밀어넣기 + COM TABLE 저장까지
						FileUpload fileUpload = new FileUpload();
						file_sav_id = fileUpload.doUpload(flbuf, orgFileNm, "TES");
						log.debug("\n\n ## file_sav_id:"+file_sav_id+"<<<<########\n\n");

						//TES FILE TABLE에 기록 남기기
						if (file_sav_id!=null && !file_sav_id.trim().equals("")){
							//VNDR+INVNO 별로 유효성 확인 작업 여기서- 유효하지 않은 경우 DB상태 삭제 처리
							//VNDR+INVNO의 invoice가 존재하면 붙여준다. EDI나 정규 invoice가 될 수 있다.
							tmp_vndr_seq 	= orgFileNmSplit!=null && orgFileNmSplit[0]!=null ? orgFileNmSplit[0] : "";
							tmp_inv_no		= orgFileNmSplit!=null && orgFileNmSplit[1]!=null ? orgFileNmSplit[1] : "";
							log.debug("\n ## tmp_vndr_seq:"+tmp_vndr_seq+"  -  tmp_inv_no:"+tmp_inv_no+"<<<<<\n");
							valid_vndrs = TESInterfaceManageBC.VALID_TES_EDI_VNDRS;
							if (tmp_vndr_seq!=null && !tmp_vndr_seq.trim().equals("")){
								for (int i=0; valid_vndrs!=null && i<valid_vndrs.length; i++){
									if (valid_vndrs[i]!=null && !valid_vndrs[i].equals("") && valid_vndrs[i].equals(tmp_vndr_seq)){
										if (tmp_inv_no!=null && !tmp_inv_no.trim().equals("") && tmp_inv_no.length()>0){
											isVaildPDFNm = true;
											break;
										}
									}
								}
							}

							log.debug("\n\n ## isVaildPDFNm:"+isVaildPDFNm+"<<<<########\n\n");
							if (isVaildPDFNm){
								log.debug("\n\n -- isVaildPDFNm  if ------------ \n\n");
								/**
								 * VNDR + INVNO.로 (EDI HDR와 INV HDR)를 뒤져서,
								 * 1)VNDR + INVNO.로 접수된 INVOICE가 없을 경우 그냥 EDI FILE TABLE에만 기록하고 통과한다.(나중에 해당 INVOICE가 접수할 경우 그쪽에서 땡겨간다.)  
								 * 2)이미 접수된 INVOICE가 복수개인 경우 오류로.. 
								 * 3)이미 접수된 INVOICE가 정상적으로 접수되어 있으면 해당 INVOICE의 KEY값으로  MAPPING을 해준다.
								 * 4)이미 접수된 INVOICE의 상태가 CONFIRM상태 이상인 경우는 해당 PDF FILE은 접수가 되면 안된다.
								 */
								hVo = new TesEdiSoHdrVO();
								hVo.setVndrSeq(tmp_vndr_seq);
								hVo.setInvNo(tmp_inv_no);
								fVo.setOrgFileNm(orgFileNm);
								eventResponse = checkEDIOriginInvoice(hVo, fVo);
								dbRowset = eventResponse.getRs();

								if (dbRowset!=null && dbRowset.next()){
									log.debug("\n\n -- dbRowset NOT NULL ------------ \n\n");
									rjctRmk = rjctRmk + (rjctRmk!=null&&!rjctRmk.trim().equals("")?"|":"") + (dbRowset.getInt("INV_KNT")>1?"DUPLICATED INVOICES FOUND":"");
									rjctRmk = rjctRmk + (rjctRmk!=null&&!rjctRmk.trim().equals("")?"|":"") + (dbRowset.getInt("ACC_STS")>0?"INVALID INVOICE STATUS":"");
									
									if (dbRowset.getInt("INV_KNT")==0){
										log.debug("\n\n -- dbRowset INV_KNT==0 ------------ \n\n");
										/* 정상적인 기접수된 invoice정보가 없는 경우 -> 그냥 넣기만 하고 invoice mapping은 나중에 전문이 접수되는 시점에 하게 그냥 둔다. */
										/*  EDI file table에만 기록한다.  */
										fVo.setSavCfmFlg("Y");
										fVo.setFileRmk("WAITING");								
										fVo.setOrgFileNm(orgFileNm);
										fVo.setFileSavId(file_sav_id);
										
										fVo.setCreUsrId(usr_id);
										fVo.setUpdUsrId(usr_id);
										putEDIOriginInvoice(fVo);
									} else if (dbRowset.getInt("INV_KNT")==1){
										log.debug("\n\n -- dbRowset INV_KNT==1 ------------ \n\n");
										/* 정상적인 기접수된 invoice정보가 존재하며, update수행 */
										if (dbRowset.getInt("FILE_KNT")==0){
											log.debug("\n\n -- dbRowset FILE_KNT==0 ------------ \n\n");
											log.debug("\n ~~~ INSSSSSSSEERRRRTTT!!!! ~~ \n");
											fVo.setSavCfmFlg("Y");
											fVo.setFileRmk("");								
											fVo.setOrgFileNm(orgFileNm);
											fVo.setFileSavId(file_sav_id);
											fVo.setTmlSoOfcCtyCd(dbRowset.getString("TML_SO_OFC_CTY_CD"));
											fVo.setTmlSoSeq(dbRowset.getString("TML_SO_SEQ"));
											fVo.setTmlEdiSoOfcCtyCd(dbRowset.getString("TML_EDI_SO_OFC_CTY_CD"));
											fVo.setTmlEdiSoSeq(dbRowset.getString("TML_EDI_SO_SEQ"));
											
											fVo.setCreUsrId(usr_id);
											fVo.setUpdUsrId(usr_id);
											putEDIOriginInvoice(fVo);
										} else {
											log.debug("\n\n -- dbRowset FILE_KNT!=0 ------------ \n\n");
											// 우회
											log.debug("\n ~~~ PASSSSS!!!! ~~ \n");
										}
									} else {
										log.debug("\n\n -- dbRowset INV_KNT else ------------ \n\n");
										/* 비정상적인 기접수된 invoice정보가 존재하며, update취소 */
										fVo.setSavCfmFlg("N");
										fVo.setFileRmk(rjctRmk);
										fVo.setOrgFileNm(orgFileNm);
										fVo.setFileSavId(file_sav_id);
										
										fVo.setCreUsrId(usr_id);
										fVo.setUpdUsrId(usr_id);
										putEDIOriginInvoice(fVo);
									}
								} else {
									log.debug("\n\n -- dbRowset NULL ------------ \n\n");
									/* 정상적인 기접수된 invoice정보가 없는 경우 -> 그냥 넣기만 하고 invoice mapping은 나중에 전문이 접수되는 시점에 하게 그냥 둔다. */
									/*  EDI file table에만 기록한다.  */
									fVo.setSavCfmFlg("Y");
									fVo.setFileRmk("WAITING");								
									fVo.setOrgFileNm(orgFileNm);
									fVo.setFileSavId(file_sav_id);		
									
									fVo.setCreUsrId(usr_id);
									fVo.setUpdUsrId(usr_id);
									putEDIOriginInvoice(fVo);
								}
							} else {
								log.debug("\n\n ~~~ isVaildPDFNm - INVALID PDF NAME!!!! ~~~~~~~~~~~~~~~~~~~~  \n\n");

								fVo.setSavCfmFlg("N");
								fVo.setFileRmk("INVALID PDF File Name");
								fVo.setOrgFileNm(orgFileNm);
								
								if (!isVaildPDFNm){
									// KEY값이 FILE을 지움표시
									UpdateFileMetaInfo.delete(file_sav_id);
								}
							}
						} else {
							log.debug("\n\n ~~~ INVALID COMMON FILE_SAV_ID ~~~~~~~~~~~~~~~~~~~~  \n\n");
							//file_sav_id이 없으면 공통TABLE의 DATA는 어쩔 수 없다.
							//==>>다만 TES FILE TABLE에 orgFileNm으로만 오류 기록 남기기
							fVo.setOrgFileNm(orgFileNm);
							fVo.setSavCfmFlg("N");
							fVo.setFileRmk("INVALID COMMON FILE_SAV_ID");
							
							fVo.setCreUsrId(usr_id);
							fVo.setUpdUsrId(usr_id);
							putEDIOriginInvoice(fVo);
						}
					} else {
						log.debug("\n\n ~~~ FileBuf NULL Exception ~~~~~~~~~~~~~~~~~~~~  \n\n");
						// FileBuf NULL Exception
						fVo.setOrgFileNm(orgFileNm);
						fVo.setSavCfmFlg("N");
						fVo.setFileRmk("FileBuf NULL Exception");
						
						fVo.setCreUsrId(usr_id);
						fVo.setUpdUsrId(usr_id);
						putEDIOriginInvoice(fVo);
					}
				} else {
					log.debug("\n\n ~~~ INVALID EDI FILE NAME ~~~~~~~~~~~~~~~~~~~~  \n\n");
					//유효하지 않은 fileName -> 'VNDRCD_INVNO_...' 형태로 구분자로 '_'가 중간에 와야한다.
					//==>>TES FILE TABLE에 orgFileNm으로만 오류 기록 남기기
					fVo.setOrgFileNm(orgFileNm);
					fVo.setSavCfmFlg("N");
					fVo.setFileRmk("INVALID EDI FILE NAME");
					
					fVo.setCreUsrId(usr_id);
					fVo.setUpdUsrId(usr_id);
					putEDIOriginInvoice(fVo);
				}
			} else {
				log.error("\n !!!!orgFileNm NULL!!!!!!!!!! \n");
			}
			
//			fVo.setCreUsrId(usr_id);
//			fVo.setUpdUsrId(usr_id);
//			putEDIOriginInvoice(fVo);
			
			
			log.debug("<<<<<<<<<< BC - saveEDIPDFfile - END >>>>>>>>>>>>>>>>");

		} catch (FileUploadException ef) {
			log.error(ef.getMessage());
			throw new EventException(ef.getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage());
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * EDI Invoice원본에 mapping되는 invoice의 상태를 확인
	 * @param hVo
	 * @param fVo
	 * @return
	 * @throws EventException
	 */
	public EventResponse checkEDIOriginInvoice(TesEdiSoHdrVO hVo, TesEdiSoFileVO fVo) throws EventException {

		log.debug("\n\n BC.checkEDIOriginInvoice \n");
		
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();

		try {
			eventResponse.setRs(dbDao.checkEDIOriginInvoice(hVo, fVo));
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * Cost OFC 조회
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCostOFC(Event e) throws EventException {

		log.debug("\n\n BC.searchCostOFC \n");
		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		log.debug("\n\n Id : "+event.getTesCommonVO().getCoid()+"<<<");
		try {
			eventResponse.setRs (dbDao.searchCostOFC(event));
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * currency 조회
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCurrencyList(Event e) throws EventException {

		log.debug("\n\n BC.searchCurrencyList \n");
		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();
		log.debug("\n\n Id : "+event.getTesCommonVO().getCoid()+"<<<");

		log.debug("ofc_cd:"+event.getSignOnUserAccount().getOfc_cd());

		try {
			eventResponse.setRs (dbDao.searchCurrencyList(event));
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * Cost OFC 유효성 확인
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse validateCostOFC(Event e) throws EventException {

		log.debug("\n\n BC.validateCostOFC \n");

		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			eventResponse.setRs (dbDao.validateCostOFC(event));
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * Cost OFC 존재 확인 + delt_flg
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse validateCostOFC2(Event e) throws EventException {

		log.debug("\n\n BC.validateCostOFC2 \n");

		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			eventResponse.setRs (dbDao.validateCostOFC2(event));
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * Inv OFC 존재 확인 + delt_flg
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse validateInvOFC(Event e) throws EventException {

		log.debug("\n\n BC.validateInvOFC \n");

		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			if( !"".equals( event.getTesTmlSoHdrVO().getInvOfcCd() ) ) {
				event.getTesTmlSoHdrVO().setCostOfcCd( event.getTesTmlSoHdrVO().getInvOfcCd() );
			}
			
			eventResponse.setRs (dbDao.validateCostOFC2(event));
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}


	/**
	 * YARD DATA 입력시
	 * LOCATION CODE에 해당하는 NODE CODE를 조회해 콤보 형식으로 화면에 보여줌
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse getNodeCode(Event e) throws EventException {

		log.debug("\n\n BC.validateInvOFC \n");

		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			eventResponse.setRs ( dbDao.getNodeCode(event) );
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * Yard code 유효성 확인
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse validateYardCode(Event e) throws EventException {

		log.debug("\n\n BC.validateYardCode \n");

		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			eventResponse.setRs (dbDao.validateYardCode(event));
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * Yard code 존재 확인 + delt_flg
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse validateYardCode2(Event e) throws EventException {

		log.debug("\n\n BC.validateYardCode2 \n");

		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			eventResponse.setRs (dbDao.validateYardCode2(event));
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * DB 시간 조회
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse getDBdate(Event e) throws EventException {

		log.debug("\n\n BC.getDBdate \n");
		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			eventResponse.setRs (dbDao.searchDBdate(event));
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * 2009-05-08 : Office change기능 추가로 인해 session의 ofc_cd를 기준으로 (session이 아닌) MDM의 cnt_cd를 조회 
	 * @param ofc_cd
	 * @return String
	 * @throws EventException
	 */
	public String getDBdateStr(String ofc_cd) throws EventException {
		
		try {
			return dbDao.searchDBdateStr(ofc_cd);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}	
	
	/**
	 * vndr code 유효성 확인
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse validateVndrCode(Event e) throws EventException {

		log.debug("\n\n BC.validateVndrCode \n");
		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			eventResponse.setRs ( dbDao.validateVndrCode(event) );
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * vndr code 존재 확인 + delt_flg
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse validateVndrCode2(Event e) throws EventException {

		log.debug("\n\n BC.validateVndrCode2 \n");
		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			eventResponse.setRs ( dbDao.validateVndrCode2(event) );
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * Yard code에 귀속된 Cost code 목록 조회
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchYdCostCodeList(Event e) throws EventException {

		log.debug("\n\n BC.searchYdCostCodeList \n");

		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();


		try {
			eventResponse.setRs ( dbDao.searchYdCostCodeList(event) );
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * Yard code 유효성 확인 및 귀속 code 조회
	 * @param Event e
	 * @return
	 * @exception EventException
	 */
	public EventResponse validateYardCodeNsearchYdCostCodeList(Event e) throws EventException {

		log.debug("\n\n BC.validateYardCodeNsearchYdCostCodeList \n");
		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			eventResponse.setRs ( dbDao.validateYardCodeNsearchYdCostCodeList(event) );
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * TES의 cost code 조회
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTESCostCodeList(Event e) throws EventException {

		log.debug("\n\n BC.searchTESCostCodeList \n");

		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			eventResponse.setRs (dbDao.searchTESCostCodeList());
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * CntrTPCD 조회
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCntrTPCDList(Event e) throws EventException {

		log.debug("\n\n BC.searchCntrTPCDList \n");
		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			eventResponse.setRs (dbDao.searchCntrTPCDList());
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * CntrSZCD 조회
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCntrSZCDList(Event e) throws EventException {

		log.debug("\n\n BC.searchCntrSZCDList \n");
		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			eventResponse.setRs (dbDao.searchCntrSZCDList());
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * CntrTPSZCD 조회
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCntrTPSZCDList(Event e) throws EventException {

		log.debug("\n\n BC.searchCntrTPSZCDList \n");
		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			eventResponse.setRs ( dbDao.searchCntrTPSZCDList() );
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * Lane CD 조회
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchLaneList(Event e) throws EventException {

		log.debug("\n\n BC.searchLaneList \n");
		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		log.debug("\n\n Id : "+event.getTesCommonVO().getCoid()+"<<<");
		try {
			eventResponse.setRs (dbDao.searchLaneList(event));
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * TES SO 자동 Cost code 조회
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAutoTESTmlSoCostCDList(Event e) throws EventException {

		log.debug("\n\n BC.searchAutoTESTmlSoCostCDList \n");
		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			eventResponse.setRs (dbDao.searchAutoTESTmlSoCostCDList(event));
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * TES SO 수동 Cost code 조회
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchManualTESTmlSoCostCDList(Event e) throws EventException {

		log.debug("\n\n BC.searchManualTESTmlSoCostCDList \n");
		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			eventResponse.setRs (dbDao.searchManualTESTmlSoCostCDList(event));
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * TES invoice 공통 code 조회
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTESInvoiceCommonCodeList(Event e) throws EventException {

		log.debug("\n\n BC.searchTESInvoiceCommonCodeList \n");

		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			eventResponse.setRs (dbDao.searchTESInvoiceCommonCodeList());
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * agreement cost code 조회
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAgreementCostCodeList(Event e) throws EventException {

		log.debug("\n\n BC.searchAgreementCostCodeList \n");
		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			eventResponse.setRs (dbDao.searchAgreementCostCodeList(event));
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * Lane CD 조회
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchLaneCodeList(Event e) throws EventException {

		log.debug("\n\n BC.searchLaneCodeList \n");
		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			eventResponse.setRs (dbDao.searchLaneCodeList(event));
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Lane CD 조회
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMDMAccount(Event e) throws EventException {

		log.debug("\n\n BC.searchMDMAccount \n");
		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			eventResponse.setRs (dbDao.searchMDMAccount(event));
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	
	/**
	 * Lane CD 조회
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAuthOfcCd(Event e) throws EventException {
		log.debug("\n\n BC.searchAuthOfcCd \n");

		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			eventResponse.setRs (dbDao.searchAuthOfcCd(event));
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * 등록된 주요 기능의 성능 측정 시작용
	 *  
	 * @param TesJbExePerfLogVO tesJbExePerfLogVO
	 * @return String
	 * @exception EventException
	 */
	public String beginJobExecutionPerformance(TesJbExePerfLogVO tesJbExePerfLogVO) throws EventException {
		log.debug("\n\n BC.beginJobExecutionPerformance \n");
	
		String			currSeq	= null;
		
		try {
			currSeq = dbDao.beginJobExecutionPerformanceR( tesJbExePerfLogVO );
			
			if ( !"".equals( currSeq ) ) {
				tesJbExePerfLogVO.setExePerfLogSeq( currSeq );
				dbDao.beginJobExecutionPerformanceC( tesJbExePerfLogVO );
			}
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return currSeq;
	}

	/**
	 * 등록된 주요 기능의 성능 측정 마침용 
	 *  
	 * @param String curr_seq
	 * @exception EventException
	 */
	public void endJobExecutionPerformance(String curr_seq) throws EventException {
		log.debug("\n\n BC.endJobExecutionPerformance \n");

		try {
			dbDao.endJobExecutionPerformance(curr_seq, TESCommonBC.PERF_JOB_COMPLETE);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 등록된 주요 기능의 성능 측정 오류 처리용 
	 *  
	 * @param String curr_seq
	 * @exception EventException
	 */
	public void errorJobExecutionPerformance(String curr_seq) throws EventException {
		log.debug("\n\n BC.errorJobExecutionPerformance \n");

		try {
			dbDao.endJobExecutionPerformance(curr_seq, TESCommonBC.PERF_JOB_ERROR);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	
	/**
	 * ESD 업무 시나리오 마감작업<br>
	 * TESCommon업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
	
	
	/**
	 * Regional Head Office 조회
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRhqOfcCd(Event e) throws EventException {
		log.debug("\n\n BC.searchRhqOfcCd \n");

		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			eventResponse.setRs (dbDao.searchRhqOfcCd(event));
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * 해당 월 환율 적용하여 USD Amt를 구한다.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse checkUsdConvert(Event e) throws EventException {
		log.debug("\n\n BC.checkUsdConvert \n");
		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			eventResponse.setRs (dbDao.checkUsdConvert(event));
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Upload 되어있는 Excel Template File Key 를 조회합니다.<br>
	 * 
	 * @param ComUpldFileVO comUpldFileVO
	 * @return String
	 * @exception EventException
	 */
	public String searchExcelTemplateFileKey(ComUpldFileVO comUpldFileVO) throws EventException {
		try {
			return dbDao.searchExcelTemplateFileKey(comUpldFileVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("TES00090", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TES00090", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Invoice No 중복 확인
	 * @param  Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchInvNoDupChk(Event e) throws EventException {

		log.debug("\n\n BC.searchInvNoDupChk \n");
		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		Map<String, String>		etcData			= new HashMap<String, String>();
		
		try {
			eventResponse.setRs(dbDao.searchInvNoDupChk(event));	
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Invoice의  Manual 입력시 필수 입력 체크 여부
	 * @param  Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchCostCodeChkFlg(Event e) throws EventException {

		log.debug("\n\n BC.searchCostCodeChkFlg \n");
		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		Map<String, String>		etcData			= new HashMap<String, String>();
		
		try {
			eventResponse.setRs(dbDao.searchCostCodeChkFlg(event));	
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * TES 공통 조회 기능 <br>
	 * AGMT NO 를 조회하여 AGMT NO 를 리턴<br>
	 * 
	 * @param String agmt_no
	 * @return String return_agmt_no
	 * @exception DAOException
	 */
	public String searchTesAgmtNoBasic(String agmt_no) throws EventException {
		try{	
			return dbDao.searchTesAgmtNoData(agmt_no);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("TES00016", new String[]{"[TESCOMMON] searchTesAgmtNoBasic"}).getMessage(),ex);
		} catch (Exception ex) {	
			throw new EventException(new ErrorHandler("TES00016", new String[]{"[TESCOMMON] searchTesAgmtNoBasic"}).getMessage(),ex);
		}
	}
	
	
	
	/**
	 * TES Invoice Cost Code List Inquiry
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTESInvCostCodeList(Event e) throws EventException {

		log.debug("\n\n BC.searchTESInvCostCodeList \n");

		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			eventResponse.setRs (dbDao.searchTESInvCostCodeList());
			etcData.put("successFlag", "SUCCESS" );
			
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * CALLING YARD INDICATOR SEQUENCE List
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchCallYdIndSeqList(Event e) throws EventException {

		log.debug("\n\n BC.searchCallYdIndSeqList \n");

		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			eventResponse.setRs (dbDao.searchCallYdIndSeqList(event));
			etcData.put("successFlag", "SUCCESS" );			
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * CALLING PORT INDICATOR SEQUENCE
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchClptIndSeq(Event e) throws EventException {

		log.debug("\n\n BC.searchClptIndSeq \n");

		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			eventResponse.setRs (dbDao.searchClptIndSeq(event));
			etcData.put("successFlag", "SUCCESS" );			
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	
	/**
	 * CALLING YARD SEQUENCE check
	 * doubling calling 이면 Y, 아니면 N 
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchCallingYardSeqChk(Event e) throws EventException {

		log.debug("\n\n BC.searchClptIndSeq \n");

		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			eventResponse.setRs (dbDao.searchCallingYardSeqChk(event));
			etcData.put("successFlag", "SUCCESS" );			
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}	
	
	/**
	 * Sub Office List
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchSubOfficeList(Event e) throws EventException {

		log.debug("\n\n BC.searchSubOfficeList \n");

		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			eventResponse.setRs (dbDao.searchSubOfficeList(event));
			etcData.put("successFlag", "SUCCESS" );			
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex); 
		}
	}
	
	/**
	 * login user의 default office와 login한 office가 같은지 확인한다.
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse getUserOfcCdChk(Event e) throws EventException {
		
		log.debug("\n\n BC.getUserOfcCdChk \n");
		
		TESCommonEvent	event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();	
		
		Map<String, String>		etcData			= new HashMap<String, String>();
		
		try {
			event.getTesCommonVO().setUsrId(event.getSignOnUserAccount().getUsr_id());
			event.getTesCommonVO().setOfcCd(event.getSignOnUserAccount().getOfc_cd());
			
			eventResponse.setRs ( dbDao.getUserOfcCdChk( event ) );
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * login office가 BOMSC 혹은 BOMSC 산하 Office 인지 확인한다.
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public String getIndOfcCdChk(String ofcCd) throws EventException {
		
		log.debug("\n\n BC.getIndOfcCdChk \n");
		try {
			return dbDao.getIndOfcCdChk(ofcCd) ;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	public EventResponse getIndGstRto(Event e) throws EventException {
		
		log.debug("\n\n BC.getIndGstRto \n");
		
		TESCommonEvent	event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();		
		Map<String, String>		etcData			= new HashMap<String, String>();
		
		try {
			eventResponse.setRs ( dbDao.getIndGstRto( event ) );
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	public EventResponse validateSacCd(Event e) throws EventException {
		
		log.debug("\n\n BC.validateSacCd \n");
		
		TESCommonEvent	event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();		
		Map<String, String>		etcData			= new HashMap<String, String>();
		
		try {
			eventResponse.setRs ( dbDao.validateSacCd( event ) );
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
}