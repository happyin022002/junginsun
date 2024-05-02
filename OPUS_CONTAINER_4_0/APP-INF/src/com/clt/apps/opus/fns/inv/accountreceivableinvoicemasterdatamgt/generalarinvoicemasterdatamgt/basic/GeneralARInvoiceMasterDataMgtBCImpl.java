/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : GeneralARInvoiceMasterDataMgtBCImpl.java
 *@FileTitle : Revenue Lane Inquiry by Order
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.04
 *@LastModifier : 김세일
 *@LastVersion : 1.0
 * 2009.05.04 김세일
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 =========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.xmlbeans.XmlObject;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.integration.GeneralARInvoiceMasterDataMgtDBDAO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.InvArStupOfcVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.InvCprtCdConvVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.InvCutOffLaneVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.PrinterbyUserIdVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.InvRevAcctCdVO;
import com.clt.irep.erp.FNS0430001Document;
import com.clt.irep.erp.FNS0430001Document.FNS0430001;
import com.clt.irep.erp.FNS0430001Document.FNS0430001.DataArea;
import com.clt.irep.erp.FNS0430001Document.FNS0430001.DataArea.ROWSET;
import com.clt.irep.erp.FNS0430001Document.FNS0430001.DataArea.ROWSET.ROW;

/**
 * AccountReceivableInvoiceMasterDataMgt Business Logic Basic Command implementation<br>
 * -handling AccountReceivableInvoiceMasterDataMgt business logic.<br>
 * 
 * @author saeil kim
 * @see FNS_INV_0077EventResponse,GeneralARInvoiceMasterDataMgtBC  refer each DAO class 
 * @since J2EE 1.4
 */
 
public class GeneralARInvoiceMasterDataMgtBCImpl extends BasicCommandSupport implements GeneralARInvoiceMasterDataMgtBC {

	// Database Access Object
	private transient GeneralARInvoiceMasterDataMgtDBDAO dbDao = null;

	/**
	 * create GeneralARInvoiceMasterDataMgtBCImpl Object<br>
	 * create GeneralARInvoiceMasterDataMgtDBDAO.<br>
	 */
	public GeneralARInvoiceMasterDataMgtBCImpl() {
		dbDao = new GeneralARInvoiceMasterDataMgtDBDAO();
	}

