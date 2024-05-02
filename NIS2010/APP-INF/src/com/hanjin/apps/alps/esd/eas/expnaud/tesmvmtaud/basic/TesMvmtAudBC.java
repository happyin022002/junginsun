/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TesMvmtAudBC   
*@FileTitle : Contianer Movement - Reefer
*Open Issues :
*Change history :
*@LastModifyDate : 2015-02-02
*@LastModifier : 9014613
*@LastVersion : 1.0
* 2015-02-02 : 9014613
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.tesmvmtaud.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.eas.expnaud.tesmvmtaud.vo.SearchMvmtLegListVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * TesMvmtAudBC PDTO(Data Transfer Object including Parameters)<br>
 * @author 9014613
 * @see List<SearchMvmtLegListVO> 참조
 * @since J2EE 1.4
 */
public interface TesMvmtAudBC {
	/**
	 * Port (Service) Charge 조회.
	 * 
	 * @category EDS_EAS_0315
	 * @param e EsdEas0315Event
	 * @return List<SearchMvmtLegListVO>
	 * @throws EventException
	 */
	public List<SearchMvmtLegListVO> searchMvmtLegList(Event e) throws EventException;
}