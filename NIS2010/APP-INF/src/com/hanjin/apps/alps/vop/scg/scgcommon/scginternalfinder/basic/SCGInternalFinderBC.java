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
package com.hanjin.apps.alps.vop.scg.scgcommon.scginternalfinder.basic;

import java.util.List;

import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.PartnerApprovalRequestVO;
import com.hanjin.apps.alps.vop.scg.scgcommon.scginternalfinder.vo.CheckUNNumberVO;
import com.hanjin.apps.alps.vop.scg.scgcommon.scginternalfinder.vo.SearchUNNumberVO;
import com.hanjin.apps.alps.vop.scg.scgcommon.scginternalfinder.vo.CheckPckCdVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.syscommon.common.table.ScgImdgClssCdVO;
import com.hanjin.syscommon.common.table.ScgImdgSpclProviVO;
import com.hanjin.syscommon.common.table.ScgImdgUnNoVO;
import com.hanjin.syscommon.common.table.ScgIrrTpCdVO;

/**
 * ALPS-Scgcommon Business Logic Command Interface<br>
 * - ALPS-Scgcommon에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Dohyoung Lee
 * @see Scg_com_internalEventResponse 참조
 * @since J2EE 1.6
 */

public interface SCGInternalFinderBC {
	/**
	 * UN No.를 조회 합니다. <br>
	 * 
	 * @param UnNumberCode 
	 * @return List<CheckUNNumberVO>
	 * @exception EventException
	 */
	public List<CheckUNNumberVO> checkUNNumber(String UnNumberCode) throws EventException;

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
     * IMDG UN Number 의  Seq 를 조회 합니다. <br>
     * 
     * @param ScgImdgUnNoVO
     * @return List<ScgImdgUnNoVO> 
     * @throws EventException
     */
	public List<ScgImdgUnNoVO> searchImdgUnNoSeqList(ScgImdgUnNoVO scgImdgUnNoVO) throws EventException; 
    /**
     * IMDG UN No, IMDG UN No Seq 의 Class, Sub Risk, PG 를 조회 합니다. <br>
     * 
     * @param ScgImdgUnNoVO
     * @return List<PartnerApprovalRequestVO> 
     * @throws EventException
     */
	public List<PartnerApprovalRequestVO> searchClassSubRiskPGData(ScgImdgUnNoVO scgImdgUnNoVO) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param pckCd
	 * @return List<CheckPckCdVO>
	 * @exception EventException
	 */
	public List<CheckPckCdVO> checkPckCd(String pckCd) throws EventException;

}