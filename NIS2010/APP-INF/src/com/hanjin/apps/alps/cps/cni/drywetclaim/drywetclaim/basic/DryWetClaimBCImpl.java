/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DryWetClaimBCImpl.java
*@FileTitle : DW Claim Main
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.10.12 윤세영
* 1.0 Creation
* --------------------------------------------------------------
* Histroy
* 2011.08.08 이준범[CHM-201112635-01]
* 제목 : Dry Wet Claim 등록 시 알림 Mail Auto 발송 요청
* 내용 : DW Claim Main 에서 최초 등록하여 Case No가 부여 될 때, 자동으로 Auto-Notice(Web Mail) 되도록 보완)
=========================================================*/
package com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.basic;
 
import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.integration.DryWetClaimDBDAO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.CniDwTrnsVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.CondSearchStatusListVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.ContainerHandlingCostVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.CustomDryWetClaimVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.CustomHandlingCostVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.HandlerHistoryVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.ManagerHistoryVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.SearchAgentVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.SearchDryWetClaimCodeListVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.SearchDryWetClaimVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.SearchHandlingCostListVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.SearchHandlingCostVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.SearchRoeListVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.SearchStatusListVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.SearchVesselListVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.SearchVesselVvdListVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.TransferCondVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.TransferVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.component.javamail.Mail;

