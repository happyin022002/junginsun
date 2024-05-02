/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VmsScg0043Event.java
*@FileTitle : Packaging Code (Creation)
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
import com.hanjin.syscommon.common.table.ScgImdgPckCdVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.PackingStyleCodesVO;


/**
 * VMS_SCG-0043 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VMS_SCG-0043HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dohyoung Lee
 * @see VMS_SCG-0043HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopScg0043Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgImdgPckCdVO scgImdgPckCdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgImdgPckCdVO[] scgImdgPckCdVOs = null;

	public VopScg0043Event(){}
	
	public void setScgImdgPckCdVO(ScgImdgPckCdVO scgImdgPckCdVO){
		this. scgImdgPckCdVO = scgImdgPckCdVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setScgImdgPckCdVOS(ScgImdgPckCdVO[] scgImdgPckCdVOs){
		if (scgImdgPckCdVOs != null) {
			ScgImdgPckCdVO[] tmpVOs = new ScgImdgPckCdVO[scgImdgPckCdVOs.length];
			System.arraycopy(scgImdgPckCdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.scgImdgPckCdVOs = tmpVOs;
		}
	}

	public ScgImdgPckCdVO getScgImdgPckCdVO(){
		return scgImdgPckCdVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public ScgImdgPckCdVO[] getScgImdgPckCdVOS(){
		ScgImdgPckCdVO[] rtnVOs = null;
		if (this.scgImdgPckCdVOs != null) {
			rtnVOs = new ScgImdgPckCdVO[scgImdgPckCdVOs.length];
			System.arraycopy(scgImdgPckCdVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}