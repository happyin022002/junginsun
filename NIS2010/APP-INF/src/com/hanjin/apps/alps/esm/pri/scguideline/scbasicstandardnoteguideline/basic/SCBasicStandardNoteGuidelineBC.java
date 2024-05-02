/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCBasicStandardNoteGuidelineBC.java
*@FileTitle : Standard Note Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.17
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.04.17 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scguideline.scbasicstandardnoteguideline.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.scguideline.scbasicstandardnoteguideline.vo.RsltPriSgStndNoteCtntVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scbasicstandardnoteguideline.vo.RsltPriSgStndNoteHdrCopyVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scbasicstandardnoteguideline.vo.StndNoteGlineVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSgStndNoteHdrVO;
import com.hanjin.syscommon.common.table.PriSgStndNoteVO;

/**
 * NIS2010-Scguideline Business Logic Command Interface<br>
 * - NIS2010-Scguideline에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Seung Jun Lee
 * @see Ui_pri_0005EventResponse 참조
 * @since J2EE 1.4
 */

public interface SCBasicStandardNoteGuidelineBC {
	
	
	/**
	 * StndNote 헤더 정보를 조회한다.<br>
	 * 
	 * @param PriSgStndNoteHdrVO priSgStndNoteHdrVO
	 * @return StndNoteGlineVO
	 * @exception EventException
	 */
	public StndNoteGlineVO searchBasicStandardNoteGuidelineHdrList(PriSgStndNoteHdrVO priSgStndNoteHdrVO) throws EventException;
	
	/**
	 * StndNote Duration을 조회한다.<br>
	 * 
	 * @param PriSgStndNoteHdrVO priSgStndNoteHdrVO
	 * @return StndNoteGlineVO
	 * @exception EventException
	 */
	public StndNoteGlineVO searchBasicStandardNoteGuidelineHdrDurationList(PriSgStndNoteHdrVO priSgStndNoteHdrVO)throws EventException;
	
	/**
	 * StndNote 메인, 타이틀 바디 정보를 조회한다.<br>
	 * 
	 * @param PriSgStndNoteVO priSgStndNoteHdrVO
	 * @param String searchGubun
	 * @return StndNoteGlineVO
	 * @exception EventException
	 */
	public StndNoteGlineVO searchBasicStandardNoteGuidelineList(PriSgStndNoteVO priSgStndNoteHdrVO, String searchGubun) throws EventException;
	
	/**
	 * StndNote 메인, 타이틀 바디 정보를 다운로드한다.<br>
	 * 
	 * @param RsltPriSgStndNoteCtntVO rsltPriSgStndNoteCtntVO
	 * @return List<RsltPriSgStndNoteCtntVO>
	 * @exception EventException
	 */
	public List<RsltPriSgStndNoteCtntVO> searchBasicStandardNoteGuidelineExcelList(RsltPriSgStndNoteCtntVO rsltPriSgStndNoteCtntVO) throws EventException;
	
	
	/**
	 * StndNote 정보를 저장한다.<br>
	 * 
	 * @param StndNoteGlineVO stndNoteGlineVO
	 * @param SignOnUserAccount account
	 * @return PriSgStndNoteVO 
	 * @exception EventException
	 */
	public PriSgStndNoteVO manageBasicStandardNoteGuideline(StndNoteGlineVO stndNoteGlineVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * 사용자가 노트를 컨폼한다<br>
	 * 
	 * @param PriSgStndNoteHdrVO priSgStndNoteHdrVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void confirmBasicStandardNoteGuideline(PriSgStndNoteHdrVO priSgStndNoteHdrVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 사용자가 노트를 컨폼 cancel한다<br>
	 * 
	 * @param PriSgStndNoteHdrVO priSgStndNoteHdrVO
	 * @param SignOnUserAccount account 
	 * @exception EventException
	 */
	public void cancelBasicStandardNoteGuideline(PriSgStndNoteHdrVO priSgStndNoteHdrVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * 노트 전체를 삭제한다<br>
	 * 
	 * @param PriSgStndNoteHdrVO priSgStndNoteHdrVO
	 * @exception EventException
	 */
	public void removeBasicStandardNoteGuideline(PriSgStndNoteHdrVO priSgStndNoteHdrVO) throws EventException;
	
	/**
	 * 노트 전체를 복사한다<br>
	 * 
	 * @param RsltPriSgStndNoteHdrCopyVO rsltPriSgStndNoteHdrCopyVO
	 * @param SignOnUserAccount account
	 * @return PriSgStndNoteVO
	 * @exception EventException
	 */
	public PriSgStndNoteVO copyBasicStandardNoteGuideline(RsltPriSgStndNoteHdrCopyVO rsltPriSgStndNoteHdrCopyVO, SignOnUserAccount account) throws EventException;
	
	
}