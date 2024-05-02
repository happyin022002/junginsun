/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TariffGeneralInformationBCImpl.java
*@FileTitle : Tariff General Information Creation &amp; Amendment
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.13
*@LastModifier : 김민아
*@LastVersion : 1.0
* 2010.10.13 김민아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.tariffgeneralinformation.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.tariff.tariffgeneralinformation.integration.TariffGeneralInformationDBDAO;
import com.hanjin.apps.alps.esm.pri.tariff.tariffgeneralinformation.vo.PriTrfBzcHistoryAmendVO;
import com.hanjin.apps.alps.esm.pri.tariff.tariffgeneralinformation.vo.PriTrfBzcHistoryVO;
import com.hanjin.apps.alps.esm.pri.tariff.tariffgeneralinformation.vo.RsltMdmOrganizationVO;
import com.hanjin.apps.alps.esm.pri.tariff.tariffgeneralinformation.vo.RsltPriTrfBzcListVO;
import com.hanjin.apps.alps.esm.pri.tariff.tariffgeneralinformation.vo.RsltPriTrfBzcVO;
import com.hanjin.apps.alps.esm.pri.tariff.tariffgeneralinformation.vo.TrfBzcMnVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriTrfBzcProgVO;
import com.hanjin.syscommon.common.table.PriTrfBzcRoutPntVO;
import com.hanjin.syscommon.common.table.PriTrfBzcVO;

/**
 * ALPS-Tariff Business Logic Command Interface<br>
 * - ALPS-Tariff에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM MINAH
 * @since J2EE 1.6
 */
public class TariffGeneralInformationBCImpl extends BasicCommandSupport implements TariffGeneralInformationBC {

	// Database Access Object
	private transient TariffGeneralInformationDBDAO dbDao = null;

