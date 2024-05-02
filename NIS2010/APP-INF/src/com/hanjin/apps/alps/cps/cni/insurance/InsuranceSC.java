/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InsuranceSC.java
*@FileTitle : Insurance Main
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.13
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.11.13 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.insurance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.hanjin.apps.alps.cps.cni.codemgt.filemgt.basic.FileMgtBC;
import com.hanjin.apps.alps.cps.cni.codemgt.filemgt.basic.FileMgtBCImpl;
import com.hanjin.apps.alps.cps.cni.codemgt.filemgt.vo.SearchFileInsuranceListVO;
import com.hanjin.apps.alps.cps.cni.common.CniUtil;
import com.hanjin.apps.alps.cps.cni.common.basic.CniCommonBC;
import com.hanjin.apps.alps.cps.cni.common.basic.CniCommonBCImpl;
import com.hanjin.apps.alps.cps.cni.insurance.insurance.basic.InsuranceBC;
import com.hanjin.apps.alps.cps.cni.insurance.insurance.basic.InsuranceBCImpl;
import com.hanjin.apps.alps.cps.cni.insurance.insurance.event.CpsCni0401Event;
import com.hanjin.apps.alps.cps.cni.insurance.insurance.integration.InsuranceDBDAO;
import com.hanjin.apps.alps.cps.cni.insurance.insurance.vo.ContainerPremiumVO;
import com.hanjin.apps.alps.cps.cni.insurance.insurance.vo.SearchInsuranceVO;
import com.hanjin.apps.alps.cps.cni.insurance.insurance.vo.SearchPremiumInstallmentListVO;
import com.hanjin.apps.alps.cps.cni.insurance.insurance.vo.SearchPremiumVO;
import com.hanjin.apps.alps.cps.cni.insurance.vesselstatus.basic.VesselStatusBC;
import com.hanjin.apps.alps.cps.cni.insurance.vesselstatus.basic.VesselStatusBCImpl;
import com.hanjin.apps.alps.cps.cni.insurance.vesselstatus.event.CpsCni0403Event;
import com.hanjin.apps.alps.cps.cni.insurance.vesselstatus.vo.SearchInsuranceVesselDataVO;
import com.hanjin.apps.alps.cps.cni.insurance.vesselstatus.vo.SearchVesselStatusListVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-Insurance Business Logic ServiceCommand - ALPS-Insurance 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Yoon, Seyeong
 * @see InsuranceDBDAO
 * @since J2EE 1.6
 */

