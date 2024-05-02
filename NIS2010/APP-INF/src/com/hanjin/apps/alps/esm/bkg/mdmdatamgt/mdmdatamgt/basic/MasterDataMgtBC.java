/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : MasterDataMgtBC.java
*@FileTitle : MDM DATA Management
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.28
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.06.28
* 1.0 Creation
* 
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.mdmdatamgt.mdmdatamgt.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.mdmdatamgt.mdmdatamgt.vo.MdmStateVO;
import com.hanjin.apps.alps.esm.bkg.mdmdatamgt.mdmdatamgt.vo.SearchBkgIdaSacMstVO;
import com.hanjin.apps.alps.esm.bkg.mdmdatamgt.mdmdatamgt.vo.SearchMdmChargeVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgIdaSacMstVO;
import com.hanjin.syscommon.common.table.MdmChargeVO;
 
/**
 *ALPS-MdmDataMgtSC Business Logic Basic Command Interface<br>
 * - ALPS-MdmDataMgtSC 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SONG Min Seok
 * @since J2EE 1.6
 */

public interface MasterDataMgtBC {
	
    /**
     * 조회 이벤트 처리<br>
     * MDM_CHARGE LIST 데이타 모델에 해당되는 값을 불러온다.<br>
     * @author SONG Min Seok
     * @param SearchMdmChargeVO paramVO
     * @return List<SearchMdmChargeVO> 
     * @exception EventException
     */
    public List<SearchMdmChargeVO> searchMdmChargeList(SearchMdmChargeVO paramVO) throws EventException ;
    
    /**
     * MDM_CHARGE의 정보중 mdm에서 interface 되지 않는 일부 정보를 update한다<br>    
     * 
     * @param MdmChargeVO[] mdmChargeVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageMdmChargeList(MdmChargeVO[] mdmChargeVOs,SignOnUserAccount account) throws EventException;
    
    /**
     * 조회 이벤트 처리<br>
     * India SAC Master Data LIST 데이타 모델에 해당되는 값을 불러온다.<br>
     * @author SONG Min Seok
     * @param SearchBkgIdaSacMstVO paramVO
     * @return List<SearchBkgIdaSacMstVO> 
     * @exception EventException
     */
    public List<SearchBkgIdaSacMstVO> searchIndiaSacMasterList (SearchBkgIdaSacMstVO paramVO) throws EventException ;
    
    
	/**
	 * MDM_State 조회 이벤트 처리(ESM_BKG_S002)<br>

	 * @param MdmStateVO vo
	 * @return List<MdmStateVO>
	 * @throws EventException
	 */
	public List<MdmStateVO> searchMdmStateList (MdmStateVO vo) throws EventException;
	
    /**
     * MDM_State의 일부 정보를 update한다<br>    
     * 
     * @param MdmStateVO[] MdmStateVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageMdmState(MdmStateVO[] MdmStateVOs,SignOnUserAccount account) throws EventException;
	 
    /**
     * India SAC Master 정보를 update한다<br>    
     * 
     * @param BkgIdaSacMstVO[] bkgIdaSacMstVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageBkgIdaSacMstList(BkgIdaSacMstVO[] bkgIdaSacMstVOs,SignOnUserAccount account) throws EventException;
}