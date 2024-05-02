/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LseCommonBC.java
*@FileTitle : ETC LesCommon Code Search
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.09.29 장준우
* 1.0 Creation
* 2014-02-19 채창호 [CHM-201428698-01] Split 01-계약 종료 Notice건 개발
=========================================================*/
package com.hanjin.apps.alps.ees.lse.lsecommon.lsecommon.basic;

import java.util.List;

import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.syscommon.common.table.MdmLocationVO;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;
import com.hanjin.syscommon.common.table.MstContainerVO;
import com.hanjin.syscommon.common.table.MdmOrganizationVO;
import com.hanjin.syscommon.common.table.VskVslPortSkdVO;


/**
 * ALPS-LseCommon Business Logic Command Interface<br>
 * - ALPS-LseCommon에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jang Jun-Woo
 * @see UI_LSE_0020EventResponse 참조
 * @since J2EE 1.6
 */
public interface LseCommonBC {
	/**
	 * Location - Port 코드목록을 조회합니다.<br>
	 *
	 * @param  String locCd
	 * @return List<MdmLocationVO>
	 * @exception EventException
	 */
	public List<MdmLocationVO> searchLocationPortBasic(String locCd) throws EventException;

	/**
	 * Vessel SKD 목록을 조회합니다.<br>
	 *
	 * @param  String vvdCd
	 * @return List<VskVslPortSkdVO>
	 * @exception EventException
	 */
	public List<VskVslPortSkdVO> searchVesselSkdBasic(String vvdCd) throws EventException;

	/**
	 * 컨테이너 정보 조회합니다.<br>
	 *
	 * @param  String cntrNo
	 * @return MstContainerVO
	 * @exception EventException
	 */
	public MstContainerVO searchContainerInfoBrieflyBasic(String cntrNo) throws EventException;

	/**
	 * Office 코드목록을 조회합니다.<br>
	 *
	 * @param  String ofcCd
	 * @return List<MdmOrganizationVO>
	 * @exception EventException
	 */
	public List<MdmOrganizationVO> searchOfficeCodeBasic(String ofcCd) throws EventException;

	/**
	 * Vessel SVC Lane 목록을 조회합니다.<br>
	 *
	 * @param  String slanCd
	 * @return List<MdmVslSvcLaneVO>
	 * @exception EventException
	 */
	public List<MdmVslSvcLaneVO> searchServiceLaneBasic(String slanCd) throws EventException;
	
	/**
	 * Agreement No 존재하는 체크를 합니다 (Notice 에서 사용).<br>
	 * 
	 * @param String agmtNo
	 * @return String
	 * @exception EventException
	 */		
	public String searchLessorCodeCtrtNtcInfo(String agmtNo) throws EventException;
}
