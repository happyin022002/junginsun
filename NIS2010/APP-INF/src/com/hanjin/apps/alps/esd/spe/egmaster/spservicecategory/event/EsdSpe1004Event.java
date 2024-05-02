/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EsdSpe1004Event.java
*@FileTitle : S/P Service Category Inquiry
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
 * ESD_SPE_1004 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_SPE_1004HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HI
 * @see ESD_SPE_1004HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdSpe1004Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	SpeSvcCateVO speSvcCateVO = null;
	
	/** Table Value Object Multi Data 처리 */
	SpeSvcCateVO[] speSvcCateVOs = null;

	public EsdSpe1004Event(){}
	
	public void setSpeSvcCateVO(SpeSvcCateVO speSvcCateVO){
		this. speSvcCateVO = speSvcCateVO;
	}

	public void setSpeSvcCateVOS(SpeSvcCateVO[] speSvcCateVOs){
		this. speSvcCateVOs = speSvcCateVOs;
	}

	public SpeSvcCateVO getSpeSvcCateVO(){
		return speSvcCateVO;
	}

	public SpeSvcCateVO[] getSpeSvcCateVOS(){
		return speSvcCateVOs;
	}

}