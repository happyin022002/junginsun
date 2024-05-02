/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EsdSpe1003Event.java
*@FileTitle : S/P Service Category Confirm
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.egmaster.spservicecategory.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esd.spe.egmaster.spservicecategory.vo.SpeSvcCateVO;


/**
 * ESD_SPE_1003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_SPE_1003HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HI
 * @see ESD_SPE_1003HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdSpe1003Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	SpeSvcCateVO speSvcCateVO = null;
	
	/** Table Value Object Multi Data 처리 */
	SpeSvcCateVO[] speSvcCateVOs = null;

	public EsdSpe1003Event(){}

	public SpeSvcCateVO getSpeSvcCateVO() {
		return speSvcCateVO;
	}

	public void setSpeSvcCateVO(SpeSvcCateVO speSvcCateVO) {
		this.speSvcCateVO = speSvcCateVO;
	}

	public SpeSvcCateVO[] getSpeSvcCateVOs() {
		return speSvcCateVOs;
	}

	public void setSpeSvcCateVOs(SpeSvcCateVO[] speSvcCateVOs) {
		this.speSvcCateVOs = speSvcCateVOs;
	}



	

}