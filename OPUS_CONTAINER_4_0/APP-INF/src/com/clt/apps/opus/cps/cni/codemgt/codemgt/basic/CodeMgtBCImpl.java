/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CodeMgtBCImpl.java
 *@FileTitle : 공통코드및 기준정보 관리
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.05
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2009.10.05 박제성 , 진윤오 , 정행룡 , 양정란 , 윤세영
 * 1.0 Creation
 * --------------------------------------------------------------
 * History
 * CHM-201004242 윤진영 managePartyContactPoint에  vender값이 넘어 오지 않을때 
                 mdm_customer에서 refund_seq를 가져와서 vender값에 넣어주고 둘다 없는경우 null처리
 * 2010.12.10 이준범 [CHM-201007236-01]
 * 1.제목 : CNI Main Code Creation Logic 보완 및 Popup 화면 추가 요청
 * 2.처리내역
 *  2.1 Main code creation시 Code 생성 규칙에 따른 중복 유사 Code를 검색하여 
 *      그 결과를 Popup display하며 User의 선택에  따라 생성 또는 Detail 
 *      information을 확인할 수 있는 Main Code View 화면으로 이동하도록 보완                  
=========================================================*/
package com.clt.apps.opus.cps.cni.codemgt.codemgt.basic;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.cps.cni.codemgt.codemgt.integration.CodeMgtDBDAO;
import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.ClassCodeVO;
import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.CniClassCodeVO;
import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.CniCntcPntVO;
import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.CniMiscCodeVO;
import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.CniPartyVO;
import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.ContactPointVO;
import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.HandlerHistoryVO;
import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.MdmOrganizationVO;
import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.MiscCodeVO;
import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.MiscellaneousVO;
import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.PartyCntVO;
import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.PartyInquiryCondVO;
import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.PartyInquiryVO;
import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.PartyVO;
import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.SearchAgentVO;
import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.SearchClaimCodeListVO;
import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.SearchRoeListVO;
import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.SearchVesselListVO;
import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.SearchVesselVvdListVO;
import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.VvdSkdCondVO;
import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.VvdSkdVO;
import com.clt.apps.opus.cps.cni.common.CniConst;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAO;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;


/**
 *  CNI 코드 관련 Business Logic Basic Command implementation<br>
 *  CNI 코드 관련 비지니스 로직을 처리한다.<br>
 * 
 * @author cyo
 * @see DAO 클래스 참조
 * @since J2EE 1.4
 */
public class CodeMgtBCImpl extends BasicCommandSupport implements CodeMgtBC {

    // Database Access Object
    private transient CodeMgtDBDAO dbDao = null;

    /**
     * CodeMgtBCImpl 객체 생성<br>
     * CodeMgtDBDAO 생성한다.<br>
     */
    public CodeMgtBCImpl() {
        dbDao = new CodeMgtDBDAO();
    }


    // ---------------------------------------------------------------------------
    // 공통 
    // ---------------------------------------------------------------------------
	/**
	 * CNI GMT(YYYY-MM-DD)  조회<br>
	 * @author 진윤오
	 * @category common
	 * @category searchGmtDate 
	 * @param String userId
     * @return String
     * @throws EventException
     */
    public String searchGmtDate(String userId) throws EventException {
		try {
			return dbDao.searchGmtDate(userId);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		}
	}
    
    
    // ===========================================================================
    // 진윤오
    // ===========================================================================    
    // ---------------------------------------------------------------------------
    // [CPS_CNI_0025] Main Code Creation
    // ---------------------------------------------------------------------------

