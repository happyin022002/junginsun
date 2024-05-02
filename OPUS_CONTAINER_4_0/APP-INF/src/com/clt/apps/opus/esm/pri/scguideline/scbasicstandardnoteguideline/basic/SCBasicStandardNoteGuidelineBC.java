/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCBasicStandardNoteGuidelineBC.java
*@FileTitle : Standard Note Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.scbasicstandardnoteguideline.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.scguideline.scbasicstandardnoteguideline.vo.RsltPriSgStndNoteCtntVO;
import com.clt.apps.opus.esm.pri.scguideline.scbasicstandardnoteguideline.vo.RsltPriSgStndNoteHdrCopyVO;
import com.clt.apps.opus.esm.pri.scguideline.scbasicstandardnoteguideline.vo.StndNoteGlineVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSgStndNoteHdrVO;
import com.clt.syscommon.common.table.PriSgStndNoteVO;

/**
 * Scguideline Business Logic Command Interface<br>
 * - interface about Scguideline biz logic<br>
 *
 * @author 
 * @see Ui_pri_0005EventResponse 
 * @since J2EE 1.4
 */

public interface SCBasicStandardNoteGuidelineBC {
	
	
	/**
	 * Retrieving StndNote header information <br>
	 * 
	 * @param PriSgStndNoteHdrVO priSgStndNoteHdrVO
	 * @return StndNoteGlineVO
	 * @exception EventException
	 */
	public StndNoteGlineVO searchBasicStandardNoteGuidelineHdrList(PriSgStndNoteHdrVO priSgStndNoteHdrVO) throws EventException;
	
	/**
	 * Retrieving StndNote Duration<br>
	 * 
	 * @param PriSgStndNoteHdrVO priSgStndNoteHdrVO
	 * @return StndNoteGlineVO
	 * @exception EventException
	 */
	public StndNoteGlineVO searchBasicStandardNoteGuidelineHdrDurationList(PriSgStndNoteHdrVO priSgStndNoteHdrVO)throws EventException;
	
	/**
	 * Retrieving StndNote main, title and body information <br>
	 * 
	 * @param PriSgStndNoteVO priSgStndNoteHdrVO
	 * @param String searchGubun
	 * @return StndNoteGlineVO
	 * @exception EventException
	 */
	public StndNoteGlineVO searchBasicStandardNoteGuidelineList(PriSgStndNoteVO priSgStndNoteHdrVO, String searchGubun) throws EventException;
	
	/**
	 * Retrieving StndNote main, title and body information <br>
	 * 
	 * @param RsltPriSgStndNoteCtntVO rsltPriSgStndNoteCtntVO
	 * @return List<RsltPriSgStndNoteCtntVO>
	 * @exception EventException
	 */
	public List<RsltPriSgStndNoteCtntVO> searchBasicStandardNoteGuidelineExcelList(RsltPriSgStndNoteCtntVO rsltPriSgStndNoteCtntVO) throws EventException;
	
	
	/**
	 * Saving StndNote information<br>
	 * 
	 * @param StndNoteGlineVO stndNoteGlineVO
	 * @param SignOnUserAccount account
	 * @return PriSgStndNoteVO 
	 * @exception EventException
	 */
	public PriSgStndNoteVO manageBasicStandardNoteGuideline(StndNoteGlineVO stndNoteGlineVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * Confirming Note <br>
	 * 
	 * @param PriSgStndNoteHdrVO priSgStndNoteHdrVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void confirmBasicStandardNoteGuideline(PriSgStndNoteHdrVO priSgStndNoteHdrVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Cancel Confirming Note <br>
	 * 
	 * @param PriSgStndNoteHdrVO priSgStndNoteHdrVO
	 * @param SignOnUserAccount account 
	 * @exception EventException
	 */
	public void cancelBasicStandardNoteGuideline(PriSgStndNoteHdrVO priSgStndNoteHdrVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * Deleting all Notes <br>
	 * 
	 * @param PriSgStndNoteHdrVO priSgStndNoteHdrVO
	 * @exception EventException
	 */
	public void removeBasicStandardNoteGuideline(PriSgStndNoteHdrVO priSgStndNoteHdrVO) throws EventException;
	
	/**
	 * Copying all Notes <br>
	 * 
	 * @param RsltPriSgStndNoteHdrCopyVO rsltPriSgStndNoteHdrCopyVO
	 * @param SignOnUserAccount account
	 * @return PriSgStndNoteVO
	 * @exception EventException
	 */
	public PriSgStndNoteVO copyBasicStandardNoteGuideline(RsltPriSgStndNoteHdrCopyVO rsltPriSgStndNoteHdrCopyVO, SignOnUserAccount account) throws EventException;
	
	
}