/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CODCorrectionBC.java
*@FileTitle : COD Status Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.07.23 최영희
* 1.0 Creation
* --------------------------------------------------------
* History
* 2012.11.12 조정민 [CHM-201220900] [BKG] [COD Application] Approval RSO 자동지정 (Re-handling port 대륙으로 일치)
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BookingCreationVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.vo.CodAuthVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.vo.CodEtcVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.vo.CodHistoryVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.vo.CodRehandlingInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.vo.CodStsInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.vo.CodStsVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.vo.CodVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.vo.PrnrCodRqstVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgCodCostVO;
import com.hanjin.syscommon.common.table.BkgCodVO;

/**
 * ALPS-Bookingcorrection Business Logic Command Interface<br>
 * - ALPS-Bookingcorrection에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Choi Yeoung Hee
 * @see Esm_bkg_0157EventResponse 참조
 * @since J2EE 1.6
 */

public interface CODCorrectionBC {

	/**
	 * COD의 요청,승인,거절 등의 이력을 조회한다.<br>
	 * 
	 * @param CodStsInputVO codStsInputVO
	 * @return List<CodStsVO>
	 * @exception EventException
	 */
	public List<CodStsVO> searchCodStsList(CodStsInputVO codStsInputVO) throws EventException;
	
	/**
	 * 해당 bkg으로 bkg_cod의 cod_rqst_seq를 조회한다.<br>
     * 
	 * @param  BkgBlNoVO bkgBlNoVO 
	 * @return List<BkgComboVO>
	 * @exception EventException
	 */
	public List<BkgComboVO> searchCodRqstSeq(BkgBlNoVO bkgBlNoVO) throws EventException;
	
	/**
	 * cod 요청 정보를 생성하기 위해 booking 정보와 요청/승인 상태도 함께 조회한다.<br>
	 * 
	 * @param  String codRqstSeq
	 * @param  BkgBlNoVO bkgBlNoVo
	 * @return CodVO
	 * @exception EventException
	 */
	public CodVO searchCodRqst(String codRqstSeq, BkgBlNoVO bkgBlNoVO)throws EventException;
	
	/**
	 * cod 요청에 대한 변경 이력을 조회한다<br>
     * 
	 * @param  BkgBlNoVO bkgBlNoVo
	 * @param  String codRqstSeq
	 * @return List<CodHistoryVO>
	 * @exception EventException
	 */
	public List<CodHistoryVO>searchCodHistory (BkgBlNoVO bkgBlNoVO, String  codRqstSeq) throws EventException;
	
