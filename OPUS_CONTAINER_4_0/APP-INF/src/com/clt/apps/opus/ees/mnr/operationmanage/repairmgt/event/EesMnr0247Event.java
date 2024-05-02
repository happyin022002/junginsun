/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EesMnr0247Event.java
*@FileTitle : EDI Invoice Parking Lot
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.24
*@LastModifier : Jun Kato
*@LastVersion : 1.0
* 2014.12.24 Jun Kato
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event;

import java.util.HashMap;
import java.util.Map;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.CustomMnrOrdTmpDtlVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.CustomMnrOrdTmpHdrVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.EDIInvoiceParkingLotHDRDataVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.EDIInvoiceParkingLotDTLDataVO;

/**
 * EDI Invoice Parking Lot 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EesMnr0247HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author 박명신
 * @see ees_mnr_0247HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMnr0247Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	private Map<String, Object> voMap = new HashMap<String, Object>();
	
	/** com_user Table  Value Object */
	private EDIInvoiceParkingLotHDRDataVO eDIInvoiceParkingLotHDRDataVO = null;
	
	/** com_users Multi Action을 위한 Collection */
	private EDIInvoiceParkingLotHDRDataVO[] eDIInvoiceParkingLotHDRDataVOs = null;
	
	/** com_user Table  Value Object */
	private CustomMnrOrdTmpHdrVO customMnrOrdTmpHdrVO = null;
	
	/** com_users Multi Action을 위한 Collection */
	private CustomMnrOrdTmpHdrVO[] customMnrOrdTmpHdrVOs = null;
	
	public EesMnr0247Event(){}
		
	public void setEDIInvoiceParkingLotHDRDataVO(EDIInvoiceParkingLotHDRDataVO eDIInvoiceParkingLotHDRDataVO) {
		this.eDIInvoiceParkingLotHDRDataVO = eDIInvoiceParkingLotHDRDataVO;
	}

	public void setEDIInvoiceParkingLotHDRDataVOS(EDIInvoiceParkingLotHDRDataVO[] eDIInvoiceParkingLotHDRDataVOs){
		if(eDIInvoiceParkingLotHDRDataVOs != null){
			EDIInvoiceParkingLotHDRDataVO[] tmpVOs = java.util.Arrays.copyOf(eDIInvoiceParkingLotHDRDataVOs, eDIInvoiceParkingLotHDRDataVOs.length);
			this.eDIInvoiceParkingLotHDRDataVOs = tmpVOs;
		}
	}

	public EDIInvoiceParkingLotHDRDataVO getEDIInvoiceParkingLotHDRDataVO(){
		return eDIInvoiceParkingLotHDRDataVO;
	}

	public EDIInvoiceParkingLotHDRDataVO[] getEDIInvoiceParkingLotHDRDataVOS(){
		EDIInvoiceParkingLotHDRDataVO[] rtnVOs = null;
		if (this.eDIInvoiceParkingLotHDRDataVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(eDIInvoiceParkingLotHDRDataVOs, eDIInvoiceParkingLotHDRDataVOs.length);
		}
		return rtnVOs;
	}

	/** com_user Table  Value Object */
	private EDIInvoiceParkingLotDTLDataVO eDIInvoiceParkingLotDTLDataVO = null;
	
	/** com_users Multi Action을 위한 Collection */
	private EDIInvoiceParkingLotDTLDataVO[] eDIInvoiceParkingLotDTLDataVOs = null;
	
	public void setEDIInvoiceParkingLotDTLDataVO(EDIInvoiceParkingLotDTLDataVO eDIInvoiceParkingLotDTLDataVO) {
		this.eDIInvoiceParkingLotDTLDataVO = eDIInvoiceParkingLotDTLDataVO;
	}

	public void setEDIInvoiceParkingLotDTLDataVOS(EDIInvoiceParkingLotDTLDataVO[] eDIInvoiceParkingLotDTLDataVOs){
		if(eDIInvoiceParkingLotDTLDataVOs != null){
			EDIInvoiceParkingLotDTLDataVO[] tmpVOs = java.util.Arrays.copyOf(eDIInvoiceParkingLotDTLDataVOs, eDIInvoiceParkingLotDTLDataVOs.length);
			this.eDIInvoiceParkingLotDTLDataVOs = tmpVOs;
		}
	}

	public EDIInvoiceParkingLotDTLDataVO getEDIInvoiceParkingLotDTLDataVO(){
		return eDIInvoiceParkingLotDTLDataVO;
	}

	public EDIInvoiceParkingLotDTLDataVO[] getEDIInvoiceParkingLotDTLDataVOS(){
		EDIInvoiceParkingLotDTLDataVO[] rtnVOs = null;
		if (this.eDIInvoiceParkingLotDTLDataVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(eDIInvoiceParkingLotDTLDataVOs, eDIInvoiceParkingLotDTLDataVOs.length);
		}
		return rtnVOs;
	}
	
	public void setCustomMnrOrdTmpHdrVO(CustomMnrOrdTmpHdrVO customMnrOrdTmpHdrVO) {
		this.customMnrOrdTmpHdrVO = customMnrOrdTmpHdrVO;
	}
	
	public void setCustomMnrOrdTmpHdrVOS(CustomMnrOrdTmpHdrVO[] customMnrOrdTmpHdrVOs){
		if(customMnrOrdTmpHdrVOs != null){
			CustomMnrOrdTmpHdrVO[] tmpVOs = java.util.Arrays.copyOf(customMnrOrdTmpHdrVOs, customMnrOrdTmpHdrVOs.length);
			this.customMnrOrdTmpHdrVOs = tmpVOs;
		}
	}
	
	public CustomMnrOrdTmpHdrVO getCustomMnrOrdTmpHdrVO(){
		return customMnrOrdTmpHdrVO;
	}
	
	public CustomMnrOrdTmpHdrVO[] getCustomMnrOrdTmpHdrVOS(){
		CustomMnrOrdTmpHdrVO[] rtnVOs = null;
		if (this.customMnrOrdTmpHdrVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(customMnrOrdTmpHdrVOs, customMnrOrdTmpHdrVOs.length);
		}
		return rtnVOs;
	}

	/** com_user Table  Value Object */
	private CustomMnrOrdTmpDtlVO customMnrOrdTmpDtlVO = null;
	
	/** com_users Multi Action을 위한 Collection */
	private CustomMnrOrdTmpDtlVO[] customMnrOrdTmpDtlVOs = null;
	
	public void setCustomMnrOrdTmpDtlVO(CustomMnrOrdTmpDtlVO customMnrOrdTmpDtlVO) {
		this.customMnrOrdTmpDtlVO = customMnrOrdTmpDtlVO;
	}

	public void setCustomMnrOrdTmpDtlVOS(CustomMnrOrdTmpDtlVO[] customMnrOrdTmpDtlVOs){
		if(customMnrOrdTmpDtlVOs != null){
			CustomMnrOrdTmpDtlVO[] tmpVOs = java.util.Arrays.copyOf(customMnrOrdTmpDtlVOs, customMnrOrdTmpDtlVOs.length);
			this.customMnrOrdTmpDtlVOs = tmpVOs;
		}
	}

	public CustomMnrOrdTmpDtlVO getCustomMnrOrdTmpDtlVO(){
		return customMnrOrdTmpDtlVO;
	}

	public CustomMnrOrdTmpDtlVO[] getCustomMnrOrdTmpDtlVOS(){
		CustomMnrOrdTmpDtlVO[] rtnVOs = null;
		if (this.customMnrOrdTmpDtlVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(customMnrOrdTmpDtlVOs, customMnrOrdTmpDtlVOs.length);
		}
		return rtnVOs;
	}
	
	public void setVO(String key, Object vo){
		voMap.put(key, vo);
	}

	public Object getVO(String key){
		return voMap.get(key);
	}

}