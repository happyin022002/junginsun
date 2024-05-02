/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ModelConstraintManageSC.java
*@FileTitle : Constraints List Change
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 이현주
*@LastVersion : 1.0
* 2009.07.30 이현주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelconstraintmanage;

import java.util.List;

import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.constraintitem.basic.ConstraintItemBC;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.constraintitem.basic.ConstraintItemBCImpl;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.constraintitem.event.EsmSpc0011Event;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.constraintitem.event.EsmSpc0012Event;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.constraintitem.event.EsmSpc0063Event;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.constraintitem.integration.ConstraintItemDBDAO;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.constraintitem.vo.SearchConstraintItem063LoadableListVO;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.constraintitem.vo.SearchConstraintItemListVO;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.customerspaceguarantee.basic.CustomerSpaceGuaranteeBC;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.customerspaceguarantee.basic.CustomerSpaceGuaranteeBCImpl;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.customerspaceguarantee.event.EsmSpc0062Event;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.customerspaceguarantee.vo.SearchCustomerSpaceGuaranteeConvLaneListVO;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.customerspaceguarantee.vo.SearchCustomerSpaceGuaranteeConvListVO;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.maxloadfactor.basic.MaxLoadFactorBC;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.maxloadfactor.basic.MaxLoadFactorBCImpl;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.maxloadfactor.event.EsmSpc0019Event;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.maxloadfactor.event.EsmSpc0020Event;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.maxloadfactor.vo.SearchMaxLoadFactorListVO;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.noshowreflection.basic.NoShowReflectionBC;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.noshowreflection.basic.NoShowReflectionBCImpl;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.noshowreflection.event.EsmSpc0015Event;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.noshowreflection.event.EsmSpc0016Event;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.noshowreflection.vo.SearchNoShowReflectionListVO;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.preallocation.basic.PreAllocationBC;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.preallocation.basic.PreAllocationBCImpl;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.preallocation.event.EsmSpc0067Event;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.preallocation.event.EsmSpc0068Event;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.preallocation.vo.SearchPreAllocation0068List01VO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-ModelConstraintManage Business Logic ServiceCommand - ALPS-ModelConstraintManage 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author HJ.LEE
 * @see ConstraintItemDBDAO
 * @since J2EE 1.6
 */

