/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopOpf0020Event.java
*@FileTitle : CBF for Partner Line’s Booking (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 우지석
*@LastVersion : 1.0
* 2009.06.09 우지석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.event;

import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFListOptionVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.PodComboVO;

import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * VOP_OPF_0020 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF_0020HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ji Seok Woo
 * @see VOP_OPF_0020HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopOpf0020Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CBFListOptionVO cBFListOptionVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PodComboVO podComboVO = null;

	/** Table Value Object Multi Data 처리 */
	private CBFListOptionVO[] cBFListOptionVOs = null;

	/** Table Value Object Multi Data 처리 */
	private PodComboVO[] podComboVOs = null;

	public VopOpf0020Event(){}
	
	public void setCBFListOptionVO(CBFListOptionVO cBFListOptionVO){
		this. cBFListOptionVO = cBFListOptionVO;
	}

	public void setPodComboVO(PodComboVO podComboVO){
		this. podComboVO = podComboVO;
	}

	public void setCBFListOptionVOS(CBFListOptionVO[] cBFListOptionVOs){
		if (cBFListOptionVOs != null) {
			CBFListOptionVO[] tmpVOs = new CBFListOptionVO[cBFListOptionVOs.length];
			System.arraycopy(cBFListOptionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cBFListOptionVOs = tmpVOs;
		}
	}
	
	public void setCBFListOptionVOS2(CBFListOptionVO[] cBFListOptionVOs){
		if (cBFListOptionVOs != null) {
			CBFListOptionVO[] tmpVOs = new CBFListOptionVO[cBFListOptionVOs.length];
			System.arraycopy(cBFListOptionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cBFListOptionVOs = tmpVOs;
		}
	}
	
	public void setPodComboVOS(PodComboVO[] podComboVOs){
		if (podComboVOs != null) {
			PodComboVO[] tmpVOs = new PodComboVO[podComboVOs.length];
			System.arraycopy(podComboVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.podComboVOs = tmpVOs;
		}
	}

	public CBFListOptionVO getCBFListOptionVO(){
		return cBFListOptionVO;
	}

	public PodComboVO getPodComboVO(){
		return podComboVO;
	}

	public CBFListOptionVO[] getCBFListOptionVOS(){
		CBFListOptionVO[] rtnVOs = null;
		
		if (this.cBFListOptionVOs != null) {
			rtnVOs = new CBFListOptionVO[cBFListOptionVOs.length];
			System.arraycopy(cBFListOptionVOs, 0, rtnVOs, 0, rtnVOs.length);
		}		
		return rtnVOs;			
	}
	
	
	public CBFListOptionVO[] getCBFListOptionVOS2(){
	   CBFListOptionVO[] rtnVOs = null;
		
		if (this.cBFListOptionVOs != null) {
			rtnVOs = new CBFListOptionVO[cBFListOptionVOs.length];
			System.arraycopy(cBFListOptionVOs, 0, rtnVOs, 0, rtnVOs.length);
		}		
		return rtnVOs;	
	}

	public PodComboVO[] getPodComboVOS(){
		PodComboVO[] rtnVOs = null;
			
		if (this.podComboVOs != null) {
			rtnVOs = new PodComboVO[podComboVOs.length];
			System.arraycopy(podComboVOs, 0, rtnVOs, 0, rtnVOs.length);
		 }		
		 return rtnVOs;
	}
}