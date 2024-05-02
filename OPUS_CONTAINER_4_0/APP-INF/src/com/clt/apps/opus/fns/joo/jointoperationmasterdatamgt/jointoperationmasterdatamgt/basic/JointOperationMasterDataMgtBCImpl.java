/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationMasterDataMgtBCImpl.java
*@FileTitle : Settlement Item & Account Code List
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.AdjustSettlementVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.ProcSettlementVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration.JointOperationMasterDataMgtDBDAO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.AuthorityOfficeVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.CarFinanMtrxGrpVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.CarFinanMtrxVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.CarrierVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.CusBzcAgmtVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.CustomSearchOfficeMappingManagementVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.MstComInputVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.STLItemAcctVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.StlBssPortVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.TargetVVDVO;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeInfoVO;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeParamVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.JooCrrMrgVO;
import com.clt.syscommon.common.table.JooStlBssPortVO;
import com.clt.syscommon.common.table.JooStlItmAcctVO;
import com.clt.syscommon.common.table.JooStlVvdVO;

/**
 * OPUS-JointOperationMasterDataMgtSC Business Logic Basic Command implementation<br>
 * - OPUS-JointOperationMasterDataMgtSC: handling business logic<br>
 *
 * @author
 * @see UI_JOO_0028EventResponse,JointOperationMasterDataMgtBC DAO class
 * @since J2EE 1.4
 */

public class JointOperationMasterDataMgtBCImpl extends BasicCommandSupport implements JointOperationMasterDataMgtBC {

	// Database Access Object
	private transient JointOperationMasterDataMgtDBDAO dbDao = null;

	/**
	 * JointOperationMasterDataMgtBCImpl object creation<br>
	 * JointOperationMasterDataMgtBCDBDAO creation<br>
	 */
	public JointOperationMasterDataMgtBCImpl() {
		dbDao = new JointOperationMasterDataMgtDBDAO();
	}

