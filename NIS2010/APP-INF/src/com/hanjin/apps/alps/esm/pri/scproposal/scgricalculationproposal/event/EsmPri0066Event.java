/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UiPri0066Event.java
 *@FileTitle : GRI Calculation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.22
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.06.22 박성수
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.event;

import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo.RsltGriCalcListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo.ScGriCalcVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSpScpGriGrpVO;

/**
 * UI_PRI_0066 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_PRI_0066HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Sungsoo, Park
 * @see ESM_PRI_0066HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri0066Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private PriSpScpGriGrpVO priSpScpGriGrpVO = null;
	private RsltGriCalcListVO rsltGriCalcListVO = null;
	private ScGriCalcVO scGriCalcVO = null;

	public EsmPri0066Event() {
	}

	public PriSpScpGriGrpVO getPriSpScpGriGrpVO() {
		return priSpScpGriGrpVO;
	}

	public void setPriSpScpGriGrpVO(PriSpScpGriGrpVO priSpScpGriGrpVO) {
		this.priSpScpGriGrpVO = priSpScpGriGrpVO;
	}

	public RsltGriCalcListVO getRsltGriCalcListVO() {
		return rsltGriCalcListVO;
	}

	public void setRsltGriCalcListVO(RsltGriCalcListVO rsltGriCalcListVO) {
		this.rsltGriCalcListVO = rsltGriCalcListVO;
	}

	public ScGriCalcVO getScGriCalcVO() {
		return scGriCalcVO;
	}

	public void setScGriCalcVO(ScGriCalcVO scGriCalcVO) {
		this.scGriCalcVO = scGriCalcVO;
	}

}