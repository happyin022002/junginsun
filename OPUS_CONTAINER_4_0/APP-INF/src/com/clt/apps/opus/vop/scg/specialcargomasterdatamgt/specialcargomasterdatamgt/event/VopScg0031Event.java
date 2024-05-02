/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VmsScg0031Event.java
*@FileTitle : Load Reject Reason (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.04.28 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event;

import java.util.Arrays;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.ScgLodRjctCdVO;


/**
 * VMS_SCG-0031 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VMS_SCG-0031HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dohyoung Lee
 * @see VMS_SCG-0031HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopScg0031Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgLodRjctCdVO scgLodRjctCdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgLodRjctCdVO[] scgLodRjctCdVOs = null;

	public VopScg0031Event(){}
	
	public void setScgLodRjctCdVO(ScgLodRjctCdVO scgLodRjctCdVO){
		this.scgLodRjctCdVO = scgLodRjctCdVO;
	}

	public void setScgLodRjctCdVOS(ScgLodRjctCdVO[] scgLodRjctCdVOs){
		if(scgLodRjctCdVOs != null){
			ScgLodRjctCdVO[] tmpVOs = Arrays.copyOf(scgLodRjctCdVOs, scgLodRjctCdVOs.length);
			this.scgLodRjctCdVOs = tmpVOs;
		}
	}

	public ScgLodRjctCdVO getScgLodRjctCdVO(){
		return scgLodRjctCdVO;
	}

	public ScgLodRjctCdVO[] getScgLodRjctCdVOS(){
		ScgLodRjctCdVO[] rtnVOs = null;
		if (this.scgLodRjctCdVOs != null) {
			rtnVOs = Arrays.copyOf(scgLodRjctCdVOs, scgLodRjctCdVOs.length);
		}
		return rtnVOs;
	}

}