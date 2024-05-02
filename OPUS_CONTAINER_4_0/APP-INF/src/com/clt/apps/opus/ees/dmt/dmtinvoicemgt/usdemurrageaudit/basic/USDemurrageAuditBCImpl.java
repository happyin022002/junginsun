/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : USDemurrageAuditBCImpl.java
*@FileTitle : 3rd Party DEM/DET Collection Audit
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.usdemurrageaudit.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.usdemurrageaudit.integration.USDemurrageAuditDBDAO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.usdemurrageaudit.vo.ChargeForAuditParmVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.usdemurrageaudit.vo.ChargeForAuditVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * DMTInvoiceMgt Business Logic Command Interface<br>
 *
 * @author
 * @see reference Ees_dmt_4005EventResponse
 * @since J2EE 1.6
 */
public class USDemurrageAuditBCImpl extends BasicCommandSupport implements USDemurrageAuditBC {

	// Database Access Object
	private transient USDemurrageAuditDBDAO dbDao = null;

	/**
	 * USDemurrageAuditBCImpl Create object<br>
	 * Create USDemurrageAuditDBDAO<br>
	 */
	public USDemurrageAuditBCImpl() {
		dbDao = new USDemurrageAuditDBDAO();
	}
	/**
	 * Search 3rd Party DEM/DET Collection Audit.<br>
	 * 
	 * @param ChargeForAuditParmVO[] chargeForAuditParmVOs
	 * @return List<ChargeForAuditVO>
	 * @exception EventException
	 */
	public List<ChargeForAuditVO> searchChargeForAudit(ChargeForAuditParmVO[] chargeForAuditParmVOs) throws EventException {
		List<ChargeForAuditVO> chargeForAuditVOS = new ArrayList<ChargeForAuditVO>();
		ChargeForAuditVO chargeForAuditVO = null;
		ChargeForAuditVO chargeForAuditRS = null;
		
		try {
			for ( int i=0; i<chargeForAuditParmVOs.length; i++ ) {
				chargeForAuditVO = new ChargeForAuditVO();
				chargeForAuditRS = new ChargeForAuditVO();
							
				String pLoadOptInput = chargeForAuditParmVOs[i].getPLoadOptInput();
				String pOfcCd = chargeForAuditParmVOs[i].getPOfcCd();
				String pDmdtTrfCd = chargeForAuditParmVOs[i].getPDmdtTrfCd();
				String pFmMvmtYdCd = chargeForAuditParmVOs[i].getPFmMvmtYdCd();
				String cntrNo = chargeForAuditParmVOs[i].getCntrNo();
				String tFromDt = chargeForAuditParmVOs[i].getTFromDt();
				String tToDt = chargeForAuditParmVOs[i].getTToDt();
				String tFtEnd = chargeForAuditParmVOs[i].getTFtEnd();
				String tOver = chargeForAuditParmVOs[i].getTOver();
				String tCollection = chargeForAuditParmVOs[i].getTCollection();				
				String vvd = chargeForAuditParmVOs[i].getVvd();
				String blNo = chargeForAuditParmVOs[i].getBlNo();
				String bkgNo = chargeForAuditParmVOs[i].getBkgNo();
				
				log.debug(i+".[pLoadOptInput]:"+pLoadOptInput);
				log.debug(i+".[pOfcCd]		:"+pOfcCd);
				log.debug(i+".[pDmdtTrfCd]	:"+pDmdtTrfCd);
				log.debug(i+".[pFmMvmtYdCd]	:"+pFmMvmtYdCd);
				
				log.debug(i+".[cntrNo]		:"+cntrNo);
				log.debug(i+".[tFromDt]		:"+tFromDt);
				log.debug(i+".[tToDt]		:"+tToDt);
				log.debug(i+".[tFtEnd]		:"+tFtEnd);
				log.debug(i+".[tOver]		:"+tOver);
				log.debug(i+".[tCollection]	:"+tCollection);
				//1
				log.debug(i+".[vvd]			:"+vvd);
				//2
				log.debug(i+".[blNo]		:"+blNo);
				//3
				log.debug(i+".[bkgNo]		:"+bkgNo);
				
				//1. DB Search  
				chargeForAuditRS = dbDao.searchChargeForAudit(chargeForAuditParmVOs[i]);				
				chargeForAuditVO.setCntrTpszCd(chargeForAuditRS.getCntrTpszCd());
				chargeForAuditVO.setCalFromDt(chargeForAuditRS.getCalFromDt());
				chargeForAuditVO.setCalToDt(chargeForAuditRS.getCalToDt());
				chargeForAuditVO.setCalFtEnd(chargeForAuditRS.getCalFtEnd());
				chargeForAuditVO.setCalOver(chargeForAuditRS.getCalOver());
				chargeForAuditVO.setCurrCd(chargeForAuditRS.getCurrCd());
				chargeForAuditVO.setCalCollection(chargeForAuditRS.getCalCollection());
				chargeForAuditVO.setFmMvmtYdCd(chargeForAuditRS.getFmMvmtYdCd());
				chargeForAuditVO.setFtCmncDt(chargeForAuditRS.getFtCmncDt());
				chargeForAuditVO.setFtDys(chargeForAuditRS.getFtDys());
				chargeForAuditVO.setScNo(chargeForAuditRS.getScNo());
				chargeForAuditVO.setRfaNo(chargeForAuditRS.getRfaNo());
				chargeForAuditVO.setExceptionAmt(chargeForAuditRS.getExceptionAmt());
				chargeForAuditVO.setAftExptAmt(chargeForAuditRS.getAftExptAmt());
				chargeForAuditVO.setDmdtChgStsCd(chargeForAuditRS.getDmdtChgStsCd());
				chargeForAuditVO.setSvrId(chargeForAuditRS.getSvrId());
				chargeForAuditVO.setCntrCycNo(chargeForAuditRS.getCntrCycNo());
				chargeForAuditVO.setDmdtTrfCd(chargeForAuditRS.getDmdtTrfCd());
				chargeForAuditVO.setDmdtChgLocDivCd(chargeForAuditRS.getDmdtChgLocDivCd());
				chargeForAuditVO.setChgSeq(chargeForAuditRS.getChgSeq());
				
				//2. excel loading data
				chargeForAuditVO.setCntrNo(chargeForAuditParmVOs[i].getCntrNo());
				chargeForAuditVO.setTFromDt(chargeForAuditParmVOs[i].getTFromDt());
				chargeForAuditVO.setTToDt(chargeForAuditParmVOs[i].getTToDt());
				chargeForAuditVO.setTFtEnd(chargeForAuditParmVOs[i].getTFtEnd());
				chargeForAuditVO.setTOver(chargeForAuditParmVOs[i].getTOver());
				chargeForAuditVO.setTCollection(chargeForAuditParmVOs[i].getTCollection());
				
				//3. change setting 
				if(pLoadOptInput.equals("1")){ //VVD
					chargeForAuditVO.setVvd(chargeForAuditParmVOs[i].getVvd());
					chargeForAuditVO.setBkgNo(chargeForAuditRS.getBkgNo());
					chargeForAuditVO.setBlNo(chargeForAuditRS.getBlNo());
					
				} else if(pLoadOptInput.equals("2")){ //B/L NO
					chargeForAuditVO.setBlNo(chargeForAuditParmVOs[i].getBlNo());
					chargeForAuditVO.setBkgNo(chargeForAuditRS.getBkgNo());
					chargeForAuditVO.setVvd(chargeForAuditRS.getVvd());
					
				} else if(pLoadOptInput.equals("3")){ //BKG NO
					chargeForAuditVO.setBkgNo(chargeForAuditParmVOs[i].getBkgNo());
					chargeForAuditVO.setBlNo(chargeForAuditRS.getBlNo());
					chargeForAuditVO.setVvd(chargeForAuditRS.getVvd());
				}
							
				//4. save to VOs 
				chargeForAuditVOS.add(chargeForAuditVO);
			}

			return chargeForAuditVOS;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
}
