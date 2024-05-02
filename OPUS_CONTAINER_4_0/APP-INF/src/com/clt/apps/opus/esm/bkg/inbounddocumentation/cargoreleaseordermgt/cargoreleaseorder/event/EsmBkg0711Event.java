/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiBkg0711Event.java
*@FileTitle : Cargo Release Order History
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 
*@LastVersion : 1.0
* 2009.05.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoHisVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * UI_BKG-0711 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_BKG-0711HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see UI_BKG-0711HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0711Event extends EventSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6766125147959177357L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private DoHisVO doHisVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private DoHisVO[] doHisVOs = null;

	public EsmBkg0711Event(){}

	/**
	 * @return the bkgDoHisVO
	 */
	public DoHisVO getDoHisVO() {
		return doHisVO;
	}

	/**
	 * @param bkgDoHisVO the bkgDoHisVO to set
	 */
	public void setDoHisVO(DoHisVO doHisVO) {
		this.doHisVO = doHisVO;
	}

	/**
	 * @return the bkgDoHisVOs
	 */
//	public DoHisVO[] getDoHisVOs() {
//		return doHisVOs;
//	}

	//2015.04.14 Secure Coding 적용[CWE-496]
	public DoHisVO[] getDoHisVOs() {
		DoHisVO[] tmpVOs = null;
		if (this.doHisVOs != null) {
			tmpVOs = new DoHisVO[doHisVOs.length];
			System.arraycopy(doHisVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	} 	
	
	/**
	 * @param bkgDoHisVOs the bkgDoHisVOs to set
	 */
//	public void setDoHisVOs(DoHisVO[] doHisVOs) {
//		this.doHisVOs = doHisVOs;
//	}
	
	//2015.04.14 Secure Coding 적용[CWE-496]
	public void setDoHisVOs(DoHisVO[] doHisVOs) {
		if (doHisVOs != null) {
			DoHisVO[] tmpVOs = new DoHisVO[doHisVOs.length];
			System.arraycopy(doHisVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.doHisVOs = tmpVOs;
		}		
	} 
}