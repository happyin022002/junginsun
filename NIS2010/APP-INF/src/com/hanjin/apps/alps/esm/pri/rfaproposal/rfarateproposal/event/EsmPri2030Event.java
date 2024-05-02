/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : EsmPri2030Event.java
 *@FileTitle : RFA Proposal Creation - Route Popup (Add-On Tariff Management)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.09.25
 *@LastModifier : 이은섭
 *@LastVersion : 1.0
 * 1.0 Creation
=========================================================
* History
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.FicCheckCYPortLocationVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.FicRouteGroupVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtHdrVO;
import com.hanjin.syscommon.common.table.PriRpScpRtRoutPntVO;
import com.hanjin.syscommon.common.table.PriRpScpRtRoutViaVO;

/**
 * UI_PRI_2030 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Eunsup, Lee
 * @see ESM_PRI_2030HTMLAction 참조
 * @since J2EE 1.4
 */
 
public class EsmPri2030Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	private PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO = null;

	private PriRpScpRtRoutPntVO[] priRpScpRtRoutOrgPntVO = null;
	private PriRpScpRtRoutViaVO[] priRpScpRtRoutOrgViaVO = null;
	private PriRpScpRtRoutViaVO[] priRpScpRtRoutDestViaVO = null;
	private PriRpScpRtRoutPntVO[] priRpScpRtRoutDestPntVO = null;
	private FicRouteGroupVO ficRouteGroupVO = null;
	private FicCheckCYPortLocationVO ficCheckCYPortLocationVO = null;

	public EsmPri2030Event() {
	}

	/**
	 * @return the priRpScpRtRoutOrgPntVO
	 */
	public PriRpScpRtRoutPntVO[] getPriRpScpRtRoutOrgPntVO() {
		PriRpScpRtRoutPntVO[] rtnVOs = null;
		if (this.priRpScpRtRoutOrgPntVO != null) {
			rtnVOs = new PriRpScpRtRoutPntVO[priRpScpRtRoutOrgPntVO.length];
			System.arraycopy(priRpScpRtRoutOrgPntVO, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param priRpScpRtRoutOrgPntVO the priRpScpRtRoutOrgPntVO to set
	 */
	public void setPriRpScpRtRoutOrgPntVO(PriRpScpRtRoutPntVO[] priRpScpRtRoutOrgPntVO){
		if(priRpScpRtRoutOrgPntVO != null){
			PriRpScpRtRoutPntVO[] tmpVOs = new PriRpScpRtRoutPntVO[priRpScpRtRoutOrgPntVO.length];
			System.arraycopy(priRpScpRtRoutOrgPntVO, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpRtRoutOrgPntVO = tmpVOs;
		}
	}

	/**
	 * @return the priRpScpRtRoutOrgViaVO
	 */
	public PriRpScpRtRoutViaVO[] getPriRpScpRtRoutOrgViaVO() {
		PriRpScpRtRoutViaVO[] rtnVOs = null;
		if (this.priRpScpRtRoutOrgViaVO != null) {
			rtnVOs = new PriRpScpRtRoutViaVO[priRpScpRtRoutOrgViaVO.length];
			System.arraycopy(priRpScpRtRoutOrgViaVO, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param priRpScpRtRoutOrgViaVO the priRpScpRtRoutOrgViaVO to set
	 */
	public void setPriRpScpRtRoutOrgViaVO(PriRpScpRtRoutViaVO[] priRpScpRtRoutOrgViaVO){
		if(priRpScpRtRoutOrgViaVO != null){
			PriRpScpRtRoutViaVO[] tmpVOs = new PriRpScpRtRoutViaVO[priRpScpRtRoutOrgViaVO.length];
			System.arraycopy(priRpScpRtRoutOrgViaVO, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpRtRoutOrgViaVO = tmpVOs;
		}
	}

	/**
	 * @return the priRpScpRtRoutDestViaVO
	 */
	public PriRpScpRtRoutViaVO[] getPriRpScpRtRoutDestViaVO() {
		PriRpScpRtRoutViaVO[] rtnVOs = null;
		if (this.priRpScpRtRoutDestViaVO != null) {
			rtnVOs = new PriRpScpRtRoutViaVO[priRpScpRtRoutDestViaVO.length];
			System.arraycopy(priRpScpRtRoutDestViaVO, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param priRpScpRtRoutDestViaVO the priRpScpRtRoutDestViaVO to set
	 */
	public void setPriRpScpRtRoutDestViaVO(PriRpScpRtRoutViaVO[] priRpScpRtRoutDestViaVO){
		if(priRpScpRtRoutDestViaVO != null){
			PriRpScpRtRoutViaVO[] tmpVOs = new PriRpScpRtRoutViaVO[priRpScpRtRoutDestViaVO.length];
			System.arraycopy(priRpScpRtRoutDestViaVO, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpRtRoutDestViaVO = tmpVOs;
		}
	}

	/**
	 * @return the priRpScpRtRoutDestPntVO
	 */
	public PriRpScpRtRoutPntVO[] getPriRpScpRtRoutDestPntVO() {
		PriRpScpRtRoutPntVO[] rtnVOs = null;
		if (this.priRpScpRtRoutDestPntVO != null) {
			rtnVOs = new PriRpScpRtRoutPntVO[priRpScpRtRoutDestPntVO.length];
			System.arraycopy(priRpScpRtRoutDestPntVO, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param priRpScpRtRoutDestPntVO the priRpScpRtRoutDestPntVO to set
	 */
	public void setPriRpScpRtRoutDestPntVO(PriRpScpRtRoutPntVO[] priRpScpRtRoutDestPntVO){
		if(priRpScpRtRoutDestPntVO != null){
			PriRpScpRtRoutPntVO[] tmpVOs = new PriRpScpRtRoutPntVO[priRpScpRtRoutDestPntVO.length];
			System.arraycopy(priRpScpRtRoutDestPntVO, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpRtRoutDestPntVO = tmpVOs;
		}
	}

	/**
	 * @return the ficRouteGroupVO
	 */
	public FicRouteGroupVO getFicRouteGroupVO() {
		return ficRouteGroupVO;
	}

	/**
	 * @param ficRouteGroupVO the ficRouteGroupVO to set
	 */
	public void setFicRouteGroupVO(FicRouteGroupVO ficRouteGroupVO) {
		this.ficRouteGroupVO = ficRouteGroupVO;
	}

	/**
	 * @return the ficRouteGroupVO
	 */
	public FicCheckCYPortLocationVO getFicCheckCYPortLocationVO() {
		return ficCheckCYPortLocationVO;
	}

	/**
	 * @param ficCheckCYPortLocationVO the ficCheckCYPortLocationVO to set
	 */
	public void setFicCheckCYPortLocationVO(FicCheckCYPortLocationVO ficCheckCYPortLocationVO) {
		this.ficCheckCYPortLocationVO = ficCheckCYPortLocationVO;
	}

	/**
	 * @return the priRpScpRtCmdtHdrVO
	 */
	public PriRpScpRtCmdtHdrVO getPriRpScpRtCmdtHdrVO() {
		return priRpScpRtCmdtHdrVO;
	}

	/**
	 * @param priRpScpRtCmdtHdrVO the priRpScpRtCmdtHdrVO to set
	 */
	public void setPriRpScpRtCmdtHdrVO(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) {
		this.priRpScpRtCmdtHdrVO = priRpScpRtCmdtHdrVO;
	}

}