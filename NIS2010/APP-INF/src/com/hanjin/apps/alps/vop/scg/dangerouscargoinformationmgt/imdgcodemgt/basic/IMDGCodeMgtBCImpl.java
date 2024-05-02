/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : IMDGCodeMgtBCImpl.java
 *@FileTitle : UN Number
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.18
 *@LastModifier : 이도형
 *@LastVersion : 1.0
 * 2009.05.18 이도형
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.basic;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.integration.IMDGCodeMgtDBDAO;
import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.integration.IMDGJMSQueueEAIDAO;
import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.AutoCreationVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.ScgImdgClssSegrListVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.ScgImdgCompGrpSegrListVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.ScgImdgUnNoSegrListVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.SegregationSimulationInputVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.SegregationSimulationOutputVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.SegregationTableGrpVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.UNNumberGrpVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.UNNumberListOptionVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgImdgSpclProvisVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ScgImdgClssCdVO;
import com.hanjin.syscommon.common.table.ScgImdgClssSegrVO;
import com.hanjin.syscommon.common.table.ScgImdgCompGrpSegrVO;
import com.hanjin.syscommon.common.table.ScgImdgExptQtyVO;
import com.hanjin.syscommon.common.table.ScgImdgPckCdVO;
import com.hanjin.syscommon.common.table.ScgImdgSegrGrpVO;
import com.hanjin.syscommon.common.table.ScgImdgSegrSymVO;
import com.hanjin.syscommon.common.table.ScgImdgSubsRskLblVO;
import com.hanjin.syscommon.common.table.ScgImdgUnNoClssCdVO;
import com.hanjin.syscommon.common.table.ScgImdgUnNoOrgRactVO;
import com.hanjin.syscommon.common.table.ScgImdgUnNoSegrGrpVO;
import com.hanjin.syscommon.common.table.ScgImdgUnNoSpclProviVO;

