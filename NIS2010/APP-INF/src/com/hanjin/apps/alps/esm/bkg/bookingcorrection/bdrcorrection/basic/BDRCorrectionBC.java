/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BDRCorrectionBC.java
*@FileTitle : BDR_Correction
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.05.11 김영출
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.vo.CaDetailVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.vo.CaInfoByBkgVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.vo.CaRsnRmkVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.vo.CorrReplanVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.CaIssueDateInVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgCorrectionVO;

/**
 * NIS2010-Bookingcorrection Business Logic Command Interface<br>
 * - NIS2010-Bookingcorrection에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kim Youngchul
 * @see Bdr_correctionEventResponse 참조
 * @since J2EE 1.4
 */

public interface BDRCorrectionBC {
	
    /**
     * 1) C/A Issue Reason 시, C/A Temp History를 생성<br>
     * 2) C/A complete 시, C/A History를 생성<br>
     * @author Lee NamKyung 
     * @param  BkgBlNoVO bkgBlNoVO
     * @param  String tempHistCd
     * @param  BkgCorrectionVO bkgCorrectionVO
     * @param  SignOnUserAccount account
     * @return BkgBlNoVO 
     * @exception EventException
     */
    public BkgBlNoVO createTempHist(BkgBlNoVO bkgBlNoVO, String tempHistCd, BkgCorrectionVO bkgCorrectionVO, SignOnUserAccount account) throws EventException;
    
    /**
     * 1) c/a 완료후 변경된 data를 비교하여 kind를 계산하여 저장한다.<br>
     * 2) 이 기준으로 실적을 산출하며 exempt 여부를 판단한다.<br>
     * @author Lee NamKyung 
     * @param  BkgBlNoVO bkgBlNoVO
     * @param  SignOnUserAccount account
     * @exception EventException
     */
    public void modifyCngItemFlag(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException;
    
    /**
     * C/A를 진행중인 user가 c/a를 중지한다.<br>
     * @author Lee NamKyung 
     * @param  BkgBlNoVO bkgBlNoVO
     * @param  SignOnUserAccount account
     * @exception EventException
     */
    public void cancelCA(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException;
    
    /**
     * C/A 중지/완료이므로 해당 C/A의 temp table을 삭제한다.<br>
     * @author Lee NamKyung 
     * @param  BkgBlNoVO bkgBlNoVO
     * @exception EventException
     */
    public void removeCATemp(BkgBlNoVO bkgBlNoVO) throws EventException;
    
    /**
     * CA Resaon/Remark 정보 수정한다.<br>
     * @author Lee NamKyung 
     * @param  String caIssReasonCd
     * @param  String caRemark
     * @param  BkgBlNoVO bkgBlNoVO
     * @param  String RdnAcptFlg
     * @param  SignOnUserAccount account
     * @exception EventException
     */
    public void modifyCaReason(String caIssReasonCd, String caRemark, BkgBlNoVO bkgBlNoVO, String rdnAcptFlg, String umchSubTpCd, SignOnUserAccount account) throws EventException;
    
    /**
     * CA Resaon/Remark 정보 조회한다.<br>
     * @author Lee NamKyung 
     * @param  BkgBlNoVO bkgBlNoVO
     * @param  SignOnUserAccount account
     * @return CaRsnRmkVO 
     * @exception EventException
     */
    public CaRsnRmkVO searchCaRsnRmk(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException; 
    
    /**
     * bkg별 기본 정보와 C/A 변경 list를 조회한다.<br>
     * @author Lee NamKyung 
     * @param  BkgBlNoVO bkgBlNoVO
     * @return CaInfoByBkgVO 
     * @exception EventException
     */
    public CaInfoByBkgVO searchCaInfoByBkg(BkgBlNoVO bkgBlNoVO) throws EventException;
    
    /**
     *  C/A 변경 건 별 상세 정보를 조회한다.<br>
     * @author Lee NamKyung 
     * @param  BkgBlNoVO bkgBlNoVO
     * @return CaDetailVO 
     * @exception EventException
     */
    public CaDetailVO searchCaDetail(BkgBlNoVO bkgBlNoVO) throws EventException;
    
    /**
     * c/a이력이 있는지 없는지 조회한다.<br>
     * @author Lee NamKyung 
     * @param  BkgBlNoVO bkgBlNoVO
     * @param  SignOnUserAccount account
     * @return String 
     * @exception EventException
     */
    public String add1stCaHist(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException;
 
    /**
     * c/a 완료시 replan할 필요가 있는지 조회한다.<br>
     * @author Ryu Daeyoung
     * @param  BkgBlNoVO bkgBlNoVO
     * @return List<CorrReplanVO>
     * @exception EventException
     */ 
	public List<CorrReplanVO> searchCorrReplan(BkgBlNoVO bkgBlNoVO) throws EventException;

    /**
     * combine/split/cod의 경우 auto c/a temp data를 생성한다..<br>
     * @author Ryu Daeyoung
     * @param  BkgBlNoVO bkgBlNoVO
     * @param  modeCd
     * @param  BkgCorrectionVO bkgCorrectionVO
     * @param  SignOnUserAccount account
     * @exception EventException
     */ 
	public void addAutoCaTemp(BkgBlNoVO bkgBlNoVO, String modeCd,BkgCorrectionVO bkgCorrectionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * C/A Report (ESM_BKG_0568) Remark를 수정합니다.<br>
	 * 
	 * @param  CaIssueDateInVO[] vos
	 * @param  SignOnUserAccount account
	 * @throws EventException
	 */
	public void modifyCaIssueRemark(CaIssueDateInVO[] vos, SignOnUserAccount account) throws EventException ;

	/**
	 * Last Correction No를 조회한다.<br>
	 * 
	 * @param  BkgBlNoVO bkgBlNoVO
     * @return BkgBlNoVO
	 * @throws EventException
	 */
	public BkgBlNoVO searchLstCorrNo(BkgBlNoVO bkgBlNoVO) throws EventException ;

	/**
	 * BKG Correction 을 삭제한다.<br>
	 * 
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @throws EventException
	 */
	public void removeCA(BkgBlNoVO bkgBlNoVO) throws EventException ;
	 
	 
	 /**
      * CA 가 진행 중인지 확인한다.<br>
      * 
      * @param  BkgBlNoVO bkgBlNoVO
      * @param  SignOnUserAccount account
      * @return boolean 
      * @exception EventException
      */
    public boolean checkCaProcessing(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException;

	 /**
     * 진행 중인 CA 정보를 조회한다.<br>
     * 
     * @param  BkgBlNoVO bkgBlNoVO
     * @return BkgCorrectionVO 
     * @exception EventException
     */
	public BkgCorrectionVO searchBkgCorrection(BkgBlNoVO bkgBlNoVO) throws EventException;
}