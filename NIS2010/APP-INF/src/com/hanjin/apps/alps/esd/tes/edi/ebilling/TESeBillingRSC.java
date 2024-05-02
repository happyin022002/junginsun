/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TESeBillingRSC.java
*@FileTitle : TES eBilling EDI 처리용 RSC
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2012-01-04 
=========================================================*/
package com.hanjin.apps.alps.esd.tes.edi.ebilling;

import org.apache.log4j.Logger;

import java.util.List;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

import com.hanjin.apps.alps.esd.tes.edi.ebilling.event.TESeBillingEvent;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.basic.TESeBillingCommonBC;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.basic.TESeBillingCommonBCImpl;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.basic.TESeBillingManageBC;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.util.TESeBillingManageUtil;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.vo.ComTesEdiRcvRuleMnVO;
import com.hanjin.syscommon.common.table.TesEdiSoErrLogVO;
import com.hanjin.syscommon.common.table.TesEdiSoHdrVO;

/**
 * ENIS-BIZCOMMON Business Logic ServiceCommand<br>
 * - ENIS-BIZCOMMON에 대한 비지니스 트랜잭션을 처리한다.<br>
 *
 * @author 
 * @see COM_ENS_0A1EventResponse,VesselDBDAO 참조
 * @since J2EE 1.4
 */
public class TESeBillingRSC extends ServiceCommandSupport {

	private static Logger log = Logger.getLogger(TESeBillingRSC.class.getName());
	
	// Login User Information
    private SignOnUserAccount account = null;

    /**
     * BIZCOMMON 업무 시나리오 선행작업<br>
     * Vessel업무 시나리오 호출시 관련 내부객체 생성<br>
     */
    public void doStart() {
        try {
            account=getSignOnUserAccount();
        } catch (Exception e) {
            log.error("BizCommonSC 선행 작업 시 오류 " + e.toString(), e);
        }
    }

    /**
     * BIZCOMMON 업무 시나리오 마감작업<br>
     * Vessel업무 시나리오 종료시 관련 내부객체 해제<br>
     */
    public void doEnd() {
        log.debug("TESeBillingRSC 종료");
    }

