/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IMDGCodeMgtBC.java
*@FileTitle : UN Number
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.05.18 이도형
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.basic;

import java.util.List;

import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.AutoCreationVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.ScgImdgClssSegrListVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.ScgImdgCompGrpSegrListVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.ScgImdgUnNoSegrListVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.SegregationSimulationInputVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.SegregationSimulationOutputVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.SegregationTableGrpVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.UNNumberGrpVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.UNNumberListOptionVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgImdgSpclProvisVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ScgImdgClssCdVO;
import com.hanjin.syscommon.common.table.ScgImdgExptQtyVO;
import com.hanjin.syscommon.common.table.ScgImdgPckCdVO;
import com.hanjin.syscommon.common.table.ScgImdgSegrGrpVO;
import com.hanjin.syscommon.common.table.ScgImdgSegrSymVO;
import com.hanjin.syscommon.common.table.ScgImdgSubsRskLblVO;

/**
 * ALPS-Dangerouscargoinformationmgt Business Logic Command Interface<br>
 * - ALPS-Dangerouscargoinformationmgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Dohyoung Lee
 * @see Vop_scg-0001EventResponse 참조
 * @since J2EE 1.4
 */

public interface IMDGCodeMgtBC {
	/**
	 * UN Number 의 Detail을 조회 합니다. <br>
	 * 
	 * @param unNumberListOptionVO
	 * @return List<UNNumberListOptionVO>
	 * @exception EventException
	 */
	public List<UNNumberListOptionVO> searchUNNumberList(UNNumberListOptionVO unNumberListOptionVO) throws EventException;

	/**
	 * Segregation을 조회 합니다. <br>
	 * 
	 * @param unNumberListOptionVO
	 * @return List<ScgImdgUnNoSegrListVO>
	 * @exception EventException
	 */
	public List<ScgImdgUnNoSegrListVO> searchSegrList(UNNumberListOptionVO unNumberListOptionVO) throws EventException;

	/**
	 * Subsidiary risk(s)을 조회 합니다. <br>
	 * 
	 * @param unNumberListOptionVO
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchSubsRskLblList(UNNumberListOptionVO unNumberListOptionVO) throws EventException;

	/**
	 * Special Provisions을 조회 합니다. <br>
	 * 
	 * @param unNumberListOptionVO
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchSpclProviList(UNNumberListOptionVO unNumberListOptionVO) throws EventException;

	/**
	 * Segregation Group Detail을 조회 합니다. <br>
	 * 
	 * @param unNumberListOptionVO
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchSegrGrpDtlList(UNNumberListOptionVO unNumberListOptionVO) throws EventException;

	/**
	 * Segregation Group을 조회 합니다. <br>
	 * 
	 * @param unNumberListOptionVO
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchSegrGrpList(UNNumberListOptionVO unNumberListOptionVO) throws EventException;

	/**
	 * Clss Cd을 조회 합니다. <br>
	 * 
	 * @param unNumberListOptionVO
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchClssCdList(UNNumberListOptionVO unNumberListOptionVO) throws EventException;

	/**
	 * Excepted Q'ty을 조회 합니다. <br>
	 * 
	 * @return List<ScgImdgExptQtyVO>
	 * @exception EventException
	 */
	public List<ScgImdgExptQtyVO> searchExceptedQtyList() throws EventException;

	/**
	 * Segregation Group의 List를 조회 합니다. <br>
	 * 
	 * @return List<ScgImdgSegrGrpVO>
	 * @exception EventException
	 */
	public List<ScgImdgSegrGrpVO> searchSegregationGroupList() throws EventException;

	/**
	 * AutoCreation의 Segregation을 조회 합니다. <br>
	 * 
	 * @param autoCreationVO
	 * @return List<ScgImdgUnNoSegrListVO>
	 * @exception EventException
	 */
	public List<ScgImdgUnNoSegrListVO> searchAutoCreation(AutoCreationVO autoCreationVO) throws EventException;

	/**
	 * UN Number을 생성/수정 합니다. <br>
	 * 
	 * @param unNumberGrpVO
	 * @param account
	 * @exception EventException
	 */
	public void manageUNNumber(UNNumberGrpVO unNumberGrpVO, SignOnUserAccount account) throws EventException;

	/**
	 * Numbers & symbols in segregation table between various Classes의 내용을 조회 합니다. <br>
	 * 
	 * @return List<ScgImdgClssSegrListVO>
	 * @exception EventException
	 */
	public List<ScgImdgClssSegrListVO> searchSegregationClssList() throws EventException;

