/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeOfficeTransferMgtBC.java
*@FileTitle : Office Transfer History
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargeofficetransfermgt.basic;

import java.util.List;

import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationContainerVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.DmtResultVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeofficetransfermgt.vo.DmtOfcTrnsHisVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeofficetransfermgt.vo.OfficeTransferHistoryByContainerVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeofficetransfermgt.vo.OfficeTransferParmVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-Dmtclosing Business Logic Command Interface<br>
 * @author
 * @see reference DAO of  EES_DMT_3001EventResponse,ChargeOfficeTransferMgtBC
 * @since J2EE 1.6
 */

public interface ChargeOfficeTransferMgtBC {

	/**
	 * search Office Transfer by Office and date
	 * 
	 * @param OfficeTransferParmVO officeTransferParmVO
	 * @return List<DmtOfcTrnsHisVO>
	 * @exception EventException
	 */
	public List<DmtOfcTrnsHisVO> searchOfficeTransferHistoryList(OfficeTransferParmVO officeTransferParmVO) throws EventException;

	
	/**
	 * modify Office  Charge Data for Office Transfer.
	 * Charge for Office Transfer 's  Status is  "F"(Finish) or "L"(Long Staying) 
	 * 
	 * @param OfficeTransferParmVO[] officeTransferParmVOs 
	 * @param SignOnUserAccount account
	 * @return String[]
	 * @exception EventException
	 */
	public String[] createOfficeTransferCharge(OfficeTransferParmVO[] officeTransferParmVOs, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * search Office Transfer History info. by Container.
	 * 
	 * @param OfficeTransferParmVO officeTransferParmVO
	 * @return List<OfficeTransferHistoryByContainerVO>
	 * @exception EventException
	 */
	public List<OfficeTransferHistoryByContainerVO> searchOfficeTransferHistoryListByContainer(OfficeTransferParmVO officeTransferParmVO) 
		throws EventException;
	
	
	/**
	 * case in Office Transfered Charge is Partial,Office Transfer Flag of new created Charge to be "Y" ,
	 * also  create Office Transfer History.
	 * 
	 * @param	ChargeCalculationContainerVO[] chargeCalculationContainerVOs
	 * @param	SignOnUserAccount account
	 * @return	DmtResultVO
	 * @exception EventException
	 */
	public DmtResultVO createOfficeTransferHistoryByPartialPayment(ChargeCalculationContainerVO[] chargeCalculationContainerVOs, SignOnUserAccount account)
		throws EventException;

}