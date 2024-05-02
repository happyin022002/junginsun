/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0162Event.java
*@FileTitle : Container List on Stowage & B/L
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.06.16 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.CntrStowageintVO;


/**
 * ESM_BKG_0162 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0162HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Jong
 * @see ESM_BKG_0162HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0162Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CntrStowageintVO cntrStowageintVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CntrStowageintVO[] cntrStowageintVOs = null;

	public EsmBkg0162Event(){}
	
	public void setCntrStowageintVO(CntrStowageintVO cntrStowageintVO){
		this. cntrStowageintVO = cntrStowageintVO;
	}
 
	public void setCntrStowageintVOS(CntrStowageintVO[] cntrStowageintVOs){
		this. cntrStowageintVOs = cntrStowageintVOs;
	}

	public CntrStowageintVO getCntrStowageintVO(){
		return cntrStowageintVO;
	}

	public CntrStowageintVO[] getCntrStowageintVOS(){
		return cntrStowageintVOs;
	}

}