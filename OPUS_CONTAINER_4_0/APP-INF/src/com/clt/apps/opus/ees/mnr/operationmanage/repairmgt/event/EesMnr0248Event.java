/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EES_MNR_0248.jsp
*@FileTitle : MNR SOL Invoice File Import
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.25
*@LastModifier : Jun Kato
*@LastVersion : 1.0
* 2015.02.25Jun Kato
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event;

import java.util.HashMap;
import java.util.Map;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.CustomMnrOrdTmpDtlVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.CustomMnrOrdTmpHdrVO;

/**
 * EDI Invoice Parking Lot 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EesMnr0248HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author 박명신
 * @see ees_mnr_0248HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMnr0248Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	private Map<String, Object> voMap = new HashMap<String, Object>();
	
	
	/** com_user Table  Value Object */
	private CustomMnrOrdTmpHdrVO customMnrOrdTmpHdrVO = null;
	
	/** com_users Multi Action을 위한 Collection */
	private CustomMnrOrdTmpHdrVO[] customMnrOrdTmpHdrVOs = null;
	
	/** com_user Table  Value Object */
	private CustomMnrOrdTmpDtlVO customMnrOrdTmpDtlVO = null;

	/** com_users Multi Action을 위한 Collection */
	private CustomMnrOrdTmpDtlVO[] customMnrOrdTmpDtlVOs = null;

	public EesMnr0248Event(){}
		
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