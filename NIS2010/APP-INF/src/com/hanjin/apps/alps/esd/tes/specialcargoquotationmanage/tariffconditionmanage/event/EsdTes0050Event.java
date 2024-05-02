/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTes0050Event.java
*@FileTitle : Tariff Condition Registry
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.04
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.02.04 이혜민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.tariffconditionmanage.event;


import com.hanjin.framework.support.layer.event.EventSupport;

import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.tariffconditionmanage.vo.ComTesCondDtlVO;

import com.hanjin.syscommon.common.table.TesObjListVO;
import com.hanjin.syscommon.common.table.TesTrfCondVO;



/**
 * ESD_TES_0050 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TES_0050HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 이혜민
 * @see ESD_TES_0050HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTes0050Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsdTes0050Event(){}

	private TesTrfCondVO	tesTrfCondVO		= null;
	private TesObjListVO	tesObjListVO		= null;
	private ComTesCondDtlVO[] comTesCondDtlVOs	= null;
	
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public TesTrfCondVO getTesTrfCondVO() {
		return tesTrfCondVO;
	}

	public TesObjListVO getTesObjListVO() {
		return tesObjListVO;
	}

	public ComTesCondDtlVO[] getComTesCondDtlVOs() {
		return comTesCondDtlVOs;
	}

	public void setTesTrfCondVO(TesTrfCondVO tesTrfCondVO) {
		this.tesTrfCondVO = tesTrfCondVO;
	}

	public void setTesTrfCondVO(TesObjListVO tesObjListVO) {
		this.tesObjListVO = tesObjListVO;
	}

	public void setComTesCondDtlVOs(ComTesCondDtlVO[] comTesCondDtlVOs) {
		this.comTesCondDtlVOs = comTesCondDtlVOs;
	}

}