    /**
     * test용
     * @param args
     */
//    public static void main(String[] args){
//    	
//    	try {
//    		log.debug(" \n bbbbbb \n");
//
////    		String arg = "HKG";
////    		//SET TEST
////    		String mzd_nm = "setTmlSoOfcCtyCd"; //EDI RULE에서 PK명을 받아 SETTER명을 구성한다.
////    		Class cls = Class.forName("com.hanjin.syscommon.common.table.TesEdiSoHdrVO"); // TABLE VO명으로 CLASS생성(TABLE명으로 구성 가능)
//////    		Class cls = TesEdiSoHdrVO.class;
////    		Class[] cnst_param_tps = new Class[]{}; //VO의 인자는 전부 String이다.
////    		Constructor cnst = cls.getConstructor(cnst_param_tps);
////    		Object nobj = cnst.newInstance(new Object[]{});
////    		Class[] mzd_param_tps = new Class[]{};
////    		mzd_param_tps = new Class[]{String.class};
////    		Method method = cls.getMethod(mzd_nm, mzd_param_tps);
////    		Object[] mzd_params = new Object[]{arg};
////    		method.invoke(nobj, mzd_params);
////    		
////    		//GET TEST
//////    		TesEdiSoHdrVO x = (TesEdiSoHdrVO)nobj;
//////    		x.getTmlEdiSoOfcCtyCd();
//////    		log.debug(" \n retval : "+(x!=null?x.getTmlSoOfcCtyCd():"XXX")+"\n");
////
////    		//GET TEST2
////    		String mzd_nm2 = "getTmlSoOfcCtyCd"; 
////    		Class[] mzd_param_tps2 = new Class[]{};
////    		method = cls.getMethod(mzd_nm2, mzd_param_tps2);
////    		mzd_params = new Object[]{};
////    		String retval = (String)method.invoke(nobj, mzd_params);
////    		log.debug(" \n retval : "+(retval!=null&&!retval.trim().equals("")?retval:"NNN")+"\n");
//    		
//			log.debug(" \n eeeeee \n");
//			
////    	} catch (ClassNotFoundException e){
////    		log.error("\n MAIN cls not found EXCEPTION!!");
//    	} catch (Exception e){
//			log.error("\n MAIN EXCEPTION!!");
//		}
//    }
    
    
    /**
     * eBilling EDI Invoice 접수
     * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
    public EventResponse perform(Event e) throws EventException {
        log.debug("\n RSC.TESInterfaceRSC perform -> ====================================");

        EventResponse eventResponse = null;

        /*
         * BizCommonSC에 사용법
         * 1. 각각의 업무에 를 통합하는 SC로써 각 업무에 대한 로직은 아래와 같이 작성한다.
         * 2. BC에 대한 각 업무단 BC를 참조하여야 한다.
         * */
        if (e.getEventName().equalsIgnoreCase("TESeBillingEvent")){
        	log.debug("\n RSC.TESInterfaceRSC ::::::: TESeBillingEvent");
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH01)){
        		eventResponse = createEbillingEDIinvoice(e);
        	}
        }
        
        return eventResponse;
    }

	/**
	 * EDI invoice 접수 - 전문 추출/저장/유효성 확인
	 * 
	 * <중> 개발 목적: 
	 * 1) 유지 보수 편의 : 적절한 공통화 및 개별 구현 수정시 타VNDR에 영향 최소화 
	 * 2) 신규 개발 용이 : 동일 TYPE의 개발 내용 개발 용이 및 신규 TYPE 개발 편의성
	 * 
	 * @param event
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse createEbillingEDIinvoice(Event event) throws EventException {
		log.error("\n\n RSC.createEbillingEDIinvoice(Event e) --- BEGIN \n\n");
 
		TESeBillingCommonBC tes_com_command = null;
		EventResponse eventResponse = new GeneralEventResponse();
		TesEdiSoErrLogVO tesEdiErrLogVO = null;
		TesEdiSoHdrVO tesEdiInitVO = null;
		ComTesEdiRcvRuleMnVO tesEdiRuleMainVO = null;
		String str_ffs = null;
		String[] arr_ffs = null;		
		String tml_inv_edi_seq = null;
		
		/**
		 * ---------------------------------------------------------------------------
		 * 목적: eBilling EDI invoice 수신은 S/P를 대상으로 하는데,
		 * 		동시에 복수개의 S/P 대상으로 개발을 해야하는 요구사항을 처리하고,
		 * 		향후 몇년간 대상 S/P가 대략 20~30여개 이상으로 확대될 전망.
		 * 		S/P의 전문이 통일되지 않고 다양하며, 경우에 따라서는 S/P의 Private format을 그대로
		 * 		사용해야합에 다른 S/P와는 많이 다르게 구현이 요구되는 경우도 있어서, 
		 * 		공통적인 부분은 모으고, 서로 관련이 최대한 없는 부분은 TYPE별로 분리하여, 유지 및 보수시에도 TYPE간에 영향이 적도록 하도록 도모함
		 * --------------------------------------------------------------------------- 
		 */
		
		try {
			/**
			 * 1. F/F이 존재한다면 tml_inv_edi_seq가 생성됨
			 * 2. tml_inv_edi_seq는 모든 F/F당 필수값으로 정상적으로 생성이 되었다면 하기 작업 처리
			 * 		a) LOOP: 분해 및 임시저장 -> EDI RULE에 따라 STR[]로 쪼개어 사용 -> tml_inv_edi_seq는 모든 F/F당 필수값으로 사용
			 * 		b) a)에서 임시 저장된 F/F을 INVOICE단위로 SESSION KEY로 조회하여 전부 가져온다
			 * 		c) LOOP: 추가 작업   -> tml_inv_edi_seq별 invoice를 구하여 invoice별로 처리
			 * 		         유효성 확인 -> tml_inv_edi_seq별 invoice를 구하여 invoice별로 처리
			 * <중> 세단계의 과정이 이해가 되지 않으면 함부로 수정하지 않도록 주의!!
			 */
			
			tesEdiErrLogVO = new TesEdiSoErrLogVO();
			
			str_ffs = (event!=null?((TESeBillingEvent)event).getStr().trim():"");
			
			if (str_ffs!=null && !str_ffs.trim().equals("")){
				
				tes_com_command = new TESeBillingCommonBCImpl();
				
				tesEdiInitVO = new TesEdiSoHdrVO();
				TESeBillingManageUtil.getNSetEDIMsgInfo(str_ffs, tesEdiInitVO);
				if (tesEdiInitVO!=null){
					if (tesEdiInitVO.getSndrId()==null || tesEdiInitVO.getSndrId().trim().equals("")){
						log.error("\n NO SNDR ID found in EDI MSG \n");
						throw new EventException("\n NO SNDR ID found in EDI MSG \n");
					}
				} else {
					log.error("\n Initial VO object is NULL Exception \n");
					throw new EventException("\n Initial VO object is NULL Exception \n");
				}
				
				tesEdiRuleMainVO = tes_com_command.getEdiMainRule(tesEdiInitVO);
				
				if (tesEdiRuleMainVO!=null){
					if (!TESeBillingManageUtil.checkTagValidation(str_ffs, tesEdiRuleMainVO)){
						log.error("\n TESeBillingRSC.createEbillingEDIinvoice - TAG VALIDATION FAILURE!!!!  \n");
						throw new Exception("\n TAG VALIDATION FAILURE! \n");
					} else {
						log.error("\n TAG VALIDATION SUCCESS!!!! \n");
					}
					
					/**
					 *  수신된 F/F에 포함된 INVOICE단위로 DATA를 조회해서 배열로 가져온다
					 */
					arr_ffs = TESeBillingManageUtil.getEDIInvoiceStrs(str_ffs, tesEdiRuleMainVO);
					log.debug("\n >>>>> TESeBillingRSC.createEbillingEDIinvoice - arr_ffs.length:"+(arr_ffs!=null?arr_ffs.length:0)+"<<<<< \n");
					
					if (arr_ffs!=null && arr_ffs.length>0){
						
						/** 앞으로는 모든 F/F 수신시에 SESSION KEY로써 tml_inv_edi_seq를 항상 구한다.**/
						tml_inv_edi_seq = tes_com_command.createTmlInvEdiSeq();
						log.debug("\n >>>>> TESeBillingRSC.createEbillingEDIinvoice - tml_inv_edi_seq:"+(tml_inv_edi_seq!=null?tml_inv_edi_seq:"")+"<<<<< \n");
						
						if (tml_inv_edi_seq!=null && !tml_inv_edi_seq.trim().equals("")){
							
							eventResponse.setCustomData(TESeBillingCommonBC.TML_INV_EDI_SEQ, tml_inv_edi_seq); 
							tesEdiInitVO.setTmlInvEdiSeq(tml_inv_edi_seq);
							
							/*** 
							 * <중> 항상 tml_inv_edi_seq를 구해서 현재 F/F의 SESSION KEY로 활용한다.
							 * 
							 * 1. 여기서는 F/F 분해 및 임시 저장까지만 한다.
							 ***/
							for (int x=0; arr_ffs!=null && x<arr_ffs.length; x++){
								processEDIinvoice01(arr_ffs[x], tesEdiInitVO, tesEdiRuleMainVO);
								continue;
							}
							
							/**
							 * 2. 앞서 F/F을 INVOICE단위로 전부 임시저장한 대상을 SESSION KEY로 조회하여 전부 가져온다.
							 */
							List<TesEdiSoHdrVO> lt_invVOs = tes_com_command.getEDIInvoiceList(eventResponse);
							log.debug("\n ---- lt_invVOs.SIZE:"+(lt_invVOs!=null?lt_invVOs.size():0)+"<<<<< \n");
							
							/**
							 * 3. 조회된 INVOICE를 가져와서 INVOICE단위로 후속 작업을 한다. (추가 작업 및 유효성 확인 작업)
							 */
							for (int i=0; lt_invVOs!=null && lt_invVOs.size()>0 && i<lt_invVOs.size(); i++){
								processEDIinvoice02(lt_invVOs.get(i), tesEdiInitVO, tesEdiRuleMainVO);
								continue;
							}
							
						} else {
							log.error("\n NO tml_inv_edi_seq found \n");
							throw new EventException("\n NO tml_inv_edi_seq found \n");
						}
						
					} else {
						log.error("\n NO EDI F/Fs found \n");
						throw new EventException("\n NO EDI RULE found \n");
					}
					
				} else {
					log.error("\n NO EDI RULE found \n");
					throw new EventException("\n NO EDI RULE found \n");
				}
			
			}

		} catch (EventException ee) {
			if (tesEdiErrLogVO!=null){
				tesEdiErrLogVO.setEdiMsg(tesEdiInitVO!=null?JSPUtil.getNull(tesEdiInitVO.getEdiMsg()):"");
				tesEdiErrLogVO.setTmlInvEdiSeq(tesEdiInitVO!=null?JSPUtil.getNull(tesEdiInitVO.getTmlInvEdiSeq()):"");
				tesEdiErrLogVO.setErrLogRmk(ee.getMessage().substring(0,ee.getMessage().length()>=1000?1000:ee.getMessage().length()-1));
				try {
					begin();
					tes_com_command.logEDIErrMsg(tesEdiErrLogVO);
					commit();
				} catch(Exception e){
					rollback();
					log.error("\n TESeBillingRSC.createEbillingEDIinvoice - logEDIErrMsg err " + e.toString(), e);
					throw new EventException(e.getMessage());
				}
			} else {
				log.error("\n tesEdiErrLogVO NULL EXCEPTION!!!!!!! \n ");
			}
			log.error("err " + ee.toString(), ee);
			throw ee;			
		} catch (Exception de) {
			if (tesEdiErrLogVO!=null){
				tesEdiErrLogVO.setEdiMsg(tesEdiInitVO!=null?JSPUtil.getNull(tesEdiInitVO.getEdiMsg()):"");
				tesEdiErrLogVO.setTmlInvEdiSeq(tesEdiInitVO!=null?JSPUtil.getNull(tesEdiInitVO.getTmlInvEdiSeq()):"");
				tesEdiErrLogVO.setErrLogRmk(de.getMessage().substring(0,de.getMessage().length()>=1000?1000:de.getMessage().length()-1));
				try {
					begin();
					tes_com_command.logEDIErrMsg(tesEdiErrLogVO);
					commit();
				} catch(Exception e){
					rollback();
					log.error("\n TESeBillingRSC.createEbillingEDIinvoice - logEDIErrMsg err " + e.toString(), e);
					throw new EventException(e.getMessage());
				}
			} else {
				log.error("\n tesEdiErrLogVO NULL EXCEPTION!!!!!!! \n ");
			}
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		eventResponse.setETCData("successFlag", "SUCCESS");
		
		log.error("\n\n RSC.createEbillingEDIinvoice(Event e) --- END \n\n");
		
		return eventResponse;
	}
    
	/**
	 * # R4J님이 뭐라 해서.. try catch문에서 throw절을 생략하기 위해 그냥 method로 뺀다. 빼면 안 걸린단다...
	 * 
	 * 인자로 받는 str은 개별 INVOICE에 해당하는 F/F 단위로 받는다. F/F은 하나의 INVOICE정보만 처리한다는 야그...
	 * 
	 * @param str_ff
	 * @param tesEdiInitVO
	 * @param tesEdiRuleVO
	 */
	private void processEDIinvoice01(String str_ff, TesEdiSoHdrVO tesEdiInitVO, ComTesEdiRcvRuleMnVO tesEdiRuleMainVO) {
		
		log.error("\n\n\n\n RSC.processEDIinvoice01() --- BBBB  \n\n");
		
		EventResponse er = null;
		TESeBillingManageBC tes_command01 = null;
		TesEdiSoErrLogVO tesEdiErrLogVO = null;
		
		try {
			tesEdiErrLogVO = new TesEdiSoErrLogVO();
			if (str_ff!=null && !str_ff.trim().equals("")) {
				
				if (tesEdiRuleMainVO!=null) {
					TESeBillingManageUtil.getSetEdiVndrCode(tesEdiInitVO, str_ff);
					log.debug("\n"+" TESeBillingManageUtil.getSetEdiVndrCode -> tesEdiInitVO.getVndrSeq() : "+(tesEdiInitVO.getVndrSeq()!=null && !tesEdiInitVO.getVndrSeq().trim().equals("") ? tesEdiInitVO.getVndrSeq() : "")+"\n");
					if (tesEdiInitVO.getVndrSeq()!=null && !tesEdiInitVO.getVndrSeq().trim().equals("")){
						new TESeBillingManageUtil().getSetEdiVndrRules(tesEdiInitVO, tesEdiRuleMainVO);
					} else {
						log.debug("\n No EDI VNDR Rule fetch Exception!!! \n ");
						throw new Exception("No EDI VNDR Rule fetch Exception!!!");
					}
					log.debug("\n TESeBillingManageUtil().getSetEdiVndrRules - done! \n ");
					
					/* DETAIL구분을  BCIMPL내에서 할 경우 ... 요것  */
					/* VO에 SNDR ID가 꼭 넘어가야 한다. SNDR ID로 BCImpl이 정해진다. 혹 나중에 구주의 요구사항으로 각각의 VNDR가 필요한 경우 VNDR를 넘겨 참조하게 하면 된다.  */
					tes_command01 = TESeBillingManageUtil.getBcInstance(tesEdiRuleMainVO.getComTesEdiRcvRuleVndrMgmtVO());
					log.debug("\n TESeBillingManageUtil().getBcInstance - done! \n ");
					if (tes_command01!=null){

						/* ER 초기화 + F/F 담기  */
						er = new GeneralEventResponse();
						er.setCustomData(TESeBillingCommonBC.FLT_FILE, str_ff);
						er.setCustomData(TESeBillingCommonBC.EDI_RULE_MAIN, tesEdiRuleMainVO);
						er.setCustomData(TESeBillingCommonBC.EDI_INIT_VO, tesEdiInitVO);
						
						/* F/F 분해 */
						tes_command01.getEDIInvoiceInTESformat(er);
						
						/* 분해된 F/F을 임시 저장 */
						begin();
						tes_command01.createEDIInvoiceData(er);
						commit();
						
					} else {
						log.debug("\n No BCImpl class found!!! \n");
						throw new Exception("\n No BCImpl class found!!! \n ");
					}	
				} else {
					log.debug("\n No EDI MAIN RULE found!!! \n");
					throw new Exception("\n No EDI MAIN RULE found!!! \n");
				}
			} else {
				log.debug("\n No EDI Invoice F/F found!!! \n");
				throw new Exception("\n No EDI Invoice F/F found!!! \n");
			}
			
		} catch (EventException de) {
			rollback();
			log.error("\n rollback - err \n" + de.toString(), de);
			if (tesEdiErrLogVO!=null){
				tesEdiErrLogVO.setEdiMsg(tesEdiInitVO!=null?JSPUtil.getNull(tesEdiInitVO.getEdiMsg()):"");
				tesEdiErrLogVO.setTmlInvEdiSeq(tesEdiInitVO!=null?JSPUtil.getNull(tesEdiInitVO.getTmlInvEdiSeq()):"");
				tesEdiErrLogVO.setErrLogRmk(de.getMessage().substring(0,de.getMessage().length()>=1000?1000:de.getMessage().length()-1));
				try {
					begin();
					new TESeBillingManageUtil().logEDIErrMsg(tesEdiErrLogVO);
					commit();
				} catch (Exception e) { 
					rollback();
					log.error("\n TESeBillingRSC.processEDIinvoice01 - logEDIErrMsg err: " + e.toString(), e);
				}
			} else {
				log.error("\n tesEdiErrLogVO NULL EXCEPTION!!!!!!! \n ");
			}
		} catch (Exception de) {
			rollback();
			log.error("\n rollback - err \n" + de.getMessage(), de);
			if (tesEdiErrLogVO!=null){
				tesEdiErrLogVO.setEdiMsg(tesEdiInitVO!=null?JSPUtil.getNull(tesEdiInitVO.getEdiMsg()):"");
				tesEdiErrLogVO.setTmlInvEdiSeq(tesEdiInitVO!=null?JSPUtil.getNull(tesEdiInitVO.getTmlInvEdiSeq()):"");
				tesEdiErrLogVO.setErrLogRmk(de.getMessage().substring(0,de.getMessage().length()>=1000?1000:de.getMessage().length()-1));
				try {
					begin();
					new TESeBillingManageUtil().logEDIErrMsg(tesEdiErrLogVO);
					commit();
				} catch (Exception e) {
					rollback();
					log.error("\n TESeBillingRSC.processEDIinvoice01 - logEDIErrMsg err: " + e.toString(), e);
				}				
			} else {
				log.error("\n tesEdiErrLogVO NULL EXCEPTION!!!!!!! \n ");
			}
		}
		log.error("\n\n RSC.processEDIinvoice01() --- EEEE  \n\n");
	}
	
	/**
	 * # R4J님이 뭐라 해서.. try catch문에서 throw절을 생략하기 위해 그냥 method로 뺀다. 빼면 안 걸린단다...
	 * 
	 * 인자로 받는 lt_inv은 개별 INVOICE에 해당하는 VO 이다.
	 * 
	 * @param invVO
	 * @param tesEdiInitVO
	 * @param tesEdiRuleMainVO
	 */
	private void processEDIinvoice02(TesEdiSoHdrVO invVO, TesEdiSoHdrVO tesEdiInitVO, ComTesEdiRcvRuleMnVO tesEdiRuleMainVO) {
		log.error("\n\n\n\n RSC.processEDIinvoice02() --- BBBB  \n\n");
		
		EventResponse er = null;
		TESeBillingManageBC tes_command02 = null;
		TesEdiSoErrLogVO tesEdiErrLogVO = null;
		
		try {
			tesEdiErrLogVO = new TesEdiSoErrLogVO();
			if (invVO!=null && tesEdiRuleMainVO!=null){
				
				if (invVO!=null && invVO.getVndrSeq()!=null && !invVO.getVndrSeq().trim().equals("")){
					new TESeBillingManageUtil().getSetEdiVndrRules(invVO, tesEdiRuleMainVO);
				} else {
					log.debug("\n No EDI VNDR Rule fetch Exception!!! \n");
					throw new Exception("\n No EDI VNDR Rule fetch Exception!!! \n");
				}

				if (tesEdiRuleMainVO.getComTesEdiRcvRuleVndrMgmtVO()!=null){
					
					tes_command02 = TESeBillingManageUtil.getBcInstance(tesEdiRuleMainVO.getComTesEdiRcvRuleVndrMgmtVO());
					
					if (tes_command02!=null){
						/* ER 초기화 + F/F 담기  */
						er = new GeneralEventResponse();
						er.setCustomData(TESeBillingCommonBC.INV_HDR, invVO);
						er.setCustomData(TESeBillingCommonBC.EDI_RULE_MAIN, tesEdiRuleMainVO);
						er.setCustomData(TESeBillingCommonBC.EDI_INIT_VO, tesEdiInitVO);
						
						/* EDI INV 임시 저장 후 바로 추가 작업  */
						begin();
						tes_command02.createEDIInvoiceData2(er);
						commit();
						
						/* 저장된 임시 data의 유효성 확인 */
						begin();
						tes_command02.validateEDIInvoice(er);
						commit();
						
					} else {
						throw new Exception("No BCImpl class found!!!");
					}			
				}
				
			} else {
				throw new Exception("No EDI DETAIL RULE found!!!");
			}

		} catch (EventException de) {
			rollback();
			log.error("\n rollback - err " + de.getMessage(), de);
			if (tesEdiErrLogVO!=null){
				tesEdiErrLogVO.setEdiMsg(tesEdiInitVO!=null?JSPUtil.getNull(tesEdiInitVO.getEdiMsg()):"");
				tesEdiErrLogVO.setTmlInvEdiSeq(tesEdiInitVO!=null?JSPUtil.getNull(tesEdiInitVO.getTmlInvEdiSeq()):"");
				tesEdiErrLogVO.setErrLogRmk(de.getMessage().substring(0,de.getMessage().length()>=1000?1000:de.getMessage().length()-1));
				try {
					begin();
					new TESeBillingManageUtil().logEDIErrMsg(tesEdiErrLogVO);
					commit();
				} catch (Exception e) { 
					rollback();
					log.error("\n TESeBillingRSC.processEDIinvoice02 - logEDIErrMsg err: " + e.toString(), e);
				}				
			} else {
				log.error("\n tesEdiErrLogVO NULL EXCEPTION!!!!!!! \n ");
			}
		} catch (Exception de) {
			rollback();
			log.error("\n rollback - err " + de.getMessage(), de);
			if (tesEdiErrLogVO!=null){
				tesEdiErrLogVO.setEdiMsg(tesEdiInitVO!=null?JSPUtil.getNull(tesEdiInitVO.getEdiMsg()):"");
				tesEdiErrLogVO.setTmlInvEdiSeq(tesEdiInitVO!=null?JSPUtil.getNull(tesEdiInitVO.getTmlInvEdiSeq()):"");
				tesEdiErrLogVO.setErrLogRmk(de.getMessage().substring(0,de.getMessage().length()>=1000?1000:de.getMessage().length()-1));
				try {
					begin();
					new TESeBillingManageUtil().logEDIErrMsg(tesEdiErrLogVO);
					commit();
				} catch (Exception e) { 
					rollback();
					log.error("\n TESeBillingRSC.processEDIinvoice02 - logEDIErrMsg err: " + e.toString(), e);
				}				
			} else {
				log.error("\n tesEdiErrLogVO NULL EXCEPTION!!!!!!! \n ");
			}
		}
		log.error("\n\n RSC.processEDIinvoice02() --- EEEE  \n\n");
	}

}