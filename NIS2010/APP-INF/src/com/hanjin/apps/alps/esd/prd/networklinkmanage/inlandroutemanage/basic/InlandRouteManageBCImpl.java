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
 * 2012.05.31 박만건 [CHM-201217633] 구주 Hinterland
 * 2012.10.17 김진승 [CHM-201220713][PRD] O5 CNTR 추가로 인한 PRD 상 변경사항
 * 2012.10.25 정선용 [CHM-201220785] [PRD] US-Full Optimum flag Validation 변경요청

=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.basic;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.integration.InlandRouteManageDBDAO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.EmptySaveInlandRouteDetVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.EmptySaveInlandRouteMstVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.GetReferenceNoVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteDetVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteMsUSVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteSelCreVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteUSDetVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.RowSearchEmptyMasterVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.RowSearchInlandRouteManageVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.RowSearchMasterVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.SearchConditionVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.SearchEmptyInlandRouteMasterListVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.SearchInlandRouteManageAsiaEuVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PrdProdCtlRoutDtlVO;

/**
 * alps-PRD Business Logic Basic Command implementation<br>
 * - alps-PRD에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author jungsunyong
 * @see ESD_PRD_005EventResponse,InlandRouteManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class InlandRouteManageBCImpl extends BasicCommandSupport implements InlandRouteManageBC{

	// Database Access Object
	private transient InlandRouteManageDBDAO dbDao = null;

	/**
	 * InlandRouteManageBCImpl 객체 생성<br>
	 * InlandRouteManageDBDAO를 생성한다.<br>
	 */
	public InlandRouteManageBCImpl(){
		dbDao = new InlandRouteManageDBDAO();
	}

	/**
	 * InlandRouteManageBCImpl.java's searchInlandRouteManageList
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<SearchInlandRouteManageAsiaEuVO> searchInlandRouteManageList(SearchConditionVO vo) throws EventException{
		try{
			return dbDao.searchInlandRouteManageList(vo);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}

	}

	/**
	 * 조회 이벤트 처리<br>
	 * ★ 2009/07/29 kim kwi-jin 생성
	 * @param inlandRouteVO
	 * @return
	 * @throws EventException
	 */
	public List<InlandRouteVO> searchInlandRouteManageList01(InlandRouteVO inlandRouteVO) throws EventException{
		try{
			return dbDao.searchInlandRouteManageList01(inlandRouteVO);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}

	}

	/**
	 * InlandRouteManageBCImpl.java's searchInlandRouteManage
	 * @param inlandRouteDetVO
	 * @return
	 * @throws EventException
	 */
	public List<InlandRouteDetVO> searchInlandRouteManage(InlandRouteDetVO inlandRouteDetVO) throws EventException{
		try{
			return dbDao.searchInlandRouteManage(inlandRouteDetVO);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * InlandRouteManageBCImpl's searchEmptyInlandRouteManage
	 * ★2009-08-24 kim kiwjin생성
	 * @param inlandRouteDetVO
	 * @return
	 * @throws EventException
	 */
	public List<InlandRouteDetVO> searchEmptyInlandRouteManage(InlandRouteDetVO inlandRouteDetVO) throws EventException{
		try{
			return dbDao.searchInlandRouteManage(inlandRouteDetVO);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}

	}

	/**
	 * InlandRouteManage화면에 대한 Row조회 이벤트 처리<br>
	 * ★2009-08-13 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<RowSearchInlandRouteManageVO> rowSearchInlandRouteManage(RowSearchInlandRouteManageVO vo) throws EventException{
		try{
			return dbDao.rowSearchInlandRouteManage(vo);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * ★2009-08-12 kim kwijin생성
	 * @param inlandRouteMsUSVO
	 * @return
	 * @throws EventException
	 */
	public List<RowSearchMasterVO> rowSearchMaster(InlandRouteMsUSVO inlandRouteMsUSVO) throws EventException{
		try{
			return dbDao.rowSearchMaster(inlandRouteMsUSVO);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}

	}

	/**
	 * ★2009-08-12 kim kwijin생성
	 * @param inlandRouteMsUSVO
	 * @return
	 * @throws EventException
	 */
	public String searchPrioSeq(InlandRouteMsUSVO inlandRouteMsUSVO) throws EventException{
		try{
			return dbDao.searchPrioSeq(inlandRouteMsUSVO);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}

	}

	/**
	 * InlandRouteManageBCImpl's rowSearchEmptyMaster
	 * ★2009-08-25 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<RowSearchEmptyMasterVO> rowSearchEmptyMaster(EmptySaveInlandRouteDetVO vo) throws EventException{
		try{
			return dbDao.rowSearchEmptyMaster(vo);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}


	}

	/**
	 * 
	 * @param vos
	 * @param iDelFlg
	 * @param account
	 * @throws EventException
	 */
	public void multiInlandRouteManage(SearchInlandRouteManageAsiaEuVO[] vos, String iDelFlg, SignOnUserAccount account) throws EventException{
		try{
			List<SearchInlandRouteManageAsiaEuVO> updateVoList = new ArrayList<SearchInlandRouteManageAsiaEuVO>();
			List<SearchInlandRouteManageAsiaEuVO> unDelUpdateVoList = new ArrayList<SearchInlandRouteManageAsiaEuVO>();
			List<SearchInlandRouteManageAsiaEuVO> deleteVoList = new ArrayList<SearchInlandRouteManageAsiaEuVO>();
			List<SearchInlandRouteManageAsiaEuVO> optimumVoList = new ArrayList<SearchInlandRouteManageAsiaEuVO>();
			
			//MASTER 저장 로직(I는 없음 )
			for(int i = 0; i < vos.length; i++){
				vos[i].setUpdUsrId(account.getUsr_id());
				vos[i].setCreUsrId(account.getUsr_id());
				vos[i].setCreOfcCd(account.getOfc_cd());

				if(vos[i].getIbflag().equals("U")){
					if(!iDelFlg.equals("Y")){
						updateVoList.add(vos[i]);
					}else{
						unDelUpdateVoList.add(vos[i]);
					}
				}else if(vos[i].getIbflag().equals("D")){
					deleteVoList.add(vos[i]);
				}
				// ib_flag가 U 이고, optm_flag = 1 일때 추가로 새로운  vo 에 저장.
				if("1".equals(vos[i].getInlndRoutOptmFlg()) && !vos[i].getIbflag().equals("D")) {
					optimumVoList.add(vos[i]);
				}
			}



			if(updateVoList.size() > 0){
				//로직 추가: 같은 FM,TO 에 OPTM 이 없으면, BKG_FLAG 체크된것중 하나를 OPTM으로 변경(20121025) 
				dbDao.updateAsiaEuPs(updateVoList);
			}

			if(unDelUpdateVoList.size() > 0){
				dbDao.updateUndelAsiEu(unDelUpdateVoList);
			}

			if(deleteVoList.size() > 0){
				dbDao.strDelUpdAsiaEu(deleteVoList);
			}
			// OPTM FLAG 자유롭게 해제 가능하게 하기위해 맨 나중으로 위치 변경
			//-- optimum으로 등록하려는 것을 제외하고는 모두 uncheck
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
	 * InlandRouteManageBCImpl's multiEmptyInlandRouteManage
	 * ★2009-08-24 KIM KWIJIN 생성
	 * @param emptySaveInlandRouteMstVO
	 * @param account
	 * @param iDelFlg
	 * @throws EventException
	 */
	public void multiEmptyInlandRouteManage(EmptySaveInlandRouteMstVO[] emptySaveInlandRouteMstVO, SignOnUserAccount account, String iDelFlg) throws EventException{

		try{

			List<EmptySaveInlandRouteMstVO> updateVoList = new ArrayList<EmptySaveInlandRouteMstVO>();


			for(int i = 0; i < emptySaveInlandRouteMstVO.length; i++){
				emptySaveInlandRouteMstVO[i].setCreUsrId(account.getUsr_id());
				emptySaveInlandRouteMstVO[i].setUpdUsrId(account.getUsr_id());
				emptySaveInlandRouteMstVO[i].setCreOfcCd(account.getOfc_cd());

				if(emptySaveInlandRouteMstVO[i].getWrsChk().equals("1")){
					DBRowSet chkWrs = dbDao.checkEmptyWrs(emptySaveInlandRouteMstVO[i]);
					String chk = "";
					if(chkWrs.next()){
						chk = chkWrs.getString("WRS");
						if(chk.equals("Y")){
							throw new DAOException("WRS Flagged IRG already exists!");
						}
					}
				}

				if(emptySaveInlandRouteMstVO[i].getWrsChk().equals("1")){
					if(emptySaveInlandRouteMstVO[i].getD2Flg().equals("0")
							&& emptySaveInlandRouteMstVO[i].getD4Flg().equals("0")
							&& emptySaveInlandRouteMstVO[i].getD5Flg().equals("0")
							&& emptySaveInlandRouteMstVO[i].getD7Flg().equals("0")
							&& emptySaveInlandRouteMstVO[i].getO2Flg().equals("0")
							&& emptySaveInlandRouteMstVO[i].getO4Flg().equals("0")
							&& emptySaveInlandRouteMstVO[i].getO5Flg().equals("0") // added in 2012.10.17
							&& emptySaveInlandRouteMstVO[i].getA2Flg().equals("0")
							&& emptySaveInlandRouteMstVO[i].getA4Flg().equals("0")
							&& emptySaveInlandRouteMstVO[i].getA5Flg().equals("0")
							&& emptySaveInlandRouteMstVO[i].getR2Flg().equals("0")
							&& emptySaveInlandRouteMstVO[i].getR5Flg().equals("0")
							&& emptySaveInlandRouteMstVO[i].getR8Flg().equals("0")
							){


						emptySaveInlandRouteMstVO[i].setWrsChk("0");
					}
				}
				updateVoList.add(emptySaveInlandRouteMstVO[i]);
			}

			if(iDelFlg.equals("Y")){
				dbDao.undelUpdateEmptyPs(updateVoList);
			}else{
				dbDao.updateEmptyPs(updateVoList);
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
	 * 멀티 이벤트 처리<br>
	 * ESD_PRD_005 화면에 대한 멀티 이벤트 처리<br>
	 * DETAIL 저장,( 미주,구주 모두 공통 사용)
	 * @param inlandRouteUSDetVOs
	 * @param inlandRouteMsUSVO
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public String multi01InlandRouteManage(InlandRouteUSDetVO[] inlandRouteUSDetVOs, InlandRouteMsUSVO inlandRouteMsUSVO, SignOnUserAccount account) throws EventException{

		String retVal = "";
		try{
			List<InlandRouteUSDetVO> voList = new ArrayList<InlandRouteUSDetVO>();



			String iRoutSeq = inlandRouteMsUSVO.getIRoutSeq();
			if("FN".equals(inlandRouteMsUSVO.getWrsFChk())) {
				String chkWrs = dbDao.checkWrs(inlandRouteMsUSVO);
				log.debug("★★ chkWrs USA-FULL ::::" + chkWrs);
				if(chkWrs.equals("Y")){
					throw new DAOException(new ErrorHandler("PRD00049", " [" + inlandRouteMsUSVO.getIRoutOrgNodCd() + "-" + inlandRouteMsUSVO.getIRoutDestNodCd() + "]").getMessage());
				}
				chkWrs = dbDao.checkWrs2(inlandRouteMsUSVO);
				log.debug("★★ chkWrs2 USA-Empty::::" + chkWrs);
				if(chkWrs.equals("Y")){
					throw new DAOException(new ErrorHandler("PRD00049", " [" + inlandRouteMsUSVO.getIRoutOrgNodCd() + "-" + inlandRouteMsUSVO.getIRoutDestNodCd() + "]").getMessage());
				}
			}
			log.debug("★★ isPseudoYard::::" + dbDao.isPseudoYard(inlandRouteMsUSVO));
			if(dbDao.isPseudoYard(inlandRouteMsUSVO)){
				throw new DAOException(new ErrorHandler("PRD00050").getMessage());
			}


			Map<String, String> selPs = dbDao.selectPs(inlandRouteMsUSVO);
			log.debug("★★SELECTPC::::" + selPs);

			inlandRouteMsUSVO.setNextRoutSeq(selPs.get("next_rout_seq"));
			inlandRouteMsUSVO.setNextPrioSeq(selPs.get("next_prio_seq"));

			inlandRouteMsUSVO.setCreOfcCd(account.getOfc_cd());
			inlandRouteMsUSVO.setCreUsrId(account.getUsr_id());
			inlandRouteMsUSVO.setUpdUsrId(account.getUsr_id());

			log.debug("★★INewRouteCd::::" + inlandRouteMsUSVO.getINewRouteCd());
			if(inlandRouteMsUSVO.getINewRouteCd().equals("Y")){
				iRoutSeq = selPs.get("next_rout_seq");
				inlandRouteMsUSVO.setIRoutSeq(iRoutSeq);
				
				if ("Y".equals(inlandRouteMsUSVO.getIOptmFlg())) {
					// 현 Record가 Optimum일 경우 다른 데이터의 Optimum을 제거한다.
					dbDao.updateRemoveOptimumFlag(inlandRouteMsUSVO.getIRoutOrgNodCd(), inlandRouteMsUSVO.getIRoutDestNodCd(), inlandRouteMsUSVO.getIRoutSeq(), inlandRouteMsUSVO.getCreUsrId());
//				} else {
//					// 현 Record가 Optimum이 아니지만,기존에 Optimum이 등록되지 않은 경우 자동 Optimum처리(구주)
//					String optmFlg = dbDao.searchOptimumRouteCheck(inlandRouteMsUSVO.getIRoutOrgNodCd(), inlandRouteMsUSVO.getIRoutDestNodCd(), inlandRouteMsUSVO.getRInbound());
//					inlandRouteMsUSVO.setIOptmFlg(optmFlg);
//					if ("Y".equals(optmFlg)) {
////						if ( inlandRouteUSDetVOs.length > 2) {
////							throw new EventException ((new ErrorHandler("PRD90138")).getMessage());
////						}
//						inlandRouteMsUSVO.setIBkgFlg(optmFlg);
//					}
//					
				}
				int insRet = dbDao.insertPs1(inlandRouteMsUSVO);
				log.debug("★★insRet::::" + insRet);
			}

			if(inlandRouteMsUSVO.getINewRouteCd().equals("N") || inlandRouteMsUSVO.getINewRouteCd().equals("M")){
				int delRet = dbDao.deletePs(inlandRouteMsUSVO);
				
				if ("Y".equals(inlandRouteMsUSVO.getIOptmFlg())) {
					// 현 Record가 Optimum일 경우 다른 데이터의 Optimum을 제거한다.
					dbDao.updateRemoveOptimumFlag(inlandRouteMsUSVO.getIRoutOrgNodCd(), inlandRouteMsUSVO.getIRoutDestNodCd(), inlandRouteMsUSVO.getIRoutSeq(), inlandRouteMsUSVO.getCreUsrId());
				}
				int upRet = dbDao.updatePs(inlandRouteMsUSVO);
				log.debug("★★delRet::::" + delRet);
				log.debug("★★upRet::::" + upRet);

			}
			String chkPs = dbDao.checkPs(inlandRouteMsUSVO);


			if(chkPs == null || chkPs.equals("") || !chkPs.equals("X")){
				throw new DAOException((new ErrorHandler("PRD00046")).getMessage());
			}


			int routDtlSeq = 1;

			String rInbound = inlandRouteMsUSVO.getRInbound();
			String nod_tp_cd1 = inlandRouteMsUSVO.getNodTpCd1();
			String nod_tp_cd2 = nod_tp_cd1;//★
			int rowCount = inlandRouteUSDetVOs.length;

			log.debug("\n\n rInbound:"+rInbound
					+"\n nod_tp_cd1:"+nod_tp_cd1
					+"\n nod_tp_cd2:"+nod_tp_cd2);


			for(int j = 0; j < inlandRouteUSDetVOs.length; j++){


				if(rInbound.equals("I") && nod_tp_cd1.equals("Z")){
					if(j < (rowCount - 1)){

						if(dbDao.isDoorTml(inlandRouteUSDetVOs[j].getLnkOrgLoc() + inlandRouteUSDetVOs[j].getLnkOrgType())
								|| dbDao.isDoorTml(inlandRouteUSDetVOs[j].getLnkDestLoc() + inlandRouteUSDetVOs[j].getLnkDestType())){
							throw new DAOException((new ErrorHandler("PRD00069")).getMessage());
						}
					}else if(routDtlSeq == rowCount){ //마지막 row 일때

						if(dbDao.isDoorTml(inlandRouteUSDetVOs[j].getLnkOrgLoc() + inlandRouteUSDetVOs[j].getLnkOrgType())){ //from
							throw new DAOException((new ErrorHandler("PRD00069")).getMessage());
						}
					}
				}else if(rInbound.equals("O") && nod_tp_cd2.equals("Z")){
					if(j == 0){

						if(dbDao.isDoorTml(inlandRouteUSDetVOs[j].getLnkDestLoc() + inlandRouteUSDetVOs[j].getLnkDestType())){ //to
							throw new DAOException((new ErrorHandler("PRD00069")).getMessage());
						}
					}else{ //

						if(dbDao.isDoorTml(inlandRouteUSDetVOs[j].getLnkOrgLoc() + inlandRouteUSDetVOs[j].getLnkOrgType())
								|| dbDao.isDoorTml(inlandRouteUSDetVOs[j].getLnkDestLoc() + inlandRouteUSDetVOs[j].getLnkDestType())){
							throw new DAOException((new ErrorHandler("PRD00069")).getMessage());
						}
					}
				}else{

					if(dbDao.isDoorTml(inlandRouteUSDetVOs[j].getLnkOrgLoc() + inlandRouteUSDetVOs[j].getLnkOrgType())
							|| dbDao.isDoorTml(inlandRouteUSDetVOs[j].getLnkDestLoc() + inlandRouteUSDetVOs[j].getLnkDestType())){
						throw new DAOException((new ErrorHandler("PRD00069")).getMessage());
					}
				}

				log.debug("★★:::inlandRouteMsUSVO:getIbflag" + inlandRouteUSDetVOs[j].getIbflag());
				if(inlandRouteUSDetVOs[j].getIbflag().equals("I") || inlandRouteUSDetVOs[j].getIbflag().equals("U") || inlandRouteUSDetVOs[j].getIbflag().equals("R") || inlandRouteUSDetVOs[j].getIbflag().equals("")){
					log.debug("★★:::inlandRouteMsUSVO:getIRoutOrgNodCd" + inlandRouteMsUSVO.getIRoutOrgNodCd());
					log.debug("★★:::inlandRouteMsUSVO:getIRoutDestNodCd" + inlandRouteMsUSVO.getIRoutDestNodCd());
					log.debug("★★:::inlandRouteMsUSVO:next_rout_seq" + selPs.get("next_rout_seq"));

					inlandRouteUSDetVOs[j].setRoutOrgNodCd(inlandRouteMsUSVO.getIRoutOrgNodCd());
					inlandRouteUSDetVOs[j].setRoutDestNodCd(inlandRouteMsUSVO.getIRoutDestNodCd());
					inlandRouteUSDetVOs[j].setRoutSeq(iRoutSeq);//ROUTE SEQ
					inlandRouteUSDetVOs[j].setRoutDtlSeq(routDtlSeq + "");
					inlandRouteUSDetVOs[j].setCreOfcCd(account.getOfc_cd());
					inlandRouteUSDetVOs[j].setCreUsrId(account.getUsr_id());
					inlandRouteUSDetVOs[j].setUpdUsrId(account.getUsr_id());


					String ctyCd = "";
					String agmtSeq = "";
					int iAgmtSeq = 0;


					if(inlandRouteUSDetVOs[j].getAgmtNo() != null && inlandRouteUSDetVOs[j].getAgmtNo().length() > 4){
						ctyCd = inlandRouteUSDetVOs[j].getAgmtNo().substring(0, 3);
						agmtSeq = inlandRouteUSDetVOs[j].getAgmtNo().substring(3);
						iAgmtSeq = Integer.parseInt(agmtSeq);

					}

					inlandRouteUSDetVOs[j].setTrspAgmtOfcCtyCd(ctyCd);
					inlandRouteUSDetVOs[j].setTrspAgmtSeq(agmtSeq);



					voList.add(inlandRouteUSDetVOs[j]);

					routDtlSeq++;
				}
			}

			if(voList.size() > 0){
			   // int retDtl[] = dbDao.insert2Ps(voList);
				dbDao.insert2Ps(voList);
			}

			//★2009-10-12 kim kwijin 추가사항

			// if(inlandRouteMsUSVO.getINewRouteCd().equals("Y")){
			//@[i_rout_org_nod_cd], @[i_rout_dest_nod_cd], @[i_rout_seq]
			String i_rout_org_nod_cd = inlandRouteMsUSVO.getIRoutOrgNodCd();
			String i_rout_dest_nod_cd = inlandRouteMsUSVO.getIRoutDestNodCd();
			String i_rout_seq = inlandRouteMsUSVO.getIRoutSeq();

			Map addItems = dbDao.getInlandRoutAddItems(i_rout_org_nod_cd, i_rout_dest_nod_cd, i_rout_seq);

			inlandRouteMsUSVO.setFullRtnYdCd((String) addItems.get("fullRtnYdCd"));
			inlandRouteMsUSVO.setFullPkupYdCd((String) addItems.get("fullPkupYdCd"));
			inlandRouteMsUSVO.setTrspModCd((String) addItems.get("trspModCd"));


			log.debug("★fullRtnYnCd:" + inlandRouteMsUSVO.getFullRtnYdCd()
					+ "\n fullPkupYdCd:" + inlandRouteMsUSVO.getFullPkupYdCd()
					+ "\n trspModCd:" + inlandRouteMsUSVO.getTrspModCd());
			dbDao.updateInlandRoutAddItems(inlandRouteMsUSVO);


			// }
			//★2009-10-12 kim kwijin추가사항




			dbDao.upDateHubLoc(inlandRouteMsUSVO);
			
			// 미주일경우, BKG flag 를 새로 달 경우 해당 Corridor 에 관련된 IRG 들 중 Optimum flag 를 달고 있는 IRG 가 없을 경우 
			// BKG flag 를 단 해당 IRG 상에 Optimum flag 가 따라 달리도록 설정
			// 미주 포함 모든 곳에 적용 20121025
//			if( "US".equals(i_rout_org_nod_cd.substring(0, 2) ) || "CA".equals(i_rout_org_nod_cd.substring(0, 2) )  ) {
				
				dbDao.updateOptmFlagForUs(inlandRouteMsUSVO);
//			}
			

			return retVal;


		}catch(DAOException ex){
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * InlandRouteManageBCImpl's multi01EmptyInlandRouteManage
	 * ★ 2009-08-25 kim kwijin생성
	 * empty inland route 상세저장
	 * @param vos
	 * @param vo
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public String multi01EmptyInlandRouteManage(EmptySaveInlandRouteDetVO[] vos, EmptySaveInlandRouteDetVO vo, SignOnUserAccount account) throws EventException{
		String i_rout_seq = "";
		String prioSeq = "";
		try{


			List<EmptySaveInlandRouteDetVO> insertVoList = new ArrayList<EmptySaveInlandRouteDetVO>();
			DBRowSet wrsDrs = dbDao.checkEmptyWrs(vo);

			DBRowSet dRs = null;
			String chkWrs = "";

			vo.setCreUsrId(account.getUsr_id());
			vo.setUpdUsrId(account.getUsr_id());
			vo.setCreOfcCd(account.getOfc_cd());

			if(!JSPUtil.getNull(vo.getWrsChk()).equals("")){

				if(wrsDrs.next()){
					chkWrs = wrsDrs.getString("WRS");
					log.debug("\n ★ SQL chkWrs:" + chkWrs);
					if(chkWrs.equals("Y")){
						throw new DAOException(new ErrorHandler("PRD00049", " [" + vo.getIRoutOrgNodCd() + "-" + vo.getIRoutDestNodCd() + "]").getMessage());
					}
				}

			}
			/*
			 * pseudo yard 체크
			 */
			if(dbDao.isPseudoYard(vo.getIRoutOrgNodCd(), vo.getIRoutDestNodCd())){
				throw new DAOException(new ErrorHandler("PRD00050").getMessage());
			}
			log.debug("\n\n ★ i_newRouteCd:" + vo.getINewRouteCd());


			if(vo.getINewRouteCd().equals("Y")){//new route -----------------------
				dRs = dbDao.searchEmptyRoutSeq(vo);

				if(dRs.next()){
					i_rout_seq = dRs.getString("next_rout_seq");
					prioSeq = dRs.getString("next_prio_seq");

				}

				vo.setIRoutSeq(i_rout_seq);
				vo.setPrioSeq(prioSeq);

				int insRet = dbDao.insert1Empty1Ps(vo);
				log.debug("\n\n ★ insRet:" + insRet);
			}//new route end -------------------------------------------------


			log.debug("\n\n ★ "
					+ "\n i_inv:" + vo.getIInv()
					+ "\n i_rout_pln_cd:" + vo.getIRoutPlnCd());

			if(vo.getINewRouteCd().equals("N") || vo.getINewRouteCd().equals("M")){
				int delRet = dbDao.deleteEmptyDetPs(vo);
				int upRet = dbDao.updateEmptyDetPs(vo);
				log.debug("\n\ndelRet:" + delRet + " upRet:" + upRet);


			}// delete end-------------------------------------------------------------------------


			//int checkPsIdx = 1;

			dRs = dbDao.checkEmptyDetPs(vo);
			if(dRs.next()){
				log.debug("\n SQL X:" + dRs.getString(1));
				if(dRs.getString(1) == null || dRs.getString(1).equals("") || !dRs.getString(1).equals("X")){
					throw new DAOException((new ErrorHandler("PRD00046")).getMessage());
				}
			}else{
				log.debug("\n SQL dRs.next() 이 없을떄  ");
				//Node Type 이 틀립니다.
				throw new DAOException((new ErrorHandler("PRD00046")).getMessage());
			}

			int routDtlSeq = 1;
			if(vos != null){
				for(int i = 0; i < vos.length; i++){

					if(vos[i].getIbflag().equals("I") || vos[i].getIbflag().equals("U") || vos[i].getIbflag().equals("R")){
						String ctyCd = "";
						String agmtSeq = "";
						int iAgmtSeq = 0;
						if(vos[i].getAgmtNo() != null && vos[i].getAgmtNo().length() > 4){
							ctyCd = vos[i].getAgmtNo().substring(0, 3);
							agmtSeq = vos[i].getAgmtNo().substring(3);
							iAgmtSeq = Integer.parseInt(agmtSeq);
						}
						vos[i].setCreUsrId(account.getUsr_id());
						vos[i].setUpdUsrId(account.getUsr_id());
						vos[i].setCreOfcCd(account.getOfc_cd());
						vos[i].setRoutDtlSeq(routDtlSeq + "");
						vos[i].setIAgmtSeq(iAgmtSeq + "");
						vos[i].setCtyCd(ctyCd);

						vos[i].setIRoutOrgNodCd(vo.getIRoutOrgNodCd());
						vos[i].setIRoutDestNodCd(vo.getIRoutDestNodCd());
						vos[i].setIRoutSeq(vo.getIRoutSeq());

						routDtlSeq++;
						insertVoList.add(vos[i]);
					}

				}


				if(insertVoList.size() > 0){
					int[] retDtl = dbDao.insertEmpty2Ps(insertVoList);
					log.debug("\n\n rowCount: " + vos.length + ",  retDtl.length:" + retDtl.length);
					if(vos.length != retDtl.length){
						log.debug("\n\n rowCount: " + vos.length + "  !=  retDtl.length:" + retDtl.length);
						throw new DAOException((new ErrorHandler("PRD00047")).getMessage());
					}

				}

			}

		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}

		vo.setIRoutSeq(i_rout_seq);

		return i_rout_seq;

	}

	/**
	 * INLAND ROUTE DETAIL SAVE AS
	 * @param vos
	 * @param vo
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public String saveAsInlandRouteManage(InlandRouteUSDetVO[] vos, InlandRouteMsUSVO vo, SignOnUserAccount account) throws EventException{
		try{
			List<InlandRouteUSDetVO> insertVoList = new ArrayList<InlandRouteUSDetVO>();

			DBRowSet wrsDrs = null;
			String i_rout_seq = vo.getIRoutSeq();
			vo.setCreUsrId(account.getUsr_id());
			vo.setUpdUsrId(account.getUsr_id());
			vo.setCreOfcCd(account.getOfc_cd());

			if(vo.getIWrsFlCd() != null && vo.getIWrsFlCd().length() > 0){
				wrsDrs = dbDao.inlandRouteSaveAsCheckWrs(vo);
				if(wrsDrs.next()){
					String chkWrs = wrsDrs.getString("WRS");

					if(chkWrs.equals("Y")){
						throw new DAOException(new ErrorHandler("PRD00049", " [" + vo.getIRoutOrgNodCd() + "-" + vo.getIRoutDestNodCd() + "]").getMessage());
					}
				}

			}

			if(vo.getIWrsMtCd() != null && vo.getIWrsMtCd().length() > 0){
				wrsDrs = null;
				wrsDrs = dbDao.inlandRouteSaveAsCheckWrs2(vo);
				if(wrsDrs.next()){
					String chkWrs = wrsDrs.getString("WRS");
					if(chkWrs.equals("Y")){
						throw new DAOException(new ErrorHandler("PRD00049", " [" + vo.getIRoutOrgNodCd() + "-" + vo.getIRoutDestNodCd() + "]").getMessage());
					}
				}
			}

			/*
			 * pseudo yard 체크
			 */
			if(dbDao.isPseudoYard(vo.getIRoutOrgNodCd(), vo.getIRoutDestNodCd())){
				throw new DAOException(new ErrorHandler("PRD00050").getMessage());
			}

			wrsDrs = dbDao.inlandRouteSaveAsSelectPs(vo);
			String prioSeq = "";
			log.debug("★처음 i_rout_seq:::" + vo.getIRoutSeq());
			if(wrsDrs.next()){
				i_rout_seq = wrsDrs.getString("next_rout_seq");
				prioSeq = wrsDrs.getString("next_prio_seq");
				vo.setIRoutSeq(i_rout_seq);
				vo.setNextPrioSeq(prioSeq);
			}
			log.debug("★나중 i_rout_seq:::" + vo.getIRoutSeq());
           // int insRet = dbDao.inlandRouteSaveAsInsert1(vo);
			
			if ("Y".equals(vo.getIOptmFlg())) {
				// 현 Record가 Optimum일 경우 다른 데이터의 Optimum을 제거한다.
				dbDao.updateRemoveOptimumFlag(vo.getIRoutOrgNodCd(), vo.getIRoutDestNodCd(), vo.getIRoutSeq(), vo.getCreUsrId());
//			} else {
//				// 현 Record가 Optimum이 아니지만,기존에 Optimum이 등록되지 않은 경우 자동 Optimum처리(구주)
//				String optmFlg = dbDao.searchOptimumRouteCheck(vo.getIRoutOrgNodCd(), vo.getIRoutDestNodCd(), vo.getRInbound());
//				if ("Y".equals(optmFlg) && vos.length > 2) {
//					throw new EventException ((new ErrorHandler("PRD90138")).getMessage());
//				}
			}

			dbDao.inlandRouteSaveAsInsert1(vo);
			wrsDrs = null;
			wrsDrs = dbDao.inlandRouteSaveAsCheckLastPs(vo);


			if(wrsDrs.next()){

				if(wrsDrs.getString(1) == null || wrsDrs.getString(1).equals("") || !wrsDrs.getString(1).equals("X")){
					throw new DAOException((new ErrorHandler("PRD00046")).getMessage());
				}
			}else{
				throw new DAOException((new ErrorHandler("PRD00046")).getMessage());
			}

			int routDtlSeq = 1;

			int rowCount = (vos == null) ? 0 : vos.length;
			for(int j = 0; j < rowCount; j++){
				vos[j].setCreUsrId(account.getUsr_id());
				vos[j].setUpdUsrId(account.getUsr_id());
				vos[j].setCreOfcCd(account.getOfc_cd());


				if(vo.getRInbound().equals("I") && vo.getNodTpCd1().equals("Z")){
					if(j < (rowCount - 1)){
						log.debug("\n\n in Zone j<rowCount ..................");
						if(dbDao.isDoorTml(vos[j].getLnkOrgLoc() + vos[j].getLnkOrgType()) || dbDao.isDoorTml(vos[j].getLnkDestLoc() + vos[j].getLnkDestType())){
							throw new DAOException((new ErrorHandler("PRD00069")).getMessage());
						}
					}else if(routDtlSeq == rowCount){ //마지막 row 일때
						log.debug("\n\n in Zone routDtlSeq==rowCount ..................");
						if(dbDao.isDoorTml(vos[j].getLnkOrgLoc() + vos[j].getLnkOrgType())){ //from
							throw new DAOException((new ErrorHandler("PRD00069")).getMessage());
						}
					}
				}else if(vo.getRInbound().equals("O") && vo.getNodTpCd2().equals("Z")){
					if(j == 0){
						log.debug("\n\n out Zone j==0 ..................");
						if(dbDao.isDoorTml(vos[j].getLnkDestLoc() + vos[j].getLnkDestType())){ //to
							throw new DAOException((new ErrorHandler("PRD00069")).getMessage());
						}
					}else{ //마지막 row 일때
						log.debug("\n\n out Zone j==0 else ..................");
						if(dbDao.isDoorTml(vos[j].getLnkOrgLoc() + vos[j].getLnkOrgType()) || dbDao.isDoorTml(vos[j].getLnkDestLoc() + vos[j].getLnkDestType())){
							throw new DAOException((new ErrorHandler("PRD00069")).getMessage());
						}
					}
				}else{
					log.debug("\n\n i/o Yard or tmnl_shtl ..................");
					if(dbDao.isDoorTml(vos[j].getLnkOrgLoc() + vos[j].getLnkOrgType()) || dbDao.isDoorTml(vos[j].getLnkDestLoc() + vos[j].getLnkDestType())){
						throw new DAOException((new ErrorHandler("PRD00069")).getMessage());
					}
				}


				String ctyCd = "";
				String agmtSeq = "";
				int iAgmtSeq = 0;

				if(vos[j].getAgmtNo() != null && vos[j].getAgmtNo().length() > 4){
					ctyCd = vos[j].getAgmtNo().substring(0, 3);
					agmtSeq = vos[j].getAgmtNo().substring(3);
					iAgmtSeq = Integer.parseInt(agmtSeq);
				}

				vos[j].setCtyCd(ctyCd);
				vos[j].setIAgmtSeq(iAgmtSeq + "");
				vos[j].setRoutDtlSeq(routDtlSeq + "");
				vos[j].setRoutSeq(i_rout_seq);
				vos[j].setRoutOrgNodCd(vo.getIRoutOrgNodCd());
				vos[j].setRoutDestNodCd(vo.getIRoutDestNodCd());

				routDtlSeq++;
				insertVoList.add(vos[j]);
			}

			if(insertVoList.size() > 0){
				int retDtl[] = dbDao.inlandRouteSaveAsInsert2(insertVoList);

				if(rowCount != retDtl.length){
					log.debug("\n\n rowCount(ibflag): " + rowCount + "  !=  retDtl.length:" + retDtl.length);
					throw new DAOException((new ErrorHandler("PRD00070")).getMessage());
				}
				for(int j = 0; j < retDtl.length; j++){
					log.debug("\n\n retDtl[j] :[" + retDtl[j] + "]   ");
					if(retDtl[j] == Statement.EXECUTE_FAILED){
						throw new DAOException((new ErrorHandler("PRD00070")).getMessage());
					}else{
						continue;

					}
				}

			}


			//★2009-10-12 kim kwijin추가사항
			String i_rout_org_nod_cd = vo.getIRoutOrgNodCd();
			String i_rout_dest_nod_cd = vo.getIRoutDestNodCd();
			String i_rout_seq2 = vo.getIRoutSeq();

			Map addItems = dbDao.getInlandRoutAddItems(i_rout_org_nod_cd, i_rout_dest_nod_cd, i_rout_seq2);

			vo.setFullRtnYdCd((String) addItems.get("fullRtnYdCd"));
			vo.setFullPkupYdCd((String) addItems.get("fullPkupYdCd"));
			vo.setTrspModCd((String) addItems.get("trspModCd"));

			dbDao.updateInlandRoutAddItems(vo);
			//★2009-10-12 kim kwijin추가사항
			//int updateHubRet = dbDao.upDateHubLoc(vo);
			dbDao.upDateHubLoc(vo);
			// 미주일경우, BKG flag 를 새로 달 경우 해당 Corridor 에 관련된 IRG 들 중 Optimum flag 를 달고 있는 IRG 가 없을 경우 
			// BKG flag 를 단 해당 IRG 상에 Optimum flag 가 따라 달리도록 설정
			// 모든지역에 적용
//			if( "US".equals(i_rout_org_nod_cd.substring(0, 2) ) || "CA".equals(i_rout_org_nod_cd.substring(0, 2) )  ) {
				
				dbDao.updateOptmFlagForUs(vo);
//			}
			
			
		}catch(DAOException ex){
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return vo.getIRoutSeq();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * InlandRouteManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<InlandRouteSelCreVO> searchInlandRouteManageCreateList(InlandRouteSelCreVO vo) throws EventException{
		try{
			DBRowSet chkPort = dbDao.portChk(vo.getIOrgCd(), vo.getIDestCd());
			String fromChk = "";
			String toChk = "";

			String hubLocCd = "";
			String trspModCd = "";
			List<InlandRouteSelCreVO> list = new ArrayList();
			if(chkPort.next()){
				fromChk = chkPort.getString("from_port_chk");
				toChk = chkPort.getString("to_port_chk");

			}
			vo.setFromChk(fromChk);
			vo.setToChk(toChk);

			if((fromChk.equals("Y") && toChk.equals("N")) || (fromChk.equals("N") && toChk.equals("Y"))){
				DBRowSet chkHub = dbDao.hubChk(fromChk, vo.getIOrgCd(), toChk, vo.getIDestCd());
				if(chkHub.next()){
					hubLocCd = chkHub.getString("hub_loc_cd");
					trspModCd = chkHub.getString("trsp_mod_cd");
				}
				vo.setHubLocCd(hubLocCd);
				vo.setTrspModCd(trspModCd);

				list = dbDao.searchInlandRouteManageCreateList(vo);
			}


			return list;

		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
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

	/**
	 * 
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<GetReferenceNoVO> getReferenceNo(GetReferenceNoVO vo) throws EventException{
		try{
			List<GetReferenceNoVO> list = dbDao.getReferenceNo(vo);
			if(list.size() == 0){
				throw new EventException((new ErrorHandler("PRD00001")).getMessage());
			}
			return list;
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}


	}

	/**
	 *  InlandRouteManageBCImpl's getInLandRouteExistCount
	 * @param inlandRouteMsUSVO
	 * @param InlandRouteUSDetVOs
	 * @return
	 * @throws EventException
	 * ★ 2009-08-10 KIM KWIJIN
	 */
	public int getInLandRouteExistCount(InlandRouteMsUSVO inlandRouteMsUSVO, InlandRouteUSDetVO[] InlandRouteUSDetVOs) throws EventException{
		try{
			return dbDao.getInLandRouteExistCount(inlandRouteMsUSVO, InlandRouteUSDetVOs);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}

	}

	/**
	 * InlandRouteManageBCImpl's getEmptyInLandRouteExistCount
	 * ★2009-08-25 kim kwijin생성
	 * @param vos
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public int getEmptyInLandRouteExistCount(EmptySaveInlandRouteDetVO[] vos, EmptySaveInlandRouteDetVO vo) throws EventException{
		try{
			return dbDao.getEmptyInLandRouteExistCount(vos, vo);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}

	}

	/**
	 * InlandRouteManageBCImpl's getInLandRouteRemarkCompare
	 * ★2009-08-25 kim kwijin생성
	 * @param vos
	 * @param vo
	 * @return
	 * @throws EventException
	 */	
	public int getInLandRouteRemarkCompare(InlandRouteMsUSVO inlandRouteMsUSVO) throws EventException{
		try{
			return dbDao.getInLandRouteRemarkCompare(inlandRouteMsUSVO);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}

	}

	/**
	 * ★ 2009-08-10 KIM KWIJIN
	 * @param inlandRouteMsUSVO
	 * @throws EventException
	 */
	public void updateRemark(InlandRouteMsUSVO inlandRouteMsUSVO) throws EventException{
		try{
			dbDao.updateRemark(inlandRouteMsUSVO);
		}catch(DAOException ex){
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * InlandRouteManageBCImpl's updateEmptyRemark
	 * ★2009-08-25 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public int updateEmptyRemark(EmptySaveInlandRouteDetVO vo) throws EventException{
		try{
			return dbDao.updateEmptyRemark(vo);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}

	}

	/** (non-Javadoc)
	 * InlandRouteManageBCImpl's searchEmptyInlandRouteManageList
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<SearchEmptyInlandRouteMasterListVO> searchEmptyInlandRouteManageList(SearchConditionVO vo) throws EventException{
		try{
			return dbDao.searchEmptyInlandRouteManageList(vo.getFromCd(), vo.getToCd(), vo.getWrsFlg(), vo.getIDelFlg());
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}

	}
	
	/**
     * Auto IRG가 생성되어야 하는지 검사하고 필요시 생성함<br>
	 * @param autoIrgParamVO
	 * @param usrId
	 * @param ofcCd
	 * @throws EventException
	 */
	public void createAutoIRG(PrdProdCtlRoutDtlVO autoIrgParamVO, String usrId, String ofcCd) throws EventException {
		try {
				dbDao.createAutoIRGEachLnk(autoIrgParamVO, usrId, ofcCd);
				dbDao.createAutoIRGMst(autoIrgParamVO, usrId, ofcCd);
				dbDao.createAutoIRGDtl(autoIrgParamVO, usrId, ofcCd);
				// Hub yard 등 미주 Rail의 경우 계획에따라 이동하므로 불필요(2011.05.26 - 최종혁수석님에게 물어보고 처리)
//				InlandRouteMsUSVO inlandRouteMsUSVO = new InlandRouteMsUSVO();
//				inlandRouteMsUSVO.setIRoutOrgNodCd(autoIrgParamVO.getRoutOrgNodCd());
//				inlandRouteMsUSVO.setIRoutDestNodCd(autoIrgParamVO.getRoutDestNodCd());
//				inlandRouteMsUSVO.setIRoutSeq(autoIrgParamVO.getRoutSeq());
//				dbDao.upDateHubLoc( inlandRouteMsUSVO);
		} catch (DAOException e1) {
			throw new EventException(e1.getMessage());
		}
		
	}
}
