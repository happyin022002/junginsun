/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : AccountReceivableOutstandingMigrationBC.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier :
 *@LastVersion : 1.0
 * 2015.11.26 authorName
 * 1.0 Creation
 * --------------------------------------------------------
 * History
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.basic;

import java.util.List;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.InvArIfNoVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.vo.AROutstandingChgVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.vo.AROutstandingHistVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * AccountReceivableOutstandingMigrationBC Business Logic ServiceCommand - Handling
 * AccountReceivableOutstandingMigrationBC Business transaction.
 * 
 * @author
 * @see AccountReceivableOutstandingMigrationBCImpl
 * @since J2EE 1.6
 */
public interface AccountReceivableOutstandingMigrationBC {
 
	/**
	 * Create AR Information to Outstanding<br>
	 * 
	 * @param List<InvArIfNoVO> ifNos
	 * @exception EventException
	 */
	public void createOutstandingInfo(List<InvArIfNoVO> ifNos) throws EventException;

	/**
	 * Create Outstanding Account distribution Info<br>
	 * 
	 * @param List<AROutstandingHistVO> arOutstandingHistVOs
	 * @param List<AROutstandingChgVO> arOutstandingChgVOs
	 * @exception EventException
	 */
	public void createOutstandingAccount(List<AROutstandingHistVO> arOutstandingHistVOs, List<AROutstandingChgVO> arOutstandingChgVOs) throws EventException;

}
