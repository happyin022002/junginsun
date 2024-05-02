/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InboundNoticeBCImpl.java
*@FileTitle : Arrival Notice Form Setting tab#1
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic;
 
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration.ArrivalNoticeDBDAO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration.InboundNoticeEAIDAO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustCodeErrListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustCodeErrSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustRefVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustUploadListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcGrpSendListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcGrpSendVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcInfoListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcMrdSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcMrdVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcSendListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcWdVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrivalNoticeSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.BkgNtcSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.CustCdEvaluationVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.CustCdValidationVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.FaxSendVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.IbCustCntcHisVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.IbCustCntcVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.IntgCustSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.MdmCustomerVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.MrnRtnYdVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.NoticeVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.RDMailSendVO;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.backend.support.BackEndJobException;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.backend.support.BackEndJobResult;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.framework.table.ComRptDsgnXptInfoVO;
import com.clt.syscommon.common.table.BkgArrNtcCntrVO;
import com.clt.syscommon.common.table.BkgArrNtcDtlVO;
import com.clt.syscommon.common.table.BkgArrNtcVO;
import com.clt.syscommon.common.table.BkgArrNtcWdDtlVO;
import com.clt.syscommon.common.table.BkgArrNtcWdVO;
import com.clt.syscommon.common.table.BkgCustTmpltVO;
import com.clt.syscommon.common.table.BkgIbCmdtCntcVO;
import com.clt.syscommon.common.table.BkgIbCustCntcHisVO;
import com.clt.syscommon.common.table.BkgIbCustCntcStupHisVO;
import com.clt.syscommon.common.table.BkgIbCustCntcStupVO;
import com.clt.syscommon.common.table.BkgIbCustCntcVO;
import com.clt.syscommon.common.table.BkgMdmCrCustVO;
import com.clt.syscommon.common.table.BkgNtcHisVO;
import com.clt.syscommon.common.table.BkgTroActCustVO;
import com.clt.syscommon.common.table.ComUserVO;

/**  
 *   ArrivalNoticeBCImpl
 *   InboundNoticeMgt Business Logic Basic Command implementation<br>
 * - InboundNoticeMgt business logic handling<br>
 * 
 * @author
 * @see EventResponse,ArrivalNoticeBC each DAO Class reference
 * @since J2EE 1.4
 */
public class ArrivalNoticeBCImpl extends BasicCommandSupport implements ArrivalNoticeBC {

	// Database Access Object
	private transient ArrivalNoticeDBDAO dbDao = null;
	
	private transient InboundNoticeEAIDAO eaiDao = null;
	/**
	 * InboundNoticeBCImpl object creation<br>
	 * InboundNoticeDBDAO creation<br>
	 */
	public ArrivalNoticeBCImpl() {
		dbDao = new ArrivalNoticeDBDAO();
		eaiDao = new InboundNoticeEAIDAO();
	}
	

	/**
	 * UI_BKG-0375 Arrival Notice Form Setup<br>
     * retrieve Arrival Notice Form 
	 * @param String ofcCd
	 * @param String pod
	 * @param String agent
	 * @return ArrNtcWdVO
	 * @exception EventException
	 */
	public ArrNtcWdVO searchArrNtcForm ( String ofcCd , String pod , String agent )  throws EventException {
		ArrNtcWdVO arrNtcWdVO = new ArrNtcWdVO();
		try {
			// Search Master 
			arrNtcWdVO.setBkgArrNtcWdVO(dbDao.searchArrNtcForm(ofcCd, pod, agent));
			if (arrNtcWdVO.getBkgArrNtcWdVO() != null) {
				// if master exists : search Detail
				List<BkgArrNtcWdDtlVO> bkgArrNtcWdDtlList = dbDao.searchArrNtcFormDtls(arrNtcWdVO.getBkgArrNtcWdVO().getAnSeq());
				BkgArrNtcWdDtlVO[] bkgArrNtcWdDtlVOs = new BkgArrNtcWdDtlVO[bkgArrNtcWdDtlList.size()];
				bkgArrNtcWdDtlList.toArray(bkgArrNtcWdDtlVOs);
				arrNtcWdVO.setBkgArrNtcWdDtlVOs(bkgArrNtcWdDtlVOs);
			}
        }catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
        
        return arrNtcWdVO;
	}
	
	
	/**
	 * UI_BKG-0375 Arrival Notice Form Setup<br>
	 * retrieve registered POD list at Arrival Notice Form 
	 * @param String ofcCd
	 * @return List<BkgArrNtcWdVO>
	 * @exception EventException
	 */
	public List<BkgArrNtcWdVO> searchArrNtcFormPodList(String ofcCd) throws EventException {
		try {
			List<BkgArrNtcWdVO> list = dbDao.searchArrNtcFormPodList(ofcCd);
			return list;
        }catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
	}

