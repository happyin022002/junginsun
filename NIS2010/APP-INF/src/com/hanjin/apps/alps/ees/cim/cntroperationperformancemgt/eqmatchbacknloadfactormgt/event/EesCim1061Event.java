/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EesCim1061Event.java
*@FileTitle : Location M/B by COA BKG
*Open Issues :
*Change history :	
*@LastModifyDate : 2011.03.18
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2011.03.18 박명신	
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event;

import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.MBSearchOptionCOABKGVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * UI_CIM_1054 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_CIM_1054HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 박명신
 * @see UI_CIM_1054HTMLAction 참조
 * @since J2EE 1.4
 */
public class EesCim1061Event extends EventSupport {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
		
	private MBSearchOptionCOABKGVO mBSearchOptionCOABKGVO = null;

	public MBSearchOptionCOABKGVO getMBSearchOptionCOABKGVO() {
		return mBSearchOptionCOABKGVO;
	}	
			
	public void setMBSearchOptionCOABKGVO(
			MBSearchOptionCOABKGVO searchOptionCOABKGVO) {
		mBSearchOptionCOABKGVO = searchOptionCOABKGVO;
	}	
}
