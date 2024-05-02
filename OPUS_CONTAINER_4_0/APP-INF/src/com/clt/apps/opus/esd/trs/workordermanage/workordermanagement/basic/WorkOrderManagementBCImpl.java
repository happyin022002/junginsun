/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : WorkOrderInquiryBCImpl.java
 *@FileTitle : W/O BFI Management 를 조회하는 화면
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014-11-17
 *@LastModifier : P.K.S
 *@LastVersion : 1.0
 * 2014-11-17 P.K.S
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workordermanagement.basic;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
//import java.util.UUID;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

import com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration.USA404EDIStatusInquiryDBDAO;
import com.clt.apps.opus.esd.trs.workordermanage.workordermanagement.event.EsdTrs0983Event;
import com.clt.apps.opus.esd.trs.workordermanage.workordermanagement.integration.WorkOrderManagementDBDAO;
import com.clt.apps.opus.esd.trs.workordermanage.workordermanagement.vo.WorkOrderBFIManagementVO;
import com.clt.framework.component.javamail.Mail;
import com.clt.framework.component.javamail.SingleMailAttachedFile;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.rowset.DBRowSetMetaData;
import com.clt.framework.core.config.SiteConfigFactory;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.utility.CheckUtilities;
import com.clt.syscommon.common.table.TrsTrspSvcOrdVO;

/**
 * ESD-workordermanage Business Logic Basic Command implementation<br>
 * - ESD-workordermanage handling business logic .<br>
 * @author
 * @see ESD_TRS_025EventResponse,WorkOrderInquiryBC refer to Each DAO classes
 * @since
 */
public class WorkOrderManagementBCImpl extends BasicCommandSupport implements WorkOrderManagementBC {
	private transient WorkOrderManagementDBDAO dbDao = null;

	/**
	 * WorkOrderInquiryBCImpl object creation <br>
	 * Generate WorkOrderInquiryDBDAO.<br>
	 */
	public WorkOrderManagementBCImpl() {
		dbDao = new WorkOrderManagementDBDAO();
	}

