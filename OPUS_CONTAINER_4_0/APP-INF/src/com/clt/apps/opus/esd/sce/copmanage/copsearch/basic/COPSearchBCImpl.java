/*=========================================================
 *Copyright(c) 20006 CyberLogitec
 *@FileName : COPManageBCImpl.java
 *@FileTitle : COP Main Search
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.sce.copmanage.copsearch.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.sce.copmanage.copsearch.integration.COPSearchDBDAO;
import com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.BookingInfoVO;
import com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.COPDetailVO;
import com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.COPInquiryVO;
import com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.COPReplanInfoVO;
import com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.SearchActualInfoVO;
import com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.SearchCOPDetailDtInfoVO;
import com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.SearchCOPMainListVO;
import com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.SearchSCInfoVO;
import com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.SearchSOCostInfoVO;
import com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.SearchSceCopHdrInfoVO;
import com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.SearchTargetCOPInfoListVO;
import com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.SearchTransportationInfoVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * SCE Business Logic Basic Command implementation<br>
 * - SCE for the business logic to handle.<br>
 * 
 * @author
 * @see EsdSce0001EventResponse , COPManageBC Note Each DAO classes
 * @since J2EE 1.4
 */
public class COPSearchBCImpl extends BasicCommandSupport implements COPSearchBC {
	private transient COPSearchDBDAO dbDao = null;

	/**
	 * OPManageBCImpl object creation<br>
	 * Creates COPManageDBDAO.<br>
	 */
	public COPSearchBCImpl() {
		dbDao = new COPSearchDBDAO();
	}

	/**
	 * Query event processing<br>
	 * COP Main Query event processing<br>
	 * 
	 * @param COPInquiryVO inqVO
	 * @return List<SearchCOPMainListVO>
	 * @throws EventException ...
	 */
	public List<SearchCOPMainListVO> searchCOPMainList(COPInquiryVO inqVO) throws EventException {

		// DBRowSet rowSet = null ;
		List<SearchCOPMainListVO> list = null;
		try {

			log.debug("\n COPSearchBCImpl");
			list = dbDao.searchCOPMainList(inqVO);
			// int totCnt = 0;

			// if (rowSet == null)
			// log.debug ("rowSet is null!");

			// if( rowSet!=null && rowSet.next()) {
			// totCnt = rowSet.getInt("totcnt");
			// log.debug("\n totCnt<<<<<<"+totCnt);
			// rowSet.beforeFirst();
			// }
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw new EventException(de.getMessage());
		} catch (Exception de) {
			log.error(de.getMessage(), de);
			throw new EventException(de.getMessage());
		}
		return list;
	}

