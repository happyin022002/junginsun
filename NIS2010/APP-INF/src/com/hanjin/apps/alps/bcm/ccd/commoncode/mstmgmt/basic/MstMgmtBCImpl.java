/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MstMgmtBCImpl.java
*@FileTitle : BCM_CCD_2001
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.03
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.03 황효근
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.basic;
 
import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.integration.MstMgmtDBDAO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.vo.MdmDatProcVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.vo.MdmUsrAuthVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.vo.SearchMdmHistListVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.vo.SearchMdmHistoryListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-CommonCode Business Logic Command Interface<br>
 * - OPUS-CommonCode에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author 
 * @see 
 * @since J2EE 1.4 
 */
public class MstMgmtBCImpl extends BasicCommandSupport implements MstMgmtBC {

	// Database Access Object
	private transient MstMgmtDBDAO dbDao = null;
 
	/**
	 * MstMgmtBCImpl 객체 생성<br>
	 * MstMgmtDBDAO를 생성한다.<br>
	 */
	public MstMgmtBCImpl() {
		dbDao = new MstMgmtDBDAO();
	}
	
	/**
	 * Master User Authoriry 정보를 조회한다.
	 * 
	 * @param MdmUsrAuthVO mdmUsrAuthVO
	 * @return List<MdmUsrAuthVO>
	 * @exception EventException
	 */
	public List<MdmUsrAuthVO> searchMdmUsrAuthList(MdmUsrAuthVO mdmUsrAuthVO) throws EventException {
		try {
			return dbDao.searchMdmUsrAuthList(mdmUsrAuthVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	
	/**
	 * Master User Authoriry 정보를 추가, 수정, 삭제 처리한다.
	 * 
	 * @param mdmUsrAuthVOs
	 * @param account
	 * @throws EventException
	 */
	public void manageMdmUsrAuth(MdmUsrAuthVO[] mdmUsrAuthVOs, SignOnUserAccount account) throws EventException {
		// TODO Auto-generated method stub
			try {			
			List<MdmUsrAuthVO> insertVoList = new ArrayList<MdmUsrAuthVO>();
			List<MdmUsrAuthVO> updateVoList = new ArrayList<MdmUsrAuthVO>();	
			List<MdmUsrAuthVO> deleteVoList = new ArrayList<MdmUsrAuthVO>();
			MdmUsrAuthVO mdmUsrAuthVO = null;
				
			if(mdmUsrAuthVOs != null) {
				for ( int i=0; i < mdmUsrAuthVOs.length; i++ ) {
					mdmUsrAuthVO = mdmUsrAuthVOs[i];
					
					if (mdmUsrAuthVO.getIbflag().equals("I")) {
						mdmUsrAuthVO.setCreUsrId(account.getUsr_id());
						mdmUsrAuthVO.setUpdUsrId(account.getUsr_id());
						mdmUsrAuthVO.setCreOfcCd(account.getOfc_cd());
						insertVoList.add(mdmUsrAuthVO);	
											
					} else if ( mdmUsrAuthVO.getIbflag().equals("U")) {
						mdmUsrAuthVO.setUpdUsrId(account.getUsr_id());
						mdmUsrAuthVO.setCreOfcCd(account.getOfc_cd());
						updateVoList.add(mdmUsrAuthVO);		
						
					} else if ( mdmUsrAuthVO.getIbflag().equals("D")) {
						deleteVoList.add(mdmUsrAuthVO);					
						//removeOfcAccGrpMap VO
						deleteVoList.add(mdmUsrAuthVO);
					}
				}	
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeMdmUsrAuth(deleteVoList);
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addMdmUsrAuth(insertVoList);
			}

			if ( updateVoList.size() > 0 ) {
				dbDao.modifyMdmUsrAuth(updateVoList);
			}
			
		}catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	
	/**
	 * Master Data Process 요청 정보를 조회한다.
	 * 
	 * @param MdmDatProcVO mdmDatProcVO
	 * @return List<MdmDatProcVO>
	 * @exception EventException
	 */
	public List<MdmDatProcVO> searchMdmDatProcRequestList(MdmDatProcVO mdmDatProcVO) throws EventException {
		try {
			return dbDao.searchMdmDatProcRequestList(mdmDatProcVO);
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Mdm History 요청 정보를 조회한다.
	 * 
	 * @param SearchMdmHistoryListVO searchMdmHistoryListVO
	 * @return List<SearchMdmHistoryListVO>
	 * @exception EventException
	 */
	public List<SearchMdmHistoryListVO> searchMdmHistoryList(SearchMdmHistoryListVO searchMdmHistoryListVO) throws EventException {
		try {
			return dbDao.searchMdmHistoryList(searchMdmHistoryListVO);
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Master Data Process 결과 정보를 조회한다.
	 * 
	 * @param MdmDatProcVO mdmDatProcVO
	 * @return List<MdmDatProcVO>
	 * @exception EventException
	 */
	public List<MdmDatProcVO> searchMdmDatProcCompletionList(MdmDatProcVO mdmDatProcVO) throws EventException {
		try {
			return dbDao.searchMdmDatProcCompletionList(mdmDatProcVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	
	/**
	 * Master Data 의 Authority Type Code 정보를 조회한다.<br>
	 * 
	 * @param MdmDatProcVO mdmDatProcVO
	 * @return List<MdmDatProcVO>
	 * @exception EventException
	 */
	public String searchAuthTpCd(MdmDatProcVO mdmDatProcVO) throws EventException {
		try {
			return dbDao.searchAuthTpCd(mdmDatProcVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	
	/**
	 * Master Data Process 테이블의 새로운 Request No 정보를 조회한다.
	 * 
	 * @param String mstDatSubjCd
	 * @return String
	 * @exception EventException
	 */
	public String searchMdmDatProcRqstNo(String mstDatSubjCd) throws EventException {
		try {
			return dbDao.searchMdmDatProcRqstNo(mstDatSubjCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	
	/**
	 * MDM DATA PROCESS 정보를 추가한다.
	 * 
	 * @param mdmDatProcVO
	 * @throws EventException
	 */
	public void addMdmDatProc(MdmDatProcVO mdmDatProcVO) throws EventException {
		try {
			dbDao.addMdmDatProc(mdmDatProcVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	
	/**
	 * MDM DATA PROCESS 정보를 수정한다.
	 * 
	 * @param mdmDatProcVO
	 * @param mdmDatProcVOs
	 * @param account
	 * @throws EventException
	 */
	public void modifyMdmDatProc(MdmDatProcVO mdmDatProcVO, MdmDatProcVO[] mdmDatProcVOs, SignOnUserAccount account) throws EventException {
		try {
			List<MdmDatProcVO> mdmDatProcVOList = new ArrayList<MdmDatProcVO>();
			
			for(int i=0; i < mdmDatProcVOs.length; i++) {
				MdmDatProcVO vo = mdmDatProcVOs[i];
				
				vo.setProcTpCd(mdmDatProcVO.getProcTpCd());
				vo.setAproUsrId(account.getUsr_id());
				vo.setUpdUsrId(account.getUsr_id());
				mdmDatProcVOList.add(vo);
			}
			
			dbDao.modifyMdmDatProc(mdmDatProcVOList);
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	
	/**
	 * MDM DATA PROCESS 정보를 수정한다.
	 * 
	 * @param MdmDatProcVO mdmDatProcVO
	 * @throws EventException
	 */
	public void modifyMdmDatProc(MdmDatProcVO mdmDatProcVO) throws EventException {
		try {
			dbDao.modifyMdmDatProc(mdmDatProcVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	
	/**
	 * MDM USER AUTHORITY 정보를 추가, 수정, 삭제 처리한다.<br>
	 * 
	 * @param mdmDatProcVOs
	 * @param account
	 * @throws EventException
	 */
	public void removeMdmDatProc(MdmDatProcVO[] mdmDatProcVOs, SignOnUserAccount account) throws EventException {
		try {
			List<MdmDatProcVO> mdmDatProcVOList = new ArrayList<MdmDatProcVO>();
			
			for(int i=0; i < mdmDatProcVOs.length; i++) {
				MdmDatProcVO vo = mdmDatProcVOs[i];
				vo.setUpdUsrId(account.getUsr_id());
				mdmDatProcVOList.add(vo);
			}
			
			dbDao.removeMdmDatProc(mdmDatProcVOList);
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	
	/**
	 * CNT_CD별 CUST_MAX_SEQ 정보를 조회한다.
	 * 
	 * @param String cntCd
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String searchCustMaxSeq(String cntCd, SignOnUserAccount account) throws EventException {
		String result = "";
		
		try {
			String custMaxSeq = dbDao.searchCustMaxSeq(cntCd);
			
			if(custMaxSeq.equals("000001")) {
				dbDao.addCustMaxSeq(cntCd, account);
				return custMaxSeq;
			}
 			
			dbDao.modifyCustMaxSeq(cntCd, account);
			result = custMaxSeq;
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return result;
	}
	
	
	/**
	 * Office Kind Code retrieve.
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchOfcKndCd(String ofcCd) throws EventException {	
		try {
			//return dbDao.searchOfcKndCd(usrId);
			return dbDao.searchOfcKndCd(ofcCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * MDM DATA Process info retrieve. 
	 * 
	 * @param String rqstNo
	 * @return MdmDatProcVO
	 * @exception EventException
	 */
	public MdmDatProcVO searchMdmDatProc(String rqstNo) throws EventException {
		try {
			return dbDao.searchMdmDatProc(rqstNo);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	/**
	 * Mdm History 요청 정보를 조회한다.
	 * 
	 * @param SearchMdmHistoryListVO searchMdmHistoryListVO
	 * @return String
	 * @exception EventException
	 */
	public String searchMdmHistoryCount(SearchMdmHistoryListVO searchMdmHistoryListVO) throws EventException {
		try {
			return dbDao.searchMdmHistoryCount(searchMdmHistoryListVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Mdm History 요청 정보를 조회한다.
	 * 
	 * @param SearchMdmHistListVO searchMdmHistListVO
	 * @return List<SearchMdmHistoryListVO>
	 * @exception EventException
	 */
	public List<SearchMdmHistListVO> searchMdmHistList(SearchMdmHistListVO searchMdmHistListVO) throws EventException {
		try {
			return dbDao.searchMdmHistList(searchMdmHistListVO);
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
}