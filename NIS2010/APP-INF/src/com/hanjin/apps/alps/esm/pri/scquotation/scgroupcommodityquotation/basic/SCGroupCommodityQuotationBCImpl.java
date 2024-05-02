/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGroupCommodityQuotationBCImpl.java
*@FileTitle : S/C Quotation Commodity Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.09
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.08.09 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scquotation.scgroupcommodityquotation.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scgroupcommodityquotation.integration.SCGroupCommodityQuotationDBDAO;
import com.hanjin.apps.alps.esm.pri.scquotation.scgroupcommodityquotation.vo.GroupCommodityQuotationVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scgroupcommodityquotation.vo.RsltPriSqGrpCmdtDtlVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scgroupcommodityquotation.vo.RsltPriSqGrpCmdtVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltCopyToQuotationVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltPriSqMnVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltSearchGlineExistVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSqGrpCmdtDtlVO;
import com.hanjin.syscommon.common.table.PriSqGrpCmdtVO;
import com.hanjin.syscommon.common.table.PriSqHdrVO;

/**
 * ALPS-SCQuotation Business Logic Basic Command implementation<br>
 * - ALPS-SCQuotation에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Seung-Jun,Lee
 * @see ESM_PRI_6005_02EventResponse,SCGroupCommodityQuotationBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class SCGroupCommodityQuotationBCImpl extends BasicCommandSupport implements SCGroupCommodityQuotationBC {

	// Database Access Object
	private transient SCGroupCommodityQuotationDBDAO dbDao = null;

	/**
	 * SCGroupCommodityQuotationBCImpl 객체 생성<br>
	 * SCGroupCommodityQuotationDBDAO를 생성한다.<br>
	 */
	public SCGroupCommodityQuotationBCImpl() {
		dbDao = new SCGroupCommodityQuotationDBDAO();
	}
	/**
	 * PRI_SQ_GRP_CMDT_DTL 테이블을 조회한다.<br>
	 * 
	 * @param PriSqGrpCmdtVO priSqGrpCmdtVO
	 * @return List<RsltPriSqGrpCmdtDtlVO>
	 * @exception EventException
	 */
	public List<RsltPriSqGrpCmdtDtlVO> searchGroupCommodityDetailList(PriSqGrpCmdtVO priSqGrpCmdtVO) throws EventException {
		try {
			return dbDao.searchGroupCommodityDetailList(priSqGrpCmdtVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
		
	}
	
	/**
	 * PRI_SQ_GRP_CMDT 테이블을 조회한다.<br>
	 * 
	 * @param PriSqGrpCmdtVO priSqGrpCmdtVO
	 * @return List<RsltPriSqGrpCmdtVO>
	 * @exception EventException
	 */
	public List<RsltPriSqGrpCmdtVO> searchScGroupCommodityQuotationList(PriSqGrpCmdtVO priSqGrpCmdtVO) throws EventException {
		try {
			return dbDao.searchScGroupCommodityQuotationList(priSqGrpCmdtVO);
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
	 * @param GroupCommodityQuotationVO groupCommodityQuotationVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageScGroupCommodityQuotation(GroupCommodityQuotationVO groupCommodityQuotationVO, SignOnUserAccount account) 
		throws EventException{
		try {
			
			//컨테이너 vo에서 loc, detail을 뺀다
			PriSqGrpCmdtVO priSqGrpCmdtVO 			= groupCommodityQuotationVO.getPriSqGrpCmdtVO();
			PriSqGrpCmdtVO[] priSqGrpCmdtVOs 		= groupCommodityQuotationVO.getPriSqGrpCmdtVOs();
			PriSqGrpCmdtDtlVO[] priSqGrpCmdtDtlVOs 	= groupCommodityQuotationVO.getPriSqGrpCmdtDtlVOs();
			
			//location
			List<PriSqGrpCmdtVO> insertVoList = new ArrayList<PriSqGrpCmdtVO>();
			List<PriSqGrpCmdtVO> updateVoList = new ArrayList<PriSqGrpCmdtVO>();
			List<PriSqGrpCmdtVO> deleteVoList = new ArrayList<PriSqGrpCmdtVO>();
			//location detail 
			List<PriSqGrpCmdtDtlVO> insertDtlVoList = new ArrayList<PriSqGrpCmdtDtlVO>();
			List<PriSqGrpCmdtDtlVO> updateDtlVoList = new ArrayList<PriSqGrpCmdtDtlVO>();
			List<PriSqGrpCmdtDtlVO> deleteDtlVoList = new ArrayList<PriSqGrpCmdtDtlVO>();

			
			
			////////////////////////////commodity / detail 저장/////////////////////////////////////	
			int max_cmdt_seq = -1;
			
			
			//Group Location
			for (int i = 0; priSqGrpCmdtVOs != null && i < priSqGrpCmdtVOs.length; i++) {
				
				if ( priSqGrpCmdtVOs[i].getIbflag().equals("I")){
					
//					if("".equals(priSqGrpCmdtVOs[i].getGrpCmdtSeq()) || priSqGrpCmdtVOs[i].getGrpCmdtSeq() == null) {
						max_cmdt_seq = dbDao.searchGroupCommodityQuotationMaxGrpCmdtSeq(priSqGrpCmdtVO);
//					} 
					
					//cmdt seq
					priSqGrpCmdtVOs[i].setGrpCmdtSeq(String.valueOf(max_cmdt_seq+i));
					
					priSqGrpCmdtVOs[i].setCreUsrId(account.getUsr_id());
					priSqGrpCmdtVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priSqGrpCmdtVOs[i]);
				} else if ( priSqGrpCmdtVOs[i].getIbflag().equals("U")){
					priSqGrpCmdtVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priSqGrpCmdtVOs[i]);
				} else if ( priSqGrpCmdtVOs[i].getIbflag().equals("D")){
					priSqGrpCmdtVOs[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(priSqGrpCmdtVOs[i]);
					//본문별 디테일 삭제
					
						dbDao.removeScGroupCommodityQuotationDetail(priSqGrpCmdtVOs[i]);
						//디테일을 이미 삭제 했으므로 널로 세팅
						priSqGrpCmdtDtlVOs = null;
					
					
				}
				
			}
			
			//마스터가 신규인 경우
			if(max_cmdt_seq != -1)
				priSqGrpCmdtVO.setGrpCmdtSeq(String.valueOf(max_cmdt_seq));
			else
				max_cmdt_seq = Integer.parseInt(priSqGrpCmdtVO.getGrpCmdtSeq());
			
			int max_cmdt_dtl_seq = dbDao.searchGroupCommodityQuotationMaxGrpLocDtlSeq(priSqGrpCmdtVO);
			
			//detail
			for (int i = 0; priSqGrpCmdtDtlVOs != null && i < priSqGrpCmdtDtlVOs.length; i++) {
				
				if ( priSqGrpCmdtDtlVOs[i].getIbflag().equals("I")) {
					//loc seq
					priSqGrpCmdtDtlVOs[i].setGrpCmdtSeq(String.valueOf(max_cmdt_seq));
					//loc dtl seq
					priSqGrpCmdtDtlVOs[i].setGrpCmdtDtlSeq(String.valueOf(max_cmdt_dtl_seq+i));
					priSqGrpCmdtDtlVOs[i].setCreUsrId(account.getUsr_id());
					priSqGrpCmdtDtlVOs[i].setUpdUsrId(account.getUsr_id());
					insertDtlVoList.add(priSqGrpCmdtDtlVOs[i]);
				} else if ( priSqGrpCmdtDtlVOs[i].getIbflag().equals("U")){
					//loc seq
					priSqGrpCmdtDtlVOs[i].setGrpCmdtSeq(String.valueOf(max_cmdt_seq));
					priSqGrpCmdtDtlVOs[i].setUpdUsrId(account.getUsr_id());
					updateDtlVoList.add(priSqGrpCmdtDtlVOs[i]);
				} else if ( priSqGrpCmdtDtlVOs[i].getIbflag().equals("D")){
					//loc seq
					priSqGrpCmdtDtlVOs[i].setGrpCmdtSeq(String.valueOf(max_cmdt_seq));
					deleteDtlVoList.add(priSqGrpCmdtDtlVOs[i]);
				}
			}
			
			if (deleteDtlVoList.size() > 0) {
				dbDao.removeScGroupCommodityQuotationDetailS(deleteDtlVoList);
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeScGroupCommodityQuotationS(deleteVoList);
			}
			
			if (insertVoList.size() > 0) {
				dbDao.addScGroupCommodityQuotationS(insertVoList);
			}
			if (insertDtlVoList.size() > 0) {
				dbDao.addScGroupCommodityQuotationDetailS(insertDtlVoList);
			}
			
			if (updateVoList.size() > 0) {
				dbDao.modifyScGroupCommodityQuotationS(updateVoList);
			}
			if (updateDtlVoList.size() > 0) {
				dbDao.modifyScGroupCommodityQuotationDetailS(updateDtlVoList);
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
	 * @param RsltPriSqMnVO priSqHdrVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void glineCopyScGroupCommodityQuotation(RsltPriSqMnVO priSqHdrVO, SignOnUserAccount account) 
		throws EventException{
		try {
			priSqHdrVO.setCreUsrId(account.getUsr_id());
			priSqHdrVO.setUpdUsrId(account.getUsr_id());
			
			dbDao.addGlineCopyScGroupCommodityQuotation(priSqHdrVO);
			dbDao.addGlineCopyScGroupCommodityQuotationDetail(priSqHdrVO);
			
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
     * @param vo RsltSearchGlineExistVO
     * @param account SignOnUserAccount
     * @exception EventException
     */
    public void copyScopeGuidelineGrpCmdtTpw (RsltSearchGlineExistVO vo, SignOnUserAccount account) throws EventException{
        try {
            vo.setCreUsrId(account.getUsr_id());
            vo.setUpdUsrId(account.getUsr_id());
//            vo.setOfcCd(account.getOfc_cd());
            String master = vo.getCmdtTpwMst();
            String detail = vo.getCmdtTpwDtl();
            String[] mstRows = null;
            String[] mstKeys = null;
            String[] dtlArr = null;
            String[] dtlRows = null;
            String[] dtlKeys = null;
//            List<SqScpGlineCopyVO> cmdtList = new ArrayList<SqScpGlineCopyVO>();
            RsltSearchGlineExistVO cmdtVo = new RsltSearchGlineExistVO();
//            ObjectCloner.build(vo, cmdtVo);
//            List<SqScpGlineCopyVO> cmdtDtlList = new ArrayList<SqScpGlineCopyVO>();
//            SpScpGlineCopyVO cmdtDtlVo = new SpScpGlineCopyVO();
//            ObjectCloner.build(vo, cmdtDtlVo);
            
            
            log.debug("master : " + master);
            log.debug("detail : " + detail);
            
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
                    
                    
                    log.debug("mstKeys " + mstKeys);
                    
                    
                    cmdtVo = new RsltSearchGlineExistVO();
                    ObjectCloner.build(vo, cmdtVo);
//                    cmdtVo.setSvcScpCd(mstKeys[0]);
//                    cmdtVo.setGlineSeq(mstKeys[1]);
//                    cmdtVo.setPrcCustTpCd(mstKeys[2]);
                    cmdtVo.setGrpCmdtSeq(mstKeys[3]);
                    cmdtVo.setNewGrpCmdtSeq(mstKeys[3]);
//                    cmdtList.add(cmdtVo);
                    dbDao.addGlineCopyScGroupCommodityQuotation(cmdtVo);    
                }
                
                // PRI_SP_SCP_GRP_CMDT COPY
//                dbDao.copyScopeGuidelineGrpCmdtTpw(vo);
                
//                if (cmdtList.size() > 0) {
//                    dbDao.copyScopeGuidelineGrpCmdtTpw(cmdtList);
//                }
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
//                        cmdtDtlVo.setPropNo(vo.getPropNo());
//                        cmdtDtlVo.setAmdtSeq(vo.getAmdtSeq());
//                        cmdtDtlVo.setEffDt(vo.getEffDt());
//                        cmdtDtlVo.setSvcScpCd(vo.getSvcScpCd());
//                        cmdtDtlVo.set
                        

//                        cmdtDtlVo = new SpScpGlineCopyVO();
//                        cmdtDtlVo.setSvcScpCd(dtlKeys[0]);
//                        cmdtDtlVo.setGlineSeq(dtlKeys[1]);
//                        cmdtDtlVo.setPrcCustTpCd(dtlKeys[2]);
                        cmdtDtlVo.setGrpCmdtSeq(dtlKeys[3]);
                        cmdtDtlVo.setGrpCmdtDtlSeq(dtlKeys[4]);
                        cmdtDtlVo.setNewGrpCmdtSeq(dtlKeys[3]);
                        cmdtDtlVo.setNewGrpCmdtDtlSeq(dtlKeys[4]);
//                        cmdtDtlList.add(cmdtDtlVo);
                        dbDao.addGlineCopyScGroupCommodityQuotationDetail(cmdtDtlVo);
                    }
                }

//                if (cmdtDtlList.size() > 0) {
//                    dbDao.copyScopeGuidelineGrpCmdtDtlTpw(cmdtDtlList);
//                }
            }

            // PRI_SP_SCP_GRP_CMDT_DTL COPY
//            dbDao.copyScopeGuidelineGrpCmdtTpwDtl(vo);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
    }
    
    
    
    /**
	 * COPY TO QUOTATION PRI_SQ_GRP_CMDT, PRI_SQ_GRP_CMDT_DTL<br>
	 * 
	 * @param RsltCopyToQuotationVO rsltCopyToQuotationVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void copyToQuotationScGroupCommodityQuotaionReport(RsltCopyToQuotationVO rsltCopyToQuotationVO, SignOnUserAccount account) 
		throws EventException{
		try {
			rsltCopyToQuotationVO.setCreUsrId(account.getUsr_id());
			rsltCopyToQuotationVO.setUpdUsrId(account.getUsr_id());
			
			//office
			rsltCopyToQuotationVO.setQttnOfcCd(account.getOfc_cd());
			
			dbDao.addCopyToQuotationScGroupCommodityQuotation(rsltCopyToQuotationVO);
			dbDao.addCopyToQuotationScGroupCommodityQuotationDetail(rsltCopyToQuotationVO);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	
	/**
	 * REMOVE PRI_SQ_GRP_CMDT, PRI_SQ_GRP_CMDT_DTL BY QTTN NO, QTTN VER NO<br>
	 * 
	 * @param PriSqHdrVO priSqHdrVO
	 * @exception EventException
	 */
	public void removeManageScGroupCommodityQuotation(PriSqHdrVO priSqHdrVO) 
		throws EventException{
		try {
			dbDao.removeScGroupCommodityQuotationDetail(priSqHdrVO);
			dbDao.removeScGroupCommodityQuotation(priSqHdrVO);
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
	 * @param GroupCommodityQuotationVO groupCommodityQuotationVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkGroupCommodityInUse(GroupCommodityQuotationVO groupCommodityQuotationVO) throws EventException {
		try {
			List<RsltCdListVO> rslt = new ArrayList<RsltCdListVO>();
			
			PriSqGrpCmdtVO[] priSqGrpCmdtVOs = groupCommodityQuotationVO.getPriSqGrpCmdtVOs();
			
			for (int i = 0; i < priSqGrpCmdtVOs.length; i++) {
				
				PriSqGrpCmdtVO row = priSqGrpCmdtVOs[i];

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