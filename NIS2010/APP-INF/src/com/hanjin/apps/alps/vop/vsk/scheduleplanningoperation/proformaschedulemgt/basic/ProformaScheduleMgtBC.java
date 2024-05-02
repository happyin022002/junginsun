/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ProformaScheduleMgtBC.java
*@FileTitle : P/F SKD Type Help (Pop-Up) 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.04.30 서창열
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.basic;

import java.util.List;

import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdBerthWdoVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdEotpGRPVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdGRPVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdHisGRPVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdRequestVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdTypeHelpVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.SlotPriceGRPVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.VskPfSkdDtlVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.VskPfSkdHisVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MasSimInfoVO;
import com.hanjin.syscommon.common.table.VskPfSkdVO;

/**
 * NIS2010-Scheduleplanningoperation Business Logic Command Interface<br>
 * - NIS2010-Scheduleplanningoperation에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SEO CHANG YUL
 * @see Ui_vsk-0241EventResponse 참조
 * @since J2EE 1.4
 */

public interface ProformaScheduleMgtBC {
	/**
	 * Proforma Type 정보를 조회합니다.
	 * 
	 * @param PfSkdTypeHelpVO pfSkdTypeHelpVO
	 * @return List<PfSkdTypeHelpVO>
	 * @exception EventException
	 */
	public List<PfSkdTypeHelpVO> searchPfTpHelp(PfSkdTypeHelpVO pfSkdTypeHelpVO) throws EventException;
	
	/**
	 * 등록된 Proforma SKD 정보를 조회한다.
	 * 
	 * @param String landCd
	 * @param String pfSvcTpCd
	 * @param String vslSvcTpCd
	 * @return List<PfSkdVO>
	 * @exception EventException
	 */
	public List<PfSkdVO> searchPfSkd(String landCd, String pfSvcTpCd, String vslSvcTpCd) throws EventException;

	/**
	 * 등록된 Proforma SKD 정보를 조회한다.
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
	 * 등록된 Proforma SKD 정보를 조회한다.
	 * 
	 * @param PfSkdVO pfSkdVO
	 * @return List<PfSkdVO>
	 * @exception EventException
	 */
	public List<PfSkdVO> searchPfSkd(PfSkdVO pfSkdVO) throws EventException;
	
	/**
	 * 등록된 Proforma SKD 정보를 조회한다.
	 * 
	 * @param VskPfSkdHisVO vskPfSkdHisVO
	 * @return PfSkdHisGRPVO
	 * @exception EventException
	 */
	public PfSkdHisGRPVO searchPfSkdHis(VskPfSkdHisVO vskPfSkdHisVO) throws EventException;
	
	/**
	 * BERTH WINDOW 정보를 조회한다.
	 * 
	 * @param List<VskPfSkdDtlVO> vskPfSkdDtlVOs
	 * @return List<PfSkdBerthWdoVO>
	 * @exception EventException
	 */
	public List<PfSkdBerthWdoVO> searchPfSkdBerthWdo(List<VskPfSkdDtlVO> vskPfSkdDtlVOs) throws EventException;
	
	/**
	 * P/F SKD Settlement 정보를 조회한다.
	 * 
	 * @param PfSkdRequestVO pfSkdRequestVO
	 * @return PfSkdGRPVO
	 * @exception EventException
	 */
	public PfSkdGRPVO searchRqstSimScnr(PfSkdRequestVO pfSkdRequestVO) throws EventException;
	
	/**
	 * P/F SKD Settlement 정보를 저장한다
	 * 
	 * @param PfSkdGRPVO pfSkdGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void confirmSimScnr(PfSkdGRPVO pfSkdGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * P/F SKD M/Simultion 이벤트 처리
	 * 
	 * @param PfSkdGRPVO pfSkdGRPVO
	 * @return PfSkdGRPVO
	 * @exception EventException
	 */
	public PfSkdGRPVO calPfSkdManual(PfSkdGRPVO pfSkdGRPVO) throws EventException;
	
	/**
	 * P/F SKD Creation 이벤트 처리
	 * 
	 * @param PfSkdGRPVO pfSkdGRPVO
	 * @return PfSkdGRPVO
	 * @exception EventException
	 */
	public PfSkdGRPVO calPfSkdAuto(PfSkdGRPVO pfSkdGRPVO) throws EventException;
	
	/**
	 * Slot Price 이벤트 처리
	 * 
	 * @param SlotPriceGRPVO slotPriceGRPVO
	 * @return SlotPriceGRPVO
	 * @exception EventException
	 */
	public SlotPriceGRPVO searchSlotPrice(SlotPriceGRPVO slotPriceGRPVO) throws EventException;
	
	/**
	 * Slot Price 이벤트 처리
	 * 
	 * @param SlotPriceGRPVO slotPriceGRPVO
	 * @return SlotPriceGRPVO
	 * @exception EventException
	 */
	public SlotPriceGRPVO calSlotPrice(SlotPriceGRPVO slotPriceGRPVO) throws EventException;
	
	/**
	 * Slot Price 정보를 저장한다
	 * 
	 * @param SlotPriceGRPVO slotPriceGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSlotPrice(SlotPriceGRPVO slotPriceGRPVO, SignOnUserAccount account) throws EventException;
	
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
	
	/**
	 * FROM, TO PORT간에 DISTANCE, ZD(ZONE DESCRIPTION), CRANE 수, 터미널 생산성 정보를 조회한다.
	 * 
	 * @param List<PfSkdVO> pfSkdVOs
	 * @return List<PfSkdVO>
	 * @exception EventException
	 */
	public List<PfSkdVO> searchPortInfo(List<PfSkdVO> pfSkdVOs) throws EventException;
	
	/**
	 * P/F SKD Settlement의 PF_SKD을 삭제한다.
	 * 
	 * @param VskPfSkdVO vskPfSkdVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removePfSkd(VskPfSkdVO vskPfSkdVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * P/F Type Cd가 존재하는지 여부를 조회한다
	 * 
	 * @param VskPfSkdVO vskPfSkdVO
	 * @return String
	 * @exception EventException
	 */
	public String checkPfType(VskPfSkdVO vskPfSkdVO) throws EventException;
	
	/**
	 * 선택한 로우(들)을 삭제하고 존재하는 포트에 대한 정보를 재 조합한다.
	 * 
	 * @param PfSkdGRPVO pfSkdGRPVO
	 * @return List<VskPfSkdDtlVO>
	 * @exception EventException
	 */
	public List<VskPfSkdDtlVO> calRowDelete(PfSkdGRPVO pfSkdGRPVO) throws EventException;
	
	
	/**
	 * VSK 모듈에서 데이터를 받아서 Sim 테이블에 저장한다.
	 * 
	 * @param vo PfSkdGRPVO
	 * @param ind Strig [I:신규,U:수정]  
	 * @param account
     * @return List<CoaSimInfoVO>
	 * @throws EventException
	 */
    public List<MasSimInfoVO> createCoaSimRqst(PfSkdGRPVO vo, String ind, SignOnUserAccount account) throws EventException;
	
}