/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : demandnotesendBC.java
*@FileTitle : Demand Note Issue
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.basic;

import java.util.List;

import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNoteByBookingVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNoteGroupListVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNoteListParmVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNoteListVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNoteParmVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNotePreviewEtcVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNotePreviewListVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNotePreviewMstVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNotePreviewParmVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNoteRDParmVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration.InvoiceIssueCollectionMgtDBDAO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * Dmtinvoicemgt Business Logic Command Interface<br>
 *
 * @author
 * @see InvoiceIssueCollectionMgtDBDAO
 * @since J2EE 1.6
 */

public interface DemandNoteSendBC {

	/**
	 * Search Demand Note for Issue.<br>
	 * 
	 * @param DemandNoteListParmVO demandNoteListParmVO
	 * @param SignOnUserAccount account
	 * @return List<DemandNoteListVO>
	 * @exception EventException
	 */
	public List<DemandNoteListVO> searchDemandChargeList(DemandNoteListParmVO demandNoteListParmVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Search Demand Note Issue by Booking.<br>
	 * 
	 * @param DemandNoteParmVO demandNoteParmVO
	 * @param SignOnUserAccount account
	 * @return DemandNoteByBookingVO
	 * @exception EventException
	 */
	public DemandNoteByBookingVO searchDemandNoteByBooking(DemandNoteParmVO demandNoteParmVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Search Demand Note Issue by Group <br>
	 * 
	 * @param DemandNoteParmVO demandNoteParmVO
	 * @return List<DemandNoteGroupListVO>
	 * @exception EventException
	 */
	public List<DemandNoteGroupListVO> searchDemandNoteByGroup(DemandNoteParmVO demandNoteParmVO) throws EventException;
	
	/**
	 *  Search Master data Demand Note Issue Preview <br>
	 * 
	 * @param DemandNotePreviewParmVO demandNotePreviewParmVO
	 * @return DemandNotePreviewMstVO
	 * @exception EventException
	 */
	public DemandNotePreviewMstVO searchDemandNoteIssueMstPreview(DemandNotePreviewParmVO demandNotePreviewParmVO) throws EventException;
	
	/**
	 * Search Etc data Demand Note Issue Preview <br>
	 * 
	 * @param DemandNotePreviewParmVO demandNotePreviewParmVO
	 * @return DemandNotePreviewEtcVO
	 * @exception EventException
	 */
	public DemandNotePreviewEtcVO searchDemandNoteIssueEtcPreview(DemandNotePreviewParmVO demandNotePreviewParmVO) throws EventException;
	
	/**
	 * Search Detail List Demand Note Issue Preview <br>
	 * 
	 * @param DemandNotePreviewParmVO demandNotePreviewParmVO
	 * @return List<DemandNotePreviewListVO>
	 * @exception EventException
	 */
	public List<DemandNotePreviewListVO> searchDemandNoteIssueDtlPreview(DemandNotePreviewParmVO demandNotePreviewParmVO) throws EventException;
	
	/**
	 *  Search RD REPORT Demand Note Issue Preview <br>
	 *
	 * @param DemandNoteRDParmVO[] demandNoteRDParmVOs
	 * @return String
	 * @exception EventException
	 */
	public String searchDemandNoteRD(DemandNoteRDParmVO[] demandNoteRDParmVOs) throws EventException;
}
