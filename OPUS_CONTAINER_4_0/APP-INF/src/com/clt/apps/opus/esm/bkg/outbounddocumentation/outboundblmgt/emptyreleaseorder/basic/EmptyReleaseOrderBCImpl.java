/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EmptyReleaseOrderBCBCImpl.java
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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgEmlEdtVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.integration.EmptyReleaseOrderDBDAO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.integration.EmptyReleaseOrderEAIDAO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.BkgLodFctrDlLogDtlVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.BkgLodFctrDlLogHdrVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.FtpInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdDetailOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdSimpleOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdUsaOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.SendMtyRlseOrdVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgNtcHisVO;
import com.clt.syscommon.common.table.ComUserVO;

/**
 * OPUS-OutboundBLMgtSC Business Logic Basic Command implementation<br>
 * - OPUS-OutboundBLMgtSC business logic handling.<br>
 *
 * @author Lee Jin Seo
 * @see esm_bkg-0913EventResponse,EmptyReleaseOrderBCBC each DAO class reference
 * @since J2EE 1.6
 */
public class EmptyReleaseOrderBCImpl extends BasicCommandSupport implements EmptyReleaseOrderBC {

	// Database Access Object
	private transient EmptyReleaseOrderDBDAO dbDao = null;
	private transient EmptyReleaseOrderEAIDAO dbEaiDao = null;

	/**
	 * EmptyReleaseOrderBCBCImpl object creation<br>
	 * EmptyReleaseOrderBCDBDAO creation.<br>
	 */
	public EmptyReleaseOrderBCImpl() {
		dbDao = new EmptyReleaseOrderDBDAO();
		dbEaiDao = new EmptyReleaseOrderEAIDAO();
	}