	/**
	 * COP Inquiry S / O check availability
	 * 
	 * @param COPInquiryVO inqVO
	 * @return List<SearchSceCopHdrInfoVO>
	 * @throws EventException ...
	 */
	public List<SearchSceCopHdrInfoVO> searchSceCopHdrInfo(COPInquiryVO inqVO) throws EventException {
		// DBRowSet rowSet = null;
		List<SearchSceCopHdrInfoVO> list = null;
		try {
			list = dbDao.searchSceCopHdrInfo(inqVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return list;
	}

	/**
	 * Search Master S / O check query
	 * 
	 * @param COPInquiryVO inqVO
	 * @return List<SearchSCInfoVO>
	 * @throws EventException ...
	 */
	public List<SearchSCInfoVO> searchSCInfo(COPInquiryVO inqVO) throws EventException {
		List<SearchSCInfoVO> list = null;

		try {
			list = dbDao.searchSCInfo(inqVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return list;
	}

	/**
	 * SCE_COP_HDR Update
	 * 
	 * @param COPInquiryVO inqVO
	 * @throws EventException ...
	 */
	public void modifyPCopHdr(COPInquiryVO inqVO) throws EventException {
		try {
			dbDao.modifyPCopHdr(inqVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * trs_trsp_rail_bil_ord,trs_trsp_svc_ord Update
	 * 
	 * @param SearchSCInfoVO inqVO
	 * @throws EventException ...
	 */
	public void modifyTrsRailSvcOrd(SearchSCInfoVO inqVO) throws EventException {
		try {
			dbDao.modifyTrsRailSvcOrd(inqVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * SCE_COP_HDR Update
	 * 
	 * @param COPInquiryVO inqVO
	 * @throws EventException ...
	 */
	public void modifyCopHdr(COPInquiryVO inqVO) throws EventException {
		try {
			dbDao.modifyCopHdr(inqVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * sce_cop_log insert
	 * 
	 * @param inqVO COPInquiryVO
	 * @exception EventException ...
	 */
	public void addSceCopHis(COPInquiryVO inqVO) throws EventException {
		try {
			dbDao.addSceCopHis(inqVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * BKG Detail Query event processing<br>
	 * 
	 * @param inqVO COPInquiryVO
	 * @return List
	 * @throws EventException ...
	 */
	@SuppressWarnings("rawtypes")
	public List searchBookingDetail(COPInquiryVO inqVO) throws EventException {
		DBRowSet rowSet = null;
		List<Object> returnList = new ArrayList<Object>();
		List<BookingInfoVO> listVVD = null;

		try {
			rowSet = dbDao.searchBookingAllDetail(inqVO);
			listVVD = dbDao.searchBookingVVDDetail(inqVO);

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		returnList.add(0, rowSet);
		returnList.add(1, listVVD);
		return returnList;
	}

	/**
	 * COP Sub Status Change.
	 * 
	 * @param mainListVOs SearchCOPMainListVO[]
	 * @throws EventException ...
	 */
	public void modifyCOPStatusChange(SearchCOPMainListVO[] mainListVOs) throws EventException {
		try {

			if (mainListVOs != null) {
				for (int i = 0; i < mainListVOs.length; i++) {
					String copSubStsCd = null;
					if ("Y".equals(mainListVOs[i].getCopSubStsCd())) {
						copSubStsCd = "R";
					} else {
						copSubStsCd = "";
					}
					// status change
					dbDao.modifyCOPStatusChange(mainListVOs[i].getRCopNo(), copSubStsCd);

					// history
					COPInquiryVO histVO = new COPInquiryVO();
					histVO.setNewCopNo(mainListVOs[i].getRCopNo());
					histVO.setUsrId(mainListVOs[i].getCreUsrId());
					histVO.setBkgEventTpCd("SC");
					dbDao.addSceCopHis(histVO);
				}
			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Query event processing<br>
	 * Booking List Query event processing<br>
	 * 
	 * @param COPDetailVO inqVO
	 * @return List<SearchSceCopHdrInfoVO>
	 * @throws EventException ...
	 */
	public List<SearchSceCopHdrInfoVO> searchBookingList(COPDetailVO inqVO) throws EventException {
		List<SearchSceCopHdrInfoVO> list = null;
		try {
			list = dbDao.searchBookingList(inqVO);
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw new EventException(de.getMessage());
		}
		return list;
	}

	/**
	 * Returns the current detail information.<br>
	 * CSHA9917655412
	 * 
	 * @param inqVOs COPReplanInfoVO[]
	 * @param inqVO COPReplanInfoVO
	 * @return String[]
	 * @throws EventException ...
	 */
	public String[] searchCopCurrentInfo(COPReplanInfoVO[] inqVOs, COPReplanInfoVO inqVO) throws EventException {

		String frmtoNumArray[] = { "", "", "", "", "" };

		// prd call
		String copno = "";
		String ioBndCd = "";
		String newNod = "";
		String creUsrId = "TEST";

		try {
			copno = inqVO.getCopNo();// event.getSCE_COP_HDR_INFO().getCop_no();

			log.debug("\n getIscompled    : " + inqVO.getIscompled() + "\n getBound_name   : " + inqVO.getBoundName() + "\n ++ Planned Route Only ++" + "\n getIsnodchg     : " + inqVO.getIsnodchg()
					+ "\n getNodcd        : " + inqVO.getNodcd() + "\n ++ Include Completed Route ++" + "\n getIsfrmchg     : " + inqVO.getIsfrmchg() + "\n getFrmcd        : " + inqVO.getFrmcd()
					+ "\n ");

			/*
			 * if(inqVO.getIscompled().equals("N")){ // Planned Route Only 버튼 체크 ioBndCd = dbDao.searchCopCurrentBound(copno); newNod = inqVO.getNodcd(); }else{ // Check Include Completed Route button
			 */
			log.debug("\n Check Include Completed Route button ");
			ioBndCd = inqVO.getBoundName();
			newNod = inqVO.getFrmcd();

			// }

			frmtoNumArray[0] = copno;
			frmtoNumArray[1] = ioBndCd;
			frmtoNumArray[2] = newNod;
			frmtoNumArray[3] = creUsrId;

			return frmtoNumArray;

			/*
			 * } catch (DAOException de) { log.error(de.getMessage(), de); throw new EventException(de.getMessage());
			 */
		} catch (Exception de) {
			log.error(de.getMessage(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * COP Detail Query event processing<br>
	 * 
	 * @param COPDetailVO inqVO
	 * @return GeneralEventResponse
	 * @throws EventException ...
	 */
	public GeneralEventResponse searchCOPDetail(COPDetailVO inqVO) throws EventException {
		// Collection models = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// SEARCHLIST01
		List<SearchTransportationInfoVO> transList = null;
		List<SearchCOPDetailDtInfoVO> dtList = null;
		// SEARCHLIST03
		List<SearchSOCostInfoVO> soCostInfoList = null;
		// SEARCHLIST04
		List<SearchActualInfoVO> actualInfoList = null;

		try {
			// command
			int command = Integer.parseInt(inqVO.getFCmd());

			// If the header and the Transportation tab search
			if (command == FormCommand.SEARCHLIST01) {
				transList = dbDao.searchTransportationInfo(inqVO);
				dtList = dbDao.searchCOPDetailDtInfo(inqVO);
				if (dtList != null && dtList.size() > 0) {
					SearchCOPDetailDtInfoVO etcVO = (SearchCOPDetailDtInfoVO) dtList.get(0);
					Map<String, String> mapVO = etcVO.getColumnValues();
					eventResponse.setETCData(mapVO);
				}
				eventResponse.setRsVoList(transList);
			}

			// S/O Cost tab
			else if (command == FormCommand.SEARCHLIST03) {
				soCostInfoList = dbDao.searchSOCostInfo(inqVO);
				eventResponse.setRsVoList(soCostInfoList);
			}

			// Actual Information tab
			else if (command == FormCommand.SEARCHLIST04) {
				actualInfoList = dbDao.searchActualInfo(inqVO);
				eventResponse.setRsVoList(actualInfoList);
			}

		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new EventException(e.getMessage());
		}

		return eventResponse;
	}

	/**
	 * Target COP Infomation Query<br>
	 * 
	 * @param COPReplanInfoVO inqVO
	 * @return List<SearchTargetCOPInfoListVO>
	 * @throws EventException ...
	 */
	public List<SearchTargetCOPInfoListVO> searchTargetCOPInfoList(COPReplanInfoVO inqVO) throws EventException {
		List<SearchTargetCOPInfoListVO> list = null;
		try {
			list = dbDao.searchTargetCOPInfoList(inqVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return list;
	}

	/**
	 * Target PC Infomation Query event processing<br>
	 * 
	 * @param inqVOs COPReplanInfoVO[]
	 * @param inqVO COPReplanInfoVO
	 * @param frmtoNum String[]
	 * @return GeneralEventResponse
	 * @throws EventException ...
	 */
	public GeneralEventResponse searchTargetPCInfoList(COPReplanInfoVO[] inqVOs, COPReplanInfoVO inqVO, String[] frmtoNum) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		List<SearchTargetCOPInfoListVO> list = null;
		try {
			String paramPctlNo = frmtoNum[0];
			String copNo = frmtoNum[1];
			String ioBndCd = frmtoNum[2];

			int colCnt = 0;
			if (!paramPctlNo.equals("") && paramPctlNo.length() > 0) {
				inqVO.setPctlNo(paramPctlNo);
				inqVO.setIoBndCd(ioBndCd);
				inqVO.setCopNo(copNo);
				list = dbDao.searchTargetCOPInfoList2(inqVO);
				colCnt = dbDao.searchTargetCOPInfoList2Cnt(inqVO);
			} else {
				log.info("\n @@@@@@@@@@@@@@@@@@@ pctlNo ​​must check ");
				throw new DAOException(new ErrorHandler("SCE00031").getMessage());
			}

			int rowSize = list != null ? list.size() : 0;
			int iDefaultColCnt = 4;// location, mode, sp name, AGMT ref no Loop
			int colSize = ((colCnt * iDefaultColCnt) + 1) + 4 + 1 + 1; // Combined Flag due to adding +1 to the end
			// int colSize = ((colCnt * 2) + 1) + 3 + 1 + 1 ; // Combined Flag due to adding +1 to the end
			String dataSet[][] = new String[rowSize][colSize];
			String pctlNo = "";
			String routPlnCd = "";
			String orgNodCd = "";
			String[] orgNodArry = null;
			String estDlvTm = "";
			String estTotCost = "";
			int itemCnt = 0;
			int itemMaxCnt = 0;
			String inlndRoutCmgFlg = ""; // Add Combined Flag
			String inlndRoutTmpFlg = ""; // Add Tmp Flag

			String[] tmpOrgNodArry = null;

			for (int i = 0; i < rowSize; i++) {
				SearchTargetCOPInfoListVO vo = (SearchTargetCOPInfoListVO) list.get(i);

				pctlNo = vo.getPctlNo();// row[0];
				routPlnCd = vo.getRoutPlnCd();
				orgNodCd = vo.getOrgNodCdVal();
				estDlvTm = vo.getEstDlvTm();// row[2];
				estTotCost = vo.getEstTotCost();// row[3];
				itemCnt = Integer.parseInt(vo.getItemCnt());
				itemMaxCnt = Integer.parseInt(vo.getItemMaxCnt());
				inlndRoutCmgFlg = vo.getInlndRoutCmbFlg();
				inlndRoutTmpFlg = vo.getInlndRoutTmpFlg();

				tmpOrgNodArry = orgNodCd.split("/");
				orgNodArry = new String[itemMaxCnt];

				for (int m = 0; m < itemMaxCnt; m++) {
					if (m < itemCnt) {
						orgNodArry[m] = tmpOrgNodArry[m];
					} else {
						orgNodArry[m] = "";
					}
				}

				for (int j = 0; j < colSize; j++) {
					if (j == 0) {
						dataSet[i][j] = pctlNo;
					} else if (j == 1) {
						dataSet[i][j] = routPlnCd;
					} else if (j > 1 && j < colSize - 6) {
						dataSet[i][j] = orgNodArry[j - 2];
					} else if (j == colSize - 4) {
						dataSet[i][j] = estDlvTm;
					} else if (j == colSize - 3) {
						dataSet[i][j] = estTotCost;
					} else if (j == colSize - 2) {
						dataSet[i][j] = inlndRoutCmgFlg; // Add Combined Flag
					} else if (j == colSize - 1) {
						dataSet[i][j] = inlndRoutTmpFlg; // Add Tmp Flag
					}
				}
			}

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("max_cnt", new Integer(colCnt).toString());
			mapVO.put("io_bnd_Cd", ioBndCd);
			eventResponse.setETCData(mapVO);

			eventResponse.setCustomData("list", dataSet);

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * get MT node
	 * 
	 * @param String cop_no
	 * @param String ioBndCd
	 * @return String
	 * @throws EventException ...
	 */
	public String getMTNode(String cop_no, String ioBndCd) throws EventException {
		String mtNode = "";
		try {
			mtNode = dbDao.getMTNode(cop_no, ioBndCd);
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new EventException(e.getMessage());
		}
		return mtNode;
	}
}
