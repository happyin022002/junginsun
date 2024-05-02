/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCBoilerPlateProposalBC.java
*@FileTitle : Bolier Plate Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.05.28 공백진
* 1.0 Creation
* 
* 2012.02.23 이석준[CHM-201216153-01] S/C Amendment History 화면 기능 개선 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.vo.BlplPropVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.vo.CstBlplCopyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.vo.CstBlplSearchVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.vo.CstPriSpBlplVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.vo.RsltPriSpBlplCtntInqVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.vo.RsltPriSpBlplCtntVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.vo.RsltPriSpBlplExcelVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.vo.RsltPriSpBlplHeaderVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.vo.RsltPriSpBlplInqVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.vo.RsltPriSpBlplVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSpBlplCtntVO;
import com.hanjin.syscommon.common.table.PriSpBlplVO;
import com.hanjin.syscommon.common.table.PriSpMnVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpHistoryInquiryParamVO;

/**
 * NIS2010-Scproposal Business Logic Command Interface<br>
 * - NIS2010-Scproposal에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kong Back Jin
 * @see Esm_pri_0023EventResponse 참조
 * @since J2EE 1.6
 */
  
public interface SCBoilerPlateProposalBC {
	/**
	 * Boiler Plate List를 조회합니다.<br>
	 * 
	 * @param CstBlplSearchVO cstBlplSearchVO
	 * @return List<RsltPriSpBlplVO>
	 * @exception EventException
	 */
	public List<RsltPriSpBlplVO> searchBoilerPlateList(CstBlplSearchVO cstBlplSearchVO) throws EventException;
	/** 
	 * Boiler Plate Detail List를 조회합니다.<br>
	 * 
	 * @param PriSpBlplCtntVO priSpBlplCtntVO
	 * @return List<RsltPriSpBlplCtntVO>
	 * @exception EventException
	 */
	public List<RsltPriSpBlplCtntVO> searchBoilerPlateDetailList(PriSpBlplCtntVO priSpBlplCtntVO) throws EventException;	
	/**
	 * Boiler Plate 데이터를 저장합니다.<br>
	 * 
	 * @param BlplPropVO blplPropVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageBoilerPlate(BlplPropVO blplPropVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Boiler Plate Header를 조회합니다.<br>
	 * 
	 * @param RsltPriSpBlplHeaderVO rsltPriSpBlplHeaderVO
	 * @return List<RsltPriSpBlplHeaderVO>
	 * @exception EventException
	 */
	public List<RsltPriSpBlplHeaderVO> searchBoilerPlateHeader(RsltPriSpBlplHeaderVO rsltPriSpBlplHeaderVO) throws EventException;
	
	/**
	 * GuideLine의 데이터를 Copy합니다.<br>
	 * 
	 * @param CstBlplCopyVO cstBlplCopyVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String copyGuidelineBoilerPlate(CstBlplCopyVO cstBlplCopyVO,SignOnUserAccount account) throws EventException;	
	
	/**
	 * Boiler Plate 데이터를 Excel로 보내기위하여 Boiler Plate Title과 Content를 합쳐서 조회합니다.<br>
	 * 
	 * @param PriSpBlplVO priSpBlplVO
	 * @return List<RsltPriSpBlplExcelVO>
	 * @exception EventException
	 */
	public List<RsltPriSpBlplExcelVO> searchBoilerPlateListExcel(PriSpBlplVO priSpBlplVO) throws EventException;	
	
