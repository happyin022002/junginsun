/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationMasterDataMgtSC.java
*@FileTitle : Settlement Item & Account Code List
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.clt.apps.opus.bcm.sup.valuemanage.util.OfficeCodeMgr;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.basic.RenewalMasterDataMgtBC;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.basic.RenewalMasterDataMgtBCImpl;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.event.FnsJoo0088Event;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.event.FnsJoo0089Event;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.event.FnsJoo0090Event;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.vo.AuthorityCarrierVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.vo.CarrierVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.vo.FinancialAffairsMtxVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.vo.MstConditionVO;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.basic.JOOFindCodeAndCheckBC;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.basic.JOOFindCodeAndCheckBCImpl;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeInfoVO;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeParamVO;
import com.clt.apps.opus.fns.joo.joocommonutil.JooConstants;
import com.clt.bizcommon.util.BizComUtil;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.StringUtil;
import com.clt.framework.component.util.code.CodeInfo;
import com.clt.framework.component.util.code.CodeUtil;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-JointOperationMasterDataMgtSC Business Logic ServiceCommand - handling business transaction
 * 
 * @author
 * @see RenewalMasterDataMgtBCDBDAO
 * @since J2EE 1.4
 */

public class RenewalMasterDataMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * JointOperationMasterDataMgtSC system : preceding process for biz scenario<br>
	 */
	public void doStart() {
		try {
			// checking login
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	/**
	 * JointOperationMasterDataMgtSC system : biz scenario closing<br>
	 */
	public void doEnd() {
		log.debug("RenewalMasterDataMgtSC 종료");
	}

	/**
	 * 
	 * OPUS-RenewalMasterDataMgtSC system <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		if (e.getEventName().equalsIgnoreCase("FnsJoo0088Event")) {

            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = openFnsJoo0088(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchCarrierList(e);  //search
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageCarrier(e); //save
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = checkCarrierInfo(e); //carrier key in check.
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
                eventResponse = searchRevenueLaneInfo(e); //rlane_cd combo item search.
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
                eventResponse = searchVendorInfo(e); //vendor search.
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
                eventResponse = searchCustomerInfo(e); //customer search.
            }else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0088(e);				
			}
        } else if (e.getEventName().equalsIgnoreCase("FnsJoo0089Event")) { // Financial Affairs Matrix

            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchFinancialAffairsMtxList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = calculateFinancialAffairsMtxList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageFinancialAffairsMtx(e); //save
            }else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0089(e);				
			}
        }  else if (e.getEventName().equalsIgnoreCase("FnsJoo0090Event")) { // Authority Carrier 

        	if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchAuthorityCarrierList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageAuthorityCarrier(e); //save
            }else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0090(e);				
			}
        }
		
		return eventResponse;
	}
	
	
	/*================================================================================
	 * 2016.05.13 Renewal Add.
	 ================================================================================*/
    /**
     *  FNS_JOO_0088 : Open <br>
     *  retrieving Carrier Code<br>
     *  2016.05.13 Renewal Add.
     *
     * @throws EventException
     * @return EventResponse
     * @author 
     */
    @SuppressWarnings("unchecked")
	private EventResponse openFnsJoo0088(Event e) throws EventException {
        GeneralEventResponse eventResponse  = new GeneralEventResponse();
        try{
    		
            //Currency 
    		CodeUtil codeUtil = CodeUtil.getInstance();
    		Collection<CodeInfo> currList = codeUtil.getCodeSelect("CD02081", 0);
    		String currCombo[] = StringUtil.split(BizComUtil.getCodeSelectString(currList),BizComUtil.CODE_DELIMITTER);
            
            String joCrrCdCombo = this.searchConditionComboItemByAuthOfficeCd(JooConstants.KEY_COMBOITEM_FLG_CARRIER); //CARRIER
            String trdCdCombo 	= this.searchConditionComboItemByAuthOfficeCd(JooConstants.KEY_COMBOITEM_FLG_TRADE); //TRADE
            String rlaneCdCombo	= this.searchConditionComboItemByAuthOfficeCd(JooConstants.KEY_COMBOITEM_FLG_RLANE); //RLANE
            String authOfcCds 	= this.searchConditionComboItemByAuthOfficeCd(JooConstants.KEY_COMBOITEM_FLG_AUTH_OFC); //2016.07.26 권한 있는 Office 조회
            
    		eventResponse.setETCData("jo_crr_cds"   , joCrrCdCombo);
    		eventResponse.setETCData("trd_cds"   	, trdCdCombo);
    		eventResponse.setETCData("rlane_cds"   	, rlaneCdCombo);
    		eventResponse.setETCData("auth_ofc_cds" , authOfcCds);
    		eventResponse.setETCData("currency"  	, currCombo[0]);
        } catch (EventException ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }    
        return eventResponse;
    }
    
    /**
     * FNS_JOO_0088 : Retrieve
     * retrieving Carrier.<br>
     *  2016.05.13 Renewal Add.
     * 
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author 
     */
    private EventResponse searchCarrierList(Event e) throws EventException {
        FnsJoo0088Event event = (FnsJoo0088Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
    	try{
	        RenewalMasterDataMgtBC command = new RenewalMasterDataMgtBCImpl();
	        
	        List<CarrierVO> list = command.searchCarrierList(   event.getMstConditionVO() );
	        eventResponse.setRsVoList(list);
	        
    	} catch (EventException ex) {
    		log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    	return eventResponse;
    }
    
    /**
     * FNS_JOO_0088 : Sheet Carrier Check.
     * Sheet Carrier Check..<br>
     *  2016.05.13 Renewal Add.
     * 
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author 
     */
    private EventResponse checkCarrierInfo(Event e) throws EventException {
        FnsJoo0088Event event = (FnsJoo0088Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
    	try{
    		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();

    		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();
    		jooCodeParamVO.setCode(event.getMstConditionVO().getJoCrrCd());
    		
    		List<JooCodeInfoVO> list = command.searchVskCarrierList(jooCodeParamVO);

    		if (list.isEmpty()){
    			eventResponse.setETCData("CHECK", "E");
    			eventResponse.setETCData("CHKMSG", "Wrong Carrier");
    		}else{
    			eventResponse.setETCData("CHECK", "N");
    			eventResponse.setETCData("CHKMSG", "Normal");
    		}
	        
    	} catch (EventException ex) {
    		log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    	return eventResponse;
    }
    
    /**
     * FNS_JOO_0088 : Sheet Revenue Lane Search.
     * Sheet Carrier Check..<br>
     *  2016.05.13 Renewal Add.
     * 
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author 
     */
    private EventResponse searchRevenueLaneInfo(Event e) throws EventException {
        FnsJoo0088Event event = (FnsJoo0088Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
    	try{
    		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
    		
    		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();
    		jooCodeParamVO.setSuperCd1(event.getMstConditionVO().getTrdCd());
    		jooCodeParamVO.setSuperCd2(event.getMstConditionVO().getJoCrrCd());
    		jooCodeParamVO.setOfcCd(account.getOfc_cd());

    		List<JooCodeInfoVO> list = command.searchMdmRlaneCdList(jooCodeParamVO);
    		
    		String comboList = makeComboString(list, 2);
    		eventResponse.setETCData("rlane_cds" ,comboList);
	        
    	} catch (EventException ex) {
    		log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    	return eventResponse;
    }
    
    /**
     * FNS_JOO_0088 : Sheet Vendor Search.
     * Sheet Vendor..<br>
     *  2016.05.13 Renewal Add.
     * @param e
     * @return
     * @throws EventException
     */
	@SuppressWarnings("rawtypes")
	private EventResponse searchVendorInfo(Event e) throws EventException {
		FnsJoo0088Event event = (FnsJoo0088Event)e;
	    GeneralEventResponse eventResponse = new GeneralEventResponse();
	    try{
	    	JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
	    	JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();
	    	jooCodeParamVO.setCode(event.getMstConditionVO().getVndrSeq());
	    	
	    	List<JooCodeInfoVO> list = command.searchVendorList(jooCodeParamVO);
	    	Iterator iterator = (Iterator) list.iterator();
	    	
	    	String name = "";
			String code = "";
			while(iterator.hasNext()){
				JooCodeInfoVO jooCodeInfoVO = (JooCodeInfoVO)iterator.next();
				code = jooCodeInfoVO.getCode();
				name = jooCodeInfoVO.getName();
			}
			eventResponse.setETCData("vndr_seq" ,code);
			eventResponse.setETCData("vndr_lgl_eng_nm" ,name);
	    } catch (EventException ex) {
    		log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    	return eventResponse;
	}
    
    /**
     * FNS_JOO_0088 : Sheet Customer Search.
     * Sheet Customer..<br>
     *  2016.05.13 Renewal Add.
     * @param e
     * @return
     * @throws EventException
     */
	@SuppressWarnings("rawtypes")
	private EventResponse searchCustomerInfo(Event e) throws EventException {
		FnsJoo0088Event event = (FnsJoo0088Event)e;
	    GeneralEventResponse eventResponse = new GeneralEventResponse();
	    try{
	    	JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
	    	JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();
	    	jooCodeParamVO.setCode(event.getMstConditionVO().getCustCd());
	    	
	    	List<JooCodeInfoVO> list = command.searchCustomerList(jooCodeParamVO);
	    	Iterator iterator = (Iterator) list.iterator();
	    	
	    	String name = "";
			String code = "";
			while(iterator.hasNext()){
				JooCodeInfoVO jooCodeInfoVO = (JooCodeInfoVO)iterator.next();
				code = jooCodeInfoVO.getCode();
				name = jooCodeInfoVO.getName();
			}
			eventResponse.setETCData("cust_cd" ,code);
			eventResponse.setETCData("cust_lgl_eng_nm" ,name);
	    } catch (EventException ex) {
    		log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    	return eventResponse;
	}
    
    /**
     * FNS_JOO_0088 : Save
     * saving Carrier & Carrier Auth & Fin Mtx Creation<br>
     *  2016.05.13 Renewal Add.
     * 
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author 
     */
    private EventResponse manageCarrier(Event e) throws EventException {
        RenewalMasterDataMgtBC command = new RenewalMasterDataMgtBCImpl();
 
        FnsJoo0088Event event = (FnsJoo0088Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
 
        try {
            begin();
            
            command.manageCarrier( event.getCarrierVOs() , this.account);
             
            eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());            
            commit();
        } catch (EventException ex) {
            log.error("error "+ex.toString(), ex);
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }

        return eventResponse;
    }
    
    /**
     *  FNS_JOO_0089 : Open <br>
     *  retrieving Financial Affairs Matrix Open customer/vendor Name<br>
     *  2016.05.13 Renewal Add.
     *
     * @throws EventException
     * @return EventResponse
     * @author 
     */
	private EventResponse openFnsJoo0089(Event e) throws EventException {
        GeneralEventResponse eventResponse  = new GeneralEventResponse();
        try{
        	FnsJoo0089Event event = (FnsJoo0089Event)e;
            JOOFindCodeAndCheckBC    command    = new JOOFindCodeAndCheckBCImpl();
            
            //Customer nm
            String custNm = "";
            String vndrNm = "";
            JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();
            jooCodeParamVO.setCode(event.getMstConditionVO().getCustCd());
            List<JooCodeInfoVO> customerList   = command.searchCustomerList(jooCodeParamVO);
            if(customerList.size() > 0){
            	custNm = (String) customerList.get(0).getName();
            }
            
            //Service provider nm
            jooCodeParamVO.setCode(event.getMstConditionVO().getVndrSeq());
            List<JooCodeInfoVO> vndrList   = command.searchVendorList(jooCodeParamVO);
            if(vndrList.size() > 0){
            	vndrNm = (String) vndrList.get(0).getName();
            }
            
            //Currency 
            //CodeUtil codeUtil = CodeUtil.getInstance();
    		//Collection<CodeInfo> currList = codeUtil.getCodeSelect("CD02081", 0);
    		//String currCombo[] = StringUtil.split(BizComUtil.getCodeSelectString(currList),BizComUtil.CODE_DELIMITTER);

    		eventResponse.setETCData("cust_nm"   		, custNm);
    		eventResponse.setETCData("vndr_nm"   		, vndrNm);
    		//eventResponse.setETCData("locl_curr_cds"  	, currCombo[0]);
    		
        } catch (EventException ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }    
        return eventResponse;
    }
    
    /**
     * FNS_JOO_0089 : Retrieve
     * retrieving Financial Affairs Matrix.<br>
     *  2016.05.13 Renewal Add.
     * 
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author 
     */
    private EventResponse searchFinancialAffairsMtxList(Event e) throws EventException {
        FnsJoo0089Event event = (FnsJoo0089Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
    	try{
	        RenewalMasterDataMgtBC command = new RenewalMasterDataMgtBCImpl();
	        MstConditionVO mstConditionVO = event.getMstConditionVO();
	        
	        mstConditionVO.setReDivrCd("R");
	        List<FinancialAffairsMtxVO> revenueList = command.searchFinancialAffairsMtxList(mstConditionVO);
	        
	        mstConditionVO.setReDivrCd("E");
	        List<FinancialAffairsMtxVO> expenseList = command.searchFinancialAffairsMtxList(mstConditionVO);
	        
	        
	        eventResponse.setRsVoList(revenueList);
	        eventResponse.setRsVoList(expenseList);
	        
    	} catch (EventException ex) {
    		log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    	return eventResponse;
    }
    
    /**
     * FNS_JOO_0089 : Create
     * Create Financial Affairs Matrix.<br>
     *  2016.05.13 Renewal Add.
     * 
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author 
     */
    private EventResponse calculateFinancialAffairsMtxList(Event e) throws EventException {
        FnsJoo0089Event event = (FnsJoo0089Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
    	try{
	        RenewalMasterDataMgtBC command = new RenewalMasterDataMgtBCImpl();
	        MstConditionVO mstConditionVO = event.getMstConditionVO();
	        mstConditionVO.setOfcCd(this.account.getOfc_cd());
	        
	        mstConditionVO.setReDivrCd("R");
	        List<FinancialAffairsMtxVO> revenueList = command.calculateFinancialAffairsMtxList(mstConditionVO);
	        
	        mstConditionVO.setReDivrCd("E");
	        List<FinancialAffairsMtxVO> expenseList = command.calculateFinancialAffairsMtxList(mstConditionVO);
	        
	        
	        eventResponse.setRsVoList(revenueList);
	        eventResponse.setRsVoList(expenseList);
	        
    	} catch (EventException ex) {
    		log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    	return eventResponse;
    }
    
    /**
     * FNS_JOO_0089 : Save
     * saving Financial Affairs Matrix <br>
     *  2016.05.13 Renewal Add.
     * 
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author 
     */
    private EventResponse manageFinancialAffairsMtx(Event e) throws EventException {
        RenewalMasterDataMgtBC command = new RenewalMasterDataMgtBCImpl();
 
        FnsJoo0089Event event = (FnsJoo0089Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
 
        try {
            begin();
            
            command.manageFinancialAffairsMtx( event.getFinancialAffairsMtxGrpVO() , this.account);
             
            eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());            
            commit();
        } catch (EventException ex) {
            log.error("error "+ex.toString(), ex);
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }

        return eventResponse;
    }
	

    
    /**
     *  FNS_JOO_0090 : Open <br>
     *  retrieving Authority Carrier Open customer/vendor Name<br>
     *  2016.05.13 Renewal Add.
     *
     * @throws EventException
     * @return EventResponse
     * @author 
     */
	private EventResponse openFnsJoo0090(Event e) throws EventException {
        GeneralEventResponse eventResponse  = new GeneralEventResponse();
        try{
        	FnsJoo0090Event event = (FnsJoo0090Event)e;
            JOOFindCodeAndCheckBC    command    = new JOOFindCodeAndCheckBCImpl();
            
            //Customer nm
            String custNm = "";
            String vndrNm = "";
            JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();
            jooCodeParamVO.setCode(event.getMstConditionVO().getCustCd());
            List<JooCodeInfoVO> customerList   = command.searchCustomerList(jooCodeParamVO);
            if(customerList.size() > 0){
            	custNm = (String) customerList.get(0).getName();
            }
            
            //Service provider nm
            jooCodeParamVO.setCode(event.getMstConditionVO().getVndrSeq());
            List<JooCodeInfoVO> vndrList   = command.searchVendorList(jooCodeParamVO);
            if(vndrList.size() > 0){
            	vndrNm = (String) vndrList.get(0).getName();
            }

    		eventResponse.setETCData("cust_nm"   , custNm);
    		eventResponse.setETCData("vndr_nm"   , vndrNm);
    		
            //eventResponse.setRsVoList( carrlist   );
        } catch (EventException ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }    
        return eventResponse;
    }
    
    /**
     * FNS_JOO_0090 : Retrieve
     * retrieving Authority Carrier.<br>
     *  2016.05.13 Renewal Add.
     * 
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author 
     */
    private EventResponse searchAuthorityCarrierList(Event e) throws EventException {
    	FnsJoo0090Event event = (FnsJoo0090Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
    	try{
	        RenewalMasterDataMgtBC command = new RenewalMasterDataMgtBCImpl();
	        List<AuthorityCarrierVO> list = command.searchAuthorityCarrierList(event.getMstConditionVO() );
	       
	        eventResponse.setRsVoList(list);
	        
    	} catch (EventException ex) {
    		log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    	return eventResponse;
    }
    
    /**
     * FNS_JOO_0090 : Save
     * saving authority Carrier <br>
     *  2016.05.13 Renewal Add.
     * 
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author 
     */
    private EventResponse manageAuthorityCarrier(Event e) throws EventException {
        RenewalMasterDataMgtBC command = new RenewalMasterDataMgtBCImpl();
 
        FnsJoo0090Event event = (FnsJoo0090Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
 
        try {
            begin();
            
            command.manageAuthorityCarrier( event.getAuthorityCarrierVOS() , this.account);
             
            eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());            
            commit();
        } catch (EventException ex) {
            log.error("error "+ex.toString(), ex);
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }

        return eventResponse;
    }
    
    /**
     * JOO_CRR_AUTH에 등록된 Office 권한의 ComboItem 조회.
     * @param comboItemFlg
     * @return
     * @throws EventException
     */
    private String searchConditionComboItemByAuthOfficeCd(String comboItemFlg) throws EventException {
    	try {    
		    JOOFindCodeAndCheckBC    command    = new JOOFindCodeAndCheckBCImpl();
		    
		    String ofcCd = account.getOfc_cd();
		    boolean isContainOffice = OfficeCodeMgr.checkContainOfficeCode(JooConstants.KEY_OFFICE_GROUP_CD, JooConstants.KEY_OFFICE_SUBSYS_CD, ofcCd);
		    
		    String authOfcCd = isContainOffice ? "" : ofcCd; //등록된 Office일때는 ALL 권한, 그렇지 않으면 디폴트로 Login office
		    
		    //authDelcheckYn
		    JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();
		    jooCodeParamVO.setOfcCd(authOfcCd);
		    
		    String rtnCds = "";
		    
		    if(comboItemFlg.equals(JooConstants.KEY_COMBOITEM_FLG_CARRIER)){
		    	List<JooCodeInfoVO> carrlist   = command.searchCarrierCodeList(jooCodeParamVO);
		    	rtnCds = makeComboString(carrlist, 2); //IBCombo, Code만
		    }else if(comboItemFlg.equals(JooConstants.KEY_COMBOITEM_FLG_TRADE)){
		    	List<JooCodeInfoVO> list = command.searchTradeCodeList(jooCodeParamVO);
		    	rtnCds = makeComboString(list, 2); //IBCombo, Code만
		    }else if(comboItemFlg.equals(JooConstants.KEY_COMBOITEM_FLG_RLANE)){
		    	List<JooCodeInfoVO> rlaneList = command.searchRlaneCodeList(jooCodeParamVO);
		    	rtnCds= makeComboString(rlaneList, 2); //IBCombo, Code만
		    }else if(comboItemFlg.equals(JooConstants.KEY_COMBOITEM_FLG_AUTH_OFC)){
		    	//2016.07.26 권한 있는 Office 조회
				if (isContainOffice){
					List<JooCodeInfoVO> authOfcList = command.searchAuthOfficeList(jooCodeParamVO);
					if (authOfcList.isEmpty()) {
						rtnCds = ofcCd + "," + ofcCd;
					}else{ 
						rtnCds = "ALL,|"+makeComboString(authOfcList, 1);
					}
				}else{
					rtnCds = ofcCd+","+ofcCd;
				}
		    }
		    
		    return rtnCds;
    	} catch (EventException ex) {
            log.error("error "+ex.toString(), ex);
            rollback();
            throw ex;
        }
    }
	
	/**
	 * changing List to String
	 * @param List<JooCodeInfoVO> list
	 * @param int flg
	 * @return String rtnVal
	 * @throws EventException
	 */
	@SuppressWarnings("rawtypes")
	private String makeComboString(List<JooCodeInfoVO> list, int flg) throws EventException{
		String rtnVal = null;
		StringBuilder sb = new StringBuilder();

		Iterator iterator = (Iterator) list.iterator();

		while(iterator.hasNext()){
			JooCodeInfoVO jooCodeInfoVO = (JooCodeInfoVO)iterator.next();
			
			if (flg==0){
				sb.append(jooCodeInfoVO.getName()+","+jooCodeInfoVO.getCode()+"|");				
			//IBCombo (code, code|)
			}else if (flg==1){
				sb.append(jooCodeInfoVO.getCode()+","+jooCodeInfoVO.getCode()+"|");				
			//IBSheet code(code|)
			}else if (flg==2){
				sb.append(jooCodeInfoVO.getCode()+"|");				
			//IBSheet name(name|)
			}else if (flg==3){
				sb.append(jooCodeInfoVO.getName()+"|");				
			//SuperCd
			}else if (flg==4){
				sb.append(jooCodeInfoVO.getSuperCd1()+","+jooCodeInfoVO.getSuperCd2()+","+jooCodeInfoVO.getCode()+"|");				
			}else if (flg==5){
				sb.append(jooCodeInfoVO.getCode()+"\t"+jooCodeInfoVO.getName()+"|");				
			}
		}
		
		rtnVal = sb.toString();
		
		if (rtnVal.length() > 0){
			rtnVal = rtnVal.substring(0,rtnVal.length()-1);
		}
		
		return rtnVal;
	}
	//renewalCheckCarrierInfo  renewalRevenueLaneInfo renewalSearchCustomerInfo
} 