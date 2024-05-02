/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UiPri0081Event.java
 *@FileTitle : GRI Calculation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.24
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.06.24 박성수
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSpScpRtActCustVO;

/**
 * UI_PRI_0081 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_PRI_0081HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Sungsoo, Park
 * @see ESM_PRI_0081HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri0081Event extends EventSupport {

	private static final long serialVersionUID = 1L;
    private PriSpScpRtActCustVO priSpScpRtActCustVO = null;

	public EsmPri0081Event() {
	}

	
	   
 

	public PriSpScpRtActCustVO getPriSpScpRtActCustVO() {
	    return priSpScpRtActCustVO;
	}

	public void setPriSpScpRtActCustVO(PriSpScpRtActCustVO priSpScpRtActCustVO) {
	    this.priSpScpRtActCustVO = priSpScpRtActCustVO;
	}
}