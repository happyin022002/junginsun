/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EqInterchangeRequestBCImpl.java
*@FileTitle : EQ Interchange Request
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.21
*@LastModifier : 길정권
*@LastVersion : 1.0
* 2015.05.21 길정권
* 1.0 Creation
* 2015-07-09 [CHM-201536018] EQ INTERCHANGE WORK module 신규 개발 제안
=========================================================*/

package com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.basic;
import java.util.List;

import com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.integration.EqInterchangeRequestDBDAO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.vo.AvailableOnewayInventoryVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.vo.EqInterchangeDetailVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.vo.EqInterchangeReqVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.vo.EqInterchangeSummaryVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.vo.EqInterchangeVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.vo.SearchOfferInquiryVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.vo.SearchParamVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-EQ Interchange Request Business Logic Basic Command implementation<br>
 * - ALPS-ContainerLeaseMgt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Jikkil
 * @see EES_LSE_0107EventResponse,EqInterchangeRequestBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */


public class EqInterchangeRequestBCImpl extends BasicCommandSupport implements EqInterchangeRequestBC{
	// Database Access Object
	private transient EqInterchangeRequestDBDAO dbDao = null;

	/**
	 * EqInterchangeRequestBCImpl 객체 생성<br>
	 * EqInterchangeRequestDBDAO를 생성한다.<br>
	 */
	public EqInterchangeRequestBCImpl() {
		dbDao = new EqInterchangeRequestDBDAO();
	}
	
	/**
	 * EQ Interchange Request 처리에 대한 진행 상황을  조회<br>
	 *
	 * @param  EqInterchangeReqVO eqInterchangeReqVO
	 * @return List<EqInterchangeReqVO>
	 * @exception EventException
	 */
	public List<EqInterchangeReqVO> searchEqInterchangeRequestBasic(EqInterchangeReqVO eqInterchangeReqVO) throws EventException {
		List<EqInterchangeReqVO> list = null;
		try {
			list = dbDao.searchEqInterchangeRequestData(eqInterchangeReqVO);

		} catch(DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Eq Interchange Request Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Eq Interchange Request Search"}).getMessage(),ex);
		}
		return list;
	}
	