	/**
	 * Permitted mixed stowage for goods of class 1의 내용을 조회 합니다. <br>
	 * 
	 * @return List<ScgImdgCompGrpSegrListVO>
	 * @exception EventException
	 */
	public List<ScgImdgCompGrpSegrListVO> searchSegregationCompList() throws EventException;

	/**
	 * Segregation Table의 내용을 수정 합니다. <br>
	 * 
	 * @param segregationTableGrpVO
	 * @param account
	 * @exception EventException
	 */
	public void manageSegregation(SegregationTableGrpVO segregationTableGrpVO,SignOnUserAccount account) throws EventException;

	/**
	 * Numbers & symbols in segregation table between various Classes의 내용을 조회 합니다. <br>
	 * 
	 * @param imdgSegrTpCd
	 * @return List<ScgImdgSegrSymVO>
	 * @exception EventException
	 */
	public List<ScgImdgSegrSymVO> searchSymbolList(String imdgSegrTpCd) throws EventException;

	/**
	 * Permitted mixed stowage for goods of class 1의 내용을 조회 합니다. <br>
	 * 
	 * @param imdgSegrTpCd
	 * @return List<ScgImdgSegrSymVO>
	 * @exception EventException
	 */
	public List<ScgImdgSegrSymVO> searchPermitMixedList(String imdgSegrTpCd) throws EventException;
    /**
     * [Special Provisions for Segregation (Creation)]을 [저장 Save] 합니다.<br>
     * @param  ScgImdgSpclProvisVO[] scgImdgSpclProvisVO
     * @param  String imdgSpclProviNo
     * @param  String usrId
     * @throws EventException 
     * @author jang kang cheol
     */
    public void manageSpecialProvisionSegregationList(ScgImdgSpclProvisVO[] scgImdgSpclProvisVO,String imdgSpclProviNo,  String usrId ) throws EventException;
 
    /**
	 * Segregation Simulation in a CNTR 의 Segregation Validation 을 조회 합니다. <br>
	 * 
	 * @param segregationSimulationInputVOs
	 * @return List<SegregationSimulationInputVO>
	 * @exception EventException
	 */
	public List<SegregationSimulationOutputVO> checkSegregation(SegregationSimulationInputVO[] segregationSimulationInputVOs) throws EventException;
	
	/**
	 * SpecialCargo - searching information by imdgPckCd and imdgPckTpCd.(VOP_SCG_0110)
	 *	 
	 * @param 	String imdgPckCd
	 * @param 	String imdgPckTpCd
	 * @return  ImdgPckDescVO
	 * @exception EventException
	 */
	public ScgImdgPckCdVO searchImdgPckDesc(String imdgPckCd, String imdgPckTpCd) throws EventException;
	
	/**
	 * IMDG search for SCG_IMDG_UN_NO
	 *	 
	 * @param 	UNNumberListOptionVO vo
	 * @param 	String flag	 
	 * @exception EventException
	 */
	public void sendScgImdgUnNo(UNNumberListOptionVO vo, String flag) throws EventException;
	
	/**
	 * IMDG search for SCG_IMDG_SUBS_RSK_LBL
	 *	 
	 * @param 	List<ScgImdgSubsRskLblVO> vo
	 * @param 	String flag	 
	 * @exception EventException
	 */
	public void sendScgImdgSubRskLbl(List<ScgImdgSubsRskLblVO> vo, String flag) throws EventException;
	
	/**
	 * IMDG search for SCG_IMDG_PCK_CD
	 *	 
	 * @param 	List<ScgImdgPckCdVO> vo
	 * @param 	String flag
	 * @exception EventException
	 */
	public void sendScgImdgPckCd(List<ScgImdgPckCdVO> vo, String flag) throws EventException;	
	
	/**
	 * IMDG search for SCG_IMDG_CLSS_CD
	 *	 
	 * @param 	List<ScgImdgClssCdVO> vo
	 * @param 	String flag
	 * @exception EventException
	 */
	public void sendScgImdgClssCd(List<ScgImdgClssCdVO> vo, String flag) throws EventException;
	
	/**
	 * return ScgPrnrAproRqst Result
	 *	 
	 * @param 	String result
	 * @param 	String ifId
	 * @exception EventException
	 */
	public void sendScgPrnrAproRqstResult (String result, String ifId) throws EventException;
	
}