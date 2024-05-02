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
package com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFListOptionVO;
import com.clt.framework.support.layer.event.EventSupport;

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
			CBFListOptionVO[] tmpVOs = Arrays.copyOf(cbfListOptionVOs, cbfListOptionVOs.length);
			this.cbfListOptionVOs = tmpVOs;
		} // end if
	}
	
	public void setCBFListVolumnVOS(CBFListOptionVO[] cbfListVolumnVOs){
		if (cbfListVolumnVOs != null) {
			CBFListOptionVO[] tmpVOs = Arrays.copyOf(cbfListVolumnVOs, cbfListVolumnVOs.length);
			this.cbfListVolumnVOs = tmpVOs;
		} // end if
	}
	
	public void setCBFListSpecialVOS(CBFListOptionVO[] cbfListSpecialVOs){
		if (cbfListSpecialVOs != null) {
			CBFListOptionVO[] tmpVOs = Arrays.copyOf(cbfListSpecialVOs, cbfListSpecialVOs.length);
			this.cbfListSpecialVOs = tmpVOs;
		} // end if
	}

	public CBFListOptionVO getCBFListOptionVO(){
		return cbfListOptionVO;
	}

	public CBFListOptionVO[] getCBFListOptionVOS(){
		CBFListOptionVO[] rtnVOs = null;
		if (this.cbfListOptionVOs != null) {
			rtnVOs = Arrays.copyOf(this.cbfListOptionVOs, this.cbfListOptionVOs.length);
		} // end if
		return rtnVOs;
	}
	
	public CBFListOptionVO[] getCBFListVolumnVOS(){
		CBFListOptionVO[] rtnVOs = null;
		if (this.cbfListVolumnVOs != null) {
			rtnVOs = Arrays.copyOf(this.cbfListVolumnVOs, this.cbfListVolumnVOs.length);
		} // end if
		return rtnVOs;
	}
	
	public CBFListOptionVO[] getCBFListSpecialVOS(){
		CBFListOptionVO[] rtnVOs = null;
		if (this.cbfListSpecialVOs != null) {
			rtnVOs = Arrays.copyOf(this.cbfListSpecialVOs, this.cbfListSpecialVOs.length);
		} // end if
		return rtnVOs;
	}

}