	/**
	 * Boiler Plate Title 데이터를 Accept 합니다.<br>
	 * 
	 * @param PriSpBlplVO[] priSpBlplVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptBoilerPlate(PriSpBlplVO[] priSpBlplVO,SignOnUserAccount account) throws EventException;
	/**
	 * Boiler Plate Title 데이터를 Accept Cancel 합니다.<br>
	 * 
	 * @param PriSpBlplVO[] priSpBlplVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelBoilerPlate(PriSpBlplVO[] priSpBlplVO,SignOnUserAccount account) throws EventException;	
	
	/**
	 * Boiler Plate Content 데이터를 Accept 합니다.<br>
	 * 
	 * @param PriSpBlplCtntVO[] priSpBlplCtntVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptBoilerPlateContent(PriSpBlplCtntVO[] priSpBlplCtntVO,SignOnUserAccount account) throws EventException;
	/**
	 * Boiler Plate Content 데이터를 Accept Cancel 합니다.<br>
	 * 
	 * @param PriSpBlplCtntVO[] priSpBlplCtntVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelBoilerPlateContent(PriSpBlplCtntVO[] priSpBlplCtntVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Boiler Plate  데이터 중 이미 Accept된 데이터를 제외한 모든 데이터를 Accept 합니다.<br>
	 * 
	 * @param CstPriSpBlplVO cstPriSpBlplVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int acceptAllBoilerPlate(CstPriSpBlplVO cstPriSpBlplVO,SignOnUserAccount account) throws EventException;

	/**
	 * Boiler Plate  데이터중 Accept된 데이터를 모두 Accept Cancel 합니다.<br>
	 * 
	 * @param CstPriSpBlplVO cstPriSpBlplVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int cancelAllBoilerPlate(CstPriSpBlplVO cstPriSpBlplVO,SignOnUserAccount account) throws EventException;		

	/**
	 * Amend Request를 처리합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void amendProposal(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;

    /**
     * Proposal Boiler Plate 정보를 Copy 합니다.<br>
     * 
     * @param RsltPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalBoilerPlate(RsltPropCopyVO vo, SignOnUserAccount account) throws EventException;
    
    /**
	 * Excel Upload한 데이터를 Boiler Plate에 저장합니다.<br>
	 * 
	 * @param BlplPropVO getBlplPropVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageBoilerPlateExl(BlplPropVO getBlplPropVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Main의 Init 상태를 Cancel시 해당 Amend Seq NO.의 모든 데이터를 삭제합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposal(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException;	
	
	/**
	 * Request Cancel시 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Boiler Plate Record Count를 반환한다.<br>
	 * 
	 * @param BlplPropVO blplPropVO
	 * @param SignOnUserAccount account
	 * @return returnCnt int
	 * @exception EventException
	 */
	public int searchBoilerPlateCount(BlplPropVO blplPropVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Boiler Plate Amend History Title을 조회합니다.<br>
	 * 
	 * @param RsltPriSpBlplHeaderVO rsltPriSpBlplHeaderVO
	 * @return List<RsltPriSpBlplHeaderVO>
	 * @exception EventException
	 */
	public List<RsltPriSpBlplHeaderVO> searchBoilerPlateTitle(RsltPriSpBlplHeaderVO rsltPriSpBlplHeaderVO)	throws EventException;
	/**
	 * Boiler Plate Amend History Content를 조회합니다.<br>
	 * 
	 * @param PriSpBlplCtntVO priSpBlplCtntVO
	 * @param PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO
	 * @return List<RsltPriSpBlplCtntVO>
	 * @exception EventException
	 */
	public List<RsltPriSpBlplCtntVO> searchBoilerPlateDetailHistoryList(PriSpBlplCtntVO priSpBlplCtntVO,PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO) throws EventException;	
	/**
	 * Boiler Plate Amend History List를 조회합니다.<br>
	 * 
	 * @param CstBlplSearchVO cstBlplSearchVO
	 * @param PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO
	 * @return List<RsltPriSpBlplVO>
	 * @exception EventException
	 */
	public List<RsltPriSpBlplVO> searchBoilerPlateHistoryList(CstBlplSearchVO cstBlplSearchVO,PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO) throws EventException;
	
	/**
	 *Inquiry - Boiler Plate Header 정보를 조회합니다<br>
	 * 
	 * @param RsltPriSpBlplHeaderVO rsltPriSpBlplHeaderVO
	 * @return List<RsltPriSpBlplHeaderVO>
	 * @exception EventException
	 */
	public List<RsltPriSpBlplHeaderVO> searchBoilerPlateHeaderInquiry(RsltPriSpBlplHeaderVO rsltPriSpBlplHeaderVO) throws EventException;	
	
	/**
	 *Inquiry - Boiler Plate Title 정보를 조회합니다<br>
	 * 
	 * @param CstBlplSearchVO cstBlplSearchVO
	 * @return List<RsltPriSpBlplInqVO>
	 * @exception EventException
	 */
	public List<RsltPriSpBlplInqVO> searchBoilerPlateInquiryList(CstBlplSearchVO cstBlplSearchVO) throws EventException;
	
	/**
	 * Inquiry - Boiler Plate Contents 정보를 조회합니다<br>
	 * 
	 * @param PriSpBlplCtntVO priSpBlplCtntVO
	 * @return List<RsltPriSpBlplCtntInqVO>
	 * @exception EventException
	 */
	public List<RsltPriSpBlplCtntInqVO> searchBoilerPlateDetailInquiryList(PriSpBlplCtntVO priSpBlplCtntVO) throws EventException;
	
	/**
     * Master Delete시 Detail  데이터에 Accept된 항목이 있는지 조회한다.<br>
     * Accept데이터가 있다면 삭제할 수 없다.<br>
	 * 
	 * @param PriSpBlplVO[] priSpBlplVOs
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchDetailAccept(PriSpBlplVO[] priSpBlplVOs) throws EventException;	
	/**
	 * 모든 SRC_INFO_CD가 GC이고 삭제된 내용이 없을시 자동 Accept 합니다.<br>
	 * 
	 * @param PriSpBlplvo priSpBlplvo
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int autoAcceptProposalBoilerPlate(PriSpBlplVO priSpBlplVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 모든 SRC_INFO_CD가 GC이고 삭제된 내용이 없을시 자동 Cancel 합니다.<br>
	 * 
	 * @param PriSpBlplvo priSpBlplvo
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int autoCancelProposalBoilerPlate(PriSpBlplVO priSpBlplVO, SignOnUserAccount account) throws EventException;
}