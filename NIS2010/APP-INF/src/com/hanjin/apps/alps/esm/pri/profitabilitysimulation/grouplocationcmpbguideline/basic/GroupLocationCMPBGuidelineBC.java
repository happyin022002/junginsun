/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GroupLocationCMPBGuidelineBC.java
*@FileTitle : CMPB Guideline Creation - Location Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.07.17 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.grouplocationcmpbguideline.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.RsltDurationCreationOfficeVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.grouplocationcmpbguideline.vo.GroupLocationCmpbGuidelineVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.grouplocationcmpbguideline.vo.RsltPriCmpbGrpLocDtlVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriCmpbGlineMnVO;
import com.hanjin.syscommon.common.table.PriCmpbGrpLocVO;

/**
 * ALPS-Profitabilitysimulation Business Logic Command Interface<br>
 * - ALPS-Profitabilitysimulation에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Seung-Jun,Lee
 * @see Esm_pri_6042EventResponse 참조
 * @since J2EE 1.6
 */

public interface GroupLocationCMPBGuidelineBC {

	/**
	 * PRI_CMPB_GRP_LOC_DTL 테이블을 조회한다.<br>
	 * 
	 * @param PriCmpbGrpLocVO priCmpbGrpLocVO 
	 * @return List<RsltPriCmpbGrpLocDtlVO>
	 * @exception EventException
	 */
	public List<RsltPriCmpbGrpLocDtlVO> searchCmpbGlineGroupLocationDetailList(PriCmpbGrpLocVO priCmpbGrpLocVO) throws EventException;
	
	/**
	 * PRI_CMPB_GRP_LOC 테이블을 조회한다.<br>
	 * 
	 * @param PriCmpbGrpLocVO priCmpbGrpLocVO
	 * @return List<PriCmpbGrpLocVO>
	 * @exception EventException
	 */
	public List<PriCmpbGrpLocVO> searchCmpbGlineGroupLocationList(PriCmpbGrpLocVO priCmpbGrpLocVO) throws EventException;
	
	/**
	 * PRI_CMPB_GRP_LOC, PRI_CMPB_GRP_LOC_DTL을 입력 수정 삭제한다<br>
	 * 
	 * @param GroupLocationCmpbGuidelineVO groupLocationCmpbGuidelineVO 
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageGroupLocationCmpbGuideline(GroupLocationCmpbGuidelineVO groupLocationCmpbGuidelineVO, SignOnUserAccount account) 
		throws EventException;
	
	/**
	 * 헤더 별 copy 등록한다<br>
	 * 
	 * @param RsltDurationCreationOfficeVO rsltDurationCreationOfficeVO 
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void copyGroupLocationCmpbGuideline(RsltDurationCreationOfficeVO rsltDurationCreationOfficeVO, SignOnUserAccount account) 
	throws EventException;
	
	/**
	 * 헤더 별 전체 삭제한다.<br>
	 * 
	 * @param PriCmpbGlineMnVO priCmpbGlineMnVO
	 * @param account SignOnUserAccount 
	 * @exception EventException
	 */
	public void removeGroupLocationCmpbGuideline (PriCmpbGlineMnVO priCmpbGlineMnVO, SignOnUserAccount account ) throws EventException;
	
	/**
	 * Rate에서 사용하는 Location 코드가 있는지 조회한다.
	 * @param GroupLocationCmpbGuidelineVO groupLocationCmpbGuidelineVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkGroupLocationInUse(GroupLocationCmpbGuidelineVO groupLocationCmpbGuidelineVO) throws EventException;
}