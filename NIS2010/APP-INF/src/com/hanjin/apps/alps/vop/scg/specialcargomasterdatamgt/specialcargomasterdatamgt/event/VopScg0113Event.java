/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg0113Event.java
*@FileTitle : Partner’s Contact Point for SPCL CGO (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.05.11 이도형
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.ScgCntcPntPolVO;


/**
 * VMS_SCG-0113 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VMS_SCG-0113HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dohyoung Lee
 * @see VMS_SCG-0113HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopScg0113Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgCntcPntPolVO ScgCntcPntPolVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgCntcPntPolVO[] ScgCntcPntPolVOs = null;

	public VopScg0113Event(){}
	
	public void setScgCntcPntPolVO(ScgCntcPntPolVO ScgCntcPntPolVO){
		this. ScgCntcPntPolVO = ScgCntcPntPolVO;
	}

	public void setScgCntcPntPolVOS(ScgCntcPntPolVO[] ScgCntcPntPolVOs){
		if (ScgCntcPntPolVOs != null) {
			ScgCntcPntPolVO[] tmpVOs = new ScgCntcPntPolVO[ScgCntcPntPolVOs.length];
			System.arraycopy(ScgCntcPntPolVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.ScgCntcPntPolVOs = tmpVOs;
		}
	}

	public ScgCntcPntPolVO getScgCntcPntPolVO(){
		return ScgCntcPntPolVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public ScgCntcPntPolVO[] getScgCntcPntPolVOS(){
		ScgCntcPntPolVO[] rtnVOs = null;
		if (this.ScgCntcPntPolVOs != null) {
			rtnVOs = new ScgCntcPntPolVO[ScgCntcPntPolVOs.length];
			System.arraycopy(ScgCntcPntPolVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}