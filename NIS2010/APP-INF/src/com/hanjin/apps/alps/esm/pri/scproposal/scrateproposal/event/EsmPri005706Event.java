/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmPri005706Event.java
 *@FileTitle : Amendment History Inquiry - General/Special Rate
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.25
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.05.25 박성수
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSpScpGriGrpVO;
import com.hanjin.syscommon.common.table.PriSpScpRtCmdtHdrVO;
import com.hanjin.syscommon.common.table.PriSpScpRtCmdtRoutVO;
import com.hanjin.syscommon.common.table.PriSpScpRtVO;

/**
 * UI_PRI_0030 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_PRI_0030HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Sungsoo, Park
 * @see ESM_PRI_0003_08HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri005706Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO = null;
	private PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO = null;
	private PriSpScpRtVO priSpScpRtVO = null;
	private PriSpScpGriGrpVO priSpScpGriGrpVO = null;
	private String isConversion = "";

	public EsmPri005706Event() {
	}

	/**
	 * @return the priSpScpRtCmdtHdrVO
	 */
	public PriSpScpRtCmdtHdrVO getPriSpScpRtCmdtHdrVO() {
		return priSpScpRtCmdtHdrVO;
	}

	/**
	 * @param priSpScpRtCmdtHdrVO the priSpScpRtCmdtHdrVO to set
	 */
	public void setPriSpScpRtCmdtHdrVO(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO) {
		this.priSpScpRtCmdtHdrVO = priSpScpRtCmdtHdrVO;
	}

	/**
	 * @return the priSpScpRtCmdtRoutVO
	 */
	public PriSpScpRtCmdtRoutVO getPriSpScpRtCmdtRoutVO() {
		return priSpScpRtCmdtRoutVO;
	}

	/**
	 * @param priSpScpRtCmdtRoutVO the priSpScpRtCmdtRoutVO to set
	 */
	public void setPriSpScpRtCmdtRoutVO(PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO) {
		this.priSpScpRtCmdtRoutVO = priSpScpRtCmdtRoutVO;
	}

	/**
	 * @return the priSpScpRtVO
	 */
	public PriSpScpRtVO getPriSpScpRtVO() {
		return priSpScpRtVO;
	}

	/**
	 * @param priSpScpRtVO the priSpScpRtVO to set
	 */
	public void setPriSpScpRtVO(PriSpScpRtVO priSpScpRtVO) {
		this.priSpScpRtVO = priSpScpRtVO;
	}

	/**
	 * @return the isConversion
	 */
	public String getIsConversion() {
		return isConversion;
	}

	/**
	 * @param isConversion the isConversion to set
	 */
	public void setIsConversion(String isConversion) {
		this.isConversion = isConversion;
	}

	/**
	 * @return the priSpScpGriGrpVO
	 */
	public PriSpScpGriGrpVO getPriSpScpGriGrpVO() {
		return priSpScpGriGrpVO;
	}

	/**
	 * @param priSpScpGriGrpVO the priSpScpGriGrpVO to set
	 */
	public void setPriSpScpGriGrpVO(PriSpScpGriGrpVO priSpScpGriGrpVO) {
		this.priSpScpGriGrpVO = priSpScpGriGrpVO;
	}

}