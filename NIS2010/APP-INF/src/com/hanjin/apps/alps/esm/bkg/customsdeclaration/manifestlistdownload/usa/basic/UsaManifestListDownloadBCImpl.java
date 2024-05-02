/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UsaManifestListDownloadBCImpl.java
 *@FileTitle : CM Data Check Set-up
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.23
 *@LastModifier : 이수빈
 *@LastVersion : 1.0
 * 2009.04.23 이수빈
 * 1.0 Creation
 *  
 * 2011.06.01 민정호 [CHM-201111028] AMS - Customs Data Download (D/L) 화면 validation추가
 * 2011.10.12 윤태승 [CHM-201113684-01][ESM_BKG] US AMS 의 MI 중복전송 기능 요청 - IDhjsedlee
 * 2012.01.31 민정호 [CHM-201215726-01] AMS 전송시 Customs 로직 추가 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgReferenceNoGenerationVO;
import com.hanjin.apps.alps.esm.bkg.common.CountryCode;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaRcvMsgVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.ClearanceTypeCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.ClearanceTypeDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.InBondNumberDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.InBondNumberVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.UsaInbondContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.UsaInbondDataVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.UsaInbondManifestDetailListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.vo.InbondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.basic.ManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration.UsaManifestListDownloadDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration.UsaManifestListDownloadDBDAOsearchUserAuthMiMultiYnRSQL;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.ExpRuleSetupVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.ImpRuleSetupVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.OrgPartyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.RuleSetupCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsCustomsStatusNoticeVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaAiBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaBlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaBlCustVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaBlCustomerSecondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaBlDetailContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaBlKeyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaCntrListRsltVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaCntrManifestCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaCntrSealNoListRsltVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaContainerManifestDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaContainerManifestListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaDownloadSummaryVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaHblCheckCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaHblCheckDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaManifestListContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaManifestListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaManifestSearchCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaManifestSearchDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaSetupKeyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaVesselCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UserAuthListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UserAuthListModiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UserInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.AuthSetupListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.AuthSetupListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlKeyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ConatinerModificationtVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ContainerListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ContainerListRsltVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ContainerManifestCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.DispoCdDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.DispoCdListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.HouseBlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.HouseBlDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.SetupKeyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.SetupListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.SetupListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.SetupListModVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgCstmsAdvIbdVO;
import com.hanjin.syscommon.common.table.BkgCstmsIbdHisDtlVO;
import com.hanjin.syscommon.common.table.BkgCstmsIbdHisVO;
import com.hanjin.syscommon.common.table.MdmCountryVO;
import com.hanjin.syscommon.common.table.MdmPortVO;

