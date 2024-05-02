/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : SpacecontrolinquiryBCImpl.java
*@FileTitle      : SpacecontrolinquiryBC
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 

=========================================================*/
package com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.spc.common.common.vo.ConditionVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration.SpacecontrolinquiryDBDAO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.ComplexMainVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.ETCVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceAllocationControlFlagListVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiry021AllocPortViewListVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiry021FcastPortViewListVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryConditionVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryContractorVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryCustomerListVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryListVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryOfficeCustomerListVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryOfficeListVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryOfficeSalesOrgListVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryPolPodListVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquirySalesOrgListVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryTradeListVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryRDRDetailListVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlLFSummaryDownVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlLFSummaryListVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlRDRSummaryDownVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlRDRSummaryListVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlTsVolumnListVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchWeeklyLfByPolPodListVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlRDRSummaryListVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlRDRSummaryDownVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.SpcBsaMgmtVO;


/**
 * Spacecontrolinquiry Business Logic Basic Command implementation<br>
 * - handling business transaction for Spacecontrolinquiry<br>
 *
 * @author 
 * @see ESM_SPC_0021EventResponse,SpacecontrolinquiryBC (Reference DAO Class of each)
 * @since J2EE 1.6
 */
public class SpacecontrolinquiryBCImpl extends BasicCommandSupport implements SpacecontrolinquiryBC {

	// Database Access Object
	private transient SpacecontrolinquiryDBDAO dbDao = null;

	/**
	 * SpacecontrolinquiryBCImpl Object creation<br>
	 * SpacecontrolinquiryDBDAO Object creation<br>
	 */
	public SpacecontrolinquiryBCImpl() {
		dbDao = new SpacecontrolinquiryDBDAO();
	}
		
