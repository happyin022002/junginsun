/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MisUseApprovalBCImpl.java
*@FileTitle : Mis Use In & Out Request
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.07.14 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.misuseapproval.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.lse.containerleasemgt.misuseapproval.integration.MisUseApprovalDBDAO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.misuseapproval.vo.MisUseApprovalVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.misuseapproval.vo.MisUseContainerInfoVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.misuseapproval.vo.MisUseInOutInquiryVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.misuseapproval.vo.MisUseReqContainerVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.misuseapproval.vo.MisUseRequestVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.misuseapproval.vo.SearchParamVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-ContainerLeaseMgt Business Logic Basic Command implementation<br>
 * - ALPS-ContainerLeaseMgt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Jang Jun-Woo
 * @see EES_LSE_0027EventResponse,MisUseApprovalBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class MisUseApprovalBCImpl extends BasicCommandSupport implements MisUseApprovalBC {

	// Database Access Object
	private transient MisUseApprovalDBDAO dbDao = null;

	/**
	 * MisUseApprovalBCImpl 객체 생성<br>
	 * MisUseApprovalDBDAO를 생성한다.<br>
	 */
	public MisUseApprovalBCImpl() {
		dbDao = new MisUseApprovalDBDAO();
	}

	/**
	 * Miss Use 최대 Request No.를 조회합니다.<br>
	 *
	 * @param  String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchNewMisUseRequestNumberBasic(String ofcCd) throws EventException {
		String rqstNo = null;

		try {
			rqstNo = dbDao.searchNewMisUseRequestNumberData(ofcCd);
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"NewMissUseRequestNumber Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"NewMissUseRequestNumber Search"}).getMessage(),ex);
		}

		return rqstNo;
	}

	/**
	 * 입력된 컨테이너 번호에 대한 요청내역 중복여부를 확인합니다.<br>
	 *
	 * @param  String cntrNo
	 * @return boolean
	 * @exception EventException
	 */
	public boolean searchMisUseReqContainerExistBasic(String cntrNo) throws EventException {
		boolean existFlag = false;
		List<MisUseReqContainerVO> resultVOs = null; // 데이터 전송을 위해 VO 객체

		try {
			resultVOs = dbDao.searchMisUseReqContainerExistData(cntrNo);
			existFlag = resultVOs.size() > 0 ? true : false;
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"MissUseRequestContainerExist Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"MissUseRequestContainerExist Search"}).getMessage(),ex);
		}

		return existFlag;
	}

	/**
	 * 입력된 컨테이너 번호에 대한 기본정보를 조회합니다.<br>
	 *
	 * @param  String cntrNo
	 * @return List<MisUseContainerInfoVO>
	 * @exception EventException
	 */
	public List<MisUseContainerInfoVO> searchMisUseRequestContainerBasic(String cntrNo) throws EventException {
		List<MisUseContainerInfoVO> resultVOs = null; // 데이터 전송을 위해 VO 객체

		try {
			resultVOs = dbDao.searchMisUseRequestContainerData(cntrNo);
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"MissUseRequestContainerInfo Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"MissUseRequestContainerInfo Search"}).getMessage(),ex);
		}

		return resultVOs;
	}

	/**
	 * Miss Use Request 요청내역 및 장비목록을 저장합니다.<br>
	 *
	 * @param MisUseRequestVO misUseRequestVO
	 * @param MisUseReqContainerVO[] misUseReqContainerVOs
	 * @param SignOnUserAccount userAccount
	 * @throws EventException
	 */
	public void createMisUseRequestNumberListBasic(MisUseRequestVO misUseRequestVO, MisUseReqContainerVO[] misUseReqContainerVOs, SignOnUserAccount userAccount) throws EventException {
		try {
			//Miss Use 최대 Request No.를 조회합니다.
			String rqstNo = dbDao.searchNewMisUseRequestNumberData(misUseRequestVO.getRqstOfcCd());
			if(rqstNo.equals(misUseRequestVO.getRqstNo()) == false) {//Request No 가 중복되는 경우
				throw new EventException(new ErrorHandler("LSE01076",new String[]{"User Information"}).getMessage());
			}

			//Miss Use Request 요청내역 정보를 생성합니다.
			misUseRequestVO.setCreUsrId(userAccount.getUsr_id());
			dbDao.addMisUseRequestInfoData(misUseRequestVO);

			//Miss Use Request 요청장비 목록을 일괄 생성합니다.
			List<MisUseReqContainerVO> insertVoList = new ArrayList<MisUseReqContainerVO>();
			for(int i = 0; i < misUseReqContainerVOs.length; i++ ) {
				if(misUseReqContainerVOs[i].getIbflag().equals("I")) {
					misUseReqContainerVOs[i].setCreUsrId(userAccount.getUsr_id());
					insertVoList.add(misUseReqContainerVOs[i]);
				}
			}
			if(insertVoList.size() > 0) {
				dbDao.addMisUseReqContainerInfoListData(insertVoList);
			}
		} catch(EventException ee) {
			log.error("err " + ee.getMessage(), ee);
			throw ee;
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"MissUseRequestNumberList Create"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"MissUseRequestNumberList Create"}).getMessage(),ex);
		}
	}

	/**
	 * Miss Use 최대 Approval No.를 조회합니다.<br>
	 *
	 * @param  String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchNewMisUseApprovalNumberBasic(String ofcCd) throws EventException {
		String aproNo = null;

		try {
			aproNo = dbDao.searchNewMisUseApprovalNumberData(ofcCd);
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"NewMissUseApprovalNumber Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"NewMissUseApprovalNumber Search"}).getMessage(),ex);
		}

		return aproNo;
	}

	/**
	 * 승인대상 Miss Use Request No. 목록을 조회합니다.<br>
	 *
	 * @return List<MisUseRequestVO>
	 * @exception EventException
	 */
	public List<MisUseRequestVO> searchMisUseRequestNoItemsBasic() throws EventException {
		List<MisUseRequestVO> resultVOs = null; // 데이터 전송을 위해 VO 객체

		try {
			resultVOs = dbDao.searchMisUseRequestNoItemsData();
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"MissUseRequestNumberItems Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"MissUseRequestNumberItems Search"}).getMessage(),ex);
		}

		return resultVOs;
	}

	/**
	 * 선택 Request No.에 대한 요청정보을 조회합니다.<br>
	 *
	 * @param  String rqstNo
	 * @return List<MisUseRequestVO>
	 * @exception EventException
	 */
	public List<MisUseRequestVO> searchMisUseRequestInfoBasic(String rqstNo) throws EventException {
		List<MisUseRequestVO> resultVOs = null; // 데이터 전송을 위해 VO 객체

		try {
			resultVOs = dbDao.searchMisUseRequestInfoData(rqstNo);
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"MissUseRequestInfo Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"MissUseRequestInfo Search"}).getMessage(),ex);
		}

		return resultVOs;
	}

	/**
	 * 선택 Request No.에 대한 장비내역 목록을 조회합니다.<br>
	 *
	 * @param  String rqstNo
	 * @return List<MisUseReqContainerVO>
	 * @exception EventException
	 */
	public List<MisUseReqContainerVO> searchMisUseReqContainerListBasic(String rqstNo) throws EventException {
		List<MisUseReqContainerVO> resultVOs = null; // 데이터 전송을 위해 VO 객체

		try {
			resultVOs = dbDao.searchMisUseReqContainerListData(rqstNo);
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"MissUseRequestContainerList Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"MissUseRequestContainerList Search"}).getMessage(),ex);
		}

		return resultVOs;
	}

	/**
	 * Miss Use Approval 승인내역 및 장비목록을 저장합니다.<br>
	 *
	 * @param MisUseRequestVO misUseRequestVO
	 * @param MisUseApprovalVO misUseApprovalVO
	 * @param MisUseReqContainerVO[] misUseReqContainerVOs
	 * @param SignOnUserAccount userAccount
	 * @throws EventException
	 */
	public void createMisUseApprovalNumberListBasic(MisUseRequestVO misUseRequestVO,MisUseApprovalVO misUseApprovalVO,MisUseReqContainerVO[] misUseReqContainerVOs, SignOnUserAccount userAccount) throws EventException {
		try {
			//Miss Use 최대 Approval No.를 조회합니다.
			String aproNo = dbDao.searchNewMisUseApprovalNumberData(misUseApprovalVO.getAproOfcCd());
			if(aproNo.equals(misUseRequestVO.getAproNo()) == false) {//Approval No 가 중복되는 경우
				throw new EventException(new ErrorHandler("LSE01128",new String[]{"User Information"}).getMessage());
			}

			//Miss Use Approval 승인내역 정보를 생성합니다.
			misUseApprovalVO.setCreUsrId(userAccount.getUsr_id());
			dbDao.addMisUseApprovalInfoData(misUseApprovalVO);

			//Miss Use Request 요청내역 정보를 갱신합니다.
			misUseRequestVO.setUpdUsrId(userAccount.getUsr_id());
			dbDao.modifyMisUseRequestInfoData(misUseRequestVO);

			//Miss Use Request 승인장비 목록을 일괄 갱신합니다.
			List<MisUseReqContainerVO> updateVoList = new ArrayList<MisUseReqContainerVO>();
			for(int i = 0; i < misUseReqContainerVOs.length; i++ ) {
				if(misUseReqContainerVOs[i].getIbflag().equals("U")) {
					misUseReqContainerVOs[i].setUpdUsrId(userAccount.getUsr_id());
					updateVoList.add(misUseReqContainerVOs[i]);
				}
			}
			if(updateVoList.size() > 0) {
				dbDao.modifyMisUseReqContainerInfoListData(updateVoList);
			}
		} catch(EventException ee) {
			log.error("err " + ee.getMessage(), ee);
			throw ee;
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"MissUseApprovalNumberList Create"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"MissUseApprovalNumberList Create"}).getMessage(),ex);
		}
	}

	/**
	 * 자사 및 타사장비의 Miss Use된 장비의 현황을 조회합니다.<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<MisUseInOutInquiryVO>
	 * @exception EventException
	 */
	public List<MisUseInOutInquiryVO> searchMisUseInOutInquiryListBasic(SearchParamVO searchParamVO) throws EventException {
		List<MisUseInOutInquiryVO> resultVOs = null; // 데이터 전송을 위해 VO 객체

		try {
			resultVOs = dbDao.searchMisUseInOutInquiryListData(searchParamVO);
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"MissUseInOutInquiryList Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"MissUseInOutInquiryList Search"}).getMessage(),ex);
		}

		return resultVOs;
	}

	/**
	 * Miss Use Approval 승인장비 목록을 일괄 취소합니다.<br>
	 *
	 * @param MisUseInOutInquiryVO[] misUseInOutInquiryVOs
	 * @param SignOnUserAccount userAccount
	 * @throws EventException
	 */
	public void modifyMisUseApprovalCancelListBasic(MisUseInOutInquiryVO[] misUseInOutInquiryVOs, SignOnUserAccount userAccount) throws EventException {
		try {
			List<MisUseInOutInquiryVO> updateVoList = new ArrayList<MisUseInOutInquiryVO>();

			for(int i = 0; i < misUseInOutInquiryVOs.length; i++ ) {
				if(misUseInOutInquiryVOs[i].getIbflag().equals("U")) {
					misUseInOutInquiryVOs[i].setUpdUsrId(userAccount.getUsr_id());
					updateVoList.add(misUseInOutInquiryVOs[i]);
				}
			}
			if(updateVoList.size() > 0) {
				dbDao.modifyMisUseApprovalCancelListData(updateVoList);
			}
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"MisUseApprovalCancelList Modify"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"MisUseApprovalCancelList Modify"}).getMessage(),ex);
		}
	}
}