/**
 * ALPS-manifestlistdownload Business Logic Basic Command implementation<br>
 * - ALPS-manifestlistdownload에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kim Dowan
 * @see ESM_BKG_0926EventResponse,UsaManifestListDownloadBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class UsaManifestListDownloadBCImpl extends ManifestListDownloadBCImpl {

    // Database Access Object
    private transient UsaManifestListDownloadDBDAO dbDao = null;

    /**
     * UsaManifestListDownloadBCImpl 객체 생성<br>
     * UsaManifestListDownloadDBDAO를 생성한다.<br>
     */
    public UsaManifestListDownloadBCImpl() {
        dbDao = new UsaManifestListDownloadDBDAO();
    }

 
	/**
     * 국가별 세관 관리 항목 setup 정보 조회<br>
     * 
     * @param SetupListCondVO setupListCondVO 
     * @return List<SetupListDetailVO>
     * @exception EventException
     */
    public List<SetupListDetailVO> searchSetupList(SetupListCondVO setupListCondVO) throws EventException {
        try {
        	return dbDao.searchRuleSetupList((RuleSetupCondVO)setupListCondVO);
        } catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		}
    }

    /**
     *  국가 코드 조회<br>
	 *  UsaManifestListDownload Combo List에서 사용하는 코드를 가져온다.<br>
	 *  
	 * @return List<MdmCountryVO>
     * @exception EventException
     */
    public List<MdmCountryVO> searchCountryCodeList() throws EventException {
        try {
        	return dbDao.searchCountryCodeList();
        } catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		}
    }

    /**
     *  포트 코드 조회<br>
	 *  UsaManifestListDownload Combo List에서 사용하는 코드를 가져온다.<br>
	 *  
	 * @param String cntCd 
	 * @return List<MdmPortVO>
     * @exception EventException 
     */
    public List<MdmPortVO> searchPortCodeList(String cntCd) throws EventException {
        try {
        	return dbDao.searchFiterPortList(cntCd);
        } catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		}
    }

    /**
     * 국가별 세관 관리 항목 setup 정보 저장<br>
     * 
     * @param SetupListModVO setupListModVO SetupListModVO
     * @param SignOnUserAccount account 
     * @exception EventException
     */
    public void modifySetupList(SetupListModVO setupListModVO, SignOnUserAccount account) throws EventException {
        try {
            
            List<ExpRuleSetupVO> expRuleSetupVOs = setupListModVO.getExpRuleSetupVOS();
            List<ImpRuleSetupVO> impRuleSetupVOs = setupListModVO.getImpRuleSetupVOS();
            
            ExpRuleSetupVO expRuleSetupVO = null;
            ImpRuleSetupVO impRuleSetupVO = null;
            
            for (int i=0; i < expRuleSetupVOs.size(); i++) {
            	expRuleSetupVO = expRuleSetupVOs.get(i);
            	expRuleSetupVO.setCreUsrId(account.getUsr_id());
            	expRuleSetupVO.setUpdUsrId(account.getUsr_id());
                if ( dbDao.modifyExportRuleSetup ( expRuleSetupVO ) == 0 ) {
                    dbDao.addExportRuleSetup ( expRuleSetupVO );
                }
            }

            for (int i=0; i < impRuleSetupVOs.size(); i++) {
            	impRuleSetupVO = impRuleSetupVOs.get(i);
            	impRuleSetupVO.setCreUsrId(account.getUsr_id());
            	impRuleSetupVO.setUpdUsrId(account.getUsr_id());
                if ( dbDao.modifyImportRuleSetup ( impRuleSetupVO ) == 0 ) {
                    dbDao.addImportRuleSetup ( impRuleSetupVO );
                }
            }

        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
        } catch (Exception e) {
            log.error("err " + e.toString(), e);
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), e);
        }
    } 

    /**
     * 국가별 세관 관리 항목 setup 정보 삭제<br>
     * 
     * @param SetupKeyVO setupKeyVO 
     * @param SignOnUserAccount account 
     * @exception EventException
     */
    public void modifySetupStatus(SetupKeyVO setupKeyVO, SignOnUserAccount account) throws EventException {
        try {
        	UsaSetupKeyVO usaSetupKeyVO = new UsaSetupKeyVO();
        	usaSetupKeyVO.setUpdUsrId(account.getUsr_id());
        	usaSetupKeyVO.setCntCd(setupKeyVO.getCntCd());
        	usaSetupKeyVO.setLocCd(setupKeyVO.getLocCd());
        	usaSetupKeyVO.setFrobFlg(setupKeyVO.getFrobFlg());
        	usaSetupKeyVO.setCstmsDivId(setupKeyVO.getCstmsDivId());
        	dbDao.modifySetupStatusForDelete( usaSetupKeyVO );
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
        } catch (Exception e) {
            log.error("err " + e.toString(), e);
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), e);
        }
    } 

    /**
     * Customer, Container, Commodity(CM) 등의 BL 정보를 세관테이블 내로 다운로드 받고 이를 조회/확인한다.<br>
     * 
     * @param BlCondVO blCondVO 
     * @return List<BlDetailVO>
     * @exception EventException
     */
	public List<BlDetailVO> inquiryBlData(BlCondVO blCondVO) throws EventException {
		try {
			UsaBlCondVO usaBlCondVO = (UsaBlCondVO)blCondVO;
//			usaBlCondVO.setBlNo(usaBlCondVO.getBlNos());
			usaBlCondVO.setCntCd(CountryCode.US);

			UsaBlDetailContainerVO containerVO = new UsaBlDetailContainerVO();
			if("0".equals(usaBlCondVO.getTabNo())){
				containerVO.setUsaAiBlInfoVO(dbDao.searchAiBl(usaBlCondVO));
			}
			else if("1".equals(usaBlCondVO.getTabNo())){
				containerVO.setUsaBlCustVOs(dbDao.searchCustomer(usaBlCondVO));
			}
			else if("2".equals(usaBlCondVO.getTabNo())){
				containerVO.setUsaBlCustomerSecondVOs(dbDao.searchCustomerSecond(usaBlCondVO));
			}
			else if("3".equals(usaBlCondVO.getTabNo())){
				containerVO.setUsaBlCustomsResultVOs(dbDao.searchCustomsResult(usaBlCondVO));
			}
			else if("4".equals(usaBlCondVO.getTabNo())){
				containerVO.setUsaBlRemarkVOs(dbDao.searchRemarks(usaBlCondVO));
			}
			else if("5".equals(usaBlCondVO.getTabNo())){
				containerVO.setUsaBlHistoryVOs(dbDao.searchHistory(usaBlCondVO));
			}
			else if("6".equals(usaBlCondVO.getTabNo())){
				containerVO.setUsaBlHblListVOs(dbDao.searchHblList(usaBlCondVO));
			}
			else if("7".equals(usaBlCondVO.getTabNo())){
				containerVO.setUsaBlMultiBlListVOs(dbDao.searchMultiBlList(usaBlCondVO));
			}

			List<BlDetailVO> detailVOs = new ArrayList<BlDetailVO>();
			detailVOs.add((BlDetailVO)containerVO);
			return detailVOs;
			
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
        } catch (Exception e) {
            log.error("err " + e.toString(), e);
            throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), e);
        }
	}


	/**
	 * User Auth List 조회<br>
	 * 
	 * @param AuthSetupListCondVO authSetupListCondVO 
	 * @return List<AuthSetupListVO>
	 * @exception EventException 
	 */
	public List<AuthSetupListVO> searchAuthSetupList (AuthSetupListCondVO authSetupListCondVO) throws EventException {
		try
		{
			return dbDao.searchUserAuthList((UserAuthListCondVO) authSetupListCondVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		}
	}


	/**
	 * Disposition Code Description 조회<br>
	 * 
	 * @param BlCondVO blCondVO 
	 * @return List<DispoCdDetailVO>
	 * @exception EventException
	 */
	public List<DispoCdDetailVO> searchCodeDesc(BlCondVO blCondVO) throws EventException {
		try{
			return dbDao.searchCodeDesc((UsaBlCondVO) blCondVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * User Auth List 정보 저장<br>
	 * 
	 * @param authSetupListVO AuthSetupListVO[]
	 * @return int
	 * @exception EventException
	 */
	public int manageAuthSetupList(AuthSetupListVO[] authSetupListVO) throws EventException {
		try
		{
			UserAuthListModiVO vo = null;
			List<UserAuthListModiVO> addList = new ArrayList<UserAuthListModiVO>();
			List<UserAuthListModiVO> delList = new ArrayList<UserAuthListModiVO>();

			for (int i = 0; i < authSetupListVO.length; i++)
			{
				vo = (UserAuthListModiVO) authSetupListVO[i];
				if ("I".equals(vo.getIbflag()))
				{
					addList.add(vo);
				}
				else if ("U".equals(vo.getIbflag()))
				{
					delList.add(vo);
					addList.add(vo);
				}
				else if ("D".equals(vo.getIbflag()))
				{
					delList.add(vo);
				}
				vo.setCreUsrId(vo.getUpdUsrId());
			}
			// 먼저 삭제하고 다시 저장
			if (delList.size() > 0)
			{
				dbDao.removeUserAuthSetup(delList);
			}
			if (addList.size() > 0)
			{
				dbDao.addUserAuthSetup(addList);
			}
		}
		catch (DAOException de)
		{
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		}
		catch (Exception e)
		{
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), e);
		}
		return 0;
	}

	/**
	 * 사용자의 권한을 확인하여 버튼 Disable 여부를 결정한다.<br>
	 * 
	 * @param String userId 
	 * @return List<UserInfoVO>
	 * @exception EventException
	 */
	public List<UserInfoVO> searchUserAuthority (String userId) throws EventException {
		try	{
			return dbDao.searchUserAuthInfo(userId);
		}catch(DAOException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		}catch (Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * 사용자의 권한을 확인하여 버튼 Disable 여부를 결정한다.<br>
	 * 
	 * @param String userId 
	 * @param String pgmNo
	 * @return String
	 * @exception EventException
	 */
	public String searchUserAuthYn (String userId, String pgmNo) throws EventException {
		try
		{
			return dbDao.searchUserAuthYn(userId, pgmNo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 사용자의 MI - MULTI 권한을 확인하여 버튼 Disable 여부를 결정한다.<br>
	 * 
	 * @param String userId 
	 * @return String
	 * @exception EventException
	 */
	public String searchUserAuthMiMultiYn (String userId) throws EventException {
		try
		{
			return dbDao.searchUserAuthMiMultiYn(userId);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * 로그인 한 사용자의 권한을 조회한다.<br>
	 * 
	 * @param String userId 
	 * @param String ofcCd 
	 * @return AuthSetupListVO
	 * @exception EventException
	 */
	public AuthSetupListVO searchUserAuthority (String userId, String ofcCd) throws EventException {
		try {
			return dbDao.searchUserAuthInfo(userId, ofcCd);
		} catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
        } catch (Exception e) {
            log.error("err " + e.toString(), e);
            throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), e);
        }
	}


	/**
	 * VVD,Port 등 입력 후 세관 신고 대상 List를 조회한다.<br>
	 * 
	 * @param ManifestListCondVO manifestListCondVO 
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	public List<ManifestListDetailVO> searchManifestList(ManifestListCondVO manifestListCondVO) throws EventException {
		try {	
			UsaManifestListContainerVO containerVO = new UsaManifestListContainerVO();
			UsaManifestListCondVO condVO = (UsaManifestListCondVO)manifestListCondVO;
			
			String customs = condVO.getCustoms();
			customs = customs.length() > 6 ? customs.substring(0,6) : customs;
			condVO.setCustoms(customs);

			String sheetId = condVO.getSheetId();		
			if("sheet0".equals(sheetId)){ // 상단 그리드 조회
				List<UsaDownloadSummaryVO> list = dbDao.searchDownloadSummaryList(condVO);
				containerVO.setUsaManifestListDownloadVO(list);
			}
			else if("sheet2".equals(sheetId)){ // 하단 그리드 조회
				containerVO.setUsaManifestListDownloadDetailVO(dbDao.searchDownloadDetailList(condVO));
				containerVO.setUsaManifestListDownloadCntrVO(dbDao.searchDownloadContainerList(condVO));
				containerVO.setUsaBkgCmVO(dbDao.searchDownloadCntrMFList(condVO));
				 
			}
			else if("sheet1".equals(sheetId)){ // Container 조회
				containerVO.setUsaManifestListDownloadCntrVO(dbDao.searchDownloadContainerList(condVO));
			}
			
			List<ManifestListDetailVO> detailVOs = new ArrayList<ManifestListDetailVO>();
			detailVOs.add((ManifestListDetailVO)containerVO);
			return detailVOs;

        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
        } catch (Exception e) {
            log.error("err " + e.toString(), e);
            throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), e);
        }
	}


	/**
	 * 세관 신고 대상 List를 세관 테이블 내로 다운받는 작업을 BackEndJob으로 등록한다.<br>
	 * 
	 * @param ManifestListDetailVO[] manifestListDetailVO 
	 * @param SignOnUserAccount account 
	 * @return String
	 * @exception EventException
	 */
	public String manageManifest(ManifestListDetailVO[] manifestListDetailVO, SignOnUserAccount account) throws EventException {
		try {
			if ("ESM_BKG_0028_DN".equals(manifestListDetailVO[0].getPgmNo())) {
				UsaManifestListDownloadBackEndJob usaBackEndJob = new UsaManifestListDownloadBackEndJob();
				usaBackEndJob.setPgmNo("ESM_BKG_0210");
				usaBackEndJob.setManifestListDetailVO(manifestListDetailVO, account, dbDao);
				usaBackEndJob.doStart();
				return null;
			}
			else if ("ESM_BKG_0028".equals(manifestListDetailVO[0].getPgmNo())) {
				UsaManifestListDetailVO detailVO = (UsaManifestListDetailVO)manifestListDetailVO[0];
				if (!"".equals(JSPUtil.getNull(detailVO.getMfStsCd()))) {
					dbDao.modifyBlStatus("US"+detailVO.getBlNo(), account.getUsr_id(), detailVO.getMfStsCd());
				} else {
					dbDao.modifyTransStage(detailVO.getBlNo(), detailVO.getCstmsMfTpCd(), detailVO.getCstmsTrsmStsCd());
				}
				return null;
			} 
			else if ("ESM_BKG_0568".equals(manifestListDetailVO[0].getPgmNo())) {
				UsaManifestListDownloadBackEndJob usaBackEndJob = new UsaManifestListDownloadBackEndJob();
				usaBackEndJob.setPgmNo("ESM_BKG_0568");
				usaBackEndJob.setManifestListDetailVO(manifestListDetailVO, account, dbDao);
				return usaBackEndJob.manageManifest(manifestListDetailVO);
			} 
			else {
				//BackEndJob
				UsaManifestListDownloadBackEndJob usaBackEndJob = new UsaManifestListDownloadBackEndJob();
				usaBackEndJob.setPgmNo("ESM_BKG_0210");
				usaBackEndJob.setManifestListDetailVO(manifestListDetailVO, account, dbDao);
				BackEndJobManager backEndJobManager = new BackEndJobManager();
				return backEndJobManager.execute(usaBackEndJob, account.getUsr_id(), "USA Data Download (D/L)");
			}			
        } catch (Exception e) {
            log.error("err " + e.toString(), e);
            if(!"Save Failed".equals(e.getMessage())){
            	throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), e);
            }else{
    			throw new EventException(new ErrorHandler(e).getMessage(), e);
            }
        }
	}
	
	/**
	 * US AMS:Manifest Transmit(MI) 조회.<br>
	 * 
	 * @param ManifestListCondVO manifestListCondVO 
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	public List<ManifestListDetailVO> searchMiManifestList(ManifestListCondVO manifestListCondVO) throws EventException {
		try {	
			UsaManifestSearchCondVO condVO = (UsaManifestSearchCondVO)manifestListCondVO;
			
			
			UsaManifestListContainerVO containerVO = new UsaManifestListContainerVO();
			String search_mtd = condVO.getSearchMtd();
			if ("Summary".equals(search_mtd)){
				containerVO.setUsaManifestSummaryVO(dbDao.searchManifestSummary (condVO));
			}else{
				
				List<UsaManifestSearchDetailVO> vos = dbDao.searchManifestList(condVO);
				for(int i = 0; i < vos.size(); i++){
					vos.get(i).setIbflag("U");
				}
				containerVO.setUsaManifestSearchDetailVO(vos);
			}
				
			List<ManifestListDetailVO> detailVOs = new ArrayList<ManifestListDetailVO>();
			detailVOs.add((ManifestListDetailVO)containerVO);
			return detailVOs;

        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
        } catch (Exception e) {
            log.error("err " + e.toString(), e);
            throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), e);
        }
	}	
	
	/**
	 * EXPORT US AMS:Manifest Transmit(XI) 조회.<br>
	 * 
	 * @param ManifestListCondVO manifestListCondVO 
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	public List<ManifestListDetailVO> searchMiManifestListOB(ManifestListCondVO manifestListCondVO) throws EventException {
		try {	
			UsaManifestSearchCondVO condVO = (UsaManifestSearchCondVO)manifestListCondVO;
			
			
			UsaManifestListContainerVO containerVO = new UsaManifestListContainerVO();
			String search_mtd = condVO.getSearchMtd();
			if ("Summary".equals(search_mtd)){
				containerVO.setUsaManifestSummaryVO(dbDao.searchManifestSummaryOB(condVO));
			}else{
				
				List<UsaManifestSearchDetailVO> vos = dbDao.searchManifestListOB(condVO);
				for(int i = 0; i < vos.size(); i++){
					vos.get(i).setIbflag("U");
				}
				containerVO.setUsaManifestSearchDetailVO(vos);
			}
				
			List<ManifestListDetailVO> detailVOs = new ArrayList<ManifestListDetailVO>();
			detailVOs.add((ManifestListDetailVO)containerVO);
			return detailVOs;

        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
        } catch (Exception e) {
            log.error("err " + e.toString(), e);
            throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), e);
        }
	}	
	
	/**
	 * Container 정보 조회
	 * 
	 * @param ContainerListCondVO containerListCondVO 
	 * @return List<ContainerListRsltVO>
	 * @exception EventException
	 */
	public List<ContainerListRsltVO> searchContainerList(ContainerListCondVO containerListCondVO) throws EventException {
		try {
			if("".equals(containerListCondVO.getCntrNo())){
				String cntCd = containerListCondVO.getCntCd();
				String blNo = containerListCondVO.getBlNo();
				
				if("sheet3".equals(containerListCondVO.getSheetId())){
					return dbDao.searchContainerSealNoByBl(cntCd, blNo);
				}else{
					return dbDao.searchContainerByBl(cntCd, blNo);
				}
			}else{
				return dbDao.searchCntrTySzCd(containerListCondVO.getCntrNo());
			}
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
        } catch (Exception e) {
            log.error("err " + e.toString(), e);
            throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), e);
        }
	}		
	
	/**
	 * Container 정보 저장
	 * 
	 * @param ContainerListRsltVO[] cntrListRsltVOs 
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageContainerList(ContainerListRsltVO[] cntrListRsltVOs, SignOnUserAccount account) throws EventException {
		try {
			UsaCntrListRsltVO usaCntrListRsltVO = null;
			UsaCntrSealNoListRsltVO usaCntrSealListRsltVO = null;
			UsaContainerManifestListVO cmListVO = null;
			
			String mode = null;
			String cntCd = null;
			
			if( cntrListRsltVOs.getClass().equals(UsaCntrListRsltVO[].class) ){
				usaCntrSealListRsltVO = new UsaCntrSealNoListRsltVO();

				for(int i=0; i<cntrListRsltVOs.length; i++){
					usaCntrListRsltVO = (UsaCntrListRsltVO)cntrListRsltVOs[i];
					mode = usaCntrListRsltVO.getIbflag();
					if(i == 0) {
						cntCd = usaCntrListRsltVO.getCntCd();
					}
					else{
						usaCntrListRsltVO.setCntCd(cntCd);
					}

					usaCntrSealListRsltVO.setCntCd(cntCd);
					usaCntrSealListRsltVO.setBlNo(usaCntrListRsltVO.getBlNo());
					usaCntrSealListRsltVO.setCntrNo(usaCntrListRsltVO.getCntrNo());
					
					if("I".equals(mode)){
						dbDao.modifyContainer(usaCntrListRsltVO, account);
					}
					else if("U".equals(mode)){
						String bakCntrNo = usaCntrListRsltVO.getBakCntrNo();
						String cntrNo = usaCntrListRsltVO.getCntrNo();
						if(!cntrNo.equals(bakCntrNo)){
							usaCntrListRsltVO.setCntrNo(bakCntrNo);
							usaCntrListRsltVO.setIbdCntrStsCd("D");
							dbDao.modifyContainerStatus(usaCntrListRsltVO);
							dbDao.removeContainerSealNo(usaCntrSealListRsltVO);
						}
						usaCntrListRsltVO.setCntrNo(cntrNo);
						usaCntrListRsltVO.setIbdCntrStsCd("A");
						dbDao.modifyContainer(usaCntrListRsltVO, account);
					}
					else if("D".equals(mode)){
						usaCntrListRsltVO.setIbdCntrStsCd("D");
						dbDao.modifyContainerStatus(usaCntrListRsltVO);
						dbDao.removeContainerSealNo(usaCntrSealListRsltVO);

						cmListVO = new UsaContainerManifestListVO();
						cmListVO.setCntCd(cntCd);
						cmListVO.setBlNo(usaCntrListRsltVO.getBlNo());
						cmListVO.setCntrNo(usaCntrListRsltVO.getCntrNo());
						dbDao.removeCM(cmListVO);
					}
				}
			}
			else{
				String preCntrNo = "";
				for(int i=0; i<cntrListRsltVOs.length; i++){
					usaCntrSealListRsltVO = (UsaCntrSealNoListRsltVO)cntrListRsltVOs[i];
					mode = usaCntrSealListRsltVO.getIbflag();
					if(i == 0) {
						cntCd = usaCntrSealListRsltVO.getCntCd();
					}
					else{
						usaCntrSealListRsltVO.setCntCd(cntCd);
					}

					if( !preCntrNo.equals(usaCntrSealListRsltVO.getCntrNo())){
						dbDao.removeContainerSealNo(usaCntrSealListRsltVO);
						preCntrNo = usaCntrSealListRsltVO.getCntrNo();
					}
					if(!"D".equals(mode)){
						dbDao.modifyContainerSealNo(usaCntrSealListRsltVO, account);
					}
				}
			}
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
        } catch (Exception e) {
            log.error("err " + e.toString(), e);
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), e);
        }
	}	
	
	/**
     * bl 수정<br>
     * 
     * @param BlDetailVO blDetailVO 
     * @param account SignOnUserAccount
     * @exception EventException
     */
    public void correctBl (BlDetailVO blDetailVO, SignOnUserAccount account) throws EventException {
        try {
        	UsaBlDetailContainerVO detailVO = (UsaBlDetailContainerVO)blDetailVO;
        	ClearanceTypeCondVO clrCondVO = new ClearanceTypeCondVO();
        	ClearanceTypeDetailVO clrDetailVO = null;

        	BkgCstmsIbdHisVO hisInfo = null;
        	
    		String bl_no = detailVO.getBlNo();
        	String bl_key = CountryCode.US + detailVO.getBlNo();
        	String cstms_auth = detailVO.getBlCstms();
        	String usr_id = account.getUsr_id();
        	String custCd = "";

    		String preCtnt = "";
    		String curCtnt = null;
    		List<String> blList = new ArrayList<String>();
    		int blListSize = 0;
    		UsaAiBlInfoVO cloneNewBlInfoVO = null;
        	
        	if( detailVO.getNewAiBlInfoVO() != null ) {
        		UsaAiBlInfoVO newAiBlInfoVO = detailVO.getNewAiBlInfoVO();
        		UsaAiBlInfoVO oldAiBlInfoVO = detailVO.getOldAiBlInfoVO();

        		if( newAiBlInfoVO != null ) {
        			String vvd = newAiBlInfoVO.getVvd();
        			newAiBlInfoVO.setVslCd(vvd.substring(0, 4));
        			newAiBlInfoVO.setSkdVoyNo(vvd.substring(4, 8));
        			newAiBlInfoVO.setSkdDirCd(vvd.substring(8, 9));
        			
        			String pckQty = newAiBlInfoVO.getPckQty();
        			newAiBlInfoVO.setPckQty(pckQty.replace(",", ""));
        			String cgoWgt = newAiBlInfoVO.getCgoWgt();
        			newAiBlInfoVO.setCgoWgt(cgoWgt.replace(",", "").replace(".000", ""));
            		
        			
        			String newLoclTrnsCd = newAiBlInfoVO.getLoclTrnsCd();
        			String oldLoclTrnsCd = oldAiBlInfoVO.getLoclTrnsCd();
        			String newIbdTrspTpCd = newAiBlInfoVO.getIbdTpCd();
        			String oldIbdTrspTpCd = oldAiBlInfoVO.getIbdTpCd();
        			String hubLocCd = newAiBlInfoVO.getHubLocCd();
        			String cstmsPodCd = newAiBlInfoVO.getPodCd();
        			
        			if("C".equals(newAiBlInfoVO.getBkgCustTpCd())){
        				custCd = detailVO.getNewBlCustVOs()[1].getCustCntCd() + detailVO.getNewBlCustVOs()[1].getCustSeq();
        			}else if("N".equals(newAiBlInfoVO.getBkgCustTpCd())){
        				custCd = detailVO.getNewBlCustVOs()[2].getCustCntCd() + detailVO.getNewBlCustVOs()[2].getCustSeq();
        			}
        			
        			log.debug("*********************************");
        			log.debug("newCstmsClrCd : " + newLoclTrnsCd);
        			log.debug("oldCstmsClrCd : " + oldLoclTrnsCd);
        			log.debug("newIbdTrspTpCd : " + newIbdTrspTpCd);
        			log.debug("oldIbdTrspTpCd : " + oldIbdTrspTpCd);
        			log.debug("hubLocCd : " + hubLocCd);
        			log.debug("cstmsPodCd : " + cstmsPodCd);
        			log.debug("*********************************");
        			
					/*
					 *  ENTRY TYPE 변경 (MIB->L) 일 경우
					 *	조건:HUB_LOC_CD <> CSTMS_POD_CD
					 *	조치:bkg_cstms_adv_ibd.LOCL_CLR_IPI_MVMT_FLG = 'Y' 
					 */
        			if(!oldLoclTrnsCd.equals(newLoclTrnsCd) && "L".equals(newLoclTrnsCd) &&  !hubLocCd.equals(cstmsPodCd)) {
        				newAiBlInfoVO.setLoclClrIpiMvmtFlg("Y");
        			} else if(!oldLoclTrnsCd.equals(newLoclTrnsCd) && "I".equals(newLoclTrnsCd) &&  !hubLocCd.equals(cstmsPodCd)){
        				newAiBlInfoVO.setLoclClrIpiMvmtFlg("N");
        			}
        			
					/*
					 *  2010.01.15 ASIS 로직 반영
					 *  ABL.CSTMS_LOC_CD -> IPI(I) 이면 HUB, LOCAL(L) 이면 POD
					 *  2012.11.21
					 *  cstms_auth == 0 : 권한 X
					 *  cstms_auth == 1 : 권한 O
					 *  Customs Loc의 수정 권한이 없을 때 기존 로직을 타고 권한이 있을 때는 화면에 표시된 Customs Loc 지정
					 *  2014.06.25 로직 변경
					 *  0. Entry type이 P/MIB에서 Local로 update될경우 POD location 의 값을 Customs Loc으로 Update.
					 *     - Additional update과 user mistake을 줄이기 위하여 수정권한을 check 하지 않음
					 *  1. P/MIB 으로 변경시는 기존로직과 동일    
					*/ 
    				//P/MIB ==> Local
    				if("L".equals(newLoclTrnsCd)){
    					newAiBlInfoVO.setCstmsLocCd(newAiBlInfoVO.getPodCd());
    				} 
    				if("L".equals(oldLoclTrnsCd) && "I".equals(newLoclTrnsCd) && !"1".equals(cstms_auth)) {
	    				clrCondVO.setCustCd(custCd);
	    				clrCondVO.setPodCd(newAiBlInfoVO.getPodCd());
	    				clrCondVO.setDelCd(newAiBlInfoVO.getDelCd());
	    				clrCondVO.setScNo(newAiBlInfoVO.getScNo());
	    				clrDetailVO = dbDao.searchClrTpSetup(clrCondVO); //entry type set up screen조회
	    				//entry type set up screen 정보가 있는경우
	    				if(clrDetailVO != null && !"".equals(clrDetailVO.getCstmsLocCd())){
	        				newAiBlInfoVO.setCstmsLocCd(clrDetailVO.getCstmsLocCd());
	        			}else{
	        				//Local ==> P/MIB
	        				newAiBlInfoVO.setCstmsLocCd(newAiBlInfoVO.getHubLocCd());
	        			}
        			}

    				
        			/*
        			 * 2010.04.29 경종윤
        			 * ENTRY TYPE이 변경되거나 IN-BOND TYPE이 변경되면
        			 * 현재 BL_NO에 해당하는 HOUSE BL_NO를 구한다.
        			 */
        			if(!oldLoclTrnsCd.equals(newLoclTrnsCd) || !oldIbdTrspTpCd.equals(newIbdTrspTpCd)) {
        				blList = dbDao.searchBlListbyMasterBl("US",newAiBlInfoVO.getBlNo());
        				if(!oldLoclTrnsCd.equals(newLoclTrnsCd)) {
        					newAiBlInfoVO.setCstmsClrTpCdChg("Y");
        				} else {
        					newAiBlInfoVO.setCstmsClrTpCdChg("N");
        				}
        				if(!oldIbdTrspTpCd.equals(newIbdTrspTpCd)) {
        					newAiBlInfoVO.setIbdTrspTpCdChg("Y");
        				} else {
        					newAiBlInfoVO.setIbdTrspTpCdChg("N");
        				}
        			}  
        			
        			/*
        			 * 2010.04.29 경종윤
        			 * 조회된 HOUSE BL LIST에 원래 BL_NO를 추가 후 blList수만큼 반복하다.
        			 */
        			String newBlKey = "";
        			cloneNewBlInfoVO = (UsaAiBlInfoVO) newAiBlInfoVO.clone(); // 하우스 bl이 포함된 vo로 사용할려고 복제
					blList.add(newAiBlInfoVO.getBlNo());
					blListSize = blList.size();
					String blNo = "";
					BkgCstmsIbdHisVO newHisInfo = null;
					String cstmsPortCd = null;
					for(int i = 0; i < blListSize; i++) {
						blNo = (String)blList.get(i);
						newBlKey = "US" + blNo;
						
						cloneNewBlInfoVO.setBlNo(blNo);
						
						if(blNo.equals(newAiBlInfoVO.getBlNo())) {
							cloneNewBlInfoVO.setIbflag("origin_bl"); // 원래 bl 구분을 위해서 ibflag값을 사용한다.
						} else {
							cloneNewBlInfoVO.setIbflag("new_bl");
						}
						// cstms_port_cd 추가
                        if (cloneNewBlInfoVO.getPodCd().startsWith("US"))
                        {
                              cstmsPortCd = cloneNewBlInfoVO.getPodCd();
                        }
                        else
                        {
                              cstmsPortCd = dbDao.searchCstmsPortCd(cloneNewBlInfoVO);
                        }						                        
                        cloneNewBlInfoVO.setCstmsPortCd(cstmsPortCd);
                                                                                                                                              
	        			if(dbDao.modifyBl( cloneNewBlInfoVO, usr_id ) > 0){
	        				if(blNo.equals(newAiBlInfoVO.getBlNo())) { // 원래 bl
		    					if(hisInfo == null){
			                		hisInfo = addBlHistory( newBlKey, usr_id, "BLI" );
		    					}
	        				} else { // 원래 bl 이외의 하우스 bl
	        					if(newHisInfo == null){
	        						newHisInfo = addBlHistory( newBlKey, usr_id, "BLI" );

	    		        			preCtnt = oldAiBlInfoVO != null ? oldAiBlInfoVO.getUsaLstLocCd() : "";
	    		        			curCtnt = cloneNewBlInfoVO.getUsaLstLocCd();
	    			        		if("Y".equals(cloneNewBlInfoVO.getLoclClrIpiMvmtFlg())
	    			        				&& "L".equals(newLoclTrnsCd) 
	    			        				&& !preCtnt.equals(curCtnt) ) {               		
	    			            		addBlDetailHistory( newHisInfo, "LUSA", preCtnt, curCtnt );
	    			        		}
	    		        			preCtnt = oldAiBlInfoVO != null ? oldAiBlInfoVO.getLoclTrnsCd() : "";
	    		        			curCtnt = cloneNewBlInfoVO.getLoclTrnsCd();
	    			        		if("Y".equals(cloneNewBlInfoVO.getCstmsClrTpCdChg()) && !preCtnt.equals(curCtnt) ) {               		
	    			            		addBlDetailHistory( newHisInfo, "IT", preCtnt, curCtnt );
	    			        		}   
	    		        			preCtnt = oldAiBlInfoVO != null ? oldAiBlInfoVO.getIbdTpCd() : "";
	    		        			curCtnt = cloneNewBlInfoVO.getIbdTpCd();
	    			        		if("Y".equals(cloneNewBlInfoVO.getIbdTrspTpCdChg()) && !preCtnt.equals(curCtnt) ) {               		
	    			            		addBlDetailHistory( newHisInfo, "IBTP", preCtnt, curCtnt );
	    			        		}
	    			        		
	    			        		newHisInfo = null;
	        					}
	        				}
	        			}
					} // end for(i)
	        			
        			
        				// 2010.04.08 추가
	//        			UsaInbondManifestDetailListVO detailVo = new UsaInbondManifestDetailListVO();
	//        			detailVo.setIbflag("0034");
	//        			detailVo.setBlNo(newAiBlInfoVO.getBlNo());
	//        			detailVo.setIbdTrspTpCd(newAiBlInfoVO.getIbdTpCd());
	//        			dbDao.modifyMIBList(detailVo);
	        			
		        		// AI B/L Info 수정사항 히스토리 저장
        			preCtnt = oldAiBlInfoVO != null ? oldAiBlInfoVO.getLoclTrnsCd() : "";
        			curCtnt = newAiBlInfoVO.getLoclTrnsCd();
	        		if( !preCtnt.equals(curCtnt) ) {               		
	            		addBlDetailHistory( hisInfo, "IT", preCtnt, curCtnt );
	        		}     			
        			preCtnt = oldAiBlInfoVO != null ? oldAiBlInfoVO.getIbdTrspNo() : "";
        			curCtnt = newAiBlInfoVO.getIbdTrspNo();
	        		if( !preCtnt.equals(curCtnt) ) {               		
	            		addBlDetailHistory( hisInfo, "IT", preCtnt, curCtnt );
	        		}
        			preCtnt = oldAiBlInfoVO != null ? oldAiBlInfoVO.getIbdTpCd() : "";
        			curCtnt = newAiBlInfoVO.getIbdTpCd();
	        		if( !preCtnt.equals(curCtnt) ) {               		
	            		addBlDetailHistory( hisInfo, "IBTP", preCtnt, curCtnt );
	        		}
        			preCtnt = oldAiBlInfoVO != null ? oldAiBlInfoVO.getPreMfNo() : "";
        			curCtnt = newAiBlInfoVO.getPreMfNo();
	        		if( !preCtnt.equals(curCtnt) ) {         		
	            		addBlDetailHistory( hisInfo, "MST B/L", preCtnt, curCtnt );
	        		} 
        			preCtnt = oldAiBlInfoVO != null ? oldAiBlInfoVO.getVvd() : "";
        			curCtnt = newAiBlInfoVO.getVvd();
	        		if( !preCtnt.equals(curCtnt) ) {         		
	            		addBlDetailHistory( hisInfo, "VVD PORT", preCtnt, curCtnt );
	        		}  
        			preCtnt = oldAiBlInfoVO != null ? oldAiBlInfoVO.getPodCd() : "";
        			curCtnt = newAiBlInfoVO.getPodCd();
	        		if( !preCtnt.equals(curCtnt) ) {           		
	            		addBlDetailHistory( hisInfo, "ROUTE", preCtnt, curCtnt );
	        		}      		
        			preCtnt = oldAiBlInfoVO != null ? oldAiBlInfoVO.getDelCd() : "";
        			curCtnt = newAiBlInfoVO.getDelCd();
	        		if( !preCtnt.equals(curCtnt) ) {            		
	            		addBlDetailHistory( hisInfo, "ROUTE", preCtnt, curCtnt );
	        		}
        			preCtnt = oldAiBlInfoVO != null ? oldAiBlInfoVO.getHubLocCd() : "";
        			curCtnt = newAiBlInfoVO.getHubLocCd();
	        		if( !preCtnt.equals(curCtnt) ) {            		
	            		addBlDetailHistory( hisInfo, "HUB", preCtnt, curCtnt );
	        		}
        			preCtnt = oldAiBlInfoVO != null ? oldAiBlInfoVO.getUsaLstLocCd() : "";
        			curCtnt = newAiBlInfoVO.getUsaLstLocCd();
	        		if( !preCtnt.equals(curCtnt) ) {               		
	            		addBlDetailHistory( hisInfo, "LUSA", preCtnt, curCtnt );
	        		}
        			preCtnt = oldAiBlInfoVO != null ? oldAiBlInfoVO.getPckQty() : "";
        			curCtnt = newAiBlInfoVO.getPckQty();
	        		if( !preCtnt.equals(curCtnt) ) {               		
	            		addBlDetailHistory( hisInfo, "PKG", preCtnt, curCtnt );
	        		}
        			preCtnt = oldAiBlInfoVO != null ? oldAiBlInfoVO.getAmsPckTpCd() : "";
        			curCtnt = newAiBlInfoVO.getAmsPckTpCd();
	        		if( !preCtnt.equals(curCtnt) ) {               		
	            		addBlDetailHistory( hisInfo, "PKG", preCtnt, curCtnt );
	        		}
        			preCtnt = oldAiBlInfoVO != null ? oldAiBlInfoVO.getCgoWgt() : "";
        			curCtnt = newAiBlInfoVO.getCgoWgt();
	        		if( !preCtnt.equals(curCtnt) ) {               		
	            		addBlDetailHistory( hisInfo, "WGT", preCtnt, curCtnt );
	        		}
        			preCtnt = oldAiBlInfoVO != null ? oldAiBlInfoVO.getWgtUtCd() : "";
        			curCtnt = newAiBlInfoVO.getWgtUtCd();
	        		if( !preCtnt.equals(curCtnt) ) {               		
	            		addBlDetailHistory( hisInfo, "WGT", preCtnt, curCtnt );
	        		}
        			preCtnt = oldAiBlInfoVO != null ? oldAiBlInfoVO.getDiffRmk() : "";
        			curCtnt = newAiBlInfoVO.getDiffRmk();
	        		if( !preCtnt.equals(curCtnt) ) {         		
	            		addBlDetailHistory( hisInfo, "REMARK", preCtnt, curCtnt );
	        		}  
        			preCtnt = oldAiBlInfoVO != null ? oldAiBlInfoVO.getFreeTrdZnFlg() : "";
        			curCtnt = newAiBlInfoVO.getFreeTrdZnFlg();
	        		if( !preCtnt.equals(curCtnt) ) {         		
	            		addBlDetailHistory( hisInfo, "FTZ", preCtnt, curCtnt );
	        		}
        			preCtnt = oldAiBlInfoVO != null ? oldAiBlInfoVO.getCstmsLocCd() : "";
        			curCtnt = newAiBlInfoVO.getCstmsLocCd();
	        		if( !preCtnt.equals(curCtnt) ) {         		
	            		addBlDetailHistory( hisInfo, "CLO", preCtnt, curCtnt );
	        		}
        		}
        	}
        	if( detailVO.getNewBlCustVOs() != null ) {
        		UsaBlCustVO[] newBlCustVOs = detailVO.getNewBlCustVOs();
        		UsaBlCustVO[] oldBlCustVOs = 
        			detailVO.getOldBlCustVOs() != null ? detailVO.getOldBlCustVOs() : new UsaBlCustVO[1];
        		
        		UsaBlCustVO oldVO = null;
        		UsaBlCustVO newVO = null;

        		for( int i=0; i < newBlCustVOs.length; i++ ) {
        			newVO = newBlCustVOs[i];
        			if(newVO == null) continue;
        			newVO.setBlNo(bl_no);
    				if(dbDao.modifyCustomer( newVO, usr_id ) > 0){
    					if(hisInfo == null){
	                		hisInfo = addBlHistory( bl_key, usr_id, "BLI" );
    					}
    				}
    				        			
        			for( int j=0; j < oldBlCustVOs.length; j++ ) {
        				oldVO = oldBlCustVOs[j];
            			if(oldVO == null) continue;
        				
                		// AI B/L Customer Info 수정사항 히스토리 저장
	        			if( "S".equals(newVO.getBkgCustTpCd()) && "S".equals(oldVO.getBkgCustTpCd()) ) {

	            			preCtnt = oldVO != null ? oldVO.getCustCntCd() : "";
	            			curCtnt = newVO.getCustCntCd();
		        			if( !preCtnt.equals(curCtnt) ) {            		
		                		addBlDetailHistory(hisInfo, "SHPR CD", preCtnt, curCtnt);
		            		} 
	            			preCtnt = oldVO != null ? oldVO.getCustSeq() : "";
	            			curCtnt = newVO.getCustSeq();
		        			if( !preCtnt.equals(curCtnt) ) {            		
		                		addBlDetailHistory(hisInfo, "SHPR CD", preCtnt, curCtnt);
		            		}  
	            			preCtnt = oldVO != null ? oldVO.getCustNm() : "";
	            			curCtnt = newVO.getCustNm();
		        			if( !preCtnt.equals(curCtnt) ) {           		
		                		addBlDetailHistory(hisInfo, "SHPR NM", preCtnt, curCtnt);
		            		}  
	            			preCtnt = oldVO != null ? oldVO.getCustAddr() : "";
	            			curCtnt = newVO.getCustAddr();
		        			if( !preCtnt.equals(curCtnt) ) {               		
		                		addBlDetailHistory(hisInfo, "SHPR ADDR", preCtnt, curCtnt);
		            		} 
	            			preCtnt = oldVO != null ? oldVO.getPhnNo() : "";
	            			curCtnt = newVO.getPhnNo();
		        			if( !preCtnt.equals(curCtnt) ) {           		
		                		addBlDetailHistory(hisInfo, "SHPR PHN", preCtnt, curCtnt);
		            		}
	            			preCtnt = oldVO != null ? oldVO.getFaxNo() : "";
	            			curCtnt = newVO.getFaxNo();
		        			if( !preCtnt.equals(curCtnt) ) {           		
		                		addBlDetailHistory(hisInfo, "SHPR FAX", preCtnt, curCtnt);
		            		}
	        			}
	        			else if( "C".equals(newVO.getBkgCustTpCd()) && "C".equals(oldVO.getBkgCustTpCd()) ) {

	            			preCtnt = oldVO != null ? oldVO.getCustCntCd() : "";
	            			curCtnt = newVO.getCustCntCd();
		        			if( !preCtnt.equals(curCtnt) ) {            		
		                		addBlDetailHistory(hisInfo, "CNEE CD", preCtnt, curCtnt);
		            		} 
	            			preCtnt = oldVO != null ? oldVO.getCustSeq() : "";
	            			curCtnt = newVO.getCustSeq();
		        			if( !preCtnt.equals(curCtnt) ) {           		
		                		addBlDetailHistory(hisInfo, "CNEE CD", preCtnt, curCtnt);
		            		}  
	            			preCtnt = oldVO != null ? oldVO.getCustNm() : "";
	            			curCtnt = newVO.getCustNm();
		        			if( !preCtnt.equals(curCtnt) ) {            		
		                		addBlDetailHistory(hisInfo, "CNEE NM", preCtnt, curCtnt);
		            		}  
	            			preCtnt = oldVO != null ? oldVO.getCustAddr() : "";
	            			curCtnt = newVO.getCustAddr();
		        			if( !preCtnt.equals(curCtnt) ) {               		
		                		addBlDetailHistory(hisInfo, "CNEE ADDR", preCtnt, curCtnt);
		            		} 
	            			preCtnt = oldVO != null ? oldVO.getPhnNo() : "";
	            			curCtnt = newVO.getPhnNo();
		        			if( !preCtnt.equals(curCtnt) ) {           		
		                		addBlDetailHistory(hisInfo, "CNEE PHN", preCtnt, curCtnt);
		            		}
	            			preCtnt = oldVO != null ? oldVO.getFaxNo() : "";
	            			curCtnt = newVO.getFaxNo();
		        			if( !preCtnt.equals(curCtnt) ) {           		
		                		addBlDetailHistory(hisInfo, "CNEE FAX", preCtnt, curCtnt);
		            		}
	        			}
	        			else if( "N".equals(newVO.getBkgCustTpCd()) && "N".equals(oldVO.getBkgCustTpCd()) ) {

	            			preCtnt = oldVO != null ? oldVO.getCustCntCd() : "";
	            			curCtnt = newVO.getCustCntCd();
		        			if( !preCtnt.equals(curCtnt) ) {            		
		                		addBlDetailHistory(hisInfo, "NTFY CD", preCtnt, curCtnt);
		            		} 
	            			preCtnt = oldVO != null ? oldVO.getCustSeq() : "";
	            			curCtnt = newVO.getCustSeq();
		        			if( !preCtnt.equals(curCtnt) ) {            		
		                		addBlDetailHistory(hisInfo, "NTFY CD", preCtnt, curCtnt);
		            		}  
	            			preCtnt = oldVO != null ? oldVO.getCustNm() : "";
	            			curCtnt = newVO.getCustNm();
		        			if( !preCtnt.equals(curCtnt) ) {           		
		                		addBlDetailHistory(hisInfo, "NTFY NM", preCtnt, curCtnt);
		            		}  
	            			preCtnt = oldVO != null ? oldVO.getCustAddr() : "";
	            			curCtnt = newVO.getCustAddr();
		        			if( !preCtnt.equals(curCtnt) ) {          		
		                		addBlDetailHistory(hisInfo, "NTFY ADDR", preCtnt, curCtnt);
		            		} 
	            			preCtnt = oldVO != null ? oldVO.getPhnNo() : "";
	            			curCtnt = newVO.getPhnNo();
		        			if( !preCtnt.equals(curCtnt) ) {           		
		                		addBlDetailHistory(hisInfo, "NTFY PHN", preCtnt, curCtnt);
		            		}
	            			preCtnt = oldVO != null ? oldVO.getFaxNo() : "";
	            			curCtnt = newVO.getFaxNo();
		        			if( !preCtnt.equals(curCtnt) ) {           		
		                		addBlDetailHistory(hisInfo, "NTFY FAX", preCtnt, curCtnt);
		            		}
	        			}
	        			
        			}// for end
        			
        		}// for end
        	}
        	if( detailVO.getNewBlCustomerSecondVOs() != null ) {      		
        		UsaBlCustomerSecondVO[] newBlCust2VOs = detailVO.getNewBlCustomerSecondVOs();
        		UsaBlCustomerSecondVO[] oldBlCust2VOs = 
        			detailVO.getOldBlCustomerSecondVOs() != null ? detailVO.getOldBlCustomerSecondVOs() : new UsaBlCustomerSecondVO[1];  

        		UsaBlCustomerSecondVO newVO = null;
        		UsaBlCustomerSecondVO oldVO = null;  
        		
        		for( int i=0; i < newBlCust2VOs.length; i++ ) {
        			newVO = newBlCust2VOs[i];
        			if(newVO == null) continue;
        			newVO.setBlNo(bl_no);
       				if(dbDao.modifyCustomer2( newVO, usr_id ) > 0){
    					if(hisInfo == null){
	                		hisInfo = addBlHistory( bl_key, usr_id, "BLI" );
    					}
       				}
        			      			
        			for( int j=0; j < oldBlCust2VOs.length; j++ ) {
        				oldVO = oldBlCust2VOs[j];
            			if(oldVO == null) continue;

                		// AI B/L Customer Second Info 수정사항 히스토리 저장
	        			if( "F".equals(newVO.getBkgCustTpCd()) && "F".equals(oldVO.getBkgCustTpCd()) ) {

	            			preCtnt = oldVO != null ? oldVO.getCustCntCd() : "";
	            			curCtnt = newVO.getCustCntCd();
		        			if( !preCtnt.equals(curCtnt) ) {            		
		                		addBlDetailHistory(hisInfo, "FWDR CD", preCtnt, curCtnt);
		            		} 
	            			preCtnt = oldVO != null ? oldVO.getCustSeq() : "";
	            			curCtnt = newVO.getCustSeq();
		        			if( !preCtnt.equals(curCtnt) ) {          		
		                		addBlDetailHistory(hisInfo, "FWDR CD", preCtnt, curCtnt);
		            		}  
	            			preCtnt = oldVO != null ? oldVO.getCustNm() : "";
	            			curCtnt = newVO.getCustNm();
		        			if( !preCtnt.equals(curCtnt) ) {         		
		                		addBlDetailHistory(hisInfo, "FWDR NM", preCtnt, curCtnt);
		            		}  
	            			preCtnt = oldVO != null ? oldVO.getCustAddr() : "";
	            			curCtnt = newVO.getCustAddr();
		        			if( !preCtnt.equals(curCtnt) ) {           		
		                		addBlDetailHistory(hisInfo, "FWDR ADDR", preCtnt, curCtnt);
		            		} 
	            			preCtnt = oldVO != null ? oldVO.getPhnNo() : "";
	            			curCtnt = newVO.getPhnNo();
		        			if( !preCtnt.equals(curCtnt) ) {           		
		                		addBlDetailHistory(hisInfo, "FWDR PHN", preCtnt, curCtnt);
		            		}
	            			preCtnt = oldVO != null ? oldVO.getFaxNo() : "";
	            			curCtnt = newVO.getFaxNo();
		        			if( !preCtnt.equals(curCtnt) ) {           		
		                		addBlDetailHistory(hisInfo, "FWDR FAX", preCtnt, curCtnt);
		            		}
	        			}
	        			else if( "A".equals(newVO.getBkgCustTpCd()) && "A".equals(oldVO.getBkgCustTpCd()) ) {

	            			preCtnt = oldVO != null ? oldVO.getCustCntCd() : "";
	            			curCtnt = newVO.getCustCntCd();
		        			if( !preCtnt.equals(curCtnt) ) {            		
		                		addBlDetailHistory(hisInfo, "ANTF CD", preCtnt, curCtnt);
		            		} 
	            			preCtnt = oldVO != null ? oldVO.getCustSeq() : "";
	            			curCtnt = newVO.getCustSeq();
		        			if( !preCtnt.equals(curCtnt) ) {          		
		                		addBlDetailHistory(hisInfo, "ANTF CD", preCtnt, curCtnt);
		            		}  
	            			preCtnt = oldVO != null ? oldVO.getCustNm() : "";
	            			curCtnt = newVO.getCustNm();
		        			if( !preCtnt.equals(curCtnt) ) {          		
		                		addBlDetailHistory(hisInfo, "ANTF NM", preCtnt, curCtnt);
		            		}  
	            			preCtnt = oldVO != null ? oldVO.getCustAddr() : "";
	            			curCtnt = newVO.getCustAddr();
		        			if( !preCtnt.equals(curCtnt) ) {            		
		                		addBlDetailHistory(hisInfo, "ANTF ADDR", preCtnt, curCtnt);
		            		} 
	            			preCtnt = oldVO != null ? oldVO.getPhnNo() : "";
	            			curCtnt = newVO.getPhnNo();
		        			if( !preCtnt.equals(curCtnt) ) {           		
		        				addBlDetailHistory(hisInfo, "ANTF PHN", preCtnt, curCtnt);
		            		}
	            			preCtnt = oldVO != null ? oldVO.getFaxNo() : "";
	            			curCtnt = newVO.getFaxNo();
		        			if( !preCtnt.equals(curCtnt) ) {           		
		                		addBlDetailHistory(hisInfo, "ANTF FAX", preCtnt, curCtnt);
		            		}
	        			}
		        			
        			}// for end
        			
        		}// for end
        	}
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
        } catch (Exception e) {
            log.error("err " + e.toString(), e);
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), e);
        }
    } 
	
	/**
     * bl 삭제<br>
     * 
     * @param BlKeyVO blKeyVO
     * @param SignOnUserAccount account 
     * @exception EventException
     */
    public void removeBl (BlKeyVO blKeyVO, SignOnUserAccount account) throws EventException {
        try {
    		String usrId = account.getUsr_id();
        	UsaBlKeyVO usaBlKeyVO = (UsaBlKeyVO)blKeyVO;        	
        	String blKey = usaBlKeyVO.getBlKey();
        	String blStat = dbDao.searchBlStatus(blKey);
        	
        	if(blStat == null){
        		throw new EventException(new ErrorHandler("BKG00095", new String[] {}).getMessage());
        	}else if(blStat.equals("D")){
        		throw new EventException(new ErrorHandler("BKG00471", new String[] {}).getMessage());
        	}else{
	        	int result = dbDao.modifyBlStatus( blKey, account.getUsr_id(), "D" );
	
	        	if(result > 0)	{               		
	        		BkgCstmsIbdHisVO hisInfo = addBlHistory( blKey, usrId, usaBlKeyVO.getHisTpId() );
	        		if( hisInfo != null) addBlDetailHistory( hisInfo, "STS", "A", "D" );
	        	}
        	}
        } catch (EventException ee) {
            log.error("err " + ee.toString(), ee);
            throw ee;
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
        } catch (Exception e) {
            log.error("err " + e.toString(), e);
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), e);
        }
    } 
	
	/**
     * bl 재사용<br>
     * 
     * @param BlKeyVO b
     * @param SignOnUserAccount account 
     * @exception EventException
     */
    public void reactivateBl (BlKeyVO b, SignOnUserAccount account) throws EventException {
        try {
    		String usrId = account.getUsr_id();
        	UsaBlKeyVO blKeyVO = (UsaBlKeyVO)b;
        	String blKey = blKeyVO.getBlKey();
        	String blStat = dbDao.searchBlStatus(blKey);
        	
        	if(blStat == null){
        		throw new EventException(new ErrorHandler("BKG00095", new String[] {}).getMessage());
        	}else if(blStat.equals("A")){
        		throw new EventException(new ErrorHandler("BKG00477", new String[] {}).getMessage());
        	}else{
	        	int result = dbDao.modifyBlStatus( blKey, account.getUsr_id(), "A" );
	        	
	        	if(result > 0)	{
	        		BkgCstmsIbdHisVO hisInfo = addBlHistory( blKey, usrId, "BLI" );
	        		if( hisInfo != null) addBlDetailHistory( hisInfo, "STS", "D", "A" );
	        	}
        	}
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
        } catch (Exception e) {
            log.error("err " + e.toString(), e);
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), e);
        }
    } 
    
    /**
     * BL 정보 변경 내역 저장<br>
     * @param String blKey 
     * @param String usrId 
     * @param String hisTpId
     * @return BkgCstmsIbdHisVO
     * @exception EventException
     */
    public BkgCstmsIbdHisVO addBlHistory (String blKey, String usrId, String hisTpId) throws EventException {
        try {
    		// History Seq. 생성
			int seq = dbDao.addBlHistorySeq(blKey);

			BkgCstmsIbdHisVO hisVO = new BkgCstmsIbdHisVO();
			hisVO.setHisSeq(Integer.toString(seq));
			hisVO.setCntCd(blKey.substring(0, 2));
			hisVO.setBlNo(blKey.substring(2));
			hisVO.setHisTpId(hisTpId);
			hisVO.setCreUsrId(usrId);
			hisVO.setUpdUsrId(usrId);
			
        	if(dbDao.addBlHistory(hisVO) > 0){
        		return hisVO;
        	}else{
        		return null;
        	}
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
        } catch (Exception e) {
            log.error("err " + e.toString(), e);
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), e);
        }
    }
    
    /**
     * BL 정보 변경 상세 내역 저장<br>
     * @param BkgCstmsIbdHisVO bkgCstmsIbdHisVO
     * @param String ctnt
     * @param String preCtnt
     * @param String curCtnt
     * @exception EventException
     */
    public void addBlDetailHistory (BkgCstmsIbdHisVO bkgCstmsIbdHisVO, String ctnt, String preCtnt, String curCtnt) throws EventException {
        try {
			BkgCstmsIbdHisDtlVO hisDtlVO = new BkgCstmsIbdHisDtlVO();
			
			hisDtlVO.setHisSeq(bkgCstmsIbdHisVO.getHisSeq());
			hisDtlVO.setCntCd(bkgCstmsIbdHisVO.getCntCd());
			hisDtlVO.setBlNo(bkgCstmsIbdHisVO.getBlNo());
			hisDtlVO.setCreUsrId(bkgCstmsIbdHisVO.getCreUsrId());
			hisDtlVO.setUpdUsrId(bkgCstmsIbdHisVO.getUpdUsrId());
			hisDtlVO.setHisItmCtnt(ctnt);
			hisDtlVO.setPreCtnt(preCtnt);
			hisDtlVO.setCrntCtnt(curCtnt);
			
        	dbDao.addBlDetailHistory(hisDtlVO);

        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
        } catch (Exception e) {
            log.error("err " + e.toString(), e);
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), e);
        }
    }
    
	/**
	 * Container Manifest 정보를 조회한다.
	 * 
	 * @param ContainerManifestCondVO containerManifestCondVO
	 * @return ManifestListDetailVO
	 * @exception EventException
	 */
	public ManifestListDetailVO searchContainerManifest(ContainerManifestCondVO containerManifestCondVO) throws EventException {
		UsaContainerManifestDetailVO detailVO = new UsaContainerManifestDetailVO();
		try {
			UsaCntrManifestCondVO condVO = (UsaCntrManifestCondVO)containerManifestCondVO;
			detailVO.setUsaContainerListVOs(dbDao.searchContainerList(condVO.getCntCd(), condVO.getBlNo()));
			detailVO.setUsaCntrManifestListVOs(dbDao.searchContainerManifestList(condVO.getCntCd(), condVO.getBlNo(), condVO.getCntrNo()));
			detailVO.setUsaCntrManifestInfoVOs(dbDao.searchContainerManifestInfo(condVO.getCntCd(), condVO.getBlNo()));
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
        } catch (Exception e) {
            log.error("err " + e.toString(), e);
            throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), e);
        }
        return (ManifestListDetailVO)detailVO;
	}	
	
	/**
	 * 전송대상 Container Manifest 데이터를 수정한다.
	 * 
	 * @param ConatinerModificationtVO[] containerVOs 
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyContainerManifest(ConatinerModificationtVO[] containerVOs, SignOnUserAccount account) throws EventException {
		try {
			UsaContainerManifestListVO cmListVO = null;
			String mode = null;
			String bdrFlg = null;
			String cntCd = null;
			
			for(int i=0; i<containerVOs.length; i++){
				cmListVO = (UsaContainerManifestListVO)containerVOs[i];
				mode = cmListVO.getIbflag();
				if(i == 0){
					cntCd = cmListVO.getCntCd();
				}
				else{
					cmListVO.setCntCd(cntCd);
				}
				bdrFlg = !"".equals(cmListVO.getBdrFlg()) ? cmListVO.getBdrFlg() : bdrFlg;
				
				//if("N".equals(bdrFlg)){
					if("I".equals(mode) || "U".equals(mode)){
						dbDao.modifyCM(cmListVO, account);
					}
					else if("D".equals(mode)){
						dbDao.removeCM(cmListVO);
					}
				//}
			}
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
        } catch (Exception e) {
            log.error("err " + e.toString(), e);
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), e);
        }
	}

	/**
	 * Hold Notice를 송부를 위하여 Customs에서 받는 특정 Code를 조회 한다
	 * 
	 * @param DispoCdListCondVO dispoCdListCondVO 
	 * @return List<DispoCdDetailVO>
	 * @exception EventException
	 */
	public List<DispoCdDetailVO> searchDispositionCdList(DispoCdListCondVO dispoCdListCondVO) throws EventException {
        try {
        	return dbDao.searchUsaDispositionCdList(dispoCdListCondVO);
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
        } catch (Exception e) {
            log.error("err " + e.toString(), e);
            throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), e);
        }
	}

	/**
	 * Hold Notice를 송부를 위하여 Customs에서 받는 특정 Code를 등록, 수정 및 삭제 한다
	 * 
	 * @param DispoCdDetailVO[] dispoCdDetailVO 
	 * @param SignOnUserAccount account 
	 * @exception EventException
	 */
	public void manageDispositionCdList(DispoCdDetailVO[] dispoCdDetailVO, SignOnUserAccount account) throws EventException {
		try {
			DispoCdDetailVO detailVO = null;
			String mode = null;
			
			for(int i=0; i<dispoCdDetailVO.length; i++){
				detailVO = dispoCdDetailVO[i];
				mode = detailVO.getIbflag();
				detailVO.setCreUsrId(account.getUsr_id());
				detailVO.setUpdUsrId(account.getUsr_id());
				
				if("I".equals(mode)){
					dbDao.addDispositonCode(detailVO);
				}
				else if("U".equals(mode)){
					dbDao.modifyDispositionCode(detailVO);
				}
				else if("D".equals(mode)){
					dbDao.removeDispositionCode(detailVO);
				}
			}
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
        } catch (Exception e) {
            log.error("err " + e.toString(), e);
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), e);
        }
	}
	
    /**
	 * 세관신고전 House B/L의 Data의 정확성 유무를 조회
	 * @param HouseBlCondVO houseBlCondVO 
	 * @return List<HouseBlDetailVO>
	 * @exception EventException
	 */
	public List<HouseBlDetailVO> checkHouseBlDataList(HouseBlCondVO houseBlCondVO) throws EventException {
        try {
        	List<HouseBlDetailVO> list = dbDao.searchHblCheckList((UsaHblCheckCondVO)houseBlCondVO);
            if(list.size() > 0){
                String strSeq = null;
                int    seq    = 0;
                String strBkg = "";
                int    cntBkg = 0;
                int    cntBl  = 0; 
                int    cntHbl = 0; 
                int    cntFiler01 = 0;
                int    cntFiler02 = 0;
                int    cntFiler03 = 0;
                int    cntFileNo  = 0;
				int cntHblEtc = 0;
				int cntFileNoEtc = 0;
            	UsaHblCheckDetailVO vo = null;
            	
            	for(int i=0; i<list.size(); i++){
            		vo = (UsaHblCheckDetailVO)list.get(i);
            		// Seq 셋팅
                	strSeq = vo.getSeq();
                	if(strSeq.equals("1")){
                		vo.setSeq(Integer.toString(++seq));
                	}else{
                		vo.setSeq(Integer.toString(seq));
                	}
                	// tot_bkg 카운트
                	if(!strBkg.equals(vo.getBkgNo())){
                		++cntBkg;
                		// tot_mbl 카운트
                		if("01".equals(vo.getMblFiler())) ++cntFiler01;
                		else if("02".equals(vo.getMblFiler())) ++cntFiler02;
                		else if("03".equals(vo.getMblFiler())) ++cntFiler03;
                	}
                	strBkg = vo.getBkgNo();
                	// 2010.04.23 변경 US, CA Filer에 따라 카운트 다르게..
					if ("01".equals(vo.getMblFiler()))
					{
						// tot_hbl 카운트
						if (!"".equals(vo.getHblSeq()))
							++cntHbl;
						// tot_fileno 카운트
						if ("Y".equals(vo.getHblFilenoFlg()))
							++cntFileNo;
					}
					else
					{
//						if ("01".equals(vo.getEtcFiler()))
//						{
							// "US" 가 아닌 tot_hbl 카운트
							if (!"".equals(vo.getHblSeq()))
								++cntHblEtc;
							// "US" 가 아닌 tot_fileno 카운트
							if ("Y".equals(vo.getHblFilenoFlg()))
								++cntFileNoEtc;
//						}
					}
            	}
        		vo = new UsaHblCheckDetailVO();
        		vo.setTotBkg(Integer.toString(cntBkg));
        		vo.setTotMbl01(Integer.toString(cntFiler01));
        		vo.setTotMbl02(Integer.toString(cntFiler02));
        		vo.setTotMbl03(Integer.toString(cntFiler03));
        		vo.setTotMbl(Integer.toString(cntFiler01+cntFiler02+cntFiler03));
        		vo.setTotHbl(Integer.toString(cntHbl));
        		cntBl = Integer.parseInt(vo.getTotMbl()) + Integer.parseInt(vo.getTotHbl());
        		vo.setTotBl(Integer.toString(cntBl));
        		vo.setTotFileno(Integer.toString(cntFileNo));
				vo.setTotHblEtc(Integer.toString(cntHblEtc));
				vo.setTotFilenoEtc(Integer.toString(cntFileNoEtc));
            	list.add(0, vo);
            }
            
            return list;
            	
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
        } catch (Exception e) {
            log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), e);
        }
	}
	
	/**
	 * 0408, 0533 등에서 입력한 내용을 저장한다.<br>
	 * 
	 * @param InbondVO[] inbondVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int modifyInbondData(InbondVO[] inbondVO, SignOnUserAccount account) throws EventException{
		try {
			UsaInbondDataVO vo = null;
        	UsaInbondContainerVO containerVo = null;
        	
        	int result = 0;
        	
        	if(inbondVO != null){
        	
	        	
	        	// 0533화면.
	        	if( ! "ESM_BKG_0408".equals(inbondVO[0].getPageNo())){
	        		for (int i=0; i < inbondVO.length; i++) {
		            	
		            	vo = (UsaInbondDataVO)inbondVO[i];
		            	
		            	// 컨테이너 단위 갱신.
		                result = dbDao.modifyGeneralArrivalbyCntr(vo);
		                
		                // BL 화면에서 호출되었다면, BL정보도 갱신.
		                if(vo.getBlCntrFlag().equals("B")){
		                	result = dbDao.modifyGeneralArrivalbyBl(vo);
		                }
		            }
	        	
	        	// 0408화면.
	        	}else{
	        		
	        		String cstmsClrTpcdChg 	= ""; // Entry Type 변경여부 저장 변수
	        		String cstmsClrTpCd 	= "";	// Entry Type 저장 변수
	        		String hubLocCd 		= "";
	        		String cstmsPodCd 		= "";
	        		String ibdTrspTpCdChg	= ""; // In-bond Type 변경여부 저장 변수
	        		String blNo 			= "";
	        		int blListSize 			= 0;
	        		List<String> blList		= new ArrayList<String>();
	        		
	        		containerVo = (UsaInbondContainerVO)inbondVO[0];
	        		//UsaInbondManifestListVO[] masterVos = containerVo.getUsaInbondManifestListVOs();
	        		UsaInbondManifestDetailListVO[] detailVos = containerVo.getUsaInbondManifestDetailListVOs();
		        	if(detailVos != null){	
		        		BkgCstmsIbdHisVO hisInfo = null;
	        			for(int i = 0; i < detailVos.length; i++){

        					
        					cstmsClrTpcdChg = detailVos[i].getCstmsClrTpCdChg();
        					cstmsClrTpCd 	= detailVos[i].getCstmsClrTpCd();
        					hubLocCd 		= detailVos[i].getHubLocCd();
        					cstmsPodCd 		= detailVos[i].getPodCd();
        					ibdTrspTpCdChg  = detailVos[i].getIbdTrspTpCdChg();

        					log.info("1###############################################");
        					log.info("ENTRY TYPE CHAGE FLAG : cstmsClrTpcdChg : "+ cstmsClrTpcdChg);
        					log.info("ENTRY TYPE : cstmsClrTpCd : "+cstmsClrTpCd);
        					log.info("ibdTrspTpCdChg : "+ibdTrspTpCdChg);
        					log.info("hubLocCd : "+hubLocCd);
        					log.info("cstmspodCd : "+cstmsPodCd);
        					log.info("1###############################################");
        					
        					/*
        					 *  ENTRY TYPE 변경 (MIB->L) 일 경우
							 *	조건:HUB_LOC_CD <> CSTMS_POD_CD
							 *	조치:bkg_cstms_adv_ibd.LOCL_CLR_IPI_MVMT_FLG = 'Y' 
        					 */
        					if(!hubLocCd.equals(cstmsPodCd) && "Y".equals(cstmsClrTpcdChg) && "L".equals(cstmsClrTpCd)) {
        						detailVos[i].setLoclClrIpiMvmtFlg("Y");
        					} else if(!hubLocCd.equals(cstmsPodCd) && "Y".equals(cstmsClrTpcdChg) && "I".equals(cstmsClrTpCd)){
        						detailVos[i].setLoclClrIpiMvmtFlg("N");
        					}
        					
                			/*
                			 * 2010.04.29 경종윤
                			 * ENTRY TYPE이 변경되거나 IN-BOND TYPE이 변경되면
                			 * 현재 BL_NO에 해당하는 HOUSE BL_NO를 구한다.
                			 */
        					String originBlNo = detailVos[i].getBlNo();
        					if("Y".equals(cstmsClrTpcdChg) || "Y".equals(ibdTrspTpCdChg)) {
        						blList = dbDao.searchBlListbyMasterBl("US",originBlNo);
        					}
        					blList.add(originBlNo);
        					blListSize = blList.size();
        					for(int idx = 0; idx < blListSize; idx++) {
        						blNo = (String)blList.get(idx);
        						
        						if(blNo.equals(originBlNo)) {
        							detailVos[i].setIbflag("origin_bl"); // 원래 bl 구분을 위해서 ibflag값을 사용한다.
        						} else {
        							detailVos[i].setIbflag("new_bl");
        						}
        						
        						detailVos[i].setBlNo(blNo);
        						
            					// IBD 테이블에 CstmsClrTpCd, IbdTrspTpCd 갱신.
    	        				result = dbDao.modifyMIBList(detailVos[i]);
    	        				// BL 테이블에 UsaLstLocCd 갱신.
    	        				result = dbDao.modifyMIBAdvList(detailVos[i]);
    	        				// 갱신후, 로그 테이블 저장.
    	        				if(result > 0){
    	        					log.info("2###############################################");
    	        					log.info("BL : "+detailVos[i].getBlNo());
    	        					log.info("LUSA : "+detailVos[i].getOldUsa()+","+detailVos[i].getUsaLstLocCd());
    	        					log.info("ENTP : "+detailVos[i].getOldEntry()+","+detailVos[i].getCstmsClrTpCd());
    	        					log.info("IBTP : "+detailVos[i].getOldTp()+","+detailVos[i].getIbdTrspTpCd());
    	        					log.info("HUB : "+detailVos[i].getOldHub()+","+detailVos[i].getHubLocCd());

    	        					log.info("2###############################################");
    	        					
    	        					if("origin_bl".equals(detailVos[i].getIbflag())) { // 원래 bl 이력 저장
    		        					// His 테이블 대상. (
    		        					hisInfo = addBlHistory( "US"+detailVos[i].getBlNo(), account.getUsr_id(), "MIB" );
    		        					
    		        					// His_dtl 테이블 대상.
    		        	        		if( ! detailVos[i].getOldUsa().equals(detailVos[i].getUsaLstLocCd())){
    		        	        			String usaLstLocCd = detailVos[i].getUsaLstLocCd();
    		        	        			if("Y".equals(detailVos[i].getLoclClrIpiMvmtFlg()) && "L".equals(detailVos[i].getCstmsClrTpCd()) ) {
    		        	        				usaLstLocCd = "";
    		        	        			}
    		        	        			addBlDetailHistory( hisInfo, "LUSA", detailVos[i].getOldUsa(), usaLstLocCd );
    		        	        		}
    		        	        		if( ! detailVos[i].getOldEntry().equals(detailVos[i].getCstmsClrTpCd())){
    		        	        			addBlDetailHistory( hisInfo, "ENTP", detailVos[i].getOldEntry(), detailVos[i].getCstmsClrTpCd() );
    		        	        		}
    		        	        		if( ! detailVos[i].getOldTp().equals(detailVos[i].getIbdTrspTpCd())){
    		        	        			addBlDetailHistory( hisInfo, "IBTP", detailVos[i].getOldTp(), detailVos[i].getIbdTrspTpCd() );
    		        	        		}
    		        	        		if( ! detailVos[i].getOldHub().equals(detailVos[i].getHubLocCd())){
    		        	        			addBlDetailHistory( hisInfo, "HUB", detailVos[i].getOldHub(), detailVos[i].getHubLocCd() );
    		        	        		}
    	        						
    	        					} else { // house bl 이력저장
		        						hisInfo = addBlHistory( "US"+blNo, account.getUsr_id(), "MIB" );
			        					
			        					// His_dtl 테이블 대상.
			        	        		if("Y".equals(detailVos[i].getLoclClrIpiMvmtFlg()) 
			        	        				&& "L".equals(detailVos[i].getCstmsClrTpCd()) 
			        	        				&& detailVos[i].getOldUsa().equals(detailVos[i].getUsaLstLocCd())){ 
			        	        			addBlDetailHistory( hisInfo, "LUSA", detailVos[i].getOldUsa(), "" );
			        	        		}
			        	        		if("Y".equals(cstmsClrTpcdChg) && ! detailVos[i].getOldEntry().equals(detailVos[i].getCstmsClrTpCd())){
			        	        			addBlDetailHistory( hisInfo, "ENTP", detailVos[i].getOldEntry(), detailVos[i].getCstmsClrTpCd() );
			        	        		}
			        	        		if("Y".equals(ibdTrspTpCdChg) && ! detailVos[i].getOldTp().equals(detailVos[i].getIbdTrspTpCd())){
			        	        			addBlDetailHistory( hisInfo, "IBTP", detailVos[i].getOldTp(), detailVos[i].getIbdTrspTpCd() );
			        	        		}
    	        						
    	        					}
    	        				}
        						
        					} // end for(idx)
        					
        					
		        		}
		        	}
	        	}
        	}
            return result;

        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            //throw new EventException(de.getMessage());
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getUserMessage());
        } catch (Exception de) {
            log.error("err " + de.toString(), de);
            //throw new EventException(de.getMessage());
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getUserMessage());
        }
	}
	

	/**
	 * P/MIB NO Assign 을 위한 조회및 MAX 시퀀스 갱신<br>
	 * 
	 * @param InBondNumberVO[] inBondNumberVO
	 * @return List<InBondNumberDetailVO>
	 * @exception EventException
	 */
	public List<InBondNumberDetailVO> assignInBondNumber(InBondNumberVO[] inBondNumberVO) throws EventException{
		List<InBondNumberDetailVO> rtnVos = new ArrayList<InBondNumberDetailVO>();
		InBondNumberDetailVO rtnVo = new InBondNumberDetailVO();
		
    	BookingUtil command2 = new BookingUtil();
    	
		String nextSeqNo = "";
		String tmpStr = "";
		int j1 = 0;
		int j2 = 0;
		int j3 = 0;
		int j4 = 0;
		int j5 = 0;
		
		int h1 = 0;
		int h2 = 0;
		int h3 = 0;
		int h4 = 0;
		int h5 = 0;
		
		int jh = 0;
		int hh = 0;
		String itChk = "";
		
		try {
			for(int i = 0; i < inBondNumberVO.length; i++){
				nextSeqNo = "";

				/*
				 * 20100531 경종윤
				 * 같은 Hub && Del 에 대해 이미 찾아진 PmibNo가 있다면 그걸로 Assign한다.
				 */
				for(int j = 0; j < i; j++){
					if(rtnVos.get(j).getHub().equals(inBondNumberVO[i].getHub()) && rtnVos.get(j).getDel().equals(inBondNumberVO[i].getDel()) && rtnVos.get(j).getCstms().equals(inBondNumberVO[i].getCstms())){
						nextSeqNo = rtnVos.get(j).getPmibNo();
						break;
					}
				}
				if("".equals(nextSeqNo)){
					/**********************************************************************
					// BKG_INTG_NO_GEN 테이블에서 가져오는 시퀀스에 대한 조회 방식을 공통 메서드를 이용하는 것으로 수정한다.
					**********************************************************************/
					// 아래가 공통메서드를 이용한 GEN_SEQ 조회 및 갱신메서드.
					BkgReferenceNoGenerationVO genVo = command2.manageBkgReferenceNumberGeneration("UIT", inBondNumberVO[i].getOfcCd(), inBondNumberVO[i].getUserId());
					nextSeqNo = genVo.getUitNo();
					/**********************************************************************/
					tmpStr = nextSeqNo;
					tmpStr = tmpStr.replace("V", "5");
					tmpStr = tmpStr.replace("N", "5"); // V17에서 V5N으로 변경되어 PMIB the check digit 룰에 따라 변경한다.
					/* 변경 룰
								A=1		J=1		S=2
								B=2		K=2		T=3
								C=3		L=3		U=4
								D=4		M=4		V=5
								E=5		N=5		W=6
								F=6		O=6		X=7
								G=7		P=7		Y=8
								H=8		Q=8		Z=9
								I=9		R=9
					*/
					
					// 짝수 자리숫자를 잘라서 숫자형식으로 변환한다.
					j1 = Integer.parseInt(tmpStr.substring(1, 2)); 
					j2 = Integer.parseInt(tmpStr.substring(3, 4));
					j3 = Integer.parseInt(tmpStr.substring(5, 6));
					j4 = Integer.parseInt(tmpStr.substring(7, 8));
					j5 = Integer.parseInt(tmpStr.substring(9));
					
					log.info("########################################");
					log.info("["+tmpStr+"] 짝수자리: "+j1+","+j2+","+j3+","+j4+","+j5);
					
					if((j1 * 2) > 9){
						j1 = (j1 * 2) - 9;
					}else{
						j1 = (j1 * 2);
					}
					if((j2 * 2) > 9){
						j2 = (j2 * 2) - 9;
					}else{
						j2 = (j2 * 2);
					}
					if((j3 * 2) > 9){
						j3 = (j3 * 2) - 9;
					}else{
						j3 = (j3 * 2);
					}
					if((j4 * 2) > 9){
						j4 = (j4 * 2) - 9;
					}else{
						j4 = (j4 * 2);
					}
					if((j5 * 2) > 9){
						j5 = (j5 * 2) - 9;
					}else{
						j5 = (j5 * 2);
					}
						
					jh = j1 + j2 + j3 + j4 + j5;
					
					// 홀수 자리숫자를 잘라서 숫자형식으로 변환한다.
					h1 = Integer.parseInt(tmpStr.substring(0, 1)); 
					h2 = Integer.parseInt(tmpStr.substring(2, 3));
					h3 = Integer.parseInt(tmpStr.substring(4, 5));
					h4 = Integer.parseInt(tmpStr.substring(6, 7));
					h5 = Integer.parseInt(tmpStr.substring(8, 9));
					
					
					hh = h1 + h2 + h3 + h4 + h5;
					itChk = Integer.toString( 10 - ((jh + hh)%10));
					if(itChk.equals("10")) itChk = "0";
					
					log.info("["+tmpStr+"] 홀수자리: "+h1+","+h2+","+h3+","+h4+","+h5);
					log.info("it_chk : "+itChk+", ("+ (jh + hh) +", "+ ((jh + hh)%10) +")");
					log.info("########################################");
					
					// DB에서 찾아온 10자리와 위의 로직에서 찾은 1자리 숫자를 합하면 새로운 PMIB No.가 된다.
					nextSeqNo = nextSeqNo + itChk;
				}	
				// return 할 VOs를 셋업한다.
				rtnVo = new InBondNumberDetailVO();
				rtnVo.setDel(inBondNumberVO[i].getDel());
				rtnVo.setPod(inBondNumberVO[i].getPod());
				rtnVo.setHub(inBondNumberVO[i].getHub());
				rtnVo.setCstms(inBondNumberVO[i].getCstms());
				rtnVo.setVvd(inBondNumberVO[i].getVvd());
				rtnVo.setPmibNo(nextSeqNo);
				rtnVos.add(rtnVo);
				
				inBondNumberVO[i].setPmibNo(nextSeqNo);
				
				
				dbDao.modifyMibNumberByBl(inBondNumberVO[i]);
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087",new String[]{}).getMessage(), ex);
		}
		return rtnVos;
	}
	
	/**
     * BKG_CSTMS_ADV_BL에 MI, AI 전송일자를 갱신한다.<br>
     * 
     * @param String blNo
     * @param String command
     * @throws Exception
     */
	public void modifyTransStage(String blNo, String command) throws EventException{
        try {
        	dbDao.modifyTransStage( blNo, command);
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
        } catch (Exception e) {
            log.error("err " + e.toString(), e);
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), e);
        }
        
	}

	/**
     * BKG_CSTMS_ADV_BL에 MI, AI 전송일자 및 cancel status를  갱신한다.<br>
     * 
     * @param String blNo
     * @param String cstmsMfTpCd
     * @param cstmsTrsmStsCd
     * @throws Exception
     */
	public void modifyTransStage2(String blNo, String cstmsMfTpCd, String cstmsTrsmStsCd) throws EventException{
        try {
        	dbDao.modifyTransStage( blNo, cstmsMfTpCd, cstmsTrsmStsCd);
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
        } catch (Exception e) {
            log.error("err " + e.toString(), e);
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), e);
        }
        
	}
	
	/**
     * TI전송 기록을 BKG_CSTMS_ADV_IBD에 갱신한다.<br>
     * 
     * @param String blNo
     * @param String usrId
     * @param String ofcCd
     * @return int 
     * @throws Exception
     */
	public int modifyTiInfo(String blNo, String usrId, String ofcCd) throws EventException{
		int result = 0;
        try {
        	result = dbDao.modifyTiInfo( blNo, usrId, ofcCd);
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
        } catch (Exception e) {
            log.error("err " + e.toString(), e);
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), e);
        }
        
        return result;
	}
	
	/**
     * modifyInbondArrFlagByBl 정보를 생성한다.<br>
     * backEndJob으로 구동하므로, 책임테이블 예외로 한다.<br>
     * 
     * @param String blNo
     * @param String transGubun
     * @throws Exception
     */
	public void modifyInbondArrFlagByBl(String blNo, String transGubun) throws EventException{

        try {
        	dbDao.modifyInbondArrFlagByBl( blNo, transGubun);
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
        } catch (Exception e) {
            log.error("err " + e.toString(), e);
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), e);
        }
        
	}
	
	/**
     * updateCntrArrExpByBlCntr 컨테이너별로 Arr, Exp 정보를 갱신한다.<br>
     * 
     * @param String blNo
     * @param String cntrNo
     * @param String transGubun
     * @throws Exception
     */
	public void updateCntrArrExpByBlCntr(String blNo, String cntrNo, String transGubun) throws EventException{

        try {
        	dbDao.updateCntrArrExpByBlCntr( blNo, cntrNo, transGubun);
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
        } catch (Exception e) {
            log.error("err " + e.toString(), e);
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), e);
        }
        
	}
	
	/**
	 * 미세관 응답메세지 수신 Cancus_cntr 결과를 추가한다.<br>
	 * 
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
     * @throws EventException
     */
	public int addCNRUInfoAtCanada(UsaRcvMsgVO usaRcvMsgVO) throws EventException{
		int retVal = 0;
        try {
        	retVal = dbDao.addCNRUInfoAtCanada(usaRcvMsgVO);
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
        } catch (Exception e) {
            log.error("err " + e.toString(), e);
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), e);
        }
        
        return retVal;
	}

	/**
	 * 미세관 응답메세지 수신 Cancus_cntr 결과를 갱신한다.<br>
	 * 
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
     * @throws EventException
     */
	public int modifyCNRUInfoAtCanada(UsaRcvMsgVO usaRcvMsgVO) throws EventException{
		int retVal = 0;
        try {
        	retVal = dbDao.modifyCNRUInfoAtCanada(usaRcvMsgVO);
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
        } catch (Exception e) {
            log.error("err " + e.toString(), e);
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), e);
        }
        return retVal;
	}
	
	/**
	 * 미세관 응답메세지 수신 NVOCC 중 BKG_CSTMS_ADV_IBD 를 갱신한다.<br>
	 * 
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
     * @throws Exception
     */
	public int modifyExpAccpDtAtBl(UsaRcvMsgVO usaRcvMsgVO) throws EventException{
		int retVal = 0;
        try {
        	retVal = dbDao.modifyExpAccpDtAtBl(usaRcvMsgVO);
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
        } catch (Exception e) {
            log.error("err " + e.toString(), e);
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), e);
        }
        return retVal;
	}

	/**
	 * 미세관 응답메세지 수신 NVOCC 중 BKG_CSTMS_ADV_CNTR 를 갱신한다.<br>
	 * 
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
     * @throws Exception
     */
	public int modifyExpAccpDtAtCntr(UsaRcvMsgVO usaRcvMsgVO) throws EventException{
		int retVal = 0;
        try {
        	retVal = dbDao.modifyExpAccpDtAtCntr(usaRcvMsgVO);
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
        } catch (Exception e) {
            log.error("err " + e.toString(), e);
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), e);
        }
        return retVal;
	}

	/**
	 * 미세관 응답메세지 수신 Nak 결과를 IBD 테이블에 갱신한다.<br>
	 * 
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
     * @throws Exception
     */
	public int modifyResultCdByBl(UsaRcvMsgVO usaRcvMsgVO) throws EventException{
		int retVal = 0;
        try {
        	retVal = dbDao.modifyResultCdByBl(usaRcvMsgVO);
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
        } catch (Exception e) {
            log.error("err " + e.toString(), e);
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), e);
        }
        return retVal;
	}

	/**
	 * 미세관 응답메세지 수신 Nak 결과를 IBD 테이블에 갱신한다.<br>
	 * 
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
     * @throws Exception
     */
	public int modifyIbd(UsaRcvMsgVO usaRcvMsgVO) throws EventException{
		int retVal = 0;
        try {
        	retVal = dbDao.modifyResultCdByBl(usaRcvMsgVO);
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
        } catch (Exception e) {
            log.error("err " + e.toString(), e);
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), e);
        }
        return retVal;
	}

	/**
	 * 미세관 응답메세지 수신 결과를 IBD 테이블에 갱신한다.(CSTMS_CLR_CNG_FLG)<br>
	 * 
	 * @param bkgCstmsAdvIbdVOs List<BkgCstmsAdvIbdVO>
	 * @throws EventException
	 */
	public void modifyIbdCstmsClrCngFlg(List<BkgCstmsAdvIbdVO> bkgCstmsAdvIbdVOs) throws EventException {
        try
		{
			dbDao.modifyIbdCstmsClrCngFlg(bkgCstmsAdvIbdVOs);
		}
		catch (DAOException de)
		{
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		}
		catch (Exception e)
		{
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), e);
		}
	}
	
	/**
	 * Actual Vvd 조회
	 * 
	 * @param VesselCondVO vesselCondVO
	 * @return List<VesselVO>
	 * @exception EventException
	 */
	public List<VesselVO> searchVessel(VesselCondVO vesselCondVO) throws EventException {
        try
		{
			return dbDao.searchActVvd((UsaVesselCondVO) vesselCondVO);
		}
		catch (DAOException ex)
		{
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
    }
	
	/**
	 * ESM_BKG_1144 SNP/Broker Nomination 조회
	 * 
	 * @param OrgPartyVO  orgPartyVO
	 * @return List<OrgPartyVO>
	 * @exception EventException
	 */
	public  List<OrgPartyVO> searchOrgPartyList(OrgPartyVO  orgPartyVO) throws EventException {
		try	{
			return dbDao.searchOrgPartyList(orgPartyVO);
		}catch(DAOException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		}catch (Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * ESM_BKG_1144 SNP/Broker Nomination 저장
	 * 
	 * @param OrgPartyVO[] orgPartyVOs
	 * @exception EventException
	 */	
	public void manageOrgPartyInfo(OrgPartyVO[]  orgPartyVOs) throws EventException {
		try
		{
			OrgPartyVO vo = null;

			for (int i = 0; i <  orgPartyVOs.length; i++)
			{
				vo = (OrgPartyVO)  orgPartyVOs[i];
				if ("I".equals(vo.getIbflag()))
				{
					dbDao.addOrgPartyList(vo);
				}
				else if ("U".equals(vo.getIbflag()) || "D".equals(vo.getIbflag()) )
				{
					dbDao.modifyOrgPartyList(vo);
				}
			}
			
		} catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
        } catch (Exception e) {
            log.error("err " + e.toString(), e);
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), e);
        }
	}
	
	/**
	 * 미세관 응답메세지 수신 결과를 BL 테이블에 갱신한다.<br>
	 * - CUSTMS_LOC_CD
	 * 
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
     * @throws Exception
     */
	public int modifyAdvancedBl(UsaRcvMsgVO usaRcvMsgVO) {
		int retVal = 0;
        try {
        	retVal = dbDao.modifyAdvancedBl(usaRcvMsgVO);
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
//            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
        } catch (Exception e) {
            log.error("err " + e.toString(), e);
        }
        return retVal;
	}
	
	
	/**
     * Customer Status Notice 정보 조회<br>
     * 
     * @param hndlOfcCd
     * @return UsCustomsStatusNoticeVO
     * @exception EventException
     */
    public UsCustomsStatusNoticeVO searchUsCustomsStatusNoticeInfo(String hndlOfcCd)  throws EventException {
    	
        try {
      	
        	UsCustomsStatusNoticeVO usCustomsVO = dbDao.searchUsCustomsStatusNoticeInfo(hndlOfcCd);
        	return usCustomsVO;
        	
        } catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		}
    }
	
	/**
     * Customer Status Notice 정보 등록,수정<br>
     * 
     * @param usCustomsVO
     * @exception EventException
     */
    public void manageUsCustomsStatusNoticeInfo(  UsCustomsStatusNoticeVO usCustomsVO )  throws EventException {

        try {
        	
            //1R 일 경우
			if ( "1R".equals(usCustomsVO.getNtcMsgTpCd1r())) {
				usCustomsVO.setNtcMsgTpCd("1R");
				usCustomsVO.setCstmsNtcMsg(usCustomsVO.getCstmsNtcMsg1r());				
				dbDao.manageUsCustomsStatusNoticeInfo(usCustomsVO);
			}
            //1S 일 경우			
			if ( "1S".equals(usCustomsVO.getNtcMsgTpCd1s())) {
				usCustomsVO.setNtcMsgTpCd("1S");
				usCustomsVO.setCstmsNtcMsg(usCustomsVO.getCstmsNtcMsg1s());				
				dbDao.manageUsCustomsStatusNoticeInfo(usCustomsVO);
			}
		
        } catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}

    }
    
	
}