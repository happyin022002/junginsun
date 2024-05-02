/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueBCImpl.java
*@FileTitle : (Korea) Terminal GIRO Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.04.27 정휘택
* 1.0 Creation
* --------------------------------------------------------
* History
* 2010.08.31 최도순 removeInvoiceIssueFilter 함수 Filter Table Sequence 주기 문제로 주석해제
* 2010.11.04 최도순 JSPUtil의 공통함수 사용으로 주석처리
* 2011.01.24 최도순 [CHM-201108418] 베트남지역 ALPS INVOICE 변경 요청
* 2011.02.08 최도순 [CHM-201108232] DEM/DET 에서 INV로 INTERFACE 시 I/F NO 누락 방지를 위한 로직 변경
* 2011.08.04 오요한 [CHM-201111930] Invoice Issue 프로그램 개선
* 2011.11.14 오요한 [CHM-201113617] SVAT Reg. No for CMBSC
* 2012.02.01 권   민 [CHM-201215781-01] [INV] ALPS INV 중복 발행 시 알림창 pop up
* 2014.08.26 최도순 [CHM-201431413] 미주지역 Inv Issue 프로그램 개발 요청
* 2014.10.07 최도순[CHM-201432279] 미주지역 invoice Issue 메뉴 보완 요청
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.basic;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBC;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvArIfNoVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceListByIFDateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceIssueDateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration.InvoiceIssueDBDAO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration.InvoiceIssueEAIDAO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.CHNIssuedInvoiceListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.CHNReissuedInvoiceListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.CPRIDListInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.CPRTInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.CPRTInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.CPRTListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.CPRTMainVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.GeneralInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvArEmlCustRgstVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvArGiroVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvArKrIssChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvArSplitIssChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvArSplitIssVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvArUsaIssSndVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvEmailFaxVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvEmlVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvIssMainVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvIssVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvoiceFaxEmailListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvoiceIssueSndToErpVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvoiceNumberVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.IssueEachTargetVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.IssueOptionVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.IssueTargetVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.KORGiroInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.KORGiroListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.KORInvoiceBLListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.KORInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.NYCEmlVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.NYCInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.PrintInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.SetupOfficeVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.TemplateItemVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.TemplateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.VIEActInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.VIECombineInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.VIEDailyExrateReturnVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.VIEDailyExrateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.VIEInvoiceTargetVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.DateTime;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.InvArIssSndVO;
import com.hanjin.syscommon.common.table.InvArIssVO;
import com.hanjin.syscommon.common.table.MdmCrCustVO;