	/**
	 * retrieving Account Item List
	 * @return List<STLItemAcctVO>
	 * @throws EventException
	 */
	public List<STLItemAcctVO> searchSTLItemAcctList() throws EventException {
		try {
			return dbDao.searchSTLItemAcctList();
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement Item", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement Item", "Retrieve"}).getMessage(), ex);
		}
	}

	/**
	 * saving Settlement Item 
	 * @param STLItemAcctVO[] sTLItemAcctVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void manageSTLItemAcct(STLItemAcctVO[] sTLItemAcctVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		try {
			JooStlItmAcctVO rJooStlItmAcctVO = null;
			JooStlItmAcctVO eJooStlItmAcctVO = null;
			
			for ( int i=0; i<sTLItemAcctVOs.length; i++ ) {
				//1이면 Y, 0이면 N
				String joAutoCreFlg = "1".equals(sTLItemAcctVOs[i].getJoAutoCreFlg())?"Y":"N";
				String joMnlCreFlg  = "1".equals(sTLItemAcctVOs[i].getJoMnlCreFlg ())?"Y":"N";
				
				sTLItemAcctVOs[i].setJoAutoCreFlg(joAutoCreFlg);
				sTLItemAcctVOs[i].setJoMnlCreFlg (joMnlCreFlg);
				sTLItemAcctVOs[i].setUsrId(signOnUserAccount.getUsr_id());
				
				rJooStlItmAcctVO = makeJooStlItmAcctVOBySTLItemAcctVO(sTLItemAcctVOs[i], "R");
				eJooStlItmAcctVO = makeJooStlItmAcctVOBySTLItemAcctVO(sTLItemAcctVOs[i], "E");
				
				if ( sTLItemAcctVOs[i].getIbflag().equals("I")){
					
					dbDao.addJooStlItm(sTLItemAcctVOs[i]);
					
					
					dbDao.addJooStlItmAcct(rJooStlItmAcctVO);

					
					dbDao.addJooStlItmAcct(eJooStlItmAcctVO);
				} else if ( sTLItemAcctVOs[i].getIbflag().equals("U")){
					
					dbDao.modifyJooStlItm(sTLItemAcctVOs[i]);
					
					
					dbDao.modifyJooStlItmAcct(rJooStlItmAcctVO);

					
					dbDao.modifyJooStlItmAcct(eJooStlItmAcctVO);
				} else if ( sTLItemAcctVOs[i].getIbflag().equals("D")){					
					
					dbDao.removeJooStlItmAcct(rJooStlItmAcctVO);

					
					dbDao.removeJooStlItmAcct(eJooStlItmAcctVO);

					
					dbDao.removeJooStlItm(sTLItemAcctVOs[i]);
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement Item", "Save"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement Item", "Save"}).getMessage(), ex);
		}
	}

	/**
	 * retrieving Financial Matrix
	 * @param CarrierVO carrierVO
	 * @return CarFinanMtrxGrpVO
	 * @throws EventException
	 */
	public CarFinanMtrxGrpVO searchCarFinancialMtrxList(CarrierVO carrierVO) throws EventException {
		CarFinanMtrxGrpVO grpVO = new CarFinanMtrxGrpVO();
		try {
			CarrierVO rtnCarrierVO = dbDao.searchCarCustVndrCd(carrierVO);;
			carrierVO.setReDivrCd("R"); //REVENUE 조회
			List<CarFinanMtrxVO> rCarFinanMtrxVOs = dbDao.searchFinanMtrxList(carrierVO);
			carrierVO.setReDivrCd("E"); //EXPENSE 조회
			List<CarFinanMtrxVO> eCarFinanMtrxVOs = dbDao.searchFinanMtrxList(carrierVO);

			grpVO.setCarrierVO(rtnCarrierVO);
			grpVO.setECarFinanMtrxVOs(eCarFinanMtrxVOs);
			grpVO.setRCarFinanMtrxVOs(rCarFinanMtrxVOs);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Financial Matrix", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Financial Matrix", "Retrieve"}).getMessage(), ex);
		}
		return grpVO;
	}

	/**
	 * retrieving settlement item not exists to create finance matrix
	 * @param CarrierVO carrierVO
	 * @return CarFinanMtrxGrpVO
	 * @throws EventException
	 */
	public CarFinanMtrxGrpVO calCarFinancialMtrx(CarrierVO carrierVO) throws EventException {
		CarFinanMtrxGrpVO grpVO = new CarFinanMtrxGrpVO();
		try {
			if (carrierVO.getCustSeq() != null && !"".equals(carrierVO.getCustSeq())){
				carrierVO.setReDivrCd("R"); 
				List<CarFinanMtrxVO> rCarFinanMtrxVOs = dbDao.searchCalFinanMtrxList(carrierVO);
				grpVO.setRCarFinanMtrxVOs(rCarFinanMtrxVOs);
			}
			if (carrierVO.getVndrSeq() != null && !"".equals(carrierVO.getVndrSeq())){
				carrierVO.setReDivrCd("E"); 
				List<CarFinanMtrxVO> eCarFinanMtrxVOs = dbDao.searchCalFinanMtrxList(carrierVO);
				grpVO.setECarFinanMtrxVOs(eCarFinanMtrxVOs);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Financial Matrix", "Create"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Financial Matrix", "Create"}).getMessage(), ex);
		}
		return grpVO;
	}

	/**
	 * saving Financial Matrix
	 * @param CarFinanMtrxGrpVO carFinanMtrxGrpVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void manageCarFinancialMtrx(CarFinanMtrxGrpVO carFinanMtrxGrpVO, SignOnUserAccount signOnUserAccount) throws EventException{
		try {
			
			CarrierVO carrierVO = carFinanMtrxGrpVO.getCarrierVO();

			boolean revDel = false;
			boolean expDel = false;
			
			if (carrierVO != null){
				
				carrierVO.setUsrId(signOnUserAccount.getUsr_id());

				int rtnVal = dbDao.addJooCarrier(carrierVO);
				
				
				if (rtnVal == 1){
					dbDao.modifyJooCarrier(carrierVO);
				}
				revDel = (carrierVO.getCustSeq() == null || "".equals(carrierVO.getCustSeq()));
				expDel = (carrierVO.getVndrSeq() == null || "".equals(carrierVO.getVndrSeq()));				
			}
			
			List<CarrierVO> list = null;
			
			
			if (carrierVO != null && "Y".equals(carrierVO.getDeltFlg())){
				carrierVO.setReDivrCd(""); 
				
				
				list = dbDao.searchChkVvdForDelCar(carrierVO);
				
				if (!list.isEmpty()){
					throw new EventException(new ErrorHandler("JOO10010").getMessage());
				}
				dbDao.removeJooFincMtxByCarrierLane(carrierVO);
			}else{
				
				List<CarFinanMtrxVO> revVOs = (List<CarFinanMtrxVO>)carFinanMtrxGrpVO.getRCarFinanMtrxVOs();
				List<CarFinanMtrxVO> expVOs = (List<CarFinanMtrxVO>)carFinanMtrxGrpVO.getECarFinanMtrxVOs();
				
				if (revDel){
					carrierVO.setReDivrCd("R"); 

					
					list = dbDao.searchChkVvdForDelCar(carrierVO);
					
					if (!list.isEmpty()){
						throw new EventException(new ErrorHandler("JOO10010").getMessage());
					}
					dbDao.removeJooFincMtxByCarrierLane(carrierVO);
				}else{
					if (revVOs != null){
						Iterator itr = (Iterator) revVOs.iterator();
						while(itr.hasNext()){
							CarFinanMtrxVO revVO = (CarFinanMtrxVO)itr.next();
							revVO.setUsrId   (signOnUserAccount.getUsr_id());
							
							if ("I".equals(revVO.getIbflag())){
								dbDao.addJooFincMtx(revVO);
							}else if("U".equals(revVO.getIbflag())){
								dbDao.modifyJooFincMtx(revVO);
							}else if("D".equals(revVO.getIbflag())){
								dbDao.removeJooFincMtx(revVO);
							}
						}
					}
				}
	
				if (expDel){
					carrierVO.setReDivrCd("E"); 
					
					list = dbDao.searchChkVvdForDelCar(carrierVO);
					
					if (!list.isEmpty()){
						throw new EventException(new ErrorHandler("JOO10010").getMessage());
					}
					dbDao.removeJooFincMtxByCarrierLane(carrierVO);
				}else{
					if (expVOs != null){
						Iterator itr = (Iterator) expVOs.iterator();
						while(itr.hasNext()){
							CarFinanMtrxVO expVO = (CarFinanMtrxVO)itr.next();
							expVO.setUsrId   (signOnUserAccount.getUsr_id());
							if ("I".equals(expVO.getIbflag())){
								dbDao.addJooFincMtx(expVO);
							}else if("U".equals(expVO.getIbflag())){
								dbDao.modifyJooFincMtx(expVO);
							}else if("D".equals(expVO.getIbflag())){
								dbDao.removeJooFincMtx(expVO);
							}
						}
					}
				}
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Financial Matrix", "Save"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Financial Matrix", "Save"}).getMessage(), ex);
		}
	}

	/**
	 * retrieving Carrier Merge
	 * @param MstComInputVO mstComInputVO
	 * @return List<JooCrrMrgVO>
	 * @throws EventException
	 */
	public List<JooCrrMrgVO> searchCarrierMerge(MstComInputVO mstComInputVO) throws EventException {
		try {
			return dbDao.searchCarrierMerge(mstComInputVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Carrier Merge", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Carrier Merge", "Retrieve"}).getMessage(), ex);

		}
	}

	/**
	 * saving Carrier Merge
	 * @param JooCrrMrgVO[] jooCrrMrgVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void manageCarrierMerge(JooCrrMrgVO[] jooCrrMrgVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		try {
			List<JooCrrMrgVO> insertVoList = new ArrayList<JooCrrMrgVO>();
			List<JooCrrMrgVO> updateVoList = new ArrayList<JooCrrMrgVO>();
			List<JooCrrMrgVO> deleteVoList = new ArrayList<JooCrrMrgVO>();
			
			for (int inx=0; inx<jooCrrMrgVOs.length; inx++){
				if ("I".equals(jooCrrMrgVOs[inx].getIbflag())){
					jooCrrMrgVOs[inx].setCreUsrId(signOnUserAccount.getUsr_id());
					jooCrrMrgVOs[inx].setUpdUsrId(signOnUserAccount.getUsr_id());
					insertVoList.add(jooCrrMrgVOs[inx]);
				}else if("U".equals(jooCrrMrgVOs[inx].getIbflag())){
					jooCrrMrgVOs[inx].setUpdUsrId(signOnUserAccount.getUsr_id());
					updateVoList.add(jooCrrMrgVOs[inx]);
				}else if("D".equals(jooCrrMrgVOs[inx].getIbflag())){
					deleteVoList.add(jooCrrMrgVOs[inx]);
				}
			}

			if ( insertVoList.size() > 0 ) {
				dbDao.addCarrierMergeS(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyCarrierMergeS(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeCarrierMergeS(deleteVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Carrier Merge", "Save"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Carrier Merge", "Save"}).getMessage(), ex);
		}
	}
	
	/**
	 * retrieving Service Provider/Customer of carrier
	 * @param CarrierVO carrierVO
	 * @return List<CarrierVO>
	 * @throws EventException
	 */
	public List<CarrierVO> searchVndrCustListByCar(CarrierVO carrierVO) throws EventException {
		try {
			return dbDao.searchVndrCustListByCar(carrierVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Service Provider and Customer's Information of Carrier", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Service Provider and Customer's Information of Carrier", "Retrieve"}).getMessage(), ex);
		}
	}

	/**
	 * retrieving Basic Port List
	 * @param MstComInputVO mstComInputVO
	 * @param String lsAbbr
	 * @param String lsDir
	 * @return List<StlBssPortVO>
	 * @throws EventException
	 */
	public List<StlBssPortVO> searchSettlementBasicPortList(MstComInputVO mstComInputVO, String lsAbbr, String lsDir) throws EventException {
		try {
			return dbDao.searchSettlementBasicPortList(mstComInputVO, lsAbbr, lsDir);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Basic Port", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Basic Port", "Retrieve"}).getMessage(), ex);
		}
	}

	/**
	 * saving Basic Port
	 * @param JooStlBssPortVO[] jooStlBssPortVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @return int
	 * @throws EventException
	 */
	public int manageSettlementBasicPort(JooStlBssPortVO[] jooStlBssPortVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		int rtnVal = 0;
		try {
			List<JooStlBssPortVO> insertVoList = new ArrayList<JooStlBssPortVO>();
			List<JooStlBssPortVO> updateVoList = new ArrayList<JooStlBssPortVO>();
			List<JooStlBssPortVO> deleteVoList = new ArrayList<JooStlBssPortVO>();
			
			for (int inx=0; inx<jooStlBssPortVOs.length; inx++){
				if ("I".equals(jooStlBssPortVOs[inx].getIbflag())){
					
					if (inx==0){
						CarrierVO carrierVO = new CarrierVO();
						List<CarrierVO> list = null;
						carrierVO.setJoCrrCd(jooStlBssPortVOs[inx].getJoCrrCd());
						carrierVO.setTrdCd  (jooStlBssPortVOs[inx].getTrdCd  ());
						carrierVO.setRlaneCd(jooStlBssPortVOs[inx].getRlaneCd());
						
						list = dbDao.searchCarrierList(carrierVO);
						
						
						if (list.isEmpty()){
							rtnVal = 999;
							return rtnVal;
						}
					}
					jooStlBssPortVOs[inx].setCreUsrId(signOnUserAccount.getUsr_id());
					jooStlBssPortVOs[inx].setUpdUsrId(signOnUserAccount.getUsr_id());
					insertVoList.add(jooStlBssPortVOs[inx]);
				}else if("U".equals(jooStlBssPortVOs[inx].getIbflag())){
					jooStlBssPortVOs[inx].setUpdUsrId(signOnUserAccount.getUsr_id());
					updateVoList.add(jooStlBssPortVOs[inx]);
				}else if("D".equals(jooStlBssPortVOs[inx].getIbflag())){
					deleteVoList.add(jooStlBssPortVOs[inx]);
				}
			}

			if ( insertVoList.size() > 0 ) {
				rtnVal = dbDao.addSettlementBasicPort(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifySettlementBasicPort(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeSettlementBasicPort(deleteVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Basic Port", "Save"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Basic Port", "Save"}).getMessage(), ex);
		}
		
		return rtnVal;
	}

	/**
	 * creating data again in case of duplication
	 * @param JooStlBssPortVO[] jooStlBssPortVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void manageCopyBasicPort(JooStlBssPortVO[] jooStlBssPortVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		try {
			List<JooStlBssPortVO> insertVoList = new ArrayList<JooStlBssPortVO>();
			
			for (int inx=0; inx<jooStlBssPortVOs.length; inx++){
				if ("I".equals(jooStlBssPortVOs[inx].getIbflag())){
					jooStlBssPortVOs[inx].setCreUsrId(signOnUserAccount.getUsr_id());
					jooStlBssPortVOs[inx].setUpdUsrId(signOnUserAccount.getUsr_id());
					insertVoList.add(jooStlBssPortVOs[inx]);
				}
			}

			if ( insertVoList.size() > 0 ) {
				
				dbDao.removeSettlementBasicPort(insertVoList);
				dbDao.addSettlementBasicPort   (insertVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Basic Port", "Save"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Basic Port", "Save"}).getMessage(), ex);
		}
	}
	
	/**
	 * retrieving Basic Port to create
	 * @param MstComInputVO mstComInputVO
	 * @return List<StlBssPortVO>
	 * @throws EventException
	 */
	public List<StlBssPortVO> searchItemDirList(MstComInputVO mstComInputVO) throws EventException {
		try {
			return dbDao.searchItemDirList(mstComInputVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Basic Port", "Create"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Basic Port", "Create"}).getMessage(), ex);
		}
	}

	/**
	 * retrieving Target VVD 
	 * @param TargetVVDVO targetVVDVO
	 * @return List<TargetVVDVO>
	 * @throws EventException
	 */
	public List<TargetVVDVO> searchTargetVVDList(TargetVVDVO targetVVDVO) throws EventException {
		try {
			return dbDao.searchTargetVVDList(targetVVDVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Target VVD", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Target VVD", "Retrieve"}).getMessage(), ex);
		}
	}

	/**
	 * retrieving Target VVD to create
	 * @param TargetVVDVO targetVVDVO
	 * @param String joStlOptCd
	 * @return List<TargetVVDVO>
	 * @throws EventException
	 */
	public List<TargetVVDVO> createTargetVVDList(TargetVVDVO targetVVDVO, String joStlOptCd) throws EventException {
		try {
			return dbDao.searchSKDVVDList(targetVVDVO, joStlOptCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Target VVD", "Create"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Target VVD", "Create"}).getMessage(), ex);
		}
	}

	/**
	 * saving Target VVD
	 * @param JooStlVvdVO[] jooStlVvdVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void manageTargetVVD(JooStlVvdVO[] jooStlVvdVOs, SignOnUserAccount signOnUserAccount) throws EventException{

		try {
			List<JooStlVvdVO> insertVoList = new ArrayList<JooStlVvdVO>();
			List<JooStlVvdVO> updateVoList = new ArrayList<JooStlVvdVO>();
			List<JooStlVvdVO> deleteVoList = new ArrayList<JooStlVvdVO>();
			List<JooStlVvdVO> list = null;
			
			String ibflag = "";
			for (int inx=0; inx<jooStlVvdVOs.length; inx++){
				ibflag = jooStlVvdVOs[inx].getIbflag();
				if ("I".equals(ibflag)){
					jooStlVvdVOs[inx].setCreUsrId(signOnUserAccount.getUsr_id());
					jooStlVvdVOs[inx].setUpdUsrId(signOnUserAccount.getUsr_id());
					insertVoList.add(jooStlVvdVOs[inx]);
				}else if("U".equals(ibflag)){
					jooStlVvdVOs[inx].setUpdUsrId(signOnUserAccount.getUsr_id());
					updateVoList.add(jooStlVvdVOs[inx]);
				}else if("D".equals(ibflag)){
					deleteVoList.add(jooStlVvdVOs[inx]);
				}
			}

			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeTargetVVD(deleteVoList);
			}

			if ( insertVoList.size() > 0 ) {
				for (int inx=0; inx<insertVoList.size(); inx++){
					//Duplicate Check
					list = dbDao.searchTargetVvdDup(insertVoList.get(inx));					
					if (!list.isEmpty()){
						throw new EventException(new ErrorHandler("JOO10008").getMessage());
					}
					//Financial Matrix Item Check
					list = dbDao.searchFincMtxItmForStlVvdList(insertVoList.get(inx));
					if (list.isEmpty()){
						throw new EventException(new ErrorHandler("JOO10011", insertVoList.get(inx).getJoStlItmCd()).getMessage());
					}
					
					dbDao.addTargetVVD(insertVoList.get(inx));
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				for (int inx=0; inx<updateVoList.size(); inx++){
					//Duplicate Check
					list = dbDao.searchTargetVvdDup(updateVoList.get(inx));					
					if (!list.isEmpty()){
						throw new EventException(new ErrorHandler("JOO10008").getMessage());
					}
					//Financial Matrix Item Check
					list = dbDao.searchFincMtxItmForStlVvdList(updateVoList.get(inx));
					if (list.isEmpty()){
						throw new EventException(new ErrorHandler("JOO10011", updateVoList.get(inx).getJoStlItmCd()).getMessage());
					}
				}
				dbDao.modifyTargetVVD(updateVoList);
			}
			
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Target VVD", "Save"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err ===>" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Target VVD", "Save"}).getMessage(), ex);
		}
	}

	/**
	 * retrieving jo_mnu_nm in jo_stl_tgt_tp_cd of Basic Port
	 * @param JooStlVvdVO jooStlVvdVO
	 * @return List<JooStlVvdVO>
	 * @throws EventException
	 */
	public List<JooStlVvdVO> searchOusTdrRdrInBssPort(JooStlVvdVO jooStlVvdVO) throws EventException {
		try {
			return dbDao.searchOusTdrRdrInBssPort(jooStlVvdVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Target VVD", "Search Settlement Type of OUS"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Target VVD", "Search Settlement Type of OUS"}).getMessage(), ex);
		}
	}

	/**
	 * updating PROC_JP_FLG = 'Y' in case of settlement
	 * @param ProcSettlementVO[] procSettlementVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void manageTargetVVDForSettlement(ProcSettlementVO[] procSettlementVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		try {
			List<ProcSettlementVO> updateVoList = new ArrayList<ProcSettlementVO>();

			String ibFlag = "";
			
			for (int inx=0; inx<procSettlementVOs.length; inx++){
				ibFlag = procSettlementVOs[inx].getIbflag();
				if ("I".equals(ibFlag) || "D".equals(ibFlag)){
					procSettlementVOs[inx].setUpdUsrId(signOnUserAccount.getUsr_id());
					updateVoList.add(procSettlementVOs[inx]);
				}
			}
			if (updateVoList.size() > 0)
				dbDao.modifyJooStlVVDForSettlement(updateVoList);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement Process", "Update Flag of Target VVD"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement Process", "Update Flag of Target VVD"}).getMessage(), ex);
		}
	}

	/**
	 * mapping STLItemAcctVO to JooStlItmAcctVO
	 * @param STLItemAcctVO sTLItemAcctVO
	 * @param String reDivrCd
	 * @return JooStlItmAcctVO
	 * @throws Exception
	 */
	private JooStlItmAcctVO makeJooStlItmAcctVOBySTLItemAcctVO(STLItemAcctVO sTLItemAcctVO, String reDivrCd) throws Exception{
		JooStlItmAcctVO jooStlItmAcctVO = new JooStlItmAcctVO();

		jooStlItmAcctVO.setReDivrCd(reDivrCd);
		jooStlItmAcctVO.setJoStlItmCd(sTLItemAcctVO.getJoStlItmCd());
		if ("R".equals(reDivrCd)){
			jooStlItmAcctVO.setCrAcctCd(sTLItemAcctVO.getRCrAcctCd());
			jooStlItmAcctVO.setDrAcctCd(sTLItemAcctVO.getRDrAcctCd());
			jooStlItmAcctVO.setJoEstmAcctCd(sTLItemAcctVO.getREsAcctCd());
		}else{
			jooStlItmAcctVO.setCrAcctCd(sTLItemAcctVO.getECrAcctCd());
			jooStlItmAcctVO.setDrAcctCd(sTLItemAcctVO.getEDrAcctCd());
			jooStlItmAcctVO.setJoEstmAcctCd(sTLItemAcctVO.getEEsAcctCd());
		}
		jooStlItmAcctVO.setUpdUsrId(sTLItemAcctVO.getUsrId());
		return jooStlItmAcctVO;
	}

    /**
     * retrieving authority of Authority Office Creation
     * @param  AuthorityOfficeVO authorityOfficeVO
     * @return List<AuthorityOfficeVO>
     * @throws EventException
     */
    public List<AuthorityOfficeVO> searchAuthorityOffice(AuthorityOfficeVO authorityOfficeVO) throws EventException{
        try {
            return dbDao.searchAuthorityOffice(authorityOfficeVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Authority Office", "Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Authority Office", "Retrieve"}).getMessage(), ex);
        }
    }
	/**
     * saving locale authrity of Authority Office Creation
     * @param  AuthorityOfficeVO[] authorityOfficeVOs
     * @param  SignOnUserAccount signOnUserAccount
     * @throws EventException
     */
    public void manageAuthorityOffice(AuthorityOfficeVO[] authorityOfficeVOs,      
            SignOnUserAccount signOnUserAccount) throws EventException {
        try{
            List<AuthorityOfficeVO> removeVoList = new ArrayList<AuthorityOfficeVO>();
            List<AuthorityOfficeVO> insertVoList = new ArrayList<AuthorityOfficeVO>();            
            for( int i=0;i< authorityOfficeVOs.length;i++){
                authorityOfficeVOs[i].setCreUsrId( signOnUserAccount.getUsr_id() );
                removeVoList.add ( authorityOfficeVOs[i]  );
                insertVoList.add ( authorityOfficeVOs[i]  );
            }
            if ( insertVoList.size() > 0 ) {
                dbDao.removeAuthorityOffice(removeVoList);
                dbDao.addAuthorityOffice   (insertVoList);
            }
 
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Authority Office", "Creation"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Authority Office", "Creation"}).getMessage(), ex);
        }
  
    }

    /**
     * creating VVD not exists in target VVD
     * @param AdjustSettlementVO[] adjustSettlementVOs
     * @param SignOnUserAccount signOnUserAccount
     * @throws EventException
     */
	public void manageTargetVVDForAdjustment(AdjustSettlementVO[] adjustSettlementVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		try {
			AdjustSettlementVO adjustSettlementVO = null;
			List<AdjustSettlementVO> adjStls = null;
			JooStlVvdVO targetVVDVO = null; 
			
			for (int i=0; i<adjustSettlementVOs.length; i++){
				adjustSettlementVO = adjustSettlementVOs[i];
				
				
				if (adjustSettlementVO.getJoStlJbCd() == null || "".equals(adjustSettlementVO.getJoStlJbCd()))
					continue;
				
				if ("I".equals(adjustSettlementVO.getIbflag())){
					
					adjStls = dbDao.searchStlVvdByVvd(adjustSettlementVO);
					
					
					if (adjStls.size() == 0){
						targetVVDVO = new JooStlVvdVO();
						targetVVDVO.setAcctYrmon (adjustSettlementVO.getAcctYrmon());
						targetVVDVO.setTrdCd     (adjustSettlementVO.getTrdCd     ());
						targetVVDVO.setJoCrrCd   (adjustSettlementVO.getJoCrrCd   ());
						targetVVDVO.setRlaneCd   (adjustSettlementVO.getRlaneCd   ());
						targetVVDVO.setReDivrCd  (adjustSettlementVO.getReDivrCd  ());
						targetVVDVO.setJoStlItmCd(adjustSettlementVO.getJoStlItmCd());
						targetVVDVO.setJoMnuNm   (adjustSettlementVO.getJoMnuNm   ());
						targetVVDVO.setVslCd     (adjustSettlementVO.getVslCd     ());
						targetVVDVO.setSkdVoyNo  (adjustSettlementVO.getSkdVoyNo  ());
						targetVVDVO.setSkdDirCd  (adjustSettlementVO.getSkdDirCd  ());
						targetVVDVO.setRevDirCd  (adjustSettlementVO.getRevDirCd  ());
						targetVVDVO.setJoStlCfmCd("N"); 
						targetVVDVO.setProcJbFlg ("Y"); 
						targetVVDVO.setStlTgtVvdBssCd("A"); 
						targetVVDVO.setCreUsrId  (signOnUserAccount.getUsr_id());
						targetVVDVO.setStlRmk    ("Create for S/H Adjustment");
						
						dbDao.addTargetVVD(targetVVDVO);
					}
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"S/H Adjustment Process", "Insert a new VVD exists COA not JOO"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"S/H Adjustment Process", "Insert a new VVD exists COA not JOO"}).getMessage(), ex);
		}
	}

	/**
	 * retrieving target VVD closing status
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchCloseYn(JooCodeParamVO jooCodeParamVO) throws EventException {
		try {
			return dbDao.searchCloseYn(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Target VVD", "Check close"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Target VVD", "Check close"}).getMessage(), ex);
		}
	}
	
    /**
     * 
     * @param  CustomSearchOfficeMappingManagementVO customSearchOfficeMappingManagementVO
     * @return List<CustomSearchOfficeMappingManagementVO>
     * @throws EventException
     */
