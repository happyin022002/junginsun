/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CanadaCCTManageBC.java
*@FileTitle : CanadaCCTManageBC
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.18
*@LastModifier : JunKun Lee
*@LastVersion : 1.0
*2012-06-18 JunKun Lee : Rail Receiving (Cut Off) Date 산출 Logic 변경 및 추가 요청
*2012.11.02 정선용 [CHM-201221039] [PRD] Canada rail cut off 기능개선
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networknodemanage.canadacctmanage.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.prd.networknodemanage.canadacctmanage.event.EsdPrd0037Event;
import com.hanjin.apps.alps.esd.prd.networknodemanage.canadacctmanage.vo.CanadaCCTManageVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.MdmLocationVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * alps-PRD Business Logic Command Interface<br>
 * - alps-PRD에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author 2007611
 * @see ESD_PRD_0037EventResponse 참조
 * @since J2EE 1.4
 */
public interface CanadaCCTManageBC {

	/**
	 * searchCanadaCCTManage
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<CanadaCCTManageVO> searchCanadaCCTManage(CanadaCCTManageVO vo) throws EventException;
	
	/**
	 * searchCanadaCCTInterval
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<CanadaCCTManageVO> searchCanadaCCTInterval(CanadaCCTManageVO vo) throws EventException;
	
	/**
	 * multiCanadaCCTManage
	 * @param canadaCCTManageVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiCanadaCCTManage(CanadaCCTManageVO[] canadaCCTManageVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * searchMdmLocation
	 * @param event
	 * @return
	 * @throws EventException
	 */
	public List<MdmLocationVO> searchMdmLocation(EsdPrd0037Event event) throws EventException;
	
	/**
	 * POL, POR Duplication Check
	 * @param vos
	 * @return
	 * @throws EventException
	 */
	public List<CanadaCCTManageVO> checkDuplicateCanadaCCTManage(CanadaCCTManageVO[] vos) throws EventException;

	/**
	 * @param event
	 * @return
	 * @throws EventException
	 */
	public List<MdmLocationVO> searchPolNode(EsdPrd0037Event event) throws EventException;

	/**
	 * @param canadaCCTManageVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiIntevalCCTManage(CanadaCCTManageVO[] canadaCCTManageVOs,
			SignOnUserAccount account) throws EventException;
}