/**
 * ALPS-AccountReceivableInvoiceMgt Business Logic Basic Command implementation<br>
 * - ALPS-AccountReceivableInvoiceMgt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Jung Hwi Taek
 * @see FNS_INV_0064EventResponse,InvoiceIssueBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class InvoiceIssueBCImpl extends BasicCommandSupport implements InvoiceIssueBC {

	// Database Access Object
	private transient InvoiceIssueDBDAO dbDao = null;
	private transient InvoiceIssueEAIDAO eaiDao = null;

	/**
	 * InvoiceIssueBCImpl 객체 생성<br>
	 * InvoiceIssueDBDAO를 생성한다.<br>
	 */
	public InvoiceIssueBCImpl() {
		dbDao = new InvoiceIssueDBDAO();
		eaiDao = new InvoiceIssueEAIDAO(); 
	}
	
	/**
	 * GeneralARInvoiceCreationBCImpl 객체 생성<br>
	 * GeneralARInvoiceCreationBCImpl를 생성한다.<br>
	 *  @param String dataSource
	 */
	public InvoiceIssueBCImpl(String dataSource) {
		dbDao = new InvoiceIssueDBDAO(dataSource);
		eaiDao = new InvoiceIssueEAIDAO();
	}
	
	/**
	 * Terminal Invoice 의 GIRO 정보를 다수 조회한다. <br>
	 * 
	 * @param KORGiroInputVO giroInputVo
	 * @return List<KORGiroListVO>
	 * @exception EventException
	 */
	public List<KORGiroListVO> searchKORGIROList(KORGiroInputVO giroInputVo) throws EventException {
		
		//log.info("\n########## giroInputVo.getArOfcCd2() : "+giroInputVo.getArOfcCd2());		
		
		try {
			return dbDao.searchKORGIROList(giroInputVo);
	    } catch(DAOException ex) {
	    	log.error("err " + ex.toString(), ex);
	    	throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}	
	}
	
	/**
	 * Invoice Remark(s)의 event에 대한 조회 이벤트 처리<br>
	 * @author Jung Hwi Taek
	 * @param InvArIssVO invArIssVO
	 * @return List<InvArIssVO>
	 * @exception EventException
	 */
	public List<InvArIssVO> searchInvoiceRemark(InvArIssVO invArIssVO) throws EventException {
		try {
			return dbDao.searchInvoiceRemark(invArIssVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Invoice 발행시 Copy 본수를 조회한다. <br>
	 * 
	 * @param String ofcCd
	 * @return int
	 * @exception EventException
	 */
	public int searchInvoiceCopyCnt(String ofcCd) throws EventException {
		try {
			return dbDao.searchInvoiceCopyCnt(ofcCd);
	    } catch(DAOException ex) {
	    	log.error("err " + ex.toString(), ex);
	    	throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}	
	}
	
	/**
	 * Invoice No를 입력받은 후 유효한 Invoice No를 Return 해주며 INV_AR_ISS에 Re-issue 이력을 저장해 준다. <br>
	 * 
	 * @param PrintInvoiceVO prtInvoiceVo
	 * @return List<InvIssMainVO>
	 * @exception EventException
	 */
	public List<InvIssMainVO> searchPrintInvoice(PrintInvoiceVO prtInvoiceVo) throws EventException {
		List<InvIssMainVO> list = null;
		InvIssMainVO issMain = null;
		String xchRt = "0";
		InvEmlVO invEmlSendNoVO = new InvEmlVO();
		
		try {
			list =  dbDao.searchPrintInvoice(prtInvoiceVo);
			
			log.info("\n########## prtInvoiceVo.getPrevFlg() : "+prtInvoiceVo.getPrevFlg());
				
			if (!prtInvoiceVo.getPrevFlg().equals("Y")) {
			
				for(int i=0; i<list.size(); i++) {
					issMain = new InvIssMainVO();
					issMain.setInvNo(list.get(i).getInvNo());
					issMain.setIssOfcCd(prtInvoiceVo.getUserOfc());
					issMain.setCreUsrId(prtInvoiceVo.getUserId());
					
					log.info("\n########## prtInvoiceVo.getUserOfc() : "+prtInvoiceVo.getUserOfc());
					
					if (prtInvoiceVo.getIssOfcCd().equals("SGNSC")) {
						
						// [CHM-201111084] 베트남 지역 인보이스 로직 변경 요청건 
						//VIEDailyExrateVO vIEDailyExrateVO = new VIEDailyExrateVO();
						//vIEDailyExrateVO.setIoBndCd(list.get(i).getIoBndCd());
						//vIEDailyExrateVO.setOfcCd(prtInvoiceVo.getIssOfcCd());
						//vIEDailyExrateVO.setXchRtDt(DateTime.getShortDateString());
						
						//ReIssue 이므로 아래의 dao를 호출한다.(from 김동진수석님)
						//xchRt = dbDao.searchVIEDailyExrateMaxToDt(vIEDailyExrateVO);
						xchRt = dbDao.searchVIEDailyExrateForReIssue(list.get(i).getInvNo());
						
						log.info("\n########## list.get(i).getIoBndCd() : "+list.get(i).getIoBndCd());
						log.info("\n########## prtInvoiceVo.getIssOfcCd() : "+prtInvoiceVo.getIssOfcCd());
						log.info("\n########## DateTime.getShortDateString() : "+DateTime.getShortDateString());
						log.info("\n########## xchRt : "+xchRt);
						
						issMain.setUsdXchRt(xchRt);
						
					}
					
					dbDao.createIssueMain(issMain);		
					
					if (!prtInvoiceVo.getGotoFlg().equals("Y")) {
						
						//INV_AR_ISS_SND INSERT
						invEmlSendNoVO.setCustEml("");
						invEmlSendNoVO.setOfcCd(prtInvoiceVo.getUserOfc());
						invEmlSendNoVO.setEmlSndNo("");
						dbDao.createSendNo(list.get(i).getInvNo(), "P", invEmlSendNoVO, prtInvoiceVo.getUserId());
							
					}
				}
			
			}

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}

		return list;
	}
	
	/**
	 * Fax / E-mail 발송 또는 Print 하려는 대상 Invoice 정보를 조회한다. <br>
	 * 
	 * @param PrintInvoiceVO prtInvoiceVo
	 * @return List<InvoiceFaxEmailListVO>
	 * @exception EventException
	 */
	public List<InvoiceFaxEmailListVO> searchIssuedGeneralInvoiceList(PrintInvoiceVO prtInvoiceVo) throws EventException {
		try {
			return dbDao.searchIssuedGeneralInvoiceList(prtInvoiceVo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Invoice 발행 정보를 생성한다. <br>
	 * 
	 * @param InvIssMainVO[] issMainVOs
	 * @param IssueOptionVO issOptionVO
	 * @param String userId
	 * @return String
	 * @exception EventException
	 */
    public String createIssueMain(InvIssMainVO[] issMainVOs, IssueOptionVO issOptionVO, String userId) throws EventException {

    	int issueCnt = 0;
    	String xchRt = "0";
    	InvEmlVO invEmlSendNoVO = new InvEmlVO();
    	
		try {
			
			if (issOptionVO.getIssueGubn().equals("I")) {
				// issue 일때
				for (int i = 0; i < issMainVOs.length; i++) {
					//log.info("########## issMainVOs[i].getInvNo() : "+issMainVOs[i].getInvNo());
					issMainVOs[i].setCreUsrId(userId);
					dbDao.modifyIssueMain(issMainVOs[i]);
					
					if (issOptionVO.getSendFlag().equals("P") || (issOptionVO.getSendFlag().equals("E") && issOptionVO.getSendFlag2().equals("P"))) {
						
						if (issOptionVO.getSendFlag().equals("E") && issOptionVO.getSendFlag2().equals("P") && issOptionVO.getCopyCnt().equals("0") && (issMainVOs[i].getCustEml().length() > 0)){
							// INV_AR_ISS_SND INSERT SKIP
							issMainVOs[i].setCreUsrId(userId);
						} else {
											
							//INV_AR_ISS_SND INSERT
							invEmlSendNoVO.setCustEml("");
							invEmlSendNoVO.setOfcCd(issOptionVO.getIssOfcCd()); 
							invEmlSendNoVO.setEmlSndNo("");
							dbDao.createSendNo(issMainVOs[i].getInvNo(), "P", invEmlSendNoVO, userId);
						}
					}
					issueCnt++;
				}
			} else {
				// re-issue 일때
				for (int i = 0; i < issMainVOs.length; i++) {
					issMainVOs[i].setCreUsrId(userId);					
					issMainVOs[i].setSendFlag(issOptionVO.getSendFlag());
					issMainVOs[i].setIssOfcCd(issOptionVO.getIssOfcCd());
					
					log.info("\n########## issOptionVO.getIssOfcCd() : "+issOptionVO.getIssOfcCd());
					
					if (issOptionVO.getIssOfcCd().equals("SGNSC")) {
						VIEDailyExrateVO vIEDailyExrateVO = new VIEDailyExrateVO();
						vIEDailyExrateVO.setIoBndCd(issMainVOs[i].getIoBndCd());
						vIEDailyExrateVO.setOfcCd(issOptionVO.getIssOfcCd());
						vIEDailyExrateVO.setXchRtDt(DateTime.getShortDateString());
						
						xchRt = dbDao.searchVIEDailyExrateMaxToDt(vIEDailyExrateVO);
						
						log.info("\n########## issMainVOs[i].getIoBndCd() : "+issMainVOs[i].getIoBndCd());
						log.info("\n########## issOptionVO.getIssOfcCd() : "+issOptionVO.getIssOfcCd());
						log.info("\n########## DateTime.getShortDateString() : "+DateTime.getShortDateString());
						log.info("\n########## xchRt : "+xchRt);
						
						issMainVOs[i].setUsdXchRt(xchRt);
						
					}				
					
					dbDao.createIssueMain(issMainVOs[i]);
					
					log.info("\n########## issOptionVO.getSendFlag() : "+issOptionVO.getSendFlag());
					log.info("\n########## issOptionVO.getSendFlag2() : "+issOptionVO.getSendFlag2());
					
					if (issOptionVO.getSendFlag().equals("P") || (issOptionVO.getSendFlag().equals("E") && issOptionVO.getSendFlag2().equals("P"))) {
						
						if (issOptionVO.getSendFlag().equals("E") && issOptionVO.getSendFlag2().equals("P") && issOptionVO.getCopyCnt().equals("0") && (issMainVOs[i].getCustEml().length() > 0)){
							// INV_AR_ISS_SND INSERT SKIP
							issMainVOs[i].setCreUsrId(userId);
						} else {
						
							//INV_AR_ISS_SND INSERT
							invEmlSendNoVO.setCustEml("");
							invEmlSendNoVO.setOfcCd(issOptionVO.getIssOfcCd());
							invEmlSendNoVO.setEmlSndNo("");
							dbDao.createSendNo(issMainVOs[i].getInvNo(), "P", invEmlSendNoVO, userId);
						}
					}
					
					issueCnt++;
				}				
			
			}			
			return String.valueOf(issueCnt);
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00025",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00025",new String[]{}).getMessage(), ex);
		}
	}
    
    /**
	 * 입력한 B/L 에 대한 북중국지역의 Invoice 발행대상을 조회한다.<br>
	 * @author Dong Hoon Han
	 * @param String blNo
	 * @param String ofcCd
	 * @param String curCd
	 * @param String userId
	 * @return List<CHNIssuedInvoiceListVO>
	 * @exception EventException
	 */			
	public List<CHNIssuedInvoiceListVO> searchCHNInvoiceForIssue(String blNo, String ofcCd, String curCd, String userId) throws EventException {
		
		List<CHNIssuedInvoiceListVO> list = null;
		try {
			//usd,cny,uds/cny 조회
			list = dbDao.searchCHNInvoiceForIssue(blNo, ofcCd, curCd);
			
			return list;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}			
	}
	
	/**
	 * 입력한 B/L 에 대한 북중국지역의 Invoice 발행대상을 조회한다.<br>
	 * @author Dong Hoon Han
	 * @param CHNIssuedInvoiceListVO[] chnInv
	 * @param String ofcCd
	 * @param String curCd
	 * @param String userId
	 * @return List<String>
	 * @exception EventException
	 */			
	public List<String> issueCHNInvoice(CHNIssuedInvoiceListVO[] chnInv, String ofcCd, String curCd, String userId) throws EventException {
		
		//List<CHNIssuedInvoiceListVO> list = null;
		List<String> list = new ArrayList<String>(); 
		InvIssMainVO issMainVo = new InvIssMainVO();
		InvoiceNumberVO invNumVo = new InvoiceNumberVO();
		//IssueEachTargetVO issueEachTargetVO = new IssueEachTargetVO();
		String invNo = "";	
		String currCd = "";
		InvEmlVO invEmlSendNoVO = new InvEmlVO();
		try {
			for (int i = 0; i < chnInv.length; i++) {
				//inv_no 추출
				invNumVo = dbDao.searchInvoiceNumber(ofcCd, "", userId);
				invNo = invNumVo.getInvNo();
				list.add(invNo);
				//max값 업데이트
				dbDao.modifyInvoiceNumber(invNumVo.getInvPfxCd(), invNumVo.getInvMaxSeq(), userId);
				
				if(curCd.equals("ALL")){
					currCd = chnInv[i].getCurrCd();
				}else{
					currCd = "";
				}
				
				//INV_AR_ISS_DTL 인서트
				dbDao.createIssueDetail( chnInv[i].getBlSrcNo() , ofcCd , chnInv[i].getArIfNo() , userId , invNo, currCd);
				issMainVo.setInvNo(invNo);
				issMainVo.setIssOfcCd(ofcCd);
				issMainVo.setInvIssRmk("");
				issMainVo.setCreUsrId(userId);
				//INV_AR_ISS 인서트
				dbDao.createIssueMain(issMainVo);
				
				//INV_AR_ISS_SND INSERT
				invEmlSendNoVO.setCustEml("");
				invEmlSendNoVO.setOfcCd(ofcCd);
				invEmlSendNoVO.setEmlSndNo("");
				dbDao.createSendNo(invNo, "P", invEmlSendNoVO, userId);
			}
			return list;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}			
	}

	/**
	 * 입력한 B/L 에 대한 북중국지역의 Invoice 재발행대상을 조회한다.<br>
	 * @author Dong Hoon Han
	 * @param String blNo
	 * @param String ofcCd
	 * @param String curCd
	 * @return List<CHNReissuedInvoiceListVO>
	 * @exception EventException
	 */			
	public List<CHNReissuedInvoiceListVO> searchCHNInvoiceForReissue (String blNo , String ofcCd, String curCd ) throws EventException {
		List<CHNReissuedInvoiceListVO> list = null;
		try {
			list = dbDao.searchCHNInvoiceForReissue(blNo, ofcCd, curCd);
			return list;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}			
	}
	
	/**
	 * 입력한 B/L 에 대한 북중국지역의 Invoice 재발행대상을 저장한다.<br>
	 * @author Dong Hoon Han
	 * @param CHNReissuedInvoiceListVO[] chnInv
	 * @param String userId
	 * @exception EventException
	 */	
	public void reissueCHNInvoice(CHNReissuedInvoiceListVO[] chnInv, String userId) throws EventException {		
		//List<CHNReissuedInvoiceListVO> insertVoList = new ArrayList<CHNReissuedInvoiceListVO>();
		InvEmlVO invEmlSendNoVO = new InvEmlVO();
		try {			
			if(null != chnInv){
				for ( int i=0; i<chnInv.length; i++ ) {
					InvIssMainVO issMainVo = new InvIssMainVO();
					issMainVo.setInvNo(chnInv[i].getInvNo());
					issMainVo.setIssOfcCd(chnInv[i].getArOfcCd());
					issMainVo.setInvIssRmk("");
					issMainVo.setCreUsrId(userId);
					dbDao.createIssueMain(issMainVo );
					
					//INV_AR_ISS_SND INSERT
					invEmlSendNoVO.setCustEml("");
					invEmlSendNoVO.setOfcCd(chnInv[i].getArOfcCd());
					invEmlSendNoVO.setEmlSndNo("");
					dbDao.createSendNo(chnInv[i].getInvNo(), "P", invEmlSendNoVO, userId);
				}
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), de);
		}
	}
    
	/**
	 * Invoice 발행할 대상 Data를 조회한다. <br>
	 * 
	 * @param GeneralInvoiceVO genInvVo
	 * @return List<IssueTargetVO>
	 * @exception EventException
	 */	
	public List<IssueTargetVO> searchTargetBLForIssue(GeneralInvoiceVO genInvVo) throws EventException {
		List<IssueTargetVO> list = null;
		//log.info("########## genInvVo.getBlNos() : "+genInvVo.getBlNos());
		try {
			list = dbDao.searchTargetBLForIssue(genInvVo);	
			return list;
	    } catch(DAOException ex) {
	    	log.error("err " + ex.toString(), ex);
	    	throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 구주지역, 서남아 일부지역, 남중국지역의 Invoice 를 발행함. <br>
	 * 
	 * @param IssueTargetVO issTgtVo
	 * @param GeneralInvoiceVO genInvVo
	 * @param String userId
	 * @return List<IssueTargetVO>
	 * @exception EventException
	 */	
	public List<IssueTargetVO> issueGeneralInvoice(IssueTargetVO issTgtVo, GeneralInvoiceVO genInvVo, String userId) throws EventException {
		List<IssueEachTargetVO> list2 = null;
		String invNo = "";
		String dueDt = "";
		String issDt = "";
		InvIssMainVO issMainVo = new InvIssMainVO();
		MdmCrCustVO mdmCrCustVo = new MdmCrCustVO();
		InvoiceNumberVO invNumVo = new InvoiceNumberVO();
		String ofcCd = genInvVo.getLoginOfcCd();
		//String svrId = genInvVo.getSvrId();
		String otsSmryCd = genInvVo.getOtsSmryCd();
		
		log.info("\n########## otsSmryCd : "+otsSmryCd);
		try {
					
			// Invoice No 채번
			invNumVo = dbDao.searchInvoiceNumber(ofcCd, issTgtVo.getIoBndCd(), userId);
			invNo = invNumVo.getInvNo();
			
			log.info("\n########## invNo : "+invNo);
			
			dbDao.modifyInvoiceNumber(invNumVo.getInvPfxCd(), invNumVo.getInvMaxSeq(), userId);
			
			issMainVo.setInvNo(invNo);
			issMainVo.setIssOfcCd(ofcCd);		
			//issMainVo.setInvIssRmk(issTgtVo.getInvRmk());
			issMainVo.setCreUsrId(userId);
			
			// Issue Data 생성
			dbDao.createIssueMain(issMainVo);	
				
			// 업데이트할 대상 Interface No 조회
			List<IssueTargetVO> list = dbDao.searchInterfaceNumberList(genInvVo, issTgtVo); 			
						
			for (int i = 0; i < list.size(); i++) {
				
				log.info("\n########## list.get("+String.valueOf(i)+").getArIfNo()_2 : "+list.get(i).getArIfNo());
				
				// Issue Detail 생성 대상  조회
				list2 = dbDao.searchEachTargetForIssue(list.get(i).getArIfNo());				
				
				for (int j = 0; j < list2.size(); j++) {
					// Issue Detail Data 생성
					log.info("\n########## invNo2 : "+invNo);
					dbDao.createInvoiceMapping(invNo, list2.get(j), userId);				
				}
					
				issDt = dbDao.searchIssDate(invNo);
				
				// 구주인 경우
				//if (svrId.equals("EUR")) {
				if (otsSmryCd.equals("INV")) {	
					
					//log.info("\n########## list.get(i).getRevTpCd() : "+list.get(i).getRevTpCd());
					log.info("\n########## list.get(i).getTrspRqstOrdFlg() : "+list.get(i).getTrspRqstOrdFlg());
					
					//(REV_TYP = 'M' 또는 TRO_MK = 'Y') 인 경우
					if(list.get(i).getRevTpCd().equals("M") || list.get(i).getTrspRqstOrdFlg().equals("Y")) {
					
						dueDt = dbDao.searchDueDateByCustomer(list.get(i), ofcCd, issDt);
						log.info("\n########## dueDt1 : "+dueDt);
						if (dueDt.equals("")){
							dueDt = dbDao.searchDueDateByOffice(list.get(i), ofcCd);  
							log.info("\n########## dueDt2 : "+dueDt);
						}		
						
					//(REV_TYP = 'M' 또는 TRO_MK = 'Y') 아닌 경우	
					} else {
						
						mdmCrCustVo = dbDao.searchPaymentDateByCustomer(list.get(i).getActCustCntCd(), list.get(i).getActCustSeq());
						
						dueDt = dbDao.searchDueDateByDivCd (list.get(i), issDt, ofcCd);
						log.info("\n########## dueDt3 : "+dueDt);
	
						if (dueDt.equals("")){
							dueDt = dbDao.searchDueDateByOffice(list.get(i), ofcCd);  
							log.info("\n########## dueDt4 : "+dueDt);
						}		
						
						if (mdmCrCustVo.getPayDtDy1() != null) { 
							if (!mdmCrCustVo.getPayDtDy1().equals("") && mdmCrCustVo.getCrFlg().equals("Y")){
								dueDt = dbDao.searchDueDateByPaymentDate(list.get(i), dueDt);	
								log.info("\n########## dueDt5 : "+dueDt);
								
							}		
						}
					}				
					
				// 구주가 아닌 경우	
				} else {
					
					dueDt = dbDao.searchDueDateByCustomer(list.get(i), ofcCd, issDt);
					if (dueDt.equals("")){
						dueDt = dbDao.searchDueDateByOffice(list.get(i), ofcCd);  
					}				
					
				}			
				
				//log.info("########## invNo : "+invNo);
				//log.info("########## dueDt : "+dueDt);
				list.get(i).setInvNo(invNo);
				list.get(i).setDueDt(dueDt);				
						
			}
			
			return list;
			
	    } catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}

	}
	
	/**
	 * e-mail, FAX를 전송한다. <br>
	 * 
	 * @param InvIssMainVO[] issMainVOs
	 * @param IssueOptionVO issOptionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void sendGeneralInvoiceByFaxEmail(InvIssMainVO[] issMainVOs, IssueOptionVO issOptionVO, SignOnUserAccount account) throws EventException {
		try {	
			eaiDao.sendGeneralInvoiceByFaxEmail(issMainVOs, issOptionVO, account);	
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}	
	
    /**
	 * CPRT(Customer Preferable Report)에서  한개 이상의 Report ID 로 생성내역을 조회한다.<br>
	 * @author Dong Hoon Han
	 * @param CPRTListVO cprIdVo
	 * @return List<CPRTMainVO>
	 * @exception EventException
	 */		
	public List<CPRTMainVO> searchCPRTHistoryList(CPRTListVO cprIdVo) throws EventException {
		List<CPRTMainVO> list = null;
		//log.info("########## genInvVo.getBlNos() : "+genInvVo.getBlNos());
		try {
			list = dbDao.searchCPRTHistoryList(cprIdVo);	
			return list;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}			
	}
	
	/**
	 * CPRT(Customer Preferable Report) 조회조건에 해당하는  Report ID 를 조회한다.<br>
	 * @author Dong Hoon Han
	 * @param CPRIDListInputVO cprsearchVo
	 * @return List<CPRTListVO>
	 * @exception EventException
	 */	
	public List<CPRTListVO> searchCPRTIDList(CPRIDListInputVO cprsearchVo) throws EventException {
		List<CPRTListVO> list = null;
		//log.info("########## genInvVo.getBlNos() : "+genInvVo.getBlNos());
		try {
			list = dbDao.searchCPRTIDList(cprsearchVo);	
			return list;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}			
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * 한국지역 Invoice 정보를 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param String invNo
	 * @param String ofcCd
	 * @return KORInvoiceVO
	 * @exception EventException
	 */
	public KORInvoiceVO searchKORInvoice (String invNo, String ofcCd) throws EventException {
		try {
			KORInvoiceVO korInvoiceVO = dbDao.searchKORIssuedCustomer(invNo, ofcCd);
			
			if (korInvoiceVO != null) {
				List<KORInvoiceBLListVO> korInvoiceBLListVO = dbDao.searchKORIssuedBLList(invNo, ofcCd);
				List<InvArKrIssChgVO> invArKrIssChgVO = dbDao.searchKORIssuedChargeList(invNo, ofcCd);
				
				korInvoiceVO.setKorInvoiceBLListVO(korInvoiceBLListVO);
				korInvoiceVO.setInvArKrIssChgVO(invArKrIssChgVO);
			}

			return korInvoiceVO;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * 입력한 B/L 에 대한 정보를 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param String blNo
	 * @param String ofcCd
	 * @return KORInvoiceVO
	 * @exception EventException
	 */
	public KORInvoiceVO searchKORIssueTargetByBL (String blNo, String ofcCd) throws EventException {
		try {
			KORInvoiceVO korInvoiceVO = dbDao.searchKORIssueTargetByBL(blNo, ofcCd);
			
			if (korInvoiceVO != null) {
				String arOfcCd = korInvoiceVO.getArOfcCd();
				
				List<KORInvoiceBLListVO> korInvoiceBLListVO = dbDao.searchKORIssueTargetBL(blNo, arOfcCd);
				List<InvArKrIssChgVO> invArKrIssChgVO = dbDao.searchKORIssueTargetChargeList(blNo, arOfcCd);
				
				korInvoiceVO.setKorInvoiceBLListVO(korInvoiceBLListVO);
				korInvoiceVO.setInvArKrIssChgVO(invArKrIssChgVO);
			}

			return korInvoiceVO;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Bank 의 계좌번호를 조회한다.<br>
	 * @author Dong Hoon Han
	 * @param String ofcCd
	 * @param String currCd
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchBankAccount(String ofcCd, String currCd) throws EventException {
		List<String> resultVOs = null;
		try {
			resultVOs = dbDao.searchBankAccount(ofcCd, currCd);	
			return resultVOs;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}			
	}	
	
	/**
	 * Issue 이벤트 처리<br>
	 * 한국지역 Invoice 를 발행한다.<br>
	 * 
	 * @author JungJin Park
	 * @param KORInvoiceVO korInvVo
	 * @return String
	 * @exception EventException
	 */
	public String issueKORInvoice (KORInvoiceVO korInvVo) throws EventException {
		try {
			InvoiceNumberVO invNumVo = new InvoiceNumberVO();
			
			String invNo = "";
			String arOfcCd = korInvVo.getArOfcCd();
			String ioBndCd = "";
			String userId = korInvVo.getCreUsrId();
			
			if (korInvVo != null && !userId.equals("")) {
				//invoice No 조회
				invNumVo = dbDao.searchInvoiceNumber(arOfcCd, ioBndCd, userId);
				invNo = invNumVo.getInvNo();
				dbDao.modifyInvoiceNumber(invNumVo.getInvPfxCd(), invNumVo.getInvMaxSeq(), userId);
				
				korInvVo.setInvNo(invNo);
				
				//INV_AR_KR_ISS 입력
				dbDao.addKORIssueMain(korInvVo);
				
				List<KORInvoiceBLListVO> korInvoiceBLList = korInvVo.getKorInvoiceBLListVO();
				List<InvArKrIssChgVO> invArKrIssChgList = korInvVo.getInvArKrIssChgVO();
				
				for(int i=0; i<korInvoiceBLList.size(); i++) {
					for(int j=0; j<invArKrIssChgList.size(); j++) {
						InvArKrIssChgVO invArKrIssChgVO = invArKrIssChgList.get(j);
						
						invArKrIssChgVO.setInvNo(invNo);
						invArKrIssChgVO.setChgSeq(String.valueOf(j+1));
						invArKrIssChgVO.setCreUsrId(userId);
						invArKrIssChgVO.setUpdUsrId(userId);
					}
				}
				
				//INV_AR_KR_ISS_CHG 입력
				dbDao.addKORIssueCharge(korInvVo);
			}
			
			return invNo;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
		
	/**
	 * ReIssue 이벤트 처리<br>
	 * 한국지역 Invoice 를 재발행한다.<br>
	 * 
	 * @author JungJin Park
	 * @param KORInvoiceVO korInvVo
	 * @return String
	 * @exception EventException
	 */
	public String reissueKORInvoice (KORInvoiceVO korInvVo) throws EventException {
		try {
			String userId = korInvVo.getCreUsrId();
			String invNo = korInvVo.getInvNo();
			
			if (korInvVo != null && !userId.equals("")) {
				//INV_AR_KR_ISS 입력
				dbDao.addKORIssueMain(korInvVo);
				
				List<KORInvoiceBLListVO> korInvoiceBLList = korInvVo.getKorInvoiceBLListVO();
				List<InvArKrIssChgVO> invArKrIssChgList = korInvVo.getInvArKrIssChgVO();
				
				for(int i=0; i<korInvoiceBLList.size(); i++) {
					for(int j=0; j<invArKrIssChgList.size(); j++) {
						InvArKrIssChgVO invArKrIssChgVO = invArKrIssChgList.get(j);
						
						invArKrIssChgVO.setInvNo(invNo);
						invArKrIssChgVO.setChgSeq(String.valueOf(j+1));
						invArKrIssChgVO.setCreUsrId(userId);
						invArKrIssChgVO.setUpdUsrId(userId);
					}
				}
				
				//INV_AR_KR_ISS_CHG 입력
				dbDao.addKORIssueCharge(korInvVo);
			}
			
			return invNo;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * CPR(Customer Preferable Report)에서 사용. user 가 사용가능한 Template List 를 가져온다.<br>
	 * @author Dong Hoon Han
	 * @param String userId
	 * @param String ofc
	 * @return List<TemplateVO>
	 * @exception EventException
	 */		
	public List<TemplateVO> searchTemplateList(String userId, String ofc) throws EventException {
		List<TemplateVO> list = null;
		try {
			list = dbDao.searchTemplateList(userId, ofc);	
			return list;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * CPR(Customer Preferable Report)에서 사용.  조건 Template name 으로 저장된 Item들을 조회한다.<br>
	 * @author Dong Hoon Han
	 * @param String tmplate
	 * @param CPRTInputVO cprInputVo
	 * @return List<TemplateItemVO>
	 * @exception EventException
	 */		
	public List<TemplateItemVO> searchTemplateItemList(String tmplate,CPRTInputVO cprInputVo) throws EventException {
		List<TemplateItemVO> list = null;
		log.debug("BC===========================================");
		log.debug("----start-------tmplate-----------arOfcCd--------------------------------");
		log.debug(tmplate);
		log.debug("cprInputVo.getarOfcCd()>>>>>>>>>>>>>>>>>>>>>>>>"+cprInputVo.getArOfcCd());
		log.debug("cprInputVo.getScNo()>>>>>>>>>>>>>>>>>>>>>>>>"+cprInputVo.getScNo());
		log.debug("--- end----------tmplate-----------arOfcCd-------------------");
		try {
			list = dbDao.searchTemplateItemList(tmplate,cprInputVo);	
			return list;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * CPRT(Customer Preferable Report) 생성 대상 내용을 BKG 정보에서 조회해 온다.<br>
	 * @author Dong Hoon Han
	 * @param CPRTInputVO cprInputVo
	 * @param String rptItmId
	 * @return TemplateVO
	 * @exception EventException
	 */		
	public List<CPRTInvoiceVO> searchCPRTInvoice(CPRTInputVO cprInputVo, String rptItmId) throws EventException {
//	public TemplateVO searchCPRTInvoice(CPRTInputVO cprInputVo, String rptItmId) throws EventException {
//		TemplateVO templateVO = new TemplateVO();
		List<CPRTInvoiceVO> listCPRTInvoiceVO = null;
		String bl_nos = cprInputVo.getBlNos();	

		try {
			if (!bl_nos.equals("")){
			    listCPRTInvoiceVO = dbDao.searchCPRTByBL(cprInputVo, rptItmId);
			    log.debug("======================bl_nos================================");
			}else {
				listCPRTInvoiceVO = dbDao.searchCPRTInvoice(cprInputVo, rptItmId);
				log.debug("=====================not bl_nos================================");
			}
			return listCPRTInvoiceVO;
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			if (ex.toString().contains("ORA-01013")) {
				throw new EventException(new ErrorHandler("COM12244", new String[]{}).getMessage(), ex);
			} else {
				throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
			}
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
	
	}
	
	/**
	 * CPRT(Customer Preferable Report) Report ID를 생성한다.<br>
	 * @author Dong Hoon Han
	 * @param String custNm
	 * @param CPRTInputVO cprInputVo
	 * @return String
	 * @exception EventException
	 */		
	public String issueCPRTInvoice(String custNm, CPRTInputVO cprInputVo) throws EventException {
		//CPRTMainVO cPRTMainVO = new CPRTMainVO();
		
		String reportId = "";
		try {
			if(cprInputVo != null){
				reportId = dbDao.searchMaxReporID(custNm, cprInputVo.getArOfcCd());
				//log.info("reportId===========>>>>>"+reportId);
				dbDao.addCPRTHistory(reportId, cprInputVo);
			}
			return reportId;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * 조회 이벤트 처리<br>
	 * Terminal Invoice 의 GIRO 정보를 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param String blNo
	 * @param String ofcCd
	 * @return KORGiroListVO
	 * @exception EventException
	 */
	public KORGiroListVO searchKORGIRO (String blNo, String ofcCd) throws EventException {
		KORGiroListVO korGiroListVO = new KORGiroListVO();
		List<InvArGiroVO> invArGiroList = null;
		try {
			korGiroListVO = dbDao.searchGIROMain(blNo, ofcCd);
			
			if (korGiroListVO != null) {
				invArGiroList = dbDao.searchGIROAmtList(blNo, ofcCd);
				
				korGiroListVO.setInvArGiroVO(invArGiroList);
			}
			
			return korGiroListVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		}
	}
	
	/**
	 * Terminal Invoice 의 생성된 GIRO 정보를 생성, 갱신, 삭제한다.<br>
	 * 
	 * @author JungJin Park
	 * @param List<InvArGiroVO> invArGiros
	 * @exception EventException
	 */		
	public void manageKORGIRO (List<InvArGiroVO> invArGiros) throws EventException {
		List<InvArGiroVO> insInvArGiroList = new ArrayList<InvArGiroVO>();
		List<InvArGiroVO> updInvArGiroList = new ArrayList<InvArGiroVO>();
		List<InvArGiroVO> delInvArGiroList = new ArrayList<InvArGiroVO>();
		try {
			for (int i = 0; i < invArGiros.size(); i++) {
				InvArGiroVO invArGiroVO = (InvArGiroVO) invArGiros.get(i);
				
				if(invArGiroVO.getIbflag().equals("I")) {
					insInvArGiroList.add(invArGiroVO);
				}
				else if(invArGiroVO.getIbflag().equals("U")) {
					updInvArGiroList.add(invArGiroVO);
				}
				else if(invArGiroVO.getIbflag().equals("D")) {
					delInvArGiroList.add(invArGiroVO);
				}
			}
				
			if (insInvArGiroList.size() > 0) {
				dbDao.createKORGIRO(insInvArGiroList);
			}
			if (updInvArGiroList.size() > 0) {
				dbDao.modifyKORGIRO(updInvArGiroList);
			}
			if (delInvArGiroList.size() > 0) {
				dbDao.removeKORGIRO(delInvArGiroList);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		}
	}
	

	/**
	 * Terminal Invoice 의 생성된 GIRO 정보를 삭제한다.<br>
	 * 
	 * @author JungJin Park
	 * @param List<InvArGiroVO> invArGiros
	 * @exception EventException
	 */		
	public void removeKORGIRO (List<InvArGiroVO> invArGiros) throws EventException {
		try {
			if (invArGiros.size() > 0) {
				dbDao.removeKORGIRO(invArGiros);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		}
	}

	/**
	 * Fax, Email 이벤트 처리<br>
	 * 한국지역 Invoice 를 Fax/Email 로 전송한다.<br>
	 * 
	 * @author JungJin Park
	 * @param KORInvoiceVO korInvVo
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String sendKORInvoiceByFaxEmail(KORInvoiceVO korInvVo, SignOnUserAccount account) throws EventException {
		InvEmailFaxVO invEmailFaxVO = new InvEmailFaxVO();
		String sndNo = "";
		try {
			if (korInvVo != null && account != null) {
				invEmailFaxVO.setInvNo(korInvVo.getInvNo());
				invEmailFaxVO.setArOfcCd(korInvVo.getArOfcCd());
				invEmailFaxVO.setInvSeq(korInvVo.getInvSeq());
				invEmailFaxVO.setSendFlg(korInvVo.getSendFlg());
				invEmailFaxVO.setSubject(korInvVo.getEmailSubject());
				if (korInvVo.getSendFlg().equals("E")) {
					invEmailFaxVO.setRecipient(korInvVo.getCustEml());
				}
				else {
					invEmailFaxVO.setRecipient(korInvVo.getCustFaxNo());
				}
				invEmailFaxVO.setFileName(korInvVo.getEmailFileName());
				
				// Send Mail
				sndNo = eaiDao.sendKORInvoiceByFaxEmail(invEmailFaxVO, account);

				dbDao.modifyKORIssueMain(korInvVo.getInvNo(), korInvVo.getInvSeq(), sndNo, korInvVo.getSendFlg(), account.getUsr_id());
			}
			
			return sndNo;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * 베트남지역 기 발행된 Invoice 정보를 조회한다.<br>
	 * 
	 * @param InvoiceIssueDateVO vieInvVo
	 * @return List<ARInvoiceListByIFDateVO>
	 * @exception EventException
	 */
	public List<ARInvoiceListByIFDateVO> searchSWAIssuedInvoiceList (InvoiceIssueDateVO vieInvVo) throws EventException {
		try {
			List<ARInvoiceListByIFDateVO> list = dbDao.searchSWAIssuedInvoiceList(vieInvVo);
			return list;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * FNS_INV_0036<br>
	 * 베트남 지역의 Single Invoice 발행대상 B/L 정보를 조회한다.(Max I/F NO 정보를 가져옴)<br>
	 * INV Type별 Charge 조건에 맞는 내요이 chg_amt <> 0 인 대상임<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param GeneralInvoiceVO sinInvVo
	 * @return List<VIEInvoiceTargetVO>
	 * @exception EventException
	 */
	public List<VIEInvoiceTargetVO> searchVIEIssueTargetBLNoList(GeneralInvoiceVO sinInvVo) throws EventException{
		try {
			return dbDao.searchVIEIssueTargetBLNoList(sinInvVo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * FNS_INV_0036<br>
	 * 베트남 지역의 Single Invoice 발행대상 B/L 정보를 조회한다.(Max I/F NO 정보를 가져옴)<br>
	 * INV Type별 Charge 조건에 맞는 내요이 chg_amt <> 0 인 대상임<br>
	 * 
	 * @param GeneralInvoiceVO sinInvVo
	 * @return String
	 * @exception EventException
	 */
	public String searchVIEIssueTargetCheckCharge(GeneralInvoiceVO sinInvVo) throws EventException{
		try {
			return dbDao.searchVIEIssueTargetCheckCharge(sinInvVo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * FNS_INV_0036<br>
	 * 베트남 지역 매출채권 정보를 Invoice 발행한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param GeneralInvoiceVO sinInvVo
	 * @return List<IssueEachTargetVO>
	 * @exception EventException
	 */
	public List<IssueEachTargetVO> issueVIESingleInvoice(GeneralInvoiceVO sinInvVo) throws EventException{
		String invPrefix = "";
		String invNo = "";
		List<IssueEachTargetVO> issueEachTargetVO = null;

		try {
			if(sinInvVo.getInvType().equals("FRT")) {
				invPrefix = "F";
			} else if(sinInvVo.getInvType().equals("THC")) {
				invPrefix = "T";
			} else if(sinInvVo.getInvType().equals("DHF")) {
				invPrefix = "H";
			} else if(sinInvVo.getInvType().equals("DMR")) {
				invPrefix = "D";
			} else if(sinInvVo.getInvType().equals("MNR")) {
				invPrefix = "R";
			} else if(sinInvVo.getInvType().equals("MRI")) {
				invPrefix = "M";
			} else if(sinInvVo.getInvType().equals("SLF")) {
				invPrefix = "S";
			} else if(sinInvVo.getInvType().equals("CLN")) {
				invPrefix = "C";
				
			//2010-07-19 TYPE REF 추가	
			} else if(sinInvVo.getInvType().equals("REF")) {
				invPrefix = "E";
			//2011-11-19 TYPE ETC 추가	
			} else if(sinInvVo.getInvType().equals("ETC")) {
				invPrefix = "X";
			}
			
			log.error("------------------->>>>>>>>>>>>0_1");
			invNo = dbDao.searchVIEInvoiceNumber(invPrefix, sinInvVo.getArOfcCd());
			if(invNo.equals("") || invNo == null) {
				dbDao.addVIEInvoiceNumber(invPrefix, sinInvVo.getArOfcCd(), sinInvVo.getUserId());
				invNo = dbDao.searchVIEInvoiceNumber(invPrefix, sinInvVo.getArOfcCd());
			}
			log.error("------------------->>>>>>>>>>>>0_3");
			dbDao.modifyVIEInvoiceNumber(invPrefix, invNo.substring(6,9), sinInvVo.getArOfcCd(), sinInvVo.getUserId());
			log.error("------------------->>>>>>>>>>>>0_4");
			issueEachTargetVO = dbDao.searchVIEIssueTargetByBLNo(sinInvVo.getBlNo(), sinInvVo.getInvType(), invNo, sinInvVo.getArOfcCd());
			log.error("------------------->>>>>>>>>>>>0_5");
			return issueEachTargetVO;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * FNS_INV_0036<br>
	 * 베트남 지역에서 Issue시 Issue Table에 정보를 반영한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param IssueEachTargetVO issEachTargetVO
	 * @param String userId
	 * @exception EventException
	 */
	public void createVIEInvoice(IssueEachTargetVO issEachTargetVO, String userId) throws EventException {
		try {
			dbDao.createInvoiceMapping(issEachTargetVO.getInvNo(), issEachTargetVO, userId);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getUserMessage(), ex);
		}
	}
	
	/**
	 * FNS_INV_0036<br>
	 * 베트남 지역에서 Issue시 Issue Table에 정보를 반영한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param String invNo
	 * @param String cmbFlg
	 * @param VIEDailyExrateVO vIEDailyExrateVO
	 * @param String userId
	 * @exception EventException
	 */
	public void createVIEIssueMain(String invNo, String cmbFlg, VIEDailyExrateVO vIEDailyExrateVO, String userId) throws EventException {
		createVIEIssueMain( invNo,  cmbFlg,  vIEDailyExrateVO,  userId, null);
	}
	
	/**
	 * FNS_INV_0036<br>
	 * 베트남 지역에서 Issue시 Issue Table에 정보를 반영한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param String invNo
	 * @param String cmbFlg
	 * @param VIEDailyExrateVO vIEDailyExrateVO
	 * @param String userId
	 * @param String vnInvPayMzdCd
	 * @exception EventException
	 */
	public void createVIEIssueMain(String invNo, String cmbFlg, VIEDailyExrateVO vIEDailyExrateVO, String userId, String vnInvPayMzdCd) throws EventException {
		InvIssMainVO issMainVO = new InvIssMainVO();
		
		try {
			issMainVO.setInvNo(invNo);
			issMainVO.setIssOfcCd(vIEDailyExrateVO.getOfcCd());
			issMainVO.setCreUsrId(userId);
			issMainVO.setInvIssCmbFlg(cmbFlg);
			issMainVO.setInvXchRtDt(vIEDailyExrateVO.getXchRtDt());
			issMainVO.setUsdXchRt(vIEDailyExrateVO.getXchRt());
			
			// [CHM-201111084] 베트남 지역 인보이스 로직 변경 요청건
			if (vnInvPayMzdCd != null && !vnInvPayMzdCd.equals("")){
				issMainVO.setVnInvPayMzdCd(vnInvPayMzdCd);
			} 
			
			dbDao.createIssueMain(issMainVO);			
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getUserMessage(), ex);
		}
	}

	/**
	 * FNS_INV_0036<br>
	 * 베트남 지역의 Invoice 발행시 적용 환율을 구한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param VIEDailyExrateVO vieDailyExrateVO
	 * @return VIEDailyExrateReturnVO
	 * @exception EventException
	 */
	public VIEDailyExrateReturnVO searchVIEDailyExrate(VIEDailyExrateVO vIEDailyExrateVO) throws EventException{
		try {
			return dbDao.searchVIEDailyExrate(vIEDailyExrateVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 베트남 지역에서 실제 사용하는 Actual Invoice Number 를 Invoice 정보에 반영한다.<br>
	 * 
	 * @author JungJin Park
	 * @param List<VIEActInvoiceVO> vieActInvoiceVOs
	 * @exception EventException
	 */		
	public void createVIEActualInvoiceNumber (List<VIEActInvoiceVO> vieActInvoiceVOs ) throws EventException {
		try {
			if (vieActInvoiceVOs.size() > 0) {
				dbDao.createVIEActualInvoiceNumber(vieActInvoiceVOs);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		}
	}
	
	/**
	 * FNS_INV_0088<br>
	 * 베트남 지역의 Combine Invoice 발행대상 B/L 및 금액정보를 조회한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param GeneralInvoiceVO sinInvVo
	 * @return List<VIECombineInvoiceVO>
	 * @exception EventException
	 */
	public List<VIECombineInvoiceVO> searchVIECombineBLNoList(GeneralInvoiceVO sinInvVo) throws EventException{
		try {
			return dbDao.searchVIECombineBLNoList(sinInvVo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * BackEndJob 으로 Invoice 를 발행한다. <br>
	 * 
	 * @param GeneralInvoiceVO genInvVo
	 * @param String userId
	 * @return String
	 * @exception EventException
	 */	
	@SuppressWarnings("unused")
	public String issueGeneralInvoiceBackEndJobKey(GeneralInvoiceVO genInvVo, String userId) throws EventException{
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		InvoiceIssueBackEndJob command = new InvoiceIssueBackEndJob();
		String backEndJobKey = "";
		try {			
			//String ofc = genInvVo.getArOfcCd();
			//String ofcCd = genInvVo.getArOfcCd2();
			InvoiceNumberVO invNumVo = new InvoiceNumberVO();
			if(invNumVo == null){
				throw new EventException(new ErrorHandler("INV00113", new String[] {}).getMessage());
			}
			
			command.setGenInvVo(genInvVo);
			command.setUserId(userId);

            backEndJobKey = backEndJobManager.execute(command, userId, "FNS_INV_0034_01");

			return backEndJobKey;	
		} catch (EventException ex) {	
			log.error("errBc0=============>> " + ex.toString(), ex);
			throw ex;	
			/*
		} catch (DAOException ex) {
			log.error("errBc1=============>> " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);*/
		} catch (Exception ex) {
			log.error("errBc2=============>> " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
	}
	
	
	/**
	 * Invoice 를 발행하기 위한 BackEndJob의 LoadFile함수를 통해 결과를 조회한다.<br>
	 * 
	 * @param String key
	 * @return InvoiceIssueSndToErpVO
	 * @exception EventException
	 */
	public InvoiceIssueSndToErpVO getBackEndJobResutIssueGeneralInvoice(String key) throws EventException {
		try {
			//InvoiceIssueEAIDAO eaiDao = new InvoiceIssueEAIDAO();
			return eaiDao.getBackEndJobResutIssueGeneralInvoice(key);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage());
		}
	}

	/**
	 * FNS_INV_0088<br>
	 * 베트남 지역의 Invoice 발행시 INV NO를 구한다.<br>
	 *
	 * @author Choi Woo-Seok
	 * @param String invType
	 * @param String ofcCd
	 * @param String userId
	 * @return String
	 * @exception EventException
	 */
	public String searchVIEInvoiceNumber(String invType, String ofcCd, String userId) throws EventException{
		String invPrefix = "";
		String invNo = "";
		
		try {
			if(invType.equals("FRT")) {
				invPrefix = "F";
			} else if(invType.equals("THC")) {
				invPrefix = "T";
			} else if(invType.equals("DHF")) {
				invPrefix = "H";
			} else if(invType.equals("DMR")) {
				invPrefix = "D";
			} else if(invType.equals("MNR")) {
				invPrefix = "R";
			} else if(invType.equals("MRI")) {
				invPrefix = "M";
			} else if(invType.equals("SLF")) {
				invPrefix = "S";
			} else if(invType.equals("CLN")) {
				invPrefix = "C";
			
			//2010-07-21 TYPE REF 추가	
			} else if(invType.equals("REF")) {
				invPrefix = "E";
			//2011-11-19 TYPE REF 추가	
			} else if(invType.equals("ETC")) {
				invPrefix = "X";
			}
			
			invNo = dbDao.searchVIEInvoiceNumber(invPrefix, ofcCd);
			if(invNo.equals("") || invNo == null) {
				dbDao.addVIEInvoiceNumber(invPrefix, ofcCd, userId);
				invNo = dbDao.searchVIEInvoiceNumber(invPrefix, ofcCd);
			}
			dbDao.modifyVIEInvoiceNumber(invPrefix, invNo.substring(6,9), ofcCd, userId);

			return invNo;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * FNS_INV_0088<br>
	 * 베트남 지역 매출채권 정보를 Combine 하여 한 Invoice 로 발행한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param VIECombineInvoiceVO vIECombineInvoiceVO
	 * @return List<IssueEachTargetVO>
	 * @exception EventException
	 */
	public List<IssueEachTargetVO> issueVIECombinedInvoice(VIECombineInvoiceVO vIECombineInvoiceVO) throws EventException{
		List<IssueEachTargetVO> issueEachTargetVO = null;
		try {
			issueEachTargetVO = dbDao.searchVIEIssueTargetByBLNo(vIECombineInvoiceVO.getBlNo(), vIECombineInvoiceVO.getInvType(), vIECombineInvoiceVO.getInvNo(), vIECombineInvoiceVO.getArOfcCd());
			return issueEachTargetVO;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Invoice 비발행 대상 Data를 조회한다. <br>
	 * 
	 * @param GeneralInvoiceVO genInvVo
	 * @return List<String>
	 * @exception EventException
	 */	
	public List<String> searchErrorBLNumberList(GeneralInvoiceVO genInvVo) throws EventException {
		List<String> list = null;
		//log.info("########## genInvVo.getBlNos() : "+genInvVo.getBlNos());
		try {
			list = dbDao.searchErrorBLNumberList(genInvVo);	
			return list;
	    } catch(DAOException ex) {
	    	log.error("err " + ex.toString(), ex);
	    	throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Invoice 기발행 Data를 조회한다. <br>
	 * 
	 * @param GeneralInvoiceVO genInvVo
	 * @return HashMap<String, Object>
	 * @exception EventException
	 */	
	public HashMap<String, Object> searchAlreadyIssuedList(GeneralInvoiceVO genInvVo) throws EventException {
		HashMap<String, Object> result	= new HashMap<String, Object>();
		
		List<String> list = null;

		try {
			String ofcCd = genInvVo.getArOfcCd2();
			
			SetupOfficeVO setupOfficeVO = new SetupOfficeVO();

			setupOfficeVO = dbDao.searchSetupOfficeForIssue(ofcCd);
			
			String dupYN	= setupOfficeVO.getInvDupFlg();
			
			if(("Y").equals(dupYN)){
				list = dbDao.searchAlreadyIssuedList(genInvVo);
			}
				
			result.put("blNoList", list);
			result.put("dupYN", dupYN);
			
			return result;
			
	    } catch(DAOException ex) {
	    	log.error("err " + ex.toString(), ex);
	    	throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * FNS_INV_0088<br>
	 * B/L 대상 Select<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param VIECombineInvoiceVO[] vIECombineInvoiceVOs
	 * @return List<VIECombineInvoiceVO>
	 * @exception EventException
	 */
	public List<VIECombineInvoiceVO> searchVIECombineTargetBLNoList(VIECombineInvoiceVO[] vIECombineInvoiceVOs) throws EventException{
		try {
			return dbDao.searchVIECombineTargetBLNoList(vIECombineInvoiceVOs);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Issue 이벤트 처리<br>
	 * 한국지역 Invoice 를 발행한다.<br>
	 * 
	 * @author JungJin Park
	 * @param KORInvoiceVO korInvVo
	 * @return KORInvoiceVO
	 * @exception EventException
	 */
	public KORInvoiceVO printKORInvoice (KORInvoiceVO korInvVo) throws EventException {
		//InvEmlVO invEmlSendNoVO = new InvEmlVO();
		//InvIssMainVO issMainVo = new InvIssMainVO();
		try {
			InvoiceNumberVO invNumVo = new InvoiceNumberVO();

			String invNo = "";
			String invPfxCd = "";
			String invSeq = "";
			String invMaxseq = "";
			String arOfcCd = korInvVo.getArOfcCd();
			String ioBndCd = "";
			String userId = korInvVo.getCreUsrId();
			
			if (korInvVo != null && !userId.equals("")) {
				//INV No가 없는 경우
				if (korInvVo.getInvNo().equals("")) {
					//invoice No 조회
					invNumVo = dbDao.searchInvoiceNumber(arOfcCd, ioBndCd, userId);	

					invNo = invNumVo.getInvNo();					
					if(invNo == null || invNo.equals("")){
						invMaxseq = "1";
						invPfxCd = arOfcCd.substring(0,2);
						dbDao.modifyInvoiceNumber(invPfxCd, invMaxseq, userId);
						invNumVo = dbDao.searchInvoiceNumber(arOfcCd, ioBndCd, userId);	
					}else{
						invMaxseq = invNumVo.getInvMaxSeq();
						invPfxCd = invNumVo.getInvPfxCd();
						dbDao.modifyInvoiceNumber(invPfxCd, invMaxseq, userId);
					}
					invNo = invNumVo.getInvNo();
					invSeq = "1";
					
					korInvVo.setInvNo(invNo);
					korInvVo.setInvSeq(invSeq);
				}
				else {
					invNo = korInvVo.getInvNo();
					invSeq = dbDao.searchKORInvoiceNumber(korInvVo.getInvNo());
					
					korInvVo.setInvSeq(invSeq);
				}
				log.error("userId------------------------>>>>>>>>>>>>>>>"+userId);
				//INV_AR_KR_ISS 입력
				dbDao.addKORIssueMain(korInvVo);
				
				List<KORInvoiceBLListVO> korInvoiceBLList = korInvVo.getKorInvoiceBLListVO();
				List<InvArKrIssChgVO> invArKrIssChgList = korInvVo.getInvArKrIssChgVO();
				log.error("korInvoiceBLList.size()------------------------>>>>>>>>>>>>>>>"+korInvoiceBLList.size());
				log.error("invArKrIssChgList.size()------------------------>>>>>>>>>>>>>>>"+invArKrIssChgList.size());				
				for(int i=0; i<korInvoiceBLList.size(); i++) {
					log.error("korInvoiceBLList.get(i).getBlSrcNo()------------------------>>>>>>>>>>>>>>>"+korInvoiceBLList.get(i).getBlSrcNo());
					for(int j=0; j<invArKrIssChgList.size(); j++) {
						InvArKrIssChgVO invArKrIssChgVO = invArKrIssChgList.get(j);
						
						if (korInvoiceBLList.get(i).getBlSrcNo().equals(invArKrIssChgList.get(j).getBlSrcNo())) {
							invArKrIssChgVO.setInvNo(invNo);
							invArKrIssChgVO.setInvSeq(invSeq);
							invArKrIssChgVO.setChgSeq(String.valueOf(j+1));
							
							invArKrIssChgVO.setBkgNo(korInvoiceBLList.get(i).getBkgNo());
							if (korInvoiceBLList.get(i).getIoBndCd().equals("O/B")) {
								invArKrIssChgVO.setIoBndCd("O");
							}
							else {
								invArKrIssChgVO.setIoBndCd("I");	
							}
							invArKrIssChgVO.setBkgNo(korInvoiceBLList.get(i).getBkgNo());
							invArKrIssChgVO.setVslCd(korInvoiceBLList.get(i).getVvd().substring(0, 4));
							invArKrIssChgVO.setSkdVoyNo(korInvoiceBLList.get(i).getVvd().substring(4, 8));
							invArKrIssChgVO.setSkdDirCd(korInvoiceBLList.get(i).getVvd().substring(8, 9));
							invArKrIssChgVO.setSailArrDt(korInvoiceBLList.get(i).getSailArrDt());
							invArKrIssChgVO.setPolCd(korInvoiceBLList.get(i).getPolCd());
							invArKrIssChgVO.setPodCd(korInvoiceBLList.get(i).getPodCd());
							invArKrIssChgVO.setCreUsrId(userId);
							invArKrIssChgVO.setUpdUsrId(userId);
						}
					}
				}
				
				//INV_AR_KR_ISS_CHG 입력
				if(korInvoiceBLList.size() > 0 && invArKrIssChgList.size() > 0){
					dbDao.addKORIssueCharge(korInvVo);
				}
				
				/*
				//INV_AR_ISS_DTL 인서트
				dbDao.createIssueDetail( chnInv[i].getBlSrcNo() , arOfcCd , chnInv[i].getArIfNo() , userId , invNo, currCd);
				issMainVo.setInvNo(invNo);
				issMainVo.setIssOfcCd(arOfcCd);
				issMainVo.setInvIssRmk("");
				issMainVo.setCreUsrId(userId);
				//INV_AR_ISS 인서트
				dbDao.createIssueMain(issMainVo);
				*/
				
				//INV_AR_ISS_SND INSERT
				/*
				invEmlSendNoVO.setCustEml("");
				invEmlSendNoVO.setOfcCd(arOfcCd);
				invEmlSendNoVO.setEmlSndNo("");
				dbDao.createSendNo(invNo, "P", invEmlSendNoVO, userId);
				*/
			}
			
			return korInvVo;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Invoice Number를 채번한다. <br>
	 * 
	 * @param String ofcCd
	 * @param String bnd
	 * @param String userId
	 * @return InvoiceNumberVO
	 * @exception DAOException
	 */
	public InvoiceNumberVO searchInvoiceNumber(String ofcCd, String bnd, String userId) throws EventException{
		try {
			return dbDao.searchInvoiceNumber(ofcCd, bnd, userId);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Invoice Number채번 Table의 max_seq 값을 변경한다. <br>
	 * 
	 * @param String invPfxCd
	 * @param String invMaxSeq
	 * @param String userId
	 * @exception DAOException
	 */
	public void modifyInvoiceNumber(String invPfxCd, String invMaxSeq, String userId) throws EventException{
		try {
			 dbDao.modifyInvoiceNumber(invPfxCd, invMaxSeq, userId);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 동일 INVOICE NO를 반영할 대상 INTERFACE NO를 구한다. <br>
	 * 
	 * @param GeneralInvoiceVO genInvVo
	 * @param IssueTargetVO issTgtVo
	 * @return List<IssueTargetVO>
	 * @exception DAOException
	 */
	public List<IssueTargetVO> searchInterfaceNumberList(GeneralInvoiceVO genInvVo, IssueTargetVO issTgtVo) throws EventException{
		try {
			return dbDao.searchInterfaceNumberList(genInvVo, issTgtVo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Invoice Detail Table 에 저장할 대상 Data를 조회한다. <br>
	 * 
	 * @param String arIfNo
	 * @return List<IssueEachTargetVO>
	 * @exception DAOException
	 */
	public List<IssueEachTargetVO> searchEachTargetForIssue(String arIfNo) throws EventException{
		try {
			return dbDao.searchEachTargetForIssue(arIfNo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Invoice Detail 정보를 생성한다. <br>
	 * 
	 * @param String invNo
	 * @param IssueEachTargetVO issEachTgtVo
	 * @param String userId
	 * @exception DAOException
	 */
	public void createInvoiceMapping(String invNo, IssueEachTargetVO issEachTgtVo, String userId) throws EventException {
		try {
			dbDao.createInvoiceMapping(invNo, issEachTgtVo, userId);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		}
	}
	
	/**
	 * Invoice issue 실행한다. <br>
	 * 
	 * @author Dong Hoon Han
	 * @param GeneralInvoiceVO genInvVo
	 * @return InvIssVO
	 * @exception DAOException
	 */
	public InvIssVO manageIssueTargetMgt(GeneralInvoiceVO genInvVo) throws EventException{
		try {
			String ofcCd = genInvVo.getArOfcCd2();
			String userId = genInvVo.getUserId();
			String issueType = genInvVo.getIssueType();	//DXBSC - INV NO 채번시 사용
			String emailFlag = genInvVo.getEmailFlag();
			String revType = genInvVo.getRevType();
			String autoInvIssFlg = "Y".equals(genInvVo.getAutoInvIssFlg()) ? "Y" : "N";
			String indIssTpCd = genInvVo.getIndIssTpCd();		//2017.07.20 인도 GST 세법 변경 관련 보완
			String loginOfcCd = genInvVo.getLoginOfcCd();		//2017.07.20 인도 GST 세법 변경 관련 보완
			InvoiceNumberVO invNumVo = new InvoiceNumberVO();
			SetupOfficeVO setupOfficeVO = new SetupOfficeVO();
			log.error("bl_src_no------------------------->>>>>>>>>>>>>>>"+genInvVo.getBlNo());
			log.error("bl_src_nos------------------------->>>>>>>>>>>>>>>"+genInvVo.getBlNos());
			//A/R Setup Office 테이블에서 Select(INV_MLT_BL_ISS_FLG, INV_DUP_FLG, OTS_SMRY_CD, INV_ISS_TP_CD)
			setupOfficeVO = dbDao.searchSetupOfficeForIssue(ofcCd);
			String invMltBlIssFlg = setupOfficeVO.getInvMltBlIssFlg();
			String invDupFlg = setupOfficeVO.getInvDupFlg();
			String otsSmryCd = setupOfficeVO.getOtsSmryCd();			
			String invIssTpCd = setupOfficeVO.getInvIssTpCd();
			
			//2017.07.20 인도 GST 세법 변경 관련 보완
			if(("BOMSC").equals(ofcCd)) {
				if(("P").equals(indIssTpCd) || ("T").equals(indIssTpCd)) {
					invDupFlg = "Y";
					invIssTpCd = "S";
				} else if (("C").equals(indIssTpCd) || ("D").equals(indIssTpCd)) {
					invDupFlg = "N";
					invIssTpCd = "S";
				}
				
				genInvVo.setInvDupFlg(invDupFlg);
			}
			
			//if(invDupFlg == null) invDupFlg = "N";
			//if(otsSmryCd == null) otsSmryCd = "AA";
			//if(invIssTpCd == null) invIssTpCd = "S";
			
			//WRK NO 채번
			if(("BOMSC").equals(ofcCd)) {
				invNumVo = dbDao.searchINDInvoiceMaxSequence(loginOfcCd, indIssTpCd);	//2017.07.20 인도 GST 세법 변경 관련 보완
			} else {
				invNumVo = dbDao.searchInvoiceMaxSequence(ofcCd, userId, autoInvIssFlg);
			}
			
			String wrkNo = invNumVo.getWrkNo();
			String invPfxCd = invNumVo.getInvPfxCd();
			String invMaxSeq = invNumVo.getInvMaxSeq();
			String issDt = invNumVo.getIssDt();						
			
			//inv_ar_iss_ftr 에서 work 존재여부 체크
			String wrkNoCnt = dbDao.searchInvIssWorkNumber(wrkNo);
			
			if(!wrkNoCnt.equals("0")){
				//NextVal
				dbDao.searchIssNoNextval();
			}
			
			
			genInvVo.setWrkNo(wrkNo);
			InvIssVO invIssVO = new InvIssVO();
			invIssVO.setIssDt(issDt);
			invIssVO.setOfcCd(ofcCd);
			invIssVO.setUserId(userId);
			invIssVO.setInvPfxCd(invPfxCd);
			invIssVO.setInvMaxSeq(invMaxSeq);
			invIssVO.setWrkNo(wrkNo);
			invIssVO.setInvMltBlIssFlg(invMltBlIssFlg);
			invIssVO.setInvDupFlg(invDupFlg);
			invIssVO.setOtsSmryCd(otsSmryCd);
			invIssVO.setInvIssTpCd(invIssTpCd);
			invIssVO.setIssueType(issueType);
			invIssVO.setEmailFlag(emailFlag);
			invIssVO.setRevType(revType);
			invIssVO.setAutoInvIssFlg(autoInvIssFlg);
			
			//2017.07.20 인도 GST 세법 변경 관련 보완
			invIssVO.setIndIssTpCd(indIssTpCd);
			invIssVO.setLoginOfcCd(loginOfcCd);
			
			String invSeq = "";

			//ISSUE TEMP 테이블 INSERT
			if(invDupFlg.equals("Y")){
				dbDao.addInvoiceIssueFilterForDup(genInvVo);
			}else{
				dbDao.addInvoiceIssueFilter(genInvVo);
			}
			log.error("------------------------->>>>>>>>>>>>>>>1");
			if(invDupFlg.equals("Y")){	
				//ISSUE TEMP 테이블 DELETE
				//dbDao.removeInvoiceIssueFilterForDup(genInvVo);
				//INV_AR_ISS 테이블 INSERT			
				invSeq = dbDao.addInvoiceIssueForDup(invIssVO);
			}else if(invDupFlg.equals("N")){					
				//INV_AR_ISS 테이블 INSERT			
				invSeq = dbDao.addInvoiceIssue(invIssVO);
			}
			log.error("------------------------->>>>>>>>>>>>>>>2");
			
			log.error("invSeq==========>>>"+invSeq);
			invIssVO.setInvSeq(invSeq);
			if(!ofcCd.equals("VLCSC") && !ofcCd.equals("LEHSC")){
				//채번테이블 UPDATE
				if(("BOMSC").equals(ofcCd)) {
					dbDao.modifyINDInvMaxSeq(invPfxCd, invMaxSeq, invSeq, userId, loginOfcCd);		//2017.07.20 인도 GST 세법 변경 관련 보완
				} else {
					dbDao.modifyInvMaxSeq(invPfxCd, invMaxSeq, invSeq, userId);
				}
			}
			
			return invIssVO;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * INV_AR_ISS_DTL 테이블 INSERT 한다. <br>
	 * 
	 * @author Dong Hoon Han
	 * @param InvIssVO invIssVO
	 * @exception DAOException
	 */
	public void addInvoiceIssueDetail(InvIssVO invIssVO) throws EventException{
		try {				
			dbDao.addInvoiceIssueDetail(invIssVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * ISSUE TEMP 테이블 DELETE 한다. <br>
	 * 
	 * @author Dong Hoon Han
	 * @param InvIssVO invIssVO
	 * @return List<String>
	 * @exception DAOException
	 */
	public List<String> removeInvoiceIssueFilter(InvIssVO invIssVO) throws EventException{
		//List<String> resultVOs = null;
		List<String> resultVOs = new ArrayList<String>();
		InvEmlVO invEmlSendNoVO = new InvEmlVO();
		try {	
			//INV_NO 조회
			//resultVOs = dbDao.searchFilterInvoiceNumber(invIssVO);
			//if no 조회
			List<String> ifNoList = new ArrayList<String>();	
			String wrkNo = invIssVO.getWrkNo();
			ifNoList = dbDao.searchInterfaceNumberForERP(wrkNo);
			log.error("ifNoList------------------------->>>>>>>>>>>>>>>"+ifNoList);
			//ISSUE TEMP 테이블 DELETE
			//임시 주석처리함 2010.08.31 Filter Table Sequence 주기 문제로 주석해제
			dbDao.removeInvoiceIssueFilter(invIssVO);
			
			String ofcCd = invIssVO.getOfcCd();
			String invPfxCd = invIssVO.getInvPfxCd();
			String invMaxSeq = invIssVO.getInvMaxSeq();
			String invSeq = invIssVO.getInvSeq();
			String userId = invIssVO.getUserId();
			String issueType = invIssVO.getIssueType();
			if(ofcCd.equals("VLCSC") || ofcCd.equals("LEHSC")){
				//채번테이블 UPDATE
				dbDao.modifyInvMaxSeq(invPfxCd, invMaxSeq, invSeq, userId);
			}
			
			//INV_NO 조회			
			int invMaxSeqI = Integer.parseInt(invMaxSeq);
			String invNo = "";

			for(int i=1; i<=Integer.parseInt(invSeq); i++){
				if(ofcCd.equals("DXBSC")){
					//invNo = invPfxCd+issueType+invLpad(Integer.toString(invMaxSeqI+i),6,"0");
					invNo = invPfxCd+issueType+JSPUtil.getLPAD(Integer.toString(invMaxSeqI+i), 6, "0");
				}else{
					//invNo = invPfxCd+invLpad(Integer.toString(invMaxSeqI+i),7,"0");
					invNo = invPfxCd+JSPUtil.getLPAD(Integer.toString(invMaxSeqI+i),7,"0");
				}
				
				//INV_AR_ISS_SND INSERT				
				if(invIssVO.getEmailFlag().equals("N")){
					invEmlSendNoVO.setCustEml("");
					invEmlSendNoVO.setOfcCd(ofcCd);
					invEmlSendNoVO.setEmlSndNo("");
					dbDao.createSendNo(invNo, "P", invEmlSendNoVO, userId);
				}
				
				resultVOs.add(invNo);				
			}
			
			//interface 전송
			BookingARCreationBC command2 = new BookingARCreationBCImpl();
			List<InvArIfNoVO> ifNos = new ArrayList<InvArIfNoVO>();
			InvArIfNoVO invArIfNoVO = new InvArIfNoVO();
			
			String ifNo = "";
			// New Data 생성
			for(int k=0; k<ifNoList.size(); k++){
				ifNo = ifNoList.get(k);
				if(!ifNo.equals("")){
					invArIfNoVO = new InvArIfNoVO();
					invArIfNoVO.setIfNo(ifNo);
					ifNos.add(invArIfNoVO);
				}
			}
						
			String otsSmryCd = invIssVO.getOtsSmryCd();
			if(otsSmryCd.equals("INV") || ofcCd.equals("DXBSC")){
				command2.interfaceARInvoiceToERPAR(ifNos, "U");
			}
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
		return resultVOs;
	}
	
	/**
	 * INVOICE ISSUE시 해당 테이블의 CRUD(SysClear대상제외)  <br>
	 * 
	 * @param InvIssVO invIssVO
	 * @return InvoiceIssueSndToErpVO
	 * @exception EventException
	 */
	public InvoiceIssueSndToErpVO manageArMainForInvoiceIssue(InvIssVO invIssVO) throws EventException{

		InvoiceIssueSndToErpVO returnVo = new InvoiceIssueSndToErpVO();
		List<String> invNoList = new ArrayList<String>();
		InvEmlVO invEmlSendNoVO = new InvEmlVO();
		
		String ofcCd = "";
		String invPfxCd = "";
		String invMaxSeq = "";
		String invSeq = "";
		String userId = "";
		String issueType = "";
		List<String> ifNoList = new ArrayList<String>();	
		
		String workNo = invIssVO.getWrkNo();
	
		try {	
			//if no 조회
			String wrkNo = invIssVO.getWrkNo();
			
			//ISSUE TEMP 테이블 DELETE
			//임시 주석처리함 2010.08.31 Filter Table Sequence 주기 문제로 주석해제

			ofcCd = invIssVO.getOfcCd();
			invPfxCd = invIssVO.getInvPfxCd();
			invMaxSeq = invIssVO.getInvMaxSeq();
			invSeq = invIssVO.getInvSeq();
			userId = invIssVO.getUserId();
			issueType = invIssVO.getIssueType();
			
			returnVo.setOfccd(invIssVO.getOfcCd());
			returnVo.setOtssmrycd(invIssVO.getOtsSmryCd());
			
			if(ofcCd.equals("VLCSC") || ofcCd.equals("LEHSC")){
				//채번테이블 UPDATE
				log.error("36------------------------->>>>>>>>>>>>>>>");
				dbDao.modifyInvMaxSeq(invPfxCd, invMaxSeq, invSeq, userId);
				log.error("36 end------------------------->>>>>>>>>>>>>>>");
			}
			
			//INV_NO 조회			
			int invMaxSeqI = Integer.parseInt(invMaxSeq);
			String invNo = "";
			
			log.error("37 invSeq------------------------->>>>>>>>>>>>>>>"+invSeq);
			for(int i=1; i<=Integer.parseInt(invSeq); i++){
				if(ofcCd.equals("DXBSC")){
					invNo = invPfxCd+issueType+JSPUtil.getLPAD(Integer.toString(invMaxSeqI+i), 6, "0");
				}else if(ofcCd.equals("BOMSC")){		//2017.07.20 인도 GST 세법 변경 관련 보완
					invNo = invPfxCd+JSPUtil.getLPAD(Integer.toString(invMaxSeqI+i),6,"0");
				}else{
					invNo = invPfxCd+JSPUtil.getLPAD(Integer.toString(invMaxSeqI+i),7,"0");
				}
				
				//INV_AR_ISS_SND INSERT				
				if(invIssVO.getEmailFlag().equals("N")){
					invEmlSendNoVO.setCustEml("");
					invEmlSendNoVO.setOfcCd(ofcCd);
					invEmlSendNoVO.setEmlSndNo("");
					dbDao.createSendNo(invNo, "P", invEmlSendNoVO, userId);
					
				}
				
				invNoList.add(invNo);				
			}
			
			returnVo.setInvnos(invNoList);

			// SYS Clear된 대상을 찾는다.
			int sysClearCnt = dbDao.checkInvoiceIssueFilterForSysClear(workNo);

			// SYS Clear된 대상은 이전 데이타로 원복시킨다.
			if (sysClearCnt > 0) {

				dbDao.removeInvArIssSndForSysClear(workNo);
				dbDao.removeInvArIssForSysClear(workNo);
				dbDao.removeInvArIssDtlForSysClear(workNo);
				dbDao.removeInvoiceIssueFilterForSysClear(workNo);
			}
			
			// CMBSC인 경우 INV_AR_SPND_VAT_RGST_NO 에서 CUSTOMER CODE RGST NO가 존재하는 확인
			// 존재시  INV_AR_SPND_VAT_RGST_SEQ OBJECT에서 채번후  INV_AR_ISS 테이블 SPND_VAT_RGST_SEQ 컬럼 업데이트
			// 조건은 INVOICE NO 별, SEQ = 1에 대해 업데이트 한다.
			if (ofcCd.equals("CMBSC")) {
				dbDao.modifySpndVatRgstSeq(workNo,ofcCd);
			}

			ifNoList = dbDao.searchInterfaceNumberForERP(wrkNo);
			returnVo.setIfnolist(ifNoList);
			
			dbDao.removeInvoiceIssueFilter(invIssVO);
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
		return returnVo;
	}
	
	
	/**
	 * ERP에 전송한다. <br>
	 * 
	 * @param InvoiceIssueSndToErpVO invoiceIssueSndToErpVO
	 * @exception EventException
	 */
	public void interfaceARInvoiceToERPAR(InvoiceIssueSndToErpVO invoiceIssueSndToErpVO)throws EventException {
		
		List<String> ifNoList = invoiceIssueSndToErpVO.getIfnolist();	
		
		String ofcCd = invoiceIssueSndToErpVO.getOfccd();
		
		//interface 전송
		BookingARCreationBC command2 = new BookingARCreationBCImpl();
		List<InvArIfNoVO> ifNos = new ArrayList<InvArIfNoVO>();
		InvArIfNoVO invArIfNoVO = new InvArIfNoVO();
		
		String ifNo = "";
		StringBuffer ifNoStr = new StringBuffer();
		// New Data 생성
		for(int k=0; k<ifNoList.size(); k++){
			ifNo = ifNoList.get(k);
			if(!ifNo.equals("")){
				invArIfNoVO = new InvArIfNoVO();
				invArIfNoVO.setIfNo(ifNo);
				ifNos.add(invArIfNoVO);
				ifNoStr.append(ifNo);
				ifNoStr.append("  ");
			}
		}
		
		try {
			String otsSmryCd = invoiceIssueSndToErpVO.getOtssmrycd();
			
			log.error("[[otsSmryCd ="+otsSmryCd);
			if(otsSmryCd.equals("INV") || ofcCd.equals("DXBSC")|| ofcCd.equals("PKGSC") ){
			
				// ifNoList 로그출력
				log.error("[[InvoiceIssueBCImpl@interfaceARInvoiceToERPAR IF_NO ="+ifNoStr);
				command2.interfaceARInvoiceToERPAR(ifNos, "U");
			}		
		}  catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
		
	}
	
	/**
     * lpad 함수
     *
     * @param String str
     * @param int len
     * @param String addStr
     * @return String
     */
/* 2010.11.04 JSPUtil의 공통함수 사용으로 주석처리
    public static String invLpad(String str, int len, String addStr) {
        String result = str;
        int templen   = len - result.length();

        for (int i = 0; i < templen; i++){
              result = addStr + result;
        }
        
        return result;
    }
*/	
	/**
	 * Other Revenue 에서 입력한 내용의  Invoice 를 발행한다. <br>
	 * 
	 * @param InvIssMainVO invCreVo
	 * @param List<IssueEachTargetVO> issEachTgtVOs
	 * @param String ofcCd
	 * @param String userId
	 * @return String
	 * @throws EventException
	 */
	public String issueOtherRevInvoice (InvIssMainVO invCreVo, List<IssueEachTargetVO> issEachTgtVOs, String ofcCd, String userId) throws EventException {
		try {
			InvoiceNumberVO invNumVo = new InvoiceNumberVO();
			String invNo = "";
			
			//invoice No 조회
			invNumVo = dbDao.searchInvoiceNumber(ofcCd, "O", userId);
			invNo = invNumVo.getInvNo();
			
			dbDao.modifyInvoiceNumber(invNumVo.getInvPfxCd(), invNumVo.getInvMaxSeq(), userId);
			
			invCreVo.setInvNo(invNumVo.getInvNo());
			invCreVo.setIssOfcCd(ofcCd);
			invCreVo.setCreUsrId(userId);
			
			dbDao.createIssueMain(invCreVo);

			for (int j = 0; j < issEachTgtVOs.size(); j++) {
				dbDao.createInvoiceMapping(invNo, issEachTgtVOs.get(j), userId);
			}
			
			return invNo;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * CPR 에서 bl preview 조회시 bkg_no가 없을 경우, 조회한다. <br>
	 * @author Dong Hoon Han
	 * @param String blNo
	 * @return String
	 * @throws EventException
	 */
	public String searchBlNo(String blNo) throws EventException {
		try {			
			String bkgNo = dbDao.searchBlNo(blNo);
			return bkgNo;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * INV_AR_ISS_SND insert한다. <br>
	 * @author Dong Hoon Han
	 * @param String invNo
	 * @param String sndTp
	 * @param InvEmlVO invEmlSendNoVO
	 * @param String usrId
	 * @throws EventException
	 */
	public void createSendNo(String invNo, String sndTp, InvEmlVO invEmlSendNoVO, String usrId) throws EventException {
		try {			
			dbDao.createSendNo(invNo, sndTp, invEmlSendNoVO, usrId);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * VAT Charge를 검색한다. <br>
	 * @param GeneralInvoiceVO vo
	 * @return List<String>
	 * @throws EventException
	 */	
	public List<String> searchVIEVATCharge(GeneralInvoiceVO vo) throws EventException {
		List<String> list = new ArrayList<String>();
		try {			
			list = dbDao.searchVIEVATCharge(vo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
		
		return list;	
	}
	
	/**
	 * Eur Email Server로부터 들어온 EDI Message를 table에 저장
	 * 
	 * @param String rcvMsg
	 * @param String userId
	 * @param String integrationId
	 * @exception EventException
	 */
	public void receiveEdiFromEurEmailServer(String rcvMsg, String userId, String integrationId) throws EventException {
		
		List<InvArIssSndVO> invArIssSndVOs = new ArrayList<InvArIssSndVO>();
		invArIssSndVOs = makeEurEmailServerFlatFile(rcvMsg,userId,integrationId);
		
		try {
			if (invArIssSndVOs != null && invArIssSndVOs.size() > 0){ 
				for (InvArIssSndVO invArIssSndVO : invArIssSndVOs) {
					log.error(">EurEmailServer EDI Message NO>>>>>>>>>>>>>>>>>>"+invArIssSndVO.getInvSndCustNo()+"<<<<<<<<<<<<<<<<<<<<<<<<");
					dbDao.modifyInvArIssSnd(invArIssSndVO);
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * EurEmailServer로부터 들어온 EDI Message 수신
	 * @param rcvMsg
	 * @param userId
	 * @param integrationId
	 * @return List<InvArIssSndVO>
	 * @throws EventException
	 */
	private List<InvArIssSndVO> makeEurEmailServerFlatFile(String rcvMsg, String userId, String integrationId) throws EventException{
		
		List<InvArIssSndVO> list = new ArrayList<InvArIssSndVO>();
		
		try {
			String[] rcvMsgs = rcvMsg.split("\n");
			int rcvMsgLines = rcvMsgs.length;
			String[] tempEntity;

			InvArIssSndVO invArIssSndVO = new InvArIssSndVO();

			for (int i = 0; i < rcvMsgLines; i++) {

				// message start부분은 그대로 찍는다.
				if (i == 0) {
					// log.debug(rcvMsgs[i]);
					continue;
				}

				// 시작
				if (rcvMsgs[i].startsWith("{ACK_BEGIN")) {
					invArIssSndVO = new InvArIssSndVO();
					continue;
				}
				
				tempEntity = rcvMsgs[i].split(":");

				if (tempEntity == null || tempEntity.length == 0)
					continue;
				
				if (tempEntity.length > 1) {

					// Header
					tempEntity[0] = (tempEntity[0] == null ? "" : tempEntity[0].trim()+ "");
					// Item
					tempEntity[1] = (tempEntity[1] == null ? "" : tempEntity[1].trim()+ "");

					if ("EML_SND_NO".equals(tempEntity[0])) {
						invArIssSndVO.setInvSndNo(tempEntity[1]);
						log.debug("\nEML_SND_NO:" + tempEntity[1]);
						continue;
					}
					if ("EML_RECEIVER".equals(tempEntity[0])) {
						// EDI에는 해당항목 있으나 VO에 존재하지않음
						log.debug("\nEML_RECEIVER:" + tempEntity[1]);
						continue;
					}
					if ("SND_RESULT".equals(tempEntity[0])) {
						invArIssSndVO.setEurEmlSndRsltCd(tempEntity[1]);
						log.debug("\nSND_RESULT:" + tempEntity[1]);
						continue;
					}
					if ("ACK_SERVER".equals(tempEntity[0])) {
						invArIssSndVO.setAckSvrCd(tempEntity[1]);
						log.debug("\nACK_SERVER:" + tempEntity[1]);
						continue;
					}
					if ("ERR_DESC".equals(tempEntity[0])) {
						invArIssSndVO.setErrDesc(tempEntity[1]);
						log.debug("\nERR_DESC:" + tempEntity[1]);
						continue;
					}
					if ("ACK_DT".equals(tempEntity[0])) {
						invArIssSndVO.setSndDt(tempEntity[1]);
						log.debug("\nACK_DT:" + tempEntity[1]);
						continue;
					}
					if ("ACK_DT_GMT".equals(tempEntity[0])) {
						// EDI에는 해당항목 있으나 VO에 존재하지않음
						log.debug("\nACK_DT_GMT:" + tempEntity[1]);
						continue;
					}
				} else if (rcvMsgs[i].startsWith("}ACK_END")) {
					// block의 끝이면
					log.debug("}ACK_END");
					invArIssSndVO.setUpdUsrId(userId);
					list.add(invArIssSndVO);
					continue;
				}
			}
			return list;			
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		}
	}
	
	/**
     * @param vo
     * @return
     * @throws EventException
     */
	public List<InvArEmlCustRgstVO> searchEmlCustRgst(InvArEmlCustRgstVO vo)throws EventException{
		List<InvArEmlCustRgstVO> list = new ArrayList<InvArEmlCustRgstVO>();
		try{
			list = dbDao.searchEmlCustRgst(vo);
		}catch(DAOException ex){
			log.error((new StringBuilder("err ")).append(ex.toString()).toString(), ex);
			throw new EventException((new ErrorHandler("COM12240", new String[0])).getMessage(), ex);
		}catch(Exception ex){
			log.error((new StringBuilder("err ")).append(ex.toString()).toString(), ex);
			throw new EventException((new ErrorHandler("COM12240", new String[0])).getMessage(), ex);
		}
		return list;
	}

	
    /**
     * @param vos
     * @throws EventException
     */
	public void manageEmlCustRgst(List<InvArEmlCustRgstVO> vos)throws EventException{
		List<InvArEmlCustRgstVO> insInvArEmlCustRgstVOList = new ArrayList<InvArEmlCustRgstVO>();
		List<InvArEmlCustRgstVO> updInvArEmlCustRgstVOList = new ArrayList<InvArEmlCustRgstVO>();
		List<InvArEmlCustRgstVO> delInvArEmlCustRgstVOList = new ArrayList<InvArEmlCustRgstVO>();
		try{
			for(int i = 0; i < vos.size(); i++){
				InvArEmlCustRgstVO invArEmlCustRgstVO = (InvArEmlCustRgstVO)vos.get(i);
				if(invArEmlCustRgstVO.getIbflag().equals("I"))
					insInvArEmlCustRgstVOList.add(invArEmlCustRgstVO);
				else
					if(invArEmlCustRgstVO.getIbflag().equals("U"))
						updInvArEmlCustRgstVOList.add(invArEmlCustRgstVO);
					else
						if(invArEmlCustRgstVO.getIbflag().equals("D"))
							delInvArEmlCustRgstVOList.add(invArEmlCustRgstVO);
			}

			if(insInvArEmlCustRgstVOList.size() > 0)
				dbDao.createEmlCustRgst(insInvArEmlCustRgstVOList);
			if(updInvArEmlCustRgstVOList.size() > 0)
				dbDao.modifyEmlCustRgst(updInvArEmlCustRgstVOList);
			if(delInvArEmlCustRgstVOList.size() > 0)
				dbDao.removeEmlCustRgst(delInvArEmlCustRgstVOList);
		}catch(DAOException ex){
			throw new EventException((new ErrorHandler("COM12240", new String[0])).getUserMessage(), ex);
		}catch(Exception ex){
			throw new EventException((new ErrorHandler("COM12240", new String[0])).getUserMessage(), ex);
		}
	}

    /**
     * @param ofcCd
     * @return
     * @throws EventException
     */
	public String searchOfcOpt(String ofcCd)throws EventException{
		String ofcOpt = "";
		try {
			ofcOpt = dbDao.searchOfcOpt(ofcCd);
			return ofcOpt;
		}catch(DAOException de){
			log.error((new StringBuilder("err ")).append(de.toString()).toString(), de);
			throw new EventException((new ErrorHandler("COM12240", new String[0])).getMessage(), de);
		}catch(Exception ex){
			log.error((new StringBuilder("err ")).append(ex.toString()).toString(), ex);
			throw new EventException((new ErrorHandler("COM12240", new String[0])).getMessage(), ex);
		}
	}

    /**
     * @param invArSplitIssVO
     * @param invArSplitIssChgVOs
     * @param ofcCd
     * @param usrId
     * @param loginOfcCd
     * @return
     * @throws EventException
     */
	public String splitARInvoiceByBL(InvArSplitIssVO invArSplitIssVO, List<InvArSplitIssChgVO> invArSplitIssChgVOs, String ofcCd, String usrId, String loginOfcCd)throws EventException{
		try	{
			InvoiceNumberVO invNumVo = new InvoiceNumberVO();
			String invNo = "";
			String invSeq = "1";
			String indIssTpCd = "";
			
			// 2018.05.16 인도지역 Split Invoice Issue 기능 보완
			if(("BOMSC").equals(ofcCd)){
				
				BigDecimal invTtlLoclAmt = new BigDecimal("0");
				
				int cnt = dbDao.searchTaxInvIssCnt(ofcCd, invArSplitIssVO.getBlSrcNo());
				
				if(invArSplitIssChgVOs != null){
				    for (InvArSplitIssChgVO chgVo : invArSplitIssChgVOs) {
				        BigDecimal chgAmt = new BigDecimal(chgVo.getChgAmt());
				        BigDecimal exRate = new BigDecimal(chgVo.getInvXchRt());
				        invTtlLoclAmt = invTtlLoclAmt.add(chgAmt.multiply(exRate).setScale(2,BigDecimal.ROUND_HALF_UP));
				    }
				}
				
				if(cnt == 0) {
				    indIssTpCd = "T";
				} else {
				    if(invTtlLoclAmt.compareTo(new BigDecimal("0")) >= 0){
				        indIssTpCd = "D";
				    } else {
				        indIssTpCd = "C";
				    }
				}
			
				invNumVo = dbDao.searchINDInvoiceNumber(loginOfcCd, indIssTpCd);
				dbDao.modifyINDInvMaxSeq(invNumVo.getInvPfxCd(), invNumVo.getInvMaxSeq(), invSeq, usrId, loginOfcCd);
			
			} else {
				invNumVo = dbDao.searchInvoiceNumber(ofcCd, "O", usrId);
				dbDao.modifyInvoiceNumber(invNumVo.getInvPfxCd(), invNumVo.getInvMaxSeq(), usrId);
			}
			
			invNo = invNumVo.getInvNo();
			
			invArSplitIssVO.setInvNo(invNo);
			invArSplitIssVO.setInvSeq(invSeq);
			invArSplitIssVO.setArOfcCd(ofcCd);
			invArSplitIssVO.setIdaIssTpCd(indIssTpCd);		// 2018.05.16 인도지역 Split Invoice Issue 기능 보완
			invArSplitIssVO.setIdaIssOfcCd(loginOfcCd);		// 2018.05.16 인도지역 Split Invoice Issue 기능 보완
			dbDao.addInvoiceSplitIssue(invArSplitIssVO, usrId);
			if(invArSplitIssChgVOs != null){
				for (InvArSplitIssChgVO vo : invArSplitIssChgVOs) {
					vo.setInvNo(invNo);
					vo.setInvSeq(invSeq);
					vo.setArOfficeCd(ofcCd); 		// 2018.05.16 인도지역 Split Invoice Issue 기능 보완
					dbDao.addInvoiceSplitIssueCharge(vo, usrId);
				}
				
				// 2018.05.16 인도지역 Split Invoice Issue 기능 보완
				if(("BOMSC").equals(ofcCd)){
					dbDao.modifyIDAGstRto(invNo, invSeq, invArSplitIssVO.getArIfNo());
					dbDao.modifyIDAGstAmt(invNo, invSeq);
				}
			}
			return invNo;
		}catch(EventException ex){
			throw ex;
		}catch(DAOException ex){
			throw new EventException((new ErrorHandler("INV00080", new String[0])).getMessage(), ex);
		}catch(Exception ex){
			throw new EventException((new ErrorHandler("COM12240", new String[0])).getMessage(), ex);
		}
	}

	
    /**
     * @param invArSplitIssVO
     * @return
     * @throws EventException
     */
	public String searchMaxSplitInvWorkNumber(InvArSplitIssVO invArSplitIssVO)throws EventException{
		try {
			return dbDao.searchMaxSplitInvWorkNumber(invArSplitIssVO);
		}catch(EventException ex){
			throw ex;
		}catch(DAOException ex){
			throw new EventException((new ErrorHandler("INV00080", new String[0])).getMessage(), ex);
		}catch(Exception ex){
			throw new EventException((new ErrorHandler("COM12240", new String[0])).getMessage(), ex);
		}
	}
	
	/**
	 * Invoice No를 입력받은 후 유효한 Invoice No를 Return 해주며 INV_AR_ISS에 Re-issue 이력을 저장해 준다. <br>
	 * 
	 * @param PrintInvoiceVO prtInvoiceVo
	 * @return List<InvIssMainVO>
	 * @exception EventException
	 */
	public List<InvIssMainVO> searchPrintSplitInvoice(PrintInvoiceVO prtInvoiceVo) throws EventException {
		List<InvIssMainVO> list = null;
		InvIssMainVO issMain = null;

		InvEmlVO invEmlSendNoVO = new InvEmlVO();
		
		try {
			list =  dbDao.searchPrintSplitInvoice(prtInvoiceVo);
			
			log.info("\n########## prtInvoiceVo.getPrevFlg() : "+prtInvoiceVo.getPrevFlg());
				
			if (!prtInvoiceVo.getPrevFlg().equals("Y")) {
			
				for(int i=0; i<list.size(); i++) {
					issMain = new InvIssMainVO();
					issMain.setInvNo(list.get(i).getInvNo());
					issMain.setIssOfcCd(prtInvoiceVo.getUserOfc());
					issMain.setCreUsrId(prtInvoiceVo.getUserId());
					
					log.info("\n########## prtInvoiceVo.getUserOfc() : "+prtInvoiceVo.getUserOfc());
										
					dbDao.createIssueMain(issMain);		
					
					if (!prtInvoiceVo.getGotoFlg().equals("Y")) {
						
						//INV_AR_ISS_SND INSERT
						invEmlSendNoVO.setCustEml("");
						invEmlSendNoVO.setOfcCd(prtInvoiceVo.getUserOfc());
						invEmlSendNoVO.setEmlSndNo("");
						dbDao.createSendNo(list.get(i).getInvNo(), "P", invEmlSendNoVO, prtInvoiceVo.getUserId());
							
					}
				}
			
			}

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}

		return list;
	}
	
	/**
	 * Issue 대상 Bkg No, Sail Arr Dt, Due Dt 를 가져온다 <br>
	 * 
	 * @param GeneralInvoiceVO genInvVo
	 * @return List<NYCInvoiceVO>
	 * @exception EventException
	 */
	public List<NYCInvoiceVO> searchNYCIssueTarget(GeneralInvoiceVO genInvVo) throws EventException {
		List<NYCInvoiceVO> list = null;
		
		try {
			list =  dbDao.searchNYCIssueTarget(genInvVo);

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}

		return list;
	}
	
	
	/**
	 * Fax, Email 이벤트 처리<br>
	 * 미주지역 Invoice 를 Fax/Email 로 전송한다.<br>
	 * 
	 * @author JungJin Park
	 * @param List<NYCInvoiceVO> nYCInvoiceVOs
	 * @param NYCEmlVO nycEmlVo
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int sendNYCInvoiceByFaxEmail(List<NYCInvoiceVO> nYCInvoiceVOs, NYCEmlVO nycEmlVo, SignOnUserAccount account) throws EventException {
		InvEmailFaxVO invEmailFaxVO = new InvEmailFaxVO();
		int sndNum = 0;
		String bkgNos = "";
			
		try {
			
			log.debug("nYCInvoiceVOs======================"+nYCInvoiceVOs.size());
			
			if (nYCInvoiceVOs != null && account != null) {				
				
				if("P".equals(nycEmlVo.getSendFlag())){
					
					for( int i=0; i < nYCInvoiceVOs.size();  i++){					
						InvArUsaIssSndVO invArUsaIssSndVO = new InvArUsaIssSndVO();
						
						SimpleDateFormat SDformat = new SimpleDateFormat("MM/dd/yyyy");
						SimpleDateFormat SDformat2 = new SimpleDateFormat("yyyyMMdd");
				       
						Date transdate = SDformat.parse(nYCInvoiceVOs.get(i).getSailArrDt()); 				         
				        String transStr = SDformat2.format(transdate);    
						
						invArUsaIssSndVO.setBlSrcNo(nYCInvoiceVOs.get(i).getBlSrcNo());
						invArUsaIssSndVO.setInvIssSndTpCd(nycEmlVo.getSendFlag());
						invArUsaIssSndVO.setInvSndCustNo("");
						invArUsaIssSndVO.setInvSndNo("");
						invArUsaIssSndVO.setArOfcCd(nycEmlVo.getArOfcCd());
						invArUsaIssSndVO.setSailArrDt(transStr);
						invArUsaIssSndVO.setCreUsrId(account.getUsr_id());
						invArUsaIssSndVO.setUpdUsrId(account.getUsr_id());
						
						dbDao.addNYCIssueMain(invArUsaIssSndVO);
					}
					
				} else {
					if("S".equals(nycEmlVo.getMailType())){
						
						for( int i=0; i < nYCInvoiceVOs.size();  i++){						
							
							bkgNos = "'"+nYCInvoiceVOs.get(i).getBkgNo()+"'";							
							
							invEmailFaxVO.setInvNo(bkgNos);
							invEmailFaxVO.setArOfcCd(nycEmlVo.getArOfcCd());
							invEmailFaxVO.setSendFlg(nycEmlVo.getSendFlag());
							invEmailFaxVO.setArgument(nycEmlVo.getStampType());
							invEmailFaxVO.setSubject(nycEmlVo.getEdtSubject());		
							
							StringBuffer contentBuff = new StringBuffer();
							
							contentBuff.append("<table border='0' cellspacing='0' cellpadding='0' width='740' style='width:554.85pt;margin-left:-1.15pt;border-collapse:collapse'>");
							contentBuff.append("	<tr>");
							contentBuff.append("		<td width='252' nowrap='' valign='bottom' style='width:189.35pt;border:solid windowtext 1.0pt;background:#B6DDE8;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>");
							contentBuff.append("			<p><b><span lang='EN-US' style='font-size:8.0pt;color:#1F497D'>Customer Name</span></b></p>");
							contentBuff.append("		</td>");
							contentBuff.append("		<td width='104' nowrap='' valign='bottom' style='width:77.8pt;border:solid windowtext 1.0pt;border-left:none;background:#B6DDE8;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>");
							contentBuff.append("			<p><b><span lang='EN-US' style='font-size:8.0pt;color:#1F497D'>B/L No</span></b></p>");
							contentBuff.append("		</td>");
							contentBuff.append("		<td width='71' nowrap='' valign='bottom' style='width:52.9pt;border:solid windowtext 1.0pt;border-left:none;background:#B6DDE8;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>");
							contentBuff.append("			<p><b><span lang='EN-US' style='font-size:8.0pt;color:#1F497D'>Credit Limit</span></b></p>");
							contentBuff.append("		</td>");
							contentBuff.append("		<td width='84' nowrap='' valign='bottom' style='width:62.75pt;border:solid windowtext 1.0pt;border-left:none;background:#B6DDE8;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>");
							contentBuff.append("			<p><b><span lang='EN-US' style='font-size:8.0pt;color:#1F497D'>S/A Date</span></b></p>");
							contentBuff.append("		</td>");
							contentBuff.append("		<td width='76' nowrap='' valign='bottom' style='width:57.35pt;border:solid windowtext 1.0pt;border-left:none;background:#B6DDE8;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>");
							contentBuff.append("			<p><b><span lang='EN-US' style='font-size:8.0pt;color:#1F497D'>Due Date</span></b></p>");
							contentBuff.append("		</td>");
							contentBuff.append("		<td width='153' nowrap='' valign='bottom' style='width:114.7pt;border:solid windowtext 1.0pt;border-left:none;background:#B6DDE8;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>");
							contentBuff.append("			<p><b><span lang='EN-US' style='font-size:8.0pt;color:#1F497D'>&nbsp; TTL USD </span></b></p>");
							contentBuff.append("		</td>");
							contentBuff.append("	</tr>");
							contentBuff.append("	<tr>");
							contentBuff.append("		<td width='252' nowrap='' valign='bottom' style='width:189.35pt;border:solid windowtext 1.0pt;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>");
							contentBuff.append("			<span lang='EN-US' style='font-size:8.0pt;'>"+ nYCInvoiceVOs.get(i).getCustNm() +"</span>");
							contentBuff.append("		</td>");
							contentBuff.append("		<td width='104' nowrap='' valign='bottom' style='width:77.8pt;border:solid windowtext 1.0pt;border-left:none;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>");
							contentBuff.append("			<span lang='EN-US' style='font-size:8.0pt;'>"+ nYCInvoiceVOs.get(i).getBlSrcNo() +"</span>");
							contentBuff.append("		</td>");
							contentBuff.append("		<td width='71' nowrap='' valign='bottom' style='width:52.9pt;border:solid windowtext 1.0pt;border-left:none;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>");
							contentBuff.append("			<span lang='EN-US' style='font-size:8.0pt;'>"+ nYCInvoiceVOs.get(i).getCrAmt() +"</span>");
							contentBuff.append("		</td>");
							contentBuff.append("		<td width='84' nowrap='' valign='bottom' style='width:62.75pt;border:solid windowtext 1.0pt;border-left:none;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>");
							contentBuff.append("			<span lang='EN-US' style='font-size:8.0pt;'>"+ nYCInvoiceVOs.get(i).getSailArrDt() +"</span>");
							contentBuff.append("		</td>");
							contentBuff.append("		<td width='76' nowrap='' valign='bottom' style='width:57.35pt;border:solid windowtext 1.0pt;border-left:none;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>");
							contentBuff.append("			<span lang='EN-US' style='font-size:8.0pt;'>"+ nYCInvoiceVOs.get(i).getDueDt() +"</span>");
							contentBuff.append("		</td>");
							contentBuff.append("		<td width='153' nowrap='' valign='bottom' style='width:114.7pt;border:solid windowtext 1.0pt;border-left:none;padding:0cm 10.4pt 0cm 5.4pt;height:15.0pt'>");
							contentBuff.append("			<span lang='EN-US' style='font-size:8.0pt;'>&nbsp; $ </span><span lang='EN-US' style='font-size:8.0pt;'>&nbsp; "+ nYCInvoiceVOs.get(i).getTtlAmt() +" </span>");
							contentBuff.append("		</td>");
							contentBuff.append("	</tr>");
							contentBuff.append("</table><br><br><br><br>");						
							contentBuff.append("<p style='margin:0cm;margin-bottom:.0001pt;font-size:12.0pt;font-family:&quot;Times New Roman&quot;,&quot;serif&quot;;'>");
							contentBuff.append("	<b><i><span lang='EN-US' style='color:#1F497D;'>"+ account.getUsr_nm() +"</span></i></b>");
							contentBuff.append("	<span lang='EN-US' style='font-size:10.0pt;font-family:&quot;Calibri&quot;,&quot;sans-serif&quot;;color:#244061'><b>|</b>&nbsp;");
							contentBuff.append("	Account Receivable&nbsp;<b>|</b> SM Line Corporation America, LLC. </span>");
							contentBuff.append("</p>");
							contentBuff.append("<p style='margin:0cm;margin-bottom:.0001pt;'>");
							contentBuff.append("	<span lang='EN-US' style='font-size:10.0pt;font-family:&quot;Calibri&quot;,&quot;sans-serif&quot;;color:#1F497D'>2195 W. CHANDLER BLVD., SUITE 100, CHANDLER, AZ 85224</span>");
							contentBuff.append("</p>");
							contentBuff.append("<p style='margin:0cm;margin-bottom:.0001pt;'>");
							contentBuff.append("	<span lang='EN-US' style='font-size:10.0pt;font-family:&quot;Calibri&quot;,&quot;sans-serif&quot;;color:#1F497D'>Email: ");
							contentBuff.append("	<a href='mailto:seng@us.hanjin.com' target='_blank'>"+ account.getUsr_eml() +"</a>");
							contentBuff.append("	Group Email: <a href='mailto:atobar@us.hanjin.com' target='_blank'>ecobar@us.hanjin.com</a></span>");
							contentBuff.append("</p>");
							contentBuff.append("<p style='margin:0cm;margin-bottom:.0001pt;'>");
							contentBuff.append("	<span lang='EN-US' style='font-size:10.0pt;font-family:&quot;Calibri&quot;,&quot;sans-serif&quot;;color:#1F497D'>Main #<b>:</b> 480-927-3600 Direct #<b>:</b>"+ account.getXtn_phn_no()+"</span>");
							contentBuff.append("</p>");
 							 
							String mailContents = nycEmlVo.getEdtContents() + contentBuff.toString();
								
							invEmailFaxVO.setContent(mailContents);
							
							if ("E".equals(nycEmlVo.getSendFlag())) {
								invEmailFaxVO.setRecipient(nYCInvoiceVOs.get(i).getCustEml());
							}
							else {
								invEmailFaxVO.setRecipient(nYCInvoiceVOs.get(i).getCustFaxNo());
							}
							
							// Send Mail
							String sndNo = eaiDao.sendNYCInvoiceByFaxEmail(nYCInvoiceVOs, invEmailFaxVO, nycEmlVo,account);
							
							InvArUsaIssSndVO invArUsaIssSndVO = new InvArUsaIssSndVO();
							
							SimpleDateFormat SDformat = new SimpleDateFormat("MM/dd/yyyy");
							SimpleDateFormat SDformat2 = new SimpleDateFormat("yyyyMMdd");
					       
							Date transdate = SDformat.parse(nYCInvoiceVOs.get(i).getSailArrDt()); 				         
					        String transStr = SDformat2.format(transdate);    
							
							invArUsaIssSndVO.setBlSrcNo(nYCInvoiceVOs.get(i).getBlSrcNo());
							invArUsaIssSndVO.setInvIssSndTpCd(nycEmlVo.getSendFlag());
							invArUsaIssSndVO.setInvSndCustNo(invEmailFaxVO.getRecipient());
							invArUsaIssSndVO.setInvSndNo(sndNo);
							invArUsaIssSndVO.setArOfcCd(nycEmlVo.getArOfcCd());
							invArUsaIssSndVO.setSailArrDt(transStr);
							invArUsaIssSndVO.setCreUsrId(account.getUsr_id());
							invArUsaIssSndVO.setUpdUsrId(account.getUsr_id());
							
							dbDao.addNYCIssueMain(invArUsaIssSndVO);
							
							if(!"".equals(sndNo)){
								sndNum++;
							}
						}
					} else {
						bkgNos = nycEmlVo.getBkgNos();
						
						invEmailFaxVO.setInvNo(bkgNos);
						invEmailFaxVO.setArOfcCd(nycEmlVo.getArOfcCd());
						invEmailFaxVO.setSendFlg(nycEmlVo.getSendFlag());
						invEmailFaxVO.setArgument(nycEmlVo.getStampType());
						invEmailFaxVO.setSubject(nycEmlVo.getEdtSubject());
						invEmailFaxVO.setContent(nycEmlVo.getEdtContents());
						
						if ("E".equals(nycEmlVo.getSendFlag())) {
							invEmailFaxVO.setRecipient(nycEmlVo.getEdtToEml());
						}
						else {
							invEmailFaxVO.setRecipient(nYCInvoiceVOs.get(0).getCustFaxNo());
						}
						
						// Send Mail
						String sndNo = eaiDao.sendNYCInvoiceByFaxEmail(nYCInvoiceVOs,invEmailFaxVO, nycEmlVo,account);
						
						for( int i=0; i < nYCInvoiceVOs.size();  i++){					
							InvArUsaIssSndVO invArUsaIssSndVO = new InvArUsaIssSndVO();
							
							SimpleDateFormat SDformat = new SimpleDateFormat("MM/dd/yyyy");
							SimpleDateFormat SDformat2 = new SimpleDateFormat("yyyyMMdd");
					       
							Date transdate = SDformat.parse(nYCInvoiceVOs.get(i).getSailArrDt()); 				         
					        String transStr = SDformat2.format(transdate);    
							
							invArUsaIssSndVO.setBlSrcNo(nYCInvoiceVOs.get(i).getBlSrcNo());
							invArUsaIssSndVO.setInvIssSndTpCd(nycEmlVo.getSendFlag());
							invArUsaIssSndVO.setInvSndCustNo(invEmailFaxVO.getRecipient());
							invArUsaIssSndVO.setInvSndNo(sndNo);
							invArUsaIssSndVO.setArOfcCd(nycEmlVo.getArOfcCd());
							invArUsaIssSndVO.setSailArrDt(transStr);
							invArUsaIssSndVO.setCreUsrId(account.getUsr_id());
							invArUsaIssSndVO.setUpdUsrId(account.getUsr_id());
							
							dbDao.addNYCIssueMain(invArUsaIssSndVO);
						}
						
						if(!"".equals(sndNo)){
							sndNum++;
						}
					}
				}
			}
			
			return sndNum;
			
		}  catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		}
	}
	
    /**
     * Office Code로 Server ID 조회
     * @param ofcCd
     * @return String
     * @throws EventException
     */
	public String searchSeverId(String ofcCd) throws EventException{
		String svrId = "";
		try {
			svrId = dbDao.searchSeverId(ofcCd);
			return svrId;
		}catch(DAOException de){
			log.error((new StringBuilder("err ")).append(de.toString()).toString(), de);
			throw new EventException((new ErrorHandler("COM12240", new String[0])).getMessage(), de);
		}catch(Exception ex){
			log.error((new StringBuilder("err ")).append(ex.toString()).toString(), ex);
			throw new EventException((new ErrorHandler("COM12240", new String[0])).getMessage(), ex);
		}
	}
	
	/**
     * VLCSC  MIV 존재여부 Check 
     * VLCSC의 경우 Auto Invoice Issue는 MIV가 존재하는 BL만 대상으로함<br>
	 * @author JungJin Park
     * @param arOfcCd
     * @param blSrcNo
	 * @return String
	 * @exception EventException
	 */
	public String searchChkAutoInv(String arOfcCd, String blSrcNo) throws EventException {
		String chkAutoInvFlg = "N";
		try {
			chkAutoInvFlg = dbDao.searchChkAutoInv(arOfcCd, blSrcNo);
			return chkAutoInvFlg;
		}catch(DAOException de){
			log.error((new StringBuilder("err ")).append(de.toString()).toString(), de);
			throw new EventException((new ErrorHandler("COM12240", new String[0])).getMessage(), de);
		}catch(Exception ex){
			log.error((new StringBuilder("err ")).append(ex.toString()).toString(), ex);
			throw new EventException((new ErrorHandler("COM12240", new String[0])).getMessage(), ex);
		}
	}
	
	/**
     * Auto Invoice 전송을 위해 AR_IF_NO로 Customer Email 조회<br>
	 * @author JungJin Park
     * @param arIfNo
	 * @return String
	 * @exception EventException
	 */
	public String searchAutoInvEmail(String arIfNo) throws EventException{
		String custEml = "";
		try {
			custEml = dbDao.searchAutoInvEmail(arIfNo);
			return custEml;
		}catch(DAOException de){
			log.error((new StringBuilder("err ")).append(de.toString()).toString(), de);
			throw new EventException((new ErrorHandler("COM12240", new String[0])).getMessage(), de);
		}catch(Exception ex){
			log.error((new StringBuilder("err ")).append(ex.toString()).toString(), ex);
			throw new EventException((new ErrorHandler("COM12240", new String[0])).getMessage(), ex);
		}
	}
	
	
	/**
	 * Invoice 기발행 Data를 조회한다. <br>
	 * 
	 * @param GeneralInvoiceVO genInvVo
	 * @return HashMap<String, Object>
	 * @exception EventException
	 */	
	public HashMap<String, Object> search3rdCheckList(GeneralInvoiceVO genInvVo) throws EventException {
		HashMap<String, Object> result	= new HashMap<String, Object>();
		
		List<String> list = null;

		try {
			list = dbDao.search3rdCheckList(genInvVo);

			result.put("BL_NOS", list);
 
			
			return result;
			
	    } catch(DAOException ex) {
	    	log.error("err " + ex.toString(), ex);
	    	throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 인도지역 Split Flag를 update 한다. <br>
	 * 
	 * @param String arOfcCd
	 * @param String blSrcNo
	 * @exception DAOException
	 */
	public void modifyIDASplitFlg(String arOfcCd, String blSrcNo) throws EventException{
		try {
			 dbDao.modifyIDASplitFlg(arOfcCd, blSrcNo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
}