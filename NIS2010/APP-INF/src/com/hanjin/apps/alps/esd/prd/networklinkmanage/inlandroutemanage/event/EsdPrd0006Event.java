/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : EsdPrd0006Event.java
 *@FileTitle : Route List 정보조회
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-09-22
 *@LastModifier : jungsunyong
 *@LastVersion : 1.0
 * 2006-09-22 jungsunyong
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.event;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteSelCreVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_PRD_006 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_PRD_006HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jungsunyong
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdPrd0006Event extends EventSupport{

	private InlandRouteSelCreVO inlandRouteSelCreVO = null;
	private InlandRouteSelCreVO[] inlandRouteSelCreVOs = null;

	/**
	 *
	 * @return
	 */
	public InlandRouteSelCreVO getInlandRouteSelCreVO(){
		return inlandRouteSelCreVO;
	}

	/**
	 *
	 * @param inlandRouteSelCreVO
	 */
	public void setInlandRouteSelCreVO(InlandRouteSelCreVO inlandRouteSelCreVO){
		this.inlandRouteSelCreVO = inlandRouteSelCreVO;
	}

	/**
	 *
	 * @return
	 */
	public InlandRouteSelCreVO[] getInlandRouteSelCreVOs(){
		return inlandRouteSelCreVOs;
	}

	/**
	 *
	 * @param inlandRouteSelCreVOs
	 */
	public void setInlandRouteSelCreVOs(InlandRouteSelCreVO[] inlandRouteSelCreVOs){
		this.inlandRouteSelCreVOs = inlandRouteSelCreVOs;
	}
}
