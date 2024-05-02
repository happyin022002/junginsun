/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialCargoMasterDataMgtBCImpl.java
*@FileTitle : Load Reject Reason (Creation)
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration.SpecialCargoMasterDataMgtDBDAO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.GetLoadingPortRsoVO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.MdmVslSvcLaneListVO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgCntcPntVO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgImdgPckInstrVO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgImdgSpclProvisVO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgImdgUnNoOrgRactVO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgMailTampletVO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgRgnShpOprPortListVO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.SearchIrregularTypeCodeListVO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.SearchLoadingPortRsoVO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.SearchRsoComboListVO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.VopScg0070VO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.MdmCarrierVO;
import com.clt.syscommon.common.table.ScgImdgAbbrVO;
import com.clt.syscommon.common.table.ScgImdgClssCdVO;
import com.clt.syscommon.common.table.ScgImdgCompGrpVO;
import com.clt.syscommon.common.table.ScgImdgExptQtyVO;
import com.clt.syscommon.common.table.ScgImdgMrnPolutVO;
import com.clt.syscommon.common.table.ScgImdgPckCdVO;
import com.clt.syscommon.common.table.ScgImdgPckGrpVO;
import com.clt.syscommon.common.table.ScgImdgSegrGrpDtlVO;
import com.clt.syscommon.common.table.ScgImdgSegrGrpVO;
import com.clt.syscommon.common.table.ScgImdgSegrSymVO;
import com.clt.syscommon.common.table.ScgImdgSpclProviVO;
import com.clt.syscommon.common.table.ScgImdgTnkTpVO;
import com.clt.syscommon.common.table.ScgLodRjctCdVO;
import com.clt.syscommon.common.table.ScgRgnShpOprCdVO;



/**
 * OPUS-SpecialCargoMasterDataMgt Business Logic Basic Command implementation<br>
 * - Handling business transactions of OPUS-SpecialCargoMasterDataMgt<br>
 *
 * @author
 * @see VOP_SCG-0031EventResponse,SpecialCargoMasterDataMgtBC
 * @since J2EE 1.4
 */

public class SpecialCargoMasterDataMgtBCImpl extends BasicCommandSupport implements SpecialCargoMasterDataMgtBC {

	// Database Access Object
	private transient SpecialCargoMasterDataMgtDBDAO dbDao = null;

	/**
	 * SpecialCargoMasterDataMgtBCImpl object creation<br>
	 * SpecialCargoMasterDataMgtDBDAO creation<br>
	 */
	public SpecialCargoMasterDataMgtBCImpl() {
		dbDao = new SpecialCargoMasterDataMgtDBDAO();
	}
	
