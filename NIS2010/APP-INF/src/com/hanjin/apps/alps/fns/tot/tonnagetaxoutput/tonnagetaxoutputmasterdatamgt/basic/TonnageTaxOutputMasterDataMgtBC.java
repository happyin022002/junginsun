/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TonnageTaxOutputMasterDataMgtBC.java
*@FileTitle : TOT
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.05.21 장창수
* 1.0 Creation
* History
* 2012.01.27 이준범 [CHM-201113807-01]
* 제목 : ALPS 톤세 시스템 기능보완 - T/TAX Recalculation
* 내용 : 1) T/Tax Recalculated 옆에 Lane이 추가 되면 추가된 선박만 재배치 할 수 있게 처리
*       2) T/Tax Recalculated 작업 후, 변경된 내역을 표시해주는 팝업창 또는 화면을 추가하여
*          변경사항 확인할 수 있게 처리
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.basic;

import java.util.List;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.BsaVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.LaneVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.MissLaneChkVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.NrtBsaChgVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.VslVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.PndlmPortVO;
import com.hanjin.syscommon.common.table.TotVesselVO;
import com.hanjin.syscommon.common.table.TotBsaVO;
/**
 * ALPS-Tonnagetaxoutput Business Logic Command Interface<br>
 * - ALPS-Tonnagetaxoutput에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jang Chang Soo
 * @see Fns_tot_0001EventResponse 참조
 * @since J2EE 1.6
 */

public interface TonnageTaxOutputMasterDataMgtBC {
	
	/**
	 * VESSEL 정보를 조회한다. <br>
	 * 
	 * @param VslVO vslVO
	 * @return List<VslVO>
	 * @exception EventException
	 */
	public List<VslVO> searchUseTonnageVesselList(VslVO vslVO) throws EventException;
	
	/**
	 * 추가,수정 또는 삭제된 VESSEL 정보를 저장한다. <br>
	 * 
	 * @param TotVesselVO[] totVesselVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @exception EventException
	 */
	public void manageUseTonnageVessel (TotVesselVO[] totVesselVOs,SignOnUserAccount signOnUserAccount) throws EventException;

	/**
	 * 30일이상 사용하지 않은 VESSEL 정보를 조회한다. <br>
	 * 
	 * @param VslVO vslVO
	 * @return List<VslVO>
	 * @exception EventException
	 */
	public List<VslVO> searchUnusedVesselList(VslVO vslVO) throws EventException;
	
	/**
	 * 추가,수정 또는 삭제된 30일 이상 사용하지 않은 VESSEL 정보를 저장한다. <br>
	 * 
	 * @param TotVesselVO[] totVesselVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @exception EventException
	 */
	public void manageUnusedVessel (TotVesselVO[] totVesselVOs,SignOnUserAccount signOnUserAccount) throws EventException;

	/**
	 * VESSEL 정보의 가장 최근 업데이트된 날짜조회한다. <br>
	 * 
	 * @param VslVO vslVO
	 * @return List<VslVO>
	 * @exception EventException
	 */	
	public List<VslVO> searchRecentUpdateDt(VslVO vslVO) throws EventException; 

	/**
	 * [VSL_PORT_SKD] 테이블 기준대상 Lane의 Trade정보를 조회한다. <br>
	 * 
	 * @param LaneVO laneVO
	 * @return List<LaneVO>
	 * @exception EventException
	 */	
	public List<LaneVO> searchLaneTradeGroupList(LaneVO laneVO) throws EventException;

	/**
	 * [VSL_PORT_SKD] 테이블 기준대상 Lane의 Trade정보의 최근업데이트일자를 조회한다. <br>
	 * 
	 * @param LaneVO laneVO
	 * @return List<LaneVO>
	 * @exception EventException
	 */	
	public List<LaneVO> searchRcLaneUpdateDt(LaneVO laneVO) throws EventException; 

	/**
	 * 추가,수정 또는 삭제된 Trade정보를 저장한다. <br>
	 * 
	 * @param LaneVO[] laneVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @exception EventException
	 */	
	public void manageLaneTradeGroup (LaneVO[] laneVOs,SignOnUserAccount signOnUserAccount) throws EventException;

	/**
	 * 전월의 lane group 정보를 해당년월에 copy한다. <br>
	 * 
	 * @param LaneVO laneVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @exception EventException
	 */	
	public void createLaneTradeGroupFromPreMonth (LaneVO laneVO,SignOnUserAccount signOnUserAccount) throws EventException;

	
	/**
	 * Pendulm port Start Port List, End Port List 정보를 조회한다. <br>
	 * 
	 * @param PndlmPortVO pndlmPortVO
	 * @return List<PndlmPortVO>
	 * @exception EventException
	 */	
	public List<PndlmPortVO> searchPendulumLanePortCodeList(PndlmPortVO pndlmPortVO) throws EventException;

