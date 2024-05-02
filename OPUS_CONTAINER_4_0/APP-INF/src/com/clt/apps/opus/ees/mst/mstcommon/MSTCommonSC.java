/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EquipmentManagementSC.java
*@FileTitle : ContainerOnOffhire
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mst.mstcommon;

import java.util.List;

import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration.ContainerOnOffhireDBDAO;
import com.clt.apps.opus.ees.mst.mstcommon.mstcommon.basic.MSTCommonBC;
import com.clt.apps.opus.ees.mst.mstcommon.mstcommon.basic.MSTCommonBCImpl;
import com.clt.apps.opus.ees.mst.mstcommon.mstcommon.event.MstComEvent;
import com.clt.apps.opus.ees.mst.mstcommon.mstcommon.vo.AgmtInfoVO;
import com.clt.apps.opus.ees.mst.mstcommon.mstcommon.vo.CommonListVO;
import com.clt.apps.opus.ees.mst.mstcommon.mstcommon.vo.GeneralCodeSearchGRPVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.CryptUtil;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
/**
 * EquipmentManagement Business Logic ServiceCommand 
 * handling business transaction about EquipmentManagement
 * 
 * @author
 * @see ContainerOnOffhireDBDAO
 * @since J2EE 1.6
 */

public class MSTCommonSC extends ServiceCommandSupport {
	// Login User Information
	/**
	 * preceding process for biz scenario EquipmentManagement system<br>
	 * related objects creation EES_MST_0032<br>
	 */
	public void doStart() {
	}

	/**
	 * biz scenario closing EquipmentManagement system<br>
	 * clearing related objects EES_MST_0032<br>
	 */
	public void doEnd() {
	}

