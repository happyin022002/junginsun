/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ProformaScheduleMgtBC.java
*@FileTitle : P/F SKD Type Help (Pop-Up) 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.basic;

import java.util.List;

import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdGRPVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdEotpGRPVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdHisGRPVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdRequestVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdTypeHelpVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.VskPfSkdDtlVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.VskPfSkdHisVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdBerthWdoVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.VskPfSkdVO;

/**
 * Scheduleplanningoperation Business Logic Command Interface<br>
 * - business logic interface about Scheduleplanningoperation
 *
 * @author 
 * @see Ui_vsk-0241EventResponse
 * @since J2EE 1.4
 */

public interface ProformaScheduleMgtBC {
	/**
	 * Retrieving registeredProforma Type
	 * 
	 * @param PfSkdTypeHelpVO pfSkdTypeHelpVO
	 * @return List<PfSkdTypeHelpVO>
	 * @exception EventException
	 */
	public List<PfSkdTypeHelpVO> searchPfTpHelp(PfSkdTypeHelpVO pfSkdTypeHelpVO) throws EventException;
	
	/**
	 * Retrieving registeredProforma Type
	 * 
	 * @param String landCd
	 * @param String pfSvcTpCd
	 * @param String vslSvcTpCd
	 * @return List<PfSkdVO>
	 * @exception EventException
	 */
	public List<PfSkdVO> searchPfSkd(String landCd, String pfSvcTpCd, String vslSvcTpCd) throws EventException;
	
	/**
	 * Retrieving registeredProforma Type
	 * 
	 * @param PfSkdVO pfSkdVO
	 * @return List<PfSkdVO>
	 * @exception EventException
	 */
	public List<PfSkdVO> searchPfSkdHAS(PfSkdVO pfSkdVO) throws EventException;
	
	/**
	 * Retrieving registeredProforma Type
	 * 
	 * @param String landCd
	 * @param String pfSvcTpCd
	 * @param String vslSvcTpCd
	 * @param String slanStndFlg
	 * @return List<PfSkdVO>
	 * @exception EventException
	 */
	public List<PfSkdVO> searchPfSkd(String landCd, String pfSvcTpCd, String vslSvcTpCd, String slanStndFlg) throws EventException;
	
	/**
	 * Retrieving registeredProforma Type
	 * 
	 * @param PfSkdVO pfSkdVO
	 * @return List<PfSkdVO>
	 * @exception EventException
	 */
	public List<PfSkdVO> searchPfSkd(PfSkdVO pfSkdVO) throws EventException;
	
	/**
	 * Retrieving registeredProforma Type
	 * 
	 * @param PfSkdVO pfSkdVO
	 * @return List<PfSkdVO>
	 * @exception EventException
	 */
	public List<PfSkdVO> searchPfSkdInclFinalVirPortList(PfSkdVO pfSkdVO) throws EventException;
	
	/**
	 * Retrieving registeredProforma Type
	 * 
	 * @param VskPfSkdHisVO vskPfSkdHisVO
	 * @return PfSkdHisGRPVO
	 * @exception EventException
	 */
	public PfSkdHisGRPVO searchPfSkdHis(VskPfSkdHisVO vskPfSkdHisVO) throws EventException;
	
	/**
	 * Retrieving P/F SKD Settlement
	 * 
	 * @param PfSkdRequestVO pfSkdRequestVO
	 * @return PfSkdGRPVO
	 * @exception EventException
	 */
	public PfSkdGRPVO searchRqstSimScnr(PfSkdRequestVO pfSkdRequestVO) throws EventException;
	
	/**
	 * Retrieving P/F SKD Settlement
	 * 
	 * @param PfSkdGRPVO pfSkdGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void confirmSimScnr(PfSkdGRPVO pfSkdGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Retrieving M/Simulation of P/F SKD Settlement ,Creation
	 * 
	 * @param PfSkdGRPVO pfSkdGRPVO
	 * @return PfSkdGRPVO
	 * @exception EventException
	 */
	public PfSkdGRPVO calPfSkdManual(PfSkdGRPVO pfSkdGRPVO) throws EventException;
	
	/**
	 * Retrieving A/Simulation of P/F SKD Settlement ,Creation
	 * 
	 * @param PfSkdGRPVO pfSkdGRPVO
	 * @return PfSkdGRPVO
	 * @exception EventException
	 */
	public PfSkdGRPVO calPfSkdAuto(PfSkdGRPVO pfSkdGRPVO) throws EventException;
	
	/**
	 * Retrieving Distance of FROM, TO PORT, ZD(ZONE DESCRIPTION), CRANE count, terminal productivity
	 * 
	 * @param List<PfSkdVO> pfSkdVOs
	 * @return List<PfSkdVO>
	 * @exception EventException
	 */
	public List<PfSkdVO> searchPortInfo(List<PfSkdVO> pfSkdVOs) throws EventException;
	
	/**
	 * Deleting PF SKD of P/F SKD Settlement
	 * 
	 * @param VskPfSkdVO vskPfSkdVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removePfSkd(VskPfSkdVO vskPfSkdVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Retrieving P/F Type CD is exist
	 * 
	 * @param VskPfSkdVO vskPfSkdVO
	 * @return String
	 * @exception EventException
	 */
	public String checkPfType(VskPfSkdVO vskPfSkdVO) throws EventException;
	
	/**
	 * Deleting selected row(s) of ProformaScheduleMgt, recombining information of existed ports
	 * 
	 * @param PfSkdGRPVO pfSkdGRPVO
	 * @return List<VskPfSkdDtlVO>
	 * @exception EventException
	 */
	public List<VskPfSkdDtlVO> calRowDelete(PfSkdGRPVO pfSkdGRPVO) throws EventException;
	
	/**
	 * BERTH WINDOW 정보를 조회한다.
	 * 
	 * @param List<VskPfSkdDtlVO> vskPfSkdDtlVOs
	 * @return List<PfSkdBerthWdoVO>
	 * @exception EventException
	 */
	public List<PfSkdBerthWdoVO> searchPfSkdBerthWdo(List<VskPfSkdDtlVO> vskPfSkdDtlVOs) throws EventException;
	
	/**
	 * EOTP Creation 이벤트 처리
	 * 
	 * @param PfSkdGRPVO pfSkdGRPVO
	 * @return PfSkdEotpGRPVO
	 * @exception EventException
	 */
	public PfSkdEotpGRPVO searchPfSkdEotpSum(PfSkdGRPVO pfSkdGRPVO) throws EventException;
	
	/**
	 * EOTP Creation Detail 이벤트 처리
	 * 
	 * @param PfSkdGRPVO pfSkdGRPVO
	 * @return PfSkdEotpGRPVO
	 * @exception EventException
	 */
	public PfSkdEotpGRPVO searchPfSkdEotpDtl(PfSkdGRPVO pfSkdGRPVO) throws EventException;

	
	public List<VskPfSkdDtlVO> getVskPfSkdDtlList();

	public List<PfSkdVO> getPfSkdList();
}