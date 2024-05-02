/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : TrsCommonBC.java
 *@FileTitle : TrsCommon
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.common.trscommon.basic;

import java.util.List;

import com.clt.apps.opus.esd.trs.common.trscommon.event.EsdTrs0999Event;
import com.clt.apps.opus.esd.trs.common.trscommon.vo.TrsCommonComboVO;
import com.clt.apps.opus.esd.trs.common.trscommon.vo.TrsSOHistoryVO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.syscommon.common.table.MdmCntrTpSzVO;

/**
 * ALPS-Common Business Logic Command Interface<br>
 * 
 * @author
 * @see EsdTrs0999Event 참조
 * @since J2EE 1.6
 */
public interface TrsCommonBC {
	/**
	 * Rail Vendor Code List
	 * 
	 * @param e ESD_TRS_0999Event
	 * @return EventResponse ESD_TRS_0999EventResponse
	 * @throws EventException
	 */
	public EventResponse searchRailVndrCd(Event e) throws EventException;

	/**
	 * Other S/O와 관련된 Commmodity Code를 입력,찾기
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchCmdtCd(Event e) throws EventException;

	/**
	 * Other S/O와 관련된 Customer Code를 입력,찾기
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchCustCd(Event e) throws EventException;

	/**
	 * MDM Container Type/Size
	 * 
	 * @param e
	 * @return List<MdmCntrTpSzVO>
	 * @throws EventException
	 */
	public List<MdmCntrTpSzVO> searchMdmCntrTpSz(Event e) throws EventException;

	/**
	 * Common lookup combo list<br>
	 * 
	 * @param String comCode
	 * @return List<TrsCommonComboVO>
	 * @exception EventException
	 */
	public List<TrsCommonComboVO> searchCombo(String comCode) throws EventException;

	/**
	 * Common lookup combo list<br>
	 * 
	 * @param e
	 * @return List<TrsCommonComboVO>
	 * @exception EventException
	 */
	public List<TrsCommonComboVO> searchComboCustCode(Event e) throws EventException;

	/**
	 * Common lookup combo list<br>
	 * 
	 * @param e
	 * @return List<TrsCommonComboVO>
	 * @exception EventException
	 */
	public List<TrsCommonComboVO> searchComboVendor(Event e) throws EventException;

	/**
	 * Change Weight
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchChangeWeight(Event e) throws EventException;
	
	/**
	 * TRS CY/DOOR S/O와 관련된 각 이벤트 별로 S/O HISTORY를 입력
	 * 
	 * @param soHisVo
	 * @throws EventException
	 */
	public void multiSoHistory(TrsSOHistoryVO soHisVo) throws EventException;
	
	/**
	 * USA/CA Rail S/O Creation 화면 Package Type 조회
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchMdmPckTp(Event e) throws EventException;
}
