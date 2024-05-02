/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : PrdCommonManageBC.java
 *@FileTitle : PRD 공통관리
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-10-16
 *@LastModifier : jungsunyoung
 *@LastVersion : 1.0
 * 2006-10-16 jungsunyoung
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.prd.common.productcatalogcreateverify.basic;

import com.clt.apps.opus.esd.prd.common.prdcreate.vo.PrdPcCreateVO;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.event.EsdPrd0080Event;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdCreateParamVO;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdPatternVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * PRD Business Logic Command Interface<br>
 * PRD에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author noh seung bae
 * @see EventResponse 참조
 * @since J2EE 1.6
 */
public interface ProductCatalogCreateVerifyBC{

	/**
	 *
	 * @param event
	 * @param prdCreateParamVO
	 * @param prdPcCreateVO
	 * @param prdPatternVO
	 * @return
	 * @throws EventException
	 */
	public String getPcVerify(EsdPrd0080Event event ,PrdCreateParamVO prdCreateParamVO, PrdPcCreateVO prdPcCreateVO, PrdPatternVO prdPatternVO) throws EventException;
}
