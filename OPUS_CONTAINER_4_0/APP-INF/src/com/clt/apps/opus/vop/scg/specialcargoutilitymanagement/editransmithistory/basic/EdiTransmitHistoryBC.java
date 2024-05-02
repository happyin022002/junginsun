/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EdiTransmitHistoryBC.java
*@FileTitle : DG EDI Transmit History
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.editransmithistory.basic;

import java.util.List;

import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.editransmithistory.vo.EdiTransmitHistoryHdrVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.editransmithistory.vo.ImdgItemBkgSummaryVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * EDI HISTORY 조회<br>
 *
 * @author 
 * @see Reference VOP_SCG_5011EventResponse
 * @since J2EE 1.6
 */

public interface EdiTransmitHistoryBC {

	/**
	 * Retrieve searchEdiTransmitHistoryHdr .<br>
	 * 
	 * @param EdiTransmitHistoryHdrVO VO
	 * @return List<EdiTransmitHistoryHdrVO>
	 * @exception EventException
	 */
	public List<EdiTransmitHistoryHdrVO> searchEdiTransmitHistoryHdr(EdiTransmitHistoryHdrVO vo) throws EventException;
	
	/**
	 * Retrieve searchEdiTransmitHistoryDtl .<br>
	 * 
	 * @param EdiTransmitHistoryHdrVO VO
	 * @return List<EdiTransmitHistoryHdrVO>
	 * @exception EventException
	 */
	public List<EdiTransmitHistoryHdrVO> searchEdiTransmitHistoryDtl(EdiTransmitHistoryHdrVO vo) throws EventException;
	
	/**
	 * Retrieve searchImdgItemBkgSummary .<br>
	 * 
	 * @param ImdgItemBkgSummaryVO VO
	 * @return List<ImdgItemBkgSummaryVO>
	 * @exception EventException
	 */
	public List<ImdgItemBkgSummaryVO> searchImdgItemBkgSummary(ImdgItemBkgSummaryVO vo) throws EventException;
	
	/**
	 * Retrieve searchEdiTransmitFlatFile .<br>
	 * 
	 * @param EdiTransmitHistoryHdrVO VO
	 * @return List<EdiTransmitHistoryHdrVO>
	 * @exception EventException
	 */
	public List<EdiTransmitHistoryHdrVO> searchEdiTransmitFlatFile(EdiTransmitHistoryHdrVO vo) throws EventException;

}