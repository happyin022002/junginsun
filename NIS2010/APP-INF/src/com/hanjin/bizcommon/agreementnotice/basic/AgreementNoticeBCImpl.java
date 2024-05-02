/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AgreementNoticeBCImpl.java
*@FileTitle : AgreementNoticeBCImpl.java
*Open Issues :
*Change history :
*@LastModifyDate : 2014-01-24
*@LastModifier : 
*@LastVersion : 1.0
* 2014-01-24
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.agreementnotice.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.bizcommon.agreementnotice.integration.AgreementNoticeDBDAO;
import com.hanjin.bizcommon.agreementnotice.util.AgreementNoticeUtil;
import com.hanjin.bizcommon.agreementnotice.vo.CodeNameVO;
import com.hanjin.bizcommon.agreementnotice.vo.ComCtrtUsrListVO;
import com.hanjin.bizcommon.agreementnotice.vo.SearchAgreementListVO;
import com.hanjin.bizcommon.agreementnotice.vo.SearchContractCreationUserVO;
import com.hanjin.bizcommon.agreementnotice.vo.SearchMailingListVO;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * ENIS-BIZCOMMON Business Logic Basic Command implementation<br>
 * - ENIS-BIZCOMMON에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author yj jeon
 * @see COM_NTC_0001EventResponse, 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class AgreementNoticeBCImpl extends BasicCommandSupport implements AgreementNoticeBC {

    // Database Access Object
    private transient AgreementNoticeDBDAO dbDao=null;

    /**
     * AgreementNoticeBCImpl 객체 생성<br>
     * AgreementNoticeDBDAO  객체 생성<br>
     */
    public AgreementNoticeBCImpl(){
        dbDao = new AgreementNoticeDBDAO();
    }

    /**
     * Pop-up Notice User 조회  <br>
	 * 
	 * @param String user_id
	 * @param String pgm_no
	 * @return String
	 * @exception EventException
	 */
	public String searchNoticeUser(String user_id, String pgm_no) throws EventException {
		try {
			return dbDao.searchNoticeUser(user_id, pgm_no);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
     * Notice Agreement List 조회<br>
	 * 
	 * @param String user_id
	 * @param String pgm_no
	 * @return List<SearchAgreementListVO>
	 * @exception EventException
	 */
	public List<SearchAgreementListVO> searchAgreementList(String user_id, String pgm_no) throws EventException {
		try {
			return dbDao.searchAgreementList(user_id, pgm_no);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
    /**
     * COM_NTC_0001 : System Name Combo
	 * 
	 * @return List<CodeNameVO>
	 * @exception EventException
	 */
	public List<CodeNameVO> searchSystemName() throws EventException {
		try {
			return dbDao.searchSystemName();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
    /**
     * COM_NTC_0001 : Office Level Combo
     * 
	 * @param CodeNameVO codeNameVO
	 * @return List<CodeNameVO>
	 * @exception EventException
	 */
	public List<CodeNameVO> searchOfficeLevel(CodeNameVO codeNameVO) throws EventException {
		try {
			return dbDao.searchOfficeLevel(codeNameVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
     * COM_NTC_0001 : Search User Name
	 * 
	 * @param CodeNameVO codeNameVO
	 * @return String
	 * @exception EventException 
	 */
	public String searchUserName(CodeNameVO codeNameVO) throws EventException {
		try {
			return dbDao.searchUserName(codeNameVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
     * COM_NTC_0001 : Search Office valid
	 * 
	 * @param String cd
	 * @param String nm
	 * @return String
	 * @exception EventException 
	 */
	public String searchOfficeValid(String cd, String nm) throws EventException {
		try {
			return dbDao.searchOfficeValid(cd, nm);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
     * COM_NTC_0001 : Retrieve
	 * 
	 * @param SearchMailingListVO searchMailingListVO
	 * @return DBRowSet
	 * @exception EventException 
	 */
	public DBRowSet searchMailingList(SearchMailingListVO searchMailingListVO) throws EventException {
		try {
			return dbDao.searchMailingList(searchMailingListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
     * COM_NTC_0001 : Save
	 * 
	 * @param SearchMailingListVO[] searchMailingListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException 
	 */
	public void manageMailingList(SearchMailingListVO[] searchMailingListVOs, SignOnUserAccount account) throws EventException {
		try {
			List<SearchMailingListVO> insertSheetVoList = new ArrayList<SearchMailingListVO>();
			List<SearchMailingListVO> updateSheetVoList = new ArrayList<SearchMailingListVO>();
			List<SearchMailingListVO> deleteSheetVoList = new ArrayList<SearchMailingListVO>();

			List<ComCtrtUsrListVO> comCtrtUsrList = new ArrayList<ComCtrtUsrListVO>();
			List<ComCtrtUsrListVO> delOverUsrMaxKntComCtrtUsrList = new ArrayList<ComCtrtUsrListVO>();
			int usrMaxKnt = 0; 
			String[] usrIdListArr = null;
			String[] usrJobCdListArr = null;
			ComCtrtUsrListVO comCtrtUsrListVO = null;
			ComCtrtUsrListVO delOverUsrMaxKntComCtrtUsrListVO = null;
			
			for (int i = 0; searchMailingListVOs != null && i < searchMailingListVOs.length; i++) {
				usrMaxKnt = searchMailingListVOs[i]!=null&&!searchMailingListVOs[i].equals("")?Integer.parseInt(JSPUtil.getNull(searchMailingListVOs[i].getUsrMaxKnt())):7;
				usrIdListArr = AgreementNoticeUtil.getStringToArray(searchMailingListVOs[i].getNtcUsrIdListCtnt(),"|");
				usrJobCdListArr = AgreementNoticeUtil.getStringToArray(searchMailingListVOs[i].getNtcUsrIdJbCdListCtnt(),"|");
				if (searchMailingListVOs[i].getIbflag().equals("I")) {
					searchMailingListVOs[i].setCreUsrId(account.getUsr_id());
					searchMailingListVOs[i].setUpdUsrId(account.getUsr_id());
					insertSheetVoList.add(searchMailingListVOs[i]);
				}else if (searchMailingListVOs[i].getIbflag().equals("U")) {
					searchMailingListVOs[i].setUpdUsrId(account.getUsr_id());
					updateSheetVoList.add(searchMailingListVOs[i]);
				}else if (searchMailingListVOs[i].getIbflag().equals("D")) {
					deleteSheetVoList.add(searchMailingListVOs[i]);
				}
				
				/** USR ID LIST를 위한 처리 **/
				if (searchMailingListVOs[i].getIbflag().equals("I") || searchMailingListVOs[i].getIbflag().equals("U")) {
					/** USR ID들과 USR JOB CD들을 list에 담는다 **/
					for (int j=0; j<usrMaxKnt; j++){
						if (i<searchMailingListVOs.length && i<usrMaxKnt){
							comCtrtUsrListVO = new ComCtrtUsrListVO();
							comCtrtUsrListVO.setSysCd(JSPUtil.getNull(searchMailingListVOs[i].getSysCd()));
							comCtrtUsrListVO.setCtrtOfcCd(JSPUtil.getNull(searchMailingListVOs[i].getCtrtOfcCd()));
							comCtrtUsrListVO.setAgmtNo(JSPUtil.getNull(searchMailingListVOs[i].getAgmtNo()));
							comCtrtUsrListVO.setNtcUsrSeq(JSPUtil.getNull(Integer.toString(j+1)));
							comCtrtUsrListVO.setNtcUsrId(usrIdListArr!=null?JSPUtil.getNull((j<usrIdListArr.length&&j<usrMaxKnt&&usrIdListArr.length<=usrMaxKnt?usrIdListArr[j]:"")):"");
							comCtrtUsrListVO.setNtcUsrIdJbCd(usrJobCdListArr!=null?JSPUtil.getNull((j<usrJobCdListArr.length&&j<usrMaxKnt&&usrJobCdListArr.length<=usrMaxKnt?usrJobCdListArr[j]:"")):"");
							comCtrtUsrListVO.setCreUsrId(JSPUtil.getNull(account.getUsr_id()));
							comCtrtUsrListVO.setUpdUsrId(JSPUtil.getNull(account.getUsr_id()));
							comCtrtUsrListVO.setUsrMaxKnt(Integer.toString(usrMaxKnt));
							comCtrtUsrList.add(comCtrtUsrListVO);
						}
					}
				}
				if (comCtrtUsrList!=null && comCtrtUsrList.size()>0){
					delOverUsrMaxKntComCtrtUsrListVO = new ComCtrtUsrListVO();
					delOverUsrMaxKntComCtrtUsrListVO.setSysCd(JSPUtil.getNull(searchMailingListVOs[i].getSysCd()));
					delOverUsrMaxKntComCtrtUsrListVO.setCtrtOfcCd(JSPUtil.getNull(searchMailingListVOs[i].getCtrtOfcCd()));
					delOverUsrMaxKntComCtrtUsrListVO.setAgmtNo(JSPUtil.getNull(searchMailingListVOs[i].getAgmtNo()));
					delOverUsrMaxKntComCtrtUsrListVO.setUsrMaxKnt(Integer.toString(usrMaxKnt));
					delOverUsrMaxKntComCtrtUsrListVO.setCreUsrId(JSPUtil.getNull(account.getUsr_id()));
					delOverUsrMaxKntComCtrtUsrListVO.setUpdUsrId(JSPUtil.getNull(account.getUsr_id()));					
					delOverUsrMaxKntComCtrtUsrList.add(delOverUsrMaxKntComCtrtUsrListVO);
				}
			}
			if (deleteSheetVoList.size() > 0) {
				// USR MGMT에 앞서 USR LIST를 먼저 삭제해야함
				dbDao.removeMailingComCtrtUsrList(deleteSheetVoList); //-> COM_CTRT_USR_LIST을 삭제 처리
				dbDao.removeMailingList(deleteSheetVoList); //-> COM_CTRT_USR_MGMT을 삭제 처리
			}
			if (updateSheetVoList.size() > 0) {
				dbDao.modifyMailingList(updateSheetVoList);
			}
			if (insertSheetVoList.size() > 0) {
				dbDao.addMailingList(insertSheetVoList);
			}
			if ((updateSheetVoList.size() > 0) || (insertSheetVoList.size() > 0)){
				if (comCtrtUsrList!=null && comCtrtUsrList.size()>0){
					dbDao.manageMailingComCtrtUsrList(comCtrtUsrList);
					if (delOverUsrMaxKntComCtrtUsrList!=null && delOverUsrMaxKntComCtrtUsrList.size()>0){
						dbDao.deleteOverUsrMaxKntComCtrtUsrList(delOverUsrMaxKntComCtrtUsrList);	
					}
				}
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
     * COM_NTC_0002 : Retrieve
	 * 
	 * @param SearchContractCreationUserVO searchContractCreationUserVO
	 * @return List<SearchContractCreationUserVO>
	 * @exception EventException 
	 */
	public List<SearchContractCreationUserVO> searchContractCreationUser(SearchContractCreationUserVO searchContractCreationUserVO) throws EventException {
		try {
			return dbDao.searchContractCreationUser(searchContractCreationUserVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

    /**
     * BIZCOMMON 업무 시나리오 마감작업<br>
     * Customer_02업무 시나리오 종료시 관련 내부객체 해제<br>
     */
    public void doEnd() {
        dbDao = null;
    }
}