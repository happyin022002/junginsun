/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BcmCcd0026Event.java
*@FileTitle : movement status
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.service.event;

import java.util.List;

import com.clt.apps.opus.bcm.ccd.commoncode.service.vo.MovementStatusVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * BCM_CCD_0026 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_0026HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see BCM_CCD_0026HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd0026Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String mvmtStsCd = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MovementStatusVO mvmtStsVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MovementStatusVO[] mvmtStsVOs = null;

	public BcmCcd0026Event(){}
	
	public void setMvmtStsVO(MovementStatusVO mvmtStsVO){
		this. mvmtStsVO = mvmtStsVO;
	}

	public void setMvmtStsVOS(MovementStatusVO[] mvmtStsVOs){
		if(mvmtStsVOs != null){
			MovementStatusVO[] tmpVOs = java.util.Arrays.copyOf(mvmtStsVOs, mvmtStsVOs.length);
			this.mvmtStsVOs = tmpVOs;
		}
	}
	
	public void setMvmtStsCd(String mvmtStsCd){
		this. mvmtStsCd = mvmtStsCd;
	}

	public MovementStatusVO getMvmtStsVO(){
		return mvmtStsVO;
	}

	public MovementStatusVO[] getMvmtStsVOS(){
		MovementStatusVO[] rtnVOs = null;
		if (this.mvmtStsVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(mvmtStsVOs, mvmtStsVOs.length);
		}
		return rtnVOs;
	}
	
	public String getMvmtStsCd(){
		return mvmtStsCd;
	}

}