/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DryWetClaimSC.java
*@FileTitle : DW Claim Main
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.10.12 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.drywetclaim;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.basic.CodeMgtBC;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.basic.CodeMgtBCImpl;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo.MiscellaneousVO;
import com.hanjin.apps.alps.cps.cni.codemgt.filemgt.basic.FileMgtBC;
import com.hanjin.apps.alps.cps.cni.codemgt.filemgt.basic.FileMgtBCImpl;
import com.hanjin.apps.alps.cps.cni.codemgt.filemgt.vo.SearchFileDwcInsuranceListVO;
import com.hanjin.apps.alps.cps.cni.common.CniConst;
import com.hanjin.apps.alps.cps.cni.common.CniUtil;
import com.hanjin.apps.alps.cps.cni.common.basic.CniCommonBC;
import com.hanjin.apps.alps.cps.cni.common.basic.CniCommonBCImpl;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.basic.DryWetClaimBC;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.basic.DryWetClaimBCImpl;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.event.CpsCni0301Event;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.event.CpsCni0302Event;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.event.CpsCni0303Event;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.event.CpsCni0306Event;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.event.CpsCni0307Event;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.event.CpsCni0308Event;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.event.CpsCni0310Event;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.event.CpsCni0311Event;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.event.CpsCni0312Event;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.integration.DryWetClaimDBDAO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.ContainerHandlingCostVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.SearchAgentVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.SearchDryWetClaimCodeListVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.SearchDryWetClaimVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.SearchHandlingCostVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.SearchRoeListVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.SearchStatusListVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.SearchVesselListVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.SearchVesselVvdListVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.HandlerHistoryVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.ManagerHistoryVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.TransferVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.DateTime;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-DryWetClaim Business Logic ServiceCommand - ALPS-DryWetClaim 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Yoon, Seyeong
 * @see DryWetClaimDBDAO
 * @since J2EE 1.6
 */