	/**
	 * Pendulm port Start Port List, End Port List 정보의 최근업데이트된 날짜를 조회한다. <br>
	 * 
	 * @param PndlmPortVO pndlmPortVO
	 * @return List<PndlmPortVO>
	 * @exception EventException
	 */	
	public List<PndlmPortVO> searchPendulumRecentUpdateDt(PndlmPortVO pndlmPortVO) throws EventException;
	
	/**
	 * 추가, 수정, 삭제된 Pendulm port Start Port List, End Port List 정보를 저장한다. <br>
	 * 
	 * @param PndlmPortVO[] pndlmPortVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @return int
	 * @exception EventException
	 */	
	public int managePendulumLanePortCode (PndlmPortVO[] pndlmPortVOs,SignOnUserAccount signOnUserAccount) throws EventException;

	/**
	 * BSA 정보를 조회한다. <br>
	 * 
	 * @param BsaVO bsaVO
	 * @return List<BsaVO>
	 * @exception EventException
	 */	
	public List<BsaVO> searchBSAListByVVD(BsaVO bsaVO) throws EventException;

	/**
	 * BSA 정보의 tax 재계산전 변경된 데이터가 있는지 여부를 조회한다. <br>
	 * 
	 * @param TotBsaVO totBsaVO
	 * @return List<TotBsaVO>
	 * @exception EventException
	 */	
	public List<TotBsaVO> searchBSAModiFlgYCnt(TotBsaVO totBsaVO) throws EventException;

	/**
	 * BSA 정보의 배치처리된 데이터가 있는지를 조회한다. <br>
	 * 
	 * @param TotBsaVO totBsaVO
	 * @return List<TotBsaVO>
	 * @exception EventException
	 */	
	public List<TotBsaVO> searchBSABatchCnt(TotBsaVO totBsaVO) throws EventException;

	/**
	 * BSA 정보의 최근업데이트 일자를 조회한다. <br>
	 * 
	 * @param BsaVO bsaVO
	 * @return List<BsaVO>
	 * @exception EventException
	 */	
	public List<BsaVO> searchBSARecentUpdateDt(BsaVO bsaVO) throws EventException;

	/**
	 * 수정된 BSA 정보를 저장한다. <br>
	 * 
	 * @param TotBsaVO[] totBsaVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @exception EventException
	 */	
	public void manageBSAByVVD (TotBsaVO[] totBsaVOs,SignOnUserAccount signOnUserAccount) throws EventException;
	
	/**
	 * 해당년월의 정보를 모두 삭제한다. <br>
	 * 
	 * @param BsaVO bsaVO
	 * @exception EventException
	 */	
	public void removeBSAByVVD (BsaVO bsaVO) throws EventException;

	/**
	 * 해당년월의 BSA 정보를 생성하여 저장한다. <br>
	 * 
	 * @param TotBsaVO totBsaVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @return String
	 * @exception EventException
	 */	
	public String manageIFBSAByVVD (TotBsaVO totBsaVO,SignOnUserAccount signOnUserAccount) throws EventException;

	/**
	 * 변경된(MODIFY FLAG = 'Y') 정보를 "N" 으로 초기화한다. <br>
	 * 
	 * @param TotBsaVO totBsaVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @exception EventException
	 */	
	public void manageRecalculateBsaForModiFlg (TotBsaVO totBsaVO,SignOnUserAccount signOnUserAccount) throws EventException;

	/**
	 * NRT & BSA Change 정보를 조회한다. <br>
	 * 
	 * @param String stlYrmon
	 * @return List<NrtBsaChgVO>
	 * @exception EventException
	 */	
	public List<NrtBsaChgVO>  searchNrtBsaChg(String stlYrmon) throws EventException;
	
	/**
	 * Missing Lane Check 정보를 조회한다. <br>
	 * 
	 * @param String stlYrmon
	 * @return List<MissLaneChkVO>
	 * @exception EventException
	 */	
	public List<MissLaneChkVO>  searchMissLaneChk(String stlYrmon) throws EventException;
	
	/**
	 * NRT & BSA Change 화면에서 BSA Before 를 After로 업데이트 한다.<br>
	 * 
	 * @param NrtBsaChgVO nrtBsaChgVO
	 * @exception EventException
	 */	
	public void modifyNrtBsaChgBsa (NrtBsaChgVO nrtBsaChgVO) throws EventException;

	/**
	 * VESSEL 정보를 저장한다. <br>
	 * 
	 * @param VslVO vslVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @exception EventException
	 */
	public void createUseTonnageVessel(VslVO vslVO, SignOnUserAccount signOnUserAccount) throws EventException;

	
	/**
	 * lane group 정보를 해당년월에 넣는다. <br>
	 * @param LaneVO laneVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @exception EventException
	 */
	public void createLaneTradeGroupByVesselSchedule (LaneVO laneVO,SignOnUserAccount signOnUserAccount)  throws EventException;
}