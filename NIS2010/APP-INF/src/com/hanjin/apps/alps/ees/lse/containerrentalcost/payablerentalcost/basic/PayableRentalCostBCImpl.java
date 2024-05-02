/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PayableRentalCostBCImpl.java
*@FileTitle : EQ Payable Charge Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.08.25 진준성
* 1.0 Creation
* =======================================================
* 2010.10.05 남궁진호 [CHM-201006272-01] Session User Id 변경, CreUsrId -> UsrId
* 					createPayableRentalChargeBasic, removePayableRentalChargeBasic
*					createPayableRentalInvoiceBasic,createOperatingPayableRentalInvoiceBasic
*					searchPayableRentalChargeAuditBackEndBasic
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.basic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.integration.PayableRentalCostDBDAO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostAuditSearchVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostAuditVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostCreatVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostInvoiceCreateVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostOperationalInvoiceVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalInvoiceCostVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.vo.ReportSearchPayableVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestAgmtVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.backend.support.BackEndJobException;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.DateTime;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.util.StringUtil;
import com.hanjin.framework.core.config.SiteConfigFactory;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ApPayInvDtlVO;
import com.hanjin.syscommon.common.table.ApPayInvVO;
import com.hanjin.syscommon.common.table.LsePayRntlChgCoVO;

