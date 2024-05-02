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
 * 2010.09.07 최도순 [CHM-201005726] ALPS > Cut Over VVD Creation for New A/R Office 보완 요청
 * 2010.11.23 이석준 [CHM-201006884] FNS_INV_0114 신규 개발(조회,저장 기능 추가)
 * 2011.05.12 김태균 [CHM-201110564-01] AR Invoice - VVD 조회 기능 개발 요청 - 신규
 * 2011.08.04 오요한 [CHM-201112323] ALPS 코드 속성 작업 결과에 따른 기 메뉴 삭제된 ALPS INV 소스 삭제 
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;
import org.apache.xmlbeans.XmlObject;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.integration.GeneralARInvoiceMasterDataMgtDBDAO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.InvArBankListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.InvArLoclChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.InvArStupOfcVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.InvCutOffLaneVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.LaneOrderInPutVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.LaneOrderVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.MdmOfcInPutVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.MdmOrganizationVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.PHILSLocationListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.PrinterbyUserIdVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.ProcessingVvdListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.RevenueProcessParamVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.RevenueVvdListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.InvChgDescConvVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.erp.FNS0430001Document;
import com.hanjin.irep.erp.FNS0430001Document.FNS0430001;
import com.hanjin.irep.erp.FNS0430001Document.FNS0430001.DataArea;
import com.hanjin.irep.erp.FNS0430001Document.FNS0430001.DataArea.ROWSET;
import com.hanjin.irep.erp.FNS0430001Document.FNS0430001.DataArea.ROWSET.ROW;
import com.hanjin.syscommon.common.table.ArFincDirConvVO;
import com.hanjin.syscommon.common.table.InvArBankVO;
import com.hanjin.syscommon.common.table.InvEdiIntgCdDtlVO;
import com.hanjin.syscommon.common.table.InvEdiIntgCdVO;
import com.hanjin.syscommon.common.table.InvRevAcctCdVO;

