/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : IMDG070001Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014-05-30
*@LastModifier : 윤용상
*@LastVersion : 1.0
* 2014-05-30	윤용상
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.event;

import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionInputVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * CargoLoadingApprovalWSProxy 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see CargoLoadingApprovalWSProxy 참조
 * @since J2EE 1.6
 */
public class IMDG070001Event extends EventSupport {

	/** 
	 * 
	 */
	private static final long serialVersionUID = -5469469295733780000L;
	
	private PreRestrictionInputVO preRestrictionInputVO;
	private boolean segChk;
	private boolean vslChk;
	private boolean prtChk;
	
	
	
	/**
	 * @param preRestrictionInputVO
	 * @param segChk
	 * @param vslChk
	 * @param prtChk
	 */
	public IMDG070001Event(PreRestrictionInputVO preRestrictionInputVO,
			boolean segChk, boolean vslChk, boolean prtChk) {
		super();
		this.preRestrictionInputVO = preRestrictionInputVO;
		this.segChk = segChk;
		this.vslChk = vslChk;
		this.prtChk = prtChk;
	}
	/**
	 * @return the preRestrictionInputVO
	 */
	public PreRestrictionInputVO getPreRestrictionInputVO() {
		return preRestrictionInputVO;
	}
	/**
	 * @param preRestrictionInputVO the preRestrictionInputVO to set
	 */
	public void setPreRestrictionInputVO(PreRestrictionInputVO preRestrictionInputVO) {
		this.preRestrictionInputVO = preRestrictionInputVO;
	}
	/**
	 * @return the segChk
	 */
	public boolean isSegChk() {
		return segChk;
	}
	/**
	 * @param segChk the segChk to set
	 */
	public void setSegChk(boolean segChk) {
		this.segChk = segChk;
	}
	/**
	 * @return the vslChk
	 */
	public boolean isVslChk() {
		return vslChk;
	}
	/**
	 * @param vslChk the vslChk to set
	 */
	public void setVslChk(boolean vslChk) {
		this.vslChk = vslChk;
	}
	/**
	 * @return the prtChk
	 */
	public boolean isPrtChk() {
		return prtChk;
	}
	/**
	 * @param prtChk the prtChk to set
	 */
	public void setPrtChk(boolean prtChk) {
		this.prtChk = prtChk;
	}
	
	
}
