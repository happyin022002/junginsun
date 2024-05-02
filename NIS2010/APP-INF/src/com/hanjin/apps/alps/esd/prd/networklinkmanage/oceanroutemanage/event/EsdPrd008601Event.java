/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : EsdPrd008601Event.java
 *@FileTitle : Verify Rule
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011-12-06
 *@LastModifier : 변종건
 *@LastVersion : 1.0
 * 1.0 최초 생성
 * 2011.12.06 변종건 [CHM-201114917-01] Ocean Route Upload Excel 신규 기능 추가건
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.event;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.SaveOceanRouteVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_PRD_086_01 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_PRD_086_01HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kimyoungchul
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdPrd008601Event extends EventSupport{

	/**
	 * 
	 */
	public EsdPrd008601Event(){
	}

	private SaveOceanRouteVO saveOceanRouteVO = null;
	private SaveOceanRouteVO[] saveOceanRouteVOs = null;
	
	
	public SaveOceanRouteVO getSaveOceanRouteVO() {
		return saveOceanRouteVO;
	}

	public void setSaveOceanRouteVO(SaveOceanRouteVO saveOceanRouteVO) {
		this.saveOceanRouteVO = saveOceanRouteVO;
	}

	public SaveOceanRouteVO[] getSaveOceanRouteVOs() {
		return saveOceanRouteVOs;
	}

	public void setSaveOceanRouteVOs(SaveOceanRouteVO[] saveOceanRouteVOs) {
		this.saveOceanRouteVOs = saveOceanRouteVOs;
	}

	/**
	 * 에러 안나게하기 위해 임시로
	 * @param arg1
	 * @return
	 */
	public String getString(String arg1){
		return "";
	}

	/**
	 * 에러 안나게하기 위해 임시로
	 * @param arg1
	 * @return
	 */
	public String[] getObject(String arg1){
		return new String[1];
	}
}