/**
 * ALPS-AccountReceivableInvoiceMasterDataMgt Business Logic Basic Command implementation<br>
 * - ALPS-AccountReceivableInvoiceMasterDataMgt에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author saeil kim
 * @see FNS_INV_0077EventResponse,GeneralARInvoiceMasterDataMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
 
public class GeneralARInvoiceMasterDataMgtBCImpl extends BasicCommandSupport implements GeneralARInvoiceMasterDataMgtBC {

	// Database Access Object
	private transient GeneralARInvoiceMasterDataMgtDBDAO dbDao = null;

	/**
	 * GeneralARInvoiceMasterDataMgtBCImpl 객체 생성<br>
	 * GeneralARInvoiceMasterDataMgtDBDAO를 생성한다.<br>
	 */
	public GeneralARInvoiceMasterDataMgtBCImpl() {
		dbDao = new GeneralARInvoiceMasterDataMgtDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * GeneralARInvoiceMasterDataMgt화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param LaneOrderInPutVO lanOrdInputVo
	 * @return List<LaneOrderVO>
	 * @exception EventException
	 */
	public List<LaneOrderVO> searchRevenueLaneOrderList(LaneOrderInPutVO lanOrdInputVo) throws EventException {
		try {
			return dbDao.searchRevenueLaneOrderList(lanOrdInputVo);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * GeneralARInvoiceMasterDataMgt화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param ArFincDirConvVO arFincDirConvVO
	 * @return List<ArFincDirConvVO>
	 * @exception EventException
	 */
	public List<ArFincDirConvVO> searchRevenueVesselDirectionCodeConversionList(ArFincDirConvVO arFincDirConvVO) throws EventException {
		try {
			return dbDao.searchRevenueVesselDirectionCodeConversionList(arFincDirConvVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * AR Office별 Invoice 표기 은행계좌번호를 조회한다. <br>
	 * 
	 * @param String arOfc
	 * @param String saleOfc
	 * @return List<InvArBankListVO>
	 * @exception EventException
	 */
	public List<InvArBankListVO> searchBankAccountList(String arOfc, String saleOfc) throws EventException {
		try {
			return dbDao.searchBankAccountList(arOfc, saleOfc);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}

	}

	/**
	 * Office별 Invoice발행시 표기되는 정보중 하나인 Currency별 은행계좌정보를 등록, 수정한다. <br>
	 * 
	 * @param InvArBankVO[] bAcctVOs
	 * @param String userId
	 * @exception EventException
	 */
	public void manageBankAccount(InvArBankVO[] bAcctVOs, String userId) throws EventException {
		try {
			List<InvArBankVO> insertVoList = new ArrayList<InvArBankVO>();
			List<InvArBankVO> updateVoList = new ArrayList<InvArBankVO>();
			List<InvArBankVO> deleteVoList = new ArrayList<InvArBankVO>();
			for (int i = 0; i < bAcctVOs.length; i++) {
				if (bAcctVOs[i].getIbflag().equals("I")) {
					bAcctVOs[i].setCreUsrId(userId);
					insertVoList.add(bAcctVOs[i]);
				} else if (bAcctVOs[i].getIbflag().equals("U")) {
					bAcctVOs[i].setUpdUsrId(userId);
					updateVoList.add(bAcctVOs[i]);
				} else if (bAcctVOs[i].getIbflag().equals("D")) {
					deleteVoList.add(bAcctVOs[i]);
				}
			}
			if (insertVoList.size() > 0) {
				dbDao.addBankAccount(insertVoList);
			}
			if (updateVoList.size() > 0) {
				dbDao.modifyBankAccount(updateVoList);
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeBankAccount(deleteVoList);
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			if (ex.toString().contains("ORA-00001")) {
				throw new EventException(new ErrorHandler("INV00040", new String[] {}).getMessage(), ex);
			} else {
				throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
			}
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}

	}

	/**
	 * 입력한 Sales Office code가 AR Office의 소속 Office 인지를 확인한다. <br>
	 * 
	 * @param String arOfc
	 * @param String saleOfc
	 * @return String
	 * @exception EventException
	 */
	public String searchSalesOffice(String arOfc, String saleOfc) throws EventException {
		String ofcCd = "";
		try {
			ofcCd = dbDao.searchSalesOffice(arOfc, saleOfc);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00038", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00038", new String[] {}).getMessage(), ex);
		}
		return ofcCd;
	}

	/**
	 * ERP 에서 생성하여 Interface 된 Revenue Account 정보를 조회한다. <br>
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
	 * Local에서 사용하는 Charge code를 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String ofc
	 * @param String locCd
	 * @return List<InvArLoclChgVO>
	 * @exception EventException
	 */
	public List<InvArLoclChgVO> searchLocalChargeList(String Ofc, String locCd) throws EventException {
		try {
			return dbDao.searchLocalChargeList(Ofc, locCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * ofc에 따라 loc_cd 를 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String ofc
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchLocalChargeLocationList(String Ofc) throws EventException {
		try {
			return dbDao.searchLocalChargeLocationList(Ofc);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Local에서 사용하는 Charge code를 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String acctCd
	 * @return String
	 * @exception EventException
	 */
	public String searchMDMAccount(String acctCd) throws EventException {
		try {
			return dbDao.searchMDMAccount(acctCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 지역별 Local Charge등록, 수정, 삭제한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param InvArLoclChgVO[] invArLoclChgVOs
	 * @param String userId
	 * @exception EventException
	 */
	public void manageLocalCharge(InvArLoclChgVO[] invArLoclChgVOs, String userId) throws EventException {
		try {
			List<InvArLoclChgVO> insertVoList = new ArrayList<InvArLoclChgVO>();
			List<InvArLoclChgVO> updateVoList = new ArrayList<InvArLoclChgVO>();
			List<InvArLoclChgVO> deleteVoList = new ArrayList<InvArLoclChgVO>();
			if (null != invArLoclChgVOs) {
				for (int i = 0; i < invArLoclChgVOs.length; i++) {
					if (invArLoclChgVOs[i].getIbflag().equals("I")) {
						invArLoclChgVOs[i].setCreUsrId(userId);
						invArLoclChgVOs[i].setUpdUsrId(userId);
						insertVoList.add(invArLoclChgVOs[i]);
					} else if (invArLoclChgVOs[i].getIbflag().equals("U")) {
						invArLoclChgVOs[i].setUpdUsrId(userId);
						updateVoList.add(invArLoclChgVOs[i]);
					} else if (invArLoclChgVOs[i].getIbflag().equals("D")) {
						deleteVoList.add(invArLoclChgVOs[i]);
					}
				}
			}
			if (insertVoList.size() > 0) {
				dbDao.addLocalChg(insertVoList);
			}
			if (updateVoList.size() > 0) {
				dbDao.modifyLocalChg(updateVoList);
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeLocalChg(deleteVoList);
			}

		} catch (DAOException ex) {
			log.error("err--> " + ex.toString(), ex);
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
	 * 신규 AR Office 생성 시 구 Office와 구분을 결정하는 기준조회(VVD/Lane 별 office결정 기준일자 관리)한다.<br>
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
	 * A/R Office별 Cut Off Lane정보등록, 수정, 삭제한다.<br>
	 * Office 신설 및 변경시 invoice관리 office결정을 등록된 내용의 날짜 기준으로 정한다.<br>
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
							// inbound일 경우,
							cutLanVOs[i].setIoBndCd("I");
							insertVoList.add(cutLanVOs[i]);
							// log.debug(i+"===>>"+insertVoList.get(i).getIoBndCd());

							// outbound일 경우,
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
	 * 입력된 lane code 가 정상적인 lane code인지 체크한다.<br>
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
	 * 입력된 port가 정상적인 Location code인지 체크한다.<br>
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
	 * 입력된 VVD code 가 정상적인 VVD 인지 체크한다.<br>
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
	 * Office별 Invoice 발행시 특이사항 및 발행유형을 조회한다.<br>
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
				String chgCd = "";
				StringBuffer chgCdBuff = new StringBuffer();
				if(invArStupOfcVO != null){
					if(list2.size() > 0){
						for (int i = 0; i < list2.size(); i++) {
							chgCdBuff.append("|" + list2.get(i));
							//chgCd = chgCd + "|" + list2.get(i);
						}
						chgCd = chgCdBuff.toString();
						invArStupOfcVO.setChgCd(chgCd);
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
	 * INV_AR_MISC_BLCK_CHG 테이블에서 해당 Office 내용을 등록, 삭제함. <br>
	 * author Dong Hoon Han
	 * 
	 * @param String ofc
	 * @param String chgCd
	 * @param String userId
	 * @exception EventException
	 */
	public void manageMriChgcdByOffice(String ofc, String chgCd, String userId) throws EventException {
		try {
			// ofc별 chg 삭제
			dbDao.removeMiscBlckChg(ofc);

			// ofc별 chg 등록
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
	 * Office별 Invoice 발행시 특이사항및 발행유형을 등록 수정한다. <br>
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
     * ERP에서 Revenue Type별 Account code를 전송받아 등록한다. <br>
     * 
     * @param InvRevAcctCdVO[] invRevAcctCdVOs
     * @exception EventException
     */
	public void createRevenueAccountList(InvRevAcctCdVO[] invRevAcctCdVOs) throws EventException {
		try {
			
			dbDao.removeRevenueAccountList();
		
			List<InvRevAcctCdVO> insertVoList = new ArrayList<InvRevAcctCdVO>();			

			for (int i = 0; i < invRevAcctCdVOs.length; i++) {				
				// Insert 항목에 추가
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
	 * FNS_INV_0107<br>
	 * MDM 에서 관리하는 Office 정보를 조회한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param MdmOfcInPutVO mdmOfcInPutVO
	 * @return List<MdmOrganizationVO>
	 * @exception EventException
	 */
	public List<MdmOrganizationVO> searchMDMOfficeList(MdmOfcInPutVO mdmOfcInPutVO) throws EventException {
		try {
			return dbDao.searchMDMOfficeList(mdmOfcInPutVO);
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
	 * INVOICE Printer Set up정보를 조회한다.<br>
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
	 * INVOICE Printer Set up정보를 수정, 입력한다.<br>
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
	 * 조회 이벤트 처리<br>
	 * User ID 소속의 A/R Office 관련 정보를 조회한다<br>
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
	 * 조회 이벤트 처리<br>
	 * Glovis EDI Code Conversion 조회<br>
	 * 
	 * @param InvEdiIntgCdVO invEdiIntgCdVO
	 * @return List<InvEdiIntgCdDtlVO>
	 * @exception EventException
	 */
	public List<InvEdiIntgCdDtlVO> searchEDIMappingCodeList(InvEdiIntgCdVO invEdiIntgCdVO) throws EventException {
		try {
			return dbDao.searchEDIMappingCodeList(invEdiIntgCdVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00075",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00075",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * FNS_INV_0114<br>
	 * Glovis Code 인력/저장/삭제 function.<br>
	 * 
	 * @author 이석준
	 * @param InvEdiIntgCdDtlVO[] invEdiIntgCdDtlVOs
	 * @param String userId
	 * @exception EventException
	 */
	public void manageEDIMappingCodeList(InvEdiIntgCdDtlVO[] invEdiIntgCdDtlVOs,String userId) throws EventException {
		try {
			List<InvEdiIntgCdDtlVO> insertVoList = new ArrayList<InvEdiIntgCdDtlVO>();
			List<InvEdiIntgCdDtlVO> updateVoList = new ArrayList<InvEdiIntgCdDtlVO>();
			List<InvEdiIntgCdDtlVO> deleteVoList = new ArrayList<InvEdiIntgCdDtlVO>();
			if (null != invEdiIntgCdDtlVOs) {
				for (int i = 0; i < invEdiIntgCdDtlVOs.length; i++) {
					if (invEdiIntgCdDtlVOs[i].getIbflag().equals("I")) {
						invEdiIntgCdDtlVOs[i].setCreUsrId(userId);
						invEdiIntgCdDtlVOs[i].setUpdUsrId(userId);
						insertVoList.add(invEdiIntgCdDtlVOs[i]);
					} else if (invEdiIntgCdDtlVOs[i].getIbflag().equals("U")) {
						invEdiIntgCdDtlVOs[i].setUpdUsrId(userId);
						updateVoList.add(invEdiIntgCdDtlVOs[i]);
					} else if (invEdiIntgCdDtlVOs[i].getIbflag().equals("D")) {
						deleteVoList.add(invEdiIntgCdDtlVOs[i]);
					}
				}
			}
			
			if (deleteVoList.size() > 0) {
				dbDao.removeInvEdiIntgCdDtl(deleteVoList);
			}
			
			if (insertVoList.size() > 0) {
				dbDao.addInvEdiIntgCdDtl(insertVoList);
			}
			
			if (updateVoList.size() > 0) {
				dbDao.modifyInvEdiIntgCdDtl(updateVoList);
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
	 * FNS_INV_0121<br>
	 * Revenue VVD 정보를 조회한다.<br>
	 * 
	 * @author 김태균
	 * @param RevenueProcessParamVO paramVO
	 * @return List<RevenueVvdListVO>
	 * @exception EventException
	 */
	public List<RevenueVvdListVO> searchRevenueVvdList(RevenueProcessParamVO paramVO) throws EventException {
		String fmYYMM = "";
		String toYYMM = "";
		try {
			fmYYMM = StringUtils.defaultString(paramVO.getYrmonFm());
			toYYMM = StringUtils.defaultString(paramVO.getYrmonTo());
			
			if(!fmYYMM.equals(""))
				fmYYMM = StringUtils.replace(fmYYMM,"-", "");
			
			if(!toYYMM.equals(""))
				toYYMM = StringUtils.replace(toYYMM,"-", "");
			
			paramVO.setYrmonFm(fmYYMM);
			paramVO.setYrmonTo(toYYMM);
			
			log.debug("[fmYYMM]"+fmYYMM);
			log.debug("[toYYMM]"+toYYMM);

			return dbDao.searchRevenueVvdList(paramVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00075",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00075",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * FNS_INV_0121<br>
	 * Processing VVD 정보를 조회한다.<br>
	 * 
	 * @author 김태균
	 * @param RevenueProcessParamVO paramVO
	 * @return List<searchProcessingVvdList>
	 * @exception EventException
	 */
	public List<ProcessingVvdListVO> searchProcessingVvdList(RevenueProcessParamVO paramVO) throws EventException {
		String fmYYMM = "";
		String toYYMM = "";
		try {
			fmYYMM = StringUtils.defaultString(paramVO.getYrmonFm());
			toYYMM = StringUtils.defaultString(paramVO.getYrmonTo());
			
			if(!fmYYMM.equals(""))
				fmYYMM = StringUtils.replace(fmYYMM,"-", "");
			
			if(!toYYMM.equals(""))
				toYYMM = StringUtils.replace(toYYMM,"-", "");
			
			paramVO.setYrmonFm(fmYYMM);
			paramVO.setYrmonTo(toYYMM);
			
			log.debug("[fmYYMM]"+fmYYMM);
			log.debug("[toYYMM]"+toYYMM);
			
			return dbDao.searchProcessingVvdList(paramVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00075",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00075",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * FNS_INV_0133 : Retrieve<br>
	 * Philips Location Code 를 조회한다. <br>
	 * 
	 * @author 9011620
	 * @return
	 * @throws EventException
	 */
	public List<PHILSLocationListVO> searchEdiPHILSLocationList() throws EventException {
		try {
			return dbDao.searchEdiPHILSLocationList();
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00075",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00075",new String[]{}).getMessage(), ex);
		}
	}
	
	
	/**
	 * FNS_INV_0133 : Retrieve<br>
	 * Philips Location Code 를  등록, 변경 삭제한다. <br>
	 * 
	 * @author 9011620
	 * @param vos
	 * @throws EventException
	 */
	public void manageEdiPHILSLocationList(List<PHILSLocationListVO> vos) throws EventException{
		List<PHILSLocationListVO> insPHILSLocationListVOList = new ArrayList<PHILSLocationListVO>();
		List<PHILSLocationListVO> updPHILSLocationListVOList = new ArrayList<PHILSLocationListVO>();
		List<PHILSLocationListVO> delPHILSLocationListVOList = new ArrayList<PHILSLocationListVO>();
		try{
			for(int i = 0; i < vos.size(); i++){
				PHILSLocationListVO philsLocationListVO = (PHILSLocationListVO)vos.get(i);
				if(philsLocationListVO.getIbflag().equals("I"))
					insPHILSLocationListVOList.add(philsLocationListVO);
				else
					if(philsLocationListVO.getIbflag().equals("U"))
						updPHILSLocationListVOList.add(philsLocationListVO);
					else
						if(philsLocationListVO.getIbflag().equals("D"))
							delPHILSLocationListVOList.add(philsLocationListVO);
			}

			if(insPHILSLocationListVOList.size() > 0)
				dbDao.addEdiPHILSLocationList(insPHILSLocationListVOList);
			if(updPHILSLocationListVOList.size() > 0)
				dbDao.modifyEdiPHILSLocationList(updPHILSLocationListVOList);
			if(delPHILSLocationListVOList.size() > 0)
				dbDao.removeEdiPHILSLocationList(delPHILSLocationListVOList);
		}catch(DAOException ex){
			throw new EventException((new ErrorHandler("COM12240", new String[0])).getUserMessage(), ex);
		}catch(Exception ex){
			throw new EventException((new ErrorHandler("COM12240", new String[0])).getUserMessage(), ex);
		}
		
	}
	
	/**
	 * FNS_INV_0134 : Retrieve<br>
	 * Surcharge Description 를 조회한다. <br>
	 * 
	 * @author  김준호
	 * @param  String arHdQtrOfcCd
	 * @param  String arOfcCd
	 * @param  String chgCd
	 * @return List<InvChgDescConvVO>
	 * @throws EventException
	 */
	public List<InvChgDescConvVO> searchSurchargeDescriptionList(String arHdQtrOfcCd, String arOfcCd, String chgCd) throws EventException {
		try {
			return dbDao.searchSurchargeDescriptionList(arHdQtrOfcCd, arOfcCd, chgCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00075",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00075",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * FNS_INV_0134 : Save<br>
	 * Surcharge Description 를  등록, 변경 삭제한다. <br>
	 * 
	 * @author 김준호
	 * @param vos
	 * @throws EventException
	 */
	public void manageSurchargeDescriptionList(List<InvChgDescConvVO> vos) throws EventException{
		List<InvChgDescConvVO> insInvChgDescConvVOList = new ArrayList<InvChgDescConvVO>();
		List<InvChgDescConvVO> updInvChgDescConvVOList = new ArrayList<InvChgDescConvVO>();
		List<InvChgDescConvVO> delInvChgDescConvVOList = new ArrayList<InvChgDescConvVO>();
		try{
			for(int i = 0; i < vos.size(); i++){
				InvChgDescConvVO invChgDescConvVO = (InvChgDescConvVO)vos.get(i);
				if(invChgDescConvVO.getIbflag().equals("I"))
					insInvChgDescConvVOList.add(invChgDescConvVO);
				else
					if(invChgDescConvVO.getIbflag().equals("U"))
						updInvChgDescConvVOList.add(invChgDescConvVO);
					else
						if(invChgDescConvVO.getIbflag().equals("D"))
							delInvChgDescConvVOList.add(invChgDescConvVO);
			}

			if(insInvChgDescConvVOList.size() > 0)
				dbDao.addSurchargeDescriptionList(insInvChgDescConvVOList);
			if(updInvChgDescConvVOList.size() > 0)
				dbDao.modifySurchargeDescriptionList(updInvChgDescConvVOList);
			if(delInvChgDescConvVOList.size() > 0)
				dbDao.removeSurchargeDescriptionList(delInvChgDescConvVOList);
						
		}catch(DAOException ex){
			throw new EventException((new ErrorHandler("COM12240", new String[0])).getUserMessage(), ex);
		}catch(Exception ex){
			throw new EventException((new ErrorHandler("COM12240", new String[0])).getUserMessage(), ex);
		}
		
	}
	
	/**
	 * LOCAL Charge 에 등록된 Charge 인지 확인한다.
	 * 
	 * @param String ofcCd
	 * @param String chgCd
	 * @return String
	 * @exception EventException
	 */
	public String searchLocalChargeExists(String ofcCd, String chgCd) throws EventException {
		try {
			return dbDao.searchLocalChargeExists(ofcCd, chgCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
}