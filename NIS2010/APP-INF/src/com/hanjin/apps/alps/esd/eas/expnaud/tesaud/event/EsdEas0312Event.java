/*=========================================================
*Copyright(c) 2015 CyberLogitec 
*@FileName : EsdEas0315Event.java
*@FileTitle : Contianer Movement - Reefer
*Open Issues :
*Change history :
*@LastModifyDate : 2015-02-02
*@LastModifier : 9014613
*@LastVersion : 1.0
* 2015-02-02
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.tesaud.event;

import com.hanjin.apps.alps.esd.eas.expnaud.tesaud.vo.TesOnDockRailVO;
import com.hanjin.apps.alps.esd.eas.expnaud.tesaud.vo.TesRowDataVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_EAS_0312 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_EAS_0312HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 9014613
 * @see ESD_EAS_0312HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdEas0312Event extends EventSupport {
	/** Table Value Object MultiCombo 조회 조건 및 단건 처리  */
	TesRowDataVO tesRowDataVO = null;
	TesOnDockRailVO tesOnDockRailVO = null;
	
	private static final long serialVersionUID = 1L;
	
	public TesOnDockRailVO getTesOnDockRailVO() {
		return tesOnDockRailVO;
	}
	public void setTesOnDockRailVO(TesOnDockRailVO tesOnDockRailVO) {
		this.tesOnDockRailVO = tesOnDockRailVO;
	}
	
	public TesRowDataVO getTesRowDataVO() {
		return tesRowDataVO;
	}
	public void setTesRowDataVO(TesRowDataVO tesRowDataVO) {
		this.tesRowDataVO = tesRowDataVO;
	}

}