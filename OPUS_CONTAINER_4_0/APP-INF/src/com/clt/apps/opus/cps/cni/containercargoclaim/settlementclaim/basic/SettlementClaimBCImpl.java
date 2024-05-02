/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SettlementClaimBCImpl.java
 *@FileTitle : SettlementClaimBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.11.22
 *@LastModifier : 박제성
 *@LastVersion : 1.0
 * 2009.11.22 박제성
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.settlementclaim.basic;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import com.clt.apps.opus.cps.cni.common.CniUtil;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.integration.ClaimMainDBDAO;
import com.clt.apps.opus.cps.cni.containercargoclaim.settlementclaim.integration.SettlementClaimDBDAO;
import com.clt.apps.opus.cps.cni.containercargoclaim.settlementclaim.vo.CniSettlementVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.settlementclaim.vo.GwApproveStatusVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.settlementclaim.vo.GwCargoInfoVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.settlementclaim.vo.SettlementVO;
import com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.integration.ContainerCargoClaimReportDBDAO;
import com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.CargoClaimReportVO;
import com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.CargoLitigationReportVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * CNI Business Logic Basic Command implementation<br>
 * CNI 로직을 처리한다.<br>
 * 
 * @author jspark
 * @see SettlementClaimBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class SettlementClaimBCImpl extends BasicCommandSupport implements SettlementClaimBC
{

    // Database Access Object
    private transient SettlementClaimDBDAO dbDao = null;
    private transient ContainerCargoClaimReportDBDAO reportDao = null;
    private transient ClaimMainDBDAO mainDao = null;
    /**
     * SettlementClaimBCImpl 객체 생성<br>
     * SettlementClaimDBDAO 생성한다.<br>
     */
    public SettlementClaimBCImpl()
    {
        dbDao = new SettlementClaimDBDAO();
        reportDao = new ContainerCargoClaimReportDBDAO();
        mainDao = new ClaimMainDBDAO();
    }

    // ===========================================================================
    // 박제성
    // ===========================================================================
	
    // ---------------------------------------------------------------------------
    // [CPS_CNI_0014] SettlementClaim
    // ---------------------------------------------------------------------------
	/**
	 * Settlement 리스트 조회<br>
	 * @author 박제성
	 * @category CPS_CNI_0012
	 * @category searchSettlementInfo 
	 * @param String  cgoClmNo
     * @return List<SettlementVO>
     * @throws EventException
     */	
	
	public List<SettlementVO> searchSettlementInfo(String cgoClmNo) throws EventException {
		try {
			
			return dbDao.searchSettlementInfo(cgoClmNo);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}	
	}
	
	/**
	 * Settlement 멀티 이벤트 처리<br>
	 * 
	 * @author 박제성
	 * @category CPS_CNI_0015
	 * @category manageSettlement
	 * @param CniSettlementVO cniSettlementVO
	 * @return String 
	 * @exception EventException
	 */
	public String  manageSettlement(CniSettlementVO cniSettlementVO) throws EventException {		
		try {
			String manageStr="";
			
			// 데이타 수정
			String exist = dbDao.searchSettlementExist(cniSettlementVO.getCgoClmNo());

			if (exist.equals("MS")) {
				dbDao.modifySettlement(cniSettlementVO);// 존재하면
				manageStr = "Y";
			}
			if (exist.equals("M")) {
				dbDao.addSettlement(cniSettlementVO);// 없으면
				manageStr = "Y";
			}
			if (exist.equals("")) {
				manageStr = "N";
			}
			
			return manageStr;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}	
		
	}
	
	/**
	 * Settlement Cancel 처리<br>
	 * 
	 * @author 박제성
	 * @category CPS_CNI_0015
	 * @category modifyClaimCancel
	 * @param CniSettlementVO cniSettlementVO	 
	 * @exception EventException
	 */
	public void  modifyClaimCancel(CniSettlementVO cniSettlementVO) throws EventException {		
		try {

				dbDao.modifyClaimCancel(cniSettlementVO);		
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}	
		
	}	
	
	/** 
	 * Reopen시 Settlement 값 변경<br>
	 * @author 정행룡
	 * @category CPS_CNI_0037
	 * @category modifyReOpenSettlement
	 * @param String cgoClmNo
	 * @param String updUsrId 
	 * @exception EventException
	 */
	public void modifyReOpenSettlement(String cgoClmNo , String updUsrId) throws EventException {
		try {		
			dbDao.modifyReOpenSettlement(cgoClmNo , updUsrId );
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		}
	}	
	
}