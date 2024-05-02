/*==========================================================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChassisMgsetInvoiceInvoiceEstimateExpenseBackEndJob.java
*@FileTitle : EES_CGM_1107 Chassis Estimated Expense(Calculation) BackEndJob impl
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.25
*@LastModifier : Chang Young Kim
*@LastVersion : 1.0
* 2015.03.25 Chang Young Kim
* 1.0 Creation
* -----------------------------------------------------------------------------------------
* Change History
==========================================================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration.ChassisMgsetInvoiceDBDAO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSEstimateExpenseINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSEstimateExpenseMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.basic.ChassisMgsetInventoryVariationStatusBackEndJob;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;



/**
 * NIS2010-ChassisMgsetMgt Business Logic Basic Command implementation<br>
 * - NIS2010-ChassisMgsetMgt EES_CGM_1102 Status Change 인벤토리 조회(summary) 관련한 BACKEND에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Chae-Shung Cho
 * @see ChassisMgsetInventoryVariationStatusBackEndJob 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class ChassisMgsetInvoiceInvoiceEstimateExpenseBackEndJob extends BackEndCommandSupport {
	
	private static final long serialVersionUID = -8569053557386320221L;
	
	/**
	 * Backend job을 위한 DAO
	 */
	private ChassisMgsetInvoiceDBDAO dbDao;

	private SignOnUserAccount account = null;

	private CHSEstimateExpenseINVO cHSEstimateExpenseINVO; 
	


	/**
	 * BackEndJob시작전 VO 객체를 세팅한다.  [EES_CGM_1107] <br>
	 *  
	 * @param CHSEstimateExpenseINVO cHSEstimateExpenseINVO 
	 */		
	
	public CHSEstimateExpenseINVO getCHSEstimateExpenseINVO() {
		return cHSEstimateExpenseINVO;
	}
	
	public void setCHSEstimateExpenseINVO(CHSEstimateExpenseINVO cHSEstimateExpenseINVO) {
		this.cHSEstimateExpenseINVO = cHSEstimateExpenseINVO;
	}
	
	public SignOnUserAccount getAccount() {
		return account;
	}

	public void setAccount(SignOnUserAccount account) {
		this.account = account;
	}

	/**
	 * Chassis Estimated Expense [EES_CGM_1107]<br>
	 * 
	 * @return List<CHSInventoryByVariationMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */		
	
	@SuppressWarnings("unchecked")
	public List doStart() throws Exception
	{
		List<CHSEstimateExpenseMGTVO> list = new ArrayList<CHSEstimateExpenseMGTVO>();
		this.dbDao = new ChassisMgsetInvoiceDBDAO();
		
		try {
			list = dbDao.searchCHSEstimateExpenseCalcData(cHSEstimateExpenseINVO);
		}catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(ex.getMessage(),ex);
		}
		return list;
	
	}
}