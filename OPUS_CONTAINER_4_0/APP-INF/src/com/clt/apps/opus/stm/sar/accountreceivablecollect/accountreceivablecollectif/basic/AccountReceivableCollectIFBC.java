/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : AccountReceivableCollectIFBC.java
 *@FileTitle : AccountReceivableCollectIFBC
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
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablecollectif.basic;

import java.util.List;

import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablecollectif.vo.SaKuraIFVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
	
/**
 * AccountReceivableCollectIFBC Business Logic BusinessCommand 
 * - Handling AccountReceivableCollectIFBC Business transaction.
 * 
 * @author 
 * @see AccountReceivableCollectIFBCImpl
 * @since J2EE 1.6
 */ 
public interface AccountReceivableCollectIFBC {
	/**
   	 * Create SAKURA INTERFACEDATA<br> 
   	 * SAR_AR_IF 참조
   	 * @param String rctNo
   	 * @param String Status
   	 * @exception EventException
   	 */
   	public void createReceiptSakuraIFdata(String rctNo,String Status);
   	
    /**
   	 * Create SAKURA INTERFACEDATA<br> 
   	 * SAR_AR_IF 참조
   	 * @param String arOffstNo
   	 * @param String Status
   	 * @exception EventException
   	 */
   	public void createOffsetSakuraIFdata(String arOffstNo,String Status);
   	
   	/**
   	 * Create SAKURA INTERFACEDATA<br> 
   	 * SAR_AR_IF 참조
   	 * @param String adjNo
   	 * @param String Status
   	 * @exception EventException
   	 */
   	public void createAdjustSakuraIFdata(String adjNo,String Status);
   	
   	/**
   	 * Create SAKURA INTERFACEDATA<br> 
   	 * SAR_AR_IF 참조
   	 * @param String asaNo
   	 * @param String Status
   	 * @exception EventException
   	 */
   	public void createASASakuraIFdata(String asaNo,String Status);
   	
   	/**
	 * Search Sakura REC BatchList<br> 
	 * 
	 * @return List<SaKuraIFVO>
	 * @exception EventException
	 */
	public List<SaKuraIFVO> searchSakuraRECBatchList() throws EventException;
	
	/**
	 * Search Sakura OFF BatchList<br> 
	 * 
	 * @return List<SaKuraIFVO>
	 * @exception EventException
	 */
	public List<SaKuraIFVO> searchSakuraOFFBatchList() throws EventException;
	
	/**
	 * Search Sakura OFF BatchList<br> 
	 * 
	 * @return List<SaKuraIFVO>
	 * @exception EventException
	 */
	public List<SaKuraIFVO> searchSakuraADJBatchList() throws EventException;
	
	/**
	 * Search Sakura ASA BatchList<br> 
	 * 
	 * @return List<SaKuraIFVO>
	 * @exception EventException
	 */
	public List<SaKuraIFVO> searchSakuraASABatchList() throws EventException;
	
	/**
	 * Update Sakura Error Reason, Flag

	 * @param List<SaKuraIFVO> sarIFVOs
	 * @exception EventException
	 */
	public void modifySakuraIFErrRsn(List<SaKuraIFVO> sarIFVOs) throws EventException;	
	
	/**
	 * insert sakura interface data
	 * 
	 * @param List<SaKuraIFVO> sarIFVOs
	 * @exception EventException
	 */
	public void addSarIFData(List<SaKuraIFVO> sarIFVOs) throws EventException;	
	
	/**
	 * Update Holding Status<br>
	 * 
	 * @param String ifSeqNo
	 * @throws EventException
	 */
	public void modifyHoldingStatus(String ifSeqNo) throws EventException;		
	
	/**
	 * Update Holding Status<br>
	 * 
	 * @param String ifSeqNo
	 * @throws EventException
	 */
	public void modifyReCheckHoldingStatus(String ifSeqNo) throws EventException;	
}
