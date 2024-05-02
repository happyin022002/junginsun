/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OCPChgColmanageBC
*@FileTitle : OCP Charge Collection Management
*Open Issues :
*Change history :
*@LastModifyDate : 2010-11-10
*@LastModifier : Jeongsoo Lee
*@LastVersion : 1.0
* 2010-11-10 Jeongsoo Lee
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.transportmanage.ocpchgcolmanage.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.eas.transportmanage.ocpchgcolmanage.vo.SearchOCPChgListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * OCPChgColmanageBC<br>
 * 미주 OCP charge collection 대상건의 collection 여부를 검색하고, 진행사항을 text로 입력
 * @author Jeongsoo Lee
 * @see EventResponse 참조
 * @since J2EE 1.4
 */
public interface OCPChgColmanageBC {

	/**
	 * ESD_EAS_0010 : Retrieve<br>
	 * [미주 OCP charge collection]을 [조회] 합니다.<br>
	 * 
	 * @param SearchOCPChgListVO searchOCPChgListVO
	 * @return List<SearchOCPChgListVO>
	 * @exception EventException
	 */
	public List<SearchOCPChgListVO> searchOcpChgList(SearchOCPChgListVO searchOCPChgListVO) throws EventException;

	/**
	 * ESD_EAS_0010 : Save<br>
	 * [미주 OCP charge collection]을 [저장] 합니다.<br>
	 * 
	 * @param SearchOCPChgListVO[] searchOCPChgListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiOcpChgList(SearchOCPChgListVO[] searchOCPChgListVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Location을 check  합니다. <br>
	 * 
	 * @param locLevel
	 * @param locCD
	 * @return String
	 * @exception EventException
	 */
	public String checkLocation(String locLevel ,String locCD) throws EventException;
	
}
