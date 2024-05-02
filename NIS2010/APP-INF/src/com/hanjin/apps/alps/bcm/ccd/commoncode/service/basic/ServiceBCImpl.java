/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : seviceBCImpl.java
 *@FileTitle : activity
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 1.0

=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.service.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.bcm.ccd.commoncode.service.integration.ServiceDBDAO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.ActivityVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.MovementStatusVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.RLaneDtlIbisIfVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.RLaneDtlVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.RLaneGroupVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.RLaneIbisIfVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.RLaneVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.SLaneDirVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.SLaneGroupVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.SLaneIfVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.SLaneVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.ScopeGroupVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.ScopeLaneVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.ScopeLimitVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.ScopeVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.SubTradeVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.TradeIbisIfVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.TradeVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * commoncode Business Logic Command Interface<br>
 * An interface to the business logic for commoncode<br>
 * 
 * @author 
 * @see 
 * @since J2EE 1.4 
 */
public class ServiceBCImpl extends BasicCommandSupport implements ServiceBC {

	// Database Access Object
	private transient ServiceDBDAO dbDao = null;

	/**
	 * seviceBCImpl object creation<br>
	 * Generate seviceDBDAO.<br>
	 */
	public ServiceBCImpl() {
		dbDao = new ServiceDBDAO();
	}

