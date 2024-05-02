/*========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName :DODInvoicemgtBCImpl.java
*@FileTitle : 
*Open Issues :
*Change history 
*@LastModifyDate : 2013. 9. 11.
*@LastModifier : KIM HYUN HWA
*@LastVersion : 
* 2013. 9. 11. KIM HYUN HWA 
* 2016-03-28 [CHM-201640540]한국지역 Drop-Off Charge 시스템 개선 요청
=========================================================*/
package com.hanjin.apps.alps.esd.eas.dodinvoicemgt.basic;


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.integration.DODInvoiceIssueEAIDAO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.integration.DODInvoiceMgtDBDAO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DODCollectionParmVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DODCollectionSumVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DODCollectionVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DODInvEmailFaxVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DODInvoiceDetailVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DODInvoiceListVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DODInvoiceMainVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DODInvoiceEdiInfoVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DODPayrInfoVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DODTariffVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DodArIfMnVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.EASEdiSndLogDtlVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.EasAttentionVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.EasPayrCntcPntVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.EasPayrInfoVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.FlatFileAckVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.PayerInfoParamVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.PayerInformationVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.SearchBKGCntrListVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.SearchDODInvoiceListInputVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.SendFlatFileVO;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.ARInterfaceCreationVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfCntrVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfMnVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
 
/**
 *  DOD Invoice management Business Logic Basic Command implementation<br>
 * - DOD Invoice management 에 대한 비지니스 로직을 처리한다.<br>
 * @author KIM HYUN HWA
 * @see  Esd_eas_0100EventResponse 참조
 * @since J2EE 1.6
 */

public class DODInvoiceMgtBCImpl extends BasicCommandSupport implements DODInvoiceMgtBC {
	
	// Database Access Object
	private transient DODInvoiceMgtDBDAO dbDao = null;
	private transient DODInvoiceIssueEAIDAO eaiDao = null;
	
	/**
	 * DODInvoiceMgtBCImpl 객체 생성<br>
	 * DODInvoiceMgtDBDAO를 생성한다.<br>
	 */
	public DODInvoiceMgtBCImpl() {
		dbDao = new DODInvoiceMgtDBDAO();
		eaiDao = new DODInvoiceIssueEAIDAO();
	}
	
	/**
	 * BKG Container List를 조회한다.
	 * 
	 * @param inBlNo
	 * @param sessionOfcCd
	 * @return List<SearchBKGCntrListVO>
	 * @throws EventException
	 */
	public List<SearchBKGCntrListVO> searchBKGCntrList(String inBlNo, String sessionOfcCd) throws EventException {
		try {
			log.debug("\n ================[BC] sessionOfcCd:"+sessionOfcCd);
			return dbDao.searchBKGCntrList(inBlNo,sessionOfcCd);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}        
	}
	
	/**
	 * 신규 DOD INV No 생성 <br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchEasDodInvSeq(String ofcCd) throws EventException {
		try {
			String dodInvNo = dbDao.searchEasDodInvSeq(ofcCd);
			return dodInvNo;			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}        
	}

	/**
	 * ESD_EAS_0100 Payer정보를 조회한다. <br>
	 * 
	 * @param String inPayerCd
	 * @return DODPayrInfoVO
	 * @throws DAOException
	 */
	public DODPayrInfoVO searchPayerInfo(String inPayerCd) throws EventException {
		try {
			return dbDao.searchPayerInfo(inPayerCd);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}        
	}	
	
	/**
	 * ESD_EAS_0100 Payer정보를 조회한다. <br>
	 * 
	 * @param String inPayerCd
	 * @param String inCustRgstNo
	 * @return DODPayrInfoVO
	 * @throws DAOException
	 */
	public DODPayrInfoVO searchPayerInfo(String inPayerCd, String inCustRgstNo) throws EventException { 
		try { 
			return dbDao.searchPayerInfo(inPayerCd,inCustRgstNo);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}        
	}	
	
