/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : InlandLinkManageBCImpl.java
 *@FileTitle : Inland Link 정보관리
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-09-19
 *@LastModifier : jungsunyong
 *@LastVersion : 1.0
 * 2006-09-19 jungsunyong
 * 1.0 최초 생성
 * history
 * 2010.11.03 채창호  CHM-201006834-01: Inland Link Management와 Route Management의 연동 Logic 변경요청.(2010년 8월 3일 이전버젼으로 원복 조치) 
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandlinkmanage.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandlinkmanage.integration.InlandLinkManageDBDAO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandlinkmanage.vo.PrdInlndEachLnkVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandlinkmanage.vo.SearchInlandLinkManageListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * alps-PRD Business Logic Basic Command implementation<br>
 * - alps-PRD에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author jungsunyong
 * @see ESD_PRD_009EventResponse,InlandLinkManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class InlandLinkManageBCImpl extends BasicCommandSupport implements InlandLinkManageBC{

	// Database Access Object
	private transient InlandLinkManageDBDAO dbDao = null;

	/**
	 * InlandLinkManageBCImpl 객체 생성<br>
	 * InlandLinkManageDBDAO를 생성한다.<br>
	 */
	public InlandLinkManageBCImpl(){
		dbDao = new InlandLinkManageDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * InlandLinkManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param vo
	 * @return response ESD_PRD_009EventResponse
	 * @exception EventException
	 */
	public List<PrdInlndEachLnkVO> searchInlandLinkManageList(PrdInlndEachLnkVO vo) throws EventException{
		try{
			return dbDao.searchInlandLinkManageList(vo);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * ★2009-08-13 kim kwijin
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<SearchInlandLinkManageListVO> searchInlandLinkManagePopup(SearchInlandLinkManageListVO vo) throws EventException{
		try{
			return dbDao.searchInlandLinkManageList(vo);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}


	}

	/**
	 * ★2009-08-13 kim kwijin 생성
	 * 2010.11.03 채창호  CHM-201006834-01: Inland Link Management와 Route Management의 연동 Logic 변경요청.(2010년 8월 3일 이전버젼으로 원복 조치) 
	 * @param vo
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public Map<String, String> multiInlandLinkManage(SearchInlandLinkManageListVO[] vo, SignOnUserAccount account) throws EventException{

		try{
			boolean isInsert = false;

			Map retVal = new HashMap();
			String pseudoChk = "";
			String pseudoCd = ""; //pseudo노드일때 리턴
			String blankCd = ""; // 없는 노드일떄 리턴해줌
			String invalidVendor = "";

			boolean resultVendorCheck = false;
			String ctyCd = "";
			String agmtSeq = "";
			int iAgmtSeq = 0;
			String agmt_no = "";

			log.debug("★저장 들어왔다");
			for(int i = 0; i < vo.length; i++){
				vo[i].setCreUsrId(account.getUsr_id());
				vo[i].setUpdUsrId(account.getUsr_id());
				vo[i].setCreOfcCd(account.getOfc_cd());

				ctyCd = "";
				agmtSeq = "";
				iAgmtSeq = 0;
				agmt_no = vo[i].getAgmtNo();

				if(agmt_no != null && agmt_no.length() > 4){
					ctyCd = agmt_no.substring(0, 3);
					agmtSeq = agmt_no.substring(3);
					iAgmtSeq = Integer.parseInt(agmtSeq);
				}

				vo[i].setCtyCd(ctyCd);
				vo[i].setAgmtSeq(agmtSeq);
				vo[i].setIAgmtSeq(iAgmtSeq + "");

				if(vo[i].getIbflag().equals("I")){
					log.debug("★insert 여기들어왔다");
					pseudoChk = dbDao.pseudoTypeFromToCheck(vo[i].getLnkOrgNodCd(), vo[i].getLnkDestNodCd());
					log.debug("★pseudoChk:::" + pseudoChk);
					resultVendorCheck = dbDao.validationVendor(vo[i].getVndrSeq());
					log.debug("★resultVendorCheck:::" + resultVendorCheck);
					if(!resultVendorCheck){
						invalidVendor = invalidVendor + (invalidVendor.length() > 0 ? "," : "") + vo[i].getVndrSeq();
					}

					if(pseudoChk.equals("3")){ //양쪽다 수도 
						pseudoCd = pseudoCd + (pseudoCd.length() > 0 ? "," : "") + vo[i].getLnkOrgNodCd() + "," + vo[i].getLnkDestNodCd();
						continue;
					}else if(pseudoChk.equals("2")){ //from 이 수도
						pseudoCd = pseudoCd + (pseudoCd.length() > 0 ? "," : "") + vo[i].getLnkDestNodCd();
						continue;
					}else if(pseudoChk.equals("1")){ //to 가 수도 
						pseudoCd = pseudoCd + (pseudoCd.length() > 0 ? "," : "") + vo[i].getLnkOrgNodCd();
						continue;
					}else if(pseudoChk.equals("4")){ // from,to 의 노드가 없을때 
						blankCd = blankCd + (blankCd.length() > 0 ? "," : "") + vo[i].getLnkOrgNodCd() + "," + vo[i].getLnkDestNodCd();
					}else if(pseudoChk.equals("5")){ // from  의 노드가 없을때 
						blankCd = blankCd + (blankCd.length() > 0 ? "," : "") + vo[i].getLnkOrgNodCd();
						continue;
					}else if(pseudoChk.equals("6")){ // from  의 노드가 없을때 
						blankCd = blankCd + (blankCd.length() > 0 ? "," : "") + vo[i].getLnkDestNodCd();
						continue;
					}
					if(!resultVendorCheck){
						continue;
					}
					isInsert = true;

					dbDao.mergeInlandLink(vo[i]);
				}else if(vo[i].getIbflag().equals("U")){
					log.debug("★update 여기들어왔다");
					log.debug("★tztm_hrs::::::" + vo[i].getTztmHrs());
					dbDao.updateInlandLink(vo[i]);//★이부분은 한건씩 말고 여러건으로 돌려야겠다

				}else if(vo[i].getIbflag().equals("D")){
					log.debug("★delete 여기들어왔다");
					dbDao.deleteInlandLink(vo[i]); //★이부분은 한건씩 말고 여러건으로 돌려야겠다
					dbDao.deleteInlndRoutMst(vo[i].getLnkOrgNodCd(), vo[i].getLnkDestNodCd(), vo[i].getTrspModCd(), account.getUsr_id());
				}
			}
			retVal.put("pseudoCd", pseudoCd);
			retVal.put("blankCd", blankCd);
			retVal.put("invalidVendorCd", invalidVendor);

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
	 * PRD 업무 시나리오 마감작업<br>
	 * InlandLinkManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd(){
		dbDao = null;
	}

	/**
	 * 
	 * @param vo
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public List<PrdInlndEachLnkVO> multiAgmtNo(PrdInlndEachLnkVO[] vo, SignOnUserAccount account) throws EventException{
		try{
			List<PrdInlndEachLnkVO> prdInlndEachLnkVO = new ArrayList<PrdInlndEachLnkVO>();
			String validAgmtNoRoute = "";
			String validUpdateRoute = "";

			for(int i = 0; i < vo.length; i++){
				log.debug("★update실행::::");
				String ctyCd = "";
				String agmtSeq = "";
				int iAgmtSeq = 0;
				String vndSeq = vo[i].getVndrSeq();
				String agmt_no = vo[i].getAgmtNo();

				if(agmt_no != null && agmt_no.length() > 4){
					ctyCd = agmt_no.substring(0, 3);
					agmtSeq = agmt_no.substring(3);
					iAgmtSeq = Integer.parseInt(agmtSeq);
				}


				vo[i].setCreUsrId(account.getUsr_id());
				vo[i].setCreOfcCd(account.getOfc_cd());
				vo[i].setUpdUsrId(account.getUsr_id());
				vo[i].setCtyCd(ctyCd);
				vo[i].setIAgmtNo(iAgmtSeq + "");
				vo[i].setIAgmtSeq(iAgmtSeq + "");

				if(dbDao.isAgmtNoRight(ctyCd, iAgmtSeq, vndSeq)){
					int res = dbDao.multiAgmtNo(vo[i]);

					if(res == 0){
						validUpdateRoute = validUpdateRoute + " ," + vo[i].getLnkOrgNodCd() + " to " + vo[i].getLnkDestNodCd();
						vo[i].setResult("NOT LINK");
					}else{
						vo[i].setResult("OK");
						dbDao.updateInlandRouteAgmtNo(vo[i].getLnkOrgNodCd(), vo[i].getLnkDestNodCd(), vo[i].getTrspModCd(), vo[i].getVndrSeq(), ctyCd, iAgmtSeq);
					}
				}else{
					validAgmtNoRoute = validAgmtNoRoute + " ," + vo[i].getLnkOrgNodCd() + " to " + vo[i].getLnkDestNodCd();
					vo[i].setResult("UNMATCH AGMT_NO");
				}

				if(i == (vo.length - 1)){
					vo[i].setValidUpdateRoute(validUpdateRoute);
					vo[i].setValidAgmtNoRoute(validAgmtNoRoute);
				}

				prdInlndEachLnkVO.add(vo[i]);
			}
			return prdInlndEachLnkVO;

		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}


	}
}
