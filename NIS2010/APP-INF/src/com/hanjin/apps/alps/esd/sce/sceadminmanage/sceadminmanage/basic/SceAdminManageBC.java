/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SceAdminManageBC.java
*@FileTitle : SCE Admin
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.02
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.12.02 김인수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.basic;

import java.util.List;
import java.util.Set;

import com.hanjin.apps.alps.esd.sce.copdetailreceive.vo.SceActRcvIfVO;
import com.hanjin.apps.alps.esd.sce.sceadminmanage.SceAdminManageSC;
import com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.event.EsdSce6000Event;
import com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.vo.CntrDiffVO;
import com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.vo.SceAdminObjVO;
import com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.vo.SearchLeaMonthlyWorkVO;
import com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.vo.SearchSceMnlRplnVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.syscommon.common.table.SceActTmlIfVO;
import com.hanjin.syscommon.common.table.SceCopHdrVO;
import com.hanjin.framework.core.layer.event.Event;

/**
 * ALPS-Sceadminmanage Business Logic Command Interface<br>
 * - ALPS-Sceadminmanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kim In-soo
 * @see SceAdminManageSC 참조
 * @since J2EE 1.6
 */

public interface SceAdminManageBC {

	/**
	 * terminal change 수행 내역을 조회한다. 
	 * @param SceAdminObjVO	sceAdminObjVO
	 * @return List<SceActTmlIfVO>
	 * @exception EventException
	 */
	public List<SceActTmlIfVO> searchTmlChgRslt(SceAdminObjVO sceAdminObjVO) throws EventException;
	
	/**
	 * terminal change 를 재 실행한다.
	 * @param SceActTmlIfVO sceActTmlIfVO
	 * @return int
	 * @throws EventException
	 */
	public int modifyActTmlIfSts (SceActTmlIfVO sceActTmlIfVO) throws EventException;
	
	/**
	 * @param SceAdminObjVO sceAdminObjVO
	 * @return List<SceCopHdrVO> 
	 * @throws EventException
	 */
	public List<SceCopHdrVO> searchRplnCops(SceAdminObjVO sceAdminObjVO) throws EventException;
	
	/**
	 * COA 의 비용계산 일배치로 bkg 을 넘김
	 * @param Set<String> bkgNoSet
	 * @throws EventException
	 */
	public void interfaceMasDailyBtch (Set<String> bkgNoSet) throws EventException ;
	
	/**
	 * @param String fm_dt
	 * @param String to_dt
	 * @return List<SceCopHdrVO>
	 * @throws EventException
	 */
	public List<SceCopHdrVO> searchMstCopNoDiff (String fm_dt, String to_dt) throws EventException;
	
	
	/**
	 * CNTR의 DIFF 내역을 조회한다.
	 * @param String fm_dt
	 * @param String to_dt
	 * @return List<CntrDiffVO>
	 * @exception EventException
	 */
	public List<CntrDiffVO> searchCntrDiff(String fm_dt, String to_dt) throws EventException;
	
	/**
	 * @param SceAdminObjVO sceAdminObjVO
	 * @return List<SceActRcvIfVO>
	 * @throws EventException
	 */
	public List<SceActRcvIfVO> searchActDatRcvIf(SceAdminObjVO sceAdminObjVO) throws EventException;
	
	/**
	 * LEA 월말 결산 대상을 조회한다.
	 * @param Event e
	 * @return List<SearchLeaMonthlyWorkVO>
	 * @throws EventException
	 */
	public List<SearchLeaMonthlyWorkVO> searchLeaMonthlyWorkCandidate(Event e) throws EventException;
	
	/**
	 * LEA 대상을 SCE로 IF 한다.
	 * @param SearchLeaMonthlyWorkVO searchLeaMonthlyWorkVO
	 * @return int
	 * @throws EventException
	 */
	public int addCandidateSceCsrMntr (SearchLeaMonthlyWorkVO searchLeaMonthlyWorkVO) throws EventException;

	/**
	 * SCE_CSR_MNTR TABLE의 DATA를 삭제한다.
	 * @return int
	 * @throws EventException
	 */
	public int delSceCsrMntr() throws EventException;
	
	/**
	 * Manual Replan table에 replan대상을 추가한다.
	 * @param SearchSceMnlRplnVO rplnVo
	 * @return int
	 * @throws EventException
	 */
	public int addSceMngRpln(SearchSceMnlRplnVO rplnVo) throws EventException;
	
	/**
	 * LEA 결산 대상 데이타를 조회한다.
	 * @return List<SearchSceMnlRplnVO>
	 * @throws EventException
	 */	
	public List<SearchSceMnlRplnVO> searchSceMngRplnCandidate() throws EventException;
	
	/**
	 * Manual Replan 대상을 조회한다.
	 * @return DBRowSet
	 * @throws EventException
	 */
	public DBRowSet searchSceMngRpln() throws EventException;
}