/**
 * Dry&Wet Claim Business Logic Command Interface<br>
 * - Dry&Wet Claim에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Yoon, Seyeong
 * @see DryWetClaimBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class DryWetClaimBCImpl extends BasicCommandSupport implements DryWetClaimBC {

	// Database Access Object
	private transient DryWetClaimDBDAO dbDao = null;

	/**
	 * DryWetClaimBCImpl 객체 생성<br>
	 * DryWetClaimDBDAO를 생성한다.<br>
	 */
	public DryWetClaimBCImpl() {
		dbDao = new DryWetClaimDBDAO();
	}
	/**
	 * Dry & Wet Claim을 조회한다.<br>
	 * 
	 * @param String dwClmNo
	 * @return SearchDryWetClaimVO
	 * @exception EventException
	 */
	public SearchDryWetClaimVO searchDryWetClaim(String dwClmNo) throws EventException {

		try {
			
			return dbDao.searchDryWetClaim(dwClmNo);
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09011",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09011",new String[]{}).getMessage(), ex);
		}
		
	}
	
	/**
	 * Dry & Wet Claim를 생성 및 변경한다.<br>
	 * 
	 * @param CustomDryWetClaimVO customDryWetClaimVO
	 * @param CniDwTrnsVO cniDwTrnsVO
	 * @param String usrId
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String manageDryWetClaim(CustomDryWetClaimVO customDryWetClaimVO, CniDwTrnsVO cniDwTrnsVO, String usrId, String ofcCd) throws EventException{
		
		String dwClmNo = null;		
		String manageFlg = null;
		try {

			if ( customDryWetClaimVO.getDwClmNo().equals("")){//Insert
				
				String hdlrOfcCd = null ;
				String usrNm = null;
				dwClmNo = dbDao.searchDwClmNo(customDryWetClaimVO.getDwClmTpCd());
			
				customDryWetClaimVO.setDwClmNo(dwClmNo);
				customDryWetClaimVO.setCreUsrId(usrId);
				
				dbDao.addmanageDryWetClaim(customDryWetClaimVO);
				
				hdlrOfcCd = customDryWetClaimVO.getHdlrOfcCd();
				
				usrNm = dbDao.searchUserIdName(usrId);
				
				/** 2011.08.08 이준범[CHM-201112635-01]
				 * Dry Wet Claim 등록 시 알림 Mail Auto 발송 요청
				 */
				///////////////////////////////////////////////////
				StringBuffer sbContents = new StringBuffer();
				
				sbContents.append("Case No. "+dwClmNo+" is just registered by "+usrNm+" in "+hdlrOfcCd+" <br>");
				sbContents.append("Please review the case in CNI - Dry Wet Claim accordingly.");
				
				Mail mail = new Mail();
				mail.setFrom("postmaster@hanjin.com");						//보내는 사람 메일주소
				mail.setSubject(" New Case Notice - Case No. ["+dwClmNo+"]");	//메일제목
				mail.setRecipient("lawinsu@hanjin.com");				//받는 사람 메일주소
				mail.setHtmlContent(sbContents.toString());
				mail.send();
				///////////////////////////////////////////////////				
				
				manageFlg = "INSERT";
			} else {//Update
				dwClmNo = customDryWetClaimVO.getDwClmNo();
				customDryWetClaimVO.setDwClmNo(dwClmNo);
				customDryWetClaimVO.setUpdUsrId(usrId);
				
				dbDao.modifyDryWetClaim(customDryWetClaimVO);
				manageFlg = "UPDATE";
			}
			
			//Transfer 가 체크("Y")되면 
			String trnsFlg = customDryWetClaimVO.getTrnsFlg();
			String clmTrnsAuthCd = cniDwTrnsVO.getClmTrnsAuthCd();
			cniDwTrnsVO.setCreUsrId(usrId);
			cniDwTrnsVO.setUpdUsrId(usrId);
			cniDwTrnsVO.setTrnsOfcCd(ofcCd);//Office Cd 저장
			cniDwTrnsVO.setTrnsFmOfcCd(customDryWetClaimVO.getCreOfcCd());
			cniDwTrnsVO.setTrnsFmUsrId(customDryWetClaimVO.getHdlrUsrId());

			if (trnsFlg.equals("Y") && clmTrnsAuthCd.equals("") ){
				dbDao.addTransfer(cniDwTrnsVO);
			} else if ((trnsFlg.equals("N") || trnsFlg.equals("")) && (clmTrnsAuthCd.equals("W") || clmTrnsAuthCd.equals("R"))){
				dbDao.removeTransfer(cniDwTrnsVO);
			}
			//Status가 변경되면 이력 등록
			String beforeDwClmStsCd = customDryWetClaimVO.getDwClmStsCdOrg();
			String afterDwClmStsCd = customDryWetClaimVO.getDwClmStsCd();
			if ((!afterDwClmStsCd .equals(beforeDwClmStsCd)) ||
				("".equals(beforeDwClmStsCd) && "".equals(afterDwClmStsCd) && manageFlg.equals("INSERT"))) {
				//dbDao.addDryWetClaimHis(dwClmNo, customDryWetClaimVO.getDwClmStsCd(), usrId);
				// ---------------------------------------------
				// 상태변경 처리후  Status History에 이력정보 설정
				// ---------------------------------------------				
				HandlerHistoryVO handlerHistoryVO = new HandlerHistoryVO();
				handlerHistoryVO.setDwClmNo(dwClmNo);
				handlerHistoryVO.setUpdUsrId(usrId);
				handlerHistoryVO.setCreUsrId(usrId);				
				
				handlerHistoryVO.setHdlrOfcCd(ofcCd);
				handlerHistoryVO.setHdlrUsrId(usrId);
				
				manageHandlerHistory(handlerHistoryVO, customDryWetClaimVO.getDwClmStsCd());
			}

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09012",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09012",new String[]{}).getMessage(), ex);
		}
		
		return dwClmNo;
	}
	
	/**
	 * Dry & Wet Claim의 MISCELLANEOUS  코드를 조회한다.<br>
	 * 
	 * @param String typeCd
	 * @return List<SearchDryWetClaimCodeListVO>
	 * @exception EventException
	 */
	public List<SearchDryWetClaimCodeListVO> searchDryWetClaimCodeList(String typeCd) throws EventException {
		try {
			
    		String[] cdId      = typeCd.split(":");
    		List<SearchDryWetClaimCodeListVO> searchDryWetClaimCodeListVO = new ArrayList<SearchDryWetClaimCodeListVO>();
    		
    		for (int i=0; i<cdId.length; i++) {
    			List<SearchDryWetClaimCodeListVO> list = dbDao.searchDryWetClaimCodeList(cdId[i]);
    			
    			StringBuffer clmMiscCd = new StringBuffer();
    			StringBuffer clmMiscNm = new StringBuffer();
    			for (int j=0; j<list.size(); j++) {
    				clmMiscCd.append(list.get(j).getClmMiscCd()+"|");
    				clmMiscNm.append(list.get(j).getClmMiscNm()+"|");
    			}
				
				SearchDryWetClaimCodeListVO searchDryWetClaimCodeVO = new SearchDryWetClaimCodeListVO();
				searchDryWetClaimCodeVO.setClmMiscCd(clmMiscCd.toString());
				searchDryWetClaimCodeVO.setClmMiscNm(clmMiscNm.toString());
    			searchDryWetClaimCodeListVO.add(searchDryWetClaimCodeVO);
    		}
    		
    		return searchDryWetClaimCodeListVO;
    		
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09010",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09010",new String[]{}).getMessage(), ex);
		}
		
	}
	
	/**
	 * Handler 코드를 조회한다.<br>
	 * 
	 * @param String handler
	 * @return String
	 * @exception EventException
	 */
	public String searchDryWetClaimHandler(String handler) throws EventException {
		try {
			return dbDao.searchDryWetClaimHandler(handler);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09015",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09015",new String[]{}).getMessage(), ex);
		}
		
	}
	
	/**
	 * 통화를 검사한다.<br>
	 * 
	 * @param String currCd
	 * @return String
	 * @exception EventException
	 */
	public String searchCurrency(String currCd) throws EventException {
		try {
			return dbDao.searchCurrency(currCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09016",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09016",new String[]{}).getMessage(), ex);
		}
		
	}
	
	/**
	 * Agent 에 관련된 전화번호, e-Mail 정보를 조회한다.<br>
	 * 
	 * @param String agentCd
	 * @return List<SearchAgentVO>
	 * @exception EventException
	 */
	public List<SearchAgentVO> searchAgent(String agentCd ) throws EventException {
		try {
			return dbDao.searchAgent(agentCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09020",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09020",new String[]{}).getMessage(), ex);
		}
		
	}
	/**
	 * Dry & Wet Claim를 Status Close한다.<br>
	 * 
	 * @param dwClmNo String
	 * @param usrId String
	 * @param String ofcCd
	 * @exception EventException
	 */
	public void modifyCloseDryWetClaim(String dwClmNo, String usrId, String ofcCd) throws EventException{
		
		try {
	
			//Status 업데이트
			dbDao.modifyCloseDryWetClaim(dwClmNo, usrId);
			//Status 이력 등록
			//dbDao.addDryWetClaimHis(dwClmNo, "CC", usrId);
			// ---------------------------------------------
			// 상태변경 처리후  Status History에 이력정보 설정
			// ---------------------------------------------				
			HandlerHistoryVO handlerHistoryVO = new HandlerHistoryVO();
			handlerHistoryVO.setDwClmNo(dwClmNo);
			handlerHistoryVO.setUpdUsrId(usrId);
			handlerHistoryVO.setCreUsrId(usrId);				
			
			handlerHistoryVO.setHdlrOfcCd(ofcCd);
			handlerHistoryVO.setHdlrUsrId(usrId);
			
			manageHandlerHistory(handlerHistoryVO, "CC");
				
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09021",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09021",new String[]{}).getMessage(), ex);
		}
		
	}
	/**
	 * Dry & Wet Claim를 Status Reopen한다.<br>
	 * 
	 * @param dwClmNo String
	 * @param usrId String
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String modifyReopenDryWetClaim(String dwClmNo, String usrId, String ofcCd) throws EventException{
		
		try {
	
			//Status 이력 테이블에서 바로 전단계 Status를 조회한다.
			String statusCd = dbDao.searchDryWetClaimHis(dwClmNo);
			//Status 업데이트
			dbDao.modifyReopenDryWetClaim(dwClmNo, statusCd, usrId);
			//Status 이력 등록
			//dbDao.addDryWetClaimHis(dwClmNo, statusCd, usrId);
			// ---------------------------------------------
			// 상태변경 처리후  Status History에 이력정보 설정
			// ---------------------------------------------				
			HandlerHistoryVO handlerHistoryVO = new HandlerHistoryVO();
			handlerHistoryVO.setDwClmNo(dwClmNo);
			handlerHistoryVO.setUpdUsrId(usrId);
			handlerHistoryVO.setCreUsrId(usrId);				
			
			handlerHistoryVO.setHdlrOfcCd(ofcCd);
			handlerHistoryVO.setHdlrUsrId(usrId);
			
			manageHandlerHistory(handlerHistoryVO, statusCd);	
			return statusCd;
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09022",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09022",new String[]{}).getMessage(), ex);
		}
		
	}
	/**
	 * Dry & Wet Claim를 Status Cancel한다.<br>
	 * 
	 * @param dwClmNo String
	 * @param usrId String
	 * @param String ofcCd
	 * @exception EventException
	 */
	public void modifyCancelDryWetClaim(String dwClmNo, String usrId, String ofcCd) throws EventException{
		
		try {
	
			//Status 업데이트
			dbDao.modifyCancelDryWetClaim(dwClmNo, usrId);
			//Status 이력 등록
			//dbDao.addDryWetClaimHis(dwClmNo, "XX", usrId);
			// ---------------------------------------------
			// 상태변경 처리후  Status History에 이력정보 설정
			// ---------------------------------------------				
			HandlerHistoryVO handlerHistoryVO = new HandlerHistoryVO();
			handlerHistoryVO.setDwClmNo(dwClmNo);
			handlerHistoryVO.setUpdUsrId(usrId);
			handlerHistoryVO.setCreUsrId(usrId);				
			
			handlerHistoryVO.setHdlrOfcCd(ofcCd);
			handlerHistoryVO.setHdlrUsrId(usrId);
			
			manageHandlerHistory(handlerHistoryVO, "XX");
				
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09013",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09013",new String[]{}).getMessage(), ex);
		}
		
	}
	
	/**
	 * 선박명를 조회한다.<br>
	 * 
	 * @param String vslCd
	 * @return String
	 * @exception EventException
	 */
	public String searchVesselName(String vslCd) throws EventException {
		try {
			return dbDao.searchVesselName(vslCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09014",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09014",new String[]{}).getMessage(), ex);
		}
		
	}
	
	/**
	 * Claim 및Incident Case 접수 및 처리 현황 조회한다.<br>
	 * 
	 * @param CondSearchStatusListVO condSearchStatusListVO
	 * @return List<SearchStatusListVO>
	 * @exception EventException
	 */
	public List<SearchStatusListVO> searchStatusList(CondSearchStatusListVO condSearchStatusListVO) throws EventException {
		try {
			return dbDao.searchStatusList(condSearchStatusListVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09019",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09019",new String[]{}).getMessage(), ex);
		}
		
	}
	
	/**
	 * Office Code를 검사한다.<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchDryWetClaimOffice(String ofcCd) throws EventException {
		try {
			return dbDao.searchDryWetClaimOffice(ofcCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09027",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09027",new String[]{}).getMessage(), ex);
		}
		
	}
	
	/**
	 * 선박 항차 정보를 조회한다.<br>
	 * 
	 * @param String vvdCd
	 * @param String vslEngNm
	 * @return List<SearchVesselVvdListVO>
	 * @exception EventException
	 */
	public List<SearchVesselVvdListVO> searchVesselVvdList(String vvdCd, String vslEngNm) throws EventException {
		try {
			
			List<SearchVesselVvdListVO> searchVesselVvdListVO = null;
			
			searchVesselVvdListVO = dbDao.searchVesselVvdList(vvdCd, vslEngNm);
			
			return searchVesselVvdListVO;
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09029",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09029",new String[]{}).getMessage(), ex);
		}
		
	}
	
	/**
	 * 경리환율 정보를 조회한다.<br>
	 * 
	 * @param String fmDt
	 * @param String toDt
	 * @param String currCd
	 * @return List<SearchRoeListVO>
	 * @exception EventException
	 */
	public List<SearchRoeListVO> searchRoeList(String fmDt, String toDt, String currCd) throws EventException {
		try {
			
			return dbDao.searchRoeList(fmDt, toDt, currCd);
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09030",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09030",new String[]{}).getMessage(), ex);
		}
		
	}
	
	/**
	 * 해당 Case 관련 발생된 제 처리비용을 조회한다.<br>
	 * 
	 * @param String dwClmNo
	 * @return ContainerHandlingCostVO
	 * @exception EventException
	 */
	public ContainerHandlingCostVO searchHandlingCostList(String dwClmNo) throws EventException {
		try {
			
			ContainerHandlingCostVO containerHandlingCostVO = new ContainerHandlingCostVO();

			SearchHandlingCostVO searchHandlingCostVO = dbDao.searchHandlingCost(dwClmNo);
			List<SearchHandlingCostListVO> searchHandlingCostListVO = dbDao.searchHandlingCostList(dwClmNo);

			containerHandlingCostVO.setSearchHandlingCostVO(searchHandlingCostVO);
			containerHandlingCostVO.setSearchHandlingCostListVOs(searchHandlingCostListVO);
			
			return containerHandlingCostVO;
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09017",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09017",new String[]{}).getMessage(), ex);
		}
		
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * 해당 Case 관련 발생된 제 처리비용을 생성 및 변경한다<br>
	 * 
	 * @param customHandlingCostVOs CustomHandlingCostVO[]
	 * @param dwClmNo String
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageHandlingCost(CustomHandlingCostVO[] customHandlingCostVOs, String dwClmNo, String usrId) throws EventException{
		try {
			List<CustomHandlingCostVO> addVoList = new ArrayList<CustomHandlingCostVO>();
			List<CustomHandlingCostVO> modifyVoList = new ArrayList<CustomHandlingCostVO>();
			List<CustomHandlingCostVO> removeVoList = new ArrayList<CustomHandlingCostVO>();
			
			for ( int i=0; i<customHandlingCostVOs.length; i++ ) {
				
				//Case No. setting
				customHandlingCostVOs[i].setDwClmNo(dwClmNo);
				
				//환율의 컴마 제거
				customHandlingCostVOs[i].setInvXchRt(customHandlingCostVOs[i].getInvXchRt().replaceAll(",", ""));

				if ( customHandlingCostVOs[i].getIbflag().equals("I")){
					
					//Payee 검사
					String clmPtyNo = dbDao.searchCheckPayee(customHandlingCostVOs[i].getClmPtyNo());
					if (clmPtyNo == null) {
						throw new EventException(new ErrorHandler("CNI09032",new String[]{" No. : "+JSPUtil.getRPAD(customHandlingCostVOs[i].getSeqNo(), 4, " ")+" Payee : "+customHandlingCostVOs[i].getClmPtyNo() + " ("+customHandlingCostVOs[i].getClmPtyNm()+")"}).getMessage());
					}
					
					customHandlingCostVOs[i].setLoclCurrCd(customHandlingCostVOs[i].getLoclCurrCd().toUpperCase());
					//Currency 검사
					String currCd = dbDao.searchCurrency(customHandlingCostVOs[i].getLoclCurrCd());
					if (currCd == null) {
						throw new EventException(new ErrorHandler("CNI09016",new String[]{" No. : "+JSPUtil.getRPAD(customHandlingCostVOs[i].getSeqNo(), 4, " ")+" Currency : "+customHandlingCostVOs[i].getLoclCurrCd()}).getMessage());
					}

					customHandlingCostVOs[i].setCreUsrId(usrId);
					addVoList.add(customHandlingCostVOs[i]);
				} else if ( customHandlingCostVOs[i].getIbflag().equals("U")){
					customHandlingCostVOs[i].setUpdUsrId(usrId);
					modifyVoList.add(customHandlingCostVOs[i]);
				} else if ( customHandlingCostVOs[i].getIbflag().equals("D")){
					customHandlingCostVOs[i].setUpdUsrId(usrId);
					removeVoList.add(customHandlingCostVOs[i]);
				}
			}
			
			if ( addVoList.size() > 0 ) {
				dbDao.addHandlingCosts(addVoList);
			}
			
			if ( modifyVoList.size() > 0 ) {
				dbDao.modifyHandlingCosts(modifyVoList);
			}
			
			if ( removeVoList.size() > 0 ) {
				dbDao.removeHandlingCosts(removeVoList);
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI09018",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI09018",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * 선박 정보를 조회한다.<br>
	 * 
	 * @param String vslCd
	 * @param String vslNm
	 * @return List<SearchVesselListVO>
	 * @exception EventException
	 */
	public List<SearchVesselListVO> searchVesselList(String vslCd, String vslNm) throws EventException {
		try {
			
			return dbDao.searchVesselList(vslCd, vslNm);
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09031",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09031",new String[]{}).getMessage(), ex);
		}
		
	}
	// ===========================================================================
    // 정행룡
    // ===========================================================================

    // ---------------------------------------------------------------------------
    // [CPS_CNI_0310] Handler History
    // ---------------------------------------------------------------------------

	/**
	 * Claim No별 Handler History 목록 정보 조회<br>
	 * @author 정행룡
	 * @category CPS_CNI_0310
	 * @category searchHandlerHistoryList 
	 * @param String dwClmNo
	 * @return List<HandlerHistoryVO>
     * @throws EventException
     */
	public List<HandlerHistoryVO> searchHandlerHistoryList(String dwClmNo) throws EventException {
		try {
			return dbDao.searchHandlerHistoryList(dwClmNo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		}
	}
	
	// ---------------------------------------------------------------------------
    // [CPS_CNI_0311] Manager History
    // ---------------------------------------------------------------------------

	/**
	 * Claim No별 Manager History 목록 정보 조회<br>
	 * @author 정행룡
	 * @category CPS_CNI_0311
	 * @category searchManagerHistoryList 
	 * @param String dwClmNo
     * @return List<ManagerHistoryVO>
     * @throws EventException
     */
	public List<ManagerHistoryVO> searchManagerHistoryList(String dwClmNo) throws EventException {
		try {
			return dbDao.searchManagerHistoryList(dwClmNo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Claim Manager 정보 등록, 수정, 삭제 처리<br>
	 * @author 정행룡
	 * @category CPS_CNI_0311
	 * @category manageManagerHistory 
	 * @param HandlerHistoryVO[] handlerHistoryVOs 
	 * @exception EventException
	 */
	public void manageManagerHistory(HandlerHistoryVO[] handlerHistoryVOs) throws EventException {
		try {

			List<HandlerHistoryVO> addVoList = new ArrayList<HandlerHistoryVO>();
			List<HandlerHistoryVO> modifyVoList = new ArrayList<HandlerHistoryVO>();
			List<HandlerHistoryVO> deleteVoList = new ArrayList<HandlerHistoryVO>();

			for (int i = 0; i < handlerHistoryVOs.length; i++) {

				// C,U,D 플래그 취득
				String ibFlag = handlerHistoryVOs[i].getIbflag();

				if ("I".equals(ibFlag)) {
					addVoList.add(handlerHistoryVOs[i]);
				} else if ("U".equals(ibFlag)) {
					modifyVoList.add(handlerHistoryVOs[i]);
				} else if ("D".equals(ibFlag)) {
					deleteVoList.add(handlerHistoryVOs[i]);
				}
			}

			// 데이타 입력
			if (addVoList.size() > 0) {
				dbDao.addManagerHistory(addVoList);
			}

			// 데이타 수정
			if (modifyVoList.size() > 0) {
				dbDao.modifyManagerHistory(modifyVoList);
			}

			// 데이터 삭제
			if (deleteVoList.size() > 0) {
				dbDao.removeManagerHistory(deleteVoList);
			}

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Claim Handler 정보 등록, 수정<br>
	 * @author 정행룡
	 * @category CPS_CNI_0311
	 * @category manageHandlerHistory 
	 * @param HandlerHistoryVO handlerHistoryVO 
	 * @param String afterDwClmStsCd
	 * @exception EventException
	 */
	public void manageHandlerHistory(HandlerHistoryVO handlerHistoryVO, String afterDwClmStsCd) throws EventException {
		try {
	
			dbDao.modifyHandlerHistory(handlerHistoryVO);
			handlerHistoryVO.setDwClmStsCd(afterDwClmStsCd);
			dbDao.addHandlerHistory(handlerHistoryVO);
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Handler History 정보 등록<br>
	 * @author 정행룡
	 * @category CPS_CNI_0301
	 * @category addHandlerHistory
	 * @param HandlerHistoryVO handlerHistoryVO
	 * @exception EventException
	 */
	public void addHandlerHistory(HandlerHistoryVO handlerHistoryVO) throws EventException {
		try {
			dbDao.addHandlerHistory(handlerHistoryVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Handler History 정보 수정<br>
	 * @author 정행룡
	 * @category CPS_CNI_0301
	 * @category modifyHandlerHistory
	 * @param HandlerHistoryVO handlerHistoryVO
	 * @exception EventException
	 */
	public void modifyHandlerHistory(HandlerHistoryVO handlerHistoryVO) throws EventException {
		try {
			dbDao.modifyHandlerHistory(handlerHistoryVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		}
	}
		
	// ---------------------------------------------------------------------------
    // [CPS_CNI_0312] Transfer
    // ---------------------------------------------------------------------------
	/**
	 * Transfer 리스트 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0312
	 * @category searchTransferList 
	 * @param TransferCondVO transferCondVO
     * @return List<TransferVO> 
     * @throws EventException
     */	
	public List<TransferVO> searchTransferList(TransferCondVO transferCondVO) throws EventException {
		try {
			
			List<TransferVO> returnList = new ArrayList<TransferVO>();
			
			returnList = dbDao.searchTransferList(transferCondVO);
			
			if (returnList != null && !returnList.isEmpty()) {
				TransferVO vo = returnList.get(0);
				int maxRows = Integer.parseInt(vo.getTotal());
				vo.setMaxRows(maxRows);
			}			
			
			return returnList;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}
	}
	
    /**
	 * Transfer 멀티 이벤트 처리<br>
	 * @author 양정란
	 * @category CPS_CNI_0312
	 * @category manageTransfer
	 * @param TransferVO[] transferVOs
	 * @exception EventException
	 */
	public void manageTransfer(TransferVO[] transferVOs) throws EventException {		
		
		try{
			
			if (transferVOs != null) {				
				for (int i = 0; i < transferVOs.length; i++) {
					TransferVO transferVO = transferVOs[i];
										
					String ibflag = transferVO.getIbflag();					
					if ("U".equals(ibflag)) {
						dbDao.modifyTransfer(transferVO);
						
						// Main 에 Update
						dbDao.modifyTransferClaimMain(transferVO.getDwClmNo() , transferVO.getUpdUsrId() , transferVO.getTrnsToUsrId(), transferVO.getTrnsToOfcCd());
						
						if(transferVO.getDiv().equals("TO")&& transferVO.getClmTrnsAuthCd().equals("A")){
						// HandlerHistory에 저장		
						HandlerHistoryVO handlerHistoryVO = new HandlerHistoryVO();
						handlerHistoryVO.setDwClmNo(transferVO.getDwClmNo());
						handlerHistoryVO.setUpdUsrId(transferVO.getUpdUsrId());
						handlerHistoryVO.setCreUsrId(transferVO.getUpdUsrId());				
						handlerHistoryVO.setHdlrOfcCd(transferVO.getTrnsToOfcCd());
						handlerHistoryVO.setHdlrUsrId(transferVO.getTrnsToUsrId());
						
						manageHandlerHistory(handlerHistoryVO, transferVO.getClmMiscCd());		
						}
					} 				
				}
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage());
		}		
	}
	
}