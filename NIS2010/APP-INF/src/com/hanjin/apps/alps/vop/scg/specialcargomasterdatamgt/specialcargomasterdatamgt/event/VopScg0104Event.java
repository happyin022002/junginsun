/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VopScg0104Event.java
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
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgPckReguPkgCdVO;


/**
 * VOP_AOM_0104 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_AOM_0104HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dohyoung Lee
 * @see VOP_SCG_0104HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg0104Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgPckReguPkgCdVO ScgPckReguPkgCdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgPckReguPkgCdVO[] ScgPckReguPkgCdVOs = null;

	public VopScg0104Event(){}
	
	public void setScgPckReguPkgCdVO(ScgPckReguPkgCdVO ScgPckReguPkgCdVO){
		this. ScgPckReguPkgCdVO = ScgPckReguPkgCdVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setScgPckReguPkgCdVOS(ScgPckReguPkgCdVO[] ScgPckReguPkgCdVOs){
		if (ScgPckReguPkgCdVOs != null) {
			ScgPckReguPkgCdVO[] tmpVOs = new ScgPckReguPkgCdVO[ScgPckReguPkgCdVOs.length];
			System.arraycopy(ScgPckReguPkgCdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.ScgPckReguPkgCdVOs = tmpVOs;
		}
	}

	public ScgPckReguPkgCdVO getScgPckReguPkgCdVO(){
		return ScgPckReguPkgCdVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public ScgPckReguPkgCdVO[] getScgPckReguPkgCdVOS(){
		ScgPckReguPkgCdVO[] rtnVOs = null;
		if (this.ScgPckReguPkgCdVOs != null) {
			rtnVOs = new ScgPckReguPkgCdVO[ScgPckReguPkgCdVOs.length];
			System.arraycopy(ScgPckReguPkgCdVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	 
}