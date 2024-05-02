/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmPri3011Event.java
 *@FileTitle : TRI GRI Calculation - Commodity Select
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.12.10
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.12.10 박성수
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.triproposal.trigricalculationproposal.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriTriGriCmdtVO;
import com.clt.syscommon.common.table.PriTriGriGrpVO;

/**
 * UI_PRI_3011 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_PRI_3011HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Sungsoo, Park
 * @see ESM_PRI_3011HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri3011Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private PriTriGriGrpVO priTriGriGrpVO = null;
	private PriTriGriCmdtVO priTriGriCmdtVO = null;

	public EsmPri3011Event() {
	}

	/**
	 * @return the priTriGriGrpVO
	 */
	public PriTriGriGrpVO getPriTriGriGrpVO() {
		return priTriGriGrpVO;
	}

	/**
	 * @param priTriGriGrpVO the priTriGriGrpVO to set
	 */
	public void setPriTriGriGrpVO(PriTriGriGrpVO priTriGriGrpVO) {
		this.priTriGriGrpVO = priTriGriGrpVO;
	}

	/**
	 * @return the priTriGriCmdtVO
	 */
	public PriTriGriCmdtVO getPriTriGriCmdtVO() {
		return priTriGriCmdtVO;
	}

	/**
	 * @param priTriGriCmdtVO the priTriGriCmdtVO to set
	 */
	public void setPriTriGriCmdtVO(PriTriGriCmdtVO priTriGriCmdtVO) {
		this.priTriGriCmdtVO = priTriGriCmdtVO;
	}

}