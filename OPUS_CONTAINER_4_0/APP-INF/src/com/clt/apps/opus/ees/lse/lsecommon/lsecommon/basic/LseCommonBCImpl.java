/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LseCommonBCImpl.java
*@FileTitle : ETC LesCommon Code Search
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.ees.lse.lsecommon.lsecommon.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.lse.lsecommon.lsecommon.vo.SearchInvoiceNoVO;
import com.clt.apps.opus.ees.lse.lsecommon.lsecommon.integration.LseCommonDBDAO;
import com.clt.apps.opus.ees.lse.lsecommon.lsecommon.vo.CdListVO;
import com.clt.apps.opus.ees.lse.lsecommon.lsecommon.vo.LseRntlCostAcctOrdVO;
import com.clt.apps.opus.ees.mst.mstcommon.mstcommon.vo.CommonListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.MdmLocationVO;
import com.clt.syscommon.common.table.MdmOrganizationVO;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;
import com.clt.syscommon.common.table.MstContainerVO;
import com.clt.syscommon.common.table.VskVslPortSkdVO;

/**
 * LseCommon system Business Logic Basic Command implementation<br>
 * Handling a business transaction about LseCommon<br>
 *
 * @author
 * @see LseCommonBCImpl - refer to each DAO class
 * @since J2EE 1.6
 */
public class LseCommonBCImpl extends BasicCommandSupport implements LseCommonBC {
	// Database Access Object
	private transient LseCommonDBDAO dbDao = null;

	/**
	 * Creating LseCommonBCImpl object<br>
	 * Creating LseCommonDBDAO<br> 
	 */
	public LseCommonBCImpl() {
		dbDao = new LseCommonDBDAO();
	}

