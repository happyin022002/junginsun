/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : demandnotesendBC.java
*@FileTitle : Demand Note Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.09.18 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNoteByBookingVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNoteGroupListVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNoteListParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNoteListVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNoteParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNotePreviewEtcVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNotePreviewListVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNotePreviewMstVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNotePreviewParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNoteRDParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration.InvoiceIssueCollectionMgtDBDAO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Dmtinvoicemgt Business Logic Command Interface<br>
 * - ALPS-Dmtinvoicemgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Choi Sung Hwan
 * @see InvoiceIssueCollectionMgtDBDAO
 * @since J2EE 1.6
 */

public interface DemandNoteSendBC {

	/**
	 * [Demand Note Issue]을 [조회] 합니다.<br>
	 * 
	 * @param DemandNoteListParmVO demandNoteListParmVO
	 * @param SignOnUserAccount account
	 * @return List<DemandNoteListVO>
	 * @exception EventException
	 */
	public List<DemandNoteListVO> searchDemandChargeList(DemandNoteListParmVO demandNoteListParmVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [Demand Note Issue - Booking]을 [조회] 합니다.<br>
	 * 
	 * @param DemandNoteParmVO demandNoteParmVO
	 * @param SignOnUserAccount account
	 * @return DemandNoteByBookingVO
	 * @exception EventException
	 */
	public DemandNoteByBookingVO searchDemandNoteByBooking(DemandNoteParmVO demandNoteParmVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [Demand Note Issue - Group]을 [조회] 합니다.<br>
	 * 
	 * @param DemandNoteParmVO demandNoteParmVO
	 * @return List<DemandNoteGroupListVO>
	 * @exception EventException
	 */
	public List<DemandNoteGroupListVO> searchDemandNoteByGroup(DemandNoteParmVO demandNoteParmVO) throws EventException;
	
	/**
	 * [Demand Note Issue Preview - Master data] 을 [조회] 합니다.<br>
	 * 
	 * @param DemandNotePreviewParmVO demandNotePreviewParmVO
	 * @return DemandNotePreviewMstVO
	 * @exception EventException
	 */
	public DemandNotePreviewMstVO searchDemandNoteIssueMstPreview(DemandNotePreviewParmVO demandNotePreviewParmVO) throws EventException;
	
	/**
	 * [Demand Note Issue Preview - Etc data] 을 [조회] 합니다.<br>
	 * 
	 * @param DemandNotePreviewParmVO demandNotePreviewParmVO
	 * @return DemandNotePreviewEtcVO
	 * @exception EventException
	 */
	public DemandNotePreviewEtcVO searchDemandNoteIssueEtcPreview(DemandNotePreviewParmVO demandNotePreviewParmVO) throws EventException;
	
	/**
	 * [Demand Note Issue Preview - Detail List] 을 [조회] 합니다.<br>
	 * 
	 * @param DemandNotePreviewParmVO demandNotePreviewParmVO
	 * @return List<DemandNotePreviewListVO>
	 * @exception EventException
	 */
	public List<DemandNotePreviewListVO> searchDemandNoteIssueDtlPreview(DemandNotePreviewParmVO demandNotePreviewParmVO) throws EventException;
	
	/**
	 * [Demand Note Issue Preview - RD REPORT] 을 [조회] 합니다.<br>
	 *
	 * @param DemandNoteRDParmVO[] demandNoteRDParmVOs
	 * @return String
	 * @exception EventException
	 */
	public String searchDemandNoteRD(DemandNoteRDParmVO[] demandNoteRDParmVOs) throws EventException;
}