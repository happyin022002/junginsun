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
package com.hanjin.apps.alps.esd.prd.common.productcatalogcreateverify.basic;

import com.hanjin.apps.alps.esd.prd.common.prdcreate.vo.PrdPcCreateVO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdCreateParamVO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdPatternVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * alps-PRD Business Logic Command Interface<br>
 * - alps-PRD에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author noh seung bae
 * @see EventResponse 참조
 * @since J2EE 1.6
 */
public interface ProductCatalogCreateVerifyBC{

	/**
	 *
	 * @param prdCreateParamVO
	 * @param prdPcCreateVO
	 * @param prdPatternVO
	 * @return
	 * @throws EventException
	 */
	public String getPcVerify(PrdCreateParamVO prdCreateParamVO, PrdPcCreateVO prdPcCreateVO, PrdPatternVO prdPatternVO) throws EventException;
}