	/**
	 * EsmSpc0021Event retrieve event process<br>
	 * space control info retrieve<br>
	 * 
     * @author
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<ComplexMainVO>
     * @exception EventException
     */	
	public List<ComplexMainVO> searchSpaceControlInquiry021FcastPortViewList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws EventException {
		try {
			List<SearchSpaceControlInquiry021FcastPortViewListVO> inquiry021FcastPortViewListVO = dbDao.searchSpaceControlInquiry021FcastPortViewList(searchSpaceControlInquiryConditionVO);
			List<ETCVO> etc = dbDao.searchETC(searchSpaceControlInquiryConditionVO);
			ComplexMainVO com = new ComplexMainVO();
			com.setInquiry021FcastPortViewListVO(inquiry021FcastPortViewListVO);
			com.setEtc(etc);
			com.setCondition(searchSpaceControlInquiryConditionVO);
			
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();	
			listCom.add(com);
						
			return listCom;			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * EsmSpc0021Event retrieve event process<br>
	 * space control info retrieve<br>
	 * 
     * @author
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @param account SignOnUserAccount
	 * @return List<ComplexMainVO>
     * @exception EventException
     */	
	public List<ComplexMainVO> searchSpaceControlInquiry021AllocPortViewList2(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO, SignOnUserAccount account) throws EventException {
		try {
			DBRowSet rs = dbDao.searchSpaceControlInquiry021AllocPortViewList2(searchSpaceControlInquiryConditionVO, account);
			List<ETCVO> etc = dbDao.searchETC(searchSpaceControlInquiryConditionVO);
			ComplexMainVO com = new ComplexMainVO();
			com.setEtc(etc);
			com.setRs(rs);
			com.setCondition(searchSpaceControlInquiryConditionVO);						
						
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();	
			listCom.add(com);
			
			return listCom;		
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}

	/**
	 * EsmSpc0021Event retrieve event process<br>
	 * space control info retrieve<br>
	 * 
     * @author
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @param account SignOnUserAccount
	 * @return List<ComplexMainVO>
     * @exception EventException
     */	
	public List<ComplexMainVO> searchSpaceControlInquiry021AllocPortViewList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO, SignOnUserAccount account) throws EventException {
		try {
			List<SearchSpaceControlInquiry021AllocPortViewListVO> inquiry021AllocPortViewListVO =  dbDao.searchSpaceControlInquiry021AllocPortViewList(searchSpaceControlInquiryConditionVO, account);
			List<ETCVO> etc = dbDao.searchETC(searchSpaceControlInquiryConditionVO);
			ComplexMainVO com = new ComplexMainVO();
			com.setEtc(etc);
			com.setInquiry021AllocPortViewListVO(inquiry021AllocPortViewListVO);
			com.setCondition(searchSpaceControlInquiryConditionVO);						
						
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();	
			listCom.add(com);
			
			return listCom;			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * EsmSpc0022Event retrieve event process<br>
	 * space control info retrieve<br>
	 * 
     * @author
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<ComplexMainVO>
     * @exception EventException
     */	
	public List<ComplexMainVO> searchSpaceControlInquiryTradeList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws EventException {
		try {
			
			List<SearchSpaceControlInquiryTradeListVO> searchSpaceControlInquiryTradeListVO =  dbDao.searchSpaceControlInquiryTradeList(searchSpaceControlInquiryConditionVO);
			ComplexMainVO com = new ComplexMainVO();
			com.setSearchSpaceControlInquiryTradeListVO(searchSpaceControlInquiryTradeListVO);
			com.setCondition(searchSpaceControlInquiryConditionVO);						
						
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();	
			listCom.add(com);
			
			return listCom;			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * EsmSpc0022Event retrieve event process<br>
	 * space control info retrieve<br>
	 * 
     * @author
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<ComplexMainVO>
     * @exception EventException
     */	
	public List<ComplexMainVO> searchSpaceControlInquirySalesOrgList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws EventException {
		try {
			List<SearchSpaceControlInquirySalesOrgListVO> searchSpaceControlInquirySalesOrgListVO =  dbDao.searchSpaceControlInquirySalesOrgList(searchSpaceControlInquiryConditionVO);
			ComplexMainVO com = new ComplexMainVO();
			com.setSearchSpaceControlInquirySalesOrgListVO(searchSpaceControlInquirySalesOrgListVO);
			com.setCondition(searchSpaceControlInquiryConditionVO);						
						
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();	
			listCom.add(com);
			
			return listCom;			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * EsmSpc0022Event retrieve event process<br>
	 * space control info retrieve<br>
	 * 
     * @author
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<ComplexMainVO>
     * @exception EventException
     */	
	public List<ComplexMainVO> searchSpaceControlInquiryPolPodList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws EventException {
		try {
			List<SearchSpaceControlInquiryPolPodListVO> searchSpaceControlInquiryPolPodListVO =  dbDao.searchSpaceControlInquiryPolPodList(searchSpaceControlInquiryConditionVO);
			ComplexMainVO com = new ComplexMainVO();
			com.setSearchSpaceControlInquiryPolPodListVO(searchSpaceControlInquiryPolPodListVO);
			com.setCondition(searchSpaceControlInquiryConditionVO);						
						
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();	
			listCom.add(com);
			
			return listCom;			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * EsmSpc0022Event retrieve event process<br>
	 * space control info retrieve<br>
	 * 
     * @author
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @param account SignOnUserAccount
	 * @return List<ComplexMainVO>
     * @exception EventException
     */	
	public List<ComplexMainVO> searchSpaceControlInquiryCustomerList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO, SignOnUserAccount account) throws EventException {
		try {
			
			String vvd = searchSpaceControlInquiryConditionVO.getVvd();
			if(vvd.length() == 9){
				searchSpaceControlInquiryConditionVO.setVslCd(vvd.substring(0, 4));
				searchSpaceControlInquiryConditionVO.setSkdVoyNo(vvd.substring(4, 8));
				searchSpaceControlInquiryConditionVO.setSkdDirCd(vvd.substring(8));
			}
			List<SearchSpaceControlInquiryCustomerListVO> searchSpaceControlInquiryCustomerListVO =  dbDao.searchSpaceControlInquiryCustomerList(searchSpaceControlInquiryConditionVO);
			ComplexMainVO com = new ComplexMainVO();
			com.setSearchSpaceControlInquiryCustomerListVO(searchSpaceControlInquiryCustomerListVO);
			com.setCondition(searchSpaceControlInquiryConditionVO);						
						
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();	
			listCom.add(com);
			
			return listCom;			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	

	/**
	 * EsmSpc0022Event retrieve event process<br>
	 * space control info retrieve<br>
	 * 
     * @author
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<ComplexMainVO>
     * @exception EventException
     */	
	public List<ComplexMainVO> searchSpaceControlInquiryContractor(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws EventException {
		try {
			String vvd = searchSpaceControlInquiryConditionVO.getVvd();
			if(vvd.length() == 9){
				searchSpaceControlInquiryConditionVO.setVslCd(vvd.substring(0, 4));
				searchSpaceControlInquiryConditionVO.setSkdVoyNo(vvd.substring(4, 8));
				searchSpaceControlInquiryConditionVO.setSkdDirCd(vvd.substring(8));
			}
			List<SearchSpaceControlInquiryContractorVO> searchSpaceControlInquiryContractorVO =  dbDao.searchSpaceControlInquiryContractor(searchSpaceControlInquiryConditionVO);
			ComplexMainVO com = new ComplexMainVO();
			com.setSearchSpaceControlInquiryContractorVO(searchSpaceControlInquiryContractorVO);
			com.setCondition(searchSpaceControlInquiryConditionVO);						
						
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();	
			listCom.add(com);
			
			return listCom;			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * EsmSpc0024Event retrieve event process<br>
	 * space control info retrieve<br>
	 * 
     * @author
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<ComplexMainVO>
     * @exception EventException
     */	
	public List<ComplexMainVO> searchSpaceControlInquiryNoShowSummaryList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws EventException {
		try {
			DBRowSet rsNoShowSumList = dbDao.searchSpaceControlInquiryNoShowSummaryList(searchSpaceControlInquiryConditionVO);
			ComplexMainVO com = new ComplexMainVO();
			com.setRsNoShowSumList(rsNoShowSumList);
			com.setCondition(searchSpaceControlInquiryConditionVO);						
			
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();	
			listCom.add(com);
			
			return listCom;			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * EsmSpc0024Event retrieve event process<br>
	 * space control info retrieve<br>
	 * 
     * @author
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<ComplexMainVO>
     * @exception EventException
     */	
	public List<ComplexMainVO> searchSpaceControlInquiryNoShowTradeList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws EventException {
		try {
			DBRowSet rs = dbDao.searchSpaceControlInquiryNoShowTradeList(searchSpaceControlInquiryConditionVO);
			ComplexMainVO com = new ComplexMainVO();
			com.setRs(rs);
			com.setCondition(searchSpaceControlInquiryConditionVO);							
						
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();	
			listCom.add(com);
			
			return listCom;			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	

	/**
	 * EsmSpc0024Event retrieve event process<br>
	 * space control info retrieve<br>
	 * 
     * @author
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<ComplexMainVO>
     * @exception EventException
     */	
	public List<ComplexMainVO> searchSpaceControlInquiryNoShowOfficeLaneList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws EventException {
		try {
			DBRowSet rs = dbDao.searchSpaceControlInquiryNoShowOfficeLaneList(searchSpaceControlInquiryConditionVO);
			ComplexMainVO com = new ComplexMainVO();
			com.setRs(rs);
			com.setCondition(searchSpaceControlInquiryConditionVO);								
						
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();	
			listCom.add(com);
			
			return listCom;			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}

	/**
	 * EsmSpc0024Event retrieve event process<br>
	 * space control info retrieve<br>
	 * 
     * @author
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<ComplexMainVO>
     * @exception EventException
     */	
	public List<ComplexMainVO> searchSpaceControlInquiryNoShowLaneOfficeList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws EventException {
		try {
			DBRowSet rs = dbDao.searchSpaceControlInquiryNoShowLaneOfficeList(searchSpaceControlInquiryConditionVO);
			ComplexMainVO com = new ComplexMainVO();
			com.setRs(rs);
			com.setCondition(searchSpaceControlInquiryConditionVO);							
						
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();	
			listCom.add(com);
			
			return listCom;			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	

	/**
	 * EsmSpc0024Event retrieve event process<br>
	 * space control info retrieve<br>
	 * 
     * @author
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<ComplexMainVO>
     * @exception EventException
     */	
	public List<ComplexMainVO> searchSpaceControlInquiryNoShowSubOfficeList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws EventException {
		try {
			DBRowSet rs = dbDao.searchSpaceControlInquiryNoShowSubOfficeList(searchSpaceControlInquiryConditionVO);
			ComplexMainVO com = new ComplexMainVO();
			com.setRs(rs);
			com.setCondition(searchSpaceControlInquiryConditionVO);							
						
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();	
			listCom.add(com);
			
			return listCom;			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * EsmSpc0028Event retrieve event process<br>
	 * space control info retrieve<br>
	 * 
     * @author
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<ComplexMainVO>
     * @exception EventException
     */	
	public List<ComplexMainVO> searchSpaceControlInquiryOfficeList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws EventException {
		try {
			List<SearchSpaceControlInquiryOfficeListVO> searchSpaceControlInquiryOfficeListVO =  dbDao.searchSpaceControlInquiryOfficeList(searchSpaceControlInquiryConditionVO);
			ComplexMainVO com = new ComplexMainVO();
			com.setSearchSpaceControlInquiryOfficeListVO(searchSpaceControlInquiryOfficeListVO);
			com.setCondition(searchSpaceControlInquiryConditionVO);						
						
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();	
			listCom.add(com);
			
			return listCom;				
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * EsmSpc0028Event retrieve event process<br>
	 * space control info retrieve<br>
	 * 
     * @author
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<ComplexMainVO>
     * @exception EventException
     */	
	public List<ComplexMainVO> searchSpaceControlInquiryOfficeSalesOrgList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws EventException {
		try {
			String vvd = searchSpaceControlInquiryConditionVO.getVvd();
			if(vvd.length() == 9){
				searchSpaceControlInquiryConditionVO.setVslCd(vvd.substring(0, 4));
				searchSpaceControlInquiryConditionVO.setSkdVoyNo(vvd.substring(4, 8));
				searchSpaceControlInquiryConditionVO.setSkdDirCd(vvd.substring(8));
			}
			List<SearchSpaceAllocationControlFlagListVO> searchSpaceAllocationControlFlagListVO = dbDao.searchSpaceAllocationControlFlagList(searchSpaceControlInquiryConditionVO);
			List<SearchSpaceControlInquiryOfficeSalesOrgListVO> searchSpaceControlInquiryOfficeSalesOrgListVO = dbDao.searchSpaceControlInquiryOfficeSalesOrgList(searchSpaceControlInquiryConditionVO);
				searchSpaceControlInquiryConditionVO.setPolPod("S");
			List<SearchSpaceControlInquiryOfficeCustomerListVO> searchSpaceControlInquiryOfficeCustomerListVO = dbDao.searchSpaceControlInquiryOfficeCustomerList(searchSpaceControlInquiryConditionVO);
				searchSpaceControlInquiryConditionVO.setPolPod("C");
			List<SearchSpaceControlInquiryOfficeCustomerListVO> searchSpaceControlInquiryOfficeCustomerList2VO = dbDao.searchSpaceControlInquiryOfficeCustomerList(searchSpaceControlInquiryConditionVO);
						
			ComplexMainVO com = new ComplexMainVO();
			com.setSearchSpaceAllocationControlFlagListVO(searchSpaceAllocationControlFlagListVO);
			com.setSearchSpaceControlInquiryOfficeSalesOrgListVO(searchSpaceControlInquiryOfficeSalesOrgListVO);
			com.setSearchSpaceControlInquiryOfficeCustomerListVO(searchSpaceControlInquiryOfficeCustomerListVO);
			com.setSearchSpaceControlInquiryOfficeCustomerList2VO(searchSpaceControlInquiryOfficeCustomerList2VO);
			com.setCondition(searchSpaceControlInquiryConditionVO);						
						
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();	
			listCom.add(com);
			
			return listCom;						
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	

	/**
	 * EsmSpc0026Event retrieve event process<br>
	 * space control info retrieve<br>
	 * 
     * @author
	 * @param ConditionVO conditionVO 
	 * @return List<ComplexMainVO>
     * @exception EventException
     */	
	public  List<ComplexMainVO> searchSpaceControlInquiryList( ConditionVO conditionVO) throws EventException {
		try {
			
			List<SearchSpaceControlInquiryListVO> searchSpaceControlInquiryListVO = dbDao.searchSpaceControlInquiryList( conditionVO);
			ComplexMainVO com = new ComplexMainVO();
			com.setSearchSpaceControlInquiryListVO(searchSpaceControlInquiryListVO);
						
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();	
			listCom.add(com);
			
			return listCom;			
						
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}

	
	/**
	 * [ESM_SPC_0080]을 [행 위] 합니다.<br>
	 * 
	 * 2010.08.25 최윤성 [CHM-201005492-01] RDR 실적 Summary 기능 개발 메소드 추가
	 * 2010.10.19 최윤성 [CHM-201006585-01] 2010년 연간개발계획 - full+empty L/F summary 화면 개발.
	 * @param ConditionVO conditionVO
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlRDRSummaryList(ConditionVO conditionVO) throws EventException {
		try {
			List<SearchSpaceControlRDRSummaryListVO> searchSpaceControlRDRSummaryListVO = dbDao.searchSpaceControlRDRSummaryList(conditionVO);
			List<ETCVO> etc = dbDao.searchETC(conditionVO);
			ComplexMainVO com = new ComplexMainVO();
			com.setSearchSpaceControlRDRSummaryListVO(searchSpaceControlRDRSummaryListVO);
			com.setEtc(etc);
			com.setConditionVO(conditionVO);
			
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();	
			listCom.add(com);
						
			return listCom;			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * [ESM_SPC_0080]을 [행 위] 합니다.<br>
	 * 
	 * 2010.08.25 최윤성 [CHM-201005492-01] RDR 실적 Summary 기능 개발 메소드 추가
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlRDRSummaryDown(ConditionVO conditionVO) throws EventException {
		try {
			List<SearchSpaceControlRDRSummaryDownVO> searchSpaceControlRDRSummaryDownVO = dbDao.searchSpaceControlRDRSummaryDown(conditionVO);
			ComplexMainVO com = new ComplexMainVO();
			com.setSearchSpaceControlRDRSummaryDownVO(searchSpaceControlRDRSummaryDownVO);
			com.setConditionVO(conditionVO);
			
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();	
			listCom.add(com);
						
			return listCom;			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	

	/**
	 * [ESM_SPC_0081]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO 
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public  List<ComplexMainVO> searchSpaceControlInquiryRDRDetailList( ConditionVO conditionVO) throws EventException {
		try {
			
			List<SearchSpaceControlInquiryRDRDetailListVO> searchSpaceControlInquiryRDRDetailListVO = dbDao.searchSpaceControlInquiryRDRDetailList(conditionVO);
			ComplexMainVO com = new ComplexMainVO();
			com.setSearchSpaceControlInquiryRDRDetailListVO(searchSpaceControlInquiryRDRDetailListVO);
			
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();	
			listCom.add(com);
			
			return listCom;			
						
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}	
	
	/**
	 * [ESM_SPC_0082]을 [행 위] 합니다.<br>
	 * 
	 * 2010.10.19 최윤성 [CHM-201006585-01] 2010년 연간개발계획 - full+empty L/F summary 화면 개발.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlLFSummaryList(ConditionVO conditionVO) throws EventException {
		try {
			List<SearchSpaceControlLFSummaryListVO> searchSpaceControlLFSummaryListVO = dbDao.searchSpaceControlLFSummaryList(conditionVO);
			List<ETCVO> etc = dbDao.searchETC(conditionVO);
			ComplexMainVO com = new ComplexMainVO();
			com.setSearchSpaceControlLFSummaryListVO(searchSpaceControlLFSummaryListVO);
			com.setEtc(etc);
			com.setConditionVO(conditionVO);
			
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();	
			listCom.add(com);
						
			return listCom;			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * [ESM_SPC_0082]을 [행 위] 합니다.<br>
	 * 
	 * 2010.10.19 최윤성 [CHM-201006585-01] 2010년 연간개발계획 - full+empty L/F summary 화면 개발.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlLFSummaryDown(ConditionVO conditionVO) throws EventException {
		try {
			List<SearchSpaceControlLFSummaryDownVO> searchSpaceControlLFSummaryDownVO = dbDao.searchSpaceControlLFSummaryDown(conditionVO);
			ComplexMainVO com = new ComplexMainVO();
			com.setSearchSpaceControlLFSummaryDownVO(searchSpaceControlLFSummaryDownVO);
			com.setConditionVO(conditionVO);
			
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();	
			listCom.add(com);
						
			return listCom;			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * [ESM_SPC_0083]을 Weekly L/F by POL/POD 리스트를 조회 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO 
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public  List<ComplexMainVO> searchWeeklyLfByPolPodList( ConditionVO conditionVO) throws EventException {
		try {
			String costWk=  conditionVO.getWeek();
			if ( !conditionVO.getVvd().trim().equals("")) {
				costWk= dbDao.searchVvdCostYrwk(conditionVO);	//vvd에 해당하는 년과 주차를 가져온다.
				if ( !costWk.equals("" )) {
					conditionVO.setYear(costWk.substring(0,4));
					conditionVO.setWeek(costWk.substring(4,6));
					conditionVO.setDuration("1");
				}
			}
			
			List<SearchWeeklyLfByPolPodListVO> searchLoadingByPolPodListVO = dbDao.searchWeeklyLfByPolPodList(conditionVO);
			ComplexMainVO com = new ComplexMainVO();
			com.setSearchWeeklyLfByPolPodListVO(searchLoadingByPolPodListVO);
			com.setConditionVO(conditionVO);	//EsmSpc0083ViewAdapter에서 polpod_flg 값 사용을 위한 세팅 
			
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();
			listCom.add(com);
			
			return listCom;			
						
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}

	/**
	 * [ESM_SPC_0083]의 주어진 기간의 주차,년월 목록을 조회<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchLoadingByPolPodListVO>
	 * @exception EventException
	 */
	public List<SearchWeeklyLfByPolPodListVO> searchMonthWeekList(ConditionVO conditionVO) throws EventException {
		List<SearchWeeklyLfByPolPodListVO> list = null;
		String base_dt = "";
		try {
			if ( !conditionVO.getVvd().equals("")) {	//vvd값이 있을시 vvd의 해당 1주차를 찾는다.
				list = new ArrayList<SearchWeeklyLfByPolPodListVO>();
				base_dt = dbDao.searchVvdCostYrwk(conditionVO);
				SearchWeeklyLfByPolPodListVO searchWeeklyLfByPolPodListVO = new SearchWeeklyLfByPolPodListVO();
				if ( !base_dt.equals("")) {
					searchWeeklyLfByPolPodListVO.setCostYrwk(base_dt);
				} else {
					searchWeeklyLfByPolPodListVO.setCostYrwk(conditionVO.getYear()+conditionVO.getWeek());
				}
				list.add(0, searchWeeklyLfByPolPodListVO);
			} else {	//VVD값이 조회조건에 없을시 Duration 검색
				list = dbDao.searchMonthWeekList(conditionVO);
			}
			return list;
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
	}
	
	/**
	 * [ESM_SPC_0084]을 BSA INPUT DATA 리스트를 조회 합니다.<br>
	 * @param SpcBsaMgmtVO spcBsaMgmtVO
	 * @return List<SpcBsaMgmtVO>
	 * @exception EventException
	 */
	public  List<SpcBsaMgmtVO> searchSpaceContorlInquiryBSA( SpcBsaMgmtVO spcBsaMgmtVO) throws EventException {
		try {
			return dbDao.searchSpaceContorlInquiryBSA(spcBsaMgmtVO);	
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * [ESM_SPC_0056]을 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlTsVolumnList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws EventException {
		try {
			List<SearchSpaceControlTsVolumnListVO> searchSpaceControlTsVolumnListVO = dbDao.searchSpaceControlTsVolumnList(searchSpaceControlInquiryConditionVO);
			
			ComplexMainVO com = new ComplexMainVO();
			com.setSearchSpaceControlTsVolumnListVO(searchSpaceControlTsVolumnListVO);
			com.setCondition(searchSpaceControlInquiryConditionVO);						
						
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();	
			listCom.add(com);
			
			return listCom;						
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
}