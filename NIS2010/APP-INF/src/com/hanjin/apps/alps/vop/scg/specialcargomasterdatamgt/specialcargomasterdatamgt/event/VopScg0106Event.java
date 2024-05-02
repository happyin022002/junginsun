/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VopScg0106Event.java
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
import com.hanjin.syscommon.common.table.ScgPckReguPkgOrgPrxVO;


/**
 * VOP_AOM_0106 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_AOM_0106HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dohyoung Lee
 * @see VOP_SCG_0106HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg0106Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgPckReguPkgOrgPrxVO ScgPckReguPkgOrgPrxVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgPckReguPkgOrgPrxVO[] ScgPckReguPkgOrgPrxVOs = null;

	public VopScg0106Event(){}
	
	public void setScgPckReguPkgOrgPrxVO(ScgPckReguPkgOrgPrxVO ScgPckReguPkgOrgPrxVO){
		this. ScgPckReguPkgOrgPrxVO = ScgPckReguPkgOrgPrxVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setScgPckReguPkgOrgPrxVOS(ScgPckReguPkgOrgPrxVO[] ScgPckReguPkgOrgPrxVOs){
		if (ScgPckReguPkgOrgPrxVOs != null) {
			ScgPckReguPkgOrgPrxVO[] tmpVOs = new ScgPckReguPkgOrgPrxVO[ScgPckReguPkgOrgPrxVOs.length];
			System.arraycopy(ScgPckReguPkgOrgPrxVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.ScgPckReguPkgOrgPrxVOs = tmpVOs;
		}
	}

	public ScgPckReguPkgOrgPrxVO getScgPckReguPkgOrgPrxVO(){
		return ScgPckReguPkgOrgPrxVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public ScgPckReguPkgOrgPrxVO[] getScgPckReguPkgOrgPrxVOS(){
		ScgPckReguPkgOrgPrxVO[] rtnVOs = null;
		if (this.ScgPckReguPkgOrgPrxVOs != null) {
			rtnVOs = new ScgPckReguPkgOrgPrxVO[ScgPckReguPkgOrgPrxVOs.length];
			System.arraycopy(ScgPckReguPkgOrgPrxVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	 
}