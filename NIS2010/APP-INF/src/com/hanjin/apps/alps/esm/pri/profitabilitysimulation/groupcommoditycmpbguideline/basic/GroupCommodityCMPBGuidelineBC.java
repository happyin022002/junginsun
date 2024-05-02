/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GroupCommodityCMPBGuidelineBC.java
*@FileTitle : CMPB Guideline Creation - Commodity Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.07.14 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.groupcommoditycmpbguideline.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.RsltDurationCreationOfficeVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.groupcommoditycmpbguideline.vo.GroupCommodityCmpbGuidelineVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.groupcommoditycmpbguideline.vo.RsltPriCmpbGrpCmdtDtlVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriCmpbGlineMnVO;
import com.hanjin.syscommon.common.table.PriCmpbGrpCmdtVO;

/**
 * ALPS-Profitabilitysimulation Business Logic Command Interface<br>
 * - ALPS-Profitabilitysimulation에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Seung-Jun,Lee
 * @see Esm_pri_6041EventResponse 참조
 * @since J2EE 1.6
 */

public interface GroupCommodityCMPBGuidelineBC {

	/**
	 * PRI_CMPB_GRP_CMDT_DTL 테이블을 조회한다.<br>
	 * 
	 * @param PriCmpbGrpCmdtVO priCmpbGrpCmdtVO  
	 * @return List<RsltPriCmpbGrpCmdtDtlVO>
	 * @exception EventException
	 */
	public List<RsltPriCmpbGrpCmdtDtlVO> searchCmpbGroupCommodityDetailList(PriCmpbGrpCmdtVO priCmpbGrpCmdtVO) throws EventException;
	
	/**
	 * PRI_CMPB_GRP_CMDT 테이블을 조회한다.<br>
	 * 
	 * @param PriCmpbGrpCmdtVO priCmpbGrpCmdtVO 
	 * @return List<PriCmpbGrpCmdtVO>
	 * @exception EventException
	 */
	public List<PriCmpbGrpCmdtVO> searchCmpbGroupCommodityList(PriCmpbGrpCmdtVO priCmpbGrpCmdtVO) throws EventException;
	
	/**
	 * PRI_CMPB_GRP_CMDT, PRI_CMPB_GRP_CMDT_DTL을 입력 수정 삭제한다<br>
	 * 
	 * @param groupCommodityCmpbGuidelineVO GroupCommodityCmpbGuidelineVO
	 * @param SignOnUserAccount account 
	 * @exception EventException
	 */
	public void manageGroupCommodityCmpbGuideline(GroupCommodityCmpbGuidelineVO groupCommodityCmpbGuidelineVO, SignOnUserAccount account) 
		throws EventException;
	
	
	/**
	 * 헤더 별 copy 등록한다<br>
	 * 
	 * @param RsltDurationCreationOfficeVO rsltDurationCreationOfficeVO 
	 * @param SignOnUserAccount account  
	 * @exception EventException
	 */
	public void copyGroupCommodityCmpbGuideline(RsltDurationCreationOfficeVO rsltDurationCreationOfficeVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * 헤더 별 전체 삭제<br>
	 * 
	 * @param PriCmpbGlineMnVO priCmpbGlineMnVO
	 * @param SignOnUserAccount account  
	 * @exception EventException
	 */
	public void removeGroupCommodityCmpbGuideline (PriCmpbGlineMnVO priCmpbGlineMnVO, SignOnUserAccount account ) throws EventException;
	
	
	/**
	 * Rate에서 사용하는 commodity 코드가 있는지 조회한다.
	 * @param GroupCommodityCmpbGuidelineVO groupCommodityCmpbGuidelineVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkGroupCommodityInUse(GroupCommodityCmpbGuidelineVO groupCommodityCmpbGuidelineVO) throws EventException;
}