	/**
	 * [ESD_TRS_0029] W/O BFI Management 를 조회합니다. <br>
	 * @param WorkOrderBFIManagementVO workOrderBFIManagementVO
	 * @return List<WorkOrderBFIManagementVO>
	 * @exception EventException
	 */
	public List<WorkOrderBFIManagementVO> searchWorkOrderManagementBFIListBasic(WorkOrderBFIManagementVO workOrderBFIManagementVO) throws EventException {
		List<WorkOrderBFIManagementVO> resultVOs = null;
		try {
			resultVOs = dbDao.searchWorkOrderManagementBFIListData(workOrderBFIManagementVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return resultVOs;
	}

	/**
	 * [ESD_TRS_0029] W/O BFI Management 를 조회합니다. <br>
	 * @param WorkOrderBFIManagementVO workOrderBFIManagementVO
	 * @return List<WorkOrderBFIManagementVO>
	 * @exception EventException
	 */
	public List<WorkOrderBFIManagementVO> searchWorkOrderManagementBFIUiListBasic(WorkOrderBFIManagementVO workOrderBFIManagementVO) throws EventException {
		List<WorkOrderBFIManagementVO> resultVOs = null;
		try {
			resultVOs = dbDao.searchWorkOrderManagementBFIUiListData(workOrderBFIManagementVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return resultVOs;
	}

	/**
	 * Movement I/F
	 * @param cntrNo
	 * @param eventDt
	 * @param woNo
	 * @param orgNode
	 * @param mvmtStsCd
	 * @param bkgNo
	 * @param usrId
	 * @return
	 */
	public int modifyWorkOrderExecuteDate(String cntrNo, String eventDt, String woNo, String orgNode, String mvmtStsCd, String bkgNo, String usrId) {
		return modifyWorkOrderExecuteDate(cntrNo, eventDt, woNo, orgNode, mvmtStsCd, bkgNo, usrId, "XX");
	}

	/**
	 * Movement I/F
	 * @param cntrNo
	 * @param eventDt
	 * @param woNo
	 * @param orgNode
	 * @param mvmtStsCd
	 * @param bkgNo
	 * @param usrId
	 * @param inMvmtCreTpCd
	 * @return
	 */
	public int modifyWorkOrderExecuteDate(String cntrNo, String eventDt, String woNo, String orgNode, String mvmtStsCd, String bkgNo, String usrId, String inMvmtCreTpCd) {
		int rtnVal = 0;
		int iSoUpd = 0;
		int iRailSoUpd = 0;
		try {
			iSoUpd = dbDao.modifyWorkOrderExecuteDate(cntrNo, eventDt, woNo, orgNode, mvmtStsCd, bkgNo, usrId, inMvmtCreTpCd);
			iRailSoUpd = new USA404EDIStatusInquiryDBDAO().updateWoExeDtExecuteDateByCtm(cntrNo, eventDt, woNo, orgNode, mvmtStsCd, bkgNo, usrId, inMvmtCreTpCd);
			if (iSoUpd > 0 || iRailSoUpd > 0) {
				rtnVal = 1;
			}
		} catch (DAOException de) {
			log.error(de.toString(), de);
		} catch (Exception e) {
			log.error(e.toString(), e);
		}
		return rtnVal;
	}

	/**
	 * @param inTrspSoOfcCtyCd
	 * @param inTrspSoSeq
	 * @param inTrspWoOfcCtyCd
	 * @param inTrspWoSeq
	 * @param inCntrNo
	 * @param inBkgNo
	 * @param inUpdUsrId
	 * @return
	 */
	public int modifyWorkOrderExecuteDateByTrs(String inTrspSoOfcCtyCd, String inTrspSoSeq, String inTrspWoOfcCtyCd, String inTrspWoSeq, String inCntrNo, String inBkgNo, String inUpdUsrId) {
		try {
			if (!(CheckUtilities.isInBlank(inTrspSoOfcCtyCd) || CheckUtilities.isInBlank(inTrspSoSeq) || CheckUtilities.isInBlank(inBkgNo))) {
				dbDao.modifyWorkOrderExecuteDateByTrs(inTrspSoOfcCtyCd, inTrspSoSeq, inTrspWoOfcCtyCd, inTrspWoSeq, inCntrNo, inBkgNo, inUpdUsrId);
			}
		} catch (DAOException de) {
			log.error(de.toString(), de);
		} catch (Exception e) {
			log.error(e.toString(), e);
		}
		return 0;
	}

	/**
	 * searchTrsSubStsHis
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchTrsSubStsHis(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0983Event event = (EsdTrs0983Event) e;
		try {
			if (event.getTrsTrspSvcOrdVOs() != null) {
				List<TrsTrspSvcOrdVO> trspSvcOrdVOs = new ArrayList<TrsTrspSvcOrdVO>();
				if (event.getTrsTrspSvcOrdVOs() != null) {
					Collections.addAll(trspSvcOrdVOs, event.getTrsTrspSvcOrdVOs());
					if (!trspSvcOrdVOs.isEmpty()) {
						trspSvcOrdVOs.get(0).setCreOfcCd(event.getSignOnUserAccount().getOfc_cd());
						eventResponse.setRsVo(dbDao.searchTrsSubStsHis(trspSvcOrdVOs));
					}
				}
			}
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

	}

	/**
	 * [ESD_TRS_0029] download포맷의 W/O BFI Management 를 조회합니다. <br>
	 * @param WorkOrderBFIManagementVO workOrderBFIManagementVO
	 * @return List<WorkOrderBFIManagementVO>
	 * @exception EventException
	 */
	public List<WorkOrderBFIManagementVO> searchWorkOrderBFIDownForInvoice(WorkOrderBFIManagementVO workOrderBFIManagementVO) throws EventException {
		List<WorkOrderBFIManagementVO> resultVOs = null;
		try {
			resultVOs = dbDao.searchWorkOrderBFIDownForInvoice(workOrderBFIManagementVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return resultVOs;
	}

	// LOOK : email testing, DON'T BUILD IT
	/**
	 * [ESD_TRS_0029] W/O BFI Management 를 조회 후 csv 변환/첨부하여 S/P에게 email로 발송합니다. <br>
	 * @param WorkOrderBFIManagementVO workOrderBFIManagementVO
	 * @return List<WorkOrderBFIManagementVO>
	 * @exception EventException
	 */
	public List<WorkOrderBFIManagementVO> sendBFIManagementByEmail(WorkOrderBFIManagementVO workOrderBFIManagementVO) throws EventException {
		// List<WorkOrderBFIManagementVO> resultVOs = null;
		try {
			Set<String> recipients = null;

			// 1. retrieve data
			DBRowSet dbRowset = dbDao.searchBFIManagementListForEmail(workOrderBFIManagementVO);
			// 1.1. when data empty, skip sending e-mail
			if (dbRowset.getRowCount() < 1) {
				log.info("coresponding S/P " + workOrderBFIManagementVO.getVndrLglEngNm() + "(" + workOrderBFIManagementVO.getVndrSeq() + ")'s data not exists.");
				return null;
			}
			// 2. make csv file
			// ***************************************************************************
			// sample 1
			// SimpleDateFormat newDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			// Date myDate = newDateFormat.parse("28/12/2013");
			// newDateFormat.applyPattern("yyyy/MM/dd");
			// String myDateString = newDateFormat.format(myDate);
			// sample 2
			// String date = "10/07/2010";
			// String newDate = date.replaceAll("(\\d+)/(\\d+)/(\\d+)", "$3/$2/$1");
			// System.out.println(newDate);
			// ***************************************************************************

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date oldFromDate = dateFormat.parse(workOrderBFIManagementVO.getFmDt());
			Date oldToDate = dateFormat.parse(workOrderBFIManagementVO.getToDt());
			dateFormat.applyPattern("dd-MM-yyyy");
			String newFromDate = dateFormat.format(oldFromDate);
			String newToDate = dateFormat.format(oldToDate);
			String fileName = "BFI Report " + newFromDate + " ~ " + newToDate + ".csv";
			log.debug("========================================= " + fileName);

			String filepath = createAtchFile(dbRowset, fileName);

			// 3. set email recipients
			recipients = collectRecipients(dbRowset);

			// 4. send email
			// 4.1. create email object
			Mail mail = new Mail();

			// 4.2. set title, receiver, contents

			String subject = "Basis For Invoicing : " + newFromDate + " ~ " + newToDate;
			String contents = "<br><br>Please refer to the attachment and check for Invoice data.<br><br>";
			mail.setFrom("shipment.info@notifications.nykline.com");
			// mail.setBccRcvrEml("shipinfobcc@na.nykline.com");
			/*************************************/
			// for test
			// recipients.clear();
			// recipients.add("nyktest@cyberlogitec.com");
			// recipients.add("swookkim@cyberlogitec.com");
			/*************************************/
			mail.setRecipients(new ArrayList<String>(recipients));
			mail.setSubject(subject);
			mail.setHtmlContent(contents);

			// 4.3. attach csv file
			List<SingleMailAttachedFile> list1 = new ArrayList<SingleMailAttachedFile>();
			SingleMailAttachedFile attachedFile1 = new SingleMailAttachedFile();
			attachedFile1.setFileLocation(filepath);
			attachedFile1.setFileName(fileName);
			list1.add(attachedFile1);

			mail.addAttachedFile(list1);
			// 4.4. send
			mail.send();
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return null;
	}

	/**
	 * append attached file header
	 * @param StringBuilder
	 */
	private void appendAtchFileHeader(StringBuilder sb) {
		sb.append("Office,Fm Date,To Date,S/P Name,Email,File Creation Date,Contact,W/O No,TP/SZ,From,Via,To,Door,Door,Date,Currency,Charge Description,Charges,EQ No,Cargo,W/O Status\n");
		// for(int ndx = 0; ndx < columnCount; ndx++) {
		// if(ndx > 0) {
		// sb.append(",");
		// }
		// sb.append("\"").append(columnNameArr[ndx]).append("\"");
		// if (ndx == (columnCount - 1)) {
		// sb.append("\n");
		// }
		// }
	}

	/**
	 * append attached file data
	 * @param StringBuilder
	 * @param DBRowSet
	 */
	private void appendAtchFileData(StringBuilder sb, DBRowSet dbRowset) throws SQLException {
		int columnCount = dbRowset.getMetaData().getColumnCount();
		String[] columnNameArr = ((DBRowSetMetaData) dbRowset.getMetaData()).getColumnNameArray();
		DecimalFormat df = new DecimalFormat("#0.00");

		while (dbRowset.next()) {
			for (int ndx = 0; ndx < columnCount; ndx++) {
				if (columnNameArr[ndx].equalsIgnoreCase("WO_VNDR_SEQ")) { // skip column
					continue;
				}

				if (ndx > 0) { // delimiter for CSV format
					sb.append(",");
				}

				if (columnNameArr[ndx].equalsIgnoreCase("VNDR_LGL_ENG_NM") || columnNameArr[ndx].equalsIgnoreCase("DOR_NOD_NM")) { // case comma string
					sb.append("\"").append(dbRowset.getString(columnNameArr[ndx])).append("\"");
				} else if (columnNameArr[ndx].equalsIgnoreCase("BZC_AMT")) { // format for amount
					sb.append(df.format(Double.valueOf(dbRowset.getString(columnNameArr[ndx])).doubleValue()));
				} else {
					sb.append(dbRowset.getString(columnNameArr[ndx]));
				}

				if (ndx == (columnCount - 1)) { // end of line
					sb.append("\n");
				}
			}
		}
	}

	/**
	 * collect recipients email address
	 * @param DBRowSet
	 * @return Set<String>
	 * @throws SQLException
	 */
	private Set<String> collectRecipients(DBRowSet dbRowset) throws SQLException {
		Set<String> recipients = new LinkedHashSet<String>();
		dbRowset.beforeFirst();
		while (dbRowset.next()) {
			// --> 3.1. retrieve email addresses
			// --> 3.2. check duplicated email
			recipients.add(dbRowset.getString("VNDR_EML").trim());
		}

		// 3.3. check wrong email format
		String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern pattern = Pattern.compile(emailPattern);
		List<String> badEmail = new ArrayList<String>();
		for (String email : recipients) {
			if (!pattern.matcher(email).matches()) {
				badEmail.add(email);
			}
		}
		recipients.removeAll(badEmail);

		/*********************************************************************/
		for (String email : recipients) {
			log.debug("\nE-mail : " + email);
		}
		/*********************************************************************/

		return recipients;
	}

	/**
	 * generate attached csv file
	 * @param dbRowset
	 * @param String
	 * @return String
	 */
	private String createAtchFile(DBRowSet dbRowset, String fileName) throws SQLException, IOException {
		StringBuilder sb = new StringBuilder();

		// 2.1. create csv format string from VO
		appendAtchFileHeader(sb);
		appendAtchFileData(sb, dbRowset);

		// 2.2. generate UUID file name
		// String filename = UUID.randomUUID().toString() + ".csv";
		String filepath = SiteConfigFactory.getWhenNullThrowException("COM.MAIL.FILE.DIRECTORY") + fileName;
		// TODO : For MS Windows System
		// filepath = filepath.replace("/", "\\");

		// 2.3. save file
		String encoding = SiteConfigFactory.getWhenNullThrowException("COM.FILE.UPLOAD.ENCODING");

		File file = null;
		try {
			file = new File(filepath);
			while (file.exists() && file.isFile()) {
				file.delete();
			}
		} catch (NullPointerException e) {
			log.error(e.getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			if (file != null)
				file = null;
		}

		FileUtils.writeStringToFile(new File(filepath), sb.toString(), encoding);

		/*********************************************************************/
		log.debug("\nData : " + sb.toString());
		log.debug("\nData Size : " + sb.toString().getBytes(encoding).length);
		log.debug("\nFile Path : " + filepath);
		log.debug("\nFile Size : " + new File(filepath).length());
		/*********************************************************************/

		return filepath;
	}

	/**
	 * check vendor's email address exists or not
	 * @param WorkOrderBFIManagementVO workOrderBFIManagementVO
	 * @return
	 * @throws DAOException
	 */
	public int checkVndrPrmrCntcPntEmailAddr(WorkOrderBFIManagementVO workOrderBFIManagementVO) throws DAOException {
		return dbDao.checkVndrPrmrCntcPntEmailAddr(workOrderBFIManagementVO);
	}

	/**
	 * searchVendorList
	 * @param WorkOrderBFIManagementVO workOrderBFIManagementVO
	 * @return String[] vendors
	 * @throws DAOException
	 */
	public String[] searchVendorList(WorkOrderBFIManagementVO workOrderBFIManagementVO) throws DAOException {
		return dbDao.searchVendorList(workOrderBFIManagementVO);
	}

	/**
	 * workordermanage biz scenario closing<br>
	 * WorkOrderInquiry clearing related objects<br>
	 */
	public void doEnd() {
		dbDao = null;
	}

}