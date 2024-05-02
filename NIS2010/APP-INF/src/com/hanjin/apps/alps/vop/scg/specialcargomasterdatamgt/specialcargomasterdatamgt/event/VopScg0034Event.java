/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VmsScg0034Event.java
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
import com.hanjin.syscommon.common.table.ScgCntcPntVO;
import com.hanjin.syscommon.common.table.ScgRgnShpOprCdVO;


/**
 * VMS_SCG-0034 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VMS_SCG-0034HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dohyoung Lee
 * @see VMS_SCG-0034HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopScg0034Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgCntcPntVO scgCntcPntVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgRgnShpOprCdVO scgRgnShpOprCdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgCntcPntVO[] scgCntcPntVOs = null;

	public VopScg0034Event(){}
	
	public void setScgCntcPntVO(ScgCntcPntVO scgCntcPntVO){
		this. scgCntcPntVO = scgCntcPntVO;
	}

	public void setScgRgnShpOprCdVO(ScgRgnShpOprCdVO scgRgnShpOprCdVO){
		this. scgRgnShpOprCdVO = scgRgnShpOprCdVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setScgCntcPntVOS(ScgCntcPntVO[] scgCntcPntVOs){
		if (scgCntcPntVOs != null) {
			ScgCntcPntVO[] tmpVOs = new ScgCntcPntVO[scgCntcPntVOs.length];
			System.arraycopy(scgCntcPntVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.scgCntcPntVOs = tmpVOs;
		}
	}

	public ScgCntcPntVO getScgCntcPntVO(){
		return scgCntcPntVO;
	}

	public ScgRgnShpOprCdVO getScgRgnShpOprCdVO(){
		return scgRgnShpOprCdVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public ScgCntcPntVO[] getScgCntcPntVOS(){
		ScgCntcPntVO[] rtnVOs = null;
		if (this.scgCntcPntVOs != null) {
			rtnVOs = new ScgCntcPntVO[scgCntcPntVOs.length];
			System.arraycopy(scgCntcPntVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}