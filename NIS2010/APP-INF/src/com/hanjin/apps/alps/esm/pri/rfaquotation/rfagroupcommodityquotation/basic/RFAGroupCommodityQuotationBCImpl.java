/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAGroupCommodityQuotationBCImpl.java
*@FileTitle : RFA Quotation Commodity Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.09.03 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfagroupcommodityquotation.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfagroupcommodityquotation.integration.RFAGroupCommodityQuotationDBDAO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfagroupcommodityquotation.vo.RFAGroupCommodityQuotationVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfagroupcommodityquotation.vo.RsltPriRqGrpCmdtDtlVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfagroupcommodityquotation.vo.RsltPriRqGrpCmdtVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltCopyToQuotationVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltPriRqMnVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltSearchGlineExistVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriRqGrpCmdtDtlVO;
import com.hanjin.syscommon.common.table.PriRqGrpCmdtVO;
import com.hanjin.syscommon.common.table.PriRqHdrVO;

/**
 * ALPS-RFAQuotation Business Logic Command Interface<br>
 * - ALPS-RFAQuotation에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Seung-Jun,Lee
 * @see Esm_pri_6014_2EventResponse 참조 
 * @since J2EE 1.6
 */
public class RFAGroupCommodityQuotationBCImpl extends BasicCommandSupport implements RFAGroupCommodityQuotationBC {

	// Database Access Object
	private transient RFAGroupCommodityQuotationDBDAO dbDao = null;

