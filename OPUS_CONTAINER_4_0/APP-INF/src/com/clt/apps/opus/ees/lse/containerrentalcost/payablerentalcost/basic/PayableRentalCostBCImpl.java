/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PayableRentalCostBCImpl.java
*@FileTitle : EQ Payable Charge Summary
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.basic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import com.clt.syscommon.common.util.RemoveUTF8BOMUtil;
import com.clt.syscommon.common.util.ScheduleUtil;
import com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.integration.PayableRentalCostDBDAO;
import com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostAuditSearchVO;
import com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostAuditVO;
import com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostCreatVO;
import com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostInvoiceCreateVO;
import com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostOperationalInvoiceVO;
import com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostVO;
import com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalInvoiceCostVO;
import com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.vo.ReportSearchPayableVO;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.backend.support.BackEndJobException;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.DateTime;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.util.StringUtil;
import com.clt.framework.core.config.SiteConfigFactory;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.ApPayInvDtlVO;
import com.clt.syscommon.common.table.ApPayInvVO;
import com.clt.syscommon.common.table.LsePayRntlChgCoVO;

/**
 * ContainerRentalCost Business Logic Basic Command implementation<br>
 *
 * @author  
 * @see EES_LSE_0060EventResponse,PayableRentalCostBC
 * @since J2EE 1.6
 */
public class PayableRentalCostBCImpl extends BasicCommandSupport implements PayableRentalCostBC {

	// Database Access Object
	private transient PayableRentalCostDBDAO dbDao = null;

