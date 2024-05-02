/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UiPri0001Event.java
 *@FileTitle : Guideline Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.15
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.04.15 박성수
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scguideline.scsalesguideline.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSgSlsRefVO;

/**
 * UI_PRI_0001_01 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_PRI_0001_01HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Park Sungsoo
 * @see ESM_PRI_0001_01HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri000101Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private PriSgSlsRefVO prisgslsrefvo = null;

	/** Table Value Object Multi Data 처리 */
	private PriSgSlsRefVO[] prisgslsrefvos = null;

	public EsmPri000101Event() {
	}

	public PriSgSlsRefVO getPriSgSlsRefVO() {
		return prisgslsrefvo;
	}

	public void setPriSgSlsRefVO(PriSgSlsRefVO prisgslsrefvo) {
		this.prisgslsrefvo = prisgslsrefvo;
	}

	public PriSgSlsRefVO[] getPriSgSlsRefVOS() {
		return prisgslsrefvos;
	}

	public void setPriSgSlsRefVOS(PriSgSlsRefVO[] prisgslsrefvos) {
		this.prisgslsrefvos = prisgslsrefvos;
	}

}