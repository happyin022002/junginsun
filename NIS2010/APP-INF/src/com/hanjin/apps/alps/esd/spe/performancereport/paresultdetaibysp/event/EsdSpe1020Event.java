/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EsdSpe1020Event.java
*@FileTitle : Quantitative Analysis PA Result Detail by S/P
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.03.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancereport.paresultdetaibysp.event;

import com.hanjin.apps.alps.esd.spe.performancereport.paresultdetaibysp.vo.PAResultDetaibySPVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_SPE_1020 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_SPE_1020HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HI
 * @see ESD_SPE_1020HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdSpe1020Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	PAResultDetaibySPVO pAResultDetaibySPVO = null;
	
	/** Table Value Object Multi Data 처리 */
	PAResultDetaibySPVO[] pAResultDetaibySPVOs = null;

	public EsdSpe1020Event(){}

	public PAResultDetaibySPVO getpAResultDetaibySPVO() {
		return pAResultDetaibySPVO;
	}

	public void setpAResultDetaibySPVO(PAResultDetaibySPVO pAResultDetaibySPVO) {
		this.pAResultDetaibySPVO = pAResultDetaibySPVO;
	}

	public PAResultDetaibySPVO[] getpAResultDetaibySPVOs() {
		return pAResultDetaibySPVOs;
	}

	public void setpAResultDetaibySPVOs(PAResultDetaibySPVO[] pAResultDetaibySPVOs) {
		this.pAResultDetaibySPVOs = pAResultDetaibySPVOs;
	}



}