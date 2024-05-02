/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OCPChgColmanageBC
*@FileTitle : OCP Charge Collection Management
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
=========================================================*/
package com.clt.apps.opus.esd.eas.transportmanage.ocpchgcolmanage.basic;

import java.util.List;

import com.clt.apps.opus.esd.eas.transportmanage.ocpchgcolmanage.vo.SearchOCPChgListVO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * OCPChgColmanageBC<br>
 * checking collectable US OCP charge, input goings-on 
 * @author Jeongsoo Lee
 * @see EventResponse 참조
 * @since J2EE 1.4
 */
public interface OCPChgColmanageBC {

	/**
	 * ESD_EAS_0010 : Retrieve<br>
	 * [US OCP charge collection]<br>
	 * 
	 * @param SearchOCPChgListVO searchOCPChgListVO
	 * @return List<SearchOCPChgListVO>
	 * @exception EventException
	 */
	public List<SearchOCPChgListVO> searchOcpChgList(SearchOCPChgListVO searchOCPChgListVO) throws EventException;
	
}
