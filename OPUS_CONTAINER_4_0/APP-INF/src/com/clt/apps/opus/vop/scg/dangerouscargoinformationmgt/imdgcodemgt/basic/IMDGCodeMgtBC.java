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
package com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.basic;

import java.util.List;

import com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.AutoCreationVO;
import com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.ScgImdgClssSegrListVO;
import com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.ScgImdgCompGrpSegrListVO;
import com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.ScgImdgUnNoSegrListVO;
import com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.SegregationSimulationInputVO;
import com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.SegregationSimulationOutputVO;
import com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.SegregationTableGrpVO;
import com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.UNNumberGrpVO;
import com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.UNNumberListOptionVO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgImdgSpclProvisVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.ScgImdgExptQtyVO;
import com.clt.syscommon.common.table.ScgImdgSegrGrpVO;
import com.clt.syscommon.common.table.ScgImdgSegrSymVO;

/**
 * OPUS-Dangerouscargoinformationmgt Business Logic Command Interface<br>
 * - OPUS-Dangerouscargoinformationmgt에 대한 비지니스 로직에 대한 인터페이스<br>
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
}