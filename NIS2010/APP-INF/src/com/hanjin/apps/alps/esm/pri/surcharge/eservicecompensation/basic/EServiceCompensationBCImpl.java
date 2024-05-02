/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EServiceCompensationBCImpl.java
*@FileTitle : E-Service Compensation Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.07.29 김대호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.surcharge.eservicecompensation.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.surcharge.eservicecompensation.integration.EServiceCompensationDBDAO;
import com.hanjin.apps.alps.esm.pri.surcharge.eservicecompensation.vo.MdmSvcScpLmtVO;
import com.hanjin.apps.alps.esm.pri.surcharge.eservicecompensation.vo.PriCmpnEsvcVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriRpHdrVO;
import com.hanjin.syscommon.common.table.PriSpHdrVO;

/**
 * ALPS-EServiceCompensation Business Logic Basic Command implementation<br>
 * - ALPS-EServiceCompensation에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author day-hoh Kim
 * @see EMS_PRI_4009EventResponse,EServiceCompensationBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class EServiceCompensationBCImpl extends BasicCommandSupport implements EServiceCompensationBC {

	// Database Access Object
	private transient EServiceCompensationDBDAO dbDao = null;

	/**
	 * EServiceCompensationBCImpl 객체 생성<br>
	 * EServiceCompensationDBDAO를 생성한다.<br>
	 */
	public EServiceCompensationBCImpl() {
		dbDao = new EServiceCompensationDBDAO();
	}
	
	/**
	 * E-SVC Compensation 의 리스트를 조회합니다.<br>
	 * 
	 * @param PriCmpnEsvcVO priCmpnEsvcVO
	 * @return List<PriCmpnEsvcVO>
	 * @exception EventException
	 */
	public List<PriCmpnEsvcVO> searchEServiceCompensationList(PriCmpnEsvcVO priCmpnEsvcVO) throws EventException {
		try {
			return dbDao.searchEServiceCompensationList(priCmpnEsvcVO);
		} catch(DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * E-SVC Compensation 의 origin, destination 콤보를 조회합니다.<br>
	 * 
	 * @param MdmSvcScpLmtVO mdmSvcScpLmtVO
	 * @return List<MdmSvcScpLmtVO>
	 * @exception EventException
	 */
	public List<MdmSvcScpLmtVO> searchEServiceCompensationOrigiComboList(MdmSvcScpLmtVO mdmSvcScpLmtVO) throws EventException {
		try {
			return dbDao.searchEServiceCompensationOrigiComboList(mdmSvcScpLmtVO);
		} catch(DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * E-SVC Compensation 에서 SC No. 존재여부를 조회합니다.<br>
	 *
	 * @param PriSpHdrVO priSpHdrVO
	 * @return String
	 * @exception EventException
	 */
	public String searchEServiceCompensationSCNo(PriSpHdrVO priSpHdrVO) throws EventException {
		try {
			return dbDao.searchEServiceCompensationSCNo(priSpHdrVO);
		} catch(DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * E-SVC Compensation 에서 RFA NO. 존재여부를 조회합니다.<br>
	 * 
	 * @param PriRpHdrVO priRpHdrVO
	 * @return String
	 * @exception EventException
	 */
	public String searchEServiceCompensationRFANo(PriRpHdrVO priRpHdrVO) throws EventException {
		try {
			return dbDao.searchEServiceCompensationRFANo(priRpHdrVO);
		} catch(DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}

    /**
     * E-SVC Compensation 정보를 저장합니다.<br>
     * 
     * @param PriCmpnEsvcVO[] priCmpnEsvcVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageEServiceCompensation(PriCmpnEsvcVO[] priCmpnEsvcVOs, SignOnUserAccount account) throws EventException {

        try {
            List<PriCmpnEsvcVO> insertVoList = new ArrayList<PriCmpnEsvcVO>();
            List<PriCmpnEsvcVO> updateVoList = new ArrayList<PriCmpnEsvcVO>();
            List<PriCmpnEsvcVO> deleteVoList = new ArrayList<PriCmpnEsvcVO>();
            PriCmpnEsvcVO priCmpnEsvcVO = new PriCmpnEsvcVO();

            for (int i = 0, n = priCmpnEsvcVOs.length ; i < n ; i++) {
            
                if (priCmpnEsvcVOs[i].getIbflag().equals("I") || priCmpnEsvcVOs[i].getIbflag().equals("U")) {
                    priCmpnEsvcVOs[i].setCreUsrId(account.getUsr_id());
                    priCmpnEsvcVOs[i].setUpdUsrId(account.getUsr_id());

                    // 자리수에 따라 RFA,SC No로
                    if (priCmpnEsvcVOs[i].getScNo().length() == 8 || priCmpnEsvcVOs[i].getScNo().length() == 9) {
                        priCmpnEsvcVOs[i].setPrcCtrtTpCd("S"); // S/C
                        priCmpnEsvcVOs[i].setRfaNo("");
                    } else {
                        priCmpnEsvcVOs[i].setPrcCtrtTpCd("R"); // RFA
                        priCmpnEsvcVOs[i].setRfaNo(priCmpnEsvcVOs[i].getScNo());
                        priCmpnEsvcVOs[i].setScNo("");
                    }
                    
                    if (priCmpnEsvcVOs[i].getIbflag().equals("I")) {
                        insertVoList.add(priCmpnEsvcVOs[i]);
                    } else {
                        updateVoList.add(priCmpnEsvcVOs[i]);
                    }
                } else if (priCmpnEsvcVOs[i].getIbflag().equals("D")) {
                    priCmpnEsvcVOs[i].setUpdUsrId(account.getUsr_id());
                    deleteVoList.add(priCmpnEsvcVOs[i]);
                }
            }
            
            // 삭제
            if (deleteVoList.size() > 0) {
                dbDao.removeEServiceCompensationTP(deleteVoList);
                dbDao.removeEServiceCompensation(deleteVoList);
            }

            // 수정
            if (updateVoList.size() > 0) {
                dbDao.modifyEServiceCompensation(updateVoList);
                dbDao.removeEServiceCompensationTP(updateVoList);

                for (int i = 0, n = updateVoList.size() ; i < n ; i++) {
                    priCmpnEsvcVO = updateVoList.get(i);
                    if (priCmpnEsvcVO.getPrcEsvcTpCdW().equals("1")) {
                        dbDao.addEServiceCompensationTPW(priCmpnEsvcVO);
                    }
                    if (priCmpnEsvcVO.getPrcEsvcTpCdE().equals("1")) {
                        dbDao.addEServiceCompensationTPE(priCmpnEsvcVO);
                    }
                    if (priCmpnEsvcVO.getPrcEsvcTpCdD().equals("1")) {
                        dbDao.addEServiceCompensationTPD(priCmpnEsvcVO);
                    }                    
                }
            }

            // 생성
            for (int i = 0, n = insertVoList.size() ; i < n ; i++) {
                priCmpnEsvcVO = insertVoList.get(i);
                priCmpnEsvcVO.setCmpnSeq(dbDao.searchEServiceCompensationNewCmpnSeq(priCmpnEsvcVO));
                dbDao.addEServiceCompensation(priCmpnEsvcVO);

                if (priCmpnEsvcVO.getPrcEsvcTpCdW().equals("1")) {
                    dbDao.addEServiceCompensationTPW(priCmpnEsvcVO);
                }
                if (priCmpnEsvcVO.getPrcEsvcTpCdE().equals("1")) {
                    dbDao.addEServiceCompensationTPE(priCmpnEsvcVO);
                }
                if (priCmpnEsvcVO.getPrcEsvcTpCdD().equals("1")) {
                    dbDao.addEServiceCompensationTPD(priCmpnEsvcVO);
                }
            }
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
        }
    }
}