/**
 * ALPS-ContainerRentalCost Business Logic Basic Command implementation<br>
 * - ALPS-ContainerRentalCost에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Jin Jun Sung
 * @see EES_LSE_0060EventResponse,PayableRentalCostBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class PayableRentalCostBCImpl extends BasicCommandSupport implements PayableRentalCostBC {

	// Database Access Object
	private transient PayableRentalCostDBDAO dbDao = null;

	/**
	 * PayableRentalCostBCImpl 객체 생성<br>
	 * PayableRentalCostDBDAO를 생성한다.<br>
	 */
	public PayableRentalCostBCImpl() {
		dbDao = new PayableRentalCostDBDAO();
	}
	/**
	 * Payable Invoice 한 결과에 대하여 실적을 조회<br>
	 *
	 * @param ReportSearchPayableVO  reportSearchPayableVO
	 * @return List<ReportSearchPayableVO>
	 * @exception EventException
	 */
	public List<ReportSearchPayableVO> searchPayableRentalReportBasic(ReportSearchPayableVO reportSearchPayableVO) throws EventException {
		List<ReportSearchPayableVO> list = null;
		try {
			if( reportSearchPayableVO.getReportType() != null  && "rp_0060".equals(reportSearchPayableVO.getReportType())){
				list = dbDao.searchPayableRentalReportByChargeTypeData(reportSearchPayableVO);
			}else if( reportSearchPayableVO.getReportType() != null  && "rp_0061".equals(reportSearchPayableVO.getReportType())){
				list = dbDao.searchPayableRentalReportByTySzData(reportSearchPayableVO);
			}else if( reportSearchPayableVO.getReportType() != null  && "rp_0062".equals(reportSearchPayableVO.getReportType())){
				list = dbDao.searchPayableRentalReportByChargeTypeTySzData(reportSearchPayableVO);
			}else if( reportSearchPayableVO.getReportType() != null  && "rp_0063".equals(reportSearchPayableVO.getReportType())){
				list = dbDao.searchPayableRentalReportByLeaseTermMonthData(reportSearchPayableVO);
			}else if( reportSearchPayableVO.getReportType() != null  && "rp_0064".equals(reportSearchPayableVO.getReportType())){
				list = dbDao.searchPayableRentalReportByLessorMonthData(reportSearchPayableVO);
			}else if( reportSearchPayableVO.getReportType() != null  && "rp_0065".equals(reportSearchPayableVO.getReportType())){
	            list  = dbDao.searchPayablebyLessorMonthReportData(reportSearchPayableVO);
			}

		} catch(DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"PayableRentalReport Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"PayableRentalReport Search"}).getMessage(),ex);
		}
		return list;
	}

	/**
	 * Payable Creation Lessor Invoice File Import 신규 저장<br>
	 *
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param SignOnUserAccount account
	 * @return String[]
	 * @exception EventException
	 */
	public String[] importPayableLessorInvoiceBasic(PayableRentalCostVO payableRentalCostVO, SignOnUserAccount account) throws EventException {
		//String   uploadPath  = "/sitectx/DocUp/LSE";
		String   uploadPath  = (new StringBuilder(String.valueOf(SiteConfigFactory.get("COM.FILE.UPLOAD.DIRECTORY")))).append(SubSystemConfigFactory.get("LSE.MODULE.ID")).append("/").toString();
		String   fileName = payableRentalCostVO.getUploadFileNm();
		String   fileType = "";
		String[] result   = new String[3];
		BufferedReader br = null;

		try {
			if ( !fileName.equals("") ) {
				String[] arrFileName = fileName.split("[.]");

				fileType = arrFileName[1].toUpperCase();

				String invNo       = "";
				String ctrtNo      = "";
				String payImpSeq   = "";
				String agmtCytCd   = "";
				String agmtSeq     = "";
				String coCostYrmon = payableRentalCostVO.getCoCostYrmon();

				br = new BufferedReader(new FileReader(new File(uploadPath + "/" + payableRentalCostVO.getUploadFileNm())));

				int i = 0;

				List<LsePayRntlChgCoVO> insModels = new ArrayList<LsePayRntlChgCoVO>();

				String line = null;

				while ( (line = br.readLine()) != null ) {
					// If File Type
					if ( fileType.equals("TXT") ) {
						if ( i == 0 ) {
							if ( line.trim().length() > 9 ) {

								// Invoice No.
								invNo  = line.substring(3, 17).trim();
								// Contract No.
								ctrtNo = line.substring(17, 32).trim();

								// Agreement 조회
								String[] agmtNo = dbDao.searchAgreementNoByCtrtNoData(ctrtNo.trim());

								if ( agmtNo[0].equals("0") ) {
									result[0] = new ErrorHandler("LSE01007").getUserMessage(); //"Not exists Agreement No.";
									result[1] = agmtNo[1];
									result[2] = "";
									break;
								} else if ( agmtNo[0].equals("2") ) {
									result[0] = new ErrorHandler("LSE01055").getUserMessage(); //"So Many Agreement No.";
									result[1] = agmtNo[1];
									result[2] = "";
									break;
								} else if ( agmtNo[0].equals("1") ) {
									result[0] = new ErrorHandler("LSE10006", new String[]{"Invoice File Import"}).getUserMessage(); //"OK";
									result[1] = agmtNo[1];
									result[2] = ctrtNo;

									if ( !agmtNo[1].equals("") && agmtNo[1].length() > 3 ) {
										agmtCytCd = agmtNo[1].substring(0, 3);
										agmtSeq   = agmtNo[1].substring(3);
									}

									/* Audit 된 Charge Creation 이 존재한다면 File Import 불가 */
									boolean auditYN = dbDao.searchPayableRentalChargeHeaderData(agmtCytCd, agmtSeq, coCostYrmon);
									if ( auditYN ) {
										result[0] = new ErrorHandler("LSE01076", new String[]{"Invoice File","Charge Audit"}).getUserMessage();
										result[1] = "";
										result[2] = "";
										break;
									} else {
										/* 이미 저장된 데이터가 있다면 삭제 처리 */
										if ( !agmtNo[1].equals("") && agmtNo[1].length() > 3
										  && !coCostYrmon.equals("") && coCostYrmon.length() == 6) {
											dbDao.removePayableLessorInvoiceImportData(agmtCytCd, agmtSeq, coCostYrmon);
										}

										/* PAY_IMP_SEQ 채번 */
										payImpSeq = dbDao.searchNewPayImpSeqData(coCostYrmon);
									}
								} else {
									result[0] = new ErrorHandler("LSE10005", new String[]{"Invoice File Import"}).getMessage(); //"Service Not available.";
									result[1] = "";
									result[2] = "";
									break;
								}

								i++;
							}
						} else {
							if ( line.trim().length() > 9 ) {
								LsePayRntlChgCoVO vo = new LsePayRntlChgCoVO();

								vo.setPayImpSeq(payImpSeq);
								vo.setDtlSeq(String.valueOf(i));
								vo.setAgmtCtyCd(agmtCytCd);
								vo.setAgmtSeq(agmtSeq);
								vo.setCoCostYrmon(coCostYrmon);
								vo.setLseCtrtNo(ctrtNo);
								vo.setInvNo(invNo);
								vo.setCntrNo(line.substring(0, 11).trim());
								vo.setLsePayChgTpCd(line.substring(27, 30).trim());
								vo.setLsePayChgTpNm(line.substring(27, 30).trim());
								vo.setOnhDt(line.substring(30, 38).trim());
								vo.setOnhLocCd(line.substring(38, 43).trim());
								vo.setOffhDt(line.substring(43, 51).trim());
								vo.setOffhLocCd(line.substring(51, 56).trim());
								vo.setChgFreeDys(line.substring(56, 59).trim());
								vo.setPdRtAmt(line.substring(59, 67).trim());
								vo.setTtlCostAmt(line.substring(67, 77).trim());
								vo.setCreUsrId(account.getUsr_id());
								vo.setUpdUsrId(account.getUsr_id());

								insModels.add(vo);

								i++;
							}
						}
					}
				}

				if ( insModels.size() > 0 ) {
					payableRentalCostVO.setLsePayRntlChgCoVOs(insModels);
					dbDao.addPayableLessorInvoiceImportData(payableRentalCostVO);

					// HJS Charge Creation 된 데이터가 존재한다면 LSE_PAY_RNTL_CHG Table 의 INV_NO Update
					//dbDao.modifyPayableLessorInvoiceImportData(coCostYrmon, agmtCytCd, agmtSeq, invNo, account.getUsr_id());
					dbDao.modifyPayableRentalChargeMasterInvoiceNoData("", coCostYrmon, agmtCytCd, agmtSeq, invNo, account.getUsr_id());
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Payable Rental Lessor Invoice File Import"}).getMessage(), ex);
		} catch (FileNotFoundException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Payable Rental Lessor Invoice File Import"}).getMessage(), ex);
		} catch (IOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Payable Rental Lessor Invoice File Import"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Payable Rental Lessor Invoice File Import"}).getMessage(), ex);
		} finally {
			try {
				if (br != null) br.close();
			} catch (IOException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("LSE10005",new String[]{"Payable Rental Lessor Invoice File Import"}).getMessage(), ex);
			}
		}

		return result;
	}

	/**
	 * Payable Creation Lessor Invoice File Data 조회<br>
	 *
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @return PayableRentalCostVO
	 * @exception EventException
	 */
	public PayableRentalCostVO searchPayableLessorInvoiceBasic(PayableRentalCostVO payableRentalCostVO) throws EventException {
		PayableRentalCostVO resultVO = null; // 데이터 전송을 위해 VO 객체

		try {
			resultVO = dbDao.searchPayableLessorInvoiceData(payableRentalCostVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Payable Rental Lessor Invoice Inquery Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Payable Rental Lessor Invoice Inquery Search"}).getMessage(),ex);
		}

		return resultVO;
	}

	/**
	 * Payable Charge Creation 대상 Agreement를 조회<br>
	 *
	 * @param String costMonth
	 * @param String lessorNo
	 * @param String lstmCd
	 * @return PayableRentalCostVO
	 * @exception EventException
	 */
	public PayableRentalCostVO searchPayableRentalBasic(String costMonth, String lessorNo, String lstmCd) throws EventException {
		PayableRentalCostVO resultVO = null; // 데이터 전송을 위해 VO 객체

		try {
			resultVO = dbDao.searchPayableRentalData(costMonth, lessorNo, lstmCd);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Payable Rental Charget Creation Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Payable Rental Charget Creation Search"}).getMessage(),ex);
		}

		return resultVO;
	}

	/**
	 * Payable Rental Charge Creation 생성일괄작업(BackEndJob)을 수행<br>
	 *
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String createPayableRentalChargeBasic(PayableRentalCostVO payableRentalCostVO, SignOnUserAccount account) throws EventException {
		PayableRentalCostBackEndJob backEndJob = new PayableRentalCostBackEndJob();
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		try {
			payableRentalCostVO.setOfcCd(account.getOfc_cd());
			payableRentalCostVO.setUsrId(account.getUsr_id());
			backEndJob.setJobType("CHG_CRE");
			backEndJob.setPayableRentalCostVO(payableRentalCostVO);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Payable Rental Charget Creation Search"}).getMessage(),ex);
		}
		return backEndJobManager.execute(backEndJob, account.getUsr_id(), "Payable Charge Creation : Payable Charge Creat");
	}

	/**
	 * Payable Rental Charge Creation 삭제일괄작업(BackEndJob)을 수행<br>
	 *
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String removePayableRentalChargeBasic(PayableRentalCostVO payableRentalCostVO, SignOnUserAccount account) throws EventException {
		PayableRentalCostBackEndJob backEndJob = new PayableRentalCostBackEndJob();
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		try {
			backEndJob.setJobType("CHG_DEL");
			backEndJob.setPayableRentalCostVO(payableRentalCostVO);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Payable Rental Charget Creation Search"}).getMessage(),ex);
		}
		return backEndJobManager.execute(backEndJob, account.getUsr_id(), "Payable Charge Creation : Payable Charge Delete");
	}

	/**
	 * BackEndJob의 실행결과를 조회<br>
	 *
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String searchBakEndJobResultBasic(String key) throws EventException {

		DBRowSet rowSet;
		try {
			rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			rowSet.next();
			Thread.sleep(1000);
			if ( ((String)rowSet.getObject("jb_sts_flg")).equals("4") ) {
				throw new EventException((String)rowSet.getObject("jb_usr_err_msg"));
			}
			return (String) rowSet.getObject("jb_sts_flg");
		} catch (EventException e) {
			throw e;
		} catch (BackEndJobException e) {
			throw new EventException(e.getMessage());
		} catch (SQLException e) {
			throw new EventException(e.getMessage());
		} catch (InterruptedException e) {
			throw new EventException(e.getMessage());
		} catch(Exception e){
			throw new EventException(e.getMessage());
		}
	}

	/**
	 * Charge Creation 데이터의 Invoice No 를 저장<br>
	 *
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyPayableRentalChargeMasterInvoiceNoBasic(PayableRentalCostVO payableRentalCostVO, SignOnUserAccount account) throws EventException {
		try {
			PayableRentalCostCreatVO vo = payableRentalCostVO.getRentalCostCreatVO();
			dbDao.modifyPayableRentalChargeMasterInvoiceNoData(vo.getChgSeq(), "", vo.getAgmtCtyCd(), vo.getAgmtSeq(), vo.getInvNo(), account.getUsr_id());
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Payable Rental Charge Create"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Payable Rental Charge Create"}).getMessage(), ex);
		}
	}

	/**
	 * Payable Charge Audit 할 대상을 조회<br>
	 *
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @return PayableRentalCostVO
	 * @exception EventException
	 */
	public PayableRentalCostVO searchPayableRentalAuditBasic(PayableRentalCostVO payableRentalCostVO) throws EventException {
		PayableRentalCostVO resultVO = new PayableRentalCostVO();

		try {
			List<List<PayableRentalCostAuditVO>> payableRentalCostAuditVOs = new ArrayList<List<PayableRentalCostAuditVO>>();
			List<PayableRentalCostAuditVO> list1 = new ArrayList<PayableRentalCostAuditVO>();
			List<PayableRentalCostAuditVO> list2 = new ArrayList<PayableRentalCostAuditVO>();
			List<PayableRentalCostAuditVO> list3 = new ArrayList<PayableRentalCostAuditVO>();
			List<PayableRentalCostAuditVO> list4 = new ArrayList<PayableRentalCostAuditVO>();

			List<PayableRentalCostAuditVO> rowSetList = dbDao.searchPayableRentalAuditData(payableRentalCostVO);

			String auditStsCd = "";
			for ( int i = 0 ; i < rowSetList.size() ; i++ ) {
				auditStsCd = rowSetList.get(i).getCntrAudStsCd();

				if( auditStsCd.equals("D") ) {
					// Discrepancy
					list2.add(rowSetList.get(i));
				} else if( auditStsCd.equals("H") ) {
					// HJS Charge Only
					list3.add(rowSetList.get(i));
				} else if( auditStsCd.equals("L") ) {
					// Lessor Only
					list4.add(rowSetList.get(i));
				} else {
					// Coincidence
					list1.add(rowSetList.get(i));
				}
			}

			payableRentalCostAuditVOs.add(list1);
			payableRentalCostAuditVOs.add(list2);
			payableRentalCostAuditVOs.add(list3);
			payableRentalCostAuditVOs.add(list4);

			resultVO.setPayableRentalCostAuditVOs(payableRentalCostAuditVOs);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Payable Rental Charge Create"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Payable Rental Charge Create"}).getMessage(), ex);
		}

		return resultVO;
	}

	/**
	 * Payable Charge Audit 할 대상을 Back End Job 으로 조회한 결과를 UI에 맞는 VO 배열 형대로 변환합니다.<br>
	 *
	 * @param List<PayableRentalCostAuditVO> rowSetList
	 * @return PayableRentalCostVO
	 * @exception EventException
	 */
	public PayableRentalCostVO searchPayableRentalAuditBasic(List<PayableRentalCostAuditVO> rowSetList) throws EventException {
		PayableRentalCostVO resultVO = new PayableRentalCostVO();

		try {
			List<List<PayableRentalCostAuditVO>> payableRentalCostAuditVOs = new ArrayList<List<PayableRentalCostAuditVO>>();
			List<PayableRentalCostAuditVO> list1 = new ArrayList<PayableRentalCostAuditVO>();
			List<PayableRentalCostAuditVO> list2 = new ArrayList<PayableRentalCostAuditVO>();
			List<PayableRentalCostAuditVO> list3 = new ArrayList<PayableRentalCostAuditVO>();
			List<PayableRentalCostAuditVO> list4 = new ArrayList<PayableRentalCostAuditVO>();

			//List<PayableRentalCostAuditVO> rowSetList = dbDao.searchPayableRentalAuditData(payableRentalCostVO);

			String auditStsCd = "";
			for ( int i = 0 ; i < rowSetList.size() ; i++ ) {
				auditStsCd = rowSetList.get(i).getCntrAudStsCd();

				if( auditStsCd.equals("D") ) {
					// Discrepancy
					list2.add(rowSetList.get(i));
				} else if( auditStsCd.equals("H") ) {
					// HJS Charge Only
					list3.add(rowSetList.get(i));
				} else if( auditStsCd.equals("L") ) {
					// Lessor Only
					list4.add(rowSetList.get(i));
				} else {
					// Coincidence
					list1.add(rowSetList.get(i));
				}
			}

			payableRentalCostAuditVOs.add(list1);
			payableRentalCostAuditVOs.add(list2);
			payableRentalCostAuditVOs.add(list3);
			payableRentalCostAuditVOs.add(list4);

			resultVO.setPayableRentalCostAuditVOs(payableRentalCostAuditVOs);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Payable Rental Charge Create"}).getMessage(), ex);
		}

		return resultVO;
	}

	/**
	 * Payable Charge Audit 대상을 Audit 완료로 저장함.<br>
	 *
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public void createPayableRentalAuditBasic(PayableRentalCostVO payableRentalCostVO, SignOnUserAccount account) throws EventException {
		PayableRentalCostAuditVO[] payableRentalCostAuditVO = payableRentalCostVO.getPayableRentalCostAuditVO();

		try {
			/* Lease Agreement Drop Office Description 처리를 위한 객체 */
			List<PayableRentalCostAuditVO> insertVos  = new ArrayList<PayableRentalCostAuditVO>();
			List<PayableRentalCostAuditVO> modifyVos  = new ArrayList<PayableRentalCostAuditVO>();
			List<PayableRentalCostAuditVO> removeVos  = new ArrayList<PayableRentalCostAuditVO>();
			List<LsePayRntlChgCoVO>        modifyVos2 = new ArrayList<LsePayRntlChgCoVO>();
			List<LsePayRntlChgCoVO>        modifyVos3 = new ArrayList<LsePayRntlChgCoVO>();

			if ( payableRentalCostAuditVO.length > 0 ) {
				for ( int i = 0 ; i < payableRentalCostAuditVO.length ; i++ ) {
					payableRentalCostAuditVO[i].setUsrId(account.getUsr_id());
					payableRentalCostAuditVO[i].setOnhDt(payableRentalCostAuditVO[i].getOnhDt().replaceAll("-", ""));
					payableRentalCostAuditVO[i].setOffhDt(payableRentalCostAuditVO[i].getOffhDt().replaceAll("-", ""));
					payableRentalCostAuditVO[i].setDscrOnhDt(payableRentalCostAuditVO[i].getDscrOnhDt().replaceAll("-", ""));
					payableRentalCostAuditVO[i].setDscrOffhDt(payableRentalCostAuditVO[i].getDscrOffhDt().replaceAll("-", ""));

					if ( payableRentalCostAuditVO[i].getIbflag().equals("R") ) {
						/* Audit 완료로 modify. 기존 Audit 된 데이터는 가공이 되지 않은 경우 수행 작업 없음. */
						if ( payableRentalCostAuditVO[i].getCntrAudStsCd().equals("L") ) {
							payableRentalCostAuditVO[i].setCntrAudStsCd("A");

							/* Lessor Only(L) 데이터는 Audit 상태로 insert */
							insertVos.add(payableRentalCostAuditVO[i]);
						} else if ( !payableRentalCostAuditVO[i].getCntrAudStsCd().equals("A") ) {
							payableRentalCostAuditVO[i].setCntrAudStsCd("A");

							/* Coincidence, Discrepancy, Hanjin Only 데이터는 Audit 상태로 modify */
							modifyVos.add(payableRentalCostAuditVO[i]);
						}
					} else if ( payableRentalCostAuditVO[i].getIbflag().equals("I") ) {
						payableRentalCostAuditVO[i].setCntrAudStsCd("A");

						/* 직접입력된 데이터는 insert */
						insertVos.add(payableRentalCostAuditVO[i]);
					} else if ( payableRentalCostAuditVO[i].getIbflag().equals("U") ) {
						/* 1.Audit(A), Coincedance(D), Discrepance(D) 또는 Hanjin Only(H) 데이터는 modify
                         * 2.Lessor Only(L) 또는 직접입력된 데이터는 insert */
						if ( payableRentalCostAuditVO[i].getCntrAudStsCd().equals("L") ) {
							payableRentalCostAuditVO[i].setCntrAudStsCd("A");

							insertVos.add(payableRentalCostAuditVO[i]);

							/* Lessor Inovice File 의 Charge Type Code 가 사용하지 않는 Code 일 경우
							 * Coincidence 화면에서 Charge Type 을 설정하므로 Lessor Inovice File Data 에 Update. */
							if ( !payableRentalCostAuditVO[i].getLsePayChgTpCd().equals(payableRentalCostAuditVO[i].getLsePayChgTpNm()) ) {
								LsePayRntlChgCoVO vo = new LsePayRntlChgCoVO();

								vo.setCoCostYrmon(payableRentalCostAuditVO[i].getChgCostYrmon());
								vo.setCntrNo(payableRentalCostAuditVO[i].getCntrNo());
								// Lessor Invoice File 의 Original Charge Type Setting.
								vo.setLsePayChgTpCd(payableRentalCostAuditVO[i].getLsePayChgTpNm());
								// Coincidence 에서 변경된 Charge Type Setting.
								vo.setLsePayChgTpNm(payableRentalCostAuditVO[i].getLsePayChgTpCd());
								vo.setAgmtCtyCd(payableRentalCostAuditVO[i].getAgmtCtyCd());
								vo.setAgmtSeq(payableRentalCostAuditVO[i].getAgmtSeq());
								vo.setUpdUsrId(account.getUsr_id());

								modifyVos2.add(vo);
							}
						} else {
							payableRentalCostAuditVO[i].setCntrAudStsCd("A");

							modifyVos.add(payableRentalCostAuditVO[i]);
						}
					} else if ( payableRentalCostAuditVO[i].getIbflag().equals("D") ) {
						/* 1. Audit 완료 Data 만 작업수행. 완료되지 않은 Data 는 수행작업 없음.
						 * 2. Audit 완료 Data 중 Coincidence Data 는 수행작업 없음. */
						if ( payableRentalCostAuditVO[i].getCntrAudStsCd().equals("A") ) {
							if ( payableRentalCostAuditVO[i].getPayChgStsCd().equals("A") ) {
								// 출처가 직접입력일 경우 삭제.
								removeVos.add(payableRentalCostAuditVO[i]);
							} else if ( payableRentalCostAuditVO[i].getPayChgStsCd().equals("D")
									 || payableRentalCostAuditVO[i].getPayChgStsCd().equals("H") ) {
								// Discrepancy, Hanjin Only 데이터는 상태를 Audit 이전으로 Update.
								payableRentalCostAuditVO[i].setCntrAudStsCd("H");
								payableRentalCostAuditVO[i].setDscrOnhDt("");
								payableRentalCostAuditVO[i].setDscrOnhLocCd("");
								payableRentalCostAuditVO[i].setDscrOffhDt("");
								payableRentalCostAuditVO[i].setDscrOffhLocCd("");
								payableRentalCostAuditVO[i].setDscrPdRtAmt("0.0");
								payableRentalCostAuditVO[i].setDscrCostAmt("0.0");

								modifyVos.add(payableRentalCostAuditVO[i]);
							} else if ( payableRentalCostAuditVO[i].getPayChgStsCd().equals("L") ) {
								/* Audit 완료 Data 중 출처가 Lessor Only 인 경우 삭제. */
								removeVos.add(payableRentalCostAuditVO[i]);

								/* Lessor Data 의 Charge Type 이 변경되었을 수 있으니 Charge Type 도 원상복구. */
								LsePayRntlChgCoVO vo = new LsePayRntlChgCoVO();

								vo.setCoCostYrmon(payableRentalCostAuditVO[i].getChgCostYrmon());
								vo.setCntrNo(payableRentalCostAuditVO[i].getCntrNo());
								vo.setLsePayChgTpNm(payableRentalCostAuditVO[i].getLsePayChgTpCd());
								vo.setAgmtCtyCd(payableRentalCostAuditVO[i].getAgmtCtyCd());
								vo.setAgmtSeq(payableRentalCostAuditVO[i].getAgmtSeq());
								vo.setUpdUsrId(account.getUsr_id());

								modifyVos3.add(vo);
							}
						}
					}
				}
			}

			if ( removeVos != null && removeVos.size() > 0 ) {
				dbDao.removePayableRentalAuditData(removeVos);
			}

			if ( modifyVos != null && modifyVos.size() > 0 ) {
				dbDao.modifyPayableRentalAuditData(modifyVos);
			}

			if ( insertVos != null && insertVos.size() > 0 ) {
				// Detai Sequence 채번을 위하여 ExecuteBatch 사용 안함.
				for ( int i = 0 ; i < insertVos.size() ; i++ ) {
					dbDao.addPayableRentalAuditData(insertVos.get(i));
				}
			}

			if ( modifyVos2 != null && modifyVos2.size() > 0 ) {
				dbDao.modifyPayableLessorInvoiceImportData(modifyVos2);
			}

			if ( modifyVos3 != null && modifyVos3.size() > 0 ) {
				dbDao.modifyPayableLessorInvoiceImportInitData(modifyVos3);
			}

			if ( !payableRentalCostVO.getChgSeq().equals("") ) {
				ArrayList arrChgSeq    = JSPUtil.convertStringToArrayList(payableRentalCostVO.getChgSeq());
				ArrayList arrAgmtCtyCd = JSPUtil.convertStringToArrayList(payableRentalCostVO.getAgmtCtyCd());
				ArrayList arrAgmtSeq   = JSPUtil.convertStringToArrayList(payableRentalCostVO.getAgmtSeq());
				// 다수의 Charge 를 Audit 하므로 Charge Sequence 별로 Detail 의 합계 데이터를 Master 로 Update.
				for ( int i = 0 ; i < arrChgSeq.size() ; i++ ) {
					dbDao.modifyPayableRentalAuditChargeMasterData((String)arrChgSeq.get(i), account.getUsr_id(), (String)arrAgmtCtyCd.get(i), (String)arrAgmtSeq.get(i));
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Payable Rental Charge Create Audit"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Payable Rental Charge Create Audit"}).getMessage(), ex);
		}
	}

	/**
	 * Payable Charge Audit 대상을 백업하고 Audit 이전으로 저장함.<br>
	 *
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public void rejectPayableRentalAuditBasic(PayableRentalCostVO payableRentalCostVO, SignOnUserAccount account) throws EventException {
		PayableRentalCostAuditSearchVO searchVO = payableRentalCostVO.getPayableRentalCostAuditSearchVO();
		String chgCostYrmon = StringUtil.replace(searchVO.getChgCostYrmon().trim(),"-","");
		String usrId        = account.getUsr_id();

		try {
			if ( !searchVO.getChgSeq().equals("") ) {
				ArrayList arrChgSeq    = JSPUtil.convertStringToArrayList(searchVO.getChgSeq());
				ArrayList arrAgmtCtyCd = JSPUtil.convertStringToArrayList(searchVO.getAgmtCtyCd());
				ArrayList arrAgmtSeq   = JSPUtil.convertStringToArrayList(searchVO.getAgmtSeq());

				for ( int i = 0 ; i < arrChgSeq.size() ; i++ ) {
					String agmtCtyCd = (String)arrAgmtCtyCd.get(i);
					String agmtSeq   = (String)arrAgmtSeq.get(i);
					String chgSeq    = (String)arrChgSeq.get(i);

					if ( dbDao.searchPayableRentalChargeRejectMasterData(agmtCtyCd, agmtSeq, chgSeq) ) {
						dbDao.createPayableRentalChargeAuditRejectData(agmtCtyCd, agmtSeq, chgSeq, usrId);
						dbDao.removePayableRentalChargeAuditRejectDetailData(agmtCtyCd, agmtSeq, chgSeq);
						dbDao.modifyPayableRentalChargeAuditRejectDetailData(agmtCtyCd, agmtSeq, chgSeq, usrId);
						dbDao.modifyPayableRentalChargeAuditRejectInvoiceData(agmtCtyCd, agmtSeq, chgCostYrmon, usrId);
						dbDao.modifyPayableRentalChargeAuditRejectMasterData(agmtCtyCd, agmtSeq, chgSeq, usrId);
					}
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Payable Rental Charge Create Audit"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Payable Rental Charge Create Audit"}).getMessage(), ex);
		}
	}

	/**
	 * Payable Charge Audit 완료 된 Charge Creation 데이터를 선택하여 Invoice 생성을 위한 Data 조회<br>
	 *
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @return PayableRentalCostVO
	 * @exception EventException
	 */
	public PayableRentalCostVO searchPayableRentalInvoiceCreateBasic(PayableRentalCostVO payableRentalCostVO) throws EventException {
		PayableRentalCostVO resultVO = null; // 데이터 전송을 위해 VO 객체

		try {
			resultVO = dbDao.searchPayableRentalInvoiceCreateData(payableRentalCostVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Payable Rental Charge Create Invoice Create Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Payable Rental Charge Create Invoice Create Search"}).getMessage(),ex);
		}

		return resultVO;
	}

	/**
	 * Rental payable invoice 처리에 대한 진행 상황을  조회<br>
	 *
	 * @param  PayableRentalInvoiceCostVO payableRentalInvoiceCostVO
	 * @return List<PayableRentalInvoiceCostVO>
	 * @exception EventException
	 */
	public List<PayableRentalInvoiceCostVO> searchPayableRentalInvoiceBasic(PayableRentalInvoiceCostVO payableRentalInvoiceCostVO) throws EventException {
		List<PayableRentalInvoiceCostVO> list = null;
		try {
			list = dbDao.searchPayableRentalInvoiceData(payableRentalInvoiceCostVO);

		} catch(DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"PayableRentalReport Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"PayableRentalReport Search"}).getMessage(),ex);
		}
		return list;
	}

	/**
	 * Operation Lease Payable Invoice Creation Data 조회<br>
	 *
	 * @param String lessorNo
	 * @param String effectiveDate
	 * @param String expireDate
	 * @return PayableRentalCostVO
	 * @exception EventException
	 */
	public PayableRentalCostVO searchOperatingPayableRentalBasic(String lessorNo, String effectiveDate, String expireDate) throws EventException {
		PayableRentalCostVO payableRentalCostVO = null;
		try {
			payableRentalCostVO = dbDao.searchOperatingPayableRentalData(lessorNo, effectiveDate, expireDate);

		} catch(DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Operating Payable Rental Invoice Creation Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Operating Payable Rental Invoice Creation Search"}).getMessage(),ex);
		}
		return payableRentalCostVO;
	}

	/**
	 * Operation Lease Payable Invoice Creation Data 조회<br>
	 *
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageOperatingPayableRentalBasic(PayableRentalCostVO payableRentalCostVO, SignOnUserAccount account) throws EventException {
		PayableRentalCostOperationalInvoiceVO[] payableRentalCostOperationalInvoiceVOs = payableRentalCostVO.getArrPayableRentalCostOperationalInvoiceVO();

		try {
			if ( payableRentalCostOperationalInvoiceVOs.length > 0 ) {
				for ( int i = 0 ; i < payableRentalCostOperationalInvoiceVOs.length ; i++ ) {
					if ( payableRentalCostOperationalInvoiceVOs[i].getIbflag().equals("I") ) {
						payableRentalCostOperationalInvoiceVOs[i].setUsrId(account.getUsr_id());
						dbDao.addOperatingPayableRentalData(payableRentalCostOperationalInvoiceVOs[i]);
					} else if ( payableRentalCostOperationalInvoiceVOs[i].getIbflag().equals("U") ) {
						payableRentalCostOperationalInvoiceVOs[i].setUsrId(account.getUsr_id());
						dbDao.modifyOperatingPayableRentalData(payableRentalCostOperationalInvoiceVOs[i]);
					} else if ( payableRentalCostOperationalInvoiceVOs[i].getIbflag().equals("D") ) {
						dbDao.removeOperatingPayableRentalData(payableRentalCostOperationalInvoiceVOs[i]);
					}
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Operating Payable Rental Invoice Creation SO Creation"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Operating Payable Rental Invoice Creation SO Creation"}).getMessage(), ex);
		}
	}

	/**
	 * Payable Rental Invoice Creation : AP 등록을 위한 Master Data Model 생성<br>
	 *
	 * @param String invNo
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param SignOnUserAccount account
	 * @return ApPayInvVO
	 * @exception EventException
	 */
	public ApPayInvVO makePayableRentalInvoiceCreateMainBasic(String invNo, PayableRentalCostVO payableRentalCostVO, SignOnUserAccount account) throws EventException {
		ApPayInvVO apPayInvVO = new ApPayInvVO();

		try {
			PayableRentalCostCreatVO   payableRentalCostCreatVO  = payableRentalCostVO.getRentalCostCreatVO();
			PayableRentalCostCreatVO[] payableRentalCostCreatVOs = payableRentalCostVO.getPayableRentalCostCreatVO();

			double payAmt = (double) 0.0;

			for ( int i = 0 ; i < payableRentalCostCreatVOs.length ; i++ ) {
				if ( invNo.equals(payableRentalCostCreatVOs[i].getInvNo()) ) {
					payAmt = payAmt + Double.parseDouble(payableRentalCostCreatVOs[i].getPayRntlCostAmt());
				}
			}

			apPayInvVO.setInvSubSysCd("LSE");
			apPayInvVO.setInvOfcCd(payableRentalCostCreatVO.getInvOfcCd());
			apPayInvVO.setCostOfcCd(payableRentalCostCreatVO.getCostOfcCd());
			//apPayInvVO.setVndrSeq(payableRentalCostVO.getVndrSeq());  // 2010.04.26 VNDR_SEQ => PAY_VNDR_SEQ 로 수정. 이유목 수석.
			apPayInvVO.setVndrSeq(payableRentalCostCreatVO.getPayVndrSeq());
			apPayInvVO.setInvNo(invNo);
			apPayInvVO.setInvIssDt(StringUtil.replace(payableRentalCostCreatVO.getInvIssDt().trim(),"-",""));
			apPayInvVO.setInvRcvDt(StringUtil.replace(payableRentalCostCreatVO.getInvRcvDt().trim(),"-",""));
			apPayInvVO.setInvCfmDt(DateTime.getShortDateString());
			apPayInvVO.setVndrTermNm(payableRentalCostCreatVO.getVndrTermNm());
			apPayInvVO.setInvCurrCd(payableRentalCostCreatVO.getCurrCd());
			apPayInvVO.setInvNetAmt(Double.toString(payAmt));
			apPayInvVO.setInvVatAmt("0");
			apPayInvVO.setWhldTaxAmt("0");
			apPayInvVO.setInvTtlAmt(Double.toString(payAmt));
			apPayInvVO.setEqTpCd("U");
			apPayInvVO.setInvRmk(payableRentalCostCreatVO.getInvRmk());
			apPayInvVO.setInvStsCd("C");
			apPayInvVO.setDeltFlg("N");
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Payable Rental Invoice Creation"}).getMessage(), ex);
		}

		return apPayInvVO;
	}

	/**
	 * Payable Rental Invoice Creation : AP 등록을 위한 Detail Data Model 생성<br>
	 *
	 * @param String invNo
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param SignOnUserAccount account
	 * @return ApPayInvDtlVO[]
	 * @exception EventException
	 */
	public ApPayInvDtlVO[] makePayableRentalInvoiceCreateDetailBasic(String invNo, PayableRentalCostVO payableRentalCostVO, SignOnUserAccount account) throws EventException {
		PayableRentalCostInvoiceCreateVO[] payableRentalCostInvoiceCreateVOs = payableRentalCostVO.getArrPayableRentalCostInvoiceCreateVO();
		List<ApPayInvDtlVO> apPayInvDtlVOList = new ArrayList<ApPayInvDtlVO>();
		ApPayInvDtlVO[] apPayInvDtlVOs = null;

		try {
			for ( int i = 0; i < payableRentalCostInvoiceCreateVOs.length; i++ ) {
				if ( invNo.equals(payableRentalCostInvoiceCreateVOs[i].getInvNo()) ) {
					ApPayInvDtlVO dtlVO = new ApPayInvDtlVO();
					PayableRentalCostInvoiceCreateVO payableRentalCostInvoiceCreateVO = payableRentalCostInvoiceCreateVOs[i];

					dtlVO.setLgsCostCd(payableRentalCostInvoiceCreateVO.getCostCd());
					dtlVO.setAcctCd(payableRentalCostInvoiceCreateVO.getAcctCd());
					dtlVO.setVslCd(payableRentalCostInvoiceCreateVO.getVvd().substring(0, 4));
					dtlVO.setSkdVoyNo(payableRentalCostInvoiceCreateVO.getVvd().substring(4, 8));
					dtlVO.setSkdDirCd(payableRentalCostInvoiceCreateVO.getVvd().substring(8, 9));
					dtlVO.setRevDirCd(payableRentalCostInvoiceCreateVO.getVvd().substring(9));
					dtlVO.setSlanCd("CNT");
					dtlVO.setCntrTpszCd(payableRentalCostInvoiceCreateVO.getCntrTpszCd());
					double payAmt = (double) 0.0;
					payAmt = Double.parseDouble(payableRentalCostInvoiceCreateVO.getTtlCostAmt()) + Double.parseDouble(payableRentalCostInvoiceCreateVO.getCrAmt());
					dtlVO.setInvAmt(payAmt+"");
					dtlVO.setDeltFlg("N");
					dtlVO.setIbflag("I");

					apPayInvDtlVOList.add(dtlVO);
				}
			}

			apPayInvDtlVOs = apPayInvDtlVOList.toArray(new ApPayInvDtlVO[apPayInvDtlVOList.size()]);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Payable Rental Invoice Creation"}).getMessage(), ex);
		}

		return apPayInvDtlVOs;
	}

	/**
	 * Payable Rental Invoice Creation : AP 등록 후 Register No. Update<br>
	 *
	 * @param String invNo
	 * @param String invRgstNo
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyPayableRentalInvoiceBasic(String invNo, String invRgstNo, PayableRentalCostVO payableRentalCostVO, SignOnUserAccount account) throws EventException {
		PayableRentalCostCreatVO[] payableRentalCostCreatVOs = payableRentalCostVO.getPayableRentalCostCreatVO();
		String chgSeqs = "";

		try {
			for ( int i = 0 ; i < payableRentalCostCreatVOs.length ; i++ ) {
				if ( invNo.equals(payableRentalCostCreatVOs[i].getInvNo()) ) {
					if ( chgSeqs.equals("") ) {
						chgSeqs = payableRentalCostCreatVOs[i].getChgSeq();
					} else {
						chgSeqs = chgSeqs + "|" + payableRentalCostCreatVOs[i].getChgSeq();
					}
				}
			}

			dbDao.modifyPayableRentalChargeInvoiceData(invNo, invRgstNo, chgSeqs, account.getUsr_id(), (payableRentalCostVO.getRentalCostCreatVO()).getPayVndrSeq());

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Payable Rental Invoice Creation"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Payable Rental Invoice Creation"}).getMessage(), ex);
		}
	}

	/**
	 * Payable Rental Invoice Creation : Invoice Create 생성 일괄작업(BackEndJob) 수행<br>
	 *
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String createPayableRentalInvoiceBasic(PayableRentalCostVO payableRentalCostVO, SignOnUserAccount account) throws EventException {
		PayableRentalCostBackEndJob backEndJob = new PayableRentalCostBackEndJob();
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		try {
			payableRentalCostVO.setOfcCd(account.getOfc_cd());
			payableRentalCostVO.setUsrId(account.getUsr_id());
			backEndJob.setJobType("IVN_CRE");
			backEndJob.setPayableRentalCostVO(payableRentalCostVO);
			backEndJob.setAccount(account);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Payable Rental Invoice Creation"}).getMessage(), ex);
		}

		return backEndJobManager.execute(backEndJob, account.getUsr_id(), "Payable Charge Creation : Invoice Create");
	}

	/**
	 * Operating Payable Rental Invoice Creation : Invoice Create 생성 일괄작업(BackEndJob) 수행<br>
	 *
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String createOperatingPayableRentalInvoiceBasic(PayableRentalCostVO payableRentalCostVO, SignOnUserAccount account) throws EventException {
		PayableRentalCostBackEndJob backEndJob = new PayableRentalCostBackEndJob();
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		try {
			payableRentalCostVO.setOfcCd(account.getOfc_cd());
			payableRentalCostVO.setUsrId(account.getUsr_id());
			backEndJob.setJobType("OP_IVN_CRE");
			backEndJob.setPayableRentalCostVO(payableRentalCostVO);
			backEndJob.setAccount(account);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Operating Payable Rental Invoice Creation"}).getMessage(), ex);
		}
		return backEndJobManager.execute(backEndJob, account.getUsr_id(), "Operating Payable Charge Creation : Invoice Create");
	}

	/**
	 * Operating Payable Rental Invoice Creation : AP 등록을 위한 Master Data Model 생성<br>
	 *
	 * @param String invNo
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param SignOnUserAccount account
	 * @return ApPayInvVO
	 * @exception EventException
	 */
	public ApPayInvVO makeOperatingPayableRentalInvoiceCreateMainBasic(String invNo, PayableRentalCostVO payableRentalCostVO, SignOnUserAccount account) throws EventException {
		ApPayInvVO apPayInvVO = new ApPayInvVO();

		try {
			PayableRentalCostCreatVO   payableRentalCostCreatVO  = payableRentalCostVO.getRentalCostCreatVO();
			PayableRentalCostOperationalInvoiceVO[] costOperationalInvoiceVOs = payableRentalCostVO.getArrPayableRentalCostOperationalInvoiceVO();

			double payAmt = (double) 0.0;
			String vndrSeq = "";

			for ( int i = 0 ; i < costOperationalInvoiceVOs.length ; i++ ) {
				if ( invNo.equals(costOperationalInvoiceVOs[i].getInvNo()) ) {
					payAmt = payAmt + Double.parseDouble(costOperationalInvoiceVOs[i].getPayAmt());
					vndrSeq = costOperationalInvoiceVOs[i].getVndrSeq();
				}
			}

			apPayInvVO.setInvSubSysCd("LSE");
			//apPayInvVO.setInvOfcCd(payableRentalCostCreatVO.getOffcCd());
			apPayInvVO.setInvOfcCd(payableRentalCostCreatVO.getInvOfcCd());
			//apPayInvVO.setCostOfcCd(payableRentalCostCreatVO.getOffcCd());
			apPayInvVO.setCostOfcCd(payableRentalCostCreatVO.getCostOfcCd());
			//apPayInvVO.setVndrSeq(payableRentalCostVO.getVndrSeq());
			apPayInvVO.setVndrSeq(vndrSeq);
			apPayInvVO.setInvNo(invNo);
			apPayInvVO.setInvIssDt(StringUtil.replace(payableRentalCostCreatVO.getInvIssDt().trim(),"-",""));
			apPayInvVO.setInvRcvDt(StringUtil.replace(payableRentalCostCreatVO.getInvRcvDt().trim(),"-",""));
			//apPayInvVO.setInvEffDt(StringUtil.replace(payableRentalCostCreatVO.getInvEffDt().trim(),"-",""));
			apPayInvVO.setInvCfmDt(DateTime.getShortDateString());
			apPayInvVO.setVndrTermNm(payableRentalCostCreatVO.getVndrTermNm());
			apPayInvVO.setInvCurrCd(payableRentalCostCreatVO.getCurrCd());
			apPayInvVO.setInvNetAmt(payAmt+"");
			apPayInvVO.setInvVatAmt("0");
			apPayInvVO.setWhldTaxAmt("0");
			apPayInvVO.setInvTtlAmt(payAmt+"");
			apPayInvVO.setEqTpCd("U");
			apPayInvVO.setInvRmk(payableRentalCostCreatVO.getInvRmk());
			apPayInvVO.setInvStsCd("C");
			apPayInvVO.setDeltFlg("N");
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Operating Payable Rental Invoice Creation"}).getMessage(), ex);
		}
		return apPayInvVO;
	}

	/**
	 * Operating Payable Rental Invoice Creation : AP 등록을 위한 Detail Data Model 생성<br>
	 *
	 * @param String invNo
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param SignOnUserAccount account
	 * @return ApPayInvDtlVO[]
	 * @exception EventException
	 */
	public ApPayInvDtlVO[] makeOperatingPayableRentalInvoiceCreateDetailBasic(String invNo, PayableRentalCostVO payableRentalCostVO, SignOnUserAccount account) throws EventException {
		PayableRentalCostInvoiceCreateVO[] payableRentalCostInvoiceCreateVOs = payableRentalCostVO.getArrPayableRentalCostInvoiceCreateVO();
		List<ApPayInvDtlVO> apPayInvDtlVOList = new ArrayList<ApPayInvDtlVO>();
		ApPayInvDtlVO[] apPayInvDtlVOs = null;

		try {
			for ( int i = 0 ; i < payableRentalCostInvoiceCreateVOs.length; i++ ) {
				if ( invNo.equals(payableRentalCostInvoiceCreateVOs[i].getInvNo()) ) {
					ApPayInvDtlVO dtlVO = new ApPayInvDtlVO();
					PayableRentalCostInvoiceCreateVO payableRentalCostInvoiceCreateVO = payableRentalCostInvoiceCreateVOs[i];

					dtlVO.setLgsCostCd(payableRentalCostInvoiceCreateVO.getCostCd());
					dtlVO.setAcctCd(payableRentalCostInvoiceCreateVO.getAcctCd());
					dtlVO.setVslCd(payableRentalCostInvoiceCreateVO.getVvd().substring(0, 4));
					dtlVO.setSkdVoyNo(payableRentalCostInvoiceCreateVO.getVvd().substring(4, 8));
					dtlVO.setSkdDirCd(payableRentalCostInvoiceCreateVO.getVvd().substring(8, 9));
					dtlVO.setRevDirCd(payableRentalCostInvoiceCreateVO.getVvd().substring(9));
					dtlVO.setSlanCd("CNT");
					dtlVO.setCntrTpszCd(payableRentalCostInvoiceCreateVO.getCntrTpszCd());
					double payAmt = (double) 0.0;
					payAmt = Double.parseDouble(payableRentalCostInvoiceCreateVO.getTtlCostAmt()) - Double.parseDouble(payableRentalCostInvoiceCreateVO.getCrAmt());
					dtlVO.setInvAmt(payAmt+"");
					dtlVO.setDeltFlg("N");
					dtlVO.setIbflag("I");

					apPayInvDtlVOList.add(dtlVO);
				}
			}

			apPayInvDtlVOs = apPayInvDtlVOList.toArray(new ApPayInvDtlVO[apPayInvDtlVOList.size()]);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Operating Payable Rental Invoice Creation"}).getMessage(), ex);
		}

		return apPayInvDtlVOs;
	}

	/**
	 * Operating Payable Rental Invoice Creation : AP 등록 후 Register No. Update<br>
	 *
	 * @param String invNo
	 * @param String invRgstNo
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyOperatingPayableRentalInvoiceBasic(String invNo, String invRgstNo, PayableRentalCostVO payableRentalCostVO, SignOnUserAccount account) throws EventException {
		PayableRentalCostOperationalInvoiceVO[] payableRentalCostCreatVOs = payableRentalCostVO.getArrPayableRentalCostOperationalInvoiceVO();
		String opSeqs = "";

		try {
			for ( int i = 0 ; i < payableRentalCostCreatVOs.length ; i++ ) {
				if ( invNo.equals(payableRentalCostCreatVOs[i].getInvNo()) ) {
					if ( opSeqs.equals("") ) {
						opSeqs = payableRentalCostCreatVOs[i].getOpSeq();
					} else {
						opSeqs = opSeqs + "|" + payableRentalCostCreatVOs[i].getOpSeq();
					}
				}
			}

			dbDao.modifyOperatingPayableRentalChargeInvoiceData(invNo, invRgstNo, opSeqs, account.getUsr_id());

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Payable Rental Invoice Creation"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Payable Rental Invoice Creation"}).getMessage(), ex);
		}
	}

	/**
	 * Payable invoice 를 Cancel 처리함<br>
	 *
	 * @param PayableRentalInvoiceCostVO[] payableRentalInvoiceCostVOS
	 * @exception EventException
	 */
	public void modifyPayableRentalChargeBasic (PayableRentalInvoiceCostVO[] payableRentalInvoiceCostVOS ) throws EventException {
	     try {
	    	 for(int i=0; i < payableRentalInvoiceCostVOS.length; i++){
	    		 if ( payableRentalInvoiceCostVOS[i].getChgTp().equals("O") ) {
	    			 dbDao.modifyOperationPayableRentalChargeInvoiceCancelData(payableRentalInvoiceCostVOS[i]);
	    		 } else {
	    			 dbDao.modifyPayableRentalChargeInvoiceCancelData(payableRentalInvoiceCostVOS[i]);
	    		 }
	    	 }
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Payable Rental Invoice Cancel"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Payable Rental Invoice Cancel"}).getMessage(), ex);
		}
	}

	/**
	 * Payable Charge Audit 할 대상을 조회하는 Back End Job 실행.<br>
	 *
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param SignOnUserAccount userAccount
	 * @return String
	 * @exception EventException
	 */
	public String searchPayableRentalChargeAuditBackEndBasic(PayableRentalCostVO payableRentalCostVO, SignOnUserAccount userAccount) throws EventException {
		PayableRentalCostAuditBackEndJob backEndJob = new PayableRentalCostAuditBackEndJob();
		backEndJob.setJobType("SearchPayableRentalAuditList");
		backEndJob.setPayableRentalCostVO(payableRentalCostVO);
		BackEndJobManager backEndJobManager = new BackEndJobManager();

		try {
			return backEndJobManager.execute(backEndJob, userAccount.getUsr_id(), "PayableRentalChargeAudit BackEndJob");
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"PayableRentalChargeAudit BackEndJob"}).getMessage(),ex);
		}
	}
	
	/**
	 * CSR Agreement Info List
	 * @param String csrNo
	 * @return List<ComCsrRequestAgmtVO>
	 */
	public List<ComCsrRequestAgmtVO> printComCsrLseAgmtInfo(String csrNo) throws EventException {
		try {
			return dbDao.printComCsrLseAgmtInfo(csrNo);
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage());
		}
	}
	
	
	/**
	 * CSR Agreement Info List
	 * @param String csrNo
	 * @return List<ComCsrRequestAgmtVO>
	 */
	public List<ComCsrRequestAgmtVO> printComCsrAgmtInfo2(String csrNo) throws EventException {
		try {
			return dbDao.printComCsrAgmtInfo2(csrNo);
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage());
		}
	}
}