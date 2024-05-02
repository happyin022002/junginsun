/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CntrPlanGuidelineManageDBDAO.java
*@FileTitle : Container Guideline Manage
*Open Issues :
*Change history :
* No.	Ver.		Modifier           					modifier date    explanation
* 1     1.0      	SHIN DONG IL						2013.05.27		 Creation
*
*@LastModifyDate : 2013.05.27
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2013.05.27 SHIN DONG IL
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanmtrepoplan.basic;
 
import java.util.ArrayList;
import java.util.List;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

import com.hanjin.apps.alps.ees.eqr.cntrcommon.eqrcommon.vo.CommonVO;
import com.hanjin.apps.alps.ees.eqr.cntrcommon.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanmtrepoplan.event.EesEqr1013Event;
import com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanmtrepoplan.vo.EesEqr1013ConditionVO;
import com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanmtrepoplan.vo.EesEqr1013MtRepoPlanVO;
import com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanmtrepoplan.integration.CntrPlanMTRepoPlanDBDAO;
import com.hanjin.syscommon.common.table.EqrCtrlMtyLodgPlnVO;
import com.hanjin.syscommon.common.table.EqrCtrlMtyDchgPlnVO;
import com.hanjin.syscommon.common.table.EqrCtrlMtyDchgPlnQtyVO;


