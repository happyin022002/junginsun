/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmPri3001Event.java
 *@FileTitle : TRI Creation & Amendment
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.11.13
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.11.13 박성수
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.triproposal.triproposal.event;

import com.clt.apps.opus.esm.pri.triproposal.trinoteconversionproposal.vo.PriTriNoteConvListVO;
import com.clt.apps.opus.esm.pri.triproposal.triproposal.vo.TriPropParamVO;
import com.clt.apps.opus.esm.pri.triproposal.triproposal.vo.TriPropVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriTriMnVO;
import com.clt.syscommon.common.table.PriTriRtVO;

/**
 * ESM_PRI_3001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_PRI_3001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Sungsoo Park
 * @see ESM_PRI_3001HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri3001Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private TriPropParamVO triPropParamVO = null;
	private PriTriMnVO priTriMnVO = null;
	private PriTriMnVO[] priTriMnVOs = null;
	private PriTriRtVO priTriRtVO = null;
	private PriTriRtVO[] priTriRtVOs = null;
	private TriPropVO triPropVO = null;
	private PriTriNoteConvListVO[] priTriNoteConvListVOs = null;

	public EsmPri3001Event() {
	}

	/**
	 * @return the triPropParamVO
	 */
	public TriPropParamVO getTriPropParamVO() {
		return triPropParamVO;
	}

	/**
	 * @param triPropParamVO the triPropParamVO to set
	 */
	public void setTriPropParamVO(TriPropParamVO triPropParamVO) {
		this.triPropParamVO = triPropParamVO;
	}

	/**
	 * @return the triPropVO
	 */
	public TriPropVO getTriPropVO() {
		return triPropVO;
	}

	/**
	 * @param triPropVO the triPropVO to set
	 */
	public void setTriPropVO(TriPropVO triPropVO) {
		this.triPropVO = triPropVO;
	}

	/**
	 * @return the priTriMnVO
	 */
	public PriTriMnVO getPriTriMnVO() {
		return priTriMnVO;
	}

	/**
	 * @param priTriMnVO the priTriMnVO to set
	 */
	public void setPriTriMnVO(PriTriMnVO priTriMnVO) {
		this.priTriMnVO = priTriMnVO;
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

	/**
	 * @return the priTriNoteConvListVOs
	 */
	public PriTriNoteConvListVO[] getPriTriNoteConvListVOs() {
		PriTriNoteConvListVO[] tmpVOs = null;
		if (this.priTriNoteConvListVOs != null) {
			tmpVOs = new PriTriNoteConvListVO[priTriNoteConvListVOs.length];
			System.arraycopy(priTriNoteConvListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @param priTriNoteConvListVOs the priTriNoteConvListVOs to set
	 */
	public void setPriTriNoteConvListVOs(PriTriNoteConvListVO[] priTriNoteConvListVOs) {
		if (priTriNoteConvListVOs != null) {
			PriTriNoteConvListVO[] tmpVOs = new PriTriNoteConvListVO[priTriNoteConvListVOs.length];
			System.arraycopy(priTriNoteConvListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priTriNoteConvListVOs = tmpVOs;
		}
	}

	/**
	 * @return the priTriMnVOs
	 */
	public PriTriMnVO[] getPriTriMnVOs() {
		PriTriMnVO[] tmpVOs = null;
		if (this.priTriMnVOs != null) {
			tmpVOs = new PriTriMnVO[priTriMnVOs.length];
			System.arraycopy(priTriMnVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @param priTriMnVOs the priTriMnVOs to set
	 */
	public void setPriTriMnVOs(PriTriMnVO[] priTriMnVOs) {
		if (priTriMnVOs != null) {
			PriTriMnVO[] tmpVOs = new PriTriMnVO[priTriMnVOs.length];
			System.arraycopy(priTriMnVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priTriMnVOs = tmpVOs;
		}
	}

	/**
	 * @return the priTriRtVOs
	 */
	public PriTriRtVO[] getPriTriRtVOs() {
		PriTriRtVO[] tmpVOs = null;
		if (this.priTriRtVOs != null) {
			tmpVOs = new PriTriRtVO[priTriRtVOs.length];
			System.arraycopy(priTriRtVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @param priTriRtVOs the priTriRtVOs to set
	 */
	public void setPriTriRtVOs(PriTriRtVO[] priTriRtVOs) {
		if (priTriRtVOs != null) {
			PriTriRtVO[] tmpVOs = new PriTriRtVO[priTriRtVOs.length];
			System.arraycopy(priTriRtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priTriRtVOs = tmpVOs;
		}
	}
}