	/**
	 * EQ Interchange Request를 저장 처리함<br>
	 *
	 * @param EqInterchangeReqVO[] eqInterchangeReqVOS
	 * @param SignOnUserAccount userAccount
	 * @return String
	 * @exception EventException
	 */
	public String modifyEqInterchangeRequestBasic(EqInterchangeReqVO[] eqInterchangeReqVOS, SignOnUserAccount userAccount ) throws EventException {
	     try {
	    	 String vReqNo = dbDao.searchEqInterchangeReqNo(eqInterchangeReqVOS[0].getLstmCd());
	    	 String retReqNo = "N";
	    	 log.debug("\n\n req_no ==> " + vReqNo + "\n\n");

	    	 for(int i=0; i < eqInterchangeReqVOS.length; i++){
		    	 eqInterchangeReqVOS[i].setUpdUsrId(userAccount.getUsr_id());
		    	 log.debug("\n\n IBflag => "+eqInterchangeReqVOS[i].getIbflag()+"\n\n");
	    		 if ( eqInterchangeReqVOS[i].getIbflag().equals("I") ) {
	    			 log.debug("\n\n getReqNo => " + eqInterchangeReqVOS[i].getReqNo() + " <===> " + vReqNo + " getComboReqNo = " + eqInterchangeReqVOS[0].getComboReqNo()+ " \n\n");
	    			 if( eqInterchangeReqVOS[0].getComboReqNo().equals("")){ // Retrieve And Insert
	    				 eqInterchangeReqVOS[i].setReqNo(vReqNo);
		    			 eqInterchangeReqVOS[i].setReqSeq(Integer.toString(i+1));
		    			 retReqNo = "Y";
	    			 }else {
	    				 eqInterchangeReqVOS[i].setReqNo(eqInterchangeReqVOS[0].getComboReqNo());
		    			 String vReqSeq = dbDao.searchEqInterchangeSetReqSeq(eqInterchangeReqVOS[0].getComboReqNo());
	    				 eqInterchangeReqVOS[i].setReqSeq(vReqSeq);
	    			 }
	    			 dbDao.addEqInterchangeReqVO(eqInterchangeReqVOS[i]);
	    		 }else if ( eqInterchangeReqVOS[i].getIbflag().equals("U") )
	    			 dbDao.updateEqInterchangeReqVO(eqInterchangeReqVOS[i]);
	    		 else if ( eqInterchangeReqVOS[i].getIbflag().equals("D") )
	    			 dbDao.removeEqInterchangeReqVOs(eqInterchangeReqVOS[i]);
	    	 }
	    	 //if(eqInterchangeReqVOS[eqInterchangeReqVOS.length -1].getIbflag().equals("I"))
	    	 if(retReqNo.equals("Y"))
	    		 return vReqNo;
	    	 else
	    		 return "";
	    	 	 //return eqInterchangeReqVOS[0].getReqNo();
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Eq Interchange Request Save"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Eq Interchange Request Save"}).getMessage(), ex);
		}
	}	
	
	/**
	 * Req No 조회 이벤트 처리<br>
	 * EQ interchange 화면에 대한 Req No조회 이벤트 처리<br>
	 * 
	 * @param  EqInterchangeReqVO eqInterchangeReqVO
	 * @return List<EqInterchangeReqVO>
	 * @exception EventException
	 */
    public List<EqInterchangeReqVO> searchEqInterchangeReqNumberService(EqInterchangeReqVO eqInterchangeReqVO) throws EventException {
     	try {
			return dbDao.searchEqInterchangeReqNumberData(eqInterchangeReqVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"searchEqInterchangeReqNumberService Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"searchEqInterchangeReqNumberService Search"}).getMessage(),ex);
		}
	}
    
    /**
	 * EMU Cost 조회 이벤트 처리<br>
	 * EQ interchange 화면에 대한 EMU Cost조회 이벤트 처리<br>
	 * 
	 * @param  EqInterchangeReqVO eqInterchangeReqVO
	 * @return List<EqInterchangeReqVO>
	 * @exception EventException
	 */
    public EqInterchangeReqVO searchEqInterchangeEMUCostService(EqInterchangeReqVO eqInterchangeReqVO) throws EventException {
    	 
    	  EqInterchangeReqVO transVO = new EqInterchangeReqVO();
		try {
			 if(eqInterchangeReqVO.getLstmCd().equals("OF")){
				 transVO.setPorCost(JSPUtil.getNull(dbDao.searchEmuCost(eqInterchangeReqVO.getLocGrp() , "O" ,eqInterchangeReqVO.getTpszCd() , eqInterchangeReqVO.getLocFm()),"0"));
				 transVO.setDelCost(JSPUtil.getNull(dbDao.searchEmuCost(eqInterchangeReqVO.getLocGrp() , "D" , eqInterchangeReqVO.getTpszCd() , eqInterchangeReqVO.getLocTo()),"0"));
			 }else if(eqInterchangeReqVO.getLstmCd().equals("SO")){
				 transVO.setSboCost(JSPUtil.getNull(dbDao.searchEmuCost(eqInterchangeReqVO.getLocGrp() , "D" , eqInterchangeReqVO.getTpszCd() , eqInterchangeReqVO.getLocFm()),"0"));
				 transVO.setSbiCost(JSPUtil.getNull(dbDao.searchEmuCost(eqInterchangeReqVO.getLocGrp() , "O" , eqInterchangeReqVO.getTpszCd() , eqInterchangeReqVO.getLocTo()),"0"));	    				 
			 }
		 	return transVO;
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"searchEqInterchangeEMUCostService Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"searchEqInterchangeEMUCostService Search"}).getMessage(),ex);
		}
	}
	/**
	 * EQ Interchange Approval 처리에 대한 진행 상황을  조회<br>
	 *
	 * @param  EqInterchangeReqVO eqInterchangeReqVO
	 * @return List<EqInterchangeReqVO>
	 * @exception EventException
	 */
	public List<EqInterchangeReqVO> searchEqInterchangeApprovalBasic(EqInterchangeReqVO eqInterchangeReqVO) throws EventException {
		List<EqInterchangeReqVO> list = null;
		try {
			list = dbDao.searchEqInterchangeApprovalData(eqInterchangeReqVO);

		} catch(DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Eq Interchange Request Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Eq Interchange Request Search"}).getMessage(),ex);
		}
		return list;
	}
	
	/**
	 * EQ Interchange Approval을 Creation 처리함<br>
	 *
	 * @param EqInterchangeReqVO[] eqInterchangeReqVOS
	 * @param SignOnUserAccount userAccount
	 * @return String
	 * @exception EventException
	 */
	public String modifyEqInterchangeApprovalBasic(EqInterchangeReqVO[] eqInterchangeReqVOS, SignOnUserAccount userAccount ) throws EventException {
	     try {
	    	 String vAuthNo = dbDao.searchEqInterchangeAuthNo(eqInterchangeReqVOS[0].getLocCd(), eqInterchangeReqVOS[0].getLstmCd());
	    	 log.debug("\n\n auth_no ==> " + vAuthNo + "\n\n");

	    	 for(int i=0; i < eqInterchangeReqVOS.length; i++){
		    	 eqInterchangeReqVOS[i].setUpdUsrId(userAccount.getUsr_id());								
	    		 if ( eqInterchangeReqVOS[i].getIbflag().equals("I") ) {
	    			 eqInterchangeReqVOS[i].setAuthNo(vAuthNo);
	    			 eqInterchangeReqVOS[i].setAuthSeq(Integer.toString(i+1));
	    			 
	    			 dbDao.addEqInterchangeApprovalVO(eqInterchangeReqVOS[i]);
	    		 }
	    	}
	    	return vAuthNo;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Eq Interchange Approval Save"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Eq Interchange Approval Save"}).getMessage(), ex);
		}
	}
	
	/**
	 * EQ Interchange Update 처리에 대한 진행 상황을  조회<br>
	 *
	 * @param  EqInterchangeVO eqInterchangeVO
	 * @return List<EqInterchangeReqVO>
	 * @exception EventException
	 */
	public List<EqInterchangeVO> searchEqInterchangeUpdateBasic(EqInterchangeVO eqInterchangeVO) throws EventException {
		List<EqInterchangeVO> list = null;
		try {
			list = dbDao.searchEqInterchangeUpdateData(eqInterchangeVO);

		} catch(DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Eq Interchange Update Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Eq Interchange Update Search"}).getMessage(),ex);
		}
		return list;
	}

	
	/**
	 * Auth No 조회 이벤트 처리<br>
	 * EQ interchange Update 화면에 대한 Auth No조회 이벤트 처리<br>
	 * 
	 * @param  EqInterchangeVO eqInterchangeVO
	 * @return  List<EqInterchangeVO>
	 * @exception EventException
	 */
    public List<EqInterchangeVO> searchEqInterchangeAuthNumberDataService(EqInterchangeVO eqInterchangeVO) throws EventException {
     	try {
			return dbDao.searchEqInterchangeAuthNumberData(eqInterchangeVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"searchEqInterchangeAuthNumberDataService Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"searchEqInterchangeAuthNumberDataService Search"}).getMessage(),ex);
		}
	}
    
    /**
	 * EQ Interchange Update를 저장 처리함<br>
	 *
	 * @param EqInterchangeVO[] eqInterchangeVOS
	 * @param SignOnUserAccount userAccount
	 * @exception EventException
	 */
	public void modifyEqInterchangeUpdateService(EqInterchangeVO[] eqInterchangeVOS, SignOnUserAccount userAccount ) throws EventException {
	     try {
	    	 for(int i=0; i < eqInterchangeVOS.length; i++){
	    		 eqInterchangeVOS[i].setUpdUsrId(userAccount.getUsr_id());								
	    		 if ( eqInterchangeVOS[i].getIbflag().equals("U") )
	    			 dbDao.updateEqInterchangeUpdate(eqInterchangeVOS[i]);
	    	 }

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Eq Interchange Request Save"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Eq Interchange Request Save"}).getMessage(), ex);
		}
	}	
	
	  /**
		 * EQ Interchange Update를 저장 처리함<br>
		 *
		 * @param EqInterchangeVO[] eqInterchangeVOS
		 * @param SignOnUserAccount userAccount
		 * @exception EventException
		 */
		public void modifyEqInterchangeUpdateCancelService(EqInterchangeVO[] eqInterchangeVOS, SignOnUserAccount userAccount ) throws EventException {
		     try {
		    	 for(int i=0; i < eqInterchangeVOS.length; i++){
		    		 eqInterchangeVOS[i].setUpdUsrId(userAccount.getUsr_id());								
		    		 if ( eqInterchangeVOS[i].getIbflag().equals("U") )
		    			 dbDao.updateEqInterchangeAuthNoCancel(eqInterchangeVOS[i]);
		    		     dbDao.updateEqInterchangeReqNoCancel(eqInterchangeVOS[i]);
		    	 }

			} catch (DAOException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("LSE10005",new String[]{"Eq Interchange Request Save"}).getMessage(), ex);
			} catch (Exception ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("LSE10005",new String[]{"Eq Interchange Request Save"}).getMessage(), ex);
			}
		}

		/**
		 * EQ Interchange offer inquiry 처리에 대한 진행 상황을  조회<br>
		 *
		 * @param  SearchOfferInquiryVO searchOfferInquiryVO
		 * @return List<SearchOfferInquiryVO>
		 * @exception EventException
		 */
		public List<SearchOfferInquiryVO> searchOfferInquiryService(SearchOfferInquiryVO searchOfferInquiryVO) throws EventException {
			List<SearchOfferInquiryVO> list = null;
			try {
				list = dbDao.searchOfferInquiryData(searchOfferInquiryVO);

			} catch(DAOException ex) {
				log.error(ex.getMessage());
				throw new EventException(new ErrorHandler("LSE10005", new String[]{"Eq Interchange Request Search"}).getMessage(),ex);
			} catch (Exception ex) {
				log.error(ex.getMessage());
				throw new EventException(new ErrorHandler("LSE10005", new String[]{"Eq Interchange Request Search"}).getMessage(),ex);
			}
			return list;
		}
		
		/**
		 * EQ interchange pick-up/off-hire 현황목록을 조회합니다.<br>
		 *
		 * @param  SearchParamVO searchParamVO
		 * @return List<EqInterchangeSummaryVO>
		 * @throws EventException
		 */
		public List<EqInterchangeSummaryVO> searchEqInterchangeSummaryListBasic(SearchParamVO searchParamVO) throws EventException {
			List<EqInterchangeSummaryVO> resultVOs = null; // 데이터 전송을 위해 VO 객체

			try {
				resultVOs = dbDao.searchEqInterchangeSummaryListData(searchParamVO);
			} catch(DAOException de) {
				log.error("err " + de.getMessage(), de);
				throw new EventException(new ErrorHandler("LSE10005", new String[]{"EqInterchangeSummary Search"}).getMessage(),de);
			} catch (Exception ex) {
				log.error("err " + ex.getMessage(), ex);
				throw new EventException(new ErrorHandler("LSE10005", new String[]{"EqInterchangeSummary Search"}).getMessage(),ex);
			}

			return resultVOs;
		}

		/**
		 * EQ interchange pick-up/off-hire 상세내역을 조회합니다..<br>
		 *
		 * @param  SearchParamVO searchParamVO
		 * @return List<SubLeaseOutDetailVO>
		 * @throws EventException
		 */
		public List<EqInterchangeDetailVO> searchEqInterchangeContainerDetailBasic(SearchParamVO searchParamVO) throws EventException {
			List<EqInterchangeDetailVO> resultVOs = null; // 데이터 전송을 위해 VO 객체

			try {
				resultVOs = dbDao.searchEqInterchangeContainerDetailData(searchParamVO);

				//if(resultVOs.size() > 0) {
				//	resultVOs.get(0).setMaxRows(dbDao.searchEqInterchangeContainerCountData(searchParamVO));
				//}
			} catch(DAOException de) {
				log.error("err " + de.getMessage(), de);
				throw new EventException(new ErrorHandler("LSE10005", new String[]{"EqInterchangeContainerDetail Search"}).getMessage(),de);
			} catch (Exception ex) {
				log.error("err " + ex.getMessage(), ex);
				throw new EventException(new ErrorHandler("LSE10005", new String[]{"EqInterchangeContainerDetail Search"}).getMessage(),ex);
			}

			return resultVOs;
		}
		
		/**
		 * Available Oneway Inventory 조회<br>
		 * 
	     * @param String locFmTp
	     * @param String locFm
	     * @param String dpsl
	     * @param String orgCntrTpszCd
	     * @param String trd
	     * @param String locTp
	     * @param String locTo
	     * @param String sts
	     * @param String stay
	     * @param String dys
	     * @param String agmtSeq
	     * @param String vndrSeq
		 * @return List<AvailableOnewayInventoryVO>
		 * @exception EventException
		 */
		public List<AvailableOnewayInventoryVO> searchAvailableOnewaySummaryBasic(String locFmTp,String locFm,String dpsl,String orgCntrTpszCd,String trd,String locTp,String locTo,String sts,String stay,String dys,String agmtSeq,String vndrSeq) throws EventException {
			List<AvailableOnewayInventoryVO> resultVOs = null; // 데이터 전송을 위해 VO 객체

			try {
				resultVOs = dbDao.searchAvailableOnewaySummaryData(locFmTp,locFm,dpsl,orgCntrTpszCd,trd,locTp,locTo,sts,stay,dys,agmtSeq,vndrSeq);
			} catch (DAOException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("LSE10005", new String[]{"Available Oneway Inventory Summary Search"}).getMessage(),ex);
			} catch (Exception ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("LSE10005", new String[]{"Available Oneway Inventory Summary Search"}).getMessage(),ex);
			}
			
			return resultVOs;
		}
		
		/**
		 * Available Oneway Inventory 조회<br>
		 * 
	     * @param String locFmTp
	     * @param String locFm
	     * @param String dpsl
	     * @param String orgCntrTpszCd
	     * @param String trd
	     * @param String locTp
	     * @param String locTo
	     * @param String sts
	     * @param String stay
	     * @param String dys
	     * @param String agmtSeq
	     * @param String vndrSeq
		 * @return List<AvailableOnewayInventoryVO>
		 * @exception EventException
		 */
		public List<AvailableOnewayInventoryVO> searchAvailableOnewayListBasic(String locFmTp,String locFm,String dpsl,String orgCntrTpszCd,String trd,String locTp,String locTo,String sts,String stay,String dys,String agmtSeq,String vndrSeq) throws EventException {
			List<AvailableOnewayInventoryVO> resultVOs = null; // 데이터 전송을 위해 VO 객체

			try {
				resultVOs = dbDao.searchAvailableOnewayListBasic(locFmTp,locFm,dpsl,orgCntrTpszCd,trd,locTp,locTo,sts,stay,dys,agmtSeq,vndrSeq);
			} catch (DAOException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("LSE10005", new String[]{"Available Oneway Inventory Summary Search"}).getMessage(),ex);
			} catch (Exception ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("LSE10005", new String[]{"Available Oneway Inventory Summary Search"}).getMessage(),ex);
			}
			
			return resultVOs;
		}		
	
		/**
		 * Oneway Loading PFMC 조회<br>
		 * 
	     * @param String period
	     * @param String froms
	     * @param String dpsl
	     * @param String orgCntrTpszCd
	     * @param String trd
	     * @param String locTp
	     * @param String locTo
	     * @param String tos
	     * @param String delDol
	     * @param String porDol
	     * @param String ifFlg
	     * @param String mvmt
		 * @return List<AvailableOnewayInventoryVO>
		 * @exception EventException
		 */
		public List<AvailableOnewayInventoryVO> searchOnewayLoadingPFMCSummaryBasic(String period,String froms,String dpsl,String orgCntrTpszCd,String trd,String locTp,String locTo,String tos,String delDol,String porDol,String ifFlg,String mvmt) throws EventException {
			List<AvailableOnewayInventoryVO> resultVOs = null; // 데이터 전송을 위해 VO 객체

			try {
				resultVOs = dbDao.searchOnewayLoadingPFMCSSummaryData(period,froms,dpsl,orgCntrTpszCd,trd,locTp,locTo,tos,delDol,porDol,ifFlg,mvmt);
			} catch (DAOException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("LSE10005", new String[]{"Oneway Loading PFMC Summary Search"}).getMessage(),ex);
			} catch (Exception ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("LSE10005", new String[]{"Oneway Loading PFMC Summary Search"}).getMessage(),ex);
			}
			
			return resultVOs;
		}
		
		/**
		 * Oneway Loading PFMC 조회<br>
		 * 
	     * @param String period
	     * @param String froms
	     * @param String dpsl
	     * @param String orgCntrTpszCd
	     * @param String trd
	     * @param String locTp
	     * @param String locTo
	     * @param String tos
	     * @param String delDol
	     * @param String porDol
	     * @param String ifFlg
	     * @param String mvmt
		 * @return List<AvailableOnewayInventoryVO>
		 * @exception EventException
		 */
		public List<AvailableOnewayInventoryVO> searchOnewayLoadingPFMCListBasic(String period,String froms,String dpsl,String orgCntrTpszCd,String trd,String locTp,String locTo,String tos,String delDol,String porDol,String ifFlg,String mvmt) throws EventException {
			List<AvailableOnewayInventoryVO> resultVOs = null; // 데이터 전송을 위해 VO 객체

			try {
				resultVOs = dbDao.searchOnewayLoadingPFMCSListData(period,froms,dpsl,orgCntrTpszCd,trd,locTp,locTo,tos,delDol,porDol,ifFlg,mvmt);
			} catch (DAOException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("LSE10005", new String[]{"Oneway Loading PFMC Summary Search"}).getMessage(),ex);
			} catch (Exception ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("LSE10005", new String[]{"Oneway Loading PFMC Summary Search"}).getMessage(),ex);
			}
			
			return resultVOs;
		}
		
		/** EES_LSE_0113 : save <br>
		 * 등록, 수정, 삭제 데이타 처리<br> 
		 * @author DOO KI MIN
		 * @category EES_LSE_0113
		 * @category manageOnewayLoadingPFMCBasic    
		 * @param AvailableOnewayInventoryVO[] availableOnewayInventoryVOs
		 * @param SignOnUserAccount account
		 * @exception EventException
		 */	
		public void manageOnewayLoadingPFMCBasic(AvailableOnewayInventoryVO[] availableOnewayInventoryVOs,SignOnUserAccount account) throws EventException {
			try {
				
				//List<AvailableOnewayInventoryVO> updateVoList = new ArrayList<AvailableOnewayInventoryVO>();
				for ( int i=0; i<availableOnewayInventoryVOs.length; i++ ) {
					
					availableOnewayInventoryVOs[i].setCntrMvDt(JSPUtil.replace(availableOnewayInventoryVOs[i].getCntrMvDt(),"-",""));
					availableOnewayInventoryVOs[i].setUpdUsrId(account.getUsr_id());
					dbDao.modifyLseOnewayLoadPFMCData(availableOnewayInventoryVOs[i]);
					dbDao.modifyMasOffhBkgListData(availableOnewayInventoryVOs[i]);
				}
							
			} catch (DAOException ex) {
				throw new EventException(new ErrorHandler("LSE10005", new String[]{"Oneway Loading PFMC Creation"}).getMessage(),ex);
			} catch (Exception ex) {
				throw new EventException(new ErrorHandler("LSE10005", new String[]{"Oneway Loading PFMC Creation"}).getMessage(),ex);
			}
		}
}
