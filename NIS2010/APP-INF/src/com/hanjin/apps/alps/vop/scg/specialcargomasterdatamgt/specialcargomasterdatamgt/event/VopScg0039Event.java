/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VmsScg0039Event.java
*@FileTitle : Marine Pollutant (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.29
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.04.29 이도형
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.ScgImdgMrnPolutVO;


/**
 * VMS_SCG-0039 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VMS_SCG-0039HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dohyoung Lee
 * @see VMS_SCG-0039HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopScg0039Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgImdgMrnPolutVO scgImdgMrnPolutVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgImdgMrnPolutVO[] scgImdgMrnPolutVOs = null;

	public VopScg0039Event(){}
	
	public void setScgImdgMrnPolutVO(ScgImdgMrnPolutVO scgImdgMrnPolutVO){
		this. scgImdgMrnPolutVO = scgImdgMrnPolutVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setScgImdgMrnPolutVOS(ScgImdgMrnPolutVO[] scgImdgMrnPolutVOs){
		if (scgImdgMrnPolutVOs != null) {
			ScgImdgMrnPolutVO[] tmpVOs = new ScgImdgMrnPolutVO[scgImdgMrnPolutVOs.length];
			System.arraycopy(scgImdgMrnPolutVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.scgImdgMrnPolutVOs = tmpVOs;
		}
	}

	public ScgImdgMrnPolutVO getScgImdgMrnPolutVO(){
		return scgImdgMrnPolutVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public ScgImdgMrnPolutVO[] getScgImdgMrnPolutVOS(){
		ScgImdgMrnPolutVO[] rtnVOs = null;
		if (this.scgImdgMrnPolutVOs != null) {
			rtnVOs = new ScgImdgMrnPolutVO[scgImdgMrnPolutVOs.length];
			System.arraycopy(scgImdgMrnPolutVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}