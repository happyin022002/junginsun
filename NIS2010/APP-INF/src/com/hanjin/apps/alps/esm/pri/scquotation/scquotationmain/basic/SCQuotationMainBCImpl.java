/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCQuotationMainBCImpl.java
*@FileTitle : S/C Quotation Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.08.06 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.integration.SCQuotationMainDBDAO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.QutationMainVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltCopyToQuotationVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltPriSqMnChkNeedCalcVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltPriSqMnVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltSearchDetailCntVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltSearchGlineExistVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.PriSqRtCmdtRoutSetVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSqHdrVO;
import com.hanjin.syscommon.common.table.PriSqMnVO;
import com.hanjin.syscommon.common.table.PriSqRtCmdtRoutVO;

/**
 * ALPS-SCQuotation Business Logic Basic Command implementation<br>
 * - ALPS-SCQuotation에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Seung-Jun,Lee
 * @see ESM_PRI_6005EventResponse,SCQuotationMainBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class SCQuotationMainBCImpl extends BasicCommandSupport implements SCQuotationMainBC {

	// Database Access Object
	private transient SCQuotationMainDBDAO dbDao = null;

	/**
	 * SCQuotationMainBCImpl 객체 생성<br>
	 * SCQuotationMainDBDAO를 생성한다.<br>
	 */
	public SCQuotationMainBCImpl() {
		dbDao = new SCQuotationMainDBDAO();
	}
	
	/**
	 * Max Qttn No select<br>
	 * 
	 * @param PriSqHdrVO priSqHdrVO
	 * @return String
	 * @exception EventException
	 */
	public String searchScQuotationHeaderMaxQttnNo(PriSqHdrVO priSqHdrVO) throws EventException {
		try {
			return dbDao.searchScQuotationHeaderMaxQttnNo(priSqHdrVO);
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
	 * @param RsltPriSqMnVO rsltPriSqMnVO
	 * @return List<RsltPriSqMnVO>
	 * @exception EventException
	 */
	public List<RsltPriSqMnVO> searchScQuotationMainList(RsltPriSqMnVO rsltPriSqMnVO) throws EventException {
		try {
			return dbDao.searchScQuotationMainList(rsltPriSqMnVO);
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
	 * @param RsltPriSqMnVO rsltPriSqMnVO
	 * @return List<RsltPriSqMnChkNeedCalcVO>
	 * @exception EventException
	 */
	public List<RsltPriSqMnChkNeedCalcVO> searchScQuotationMainChkNeedCalcList(RsltPriSqMnVO rsltPriSqMnVO) throws EventException {
		try {
			return dbDao.searchScQuotationMainChkNeedCalcList(rsltPriSqMnVO);
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
	 * @param RsltPriSqMnVO rsltPriSqMnVO
	 * @return List<RsltSearchGlineExistVO>
	 * @exception EventException
	 */
	public List<RsltSearchGlineExistVO> searchGlineExist(RsltPriSqMnVO rsltPriSqMnVO) throws EventException {
		try {
			return dbDao.searchGlineExist(rsltPriSqMnVO);
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
	 * @param RsltPriSqMnVO rsltPriSqMnVO
	 * @return List<RsltSearchDetailCntVO>
	 * @exception EventException
	 */
	public List<RsltSearchDetailCntVO> searchDetailCnt(RsltPriSqMnVO rsltPriSqMnVO) throws EventException {
		try {
			return dbDao.searchDetailCnt(rsltPriSqMnVO);
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
	 * @param RsltPriSqMnVO rsltPriSqMnVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchCopyGlineSeq(RsltPriSqMnVO rsltPriSqMnVO) throws EventException {
		try {
			return dbDao.searchCopyGlineSeq(rsltPriSqMnVO);
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
	 * @param RsltPriSqMnVO rsltPriSqMnVO
	 * @return String
	 * @throws DAOException
	 */
	public String checkExistRate(RsltPriSqMnVO rsltPriSqMnVO) throws EventException {
		try {
			return dbDao.searchCheckExistRate(rsltPriSqMnVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
		
	}
	
	
	/**
	 * PRI_SQ_HDR, PRI_SQ_MN 정보를 저장한다.<br>
	 * 
	 * @param QutationMainVO qutationMainVO
	 * @param account SignOnUserAccount
	 * @return RsltPriSqMnVO
	 * @exception EventException
	 */
	public RsltPriSqMnVO manageScQuotationMain(QutationMainVO qutationMainVO, SignOnUserAccount account) throws EventException{
		try {

			PriSqHdrVO priSqHdrVO = qutationMainVO.getPriSqHdrVO();
			PriSqMnVO priSqMnVO = qutationMainVO.getPriSqMnVO();
			RsltPriSqMnVO rsltPriSqMnVO = qutationMainVO.getRsltPriSqMnVO();
			
			//quotation no
			String qttn_no = "";
			//quotation no
			String qttn_ver_no = "Q1";
			
			//header
			if(priSqMnVO != null) {
				//입력이면 max seq를 조회한 후 등록
				if(rsltPriSqMnVO.getQttnNoHidden() == null || "".equals(rsltPriSqMnVO.getQttnNoHidden()) ) {
					
					//max quotation no  
					qttn_no = dbDao.searchScQuotationHeaderMaxQttnNo(priSqHdrVO);
					
					priSqHdrVO.setQttnNo(qttn_no);
					priSqHdrVO.setQttnStsCd("N");
					
					priSqHdrVO.setCreUsrId(account.getUsr_id());
					priSqHdrVO.setUpdUsrId(account.getUsr_id());
					dbDao.addScQuotationHeader(priSqHdrVO);
					
					
					//main
					priSqMnVO.setQttnNo(qttn_no);
					priSqMnVO.setQttnVerNo(qttn_ver_no);
					
					priSqMnVO.setCreUsrId(account.getUsr_id());
					priSqMnVO.setUpdUsrId(account.getUsr_id());
					dbDao.addScQuotationMain(priSqMnVO);
					
					
				}
				//수정
				else {
					//header
					priSqHdrVO.setUpdUsrId(account.getUsr_id());
					dbDao.modifyScQuotationHeader(priSqHdrVO);
					
					//add version => quotation no가 not null and version no 가  null인 경우 js에서 '-1'로 세팅
					if("-1".equals(rsltPriSqMnVO.getQttnVerNoHidden()) ) {
						//main
						priSqMnVO.setCreUsrId(account.getUsr_id());
						priSqMnVO.setUpdUsrId(account.getUsr_id());
						dbDao.addScQuotationMain(priSqMnVO);
						
					} else {
						//main
						priSqMnVO.setUpdUsrId(account.getUsr_id());
						dbDao.modifyScQuotationMain(priSqMnVO);
					}
							
				}
				
			}
			
			rsltPriSqMnVO.setQttnNo(priSqMnVO.getQttnNo());
			rsltPriSqMnVO.setQttnVerNo(priSqMnVO.getQttnVerNo());
			
			return rsltPriSqMnVO;
			
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * PRI_SQ_HDR 테이블 상태코드 cancel 저장<br>
	 * 
	 * @param PriSqHdrVO priSqHdrVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void cancelStatusScQuotationMain(PriSqHdrVO priSqHdrVO, SignOnUserAccount account) throws EventException{
		try {

//			priSqHdrVO.setQttnStsCd("C");
			priSqHdrVO.setUpdUsrId(account.getUsr_id());
			dbDao.modifyScQuotationHeaderStatus(priSqHdrVO);
					
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	
	/**
	 * COPY TO QUOTATION PRI_SQ_HDR,PRI_SQ_MN<br>
	 * 
	 * @param RsltCopyToQuotationVO rsltCopyToQuotationVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void copyToQuotationScQuotaionMainReport(RsltCopyToQuotationVO rsltCopyToQuotationVO, SignOnUserAccount account) 
		throws EventException{
		try {
			rsltCopyToQuotationVO.setCreUsrId(account.getUsr_id());
			rsltCopyToQuotationVO.setUpdUsrId(account.getUsr_id());
			//srep
			rsltCopyToQuotationVO.setQttnSrepCd(account.getSrep_cd());
			 
			
			//add version 과 copy to quotation 구분
			if("".equals(rsltCopyToQuotationVO.getCopyType())) {
				//office
				rsltCopyToQuotationVO.setQttnOfcCd(account.getOfc_cd());
				dbDao.addCopyToQuotationScQuotationHeader(rsltCopyToQuotationVO);
			}	
			dbDao.addCopyToQuotationScQuotationMain(rsltCopyToQuotationVO);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	
	/**
	 * REMOVE PRI_SQ_MN BY QTTN NO<br>
	 * 
	 * @param PriSqHdrVO priSqHdrVO
	 * @exception EventException
	 */
	public void removeScQuotationMain(PriSqHdrVO priSqHdrVO) throws EventException{
		try {
			
			dbDao.removeScQuotationMain(priSqHdrVO);
			dbDao.removeScQuotationHeader(priSqHdrVO);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * SC QUOTATION INQUIRY MAIN SEARCH<br>
	 * 
	 * @param RsltPriSqMnVO rsltPriSqMnVO
	 * @return List<RsltPriSqMnVO>
	 * @exception EventException
	 */
	public List<RsltPriSqMnVO> searchScQuotationReportList(RsltPriSqMnVO rsltPriSqMnVO) throws EventException {
		try {
			return dbDao.searchScQuotationReportList(rsltPriSqMnVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
		
	}
	
	
	/**
	 * copyToProposal 시 PRI_SQ_MN 테이블 prop_no 저장<br>
	 * 
	 * @param PriSqMnVO priSqMnVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyScQuotationMainPropNo(PriSqMnVO priSqMnVO, SignOnUserAccount account) throws EventException{
		try {
			priSqMnVO.setUpdUsrId(account.getUsr_id());
			dbDao.modifyScQuotationMainPropNo(priSqMnVO);
					
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	
	/**
	 *  S/C Quotation Rate Main Table에 변경된 Load값을 이용해서 CM 값을 재 계산해서 갱신한다.<br>
	 * 
	 * @param priSqRtCmdtRoutSetVO PriSqRtCmdtRoutSetVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyPrsPriSqMnCm(PriSqRtCmdtRoutSetVO priSqRtCmdtRoutSetVO, SignOnUserAccount account)
			throws EventException {
		try {
			List<PriSqRtCmdtRoutVO> updateVoList = new ArrayList<PriSqRtCmdtRoutVO>();
			String pfmcUnit = priSqRtCmdtRoutSetVO.getPfmcUnit();
			PriSqRtCmdtRoutVO[] priSqRtCmdtRoutVO = priSqRtCmdtRoutSetVO.getPriSqRtCmdtRoutVOS();
 
			for (int i = 0; i < priSqRtCmdtRoutVO.length; i++) {
				if (priSqRtCmdtRoutVO[i].getIbflag().equals("U")) {
					priSqRtCmdtRoutVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priSqRtCmdtRoutVO[i]);
					break;
				}
			}
			if (updateVoList.size() > 0) {
				dbDao.modifyPrsPriSqMnCm(updateVoList.get(0),pfmcUnit);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}

    /**
     * Proposal 삭제 시 해당하는 Quotation Main 의 Prop No 를 공백으로 업데이트 합니다.<br>
     * 
     * @param PriSqMnVO priSqMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void modifyScQuotationMainPropNoDel(PriSqMnVO priSqMnVO, SignOnUserAccount account) throws EventException {
        try {
            priSqMnVO.setUpdUsrId(account.getUsr_id());
            dbDao.modifyScQuotationHdrStsCd(priSqMnVO);
            dbDao.modifyScQuotationMainPropNoDel(priSqMnVO);            
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
        }
    }

}