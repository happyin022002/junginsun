/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BDRCorrectionBC.java
 *@FileTitle : BDR_Correction
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.vo.CaDetailVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.vo.CaInfoByBkgVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.vo.CaRsnRmkVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.vo.CorrReplanVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.CaIssueDateInVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgCorrectionVO;

/**
 * OPUS-BookingCorrection Business Logic Basic Command implementation<br>
 * - OPUS-BookingCorrection handling business transaction.<br>
 *
 * @author
 * @see BDR_CorrectionEventResponse,BDRCorrectionBC
 * @since J2EE 1.4
 */

public interface BDRCorrectionBC {
	
	/**
     * 1) create C/A Temp History when C/A Issue Reason<br>
     * 2) create C/A History when C/A complete<br>
     * 
     * @author  
     * @param  BkgBlNoVO bkgBlNoVO
     * @param  String tempHistCd
     * @param  BkgCorrectionVO bkgCorrectionVO
     * @param  SignOnUserAccount account
     * @return BkgBlNoVO 
     * @exception EventException
     */
    public BkgBlNoVO createTempHist(BkgBlNoVO bkgBlNoVO, String tempHistCd, BkgCorrectionVO bkgCorrectionVO, SignOnUserAccount account) throws EventException;
    
    /**
     * 1-1) complete C/A.<br>
     * 1-2) comparing change data and calculate kind.<br>
     * 1-3) save.<br>
     * 2) Judging exempt or not from this results.<br>
     
     * @author  
     * @param  BkgBlNoVO bkgBlNoVO
     * @param  SignOnUserAccount account
     * @exception EventException
     */
    public void modifyCngItemFlag(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException;
    
    /**
     * cancel C/A by user of processing C/A.<br>
     * 
     * @author  
     * @param  BkgBlNoVO bkgBlNoVO
     * @param  SignOnUserAccount account
     * @exception EventException
     */
    public void cancelCA(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException;
    
    /**
     * delete temp table because C/A was Stop or Complete.<br>
     * 
     * @author  
     * @param  BkgBlNoVO bkgBlNoVO
     * @exception EventException
     */
    public void removeCATemp(BkgBlNoVO bkgBlNoVO) throws EventException;
    
    /**
     * CA Resaon/Remark Info modify.<br>
     * 
     * @author  
     * @param  String caIssReasonCd
     * @param  String caRemark
     * @param  BkgBlNoVO bkgBlNoVO
     * @param  String RdnAcptFlg
     * @param  SignOnUserAccount account
     * @exception EventException
     */
    public void modifyCaReason(String caIssReasonCd, String caRemark, BkgBlNoVO bkgBlNoVO, String rdnAcptFlg, SignOnUserAccount account) throws EventException;
    
    /**
     * CA Resaon/Remark Info retrieve.<br>
     * 
     * @author  
     * @param  BkgBlNoVO bkgBlNoVO
     * @param  SignOnUserAccount account
     * @return CaRsnRmkVO 
     * @exception EventException
     */
    public CaRsnRmkVO searchCaRsnRmk(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException; 
    
    /**
     * retrieving BKG Info and C/A change list.<br>
     * 
     * @author  
     * @param  BkgBlNoVO bkgBlNoVO
     * @return CaInfoByBkgVO 
     * @exception EventException
     */
    public CaInfoByBkgVO searchCaInfoByBkg(BkgBlNoVO bkgBlNoVO) throws EventException;
    
    /**
     * retrieving detail info by C/A change.<br>
     * 
     * @author  
     * @param  BkgBlNoVO bkgBlNoVO
     * @return CaDetailVO 
     * @exception EventException
     */
    public CaDetailVO searchCaDetail(BkgBlNoVO bkgBlNoVO) throws EventException;
    
    /**
     * checking C/A history.<br>
     * 
     * @author  
     * @param  BkgBlNoVO bkgBlNoVO
     * @param  SignOnUserAccount account
     * @return String 
     * @exception EventException
     */
    public String add1stCaHist(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException;
 
    /**
     * checking need to re-plan. when C/A had complete.<br>
     *  
     * @author 
     * @param  BkgBlNoVO bkgBlNoVO
     * @return List<CorrReplanVO>
     * @exception EventException
     */ 
	public List<CorrReplanVO> searchCorrReplan(BkgBlNoVO bkgBlNoVO) throws EventException;

	/**
     * create auto C/A temp data in case of combine/split/cod.<br>
     * 
     * @author 
     * @param  BkgBlNoVO bkgBlNoVO
     * @param  modeCd
     * @param  BkgCorrectionVO bkgCorrectionVO
     * @param  SignOnUserAccount account
     * @exception EventException
     */ 
	public void addAutoCaTemp(BkgBlNoVO bkgBlNoVO, String modeCd,BkgCorrectionVO bkgCorrectionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * C/A Report (ESM_BKG_0568) Remark modify.<br>
	 * 
	 * @author
	 * @param CaIssueDateInVO[] vos
	 * @param SignOnUserAccount account
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
}