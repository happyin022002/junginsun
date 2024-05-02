/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdPrd0081Event.java
*@FileTitle : ProductCatalogCreate
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.22
*@LastModifier : 정선용
*@LastVersion : 1.0
* 2009.08.22 정선용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.event;

import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdSearchParamVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_PRD_0080 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_PRD_0080HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author sun yong Jung
 * @see ESD_PRD_0080HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdPrd0082Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	

	private PrdSearchParamVO prdSearchParamVO = null;

	public PrdSearchParamVO getPrdSearchParamVO() {
		return prdSearchParamVO;
	}

	public EsdPrd0082Event(){}
	
 
 

	public void setPrdSearchParamVO(PrdSearchParamVO vo) {
		// TODO Auto-generated method stub
		this.prdSearchParamVO = vo;
	}
 

}