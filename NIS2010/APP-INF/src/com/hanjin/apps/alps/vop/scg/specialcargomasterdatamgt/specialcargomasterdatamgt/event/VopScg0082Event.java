/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VopScg0082Event.java
*@FileTitle : Port Code (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2010.02.01 이도형
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.ScgCdVO;


/**
 * VOP_AOM_0082 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_AOM_0082HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dohyoung Lee
 * @see VOP_SCG_0082HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg0082Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgCdVO scgCdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgCdVO[] scgCdVOs = null;

	public VopScg0082Event(){}
	
	public void setScgCdVO(ScgCdVO scgCdVO){
		this. scgCdVO = scgCdVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setScgCdVOS(ScgCdVO[] scgCdVOs){
		if (scgCdVOs != null) {
			ScgCdVO[] tmpVOs = new ScgCdVO[scgCdVOs.length];
			System.arraycopy(scgCdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.scgCdVOs = tmpVOs;
		}
	}

	public ScgCdVO getScgCdVO(){
		return scgCdVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public ScgCdVO[] getScgCdVOS(){
		ScgCdVO[] rtnVOs = null;
		if (this.scgCdVOs != null) {
			rtnVOs = new ScgCdVO[scgCdVOs.length];
			System.arraycopy(scgCdVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}