	/**
	 * Claim Party 정보 조회<br>
	 * @author 진윤오
	 * @category CPS_CNI_0025
	 * @category searchPartyInfo 
	 * @param String clmPtyNo
     * @return PartyVO 
     * @throws EventException
     */
	public PartyVO searchPartyInfo(String clmPtyNo) throws EventException {
		try {
			return dbDao.searchPartyInfo(clmPtyNo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		}
	}
    	
	/**
	 * Claim Party 별 Cni Contact Point 리스트 조회<br>
	 * @author 진윤오
	 * @category CPS_CNI_0025
	 * @category searchContactPointList 
	 * @param String clmPtyNo
     * @return List<ContactPointVO> 
     * @throws EventException
     */
	public List<ContactPointVO> searchContactPointList(String clmPtyNo) throws EventException {
		try {
			return dbDao.searchContactPointList(clmPtyNo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		}
	}
	
	
	/**
	 * Claim Party 정보 및 Contact Point  수정 ,입력<br>
	 * @author 진윤오
	 * @category CPS_CNI_0025
	 * @category managePartyNContactPoint 
	 * @param PartyCntVO partyCntVO
	 * @return String
	 * @exception EventException
	 */
	public String managePartyContactPoint(PartyCntVO partyCntVO) throws EventException {

		try {		
			
			CniPartyVO cniPartyVO = partyCntVO.getCniPartyVO();
			//사용자 정보
			String userId = cniPartyVO.getCreUsrId();
			
			// claim party no 취득
			String clmPtyNo = cniPartyVO.getClmPtyNo();
			
			// claim party code 설정
			// name의 고정8 및 대문자 
			String clmPtyAbbrNm = cniPartyVO.getPtyNm();
			String duplicateFlag = cniPartyVO.getDuplicateFlag();
			
			if (clmPtyAbbrNm != null) {
				
				clmPtyAbbrNm = clmPtyAbbrNm.toUpperCase();
				
				//워드를 제외한 문자(공백,특수문자)는 공백 처리
				//clmPtyAbbrNm = clmPtyAbbrNm.replaceAll("[^\\w]", "");
				if (clmPtyAbbrNm.length() > 8) {
					clmPtyAbbrNm = clmPtyAbbrNm.substring(0,8);
				}				
				
				clmPtyAbbrNm = clmPtyAbbrNm.trim();				
				
				int cnt = dbDao.searchClmPtyAbbrNmCount(clmPtyAbbrNm);
		
				if (cnt > 0 && StringUtils.isEmpty(clmPtyNo) && "Y".equals(duplicateFlag)){
					return "Y";
				}
				
				if (cnt > 1 && "Y".equals(duplicateFlag)){
					return "Y";
				}
				
				if (cnt > 0) {
					//clmPtyAbbrNm 연번부여 999번 까지만		
					int len = clmPtyAbbrNm.length();
					StringBuffer tmp = new StringBuffer(clmPtyAbbrNm);
					for (int i = len; i < 8; i++) {
//						clmPtyAbbrNm = clmPtyAbbrNm + " ";
						tmp.append(" ");
					}
					clmPtyAbbrNm = tmp.toString();
					String subStr = clmPtyAbbrNm.substring(0,5);
					String nm = dbDao.searchPartyMaxCodeList(subStr);
					
					if (StringUtils.isEmpty(nm)) {
						subStr = clmPtyAbbrNm.substring(0,6);
						nm = dbDao.searchPartyMaxCodeList(subStr);
						if (StringUtils.isEmpty(nm)) {
							subStr = clmPtyAbbrNm.substring(0,7);
							nm = dbDao.searchPartyMaxCodeList(subStr);
							if (StringUtils.isEmpty(nm)) {
								clmPtyAbbrNm = subStr + "1";
							} else {
								String abbr = nm.substring(0,7);						
								int num = new Integer(nm.substring(7,8)) + 1;							
								if (num == 10) {
									clmPtyAbbrNm = abbr.substring(0,6) + num;
								} else {
									clmPtyAbbrNm = abbr + num;
								}
							}
						} else {
							String abbr = nm.substring(0,6);						
							int num = new Integer(nm.substring(6,8)) + 1;							
							if (num == 100) {
								clmPtyAbbrNm = abbr.substring(0,5) + num;
							} else {
								clmPtyAbbrNm = abbr + num;
							}

						}
					} else {						
						String abbr = nm.substring(0,5);						
						int num = new Integer(nm.substring(5,8)) + 1;							
						if (num == 10) {
							clmPtyAbbrNm = abbr.substring(0,6) + num;
						} else {
							clmPtyAbbrNm = abbr + num;
						}
					}
										
				}				
							
			}else{
				clmPtyAbbrNm = "";
			}
						
			cniPartyVO.setClmPtyAbbrNm(clmPtyAbbrNm);
			//  claim party no가 존재하지 않는 경우 신규
			if (StringUtils.isEmpty(clmPtyNo)||clmPtyNo.equals("undefined")) {
				//vender , refund 구해와야 mdm_customer에서..party에 vender에 넣는다.
				cniPartyVO.setVndrSeq(dbDao.searchMdmVndrRfndList(cniPartyVO.getCntCd(),cniPartyVO.getCustSeq()));
				//신규 sequence취득
				clmPtyNo = dbDao.searchSequenceNo(CniConst.CNI_CLM_PTY_NO_SEQ);
				// 추가 처리
				cniPartyVO.setClmPtyNo(clmPtyNo);
				// 부모 claim party no는 claim party no로 설정
				cniPartyVO.setPrntClmPtyNo(clmPtyNo);
				cniPartyVO.setDeltFlg("N");
				dbDao.addParty(cniPartyVO);
			} else {
				// 갱신 처리 
				//vender code가 없으면 refund code를vender code에 넣고 둘다 없으면 null을 넣는다. party vender에다가..
				if(StringUtils.isEmpty(cniPartyVO.getVndrSeq())||clmPtyNo.equals("undefined")) {
					cniPartyVO.setVndrSeq(dbDao.searchMdmVndrRfndList(cniPartyVO.getCntCd(),cniPartyVO.getCustSeq()));
				}
				dbDao.modifyParty(cniPartyVO);				
				
			}
						
			CniCntcPntVO[] cniCntcPntVOs = partyCntVO.getCniCntcPntVO();
			
			// ------------------------------------------------------------
			// Contact point가 존재하는경우 전건 추가
			// claim party no가 존재하는 경우 위에서 삭제처리후 전건 추가
			// ------------------------------------------------------------			
			if (cniCntcPntVOs != null) {				
				for (int i = 0; i < cniCntcPntVOs.length; i++) {
					CniCntcPntVO cniCntcPntVO = cniCntcPntVOs[i];
					cniCntcPntVO.setUpdUsrId(userId);
					cniCntcPntVO.setCreUsrId(userId);
					
					String ibflag = cniCntcPntVO.getIbflag();					
					if ("I".equals(ibflag)) {
						String clmCntcPntSeq =  dbDao.searchSequenceNo(CniConst.CNI_CLM_CNTC_PNT_SEQ);
						cniCntcPntVO.setClmPtyNo(clmPtyNo);
						cniCntcPntVO.setClmCntcPntSeq(clmCntcPntSeq);						
						dbDao.addContactPoint(cniCntcPntVO);
					} else if ("U".equals(ibflag)) {
						cniCntcPntVO.setClmPtyNo(clmPtyNo);
						
						dbDao.modifyContactPoint(cniCntcPntVO);
					} else if ("D".equals(ibflag)) {
						cniCntcPntVO.setClmPtyNo(clmPtyNo);
						
						dbDao.removeContactPoint(cniCntcPntVO);
					}					
				}
				
			} 			
			
			return clmPtyNo;
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		}
	}		
	
	/**
	 * Claim Party 정보 삭제<br>
	 * @author 진윤오
	 * @category CPS_CNI_0025
	 * @category removeParty 
	 * @param CniPartyVO cniPartyVO
	 * @exception EventException
	 */
	public void removeParty(CniPartyVO cniPartyVO) throws EventException {
		try {
			dbDao.removeParty(cniPartyVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		}
	}
    
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0026] Main Code-Inquiry
	// ---------------------------------------------------------------------------
	/**
	 * Claim Party 리스트 조회<br>
	 * @author 진윤오
	 * @category CPS_CNI_0026
	 * @category searchPartyInquiryList 
	 * @param PartyInquiryCondVO partyInquiryCondVO
     * @return List<PartyInquiryVO>
     * @throws EventException
     */
	public List<PartyInquiryVO> searchPartyInquiryList(PartyInquiryCondVO partyInquiryCondVO) throws EventException {
		try {
			return dbDao.searchPartyInquiryList(partyInquiryCondVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		}
	}
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0095] Main Code-Popup
	// ---------------------------------------------------------------------------
	/**
	 * Claim Party 리스트 조회<br>
	 * @author 진윤오
	 * @category CPS_CNI_0026
	 * @category searchPartyPopupList 
	 * @param String ptyNm
     * @return List<PartyInquiryVO>
     * @throws EventException
     */
	public List<PartyInquiryVO> searchPartyPopupList(String ptyNm) throws EventException {
		try {
			return dbDao.searchPartyPopupList(ptyNm);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		}
	}	
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI-0042] 
	// ---------------------------------------------------------------------------    
    /**
     * CCC VVD & SKD Inquiry 
	 * vvd  Vessel schedule 리스트 조회<br>
	 * @author 진윤오
	 * @category CPS_CNI_0042
	 * @category searchVvdSkdList 
	 * @param VvdSkdCondVO vvdSkdCondVO
     * @return List<VvdSkdVO>
     * @throws EventException
     */
    public List<VvdSkdVO> searchVvdSkdList(VvdSkdCondVO vvdSkdCondVO) throws EventException {
		try {
			return dbDao.searchVvdSkdList(vvdSkdCondVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		}
    }
    // ===========================================================================
    // 양정란
    // ===========================================================================

    // ---------------------------------------------------------------------------
    // [CPS_CNI_0007] Office Code Creation
    // ---------------------------------------------------------------------------	
	/**
	 * Office Code 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0007
	 * @category searchMdmOrganizationList 
	 * @param String ofcCd
     * @return List<MdmOrganizationVO>
     * @throws EventException
     */	
	
	public List<MdmOrganizationVO> searchMdmOrganizationList(String ofcCd) throws EventException {
		try {
			return dbDao.searchMdmOrganizationList(ofcCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * Office Code 입력값 validation<br>
	 * @author 양정란
	 * @category CPS_CNI_0036
	 * @category searchOfcCd 
	 * @param String ofcCd
     * @return String[]
     * @throws EventException
     */	
	public String[] searchOfcCd(String ofcCd) throws EventException {
		try {
			String[] returnList = null;
			
			returnList = dbDao.searchOfcCd(ofcCd);
			
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
	 * UsrId 입력값 validation<br>
	 * @author 양정란
	 * @category CPS_CNI_0036
	 * @category searchUsrId 
	 * @param String ofcCd
	 * @param String usrId
     * @return String[]
     * @throws EventException
     */	
	public String[] searchUsrId(String ofcCd, String usrId) throws EventException {
		try {
			
			String[] returnList = null;
			
			returnList = dbDao.searchUsrId(ofcCd, usrId);
			
			return returnList;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}
	}	


	// ===========================================================================
    // 정행룡
    // ===========================================================================

    // ---------------------------------------------------------------------------
    // [CPS_CNI_0004] Handler History
    // ---------------------------------------------------------------------------

	/**
	 * Claim No별 Handler History 목록 정보 조회<br>
	 * @author 정행룡
	 * @category CPS_CNI_0004
	 * @category searchHandlerHistoryList 
	 * @param String cgoClmNo
	 * @param String mgrHdlrDivCd
     * @return List<HandlerHistoryVO>
     * @throws EventException
     */
	public List<HandlerHistoryVO> searchHandlerHistoryList(String cgoClmNo, String mgrHdlrDivCd) throws EventException {
		try {
			return dbDao.searchHandlerHistoryList(cgoClmNo,mgrHdlrDivCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		}
	}
	
	// ---------------------------------------------------------------------------
    // [CPS_CNI_0005] Manager History
    // ---------------------------------------------------------------------------

	/**
	 * Claim No별 Manager History 목록 정보 조회<br>
	 * @author 정행룡
	 * @category CPS_CNI_0004
	 * @category searchHandlerHistoryList 
	 * @param String cgoClmNo
	 * @param String mgrHdlrDivCd
     * @return List<HandlerHistoryVO>
     * @throws EventException
     */
	public List<HandlerHistoryVO> searchManagerHistoryList(String cgoClmNo, String mgrHdlrDivCd) throws EventException {
		try {
			return dbDao.searchHandlerHistoryList(cgoClmNo, mgrHdlrDivCd);
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
	 * @category CPS_CNI_0005
	 * @category manageManagerHistory 
	 * @param HandlerHistoryVO[] HandlerHistoryVO 
	 * @exception EventException
	 */
	public void manageManagerHistory(HandlerHistoryVO[] handlerHistoryVO) throws EventException {
		try {

			List<HandlerHistoryVO> addVoList = new ArrayList<HandlerHistoryVO>();
			List<HandlerHistoryVO> modifyVoList = new ArrayList<HandlerHistoryVO>();
			List<HandlerHistoryVO> deleteVoList = new ArrayList<HandlerHistoryVO>();

			for (int i = 0; i < handlerHistoryVO.length; i++) {

				// C,U,D 플래그 취득
				String ibFlag = handlerHistoryVO[i].getIbflag();

				if ("I".equals(ibFlag)) {
					addVoList.add(handlerHistoryVO[i]);
				} else if ("U".equals(ibFlag)) {
					modifyVoList.add(handlerHistoryVO[i]);
				} else if ("D".equals(ibFlag)) {
					deleteVoList.add(handlerHistoryVO[i]);
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
	 * @category CPS_CNI_0005
	 * @category manageHandlerHistory 
	 * @param HandlerHistoryVO HandlerHistoryVO 
	 * @param String afterCgoClmStsCd
	 * @exception EventException
	 */
	public void manageHandlerHistory(HandlerHistoryVO handlerHistoryVO, String afterCgoClmStsCd) throws EventException {
		try {
			handlerHistoryVO.setCgoClmHisTpCd("T");	
			dbDao.modifyHandlerHistory(handlerHistoryVO);
			handlerHistoryVO.setCgoClmStsCd(afterCgoClmStsCd);
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
	 * @category CPS_CNI_0003
	 * @category addHandlerHistory
	 * @param HandlerHistoryVO HandlerHistoryVO
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
	 * @category CPS_CNI_0003
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
	
	/**
	 * Class Code Validation 체크 조회<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category searchMiscCodeExist
	 * @param String clssClmMiscCd
	 * @param String clmMiscCd
     * @return String
     * @throws EventException
     */
	public String searchMiscCodeExist(String clssClmMiscCd, String clmMiscCd) throws EventException {
		try {
			return dbDao.searchMiscCodeExist(clssClmMiscCd, clmMiscCd );
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		}
	}
	
	

    /**
	 * Office Code 체크 조회<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category searchMdmOrganizationExist
	 * @param String ofcCd
     * @return String
    * @throws EventException
    */
	public String searchMdmOrganizationExist(String ofcCd) throws EventException{
	
		try {
			return dbDao.searchMdmOrganizationExist(ofcCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		}
	}

	// ===========================================================================
    // 박제성
    // ===========================================================================

    // ---------------------------------------------------------------------------
    // [CPS_CNI_0039] Class Code Creation
    // ---------------------------------------------------------------------------
	
	/**
	 * Class Code 리스트 조회<br>
	 * @author 박제성
	 * @category CPS_CNI_0039
	 * @category searchClassCodeList
	 * 	
     * @return Class Code 리스트 정보 
     * @throws EventException
     */
	public List<ClassCodeVO> searchClassCodeList() throws EventException {
		try {
			return dbDao.searchClassCodeList();
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage());
		}
	}
	
	
    /**
	 * Class Code 멀티 이벤트 처리<br>
	 * 
	 * @author 박제성
	 * @category CPS_CNI_0039
	 * @category manageClassCode
	 * 
	 * @param cniClassCodeVOs
	 *            CniClassCodeVO[]
	 * @exception EventException
	 */
	public void manageClassCode(CniClassCodeVO[] cniClassCodeVOs) throws EventException {		
		
		try {			
			
			if (cniClassCodeVOs != null) {				
				for (int i = 0; i < cniClassCodeVOs.length; i++) {
					CniClassCodeVO cniClassCodeVO = cniClassCodeVOs[i];
										
					String ibflag = cniClassCodeVO.getIbflag();					
					if ("I".equals(ibflag)) {

						dbDao.addClassCode(cniClassCodeVO);
					} else if ("U".equals(ibflag)) {
						dbDao.modifyClassCode(cniClassCodeVO);
					} else if ("D".equals(ibflag)) {
						dbDao.removeClassCode(cniClassCodeVO);
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
	
	
    // ===========================================================================
    // 박제성
    // ===========================================================================

    // ---------------------------------------------------------------------------
    // [CPS_CNI_0028] Miscellaneous Code Creation
    // ---------------------------------------------------------------------------

	/**
	 * Miscellaneous Code 리스트 조회<br>
	 * @author 진윤오
	 * @category CPS_CNI_0028
	 * @category searchMiscellaneousList  
	 * @param String clssClmMiscCd
     * @return List<MiscellaneousVO>
     * @throws EventException
     */
	public List<MiscellaneousVO> searchMiscellaneousList (String clssClmMiscCd) throws EventException {
		try {
			return dbDao.searchMiscellaneousList(clssClmMiscCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Miscellaneous Code 리스트 조회<br>
	 * @author 박제성
	 * @category CPS_CNI_0028
	 * @category searchMiscCodeList 
	 * @param  String clssClmMiscCd
	 * @param String clmMiscCd
	 * @param String clmMiscNm
     * @return Miscellaneous Code 리스트 정보 
     * @throws EventException
     */
	public List<MiscCodeVO> searchMiscCodeList(String clssClmMiscCd, String clmMiscCd, String clmMiscNm) throws EventException {
		try {
			return dbDao.searchMiscCodeList(clssClmMiscCd, clmMiscCd, clmMiscNm);
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage());
		}
	}
	
	
    /**
	 * Miscellaneous Code 멀티 이벤트 처리<br>
	 * 
	 * @author 박제성
	 * @category CPS_CNI_0028
	 * @category manageMiscCode
	 * 
	 * @param cniMiscCodeVOs
	 *            CniMiscCodeVO[]
	 * @exception EventException
	 */
	public void manageMiscCode(CniMiscCodeVO[] cniMiscCodeVOs) throws EventException {		
		
		try{
			
			if (cniMiscCodeVOs != null) {				
				for (int i = 0; i < cniMiscCodeVOs.length; i++) {
					CniMiscCodeVO cniMiscCodeVO = cniMiscCodeVOs[i];
										
					String ibflag = cniMiscCodeVO.getIbflag();					
					if ("I".equals(ibflag)) {
						dbDao.addMiscCode(cniMiscCodeVO);
					} else if ("U".equals(ibflag)) {
						dbDao.modifyMiscCode(cniMiscCodeVO);
					} else if ("D".equals(ibflag)) {
						dbDao.removeMiscCode(cniMiscCodeVO);
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
	
	/**
	 * Currency Check<br>
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
	
	/**
	 * Dry & Wet Claim의 MISCELLANEOUS  코드를 조회한다.<br>
	 * 
	 * @param String typeCd
	 * @return List<SearchClaimCodeListVO>
	 * @exception EventException
	 */
	public List<SearchClaimCodeListVO> searchClaimCodeList(String typeCd) throws EventException {
		try {
			
    		String[] cdId      = typeCd.split(":");
    		List<SearchClaimCodeListVO> searchClaimCodeListVO = new ArrayList<SearchClaimCodeListVO>();
    		
    		for (int i=0; i<cdId.length; i++) {
    			List<SearchClaimCodeListVO> list = dbDao.searchClaimCodeList(cdId[i]);
    			
    			StringBuffer clmMiscCd = new StringBuffer();
    			StringBuffer clmMiscNm = new StringBuffer();
    			for (int j=0; j<list.size(); j++) {
    				clmMiscCd.append(list.get(j).getClmMiscCd()+"|");
    				clmMiscNm.append(list.get(j).getClmMiscNm()+"|");
    			}
				
				SearchClaimCodeListVO searchClaimCodeVO = new SearchClaimCodeListVO();
				searchClaimCodeVO.setClmMiscCd(clmMiscCd.toString());
				searchClaimCodeVO.setClmMiscNm(clmMiscNm.toString());
    			searchClaimCodeListVO.add(searchClaimCodeVO);
    		}
    		
    		return searchClaimCodeListVO;
    		
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09010",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09010",new String[]{}).getMessage(), ex);
		}
		
	}
	
}