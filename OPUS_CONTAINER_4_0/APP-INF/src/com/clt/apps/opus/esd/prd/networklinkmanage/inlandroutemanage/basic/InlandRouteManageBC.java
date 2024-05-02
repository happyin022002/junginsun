/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : InlandRouteManageBC.java
 *@FileTitle : Inland Route Management
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.basic;

import java.util.List;

import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.EmptySaveInlandRouteDetVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.EmptySaveInlandRouteMstVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.GetReferenceNoVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteDetVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteMsUSVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteSelCreVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteUSDetVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.RowSearchEmptyMasterVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.RowSearchInlandRouteManageVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.RowSearchMasterVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.SearchConditionVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.SearchEmptyInlandRouteMasterListVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.SearchInlandRouteManageAsiaEuVO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * PRD Business Logic Command Interface<br>
 * 
 * @author jungsunyong
 * @see ESD_PRD_005EventResponse
 * @since J2EE 1.4
 */
public interface InlandRouteManageBC {

	/**
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<SearchInlandRouteManageAsiaEuVO> searchInlandRouteManageList(SearchConditionVO vo) throws EventException;

	/**
	 * @param inlandRouteMsUSVO
	 * @return
	 * @throws EventException
	 */
	public List<RowSearchMasterVO> rowSearchMaster(InlandRouteMsUSVO inlandRouteMsUSVO) throws EventException;

	/**
	 * @param inlandRouteMsUSVO
	 * @return
	 * @throws EventException
	 */
	public String searchPrioSeq(InlandRouteMsUSVO inlandRouteMsUSVO) throws EventException;

	/**
	 * @param inlandRouteDetVO
	 * @return
	 * @throws EventException
	 */
	public List<InlandRouteDetVO> searchInlandRouteManage(InlandRouteDetVO inlandRouteDetVO) throws EventException;

	/**
	 * InlandRouteManageBC's rowSearchInlandRouteManage
	 * 
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<RowSearchInlandRouteManageVO> rowSearchInlandRouteManage(RowSearchInlandRouteManageVO vo) throws EventException;

	/**
	 * InlandRouteManageBC's multi01InlandRouteManage new
	 * 
	 * @param inlandRouteUSDetVOs
	 * @param inlandRouteMsUSVO
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public String multi01InlandRouteManage(InlandRouteUSDetVO[] inlandRouteUSDetVOs, InlandRouteMsUSVO inlandRouteMsUSVO, SignOnUserAccount account) throws EventException;

	/**
	 * InlandRouteManageBC's searchInlandRouteManageList01
	 * 
	 * @param inlandRouteVO
	 * @return
	 * @throws EventException
	 */
	public List<InlandRouteVO> searchInlandRouteManageList01(InlandRouteVO inlandRouteVO) throws EventException;

	/**
	 * InlandRouteManageBC's searchInlandRouteManageCreateList
	 * 
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
	 * 
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
	public DBRowSet getInLandRouteExistCount(InlandRouteMsUSVO inlandRouteMsUSVO, InlandRouteUSDetVO[] InlandRouteUSDetVOs) throws EventException;

	/**
	 * InlandRouteManageBC's getInLandRouteRemarkCompare
	 * 
	 * @param inlandRouteMsUSVO
	 * @return
	 * @throws EventException int
	 */
	public int getInLandRouteRemarkCompare(InlandRouteMsUSVO inlandRouteMsUSVO) throws EventException;

	/**
	 * InlandRouteManageBC's updateRemark
	 * 
	 * @param inlandRouteMsUSVO
	 * @throws EventException
	 */
	public void updateRemark(InlandRouteMsUSVO inlandRouteMsUSVO) throws EventException;

	/**
	 * InlandRouteManageBC's searchEmptyInlandRouteManageList
	 * 
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
	 * 
	 * @param vos
	 * @param iDelFlg
	 * @param account
	 * @throws EventException
	 */
	public void multiInlandRouteManage(SearchInlandRouteManageAsiaEuVO[] vos, String iDelFlg, SignOnUserAccount account) throws EventException;

	/**
	 * @param emptySaveInlandRouteMstVO
	 * @param account
	 * @param iDelFlg
	 * @throws EventException
	 */
	public void multiEmptyInlandRouteManage(EmptySaveInlandRouteMstVO[] emptySaveInlandRouteMstVO, SignOnUserAccount account, String iDelFlg) throws EventException;

	/**
	 * InlandRouteManageBC's getEmptyInLandRouteExistCount
	 * 
	 * @param vos
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public DBRowSet getEmptyInLandRouteExistCount(EmptySaveInlandRouteDetVO[] vos, EmptySaveInlandRouteDetVO vo) throws EventException;

	/**
	 * InlandRouteManageBC's updateEmptyRemark
	 * 
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public int updateEmptyRemark(EmptySaveInlandRouteDetVO vo) throws EventException;

	/**
	 * InlandRouteManageBC's multi01EmptyInlandRouteManage
	 * 
	 * @param vos
	 * @param vo
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public String multi01EmptyInlandRouteManage(EmptySaveInlandRouteDetVO[] vos, EmptySaveInlandRouteDetVO vo, SignOnUserAccount account) throws EventException;

	/**
	 * InlandRouteManageBC's rowSearchEmptyMaster
	 * 
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<RowSearchEmptyMasterVO> rowSearchEmptyMaster(EmptySaveInlandRouteDetVO vo) throws EventException;

	/**
	 * updatePrdInlndRoutMst
	 * 
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public int updatePrdInlndRoutMst(InlandRouteMsUSVO vo) throws EventException;
}
