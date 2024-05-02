/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_923_3Event.java
*@FileTitle : Off-dock CY Invoice 3rd 관리
*Open Issues :
*Change history :
*@LastModifyDate : 2007-10-09
*@LastModifier : byungheeyoo
*@LastVersion : 1.0
* 2006-11-27 byungheeyoo
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.event;

import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.TesN3rdPtyIfVO;


/**
 * ESD_TES_925_4 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_925_4HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author byungheeyoo
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTes9254Event extends EventSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** TES_N3RD_PTY_IF Table  Value Object */
	private TesN3rdPtyIfVO tesN3rdPtyIfVO = null;
		
	public EsdTes9254Event(){}
	
	public void setTesN3rdPtyIfVO( TesN3rdPtyIfVO tesN3rdPtyIfVO ){
		this.tesN3rdPtyIfVO = tesN3rdPtyIfVO;
	}
		
	public TesN3rdPtyIfVO getTesN3rdPtyIfVO(){
		return tesN3rdPtyIfVO;
	}
	
}
