/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmPri3010Event.java
 *@FileTitle : TRI GRI Calculation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.12.10
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.12.10 박성수
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.triproposal.trigricalculationproposal.event;

import com.clt.apps.opus.esm.pri.triproposal.trigricalculationproposal.vo.TriGriCalcVO;
import com.clt.apps.opus.esm.pri.triproposal.triproposal.vo.TriPropGRIVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriTriGriGrpVO;

/**
 * UI_PRI_3010 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_PRI_3010HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Sungsoo, Park
 * @see ESM_PRI_3010HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri3010Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private PriTriGriGrpVO priTriGriGrpVO = null;
	private TriGriCalcVO triGriCalcVO = null;
	private TriPropGRIVO triPropGRIVO = null;

	public EsmPri3010Event() {
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
	 * @return the triGriCalcVO
	 */
	public TriGriCalcVO getTriGriCalcVO() {
		return triGriCalcVO;
	}

	/**
	 * @param triGriCalcVO the triGriCalcVO to set
	 */
	public void setTriGriCalcVO(TriGriCalcVO triGriCalcVO) {
		this.triGriCalcVO = triGriCalcVO;
	}

	/**
	 * @return the triPropGRIVO
	 */
	public TriPropGRIVO getTriPropGRIVO() {
		return triPropGRIVO;
	}

	/**
	 * @param triPropGRIVO the triPropGRIVO to set
	 */
	public void setTriPropGRIVO(TriPropGRIVO triPropGRIVO) {
		this.triPropGRIVO = triPropGRIVO;
	}

}