	/**
	 * To act code to query detailed information.<br>
	 * 
	 * @param String actCd
	 * @return ActivityVO
	 * @exception EventException
	 */
	public ActivityVO searchActCode(String actCd) throws EventException {
		try {
			return dbDao.searchActCode(actCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 * Act code on the new generation, and act code to modify the details of information.<br>
	 * 
	 * @param ActivityVO actvo
	 * @exception EventException
	 */
	public void manageActCode(ActivityVO actvo) throws EventException {
		try {
			if (actvo.getIbflag().equals("I")) {
				dbDao.addActCode(actvo);
			} else if (actvo.getIbflag().equals("U")) {
				dbDao.modifyActCode(actvo);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 * To mvmt sts code to query detailed information.br>
	 * 
	 * @param String mvmtStsCd
	 * @return MovementStatusVO
	 * @exception EventException
	 */
	public MovementStatusVO searchMvmtStsCode(String mvmtStsCd) throws EventException {
		try {
			return dbDao.searchMvmtStsCode(mvmtStsCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 * Mvmt sts code on the new generation, and mvmt sts code to modify the details of information.<br>
	 * 
	 * @param MovementStatusVO mvmtstsvo
	 * @exception EventException
	 */
	public void manageMvmtStsCode(MovementStatusVO mvmtstsvo, SignOnUserAccount account) throws EventException {
		try {
			mvmtstsvo.setUsrId(account.getUsr_id());
			if (mvmtstsvo.getIbflag().equals("I")) {
				dbDao.addMvmtStsCode(mvmtstsvo);
			} else if (mvmtstsvo.getIbflag().equals("U")) {
				dbDao.modifyMvmtStsCode(mvmtstsvo);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 * To rlane code to query detailed information.<br>
	 * 
	 * @param String rlaneCd
	 * @return RLaneGroupVO
	 * @exception EventException
	 */
	public RLaneGroupVO searchRlaneCode(String rlaneCd) throws EventException {
		try {
			RLaneGroupVO rLaneGroupVO = new RLaneGroupVO();
			RLaneVO rLaneVO = new RLaneVO();
			List<RLaneDtlVO> rLaneDtlVO = new ArrayList<RLaneDtlVO>();

			rLaneVO = dbDao.searchRlaneCode(rlaneCd);
			rLaneDtlVO = dbDao.searchRlaneDtlCode(rlaneCd);

			rLaneGroupVO.setRLaneVO(rLaneVO);
			rLaneGroupVO.setRLaneDtlVOS(rLaneDtlVO);

			return rLaneGroupVO;

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}

	}
	
	/**
	 * To rlane code to query detailed information.<br>
	 * 
	 * @param String rqstNo
	 * @return RLaneGroupVO
	 * @exception EventException
	 */
	public RLaneGroupVO searchRlaneCodeRqst(String rqstNo) throws EventException {
		try {
			RLaneGroupVO rLaneGroupVO = new RLaneGroupVO();
			RLaneVO rLaneVO = new RLaneVO();
			List<RLaneDtlVO> rLaneDtlVO = new ArrayList<RLaneDtlVO>();

			rLaneVO = dbDao.searchRlaneCodeRqst(rqstNo);
			rLaneDtlVO = dbDao.searchRlaneDtlCodeRqst(rqstNo);
			
			rLaneGroupVO.setRLaneVO(rLaneVO);
			rLaneGroupVO.setRLaneDtlVOS(rLaneDtlVO);

			return rLaneGroupVO;

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 * Rlane code on the new generation, and rlane code to modify the details of information.<br>
	 * 
	 * @param RLaneGroupVO rlaneGroupvo
	 * @exception EventException
	 */
	public void manageRlaneCode(RLaneGroupVO rlaneGroupvo) throws EventException {
		try {
			RLaneVO rlanevo = rlaneGroupvo.getRLaneVO();
			RLaneDtlVO[] rlanevos = rlaneGroupvo.getRLaneDtlVOs();
			List<RLaneDtlVO> arrRlanevos = rlaneGroupvo.getRLaneDtlVOS();
			
			List<RLaneDtlVO> createDtlVoList = new ArrayList<RLaneDtlVO>();
			List<RLaneDtlVO> updateDtlVoList = new ArrayList<RLaneDtlVO>();
			List<RLaneDtlVO> deleteDtlVoList = new ArrayList<RLaneDtlVO>();

			if ("U".equals(rlanevo.getAddFlg())) {
				dbDao.modifyeRlaneCode(rlanevo);
			} else if ("I".equals(rlanevo.getAddFlg())) {
				dbDao.addeRlaneCode(rlanevo);
			}
			if (rlanevos != null) {
				for (int i = 0; i < rlanevos.length; i++) {
					if ("U".equals(rlanevos[i].getIbflag())) {
						updateDtlVoList.add(rlanevos[i]);
					} else if ("I".equals(rlanevos[i].getIbflag())) {
						createDtlVoList.add(rlanevos[i]);
					} else if ("D".equals(rlanevos[i].getIbflag())) {
						deleteDtlVoList.add(rlanevos[i]);
					}
				}
			}
			if (arrRlanevos != null) {
				if(arrRlanevos.size() > 0){
					if(!"".equals(arrRlanevos.get(0).getVslSlanDirCd())){
						dbDao.addeRlaneDtlCode(arrRlanevos);
					}
				}
			}
			
			if (createDtlVoList.size() > 0) {
				dbDao.addeRlaneDtlCode(createDtlVoList);
			}
			if (updateDtlVoList.size() > 0) {
				dbDao.modifyRlaneDtlCode(updateDtlVoList);
			}
			if (deleteDtlVoList.size() > 0) {
				dbDao.removeRlaneDtlCode(deleteDtlVoList);
			}
			
			
			//Min 2018.05.11 IBIS 테이블없는것으로 보임일단 주석처리
			//manageRlaneInfoIbisIf(rlaneGroupvo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Service Lane Info Ibis IF 
	 * 
	 * @param RLaneGroupVO rlaneGroupvo
	 * @exception EventException
	 */
	public void manageRlaneInfoIbisIf(RLaneGroupVO rlaneGroupvo) throws EventException{
		try{
			RLaneIbisIfVO rLaneIfVo = new RLaneIbisIfVO();
			List<RLaneDtlIbisIfVO> rLaneDtlIfVOs = new ArrayList<RLaneDtlIbisIfVO>();
			RLaneVO rlanevo = rlaneGroupvo.getRLaneVO();
			RLaneDtlVO[] rlanevos = rlaneGroupvo.getRLaneDtlVOs();
			
			rLaneIfVo.setRlaneCd(rlanevo.getRlaneCd());
			rLaneIfVo.setRlaneNm(rlanevo.getRlaneNm());
			rLaneIfVo.setVslTpCd(rlanevo.getVslTpCd());
			rLaneIfVo.setRepTrdCd(rlanevo.getRepTrdCd());
			rLaneIfVo.setVslSlanCd(rlanevo.getVslSlanCd());
			rLaneIfVo.setModiRlaneCd(rlanevo.getModiRlaneCd());
			rLaneIfVo.setUserId(rlanevo.getUserId());
			rLaneIfVo.setDeltFlg(rlanevo.getDeltFlg());
			
			if(rlanevo.getAddFlg().equals("I")){
				rLaneIfVo.setIfMnplCd("I");
			}else if(rlanevo.getAddFlg().equals("U")){
				if(rlanevo.getDeltFlg().equals("Y")){
					rLaneIfVo.setIfMnplCd("D");
				}else {
					rLaneIfVo.setIfMnplCd("U");
				}
			}
			
			dbDao.addRlaneCodeIbisIf(rLaneIfVo);
			
			if(rlanevos != null){
				RLaneDtlIbisIfVO rDtlIfVo = new RLaneDtlIbisIfVO();
				for (int i = 0; i < rlanevos.length; i++) {
					rDtlIfVo.setRlaneCd(rlanevos[i].getRlaneCd());
					rDtlIfVo.setVslSlanDirCd(rlanevos[i].getVslSlanDirCd());
					rDtlIfVo.setIocCd(rlanevos[i].getIocCd());
					rDtlIfVo.setFmContiCd(rlanevos[i].getFmContiCd());
					rDtlIfVo.setToContiCd(rlanevos[i].getToContiCd());
					rDtlIfVo.setTrdCd(rlanevos[i].getTrdCd());
					rDtlIfVo.setSubTrdCd(rlanevos[i].getSubTrdCd());
					rDtlIfVo.setUserId(rlanevos[i].getUserId());
					rDtlIfVo.setDeltFlg(rlanevos[i].getDeltFlg());
					rDtlIfVo.setDmntLegFlg(rlanevos[i].getDmntLegFlg());
					rDtlIfVo.setIfMnplCd(rlanevos[i].getIbflag());
					rDtlIfVo.setDeltFlg(rlanevos[i].getDeltFlg());
					
					rLaneDtlIfVOs.add(rDtlIfVo);
				}
				dbDao.addRlaneDtlIbisIf(rLaneDtlIfVOs);
			}
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	/**
	 * Rlane code on the new generation, and rlane code to modify the details of information.<br>
	 * 
	 * @param RLaneGroupVO rlaneGroupvo
	 * @param String rqstNo
	 * @exception EventException
	 */
	public void manageRlaneCodeRqst(RLaneGroupVO rlaneGroupvo, String rqstNo) throws EventException {
		try {
			RLaneVO rlanevo = rlaneGroupvo.getRLaneVO();
			RLaneDtlVO[] rlanevos = rlaneGroupvo.getRLaneDtlVOs();

			List<RLaneDtlVO> createDtlVoList = new ArrayList<RLaneDtlVO>();
			List<RLaneDtlVO> updateDtlVoList = new ArrayList<RLaneDtlVO>();
			List<RLaneDtlVO> deleteDtlVoList = new ArrayList<RLaneDtlVO>();
			
			rlanevo.setRqstNo(rqstNo);
			
			if ("U".equals(rlanevo.getAddFlg())) {
				dbDao.modifyeRlaneCodeRqst(rlanevo);
			} else if ("I".equals(rlanevo.getAddFlg())) {
				dbDao.addeRlaneCodeRqst(rlanevo);
			}
			if (rlanevos != null) {
				for (int i = 0; i < rlanevos.length; i++) {
					rlanevos[i].setRqstNo(rqstNo);
					if ("U".equals(rlanevos[i].getIbflag())) {
						updateDtlVoList.add(rlanevos[i]);
					} else if ("I".equals(rlanevos[i].getIbflag())) {
						createDtlVoList.add(rlanevos[i]);
					} else if ("D".equals(rlanevos[i].getIbflag())) {
						deleteDtlVoList.add(rlanevos[i]);
					}
				}
			}

			if (createDtlVoList.size() > 0) {
				dbDao.addeRlaneDtlCodeRqst(createDtlVoList);
			}
			if (updateDtlVoList.size() > 0) {
				dbDao.modifyRlaneDtlCodeRqst(updateDtlVoList);
			}
			if (deleteDtlVoList.size() > 0) {
				dbDao.removeRlaneDtlCodeRqst(deleteDtlVoList);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * To slane code to query detailed information.<br>
	 * 
	 * @param String slaneCd
	 * @return SLaneGroupVO
	 * @exception EventException
	 */
	public SLaneGroupVO searchSlaneCode(String slaneCd) throws EventException {
		try {
			SLaneGroupVO sLaneGroupvo = new SLaneGroupVO();
			SLaneVO sLanevo = new SLaneVO();
			List<SLaneDirVO> sLaneDirvo = new ArrayList<SLaneDirVO>();

			sLanevo = dbDao.searchSlaneCode(slaneCd);
			sLaneDirvo = dbDao.searchSlaneDirCode(slaneCd);

			sLaneGroupvo.setSLaneVO(sLanevo);
			sLaneGroupvo.setSLaneDirVOS(sLaneDirvo);

			return sLaneGroupvo;

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}

	}
	
	/**
	 * To slane code to query detailed information.<br>
	 * 
	 * @param String rqstNo
	 * @return SLaneGroupVO
	 * @exception EventException
	 */
	public SLaneGroupVO searchSlaneRqst(String rqstNo) throws EventException {
		try {
			SLaneGroupVO sLaneGroupvo = new SLaneGroupVO();
			SLaneVO sLanevo = new SLaneVO();
			List<SLaneDirVO> sLaneDirvo = new ArrayList<SLaneDirVO>();

			sLanevo = dbDao.searchSlaneRqst(rqstNo);
			sLaneDirvo = dbDao.searchSlaneDirRqst(rqstNo);

			sLaneGroupvo.setSLaneVO(sLanevo);
			sLaneGroupvo.setSLaneDirVOS(sLaneDirvo);

			return sLaneGroupvo;

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 * Slane code on the new generation, and slane code to modify the details of information.<br>
	 * 
	 * @param SLaneGroupVO sLaneGroupvo
	 * @exception EventException
	 */
	public void manageSlaneCode(SLaneGroupVO sLaneGroupvo) throws EventException {
		try {
			SLaneVO slanevo = sLaneGroupvo.getSLaneVO();
			SLaneDirVO[] slanevos = sLaneGroupvo.getSLaneDirVOs();
			
			List<SLaneDirVO> sLaneDirvo = sLaneGroupvo.getSLaneDirVOS();
			
			List<SLaneDirVO> createDtlVoList = new ArrayList<SLaneDirVO>();
			List<SLaneDirVO> updateDtlVoList = new ArrayList<SLaneDirVO>();
			List<SLaneDirVO> deleteDtlVoList = new ArrayList<SLaneDirVO>();

			if ("U".equals(slanevo.getAddFlg())) {
				dbDao.modifyeSlaneCode(slanevo);
			} else if ("I".equals(slanevo.getAddFlg())) {
				dbDao.addeSlaneCode(slanevo);
			}
			if (slanevos != null) {
				for (int i = 0; i < slanevos.length; i++) {
					if ("U".equals(slanevos[i].getIbflag())) {
						updateDtlVoList.add(slanevos[i]);
					} else if ("I".equals(slanevos[i].getIbflag())) {
						createDtlVoList.add(slanevos[i]);
					} else if ("D".equals(slanevos[i].getIbflag())) {
						deleteDtlVoList.add(slanevos[i]);
					}
				}
			}
			
			if (sLaneDirvo != null) {
				if (sLaneDirvo.size() > 0) {
					if(!"".equals(sLaneDirvo.get(0).getVslSlanDirCd())){
						dbDao.addeSlaneDirCode(sLaneDirvo);
					}
				}
			}

			if (createDtlVoList.size() > 0) {
				dbDao.addeSlaneDirCode(createDtlVoList);
			}
			if (updateDtlVoList.size() > 0) {
				dbDao.modifySlaneDirCode(updateDtlVoList);
			}
			if (deleteDtlVoList.size() > 0) {
				dbDao.removeSlaneDirCode(deleteDtlVoList);
			}

			//EAI I/F Min 임시주석처리 일단...
			//manageSlaneInfoIf(slanevo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Slane code on the new generation, and slane code to modify the details of information.<br>
	 * 
	 * @param SLaneGroupVO sLaneGroupvo
	 * @param String rqstNo
	 * @exception EventException
	 */
	public void manageSlaneRqst(SLaneGroupVO sLaneGroupvo, String rqstNo) throws EventException {
		try {
			SLaneVO slanevo = sLaneGroupvo.getSLaneVO();
			SLaneDirVO[] slanevos = sLaneGroupvo.getSLaneDirVOs();

			List<SLaneDirVO> createDtlVoList = new ArrayList<SLaneDirVO>();
			List<SLaneDirVO> updateDtlVoList = new ArrayList<SLaneDirVO>();
			List<SLaneDirVO> deleteDtlVoList = new ArrayList<SLaneDirVO>();
			
			slanevo.setRqstNo(rqstNo);
			if ("U".equals(slanevo.getAddFlg())) {
				dbDao.modifyeSlaneRqst(slanevo);
			} else if ("I".equals(slanevo.getAddFlg())) {
				dbDao.addeSlaneRqst(slanevo);
			}
			if (slanevos != null) {
				for (int i = 0; i < slanevos.length; i++) {
					slanevos[i].setRqstNo(rqstNo);
					if ("U".equals(slanevos[i].getIbflag())) {
						updateDtlVoList.add(slanevos[i]);
					} else if ("I".equals(slanevos[i].getIbflag())) {
						createDtlVoList.add(slanevos[i]);
					} else if ("D".equals(slanevos[i].getIbflag())) {
						deleteDtlVoList.add(slanevos[i]);
					}
				}
			}

			if (createDtlVoList.size() > 0) {
				dbDao.addeSlaneDirRqst(createDtlVoList);
			}
			if (updateDtlVoList.size() > 0) {
				dbDao.modifySlaneDirRqst(updateDtlVoList);
			}
			if (deleteDtlVoList.size() > 0) {
				dbDao.removeSlaneDirRqst(deleteDtlVoList);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * To scp code to query detailed information.<br>
	 * 
	 * @param String scpCd
	 * @return ScopeGroupVO
	 * @exception EventException
	 */
	public ScopeGroupVO searchScpCode(String scpCd) throws EventException {
		try {
			ScopeGroupVO scpGroupVO = new ScopeGroupVO();
			ScopeVO scpvo = new ScopeVO();
			List<ScopeLaneVO> scpLaneVOs = new ArrayList<ScopeLaneVO>();
			List<ScopeLimitVO> scpLimitVOs = new ArrayList<ScopeLimitVO>();

			scpvo = dbDao.searchScpCode(scpCd);
			scpLaneVOs = dbDao.searchScpLaneCode(scpCd);
			scpLimitVOs = dbDao.searchScpLimitCode(scpCd);

			scpGroupVO.setScopeVO(scpvo);
			scpGroupVO.setScopeLaneVOS(scpLaneVOs);
			scpGroupVO.setScopeLimitVOS(scpLimitVOs);

			return scpGroupVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}

	}
	
	/**
	 * To scp code to query detailed information.<br>
	 * 
	 * @param String rqstNo
	 * @return ScopeGroupVO
	 * @exception EventException
	 */
	public ScopeGroupVO searchScpRqst(String rqstNo) throws EventException {
		try {
			ScopeGroupVO scpGroupVO = new ScopeGroupVO();
			ScopeVO scpvo = new ScopeVO();
			List<ScopeLaneVO> scpLaneVOs = new ArrayList<ScopeLaneVO>();
			List<ScopeLimitVO> scpLimitVOs = new ArrayList<ScopeLimitVO>();

			scpvo = dbDao.searchScpRqst(rqstNo);
			scpLaneVOs = dbDao.searchScpLaneRqst(rqstNo);
			scpLimitVOs = dbDao.searchScpLimitRqst(rqstNo);

			scpGroupVO.setScopeVO(scpvo);
			scpGroupVO.setScopeLaneVOS(scpLaneVOs);
			scpGroupVO.setScopeLimitVOS(scpLimitVOs);

			return scpGroupVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 * Scp code on the new generation, and scp code to modify the details of information.<br>
	 * 
	 * @param ScopeGroupVO scpGroupVO
	 * @exception EventException
	 */
	public void manageScpCode(ScopeGroupVO scpGroupVO) throws EventException {
		try {
			ScopeVO scpVO = scpGroupVO.getScopeVO();
			ScopeLaneVO[] scpLaneVOs = scpGroupVO.getScopeLaneVOs();
			ScopeLimitVO[] scpLimintVOs = scpGroupVO.getScopeLimitVOs();

			List<ScopeLaneVO> createLaneVoList = new ArrayList<ScopeLaneVO>();
			List<ScopeLaneVO> updateLaneVoList = new ArrayList<ScopeLaneVO>();
			List<ScopeLaneVO> deleteLaneVoList = new ArrayList<ScopeLaneVO>();

			List<ScopeLimitVO> createLimitVoList = new ArrayList<ScopeLimitVO>();
			List<ScopeLimitVO> updateLimitVoList = new ArrayList<ScopeLimitVO>();
			List<ScopeLimitVO> deleteLimitVoList = new ArrayList<ScopeLimitVO>();

			if ("U".equals(scpVO.getIbflag())) {
				dbDao.modifyeScpCode(scpVO);
			} else if ("I".equals(scpVO.getIbflag())) {
				dbDao.addeScpCode(scpVO);
			}
			if (scpLaneVOs != null) {
				for (int i = 0; i < scpLaneVOs.length; i++) {
					if ("U".equals(scpLaneVOs[i].getIbflag())) {
						updateLaneVoList.add(scpLaneVOs[i]);
					} else if ("I".equals(scpLaneVOs[i].getIbflag())) {
						createLaneVoList.add(scpLaneVOs[i]);
					} else if ("D".equals(scpLaneVOs[i].getIbflag())) {
						deleteLaneVoList.add(scpLaneVOs[i]);
					}
				}
			}
			if (scpLimintVOs != null) {
				for (int i = 0; i < scpLimintVOs.length; i++) {
					if ("U".equals(scpLimintVOs[i].getIbflag())) {
						updateLimitVoList.add(scpLimintVOs[i]);
					} else if ("I".equals(scpLimintVOs[i].getIbflag())) {
						createLimitVoList.add(scpLimintVOs[i]);
					} else if ("D".equals(scpLimintVOs[i].getIbflag())) {
						deleteLimitVoList.add(scpLimintVOs[i]);
					}
				}
			}

			if (createLaneVoList.size() > 0) {
				dbDao.addeScpLaneCode(createLaneVoList);
			}
			if (updateLaneVoList.size() > 0) {
				dbDao.modifyScpLaneCode(updateLaneVoList);
			}
			if (deleteLaneVoList.size() > 0) {
				dbDao.removeScpLaneCode(deleteLaneVoList);
			}
			if (createLimitVoList.size() > 0) {
				dbDao.addeScpLimitCode(createLimitVoList);
			}
			if (updateLimitVoList.size() > 0) {
				dbDao.modifyScpLimitCode(updateLimitVoList);
			}
			if (deleteLimitVoList.size() > 0) {
				dbDao.removeScpLimitCode(deleteLimitVoList);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Scp code on the new generation, and scp code to modify the details of information.<br>
	 * 
	 * @param ScopeGroupVO scpGroupVO
	 * @param String rqstNo
	 * @exception EventException
	 */
	public void manageScpRqst(ScopeGroupVO scpGroupVO, String rqstNo) throws EventException {
		try {
			ScopeVO scpVO = scpGroupVO.getScopeVO();
			ScopeLaneVO[] scpLaneVOs = scpGroupVO.getScopeLaneVOs();
			ScopeLimitVO[] scpLimintVOs = scpGroupVO.getScopeLimitVOs();

			List<ScopeLaneVO> createLaneVoList = new ArrayList<ScopeLaneVO>();
			List<ScopeLaneVO> updateLaneVoList = new ArrayList<ScopeLaneVO>();
			List<ScopeLaneVO> deleteLaneVoList = new ArrayList<ScopeLaneVO>();

			List<ScopeLimitVO> createLimitVoList = new ArrayList<ScopeLimitVO>();
			List<ScopeLimitVO> updateLimitVoList = new ArrayList<ScopeLimitVO>();
			List<ScopeLimitVO> deleteLimitVoList = new ArrayList<ScopeLimitVO>();
			
			scpVO.setRqstNo(rqstNo);
			
			if ("U".equals(scpVO.getIbflag())) {
				dbDao.modifyeScpRqst(scpVO);
			} else if ("I".equals(scpVO.getIbflag())) {
				dbDao.addeScpRqst(scpVO);
			}
			if (scpLaneVOs != null) {
				for (int i = 0; i < scpLaneVOs.length; i++) {
					scpLaneVOs[i].setRqstNo(rqstNo);
					if ("U".equals(scpLaneVOs[i].getIbflag())) {
						updateLaneVoList.add(scpLaneVOs[i]);
					} else if ("I".equals(scpLaneVOs[i].getIbflag())) {
						createLaneVoList.add(scpLaneVOs[i]);
					} else if ("D".equals(scpLaneVOs[i].getIbflag())) {
						deleteLaneVoList.add(scpLaneVOs[i]);
					}
				}
			}
			if (scpLimintVOs != null) {
				for (int i = 0; i < scpLimintVOs.length; i++) {
					scpLimintVOs[i].setRqstNo(rqstNo);
					if ("U".equals(scpLimintVOs[i].getIbflag())) {
						updateLimitVoList.add(scpLimintVOs[i]);
					} else if ("I".equals(scpLimintVOs[i].getIbflag())) {
						createLimitVoList.add(scpLimintVOs[i]);
					} else if ("D".equals(scpLimintVOs[i].getIbflag())) {
						deleteLimitVoList.add(scpLimintVOs[i]);
					}
				}
			}

			if (createLaneVoList.size() > 0) {
				dbDao.addeScpLaneRqst(createLaneVoList);
			}
			if (updateLaneVoList.size() > 0) {
				dbDao.modifyScpLaneRqst(updateLaneVoList);
			}
			if (deleteLaneVoList.size() > 0) {
				dbDao.removeScpLaneRqst(deleteLaneVoList);
			}
			if (createLimitVoList.size() > 0) {
				dbDao.addeScpLimitRqst(createLimitVoList);
			}
			if (updateLimitVoList.size() > 0) {
				dbDao.modifyScpLimitRqst(updateLimitVoList);
			}
			if (deleteLimitVoList.size() > 0) {
				dbDao.removeScpLimitRqst(deleteLimitVoList);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * To trd code to query detailed information.<br>
	 * 
	 * @param String trdCd
	 * @return TradeVO
	 * @exception EventException
	 */
	public TradeVO searchTrdCode(String trdCd) throws EventException {
		try {
			return dbDao.searchTrdCode(trdCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * To trd code to query detailed information.<br>
	 * 
	 * @param String rqstNo
	 * @return TradeVO
	 * @exception EventException
	 */
	public TradeVO searchTrdRqst(String rqstNo) throws EventException {
		try {
			return dbDao.searchTrdRqst(rqstNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Trd code on the new generation, and trd code to modify the details of information.<br>
	 * 
	 * @param TradeVO trdvo
	 * @exception EventException
	 */
	public void manageTrdCode(TradeVO trdvo) throws EventException {
		try {
			if (trdvo.getIbflag().equals("I")) {
				dbDao.addTrdCode(trdvo);
			} else if (trdvo.getIbflag().equals("U")) {
				dbDao.modifyTrdCode(trdvo);
			}
			
			//manageTradeIbisIf(trdvo);	//2018.05.15 Min IBIS 주석처리...
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Trd code on the new generation, and trd code to modify the details of information.<br>
	 * 
	 * @param TradeVO trdvo
	 * @exception EventException
	 */
	public void manageTrdRqst(TradeVO trdvo) throws EventException {
		try {
			if (trdvo.getIbflag().equals("I")) {
				dbDao.addTrdRqst(trdvo);
			} else if (trdvo.getIbflag().equals("U")) {
				dbDao.modifyTrdRqst(trdvo);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * To sub trd code to query detailed information.<br>
	 * 
	 * @param String subtrdCd
	 * @return SubTradeVO
	 * @exception EventException
	 */
	public SubTradeVO searchSubTrdCode(String subTrdCd) throws EventException {
		try {
			return dbDao.searchSubTrdCode(subTrdCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Sub trd code on the new generation, and sub trd code to modify the details of information.<br>
	 * 
	 * @param SubTradeVO subtrdvo
	 * @exception EventException
	 */
	public void manageSubTrdCode(SubTradeVO subTrdvo) throws EventException {
		try {
			if (subTrdvo.getIbflag().equals("I")) {
				dbDao.addSubTrdCode(subTrdvo);
			} else if (subTrdvo.getIbflag().equals("U")) {
				dbDao.modifySubTrdCode(subTrdvo);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	

	/**
	 * BCM_CCD_0028 : Save<br>
	 * SLane information save.<br>
	 * 
	 * @param SLaneVO slaneVO
	 * @exception EventException
	 */
	public void manageSlaneInfoIf(SLaneVO slaneVO) throws EventException{
		try{
			SLaneIfVO slaneifVO = new SLaneIfVO();
			String vsl_slan_if_seq = "";
			
			//VSL_SLAN_SEQ_IF 채번
			vsl_slan_if_seq = searchSlaneIfSeq();
			slaneifVO.setVslSlanIfSeq(vsl_slan_if_seq);

			slaneifVO.setVslSlanCd(slaneVO.getVslSlanCd());
			slaneifVO.setVslSlanNm(slaneVO.getVslSlanNm());
			slaneifVO.setVslSvcTpCd(slaneVO.getVslSvcTpCd());
			slaneifVO.setVslTpCd(slaneVO.getVslTpCd());
			slaneifVO.setStEffDt(slaneVO.getStEffDt());
			slaneifVO.setEndEffDt(slaneVO.getEndEffDt());
			slaneifVO.setCoCd(slaneVO.getCoCd());
			slaneifVO.setFdrDivCd(slaneVO.getFdrDivCd());

			slaneifVO.setCreUsrId(slaneVO.getUserId());
			slaneifVO.setUpdUsrId(slaneVO.getUserId());
			slaneifVO.setDeltFlg(slaneVO.getDeltFlg());
			slaneifVO.setModiVslSlanCd(slaneVO.getModiVslSlanCd());
			slaneifVO.setModiVslSlanCd2(slaneVO.getModiVslSlanCd2());
			slaneifVO.setModiVipTeamCd(slaneVO.getModiVipTeamCd());

			slaneifVO.setEcomInsfId("OPECOM03");
			slaneifVO.setOcediInsfId("OCEDI01");
			if("Y".equals(slaneVO.getEdiIfFlg())||"Y".equals(slaneVO.getDeltFlg())){
				slaneifVO.setOpediInsfId("OPEDI04");
			}else{
				slaneifVO.setOpediInsfId("");
			}
			
			if(slaneVO.getAddFlg().equals("I")){
				slaneifVO.setEcomInsfDvCd("I");
				slaneifVO.setOcediInsfDvCd("I");
				slaneifVO.setOpediInsfDvCd("I");
			}else if(slaneVO.getAddFlg().equals("U")){
				if(slaneVO.getDeltFlg().equals("Y")){
					slaneifVO.setEcomInsfDvCd("D");
					slaneifVO.setOcediInsfDvCd("D");
					slaneifVO.setOpediInsfDvCd("D");
				}else {
					slaneifVO.setEcomInsfDvCd("U");
					slaneifVO.setOcediInsfDvCd("U");
					slaneifVO.setOpediInsfDvCd("U");
				}
			}

			dbDao.addSlaneInfoIf(slaneifVO);
			dbDao.addSlaneInfoIbisIf(slaneifVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}

	/**
	 * SLane EAI I/F 의 테이블(MDM_VSL_SVC_LANE_IF)의 VSL_SLAN_SEQ 생성값을 조회 합니다.(BCM_CCD_0028)<br>
	 * SLane Seq + 1 retrieve.<br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchSlaneIfSeq() throws EventException{
		DBRowSet rowSet = null;
        String vsl_slan_seq = "";
        
        try {
            rowSet=dbDao.searchSlaneIfSeq();
            if(rowSet!=null) {
            	while(rowSet.next()){
            		vsl_slan_seq = rowSet.getString(1);
            	}
            }
            return vsl_slan_seq;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
	}
	
	/**
	 * BCM_CCD_0030 : Save<br>
	 * Trade IBIS Interface information save.<br>
	 * 
	 * @param TradeVO tradeVO
	 * @exception EventException
	 */
	public void manageTradeIbisIf(TradeVO tradeVO) throws EventException{
		try{
			TradeIbisIfVO tradeIbisIfVO = new TradeIbisIfVO();
			
			tradeIbisIfVO.setTrdCd(tradeVO.getTrdCd());
			tradeIbisIfVO.setTrdNm(tradeVO.getTrdNm());
			tradeIbisIfVO.setVslTpCd(tradeVO.getVslTpCd());
			tradeIbisIfVO.setFmContiCd(tradeVO.getFmContiCd());
			tradeIbisIfVO.setToContiCd(tradeVO.getToContiCd());
			tradeIbisIfVO.setOfcCd(tradeVO.getOfcCd());
			tradeIbisIfVO.setStEffDt(tradeVO.getStEffDt());
			tradeIbisIfVO.setEndEffDt(tradeVO.getEndEffDt());
			tradeIbisIfVO.setCreUsrId(tradeVO.getUserId());
			tradeIbisIfVO.setUpdUsrId(tradeVO.getUserId());
			tradeIbisIfVO.setModiCostCtrCd(tradeVO.getModiCostCtrCd());
			tradeIbisIfVO.setDeltFlg(tradeVO.getDeltFlg());
			if("I".equals(tradeVO.getIbflag())){
				tradeIbisIfVO.setIfMnplCd("I");
			}else if("U".equals(tradeVO.getIbflag())){
				if("Y".equals(tradeVO.getDeltFlg())){
					tradeIbisIfVO.setIfMnplCd("D");
				}else{
					tradeIbisIfVO.setIfMnplCd("U");
				}
			}
			
			dbDao.addTrdIbisIf(tradeIbisIfVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
}