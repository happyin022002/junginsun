/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopOpf0022Event.java
*@FileTitle : CBF - Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.13
*@LastModifier : 김도현
*@LastVersion : 1.0
* 2015.10.13 김도현
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.event;

import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFIFSummaryListVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * vop_opf_0022 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  vop_opf_0022HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ji Seok Woo
 * @see vop_opf_0022HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopOpf0022Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CBFIFSummaryListVO cbfIFSummaryListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CBFIFSummaryListVO[] cbfIFSummaryListVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private CBFIFSummaryListVO[] cbfIFSummarySpecialListVOs = null;

	public VopOpf0022Event(){}
	
	public void setCBFIFSummaryListVO(CBFIFSummaryListVO cbfIFSummaryListVO){
		this.cbfIFSummaryListVO = cbfIFSummaryListVO;
	}

	public void setCBFIFSummaryListVOS(CBFIFSummaryListVO[] cbfIFSummaryListVOs){
		if (cbfIFSummaryListVOs != null) {
			CBFIFSummaryListVO[] tmpVOs = new CBFIFSummaryListVO[cbfIFSummaryListVOs.length];
			System.arraycopy(cbfIFSummaryListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cbfIFSummaryListVOs = tmpVOs;
		}
	}
	
	public CBFIFSummaryListVO getCBFIFSummaryListVO(){
		return cbfIFSummaryListVO;
	}

	public CBFIFSummaryListVO[] getCBFIFSummaryListVOS(){
		CBFIFSummaryListVO[] rtnVOs = null;
		
		if (this.cbfIFSummaryListVOs != null) {
			rtnVOs = new CBFIFSummaryListVO[cbfIFSummaryListVOs.length];
			System.arraycopy(cbfIFSummaryListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;

	}

	public void setCbfIFSummarySpecialListVOs(CBFIFSummaryListVO[] cbfIFSummarySpecialListVOs){		
		if (cbfIFSummarySpecialListVOs != null) {
			CBFIFSummaryListVO[] tmpVOs = new CBFIFSummaryListVO[cbfIFSummarySpecialListVOs.length];
			System.arraycopy(cbfIFSummarySpecialListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cbfIFSummarySpecialListVOs = tmpVOs;
		}
	}

	public CBFIFSummaryListVO[] getCbfIFSummarySpecialListVOs(){
		CBFIFSummaryListVO[] rtnVOs = null;
		
		if (this.cbfIFSummarySpecialListVOs != null) {
			rtnVOs = new CBFIFSummaryListVO[cbfIFSummarySpecialListVOs.length];
			System.arraycopy(cbfIFSummarySpecialListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;

	}
	
}