	/**
	 * cod 요청 정보를 생성한다.<br>
     * 
	 * @param  CodVO codVO
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void createCodRqst(CodVO codVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * cod 요청 건의 변경 정보를 생성한다.<br>
     * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String codRqstSeq
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCodHistory(BkgBlNoVO bkgBlNoVO , String codRqstSeq,SignOnUserAccount account) throws EventException;
	
	/**
	 * COD 요청 내역을 수정<br>
     * 
	 * @param CodVO codVO
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String codRqstSeq
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyCodRqst(CodVO codVO,BkgBlNoVO bkgBlNoVO, String codRqstSeq,SignOnUserAccount account) throws EventException; 
	
	/**
	 * COD 요청 내역을 삭제<br>
     * 
	 * @param CodVO codVO
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String codRqstSeq
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeCodRqst(CodVO codVO,BkgBlNoVO bkgBlNoVO, String codRqstSeq,SignOnUserAccount account) throws EventException; 
	
	/**
	 * OPF로 저장된 COD 정보에 대해서 승인을 요청한다.<br>
	 * 
	 * @param CodVO codVO
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String codRqstSeq
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyCodApproval(CodVO codVO,BkgBlNoVO bkgBlNoVO, String codRqstSeq,SignOnUserAccount account) throws EventException; 
	
	/**
	 * cod 요청의 상태를 변경한다.<br>
     * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String codRqstSeq
	 * @param String codStatusCd
	 * @param String codRqstRsnCd
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyCodStatus(BkgBlNoVO bkgBlNoVO, String codRqstSeq,String codStatusCd,String codRqstRsnCd,SignOnUserAccount account) throws EventException;
	
	/**
	 * OPF에서 COST 저장시나 승인/거절 처리<br>
     *  
	 * @param CodAuthVO codAuthVo
	 * @param BkgCodCostVO[] bkgCodCostVOs
	 * @param String chgRmk
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void approveCod(CodAuthVO codAuthVO,BkgCodCostVO[] bkgCodCostVOs,String chgRmk, SignOnUserAccount account) throws EventException;
	
	/**
	 * 해당 COD 요청 건에 대해서 승인 상태로 update한다.<br>
     * 
	 * @param String codRqstSeq
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void confirmCod (String codRqstSeq, BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * OPF에서 bkg_no, cod_rqst_seq에 맞는 bkg_cod에 rgn_code를 update한다.<br>
	 *
	 * @param BkgCodVO bkgCodVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyCodRgn(BkgCodVO bkgCodVO,SignOnUserAccount account)throws EventException;

	/**
	 * (ESM_BKG_156) 해당 Cod Request 건의 rehandling Request를 판단한다..<br>
	 * @author    Ryu DaeYoung
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @param     CodAuthVO codAuthVO
	 * @param     SignOnUserAccount account
	 * @param     String robFlag
	 * @return    CodVO
	 * @exception EventException
	 */
	public CodVO searchRehandlingPort(BkgBlNoVO bkgBlNoVO, CodAuthVO codAuthVO, SignOnUserAccount account, String robFlag) throws EventException;
	
	/**
	 * opf에서 호출시 해당 request 건의 rehandling 정보를 조회한다.<br>
	 * 
	 * @param String bkgNo
	 * @param String codRqstSeq
	 * @return CodRehandlingInfoVO
	 * @throws EventException
	 */
	public CodRehandlingInfoVO searchRehandlingInfo(String bkgNo, String codRqstSeq) throws EventException;
	
	/**
	 * 외부 cca feeder 선사의 vvd에 대한 cod 요청일 경우 해당 선사로 request mail을 보낸다.<br>
	 * 
	 * @param String codRqstSeq
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void sendXterCodRqst(String codRqstSeq, BkgBlNoVO bkgBlNoVO , SignOnUserAccount account) throws EventException;

	/**
	 * cod split시 dest route 정보를 조회한다..<br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String codRqstSeq
	 * @return CodEtcVO
	 * @throws EventException
	 */
	public CodEtcVO searchCodSplitRoute(BkgBlNoVO bkgBlNoVO, String codRqstSeq) throws EventException;
	
	/**
	 * g/w mail로 cod 요청일 경우 mail 내용의 data를 조회한다..<br>
	 * 
	 * @param String codRqstSeq
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param SignOnUserAccount account
	 * @return PrnrCodRqstVO
	 * @throws EventException
	 */
	public PrnrCodRqstVO searchCodRqstEmlCtnt(String codRqstSeq, BkgBlNoVO bkgBlNoVO , SignOnUserAccount account )throws EventException;

	/**
	 * Re-Handling Port 변경시에 RSO를 재설정<br> 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String codRqstSeq
	 * @param String rehandlingPort
	 * @return String
	 * @throws EventException
	 */
	public String searchCodRso(BkgBlNoVO bkgBlNoVO, String codRqstSeq, String rehandlingPort) throws EventException;

	/**
	 * POD, DEL이 바뀌는 경우 auto C/A를 생성한다<br> 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param SignOnUserAccount account
	 * @param String typeCd
	 * @throws EventException
	 */
	public void manageAutoCod(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account, String typeCd) throws EventException;
	
	/**
	 * SCE COP updateBkgForBkgCod 메서드 호출 대상 여부 및 파라미터를 조회 한다.<br>
	 * POD, DEL 국가가 바뀌었을 때 COP 호출한다.
	 * 
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @return CodEtcVO
	 * @throws EventException
	 */
	public CodEtcVO searchCopForBkgCodParam(BkgBlNoVO bkgBlNoVO) throws EventException;
}