public class ModelConstraintManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * ModelConstraintManage system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("ModelConstraintManageSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * ModelConstraintManage system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("ModelConstraintManageSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-ModelConstraintManage system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		// 판매목표수립 모델 제약조건 항목변경
		if (e.getEventName().equalsIgnoreCase("EsmSpc0011Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchConstraintItemList0011(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiConstraintItem(e);
			}
		// 판매목표수립 모델 제약조건 항목조회
		} else if (e.getEventName().equalsIgnoreCase("EsmSpc0012Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchConstraintItemList0012(e);
			}
			
		} else if (e.getEventName().equalsIgnoreCase("EsmSpc0019Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchMaxLoadFactorList0019(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiMaxLoadFactor(e);
			}
		}  else if (e.getEventName().equalsIgnoreCase("EsmSpc0020Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchMaxLoadFactorList0020(e);
			}
		}  else if (e.getEventName().equalsIgnoreCase("EsmSpc0067Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchPreAllocation0068List01(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiPreAllocation0067(e);
			}

		}  else if (e.getEventName().equalsIgnoreCase("EsmSpc0068Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchPreAllocation0068List01(e);
			}	
			
		}  else if (e.getEventName().equalsIgnoreCase("EsmSpc0015Event")) {				
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchNoShowReflectionList0015(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiNoShowReflection(e);
			}
			
		}  else if (e.getEventName().equalsIgnoreCase("EsmSpc0016Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchNoShowReflectionList0016(e);
			}	
		}  else if (e.getEventName().equalsIgnoreCase("EsmSpc0063Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchConstraintItem063LoadableList(e);
			}	
		} else if (e.getEventName().equalsIgnoreCase("EsmSpc0062Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchCustomerSpaceGuaranteeConvList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchCustomerSpaceGuaranteeConvLaneList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = multiCustomerSpaceGuarantee1(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = multiCustomerSpaceGuarantee2(e);
			}			
		}
		
		return eventResponse;
	}
	/**
	 * ESM_SPC_0011 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchConstraintItemList0011(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0011Event event = (EsmSpc0011Event)e;
		ConstraintItemBC command = new ConstraintItemBCImpl();

		try{
			List<SearchConstraintItemListVO> list = command.searchConstraintItemList(event.getSearchConstraintItemListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	private EventResponse searchConstraintItemList0012(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0012Event event = (EsmSpc0012Event)e;
		ConstraintItemBC command = new ConstraintItemBCImpl();

		try{
			List<SearchConstraintItemListVO> list = command.searchConstraintItemList(event.getSearchConstraintItemListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * ESM_SPC_0011 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiConstraintItem(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0011Event event = (EsmSpc0011Event)e;
		ConstraintItemBC command = new ConstraintItemBCImpl();
		try{
			begin();
			command.multiConstraintItem(event.getSaqMdlCnstVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("SPC00010").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
		
	/**
	 * ESM_SPC_0019 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMaxLoadFactorList0019(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0019Event event = (EsmSpc0019Event)e;
		MaxLoadFactorBC command = new MaxLoadFactorBCImpl();

		try{
			List<SearchMaxLoadFactorListVO> list = command.searchMaxLoadFactorList(event.getConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * ESM_SPC_0020 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMaxLoadFactorList0020(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0020Event event = (EsmSpc0020Event)e;
		MaxLoadFactorBC command = new MaxLoadFactorBCImpl();

		try{
			List<SearchMaxLoadFactorListVO> list = command.searchMaxLoadFactorList(event.getConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * ESM_SPC_0019 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiMaxLoadFactor(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0019Event event = (EsmSpc0019Event)e;
		MaxLoadFactorBC command = new MaxLoadFactorBCImpl();
		try{
			String bse_yr = event.getConditionVO().getYear();
			begin();
			command.multiMaxLoadFactor(event.getSpcMaxLodFctrVOS(),bse_yr, account);
			eventResponse.setETCData("status"  , "OK");
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	private EventResponse searchPreAllocation0068List01(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EsmSpc0068Event event0068 = null;
		EsmSpc0067Event event0067 = null;
		
		List<SearchPreAllocation0068List01VO> list = null;
		PreAllocationBC command = new PreAllocationBCImpl();

		try{
			if(e.getEventName() != null){
				if (e.getEventName().equalsIgnoreCase("EsmSpc0068Event")){
					event0068 = (EsmSpc0068Event)e;
					list = command.searchPreAllocation0068List01(event0068.getConditionVO());
				}else {
					event0067 = (EsmSpc0067Event)e;
	  			    list = command.searchPreAllocation0068List01(event0067.getConditionVO());
				}
				// ETC 데이터 셋팅
				eventResponse.setETCData("status"  , "OK");	
			}
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
		
	private EventResponse multiPreAllocation0067(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0067Event event = (EsmSpc0067Event)e;
		PreAllocationBC command = new PreAllocationBCImpl();
		try{
			begin();
			command.multiSaqPreAloc0067(event.getSaqPreAlocVOS(), account);
			// ETC 데이터 셋팅
			eventResponse.setETCData("status"  , "OK");
			
			eventResponse.setUserMessage(new ErrorHandler("SPC00010").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SPC_0015 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNoShowReflectionList0015(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0015Event event = (EsmSpc0015Event)e;
		NoShowReflectionBC command = new NoShowReflectionBCImpl();

		try{
			List<SearchNoShowReflectionListVO> list = command.searchNoShowReflectionList(event.getSearchNoShowReflectionListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * ESM_SPC_0015 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiNoShowReflection(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0015Event event = (EsmSpc0015Event)e;
		NoShowReflectionBC command = new NoShowReflectionBCImpl();
		try{
			begin();
			command.multiNoShowReflection(event.getSpcNshwRfltVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("SPC00010").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SPC_0016 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNoShowReflectionList0016(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0016Event event = (EsmSpc0016Event)e;
		NoShowReflectionBC command = new NoShowReflectionBCImpl();

		try{
			List<SearchNoShowReflectionListVO> list = command.searchNoShowReflectionList(event.getSearchNoShowReflectionListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}	
	
	/**
	 * ESM_SPC_0063 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchConstraintItem063LoadableList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0063Event event = (EsmSpc0063Event)e;
		ConstraintItemBC command = new ConstraintItemBCImpl();

		try{
			List<SearchConstraintItem063LoadableListVO> list = command.searchConstraintItem063LoadableList(event.getConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * ESM_SPC_0062 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustomerSpaceGuaranteeConvList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0062Event event = (EsmSpc0062Event)e;
		CustomerSpaceGuaranteeBC command = new CustomerSpaceGuaranteeBCImpl();

		try{
			List<SearchCustomerSpaceGuaranteeConvListVO> list = command.searchCustomerSpaceGuaranteeConvList(event.getSearchCustomerSpaceGuaranteeConvListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	private EventResponse searchCustomerSpaceGuaranteeConvLaneList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0062Event event = (EsmSpc0062Event)e;
		CustomerSpaceGuaranteeBC command = new CustomerSpaceGuaranteeBCImpl();

		try{
			List<SearchCustomerSpaceGuaranteeConvLaneListVO> list = command.searchCustomerSpaceGuaranteeConvLaneList(event.getSearchCustomerSpaceGuaranteeConvLaneListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * ESM_SPC_0062 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiCustomerSpaceGuarantee1(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0062Event event = (EsmSpc0062Event)e;
		CustomerSpaceGuaranteeBC command = new CustomerSpaceGuaranteeBCImpl();
		try{
			begin();
			command.multiCustomerSpaceGuarantee1(event.getSaqCntrSzConvVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("SPC00010").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	private EventResponse multiCustomerSpaceGuarantee2(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0062Event event = (EsmSpc0062Event)e;
		CustomerSpaceGuaranteeBC command = new CustomerSpaceGuaranteeBCImpl();
		try{
			begin();
			command.multiCustomerSpaceGuarantee2(event.getSaqCntrSzConvLaneVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("SPC00010").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
}