	/**
	 * (KOR) DOD Invoice Issue - ISSUE<br>
	 * 
	 * @param DODInvoiceMainVO dodInvoiceMainVO
	 * @param DODInvoiceDetailVO[] dodInvoiceDetailVOs
	 * @param String dodInvNo
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void createDODInvoice(DODInvoiceMainVO dodInvoiceMainVO, DODInvoiceDetailVO[] dodInvoiceDetailVOs, String dodInvNo, SignOnUserAccount account) throws EventException {

		try {
			//Main
			dodInvoiceMainVO.setDodInvNo(dodInvNo);
			dodInvoiceMainVO.setCreUsrId(account.getUsr_id());
			dodInvoiceMainVO.setCreOfcCd(account.getOfc_cd());
			dbDao.addDODInvoiceMain(dodInvoiceMainVO);
			
			//Detail
			List<DODInvoiceDetailVO> insertVoList = new ArrayList<DODInvoiceDetailVO>();

			for ( int i=0; i<dodInvoiceDetailVOs .length; i++ ) {
				if ( dodInvoiceDetailVOs[i].getIbflag().equals("U") && dodInvoiceDetailVOs[i].getSelChk().equals("1")){
					dodInvoiceDetailVOs[i].setCreUsrId(account.getUsr_id());
					dodInvoiceDetailVOs[i].setCreOfcCd(account.getOfc_cd());
					dodInvoiceDetailVOs[i].setDodInvNo(dodInvNo);
					insertVoList.add(dodInvoiceDetailVOs[i]);
				}
			} 

			if ( insertVoList.size() > 0 ) {
				dbDao.addDODInvoiceDetail(insertVoList);
			}
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}

    /**
     * Payer정보를 조회한다.
     * 
     * @param PayerInfoParamVO payerInfoParamVO
     * @return PayerInformationVO
     * @throws EventException
     */
    public PayerInformationVO searchPayerInformation ( PayerInfoParamVO payerInfoParamVO) throws EventException {
    	PayerInformationVO rePayerInformationVO = new PayerInformationVO();
    	EasPayrInfoVO reDmtPayrInfoVO 			= new EasPayrInfoVO();
    	List<EasPayrCntcPntVO> list 			= null;

    	String s_cust_cd 	= "";
    	String s_payr_yn	= "";
    	String s_cust_gubun	= "";
    	String s_vndr_flg	= "";
    	
    	try {
    		
    		s_cust_cd 	= payerInfoParamVO.getSCustCd();
    		s_cust_gubun= payerInfoParamVO.getSCustGubun();
    		if(s_cust_gubun.equals("1")) {
    			s_vndr_flg = "Y";
    		} else if(s_cust_gubun.equals("2")) {
    			s_vndr_flg = "N";
    		}
    		
    		//PayerInfo 정보 갯수를 조회한다.
    		s_payr_yn	= dbDao.checkPayerInfo(s_cust_cd, s_vndr_flg);
    		
   		
log.debug("\n #### s_cust_cd ==> "+s_cust_cd);    		
log.debug("\n #### s_payr_yn ==> "+s_payr_yn);    		
log.debug("\n #### s_cust_gubun ==> "+s_cust_gubun);    		
    		
    		reDmtPayrInfoVO = dbDao.searchPayerInformation(s_cust_cd, s_payr_yn, s_cust_gubun);
    		list 			= dbDao.searchPayerContactPoint(s_cust_cd, s_cust_gubun);
    		
    		//MDM CUSTOMER에서 정보를 조회 하여 보여준다.
    		if(list == null || list.size() == 0) {
   				list = dbDao.searchPayerContactPointMdm( s_cust_cd, s_cust_gubun);
    		}
    		
    		rePayerInformationVO.setEasPayrInfoVO(reDmtPayrInfoVO);
    		rePayerInformationVO.setEasPayrCntcPntVOList(list);
    		
    	} catch(DAOException ex) {
    		log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("COM12203").getUserMessage());	
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
            throw new EventException(new ErrorHandler("COM12203").getUserMessage());	
        }
    	return rePayerInformationVO;
    }
    
    
	/**
	 * Payer Name 정보를 조회한다.<br>
	 * 
	 * @param PayerInfoParamVO payerInfoParamVO
	 * @return List<EasPayrInfoVO>
	 * @throws EventException
	 */
    public List<EasPayrInfoVO> searchPayerName(PayerInfoParamVO payerInfoParamVO) throws EventException{
        try {
        	if(payerInfoParamVO.getSPodCd() == null || payerInfoParamVO.getSPodCd().equals("")){
        		payerInfoParamVO.setSPodCntCd("");
        	}else{
        		payerInfoParamVO.setSPodCntCd(payerInfoParamVO.getSPodCd().substring(0, 2));
        	}
            return dbDao.searchPayerName ( payerInfoParamVO );
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("COM12203").getUserMessage());	
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
    }
    
	/**
	 * Payer Address 정보를 조회한다.<br>
	 * 
	 * @param PayerInfoParamVO payerInfoParamVO
	 * @return List<EasPayrInfoVO>
	 * @throws EventException
	 */
    public List<EasPayrInfoVO> searchPayerAddress(PayerInfoParamVO payerInfoParamVO) throws EventException{
        try {
        	if(payerInfoParamVO.getSPodCd() == null || payerInfoParamVO.getSPodCd().equals("")){
        		payerInfoParamVO.setSPodCntCd("");
        	}else{
        		payerInfoParamVO.setSPodCntCd(payerInfoParamVO.getSPodCd().substring(0, 2));
        	}
            return dbDao.searchPayerAddress ( payerInfoParamVO );
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("COM12203").getUserMessage());	
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
    }
    
	/**
	 * Payer Contact Point 정보를 조회한다.<br>
	 * 
	 * @param PayerInfoParamVO payerInfoParamVO
	 * @return List<EasPayrInfoVO>
	 * @throws EventException
	 */
    public List<EasPayrInfoVO> searchPayerContactPointName(PayerInfoParamVO payerInfoParamVO) throws EventException{
        try {
        	if(payerInfoParamVO.getSPodCd() == null || payerInfoParamVO.getSPodCd().equals("")){
        		payerInfoParamVO.setSPodCntCd("");
        	}else{
        		payerInfoParamVO.setSPodCntCd(payerInfoParamVO.getSPodCd().substring(0, 2));
        	}
            return dbDao.searchPayerContactPointName ( payerInfoParamVO );
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("COM12203").getUserMessage());	
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
    }
	/**
	 * Payer Phone No 정보를 조회한다.<br>
	 * 
	 * @param PayerInfoParamVO payerInfoParamVO
	 * @return List<EasPayrInfoVO>
	 * @throws EventException
	 */
	public List<EasPayrInfoVO> searchPayerPhoneNo(PayerInfoParamVO payerInfoParamVO) throws EventException{
        try {
        	if(payerInfoParamVO.getSPodCd() == null || payerInfoParamVO.getSPodCd().equals("")){
        		payerInfoParamVO.setSPodCntCd("");
        	}else{
        		payerInfoParamVO.setSPodCntCd(payerInfoParamVO.getSPodCd().substring(0, 2));
        	}
            return dbDao.searchPayerPhoneNo ( payerInfoParamVO );
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("COM12203").getUserMessage());	
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
	}
    
	/**
	 * Payer Fax No 정보를 조회한다.<br>
	 * 
	 * @param PayerInfoParamVO payerInfoParamVO
	 * @return List<EasPayrInfoVO>
	 * @throws EventException
	 */
	public List<EasPayrInfoVO> searchPayerFaxNo(PayerInfoParamVO payerInfoParamVO) throws EventException{
        try {
        	if(payerInfoParamVO.getSPodCd() == null || payerInfoParamVO.getSPodCd().equals("")){
        		payerInfoParamVO.setSPodCntCd("");
        	}else{
        		payerInfoParamVO.setSPodCntCd(payerInfoParamVO.getSPodCd().substring(0, 2));
        	}
            return dbDao.searchPayerFaxNo ( payerInfoParamVO );
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("COM12203").getUserMessage());	
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Payer Email 정보를 조회한다.<br>
	 * 
	 * @param PayerInfoParamVO payerInfoParamVO
	 * @return List<EasPayrInfoVO>
	 * @throws EventException
	 */
	public List<EasPayrInfoVO> searchPayerEmail(PayerInfoParamVO payerInfoParamVO) throws EventException{
        try {
        	if(payerInfoParamVO.getSPodCd() == null || payerInfoParamVO.getSPodCd().equals("")){
        		payerInfoParamVO.setSPodCntCd("");
        	}else{
        		payerInfoParamVO.setSPodCntCd(payerInfoParamVO.getSPodCd().substring(0, 2));
        	}
            return dbDao.searchPayerEmail ( payerInfoParamVO );
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("COM12203").getUserMessage());	
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Payer Info 정보를 저장한다.<br>
	 * 
	 * @param PayerInformationVO payerInformationVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void managePayerInformation(PayerInformationVO payerInformationVO, SignOnUserAccount account) throws EventException{
		EasPayrInfoVO easPayrInfoVO = new EasPayrInfoVO();
		List<EasPayrCntcPntVO> easPayrCntcPntVOs = null;
		EasPayrCntcPntVO easPayrCntcPntVO = new EasPayrCntcPntVO();
		String s_payr_yn = "";
		try{
			easPayrInfoVO 		= payerInformationVO.getEasPayrInfoVO();
			easPayrCntcPntVOs 	= payerInformationVO.getEasPayrCntcPntVOs();
			
			//vendor일 경우
			if(easPayrInfoVO.getCustCd().length() == 6){
				easPayrInfoVO.setCustCntCd("00");
				easPayrInfoVO.setCustSeq(easPayrInfoVO.getCustCd());
				easPayrInfoVO.setEasPayrVndrFlg("Y");

			}else{
				easPayrInfoVO.setCustCntCd(easPayrInfoVO.getCustCd().substring(0, 2));
				easPayrInfoVO.setCustSeq(easPayrInfoVO.getCustCd().substring(2));
				easPayrInfoVO.setEasPayrVndrFlg("N");
			}
			
			//Payer Info 저장
			s_payr_yn	= dbDao.checkPayerInfo(easPayrInfoVO.getCustCd(), easPayrInfoVO.getEasPayrVndrFlg());
			
			easPayrInfoVO.setCreOfcCd(account.getOfc_cd());
			easPayrInfoVO.setCreUsrId(account.getUsr_id());
			easPayrInfoVO.setUpdOfcCd(account.getOfc_cd());
			easPayrInfoVO.setUpdUsrId(account.getUsr_id());
			
			
			//update
			if(s_payr_yn.equals("Y")){
				dbDao.modifyPayerInfomation(easPayrInfoVO);
			}else if(s_payr_yn.equals("N")){
				dbDao.addPayerInfomation(easPayrInfoVO);
			}
			
			if(easPayrCntcPntVOs != null && easPayrCntcPntVOs.size() > 0) {
			
				//Payer contact point 저장
				for(int i = 0; i < easPayrCntcPntVOs.size(); i++) {
					easPayrCntcPntVO = (EasPayrCntcPntVO)easPayrCntcPntVOs.get(i);
					
					if(easPayrCntcPntVO.getIbflag().equals("R"))
						continue;
					
									
					log.info("\nCustCntcPntSeq=["+i+"]=>"+easPayrCntcPntVO.getCustCntcPntSeq()+"<<");
					
					if(easPayrCntcPntVO.getCustCntcPntSeq() == null || easPayrCntcPntVO.getCustCntcPntSeq().equals("")){
						s_payr_yn = "N";
					}else{
						s_payr_yn = "Y";
					}
					log.info("\nIbflag=["+i+"]=>"+easPayrCntcPntVO.getIbflag()+"<<");
					log.info("\ns_payr_yn=["+i+"]=>"+s_payr_yn+"<<");
					
					easPayrCntcPntVO.setCreOfcCd(account.getOfc_cd());
					easPayrCntcPntVO.setCreUsrId(account.getUsr_id());
					easPayrCntcPntVO.setUpdOfcCd(account.getOfc_cd());
					easPayrCntcPntVO.setUpdUsrId(account.getUsr_id());
					
					//svr_id, cust_cd CHECK
					//easPayrCntcPntVO.setSvrId(easPayrInfoVO.getSvrId());
					easPayrCntcPntVO.setCustCntCd(easPayrInfoVO.getCustCntCd());
					easPayrCntcPntVO.setCustSeq(easPayrInfoVO.getCustSeq());
					
					//east_payr_cntc_pnt_nm
					//easPayrCntcPntVO.setCntcPntNm(easPayrCntcPntVO.getPayrCntcPntNm());
					
					///////////////////////////////////////////////////////////
					//상태 체크 후 삭제 상태인 경우는 무조건 삭제 한다.
					if(easPayrCntcPntVO.getIbflag().equals("D")){
						dbDao.removePayerContactPoint(easPayrCntcPntVO);
					}else{
						
						if(s_payr_yn.equals("Y")) {
							dbDao.modifyPayerContactPoint(easPayrCntcPntVO);
						}else if(s_payr_yn.equals("N")){
							dbDao.addPayerContactPoint(easPayrCntcPntVO);
						}
					}
				}
			}
			
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("COM12192").getUserMessage());	
        } catch (Exception de) {
        	log.error("[Exception]"+de.getMessage());
            throw new EventException(new ErrorHandler("COM12192").getUserMessage());	
        }
	}	
	
	/**
	 * Atttention 정보를 조회한다.<br>
	 * 
	 * @param EasAttentionVO attentionVO
	 * @return List<EasAttentionVO>
	 * @exception EventException
	 */
	public List<EasAttentionVO> searchAttention(EasAttentionVO attentionVO) throws EventException {
		List<EasAttentionVO> attentionVOS = null;
		try {
			attentionVOS = dbDao.searchAttention(attentionVO);
			if (attentionVOS == null || attentionVOS.size() == 0) {
				attentionVOS = dbDao.searchAttentionOfCustomer(attentionVO);
			}
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return attentionVOS;
	}	
	
	/**
	 * ESD_EAS_0102 : 조회<br>
	 * DOD Invoice list를 조회합니다.<br>
	 * 
	 * @param SearchDODInvoiceListInputVO searchDODInvoiceListInputVO
	 * @return List<DODInvoiceListVO>
	 * @exception EventException
	 */
	public List<DODInvoiceListVO> searchDODInvoiceList(SearchDODInvoiceListInputVO searchDODInvoiceListInputVO) throws EventException {
		try {
			
			String dodLocCd = searchDODInvoiceListInputVO.getDodLocCd();

			if(dodLocCd != null && !dodLocCd.equals("") && !"A".equals(dodLocCd)){
				dodLocCd = "'" + dodLocCd.replaceAll(",", "','") + "'";
				searchDODInvoiceListInputVO.setDodLocCd(dodLocCd);
			}
			return dbDao.searchDODInvoiceList(searchDODInvoiceListInputVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESD_EAS_0102 : Cancel<br>
	 * DOD Invoice 를 Cancel합니다.<br>
	 * 
	 * @param DODInvoiceListVO[] dODInvoiceListVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void cancelDODInvoice(DODInvoiceListVO[] dODInvoiceListVOs, SignOnUserAccount account) throws EventException{
		try {
			List<DODInvoiceListVO> updateVoList = new ArrayList<DODInvoiceListVO>();
			
			for ( int i=0; i<dODInvoiceListVOs .length; i++ ) {    
				dODInvoiceListVOs[i].setUpdUsrId(account.getUsr_id()); 
				dODInvoiceListVOs[i].setCreOfcCd(account.getOfc_cd());
				if ( dODInvoiceListVOs[i].getIbflag().equals("U")){
					updateVoList.add(dODInvoiceListVOs[i]);
				}
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.cancelDODInvoice(updateVoList);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESD_EAS_0102 Invoice 정보를 조회하여 Account Receivable I/F 요청자료로 변환한다.<br>
	 *
	 * @param  SignOnUserAccount account
	 * @param  String invoiceNo
	 * @param  String bkgNo
	 * @return List<ARInterfaceCreationVO>
	 * @exception EventException
	 */
	public ARInterfaceCreationVO searchARInterfaceInvoice(SignOnUserAccount account, String invoiceNo,  String bkgNo ) throws EventException {

		ARInterfaceCreationVO arInterfaceCreationVO = new ARInterfaceCreationVO();

		InvArIfMnVO invArIfMnVO = new InvArIfMnVO();
		List<InvArIfChgVO> invArIfChgVOs = new ArrayList<InvArIfChgVO>();
		List<InvArIfCntrVO> invArIfCntrVOs = new ArrayList<InvArIfCntrVO>();
		

		try {
			invArIfMnVO    = dbDao.searchARInterfaceInvoiceMain(invoiceNo, bkgNo, account.getOfc_cd(), account.getUsr_id());
			invArIfChgVOs  = dbDao.searchARInterfaceChargeList(invoiceNo, account.getOfc_cd(), account.getUsr_id());
			invArIfCntrVOs = dbDao.searchARInterfaceContainerList(invoiceNo, account.getOfc_cd(), account.getUsr_id());

			arInterfaceCreationVO.setInvArIfMnVO(invArIfMnVO);
			arInterfaceCreationVO.setInvArIfChgVOs(invArIfChgVOs);
			arInterfaceCreationVO.setInvArIfCntrVOs(invArIfCntrVOs);


		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("COM12211", new String[]{"GeneralARInterfaceCreation Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("COM12211", new String[]{"GeneralARInterfaceCreation Search"}).getMessage(),ex);
		}

		return arInterfaceCreationVO;
	}
	
    /**
     * [AR Interface no]에 전달할 내용을 [저장]한다.
     * @param SignOnUserAccount account
     * @param String arIfNo
     * @param String invoiceNo
     * @throws EventException
     */
    public void modifyARInterfaceInfo(SignOnUserAccount account, String arIfNo, String invoiceNo) throws EventException{
    	try{
    		dbDao.modifyARInterfaceInfo(arIfNo, account.getOfc_cd(), account.getUsr_id(), invoiceNo);
        } catch(DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("COM12192").getUserMessage());	
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
            throw new EventException(new ErrorHandler("COM12192").getUserMessage());	
        }
    }
    
	/**
	 * Fax, Email 이벤트 처리<br>
	 * 한국지역 Invoice 를 Fax/Email 로 전송한다.<br>
	 * 
	 * @param DODInvEmailFaxVO dODInvEmailFaxVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String sendKORDodInvoiceByFaxEmail(DODInvEmailFaxVO dODInvEmailFaxVO, SignOnUserAccount account) throws EventException {
		String sndNo = "";
		try {
			// Send Mail
			sndNo = eaiDao.sendKORDodInvoiceByFaxEmail(dODInvEmailFaxVO, account);
			if(!StringUtils.isEmpty(sndNo)){
				DODInvoiceMainVO vo = new DODInvoiceMainVO();
				vo.setCreOfcCd(account.getOfc_cd());
				vo.setCreUsrId(account.getUsr_id());
				vo.setDodInvNo(dODInvEmailFaxVO.getDodInvNo());
				eaiDao.updateFaxEmail(vo, dODInvEmailFaxVO.getSendFlg());
			}
			return sndNo;
		//} catch (DAOException ex) {
		//	throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		}
	}
	
	/**
	 *  DOD Collection List<br>
	 *  
	 * @param DODCollectionParmVO dodCollectionParmVO
	 * @return List<DODCollectionVO>
	 * @throws EventException
	 */
	public List<DODCollectionVO> searchDODInvoiceCollectionList(DODCollectionParmVO dodCollectionParmVO) throws EventException {
		try {
			
			String doLoc = dodCollectionParmVO.getDoLoc();

			if(doLoc != null && !doLoc.equals("") && !"A".equals(doLoc)){
				doLoc = "'" + doLoc.replaceAll(",", "','") + "'";
				dodCollectionParmVO.setDoLoc(doLoc);
			}
			return dbDao.searchDODInvoiceCollectionList(dodCollectionParmVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * DOD Collection List Summary<br>
	 * 
	 * @param DODCollectionParmVO dodCollectionParmVO
	 * @return List<DODCollectionSumVO>
	 * @throws EventException
	 */
	public List<DODCollectionSumVO> searchDODInvoiceCollectionSummary(DODCollectionParmVO dodCollectionParmVO) throws EventException {
		try {
			
/*			String doLoc = dodCollectionParmVO.getDoLoc();

			if(doLoc != null && !doLoc.equals("") && !"A".equals(doLoc)){
				doLoc = "'" + doLoc.replaceAll(",", "','") + "'";
				dodCollectionParmVO.setDoLoc(doLoc);
			}*/
			
			return dbDao.searchDODInvoiceCollectionSummary(dodCollectionParmVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * DOD Invoice  Credit Note 생성<br>
	 * 
	 * @param String dodInvNo
	 * @param String newDodInvNo
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void createCreditNoteDODInvoice(String dodInvNo, String newDodInvNo, SignOnUserAccount account) throws EventException {

		try {
		    String creUsrId = account.getUsr_id();
		    String ofcCd    = account.getOfc_cd();
			dbDao.addCreditNoteMain(dodInvNo, newDodInvNo, creUsrId, ofcCd );
			dbDao.addCreditNoteDetail(dodInvNo, newDodInvNo, creUsrId, ofcCd);
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * ESD_EAS_0102 Invoice 정보를 조회하여 Account Receivable I/F 가 처리 되었는지 확인.<br>
	 *
	 * @param  SignOnUserAccount account
	 * @param  String invoice_no
	 * @param  String bkg_no
	 * @return DodArIfMnVO
	 * @exception EventException
	 */
	public DodArIfMnVO checkAlreadyArIf(SignOnUserAccount account, String invoice_no,
			String bkg_no) throws EventException  {


				DodArIfMnVO dodArIfMnVO = new DodArIfMnVO();
				
				try {
					dodArIfMnVO    = dbDao.checkAlreadyArIf(invoice_no, bkg_no, account.getOfc_cd(), account.getUsr_id());


				} catch(DAOException de) {
					log.error("err " + de.getMessage(), de);
					throw new EventException(new ErrorHandler("COM12211", new String[]{"GeneralARInterfaceCreation Search"}).getMessage(),de);
				} catch (Exception ex) {
					log.error("err " + ex.getMessage(), ex);
					throw new EventException(new ErrorHandler("COM12211", new String[]{"GeneralARInterfaceCreation Search"}).getMessage(),ex);
				}

				return dodArIfMnVO;
		
	}	    
	
	/**
	 * EAS Invoice EDI 전송 위해 FlatFile을 생성한다.
	 * @param DODInvoiceMainVO dodInvoiceMainVO
	 * @param DODInvoiceDetailVO[] dodInvoiceDetailVOs
	 * @param SignOnUserAccount account
	 * @param String docName
	 * @param String docFunc
	 * @return String
	 * @throws EventException
	 */
	public String transmitEASEDI(DODInvoiceMainVO dodInvoiceMainVO, DODInvoiceDetailVO[] dodInvoiceDetailVOs, SignOnUserAccount account, String docName, String docFunc) throws EventException {
		
		log.debug("\n transmitEASEDI============================");
		// FLATFILE
		String 			senderId 		= "";
		String 			receiverId 		= "";
		String 			headerType 		= "";
		String 		 	flatFileHeader	= null;
		String 		 	flatFileRefNo	= null;
		StringBuffer 	flatFile 		= new StringBuffer();
		
		// -- Output 정보 -- //
		// EAS Invoice 정보
		DODInvoiceEdiInfoVO 				dodInvoiceEdiInfoVO 			= null;
		
		// -- For문 Index -- //
		int ItemIdx = 0;
		int subTotAmount = 0;
		int vatAmount = 0;

		dodInvoiceMainVO = searchDodInvoiceMain(dodInvoiceMainVO.getDodInvNo());
		dodInvoiceDetailVOs	 = searchDodInvoiceDetail(dodInvoiceMainVO.getDodInvNo());
		
		try
		{
			// Body 생성
			if( dodInvoiceMainVO != null ){
					
				// Header 생성
				//$$$MSGSTART:SMLMM010            KTNETPCS            KLQMSG    EAS14040975174 
				senderId = "SMLMM010";
				receiverId = "KTNETPCS";
				headerType = "KLQMSG";
				flatFileHeader = searchEASEdiHeader(senderId, receiverId, headerType);
				flatFile.append(flatFileHeader).append("\n");
				
				flatFileRefNo = flatFileHeader.substring(flatFileHeader.indexOf("EAS"));
log.debug("\n flatFileRefNo["+flatFileRefNo+"]==docName + docFunc["+docName + docFunc+"]=====================================");					
				flatFile.append("DOC_NAME:")		.append(docName).append("\n");
				if(docName.equals("DDI")){
					flatFile.append("DOC_NO:")		.append(dodInvoiceMainVO.getDodInvNo()).append("\n");
				}else if(docName.equals("DDP")){	  
					flatFile.append("DOC_NO:")		.append(dodInvoiceMainVO.getArIfNo()).append("\n");
				}	
				flatFile.append("DOC_FUNC:")		.append(docFunc).append("\n");
				flatFile.append("RESP_TYPE:")		.append("NA").append("\n");
				flatFile.append("SHIP_COMPANY:")	.append("SML").append("\n");
				if(docName.equals("DDI")){
					flatFile.append("REQ_NO:")		.append(dodInvoiceMainVO.getDodInvNo()).append("\n");
				}else if(docName.equals("DDP")){		
					flatFile.append("REQ_NO:")		.append(dodInvoiceMainVO.getArIfNo()).append("\n");
				}		
				flatFile.append("INV_NO:")		.append(dodInvoiceMainVO.getDodInvNo()).append("\n");
				if(docName.equals("DDP")){
					flatFile.append("PAYINSLIP_NO:").append(dodInvoiceMainVO.getArIfNo()).append("\n");
				}else{
					flatFile.append("PAYINSLIP_NO:").append("").append("\n");
				}
				if(docName.equals("DDI")){
					//flatFile.append("ISSUE_DT:")	.append((new SimpleDateFormat("yyyyMMddHHmm")).format(new Date())).append("\n");  //yyyyMMddHHmmssSSS
					flatFile.append("ISSUE_DT:")	.append(dodInvoiceMainVO.getCreDt()).append("\n");  //yyyyMMddHHmmssSSS
				}else if(docName.equals("DDP")){
					flatFile.append("ISSUE_DT:")	.append(dodInvoiceMainVO.getArIfDt()).append("\n");
				}
				if(docName.equals("DDP")){
					flatFile.append("PAYIN_DT:")	.append(dodInvoiceMainVO.getArIfDt()).append("\n"); //[from 김재진 수석님]A/R IF 시점을 실제 입금일자로 간주하기 때문에 9,10번 A/R I/F Date로 처리하면 될 것 같습니다.
					flatFile.append("MAIN_DIV_CD:")	.append("DOC").append("\n");
				}else{
					flatFile.append("PAYIN_DT:")	.append("").append("\n");
					flatFile.append("MAIN_DIV_CD:")	.append("").append("\n");
				}	
				
				
				// (1) EAS Invoice 정보  searchInvoiceStatusVO
//				if(docName.equals("DDI")){
					dodInvoiceEdiInfoVO = dbDao.searchIssueEdiInfo(dodInvoiceMainVO.getDodInvNo());
//				}	
				flatFile.append("IMEX_CD:")			.append(dodInvoiceEdiInfoVO.getImexCd()).append("\n");	
				flatFile.append("MRNMSN_NO:")		.append(dodInvoiceEdiInfoVO.getMrnmsnNo()).append("\n");
				flatFile.append("BL_NO:")			.append(dodInvoiceEdiInfoVO.getBlNo()).append("\n");
				flatFile.append("BKG_NO:")			.append(dodInvoiceEdiInfoVO.getBkgNo()).append("\n");
				flatFile.append("VSL_CD:")			.append(dodInvoiceEdiInfoVO.getVslCd()).append("\n");
				flatFile.append("VSL_VOY_DIR:")		.append(dodInvoiceEdiInfoVO.getVslVoyDir()).append("\n");
				flatFile.append("POL_LOC:")			.append(dodInvoiceEdiInfoVO.getPolLoc()).append("\n");
				flatFile.append("POD_LOC:")			.append(dodInvoiceEdiInfoVO.getPodLoc()).append("\n");
				flatFile.append("DEL_LOC:")			.append(dodInvoiceEdiInfoVO.getDelLoc()).append("\n");
				
				flatFile.append("ETA:")				.append(dodInvoiceEdiInfoVO.getEta()).append("\n");
				flatFile.append("ETD:")				.append(dodInvoiceEdiInfoVO.getEtd()).append("\n");
				flatFile.append("PAYIN_NAME:")		.append(dodInvoiceMainVO.getCntcPntNm()).append("\n");
				flatFile.append("CUR_RATE:")		.append(dodInvoiceEdiInfoVO.getCurRate()).append("\n");
				flatFile.append("CUR_DT:")			.append(dodInvoiceEdiInfoVO.getCurDt()).append("\n");
				flatFile.append("TOT_AMOUNT:")		.append(dodInvoiceMainVO.getTtlInvAmt()).append("\n");
				flatFile.append("CUR_CD:")			.append(dodInvoiceMainVO.getInvCurrCd()).append("\n");
				
				for( ItemIdx = 0; ItemIdx < dodInvoiceDetailVOs.length; ItemIdx++)
				{
					int tmpBilAmount = Integer.parseInt(dodInvoiceDetailVOs[ItemIdx].getBilAmt());
					int tmpVatAmount = Integer.parseInt(dodInvoiceDetailVOs[ItemIdx].getTaxAmt());
					subTotAmount = subTotAmount + tmpBilAmount;
					vatAmount = vatAmount + tmpVatAmount;
				}
				flatFile.append("SUBTOT_AMOUNT:")	.append(subTotAmount ).append("\n");
				flatFile.append("VAT:")				.append(vatAmount).append("\n");
				//CNTC_PNT_FAX_NO,CNTC_PNT_EML,CNTC_PNT_PHN_NO
				flatFile.append("REMARK:")			.append("FAX "+dodInvoiceMainVO.getCntcPntFaxNo()+", e-mail" +dodInvoiceMainVO.getCntcPntEml()+", TEL "+dodInvoiceMainVO.getCntcPntPhnNo()).append("\n");

				// (1) EAS Invoice 정보  searchInvoiceStatusVO
				if(docName.equals("DDI")){
					if(dodInvoiceDetailVOs.length>0) flatFile.append("{CNTR_INFO")   .append("\n");
						String strNum="";
						for( ItemIdx = 0; ItemIdx < dodInvoiceDetailVOs.length; ItemIdx++)
						{
							if(ItemIdx<10) strNum="00";
							else if(ItemIdx<100) strNum="0";
							log.debug("\n strNum + ItemIdx : "+strNum + ItemIdx+"============================================");
							flatFile.append("CNTR_SEQ:")	.append(strNum + (ItemIdx+1)).append("\n");
							flatFile.append("CNTR_NO:")		.append(dodInvoiceDetailVOs[ItemIdx].getCntrNo()).append("\n");
							strNum = dbDao.searchCntrSizeIso(dodInvoiceDetailVOs[ItemIdx].getCntrTpszCd());
							flatFile.append("CNTR_SIZE_ISO:").append(strNum).append("\n");
							flatFile.append("CNTR_DIV_CD:")	.append("DOC").append("\n");
						}						
						if(dodInvoiceDetailVOs.length>0) flatFile.append("}CNTR_INFO")	.append("\n");
				}		
				
			log.debug("abc_FlatFile = "+flatFile.toString());
			
			// send Flat File log VO 셋팅
			EASEdiSndLogDtlVO easEdiSndLogDtlVO = new EASEdiSndLogDtlVO(); // send
			//List<TPBEdiSndLogDtlVO> tpbEdiSndLogDtlList = new ArrayList<TPBEdiSndLogDtlVO>();
					
			// 전송로그를 저장한다. 	
			//FlatFile을 4000Byte씩 나눈다 - start (100Byte의 여유를 주기 위해 3900Byte로 나눔)
			int divisor = 3900;
			int totLength = flatFile.length();
			int quotient = totLength / divisor;
			int remainder = totLength % divisor;
				
			int loopCnt = 0;
			int start = 0;
			int end = 0;
			
			if(remainder > 0) {
				loopCnt = quotient + 1;
			} else {
				loopCnt = quotient;
			}
			
			String[] fFiles = new String[loopCnt];
			
			for(int i = 0; i < loopCnt; i++) {
				if(i == loopCnt-1) {
					end = remainder;
				} else {
					end = divisor;
				}
				
				start = i * divisor;
				
				fFiles[i] = flatFile.substring(start, start+end);

				easEdiSndLogDtlVO.setEdiSndIndCd(docName + docFunc);
				easEdiSndLogDtlVO.setFltFileRefNo(flatFileRefNo);
				easEdiSndLogDtlVO.setEdiSndSeq(Integer.toString(i+1));
				easEdiSndLogDtlVO.setEdiDtlSeq(Integer.toString(i+1));
				easEdiSndLogDtlVO.setDodInvNo(dodInvoiceMainVO.getDodInvNo());
				easEdiSndLogDtlVO.setArIfNo(dodInvoiceMainVO.getArIfNo());
				easEdiSndLogDtlVO.setEdiSndMsg(fFiles[i]);
				easEdiSndLogDtlVO.setCreUsrId(account.getUsr_id());
				easEdiSndLogDtlVO.setUpdUsrId(account.getUsr_id());

				// 전송로그를 저장한다. (DETAIL)
				if( easEdiSndLogDtlVO != null ){
					dbDao.addEASEdiSndLogDtl(easEdiSndLogDtlVO);
				}								
				
			}
			
			// flatFile MQ로 전송
			ediSendMessage(flatFile.toString(), "EAS.EAS_EDI_IBMMQ.QUEUE"); 
			
		}
		}catch (DAOException ex)
		{
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EAS00080", new String[] {}).getMessage(), ex);
		}
		catch (Exception ex)
		{
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EAS00080", new String[] {}).getMessage(), ex);
		}
		return flatFile.toString();
	}

	/**
	 * EDI 전송 처리부
	 * @param String flatFile
	 * @param String queueName
	 * @exception EventException
	 */
	private void ediSendMessage(String flatFile, String queueName) throws EventException
	{
		try {					
		  // FlatFile 이 빈 경우 SKIP 처리
			if (flatFile!=null && flatFile.trim().length() > 1) {
			  SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
			  sendFlatFileVO.setFlatFile(flatFile);
			  sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get(queueName));
			  FlatFileAckVO flatFileAckVO = sendFlatFile(sendFlatFileVO);
			  if (flatFileAckVO.getAckStsCd().equals("E"))
			  	throw new EventException(new ErrorHandler("EAS00080", new String[] {}).getMessage());
			}
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("EAS00080", new String[] {}).getMessage(), ex);
		}
	}
	
    
	/**
	 * EDI Transmit 공통 함수<br>
	 * @param SendFlatFileVO sendFlatFileVO
	 * @return FlatFileAckVO
	 * @throws EventException
	 */
	public FlatFileAckVO sendFlatFile(SendFlatFileVO sendFlatFileVO) throws EventException {
		FlatFileAckVO flatFileAckVO = new FlatFileAckVO();
		try {
			flatFileAckVO = eaiDao.sendFlatFile(sendFlatFileVO);
		}catch(EventException ex){
			throw ex;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}

		return flatFileAckVO;
	}  
		

	/**
	 * EDI 전송을 위한 BackEndJob을 실행<br>
	 * @param SignOnUserAccount account
	 * @param DODInvoiceMainVO dodInvoiceMainVO
	 * @param DODInvoiceDetailVO[] dodInvoiceDetailVOs
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJob(SignOnUserAccount account, DODInvoiceMainVO dodInvoiceMainVO, DODInvoiceDetailVO[] dodInvoiceDetailVOs, String pgmNo)  throws EventException{

		DODInvoiceMgtEdiBackEndJob backEndJob = new DODInvoiceMgtEdiBackEndJob ();
		backEndJob.setPgmNo(pgmNo);
		String resultStr = "";

		log.debug("\n startBackEndJob::start[pgmNo:"+pgmNo+"]============================");		
		
		if(pgmNo.equals("ESD_EAS_0100")) {

			backEndJob.setDODInvoiceMainVO(dodInvoiceMainVO);
			backEndJob.setDODInvoiceDetailVO(dodInvoiceDetailVOs);
			backEndJob.setAccount(account);
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			log.debug("\n startBackEndJob::ESD_EAS_0100============================");
			resultStr = backEndJobManager.execute(backEndJob , account.getUsr_id(), "ESD_EAS_0100");	//EAS Invoice EDI Transmit
		}else if(pgmNo.equals("ESD_EAS_0100_1")) {
			
			backEndJob.setDODInvoiceMainVO(dodInvoiceMainVO);
			backEndJob.setDODInvoiceDetailVO(dodInvoiceDetailVOs);
			backEndJob.setAccount(account);
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			log.debug("\n startBackEndJob::ESD_EAS_0100_1============================"); 
			resultStr = backEndJobManager.execute(backEndJob , account.getUsr_id(), "ESD_EAS_0100_1");	//EAS Invoice Cancel EDI Transmit
			
		}else if(pgmNo.equals("ESD_EAS_0102")) {
			
			backEndJob.setDODInvoiceMainVO(dodInvoiceMainVO);
			backEndJob.setDODInvoiceDetailVO(dodInvoiceDetailVOs);
			backEndJob.setAccount(account);
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			log.debug("\n startBackEndJob::ESD_EAS_0102============================"); 
			resultStr = backEndJobManager.execute(backEndJob , account.getUsr_id(), "ESD_EAS_0102");	//EAS AR I/F EDI Transmit
			
		}else if(pgmNo.equals("ESD_EAS_0102_1")) {
			
			backEndJob.setDODInvoiceMainVO(dodInvoiceMainVO);
			backEndJob.setDODInvoiceDetailVO(dodInvoiceDetailVOs);
			backEndJob.setAccount(account);
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			log.debug("\n startBackEndJob::ESD_EAS_0102_1============================"); 
			resultStr = backEndJobManager.execute(backEndJob , account.getUsr_id(), "ESD_EAS_0102_1");	//EAS AR I/F Cancel EDI Transmit
			
		}
		
		return resultStr;
	}
	
	
	/**
	 * EAS에서 사용하는 Flat File Header 생성 <br> 
	 * @param String sndrId
	 * @param String rcvId
	 * @param String msgId
	 * @return String
	 * @throws EventException
	 */
	public String searchEASEdiHeader(String sndrId, String rcvId, String msgId)throws EventException {
	    try {
	        return dbDao.searchEASEdiHeader(sndrId, rcvId, msgId);
	    } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}	

	
	/**
	 * EAS Invoice Main 정보를  search 한다.
	 * @param dodInvNo
	 * @return DODInvoiceMainVO
	 * @throws EventException
	 */
	public DODInvoiceMainVO searchDodInvoiceMain(String dodInvNo) throws EventException{
	    try {
	        return dbDao.searchDodInvoiceMain(dodInvNo);
	    } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}	

	/**
	 * EAS Invoice Detail 정보를  search 한다.
	 * @param dodInvNo
	 * @return List<DODInvoiceDetailVO>
	 * @throws EventException
	 */
	public DODInvoiceDetailVO[] searchDodInvoiceDetail(String dodInvNo) throws EventException{
	    try {
	        return dbDao.searchDodInvoiceDetail(dodInvNo);
	    } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * (KOR) DOD Tariff List 정보를 조회합니다.<br>
	 * 
	 * @param String ofcCd
	 * @param String polContiCd
	 * @param String effDt 
	 * @return List<DODTariffVO>
	 * @throws EventException
	 */
	public List<DODTariffVO> searchDODTariffList(String ofcCd , String polContiCd, String effDt) throws EventException{
        try {
            return dbDao.searchDODTariffList(ofcCd, polContiCd,effDt);
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("COM12203").getUserMessage());	
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * (KOR) DOD Tariff Effective Date list를 조회한다.<br>
	 * 
	 * @param String ofc
	 * @param String pol_conti
	 * @return List<String>
	 * @throws EventException
	 */
	public List<String> searchDODTariffEffDtList(String ofc, String pol_conti) throws EventException{
        try {
            return dbDao.searchDODTariffEffDtList(ofc, pol_conti);
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("COM12203").getUserMessage());	
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * (KOR) DOD Tariff 정보를 등록, 수정, 삭제한다.<br>
	 * 
	 * @author  
	 * @param DODTariffVO[] dODTariffVOs
	 * @exception EventException
	 */
	public void manageDODTariff(DODTariffVO[] dODTariffVOs) throws EventException {
		try {
				
			List<DODTariffVO> insertVoList = new ArrayList<DODTariffVO>();
			List<DODTariffVO> updateVoList = new ArrayList<DODTariffVO>();
			List<DODTariffVO> deleteVoList = new ArrayList<DODTariffVO>();
			
			if (null != dODTariffVOs) {
				
				for (int i = 0; i < dODTariffVOs.length; i++) {
					
					log.debug(dODTariffVOs[i].toString());
					
					if (dODTariffVOs[i].getIbflag().equals("I")) {
						insertVoList.add(dODTariffVOs[i]);
						
					} else if (dODTariffVOs[i].getIbflag().equals("U")) {
						updateVoList.add(dODTariffVOs[i]);
						
					} else if (dODTariffVOs[i].getIbflag().equals("D")) {
						deleteVoList.add(dODTariffVOs[i]);
					}
				}
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeDODTariff(deleteVoList);
			}
			if (updateVoList.size() > 0) {
				dbDao.modifyDODTariff(updateVoList);
			}
			if (insertVoList.size() > 0) {
				dbDao.addDODTariff(insertVoList);
			}
		} catch (DAOException e) {
			throw new EventException(e.getMessage(), e);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}	
	
	/**
	 * (KOR) DOD Tariff Creation 입력된 tpsz_cd의 MDM내 존재여부 확인.<br>
	 * 
	 * @param String cntr_tpsz_cds
	 * @return String
	 * @throws EventException
	 */
	public String verifyDODTariffTpSz(String cntr_tpsz_cds) throws EventException{
        try {
            return dbDao.verifyDODTariffTpSz(cntr_tpsz_cds);
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("COM12203").getUserMessage());	
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * (Korea) DOD Tariff Dup Chek 정보를 조회한다.<br>
	 * 
	 * @param DODTariffVO dODTariffVO
	 * @return String
	 * @throws EventException
	 */
	public String searchDODTariffDupCheck(DODTariffVO dODTariffVO) throws EventException{
        try {
            return dbDao.searchDODTariffDupCheck(dODTariffVO);
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("COM12203").getUserMessage());	
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
	}
}