/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ARInvoiceCustomerMgtBCImpl.java
 *@FileTitle : Customer Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.04
 *@LastModifier : 김세일
 *@LastVersion : 1.0
 * 2009.05.04 김세일
 * 1.0 Creation
 *  --------------------------------------------------------
 * History
 * 2011.09.28 권   민 [CHM-201113617] [INV]SVAT Reg. No for CMBSC SVAT Reg. NO 입력/저장 기능 개발
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.hanjin.apps.alps.common.mdmSync.jms.vo.CreateMdmCrCustVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.integration.ARInvoiceCustomerMgtDBDAO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.ARInvoiceBadCustomerHistoryVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.AgentByVesselPortVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.CprtItemVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.CreditCustomerVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.CustRepEmlInfoVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.CustomerListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.CustomerSecurityVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.InvArScrVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.InvCprtCdConvVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.InvSubAgnCustCdVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.PopCustomerListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.PriCustomerListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.SearchAgentListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.SearchCustomerVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.SearchSVATNoVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.SecurityInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.TemplateItemVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.TemplateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.ActPayerVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.AutoInvCustomerVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.InvArSpndVatRgstNoVO;
import com.hanjin.syscommon.common.table.InvCprtTmpltChgVO;
import com.hanjin.syscommon.common.table.MdmCustomerVO;

