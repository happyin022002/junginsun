/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SCRateGuidelineBCImpl.java
 *@FileTitle : Guideline MQC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.scrateguideline.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.scguideline.scguidelinemain.vo.GlineMnCpVO;
import com.clt.apps.opus.esm.pri.scguideline.scrateguideline.integration.SCRateGuidelineDBDAO;
import com.clt.apps.opus.esm.pri.scguideline.scrateguideline.vo.RsltRtCmdtListVO;
import com.clt.apps.opus.esm.pri.scguideline.scrateguideline.vo.RsltRtCustTpVO;
import com.clt.apps.opus.esm.pri.scguideline.scrateguideline.vo.RsltRtListExcelVO;
import com.clt.apps.opus.esm.pri.scguideline.scrateguideline.vo.RsltRtRoutHdrListVO;
import com.clt.apps.opus.esm.pri.scguideline.scrateguideline.vo.RsltRtRoutListVO;
import com.clt.apps.opus.esm.pri.scguideline.scrateguideline.vo.ScRtGlineCmdtVO;
import com.clt.apps.opus.esm.pri.scguideline.scrateguideline.vo.ScRtGlineRoutVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSgMnVO;
import com.clt.syscommon.common.table.PriSgRtCmdtHdrVO;
import com.clt.syscommon.common.table.PriSgRtCmdtRnoteVO;
import com.clt.syscommon.common.table.PriSgRtCmdtRoutVO;
import com.clt.syscommon.common.table.PriSgRtCmdtVO;
import com.clt.syscommon.common.table.PriSgRtMqcRngVO;
import com.clt.syscommon.common.table.PriSgRtRoutPntVO;
import com.clt.syscommon.common.table.PriSgRtRoutViaVO;
import com.clt.syscommon.common.table.PriSgRtVO;

/**
 * SCGuideline Business Logic Basic Command implementation<br>
 * - handling biz logic about SCGuideline <br>
 * 
 * @author  
 * @see UI_PRI_0030EventResponse,SCRateGuidelineBC each DAO class
 * @since J2EE 1.4
 */

public class SCRateGuidelineBCImpl extends BasicCommandSupport implements SCRateGuidelineBC {

	// Database Access Object
	private transient SCRateGuidelineDBDAO dbDao = null;

	/**
	 * SCRateGuidelineBCImpl object creation<br>
	 * creating SCRateGuidelineDBDAO<br>
	 */
	public SCRateGuidelineBCImpl() {
		dbDao = new SCRateGuidelineDBDAO();
	}

