/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm2004Event.java
*@FileTitle : Own M.G Set Master Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : 박의수
*@LastVersion : 1.0
* 2009.06.23 박의수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event;

import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSSpecINVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_2004 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_2004HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Eui-su Park
 * @see EES_CGM_2004HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm2004Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MGSSpecINVO mGSSpecINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MGSSpecINVO[] mGSSpecINVOs = null;

	public EesCgm2004Event(){}
	
	public void setMGSSpecINVO(MGSSpecINVO mGSSpecINVO){
		this. mGSSpecINVO = mGSSpecINVO;
	}

	public void setMGSSpecINVOS(MGSSpecINVO[] mGSSpecINVOs){
		this. mGSSpecINVOs = mGSSpecINVOs;
	}

	public MGSSpecINVO getMGSSpecINVO(){
		return mGSSpecINVO;
	}

	public MGSSpecINVO[] getMGSSpecINVOS(){
		return mGSSpecINVOs;
	}
}