	/**
	 * RFAGroupCommodityQuotationBCImpl 객체 생성<br>
	 * RFAGroupCommodityQuotationDBDAO를 생성한다.<br>
	 */
	public RFAGroupCommodityQuotationBCImpl() {
		dbDao = new RFAGroupCommodityQuotationDBDAO();
	}
	/**
	 * Group Commodity detail search.<br>
	 * 
	 * @param PriRqGrpCmdtVO priRqGrpCmdtVO 
	 * @return List<RsltPriRqGrpCmdtDtlVO>
	 * @exception EventException
	 */
	public List<RsltPriRqGrpCmdtDtlVO> searchGroupCommodityDetailList(PriRqGrpCmdtVO priRqGrpCmdtVO) throws EventException {
		try {
			return dbDao.searchGroupCommodityDetailList(priRqGrpCmdtVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
		
	}
	
	/**
	 * Group Commodity search.<br>
	 * 
	 * @param PriRqGrpCmdtVO priRqGrpCmdtVO 
	 * @return List<RsltPriRqGrpCmdtVO>
	 * @exception EventException
	 */
	public List<RsltPriRqGrpCmdtVO> searchRfaGroupCommodityQuotationList(PriRqGrpCmdtVO priRqGrpCmdtVO) throws EventException {
		try {
			return dbDao.searchRfaGroupCommodityQuotationList(priRqGrpCmdtVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
		
	}
	
	
	/**
	 * PRI_SQ_GRP_CMDT, PRI_SQ_GRP_CMDT_DTL을 입력 수정 삭제한다<br>
	 * 
	 * @param RFAGroupCommodityQuotationVO groupCommodityQuotationVO 
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageRfaGroupCommodityQuotation(RFAGroupCommodityQuotationVO groupCommodityQuotationVO, SignOnUserAccount account) 
		throws EventException{
		try {
			
			//컨테이너 vo에서 loc, detail을 뺀다
			PriRqGrpCmdtVO priRqGrpCmdtVO 			= groupCommodityQuotationVO.getPriRqGrpCmdtVO();
			PriRqGrpCmdtVO[] priRqGrpCmdtVOs 		= groupCommodityQuotationVO.getPriRqGrpCmdtVOs();
			PriRqGrpCmdtDtlVO[] priRqGrpCmdtDtlVOs 	= groupCommodityQuotationVO.getPriRqGrpCmdtDtlVOs();
			
			//location
			List<PriRqGrpCmdtVO> insertVoList = new ArrayList<PriRqGrpCmdtVO>();
			List<PriRqGrpCmdtVO> updateVoList = new ArrayList<PriRqGrpCmdtVO>();
			List<PriRqGrpCmdtVO> deleteVoList = new ArrayList<PriRqGrpCmdtVO>();
			//location detail 
			List<PriRqGrpCmdtDtlVO> insertDtlVoList = new ArrayList<PriRqGrpCmdtDtlVO>();
			List<PriRqGrpCmdtDtlVO> updateDtlVoList = new ArrayList<PriRqGrpCmdtDtlVO>();
			List<PriRqGrpCmdtDtlVO> deleteDtlVoList = new ArrayList<PriRqGrpCmdtDtlVO>();

			
			
			////////////////////////////commodity / detail 저장/////////////////////////////////////	
			int max_cmdt_seq = -1;
			
			
			//Group Location
			for (int i = 0; priRqGrpCmdtVOs != null && i < priRqGrpCmdtVOs.length; i++) {
				
				if ( priRqGrpCmdtVOs[i].getIbflag().equals("I")){
					
//					if("".equals(priRqGrpCmdtVOs[i].getGrpCmdtSeq()) || priRqGrpCmdtVOs[i].getGrpCmdtSeq() == null) {
						max_cmdt_seq = dbDao.searchGroupCommodityQuotationMaxGrpCmdtSeq(priRqGrpCmdtVO);
//					} 
					
					//cmdt seq
					priRqGrpCmdtVOs[i].setGrpCmdtSeq(String.valueOf(max_cmdt_seq+i));
					
					priRqGrpCmdtVOs[i].setCreUsrId(account.getUsr_id());
					priRqGrpCmdtVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priRqGrpCmdtVOs[i]);
				} else if ( priRqGrpCmdtVOs[i].getIbflag().equals("U")){
					priRqGrpCmdtVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priRqGrpCmdtVOs[i]);
				} else if ( priRqGrpCmdtVOs[i].getIbflag().equals("D")){
					priRqGrpCmdtVOs[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(priRqGrpCmdtVOs[i]);
					//본문별 디테일 삭제
					
						dbDao.removeRfaGroupCommodityQuotationDetail(priRqGrpCmdtVOs[i]);
						//디테일을 이미 삭제 했으므로 널로 세팅
						priRqGrpCmdtDtlVOs = null;
					
					
				}
				
			}
			
			//마스터가 신규인 경우
			if(max_cmdt_seq != -1)
				priRqGrpCmdtVO.setGrpCmdtSeq(String.valueOf(max_cmdt_seq));
			else
				max_cmdt_seq = Integer.parseInt(priRqGrpCmdtVO.getGrpCmdtSeq());
			
			int max_cmdt_dtl_seq = dbDao.searchGroupCommodityQuotationMaxGrpLocDtlSeq(priRqGrpCmdtVO);
			
			//detail
			for (int i = 0; priRqGrpCmdtDtlVOs != null && i < priRqGrpCmdtDtlVOs.length; i++) {
				
				if ( priRqGrpCmdtDtlVOs[i].getIbflag().equals("I")) {
					//loc seq
					priRqGrpCmdtDtlVOs[i].setGrpCmdtSeq(String.valueOf(max_cmdt_seq));
					//loc dtl seq
					priRqGrpCmdtDtlVOs[i].setGrpCmdtDtlSeq(String.valueOf(max_cmdt_dtl_seq+i));
					priRqGrpCmdtDtlVOs[i].setCreUsrId(account.getUsr_id());
					priRqGrpCmdtDtlVOs[i].setUpdUsrId(account.getUsr_id());
					insertDtlVoList.add(priRqGrpCmdtDtlVOs[i]);
				} else if ( priRqGrpCmdtDtlVOs[i].getIbflag().equals("U")){
					//loc seq
					priRqGrpCmdtDtlVOs[i].setGrpCmdtSeq(String.valueOf(max_cmdt_seq));
					priRqGrpCmdtDtlVOs[i].setUpdUsrId(account.getUsr_id());
					updateDtlVoList.add(priRqGrpCmdtDtlVOs[i]);
				} else if ( priRqGrpCmdtDtlVOs[i].getIbflag().equals("D")){
					//loc seq
					priRqGrpCmdtDtlVOs[i].setGrpCmdtSeq(String.valueOf(max_cmdt_seq));
					deleteDtlVoList.add(priRqGrpCmdtDtlVOs[i]);
				}
			}
			
			if (deleteDtlVoList.size() > 0) {
				dbDao.removeRfaGroupCommodityQuotationDetailS(deleteDtlVoList);
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeRfaGroupCommodityQuotationS(deleteVoList);
			}
			
			if (insertVoList.size() > 0) {
				dbDao.addRfaGroupCommodityQuotationS(insertVoList);
			}
			if (insertDtlVoList.size() > 0) {
				dbDao.addRfaGroupCommodityQuotationDetailS(insertDtlVoList);
			}
			
			if (updateVoList.size() > 0) {
				dbDao.modifyRfaGroupCommodityQuotationS(updateVoList);
			}
			if (updateDtlVoList.size() > 0) {
				dbDao.modifyRfaGroupCommodityQuotationDetailS(updateDtlVoList);
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
	 * PRI_SQ_GRP_CMDT, PRI_SQ_GRP_CMDT_DTL 에 가이드라인 정보를 조회 입력한다<br>
	 * 
	 * @param RsltPriRqMnVO priRqHdrVO 
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void glineCopyRfaGroupCommodityQuotation(RsltPriRqMnVO priRqHdrVO, SignOnUserAccount account) 
		throws EventException{
		try {
			priRqHdrVO.setCreUsrId(account.getUsr_id());
			priRqHdrVO.setUpdUsrId(account.getUsr_id());
			
			dbDao.addGlineCopyRfaGroupCommodityQuotation(priRqHdrVO);
			dbDao.addGlineCopyRfaGroupCommodityQuotationDetail(priRqHdrVO);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	
	/**
     * Guideline TPW Commodity Group 을 Copy 합니다.<br>
     * 
     * @param vo  RsltSearchGlineExistVO
     * @param account SignOnUserAccount
     * @exception EventException
     */
    public void copyScopeGuidelineGrpCmdtTpw (RsltSearchGlineExistVO vo, SignOnUserAccount account) throws EventException{
        try {
            vo.setCreUsrId(account.getUsr_id());
            vo.setUpdUsrId(account.getUsr_id());
            String master = vo.getCmdtTpwMst();
            String detail = vo.getCmdtTpwDtl();
            String[] mstRows = null;
            String[] mstKeys = null;
            String[] dtlArr = null;
            String[] dtlRows = null;
            String[] dtlKeys = null;
            RsltSearchGlineExistVO cmdtVo = new RsltSearchGlineExistVO();
            
            if (master != null) {
                mstRows = master.split(";");
                
                for(int y=0; y<mstRows.length; y++) {
                	log.debug("mstRows[" + y + "]" + mstRows[y]);
                }

                for (int i = 0, n = mstRows.length ; i < n ; i++) {
                    mstKeys = mstRows[i].split("\\|");
                    if (mstKeys.length < 4) {
                        continue;
                    }
                    
                    cmdtVo = new RsltSearchGlineExistVO();
                    ObjectCloner.build(vo, cmdtVo);
                    cmdtVo.setGrpCmdtSeq(mstKeys[3]);
                    cmdtVo.setNewGrpCmdtSeq(mstKeys[3]);
                    dbDao.addGlineCopyRfaGroupCommodityQuotation(cmdtVo);    
                }
            }
            
            if (detail != null) {
                dtlArr = detail.split(",");
                
                for (int i = 0, n = dtlArr.length ; i < n ; i++) {
                    dtlRows = dtlArr[i].split(";");

                    for (int j = 0, m = dtlRows.length ; j < m ; j++) {
                        dtlKeys = dtlRows[j].split("\\|");
                        if (dtlKeys.length < 5) {
                            continue;
                        }
                        RsltSearchGlineExistVO cmdtDtlVo = new RsltSearchGlineExistVO();
                        ObjectCloner.build(vo, cmdtDtlVo);
                        cmdtDtlVo.setGrpCmdtSeq(dtlKeys[3]);
                        cmdtDtlVo.setGrpCmdtDtlSeq(dtlKeys[4]);
                        cmdtDtlVo.setNewGrpCmdtSeq(dtlKeys[3]);
                        cmdtDtlVo.setNewGrpCmdtDtlSeq(dtlKeys[4]);
                        dbDao.addGlineCopyRfaGroupCommodityQuotationDetail(cmdtDtlVo);
                    }
                }
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
	 * COPY TO QUOTATION Group commodity<br>
	 * 
	 * @param RsltCopyToQuotationVO rsltCopyToQuotationVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void copyToQuotationRfaGroupCommodityQuotaionReport(RsltCopyToQuotationVO rsltCopyToQuotationVO, SignOnUserAccount account) 
		throws EventException{
		try {
			rsltCopyToQuotationVO.setCreUsrId(account.getUsr_id());
			rsltCopyToQuotationVO.setUpdUsrId(account.getUsr_id());
			
			//office
			rsltCopyToQuotationVO.setQttnOfcCd(account.getOfc_cd());
			
			dbDao.addCopyToQuotationRfaGroupCommodityQuotation(rsltCopyToQuotationVO);
			dbDao.addCopyToQuotationRfaGroupCommodityQuotationDetail(rsltCopyToQuotationVO);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	
	/**
	 * REMOVE Group Commodity BY QTTN NO, QTTN VER NO<br>
	 * 
	 * @param priRqHdrVO PriRqHdrVO
	 * @exception EventException
	 */
	public void removeManageRfaGroupCommodityQuotation(PriRqHdrVO priRqHdrVO) throws EventException{
		try {
			dbDao.removeRfaGroupCommodityQuotationDetail(priRqHdrVO);
			dbDao.removeRfaGroupCommodityQuotation(priRqHdrVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	
	/**
	 * Rate에서 사용하는 commodity 코드가 있는지 조회한다.
	 * @param RFAGroupCommodityQuotationVO groupCommodityQuotationVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkGroupCommodityInUse(RFAGroupCommodityQuotationVO groupCommodityQuotationVO) throws EventException {
		try {
			List<RsltCdListVO> rslt = new ArrayList<RsltCdListVO>();
			
			PriRqGrpCmdtVO[] priRqGrpCmdtVOs = groupCommodityQuotationVO.getPriRqGrpCmdtVOs();
			
			for (int i = 0; i < priRqGrpCmdtVOs.length; i++) {
				
				PriRqGrpCmdtVO row = priRqGrpCmdtVOs[i];

				RsltCdListVO cdVO = dbDao.searchCheckGroupCommodityInUse(row);
				
				if (cdVO != null) {						
					rslt.add(cdVO);
				}
			}
			
			return rslt;

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}	
	
}