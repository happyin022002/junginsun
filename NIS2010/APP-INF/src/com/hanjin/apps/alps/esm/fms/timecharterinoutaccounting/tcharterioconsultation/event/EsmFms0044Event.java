/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0044Event.java
*@FileTitle : Slip Correction - Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.07
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.08.07 정윤태
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomCsulSlpVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.BsaVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0044 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0044HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung, Yoon-Tae
 * @see ESM_FMS_0044HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmFms0044Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/* CSR No */
	private String csrNo = "";
	
	/** Table Value Object Multi Data 처리 */
	private CustomCsulSlpVO[] customCsulSlpVOs = null;
	
	public void setCustomCsulSlpVOS(CustomCsulSlpVO[] customCsulSlpVOs){
		if (customCsulSlpVOs != null) {
			CustomCsulSlpVO[] tmpVOs = new CustomCsulSlpVO[customCsulSlpVOs.length];
			System.arraycopy(customCsulSlpVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.customCsulSlpVOs = tmpVOs;
		}
	}
	
	public CustomCsulSlpVO[] getCustomCsulSlpVOS(){
		CustomCsulSlpVO[] rtnVOs = null;
		if (this.customCsulSlpVOs != null) {
			rtnVOs = new CustomCsulSlpVO[customCsulSlpVOs.length];
			System.arraycopy(customCsulSlpVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public String getCsrNo() {
		return csrNo;
	}

	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}
}