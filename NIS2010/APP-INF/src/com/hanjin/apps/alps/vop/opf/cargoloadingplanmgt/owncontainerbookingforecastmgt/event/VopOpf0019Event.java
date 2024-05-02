/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopOpf0019Event.java
*@FileTitle : CBF for Own Booking (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 우지석
*@LastVersion : 1.0
* 2009.05.18 우지석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.event;

import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFListOptionVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * vop_opf_0019 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  vop_opf_0019HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ji Seok Woo
 * @see vop_opf_0019HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopOpf0019Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CBFListOptionVO cbfListOptionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CBFListOptionVO[] cbfListOptionVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private CBFListOptionVO[] cbfListVolumnVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private CBFListOptionVO[] cbfListSpecialVOs = null;

	public VopOpf0019Event(){}
	
	public void setCBFListOptionVO(CBFListOptionVO cbfListOptionVO){
		this.cbfListOptionVO = cbfListOptionVO;
	}

	public void setCBFListOptionVOS(CBFListOptionVO[] cbfListOptionVOs){		
		if (cbfListOptionVOs != null) {
			CBFListOptionVO[] tmpVOs = new CBFListOptionVO[cbfListOptionVOs.length];
			System.arraycopy(cbfListOptionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cbfListOptionVOs = tmpVOs;
		}
	}
	
	
	public void setCBFListVolumnVOS(CBFListOptionVO[] cbfListVolumnVOs){
		if (cbfListVolumnVOs != null) {
			CBFListOptionVO[] tmpVOs = new CBFListOptionVO[cbfListVolumnVOs.length];
			System.arraycopy(cbfListVolumnVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cbfListVolumnVOs = tmpVOs;
		}
	}
	
	public void setCBFListSpecialVOS(CBFListOptionVO[] cbfListSpecialVOs){
		if (cbfListSpecialVOs != null) {
			CBFListOptionVO[] tmpVOs = new CBFListOptionVO[cbfListSpecialVOs.length];
			System.arraycopy(cbfListSpecialVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cbfListSpecialVOs = tmpVOs;
		}
	}
	

	public CBFListOptionVO getCBFListOptionVO(){
		return cbfListOptionVO;
	}

	public CBFListOptionVO[] getCBFListOptionVOS(){
		CBFListOptionVO[] rtnVOs = null;
		
		if (this.cbfListOptionVOs != null) {
			rtnVOs = new CBFListOptionVO[cbfListOptionVOs.length];
			System.arraycopy(cbfListOptionVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;

	}
	
	public CBFListOptionVO[] getCBFListVolumnVOS(){
		CBFListOptionVO[] rtnVOs = null;
		
		if (this.cbfListVolumnVOs != null) {
			rtnVOs = new CBFListOptionVO[cbfListVolumnVOs.length];
			System.arraycopy(cbfListVolumnVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		
	}
	
	public CBFListOptionVO[] getCBFListSpecialVOS(){
          CBFListOptionVO[] rtnVOs = null;
		
		if (this.cbfListSpecialVOs != null) {
			rtnVOs = new CBFListOptionVO[cbfListSpecialVOs.length];
			System.arraycopy(cbfListSpecialVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}