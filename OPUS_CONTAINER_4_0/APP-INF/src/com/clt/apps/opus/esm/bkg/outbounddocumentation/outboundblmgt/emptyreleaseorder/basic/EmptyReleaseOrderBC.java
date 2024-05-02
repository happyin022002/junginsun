/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EmptyReleaseOrderBC.java
*@FileTitle : esm_bkg-0913
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.15
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.06.15 이진서
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgEmlEdtVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.BkgLodFctrDlLogDtlVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.BkgLodFctrDlLogHdrVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.FtpInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdDetailOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdSimpleOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdUsaOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.SendMtyRlseOrdVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgNtcHisVO;

/**
 * OPUS-Outboundblmgtsc Business Logic Command Interface<br>
 * - OPUS-Outboundblmgtsc business logic Interface<br>
 *
 * @author Lee Jin Seo
 * @see Esm_bkg-0913EventResponse reference
 * @since J2EE 1.6
 */

public interface EmptyReleaseOrderBC {
	/**
	 * retrieve event handling<br>
	 * Emptyreleaseorderbc screen retrieve event handling<br>
	 *
	 * @param e Esm_bkg-0913Event
	 * @return EventResponse Esm_bkg-0913EventResponse
	 * @exception EventException
	 */

	/**
	 * ESM_BKG_0252 : Simple retrieve event handling<br>
     *
     * @param MtyRlseOrdInVO mtyRlseOrdIn
     * @author Choi Do Soon
     * @return List<MtyRlseOrdSimpleOutVO>
	 * @throws EventException
	 */
    public  List<MtyRlseOrdSimpleOutVO> searchMtyRlseOrdForSimple(MtyRlseOrdInVO mtyRlseOrdIn) throws EventException;

    /**
	 * ESM_BKG_0252 : Detail retrieve event handling<br>
     *
     * @param MtyRlseOrdInVO mtyRlseOrdIn
     * @author Choi Do Soon
     * @return List<MtyRlseOrdDetailOutVO>
	 * @throws EventException
	 */
    public  List<MtyRlseOrdDetailOutVO> searchMtyRlseOrdForDetail(MtyRlseOrdInVO mtyRlseOrdIn) throws EventException;

    /**
	 * ESM_BKG_0252 : Detail(USA) retrieve event handling<br>
     *
     * @param MtyRlseOrdInVO mtyRlseOrdIn
     * @author Choi Do Soon
     * @return List<MtyRlseOrdUsaOutVO>
	 * @throws EventException
	 */
    public  List<MtyRlseOrdUsaOutVO> searchMtyRlseOrdForUsa(MtyRlseOrdInVO mtyRlseOrdIn) throws EventException;
    
    /**
     * ESM_BKG_0252 : send fax event handling
     * 
     * @param SendMtyRlseOrdVO[] sendMtyRlseOrdVOs
     * @param SignOnUserAccount account
     * @author Choi Do Soon
     * @return List<BkgNtcHisVO>
     * @throws EventException
     */
    public  List<BkgNtcHisVO> sendMtyRlseOrdByFax (SendMtyRlseOrdVO[] sendMtyRlseOrdVOs,SignOnUserAccount account)throws EventException;
    
    
    /**
     * ESM_BKG_0252 : send e-mail event handling
     * 
     * @param SendMtyRlseOrdVO[] sendMtyRlseOrdVOs
     * @param BkgEmlEdtVO bkgEmlEdtVO
     * @param SignOnUserAccount account
     * @author Choi Do Soon
     * @return List<BkgNtcHisVO>
     * @throws EventException
     */
    public  List<BkgNtcHisVO> sendMtyRlseOrdByEmail (SendMtyRlseOrdVO[] sendMtyRlseOrdVOs,BkgEmlEdtVO bkgEmlEdtVO,SignOnUserAccount account)throws EventException;

    /**
     * Empty Container Release Order Excel Download
     * @param mtyRlseOrdInVO
     * @return List<?>
     * @throws EventException
     */
    public List<?> searchMtyRlseOrdForExcelDownload(MtyRlseOrdInVO mtyRlseOrdInVO)throws EventException;
    
    /**
     * Empty Container Release Order Excel Download
     * @param mtyRlseOrdInVO
     * @param excelNumber
     * @return List<?>
     * @throws EventException
     */
    public List<?> searchMtyRlseOrdForExcelDownload(MtyRlseOrdInVO mtyRlseOrdInVO, int excelNumber)throws EventException;
    
    
    /**
     * BATCH : Container Release Order Excel FTP Info
     * 
     * @param String hrdCdgId
     * @return List<FtpInfoVO>
     * @throws EventException
     */
    public  List<FtpInfoVO> sendMtyRlseOrdByFTP (String hrdCdgId) throws EventException;
    
    /**
     * BATCH : Container Release Order Excel FTP Info History
     * @param FtpInfoVO ftpInfoVO
     * @param String[] bkgNos
     * @param String sendDate
     * @param String fileName
     * @param String ftpYn
     * @param String usrId
     * @throws EventException
     */
    public void manageLodFctrDlLog(FtpInfoVO ftpInfoVO, String[] bkgNos, String sendDate, String fileName, String ftpYn, String usrId)throws EventException;
    
    /**
	 * ESM_BKG_0252 : Detail(USA) retrieve event handling<br>
     *
     * @param BkgLodFctrDlLogHdrVO logHdrVO
     * @author 
     * @return List<BkgLodFctrDlLogHdrVO>
	 * @throws EventException
	 */
    public  List<BkgLodFctrDlLogHdrVO> searchBkgLodFctrDlLogHdr(BkgLodFctrDlLogHdrVO logHdrVO) throws EventException;
    
    /**
	 * ESM_BKG_0252 : Detail(USA) retrieve event handling<br>
     *
     * @param BkgLodFctrDlLogHdrVO logHdrVO
     * @author 
     * @return List<BkgLodFctrDlLogDtlVO>
	 * @throws EventException
	 */
    public  List<BkgLodFctrDlLogDtlVO> searchBkgLodFctrDlLogDtl(BkgLodFctrDlLogHdrVO logHdrVO) throws EventException;
    
    /**
     * BATCH : Container Release Order Excel FTP Info
     * 
     * @param String hrdCdgId
     * @return List<FtpInfoVO>
     * @throws EventException
     */
    public  List<FtpInfoVO> sendMtyRlseOrdByFTPRetry (String hrdCdgId) throws EventException;
    
    /**
     * BATCH : Container Release Order Excel FTP Info History
     * @param String ldfDlDt
     * @param String bkgOfcCd
     * @param String ftpYn
     * @param String usrId
     * @throws EventException
     */
    public void modifyLodFctrDlLog(String ldfDlDt, String bkgOfcCd, String ftpYn, String usrId) throws EventException;
    
    
}