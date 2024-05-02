/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RFARateGuidelineBCImpl.java
 *@FileTitle : RFA Rate Guideline Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfaguidelinemain.vo.RsltRfaGlineCopyVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.integration.RFARateGuidelineDBDAO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.vo.RfaRtGlineCmdtVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.vo.RfaRtGlineRoutVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.vo.RsltRfaRtListHorizontalExcelVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.vo.RsltRfaRtListVerticalExcelVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.vo.RsltRtCmdtListVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.vo.RsltRtListExcelVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.vo.RsltRtRoutHdrListVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.vo.RsltRtRoutListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriRgMnVO;
import com.clt.syscommon.common.table.PriRgRtCmdtHdrVO;
import com.clt.syscommon.common.table.PriRgRtCmdtRoutVO;
import com.clt.syscommon.common.table.PriRgRtCmdtVO;
import com.clt.syscommon.common.table.PriRgRtRoutPntVO;
import com.clt.syscommon.common.table.PriRgRtRoutViaVO;
import com.clt.syscommon.common.table.PriRgRtVO;

/**
 * RFAGuideline Business Logic Basic Command implementation<br>
 * - handling biz logic about RFAGuideline<br>
 * 
 * @author 
 * @see UI_PRI_0030EventResponse,SCRateGuidelineBC reference each DAO class
 * @since J2EE 1.4
 */

public class RFARateGuidelineBCImpl extends BasicCommandSupport implements RFARateGuidelineBC {

	// Database Access Object
	private transient RFARateGuidelineDBDAO dbDao = null;

	/**
	 * SCRateGuidelineBCImpl object creation<br>
	 * creating SCRateGuidelineDBDAO
	 */
	public RFARateGuidelineBCImpl() {
		dbDao = new RFARateGuidelineDBDAO();
	}

