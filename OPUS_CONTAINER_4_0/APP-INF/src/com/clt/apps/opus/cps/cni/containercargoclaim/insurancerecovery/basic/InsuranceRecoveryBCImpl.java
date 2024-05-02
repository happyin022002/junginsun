/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : IncidentSurveyBCImpl.java
 *@FileTitle : IncidentSurveyBC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.07
 *@LastModifier : 진윤오
 *@LastVersion : 1.0
 * 2009.04.17 진윤오
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.insurancerecovery.basic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.PartyVO;
import com.clt.apps.opus.cps.cni.common.CniUtil;
import com.clt.apps.opus.cps.cni.containercargoclaim.insurancerecovery.integration.InsuranceRecoveryDBDAO;
import com.clt.apps.opus.cps.cni.containercargoclaim.insurancerecovery.vo.CniCgoClmInsurVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.insurancerecovery.vo.EntryStatusVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.insurancerecovery.vo.InsuranceRecoveryByCaseVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.insurancerecovery.vo.InsuranceRecoveryByVvdVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * OPUS-CNI Insurance Business Logic Basic Command implementation<br>
 * - OPUS-CNI Insurance에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author 
 * @see InsuranceRecoveryBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class InsuranceRecoveryBCImpl extends BasicCommandSupport implements InsuranceRecoveryBC
{

    // Database Access Object
    private transient InsuranceRecoveryDBDAO dbDao = null;

    /**
     * InsuranceRecoveryBCImpl 객체 생성<br>
     * InsuranceRecoveryDBDAO 생성한다.<br>
     */
    public InsuranceRecoveryBCImpl()
    {
        dbDao = new InsuranceRecoveryDBDAO();
    }

    

    
	// 진윤오  ===========================================================================	
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0016] Insurance Recovery by VVD 
	// ---------------------------------------------------------------------------
	
	/**
	 * vvd 정보 및 보험관련 조회<br>
	 * @author 진윤오
	 * @category CPS_CNI_0016
	 * @category searchEntryStatusInfo 
	 * @param String vslCd
	 * @param String insurClmPtyNo
	 * @param String insurPlcyYr
     * @return EntryStatusVO
     * @throws EventException
     */
    public EntryStatusVO searchEntryStatusInfo(String vslCd , String insurClmPtyNo , String insurPlcyYr) throws EventException {    
		try {
			return dbDao.searchEntryStatusInfo(vslCd, insurClmPtyNo, insurPlcyYr);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		}
	}

    

	/**
	 * VVD InsuranceRecovery정보 조회<br>
	 * @author 진윤오
	 * @category CPS_CNI_0016
	 * @category searchInsuranceRecoveryByVvdList 
	 * @param String trnkRefVvdNo
     * @return List<InsuranceRecoveryByVvdVO>
     * @throws EventException
     */
    public List<InsuranceRecoveryByVvdVO> searchInsuranceRecoveryByVvdList(String trnkRefVvdNo) throws EventException {    
		try {
			return dbDao.searchInsuranceRecoveryByVvdList(trnkRefVvdNo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		}
	}
    
    
	/**
	 * VVD InsuranceRecovery 등록 , 수정 <br>
	 * @author 진윤오
	 * @category CPS_CNI_0016
	 * @category manageInsuranceRecoveryByVvd
	 * @param CniCgoClmInsurVO[] cniCgoClmInsurVOs 
	 * @exception EventException
	 */
	public void  manageInsuranceRecoveryByVvd(CniCgoClmInsurVO[] cniCgoClmInsurVOs) throws EventException {		
		try {
			
			String userId = cniCgoClmInsurVOs[0].getCreUsrId();
			
			for (int i = 0; i < cniCgoClmInsurVOs.length; i++) {
				CniCgoClmInsurVO cniCgoClmInsurVO = cniCgoClmInsurVOs[i];
				// 데이타 수정
				String exist = dbDao.searchInsuranceExist(cniCgoClmInsurVO.getCgoClmNo());

				// INS Claimed Amount Currency code , R.O.E 로 로컬금액을 취득
				String insurDmndUsdAmt = cniCgoClmInsurVO.getInsurDmndUsdAmt();
				String insurXchRt = cniCgoClmInsurVO.getInsurXchRt();
				
				if (StringUtils.isEmpty(insurDmndUsdAmt) || 
						StringUtils.isEmpty(insurXchRt)) {					
					cniCgoClmInsurVO.setInsurDmndAmt("0");					
				} else {
					BigDecimal usdAmt = new BigDecimal(insurDmndUsdAmt);
					BigDecimal usdXchRt = new BigDecimal(cniCgoClmInsurVO.getInsurXchRt());
					BigDecimal lclAmt = CniUtil.getUsdToLclAmt(usdAmt, usdXchRt);
					cniCgoClmInsurVO.setInsurDmndAmt(lclAmt.toPlainString());					
				}
				
				cniCgoClmInsurVO.setCreUsrId(userId);
				cniCgoClmInsurVO.setUpdUsrId(userId);
								
				if (exist != null && exist.equals("Y")) {					
					dbDao.modifyInsuranceRecoveryByVvd(cniCgoClmInsurVO);// 존재하면
				} else {
					dbDao.addInsuranceRecoveryByVvd(cniCgoClmInsurVO);
				}
				
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}	
		
	}	
	
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0017] Insurance Recovery by Case 
	// ---------------------------------------------------------------------------
    
	/**
	 * Case InsuranceRecovery정보 조회<br>
	 * @author 진윤오
	 * @category CPS_CNI_0017
	 * @category searchInsuranceRecoveryByCaseInfo 
	 * @param String cgoClmNo
     * @return InsuranceRecoveryByCaseVO
     * @throws EventException
     */
    public InsuranceRecoveryByCaseVO searchInsuranceRecoveryByCaseInfo(String cgoClmNo) throws EventException {    
		try {
			return dbDao.searchInsuranceRecoveryByCaseInfo(cgoClmNo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * Case InsuranceRecovery 수정 <br>
	 * @author 진윤오
	 * @category CPS_CNI_0017
	 * @category manageInsuranceRecoveryByCase
	 * @param CniCgoClmInsurVO cniCgoClmInsurVO 
	 * @exception EventException
	 */
	public void  manageInsuranceRecoveryByCase(CniCgoClmInsurVO cniCgoClmInsurVO) throws EventException {		
		try {
			
			// INS Claimed Amount Currency code , R.O.E 로 로컬금액을 취득
			String insurRcvrUsdAmt = cniCgoClmInsurVO.getInsurRcvrUsdAmt();			
			String insurXchRt = cniCgoClmInsurVO.getInsurXchRt();
			String insurDmndCurrCd = cniCgoClmInsurVO.getInsurDmndCurrCd();
			
			if (!StringUtils.isEmpty(insurRcvrUsdAmt) && 
					!StringUtils.isEmpty(insurXchRt)) {				
				BigDecimal usdAmt = new BigDecimal(insurRcvrUsdAmt);
				BigDecimal usdXchRt = new BigDecimal(insurXchRt);
				BigDecimal lclAmt = CniUtil.getUsdToLclAmt(usdAmt, usdXchRt);				
				cniCgoClmInsurVO.setInsurRcvrAmt(lclAmt.toPlainString());				
				cniCgoClmInsurVO.setInsurRcvrXchRt(insurXchRt);
				cniCgoClmInsurVO.setInsurRcvrLoclCurrCd(insurDmndCurrCd);
				dbDao.modifyInsuranceRecoveryByCase(cniCgoClmInsurVO);
			}			
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}	
		
	}	    
	
	/**
	 * Case InsuranceRecovery Recovery Cancel <br>
	 * INS Claimed Amount, INS DOF, R.O.E, USD 삭제
	 * @author 진윤오
	 * @category CPS_CNI_0017
	 * @category manageInsuranceRecoveryCancel 
	 * @param String cgoClmNo
	 * @param String updUsrId    
	 * @exception EventException
	 */
	public void  manageInsuranceRecoveryCancel(String cgoClmNo , String updUsrId) throws EventException {		
		try {
			// Insure 정보 빈공백처리		
			dbDao.modifyInsuranceRecoveryCancel(cgoClmNo , updUsrId);			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}	
		
	}	   	
	

	
    //====================================================================================
    // 정행룡
    //====================================================================================
    // ---------------------------------------------------------------------------
    // [CPS_CNI_0003] Claim Mian
    // ---------------------------------------------------------------------------	
	/**
	 * Claim Main Insurance 멀티 이벤트 처리<br>
	 * 
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category manageClaimMainInsurance
	 * @param CniCgoClmInsurVO cniCgoClmInsurVO
	 * @exception EventException
	 */
	public void  manageClaimMainInsurance(CniCgoClmInsurVO cniCgoClmInsurVO) throws EventException {		
		try {
			
			// 데이타 수정
			String exist = dbDao.searchInsuranceExist(cniCgoClmInsurVO.getCgoClmNo());

			if (exist != null && exist.trim().equals("Y")) {
				dbDao.modifyClaimMainInsurance(cniCgoClmInsurVO);// 존재하면
			}else {
				dbDao.addInsurance(cniCgoClmInsurVO);// 없으면
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}	
		
	}
}