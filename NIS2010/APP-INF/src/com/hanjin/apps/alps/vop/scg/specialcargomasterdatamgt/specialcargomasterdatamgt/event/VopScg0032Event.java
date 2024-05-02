/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VmsScg0032Event.java
*@FileTitle : SPCL CGO RSO (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.05.04 이도형
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.ScgRgnShpOprCdVO;


/**
 * VMS_SCG-0032 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VMS_SCG-0032HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dohyoung Lee
 * @see VMS_SCG-0032HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopScg0032Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgRgnShpOprCdVO scgRgnShpOprCdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgRgnShpOprCdVO[] scgRgnShpOprCdVOs = null;

	public VopScg0032Event(){}
	
	public void setScgRgnShpOprCdVO(ScgRgnShpOprCdVO scgRgnShpOprCdVO){
		this. scgRgnShpOprCdVO = scgRgnShpOprCdVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setScgRgnShpOprCdVOS(ScgRgnShpOprCdVO[] scgRgnShpOprCdVOs){
		if (scgRgnShpOprCdVOs != null) {
			ScgRgnShpOprCdVO[] tmpVOs = new ScgRgnShpOprCdVO[scgRgnShpOprCdVOs.length];
			System.arraycopy(scgRgnShpOprCdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.scgRgnShpOprCdVOs = tmpVOs;
		}
	}

	public ScgRgnShpOprCdVO getScgRgnShpOprCdVO(){
		return scgRgnShpOprCdVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public ScgRgnShpOprCdVO[] getScgRgnShpOprCdVOS(){
		ScgRgnShpOprCdVO[] rtnVOs = null;
		if (this.scgRgnShpOprCdVOs != null) {
			rtnVOs = new ScgRgnShpOprCdVO[scgRgnShpOprCdVOs.length];
			System.arraycopy(scgRgnShpOprCdVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}