/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsdPrd0058Event.java
 *@FileTitle : EsdPrd0058Event
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009/07/29
 *@LastModifier : waiterj
 *@LastVersion : 1.0
 * 2009/07/29 waiterj
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.event;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.lnlandRouteUSVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EsdPrd0058Event 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EST_PRD_057HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kIm kwi-jin
 * @see UI_TESTHTMLAction 참조
 * @since J2EE 1.6
 */
public class EsdPrd0058Event extends EventSupport{

	private static final long serialVersionUID = 1L;
	lnlandRouteUSVO inlandRouteUSVO = null;
	lnlandRouteUSVO[] inlandRouteUSVOs = null;

	/**
	 *
	 * @return
	 */
	public lnlandRouteUSVO getInlandRouteUSVO(){
		return inlandRouteUSVO;
	}

	/**
	 *
	 * @param inlandRouteUSVO
	 */
	public void setInlandRouteUSVO(lnlandRouteUSVO inlandRouteUSVO){
		this.inlandRouteUSVO = inlandRouteUSVO;
	}

	/**
	 *
	 * @return
	 */
	public lnlandRouteUSVO[] getInlandRouteUSVOs(){
		return inlandRouteUSVOs;
	}

	/**
	 *
	 * @param inlandRouteUSVOs
	 */
	public void setInlandRouteUSVOs(lnlandRouteUSVO[] inlandRouteUSVOs){
		this.inlandRouteUSVOs = inlandRouteUSVOs;
	}
}