/**
 * ALPS-DangerousCargoInformationMgt Business Logic Basic Command implementation<br>
 * - ALPS-DangerousCargoInformationMgt에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Dohyoung Lee
 * @see VOP_SCG-0001EventResponse,IMDGCodeMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class IMDGCodeMgtBCImpl extends BasicCommandSupport implements
		IMDGCodeMgtBC {

	// Database Access Object
	private transient IMDGCodeMgtDBDAO dbDao = null;
	private IMDGJMSQueueEAIDAO eaiDao = null;

	/**
	 * IMDGCodeMgtBCImpl 객체 생성<br>
	 * IMDGCodeMgtDBDAO를 생성한다.<br>
	 */
	public IMDGCodeMgtBCImpl() {
		dbDao = new IMDGCodeMgtDBDAO();
		eaiDao = new IMDGJMSQueueEAIDAO();
	}

	/**
	 * UN Number 의 Detail을 조회 합니다. <br>
	 * 
	 * @param unNumberListOptionVO
	 * @return List<UNNumberListOptionVO>
	 * @exception EventException
	 */
	public List<UNNumberListOptionVO> searchUNNumberList(
			UNNumberListOptionVO unNumberListOptionVO) throws EventException {
		try {
			
			List<UNNumberListOptionVO> returnList = new ArrayList<UNNumberListOptionVO>();
			returnList = dbDao.searchUNNumberList(unNumberListOptionVO);
			
			if (returnList != null && !returnList.isEmpty()) {
				UNNumberListOptionVO vo = returnList.get(0);
				int maxRows = Integer.parseInt(vo.getTotal());
				vo.setMaxRows(maxRows);
			}
			
			return returnList;

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",
					new String[] { "UN No." }).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",
					new String[] { "UN No." }).getMessage(), ex);
		}
	}

	/**
	 * Segregation을 조회 합니다. <br>
	 * 
	 * @param unNumberListOptionVO
	 * @return List<ScgImdgUnNoSegrListVO>
	 * @exception EventException
	 */
	public List<ScgImdgUnNoSegrListVO> searchSegrList(
			UNNumberListOptionVO unNumberListOptionVO) throws EventException {
		try {
			return dbDao.searchSegrList(unNumberListOptionVO);

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",
					new String[] { "Segregation" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",
					new String[] { "Segregation" }).getMessage(), ex);
		}
	}

	/**
	 * Subsidiary risk(s)을 조회 합니다. <br>
	 * 
	 * @param unNumberListOptionVO
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchSubsRskLblList(
			UNNumberListOptionVO unNumberListOptionVO) throws EventException {
		try {
			String[] returnList = dbDao
					.searchSubsRskLblList(unNumberListOptionVO);
			return returnList;

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",
					new String[] { "Subsidiary risk(s)" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",
					new String[] { "Subsidiary risk(s)" }).getMessage(), ex);
		}
	}

	/**
	 * Special Provisions을 조회 합니다. <br>
	 * 
	 * @param unNumberListOptionVO
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchSpclProviList(
			UNNumberListOptionVO unNumberListOptionVO) throws EventException {
		try {
			String[] returnList = dbDao
					.searchSpclProviList(unNumberListOptionVO);
			return returnList;

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",
					new String[] { "Special Provisions" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",
					new String[] { "Special Provisions" }).getMessage(), ex);
		}
	}

	/**
	 * Segregation Group Detail을 조회 합니다. <br>
	 * 
	 * @param unNumberListOptionVO
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchSegrGrpDtlList(
			UNNumberListOptionVO unNumberListOptionVO) throws EventException {
		try {
			String[] returnList = dbDao
					.searchSegrGrpDtlList(unNumberListOptionVO);
			return returnList;

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",
					new String[] { "Segregation Group Detail" }).getMessage(),
					ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",
					new String[] { "Segregation Group Detail" }).getMessage(),
					ex);
		}
	}

	/**
	 * Segregation Group을 조회 합니다. <br>
	 * 
	 * @param unNumberListOptionVO
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchSegrGrpList(UNNumberListOptionVO unNumberListOptionVO)
			throws EventException {
		try {
			String[] returnList = dbDao.searchSegrGrpList(unNumberListOptionVO);
			return returnList;

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",
					new String[] { "Segregation Group" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",
					new String[] { "Segregation Group" }).getMessage(), ex);
		}
	}

	/**
	 * Clss Cd을 조회 합니다. <br>
	 * 
	 * @param unNumberListOptionVO
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchClssCdList(UNNumberListOptionVO unNumberListOptionVO)
			throws EventException {
		try {
			String[] returnList = dbDao.searchClssCdList(unNumberListOptionVO);
			return returnList;

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",
					new String[] { "Class Code" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",
					new String[] { "Class Code" }).getMessage(), ex);
		}
	}

	/**
	 * Excepted Q'ty을 조회 합니다. <br>
	 * 
	 * @return List<ScgImdgExptQtyVO>
	 * @exception EventException
	 */
	public List<ScgImdgExptQtyVO> searchExceptedQtyList() throws EventException {
		try {
			return dbDao.searchExceptedQtyList();

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",
					new String[] { "Excepted Q'ty" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",
					new String[] { "Excepted Q'ty" }).getMessage(), ex);
		}
	}

	/**
	 * Segregation Group의 List를 조회 합니다. <br>
	 * 
	 * @return List<ScgImdgSegrGrpVO>
	 * @exception EventException
	 */
	public List<ScgImdgSegrGrpVO> searchSegregationGroupList()
			throws EventException {
		try {
			return dbDao.searchSegregationGroupList();

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",
					new String[] { "Segregation Group" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",
					new String[] { "Segregation Group" }).getMessage(), ex);
		}
	}

	/**
	 * AutoCreation의 Segregation을 조회 합니다. <br>
	 * 
	 * @param autoCreationVO
	 * @return List<ScgImdgUnNoSegrListVO>
	 * @exception EventException
	 */
	public List<ScgImdgUnNoSegrListVO> searchAutoCreation(
			AutoCreationVO autoCreationVO) throws EventException {
		try {
			return dbDao.searchAutoCreation(autoCreationVO);

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",
					new String[] { "AutoCreation" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",
					new String[] { "AutoCreation" }).getMessage(), ex);
		}
	}

	/**
	 * UN Number을 생성/수정 합니다. <br>
	 * 
	 * @param unNumberGrpVO
	 * @param account
	 * @exception EventException
	 */
	public void manageUNNumber(UNNumberGrpVO unNumberGrpVO,
			SignOnUserAccount account) throws EventException {
		try {
			// (containerVO)
			UNNumberListOptionVO[] unNumberListOptionVO = null;
			ScgImdgUnNoSegrListVO[] scgImdgUnNoSegrListVO = null;

			unNumberListOptionVO = unNumberGrpVO.getUNNumberListOptionVOs();
			scgImdgUnNoSegrListVO = unNumberGrpVO.getScgImdgUnNoSegrListVOs();

			List<ScgImdgSubsRskLblVO> arrScgImdgSubsRskLblVO = new ArrayList<ScgImdgSubsRskLblVO>();
			List<ScgImdgUnNoSpclProviVO> arrScgImdgUnNoSpclProviVO = new ArrayList<ScgImdgUnNoSpclProviVO>();
			List<ScgImdgUnNoSegrListVO> arrScgImdgUnNoSegrListVO = new ArrayList<ScgImdgUnNoSegrListVO>();
			List<ScgImdgUnNoClssCdVO> arrScgImdgUnNoClssCdVO = new ArrayList<ScgImdgUnNoClssCdVO>();
			List<ScgImdgUnNoSegrGrpVO> arrScgImdgUnNoSegrGrpVO = new ArrayList<ScgImdgUnNoSegrGrpVO>();

			// SCG_IMDG_SUBS_RSK_LBL
			for (int i = 0; i < 4; i++) {
				ScgImdgSubsRskLblVO scgImdgSubsRskLblVOs = new ScgImdgSubsRskLblVO();
				scgImdgSubsRskLblVOs.setImdgUnNo(unNumberListOptionVO[0]
						.getImdgUnNo());
				scgImdgSubsRskLblVOs.setImdgUnNoSeq(unNumberListOptionVO[0]
						.getImdgUnNoSeq());
				scgImdgSubsRskLblVOs.setCreUsrId(account.getUsr_id());
				if (i == 0
						&& unNumberListOptionVO[0].getImdgSubsRskLblCd1()
								.trim() != null
						&& !unNumberListOptionVO[0].getImdgSubsRskLblCd1()
								.equals("")) {
					scgImdgSubsRskLblVOs
							.setImdgSubsRskLblCd(unNumberListOptionVO[0]
									.getImdgSubsRskLblCd1());
					arrScgImdgSubsRskLblVO.add(scgImdgSubsRskLblVOs);
				} else if (i == 1
						&& unNumberListOptionVO[0].getImdgSubsRskLblCd2()
								.trim() != null
						&& !unNumberListOptionVO[0].getImdgSubsRskLblCd2()
								.equals("")) {
					scgImdgSubsRskLblVOs
							.setImdgSubsRskLblCd(unNumberListOptionVO[0]
									.getImdgSubsRskLblCd2());
					arrScgImdgSubsRskLblVO.add(scgImdgSubsRskLblVOs);
				} else if (i == 2
						&& unNumberListOptionVO[0].getImdgSubsRskLblCd3()
								.trim() != null
						&& !unNumberListOptionVO[0].getImdgSubsRskLblCd3()
								.equals("")) {
					scgImdgSubsRskLblVOs
							.setImdgSubsRskLblCd(unNumberListOptionVO[0]
									.getImdgSubsRskLblCd3());
					arrScgImdgSubsRskLblVO.add(scgImdgSubsRskLblVOs);
				} else if (i == 3
						&& unNumberListOptionVO[0].getImdgSubsRskLblCd4()
								.trim() != null
						&& !unNumberListOptionVO[0].getImdgSubsRskLblCd4()
								.equals("")) {
					scgImdgSubsRskLblVOs
							.setImdgSubsRskLblCd(unNumberListOptionVO[0]
									.getImdgSubsRskLblCd4());
					arrScgImdgSubsRskLblVO.add(scgImdgSubsRskLblVOs);
				}
			}

			// SCG_IMDG_UN_NO_SPCL_PROVI
			for (int i = 0; i < 8; i++) {
				ScgImdgUnNoSpclProviVO scgImdgUnNoSpclProviVOs = new ScgImdgUnNoSpclProviVO();
				scgImdgUnNoSpclProviVOs.setImdgUnNo(unNumberListOptionVO[0]
						.getImdgUnNo());
				scgImdgUnNoSpclProviVOs.setImdgUnNoSeq(unNumberListOptionVO[0]
						.getImdgUnNoSeq());
				scgImdgUnNoSpclProviVOs.setCreUsrId(account.getUsr_id());

				if (i == 0
						&& unNumberListOptionVO[0].getImdgSpclProviNo1().trim() != null
						&& !unNumberListOptionVO[0].getImdgSpclProviNo1()
								.equals("")) {
					scgImdgUnNoSpclProviVOs
							.setImdgSpclProviNo(unNumberListOptionVO[0]
									.getImdgSpclProviNo1());
					scgImdgUnNoSpclProviVOs.setDpSeq("1");
					arrScgImdgUnNoSpclProviVO.add(scgImdgUnNoSpclProviVOs);
				} else if (i == 1
						&& unNumberListOptionVO[0].getImdgSpclProviNo2().trim() != null
						&& !unNumberListOptionVO[0].getImdgSpclProviNo2()
								.equals("")) {
					scgImdgUnNoSpclProviVOs
							.setImdgSpclProviNo(unNumberListOptionVO[0]
									.getImdgSpclProviNo2());
					scgImdgUnNoSpclProviVOs.setDpSeq("2");
					arrScgImdgUnNoSpclProviVO.add(scgImdgUnNoSpclProviVOs);
				} else if (i == 2
						&& unNumberListOptionVO[0].getImdgSpclProviNo3().trim() != null
						&& !unNumberListOptionVO[0].getImdgSpclProviNo3()
								.equals("")) {
					scgImdgUnNoSpclProviVOs
							.setImdgSpclProviNo(unNumberListOptionVO[0]
									.getImdgSpclProviNo3());
					scgImdgUnNoSpclProviVOs.setDpSeq("3");
					arrScgImdgUnNoSpclProviVO.add(scgImdgUnNoSpclProviVOs);
				} else if (i == 3
						&& unNumberListOptionVO[0].getImdgSpclProviNo4().trim() != null
						&& !unNumberListOptionVO[0].getImdgSpclProviNo4()
								.equals("")) {
					scgImdgUnNoSpclProviVOs
							.setImdgSpclProviNo(unNumberListOptionVO[0]
									.getImdgSpclProviNo4());
					scgImdgUnNoSpclProviVOs.setDpSeq("4");
					arrScgImdgUnNoSpclProviVO.add(scgImdgUnNoSpclProviVOs);
				} else if (i == 4
						&& unNumberListOptionVO[0].getImdgSpclProviNo5().trim() != null
						&& !unNumberListOptionVO[0].getImdgSpclProviNo5()
								.equals("")) {
					scgImdgUnNoSpclProviVOs
							.setImdgSpclProviNo(unNumberListOptionVO[0]
									.getImdgSpclProviNo5());
					scgImdgUnNoSpclProviVOs.setDpSeq("5");
					arrScgImdgUnNoSpclProviVO.add(scgImdgUnNoSpclProviVOs);
				} else if (i == 5
						&& unNumberListOptionVO[0].getImdgSpclProviNo6().trim() != null
						&& !unNumberListOptionVO[0].getImdgSpclProviNo6()
								.equals("")) {
					scgImdgUnNoSpclProviVOs
							.setImdgSpclProviNo(unNumberListOptionVO[0]
									.getImdgSpclProviNo6());
					scgImdgUnNoSpclProviVOs.setDpSeq("6");
					arrScgImdgUnNoSpclProviVO.add(scgImdgUnNoSpclProviVOs);
				} else if (i == 6
						&& unNumberListOptionVO[0].getImdgSpclProviNo7().trim() != null
						&& !unNumberListOptionVO[0].getImdgSpclProviNo7()
								.equals("")) {
					scgImdgUnNoSpclProviVOs
							.setImdgSpclProviNo(unNumberListOptionVO[0]
									.getImdgSpclProviNo7());
					scgImdgUnNoSpclProviVOs.setDpSeq("7");
					arrScgImdgUnNoSpclProviVO.add(scgImdgUnNoSpclProviVOs);
				} else if (i == 7
						&& unNumberListOptionVO[0].getImdgSpclProviNo8().trim() != null
						&& !unNumberListOptionVO[0].getImdgSpclProviNo8()
								.equals("")) {
					scgImdgUnNoSpclProviVOs
							.setImdgSpclProviNo(unNumberListOptionVO[0]
									.getImdgSpclProviNo8());
					scgImdgUnNoSpclProviVOs.setDpSeq("8");
					arrScgImdgUnNoSpclProviVO.add(scgImdgUnNoSpclProviVOs);
				}
			}

			// SCG_IMDG_UN_NO_SEGR
			for (int i = 0; i < 20; i++) {
				ScgImdgUnNoSegrListVO scgImdgUnNoSegrListVOs = new ScgImdgUnNoSegrListVO();
				scgImdgUnNoSegrListVOs.setImdgUnNo(unNumberListOptionVO[0]
						.getImdgUnNo());
				scgImdgUnNoSegrListVOs.setImdgUnNoSeq(unNumberListOptionVO[0]
						.getImdgUnNoSeq());
				if (i == 0) {
					scgImdgUnNoSegrListVOs.setImdgClssCd("1.1");
					scgImdgUnNoSegrListVOs
							.setImdgSegrCd(scgImdgUnNoSegrListVO[0]
									.getClssCd11());
					scgImdgUnNoSegrListVOs.setCreUsrId(account.getUsr_id());
					arrScgImdgUnNoSegrListVO.add(scgImdgUnNoSegrListVOs);
				} else if (i == 1) {
					scgImdgUnNoSegrListVOs.setImdgClssCd("1.2");
					scgImdgUnNoSegrListVOs
							.setImdgSegrCd(scgImdgUnNoSegrListVO[0]
									.getClssCd12());
					scgImdgUnNoSegrListVOs.setCreUsrId(account.getUsr_id());
					arrScgImdgUnNoSegrListVO.add(scgImdgUnNoSegrListVOs);
				} else if (i == 2) {
					scgImdgUnNoSegrListVOs.setImdgClssCd("1.3");
					scgImdgUnNoSegrListVOs
							.setImdgSegrCd(scgImdgUnNoSegrListVO[0]
									.getClssCd13());
					scgImdgUnNoSegrListVOs.setCreUsrId(account.getUsr_id());
					arrScgImdgUnNoSegrListVO.add(scgImdgUnNoSegrListVOs);
				} else if (i == 3) {
					scgImdgUnNoSegrListVOs.setImdgClssCd("1.4");
					scgImdgUnNoSegrListVOs
							.setImdgSegrCd(scgImdgUnNoSegrListVO[0]
									.getClssCd14());
					scgImdgUnNoSegrListVOs.setCreUsrId(account.getUsr_id());
					arrScgImdgUnNoSegrListVO.add(scgImdgUnNoSegrListVOs);
				} else if (i == 4) {
					scgImdgUnNoSegrListVOs.setImdgClssCd("1.5");
					scgImdgUnNoSegrListVOs
							.setImdgSegrCd(scgImdgUnNoSegrListVO[0]
									.getClssCd15());
					scgImdgUnNoSegrListVOs.setCreUsrId(account.getUsr_id());
					arrScgImdgUnNoSegrListVO.add(scgImdgUnNoSegrListVOs);
				} else if (i == 5) {
					scgImdgUnNoSegrListVOs.setImdgClssCd("1.6");
					scgImdgUnNoSegrListVOs
							.setImdgSegrCd(scgImdgUnNoSegrListVO[0]
									.getClssCd16());
					scgImdgUnNoSegrListVOs.setCreUsrId(account.getUsr_id());
					arrScgImdgUnNoSegrListVO.add(scgImdgUnNoSegrListVOs);
				} else if (i == 6) {
					scgImdgUnNoSegrListVOs.setImdgClssCd("2.1");
					scgImdgUnNoSegrListVOs
							.setImdgSegrCd(scgImdgUnNoSegrListVO[0]
									.getClssCd21());
					scgImdgUnNoSegrListVOs.setCreUsrId(account.getUsr_id());
					arrScgImdgUnNoSegrListVO.add(scgImdgUnNoSegrListVOs);
				} else if (i == 7) {
					scgImdgUnNoSegrListVOs.setImdgClssCd("2.2");
					scgImdgUnNoSegrListVOs
							.setImdgSegrCd(scgImdgUnNoSegrListVO[0]
									.getClssCd22());
					scgImdgUnNoSegrListVOs.setCreUsrId(account.getUsr_id());
					arrScgImdgUnNoSegrListVO.add(scgImdgUnNoSegrListVOs);
				} else if (i == 8) {
					scgImdgUnNoSegrListVOs.setImdgClssCd("2.3");
					scgImdgUnNoSegrListVOs
							.setImdgSegrCd(scgImdgUnNoSegrListVO[0]
									.getClssCd23());
					scgImdgUnNoSegrListVOs.setCreUsrId(account.getUsr_id());
					arrScgImdgUnNoSegrListVO.add(scgImdgUnNoSegrListVOs);
				} else if (i == 9) {
					scgImdgUnNoSegrListVOs.setImdgClssCd("3");
					scgImdgUnNoSegrListVOs
							.setImdgSegrCd(scgImdgUnNoSegrListVO[0]
									.getClssCd3());
					scgImdgUnNoSegrListVOs.setCreUsrId(account.getUsr_id());
					arrScgImdgUnNoSegrListVO.add(scgImdgUnNoSegrListVOs);
				} else if (i == 10) {
					scgImdgUnNoSegrListVOs.setImdgClssCd("4.1");
					scgImdgUnNoSegrListVOs
							.setImdgSegrCd(scgImdgUnNoSegrListVO[0]
									.getClssCd41());
					scgImdgUnNoSegrListVOs.setCreUsrId(account.getUsr_id());
					arrScgImdgUnNoSegrListVO.add(scgImdgUnNoSegrListVOs);
				} else if (i == 11) {
					scgImdgUnNoSegrListVOs.setImdgClssCd("4.2");
					scgImdgUnNoSegrListVOs
							.setImdgSegrCd(scgImdgUnNoSegrListVO[0]
									.getClssCd42());
					scgImdgUnNoSegrListVOs.setCreUsrId(account.getUsr_id());
					arrScgImdgUnNoSegrListVO.add(scgImdgUnNoSegrListVOs);
				} else if (i == 12) {
					scgImdgUnNoSegrListVOs.setImdgClssCd("4.3");
					scgImdgUnNoSegrListVOs
							.setImdgSegrCd(scgImdgUnNoSegrListVO[0]
									.getClssCd43());
					scgImdgUnNoSegrListVOs.setCreUsrId(account.getUsr_id());
					arrScgImdgUnNoSegrListVO.add(scgImdgUnNoSegrListVOs);
				} else if (i == 13) {
					scgImdgUnNoSegrListVOs.setImdgClssCd("5.1");
					scgImdgUnNoSegrListVOs
							.setImdgSegrCd(scgImdgUnNoSegrListVO[0]
									.getClssCd51());
					scgImdgUnNoSegrListVOs.setCreUsrId(account.getUsr_id());
					arrScgImdgUnNoSegrListVO.add(scgImdgUnNoSegrListVOs);
				} else if (i == 14) {
					scgImdgUnNoSegrListVOs.setImdgClssCd("5.2");
					scgImdgUnNoSegrListVOs
							.setImdgSegrCd(scgImdgUnNoSegrListVO[0]
									.getClssCd52());
					scgImdgUnNoSegrListVOs.setCreUsrId(account.getUsr_id());
					arrScgImdgUnNoSegrListVO.add(scgImdgUnNoSegrListVOs);
				} else if (i == 15) {
					scgImdgUnNoSegrListVOs.setImdgClssCd("6.1");
					scgImdgUnNoSegrListVOs
							.setImdgSegrCd(scgImdgUnNoSegrListVO[0]
									.getClssCd61());
					scgImdgUnNoSegrListVOs.setCreUsrId(account.getUsr_id());
					arrScgImdgUnNoSegrListVO.add(scgImdgUnNoSegrListVOs);
				} else if (i == 16) {
					scgImdgUnNoSegrListVOs.setImdgClssCd("6.2");
					scgImdgUnNoSegrListVOs
							.setImdgSegrCd(scgImdgUnNoSegrListVO[0]
									.getClssCd62());
					scgImdgUnNoSegrListVOs.setCreUsrId(account.getUsr_id());
					arrScgImdgUnNoSegrListVO.add(scgImdgUnNoSegrListVOs);
				} else if (i == 17) {
					scgImdgUnNoSegrListVOs.setImdgClssCd("7");
					scgImdgUnNoSegrListVOs
							.setImdgSegrCd(scgImdgUnNoSegrListVO[0]
									.getClssCd7());
					scgImdgUnNoSegrListVOs.setCreUsrId(account.getUsr_id());
					arrScgImdgUnNoSegrListVO.add(scgImdgUnNoSegrListVOs);
				} else if (i == 18) {
					scgImdgUnNoSegrListVOs.setImdgClssCd("8");
					scgImdgUnNoSegrListVOs
							.setImdgSegrCd(scgImdgUnNoSegrListVO[0]
									.getClssCd8());
					scgImdgUnNoSegrListVOs.setCreUsrId(account.getUsr_id());
					arrScgImdgUnNoSegrListVO.add(scgImdgUnNoSegrListVOs);
				} else if (i == 19) {
					scgImdgUnNoSegrListVOs.setImdgClssCd("9");
					scgImdgUnNoSegrListVOs
							.setImdgSegrCd(scgImdgUnNoSegrListVO[0]
									.getClssCd9());
					scgImdgUnNoSegrListVOs.setCreUsrId(account.getUsr_id());
					arrScgImdgUnNoSegrListVO.add(scgImdgUnNoSegrListVOs);
				}
			}

			// SCG_IMDG_UN_NO_CLSS_CD
			String strAwayFmImdgClssCd = unNumberListOptionVO[0]
					.getAwayFmImdgClssCd().toString().trim();
			String strSprtFmImdgClssCd = unNumberListOptionVO[0]
					.getSprtFmImdgClssCd().toString().trim();
			String strSprtHldFmImdgClssCd = unNumberListOptionVO[0]
					.getSprtHldFmImdgClssCd().toString().trim();
			String strSprtLonFmImdgClssCd = unNumberListOptionVO[0]
					.getSprtLonFmImdgClssCd().toString().trim();
			String[] arrAwayFmImdgClssCd = strAwayFmImdgClssCd.split("\\/");
			String[] arrSprtFmImdgClssCd = strSprtFmImdgClssCd.split("\\/");
			String[] arrSprtHldFmImdgClssCd = strSprtHldFmImdgClssCd
					.split("\\/");
			String[] arrSprtLonFmImdgClssCd = strSprtLonFmImdgClssCd
					.split("\\/");
			for (int i = 0; i < arrAwayFmImdgClssCd.length; i++) {
				if (arrAwayFmImdgClssCd[i] != null
						&& !arrAwayFmImdgClssCd[i].equals("")) {
					ScgImdgUnNoClssCdVO scgImdgUnNoClssCdVOs = new ScgImdgUnNoClssCdVO();
					scgImdgUnNoClssCdVOs.setImdgUnNo(unNumberListOptionVO[0]
							.getImdgUnNo());
					scgImdgUnNoClssCdVOs.setImdgUnNoSeq(unNumberListOptionVO[0]
							.getImdgUnNoSeq());
					scgImdgUnNoClssCdVOs.setCreUsrId(account.getUsr_id());
					scgImdgUnNoClssCdVOs.setImdgClssCd(arrAwayFmImdgClssCd[i]);
					scgImdgUnNoClssCdVOs.setImdgSegrGrpStwgTpCd("1");
					scgImdgUnNoClssCdVOs.setDpSeq(i + 1 + "");
					arrScgImdgUnNoClssCdVO.add(scgImdgUnNoClssCdVOs);
				}
			}
			for (int i = 0; i < arrSprtFmImdgClssCd.length; i++) {
				if (arrSprtFmImdgClssCd[i] != null
						&& !arrSprtFmImdgClssCd[i].equals("")) {
					ScgImdgUnNoClssCdVO scgImdgUnNoClssCdVOs = new ScgImdgUnNoClssCdVO();
					scgImdgUnNoClssCdVOs.setImdgUnNo(unNumberListOptionVO[0]
							.getImdgUnNo());
					scgImdgUnNoClssCdVOs.setImdgUnNoSeq(unNumberListOptionVO[0]
							.getImdgUnNoSeq());
					scgImdgUnNoClssCdVOs.setCreUsrId(account.getUsr_id());
					scgImdgUnNoClssCdVOs.setImdgClssCd(arrSprtFmImdgClssCd[i]);
					scgImdgUnNoClssCdVOs.setImdgSegrGrpStwgTpCd("2");
					scgImdgUnNoClssCdVOs.setDpSeq(i + 1 + "");
					arrScgImdgUnNoClssCdVO.add(scgImdgUnNoClssCdVOs);
				}
			}
			for (int i = 0; i < arrSprtHldFmImdgClssCd.length; i++) {
				if (arrSprtHldFmImdgClssCd[i] != null
						&& !arrSprtHldFmImdgClssCd[i].equals("")) {
					ScgImdgUnNoClssCdVO scgImdgUnNoClssCdVOs = new ScgImdgUnNoClssCdVO();
					scgImdgUnNoClssCdVOs.setImdgUnNo(unNumberListOptionVO[0]
							.getImdgUnNo());
					scgImdgUnNoClssCdVOs.setImdgUnNoSeq(unNumberListOptionVO[0]
							.getImdgUnNoSeq());
					scgImdgUnNoClssCdVOs.setCreUsrId(account.getUsr_id());
					scgImdgUnNoClssCdVOs
							.setImdgClssCd(arrSprtHldFmImdgClssCd[i]);
					scgImdgUnNoClssCdVOs.setImdgSegrGrpStwgTpCd("3");
					scgImdgUnNoClssCdVOs.setDpSeq(i + 1 + "");
					arrScgImdgUnNoClssCdVO.add(scgImdgUnNoClssCdVOs);
				}
			}
			for (int i = 0; i < arrSprtLonFmImdgClssCd.length; i++) {
				if (arrSprtLonFmImdgClssCd[i] != null
						&& !arrSprtLonFmImdgClssCd[i].equals("")) {
					ScgImdgUnNoClssCdVO scgImdgUnNoClssCdVOs = new ScgImdgUnNoClssCdVO();
					scgImdgUnNoClssCdVOs.setImdgUnNo(unNumberListOptionVO[0]
							.getImdgUnNo());
					scgImdgUnNoClssCdVOs.setImdgUnNoSeq(unNumberListOptionVO[0]
							.getImdgUnNoSeq());
					scgImdgUnNoClssCdVOs.setCreUsrId(account.getUsr_id());
					scgImdgUnNoClssCdVOs
							.setImdgClssCd(arrSprtLonFmImdgClssCd[i]);
					scgImdgUnNoClssCdVOs.setImdgSegrGrpStwgTpCd("4");
					scgImdgUnNoClssCdVOs.setDpSeq(i + 1 + "");
					arrScgImdgUnNoClssCdVO.add(scgImdgUnNoClssCdVOs);
				}
			}

			// SCG_IMDG_UN_NO_SEGR_GRP
			String strAwayDpSeq = unNumberListOptionVO[0].getAwayDpSeq()
					.toString().trim();
			String strSprtDpSeq = unNumberListOptionVO[0].getSprtDpSeq()
					.toString().trim();
			String[] arrAwayDpSeq = strAwayDpSeq.split("\\/");
			String[] arrSprtDpSeq = strSprtDpSeq.split("\\/");

			for (int i = 0; i < arrAwayDpSeq.length; i++) {
				if (arrAwayDpSeq[i] != null && !arrAwayDpSeq[i].equals("")) {
					ScgImdgUnNoSegrGrpVO scgImdgUnNoSegrGrpVOs = new ScgImdgUnNoSegrGrpVO();
					scgImdgUnNoSegrGrpVOs.setImdgUnNo(unNumberListOptionVO[0]
							.getImdgUnNo());
					scgImdgUnNoSegrGrpVOs
							.setImdgUnNoSeq(unNumberListOptionVO[0]
									.getImdgUnNoSeq());
					scgImdgUnNoSegrGrpVOs.setCreUsrId(account.getUsr_id());
					scgImdgUnNoSegrGrpVOs.setImdgSegrGrpNo(arrAwayDpSeq[i]);
					scgImdgUnNoSegrGrpVOs.setImdgSegrGrpStwgTpCd("1");
					scgImdgUnNoSegrGrpVOs.setDpSeq(i + 1 + "");
					arrScgImdgUnNoSegrGrpVO.add(scgImdgUnNoSegrGrpVOs);
				}
			}
			for (int i = 0; i < arrSprtDpSeq.length; i++) {
				if (arrSprtDpSeq[i] != null && !arrSprtDpSeq[i].equals("")) {
					ScgImdgUnNoSegrGrpVO scgImdgUnNoSegrGrpVOs = new ScgImdgUnNoSegrGrpVO();
					scgImdgUnNoSegrGrpVOs.setImdgUnNo(unNumberListOptionVO[0]
							.getImdgUnNo());
					scgImdgUnNoSegrGrpVOs
							.setImdgUnNoSeq(unNumberListOptionVO[0]
									.getImdgUnNoSeq());
					scgImdgUnNoSegrGrpVOs.setCreUsrId(account.getUsr_id());
					scgImdgUnNoSegrGrpVOs.setImdgSegrGrpNo(arrSprtDpSeq[i]);
					scgImdgUnNoSegrGrpVOs.setImdgSegrGrpStwgTpCd("2");
					scgImdgUnNoSegrGrpVOs.setDpSeq(i + 1 + "");
					arrScgImdgUnNoSegrGrpVO.add(scgImdgUnNoSegrGrpVOs);
				}
			}

			// SCG_IMDG_UN_NO_ORG_RACT
			ScgImdgUnNoOrgRactVO scgImdgUnNoOrgRactVO = new ScgImdgUnNoOrgRactVO();
			scgImdgUnNoOrgRactVO.setImdgUnNo(unNumberListOptionVO[0]
					.getImdgUnNo());
			scgImdgUnNoOrgRactVO.setImdgUnNoSeq(unNumberListOptionVO[0]
					.getImdgUnNoSeq());
			scgImdgUnNoOrgRactVO.setImdgOrgRactTpCd(unNumberListOptionVO[0]
					.getImdgOrgRactTpCd());
			scgImdgUnNoOrgRactVO.setImdgTecNm(unNumberListOptionVO[0]
					.getImdgTecNm());
			scgImdgUnNoOrgRactVO.setImdgConcRtCtnt(unNumberListOptionVO[0]
					.getImdgConcRtCtnt());
			scgImdgUnNoOrgRactVO.setImdgPckMzdCd(unNumberListOptionVO[0]
					.getImdgPckMzdCd());
			scgImdgUnNoOrgRactVO.setImdgCtrlTemp(unNumberListOptionVO[0]
					.getImdgCtrlTemp());
			scgImdgUnNoOrgRactVO.setImdgEmerTemp(unNumberListOptionVO[0]
					.getImdgEmerTemp());
			scgImdgUnNoOrgRactVO.setCreUsrId(account.getUsr_id());
			scgImdgUnNoOrgRactVO.setUpdUsrId(account.getUsr_id());

			if (unNumberListOptionVO[0].getIbflag().equals("I")) {
				unNumberListOptionVO[0].setCreUsrId(account.getUsr_id());
				dbDao.addUNNumber(unNumberListOptionVO[0]);
				dbDao.addSubsidiaryS(arrScgImdgSubsRskLblVO);
				dbDao.addSpecialProvisionS(arrScgImdgUnNoSpclProviVO);
				dbDao.addSegrListS(arrScgImdgUnNoSegrListVO);
				dbDao.addClssCdListS(arrScgImdgUnNoClssCdVO);
				dbDao.addSegrGrpListS(arrScgImdgUnNoSegrGrpVO);
				dbDao.addOrgRact(scgImdgUnNoOrgRactVO);
			} else if (unNumberListOptionVO[0].getIbflag().equals("U")) {
				unNumberListOptionVO[0].setUpdUsrId(account.getUsr_id());
				dbDao.modifyUNNumber(unNumberListOptionVO[0]);
				dbDao.removeSubsidiaryS(arrScgImdgSubsRskLblVO);
				dbDao.addSubsidiaryS(arrScgImdgSubsRskLblVO);

				if (arrScgImdgSubsRskLblVO.size() < 1) {
					ScgImdgSubsRskLblVO scgImdgSubsRskLblVOs = new ScgImdgSubsRskLblVO();
					scgImdgSubsRskLblVOs.setImdgUnNo(unNumberListOptionVO[0]
							.getImdgUnNo());
					scgImdgSubsRskLblVOs.setImdgUnNoSeq(unNumberListOptionVO[0]
							.getImdgUnNoSeq());
					arrScgImdgSubsRskLblVO.add(scgImdgSubsRskLblVOs);
					dbDao.removeSubsidiaryS(arrScgImdgSubsRskLblVO);
				}
				dbDao.removeSpecialProvisionS(arrScgImdgUnNoSpclProviVO);
				dbDao.addSpecialProvisionS(arrScgImdgUnNoSpclProviVO);

				if (arrScgImdgUnNoSpclProviVO.size() < 1) {
					// SCG_IMDG_UN_NO_SPCL_PROVI
					for (int i = 0; i < 8; i++) {
						String j = Integer.toString(i + 1);
						ScgImdgUnNoSpclProviVO scgImdgUnNoSpclProviVOs = new ScgImdgUnNoSpclProviVO();
						scgImdgUnNoSpclProviVOs
								.setImdgUnNo(unNumberListOptionVO[0]
										.getImdgUnNo());
						scgImdgUnNoSpclProviVOs
								.setImdgUnNoSeq(unNumberListOptionVO[0]
										.getImdgUnNoSeq());
						scgImdgUnNoSpclProviVOs.setDpSeq(j);
						arrScgImdgUnNoSpclProviVO.add(scgImdgUnNoSpclProviVOs);
					}
					dbDao.removeSpecialProvisionS(arrScgImdgUnNoSpclProviVO);
				}
				dbDao.modifySegrListS(arrScgImdgUnNoSegrListVO);
				dbDao.removeClssCdListS(arrScgImdgUnNoClssCdVO);
				dbDao.addClssCdListS(arrScgImdgUnNoClssCdVO);

				if (arrScgImdgUnNoClssCdVO.size() < 1) {
					ScgImdgUnNoClssCdVO scgImdgUnNoClssCdVOs = new ScgImdgUnNoClssCdVO();
					scgImdgUnNoClssCdVOs.setImdgUnNo(unNumberListOptionVO[0]
							.getImdgUnNo());
					scgImdgUnNoClssCdVOs.setImdgUnNoSeq(unNumberListOptionVO[0]
							.getImdgUnNoSeq());
					arrScgImdgUnNoClssCdVO.add(scgImdgUnNoClssCdVOs);
					dbDao.removeClssCdListS(arrScgImdgUnNoClssCdVO);
				}
				dbDao.removeSegrGrpListS(arrScgImdgUnNoSegrGrpVO);
				dbDao.addSegrGrpListS(arrScgImdgUnNoSegrGrpVO);

				if (arrScgImdgUnNoSegrGrpVO.size() < 1) {
					ScgImdgUnNoSegrGrpVO scgImdgUnNoSegrGrpVOs = new ScgImdgUnNoSegrGrpVO();
					scgImdgUnNoSegrGrpVOs.setImdgUnNo(unNumberListOptionVO[0]
							.getImdgUnNo());
					scgImdgUnNoSegrGrpVOs
							.setImdgUnNoSeq(unNumberListOptionVO[0]
									.getImdgUnNoSeq());
					arrScgImdgUnNoSegrGrpVO.add(scgImdgUnNoSegrGrpVOs);
					dbDao.removeSegrGrpListS(arrScgImdgUnNoSegrGrpVO);
				}
				dbDao.removeOrgRact(scgImdgUnNoOrgRactVO);
				dbDao.addOrgRact(scgImdgUnNoOrgRactVO);
			} else if (unNumberListOptionVO[0].getIbflag().equals("D")) {
				// 삭제일때만 미리 EAI-SEND
//				try {
					//sendScgImdgUnNo(unNumberListOptionVO[0], "D");
					//sendScgImdgSubRskLbl(arrScgImdgSubsRskLblVO,
					//		unNumberListOptionVO[0].getIbflag());
//				} catch (Exception e) {
//					log.error("err : EAI delete");
//				}
				dbDao.removeSubsidiaryS(arrScgImdgSubsRskLblVO);
				dbDao.removeSpecialProvisionS(arrScgImdgUnNoSpclProviVO);
				dbDao.removeSegrListS(arrScgImdgUnNoSegrListVO);
				dbDao.removeClssCdListS(arrScgImdgUnNoClssCdVO);
				dbDao.removeSegrGrpListS(arrScgImdgUnNoSegrGrpVO);
				dbDao.removeOrgRact(scgImdgUnNoOrgRactVO);
				dbDao.removeUNNumber(unNumberListOptionVO[0]);

			}

//			if (!unNumberListOptionVO[0].getIbflag().equals("D")) {
//				try {
					//sendScgImdgUnNo(unNumberListOptionVO[0],
					//		unNumberListOptionVO[0].getIbflag());
					//sendScgImdgSubRskLbl(arrScgImdgSubsRskLblVO,
					//		unNumberListOptionVO[0].getIbflag());
//				} catch (Exception e) {
//					log.error("err : " + unNumberListOptionVO[0].getIbflag());
//				}
//			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192",
					new String[] { "UN Number" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192",
					new String[] { "UN Number" }).getMessage(), ex);
		}
	}

	/**
	 * Numbers & symbols in segregation table between various Classes의 내용을 조회
	 * 합니다. <br>
	 * 
	 * @return List<ScgImdgClssSegrListVO>
	 * @exception EventException
	 */
	public List<ScgImdgClssSegrListVO> searchSegregationClssList()
			throws EventException {
		try {
			return dbDao.searchSegregationClssList();
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(
					new ErrorHandler(
							"COM12203",
							new String[] { "Numbers & symbols in segregation table between various Classes" })
							.getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(
					new ErrorHandler(
							"COM12203",
							new String[] { "Numbers & symbols in segregation table between various Classes" })
							.getMessage(), ex);
		}
	}

	/**
	 * Permitted mixed stowage for goods of class 1의 내용을 조회 합니다. <br>
	 * 
	 * @return List<ScgImdgCompGrpSegrListVO>
	 * @exception EventException
	 */
	public List<ScgImdgCompGrpSegrListVO> searchSegregationCompList()
			throws EventException {
		try {
			return dbDao.searchSegregationCompList();
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(
					new ErrorHandler(
							"COM12203",
							new String[] { "Permitted mixed stowage for goods of class 1" })
							.getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(
					new ErrorHandler(
							"COM12203",
							new String[] { "Permitted mixed stowage for goods of class 1" })
							.getMessage(), ex);
		}
	}

	/**
	 * Segregation Table의 내용을 수정 합니다. <br>
	 * 
	 * @param segregationTableGrpVO
	 * @param account
	 * @exception EventException
	 */
	public void manageSegregation(SegregationTableGrpVO segregationTableGrpVO,
			SignOnUserAccount account) throws EventException {
		try {

			ScgImdgClssSegrListVO[] scgImdgClssSegrListVOs = null;
			ScgImdgCompGrpSegrListVO[] scgImdgCompGrpSegrListVOs = null;

			scgImdgClssSegrListVOs = segregationTableGrpVO
					.getScgImdgClssSegrListVOs();
			scgImdgCompGrpSegrListVOs = segregationTableGrpVO
					.getScgImdgCompGrpSegrListVOs();

			List<ScgImdgClssSegrVO> insertVoList = new ArrayList<ScgImdgClssSegrVO>();
			List<ScgImdgClssSegrVO> updateVoList = new ArrayList<ScgImdgClssSegrVO>();
			List<ScgImdgClssSegrVO> deleteVoList = new ArrayList<ScgImdgClssSegrVO>();
			if (scgImdgClssSegrListVOs != null) {
				for (int i = 0; i < scgImdgClssSegrListVOs.length; i++) {
					if (scgImdgClssSegrListVOs[i].getIbflag().equals("I")) {
						for (int j = 0; j < 20; j++) {
							ScgImdgClssSegrVO scgImdgClssSegrVO = new ScgImdgClssSegrVO();
							scgImdgClssSegrVO
									.setRowImdgClssCd(scgImdgClssSegrListVOs[i]
											.getRowImdgClssCd());
							if (j == 0) {
								scgImdgClssSegrVO.setColImdgClssCd("1.1");
								scgImdgClssSegrVO
										.setImdgSegrCd(scgImdgClssSegrListVOs[i]
												.getClssCd11());
								scgImdgClssSegrVO.setCreUsrId(account
										.getUsr_id());
								insertVoList.add(scgImdgClssSegrVO);
							} else if (j == 1) {
								scgImdgClssSegrVO.setColImdgClssCd("1.2");
								scgImdgClssSegrVO
										.setImdgSegrCd(scgImdgClssSegrListVOs[i]
												.getClssCd12());
								scgImdgClssSegrVO.setCreUsrId(account
										.getUsr_id());
								insertVoList.add(scgImdgClssSegrVO);
							} else if (j == 2) {
								scgImdgClssSegrVO.setColImdgClssCd("1.3");
								scgImdgClssSegrVO
										.setImdgSegrCd(scgImdgClssSegrListVOs[i]
												.getClssCd13());
								scgImdgClssSegrVO.setCreUsrId(account
										.getUsr_id());
								insertVoList.add(scgImdgClssSegrVO);
							} else if (j == 3) {
								scgImdgClssSegrVO.setColImdgClssCd("1.4");
								scgImdgClssSegrVO
										.setImdgSegrCd(scgImdgClssSegrListVOs[i]
												.getClssCd14());
								scgImdgClssSegrVO.setCreUsrId(account
										.getUsr_id());
								insertVoList.add(scgImdgClssSegrVO);
							} else if (j == 4) {
								scgImdgClssSegrVO.setColImdgClssCd("1.5");
								scgImdgClssSegrVO
										.setImdgSegrCd(scgImdgClssSegrListVOs[i]
												.getClssCd15());
								scgImdgClssSegrVO.setCreUsrId(account
										.getUsr_id());
								insertVoList.add(scgImdgClssSegrVO);
							} else if (j == 5) {
								scgImdgClssSegrVO.setColImdgClssCd("1.6");
								scgImdgClssSegrVO
										.setImdgSegrCd(scgImdgClssSegrListVOs[i]
												.getClssCd16());
								scgImdgClssSegrVO.setCreUsrId(account
										.getUsr_id());
								insertVoList.add(scgImdgClssSegrVO);
							} else if (j == 6) {
								scgImdgClssSegrVO.setColImdgClssCd("2.1");
								scgImdgClssSegrVO
										.setImdgSegrCd(scgImdgClssSegrListVOs[i]
												.getClssCd21());
								scgImdgClssSegrVO.setCreUsrId(account
										.getUsr_id());
								insertVoList.add(scgImdgClssSegrVO);
							} else if (j == 7) {
								scgImdgClssSegrVO.setColImdgClssCd("2.2");
								scgImdgClssSegrVO
										.setImdgSegrCd(scgImdgClssSegrListVOs[i]
												.getClssCd22());
								scgImdgClssSegrVO.setCreUsrId(account
										.getUsr_id());
								insertVoList.add(scgImdgClssSegrVO);
							} else if (j == 8) {
								scgImdgClssSegrVO.setColImdgClssCd("2.3");
								scgImdgClssSegrVO
										.setImdgSegrCd(scgImdgClssSegrListVOs[i]
												.getClssCd23());
								scgImdgClssSegrVO.setCreUsrId(account
										.getUsr_id());
								insertVoList.add(scgImdgClssSegrVO);
							} else if (j == 9) {
								scgImdgClssSegrVO.setColImdgClssCd("3");
								scgImdgClssSegrVO
										.setImdgSegrCd(scgImdgClssSegrListVOs[i]
												.getClssCd3());
								scgImdgClssSegrVO.setCreUsrId(account
										.getUsr_id());
								insertVoList.add(scgImdgClssSegrVO);
							} else if (j == 10) {
								scgImdgClssSegrVO.setColImdgClssCd("4.1");
								scgImdgClssSegrVO
										.setImdgSegrCd(scgImdgClssSegrListVOs[i]
												.getClssCd41());
								scgImdgClssSegrVO.setCreUsrId(account
										.getUsr_id());
								insertVoList.add(scgImdgClssSegrVO);
							} else if (j == 11) {
								scgImdgClssSegrVO.setColImdgClssCd("4.2");
								scgImdgClssSegrVO
										.setImdgSegrCd(scgImdgClssSegrListVOs[i]
												.getClssCd42());
								scgImdgClssSegrVO.setCreUsrId(account
										.getUsr_id());
								insertVoList.add(scgImdgClssSegrVO);
							} else if (j == 12) {
								scgImdgClssSegrVO.setColImdgClssCd("4.3");
								scgImdgClssSegrVO
										.setImdgSegrCd(scgImdgClssSegrListVOs[i]
												.getClssCd43());
								scgImdgClssSegrVO.setCreUsrId(account
										.getUsr_id());
								insertVoList.add(scgImdgClssSegrVO);
							} else if (j == 13) {
								scgImdgClssSegrVO.setColImdgClssCd("5.1");
								scgImdgClssSegrVO
										.setImdgSegrCd(scgImdgClssSegrListVOs[i]
												.getClssCd51());
								scgImdgClssSegrVO.setCreUsrId(account
										.getUsr_id());
								insertVoList.add(scgImdgClssSegrVO);
							} else if (j == 14) {
								scgImdgClssSegrVO.setColImdgClssCd("5.2");
								scgImdgClssSegrVO
										.setImdgSegrCd(scgImdgClssSegrListVOs[i]
												.getClssCd52());
								scgImdgClssSegrVO.setCreUsrId(account
										.getUsr_id());
								insertVoList.add(scgImdgClssSegrVO);
							} else if (j == 15) {
								scgImdgClssSegrVO.setColImdgClssCd("6.1");
								scgImdgClssSegrVO
										.setImdgSegrCd(scgImdgClssSegrListVOs[i]
												.getClssCd61());
								scgImdgClssSegrVO.setCreUsrId(account
										.getUsr_id());
								insertVoList.add(scgImdgClssSegrVO);
							} else if (j == 16) {
								scgImdgClssSegrVO.setColImdgClssCd("6.2");
								scgImdgClssSegrVO
										.setImdgSegrCd(scgImdgClssSegrListVOs[i]
												.getClssCd62());
								scgImdgClssSegrVO.setCreUsrId(account
										.getUsr_id());
								insertVoList.add(scgImdgClssSegrVO);
							} else if (j == 17) {
								scgImdgClssSegrVO.setColImdgClssCd("7");
								scgImdgClssSegrVO
										.setImdgSegrCd(scgImdgClssSegrListVOs[i]
												.getClssCd7());
								scgImdgClssSegrVO.setCreUsrId(account
										.getUsr_id());
								insertVoList.add(scgImdgClssSegrVO);
							} else if (j == 18) {
								scgImdgClssSegrVO.setColImdgClssCd("8");
								scgImdgClssSegrVO
										.setImdgSegrCd(scgImdgClssSegrListVOs[i]
												.getClssCd8());
								scgImdgClssSegrVO.setCreUsrId(account
										.getUsr_id());
								insertVoList.add(scgImdgClssSegrVO);
							} else if (j == 19) {
								scgImdgClssSegrVO.setColImdgClssCd("9");
								scgImdgClssSegrVO
										.setImdgSegrCd(scgImdgClssSegrListVOs[i]
												.getClssCd9());
								scgImdgClssSegrVO.setCreUsrId(account
										.getUsr_id());
								insertVoList.add(scgImdgClssSegrVO);
							}
						}
					} else if (scgImdgClssSegrListVOs[i].getIbflag()
							.equals("U")) {
						for (int j = 0; j < 20; j++) {
							ScgImdgClssSegrVO scgImdgClssSegrVO = new ScgImdgClssSegrVO();
							scgImdgClssSegrVO
									.setRowImdgClssCd(scgImdgClssSegrListVOs[i]
											.getRowImdgClssCd());
							if (j == 0) {
								scgImdgClssSegrVO.setColImdgClssCd("1.1");
								scgImdgClssSegrVO
										.setImdgSegrCd(scgImdgClssSegrListVOs[i]
												.getClssCd11());
								scgImdgClssSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoList.add(scgImdgClssSegrVO);
							} else if (j == 1) {
								scgImdgClssSegrVO.setColImdgClssCd("1.2");
								scgImdgClssSegrVO
										.setImdgSegrCd(scgImdgClssSegrListVOs[i]
												.getClssCd12());
								scgImdgClssSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoList.add(scgImdgClssSegrVO);
							} else if (j == 2) {
								scgImdgClssSegrVO.setColImdgClssCd("1.3");
								scgImdgClssSegrVO
										.setImdgSegrCd(scgImdgClssSegrListVOs[i]
												.getClssCd13());
								scgImdgClssSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoList.add(scgImdgClssSegrVO);
							} else if (j == 3) {
								scgImdgClssSegrVO.setColImdgClssCd("1.4");
								scgImdgClssSegrVO
										.setImdgSegrCd(scgImdgClssSegrListVOs[i]
												.getClssCd14());
								scgImdgClssSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoList.add(scgImdgClssSegrVO);
							} else if (j == 4) {
								scgImdgClssSegrVO.setColImdgClssCd("1.5");
								scgImdgClssSegrVO
										.setImdgSegrCd(scgImdgClssSegrListVOs[i]
												.getClssCd15());
								scgImdgClssSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoList.add(scgImdgClssSegrVO);
							} else if (j == 5) {
								scgImdgClssSegrVO.setColImdgClssCd("1.6");
								scgImdgClssSegrVO
										.setImdgSegrCd(scgImdgClssSegrListVOs[i]
												.getClssCd16());
								scgImdgClssSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoList.add(scgImdgClssSegrVO);
							} else if (j == 6) {
								scgImdgClssSegrVO.setColImdgClssCd("2.1");
								scgImdgClssSegrVO
										.setImdgSegrCd(scgImdgClssSegrListVOs[i]
												.getClssCd21());
								scgImdgClssSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoList.add(scgImdgClssSegrVO);
							} else if (j == 7) {
								scgImdgClssSegrVO.setColImdgClssCd("2.2");
								scgImdgClssSegrVO
										.setImdgSegrCd(scgImdgClssSegrListVOs[i]
												.getClssCd22());
								scgImdgClssSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoList.add(scgImdgClssSegrVO);
							} else if (j == 8) {
								scgImdgClssSegrVO.setColImdgClssCd("2.3");
								scgImdgClssSegrVO
										.setImdgSegrCd(scgImdgClssSegrListVOs[i]
												.getClssCd23());
								scgImdgClssSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoList.add(scgImdgClssSegrVO);
							} else if (j == 9) {
								scgImdgClssSegrVO.setColImdgClssCd("3");
								scgImdgClssSegrVO
										.setImdgSegrCd(scgImdgClssSegrListVOs[i]
												.getClssCd3());
								scgImdgClssSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoList.add(scgImdgClssSegrVO);
							} else if (j == 10) {
								scgImdgClssSegrVO.setColImdgClssCd("4.1");
								scgImdgClssSegrVO
										.setImdgSegrCd(scgImdgClssSegrListVOs[i]
												.getClssCd41());
								scgImdgClssSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoList.add(scgImdgClssSegrVO);
							} else if (j == 11) {
								scgImdgClssSegrVO.setColImdgClssCd("4.2");
								scgImdgClssSegrVO
										.setImdgSegrCd(scgImdgClssSegrListVOs[i]
												.getClssCd42());
								scgImdgClssSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoList.add(scgImdgClssSegrVO);
							} else if (j == 12) {
								scgImdgClssSegrVO.setColImdgClssCd("4.3");
								scgImdgClssSegrVO
										.setImdgSegrCd(scgImdgClssSegrListVOs[i]
												.getClssCd43());
								scgImdgClssSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoList.add(scgImdgClssSegrVO);
							} else if (j == 13) {
								scgImdgClssSegrVO.setColImdgClssCd("5.1");
								scgImdgClssSegrVO
										.setImdgSegrCd(scgImdgClssSegrListVOs[i]
												.getClssCd51());
								scgImdgClssSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoList.add(scgImdgClssSegrVO);
							} else if (j == 14) {
								scgImdgClssSegrVO.setColImdgClssCd("5.2");
								scgImdgClssSegrVO
										.setImdgSegrCd(scgImdgClssSegrListVOs[i]
												.getClssCd52());
								scgImdgClssSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoList.add(scgImdgClssSegrVO);
							} else if (j == 15) {
								scgImdgClssSegrVO.setColImdgClssCd("6.1");
								scgImdgClssSegrVO
										.setImdgSegrCd(scgImdgClssSegrListVOs[i]
												.getClssCd61());
								scgImdgClssSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoList.add(scgImdgClssSegrVO);
							} else if (j == 16) {
								scgImdgClssSegrVO.setColImdgClssCd("6.2");
								scgImdgClssSegrVO
										.setImdgSegrCd(scgImdgClssSegrListVOs[i]
												.getClssCd62());
								scgImdgClssSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoList.add(scgImdgClssSegrVO);
							} else if (j == 17) {
								scgImdgClssSegrVO.setColImdgClssCd("7");
								scgImdgClssSegrVO
										.setImdgSegrCd(scgImdgClssSegrListVOs[i]
												.getClssCd7());
								scgImdgClssSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoList.add(scgImdgClssSegrVO);
							} else if (j == 18) {
								scgImdgClssSegrVO.setColImdgClssCd("8");
								scgImdgClssSegrVO
										.setImdgSegrCd(scgImdgClssSegrListVOs[i]
												.getClssCd8());
								scgImdgClssSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoList.add(scgImdgClssSegrVO);
							} else if (j == 19) {
								scgImdgClssSegrVO.setColImdgClssCd("9");
								scgImdgClssSegrVO
										.setImdgSegrCd(scgImdgClssSegrListVOs[i]
												.getClssCd9());
								scgImdgClssSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoList.add(scgImdgClssSegrVO);
							}
						}
					} else if (scgImdgClssSegrListVOs[i].getIbflag()
							.equals("D")) {
						for (int j = 0; j < 20; j++) {
							ScgImdgClssSegrVO scgImdgClssSegrVO = new ScgImdgClssSegrVO();
							scgImdgClssSegrVO
									.setRowImdgClssCd(scgImdgClssSegrListVOs[i]
											.getRowImdgClssCd());
							if (j == 0) {
								scgImdgClssSegrVO.setColImdgClssCd("1.1");
								scgImdgClssSegrVO.setImdgSegrCd("");
								scgImdgClssSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoList.add(scgImdgClssSegrVO);
							} else if (j == 1) {
								scgImdgClssSegrVO.setColImdgClssCd("1.2");
								scgImdgClssSegrVO.setImdgSegrCd("");
								scgImdgClssSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoList.add(scgImdgClssSegrVO);
							} else if (j == 2) {
								scgImdgClssSegrVO.setColImdgClssCd("1.3");
								scgImdgClssSegrVO.setImdgSegrCd("");
								scgImdgClssSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoList.add(scgImdgClssSegrVO);
							} else if (j == 3) {
								scgImdgClssSegrVO.setColImdgClssCd("1.4");
								scgImdgClssSegrVO.setImdgSegrCd("");
								scgImdgClssSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoList.add(scgImdgClssSegrVO);
							} else if (j == 4) {
								scgImdgClssSegrVO.setColImdgClssCd("1.5");
								scgImdgClssSegrVO.setImdgSegrCd("");
								scgImdgClssSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoList.add(scgImdgClssSegrVO);
							} else if (j == 5) {
								scgImdgClssSegrVO.setColImdgClssCd("1.6");
								scgImdgClssSegrVO.setImdgSegrCd("");
								scgImdgClssSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoList.add(scgImdgClssSegrVO);
							} else if (j == 6) {
								scgImdgClssSegrVO.setColImdgClssCd("2.1");
								scgImdgClssSegrVO.setImdgSegrCd("");
								scgImdgClssSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoList.add(scgImdgClssSegrVO);
							} else if (j == 7) {
								scgImdgClssSegrVO.setColImdgClssCd("2.2");
								scgImdgClssSegrVO.setImdgSegrCd("");
								scgImdgClssSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoList.add(scgImdgClssSegrVO);
							} else if (j == 8) {
								scgImdgClssSegrVO.setColImdgClssCd("2.3");
								scgImdgClssSegrVO.setImdgSegrCd("");
								scgImdgClssSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoList.add(scgImdgClssSegrVO);
							} else if (j == 9) {
								scgImdgClssSegrVO.setColImdgClssCd("3");
								scgImdgClssSegrVO.setImdgSegrCd("");
								scgImdgClssSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoList.add(scgImdgClssSegrVO);
							} else if (j == 10) {
								scgImdgClssSegrVO.setColImdgClssCd("4.1");
								scgImdgClssSegrVO.setImdgSegrCd("");
								scgImdgClssSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoList.add(scgImdgClssSegrVO);
							} else if (j == 11) {
								scgImdgClssSegrVO.setColImdgClssCd("4.2");
								scgImdgClssSegrVO.setImdgSegrCd("");
								scgImdgClssSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoList.add(scgImdgClssSegrVO);
							} else if (j == 12) {
								scgImdgClssSegrVO.setColImdgClssCd("4.3");
								scgImdgClssSegrVO.setImdgSegrCd("");
								scgImdgClssSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoList.add(scgImdgClssSegrVO);
							} else if (j == 13) {
								scgImdgClssSegrVO.setColImdgClssCd("5.1");
								scgImdgClssSegrVO.setImdgSegrCd("");
								scgImdgClssSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoList.add(scgImdgClssSegrVO);
							} else if (j == 14) {
								scgImdgClssSegrVO.setColImdgClssCd("5.2");
								scgImdgClssSegrVO.setImdgSegrCd("");
								scgImdgClssSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoList.add(scgImdgClssSegrVO);
							} else if (j == 15) {
								scgImdgClssSegrVO.setColImdgClssCd("6.1");
								scgImdgClssSegrVO.setImdgSegrCd("");
								scgImdgClssSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoList.add(scgImdgClssSegrVO);
							} else if (j == 16) {
								scgImdgClssSegrVO.setColImdgClssCd("6.2");
								scgImdgClssSegrVO.setImdgSegrCd("");
								scgImdgClssSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoList.add(scgImdgClssSegrVO);
							} else if (j == 17) {
								scgImdgClssSegrVO.setColImdgClssCd("7");
								scgImdgClssSegrVO.setImdgSegrCd("");
								scgImdgClssSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoList.add(scgImdgClssSegrVO);
							} else if (j == 18) {
								scgImdgClssSegrVO.setColImdgClssCd("8");
								scgImdgClssSegrVO.setImdgSegrCd("");
								scgImdgClssSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoList.add(scgImdgClssSegrVO);
							} else if (j == 19) {
								scgImdgClssSegrVO.setColImdgClssCd("9");
								scgImdgClssSegrVO.setImdgSegrCd("");
								scgImdgClssSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoList.add(scgImdgClssSegrVO);
							}
						}
					}
				}

				if (insertVoList.size() > 0) {
					dbDao.addClssSegregationS(insertVoList);
				}

				if (updateVoList.size() > 0) {
					dbDao.modifyClssSegregationS(updateVoList);
				}

				if (deleteVoList.size() > 0) {
					dbDao.removeClssSegregationS(deleteVoList);
				}
			}
			List<ScgImdgCompGrpSegrVO> insertVoCompList = new ArrayList<ScgImdgCompGrpSegrVO>();
			List<ScgImdgCompGrpSegrVO> updateVoCompList = new ArrayList<ScgImdgCompGrpSegrVO>();
			List<ScgImdgCompGrpSegrVO> deleteVoCompList = new ArrayList<ScgImdgCompGrpSegrVO>();

			if (scgImdgCompGrpSegrListVOs != null) {
				for (int i = 0; i < scgImdgCompGrpSegrListVOs.length; i++) {
					if (scgImdgCompGrpSegrListVOs[i].getIbflag().equals("I")) {
						for (int j = 0; j < 13; j++) {
							ScgImdgCompGrpSegrVO scgImdgCompGrpSegrVO = new ScgImdgCompGrpSegrVO();
							scgImdgCompGrpSegrVO
									.setRowImdgCompGrpCd(scgImdgCompGrpSegrListVOs[i]
											.getRowImdgCompGrpCd());
							if (j == 0) {
								scgImdgCompGrpSegrVO.setColImdgCompGrpCd("A");
								if (scgImdgCompGrpSegrListVOs[i].getSegrCdA()
										.length() > 1) {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdA().substring(0,
															1));
									scgImdgCompGrpSegrVO
											.setImdgSegrNtcNo(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdA().substring(1,
															2));
								} else {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdA());
								}
								scgImdgCompGrpSegrVO.setCreUsrId(account
										.getUsr_id());
								insertVoCompList.add(scgImdgCompGrpSegrVO);
							} else if (j == 1) {
								scgImdgCompGrpSegrVO.setColImdgCompGrpCd("B");
								if (scgImdgCompGrpSegrListVOs[i].getSegrCdB()
										.length() > 1) {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdB().substring(0,
															1));
									scgImdgCompGrpSegrVO
											.setImdgSegrNtcNo(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdB().substring(1,
															2));
								} else {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdB());
								}
								scgImdgCompGrpSegrVO.setCreUsrId(account
										.getUsr_id());
								insertVoCompList.add(scgImdgCompGrpSegrVO);
							} else if (j == 2) {
								scgImdgCompGrpSegrVO.setColImdgCompGrpCd("C");
								if (scgImdgCompGrpSegrListVOs[i].getSegrCdC()
										.length() > 1) {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdC().substring(0,
															1));
									scgImdgCompGrpSegrVO
											.setImdgSegrNtcNo(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdC().substring(1,
															2));
								} else {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdC());
								}
								scgImdgCompGrpSegrVO.setCreUsrId(account
										.getUsr_id());
								insertVoCompList.add(scgImdgCompGrpSegrVO);
							} else if (j == 3) {
								scgImdgCompGrpSegrVO.setColImdgCompGrpCd("D");
								if (scgImdgCompGrpSegrListVOs[i].getSegrCdD()
										.length() > 1) {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdD().substring(0,
															1));
									scgImdgCompGrpSegrVO
											.setImdgSegrNtcNo(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdD().substring(1,
															2));
								} else {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdD());
								}
								scgImdgCompGrpSegrVO.setCreUsrId(account
										.getUsr_id());
								insertVoCompList.add(scgImdgCompGrpSegrVO);
							} else if (j == 4) {
								scgImdgCompGrpSegrVO.setColImdgCompGrpCd("E");
								if (scgImdgCompGrpSegrListVOs[i].getSegrCdE()
										.length() > 1) {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdE().substring(0,
															1));
									scgImdgCompGrpSegrVO
											.setImdgSegrNtcNo(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdE().substring(1,
															2));
								} else {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdE());
								}
								scgImdgCompGrpSegrVO.setCreUsrId(account
										.getUsr_id());
								insertVoCompList.add(scgImdgCompGrpSegrVO);
							} else if (j == 5) {
								scgImdgCompGrpSegrVO.setColImdgCompGrpCd("F");
								if (scgImdgCompGrpSegrListVOs[i].getSegrCdF()
										.length() > 1) {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdF().substring(0,
															1));
									scgImdgCompGrpSegrVO
											.setImdgSegrNtcNo(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdF().substring(1,
															2));
								} else {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdF());
								}
								scgImdgCompGrpSegrVO.setCreUsrId(account
										.getUsr_id());
								insertVoCompList.add(scgImdgCompGrpSegrVO);
							} else if (j == 6) {
								scgImdgCompGrpSegrVO.setColImdgCompGrpCd("G");
								if (scgImdgCompGrpSegrListVOs[i].getSegrCdG()
										.length() > 1) {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdG().substring(0,
															1));
									scgImdgCompGrpSegrVO
											.setImdgSegrNtcNo(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdG().substring(1,
															2));
								} else {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdG());
								}
								scgImdgCompGrpSegrVO.setCreUsrId(account
										.getUsr_id());
								insertVoCompList.add(scgImdgCompGrpSegrVO);
							} else if (j == 7) {
								scgImdgCompGrpSegrVO.setColImdgCompGrpCd("H");
								if (scgImdgCompGrpSegrListVOs[i].getSegrCdH()
										.length() > 1) {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdH().substring(0,
															1));
									scgImdgCompGrpSegrVO
											.setImdgSegrNtcNo(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdH().substring(1,
															2));
								} else {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdH());
								}
								scgImdgCompGrpSegrVO.setCreUsrId(account
										.getUsr_id());
								insertVoCompList.add(scgImdgCompGrpSegrVO);
							} else if (j == 8) {
								scgImdgCompGrpSegrVO.setColImdgCompGrpCd("J");
								if (scgImdgCompGrpSegrListVOs[i].getSegrCdJ()
										.length() > 1) {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdJ().substring(0,
															1));
									scgImdgCompGrpSegrVO
											.setImdgSegrNtcNo(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdJ().substring(1,
															2));
								} else {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdJ());
								}
								scgImdgCompGrpSegrVO.setCreUsrId(account
										.getUsr_id());
								insertVoCompList.add(scgImdgCompGrpSegrVO);
							} else if (j == 9) {
								scgImdgCompGrpSegrVO.setColImdgCompGrpCd("K");
								if (scgImdgCompGrpSegrListVOs[i].getSegrCdK()
										.length() > 1) {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdK().substring(0,
															1));
									scgImdgCompGrpSegrVO
											.setImdgSegrNtcNo(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdK().substring(1,
															2));
								} else {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdK());
								}
								scgImdgCompGrpSegrVO.setCreUsrId(account
										.getUsr_id());
								insertVoCompList.add(scgImdgCompGrpSegrVO);
							} else if (j == 10) {
								scgImdgCompGrpSegrVO.setColImdgCompGrpCd("L");
								if (scgImdgCompGrpSegrListVOs[i].getSegrCdL()
										.length() > 1) {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdL().substring(0,
															1));
									scgImdgCompGrpSegrVO
											.setImdgSegrNtcNo(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdL().substring(1,
															2));
								} else {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdL());
								}
								scgImdgCompGrpSegrVO.setCreUsrId(account
										.getUsr_id());
								insertVoCompList.add(scgImdgCompGrpSegrVO);
							} else if (j == 11) {
								scgImdgCompGrpSegrVO.setColImdgCompGrpCd("N");
								if (scgImdgCompGrpSegrListVOs[i].getSegrCdN()
										.length() > 1) {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdN().substring(0,
															1));
									scgImdgCompGrpSegrVO
											.setImdgSegrNtcNo(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdN().substring(1,
															2));
								} else {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdN());
								}
								scgImdgCompGrpSegrVO.setCreUsrId(account
										.getUsr_id());
								insertVoCompList.add(scgImdgCompGrpSegrVO);
							} else if (j == 12) {
								scgImdgCompGrpSegrVO.setColImdgCompGrpCd("S");
								if (scgImdgCompGrpSegrListVOs[i].getSegrCdS()
										.length() > 1) {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdS().substring(0,
															1));
									scgImdgCompGrpSegrVO
											.setImdgSegrNtcNo(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdS().substring(1,
															2));
								} else {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdS());
								}
								scgImdgCompGrpSegrVO.setCreUsrId(account
										.getUsr_id());
								insertVoCompList.add(scgImdgCompGrpSegrVO);
							}
						}
					} else if (scgImdgCompGrpSegrListVOs[i].getIbflag().equals(
							"U")) {
						for (int j = 0; j < 13; j++) {
							ScgImdgCompGrpSegrVO scgImdgCompGrpSegrVO = new ScgImdgCompGrpSegrVO();
							scgImdgCompGrpSegrVO
									.setRowImdgCompGrpCd(scgImdgCompGrpSegrListVOs[i]
											.getRowImdgCompGrpCd());
							if (j == 0) {
								scgImdgCompGrpSegrVO.setColImdgCompGrpCd("A");
								if (scgImdgCompGrpSegrListVOs[i].getSegrCdA()
										.length() > 1) {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdA().substring(0,
															1));
									scgImdgCompGrpSegrVO
											.setImdgSegrNtcNo(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdA().substring(1,
															2));
								} else {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdA());
								}
								scgImdgCompGrpSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoCompList.add(scgImdgCompGrpSegrVO);
							} else if (j == 1) {
								scgImdgCompGrpSegrVO.setColImdgCompGrpCd("B");
								if (scgImdgCompGrpSegrListVOs[i].getSegrCdB()
										.length() > 1) {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdB().substring(0,
															1));
									scgImdgCompGrpSegrVO
											.setImdgSegrNtcNo(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdB().substring(1,
															2));
								} else {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdB());
								}
								scgImdgCompGrpSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoCompList.add(scgImdgCompGrpSegrVO);
							} else if (j == 2) {
								scgImdgCompGrpSegrVO.setColImdgCompGrpCd("C");
								if (scgImdgCompGrpSegrListVOs[i].getSegrCdC()
										.length() > 1) {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdC().substring(0,
															1));
									scgImdgCompGrpSegrVO
											.setImdgSegrNtcNo(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdC().substring(1,
															2));
								} else {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdC());
								}
								scgImdgCompGrpSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoCompList.add(scgImdgCompGrpSegrVO);
							} else if (j == 3) {
								scgImdgCompGrpSegrVO.setColImdgCompGrpCd("D");
								if (scgImdgCompGrpSegrListVOs[i].getSegrCdD()
										.length() > 1) {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdD().substring(0,
															1));
									scgImdgCompGrpSegrVO
											.setImdgSegrNtcNo(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdD().substring(1,
															2));
								} else {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdD());
								}
								scgImdgCompGrpSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoCompList.add(scgImdgCompGrpSegrVO);
							} else if (j == 4) {
								scgImdgCompGrpSegrVO.setColImdgCompGrpCd("E");
								if (scgImdgCompGrpSegrListVOs[i].getSegrCdE()
										.length() > 1) {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdE().substring(0,
															1));
									scgImdgCompGrpSegrVO
											.setImdgSegrNtcNo(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdE().substring(1,
															2));
								} else {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdE());
								}
								scgImdgCompGrpSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoCompList.add(scgImdgCompGrpSegrVO);
							} else if (j == 5) {
								scgImdgCompGrpSegrVO.setColImdgCompGrpCd("F");
								if (scgImdgCompGrpSegrListVOs[i].getSegrCdF()
										.length() > 1) {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdF().substring(0,
															1));
									scgImdgCompGrpSegrVO
											.setImdgSegrNtcNo(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdF().substring(1,
															2));
								} else {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdF());
								}
								scgImdgCompGrpSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoCompList.add(scgImdgCompGrpSegrVO);
							} else if (j == 6) {
								scgImdgCompGrpSegrVO.setColImdgCompGrpCd("G");
								if (scgImdgCompGrpSegrListVOs[i].getSegrCdG()
										.length() > 1) {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdG().substring(0,
															1));
									scgImdgCompGrpSegrVO
											.setImdgSegrNtcNo(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdG().substring(1,
															2));
								} else {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdG());
								}
								scgImdgCompGrpSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoCompList.add(scgImdgCompGrpSegrVO);
							} else if (j == 7) {
								scgImdgCompGrpSegrVO.setColImdgCompGrpCd("H");
								if (scgImdgCompGrpSegrListVOs[i].getSegrCdH()
										.length() > 1) {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdH().substring(0,
															1));
									scgImdgCompGrpSegrVO
											.setImdgSegrNtcNo(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdH().substring(1,
															2));
								} else {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdH());
								}
								scgImdgCompGrpSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoCompList.add(scgImdgCompGrpSegrVO);
							} else if (j == 8) {
								scgImdgCompGrpSegrVO.setColImdgCompGrpCd("J");
								if (scgImdgCompGrpSegrListVOs[i].getSegrCdJ()
										.length() > 1) {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdJ().substring(0,
															1));
									scgImdgCompGrpSegrVO
											.setImdgSegrNtcNo(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdJ().substring(1,
															2));
								} else {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdJ());
								}
								scgImdgCompGrpSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoCompList.add(scgImdgCompGrpSegrVO);
							} else if (j == 9) {
								scgImdgCompGrpSegrVO.setColImdgCompGrpCd("K");
								if (scgImdgCompGrpSegrListVOs[i].getSegrCdK()
										.length() > 1) {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdK().substring(0,
															1));
									scgImdgCompGrpSegrVO
											.setImdgSegrNtcNo(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdK().substring(1,
															2));
								} else {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdK());
								}
								scgImdgCompGrpSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoCompList.add(scgImdgCompGrpSegrVO);
							} else if (j == 10) {
								scgImdgCompGrpSegrVO.setColImdgCompGrpCd("L");
								if (scgImdgCompGrpSegrListVOs[i].getSegrCdL()
										.length() > 1) {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdL().substring(0,
															1));
									scgImdgCompGrpSegrVO
											.setImdgSegrNtcNo(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdL().substring(1,
															2));
								} else {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdL());
								}
								scgImdgCompGrpSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoCompList.add(scgImdgCompGrpSegrVO);
							} else if (j == 11) {
								scgImdgCompGrpSegrVO.setColImdgCompGrpCd("N");
								if (scgImdgCompGrpSegrListVOs[i].getSegrCdN()
										.length() > 1) {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdN().substring(0,
															1));
									scgImdgCompGrpSegrVO
											.setImdgSegrNtcNo(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdN().substring(1,
															2));
								} else {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdN());
								}
								scgImdgCompGrpSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoCompList.add(scgImdgCompGrpSegrVO);
							} else if (j == 12) {
								scgImdgCompGrpSegrVO.setColImdgCompGrpCd("S");
								if (scgImdgCompGrpSegrListVOs[i].getSegrCdS()
										.length() > 1) {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdS().substring(0,
															1));
									scgImdgCompGrpSegrVO
											.setImdgSegrNtcNo(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdS().substring(1,
															2));
								} else {
									scgImdgCompGrpSegrVO
											.setImdgSegrCd(scgImdgCompGrpSegrListVOs[i]
													.getSegrCdS());
								}
								scgImdgCompGrpSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoCompList.add(scgImdgCompGrpSegrVO);
							}
						}
					} else if (scgImdgCompGrpSegrListVOs[i].getIbflag().equals(
							"D")) {
						for (int j = 0; j < 13; j++) {
							ScgImdgCompGrpSegrVO scgImdgCompGrpSegrVO = new ScgImdgCompGrpSegrVO();
							scgImdgCompGrpSegrVO
									.setRowImdgCompGrpCd(scgImdgCompGrpSegrListVOs[i]
											.getRowImdgCompGrpCd());
							if (j == 0) {
								scgImdgCompGrpSegrVO.setColImdgCompGrpCd("A");
								scgImdgCompGrpSegrVO.setImdgSegrCd("");
								scgImdgCompGrpSegrVO.setImdgSegrNtcNo("");
								scgImdgCompGrpSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoCompList.add(scgImdgCompGrpSegrVO);
							} else if (j == 1) {
								scgImdgCompGrpSegrVO.setColImdgCompGrpCd("B");
								scgImdgCompGrpSegrVO.setImdgSegrCd("");
								scgImdgCompGrpSegrVO.setImdgSegrNtcNo("");
								scgImdgCompGrpSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoCompList.add(scgImdgCompGrpSegrVO);
							} else if (j == 2) {
								scgImdgCompGrpSegrVO.setColImdgCompGrpCd("C");
								scgImdgCompGrpSegrVO.setImdgSegrCd("");
								scgImdgCompGrpSegrVO.setImdgSegrNtcNo("");
								scgImdgCompGrpSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoCompList.add(scgImdgCompGrpSegrVO);
							} else if (j == 3) {
								scgImdgCompGrpSegrVO.setColImdgCompGrpCd("D");
								scgImdgCompGrpSegrVO.setImdgSegrCd("");
								scgImdgCompGrpSegrVO.setImdgSegrNtcNo("");
								scgImdgCompGrpSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoCompList.add(scgImdgCompGrpSegrVO);
							} else if (j == 4) {
								scgImdgCompGrpSegrVO.setColImdgCompGrpCd("E");
								scgImdgCompGrpSegrVO.setImdgSegrCd("");
								scgImdgCompGrpSegrVO.setImdgSegrNtcNo("");
								scgImdgCompGrpSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoCompList.add(scgImdgCompGrpSegrVO);
							} else if (j == 5) {
								scgImdgCompGrpSegrVO.setColImdgCompGrpCd("F");
								scgImdgCompGrpSegrVO.setImdgSegrCd("");
								scgImdgCompGrpSegrVO.setImdgSegrNtcNo("");
								scgImdgCompGrpSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoCompList.add(scgImdgCompGrpSegrVO);
							} else if (j == 6) {
								scgImdgCompGrpSegrVO.setColImdgCompGrpCd("G");
								scgImdgCompGrpSegrVO.setImdgSegrCd("");
								scgImdgCompGrpSegrVO.setImdgSegrNtcNo("");
								scgImdgCompGrpSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoCompList.add(scgImdgCompGrpSegrVO);
							} else if (j == 7) {
								scgImdgCompGrpSegrVO.setColImdgCompGrpCd("H");
								scgImdgCompGrpSegrVO.setImdgSegrCd("");
								scgImdgCompGrpSegrVO.setImdgSegrNtcNo("");
								scgImdgCompGrpSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoCompList.add(scgImdgCompGrpSegrVO);
							} else if (j == 8) {
								scgImdgCompGrpSegrVO.setColImdgCompGrpCd("J");
								scgImdgCompGrpSegrVO.setImdgSegrCd("");
								scgImdgCompGrpSegrVO.setImdgSegrNtcNo("");
								scgImdgCompGrpSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoCompList.add(scgImdgCompGrpSegrVO);
							} else if (j == 9) {
								scgImdgCompGrpSegrVO.setColImdgCompGrpCd("K");
								scgImdgCompGrpSegrVO.setImdgSegrCd("");
								scgImdgCompGrpSegrVO.setImdgSegrNtcNo("");
								scgImdgCompGrpSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoCompList.add(scgImdgCompGrpSegrVO);
							} else if (j == 10) {
								scgImdgCompGrpSegrVO.setColImdgCompGrpCd("L");
								scgImdgCompGrpSegrVO.setImdgSegrCd("");
								scgImdgCompGrpSegrVO.setImdgSegrNtcNo("");
								scgImdgCompGrpSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoCompList.add(scgImdgCompGrpSegrVO);
							} else if (j == 11) {
								scgImdgCompGrpSegrVO.setColImdgCompGrpCd("N");
								scgImdgCompGrpSegrVO.setImdgSegrCd("");
								scgImdgCompGrpSegrVO.setImdgSegrNtcNo("");
								scgImdgCompGrpSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoCompList.add(scgImdgCompGrpSegrVO);
							} else if (j == 12) {
								scgImdgCompGrpSegrVO.setColImdgCompGrpCd("S");
								scgImdgCompGrpSegrVO.setImdgSegrCd("");
								scgImdgCompGrpSegrVO.setImdgSegrNtcNo("");
								scgImdgCompGrpSegrVO.setUpdUsrId(account
										.getUsr_id());
								updateVoCompList.add(scgImdgCompGrpSegrVO);
							}
						}
					}
				}

				if (insertVoCompList.size() > 0) {
					dbDao.addCompSegregationS(insertVoCompList);
				}

				if (updateVoCompList.size() > 0) {
					dbDao.modifyCompSegregationS(updateVoCompList);
				}

				if (deleteVoCompList.size() > 0) {
					dbDao.removeCompSegregationS(deleteVoCompList);
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192",
					new String[] { "Segregation Table" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192",
					new String[] { "Segregation Table" }).getMessage(), ex);
		}
	}

	/**
	 * Numbers & symbols in segregation table between various Classes의 내용을 조회
	 * 합니다. <br>
	 * 
	 * @param imdgSegrTpCd
	 * @return List<ScgImdgSegrSymVO>
	 * @exception EventException
	 */
	public List<ScgImdgSegrSymVO> searchSymbolList(String imdgSegrTpCd)
			throws EventException {
		try {
			return dbDao.searchSymbolList(imdgSegrTpCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(
					new ErrorHandler(
							"COM12203",
							new String[] { "Numbers & symbols in segregation table between various Classes" })
							.getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(
					new ErrorHandler(
							"COM12203",
							new String[] { "Numbers & symbols in segregation table between various Classes" })
							.getMessage(), ex);
		}
	}

	/**
	 * Permitted mixed stowage for goods of class 1의 내용을 조회 합니다. <br>
	 * 
	 * @param imdgSegrTpCd
	 * @return List<ScgImdgSegrSymVO>
	 * @exception EventException
	 */
	public List<ScgImdgSegrSymVO> searchPermitMixedList(String imdgSegrTpCd)
			throws EventException {
		try {
			return dbDao.searchPermitMixedList(imdgSegrTpCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(
					new ErrorHandler(
							"COM12203",
							new String[] { "Permitted mixed stowage for goods of class 1" })
							.getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(
					new ErrorHandler(
							"COM12203",
							new String[] { "Permitted mixed stowage for goods of class 1" })
							.getMessage(), ex);
		}
	}

	/**
	 * [Special Provisions for Segregation (Creation)]을 [저장 Retrieve] 합니다.<br>
	 * 
	 * @param ScgImdgSpclProvisVO[] scgImdgSpclProvisVOs
	 * @param String imdgSpclProviNo
	 * @param String usrId
	 * @exception EventException
	 */
	public void manageSpecialProvisionSegregationList(
			ScgImdgSpclProvisVO[] scgImdgSpclProvisVOs, String imdgSpclProviNo,
			String usrId) throws EventException {
		try {
			List<ScgImdgSpclProvisVO> updateVoList = new ArrayList<ScgImdgSpclProvisVO>();

			for (int i = 0; i < scgImdgSpclProvisVOs.length; i++) {

				if (scgImdgSpclProvisVOs[i].getIbflag().equals("I")
						|| scgImdgSpclProvisVOs[i].getIbflag().equals("U")) {
					scgImdgSpclProvisVOs[i].setImdgTblNo(imdgSpclProviNo);
					scgImdgSpclProvisVOs[i].setUpdUsrId(usrId);
					updateVoList.add(scgImdgSpclProvisVOs[i]);
				} else if (scgImdgSpclProvisVOs[i].getIbflag().equals("D")) {
					scgImdgSpclProvisVOs[i].setImdgTblNo("");
					scgImdgSpclProvisVOs[i].setUpdUsrId(usrId);
					updateVoList.add(scgImdgSpclProvisVOs[i]);
				}
			}
			if (updateVoList.size() > 0) {
				dbDao.modifySpecialProvisionSegregation(updateVoList);
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(
					new ErrorHandler(
							"COM12192",
							new String[] { "Special Provisions for Segregation" })
							.getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(
					new ErrorHandler(
							"COM12192",
							new String[] { "Special Provisions for Segregation" })
							.getMessage(), ex);
		}
	}

	/**
	 * Segregation Simulation in a CNTR 의 Segregation Validation 을 조회 합니다. <br>
	 * 
	 * @param segregationSimulationInputVOs
	 * @return List<SegregationSimulationInputVO>
	 * @exception EventException
	 */
	public List<SegregationSimulationOutputVO> checkSegregation(
			SegregationSimulationInputVO[] segregationSimulationInputVOs)
			throws EventException {
		try {
			List<SegregationSimulationOutputVO> rsltVOs = dbDao
					.checkSegregation(segregationSimulationInputVOs);

			// 중복 제거
			String[] rmList = new String[rsltVOs.size()];
			for (int rsltCt = 0; rsltCt < rsltVOs.size(); rsltCt++) {
				for (int rmCt = rsltCt + 1; rmCt < rsltVOs.size(); rmCt++) {
					if (rsltVOs.get(rsltCt).getImdgUnNo1()
							.equals(rsltVOs.get(rmCt).getImdgUnNo2())
							&& rsltVOs
									.get(rsltCt)
									.getImdgUnNoSeq1()
									.equals(rsltVOs.get(rmCt).getImdgUnNoSeq2())
							&& rsltVOs.get(rsltCt).getImdgUnNo2()
									.equals(rsltVOs.get(rmCt).getImdgUnNo1())
							&& rsltVOs
									.get(rsltCt)
									.getImdgUnNoSeq2()
									.equals(rsltVOs.get(rmCt).getImdgUnNoSeq1())) {
						rmList[rmCt] = "Y";
					}
				}
			}

			/*
			 * 같은 쌍의 경우에도 모두 보여주기로 하여 주석처리함. for(int delCt=rmList.length-1;
			 * delCt >= 0; delCt--) { if("Y".equals(rmList[delCt]))
			 * rsltVOs.remove(delCt); }
			 */

			return rsltVOs;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(
					new ErrorHandler("COM12203",
							new String[] { "Segregation Simulation in a CNTR" })
							.getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(
					new ErrorHandler("COM12203",
							new String[] { "Segregation Simulation in a CNTR" })
							.getMessage(), ex);
		}
	}

	/**
	 * SpecialCargo - searching information by imdgPckCd and
	 * imdgPckTpCd.(VOP_SCG_0110)
	 * 
	 * @param String imdgPckCd
	 * @param String imdgPckTpCd
	 * @return ScgImdgPckCdVO
	 * @exception EventException
	 */
	public ScgImdgPckCdVO searchImdgPckDesc(String imdgPckCd, String imdgPckTpCd)
			throws EventException {
		try {
			return dbDao.searchImdgPckDesc(imdgPckCd, imdgPckTpCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),
					ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),
					ex);
		}
	}

	/**
	 * IMDG search & send msg for SCG_IMDG_UN_NO
	 * 
	 * @param UNNumberListOptionVO vo
	 * @param String flag
	 * @exception EventException
	 */
	public void sendScgImdgUnNo(UNNumberListOptionVO vo, String flag)
			throws EventException {
		try {
			List<UNNumberListOptionVO> list = dbDao.searchScgImdgUnNo(vo, flag);
			if ("D".equals(vo.getIbflag())) {
				for (UNNumberListOptionVO l : list) {
					l.setIbflag(vo.getIbflag());
				}
			}
			if (!list.isEmpty()) {
				String str = eaiDao.sendDbIMDG0010001(list);
				for (UNNumberListOptionVO l : list) {
					l.setEaiIfId(str);
					updateScgImdgUnNo(l);
				}
			}
		} catch (Exception e) {
			log.error("Exception : " + e.getMessage(), e);
			throw new EventException(e.getMessage());
		}

	}

	/**
	 * IMDG Update for SCG_IMDG_UN_NO
	 * 
	 * @param UNNumberListOptionVO vo
	 * @exception EventException
	 * @throws DAOException
	 */
	private int updateScgImdgUnNo(UNNumberListOptionVO vo)
			throws EventException, DAOException {
		return dbDao.updateScgImdgUnNo(vo);
	}

	/**
	 * IMDG search & send msg for SCG_IMDG_SUBS_RSK_LBL
	 * 
	 * @param List<ScgImdgSubsRskLblVO> lists
	 * @param String flag
	 * @exception EventException
	 */
	@Override
	public void sendScgImdgSubRskLbl(List<ScgImdgSubsRskLblVO> lists,
			String flag) throws EventException {
		try {
			// if(!lists.isEmpty()){
			for (ScgImdgSubsRskLblVO subsRsk : lists) {
				List<ScgImdgSubsRskLblVO> list = dbDao.searchScgImdgSubRskLbl(
						subsRsk, flag);
				if (!list.isEmpty()) {
					if ("D".equals(flag)) {
						for (ScgImdgSubsRskLblVO l : list) {
							l.setIbflag(flag);
						}
					}
					String str = eaiDao.sendDbIMDG0030001(list);
					for (ScgImdgSubsRskLblVO vo : list) {
						vo.setEaiIfId(str);
						updateScgImdgSubRskLbl(vo);
					}
				}

			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new EventException(e.getMessage());
		}

	}

	/**
	 * IMDG Update for SCG_IMDG_SUBS_RSK_LBL
	 * 
	 * @param ScgImdgSubsRskLblVO vo
	 * @exception EventException
	 * @throws DAOException
	 * @return int
	 */
	private int updateScgImdgSubRskLbl(ScgImdgSubsRskLblVO vo)
			throws EventException, DAOException {
		return dbDao.updateScgImdgSubRskLbl(vo);
	}

	/**
	 * IMDG search & send msg for SCG_IMDG_PCK_CD
	 * 
	 * @param List<ScgImdgPckCdVO> lists
	 * @param String flag
	 * @exception EventException
	 */
	@Override
	public void sendScgImdgPckCd(List<ScgImdgPckCdVO> lists, String flag)
			throws EventException {
		try {
			if (!lists.isEmpty()) {
				for (ScgImdgPckCdVO pck : lists) {
					List<ScgImdgPckCdVO> list = dbDao.searchScgImdgPckCd(pck);
					String str = eaiDao.sendDbIMDG0020001(list);
					for (ScgImdgPckCdVO vo : list) {
						vo.setEaiIfId(str);
						updateScgImdgPckCd(vo);
					}
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new EventException(e.getMessage());
		}
	}

	/**
	 * IMDG Update for SCG_IMDG_PCK_CD
	 * 
	 * @param ScgImdgPckCdVO vo
	 * @exception EventException
	 * @throws DAOException
	 * @return int
	 */

	private int updateScgImdgPckCd(ScgImdgPckCdVO vo) throws EventException,
			DAOException {
		return dbDao.updateScgImdgPckCd(vo);
	}

	/**
	 * IMDG search & send msg for SCG_IMDG_CLSS_CD
	 * 
	 * @param List<ScgImdgClssCdVO> lists
	 * @param String flag
	 * @exception EventException
	 */
	@Override
	public void sendScgImdgClssCd(List<ScgImdgClssCdVO> lists, String flag)
			throws EventException {
		try {
			if (!lists.isEmpty()) {
				for (ScgImdgClssCdVO clss : lists) {
					List<ScgImdgClssCdVO> list = dbDao.searchScgImdgClssCd(clss);
					String str = eaiDao.sendDbIMDG0040001(list);
					for (ScgImdgClssCdVO vo : list) {
						vo.setEaiIfId(str);
						updateScgImdgClssCd(vo);
					}
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new EventException(e.getMessage());
		}
	}

	/**
	 * IMDG Update for SCG_IMDG_CLSS_CD
	 * 
	 * @param ScgImdgClssCdVO vo
	 * @exception EventException
	 * @throws DAOException
	 */
	private int updateScgImdgClssCd(ScgImdgClssCdVO vo) throws EventException,
			DAOException {
		return dbDao.updateScgImdgClssCd(vo);
	}
	
	/**
	 * IMDG Update for SCG_IMDG_CLSS_CD
	 * 
	 * @param String result
	 * @param String ifId
	 * @exception EventException
	 * @throws DAOException
	 */
	public void sendScgPrnrAproRqstResult(String result, String ifId)
			throws EventException {
		try {
			eaiDao.sendDbIMDG005R001(result, ifId);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new EventException(e.getMessage());
		}
	}
}