/**
 * ALPS-AccountReceivableInvoiceMasterDataMgt Business Logic Basic Command implementation<br>
 * - ALPS-AccountReceivableInvoiceMasterDataMgt에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author saeil kim
 * @see FNS_INV_0014EventResponse,ARInvoiceCustomerMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class ARInvoiceCustomerMgtBCImpl extends BasicCommandSupport implements ARInvoiceCustomerMgtBC {

	// Database Access Object
	private transient ARInvoiceCustomerMgtDBDAO dbDao = null;

	/**
	 * ARInvoiceCustomerMgtBCImpl 객체 생성<br>
	 * ARInvoiceCustomerMgtDBDAO를 생성한다.<br>
	 */
	public ARInvoiceCustomerMgtBCImpl() {
		dbDao = new ARInvoiceCustomerMgtDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * ARInvoiceCustomerMgt화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchCustomerVO searchCustomerVO
	 * @return List<serarchCustomerVO>
	 * @exception EventException
	 */
	public List<SearchCustomerVO> searchCustomerList(SearchCustomerVO searchCustomerVO) throws EventException {
		int cnt = 0; // 조회 데이터 총카운트
		List<SearchCustomerVO> resultVOs = null; // 데이터 전송을 위해 VO 객체
		try {
			cnt = dbDao.searchCustomerListCnt(searchCustomerVO);
			resultVOs = dbDao.searchCustomerList(searchCustomerVO);
			if (resultVOs.size() > 0) {
				resultVOs.get(0).setMaxRows(cnt);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}

		return resultVOs;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * ARInvoiceCustomerMgt화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchCustomerVO searchCustomerVO
	 * @return int
	 * @exception EventException
	 */
	public int searchCustomerListCnt(SearchCustomerVO searchCustomerVO) throws EventException {
		int cnt = 0; // 조회 데이터 총카운트
		try {
			cnt = dbDao.searchCustomerListCnt(searchCustomerVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}

		return cnt;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Customer 테이블 에서 조회조건에 해당하는 기초정보 및 신용정보를 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String country
	 * @param String cust
	 * @param String regNo
	 * @return List<CreditCustomerVO>
	 * @exception EventException
	 */
	public List<CreditCustomerVO> searchCreditCustomer(String country, String cust, String regNo) throws EventException {
		// int cnt = 0; // 조회 데이터 총카운트
		List<CreditCustomerVO> creditCustomerVO = null; // 데이터 전송을 위해 VO 객체
		try {
			creditCustomerVO = dbDao.searchCreditCustomer(country, cust, regNo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}

		return creditCustomerVO;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * MDM_CUST_REP 테이블 에서 조회조건에 해당하는E-MAIL정보를 가져온다.<br>
	 * 
	 * @author Seungil Baek
	 * @param String custCntCd
	 * @param String custSeq
	 * @return List<CustRepEmlInfoVO>
	 * @exception EventException
	 */
	public List<CustRepEmlInfoVO> searchMdmCustRepEmlInfo(String custCntCd, String custSeq) throws EventException {
		// int cnt = 0; // 조회 데이터 총카운트
		List<CustRepEmlInfoVO> custRepEmlInfoVO = null; // 데이터 전송을 위해 VO 객체
		try {
			custRepEmlInfoVO = dbDao.searchMdmCustRepEmlInfo(custCntCd, custSeq);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}

		return custRepEmlInfoVO;
	}
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * Option에 따라 Credit Customer/ Sale Customer 정보를 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String custFlag
	 * @param String usrOfcCd
	 * @param String ofc
	 * @param String custRlseCtrlFlg
	 * @return List<CustomerListVO>
	 * @exception EventException
	 */
	public List<CustomerListVO> searchCustomerListByOffice(String custFlag, String usrOfcCd, String ofc, String custRlseCtrlFlg) throws EventException {
		int cnt = 0; // 조회 데이터 총카운트
		List<CustomerListVO> resultVOs = null; // 데이터 전송을 위해 VO 객체
		try {
			if (custFlag.equals("C")) {
				// CreditCustomer 일때,
				resultVOs = dbDao.searchCreditCustomerListByOffice(usrOfcCd, ofc, custRlseCtrlFlg);
			} else {
				// SalesCustomer 일때,
				resultVOs = dbDao.searchSalesCustomerListByOffice(usrOfcCd, ofc, custRlseCtrlFlg);
			}

			if (resultVOs.size() > 0) {
				resultVOs.get(0).setMaxRows(cnt);
			}
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
		return resultVOs;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * 소속 AR_HD_QTR_OFC_CD 산하의 모든 office code를 가져온다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String ofc
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchSalesOfcList(String ofc) throws EventException {
		List<String> resultVOs = null; // 데이터 전송을 위해 VO 객체
		try {
			resultVOs = dbDao.searchSalesOfcList(ofc);
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), e);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		return resultVOs;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * POP UI에서 Customer 정보를 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String cntry
	 * @param String custNm
	 * @param String zipNo
	 * @param String chkNm
	 * @param String custRgstNo
	 * @return List<PopCustomerListVO>
	 * @exception EventException
	 */
	public List<PopCustomerListVO> searchPopCustomerList(String cntry, String custNm, String zipNo, String chkNm, String custRgstNo) throws EventException {
		int cnt = 0; // 조회 데이터 총카운트
		List<PopCustomerListVO> resultVOs = null; // 데이터 전송을 위해 VO 객체
		try {
			resultVOs = dbDao.searchPopCustomerList(cntry, custNm, zipNo, chkNm, custRgstNo);
			if (resultVOs.size() > 0) {
				resultVOs.get(0).setMaxRows(cnt);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		return resultVOs;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * ARInvoiceCustomerMgt화면에 대한 조회 이벤트 처리<br>
	 * FNS_INV_0090
	 * 
	 * @author saeil
	 * @param String rfaNo
	 * @return List<PriCustomerListVO>
	 * @exception EventException
	 */
	public List<PriCustomerListVO> searchRFACustomerList(String rfaNo) throws EventException {
		int cnt = 0; // 조회 데이터 총카운트
		List<PriCustomerListVO> resultVOs = null; // 데이터 전송을 위해 VO 객체
		try {
			resultVOs = dbDao.searchRFACustomerList(rfaNo);
			if (resultVOs.size() > 0) {
				resultVOs.get(0).setMaxRows(cnt);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}

		return resultVOs;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * ARInvoiceCustomerMgt화면에 대한 조회 이벤트 처리<br>
	 * FNS_INV_0091
	 * 
	 * @author saeil
	 * @param String scNo
	 * @return List<PriCustomerListVO>
	 * @exception EventException
	 */
	public List<PriCustomerListVO> searchSCCustomerList(String scNo) throws EventException {
		int cnt = 0; // 조회 데이터 총카운트
		List<PriCustomerListVO> resultVOs = null; // 데이터 전송을 위해 VO 객체
		try {
			resultVOs = dbDao.searchSCCustomerList(scNo);
			if (resultVOs.size() > 0) {
				resultVOs.get(0).setMaxRows(cnt);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}

		return resultVOs;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * ARInvoiceCustomerMgt화면에 대한 조회 이벤트 처리<br>
	 * FNS_INV_0080
	 * 
	 * @param String option
	 * @param String arOfc
	 * @param String ofc
	 * @return List<AgentByVesselPortVO>
	 * @exception EventException
	 */
	
	public List<AgentByVesselPortVO> searchAgentByVesselPortList(String option, String arOfc, String ofc) throws EventException {
		List<AgentByVesselPortVO> resultVOs = null; // 데이터 전송을 위해 VO 객체
		try {
			if (option.equals("V")) {
				resultVOs = dbDao.searchAgentByVesselList(arOfc, ofc);

			} else {
				resultVOs = dbDao.searchAgentByPortList(arOfc, ofc);

			}
			// if ( resultVOs.size() > 0 ) {
			// resultVOs.get(0).setMaxRows(cnt);
			// }
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}

		return resultVOs;
	}
	
	/**
	 * FNS_INV_0081<br>
	 * 북중국 Inbound Collection Agent code list를 조회한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param String arOfc
	 * @param String arControl
	 * @return List<SearchAgentListVO>
	 * @exception EventException
	 */
	public List<SearchAgentListVO> searchAgentList(String arOfc, String arControl) throws EventException {
		List<SearchAgentListVO> resultVOs = null;
		
		try {
			if(arControl.equals("C") || arOfc.equals("XMNSC")) {
				resultVOs = dbDao.searchAgentCList(arOfc);
			} else {
				resultVOs = dbDao.searchAgentList(arOfc);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00115", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00115", new String[] {}).getMessage(), ex);
		}

		return resultVOs;
	}

	/**
	 * ARInvoiceCustomerMgt화면에 대한 조회 이벤트 처리<br>
	 * FNS_INV_0081 vessel Search
	 * 
	 * @author saeil
	 * @param String vsl
	 * @return List<AgentByVesselPortVO>
	 * @exception EventException
	 */
	/*
	public List<AgentByVesselPortVO> searchAgentByVessel(String vsl) throws EventException {
		List<AgentByVesselPortVO> resultVOs = null; // 데이터 전송을 위해 VO 객체
		try {
			resultVOs = dbDao.searchAgentByVessel(vsl);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}

		return resultVOs;
	}
	*/

	/**
	 * 다건의 데이터를 일괄적으로 삭제한다.<br>
	 * FNS_INV_0081 vessel delete
	 * 
	 * @author saeil
	 * @param AgentByVesselPortVO[] agentByVesselPortVOs
	 * @param String userId
	 * @exception EventException
	 */
	/*
	public void removeAgentByVessel(AgentByVesselPortVO[] agentByVesselPortVOs, String userId) throws EventException {
		try {
			List<AgentByVesselPortVO> deleteVoList = new ArrayList<AgentByVesselPortVO>();

			for (int i = 0; i < agentByVesselPortVOs.length; i++) {

				deleteVoList.add(agentByVesselPortVOs[i]);
			}

			if (deleteVoList.size() > 0) {
				dbDao.removeAgentByVessel(deleteVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}

	}
	*/
	/**
	 * ARInvoiceCustomerMgtDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * FNS_INV_0082 by Pod,Lane Search
	 * 
	 * @author saeil
	 * @param String pod
	 * @param String lane
	 * @return List<AgentByVesselPortVO>
	 * @exception EventException
	 */
	/*
	public List<AgentByVesselPortVO> searchAgentByPort(String pod, String lane) throws EventException {
		List<AgentByVesselPortVO> resultVOs = null; // 데이터 전송을 위해 VO 객체
		try {
			resultVOs = dbDao.searchAgentByPort(pod, lane);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}

		return resultVOs;
	}
	*/

//	/**
//	 * 다건의 데이터를 일괄적으로 생성및 수정 한다.<br>
//	 * FNS_INV_0082 pod Insert
//	 * 
//	 * @author saeil
//	 * @param AgentByVesselPortVO[] agentByVesselPortVOs
//	 * @param String userId
//	 * @exception EventException
//	 */
//	public void manageAgentByPort(AgentByVesselPortVO[] agentByVesselPortVOs, String userId) throws EventException {
//		try {
//			List<AgentByVesselPortVO> insertVoList = new ArrayList<AgentByVesselPortVO>();
//			List<AgentByVesselPortVO> updateVoList = new ArrayList<AgentByVesselPortVO>();
//
//			for (int i = 0; i < agentByVesselPortVOs.length; i++) {
//
//				if (agentByVesselPortVOs[i].getIbflag().equals("I")) {
//					agentByVesselPortVOs[i].setCreUsrId(userId);
//					agentByVesselPortVOs[i].setUpdUsrId(userId);
//					insertVoList.add(agentByVesselPortVOs[i]);
//				} else if (agentByVesselPortVOs[i].getIbflag().equals("U")) {
//					agentByVesselPortVOs[i].setUpdUsrId(userId);
//					updateVoList.add(agentByVesselPortVOs[i]);
//				}
//			}
//
//			if (insertVoList.size() > 0) {
//				dbDao.addAgentByPort(insertVoList);
//			}
//			if (updateVoList.size() > 0) {
//				dbDao.modifyAgentByPort(updateVoList);
//			}
//		} catch (DAOException ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
//		} catch (Exception ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
//		}
//
//	}

//	/**
//	 * 다건의 데이터를 일괄적으로 삭제한다.<br>
//	 * FNS_INV_0082 vessel delete
//	 * 
//	 * @author saeil
//	 * @param AgentByVesselPortVO[] agentByVesselPortVOs
//	 * @param String userId
//	 * @exception EventException
//	 */
//	public void removeAgentByPort(AgentByVesselPortVO[] agentByVesselPortVOs, String userId) throws EventException {
//		try {
//			List<AgentByVesselPortVO> deleteVoList = new ArrayList<AgentByVesselPortVO>();
//
//			for (int i = 0; i < agentByVesselPortVOs.length; i++) {
//				agentByVesselPortVOs[i].setUpdUsrId(userId);
//				deleteVoList.add(agentByVesselPortVOs[i]);
//			}
//
//			if (deleteVoList.size() > 0) {
//				dbDao.removeAgentByPort(deleteVoList);
//			}
//		} catch (DAOException ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
//		} catch (Exception ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
//		}
//
//	}

	/**
	 * CPR(Customer Preferable Report)에서 사용할 Conversion code를 유형별로 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String scNo
	 * @param String rfaNO
	 * @param String codeTy
	 * @return List<InvCprtCdConvVO>
	 * @exception EventException
	 */
	public List<InvCprtCdConvVO> searchCodeConversionList(String scNo, String rfaNO, String codeTy) throws EventException {
		List<InvCprtCdConvVO> resultVOs = null; // 데이터 전송을 위해 VO 객체
		try {
			resultVOs = dbDao.searchCodeConversionList(scNo, rfaNO, codeTy);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		return resultVOs;
	}

	/**
	 * S/C No, RFA no로 PRI 시스템에서 Customer를 찾아 온다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String scNo
	 * @param String rfaNo
	 * @return String
	 * @exception EventException
	 */
	public String searchCustomerName(String scNo, String rfaNo) throws EventException {
		String customerName = "";
		try {
			if (rfaNo.equals("X")) {
				customerName = dbDao.searchSCCustomerName(scNo);
			}
			if (scNo.equals("X")) {
				customerName = dbDao.searchRFACustomerName(rfaNo);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		return customerName;
	}

	/**
	 * CPR(Customer Preferable Report)에서 사용할 한진해운 사용 code를 Customer 사용 Code로 Conversion하기 위한 code를 등록하는 화면에서 한진해운 Code 가 유효한 Code 인지를 check한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String cdTp
	 * @param String cd
	 * @return String
	 * @exception EventException
	 */
	public String searchHJSCode(String cdTp, String cd) throws EventException {
		String hjsCode = "";
		try {
			if (cdTp.equals("LOCATION")) {
				hjsCode = dbDao.searchLocation(cd);
			} else if (cdTp.equals("CHARGE")) {
				hjsCode = dbDao.searchChgCode(cd);
			} else if (cdTp.equals("CNTRTPSZ")) {
				hjsCode = dbDao.searchCNTRCode(cd);
			} else if (cdTp.equals("COMMODITY")) {
				hjsCode = dbDao.searchCmdtCode(cd);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		return hjsCode;
	}

	/**
	 * CPR(Customer Preferable Report)에서 사용할 conversion code를 수정한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param InvCprtCdConvVO[] invCprtCdConvVOs
	 * @param String userId
	 * @exception EventException
	 */
	public void manageCodeConversion(InvCprtCdConvVO[] invCprtCdConvVOs, String userId) throws EventException {
		try {
			List<InvCprtCdConvVO> insertVoList = new ArrayList<InvCprtCdConvVO>();
			List<InvCprtCdConvVO> updateVoList = new ArrayList<InvCprtCdConvVO>();
			List<InvCprtCdConvVO> deleteVoList = new ArrayList<InvCprtCdConvVO>();
			for (int i = 0; i < invCprtCdConvVOs.length; i++) {
				if (invCprtCdConvVOs[i].getIbflag().equals("I")) {
					invCprtCdConvVOs[i].setCreUsrId(userId);
					insertVoList.add(invCprtCdConvVOs[i]);
				} else if (invCprtCdConvVOs[i].getIbflag().equals("U")) {
					invCprtCdConvVOs[i].setUpdUsrId(userId);
					updateVoList.add(invCprtCdConvVOs[i]);
				} else if (invCprtCdConvVOs[i].getIbflag().equals("D")) {
					deleteVoList.add(invCprtCdConvVOs[i]);
				}
			}
			if (insertVoList.size() > 0) {
				dbDao.addCodeConversion(insertVoList);
			}
			if (updateVoList.size() > 0) {
				dbDao.modifyCodeConversion(updateVoList);
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeCodeConversion(deleteVoList);
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			if (ex.toString().contains("ORA-00001")) {
				throw new EventException(new ErrorHandler("INV00052", new String[] {}).getMessage(), ex);
			} else {
				throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
			}
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * CPR(Customer Preferable Report)에서 사용할 Conversion code를 유형별로 등록한다. 이미 다른 S/C NO나 RFA NO로 등록된 Conversion code를 신규 S/C NO나 RFA NO로 내용을 Copy 하여 새로 생성해준다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param InvCprtCdConvVO[] invCprtCdConvVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createCodeConversion(InvCprtCdConvVO[] invCprtCdConvVOs, SignOnUserAccount account) throws EventException {
		try {
			List<InvCprtCdConvVO> insertVoList = new ArrayList<InvCprtCdConvVO>();
			for (int i = 0; i < invCprtCdConvVOs.length; i++) {
				invCprtCdConvVOs[i].setCreUsrId(account.getUsr_id());
				insertVoList.add(invCprtCdConvVOs[i]);
			}
			if (insertVoList.size() > 0) {
				dbDao.addCodeConversion(insertVoList);
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			if (ex.toString().contains("ORA-00001")) {
				throw new EventException(new ErrorHandler("INV00052", new String[] {}).getMessage(), ex);
			} else {
				throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
			}
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Customer 기본 신용정보 및 신용담보정보조회 조회한다.<br>
	 * 
	 * @author Choi Do Soon
	 * @param String custCntCd
	 * @param String custSeq
	 * @return List<CustomerSecurityVO>
	 * @exception EventException
	 */
	public List<CustomerSecurityVO> searchSecurityList(String custCntCd, String custSeq) throws EventException {
		List<CustomerSecurityVO> customerSecurityVOs = null; // 데이터 전송을 위해 VO 객체
		try {
			customerSecurityVOs = dbDao.searchSecurityList(custCntCd, custSeq);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}

		return customerSecurityVOs;
	}

	/**
	 * 시스템에 Customer 신용정보인 담보등록, 수정, 삭제한다.<br>
	 * 
	 * @author Choi Do Soon
	 * @param InvArScrVO[] invArScrVOs
	 * @param userId
	 * @exception EventException
	 */
	public void manageCustomerSecurity(InvArScrVO[] invArScrVOs, String userId) throws EventException {
		List<InvArScrVO> updateVoList = new ArrayList<InvArScrVO>();
		List<InvArScrVO> deleteVoList = new ArrayList<InvArScrVO>();
		try {
			for (int i = 0; i < invArScrVOs.length; i++) {
				if (invArScrVOs[i].getIbflag().equals("I")) {
					invArScrVOs[i].setCreUsrId(userId);
					invArScrVOs[i].setUpdUsrId(userId);

					dbDao.addCustomerSecurity(invArScrVOs[i]);
				} else if (invArScrVOs[i].getIbflag().equals("U")) {
					invArScrVOs[i].setUpdUsrId(userId);
					updateVoList.add(invArScrVOs[i]);
				} else if (invArScrVOs[i].getIbflag().equals("D")) {
					deleteVoList.add(invArScrVOs[i]);
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyCustomerSecurity(updateVoList);
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeCustomerSecurity(deleteVoList);
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
	 * CPR(Customer Preferable Report)에서 사용. 선택가능한 모든 항목 List 와 를 가져온다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String userId
	 * @param String ofc
	 * @return CPRT_ItemVO
	 * @exception EventException
	 */
	public CprtItemVO searchReportItemList(String userId, String ofc) throws EventException {
		// CPRT_ItemVO cPRT_ItemVO = null; // 데이터 전송을 위해 VO 객체
		CprtItemVO cprtItemVO = new CprtItemVO();
		try {
			cprtItemVO.setCprtItemListVOs(dbDao.searchItemList());
			//cprtItemVO.setCprtTmpltVOs(dbDao.searchTemplateList(userId, ofc));
			cprtItemVO.setRptTmpltNmVOs(dbDao.searchTemplateList(userId, ofc));
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		return cprtItemVO;
	}

	/**
	 * CPR(Customer Preferable Report)에서 사용. Template으로 등록된 선택한 항목 List 를 가져온다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String tmplate
	 * @param String arOfcCd
	 * @return TemplateVO
	 * @exception EventException
	 */
	public TemplateVO searchSelectedItemList(String tmplate, String arOfcCd) throws EventException {
//		List<TemplateItemVO> templateItemVOs = null; // 데이터 전송을 위해 VO 객체
		TemplateVO templateVO = new TemplateVO();
		try {
			List<TemplateItemVO> listTemplateItemVO = dbDao.searchSelectedItemList(tmplate, arOfcCd);
			List<InvCprtTmpltChgVO> listInvCprtTmpltChgVO = dbDao.searchSelectedChildItemList(tmplate, arOfcCd);
			                                                   
			templateVO.setListTemplateItemVO(listTemplateItemVO);
			templateVO.setListInvCprtTmpltChgVO(listInvCprtTmpltChgVO);
	
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		return templateVO;
	}

	/**
	 * CPR(Customer Preferable Report)에서 사용. 신규입력한 Template 명이 이미 존재하는지를 check한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String tmplate
	 * @return String
	 * @exception EventException
	 */

	public String searchTemplateName(String tmplate) throws EventException {
	
		String tmpleName = null; // 데이터 전송을 위해 VO 객체
		try {

			tmpleName = dbDao.searchTemplateName(tmplate);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		return tmpleName;
	}

	/**
	 * Template name으로 선택한 item을 등록,수정, 삭제한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param TemplateVO[] templateVOs
	 * @param InvCprtTmpltChgVO[] invCprtTmpltChgVOs 
	 * @param String userId
	 * @param String ofcCd
	 * @exception EventException
	 */
	public void manageTemplateItem(TemplateVO[] templateVOs, InvCprtTmpltChgVO[] invCprtTmpltChgVOs, String userId, String ofcCd) throws EventException {
		List<TemplateVO> insertVoList = new ArrayList<TemplateVO>();
		List<TemplateVO> updateVoList = new ArrayList<TemplateVO>();
		List<TemplateVO> deleteVoList = new ArrayList<TemplateVO>();
		List<InvCprtTmpltChgVO> chgVoList = new ArrayList<InvCprtTmpltChgVO>();
		String tmplate = templateVOs[0].getRptTmpltNm();
		//Template 등록 Office로 처리되도록 함. 2011.03.28
		String ofc = templateVOs[0].getArOfcCd();
	 	

		try {
			for (int i = 0; i < templateVOs.length; i++) {
				if (templateVOs[i].getIbflag().equals("I")) {
					templateVOs[i].setCreUsrId(userId);
					templateVOs[i].setUpdUsrId(userId);

					insertVoList.add(templateVOs[i]);
				} else if (templateVOs[i].getIbflag().equals("U")) {
					templateVOs[i].setUpdUsrId(userId);
					updateVoList.add(templateVOs[i]);
				} else if (templateVOs[i].getIbflag().equals("D")) {
					deleteVoList.add(templateVOs[i]);
				}
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeTemplateItem(deleteVoList);
			}
			if (insertVoList.size() > 0) {
				dbDao.addTemplateItem(insertVoList);
			}
			if (updateVoList.size() > 0) {
				dbDao.modifyTemplateItem(updateVoList);
			}
			
			
			if(invCprtTmpltChgVOs != null && invCprtTmpltChgVOs.length > 0){
				for (int j = 0; j < invCprtTmpltChgVOs.length; j++) {
					
					invCprtTmpltChgVOs[j].setUpdUsrId(userId);
					chgVoList.add(invCprtTmpltChgVOs[j]);
					
				}
				
			
				if (chgVoList.size() > 0) {	
				    	dbDao.removeInvCprTmpltChg(tmplate, ofc);
				     	dbDao.addInvCprTmpltChg(chgVoList);
				  }
			}else {
			            dbDao.removeInvCprTmpltChg(tmplate, ofc);
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
	 * CPR(Customer Preferable Report)에 사용하기 위해 등록한 Template을 삭제한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String tmplate
	 * @param String ofcCd
	 * @exception EventException
	 */
	public void removeTemplate(String tmplate, String ofcCd) throws EventException {
		// String tmpleName = null; // 데이터 전송을 위해 VO 객체
		try {
			dbDao.removeTemplate(tmplate, ofcCd);
			dbDao.removeInvCprTmpltChg(tmplate, ofcCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 입력된 조건으로 Customer별 신용담보정보조회 조회한다.<br>
	 * 
	 * @author Choi Do Soon
	 * @param SecurityInputVO securityInputVO
	 * @return List<CustomerSecurityVO>
	 * @exception EventException
	 */
	public List<CustomerSecurityVO> searchCustomerSecurityList(SecurityInputVO securityInputVO) throws EventException {
		List<CustomerSecurityVO> customerSecurityVOs = null; // 데이터 전송을 위해 VO 객체
		try {
			customerSecurityVOs = dbDao.searchCustomerSecurityList(securityInputVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}

		return customerSecurityVOs;
	}
	
	/**
	 * FNS_INV_0081<br>
	 * 시스템에 북중국 Inbound Collection Agent와 Vessel code, Port(POD)/Lane별로  Match 하여 등록, 수정한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param String option
	 * @param AgentByVesselPortVO[] agentByVesselPortVOs
	 * @param String userId
	 * @exception EventException
	 */
	public void manageAgentByVslPod(String option, AgentByVesselPortVO[] agentByVesselPortVOs, String userId) throws EventException {
		try {
			List<AgentByVesselPortVO> insertVoList = new ArrayList<AgentByVesselPortVO>();
			List<AgentByVesselPortVO> updateVoList = new ArrayList<AgentByVesselPortVO>();
			List<AgentByVesselPortVO> deleteVoList = new ArrayList<AgentByVesselPortVO>();

			for (int i = 0; i < agentByVesselPortVOs.length; i++) {

				if (agentByVesselPortVOs[i].getIbflag().equals("I")) {
					agentByVesselPortVOs[i].setCreUsrId(userId);
					agentByVesselPortVOs[i].setUpdUsrId(userId);
					insertVoList.add(agentByVesselPortVOs[i]);
				} else if (agentByVesselPortVOs[i].getIbflag().equals("U")) {
					agentByVesselPortVOs[i].setUpdUsrId(userId);
					updateVoList.add(agentByVesselPortVOs[i]);
				} else if (agentByVesselPortVOs[i].getIbflag().equals("D")) {
					deleteVoList.add(agentByVesselPortVOs[i]);
				}
			}

			if (deleteVoList.size() > 0) {
				if(option.equals("V")) {
					dbDao.removeAgentByVessel(deleteVoList);
				} else {
					dbDao.removeAgentByPort(deleteVoList);
				}
			}
			
			if (insertVoList.size() > 0) {
				if(option.equals("V")) {
					dbDao.addAgentByVessel(insertVoList);
				} else {
					dbDao.addAgentByPort(insertVoList);
				}
			}
			
			if (updateVoList.size() > 0) {
				if(option.equals("V")) {
					dbDao.modifyAgentByVessel(updateVoList);
				} else {
					dbDao.modifyAgentByPort(updateVoList);
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
	 * FNS_INV_0082<br>
	 * POD 별 관리 북중국 Inbound Collection Agent를 조회한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param String arOfc
	 * @return List<AgentByVesselPortVO>
	 * @exception EventException
	 */
	public List<AgentByVesselPortVO> searchSubAgentList(String arOfc) throws EventException {
		List<AgentByVesselPortVO> agentByVesselPortVOs = null; // 데이터 전송을 위해 VO 객체
		try {
			agentByVesselPortVOs = dbDao.searchSubAgentList(arOfc);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}

		return agentByVesselPortVOs;
	}

	/**
	 * FNS_INV_0082<br>
	 * 미주( USA) 지역 Port 별  Agent 을 Match 하여 등록한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param InvSubAgnCustCdVO[] invSubAgnCustCdVOs
	 * @param String userId
	 * @exception EventException
	 */
	public void manageSubAgent(InvSubAgnCustCdVO[] invSubAgnCustCdVOs, String userId) throws EventException {
		try {
			List<InvSubAgnCustCdVO> insertVoList = new ArrayList<InvSubAgnCustCdVO>();
			List<InvSubAgnCustCdVO> updateVoList = new ArrayList<InvSubAgnCustCdVO>();
			List<InvSubAgnCustCdVO> deleteVoList = new ArrayList<InvSubAgnCustCdVO>();

			for (int i = 0; i < invSubAgnCustCdVOs.length; i++) {

				if (invSubAgnCustCdVOs[i].getIbflag().equals("I")) {
					invSubAgnCustCdVOs[i].setCreUsrId(userId);
					invSubAgnCustCdVOs[i].setUpdUsrId(userId);
					insertVoList.add(invSubAgnCustCdVOs[i]);
				} else if (invSubAgnCustCdVOs[i].getIbflag().equals("U")) {
					invSubAgnCustCdVOs[i].setUpdUsrId(userId);
					updateVoList.add(invSubAgnCustCdVOs[i]);
				} else if (invSubAgnCustCdVOs[i].getIbflag().equals("D")) {
					deleteVoList.add(invSubAgnCustCdVOs[i]);
				}
			}

			if (deleteVoList.size() > 0) {
				dbDao.removeSubAgent(deleteVoList);
			}
			
			if (insertVoList.size() > 0) {
				dbDao.addSubAgent(insertVoList);
			}
			
			if (updateVoList.size() > 0) {
				dbDao.modifySubAgent(updateVoList);
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
	 * FNS_INV_0123<br>
	 * SVATNo을 조회한다.<br>
	 * 
	 * @author	Kwon Min
	 * @param	SearchSVATNoVO searchSVATNoVO
	 * @return	List<serarchCustomerVO>
	 * @exception EventException
	 */
	public List<SearchSVATNoVO> searchSVATNo(SearchSVATNoVO searchSVATNoVO) throws EventException {
		List<SearchSVATNoVO> resultVOs = null; // 데이터 전송을 위해 VO 객체
		try {
			resultVOs = dbDao.searchSVATNo(searchSVATNoVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}

		return resultVOs;
	}
	
	/**
	 * FNS_INV_0123<br>
	 * SVAT Reg. No 입력/수정 function.<br>
	 * 
	 * @author		권 민
	 * @param		InvArSpndVatRgstNoVO invArSpndVatRgstNoVO
	 * @param		String userId
	 * @exception	EventException
	 */
	public void manageSVATNo(InvArSpndVatRgstNoVO invArSpndVatRgstNoVO, String userId) throws EventException {
		try {
			if (null != invArSpndVatRgstNoVO) {
				invArSpndVatRgstNoVO.setCreUsrId(userId);
				invArSpndVatRgstNoVO.setUpdUsrId(userId);
				dbDao.modifySVATNo(invArSpndVatRgstNoVO);
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
	 * 악성화주 리스트 조회<br>
	 * 
	 * @param ARInvoiceBadCustomerHistoryVO aRInvoiceBadCustomerHistoryVO
	 * @return List<ARInvoiceBadCustomerHistoryVO>
	 * @exception EventException
	 */
	public List<ARInvoiceBadCustomerHistoryVO> searchBadCustomerList(ARInvoiceBadCustomerHistoryVO aRInvoiceBadCustomerHistoryVO) throws EventException {
		
		try {
			return dbDao.searchBadCustomerList(aRInvoiceBadCustomerHistoryVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 악성화주 히스토리 리스트 조회<br>
	 * 
	 * @param ARInvoiceBadCustomerHistoryVO aRInvoiceBadCustomerHistoryVO
	 * @return List<ARInvoiceBadCustomerHistoryVO>
	 * @exception EventException
	 */
	public List<ARInvoiceBadCustomerHistoryVO> searchBadCustomerHistoryList(ARInvoiceBadCustomerHistoryVO aRInvoiceBadCustomerHistoryVO) throws EventException {
		
		try {
			return dbDao.searchBadCustomerHistoryList(aRInvoiceBadCustomerHistoryVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * INV_BAD_CUST_HIS_PROC 호출함.
	 * 
	 * @param Collection models
	 * @param String eai_id
	 * @param String in_kind
	 * @exception	EventException
	 */
	@SuppressWarnings("unchecked")
	public void manageInvBadCustHist(Collection models, String eai_id, String in_kind ) throws EventException {		
		try {
			String cust_cnt_cd = "";
			String cust_seq = "";
			Iterator itrs = models.iterator();
			
			log.debug("manageInvBadCustHis :: models Size"+models.size());
			
			if (eai_id.equals("MDM001")) {
				Collection temp = null;
				while (itrs.hasNext()) {
					
					temp = (ArrayList) itrs.next();
					log.debug("manageInvBadCustHis :: (ArrayList) itrs.next() Size"+temp.size());
					Iterator itr = temp.iterator();
					
					while (itr.hasNext()) {			
						
						log.debug("manageInvBadCustHis :: itr.hasNext()");							
						Object obj = itr.next();
						
						if (obj instanceof MdmCustomerVO) {	
							MdmCustomerVO model1 = (MdmCustomerVO)obj;
							cust_cnt_cd = model1.getCustCntCd();
							cust_seq = model1.getCustSeq();
							log.debug("manageInvBadCustHist*********MdmCustomerVO**********cust_cnt_cd = "+ cust_cnt_cd+ " / cust_seq = "+ cust_seq);
							dbDao.manageInvBadCustHist(cust_cnt_cd, cust_seq,in_kind);
						}
					}
				}
				
			} else if (eai_id.equals("MDM017")) {
				log.debug("manageInvBadCustHist******MDM017***1**");
				CreateMdmCrCustVO model2 = null;
				while (itrs.hasNext()) {
					model2 = (CreateMdmCrCustVO) itrs.next();
				}
				log.debug("manageInvBadCustHist******MDM017***2**");
				
				if(model2 != null){
					cust_cnt_cd = model2.getCustCntCd();
					cust_seq = model2.getCustSeq();
				}
					log.error("manageInvBadCustHist*******************cust_cnt_cd = "+ cust_cnt_cd + " / cust_seq = " + cust_seq);
					dbDao.manageInvBadCustHist(cust_cnt_cd, cust_seq, in_kind);
					log.error("manageInvBadCustHist******MDM017***3**");
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053",
					new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053",
					new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * MDM Actual Payer 리스트 조회<br>
	 * 
	 * @param String arOfcCd
	 * @param String userOfcCd
	 * @param String actCustCntCd
	 * @param String actCustSeq
	 * @return List<ActPayerVO>
	 * @exception EventException
	 */
	public List<ActPayerVO> searchActualPayerList(String arOfcCd, String userOfcCd,String actCustCntCd, String actCustSeq) throws EventException {
		
		try {
			return dbDao.searchActualPayerList(arOfcCd, userOfcCd, actCustCntCd,actCustSeq);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * MDM Auto Invoice 대상화주 리스트 조회<br>
	 * 
	 * @param String arOfcCd
	 * @param String ioBndCd
	 * @param String userOfcCd
	 * @param String actCustCntCd
	 * @param String actCustSeq
	 * @return List<AutoInvCustomerVO>
	 * @exception EventException
	 */
	public List<AutoInvCustomerVO> searchAutoInvCustomerList(String arOfcCd, String ioBndCd, String userOfcCd,String actCustCntCd,String actCustSeq) throws EventException {
		
		try {
			return dbDao.searchAutoInvCustomerList(arOfcCd, ioBndCd, userOfcCd,actCustCntCd,actCustSeq);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
}