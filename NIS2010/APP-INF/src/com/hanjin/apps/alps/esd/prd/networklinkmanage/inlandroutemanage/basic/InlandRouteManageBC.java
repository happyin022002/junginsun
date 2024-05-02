/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : InlandRouteManageBC.java
 *@FileTitle : Inland Route 정보관리화면
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-09-04
 *@LastModifier : jungsunyong
 *@LastVersion : 1.0
 * 2006-09-04 jungsunyong
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.EmptySaveInlandRouteDetVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.EmptySaveInlandRouteMstVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.GetReferenceNoVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteDetVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteMsUSVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteSelCreVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteUSDetVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.RowSearchEmptyMasterVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.RowSearchInlandRouteManageVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.RowSearchMasterVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.SearchConditionVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.SearchEmptyInlandRouteMasterListVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.SearchInlandRouteManageAsiaEuVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PrdProdCtlRoutDtlVO;

/**
 * alps-PRD Business Logic Command Interface<br>
 * - alps-PRD에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author jungsunyong
 * @see ESD_PRD_005EventResponse 참조
 * @since J2EE 1.4
 */
public interface InlandRouteManageBC{

	/**
	 * ★2009-09-08 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<SearchInlandRouteManageAsiaEuVO> searchInlandRouteManageList(SearchConditionVO vo) throws EventException;

	/**
	 * ★2009-08-12 kim kwijin생성
	 * @param inlandRouteMsUSVO
	 * @return
	 * @throws EventException
	 */
	public List<RowSearchMasterVO> rowSearchMaster(InlandRouteMsUSVO inlandRouteMsUSVO) throws EventException;

	/**
	 * ★2009-08-12 kim kwijin생성
	 * @param inlandRouteMsUSVO
	 * @return
	 * @throws EventException
	 */
	public String searchPrioSeq(InlandRouteMsUSVO inlandRouteMsUSVO) throws EventException;

	/**
	 * ★2009/07/30 kim kwi-jin생성
	 * @param inlandRouteDetVO
	 * @return
	 * @throws EventException
	 */
	public List<InlandRouteDetVO> searchInlandRouteManage(InlandRouteDetVO inlandRouteDetVO) throws EventException;

	/**
	 * InlandRouteManageBC's rowSearchInlandRouteManage
	 * ★2009/08/13 kim kwi-jin생성
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<RowSearchInlandRouteManageVO> rowSearchInlandRouteManage(RowSearchInlandRouteManageVO vo) throws EventException;

	/**
	 * InlandRouteManageBC's multi01InlandRouteManage new
	 * @param inlandRouteUSDetVOs
	 * @param inlandRouteMsUSVO
	 * @param account
	 * @return
	 * @throws EventException
	 * ★ 2009-08-11 kimkwijin
	 */
	public String multi01InlandRouteManage(InlandRouteUSDetVO[] inlandRouteUSDetVOs, InlandRouteMsUSVO inlandRouteMsUSVO, SignOnUserAccount account) throws EventException;

	/**
	 * InlandRouteManageBC's searchInlandRouteManageList01
	 * ★ 2009/07/29 kim kwi-jin 생성
	 * @param inlandRouteVO
	 * @return
	 * @throws EventException
	 */
	public List<InlandRouteVO> searchInlandRouteManageList01(InlandRouteVO inlandRouteVO) throws EventException;

	/**
	 * ★ 2009/09/01 kim kwi-jin 생성
	 * InlandRouteManageBC's searchInlandRouteManageCreateList
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<InlandRouteSelCreVO> searchInlandRouteManageCreateList(InlandRouteSelCreVO vo) throws EventException;

	/**
	 * 
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<GetReferenceNoVO> getReferenceNo(GetReferenceNoVO vo) throws EventException;

	/**
	 * InlandRouteManageBC's saveAsInlandRouteManage
	 * ★2009-08-28 kim kwijin생성
	 * @param vos
	 * @param vo
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public String saveAsInlandRouteManage(InlandRouteUSDetVO[] vos, InlandRouteMsUSVO vo, SignOnUserAccount account) throws EventException;

	/**
	 * 
	 * @param inlandRouteMsUSVO
	 * @param InlandRouteUSDetVOs
	 * @return
	 * @throws EventException
	 */
	public int getInLandRouteExistCount(InlandRouteMsUSVO inlandRouteMsUSVO, InlandRouteUSDetVO[] InlandRouteUSDetVOs) throws EventException;

