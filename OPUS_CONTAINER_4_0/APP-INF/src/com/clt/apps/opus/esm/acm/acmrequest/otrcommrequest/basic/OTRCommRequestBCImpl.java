/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : OTRCommRequestBCImpl.java
*@FileTitle : OTRCommRequestBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.02
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.04.02 김영오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmrequest.otrcommrequest.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.acm.acmrequest.otrcommrequest.integration.OTRCommRequestDBDAO;
import com.clt.apps.opus.esm.acm.acmrequest.otrcommrequest.vo.OTRCommRequestVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-ACMRequest Business Logic Command Interface<br>
 * - OPUS-ACMReques에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM YOUNG-OH
 * @see Esm_Acm_0014Event,OTRCommRequestBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class OTRCommRequestBCImpl extends BasicCommandSupport implements OTRCommRequestBC {

	// Database Access Object
	private transient OTRCommRequestDBDAO dbDao = null;

	/**
	 * OTRCommRequestBCImpl 객체 생성<br>
	 * OTRCommRequestDBDAO를 생성한다.<br>
	 */
	public OTRCommRequestBCImpl() {
		dbDao = new OTRCommRequestDBDAO();
	}

	/**
	 * [ESM_ACM_0014]
	 * Other Commission Request 목록을 조회<br>
	 *
	 * @param OTRCommRequestVO otrCommRequestVO
	 * @return List<OTRCommRequestVO>
	 * @exception EventException
	 */
	public List<OTRCommRequestVO> searchOTRCommRequest(OTRCommRequestVO otrCommRequestVO) throws EventException {
		try {
			return dbDao.searchOTRCommRequest(otrCommRequestVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0014]
	 * Other Commission Request 화면의 office 및 vendor 정보를 조회한다.<br>
	 *
	 * @param OTRCommRequestVO otrCommRequestVO
	 * @return List<OTRCommRequestVO>
	 * @exception EventException
	 */
	public List<OTRCommRequestVO> searchOfficeVendorInfo(OTRCommRequestVO otrCommRequestVO) throws EventException {
		try {
			return dbDao.searchOfficeVendorInfo(otrCommRequestVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0014]
	 * Other Commission Request 화면의 Cur 변경시 , xchRt를 조회한다.<br>
	 *
	 * @param OTRCommRequestVO otrCommRequestVO
	 * @return List<OTRCommRequestVO>
	 * @exception EventException
	 */
	public List<OTRCommRequestVO> searchCurrXchRt(OTRCommRequestVO otrCommRequestVO) throws EventException {
		try {
			return dbDao.searchCurrXchRt(otrCommRequestVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0014]
	 * Other Commission Request 화면의 Add Row 시  PatmentAmt, UsdAmt를 조회한다.<br>
	 *
	 * @param OTRCommRequestVO otrCommRequestVO
	 * @return List<OTRCommRequestVO>
	 * @exception EventException
	 */
	public List<OTRCommRequestVO> searchPatmentUsdAmt(OTRCommRequestVO otrCommRequestVO) throws EventException {
		try {
			return dbDao.searchPatmentUsdAmt(otrCommRequestVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0014]
	 * Other Commission Creation & Request 목록을 수정, 삭제한다.<br>
	 *
	 * @param OTRCommRequestVO[] otrCommRequestVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageOTRCommRequest(OTRCommRequestVO[] otrCommRequestVOs, SignOnUserAccount account) throws EventException {
		try {
			String yrmon = otrCommRequestVOs[0].getCommYrmon();
			List<OTRCommRequestVO> updateVoList = new ArrayList<OTRCommRequestVO>();
			List<OTRCommRequestVO> deleteVoList = new ArrayList<OTRCommRequestVO>();
			for (int i=0; i<otrCommRequestVOs.length; i++) {
				otrCommRequestVOs[i].setUsrId(account.getUsr_id());
				otrCommRequestVOs[i].setCommYrmon(yrmon);
				if (otrCommRequestVOs[i].getIbflag().equals("U")) {
					updateVoList.add(otrCommRequestVOs[i]);
				} else if (otrCommRequestVOs[i].getIbflag().equals("D")) {
					deleteVoList.add(otrCommRequestVOs[i]);
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyOTRCommRequestAcmAgnOtrComm(updateVoList);
			}

			if (deleteVoList.size() > 0) {
				dbDao.removeOTRCommRequestAcmAgnOtrComm(deleteVoList);
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}


	/**
	 * [ESM_ACM_0014]
	 * Other Commission Creation & Request 목록을 추가한다.<br>
	 *
	 * @param OTRCommRequestVO otrCommRequestVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void otherCommissionRequestManageOTRCommRequest(OTRCommRequestVO otrCommRequestVO, SignOnUserAccount account) throws EventException {
		try {
			String yrmon = otrCommRequestVO.getCommYrmon();
			List<OTRCommRequestVO> insertVoList = new ArrayList<OTRCommRequestVO>();
			//for (int i=0; i<otrCommRequestVOs.length; i++) {
				otrCommRequestVO.setUsrId(account.getUsr_id());
				otrCommRequestVO.setCommYrmon(yrmon);
				if (otrCommRequestVO.getIbflag().equals("I"))
				{
					List<OTRCommRequestVO> verifyList = dbDao.searchOTRCommRequestNo(otrCommRequestVO);
					if ( verifyList.size() < 1){
						//[$s] does not exist!, Please check up Again!
						throw new DAOException((new ErrorHandler("ACM00009", new String[]{"Office Code(" + otrCommRequestVO.getArOfcCd() + ")"})).getMessage());
					}
					OTRCommRequestVO verifyVO = (OTRCommRequestVO)verifyList.get(0);
					if ( !"Y".equalsIgnoreCase(verifyVO.getVvdChkYn())){
						//VVD Code does not exist in VVD Code from AR Revenue And VVD Level from MDM Account.
						throw new DAOException((new ErrorHandler("ACM00009", new String[]{"VVD(" + otrCommRequestVO.getVvd()+ ")"})).getMessage());
					}
					otrCommRequestVO.setUsrId(account.getUsr_id());
					otrCommRequestVO.setOtrCommNo(verifyVO.getOtrCommNo());

					insertVoList.add(otrCommRequestVO);
					dbDao.addOTRCommRequestAcmAgnOtrComm(insertVoList);
				}
			//}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0014]
	 * Other Commission Request 목록을 Request 한다.<br>
	 *
	 * @param OTRCommRequestVO[] otrCommRequestVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void requestOTRCommRequest(OTRCommRequestVO[] otrCommRequestVOs, SignOnUserAccount account) throws EventException {
		try
		{
			for(int i=0; i<otrCommRequestVOs.length; i++)
			{
				if (otrCommRequestVOs[i].getIbflag().equals("U")){
					otrCommRequestVOs[i].setUsrId(account.getUsr_id());
					otrCommRequestVOs[i].setUsrEml(account.getUsr_eml());
					dbDao.requestOTRCommRequest(otrCommRequestVOs[i]);
				}
			}
		}catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}

	}


	/**
	 * [ESM_ACM_0014]
	 * Other Commission Request 화면의 Cur 변경시 xchRt를 조회(XCH_RT_DIV_LVL 값 4인경우 사용)<br>
	 *
	 * @param OTRCommRequestVO otrCommRequestVO
	 * @return List<OTRCommRequestVO>
	 * @exception EventException
	 */
	public List<OTRCommRequestVO> searchFxCurrRt(OTRCommRequestVO otrCommRequestVO) throws EventException {
		try {
			return dbDao.searchFxCurrRt(otrCommRequestVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0014]
	 * Other Commission Request 화면의 Cur 변경시 xchRt를 조회(XCH_RT_DIV_LVL 값 4인경우 사용)<br>
	 *
	 * @param OTRCommRequestVO otrCommRequestVO
	 * @return List<OTRCommRequestVO>
	 * @exception EventException
	 */
	public List<OTRCommRequestVO> searchPatmentFxCurrUsdAmt(OTRCommRequestVO otrCommRequestVO) throws EventException {
		try {
			return dbDao.searchPatmentFxCurrUsdAmt(otrCommRequestVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
}