	/**
     * ESM_BKG_0252 : Simple retrieve event handling<br>
     *
     * @param MtyRlseOrdInVO mtyRlseOrdIn
     * @author Choi Do Soon
     * @return List<MtyRlseOrdSimpleOutVO>
     * @exception EventException
     */
    public List<MtyRlseOrdSimpleOutVO> searchMtyRlseOrdForSimple(MtyRlseOrdInVO mtyRlseOrdIn) throws EventException {
        try {
            return dbDao.searchMtyRlseOrdForSimple(mtyRlseOrdIn);
        } catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        } catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
    }

    /**
     * ESM_BKG_0252 : Detail retrieve event handling<br>
     *
     * @param MtyRlseOrdInVO mtyRlseOrdIn
     * @author Choi Do Soon
     * @return List<MtyRlseOrdDetailOutVO>
     * @exception EventException
     */
    public List<MtyRlseOrdDetailOutVO> searchMtyRlseOrdForDetail(MtyRlseOrdInVO mtyRlseOrdIn) throws EventException {
        try {
            return dbDao.searchMtyRlseOrdForDetail(mtyRlseOrdIn);
        } catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        } catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
    }

    /**
     * ESM_BKG_0252 : Detail(USA) retrieve event handling<br>
     *
     * @param MtyRlseOrdInVO mtyRlseOrdIn
     * @author Choi Do Soon
     * @return List<MtyRlseOrdUsaOutVO>
     * @exception EventException
     */
    public List<MtyRlseOrdUsaOutVO> searchMtyRlseOrdForUsa(MtyRlseOrdInVO mtyRlseOrdIn) throws EventException {
        try {
            return dbDao.searchMtyRlseOrdForUsa(mtyRlseOrdIn);
        } catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        } catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
    }
    
    /**
     * ESM_BKG_0252 : send fax event handling
     * 
     * @param SendMtyRlseOrdVO[] sendMtyRlseOrdVOs
     * @param SignOnUserAccount account
     * @author Choi Do Soon
     * @return List<BkgNtcHisVO>
     * @throws EventException
     */
    public  List<BkgNtcHisVO> sendMtyRlseOrdByFax (SendMtyRlseOrdVO[] sendMtyRlseOrdVOs,SignOnUserAccount account)throws EventException {
		List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
		BkgNtcHisVO bkgNtcHisVO = null;
		SendMtyRlseOrdVO sendMtyRlseOrdVO = null;	
		String rcvInfo = null;
		String sendId = null;
		try {
			for (int i=0; i<sendMtyRlseOrdVOs.length; i++) {
				rcvInfo = account.getUsr_nm() + ";" + sendMtyRlseOrdVOs[i].getNtcFaxNo();
				
				/* 3. Fax send */
				sendMtyRlseOrdVO = new SendMtyRlseOrdVO();
				sendMtyRlseOrdVO.setSysCd("BKG");
				sendMtyRlseOrdVO.setTmplMrd("ESM_BKG_0861.mrd");
				sendMtyRlseOrdVO.setBatchFlg("N");
				sendMtyRlseOrdVO.setTitle("Empty Container Release Order(BKG#: "+sendMtyRlseOrdVOs[i].getBkgNo()+")");
				sendMtyRlseOrdVO.setTmplParam(sendMtyRlseOrdVOs[i].getTmplParam()); 
				sendMtyRlseOrdVO.setRcvInfo(rcvInfo);
				sendMtyRlseOrdVO.setOffice(account.getOfc_cd());
				sendMtyRlseOrdVO.setCrtUserId(account.getUsr_id());
				sendId = dbEaiDao.sendMtyRlseOrdByFax(sendMtyRlseOrdVO);				
				
				bkgNtcHisVO = new BkgNtcHisVO();
				bkgNtcHisVO.setBkgNo(sendMtyRlseOrdVOs[i].getBkgNo());
				bkgNtcHisVO.setNtcViaCd("F"); //F:Fax,M:Email
				bkgNtcHisVO.setNtcKndCd("F".equalsIgnoreCase(sendMtyRlseOrdVOs[i].getYardType()) ? "FC" :("T".equalsIgnoreCase(sendMtyRlseOrdVOs[i].getYardType()) ?  "BT":"CN"));
				bkgNtcHisVO.setNtcSeq("0");
				bkgNtcHisVO.setCustCntcTpCd("E0");
				bkgNtcHisVO.setNtcFaxNo(sendMtyRlseOrdVOs[i].getNtcFaxNo());
				bkgNtcHisVO.setSndId(sendId);
				bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
				bkgNtcHisVO.setSndUsrId(account.getUsr_id());
				bkgNtcHisVO.setSndRqstDt(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
				bkgNtcHisVO.setDiffRmk(sendMtyRlseOrdVOs[i].getDiffRmk());
				bkgNtcHisVO.setCreUsrId(account.getUsr_id());
				bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
				bkgNtcHisVOs.add(bkgNtcHisVO);
			}
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage());
		} catch (Exception ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage());
		}
		
		return bkgNtcHisVOs;
    		 
    }
    
    
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
    public  List<BkgNtcHisVO> sendMtyRlseOrdByEmail (SendMtyRlseOrdVO[] sendMtyRlseOrdVOs,BkgEmlEdtVO bkgEmlEdtVO,SignOnUserAccount account)throws EventException {
    	List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
		BkgNtcHisVO bkgNtcHisVO = null;
		SendMtyRlseOrdVO sendMtyRlseOrdVO = null;
		String sendId = null;
		BookingUtil util = null;
		String ntcKndCd = null;
		ComUserVO comUserVO = null;
		try {
			util = new BookingUtil();
			comUserVO = util.searchComUserInfo(account.getUsr_id());
			String sUsrEml = null;
			if (null!=comUserVO) {
				sUsrEml = (null==comUserVO.getDfltEml() || "".equals(comUserVO.getDfltEml())) ? comUserVO.getUsrEml() : comUserVO.getDfltEml();
			}
			sUsrEml = " shipment.info@notifications.nykline.com";
//			String sUsrEml = util.searchComUserInfo(account.getUsr_id()).getDfltEml();
			for (int i=0; i<sendMtyRlseOrdVOs.length; i++) {
				sendMtyRlseOrdVO = new SendMtyRlseOrdVO();
				ntcKndCd = "F".equalsIgnoreCase(sendMtyRlseOrdVO.getYardType()) ? "FC" :("T".equalsIgnoreCase(sendMtyRlseOrdVO.getYardType()) ?  "BT":"CN");
				sendMtyRlseOrdVO.setSysCd("BKG");
				sendMtyRlseOrdVO.setTmplMrd("ESM_BKG_0861.mrd");
				sendMtyRlseOrdVO.setBatchFlg("N");
				sendMtyRlseOrdVO.setTitle("EMPTY RELEASE ORDER for Shipment reference "+sendMtyRlseOrdVOs[i].getBkgNo());
				sendMtyRlseOrdVO.setContents("BKG No : "+sendMtyRlseOrdVOs[i].getBkgNo()); 
				sendMtyRlseOrdVO.setTmplParam(sendMtyRlseOrdVOs[i].getTmplParam());
				sendMtyRlseOrdVO.setSndEml(sUsrEml);
				sendMtyRlseOrdVO.setRcvEml(sendMtyRlseOrdVOs[i].getNtcEml());
				
				String bccRcvrEml = util.searchBccEmailAddrRSQL("CN"); 
				
				sendMtyRlseOrdVO.setCrtUserId(account.getUsr_id());
				sendId = dbEaiDao.sendMtyRlseOrdByEmail(sendMtyRlseOrdVO,bkgEmlEdtVO,util.searchCcEmailAddrRSQL(ntcKndCd, account.getUsr_id()), bccRcvrEml);
				bkgNtcHisVO = new BkgNtcHisVO();
				bkgNtcHisVO.setBkgNo(sendMtyRlseOrdVOs[i].getBkgNo());
				bkgNtcHisVO.setNtcViaCd("M"); //F:Fax,M:Email
				bkgNtcHisVO.setNtcKndCd(ntcKndCd);
				bkgNtcHisVO.setNtcSeq("0");
				bkgNtcHisVO.setCustCntcTpCd("E0");
				bkgNtcHisVO.setNtcEml(sendMtyRlseOrdVOs[i].getNtcEml());
				bkgNtcHisVO.setSndId(sendId);
				bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
				bkgNtcHisVO.setSndUsrId(account.getUsr_id());
				bkgNtcHisVO.setSndRqstDt(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
				bkgNtcHisVO.setDiffRmk(sendMtyRlseOrdVOs[i].getDiffRmk());
				bkgNtcHisVO.setCreUsrId(account.getUsr_id());
				bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
				bkgNtcHisVOs.add(bkgNtcHisVO);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage());
		}
		return bkgNtcHisVOs;
    }

    /**
     * Empty Container Release Order Excel Download
     * @param mtyRlseOrdInVO
     * @return List<?>
     * @throws EventException
     */
	@Override
	public List<?> searchMtyRlseOrdForExcelDownload(MtyRlseOrdInVO mtyRlseOrdInVO) throws EventException {
		try {
            return dbDao.searchMtyRlseOrdForExcelDownload(mtyRlseOrdInVO);
        } catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        } catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
	}

    /**
     * Empty Container Release Order Excel Download
     * @param mtyRlseOrdInVO
     * @param excelNumber
     * @return List<?>
     * @throws EventException
     */
	@Override
	public List<?> searchMtyRlseOrdForExcelDownload(MtyRlseOrdInVO mtyRlseOrdInVO, int excelNumber)	throws EventException {
		try {
            return dbDao.searchMtyRlseOrdForExcelDownload(mtyRlseOrdInVO, excelNumber);
        } catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        } catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
	}

    /**
     * BATCH : Container Release Order Excel FTP Info
     * 
     * @param String hrdCdgId
     * @return List<FtpInfoVO>
     * @throws EventException
     */
	@Override
	public List<FtpInfoVO> sendMtyRlseOrdByFTP(String hrdCdgId) throws EventException {
		try {
            return dbDao.sendMtyRlseOrdByFTP(hrdCdgId);
        } catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        } catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
	}
	
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
    public void manageLodFctrDlLog(FtpInfoVO ftpInfoVO, String[] bkgNos, String sendDate, String fileName, String ftpYn, String usrId) throws EventException {
		try {
			dbDao.createLodFctrDlLogHdr(sendDate, ftpInfoVO, fileName, ftpYn, usrId);
			for(int i=0;i<bkgNos.length;i++) {
				dbDao.createLodFctrDlLogDtl(sendDate, ftpInfoVO.getOfcCd(), bkgNos[i], usrId);
			}
        } catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        } catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
	}

    /**
     * BATCH : Container Release Order Excel FTP Info
     * 
     * @param BkgLodFctrDlLogHdrVO logHdrVO
     * @return List<BkgLodFctrDlLogHdrVO>
     * @throws EventException
     */
	@Override
	public List<BkgLodFctrDlLogHdrVO> searchBkgLodFctrDlLogHdr(BkgLodFctrDlLogHdrVO logHdrVO) throws EventException {
		try {
            return dbDao.searchBkgLodFctrDlLogHdr(logHdrVO);
        } catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        } catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
	}
	
    /**
     * BATCH : Container Release Order Excel FTP Info
     * 
     * @param BkgLodFctrDlLogHdrVO logHdrVO
     * @return List<BkgLodFctrDlLogHdrVO>
     * @throws EventException
     */
	@Override
	public List<BkgLodFctrDlLogDtlVO> searchBkgLodFctrDlLogDtl(BkgLodFctrDlLogHdrVO logHdrVO) throws EventException {
		try {
            return dbDao.searchBkgLodFctrDlLogDtl(logHdrVO);
        } catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        } catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
	}

    /**
     * BATCH : Container Release Order Excel FTP Info
     * 
     * @param String hrdCdgId
     * @return List<FtpInfoVO>
     * @throws EventException
     */
	@Override
	public List<FtpInfoVO> sendMtyRlseOrdByFTPRetry(String hrdCdgId) throws EventException {
		try {
            return dbDao.sendMtyRlseOrdByFTPRetry(hrdCdgId);
        } catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        } catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
	}
	
    /**
     * BATCH : Container Release Order Excel FTP Info History
     * @param String ldfDlDt
     * @param String bkgOfcCd
     * @param String ftpYn
     * @param String usrId
     * @throws EventException
     */
    public void modifyLodFctrDlLog(String ldfDlDt, String bkgOfcCd, String ftpYn, String usrId) throws EventException {
		try {
			dbDao.modifyLodFctrDlLog(ldfDlDt, bkgOfcCd, ftpYn, usrId);
        } catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        } catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
	}
	
}
