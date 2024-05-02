/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiComEnsN13Event.java
*@FileTitle : Currency Code
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.22
*@LastModifier : 박의수
*@LastVersion : 1.0
* 2009.04.22 박의수
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.currency.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MdmCurrencyVO;


/**
 * UI_COM_ENS_N13 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_COM_ENS_N13HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Eui-Su Park
 * @see COM_ENS_N13HTMLAction 참조
 * @since J2EE 1.4
 */

public class ComEnsN13Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmCurrencyVO mdmcurrencyvo = null;
	
	/** Table Value Object Multi Data 처리 */
	private MdmCurrencyVO[] mdmcurrencyvos = null;

	public ComEnsN13Event(){}
	
	public void setMdmCurrencyVO(MdmCurrencyVO mdmcurrencyvo){
		this. mdmcurrencyvo = mdmcurrencyvo;
	}

	public void setMdmCurrencyVOS(MdmCurrencyVO[] mdmcurrencyvos){
		this. mdmcurrencyvos = mdmcurrencyvos;
	}

	public MdmCurrencyVO getMdmCurrencyVO(){
		return mdmcurrencyvo;
	}

	public MdmCurrencyVO[] getMdmCurrencyVOS(){
		return mdmcurrencyvos;
	}

}