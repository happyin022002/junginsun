/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0936Event.java
*@FileTitle : Arrival Notice Form Setting tab#1
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 
*@LastVersion : 1.0
* 2009.04.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoRcvrVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * esm_bkg_0375 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0375HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see ESM_BKG_0936HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0936Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DoRcvrVO doRcvrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private DoRcvrVO[] doRcvrVOs = null;

	public DoRcvrVO getDoRcvrVO() {
		return doRcvrVO;
	}

	public void setDoRcvrVO(DoRcvrVO doRcvrVO) {
		this.doRcvrVO = doRcvrVO;
	}

//	public DoRcvrVO[] getDoRcvrVOs() {
//		return doRcvrVOs;
//	}
	
	//2015.04.14 Secure Coding 적용[CWE-496]
	public DoRcvrVO[] getDoRcvrVOs() {
		DoRcvrVO[] tmpVOs = null;
		if (this.doRcvrVOs != null) {
			tmpVOs = new DoRcvrVO[doRcvrVOs.length];
			System.arraycopy(doRcvrVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	} 	

//	public void setDoRcvrVOs(DoRcvrVO[] doRcvrVOs) {
//		this.doRcvrVOs = doRcvrVOs;
//	}
	
	//2015.04.14 Secure Coding 적용[CWE-496]
	public void setDoRcvrVOs(DoRcvrVO[] doRcvrVOs) {
		if (doRcvrVOs != null) {
			DoRcvrVO[] tmpVOs = new DoRcvrVO[doRcvrVOs.length];
			System.arraycopy(doRcvrVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.doRcvrVOs = tmpVOs;
		}		
	} 
}