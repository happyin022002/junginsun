/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsdPrd0083Event.java
 *@FileTitle : ProductCatalogCreate
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.22
 *@LastModifier : 이재위
 *@LastVersion : 1.0
 * 2009.08.22 이재위
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.event;

import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdValChkVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESD_PRD_0083 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_PRD_0080HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author jaewi Lee
 * @see ESD_PRD_0080HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdPrd0083Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private PrdValChkVO prdValChkVO = null;

	public EsdPrd0083Event() {
	}

	public PrdValChkVO getPrdValChkVO() {
		return prdValChkVO;
	}

	public void setPrdValChkVO(PrdValChkVO vo) {
		this.prdValChkVO = vo;
	}

}