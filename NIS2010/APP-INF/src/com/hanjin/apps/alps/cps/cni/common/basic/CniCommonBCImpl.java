/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CniCommonBCImpl.java
 *@FileTitle : Container Cargo Claim 공통
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.07
 *@LastModifier : 진윤오
 *@LastVersion : 1.0
 * 2009.04.17 진윤오
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.common.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.cps.cni.common.integration.CniCommonDBDAO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.integration.ClaimMainDBDAO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.integration.ClaimMainEAIDAO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.BlGetVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.BookingNoVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.CMSServiceVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.ClaimMainCntVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.ClaimMainVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.CniAreaOfcVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmBlDtlVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmCntrDtlVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmCostVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmCtrtVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmLtgtVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmTrnsVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.ContractCarriageVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.FindCondVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.FindVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.HandlingCostInfoVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.HandlingCostVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.ImpendingTBIndemnityClaimVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.ImpendingTBMainClaimVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.PaymentVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.TransferCondVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.TransferVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * Business Logic Basic Command implementation<br>
 * Container Cargo Claim 에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author choijungmi
 * @see ClaimMainBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class CniCommonBCImpl extends BasicCommandSupport implements CniCommonBC
{

    // Database Access Object
    private transient CniCommonDBDAO dbDao = null;

    /**
     * CniCommonBCImpl 객체 생성<br>
     * ContainerCargoClaimDBDAO 생성한다.<br>
     */
    public CniCommonBCImpl()
    {
        dbDao = new CniCommonDBDAO();
    }



    // ===========================================================================
    // 진윤오
    // ===========================================================================

	// ---------------------------------------------------------------------------
	// [CNI COMMON] Cargo Claim 공통
	// ---------------------------------------------------------------------------	
	/**
	 * 사용자 Role 리스트 취득<br>
	 * @author 진윤오
	 * @category CNI COMMON
	 * @category searchUserRoleList 
	 * @param String usrId 로그인 사용자
     * @return String "CNI01,CNI02 ....." 반환
     * @throws EventException
     */
    public String searchUserRoleList(String usrId) throws EventException {
      
        try {     
            String[] list = dbDao.searchUserRoleList(usrId);
            
            if (list == null) {
            	return "";
            } else {
            	StringBuffer sb = new StringBuffer();
            	for (int i = 0; i < list.length; i++) {
            		if (i == 0 ) {
            			sb.append(list[i]);
            		} else {
            			sb.append(",").append(list[i]);
            		}
					
				}
            	return sb.toString();
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
	 * 사용자 Area  취득<br>
	 * @author 진윤오
	 * @category CNI COMMON
	 * @category searchUserArea 
	 * @param String ofcCd 오피스코드
     * @return String
     * @throws EventException
     */
    public String searchUserArea(String ofcCd) throws EventException {
      
        try {     
            return  dbDao.searchUserArea(ofcCd);            
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}
       
    } 	
}