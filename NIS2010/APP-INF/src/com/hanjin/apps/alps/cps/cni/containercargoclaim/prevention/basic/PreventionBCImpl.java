/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : PreventionBCImpl.java
 *@FileTitle : PreventionBC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.22
 *@LastModifier : 진윤오
 *@LastVersion : 1.0
 * 2009.10.22 진윤오
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaim.prevention.basic;

import java.util.List;

import com.hanjin.apps.alps.cps.cni.common.CniUtil;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.prevention.integration.PreventionDBDAO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.prevention.vo.CniClmPrveVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.prevention.vo.PreventionCondVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.prevention.vo.PreventionInfoVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.prevention.vo.PreventionVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * CNI Business Logic Basic Command implementation<br>
 * CNI 로직을 처리한다.<br>
 * 
 * @author jspark
 * @see PreventionBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class PreventionBCImpl extends BasicCommandSupport implements PreventionBC
{

    // Database Access Object
    private transient PreventionDBDAO dbDao = null;

    /**
     * PreventionBCImpl 객체 생성<br>
     * PreventionDBDAO 생성한다.<br>
     */
    public PreventionBCImpl()
    {
        dbDao = new PreventionDBDAO();
    }

    // ===========================================================================
    // 진윤오
    // ===========================================================================
	
    // ---------------------------------------------------------------------------
    // [CPS_CNI_0022] Prevention
    // ---------------------------------------------------------------------------
    
    
	/**
	 * Prevention 리스트 조회<br>
	 * @author 진윤오
	 * @category CPS_CNI_0022
	 * @category searchPreventionList 
	 * @param PreventionCondVO condVo
     * @return List<PreventionVO>
     * @throws EventException
     */	
	public List<PreventionVO> searchPreventionList(PreventionCondVO condVo) throws EventException {
		try {
			
			String creDtStart = condVo.getCreDtStart();			
			condVo.setCreDtStart(CniUtil.getFmtDt(creDtStart));

			String creDtEnd = condVo.getCreDtEnd();
			condVo.setCreDtEnd(CniUtil.getFmtDt(creDtEnd));
			
			String curDt = condVo.getCurDt();
			condVo.setCurDt(CniUtil.getFmtDt(curDt));
			
			String usrRoles = condVo.getUsrRoles();
			
			// CCC조회 가능자
			if (usrRoles != null) {
				// CCC담당자 , 지역관리자 , 본사관리자 , 
				// 모듈관리자 , Loss Prevention 담당자 , Loss Prevention 관리자
				/*
				usrRoles.indexOf("CNI01") != -1 ||
				usrRoles.indexOf("CNI02") != -1 ||
				usrRoles.indexOf("CNI03")  != -1 ||
				
				*/
				
				if (usrRoles.indexOf("CNI41") != -1 ||
						usrRoles.indexOf("CNI42") != -1 ||
						usrRoles.indexOf("CNI93") != -1) {
					condVo.setUsrRoles("TRUE");
				} else {
					condVo.setUsrRoles("");
				}
			}
			
			return dbDao.searchPreventionList(condVo);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}	
	}

    // ---------------------------------------------------------------------------
    // [CPS_CNI_0023] Prevention-Register
    // ---------------------------------------------------------------------------
	
	/**
	 * Prv No 별 Prevention 정보 조회<br>
	 * @author 진윤오
	 * @category CPS_CNI_0023
	 * @category searchPreventionInfo 
	 * @param String clmPrveNo
     * @return PreventionInfoVO
     * @throws EventException
     */	
	public PreventionInfoVO searchPreventionInfo(String clmPrveNo) throws EventException {
		try {			
			
			//view Count + 1
			dbDao.modifyPreventionViewCnt(clmPrveNo);
			
			return dbDao.searchPreventionInfo(clmPrveNo);			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}	
	}	
	
	
	/**
	 * Prv No 최대값 취득<br>
	 * @author 진윤오
	 * @category CPS_CNI_0023
	 * @category searchMaxClmPrevNo
     * @return String Max claim prevention no
     * @throws EventException
     */	
	public String searchMaxClmPrevNo() throws EventException {
		try {			
			return dbDao.searchMaxClmPrevNo();			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}	
	}	
		
	
	/**
	 * Prevention 추가<br>
	 * @author 진윤오
	 * @category CPS_CNI_0023
	 * @category createPrevention 
	 * @param CniClmPrveVO cniClmPrveVO
     * @throws EventException
     */	
	public void createPrevention(CniClmPrveVO cniClmPrveVO) throws EventException {
		try {
			
			String effDt = cniClmPrveVO.getEffDt();
			String expDt = cniClmPrveVO.getExpDt();
			
			
			if (effDt != null && effDt.indexOf("-") != -1) {
				effDt = effDt.replaceAll("\\-", "");
				cniClmPrveVO.setEffDt(effDt);
			}
			
			String yyyy = effDt.substring(0,4);
			
			if ("1".equals(expDt)) {
				expDt = (Integer.parseInt(yyyy) + 1) + "";
			} else if ("3".equals(expDt)) {
				expDt = (Integer.parseInt(yyyy) + 3) + "";
			} else if ("5".equals(expDt)) {
				expDt = (Integer.parseInt(yyyy) + 5) + "";
			} else if ("10".equals(expDt)) {
				expDt = (Integer.parseInt(yyyy) + 10) + "";
			} else if ("P".equals(expDt)) {			
				expDt = "99991231";
			}
			cniClmPrveVO.setExpDt(expDt);
			
			dbDao.addPrevention(cniClmPrveVO);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}	
	}
	
	
	/**
	 * Prevention 수정<br>
	 * @author 진윤오
	 * @category CPS_CNI_0023
	 * @category modifyPrevention 
	 * @param CniClmPrveVO cniClmPrveVO
     * @throws EventException
     */	
	public void modifyPrevention(CniClmPrveVO cniClmPrveVO) throws EventException {
		try {
			
			String effDt = cniClmPrveVO.getEffDt();
			String expDt = cniClmPrveVO.getExpDt();
			
			
			if (effDt != null && effDt.indexOf("-") != -1) {
				effDt = effDt.replaceAll("\\-", "");
				cniClmPrveVO.setEffDt(effDt);
			}
			
			String yyyy = effDt.substring(0,4);
			
			if ("1".equals(expDt)) {
				expDt = (Integer.parseInt(yyyy) + 1) + "";
			} else if ("3".equals(expDt)) {
				expDt = (Integer.parseInt(yyyy) + 3) + "";
			} else if ("5".equals(expDt)) {
				expDt = (Integer.parseInt(yyyy) + 5) + "";
			} else if ("10".equals(expDt)) {
				expDt = (Integer.parseInt(yyyy) + 10) + "";
			} else if ("P".equals(expDt)) {			
				expDt = "99991231";
			}
			
			cniClmPrveVO.setExpDt(expDt);
			
			dbDao.modifyPrevention(cniClmPrveVO);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}	
	}	
	
	/**
	 * Prevention 추가<br>
	 * @author 진윤오
	 * @category CPS_CNI_0023
	 * @category removePrevention 
	 * @param String clmPrveNo
     * @throws EventException
     */	
	public void removePrevention(String clmPrveNo) throws EventException {
		try {
			dbDao.removePrevention(clmPrveNo);			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}	
	}		
	
	
	/**
	 * Prevention View + 1 수정 <br>
	 * @author 진윤오
	 * @category CPS_CNI_0023
	 * @category modifyPreventionViewCnt 
	 * @param String clmPrveNo
     * @throws EventException
     */	
	public void modifyPreventionViewCnt(String clmPrveNo) throws EventException {
		try {
			dbDao.modifyPreventionViewCnt(clmPrveNo);			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}	
	}		
	
}