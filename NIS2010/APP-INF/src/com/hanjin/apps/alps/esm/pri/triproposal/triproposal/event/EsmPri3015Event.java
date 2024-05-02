/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmPri3015Event.java
 *@FileTitle : EsmPri3015Event
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.11.30
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.11.30 박성수
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.triproposal.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriTriRtVO;

/**
 * UI_PRI_3015 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_PRI_3015HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Sungsoo, Park
 * @see ESM_PRI_3015HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri3015Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private PriTriRtVO priTriRtVO = null;

	public EsmPri3015Event() {
	}

	/**
	 * @return the priTriRtVO
	 */
	public PriTriRtVO getPriTriRtVO() {
		return priTriRtVO;
	}

	/**
	 * @param priTriRtVO the priTriRtVO to set
	 */
	public void setPriTriRtVO(PriTriRtVO priTriRtVO) {
		this.priTriRtVO = priTriRtVO;
	}

}