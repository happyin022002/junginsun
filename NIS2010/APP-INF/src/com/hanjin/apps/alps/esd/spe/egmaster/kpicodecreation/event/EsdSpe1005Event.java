/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EsdSpe1005Event.java
*@FileTitle : KPI Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.egmaster.kpicodecreation.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esd.spe.egmaster.kpicodecreation.vo.KPICodeCreVO;


/**
 * ESD_SPE_1005 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_SPE_1005HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HI
 * @see ESD_SPE_1005HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdSpe1005Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	KPICodeCreVO kPICodeCreVO = null;
	
	/** Table Value Object Multi Data 처리 */
	KPICodeCreVO[] kPICodeCreVOs = null;

	public EsdSpe1005Event(){}

	public KPICodeCreVO getkPICodeCreVO() {
		return kPICodeCreVO;
	}

	public void setkPICodeCreVO(KPICodeCreVO kPICodeCreVO) {
		this.kPICodeCreVO = kPICodeCreVO;
	}

	public KPICodeCreVO[] getkPICodeCreVOs() {
		return kPICodeCreVOs;
	}

	public void setkPICodeCreVOs(KPICodeCreVO[] kPICodeCreVOs) {
		this.kPICodeCreVOs = kPICodeCreVOs;
	}



	

}