	/**
	 * Load Reject Reason retrieve<br>
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
	 * Load Reject Reason create,modify,delete <br>
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
			
			String spclCgoCateCd = scgLodRjctCdVOs[0].getSpclCgoCateCd();	//Retrieve Special Cargo Type.

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
	 * SPCL CGO RSO retrieve <br>
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
	 * SPCL CGO RSO create,modify,delete <br>
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
	 * Partner's Contact Point for SPCL CGO retrieve <br>
	 * 
	 * @param scgCntcPntVO
	 * @return List<ScgCntcPntVO>
	 * @exception EventException
	 */
	public List<ScgCntcPntVO> searchPartnerLineContactPointList(ScgCntcPntVO scgCntcPntVO) throws EventException {
		try {
			
			if("SpclCgo".equals(scgCntcPntVO.getTransmitTarget())){
				return dbDao.searchPartnerLineContactPointList(scgCntcPntVO);	
			}else{
				return dbDao.searchPartnerLineContactPointAddList(scgCntcPntVO);
			}
			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Partner Contact Point for SPCL CGO"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Partner Contact Point for SPCL CGO"}).getMessage(), ex);
        }

	}

	/**
	 * RSO retrieve <br>
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
	 * RSO retrieve <br>
	 * 
	 * @param ScgRgnShpOprCdVO scgRgnShpOprCdVO
	 * @return List<ScgRgnShpOprCdVO>
	 * @exception EventException
	 */
	public List<ScgRgnShpOprCdVO> searchSpclCgoRsoforEdiUnmapList(ScgRgnShpOprCdVO scgRgnShpOprCdVO) throws EventException {
		
		try {
			return dbDao.searchSpclCgoRsoforEdiUnmapList(scgRgnShpOprCdVO);
			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Special Cargo RSO"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Special Cargo RSO"}).getMessage(), ex);
        }
	}
	
	/**
	 * Partner's Contact Point for SPCL CGO create,modify,delete <br>
	 * 
	 * @param  ScgCntcPntVO[]  scgCntcPntVOs
	 * @param  ScgCntcPntVO  scgCntcPntVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePartnerLineContactPoint(ScgCntcPntVO[] scgCntcPntVOs, ScgCntcPntVO scgCntcPntVO, SignOnUserAccount account) throws EventException{
		try {
			List<ScgCntcPntVO> insertVoList = new ArrayList<ScgCntcPntVO>();
			List<ScgCntcPntVO> updateVoList = new ArrayList<ScgCntcPntVO>();
			List<ScgCntcPntVO> deleteVoList = new ArrayList<ScgCntcPntVO>();
			
			for ( int i=0; i<scgCntcPntVOs.length; i++ ) {
				if ( scgCntcPntVOs[i].getIbflag().equals("I")){
					//scgCntcPntVOs[i].setOrgCntcCateCd(scgCntcPntVOs[i].getCntcCateCd());
					if("SpclCgo".equals(scgCntcPntVO.getTransmitTarget())){
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
					}else{
						
						// BAPLIE(Syntax Error) 항목 저장시 RSO(ASR,AMR,EUR) 모두  적용 
						if("BE".equals(scgCntcPntVOs[i].getCntcCateCd())){
							List<ScgRgnShpOprCdVO> searchSpclCgoRsoList = dbDao.searchSpclCgoRsoList();
							for(int k=0; k<searchSpclCgoRsoList.size(); k++){

								if(!searchSpclCgoRsoList.get(k).getRgnShpOprCd().equals(scgCntcPntVOs[i].getRgnShpOprCd())){
									ScgCntcPntVO tempVo = new ScgCntcPntVO();
									
									tempVo.setRgnShpOprCd(searchSpclCgoRsoList.get(k).getRgnShpOprCd());
									tempVo.setCrrCd(scgCntcPntVOs[i].getCrrCd());
									tempVo.setSlanCd(scgCntcPntVOs[i].getSlanCd());
									tempVo.setCntcCateCd(scgCntcPntVOs[i].getCntcCateCd());
									tempVo.setCntcPsonEmlCtnt(scgCntcPntVOs[i].getCntcPsonEmlCtnt());
									tempVo.setDeltFlg("N");
									tempVo.setCreUsrId(account.getUsr_id());
									
									if (dbDao.searchPartnerLineContactPointAddList(tempVo).size() <= 0) {
										insertVoList.add(tempVo);
									}
									
								}
							}							
						}

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
				if("SpclCgo".equals(scgCntcPntVO.getTransmitTarget())){
					dbDao.addPartnerLineContactPoint(insertVoList);	
				}else{
					dbDao.addPartnerLineContactPointAdd(insertVoList);	
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				if("SpclCgo".equals(scgCntcPntVO.getTransmitTarget())){
					dbDao.modifyPartnerLineContactPoint(updateVoList);	
				}else{
					dbDao.modifyPartnerLineContactPointAdd(updateVoList);
				}
				
			}
			
			if ( deleteVoList.size() > 0 ) {
				if("SpclCgo".equals(scgCntcPntVO.getTransmitTarget())){
					dbDao.removePartnerLineContactPoint(deleteVoList);	
				}else{
					dbDao.removePartnerLineContactPointAdd(deleteVoList);
				}
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
	 * SPCL CGO Irregular Type retrieve <br>
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
	 * SPCL CGO Irregular Type create,modify,delete <br>
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
					if (dbDao.searchIrregularTypeCodeDupChk(searchIrregularTypeCodeListVOs[i]).size() > 0) {
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
	 * Definition of Class  retrieve <br>
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
	 * Definition of Class create,modify,delete <br>
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
					scgImdgClssCdVOs[i].setDeltFlg("Y");
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
	 * Marine Pollutant retrieve <br>
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
	 * Marine Pollutant create,modify,delete <br>
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
					scgImdgMrnPolutVOs[i].setDeltFlg("Y");
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
	 * Special Provisions retrieve <br>
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
	 * Special Provisions create,modify,delete <br>
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
	 * Packing Group retrieve <br>
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
	 * Packing Group create,modify,delete <br>
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
	 * Packaging Code retrieve <br>
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
	 * Packaging Code create,modify,delete <br>
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
					if("1".equals(scgImdgPckCdVOs[i].getDeltFlg())){
						scgImdgPckCdVOs[i].setDeltFlg("Y");	
					}
					else{
					scgImdgPckCdVOs[i].setDeltFlg("N");
					}
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
	 * IMO Type Portable Tanks retrieve <br>
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
	 * IMO Type Portable Tanks create,modify,delete <br>
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
					scgImdgTnkTpVOs[i].setDeltFlg("Y");
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
	 * DG Abbreviation retrieve <br>
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
	 * DG Abbreviation create,modify,delete <br>
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
					if (dbDao.searchDGAbbreviationCodeList(scgImdgAbbrVOs[i]).size() > 0) {
						//scgImdgAbbrVOs[i].setDeltFlg("N");
						//scgImdgAbbrVOs[i].setUpdUsrId(account.getUsr_id());
						//updateVoList.add(scgImdgAbbrVOs[i]);
						throw new EventException(new ErrorHandler("COM12226", new String[]{scgImdgAbbrVOs[i].getImdgAbbrCd()}).getMessage());
					}else{
						scgImdgAbbrVOs[i].setDeltFlg("N");
						scgImdgAbbrVOs[i].setCreUsrId(account.getUsr_id());
						insertVoList.add(scgImdgAbbrVOs[i]);
					}
				} else if ( scgImdgAbbrVOs[i].getIbflag().equals("U")){
					scgImdgAbbrVOs[i].setDeltFlg("Y");
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
		}catch(EventException e){
			throw e;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"DG Abbreviation"}).getMessage(), ex);
        }
	}	


	/**
	 * No. & Symbols in SEG Table/Mixed STWG retrieve <br>
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
	 * No. & Symbols in SEG Table/Mixed STWG create,modify,delete <br>
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
					scgImdgSegrSymVOs[i].setDeltFlg("Y");
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
	 * Compatibility Groups of Class 1 retrieve <br>
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
	 * Compatibility Groups of Class 1 create,modify,delete <br>
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
					scgImdgCompGrpVOs[i].setDeltFlg("Y");
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
	 * Excepted Quantities retrieve <br>
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
	 * Excepted Quantities create,modify,delete <br>
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
	 * Segregation Groups retrieve <br>
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
				vopScg0070VO.setScgImdgSegrGrpVOL(dbDao.searchSegregationGroupList(scgImdgSegrGrpVO));
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
	 * Segregation Groups create,modify,delete <br>
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
					//dbDao.addSegregationGroup(insertVoList1);
					for(int i=0; i < insertVoList1.size(); i++){ //20141210 저장할때 버그발생 > 기존저장된 데이타 중복에러 > 키조회후 있으면 저장할 수 없도록 조치
						ScgImdgSegrGrpVO sVO = insertVoList1.get(i);
						List<ScgImdgSegrGrpVO> vo = dbDao.searchSegregationGroupList(sVO);
						
						if(vo.size() == 0){
							dbDao.addSegregationGroup(sVO);
						}

					}
				}
				
				if ( updateVoList1.size() > 0 ) {
					dbDao.modifySegregationGroup(updateVoList1);
				}
				
			}
			
			//Heavy metals and their salts save
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
	 * VOP_SCG-0033 : retrieve<br>
	 * Loading Port for RSO retrieve
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
     *  Loading Port for RSO retrieve
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
	 *  Loading Port for RSO save
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
	 * Loading Port for RSO Location Code retrieve <br>
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
     * Loading Port for RSO Retrieve Dup Check 내용을 조회한다.
	 * 
	 * @param  String locCd
	 * @return List<GetLoadingPortRsoVO>
	 * @exception EventException
	 */
	public List<GetLoadingPortRsoVO> searchLoadingPortRSODupChk(String locCd)
			throws EventException {
		try {
			return dbDao.searchLoadingPortRSODupChk(locCd);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Location Code"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Location Code"}).getMessage(), ex);
        }
	}
	/**
	 * Target Lane for SPCL CGO APVL retrieve <br>
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
	 * Target Lane for SPCL CGO APVL modify <br>
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
	 * Packing Instructions/Provisions retrieve <br>
	 * 
	 * @param  String imdgPckInstrCd
	 * @return List<ScgImdgPckInstrVO>
	 * @exception EventException
	 */
	public List<ScgImdgPckInstrVO> searchPackingInstructionList(String imdgPckInstrCd) throws EventException {
		try {
			return dbDao.searchPackingInstructionList(imdgPckInstrCd);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Packing Instructions/Provisions"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Packing Instructions/Provisions"}).getMessage(), ex);
        }
	}

	/**
	 * Packing Instructions/Provisions create,modify,delete <br>
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
     * Organic Peroxides & Self-Reactive Substances info retrieve<br>
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
     *  Special Provisions for Segregation (Creation) retrieve <br>
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
     * Special Provisions for Segregation (Creation) SubsidiaryRisks retrieve <br>
     * 
     * @param  String sImdgUnNo
     * @param  String sImdgUnNoSeq
     * @throws EventException
     * @return List<ScgImdgSpclProvisVO>
     * @author
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
	 * Setup mail contents for SPCL CGO application retrieve <br>
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
	 * Setup mail contents for SPCL CGO application modification save <br>
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
     * Carreier Code check <br>
	 * 
	 * @param crrCd
	 * @return List<MdmCarrierVO>
	 * @exception EventException
	 */
	public List<MdmCarrierVO> searchCarrierCode(String crrCd) throws EventException {
		try {
			return dbDao.searchCarrierCode(crrCd);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Carrier Code"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Carrier Code"}).getMessage(), ex);
		}		
	}
 
}