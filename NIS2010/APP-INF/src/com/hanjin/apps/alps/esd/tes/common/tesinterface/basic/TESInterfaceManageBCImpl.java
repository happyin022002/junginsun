/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TESInterfaceBCImpl.java
*@FileTitle : EAI Interface
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-07
*@LastModifier : kimjinjoo
*@LastVersion : 1.0
* 2006-12-07 kimjinjoo
* 1.0 최초 생성
* 2009-08-27 [PJM-200900072] : MANUAL CNTR LIST과 AUTO FREEPOOL LIST 추가 추출
*                              부산신항만(180020)일 경우 AUTO FREEPOOL목록 추가
*                              부산신항만(180020)일 경우 MANUAL CNTR목록 추가
=========================================================*/
package com.hanjin.apps.alps.esd.tes.common.tesinterface.basic;
import java.util.HashMap;

import com.hanjin.apps.alps.esd.tes.common.tesinterface.integration.TESInterfaceManageDBDAO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ENIS-ESD Business Logic Basic Command implementation<br>
 * - ENIS-ESD에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author kimjinjoo
 * @see TESInterface9EventResponse,TESInterfaceManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class TESInterfaceManageBCImpl   extends BasicCommandSupport implements TESInterfaceManageBC {

	// Database Access Object
	private transient TESInterfaceManageDBDAO dbDao=null;

	private String msgCreDt= "";

	/**
	 * getMsgCreDt
	 * @return
	 */
	public String getMsgCreDt(){
		return msgCreDt;
	}

	/**
	 * setMsgCreDt
	 * @param msgCreDt
	 */
	public void setMsgCreDt(String msgCreDt){
		this.msgCreDt = msgCreDt;
	}

	/**
	 * TESInterfaceeManageBCImpl 객체 생성<br>
	 * TESInterfaceeManageDBDAO를 생성한다.<br>
	 */
	public TESInterfaceManageBCImpl(){
		dbDao = new TESInterfaceManageDBDAO();
	}

	/**
	 * 2009-08-27 [PJM-200900072] : MANUAL CNTR LIST과 AUTO FREEPOOL LIST 추가 추출
	 * EDI에서 전송한 FLAT FILE에서 INVOICE정보를 MODEL별로 추출하여 Hashmap으로 추출하기
	 * @param str
	 * @return EventResponse
	 */
	@SuppressWarnings("unchecked")
	public EventResponse getEDIinvoiceInTESformat(String str) throws EventException {
		
		log.debug("\n\n BEGIN - BCimpl.getEDIinvoiceInTESformat - ########################################### ");
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		java.io.BufferedReader br = null;
		
		try {
			
			str = str.trim();
			
			/**
			 * 유효성 검사 : { } 앞뒤 확인, 쌍으로 왔는지 등 + HDR 1X, CNTR_LIST MX, DTL MX의 배열 생성
			 * 차후에 모든 열고 닫기 검사 logic 추가
			 */
			if (str.indexOf("{TES_EDI_SO_HDR")!=str.lastIndexOf("{TES_EDI_SO_HDR") && 
				str.indexOf("}TES_EDI_SO_HDR")!=str.lastIndexOf("}TES_EDI_SO_HDR")) {
				throw new EventException("INVALID EDI HEADER FORMAT");
			}

			
			/**
			 * HDR, CNTR_LIST, DTL로 쪼개어 담을 배열의 크기 구하기 - Table명을 나중에 DB에서 불러오게 해도 된다.
			 * EDI로 전송된 invoice는 한개의 HEADER정보와 다수DTL/다수CNTR/다수MANUAL CNTR/다수AUTO FP정보가 온다.
			 */
			String[] arr_search_substr= {"{TES_EDI_SO_HDR","{TES_EDI_SO_DTL","{TES_EDI_SO_CNTR_LIST","{TES_EDI_SO_MNL_CNTR_LIST","{TES_EDI_SO_AUTO_FREE_POOL"};
//			String FM_VNDR_SEQ = null; 
			HashMap hdr 	= null;
			HashMap[] cntrs = null;
			HashMap[] dtls 	= null;
			HashMap[] mnlCntrs = null;
			HashMap[] autoFPs = null;
			
			int cnt = 0;
			int cnt_hdr = 0;
			int cnt_cntr = 0;
			int cnt_dtl = 0;
			int cnt_mnl_cntr = 0;
			int cnt_auto_fp = 0;
			
			for (int k=0; arr_search_substr!=null && k<arr_search_substr.length; k++) {
				for (int j=str.indexOf(arr_search_substr[k],0); 
						str!=null && !str.equals("") && str.indexOf(arr_search_substr[k])!=-1 && str.indexOf(arr_search_substr[k],j)!=-1; 
							j=(str.indexOf(arr_search_substr[k],j)!=-1)?str.indexOf(arr_search_substr[k],j)+arr_search_substr[k].length():j++) {
					cnt++;
					cnt_hdr = k==0?cnt_hdr+1:cnt_hdr;
					cnt_dtl = k==1?cnt_dtl+1:cnt_dtl;
					cnt_cntr = k==2?cnt_cntr+1:cnt_cntr;
					cnt_mnl_cntr = k==3?cnt_mnl_cntr+1:cnt_mnl_cntr;
					cnt_auto_fp  = k==4?cnt_auto_fp+1:cnt_auto_fp;
				}
			}
			log.debug("cnt_hdr:"+cnt_hdr);
			log.debug("cnt_dtl:"+cnt_dtl);
			log.debug("cnt_cntr:"+cnt_cntr);
			log.debug("cnt_mnl_cntr:"+cnt_mnl_cntr);
			log.debug("cnt_auto_fp:"+cnt_auto_fp);
			if (cnt_hdr!=1){
				throw new Exception("\n [TES-EDI EXCEPTION] No Proper EDI Header Sent \n");
			}
			
			hdr 	= new HashMap();
			cntrs 	= new HashMap[cnt_cntr];
			dtls 	= new HashMap[cnt_dtl];
			mnlCntrs 	= new HashMap[cnt_mnl_cntr];
			autoFPs 	= new HashMap[cnt_auto_fp];
			
			/**
			 * HDR, CNTR_LIST, DTL로 쪼개어 response에 담기
			 */			
			String buffer = null;
			String curr_blk = null;
			br = new java.io.BufferedReader(new java.io.StringReader(str));
			buffer = null;
			String[] tmp = null;
			int idx_dtl = 0;
			int idx_cntr = 0;
			int idx_mnl_cntr = 0;
			int idx_auto_fp = 0;
			int cntx = 0;
			while ((buffer=br.readLine()) != null){
				cntx++;
				if (buffer!=null && !buffer.trim().equals("")){
					if (buffer.trim().startsWith("$$$MSGSTART:")){
						log.debug("$$$MSGSTART:");
					} else if (buffer.trim().startsWith("{")){
						curr_blk = buffer.trim();
						if (arr_search_substr[1]!=null && buffer.trim().equals(arr_search_substr[1].trim())) {
							dtls[idx_dtl] = new HashMap();
						}
						if (arr_search_substr[2]!=null && buffer.trim().equals(arr_search_substr[2].trim())) {
							cntrs[idx_cntr] = new HashMap();
						}
						if (arr_search_substr[3]!=null && buffer.trim().equals(arr_search_substr[3].trim())) {
							mnlCntrs[idx_mnl_cntr] = new HashMap();
						}
						if (arr_search_substr[4]!=null && buffer.trim().equals(arr_search_substr[4].trim())) {
							autoFPs[idx_auto_fp] = new HashMap();
						}				
					} else if (buffer.trim().startsWith("}")){
						if (buffer!=null && buffer.trim().equals("}TES_EDI_SO_DTL".trim())) {
							if (idx_dtl<=cnt_dtl){ ++idx_dtl; }
						}
						if (buffer!=null && buffer.trim().equals("}TES_EDI_SO_CNTR_LIST".trim())) {
							if (idx_cntr<=cnt_cntr){ ++idx_cntr; }
						}
						if (buffer!=null && buffer.trim().equals("}TES_EDI_SO_MNL_CNTR_LIST".trim())) {
							if (idx_mnl_cntr<=cnt_mnl_cntr){ ++idx_mnl_cntr; }
						}
						if (buffer!=null && buffer.trim().equals("}TES_EDI_SO_AUTO_FREE_POOL".trim())) {
							if (idx_auto_fp<=cnt_auto_fp){ ++idx_auto_fp; }
						}
					} else {
						if (curr_blk!=null && curr_blk.equals(arr_search_substr[0])){
							if ((tmp = buffer.trim().split(":"))!=null){ // && tmp.length==2){
								hdr.put(tmp[0],tmp.length==2?tmp[1]:"");
							}
						} else if (curr_blk!=null && curr_blk.equals(arr_search_substr[1]) && buffer!=null && !buffer.trim().equals(arr_search_substr[1])){
							if ((tmp = buffer.trim().split(":"))!=null){
								dtls[idx_dtl].put(tmp[0],tmp.length==2?tmp[1]:"");
							}
						} else if (curr_blk!=null && curr_blk.equals(arr_search_substr[2]) && buffer!=null && !buffer.trim().equals(arr_search_substr[2])){
							if ((tmp = buffer.trim().split(":"))!=null){ // && tmp.length==2){
								cntrs[idx_cntr].put(tmp[0],tmp.length==2?tmp[1]:"");
							}
						} else if (curr_blk!=null && curr_blk.equals(arr_search_substr[3]) && buffer!=null && !buffer.trim().equals(arr_search_substr[3])){
							if ((tmp = buffer.trim().split(":"))!=null){
								mnlCntrs[idx_mnl_cntr].put(tmp[0],tmp.length==2?tmp[1]:"");
							}
						} else if (curr_blk!=null && curr_blk.equals(arr_search_substr[4]) && buffer!=null && !buffer.trim().equals(arr_search_substr[4])){
							if ((tmp = buffer.trim().split(":"))!=null){
								autoFPs[idx_auto_fp].put(tmp[0],tmp.length==2?tmp[1]:"");
							}
						}
					}
				}
			}
			
			log.debug("@@@@@ cntx:"+cntx);
			
//			eventResponse.setCustomData("FMVNDR", FM_VNDR_SEQ);
			eventResponse.setCustomData("HDR", hdr);
			eventResponse.setCustomData("DTLs", dtls);
			eventResponse.setCustomData("CNTRs", cntrs);
			eventResponse.setCustomData("MNL_CNTRs", mnlCntrs);
			
			eventResponse.setCustomData("AUTO_FPs", autoFPs);
						
//			((IF_ESD_TES_200EventResponse)eventResponse).setFMVNDR(FM_VNDR_SEQ);
//			((IF_ESD_TES_200EventResponse)eventResponse).setHDR(HDR);
//			((IF_ESD_TES_200EventResponse)eventResponse).setDTLs(DTLs);
//			((IF_ESD_TES_200EventResponse)eventResponse).setCNTRs(CNTRs);
//			((IF_ESD_TES_200EventResponse)eventResponse).setMNLCNTRs(MNL_CNTRs);
//			((IF_ESD_TES_200EventResponse)eventResponse).setAUTOFPs(AUTO_FPs);
			
			log.debug("\n\n END - BCimpl.getEDIinvoiceInTESformat - ########################################### ");
			
		} catch (java.io.IOException e){
			log.error(e.getMessage());
			try {
				if (br!=null) {
					br.close();
				}
			} catch (java.io.IOException ie){
				log.error(ie.getMessage());
				throw new EventException(ie.getMessage());
			}
			throw new EventException(e.getMessage());
		} catch (Exception e){
			log.error(e.getMessage());
			try {
				if (br!=null) {
					br.close();
				}
			} catch (java.io.IOException ie){
				log.error(ie.getMessage());
				throw new EventException(ie.getMessage());
			}
			throw new EventException(e.getMessage());
		} finally {
			try {
				if (br!=null) {
					br.close();
				}
			} catch (java.io.IOException ie){
				log.error(ie.getMessage());
				throw new EventException(ie.getMessage());
			}
		}
		
		return eventResponse;
	}

	/**
	 * 2009-08-27 : [PJM-200900072] 부산신항만(180020)일 경우 AUTO FREEPOOL목록 추가
	 * EDI 기본 정보만 우선 TMP에 넣기
	 * 
	 * @param eventResponse
	 * @exception EventException
	 */
	public void createEDIinvoiceTmpData(EventResponse eventResponse) throws EventException { 
		log.error("\n\n BEGIN - BCimpl.createEDIinvoiceTmpData - ########################################### ");
		
		try {
			dbDao.getSoSeq(eventResponse);
			dbDao.getVndrOfcCd(eventResponse);
			
		} catch(DAOException e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		} catch(Exception e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		}
		log.error("\n\n END - BCimpl.createEDIinvoiceTmpData - ########################################### ");
	}

	/**
	 * 2009-08-27 : [PJM-200900072] 부산신항만(180020)일 경우 AUTO FREEPOOL목록 추가
	 * EDI 기본 정보만 우선 TMP에 넣기
	 * 
	 * @param eventResponse
	 * @exception EventException
	 */
	public void createEDInvoiceHDRTmpData(EventResponse eventResponse) throws EventException { 
		log.error("\n\n BEGIN - BCimpl.createEDInvoiceHDRTmpData - ########################################### ");
		
		try {
			String[] tab_cols = null; 
				
			/* HDR정보 넣기 */
			tab_cols = dbDao.getTabColumns("TES_EDI_SO_HDR");
			dbDao.createEDInvoiceHDRTmpData(eventResponse, tab_cols);
			log.error(" \n createEDInvoiceHDRTmpData - done");

		} catch(DAOException e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		} catch(Exception e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		}
		log.error("\n\n END - BCimpl.createEDInvoiceHDRTmpData - ########################################### ");
	}
	
	/**
	 * 2009-08-27 : [PJM-200900072] 부산신항만(180020)일 경우 AUTO FREEPOOL목록 추가
	 * EDI 기본 정보만 우선 TMP에 넣기
	 * 
	 * @param eventResponse
	 * @exception EventException
	 */
	public void createEDInvoiceCNTRTmpData(EventResponse eventResponse) throws EventException { 
		log.error("\n\n BEGIN - BCimpl.createEDInvoiceCNTRTmpData - ########################################### ");
		
		try {
			String[] tab_cols = null; 
				
			/* CNTR정보 넣기 */
			tab_cols = dbDao.getTabColumns("TES_EDI_SO_CNTR_LIST");
			dbDao.createEDInvoiceCNTRTmpData(eventResponse, tab_cols);
			log.error(" \n createEDInvoiceCNTRTmpData - done");

		} catch(DAOException e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		} catch(Exception e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		}
		log.error("\n\n END - BCimpl.createEDInvoiceCNTRTmpData - ########################################### ");
	}
	
	/**
	 * 2009-08-27 : [PJM-200900072] 부산신항만(180020)일 경우 AUTO FREEPOOL목록 추가
	 * EDI 기본 정보만 우선 TMP에 넣기
	 * 
	 * @param eventResponse
	 * @exception EventException
	 */
	public void createEDInvoiceDTLTmpData(EventResponse eventResponse) throws EventException { 
		log.error("\n\n BEGIN - BCimpl.createEDInvoiceDTLTmpData - ########################################### ");
		
		try {
			String[] tab_cols = null; 
			
			/* DTL정보 넣기 */
			tab_cols = dbDao.getTabColumns("TES_EDI_SO_DTL");
			dbDao.createEDInvoiceDTLTmpData(eventResponse, tab_cols);
			log.error(" \n createEDInvoiceDTLTmpData - done");

		} catch(DAOException e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		} catch(Exception e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		}
		log.error("\n\n END - BCimpl.createEDInvoiceDTLTmpData - ########################################### ");
	}
	
	/**
	 * 2009-08-27 : [PJM-200900072] 부산신항만(180020)일 경우 AUTO FREEPOOL목록 추가
	 * EDI 기본 정보만 우선 TMP에 넣기
	 * 
	 * @param eventResponse
	 * @exception EventException
	 */
	public void createEDInvoiceAUTOFPTmpData(EventResponse eventResponse) throws EventException { 
		log.error("\n\n BEGIN - BCimpl.createEDInvoiceAUTOFPTmpData - ########################################### ");
		
		try {
			String[] tab_cols = null; 
				
			/* AUTO FP정보 넣기 */
			tab_cols = dbDao.getTabColumns("TES_EDI_SO_AUTO_FREE_POOL");
			dbDao.createEDInvoiceAUTOFPTmpData(eventResponse, tab_cols);
			log.error(" \n createEDInvoiceAUTOFPTmpData - done");

		} catch(DAOException e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		} catch(Exception e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		}
		log.error("\n\n END - BCimpl.createEDInvoiceAUTOFPTmpData - ########################################### ");
	}
	
	/**
	 * 2009-08-27 : [PJM-200900072] 부산신항만(180020)일 경우 MANUAL CNTR목록 추가
	 * EDI 추가 사항 처리 - 여기서는 최소한 원본 회손이 없는 작업만 진행한다.
	 * 
	 * @param er EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public void createEDIinvoiceTmpData2(EventResponse er) throws EventException { 

		log.debug("\n\n BEGIN - BCimpl.createEDIinvoiceTmpData2 - ########################################### ");
		GeneralEventResponse eventResponse = (GeneralEventResponse)er;
		
		HashMap<String, String> hdr = (HashMap<String, String>)eventResponse.getCustomData("HDR");
		String vndrSeq	= hdr!=null&&hdr.containsKey("VNDR_SEQ")?JSPUtil.getNull((String)hdr.get("VNDR_SEQ")):"";
		
		try {
			/**
			 * VNDR_SEQ - HIT: 158002(HKGBB), YICT: 114776(SZPBB), 부산신항만: 180020(PUSBO)
			 */			
			log.error("\n\n ---- e createEDIinvoiceTmpData2 - vndrSeq: "+(vndrSeq!=null?vndrSeq:"")+"<<<<<<\n\n");
			log.debug("\n\n ---- d createEDIinvoiceTmpData2 - vndrSeq: "+(vndrSeq!=null?vndrSeq:"")+"<<<<<<\n\n");
			/*  YD를 기준으로 기본 COST_OFC를 찾아 넣기 - HIT의 경우 COST_OFC를 별도로 받지 않는다. */
			dbDao.updateEDInvoiceTmpCostOfc(eventResponse);

			if (vndrSeq!=null && (vndrSeq.trim().equals("158002") || vndrSeq.trim().equals("114776"))){
				/* VNDR Tariff를 사용해야하는 경우에는 VNDR Tariff에 해당하는 SML COST CODE를 조회하여 넣기   */
				dbDao.updateEDInvoiceDTLTmpLGSCostCode(eventResponse);
			}
//			if (vndrSeq!=null && (vndrSeq.trim().equals("180020") || vndrSeq.trim().equals("186666"))){
				/* MNL CNTR정보 넣기  - 수동비용에 대한 증빙용 CNTR이므로 부수 정보로 취급한다. */
				String[] tab_cols = dbDao.getTabColumns("TES_EDI_SO_MNL_CNTR_LIST");
				dbDao.createEDInvoiceMNLCNTRTmpData(eventResponse, tab_cols);
//			}
		} catch(DAOException e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		} catch(Exception e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		}
		
		log.debug("\n\n END - BCimpl.createEDIinvoiceTmpData2 - ########################################### ");
	}
	
	/**
	 * ESD 업무 시나리오 마감작업<br>
	 * TPBInterface업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}