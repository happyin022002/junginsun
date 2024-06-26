/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMst0025Event.java
*@FileTitle : Container Status Creation-LST and FND
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.07.30 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.LostFoundVO;


/**
 * EES_MST_0025 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MST_0025HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Ho Min
 * @see EES_MST_0025HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMst0025Event extends EventSupport {

	private static final long serialVersionUID = 1L;
		
	/** Table Value Object Multi Data 처리 */
	public LostFoundVO[] lostFoundVOs = null;

	public EesMst0025Event(){}
	

	public void setLostFoundVOs(LostFoundVO[] lostFoundVOs){
		this. lostFoundVOs = lostFoundVOs;
	}

	public LostFoundVO[] getLostFoundVOs(){
		return lostFoundVOs;
	}

}