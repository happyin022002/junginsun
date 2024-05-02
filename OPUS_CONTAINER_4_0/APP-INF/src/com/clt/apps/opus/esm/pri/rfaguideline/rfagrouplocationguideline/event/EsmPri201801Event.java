/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmPri201801Event.java
 *@FileTitle : RFA Guideline Inquiry - Location Group
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.27
 *@LastModifier : 최성민
 *@LastVersion : 1.0
 * 2009.07.27 최성민
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaguideline.rfagrouplocationguideline.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriRgGrpLocDtlVO;
import com.clt.syscommon.common.table.PriRgGrpLocVO;

/**
 * ESM_PRI_2018_01 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_PRI_2018_01HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Park Sungsoo
 * @see ESM_PRI_2018_01HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri201801Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private PriRgGrpLocVO prisggrplocvo = null;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private PriRgGrpLocDtlVO prisggrplocdtlvo = null;
	
	public EsmPri201801Event() {
	}

	public PriRgGrpLocVO getPriRgGrpLocVO() {
		return prisggrplocvo;
	}

	public void setPriRgGrpLocVO(PriRgGrpLocVO prisggrplocvo) {
		this.prisggrplocvo = prisggrplocvo;
	}


	public PriRgGrpLocDtlVO getPriRgGrpLocDtlVO() {
		return prisggrplocdtlvo;
	}

	public void setPriRgGrpLocDtlVO(PriRgGrpLocDtlVO prisggrplocdtlvo) {
		this.prisggrplocdtlvo = prisggrplocdtlvo;
	}

}