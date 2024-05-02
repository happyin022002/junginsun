/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CniFileEvent.java
*@FileTitle : CNI File Attach Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.10.12 윤세영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.codemgt.filemgt.event;

import java.util.List;

import com.clt.apps.opus.cps.cni.codemgt.filemgt.vo.CustomFileDwcInsuranceVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * CNI 공통 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  CNI_FILE_HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Yoon, Seyeong
 * @see CNI_FILE_HTMLAction 참조
 * @since J2EE 1.6
 */

public class CniFileEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** DW Claim No */
	private String dwClmNo = "";
	
	/** File Upload Key */
	private List<String> keys = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomFileDwcInsuranceVO[] customFileDwcInsuranceVOs = null;
	
	public CniFileEvent(){}
	
	public void setCustomFileDwcInsuranceVOS(CustomFileDwcInsuranceVO[] customFileDwcInsuranceVOs){
		if(customFileDwcInsuranceVOs != null){
			CustomFileDwcInsuranceVO[] tmpVOs = java.util.Arrays.copyOf(customFileDwcInsuranceVOs, customFileDwcInsuranceVOs.length);
			this.customFileDwcInsuranceVOs = tmpVOs;
		}
	}

	public void setKeys(List<String> keys) {
		this.keys = keys;
	}

	public void setDwClmNo(String dwClmNo) {
		this.dwClmNo = dwClmNo;
	}

	public CustomFileDwcInsuranceVO[] getCustomFileDwcInsuranceVOS(){
		CustomFileDwcInsuranceVO[] rtnVOs = null;
		if (this.customFileDwcInsuranceVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(customFileDwcInsuranceVOs, customFileDwcInsuranceVOs.length);
		}
		return rtnVOs;
	}
	
	public List<String> getKeys() {
		return keys;
	}
	
	public String getDwClmNo() {
		return dwClmNo;
	}
    
}