/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : IndemnityClaimBCImpl.java
 *@FileTitle : IndemnityClaimBC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.22
 *@LastModifier : 박제성
 *@LastVersion : 1.0
 * 2009.10.22 박제성
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.indemnityclaim.basic;

import java.util.List;

import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.basic.ClaimMainBC;
import com.clt.apps.opus.cps.cni.containercargoclaim.indemnityclaim.integration.IndemnityClaimDBDAO;
import com.clt.apps.opus.cps.cni.containercargoclaim.indemnityclaim.vo.CniLiablePartyVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.indemnityclaim.vo.LiablePartyVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * CNI Business Logic Basic Command implementation<br>
 * CNI 로직을 처리한다.<br>
 * 
 * @author jspark
 * @see ClaimMainBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class IndemnityClaimBCImpl extends BasicCommandSupport implements IndemnityClaimBC
{

    // Database Access Object
    private transient IndemnityClaimDBDAO dbDao = null;

    /**
     * ContainerCargoClaimBCImpl 객체 생성<br>
     * IncidentSurveyDBDAO 생성한다.<br>
     */
    public IndemnityClaimBCImpl()
    {
        dbDao = new IndemnityClaimDBDAO();
    }

    // ===========================================================================
    // 박제성
    // ===========================================================================
	
    // ---------------------------------------------------------------------------
    // [CPS_CNI_0015] IndemnityClaim
    // ---------------------------------------------------------------------------
	/**
	 * LiableParty 리스트 조회<br>
	 * @author 박제성
	 * @category CPS_CNI_0012
	 * @category searchLiablePartyList 
	 * @param String  cgoClmNo
     * @return List<LiablePartyVO>
     * @throws EventException
     */	
	
	public List<LiablePartyVO> searchLiablePartyInfo(String cgoClmNo) throws EventException {
		try {
			
			return dbDao.searchLiablePartyInfo(cgoClmNo);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}	
	}
	
	/**
	 * LiableParty 멀티 이벤트 처리<br>
	 * 
	 * @author 박제성
	 * @category CPS_CNI_0015
	 * @category manageLiableParty
	 * @param CniLiablePartyVO cniLiablePartyVO
	 * @return String 
	 * @exception EventException
	 */
	public String  manageLiableParty(CniLiablePartyVO cniLiablePartyVO) throws EventException {		
		try {
			String manageStr="";
			
			// 데이타 수정
			String exist = dbDao.searchLiablePartyExist(cniLiablePartyVO.getCgoClmNo());
					
			
			if (exist.equals("MS")) {
				dbDao.modifyLiableParty(cniLiablePartyVO);// 존재하면
				manageStr = "Y";
			}
			if (exist.equals("M")) {
				
				dbDao.addLiableParty(cniLiablePartyVO);// 없으면
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

}