	/**
	 * Retrieving Rate Guideline Commodity<br>
	 * 
	 * @param PriRgRtCmdtHdrVO rgVo
	 * @return RsltRtCmdtListVO
	 * @exception EventException
	 */
	public RsltRtCmdtListVO searchRateCommodityList(PriRgRtCmdtHdrVO rgVo) throws EventException {
		RsltRtCmdtListVO vo = new RsltRtCmdtListVO();

		try {
			vo.setRsltRtCmdtHdrListVOS(dbDao.searchRateCommodityHeaderList(rgVo));
			vo.setRsltRtCmdtDetailVOS(dbDao.searchRateCommodityDetailList(rgVo));

			return vo;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Retrieving Rate Guideline Route List<br>
	 * 
	 * @param PriRgRtCmdtRoutVO vo
	 * @return List<RsltRtRoutHdrListVO>
	 * @exception EventException
	 */
	public List<RsltRtRoutHdrListVO> searchRateRouteList(PriRgRtCmdtRoutVO vo) throws EventException {
		try {
			return dbDao.searchRateRouteHeaderList(vo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Retrieving Rate Guideline Rate List<br>
	 * 
	 * @param PriRgRtVO rtVo
	 * @return RsltRtRoutListVO
	 * @exception EventException
	 */
	public RsltRtRoutListVO searchRateList(PriRgRtVO rtVo) throws EventException {
		RsltRtRoutListVO vo = new RsltRtRoutListVO();
		try {
			vo.setRsltRtListVOS(dbDao.searchRateList(rtVo));
			vo.setOrgRsltRtRoutPntListVOS(dbDao.searchRateRouteOriginPointList(rtVo));
			vo.setOrgRsltRtRoutViaListVOS(dbDao.searchRateRouteOriginViaList(rtVo));
			vo.setDestRsltRtRoutViaListVOS(dbDao.searchRateRouteDestinationViaList(rtVo));
			vo.setDestRsltRtRoutPntListVOS(dbDao.searchRateRouteDestinationPointList(rtVo));

			return vo;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Retrieving Rate Guideline Excel Download List<br>
	 * 
	 * @param PriRgRtCmdtHdrVO vo
	 * @return List<RsltRtListExcelVO>
	 * @exception EventException
	 */
	public List<RsltRtListExcelVO> searchRateListExcel(PriRgRtCmdtHdrVO vo) throws EventException {
		try {
			return dbDao.searchRateListExcel(vo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * handling Rate Commodity Header data's CUD transaction <br>
	 * 
	 * @param RfaRtGlineCmdtVO cmdtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRateCommodity(RfaRtGlineCmdtVO cmdtVO, SignOnUserAccount account) throws EventException {
		try {
			PriRgRtCmdtHdrVO[] vo = cmdtVO.getPriRgRtCmdtHdrVOS();
			PriRgRtCmdtVO[] dtlvo = cmdtVO.getPriRgRtCmdtVOS();

			List<PriRgRtCmdtHdrVO> insertVoList = new ArrayList<PriRgRtCmdtHdrVO>();
			List<PriRgRtCmdtHdrVO> updateVoList = new ArrayList<PriRgRtCmdtHdrVO>();
			List<PriRgRtCmdtHdrVO> deleteVoList = new ArrayList<PriRgRtCmdtHdrVO>();
			List<PriRgRtCmdtVO> insertDtlVoList = new ArrayList<PriRgRtCmdtVO>();
			List<PriRgRtCmdtVO> updateDtlVoList = new ArrayList<PriRgRtCmdtVO>();
			List<PriRgRtCmdtVO> deleteDtlVoList = new ArrayList<PriRgRtCmdtVO>();

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
	 * handling Rate Commodity - Route data's CUD transaction <br>
	 * 
	 * @param RfaRtGlineRoutVO vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRateRoute(RfaRtGlineRoutVO vo, SignOnUserAccount account) throws EventException {
		try {
			PriRgRtCmdtRoutVO[] routvo = vo.getPriRgRtCmdtRoutVOS();
			PriRgRtRoutPntVO[] orgpntvo = vo.getPriRgRtRoutOrgPntVOS();
			PriRgRtRoutViaVO[] orgviavo = vo.getPriRgRtRoutOrgViaVOS();
			PriRgRtRoutViaVO[] destviavo = vo.getPriRgRtRoutDestViaVOS();
			PriRgRtRoutPntVO[] destpntvo = vo.getPriRgRtRoutDestPntVOS();
			PriRgRtVO[] rtvo = vo.getPriRgRtVOS();

			List<PriRgRtCmdtRoutVO> insertRoutList = new ArrayList<PriRgRtCmdtRoutVO>();
			List<PriRgRtCmdtRoutVO> updateRoutList = new ArrayList<PriRgRtCmdtRoutVO>();
			List<PriRgRtCmdtRoutVO> deleteRoutList = new ArrayList<PriRgRtCmdtRoutVO>();
			List<PriRgRtRoutPntVO> insertPntList = new ArrayList<PriRgRtRoutPntVO>();
			List<PriRgRtRoutPntVO> updatePntList = new ArrayList<PriRgRtRoutPntVO>();
			List<PriRgRtRoutPntVO> deletePntList = new ArrayList<PriRgRtRoutPntVO>();
			List<PriRgRtRoutViaVO> insertViaList = new ArrayList<PriRgRtRoutViaVO>();
			List<PriRgRtRoutViaVO> updateViaList = new ArrayList<PriRgRtRoutViaVO>();
			List<PriRgRtRoutViaVO> deleteViaList = new ArrayList<PriRgRtRoutViaVO>();
			List<PriRgRtVO> insertRtList = new ArrayList<PriRgRtVO>();
			List<PriRgRtVO> updateRtList = new ArrayList<PriRgRtVO>();
			List<PriRgRtVO> deleteRtList = new ArrayList<PriRgRtVO>();

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
			if (updateRtList.size() > 0) {
				dbDao.modifyRate(updateRtList);
			}

			if (deleteRtList.size() > 0) {
				dbDao.removeRate(deleteRtList);
			}
			if (deleteViaList.size() > 0) {
				dbDao.removeRateRouteVia(deleteViaList);
			}
			if (deletePntList.size() > 0) {
				dbDao.removeRateRoutePoint(deletePntList);
			}
			if (deleteRoutList.size() > 0) {
				dbDao.removeRateCommodityRouteCascadeRt(deleteRoutList);
				dbDao.removeRateCommodityRouteCascadeRoutVia(deleteRoutList);
				dbDao.removeRateCommodityRouteCascadeRoutPnt(deleteRoutList);
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
	 * Deleting Guideline in Guideline Main <br>
	 * 
	 * @param PriRgMnVO vo
	 * @exception EventException
	 */
	public void removeGuidelineMain(PriRgMnVO vo) throws EventException {
		try {
			dbDao.removeGuidelineMainRate(vo);
			dbDao.removeGuidelineMainRateRoutePoint(vo);
			dbDao.removeGuidelineMainRateRouteVia(vo);
			dbDao.removeGuidelineMainRateCommodityRoute(vo);
			dbDao.removeGuidelineMainRateCommodity(vo);
			dbDao.removeGuidelineMainRateCommodityHdr(vo);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}

    /**
     * checking RFA Guideline Rate Vertical Excel's compatibility<br>
     * 
     * @param PriRgRtCmdtHdrVO priRgRtCmdtHdrVO
     * @param RsltRfaRtListVerticalExcelVO[] rsltRfaRtListVerticalExcelVOs
     * @return List<RsltCdListVO>
     * @exception EventException
     */
    public List<RsltCdListVO> checkRateExcelVertical(PriRgRtCmdtHdrVO priRgRtCmdtHdrVO, RsltRfaRtListVerticalExcelVO[] rsltRfaRtListVerticalExcelVOs) throws EventException {
        List<RsltCdListVO> rslt = new ArrayList<RsltCdListVO>();
        try {
            String strCmdtCd    = null;
            String strOrgPntCd  = null;
            String strOrgViaCd  = null;
            String strDestViaCd = null;
            String strDestPntCd = null;
            RsltRfaRtListVerticalExcelVO row = null;

            for (int i = 0; i < rsltRfaRtListVerticalExcelVOs.length; i++) {
                row = rsltRfaRtListVerticalExcelVOs[i];
                
                strCmdtCd = row.getPrcCmdtDefCd();
                strOrgPntCd = row.getOrgRoutPntLocDefCd();
                strOrgViaCd = row.getOrgRoutViaPortDefCd();
                strDestViaCd = row.getDestRoutViaPortDefCd();
                strDestPntCd = row.getDestRoutPntLocDefCd();
                
                if (strCmdtCd != null && !"".equals(strCmdtCd)) {
                    RsltCdListVO paramVO = new RsltCdListVO();
                    paramVO.setGlineSeq(priRgRtCmdtHdrVO.getGlineSeq());
                    paramVO.setSvcScpCd(priRgRtCmdtHdrVO.getSvcScpCd());
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
                    paramVO.setGlineSeq(priRgRtCmdtHdrVO.getGlineSeq());
                    paramVO.setSvcScpCd(priRgRtCmdtHdrVO.getSvcScpCd());
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
                    paramVO.setGlineSeq(priRgRtCmdtHdrVO.getGlineSeq());
                    paramVO.setSvcScpCd(priRgRtCmdtHdrVO.getSvcScpCd());
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
                    paramVO.setGlineSeq(priRgRtCmdtHdrVO.getGlineSeq());
                    paramVO.setSvcScpCd(priRgRtCmdtHdrVO.getSvcScpCd());
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
                    paramVO.setGlineSeq(priRgRtCmdtHdrVO.getGlineSeq());
                    paramVO.setSvcScpCd(priRgRtCmdtHdrVO.getSvcScpCd());
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
     * creating RFA Guideline Rate by RFA Guideline Rate Vertical Excel<br>
     * 
     * @param PriRgRtCmdtHdrVO priRgRtCmdtHdrVO
     * @param RsltRfaRtListVerticalExcelVO[] rsltRfaRtListVerticalExcelVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void uploadRateExcelVertical(PriRgRtCmdtHdrVO priRgRtCmdtHdrVO, RsltRfaRtListVerticalExcelVO[] rsltRfaRtListVerticalExcelVOs, SignOnUserAccount account) throws EventException {
        List<PriRgRtCmdtHdrVO> cmdtHdrVoList = new ArrayList<PriRgRtCmdtHdrVO>();
        List<PriRgRtCmdtVO> cmdtVoList = new ArrayList<PriRgRtCmdtVO>();
        List<PriRgRtCmdtRoutVO> routVoList = new ArrayList<PriRgRtCmdtRoutVO>();
        List<PriRgRtRoutPntVO> pntVoList = new ArrayList<PriRgRtRoutPntVO>();
        List<PriRgRtRoutViaVO> viaVoList = new ArrayList<PriRgRtRoutViaVO>();
        List<PriRgRtVO> rtVoList = new ArrayList<PriRgRtVO>();

        try {
            int nextCmdtHdrSeq = dbDao.searchNextCmdtHdrSeq(priRgRtCmdtHdrVO);
            int nextCmdtSeq = 0;
            
            int nextRoutSeq = 0;
            int nextRoutPntSeq = 0;
            int nextRoutViaSeq = 0;
            int nextRtSeq = 0;
            
            String strGlineSeq = priRgRtCmdtHdrVO.getGlineSeq();
            String strSvcScpCd = priRgRtCmdtHdrVO.getSvcScpCd();
            String strEffDt = priRgRtCmdtHdrVO.getEffDt();
            String strExpDt = priRgRtCmdtHdrVO.getExpDt();
            String strCreUsrId = account.getUsr_id();
            String strUpdUsrId = account.getUsr_id();

            RsltRfaRtListVerticalExcelVO row = null;
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
            
            String strPerTypeCd = null;
            String strCgoTypeCd = null;
            String strRateAmt = null;
            
            PriRgRtCmdtHdrVO cmdtHdr = null;
            PriRgRtCmdtVO cmdt = null;
            PriRgRtCmdtRoutVO rout = null;
            PriRgRtRoutPntVO pnt = null;
            PriRgRtRoutViaVO via = null;
            PriRgRtVO rt = null;

            for (int i = 0; i < rsltRfaRtListVerticalExcelVOs.length; i++) {
                row = rsltRfaRtListVerticalExcelVOs[i];
                
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

                strPerTypeCd = row.getRatUtCd();
                strCgoTypeCd = row.getPrcCgoTpCd();
                strRateAmt = row.getFrtRtAmt();
                
                if (strCmdtDpSeq != null && !"".equals(strCmdtDpSeq)) {
                    nextCmdtHdrSeq++;
                    nextCmdtSeq = 0;
                    nextRoutSeq = 0;
                    
                    cmdtHdr = new PriRgRtCmdtHdrVO();
                    
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
                    
                    cmdt = new PriRgRtCmdtVO();
                    cmdt.setGlineSeq(strGlineSeq);
                    cmdt.setSvcScpCd(strSvcScpCd);
                    cmdt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
                    cmdt.setCmdtSeq(String.valueOf(nextCmdtSeq));
                    cmdt.setPrcCmdtTpCd(strCmdtCd.length() == 5 ? "G" : (strCmdtCd.length() == 4 ? "R" : "C"));
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
                    
                    rout = new PriRgRtCmdtRoutVO();
                    rout.setGlineSeq(strGlineSeq);
                    rout.setSvcScpCd(strSvcScpCd);
                    rout.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
                    rout.setRoutSeq(String.valueOf(nextRoutSeq));
                    rout.setDirCallFlg("N");
                    rout.setCreUsrId(strCreUsrId);
                    rout.setUpdUsrId(strUpdUsrId);

                    routVoList.add(rout);
                }
                
                if (strOrgPntCd != null && !"".equals(strOrgPntCd)) {
                    nextRoutPntSeq++;

                    pnt = new PriRgRtRoutPntVO();
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

                    via = new PriRgRtRoutViaVO();
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

                    via = new PriRgRtRoutViaVO();
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

                    pnt = new PriRgRtRoutPntVO();
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

                    rt = new PriRgRtVO();
                    rt.setGlineSeq(strGlineSeq);
                    rt.setSvcScpCd(strSvcScpCd);
                    rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
                    rt.setRoutSeq(String.valueOf(nextRoutSeq));
                    rt.setRtSeq(String.valueOf(nextRtSeq));
                    rt.setMqcRngFmQty("1");
                    rt.setMqcRngToQty("999999");
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
     * checking RFA Guideline Rate Horizontal Excel's compatibility<br>
     * 
     * @param PriRgRtCmdtHdrVO priRgRtCmdtHdrVO
     * @param RsltRfaRtListHorizontalExcelVO[] rsltRfaRtListHorizontalExcelVOs
     * @return List<RsltCdListVO>
     * @exception EventException
     */
    public List<RsltCdListVO> checkRateExcelHorizontal(PriRgRtCmdtHdrVO priRgRtCmdtHdrVO, RsltRfaRtListHorizontalExcelVO[] rsltRfaRtListHorizontalExcelVOs) throws EventException {
        List<RsltCdListVO> rslt = new ArrayList<RsltCdListVO>();
        
        try {
            RsltRfaRtListHorizontalExcelVO row = null;
            String strCmdtCd = null;
            String strOrgPntCd = null;
            String strOrgViaCd = null;
            String strDestViaCd = null;
            String strDestPntCd = null;

            for (int i = 0; i < rsltRfaRtListHorizontalExcelVOs.length; i++) {
                row = rsltRfaRtListHorizontalExcelVOs[i];
                
                strCmdtCd = row.getPrcCmdtDefCd();
                strOrgPntCd = row.getOrgRoutPntLocDefCd();
                strOrgViaCd = row.getOrgRoutViaPortDefCd();
                strDestViaCd = row.getDestRoutViaPortDefCd();
                strDestPntCd = row.getDestRoutPntLocDefCd();
                
                if (strCmdtCd != null && !"".equals(strCmdtCd)) {
                    RsltCdListVO paramVO = new RsltCdListVO();
                    paramVO.setGlineSeq(priRgRtCmdtHdrVO.getGlineSeq());
                    paramVO.setSvcScpCd(priRgRtCmdtHdrVO.getSvcScpCd());
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
                    paramVO.setGlineSeq(priRgRtCmdtHdrVO.getGlineSeq());
                    paramVO.setSvcScpCd(priRgRtCmdtHdrVO.getSvcScpCd());
                    paramVO.setCd(strOrgPntCd);
                    
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
                    paramVO.setGlineSeq(priRgRtCmdtHdrVO.getGlineSeq());
                    paramVO.setSvcScpCd(priRgRtCmdtHdrVO.getSvcScpCd());
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
                    paramVO.setGlineSeq(priRgRtCmdtHdrVO.getGlineSeq());
                    paramVO.setSvcScpCd(priRgRtCmdtHdrVO.getSvcScpCd());
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
                    paramVO.setGlineSeq(priRgRtCmdtHdrVO.getGlineSeq());
                    paramVO.setSvcScpCd(priRgRtCmdtHdrVO.getSvcScpCd());
                    paramVO.setCd(strDestPntCd);
                    
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
     * creating RFA Guideline Rate by RFA Guideline Rate Horizontal Excel<br>
     * 
     * @param PriRgRtCmdtHdrVO priRgRtCmdtHdrVO
     * @param RsltRfaRtListHorizontalExcelVO[] rsltRfaRtListHorizontalExcelVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void uploadRateExcelHorizontal(PriRgRtCmdtHdrVO priRgRtCmdtHdrVO, RsltRfaRtListHorizontalExcelVO[] rsltRfaRtListHorizontalExcelVOs, SignOnUserAccount account) throws EventException {
        List<PriRgRtCmdtHdrVO> cmdtHdrVoList = new ArrayList<PriRgRtCmdtHdrVO>();
        List<PriRgRtCmdtVO> cmdtVoList = new ArrayList<PriRgRtCmdtVO>();
        List<PriRgRtCmdtRoutVO> routVoList = new ArrayList<PriRgRtCmdtRoutVO>();
        List<PriRgRtRoutPntVO> pntVoList = new ArrayList<PriRgRtRoutPntVO>();
        List<PriRgRtRoutViaVO> viaVoList = new ArrayList<PriRgRtRoutViaVO>();
        List<PriRgRtVO> rtVoList = new ArrayList<PriRgRtVO>();

        try {
            int nextCmdtHdrSeq = dbDao.searchNextCmdtHdrSeq(priRgRtCmdtHdrVO);
            int nextCmdtSeq = 0;
            
            int nextRoutSeq = 0;
            int nextRoutPntSeq = 0;
            int nextRoutViaSeq = 0;
            int nextRtSeq = 0;
            
            String strGlineSeq = priRgRtCmdtHdrVO.getGlineSeq();
            String strSvcScpCd = priRgRtCmdtHdrVO.getSvcScpCd();
            String strEffDt = priRgRtCmdtHdrVO.getEffDt();
            String strExpDt = priRgRtCmdtHdrVO.getExpDt();
            String strCreUsrId = account.getUsr_id();
            String strUpdUsrId = account.getUsr_id();
            RsltRfaRtListHorizontalExcelVO row = null;

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
            
            String strRateDry20 = null;
            String strRateDry40 = null;
            String strRateDry40hc = null;
            String strRateDry45 = null;
            String strRateRf40hc = null;

            PriRgRtCmdtHdrVO cmdtHdr = null;
            PriRgRtCmdtVO cmdt = null;
            PriRgRtCmdtRoutVO rout = null;
            PriRgRtRoutPntVO pnt = null;
            PriRgRtRoutViaVO via = null;
            PriRgRtVO rt = null;
            
            for (int i = 0; i < rsltRfaRtListHorizontalExcelVOs.length; i++) {
                row = rsltRfaRtListHorizontalExcelVOs[i];
                
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
                
                strRateDry20 = row.getRateDry20();
                strRateDry40 = row.getRateDry40();
                strRateDry40hc = row.getRateDry40hc();
                strRateDry45 = row.getRateDry45();
                strRateRf40hc = row.getRateRf40hc();
                
                if (strCmdtDpSeq != null && !"".equals(strCmdtDpSeq)) {
                    nextCmdtHdrSeq++;
                    nextCmdtSeq = 0;
                    nextRoutSeq = 0;
                    
                    cmdtHdr = new PriRgRtCmdtHdrVO();
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
                    
                    cmdt = new PriRgRtCmdtVO();
                    cmdt.setGlineSeq(strGlineSeq);
                    cmdt.setSvcScpCd(strSvcScpCd);
                    cmdt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
                    cmdt.setCmdtSeq(String.valueOf(nextCmdtSeq));
                    cmdt.setPrcCmdtTpCd(strCmdtCd.length() == 5 ? "G" : (strCmdtCd.length() == 4 ? "R" : "C"));
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
                    
                    rout = new PriRgRtCmdtRoutVO();
                    rout.setGlineSeq(strGlineSeq);
                    rout.setSvcScpCd(strSvcScpCd);
                    rout.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
                    rout.setRoutSeq(String.valueOf(nextRoutSeq));
                    rout.setDirCallFlg("N");
                    rout.setCreUsrId(strCreUsrId);
                    rout.setUpdUsrId(strUpdUsrId);
                    
                    routVoList.add(rout);
                }
                
                if (strOrgPntCd != null && !"".equals(strOrgPntCd)) {
                    nextRoutPntSeq++;
                    
                    pnt = new PriRgRtRoutPntVO();
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
                    
                    via = new PriRgRtRoutViaVO();
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
                    
                    via = new PriRgRtRoutViaVO();
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
                    
                    pnt = new PriRgRtRoutPntVO();
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
                
                if (strRateDry20 != null && !"".equals(strRateDry20)) {
                    nextRtSeq++;
                    
                    rt = new PriRgRtVO();
                    rt.setGlineSeq(strGlineSeq);
                    rt.setSvcScpCd(strSvcScpCd);
                    rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
                    rt.setRoutSeq(String.valueOf(nextRoutSeq));
                    rt.setRtSeq(String.valueOf(nextRtSeq));
                    rt.setMqcRngFmQty("1");
                    rt.setMqcRngToQty("999999");
                    rt.setRatUtCd("D2");
                    rt.setPrcCgoTpCd("DR");
                    rt.setCurrCd("USD");
                    rt.setFrtRtAmt(strRateDry20);
                    rt.setCreUsrId(strCreUsrId);
                    rt.setUpdUsrId(strUpdUsrId);
                    
                    rtVoList.add(rt);
                }
                
                if (strRateDry40 != null && !"".equals(strRateDry40)) {
                    nextRtSeq++;
                    
                    rt = new PriRgRtVO();
                    rt.setGlineSeq(strGlineSeq);
                    rt.setSvcScpCd(strSvcScpCd);
                    rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
                    rt.setRoutSeq(String.valueOf(nextRoutSeq));
                    rt.setRtSeq(String.valueOf(nextRtSeq));
                    rt.setMqcRngFmQty("1");
                    rt.setMqcRngToQty("999999");
                    rt.setRatUtCd("D4");
                    rt.setPrcCgoTpCd("DR");
                    rt.setCurrCd("USD");
                    rt.setFrtRtAmt(strRateDry40);
                    rt.setCreUsrId(strCreUsrId);
                    rt.setUpdUsrId(strUpdUsrId);
                    
                    rtVoList.add(rt);
                }

                if (strRateDry40hc != null && !"".equals(strRateDry40hc)) {
                    nextRtSeq++;
                    
                    rt = new PriRgRtVO();
                    rt.setGlineSeq(strGlineSeq);
                    rt.setSvcScpCd(strSvcScpCd);
                    rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
                    rt.setRoutSeq(String.valueOf(nextRoutSeq));
                    rt.setRtSeq(String.valueOf(nextRtSeq));
                    rt.setMqcRngFmQty("1");
                    rt.setMqcRngToQty("999999");
                    rt.setRatUtCd("D5");
                    rt.setPrcCgoTpCd("DR");
                    rt.setCurrCd("USD");
                    rt.setFrtRtAmt(strRateDry40hc);
                    rt.setCreUsrId(strCreUsrId);
                    rt.setUpdUsrId(strUpdUsrId);
                    
                    rtVoList.add(rt);
                }

                if (strRateDry45 != null && !"".equals(strRateDry45)) {
                    nextRtSeq++;
                    
                    rt = new PriRgRtVO();
                    rt.setGlineSeq(strGlineSeq);
                    rt.setSvcScpCd(strSvcScpCd);
                    rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
                    rt.setRoutSeq(String.valueOf(nextRoutSeq));
                    rt.setRtSeq(String.valueOf(nextRtSeq));
                    rt.setMqcRngFmQty("1");
                    rt.setMqcRngToQty("999999");
                    rt.setRatUtCd("D7");
                    rt.setPrcCgoTpCd("DR");
                    rt.setCurrCd("USD");
                    rt.setFrtRtAmt(strRateDry45);
                    rt.setCreUsrId(strCreUsrId);
                    rt.setUpdUsrId(strUpdUsrId);
                    
                    rtVoList.add(rt);
                }

                if (strRateRf40hc != null && !"".equals(strRateRf40hc)) {
                    nextRtSeq++;
                    
                    rt = new PriRgRtVO();
                    rt.setGlineSeq(strGlineSeq);
                    rt.setSvcScpCd(strSvcScpCd);
                    rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
                    rt.setRoutSeq(String.valueOf(nextRoutSeq));
                    rt.setRtSeq(String.valueOf(nextRtSeq));
                    rt.setMqcRngFmQty("1");
                    rt.setMqcRngToQty("999999");
                    rt.setRatUtCd("R5");
                    rt.setPrcCgoTpCd("RF");
                    rt.setCurrCd("USD");
                    rt.setFrtRtAmt(strRateRf40hc);
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
     * Retrieving Guideline Rate Vertical Excel Download List<br>
     * 
     * @param PriRgRtCmdtHdrVO priRgRtCmdtHdrVO
     * @return List<RsltRfaRtListVerticalExcelVO>
     * @exception EventException
     */
    public List<RsltRfaRtListVerticalExcelVO> searchRateListVerticalExcel(PriRgRtCmdtHdrVO priRgRtCmdtHdrVO) throws EventException {
        try {
            return dbDao.searchRateListVerticalExcel(priRgRtCmdtHdrVO);
        } catch (DAOException ex) {
        	throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
    }
    
    /**
     * Retrieving Guideline Rate Horizontal Excel Download List<br>
     * 
     * @param PriRgRtCmdtHdrVO priRgRtCmdtHdrVO
     * @return List<RsltRfaRtListHorizontalExcelVO>
     * @exception EventException
     */
    public List<RsltRfaRtListHorizontalExcelVO> searchRateListHorizontalExcel(PriRgRtCmdtHdrVO priRgRtCmdtHdrVO) throws EventException {
        try {
            return dbDao.searchRateListHorizontalExcel(priRgRtCmdtHdrVO);
        } catch (DAOException ex) {
        	throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * copying RFA Guideline Rate<br>
     * 
     * @param RsltRfaGlineCopyVO rsltRfaGlineCopyVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyGuidelineMain(RsltRfaGlineCopyVO rsltRfaGlineCopyVO, SignOnUserAccount account) throws EventException {
        try {
            rsltRfaGlineCopyVO.setCreUsrId(account.getUsr_id());
            rsltRfaGlineCopyVO.setUpdUsrId(account.getUsr_id());
            
            dbDao.addGlineCopyRateCmdtHdr(rsltRfaGlineCopyVO);
            dbDao.addGlineCopyRateCmdt(rsltRfaGlineCopyVO);
            dbDao.addGlineCopyRateCmdtRout(rsltRfaGlineCopyVO);
            dbDao.addGlineCopyRateRoutPnt(rsltRfaGlineCopyVO);
            dbDao.addGlineCopyRateRoutVia(rsltRfaGlineCopyVO);
            dbDao.addGlineCopyRate(rsltRfaGlineCopyVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }
}