public class DryWetClaimSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;
	// 레포트 파일 구분자
	private final String SP = "|&&|";	
	private final String EOR = "//EOR//";

	/**
	 * DryWetClaim system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("DryWetClaimSC 시작");
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
	 * DryWetClaim system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("DryWetClaimSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-DryWetClaim system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("CpsCni0301Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDryWetClaim(e);
			}  
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchDryWetClaimCodeList(e);
			}  
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchVesselName(e);
			}  
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchDryWetClaimHandler(e);
			}  
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchCurrency(e);
			}  
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchAgent(e);
			} 
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchDryWetClaimOffice(e);
			} 
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = manageDryWetClaim(e);
			} 
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = modifyCloseDryWetClaim(e);
			} 
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = modifyReopenDryWetClaim(e);
			} 
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY03)) {
				eventResponse = modifyCancelDryWetClaim(e);
			} 
		} else if (e.getEventName().equalsIgnoreCase("CpsCni0302Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchStatusList(e);
			}  
		} else if (e.getEventName().equalsIgnoreCase("CpsCni0303Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchHandlingCostList(e);
			} 
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageHandlingCost(e);
			}  
		} else if (e.getEventName().equalsIgnoreCase("CpsCni0306Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVesselVvdList(e);
			}  
		} else if (e.getEventName().equalsIgnoreCase("CpsCni0307Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRoeList(e);
			}  
		} else if (e.getEventName().equalsIgnoreCase("CpsCni0308Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVesselList(e);
			}  
		} else if (e.getEventName().equalsIgnoreCase("CpsCni0310Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchHandlerHistoryList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("CpsCni0311Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageManagerHistory(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse =  searchManagerHistoryList(e);
			}
		}	
		
		// ---------------------------------------------------------------------------
		// [CPS_CNI_0312] Transfer
		// ---------------------------------------------------------------------------		
		else if (e.getEventName().equalsIgnoreCase("CpsCni0312Event")) {
				
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				return searchTransferList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				return manageTransfer(e);	
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				return searchTrnsOfcCd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				return searchTrnsUsrId(e);
			} else if (e.getFormCommand().isCommand(FormCommand.PRINT)) {
				return printTransfer(e);
			} else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				return searchTransferOpen(e);
			}
		}
		return eventResponse;
	}
	
	/**
	 * CPS_CNI_0301 : [이벤트]<br>
	 * Dry & Wet Claim을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDryWetClaim(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CpsCni0301Event event = (CpsCni0301Event)e;
		DryWetClaimBC command = new DryWetClaimBCImpl();

		try{
			SearchDryWetClaimVO searchDryWetClaimVO = command.searchDryWetClaim(event.getDwClmNo());
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			if (searchDryWetClaimVO != null) {
				eventResponse.setETCData("dwClmNo",searchDryWetClaimVO.getDwClmNo());
				eventResponse.setETCData("dwClmTpCd",searchDryWetClaimVO.getDwClmTpCd());
				eventResponse.setETCData("dwCoCd",searchDryWetClaimVO.getDwCoCd());
				eventResponse.setETCData("dwClmRefVvdNo",searchDryWetClaimVO.getDwClmRefVvdNo());
				eventResponse.setETCData("vslEngNm",searchDryWetClaimVO.getVslEngNm());
				eventResponse.setETCData("inciPlcTpCd",searchDryWetClaimVO.getInciPlcTpCd());
				eventResponse.setETCData("inciOccrDt",searchDryWetClaimVO.getInciOccrDt());
				eventResponse.setETCData("creOfcCd",searchDryWetClaimVO.getCreOfcCd());
				eventResponse.setETCData("hdlrUsrId",searchDryWetClaimVO.getHdlrUsrId());
				eventResponse.setETCData("tmBarDt",searchDryWetClaimVO.getTmBarDt());
				eventResponse.setETCData("litDt",searchDryWetClaimVO.getLitDt());
				eventResponse.setETCData("dwClmStsCd",searchDryWetClaimVO.getDwClmStsCd());
				eventResponse.setETCData("dwClmAttDefTpCd",searchDryWetClaimVO.getDwClmAttDefTpCd());
				eventResponse.setETCData("prlmClmNtfyDt",searchDryWetClaimVO.getPrlmClmNtfyDt());
				eventResponse.setETCData("csClzDt",searchDryWetClaimVO.getCsClzDt());
				eventResponse.setETCData("arbtDt",searchDryWetClaimVO.getArbtDt());
				eventResponse.setETCData("clmtClmPtyNo",searchDryWetClaimVO.getClmtClmPtyNo());
				eventResponse.setETCData("clmtClmPtyNm",searchDryWetClaimVO.getClmtClmPtyNm());
				eventResponse.setETCData("clmtCtnt",searchDryWetClaimVO.getClmtCtnt());
				eventResponse.setETCData("insurClmPtyNo",searchDryWetClaimVO.getInsurClmPtyNo());
				eventResponse.setETCData("insurClmPtyNm",searchDryWetClaimVO.getInsurClmPtyNm());
				eventResponse.setETCData("ddctUsdAmt",searchDryWetClaimVO.getDdctUsdAmt());
				eventResponse.setETCData("deftClmPtyNo",searchDryWetClaimVO.getDeftClmPtyNo());
				eventResponse.setETCData("deftClmPtyNm",searchDryWetClaimVO.getDeftClmPtyNm());
				eventResponse.setETCData("deftCtnt",searchDryWetClaimVO.getDeftCtnt());
				eventResponse.setETCData("lablPtyClmPtyNo",searchDryWetClaimVO.getLablPtyClmPtyNo());
				eventResponse.setETCData("lablPtyClmPtyNm",searchDryWetClaimVO.getLablPtyClmPtyNm());
				eventResponse.setETCData("lablPtyCtnt",searchDryWetClaimVO.getLablPtyCtnt());
				eventResponse.setETCData("lablPtyTmBarDt",searchDryWetClaimVO.getLablPtyTmBarDt());
				eventResponse.setETCData("clmLoclCurrCd",searchDryWetClaimVO.getClmLoclCurrCd());
				eventResponse.setETCData("clmLoclAmt",searchDryWetClaimVO.getClmLoclAmt());
				eventResponse.setETCData("fmalClmRcvDt",searchDryWetClaimVO.getFmalClmRcvDt());
				eventResponse.setETCData("clmXchRt",searchDryWetClaimVO.getClmXchRt());
				eventResponse.setETCData("clmUsdAmt",searchDryWetClaimVO.getClmUsdAmt());
				eventResponse.setETCData("clmStlLoclCurrCd",searchDryWetClaimVO.getClmStlLoclCurrCd());
				eventResponse.setETCData("clmStlLoclAmt",searchDryWetClaimVO.getClmStlLoclAmt());
				eventResponse.setETCData("clmStlDt",searchDryWetClaimVO.getClmStlDt());
				eventResponse.setETCData("clmStlXchRt",searchDryWetClaimVO.getClmStlXchRt());
				eventResponse.setETCData("clmStlUsdAmt",searchDryWetClaimVO.getClmStlUsdAmt());
				eventResponse.setETCData("lablPtyFileLoclCurrCd",searchDryWetClaimVO.getLablPtyFileLoclCurrCd());
				eventResponse.setETCData("lablPtyFileLoclAmt",searchDryWetClaimVO.getLablPtyFileLoclAmt());
				eventResponse.setETCData("lablPtyFileDt",searchDryWetClaimVO.getLablPtyFileDt());
				eventResponse.setETCData("lablPtyFileXchRt",searchDryWetClaimVO.getLablPtyFileXchRt());
				eventResponse.setETCData("lablPtyFileUsdAmt",searchDryWetClaimVO.getLablPtyFileUsdAmt());
				eventResponse.setETCData("lablPtyRcvrLoclCurrCd",searchDryWetClaimVO.getLablPtyRcvrLoclCurrCd());
				eventResponse.setETCData("lablPtyRcvrLoclAmt",searchDryWetClaimVO.getLablPtyRcvrLoclAmt());
				eventResponse.setETCData("lablPtyRcvrDt",searchDryWetClaimVO.getLablPtyRcvrDt());
				eventResponse.setETCData("lablPtyRcvrXchRt",searchDryWetClaimVO.getLablPtyRcvrXchRt());
				eventResponse.setETCData("lablPtyRcvrUsdAmt",searchDryWetClaimVO.getLablPtyRcvrUsdAmt());
				eventResponse.setETCData("insurFileLoclCurrCd",searchDryWetClaimVO.getInsurFileLoclCurrCd());
				eventResponse.setETCData("insurFileLoclAmt",searchDryWetClaimVO.getInsurFileLoclAmt());
				eventResponse.setETCData("insurFileDt",searchDryWetClaimVO.getInsurFileDt());
				eventResponse.setETCData("insurFileXchRt",searchDryWetClaimVO.getInsurFileXchRt());
				eventResponse.setETCData("insurFileUsdAmt",searchDryWetClaimVO.getInsurFileUsdAmt());
				eventResponse.setETCData("insurRcvrLoclCurrCd",searchDryWetClaimVO.getInsurRcvrLoclCurrCd());
				eventResponse.setETCData("insurRcvrLoclAmt",searchDryWetClaimVO.getInsurRcvrLoclAmt());
				eventResponse.setETCData("insurRcvrDt",searchDryWetClaimVO.getInsurRcvrDt());
				eventResponse.setETCData("insurRcvrXchRt",searchDryWetClaimVO.getInsurRcvrXchRt());
				eventResponse.setETCData("insurRcvrUsdAmt",searchDryWetClaimVO.getInsurRcvrUsdAmt());
				eventResponse.setETCData("dwClmCsDesc",searchDryWetClaimVO.getDwClmCsDesc());
				eventResponse.setETCData("inciDevDesc",searchDryWetClaimVO.getInciDevDesc());
				eventResponse.setETCData("hdlrStlOpinDesc",searchDryWetClaimVO.getHdlrStlOpinDesc());
				eventResponse.setETCData("clmtAgnClmPtyNo",searchDryWetClaimVO.getClmtAgnClmPtyNo());
				eventResponse.setETCData("clmtAgnClmPtyNm",searchDryWetClaimVO.getClmtAgnClmPtyNm());
				eventResponse.setETCData("clmtAgnTelNo",searchDryWetClaimVO.getClmtAgnTelNo());
				eventResponse.setETCData("clmtAgnEmail",searchDryWetClaimVO.getClmtAgnEmail());
				eventResponse.setETCData("clmtAgnTpCd",searchDryWetClaimVO.getClmtAgnTpCd());
				eventResponse.setETCData("clmtAgnApntDt",searchDryWetClaimVO.getClmtAgnApntDt());
				eventResponse.setETCData("clmtAgnRefNo",searchDryWetClaimVO.getClmtAgnRefNo());
				eventResponse.setETCData("deftAgnClmPtyNo",searchDryWetClaimVO.getDeftAgnClmPtyNo());
				eventResponse.setETCData("deftAgnClmPtyNm",searchDryWetClaimVO.getDeftAgnClmPtyNm());
				eventResponse.setETCData("deftAgnTelNo",searchDryWetClaimVO.getDeftAgnTelNo());
				eventResponse.setETCData("deftAgnEmail",searchDryWetClaimVO.getDeftAgnEmail());
				eventResponse.setETCData("deftAgnTpCd",searchDryWetClaimVO.getDeftAgnTpCd());
				eventResponse.setETCData("deftAgnApntDt",searchDryWetClaimVO.getDeftAgnApntDt());
				eventResponse.setETCData("deftAgnRefNo",searchDryWetClaimVO.getDeftAgnRefNo());
				eventResponse.setETCData("rHandler",searchDryWetClaimVO.getRHandler());
				eventResponse.setETCData("updDt",searchDryWetClaimVO.getUpdDt());
                //2010. 4. 19일 추가 함 Transfer를 위해
				eventResponse.setETCData("trnsFlg",searchDryWetClaimVO.getTrnsFlg());
				eventResponse.setETCData("clmTrnsAuthCd",searchDryWetClaimVO.getClmTrnsAuthCd());
				eventResponse.setETCData("trnsSeq",searchDryWetClaimVO.getTrnsSeq());
				//2010. 4. 23일 추가함
				eventResponse.setETCData("hdlrOfcCd",searchDryWetClaimVO.getHdlrOfcCd());
				
				eventResponse.setETCData("Retrieve","Y");			

				//Claim No를 Session에 세팅
				CniUtil.setDwClaimNo(account, event.getDwClmNo());
			} else {
				eventResponse.setETCData("Retrieve","N");			
				eventResponse.setUserMessage((String) new ErrorHandler("COM12198",new String[]{}).getUserMessage());
			}
			eventResponse.setETCData(etcData);
			
			FileMgtBC fileCommand = new FileMgtBCImpl();

			List<SearchFileDwcInsuranceListVO> searchFileDwcInsuranceListVO = fileCommand.searchFileDwcInsuranceList(event.getDwClmNo());
			eventResponse.setRsVoList(searchFileDwcInsuranceListVO);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * CPS_CNI_0301 : [이벤트]<br>
	 * Dry & Wet Claim를 생성 및 변경한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDryWetClaim(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CpsCni0301Event event = (CpsCni0301Event)e;
		DryWetClaimBC command = new DryWetClaimBCImpl();
		try{
			begin();
			
			String dwClmNo = command.manageDryWetClaim(event.getCustomDryWetClaimVO(), event.getCniDwTrnsVO(), account.getUsr_id(), account.getOfc_cd());
			
			Map<String,String> etcData = new HashMap<String,String>();

			eventResponse.setETCData("dwClmNo",dwClmNo);
			eventResponse.setETCData(etcData);
			
			eventResponse.setUserMessage((String) new ErrorHandler("CNI09001",new String[]{}).getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			rollback();
    		throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * 화면에서 Miscellaneous 코드를 가져온다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDryWetClaimCodeList(Event e) throws EventException {
		
		CpsCni0301Event event = (CpsCni0301Event)e;
		
		DryWetClaimBC command = new DryWetClaimBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			
    		String typeCd      = event.getComCdId();
    		String[] etcCodeNm = event.getComCode().split(":");
    		String[] etcTextNm = event.getComText().split(":");

    		List<SearchDryWetClaimCodeListVO> searchDryWetClaimCodeListVO = command.searchDryWetClaimCodeList(typeCd);
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			etcData = getMiscCodeList(searchDryWetClaimCodeListVO, etcCodeNm, etcTextNm);
			
			eventResponse.setETCData(etcData);
			
			return eventResponse;
	
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
	}

	/**
	 * MISCELLANEOUS 코드 정보를 가져온다<br>
	 * 
	 * @param searchDryWetClaimCodeListVO List<SearchDryWetClaimCodeListVO>
	 * @param etcCodeNm String[]
	 * @param etcTextNm String[]
	 * @return Map<String, String>
	 * @exception EventException
	 */
	private Map<String, String> getMiscCodeList(List<SearchDryWetClaimCodeListVO> searchDryWetClaimCodeListVO, String[] etcCodeNm, String[] etcTextNm) throws EventException{
		
	    try{
			if(searchDryWetClaimCodeListVO == null) return null;
			
			// MISCELLANEOUS Code 값
			StringBuilder comboCode = new StringBuilder();
			
			// MISCELLANEOUS Name 값
			StringBuilder comboText = new StringBuilder();
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			for(int i=0; i<searchDryWetClaimCodeListVO.size(); i++) {
	
				comboCode.append(searchDryWetClaimCodeListVO.get(i).getClmMiscCd());
				comboText.append(searchDryWetClaimCodeListVO.get(i).getClmMiscNm());
				
				etcData.put(etcCodeNm[i],comboCode.toString());
				etcData.put(etcTextNm[i],comboText.toString());
				
				comboCode.setLength(0);
				comboText.setLength(0);
			}
	
			return etcData;
			
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * Handler 코드를 검사한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDryWetClaimHandler(Event e) throws EventException {
		
		CpsCni0301Event event = (CpsCni0301Event)e;
		
		DryWetClaimBC command = new DryWetClaimBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			
			String result      = command.searchDryWetClaimHandler(event.getSearchText());
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			if (result == null || result.equals("")) {
				etcData.put("errMsg",(String) new ErrorHandler("CNI09015",new String[]{}).getUserMessage());
			} else {
				etcData.put("usr_id",result);
			}
			
			eventResponse.setETCData(etcData);
			
			return eventResponse;
	
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * 통화를 검사한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCurrency(Event e) throws EventException {
		
		CpsCni0301Event event = (CpsCni0301Event)e;
		
		DryWetClaimBC command = new DryWetClaimBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			
			String result      = command.searchCurrency(event.getSearchText());
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			if (result == null || result.equals("")) {
				etcData.put("errMsg",(String) new ErrorHandler("CNI09016",new String[]{}).getUserMessage());
			} else {
				etcData.put("curr_cd",result);
			}
			
			eventResponse.setETCData(etcData);
			
			return eventResponse;
	
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09016",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * Agent 에 관련된 전화번호, e-Mail 정보를 조회한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgent(Event e) throws EventException {
		
		CpsCni0301Event event = (CpsCni0301Event)e;
		
		DryWetClaimBC command = new DryWetClaimBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			
			List<SearchAgentVO> searchAgentVO      = command.searchAgent(event.getSearchText());
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			if (searchAgentVO.size() > 0) {
				etcData.put("phn_no",searchAgentVO.get(0).getPhnNo());
				etcData.put("pty_eml",searchAgentVO.get(0).getPtyEml());
			} else {
				etcData.put("errMsg",(String) new ErrorHandler("CNI09020",new String[]{}).getUserMessage());
			}
			
			eventResponse.setETCData(etcData);
			
			return eventResponse;
	
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
	}

	/**
	 * CPS_CNI_0301 : [이벤트]<br>
	 * Dry & Wet Claim를 Close한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyCloseDryWetClaim(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CpsCni0301Event event = (CpsCni0301Event)e;
		DryWetClaimBC command = new DryWetClaimBCImpl();
		try{
			begin();
			
			command.modifyCloseDryWetClaim(event.getDwClmNo(),account.getUsr_id(), account.getOfc_cd());
			
			eventResponse.setUserMessage((String) new ErrorHandler("CNI09001",new String[]{}).getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * CPS_CNI_0301 : [이벤트]<br>
	 * Dry & Wet Claim를 Reopen한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyReopenDryWetClaim(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CpsCni0301Event event = (CpsCni0301Event)e;
		DryWetClaimBC command = new DryWetClaimBCImpl();
		try{
			begin();
			
			String statusCd = command.modifyReopenDryWetClaim(event.getDwClmNo(),account.getUsr_id(), account.getOfc_cd());
			
			Map<String,String> etcData = new HashMap<String,String>();
			etcData.put("statusCd",statusCd);
			
			eventResponse.setETCData(etcData);
			
			eventResponse.setUserMessage((String) new ErrorHandler("CNI09001",new String[]{}).getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * CPS_CNI_0301 : [이벤트]<br>
	 * Dry & Wet Claim를 Cancel한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyCancelDryWetClaim(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CpsCni0301Event event = (CpsCni0301Event)e;
		DryWetClaimBC command = new DryWetClaimBCImpl();
		try{
			begin();
			
			command.modifyCancelDryWetClaim(event.getDwClmNo(),account.getUsr_id(), account.getOfc_cd());
			
			eventResponse.setUserMessage((String) new ErrorHandler("CNI09001",new String[]{}).getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * Vessel Name을 조회한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVesselName(Event e) throws EventException {
		
		CpsCni0301Event event = (CpsCni0301Event)e;
		
		DryWetClaimBC command = new DryWetClaimBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			
			String result      = command.searchVesselName(event.getSearchText().substring(0,4));
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			if (result == null || result.equals("")) {
				etcData.put("errMsg",(String) new ErrorHandler("CNI09014",new String[]{}).getUserMessage());
			} else {
				etcData.put("vsl_nm",result);
			}
			
			eventResponse.setETCData(etcData);
			
			return eventResponse;
	
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * Claim 및Incident Case 접수 및 처리 현황 조회한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStatusList(Event e) throws EventException {
		
		CpsCni0302Event event = (CpsCni0302Event)e;
		
		DryWetClaimBC command = new DryWetClaimBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			
			List<SearchStatusListVO> searchStatusListVO = command.searchStatusList(event.getCondSearchStatusListVO());
			
			eventResponse.setRsVoList(searchStatusListVO);
			
			return eventResponse;
	
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * Office Code를 검사한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDryWetClaimOffice(Event e) throws EventException {
		
		CpsCni0301Event event = (CpsCni0301Event)e;
		
		DryWetClaimBC command = new DryWetClaimBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			
			String result      = command.searchDryWetClaimOffice(event.getSearchText());
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			if (result == null || result.equals("")) {
				etcData.put("errMsg",(String) new ErrorHandler("CNI09027",new String[]{}).getUserMessage());
			} else {
				etcData.put("ofc_cd",result);
			}
			
			eventResponse.setETCData(etcData);
			
			return eventResponse;
	
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * Vessel Code & Particular Inquiry<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVesselVvdList(Event e) throws EventException {
		
		CpsCni0306Event event = (CpsCni0306Event)e;
		
		DryWetClaimBC command = new DryWetClaimBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			
			List<SearchVesselVvdListVO> searchVesselVvdListVO = command.searchVesselVvdList(event.getVvdCd(), event.getVslEngNm());
			
			eventResponse.setRsVoList(searchVesselVvdListVO);
			
			return eventResponse;
	
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * Vessel Code & Particular Inquiry<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRoeList(Event e) throws EventException {
		
		CpsCni0307Event event = (CpsCni0307Event)e;
		
		DryWetClaimBC command = new DryWetClaimBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			
			List<SearchRoeListVO> searchRoeListVO = command.searchRoeList(event.getFmDt(),event.getToDt(),event.getCurrCd());
			
			eventResponse.setRsVoList(searchRoeListVO);
			
			return eventResponse;
	
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
	}

	/**
	 * CPS_CNI_0303 : [이벤트]<br>
	 * 해당 Case 관련 발생된 제 처리비용을 생성 및 변경한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageHandlingCost(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CpsCni0303Event event = (CpsCni0303Event)e;
		DryWetClaimBC command = new DryWetClaimBCImpl();
		try{
			begin();
			
			command.manageHandlingCost(event.getCustomHandlingCostVOS(), event.getDwClmNo(), account.getUsr_id());
			
			ContainerHandlingCostVO containerHandlingCostVO = command.searchHandlingCostList(event.getDwClmNo());

			eventResponse.setRsVoList(containerHandlingCostVO.getSearchHandlingCostListVO());
			
			eventResponse.setUserMessage((String) new ErrorHandler("CNI09001",new String[]{}).getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler("CNI09018",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * 해당 Case 관련 발생된 제 처리비용을 조회한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchHandlingCostList(Event e) throws EventException {
		
		CpsCni0303Event event = (CpsCni0303Event)e;
		
		DryWetClaimBC command = new DryWetClaimBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			
			ContainerHandlingCostVO containerHandlingCostVO = command.searchHandlingCostList(event.getDwClmNo());
			
			SearchHandlingCostVO searchHandlingCostVO = containerHandlingCostVO.getSearchHandlingCostVO();
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			eventResponse.setETCData("dwClmNo",searchHandlingCostVO.getDwClmNo());
			eventResponse.setETCData("dwClmTpNm",searchHandlingCostVO.getDwClmTpNm());
			eventResponse.setETCData("dwCoNm",searchHandlingCostVO.getDwCoNm());
			eventResponse.setETCData("vslEngNm",searchHandlingCostVO.getVslEngNm());
			eventResponse.setETCData("inciOccrDt",searchHandlingCostVO.getInciOccrDt());
			eventResponse.setETCData("creOfcCd",searchHandlingCostVO.getCreOfcCd());
			eventResponse.setETCData("hdlrUsrNm",searchHandlingCostVO.getHdlrUsrNm());
			eventResponse.setETCData("tmBarDt",searchHandlingCostVO.getTmBarDt());
			eventResponse.setETCData("dwClmStsNm",searchHandlingCostVO.getDwClmStsNm());
			eventResponse.setETCData("dwClmAttDefTpNm",searchHandlingCostVO.getDwClmAttDefTpNm());
			eventResponse.setETCData("csClzDt",searchHandlingCostVO.getCsClzDt());
			eventResponse.setETCData("lablPtyTmBarDt",searchHandlingCostVO.getLablPtyTmBarDt());
			eventResponse.setETCData("rHandler",searchHandlingCostVO.getRHandler());
			eventResponse.setETCData("updDt",searchHandlingCostVO.getUpdDt());
			eventResponse.setETCData("hdlrUsrId",searchHandlingCostVO.getHdlrUsrId());	
			eventResponse.setETCData(etcData);

			eventResponse.setRsVoList(containerHandlingCostVO.getSearchHandlingCostListVO());
			
			//Claim No를 Session에 세팅
			CniUtil.setDwClaimNo(account, event.getDwClmNo());
			
			return eventResponse;
	
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09017",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * CCC Vessel Code & Name Inquiry<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVesselList(Event e) throws EventException {
		
		CpsCni0308Event event = (CpsCni0308Event)e;
		
		DryWetClaimBC command = new DryWetClaimBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			
			List<SearchVesselListVO> searchVesselListVO = command.searchVesselList(event.getVslCd(),event.getVslNm());
			
			eventResponse.setRsVoList(searchVesselListVO);
			
			return eventResponse;
	
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
	}
	// ===========================================================================
	// 정행룡
	// ===========================================================================
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0310] Handler History
	// ---------------------------------------------------------------------------

	/**
	 * DWC Claim No Handler History 정보 조회<br>
	 * @author 정행룡
	 * @category CPS_CNI_3010
	 * @category searchHandlerHistoryList 
	 * @param e  Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchHandlerHistoryList(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		
		try {
			// BC 객체 생성
			DryWetClaimBC command = new DryWetClaimBCImpl();
			
			CpsCni0310Event event = (CpsCni0310Event)e;
			
			// Cargo Claim No 조회		
			String dwClmNo = event.getDwClmNo();
			
			// Handler History 목록 조회
			List<HandlerHistoryVO> list = command.searchHandlerHistoryList(dwClmNo);		
			
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		return eventResponse;
	}
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0311] Manager History
	// ---------------------------------------------------------------------------

	/**
	 * DWC Claim No Manager History 정보 조회<br>
	 * @author 정행룡
	 * @category CPS_CNI_0311
	 * @category searchManagerHistoryList 
	 * @param e  Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchManagerHistoryList(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		try {
			// BC 객체 생성
			DryWetClaimBC command = new DryWetClaimBCImpl();
			
			CpsCni0311Event event = (CpsCni0311Event)e;
			
			// DW Claim No 조회		
			String dwClmNo = event.getDwClmNo();
			
			// Manager History 목록 조회
			List<ManagerHistoryVO> list = command.searchManagerHistoryList(dwClmNo);		
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}	
		return eventResponse;
	}	
	
	/**
	 * Manager History 등록, 수정, 삭제<br>
	 * @author 정행룡
	 * @category CPS_CNI_3011
	 * @category manageManagerHistory 
	 * @param e  Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageManagerHistory(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		// BC 객체 생성
		DryWetClaimBC command = new DryWetClaimBCImpl();

		CpsCni0311Event event = (CpsCni0311Event)e;
				
		try {			
			begin();

			// event관련 사용자정보 insert
			HandlerHistoryVO[] handlerHistoryVOs =  event.handlerHistoryVOs();
			
			for(int i=0; i < handlerHistoryVOs.length; i++) {
				//사용자 설정
				handlerHistoryVOs[i].setCreUsrId(account.getUsr_id());
				handlerHistoryVOs[i].setUpdUsrId(account.getUsr_id());
			}
			
			command.manageManagerHistory(handlerHistoryVOs);
			
			// 성공메세지설정
			eventResponse.setUserMessage(new ErrorHandler("CNI00008").getUserMessage());
			
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		return eventResponse;
	}

	// ---------------------------------------------------------------------------
	// [CPS_CNI_0036] Transfer
	// ---------------------------------------------------------------------------
	
	/**
	 * Transfer 정보 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0312
	 * @category searchTransferOpen 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTransferOpen(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	

		try {
			// BC 객체 생성
			CodeMgtBC command = new CodeMgtBCImpl();
			
			//GMT 조회조건의 날짜
			String schToDate = command.searchGmtDate(account.getUsr_id());
			String schFromDate = schToDate.replaceAll("-", "");
			schFromDate = DateTime.addMonths(schFromDate,-1);
			schFromDate = DateTime.getFormatDate(schFromDate, "yyyyMMdd", "yyyy-MM-dd");
			
			eventResponse.setETCData("schFromDate", schFromDate);
			eventResponse.setETCData("schToDate", schToDate);
			
			//STATUS Of TRANSFER
			List<MiscellaneousVO> miscCodeList1 = command.searchMiscellaneousList("32");
			eventResponse.setRsVoList(miscCodeList1);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
	
		return eventResponse;
	}
	
	/**
	 * Transfer 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0312
	 * @category searchTransferList 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTransferList(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		
		try{
		
			// BC 객체 생성
			DryWetClaimBC command = new DryWetClaimBCImpl();
	
			CpsCni0312Event event = (CpsCni0312Event)e;
			
			// param	
			
			// 정보 취득
			List<TransferVO> list = command.searchTransferList(event.getTransferCondVO());
			eventResponse.setRsVoList(list);
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * Transfer 리스트 프린트<br>
	 * @author 양정란
	 * @category CPS_CNI_0089
	 * @category printTransfer 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse printTransfer(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		
		try{
		
			// BC 객체 생성
			DryWetClaimBC command = new DryWetClaimBCImpl();
	
			CpsCni0312Event event = (CpsCni0312Event)e;
					
			// Find List 취득
			List<TransferVO> list = command.searchTransferList(event.getTransferCondVO());	
			eventResponse.setRsVoList(list);		
			
		    StringWriter sw = new StringWriter();
		    PrintWriter pw = new PrintWriter(sw);
		   	    
			for (int i = 0; i < list.size(); i++) {			
				TransferVO vo = list.get(i);
				pw.print(vo.getDwClmNo()+SP); 
				pw.print(vo.getClmMiscNm()+SP);
				pw.print(vo.getTrnsKnt()+SP);
				pw.print(vo.getTrnsFmOfcCd()+SP);			
				pw.print(vo.getTrnsFmUsrId()+SP);
				pw.print(vo.getTrnsFmDt()+SP);
				pw.print(vo.getClmTrnsAuthNm()+SP);
				pw.print(vo.getTrnsToOfcCd()+SP);
				pw.print(vo.getTrnsToUsrId()+SP);
				pw.print(vo.getTrnsToDt()+SP);
				pw.println(vo.getTrnsRmk()+SP);
			}
			
			eventResponse.setCustomData(CniConst.RD, sw.toString());
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}	
	
	/**
	 * Transfer Validation<br>
	 * @author 양정란
	 * @category CPS_CNI_0312
	 * @category searchTrnsOfcCd 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTrnsOfcCd(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
		
			// BC 객체 생성
			CodeMgtBC command = new CodeMgtBCImpl(); 
			
			CpsCni0312Event event = (CpsCni0312Event)e;
			
			String[] exist = command.searchOfcCd(event.getTrnsToOfcCd());
			eventResponse.setETCData("EXIST_OFC_CD", exist[0]);
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}	
	
	/**
	 * Transfer Validation<br>
	 * @author 양정란
	 * @category CPS_CNI_0312
	 * @category searchTrnsUsrId 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTrnsUsrId(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		
		try{
		
			// BC 객체 생성
			CodeMgtBC command = new CodeMgtBCImpl(); 
	
			CpsCni0312Event event = (CpsCni0312Event)e;
			
			String[] exist = command.searchUsrId(event.getTrnsToOfcCd(), event.getTrnsToUsrId());
			eventResponse.setETCData("EXIST_USR_ID", exist[0]);
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}		
	
	/**
	 * Transfer  수정<br>
	 * @author 양정란
	 * @category CPS_CNI_0312
	 * @category manageTransfer 
	 * @param e  Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTransfer(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		// BC 객체 생성
		DryWetClaimBC command = new DryWetClaimBCImpl();

		CpsCni0312Event event = (CpsCni0312Event)e;
		
		try {			
			begin();
			
			// event관련 사용자정보 insert
			TransferVO[] transferVOs =  event.getTransferVOs();
			for(int i=0; i<transferVOs.length; i++) {
				//사용자 설정
				transferVOs[i].setUpdUsrId(account.getUsr_id());
			}
			
			command.manageTransfer(transferVOs);
			
			// 에러메세지설정
			eventResponse.setUserMessage(new ErrorHandler("CNI00008").getUserMessage());			
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		return eventResponse;
	}
}