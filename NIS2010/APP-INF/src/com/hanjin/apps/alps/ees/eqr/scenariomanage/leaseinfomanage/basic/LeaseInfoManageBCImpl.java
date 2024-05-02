/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LeaseInfoManageBCImpl.java
*@FileTitle : ST On-Hire
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.07.27 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.leaseinfomanage.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.leaseinfomanage.integration.LeaseInfoManageDBDAO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.leaseinfomanage.vo.EesEqr0017ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.leaseinfomanage.vo.EesEqr0085ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.leaseinfomanage.vo.EesEqr0086ConditionVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.EqrScnrLongTermOffhCondVO;
import com.hanjin.syscommon.common.table.EqrScnrShrtTermOffhCondVO;
import com.hanjin.syscommon.common.table.EqrScnrShrtTermOnhCondVO;

/**
 * ALPS-LeaseInfoManage Business Logic Basic Command implementation<br>
 * - ALPS-LeaseInfoManage 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Haeng-ji,Lee
 * @see EES_EQR_0017EventResponse,LeaseInfoManageBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class LeaseInfoManageBCImpl extends BasicCommandSupport implements LeaseInfoManageBC {

	// Database Access Object
	private transient LeaseInfoManageDBDAO dbDao = null;

	/**
	 * LeaseInfoManageBCImpl 객체 생성<br>
	 * LeaseInfoManageDBDAO를 생성한다.<br>
	 */
	public LeaseInfoManageBCImpl() {
		dbDao = new LeaseInfoManageDBDAO();
	}
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param eesEqr0017ConditionVO EesEqr0017ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchSTOnHireInfo(EesEqr0017ConditionVO eesEqr0017ConditionVO) throws EventException {
		try {
			return dbDao.searchSTOnHireInfo(eesEqr0017ConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param eqrScnrShrtTermOnhCondVO EqrScnrShrtTermOnhCondVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifySTOnHireinfo(EqrScnrShrtTermOnhCondVO[] eqrScnrShrtTermOnhCondVO, SignOnUserAccount account) throws EventException{
		try {
			List<EqrScnrShrtTermOnhCondVO> insertVoList = new ArrayList<EqrScnrShrtTermOnhCondVO>();
			List<EqrScnrShrtTermOnhCondVO> updateVoList = new ArrayList<EqrScnrShrtTermOnhCondVO>();
			List<EqrScnrShrtTermOnhCondVO> deleteVoList = new ArrayList<EqrScnrShrtTermOnhCondVO>();
			
			String ecc_cd		= null;
			String scnr_id		= null;
			String cntr_tpsz	= null;
			boolean checkEccMst		= false;
			boolean checkSTOnHire	= false;
			
			for ( int i=0; i<eqrScnrShrtTermOnhCondVO .length; i++ ) {
				ecc_cd		= eqrScnrShrtTermOnhCondVO[i].getEccCd();
				scnr_id		= eqrScnrShrtTermOnhCondVO[i].getScnrId();
				cntr_tpsz	= eqrScnrShrtTermOnhCondVO[i].getCntrTpszCd();
				
				if ( eqrScnrShrtTermOnhCondVO[i].getIbflag().equals("I")){					
					checkEccMst		= dbDao.insertUpdateHireECCChk(ecc_cd);
					checkSTOnHire	= dbDao.insertUpdateChkOnHire(scnr_id, ecc_cd, cntr_tpsz);
					
					if ( checkEccMst &&  checkSTOnHire ){
						eqrScnrShrtTermOnhCondVO[i].setCreUsrId(account.getUsr_id());
						eqrScnrShrtTermOnhCondVO[i].setUpdUsrId(account.getUsr_id());
						insertVoList.add(eqrScnrShrtTermOnhCondVO[i]);
					} else {
						String[] errMessage ={"", ""};
						throw new DAOException(new ErrorHandler("EQR10025", errMessage).getMessage());
					}
				} else if ( eqrScnrShrtTermOnhCondVO[i].getIbflag().equals("U")){
					
					checkEccMst		= dbDao.insertUpdateHireECCChk(ecc_cd);
					checkSTOnHire	= dbDao.insertUpdateChkOnHire(scnr_id, ecc_cd, cntr_tpsz);
					
					if ( checkEccMst &&  checkSTOnHire ){
						eqrScnrShrtTermOnhCondVO[i].setCreUsrId(account.getUsr_id());
						eqrScnrShrtTermOnhCondVO[i].setUpdUsrId(account.getUsr_id());
						insertVoList.add(eqrScnrShrtTermOnhCondVO[i]);
					} else {
						eqrScnrShrtTermOnhCondVO[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(eqrScnrShrtTermOnhCondVO[i]);
					}
				} else if ( eqrScnrShrtTermOnhCondVO[i].getIbflag().equals("D")){
					deleteVoList.add(eqrScnrShrtTermOnhCondVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addSTOnHireInfo(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifySTOnHireInfo(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeSTOnHireInfo(deleteVoList);
			}
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param eesEqr0086ConditionVO EesEqr0086ConditionVO
	 * @param ecc_info String
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchLTOffHireInfo(EesEqr0086ConditionVO eesEqr0086ConditionVO ,String ecc_info) throws EventException {
		try {
			return dbDao.searchLTOffHireInfo(eesEqr0086ConditionVO ,ecc_info);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param eqrScnrLongTermOffhCondVO EqrScnrLongTermOffhCondVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyLTOffHireInfo(EqrScnrLongTermOffhCondVO[] eqrScnrLongTermOffhCondVO, SignOnUserAccount account) throws EventException{
		try {
			List<EqrScnrLongTermOffhCondVO> insertVoList = new ArrayList<EqrScnrLongTermOffhCondVO>();
			List<EqrScnrLongTermOffhCondVO> updateVoList = new ArrayList<EqrScnrLongTermOffhCondVO>();
			List<EqrScnrLongTermOffhCondVO> deleteVoList = new ArrayList<EqrScnrLongTermOffhCondVO>();
			String scnr_id         = null;
			String ecc_cd          = null;
			String ctrt_ofc_cty_cd = null;
			String ctrt_seq        = null;
			String cntr_tpsz_cd    = null;
			boolean checkEccMst		= false;
			boolean checkLTOnHire	= false;
			
			log.debug ("=============>" +account.getUsr_id());
			
			for ( int i=0; i<eqrScnrLongTermOffhCondVO .length; i++ ) {
				    scnr_id = eqrScnrLongTermOffhCondVO[i].getScnrId();
				    ecc_cd  = eqrScnrLongTermOffhCondVO[i].getEccCd();
				    ctrt_ofc_cty_cd = eqrScnrLongTermOffhCondVO[i].getCtrtOfcCtyCd().substring(0,3);
				    ctrt_seq = eqrScnrLongTermOffhCondVO[i].getCtrtOfcCtyCd().substring(3,ctrt_seq_SubString(eqrScnrLongTermOffhCondVO[i].getCtrtOfcCtyCd()));
				    cntr_tpsz_cd = eqrScnrLongTermOffhCondVO[i].getCntrTpszCd();
				    
				if ( eqrScnrLongTermOffhCondVO[i].getIbflag().equals("I")){
					checkEccMst		= dbDao.insertUpdateHireECCChk(ecc_cd);
					checkLTOnHire	= dbDao.checkUpdateLTOffHire(scnr_id, ecc_cd ,ctrt_ofc_cty_cd,ctrt_seq, cntr_tpsz_cd);
					if ( checkEccMst &&  checkLTOnHire ){
						eqrScnrLongTermOffhCondVO[i].setCreUsrId(account.getUsr_id());
						eqrScnrLongTermOffhCondVO[i].setUpdUsrId(account.getUsr_id());
						eqrScnrLongTermOffhCondVO[i].setCtrtSeq(ctrt_seq);
						eqrScnrLongTermOffhCondVO[i].setCtrtOfcCtyCd(ctrt_ofc_cty_cd);
						insertVoList.add(eqrScnrLongTermOffhCondVO[i]);
					} else {
						String[] errMessage ={"", ""};
						throw new DAOException(new ErrorHandler("EQR10025", errMessage).getMessage());
					}
					
				} else if ( eqrScnrLongTermOffhCondVO[i].getIbflag().equals("U")){
					checkEccMst		= dbDao.insertUpdateHireECCChk(ecc_cd);
					checkLTOnHire	= dbDao.checkUpdateLTOffHire(scnr_id, ecc_cd ,ctrt_ofc_cty_cd,ctrt_seq, cntr_tpsz_cd);
					
					if ( checkEccMst &&  checkLTOnHire ){
						eqrScnrLongTermOffhCondVO[i].setCreUsrId(account.getUsr_id());
						eqrScnrLongTermOffhCondVO[i].setUpdUsrId(account.getUsr_id());
						eqrScnrLongTermOffhCondVO[i].setCtrtSeq(ctrt_seq);
						eqrScnrLongTermOffhCondVO[i].setCtrtOfcCtyCd(ctrt_ofc_cty_cd);
						insertVoList.add(eqrScnrLongTermOffhCondVO[i]);
					} else {
						eqrScnrLongTermOffhCondVO[i].setUpdUsrId(account.getUsr_id());
						eqrScnrLongTermOffhCondVO[i].setCtrtSeq(ctrt_seq);
						eqrScnrLongTermOffhCondVO[i].setCtrtOfcCtyCd(ctrt_ofc_cty_cd);
						updateVoList.add(eqrScnrLongTermOffhCondVO[i]);
					}
					eqrScnrLongTermOffhCondVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(eqrScnrLongTermOffhCondVO[i]);
				} else if ( eqrScnrLongTermOffhCondVO[i].getIbflag().equals("D")){
					eqrScnrLongTermOffhCondVO[i].setCtrtSeq(ctrt_seq);
					eqrScnrLongTermOffhCondVO[i].setCtrtOfcCtyCd(ctrt_ofc_cty_cd);
					deleteVoList.add(eqrScnrLongTermOffhCondVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.insertLTOffHireInfo(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.updateLTOffHireInfo(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.deleteLTOffHireInfo(deleteVoList);
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
     * LeaseInfoManage의 모든 목록을 가져온다.<br>
     * @param  seq String
     * @return int str
     */   
	public int ctrt_seq_SubString (String seq) {
		int str = 0;
		str = seq.length()-seq.substring(0,3).length() + seq.substring(0,3).length();
		log.info("길이 값==>" + str);
		return str; 
	}

    /**
     * 
     * 화면명 : S/T off-Hire 정보 조회 /수정 - EES_EQR_085 <br>
     * 기능  : 정보 조회  <br>
     * 
     * @param conditionVO EesEqr0085ConditionVO
     * @param eccInfo String
     * @return CommonRsVO
     * @exception EventException
     */
    public CommonRsVO searchSTOffHireInfo(EesEqr0085ConditionVO conditionVO , String eccInfo) throws EventException {   
       
    	CommonRsVO retVO = null;
        try {
        	retVO=dbDao.searchSTOffHireInfo(conditionVO, eccInfo);
            return retVO;
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }
    
    
    /**
     * 화면명 : S/T off-Hire 정보조회 /수정 - EES_EQR_085 <br>
     * 기능   : 저장 , 수정 , 삭제 <br>
     * 
     * @param vos EqrScnrShrtTermOffhCondVO[]
     * @param account SignOnUserAccount
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
	public void modifySTOffHireInfo(EqrScnrShrtTermOffhCondVO[] vos,SignOnUserAccount account) throws EventException {

        String gubun="OffHire";
        
        boolean isInsert = false ;
        boolean isUpdate = false ;
        boolean isDelete = false ;
        try {
        	String user_id = account.getUsr_id();
        	List insModels 	= new ArrayList();
			List updModels 	= new ArrayList();
			List delModels 	= new ArrayList();
			if(vos != null && vos.length > 0){
				for(int i = 0 ; i < vos.length ; i++){
					EqrScnrShrtTermOffhCondVO vo = vos[i];
					if(vo.getIbflag().equals("I")){
						isInsert = true ;
						HashMap<String, Object> param = new HashMap<String, Object>();
						param.put("scnr_id", vo.getScnrId());
						param.put("ecc_cd", vo.getEccCd());
						param.put("ctrt_ofc_cty_cd03", vo.getCtrtOfcCtyCd().substring(0,3));
						param.put("ctrt_ofc_cty_cd", vo.getCtrtOfcCtyCd().substring(3,ctrt_seq_SubString(vo.getCtrtOfcCtyCd())));
						param.put("cntr_tpsz_cd", vo.getCntrTpszCd());
						param.put("aval_cntr_qty", vo.getAvalCntrQty());
						param.put("lft_chg_amt", vo.getLftChgAmt());
						param.put("dryg_amt", vo.getDrygAmt());
						param.put("drff_chg_cr_amt", vo.getDrffChgCrAmt());
						param.put("dflt_usd_dys", vo.getDfltUsdDys());
						param.put("user_id", user_id);
						insModels.add(param);
					}else if(vo.getIbflag().equals("U")){
						if (dbDao.insertUpdateHireECCChk(vo.getScnrId() 
													, vo.getEccCd()
													, vo.getCntrTpszCd()
													, gubun
													, vo.getCtrtOfcCtyCd().substring(0,3)
													, vo.getCtrtOfcCtyCd().substring(3,ctrt_seq_SubString(vo.getCtrtOfcCtyCd())))){
							isInsert = true ;
							HashMap<String, Object> param = new HashMap<String, Object>();
							param.put("scnr_id", vo.getScnrId());
							param.put("ecc_cd", vo.getEccCd());
							param.put("ctrt_ofc_cty_cd03", vo.getCtrtOfcCtyCd().substring(0,3));
							param.put("ctrt_ofc_cty_cd", vo.getCtrtOfcCtyCd().substring(3,ctrt_seq_SubString(vo.getCtrtOfcCtyCd())));
							param.put("cntr_tpsz_cd", vo.getCntrTpszCd());
							param.put("aval_cntr_qty", vo.getAvalCntrQty());
							param.put("lft_chg_amt", vo.getLftChgAmt());
							param.put("dryg_amt", vo.getDrygAmt());
							param.put("drff_chg_cr_amt", vo.getDrffChgCrAmt());
							param.put("dflt_usd_dys", vo.getDfltUsdDys());
							param.put("user_id", user_id);
							insModels.add(param);
						}else{
							isUpdate = true ;
							HashMap<String, Object> param = new HashMap<String, Object>();
							param.put("aval_cntr_qty",vo.getAvalCntrQty());
							param.put("lft_chg_amt",vo.getLftChgAmt());
							param.put("dryg_amt",vo.getDrygAmt());
							param.put("dflt_usd_dys",vo.getDfltUsdDys());
							param.put("drff_chg_cr_amt",vo.getDrffChgCrAmt());
							param.put("user_id",user_id);
							param.put("scnr_id",vo.getScnrId());
							param.put("ecc_cd",vo.getEccCd());
							param.put("ctrt_ofc_cty_cd03",vo.getCtrtOfcCtyCd().substring(0,3));
							param.put("ctrt_ofc_cty_cd",vo.getCtrtOfcCtyCd().substring(3,ctrt_seq_SubString(vo.getCtrtOfcCtyCd())));
							param.put("cntr_tpsz_cd",vo.getCntrTpszCd());
							updModels.add(param);
						}
					}else if(vo.getIbflag().equals("D")){
						isDelete = true ;
						HashMap<String, Object> param = new HashMap<String, Object>();
						param.put("scnr_id",vo.getScnrId());
						param.put("ecc_cd",vo.getEccCd());
						param.put("ctrt_ofc_cty_cd03",vo.getCtrtOfcCtyCd().substring(0,3));
						param.put("ctrt_ofc_cty_cd",vo.getCtrtOfcCtyCd().substring(3,ctrt_seq_SubString(vo.getCtrtOfcCtyCd())));
						param.put("cntr_tpsz_cd",vo.getCntrTpszCd());
						delModels.add(param);
					}
				}
			}
			if(isInsert){
				dbDao.insertSTOffHireInfo(insModels);
			}
			if(isUpdate){
				dbDao.updateSTOffHireInfo(updModels);
			}
			if(isDelete){
			 	dbDao.deleteSTOffHireInfo(delModels);
			}
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }
}