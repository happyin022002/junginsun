/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DVFactorMgtBCImpl.java
*@FileTitle : DV Factor
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.11
*@LastModifier : 조경완
*@LastVersion : 1.0
* 2009.05.20 김완규
* 1.0 Creation
* --------------------------------------------------------
* History
* 2011.11.29 김상수 [CHM-201114696-01] ALPS > MNR > Seal management creation 화면과 inquiry 화면 - Seal No의 prefix만 별도 컬럼으로 분리
*                                      - MNR_SEAL_PLN 테이블에 Serial Range 값을 분리하여 저장, 조회
*                                      - 해당 컬럼명을 사용하는 js및 쿼리, VO 전면수정
* 2012.09.11 조경완 [CHM-201220024-01] Container Seal Inquiry Back End Job 방식 구현
* 										- 관련 SQL 수정 및 VO 수정 
* 										- Back End Job Class 두개 생성      
* 2012.10.26 조경완 [CHM-201220518-01] ALPS MNR-CNTR SEAL Creation 시, Logic 검토 및 보완 요청
* 										1.CNTR SEAL Creation Data 조회시 입력한 그대로 보여줌
*										2. 생성시 자리수 체크                               
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.integration.DVFactorMgtDBDAO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.vo.ContainerSealInquiryVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.vo.ContainerSealNoCreationGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.vo.ContainerSealNoCreationVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.vo.CustomMnrEqDpcVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.vo.DVFactorGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.vo.DvLeasedUnitINGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.vo.DvLeasedUnitVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.backend.support.BackEndJobException;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * alps-GeneralManage Business Logic Basic Command implementation<br>
 * - alps-GeneralManage에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Wangyu Kim
 * @see ESS_MNR_0107EventResponse,DVFactorMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class DVFactorMgtBCImpl extends BasicCommandSupport implements DVFactorMgtBC {

	// Database Access Object
	private transient DVFactorMgtDBDAO dbDao = null;

	/**
	 * DVFactorMgtBCImpl 객체 생성<br>
	 * CDVFactorMgtDBDAO를 생성한다.<br>
	 */
	public DVFactorMgtBCImpl() {
		dbDao = new DVFactorMgtDBDAO();
	}

	/**
	 * [EES_MNR_0107]DV Factor의 정보를 조회 합니다. <br>
	 *
	 * @param DVFactorGRPVO dVFactorGRPVO
	 * @return DVFactorGRPVO
	 * @exception EventException
	 */
	public DVFactorGRPVO searchDVFactorListBasic(DVFactorGRPVO dVFactorGRPVO) throws EventException {
		try {
			//다중조회
			List<List<CustomMnrEqDpcVO>> listCustomMnrEqDpcVOs = new ArrayList<List<CustomMnrEqDpcVO>>();

			dVFactorGRPVO.getDVFactorINVO().setEqKndCd("U");  //U:CONTAINER
			List<CustomMnrEqDpcVO> customMnrEqDpcVO0 = dbDao.searchDVFactorListData(dVFactorGRPVO.getDVFactorINVO());
			dVFactorGRPVO.getDVFactorINVO().setEqKndCd("Z");  //Z:CHASSIS
			List<CustomMnrEqDpcVO> customMnrEqDpcVO1 = dbDao.searchDVFactorListData(dVFactorGRPVO.getDVFactorINVO());
			dVFactorGRPVO.getDVFactorINVO().setEqKndCd("G");  //G:GENSET
			List<CustomMnrEqDpcVO> customMnrEqDpcVO2 = dbDao.searchDVFactorListData(dVFactorGRPVO.getDVFactorINVO());

			listCustomMnrEqDpcVOs.add(customMnrEqDpcVO0);
			listCustomMnrEqDpcVOs.add(customMnrEqDpcVO1);
			listCustomMnrEqDpcVOs.add(customMnrEqDpcVO2);

			dVFactorGRPVO.setListCustomMnrEqDpcVOs(listCustomMnrEqDpcVOs);

			return dVFactorGRPVO;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0107] searchDVFactorListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0107] searchDVFactorListBasic"}).getMessage(),ex);
		}
	}

	/**
	 * [EES_MNR_0107]DV Factor의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param DVFactorGRPVO dVFactorGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDVFactorBasic(DVFactorGRPVO dVFactorGRPVO, SignOnUserAccount account) throws EventException{
		try {
			List<CustomMnrEqDpcVO> updateVoList = new ArrayList<CustomMnrEqDpcVO>();

			CustomMnrEqDpcVO[] customMnrEqDpcVO = dVFactorGRPVO.getArrayCustomMnrEqDpcVOs();

			for ( int i=0; i< customMnrEqDpcVO.length; i++ ) {
				//SQL에서 Merge 문 사용함에 따라 creUsrId도 입력함
				if  ( customMnrEqDpcVO[i].getIbflag().equals("U")){
					customMnrEqDpcVO[i].setCreUsrId(account.getUsr_id());
					customMnrEqDpcVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(customMnrEqDpcVO[i]);
				}
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyDVFactorData(updateVoList);
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0107] manageDVFactorBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0107] manageDVFactorBasic"}).getMessage(),ex);
		}
	}

	/**
	 * [EES_MNR_0249] DV Leased Unit의 정보를 조회 합니다. <br>
	 *
	 * @param DvLeasedUnitINGRPVO dvLeasedUnitINGRPVO
	 * @return dvLeasedUnitINGRPVO
	 * @exception EventException
	 */
	public DvLeasedUnitINGRPVO searchDvLeasedUnitListBasic(DvLeasedUnitINGRPVO dvLeasedUnitINGRPVO)throws EventException {
		try {

				List<DvLeasedUnitVO> dvLeasedUnitVO = new ArrayList<DvLeasedUnitVO>();
				dvLeasedUnitVO = dbDao.searchDvLeasedUnitListData(dvLeasedUnitINGRPVO.getDvLeasedUnitINVO());
				dvLeasedUnitINGRPVO.setDvLeasedUnitVOs(dvLeasedUnitVO);

				return dvLeasedUnitINGRPVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0249] searchDvLeasedUnitListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0249] searchDvLeasedUnitListBasic"}).getMessage(),ex);
		}
	}

	/**
	 * [EES_MNR_0249] DV Leased Unit의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param DvLeasedUnitINGRPVO dvLeasedUnitINGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDvLeasedUnitListBasic(DvLeasedUnitINGRPVO dvLeasedUnitINGRPVO, SignOnUserAccount account) throws EventException {
		try {
			DvLeasedUnitVO[] dvLeasedUnitVO = dvLeasedUnitINGRPVO.getArrayDvLeasedUnitVOs();
			if(dvLeasedUnitVO == null) return;

			for ( int i=0; i< dvLeasedUnitVO.length; i++ ) {
				if(dvLeasedUnitVO[i] == null) break;
				dvLeasedUnitVO[i].setCreUsrId(account.getUsr_id());		//등록id - 로그인 사용자id
				dvLeasedUnitVO[i].setUpdUsrId(account.getUsr_id());		//수정id - 로그인 사용자id

				if ( dvLeasedUnitVO[i].getIbflag().equals("I")){			//등록
					dbDao.createHangerInventoryData(dvLeasedUnitVO[i]);
				} else if ( dvLeasedUnitVO[i].getIbflag().equals("U")){		//수정
					dbDao.modifyDvLeasedUnitListData(dvLeasedUnitVO[i]);
				} else if ( dvLeasedUnitVO[i].getIbflag().equals("D")){		//삭제
					dbDao.removeHangerInventoryData(dvLeasedUnitVO[i]);
				}
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0249] manageDvLeasedUnitListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0249] manageDvLeasedUnitListBasic"}).getMessage(),ex);
		}
	}

	/**
	 * [EES_MNR_0253] Seal Range Creation의 정보를 조회한다. <br>
	 *
	 * @param ContainerSealNoCreationGRPVO containerSealNoCreationGRPVO
	 * @return ContainerSealNoCreationGRPVO
	 * @exception EventException
	 */
	public ContainerSealNoCreationGRPVO searchSealRangeCreationListBasic(ContainerSealNoCreationGRPVO containerSealNoCreationGRPVO)throws EventException {
		try {
				List<ContainerSealNoCreationVO> containerSealNoCreationVO = new ArrayList<ContainerSealNoCreationVO>();
				containerSealNoCreationVO = dbDao.searchContainerSealNoCreationData(containerSealNoCreationGRPVO.getContainerSealNoCreationVO());

				containerSealNoCreationGRPVO.setContainerSealNoCreationVOs(containerSealNoCreationVO);
				return containerSealNoCreationGRPVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0249] searchSealRangeCreationListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0249] searchSealRangeCreationListBasic"}).getMessage(),ex);
		}
	}

	/**
	 * [EES_MNR_0253] Seal Range Creation의 정보를 멀티처리한다. <br>
	 *
	 * @param ContainerSealNoCreationVO[] containerSealNoCreationVOs
	 * @param SignOnUserAccount account
	 * @return List<ContainerSealNoCreationVO>
	 * @exception EventException
	 */

	public List<ContainerSealNoCreationVO> manageSealRangeCreationListBasic(ContainerSealNoCreationVO[] containerSealNoCreationVOs, SignOnUserAccount account) throws EventException{
		List<ContainerSealNoCreationVO> list = new ArrayList<ContainerSealNoCreationVO>();
		try {
			List<ContainerSealNoCreationVO> insertVoList = new ArrayList<ContainerSealNoCreationVO>();
			List<ContainerSealNoCreationVO> updateVoList = new ArrayList<ContainerSealNoCreationVO>();
			List<ContainerSealNoCreationVO> deleteVoList = new ArrayList<ContainerSealNoCreationVO>();
			List<ContainerSealNoCreationVO> rtnVo = new ArrayList<ContainerSealNoCreationVO>();

			String sFlag = "";
			String sUpdChk = "";

			for ( int i=0; i<containerSealNoCreationVOs.length; i++ ) {
				sFlag = containerSealNoCreationVOs[i].getIbflag();
				sUpdChk = containerSealNoCreationVOs[i].getUpdChk();

				if (sFlag.equals("I")){
					if(containerSealNoCreationVOs[i].getN1stSerRngSealNo().startsWith("0")){
						containerSealNoCreationVOs[i].setRmk("Y");
					}
					rtnVo = dbDao.searchContainerSealNoCreationChkData(containerSealNoCreationVOs[i]);
					String sRmk = "";
					if (rtnVo.size() > 0){
						for(int t=0; t<rtnVo.size(); t++){
							sRmk= sRmk+ rtnVo.get(t).getRmk()+"\n";
						}
						containerSealNoCreationVOs[i].setRmk(sRmk);
						list.add(containerSealNoCreationVOs[i]);
					}
				}

				if  (sFlag.equals("U") && sUpdChk.equals("Y")){
					if(containerSealNoCreationVOs[i].getN1stSerRngSealNo().startsWith("0")){
						containerSealNoCreationVOs[i].setRmk("Y");
					}
					rtnVo = dbDao.searchContainerSealNoCreationChkData(containerSealNoCreationVOs[i]);
					String sRmk = "";
					if (rtnVo.size() > 0){
						for(int t=0; t<rtnVo.size(); t++){
							sRmk= sRmk+ rtnVo.get(t).getRmk()+"\n";
						}
						containerSealNoCreationVOs[i].setRmk(sRmk);
						containerSealNoCreationVOs[i].setUpdDt(sRmk);
						list.add(containerSealNoCreationVOs[i]);
					}
				}

				if (sFlag.equals("I") && rtnVo.size() == 0){
					containerSealNoCreationVOs[i].setCreUsrId(account.getUsr_id());
					containerSealNoCreationVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(containerSealNoCreationVOs[i]);

				} else if (sFlag.equals("U") && rtnVo.size() == 0){
					containerSealNoCreationVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(containerSealNoCreationVOs[i]);

				} else if (containerSealNoCreationVOs[i].getIbflag().equals("D")){
					deleteVoList.add(containerSealNoCreationVOs[i]);
				}
			}

			if ( insertVoList.size() > 0) {
				dbDao.createContainerSealNoCreationData(insertVoList);
			}
			if ( updateVoList.size() > 0) {
				dbDao.modifyContainerSealNoCreationData(updateVoList);
			}
			if ( deleteVoList.size() > 0) {
				dbDao.removeContainerSealNoCreationData(deleteVoList);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0249] manageSealRangeCreationListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0249] manageSealRangeCreationListBasic"}).getMessage(),ex);
		}
		return list;
	}

	/**
	 * [EES_MNR_0254] Container Seal Inquiry 카운트(Out of Range) 조회<br>
	 *
	 * @param ContainerSealInquiryVO containerSealInquiryVO
	 * @return String
	 * @throws EventException
	 */
	 public String searchContainerSealInquiryCount(ContainerSealInquiryVO containerSealInquiryVO) throws EventException {
		try {
			return dbDao.searchContainerSealInquiryCount(containerSealInquiryVO);
		} catch (DAOException ex) {
			log.error("err : " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0254] searchContainerSealInquiryList"}).getMessage(),ex);
		} catch(Exception ex) {
			log.error("err : " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0254] searchContainerSealInquiryList"}).getMessage(),ex);
		}
	}

	/**
	 * [EES_MNR_0254] Container Seal Inquiry 목록 조회<br>
	 *
	 * @param ContainerSealInquiryVO containerSealInquiryVO
	 * @return List<ContainerSealInquiryVO>
	 * @throws EventException
	 */
	 public List<ContainerSealInquiryVO> searchContainerSealInquiryList(ContainerSealInquiryVO containerSealInquiryVO) throws EventException {
		try {
			return dbDao.searchContainerSealInquiryList(containerSealInquiryVO);
		} catch (DAOException ex) {
			log.error("err : " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0254] searchContainerSealInquiryList"}).getMessage(),ex);
		} catch(Exception ex) {
			log.error("err : " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0254] searchContainerSealInquiryList"}).getMessage(),ex);
		}
	}
	
	 
	/**
	 * EES_MNR_0254 : SEARCH<br>
	 * Container Seal List 를 조회합니다. <br>
	 * 
	 * @param ContainerSealInquiryVO containerSealInquiryVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	*/
	public String searchBackEndCntrSealListBasic(ContainerSealInquiryVO containerSealInquiryVO, SignOnUserAccount account) throws EventException{
		DVFactorCNTRSealInquiryListBackEndJob backEndJob = new DVFactorCNTRSealInquiryListBackEndJob();
		backEndJob.setJobType("searchBackEndCntrSealListBasic");
		backEndJob.setContainerSealInquiryVO(containerSealInquiryVO);
		backEndJob.setAccount(account);

		BackEndJobManager backEndJobManager = new BackEndJobManager();

		try {
			return backEndJobManager.execute(backEndJob, account.getUsr_id(), "searchBackEndCntrSealListBasic BackEndJob");
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[] { "Container Seal Inquiry - searchBackEndCntrSealListBasic" }).getMessage(), ex);
		}
	}
		
	/**
	 * EES_MNR_0254 : COMMAND01<br>
	 * BackEndJob의 실행결과에 대한 상태값을 조회합니다.<br>
	 * 
	 * @param String key
	 * @return String
     * @exception EventException
	 */
	public String searchComBackEndJobStatusBasic(String key) throws EventException{
		DBRowSet rowSet;

		try {
			rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			rowSet.next();
			Thread.sleep(1000);
			return (String) rowSet.getObject("jb_sts_flg");
		} catch (BackEndJobException e) {
			throw new EventException(e.getMessage());
		} catch (SQLException e) {
			throw new EventException(e.getMessage());
		} catch (InterruptedException e) {
			throw new EventException(e.getMessage());
		} catch (Exception e) {
			throw new EventException(e.getMessage());
		}
	}
		
	/**
	 * EES_MNR_0254 : SEARCH<br>
	 * Container Seal Count 를 조회합니다. <br>
	 * 
     * @param ContainerSealInquiryVO containerSealInquiryVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String searchBackEndCntrSealCountBasic(ContainerSealInquiryVO containerSealInquiryVO, SignOnUserAccount account) throws EventException{
		DVFactorCNTRSealInquiryCountBackEndJob backEndJob = new DVFactorCNTRSealInquiryCountBackEndJob();
		backEndJob.setJobType("searchBackEndCntrSealCountBasic");
		backEndJob.setContainerSealInquiryVO(containerSealInquiryVO);
		backEndJob.setAccount(account);

		BackEndJobManager backEndJobManager = new BackEndJobManager();

		try {
			return backEndJobManager.execute(backEndJob, account.getUsr_id(), "searchBackEndCntrSealCountBasic BackEndJob");
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[] { "Container Seal Inquiry - searchBackEndCntrSealCountBasic" }).getMessage(), ex);
		}
	}
	

}