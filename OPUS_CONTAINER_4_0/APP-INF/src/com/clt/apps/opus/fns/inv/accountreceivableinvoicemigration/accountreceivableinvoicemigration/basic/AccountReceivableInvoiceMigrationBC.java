/*=========================================================
 * Copyright(c) 2009 CyberLogitec
 * @FileName : AccountReceivableInvoiceMigrationBC.java
 * @FileTitle : Migration Interface
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2015.11.26
 * @LastModifier : 박성용
 * @LastVersion : 1.0
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.basic;

import java.util.List;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.ARBkgInterfaceCreationVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.ARInterfaceCreationVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.InvArIfChgVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.InvArIfMnVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.InvArIfNoVO;
import com.clt.framework.core.layer.event.EventException;
 
/**
 * - OPUS-Accountreceivableinvoicemigration Business Logic Command Interface<br>
 * - OPUS-Accountreceivableinvoicemigration에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author sung yong park
 * @see Fns_inv_9001EventResponse 참조
 * @since J2EE 1.4
 */
 
public interface AccountReceivableInvoiceMigrationBC {
	 
	/**
	 * BKG Migration Interface<br>
	 * 
	 * @param String fmCtrtOfcCd
	 * @param String toCtrtOfcCd
	 * @param String bkgNo
	 * @return String
	 * @exception EventException
	 */
	public String executeBookingMigration(String fmCtrtOfcCd, String toCtrtOfcCd, String bkgNo ) throws EventException;
	
	/**
	 * Other Migration Interface<br>
	 * 
	 * @param String ofcCd
	 * @param String fmSrcIfSeq
	 * @param String toSrcIfSeq
	 * @return String
	 * @exception EventException
	 */
	public String executeOtherMigration(String ofcCd, String fmSrcIfSeq, String toSrcIfSeq ) throws EventException;
	
	/**
	 * VVD Ex. Rate Creation<br>
	 * 
	 * @param String arOfcCd
	 * @param String vvdCd
	 * @return String
	 * @exception EventException
	 */
	public String createVVDExchangeRate(String arOfcCd, String vvdCd) throws EventException;
	
	/**
	 * Daily USD Ex. Rate Creation<br>
	 * 
	 * @param String arOfcCd
	 * @return String
	 * @exception EventException
	 */
	public String createDailyUSDExchangeRate(String arOfcCd) throws EventException;
	
	/**
	 * Interface from booking migration<br>
	 * 
	 * @param ARBkgInterfaceCreationVO bkgIfVo
	 * @return List<InvArIfNoVO>
	 * @exception EventException
	 */
	public List<InvArIfNoVO> executeInterfaceBKGARInvoiceToINV(ARBkgInterfaceCreationVO bkgIfVo) throws EventException;
	
	/**
	 * Interface from other migration<br>
	 * 
	 * @param ARInterfaceCreationVO genIfVo
	 * @return String
	 * @exception EventException
	 */
	public String interfaceGeneralARInvoiceToINV(ARInterfaceCreationVO genIfVo) throws EventException;
	
	/**
	 * Create VVD Ex. Rate<br>
	 * 
	 * @param String arOfcCd
	 * @param String vvdCd
	 * @exception EventException
	 */
	public void createVVDExRate(String arOfcCd, String vvdCd) throws EventException;
	
	/**
	 * Create Daily USD Ex. Rate<br>
	 * 
	 * @param String arOfcCd
	 * @exception EventException
	 */
	public void createDailyUSDExRate(String arOfcCd) throws EventException;
	
	/**
	 * Search BKG Migration List<br>
	 * 
	 * @param String fmBkgOfcCd
	 * @param String toBkgOfcCd
	 * @param String bkgNo
	 * @return List<ARBkgInterfaceCreationVO>
	 * @exception EventException
	 */
	public List<ARBkgInterfaceCreationVO> searchBKGMigrationList(String fmBkgOfcCd, String toBkgOfcCd, String bkgNo) throws EventException;
	
	/**
	 * Search Other Migration Main List<br>
	 * 
	 * @param String ofcCd
	 * @param String fmSrcIfSeq
	 * @param String toSrcIfSeq
	 * @return List<InvArIfMnVO>
	 * @exception EventException
	 */
	public List<InvArIfMnVO> searchInvArIfMain(String ofcCd, String fmSrcIfSeq, String toSrcIfSeq) throws EventException;
	
	/**
	 * Search Other Migration Charge List<br>
	 * 
	 * @param String srcIfDt
	 * @param String srcIfSeq
	 * @return List<InvArIfChgVO>
	 * @exception EventException
	 */
	public List<InvArIfChgVO> searchInvArIfChg(String srcIfDt, String srcIfSeq) throws EventException;
	
}
