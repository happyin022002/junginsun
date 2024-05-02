/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAQuotationMainBCImpl.java
*@FileTitle : RFA Quotation Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.09.02 이승준
* 1.0 Creation
=========================================================
* History
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.integration.RFAQuotationMainDBDAO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RFAQutationMainVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltCopyToQuotationVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltPriRqMnChkNeedCalcVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltPriRqMnVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltSearchDetailCntVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltSearchGlineExistVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.PriRqRtCmdtRoutSetVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriRqHdrVO;
import com.hanjin.syscommon.common.table.PriRqMnVO;
import com.hanjin.syscommon.common.table.PriRqRtCmdtRoutVO;

/**
 * ALPS-RFAQuotation Business Logic Command Interface<br>
 * - ALPS-RFAQuotation에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Seung-Jun,Lee
 * @see Esm_pri_6014EventResponse 참조
 * @since J2EE 1.6
 */
public class RFAQuotationMainBCImpl extends BasicCommandSupport implements RFAQuotationMainBC {

	// Database Access Object
	private transient RFAQuotationMainDBDAO dbDao = null;

	/**
	 * RFAQuotationMainBCImpl 객체 생성<br>
	 * RFAQuotationMainDBDAO를 생성한다.<br>
	 */
	public RFAQuotationMainBCImpl() {
		dbDao = new RFAQuotationMainDBDAO();
	}
	
	
	/**
	 * Max Qttn No를 조회한다.<br>
	 * 
	 * @param PriRqHdrVO priRqHdrVO
	 * @return String
	 * @exception EventException
	 */
	public String searchRfaQuotationHeaderMaxQttnNo(PriRqHdrVO priRqHdrVO) throws EventException {
		try {
			return dbDao.searchRFAQuotationHeaderMaxQttnNo(priRqHdrVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
		
	}
	
	
	/**
	 * Quotation Main 정보를 조회한다.<br>
	 * 
	 * @param RsltPriRqMnVO rsltPriRqMnVO
	 * @return List<RsltPriRqMnVO>
	 * @exception EventException
	 */
	public List<RsltPriRqMnVO> searchRfaQuotationMainList(RsltPriRqMnVO rsltPriRqMnVO) throws EventException {
		try {
			return dbDao.searchRFAQuotationMainList(rsltPriRqMnVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
		
	}
	
	
	/**
	 * Quotation 에 calculate를 수행 했는지 조회한다.<br>
	 * 
	 * @param RsltPriRqMnVO rsltPriRqMnVO
	 * @return List<RsltPriRqMnChkNeedCalcVO>
	 * @exception EventException
	 */
	public List<RsltPriRqMnChkNeedCalcVO> searchRfaQuotationMainChkNeedCalcList(RsltPriRqMnVO rsltPriRqMnVO) throws EventException {
		try {
			return dbDao.searchRFAQuotationMainChkNeedCalcList(rsltPriRqMnVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
		
	}
	
	
	
	/**
	 * RFA Quotation Main Inquiry(ESM_PRI_6015).<br>
	 * 
	 * @param RsltPriRqMnVO rsltPriRqMnVO
	 * @return List<RsltPriRqMnVO>
	 * @exception EventException
	 */
	public List<RsltPriRqMnVO> searchRfaQuotationMainReportList(RsltPriRqMnVO rsltPriRqMnVO) throws EventException {
		try {
			return dbDao.searchRFAQuotationMainReportList(rsltPriRqMnVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
		
	}
	
	/**
	 * GLINE 존재여부 체크.<br>
	 * 
	 * @param RsltPriRqMnVO rsltPriRqMnVO
	 * @return List<RsltSearchGlineExistVO>
	 * @exception EventException
	 */
	public List<RsltSearchGlineExistVO> searchGlineExist(RsltPriRqMnVO rsltPriRqMnVO) throws EventException {
		try {
			return dbDao.searchGlineExist(rsltPriRqMnVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
		
	}
	
	
	/**
	 * 텝별 건수 조회.<br>
	 * 
	 * @param RsltPriRqMnVO rsltPriRqMnVO
	 * @return List<RsltSearchDetailCntVO>
	 * @exception EventException
	 */
	public List<RsltSearchDetailCntVO> searchDetailCnt(RsltPriRqMnVO rsltPriRqMnVO) throws EventException {
		try {
			return dbDao.searchDetailCnt(rsltPriRqMnVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
		
	}
	
	
	/**
	 * Copy to Proposal 전 calculate 했는지 체크한다.<br>
	 * 
	 * @param RsltPriRqMnVO rsltPriRqMnVO
	 * @return String
	 * @throws DAOException
	 */
	public String checkCalculate(RsltPriRqMnVO rsltPriRqMnVO) throws EventException {
		try {
			return dbDao.searchCheckCalculate(rsltPriRqMnVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
		
	}
	
	
	/**
	 * cmdt seq 별 rate data가 있는지 체크한다.<br>
	 * 
	 * @param RsltPriRqMnVO rsltPriRqMnVO
	 * @return String
	 * @throws DAOException
	 */
	public String checkExistRate(RsltPriRqMnVO rsltPriRqMnVO) throws EventException {
		try {
			return dbDao.searchCheckExistRate(rsltPriRqMnVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
		
	}
	
	
	/**
	 * Copy 할 Gline seq를 조회한다.<br>
	 * 
	 * @param RsltPriRqMnVO rsltPriRqMnVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchCopyGlineSeq(RsltPriRqMnVO rsltPriRqMnVO) throws EventException {
		try {
			return dbDao.searchCopyGlineSeq(rsltPriRqMnVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
		
	}
	
	
	/**
	 * PRI_RQ_HDR, PRI_RQ_MN 테이블 정보를 저장한다.<br>
	 * 
	 * @param RFAQutationMainVO qutationMainVO
	 * @param account SignOnUserAccount
	 * @return RsltPriRqMnVO
	 * @exception EventException
	 */
	public RsltPriRqMnVO manageRfaQuotationMain(RFAQutationMainVO qutationMainVO, SignOnUserAccount account) throws EventException{
		try {

			PriRqHdrVO priRqHdrVO = qutationMainVO.getPriRqHdrVO();
			PriRqMnVO priRqMnVO = qutationMainVO.getPriRqMnVO();
			RsltPriRqMnVO rsltPriRqMnVO = qutationMainVO.getRsltPriRqMnVO();
			
			//quotation no
			String qttn_no = "";
			//quotation no
			String qttn_ver_no = "Q1";
			
			//header
			if(priRqMnVO != null) {
				//입력이면 max seq를 조회한 후 등록
				if(rsltPriRqMnVO.getQttnNoHidden() == null || "".equals(rsltPriRqMnVO.getQttnNoHidden()) ) {
					
					//max quotation no  
					qttn_no = dbDao.searchRFAQuotationHeaderMaxQttnNo(priRqHdrVO);
					
					priRqHdrVO.setQttnNo(qttn_no);
					priRqHdrVO.setQttnStsCd("N");
					
					priRqHdrVO.setCreUsrId(account.getUsr_id());
					priRqHdrVO.setUpdUsrId(account.getUsr_id());
					dbDao.addRFAQuotationHeader(priRqHdrVO);
					
					
					//main
					priRqMnVO.setQttnNo(qttn_no);
					priRqMnVO.setQttnVerNo(qttn_ver_no);
					
					priRqMnVO.setCreUsrId(account.getUsr_id());
					priRqMnVO.setUpdUsrId(account.getUsr_id());
					dbDao.addRFAQuotationMain(priRqMnVO);
					
					
				}
				//수정
				else {
					//header
					priRqHdrVO.setUpdUsrId(account.getUsr_id());
					dbDao.modifyRFAQuotationHeader(priRqHdrVO);
					
					//add version => quotation no가 not null and version no 가  null인 경우 js에서 '-1'로 세팅
					if("-1".equals(rsltPriRqMnVO.getQttnVerNoHidden()) ) {
						//main
						priRqMnVO.setCreUsrId(account.getUsr_id());
						priRqMnVO.setUpdUsrId(account.getUsr_id());
						dbDao.addRFAQuotationMain(priRqMnVO);
						
					} else {
						//main
						priRqMnVO.setUpdUsrId(account.getUsr_id());
						dbDao.modifyRFAQuotationMain(priRqMnVO);
					}
							
				}
				
			}
			
			if(rsltPriRqMnVO != null) {
				rsltPriRqMnVO.setQttnNo(priRqMnVO.getQttnNo());
				rsltPriRqMnVO.setQttnVerNo(priRqMnVO.getQttnVerNo());
			}
			
			return rsltPriRqMnVO;
			
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * 상태코드 cancel 저장<br>
	 * 
	 * @param PriRqHdrVO priRqHdrVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void cancelStatusRfaQuotationMain(PriRqHdrVO priRqHdrVO, SignOnUserAccount account) throws EventException{
		try {

			priRqHdrVO.setUpdUsrId(account.getUsr_id());
			dbDao.modifyRFAQuotationHeaderStatus(priRqHdrVO);
					
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	
	/**
	 * copyToProposal 시 prop_no 저장<br>
	 * 
	 * @param PriRqMnVO priRqMnVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyRFAQuotationMainPropNo(PriRqMnVO priRqMnVO, SignOnUserAccount account) throws EventException{
		try {
			priRqMnVO.setUpdUsrId(account.getUsr_id());
			dbDao.modifyRFAQuotationMainPropNo(priRqMnVO);
					
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}

    /**
     * Proposal 삭제 시 해당하는 Quotation Header qttn_sts_cd 를 N으로<br>
     * Quotation Main 의 Prop No 를 공백으로 업데이트 합니다.<br>
     * 
     * @param PriRqMnVO priRqMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void modifyRFAQuotationMainPropNoDel(PriRqMnVO priRqMnVO, SignOnUserAccount account) throws EventException {
        try {
            priRqMnVO.setUpdUsrId(account.getUsr_id());
            dbDao.modifyRFAQuotationHdrStsCd(priRqMnVO);
            dbDao.modifyRFAQuotationMainPropNoDel(priRqMnVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
        }
    }

	/**
	 * COPY TO QUOTATION PRI_RQ_HDR, PRI_RQ_MN<br>
	 * 
	 * @param RsltCopyToQuotationVO rsltCopyToQuotationVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void copyToQuotationRfaQuotaionMainReport(RsltCopyToQuotationVO rsltCopyToQuotationVO, SignOnUserAccount account) 
		throws EventException{
		try {
			rsltCopyToQuotationVO.setCreUsrId(account.getUsr_id());
			rsltCopyToQuotationVO.setUpdUsrId(account.getUsr_id());
			//srep
			rsltCopyToQuotationVO.setQttnOfcCd(account.getOfc_cd());
			rsltCopyToQuotationVO.setQttnSrepCd(account.getSrep_cd());
			
			//add version 과 copy to quotation 구분
			if("".equals(rsltCopyToQuotationVO.getCopyType())) {
				dbDao.addCopyToQuotationRfaQuotationHeader(rsltCopyToQuotationVO);
			}	
			dbDao.addCopyToQuotationRfaQuotationMain(rsltCopyToQuotationVO);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * REMOVE PRI_RQ_HDR, PRI_RQ_MN BY QTTN NO<br>
	 * 
	 * @param PriRqHdrVO priRqHdrVO
	 * @exception EventException
	 */
	public void removeRfaQuotationMain(PriRqHdrVO priRqHdrVO) throws EventException{
		try {
			
			dbDao.removeRfaQuotationMain(priRqHdrVO);
			dbDao.removeRFAQuotationHeader(priRqHdrVO);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	
	/**
	 * CM/OP View 의 CM 값을 갱신처리 합니다.<BR>
	 * 
	 * @param  PriRqRtCmdtRoutSetVO priRqRtCmdtRoutSetVO
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyPrsPriRqMnCm(PriRqRtCmdtRoutSetVO priRqRtCmdtRoutSetVO, SignOnUserAccount account)
			throws EventException {
		try {
			List<PriRqRtCmdtRoutVO> updateVoList = new ArrayList<PriRqRtCmdtRoutVO>();
			String pfmcUnit = priRqRtCmdtRoutSetVO.getPfmcUnit();
			PriRqRtCmdtRoutVO[] priRqRtCmdtRoutVO = priRqRtCmdtRoutSetVO.getPriRqRtCmdtRoutVOS();
 
			for (int i = 0; i < priRqRtCmdtRoutVO.length; i++) {
				if (priRqRtCmdtRoutVO[i].getIbflag().equals("U")) {
					priRqRtCmdtRoutVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priRqRtCmdtRoutVO[i]);
					break;
				} 
			} 

			if (updateVoList.size() > 0) {  
				dbDao.modifyPrsPriRqMnCm(updateVoList.get(0),pfmcUnit);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	
	
	
}