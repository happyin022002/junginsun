/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AvailableOffHireBCImpl.java
*@FileTitle : Available Off Hire Q'ty
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.09.22 장준우
* 1.0 Creation
* =======================================================
* 2010.10.05 남궁진호 [CHM-201006272-01] Session User Id 변경, CreUsrId -> UsrId
*                    backEndAvailableOffHireContainerSummaryBasic
*                    backEndAvailableOffHireContainerDetailBasic
*                    backEndAvailableOffHireContainerConfirmBasic   
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.integration.AvailableOffHireDBDAO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.integration.AvailableOffHireEAIDAO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.vo.AvailableOffHireConfirmVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.vo.AvailableOffHireContainerListVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.vo.AvailableOffHireDetailVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.vo.AvailableOffHireSummaryVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.vo.AvailableOffHireYardCodeVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.vo.EmailSendInfoVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.vo.SearchParamVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.backend.support.BackEndJobException;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.javamail.MailerAppException;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-Containerleasemgt Business Logic Command Interface<br>
 * - ALPS-Containerleasemgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jang Jun-Woo
 * @see Ees_lse_0020EventResponse 참조
 * @since J2EE 1.6
 */
public class AvailableOffHireBCImpl extends BasicCommandSupport implements AvailableOffHireBC {

	// Database Access Object
	private transient AvailableOffHireDBDAO dbDao = null;
	// EAI Access Object
	private transient AvailableOffHireEAIDAO eaiDao = null;

	/**
	 * AvailableOffHireBCImpl 객체 생성<br>
	 * AvailableOffHireDBDAO를 생성한다.<br>
	 */
	public AvailableOffHireBCImpl() {
		dbDao = new AvailableOffHireDBDAO();
		eaiDao = new AvailableOffHireEAIDAO();
	}

	/**
	 * 지역별 반납가능 대상 장비의 현황을 조회합니다.<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<AvailableOffHireSummaryVO>
	 * @throws EventException
	 */
	public List<AvailableOffHireSummaryVO> searchAvailableOffHireContainerSummaryBasic(SearchParamVO searchParamVO) throws EventException {
		List<AvailableOffHireSummaryVO> resultVOs = null; // 데이터 전송을 위해 VO 객체

		try {
			resultVOs = dbDao.searchAvailableOffHireContainerSummaryData(searchParamVO);
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"AvailableOffHireContainerSummary Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"AvailableOffHireContainerSummary Search"}).getMessage(),ex);
		}

		return resultVOs;
	}

