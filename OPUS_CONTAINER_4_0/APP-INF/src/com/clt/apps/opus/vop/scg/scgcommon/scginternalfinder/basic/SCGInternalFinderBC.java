/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGInternalFinderBC.java
*@FileTitle : SCG COMMON
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.06.02 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.scgcommon.scginternalfinder.basic;

import java.util.List;

import com.clt.apps.opus.vop.scg.scgcommon.scginternalfinder.vo.CheckUNNumberVO;
import com.clt.apps.opus.vop.scg.scgcommon.scginternalfinder.vo.SearchImdgAmdtMstVO;
import com.clt.apps.opus.vop.scg.scgcommon.scginternalfinder.vo.SearchUNNumberVO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.SearchRsoComboListVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.LocationVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.ScgImdgClssCdVO;
import com.clt.syscommon.common.table.ScgImdgSpclProviVO;
import com.clt.syscommon.common.table.ScgImdgUnNoVO;
import com.clt.syscommon.common.table.ScgIrrTpCdVO;

/**
 * OPUS-Scgcommon Business Logic Command Interface<br>
 * - OPUS-Scgcommon에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Dohyoung Lee
 * @see Scg_com_internalEventResponse 참조
 * @since J2EE 1.6
 */

public interface SCGInternalFinderBC {
	/**
	 * UN No.를 조회 합니다. <br>
	 * 
	 * @param scgImdgUnNoVO 
	 * @return List<CheckUNNumberVO>
	 * @exception EventException
	 */
	public List<CheckUNNumberVO> checkUNNumber(ScgImdgUnNoVO scgImdgUnNoVO) throws EventException;

	/**
	 * Class 를 조회 합니다. <br>
	 * 
	 * @return List<ScgImdgClssCdVO>
	 * @exception EventException
	 */
	public List<ScgImdgClssCdVO> searchUNClass() throws EventException;
	
	/**
	 * Special Provisions 를 조회 합니다. <br>
	 * 
	 * @param spclProviNo
	 * @return List<ScgImdgSpclProviVO>
	 * @exception EventException
	 */
	public List<ScgImdgSpclProviVO> checkSpclProvi(String spclProviNo) throws EventException;
	
	/**
	 * Akward 유형에 따라 Irregular Type 을 조회합니다. <br>
	 * 
	 * @param scgIrrTpCdVO
	 * @return List<ScgIrrTpCdVO>
	 * @exception EventException
	 */
	public List<ScgIrrTpCdVO> searchIrregularType(ScgIrrTpCdVO scgIrrTpCdVO) throws EventException;

	/**
	 * IMDG UN Number 의 List를 조회 합니다. <br>
	 * 
	 * @param searchUNNumberVO
	 * @return List<SearchUNNumberVO>
	 * @exception EventException
	 */
	public List<SearchUNNumberVO> searchUNNumber(SearchUNNumberVO searchUNNumberVO) throws EventException;
	
    /**
     * SPCL CGO Irregular List 의 UN No. 를 Check 합니다. <br>
     * 
     * @param searchUNNumberVO
     * @return List<SearchUNNumberVO>
     * @exception EventException
     */
    public List<SearchUNNumberVO> checkIrrUnNoList(SearchUNNumberVO searchUNNumberVO) throws EventException;	

    /**
     * IMDG UN Number 의 Total 건수를 조회 합니다. <br>
     * 
     * @param searchUNNumberVO
     * @return String
     * @throws EventException
     */
    public String searchUNNumberTotalCnt(SearchUNNumberVO searchUNNumberVO) throws EventException; 

    /**
	 * UN No. Combo retrieve <br>
	 * 
	 * @param scgImdgUnNoVO 
	 * @return List<CheckUNNumberVO>
	 * @exception EventException
	 */
	public List<CheckUNNumberVO> searchUNNo(ScgImdgUnNoVO scgImdgUnNoVO) throws EventException; 
	
    /**
     * 특정Port의 RSO 조회 합니다. <br>
     * 
     * @param LocationVO locationVO
     * @return String
     * @throws EventException
     */
    public String searchRSOforSpecificPort(LocationVO locationVO) throws EventException; 
    
    /**
	 * SCG_IMDG_AMDT_MST retrieve <br>
	 * 
	 * @param searchImdgAmdtMstVO 
	 * @return List<SearchImdgAmdtMstVO>
	 * @exception EventException
	 */
	public List<SearchImdgAmdtMstVO> searchImdgAmdtMst(SearchImdgAmdtMstVO searchImdgAmdtMstVO) throws EventException; 

    /**
	 * SCG_IMDG_AMDT_MST List retrieve <br>
	 * 
	 * @param searchImdgAmdtMstVO 
	 * @return List<SearchImdgAmdtMstVO>
	 * @exception EventException
	 */
	public List<SearchImdgAmdtMstVO> searchImdgAmdtMstList(SearchImdgAmdtMstVO searchImdgAmdtMstVO) throws EventException; 

    /**
	 * SCG_IMDG_UN_NO 의  IMDG_AMDT_NO  retrieve <br>
	 * 
	 * @param ScgImdgUnNoVO scgImdgUnNoVO 
	 * @return List<ScgImdgUnNoVO>
	 * @exception EventException
	 */
	public List<ScgImdgUnNoVO> searchImdgAmdtNo(ScgImdgUnNoVO scgImdgUnNoVO) throws EventException; 

    /**
     * 로그인 User의 RSO 조회 합니다. <br>
     * 
     * @param SignOnUserAccount account
     * @return String
     * @throws EventException
     */
    public String searchRSOforUser(SignOnUserAccount account) throws EventException;
}