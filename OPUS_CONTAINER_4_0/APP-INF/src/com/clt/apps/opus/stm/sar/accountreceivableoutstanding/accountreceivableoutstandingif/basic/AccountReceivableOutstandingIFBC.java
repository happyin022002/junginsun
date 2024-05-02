/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : AccountReceivableOutstandingIFBC.java
 *@FileTitle : AccountReceivableOutstandingIFBC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.03.03 authorName
 * 1.0 Creation
 * --------------------------------------------------------
 * History
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstandingif.basic;

import java.util.List;

import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablecollectif.vo.SaKuraIFVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * AccountReceivableOutstandingIFBC Business Logic ServiceCommand 
 * - Handling AccountReceivableOutstandingIFBC Business transaction.
 * 
 * @author 
 * @see AccountReceivableOutstandingIFBCImpl
 * @since J2EE 1.6
 */ 
public interface AccountReceivableOutstandingIFBC {
    /**
   	 * Create SAKURA INTERFACEDATA<br> 
   	 * SAR_AR_IF 참조 
   	 * @param String ifNo
   	 * @param String status
   	 */
   	public void createSakuraOTSIFdata(String ifNo,String status);
   	
   	/**
	 * Search Sakura OTS BatchList<br> 
	 * 
	 * @return List<SaKuraIFVO>
	 * @exception EventException
	 */
	public List<SaKuraIFVO> searchSakuraOTSBatchList() throws EventException;
   	
    /**
   	 * Create SAKURA INTERFACEDATA<br> 
   	 * SAR_AR_IF 참조
   	 * @param String kindSakura
   	 * @return String
   	 * @exception EventException
   	 */
    public String createSakuraBatch(String kindSakura) throws EventException;
}
