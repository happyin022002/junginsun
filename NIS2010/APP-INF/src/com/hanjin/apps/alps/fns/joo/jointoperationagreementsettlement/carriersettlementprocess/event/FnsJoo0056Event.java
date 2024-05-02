/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0056Event.java
*@FileTitle : RDR Download by Lane
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.09.17 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.RdrLoadVO;


/**
 * FNS_JOO_0056 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0056HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see FNS_JOO_0056HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0056Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RdrLoadVO rdrLoadVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RdrLoadVO[] rdrLoadVOs = null;

	public FnsJoo0056Event(){}
	
	public void setRdrLoadVO(RdrLoadVO rdrLoadVO){
		this. rdrLoadVO = rdrLoadVO;
	}

	public void setRdrLoadVOS(RdrLoadVO[] rdrLoadVOs){
		if (rdrLoadVOs != null) {
			RdrLoadVO[] tmpVOs = new RdrLoadVO[rdrLoadVOs.length];
			System.arraycopy(rdrLoadVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rdrLoadVOs = tmpVOs;
		}		
	}

	public RdrLoadVO getRdrLoadVO(){
		return rdrLoadVO;
	}

	public RdrLoadVO[] getRdrLoadVOS(){
		RdrLoadVO[] rtnVOs = null;
		if (this.rdrLoadVOs != null) {
			rtnVOs = new RdrLoadVO[rdrLoadVOs.length];
			System.arraycopy(rdrLoadVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}

}