	/**
	 * UI_BKG-0375 Arrival Notice Form Setup<br>
	 * retrieve registered Agent list at Arrival Notice Form 
	 * @param String ofcCd
	 * @param String podCd
	 * @return List<BkgArrNtcWdVO>
	 * @exception EventException
	 */
	public List<BkgArrNtcWdVO> searchArrNtcFormAgentList(String ofcCd,String podCd) throws EventException {
		try {
			List<BkgArrNtcWdVO> list = dbDao.searchArrNtcFormAgentList(ofcCd, podCd);
			return list;
        }catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
	}

	
	/**
     * UI-BKG_0375 Arrival Notice Form Setup<br>
     * modify Arrival Notice Form Data
     * Modify the master and detail at the same time.
	 * @param BkgArrNtcWdVO arrNtcWd
	 * @param BkgArrNtcWdDtlVO[] arrNtcWdDtls
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String setupArrNtcForm(BkgArrNtcWdVO arrNtcWd, BkgArrNtcWdDtlVO[] arrNtcWdDtls, SignOnUserAccount account) throws EventException{
		String anSeq = null;
		try {
			BkgArrNtcWdVO bkgArrNtcWdVOQry = dbDao.searchArrNtcForm(arrNtcWd.getOfcCd(), arrNtcWd.getPodCd(), arrNtcWd.getChnAgnCd());
			if (bkgArrNtcWdVOQry != null && bkgArrNtcWdVOQry.getAnSeq() != null) {
				anSeq = bkgArrNtcWdVOQry.getAnSeq() ; // default sequence
			}
			if (anSeq != null && !anSeq.equals("") && !anSeq.equals("0")) { // modify
				/* update master */
				arrNtcWd.setAnSeq(anSeq);
				arrNtcWd.setCreUsrId(account.getUsr_id());
				dbDao.modifyArrNtcForm(arrNtcWd);
				for (int i = 0 ; i<arrNtcWdDtls.length; i++)
				{
					/* update detail */
					arrNtcWdDtls[i].setAnSeq(anSeq);
					arrNtcWdDtls[i].setCreUsrId(account.getUsr_id());
					arrNtcWdDtls[i].setUpdUsrId(account.getUsr_id());
					dbDao.modifyArrNtcFormDtl(arrNtcWdDtls[i]);
				}
				
			} else {  // create
				/* retrieve new sequence */
				anSeq = dbDao.searchArrNtcFomMaxSeq();
				arrNtcWd.setAnSeq(anSeq);
				
				/* add  master */
				arrNtcWd.setCreUsrId(account.getUsr_id());
				dbDao.addArrNtcForm(arrNtcWd);
				
				for (int i = 0 ; i<arrNtcWdDtls.length; i++)
				{
					/* add detail */
					arrNtcWdDtls[i].setAnSeq(anSeq);
					arrNtcWdDtls[i].setCreUsrId(account.getUsr_id());
					dbDao.addArrNtcFormDtl(arrNtcWdDtls[i]);
				}
			}

        }catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00110").getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00110").getMessage(), ex);
        }
		return anSeq;
	}
	
	/**
	 * UI_BKG-0375 Arrival Notice Form Setup<br>
	 * delete Arrival notice Form
	 * @param String ofcCd
	 * @param String podCd
	 * @param String agentCd
	 * @exception EventException
	 */
	public void removeArrNtcForm(String ofcCd, String podCd, String agentCd) throws EventException
	{
		try {
			String[] anSeqs = dbDao.searchRemoveForm(ofcCd,podCd, agentCd);
			
			if (anSeqs != null && anSeqs.length > 0) {
				for (int idx = 0; idx < anSeqs.length; idx ++) {
					dbDao.removeArrNtcFormDtl(anSeqs[idx]);
					/* remove master */
					dbDao.removeArrNtcForm(anSeqs[idx]);
				}
				
			}
			
        }catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00110").getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00110").getMessage(), ex);
        }
		
	}
	/**
	 * [240-1]ESM_BKG_0240 retrieve event handling about Customer Main (MDM) Master<br>
	 * @param IntgCustSearchVO intgCustSearchVo
	 * @return IbCustCntcVO
	 * @exception EventException
	 */
	public IbCustCntcVO searchIntgCustCntcInfo (IntgCustSearchVO intgCustSearchVo ) throws EventException {
		
		try {			
			
			IbCustCntcVO bkgIbCustCntcVO = new IbCustCntcVO();
			
			//Master retrieve			
			List<MdmCustomerVO> mdmCustomerVOs = dbDao.searchMdmCustList(intgCustSearchVo);
			bkgIbCustCntcVO.setMdmCustomerVO(mdmCustomerVOs);			
			
			if(mdmCustomerVOs.size() == 1){
				MdmCustomerVO mdmCustomerVO = mdmCustomerVOs.get(0);
				String custCntCd = mdmCustomerVO.getCustCntCd();
				String custSeq = mdmCustomerVO.getCustSeq();
				String ofcCd = intgCustSearchVo.getLoginOfcCd();
				//Detail retrieve
				
				List<IbCustCntcVO> detailBkgIbCustCntcVO = searchIntgCustCntcInfoByIB(custCntCd, custSeq, ofcCd);
				bkgIbCustCntcVO.setDetailBkgIbCustCntcVO(detailBkgIbCustCntcVO);
				
			}			
			return bkgIbCustCntcVO;
			
		} catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }

	}

	/**
	 * ESM_BKG_0240 Customer Main Detail retrieve event handling<br>
	 * @param String custCntCd
	 * @param String custSeq
	 * @param String ofcCd
	 * @return List<IbCustCntcVO>
	 * @exception EventException
	 */
	public List<IbCustCntcVO> searchIntgCustCntcInfoByIB(String custCntCd,
			String custSeq, String ofcCd) throws EventException {
		
		try{
			List<IbCustCntcVO> detailBkgIbCustCntcVO = dbDao.searchIntgCustCntcInfoByIB(custCntCd, custSeq, ofcCd);
			log.debug("------------   detailBkgIbCustCntcVO.size()   " +detailBkgIbCustCntcVO.size());
			return detailBkgIbCustCntcVO;
		
		} catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }

	}

	/**
	 * [0240] Save routines
	 * @param BkgIbCustCntcVO[] custCntc
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageIntgCustCntcInfoByIB(BkgIbCustCntcVO[] custCntc, SignOnUserAccount account)
			throws EventException {
		// TODO Auto-generated method stub
		try {
			
			for(int i=0;i<custCntc.length;i++){
				BkgIbCustCntcHisVO hisVO = new BkgIbCustCntcHisVO();
				
				custCntc[i].setCreUsrId(account.getUsr_id());
				custCntc[i].setUpdUsrId(account.getUsr_id());

				//History Data set
				hisVO.setCreUsrId(account.getUsr_id());
				hisVO.setUpdUsrId(account.getUsr_id());
				hisVO.setCustCntCd(custCntc[i].getCustCntCd());
				hisVO.setCustSeq(custCntc[i].getCustSeq());
				hisVO.setCustCntcTpCd(custCntc[i].getCustCntcTpCd());
				hisVO.setOfcCd(custCntc[i].getOfcCd());
				
				hisVO.setCngUsrId(account.getUsr_id());									

				if(!(dbDao.modifyIntgCustCntcInfo(custCntc[i]) > 0)){
					dbDao.addIntgCustCntctInfo(custCntc[i],account); 
				}
				
				// HISTORY 
				custCntc[i].setCntcEml(custCntc[i].getIbflag().equals("D")?"":custCntc[i].getCntcEml());
				custCntc[i].setFaxNo(custCntc[i].getIbflag().equals("D")?"":custCntc[i].getFaxNo());
				log.debug("------------------------------------");
				log.debug("custCntc[i].getIbflag()    "+custCntc[i].getIbflag());
				log.debug("custCntc[i].getCntcEmlOrg()    "+custCntc[i].getCntcEmlOrg());
				log.debug("custCntc[i].getCntcEml()    "+custCntc[i].getCntcEml());
				log.debug("------------------------------------");
				
				//modify Email
				if(!custCntc[i].getCntcEml().equals(custCntc[i].getCntcEmlOrg())){					
					hisVO.setOldCntcCtnt(custCntc[i].getCntcEmlOrg());					
					hisVO.setNewCntcCtnt(custCntc[i].getCntcEml());
					hisVO.setSndSelFlg("");
					
					hisVO.setCntcViaCd("M");
					hisVO.setAutoMnlFlg("N");
					dbDao.addIntgCustCntcInfoHistory(hisVO,account);		
				}
				//modifyFax
				if(!custCntc[i].getFaxNo().equals(custCntc[i].getFaxNoOrg())){
					hisVO.setOldCntcCtnt(custCntc[i].getFaxNoOrg());					
					hisVO.setNewCntcCtnt(custCntc[i].getFaxNo());	
					hisVO.setSndSelFlg("");
	
					hisVO.setCntcViaCd("F");
					hisVO.setAutoMnlFlg("N");
					dbDao.addIntgCustCntcInfoHistory(hisVO,account);		
				}
				//modify Email Flag
				if(!custCntc[i].getFaxSndFlg().equals(custCntc[i].getFaxSndFlgOrg())){
					hisVO.setOldCntcCtnt("");					
					hisVO.setNewCntcCtnt("");
					hisVO.setSndSelFlg(custCntc[i].getFaxSndFlg());
					
					hisVO.setCntcViaCd("M");					
					hisVO.setAutoMnlFlg("N");
					dbDao.addIntgCustCntcInfoHistory(hisVO,account);
				}
				//modify Fax Flag
				if(!custCntc[i].getEmlSndFlg().equals(custCntc[i].getEmlSndFlgOrg())){
					hisVO.setOldCntcCtnt("");					
					hisVO.setNewCntcCtnt("");
					hisVO.setSndSelFlg(custCntc[i].getEmlSndFlg());
					
					hisVO.setCntcViaCd("F");					
					hisVO.setAutoMnlFlg("N");
					dbDao.addIntgCustCntcInfoHistory(hisVO,account);
				}
				
				
			}		
			
		} catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }

	}

	/**
	 *  Integrated Customer Data Management(OB) Detail retrieve
	 * @param String custCntCd
	 * @param String custSeq
	 * @return List<BkgCustTmpltVO>
	 * @exception EventException
	 */
	public List<BkgCustTmpltVO> searchIntgCustCntcInfoByOB(String custCntCd,
			String custSeq) throws EventException {
		try{
			List<BkgCustTmpltVO> bkgCustTmpltVO = dbDao.searchIntgCustCntcInfoByOB(custCntCd, custSeq);
			
			return bkgCustTmpltVO;
		
		} catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }

	}
	/**
	 *  Integrated Customer Data Management(Invoice) Detail retrieve
	 * @param String custCntCd
	 * @param String custSeq
	 * @return  List<BkgMdmCrCustVO>
	 * @exception EventException
	 */
	public List<BkgMdmCrCustVO> searchIntgCustCntcInfoByInvoice(String custCntCd,
			String custSeq) throws EventException {
		try{
			List<BkgMdmCrCustVO> mdmCrCustVO = dbDao.searchIntgCustCntcInfoByInvoice(custCntCd, custSeq);
			
			return mdmCrCustVO;
		
		} catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }

	}
	
	/**
	 *  Integrated Customer Data Management(TRO) Detail retrieve
	 * @param String custCntCd
	 * @param String custSeq 
	 * @return List<BkgTroActCustVO> 
	 * @exception EventException
	 */
	public List<BkgTroActCustVO> searchIntgCustCntcInfoByTRO(String custCntCd,
			String custSeq) throws EventException {
		try{
			List<BkgTroActCustVO> bkgTroActCustVO = dbDao.searchIntgCustCntcInfoByTRO(custCntCd, custSeq);
			
			return bkgTroActCustVO;
		
		} catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }

	}


	/**
	 * Arrival Information [Arrival Date] Paging retrieve
	 * [672-1]
	 * @param ArrNtcSearchVO arrNtcSearch
	 * @param SignOnUserAccount account
	 * @return List<ArrNtcInfoListVO> 
	 * @exception EventException
	 */
	public List<ArrNtcInfoListVO> searchArrNtcInfoList(ArrNtcSearchVO arrNtcSearch,SignOnUserAccount account) throws EventException {
		try {
			List<ArrNtcInfoListVO> arrNtcVO = dbDao	.searchArrNtcInfoList(arrNtcSearch,account);
			List<ArrNtcInfoListVO> nArrNtcVO = new ArrayList<ArrNtcInfoListVO>();
			
			if(arrNtcVO.size() > 0){
				int cnt = arrNtcVO.size();
				
				log.debug("----------------------------------------");
				log.debug("cnt  "+cnt);
				log.debug("----------------------------------------");
				
				
				ArrNtcInfoListVO titleArrNtcVO = new ArrNtcInfoListVO();
				titleArrNtcVO.setVvd(arrNtcVO.get(0).getVvd());
				
				if(cnt <= 400){
					nArrNtcVO.add(titleArrNtcVO);
					log.debug("---------------------- 400 보다 적다");
					for(int x=0;x<arrNtcVO.size()-1;x++){					
						String currVvd = arrNtcVO.get(x).getVvd();
						String nextVvd = arrNtcVO.get(x+1).getVvd();					
						
						nArrNtcVO.add(arrNtcVO.get(x));
						
						if(!currVvd.equals(nextVvd)){
							titleArrNtcVO = new ArrNtcInfoListVO();
							titleArrNtcVO.setVvd(nextVvd);						
							nArrNtcVO.add(titleArrNtcVO);						
						}
						
						
					}
					nArrNtcVO.add(arrNtcVO.get(arrNtcVO.size()-1));
				}else{
					log.debug("---------------------- 400 보다 크다");
					for(int x=0;x<arrNtcVO.size()-1;x++){					
						
						nArrNtcVO.add(arrNtcVO.get(x));
						
					}
					nArrNtcVO.add(arrNtcVO.get(arrNtcVO.size()-1));
				}
				
				if(nArrNtcVO != null && nArrNtcVO.size() > 0){
					nArrNtcVO.get(0).setMaxRows(cnt);
				}
				
				log.debug("-----------------------------------//group by 있도록 조회 [ " + arrNtcVO.size() + "]");				
			}
			return nArrNtcVO;

		}catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
	}

	/**
     * UI-BKG-1054 Customer Code Validation<br>
     * return created Key at Background Job after starting Customer Code Validation
	 * @param ArrNtcSearchVO anSearch
	 * @return String backEndJobKey
	 * @exception EventException
	 */
	public String manageArrNtcCodeValidation(ArrNtcSearchVO anSearch) throws EventException{
		String backendJobKey = null;
		try {
			CodeValidationBackEndJob command = new CodeValidationBackEndJob();
	        command.setArrNtcSearchVO(anSearch);
	
	        BackEndJobManager backEndJobManager = new BackEndJobManager();
	        backendJobKey = backEndJobManager.execute(command, anSearch.getValUsrId(), "ESM_BKG_1054 Customer Code Validation");
		
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }

        return backendJobKey;
	}

	/**
     * UI-BKG-1054 Customer Code Validation<br>
     * retrieve  information corresponding to unmatch after Customer Code Validation
	 * @param ArrNtcSearchVO arrNtcSearch
	 * @param SignOnUserAccount account
	 * @return List<CustCdValidationVO> codeValidations
	 * @exception EventException
	 */
	public List<CustCdValidationVO> searchArrNtcUnMatchCustList(ArrNtcSearchVO arrNtcSearch, SignOnUserAccount account) throws EventException {
		try {
			if (arrNtcSearch.getPageNo() == null || arrNtcSearch.getPageNo().equals("") ||  Integer.valueOf( arrNtcSearch.getPageNo()).intValue() == 0) {
				arrNtcSearch.setPageNo("1");
			}
			arrNtcSearch.setUsrId(account.getUsr_id());
			arrNtcSearch.setOfcCd(account.getOfc_cd());
			return dbDao.searchArrNtcUnMatchCustList(arrNtcSearch);
			
        }catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
	}

	/**
     * UI-BKG-1054 Customer Code Validation <br>
     * retrieve  information corresponding to unmatch after Customer Code Validation
	 * @param ArrNtcSearchVO anSearch
	 * @param SignOnUserAccount account
	 * @return List<CustCdValidationVO> 
	 * @exception EventException
	 */
	public List<CustCdValidationVO> searchManualValInfo(ArrNtcSearchVO anSearch, SignOnUserAccount account) throws EventException {
		try {
			if (anSearch.getPageNo() == null || anSearch.getPageNo().equals("") ||  Integer.valueOf( anSearch.getPageNo()).intValue() == 0) {
				anSearch.setPageNo("1");
			}
			anSearch.setUsrId(account.getUsr_id());
			anSearch.setOfcCd(account.getOfc_cd());
			return dbDao.searchManualValInfo(anSearch);
			
	    }catch (DAOException de) {
	        throw new EventException(new ErrorHandler("BKG00450").getMessage(), de);
	    }catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
	    }
	}

	/**
     * UI-BKG-1054 Customer Code Validation <br>
     * retrieve  information corresponding to match after Customer Code Validation
	 * @param ArrNtcSearchVO arrNtcSch
	 * @return List<CustCdValidationVO>
	 * @exception EventException
	 */
	public List<CustCdValidationVO> searchArrNtcMatchCustList(ArrNtcSearchVO arrNtcSch) throws EventException {
		try {
			return dbDao.searchArrNtcMatchCustList(arrNtcSch);
        }catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
	}
	
	/**
     * UI-BKG-1054 Customer Code Validation<br>
     * update unmatched information after Customer Code Validation
     * create Arrival Notice master and Detail
     * @author
	 * @param CustCdEvaluationVO[] custCdEvaluationVos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageArrNtcUnMatchCust(CustCdEvaluationVO[] custCdEvaluationVos, SignOnUserAccount account) throws EventException {
		try {
			
			List<CustCdEvaluationVO> custCdEvaluations = new ArrayList<CustCdEvaluationVO>();
			for (int i= 0; i < custCdEvaluationVos.length; i ++) {
				custCdEvaluationVos[i].setUsrId(account.getUsr_id());  // val_usr_id
				custCdEvaluationVos[i].setOfcCd(account.getOfc_cd());  // val_office_cd
				custCdEvaluations.add(custCdEvaluationVos[i]);
			}

			dbDao.addArrNtcValInfo(custCdEvaluations);
			dbDao.addArrNtcDtlValInfo(custCdEvaluations);

        }catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), ex);
        }
	}

	/**
     * UI_BKG-1054 Customer Code Validation<br>
     * matched information changes unmatch after Customer Code Validation
     * delete Arrival Notice master and Detail
     * update Match information<br>
	 * @param CustCdEvaluationVO[] custCdEvals
	 * @exception EventException
	 */
	public void cancelArrNtcCustCdVal(CustCdEvaluationVO[] custCdEvals) throws EventException {
		try {
			
			if (custCdEvals.length > 0) {
				dbDao.removeArrNtcDtlByCustCdVal(custCdEvals[0].getBkgNo(), custCdEvals[0].getBkgCustTpCd());
				dbDao.removeArrNtcByCustCdVal(custCdEvals[0].getBkgNo());
			}

        }catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 * BL Copy &amp; Customer Info Update<br>
	 * delete Arrival Notice Master and Arrival Notice Detail
	 * @author
	 * @param String bkgNo
	 * @throws EventException
	 */
	public void cancelArrNtcCustCdVal(String bkgNo) throws EventException {
		try {
			
			dbDao.removeArrNtcDtlByCustCdVal(bkgNo , "C");
			dbDao.removeArrNtcDtlByCustCdVal(bkgNo , "N");
			dbDao.removeArrNtcByCustCdVal(bkgNo);

        }catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), ex);
        }
	}

	
	/**
     * UI-BKG-0941 Customer code Error Report<br>
     * retrieve Customer Code Error Report 
	 * @param ArrNtcCustCodeErrSearchVO arrNtcCustCodeErrSearch
	 * @return List<ArrNtcCustCodeErrLstVO>
	 * @exception EventException
	 */
	public List<ArrNtcCustCodeErrListVO> searchArrNtcCustCodeErrReport(ArrNtcCustCodeErrSearchVO arrNtcCustCodeErrSearch) throws EventException {
		try {
			
			return dbDao.searchArrNtcCustCodeErrReport(arrNtcCustCodeErrSearch);

        }catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		
	}
	
	/**
     * UI-BKG-0001 Notice Sent History<br>
     * extract Inbound Arrival Notice information using Bkg Notice History
	 * @param BkgNtcSearchVO bkgNtcSearch
	 * @return List<NoticeVO>
	 * @exception EventException
	 */
	public List<NoticeVO> searchBkgNtcHis (BkgNtcSearchVO bkgNtcSearch) throws EventException {
		try {
			return dbDao.searchBkgNtcHis(bkgNtcSearch);
        }catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
	}


	/**
	 * [243] AN Setup Screen_Arrival Info.
	 * retrieve entered letter and information by Grouped VVD / POD at Setup
	 * @param String ofcCd
	 * @param String podCd
	 * @param String formCd
	 * @param String agent
	 * @return List<BkgArrNtcWdDtlVO>
	 * @exception EventException 
	 */
	public List<BkgArrNtcWdDtlVO> searchArrNtcFormDtl(String ofcCd, String podCd,
			String formCd,String agent) throws EventException {
		try {
			return dbDao.searchArrNtcFormDtl(ofcCd, podCd,formCd,agent);

		} catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }

	}
	
	/**
	 * UI_BKG-0672-1
	 * save Arrival Notice (Arrival Information)
	 * @param BkgArrNtcVO[] arrNtcs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void setupArrNtcInfoList(ArrNtcInfoListVO[] arrNtcInfos , SignOnUserAccount account ) throws EventException{
		
		try {
			log.debug("--------- arrNtcInfos.size() "+arrNtcInfos.length);
			List<BkgArrNtcVO> bkgArrNtcVOs = new ArrayList<BkgArrNtcVO>();
			
			for (int i = 0; i < arrNtcInfos.length; i++) {
				BkgArrNtcVO bkgArrNtcVO = new BkgArrNtcVO();
				bkgArrNtcVO.setUpdUsrId(account.getUsr_id());
					
					if(   (arrNtcInfos[i].getIsValidated() != null && arrNtcInfos[i].getIsValidated().equals("Y"))
							&& (arrNtcInfos[i].getBlNo() != null && !arrNtcInfos[i].getBlNo().equals(""))
							){							
						ObjectCloner.build(arrNtcInfos[i], bkgArrNtcVO);
						bkgArrNtcVOs.add(bkgArrNtcVO);
					}
			}
			if(bkgArrNtcVOs.size() > 0){
				dbDao.modifyArrNtcInfo (bkgArrNtcVOs);
			}

		}catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), ex);
        }
	}
	

	/**[0052]Arrival Notice Yard information retrieve
	 * @param String vvd
	 * @param String podCd
	 * @return List<MrnRtnYdVO>
	 * @exception EventException 
	 */
	public List<MrnRtnYdVO> searchArrNtcMrnRtnYd(String vvd, String podCd) throws EventException {
		// TODO Auto-generated method stub
		
		List<MrnRtnYdVO> retList = null;
		log.debug("Impl 0052 podCd " + podCd);
		try {
			if("BEANR".equals(podCd)){
				retList= dbDao.searchArrNtcAnrMrnRtnYd (vvd);
			}else if("NLRTM".equals(podCd)){
				retList= dbDao.searchArrNtcRtmMrnRtnYd (vvd);
			}
		}catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		return retList;
	}
	/**[0052]save MRN & Return yard information
	 * @param MrnRtnYdVO[] mrnRtnYdVOS
	 * @param SignOnUserAccount account 
	 * @exception EventException 
	 */
	public void setupArrNtcMrnRtnYd(MrnRtnYdVO[] mrnRtnYdVOS, SignOnUserAccount account) throws EventException {
		try{
			for (int i = 0; i < mrnRtnYdVOS.length; i++) {
				MrnRtnYdVO mrnRtnYdVO = mrnRtnYdVOS[i];							
				if (dbDao.modifyArrNtcMrnRtnYd(mrnRtnYdVO,account) == 0) {
					dbDao.addArrNtcMrnRtnYd(mrnRtnYdVO,account);
				}
			}
			
		}catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 * [672-02]Customer information retrieve
	 * @param ArrNtcSearchVO search
	 * @param SignOnUserAccount account
	 * @return List<ArrNtcCustListVO>
	 * @exception EventException
	 */
	public List<ArrNtcCustListVO> searchArrNtcCustList(ArrNtcSearchVO search, SignOnUserAccount account)
			throws EventException {
		// TODO Auto-generated method stub
		List<ArrNtcCustListVO> retList = null;

		
		try {
			//log.debug("------------------ " + search.getColumnValues());
			retList = dbDao.searchArrNtcCustList(search,account);
		}catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }

		return retList;
	}
	/**
	 * [672-02]save Customer information
	 * @param ArrNtcCustListVO[] arrNtcCustListVOS
	 * @param SignOnUserAccount account
	 * @exception Exception
	 */
	public void modifyArrNtcCustList(ArrNtcCustListVO[] arrNtcCustListVOS,
			SignOnUserAccount account) throws Exception {
		try {
			for (int i = 0; i < arrNtcCustListVOS.length; i++) {
				ArrNtcCustListVO arrNtcCustListVO = arrNtcCustListVOS[i];
				BkgArrNtcDtlVO bkgArrNtcDtlVO = new BkgArrNtcDtlVO(); 
				
				String faxNo = "";
				String eml = "";
				
				arrNtcCustListVO.setUpdUsrId(account.getUsr_id());
				int modifyRowCnt = 0;
				
				arrNtcCustListVO.setCustCntcTpCd("C1");
				faxNo = arrNtcCustListVO.getFax1();
				eml = arrNtcCustListVO.getEml1();
				
				arrNtcCustListVO.setFaxNo(faxNo);
				arrNtcCustListVO.setNtcEml(eml);
				
				
				ObjectCloner.build(arrNtcCustListVO ,bkgArrNtcDtlVO);
				modifyRowCnt = dbDao.modifyArrNtcDtls(bkgArrNtcDtlVO,account);
				if(modifyRowCnt == 0 ){					
					dbDao.addArrNtcDtls(bkgArrNtcDtlVO, account);
					
					if(faxNo.equals("") && eml.equals("")){
						dbDao.removeArrNtcDtls(bkgArrNtcDtlVO);
					}
					
					
				}

				arrNtcCustListVO.setCustCntcTpCd("C2");
				faxNo = arrNtcCustListVO.getFax2();
				eml = arrNtcCustListVO.getEml2();
				
				arrNtcCustListVO.setFaxNo(faxNo);
				arrNtcCustListVO.setNtcEml(eml);
				
				ObjectCloner.build(arrNtcCustListVO ,bkgArrNtcDtlVO);
				modifyRowCnt = dbDao.modifyArrNtcDtls(bkgArrNtcDtlVO,account);
				
				if(modifyRowCnt == 0 ){
					
					dbDao.addArrNtcDtls(bkgArrNtcDtlVO, account);
					if(faxNo.equals("") && eml.equals("")){
						dbDao.removeArrNtcDtls(bkgArrNtcDtlVO);
					}
					
				}

				arrNtcCustListVO.setCustCntcTpCd("B1");
				faxNo = arrNtcCustListVO.getFax3();
				eml = arrNtcCustListVO.getEml3();
				
				arrNtcCustListVO.setFaxNo(faxNo);
				arrNtcCustListVO.setNtcEml(eml);
				
				ObjectCloner.build(arrNtcCustListVO ,bkgArrNtcDtlVO);
				modifyRowCnt = dbDao.modifyArrNtcDtls(bkgArrNtcDtlVO,account);
				if(modifyRowCnt == 0 ){
					
					dbDao.addArrNtcDtls(bkgArrNtcDtlVO, account);
					if(faxNo.equals("") && eml.equals("")){
						dbDao.removeArrNtcDtls(bkgArrNtcDtlVO);
					}
					
				}

				arrNtcCustListVO.setCustCntcTpCd("B2");
				faxNo = arrNtcCustListVO.getFax4();
				eml = arrNtcCustListVO.getEml4();
				
				arrNtcCustListVO.setFaxNo(faxNo);
				arrNtcCustListVO.setNtcEml(eml);
				
				ObjectCloner.build(arrNtcCustListVO ,bkgArrNtcDtlVO);
				modifyRowCnt = dbDao.modifyArrNtcDtls(bkgArrNtcDtlVO,account);
				if(modifyRowCnt == 0 ){
					
					dbDao.addArrNtcDtls(bkgArrNtcDtlVO, account);
					if(faxNo.equals("") && eml.equals("")){
						dbDao.removeArrNtcDtls(bkgArrNtcDtlVO);
					}
					
				}

				arrNtcCustListVO.setCustCntcTpCd("AN");
				
				faxNo = arrNtcCustListVO.getFax5();
				eml = arrNtcCustListVO.getEml5();
				
				arrNtcCustListVO.setFaxNo(faxNo);
				arrNtcCustListVO.setNtcEml(eml);
				
				ObjectCloner.build(arrNtcCustListVO ,bkgArrNtcDtlVO);
				modifyRowCnt = dbDao.modifyArrNtcDtls(bkgArrNtcDtlVO,account);
				if(modifyRowCnt == 0 ){
					
					dbDao.addArrNtcDtls(bkgArrNtcDtlVO, account);
					if(faxNo.equals("") && eml.equals("")){
						dbDao.removeArrNtcDtls(bkgArrNtcDtlVO);
					}
				}
				
				
			}
		}catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), ex);
        }

	}
	
	/**
	 * [672-03]Customer upload information retrieve
	 * @param ArrNtcSearchVO arrNtcSearchVO
	 * @return List<ArrNtcCustUploadListVO>
	 * @exception EventException
	 */
	public List<ArrNtcCustUploadListVO> searchArrNtcCustListForUpload(ArrNtcSearchVO arrNtcSearchVo) throws EventException {
		// TODO Auto-generated method stub
		List<ArrNtcCustUploadListVO> retList = null;
		try {
			
			retList = dbDao.searchArrNtcCustListForUpload(arrNtcSearchVo);
			
			
		}catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		return retList;
	}
	
	/**
	 * [672-03]add Customer upload informatio
	 * @param BkgArrNtcDtlVO bkgArrNtcDtlVo
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 * @exception Exception
	 */
	public void createArrNtcCustListbyUpload(BkgArrNtcDtlVO bkgArrNtcDtlVo,SignOnUserAccount account) throws DAOException, Exception{
		
		
		
		int modifyRowCnt = 0;
		try{
			modifyRowCnt = dbDao.modifyArrNtcDtls(bkgArrNtcDtlVo, account);		
			
			if(modifyRowCnt == 0 ){
				dbDao.addArrNtcDtls(bkgArrNtcDtlVo, account);
			}
		}catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), ex);
        }
	}	


	/**[242] retrieve specific information by customer that receives ARRIVAL NOTICE
	 * @param String bkgNo
	 * @param String custTpCd
	 * @return List<ArrNtcCustRefVO>
	 * @exception EventException 
	 */
	public List<ArrNtcCustRefVO> searchArrNtcCustInfo(String bkgNo,
			String custTpCd) throws EventException {
		// TODO Auto-generated method stub
		List<ArrNtcCustRefVO> retList = null;
		try {
			
			retList= dbDao.searchArrNtcCustInfo(bkgNo,custTpCd);
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);

		}catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);

		}
		return retList;
	}


	/**
     * UI-BKG-0764 Customer Data Management Update History<br>
	 * retrieve Inbount Customer information modification status
	 *  @author
	 *  @param  IbCustCntcHisVO ibCustCntcHis
	 *  @return List<IbCustCntcHisVO> ibCustCntcHis
	 *  @exception EventException
	 */
	public List<IbCustCntcHisVO> searchIntgCustCntcInfoHistory (IbCustCntcHisVO ibCustCntcHis) throws EventException{
		List<IbCustCntcHisVO> list = null;
		try {
			list = dbDao.searchIntgCustCntcInfoHistory(ibCustCntcHis);
		}catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), de);
		}catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
		return list;
	}
	
	
	/**
	 * 1021 Bank In Account No Setup for A/N<br>
	 * retrieve
	 * @param String ofcCd
	 * @return BkgArrNtcWdVO
	 * @exception EventException
	 * @author 
	 */
	public BkgArrNtcWdVO searchArrNtcBankAcct(String ofcCd) throws EventException
	{
		BkgArrNtcWdVO arrNtcBankAcctVO = null;
		try 
		{
			arrNtcBankAcctVO = dbDao.searchArrNtcBankAcct(ofcCd);
        }catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		return arrNtcBankAcctVO;
	}
	
	
	/**
	 * 1021 Bank In Account No Setup for A/N<br>
	 * modify 
	 * @param BkgArrNtcWdVO arrNtcBankAcct
	 * @param SignOnUserAccount account
	 * @exception EventException
	 * @author 
	 */
	public void setupArrNtcBankAcct(BkgArrNtcWdVO bkgArrNtcWdVo, SignOnUserAccount account)throws EventException
	{
		int result = 0;
		try 
		{
			
			bkgArrNtcWdVo.setCreUsrId(account.getUsr_id());
			bkgArrNtcWdVo.setUpdUsrId(account.getUsr_id());
			
			result = dbDao.modifyArrNtcBankAcct(bkgArrNtcWdVo);
			if(result == 0)
			{
				dbDao.addArrNtcBankAcct(bkgArrNtcWdVo);
			}
        }catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 * 1021 Bank In Account No Setup for A/N<br>
	 * delete
	 * @param String ofcCd
	 * @exception EventException
	 * @author 
	 */
	public void removeArrNtcBankAcct(String ofcCd)throws EventException
	{
		try 
		{
			dbDao.removeArrNtcBankAcct(ofcCd);
        }catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), ex);
        }
	}

	
	/**
	 * 1020 Group A/N Remark Template<br>
	 * retrieve
	 * @param String ofcCd
	 * @return BkgArrNtcWdVO
	 * @exception EventException
	 * @author 
	 */
	public List<BkgArrNtcWdVO> searchArrNtcGrpForm(String ofcCd) throws EventException
	{
		List<BkgArrNtcWdVO> bkgArrNtcWdVOs = null;
		try 
		{
			bkgArrNtcWdVOs = dbDao.searchArrNtcGrpForm(ofcCd);
        }catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		return bkgArrNtcWdVOs;
	}
	
	
	/**
	 * 1020 Group A/N Remark Template<br>
	 * add, delete, modify
	 * @param BkgArrNtcWdVO arrNtcWd
	 * @param SignOnUserAccount account
	 * @exception EventException
	 * @author 
	 */
	public void setupArrNtcGrpForm ( BkgArrNtcWdVO[] arrNtcWds ,SignOnUserAccount account )throws EventException
	{
		try{
			for(int i=0;i < arrNtcWds.length;i++){
				BkgArrNtcWdVO arrNtcWd = (BkgArrNtcWdVO)arrNtcWds[i];
				String flag = arrNtcWd.getIbflag();
				if("U".equals(flag)){
					dbDao.mergeArrNtcGrpForm(arrNtcWd, account);
				}
				else if("D".equals(flag)){
					dbDao.removeArrNtcForm(arrNtcWd.getAnSeq());
				}
			}
		
		
			
        }catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), ex);
        }
	}
	
	
	
	/**
	 * [0381] retrieve completed A/N History information
	 * @param ArrivalNoticeSearchVO arrivalNoticeSearchVo 
	 * @param SignOnUserAccount account
	 * @return List<ArrNtcSendListVO>
	 * @exception EventException 
	 */
	public List<ArrNtcSendListVO> searchArrNtcSendList(ArrivalNoticeSearchVO arrivalNoticeSearchVo,SignOnUserAccount account) throws EventException{
		// TODO Auto-generated method stub
		
		List<ArrNtcSendListVO> retList = null;
		try {
			
			retList= dbDao.searchArrNtcSendList(arrivalNoticeSearchVo,account);
			
		} catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }

		return retList;
	}
	
	
	/**
	 * 1044 Add Concerned Party Pop-up
	 * retrieve
	 * @param String ofcCd 
     * @param String custCd 
     * @param String custSeq
     * @param String custTpCd
     * @return List<BkgIbCmdtCntcVO>
	 * @exception EventException
	 * @author 
	 */
	public List<BkgIbCmdtCntcVO> searchCustCmdtCntcInfo( String ofcCd , String custCd , String custSeq, String custTpCd ) throws EventException
	{
		List<BkgIbCmdtCntcVO> list = null;
		try 
		{
			list = dbDao.searchCustCmdtCntcInfo(ofcCd, custCd, custSeq, custTpCd);
        }catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		return list;
	}
	
	
	/**
	 * 1044 Add Concerned Party Pop-up
	 * add, delete, modify
	 * @param BkgIbCmdtCntcVO[] ibCmdtCntcs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 * @author 
	 */
	public void manageCustCmdtCntcInfo( BkgIbCmdtCntcVO[] ibCmdtCntcs , SignOnUserAccount account ) throws EventException
	{
		
		try
		{
			for(int i=0;i<ibCmdtCntcs.length;i++)
			{
				BkgIbCmdtCntcVO ibCmdtCntc = ibCmdtCntcs[i];
				
				String flag = ibCmdtCntc.getIbflag();
				if("I".equals(flag))
				{
					ibCmdtCntc.setDeltFlg("N");
					dbDao.addCustCmdtCntctInfo(ibCmdtCntc, account);
				}
				else if("U".equals(flag))
				{
					dbDao.modifyCustCmdtCntcInfo(ibCmdtCntc, account);
				}
				else if("D".equals(flag))
				{
					dbDao.removeCustCmdtCntcInfo(ibCmdtCntc);
				}
			}
        }catch (DAOException de) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
	}
	/**
	 * [0381] Fax transmission
	 * @param ArrNtcSendListVO[] listVOS
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO> 
	 * @exception DAOException 
	 * @exception Exception 
	 */
	public List<BkgNtcHisVO> sendArrNtcByFax(ArrNtcSendListVO[] listVOS,
			SignOnUserAccount account) throws Exception {

		// 1.modifyArrNtcBySend;
		// 2.modifyArrNtcDtlBySend
		// 3.sendFax
		// 4.modifyArrNtcSendId
		// 5.return after creation BkgNtcHisVO 
		
		List<BkgNtcHisVO> hisVOS = new ArrayList<BkgNtcHisVO>();
		String[] arrCustCntcTpCd = new String[] { "C1", "C2", "B1", "B2", "AN" };
		
		try {

			for (int i = 0; i < listVOS.length; i++) {

				ArrNtcSendListVO listVO = listVOS[i];
				
				
				if(listVO.getChkFax().equals("1")){
					dbDao.modifyArrNtcBySend(listVO, account);
	
					BkgArrNtcDtlVO dtlVO = new BkgArrNtcDtlVO();
					
					String rcvInfo = "";
					
					String[] arrFaxNo = new String[] {listVO.getFaxNo1(),listVO.getFaxNo2(),listVO.getFaxNo3(),listVO.getFaxNo4(),listVO.getFaxNo5()
							};
					String[] arrFaxEvntFlg = new String[] {listVO.getFaxEvntFlg1(),listVO.getFaxEvntFlg2(),listVO.getFaxEvntFlg3(),listVO.getFaxEvntFlg4(),listVO.getFaxEvntFlg5()
							};
					
					
					for (int x = 0; x < arrCustCntcTpCd.length; x++) {
						
						
						
						dtlVO.setBkgNo(listVO.getBkgNo());
						dtlVO.setBkgCustTpCd(listVO.getBkgCustTpCd());
						dtlVO.setCustCntcTpCd(arrCustCntcTpCd[x]);					
						dtlVO.setFaxNo(arrFaxNo[x]);
						dtlVO.setFaxEvntFlg(arrFaxEvntFlg[x]);
						dtlVO.setFaxTpCd("F");
						
						
						
						if(arrFaxEvntFlg[x].equals("1")){				        								
							int modResult = dbDao.modifyArrNtcDtlByFax(dtlVO, account);
							if(modResult == 0){
								dbDao.addArrNtcDtlByFax(dtlVO, account);
							}
							
							List<FaxSendVO> faxInfos = new ArrayList<FaxSendVO>();
							
						
							String custNm = listVO.getCustNm();
							custNm = custNm.replaceAll(",", " " );
							custNm = custNm.replaceAll(";", " " );
							
							if(custNm.length() > 12){
								custNm = custNm.substring(0,12) + "...";
							}
							rcvInfo = custNm +";"+arrFaxNo[x];
						
							ArrNtcMrdSearchVO arrNtcMrdSearch = new ArrNtcMrdSearchVO();
							arrNtcMrdSearch.setBkgNo(listVO.getBkgNo());
							arrNtcMrdSearch.setUsrId(account.getUsr_id());
							arrNtcMrdSearch.setOfcCd(account.getOfc_cd());
							
							String mrdId = listVO.getMrdId();
							String loclLangFlg = listVO.getLoclLangFlg();
							String eclzBlCpyFlg = listVO.getEclzBlCpyFlg();
							String comParam = listVO.getComParam();
							
							FaxSendVO faxInfo = new FaxSendVO();
							faxInfo.setSysCd("BKG");
							faxInfo.setTmplMrd(mrdId + ".mrd");

							
							faxInfo.setBatchFlg("N");
							faxInfo.setTitle("Arrival Notice(BL#: "+ listVO.getBkgNo() +")");
							
							StringBuffer strArg = new StringBuffer("/rv ");
							strArg.append(" form_bkgNo['")  .append(listVO.getBkgNo()                     ).append("']");
							strArg.append(" form_usrId['")  .append(account.getUsr_id()                     ).append("']");
							strArg.append(" form_loclFlg['")  .append(loclLangFlg                     ).append("']");
							strArg.append(" form_tsFlg['")  .append(listVO.getTsFlg()                     ).append("']");
							strArg.append(" form_showPuFlg['")  .append(listVO.getShowPuFlg()                     ).append("']");
							strArg.append(" form_chgDpFlg['")  .append(listVO.getChgDpFlg()                     ).append("']");
							strArg.append(" form_remarkCtnt['']");
							strArg.append(" form_ofcCd['")  .append(account.getOfc_cd()                     ).append("']");
							strArg.append(" ").append(comParam);
							strArg.append(" /riprnmargin /rprncenteropt [3] /roldarithop");
							
							
//							String strArg = "/rv ";
//							strArg = strArg + " form_bkgNo['" + listVO.getBkgNo() + "']";
//							strArg = strArg + " form_usrId['" + account.getUsr_id() + "']";
//							strArg = strArg + " form_loclFlg['" + loclLangFlg + "']";
//							strArg = strArg + " form_tsFlg['" + listVO.getTsFlg() + "']";
//							strArg = strArg + " form_showPuFlg['" + listVO.getShowPuFlg() + "']";
//							
//							strArg = strArg + " form_chgDpFlg['" + listVO.getChgDpFlg() + "']";
//							strArg = strArg + " form_remarkCtnt['']";
//							strArg = strArg + " form_ofcCd['" + account.getOfc_cd() + "']";
							
//							strArg = strArg + " " + comParam;
//							strArg = strArg + " /riprnmargin /rprncenteropt [3] /roldarithop";
//							
//							strArg = strArg.trim();
							
							faxInfo.setTmplParam(strArg.toString().trim()); 
							faxInfo.setRcvInfo(rcvInfo);
							faxInfo.setOffice(account.getOfc_cd());
							faxInfo.setCrtUserId(account.getUsr_id());
							
							
							//-----------------------------------------------------------
							
							
							
							faxInfos.add(faxInfo);
							
						
							
							
							
							
							
							if(eclzBlCpyFlg.equals("Y")){
								FaxSendVO faxInfoObl = new FaxSendVO();
								
								StringBuffer strArgObl = new StringBuffer("/rv ");
								
								strArgObl.append(" form_bkgNo[('").append(listVO.getBkgNo()).append("')]");
								strArgObl.append(" form_type[2]");// ---> Default
								strArgObl.append(" form_dataOnly[N]");// ---> Default
								strArgObl.append(" form_manifest[N]");// ---> Default
								strArgObl.append(" form_usrId[").append(account.getUsr_id()).append("]");
								strArgObl.append(" form_hiddeData[N]");// ---> Default
								strArgObl.append(" form_level[(6)]");// ---> Default (ex - (1,2,3,4,5))
								strArgObl.append(" form_remark[]");// ---> Default
								strArgObl.append(" form_Cntr[1]");// ---> Default
								strArgObl.append(" form_mainOnly[N]");// ---> Default
								strArgObl.append(" form_CorrNo[]");// ---> Default
								strArgObl.append(" form_his_cntr[BKG_CONTAINER]");// ---> Default
								strArgObl.append(" form_his_bkg[BKG_BOOKING]");// ---> Default
								strArgObl.append(" form_his_mkd[BKG_BL_MK_DESC]");// ---> Default
								strArgObl.append(" form_his_xpt[BKG_XPT_IMP_LIC]");// ---> Default
								strArgObl.append(" form_his_bl[BKG_BL_DOC]");// ---> Default
							    
								strArgObl.append(" form_rqst_via_cd[]");// ---> Default
								strArgObl.append(" form_his_bl_mkd[BKG_BL_ISS]");// ---> Default
								strArgObl.append(" form_path[]");// ---> Default
								strArgObl.append(" isEncode[Y]");// ---> Default
								strArgObl.append(" form_end_no[]");// ---> Default
								strArgObl.append(" form_esig[] form_cpy_esig[] form_knt_flg[] form_count[]");// ---> Default							    
							    
								strArgObl.append(" /rp []");// ---> Default
								strArgObl.append(" /riprnmargin");
								
//								String strArgObl = "/rv ";
//								
//								strArgObl = strArgObl + " form_bkgNo[( '" + listVO.getBkgNo() + "' )] ";
//								strArgObl = strArgObl + " form_type[2]";// ---> Default
//								strArgObl = strArgObl + " form_dataOnly[N]";// ---> Default
//								strArgObl = strArgObl + " form_manifest[N]";// ---> Default
//								strArgObl = strArgObl + " form_usrId[" + account.getUsr_id() + "]";
//								strArgObl = strArgObl + " form_hiddeData[N]";// ---> Default
//							    strArgObl = strArgObl + " form_level[(6)]";// ---> Default (ex - (1,2,3,4,5))
//							    strArgObl = strArgObl + " form_remark[]";// ---> Default
//							    strArgObl = strArgObl + " form_Cntr[1]";// ---> Default
//							    strArgObl = strArgObl + " form_mainOnly[N]";// ---> Default
//							    strArgObl = strArgObl + " form_CorrNo[]";// ---> Default
//							    strArgObl = strArgObl + " form_his_cntr[BKG_CONTAINER]";// ---> Default
//							    strArgObl = strArgObl + " form_his_bkg[BKG_BOOKING]";// ---> Default
//							    strArgObl = strArgObl + " form_his_mkd[BKG_BL_MK_DESC]";// ---> Default
//							    strArgObl = strArgObl + " form_his_xpt[BKG_XPT_IMP_LIC]";// ---> Default
//							    strArgObl = strArgObl + " form_his_bl[BKG_BL_DOC]";// ---> Default
//							    
//							    // 2015.01.14 안진응 추가
//							    strArgObl = strArgObl + " form_rqst_via_cd[]";
//							    strArgObl = strArgObl + " form_his_bl_mkd[BKG_BL_ISS]";
//							    strArgObl = strArgObl + " form_path[]";
//					    		strArgObl = strArgObl + " isEncode[Y]";
//				   				strArgObl = strArgObl + " form_end_no[]";				
//				   				strArgObl = strArgObl + " form_esig[] form_cpy_esig[] form_knt_flg[] form_count[]";				
//
//				   				strArgObl = strArgObl + " /rp []";// ---> Default
//							    strArgObl = strArgObl + " /riprnmargin";
								
//								strArg = strArg.trim();
//								log.debug("---------- strArgObl "+ strArgObl);
//								log.debug("------- O/B BL을 첨부하여 FAX를 발송합니다.");
								
								faxInfoObl.setSysCd("BKG");
								faxInfoObl.setTmplMrd("ESM_BKG_0109_OBL_A4.mrd");

								faxInfoObl.setBatchFlg("N");
//								faxInfoObl.setTitle("O B/L");
								faxInfoObl.setTitle("BL Copy(BL#: "+listVO.getBkgNo()+")");
								
								faxInfoObl.setTmplParam(strArgObl.toString().trim()); 
								faxInfoObl.setRcvInfo(rcvInfo);
								faxInfoObl.setOffice(account.getOfc_cd());
								faxInfoObl.setCrtUserId(account.getUsr_id());
								
								log.debug("------- O/B BL을 첨부하여 FAX를 발송 시작");
								//eai.sendFax(faxInfo);
								
								faxInfos.add(faxInfoObl);
								
								
								log.debug("------- O/B BL을 첨부하여 FAX를 발송 끝");
				
							}
							
								
							log.debug("----------------- faxInfos.size() "+ faxInfos.size());
							log.debug("--------------------------------");
							log.debug("실제 Fax 발송");
							log.debug("--------------------------------");
							List<String> retFaxSndId = eaiDao.sendFax(faxInfos);
							String logFaxSndId = retFaxSndId.get(0);
							
							
							
							dtlVO.setFaxNtcSndId(logFaxSndId);
							dbDao.modifyArrNtcSendIdByFax(dtlVO, account);
							
							
								
							BkgNtcHisVO hisVO = new BkgNtcHisVO();
							hisVO.setNtcViaCd("F");
							hisVO.setSndId(logFaxSndId);
							hisVO.setSndOfcCd(account.getOfc_cd());
							hisVO.setSndUsrId(account.getUsr_id());
							hisVO.setCreUsrId(account.getUsr_id());
							hisVO.setUpdUsrId(account.getUsr_id());
							hisVO.setBkgNo(dtlVO.getBkgNo());
							hisVO.setBkgCustTpCd(dtlVO.getBkgCustTpCd());
							hisVO.setCustCntcTpCd(dtlVO.getCustCntcTpCd());
							
							log.debug("-------------- retFaxSndId  "+ retFaxSndId);
							
						
							hisVOS.add(dbDao.searchArrNtcHistory(hisVO));
							
						}
						
					}
				}
				
			}

		} catch(EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }


		return hisVOS;

	}


	/**
	 * [0381] E-Mail transmission
	 * @param ArrNtcSendListVO arrNtcSendListVo
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO> 
	 * @exception Exception 
	 */
	public List<BkgNtcHisVO> sendArrNtcByEmail(ArrNtcSendListVO arrNtcSendListVo						
						, SignOnUserAccount account) throws Exception{
		//1.modifyArrNtcBySend
		//2.modifyArrDtlByMail
		//3.sendEmail
		//4.modifyArrNtcSendId
		//5.searchBkgHistMstSeq
		//6.setting max seq value		
		
		List<BkgNtcHisVO> hisVOS = new ArrayList<BkgNtcHisVO>();
		String[] arrCustCntcTpCd = new String[] { "C1", "C2", "B1", "B2", "AN" };		
		List<String> retEmlSndId = new ArrayList<String>();
		
		try {
			BookingUtil util = new BookingUtil();
			String copyEml = util.searchCcEmailAddrRSQL("AN", account.getUsr_id());	
			String bccRcvrEml = util.searchBccEmailAddrRSQL("AN");						//20160324.ADD
			log.debug("-------------------- bccRcvrEml : "+bccRcvrEml);					//20160324.ADD			
			
			List<RDMailSendVO> mailInfos = new ArrayList<RDMailSendVO>();
			
//			for (int i = 0; i < arrNtcSendListVos.length; i++) {
//				ArrNtcSendListVO listVO = arrNtcSendListVos[i];
			  ArrNtcSendListVO listVO = arrNtcSendListVo;
				
				if(listVO.getChkEmail().equals("1")){
					dbDao.modifyArrNtcBySend(listVO, account);
					
	
					BkgArrNtcDtlVO dtlVO = new BkgArrNtcDtlVO();
					
					Vector<String> rcvMailInfo = new Vector<String>();
					
					Vector<String> vCustCntcTpCd = new Vector<String>();
					Vector<String> vNtcEml = new Vector<String>();
					vNtcEml.add(listVO.getNtcEml1());
					vNtcEml.add(listVO.getNtcEml2());
					vNtcEml.add(listVO.getNtcEml3());
					vNtcEml.add(listVO.getNtcEml4());
					vNtcEml.add(listVO.getNtcEml5());
					Vector<String> vEmlEvntFlg = new Vector<String>();
					vEmlEvntFlg.add(listVO.getEmlEvntFlg1());
					vEmlEvntFlg.add(listVO.getEmlEvntFlg2());
					vEmlEvntFlg.add(listVO.getEmlEvntFlg3());
					vEmlEvntFlg.add(listVO.getEmlEvntFlg4());
					vEmlEvntFlg.add(listVO.getEmlEvntFlg5());
					
					for (int x = 0; x < arrCustCntcTpCd.length; x++) {
						dtlVO.setBkgNo(listVO.getBkgNo());
						dtlVO.setBkgCustTpCd(listVO.getBkgCustTpCd());
						dtlVO.setCustCntcTpCd(arrCustCntcTpCd[x]);					
						dtlVO.setNtcEml(""+vNtcEml.get(x));
						dtlVO.setEmlEvntFlg(""+vEmlEvntFlg.get(x));
						dtlVO.setEmlTpCd("M");
                        dtlVO.setEmlSndUsrId(account.getUsr_id());
                        
						
						
						log.debug("-------------------- vEmlEvntFlg.get(x) " + x + "   :   "+vEmlEvntFlg.get(x));
						if(vEmlEvntFlg.get(x).equals("1")){
							log.debug("-----------------  detail 수정실행");
							rcvMailInfo.add(vNtcEml.get(x));
							vCustCntcTpCd.add(arrCustCntcTpCd[x]);
	                        if(vNtcEml.get(x) == null || vNtcEml.get(x).equals("")){
	                        	continue;
	                        }
							int modResult = dbDao.modifyArrNtcDtlByMail(dtlVO, account);
							if(modResult == 0){
								dbDao.addArrNtcDtlByMail(dtlVO, account);
							}
							
						}
						
					}				
					
					log.debug("-------------- mailInfos length"+ mailInfos.size());					
					
					if( !StringUtils.isBlank(copyEml) ){	
						rcvMailInfo.add(copyEml);
					}					
	
					for(int v=0;v<rcvMailInfo.size();v++){
						RDMailSendVO mailInfo = new RDMailSendVO();
						List<ComRptDsgnXptInfoVO> rdVOs = new ArrayList<ComRptDsgnXptInfoVO>();
						
						String bkgNo = "";
						
						log.debug("------------------ 해당 MRD 정보구해오기");
						
						log.debug("rcvMailInfo.get(v) : " + rcvMailInfo.get(v));
						
						ArrNtcMrdSearchVO arrNtcMrdSearch = new ArrNtcMrdSearchVO();
						arrNtcMrdSearch.setBkgNo(listVO.getBkgNo());
						arrNtcMrdSearch.setUsrId(account.getUsr_id());
						arrNtcMrdSearch.setOfcCd(account.getOfc_cd());
						
						String mrdId = listVO.getMrdId();
						String loclLangFlg = listVO.getLoclLangFlg();
						
						String eclzBlCpyFlg = listVO.getEclzBlCpyFlg();
						String comParam = listVO.getComParam();
						
						
						bkgNo = listVO.getBkgNo();
						
						ComRptDsgnXptInfoVO rdVO = new ComRptDsgnXptInfoVO();		
						
						rdVO.setCreUsrId(account.getUsr_id());
						rdVO.setUpdUsrId(account.getUsr_id());						
						
						rdVO.setXptFileNm("AN_"+listVO.getBlNo() + ".pdf");
						rdVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
						rdVO.setRdTmpltNm(mrdId + ".mrd");
						
						StringBuffer strArg = new StringBuffer("/rv ");
						strArg.append(" form_bkgNo['")  .append(bkgNo                     ).append("']");
						strArg.append(" form_usrId['")  .append(account.getUsr_id()       ).append("']");
						strArg.append(" form_loclFlg['")  .append(loclLangFlg             ).append("']");
						strArg.append(" form_tsFlg['")  .append(listVO.getTsFlg()         ).append("']");
						strArg.append(" form_showPuFlg['")  .append(listVO.getShowPuFlg() ).append("']");
						strArg.append(" form_chgDpFlg['")  .append(listVO.getChgDpFlg()   ).append("']");
						strArg.append(" form_remarkCtnt['']");
						strArg.append(" form_ofcCd['")  .append(account.getOfc_cd()       ).append("']");
						strArg.append(" ").append(comParam);
						strArg.append(" /riprnmargin /rprncenteropt [3] /roldarithop");
						
						log.debug("--------------------------- 파라미터 : "+ strArg);
						
						
						rdVO.setRdParaCtnt(strArg.toString());
						rdVOs.add(rdVO);	
						
						mailInfo.setSndrNm("shipment.info@notifications.nykline.com");
						mailInfo.setSndrEml("shipment.info@notifications.nykline.com");	
						mailInfo.setRcvrEml(rcvMailInfo.get(v));
						mailInfo.setRcvrNm(listVO.getCustNm());
						mailInfo.setEmlTitNm("Arrival Notice(BL#: "+ listVO.getBlNo() +")"); //Redmine #40604 - 2015-12-28 AN 
						mailInfo.setTemplate("ESM_BKG_0381_01T.html");
						
						//20160324.ADD				
						if( !StringUtils.isBlank(bccRcvrEml) ){	
							mailInfo.setBccRcvrEml(bccRcvrEml);
							log.debug("-------------------- bccRcvrEml : "+mailInfo.getBccRcvrEml());
						}
					

						HashMap<String, String> arguments = new HashMap<String, String>();
						arguments.put("rcvrNm", listVO.getCustNm());
						mailInfo.setArguments(arguments);
					
						
						if (!listVO.getFileKey().equals("")) {
							log.debug("-------------------- listVO.file_key Before: " + listVO.getFileKey());
							
							if (isNumeric(listVO.getFileKey())){
								String strFileKey = dbDao.searchAttachFileKey(listVO);
								
								if (!strFileKey.equals("")) {
									listVO.setFileKey(strFileKey);

									log.debug("-------------------- listVO.file_key After: " + listVO.getFileKey());
								}
							}
						}
						
						mailInfo.setFileKey(listVO.getFileKey());						
					
						log.debug("--------------------------- eclzBlCpyFlg    "+eclzBlCpyFlg);
						if(eclzBlCpyFlg.equals("Y")){
							rdVO = new ComRptDsgnXptInfoVO();
							
							rdVO.setCreUsrId(account.getUsr_id());
							rdVO.setUpdUsrId(account.getUsr_id());
							
							strArg = new StringBuffer("/rv ");
							strArg.append(" form_bkgNo[( '").append(listVO.getBkgNo()).append("' )] ");
						    strArg.append(" form_type[2]");// ---> Default
						    strArg.append(" form_dataOnly[N]");// ---> Default
						    strArg.append(" form_manifest[N]");// ---> Default
						    strArg.append(" form_usrId[").append(account.getUsr_id()).append("]");
						    strArg.append(" form_hiddeData[N]");// ---> Default
						    strArg.append(" form_level[(6)]");// ---> Default (ex - (1,2,3,4,5))
						    strArg.append(" form_remark[]");// ---> Default
						    strArg.append(" form_Cntr[1]");// ---> Default
						    strArg.append(" form_mainOnly[N]");// ---> Default
						    strArg.append(" form_CorrNo[]");// ---> Default
						    strArg.append(" form_his_cntr[BKG_CONTAINER]");// ---> Default
						    strArg.append(" form_his_bkg[BKG_BOOKING]");// ---> Default
						    strArg.append(" form_his_mkd[BKG_BL_MK_DESC]");// ---> Default
						    strArg.append(" form_his_xpt[BKG_XPT_IMP_LIC]");// ---> Default
						    strArg.append(" form_his_bl[BKG_BL_DOC]");// ---> Default
						    
						    strArg.append(" form_rqst_via_cd[]");// ---> Default
						    strArg.append(" form_his_bl_mkd[BKG_BL_ISS]");// ---> Default
						    strArg.append(" form_path[]");// ---> Default
						    strArg.append(" isEncode[Y]");// ---> Default
						    strArg.append(" form_end_no[]");// ---> Default
						    strArg.append(" form_esig[] form_cpy_esig[] form_knt_flg[] form_count[]");// ---> Default
						    
						    
						    strArg.append(" /rp []");// ---> Default
						    strArg.append(" /riprnmargin");
							

							rdVO.setXptFileNm("OBL_" +listVO.getBlNo() +".pdf");
							rdVO.setXptFileTpCd(ExportInfo.FTYPE_PDF); 
							rdVO.setRdTmpltNm("ESM_BKG_0109_OBL_A4.mrd");
							rdVO.setRdParaCtnt(strArg.toString());
							
							rdVOs.add(rdVO);
						}
						
						log.debug("------------------ 실제 메일 발송");
						mailInfo.setComRptDsgnXptInfoVOs(rdVOs);
						
						
						retEmlSndId.add(eaiDao.sendEmail(mailInfo));
						mailInfos.add(mailInfo);
					}
					
				}
//			}


			
			int y =0;
//			for (int i = 0; i < arrNtcSendListVos.length; i++) {
//				ArrNtcSendListVO listVO = arrNtcSendListVos[i];
				
			if(listVO.getChkEmail().equals("1")){	
					BkgArrNtcDtlVO dtlVO = new BkgArrNtcDtlVO();
					
					Vector<String> rcvMailInfo = new Vector<String>();
					
					Vector<String> vCustCntcTpCd = new Vector<String>();
					Vector<String> vNtcEml = new Vector<String>();
					vNtcEml.add(listVO.getNtcEml1());
					vNtcEml.add(listVO.getNtcEml2());
					vNtcEml.add(listVO.getNtcEml3());
					vNtcEml.add(listVO.getNtcEml4());
					vNtcEml.add(listVO.getNtcEml5());
					Vector<String> vEmlEvntFlg = new Vector<String>();
					vEmlEvntFlg.add(listVO.getEmlEvntFlg1());
					vEmlEvntFlg.add(listVO.getEmlEvntFlg2());
					vEmlEvntFlg.add(listVO.getEmlEvntFlg3());
					vEmlEvntFlg.add(listVO.getEmlEvntFlg4());
					vEmlEvntFlg.add(listVO.getEmlEvntFlg5());
					
					
					for (int x = 0; x < arrCustCntcTpCd.length; x++) {
						dtlVO.setBkgNo(listVO.getBkgNo());
						dtlVO.setBkgCustTpCd(listVO.getBkgCustTpCd());
						dtlVO.setCustCntcTpCd(arrCustCntcTpCd[x]);					
						dtlVO.setNtcEml(""+vNtcEml.get(x));
						dtlVO.setEmlEvntFlg(""+vEmlEvntFlg.get(x));
						dtlVO.setEmlTpCd("M");
                        dtlVO.setEmlSndUsrId(account.getUsr_id());
                        
                        
						
						log.debug("-------------------- vEmlEvntFlg.get(x) " + x + "   :   "+vEmlEvntFlg.get(x));
						if(vEmlEvntFlg.get(x).equals("1")){
						
							rcvMailInfo.add(vNtcEml.get(x));
							vCustCntcTpCd.add(arrCustCntcTpCd[x]);
						}
						
					}		
					
					
					log.debug("------------ retEmlSndId.size() "+retEmlSndId.size());
					
					for(int xx=0;xx<retEmlSndId.size();xx++){
						log.debug("-------------- retEmlSndId "+ xx + "    "+retEmlSndId.get(xx));
						if(retEmlSndId.get(xx) == null){
							retEmlSndId.set(xx,"NO SND NO");
						}
					}
					
					
					for (int x = 0; x < arrCustCntcTpCd.length; x++) {				
						dtlVO.setCustCntcTpCd(arrCustCntcTpCd[x]);		
						if(vEmlEvntFlg.get(x).equals("1")){
							log.debug("---------------Mail 전송후 Send Id 를 업데이트");
							log.debug("-------- bkg_no  "+dtlVO.getBkgNo());
							log.debug("-------- bkg_cust_tp_cd  "+dtlVO.getBkgCustTpCd());
							log.debug("-------- cust_cnt_tp_cd  "+dtlVO.getCustCntcTpCd());
							log.debug("-------- retEmlSndId.get(y)  "+retEmlSndId.get(y));
							dtlVO.setEmlNtcSndId(retEmlSndId.get(y));
							dbDao.modifyArrNtcSendIdByMail(dtlVO, account);
							y = y + 1;
						}
						
					}
					
					
					for(int q=0;q<rcvMailInfo.size();q++){				
						BkgNtcHisVO hisVO = new BkgNtcHisVO();
						hisVO.setNtcViaCd("M");
						hisVO.setSndId(retEmlSndId.get(q));
						hisVO.setSndOfcCd(account.getOfc_cd());
						hisVO.setSndUsrId(account.getUsr_id());
						hisVO.setCreUsrId(account.getUsr_id());
						hisVO.setUpdUsrId(account.getUsr_id());
						hisVO.setBkgNo(listVO.getBkgNo());
						hisVO.setBkgCustTpCd(listVO.getBkgCustTpCd());
						hisVO.setCustCntcTpCd(vCustCntcTpCd.get(q));
						
						log.debug("--------------listVO.getBkgNo()  "+ listVO.getBkgNo());
						
						log.debug("--------------listVO.getBkgCustTpCd()  "+ listVO.getBkgCustTpCd());
						
						hisVOS.add(dbDao.searchArrNtcHistory(hisVO));
					}
					
				}
//			}

		}catch (EventException de) {
//			de.printStackTrace();
			log.error("err " + de.toString(), de);
            throw de;
        }catch (DAOException de) {
//			de.printStackTrace();
        	log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }

		return hisVOS;
		
	}
	
	/** isNumeric<br>
	 * @param String s
	 * @return static boolean
	 */
	public static boolean isNumeric(String s) {  
        return s.matches("[-+]?\\d*\\.?\\d+");  
    } 

	/** [0956] Hold Remark retrieve<br>
	 * @param String bkgNo
	 * @return List<BkgArrNtcCntrVO>
	 * @exception EventException
	 */
	public List<BkgArrNtcCntrVO> searchArrNtcHldRmk (String bkgNo) throws EventException {
		// TODO Auto-generated method stub
		
		List<BkgArrNtcCntrVO> retList = null;
		try {
		retList= dbDao.searchArrNtcHldRmk (bkgNo);
		
		}catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		return retList;
	}
	/**
	 * [0956] save Hold Remark<br>
	 * @param BkgArrNtcCntrVO[] vos
	 * @param SignOnUserAccount account
	 * @exception EventException 
	 */
	public void setupArrNtcHldRmk (BkgArrNtcCntrVO[] bkgArrNtcCntrVos, SignOnUserAccount account) throws EventException {
		
		try {
			for (int i = 0; i < bkgArrNtcCntrVos.length; i++) {
				BkgArrNtcCntrVO vo = bkgArrNtcCntrVos[i];								
				if(dbDao.modifyArrNtcHldRmk (vo,account) == 0){
					dbDao.addArrNtcHldRmk(vo,account);
				}
				
			}
		}catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
	}
	
	/** [0946] Group A/N Merge Pop-up retrieve
	 * Group A/N Merge Pop-up
	 * @param ArrNtcGrpSendListVO vo
	 * @return List<ArrNtcGrpSendListVO>
	 * @exception EventException
	 */
	public List<ArrNtcGrpSendListVO> searchArrNtcGrpSendList(ArrNtcGrpSendListVO vo)
			throws EventException {
		// TODO Auto-generated method stub
		
		List<ArrNtcGrpSendListVO> retList = null;
		try {
			//log.debug("------------------- vo " + vo.getColumnValues());
			retList = dbDao.searchArrNtcGrpSendList(vo);

		}catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		return retList;
	}
	
	/**
	 * [0946] fax Group Arrival Notice transmission
	 * @param ArrNtcGrpSendVO grpSendVO
	 * @param ArrNtcGrpSendListVO[] arrNtcGrpSendLists
	 * @param SignOnUserAccount account
	 * @param Vector vFaxNo
	 * @return List<BkgNtcHisVO>
	 * @exception EventException 
	 */
	public List<BkgNtcHisVO> sendArrNtcByGrpFax(ArrNtcGrpSendVO grpSendVO,ArrNtcGrpSendListVO[] arrNtcGrpSendLists
			,SignOnUserAccount account,Vector vFaxNo) throws EventException{
			
		List<BkgNtcHisVO> hisVOS = new ArrayList<BkgNtcHisVO>();
		String[] arrCustCntcTpCd = new String[] { "C1", "C2", "B1", "B2", "AN" };
		String divCd = grpSendVO.getDivCd();
		


		try{
			
//			String grpNtcSeq = dbDao.searchArrGrpNtcNextSeq();
//			BkgGrpArrNtcVO bkgGrpArrNtc = new BkgGrpArrNtcVO();
//			bkgGrpArrNtc.setGrpNtcSeq(grpNtcSeq);
//			dbDao.addArrGrpNtcByNextSeq(bkgGrpArrNtc , account);
			
			//String[] arrEmlNo = new String[arrCustCntcTpCd.length] ;
			//Vector<String> rcvMailInfo = new Vector<String>();//
			
			BkgArrNtcDtlVO arrNtcDtls = new BkgArrNtcDtlVO();

			String custNm = "";
//			String bkgNoStr = "";
			StringBuffer bkgNoStr = new StringBuffer("");                                                                                                 
			
			String orgBkgNo = grpSendVO.getBkgNo();
			
			
			if(divCd.equals("C")){
				ArrNtcGrpSendListVO arrGrpSendList = new ArrNtcGrpSendListVO();
				
				for(int j=0;j<arrNtcGrpSendLists.length;j++){
					arrGrpSendList = arrNtcGrpSendLists[j];
					custNm = arrGrpSendList.getCustNm();
					bkgNoStr.append("'").append(arrGrpSendList.getBkgNo()).append("'");

//					bkgNoStr = bkgNoStr + "'" + arrGrpSendList.getBkgNo() + "'";
					if(j != (arrNtcGrpSendLists.length-1) ){
//						bkgNoStr = bkgNoStr + ",";
						bkgNoStr.append(",");
					}
				}
					
				for(int j=0;j<arrNtcGrpSendLists.length;j++){
					arrGrpSendList = arrNtcGrpSendLists[j];	
					for(int i=0;i<arrCustCntcTpCd.length;i++){
						String[] flagFax = (vFaxNo.get(i).toString()).split("\\|");
					
						arrNtcDtls.setBkgNo(arrGrpSendList.getBkgNo());
						arrNtcDtls.setBkgCustTpCd(arrGrpSendList.getBkgCustTpCd());
						arrNtcDtls.setCustCntcTpCd(arrCustCntcTpCd[i]);		
						arrNtcDtls.setFaxTpCd("F");
						
				
						if(flagFax[0].equals("1") && flagFax.length > 1){
							String faxNo = flagFax[1];						
							arrNtcDtls.setFaxNo(faxNo);						
							arrNtcDtls.setFaxSndUsrId(account.getUsr_id());
							 
							arrNtcDtls.setCreUsrId(account.getUsr_id());
							arrNtcDtls.setUpdUsrId(account.getUsr_id());
							//dbDao.mergeArrNtcDtl(arrNtcDtls,account);
												
							int modResult = dbDao.modifyArrNtcDtlByFax(arrNtcDtls, account);
							if(modResult == 0){
								dbDao.addArrNtcDtlByFax(arrNtcDtls, account);
							}
					
							List<FaxSendVO> faxInfos = new ArrayList<FaxSendVO>();
	
							FaxSendVO faxInfo = new FaxSendVO();
							faxInfo.setSysCd("BKG");
							
	
							faxInfo.setBatchFlg("N");
							
							ArrNtcMrdSearchVO arrNtcMrdSearch = new ArrNtcMrdSearchVO();
							arrNtcMrdSearch.setBkgNo(orgBkgNo);
							arrNtcMrdSearch.setUsrId(account.getUsr_id());
							arrNtcMrdSearch.setOfcCd(account.getOfc_cd());
							
							ArrNtcMrdVO mrdVO = this.searchArrNtcMrdId(arrNtcMrdSearch);
							log.error("ERR Log arrNtcMrdSearch : " + arrNtcMrdSearch);
							log.error("ERR Log mrdVO : " + mrdVO);
							String eclzBlCpyFlg = mrdVO.getEclzBlCpyFlg();
							
							
							StringBuffer strArg = new StringBuffer("/rv ");                                                                                                 
							
//							String strArg = "/rv ";
							
							
							
								
							faxInfo.setTmplMrd("ESM_BKG_0918.mrd");
							faxInfo.setBatchFlg("N");
							faxInfo.setTitle("Group Arrival Notice (Combine)(BL#: " + bkgNoStr + ")");
							
							strArg.append(" form_bkgNo[(")  .append(bkgNoStr)                 .append(")]");
							strArg.append(" form_usrId['")  .append(account.getUsr_id())      .append("']");
							strArg.append(" form_loclFlg['Y']");
							strArg.append(" form_tsFlg['")  .append(arrNtcGrpSendLists[0].getTsFlg()).append("']");
							strArg.append(" form_rvisFlg['")  .append(arrNtcGrpSendLists[0].getRvisFlg()).append("']");
							strArg.append(" form_usrTo['")  .append(arrNtcGrpSendLists[0].getCustNm()).append("']");
							strArg.append(" form_remarkCtnt['']");
							strArg.append(" form_ofcCd['")  .append( account.getOfc_cd())     .append("']");

							
//							strArg = strArg + " form_bkgNo[(" + bkgNoStr + ")]";
//							strArg = strArg + " form_usrId['" + account.getUsr_id() + "']";
//							strArg = strArg + " form_loclFlg['Y']";
//							strArg = strArg + " form_tsFlg['" + arrNtcGrpSendLists[0].getTsFlg() + "']";
//							strArg = strArg + " form_rvisFlg['" + arrNtcGrpSendLists[0].getRvisFlg()+ "']";
//							strArg = strArg + " form_usrTo['"      +arrNtcGrpSendLists[0].getCustNm() +   "']";
//							strArg = strArg + " form_remarkCtnt['']";
//							strArg = strArg + " form_ofcCd['" + account.getOfc_cd() + "']";	
								
							
							
							
//							strArg = strArg.trim();
							log.debug("----------- strArg "+strArg.toString().trim() );
							
							faxInfo.setTmplParam(strArg.toString().trim()); //
							
							faxInfo.setRcvInfo(custNm + ";" + faxNo);
							faxInfo.setOffice(account.getOfc_cd());
							faxInfo.setCrtUserId(account.getUsr_id());
							
							faxInfos.add(faxInfo);
							
							
							
							if(eclzBlCpyFlg.equals("Y")){
								
								StringBuffer strArgObl = new StringBuffer("/rv ");
								
								strArgObl.append(" form_bkgNo[('").append(bkgNoStr).append("')]");
								strArgObl.append(" form_type[2]");// ---> Default
								strArgObl.append(" form_dataOnly[N]");// ---> Default
								strArgObl.append(" form_manifest[N]");// ---> Default
								strArgObl.append(" form_usrId[").append(account.getUsr_id()).append("]");
								strArgObl.append(" form_hiddeData[N]");// ---> Default
								strArgObl.append(" form_level[(6)]");// ---> Default (ex - (1,2,3,4,5))
								strArgObl.append(" form_remark[]");// ---> Default
								strArgObl.append(" form_Cntr[1]");// ---> Default
								strArgObl.append(" form_mainOnly[N]");// ---> Default
								strArgObl.append(" form_CorrNo[]");// ---> Default
								strArgObl.append(" form_his_cntr[BKG_CONTAINER]");// ---> Default
								strArgObl.append(" form_his_bkg[BKG_BOOKING]");// ---> Default
								strArgObl.append(" form_his_mkd[BKG_BL_MK_DESC]");// ---> Default
								strArgObl.append(" form_his_xpt[BKG_XPT_IMP_LIC]");// ---> Default
								strArgObl.append(" form_his_bl[BKG_BL_DOC]");// ---> Default
							    
								strArgObl.append(" form_rqst_via_cd[]");// ---> Default
								strArgObl.append(" form_his_bl_mkd[BKG_BL_ISS]");// ---> Default
								strArgObl.append(" form_path[]");// ---> Default
								strArgObl.append(" isEncode[Y]");// ---> Default
								strArgObl.append(" form_end_no[]");// ---> Default
								strArgObl.append(" form_esig[] form_cpy_esig[] form_knt_flg[] form_count[]");// ---> Default							    
							    
								strArgObl.append(" /rp []");// ---> Default
								strArgObl.append(" /riprnmargin");
								
//								String strArgObl = "/rv ";
								
//								strArgObl = strArgObl + " form_bkgNo[(" + bkgNoStr + ")]";
//								strArgObl = strArgObl + " form_type[2]";// ---> Default
//								strArgObl = strArgObl + " form_dataOnly[N]";// ---> Default
//							    strArgObl = strArgObl + " form_manifest[N]";// ---> Default
//							    strArgObl = strArgObl + " form_usrId[" + account.getUsr_id() + "]";
//							    strArgObl = strArgObl + " form_hiddeData[N]";// ---> Default
//							    strArgObl = strArgObl + " form_level[(6)]";// ---> Default (ex - (1,2,3,4,5))
//							    strArgObl = strArgObl + " form_remark[]";// ---> Default
//							    strArgObl = strArgObl + " form_Cntr[1]";// ---> Default
//							    strArgObl = strArgObl + " form_mainOnly[N]";// ---> Default
//							    strArgObl = strArgObl + " form_CorrNo[]";// ---> Default
//							    strArgObl = strArgObl + " form_his_cntr[BKG_CONTAINER]";// ---> Default
//							    strArgObl = strArgObl + " form_his_bkg[BKG_BOOKING]";// ---> Default
//							    strArgObl = strArgObl + " form_his_mkd[BKG_BL_MK_DESC]";// ---> Default
//							    strArgObl = strArgObl + " form_his_xpt[BKG_XPT_IMP_LIC]";// ---> Default
//							    strArgObl = strArgObl + " form_his_bl[BKG_BL_DOC]";// ---> Default
//							    
//							    // 2015.01.14 안진응 추가
//							    strArgObl = strArgObl + " form_rqst_via_cd[]";
//							    strArgObl = strArgObl + " form_his_bl_mkd[BKG_BL_ISS]";
//							    strArgObl = strArgObl + " form_path[]";
//							    strArgObl = strArgObl + " isEncode[Y]";
//							    strArgObl = strArgObl + " form_end_no[]";		
//							    strArgObl = strArgObl + " form_esig[] form_cpy_esig[] form_knt_flg[] form_count[]";				
//
//							    
//							    strArgObl = strArgObl + " /rp []";// ---> Default
//							    strArgObl = strArgObl + " /riprnmargin";
//							    
//							    strArgObl = strArgObl.trim();
								
								
								log.debug("---------- strArg "+ strArgObl.toString().trim());
								log.debug("------- O/B BL을 첨부하여 FAX를 발송합니다.");
								
								FaxSendVO faxInfoObl = new FaxSendVO();
								
								faxInfoObl.setSysCd("BKG");
								faxInfoObl.setTmplMrd("ESM_BKG_0109_OBL_A4.mrd");
	
								faxInfoObl.setBatchFlg("N");
								faxInfoObl.setTitle("BL Copy(Combine)(BL#: "+arrGrpSendList.getBkgNo()+")");
								
								faxInfoObl.setTmplParam(strArgObl.toString().trim());
								faxInfoObl.setRcvInfo(custNm + ";" + faxNo);
								faxInfoObl.setOffice(account.getOfc_cd());
								
								faxInfoObl.setCrtUserId(ConstantMgr.getCompanyName().toUpperCase() + " INBOUND DEPT");
								
								log.debug("------- O/B BL을 첨부하여 FAX를 발송 시작");
								faxInfos.add(faxInfoObl);
								log.debug("------- O/B BL을 첨부하여 FAX를 발송 끝");
	
							}
							
							
							log.debug("------------------------------");
							log.debug(" FAX 실제 발송     faxInfos.size() "+ faxInfos.size());
							log.debug("------------------------------");
							
							List<String> retFaxSndId = eaiDao.sendFax(faxInfos);
							log.debug("----------- retFaxSndId "+retFaxSndId);
							
							
							
							
							log.debug("--------------group fax bkg_no "+arrGrpSendList.getBkgNo());
							log.debug("----------------group fax bl_no "+arrGrpSendList.getBlNo());
							arrNtcDtls.setBkgNo(arrGrpSendList.getBkgNo());
							arrNtcDtls.setFaxNtcSndId(retFaxSndId.get(0));		
							arrNtcDtls.setCustCntcTpCd(arrCustCntcTpCd[i]);						
							dbDao.modifyArrNtcSendIdByFax(arrNtcDtls, account);
							
						
							
							//----------------------------------------------------------
							BkgNtcHisVO hisVO = new BkgNtcHisVO();
							hisVO.setNtcViaCd("F");
							hisVO.setSndId(retFaxSndId.get(0));
							hisVO.setSndOfcCd(account.getOfc_cd());
							hisVO.setSndUsrId(account.getUsr_id());
							hisVO.setCreUsrId(account.getUsr_id());
							hisVO.setUpdUsrId(account.getUsr_id());
							hisVO.setBkgNo(arrGrpSendList.getBkgNo());
							hisVO.setBkgCustTpCd(arrNtcDtls.getBkgCustTpCd());
							hisVO.setCustCntcTpCd(arrCustCntcTpCd[i]);
							
							
							
							hisVOS.add(dbDao.searchArrNtcHistory(hisVO));
							
							//----------------------------------------------------------
					
						}
					}
				}
			}
			else if(divCd.equals("S")){
				for(int j=0;j<arrNtcGrpSendLists.length;j++){
					ArrNtcGrpSendListVO arrGrpSendList = (ArrNtcGrpSendListVO)arrNtcGrpSendLists[j];
					custNm = arrGrpSendList.getCustNm();
					
					
					//0|   ,1|sackso@nate.com      ,0|     ,0|     ,0|    ,
					
					
					for(int i=0;i<arrCustCntcTpCd.length;i++){
						String[] flagFax = (vFaxNo.get(i).toString()).split("\\|");
					
						arrNtcDtls.setBkgNo(arrGrpSendList.getBkgNo());
						arrNtcDtls.setBkgCustTpCd(arrGrpSendList.getBkgCustTpCd());
						arrNtcDtls.setCustCntcTpCd(arrCustCntcTpCd[i]);	
						
						arrNtcDtls.setFaxTpCd("F");
						
				
						if(flagFax[0].equals("1") && flagFax.length > 1){
							String faxNo = flagFax[1];						
							arrNtcDtls.setFaxNo(faxNo);						
							arrNtcDtls.setFaxSndUsrId(account.getUsr_id());							 
							arrNtcDtls.setCreUsrId(account.getUsr_id());
							arrNtcDtls.setUpdUsrId(account.getUsr_id());
							//dbDao.mergeArrNtcDtl(arrNtcDtls,account);
												
							int modResult = dbDao.modifyArrNtcDtlByFax(arrNtcDtls, account);
							if(modResult == 0){
								dbDao.addArrNtcDtlByFax(arrNtcDtls, account);
							}
					
							List<FaxSendVO> faxInfos = new ArrayList<FaxSendVO>();
	
							FaxSendVO faxInfo = new FaxSendVO();
							faxInfo.setSysCd("BKG");
							
	
							faxInfo.setBatchFlg("N");
							String eclzBlCpyFlg = "";
//							String strArg = "/rv ";
							
							StringBuffer strArg = new StringBuffer("/rv "); 
							
							ArrNtcMrdSearchVO arrNtcMrdSearch = new ArrNtcMrdSearchVO();
							
							arrNtcMrdSearch.setBkgNo(arrGrpSendList.getBkgNo());
							arrNtcMrdSearch.setUsrId(account.getUsr_id());
							arrNtcMrdSearch.setOfcCd(account.getOfc_cd());
							
							ArrNtcMrdVO mrdVO = this.searchArrNtcMrdId(arrNtcMrdSearch);
							String mrdId = mrdVO.getMrdId();
							String loclLangFlg = mrdVO.getLoclLangFlg();
							eclzBlCpyFlg = mrdVO.getEclzBlCpyFlg();
							String comParam = mrdVO.getComParam();
							
							
							faxInfo.setTmplMrd(mrdId + ".mrd");
							faxInfo.setBatchFlg("N");
							faxInfo.setTitle("Group Arrival Notice (Separate)(BL#: "+arrGrpSendList.getBkgNo()+")"); 
							                             
							strArg.append(" form_bkgNo[(")  .append(arrGrpSendList.getBkgNo()).append(")]");
							strArg.append(" form_usrId['")  .append(account.getUsr_id()).append("']");
							strArg.append(" form_loclFlg['")  .append(loclLangFlg).append("']");
							strArg.append(" form_tsFlg['")  .append(arrGrpSendList.getTsFlg()).append("']");
							strArg.append(" form_chgDpFlg['4']");
							strArg.append(" form_remarkCtnt['']");
							strArg.append(" form_ofcCd['")  .append( account.getOfc_cd()).append("']");
							strArg.append(" ").append(comParam);
							
//							strArg = strArg + " form_bkgNo[('" + arrGrpSendList.getBkgNo() + "')]";
//							strArg = strArg + " form_usrId['" + account.getUsr_id() + "']";
//							strArg = strArg + " form_loclFlg['" + loclLangFlg + "']";
//							strArg = strArg + " form_tsFlg['" + arrGrpSendList.getTsFlg() + "']";
//							strArg = strArg + " form_chgDpFlg['4']";
//							strArg = strArg + " form_remarkCtnt['']";
//							strArg = strArg + " form_ofcCd['" + account.getOfc_cd() + "']";
//							
//							strArg = strArg + " "+comParam;
							
//							strArg = strArg.toString().trim();
//							log.debug("----------- strArg "+strArg );
							
							faxInfo.setTmplParam(strArg.toString().trim()); //
							
							faxInfo.setRcvInfo(custNm + ";" + faxNo);
							faxInfo.setOffice(account.getOfc_cd());
							faxInfo.setCrtUserId(account.getUsr_id());
							
							faxInfos.add(faxInfo);
							
							
							
							if(eclzBlCpyFlg.equals("Y")){
								
								
								StringBuffer strArgObl = new StringBuffer("/rv "); 
								
								strArgObl.append(" form_bkgNo[(").append(arrGrpSendList.getBkgNo()).append(")]");
								strArgObl.append(" form_type[2]");
								strArgObl.append(" form_dataOnly[N]");
								strArgObl.append(" form_manifest[N]");
								strArgObl.append(" form_usrId[").append(account.getUsr_id()).append("]");
								strArgObl.append(" form_hiddeData[N]");
								strArgObl.append(" form_level[(6)]");
								strArgObl.append(" form_remark[]");
								strArgObl.append(" form_Cntr[1]");
								strArgObl.append(" form_mainOnly[N]");
								strArgObl.append(" form_CorrNo[]");
								strArgObl.append(" form_his_cntr[BKG_CONTAINER]");
								strArgObl.append(" form_his_bkg[BKG_BOOKING]");
								strArgObl.append(" form_his_mkd[BKG_BL_MK_DESC]");
								strArgObl.append(" form_his_xpt[BKG_XPT_IMP_LIC]");
								strArgObl.append(" form_his_bl[BKG_BL_DOC]");

								strArgObl.append(" form_rqst_via_cd[]");// ---> Default
								strArgObl.append(" form_his_bl_mkd[BKG_BL_ISS]");// ---> Default
								strArgObl.append(" form_path[]");// ---> Default
								strArgObl.append(" isEncode[Y]");// ---> Default
								strArgObl.append(" form_end_no[]");// ---> Default
								strArgObl.append(" form_esig[] form_cpy_esig[] form_knt_flg[] form_count[]");// ---> Default									
								
								strArgObl.append(" /rp []");
								strArgObl.append(" /riprnmargin");
								
//								String strArgObl = "/rv ";
								
//								strArgObl = strArgObl + " form_bkgNo[('" + arrGrpSendList.getBkgNo() + "')]";
//								strArgObl = strArgObl + " form_type[2]";// ---> Default
//								strArgObl = strArgObl + " form_dataOnly[N]";// ---> Default
//							    strArgObl = strArgObl + " form_manifest[N]";// ---> Default
//							    strArgObl = strArgObl + " form_usrId[" + account.getUsr_id() + "]";
//							    strArgObl = strArgObl + " form_hiddeData[N]";// ---> Default
//							    strArgObl = strArgObl + " form_level[(6)]";// ---> Default (ex - (1,2,3,4,5))
//							    strArgObl = strArgObl + " form_remark[]";// ---> Default
//							    strArgObl = strArgObl + " form_Cntr[1]";// ---> Default
//							    strArgObl = strArgObl + " form_mainOnly[N]";// ---> Default
//							    strArgObl = strArgObl + " form_CorrNo[]";// ---> Default
//							    strArgObl = strArgObl + " form_his_cntr[BKG_CONTAINER]";// ---> Default
//							    strArgObl = strArgObl + " form_his_bkg[BKG_BOOKING]";// ---> Default
//							    strArgObl = strArgObl + " form_his_mkd[BKG_BL_MK_DESC]";// ---> Default
//							    strArgObl = strArgObl + " form_his_xpt[BKG_XPT_IMP_LIC]";// ---> Default
//							    strArgObl = strArgObl + " form_his_bl[BKG_BL_DOC]";// ---> Default
//							    
//							    // 2015.01.14 안진응 추가
//							    strArgObl = strArgObl + " form_rqst_via_cd[]";
//							    strArgObl = strArgObl + " form_his_bl_mkd[BKG_BL_ISS]";
//							    strArgObl = strArgObl + " form_path[]";
//							    strArgObl = strArgObl + " isEncode[Y]";
//							    strArgObl = strArgObl + " form_end_no[]";				
//							    strArgObl = strArgObl + " form_esig[] form_cpy_esig[] form_knt_flg[] form_count[]";				
//							    
//							    strArgObl = strArgObl + " /rp []";// ---> Default
//							    strArgObl = strArgObl + " /riprnmargin";
							    
//							    strArgObl = strArgObl.trim();
								
								
//								log.debug("---------- strArg "+ strArg);
								log.debug("------- O/B BL을 첨부하여 FAX를 발송합니다.");
								
								FaxSendVO faxInfoObl = new FaxSendVO();
								
								faxInfoObl.setSysCd("BKG");
								faxInfoObl.setTmplMrd("ESM_BKG_0109_OBL_A4.mrd");
	
								faxInfoObl.setBatchFlg("N");
								faxInfoObl.setTitle("BL Copy(Separate)(BL#: " + arrGrpSendList.getBkgNo()+")");
								
								faxInfoObl.setTmplParam(strArgObl.toString().trim()); 
								faxInfoObl.setRcvInfo(custNm + ";" + faxNo);
								faxInfoObl.setOffice(account.getOfc_cd());
								faxInfoObl.setCrtUserId(ConstantMgr.getCompanyName().toUpperCase() + " INBOUND DEPT");
								
								log.debug("------- O/B BL을 첨부하여 FAX를 발송 시작");
								faxInfos.add(faxInfoObl);
								log.debug("------- O/B BL을 첨부하여 FAX를 발송 끝");
	
							}
							
							
							log.debug("------------------------------");
							log.debug(" FAX 실제 발송     faxInfos.size() "+ faxInfos.size());
							log.debug("------------------------------");
							
							List<String> retFaxSndId = eaiDao.sendFax(faxInfos);
							log.debug("----------- retFaxSndId "+retFaxSndId);
							
							
							
							
						
							arrNtcDtls.setBkgNo(arrGrpSendList.getBkgNo());
							arrNtcDtls.setFaxNtcSndId(retFaxSndId.get(0));		
							arrNtcDtls.setCustCntcTpCd(arrCustCntcTpCd[i]);						
							dbDao.modifyArrNtcSendIdByFax(arrNtcDtls, account);
							
						
							
							//----------------------------------------------------------
							BkgNtcHisVO hisVO = new BkgNtcHisVO();
							hisVO.setNtcViaCd("F");
							hisVO.setSndId(retFaxSndId.get(0));
							hisVO.setSndOfcCd(account.getOfc_cd());
							hisVO.setSndUsrId(account.getUsr_id());
							hisVO.setCreUsrId(account.getUsr_id());
							hisVO.setUpdUsrId(account.getUsr_id());
							hisVO.setBkgNo(arrGrpSendList.getBkgNo());
							hisVO.setBkgCustTpCd(arrNtcDtls.getBkgCustTpCd());
							hisVO.setCustCntcTpCd(arrCustCntcTpCd[i]);
							
							
							hisVOS.add(dbDao.searchArrNtcHistory(hisVO));
							
							//----------------------------------------------------------
					
						}
					}
				}
			
			
			}
			
			
			
			
			
			
			
			
		}catch (DAOException de) {
//			de.printStackTrace();
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00110",new String[]{de.getMessage()}).getMessage(), de);
        }catch (Exception de) {
            log.error("err " + de.toString(), de);
//            de.printStackTrace();
            throw new EventException(new ErrorHandler("BKG00110",new String[]{de.getMessage()}).getMessage(), de);
        }
		
		return hisVOS;
	}
	/**
	 * [0946] EMail Group Arrival Notice transmission
	 * @param ArrNtcGrpSendVO grpSendVO
	 * @param ArrNtcGrpSendListVO[] arrNtcGrpSendLists
	 * @param SignOnUserAccount account
	 * @param Vector vEmail
	 * @return List<BkgNtcHisVO>
	 * @exception EventException 
	 */
	public List<BkgNtcHisVO> sendArrNtcByGrpEml(ArrNtcGrpSendVO grpSendVO,ArrNtcGrpSendListVO[] arrNtcGrpSendLists
			,SignOnUserAccount account,Vector vEmail) throws EventException{
		
		List<BkgNtcHisVO> hisVOS = new ArrayList<BkgNtcHisVO>();
		String[] arrCustCntcTpCd = new String[] { "C1", "C2", "B1", "B2", "AN" };
		ComUserVO comUserVO = null;
		
		/**************************************
		 * searchArrGrpNtcNextSeq.
		 * addArrGrpNtcByNextSeq.
		 * modifyArrNtcByGrpNtcSeq. 
		 **************************************/				
		
		try{						

			Vector<String> sendEmail = new Vector<String>();
			BkgArrNtcDtlVO arrNtcDtls = new BkgArrNtcDtlVO();
			
			String custNm = "";
//			String bkgNoStr = "";
			StringBuffer bkgNoStr = new StringBuffer("");
			String orgBkgNo = grpSendVO.getBkgNo();
			String divCd = grpSendVO.getDivCd();
			
			String scNo = "";
			String custCd = "";

			BookingUtil util = new BookingUtil();
			String copyEml = util.searchCcEmailAddrRSQL("AN", account.getUsr_id());
			
			String bccRcvrEml = util.searchBccEmailAddrRSQL("AN");						//20160328.ADD
			log.debug("-------------------- bccRcvrEml : "+bccRcvrEml);					//20160328.ADD	

			// modify  account.getUsr_Eml() -> getDfltEml()
			comUserVO = util.searchComUserInfo(account.getUsr_id());
			String sUsrEml = "";
			if (null!=comUserVO) {
				sUsrEml = (null==comUserVO.getDfltEml() || "".equals(comUserVO.getDfltEml())) ? comUserVO.getUsrEml() : comUserVO.getDfltEml();
			}
			
			for(int j=0;j<arrNtcGrpSendLists.length;j++){				
				ArrNtcGrpSendListVO arrGrpSendList = (ArrNtcGrpSendListVO)arrNtcGrpSendLists[j];
				scNo = arrGrpSendList.getScNo();
				custCd = arrGrpSendList.getCustCntCd() +""+ arrGrpSendList.getCustSeq();
				
				custNm = arrGrpSendList.getCustNm();
//				bkgNoStr = bkgNoStr + "'" + arrGrpSendList.getBkgNo() + "'";
				bkgNoStr.append("'").append(arrGrpSendList.getBkgNo()).append("'");
				
				if(j != (arrNtcGrpSendLists.length-1) ){
//					bkgNoStr = bkgNoStr + ",";
					bkgNoStr.append(",");

				}
				
				for(int i=0;i<arrCustCntcTpCd.length;i++){
					String[] flagEmail = (vEmail.get(i).toString()).split("\\|");
					//0|   ,1|sackso@nate.com      ,0|     ,0|     ,0|    ,
					
					
					
					arrNtcDtls.setBkgNo(arrGrpSendList.getBkgNo());
					arrNtcDtls.setBkgCustTpCd(arrGrpSendList.getBkgCustTpCd());
					arrNtcDtls.setCustCntcTpCd(arrCustCntcTpCd[i]);		
					arrNtcDtls.setEmlTpCd("M");
					
			
					if(flagEmail[0].equals("1") && flagEmail.length > 1){
						//sendEmail.add(flagEmail[1]);						
						arrNtcDtls.setNtcEml(flagEmail[1]);
						arrNtcDtls.setEmlSndUsrId(account.getUsr_id());				
						//arrNtcDtls.setEmlSndFlg(""); 
						arrNtcDtls.setCreUsrId(account.getUsr_id());
						arrNtcDtls.setUpdUsrId(account.getUsr_id());						
						
						int modResult = dbDao.modifyArrNtcDtlByMail(arrNtcDtls, account);
						if(modResult == 0){
							dbDao.addArrNtcDtlByMail(arrNtcDtls, account);
						}
				
					}
				}
			}
			
			for(int i=0;i<arrCustCntcTpCd.length;i++){
				log.debug("------------ vEmail.get(i) "+vEmail.get(i));
				String[] flagEmail = (vEmail.get(i).toString()).split("\\|");
				if(flagEmail[0].equals("1") && flagEmail.length > 1){					
					sendEmail.add(flagEmail[1]);									
				}			
			}
			
			if( !StringUtils.isBlank(copyEml) ){	
				sendEmail.add(copyEml);
			}
				
			RDMailSendVO[] mailInfos = new RDMailSendVO[sendEmail.size()];
			List<String> retEmlSndId = new ArrayList<String>();
			for(int x=0;x<sendEmail.size();x++){
			

				RDMailSendVO mailInfo = new RDMailSendVO();
				
				// RD Setting
				List<ComRptDsgnXptInfoVO> rdVOs = new ArrayList<ComRptDsgnXptInfoVO>();					
				
				ComRptDsgnXptInfoVO rdVO = new ComRptDsgnXptInfoVO();	
				rdVO.setCreUsrId(account.getUsr_id());
				rdVO.setUpdUsrId(account.getUsr_id());
				
				
				if(divCd.equals("C")){//Combine
					log.debug("------------ Combine 입니다.");
					
					rdVO.setXptFileNm("Group_AN_"+custCd+scNo    +".pdf");
					rdVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
					rdVO.setRdTmpltNm("ESM_BKG_0918.mrd");
					
					StringBuffer strArg = new StringBuffer("/rv ");
					
					strArg.append(" form_bkgNo[(")  .append(bkgNoStr)                 .append(")]");
					strArg.append(" form_usrId['")  .append(account.getUsr_id())      .append("']");
					strArg.append(" form_loclFlg['Y']");
					strArg.append(" form_tsFlg['")  .append(arrNtcGrpSendLists[0].getTsFlg()).append("']");
					strArg.append(" form_rvisFlg['")  .append(arrNtcGrpSendLists[0].getRvisFlg()).append("']");
					strArg.append(" form_usrTo['")  .append(arrNtcGrpSendLists[0].getCustNm()).append("']");
					strArg.append(" form_remarkCtnt['']");
					strArg.append(" form_ofcCd['")  .append(account.getOfc_cd())     .append("']");
					
//					String strArg = "/rv ";
//					strArg = strArg + " form_bkgNo[(" + bkgNoStr + ")]";
//					strArg = strArg + " form_usrId['" + account.getUsr_id() + "']";
//					strArg = strArg + " form_loclFlg['Y']";				
//					strArg = strArg + " form_tsFlg['" + arrNtcGrpSendLists[0].getTsFlg()+ "']";
//					
//					strArg = strArg + " form_rvisFlg['" + arrNtcGrpSendLists[0].getRvisFlg()+ "']";
//					strArg = strArg + " form_usrTo['"      +arrNtcGrpSendLists[0].getCustNm() +   "']";
//					strArg = strArg + " form_remarkCtnt['']";
//					strArg = strArg + " form_ofcCd['" + account.getOfc_cd() + "']";
					
//					strArg = strArg.trim();
//					log.debug("----------- strArg "+strArg );
					rdVO.setRdParaCtnt(strArg.toString().trim());
					rdVOs.add(rdVO);
					
					
					
					
					ArrNtcMrdSearchVO arrNtcMrdSearch = new ArrNtcMrdSearchVO();
					
					log.debug("--------------------------------");
					log.debug("MRD 관련 정보를 구하기  Start ");
					log.debug("--------------------------------");
					arrNtcMrdSearch.setBkgNo(orgBkgNo);
					arrNtcMrdSearch.setUsrId(account.getUsr_id());
					arrNtcMrdSearch.setOfcCd(account.getOfc_cd());
					
					ArrNtcMrdVO mrdVO = this.searchArrNtcMrdId(arrNtcMrdSearch);
					log.error("ERR Log arrNtcMrdSearch : " + arrNtcMrdSearch);
					log.error("ERR Log mrdVO : " + mrdVO);
					String eclzBlCpyFlg = mrdVO.getEclzBlCpyFlg();
					
					
					log.debug("--------------------------------");
					log.debug("MRD 관련 정보를 구하기  End ");
					log.debug("--------------------------------");
					
					
					
					for(int j=0;j<arrNtcGrpSendLists.length;j++){				
						ArrNtcGrpSendListVO arrGrpSendList = (ArrNtcGrpSendListVO)arrNtcGrpSendLists[j];
						custNm = arrGrpSendList.getCustNm();
						
						if(eclzBlCpyFlg.equals("Y")){
							rdVO = new ComRptDsgnXptInfoVO();	
							rdVO.setCreUsrId(account.getUsr_id());
							rdVO.setUpdUsrId(account.getUsr_id());
							
							StringBuffer strArgObl = new StringBuffer("/rv ");
							
							strArgObl.append(" form_bkgNo[('").append(arrGrpSendList.getBkgNo()).append("')]");
							strArgObl.append(" form_type[2]");// ---> Default
							strArgObl.append(" form_dataOnly[N]");// ---> Default
							strArgObl.append(" form_manifest[N]");// ---> Default
							strArgObl.append(" form_usrId[").append(account.getUsr_id()).append("]");
							strArgObl.append(" form_hiddeData[N]");// ---> Default
							strArgObl.append(" form_level[(6)]");// ---> Default (ex - (1,2,3,4,5))
							strArgObl.append(" form_remark[]");// ---> Default
							strArgObl.append(" form_Cntr[1]");// ---> Default
							strArgObl.append(" form_mainOnly[N]");// ---> Default
							strArgObl.append(" form_CorrNo[]");// ---> Default
							strArgObl.append(" form_his_cntr[BKG_CONTAINER]");// ---> Default
							strArgObl.append(" form_his_bkg[BKG_BOOKING]");// ---> Default
							strArgObl.append(" form_his_mkd[BKG_BL_MK_DESC]");// ---> Default
							strArgObl.append(" form_his_xpt[BKG_XPT_IMP_LIC]");// ---> Default
							strArgObl.append(" form_his_bl[BKG_BL_DOC]");// ---> Default
						    
							strArgObl.append(" form_rqst_via_cd[]");// ---> Default
							strArgObl.append(" form_his_bl_mkd[BKG_BL_ISS]");// ---> Default
							strArgObl.append(" form_path[]");// ---> Default
							strArgObl.append(" isEncode[Y]");// ---> Default
							strArgObl.append(" form_end_no[]");// ---> Default
							strArgObl.append(" form_esig[] form_cpy_esig[] form_knt_flg[] form_count[]");// ---> Default							    
						    
							strArgObl.append(" /rp []");// ---> Default
							strArgObl.append(" /riprnmargin");
							
//							strArg = "/rv ";
//							
//							strArg = strArg + " form_bkgNo[('" + arrGrpSendList.getBkgNo() + "')]";
//						    strArg = strArg + " form_type[2]";// ---> Default
//						    strArg = strArg + " form_dataOnly[N]";// ---> Default
//						    strArg = strArg + " form_manifest[N]";// ---> Default
//						    strArg = strArg + " form_usrId[" + account.getUsr_id() + "]";
//						    strArg = strArg + " form_hiddeData[N]";// ---> Default
//						    strArg = strArg + " form_level[(6)]";// ---> Default (ex - (1,2,3,4,5))
//						    strArg = strArg + " form_remark[]";// ---> Default
//						    strArg = strArg + " form_Cntr[1]";// ---> Default
//						    strArg = strArg + " form_mainOnly[N]";// ---> Default
//						    strArg = strArg + " form_CorrNo[]";// ---> Default
//						    strArg = strArg + " form_his_cntr[BKG_CONTAINER]";// ---> Default
//						    strArg = strArg + " form_his_bkg[BKG_BOOKING]";// ---> Default
//						    strArg = strArg + " form_his_mkd[BKG_BL_MK_DESC]";// ---> Default
//						    strArg = strArg + " form_his_xpt[BKG_XPT_IMP_LIC]";// ---> Default
//						    strArg = strArg + " form_his_bl[BKG_BL_DOC]";// ---> Default
//						    
//						    // 2015.01.14 안진응 추가
//						    strArg = strArg + " form_rqst_via_cd[]";
//						    strArg = strArg + " form_his_bl_mkd[BKG_BL_ISS]";
//						    strArg = strArg + " form_path[]";
//						    strArg = strArg + " isEncode[Y]";
//						    strArg = strArg + " form_end_no[]";				
//						    strArg = strArg + " form_esig[] form_cpy_esig[] form_knt_flg[] form_count[]";				
//						    
//						    strArg = strArg + " /rp []";// ---> Default
//						    strArg = strArg + " /riprnmargin";
//							
//							strArg = strArg.trim();
//							log.debug("---------- strArg "+ strArg);
//							log.debug("------- O/B BL을 첨부하여 메일을 발송합니다.");
							
							rdVO.setXptFileNm("OBL_" +arrGrpSendList.getBlNo() + ".pdf");
							rdVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
							rdVO.setRdTmpltNm("ESM_BKG_0109_OBL_A4.mrd");
							rdVO.setRdParaCtnt(strArgObl.toString().trim());
							
							log.debug("----------XXXXXXXXXXXX "+rdVO.getCreUsrId());
							
							rdVOs.add(rdVO);
						}
						
					}
					
					
				}else if(divCd.equals("S")){
					
					for(int j=0;j<arrNtcGrpSendLists.length;j++){				
						ArrNtcGrpSendListVO arrGrpSendList = (ArrNtcGrpSendListVO)arrNtcGrpSendLists[j];
						custNm = arrGrpSendList.getCustNm();
						
						ArrNtcMrdSearchVO arrNtcMrdSearch = new ArrNtcMrdSearchVO();
						
						log.debug("--------------------------------");
						log.debug("MRD 관련 정보를 구하기  Start ");
						log.debug("--------------------------------");
						arrNtcMrdSearch.setBkgNo(orgBkgNo);
						arrNtcMrdSearch.setUsrId(account.getUsr_id());
						arrNtcMrdSearch.setOfcCd(account.getOfc_cd());
						
						ArrNtcMrdVO mrdVO = this.searchArrNtcMrdId(arrNtcMrdSearch);
						String mrdId = mrdVO.getMrdId();
						String loclLangFlg = mrdVO.getLoclLangFlg();
						log.error("ERR Log arrNtcMrdSearch : " + arrNtcMrdSearch);
						log.error("ERR Log mrdVO : " + mrdVO);
						String eclzBlCpyFlg = mrdVO.getEclzBlCpyFlg();
						String comParam = mrdVO.getComParam();
						
						log.debug("--------------------------------");
						log.debug("MRD 관련 정보를 구하기  End ");
						log.debug("--------------------------------");
						
						rdVO = new ComRptDsgnXptInfoVO();
						rdVO.setCreUsrId(account.getUsr_id());
						rdVO.setUpdUsrId(account.getUsr_id());
						
						
						rdVO.setXptFileNm("AN_"+ arrGrpSendList.getBlNo() + ".pdf");
						rdVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
						rdVO.setRdTmpltNm(mrdId + ".mrd");
						
						
						StringBuffer strArg = new StringBuffer("/rv ");
						
						strArg.append(" form_bkgNo[('")  .append(arrGrpSendList.getBkgNo()) .append("')]");
						strArg.append(" form_usrId['")  .append(account.getUsr_id())      .append("']");
						strArg.append(" form_loclFlg['")  .append(loclLangFlg)      .append("']");
						strArg.append(" form_tsFlg['")  .append(arrGrpSendList.getTsFlg()).append("']");
						strArg.append(" form_chgDpFlg['0']");
						strArg.append(" form_remarkCtnt['']");
						strArg.append(" form_ofcCd['")  .append(account.getOfc_cd())     .append("']");
						strArg.append(" ").append(comParam);
						
						
//						String strArg = "/rv ";                                                                                                 
//						strArg = strArg + " form_bkgNo[(" + bkgNoStr + ")]";
//						strArg = strArg + " form_usrId['" + account.getUsr_id() + "']";
//						strArg = strArg + " form_loclFlg['" + loclLangFlg + "']";
//						strArg = strArg + " form_tsFlg['" + arrGrpSendList.getTsFlg() + "']";
//						strArg = strArg + " form_chgDpFlg['4']";
//						strArg = strArg + " form_remarkCtnt['']";
//						strArg = strArg + " form_ofcCd['" + account.getOfc_cd() + "']";
//						
//						strArg = strArg + " "+comParam;
						
//						strArg = strArg.trim();
						
//						log.debug("----------- strArg "+strArg );
						rdVO.setRdParaCtnt(strArg.toString().trim());
						rdVOs.add(rdVO);
						
						
						if(eclzBlCpyFlg.equals("Y")){
							rdVO = new ComRptDsgnXptInfoVO();
							rdVO.setCreUsrId(account.getUsr_id());
							rdVO.setUpdUsrId(account.getUsr_id());
							
							StringBuffer strArgObl = new StringBuffer("/rv ");
							
							strArgObl.append(" form_bkgNo[('").append(arrGrpSendList.getBkgNo()).append("')]");
							strArgObl.append(" form_type[2]");// ---> Default
							strArgObl.append(" form_dataOnly[N]");// ---> Default
							strArgObl.append(" form_manifest[N]");// ---> Default
							strArgObl.append(" form_usrId[").append(account.getUsr_id()).append("]");
							strArgObl.append(" form_hiddeData[N]");// ---> Default
							strArgObl.append(" form_level[(6)]");// ---> Default (ex - (1,2,3,4,5))
							strArgObl.append(" form_remark[]");// ---> Default
							strArgObl.append(" form_Cntr[1]");// ---> Default
							strArgObl.append(" form_mainOnly[N]");// ---> Default
							strArgObl.append(" form_CorrNo[]");// ---> Default
							strArgObl.append(" form_his_cntr[BKG_CONTAINER]");// ---> Default
							strArgObl.append(" form_his_bkg[BKG_BOOKING]");// ---> Default
							strArgObl.append(" form_his_mkd[BKG_BL_MK_DESC]");// ---> Default
							strArgObl.append(" form_his_xpt[BKG_XPT_IMP_LIC]");// ---> Default
							strArgObl.append(" form_his_bl[BKG_BL_DOC]");// ---> Default
						    
							strArgObl.append(" form_rqst_via_cd[]");// ---> Default
							strArgObl.append(" form_his_bl_mkd[BKG_BL_ISS]");// ---> Default
							strArgObl.append(" form_path[]");// ---> Default
							strArgObl.append(" isEncode[Y]");// ---> Default
							strArgObl.append(" form_end_no[]");// ---> Default
							strArgObl.append(" form_esig[] form_cpy_esig[] form_knt_flg[] form_count[]");// ---> Default							    
						    
							strArgObl.append(" /rp []");// ---> Default
							strArgObl.append(" /riprnmargin");
							
							
//							strArg = "/rv ";
//							
//							strArg = strArg + " form_bkgNo[('" + arrGrpSendList.getBkgNo() + "')]";
//						    strArg = strArg + " form_type[2]";// ---> Default
//						    strArg = strArg + " form_dataOnly[N]";// ---> Default
//						    strArg = strArg + " form_manifest[N]";// ---> Default
//						    strArg = strArg + " form_usrId[" + account.getUsr_id() + "]";
//						    strArg = strArg + " form_hiddeData[N]";// ---> Default
//						    strArg = strArg + " form_level[(6)]";// ---> Default (ex - (1,2,3,4,5))
//						    strArg = strArg + " form_remark[]";// ---> Default
//						    strArg = strArg + " form_Cntr[1]";// ---> Default
//						    strArg = strArg + " form_mainOnly[N]";// ---> Default
//						    strArg = strArg + " form_CorrNo[]";// ---> Default
//						    strArg = strArg + " form_his_cntr[BKG_CONTAINER]";// ---> Default
//						    strArg = strArg + " form_his_bkg[BKG_BOOKING]";// ---> Default
//						    strArg = strArg + " form_his_mkd[BKG_BL_MK_DESC]";// ---> Default
//						    strArg = strArg + " form_his_xpt[BKG_XPT_IMP_LIC]";// ---> Default
//						    strArg = strArg + " form_his_bl[BKG_BL_DOC]";// ---> Default
//						    
//						    // 2015.01.14 안진응 추가
//						    strArg = strArg + " form_rqst_via_cd[]";
//						    strArg = strArg + " form_his_bl_mkd[BKG_BL_ISS]";
//						    strArg = strArg + " form_path[]";
//						    strArg = strArg + " isEncode[Y]";
//						    strArg = strArg + " form_end_no[]";				
//						    strArg = strArg + " form_esig[] form_cpy_esig[] form_knt_flg[] form_count[]";				
//						    
//						    strArg = strArg + " /rp []";// ---> Default
//						    strArg = strArg + " /riprnmargin";
							 
//							strArg = strArg.trim();
//							log.debug("---------- strArg "+ strArg);
//							log.debug("------- O/B BL을 첨부하여 메일을 발송합니다.1111");
							rdVO.setXptFileNm("OBL_" +arrGrpSendList.getBlNo() + ".pdf");
							rdVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
							rdVO.setRdTmpltNm("ESM_BKG_0109_OBL_A4.mrd");
							rdVO.setRdParaCtnt(strArgObl.toString().trim());
							
							
							
							rdVOs.add(rdVO);
						}
						
					}
					
				}	
				
				String nextVvd ="";				
				StringBuffer vvdStr = new StringBuffer(""); //[BKG_IND] Redmine40604- Arrival Notice Group mail title에 VVD 포함시키기 by 조원주
			
				
				for(int j=0;j<arrNtcGrpSendLists.length;j++){
					
					log.debug("*********************VVD****************************"+arrNtcGrpSendLists[j].getVvd());
					    
					   String currVvd = arrNtcGrpSendLists[j].getVvd();
											
					   if(!nextVvd.equals(currVvd)){
						   vvdStr.append(arrNtcGrpSendLists[j].getVvd());	
					   }
					  
					   if(nextVvd.equals(currVvd)) continue;
											
					   nextVvd = currVvd;
					
					   if(j != (arrNtcGrpSendLists.length-1) ){
					
						vvdStr.append("  ");

					   }
					
					}
				
				mailInfo.setComRptDsgnXptInfoVOs(rdVOs);
				
				mailInfo.setSndrNm("shipment.info@notifications.nykline.com");
				mailInfo.setSndrEml("shipment.info@notifications.nykline.com");
				mailInfo.setRcvrEml(sendEmail.get(x).toString());
				mailInfo.setRcvrNm(custNm);
				mailInfo.setEmlTitNm("Arrival Notice (Group) - " + vvdStr);
				mailInfo.setTemplate("ESM_BKG_0381_01T.html");
				//20160328. BCC email ADD				
				if( !StringUtils.isBlank(bccRcvrEml) ){	
//					mailInfo.setBccRcvrEml(bccRcvrEml);
					mailInfo.setBccRcvrEml(bccRcvrEml);					
					log.debug("-------------------- getBccRcvrEml : " + sendEmail);
				}	
				mailInfo.setUserId(account.getUsr_id());				
				HashMap<String, String> arguments = new HashMap<String, String>();
				arguments.put("rcvrNm", custNm);
				mailInfo.setArguments(arguments);		
				
				mailInfos[x] = mailInfo;				
				
				retEmlSndId.add(eaiDao.sendReportDesignerWithFiles(mailInfo,rdVOs));
			
			}
			
			for(int j=0;j<arrNtcGrpSendLists.length;j++){
				
				ArrNtcGrpSendListVO arrGrpSendList = (ArrNtcGrpSendListVO)arrNtcGrpSendLists[j];
				int y=0;
				for(int i=0;i<arrCustCntcTpCd.length;i++){
					String[] flagEmail = (vEmail.get(i).toString()).split("\\|");
					//0|   ,1|sackso@nate.com      ,0|     ,0|     ,0|    ,
					//log.debug("-------------- vEmail "+vEmail.get(i).toString());				
					
			
					if(flagEmail[0].equals("1") && flagEmail.length > 1){		
						arrNtcDtls.setBkgNo(arrGrpSendList.getBkgNo());
						arrNtcDtls.setEmlNtcSndId(retEmlSndId.get(y));		
						arrNtcDtls.setCustCntcTpCd(arrCustCntcTpCd[i]);
						dbDao.modifyArrNtcSendIdByMail(arrNtcDtls, account);
						
					
						BkgNtcHisVO hisVO = new BkgNtcHisVO();
						hisVO.setNtcViaCd("M");
						hisVO.setSndId(retEmlSndId.get(y));
						hisVO.setSndOfcCd(account.getOfc_cd());
						hisVO.setSndUsrId(account.getUsr_id());
						hisVO.setCreUsrId(account.getUsr_id());
						hisVO.setUpdUsrId(account.getUsr_id());
						hisVO.setBkgNo(arrNtcDtls.getBkgNo());
						hisVO.setBkgCustTpCd(arrNtcDtls.getBkgCustTpCd());
						hisVO.setCustCntcTpCd(arrCustCntcTpCd[i]);
						
						hisVOS.add(dbDao.searchArrNtcHistory(hisVO));
					y = y + 1;
					}
				}
			}
		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), ex);
		}   
		
		return hisVOS;
	}
	
	/**
	 * search MRD ID
	 * @param ArrNtcMrdSearchVO arrNtcMrdSearch
	 * @return ArrNtcMrdVO
	 * @exception DAOException
	 */
	public ArrNtcMrdVO searchArrNtcMrdId( ArrNtcMrdSearchVO arrNtcMrdSearch) throws EventException{
		ArrNtcMrdVO arrNtcMrdVo = new ArrNtcMrdVO();
		try{
			
			arrNtcMrdVo = dbDao.searchArrNtcMrdId(arrNtcMrdSearch);	
		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}       
       
        return arrNtcMrdVo;
	}

	/**
	 * 1099   Integrated Customer Data Update Setup retrieve
	 * @param String ofcCd
	 * @return bkgIbCustCntcStupVO
	 * @exception EventException
	 * @author
	 */
	public BkgIbCustCntcStupVO searchIntgCustCntcUpdtStupInfoByOfc(String ofcCd) throws EventException
	{
		BkgIbCustCntcStupVO bkgIbCustCntcStupVO = null;
		try 
		{
			bkgIbCustCntcStupVO = dbDao.searchIntgCustCntcUpdtStupInfoByOfc(ofcCd);
        }catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		return bkgIbCustCntcStupVO;
	}
	
	/**
     * UI-BKG-1099 save Integrated Customer Data Update Setup Master & History
	 * @param BkgIbCustCntcStupVO bkgIbCustCntcStupVo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	
	public void manageIntgCustCntcUpdtStupInfoByOfc(BkgIbCustCntcStupVO bkgIbCustCntcStupVo, SignOnUserAccount account)throws EventException
	{
		int result = 0;
		BkgIbCustCntcStupHisVO bkgIbCustCntcStupHisVO = null;
		try 
		{
			
			bkgIbCustCntcStupVo.setCreUsrId(account.getUsr_id());
			bkgIbCustCntcStupVo.setUpdUsrId(account.getUsr_id());
			
			result = dbDao.modifyIntgCustCntcUpdtStupInfoByOfc(bkgIbCustCntcStupVo);
			if(result == 0)
			{
				dbDao.addIntgCustCntcUpdtStupInfoByOfc(bkgIbCustCntcStupVo);
			}
			
			bkgIbCustCntcStupHisVO = new BkgIbCustCntcStupHisVO();
			bkgIbCustCntcStupHisVO.setOfcCd(bkgIbCustCntcStupVo.getOfcCd());
			bkgIbCustCntcStupHisVO.setNewAutoUpdFlg(bkgIbCustCntcStupVo.getAutoUpdFlg());
			bkgIbCustCntcStupHisVO.setCngUsrId(bkgIbCustCntcStupVo.getUpdUsrId());
			bkgIbCustCntcStupHisVO.setCreUsrId(bkgIbCustCntcStupVo.getUpdUsrId());
			bkgIbCustCntcStupHisVO.setUpdUsrId(bkgIbCustCntcStupVo.getUpdUsrId());
			dbDao.addIntgCustCntcUpdtStupInfoHisByOfc(bkgIbCustCntcStupHisVO);
			
        }catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), ex);
        }
	}
	
	/**
     * save MDM Customer data for Customer Code Validation
	 * @param List<MdmCustomerVO> mdmCustomerVOs
	 * @return boolean
	 * @exception EventException
	 */
	public boolean mergeBkgCustCdVal(List<MdmCustomerVO> mdmCustomerVOs)throws EventException{
		boolean isSuccessful = false;
		try {
			isSuccessful = dbDao.mergeBkgCustCdVal(mdmCustomerVOs);
        }catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), ex);
        }
		return isSuccessful;
	}
	/**
	 * Back End Job 공통 - Back End Job Status 조회
	 * (동일 Package에 Back End Job이 여러개일때 공통으로 사용)
	 *
	 * @param String backEndJobKey
	 * @return String
	 * @exception EventException
	 */
	public String getBackEndJobStatus(String backEndJobKey) throws EventException {
		String result = "";
		try {
			DBRowSet rowSet = new BackEndJobMetaDataSelector(backEndJobKey).getDbRowset();
			while (rowSet.next()) result = rowSet.getObject("jb_sts_flg").toString();
			return result;
		} catch(BackEndJobException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(SQLException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * [ESM_BKG_0381] : A/N
	 *  A/N sending - Back End Job 시작<br>
	 *  Arrival Notice email 전송
	 *
	 * @param String backEndJobKey
	 * @return String
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> resultBackEndJobSendArrivalNoticeEmail(String backEndJobKey) throws EventException {
		try {
			return (List<BkgNtcHisVO>)BackEndJobResult.loadFromFile(backEndJobKey);
		} catch(BackEndJobException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [ESM_BKG_0381] : A/N
	 *  A/N sending - Back End Job 시작<br>
	 * Arrival Notice email 전송
	 *
	 * @param ArrNtcSendListVO[] listVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @return String
	 */
	public String startBackEndJobArrivalNoticeSendEmail(ArrNtcSendListVO[] listVOs, SignOnUserAccount signOnUserAccount) throws EventException {
		ArrivalNoticeSendEmailBackEndJob backEndJob = new ArrivalNoticeSendEmailBackEndJob();
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		try {
	
			backEndJob.setListVOS(listVOs);
			backEndJob.setSignOnUserAccount(signOnUserAccount);
			return backEndJobManager.execute(backEndJob, signOnUserAccount.getUsr_id(), "ESM_BKG_0381 : A/N - Send");
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}
	
}