	/**
	 * retrieving Customer Type for Radio Button setting<br>
	 * 
	 * @param PriSgRtCmdtHdrVO priSgRtCmdtHdrVO
	 * @return List<RsltRtCustTpVO>
	 * @exception EventException
	 */
	public List<RsltRtCustTpVO> searchRateCustomerType(PriSgRtCmdtHdrVO priSgRtCmdtHdrVO) throws EventException {
		try {
			return dbDao.searchRateCustomerType(priSgRtCmdtHdrVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * retrieving Rate Guideline Commodity list<br>
	 * 
	 * @param PriSgRtCmdtHdrVO priSgRtCmdtHdrVO
	 * @return RsltRtCmdtListVO
	 * @exception EventException
	 */
	public RsltRtCmdtListVO searchRateCommodityList(PriSgRtCmdtHdrVO priSgRtCmdtHdrVO) throws EventException {
		RsltRtCmdtListVO vo = new RsltRtCmdtListVO();

		try {
			vo.setRsltRtCmdtHdrListVOS(dbDao.searchRateCommodityHeaderList(priSgRtCmdtHdrVO));
			vo.setPriSgRtCmdtVOS(dbDao.searchRateCommodityDetailList(priSgRtCmdtHdrVO));

			return vo;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Rate Guideline Route list retrieving<br>
	 * 
	 * @param PriSgRtCmdtRoutVO priSgRtCmdtRoutVO
	 * @return List<RsltRtRoutHdrListVO>
	 * @exception EventException
	 */
	public List<RsltRtRoutHdrListVO> searchRateRouteList(PriSgRtCmdtRoutVO priSgRtCmdtRoutVO) throws EventException {
		try {
			return dbDao.searchRateRouteHeaderList(priSgRtCmdtRoutVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Rate Guideline Rate list retrieving<br>
	 * 
	 * @param PriSgRtVO priSgRtVO
	 * @return RsltRtRoutListVO
	 * @exception EventException
	 */
	public RsltRtRoutListVO searchRateList(PriSgRtVO priSgRtVO) throws EventException {
		RsltRtRoutListVO vo = new RsltRtRoutListVO();
		try {
			vo.setRsltRtListVOS(dbDao.searchRateList(priSgRtVO));
			vo.setOrgRsltRtRoutPntListVOS(dbDao.searchRateRouteOriginPointList(priSgRtVO));
			vo.setOrgRsltRtRoutViaListVOS(dbDao.searchRateRouteOriginViaList(priSgRtVO));
			vo.setDestRsltRtRoutViaListVOS(dbDao.searchRateRouteDestinationViaList(priSgRtVO));
			vo.setDestRsltRtRoutPntListVOS(dbDao.searchRateRouteDestinationPointList(priSgRtVO));
			vo.setRsltRtCmdtRnoteListVOS(dbDao.searchRateCommodityRnoteList(priSgRtVO));

			return vo;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Rate list retrieving for Rate Guideline Excel Download <br>
	 * 
	 * @param PriSgRtCmdtHdrVO priSgRtCmdtHdrVO
	 * @return List<RsltRtListExcelVO>
	 * @exception EventException
	 */
	public List<RsltRtListExcelVO> searchRateListExcel(PriSgRtCmdtHdrVO priSgRtCmdtHdrVO) throws EventException {
		try {
			return dbDao.searchRateListExcel(priSgRtCmdtHdrVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Rate Commodity Header data CUD transaction event handling<br>
	 * 
	 * @param ScRtGlineCmdtVO scRtGlineCmdtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRateCommodity(ScRtGlineCmdtVO scRtGlineCmdtVO, SignOnUserAccount account) throws EventException {
		try {
			PriSgRtCmdtHdrVO[] vo = scRtGlineCmdtVO.getPriSgRtCmdtHdrVOS();
			PriSgRtCmdtVO[] dtlvo = scRtGlineCmdtVO.getPriSgRtCmdtVOS();

			List<PriSgRtCmdtHdrVO> insertVoList = new ArrayList<PriSgRtCmdtHdrVO>();
			List<PriSgRtCmdtHdrVO> updateVoList = new ArrayList<PriSgRtCmdtHdrVO>();
			List<PriSgRtCmdtHdrVO> deleteVoList = new ArrayList<PriSgRtCmdtHdrVO>();
			List<PriSgRtCmdtVO> insertDtlVoList = new ArrayList<PriSgRtCmdtVO>();
			List<PriSgRtCmdtVO> updateDtlVoList = new ArrayList<PriSgRtCmdtVO>();
			List<PriSgRtCmdtVO> deleteDtlVoList = new ArrayList<PriSgRtCmdtVO>();

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
				dbDao.addRateCommodityHeader(insertVoList);
			}
			if (insertDtlVoList.size() > 0) {
				dbDao.addRateCommodity(insertDtlVoList);
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyRateCommodityHeader(updateVoList);
			}
			if (updateDtlVoList.size() > 0) {
				dbDao.modifyRateCommodity(updateDtlVoList);
			}

			if (deleteDtlVoList.size() > 0) {
				dbDao.removeRateCommodity(deleteDtlVoList);
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeRateCommodityHeaderCascadeRt(deleteVoList);
				dbDao.removeRateCommodityHeaderCascadeRnote(deleteVoList);
				dbDao.removeRateCommodityHeaderCascadeRoutVia(deleteVoList);
				dbDao.removeRateCommodityHeaderCascadeRoutPnt(deleteVoList);
				dbDao.removeRateCommodityHeaderCascadeCmdtRout(deleteVoList);
				dbDao.removeRateCommodityHeaderCascadeCmdt(deleteVoList);
				dbDao.removeRateCommodityHeader(deleteVoList);
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Rate Commodity - Route data CUD transaction event handling<br>
	 * 
	 * @param ScRtGlineRoutVO scRtGlineRoutVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRateRoute(ScRtGlineRoutVO scRtGlineRoutVO, SignOnUserAccount account) throws EventException {
		try {
			PriSgRtCmdtRoutVO[] routvo = scRtGlineRoutVO.getPriSgRtCmdtRoutVOS();
			PriSgRtRoutPntVO[] orgpntvo = scRtGlineRoutVO.getPriSgRtRoutOrgPntVOS();
			PriSgRtRoutViaVO[] orgviavo = scRtGlineRoutVO.getPriSgRtRoutOrgViaVOS();
			PriSgRtRoutViaVO[] destviavo = scRtGlineRoutVO.getPriSgRtRoutDestViaVOS();
			PriSgRtRoutPntVO[] destpntvo = scRtGlineRoutVO.getPriSgRtRoutDestPntVOS();
			PriSgRtCmdtRnoteVO[] rnotevo = scRtGlineRoutVO.getPriSgRtCmdtRnoteVOS();
			PriSgRtVO[] rtvo = scRtGlineRoutVO.getPriSgRtVOS();

			List<PriSgRtCmdtRoutVO> insertRoutList = new ArrayList<PriSgRtCmdtRoutVO>();
			List<PriSgRtCmdtRoutVO> updateRoutList = new ArrayList<PriSgRtCmdtRoutVO>();
			List<PriSgRtCmdtRoutVO> deleteRoutList = new ArrayList<PriSgRtCmdtRoutVO>();
			List<PriSgRtRoutPntVO> insertPntList = new ArrayList<PriSgRtRoutPntVO>();
			List<PriSgRtRoutPntVO> updatePntList = new ArrayList<PriSgRtRoutPntVO>();
			List<PriSgRtRoutPntVO> deletePntList = new ArrayList<PriSgRtRoutPntVO>();
			List<PriSgRtRoutViaVO> insertViaList = new ArrayList<PriSgRtRoutViaVO>();
			List<PriSgRtRoutViaVO> updateViaList = new ArrayList<PriSgRtRoutViaVO>();
			List<PriSgRtRoutViaVO> deleteViaList = new ArrayList<PriSgRtRoutViaVO>();
			List<PriSgRtCmdtRnoteVO> insertRnoteList = new ArrayList<PriSgRtCmdtRnoteVO>();
			List<PriSgRtCmdtRnoteVO> updateRnoteList = new ArrayList<PriSgRtCmdtRnoteVO>();
			List<PriSgRtCmdtRnoteVO> deleteRnoteList = new ArrayList<PriSgRtCmdtRnoteVO>();
			List<PriSgRtVO> insertRtList = new ArrayList<PriSgRtVO>();
			List<PriSgRtVO> updateRtList = new ArrayList<PriSgRtVO>();
			List<PriSgRtVO> deleteRtList = new ArrayList<PriSgRtVO>();

			for (int i = 0; routvo != null && i < routvo.length; i++) {
				if (routvo[i].getIbflag().equals("I")) {
					routvo[i].setCreUsrId(account.getUsr_id());
					routvo[i].setUpdUsrId(account.getUsr_id());
					insertRoutList.add(routvo[i]);
				} else if (routvo[i].getIbflag().equals("U")) {
					routvo[i].setUpdUsrId(account.getUsr_id());
					updateRoutList.add(routvo[i]);
				} else if (routvo[i].getIbflag().equals("D")) {
					deleteRoutList.add(routvo[i]);
				}
			}
			for (int i = 0; orgpntvo != null && i < orgpntvo.length; i++) {
				if (orgpntvo[i].getIbflag().equals("I")) {
					orgpntvo[i].setCreUsrId(account.getUsr_id());
					orgpntvo[i].setUpdUsrId(account.getUsr_id());
					insertPntList.add(orgpntvo[i]);
				} else if (orgpntvo[i].getIbflag().equals("U")) {
					orgpntvo[i].setUpdUsrId(account.getUsr_id());
					updatePntList.add(orgpntvo[i]);
				} else if (orgpntvo[i].getIbflag().equals("D")) {
					deletePntList.add(orgpntvo[i]);
				}
			}
			for (int i = 0; orgviavo != null && i < orgviavo.length; i++) {
				if (orgviavo[i].getIbflag().equals("I")) {
					orgviavo[i].setCreUsrId(account.getUsr_id());
					orgviavo[i].setUpdUsrId(account.getUsr_id());
					insertViaList.add(orgviavo[i]);
				} else if (orgviavo[i].getIbflag().equals("U")) {
					orgviavo[i].setUpdUsrId(account.getUsr_id());
					updateViaList.add(orgviavo[i]);
				} else if (orgviavo[i].getIbflag().equals("D")) {
					deleteViaList.add(orgviavo[i]);
				}
			}
			for (int i = 0; destviavo != null && i < destviavo.length; i++) {
				if (destviavo[i].getIbflag().equals("I")) {
					destviavo[i].setCreUsrId(account.getUsr_id());
					destviavo[i].setUpdUsrId(account.getUsr_id());
					insertViaList.add(destviavo[i]);
				} else if (destviavo[i].getIbflag().equals("U")) {
					destviavo[i].setUpdUsrId(account.getUsr_id());
					updateViaList.add(destviavo[i]);
				} else if (destviavo[i].getIbflag().equals("D")) {
					deleteViaList.add(destviavo[i]);
				}
			}
			for (int i = 0; destpntvo != null && i < destpntvo.length; i++) {
				if (destpntvo[i].getIbflag().equals("I")) {
					destpntvo[i].setCreUsrId(account.getUsr_id());
					destpntvo[i].setUpdUsrId(account.getUsr_id());
					insertPntList.add(destpntvo[i]);
				} else if (destpntvo[i].getIbflag().equals("U")) {
					destpntvo[i].setUpdUsrId(account.getUsr_id());
					updatePntList.add(destpntvo[i]);
				} else if (destpntvo[i].getIbflag().equals("D")) {
					deletePntList.add(destpntvo[i]);
				}
			}
			for (int i = 0; rnotevo != null && i < rnotevo.length; i++) {
				if (rnotevo[i].getIbflag().equals("I")) {
					rnotevo[i].setCreUsrId(account.getUsr_id());
					rnotevo[i].setUpdUsrId(account.getUsr_id());
					insertRnoteList.add(rnotevo[i]);
				} else if (rnotevo[i].getIbflag().equals("U")) {
					rnotevo[i].setUpdUsrId(account.getUsr_id());
					updateRnoteList.add(rnotevo[i]);
				} else if (rnotevo[i].getIbflag().equals("D")) {
					deleteRnoteList.add(rnotevo[i]);
				}
			}
			for (int i = 0; rtvo != null && i < rtvo.length; i++) {
				if (rtvo[i].getIbflag().equals("I")) {
					rtvo[i].setCreUsrId(account.getUsr_id());
					rtvo[i].setUpdUsrId(account.getUsr_id());
					insertRtList.add(rtvo[i]);
				} else if (rtvo[i].getIbflag().equals("U")) {
					rtvo[i].setUpdUsrId(account.getUsr_id());
					updateRtList.add(rtvo[i]);
				} else if (rtvo[i].getIbflag().equals("D")) {
					deleteRtList.add(rtvo[i]);
				}
			}

			if (insertRoutList.size() > 0) {
				dbDao.addRateCommodityRoute(insertRoutList);
			}
			if (insertPntList.size() > 0) {
				dbDao.addRateRoutePoint(insertPntList);
			}
			if (insertViaList.size() > 0) {
				dbDao.addRateRouteVia(insertViaList);
			}
			if (insertRnoteList.size() > 0) {
				dbDao.addRateCommodityRnote(insertRnoteList);
			}
			if (insertRtList.size() > 0) {
				dbDao.addRate(insertRtList);
			}

			if (updateRoutList.size() > 0) {
				dbDao.modifyRateCommodityRoute(updateRoutList);
			}
			if (updatePntList.size() > 0) {
				dbDao.modifyRateRoutePoint(updatePntList);
			}
			if (updateViaList.size() > 0) {
				dbDao.modifyRateRouteVia(updateViaList);
			}
			if (updateRnoteList.size() > 0) {
				dbDao.modifyRateCommodityRnote(updateRnoteList);
			}
			if (updateRtList.size() > 0) {
				dbDao.modifyRate(updateRtList);
			}

			if (deleteRtList.size() > 0) {
				dbDao.removeRate(deleteRtList);
			}
			if (deleteRnoteList.size() > 0) {
				dbDao.removeRateCommodityRnote(deleteRnoteList);
			}
			if (deleteViaList.size() > 0) {
				dbDao.removeRateRouteVia(deleteViaList);
			}
			if (deletePntList.size() > 0) {
				dbDao.removeRateRoutePoint(deletePntList);
			}
			if (deleteRoutList.size() > 0) {
				dbDao.removeRateCommodityRoute(deleteRoutList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
    /**
     * SC Guideline Rate Vertical Excel validation check<br>
     * 
     * @param PriSgRtCmdtHdrVO priSgRtCmdtHdrVO
     * @param RsltRtListExcelVO[] rsltRtListExcelVOs
     * @return List<RsltCdListVO>
     * @exception EventException
     */
    public List<RsltCdListVO> checkRateExcelVertical(PriSgRtCmdtHdrVO priSgRtCmdtHdrVO, RsltRtListExcelVO[] rsltRtListExcelVOs) throws EventException {
        List<RsltCdListVO> rslt = new ArrayList<RsltCdListVO>();
        try {
            String strCmdtCd    = null;
            String strOrgPntCd  = null;
            String strOrgViaCd  = null;
            String strDestViaCd = null;
            String strDestPntCd = null;
            RsltRtListExcelVO row = null;

            for (int i = 0; i < rsltRtListExcelVOs.length; i++) {
                row = rsltRtListExcelVOs[i];
                
                strCmdtCd = row.getPrcCmdtDefCd();
                strOrgPntCd = row.getOrgRoutPntLocDefCd();
                strOrgViaCd = row.getOrgRoutViaPortDefCd();
                strDestViaCd = row.getDestRoutViaPortDefCd();
                strDestPntCd = row.getDestRoutPntLocDefCd();
                
                if (strCmdtCd != null && !"".equals(strCmdtCd)) {
                    RsltCdListVO paramVO = new RsltCdListVO();
                    paramVO.setPrcCustTpCd(priSgRtCmdtHdrVO.getPrcCustTpCd());
                    paramVO.setGlineSeq(priSgRtCmdtHdrVO.getGlineSeq());
                    paramVO.setSvcScpCd(priSgRtCmdtHdrVO.getSvcScpCd());
                    paramVO.setCd(strCmdtCd);
                    
                    RsltCdListVO cdVO = dbDao.searchCommodityCodeExists(paramVO);
                    if (cdVO == null) {
                        cdVO = new RsltCdListVO();
                        cdVO.setCd(strCmdtCd);
                        cdVO.setNm("");
                        cdVO.setEtc1(String.valueOf(i));
                        cdVO.setEtc2("prc_cmdt_def_cd");
                        
                        rslt.add(cdVO);
                    }
                }

                if (strOrgPntCd != null && !"".equals(strOrgPntCd)) {
                    RsltCdListVO paramVO = new RsltCdListVO();
                    paramVO.setPrcCustTpCd(priSgRtCmdtHdrVO.getPrcCustTpCd());
                    paramVO.setGlineSeq(priSgRtCmdtHdrVO.getGlineSeq());
                    paramVO.setSvcScpCd(priSgRtCmdtHdrVO.getSvcScpCd());
                    paramVO.setCd(strOrgPntCd);
                    paramVO.setEtc1("O");
                    
                    RsltCdListVO cdVO = dbDao.searchLocationCodeExists(paramVO);
                    if (cdVO == null) {
                        cdVO = new RsltCdListVO();
                        cdVO.setCd(strOrgPntCd);
                        cdVO.setNm("");
                        cdVO.setEtc1(String.valueOf(i));
                        cdVO.setEtc2("org_rout_pnt_loc_def_cd");
                        
                        rslt.add(cdVO);
                    }
                }
                if (strOrgViaCd != null && !"".equals(strOrgViaCd)) {
                    RsltCdListVO paramVO = new RsltCdListVO();
                    paramVO.setPrcCustTpCd(priSgRtCmdtHdrVO.getPrcCustTpCd());
                    paramVO.setGlineSeq(priSgRtCmdtHdrVO.getGlineSeq());
                    paramVO.setSvcScpCd(priSgRtCmdtHdrVO.getSvcScpCd());
                    paramVO.setCd(strOrgViaCd);
                    
                    RsltCdListVO cdVO = dbDao.searchLocationCodeExists(paramVO);
                    if (cdVO == null) {
                        cdVO = new RsltCdListVO();
                        cdVO.setCd(strOrgViaCd);
                        cdVO.setNm("");
                        cdVO.setEtc1(String.valueOf(i));
                        cdVO.setEtc2("org_rout_via_port_def_cd");
                        
                        rslt.add(cdVO);
                    }
                }
                if (strDestViaCd != null && !"".equals(strDestViaCd)) {
                    RsltCdListVO paramVO = new RsltCdListVO();
                    paramVO.setPrcCustTpCd(priSgRtCmdtHdrVO.getPrcCustTpCd());
                    paramVO.setGlineSeq(priSgRtCmdtHdrVO.getGlineSeq());
                    paramVO.setSvcScpCd(priSgRtCmdtHdrVO.getSvcScpCd());
                    paramVO.setCd(strDestViaCd);
                    
                    RsltCdListVO cdVO = dbDao.searchLocationCodeExists(paramVO);
                    if (cdVO == null) {
                        cdVO = new RsltCdListVO();
                        cdVO.setCd(strDestViaCd);
                        cdVO.setNm("");
                        cdVO.setEtc1(String.valueOf(i));
                        cdVO.setEtc2("dest_rout_via_port_def_cd");
                        
                        rslt.add(cdVO);
                    }
                }
                if (strDestPntCd != null && !"".equals(strDestPntCd)) {
                    RsltCdListVO paramVO = new RsltCdListVO();
                    paramVO.setPrcCustTpCd(priSgRtCmdtHdrVO.getPrcCustTpCd());
                    paramVO.setGlineSeq(priSgRtCmdtHdrVO.getGlineSeq());
                    paramVO.setSvcScpCd(priSgRtCmdtHdrVO.getSvcScpCd());
                    paramVO.setCd(strDestPntCd);
                    paramVO.setEtc1("D");
                    
                    RsltCdListVO cdVO = dbDao.searchLocationCodeExists(paramVO);
                    if (cdVO == null) {
                        cdVO = new RsltCdListVO();
                        cdVO.setCd(strDestPntCd);
                        cdVO.setNm("");
                        cdVO.setEtc1(String.valueOf(i));
                        cdVO.setEtc2("dest_rout_pnt_loc_def_cd");
                        
                        rslt.add(cdVO);
                    }
                }
            }
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return rslt;
    }
    
    /**
     * creating Guideline Rate by Guideline Rate Vertical Excel <br>
     * 
     * @param PriSgRtCmdtHdrVO priSgRtCmdtHdrVO
     * @param RsltRtListExcelVO[] rsltRtListExcelVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void uploadRateExcelVertical(PriSgRtCmdtHdrVO priSgRtCmdtHdrVO, RsltRtListExcelVO[] rsltRtListExcelVOs, SignOnUserAccount account) throws EventException {
        List<PriSgRtCmdtHdrVO> cmdtHdrVoList = new ArrayList<PriSgRtCmdtHdrVO>();
        List<PriSgRtCmdtVO> cmdtVoList = new ArrayList<PriSgRtCmdtVO>();
        List<PriSgRtCmdtRoutVO> routVoList = new ArrayList<PriSgRtCmdtRoutVO>();
        List<PriSgRtRoutPntVO> pntVoList = new ArrayList<PriSgRtRoutPntVO>();
        List<PriSgRtRoutViaVO> viaVoList = new ArrayList<PriSgRtRoutViaVO>();
        List<PriSgRtVO> rtVoList = new ArrayList<PriSgRtVO>();

        try {
            int nextCmdtHdrSeq = dbDao.searchNextCmdtHdrSeq(priSgRtCmdtHdrVO);
            int nextCmdtSeq = 0;
            
            int nextRoutSeq = 0;
            int nextRoutPntSeq = 0;
            int nextRoutViaSeq = 0;
            int nextRtSeq = 0;
            
            String strPrcCustTpCd = priSgRtCmdtHdrVO.getPrcCustTpCd();
            String strGlineSeq = priSgRtCmdtHdrVO.getGlineSeq();
            String strSvcScpCd = priSgRtCmdtHdrVO.getSvcScpCd();
            String strEffDt = priSgRtCmdtHdrVO.getEffDt();
            String strExpDt = priSgRtCmdtHdrVO.getExpDt();
            String strCreUsrId = account.getUsr_id();
            String strUpdUsrId = account.getUsr_id();

            RsltRtListExcelVO row = null;
            String strCmdtDpSeq = null;
            String strCmdtCd = null;
            
            String strRoutDpSeq = null;
            String strOrgPntCd = null;
            String strOrgRcvDeTermCd = null;
            String strOrgPrcTrspModCd = null;
            String strOrgViaCd = null;
            String strDestViaCd = null;
            String strDestPntCd = null;
            String strDestRcvDeTermCd = null;
            String strDestPrcTrspModCd = null;
            
            String strDirCallFlg = null;
            
            String strMqcRngFmQty = null;
            String strMqcRngToQty = null;
            String strPerTypeCd = null;
            String strCgoTypeCd = null;
            String strRateAmt = null;
            
            PriSgRtCmdtHdrVO cmdtHdr = null;
            PriSgRtCmdtVO cmdt = null;
            PriSgRtCmdtRoutVO rout = null;
            PriSgRtRoutPntVO pnt = null;
            PriSgRtRoutViaVO via = null;
            PriSgRtVO rt = null;

            for (int i = 0; i < rsltRtListExcelVOs.length; i++) {
                row = rsltRtListExcelVOs[i];
                
                strCmdtDpSeq = row.getCmdtDpSeq();
                strCmdtCd = row.getPrcCmdtDefCd();

                strRoutDpSeq = row.getRoutDpSeq();
                strOrgPntCd = row.getOrgRoutPntLocDefCd();
                strOrgRcvDeTermCd = row.getOrgRcvDeTermNm();
                strOrgPrcTrspModCd = row.getOrgPrcTrspModNm();
                strOrgViaCd = row.getOrgRoutViaPortDefCd();
                strDestViaCd = row.getDestRoutViaPortDefCd();
                strDestPntCd = row.getDestRoutPntLocDefCd();
                strDestRcvDeTermCd = row.getDestRcvDeTermNm();
                strDestPrcTrspModCd = row.getDestPrcTrspModNm();
                
                strDirCallFlg = row.getDirCallFlg();
                if (strDirCallFlg == null || "".equals(strDirCallFlg)) {
                	strDirCallFlg = "N";
                }

                strMqcRngFmQty = row.getMqcRngFmQty();
                strMqcRngToQty = row.getMqcRngToQty();
                strPerTypeCd = row.getRatUtCd();
                strCgoTypeCd = row.getPrcCgoTpCd();
                strRateAmt = row.getFrtRtAmt();
                
                if (strCmdtDpSeq != null && !"".equals(strCmdtDpSeq)) {
                    nextCmdtHdrSeq++;
                    nextCmdtSeq = 0;
                    nextRoutSeq = 0;
                    
                    cmdtHdr = new PriSgRtCmdtHdrVO();
                    
                    cmdtHdr.setPrcCustTpCd(strPrcCustTpCd);
                    cmdtHdr.setGlineSeq(strGlineSeq);
                    cmdtHdr.setSvcScpCd(strSvcScpCd);
                    cmdtHdr.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
                    cmdtHdr.setEffDt(strEffDt);
                    cmdtHdr.setExpDt(strExpDt);
                    cmdtHdr.setCreUsrId(strCreUsrId);
                    cmdtHdr.setUpdUsrId(strUpdUsrId);

                    cmdtHdrVoList.add(cmdtHdr);
                }
                
                if (strCmdtCd != null && !"".equals(strCmdtCd)) {
                    nextCmdtSeq++;
                    
                    cmdt = new PriSgRtCmdtVO();
                    
                    cmdt.setPrcCustTpCd(strPrcCustTpCd);
                    cmdt.setGlineSeq(strGlineSeq);
                    cmdt.setSvcScpCd(strSvcScpCd);
                    cmdt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
                    cmdt.setCmdtSeq(String.valueOf(nextCmdtSeq));
                    cmdt.setPrcCmdtTpCd(strCmdtCd.length() == 5 ? "G" : "C");
                    cmdt.setPrcCmdtDefCd(strCmdtCd);
                    cmdt.setCreUsrId(strCreUsrId);
                    cmdt.setUpdUsrId(strUpdUsrId);

                    cmdtVoList.add(cmdt);
                }
                
                if (strRoutDpSeq != null && !"".equals(strRoutDpSeq)) {
                    nextRoutSeq++;
                    nextRoutPntSeq = 0;
                    nextRoutViaSeq = 0;
                    nextRtSeq = 0;
                    
                    rout = new PriSgRtCmdtRoutVO();
                    
                    rout.setPrcCustTpCd(strPrcCustTpCd);
                    rout.setGlineSeq(strGlineSeq);
                    rout.setSvcScpCd(strSvcScpCd);
                    rout.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
                    rout.setRoutSeq(String.valueOf(nextRoutSeq));
                    rout.setDirCallFlg(strDirCallFlg);
                    rout.setCreUsrId(strCreUsrId);
                    rout.setUpdUsrId(strUpdUsrId);

                    routVoList.add(rout);
                }
                
                if (strOrgPntCd != null && !"".equals(strOrgPntCd)) {
                    nextRoutPntSeq++;

                    pnt = new PriSgRtRoutPntVO();
                    
                    pnt.setPrcCustTpCd(strPrcCustTpCd);
                    pnt.setGlineSeq(strGlineSeq);
                    pnt.setSvcScpCd(strSvcScpCd);
                    pnt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
                    pnt.setRoutSeq(String.valueOf(nextRoutSeq));
                    pnt.setOrgDestTpCd("O");
                    pnt.setRoutPntSeq(String.valueOf(nextRoutPntSeq));
                    pnt.setRoutPntLocTpCd(strOrgPntCd.length() == 4 ? "G" : "L");
                    pnt.setRoutPntLocDefCd(strOrgPntCd);
                    pnt.setRcvDeTermCd(strOrgRcvDeTermCd);
                    pnt.setPrcTrspModCd(strOrgPrcTrspModCd);
                    pnt.setCreUsrId(strCreUsrId);
                    pnt.setUpdUsrId(strUpdUsrId);
                    
                    pntVoList.add(pnt);
                }
                if (strOrgViaCd != null && !"".equals(strOrgViaCd)) {
                    nextRoutViaSeq++;

                    via = new PriSgRtRoutViaVO();
                    
                    via.setPrcCustTpCd(strPrcCustTpCd);
                    via.setGlineSeq(strGlineSeq);
                    via.setSvcScpCd(strSvcScpCd);
                    via.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
                    via.setRoutSeq(String.valueOf(nextRoutSeq));
                    via.setOrgDestTpCd("O");
                    via.setRoutViaSeq(String.valueOf(nextRoutViaSeq));
                    via.setRoutViaPortTpCd(strOrgViaCd.length() == 4 ? "G" : "L");
                    via.setRoutViaPortDefCd(strOrgViaCd);
                    via.setCreUsrId(strCreUsrId);
                    via.setUpdUsrId(strUpdUsrId);
                    
                    viaVoList.add(via);
                }
                if (strDestViaCd != null && !"".equals(strDestViaCd)) {
                    nextRoutViaSeq++;

                    via = new PriSgRtRoutViaVO();
                    
                    via.setPrcCustTpCd(strPrcCustTpCd);
                    via.setGlineSeq(strGlineSeq);
                    via.setSvcScpCd(strSvcScpCd);
                    via.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
                    via.setRoutSeq(String.valueOf(nextRoutSeq));
                    via.setOrgDestTpCd("D");
                    via.setRoutViaSeq(String.valueOf(nextRoutViaSeq));
                    via.setRoutViaPortTpCd(strDestViaCd.length() == 4 ? "G" : "L");
                    via.setRoutViaPortDefCd(strDestViaCd);
                    via.setCreUsrId(strCreUsrId);
                    via.setUpdUsrId(strUpdUsrId);
                    
                    viaVoList.add(via);
                }
                if (strDestPntCd != null && !"".equals(strDestPntCd)) {
                    nextRoutPntSeq++;

                    pnt = new PriSgRtRoutPntVO();
                    
                    pnt.setPrcCustTpCd(strPrcCustTpCd);
                    pnt.setGlineSeq(strGlineSeq);
                    pnt.setSvcScpCd(strSvcScpCd);
                    pnt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
                    pnt.setRoutSeq(String.valueOf(nextRoutSeq));
                    pnt.setOrgDestTpCd("D");
                    pnt.setRoutPntSeq(String.valueOf(nextRoutPntSeq));
                    pnt.setRoutPntLocTpCd(strDestPntCd.length() == 4 ? "G" : "L");
                    pnt.setRoutPntLocDefCd(strDestPntCd);
                    pnt.setRcvDeTermCd(strDestRcvDeTermCd);
                    pnt.setPrcTrspModCd(strDestPrcTrspModCd);
                    pnt.setCreUsrId(strCreUsrId);
                    pnt.setUpdUsrId(strUpdUsrId);
                    
                    pntVoList.add(pnt);
                }
                
                if (strRateAmt != null && !"".equals(strRateAmt)) {
                    nextRtSeq++;

                    rt = new PriSgRtVO();
                    
                    rt.setPrcCustTpCd(strPrcCustTpCd);
                    rt.setGlineSeq(strGlineSeq);
                    rt.setSvcScpCd(strSvcScpCd);
                    rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
                    rt.setRoutSeq(String.valueOf(nextRoutSeq));
                    rt.setRtSeq(String.valueOf(nextRtSeq));
                    rt.setMqcRngFmQty(strMqcRngFmQty);
                    rt.setMqcRngToQty(strMqcRngToQty);
                    rt.setRatUtCd(strPerTypeCd);
                    rt.setPrcCgoTpCd(strCgoTypeCd);
                    rt.setCurrCd("USD");
                    rt.setFrtRtAmt(strRateAmt);
                    rt.setCreUsrId(strCreUsrId);
                    rt.setUpdUsrId(strUpdUsrId);

                    rtVoList.add(rt);
                }
            }
            
            if (cmdtHdrVoList.size() > 0) {
                dbDao.addRateCommodityHeader(cmdtHdrVoList);
            }
            if (cmdtVoList.size() > 0) {
                dbDao.addRateCommodity(cmdtVoList);
            }
            
            if (routVoList.size() > 0) {
                dbDao.addRateCommodityRoute(routVoList);
            }
            if (pntVoList.size() > 0) {
                dbDao.addRateRoutePoint(pntVoList);
            }
            if (viaVoList.size() > 0) {
                dbDao.addRateRouteVia(viaVoList);
            }
            
            if (rtVoList.size() > 0) {
                dbDao.addRate(rtVoList);
            }
            
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

	/**
	 * S/C Guideline MQC list retrieving<br>
	 * 
	 * @param PriSgRtMqcRngVO priSgRtMqcRngVO
	 * @return List<PriSgRtMqcRngVO>
	 * @exception EventException
	 */
	public List<PriSgRtMqcRngVO> searchRateMQCRangeList(PriSgRtMqcRngVO priSgRtMqcRngVO) throws EventException {
		try {
			return dbDao.searchRateMQCRangeList(priSgRtMqcRngVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * creating Guideline MQC <br>
	 * 
	 * @param PriSgRtMqcRngVO[] priSgRtMqcRngVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRateMQCRange(PriSgRtMqcRngVO[] priSgRtMqcRngVOs, SignOnUserAccount account) throws EventException {
		try {
			for (int i = 0; i < priSgRtMqcRngVOs.length; i++) {
				if (priSgRtMqcRngVOs[i].getIbflag().equals("I")) {
					priSgRtMqcRngVOs[i].setCreUsrId(account.getUsr_id());
					dbDao.addRateMQCRange(priSgRtMqcRngVOs[i]);
				} else if (priSgRtMqcRngVOs[i].getIbflag().equals("U")) {
					priSgRtMqcRngVOs[i].setUpdUsrId(account.getUsr_id());
					dbDao.modifyRateMQCRange(priSgRtMqcRngVOs[i]);
				} else if (priSgRtMqcRngVOs[i].getIbflag().equals("D")) {
					dbDao.removeRateMQCRange(priSgRtMqcRngVOs[i]);
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}


	/**
	 * deleting Guideline at Guideline Main<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @exception EventException
	 */
	public void removeGuidelineMain(PriSgMnVO priSgMnVO) throws EventException {
		try {
			dbDao.removeGuidelineMainRate(priSgMnVO);
			dbDao.removeGuidelineMainRateRoutePoint(priSgMnVO);
			dbDao.removeGuidelineMainRateRouteVia(priSgMnVO);
			dbDao.removeGuidelineMainRateCommodityRnote(priSgMnVO);
			dbDao.removeGuidelineMainRateCommodityRoute(priSgMnVO);
			dbDao.removeGuidelineMainRateCommodity(priSgMnVO);
			dbDao.removeGuidelineMainRateCommodityHdr(priSgMnVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Rate Guideline Copying <br>
	 * 
	 * @param GlineMnCpVO glineMnCpVO
	 * @exception EventException
	 */
	public void copyGuidelineMain(GlineMnCpVO glineMnCpVO) throws EventException {
		try {
			dbDao.addGuidelineMainRateCommodityHeaderCopy(glineMnCpVO);
			dbDao.addGuidelineMainRateCommodityCopy(glineMnCpVO);
			dbDao.addGuidelineMainRateCommodityRouteCopy(glineMnCpVO);
			dbDao.addGuidelineMainRateCommodityRnoteCopy(glineMnCpVO);
			dbDao.addGuidelineMainRateRouteViaCopy(glineMnCpVO);
			dbDao.addGuidelineMainRateRoutePointCopy(glineMnCpVO);
			dbDao.addGuidelineMainRateCopy(glineMnCpVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
}