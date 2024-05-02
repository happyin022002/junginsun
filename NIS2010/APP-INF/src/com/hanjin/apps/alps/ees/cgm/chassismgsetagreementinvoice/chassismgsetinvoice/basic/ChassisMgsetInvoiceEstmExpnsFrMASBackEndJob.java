/*==========================================================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChassisMgsetInvoiceEstmExpnsFrMASBackEndJob.java
*@FileTitle : EES_CGM_1225 NP(ZP) Pool Chassis Estimated Expense Input(Calculation) BackEndJob impl
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.30
*@LastModifier : Chang Young Kim
*@LastVersion : 1.0
* 2015.07.30 Chang Young Kim
* 1.0 Creation
* -----------------------------------------------------------------------------------------
* Change History
==========================================================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration.ChassisMgsetInvoiceDBDAO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.PoolEstmExpenseMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.PoolEstmExpenseINVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;



/**
 * NIS2010-ChassisMgsetMgt Business Logic Basic Command implementation<br>
 * - NIS2010-ChassisMgsetMgt EES_CGM_1225 NP(ZP) Pool Chassis Estimated Expense Input (Calculation) 관련한 BACKEND에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Chang Young Kim
 * @see ChassisMgsetInvoiceEstmExpnsFrMASBackEndJob 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class ChassisMgsetInvoiceEstmExpnsFrMASBackEndJob extends BackEndCommandSupport {
	
	private static final long serialVersionUID = -8569053557386320221L;
	
	/**
	 * Backend job을 위한 DAO
	 */
	private ChassisMgsetInvoiceDBDAO dbDao;

	private SignOnUserAccount account = null;

	private PoolEstmExpenseINVO poolEstmExpenseINVO; 
	


	/**
	 * BackEndJob시작전 VO 객체를 세팅한다.  [EES_CGM_1225] <br>
	 *  
	 * @param PoolEstmExpenseINVO poolEstmExpenseINVO 
	 */		
	
	public PoolEstmExpenseINVO getPoolEstmExpenseINVO() {
		return poolEstmExpenseINVO;
	}
	
	public void setPoolEstmExpenseINVO(PoolEstmExpenseINVO poolEstmExpenseINVO) {
		this.poolEstmExpenseINVO = poolEstmExpenseINVO;
	}
	
	public SignOnUserAccount getAccount() {
		return account;
	}

	public void setAccount(SignOnUserAccount account) {
		this.account = account;
	}

	/**
	 * Chassis Estimated Expense [EES_CGM_1225]<br>
	 * 
	 * @return List<PoolEstmExpenseMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */		
	
	@SuppressWarnings("unchecked")
	public List doStart() throws Exception
	{
		List<PoolEstmExpenseMGTVO> list = new ArrayList<PoolEstmExpenseMGTVO>();
		this.dbDao = new ChassisMgsetInvoiceDBDAO();
		
		try {
			list = dbDao.searchZPPoolEstimateAmtFromMASData(poolEstmExpenseINVO);
		}catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(ex.getMessage(),ex);
		}
		return list;
	
	}
}