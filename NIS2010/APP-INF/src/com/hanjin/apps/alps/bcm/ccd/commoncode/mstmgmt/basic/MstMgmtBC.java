/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MstMgmtBC.java
*@FileTitle : BCM_CCD_2001
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.03
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.03 황효근
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.basic;
 
import java.util.List;

import com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.vo.MdmDatProcVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.vo.MdmUsrAuthVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.vo.SearchMdmHistListVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.vo.SearchMdmHistoryListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-Commoncode Business Logic Command Interface<br>
 * - OPUS-Commoncode에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author 
 * @see 
 * @since J2EE 1.4 
 */

public interface MstMgmtBC {

	/**
	 * Master User Authoriry 정보를 조회한다.
	 * 
	 * @param MdmUsrAuthVO mdmUsrAuthVO
	 * @return List<MdmUsrAuthVO>
	 * @exception EventException
	 */
	public List<MdmUsrAuthVO> searchMdmUsrAuthList(MdmUsrAuthVO mdmUsrAuthVO) throws EventException;
	
	
	/**
	 * Master Authoriry 정보를 추가, 수정, 삭제 처리한다.  
	 * 
	 * @param mdmUsrAuthVOs
	 * @param account
	 * @throws EventException
	 */
	public void manageMdmUsrAuth(MdmUsrAuthVO[] mdmUsrAuthVOs, SignOnUserAccount account) throws EventException;
	
	
	/**
	 *  Master Data Process 요청 정보를 조회한다.
	 * 
	 * @param MdmDatProcVO mdmDatProcVO
	 * @return List<MdmDatProcVO>
	 * @exception EventException
	 */
	public List<MdmDatProcVO> searchMdmDatProcRequestList(MdmDatProcVO mdmDatProcVO) throws EventException;
	
	/**
	 * Mdm History 요청 정보를 조회한다.
	 * 
	 * @param SearchMdmHistoryListVO searchMdmHistoryListVO
	 * @return List<SearchMdmHistoryListVO>
	 * @exception EventException
	 */
	public List<SearchMdmHistoryListVO> searchMdmHistoryList(SearchMdmHistoryListVO searchMdmHistoryListVO) throws EventException;
	
	/**
	 *  Master Data Process 결과 정보를 조회한다.
	 * 
	 * @param MdmDatProcVO mdmDatProcVO
	 * @return List<MdmDatProcVO>
	 * @exception EventException
	 */
	public List<MdmDatProcVO> searchMdmDatProcCompletionList(MdmDatProcVO mdmDatProcVO) throws EventException;
	
	/**
	 * Master Data 의 Authority Type Code 정보를 조회한다.<br>
	 * 
	 * @param MdmDatProcVO mdmDatProcVO
	 * @return String
	 * @exception EventException
	 */
	public String searchAuthTpCd(MdmDatProcVO mdmDatProcVO) throws EventException;
	
	/**
	 * Master Data Process 테이블의 새로운 Request No 정보를 조회한다.
	 * 
	 * @param String mstDatSubjCd
	 * @return String
	 * @exception EventException
	 */
	public String searchMdmDatProcRqstNo(String mstDatSubjCd) throws EventException;
	
	/**
	 * MDM DATA PROCESS 정보를 추가한다.
	 * 
	 * @param MdmDatProcVO mdmDatProcVO
	 * @throws EventException
	 */
	public void addMdmDatProc(MdmDatProcVO mdmDatProcVO) throws EventException;
	
	/**
	 * MDM DATA PROCESS 정보를 수정한다.
	 * 
	 * @param MdmDatProcVO mdmDatProcVO
	 * @param MdmDatProcVO[] mdmDatProcVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void modifyMdmDatProc(MdmDatProcVO mdmDatProcVO, MdmDatProcVO[] mdmDatProcVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * MDM DATA PROCESS 정보를 수정한다.
	 * 
	 * @param MdmDatProcVO mdmDatProcVO
	 * @throws EventException
	 */
	public void modifyMdmDatProc(MdmDatProcVO mdmDatProcVO) throws EventException;
	
	/**
	 * MDM USER AUTHORITY 정보를 추가, 수정, 삭제 처리한다.
	 * 
	 * @param MdmDatProcVO[] mdmDatProcVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void removeMdmDatProc(MdmDatProcVO[] mdmDatProcVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * CNT_CD별 CUST_MAX_SEQ 정보를 조회한다.
	 * 
	 * @param String cntCd
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String searchCustMaxSeq(String cntCd, SignOnUserAccount account) throws EventException;
	
	/**
	 * Office Kind Code retrieve.
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchOfcKndCd(String ofcCd) throws EventException;
	/**
	 * MDM DATA Process info retrieve. 
	 * 
	 * @param String rqstNo
	 * @return MdmDatProcVO
	 * @exception EventException
	 */
	public MdmDatProcVO searchMdmDatProc(String rqstNo) throws EventException;
	
	/**
	 * Mdm History 요청 정보를 조회한다.
	 * 
	 * @param SearchMdmHistoryListVO searchMdmHistoryListVO
	 * @return String
	 * @exception EventException
	 */
	public String searchMdmHistoryCount(SearchMdmHistoryListVO searchMdmHistoryListVO) throws EventException;
	
	
	/**
	 * Mdm History 요청 정보를 조회한다.
	 * 
	 * @param SearchMdmHistListVO SearchMdmHistListVO
	 * @return List<SearchMdmHistListVO>
	 * @exception EventException
	 */
	public List<SearchMdmHistListVO> searchMdmHistList(SearchMdmHistListVO searchMdmHistListVO) throws EventException;
	
}