	/**
	 * Retrieving code list for Location-Port<br>
	 *
	 * @param  String locCd
	 * @return List<MdmLocationVO>
	 * @exception EventException
	 */
	public List<MdmLocationVO> searchLocationPortBasic(String locCd) throws EventException {
		List<MdmLocationVO>  list = null;

		try {
			list = dbDao.searchLocationPortData(locCd);

			if ( list.size() < 1 ) {
				throw new EventException(new ErrorHandler("LSE01048").getMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return list;
	}

	/**
	 * Retrieving list for Vessel SKD<br>
	 *
	 * @param  String vvdCd
	 * @return List<VskVslPortSkdVO>
	 * @exception EventException
	 */
	public List<VskVslPortSkdVO> searchVesselSkdBasic(String vvdCd) throws EventException {
		List<VskVslPortSkdVO>  list = null;

		try {
			list = dbDao.searchVesselSkdData(vvdCd);

			if ( list.size() < 1 ) {
				throw new EventException(new ErrorHandler("LSE01048").getMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return list;
	}

	/**
	 * Retrieving information for Container<br>
	 *
	 * @param  String cntrNo
	 * @return MstContainerVO
	 * @exception EventException
	 */
	public MstContainerVO searchContainerInfoBrieflyBasic(String cntrNo) throws EventException {
		List<MstContainerVO> list = null;

		try {
			list = dbDao.searchContainerInfoBrieflyData(cntrNo);

			if ( list.size() < 1 ) {
				throw new EventException(new ErrorHandler("LSE01048").getMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return list.get(0);
	}

	/**
	 * Retrieving code list for Office<br>
	 *
	 * @param  String ofcCd
	 * @return List<MdmOrganizationVO>
	 * @exception EventException
	 */
	public List<MdmOrganizationVO> searchOfficeCodeBasic(String ofcCd) throws EventException {
		List<MdmOrganizationVO>  list = null;

		try {
			list = dbDao.searchOfficeCodeData(ofcCd);

			if ( list.size() < 1 ) {
				throw new EventException(new ErrorHandler("LSE01048").getMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return list;
	}

	/**
	 * Retrieving list for Vessel SVC Lane<br>
	 *
	 * @param  String slanCd
	 * @return List<MdmVslSvcLaneVO>
	 * @exception EventException
	 */
	public List<MdmVslSvcLaneVO> searchServiceLaneBasic(String slanCd) throws EventException {
		List<MdmVslSvcLaneVO>  list = null;

		try {
			list = dbDao.searchServiceLaneData(slanCd);

			if ( list.size() < 1 ) {
				throw new EventException(new ErrorHandler("LSE01048").getMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return list;
	}
	
	/**
	 * Retrieving list for Container Use Company<br>
	 *
	 * @param  CdListVO cdListVO
	 * @return List<CdListVO>
	 * @exception EventException
	 */
	public List<CdListVO> searchCntrUseCoCdListBasic(CdListVO cdListVO) throws EventException {
		
		List<CdListVO> list = null;

		try {
			list = dbDao.searchCntrUseCoCdListData(cdListVO);
			if ( list.size() < 1 ) {
				new EventException(new ErrorHandler("LSECommon",new String[]{"Container Use Company Information"}).getMessage());
			}
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{}).getMessage(),ex);
		}
		return list;
	}
	
	/**
	 * Retrieving list for Company<br>
	 *
	 * @param  CdListVO cdListVO
	 * @return List<CdListVO>
	 * @exception EventException
	 */
	public List<CdListVO> searchCompanyListBasic(CdListVO cdListVO) throws EventException {
		
		List<CdListVO> list = null;

		try {
			list = dbDao.searchCompanyListData(cdListVO);
			if ( list.size() < 1 ) {
				new EventException(new ErrorHandler("LSECommon",new String[]{"Container Use Company Information"}).getMessage());
			}
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{}).getMessage(),ex);
		}
		return list;
	}
	
	/**
	 * Retrieving list for LP Term Lessor<br>
	 *
	 * @param  CdListVO cdListVO
	 * @return List<CdListVO>
	 * @exception EventException
	 */
	public List<CdListVO> searchVndrSeqListBasic(CdListVO cdListVO) throws EventException {
		
		List<CdListVO> list = null;

		try {
			list = dbDao.searchVndrSeqListData(cdListVO);
			if ( list.size() < 1 ) {
				new EventException(new ErrorHandler("LSECommon",new String[]{"Container Use Company Information"}).getMessage());
			}
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{}).getMessage(),ex);
		}
		return list;
	}

	/**
	 * Retrieving list for LP Term Lessor<br>
	 *
	 * @return List<LseRntlCostAcctOrdVO>
	 * @exception EventException
	 */
	@Override
	public List<LseRntlCostAcctOrdVO> searchRentalCostAccountOrdBasic() throws EventException {
		try {
			return dbDao.searchRentalCostAccountOrdData();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Retrieving list for LP Term Lessor<br>
	 *
	 * @param lseRntlCostAcctOrdVOs LseRntlCostAcctOrdVO[]
	 * @exception EventException
	 */
	@Override
	public void manageRentalCostAccountOrdBasic(LseRntlCostAcctOrdVO[] lseRntlCostAcctOrdVOs) throws EventException {
		try {
			List<LseRntlCostAcctOrdVO> insertVoList = new ArrayList<LseRntlCostAcctOrdVO>();
			List<LseRntlCostAcctOrdVO> updateVoList = new ArrayList<LseRntlCostAcctOrdVO>();
			List<LseRntlCostAcctOrdVO> deleteVoList = new ArrayList<LseRntlCostAcctOrdVO>();
			
			for (int i = 0; i < lseRntlCostAcctOrdVOs.length; i++) {
				if (lseRntlCostAcctOrdVOs[i].getIbflag().equals("I")) {
					insertVoList.add(lseRntlCostAcctOrdVOs[i]);
				} else if (lseRntlCostAcctOrdVOs[i].getIbflag().equals("U")) {
					updateVoList.add(lseRntlCostAcctOrdVOs[i]);
				} else if (lseRntlCostAcctOrdVOs[i].getIbflag().equals("D")) {
					deleteVoList.add(lseRntlCostAcctOrdVOs[i]);
				}
			}
			
			if (insertVoList.size() > 0) {
				dbDao.addRentalCostAccountOrdData(insertVoList);
			}
			
			if (updateVoList.size() > 0) {
				dbDao.modifyRentalCostAccountOrdData(updateVoList);
			}
			
			if (deleteVoList.size() > 0) {
				dbDao.removeRentalCostAccountOrdData(deleteVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	/**
	 * Retriving Charge Type Code <br>
	 * 
	 * @return List<LseRntlCostAcctOrdVO>
	 * @exception EventException
	 */
	public List<LseRntlCostAcctOrdVO> searchChargeTpCd() throws EventException {
		try {
			return dbDao.searchChargeTpCd();
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("LSE10005", new String[]{""}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("LSE10005", new String[]{""}).getMessage(), ex);
		}		
	} 
	
	/** 
	 * Retriving Lease Term Code <br>
	 * 
	 * @return List<LseRntlCostAcctOrdVO>
	 * @exception EventException
	 */
	public List<LseRntlCostAcctOrdVO> searchLeaseTerm() throws EventException {
		try {
			return dbDao.searchLeaseTerm();
       } catch (DAOException ex) {
           log.error("err " + ex.toString(), ex);
           throw new EventException(new ErrorHandler("LSE10005", new String[]{""}).getMessage(), ex);
       } catch (Exception ex) {
           log.error("err " + ex.toString(), ex);
           throw new EventException(new ErrorHandler("LSE10005", new String[]{""}).getMessage(), ex);
		}		
	}
	
	/**
	 * : retrieve<br>
	 * l Code<br>
	 * @param intgCdId String
	 * @return List<CommonListVO> 
	 * @exception EventException
	 */	
	public List<CommonListVO> searchComIntgCdBasic(String intgCdId) throws EventException { 
		try {
			return dbDao.searchComIntgCdListData(intgCdId);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Search Unit Type Code"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Search Unit Type Code"}).getMessage(),ex);
		}
	}
	
	
	/**
	 * Search The Invoice No.
	 * @param SearchInvoiceNoVO searchInvoiceNoVO
	 * @return List<SearchInvoiceNoVO>
	 * @exception EventException
	 */
	public List<SearchInvoiceNoVO> searchInvoiceNo(SearchInvoiceNoVO searchInvoiceNoVO) throws EventException {
		
		List<SearchInvoiceNoVO> list = null;
		
		try {
			 list = dbDao.searchInvoiceNo(searchInvoiceNoVO);
		} catch (DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(de.getMessage());
			//throw new EventException(new ErrorHandler("CSR10005",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
			//throw new EventException(new ErrorHandler("CSR10005",new String[]{}).getMessage(), ex);
		}
		
		return list;
	}
	
	/**
	 * Search Blud Up Date
	 * @param String schDate 
	 * @param String agmtSeq 
	 * @return String
	 * @exception EventException
	 */	
	public String searchBldUpDateCheckBasic(String schDate, String agmtSeq) throws EventException { 
		String reString 	= 	"";
		try {
			reString =  dbDao.searchBldUpDateCheckData(schDate, agmtSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Search Unit Type Code"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Search Unit Type Code"}).getMessage(),ex);
		}
		
		return reString;
	}
	

}