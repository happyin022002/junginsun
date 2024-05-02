/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : OceanRouteManageBCImpl.java
 *@FileTitle : OceanLink 정보관리 (본사관리)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-09-22
 *@LastModifier : kimyoungchul
 *@LastVersion : 1.0
 * 2006-09-22 kimyoungchul
 * 1.0 최초 생성
 * 2011.09.19 변종건 [CHM-201113069-01] Ocean Route Management상의 Auto & Multi Creation 화면 관련 변경사항
 * 2011.12.06 변종건 [CHM-201114917-01] Ocean Route Upload Excel 신규 기능 추가건
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.integration.OceanRouteManageDBDAO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.RowSearchOceanRouteManageVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.SaveOceanRouteStatusVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.SaveOceanRouteVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchConditionVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchLaneConnectionVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanLaneVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanRouteAutoCreationVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanRouteListVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanRouteMultiCreationVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanRouteSingleCreationVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanRouteStatusVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS-PRD Business Logic Basic Command implementation<br>
 * - NIS-PRD에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author kimyoungchul
 * @see ESD_PRD_014EventResponse,OceanRouteManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class OceanRouteManageBCImpl extends BasicCommandSupport implements OceanRouteManageBC{

	// Database Access Object
	private transient OceanRouteManageDBDAO dbDao = null;

	/**
	 * OceanRouteManageBCImpl 객체 생성<br>
	 * OceanRouteManageDBDAO를 생성한다.<br>
	 */
	public OceanRouteManageBCImpl(){
		dbDao = new OceanRouteManageDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * OceanRouteManage화면에 대한 조회 이벤트 처리<br>
	 * ★2009-08-20 kim kwijin 생성
	 * @param vo
	 * @param int iPage
	 * @return List<SearchOceanRouteListVO>
	 * @throws EventException
	 */
	public List<SearchOceanRouteListVO> searchOceanRouteList(SearchConditionVO vo, int iPage) throws EventException{
		try{

			if(JSPUtil.getNull(vo.getIDelFlag()).equals("Y")){
//				return dbDao.searchOceanRouteDelList(vo);
				return dbDao.searchOceanRouteDelList(vo, iPage);
			}else{
//				return dbDao.searchOceanRouteList(vo);
				return dbDao.searchOceanRouteList(vo, iPage);
			}


		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}

	}

	/**
	 * ★ 2009-08-21 kim kwijin생성
	 * 멀티 이벤트 처리<br>
	 * ESD_PRD_0014 화면에 대한 멀티 이벤트 처리<br>
	 * @param vos
	 * @param account
	 * @throws EventException
	 */
	public void multiOceanRoute(SaveOceanRouteVO[] vos, SignOnUserAccount account) throws EventException{
		try{
			int retVal = 0;			
			DBRowSet dRs = null;
			for(int i = 0; i < vos.length; i++){
				String tsIndCd = "D";
				if(Integer.parseInt(vos[i].getSLnkCnt()) > 1){
					tsIndCd = "T";
				}
				vos[i].setTsIndCd(tsIndCd);
				vos[i].setUpdUsrId(account.getUsr_id());
				vos[i].setCreUsrId(account.getUsr_id());
				vos[i].setCreOfcCd(account.getOfc_cd());

				if(vos[i].getIbflag().equals("I")){
					dRs = dbDao.delChkPs(vos[i]);
					if(dRs.next()){

						if(dRs.getString("UPD_IND_CD").equals("Y")
								|| dRs.getString("UPD_IND_CD").equals("O")
								|| dRs.getString("UPD_IND_CD").equals("N")){ // "Y"는 "D"를 decode 한 값 (삭제 됐다는 표시)


							if(dRs.getString("UPD_IND_CD").equalsIgnoreCase("N")){

								vos[i].setSRouteFlg("T");

							}else if(dRs.getString("UPD_IND_CD").equalsIgnoreCase("O")){
//								if(vos[i].getSDupAllow() == null){
//									vos[i].setSDupAllow("");
//								}

//								if(vos[i].getSDupAllow().equals("Y")){
									vos[i].setSRouteFlg("T");
//								}
							}

							dbDao.historyOcnAddByLink(vos[i].getSPol(), vos[i].getSPod(), vos[i].getSLane(), vos[i].getSDir1(), vos[i].getSTs1Port(), vos[i].getSTs1Lane(), vos[i].getSDir2(), vos[i].getSTs2Port(), vos[i].getSTs2Lane(), vos[i].getSDir3(), vos[i].getSTs3Port(), vos[i].getSTs3Lane(), vos[i].getSDir4());
							retVal = dbDao.insertUpdatePs(vos[i]);
						}else{ 							
							throw new DAOException((new ErrorHandler("PRD00010")).getMessage());
							//throw new DAOException((new ErrorHandler("PRD90125")).getMessage());
						}
					}else{
						dRs = dbDao.getMaxSeqPs(vos[i]);

						int maxSeq = 0;

						if(dRs.next()){
							maxSeq = dRs.getInt("maxS");
							vos[i].setMaxSeq(maxSeq + "");
						}

						retVal = dbDao.insertOceanRoute(vos[i]);
						dbDao.historyOcnAdd(vos[i].getSPol(), vos[i].getSPod(), Integer.toString(maxSeq + 1));
					}


				}else if(vos[i].getIbflag().equals("U")){
					if(vos[i].getSRoutSeq() != null && !vos[i].getSRoutSeq().equals("")){
						dbDao.historyOcnAdd(vos[i].getSPol(), vos[i].getSPod(), vos[i].getSRoutSeq());
						retVal = dbDao.updateOceanRoute(vos[i]);
					}
				}else if(vos[i].getIbflag().equals("D")){
					dbDao.historyOcnAdd(vos[i].getSPol(), vos[i].getSPod(), vos[i].getSRoutSeq());
					retVal = dbDao.deleteOceanRoute(vos[i]);
				}
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
	 * 조회 이벤트 처리<br>
	 * OceanRouteManage화면에 대한 조회 이벤트 처리<br>
	 * ★2009-09-07 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<SearchOceanRouteAutoCreationVO> searchOceanRouteAutoCreationList(SearchOceanRouteAutoCreationVO vo) throws EventException{
		try{
			return dbDao.searchOceanRouteAutoCreationList(vo);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}

	}

	/**
	 * 조회 이벤트 처리<br>
	 * OceanRouteManage화면에 대한 조회 이벤트 처리<br>
	 * LaneConnection화면에 대한 조회 이벤트 처리<br>
	 * @param vo
	 * @return
	 * @throws EventException
	 */	
	public List<SearchOceanRouteStatusVO> searchOceanRouteStatusList(SearchOceanRouteStatusVO vo) throws EventException{

		try{
			return dbDao.searchOceanRouteStatusList(vo);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}

	}

	/**
	 * 수정 이벤트 처리<br>
	 * LaneConnection화면에 대한 조회 이벤트 처리<br>
	 * @param vos
	 * @param vo
	 * @param account
	 * @throws EventException
	 */		
	public void modifyOceanRouteStatus(SaveOceanRouteStatusVO[] vos, SearchOceanRouteStatusVO vo, SignOnUserAccount account) throws EventException{
		try{
			DBRowSet dRs = null;
			int retValUpdate = 0;
			for(int i = 0; i < vos.length; i++){
				vos[i].setCreOfcCd(account.getOfc_cd());
				vos[i].setCreUsrId(account.getUsr_id());
				vos[i].setUpdUsrId(account.getUsr_id());

				if(vos[i].getIbflag().equals("U")){
					//prd_svc_lane의 Upd_ind_cd 가 'N'(vsk_pf_skd, mdmd_svc_lane과 조인시 데이터가 없으면 null일때 nvl처리로 'N')
					if(vos[i].getSUpdIndCd().equals("N")){
						dRs = dbDao.oceanRouteStatusUpdate1(vos[i]);
						if(dRs.next()){
							throw new DAOException(new ErrorHandler("PRD00009", new String[]{vos[i].getSLaneCd(), vos[i].getSLaneTp()}).getMessage());
						}
                        // prd svc lane에 insert 
						retValUpdate = dbDao.oceanRouteStatusUpdate2(vos[i]);
						log.info("\n >>>>> Update Step2 retValUpdate :" + retValUpdate);
						
						//ocn route update
						retValUpdate = dbDao.oceanRouteStatusUpdate3(vos[i]);
						log.info("\n >>>>> Update Step3 retValUpdate :" + retValUpdate);


					}else if(vos[i].getSUpdIndCd().equals("U") || vos[i].getSUpdIndCd().equals("I") || vos[i].getSUpdIndCd().equals("D")){
						//log.info("\n >>>>> Update (ACTIVE, DELETED) Step1 retValUpdate :" + retValUpdate );
						//prd_svc_lane update
						retValUpdate = dbDao.oceanRouteStatusUpdate4(vos[i]);
                        // history add
						retValUpdate = dbDao.historyOcnAddByLaneDel(vos[i].getSLaneCd(), vos[i].getSLaneCd(), vos[i].getSLaneCd(), vos[i].getSLaneCd());
						//ocn rout 'S' flag 로 update
						retValUpdate = dbDao.oceanRouteStatusUpdate3(vos[i]);
						//vsk pf skd 수정은 금지 
//						retValUpdate = dbDao.oceanRouteStatusUpdate5(vos[i]);

					}

				}else if(vos[i].getIbflag().equals("D")){
					retValUpdate = dbDao.oceanRouteStatusDelete1(vos[i]);
					log.info("\n >>>>> Delete Step1 retValUpdate :" + retValUpdate);

					dRs = dbDao.oceanRouteStatusDelete2(vos[i]);
					if(!dRs.next()){
						dbDao.historyOcnAddByLaneDel(vos[i].getSLaneCd(), vos[i].getSLaneCd(), vos[i].getSLaneCd(), vos[i].getSLaneCd());
						retValUpdate = dbDao.oceanRouteStatusDelete3(vos[i]);
						log.info("\n >>>>> Delete Step3 retValUpdate :" + retValUpdate);
					}
				}
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
	 * 조회 이벤트 처리<br>
	 * LaneConnection화면에 대한 조회 이벤트 처리<br>
	 * @param vo
	 * @return 
	 * @throws EventException
	 */	
	public List<SearchLaneConnectionVO> searchLaneConnection(SearchLaneConnectionVO vo) throws EventException{
		try{
			return dbDao.searchLaneConnectionList(vo);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}

	}

	/**
	 * PRD 업무 시나리오 마감작업<br>
	 * OceanRouteManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd(){
		dbDao = null;
	}

	/**
	 * OceanRouteManageBCImpl's searchOceanLane
	 * ★2009-08-31 kim kwijin생성
	 * @param vo
	 * @param eventName
	 * @return
	 * @throws EventException
	 */
	public List<SearchOceanLaneVO> searchOceanLane(SearchOceanLaneVO vo, String eventName) throws EventException{
		try{

			List<SearchOceanLaneVO> list = dbDao.searchOceanLane(vo);

			if(eventName.equalsIgnoreCase("EsdPrd0035Event")){
				if(list.size() > 1){
					throw new EventException((new ErrorHandler("PRD00011")).getMessage());
				}
				if(list.size() == 0){
					throw new EventException((new ErrorHandler("PRD00001")).getMessage());
				}


			}
			return list;

		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}

	}

	/**
	 * 조회 이벤트 처리<br>
	 * OceanRouteManage화면에 대한 마스터 Row조회 이벤트 처리<br>
	 * ★ 2009-08-31 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<RowSearchOceanRouteManageVO> rowSearchOceanRouteManage(RowSearchOceanRouteManageVO vo) throws EventException{
		try{
			return dbDao.rowSearchOceanRouteManage(vo);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}


	}

	/**
	 * OceanRouteManageBCImpl's searchOceanRouteMultiCreationList
	 * Multi Creation시 Insert 한 Row에 대하여 중복 여부 Validation Check 
	 * ★2009-09-02 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<SearchOceanRouteMultiCreationVO> searchOceanRouteMultiCreationList(SearchOceanRouteMultiCreationVO vo) throws EventException{
		try{
			return dbDao.searchOceanRouteMultiCreationList(vo);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}

	}
	
	

    /**
     * 조회 이벤트 처리<br>
     * ESD_PRD_0016 화면에 대한 멀티 이벤트 처리<br>
     * @param SaveOceanRouteVO saveOceanRouteVO
     * @return String
     * @throws EventException
     */
    public String searchSameOceanRoute(SaveOceanRouteVO saveOceanRouteVO) throws EventException{
        String findFlg = "N";
        DBRowSet dRs = null;
        String tsIndCd = "D";

        
    	try{
                 if("".equals(saveOceanRouteVO.getSLnkCnt()) || Integer.parseInt(saveOceanRouteVO.getSLnkCnt()) > 1){
                        tsIndCd = "T";
                 }
                 saveOceanRouteVO.setTsIndCd(tsIndCd);
                 
                 SaveOceanRouteVO dupChkVO = new SaveOceanRouteVO();
     			
     			dupChkVO.setSPol(saveOceanRouteVO.getSPol());
     			dupChkVO.setSPod(saveOceanRouteVO.getSPod());
     			dupChkVO.setSTs1Port(saveOceanRouteVO.getSTs1Port());
     			dupChkVO.setSTs2Port(saveOceanRouteVO.getSTs2Port());
     			dupChkVO.setSTs3Port(saveOceanRouteVO.getSTs3Port());
     			dupChkVO.setSPol1(saveOceanRouteVO.getSPol1());
     			dupChkVO.setSPod1(saveOceanRouteVO.getSPod1());
     			dupChkVO.setSPod2(saveOceanRouteVO.getSPod2());
     			dupChkVO.setSPod3(saveOceanRouteVO.getSPod3());
     			dupChkVO.setSPod4(saveOceanRouteVO.getSPod4());
     			dupChkVO.setSDir1(saveOceanRouteVO.getSDir1());
     			dupChkVO.setSDir2(saveOceanRouteVO.getSDir2());
     			dupChkVO.setSDir3(saveOceanRouteVO.getSDir3());
     			dupChkVO.setSDir4(saveOceanRouteVO.getSDir4());
     			dupChkVO.setSLane(saveOceanRouteVO.getSTs1Lane());
     			dupChkVO.setSTs1Lane(saveOceanRouteVO.getSTs2Lane());
     			dupChkVO.setSTs2Lane(saveOceanRouteVO.getSTs3Lane());
     			dupChkVO.setSTs3Lane(saveOceanRouteVO.getSTs4Lane());
     			
                 dRs = dbDao.delChkPs(dupChkVO);
                 if(dRs.next()){
                        if(!(dRs.getString("UPD_IND_CD").equals("Y")
                                     || dRs.getString("UPD_IND_CD").equals("O")
                                     || dRs.getString("UPD_IND_CD").equals("N"))){ // "Y"는 "D"를 decode 한 값 (삭제 됐다는 표시)
                              findFlg = "Y";
                        }
                 }

          }catch(DAOException ex){
                 //log.error("err " + ex.toString(), ex);
                 throw new EventException(ex.getMessage(), ex);
          }catch(Exception ex){
                 //log.error("err " + ex.toString(), ex);
                 throw new EventException(ex.getMessage(), ex);
          }
          
          return findFlg;
          
    }
    
    /**
     * 조회 이벤트 처리<br>
     * ESD_PRD_0060 화면에 대한 Validation Check 이벤트 처리<br>
     * @param vo SearchOceanRouteSingleCreationVO
     * @return List<SearchOceanRouteSingleCreationVO>
     * @throws EventException
     */
    public List<SearchOceanRouteSingleCreationVO> searchOceanRouteSingleCreation(SearchOceanRouteSingleCreationVO vo) throws EventException{
		try{
			return dbDao.searchOceanRouteSingleCreation(vo);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}

	}
    
    /**
	 * Verify 버튼 이벤트 처리<br>
	 * ESD_PRD_0086 에 대한 추가 이벤트 처리<br>
	 * 
	 * @param inputVOs
	 * @return List<SaveOceanRouteVO>
	 * @throws EventException
	 */
    public List<SaveOceanRouteVO> searchOceanRouteValidationList(SaveOceanRouteVO[] inputVOs) throws EventException{
    	try{
    		List<SaveOceanRouteVO> outputVOs = new ArrayList<SaveOceanRouteVO>();
    		SearchOceanRouteSingleCreationVO inVO = new SearchOceanRouteSingleCreationVO();
    		SearchOceanRouteSingleCreationVO outVO = new SearchOceanRouteSingleCreationVO();
    		SaveOceanRouteVO dupChkVO = new SaveOceanRouteVO();
    		
    		String errDesc = new String();
    		String errTp = new String();
    		DBRowSet dRs = null;

    		for( int idx=0; idx < inputVOs.length ; idx++ ){
    			inVO.setSPol(inputVOs[idx].getSPol());
    			inVO.setSPod(inputVOs[idx].getSPod());
    			inVO.setSTs1Port(inputVOs[idx].getSTs1Port());
    			inVO.setSTs2Port(inputVOs[idx].getSTs2Port());
    			inVO.setSTs3Port(inputVOs[idx].getSTs3Port());
    			inVO.setSTs1Lane(inputVOs[idx].getSTs1Lane());
    			inVO.setSTs2Lane(inputVOs[idx].getSTs2Lane());
    			inVO.setSTs3Lane(inputVOs[idx].getSTs3Lane());
    			inVO.setSTs4Lane(inputVOs[idx].getSTs4Lane());
    			outVO = dbDao.searchOceanRouteSingleCreation(inVO).get(0);
    			
    			
    			
    			
//    			if( inputVOs[idx].getSPrior() == null || inputVOs[idx].getSPrior().equals("") ){
//    				inputVOs[idx].setSPrior(outVO.getPrio());
//    			}
    			inputVOs[idx].setSPrior(outVO.getPrio());
    			inputVOs[idx].setSPol(outVO.getOrgLocCd());
    			inputVOs[idx].setSPod(outVO.getDestLocCd());
    			inputVOs[idx].setSPol1(outVO.getPol1());
    			inputVOs[idx].setSPol2(outVO.getPol2());
    			inputVOs[idx].setSPol3(outVO.getPol3());
    			inputVOs[idx].setSPol4(outVO.getPol4());
    			inputVOs[idx].setSPod1(outVO.getPod1());
    			inputVOs[idx].setSPod2(outVO.getPod2());
    			inputVOs[idx].setSPod3(outVO.getPod3());
    			inputVOs[idx].setSPod4(outVO.getPod4());
    			inputVOs[idx].setSDir1(outVO.getDir1());
    			inputVOs[idx].setSDir2(outVO.getDir2());
    			inputVOs[idx].setSDir3(outVO.getDir3());
    			inputVOs[idx].setSDir4(outVO.getDir4());
    			inputVOs[idx].setSFdrFlg1(outVO.getFdrFlg1());
    			inputVOs[idx].setSFdrFlg2(outVO.getFdrFlg2());
    			inputVOs[idx].setSFdrFlg3(outVO.getFdrFlg3());
    			inputVOs[idx].setSFdrFlg4(outVO.getFdrFlg4());
    			inputVOs[idx].setSTs1Type(outVO.getSvcTp1());
    			inputVOs[idx].setSTs2Type(outVO.getSvcTp2());
    			inputVOs[idx].setSTs3Type(outVO.getSvcTp3());
    			inputVOs[idx].setSTs4Type(outVO.getSvcTp4());
    			inputVOs[idx].setSFU(outVO.getFdrUsd());
    			inputVOs[idx].setSLnkCnt(outVO.getLinkCount());
    			inputVOs[idx].setSN1stTztmHrs(outVO.getTt1());
    			inputVOs[idx].setSN2ndTztmHrs(outVO.getTt2());
    			inputVOs[idx].setSN3rdTztmHrs(outVO.getTt3());
    			inputVOs[idx].setSN4thTztmHrs(outVO.getTt4());
    			inputVOs[idx].setSN1stStayTmHrs(outVO.getSt1());
    			inputVOs[idx].setSN2ndStayTmHrs(outVO.getSt2());
    			inputVOs[idx].setSN3rdStayTmHrs(outVO.getSt3());
    			inputVOs[idx].setFmtTotTt(outVO.getFmtTotTt());
    			inputVOs[idx].setFmtTotSt(outVO.getFmtTotSt());
    			inputVOs[idx].setFullRout(outVO.getFullRout());
//    			inputVOs[idx].setSUpdIndCd(outVO.getUpdIndCd());
    			errDesc = dbDao.searchOceanRouteValidation(inputVOs[idx]);
    			
    			
    			
    			
    			dupChkVO.setSPol(inputVOs[idx].getSPol());
    			dupChkVO.setSPod(inputVOs[idx].getSPod());
    			dupChkVO.setSTs1Port(inputVOs[idx].getSTs1Port());
    			dupChkVO.setSTs2Port(inputVOs[idx].getSTs2Port());
    			dupChkVO.setSTs3Port(inputVOs[idx].getSTs3Port());
    			dupChkVO.setSPol1(outVO.getPol1());
    			dupChkVO.setSPod1(outVO.getPod1());
    			dupChkVO.setSPod2(outVO.getPod2());
    			dupChkVO.setSPod3(outVO.getPod3());
    			dupChkVO.setSPod4(outVO.getPod4());
    			dupChkVO.setSDir1(outVO.getDir1());
    			dupChkVO.setSDir2(outVO.getDir2());
    			dupChkVO.setSDir3(outVO.getDir3());
    			dupChkVO.setSDir4(outVO.getDir4());
    			dupChkVO.setSLane(inputVOs[idx].getSTs1Lane());
    			dupChkVO.setSTs1Lane(inputVOs[idx].getSTs2Lane());
    			dupChkVO.setSTs2Lane(inputVOs[idx].getSTs3Lane());
    			dupChkVO.setSTs3Lane(inputVOs[idx].getSTs4Lane());
    			dRs = dbDao.delChkPs(dupChkVO);
    			
//    			if( errDesc == null || errDesc.equals("") || errDesc.length() == 0 ){
//    				if (Integer.parseInt(outVO.getTotTt()) > (45 * 24)) {
//    					errDesc = "E13";
//    				}
//    			}
    			if( errDesc == null || errDesc.equals("") || errDesc.length() == 0 ){
    				if( dRs.next() ){
    					if( !dRs.getString("UPD_IND_CD").equals("Y")){ // "Y"는 "D"를 decode 한 값 (삭제 됐다는 표시)
    						errDesc = "E98"; //dup 
    					}
    				} else if( !outVO.getLinkValidFlg().equals("Y") ){
    					errDesc = "E99";
    				}
    			}
    			
    			if( errDesc == null || errDesc.equals("") ){
    				errTp = "N";
    				inputVOs[idx].setSChk("1");
    			} else{
    				errTp = "Y";
    				inputVOs[idx].setSChk("0");
    			}
    			inputVOs[idx].setSErrDesc(errDesc);
    			inputVOs[idx].setSErrTp(errTp);
    			outputVOs.add(inputVOs[idx]);
    		}
    		
    		return outputVOs;
    	}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
    }
	
}