//	public List<CustomSearchOfficeMappingManagementVO> searchOfficeMappingManagementList(CustomSearchOfficeMappingManagementVO customSearchOfficeMappingManagementVO) throws EventException 
//	{
//        try {
//            return dbDao.searchOfficeMappingManagementList(customSearchOfficeMappingManagementVO);
//        } catch (DAOException ex) {
//            log.error("err " + ex.toString(), ex);
//            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Office Mapping", "Retrieve"}).getMessage(), ex);
//        } catch (Exception ex) {
//            log.error("err " + ex.toString(), ex);
//            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Office Mapping", "Retrieve"}).getMessage(), ex);
//        }
//    }
	
    /**
     * 
     * @param  CustomSearchOfficeMappingManagementVO[] customSearchOfficeMappingManagementVOs
     * @param  SignOnUserAccount signOnUserAccount
     * @return String
     * @throws EventException
     * @author
     */
//	public String manageOfficeMappingManagement(CustomSearchOfficeMappingManagementVO[] customSearchOfficeMappingManagementVOs, SignOnUserAccount signOnUserAccount) throws EventException {
//
//		StringBuilder rtnVal = new StringBuilder();
//		rtnVal.append("");
//        try{
//    			List<CustomSearchOfficeMappingManagementVO> insertVoList = new ArrayList<CustomSearchOfficeMappingManagementVO>();
//    			List<CustomSearchOfficeMappingManagementVO> updateVoList = new ArrayList<CustomSearchOfficeMappingManagementVO>();
//    			
//    			String ibflag = "";
//				String tmpVal = null;
//
//    			for (int inx=0; inx < customSearchOfficeMappingManagementVOs.length; inx++){
//    				ibflag = customSearchOfficeMappingManagementVOs[inx].getIbflag();
//    				if ("I".equals(ibflag)){
//    					customSearchOfficeMappingManagementVOs[inx].setCreUsrId(signOnUserAccount.getUsr_id());
//    					customSearchOfficeMappingManagementVOs[inx].setUpdUsrId(signOnUserAccount.getUsr_id());
//    					customSearchOfficeMappingManagementVOs[inx].setDeltFlg("N");			
//
//    					//Duplicate Check
//    					tmpVal = "";
//    					tmpVal = dbDao.searchOfficeMappingDupCheck(customSearchOfficeMappingManagementVOs[inx]);    					
//    					
//    					if ("".equals(tmpVal)){  		
//        					insertVoList.add(customSearchOfficeMappingManagementVOs[inx]);
//    					} else {
//    						rtnVal.append(tmpVal + "\n");
//    					}
//    				}else if("U".equals(ibflag)){
//    					customSearchOfficeMappingManagementVOs[inx].setUpdUsrId(signOnUserAccount.getUsr_id());
//    					    					
//    					//Duplicate Check
//	    					tmpVal = "";
//	    					tmpVal = dbDao.searchOfficeMappingDupCheck(customSearchOfficeMappingManagementVOs[inx]);
//	    					
//	    					if ("".equals(tmpVal)){  	
//	    						updateVoList.add(customSearchOfficeMappingManagementVOs[inx]);
//	    					} else {
//	    						rtnVal.append(tmpVal + "\n");
//	    					}
//    				}
//	    			else if("D".equals(ibflag)){
//	    				customSearchOfficeMappingManagementVOs[inx].setUpdUsrId(signOnUserAccount.getUsr_id());
//	    				customSearchOfficeMappingManagementVOs[inx].setDeltFlg("Y");
//    					updateVoList.add(customSearchOfficeMappingManagementVOs[inx]);	    				
//	    			}
//    			}
//    			if ("".equals(rtnVal.toString()) && insertVoList.size() > 0 ) {
//					dbDao.addOfficeMappingManagement(insertVoList);
//    			}
//    			
//    			if ("".equals(rtnVal.toString()) && updateVoList.size() > 0 ) {
//    				dbDao.modifyOfficeMappingManagement(updateVoList);
//    			}
// 
//        } catch (DAOException ex) {
//            log.error("err " + ex.toString(), ex);
//            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Office Mapping", "Save"}).getMessage(), ex);
//        } catch (Exception ex) {
//            log.error("err " + ex.toString(), ex);
//            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Office Mapping", "Save"}).getMessage(), ex);
//        }
//        
//		return rtnVal.toString();
//  
//    }

	/**
	 * deleting target VVD
	 * @param JooStlVvdVO[] jooStlVvdVOs
	 * @throws EventException
	 */
	public void removeTargetVVD(JooStlVvdVO[] jooStlVvdVOs) throws EventException{

		try {
			List<JooStlVvdVO> deleteVoList = new ArrayList<JooStlVvdVO>();

			for (int inx=0; inx<jooStlVvdVOs.length; inx++){
				deleteVoList.add(jooStlVvdVOs[inx]);
			}

			if ( deleteVoList.size() > 0 ) {
				dbDao.removeTargetVVD(deleteVoList);
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Target VVD", "Remove"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err ===>" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Target VVD", "Remove"}).getMessage(), ex);
		}
	}

//	/**
//	 * 
//	 * @param CusBzcAgmtVO[] cusBzcAgmtVOs
//	 * @param SignOnUserAccount signOnUserAccount
//	 * @return String
//	 * @throws EventException
//	 */
//	public String manageJooBzcAgmt(CusBzcAgmtVO[] cusBzcAgmtVOs, SignOnUserAccount signOnUserAccount) throws EventException{
//		String rtnVal = "";
//		try {
//			List<CusBzcAgmtVO> updateVoList = new ArrayList<CusBzcAgmtVO>();
//			List<CusBzcAgmtVO> list = new ArrayList<CusBzcAgmtVO>();
//			String ibflag = "";
//			for (int inx=0; inx<cusBzcAgmtVOs.length; inx++){
//				ibflag = cusBzcAgmtVOs[inx].getIbflag();
//				
//				if (!"D".equals(ibflag)){
//					list = dbDao.searchOverlappedRefNoList(cusBzcAgmtVOs[inx]);
//					if (!list.isEmpty()){
//						rtnVal = "Office ["+cusBzcAgmtVOs[inx].getOfcCd()+"]\n"
//						       + "R/E    ["+cusBzcAgmtVOs[inx].getReDivrCd()+"]\n"
//						       + "Trade  ["+cusBzcAgmtVOs[inx].getTrdCd()+"]\n"
//						       + "Lane   ["+cusBzcAgmtVOs[inx].getRlaneCd()+"]\n"
//						       + "Carrier["+cusBzcAgmtVOs[inx].getJoCrrCd()+"]\n"
//						       + "From   ["+cusBzcAgmtVOs[inx].getAgmtEffDt()+"]\n"
//						       + "To     ["+cusBzcAgmtVOs[inx].getAgmtExpDt()+"]\n\n"
//						       + "is overlapped by\n\n"
//						       + "Ref No ["+list.get(0).getJoRefNo()+"]\n"
//						       + "Period ["+list.get(0).getAgmtEffDt()+" ~ "+list.get(0).getAgmtExpDt()+"]"
//						;
//						break;
//					}
//				}
//				if ("I".equals(ibflag)){
//					String joRefNo  = cusBzcAgmtVOs[inx].getJoRefNo();
//					String joRefSeq = "1";
//					
//					if ("".equals(joRefNo)){
//						
//						list = dbDao.searchRefNo(cusBzcAgmtVOs[inx]);
//						if (list.isEmpty()){
//							joRefNo = dbDao.searchNextJoRefNo(cusBzcAgmtVOs[inx]);
//						}else{
//							
//							joRefNo  = list.get(0).getJoRefNo ();
//						}
//					}
//					cusBzcAgmtVOs[inx].setJoRefNo (joRefNo);
//					joRefSeq = dbDao.searchNextJoRefSeq(cusBzcAgmtVOs[inx]);
//					cusBzcAgmtVOs[inx].setJoRefSeq(joRefSeq);
//					cusBzcAgmtVOs[inx].setCreUsrId(signOnUserAccount.getUsr_id());
//					cusBzcAgmtVOs[inx].setUpdUsrId(signOnUserAccount.getUsr_id());
//					dbDao.addJooBzcAgmt(cusBzcAgmtVOs[inx]);
//					
//					
//					dbDao.modifyJooBzcAgmtPeriod(cusBzcAgmtVOs[inx]);
//				}else if("U".equals(ibflag)){
//					cusBzcAgmtVOs[inx].setUpdUsrId(signOnUserAccount.getUsr_id());
//					
//					dbDao.modifyJooBzcAgmtPeriod(cusBzcAgmtVOs[inx]);
//					updateVoList.add(cusBzcAgmtVOs[inx]);
//				}else if("D".equals(ibflag)){
//					cusBzcAgmtVOs[inx].setDeltFlg ("Y");
//					cusBzcAgmtVOs[inx].setUpdUsrId(signOnUserAccount.getUsr_id());
//					updateVoList.add(cusBzcAgmtVOs[inx]);
//				}
//			}
//
//			if ( updateVoList.size() > 0 ) {
//				dbDao.modifyJooBzcAgmt(updateVoList);
//			}
//		} catch (EventException ex) {
//			log.error("err " + ex.toString(), ex);
//			throw ex;
//		} catch (DAOException ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Basic Information for Loading Summary", "Save"}).getMessage(), ex);
//		} catch (Exception ex) {
//			log.error("err ===>" + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Basic Information for Loading Summary", "Save"}).getMessage(), ex);
//		}
//		return rtnVal;
//	}

//	/**
//	 * 
//	 * @param CusBzcAgmtVO cusBzcAgmtVO
//	 * @return List<CusBzcAgmtVO>
//	 * @throws EventException
//	 */
//	public List<CusBzcAgmtVO> searchJooBzcAgmtList(CusBzcAgmtVO cusBzcAgmtVO) throws EventException {
//		try {
//			return dbDao.searchJooBzcAgmtList(cusBzcAgmtVO);
//		} catch (DAOException ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Business Agreement", "Retrieve"}).getMessage(), ex);
//		} catch (Exception ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Business Agreement", "Retrieve"}).getMessage(), ex);
//		}
//	}

//	/**
//	 * 
//	 * @param JooCodeParamVO jooCodeParamVO
//	 * @return List<JooCodeInfoVO>
//	 * @throws EventException
//	 */
//	public List<JooCodeInfoVO> searchRefNoList(JooCodeParamVO jooCodeParamVO) throws EventException {
//		try {
//			return dbDao.searchRefNoList(jooCodeParamVO);
//		} catch (DAOException ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Business Agreement Reference Number", "Retrieve"}).getMessage(), ex);
//		} catch (Exception ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Business Agreement Reference Number", "Retrieve"}).getMessage(), ex);
//		}
//	}

//	/**
//	 * 
//	 * @param CusBzcAgmtVO cusBzcAgmtVO
//	 * @return List<CusBzcAgmtVO>
//	 * @throws EventException
//	 */
//	public List<CusBzcAgmtVO> searchRefNoNPeriod(CusBzcAgmtVO cusBzcAgmtVO) throws EventException {
//		try {
//			return dbDao.searchRefNoNPeriod(cusBzcAgmtVO);
//		} catch (DAOException ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Business Agreement", "Retrieve"}).getMessage(), ex);
//		} catch (Exception ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Business Agreement", "Retrieve"}).getMessage(), ex);
//		}
//	}
}