	/**
	 * 지역별 반납가능 대상 장비의 현황을 요청합니다.<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @param  SignOnUserAccount userAccount
	 * @return String
	 * @throws EventException
	 */
	public String backEndAvailableOffHireContainerSummaryBasic(SearchParamVO searchParamVO, SignOnUserAccount userAccount) throws EventException {
		AvailableOffHireBackEndJob backEndJob = new AvailableOffHireBackEndJob();
		backEndJob.setJobType("AvailableOffHireContainerSummary");
		backEndJob.setSearchParamVO(searchParamVO);
		BackEndJobManager backEndJobManager = new BackEndJobManager();

		try {
			return backEndJobManager.execute(backEndJob, userAccount.getUsr_id(), "AvailableOffHireContainerSummary BackEndJob");
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"AvailableOffHireContainerSummary BackEndJob"}).getMessage(),ex);
		}
	}

	/**
	 * 선택된 반납가능 대상 장비의 내역을 조회합니다.<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<AvailableOffHireDetailVO>
	 * @throws EventException
	 */
	public List<AvailableOffHireDetailVO> searchAvailableOffHireContainerDetailBasic(SearchParamVO searchParamVO) throws EventException {
		List<AvailableOffHireDetailVO> resultVOs = null; // 데이터 전송을 위해 VO 객체

		try {
			resultVOs = dbDao.searchAvailableOffHireContainerDetailData(searchParamVO);
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"AvailableOffHireContainerDetail Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"AvailableOffHireContainerDetail Search"}).getMessage(),ex);
		}

		return resultVOs;
	}

	/**
	 * 선택된 반납가능 대상 장비의 내역을 요청합니다.<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @param  SignOnUserAccount userAccount
	 * @return String
	 * @throws EventException
	 */
	public String backEndAvailableOffHireContainerDetailBasic(SearchParamVO searchParamVO, SignOnUserAccount userAccount) throws EventException {
		AvailableOffHireBackEndJob backEndJob = new AvailableOffHireBackEndJob();
		backEndJob.setJobType("AvailableOffHireContainerDetail");
		backEndJob.setSearchParamVO(searchParamVO);
		BackEndJobManager backEndJobManager = new BackEndJobManager();

		try {
			return backEndJobManager.execute(backEndJob, userAccount.getUsr_id(), "AvailableOffHireContainerDetail BackEndJob");
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"AvailableOffHireContainerDetail BackEndJob"}).getMessage(),ex);
		}
	}

	/**
	 * 선택된 반납가능 대상 장비에 대한 내역을 메일로 발송합니다.<br>
	 *
	 * @param EmailSendInfoVO emailSendInfoVO
	 * @param AvailableOffHireDetailVO[] availableOffHireDetailVOs
	 * @param SignOnUserAccount userAccount
	 * @exception EventException
	 */
    public void sendToEmailAvailableOffHireContainerBasic(EmailSendInfoVO emailSendInfoVO, AvailableOffHireDetailVO[] availableOffHireDetailVOs, SignOnUserAccount userAccount) throws EventException {
		try {
			//1.대상 장비에 대한 내역을 메일로 발송합니다.
			String resultMsg = eaiDao.sendToEmailAvailableOffHireContainerData(emailSendInfoVO);

			if(resultMsg == null || resultMsg.equals("")) {
				throw new EventException(new ErrorHandler("LSE10005", new String[]{"EmailAvailableOffHireContainer SendTo"}).getMessage());
			}

			for(int i = 0; i < availableOffHireDetailVOs.length; i++) {
				availableOffHireDetailVOs[i].setCreUsrId(userAccount.getUsr_id());

				if(availableOffHireDetailVOs[i].getIbflag().equals("U")) {
					//2.반납가능 대상 장비의 내역을 생성합니다.
					dbDao.addAvailableOffHireContainerDetailData(availableOffHireDetailVOs[i]);
				}
			}
		} catch(EventException ee) {
			log.error("err " + ee.getMessage(), ee);
			throw ee;
		} catch (MailerAppException me) {
			log.error("err " + me.toString(), me);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"EmailAvailableOffHireContainer SendTo"}).getMessage(),me);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"EmailAvailableOffHireContainer SendTo"}).getMessage(),ex);
		}
	}

    /**
	 * 지역별 지정된 반납대상 장비의 현황을 조회합니다.<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<AvailableOffHireConfirmVO>
	 * @throws EventException
	 */
	public List<AvailableOffHireConfirmVO> searchAvailableOffHireContainerConfirmBasic(SearchParamVO searchParamVO) throws EventException {
		List<AvailableOffHireConfirmVO> resultVOs = null; // 데이터 전송을 위해 VO 객체

		try {
			resultVOs = dbDao.searchAvailableOffHireContainerConfirmData(searchParamVO);
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"AvailableOffHireContainerConfirm Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"AvailableOffHireContainerConfirm Search"}).getMessage(),ex);
		}

		return resultVOs;
	}

	/**
	 * 지역별 지정된 반납대상 장비의 현황을 요청합니다.<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @param  SignOnUserAccount userAccount
	 * @return String
	 * @throws EventException
	 */
	public String backEndAvailableOffHireContainerConfirmBasic(SearchParamVO searchParamVO, SignOnUserAccount userAccount) throws EventException {
		AvailableOffHireBackEndJob backEndJob = new AvailableOffHireBackEndJob();
		backEndJob.setJobType("AvailableOffHireContainerConfirm");
		backEndJob.setSearchParamVO(searchParamVO);
		BackEndJobManager backEndJobManager = new BackEndJobManager();

		try {
			return backEndJobManager.execute(backEndJob, userAccount.getUsr_id(), "AvailableOffHireContainerConfirm BackEndJob");
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"AvailableOffHireContainerConfirm BackEndJob"}).getMessage(),ex);
		}
	}

	/**
	 * 선정된 대상장비의 내역을 반납확정 자료로 일괄갱신합니다.<br>
	 *
	 * @param AvailableOffHireConfirmVO[] availableOffHireConfirmVOs
	 * @param SignOnUserAccount userAccount
	 * @exception EventException
	 */
	public void modifyAvailableOffHireContainerConfirmBasic(AvailableOffHireConfirmVO[] availableOffHireConfirmVOs, SignOnUserAccount userAccount) throws EventException {
		try {
			List<AvailableOffHireConfirmVO> updateVoList = new ArrayList<AvailableOffHireConfirmVO>();
			List<AvailableOffHireConfirmVO> deleteVoList = new ArrayList<AvailableOffHireConfirmVO>();

			for(int i = 0; i < availableOffHireConfirmVOs.length; i++ ) {
				if(availableOffHireConfirmVOs[i].getIbflag().equals("U")) {
					availableOffHireConfirmVOs[i].setUpdUsrId(userAccount.getUsr_id());

					if(availableOffHireConfirmVOs[i].getOffhStsCd().equals("D")) {//Cancel
						deleteVoList.add(availableOffHireConfirmVOs[i]);
					} else {//Request & Confirm
						updateVoList.add(availableOffHireConfirmVOs[i]);
					}
				}
			}

			if(updateVoList.size() > 0) {
				dbDao.modifyAvailableOffHireContainerConfirmData(updateVoList);
			}
			if(deleteVoList.size() > 0) {
				dbDao.removeAvailableOffHireContainerConfirmData(deleteVoList);
			}
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"AvailableOffHireContainerConfirm Modify"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"AvailableOffHireContainerConfirm Modify"}).getMessage(),ex);
		}
	}

	/**
	 * 선정된 대상장비의 반납상태 정보를 갱신합니다.<br>
	 *
	 * @param AvailableOffHireConfirmVO[] availableOffHireConfirmVOs
	 * @param SignOnUserAccount userAccount
	 * @exception EventException
	 */
	public void modifyAvailableOffHireContainerStatusBasic(AvailableOffHireConfirmVO[] availableOffHireConfirmVOs, SignOnUserAccount userAccount) throws EventException {
		int trxCnt = 0;

		try {
			for(int i = 0; i < availableOffHireConfirmVOs.length; i++) {
				availableOffHireConfirmVOs[i].setUpdUsrId(userAccount.getUsr_id());
				String offhStsCd = availableOffHireConfirmVOs[i].getOffhStsCd();

				if(offhStsCd.equals("L")) {//Off-Hire Status is 'LSO'
					trxCnt += dbDao.modifyAvailableOffHireContainerStatusData(availableOffHireConfirmVOs[i]);
				} else {//Off-Hire Status is 'Cancel'
					trxCnt += dbDao.removeAvailableOffHireContainerStatusData(availableOffHireConfirmVOs[i]);
				}
			}

			if(trxCnt < availableOffHireConfirmVOs.length) {
				throw new EventException(new ErrorHandler("LSE10005",new String[]{"AvailableOffHireContainerStatus Modify"}).getMessage());
			}
		} catch(EventException ee) {
			log.error("err " + ee.getMessage(), ee);
			throw ee;
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"AvailableOffHireContainerStatus Modify"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"AvailableOffHireContainerStatus Modify"}).getMessage(),ex);
		}
	}

	/**
	 * AvailableOffHire Yard 코드 목록을 조회합니다.<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<AvailableOffHireYardCodeVO>
	 * @throws EventException
	 */
	public List<AvailableOffHireYardCodeVO> searchAvailableOffHireYardCodeListBasic(SearchParamVO searchParamVO) throws EventException {
		List<AvailableOffHireYardCodeVO> resultVOs = null; // 데이터 전송을 위해 VO 객체

		try {
			resultVOs = dbDao.searchAvailableOffHireYardCodeListData(searchParamVO);
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"AvailableOffHireYardCodeList Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"AvailableOffHireYardCodeList Search"}).getMessage(),ex);
		}

		return resultVOs;
	}

	/**
	 * AvailableOffHire Container 목록을 조회합니다.<br>
	 *
	 * @param  AvailableOffHireContainerListVO availableOffHireContainerListVO
	 * @return List<AvailableOffHireContainerListVO.java>
	 * @throws EventException
	 */
	public List<AvailableOffHireContainerListVO> searchAvailableOffHireContainerListBasic(AvailableOffHireContainerListVO availableOffHireContainerListVO) throws EventException {
		List<AvailableOffHireContainerListVO> resultVOs = null; // 데이터 전송을 위해 VO 객체

		try {
			if(availableOffHireContainerListVO.getRadTp().equals("A")){
				resultVOs = dbDao.searchAvailableOffHireOriginContainerListData(availableOffHireContainerListVO);
			}else{
				resultVOs = dbDao.searchAvailableOffHireContainerListData(availableOffHireContainerListVO);
			}
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"AvailableOffHireContainerList Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"AvailableOffHireContainerList Search"}).getMessage(),ex);
		}

		return resultVOs;
	}

	/**
	 * BackEndJob의 실행결과에 대한 상태값을 조회합니다.<br>
	 *
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String searchComBackEndJobStatusBasic(String key) throws EventException {
		DBRowSet rowSet;

		try {
			rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			rowSet.next();
			Thread.sleep(1000);
			return (String) rowSet.getObject("jb_sts_flg");
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
	 * 지역별 지정된 반납대상 장비의 현황을 요청합니다.<br>
	 *
	 * @param  AvailableOffHireContainerListVO availableOffHireContainerListVO
	 * @param  SignOnUserAccount userAccount
	 * @return String
	 * @throws EventException
	 */
	public String backEndSearchAvailableOffHireContainerListService(AvailableOffHireContainerListVO availableOffHireContainerListVO, SignOnUserAccount userAccount) throws EventException {
		AvailableOffHireBackEndJob backEndJob = new AvailableOffHireBackEndJob();
		backEndJob.setJobType("SearchAvailableOffHireContainerListService");
		backEndJob.setAvailableOffHireContainerListVO(availableOffHireContainerListVO);
		BackEndJobManager backEndJobManager = new BackEndJobManager();

		try {
			return backEndJobManager.execute(backEndJob, userAccount.getUsr_id(), "SearchAvailableOffHireContainerListService BackEndJob");
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"SearchAvailableOffHireContainerListService BackEndJob"}).getMessage(),ex);
		}
	}
}
