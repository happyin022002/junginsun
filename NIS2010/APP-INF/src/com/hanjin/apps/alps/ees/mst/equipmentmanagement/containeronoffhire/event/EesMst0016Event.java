/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMst0016Event.java
*@FileTitle : Own Container Creation (New Van)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.06.10 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrLotVO;


/**
 * EES_MST_0016 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MST_0016HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Ho Min
 * @see EES_MST_0016HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMst0016Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private CntrLotVO cntrLotVO = null;
	
	public EesMst0016Event(){}
	
	public void setCntrLotVO(CntrLotVO cntrLotVO){
		this.cntrLotVO = cntrLotVO;
	}
	
	public CntrLotVO getCntrLotVO(){
		return cntrLotVO;
	}
}