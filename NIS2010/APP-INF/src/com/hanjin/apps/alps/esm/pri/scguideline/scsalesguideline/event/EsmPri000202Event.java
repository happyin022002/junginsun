/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UiPri000202Event.java
 *@FileTitle : Sales Guideline Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.01
 *@LastModifier : 최성민
 *@LastVersion : 1.0
 * 2009.10.01 최성민
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scguideline.scsalesguideline.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSgSlsRefVO;

/**
 * UI_PRI_0002_02 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_PRI_0002_02HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Park Sungsoo
 * @see ESM_PRI_0002_02HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri000202Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private PriSgSlsRefVO prisgslsrefvo = null;

	public EsmPri000202Event() {
	}

	public PriSgSlsRefVO getPriSgSlsRefVO() {
		return prisgslsrefvo;
	}

	public void setPriSgSlsRefVO(PriSgSlsRefVO prisgslsrefvo) {
		this.prisgslsrefvo = prisgslsrefvo;
	}
}