/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : InlandRouteManageBCImpl.java
 *@FileTitle : Inland Route 정보관리화면
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-09-04
 *@LastModifier : jungsunyong
 *@LastVersion : 1.0
 * 2006-09-04 jungsunyong
 * 1.0 최초 생성
 * 2012.09.24 정선용  CHM-201220334-01: [PRD] Optimum flag 범위확대 요청
 * 2012.10.25 정선용 [CHM-201220785] [PRD] US-Full Optimum flag Validation 변경요청
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.integration.InlandRouteManageUsaDBDAO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.CheckWrsVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteUSDetVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.SearchConditionVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.SearchInlandRouteManageAsiaEuVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.lnlandRouteUSVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * alps-PRD Business Logic Basic Command implementation<br>
 * - alps-PRD에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author jungsunyong
 * @see ESD_PRD_057EventResponse,InlandRouteManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class InlandRouteManageUsaBCImpl extends BasicCommandSupport implements InlandRouteManageUsaBC{

	// Database Access Object
	private transient InlandRouteManageUsaDBDAO dbDao = null;

	/**
	 * InlandRouteManageBCImpl 객체 생성<br>
	 * InlandRouteManageDBDAO를 생성한다.<br>
	 */
	public InlandRouteManageUsaBCImpl(){
		dbDao = new InlandRouteManageUsaDBDAO();
	}

	/**
	 *  마스터조회 이벤트 처리<br>
	 *  nlandRouteManage화면에 대한 조회 이벤트 처리<br>
	 * @param inlandRouteUSVO
	 * @return
	 * @throws EventException
	 * 2009/08/04 kim kwijin 생성
	 */
	public List<lnlandRouteUSVO> searchInlandRouteMasterUSA(lnlandRouteUSVO inlandRouteUSVO) throws EventException{
		try{
			return dbDao.searchInlandRouteMasterUSA(inlandRouteUSVO);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}


	}

	/**
	 *  상세조회 이벤트 처리<br>
	 *  nlandRouteManage화면에 대한 조회 이벤트 처리<br>
	 * @param searchConditionVO
	 * @return
	 * @throws EventException
	 * 2009/08/05 kim kwijin 생성
	 */
	public List<InlandRouteUSDetVO> searchInlandRouteDetailUSA(SearchConditionVO searchConditionVO) throws EventException{
		try{
			return dbDao.searchInlandRouteDetailUSA(searchConditionVO);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}


	}

	/** (non-Javadoc)
	 * @see com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.basic.InlandRouteManageUsaBC#saveInlandRouteMasterUSA(com.hanjin.framework.core.layer.event.Event)
	 * InlandRouteManageUsaBCImpl's saveInlandRouteMasterUSA
	 * @param inlandRouteUSVO
	 * @param params
	 * @param account
	 * @throws EventException
	 *
	 * 2009-08-07 kim kwijin 수정
	 */
	public void saveInlandRouteMasterUSA(lnlandRouteUSVO[] inlandRouteUSVO, lnlandRouteUSVO params, SignOnUserAccount account) throws EventException{

		try{
			List<lnlandRouteUSVO> deleteVoList = new ArrayList<lnlandRouteUSVO>();
			List<lnlandRouteUSVO> updateVoList = new ArrayList<lnlandRouteUSVO>();
			List<lnlandRouteUSVO> update2VoList = new ArrayList<lnlandRouteUSVO>();
			List<lnlandRouteUSVO> optimumVoList = new ArrayList<lnlandRouteUSVO>();


//			String rInbound = params.getRInbound();

			for(int i = 0; i < inlandRouteUSVO.length; i++){

				inlandRouteUSVO[i].setCreUsrId(account.getUsr_id());
				inlandRouteUSVO[i].setRInbound(params.getRBtnIrgCd());
				inlandRouteUSVO[i].setUpdUsrId(account.getUsr_id());
				inlandRouteUSVO[i].setInlndRoutTmpFlg(inlandRouteUSVO[i].getInlndRoutTmpFlg().equals("1") ? "Y" : "N");
				inlandRouteUSVO[i].setInlndRoutInclSttlFlg(inlandRouteUSVO[i].getInlndRoutInclSttlFlg().equals("1") ? "Y" : "N");
				inlandRouteUSVO[i].setCreOfcCd(account.getOfc_cd());

				log.debug("★★ibflag:" + inlandRouteUSVO[i].getIbflag() + " rout_org_nod_cd:" + inlandRouteUSVO[i].getRoutOrgNodCd());
				log.debug("★★rout_dest_nod_cd:" + inlandRouteUSVO[i].getRoutDestNodCd() + " rout_seq:" + inlandRouteUSVO[i].getRoutSeq());
				log.debug("★★prio_seq:" + inlandRouteUSVO[i].getPrioSeq() + " old_prio_seq:" + inlandRouteUSVO[i].getOldPrioSeq());
				log.debug("★★force_prio_flg:" + inlandRouteUSVO[i].getForcePrioFlg() + " bkgChk:" + inlandRouteUSVO[i].getInlndRoutBkgFlg());
				log.debug("★★wrs_chk:" + inlandRouteUSVO[i].getWrsFullCmdt() + " shttl_inc:" + inlandRouteUSVO[i].getInlndRoutInclSttlFlg() + "\n\n\n");


				if(inlandRouteUSVO[i].getIbflag().equals("D")){
					deleteVoList.add(inlandRouteUSVO[i]);
				}else if(!inlandRouteUSVO[i].getIbflag().equals("D")){
					/*
					 * WRS 를 체크시 PRIO_SEQ 가 1이 아닐때 강제로 '1'로 셋팅한게 있으면(force_prio_flg가 Y 인것) 따로 처리 한다.
					 * 1.기존 PRIO_SEQ가 '1'인게 있으면 OLD_PRIO_SEQ 로 덮어 쓴다.
					 * 2.WRS가 체크 된게 있으면 ''로 리셋시켜논다.
					 * 위작업을 모두 한후 강제로 PRIO_SEQ를 '1'로 , WRS 를 FN으로 업데이트한다.
					 */
					if(inlandRouteUSVO[i].getForcePrioFlg().equals("Y")){
						dbDao.forceWrcFlgSett01(inlandRouteUSVO[i]);
						dbDao.forceWrcFlgSett02(inlandRouteUSVO[i]);
						dbDao.forceWrcFlgSett03(inlandRouteUSVO[i]);
					}

					if(inlandRouteUSVO[i].getWrsFullCmdt().equals("1")){
						CheckWrsVO itm = new CheckWrsVO();

						itm.setRInbound(params.getRBtnIrgCd());
						itm.setRoutDestNodCd(inlandRouteUSVO[i].getRoutDestNodCd());
						itm.setRoutOrgNodCd(inlandRouteUSVO[i].getRoutOrgNodCd());
						itm.setRoutSeq(inlandRouteUSVO[i].getRoutSeq());

						List<CheckWrsVO> checkwrs = dbDao.getChkWrs(itm);


						if(checkwrs.size() >= 1){
							log.debug("★★checkWrs:::::::" + checkwrs.get(0).getWrs() + "\n");
							if(checkwrs.get(0).getWrs().equals("Y")){
								throw new DAOException(new ErrorHandler("PRD00049", " [" + inlandRouteUSVO[i].getRoutDestNodCd() + "-" + inlandRouteUSVO[i].getRoutOrgNodCd() + "]").getMessage());
							}
						}

					}

					log.debug("★★delFlag::::" + params.getIDelFlg());
					if(params.getIDelFlg().equals("Y")){
						//삭제된것을 조회한 대상.
						updateVoList.add(inlandRouteUSVO[i]);
					}else{
						//삭제 되지 않은 것들 대상.  
						update2VoList.add(inlandRouteUSVO[i]);
					}

				}
				
				
				if("1".equals(inlandRouteUSVO[i].getInlndRoutOptmFlg()) && !inlandRouteUSVO[i].getIbflag().equals("D")) {
					optimumVoList.add(inlandRouteUSVO[i]);
				}
			}
			
			if(deleteVoList.size() > 0){
				dbDao.saveInlandRouteMasterUSA01(deleteVoList);
			}
			//삭제 된것들을 un delete 
			if(updateVoList.size() > 0){
				dbDao.saveInlandRouteMasterUSA02(updateVoList);
			}
			if(update2VoList.size() > 0){
				dbDao.saveInlandRouteMasterUSA01(update2VoList);
			}
			
			if(optimumVoList.size() > 0 ) {
				dbDao.updateRemoveOptimumFlag(optimumVoList);
			}
			
		}catch(DAOException ex){
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * InlandRouteManageUsaBCImpl's saveInlandRoutePriorityUSA<br>
	 *  2009-08-06 kim kwijin 생성
	 * @param inlandRouteUSVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void saveInlandRoutePriorityUSA(lnlandRouteUSVO[] inlandRouteUSVO, SignOnUserAccount account) throws EventException{
		try{

			List<lnlandRouteUSVO> updateVoList = new ArrayList<lnlandRouteUSVO>();

			for(int i = 0; i < inlandRouteUSVO.length; i++){

				if(inlandRouteUSVO[i].getIbflag().equals("U")){
					inlandRouteUSVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(inlandRouteUSVO[i]);
				}
			}


			if(updateVoList.size() > 0){
				dbDao.saveInlandRoutePriorityUSA(updateVoList);
			}


		}catch(DAOException ex){
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * PRD 업무 시나리오 마감작업<br>
	 * InlandRouteManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd(){
		dbDao = null;
	}
}