	/**
	 * retrieve Revenue Account info Interface with ERP. <br>
	 * 
	 * @param String source
	 * @param String revGroup
	 * @param String del
	 * @return List<InvRevAcctCdVO>
	 * @exception EventException
	 */
	public List<InvRevAcctCdVO> searchRevenueAccountList(String source, String revGroup, String del) throws EventException {
		try {
			return dbDao.searchRevenueAccountList(source, revGroup, del);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * save, correct, delete Revenue Account.<br>
	 * 
	 * @param InvRevAcctCdVO[] invRevAcctCdVOs
	 * @param String userId
	 * @exception EventException
	 */
	public void manageRevenueAccount(InvRevAcctCdVO[] invRevAcctCdVOs, String userId) throws EventException{
		try {
			List<InvRevAcctCdVO> insertVoList = new ArrayList<InvRevAcctCdVO>();
			List<InvRevAcctCdVO> updateVoList = new ArrayList<InvRevAcctCdVO>();
			List<InvRevAcctCdVO> deleteVoList = new ArrayList<InvRevAcctCdVO>();
			if (null != invRevAcctCdVOs) {
				for (int i = 0; i < invRevAcctCdVOs.length; i++) {
					if (invRevAcctCdVOs[i].getIbflag().equals("I")) {
						invRevAcctCdVOs[i].setCreUsrId(userId);
						invRevAcctCdVOs[i].setUpdUsrId(userId);						
						insertVoList.add(invRevAcctCdVOs[i]);
					} else if (invRevAcctCdVOs[i].getIbflag().equals("U")) {
						invRevAcctCdVOs[i].setUpdUsrId(userId);
						updateVoList.add(invRevAcctCdVOs[i]);
					} else if (invRevAcctCdVOs[i].getIbflag().equals("D")) {
						deleteVoList.add(invRevAcctCdVOs[i]);
					}
				}
			}
			
			if (insertVoList.size() > 0) {
				dbDao.addRevenueAccount(insertVoList);
			}
			if (updateVoList.size() > 0) {
				dbDao.modifyRevenueAccount(updateVoList);
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeRevenueAccount(deleteVoList);
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
	 * retrieve cut off lane list.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String oldOfc
	 * @param String newOfc
	 * @return List<InvCutOffLaneVO>
	 * @exception EventException
	 */
	public List<InvCutOffLaneVO> searchCutOffLaneListByAROffice(String oldOfc, String newOfc) throws EventException {
		try {
			return dbDao.searchCutOffLaneListByAROffice(oldOfc, newOfc);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * save, correct, delete cut off lane by A/R Office.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param InvCutOffLaneVO[] cutLanVOs
	 * @param String userId
	 * @exception EventException
	 */
	public void manageCutOffLaneByAROffice(InvCutOffLaneVO[] cutLanVOs, String userId) throws EventException {
		try {
			List<InvCutOffLaneVO> insertVoList = new ArrayList<InvCutOffLaneVO>();
			List<InvCutOffLaneVO> updateVoList = new ArrayList<InvCutOffLaneVO>();
			List<InvCutOffLaneVO> deleteVoList = new ArrayList<InvCutOffLaneVO>();
			if (null != cutLanVOs) {
				for (int i = 0; i < cutLanVOs.length; i++) {
					if (cutLanVOs[i].getIbflag().equals("I")) {
						cutLanVOs[i].setCreUsrId(userId);
						cutLanVOs[i].setUpdUsrId(userId);
						if (cutLanVOs[i].getCutOffAplyDtTpCd().equals("I")) {

							cutLanVOs[i].setVslCd("");
							cutLanVOs[i].setSkdVoyNo("");
							cutLanVOs[i].setSkdDirCd("");
							cutLanVOs[i].setIoBndCd("I");
							insertVoList.add(cutLanVOs[i]);
							// log.debug(i+"===>>"+insertVoList.get(i).getIoBndCd());

							InvCutOffLaneVO oVO = new InvCutOffLaneVO();
							oVO.setAplyDt(cutLanVOs[i].getAplyDt());
							oVO.setOfcRmk(cutLanVOs[i].getOfcRmk());
							oVO.setCreUsrId(cutLanVOs[i].getCreUsrId());
							oVO.setUpdUsrId(cutLanVOs[i].getUpdUsrId());
							oVO.setOldArOfcCd(cutLanVOs[i].getOldArOfcCd());
							oVO.setIoBndCd("O");
							oVO.setSlanCd(cutLanVOs[i].getSlanCd());
							oVO.setPortCd(cutLanVOs[i].getPortCd());
							oVO.setVslCd(cutLanVOs[i].getVslCd());
							oVO.setSkdVoyNo(cutLanVOs[i].getSkdVoyNo());
							oVO.setSkdDirCd(cutLanVOs[i].getSkdDirCd());
							oVO.setNewArOfcCd(cutLanVOs[i].getNewArOfcCd());
							oVO.setCutOffAplyDtTpCd(cutLanVOs[i].getCutOffAplyDtTpCd());
							insertVoList.add(oVO);
						} else {
							insertVoList.add(cutLanVOs[i]);
						}
					} else if (cutLanVOs[i].getIbflag().equals("U")) {
						cutLanVOs[i].setUpdUsrId(userId);
						updateVoList.add(cutLanVOs[i]);
					} else if (cutLanVOs[i].getIbflag().equals("D")) {
						deleteVoList.add(cutLanVOs[i]);
					}
				}
			}
			for (int i = 0; i < insertVoList.size(); i++) {
				log.debug(i + "==" + insertVoList.get(i).getIoBndCd());
			}
			if (insertVoList.size() > 0) {
				dbDao.addCutOffLaneByAROffice(insertVoList);
			}
			if (updateVoList.size() > 0) {
				dbDao.modifyCutOffLaneByAROffice(updateVoList);
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeCutOffLaneByAROffice(deleteVoList);
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
	 * validate input lane code.<br>
	 * author Dong Hoon Han
	 * 
	 * @param String lane
	 * @return String
	 * @exception EventException
	 */
	public String searchSvcLane(String lane) throws EventException {
		try {
			return dbDao.searchSvcLane(lane);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * validate input port Location code.<br>
	 * author Dong Hoon Han
	 * 
	 * @param String port
	 * @return String
	 * @exception EventException
	 */
	public String searchLocation(String port) throws EventException {
		try {
			return dbDao.searchLocation(port);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * validate input VVD code.<br>
	 * author Dong Hoon Han
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @return String
	 * @exception EventException
	 */
	public String searchVVD(String vslCd, String skdVoyNo, String skdDirCd) throws EventException {
		try {
			return dbDao.searchVVD(vslCd, skdVoyNo, skdDirCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * retrieve issue standard by Office.<br>
	 * author Dong Hoon Han
	 * 
	 * @param String ofc
	 * @return InvArStupOfcVO
	 * @exception EventException
	 */
	public InvArStupOfcVO searchIssueStandardByOffice(String ofc) throws EventException {
		InvArStupOfcVO invArStupOfcVO = null;
		try {						
			invArStupOfcVO = dbDao.searchIssueStandardByOffice(ofc);			
			List<String> list2 = dbDao.searchMiscBlckChgList(ofc);
				StringBuffer chgCd = new StringBuffer("");
				if(invArStupOfcVO != null){
					if(list2.size() > 0){
						for (int i = 0; i < list2.size(); i++) {
							chgCd.append("|").append(list2.get(i));
							
						}
						invArStupOfcVO.setChgCd(chgCd.toString());
					}	
				}	
			return invArStupOfcVO;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
			//throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
			//throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * save , delete INV_AR_MISC_BLCK_CHG table by Office. <br>
	 * author Dong Hoon Han
	 * 
	 * @param String ofc
	 * @param String chgCd
	 * @param String userId
	 * @exception EventException
	 */
	public void manageMriChgcdByOffice(String ofc, String chgCd, String userId) throws EventException {
		try {
			dbDao.removeMiscBlckChg(ofc);

			StringTokenizer st = new StringTokenizer(chgCd, "|");
			String strChgCd = "";
			while (st.hasMoreTokens()) {
				strChgCd = st.nextToken();
				if (!strChgCd.equals("")) {
					dbDao.addMiscBlckChg(ofc, strChgCd, userId);
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
	 * manage issue standard by Office. <br>
	 * author Dong Hoon Han
	 * 
	 * @param InvArStupOfcVO issStnVO
	 * @exception EventException
	 */
	public void manageIssueStandardByOffice(InvArStupOfcVO issStnVO) throws EventException {
		try {
			if (null != issStnVO) {
				if (issStnVO.getIbflag().equals("I")) {
					dbDao.addSetupOffice(issStnVO);
				} else if (issStnVO.getIbflag().equals("U")) {
					dbDao.modifySetupOffice(issStnVO);
				}
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("INV00053",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("INV00053",new String[]{}).getMessage(), de);
		}
	}

	/**
	 * FNS0430001Document XMLparsing. <br>
	 * 
	 * @param XmlObject xmlObject
	 * @return InvRevAcctCdVO[]
	 * @exception EventException
	 */
    public InvRevAcctCdVO[] fns0430001Receive(XmlObject xmlObject) throws EventException {
    	
    	log.debug("======================================");
		log.debug("xmlObject : " + xmlObject);
		log.debug("======================================");		
    	
		FNS0430001Document doc = (FNS0430001Document) xmlObject;
		FNS0430001 sync = doc.getFNS0430001();
		DataArea data = sync.getDataArea();
		ROWSET rowset = data.getROWSET();
		ROW[] row = rowset.getROWArray();
		InvRevAcctCdVO[] models = new InvRevAcctCdVO[row.length];
		
		try {
	
			for (int i=0; row!=null && i<row.length; i++) {
				models[i] = new InvRevAcctCdVO();
				
				models[i].setInvSrcCd(row[i].getSOURCE());
				models[i].setRevTpGrpCd(row[i].getREVTYPEGROUP());
				models[i].setRevTpSrcCd(row[i].getREVTYPE());
				models[i].setInvAcctDivCd(row[i].getACCOUNTDIVISION());
				models[i].setChgCd(row[i].getCHARGE());
				models[i].setAcctCd(row[i].getACCOUNTCODE());
				models[i].setAcctKrnNm(row[i].getACCTNAMEKRW());
				models[i].setAcctEngNm(row[i].getACCTNAMEUSD());
				models[i].setPrcDivCd(row[i].getPRICING());
				models[i].setDeltFlg(row[i].getDELETEFLAG());
				models[i].setRepChgCd(row[i].getREPCHRG());
				models[i].setCreUsrId(row[i].getCREATEDBY());
				models[i].setCreDt(row[i].getCREATIONDATE());
				models[i].setUpdUsrId(row[i].getLASTUPDATEDBY());
				models[i].setUpdDt(row[i].getLASTUPDATEDATE());			
				
			}

    	} catch (Exception ex) {
	    	log.error("err " + ex.toString(), ex);
	    	throw new EventException(new ErrorHandler("INV00053",new String[]{}).getMessage(), ex);
    	}

		return models;
	}
    
    /**
     * save  Account code Revenue Type from ERP. <br>
     * 
     * @param InvRevAcctCdVO[] invRevAcctCdVOs
     * @exception EventException
     */
	public void createRevenueAccountList(InvRevAcctCdVO[] invRevAcctCdVOs) throws EventException {
		try {
			
			dbDao.removeRevenueAccountList();
		
			List<InvRevAcctCdVO> insertVoList = new ArrayList<InvRevAcctCdVO>();			

			for (int i = 0; i < invRevAcctCdVOs.length; i++) {				
				insertVoList.add(invRevAcctCdVOs[i]);
			}
			
			if (insertVoList.size() > 0) {
				dbDao.addRevenueAccountList(insertVoList);
			}	
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053",new String[]{}).getMessage(), ex);
		}
		
    }


	/**
	 * FNS_INV_0108<br>
	 * retrieve INVOICE Printer Set up info.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param String ofcCd
	 * @param String usrId
	 * @return List<PrinterbyUserIdVO>
	 * @exception EventException
	 */
	public List<PrinterbyUserIdVO> searchINVPrinterbyUserId(String ofcCd, String usrId) throws EventException {
		try {
			return dbDao.searchINVPrinterbyUserId(ofcCd, usrId);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * FNS_INV_0108<br>
	 *  save , correct INVOICE Printer Set up info.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param String ofc
	 * @param String userId
	 * @param String printerNm
	 * @exception EventException
	 */
	public void manageINVPrinterName(String ofc, String userId, String printerNm) throws EventException {
		try {
			int result = dbDao.modifyINVPrinterName(ofc, userId, printerNm);
			if(result == 0){
				dbDao.addINVPrinterName(ofc, userId, printerNm);
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * retrieve A/R Office by User ID <br>
	 * 
	 * @param String ofcCd
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchAROfficeList(String ofcCd) throws EventException {
		try {
			return dbDao.searchAROfficeList(ofcCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00075",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00075",new String[]{}).getMessage(), ex);
		}
	}	
	
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
	 * CPR(Customer Preferable Report)에서 사용할 NYK 사용 code를 Customer 사용 Code로 Conversion하기 위한 code를 등록하는 화면에서 NYK Code 가 유효한 Code 인지를 check한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String cdTp
	 * @param String cd
	 * @return String
	 * @exception EventException
	 */
	public String searchCompanyCode(String cdTp, String cd) throws EventException {
		String coCode = "";
		try {
			if (cdTp.equals("LOCATION")) {
				coCode = dbDao.searchLocationCode(cd);
			} else if (cdTp.equals("CHARGE")) {
				coCode = dbDao.searchChgCode(cd);
			} else if (cdTp.equals("CNTRTPSZ")) {
				coCode = dbDao.searchCNTRCode(cd);
			} else if (cdTp.equals("COMMODITY")) {
				coCode = dbDao.searchCmdtCode(cd);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		return coCode;
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

}