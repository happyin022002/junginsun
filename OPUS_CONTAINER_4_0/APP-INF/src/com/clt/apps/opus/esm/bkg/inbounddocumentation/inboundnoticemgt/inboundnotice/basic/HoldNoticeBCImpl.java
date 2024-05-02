/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : HoldNoticeBCImpl.java
*@FileTitle : Hold Mail/Alert Set-Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 
*@LastVersion : 1.0
* 2009.05.06 
* 1.0 Creation
* --------------------------------------------------------------------------------------
* History
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo;

import com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgHrdCdgCtntListCondVO;
import com.clt.apps.opus.esm.bkg.common.CountryCode;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration.HoldNoticeDBDAO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration.InboundNoticeEAIDAO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ConfirmHldNtcSendListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.CstmsHldVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.CustInfoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.FaxSendVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.HldNtcBkgStaffSetupInfoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.HldNtcObStaffSetupInfoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.HldNtcSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.HldNtcStaffInfoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.HoldNoticeFormVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PreHldNtcSendListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.RDMailSendVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.TmpMailSendVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.TpbInfoVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.framework.table.ComRptDsgnXptInfoVO;
import com.clt.syscommon.common.table.BkgBookingVO;
import com.clt.syscommon.common.table.BkgCstmsAdvDspoVO;
import com.clt.syscommon.common.table.BkgHldN3rdPtyBilCntrVO;
import com.clt.syscommon.common.table.BkgHldNtcDtlVO;
import com.clt.syscommon.common.table.BkgHldNtcUsrVO;
import com.clt.syscommon.common.table.BkgHldNtcVO;
import com.clt.syscommon.common.table.BkgHldWdDtlVO;
import com.clt.syscommon.common.table.BkgHldWdVO;
import com.clt.syscommon.common.table.BkgHrdCdgCtntVO;
import com.clt.syscommon.common.table.BkgNtcHisVO;


/**
 *   InboundBLMgt Business Logic Basic Command implementation<br>
 * - InboundBLMgt business logic handling.<br>
 *
 * @author
 * @see ESM_BKG-0948EventResponse,HoldNoticeBC each DAO class reference
 * @since J2EE 1.4
 */

public class HoldNoticeBCImpl extends BasicCommandSupport implements HoldNoticeBC {

	// Database Access Object
	private transient HoldNoticeDBDAO dbDao = null;

	/**
	 * HoldNoticeBCImpl object creation<br>
	 * ${DAO}DAO creation.<br>
	 */
	public HoldNoticeBCImpl() {
		dbDao = new HoldNoticeDBDAO();
	}
	
