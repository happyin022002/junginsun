/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RFAGuidelineMainBCImpl.java
 *@FileTitle : Guideline Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.15
 *@LastModifier : 최성민
 *@LastVersion : 1.0
 * 2009.04.15 최성민
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaguideline.rfagrouplocationguideline.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfagrouplocationguideline.integration.RFAGroupLocationGuidelineDBDAO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfagrouplocationguideline.vo.GrpLocGlineVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfagrouplocationguideline.vo.RsltPriRgGrpLocDtlVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfagrouplocationguideline.vo.RsltPriRgGrpLocExcelVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfagrouplocationguideline.vo.RsltPriRgGrpLocVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfagrouplocationguideline.vo.RsltPriRgGrpVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfaguidelinemain.vo.RsltRfaGlineCopyVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriRgGrpLocDtlVO;
import com.hanjin.syscommon.common.table.PriRgGrpLocVO;
import com.hanjin.syscommon.common.table.PriRgMnVO;

/**
 * NIS2010-RFAGuideline Business Logic Basic Command implementation<br>
 * - NIS2010-RFAGuideline에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Park Sungsoo
 * @see UI_PRI_0001EventResponse,RFAGuidelineMainBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class RFAGroupLocationGuidelineBCImpl extends BasicCommandSupport implements RFAGroupLocationGuidelineBC {

	// Database Access Object
	private transient RFAGroupLocationGuidelineDBDAO dbDao = null;

	/**
	 * RFAGuidelineMainBCImpl 객체 생성<br>
	 * RFAGuidelineMainDBDAO를 생성한다.<br>
	 */
	public RFAGroupLocationGuidelineBCImpl() {
		dbDao = new RFAGroupLocationGuidelineDBDAO();
	}

	/**
	 * LOCATION GROUP MASTER를 조회합니다.<br>
	 * 
	 * @param PriRgGrpLocVO priRgGrpLocVO
	 * @return List<RsltPriRgGrpLocVO>
	 * @exception EventException
	 */
	public List<RsltPriRgGrpLocVO> searchGroupLocationList(PriRgGrpLocVO priRgGrpLocVO) throws EventException {
		try {
			return dbDao.searchGroupLocationList(priRgGrpLocVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * LOCATION GROUP DETAIL를 조회합니다.<br>
	 * 
	 * @param PriRgGrpLocDtlVO priRgGrpLocDtlVO
	 * @return List<RsltPriRgGrpLocDtlVO>
	 * @exception EventException
	 */
	public List<RsltPriRgGrpLocDtlVO> searchGroupLocationDetailList(PriRgGrpLocDtlVO priRgGrpLocDtlVO)
			throws EventException {
		try {
			return dbDao.searchGroupLocationDetailList(priRgGrpLocDtlVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * RATE에서의 데이터존재유무를 조회합니다.<br>
	 * 
	 * @param PriRgGrpLocVO priRgGrpLocVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkGroupLocationInUse(PriRgGrpLocVO priRgGrpLocVO) throws EventException {
		try {
			return dbDao.searchGroupLocationInUse(priRgGrpLocVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * 다운로드엑셀 데이터를 조회합니다.<br>
	 * 
	 * @param PriRgGrpLocVO priRgGrpLocVO
	 * @return List<RsltPriRgGrpLocExcelVO>
	 * @exception EventException
	 */
	public List<RsltPriRgGrpLocExcelVO> searchGroupLocationListExcel(PriRgGrpLocVO priRgGrpLocVO) throws EventException {
		try {
			return dbDao.searchGroupLocationListExcel(priRgGrpLocVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * LOCATION GROUP을 저장합니다.<br>
	 * 
	 * @param GrpLocGlineVO grpLocGlineVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGroupLocationGuideline(GrpLocGlineVO grpLocGlineVO, SignOnUserAccount account)
			throws EventException {
		try {
			PriRgGrpLocVO[] vo = grpLocGlineVO.getPriRgGrpLocVOS();
			PriRgGrpLocDtlVO[] dtlvo = grpLocGlineVO.getPriRgGrpLocDtlVOS();

			List<PriRgGrpLocVO> insertVoList = new ArrayList<PriRgGrpLocVO>();
			List<PriRgGrpLocVO> updateVoList = new ArrayList<PriRgGrpLocVO>();
			List<PriRgGrpLocVO> deleteVoList = new ArrayList<PriRgGrpLocVO>();
			List<PriRgGrpLocDtlVO> insertDtlVoList = new ArrayList<PriRgGrpLocDtlVO>();
			List<PriRgGrpLocDtlVO> updateDtlVoList = new ArrayList<PriRgGrpLocDtlVO>();
			List<PriRgGrpLocDtlVO> deleteDtlVoList = new ArrayList<PriRgGrpLocDtlVO>();

			for (int i = 0; vo != null && i < vo.length; i++) {
				if (vo[i].getIbflag().equals("I")) {
					vo[i].setCreUsrId(account.getUsr_id());
					vo[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(vo[i]);
				} else if (vo[i].getIbflag().equals("U")) {
					vo[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(vo[i]);
				} else if (vo[i].getIbflag().equals("D")) {
					deleteVoList.add(vo[i]);
				}
			}
			for (int i = 0; dtlvo != null && i < dtlvo.length; i++) {
				if (dtlvo[i].getIbflag().equals("I")) {
					dtlvo[i].setCreUsrId(account.getUsr_id());
					dtlvo[i].setUpdUsrId(account.getUsr_id());
					insertDtlVoList.add(dtlvo[i]);
				} else if (dtlvo[i].getIbflag().equals("U")) {
					dtlvo[i].setUpdUsrId(account.getUsr_id());
					updateDtlVoList.add(dtlvo[i]);
				} else if (dtlvo[i].getIbflag().equals("D")) {
					deleteDtlVoList.add(dtlvo[i]);
				}
			}

			if (insertVoList.size() > 0) {
				dbDao.addGroupLocation(insertVoList);
			}
			if (insertDtlVoList.size() > 0) {
				dbDao.addGroupLocationDetail(insertDtlVoList);
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyGroupLocation(updateVoList);
			}
			if (updateDtlVoList.size() > 0) {
				dbDao.modifyGroupLocationDetail(updateDtlVoList);
			}

			if (deleteDtlVoList.size() > 0) {
				dbDao.removeGroupLocationDetail(deleteDtlVoList);
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeMasterGroupLocationDetail(deleteVoList);
				dbDao.removeGroupLocation(deleteVoList);
			}

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		
	}

	/**
	 * Guideline Main에서 Guideline을 삭제한다.<br>
	 * 
	 * @param PriRgMnVO priRgMnVO
	 * @exception EventException
	 */
	public void removeGuidelineMain(PriRgMnVO priRgMnVO) throws EventException {
		try {
			dbDao.removeGuidelineMainGroupLocationDetail(priRgMnVO);
			dbDao.removeGuidelineMainGroupLocation(priRgMnVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * RFA Guideline Group Location 정보를 Copy 합니다.<br>
	 * 
	 * @param RsltRfaGlineCopyVO rsltRfaGlineCopyVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyGuidelineMain(RsltRfaGlineCopyVO rsltRfaGlineCopyVO, SignOnUserAccount account) throws EventException {
		try {
		    rsltRfaGlineCopyVO.setCreUsrId(account.getUsr_id());
		    rsltRfaGlineCopyVO.setUpdUsrId(account.getUsr_id());
			
            dbDao.addGlineCopyGroupLocation(rsltRfaGlineCopyVO);
            dbDao.addGlineCopyGroupLocationDetail(rsltRfaGlineCopyVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * ORI/DEST TYPE의 선택유무를 체크한다.<br>
	 * ARR[0]: LOCATION CODE LIST, ARR[1]: ORI/DST TYPE NAME 으로 세팅됨.<br>
	 * 
	 * @param RsltPriRgGrpLocDtlVO[] rsltPriRgGrpLocDtlVOs
	 * @return String[]
	 * @exception EventException
	 */
	public String[] checkGroupLocationCode(RsltPriRgGrpLocDtlVO[] rsltPriRgGrpLocDtlVOs) throws EventException {
		try {
			RsltCdListVO rsltCdListVO = new RsltCdListVO();
			List<RsltCdListVO> cdList = new ArrayList<RsltCdListVO>();
			String strLocCd = "";
			String[] arrLocCd = new String[2];
			
			for (int i = 0; rsltPriRgGrpLocDtlVOs != null && i < rsltPriRgGrpLocDtlVOs.length; i++) {
				if ( !rsltPriRgGrpLocDtlVOs[i].getIbflag().equals("D")){
					rsltCdListVO.setCd(rsltPriRgGrpLocDtlVOs[i].getLocCd());
					rsltCdListVO.setEtc1(rsltPriRgGrpLocDtlVOs[0].getOrgDestTpCd());
					rsltCdListVO.setSvcScpCd(rsltPriRgGrpLocDtlVOs[i].getSvcScpCd());
					
					cdList = dbDao.searchServiceScopeLocationCodeList(rsltCdListVO);
					
					if(cdList != null && cdList.size()>0) {
						continue;
					} else {
						strLocCd = strLocCd + rsltPriRgGrpLocDtlVOs[i].getLocCd()+",";
					}
				}
			}
									
			if(!strLocCd.equals("") ) {
				arrLocCd[0] = strLocCd.substring(0, strLocCd.lastIndexOf(","));
				arrLocCd[1] = rsltPriRgGrpLocDtlVOs[0].getOrgDestTpNm();
				
				//throw new EventException(new ErrorHandler("PRI01099",arrLocCd).getMessage());								
			}	
			
			return arrLocCd;
		//} catch(EventException ex) {
		//	throw ex;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
	}
	
	
	/**
	 * 엑셀데이터를 생성합니다.
	 * 
	 * @param GrpLocGlineVO grpLocGlineVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void uploadGroupLocationGuideline(GrpLocGlineVO grpLocGlineVO, SignOnUserAccount account)
			throws EventException {
		try {
			PriRgGrpLocVO[] vo = grpLocGlineVO.getPriRgGrpLocVOS();
			PriRgGrpLocDtlVO[] dtlvo = grpLocGlineVO.getPriRgGrpLocDtlVOS();

			List<PriRgGrpLocVO> insertVoList = new ArrayList<PriRgGrpLocVO>();
			List<PriRgGrpLocDtlVO> insertDtlVoList = new ArrayList<PriRgGrpLocDtlVO>();

			for (int i = 0; vo != null && i < vo.length; i++) {
				if (vo[i].getIbflag().equals("I")) {
					vo[i].setCreUsrId(account.getUsr_id());
					vo[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(vo[i]);
				}
			}
			for (int i = 0; dtlvo != null && i < dtlvo.length; i++) {
				if (dtlvo[i].getIbflag().equals("I")) {
					dtlvo[i].setCreUsrId(account.getUsr_id());
					dtlvo[i].setUpdUsrId(account.getUsr_id());
					insertDtlVoList.add(dtlvo[i]);
				}
			}

			if (insertVoList.size() > 0) {
				dbDao.addGroupLocation(insertVoList);
			}
			if (insertDtlVoList.size() > 0) {
				dbDao.addGroupLocationDetail(insertDtlVoList);
			}

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		
	}
	
	/**
	 * 엑셀파일을 체크합니다.<br>
	 * 
	 * @param RsltPriRgGrpVO[] rsltPriRgGrpVOs
	 * @return List<RsltPriRgGrpVO>
	 * @exception EventException
	 */
	public List<RsltPriRgGrpVO> searchLocationGroupCodeCheckResult(RsltPriRgGrpVO[] rsltPriRgGrpVOs) throws EventException{
		try {
			List<RsltPriRgGrpVO> checkVoList = new ArrayList<RsltPriRgGrpVO>();
			List<RsltCdListVO> cdList = new ArrayList<RsltCdListVO>();
			RsltCdListVO vo = new RsltCdListVO();
			
			for ( int i=0; i<rsltPriRgGrpVOs.length; i++ ) {
				
				//Location Code
				vo.setCd(rsltPriRgGrpVOs[i].getLocCd());
				vo.setEtc1(rsltPriRgGrpVOs[i].getOrgDestTpCd());
				vo.setSvcScpCd(rsltPriRgGrpVOs[i].getSvcScpCd());
				cdList = dbDao.searchExcelCodeList(vo);
				if(cdList != null && cdList.size()>0) {
				    rsltPriRgGrpVOs[i].setLocCd("1");
				} else {
				    rsltPriRgGrpVOs[i].setLocCd("0");
				}
								
				checkVoList.add(rsltPriRgGrpVOs[i]);
			} 
			
			return checkVoList;
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	
	
	
}