	/**
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		if (e.getEventName().equalsIgnoreCase("MstComEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				// retrieving for Common Code
				eventResponse = searchManufacturerListService(e);
			} 
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				// retrieving for Pool List matched with IBCombo Agreement No
				eventResponse = searchEqTypeSizeListService(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)){			
				// retrieving for Delivery Location
				eventResponse = searchManufacturePlaceListService(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)){	
				// retrieving for Agreement Info
				eventResponse = searchAgmtService(e);				
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)){
				// retrieving for Yard Code
				eventResponse = searchYardCodeService(e);	
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)){
				// retrieving for Lessor
				eventResponse = searchLessorCodeService(e);					
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)){
				// retrieving for Unit Type
				eventResponse = searchReeferTypeCodeListService(e);					
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)){
				// retrieving for COM_INTG_CD
				eventResponse = searchComIntgCdListService(e);					
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)){
				// retrieving for Secret Weapon
				eventResponse = searchComboInitDataService(e);					
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)){
				// retrieving for Unit Type
				eventResponse = searchHumidityControlCodeListService(e);					
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)){
				eventResponse = searchSakuraCdListService(e);					
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND40)){
				// retrieving for USER_INFO_PW
				eventResponse = searchUserInfoService(e);					
			}
		}
		return eventResponse;
	}
	
	/**
	 * ManufacturerList : common retrieve<br>
	 * retrieving for Manufacturer List<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchManufacturerListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		MSTCommonBC command = new MSTCommonBCImpl();
		MstComEvent event = (MstComEvent)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		try{	
			List<CommonListVO> list = command.searchManufacturerListBasic(event.getCommonListVO());
			
			StringBuffer comboList = new StringBuffer("");
			 
			for(int i=0; i<list.size(); i++){
				CommonListVO commonListVO = (CommonListVO)list.get(i);
							
				String code = commonListVO.getCode();
				String name	= commonListVO.getCodeNm();
				
				name = name.replaceAll("\"", "");						
				comboList.append(code + '|' + name);
				if(i < list.size()-1) comboList.append("@");
			}
			
			eventResponse.setRsVoList(list);	
			eventResponse.setETCData("comboList", comboList.toString());		
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
		return eventResponse;
	}
	
	/**
	 * EqTypeSizeList :  common retrieve<br><br>
	 * retrieving for Eq Type Size List<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEqTypeSizeListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		MSTCommonBC command = new MSTCommonBCImpl();
		MstComEvent event = (MstComEvent)e;
				
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{	
			List<CommonListVO> list = command.searchEqTypeSizeListBasic(event.getCommonListVO());
			eventResponse.setRsVoList(list);
			
			StringBuffer sCntrTpSzNm = new StringBuffer();
			StringBuffer sCntrTpSzCd = new StringBuffer();
	
			for ( int i = 0 ; i < list.size() ; i++ ) {
				if ( sCntrTpSzNm.toString().equals("") ) {
					sCntrTpSzNm.append(list.get(i).getCode());
					sCntrTpSzCd.append(list.get(i).getCode());
				} else {
					sCntrTpSzNm.append("|").append(list.get(i).getCode());
					sCntrTpSzCd.append("|").append(list.get(i).getCode());
				}
			}
				
			eventResponse.setETCData("cntr_tpsz_nm", sCntrTpSzNm.toString());
			eventResponse.setETCData("cntr_tpsz_cd", sCntrTpSzCd.toString());		
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}			
		return eventResponse;
	}
	
	/**
	 * ManufacturePlaceList : common retrieve<br>
	 * retrieving for Manufacture Place List<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchManufacturePlaceListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		MSTCommonBC command = new MSTCommonBCImpl();
		MstComEvent event = (MstComEvent)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<CommonListVO> list = command.searchManufacturePlaceListBasic(event.getCommonListVO());
			StringBuffer comboList = new StringBuffer("");
			for(int i=0; i<list.size(); i++){
				CommonListVO commonListVO = (CommonListVO)list.get(i);
							
				String code = commonListVO.getCode();
				String name	= commonListVO.getCodeNm();
							
				name = name.replaceAll("\"", "");						
				comboList.append(code + '|' + name);
				if(i < list.size()-1) comboList.append("@");
			}
			eventResponse.setRsVoList(list);
			eventResponse.setETCData("comboList", comboList.toString());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}			
		return eventResponse;
	}
	
	/** EES_MST_0014 에서 
	 * EES_LSE_0091 : Retrieve <br>
	 * retrieving for Lease Agreement List<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgmtService(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		MstComEvent event = (MstComEvent)e;
		MSTCommonBC command = new MSTCommonBCImpl();
		try{	
			List<AgmtInfoVO> list = command.searchAgmtBasic(event.getAgmtInfoVO());
			
			if ( list.size() > 0 ) {
				eventResponse.setRsVoList(list);
			} else {
				eventResponse.setUserMessage(new ErrorHandler("LSE01048").getMessage());
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
		return eventResponse;
	}	
	
	/**
	 * EES_MST_0014, EES_MST_0024 : retrieve<br>
	 * retrieving for Yard Code<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchYardCodeService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		MSTCommonBC command = new MSTCommonBCImpl();
		MstComEvent event = (MstComEvent)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			CommonListVO list = command.searchYardCodeBasic(event.getCommonListVO());
			eventResponse.setRsVo(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}			
		return eventResponse;
	}	
	
	
	/**
	 * EES_MST_0021 : retrieve<br>
	 * retrieving for Lessor code name<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchLessorCodeService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		MSTCommonBC command = new MSTCommonBCImpl();
		MstComEvent event = (MstComEvent)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();				
		try{
			String code_nm= command.searchLessorCodeBasic(event.getCommonListVO());
			eventResponse.setETCData("code_nm",code_nm);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}			
		return eventResponse;
	}
	
	/**
	 * EES_MST_0016 : retrieve<br>
	 * retrieving for Reefer Type Code<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	 
	private EventResponse searchReeferTypeCodeListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		MSTCommonBC command = new MSTCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();				
		try{
			List<CommonListVO> list= command.searchReeferTypeCodeListBasic();
			
			StringBuilder sb = new StringBuilder();
			if(!list.isEmpty()){
				sb.append(list.get(0).getCode()+","+list.get(0).getCodeNm());
				for(int i=1; i<list.size(); i++){
					sb.append("|"+list.get(i).getCode()+","+list.get(i).getCodeNm());
				}
			}
			eventResponse.setETCData("unit_type",sb.toString());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}			
		return eventResponse;
	}
	
	
	/**
	 * EES_MST_0016 : retrieve<br>
	 * retrieving for Humidity Control Code<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchHumidityControlCodeListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		MSTCommonBC command = new MSTCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();				
		try{
			List<CommonListVO> list= command.searchHumidityControlCodeListBasic();
			
			StringBuilder sb = new StringBuilder();
			if(!list.isEmpty()){
				sb.append(list.get(0).getCode()+","+list.get(0).getCodeNm());
				for(int i=1; i<list.size(); i++){
					sb.append("|"+list.get(i).getCode()+","+list.get(i).getCodeNm());
				}
			}
			eventResponse.setETCData("rf_humid_ctrl_val_cd",sb.toString());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}			
		return eventResponse;
	}
	
	
	/**
	 * retrieving for COM_INTG_CD<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchComIntgCdListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		MSTCommonBC command = new MSTCommonBCImpl();
		MstComEvent event = (MstComEvent)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();				
		try{
			List<CommonListVO> list= command.searchComIntgCdListBasic(event.getIntgCdId(),event.getIntgCdVal());
			
			StringBuilder sb = new StringBuilder();
			if(!list.isEmpty()){
				sb.append(list.get(0).getCode()+"|"+list.get(0).getCodeNm());
				for(int i=1; i<list.size(); i++){
					sb.append("@"+list.get(i).getCode()+"|"+list.get(i).getCodeNm());
				}
			}
			eventResponse.setRsVoList(list);
			eventResponse.setETCData("code_nm",sb.toString());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}			
		return eventResponse;
	}
	
	
	/**
	 * retrieving for SAKURA INFO<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchSakuraCdListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		MSTCommonBC command = new MSTCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();				
		try{
			List<CommonListVO> list= command.searchSakuraCdListBasic();
			
			StringBuilder sb = new StringBuilder();
			if(!list.isEmpty()){
				sb.append(list.get(0).getSakuraAcctCd()+"|"+list.get(0).getOpusAcctCd()+"|"+list.get(0).getAcctNm());
				for(int i=1; i<list.size(); i++){
					sb.append("@"+list.get(i).getSakuraAcctCd()+"|"+list.get(i).getOpusAcctCd()+"|"+list.get(i).getAcctNm());
				}
			}
			eventResponse.setRsVoList(list);
			eventResponse.setETCData("sakura_nm",sb.toString());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}			
		return eventResponse;
	}
	
	/**
	 * EES_MST_SECRETWEAPON : Run <br>
	 * [EES_MST_SECRETWEAPON] Query Execute<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */					
	private EventResponse searchComboInitDataService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();  
		try {
			
			MstComEvent event = (MstComEvent)e;          
			MSTCommonBC command = new MSTCommonBCImpl(); 
			SignOnUserAccount account = getSignOnUserAccount();
			GeneralCodeSearchGRPVO generalCodeSearchGRPVO = new GeneralCodeSearchGRPVO();
			generalCodeSearchGRPVO.setComboInitDataINVOS(event.getComboInitDataINVOS());
			
			begin();
			generalCodeSearchGRPVO = command.searchComboInitDataListBasic(generalCodeSearchGRPVO, account);
			commit(); 
			
			for (int i = 0; i < generalCodeSearchGRPVO.getListCustomMstGeneralCodeVOS().size(); i++) {
				eventResponse.setRsVoList(generalCodeSearchGRPVO.getListCustomMstGeneralCodeVOS().get(i));
			}     
		} catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}	
		return eventResponse;
	}
	
	/**
	 * retrieving for UserInfo Search<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchUserInfoService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		MSTCommonBC command = new MSTCommonBCImpl();
		MstComEvent event = (MstComEvent)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		String strPassWd = "";
		String rtnPass = "";
		try{
			strPassWd= command.searchUserInfoBasic(event.getInputUser());
			
			if(!"".equals(strPassWd)){
				rtnPass = CryptUtil.decryptString(strPassWd);
			}
			
			eventResponse.setETCData("user_pass",rtnPass);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}			
		return eventResponse;
	}
	
	
}