/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CanalTransitFeeInvoiceBCImpl.java
 *@FileTitle : CanalTransitFeeInvoiceBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.10.04
 *@LastModifier : 유혁
 *@LastVersion : 1.0
 * 2009.06.08 박명종
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.basic;

import java.util.List;

import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.integration.CanalTransitFeeInvoiceDBDAO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.vo.CanalTzFeeInvDtlCondVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.vo.CanalTzFeeInvDtlVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-EstimateInvoiceAudit Business Logic Basic Command implementation<br>
 *
 * @author 
 * @see Reference each DAO class of VOP_PSO-0019EventResponse,CanalTransitFeeInvoiceBC
 * @since J2EE 1.6
 */
public class CanalTransitFeeInvoiceBCImpl extends BasicCommandSupport implements CanalTransitFeeInvoiceBC {

	// Database Access Object
	private transient CanalTransitFeeInvoiceDBDAO dbDao = null;

	/**
	 * Creating object CanalTransitFeeInvoiceBCImpl <br>
	 * Creating CanalTransitFeeInvoiceDBDAO<br>
	 */
	public CanalTransitFeeInvoiceBCImpl() {
		dbDao = new CanalTransitFeeInvoiceDBDAO();
	}
	/**
	 *Retrieve Actual Invoice requested by SPP : Retrieve Requested Actual Invoice WindowOpen event 
	 * @category VOP_PSO_0019_windowOpen
	 * @param CanalTzFeeInvDtlCondVO canalTzFeeInvDtlCondVO
	 * @return List<CanalTzFeeInvDtlVO>
	 */
	public List<CanalTzFeeInvDtlVO> searchCanalTzFeeInvByVvd(
			CanalTzFeeInvDtlCondVO canalTzFeeInvDtlCondVO)  throws EventException{
		// TODO Auto-generated method stub
		try {
			return dbDao.searchCanalTzFeeInvByVvd(canalTzFeeInvDtlCondVO); 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Requested Actual Invoice"}).getUserMessage(),ex);
		} 
		catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Requested Actual Invoice"}).getUserMessage(),ex);
		}
	}
}