	/**
	 * creating PayableRentalCostBCImpl object<br>
	 * creating PayableRentalCostDBDAO<br>
	 */
	public PayableRentalCostBCImpl() {
		dbDao = new PayableRentalCostDBDAO();
	}
	/**
	 * retrieving for Payable Invoice<br>
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
	 * saving Payable Rental Lessor Invoice File import<br>
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
				String vndrSeq	   = payableRentalCostVO.getVndrSeq();

				//br = new BufferedReader(new FileReader(new File(uploadPath + "/" + payableRentalCostVO.getUploadFileNm())));
				
				br = new BufferedReader(new InputStreamReader(new FileInputStream(uploadPath  + payableRentalCostVO.getUploadFileNm()), "UTF8"));
				
				int i = 0;

				List<LsePayRntlChgCoVO> insModels = new ArrayList<LsePayRntlChgCoVO>();

				String line = null;

				while ( (line = br.readLine()) != null ) {
					// If File Type
					
					RemoveUTF8BOMUtil removeUTF8BOMUtil = new RemoveUTF8BOMUtil();
					line = removeUTF8BOMUtil.removeUTF8BOM(line);					
					if ( fileType.equals("TXT") ) {
						if ( i == 0 ) {
							if ( line.trim().length() > 9 ) {

								// Invoice No.
								invNo  = line.substring(3, 17).trim();
								// Contract No.
								ctrtNo = line.substring(17, 32).trim();

								
								// Agreement retrieve
								String[] agmtNo = dbDao.searchAgreementNoByCtrtNoData(ctrtNo.trim(), coCostYrmon);

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

									/* in case of Audited Charge Creation existing, File Import disable */
									boolean auditYN = dbDao.searchPayableRentalChargeHeaderData(agmtCytCd, agmtSeq, coCostYrmon);
									if ( auditYN ) {
										result[0] = "The Invoice already processed.  Please check again.";
										result[1] = "";
										result[2] = "";
										break;
									} else {
										/* else, removing */
										if ( !agmtNo[1].equals("") && agmtNo[1].length() > 3
										  && !coCostYrmon.equals("") && coCostYrmon.length() == 6) {
											dbDao.removePayableLessorInvoiceImportData(agmtCytCd, agmtSeq, coCostYrmon);
										}

										/* PAY_IMP_SEQ  */
										payImpSeq = dbDao.searchNewPayImpSeqData(coCostYrmon);
									}
								} else {
									result[0] = new ErrorHandler("LSE10005", new String[]{"Invoice File Import"}).getMessage(); //"Service Not available.";
									result[1] = "";
									result[2] = "";
									break;
								}

								// Invoice No. Dup Check
								if(!invNo.equals("")){
									String strdDupInvNoChk = "";
									strdDupInvNoChk = dbDao.checkInvoiceNo(invNo, vndrSeq, agmtSeq, coCostYrmon);
									if(!"".equals(strdDupInvNoChk)) {
										//result[0] = new ErrorHandler("CSR10005", new String[]{invNo}).getUserMessage(); //"Invoice No[$s] is not unique for this module";
										result[0] = strdDupInvNoChk;
										result[1] = "";
										result[2] = "";
										break; 
									}
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
					
					String strDubCntrNoCheck = "";
					strDubCntrNoCheck = dbDao.searchPayableLessorInvoiceImportData(agmtCytCd, agmtSeq, coCostYrmon, invNo);
					
					//There are duplicate container/charge type found 시 데이타 삭제
					if(!"".equals(strDubCntrNoCheck)) {
						dbDao.removePayableLessorInvoiceImportData(agmtCytCd, agmtSeq, coCostYrmon);
						result[0] = strDubCntrNoCheck;
						result[1] = new StringBuilder(agmtCytCd).append(agmtSeq).toString();
						result[2] = ctrtNo;
					} else {
						// in case of self Charge Creation data existing, updating INV_NO of LSE_PAY_RNTL_CHG Table
						//dbDao.modifyPayableLessorInvoiceImportData(coCostYrmon, agmtCytCd, agmtSeq, invNo, account.getUsr_id());
						dbDao.modifyPayableRentalChargeMasterInvoiceNoData("", coCostYrmon, agmtCytCd, agmtSeq, invNo, account.getUsr_id());						
					}
					
				}
			}
		} catch (FileNotFoundException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Payable Rental Lessor Invoice File Import"}).getMessage(), ex);
		} catch (DAOException ex) {
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
				if(br != null) {
					br.close();
				}
			}catch (FileNotFoundException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("LSE10005",new String[]{"Payable Rental Lessor Invoice File Import"}).getMessage(), ex);
			}catch (IOException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("LSE10005",new String[]{"Payable Rental Lessor Invoice File Import"}).getMessage(), ex);
			}
		}

		return result;
	}

	/**
	 * retrieving for Payable Rental Lessor Invoice File import<br>
	 *
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @return PayableRentalCostVO
	 * @exception EventException
	 */
	public PayableRentalCostVO searchPayableLessorInvoiceBasic(PayableRentalCostVO payableRentalCostVO) throws EventException {
		PayableRentalCostVO resultVO = null; 

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
	 * retrieving for Payable Charge Creation target Agreement<br>
	 *
	 * @param String costMonth
	 * @param String lessorNo
	 * @param String lstmCd
	 * @param String lsePayTpCd
	 * @return PayableRentalCostVO
	 * @exception EventException
	 */
	public PayableRentalCostVO searchPayableRentalBasic(String costMonth, String lessorNo, String lstmCd, String lsePayTpCd) throws EventException {
		PayableRentalCostVO resultVO = null; 

		try {
			resultVO = dbDao.searchPayableRentalData(costMonth, lessorNo, lstmCd, lsePayTpCd);
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
	 * creating Payable Rental Charge Creation(BackEndJob)<br>
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
	 * retrieving for Payable Rental Charge Creation (BackEndJob)<br>
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
	 * retrieving for BackEndJob result<br>
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
	 * saving Invoice No of Charge Creation data<br>
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
	 * retrieving for Payable Charge Audit<br>
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
					// self Charge Only
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
	 * loading BackEndJob result file<br>
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
					// self Charge Only
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
	 * saving Payable Charge Audit to Audit complete<br>
	 *
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public void createPayableRentalAuditBasic(PayableRentalCostVO payableRentalCostVO, SignOnUserAccount account) throws EventException {
		PayableRentalCostAuditVO[] payableRentalCostAuditVO = payableRentalCostVO.getPayableRentalCostAuditVO();

		try {
			/* objects for Lease Agreement Drop Office Description */
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
						/* modifying to Audit complete.  */
						if ( payableRentalCostAuditVO[i].getCntrAudStsCd().equals("L") ) {
							payableRentalCostAuditVO[i].setCntrAudStsCd("A");

							/* inserting Lessor Only(L) to Audit */
							insertVos.add(payableRentalCostAuditVO[i]);
						} else if ( !payableRentalCostAuditVO[i].getCntrAudStsCd().equals("A") ) {
							payableRentalCostAuditVO[i].setCntrAudStsCd("A");

							/* modifying Coincidence, Discrepancy, self Only to Audit  */
							modifyVos.add(payableRentalCostAuditVO[i]);
						}
					} else if ( payableRentalCostAuditVO[i].getIbflag().equals("I") ) {
						payableRentalCostAuditVO[i].setCntrAudStsCd("A");

						insertVos.add(payableRentalCostAuditVO[i]);
					} else if ( payableRentalCostAuditVO[i].getIbflag().equals("U") ) {
						/* 1. moditying Audit(A), Coincedance(D), Discrepance(D) or Only(H)
                         * 2. inserting Lessor Only(L) */
						if ( payableRentalCostAuditVO[i].getCntrAudStsCd().equals("L") ) {
							payableRentalCostAuditVO[i].setCntrAudStsCd("A");

							insertVos.add(payableRentalCostAuditVO[i]);

							/* in case of Charge Type Code of Lessor Inovice File is Code not used
							 * updating Lessor Inovice File Data */
							if ( !payableRentalCostAuditVO[i].getLsePayChgTpCd().equals(payableRentalCostAuditVO[i].getLsePayChgTpNm()) ) {
								LsePayRntlChgCoVO vo = new LsePayRntlChgCoVO();

								vo.setCoCostYrmon(payableRentalCostAuditVO[i].getChgCostYrmon());
								vo.setCntrNo(payableRentalCostAuditVO[i].getCntrNo());
								// Setting Original Charge Type of  Lessor Invoice File
								vo.setLsePayChgTpCd(payableRentalCostAuditVO[i].getLsePayChgTpNm());
								// Setting Charge Type changed by Coincidence
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
						/* 1. only Audit complete Data 
						 * 2. Coincidence Data has no work to do */
						if ( payableRentalCostAuditVO[i].getCntrAudStsCd().equals("A") ) {
							if ( payableRentalCostAuditVO[i].getPayChgStsCd().equals("A") ) {
								// removing manual input data
								removeVos.add(payableRentalCostAuditVO[i]);
							} else if ( payableRentalCostAuditVO[i].getPayChgStsCd().equals("D")
									 || payableRentalCostAuditVO[i].getPayChgStsCd().equals("H") ) {
								// Discrepancy, self Only 
								payableRentalCostAuditVO[i].setCntrAudStsCd("H");
								payableRentalCostAuditVO[i].setDscrOnhDt("");
								payableRentalCostAuditVO[i].setDscrOnhLocCd("");
								payableRentalCostAuditVO[i].setDscrOffhDt("");
								payableRentalCostAuditVO[i].setDscrOffhLocCd("");
								payableRentalCostAuditVO[i].setDscrPdRtAmt("0.0");
								payableRentalCostAuditVO[i].setDscrCostAmt("0.0");

								modifyVos.add(payableRentalCostAuditVO[i]);
							} else if ( payableRentalCostAuditVO[i].getPayChgStsCd().equals("L") ) {
								/* removing Audit complete Data & Lessor Only  */
								removeVos.add(payableRentalCostAuditVO[i]);

								/* Charge Type rollback */
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
				// not using ExecuteBatch for getting Detai Sequence 
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
				// updating total data for each Charge Sequence to master
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
	 * back up Payable Charge Audit<br>
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
					//	dbDao.createPayableRentalChargeAuditRejectData(agmtCtyCd, agmtSeq, chgSeq, usrId);
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
	 * retrieving for Audit complete Charge Creation data<br>
	 *
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @return PayableRentalCostVO
	 * @exception EventException
	 */
	public PayableRentalCostVO searchPayableRentalInvoiceCreateBasic(PayableRentalCostVO payableRentalCostVO) throws EventException {
		PayableRentalCostVO resultVO = null; 

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
	 * retrieving for Rental payable invoice<br>
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
	 * etrieving for Operation lease Invoice Creation<br>
	 *
	 * @param String lessorNo
	 * @param String effectiveDate
	 * @param String expireDate
	 * @param String agmtSeq
	 * @return PayableRentalCostVO
	 * @exception EventException
	 */
	public PayableRentalCostVO searchOperatingPayableRentalBasic(String lessorNo, String effectiveDate, String expireDate, String agmtSeq) throws EventException {
		PayableRentalCostVO payableRentalCostVO = null;
		try {
			payableRentalCostVO = dbDao.searchOperatingPayableRentalData(lessorNo, effectiveDate, expireDate, agmtSeq);

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
	 * saving Operation lease Invoice Creation<br>
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
	 * Payable Rental Invoice Creation : creating Master Data Model for regstering AP<br>
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
			double payAmt1 = (double) 0.0;
			double vatAmt = (double) 0.0;
			double whldTaxAmt = (double) 0.0;
			
			for ( int i = 0 ; i < payableRentalCostCreatVOs.length ; i++ ) {
				if ( invNo.equals(payableRentalCostCreatVOs[i].getInvNo()) ) {
					payAmt = payAmt + Double.parseDouble(payableRentalCostCreatVOs[i].getPayRntlCostAmt());
					
					if (payableRentalCostCreatVOs[i].getInvVatAmt() == null || "".equals(payableRentalCostCreatVOs[i].getInvVatAmt())){
						payableRentalCostCreatVOs[i].setInvVatAmt("0");
					}							
					vatAmt = vatAmt + Double.parseDouble(payableRentalCostCreatVOs[i].getInvVatAmt().replaceAll(",", ""));
					if (payableRentalCostCreatVOs[i].getWhldTaxAmt() == null || "".equals(payableRentalCostCreatVOs[i].getWhldTaxAmt())){
						payableRentalCostCreatVOs[i].setWhldTaxAmt("0");
					}					
					whldTaxAmt = whldTaxAmt + Double.parseDouble(payableRentalCostCreatVOs[i].getWhldTaxAmt().replaceAll(",", "")); 	
				}
			}
			
			payAmt1 = ( vatAmt + payAmt)- whldTaxAmt;
			
			apPayInvVO.setInvSubSysCd("LSE");
			apPayInvVO.setInvOfcCd(payableRentalCostCreatVO.getInvOfcCd());
			apPayInvVO.setCostOfcCd(payableRentalCostCreatVO.getCostOfcCd());
			//apPayInvVO.setVndrSeq(payableRentalCostVO.getVndrSeq());  
			apPayInvVO.setVndrSeq(payableRentalCostCreatVO.getPayVndrSeq());
			apPayInvVO.setInvNo(invNo);
			apPayInvVO.setInvIssDt(StringUtil.replace(payableRentalCostCreatVO.getInvIssDt().trim(),"-",""));
			apPayInvVO.setInvRcvDt(StringUtil.replace(payableRentalCostCreatVO.getInvRcvDt().trim(),"-",""));
			apPayInvVO.setInvCfmDt(DateTime.getShortDateString());
			apPayInvVO.setVndrTermNm(payableRentalCostCreatVO.getVndrTermNm());
			apPayInvVO.setInvCurrCd(payableRentalCostCreatVO.getCurrCd());
			apPayInvVO.setInvNetAmt(Double.toString(payAmt));
			apPayInvVO.setInvVatAmt(Double.toString(vatAmt));
			apPayInvVO.setWhldTaxAmt(Double.toString(whldTaxAmt));
			apPayInvVO.setInvTtlAmt(Double.toString(payAmt1));
			apPayInvVO.setEqTpCd("U");
			apPayInvVO.setInvRmk(payableRentalCostCreatVO.getInvRmk());
			apPayInvVO.setInvStsCd("C");
			apPayInvVO.setDeltFlg("N");
			//apPayInvVO.setActDt(StringUtil.replace(payableRentalCostCreatVO.getInvIssDt().trim(),"-",""));	
			
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Payable Rental Invoice Creation"}).getMessage(), ex);
		}

		return apPayInvVO;
	}

	/**
	 * Payable Rental Invoice Creation : creating Detail Data Model for regstering AP<br>
	 *
	 * @param String invNo
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param SignOnUserAccount account
	 * @return ApPayInvDtlVO[]
	 * @exception EventException
	 */
	public ApPayInvDtlVO[] makePayableRentalInvoiceCreateDetailBasic(String invNo, PayableRentalCostVO payableRentalCostVO, SignOnUserAccount account) throws EventException {
		PayableRentalCostInvoiceCreateVO[] payableRentalCostInvoiceCreateVOs = payableRentalCostVO.getArrPayableRentalCostInvoiceCreateVO();
		//PayableRentalCostCreatVO   payableRentalCostCreatVO  = payableRentalCostVO.getRentalCostCreatVO();
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
					dtlVO.setActPlc(account.getOfc_cd());
					dtlVO.setActDt(DateTime.getShortDateString().substring(0, 2) + payableRentalCostInvoiceCreateVO.getVvd().substring(4, 8)+"01");
					//dtlVO.setActDt(StringUtil.replace(payableRentalCostCreatVO.getInvIssDt().trim(),"-",""));
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
	 * Payable Rental Invoice Creation : updating Register No. after registering AP<br>
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
	 * Payable Rental Invoice Creation : sanving Invoice Creation Data on CSR Temp Table(BackEndJob)<br>
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
	 * Operating Payable Rental Invoice Creation : creating Invoice Creation Data on CSR Temp Table<(BackEndJob)<br>
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
	 * Operating Payable Rental Invoice Creation <br>
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

			String vndrSeq = "";

			double payAmt = (double) 0.0;
			double payAmt1 = (double) 0.0;
			double vatAmt = (double) 0.0;
			double whldTaxAmt = (double) 0.0;
			
			
			for ( int i = 0 ; i < costOperationalInvoiceVOs.length ; i++ ) {
				if ( invNo.equals(costOperationalInvoiceVOs[i].getInvNo()) ) {
					payAmt = payAmt + Double.parseDouble(costOperationalInvoiceVOs[i].getPayAmt());
					vndrSeq = costOperationalInvoiceVOs[i].getVndrSeq();		
					if (costOperationalInvoiceVOs[i].getInvVatAmt() == null || "".equals(costOperationalInvoiceVOs[i].getInvVatAmt())){
						costOperationalInvoiceVOs[i].setInvVatAmt("0");
					}
					vatAmt = vatAmt + Double.parseDouble(costOperationalInvoiceVOs[i].getInvVatAmt().replaceAll(",", ""));	
					
					if (costOperationalInvoiceVOs[i].getWhldTaxAmt() == null || "".equals(costOperationalInvoiceVOs[i].getWhldTaxAmt())){
						costOperationalInvoiceVOs[i].setWhldTaxAmt("0");
					}
					whldTaxAmt = whldTaxAmt + Double.parseDouble(costOperationalInvoiceVOs[i].getWhldTaxAmt().replaceAll(",", "")); 					
				}								
			}

			
			payAmt1 = ( vatAmt + payAmt)- whldTaxAmt;
			
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
			
			apPayInvVO.setInvNetAmt(Double.toString(payAmt));
			apPayInvVO.setInvVatAmt(Double.toString(vatAmt));
			apPayInvVO.setWhldTaxAmt(Double.toString(whldTaxAmt));
			apPayInvVO.setInvTtlAmt(Double.toString(payAmt1));
			
			apPayInvVO.setEqTpCd("U");
			apPayInvVO.setInvRmk(payableRentalCostCreatVO.getInvRmk());
			apPayInvVO.setInvStsCd("C");
			apPayInvVO.setDeltFlg("N");
			//apPayInvVO.setActDt(StringUtil.replace(payableRentalCostCreatVO.getInvIssDt().trim(),"-",""));			
			
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Operating Payable Rental Invoice Creation"}).getMessage(), ex);
		}
		return apPayInvVO;
	}

	/**
	 * Operating Payable Rental Invoice Creation : creating Detail Data Model for regstering AP<br>
	 *
	 * @param String invNo
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param SignOnUserAccount account
	 * @return ApPayInvDtlVO[]
	 * @exception EventException
	 */
	public ApPayInvDtlVO[] makeOperatingPayableRentalInvoiceCreateDetailBasic(String invNo, PayableRentalCostVO payableRentalCostVO, SignOnUserAccount account) throws EventException {
		PayableRentalCostInvoiceCreateVO[] payableRentalCostInvoiceCreateVOs = payableRentalCostVO.getArrPayableRentalCostInvoiceCreateVO();
		//PayableRentalCostCreatVO   payableRentalCostCreatVO  = payableRentalCostVO.getRentalCostCreatVO();
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
					dtlVO.setActPlc(account.getOfc_cd());
					dtlVO.setActDt(DateTime.getShortDateString().substring(0, 2) + payableRentalCostInvoiceCreateVO.getVvd().substring(4, 8)+"01");
					//dtlVO.setActDt(StringUtil.replace(payableRentalCostCreatVO.getInvIssDt().trim(),"-",""));
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
	 * Operating Payable Rental Invoice Creation : updating Register No. after registering AP<br>
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
        String vndrSeq = "";
		try {
			for ( int i = 0 ; i < payableRentalCostCreatVOs.length ; i++ ) {
				if ( invNo.equals(payableRentalCostCreatVOs[i].getInvNo()) ) {
					if ( opSeqs.equals("") ) {
						opSeqs = payableRentalCostCreatVOs[i].getOpSeq();
						vndrSeq = payableRentalCostCreatVOs[i].getVndrSeq();
					} else {
						opSeqs = opSeqs + "|" + payableRentalCostCreatVOs[i].getOpSeq();
					}
				}
			}

			dbDao.modifyOperatingPayableRentalChargeInvoiceData(invNo, invRgstNo, opSeqs, account.getUsr_id(), vndrSeq);

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Payable Rental Invoice Creation"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Payable Rental Invoice Creation"}).getMessage(), ex);
		}
	}

	/**
	 * modifying Payable invoice to Cancel <br>
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
	 * retrieving for Audit target(BackEndJob)<br>
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
	 * Charge Creation Batch
	 * 
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param SignOnUserAccount userAccount
	 * @return String
	 * @throws EventException
	 */
	public String createPayableRentalChargeCreationBatchService(PayableRentalCostVO payableRentalCostVO, SignOnUserAccount userAccount) throws EventException {
		
		ScheduleUtil su = new ScheduleUtil();
		String yyyymm = payableRentalCostVO.getChgCostYrmon().replaceAll("-", "");
		boolean bIsRunning;
		try {
			bIsRunning = su.isRunning("EES_LSE_B001");
		} catch (DAOException e) {
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"PayableRentalChargeCreation BackEndJob"}).getUserMessage(),e);
		}
		log.debug("\n bIsRunning>> " + bIsRunning);
		if(bIsRunning)
			return "6";
		else{
			try {
				su.directExecuteJob("EES_LSE_B001", yyyymm);
			} catch (IOException e) {
				throw new EventException(new ErrorHandler("LSE10005", new String[]{"Estimate Creation"}).getUserMessage(),e);
			} catch (InterruptedException e) {
				throw new EventException(new ErrorHandler("LSE10005", new String[]{"Estimate Creation"}).getUserMessage(),e);
			} catch (DAOException e) {
				throw new EventException(new ErrorHandler("LSE10005", new String[]{"Estimate Creation"}).getUserMessage(),e);
			}
			return "4";
		}
	}
	
}
