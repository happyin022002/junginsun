/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialCargoMasterDataMgtBCImpl.java
*@FileTitle : Load Reject Reason (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.04.28 이도형
* 1.0 Creation
* -------------------------------------------------------- 
* History
* 2012.01.17 서석진 [CHM-201115272] RSO 설정및 지역 본부 hard coding 로직 수정 요청
* 처리내역 :RHQ1,RHQ2 GRID 클릭시 콤보박스형태로 조회후 선택하여 저장,수정 할수있게 UI,로직 수정
=========================================================*/
package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.basic;
 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.vo.FileVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration.SpecialCargoMasterDataMgtDBDAO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.GetLoadingPortRsoVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.MdmVslSvcLaneListVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgChemicalHistoryVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgChemHistoryFileVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgGuidanceFileVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgGuidanceVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgImdgPckInstrVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgImdgSpclProvisVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgImdgUnNoOrgRactVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgMailTampletVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgRgnShpOprPortListVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgPckCreationVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgPckReguImgVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgPckReguPkgCdVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgPckReguPkgIbcCdVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.SearchIrregularTypeCodeListVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.SearchLoadingPortRsoVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.SearchRsoComboListVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.VopScg0070VO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.RsltCdListVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgNonDgCgoKwVO;
import com.hanjin.syscommon.common.table.ScgCdVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ScgCntcPntPolVO;
import com.hanjin.syscommon.common.table.ScgCntcPntVO;
import com.hanjin.syscommon.common.table.ScgImdgAbbrVO;
import com.hanjin.syscommon.common.table.ScgImdgClssCdVO;
import com.hanjin.syscommon.common.table.ScgImdgCompGrpVO;
import com.hanjin.syscommon.common.table.ScgImdgExptQtyVO;
import com.hanjin.syscommon.common.table.ScgImdgMrnPolutVO;
import com.hanjin.syscommon.common.table.ScgImdgPckCdVO;
import com.hanjin.syscommon.common.table.ScgImdgPckGrpVO;
import com.hanjin.syscommon.common.table.ScgImdgSegrGrpDtlVO;
import com.hanjin.syscommon.common.table.ScgImdgSegrGrpVO;
import com.hanjin.syscommon.common.table.ScgImdgSegrSymVO;
import com.hanjin.syscommon.common.table.ScgImdgSpclProviVO;
import com.hanjin.syscommon.common.table.ScgImdgTnkTpVO;
import com.hanjin.syscommon.common.table.ScgLodRjctCdVO;
import com.hanjin.syscommon.common.table.ScgRgnShpOprCdVO;
import com.hanjin.syscommon.common.table.ScgPckInstrVO;
import com.hanjin.syscommon.common.table.ScgPckGasReguVO;
import com.hanjin.syscommon.common.table.ScgPckPkgVO;
import com.hanjin.syscommon.common.table.ScgPckPtbTnkVO;
import com.hanjin.syscommon.common.table.ScgPckRefVO;
import com.hanjin.syscommon.common.table.ScgPckReguPkgOrgPrxVO;
import com.hanjin.syscommon.common.table.ScgPckReguVO;
import com.hanjin.syscommon.common.table.ScgSpclPckProviVO;



/**
 * ALPS-SpecialCargoMasterDataMgt Business Logic Basic Command implementation<br>
 * - ALPS-SpecialCargoMasterDataMgt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Dohyoung Lee
 * @see VOP_SCG-0031EventResponse,SpecialCargoMasterDataMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class SpecialCargoMasterDataMgtBCImpl extends BasicCommandSupport implements SpecialCargoMasterDataMgtBC {

	// Database Access Object
	private transient SpecialCargoMasterDataMgtDBDAO dbDao = null;

	/**
	 * SpecialCargoMasterDataMgtBCImpl 객체 생성<br>
	 * SpecialCargoMasterDataMgtDBDAO를 생성한다.<br>
	 */
	public SpecialCargoMasterDataMgtBCImpl() {
		dbDao = new SpecialCargoMasterDataMgtDBDAO();
	}
	
	/**
	 * Load Reject Reason을 조회 합니다. <br>
	 * 
	 * @param scgLodRjctCdVO
	 * @return List<ScgLodRjctCdVO>
	 * @exception EventException
	 */
	public List<ScgLodRjctCdVO> searchLoadRejectReasonCodeList(ScgLodRjctCdVO scgLodRjctCdVO) throws EventException {
		try {
			return dbDao.searchLoadRejectReasonCodeList(scgLodRjctCdVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Load Reject Reason"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Load Reject Reason"}).getMessage(), ex);
        }
	}
	/**
	 * Load Reject Reason을 생성,수정,삭제 합니다. <br>
	 * 
	 * @param ScgLodRjctCdVO[] scgLodRjctCdVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageLoadRejectReasonCode(ScgLodRjctCdVO[] scgLodRjctCdVOs, SignOnUserAccount account) throws EventException{
		try {
			List<ScgLodRjctCdVO> insertVoList = new ArrayList<ScgLodRjctCdVO>();
			List<ScgLodRjctCdVO> updateVoList = new ArrayList<ScgLodRjctCdVO>();
			List<ScgLodRjctCdVO> deleteVoList = new ArrayList<ScgLodRjctCdVO>();
			
			String spclCgoCateCd = scgLodRjctCdVOs[0].getSpclCgoCateCd();	//Special Cargo Type을 가져온다.

			for ( int i=0; i<scgLodRjctCdVOs.length; i++ ) {
				if ( scgLodRjctCdVOs[i].getIbflag().equals("I")){
					scgLodRjctCdVOs[i].setDeltFlg("Y");
					if (dbDao.searchLoadRejectReasonCodeList(scgLodRjctCdVOs[i]).size() > 0) {
						scgLodRjctCdVOs[i].setSpclCgoCateCd(spclCgoCateCd);
						scgLodRjctCdVOs[i].setDeltFlg("N");
						scgLodRjctCdVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(scgLodRjctCdVOs[i]);
					}else{
						scgLodRjctCdVOs[i].setSpclCgoCateCd(spclCgoCateCd);
						scgLodRjctCdVOs[i].setDeltFlg("N");
						scgLodRjctCdVOs[i].setCreUsrId(account.getUsr_id());
						insertVoList.add(scgLodRjctCdVOs[i]);
					}
				} else if ( scgLodRjctCdVOs[i].getIbflag().equals("U")){
					scgLodRjctCdVOs[i].setSpclCgoCateCd(spclCgoCateCd);
					scgLodRjctCdVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(scgLodRjctCdVOs[i]);
				} else if ( scgLodRjctCdVOs[i].getIbflag().equals("D")){
					scgLodRjctCdVOs[i].setSpclCgoCateCd(spclCgoCateCd);
					scgLodRjctCdVOs[i].setDeltFlg("Y");
					scgLodRjctCdVOs[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(scgLodRjctCdVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {				
				dbDao.addLoadRejectReasonCode(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyLoadRejectReasonCode(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeLoadRejectReasonCode(deleteVoList);
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Load Reject Reason"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Load Reject Reason"}).getMessage(), ex);
        }
	}
	
	/**
	 * SPCL CGO RSO을 조회 합니다. <br>
	 * 
	 * @param  ScgRgnShpOprCdVO scgRgnShpOprCdVO
	 * @return List<ScgRgnShpOprCdVO>
	 * @exception EventException
	 */
	public List<ScgRgnShpOprCdVO> searchRegionalShipOperatorCodeList(ScgRgnShpOprCdVO scgRgnShpOprCdVO) throws EventException {
		try {
			return dbDao.searchRegionalShipOperatorCodeList(scgRgnShpOprCdVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO RSO"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO RSO"}).getMessage(), ex);
        }
	}
	/**
	 * SPCL CGO RSO을 생성,수정,삭제 합니다. <br>
	 * 
	 * @param scgRgnShpOprCdVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRegionalShipOperatorCode(ScgRgnShpOprCdVO[] scgRgnShpOprCdVOs, SignOnUserAccount account) throws EventException{
		try {
			List<ScgRgnShpOprCdVO> insertVoList = new ArrayList<ScgRgnShpOprCdVO>();
			List<ScgRgnShpOprCdVO> updateVoList = new ArrayList<ScgRgnShpOprCdVO>();
			List<ScgRgnShpOprCdVO> deleteVoList = new ArrayList<ScgRgnShpOprCdVO>();
			
			for ( int i=0; i<scgRgnShpOprCdVOs.length; i++ ) {
				if ( scgRgnShpOprCdVOs[i].getIbflag().equals("I")){
					scgRgnShpOprCdVOs[i].setDeltFlg("Y");
					if (dbDao.searchRegionalShipOperatorCodeList(scgRgnShpOprCdVOs[i]).size() > 0) {
						scgRgnShpOprCdVOs[i].setDeltFlg("N");
						scgRgnShpOprCdVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(scgRgnShpOprCdVOs[i]);						
					}else{
						scgRgnShpOprCdVOs[i].setDeltFlg("N");
						scgRgnShpOprCdVOs[i].setCreUsrId(account.getUsr_id());
						insertVoList.add(scgRgnShpOprCdVOs[i]);
					}
				} else if ( scgRgnShpOprCdVOs[i].getIbflag().equals("U")){
					scgRgnShpOprCdVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(scgRgnShpOprCdVOs[i]);
				} else if ( scgRgnShpOprCdVOs[i].getIbflag().equals("D")){
					scgRgnShpOprCdVOs[i].setDeltFlg("Y");
					scgRgnShpOprCdVOs[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(scgRgnShpOprCdVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addRegionalShipOperatorCode(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyRegionalShipOperatorCode(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeRegionalShipOperatorCode(deleteVoList);
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO RSO"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO RSO"}).getMessage(), ex);
        }

	}

	/**
	 * Partner's Contact Point for SPCL CGO 을 조회 합니다. <br>
	 * 
	 * @param scgCntcPntVO
	 * @return List<ScgCntcPntVO>
	 * @exception EventException
	 */
	public List<ScgCntcPntVO> searchPartnerLineContactPointList(ScgCntcPntVO scgCntcPntVO) throws EventException {
		try {
			return dbDao.searchPartnerLineContactPointList(scgCntcPntVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Partner Contact Point for SPCL CGO"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Partner Contact Point for SPCL CGO"}).getMessage(), ex);
        }

	}

	/**
	 * RSO을 조회 합니다. <br>
	 * 
	 * @return List<ScgRgnShpOprCdVO>
	 * @exception EventException
	 */
	public List<ScgRgnShpOprCdVO> searchSpclCgoRsoList() throws EventException {
		try {
			return dbDao.searchSpclCgoRsoList();
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Special Cargo RSO"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Special Cargo RSO"}).getMessage(), ex);
        }
	}

	/**
	 * Partner's Contact Point for SPCL CGO 을 생성,수정,삭제 합니다. <br>
	 * 
	 * @param  ScgCntcPntVO[]  scgCntcPntVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePartnerLineContactPoint(ScgCntcPntVO[] scgCntcPntVOs, SignOnUserAccount account) throws EventException{
		try {
			List<ScgCntcPntVO> insertVoList = new ArrayList<ScgCntcPntVO>();
			List<ScgCntcPntVO> updateVoList = new ArrayList<ScgCntcPntVO>();
			List<ScgCntcPntVO> deleteVoList = new ArrayList<ScgCntcPntVO>();
			
			for ( int i=0; i<scgCntcPntVOs.length; i++ ) {
				if ( scgCntcPntVOs[i].getIbflag().equals("I")){
					scgCntcPntVOs[i].setDeltFlg("Y");
					if (dbDao.searchPartnerLineContactPointList(scgCntcPntVOs[i]).size() > 0) {
						scgCntcPntVOs[i].setDeltFlg("N");
						scgCntcPntVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(scgCntcPntVOs[i]);
					}else{
						scgCntcPntVOs[i].setDeltFlg("N");
						scgCntcPntVOs[i].setCreUsrId(account.getUsr_id());
						insertVoList.add(scgCntcPntVOs[i]);
					}
				} else if ( scgCntcPntVOs[i].getIbflag().equals("U")){
					scgCntcPntVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(scgCntcPntVOs[i]);
				} else if ( scgCntcPntVOs[i].getIbflag().equals("D")){
					scgCntcPntVOs[i].setDeltFlg("Y");
					scgCntcPntVOs[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(scgCntcPntVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addPartnerLineContactPoint(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyPartnerLineContactPoint(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removePartnerLineContactPoint(deleteVoList);
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Partner's Contact Point for SPCL CGO"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Partner's Contact Point for SPCL CGO"}).getMessage(), ex);
        }
	}

	/**
	 * SPCL CGO Irregular Type 을 조회 합니다. <br>
	 * 
	 * @param  SearchIrregularTypeCodeListVO searchIrregularTypeCodeListVO
	 * @return List<SearchIrregularTypeCodeListVO>
	 * @exception EventException
	 */
	public List<SearchIrregularTypeCodeListVO> searchIrregularTypeCodeList(SearchIrregularTypeCodeListVO searchIrregularTypeCodeListVO) throws EventException {
		try {
			return dbDao.searchIrregularTypeCodeList(searchIrregularTypeCodeListVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO Irregular Type"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO Irregular Type"}).getMessage(), ex);
        }
	}
	/**
	 * SPCL CGO Irregular Type 을 생성,수정,삭제 합니다. <br>
	 * 
	 * @param searchIrregularTypeCodeListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageIrregularTypeCode(SearchIrregularTypeCodeListVO[] searchIrregularTypeCodeListVOs,SignOnUserAccount account) throws EventException{
		try {
			List<SearchIrregularTypeCodeListVO> insertVoList = new ArrayList<SearchIrregularTypeCodeListVO>();
			List<SearchIrregularTypeCodeListVO> updateVoList = new ArrayList<SearchIrregularTypeCodeListVO>();
			List<SearchIrregularTypeCodeListVO> deleteVoList = new ArrayList<SearchIrregularTypeCodeListVO>();
			
			for ( int i=0; i<searchIrregularTypeCodeListVOs.length; i++ ) {
				if ( searchIrregularTypeCodeListVOs[i].getIbflag().equals("I")){
					searchIrregularTypeCodeListVOs[i].setDeltFlg("Y");
					if (dbDao.searchIrregularTypeCodeList(searchIrregularTypeCodeListVOs[i]).size() > 0) {
						searchIrregularTypeCodeListVOs[i].setDeltFlg("N");
						searchIrregularTypeCodeListVOs[i].setUpdUsrId(account.getUsr_id());
						if (searchIrregularTypeCodeListVOs[i].getDgFlg().equals("1")) {
							searchIrregularTypeCodeListVOs[i].setDgFlg("Y");
						}else{
							searchIrregularTypeCodeListVOs[i].setDgFlg("N");						
						}
						if (searchIrregularTypeCodeListVOs[i].getAwkFlg().equals("1")) {
							searchIrregularTypeCodeListVOs[i].setAwkFlg("Y");
						}else{
							searchIrregularTypeCodeListVOs[i].setAwkFlg("N");						
						}
						updateVoList.add(searchIrregularTypeCodeListVOs[i]);						
					}else{
						searchIrregularTypeCodeListVOs[i].setDeltFlg("N");
						searchIrregularTypeCodeListVOs[i].setCreUsrId(account.getUsr_id());
						if (searchIrregularTypeCodeListVOs[i].getDgFlg().equals("1")) {
							searchIrregularTypeCodeListVOs[i].setDgFlg("Y");
						}else{
							searchIrregularTypeCodeListVOs[i].setDgFlg("N");						
						}
						if (searchIrregularTypeCodeListVOs[i].getAwkFlg().equals("1")) {
							searchIrregularTypeCodeListVOs[i].setAwkFlg("Y");
						}else{
							searchIrregularTypeCodeListVOs[i].setAwkFlg("N");						
						}
						insertVoList.add(searchIrregularTypeCodeListVOs[i]);
					}
				} else if ( searchIrregularTypeCodeListVOs[i].getIbflag().equals("U")){
					searchIrregularTypeCodeListVOs[i].setUpdUsrId(account.getUsr_id());
					if (searchIrregularTypeCodeListVOs[i].getDgFlg().equals("1")) {
						searchIrregularTypeCodeListVOs[i].setDgFlg("Y");
					}else{
						searchIrregularTypeCodeListVOs[i].setDgFlg("N");						
					}
					if (searchIrregularTypeCodeListVOs[i].getAwkFlg().equals("1")) {
						searchIrregularTypeCodeListVOs[i].setAwkFlg("Y");
					}else{
						searchIrregularTypeCodeListVOs[i].setAwkFlg("N");						
					}
					updateVoList.add(searchIrregularTypeCodeListVOs[i]);
				} else if ( searchIrregularTypeCodeListVOs[i].getIbflag().equals("D")){
					searchIrregularTypeCodeListVOs[i].setDeltFlg("Y");
					searchIrregularTypeCodeListVOs[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(searchIrregularTypeCodeListVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addIrregularTypeCode(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyIrregularTypeCode(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeIrregularTypeCode(deleteVoList);
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO Irregular Type"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO Irregular Type"}).getMessage(), ex);
        }
	}
	
	/**
	 * Definition of Class  을 조회 합니다. <br>
	 * 
	 * @param scgImdgClssCdVO
	 * @return List<ScgImdgClssCdVO>
	 * @exception EventException
	 */
	public List<ScgImdgClssCdVO> searchClassDefinitionList(ScgImdgClssCdVO scgImdgClssCdVO) throws EventException {
		try {
			return dbDao.searchClassDefinitionList(scgImdgClssCdVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Definition of Class"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Definition of Class"}).getMessage(), ex);
        }
	}
	/**
	 * Definition of Class  을 생성,수정,삭제 합니다. <br>
	 * 
	 * @param scgImdgClssCdVOs
	 * @param account
	 * @exception EventException
	 */
	public void manageClassDefinition(ScgImdgClssCdVO[] scgImdgClssCdVOs, SignOnUserAccount account) throws EventException{
		try {
			List<ScgImdgClssCdVO> insertVoList = new ArrayList<ScgImdgClssCdVO>();
			List<ScgImdgClssCdVO> updateVoList = new ArrayList<ScgImdgClssCdVO>();
			List<ScgImdgClssCdVO> deleteVoList = new ArrayList<ScgImdgClssCdVO>();
			
			for ( int i=0; i<scgImdgClssCdVOs.length; i++ ) {
				if ( scgImdgClssCdVOs[i].getIbflag().equals("I")){
					scgImdgClssCdVOs[i].setDeltFlg("Y");
					if (dbDao.searchClassDefinitionList(scgImdgClssCdVOs[i]).size() > 0) {
						scgImdgClssCdVOs[i].setDeltFlg("N");
						scgImdgClssCdVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(scgImdgClssCdVOs[i]);						
					}else{
						scgImdgClssCdVOs[i].setDeltFlg("N");
						scgImdgClssCdVOs[i].setCreUsrId(account.getUsr_id());
						insertVoList.add(scgImdgClssCdVOs[i]);
					}
				} else if ( scgImdgClssCdVOs[i].getIbflag().equals("U")){
					scgImdgClssCdVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(scgImdgClssCdVOs[i]);
				} else if ( scgImdgClssCdVOs[i].getIbflag().equals("D")){
					scgImdgClssCdVOs[i].setDeltFlg("Y");
					scgImdgClssCdVOs[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(scgImdgClssCdVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addClassDefinition(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyClassDefinition(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeClassDefinition(deleteVoList);
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Definition of Class"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Definition of Class"}).getMessage(), ex);
        }
	}
	
	/**
	 * Marine Pollutant 을 조회 합니다. <br>
	 * 
	 * @param  ScgImdgMrnPolutVO scgImdgMrnPolutVO
	 * @return List<ScgImdgMrnPolutVO>
	 * @exception EventException
	 */
	public List<ScgImdgMrnPolutVO> searchMarinePollutantCodeList(ScgImdgMrnPolutVO scgImdgMrnPolutVO) throws EventException {
		try {
			return dbDao.searchMarinePollutantCodeList(scgImdgMrnPolutVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Marine Pollutant"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Marine Pollutant"}).getMessage(), ex);
        }
	}
	/**
	 * Marine Pollutant 을 생성,수정,삭제 합니다. <br>
	 * 
	 * @param scgImdgMrnPolutVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageMarinePollutantCode(ScgImdgMrnPolutVO[] scgImdgMrnPolutVOs, SignOnUserAccount account) throws EventException{
		try {
			List<ScgImdgMrnPolutVO> insertVoList = new ArrayList<ScgImdgMrnPolutVO>();
			List<ScgImdgMrnPolutVO> updateVoList = new ArrayList<ScgImdgMrnPolutVO>();
			List<ScgImdgMrnPolutVO> deleteVoList = new ArrayList<ScgImdgMrnPolutVO>();

			for ( int i=0; i<scgImdgMrnPolutVOs.length; i++ ) {
				if ( scgImdgMrnPolutVOs[i].getIbflag().equals("I")){
					scgImdgMrnPolutVOs[i].setDeltFlg("Y");
					if (dbDao.searchMarinePollutantCodeList(scgImdgMrnPolutVOs[i]).size() > 0) {
						scgImdgMrnPolutVOs[i].setDeltFlg("N");
						scgImdgMrnPolutVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(scgImdgMrnPolutVOs[i]);						
					}else{
						scgImdgMrnPolutVOs[i].setDeltFlg("N");
						scgImdgMrnPolutVOs[i].setCreUsrId(account.getUsr_id());
						insertVoList.add(scgImdgMrnPolutVOs[i]);
					}
				} else if ( scgImdgMrnPolutVOs[i].getIbflag().equals("U")){
					scgImdgMrnPolutVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(scgImdgMrnPolutVOs[i]);
				} else if ( scgImdgMrnPolutVOs[i].getIbflag().equals("D")){
					scgImdgMrnPolutVOs[i].setDeltFlg("Y");
					scgImdgMrnPolutVOs[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(scgImdgMrnPolutVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addMarinePollutantCode(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyMarinePollutantCode(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeMarinePollutantCode(deleteVoList);
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Marine Pollutant"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Marine Pollutant"}).getMessage(), ex);
        }
	}	

	/**
	 * Special Provisions  을 조회 합니다. <br>
	 * 
	 * @param scgImdgPckGrpVO
	 * @return List<ScgImdgPckGrpVO>
	 * @exception EventException
	 */
	public List<ScgImdgPckGrpVO> searchPackingGroupCodeList(ScgImdgPckGrpVO scgImdgPckGrpVO) throws EventException {
		try {
			return dbDao.searchPackingGroupCodeList(scgImdgPckGrpVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Special Provisions"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Special Provisions"}).getMessage(), ex);
        }
	}
	/**
	 * Special Provisions  을 생성,수정,삭제 합니다. <br>
	 * 
	 * @param ScgImdgPckGrpVO[] scgImdgPckGrpVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePackingGroupCode(ScgImdgPckGrpVO[] scgImdgPckGrpVOs, SignOnUserAccount account) throws EventException{
		try {
			List<ScgImdgPckGrpVO> insertVoList = new ArrayList<ScgImdgPckGrpVO>();
			List<ScgImdgPckGrpVO> updateVoList = new ArrayList<ScgImdgPckGrpVO>();
			List<ScgImdgPckGrpVO> deleteVoList = new ArrayList<ScgImdgPckGrpVO>();

			for ( int i=0; i<scgImdgPckGrpVOs.length; i++ ) {
				if ( scgImdgPckGrpVOs[i].getIbflag().equals("I")){
					scgImdgPckGrpVOs[i].setCreUsrId(account.getUsr_id());
					insertVoList.add(scgImdgPckGrpVOs[i]);
				} else if ( scgImdgPckGrpVOs[i].getIbflag().equals("U")){
					scgImdgPckGrpVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(scgImdgPckGrpVOs[i]);
				} else if ( scgImdgPckGrpVOs[i].getIbflag().equals("D")){
					scgImdgPckGrpVOs[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(scgImdgPckGrpVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addPackingGroupCode(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyPackingGroupCode(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removePackingGroupCode(deleteVoList);
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Special Provisions"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Special Provisions"}).getMessage(), ex);
        }
	}	

	/**
	 * Packing Group 을 조회 합니다. <br>
	 * 
	 * @param  ScgImdgSpclProviVO scgImdgSpclProviVO
	 * @return List<ScgImdgSpclProviVO>
	 * @exception EventException
	 */
	public List<ScgImdgSpclProviVO> searchSpecialProvisionList(ScgImdgSpclProviVO scgImdgSpclProviVO) throws EventException {
		try {
			return dbDao.searchSpecialProvisionList(scgImdgSpclProviVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Packing Group"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Packing Group"}).getMessage(), ex);
        }
	}
	/**
	 * Packing Group 을 생성,수정,삭제 합니다. <br>
	 * 
	 * @param scgImdgSpclProviVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSpecialProvision(ScgImdgSpclProviVO[] scgImdgSpclProviVOs, SignOnUserAccount account) throws EventException{
		try {
			List<ScgImdgSpclProviVO> insertVoList = new ArrayList<ScgImdgSpclProviVO>();
			List<ScgImdgSpclProviVO> updateVoList = new ArrayList<ScgImdgSpclProviVO>();
			List<ScgImdgSpclProviVO> deleteVoList = new ArrayList<ScgImdgSpclProviVO>();

			for ( int i=0; i<scgImdgSpclProviVOs.length; i++ ) {
				if ( scgImdgSpclProviVOs[i].getIbflag().equals("I")){
					scgImdgSpclProviVOs[i].setDeltFlg("Y");
					if (dbDao.searchSpecialProvisionList(scgImdgSpclProviVOs[i]).size() > 0) {
						scgImdgSpclProviVOs[i].setDeltFlg("N");
						scgImdgSpclProviVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(scgImdgSpclProviVOs[i]);
					}else{					
						scgImdgSpclProviVOs[i].setDeltFlg("N");
						scgImdgSpclProviVOs[i].setCreUsrId(account.getUsr_id());
						insertVoList.add(scgImdgSpclProviVOs[i]);
					}
				} else if ( scgImdgSpclProviVOs[i].getIbflag().equals("U")){
					scgImdgSpclProviVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(scgImdgSpclProviVOs[i]);
				} else if ( scgImdgSpclProviVOs[i].getIbflag().equals("D")){
					scgImdgSpclProviVOs[i].setDeltFlg("Y");
					scgImdgSpclProviVOs[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(scgImdgSpclProviVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addSpecialProvision(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifySpecialProvision(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeSpecialProvision(deleteVoList);
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Packing Group"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Packing Group"}).getMessage(), ex);
        }
	}	
	
	/**
	 * Packaging Code 을 조회 합니다. <br>
	 * 
	 * @param  ScgImdgPckCdVO scgImdgPckCdVO
	 * @return List<ScgImdgPckCdVO>
	 * @exception EventException
	 */
	public List<ScgImdgPckCdVO> searchPackingCodeList(ScgImdgPckCdVO scgImdgPckCdVO) throws EventException {
		try {
			return dbDao.searchPackingCodeList(scgImdgPckCdVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Packing Code"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Packing Code"}).getMessage(), ex);
        }
	}
	/**
	 * Packaging Code 을 생성,수정,삭제 합니다. <br>
	 * 
	 * @param scgImdgPckCdVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePackingCode(ScgImdgPckCdVO[] scgImdgPckCdVOs, SignOnUserAccount account) throws EventException{
		try {
			List<ScgImdgPckCdVO> insertVoList = new ArrayList<ScgImdgPckCdVO>();
			List<ScgImdgPckCdVO> updateVoList = new ArrayList<ScgImdgPckCdVO>();
			List<ScgImdgPckCdVO> deleteVoList = new ArrayList<ScgImdgPckCdVO>();

			for ( int i=0; i<scgImdgPckCdVOs.length; i++ ) {
				if ( scgImdgPckCdVOs[i].getIbflag().equals("I")){
					String imdgPckTpCd = scgImdgPckCdVOs[i].getImdgPckTpCd();
					scgImdgPckCdVOs[i].setDeltFlg("Y");
					scgImdgPckCdVOs[i].setImdgPckTpCd("");
					if (dbDao.searchPackingCodeList(scgImdgPckCdVOs[i]).size() > 0) {
						scgImdgPckCdVOs[i].setImdgPckTpCd(imdgPckTpCd);
						scgImdgPckCdVOs[i].setDeltFlg("N");
						scgImdgPckCdVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(scgImdgPckCdVOs[i]);						
					}else{
						scgImdgPckCdVOs[i].setImdgPckTpCd(imdgPckTpCd);
						scgImdgPckCdVOs[i].setDeltFlg("N");
						scgImdgPckCdVOs[i].setCreUsrId(account.getUsr_id());
						insertVoList.add(scgImdgPckCdVOs[i]);
					}
				} else if ( scgImdgPckCdVOs[i].getIbflag().equals("U")){
					scgImdgPckCdVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(scgImdgPckCdVOs[i]);
				} else if ( scgImdgPckCdVOs[i].getIbflag().equals("D")){
					scgImdgPckCdVOs[i].setDeltFlg("Y");
					scgImdgPckCdVOs[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(scgImdgPckCdVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addPackingCode(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyPackingCode(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removePackingCode(deleteVoList);
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Packing Code"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Packing Code"}).getMessage(), ex);
        }
	}	

	/**
	 * IMO Type Portable Tanks을 조회 합니다. <br>
	 * 
	 * @param scgImdgTnkTpVO
	 * @return List<ScgImdgTnkTpVO>
	 * @exception EventException
	 */
	public List<ScgImdgTnkTpVO> searchIMOTankTypeCodeList(ScgImdgTnkTpVO scgImdgTnkTpVO) throws EventException {
		try {
			return dbDao.searchIMOTankTypeCodeList(scgImdgTnkTpVO);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"IMO Type Portable Tanks"}).getMessage(), ex);
        }
	}
	/**
	 * IMO Type Portable Tanks을 생성,수정,삭제 합니다. <br>
	 * 
	 * @param scgImdgTnkTpVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageIMOTankTypeCode(ScgImdgTnkTpVO[] scgImdgTnkTpVOs, SignOnUserAccount account) throws EventException{
		try {
			List<ScgImdgTnkTpVO> insertVoList = new ArrayList<ScgImdgTnkTpVO>();
			List<ScgImdgTnkTpVO> updateVoList = new ArrayList<ScgImdgTnkTpVO>();
			List<ScgImdgTnkTpVO> deleteVoList = new ArrayList<ScgImdgTnkTpVO>();

			for ( int i=0; i<scgImdgTnkTpVOs.length; i++ ) {
				if ( scgImdgTnkTpVOs[i].getIbflag().equals("I")){
					scgImdgTnkTpVOs[i].setDeltFlg("Y");
					if (dbDao.searchIMOTankTypeCodeList(scgImdgTnkTpVOs[i]).size() > 0) {
						scgImdgTnkTpVOs[i].setDeltFlg("N");
						scgImdgTnkTpVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(scgImdgTnkTpVOs[i]);						
					}else{
						scgImdgTnkTpVOs[i].setDeltFlg("N");
						scgImdgTnkTpVOs[i].setCreUsrId(account.getUsr_id());
						insertVoList.add(scgImdgTnkTpVOs[i]);
					}
				} else if ( scgImdgTnkTpVOs[i].getIbflag().equals("U")){
					scgImdgTnkTpVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(scgImdgTnkTpVOs[i]);
				} else if ( scgImdgTnkTpVOs[i].getIbflag().equals("D")){
					scgImdgTnkTpVOs[i].setDeltFlg("Y");
					scgImdgTnkTpVOs[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(scgImdgTnkTpVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addIMOTankTypeCode(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyIMOTankTypeCode(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeIMOTankTypeCode(deleteVoList);
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"IMO Type Portable Tanks"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"IMO Type Portable Tanks"}).getMessage(), ex);
        }
	}	

	/**
	 * DG Abbreviation을 조회 합니다. <br>
	 * 
	 * @param  ScgImdgAbbrVO scgImdgAbbrVO
	 * @return List<ScgImdgAbbrVO>
	 * @exception EventException
	 */
	public List<ScgImdgAbbrVO> searchDGAbbreviationCodeList(ScgImdgAbbrVO scgImdgAbbrVO) throws EventException {
		try {
			return dbDao.searchDGAbbreviationCodeList(scgImdgAbbrVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"DG Abbreviation"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"DG Abbreviation"}).getMessage(), ex);
        }
	}
	/**
	 * DG Abbreviation을 생성,수정,삭제 합니다. <br>
	 * 
	 * @param scgImdgAbbrVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDGAbbreviationCode(ScgImdgAbbrVO[] scgImdgAbbrVOs, SignOnUserAccount account) throws EventException{
		try {
			List<ScgImdgAbbrVO> insertVoList = new ArrayList<ScgImdgAbbrVO>();
			List<ScgImdgAbbrVO> updateVoList = new ArrayList<ScgImdgAbbrVO>();
			List<ScgImdgAbbrVO> deleteVoList = new ArrayList<ScgImdgAbbrVO>();

			for ( int i=0; i<scgImdgAbbrVOs.length; i++ ) {
				if ( scgImdgAbbrVOs[i].getIbflag().equals("I")){
					scgImdgAbbrVOs[i].setDeltFlg("Y");
					if (dbDao.searchDGAbbreviationCodeList(scgImdgAbbrVOs[i]).size() > 0) {
						scgImdgAbbrVOs[i].setDeltFlg("N");
						scgImdgAbbrVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(scgImdgAbbrVOs[i]);						
					}else{
						scgImdgAbbrVOs[i].setDeltFlg("N");
						scgImdgAbbrVOs[i].setCreUsrId(account.getUsr_id());
						insertVoList.add(scgImdgAbbrVOs[i]);
					}
				} else if ( scgImdgAbbrVOs[i].getIbflag().equals("U")){
					scgImdgAbbrVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(scgImdgAbbrVOs[i]);
				} else if ( scgImdgAbbrVOs[i].getIbflag().equals("D")){
					scgImdgAbbrVOs[i].setDeltFlg("Y");
					scgImdgAbbrVOs[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(scgImdgAbbrVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addDGAbbreviationCode(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyDGAbbreviationCode(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeDGAbbreviationCode(deleteVoList);
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"DG Abbreviation"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"DG Abbreviation"}).getMessage(), ex);
        }
	}	


	/**
	 * No. & Symbols in SEG Table/Mixed STWG 을 조회 합니다. <br>
	 * 
	 * @param scgImdgSegrSymVO
	 * @return List<ScgImdgSegrSymVO>
	 * @exception EventException
	 */
	public List<ScgImdgSegrSymVO> searchNumberNSymbolCodeList(ScgImdgSegrSymVO scgImdgSegrSymVO) throws EventException {
		try {
			return dbDao.searchNumberNSymbolCodeList(scgImdgSegrSymVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"No. & Symbols in SEG Table/Mixed STWG"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"No. & Symbols in SEG Table/Mixed STWG"}).getMessage(), ex);
        }
	}
	/**
	 * No. & Symbols in SEG Table/Mixed STWG 을 생성,수정,삭제 합니다. <br>
	 * 
	 * @param scgImdgSegrSymVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNumberNSymbolCode(ScgImdgSegrSymVO[] scgImdgSegrSymVOs, SignOnUserAccount account) throws EventException{
		try {
			List<ScgImdgSegrSymVO> insertVoList = new ArrayList<ScgImdgSegrSymVO>();
			List<ScgImdgSegrSymVO> updateVoList = new ArrayList<ScgImdgSegrSymVO>();
			List<ScgImdgSegrSymVO> deleteVoList = new ArrayList<ScgImdgSegrSymVO>();
			for ( int i=0; i<scgImdgSegrSymVOs.length; i++ ) {
				if ( scgImdgSegrSymVOs[i].getIbflag().equals("I")){
					scgImdgSegrSymVOs[i].setDeltFlg("Y");
					if (dbDao.searchNumberNSymbolCodeList(scgImdgSegrSymVOs[i]).size() > 0) {
						scgImdgSegrSymVOs[i].setDeltFlg("N");
						scgImdgSegrSymVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(scgImdgSegrSymVOs[i]);						
					}else{
						scgImdgSegrSymVOs[i].setDeltFlg("N");
						scgImdgSegrSymVOs[i].setCreUsrId(account.getUsr_id());
						insertVoList.add(scgImdgSegrSymVOs[i]);
					}
				} else if ( scgImdgSegrSymVOs[i].getIbflag().equals("U")){
					scgImdgSegrSymVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(scgImdgSegrSymVOs[i]);
				} else if ( scgImdgSegrSymVOs[i].getIbflag().equals("D")){
					scgImdgSegrSymVOs[i].setDeltFlg("Y");
					scgImdgSegrSymVOs[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(scgImdgSegrSymVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addNumberNSymbolCode(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyNumberNSymbolCode(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeNumberNSymbolCode(deleteVoList);
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"No. & Symbols in SEG Table/Mixed STWG"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"No. & Symbols in SEG Table/Mixed STWG"}).getMessage(), ex);
        }
	}	
	
	
	/**
	 * Compatibility Groups of Class 1을 조회 합니다. <br>
	 * 
	 * @param scgImdgCompGrpVO
	 * @return List<ScgImdgCompGrpVO>
	 * @exception EventException
	 */
	public List<ScgImdgCompGrpVO> searchCompatibilityGroupCodeList(ScgImdgCompGrpVO scgImdgCompGrpVO) throws EventException {
		try {
			return dbDao.searchCompatibilityGroupCodeList(scgImdgCompGrpVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Compatibility Groups of Class"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Compatibility Groups of Class"}).getMessage(), ex);
        }
	}
	/**
	 * Compatibility Groups of Class 1을 생성,수정,삭제 합니다. <br>
	 * 
	 * @param scgImdgCompGrpVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCompatibilityGroupCode(ScgImdgCompGrpVO[] scgImdgCompGrpVOs, SignOnUserAccount account) throws EventException{
		try {
			List<ScgImdgCompGrpVO> insertVoList = new ArrayList<ScgImdgCompGrpVO>();
			List<ScgImdgCompGrpVO> updateVoList = new ArrayList<ScgImdgCompGrpVO>();
			List<ScgImdgCompGrpVO> deleteVoList = new ArrayList<ScgImdgCompGrpVO>();

			for ( int i=0; i<scgImdgCompGrpVOs.length; i++ ) {
				if ( scgImdgCompGrpVOs[i].getIbflag().equals("I")){
					scgImdgCompGrpVOs[i].setDeltFlg("Y");
					if (dbDao.searchCompatibilityGroupCodeList(scgImdgCompGrpVOs[i]).size() > 0) {
						scgImdgCompGrpVOs[i].setDeltFlg("N");
						scgImdgCompGrpVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(scgImdgCompGrpVOs[i]);
					}else{
						scgImdgCompGrpVOs[i].setDeltFlg("N");
						scgImdgCompGrpVOs[i].setCreUsrId(account.getUsr_id());
						insertVoList.add(scgImdgCompGrpVOs[i]);
					}
				} else if ( scgImdgCompGrpVOs[i].getIbflag().equals("U")){
					scgImdgCompGrpVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(scgImdgCompGrpVOs[i]);
				} else if ( scgImdgCompGrpVOs[i].getIbflag().equals("D")){
					scgImdgCompGrpVOs[i].setDeltFlg("Y");
					scgImdgCompGrpVOs[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(scgImdgCompGrpVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addCompatibilityGroupCode(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyCompatibilityGroupCode(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeCompatibilityGroupCode(deleteVoList);
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Compatibility Groups of Class"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Compatibility Groups of Class"}).getMessage(), ex);
        }
	}	
	
	
	/**
	 * Excepted Quantities을 조회 합니다. <br>
	 * 
	 * @param  ScgImdgExptQtyVO scgImdgExptQtyVO
	 * @return List<ScgImdgExptQtyVO>
	 * @exception EventException
	 */
	public List<ScgImdgExptQtyVO> searchExceptedQuantityCodeList(ScgImdgExptQtyVO scgImdgExptQtyVO) throws EventException {
		try {
			return dbDao.searchExceptedQuantityCodeList(scgImdgExptQtyVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Excepted Quantities"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Excepted Quantities"}).getMessage(), ex);
        }
	}
	/**
	 * Excepted Quantities을 생성,수정,삭제 합니다. <br>
	 * 
	 * @param  ScgImdgExptQtyVO[] scgImdgExptQtyVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageExceptedQuantityCode(ScgImdgExptQtyVO[] scgImdgExptQtyVOs, SignOnUserAccount account) throws EventException{
		try {
			List<ScgImdgExptQtyVO> insertVoList = new ArrayList<ScgImdgExptQtyVO>();
			List<ScgImdgExptQtyVO> updateVoList = new ArrayList<ScgImdgExptQtyVO>();
			List<ScgImdgExptQtyVO> deleteVoList = new ArrayList<ScgImdgExptQtyVO>();

			for ( int i=0; i<scgImdgExptQtyVOs.length; i++ ) {
				if ( scgImdgExptQtyVOs[i].getIbflag().equals("I")){
					scgImdgExptQtyVOs[i].setCreUsrId(account.getUsr_id());
					insertVoList.add(scgImdgExptQtyVOs[i]);
				} else if ( scgImdgExptQtyVOs[i].getIbflag().equals("U")){
					scgImdgExptQtyVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(scgImdgExptQtyVOs[i]);
				} else if ( scgImdgExptQtyVOs[i].getIbflag().equals("D")){
					scgImdgExptQtyVOs[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(scgImdgExptQtyVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addExceptedQuantityCode(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyExceptedQuantityCode(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeExceptedQuantityCode(deleteVoList);
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Excepted Quantities"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Excepted Quantities"}).getMessage(), ex);
        }
	}	
	
	/**
	 * Segregation Groups 을 조회 합니다. <br>
	 * 
	 * @param ScgImdgSegrGrpVO scgImdgSegrGrpVO
	 * @param ScgImdgSegrGrpDtlVO scgImdgSegrGrpDtlVO 
	 * @param FormCommand searchCmd
	 * @return VopScg0070VO
	 * @exception EventException
	 */
	public VopScg0070VO searchSegregationGroupList(ScgImdgSegrGrpVO scgImdgSegrGrpVO, ScgImdgSegrGrpDtlVO scgImdgSegrGrpDtlVO, FormCommand searchCmd) throws EventException {
		VopScg0070VO vopScg0070VO = new VopScg0070VO();
		
		try {
			
			if (searchCmd.isCommand(FormCommand.SEARCH01)) {
				vopScg0070VO.setScgImdgSegrGrpVOL(dbDao.searchSegregationGroupList());
			} else if (searchCmd.isCommand(FormCommand.SEARCH02)) {
				vopScg0070VO.setScgImdgSegrGrpDtlVOL(dbDao.searchSegregationGroupDtlList(scgImdgSegrGrpVO));
			} else if (searchCmd.isCommand(FormCommand.SEARCH03)) {
				vopScg0070VO.setScgImdgSegrGrpDtlVOL(dbDao.searchScgImdgUnNo(scgImdgSegrGrpDtlVO));
			}		
			
			return vopScg0070VO;
			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Segregation Groups"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Segregation Groups"}).getMessage(), ex);
        }
	}
	
	/**
	 * Segregation Groups 을 생성, 수정, 삭제합니다. <br>
	 * 
	 * @param vopScg0070VO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSegregationGroup(VopScg0070VO vopScg0070VO, SignOnUserAccount account) throws EventException{
		try {
			ScgImdgSegrGrpVO[] scgImdgSegrGrpVOs = vopScg0070VO.getScgImdgSegrGrpVOS();
			ScgImdgSegrGrpDtlVO[] scgImdgSegrGrpDtlVOs = vopScg0070VO.getScgImdgSegrGrpDtlVOS();
			
			//Segregation Group 저장
			if(scgImdgSegrGrpVOs != null) {
			
				List<ScgImdgSegrGrpVO> insertVoList1 = new ArrayList<ScgImdgSegrGrpVO>();
				List<ScgImdgSegrGrpVO> updateVoList1 = new ArrayList<ScgImdgSegrGrpVO>();
				List<ScgImdgSegrGrpVO> deleteVoList1 = new ArrayList<ScgImdgSegrGrpVO>();
				
				List<ScgImdgSegrGrpDtlVO> deleteVoSubList1 = new ArrayList<ScgImdgSegrGrpDtlVO>();
				ScgImdgSegrGrpDtlVO scgImdgSegrGrpVO = null;
	
				for ( int i=0; i<scgImdgSegrGrpVOs.length; i++ ) {
					if ( scgImdgSegrGrpVOs[i].getIbflag().equals("I")) {
						scgImdgSegrGrpVOs[i].setCreUsrId(account.getUsr_id());
						scgImdgSegrGrpVOs[i].setUpdUsrId(account.getUsr_id());
						insertVoList1.add(scgImdgSegrGrpVOs[i]);
					} else if ( scgImdgSegrGrpVOs[i].getIbflag().equals("U")) {
						scgImdgSegrGrpVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList1.add(scgImdgSegrGrpVOs[i]);
					} else if ( scgImdgSegrGrpVOs[i].getIbflag().equals("D")) {
						deleteVoList1.add(scgImdgSegrGrpVOs[i]);
						
						scgImdgSegrGrpVO = new ScgImdgSegrGrpDtlVO();
						scgImdgSegrGrpVO.setImdgSegrGrpNo(scgImdgSegrGrpVOs[i].getImdgSegrGrpNo());
						scgImdgSegrGrpVO.setImdgUnNo("");

						deleteVoSubList1.add(scgImdgSegrGrpVO);
					}
				}
				
				if ( deleteVoSubList1.size() > 0 ) {
					dbDao.removeSegregationGroupDtl(deleteVoSubList1);
				}
				
				if ( deleteVoList1.size() > 0 ) {
					dbDao.removeSegregationGroup(deleteVoList1);
				}
				
				if ( insertVoList1.size() > 0 ) {
					dbDao.addSegregationGroup(insertVoList1);
				}
				
				if ( updateVoList1.size() > 0 ) {
					dbDao.modifySegregationGroup(updateVoList1);
				}
				
			}
			
			//Heavy metals and their salts 저장
			if(scgImdgSegrGrpDtlVOs != null) {
				List<ScgImdgSegrGrpDtlVO> insertVoList2 = new ArrayList<ScgImdgSegrGrpDtlVO>();
				List<ScgImdgSegrGrpDtlVO> updateVoList2 = new ArrayList<ScgImdgSegrGrpDtlVO>();
				List<ScgImdgSegrGrpDtlVO> deleteVoList2 = new ArrayList<ScgImdgSegrGrpDtlVO>();
				
				for ( int i=0; i<scgImdgSegrGrpDtlVOs.length; i++ ) {
					if ( scgImdgSegrGrpDtlVOs[i].getIbflag().equals("I")) {
						scgImdgSegrGrpDtlVOs[i].setCreUsrId(account.getUsr_id());
						scgImdgSegrGrpDtlVOs[i].setUpdUsrId(account.getUsr_id());
						insertVoList2.add(scgImdgSegrGrpDtlVOs[i]);
					} else if ( scgImdgSegrGrpDtlVOs[i].getIbflag().equals("U")) {
						scgImdgSegrGrpDtlVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList2.add(scgImdgSegrGrpDtlVOs[i]);
					} else if ( scgImdgSegrGrpDtlVOs[i].getIbflag().equals("D")) {
						deleteVoList2.add(scgImdgSegrGrpDtlVOs[i]);
					}
				}
				
				if ( deleteVoList2.size() > 0 ) {
					dbDao.removeSegregationGroupDtl(deleteVoList2);
				}
				
				if ( insertVoList2.size() > 0 ) {
					dbDao.addSegregationGroupDtl(insertVoList2);
				}
				
				if ( updateVoList2.size() > 0 ) {
					dbDao.modifySegregationGroupDtl(updateVoList2);
				}
			}
			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Segregation Groups"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Segregation Groups"}).getMessage(), ex);
        }
	}
	
	/**
	 * VOP_SCG-0033 : 조회<br>
	 * Loading Port for RSO 를 조회한다.
	 * 
	 * @param SearchRsoComboListVO searchRsoComboListVO
	 * @return List<SearchLoadingPortRsoVO>
	 * @exception EventException
	 */
	public List<SearchLoadingPortRsoVO> searchLoadingPortRSOList(
			SearchRsoComboListVO  searchRsoComboListVO)
			throws EventException {
		try {
			return dbDao.searchLoadingPortRSOList(searchRsoComboListVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Loading Port for RSO"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Loading Port for RSO"}).getMessage(), ex);
        }
 
	}
  	/**
     *  Loading Port for RSO 조회.
     *  
     * @return List<SearchLoadingPortRsoVO>
     * @exception EventException
  	 */
	public List<SearchRsoComboListVO> searchRsoList( ) throws EventException {
		try {
			return dbDao.searchRsoList(  );
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Loading Port for RSO"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Loading Port for RSO"}).getMessage(), ex);
        }
	}
	/**
	 *  Loading Port for RSO 저장한다.
	 * 
	 * @param ScgRgnShpOprPortListVO[] scgRgnShpOprPortListVOs
	 * @param  SignOnUserAccount signOnUserAccount
	 * @exception EventException
	 */
	public void manageLoadingPortRSO(ScgRgnShpOprPortListVO[] scgRgnShpOprPortListVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		try {
			List<ScgRgnShpOprPortListVO> insertVoList = new ArrayList<ScgRgnShpOprPortListVO>();
			List<ScgRgnShpOprPortListVO> updateVoList = new ArrayList<ScgRgnShpOprPortListVO>();
			List<ScgRgnShpOprPortListVO> deleteVoList = new ArrayList<ScgRgnShpOprPortListVO>();

			for ( int i=0; i<scgRgnShpOprPortListVOs.length; i++ ) {
				 
				if ( scgRgnShpOprPortListVOs[i].getIbflag().equals("I")){
				    scgRgnShpOprPortListVOs[i].setCreUsrId(signOnUserAccount.getUsr_id());
				    scgRgnShpOprPortListVOs[i].setUpdUsrId(signOnUserAccount.getUsr_id());
					List<ScgRgnShpOprCdVO> scgRgnShpOprCdVO = 
						 dbDao.searchScgRgnShpOprCd(scgRgnShpOprPortListVOs[i].getLocCd(), scgRgnShpOprPortListVOs[i].getRgnShpOprCd());
					if(  scgRgnShpOprCdVO.size() > 0  ){
					    scgRgnShpOprPortListVOs[i].setDeltFlg("N");							
					    scgRgnShpOprPortListVOs[i].setUpdUsrId(signOnUserAccount.getUsr_id());
					    scgRgnShpOprPortListVOs[i].setKeyLocCd( scgRgnShpOprPortListVOs[i].getLocCd() );	
					    scgRgnShpOprPortListVOs[i].setKeyRgnShpOprCd( scgRgnShpOprPortListVOs[i].getRgnShpOprCd()  );
						 
						updateVoList.add(scgRgnShpOprPortListVOs[i]);
					}else{
						insertVoList.add(scgRgnShpOprPortListVOs[i]);	
					}
					 
				} else if ( scgRgnShpOprPortListVOs[i].getIbflag().equals("U")){
				    scgRgnShpOprPortListVOs[i].setDeltFlg("N");							
				    scgRgnShpOprPortListVOs[i].setUpdUsrId(signOnUserAccount.getUsr_id());
					updateVoList.add(scgRgnShpOprPortListVOs[i]);
				} else if ( scgRgnShpOprPortListVOs[i].getIbflag().equals("D")){
				    scgRgnShpOprPortListVOs[i].setDeltFlg("Y");					
				    scgRgnShpOprPortListVOs[i].setUpdUsrId(signOnUserAccount.getUsr_id());
					deleteVoList.add(scgRgnShpOprPortListVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addLoadingPortRso(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyLoadingPortRso(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeLoadingPortRso(deleteVoList);
			}
			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Loading Port for RSO"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Loading Port for RSO"}).getMessage(), ex);
        }
	}
  	/**
	 * Loading Port for RSO의  Location Code 조회 <br>
	 * 
	 * @param String locCd
	 * @return List<GetLoadingPortRsoVO>
	 * @throws EventException
	 */
	public List<GetLoadingPortRsoVO> searchLoadingPortRSO(String locCd)
			throws EventException {
		try {
			return dbDao.searchLoadingPortRSO(locCd);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Location Code"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Location Code"}).getMessage(), ex);
        }
	}
	/**
	 * Target Lane for SPCL CGO APVL을 조회한다.<br>
	 * 
	 * @param  MdmVslSvcLaneListVO mdmVslSvcLaneListVO
	 * @return List<MdmVslSvcLaneListVO>
	 * @exception EventException
	 */

	public List<MdmVslSvcLaneListVO> searchApprovalTargetLaneList(
			MdmVslSvcLaneListVO mdmVslSvcLaneListVO) throws EventException {
		try {
			return dbDao.searchApprovalTargetLaneList(mdmVslSvcLaneListVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Target Lane for SPCL CGO APVL"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Target Lane for SPCL CGO APVL"}).getMessage(), ex);
        }
	}
	/**
	 * Target Lane for SPCL CGO APVL  수정한다.<br>
	 * 
	 * @param  MdmVslSvcLaneListVO[]  mdmVslSvcLaneListVOs 
	 * @param  SignOnUserAccount signOnUserAccount
	 * @throws DAOException
	 */
	public void manageApprovalTargetLane( MdmVslSvcLaneListVO[]  mdmVslSvcLaneListVOs, SignOnUserAccount signOnUserAccount) throws EventException{
 
		try {
			List<MdmVslSvcLaneListVO> insertVoList = new ArrayList<MdmVslSvcLaneListVO>();
			List<MdmVslSvcLaneListVO> updateVoList = new ArrayList<MdmVslSvcLaneListVO>();
			List<MdmVslSvcLaneListVO> deleteVoList = new ArrayList<MdmVslSvcLaneListVO>();

			for ( int i=0; i<mdmVslSvcLaneListVOs.length; i++ ) {
				mdmVslSvcLaneListVOs[i].setUpdUsrId(signOnUserAccount.getUsr_id());				
				if ( mdmVslSvcLaneListVOs[i].getIbflag().equals("I")){
 					mdmVslSvcLaneListVOs[i].setUpdUsrId(signOnUserAccount.getUsr_id());
					mdmVslSvcLaneListVOs[i].setSpclCgoRqstTgtLaneFlg("Y");		
 
					insertVoList.add(mdmVslSvcLaneListVOs[i]); 
				} else if ( mdmVslSvcLaneListVOs[i].getIbflag().equals("U")){
					mdmVslSvcLaneListVOs[i].setSpclCgoRqstTgtLaneFlg("Y");							
					updateVoList.add(mdmVslSvcLaneListVOs[i]);
				} else if ( mdmVslSvcLaneListVOs[i].getIbflag().equals("D")){
					mdmVslSvcLaneListVOs[i].setSpclCgoRqstTgtLaneFlg( "N");					
					deleteVoList.add(mdmVslSvcLaneListVOs[i]);
				} 
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.modifyApprovalTargetLane(insertVoList);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyApprovalTargetLane(updateVoList);
			}			
			if ( deleteVoList.size() > 0 ) {
				dbDao.modifyApprovalTargetLane(deleteVoList);
			}
			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Target Lane for SPCL CGO APVL"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Target Lane for SPCL CGO APVL"}).getMessage(), ex);
        }
	}

	/**
	 * Packing Instructions/Provisions 을 조회 합니다. <br>
	 * 
	 * @param  String imdgPckInstrCd
	 * @param  String imdgPckInstrSeq
	 * @return List<ScgImdgPckInstrVO>
	 * @exception EventException
	 */
	public List<ScgImdgPckInstrVO> searchPackingInstructionList(String imdgPckInstrCd, String imdgPckInstrSeq) throws EventException {
		try {
			return dbDao.searchPackingInstructionList(imdgPckInstrCd, imdgPckInstrSeq);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Packing Instructions/Provisions"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Packing Instructions/Provisions"}).getMessage(), ex);
        }
	}

	/**
	 * Packing Instructions/Provisions 을 생성, 수정, 삭제 합니다. <br>
	 * 
	 * @param ScgImdgPckInstrVO[] scgImdgPckInstrVOs
	 * @param keys
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePackingInstruction(ScgImdgPckInstrVO[] scgImdgPckInstrVOs, List<String> keys, SignOnUserAccount account) throws EventException{
		try {
			//FILE UPLOAD KEY값
			Iterator<String> keyArr = null;			
			if(keys != null) keyArr = keys.iterator();

			List<ScgImdgPckInstrVO> insertVoList = new ArrayList<ScgImdgPckInstrVO>();
			List<ScgImdgPckInstrVO> updateVoList = new ArrayList<ScgImdgPckInstrVO>();
			List<ScgImdgPckInstrVO> deleteVoList = new ArrayList<ScgImdgPckInstrVO>();

			for ( int i=0; i<scgImdgPckInstrVOs.length; i++ ) {
				//FILE UPLOAD KEY값 SETTING하기
				if(keyArr != null) {
					if("Y".equals(scgImdgPckInstrVOs[i].getFileSetYn()) && keyArr.hasNext()) 
						scgImdgPckInstrVOs[i].setFileSavId(keyArr.next());	 
				}
				
				if ( scgImdgPckInstrVOs[i].getIbflag().equals("I")){
					scgImdgPckInstrVOs[i].setCreUsrId(account.getUsr_id());
					scgImdgPckInstrVOs[i].setUpdUsrId(account.getUsr_id());
					
					insertVoList.add(scgImdgPckInstrVOs[i]); 
				} else if ( scgImdgPckInstrVOs[i].getIbflag().equals("U")){		
					scgImdgPckInstrVOs[i].setUpdUsrId(account.getUsr_id());
					
					updateVoList.add(scgImdgPckInstrVOs[i]);
				} else if ( scgImdgPckInstrVOs[i].getIbflag().equals("D")){
					scgImdgPckInstrVOs[i].setUpdUsrId(account.getUsr_id());
					
					deleteVoList.add(scgImdgPckInstrVOs[i]);
				}
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removePackingInstruction(deleteVoList);
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addPackingInstruction(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyPackingInstruction(updateVoList);
			}
			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Packing Instructions/Provisions"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Packing Instructions/Provisions"}).getMessage(), ex);
        }
	}
    /**
     * Organic Peroxides & Self-Reactive Substances 정보를  조회합니다. <br>
     * 
     * @param  String sImdgUnNo
	 * @return List<ScgImdgUnNoOrgRactVO>
     * @exception EventException
     */
    public List<ScgImdgUnNoOrgRactVO> searchOrganicPeroxideCodeList(String sImdgUnNo)
            throws EventException {
        try {
            return dbDao.searchOrganicPeroxideCodeList(sImdgUnNo);
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler(de).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Packing Instructions/Provisions"}).getMessage(), ex);
        }
    }
    /**
     *  [Special Provisions for Segregation (Creation)]을 [조회 Retrieve] 합니다.<br>
     * 
     * @param  String imdgSpclProviNo
     * @return List<ScgImdgSpclProvisVO>
     * @exception EventException
     */       
    public List<ScgImdgSpclProvisVO> searchSpecialProvisionSegregationList(String imdgSpclProviNo) throws EventException {
        try {
            return dbDao.searchSpecialProvisionSegregationList(imdgSpclProviNo);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Special Provisions for Segregation"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Special Provisions for Segregation"}).getMessage(), ex);
        }
    }
  
    /**
     * [Special Provisions for Segregation (Creation) SubsidiaryRisks]을 [조회 Retrieve] 합니다.<br>
     * 
     * @param  String sImdgUnNo
     * @param  String sImdgUnNoSeq
     * @throws EventException
     * @return List<ScgImdgSpclProvisVO>
     * @author jang kang cheol
     */
    public List<ScgImdgSpclProvisVO> searchSubsidiaryRisks(String sImdgUnNo, String sImdgUnNoSeq) throws EventException {
        try {
            return dbDao.searchSubsidiaryRisks(sImdgUnNo, sImdgUnNoSeq);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Special Provisions for Segregation"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Special Provisions for Segregation"}).getMessage(), ex);
        }
    }
    
    /**
	 * Setup mail contents for SPCL CGO application 을 조회 합니다. <br>
	 * 
	 * @param scgMailTampletVO
	 * @return List<ScgMailTampletVO>
	 * @exception EventException
	 */
	public List<ScgMailTampletVO> searchSCGMailTamplet(ScgMailTampletVO scgMailTampletVO) throws EventException {
		try {
			return dbDao.searchSCGMailTamplet(scgMailTampletVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Setup mail contents for SPCL CGO application"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Setup mail contents for SPCL CGO application"}).getMessage(), ex);
		}
	}
	
	/**
	 * Setup mail contents for SPCL CGO application의 수정내용을 저장 합니다. <br>
	 * 
	 * @param scgMailTampletVOs
	 * @param account
	 * @exception EventException
	 */
	public void manageSCGMailTamplet(ScgMailTampletVO[] scgMailTampletVOs, SignOnUserAccount account) throws EventException{
		try {
			
			List<ScgMailTampletVO> insertVoList = new ArrayList<ScgMailTampletVO>();
			List<ScgMailTampletVO> updateVoList = new ArrayList<ScgMailTampletVO>();
			
			for ( int i=0; i<scgMailTampletVOs.length; i++ ) {
				if ( scgMailTampletVOs[i].getIbflag().equals("I")){
					scgMailTampletVOs[i].setCreUsrId(account.getUsr_id());
					scgMailTampletVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(scgMailTampletVOs[i]);
				} else if ( scgMailTampletVOs[i].getIbflag().equals("U")){
					scgMailTampletVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(scgMailTampletVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addSCGMailTampletS(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifySCGMailTampletS(updateVoList);
			}
			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Setup mail contents for SPCL CGO application"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Setup mail contents for SPCL CGO application"}).getMessage(), ex);
		}
	}
	
	/**
	 *  SPCL CGO RSO - CREATION 에서 RgnShpOprRhqCode 를 구한다. <br>
	 * 
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchRHQOfficeList() throws EventException {
		try {
			return dbDao.searchRHQOfficeList();
		} catch (DAOException ex) {
			 log.error("err " + ex.toString(), ex);
	         throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO RSO"}).getMessage(), ex);
		} catch (Exception ex) {
			 log.error("err " + ex.toString(), ex);
	         throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO RSO"}).getMessage(), ex);
		} 
	}



	/**
	 * VOP_SCG_0080  : Retrieve <br>
	 * Special Cargo Guidance 화면의 최 상단 내용을 조회 합니다. <br>
	 * 
	 * @param scgGuidanceVO
	 * @return List<ScgGuidanceVO>
	 * @exception EventException
	 */
	public List<ScgGuidanceVO> searchScgGuidMsg(ScgGuidanceVO scgGuidanceVO) throws EventException{
		try {
			return dbDao.searchScgGuidMsg(scgGuidanceVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Special Provisions for Segregation"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Special Provisions for Segregation"}).getMessage(), ex);
        }
	}
	
	
	/**
	 * Special Cargo Guidance 상단 화면정보를 생성,수정 합니다. <br>
	 * 
	 * @param scgGuidanceVOs
	 * @param SignOnUserAccount account
	 * @param String iuFlag
	 * @exception EventException
	 */
	public void manageScgGuidMsg(ScgGuidanceVO[] scgGuidanceVOs, SignOnUserAccount account, String iuFlag) throws EventException{
		try {
			List<ScgGuidanceVO> insertVoList = new ArrayList<ScgGuidanceVO>();
			List<ScgGuidanceVO> updateVoList = new ArrayList<ScgGuidanceVO>();
			if (scgGuidanceVOs != null) {
				if (iuFlag.equals("I")){
					scgGuidanceVOs[0].setCreUsrId(account.getUsr_id());
					scgGuidanceVOs[0].setUpdUsrId(account.getUsr_id());
					insertVoList.add(scgGuidanceVOs[0]);
				} else if (iuFlag.equals("U")){
					scgGuidanceVOs[0].setUpdUsrId(account.getUsr_id());
					updateVoList.add(scgGuidanceVOs[0]);
				}
				
				if ( insertVoList.size() > 0 ) {
					dbDao.addScgGuidMsg(insertVoList);
				}
				
				if ( updateVoList.size() > 0 ) {
					dbDao.modifyScgGuidMsg(updateVoList);
				}
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO RSO"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO RSO"}).getMessage(), ex);
        }

	}
	
	 
	/**
	 * Special Cargo Guidance 중앙 상세 화면정보를 생성, 삭제 합니다. <br>
	 * 
	 * @param scgGuidanceVOs
	 * @param scgGuidanceFileVOs
	 * @param strKeys
	 * @param Keys
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageScgGuidDtl(ScgGuidanceVO[] scgGuidanceVOs, ScgGuidanceFileVO[] scgGuidanceFileVOs, String[] strKeys, List<String> Keys, SignOnUserAccount account) throws EventException{
			//상세정보
			List<ScgGuidanceVO> insertVoList = null;
			List<ScgGuidanceVO> updateVoList = null;
			List<ScgGuidanceVO> deleteVoList = null;			
			//첨부파일
			List<ScgGuidanceFileVO> insertFileVoList = null;
			List<ScgGuidanceFileVO> deleteFileVoList = null;
			//FILE UPLOAD KEY값
			Iterator<String> keyArr = null;			
			if(Keys != null) keyArr = Keys.iterator();
		try {
			insertVoList = new ArrayList<ScgGuidanceVO>();
			updateVoList = new ArrayList<ScgGuidanceVO>();
			deleteVoList = new ArrayList<ScgGuidanceVO>();

			//상세정보 - 등록, 수정, 삭제
			if (scgGuidanceVOs != null) {
				for ( int i=0; i<scgGuidanceVOs.length; i++ ) {
					if ( scgGuidanceVOs[i].getIudFlg().equals("I")){
						scgGuidanceVOs[i].setCreUsrId(account.getUsr_id());
						scgGuidanceVOs[i].setUpdUsrId(account.getUsr_id());
						
						String searchScgGuidMaxSeq = dbDao.searchScgGuidMaxSeq();
						scgGuidanceVOs[i].setSpclCgoGuidSeq(searchScgGuidMaxSeq);
						
						insertVoList.add(scgGuidanceVOs[i]);
					} else if ( scgGuidanceVOs[i].getIudFlg().equals("U")){
						scgGuidanceVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(scgGuidanceVOs[i]);
					} else if ( scgGuidanceVOs[i].getIudFlg().equals("D")){
						deleteVoList.add(scgGuidanceVOs[i]);
					}
				}
				
				if ( insertVoList.size() > 0 ) {
					dbDao.addScgGuidDtl(insertVoList);
				}				
				if ( updateVoList.size() > 0 ) {
					dbDao.modifyScgGuidDtl(updateVoList);
				}
				if ( deleteVoList.size() > 0 ) {
					dbDao.removeScgGuidDtl(deleteVoList);
				}
			}
			
			//첨부파일  -등록, 수정, 삭제
			int	iFileSaveIdLen						= 0;
			if(strKeys != null)	iFileSaveIdLen		= strKeys.length;
			int	iFileSaveDownIdx					= iFileSaveIdLen - 1;

			insertFileVoList = new ArrayList<ScgGuidanceFileVO>();
			deleteFileVoList = new ArrayList<ScgGuidanceFileVO>();
	
			if (scgGuidanceFileVOs != null) {
				for(int j=0; j < scgGuidanceFileVOs.length; j++){
					if (scgGuidanceFileVOs[j].getIudFlg().equals("I")){
						if(keyArr != null) {
							//신규 데이터인경우에만 FILE_SAVE_ID 넣기
							if(strKeys != null && iFileSaveDownIdx >=0){
								scgGuidanceFileVOs[j].setCreUsrId(account.getUsr_id());
								scgGuidanceFileVOs[j].setUpdUsrId(account.getUsr_id());
								scgGuidanceFileVOs[j].setFileSavId(strKeys[iFileSaveDownIdx--]);
								insertFileVoList.add(scgGuidanceFileVOs[j]);
							}
						}
					} else if ( scgGuidanceFileVOs[j].getIudFlg().equals("D")){
						deleteFileVoList.add(scgGuidanceFileVOs[j]);
					}
				}

				if ( insertFileVoList.size() > 0 ) {
					dbDao.addScgGuidDtlFile(insertFileVoList);
				}
				if ( deleteFileVoList.size() > 0 ) {
					dbDao.removeScgGuidDtlFile(deleteFileVoList);
				}
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Special Cargo Guidanace"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Special Cargo Guidanace"}).getMessage(), ex);
        }
	}

	/**
	 * VOP_SCG_0080  : Retrieve <br>
	 * Special Cargo Guidance 화면의 중앙 상세 화면정보를 조회 합니다. <br>
	 * 
	 * @param scgGuidanceVO
	 * @return List<ScgGuidanceVO>
	 * @exception EventException
	 */
	public List<ScgGuidanceVO> searchScgGuidDtl(ScgGuidanceVO scgGuidanceVO) throws EventException{
		try {
			return dbDao.searchScgGuidDtl(scgGuidanceVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Special Provisions for Segregation"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Special Provisions for Segregation"}).getMessage(), ex);
        }
	}

	/**
	 * VOP_SCG_0080  : Retrieve <br>
	 * Special Cargo Guidance 화면의 첨부파일 정보를 조회 합니다. <br>
	 * 
	 * @param scgGuidanceVO
	 * @return List<ScgGuidanceVO>
	 * @exception EventException
	 */
	public List<ScgGuidanceVO> searchScgGuidDtlFile(ScgGuidanceVO scgGuidanceVO) throws EventException{
		try {
			return dbDao.searchScgGuidDtlFile(scgGuidanceVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Special Provisions for Segregation"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Special Provisions for Segregation"}).getMessage(), ex);
        }
	}
	
	/**
	 * VOP_SCG_0105 : OPEN <br>
	 * Proper IBC code
	 * 
	 * @param RsltCdListVO rsltCdListVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchComCodeDescList(RsltCdListVO rsltCdListVO) throws EventException {
		try {
			return dbDao.searchComCodeDescList(rsltCdListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}	
	}
	
	/**
	 * VOP_SCG_0103 : Retrieve <br>
	 * Pack.Instruct.Code
	 * 
	 * @param ScgPckInstrVO scgPckInstrVO
	 * @return List<ScgPckInstrVO>
	 * @exception EventException
	 */
	public List<ScgPckInstrVO> searchPackingInstructionCode(ScgPckInstrVO scgPckInstrVO) throws EventException {
		try {
			return dbDao.searchPackingInstructionCode(scgPckInstrVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * VOP_SCG_0103 : SAVE <br>
	 * Pack.Instruct.Code
	 * 
	 * @param ScgPckInstrVO scgPckInstrVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePackingInstructionCode(ScgPckInstrVO scgPckInstrVO, SignOnUserAccount account) throws EventException{
		try {		
			List<ScgPckInstrVO> insertVoList = new ArrayList<ScgPckInstrVO>();
			List<ScgPckInstrVO> updateVoList = new ArrayList<ScgPckInstrVO>();
			List<ScgPckInstrVO> deleteVoList = new ArrayList<ScgPckInstrVO>();			
 
			if(scgPckInstrVO != null){
				log.info(scgPckInstrVO);				
				if (scgPckInstrVO.getIbflag().equals("I")){			
					scgPckInstrVO.setCreUsrId(account.getUsr_id());
					scgPckInstrVO.setUpdUsrId(account.getUsr_id());
					insertVoList.add(scgPckInstrVO);
				}else if (scgPckInstrVO.getIbflag().equals("U")){
					scgPckInstrVO.setUpdUsrId(account.getUsr_id());
					updateVoList.add(scgPckInstrVO);
				}else if (scgPckInstrVO.getIbflag().equals("D")){
					scgPckInstrVO.setDeltFlg("Y");
					scgPckInstrVO.setUpdUsrId(account.getUsr_id());
					deleteVoList.add(scgPckInstrVO);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addPackingInstructionCode(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyPackingInstructionCode(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.modifyPackingInstructionCode(deleteVoList);
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"IBC Code"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"IBC Code"}).getMessage(), ex);
        }
	}
	
	/**
	 * IBC Code for Organic peroxide  을 조회 합니다. <br>
	 * 
	 * @param ScgPckReguPkgOrgPrxVO scgPckReguPkgOrgPrxVO
	 * @return List<ScgPckReguPkgOrgPrxVO>
	 * @exception EventException
	 */
	public List<ScgPckReguPkgOrgPrxVO> searchPackingInstructionRegulationOrganicPeroxideList(ScgPckReguPkgOrgPrxVO scgPckReguPkgOrgPrxVO) throws EventException {
		try {

			return dbDao.searchPackingInstructionRegulationOrganicPeroxideList(scgPckReguPkgOrgPrxVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"IBC Code for Organic peroxide"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"IBC Code for Organic peroxide"}).getMessage(), ex);
        }
	}
	
	/**
	 * IBC Code for Organic peroxide  을 생성,수정,삭제 합니다. <br>
	 * 
	 * @param ScgPckReguPkgOrgPrxVO[] scgPckReguPkgOrgPrxVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePackingInstructionRegulationOrganicPeroxideList(ScgPckReguPkgOrgPrxVO[] scgPckReguPkgOrgPrxVOs, SignOnUserAccount account ) throws EventException{
		try {
			List<ScgPckReguPkgOrgPrxVO> insertVoList = new ArrayList<ScgPckReguPkgOrgPrxVO>();
			List<ScgPckReguPkgOrgPrxVO> updateVoList = new ArrayList<ScgPckReguPkgOrgPrxVO>();
			List<ScgPckReguPkgOrgPrxVO> deleteVoList = new ArrayList<ScgPckReguPkgOrgPrxVO>();
			String pckCd = "";
			String pckCdSeq = "";
			for ( int i=0; i<scgPckReguPkgOrgPrxVOs.length; i++ ) {
				pckCd = scgPckReguPkgOrgPrxVOs[0].getImdgPckInstrCd();
				pckCdSeq = scgPckReguPkgOrgPrxVOs[0].getImdgPckInstrSeq();
				if ( scgPckReguPkgOrgPrxVOs[i].getIbflag().equals("I")){
					scgPckReguPkgOrgPrxVOs[i].setDeltFlg("Y");
					scgPckReguPkgOrgPrxVOs[i].setImdgPckInstrCd(pckCd);
					scgPckReguPkgOrgPrxVOs[i].setImdgPckInstrSeq(pckCdSeq);
				    if (dbDao.searchIbcCodeDuplicateCheck(scgPckReguPkgOrgPrxVOs[i])> 0) {	
						scgPckReguPkgOrgPrxVOs[i].setDeltFlg("N");
						scgPckReguPkgOrgPrxVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(scgPckReguPkgOrgPrxVOs[i]);						
					}else{
						scgPckReguPkgOrgPrxVOs[i].setDeltFlg("N");
						scgPckReguPkgOrgPrxVOs[i].setCreUsrId(account.getUsr_id());
						insertVoList.add(scgPckReguPkgOrgPrxVOs[i]);
					}
				} else if ( scgPckReguPkgOrgPrxVOs[i].getIbflag().equals("U")){
					scgPckReguPkgOrgPrxVOs[i].setUpdUsrId(account.getUsr_id());
					scgPckReguPkgOrgPrxVOs[i].setDeltFlg("N");
					scgPckReguPkgOrgPrxVOs[i].setImdgPckInstrCd(pckCd);
					scgPckReguPkgOrgPrxVOs[i].setImdgPckInstrSeq(pckCdSeq);
					updateVoList.add(scgPckReguPkgOrgPrxVOs[i]);
				} else if ( scgPckReguPkgOrgPrxVOs[i].getIbflag().equals("D")){
					scgPckReguPkgOrgPrxVOs[i].setDeltFlg("Y");
					scgPckReguPkgOrgPrxVOs[i].setUpdUsrId(account.getUsr_id());
					scgPckReguPkgOrgPrxVOs[i].setImdgPckInstrCd(pckCd);
					scgPckReguPkgOrgPrxVOs[i].setImdgPckInstrSeq(pckCdSeq);
					deleteVoList.add(scgPckReguPkgOrgPrxVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addIbcCode(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyIbcCode(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeIbcCode(deleteVoList);
			}
			dbDao.modifyPackingInstructionRegulationFlg(scgPckReguPkgOrgPrxVOs[0].getImdgPckInstrCd(), scgPckReguPkgOrgPrxVOs[0].getImdgPckInstrSeq(), scgPckReguPkgOrgPrxVOs[0].getReguDpNo(), account.getUsr_id());
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"IBC Code for Organic peroxide"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"IBC Code for Organic peroxide"}).getMessage(), ex);
        }
	}
	
	/**
	 * VOP_SCG_0105 : Retrieve <br>
	 * Proper IBC code
	 * 
	 * @param String pkgCd
	 * @param String pkgCdSeq
	 * @param String dispNo
	 * @return List<ScgPckReguPkgIbcCdVO>
	 * @exception EventException
	 */
	public List<ScgPckReguPkgIbcCdVO> searchPackingInstructionRegulationPackagingIbcCodeList(String pkgCd, String pkgCdSeq, String dispNo) throws EventException {
		try {
			return dbDao.searchPackingInstructionRegulationPackagingIbcCodeList(pkgCd, pkgCdSeq, dispNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * VOP_SCG_0105 : SAVE <br>
	 * Proper IBC code
	 * 
	 * @param ScgPckReguPkgIbcCdVO[] ScgPckReguPkgIbcCdVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePackingInstructionRegulationPackagingIbcCodeList(ScgPckReguPkgIbcCdVO[] ScgPckReguPkgIbcCdVOs, SignOnUserAccount account) throws EventException{
		try {		
			List<ScgPckReguPkgIbcCdVO> insertVoList = new ArrayList<ScgPckReguPkgIbcCdVO>();
			List<ScgPckReguPkgIbcCdVO> updateVoList = new ArrayList<ScgPckReguPkgIbcCdVO>();
			List<ScgPckReguPkgIbcCdVO> deleteVoList = new ArrayList<ScgPckReguPkgIbcCdVO>();			

			for ( int i=0; i<ScgPckReguPkgIbcCdVOs.length; i++ ) {
				log.info(ScgPckReguPkgIbcCdVOs[i]);				
				if (ScgPckReguPkgIbcCdVOs[i].getIbflag().equals("I")){			
					ScgPckReguPkgIbcCdVOs[i].setCreUsrId(account.getUsr_id());
					ScgPckReguPkgIbcCdVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(ScgPckReguPkgIbcCdVOs[i]);
				}else if (ScgPckReguPkgIbcCdVOs[i].getIbflag().equals("U")){
					ScgPckReguPkgIbcCdVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(ScgPckReguPkgIbcCdVOs[i]);
				}else if (ScgPckReguPkgIbcCdVOs[i].getIbflag().equals("D")){
					ScgPckReguPkgIbcCdVOs[i].setDeltFlg("Y");
					ScgPckReguPkgIbcCdVOs[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(ScgPckReguPkgIbcCdVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addPackingInstructionRegulationPackagingIbcCode(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyPackingInstructionRegulationPackagingIbcCode(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.modifyPackingInstructionRegulationPackagingIbcCode(deleteVoList);
			}
			dbDao.modifyPackingInstructionRegulationFlg(ScgPckReguPkgIbcCdVOs[0].getPckCd(), ScgPckReguPkgIbcCdVOs[0].getPckCdSeq(), ScgPckReguPkgIbcCdVOs[0].getDispNo(), account.getUsr_id());
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"IBC Code"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"IBC Code"}).getMessage(), ex);
        }
	}	

	/**
	 * VOP_SCG_0103 : OPEN <br>
	 * Proper IBC code
	 * 
	 * @param String pckTpCd
	 * @param String pckMtrlTpCd
	 * @param String pckStyCd
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchPkgMtrlTpCdComboData(String pckTpCd, String pckMtrlTpCd, String pckStyCd) throws EventException {
		try {
			return dbDao.searchPkgMtrlTpCdComboData(pckTpCd, pckMtrlTpCd, pckStyCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}	
	}
	
	/**
	 * VOP_SCG_0105 : IBC CODE ONCHANGE <br>
	 * 
	 * @param ScgPckReguPkgIbcCdVO ScgPckReguPkgIbcCdVO
	 * @return List<ScgPckReguPkgIbcCdVO>
	 * @exception EventException
	 */
	public List<ScgPckReguPkgIbcCdVO> searchPackingIbcCodeList(ScgPckReguPkgIbcCdVO ScgPckReguPkgIbcCdVO) throws EventException {
		try {
			return dbDao.searchPackingIbcCodeList(ScgPckReguPkgIbcCdVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}	
	}
	
	/**
	 * Image File List를 조회 합니다. <br>
	 *   
	 * @param String pkgCd
	 * @param String pkgCdSeq
	 * @param String dispNo
	 * @return List<ScgPckReguImgVO>
	 * @exception EventException
	 */
	public List<ScgPckReguImgVO> searchPackingInstructionRegulationImgList(String pkgCd, String pkgCdSeq, String dispNo) throws EventException {
		try {
			return dbDao.searchPackingInstructionRegulationImgList(pkgCd, pkgCdSeq, dispNo);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"IBC Code for Organic peroxide"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"IBC Code for Organic peroxide"}).getMessage(), ex);
        }
	}

	/**
	 * VOP_SCG_0108 : SAVE <br>
	 * 
	 * @param ScgPckReguImgVO[] scgPckReguImgVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePackingInstructionRegulationImgList(ScgPckReguImgVO[] scgPckReguImgVOs, SignOnUserAccount account) throws EventException{
		try {	
			log.debug("\n scgPckReguImgVOs.length = " + scgPckReguImgVOs.length);
			List<ScgPckReguImgVO> insertVoList = new ArrayList<ScgPckReguImgVO>();
			List<ScgPckReguImgVO> updateVoList = new ArrayList<ScgPckReguImgVO>();
			List<ScgPckReguImgVO> deleteVoList = new ArrayList<ScgPckReguImgVO>();
			String pckCd = "";
			String pckCdSeq = "";
			String dispNo = "";
			log.debug("\n scgPckReguImgVOs.length = " + scgPckReguImgVOs.length);
			
			for ( int i=0; i<scgPckReguImgVOs.length; i++ ) {
				
				pckCd = scgPckReguImgVOs[0].getImdgPckInstrCd();
				pckCdSeq = scgPckReguImgVOs[0].getImdgPckInstrSeq();
				dispNo = scgPckReguImgVOs[0].getReguDpNo();
				log.debug("\n scgPckReguImgVOs[i].getIbflag() = " + scgPckReguImgVOs[i].getIbflag());
				
				if (scgPckReguImgVOs[i].getIbflag().equals("I")){			
					scgPckReguImgVOs[i].setCreUsrId(account.getUsr_id());
					scgPckReguImgVOs[i].setUpdUsrId(account.getUsr_id());
					scgPckReguImgVOs[i].setImdgPckInstrCd(pckCd);
					scgPckReguImgVOs[i].setImdgPckInstrSeq(pckCdSeq);
					scgPckReguImgVOs[i].setReguDpNo(dispNo);
					insertVoList.add(scgPckReguImgVOs[i]);
					log.debug("\n insertVoList.add(scgPckReguImgVOs[i])" );
				}else if (scgPckReguImgVOs[i].getIbflag().equals("U")){
					scgPckReguImgVOs[i].setUpdUsrId(account.getUsr_id());
					scgPckReguImgVOs[i].setImdgPckInstrCd(pckCd);
					scgPckReguImgVOs[i].setImdgPckInstrSeq(pckCdSeq);
					updateVoList.add(scgPckReguImgVOs[i]);
				}else if (scgPckReguImgVOs[i].getIbflag().equals("D")){
					scgPckReguImgVOs[i].setDeltFlg("Y");
					scgPckReguImgVOs[i].setUpdUsrId(account.getUsr_id());
					scgPckReguImgVOs[i].setImdgPckInstrCd(pckCd);
					scgPckReguImgVOs[i].setImdgPckInstrSeq(pckCdSeq);
					scgPckReguImgVOs[i].setReguDpNo(dispNo);
					deleteVoList.add(scgPckReguImgVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addPackingInstructionRegulationImgList(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyPackingInstructionRegulationImgList(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.modifyPackingInstructionRegulationImgList(deleteVoList);
			}
			
			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"IBC Code"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"IBC Code"}).getMessage(), ex);
        }
	}
	
	/**
	 * VOP_SCG_0103 : Retrieve <br>
	 * Pack.Instruct.Code
	 * 
	 * @param ScgPckReguVO scgPckReguVO
	 * @return List<ScgPckReguVO>
	 * @exception EventException
	 */
	public List<ScgPckReguVO> searchPackingInstructionRegulation(ScgPckReguVO scgPckReguVO) throws EventException {
		try {
			return dbDao.searchPackingInstructionRegulation(scgPckReguVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * VOP_SCG_0103 : SAVE <br>
	 * Pack.Instruct.Code
	 * 
	 * @param ScgPckReguVO[] ScgPckReguVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePackingInstructionRegulation(ScgPckReguVO[] ScgPckReguVOs, SignOnUserAccount account) throws EventException{
		try {		
			List<ScgPckReguVO> insertVoList = new ArrayList<ScgPckReguVO>();
			List<ScgPckReguVO> updateVoList = new ArrayList<ScgPckReguVO>();
			List<ScgPckReguVO> deleteVoList = new ArrayList<ScgPckReguVO>();			

			if(ScgPckReguVOs != null){
				for ( int i=0; i<ScgPckReguVOs.length; i++ ) {
					log.info(ScgPckReguVOs[i]);				
					if (ScgPckReguVOs[i].getIbflag().equals("I")){			
						ScgPckReguVOs[i].setCreUsrId(account.getUsr_id());
						ScgPckReguVOs[i].setUpdUsrId(account.getUsr_id());
						insertVoList.add(ScgPckReguVOs[i]);
					}else if (ScgPckReguVOs[i].getIbflag().equals("U")){
						ScgPckReguVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(ScgPckReguVOs[i]);
					}else if (ScgPckReguVOs[i].getIbflag().equals("D")){
						ScgPckReguVOs[i].setDeltFlg("Y");
						ScgPckReguVOs[i].setUpdUsrId(account.getUsr_id());
						deleteVoList.add(ScgPckReguVOs[i]);
					}
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addPackingInstructionRegulation(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyPackingInstructionRegulation(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removePackingInstructionRegulation(deleteVoList);
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"IBC Code"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"IBC Code"}).getMessage(), ex);
        }
	}
        
    /**
	 * VOP_SCG_0103 : Retrieve <br>
	 * Pack.Instruct.Code
	 * 
	 * @param ScgPckPkgVO scgPckPkgVO
	 * @param String pckStyCd
	 * @return List<ScgPckPkgVO>
	 * @exception EventException
	 */
	public List<ScgPckPkgVO> searchPackingInstructionPackaging(ScgPckPkgVO scgPckPkgVO, String pckStyCd) throws EventException {
		try {
			return dbDao.searchPackingInstructionPackaging(scgPckPkgVO, pckStyCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * VOP_SCG_0103 : SAVE <br>
	 * Pack.Instruct.Code
	 * 
	 * @param ScgPckPkgVO[] scgPckPkgVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePackingInstructionPackaging(ScgPckPkgVO[] scgPckPkgVOs, SignOnUserAccount account) throws EventException{
		try {		
			List<ScgPckPkgVO> insertVoList = new ArrayList<ScgPckPkgVO>();
			List<ScgPckPkgVO> updateVoList = new ArrayList<ScgPckPkgVO>();
			List<ScgPckPkgVO> deleteVoList = new ArrayList<ScgPckPkgVO>();			
			
			if(scgPckPkgVOs != null){
				for ( int i=0; i<scgPckPkgVOs.length; i++ ) {
					log.info(scgPckPkgVOs[i]);				
					if (scgPckPkgVOs[i].getIbflag().equals("I")){			
						scgPckPkgVOs[i].setCreUsrId(account.getUsr_id());
						scgPckPkgVOs[i].setUpdUsrId(account.getUsr_id());
						insertVoList.add(scgPckPkgVOs[i]);
					}else if (scgPckPkgVOs[i].getIbflag().equals("U")){
						scgPckPkgVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(scgPckPkgVOs[i]);
					}else if (scgPckPkgVOs[i].getIbflag().equals("D")){
						scgPckPkgVOs[i].setDeltFlg("Y");
						scgPckPkgVOs[i].setUpdUsrId(account.getUsr_id());
						deleteVoList.add(scgPckPkgVOs[i]);
					}
				}
				
				if ( insertVoList.size() > 0 ) {
					dbDao.addPackingInstructionPackaging(insertVoList);
				}
				
				if ( updateVoList.size() > 0 ) {
					dbDao.modifyPackingInstructionPackaging(updateVoList);
				}
				
				if ( deleteVoList.size() > 0 ) {
					dbDao.modifyPackingInstructionPackaging(deleteVoList);
				}
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"IBC Code"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"IBC Code"}).getMessage(), ex);
        }
	}
	
	/**
	 * VOP_SCG_0103 : Retrieve <br>
	 * Pack.Instruct.Code
	 * 
	 * @param ScgPckRefVO scgPckRefVO
	 * @param String pckStyCd
	 * @return List<ScgPckRefVO>
	 * @exception EventException
	 */
	public List<ScgPckRefVO> searchPackingInstructionPackagingReference(ScgPckRefVO scgPckRefVO, String pckStyCd) throws EventException {
		try {
			return dbDao.searchPackingInstructionPackagingReference(scgPckRefVO, pckStyCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * VOP_SCG_0103 : SAVE <br>
	 * Pack.Instruct.Code
	 * 
	 * @param ScgPckRefVO[] ScgPckRefVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePackingInstructionReference(ScgPckRefVO[] ScgPckRefVOs, SignOnUserAccount account) throws EventException{
		try {		
			List<ScgPckRefVO> insertVoList = new ArrayList<ScgPckRefVO>();
			List<ScgPckRefVO> updateVoList = new ArrayList<ScgPckRefVO>();
			List<ScgPckRefVO> deleteVoList = new ArrayList<ScgPckRefVO>();			

			if(ScgPckRefVOs != null){
				for ( int i=0; i<ScgPckRefVOs.length; i++ ) {
					log.info(ScgPckRefVOs[i]);				
					if (ScgPckRefVOs[i].getIbflag().equals("I")){			
						ScgPckRefVOs[i].setCreUsrId(account.getUsr_id());
						ScgPckRefVOs[i].setUpdUsrId(account.getUsr_id());
						insertVoList.add(ScgPckRefVOs[i]);
					}else if (ScgPckRefVOs[i].getIbflag().equals("U")){
						ScgPckRefVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(ScgPckRefVOs[i]);
					}else if (ScgPckRefVOs[i].getIbflag().equals("D")){
						ScgPckRefVOs[i].setDeltFlg("Y");
						ScgPckRefVOs[i].setUpdUsrId(account.getUsr_id());
						deleteVoList.add(ScgPckRefVOs[i]);
					}
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addPackingInstructionReference(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyPackingInstructionReference(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.modifyPackingInstructionReference(deleteVoList);
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"IBC Code"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"IBC Code"}).getMessage(), ex);
        }
	}

/**
	 * VOP_SCG_0107 : Retrieve <br>
	 * Packing Instruction Creation
	 * 
	 * @param ScgPckCreationVO scgPckCreationVO
	 * @return List<ScgPckCreationVO>
	 * @exception EventException
	 */	
	public List<ScgPckCreationVO> searchPackingInstructionRegulationPKGMethodList(ScgPckCreationVO scgPckCreationVO) throws EventException {
		try {
			return dbDao.searchPackingInstructionRegulationPKGMethodList(scgPckCreationVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}		
	
	
	/**
	 * VOP_SCG_0107 : Retrieve <br>
	 * Packing Instruction Creation
	 * 
	 * @param ScgPckCreationVO scgPckCreationVO
	 * @return List<ScgPckCreationVO>
	 * @exception EventException
	 */	
	public List<ScgPckCreationVO> searchPackingInstructionPKGMethodRefList(ScgPckCreationVO scgPckCreationVO) throws EventException {
		try {
			return dbDao.searchPackingInstructionPKGMethodRefList(scgPckCreationVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}		

	
	/**
	 * VOP_SCG_0107 : SAVE <br>
	 * Packing Instruction Creation
	 * 
	 * @param ScgPckCreationVO[] ScgPckCreationVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePackingInstructionRegulationPKGMethodList(ScgPckCreationVO[] ScgPckCreationVOs, SignOnUserAccount account) throws EventException{
		try {		
			List<ScgPckCreationVO> insertVoList = new ArrayList<ScgPckCreationVO>();
			List<ScgPckCreationVO> updateVoList = new ArrayList<ScgPckCreationVO>();
			List<ScgPckCreationVO> deleteVoList = new ArrayList<ScgPckCreationVO>();			

			if(ScgPckCreationVOs != null){
				for ( int i=0; i<ScgPckCreationVOs.length; i++ ) {
					log.info(ScgPckCreationVOs[i]);				
					if (ScgPckCreationVOs[i].getIbflag().equals("I")){			
						ScgPckCreationVOs[i].setCreUsrId(account.getUsr_id());
						ScgPckCreationVOs[i].setUpdUsrId(account.getUsr_id());
						insertVoList.add(ScgPckCreationVOs[i]);
					}else if (ScgPckCreationVOs[i].getIbflag().equals("U")){
						ScgPckCreationVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(ScgPckCreationVOs[i]);
					}else if (ScgPckCreationVOs[i].getIbflag().equals("D")){
						ScgPckCreationVOs[i].setDeltFlg("Y");
						ScgPckCreationVOs[i].setUpdUsrId(account.getUsr_id());
						deleteVoList.add(ScgPckCreationVOs[i]);
					}
				}
			
				if ( insertVoList.size() > 0 ) {
					dbDao.addPackingInstructionRegulationPKGMethodList(insertVoList);
				}
				
				if ( updateVoList.size() > 0 ) {
					dbDao.modifyPackingInstructionRegulationPKGMethodList(updateVoList);
				}
				
				if ( deleteVoList.size() > 0 ) {
					dbDao.modifyPackingInstructionRegulationPKGMethodList(deleteVoList);
				}
				dbDao.modifyPackingInstructionRegulationFlg(ScgPckCreationVOs[0].getImdgPckCd(), ScgPckCreationVOs[0].getImdgPckInstrSeq(), ScgPckCreationVOs[0].getReguDpNo(), account.getUsr_id());
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"PI Creation"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"PI Creation"}).getMessage(), ex);
        }
	}	
	
	/**
	 * VOP_SCG_0103 : Retrieve <br>
	 * Pack.Instruct.Code
	 * 
	 * @param ScgSpclPckProviVO scgSpclPckProviVO
	 * @return List<ScgSpclPckProviVO>
	 * @exception EventException
	 */
	public List<ScgSpclPckProviVO> searchPackingInstructionSpclProvi(ScgSpclPckProviVO scgSpclPckProviVO) throws EventException {
		try {
			return dbDao.searchPackingInstructionSpclProvi(scgSpclPckProviVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * VOP_SCG_0103 : SAVE <br>
	 * Pack.Instruct.Code
	 * 
	 * @param ScgSpclPckProviVO[] ScgSpclPckProviVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePackingInstructionSpclProvi(ScgSpclPckProviVO[] ScgSpclPckProviVOs, SignOnUserAccount account) throws EventException{
		try {		
			List<ScgSpclPckProviVO> insertVoList = new ArrayList<ScgSpclPckProviVO>();
			List<ScgSpclPckProviVO> updateVoList = new ArrayList<ScgSpclPckProviVO>();
			List<ScgSpclPckProviVO> deleteVoList = new ArrayList<ScgSpclPckProviVO>();			

			if(ScgSpclPckProviVOs != null){
				for ( int i=0; i<ScgSpclPckProviVOs.length; i++ ) {
					log.info(ScgSpclPckProviVOs[i]);				
					if (ScgSpclPckProviVOs[i].getIbflag().equals("I")){			
						ScgSpclPckProviVOs[i].setCreUsrId(account.getUsr_id());
						ScgSpclPckProviVOs[i].setUpdUsrId(account.getUsr_id());
						insertVoList.add(ScgSpclPckProviVOs[i]);
					}else if (ScgSpclPckProviVOs[i].getIbflag().equals("U")){
						ScgSpclPckProviVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(ScgSpclPckProviVOs[i]);
					}else if (ScgSpclPckProviVOs[i].getIbflag().equals("D")){
						ScgSpclPckProviVOs[i].setDeltFlg("Y");
						ScgSpclPckProviVOs[i].setUpdUsrId(account.getUsr_id());
						deleteVoList.add(ScgSpclPckProviVOs[i]);
					}
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addPackingInstructionSpclProvi(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyPackingInstructionSpclProvi(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.modifyPackingInstructionSpclProvi(deleteVoList);
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"IBC Code"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"IBC Code"}).getMessage(), ex);
        }
	}
        
    /**
	 * VOP_SCG_0103 : Retrieve <br>
	 * Pack.Instruct.Code
	 * 
	 * @param ScgPckGasReguVO scgPckGasReguVO
	 * @return List<ScgPckGasReguVO>
	 * @exception EventException
	 */
	public List<ScgPckGasReguVO> searchPackingInstructionGasRegulation(ScgPckGasReguVO scgPckGasReguVO) throws EventException {
		try {
			return dbDao.searchPackingInstructionGasRegulation(scgPckGasReguVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * VOP_SCG_0103 : Retrieve <br>
	 * Pack.Instruct.Code
	 * 
	 * @param ScgPckRefVO scgPckRefVO
	 * @return List<ScgPckRefVO>
	 * @exception EventException
	 */
	public List<ScgPckRefVO> searchPackingInstructionGasRegulationReference(ScgPckRefVO scgPckRefVO) throws EventException {
		try {
			return dbDao.searchPackingInstructionGasRegulationReference(scgPckRefVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * VOP_SCG_0103 : Retrieve <br>
	 * Pack.Instruct.Code
	 * 
	 * @param ScgPckRefVO scgPckRefVO
	 * @return List<ScgPckRefVO>
	 * @exception EventException
	 */
	public List<ScgPckRefVO> searchPackingInstructionGasSpclProviReference(ScgPckRefVO scgPckRefVO) throws EventException {
		try {
			return dbDao.searchPackingInstructionGasSpclProviReference(scgPckRefVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * VOP_SCG_0103 : SAVE <br>
	 * Pack.Instruct.Code
	 * 
	 * @param ScgPckGasReguVO[] ScgPckGasReguVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePackingInstructionGasRegulation(ScgPckGasReguVO[] ScgPckGasReguVOs, SignOnUserAccount account) throws EventException{
		try {		
			List<ScgPckGasReguVO> insertVoList = new ArrayList<ScgPckGasReguVO>();
			List<ScgPckGasReguVO> updateVoList = new ArrayList<ScgPckGasReguVO>();
			List<ScgPckGasReguVO> deleteVoList = new ArrayList<ScgPckGasReguVO>();			

			if(ScgPckGasReguVOs != null){
				for ( int i=0; i<ScgPckGasReguVOs.length; i++ ) {
					log.info(ScgPckGasReguVOs[i]);				
					if (ScgPckGasReguVOs[i].getIbflag().equals("I")){			
						ScgPckGasReguVOs[i].setCreUsrId(account.getUsr_id());
						ScgPckGasReguVOs[i].setUpdUsrId(account.getUsr_id());
						insertVoList.add(ScgPckGasReguVOs[i]);
					}else if (ScgPckGasReguVOs[i].getIbflag().equals("U")){
						ScgPckGasReguVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(ScgPckGasReguVOs[i]);
					}else if (ScgPckGasReguVOs[i].getIbflag().equals("D")){
						ScgPckGasReguVOs[i].setDeltFlg("Y");
						ScgPckGasReguVOs[i].setUpdUsrId(account.getUsr_id());
						deleteVoList.add(ScgPckGasReguVOs[i]);
					}
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addPackingInstructionGasRegulation(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyPackingInstructionGasRegulation(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.modifyPackingInstructionGasRegulation(deleteVoList);
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"IBC Code"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"IBC Code"}).getMessage(), ex);
        }
	}
	
	 /**
	 * VOP_SCG_0103 : Retrieve <br>
	 * Pack.Instruct.Code
	 * 
	 * @param ScgPckPtbTnkVO scgPckPtbTnkVO
	 * @param String ptbTnkInstrCd
	 * @return List<ScgPckPtbTnkVO>
	 * @exception EventException
	 */
	public List<ScgPckPtbTnkVO> searchPackingInstructionPortableTank(ScgPckPtbTnkVO scgPckPtbTnkVO, String ptbTnkInstrCd) throws EventException {
		try {
			return dbDao.searchPackingInstructionPortableTank(scgPckPtbTnkVO, ptbTnkInstrCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * VOP_SCG_0103 : Retrieve <br>
	 * Pack.Instruct.Code
	 * 
	 * @param ScgPckRefVO scgPckRefVO
	 * @return List<ScgPckRefVO>
	 * @exception EventException
	 */
	public List<ScgPckRefVO> searchPackingInstructionPortableTankReference(ScgPckRefVO scgPckRefVO) throws EventException {
		try {
			return dbDao.searchPackingInstructionPortableTankReference(scgPckRefVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * VOP_SCG_0103 : SAVE <br>
	 * Pack.Instruct.Code
	 * 
	 * @param ScgPckPtbTnkVO[] ScgPckPtbTnkVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePackingInstructionPortableTank(ScgPckPtbTnkVO[] ScgPckPtbTnkVOs, SignOnUserAccount account) throws EventException{
		try {		
			List<ScgPckPtbTnkVO> insertVoList = new ArrayList<ScgPckPtbTnkVO>();
			List<ScgPckPtbTnkVO> updateVoList = new ArrayList<ScgPckPtbTnkVO>();
			List<ScgPckPtbTnkVO> deleteVoList = new ArrayList<ScgPckPtbTnkVO>();			

			if(ScgPckPtbTnkVOs != null){
				for ( int i=0; i<ScgPckPtbTnkVOs.length; i++ ) {
					log.info(ScgPckPtbTnkVOs[i]);				
					if (ScgPckPtbTnkVOs[i].getIbflag().equals("I")){			
						ScgPckPtbTnkVOs[i].setCreUsrId(account.getUsr_id());
						ScgPckPtbTnkVOs[i].setUpdUsrId(account.getUsr_id());
						insertVoList.add(ScgPckPtbTnkVOs[i]);
					}else if (ScgPckPtbTnkVOs[i].getIbflag().equals("U")){
						ScgPckPtbTnkVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(ScgPckPtbTnkVOs[i]);
					}else if (ScgPckPtbTnkVOs[i].getIbflag().equals("D")){
						ScgPckPtbTnkVOs[i].setDeltFlg("Y");
						ScgPckPtbTnkVOs[i].setUpdUsrId(account.getUsr_id());
						deleteVoList.add(ScgPckPtbTnkVOs[i]);
					}
				}
			}
			if ( insertVoList.size() > 0 ) {
				dbDao.addPackingInstructionPortableTank(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyPackingInstructionPortableTank(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.modifyPackingInstructionPortableTank(deleteVoList);
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"IBC Code"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"IBC Code"}).getMessage(), ex);
        }
	}
	

	/**
	 * Packaging Code General  을 조회 합니다. <br>
	 * 
	 * @param scgPckReguPkgCdVO
	 * @return List<ScgPckReguPkgCdVO>
	 * @exception EventException
	 */
	public List<ScgPckReguPkgCdVO> searchPackingInstructionRegulationPackagingCodeList(ScgPckReguPkgCdVO scgPckReguPkgCdVO) throws EventException {
		try {

			return dbDao.searchPackingInstructionRegulationPackagingCodeList(scgPckReguPkgCdVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"IBC Code for Organic peroxide"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"IBC Code for Organic peroxide"}).getMessage(), ex);
        }
	}
	/**
	 * Packaging Code General  을 생성,수정,삭제 합니다. <br>
	 * 
	 * @param ScgPckReguPkgCdVO[] scgPckReguPkgCdVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePackingInstructionRegulationPackagingCodeList(ScgPckReguPkgCdVO[] scgPckReguPkgCdVOs, SignOnUserAccount account ) throws EventException{
		try {
			List<ScgPckReguPkgCdVO> insertVoList = new ArrayList<ScgPckReguPkgCdVO>();
			List<ScgPckReguPkgCdVO> updateVoList = new ArrayList<ScgPckReguPkgCdVO>();
			List<ScgPckReguPkgCdVO> deleteVoList = new ArrayList<ScgPckReguPkgCdVO>();
			for ( int i=0; i<scgPckReguPkgCdVOs.length; i++ ) {
				if ( scgPckReguPkgCdVOs[i].getIbflag().equals("I")){
						scgPckReguPkgCdVOs[i].setUserId(account.getUsr_id());
						insertVoList.add(scgPckReguPkgCdVOs[i]);
				} else if ( scgPckReguPkgCdVOs[i].getIbflag().equals("U")){
					scgPckReguPkgCdVOs[i].setUserId(account.getUsr_id());
					updateVoList.add(scgPckReguPkgCdVOs[i]);
				} else if ( scgPckReguPkgCdVOs[i].getIbflag().equals("D")){
					scgPckReguPkgCdVOs[i].setUserId(account.getUsr_id());
					deleteVoList.add(scgPckReguPkgCdVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addPackingInstructionRegulationPackagingCodeList(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyPackingInstructionRegulationPackagingCodeList(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removePackingInstructionRegulationPackagingCodeList(deleteVoList);
			}
			dbDao.modifyPackingInstructionRegulationFlg(scgPckReguPkgCdVOs[0].getPckCd(), scgPckReguPkgCdVOs[0].getPckCdSeq(), scgPckReguPkgCdVOs[0].getDispNo(), account.getUsr_id());
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"IBC Code for Organic peroxide"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"IBC Code for Organic peroxide"}).getMessage(), ex);
        }
	}
	
	/**
	 * VOP_SCG_0104 : IBC CODE ONCHANGE <br>
	 * 
	 * @param String pkgCd
	 * @return List<ScgPckReguPkgCdVO>
	 * @exception EventException
	 */
	public List<ScgPckReguPkgCdVO> checkPkgCd(String pkgCd) throws EventException {
		try {
			return dbDao.checkPkgCd(pkgCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}	
	}
	
	/**
	 * SCG CODE 정보를 조회합니다.<br>
	 * 
	 * @param ScgCdVO scgCdVO
	 * @return List<ScgCdVO>
	 * @exception EventException
	 */
	public List<ScgCdVO> searchScgCodeList(ScgCdVO scgCdVO) throws EventException {
		try {
			return dbDao.searchScgCodeList(scgCdVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * VOP_SCG_0083 SCG NON D/G CARGO KEYWORD 정보를 조회합니다.<br>
	 * 
	 * @param ScgNonDgCgoKwVO scgNonDgCgoKwVO
	 * @return List<ScgNonDgCgoKwVO>
	 * @exception EventException
	 */
	public List<ScgNonDgCgoKwVO> searchScgNonDgCgoList(ScgNonDgCgoKwVO scgNonDgCgoKwVO) throws EventException {
		try {
			return dbDao.searchScgNonDgCgoList(scgNonDgCgoKwVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 *VOP_SCG_0084 SCG chemical history 정보를 조회합니다.<br>
	 * 
	 * @param ScgChemicalHistoryVO scgChemicalHistoryVO
	 * @return List<ScgChemicalHistoryVO>
	 * @exception EventException
	 */
	public List<ScgChemicalHistoryVO> searchScgChemicalHistory(ScgChemicalHistoryVO scgChemicalHistoryVO) throws EventException{
		try {
			return dbDao.searchScgChemicalHistory(scgChemicalHistoryVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * SCG chemical history 정보를 조회합니다.<br>
	 * 
	 * @param ScgChemicalHistoryVO scgChemicalHistoryVO
	 * @return List<ScgChemicalHistoryVO>
	 * @exception EventException
	 */
	public List<ScgChemicalHistoryVO> searchScgChemHistoryAnswer(ScgChemicalHistoryVO scgChemicalHistoryVO) throws EventException {
		try {
			return dbDao.searchScgChemHistoryAnswer(scgChemicalHistoryVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 *VOP_SCG_0084 SCG chemical history 정보를 저장합니다.<br>
	 * 
	 * @param ScgChemicalHistoryVO[] scgChemicalHistoryVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String manageScgChemicalHistory(ScgChemicalHistoryVO[] scgChemicalHistoryVOs,SignOnUserAccount account) throws EventException{
			try {
				List<ScgChemicalHistoryVO> insertVoList = new ArrayList<ScgChemicalHistoryVO>();
				List<ScgChemicalHistoryVO> updateVoList = new ArrayList<ScgChemicalHistoryVO>();
				List<ScgChemicalHistoryVO> deleteVoList = new ArrayList<ScgChemicalHistoryVO>();
			
				for ( int i=0; i<scgChemicalHistoryVOs.length; i++ ) {
					
					
					if ( scgChemicalHistoryVOs[i].getIbflag().equals("I")){
						 scgChemicalHistoryVOs[i].setCreUsrId(account.getUsr_id());
						 scgChemicalHistoryVOs[i].setUpdUsrId(account.getUsr_id());
						 scgChemicalHistoryVOs[i].setRqstOfcCd(account.getOfc_cd());
						 scgChemicalHistoryVOs[i].setRqstId(account.getUsr_id());
						

						 insertVoList.add(scgChemicalHistoryVOs[i]);
						 
					} else if ( scgChemicalHistoryVOs[i].getIbflag().equals("U")){
						scgChemicalHistoryVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(scgChemicalHistoryVOs[i]);
					} else if ( scgChemicalHistoryVOs[i].getIbflag().equals("D")){
						scgChemicalHistoryVOs[i].setUpdUsrId(account.getUsr_id());
						deleteVoList.add(scgChemicalHistoryVOs[i]);
					}
					
				}
				
				if ( insertVoList.size() > 0 ) {
					dbDao.addScgChemicalHistory(insertVoList);
				}
				
				if ( updateVoList.size() > 0 ) {
					dbDao.updateScgChemicalHistory(updateVoList);
				}
				
				if ( deleteVoList.size() > 0 ) {
					dbDao.deleteScgChemicalHistory(deleteVoList);
					dbDao.deleteScgChemicalHistoryFile(deleteVoList);
				}

			  return "";
			  
			} catch (DAOException ex) {
	            log.error("err " + ex.toString(), ex);
	            throw new EventException(new ErrorHandler(ex).getMessage(),ex);
	        } catch (Exception ex) {
	            log.error("err " + ex.toString(), ex);
	            throw new EventException(new ErrorHandler(ex).getMessage(),ex);
	        }
		}
		
	/**
	 *VOP_SCG_0084 SCG chemical history answer 정보를 저장합니다.<br>
	 * 
	 * @param ScgChemicalHistoryVO[] scgChemicalHistoryVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String manageScgChemHistoryAnswer(ScgChemicalHistoryVO[] scgChemicalHistoryVOs,SignOnUserAccount account) throws EventException{
		try {
			List<ScgChemicalHistoryVO> updateVoList = new ArrayList<ScgChemicalHistoryVO>();
		
			for ( int i=0; i<scgChemicalHistoryVOs.length; i++ ) {
				
				
			 if ( scgChemicalHistoryVOs[i].getIbflag().equals("U")){
					scgChemicalHistoryVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(scgChemicalHistoryVOs[i]);
				}

			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.updateScgChemicalHistoryAnswer(updateVoList);
			}
			

		  return "";
		  
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(),ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(),ex);
        }
	
	}
	
	/**
	 * SCG Chemical history file 을 조회 합니다. <br>
	 * 
	 * @param  ScgChemHistoryFileVO scgChemHistoryFileVO
	 * @return List<ScgChemHistoryFileVO>
	 * @exception EventException
	 */
	public List<ScgChemHistoryFileVO> searchChemFileList(ScgChemHistoryFileVO  scgChemHistoryFileVO) throws EventException {
		try {
			return dbDao.searchChemFileList(scgChemHistoryFileVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Packing Instructions/Provisions"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Packing Instructions/Provisions"}).getMessage(), ex);
        }
	}
	
	

	/**
	 * SCG Chemical history 생성, 수정, 삭제 합니다. <br>
	 * 
	 * @param ScgChemHistoryFileVO[] scgChemHistoryFileVOs
	 * @param List<String> keys
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageChemFile(ScgChemHistoryFileVO[] scgChemHistoryFileVOs, List<String> keys, SignOnUserAccount account) throws EventException{
		try {
			//FILE UPLOAD KEY값
			Iterator<String> keyArr = null;			
			if(keys != null) keyArr = keys.iterator();

			List<ScgChemHistoryFileVO> insertVoList = new ArrayList<ScgChemHistoryFileVO>();			
			List<ScgChemHistoryFileVO> deleteVoList = new ArrayList<ScgChemHistoryFileVO>();

			for ( int i=0; i<scgChemHistoryFileVOs.length; i++ ) {
				//FILE UPLOAD KEY값 SETTING하기
				if(keyArr != null) {
					if("Y".equals(scgChemHistoryFileVOs[i].getFileSetYn()) && keyArr.hasNext()) 
						scgChemHistoryFileVOs[i].setFileSavId(keyArr.next());	 
				}
				
				if ( scgChemHistoryFileVOs[i].getIbflag().equals("I")){
			
		     		String maxSeq = searchAtchFileSeq(scgChemHistoryFileVOs[i].getChemSeq(),scgChemHistoryFileVOs[i].getAtchFileDivCd());
			    	int seq = Integer.parseInt(maxSeq)+i;
		
					scgChemHistoryFileVOs[i].setChemSeq(scgChemHistoryFileVOs[i].getChemSeq());
					scgChemHistoryFileVOs[i].setAtchFileDivCd(scgChemHistoryFileVOs[i].getAtchFileDivCd());
					scgChemHistoryFileVOs[i].setAtchFileSeq(seq+"");
					scgChemHistoryFileVOs[i].setCreUsrId(account.getUsr_id());
					scgChemHistoryFileVOs[i].setUpdUsrId(account.getUsr_id());
	
					
					insertVoList.add(scgChemHistoryFileVOs[i]); 				
				} else if ( scgChemHistoryFileVOs[i].getIbflag().equals("D")){
					scgChemHistoryFileVOs[i].setUpdUsrId(account.getUsr_id());
					scgChemHistoryFileVOs[i].setChemSeq(scgChemHistoryFileVOs[i].getChemSeq());
					scgChemHistoryFileVOs[i].setAtchFileDivCd(scgChemHistoryFileVOs[i].getAtchFileDivCd());
					scgChemHistoryFileVOs[i].setAtchFileSeq(scgChemHistoryFileVOs[i].getAtchFileSeq());
					deleteVoList.add(scgChemHistoryFileVOs[i]);
				}
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeFile(deleteVoList);
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addFile(insertVoList);
			}

			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Vessel Operator's Restriction on DG"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Vessel Operator's Restriction on DG"}).getMessage(), ex);
        }
	}
	
	
	/**
	 * 첨부파일의 max seq 값을 검색<br>

	 * @param String nseq
	 * @param String div
     * @return String
     * @throws EventException
     */
	public String searchAtchFileSeq(String nseq, String div) throws EventException {
		try {
			return dbDao.searchAtchFileSeq(nseq, div);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192",new String[]{"Vessel Operator's Restriction on DG"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192",new String[]{"Vessel Operator's Restriction on DG"}).getMessage(), ex);
		}
	}
	
	/**
	 * SCG CODE 정보를 추가,수정,삭제합니다.<br>
	 * 
	 * @param ScgCdVO[] scgCdVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageScgCode(ScgCdVO[] scgCdVO, SignOnUserAccount account) throws EventException{
		try {
			List<ScgCdVO> insertVoList = new ArrayList<ScgCdVO>();
			List<ScgCdVO> updateVoList = new ArrayList<ScgCdVO>();
			List<ScgCdVO> deleteVoList = new ArrayList<ScgCdVO>();
//			ScgCdVO dupVoList = new ScgCdVO();

			for ( int i=0; i<scgCdVO.length; i++ ) {
				ScgCdVO dupVoList = new ScgCdVO();
				scgCdVO[i].setCdTblId(scgCdVO[0].getCdTblId());
				if ( scgCdVO[i].getIbflag().equals("I")){
					dupVoList.setCdTblId(scgCdVO[i].getCdTblId());
					dupVoList.setValCd(scgCdVO[i].getValCd());
					dupVoList.setDeltFlg("Y");
					if (dbDao.searchScgCodeList(dupVoList).size() > 0) {
						scgCdVO[i].setDeltFlg("N");
						scgCdVO[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(scgCdVO[i]);						
					}else{
						scgCdVO[i].setDeltFlg("N");
						scgCdVO[i].setCreUsrId(account.getUsr_id());
						insertVoList.add(scgCdVO[i]);
					}
//					scgCdVO[i].setCreUsrId(account.getUsr_id());
//					insertVoList.add(scgCdVO[i]);
				} else if ( scgCdVO[i].getIbflag().equals("U")){
					scgCdVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(scgCdVO[i]);
				} else if ( scgCdVO[i].getIbflag().equals("D")){
					scgCdVO[i].setDeltFlg("Y");
					scgCdVO[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(scgCdVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addScgCodeS(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyScgCodeS(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeScgCodeS(deleteVoList);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 * VOP_SCG_0083 SCG NON D/G CARGO KEYWORD CODE 정보를 추가,수정,삭제합니다.<br>
	 * 
	 * @param scgNonDgCgoKwVOs
	 * @param account
	 * @return String
	 * @exception EventException
	 */
	public String manageScgNonDgCgoKwList(ScgNonDgCgoKwVO[] scgNonDgCgoKwVOs, SignOnUserAccount account) throws EventException{
		try {
			List<ScgNonDgCgoKwVO> insertVoList = new ArrayList<ScgNonDgCgoKwVO>();
			List<ScgNonDgCgoKwVO> deleteVoList = new ArrayList<ScgNonDgCgoKwVO>();
			List<ScgNonDgCgoKwVO> updateVoList = new ArrayList<ScgNonDgCgoKwVO>();
		
			for ( int i=0; i<scgNonDgCgoKwVOs.length; i++ ) {
				
				
				if ( scgNonDgCgoKwVOs[i].getIbflag().equals("I")){
					 scgNonDgCgoKwVOs[i].setCreUsrId(account.getUsr_id());
					 scgNonDgCgoKwVOs[i].setUpdUsrId(account.getUsr_id());
					 
					 String dbchk = dbDao.checkScgNonDgCgoKw(scgNonDgCgoKwVOs[i].getNonDcgoKwNm());
						String nm = scgNonDgCgoKwVOs[i].getNonDcgoKwNm();
						
						if(!dbchk.equals("0"))
						{
							throw new EventException(new ErrorHandler("Duplication:"+nm).getCode());
						}
					 
					 insertVoList.add(scgNonDgCgoKwVOs[i]);
					 
				} else if ( scgNonDgCgoKwVOs[i].getIbflag().equals("U")){
					scgNonDgCgoKwVOs[i].setDeltUsrId(account.getUsr_id());
					updateVoList.add(scgNonDgCgoKwVOs[i]);
				}
				  else if ( scgNonDgCgoKwVOs[i].getIbflag().equals("D")){
					scgNonDgCgoKwVOs[i].setDeltUsrId(account.getUsr_id());
					deleteVoList.add(scgNonDgCgoKwVOs[i]);
				}
				
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addScgNonDgCgoKwCodeList(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.updateScgNonDgCgoKwCodeList(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.modifyScgNonDgCgoKwCodeList(deleteVoList);
			}
			
		  return "";
		  
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(),ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(),ex);
        }
	}
	
	/**
	 * Partner's Contact Point for SPCL CGO by POL 을 조회 합니다. <br>
	 * 
	 * @param scgCntcPntPolVO
	 * @return List<ScgCntcPntPolVO>
	 * @exception EventException
	 */
	public List<ScgCntcPntPolVO> searchPartnerContactPointPolList(ScgCntcPntPolVO scgCntcPntPolVO) throws EventException {
		try {
			return dbDao.searchPartnerContactPointPolList(scgCntcPntPolVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Partner Contact Point for SPCL CGO by POL"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Partner Contact Point for SPCL CGO by POL"}).getMessage(), ex);
        }

	}
	
	/**
	 * Partner's Contact Point for SPCL CGO by Pol 을 생성,수정,삭제 합니다. <br>
	 * 
	 * @param  ScgCntcPntPolVO[]  scgCntcPntPolVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePartnerContactPointPol(ScgCntcPntPolVO[] scgCntcPntPolVOs, SignOnUserAccount account) throws EventException{
		try {
			List<ScgCntcPntPolVO> insertVoList = new ArrayList<ScgCntcPntPolVO>();
			List<ScgCntcPntPolVO> updateVoList = new ArrayList<ScgCntcPntPolVO>();
			List<ScgCntcPntPolVO> deleteVoList = new ArrayList<ScgCntcPntPolVO>();
			
			for ( int i=0; i<scgCntcPntPolVOs.length; i++ ) {
				if ( scgCntcPntPolVOs[i].getIbflag().equals("I")){
					scgCntcPntPolVOs[i].setCreUsrId(account.getUsr_id());
					insertVoList.add(scgCntcPntPolVOs[i]);
				} else if ( scgCntcPntPolVOs[i].getIbflag().equals("U")){
					scgCntcPntPolVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(scgCntcPntPolVOs[i]);
				} else if ( scgCntcPntPolVOs[i].getIbflag().equals("D")){
					deleteVoList.add(scgCntcPntPolVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addPartnerContactPointPol(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyPartnerContactPointPol(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removePartnerContactPointPol(deleteVoList);
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Partner's Contact Point for SPCL CGO by Pol"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Partner's Contact Point for SPCL CGO by Pol"}).getMessage(), ex);
        }
	}
}