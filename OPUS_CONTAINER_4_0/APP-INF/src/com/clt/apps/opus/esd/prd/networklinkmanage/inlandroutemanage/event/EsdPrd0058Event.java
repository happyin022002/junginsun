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
package com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.event;

import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.lnlandRouteUSVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EsdPrd0058Event 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EST_PRD_057HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author kIm kwi-jin
 * @see UI_TESTHTMLAction 참조
 * @since J2EE 1.6
 */
public class EsdPrd0058Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	lnlandRouteUSVO inlandRouteUSVO = null;
	lnlandRouteUSVO[] inlandRouteUSVOs = null;

	/**
	 * 
	 * @return
	 */
	public lnlandRouteUSVO getInlandRouteUSVO() {
		return inlandRouteUSVO;
	}

	/**
	 * 
	 * @param inlandRouteUSVO
	 */
	public void setInlandRouteUSVO(lnlandRouteUSVO inlandRouteUSVO) {
		this.inlandRouteUSVO = inlandRouteUSVO;
	}

	/**
	 * 
	 * @return
	 */
	public lnlandRouteUSVO[] getInlandRouteUSVOs() {
		lnlandRouteUSVO[] tmpVOs = null;
		if (this.inlandRouteUSVOs != null) {
			tmpVOs = new lnlandRouteUSVO[this.inlandRouteUSVOs.length];
			System.arraycopy(this.inlandRouteUSVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * 
	 * @param inlandRouteUSVOs
	 */
	public void setInlandRouteUSVOs(lnlandRouteUSVO[] inlandRouteUSVOs) {
		if (inlandRouteUSVOs != null) {
			lnlandRouteUSVO[] tmpVOs = new lnlandRouteUSVO[inlandRouteUSVOs.length];
			System.arraycopy(inlandRouteUSVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.inlandRouteUSVOs = tmpVOs;
		}
	}
}
