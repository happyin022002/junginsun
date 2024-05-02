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
package com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.integration.RenewalMasterDataMgtDBDAO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.vo.AuthorityCarrierVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.vo.CarrierVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.vo.FinancialAffairsMtxGrpVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.vo.FinancialAffairsMtxVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.vo.MstConditionVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.vo.SettlementBssPortVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-RenewalMasterDataMgtSC Business Logic Basic Command implementation<br>
 * - OPUS-RenewalMasterDataMgtSC: handling business logic<br>
 *
 * @author
 * @see UI_JOO_0028EventResponse,RenewalMasterDataMgtBC DAO class
 * @since J2EE 1.4
 */

public class RenewalMasterDataMgtBCImpl extends BasicCommandSupport implements RenewalMasterDataMgtBC {

	// Database Access Object
	private transient RenewalMasterDataMgtDBDAO dbDao = null;

	/**
	 * RenewalMasterDataMgtBCImpl object creation<br>
	 * RenewalMasterDataMgtDBDAO creation<br>
	 */
	public RenewalMasterDataMgtBCImpl() {
		dbDao = new RenewalMasterDataMgtDBDAO();
	}

	/*
	 * ===================================================================================
	 * 2016.05.13 Renewal Add.
	 * ===================================================================================
	 */

	/**
	 * retrieving Carrier
	 * 2016.05.13 Renewal Add.
	 * 
	 * @param MstConditionVO mstConditionVO
	 * @return List<CarrierVO>
	 * @throws EventException
	 */
	public List<CarrierVO> searchCarrierList(MstConditionVO mstConditionVO) throws EventException {
		try {
			return dbDao.searchCarrierList(mstConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Carrier", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Carrier", "Retrieve"}).getMessage(), ex);

		}
	}

	/**
	 * Authority Carrier 조회.
	 * 2016.05.13 Renewal Add.
	 * 
	 * @param MstConditionVO mstConditionVO
	 * @return List<CarrierVO>
	 * @throws EventException
	 */
	public List<AuthorityCarrierVO> searchAuthorityCarrierList(MstConditionVO mstConditionVO) throws EventException {
		try {
			return dbDao.searchAuthorityCarrierList(mstConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Authority Carrier", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Authority Carrier", "Retrieve"}).getMessage(), ex);

		}
	}
	

	/**
     * FNS_JOO_0090 : Save
     * saving Authority Carrier<br>
     *  2016.05.13 Renewal Add.
     *  
     *  1. JOO_CRR_AUTH 화면 Data 분류(D/U/I)
     *  2. JOO_CRR_AUTH Delete
     *  3. JOO_CRR_AUTH Update
     *  4. JOO_CRR_AUTH Insert
     *  
     * @param  AuthorityCarrierVO[] authorityCarrierVOs
     * @param  SignOnUserAccount signOnUserAccount
     * @throws EventException
     */
    public void manageAuthorityCarrier(AuthorityCarrierVO[] authorityCarrierVOs, SignOnUserAccount signOnUserAccount) throws EventException {
        try{
            List<AuthorityCarrierVO> removeVoList = new ArrayList<AuthorityCarrierVO>();
            List<AuthorityCarrierVO> insertVoList = new ArrayList<AuthorityCarrierVO>(); 
            List<AuthorityCarrierVO> updateVoList = new ArrayList<AuthorityCarrierVO>(); 

            //1.1. JOO_CRR_AUTH 화면 데이타 분류
            for(AuthorityCarrierVO vo : authorityCarrierVOs){
            	vo.setCreUsrId(signOnUserAccount.getUsr_id());
        		
            	if(vo.getIbflag().equals("D")){
            		removeVoList.add(vo);
            	}else if(vo.getIbflag().equals("U")){
            		updateVoList.add(vo);
            	}else if(vo.getIbflag().equals("I")){
            		insertVoList.add(vo);
            	}
            }
            
            //2. JOO_CRR_AUTH Delete
            for(AuthorityCarrierVO delVo : removeVoList){
            	dbDao.removeAuthorityCarrier(delVo);
            }
            
            //3. JOO_CRR_AUTH Update
            for(AuthorityCarrierVO upVo : updateVoList){            	
            	String chkExistAuthFlg = dbDao.checkExistAuthorityCarrier(upVo);
        		if(chkExistAuthFlg.equals("N")){
        			//존재하지 않으므로 Insert
        			dbDao.addAuthorityCarrier(upVo);
        		}else{
        			//존재 하므로 Update.
        			dbDao.modifyAuthorityCarrier(upVo);
        		}
            }
            
            //4. JOO_CRR_AUTH Insert
            for(AuthorityCarrierVO inVo : insertVoList){            	
            	String chkExistAuthFlg = dbDao.checkExistAuthorityCarrier(inVo);
        		if(chkExistAuthFlg.equals("N")){
        			//존재하지 않으므로 Insert
        			dbDao.addAuthorityCarrier(inVo);
        		}else{
        			//존재 하므로 Update.
        			dbDao.modifyAuthorityCarrier(inVo);
        		}
            }
 
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Authority Carrier", "Save"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Authority Carrier", "Save"}).getMessage(), ex);
        }
  
    }

	/**
	 * Financial Affairs Matrix 조회.
	 * 2016.05.13 Renewal Add.
	 * 
	 * @param MstConditionVO mstConditionVO
	 * @return List<FinancialAffairsMtxVO>
	 * @throws EventException
	 */
	public List<FinancialAffairsMtxVO> searchFinancialAffairsMtxList(MstConditionVO mstConditionVO) throws EventException {
		try {
			return dbDao.searchFinancialAffairsMtxList(mstConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Financial Affairs Matrix", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Financial Affairs Matrix", "Retrieve"}).getMessage(), ex);

		}
	}

	/**
	 * Financial Affairs Matrix Create 조회.
	 * 2016.05.13 Renewal Add.
	 * 
	 * @param MstConditionVO mstConditionVO
	 * @return List<FinancialAffairsMtxVO>
	 * @throws EventException
	 */
	public List<FinancialAffairsMtxVO> calculateFinancialAffairsMtxList(MstConditionVO mstConditionVO) throws EventException {
		try {
			return dbDao.calculateFinancialAffairsMtxList(mstConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Financial Affairs Matrix", "Create"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Financial Affairs Matrix", "Create"}).getMessage(), ex);

		}
	}
	

	/**
     * FNS_JOO_0089 : Save
     * saving Financial Affairs matrix<br>
     *  2016.05.13 Renewal Add.
     *  
     *  1. JOO_FIN_MTX
     *  1.1. Revenue Financial Affairs matrix
     *  1.2. Expense Financial Affairs matrix
     *  2. Revenue/Expense Delete
     *  3. Revenue/Expense Update
     *  4. Revenue/Expense Insert
     *  
     * @param  FinancialAffairsMtxGrpVO financialAffairsMtxGrpVO
     * @param  SignOnUserAccount signOnUserAccount
     * @throws EventException
     */
    public void manageFinancialAffairsMtx(FinancialAffairsMtxGrpVO financialAffairsMtxGrpVO, SignOnUserAccount signOnUserAccount) throws EventException {
        try{
            List<FinancialAffairsMtxVO> removeVoList = new ArrayList<FinancialAffairsMtxVO>();
            List<FinancialAffairsMtxVO> insertVoList = new ArrayList<FinancialAffairsMtxVO>(); 
            List<FinancialAffairsMtxVO> updateVoList = new ArrayList<FinancialAffairsMtxVO>(); 
            
            List<FinancialAffairsMtxVO> revList = financialAffairsMtxGrpVO.getRevenueFinancialAffairsMtxVOs(); 
            List<FinancialAffairsMtxVO> expList = financialAffairsMtxGrpVO.getExpenseFinancialAffairsMtxVOs(); 
            
            //1.1. Revenue Financial Affairs matrix
            for(FinancialAffairsMtxVO revVo : revList){
        		revVo.setCreUsrId(signOnUserAccount.getUsr_id());
        		
            	if(revVo.getIbflag().equals("D")){
            		removeVoList.add(revVo);
            	}else if(revVo.getIbflag().equals("U")){
            		updateVoList.add(revVo);
            	}else if(revVo.getIbflag().equals("I")){
            		insertVoList.add(revVo);
            	}
            }
            
            //1.2. Expense Financial Affairs matrix
            for(FinancialAffairsMtxVO expVo : expList){
            	expVo.setCreUsrId(signOnUserAccount.getUsr_id());
        		
            	if(expVo.getIbflag().equals("D")){
            		removeVoList.add(expVo);
            	}else if(expVo.getIbflag().equals("U")){
            		updateVoList.add(expVo);
            	}else if(expVo.getIbflag().equals("I")){
            		insertVoList.add(expVo);
            	}
            }
            
            
            //2. Revenue/Expense Delete
            for(FinancialAffairsMtxVO delVo : removeVoList){
            	dbDao.removeFinancialAffairsMtx(delVo);
            }
            
            //3. Revenue/Expense Update
            for(FinancialAffairsMtxVO upVo : updateVoList){            	
            	String chkExistFinMtxFlg = dbDao.checkExistFinancialAffairsMtx(upVo);
        		if(chkExistFinMtxFlg.equals("N")){
        			//존재하지 않으므로 Insert
        			dbDao.addFinancialAffairsMtx(upVo);
        		}else{
        			//존재 하므로 Update.
        			dbDao.modifyFinancialAffairsMtx(upVo);
        		}
            }
            
            //4. Revenue/Expense Insert
            for(FinancialAffairsMtxVO inVo : insertVoList){            	
            	String chkExistFinMtxFlg = dbDao.checkExistFinancialAffairsMtx(inVo);
        		if(chkExistFinMtxFlg.equals("N")){
        			//존재하지 않으므로 Insert
        			dbDao.addFinancialAffairsMtx(inVo);
        		}else{
        			//존재 하므로 Update.
        			dbDao.modifyFinancialAffairsMtx(inVo);
        		}
            }
 
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Financial Affairs Matrix", "Save"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Financial Affairs Matrix", "Save"}).getMessage(), ex);
        }
  
    }
	

	/**
     * FNS_JOO_0088 : Save
     * saving Carrier & Carrier Auth & Fin Mtx Creation<br>
     *  2016.05.13 Renewal Add.
     *  
     *  1. JOO_CARRIER 
     *  2. JOO_CRR_AUTH
     *  3. JOO_FIN_MTX
     *  
     * @param  CarrierVO[] carrierVOs
     * @param  SignOnUserAccount signOnUserAccount
     * @throws EventException
     */
    public void manageCarrier(CarrierVO[] carrierVOs, SignOnUserAccount signOnUserAccount) throws EventException {
        try{
            List<CarrierVO> removeVoList = new ArrayList<CarrierVO>();
            List<CarrierVO> insertVoList = new ArrayList<CarrierVO>(); 
            List<CarrierVO> updateVoList = new ArrayList<CarrierVO>();            
            
            for(CarrierVO vo : carrierVOs){
            	if(vo.getIbflag().equals("D")){
            		removeVoList.add(vo);
            	}else if(vo.getIbflag().equals("U")){
            		updateVoList.add(vo);
            	}else if(vo.getIbflag().equals("I")){
            		insertVoList.add(vo);
            	}
            }
            
            //1. Delete :  하위 테이블까지 체크.
            for(CarrierVO delVo : removeVoList){
            	//하위 사용 여부 판단.(JOO_STL_VVD : JO_CRR_CD, RLANE_CD) 향후 변경되는 테이블에서 체크.
            	String chkUsedYn = dbDao.checkCarrierUsed(delVo);
            	
            	if(chkUsedYn.equals("N")){
            		//1.1. 하위 테이블 삭제 처리.
            		//1.1.1. JOO_FINC_MTX Delete
            		FinancialAffairsMtxVO financialAffairsMtxVO = new FinancialAffairsMtxVO();
            		financialAffairsMtxVO.setJoCrrCd(delVo.getJoCrrCd());
            		financialAffairsMtxVO.setRlaneCd(delVo.getRlaneCd());
            		
            		dbDao.removeFinancialAffairsMtx(financialAffairsMtxVO);
            		            		
            		//1.1.2. JOO_CRR_AUTH Delete
            		AuthorityCarrierVO authorityCarrierVO = new AuthorityCarrierVO();
            		authorityCarrierVO.setJoCrrCd(delVo.getJoCrrCd());
            		authorityCarrierVO.setRlaneCd(delVo.getRlaneCd());
            		
            		dbDao.removeAuthorityCarrier(authorityCarrierVO);            		
            		
            		//1.1.3. JOO_STL_BSS_PORT Delete ( 향후 사용되지 않지만 기존에 들어가 있는 데이타로 삭제 처리해야함.)
            		SettlementBssPortVO stlBssPortVO = new SettlementBssPortVO();
            		stlBssPortVO.setJoCrrCd(delVo.getJoCrrCd());
            		stlBssPortVO.setRlaneCd(delVo.getRlaneCd());
            		
            		dbDao.removeStlBssPort(stlBssPortVO); 
            		
            		//1.1.4. JOO_CARRIER Delete
            		dbDao.removeCarrier(delVo); 
            		
            	}else{
            		//1.2. 하위가 존재 하므로 Update : DELT_FLG = Y
            		delVo.setDeltFlg("Y");   
            		delVo.setCreUsrId(signOnUserAccount.getUsr_id());
            		
            		//1.2.1. JOO_CARRIER Update.
            		dbDao.modifyCarrier(delVo);
            	}
            }
            
            //2. Update  : 자기 자신만 업데이트 하면됨...단. JOO_CRR_AUTH, JOO_FINC_MTX 존재 여부 판단하여 없으면 Insert 처리.
            for(CarrierVO upVo : updateVoList){
            	//2.1 JOO_CARRIER Update.
            	upVo.setCreUsrId(signOnUserAccount.getUsr_id());        		
            	upVo.setOfcCd(signOnUserAccount.getOfc_cd());
            	
        		dbDao.modifyCarrier(upVo);
        		
        		//2.2 JOO_FINC_MTX Check/Insert/Update
        		this.manageFinancialAffairsMtxByCarrier(upVo, signOnUserAccount);
        		
        		//2.3 JOO_CRR_AUTH Check/Insert
        		this.manageAuthorityCarrierByCarrier(upVo, signOnUserAccount);
        		        		
            }
            
            //3. Insert : JOO_CARRIER - 화면 Input Data Insert ,  JOO_CRR_AUTH, JOO_FINC_MTX 자동 Insert 처리.
            for(CarrierVO inVo : insertVoList){
            	//2.1 JOO_CARRIER 존재여부.
            	String chkExistCarrierFlg = dbDao.checkExistCarrier(inVo);
            	
            	if(chkExistCarrierFlg.equals("N")){
            		inVo.setCreUsrId(signOnUserAccount.getUsr_id());      		
            		inVo.setOfcCd(signOnUserAccount.getOfc_cd());
            		
            		//2.1.1. JOO_CARRIER Insert.
            		dbDao.addCarrier(inVo);
            		
            		//2.1.2. JOO_FINC_MTX 자동으로 Insert 작업 진행.
            		this.manageFinancialAffairsMtxByCarrier(inVo, signOnUserAccount);
            		
            		//2.1.3. JOO_CRR_AUTH 자동으로 Insert 작업 진행.
            		this.manageAuthorityCarrierByCarrier(inVo, signOnUserAccount);
            	}
            	
            	
            }
            
 
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Carrier List", "Save"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Carrier List", "Save"}).getMessage(), ex);
        }
  
    }

	/**
	 * JOO_FINC_MTX By Carrier 
	 * 
	 * @param CarrierVO carrierVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	private void manageFinancialAffairsMtxByCarrier(CarrierVO carrierVO, SignOnUserAccount signOnUserAccount) throws EventException {
		try {
			//2.2 JOO_FINC_MTX 존재여부 
    		FinancialAffairsMtxVO financialAffairsMtxVO = new FinancialAffairsMtxVO();
    		financialAffairsMtxVO.setJoCrrCd(carrierVO.getJoCrrCd());
    		financialAffairsMtxVO.setRlaneCd(carrierVO.getRlaneCd());
    		
    		String chkExistFinMtxFlg = dbDao.checkExistFinancialAffairsMtx(financialAffairsMtxVO);
    		if(chkExistFinMtxFlg.equals("N")){
    			//2.2.2. JOO_FINC_MTX Data를 자동으로 새로 구해서 Insert 작업 진행.
    			List<FinancialAffairsMtxVO> inList = dbDao.searchAutoFinancialAffairsMtxByCarrier(carrierVO);
    			
    			for(FinancialAffairsMtxVO inFinancialAffairsMtxVO : inList){
    				inFinancialAffairsMtxVO.setLoclCurrCd(carrierVO.getLoclCurrCd()); //화면에서 입력 받은 currency 
    				inFinancialAffairsMtxVO.setCreUsrId(signOnUserAccount.getUsr_id());
    				
    				dbDao.addFinancialAffairsMtx(inFinancialAffairsMtxVO);
    			}
    			
    		}else{
    			//2.2.3. Carrier에서 Currency 변경시 JOO_FINC_MTX의 Currency 체크 하여 변경 되었으면 Update 한다.
    			String chkCurrencyFlg = dbDao.checkFinancialAffairsMtxCurrency(carrierVO);
    			
    			if(chkCurrencyFlg.equals("Y")){
    				//2.2.4. Carrier에서 Currency 변경시 JOO_FINC_MTX의 Currency 체크 하여 변경 되었으면 Update 한다.
    				FinancialAffairsMtxVO upFinancialAffairsMtxVO = new FinancialAffairsMtxVO();
    				
    				upFinancialAffairsMtxVO.setJoCrrCd(carrierVO.getJoCrrCd());
    				upFinancialAffairsMtxVO.setRlaneCd(carrierVO.getRlaneCd());
    				upFinancialAffairsMtxVO.setLoclCurrCd(carrierVO.getLoclCurrCd());
    				upFinancialAffairsMtxVO.setCreUsrId(signOnUserAccount.getUsr_id());
    				        				
    				dbDao.modifyFinancialAffairsMtxAllCurrency(upFinancialAffairsMtxVO);
    			}
    			
    		}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("JOO10007", new String[] { "Carrier List" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("JOO10007", new String[] { "Carrier List" }).getMessage(), ex);
		}
	}

	/**
	 * JOO_CRR_AUTH By Carrier 
	 * 
	 * @param CarrierVO carrierVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	private void manageAuthorityCarrierByCarrier(CarrierVO carrierVO, SignOnUserAccount signOnUserAccount) throws EventException {
		try {
			AuthorityCarrierVO authorityCarrierVO = new AuthorityCarrierVO();
    		authorityCarrierVO.setJoCrrCd(carrierVO.getJoCrrCd());
    		authorityCarrierVO.setRlaneCd(carrierVO.getRlaneCd());
    		
    		String chkExistAuthFlg = dbDao.checkExistAuthorityCarrier(authorityCarrierVO);
    		if(chkExistAuthFlg.equals("N")){
    			//2.3.1. JOO_CRR_AUTH Insert VO Data Setting.
    			AuthorityCarrierVO inAuthorityCarrierVO = new AuthorityCarrierVO();
    			inAuthorityCarrierVO.setJoCrrCd(carrierVO.getJoCrrCd());
    			inAuthorityCarrierVO.setRlaneCd(carrierVO.getRlaneCd());
    			inAuthorityCarrierVO.setAuthOfcCd(signOnUserAccount.getOfc_cd());
    			inAuthorityCarrierVO.setJoCrrAuthCd("W");
    			inAuthorityCarrierVO.setDeltFlg("N");
    			inAuthorityCarrierVO.setCreUsrId(signOnUserAccount.getUsr_id());
    			
    			//2.3.2. JOO_CRR_AUTH를 새로 구해서 Insert 작업 진행.
    			dbDao.addAuthorityCarrier(inAuthorityCarrierVO);
    		}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("JOO10007", new String[] { "Carrier List" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("JOO10007", new String[] { "Carrier List" }).getMessage(), ex);
		}
	}
	
}