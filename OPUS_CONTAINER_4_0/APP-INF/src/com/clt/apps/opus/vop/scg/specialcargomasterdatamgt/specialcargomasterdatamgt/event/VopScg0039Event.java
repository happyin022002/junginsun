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
package com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event;

import java.util.Arrays;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.ScgImdgMrnPolutVO;


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

	public void setScgImdgMrnPolutVOS(ScgImdgMrnPolutVO[] scgImdgMrnPolutVOs){
		if(scgImdgMrnPolutVOs != null){
			ScgImdgMrnPolutVO[] tmpVOs = Arrays.copyOf(scgImdgMrnPolutVOs, scgImdgMrnPolutVOs.length);
			this.scgImdgMrnPolutVOs = tmpVOs;
		}
	}

	public ScgImdgMrnPolutVO getScgImdgMrnPolutVO(){
		return scgImdgMrnPolutVO;
	}

	public ScgImdgMrnPolutVO[] getScgImdgMrnPolutVOS(){
		ScgImdgMrnPolutVO[] rtnVOs = null;
		if (this.scgImdgMrnPolutVOs != null) {
			rtnVOs = Arrays.copyOf(scgImdgMrnPolutVOs, scgImdgMrnPolutVOs.length);
		}
		return rtnVOs;
	}

}