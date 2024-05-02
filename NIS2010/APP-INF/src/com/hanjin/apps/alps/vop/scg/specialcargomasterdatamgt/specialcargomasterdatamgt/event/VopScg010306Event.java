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
package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event;

import com.hanjin.syscommon.common.table.ScgPckGasReguVO;
import com.hanjin.syscommon.common.table.ScgPckRefVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * VMS_SCG-0031 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VMS_SCG-0031HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dohyoung Lee
 * @see VMS_SCG-0031HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopScg010306Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgPckGasReguVO scgPckGasReguVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgPckGasReguVO[] scgPckGasReguVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgPckRefVO scgPckRefVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgPckRefVO[] scgPckRefVOs = null;

	public VopScg010306Event(){}
	
	public void setScgPckRefVO(ScgPckRefVO scgPckRefVO){
		this.scgPckRefVO = scgPckRefVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setScgPckRefVOS(ScgPckRefVO[] scgPckRefVOs){
		if (scgPckRefVOs != null) {
			ScgPckRefVO[] tmpVOs = new ScgPckRefVO[scgPckRefVOs.length];
			System.arraycopy(scgPckRefVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.scgPckRefVOs = tmpVOs;
		}
	}

	public ScgPckRefVO getScgPckRefVO(){
		return scgPckRefVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public ScgPckRefVO[] getScgPckRefVOS(){
		ScgPckRefVO[] rtnVOs = null;
		if (this.scgPckRefVOs != null) {
			rtnVOs = new ScgPckRefVO[scgPckRefVOs.length];
			System.arraycopy(scgPckRefVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public void setScgPckGasReguVO(ScgPckGasReguVO scgPckGasReguVO){
		this.scgPckGasReguVO = scgPckGasReguVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setScgPckGasReguVOS(ScgPckGasReguVO[] scgPckGasReguVOs){
		if (scgPckGasReguVOs != null) {
			ScgPckGasReguVO[] tmpVOs = new ScgPckGasReguVO[scgPckGasReguVOs.length];
			System.arraycopy(scgPckGasReguVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.scgPckGasReguVOs = tmpVOs;
		}
	}

	public ScgPckGasReguVO getScgPckGasReguVO(){
		return scgPckGasReguVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public ScgPckGasReguVO[] getScgPckGasReguVOS(){
		ScgPckGasReguVO[] rtnVOs = null;
		if (this.scgPckGasReguVOs != null) {
			rtnVOs = new ScgPckGasReguVO[scgPckGasReguVOs.length];
			System.arraycopy(scgPckGasReguVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}