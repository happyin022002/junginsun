/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : RfaSummryAcceptAllVO.java
 *@FileTitle : RfaSummryAcceptAllVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.10.27
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.10.27 전지예
 * 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo;

import java.io.Serializable;

import com.hanjin.syscommon.common.table.PriRpScpGrpCmdtDtlVO;
import com.hanjin.syscommon.common.table.PriRpScpGrpLocDtlVO;
import com.hanjin.syscommon.common.table.PriRpScpNoteCtntVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtHdrVO;
import com.hanjin.syscommon.common.table.PriRpScpRtVO;
import com.hanjin.syscommon.common.table.PriRpScpTrspAddChgVO;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 전지예
 * @since J2EE 1.5
 */
public class RfaSummryAcceptAllVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private PriRpScpRtVO[] priRpScpRtVOS = null;
	private PriRpScpRtCmdtHdrVO[] priRpScpRtCmdtHdrVOS = null;
	private PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOS = null;
	private PriRpScpNoteCtntVO[] priRpScpNoteCtntVOS = null;
	private PriRpScpGrpLocDtlVO[] priRpScpGrpLocDtlVOS = null;
	private PriRpScpGrpCmdtDtlVO[] priRpScpGrpCmdtDtlVOS = null;
	
	/**
	 * @return the priRpScpRtCmdtHdrVOS
	 */
	public PriRpScpRtCmdtHdrVO[] getPriRpScpRtCmdtHdrVOS() {
		return priRpScpRtCmdtHdrVOS;
	}
	
	/**
	 * @param priRpScpRtCmdtHdrVOS the priRpScpRtCmdtHdrVOS to set
	 */
	public void setPriRpScpRtCmdtHdrVOS(PriRpScpRtCmdtHdrVO[] priRpScpRtCmdtHdrVOS) {
		this.priRpScpRtCmdtHdrVOS = priRpScpRtCmdtHdrVOS;
	}

	/**
	 * @return the priRpScpRtVOS
	 */
	public PriRpScpRtVO[] getPriRpScpRtVOS() {
		return priRpScpRtVOS;
	}

	/**
	 * @param priRpScpRtVOS the priRpScpRtVOS to set
	 */
	public void setPriRpScpRtVOS(PriRpScpRtVO[] priRpScpRtVOS) {
		this.priRpScpRtVOS = priRpScpRtVOS;
	}

	/**
	 * @return the priRpScpTrspAddChgVOS
	 */
	public PriRpScpTrspAddChgVO[] getPriRpScpTrspAddChgVOS() {
		return priRpScpTrspAddChgVOS;
	}

	/**
	 * @param priRpScpTrspAddChgVOS the priRpScpTrspAddChgVOS to set
	 */
	public void setPriRpScpTrspAddChgVOS(PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOS) {
		this.priRpScpTrspAddChgVOS = priRpScpTrspAddChgVOS;
	}

	/**
	 * @return the priRpScpNoteCtntVOS
	 */
	public PriRpScpNoteCtntVO[] getPriRpScpNoteCtntVOS() {
		return priRpScpNoteCtntVOS;
	}

	/**
	 * @param priRpScpNoteCtntVOS the priRpScpNoteCtntVOS to set
	 */
	public void setPriRpScpNoteCtntVOS(PriRpScpNoteCtntVO[] priRpScpNoteCtntVOS) {
		this.priRpScpNoteCtntVOS = priRpScpNoteCtntVOS;
	}

	/**
	 * @return the priRpScpGrpLocDtlVOS
	 */
	public PriRpScpGrpLocDtlVO[] getPriRpScpGrpLocDtlVOS() {
		return priRpScpGrpLocDtlVOS;
	}

	/**
	 * @param priRpScpGrpLocDtlVOS the priRpScpGrpLocDtlVOS to set
	 */
	public void setPriRpScpGrpLocDtlVOS(PriRpScpGrpLocDtlVO[] priRpScpGrpLocDtlVOS) {
		this.priRpScpGrpLocDtlVOS = priRpScpGrpLocDtlVOS;
	}

	/**
	 * @return the priRpScpGrpCmdtDtlVOS
	 */
	public PriRpScpGrpCmdtDtlVO[] getPriRpScpGrpCmdtDtlVOS() {
		return priRpScpGrpCmdtDtlVOS;
	}

	/**
	 * @param priRpScpGrpCmdtDtlVOS the priRpScpGrpCmdtDtlVOS to set
	 */
	public void setPriRpScpGrpCmdtDtlVOS(PriRpScpGrpCmdtDtlVO[] priRpScpGrpCmdtDtlVOS) {
		this.priRpScpGrpCmdtDtlVOS = priRpScpGrpCmdtDtlVOS;
	}

}
