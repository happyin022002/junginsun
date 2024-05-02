/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiBkg0711Event.java
*@FileTitle : Cargo Release Order History
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 임진영
*@LastVersion : 1.0
* 2009.05.04 임진영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoHisVO;


/**
 * UI_BKG-0711 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_BKG-0711HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lim Jin Young
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
	public DoHisVO[] getDoHisVOs() {
		return doHisVOs;
	}

	/**
	 * @param bkgDoHisVOs the bkgDoHisVOs to set
	 */
	public void setDoHisVOs(DoHisVO[] doHisVOs) {
		this.doHisVOs = doHisVOs;
	}
}