/**
 * ALPS-GuidelineManage Business Logic Basic Command implementation<br>
 * - ALPS-GuidelineManage에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author SHIN DONG IL
 * @see EES_EQR_1008EventResponse,CntrPlanGuidelineManageBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class CntrPlanMTRepoPlanBCImpl extends BasicCommandSupport implements CntrPlanMTRepoPlanBC {

	// Database Access Object
	private transient CntrPlanMTRepoPlanDBDAO dbDao = null;

	/**
	 * CntrPlanGuidelineManageBCImpl 객체 생성<br>
	 * CntrRepoExecutionPlanEstablishDBDAO를 생성한다.<br>
	 */
	public CntrPlanMTRepoPlanBCImpl() {
		dbDao = new CntrPlanMTRepoPlanDBDAO();
	}

	/**
	 * 화면 Loading시 기본 설정 데이터 조회
	 * @param conditionVO
	 * @return CommonVO
	 * @exception EventException
	 */
	public CommonVO searchLoadingTrendByLaneDefault(EesEqr1013ConditionVO conditionVO) throws EventException {
		CommonVO defaultData = null; 
		try {
			defaultData =dbDao.searchLoadingTrendByLaneDefault(conditionVO);
			return defaultData;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * VVD Combo 대상 조회
	 * @param conditionVO
	 * @return String
	 * @throws EventException
	 */
	public String searchVvdResult(EesEqr1013ConditionVO conditionVO) throws EventException {
//		StringBuffer retval = new StringBuffer();
		List<EesEqr1013ConditionVO> list = null;
		EesEqr1013ConditionVO tmpVO = null;
		
		StringBuffer vvd_cd = new StringBuffer();
		StringBuffer vvd_rslt = new StringBuffer();
		
		try {
			list = dbDao.searchVvdResult(conditionVO);
			for (int i=0; list!=null && list.size()>0 && i<list.size(); i++){
				tmpVO = list.get(i);
				if (tmpVO!=null){
//					if (i==0){
//						vvd_rslt.append("Select");
//					}
					if (i>0){
						vvd_cd.append("|");
						vvd_rslt.append("|");
					}
					vvd_cd.append(JSPUtil.getNull(tmpVO.getSVvdCd()));	
					vvd_rslt.append(JSPUtil.getNull(tmpVO.getVvdRslt()));	
				}
			}
			vvd_cd.toString();
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return JSPUtil.getNull(vvd_cd.toString())+"##"+JSPUtil.getNull(vvd_rslt.toString());
	}

	/**
	 * PlnRsnHdr 조회
	 * @return String
	 * @throws EventException
	 */
	public String searchPlnRsnHdrList() throws EventException {

		String retval = null;

		try {
			retval = dbDao.searchPlnRsnHdrList();
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return retval;
	}
	
	/**
	 * PlnRsnSub 조회
	 * @param condVO
	 * @return String
	 * @throws EventException
	 */
	public String searchPlnRsnSubList(EesEqr1013ConditionVO condVO) throws EventException {

		String retval = null;

		try {
			retval = dbDao.searchPlnRsnSubList(condVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return retval;
	}
	
	/**
	 * Mt Repo Plan data 조회
	 * @param condVO
	 * @return CommonRsVO
	 * @throws EventException
	 */
	public CommonRsVO searchMtyRepoPlanList(EesEqr1013ConditionVO condVO) throws EventException {
		try {
			return dbDao.searchMtyRepoPlanList(condVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Mt Repo Reference data 조회
	 * @param condVO
	 * @return
	 * @throws EventException
	 */
	public CommonRsVO searchMtyRepoRefList(EesEqr1013ConditionVO condVO) throws EventException {
		try {
			return dbDao.searchMtyRepoRefList(condVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Mt Repo Plan data 저장
	 * @param e
	 * @throws EventException
	 */
	public void manageMtRepoPlanInfo(Event e) throws EventException {
		
		EesEqr1013Event	event = (EesEqr1013Event)e;
		EesEqr1013MtRepoPlanVO[] eesEqr1013MtRepoPlanVOs = null;

		SignOnUserAccount account = event.getSignOnUserAccount();

		EqrCtrlMtyLodgPlnVO tmpEqrCtrlMtyLodgPlnVO = null;
		EqrCtrlMtyDchgPlnVO tmpEqrCtrlMtyDchgPlnVO = null;
		EqrCtrlMtyDchgPlnQtyVO tmpEqrCtrlMtyDchgPlnQtyVO = null;
		
		List<EqrCtrlMtyLodgPlnVO> insEqrCtrlMtyLodgPlnVOLst = null;
		List<EqrCtrlMtyDchgPlnVO> insEqrCtrlMtyDchgPlnVOLst = null;
		List<EqrCtrlMtyDchgPlnQtyVO> insEqrCtrlMtyDchgPlnQtyVOLst = null;
		
		EesEqr1013ConditionVO condVO = null;
		String[] cntr_tp_sz = null;
		String strMtyLodgTpszVals = null;
		String[] mtyLodgTpszVals = null;
		String usr_id = null;
		String tmp_pln_rsn_hdr_val = null;
		String tmp_pln_rsn_sub_val = null;
		
		try {
			insEqrCtrlMtyLodgPlnVOLst 		= new ArrayList<EqrCtrlMtyLodgPlnVO>();
			insEqrCtrlMtyDchgPlnVOLst 		= new ArrayList<EqrCtrlMtyDchgPlnVO>();
			insEqrCtrlMtyDchgPlnQtyVOLst 	= new ArrayList<EqrCtrlMtyDchgPlnQtyVO>();
			
			usr_id = account!=null?JSPUtil.getNull(account.getUsr_id()):"";
			condVO = event.getEesEqr1013ConditionVO();
			cntr_tp_sz = condVO!=null?JSPUtil.getNull(condVO.getCntrTpszCd()).split(","):null;
			log.debug("\n\n manageMtRepoPlanInfo - cntr_tp_sz : "+(condVO!=null?JSPUtil.getNull(condVO.getCntrTpszCd()):"")+"------------------\n");
			
			if (cntr_tp_sz!=null && cntr_tp_sz.length>0){
				eesEqr1013MtRepoPlanVOs = event.getEesEqr1013MtRepoPlanVO();
				for (int i=0; eesEqr1013MtRepoPlanVOs!=null && i<eesEqr1013MtRepoPlanVOs.length; i++){
					if (eesEqr1013MtRepoPlanVOs[i]!=null){
						if (eesEqr1013MtRepoPlanVOs[i].getIbflag()!=null && (eesEqr1013MtRepoPlanVOs[i].getIbflag().equals("I") || eesEqr1013MtRepoPlanVOs[i].getIbflag().equals("U"))){
							/** LODG **/
							if (eesEqr1013MtRepoPlanVOs[i].getPodYdCd()!=null && (eesEqr1013MtRepoPlanVOs[i].getPodYdCd().trim().equals("+") || eesEqr1013MtRepoPlanVOs[i].getPodYdCd().trim().equals("-"))){
								tmpEqrCtrlMtyLodgPlnVO = new EqrCtrlMtyLodgPlnVO();
								tmpEqrCtrlMtyLodgPlnVO.setVslCd(eesEqr1013MtRepoPlanVOs[i].getVvdCd().substring(0,4));
								tmpEqrCtrlMtyLodgPlnVO.setSkdVoyNo(eesEqr1013MtRepoPlanVOs[i].getVvdCd().substring(4,8));
								tmpEqrCtrlMtyLodgPlnVO.setSkdDirCd(eesEqr1013MtRepoPlanVOs[i].getVvdCd().substring(8));
								tmpEqrCtrlMtyLodgPlnVO.setPolCd(eesEqr1013MtRepoPlanVOs[i].getPolYdCd().substring(0,5));
								/*------------------------------------------------------------------------------------------*/
								tmpEqrCtrlMtyLodgPlnVO.setPolYdCd(eesEqr1013MtRepoPlanVOs[i].getPolYdCd());
								tmpEqrCtrlMtyLodgPlnVO.setTrdCd(eesEqr1013MtRepoPlanVOs[i].getTrdCd());
								tmpEqrCtrlMtyLodgPlnVO.setSubTrdCd(eesEqr1013MtRepoPlanVOs[i].getSubTrdCd());
								tmpEqrCtrlMtyLodgPlnVO.setVslLaneCd(eesEqr1013MtRepoPlanVOs[i].getSlanCd());
								tmpEqrCtrlMtyLodgPlnVO.setMtyLodgPlnTeuQty(eesEqr1013MtRepoPlanVOs[i].getMtyPlnTeu());// .getMtyLodgPlnTeu());
								tmpEqrCtrlMtyLodgPlnVO.setMtyLodgPlnTonWgt(eesEqr1013MtRepoPlanVOs[i].getMtyPlnTon());// .getMtyLodgPlnTon());
								
								tmp_pln_rsn_hdr_val = eesEqr1013MtRepoPlanVOs[i].getPlnRsnHdrCd();
								tmp_pln_rsn_sub_val = eesEqr1013MtRepoPlanVOs[i].getPlnRsnSubCd();
								log.debug("\n ["+i+"] tmp_pln_rsn_hdr_val: " + JSPUtil.getNull(tmp_pln_rsn_hdr_val) + " \n");
								log.debug("\n ["+i+"] tmp_pln_rsn_sub_val: " + JSPUtil.getNull(tmp_pln_rsn_sub_val) + " \n");
								log.debug("\n ["+i+"] tmp_pln_rsn_sub_val.length: " + (tmp_pln_rsn_sub_val!=null?tmp_pln_rsn_sub_val.trim().length():0) + " \n");
								if (tmp_pln_rsn_sub_val!=null && !tmp_pln_rsn_sub_val.trim().equals("")){ // && tmp_pln_rsn_sub_val.trim().length()==3){
									tmpEqrCtrlMtyLodgPlnVO.setPlnRsnHdrCd(tmp_pln_rsn_sub_val.substring(0,1));
									tmpEqrCtrlMtyLodgPlnVO.setPlnRsnSubCd(tmp_pln_rsn_sub_val.substring(1));
								} else {
									tmpEqrCtrlMtyLodgPlnVO.setPlnRsnHdrCd(JSPUtil.getNull(tmp_pln_rsn_hdr_val));
								}
								
								tmpEqrCtrlMtyLodgPlnVO.setPlnRsnRmk(eesEqr1013MtRepoPlanVOs[i].getPlnRsnRmk());
								if (eesEqr1013MtRepoPlanVOs[i].getFnlCbfFlg().equals("1")){
									tmpEqrCtrlMtyLodgPlnVO.setFnlCbfFlg("Y");	
								} else if (eesEqr1013MtRepoPlanVOs[i].getFnlCbfFlg().equals("0")){
									tmpEqrCtrlMtyLodgPlnVO.setFnlCbfFlg("N");
								}
								tmpEqrCtrlMtyLodgPlnVO.setFnlCbfDt(eesEqr1013MtRepoPlanVOs[i].getFnlCbfDt());
								tmpEqrCtrlMtyLodgPlnVO.setCreUsrId(usr_id);
								tmpEqrCtrlMtyLodgPlnVO.setUpdUsrId(usr_id);
								insEqrCtrlMtyLodgPlnVOLst.add(tmpEqrCtrlMtyLodgPlnVO);
							}
							
							/** DCHG **/
							tmpEqrCtrlMtyDchgPlnVO = new EqrCtrlMtyDchgPlnVO();
							tmpEqrCtrlMtyDchgPlnVO.setVslCd(eesEqr1013MtRepoPlanVOs[i].getVvdCd().substring(0,4));
							tmpEqrCtrlMtyDchgPlnVO.setSkdVoyNo(eesEqr1013MtRepoPlanVOs[i].getVvdCd().substring(4,8));
							tmpEqrCtrlMtyDchgPlnVO.setSkdDirCd(eesEqr1013MtRepoPlanVOs[i].getVvdCd().substring(8));
							tmpEqrCtrlMtyDchgPlnVO.setPolCd(eesEqr1013MtRepoPlanVOs[i].getPolYdCd().substring(0,5));
							tmpEqrCtrlMtyDchgPlnVO.setPodCd(eesEqr1013MtRepoPlanVOs[i].getPodYdCd2().substring(0,5));
							/*------------------------------------------------------------------------------------------*/
							tmpEqrCtrlMtyDchgPlnVO.setPolYdCd(eesEqr1013MtRepoPlanVOs[i].getPolYdCd());
							tmpEqrCtrlMtyDchgPlnVO.setPodYdCd(eesEqr1013MtRepoPlanVOs[i].getPodYdCd2());
							if (eesEqr1013MtRepoPlanVOs[i].getMtyPlnShwFlg().equals("1")){
								tmpEqrCtrlMtyDchgPlnVO.setMtyPlnShwFlg("Y");	
							} else if (eesEqr1013MtRepoPlanVOs[i].getMtyPlnShwFlg().equals("0")){
								tmpEqrCtrlMtyDchgPlnVO.setMtyPlnShwFlg("N");
							}
							tmpEqrCtrlMtyDchgPlnVO.setCreUsrId(usr_id);
							tmpEqrCtrlMtyDchgPlnVO.setUpdUsrId(usr_id);
							insEqrCtrlMtyDchgPlnVOLst.add(tmpEqrCtrlMtyDchgPlnVO);
							
							
							/** DCHG QTY **/
							strMtyLodgTpszVals = JSPUtil.getNull(eesEqr1013MtRepoPlanVOs[i].getMtyLodgTpszVals());
//							log.debug("\n\n strMtyLodgTpszVals : "+JSPUtil.getNull(strMtyLodgTpszVals)+"<<------------------\n");
							if (strMtyLodgTpszVals!=null){
								mtyLodgTpszVals = strMtyLodgTpszVals.split("#");
//								log.debug("\n\n mtyLodgTpszVals.LENGTH : "+(mtyLodgTpszVals!=null?mtyLodgTpszVals.length:0)+"<<------------------\n");
								if (cntr_tp_sz==null){
									throw new Exception("\n [EES_EQR_1013] CNTR TPSZ EXCEPTION!!! \n");
								}
								for (int j=0; cntr_tp_sz!=null && j<cntr_tp_sz.length; j++){
//									log.debug("\n\n : cntr_tp_sz["+j+"]:"+ JSPUtil.getNull(cntr_tp_sz[j])+"<<------------------\n");	
//									log.debug("\n : - mtyLodgTpszVals["+j+"]:"+(mtyLodgTpszVals!=null&&j<=mtyLodgTpszVals.length?JSPUtil.getNull(mtyLodgTpszVals[j]):"0")+"<<------------------\n");
									tmpEqrCtrlMtyDchgPlnQtyVO = new EqrCtrlMtyDchgPlnQtyVO();
									tmpEqrCtrlMtyDchgPlnQtyVO.setVslCd(eesEqr1013MtRepoPlanVOs[i].getVvdCd().substring(0,4));
									tmpEqrCtrlMtyDchgPlnQtyVO.setSkdVoyNo(eesEqr1013MtRepoPlanVOs[i].getVvdCd().substring(4,8));
									tmpEqrCtrlMtyDchgPlnQtyVO.setSkdDirCd(eesEqr1013MtRepoPlanVOs[i].getVvdCd().substring(8));
									tmpEqrCtrlMtyDchgPlnQtyVO.setCntrTpszCd(cntr_tp_sz[j]);
									tmpEqrCtrlMtyDchgPlnQtyVO.setPolCd(eesEqr1013MtRepoPlanVOs[i].getPolYdCd().substring(0,5));
									tmpEqrCtrlMtyDchgPlnQtyVO.setPodCd(eesEqr1013MtRepoPlanVOs[i].getPodYdCd2().substring(0,5));
									/*------------------------------------------------------------------------------------------*/
									tmpEqrCtrlMtyDchgPlnQtyVO.setPolYdCd(eesEqr1013MtRepoPlanVOs[i].getPolYdCd());
									tmpEqrCtrlMtyDchgPlnQtyVO.setPodYdCd(eesEqr1013MtRepoPlanVOs[i].getPodYdCd2());
//									if (mtyLodgTpszVals!=null && j<mtyLodgTpszVals.length){
//										tmpEqrCtrlMtyDchgPlnQtyVO.setCntrQty(JSPUtil.getNull(mtyLodgTpszVals[j]));
//									} else {
//										tmpEqrCtrlMtyDchgPlnQtyVO.setCntrQty("0");
//									}
									tmpEqrCtrlMtyDchgPlnQtyVO.setCntrQty(mtyLodgTpszVals!=null&&j<mtyLodgTpszVals.length?JSPUtil.getNull(mtyLodgTpszVals[j]):"0");
									tmpEqrCtrlMtyDchgPlnQtyVO.setCreUsrId(usr_id);
									tmpEqrCtrlMtyDchgPlnQtyVO.setUpdUsrId(usr_id);
									insEqrCtrlMtyDchgPlnQtyVOLst.add(tmpEqrCtrlMtyDchgPlnQtyVO);
								}
							}
//						} else if (eesEqr1013MtRepoPlanVOs[i].getIbflag()!=null && eesEqr1013MtRepoPlanVOs[i].getIbflag().equals("U")){
//							
						}
					}
				}
				
				if (insEqrCtrlMtyLodgPlnVOLst!=null && insEqrCtrlMtyLodgPlnVOLst.size()>0){
					dbDao.manageMtyLodgPln(insEqrCtrlMtyLodgPlnVOLst);
				}
				if (insEqrCtrlMtyDchgPlnVOLst!=null && insEqrCtrlMtyDchgPlnVOLst.size()>0){
					dbDao.manageMtyDchgPln(insEqrCtrlMtyDchgPlnVOLst);
				}
				if (insEqrCtrlMtyDchgPlnQtyVOLst!=null && insEqrCtrlMtyDchgPlnQtyVOLst.size()>0){
					dbDao.manageMtyDchgPlnQty(insEqrCtrlMtyDchgPlnQtyVOLst);
				}
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
}