	/**
	 * Hold Mail/Alert Set-Up(UI_BKG-0948)retrieve event handling.<br>
	 * 
	 * @param String cstmsLocCd Location Code
	 * @param String userId User ID
	 * @return List<BkgHldNtcUsrVO>  by Staff, Setting Hold Notice info
	 * @exception EventException
	 */
	public List<BkgHldNtcUsrVO> searchHldNtcUsr(String cstmsLocCd, String userId) throws EventException {
		try {
			return dbDao.searchHldNtcUsr(cstmsLocCd, userId);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
	}
	
	/**
	 * Hold Mail/Alert Set-Up(UI_BKG-0948) multi event handling<br>
	 * 
	 * @param BkgHldNtcUsrVO[] hldNtcUsrs Hold Notice User list
	 * @param SignOnUserAccount account SignOn User Account
	 * @exception EventException
	 */
	public void setupHldNtcUsr(BkgHldNtcUsrVO[] hldNtcUsrs, SignOnUserAccount account) throws EventException{
		try {
			List<BkgHldNtcUsrVO> updateVoList = new ArrayList<BkgHldNtcUsrVO>();
			List<BkgHldNtcUsrVO> deleteVoList = new ArrayList<BkgHldNtcUsrVO>();
			
			for ( int i=0; i<hldNtcUsrs.length; i++ ) {
				if ( hldNtcUsrs[i].getIbflag().equals("I") || hldNtcUsrs[i].getIbflag().equals("U")){
					hldNtcUsrs[i].setCreUsrId(account.getUsr_id());
					hldNtcUsrs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(hldNtcUsrs[i]);
				} else if ( hldNtcUsrs[i].getIbflag().equals("D")){
					deleteVoList.add(hldNtcUsrs[i]);
				}
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeHldNtcUsr(deleteVoList);
			}

			for (int i=0; i<updateVoList.size(); i++) {
				if ("Y".equals(updateVoList.get(i).getNtcEnblFlg())) {
					if (validationHldNtcUsr(updateVoList.get(i)) == false) {
						throw new EventException(new ErrorHandler("BKG00488", new String[] {Integer.toString(i+1)}).getMessage());
					}
				}

				if (dbDao.modifyHldNtcUsr(updateVoList.get(i)) == 0) {
					dbDao.addHldNtcUsr(updateVoList.get(i));
				}
			}
			
        } catch(EventException ex) {
        	throw ex;
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
	}
	
	/**
	 * Hold Code info in special country retrieve.<br>
	 * 
	 * @param String cntCd 
	 * @return List<BkgHldCdVO> Hold Code Data
	 * @exception EventException
	 */
	public List<BkgComboVO> searchHldNtcCode(String cntCd) throws EventException {
		try {
			// used search condition(country Code +Hold Code), Setup info retrieve.
			return dbDao.searchHldNtcCode(cntCd);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
	}
	
	/**
	 * Hold Notice User info validation.
	 * 1. POD validation.
	 * 2. duple-data checking.<br>
	 * 
	 * @param BkgHldNtcUsrVO hldNtcUsr Hold Notice User
	 * @return boolean
	 * @exception EventException
	 */
	private boolean validationHldNtcUsr (BkgHldNtcUsrVO hldNtcUsr) throws EventException {
		try {
			// duple-data checking
			if (dbDao.checkHldNtcUsrDup(hldNtcUsr) == true) {
				return false;
			} return true;
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
	}
	
	
	/**
	 * POD list info retrieve. <br>
	 * 
	 * @param String ofcCd
	 * @param String hldNtcTpCd
	 * @return List<BkgHldWdVO>
	 * @exception EventException
	 */
	public List<BkgHldWdVO> searchHldNtcFormPodList (String ofcCd, String hldNtcTpCd) throws EventException {
		try {
			return dbDao.searchHldNtcFormPodList(ofcCd, hldNtcTpCd);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
	}
	
	/**
	 * Form Setup info retrieve. <br>
	 * 
	 * @param String	ofcCd 
	 * @param String	podCd
	 * @return List<HoldNoticeFormVO>
	 * @exception EventException
	 */
	public HoldNoticeFormVO searchHldNtcPreForm (String ofcCd, String podCd) throws EventException {
		try {
			HoldNoticeFormVO hldNtcForm = new HoldNoticeFormVO();
			
			String ntcTpCd = "PH";
			
			/* Hold Notice Word */
			hldNtcForm.setBkgHldWd(dbDao.searchHldNtcForm(ofcCd, podCd, ntcTpCd));
			
			/* Hold Notice Word Detail */
			hldNtcForm.setBkgHldWdDtls(dbDao.searchHldNtcFormDtl(ofcCd, podCd, ntcTpCd));
			
			return hldNtcForm;
			
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
	}
	
	/**
	 * Hold Notice ( Pre-Hold ) Form info manage.<br>
	 * 
	 * @param HoldNoticeFormVO[]	hldNtcForm
	 * @param SignOnUserAccount	account 
	 * @exception EventException
	 */
	public void setupHldNtcPreForm(BkgHldWdVO hldWd, BkgHldWdDtlVO[] hldWdDtls, SignOnUserAccount account) throws EventException {
		try {
			List<BkgHldWdVO>    insertVoList    = new ArrayList<BkgHldWdVO>();
			List<BkgHldWdDtlVO> insertDtlVoList = new ArrayList<BkgHldWdDtlVO>();				
			
			/* Hold Notice Word*/
			hldWd.setCreUsrId(account.getUsr_id());
			hldWd.setUpdUsrId(account.getUsr_id());
			insertVoList.add(hldWd);
			
			/* Hold Notice Detail */
			for (int i=0; i<hldWdDtls.length; i++) {
				BkgHldWdDtlVO bkgHldWdDtl = hldWdDtls[i];

				bkgHldWdDtl.setCreUsrId(account.getUsr_id());
				bkgHldWdDtl.setUpdUsrId(account.getUsr_id());
				insertDtlVoList.add(bkgHldWdDtl);
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.mergeHldNtcForm(insertVoList);
			}
						
			if ( insertDtlVoList.size() > 0 ) {
				dbDao.mergeHldNtcFormDtl(insertDtlVoList);
			}

        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
	}
	
	
	/**
	 * H/N Form Master info remove.<br>
	 * 
	 * @param String ofcCd
	 * @param String podCd
	 * @param String ntcTpCd
	 * @exception EventException
	 */
	public void removeHldNtcForm(String ofcCd, String podCd, String ntcTpCd) throws EventException {

		try {

			dbDao.removeHldNtcFormDtl(ofcCd, podCd, ntcTpCd);
			dbDao.removeHldNtcForm(ofcCd, podCd, ntcTpCd);
			
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
	}

	/**
	 * Pre-Hold Notice Setup info Check.<br>
	 * 
	 * @param String ofcCd
	 * @param String podCd
	 * @param String ntcTpCd
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkHldNtcFormExist(String ofcCd, String podCd, String ntcTpCd) throws EventException {
		try {
			return dbDao.checkHldNtcFormExist(ofcCd, podCd, ntcTpCd);			
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
	}
	
	/**
	 *  Pre-Hold Notice Setup info Copy.<br>
	 * 
	 * @param String toOfcCd
	 * @param String toPodCd
	 * @param String fmOfcCd
	 * @param String fmPodCd
	 * @param String ntcTpCd
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyHldNtcPreForm(String toOfcCd, String toPodCd, String fmOfcCd, String fmPodCd, String ntcTpCd, SignOnUserAccount account) throws EventException {
		try {
			dbDao.copyHldNtcPreForm(toOfcCd, toPodCd, fmOfcCd, fmPodCd, ntcTpCd, account.getUsr_id());			
			dbDao.copyHldNtcPreFormDtl(toOfcCd, toPodCd, fmOfcCd, fmPodCd, ntcTpCd, account.getUsr_id());;			
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
	}

	
	/**
	 *  pre-transmited Hold info in manifest EDI info, Pre-Hold Notice info retrieve. ( In USA)<br>
	 *  
	 * @param HldNtcSearchVO hldNtcSearch
	 * @return List<PreHldNtcSendListVO>
	 * @exception EventException
	 */
	public List<PreHldNtcSendListVO> searchHldNtcSendListByPre(HldNtcSearchVO hldNtcSearch) throws EventException {
		try {
			return dbDao.searchHldNtcSendListByPre(hldNtcSearch);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
	}
	
	
	/**
	 * Hold Clear(Confirm) info retrieve.(In USA)<br>
	 *  
	 * @param HldNtcSearchVO hldNtcSearch
	 * @return List<PreHldNtcSendListVO>
	 * @exception EventException
	 */
	public List<ConfirmHldNtcSendListVO> searchHldNtcSendListByConfirm(HldNtcSearchVO hldNtcSearch) throws EventException {
		try {
			return dbDao.searchHldNtcSendListByConfirm(hldNtcSearch);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
	}
	
	/**
	 * Hold Notice Setup info Check.<br>
	 * 
	 * @param String ofcCd
	 * @param String podCd
	 * @param String hldNtcTpCd
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkHldNtcFormExistByNtcType(String ofcCd, String podCd, String hldNtcTpCd) throws EventException {
		try {
			return dbDao.checkHldNtcFormExistByNtcType(ofcCd, podCd, hldNtcTpCd);			
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
	}
	
	
	/**
	 * Pre Hold info send by Fax.<br>
	 * 
	 * @param PreHldNtcSendListVO[] preHldNtcSendLists
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO>
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> sendPreHldNtcByFax (PreHldNtcSendListVO[] preHldNtcSendLists, SignOnUserAccount account) throws EventException {
		BkgHldNtcVO hldNtc = null;
		BkgHldNtcDtlVO hldNtcDtl = null;
		PreHldNtcSendListVO vo = null;
		FaxSendVO faxInfo = null;
		
		InboundNoticeEAIDAO eaiDao = new InboundNoticeEAIDAO();
		String sendId = null;
		BkgNtcHisVO bkgNtcHisVO = null;
		List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
		
		try {			
			
			for (int i=0; i<preHldNtcSendLists.length; i++) {
				
				/* 1. Save Hold Notice */
				vo = preHldNtcSendLists[i];
				
				hldNtc = new BkgHldNtcVO();

				hldNtc.setBkgNo(vo.getBkgNo());
				hldNtc.setNtcSeq(vo.getNtcSeq());
				hldNtc.setHldNtcTpCd(vo.getHldNtcTpCd());
				hldNtc.setCstmsHldNtcFomCd(vo.getCstmsHldNtcFomCd());
				hldNtc.setCstmsHldLocCd(vo.getCstmsHldLocCd());
				hldNtc.setCustCntCd(vo.getCustCntCd());
				hldNtc.setCustSeq(vo.getCustSeq());
				hldNtc.setCustNm(vo.getCustNm());
				hldNtc.setCstmsPreHldCd(vo.getCstmsPreHldCd());
				hldNtc.setPreHldDt(vo.getPreHldDt());
				hldNtc.setHldEclzOblFlg(vo.getHldEclzOblFlg());
				hldNtc.setHldDiffRmk(vo.getHldDiffRmk());
				hldNtc.setCreUsrId(account.getUsr_id());
				hldNtc.setUpdUsrId(account.getUsr_id());

				dbDao.modifyHldNtc(hldNtc);
				
				
				/* 2. Save Hold Notice Detail */
				hldNtcDtl = new BkgHldNtcDtlVO();
				
				hldNtcDtl.setBkgNo(vo.getBkgNo());
				hldNtcDtl.setNtcSeq(vo.getNtcSeq());
				hldNtcDtl.setCustCntcTpCd(vo.getCustCntcTpCd());
				hldNtcDtl.setFaxNo(vo.getFaxNo());
				hldNtcDtl.setFaxTpCd("M");
				hldNtcDtl.setHldFaxSndUsrId(account.getUsr_id());
				hldNtcDtl.setCreUsrId(account.getUsr_id());
				hldNtcDtl.setUpdUsrId(account.getUsr_id());
								
				dbDao.modifyHldNtcDtlByFax(hldNtcDtl);
				
				
				
				/* 3. Send Fax */
				faxInfo = new FaxSendVO();

				faxInfo.setTmplMrd("ESM_BKG_0761.mrd");
				faxInfo.setSysCd("BKG");
				faxInfo.setBatchFlg("N");
				faxInfo.setTitle("Hold Notice(BL#: "+ vo.getBkgNo() +")");
				faxInfo.setTmplParam("/rv bkg_no['"+vo.getBkgNo()+"'] ntc_seq['"+vo.getNtcSeq()+"'] " + 
						             "p_usr_id['" + account.getUsr_id()+ "'] p_ofc_cd['" + vo.getOfcCd() + "']" +
						             "p_cust_nm[''] p_remark['']");
				faxInfo.setRcvInfo(vo.getCustNm().replaceAll("\r\n", " ").replaceAll(";", " ") + ";"+vo.getFaxNo());
				faxInfo.setOffice(account.getOfc_cd());
				faxInfo.setCrtUserId(account.getUsr_id());

				// Send Fax
				sendId = eaiDao.sendFax(faxInfo);
				
				
				if ("Y".equals(vo.getHldEclzOblFlg())) {
					faxInfo = new FaxSendVO();
					
					faxInfo.setTmplMrd("ESM_BKG_0109_OBL_A4.mrd");
					faxInfo.setSysCd("BKG");
					faxInfo.setBatchFlg("N");
					faxInfo.setTitle("BL Copy(BL#: "+ vo.getBkgNo() +")");
					faxInfo.setTmplParam("/rv form_bkgNo[('" + vo.getBkgNo() + "')] " +
										    " form_type[2] " +
											" form_dataOnly[N] " +
											" form_manifest[N] " +
											" form_usrId[" + account.getUsr_id() + "] " +
											" form_hiddeData[N] " +
											" form_level[(6)] " +
											" form_remark[] " +
											" form_Cntr[1] " +
											" form_mainOnly[N] " +
											" form_CorrNo[] " +
											" form_his_cntr[BKG_CONTAINER] " +
											" form_his_bkg[BKG_BOOKING] " +
											" form_his_mkd[BKG_BL_MK_DESC] " +
											" form_his_xpt[BKG_XPT_IMP_LIC] " +
											" form_his_bl[BKG_BL_DOC] " +
											
											//2015.01.27 안진응 추가
											" form_rqst_via_cd[] " +
											" form_his_bl_mkd[BKG_BL_ISS] " +
											" form_path[] " +
											" isEncode[Y] " +
											" form_end_no[] " + 	
											" form_esig[] form_cpy_esig[] form_knt_flg[] form_count[] " +
											
										 "/rp [] /riprnmargin");
					faxInfo.setRcvInfo(vo.getCustNm().replaceAll("\r\n", " ").replaceAll(";", " ") + ";"+vo.getFaxNo());
					faxInfo.setOffice(account.getOfc_cd());
					faxInfo.setCrtUserId(account.getUsr_id());

					// Send Fax
					eaiDao.sendFax(faxInfo);
				}							
				
				
				
				/* 4. SendId history */
				dbDao.modifyHldNtcSendIdByFax(vo.getBkgNo(), vo.getNtcSeq(), vo.getCustCntcTpCd(), sendId);
				
				
				
				/* 5. Notice History Setting */
				bkgNtcHisVO = new BkgNtcHisVO();
				
				bkgNtcHisVO.setNtcViaCd("F"); //F:Fax,M:Email
				bkgNtcHisVO.setSndId(sendId);
				bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
				bkgNtcHisVO.setSndUsrId(account.getUsr_id());
				bkgNtcHisVO.setCreUsrId(account.getUsr_id());
				bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
				bkgNtcHisVO.setBkgNo(vo.getBkgNo());
				bkgNtcHisVO.setNtcSeq(vo.getNtcSeq());
				bkgNtcHisVO.setCustCntcTpCd(vo.getCustCntcTpCd());
				
				bkgNtcHisVOs.add(dbDao.searchHldNtcHistory(bkgNtcHisVO));
				
			}
			
			return bkgNtcHisVOs;
			
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
	}

	
	/**
	 * Pre Hold info send by E-mail.<br>
	 * 
	 * @param PreHldNtcSendListVO[] preHldNtcSendLists
	 * @param SignOnUserAccount account
	 * @return
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> sendPreHldNtcByEmail (PreHldNtcSendListVO[] preHldNtcSendLists, SignOnUserAccount account) throws EventException {

		PreHldNtcSendListVO vo = null;

		BkgHldNtcVO hldNtc = null;
		BkgHldNtcDtlVO hldNtcDtl = null;
		BkgNtcHisVO bkgNtcHisVO = null;
		List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
		
		String tmpFileNm = "ESM_BKG_0510_HLD_PH.html";
		String titNm = "[" + ConstantMgr.getCompanyName() + "] U.S. Government Hold Notice";
		InboundNoticeEAIDAO eaiDao = new InboundNoticeEAIDAO();
		RDMailSendVO mailInfo = null;	
		List<RDMailSendVO> mailInfos = null;
		ComRptDsgnXptInfoVO rdVO = null;
		List<ComRptDsgnXptInfoVO> rdVOs = null;
		Map<String, String> arguments = null;
		
		List<String> sendIds = null;
		String sendId = null;

		
		try {			
			
			mailInfos = new ArrayList<RDMailSendVO>();
			
			for (int i=0; i<preHldNtcSendLists.length; i++) {

				vo = preHldNtcSendLists[i];

				mailInfo = new RDMailSendVO();
				rdVOs = new ArrayList<ComRptDsgnXptInfoVO>();	

					
				/* 1. Save Hold Notice */
				hldNtc = new BkgHldNtcVO();
				
				hldNtc.setBkgNo(vo.getBkgNo());
				hldNtc.setNtcSeq(vo.getNtcSeq());
				hldNtc.setHldNtcTpCd(vo.getHldNtcTpCd());
				hldNtc.setCstmsHldNtcFomCd(vo.getCstmsHldNtcFomCd());
				hldNtc.setCstmsHldLocCd(vo.getCstmsHldLocCd());
				hldNtc.setCustCntCd(vo.getCustCntCd());
				hldNtc.setCustSeq(vo.getCustSeq());
				hldNtc.setCustNm(vo.getCustNm());
				hldNtc.setCstmsPreHldCd(vo.getCstmsPreHldCd());
				hldNtc.setPreHldDt(vo.getPreHldDt());
				hldNtc.setHldEclzOblFlg(vo.getHldEclzOblFlg());
				hldNtc.setHldDiffRmk(vo.getHldDiffRmk());
				hldNtc.setCreUsrId(account.getUsr_id());
				hldNtc.setUpdUsrId(account.getUsr_id());
				
				dbDao.modifyHldNtc(hldNtc);

			
				/* 2. Save Hold Notice Detail */
				hldNtcDtl = new BkgHldNtcDtlVO();
				
				hldNtcDtl.setBkgNo(vo.getBkgNo());
				hldNtcDtl.setNtcSeq(vo.getNtcSeq());
				hldNtcDtl.setCustCntcTpCd(vo.getCustCntcTpCd());
				hldNtcDtl.setNtcEml(vo.getNtcEml());
				hldNtcDtl.setEmlTpCd("M");
				hldNtcDtl.setHldEmlSndUsrId(account.getUsr_id());
				hldNtcDtl.setCreUsrId(account.getUsr_id());
				hldNtcDtl.setCreDt("");
				hldNtcDtl.setUpdUsrId(account.getUsr_id());
				hldNtcDtl.setUpdDt("");
				
				dbDao.modifyHldNtcDtlByEmail(hldNtcDtl);

									
				/* 3. Email Info */
				mailInfo.setSndrNm(ConstantMgr.getCompanyName());
				mailInfo.setSndrEml(account.getUsr_eml());
				mailInfo.setRcvrEml(vo.getNtcEml());
				mailInfo.setEmlTitNm(titNm);
				mailInfo.setTemplate(tmpFileNm);
				
				arguments = new HashMap<String, String>();
				mailInfo.setArguments(arguments);

				
				rdVO = new ComRptDsgnXptInfoVO();
				rdVO.setCreUsrId(account.getUsr_id());
				rdVO.setUpdUsrId(account.getUsr_id());
				rdVO.setRdTmpltNm("ESM_BKG_0761.mrd");
				rdVO.setRdParaCtnt("/rv bkg_no['"+vo.getBkgNo()+"'] ntc_seq['"+vo.getNtcSeq()+"'] " + 
						           "p_usr_id['" + account.getUsr_id()+ "'] p_ofc_cd['" + vo.getOfcCd() + "']" +
						           "p_cust_nm[''] p_remark['']");
				rdVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
				rdVO.setXptFileNm("HoldNotice_" + vo.getBlNo() + ".pdf");
				rdVOs.add(rdVO);
				
				if ("Y".equals(vo.getHldEclzOblFlg())) {
					rdVO = new ComRptDsgnXptInfoVO();
					
					rdVO.setCreUsrId(account.getUsr_id());
					rdVO.setUpdUsrId(account.getUsr_id());
					rdVO.setRdTmpltNm("ESM_BKG_0109_OBL_A4.mrd");
					rdVO.setRdParaCtnt("/rv form_bkgNo[('" + vo.getBkgNo() + "')] " +
										    " form_type[2] " +
											" form_dataOnly[N] " +
											" form_manifest[N] " +
											" form_usrId[" + account.getUsr_id() + "] " +
											" form_hiddeData[N] " +
											" form_level[(6)] " +
											" form_remark[] " +
											" form_Cntr[1] " +
											" form_mainOnly[N] " +
											" form_CorrNo[] " +
											" form_his_cntr[BKG_CONTAINER] " +
											" form_his_bkg[BKG_BOOKING] " +
											" form_his_mkd[BKG_BL_MK_DESC] " +
											" form_his_xpt[BKG_XPT_IMP_LIC] " +
											" form_his_bl[BKG_BL_DOC] " +

											//2015.01.27 안진응 추가
											" form_rqst_via_cd[] " +
											" form_his_bl_mkd[BKG_BL_ISS] " +
											" form_path[] " +
											" isEncode[Y] " +
											" form_end_no[] " + 											
											" form_esig[] form_cpy_esig[] form_knt_flg[] form_count[] " +
											
										 "/rp [] /riprnmargin");
					rdVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
					rdVO.setXptFileNm("OBL_" + vo.getBlNo()+ ".pdf");
					rdVOs.add(rdVO);
				}


				// RD Setting
				mailInfo.setComRptDsgnXptInfoVOs(rdVOs);

				
				mailInfos.add(mailInfo);			
			}

			
			// Send Mail
			sendIds = eaiDao.sendEmailGroup(mailInfos);
			

			for (int i=0; i<preHldNtcSendLists.length; i++) {
				vo = preHldNtcSendLists[i];
				sendId = sendIds.get(i);
				

				/* 4. SendId history */
				dbDao.modifyHldNtcSendIdByEmail(vo.getBkgNo(), vo.getNtcSeq(), vo.getCustCntcTpCd(), sendId);
				
				
				
				/* 5. Notice History Setting */
				bkgNtcHisVO = new BkgNtcHisVO();
				
				bkgNtcHisVO.setNtcViaCd("M"); //F:Fax,M:Email
				bkgNtcHisVO.setSndId(sendId);
				bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
				bkgNtcHisVO.setSndUsrId(account.getUsr_id());
				bkgNtcHisVO.setCreUsrId(account.getUsr_id());
				bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
				bkgNtcHisVO.setBkgNo(vo.getBkgNo());
				bkgNtcHisVO.setNtcSeq(vo.getNtcSeq());
				bkgNtcHisVO.setCustCntcTpCd(vo.getCustCntcTpCd());
				
				bkgNtcHisVOs.add(dbDao.searchHldNtcHistory(bkgNtcHisVO));
			}
			
			return bkgNtcHisVOs;
			
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
	}
	

	/**
	 * Pre Hold Confirm info send by Fax.<br>
	 * 
	 * @param ConfirmHldNtcSendListVO[] hldNtcSendLists
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO>
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> sendConfirmHldNtcByFax (ConfirmHldNtcSendListVO[] hldNtcSendLists, SignOnUserAccount account) throws EventException {
		BkgHldNtcVO hldNtc = null;
		BkgHldNtcDtlVO hldNtcDtl = null;
		ConfirmHldNtcSendListVO vo = null;
		FaxSendVO faxInfo = null;
		
		InboundNoticeEAIDAO eaiDao = new InboundNoticeEAIDAO();
		String sendId = null;
		BkgNtcHisVO bkgNtcHisVO = null;
		List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
		
		try {			
			
			for (int i=0; i<hldNtcSendLists.length; i++) {
				
				/* 1. Save Hold Notice */
				vo = hldNtcSendLists[i];
				
				hldNtc = new BkgHldNtcVO();

				hldNtc.setBkgNo(vo.getBkgNo());
				hldNtc.setNtcSeq(vo.getNtcSeq());
				hldNtc.setHldNtcTpCd(vo.getHldNtcTpCd());
				hldNtc.setCstmsHldNtcFomCd(vo.getCstmsHldNtcFomCd());
				hldNtc.setCstmsHldLocCd(vo.getCstmsHldLocCd());
				hldNtc.setCustCntCd(vo.getCustCntCd());
				hldNtc.setCustSeq(vo.getCustSeq());
				hldNtc.setCustNm(vo.getCustNm());
				hldNtc.setCstmsPreHldCd(vo.getCstmsPreHldCd());
				hldNtc.setPreHldDt(vo.getPreHldDt());
				hldNtc.setCstmsCfmHldCd(vo.getCstmsCfmHldCd());
				hldNtc.setCfmHldDt(vo.getCfmHldDt());
				hldNtc.setHldEclzOblFlg(vo.getHldEclzOblFlg());
				hldNtc.setHldDiffRmk(vo.getHldDiffRmk());
				hldNtc.setCreUsrId(account.getUsr_id());
				hldNtc.setUpdUsrId(account.getUsr_id());

				dbDao.modifyHldNtc(hldNtc);
				

				
				/* 2. Save Hold Notice Detail */
				hldNtcDtl = new BkgHldNtcDtlVO();
				
				hldNtcDtl.setBkgNo(vo.getBkgNo());
				hldNtcDtl.setNtcSeq(vo.getNtcSeq());
				hldNtcDtl.setCustCntcTpCd(vo.getCustCntcTpCd());
				hldNtcDtl.setFaxNo(vo.getFaxNo());
				hldNtcDtl.setFaxTpCd("M");
				hldNtcDtl.setHldFaxSndUsrId(account.getUsr_id());
				hldNtcDtl.setCreUsrId(account.getUsr_id());
				hldNtcDtl.setUpdUsrId(account.getUsr_id());
								
				dbDao.modifyHldNtcDtlByFax(hldNtcDtl);
				
				
				
				/* 3. Send Fax */
				faxInfo = new FaxSendVO();
				
				faxInfo.setTmplMrd("ESM_BKG_0762.mrd");
				faxInfo.setSysCd("BKG");
				faxInfo.setBatchFlg("N");
				faxInfo.setTitle("Removal Notice(BL#: "+vo.getBkgNo()+")");
				faxInfo.setTmplParam("/rv bkg_no['" + vo.getBkgNo() + "'] ntc_seq['" + vo.getNtcSeq() + "'] " + 
					                "p_usr_id['" + account.getUsr_id() + "'] p_ofc_cd['" + account.getOfc_cd() + "'] p_fom_cd[''] " + "p_cust_nm[''] p_remark['']");
				faxInfo.setRcvInfo(vo.getCustNm().replaceAll("\r\n", " ").replaceAll(";", " ") + ";"+vo.getFaxNo());
				faxInfo.setOffice(account.getOfc_cd());
				faxInfo.setCrtUserId(account.getUsr_id());

				// Send Fax
				sendId = eaiDao.sendFax(faxInfo);
				
				if ("Y".equals(vo.getHldEclzOblFlg())) {
					faxInfo = new FaxSendVO();
					
					faxInfo.setTmplMrd("ESM_BKG_0109_OBL_A4.mrd");
					faxInfo.setSysCd("BKG");
					faxInfo.setBatchFlg("N");
					faxInfo.setTitle("BL Copy(BL#: "+ vo.getBkgNo() +")");
					faxInfo.setTmplParam("/rv form_bkgNo[('" + vo.getBkgNo() + "')] " +
										    " form_type[2] " +
											" form_dataOnly[N] " +
											" form_manifest[N] " +
											" form_usrId[" + account.getUsr_id() + "] " +
											" form_hiddeData[N] " +
											" form_level[(6)] " +
											" form_remark[] " +
											" form_Cntr[1] " +
											" form_mainOnly[N] " +
											" form_CorrNo[] " +
											" form_his_cntr[BKG_CONTAINER] " +
											" form_his_bkg[BKG_BOOKING] " +
											" form_his_mkd[BKG_BL_MK_DESC] " +
											" form_his_xpt[BKG_XPT_IMP_LIC] " +
											" form_his_bl[BKG_BL_DOC] " +
											" form_esig[] form_cpy_esig[] form_knt_flg[] form_count[] " +
											
											//2015.01.27 안진응 추가
											" form_rqst_via_cd[] " +
											" form_his_bl_mkd[BKG_BL_ISS] " +
											" form_path[] " +
											" isEncode[Y] " +
											" form_end_no[] " + 											
											" form_esig[] form_cpy_esig[] form_knt_flg[] form_count[] " +
											
										 "/rp [] /riprnmargin");
					faxInfo.setRcvInfo(vo.getCustNm().replaceAll("\r\n", " ").replaceAll(";", " ") + ";"+vo.getFaxNo());
					faxInfo.setOffice(account.getOfc_cd());
					faxInfo.setCrtUserId(account.getUsr_id());

					// Send Fax
					eaiDao.sendFax(faxInfo);
				}							
								
				
				/* 4. SendId history */
				dbDao.modifyHldNtcSendIdByFax(vo.getBkgNo(), vo.getNtcSeq(), vo.getCustCntcTpCd(), sendId);
				
				
				
				/* 5. Notice History Setting */
				bkgNtcHisVO = new BkgNtcHisVO();
				
				bkgNtcHisVO.setNtcViaCd("F"); //F:Fax,M:Email
				bkgNtcHisVO.setSndId(sendId);
				bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
				bkgNtcHisVO.setSndUsrId(account.getUsr_id());
				bkgNtcHisVO.setCreUsrId(account.getUsr_id());
				bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
				bkgNtcHisVO.setBkgNo(vo.getBkgNo());
				bkgNtcHisVO.setNtcSeq(vo.getNtcSeq());
				bkgNtcHisVO.setCustCntcTpCd(vo.getCustCntcTpCd());
				
				bkgNtcHisVOs.add(dbDao.searchHldNtcHistory(bkgNtcHisVO));

			}
			
			return bkgNtcHisVOs;
			
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
	}

	
	
	/**
	 * Pre Hold Confirm info send by E-mail.<br>
	 * 
	 * @param ConfirmHldNtcSendListVO[] hldNtcSendLists
	 * @param SignOnUserAccount account
	 * @return
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> sendConfirmHldNtcByEmail (ConfirmHldNtcSendListVO[] hldNtcSendLists, SignOnUserAccount account) throws EventException {

		ConfirmHldNtcSendListVO vo = null;

		BkgHldNtcVO hldNtc = null;
		BkgHldNtcDtlVO hldNtcDtl = null;
		BkgNtcHisVO bkgNtcHisVO = null;
		List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
		
		String tmpFileNm = "ESM_BKG_0510_HLD_CF.html";
		String titNm = "[" + ConstantMgr.getCompanyName() + "] U.S. Government Hold Removal Notice";
		InboundNoticeEAIDAO eaiDao = new InboundNoticeEAIDAO();
		RDMailSendVO mailInfo = null;	
		List<RDMailSendVO> mailInfos = null;
		ComRptDsgnXptInfoVO rdVO = null;
		List<ComRptDsgnXptInfoVO> rdVOs = null;
		Map<String, String> arguments = null;
		
		List<String> sendIds = null;
		String sendId = null;

		try {			
						
			mailInfos = new ArrayList<RDMailSendVO>();
			
			for (int i=0; i<hldNtcSendLists.length; i++) {

				vo = hldNtcSendLists[i];

				mailInfo = new RDMailSendVO();
				rdVOs = new ArrayList<ComRptDsgnXptInfoVO>();	

				
				/* 1. Save Hold Notice */
				hldNtc = new BkgHldNtcVO();
				
				hldNtc.setBkgNo(vo.getBkgNo());
				hldNtc.setNtcSeq(vo.getNtcSeq());
				hldNtc.setHldNtcTpCd(vo.getHldNtcTpCd());
				hldNtc.setCstmsHldNtcFomCd(vo.getCstmsHldNtcFomCd());
				hldNtc.setCstmsHldLocCd(vo.getCstmsHldLocCd());
				hldNtc.setCustCntCd(vo.getCustCntCd());
				hldNtc.setCustSeq(vo.getCustSeq());
				hldNtc.setCustNm(vo.getCustNm());
				hldNtc.setCstmsPreHldCd(vo.getCstmsPreHldCd());
				hldNtc.setPreHldDt(vo.getPreHldDt());
				hldNtc.setCstmsCfmHldCd(vo.getCstmsCfmHldCd());
				hldNtc.setCfmHldDt(vo.getCfmHldDt());
				hldNtc.setHldEclzOblFlg(vo.getHldEclzOblFlg());
				hldNtc.setHldDiffRmk(vo.getHldDiffRmk());
				hldNtc.setCreUsrId(account.getUsr_id());
				hldNtc.setUpdUsrId(account.getUsr_id());
				
				dbDao.modifyHldNtc(hldNtc);
					
					
					
				/* 2. Save Hold Notice Detail */
				hldNtcDtl = new BkgHldNtcDtlVO();
				
				hldNtcDtl.setBkgNo(vo.getBkgNo());
				hldNtcDtl.setNtcSeq(vo.getNtcSeq());
				hldNtcDtl.setCustCntcTpCd(vo.getCustCntcTpCd());
				hldNtcDtl.setNtcEml(vo.getNtcEml());
				hldNtcDtl.setEmlTpCd("M");
				hldNtcDtl.setHldEmlSndUsrId(account.getUsr_id());
				hldNtcDtl.setCreUsrId(account.getUsr_id());
				hldNtcDtl.setUpdUsrId(account.getUsr_id());
				
				dbDao.modifyHldNtcDtlByEmail(hldNtcDtl);
				
				/* 3. Email Info */
				mailInfo.setSndrNm(ConstantMgr.getCompanyName());
				mailInfo.setSndrEml(account.getUsr_eml());
				mailInfo.setRcvrEml(vo.getNtcEml());
				mailInfo.setEmlTitNm(titNm);
				mailInfo.setTemplate(tmpFileNm);
				
				arguments = new HashMap<String, String>();
				mailInfo.setArguments(arguments);
					
					
				rdVO = new ComRptDsgnXptInfoVO();
				rdVO.setCreUsrId(account.getUsr_id());
				rdVO.setUpdUsrId(account.getUsr_id());
				rdVO.setRdTmpltNm("ESM_BKG_0762.mrd");
				rdVO.setRdParaCtnt("/rv bkg_no['" + vo.getBkgNo() + "'] ntc_seq['" + vo.getNtcSeq() + "'] " + 
                        "p_usr_id['" + account.getUsr_id() + "'] p_ofc_cd['" + account.getOfc_cd() + "'] p_fom_cd[''] " + "p_cust_nm[''] p_remark['']");
				rdVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
				rdVO.setXptFileNm("Release Notice_" + vo.getBlNo() + ".pdf");
				rdVOs.add(rdVO);
					
				log.info("=== Booking Hold Event(OB Staff) Information ==============================\n" +
						 "	HOLD OBL FLAG    : " + vo.getHldEclzOblFlg() + "\n" +
						 "==========================================================================\n");
				
				if ("Y".equals(vo.getHldEclzOblFlg())) {
					rdVO = new ComRptDsgnXptInfoVO();
					
					rdVO.setCreUsrId(account.getUsr_id());
					rdVO.setUpdUsrId(account.getUsr_id());
					rdVO.setRdTmpltNm("ESM_BKG_0109_OBL_A4.mrd");
					rdVO.setRdParaCtnt("/rv form_bkgNo[('" + vo.getBkgNo() + "')] " +
						    " form_type[2] " +
							" form_dataOnly[N] " +
							" form_manifest[N] " +
							" form_usrId[" + account.getUsr_id() + "] " +
							" form_hiddeData[N] " +
							" form_level[(6)] " +
							" form_remark[] " +
							" form_Cntr[1] " +
							" form_mainOnly[N] " +
							" form_CorrNo[] " +
							" form_his_cntr[BKG_CONTAINER] " +
							" form_his_bkg[BKG_BOOKING] " +
							" form_his_mkd[BKG_BL_MK_DESC] " +
							" form_his_xpt[BKG_XPT_IMP_LIC] " +
							" form_his_bl[BKG_BL_DOC] " +
							
							//2015.01.27 안진응 추가
							" form_rqst_via_cd[] " +
							" form_his_bl_mkd[BKG_BL_ISS] " +
							" form_path[] " +
							" isEncode[Y] " +
							" form_end_no[] " + 											
							" form_esig[] form_cpy_esig[] form_knt_flg[] form_count[] " +
							
						 "/rp [] /riprnmargin");
					rdVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
					rdVO.setXptFileNm("OBL_" + vo.getBlNo()+ ".pdf");
					rdVOs.add(rdVO);
				}
				
				
				// RD Setting
				mailInfo.setComRptDsgnXptInfoVOs(rdVOs);

				
				mailInfos.add(mailInfo);			
			}
			
			
			// Send Mail
			sendIds = eaiDao.sendEmailGroup(mailInfos);

			
			for (int i=0; i<hldNtcSendLists.length; i++) {
				vo = hldNtcSendLists[i];
				sendId = sendIds.get(i);

				
				/* 4. SendId history */
				dbDao.modifyHldNtcSendIdByEmail(vo.getBkgNo(), vo.getNtcSeq(), vo.getCustCntcTpCd(), sendId);
					
					
					
				/* 5. Notice History Setting */
				bkgNtcHisVO = new BkgNtcHisVO();
				
				bkgNtcHisVO.setNtcViaCd("M"); //F:Fax,M:Email
				bkgNtcHisVO.setSndId(sendId);
				bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
				bkgNtcHisVO.setSndUsrId(account.getUsr_id());
				bkgNtcHisVO.setCreUsrId(account.getUsr_id());
				bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
				bkgNtcHisVO.setBkgNo(vo.getBkgNo());
				bkgNtcHisVO.setNtcSeq(vo.getNtcSeq());
				bkgNtcHisVO.setCustCntcTpCd(vo.getCustCntcTpCd());
				
				bkgNtcHisVOs.add(dbDao.searchHldNtcHistory(bkgNtcHisVO));
				
			}
			
			return bkgNtcHisVOs;
			
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
	}

	
	/**
	 * differ transmission method and description in Confirm Hold Notice, Form Setup info retrieve.<br>
	 * 
	 * @param String ofcCd
	 * @param String podCd
	 * @return HoldNoticeFormVO
	 * @exception EventException
	 */
	public HoldNoticeFormVO searchHldNtcConfirmForm (String ofcCd, String podCd) throws EventException {
		try {
			HoldNoticeFormVO hldNtcForm = new HoldNoticeFormVO();
			
			String ntcTpCd = "CF";
			
			/* Hold Notice Word */
			hldNtcForm.setBkgHldWd(dbDao.searchHldNtcForm(ofcCd, podCd, ntcTpCd));
			
			/* Hold Notice Word Detail */
			hldNtcForm.setBkgHldWdDtls(dbDao.searchHldNtcFormDtl(ofcCd, podCd, ntcTpCd));
			
			return hldNtcForm;
			
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
	}
	

	/**
	 * Hold Notice (  Confirm-Hold) Hold Code Form info manage.<br>
	 * 
	 * @param HoldNoticeFormVO hldNtcForm
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void setupHldNtcConfirmForm (BkgHldWdVO hldWd, BkgHldWdDtlVO[] hldWdDtls, SignOnUserAccount account) throws EventException {
		try {
			List<BkgHldWdVO>    insertVoList    = new ArrayList<BkgHldWdVO>();
			List<BkgHldWdDtlVO> insertDtlVoList = new ArrayList<BkgHldWdDtlVO>();				
			
			/* Hold Notice Word*/
			hldWd.setCreUsrId(account.getUsr_id());
			hldWd.setUpdUsrId(account.getUsr_id());
			insertVoList.add(hldWd);
			
			/* Hold Notice Detail */
			for (int i=0; i<hldWdDtls.length; i++) {
				BkgHldWdDtlVO bkgHldWdDtl = hldWdDtls[i];

				bkgHldWdDtl.setCreUsrId(account.getUsr_id());
				bkgHldWdDtl.setUpdUsrId(account.getUsr_id());
				insertDtlVoList.add(bkgHldWdDtl);
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.mergeHldNtcForm(insertVoList);
			}
						
			if ( insertDtlVoList.size() > 0 ) {
				dbDao.mergeHldNtcFormDtl(insertDtlVoList);
			}

        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
	}
	
	/**
	 * Hold Notice auto creation<br>
	 * 
	 * @param String bkgNo
	 * @param String ntcSeq
	 * @param CstmsHldVO cstmsHld
	 * @param CustInfoVO custInfo
	 * @param String eclzOblFlg
	 * @return BkgHldNtcVO
	 * @exception EventException
	 */
	private BkgHldNtcVO createHldNtc(String bkgNo, String ntcSeq, CstmsHldVO cstmsHld, CustInfoVO custInfo, String eclzOblFlg) throws EventException 
	{
		String usr_id = "BAT_BKG_020";
		
		BkgHldNtcVO hldNtc = new BkgHldNtcVO();

		hldNtc.setBkgNo(bkgNo);
		hldNtc.setNtcSeq(ntcSeq);
		hldNtc.setHldNtcTpCd(cstmsHld.getHldType());
		hldNtc.setCstmsHldLocCd(cstmsHld.getCstmsLocCd());

		if ("PH".equals(cstmsHld.getHldType())) {
			hldNtc.setCstmsHldNtcFomCd("**");
			hldNtc.setCstmsPreHldCd(cstmsHld.getHldCd());
			hldNtc.setPreHldDt(cstmsHld.getHldDt());
			hldNtc.setCstmsCfmHldCd("");
			hldNtc.setCfmHldDt("");
		} else {
			hldNtc.setCstmsHldNtcFomCd("E1");
			hldNtc.setCstmsPreHldCd(cstmsHld.getHldCd());
			hldNtc.setPreHldDt(cstmsHld.getHldDt());
			hldNtc.setCstmsCfmHldCd(cstmsHld.getRlseHldCd());
			hldNtc.setCfmHldDt(cstmsHld.getRlseHldDt());
		}				

		hldNtc.setCustCntCd(custInfo.getCustCntCd());
		hldNtc.setCustSeq(custInfo.getCustSeq());
		hldNtc.setCustNm(custInfo.getCustNm());
		hldNtc.setHldEclzOblFlg(eclzOblFlg);
		
		hldNtc.setHldDiffRmk("");
		hldNtc.setCreUsrId(usr_id);
		hldNtc.setCreDt("");
		hldNtc.setUpdUsrId(usr_id);
		hldNtc.setUpdDt("");		
		hldNtc.setBkgCustTpCd(custInfo.getBkgCustTpCd());

		
		try {
			/*
			 *  Hold Notice creation
			 */
			dbDao.addHldNtc(hldNtc);

			return hldNtc;

        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
	}
	
	
	/**
	 * Hold Notice Detail auto creation<br>
	 * 
	 * @param String bkgNo
	 * @param String ntcSeq
	 * @param List<BkgNtcHisVO> arrNtcHiss
	 * @return List<BkgHldNtcDtlVO>
	 * @exception EventException
	 */
	private List<BkgHldNtcDtlVO> createHldNtcDtl(String bkgNo, String ntcSeq, List<BkgNtcHisVO> bkgNtcHisVos) throws EventException
	{
		String usr_id = "BAT_BKG_020";
		
		BkgNtcHisVO ntcHis = null;
		BkgHldNtcDtlVO hldNtcDtl = null;
		
		List<BkgHldNtcDtlVO> hldNtcDtls = new ArrayList<BkgHldNtcDtlVO>();

		for (int i=0; i<bkgNtcHisVos.size(); i++) {
			ntcHis = bkgNtcHisVos.get(i);
			
			hldNtcDtl = new BkgHldNtcDtlVO();
			
			hldNtcDtl.setBkgNo(bkgNo);
			hldNtcDtl.setNtcSeq(ntcSeq);
			hldNtcDtl.setCustCntcTpCd(ntcHis.getCustCntcTpCd());
			if ("F".equals(ntcHis.getNtcViaCd())) { // Fax
				hldNtcDtl.setFaxNo(ntcHis.getNtcFaxNo());
				hldNtcDtl.setFaxTpCd("A");
				hldNtcDtl.setNtcEml("");
				hldNtcDtl.setEmlTpCd("");
			} else if ("M".equals(ntcHis.getNtcViaCd())) {  // Email
				hldNtcDtl.setFaxNo("");
				hldNtcDtl.setFaxTpCd("");
				hldNtcDtl.setNtcEml(ntcHis.getNtcEml());
				hldNtcDtl.setEmlTpCd("A");
			} 
			hldNtcDtl.setCreUsrId(usr_id);
			hldNtcDtl.setCreDt("");
			hldNtcDtl.setUpdUsrId(usr_id);
			hldNtcDtl.setUpdDt("");
			
			hldNtcDtls.add(hldNtcDtl);
		}
								
		/*
		 *  Fax and Email info save
		 */
		try {
			dbDao.addHldNtcDtl(hldNtcDtls);

			return hldNtcDtls;

        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
	}
	

	/**
	 * Waring event handling.
	 * 
	 * @param CstmsHldVO cstmsHld
	 */
	public void sendAmsNtcToObStaff (CstmsHldVO cstmsHld) {

		BkgCstmsAdvDspoVO bkgCstmsAdvDspoVO = null;
		List<HldNtcObStaffSetupInfoVO> obUsrs = null;
		HldNtcObStaffSetupInfoVO obUsr = null;
		
		TmpMailSendVO tmpMailInfo = null;
		Map<String, String> arguments = null;
		InboundNoticeEAIDAO eaiDao = new InboundNoticeEAIDAO();

		String sndrNm = "Auto Hold Notification"; // 메일 발신자명
		String sndrEml = "noreply@nykline.com"; // 메일 발신자 이메일
			

		String strHldInfo = "";
		
		try {

			if (cstmsHld == null) {
				throw new Exception("Booking Hold Event(OB Staff) Information is NULL!!");
			}
				

			String blNo    = cstmsHld.getBlNo(); 
			String locCd   = cstmsHld.getCstmsLocCd();
			String hldCd   = cstmsHld.getHldCd();
			String hldDt   = cstmsHld.getHldDt();
			String cntCd  = cstmsHld.getCntCd();
			String hldNm   = "";
			String hldDesc = "";
			String vvd     = "";
			String podCd   = "";
			String sendId  = "";
			String msgTpId = "MI";
			if(CountryCode.CA.equals(cntCd)){
				msgTpId = "A6A";
			} // Canada 일 경우 A6A를 셋팅.

			strHldInfo = "[B/L NO:" + blNo + "] [LOC CD:" + locCd + "] [HOLD CD:" + hldCd + "] [HOLD DT:" + hldDt + "]";			
			
			
			log.info("=== Booking Hold Event(OB Staff) Information ==============================\n" +
					 "	B/L NO    : " + blNo + "\n" +
					 "	LOC CD    : " + locCd + "\n" +
					 "	HOLD CD   : " + hldCd + "\n" +
					 "	HOLD DT   : " + hldDt + "\n" +
					 "==========================================================================\n");

			
			if ("".equals(blNo) || "".equals(locCd) || "null".equals(locCd) || 
					"".equals(hldCd) || "null".equals(hldCd) || "".equals(hldDt) || "null".equals(hldDt)) {
				throw new Exception("Booking Hold Event(OB Staff) Information is Empty!!");
			}			


			// 1. Hold 코드 조회 - 등록된 경우 Hold Description 을 가져온다.
			bkgCstmsAdvDspoVO = dbDao.searchWnFlg(hldCd);
			if (bkgCstmsAdvDspoVO == null) {
				throw new Exception("The Hold Code[" + hldCd + "] is not registered in DB");
			}
			
			if ("Y".equals(bkgCstmsAdvDspoVO.getObNtcFlg()) == false) {
				throw new Exception("The Hold Code[" + hldCd + "] is not O/B Notice");
			}

			hldNm     = bkgCstmsAdvDspoVO.getCstmsDspoNm();
			hldDesc   = bkgCstmsAdvDspoVO.getDspoDesc();	
			
			if ("".equals(hldDesc)) hldDesc = hldNm;

			
			
			// 2. VVD 가져오기
			vvd = dbDao.searchHldBkgVVD(blNo, cntCd);			

			
			// 3. Booking 정보 가져오기
			BkgBookingVO bkgBooking = dbDao.searchBkgBookingByBlNo(blNo);
			if (bkgBooking == null) {
				throw new Exception("The BL No[" + blNo + "] is not registered in DB");
			}
			
			podCd = bkgBooking.getPodCd();
			

			String content    = "Customs Hold B/L No[" + blNo + "] / POD [" + podCd + "] / Type [Value(" + hldCd + ")]";
			String obEmlTitNm = "Warning Notification [" + vvd + "] [" + blNo + "] " + "[" + hldCd + ": " + hldNm + "] " + hldDt + " (" + cntCd + " LOCAL TIME)";

			
			
			/*
			 * 4. BL 확정자 메일 및 메시지 전송하기
			 */
			obUsrs = dbDao.searchHldNtcObStaffSetupInfo (blNo, cntCd);
			
			log.info("==========================================================================\n" +
					 "	Booking Hold Event OB Staff(Count) : " + obUsrs.size() + "\n" +
					 "==========================================================================\n");

			for (int n=0; n<obUsrs.size(); n++) {
				obUsr = obUsrs.get(n);

				/* 메시지 전송 */
				sendId = eaiDao.sendAlert("Auto Alert", "Auto Alert", obUsr.getUsrNm(), obUsr.getSndUsrId(), content);	

				log.info("== Booking Hold Event(OB Staff) Alert ====================================\n" +
						 "	USR_NM  : " + obUsr.getUsrNm() + "\n" +
						 "	USR_ID  : " + obUsr.getSndUsrId() + "\n" +
						 "	CONTENT : " + content + "\n" +
						 "	SEND ID : " + sendId + "\n" +
						 "==========================================================================\n");

				
				/* 그룹웨어 메일 전송 */
				if ((obUsr.getUsrEml().trim()).length() > 0) 
				{
					tmpMailInfo = new TmpMailSendVO();
					
					tmpMailInfo.setSndrNm(sndrNm);
					tmpMailInfo.setSndrEml(sndrEml);
					tmpMailInfo.setRcvrEml(obUsr.getUsrEml());					
					tmpMailInfo.setRcvrNm("");
					tmpMailInfo.setEmlTitNm(obEmlTitNm);
					tmpMailInfo.setTemplate("ESM_BKG_0510_GW_OBT.html");
					
					arguments = new HashMap<String, String>();
					arguments.put("cntCd", cntCd);
					arguments.put("vvd", vvd);
					arguments.put("blNo", blNo);
					arguments.put("hldCd", hldCd);
					arguments.put("hldDesc", hldDesc);
					arguments.put("hldDt", hldDt);
					arguments.put("locCd", locCd);
					arguments.put("hldDt", hldDt);
					arguments.put("msgTpId", msgTpId);
					
					tmpMailInfo.setArguments(arguments);


					sendId = eaiDao.sendGwEmail(tmpMailInfo);

					log.info("== Booking Hold Event{OB Staff) G/W Mail =================================\n" +
							 "	Rcvr Eml : " + obUsr.getUsrEml() + "\n" +
							 "	SEND ID  : " + sendId + "\n" +
							 "==========================================================================\n");				
				}
			}
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);			
        } catch(Exception ex) {			
			log.error("err " + ex.toString(), ex);			
        }
	}

	
	/**
	 * Hold Notice event handling.
	 * 
	 * @param CstmsHldVO cstmsHld
	 * @return List<BkgNtcHisVO>
	 */
	public List<BkgNtcHisVO> createCstmsHld (CstmsHldVO cstmsHld) {
		BkgHldNtcVO hldNtc = null;
		List<BkgHldNtcDtlVO> hldNtcDtls = null;
		BkgHldNtcDtlVO hldNtcDtl = null;
		List<BkgNtcHisVO> arrNtcHiss = null;
		BkgHldWdVO hldWd = null;
		List<CustInfoVO> custInfos = null;
		CustInfoVO custInfo = null;
		List<HldNtcStaffInfoVO> ntcUsrs = null;
		HldNtcStaffInfoVO ntcUsr = null;
		
		String tmpFileNm = "ESM_BKG_0510_HLD_PH.html"; // 화주 메일 Templatate
		String titNm = "[NYK Line America] U.S. Government Hold Notice"; // 화주 메일 Title
		String sndrNm = "NYK Line America"; // 메일 발신자명
		String sndrEml = "noreply@nykline.com"; // 메일 발신자 이메일
		String tmplMrd = "ESM_BKG_0761.mrd"; // Hold Notice RD 파일명
		String oblTmplMrd = "ESM_BKG_0109_OBL_A4.mrd"; // OBL RD 파일명
		String ofc_cd = "";
		String usr_id = "BAT_BKG_020";
		RDMailSendVO mailInfo = null;
		FaxSendVO faxInfo = null;			
		TmpMailSendVO tmpMailInfo = null;
		String sendId = null;
		Map<String, String> arguments = null;
		ComRptDsgnXptInfoVO rdVO = null;
		List<ComRptDsgnXptInfoVO> rdVOs = null;
		InboundNoticeEAIDAO eaiDao = new InboundNoticeEAIDAO();
		
		List<BkgNtcHisVO> hldNtcHiss = new ArrayList<BkgNtcHisVO>();
		BkgNtcHisVO ntcHis = null;
		
		BkgCstmsAdvDspoVO bkgCstmsAdvDspoVO = null;
		String strHldInfo = "";

		try {
			
			if (cstmsHld == null) {
				throw new Exception("Booking Hold Event Information is NULL!!");
			}
			
			String blNo      = cstmsHld.getBlNo(); 
			String locCd     = cstmsHld.getCstmsLocCd();
			String hldType   = cstmsHld.getHldType();
			String hldCd     = cstmsHld.getHldCd();
			String hldDt     = cstmsHld.getHldDt();
			String cntCd    = cstmsHld.getCntCd();
			String rlseHldCd = cstmsHld.getRlseHldCd();
			String rlseHldDt = cstmsHld.getRlseHldDt();
			String hldNtcFlg = "N";
			String bkgNo     = "";			
			String ntcSeq = "";
			String podCd  = "";
			String ofcCd  = "";
			String vvd    = "";
			String hldNm  = "";
			String hldDesc = "";
			String custNm = "";
			StringBuffer customer = new StringBuffer("");

			strHldInfo = "[HOLD TYPE:" + hldType + "] [B/L NO:" + blNo + "] [LOC CD:" + locCd + "] " +
	         "[HOLD CD:" + hldCd + "] [HOLD DT:" + hldDt + "] [RLSE CD:" + rlseHldCd + "] " + "[RLSE DT:" + rlseHldDt + "] ";
			
			
			
			
			log.info("==Booking Hold Event Information==========================================\n" +
			         "	HOLD TYPE : " + hldType + "\n" +
			         "	B/L NO    : " + blNo + "\n" +
			         "	LOC CD    : " + locCd + "\n" +
			         "	HOLD CD   : " + hldCd + "\n" +
			         "	HOLD DT   : " + hldDt + "\n" +
			         "	RLSE CD   : " + rlseHldCd + "\n" +
			         "	RLSE DT   : " + rlseHldDt + "\n" +
			         "==========================================================================\n");
			
			if ("".equals(hldType) || "".equals(blNo) || 
					"".equals(locCd) || "null".equals(locCd) || 
					"".equals(hldCd) || "null".equals(hldCd) ||
					"".equals(hldDt) || "null".equals(hldDt) ||
					("CF".equals(hldType) && ("".equals(rlseHldCd) || "null".equals(rlseHldCd))) || 
					("CF".equals(hldType) && ("".equals(rlseHldDt) || "null".equals(rlseHldDt))) ) {
				throw new Exception("Booking Hold Event Information is Empty!!");
			}


			// 1. Hold 코드 유효성 체크 - 미등록 코드인 경우 Error
			bkgCstmsAdvDspoVO = dbDao.searchHldNtcFlg(hldType, hldCd, rlseHldCd);
			if (bkgCstmsAdvDspoVO == null) {
				throw new Exception("The Hold Code[" + hldCd + "/" + rlseHldCd + "] is not registered in DB");
			}

			
			hldNtcFlg = bkgCstmsAdvDspoVO.getAutoNtcFlg();
			hldNm     = bkgCstmsAdvDspoVO.getCstmsDspoNm();
			hldDesc   = bkgCstmsAdvDspoVO.getDspoDesc();
		
			if ("".equals(hldDesc)) hldDesc = hldNm;


			// 2. Booking & Customer 정보 가져오기(Bkg No, POD) - A/N Customer 없는 경우 Dummy 정보 가져옴
			custInfos = dbDao.searchBkgCustInfo(blNo);
			if (custInfos == null || custInfos.size() == 0) {
				throw new Exception("Booking Hold Event : Not Found A/N Customer Information(B/L No.:" + blNo + ")");
			}
			
			log.info("==========================================================================\n" +
					 "	Booking Hold Event Customer(Count) : " + custInfos.size() + "\n" +
					 "==========================================================================\n");
			
			// 3. Hold 정보 생성 및 Hold 이벤트인 경우 Fax/Email 전송하기
			for(int i=0; i<custInfos.size(); i++) {
				
				custInfo = custInfos.get(i);

				bkgNo    = custInfo.getBkgNo();
				podCd    = custInfo.getPodCd();
				custNm   = custInfo.getCustNm();
				customer.append("[").append(custNm).append("]");

				log.info("==========================================================================\n" +
						 "	Booking Hold Event Customer : " + custInfo.getCustCntCd() + custInfo.getCustSeq() + "\n" +
						 "==========================================================================\n");

				// 시퀀스 생성
				ntcSeq = dbDao.searchHldNtcNextSeq(bkgNo);

				// Customs Location 코드가  부정확하여 POD_CD로 강제 변경해 줌
                // pod='US' 이면, pod ==> cstms_loc 로 대체하여 Hold notice 전송함.
                if( podCd.startsWith("US") ) {
                locCd = podCd;
                //cstmsHld.setCstmsLocCd(podCd);                     
                }
				
				// 셋업정보 가져오기(auto_ntc_flg, eclz_obl_flg) -- 셋업정보가 없는 경우 디폴트 (N)정보 가져옴
				hldWd = dbDao.searchHldNtcSetupInfo(locCd, podCd, hldType);

				ofc_cd    = hldWd.getOfcCd();
				
				// Hold Notice 생성하기
				hldNtc = this.createHldNtc(bkgNo, ntcSeq, cstmsHld, custInfo, hldWd.getEclzOblFlg());
				
				
				// Confirm 인 경우, Hold Notice Container 정보 저장
				if ("CF".equals(hldType)) {
					dbDao.copyHldNtcCntrList (hldNtc);
				}
				
				
				// Fax, Email 정보 가져오기 - Arrival Notice 전송 최종 이력 조회
				arrNtcHiss = dbDao.searchArrNtcSndHist(bkgNo, ntcSeq, custInfo.getBkgCustTpCd());

				
				// 전송 정보가 없는 경우 bkg_hld_ntc_dtl 저장 및 Fax/Email 전송 안함
				if (arrNtcHiss == null || arrNtcHiss.size() == 0) {
					log.info("==========================================================================\n" +
							 "	Booking Hold Event A/N Send History : Not Found\n" +
							 "==========================================================================\n");
					continue;
				}
				

				log.info("==========================================================================\n" +
						 "	Booking Hold Event A/N Send History : " + arrNtcHiss.size() + "\n" +
						 "==========================================================================\n");
				
				
				// Fax 및 Email 정보 저장하기
				hldNtcDtls = this.createHldNtcDtl(bkgNo, ntcSeq, arrNtcHiss);
				
					
				// Pre-Hold 인 경우 화주에게 메일 및 Fax 전송하기
				if ("PH".equals(hldType)) {
					
					// Auto 셋팅된 경우에만 전송 
					if ("Y".equals(hldNtcFlg) && "Y".equals(hldWd.getAutoNtcFlg())) {
				
						ofcCd = hldWd.getOfcCd();

						for (int k=0; k<hldNtcDtls.size(); k++) {
							hldNtcDtl = hldNtcDtls.get(k);
							
							// 8-1. 이메일 전송
							if ("A".equals(hldNtcDtl.getEmlTpCd()) && (hldNtcDtl.getNtcEml().trim()).length() > 0) {
								
								mailInfo = new RDMailSendVO();
								
								mailInfo.setSndrNm(sndrNm);
								mailInfo.setSndrEml(sndrEml);
								mailInfo.setRcvrEml(hldNtcDtl.getNtcEml());								
								mailInfo.setRcvrNm(hldNtc.getCustNm());
								mailInfo.setEmlTitNm(titNm);
								mailInfo.setTemplate(tmpFileNm);
								
								arguments = new HashMap<String, String>();
								//arguments.put("rcvrNm", hldNtc.getCustNm());
								mailInfo.setArguments(arguments);
								
								// RD Setting
								rdVOs = new ArrayList<ComRptDsgnXptInfoVO>();	

								rdVO = new ComRptDsgnXptInfoVO();
								rdVO.setCreUsrId(usr_id);
								rdVO.setUpdUsrId(usr_id);
								rdVO.setRdTmpltNm("ESM_BKG_0761.mrd");
								rdVO.setRdParaCtnt("/rv bkg_no['"+bkgNo+"'] ntc_seq['"+ntcSeq+"'] " + 
							             "p_usr_id[''] p_ofc_cd['" + ofcCd + "']" +
							             "p_cust_nm[''] p_remark['']");
								rdVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
								rdVO.setXptFileNm("HoldNotice_" + blNo + ".pdf");
								rdVOs.add(rdVO);
								
								if ("Y".equals(hldNtc.getHldEclzOblFlg())) {
									rdVO = new ComRptDsgnXptInfoVO();
									
									rdVO.setCreUsrId(usr_id);
									rdVO.setUpdUsrId(usr_id);
									rdVO.setRdTmpltNm("ESM_BKG_0109_OBL_A4.mrd");
									rdVO.setRdParaCtnt("/rv form_bkgNo[('" + bkgNo + "')] " +
														    " form_type[2] " +
															" form_dataOnly[N] " +
															" form_manifest[N] " +
															" form_usrId[" + usr_id + "] " +
															" form_hiddeData[N] " +
															" form_level[(6)] " +
															" form_remark[] " +
															" form_Cntr[1] " +
															" form_mainOnly[N] " +
															" form_CorrNo[] " +
															" form_his_cntr[BKG_CONTAINER] " +
															" form_his_bkg[BKG_BOOKING] " +
															" form_his_mkd[BKG_BL_MK_DESC] " +
															" form_his_xpt[BKG_XPT_IMP_LIC] " +
															" form_his_bl[BKG_BL_DOC] " +
															
															//2015.01.27 안진응 추가
															" form_rqst_via_cd[] " +
															" form_his_bl_mkd[BKG_BL_ISS] " +
															" form_path[] " +
															" isEncode[Y] " +
															" form_end_no[] " + 											
															" form_esig[] form_cpy_esig[] form_knt_flg[] form_count[] " +
															
														 "/rp [] /riprnmargin");
									rdVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
									rdVO.setXptFileNm("OBL_" + blNo+ ".pdf");
									rdVOs.add(rdVO);
								}

								mailInfo.setComRptDsgnXptInfoVOs(rdVOs);

								
								/* Send Mail */
								sendId = eaiDao.sendEmail(mailInfo);

								log.info("==========================================================================\n" +
										 "	Booking Hold Event Send Email : " + hldNtcDtl.getNtcEml() + "(" + sendId + ")\n" +
										 "==========================================================================\n");

								
								/* SendId 기록 */
								dbDao.modifyHldNtcSendIdByEmail(bkgNo, ntcSeq, hldNtcDtl.getCustCntcTpCd(), sendId);

							
								/* Notice History Setting */
								ntcHis = new BkgNtcHisVO();
								
								ntcHis.setNtcViaCd("M"); //F:Fax,M:Email
								ntcHis.setSndId(sendId);
								ntcHis.setSndOfcCd(ofc_cd);
								ntcHis.setSndUsrId(usr_id);
								ntcHis.setCreUsrId(usr_id);
								ntcHis.setUpdUsrId(usr_id);
								ntcHis.setBkgNo(bkgNo);
								ntcHis.setNtcSeq(ntcSeq);
								ntcHis.setCustCntcTpCd(hldNtcDtl.getCustCntcTpCd());
								
								hldNtcHiss.add(dbDao.searchHldNtcHistory(ntcHis));
							}
							
 							
							/*
							 * 8-2. 팩스 전송
							 */
							if ("A".equals(hldNtcDtl.getFaxTpCd()) && (hldNtcDtl.getFaxNo().trim()).length() > 0) {
								faxInfo = new FaxSendVO();
								
								faxInfo.setTmplMrd(tmplMrd);
								faxInfo.setSysCd("BKG");
								faxInfo.setBatchFlg("Y");
								faxInfo.setTitle("Auto Hold Notice(BL#: "+bkgNo+")");
								faxInfo.setTmplParam("/rv bkg_no['"+bkgNo+"'] ntc_seq['"+ntcSeq+"'] " + 
										             "p_usr_id[''] p_ofc_cd['" + ofcCd + "']" +
										             "p_cust_nm[''] p_remark['']");
								faxInfo.setRcvInfo(hldNtc.getCustNm().replaceAll("\r\n", " ").replaceAll(";", " ") + ";"+hldNtcDtl.getFaxNo().trim());
								faxInfo.setOffice(ofc_cd);
								faxInfo.setCrtUserId(usr_id);

								/* Send Fax */
								sendId = eaiDao.sendFax(faxInfo);
								
								if ("Y".equals(hldNtc.getHldEclzOblFlg())) {
									faxInfo = new FaxSendVO();
									
									faxInfo.setTmplMrd(oblTmplMrd);
									faxInfo.setSysCd("BKG");
									faxInfo.setBatchFlg("Y");
									faxInfo.setTitle("BL Copy(BL#: "+ bkgNo +")");
									faxInfo.setTmplParam("/rv form_bkgNo[('" + bkgNo + "')] " +
														    " form_type[2] " +
															" form_dataOnly[N] " +
															" form_manifest[N] " +
															" form_usrId[BAT_BKG_020] " +
															" form_hiddeData[N] " +
															" form_level[(6)] " +
															" form_remark[] " +
															" form_Cntr[1] " +
															" form_mainOnly[N] " +
															" form_CorrNo[] " +
															" form_his_cntr[BKG_CONTAINER] " +
															" form_his_bkg[BKG_BOOKING] " +
															" form_his_mkd[BKG_BL_MK_DESC] " +
															" form_his_xpt[BKG_XPT_IMP_LIC] " +
															" form_his_bl[BKG_BL_DOC] " +
														 "/rp [] /riprnmargin");
									faxInfo.setRcvInfo(hldNtc.getCustNm().replaceAll("\r\n", " ").replaceAll(";", " ") + ";" + hldNtcDtl.getFaxNo().trim());
									faxInfo.setOffice(ofc_cd);
									faxInfo.setCrtUserId(usr_id);

									// Send Fax
									eaiDao.sendFax(faxInfo);
								}							
															
								
								log.info("==========================================================================\n" +
										 "	Booking Hold Event Send Fax : " + hldNtcDtl.getFaxNo() + "(" + sendId + ")\n" +
										 "==========================================================================\n");

								
								/* SendId 기록 */
								dbDao.modifyHldNtcSendIdByFax(bkgNo, ntcSeq, hldNtcDtl.getCustCntcTpCd(), sendId);
								
								/* Notice History Setting */
								ntcHis = new BkgNtcHisVO();
								
								ntcHis.setNtcViaCd("F"); //F:Fax,M:Email
								ntcHis.setSndId(sendId);
								ntcHis.setSndOfcCd(ofc_cd);
								ntcHis.setSndUsrId(usr_id);
								ntcHis.setCreUsrId(usr_id);
								ntcHis.setUpdUsrId(usr_id);
								ntcHis.setBkgNo(bkgNo);
								ntcHis.setNtcSeq(ntcSeq);
								ntcHis.setCustCntcTpCd(hldNtcDtl.getCustCntcTpCd());
								
								hldNtcHiss.add(dbDao.searchHldNtcHistory(ntcHis));
								
							}
						}
					}
					
				} // Hold End
			}

			
			/*
			 *  4. Staff 메일 및 메시지 전송하기
			 *  등록된 모든 Staff 에게 전송
			 */
			vvd = dbDao.searchHldBkgVVD(blNo, cntCd);			

			String content = "";
			String inEmlTitNm = "";
			
			if ("PH".equals(hldType)) {
				content    = "Customs Hold B/L No[" + blNo + "] / POD [" + podCd + "] / Type [Value(" + hldCd + ")] Customer " + customer.toString();
				inEmlTitNm = "[" + hldCd + ": " + hldNm + "] Hold Notification [" + vvd + "] " + "[" + blNo + "] " + hldDt + " (US LOCAL TIME)";
			} else {
				content = "Customs Hold B/L No[" + blNo + "] / POD [" + podCd + "] / Type [Value(" + rlseHldCd + ")] Customer " + customer.toString();
				inEmlTitNm = "[" + rlseHldCd + ": " + hldNm + "] Hold Notification [" + vvd + "] " + "[" + blNo + "] " + rlseHldDt + " (US LOCAL TIME)";
			}	
			
			ntcUsrs = dbDao.searchHldNtcStaffInfo(locCd, hldCd);
			
			log.info("==========================================================================\n" +
					 "	Booking Hold Event Staff(Count) : " + ntcUsrs.size() + "\n" +
					 "==========================================================================\n");
			
			for (int m=0; m<ntcUsrs.size(); m++) {
				ntcUsr = ntcUsrs.get(m);

				/* 메시지 전송 */
				if ("M".equals(ntcUsr.getNtcMzdCd()) || "A".equals(ntcUsr.getNtcMzdCd())) 
				{
					sendId = eaiDao.sendAlert("Auto Alert", "Auto Alert", ntcUsr.getNtcUsrNm(), ntcUsr.getNtcUsrId(), content);

					log.info("== Booking Hold Event Staff Alert ========================================\n" +
							 "	USR_NM  : " + ntcUsr.getNtcUsrNm() + "\n" +
							 "	USR_ID  : " + ntcUsr.getNtcUsrId() + "\n" +
							 "	CONTENT : " + content + "\n" +
							 "  SEND ID : " + sendId + "\n" +
							 "==========================================================================\n");
				}

				/* 그룹웨어 메일 전송 */
				if ("M".equals(ntcUsr.getNtcMzdCd()) || "E".equals(ntcUsr.getNtcMzdCd())) 
				{
					if ((ntcUsr.getNtcEml().trim()).length() > 0) 
					{
						tmpMailInfo = new TmpMailSendVO();
						
						tmpMailInfo.setSndrNm("Auto Hold Notification");
						tmpMailInfo.setSndrEml("noreply@nykline.com");
						tmpMailInfo.setRcvrEml(ntcUsr.getNtcEml());						
						tmpMailInfo.setRcvrNm("");
						tmpMailInfo.setEmlTitNm(inEmlTitNm);
						tmpMailInfo.setTemplate("ESM_BKG_0510_GW_INT.html");
						
						arguments = new HashMap<String, String>();
						arguments.put("vvd", vvd);
						arguments.put("blNo", blNo);
						arguments.put("hldDesc", hldDesc);
						arguments.put("locCd", locCd);
						arguments.put("custNm", customer.toString());
						
						if ("PH".equals(hldType)) {
							arguments.put("hldCd", hldCd);
							arguments.put("hldDt", hldDt);
						} else {
							arguments.put("hldCd", rlseHldCd);
							arguments.put("hldDt", rlseHldDt);
						}
						
						tmpMailInfo.setArguments(arguments);

						sendId = eaiDao.sendGwEmail(tmpMailInfo);					
						
						log.info("== Booking Hold Event Staff G/W Mail =====================================\n" +
								 "	RCVR EML : " + ntcUsr.getNtcEml() + "\n" +
								 "	SEND ID  : " + sendId + "\n" +
								 "==========================================================================\n");
					}
				}
			}			
			
			return hldNtcHiss;

		} catch(DAOException ex) {
			
			log.error("err " + ex.toString(), ex);
   		
			return null;
			
        } catch(Exception ex) {
        	
        	log.error("err " + ex.toString(), ex);       	
			
			return null;
        }
        
	}

	
	/**
	 * TPB info retrieve.<br>
	 * 
	 * @param String bkgNo
	 * @param String ntcSeq
	 * @return List<TpbInfoVO>
	 * @exception EventException
	 */
	public List<TpbInfoVO> searchTpbInfo(String bkgNo, String ntcSeq) throws EventException {
		try {
			return dbDao.searchTpbInfo(bkgNo, ntcSeq);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
	}
	
	
	/**
	 * TPB info update.
	 * 
	 * @param TpbInfoVO[] tpbInfos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void setupTpbInfo(TpbInfoVO[] tpbInfos, SignOnUserAccount account) throws EventException
	{
		try {
			List<BkgHldN3rdPtyBilCntrVO> list = new ArrayList<BkgHldN3rdPtyBilCntrVO>();
			BkgHldN3rdPtyBilCntrVO insVo = null;
			TpbInfoVO vo = null;
			
			for ( int i=0; i<tpbInfos.length; i++ ) {
				vo = tpbInfos[i];
				
				if ("".equals(vo.getN3ptyBilNo()) ||
						"".equals(vo.getIncurChgAmt())) continue;
				
				insVo = new BkgHldN3rdPtyBilCntrVO();
				insVo.setBkgNo(vo.getBkgNo());
				insVo.setNtcSeq(vo.getNtcSeq());
				insVo.setCntrNo(vo.getCntrNo());
				insVo.setN3ptyBilNo(vo.getN3ptyBilNo());
				insVo.setIncurChgAmt(vo.getIncurChgAmt());
				insVo.setCreUsrId(account.getUsr_id());
				insVo.setUpdUsrId(account.getUsr_id());
				
				list.add(insVo);
			}
			
			if ( list.size() > 0 ) {
				dbDao.modifyTpbInfo(list);
			}
			
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
	}

	/**
	 * Waring 이벤트 발생을 처리한다.
	 * 
	 * @param CstmsHldVO cstmsHld
	 */
	public void sendAmsNtcToBkgStaff (CstmsHldVO cstmsHld) {

		BkgCstmsAdvDspoVO bkgCstmsAdvDspoVO = null;
		HldNtcBkgStaffSetupInfoVO bkgUsr = null;
		
		TmpMailSendVO tmpMailInfo = null;
		Map<String, String> arguments = null;
		InboundNoticeEAIDAO eaiDao = new InboundNoticeEAIDAO();

		String sndrNm = "Auto Hold Notification"; // 메일 발신자명
		String sndrEml = "noreply@nykline.com"; // 메일 발신자 이메일
			

		String strHldInfo = "";
		
		try {

			if (cstmsHld == null) {
				throw new Exception("Booking Hold Event(BKG Staff) Information is NULL!!");
			}
				

			String blNo    = cstmsHld.getBlNo(); 
			String locCd   = cstmsHld.getCstmsLocCd();
			String hldCd   = cstmsHld.getHldCd();
			String hldDt   = cstmsHld.getHldDt();
			String cntCd  = cstmsHld.getCntCd();
			String hldNm   = "";
			String hldDesc = "";
			String vvd     = "";
			String podCd   = "";
			String sendId  = "";
			String msgTpId = "MI";
			if(CountryCode.CA.equals(cntCd)){
				msgTpId = "A6A";
			} // Canada 일 경우 A6A를 셋팅.

			strHldInfo = "[B/L NO:" + blNo + "] [LOC CD:" + locCd + "] [HOLD CD:" + hldCd + "] [HOLD DT:" + hldDt + "]";			
			
			
			log.info("=== Booking Hold Event(BKG Staff) Information ==============================\n" +
					 "	B/L NO    : " + blNo + "\n" +
					 "	LOC CD    : " + locCd + "\n" +
					 "	HOLD CD   : " + hldCd + "\n" +
					 "	HOLD DT   : " + hldDt + "\n" +
					 "==========================================================================\n");

			
			if ("".equals(blNo) || "".equals(locCd) || "null".equals(locCd) || 
					"".equals(hldCd) || "null".equals(hldCd) || "".equals(hldDt) || "null".equals(hldDt)) {
				throw new Exception("Booking Hold Event(BKG Staff) Information is Empty!!");
			}			


			// 1. Hold 코드 조회 - 등록된 경우 Hold Description 을 가져온다.
			bkgCstmsAdvDspoVO = dbDao.searchWnFlg(hldCd);
			if (bkgCstmsAdvDspoVO == null) {
				throw new Exception("The Hold Code[" + hldCd + "] is not registered in DB");
			}
			
			if ("Y".equals(bkgCstmsAdvDspoVO.getObNtcFlg()) == false) {
				throw new Exception("The Hold Code[" + hldCd + "] is not O/B Notice");
			}

			hldNm     = bkgCstmsAdvDspoVO.getCstmsDspoNm();
			hldDesc   = bkgCstmsAdvDspoVO.getDspoDesc();	
			
			if ("".equals(hldDesc)) hldDesc = hldNm;

			
			
			// 2. VVD 가져오기
			vvd = dbDao.searchHldBkgVVD(blNo, cntCd);			

			
			// 3. Booking 정보 가져오기
			BkgBookingVO bkgBooking = dbDao.searchBkgBookingByBlNo(blNo);
			if (bkgBooking == null) {
				throw new Exception("The BL No[" + blNo + "] is not registered in DB");
			}
			
			podCd = bkgBooking.getPodCd();
			

			String content    = "Customs Hold B/L No[" + blNo + "] / POD [" + podCd + "] / Type [Value(" + hldCd + ")]";
			String obEmlTitNm = "Warning Notification [" + vvd + "] [" + blNo + "] " + "[" + hldCd + ": " + hldNm + "] " + hldDt + " (" + cntCd + " LOCAL TIME)";

			
			
			/*
			 * 4. BL 확정자 메일 및 메시지 전송하기
			 */
			bkgUsr = dbDao.searchHldNtcBkgStaffSetupInfo (blNo);
			
//			log.info("==========================================================================\n" +
//					 "	Booking Hold Event Bkg Staff(Count) : " + obUsrs.size() + "\n" +
//					 "==========================================================================\n");

			/* 메시지 전송 */
			sendId = eaiDao.sendAlert("Auto Alert", "Auto Alert", bkgUsr.getUsrNm(), bkgUsr.getDocUsrId(), content);

			log.info("== Booking Hold Event(BKG Staff) Alert ====================================\n" +
					 "	USR_NM  : " + bkgUsr.getUsrNm() + "\n" +
					 "	USR_ID  : " + bkgUsr.getDocUsrId() + "\n" +
					 "	CONTENT : " + content + "\n" +
					 "	SEND ID : " + sendId + "\n" +
					 "==========================================================================\n");

			
			/* 그룹웨어 메일 전송 */
			if ((bkgUsr.getUsrEml().trim()).length() > 0) 
			{
				tmpMailInfo = new TmpMailSendVO();
				
				tmpMailInfo.setSndrNm(sndrNm);
				tmpMailInfo.setSndrEml(sndrEml);
				tmpMailInfo.setRcvrEml(bkgUsr.getUsrEml());
				tmpMailInfo.setRcvrNm("");
				tmpMailInfo.setEmlTitNm(obEmlTitNm);
				tmpMailInfo.setTemplate("ESM_BKG_0510_GW_OBT.html");
				
				arguments = new HashMap<String, String>();
				arguments.put("cntCd", cntCd);
				arguments.put("vvd", vvd);
				arguments.put("blNo", blNo);
				arguments.put("hldCd", hldCd);
				arguments.put("hldDesc", hldDesc);
				arguments.put("hldDt", hldDt);
				arguments.put("locCd", locCd);
				arguments.put("hldDt", hldDt);
				arguments.put("msgTpId", msgTpId);
				
				tmpMailInfo.setArguments(arguments);


				sendId = eaiDao.sendGwEmail(tmpMailInfo);

				log.info("== Booking Hold Event{BKG Staff) G/W Mail =================================\n" +
						 "	Rcvr Eml : " + bkgUsr.getUsrEml() + "\n" +
						 "	SEND ID  : " + sendId + "\n" +
						 "==========================================================================\n");				
			}
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);			
        } catch(Exception ex) {			
			log.error("err " + ex.toString(), ex);			
        }
	}
}