	/**
	 * TariffRuleBCImpl 객체 생성<br>
	 * TariffRuleDBDAO를 생성한다.<br>
	 */
	public TariffGeneralInformationBCImpl() {
		dbDao = new TariffGeneralInformationDBDAO();
	}
	/**
	 * Tariff Code의 General Information을 조회한다.<br>
	 * 
	 * @param PriTrfBzcVO priTrfBzcVO
	 * @param SignOnUserAccount account
	 * @return RsltPriTrfBzcListVO
	 * @exception EventException
	 */
	public RsltPriTrfBzcListVO searchTariffGeneralInformation(PriTrfBzcVO priTrfBzcVO, SignOnUserAccount account) throws EventException {
		try {
			RsltPriTrfBzcListVO vo = new RsltPriTrfBzcListVO();
			
			// HQ Office에 해당하는지 조회 한다.
			RsltMdmOrganizationVO orgVO = dbDao.searchMdmOrganization(account);
			
			vo.setRsltPriTrfBzcVOs(dbDao.searchTariffGeneralInformation(priTrfBzcVO, orgVO, account));
			vo.setRsltPriTrfBzcRoutPntVOs(dbDao.searchTariffGeneralInformationScope(priTrfBzcVO, "O")); //Tariff Scope - Origin
			vo.setRsltPriTrfBzcRoutPntVOs2(dbDao.searchTariffGeneralInformationScope(priTrfBzcVO, "D")); //Tariff Scope - Destination
			
			return vo;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		
	}
	
	/**
	 * Tariff Code의 General Information을 저장한다.<br>
	 * 
	 * @param TrfBzcMnVO trfBzcMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTariffGeneralInformation(TrfBzcMnVO trfBzcMnVO, SignOnUserAccount account) throws EventException{
		try {
			// Tariff Basic Information
			PriTrfBzcVO priTrfBzcVO = trfBzcMnVO.getPriTrfBzcVO();
			if(priTrfBzcVO.getIbflag().equals("I")){
				// 1.Tariff Basic
				priTrfBzcVO.setCreUsrId(account.getUsr_id());
				priTrfBzcVO.setUpdUsrId(account.getUsr_id());
				dbDao.addTariffBasic(priTrfBzcVO);
				// 2.Tariff Basic Progress
				PriTrfBzcProgVO priTrfBzcProgVO = trfBzcMnVO.getPriTrfBzcProgVO();
				priTrfBzcProgVO.setCreUsrId(account.getUsr_id());
				priTrfBzcProgVO.setUpdUsrId(account.getUsr_id());
				priTrfBzcProgVO.setProgUsrId(account.getUsr_id());
				priTrfBzcProgVO.setProgOfcCd(account.getOfc_cd());
				dbDao.addTariffBasicProgress(priTrfBzcProgVO);
			}else if(priTrfBzcVO.getIbflag().equals("U")){
				// 1.Tariff Basic
				priTrfBzcVO.setCreUsrId(account.getUsr_id());
				priTrfBzcVO.setUpdUsrId(account.getUsr_id());
				dbDao.modifyTariffBasic(priTrfBzcVO);
			}
			
			// Tariff Scope Origin
			if(trfBzcMnVO.getPriTrfBzcRoutPntVOs() != null){
				PriTrfBzcRoutPntVO[] vo  = trfBzcMnVO.getPriTrfBzcRoutPntVOs();
				
				List<PriTrfBzcRoutPntVO> insertVoList = new ArrayList<PriTrfBzcRoutPntVO>();
				List<PriTrfBzcRoutPntVO> updateVoList = new ArrayList<PriTrfBzcRoutPntVO>();
				List<PriTrfBzcRoutPntVO> deleteVoList = new ArrayList<PriTrfBzcRoutPntVO>();
				
				for ( int i=0; i<vo.length; i++ ) {
					if ( vo[i].getIbflag().equals("I")){
						vo[i].setCreUsrId(account.getUsr_id());
						vo[i].setUpdUsrId(account.getUsr_id());
						insertVoList.add(vo[i]);
					} else if ( vo[i].getIbflag().equals("U")){
						vo[i].setUpdUsrId(account.getUsr_id());
						vo[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(vo[i]);
					} else if ( vo[i].getIbflag().equals("D")){
						deleteVoList.add(vo[i]);
					}
				}
				
				if ( deleteVoList.size() > 0 ) {
					dbDao.removeTariffBasicRoutePoints(deleteVoList);			
				}
				if ( insertVoList.size() > 0 ) {
					dbDao.addTariffBasicRoutePoints(insertVoList);
				}
				if ( updateVoList.size() > 0 ) {
					dbDao.modifyTariffBasicRoutePoints(updateVoList);
				}
			}
			
			// Tariff Scope Destination
			if(trfBzcMnVO.getPriTrfBzcRoutPntVOs2() != null){
				PriTrfBzcRoutPntVO[] vo2 = trfBzcMnVO.getPriTrfBzcRoutPntVOs2();
				
				List<PriTrfBzcRoutPntVO> insertVoList2 = new ArrayList<PriTrfBzcRoutPntVO>();
				List<PriTrfBzcRoutPntVO> updateVoList2 = new ArrayList<PriTrfBzcRoutPntVO>();
				List<PriTrfBzcRoutPntVO> deleteVoList2 = new ArrayList<PriTrfBzcRoutPntVO>();
				
				for ( int i=0; i<vo2.length; i++ ) {
					if ( vo2[i].getIbflag().equals("I")){
						vo2[i].setCreUsrId(account.getUsr_id());
						vo2[i].setUpdUsrId(account.getUsr_id());
						insertVoList2.add(vo2[i]);
					} else if ( vo2[i].getIbflag().equals("U")){
						vo2[i].setUpdUsrId(account.getUsr_id());
						vo2[i].setUpdUsrId(account.getUsr_id());
						updateVoList2.add(vo2[i]);
					} else if ( vo2[i].getIbflag().equals("D")){
						deleteVoList2.add(vo2[i]);
					}
				}
				
				if ( deleteVoList2.size() > 0 ) {
					dbDao.removeTariffBasicRoutePoints(deleteVoList2);			
				}
				if ( insertVoList2.size() > 0 ) {
					dbDao.addTariffBasicRoutePoints(insertVoList2);
				}
				if ( updateVoList2.size() > 0 ) {
					dbDao.modifyTariffBasicRoutePoints(updateVoList2);
				}

			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Tariff Code의 General Information을 삭제한다.<br>
	 * 
	 * @param PriTrfBzcVO priTrfBzcVO
	 * @exception EventException
	 */
	public void removeTariffGeneralInformation(PriTrfBzcVO priTrfBzcVO)  throws EventException{
		try {
			if(priTrfBzcVO != null){
				dbDao.removeTariffBasicProgress(priTrfBzcVO);
				dbDao.removeTariffBasicRoutePoint(priTrfBzcVO);
				dbDao.removeTariffBasic(priTrfBzcVO);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Tariff Code의 General Information을 Request한다.<br>
	 * 
	 * @param TrfBzcMnVO trfBzcMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void requestTariffGeneralInformation(TrfBzcMnVO trfBzcMnVO, SignOnUserAccount account)  throws EventException{
		try {
			// 1.Tariff Basic
			if(trfBzcMnVO.getPriTrfBzcVO() != null){
				PriTrfBzcVO priTrfBzcVO = trfBzcMnVO.getPriTrfBzcVO();
				priTrfBzcVO.setUpdUsrId(account.getUsr_id());
				// Request 시에는 PUB_DT,EFF_DT의 Update가 필요없다.
				priTrfBzcVO.setPubDt(null);
				priTrfBzcVO.setEffDt(null);
				dbDao.modifyTariffBasicStatus(priTrfBzcVO);
			}
			// 2.Tariff Basic Progress
			if(trfBzcMnVO.getPriTrfBzcProgVO() != null){
				PriTrfBzcProgVO priTrfBzcProgVO = trfBzcMnVO.getPriTrfBzcProgVO();
				priTrfBzcProgVO.setCreUsrId(account.getUsr_id());
				priTrfBzcProgVO.setUpdUsrId(account.getUsr_id());
				priTrfBzcProgVO.setProgUsrId(account.getUsr_id());
				priTrfBzcProgVO.setProgOfcCd(account.getOfc_cd());
				dbDao.addTariffBasicProgress(priTrfBzcProgVO);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Tariff Code의 General Information을 Approve한다.<br>
	 * 
	 * @param TrfBzcMnVO trfBzcMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void approveTariffGeneralInformation(TrfBzcMnVO trfBzcMnVO, SignOnUserAccount account)  throws EventException{
		try {
			// 1.Tariff Basic
			if(trfBzcMnVO.getPriTrfBzcVO() != null){
				PriTrfBzcVO priTrfBzcVO = trfBzcMnVO.getPriTrfBzcVO();
				priTrfBzcVO.setUpdUsrId(account.getUsr_id());
				// Approve 시에는 PUB_DT,EFF_DT의 Update가 필요없다.
				priTrfBzcVO.setPubDt(null);
				priTrfBzcVO.setEffDt(null);
				dbDao.modifyTariffBasicStatus(priTrfBzcVO);
			}
			// 2.Tariff Basic Progress
			if(trfBzcMnVO.getPriTrfBzcProgVO() != null){
				PriTrfBzcProgVO priTrfBzcProgVO = trfBzcMnVO.getPriTrfBzcProgVO();
				priTrfBzcProgVO.setCreUsrId(account.getUsr_id());
				priTrfBzcProgVO.setUpdUsrId(account.getUsr_id());
				priTrfBzcProgVO.setProgUsrId(account.getUsr_id());
				priTrfBzcProgVO.setProgOfcCd(account.getOfc_cd());
				dbDao.addTariffBasicProgress(priTrfBzcProgVO);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Tariff Code의 General Information을 Cancel한다.<br>
	 * 
	 * @param TrfBzcMnVO trfBzcMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelTariffGeneralInformation(TrfBzcMnVO trfBzcMnVO, SignOnUserAccount account)  throws EventException{
		try {
			String strTrfBzcStsCd = null;
			if(trfBzcMnVO.getPriTrfBzcVO() != null){
				PriTrfBzcVO priTrfBzcVO = trfBzcMnVO.getPriTrfBzcVO();
				strTrfBzcStsCd = priTrfBzcVO.getTrfBzcStsCd();
				
				// Amdt Seq가 1이상, Status가 Initial인 경우 Cancel 했을 때 현재 Amdt Seq 데이터 삭제 및 Progress 생성 안함
				// Status는 Initial일 경우 js에서 "F"로 셋팅함
				if("F".equals(strTrfBzcStsCd) && Integer.parseInt(priTrfBzcVO.getAmdtSeq())>0){
					dbDao.removeTariffBasicProgress(priTrfBzcVO);
					dbDao.removeTariffBasicRoutePoint(priTrfBzcVO);
					dbDao.removeTariffBasic(priTrfBzcVO);
				}else{
				// Status 변경 및 Progress 생성
					priTrfBzcVO.setUpdUsrId(account.getUsr_id());
					// Cancel 시에는 PUB_DT,EFF_DT의 Update가 필요없다.
					priTrfBzcVO.setPubDt(null);
					priTrfBzcVO.setEffDt(null);
					dbDao.modifyTariffBasicStatus(priTrfBzcVO);
					
					if(trfBzcMnVO.getPriTrfBzcProgVO() != null){
						PriTrfBzcProgVO priTrfBzcProgVO = trfBzcMnVO.getPriTrfBzcProgVO();
						priTrfBzcProgVO.setCreUsrId(account.getUsr_id());
						priTrfBzcProgVO.setUpdUsrId(account.getUsr_id());
						priTrfBzcProgVO.setProgUsrId(account.getUsr_id());
						priTrfBzcProgVO.setProgOfcCd(account.getOfc_cd());
						dbDao.addTariffBasicProgress(priTrfBzcProgVO);
					}
				}
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Tariff Code의 General Information을 Amend한다.<br>
	 * 
	 * @param TrfBzcMnVO trfBzcMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendTariffGeneralInformation(TrfBzcMnVO trfBzcMnVO, SignOnUserAccount account)  throws EventException{
		try {
			// 1.Tariff Basic
			if(trfBzcMnVO.getPriTrfBzcVO() != null){
				PriTrfBzcVO priTrfBzcVO = trfBzcMnVO.getPriTrfBzcVO();
				priTrfBzcVO.setCreUsrId(account.getUsr_id());
				priTrfBzcVO.setUpdUsrId(account.getUsr_id());
				priTrfBzcVO.setRqstOfcCd(account.getOfc_cd());
				dbDao.addTariffBasicAmend(priTrfBzcVO);
				dbDao.addTariffBasicRoutePointAmend(priTrfBzcVO);
			}
			// 2.Tariff Basic Progress
			if(trfBzcMnVO.getPriTrfBzcProgVO() != null){
				PriTrfBzcProgVO priTrfBzcProgVO = trfBzcMnVO.getPriTrfBzcProgVO();
				priTrfBzcProgVO.setTrfBzcStsCd("I");
				priTrfBzcProgVO.setAmdtSeq((Integer.parseInt(priTrfBzcProgVO.getAmdtSeq())+1)+"");
				priTrfBzcProgVO.setCreUsrId(account.getUsr_id());
				priTrfBzcProgVO.setUpdUsrId(account.getUsr_id());
				priTrfBzcProgVO.setProgUsrId(account.getUsr_id());
				priTrfBzcProgVO.setProgOfcCd(account.getOfc_cd());
				dbDao.addTariffBasicProgress(priTrfBzcProgVO);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Tariff Code의 General Information을 Publish한다.<br>
	 * 
	 * @param TrfBzcMnVO trfBzcMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void publishTariffGeneralInformation(TrfBzcMnVO trfBzcMnVO, SignOnUserAccount account)  throws EventException{
		try {
			// 1.Tariff Basic
			if(trfBzcMnVO.getPriTrfBzcVO() != null){
				// Publish 처리
				PriTrfBzcVO priTrfBzcVO = trfBzcMnVO.getPriTrfBzcVO();
				priTrfBzcVO.setUpdUsrId(account.getUsr_id());
				dbDao.modifyTariffBasicStatus(priTrfBzcVO);
				
				// 이전SEQ의 EXP_DT를 현재SEQ의 EFF_DT -1 로 수정
				dbDao.modifyTariffBasicPublish(priTrfBzcVO);
			}
			// 2.Tariff Basic Progress
			if(trfBzcMnVO.getPriTrfBzcProgVO() != null){
				PriTrfBzcProgVO priTrfBzcProgVO = trfBzcMnVO.getPriTrfBzcProgVO();
				priTrfBzcProgVO.setCreUsrId(account.getUsr_id());
				priTrfBzcProgVO.setUpdUsrId(account.getUsr_id());
				priTrfBzcProgVO.setProgUsrId(account.getUsr_id());
				priTrfBzcProgVO.setProgOfcCd(account.getOfc_cd());
				dbDao.addTariffBasicProgress(priTrfBzcProgVO);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Tariff General Information List를 조회한다.<br>
	 * 
	 * @param PriTrfBzcVO priTrfBzcVO
	 * @return List<RsltPriTrfBzcVO>
	 * @exception EventException
	 */
	public List<RsltPriTrfBzcVO> searchTariffGeneralInformationInquiryList(PriTrfBzcVO priTrfBzcVO) throws EventException {
		try {
			return dbDao.searchTariffGeneralInformationInquiryList(priTrfBzcVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		
	}
	
	/**
	 * Tariff General Information Detail을 조회한다.<br>
	 * 
	 * @param PriTrfBzcVO priTrfBzcVO
	 * @return RsltPriTrfBzcListVO
	 * @exception EventException
	 */
	public RsltPriTrfBzcListVO searchTariffGeneralInformationInquiry(PriTrfBzcVO priTrfBzcVO) throws EventException {
		try {
			RsltPriTrfBzcListVO vo = new RsltPriTrfBzcListVO();
			
			RsltMdmOrganizationVO orgVO = null;
			SignOnUserAccount account = null;
			
			//Tariff General Information 화면과 동일한 dbDao 메소드 호출
			vo.setRsltPriTrfBzcVOs(dbDao.searchTariffGeneralInformation(priTrfBzcVO, orgVO, account));
			vo.setRsltPriTrfBzcRoutPntVOs(dbDao.searchTariffGeneralInformationInquiryScope(priTrfBzcVO, "O")); //Tariff Scope - Origin
			vo.setRsltPriTrfBzcRoutPntVOs2(dbDao.searchTariffGeneralInformationInquiryScope(priTrfBzcVO, "D")); //Tariff Scope - Destination
			return vo;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		
	}
	
	/**
	 * ESM_PRI_3504 : Retrieve <br>
	 * Tariff General Information History
	 * 
	 * @param PriTrfBzcHistoryVO priTrfBzcHistoryVO
	 * @return List<PriTrfBzcHistoryVO>
	 * @exception EventException
	 */
	public List<PriTrfBzcHistoryVO> searchTariffGeneralHistoryList(PriTrfBzcHistoryVO priTrfBzcHistoryVO) throws EventException {
		try {	
			return dbDao.searchTariffGeneralHistoryList(priTrfBzcHistoryVO);
		}catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_PRI_3504 : sheet1 double click <br>
	 * Tariff General Information Amend History
	 * 
	 * @param PriTrfBzcHistoryAmendVO priTrfBzcHistoryAmendVO
	 * @return List<PriTrfBzcHistoryAmendVO>
	 * @exception EventException
	 */
	public List<PriTrfBzcHistoryAmendVO> searchTariffGeneralAmendHistoryList(PriTrfBzcHistoryAmendVO priTrfBzcHistoryAmendVO) throws EventException {
		try {	
			return dbDao.searchTariffGeneralAmendHistoryList(priTrfBzcHistoryAmendVO);
		}catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_PRI_3504 : sheet2 double click <br>
	 * Tariff General Information Amend History Detail<br>
	 * 
	 * @param PriTrfBzcVO priTrfBzcVO
	 * @return RsltPriTrfBzcListVO
	 * @exception EventException
	 */
	public RsltPriTrfBzcListVO searchTariffGeneralHistory(PriTrfBzcVO priTrfBzcVO) throws EventException {
		try {
			RsltPriTrfBzcListVO vo = new RsltPriTrfBzcListVO();			
			//Tariff General Information 화면과 동일한 dbDao 메소드 호출
			vo.setRsltPriTrfBzcRoutPntVOs(dbDao.searchTariffGeneralInformationInquiryScope(priTrfBzcVO, "O")); //Tariff Scope - Origin
			vo.setRsltPriTrfBzcRoutPntVOs2(dbDao.searchTariffGeneralInformationInquiryScope(priTrfBzcVO, "D")); //Tariff Scope - Destination
			return vo;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		
	}
	
	/**
	 * Tariff Basic Save/Delete/Request/Cancel 전 체크<br>
	 * 
	 * @param PriTrfBzcVO priTrfBzcVO
	 * @return int
	 * @exception EventException
	 */
	public int searchTariffCodeExistCheck(PriTrfBzcVO priTrfBzcVO) throws EventException {
		try {
			
			int cnt = dbDao.searchTariffCodeExistCheck(priTrfBzcVO);
			
			return cnt;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		
	}
	
	/**
	 * Tariff Basic Save/Delete/Request/Cancel 전 체크<br>
	 * 
	 * @param PriTrfBzcVO priTrfBzcVO
	 * @return int
	 * @exception EventException
	 */
	public int searchTariffBasicExistCheck(PriTrfBzcVO priTrfBzcVO) throws EventException {
		try {
			
			int cnt = dbDao.searchTariffBasicExistCheck(priTrfBzcVO);
			
			return cnt;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		
	}
	
}