public class InsuranceSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * Insurance system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("InsuranceSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
			// 사용자 Role정보 
			String roles = CniUtil.getRoles(account);	
			
			if (StringUtils.isEmpty(roles)) {
				CniCommonBC cmd = new CniCommonBCImpl();				
				CniUtil.setRoles(account, 
						cmd.searchUserRoleList(account.getUsr_id()));
				
			}		
			
			// 사용자 Area정보 취득 
			String area = CniUtil.getAreaInfo(account);	
			
			if (StringUtils.isEmpty(area)) {
				CniCommonBC cmd = new CniCommonBCImpl();				
				CniUtil.setAreaInfo(account, 
						cmd.searchUserArea(account.getOfc_cd()));				
			}		
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * Insurance system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("InsuranceSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-Insurance system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("CpsCni0401Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInsurance(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchCheckInsurance (e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = manageInsurance(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = removeInsurance(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchPremium(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchCheckPremium (e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = managePremium(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY03)) {
				eventResponse = removePremium(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("CpsCni0403Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVesselStatusList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchInsuranceVessel(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchInsuranceFlag (e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchInsuranceVesselData (e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageVesselStatus(e);
			}
		}

		return eventResponse;
	}
	/**
	 * CPS_CNI_0401 : [이벤트]<br>
	 * Insurance 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInsurance(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CpsCni0401Event event = (CpsCni0401Event)e;
		InsuranceBC command = new InsuranceBCImpl();

		try{
			SearchInsuranceVO searchInsuranceVO = command.searchInsurance(event.getInsurTpCd(), event.getInsurPlcyYr(), event.getInsurClmPtyNo());
			
			String[] realColNms = {"insur_clm_pty_no", "insur_clm_pty_nm", "insur_ctnt", 
					"rins_clm_pty_no", "rins_clm_pty_nm",
					"rins_ctnt", "ins_clm_pty_no", "ins_clm_pty_nm", "ins_ctnt", "cins_clm_pty_no", "cins_clm_pty_nm", "cins_ctnt", 
					"bro_clm_pty_no", "bro_clm_pty_nm", "int_desc", "int_desc_nm", "insur_ctrt_eff_dt", "insur_ctrt_exp_dt", 
					"subj_mat_ins_desc", "subj_mat_ins_desc_nm", 
					"ins_curr_cd", "ins_locl_amt", "ins_xch_rt", "ins_usd_amt", "lmt_ins_curr_cd", 
					"lmt_ins_locl_amt", "lmt_ins_xch_rt", "lmt_ins_usd_amt", "insur_rmk",
					"insur_ttl_locl_amt", "insur_ttl_curr_cd", "insur_ttl_xch_rt", "insur_ttl_usd_amt"};

			if (searchInsuranceVO != null) {

				AbstractValueObject vo = (AbstractValueObject)searchInsuranceVO;
				Map<String, String> colValues = vo.getColumnValues();
				
				for (int i=0; i<realColNms.length; i++) {
					eventResponse.setETCData(realColNms[i], colValues.get(realColNms[i]));			
				}
				
				eventResponse.setETCData("Retrieve","Y");			
				
				FileMgtBC fileCommand = new FileMgtBCImpl();

				List<SearchFileInsuranceListVO> searchFileInsuranceListVO = fileCommand.searchFileInsuranceList(event.getInsurTpCd(), event.getInsurPlcyYr(), event.getInsurClmPtyNo(), event.getInsurPrmTpCd(), "040101");
				eventResponse.setRsVoList(searchFileInsuranceListVO);

				searchFileInsuranceListVO = fileCommand.searchFileInsuranceList(event.getInsurTpCd(), event.getInsurPlcyYr(), event.getInsurClmPtyNo(), event.getInsurPrmTpCd(), "040102");
				eventResponse.setRsVoList(searchFileInsuranceListVO);

				searchFileInsuranceListVO = fileCommand.searchFileInsuranceList(event.getInsurTpCd(), event.getInsurPlcyYr(), event.getInsurClmPtyNo(), event.getInsurPrmTpCd(), "040103");
				eventResponse.setRsVoList(searchFileInsuranceListVO);

				searchFileInsuranceListVO = fileCommand.searchFileInsuranceList(event.getInsurTpCd(), event.getInsurPlcyYr(), event.getInsurClmPtyNo(), event.getInsurPrmTpCd(), "040104");
				eventResponse.setRsVoList(searchFileInsuranceListVO);

				searchFileInsuranceListVO = fileCommand.searchFileInsuranceList(event.getInsurTpCd(), event.getInsurPlcyYr(), event.getInsurClmPtyNo(), event.getInsurPrmTpCd(), "040105");
				eventResponse.setRsVoList(searchFileInsuranceListVO);

				searchFileInsuranceListVO = fileCommand.searchFileInsuranceList(event.getInsurTpCd(), event.getInsurPlcyYr(), event.getInsurClmPtyNo(), event.getInsurPrmTpCd(), "040106");
				eventResponse.setRsVoList(searchFileInsuranceListVO);

				searchFileInsuranceListVO = fileCommand.searchFileInsuranceList(event.getInsurTpCd(), event.getInsurPlcyYr(), event.getInsurClmPtyNo(), event.getInsurPrmTpCd(), "040107");
				eventResponse.setRsVoList(searchFileInsuranceListVO);

				searchFileInsuranceListVO = fileCommand.searchFileInsuranceList(event.getInsurTpCd(), event.getInsurPlcyYr(), event.getInsurClmPtyNo(), event.getInsurPrmTpCd(), "040108");
				eventResponse.setRsVoList(searchFileInsuranceListVO);

				//Premium 조회
				ContainerPremiumVO containerPremiumVO = command.searchPremium(event.getInsurTpCd(), event.getInsurPlcyYr(), event.getInsurClmPtyNo(), "APR");
				SearchPremiumVO searchPremiumVO = containerPremiumVO.getSearchPremiumVO();
				
				String[] realPrmColNms = { 
						"ttl_locl_amt", "ttl_curr_cd", "ttl_xch_rt", "ttl_usd_amt", "ttl_due_dt", "ttl_pay_dt", 
						"adj_locl_amt", "adj_curr_cd", "adj_xch_rt", "adj_usd_amt", "adj_due_dt", "adj_pay_dt", 
						"rfnd_locl_amt", "rfnd_curr_cd", "rfnd_xch_rt", "rfnd_usd_amt", "rfnd_due_dt", "rfnd_pay_dt", 
						"ots_locl_amt", "ots_curr_cd", "ots_xch_rt", "ots_usd_amt", "ots_due_dt", "ots_pay_dt", 
						"diff_rmk", };

				if (searchPremiumVO != null) {

					AbstractValueObject voPrm = (AbstractValueObject)searchPremiumVO;
					Map<String, String> colPrmValues = voPrm.getColumnValues();
					
					for (int i=0; i<realPrmColNms.length; i++) {
						eventResponse.setETCData(realPrmColNms[i], colPrmValues.get(realPrmColNms[i]));			
					}

					List<SearchPremiumInstallmentListVO> searchPremiumInstallmentListVO = containerPremiumVO.getSearchPremiumInstallmentListVO();
					eventResponse.setRsVoList(searchPremiumInstallmentListVO);

					searchFileInsuranceListVO = fileCommand.searchFileInsuranceList(event.getInsurTpCd(), event.getInsurPlcyYr(), event.getInsurClmPtyNo(), "APR", "040109");
					eventResponse.setRsVoList(searchFileInsuranceListVO);
			
					searchFileInsuranceListVO = fileCommand.searchFileInsuranceList(event.getInsurTpCd(), event.getInsurPlcyYr(), event.getInsurClmPtyNo(), "APR", "040110");
					eventResponse.setRsVoList(searchFileInsuranceListVO);

					eventResponse.setETCData("RetrievePrm","Y");			
				} else {
					for (int i=0; i<realPrmColNms.length; i++) {
						eventResponse.setETCData(realPrmColNms[i], "");			
					}
					eventResponse.setETCData("RetrievePrm","N");			
				}
				
			} else {
				for (int i=0; i<realColNms.length; i++) {
					eventResponse.setETCData(realColNms[i], "");			
				}
				eventResponse.setETCData("Retrieve","N");			

				eventResponse.setUserMessage((String) new ErrorHandler("COM12198",new String[]{}).getUserMessage());
			}

		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("CNI99999").getMessage(),ex);
		}	
		return eventResponse;
	}
	/**
	 * CPS_CNI_0401 : [이벤트]<br>
	 * Insurance 생성 및 변경한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageInsurance(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CpsCni0401Event event = (CpsCni0401Event)e;
		InsuranceBC command = new InsuranceBCImpl();
		try{
			begin();
			command.manageInsurance(event.getCustomInsuranceVO(),account.getUsr_id());
			eventResponse.setUserMessage(new ErrorHandler("CNI09001").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("CNI99999").getMessage(),ex);
		}
		return eventResponse;
	}

	/**
	 * CPS_CNI_0401 : [이벤트]<br>
	 * Premium 생성 및 변경한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse managePremium(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CpsCni0401Event event = (CpsCni0401Event)e;
		InsuranceBC command = new InsuranceBCImpl();
		try{
			begin();
			command.managePremium(event.getCustomPremiumVO(),event.getCustomPremiumInstallmentVOS(),account.getUsr_id());
			eventResponse.setUserMessage(new ErrorHandler("CNI09001").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("CNI99999").getMessage(),ex);
		}
		return eventResponse;
	}

	/**
	 * CPS_CNI_0401 : [이벤트]<br>
	 * Premium 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPremium(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CpsCni0401Event event = (CpsCni0401Event)e;
		InsuranceBC command = new InsuranceBCImpl();
	
		try{
			ContainerPremiumVO containerPremiumVO = command.searchPremium(event.getInsurTpCd(), event.getInsurPlcyYr(), event.getInsurClmPtyNo(), event.getInsurPrmTpCd());
			SearchPremiumVO searchPremiumVO = containerPremiumVO.getSearchPremiumVO();
			
			String[] realColNms = { 
					"ttl_locl_amt", "ttl_curr_cd", "ttl_xch_rt", "ttl_usd_amt", "ttl_due_dt", "ttl_pay_dt", 
					"adj_locl_amt", "adj_curr_cd", "adj_xch_rt", "adj_usd_amt", "adj_due_dt", "adj_pay_dt", 
					"rfnd_locl_amt", "rfnd_curr_cd", "rfnd_xch_rt", "rfnd_usd_amt", "rfnd_due_dt", "rfnd_pay_dt", 
					"ots_locl_amt", "ots_curr_cd", "ots_xch_rt", "ots_usd_amt", "ots_due_dt", "ots_pay_dt", 
					"diff_rmk", };

			if (searchPremiumVO != null) {

				AbstractValueObject vo = (AbstractValueObject)searchPremiumVO;
				Map<String, String> colValues = vo.getColumnValues();
				
				for (int i=0; i<realColNms.length; i++) {
					eventResponse.setETCData(realColNms[i], colValues.get(realColNms[i]));			
				}
				
				eventResponse.setETCData("Retrieve","Y");			

				List<SearchPremiumInstallmentListVO> searchPremiumInstallmentListVO = containerPremiumVO.getSearchPremiumInstallmentListVO();
				eventResponse.setRsVoList(searchPremiumInstallmentListVO);

				FileMgtBC fileCommand = new FileMgtBCImpl();
		
				List<SearchFileInsuranceListVO> searchFileInsuranceListVO = fileCommand.searchFileInsuranceList(event.getInsurTpCd(), event.getInsurPlcyYr(), event.getInsurClmPtyNo(), event.getInsurPrmTpCd(), "040109");
				eventResponse.setRsVoList(searchFileInsuranceListVO);
		
				searchFileInsuranceListVO = fileCommand.searchFileInsuranceList(event.getInsurTpCd(), event.getInsurPlcyYr(), event.getInsurClmPtyNo(), event.getInsurPrmTpCd(), "040110");
				eventResponse.setRsVoList(searchFileInsuranceListVO);

			} else {
				for (int i=0; i<realColNms.length; i++) {
					eventResponse.setETCData(realColNms[i], "");			
				}
				eventResponse.setETCData("Retrieve","N");			
				eventResponse.setUserMessage((String) new ErrorHandler("COM12198",new String[]{}).getUserMessage());
			}
	
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("CNI99999").getMessage(),ex);
		}	
		return eventResponse;
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * Insurance 보험 등록 되어있는지 검사한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCheckInsurance(Event e) throws EventException {
		
		CpsCni0401Event event = (CpsCni0401Event)e;
		
		InsuranceBC command = new InsuranceBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			
			String result      = command.searchCheckInsurance(event.getInsurTpCd(), event.getInsurPlcyYr());
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			if (result != null) {
				eventResponse.setETCData("Retrieve","Y");			
				eventResponse.setUserMessage(new ErrorHandler("CNI09062").getUserMessage());
			}
			
			eventResponse.setETCData(etcData);
			
			return eventResponse;
	
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
	}

	/**
	 * CPS_CNI_0401 : [이벤트]<br>
	 * Insurance 삭제한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeInsurance(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CpsCni0401Event event = (CpsCni0401Event)e;
		InsuranceBC command = new InsuranceBCImpl();
		try{
			begin();

			FileMgtBC fileCommand = new FileMgtBCImpl();
			fileCommand.removeInsuranceFile(event.getInsurTpCd(), event.getInsurPlcyYr(), event.getInsurClmPtyNo());

			command.removeInsurance(event.getInsurTpCd(), event.getInsurPlcyYr(), event.getInsurClmPtyNo());

			eventResponse.setUserMessage(new ErrorHandler("CNI09001").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("CNI99999").getMessage(),ex);
		}
		return eventResponse;
	}

	/**
	 * CPS_CNI_0401 : [이벤트]<br>
	 * Insurance Premium 삭제한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removePremium(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CpsCni0401Event event = (CpsCni0401Event)e;
		InsuranceBC command = new InsuranceBCImpl();
		try{
			begin();

			FileMgtBC fileCommand = new FileMgtBCImpl();
			fileCommand.removePremiumFile(event.getInsurTpCd(), event.getInsurPlcyYr(), event.getInsurClmPtyNo(), event.getInsurPrmTpCd());

			command.removePremium(event.getInsurTpCd(), event.getInsurPlcyYr(), event.getInsurClmPtyNo(), event.getInsurPrmTpCd());
			eventResponse.setUserMessage(new ErrorHandler("CNI09001").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("CNI99999").getMessage(),ex);
		}
		return eventResponse;
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * Insurance 보험 Premium 등록 되어있는지 검사한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCheckPremium(Event e) throws EventException {
		
		CpsCni0401Event event = (CpsCni0401Event)e;
		
		InsuranceBC command = new InsuranceBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			
			String result      = command.searchCheckPremium(event.getInsurTpCd(), event.getInsurPlcyYr(), event.getInsurPrmTpCd());
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			if (result != null) {
				eventResponse.setETCData("Retrieve","Y");			
				eventResponse.setUserMessage(new ErrorHandler("CNI09063").getUserMessage());
			}
			
			eventResponse.setETCData(etcData);
			
			return eventResponse;
	
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
	}

	/**
	 * CPS_CNI_0403 : [이벤트]<br>
	 * Vessel Status Entry 생성 및 변경한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageVesselStatus(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CpsCni0403Event event = (CpsCni0403Event)e;
		VesselStatusBC command = new VesselStatusBCImpl();
		try{
			begin();
			command.manageVesselStatus(event.getCustomVesselStatusVOS(),account.getUsr_id());
			eventResponse.setUserMessage(new ErrorHandler("CNI09001").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("CNI99999").getMessage(),ex);
		}
		return eventResponse;
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * Vessel Status Entry 조회한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVesselStatusList(Event e) throws EventException {
		
		CpsCni0403Event event = (CpsCni0403Event)e;
		
		VesselStatusBC command = new VesselStatusBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			
			List<SearchVesselStatusListVO> searchVesselStatusListVO      = command.searchVesselStatusList(event.getCondSearchVesselStatusListVO());
			
			eventResponse.setRsVoList(searchVesselStatusListVO);
			
			return eventResponse;
	
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * 국가명을 조회한다 <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInsuranceFlag(Event e) throws EventException {
		
		CpsCni0403Event event = (CpsCni0403Event)e;
		
		VesselStatusBC command = new VesselStatusBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			
			String result      = command.searchInsuranceFlag(event.getFlag());
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			if (result != null) {
				eventResponse.setETCData("Retrieve","Y");			
				eventResponse.setETCData("cnt_nm",result);			
			} else {
				eventResponse.setETCData("Retrieve","N");			
				etcData.put("errMsg",(String) new ErrorHandler("CNI09057",new String[]{}).getUserMessage());
			}
			
			eventResponse.setETCData(etcData);
			
			return eventResponse;
	
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * 선박명을 조회한다 <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInsuranceVessel(Event e) throws EventException {
		
		CpsCni0403Event event = (CpsCni0403Event)e;
		
		VesselStatusBC command = new VesselStatusBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			
			String result      = command.searchInsuranceVessel(event.getVslCd());
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			if (result != null) {
				eventResponse.setETCData("Retrieve","Y");			
				eventResponse.setETCData("vsl_eng_nm",result);			
			} else {
				eventResponse.setETCData("Retrieve","N");			
				etcData.put("errMsg",(String) new ErrorHandler("CNI09056",new String[]{}).getUserMessage());
			}
			
			eventResponse.setETCData(etcData);
			
			return eventResponse;
	
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
	}

	/**
	 * CPS_CNI_0403 : [이벤트]<br>
	 * Vessel Status의 선박 관련 항목 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInsuranceVesselData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CpsCni0403Event event = (CpsCni0403Event)e;
		VesselStatusBC command = new VesselStatusBCImpl();
	
		try{
			SearchInsuranceVesselDataVO searchInsuranceVesselDataVO = command.searchInsuranceVesselData(event.getVslCd());
			
			if (searchInsuranceVesselDataVO != null) {
	
				eventResponse.setETCData("vsl_lnch_dt",searchInsuranceVesselDataVO.getVslLnchDt());			
				eventResponse.setETCData("vsl_rgst_cnt_cd",searchInsuranceVesselDataVO.getVslRgstCntCd());			
				eventResponse.setETCData("clss_no_rgst_area_nm",searchInsuranceVesselDataVO.getClssNoRgstAreaNm());			
				eventResponse.setETCData("grs_rgst_tong_wgt",searchInsuranceVesselDataVO.getGrsRgstTongWgt());			
				eventResponse.setETCData("dwt_wgt",searchInsuranceVesselDataVO.getDwtWgt());			
				eventResponse.setETCData("vsl_de_dt",searchInsuranceVesselDataVO.getVslDeDt());			
				eventResponse.setETCData("cnt_cd",searchInsuranceVesselDataVO.getCntCd());			
				eventResponse.setETCData("cnt_nm",searchInsuranceVesselDataVO.getCntNm());			

				eventResponse.setETCData("Retrieve","Y");			
				
			} else {
				eventResponse.setETCData("Retrieve","N");			
	
				eventResponse.setETCData("errMsg",(String) new ErrorHandler("CNI09067",new String[]{}).getUserMessage());
			}
	
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("CNI99999").getMessage(),ex);
		}	
		return eventResponse;
	}
}