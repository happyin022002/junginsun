/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : NewCCTManageBC.JAVA
 *@FileTitle : Yard별 CCT
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : JSY
 *@LastVersion : 1.0
 * 2009-06-08 SUN YONG JEONG
 * 1.0 최초 생성
 * CSR: N200903040130 20090608 e-NIS CCT MGMT by Yard UI 수정 관련 PRD SKD Logic 보완
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networknodemanage.cctmanage.basic;

import com.hanjin.apps.alps.esd.prd.networknodemanage.cctmanage.vo.NewCCTManageVO;
import com.hanjin.apps.alps.esd.prd.networknodemanage.cctmanage.vo.NewCCTManageVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import java.util.List;

/**
 * ENIS-PRD Business Logic Command Interface<br>
 * - ENIS-PRD에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jeongseon An
 * @see ESD_PRD_034EventResponse 참조
 * @since J2EE 1.4
 */
public interface NewCCTManageBC{

	/**
	 * 조회 이벤트 처리<br>
	 * CCTmanage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param vo
	 * @return EventResponse ESD_PRD_034EventResponse
	 * @exception EventException
	 */
	public List<NewCCTManageVO> searchCCTManage(NewCCTManageVO vo) throws EventException;

	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_PRD_034 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param NewCCTManageVOs 
	 * @param account
	 * @exception EventException
	 */
	public void multiCCTManage(NewCCTManageVO[] NewCCTManageVOs, SignOnUserAccount account) throws EventException;
}