	/**
	 * InlandRouteManageBC's getInLandRouteRemarkCompare
	 * @param inlandRouteMsUSVO
	 * @return
	 * @throws EventException int
	 */
	public int getInLandRouteRemarkCompare(InlandRouteMsUSVO inlandRouteMsUSVO) throws EventException;

	/**
	 * InlandRouteManageBC's updateRemark
	 * @param inlandRouteMsUSVO
	 * @throws EventException 
	 */
	public void updateRemark(InlandRouteMsUSVO inlandRouteMsUSVO) throws EventException;

	/**
	 * InlandRouteManageBC's searchEmptyInlandRouteManageList
	 * @param vo
	 * @return
	 * @throws EventException EventResponse
	 */
	public List<SearchEmptyInlandRouteMasterListVO> searchEmptyInlandRouteManageList(SearchConditionVO vo) throws EventException;

	/**
	 * 
	 * @param inlandRouteDetVO
	 * @return
	 * @throws EventException
	 */
	public List<InlandRouteDetVO> searchEmptyInlandRouteManage(InlandRouteDetVO inlandRouteDetVO) throws EventException;

	/**
	 * InlandRouteManageBC's multiEmptyInlandRouteManage
	 * ★2009-09-09 kim kwijin생성
	 * @param vos
	 * @param iDelFlg
	 * @param account
	 * @throws EventException
	 */
	public void multiInlandRouteManage(SearchInlandRouteManageAsiaEuVO[] vos, String iDelFlg, SignOnUserAccount account) throws EventException;

	/**
	 * ★ 2009-08-24 KIM KWIJIN 생성
	 * @param emptySaveInlandRouteMstVO
	 * @param account
	 * @param iDelFlg
	 * @throws EventException
	 */
	public void multiEmptyInlandRouteManage(EmptySaveInlandRouteMstVO[] emptySaveInlandRouteMstVO, SignOnUserAccount account, String iDelFlg) throws EventException;

	/**
	 * InlandRouteManageBC's getEmptyInLandRouteExistCount
	 * ★ 2009-08-24 KIM KWIJIN 생성
	 * @param vos
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public int getEmptyInLandRouteExistCount(EmptySaveInlandRouteDetVO[] vos, EmptySaveInlandRouteDetVO vo) throws EventException;

	/**
	 * InlandRouteManageBC's updateEmptyRemark
	 * ★2009-08-25 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public int updateEmptyRemark(EmptySaveInlandRouteDetVO vo) throws EventException;

	/**
	 * InlandRouteManageBC's multi01EmptyInlandRouteManage
	 * ★2009-08-25 kim kwijin생성
	 * @param vos
	 * @param vo
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public String multi01EmptyInlandRouteManage(EmptySaveInlandRouteDetVO[] vos, EmptySaveInlandRouteDetVO vo, SignOnUserAccount account) throws EventException;

	/**
	 * InlandRouteManageBC's rowSearchEmptyMaster
	 * ★2009-08-25 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<RowSearchEmptyMasterVO> rowSearchEmptyMaster(EmptySaveInlandRouteDetVO vo) throws EventException;

	/**
     * Auto IRG가 생성되어야 하는지 검사하고 필요시 생성함<br>
	 * @param autoIrgParamVO
	 * @param usrId
	 * @param ofcCd
	 * @throws EventException
	 */
	public void createAutoIRG(PrdProdCtlRoutDtlVO autoIrgParamVO, String usrId, String ofcCd) throws EventException;

}
