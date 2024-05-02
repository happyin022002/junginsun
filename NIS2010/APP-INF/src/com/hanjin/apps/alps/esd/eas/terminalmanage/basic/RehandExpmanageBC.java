/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RehandExpmanageBC.java
*@FileTitle : Rehandling Expense & TPB Check
*Open Issues :
*Change history :
*@LastModifyDate : 2008-01-04
*@LastModifier : Jun Ho Kim
*@LastVersion : 1.0
* 2008-01-04 Jun Ho Kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.terminalmanage.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.eas.terminalmanage.vo.EasLocationVO;
import com.hanjin.apps.alps.esd.eas.terminalmanage.vo.EasMdmCountryVO;
import com.hanjin.apps.alps.esd.eas.terminalmanage.vo.EasOpfTdrAtchFileVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * ENIS-RehandExpmanage Business Logic Command Interface<br>
 * - ENIS-RehandExpmanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jun Ho Kim
 * @see EsdEas0001EventResponse 참조
 * @since J2EE 1.4
 */
public interface RehandExpmanageBC  {

	/**
	 * 조회 이벤트 처리<br>
	 * RehandExpmanage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_EAS_001Event
	 * @return EventResponse ESD_EAS_001EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRehandTPBCheckList(Event e) throws EventException;

	/**
	 * Expense Audit Remark 조회
	 * @param e Event
	 * @return response ESD_EAS_0901EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRehandExpnAudRmk(Event e) throws EventException;
	
	/**
	 * Expense Audit Remark 추가/수정 4341.11.24
	 * @param e Event
	 * @return response ESD_EAS_0901EventResponse
	 * @exception EventException
	 */
	public EventResponse multiRehandExpnAudRmk(Event e) throws EventException;

	/**
	 * Port 정보를 조회합니다.
	 * 
	 * @param EasLocationVO locationVO
	 * @return List<EasLocationVO>
	 * @exception EventException
	 */
	public List<EasLocationVO> searchPortList(EasLocationVO locationVO) throws EventException;
	
	
	/**
	 * Country 정보를 조회합니다.
	 * 
	 * @param String cntCd
	 * @return List<EasMdmCountryVO>
	 * @exception EventException
	 */
	public List<EasMdmCountryVO> searchCountryList(String cntCd) throws EventException;
	
	
	
	 /**
	 * 조회 이벤트 처리<br>
	 * Office Hierarchy 조회 이벤트 처리<br>
	 * 
	 * @param ofcCd
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchOfficeHierarchy(String ofcCd) throws EventException;
	
	
	 /**
	 * 조회 이벤트 처리<br>
	 * Office Hierarchy 조회 이벤트 처리<br>
	 *
	 * @param ofcCd
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchSubOffice(String ofcCd) throws EventException;
	
	
	/**
	 * TDR R/H 의 File Attached 건을 조회합니다.<br>
	 * 
	 * @param opfTdrAtchFileVO
	 * @return
	 * @throws EventException
	 */
	public List<EasOpfTdrAtchFileVO> searchOpfTdrAtchFileVO(EasOpfTdrAtchFileVO opfTdrAtchFileVO) throws EventException;
}