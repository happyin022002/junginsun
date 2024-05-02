/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InboundNoticeBCImpl.java
*@FileTitle : Arrival Notice Form Setting tab#1
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2009.04.28 박만건
* 1.0 Creation
* History
* 2010.10.05 이지영 [CHM-201006260-01] Arrival Notice Fax 전송시 수신자 정보에 특수문자(;)에 대해 공백 처리
* 2010.12.06 전성진 [CHM-201007381] BKG/DOC Email 전송시 User Information에 Email이 누락된 경우 IAM 메일주소로 처리
* 2012.02.15 박성호 [TOSHIBA] EDI 312 개발요청  (CHM-201115034)
* 2013.02.19 김진주 [CHM-201322860] Customer Code Error Report 보완 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo;

import org.apache.commons.lang.StringUtils;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration.ArrivalNoticeDBDAO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration.InboundNoticeEAIDAO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustCodeErrListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustCodeErrSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustRefVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustUploadListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcEdi312CntrInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcGrpSendListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcGrpSendVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcInfoListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcMrdSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcMrdVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcSendListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcWdVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrivalNoticeSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.BkgNtcSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.CustCdEvaluationVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.CustCdValidationVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.FaxSendVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.IbCustCntcHisVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.IbCustCntcVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.IntgCustSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.MdmCustomerVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.MrnRtnYdVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.NoticeVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.RDMailSendVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.framework.table.ComRptDsgnXptInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.BkgArrNtcAntfyVO;
import com.hanjin.syscommon.common.table.BkgArrNtcCntrVO;
import com.hanjin.syscommon.common.table.BkgArrNtcDtlVO;
import com.hanjin.syscommon.common.table.BkgArrNtcVO;
import com.hanjin.syscommon.common.table.BkgArrNtcWdDtlVO;
import com.hanjin.syscommon.common.table.BkgArrNtcWdVO;
import com.hanjin.syscommon.common.table.BkgCustTmpltVO;
import com.hanjin.syscommon.common.table.BkgIbCmdtCntcVO;
import com.hanjin.syscommon.common.table.BkgIbCustCntcHisVO;
import com.hanjin.syscommon.common.table.BkgIbCustCntcStupHisVO;
import com.hanjin.syscommon.common.table.BkgIbCustCntcStupVO;
import com.hanjin.syscommon.common.table.BkgIbCustCntcVO;
import com.hanjin.syscommon.common.table.BkgIbEdiSndLogVO;
import com.hanjin.syscommon.common.table.BkgMdmCrCustVO;
import com.hanjin.syscommon.common.table.BkgNtcHisVO;
import com.hanjin.syscommon.common.table.BkgTroActCustVO;
import com.hanjin.syscommon.common.table.BkgVvdVO;
import com.hanjin.syscommon.common.table.ComUserVO;

/**
 * ALPS-InboundNoticeMgt Business Logic Basic Command implementation<br>
 * - ALPS-InboundNoticeMgt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Park Mangeon
 * @see EventResponse,InboundNoticeBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class ArrivalNoticeBCImpl extends BasicCommandSupport implements ArrivalNoticeBC {

	// Database Access Object
	//private transient ArrivalNoticeDBDAO dbDao = null;
	private transient ArrivalNoticeDBDAO dbDao = null;
	
	private transient InboundNoticeEAIDAO eaiDao = null;
	/**
	 * InboundNoticeBCImpl 객체 생성<br>
	 * InboundNoticeDBDAO를 생성한다.<br>
	 */
	public ArrivalNoticeBCImpl() {
		dbDao = new ArrivalNoticeDBDAO();
		eaiDao = new InboundNoticeEAIDAO();
	}
	

	/**
	 * UI_BKG-0375 Arrival Notice Form Setup<br>
     * Arrival Notice Form을 조회
	 * @param String ofcCd Office코드
	 * @param String pod POD Code
	 * @param String agent  중국 에이전트 코드
	 * @return ArrNtcWdVO
	 * @exception EventException
	 */
	public ArrNtcWdVO searchArrNtcForm ( String ofcCd , String pod , String agent )  throws EventException {
		//List<ArrNtcFormVO> arrNtcFormVO = null;
		ArrNtcWdVO arrNtcWdVO = new ArrNtcWdVO();
		try {
			// Search Master (첫번째 Sequence임)
			arrNtcWdVO.setBkgArrNtcWdVO(dbDao.searchArrNtcForm(ofcCd, pod, agent));
			if (arrNtcWdVO.getBkgArrNtcWdVO() != null) {
				// if master exists : search Detail (두번째 Sequence임)
				List<BkgArrNtcWdDtlVO> bkgArrNtcWdDtlList = dbDao.searchArrNtcFormDtls(arrNtcWdVO.getBkgArrNtcWdVO().getAnSeq());
				BkgArrNtcWdDtlVO[] bkgArrNtcWdDtlVOs = new BkgArrNtcWdDtlVO[bkgArrNtcWdDtlList.size()];
				bkgArrNtcWdDtlList.toArray(bkgArrNtcWdDtlVOs);
				arrNtcWdVO.setBkgArrNtcWdDtlVOs(bkgArrNtcWdDtlVOs);
			}
        }catch (DAOException de) {
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
        
        return arrNtcWdVO;
	}
	
	
	/**
	 * UI_BKG-0375 Arrival Notice Form Setup<br>
	 * Arrival Notice Form에 등록된 POD 목록을 조회합니다.  
	 * @param String ofcCd
	 * @return List<BkgArrNtcWdVO>
	 * @exception EventException
	 */
	public List<BkgArrNtcWdVO> searchArrNtcFormPodList(String ofcCd) throws EventException {
		//ArrNtcFomStupVO arrNtcFomStupVO = null;
		try {
			List<BkgArrNtcWdVO> list = dbDao.searchArrNtcFormPodList(ofcCd);
			return list;
        }catch (DAOException de) {
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
	}

	/**
	 * UI_BKG-0375 Arrival Notice Form Setup<br>
	 * Arrival Notice Form에 등록된 Agent 목록을 조회합니다.  
	 * @param String ofcCd
	 * @param String podCd
	 * @return List<BkgArrNtcWdVO>
	 * @exception EventException
	 */
	public List<BkgArrNtcWdVO> searchArrNtcFormAgentList(String ofcCd,String podCd) throws EventException {
		try {
			List<BkgArrNtcWdVO> list = dbDao.searchArrNtcFormAgentList(ofcCd, podCd);
			return list;
        }catch (DAOException de) {
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
	}

	
	/**
     * UI-BKG_0375 Arrival Notice Form Setup<br>
     * Arrival Notice Form Data를 수정한다.<br/>
     * master 및 detail을 동시에 수정한다.
	 * @param BkgArrNtcWdVO arrNtcWd
	 * @param BkgArrNtcWdDtlVO[] arrNtcWdDtls
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String setupArrNtcForm(BkgArrNtcWdVO arrNtcWd, BkgArrNtcWdDtlVO[] arrNtcWdDtls, SignOnUserAccount account) throws EventException{
		String anSeq = null;
		try {
			BkgArrNtcWdVO bkgArrNtcWdVOQry = dbDao.searchArrNtcForm(arrNtcWd.getOfcCd(), arrNtcWd.getPodCd(), arrNtcWd.getChnAgnCd());
			if (bkgArrNtcWdVOQry != null && bkgArrNtcWdVOQry.getAnSeq() != null) {
				anSeq = bkgArrNtcWdVOQry.getAnSeq() ; // default sequence
			}
//			anSeq = arrNtcWd.getAnSeq();
			if (anSeq != null && !anSeq.equals("") && !anSeq.equals("0")) { // modify
				/* update master */
				arrNtcWd.setAnSeq(anSeq);
				arrNtcWd.setCreUsrId(account.getUsr_id());
				dbDao.modifyArrNtcForm(arrNtcWd);
				for (int i = 0 ; i<arrNtcWdDtls.length; i++)
				{
					/* update detail */
					arrNtcWdDtls[i].setAnSeq(anSeq);
					arrNtcWdDtls[i].setCreUsrId(account.getUsr_id());
					arrNtcWdDtls[i].setUpdUsrId(account.getUsr_id());
					dbDao.modifyArrNtcFormDtl(arrNtcWdDtls[i]);
				}
				
			} else {  // create
				/* retrieve new sequence */
				anSeq = dbDao.searchArrNtcFomMaxSeq();
				arrNtcWd.setAnSeq(anSeq);
				
				/* add  master */
				arrNtcWd.setCreUsrId(account.getUsr_id());
				dbDao.addArrNtcForm(arrNtcWd);
				
				for (int i = 0 ; i<arrNtcWdDtls.length; i++)
				{
					/* add detail */
					arrNtcWdDtls[i].setAnSeq(anSeq);
					arrNtcWdDtls[i].setCreUsrId(account.getUsr_id());
					dbDao.addArrNtcFormDtl(arrNtcWdDtls[i]);
				}
			}

        }catch (DAOException de) {
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110").getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110").getMessage(), ex);
        }
		return anSeq;
	}
	
	/**
	 * UI_BKG-0375 Arrival Notice Form Setup<br>
	 * Arriv notice Form을 삭제한다.
	 * @param String ofcCd 오피스 코드
	 * @param String podCd 포트 코드
	 * @param String agentCd 중국 에이전트 코드
	 * @exception EventException
	 */
	public void removeArrNtcForm(String ofcCd, String podCd, String agentCd) throws EventException
	{
		try {
			/*
			 * 아래의 조건에 해당하는 anSeq를 가져온다. (심영우과장 요건)
			 * POD(ALL)  AGENT(ALL)  모두 삭제 (다중)
			 * POD(ALL)  AGENT(CODE) 해당건 삭제
			 * POD(CODE) AGENT(ALL)  AGENT 모두 삭제(다중)
			 * POD(CODE) AGENT(CODE) 해당건 삭제
			 */
			String[] anSeqs = dbDao.searchRemoveForm(ofcCd,podCd, agentCd);
			
			/*
			 * 해당 데이터들을 삭제한다.
			 */
			if (anSeqs != null && anSeqs.length > 0) {
				for (int idx = 0; idx < anSeqs.length; idx ++) {
					/* remove detail - FK관계에 의거 자식 테이블 우선 삭제 */
					dbDao.removeArrNtcFormDtl(anSeqs[idx]);
					/* remove master */
					dbDao.removeArrNtcForm(anSeqs[idx]);
				}
				
			}
			
        }catch (DAOException de) {
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110").getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110").getMessage(), ex);
        }
		
	}
	/**
	 * [240-1]ESM_BKG_0240 Customer Main (MDM) Master 에 대한 조회 이벤트 처리<br>
	 * @param IntgCustSearchVO intgCustSearchVo
	 * @return IbCustCntcVO
	 * @exception EventException
	 */
	public IbCustCntcVO searchIntgCustCntcInfo (IntgCustSearchVO intgCustSearchVo ) throws EventException {
		
		try {			
			
			IbCustCntcVO bkgIbCustCntcVO = new IbCustCntcVO();
			
			//Master 조회			
			List<MdmCustomerVO> mdmCustomerVOs = dbDao.searchMdmCustList(intgCustSearchVo);
			bkgIbCustCntcVO.setMdmCustomerVO(mdmCustomerVOs);			
			
			if(mdmCustomerVOs.size() == 1){
				MdmCustomerVO mdmCustomerVO = mdmCustomerVOs.get(0);
				//log.debug("---------------- mdmCustomerVO " + mdmCustomerVO);
				String custCntCd = mdmCustomerVO.getCustCntCd();
				String custSeq = mdmCustomerVO.getCustSeq();
				String ofcCd = intgCustSearchVo.getLoginOfcCd();
				//String loginOfcCd = intgCustSearchVO.getLoginOfcCd();
				//Detail 조회
				
				List<IbCustCntcVO> detailBkgIbCustCntcVO = searchIntgCustCntcInfoByIB(custCntCd, custSeq, ofcCd);
				//log.debug("------------   detailBkgIbCustCntcVO.size()   " +detailBkgIbCustCntcVO.size());
				bkgIbCustCntcVO.setDetailBkgIbCustCntcVO(detailBkgIbCustCntcVO);
				
			}			
			return bkgIbCustCntcVO;
			
		} catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }

	}

	/**
	 * ESM_BKG_0240 Customer Main Detail 에 대한 조회 이벤트 처리<br>
	 * @param String custCntCd
	 * @param String custSeq
	 * @param String ofcCd
	 * @return List<IbCustCntcVO>
	 * @exception EventException
	 */
	public List<IbCustCntcVO> searchIntgCustCntcInfoByIB(String custCntCd,
			String custSeq, String ofcCd) throws EventException {
		
		try{
			List<IbCustCntcVO> detailBkgIbCustCntcVO = dbDao.searchIntgCustCntcInfoByIB(custCntCd, custSeq, ofcCd);
			//Outer join 의 값이 하나도 없으면 출력하지 않는다.
			//2009.10.09 
			//요구사항의 변경으로 인해, 값이 없더라도 5 Row 를 출력해야함.
			//if(detailBkgIbCustCntcVO.get(0).getOfcCd().trim().equals("")){
			//	detailBkgIbCustCntcVO = new ArrayList<IbCustCntcVO>();
			//}
			log.debug("------------   detailBkgIbCustCntcVO.size()   " +detailBkgIbCustCntcVO.size());
			return detailBkgIbCustCntcVO;
		
		} catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }

	}

	/**
	 * [0240] 저장루틴
	 * @param BkgIbCustCntcVO[] custCntc
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageIntgCustCntcInfoByIB(BkgIbCustCntcVO[] custCntc, SignOnUserAccount account)
			throws EventException {
		// TODO Auto-generated method stub
		try {
			
			for(int i=0;i<custCntc.length;i++){
				//IbCustCntcHisVO bkgIbCustCntcHisVO = new IbCustCntcHisVO();
				BkgIbCustCntcHisVO hisVO = new BkgIbCustCntcHisVO();
				
				custCntc[i].setCreUsrId(account.getUsr_id());
				custCntc[i].setUpdUsrId(account.getUsr_id());
				custCntc[i].setEvntOfcCd(account.getOfc_cd());

				//History Data set
				hisVO.setCreUsrId(account.getUsr_id());
				hisVO.setUpdUsrId(account.getUsr_id());
				hisVO.setCustCntCd(custCntc[i].getCustCntCd());
				hisVO.setCustSeq(custCntc[i].getCustSeq());
				hisVO.setCustCntcTpCd(custCntc[i].getCustCntcTpCd());
				hisVO.setOfcCd(custCntc[i].getOfcCd());
				
				hisVO.setCngUsrId(account.getUsr_id());									

				//-------------------------------------
				//이후 소스
				//-------------------------------------
				if(!(dbDao.modifyIntgCustCntcInfo(custCntc[i]) > 0)){//수정에 실패할경우
					dbDao.addIntgCustCntctInfo(custCntc[i],account); //추가 실행
				}
				
				// HISTORY 
				//a.삭제일경우 New 값을 null로
				//b-1.E-Mail 이 ORG,NEW 가 다를경우 입력
				//b-2.FAX 이 ORG,NEW 가 다를경우 입력	
				custCntc[i].setCntcEml(custCntc[i].getIbflag().equals("D")?"":custCntc[i].getCntcEml());
				custCntc[i].setFaxNo(custCntc[i].getIbflag().equals("D")?"":custCntc[i].getFaxNo());
				log.debug("------------------------------------");
				log.debug("custCntc[i].getIbflag()    "+custCntc[i].getIbflag());
				log.debug("custCntc[i].getCntcEmlOrg()    "+custCntc[i].getCntcEmlOrg());
				log.debug("custCntc[i].getCntcEml()    "+custCntc[i].getCntcEml());
				log.debug("------------------------------------");
				
				//Email 수정
				if(!custCntc[i].getCntcEml().equals(custCntc[i].getCntcEmlOrg())){					
					hisVO.setOldCntcCtnt(custCntc[i].getCntcEmlOrg());					
					hisVO.setNewCntcCtnt(custCntc[i].getCntcEml());
					hisVO.setSndSelFlg("");
					
					//bkgIbCustCntcHisVO.setSndSelFlg(custCntc[i].getEmlSndFlg());
					hisVO.setCntcViaCd("M");
					hisVO.setAutoMnlFlg("N");
					dbDao.addIntgCustCntcInfoHistory(hisVO,account);		
				}
				//Fax 수정
				if(!custCntc[i].getFaxNo().equals(custCntc[i].getFaxNoOrg())){
					hisVO.setOldCntcCtnt(custCntc[i].getFaxNoOrg());					
					hisVO.setNewCntcCtnt(custCntc[i].getFaxNo());	
					hisVO.setSndSelFlg("");
	
					
					//bkgIbCustCntcHisVO.setSndSelFlg(custCntc[i].getFaxSndFlg());
					hisVO.setCntcViaCd("F");
					hisVO.setAutoMnlFlg("N");
					dbDao.addIntgCustCntcInfoHistory(hisVO,account);		
				}
				//Email Flag 수정
				if(!custCntc[i].getFaxSndFlg().equals(custCntc[i].getFaxSndFlgOrg())){
					hisVO.setOldCntcCtnt("");					
					hisVO.setNewCntcCtnt("");
					hisVO.setSndSelFlg(custCntc[i].getFaxSndFlg());
					
					hisVO.setCntcViaCd("M");					
					hisVO.setAutoMnlFlg("N");
					dbDao.addIntgCustCntcInfoHistory(hisVO,account);
				}
				//Fax Flag 수정
				if(!custCntc[i].getEmlSndFlg().equals(custCntc[i].getEmlSndFlgOrg())){
					hisVO.setOldCntcCtnt("");					
					hisVO.setNewCntcCtnt("");
					hisVO.setSndSelFlg(custCntc[i].getEmlSndFlg());
					
					hisVO.setCntcViaCd("F");					
					hisVO.setAutoMnlFlg("N");
					dbDao.addIntgCustCntcInfoHistory(hisVO,account);
				}
				
				
			}		
			
		} catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }

	}

	/**
	 *  Integrated Customer Data Management(OB) Detail 조회
	 * @param String custCntCd
	 * @param String custSeq
	 * @return List<BkgCustTmpltVO>
	 * @exception EventException
	 */
	public List<BkgCustTmpltVO> searchIntgCustCntcInfoByOB(String custCntCd,
			String custSeq) throws EventException {
		try{
			List<BkgCustTmpltVO> bkgCustTmpltVO = dbDao.searchIntgCustCntcInfoByOB(custCntCd, custSeq);
			
			return bkgCustTmpltVO;
		
		} catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }

	}
	/**
	 *  Integrated Customer Data Management(Invoice) Detail 조회
	 * @param String custCntCd
	 * @param String custSeq
	 * @return  List<BkgMdmCrCustVO>
	 * @exception EventException
	 */
	public List<BkgMdmCrCustVO> searchIntgCustCntcInfoByInvoice(String custCntCd,
			String custSeq) throws EventException {
		try{
			List<BkgMdmCrCustVO> mdmCrCustVO = dbDao.searchIntgCustCntcInfoByInvoice(custCntCd, custSeq);
			
			return mdmCrCustVO;
		
		} catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }

	}
	
	/**
	 *  Integrated Customer Data Management(TRO) Detail 조회
	 * @param String custCntCd
	 * @param String custSeq 
	 * @return List<BkgTroActCustVO> 
	 * @exception EventException
	 */
	public List<BkgTroActCustVO> searchIntgCustCntcInfoByTRO(String custCntCd,
			String custSeq) throws EventException {
		try{
			List<BkgTroActCustVO> bkgTroActCustVO = dbDao.searchIntgCustCntcInfoByTRO(custCntCd, custSeq);
			
			return bkgTroActCustVO;
		
		} catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }

	}


	/**
	 * Arrival Information [Arrival Date] Paging조회
	 * [672-1]
	 * @param ArrNtcSearchVO arrNtcSearch
	 * @param SignOnUserAccount account
	 * @return List<ArrNtcInfoListVO> 
	 * @exception EventException
	 */
	public List<ArrNtcInfoListVO> searchArrNtcInfoList(ArrNtcSearchVO arrNtcSearch,SignOnUserAccount account) throws EventException {
		try {
			List<ArrNtcInfoListVO> arrNtcVO = dbDao	.searchArrNtcInfoList(arrNtcSearch,account);
			List<ArrNtcInfoListVO> nArrNtcVO = new ArrayList<ArrNtcInfoListVO>();
			
			//if(arrNtcVO.size() < 1000 && arrNtcVO.size() > 0){
			if(arrNtcVO.size() > 0){
				//int cnt = dbDao.getTotalCountArrNtcInfoList(arrNtcSearch);
				int cnt = arrNtcVO.size();
				
				log.debug("----------------------------------------");
				log.debug("cnt  "+cnt);
				log.debug("----------------------------------------");
				
				
				//1.이전과 이후의 데이터를(VVD)를 비교하여 차이가 있을경우 Title 입력
				//List<ArrNtcVO> titleArrNtcVO = dbDao.searchArrNtcInfoList(arrNtcSearch, "2");
//				log.debug("----------------------------------------");
//				log.debug("arrNtcVO.get(0).getVvd()   "+arrNtcVO.get(0).getVvd());
//				log.debug("----------------------------------------");
				ArrNtcInfoListVO titleArrNtcVO = new ArrNtcInfoListVO();
				titleArrNtcVO.setVvd(arrNtcVO.get(0).getVvd());
				
				if(cnt <= 400){
					nArrNtcVO.add(titleArrNtcVO);
					//log.debug("----------------------");
					log.debug("---------------------- 400 보다 적다");
					//log.debug("----------------------");
					for(int x=0;x<arrNtcVO.size()-1;x++){					
						String currVvd = arrNtcVO.get(x).getVvd();
						String nextVvd = arrNtcVO.get(x+1).getVvd();					
						
						nArrNtcVO.add(arrNtcVO.get(x));
						
						//전체건수가 400 적을경우만 group 이름 입력
						if(!currVvd.equals(nextVvd)){
							titleArrNtcVO = new ArrNtcInfoListVO();
							titleArrNtcVO.setVvd(nextVvd);						
							nArrNtcVO.add(titleArrNtcVO);						
							
							//nArrNtcVO.add(arrNtcVO.get(x));
						}
						
						
					}
					nArrNtcVO.add(arrNtcVO.get(arrNtcVO.size()-1));
				}else{
					//log.debug("----------------------");
					log.debug("---------------------- 400 보다 크다");
					//log.debug("----------------------");
					for(int x=0;x<arrNtcVO.size()-1;x++){					
						
						nArrNtcVO.add(arrNtcVO.get(x));
						
					}
					nArrNtcVO.add(arrNtcVO.get(arrNtcVO.size()-1));
				}
				
				if(nArrNtcVO != null && nArrNtcVO.size() > 0){
					nArrNtcVO.get(0).setMaxRows(cnt);
				}
				
				//2.VVD로 정렬하여 출력될 형태로 생성
				log.debug("-----------------------------------//group by 있도록 조회 [ " + arrNtcVO.size() + "]");				
			//}else{
			//	nArrNtcVO = arrNtcVO;			
			//}
			}
			return nArrNtcVO;

		}catch (DAOException de) {
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
	}

//	/**
//	 * 조회 이벤트 처리<br>
//	 *  TCharterIOBasicRegister화면에 대한 조회 이벤트 처리<br>
//	 * 
//	 * @param fmsownervo   FmsOwnerVO
//	 * @return List<FmsOwnerVO>
//	 * @exception EventException
//	 */
//	public int getTotalCount(ArrNtcSearchVO arrNtcSearch) throws EventException {
//		try {
//			return dbDao.getTotalCountArrNtcInfoList(arrNtcSearch);
//		} catch (DAOException ex) {
//			ex.printStackTrace();
//			throw new EventException(new ErrorHandler(ex).getMessage());
//		}
//	}
//	

	/**
     * UI-BKG-1054 Customer Code Validation<br>
     * Customer Code Validation 수행을 시키고 Background Job에서 생성한 Key를 반환한다.<br>
     * @author Park Mangeon
	 * @param ArrNtcSearchVO anSearch
	 * @return String backEndJobKey
	 * @exception EventException
	 */
	public String manageArrNtcCodeValidation(ArrNtcSearchVO anSearch) throws EventException{
		String backendJobKey = null;
		try {
			CodeValidationBackEndJob command = new CodeValidationBackEndJob();
	        command.setArrNtcSearchVO(anSearch);
	
	        BackEndJobManager backEndJobManager = new BackEndJobManager();
	        backendJobKey = backEndJobManager.execute(command, anSearch.getValUsrId(), "ESM_BKG_1054 Customer Code Validation");
		
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }

        return backendJobKey;
	}
	
	/**
	 * [UI-BKG-1054_01] VVD별 POD 목록을 조회합니다.<br>
	 * @param String vvd 
	 * @return List<BkgVvdVO>
	 * @exception EventException 
	 */
	public List<BkgVvdVO> searchPodListByVVD(String vvd) throws EventException{
		try {
			return dbDao.searchPodListByVVD(vvd);
        }catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), de);
        }catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
	}

	/**
     * UI-BKG-1054 Customer Code Validation<br>
     * Customer Code Validation 수행 후 결과중 unmatch에 해당하는 정보를 조회한다.<br>
     * @author Park Mangeon
	 * @param ArrNtcSearchVO arrNtcSearch
	 * @param SignOnUserAccount account
	 * @return List<CustCdValidationVO> codeValidations
	 * @exception EventException
	 */
	public List<CustCdValidationVO> searchArrNtcUnMatchCustList(ArrNtcSearchVO arrNtcSearch, SignOnUserAccount account) throws EventException {
		try {
			if (arrNtcSearch.getPageNo() == null || arrNtcSearch.getPageNo().equals("") ||  Integer.valueOf( arrNtcSearch.getPageNo()).intValue() == 0) {
				arrNtcSearch.setPageNo("1");
			}
			arrNtcSearch.setUsrId(account.getUsr_id());
			arrNtcSearch.setOfcCd(account.getOfc_cd());
			return dbDao.searchArrNtcUnMatchCustList(arrNtcSearch);
			
        }catch (DAOException de) {
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
	}

	/**
     * UI-BKG-1054 Customer Code Validation (정규개발목록 아님)<br>
     * Customer Code Validation 수행 후 결과중 unmatch에 해당하는 정보를 조회한다.<br>
     * 수기작업용<br>
     * @author Park Mangeon
	 * @param ArrNtcSearchVO anSearch
	 * @param SignOnUserAccount account
	 * @return List<CustCdValidationVO> 
	 * @exception EventException
	 */
	public List<CustCdValidationVO> searchManualValInfo(ArrNtcSearchVO anSearch, SignOnUserAccount account) throws EventException {
		try {
			if (anSearch.getPageNo() == null || anSearch.getPageNo().equals("") ||  Integer.valueOf( anSearch.getPageNo()).intValue() == 0) {
				anSearch.setPageNo("1");
			}
			anSearch.setUsrId(account.getUsr_id());
			anSearch.setOfcCd(account.getOfc_cd());
			return dbDao.searchManualValInfo(anSearch);
			
	    }catch (DAOException de) {
	        // BKG00450 : 조회에 실패했습니다.
	        throw new EventException(new ErrorHandler("BKG00450").getMessage(), de);
	    }catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        // BKG00450 : 조회에 실패했습니다.
	        throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
	    }
	}

	/**
     * UI-BKG-1054 Customer Code Validation <br>
     * Customer Code Validation 수행 후 결과중 match에 해당하는 정보를 조회한다.<br>
     * @author Park Mangeon
	 * @param ArrNtcSearchVO arrNtcSch
	 * @return List<CustCdValidationVO>
	 * @exception EventException
	 */
	public List<CustCdValidationVO> searchArrNtcMatchCustList(ArrNtcSearchVO arrNtcSch) throws EventException {
		try {
			return dbDao.searchArrNtcMatchCustList(arrNtcSch);
        }catch (DAOException de) {
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
	}
	
	/**
     * UI-BKG-1054 Customer Code Validation<br>
     * Customer Code Validation한  Unmatch 정보를 update 한다.<br>
     * Arrival Notice master 및 Detail을 생성한다.<br>
     * @author Park Mangeon
	 * @param CustCdEvaluationVO[] custCdEvaluationVos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageArrNtcUnMatchCust(CustCdEvaluationVO[] custCdEvaluationVos, SignOnUserAccount account) throws EventException {
		try {
			
			List<CustCdEvaluationVO> custCdEvaluations = new ArrayList<CustCdEvaluationVO>();
			for (int i= 0; i < custCdEvaluationVos.length; i ++) {
				custCdEvaluationVos[i].setUsrId(account.getUsr_id());  // val_usr_id
				custCdEvaluationVos[i].setOfcCd(account.getOfc_cd());  // val_office_cd
				custCdEvaluations.add(custCdEvaluationVos[i]);
			}

			log.error("manageArrNtcUnMatchCustA" + custCdEvaluationVos[0].getBkgNo());
			
			// 1. arrival notice master를  등록한다.
			dbDao.addArrNtcValInfo(custCdEvaluations);
			log.error("manageArrNtcUnMatchCustB");
			// 2. arrival notice detail을 등록한다.
			dbDao.addArrNtcDtlValInfo(custCdEvaluations);

        }catch (DAOException de) {
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), ex);
        }
	}

	/**
     * UI_BKG-1054 Customer Code Validation<br>
     * Customer Code Validation작업으로 Match된 정보를 Unmatch로 변경한다.<br>
     * Arrival Notice master 와 Detail을 삭제한다.<br>
     * Match 정보를 update 한다.<br>
     * @author Park Mangeon
	 * @param CustCdEvaluationVO[] custCdEvals
	 * @exception EventException
	 */
	public void cancelArrNtcCustCdVal(CustCdEvaluationVO[] custCdEvals) throws EventException {
		try {
			
			if (custCdEvals.length > 0) {
				// 1. arrival notice detail을 삭제.
				dbDao.removeArrNtcDtlByCustCdVal(custCdEvals[0].getBkgNo(), custCdEvals[0].getBkgCustTpCd());
				// 2. arrival notice를  삭제한다.
				dbDao.removeArrNtcByCustCdVal(custCdEvals[0].getBkgNo());
			}

        }catch (DAOException de) {
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 * BL Copy &amp; Customer Info Update<br>
	 * Arrival Notice Master와 Arrival Notice Detail을 삭제한다.<br> 
	 * @author Park Mangeon
	 * @param String bkgNo
	 * @throws EventException
	 */
	public void cancelArrNtcCustCdVal(String bkgNo) throws EventException {
		try {
			
			// arrival notice detail을 삭제.
			// Consignee / Notify 두번을 호출해야 한다. (20100104 수정)
			dbDao.removeArrNtcDtlByCustCdVal(bkgNo , "C");
			dbDao.removeArrNtcDtlByCustCdVal(bkgNo , "N");
			// arrival notice를  삭제한다.
			dbDao.removeArrNtcByCustCdVal(bkgNo);

        }catch (DAOException de) {
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), ex);
        }
	}

	
	/**
     * UI-BKG-0941 Customer code Error Report<br>
     * Customer Code Error Report를 조회한다.
	 * @param ArrNtcCustCodeErrSearchVO arrNtcCustCodeErrSearch
	 * @return List<ArrNtcCustCodeErrLstVO>
	 * @exception EventException
	 */
	public List<ArrNtcCustCodeErrListVO> searchArrNtcCustCodeErrReport(ArrNtcCustCodeErrSearchVO arrNtcCustCodeErrSearch) throws EventException {
		try {
			 
			return dbDao.searchArrNtcCustCodeErrReport(arrNtcCustCodeErrSearch);

        }catch (DAOException de) {
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		
	}
	
	/**
     * UI-BKG-0941 Customer code Error Report<br>
     * Customer Code Error Rhq Report를 조회한다.
	 * @param ArrNtcCustCodeErrSearchVO arrNtcCustCodeErrSearch
	 * @return List<ArrNtcCustCodeErrLstVO>
	 * @exception EventException
	 */
	public List<ArrNtcCustCodeErrListVO> searchArrNtcCustCodeErrRhqReport(ArrNtcCustCodeErrSearchVO arrNtcCustCodeErrSearch) throws EventException {
		try {
			
			return dbDao.searchArrNtcCustCodeErrRhqReport(arrNtcCustCodeErrSearch);

        }catch (DAOException de) {
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		
	}
	
	/**
     * UI-BKG-0001 Notice Sent History<br>
     * Bkg Notice History를 이용하여 Inbound Arrival Notice 정보를 추출한다.
	 * @param BkgNtcSearchVO bkgNtcSearch
	 * @return List<NoticeVO>
	 * @exception EventException
	 */
	public List<NoticeVO> searchBkgNtcHis (BkgNtcSearchVO bkgNtcSearch) throws EventException {
		try {
			return dbDao.searchBkgNtcHis(bkgNtcSearch);
        }catch (DAOException de) {
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
	}


	/**
	 * [243] AN Setup Screen_Arrival Info. Setup에서 그룹핑된 VVD/POD별 입력되는 문구와 정보를 조회한다.
	 * @param String ofcCd
	 * @param String podCd
	 * @param String formCd
	 * @param String agent
	 * @return List<BkgArrNtcWdDtlVO>
	 * @exception EventException 
	 */
	public List<BkgArrNtcWdDtlVO> searchArrNtcFormDtl(String ofcCd, String podCd,
			String formCd,String agent) throws EventException {
		try {
			return dbDao.searchArrNtcFormDtl(ofcCd, podCd,formCd,agent);

		} catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }

	}
	
	/**
	 * UI_BKG-0672-1
	 * Arrival Notice (Arrival Information) 저장
	 * @param BkgArrNtcVO[] arrNtcs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void setupArrNtcInfoList(ArrNtcInfoListVO[] arrNtcInfos , SignOnUserAccount account ) throws EventException{
		//2010.01.19
		//1.수정호출을 add batch 형태로 전환
		//2.화면의 모든데이터를 저장하므로, 제외 조건추가
		//2-1.is_validate == 'Y'
		//2-2.bl_no != '' ; bl_no 없는경우는 안됨.
		
		try {
			log.debug("--------- arrNtcInfos.size() "+arrNtcInfos.length);
			List<BkgArrNtcVO> bkgArrNtcVOs = new ArrayList<BkgArrNtcVO>();
			
			for (int i = 0; i < arrNtcInfos.length; i++) {
				BkgArrNtcVO bkgArrNtcVO = new BkgArrNtcVO();
				bkgArrNtcVO.setUpdUsrId(account.getUsr_id());
				//if (arrNtcInfos[i].getIbflag().equals("U")) {
					
					if(   (arrNtcInfos[i].getIsValidated() != null && arrNtcInfos[i].getIsValidated().equals("Y"))
							&& (arrNtcInfos[i].getBlNo() != null && !arrNtcInfos[i].getBlNo().equals(""))
							){							
						ObjectCloner.build(arrNtcInfos[i], bkgArrNtcVO);
						//this.build(arrNtcInfos[i], bkgArrNtcVO);
						//bkgArrNtcVO.setDiffRmk(arrNtcInfos[i].get);
						//bkgArrNtcVO.setChnAgnCd(arrNtcInfos[i].get);
						bkgArrNtcVOs.add(bkgArrNtcVO);
					}
				//}
			}
			if(bkgArrNtcVOs.size() > 0){
				dbDao.modifyArrNtcInfo (bkgArrNtcVOs);
			}

		}catch (DAOException de) {
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), ex);
        }
	}
	

	/**[0052]Arrival Notice Yard 정보  조회
	 * podCd 값에 따른 분기
	 * @param String vvd
	 * @param String podCd
	 * @return List<MrnRtnYdVO>
	 * @exception EventException 
	 */
	public List<MrnRtnYdVO> searchArrNtcMrnRtnYd(String vvd, String podCd) throws EventException {
		// TODO Auto-generated method stub
		
		List<MrnRtnYdVO> retList = null;
		log.debug("Impl 0052 podCd " + podCd);
		try {
			if("BEANR".equals(podCd)){
				retList= dbDao.searchArrNtcAnrMrnRtnYd (vvd);
			}else if("NLRTM".equals(podCd)){
				retList= dbDao.searchArrNtcRtmMrnRtnYd (vvd);
			}
		}catch (DAOException de) {
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		return retList;
	}
	/**[0052]Arrival Notice Yard 정보  저장
	 * @param MrnRtnYdVO[] mrnRtnYdVOS
	 * @param SignOnUserAccount account 
	 * @exception EventException 
	 */
	public void setupArrNtcMrnRtnYd(MrnRtnYdVO[] mrnRtnYdVOS, SignOnUserAccount account) throws EventException {
		try{
			for (int i = 0; i < mrnRtnYdVOS.length; i++) {
				MrnRtnYdVO mrnRtnYdVO = mrnRtnYdVOS[i];							
				if (dbDao.modifyArrNtcMrnRtnYd(mrnRtnYdVO,account) == 0) {
					dbDao.addArrNtcMrnRtnYd(mrnRtnYdVO,account);
				}
			}
			
		}catch (DAOException de) {
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 * [672-02]Customer 정보 조회한다
	 * @param ArrNtcSearchVO search
	 * @param SignOnUserAccount account
	 * @return List<ArrNtcCustListVO>
	 * @exception EventException
	 */
	public List<ArrNtcCustListVO> searchArrNtcCustList(ArrNtcSearchVO search, SignOnUserAccount account)
			throws EventException {
		// TODO Auto-generated method stub
		List<ArrNtcCustListVO> retList = null;

		
		try {
			//log.debug("------------------ " + search.getColumnValues());
			retList = dbDao.searchArrNtcCustList(search,account);
		}catch (DAOException de) {
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }

		return retList;
	}
	/**
	 * [672-02]Customer 정보 저장
	 * @param ArrNtcCustListVO[] arrNtcCustListVOS
	 * @param SignOnUserAccount account
	 * @exception Exception
	 */
	public void modifyArrNtcCustList(ArrNtcCustListVO[] arrNtcCustListVOS,
			SignOnUserAccount account) throws Exception {
		try {
			for (int i = 0; i < arrNtcCustListVOS.length; i++) {
				ArrNtcCustListVO arrNtcCustListVO = arrNtcCustListVOS[i];
				BkgArrNtcDtlVO bkgArrNtcDtlVO = new BkgArrNtcDtlVO(); 
				
				String faxNo = "";
				String eml = "";
				
				// 수정1
				// bkg_customer.chg_dp_flg 수정
				/*
				if(arrNtcCustListVO.getChgDpFlg() != null && !arrNtcCustListVO.getChgDpFlg().equals("")){
					dbDao.modifyArrNtcChgDpFlg(arrNtcCustListVO.getBkgNo(),
							arrNtcCustListVO.getChgDpFlg(),arrNtcCustListVO.getBkgCustTpCd());
				}
                 */
				// 수정2
				arrNtcCustListVO.setUpdUsrId(account.getUsr_id());
				int modifyRowCnt = 0;
				
				// bkg_arr_ntc_dtl 수정
				arrNtcCustListVO.setCustCntcTpCd("C1");
				faxNo = arrNtcCustListVO.getFax1();
				eml = arrNtcCustListVO.getEml1();
				
				arrNtcCustListVO.setFaxNo(faxNo);
				arrNtcCustListVO.setNtcEml(eml);
				
				
				ObjectCloner.build(arrNtcCustListVO ,bkgArrNtcDtlVO);
				modifyRowCnt = dbDao.modifyArrNtcDtls(bkgArrNtcDtlVO,account);
				if(modifyRowCnt == 0 ){					
					dbDao.addArrNtcDtls(bkgArrNtcDtlVO, account);//추가
					
					if(faxNo.equals("") && eml.equals("")){
						dbDao.removeArrNtcDtls(bkgArrNtcDtlVO);
					}
					
					
				}

				arrNtcCustListVO.setCustCntcTpCd("C2");
				faxNo = arrNtcCustListVO.getFax2();
				eml = arrNtcCustListVO.getEml2();
				
				arrNtcCustListVO.setFaxNo(faxNo);
				arrNtcCustListVO.setNtcEml(eml);
				
				ObjectCloner.build(arrNtcCustListVO ,bkgArrNtcDtlVO);
				modifyRowCnt = dbDao.modifyArrNtcDtls(bkgArrNtcDtlVO,account);
				
				if(modifyRowCnt == 0 ){
					
					dbDao.addArrNtcDtls(bkgArrNtcDtlVO, account);//추가
					if(faxNo.equals("") && eml.equals("")){
						dbDao.removeArrNtcDtls(bkgArrNtcDtlVO);
					}
					
				}

				arrNtcCustListVO.setCustCntcTpCd("B1");
				faxNo = arrNtcCustListVO.getFax3();
				eml = arrNtcCustListVO.getEml3();
				
				arrNtcCustListVO.setFaxNo(faxNo);
				arrNtcCustListVO.setNtcEml(eml);
				
				ObjectCloner.build(arrNtcCustListVO ,bkgArrNtcDtlVO);
				modifyRowCnt = dbDao.modifyArrNtcDtls(bkgArrNtcDtlVO,account);
				if(modifyRowCnt == 0 ){
					
					dbDao.addArrNtcDtls(bkgArrNtcDtlVO, account);//추가
					if(faxNo.equals("") && eml.equals("")){
						dbDao.removeArrNtcDtls(bkgArrNtcDtlVO);
					}
					
				}

				arrNtcCustListVO.setCustCntcTpCd("B2");
				faxNo = arrNtcCustListVO.getFax4();
				eml = arrNtcCustListVO.getEml4();
				
				arrNtcCustListVO.setFaxNo(faxNo);
				arrNtcCustListVO.setNtcEml(eml);
				
				ObjectCloner.build(arrNtcCustListVO ,bkgArrNtcDtlVO);
				modifyRowCnt = dbDao.modifyArrNtcDtls(bkgArrNtcDtlVO,account);
				if(modifyRowCnt == 0 ){
					
					dbDao.addArrNtcDtls(bkgArrNtcDtlVO, account);
					if(faxNo.equals("") && eml.equals("")){
						dbDao.removeArrNtcDtls(bkgArrNtcDtlVO);
					}
					
				}

				arrNtcCustListVO.setCustCntcTpCd("AN");
				
				faxNo = arrNtcCustListVO.getFax5();
				eml = arrNtcCustListVO.getEml5();
				
				arrNtcCustListVO.setFaxNo(faxNo);
				arrNtcCustListVO.setNtcEml(eml);
				
				ObjectCloner.build(arrNtcCustListVO ,bkgArrNtcDtlVO);
				modifyRowCnt = dbDao.modifyArrNtcDtls(bkgArrNtcDtlVO,account);
				if(modifyRowCnt == 0 ){
					
					dbDao.addArrNtcDtls(bkgArrNtcDtlVO, account);//추가
					if(faxNo.equals("") && eml.equals("")){
						dbDao.removeArrNtcDtls(bkgArrNtcDtlVO);
					}
				}
				
				
			}
		}catch (DAOException de) {
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), ex);
        }

	}
	
//	/**
//	 * Arrival Notice Detail을 삭제한다.
//	 * @param String faxNo
//	 * @param String eml
//	 * @param ArrNtcCustListVO arrNtcCustListVO
//	 * @exception DAOException
//	 * @exception Exception
//	 */
//	private void checkModifyArrNtcCustList(String faxNo, String eml, ArrNtcCustListVO arrNtcCustListVO ) throws DAOException, Exception{
//		if(faxNo.equals("") && eml.equals("")){
//			dbDao.removeArrNtcDtls(arrNtcCustListVO);
//		}
//	}
	/**
	 * [672-03]Customer 업로드 정보 조회
	 * @param ArrNtcSearchVO arrNtcSearchVO
	 * @return List<ArrNtcCustUploadListVO>
	 * @exception EventException
	 */
	public List<ArrNtcCustUploadListVO> searchArrNtcCustListForUpload(ArrNtcSearchVO arrNtcSearchVo) throws EventException {
		// TODO Auto-generated method stub
		List<ArrNtcCustUploadListVO> retList = null;
		try {
			
			retList = dbDao.searchArrNtcCustListForUpload(arrNtcSearchVo);
			
			
		}catch (DAOException de) {
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		return retList;
	}
	
	/**
	 * [672-03]Customer 업로드 정보 추가
	 * @param BkgArrNtcDtlVO bkgArrNtcDtlVo
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 * @exception Exception
	 */
	public void createArrNtcCustListbyUpload(BkgArrNtcDtlVO bkgArrNtcDtlVo,SignOnUserAccount account) throws DAOException, Exception{
		
		
		
		int modifyRowCnt = 0;
		try{
		//for(int i=0;i<vos.length;i++){
			//BkgArrNtcDtlVO vo = vos[i];
			//if(vo == null){ continue;}
			//log.debug("---------------------vo {" + vo + "}");
			//log.debug("--------------------- getColumnValues  " + i + " => " +vo.getColumnValues());
			modifyRowCnt = dbDao.modifyArrNtcDtls(bkgArrNtcDtlVo, account);		
			
			if(modifyRowCnt == 0 ){
				dbDao.addArrNtcDtls(bkgArrNtcDtlVo, account);
			}
		}catch (DAOException de) {
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), ex);
        }
		//}
	}	


	/**[242] ARRIVAL NOTICE를 받을 수화주별로 상세 정보를 조회한다.
	 * @param String bkgNo
	 * @param String custTpCd
	 * @return List<ArrNtcCustRefVO>
	 * @exception EventException 
	 */
	public List<ArrNtcCustRefVO> searchArrNtcCustInfo(String bkgNo,
			String custTpCd) throws EventException {
		// TODO Auto-generated method stub
		List<ArrNtcCustRefVO> retList = null;
		try {
			
			retList= dbDao.searchArrNtcCustInfo(bkgNo,custTpCd);
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);

		}catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);

		}
		return retList;
	}


	/**
     * UI-BKG-0764 Customer Data Management Update History<br>
	 * 인바운드 고객정보 수정 현황을 조회한다.
	 *  @author Park Mangeon
	 *  @param  IbCustCntcHisVO ibCustCntcHis
	 *  @return List<IbCustCntcHisVO> ibCustCntcHis
	 *  @exception EventException
	 */
	public List<IbCustCntcHisVO> searchIntgCustCntcInfoHistory (IbCustCntcHisVO ibCustCntcHis) throws EventException{
		List<IbCustCntcHisVO> list = null;
		try {
			list = dbDao.searchIntgCustCntcInfoHistory(ibCustCntcHis);
		}catch (DAOException de) {
			// BKG00450 : 조회에 실패했습니다.
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), de);
		}catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			// BKG00450 : 조회에 실패했습니다.
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
		return list;
	}
	
	
	/**
	 * 1021 Bank In Account No Setup for A/N<br>
	 * 조회
	 * @param String ofcCd
	 * @return BkgArrNtcWdVO
	 * @exception EventException
	 * @author Son YunSeuk
	 */
	public BkgArrNtcWdVO searchArrNtcBankAcct(String ofcCd) throws EventException
	{
		BkgArrNtcWdVO arrNtcBankAcctVO = null;
		try 
		{
			arrNtcBankAcctVO = dbDao.searchArrNtcBankAcct(ofcCd);
        }catch (DAOException de) {
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		return arrNtcBankAcctVO;
	}
	
	
	/**
	 * 1021 Bank In Account No Setup for A/N<br>
	 * 수정 
	 * @param BkgArrNtcWdVO arrNtcBankAcct
	 * @param SignOnUserAccount account
	 * @exception EventException
	 * @author Son YunSeuk
	 */
	public void setupArrNtcBankAcct(BkgArrNtcWdVO bkgArrNtcWdVo, SignOnUserAccount account)throws EventException
	{
		int result = 0;
		try 
		{
			
			bkgArrNtcWdVo.setCreUsrId(account.getUsr_id());
			bkgArrNtcWdVo.setUpdUsrId(account.getUsr_id());
			
			result = dbDao.modifyArrNtcBankAcct(bkgArrNtcWdVo);
			if(result == 0)
			{
				dbDao.addArrNtcBankAcct(bkgArrNtcWdVo);
			}
        }catch (DAOException de) {
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 * 1021 Bank In Account No Setup for A/N<br>
	 * 삭제
	 * @param String ofcCd
	 * @exception EventException
	 * @author Son YunSeuk
	 */
	public void removeArrNtcBankAcct(String ofcCd)throws EventException
	{
		try 
		{
			dbDao.removeArrNtcBankAcct(ofcCd);
        }catch (DAOException de) {
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), ex);
        }
	}

	
	/**
	 * 1020 Group A/N Remark Template<br>
	 * 조회
	 * @param String ofcCd
	 * @return BkgArrNtcWdVO
	 * @exception EventException
	 * @author Son YunSeuk
	 */
	public List<BkgArrNtcWdVO> searchArrNtcGrpForm(String ofcCd) throws EventException
	{
		List<BkgArrNtcWdVO> bkgArrNtcWdVOs = null;
		try 
		{
			bkgArrNtcWdVOs = dbDao.searchArrNtcGrpForm(ofcCd);
        }catch (DAOException de) {
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		return bkgArrNtcWdVOs;
	}
	
	
	/**
	 * 1020 Group A/N Remark Template<br>
	 * 추가, 삭제, 수정 - ibflag활용
	 * @param BkgArrNtcWdVO arrNtcWd
	 * @param SignOnUserAccount account
	 * @exception EventException
	 * @author Son YunSeuk
	 */
	public void setupArrNtcGrpForm ( BkgArrNtcWdVO[] arrNtcWds ,SignOnUserAccount account )throws EventException
	{
		try{
			for(int i=0;i < arrNtcWds.length;i++){
				BkgArrNtcWdVO arrNtcWd = (BkgArrNtcWdVO)arrNtcWds[i];
				String flag = arrNtcWd.getIbflag();
				if("U".equals(flag)){
					dbDao.mergeArrNtcGrpForm(arrNtcWd, account);
				}
				else if("D".equals(flag)){
					dbDao.removeArrNtcForm(arrNtcWd.getAnSeq());
				}
			}
		
		
			
        }catch (DAOException de) {
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), ex);
        }
	}
	
	
	
	/**
	 * [0381]기 Setting된 A/N 발송 대상 정보 및 기 송부 실행이 완료된 A/N History정보를 EDI건을 검색한다.
	 * @param ArrivalNoticeSearchVO arrivalNoticeSearchVo 
	 * @param SignOnUserAccount account
	 * @return List<ArrNtcSendListVO>
	 * @exception EventException 
	 */
	public List<ArrNtcSendListVO> searchArrNtcSendList(ArrivalNoticeSearchVO arrivalNoticeSearchVo,SignOnUserAccount account) throws EventException{
		// TODO Auto-generated method stub
		
		List<ArrNtcSendListVO> retList = null;
		try {
			
			retList= dbDao.searchArrNtcSendList(arrivalNoticeSearchVo,account);
			
		} catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }

		return retList;
	}
	
	/**
	 * [0381]기 Setting된 A/N 발송 대상 정보 및 기 송부 실행이 완료된 A/N History정보를  검색한다.
	 * @param ArrivalNoticeSearchVO arrivalNoticeSearchVo 
	 * @param SignOnUserAccount account
	 * @return List<ArrNtcSendListVO>
	 * @exception EventException 
	 */
	public List<ArrNtcSendListVO> searchArrNtcSendListByEdi(ArrivalNoticeSearchVO arrivalNoticeSearchVo,SignOnUserAccount account) throws EventException{
		// TODO Auto-generated method stub
		
		List<ArrNtcSendListVO> retList = null;
		try {
			
			retList= dbDao.searchArrNtcSendListByEdi(arrivalNoticeSearchVo,account);
			
		} catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }

		return retList;
	}
	
	/**
	 * 1044 Add Concerned Party Pop-up
	 * 조회
	 * @param String ofcCd 
     * @param String custCd 
     * @param String custSeq
     * @param String custTpCd
     * @return List<BkgIbCmdtCntcVO>
	 * @exception EventException
	 * @author Son YunSeuk
	 */
	public List<BkgIbCmdtCntcVO> searchCustCmdtCntcInfo( String ofcCd , String custCd , String custSeq, String custTpCd ) throws EventException
	{
		List<BkgIbCmdtCntcVO> list = null;
		try 
		{
			list = dbDao.searchCustCmdtCntcInfo(ofcCd, custCd, custSeq, custTpCd);
        }catch (DAOException de) {
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		return list;
	}
	
	
	/**
	 * 1044 Add Concerned Party Pop-up
	 * 추가, 삭제, 수정 - ibflag활용
	 * @param BkgIbCmdtCntcVO[] ibCmdtCntcs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 * @author Son YunSeuk
	 */
	public void manageCustCmdtCntcInfo( BkgIbCmdtCntcVO[] ibCmdtCntcs , SignOnUserAccount account ) throws EventException
	{
		
		try
		{
			for(int i=0;i<ibCmdtCntcs.length;i++)
			{
				BkgIbCmdtCntcVO ibCmdtCntc = ibCmdtCntcs[i];
				
				String flag = ibCmdtCntc.getIbflag();
				if("I".equals(flag))
				{
					ibCmdtCntc.setDeltFlg("N");
					dbDao.addCustCmdtCntctInfo(ibCmdtCntc, account);
				}
				else if("U".equals(flag))
				{
					dbDao.modifyCustCmdtCntcInfo(ibCmdtCntc, account);
				}
				else if("D".equals(flag))
				{
					dbDao.removeCustCmdtCntcInfo(ibCmdtCntc);
				}
			}
        }catch (DAOException de) {
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
	}
	/**
	 * [0381] Fax 전송
	 * @param ArrNtcSendListVO[] listVOS
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO> 
	 * @exception DAOException 
	 * @exception Exception 
	 */
	public List<BkgNtcHisVO> sendArrNtcByFax(ArrNtcSendListVO[] listVOS,
			SignOnUserAccount account) throws Exception {

		// 1.modifyArrNtcBySend;
		// 2.modifyArrNtcDtlBySend
		// 3.sendFax
		// 4.modifyArrNtcSendId
		// 5.BkgNtcHisVO 생성후 리턴
		
		List<BkgNtcHisVO> hisVOS = new ArrayList<BkgNtcHisVO>();
		String[] arrCustCntcTpCd = new String[] { "C1", "C2", "B1", "B2", "AN","A1","A2" };
		
		String strSndrInfo;
//		if("SINBB".equals(account.getOfc_cd())){ //@ 2015.08.03 한진그룹 코드 표준화
		if("SINSC".equals(account.getOfc_cd())){
			strSndrInfo = "SMLINE-SIN";
		}else{
			strSndrInfo = account.getUsr_id();
		}
		
		String reviseYN="";
		try {

			for (int i = 0; i < listVOS.length; i++) {// ROW 단위의 FOR시작

				ArrNtcSendListVO listVO = listVOS[i];
				
				
				//CHK 가 선택되어있을경우만 실행
				if(listVO.getChkFax().equals("1")){
					//A/N Form Title Revise Check 
					reviseYN = dbDao.searchReviseYN(listVO.getBkgNo(),"AN");
					
					// Model-4(Master 수정)
					dbDao.modifyArrNtcBySend(listVO, account);
	
					// Model-6(Detail 수정)
					BkgArrNtcDtlVO dtlVO = new BkgArrNtcDtlVO();
					
					String rcvInfo = "";
					//Cust cntc Tp cd 값
					//Vector<String> vCustCntcTpCd = new Vector<String>();
					
					//Fax 번호
					//String[] arrFaxNo = this.getFaxNoS(listVO);
					String[] arrFaxNo = new String[] {listVO.getFaxNo1(),listVO.getFaxNo2(),listVO.getFaxNo3(),listVO.getFaxNo4(),listVO.getFaxNo5(),listVO.getFaxNo6(),listVO.getFaxNo7()};
					//Fax 체크박스
					//String[] arrFaxEvntFlg = this.getFaxEvntFlg(listVO);
					String[] arrFaxEvntFlg = new String[] {listVO.getFaxEvntFlg1(),listVO.getFaxEvntFlg2(),listVO.getFaxEvntFlg3(),listVO.getFaxEvntFlg4(),listVO.getFaxEvntFlg5(),listVO.getFaxEvntFlg6(),listVO.getFaxEvntFlg7()};
					
					
					for (int x = 0; x < arrCustCntcTpCd.length; x++) { //C1,C2등의 단위별 For 시작
						
						
						
						dtlVO.setBkgNo(listVO.getBkgNo());
						dtlVO.setBkgCustTpCd(listVO.getBkgCustTpCd());
						dtlVO.setCustCntcTpCd(arrCustCntcTpCd[x]);					
						dtlVO.setFaxNo(arrFaxNo[x]);
						dtlVO.setFaxEvntFlg(arrFaxEvntFlg[x]);
						dtlVO.setFaxTpCd("F");
						
						
						
						// Model-7
						if(arrFaxEvntFlg[x].equals("1")){				        								
							// Detail 수정실행
							int modResult = dbDao.modifyArrNtcDtlByFax(dtlVO, account);
							//수정값이 0이면 데이터가 없으므로, insert 를 실행한다.
							if(modResult == 0){
								dbDao.addArrNtcDtlByFax(dtlVO, account);
							}
							
							List<FaxSendVO> faxInfos = new ArrayList<FaxSendVO>();
							
						
							//이름에 , 가 있으면 공백으로 대체 ; 오류가 발생
							String custNm = listVO.getCustNm();
							custNm = custNm.replaceAll(",", " " );
							custNm = custNm.replaceAll(";", " " );
							
							if(custNm.length() > 12){
								custNm = custNm.substring(0,12) + "...";
							}
							rcvInfo = custNm +";"+arrFaxNo[x];
						
							// Fax 정보 설정
							//FaxSendVO faxInfo = this.setFaxInfo(rcvInfo,listVO.getBkgNo(), listVO.getDiffRmk(), listVO.getChgDpFlg(), account);
							//---------------------------------------------------------
							ArrNtcMrdSearchVO arrNtcMrdSearch = new ArrNtcMrdSearchVO();
							arrNtcMrdSearch.setBkgNo(listVO.getBkgNo());
							arrNtcMrdSearch.setUsrId(account.getUsr_id());
							arrNtcMrdSearch.setOfcCd(account.getOfc_cd());
							
							//------------------------------------
							//MRD 관련 정보를 구하기  Start 
							//------------------------------------
//							ArrNtcMrdVO mrdVO = this.searchArrNtcMrdId(arrNtcMrdSearch);
//							log.debug("ERR Log arrNtcMrdSearch : " + arrNtcMrdSearch);
//							log.debug("ERR Log mrdVO : " + mrdVO);
							String mrdId = listVO.getMrdId();
							String loclLangFlg = listVO.getLoclLangFlg();
							String eclzBlCpyFlg = listVO.getEclzBlCpyFlg();
							String comParam = listVO.getComParam();
							//------------------------------------
							//MRD 관련 정보를 구하기  End
							//------------------------------------
							
							FaxSendVO faxInfo = new FaxSendVO();
							faxInfo.setSysCd("BKG");
							faxInfo.setTmplMrd(mrdId + ".mrd");

							
							faxInfo.setBatchFlg("N");
							faxInfo.setTitle("Arrival Notice Send");
							String strArg = "/rv ";
							strArg = strArg + " form_bkgNo['"     + listVO.getBkgNo()   + "']";
							strArg = strArg + " form_revise_YN['" + reviseYN            + "']";
							strArg = strArg + " form_usrId['"     + account.getUsr_id() + "']";
							strArg = strArg + " form_loclFlg['"   + loclLangFlg         + "']";
							strArg = strArg + " form_tsFlg['"     + listVO.getTsFlg()   + "']";
							

							
							//@ A1,A2에 대해 chage_flag를 별도 세팅해야 하므로 Send 상세 정보를 이용한다.. 2016.02.26  무조건 표기안함 03.09
							if( "A1".equals(arrCustCntcTpCd[x]) || "A2".equals(arrCustCntcTpCd[x]) ){
								strArg = strArg + " form_chgDpFlg['0']";
							}else if("1".equals(listVO.getChgDpFlg())){
								//@ Charge 표기 Y
								strArg = strArg + " form_chgDpFlg['" + listVO.getChgDpFlg() + "']";
							}else{
								//@ Charge 표기 N이면 A1,A2도 표기하지 않느다.
								strArg = strArg + " form_chgDpFlg['" + listVO.getChgDpFlg() + "']";
							}
//							strArg = strArg + " form_chgDpFlg['" + listVO.getChgDpFlg() + "']";
					//		strArg = strArg + " form_remarkCtnt['" + listVO.getDiffRmk() + "']";
							strArg = strArg + " form_remarkCtnt['']";
							strArg = strArg + " form_ofcCd['" + account.getOfc_cd() + "']";
							
							strArg = strArg + " " + comParam;
							
							//2010-03-29 by sungho Arial Unicode Font 사용 시 글자의 윗부분이 잘리는 현상을 해결
							//strArg = strArg + " /rfonttype40";
							
							strArg = strArg.trim();
							
							faxInfo.setTmplParam(strArg); // RD 에 넘어갈 Parameter 값을 설정한다.
							faxInfo.setRcvInfo(rcvInfo);// fax_no 를 , 로 연결한 문자열
							faxInfo.setOffice(account.getOfc_cd());
							faxInfo.setCrtUserId(strSndrInfo);//2014.09.16 senderInfo를 이용하려 했으나 10자리 이상 지원 안되어 기존대로 Create User Id로 처리한다.
							faxInfo.setSndrInfo(strSndrInfo);
							
							
							//-----------------------------------------------------------
							
							
							
							faxInfos.add(faxInfo);// Fax Pool 에 추가
							
							if(eclzBlCpyFlg.equals("Y")){
								FaxSendVO faxInfoObl = new FaxSendVO();
								
								String strArgObl = "/rv ";
								
								strArgObl = strArgObl + " form_bkgNo[( '" + listVO.getBkgNo() + "' )] ";
								strArgObl = strArgObl + " form_type[2]";// ---> Default
								strArgObl = strArgObl + " form_dataOnly[N]";// ---> Default
								strArgObl = strArgObl + " form_manifest[N]";// ---> Default
								strArgObl = strArgObl + " form_usrId[" + account.getUsr_id() + "]";
								strArgObl = strArgObl + " form_hiddeData[N]";// ---> Default
							    strArgObl = strArgObl + " form_level[(6)]";// ---> Default (ex - (1,2,3,4,5))
							    strArgObl = strArgObl + " form_remark[]";// ---> Default
							    strArgObl = strArgObl + " form_Cntr[1]";// ---> Default
							    strArgObl = strArgObl + " form_mainOnly[N]";// ---> Default
							    strArgObl = strArgObl + " form_CorrNo[]";// ---> Default
							    strArgObl = strArgObl + " form_his_cntr[BKG_CONTAINER]";// ---> Default
							    strArgObl = strArgObl + " form_his_bkg[BKG_BOOKING]";// ---> Default
							    strArgObl = strArgObl + " form_his_mkd[BKG_BL_MK_DESC]";// ---> Default
							    strArgObl = strArgObl + " form_his_xpt[BKG_XPT_IMP_LIC]";// ---> Default
							    strArgObl = strArgObl + " form_his_bl[BKG_BL_DOC]";// ---> Default
							    strArgObl = strArgObl + " /rp []";// ---> Default
							    strArgObl = strArgObl + " /riprnmargin";
								
								strArg = strArg.trim();
								log.debug("---------- strArgObl "+ strArgObl);
								log.debug("------- O/B BL을 첨부하여 FAX를 발송합니다.");
								
								faxInfoObl.setSysCd("BKG");
								faxInfoObl.setTmplMrd("ESM_BKG_0109_OBL_A4.mrd");

								faxInfoObl.setBatchFlg("N");
								faxInfoObl.setTitle("O B/L");
								
								faxInfoObl.setTmplParam(strArgObl); // RD 에 넘어갈 Parameter 값을 설정한다.
								faxInfoObl.setRcvInfo(rcvInfo);// fax_no 를 , 로 연결한 문자열
								faxInfoObl.setOffice(account.getOfc_cd());
								faxInfoObl.setCrtUserId(strSndrInfo);
								faxInfoObl.setSndrInfo(strSndrInfo);
								
								log.debug("------- O/B BL을 첨부하여 FAX를 발송 시작");
								//eai.sendFax(faxInfo);
								
								faxInfos.add(faxInfoObl);// Fax Pool 에 추가
								
								
								log.debug("------- O/B BL을 첨부하여 FAX를 발송 끝");
				
							}
							
								
							//실제 Fax 발송
							log.debug("----------------- faxInfos.size() "+ faxInfos.size());
							log.debug("--------------------------------");
							log.debug("실제 Fax 발송");
							log.debug("--------------------------------");
							List<String> retFaxSndId = eaiDao.sendFax(faxInfos);
							String logFaxSndId = retFaxSndId.get(0);
							
							
							
							//Fax 전송후 Send Id 를 업데이트
							dtlVO.setFaxNtcSndId(logFaxSndId);
							dbDao.modifyArrNtcSendIdByFax(dtlVO, account);
							
							
								
							BkgNtcHisVO hisVO = new BkgNtcHisVO();
							hisVO.setNtcViaCd("F");
							hisVO.setSndId(logFaxSndId);
							hisVO.setSndOfcCd(account.getOfc_cd());
							hisVO.setSndUsrId(account.getUsr_id());
							hisVO.setCreUsrId(account.getUsr_id());
							hisVO.setUpdUsrId(account.getUsr_id());
							hisVO.setBkgNo(dtlVO.getBkgNo());
							hisVO.setBkgCustTpCd(dtlVO.getBkgCustTpCd());
							hisVO.setCustCntcTpCd(dtlVO.getCustCntcTpCd());
							
							log.debug("--------------1818181 retFaxSndId  "+ retFaxSndId);
							
							// Model-9
							//History 업데이트
						
							hisVOS.add(dbDao.searchArrNtcHistory(hisVO));
							
						}
						
					} //C1,C2등의 단위별 For 끝
				}
				
			}// ROW 단위의 FOR 끝

		} catch(EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }


		return hisVOS;

	}

	/**
	 * [0312] EDI 전송
	 * @param List<ArrNtcSendListVO> list
	 * @param String batchFlg
	 * @param SignOnUserAccount account
	 * @return List<ArrNtcSendListVO> 
	 * @exception DAOException 
	 * @exception Exception 
	 */
	public List<BkgNtcHisVO> sendArrivaNoticeEdi( List<ArrNtcSendListVO> list
			                                     ,String batchFlg 
			                                     ,SignOnUserAccount account) throws Exception {
		 log.info("ArrivalNoticeBCImpl:::::sendArrivaNoticeEdi is call!!");
		 /*
		 1.searchArrNtcEdi312Header;
		 2.searchArrNtcEdi312Bllnfo
		 3.searchArrNtcEdi312CustInfo
		 4.searchArrNtcEdi312CntrInfo
		 5.searchArrNtcEdi312CntrSealInfo
		 
		 6.searchArrNtcEdi312CntrDgInfo
		 7.searchArrNtcEdi312CntrDescInfo
		 8.searchArrNtcEdi312ChargeInfo
		 9.searchArrNtcEdi312ChargeTotInfo
		 10.sendFlatFile
		 11.searchArrNtcHistory
		*/
		
		List<BkgNtcHisVO> hisVOS = new ArrayList<BkgNtcHisVO>();
		ArrNtcSendListVO arrNtcSendListVO = null;
		ArrNtcEdi312CntrInfoVO cntrInfoVO = null;
		BkgIbEdiSndLogVO ibEdiSndLog = null;
		BkgArrNtcDtlVO dtlVO = null;
		
		String usrId = null;
		String ofcCd = null;
		
		try {
			
			String senderId   = "SMLINE";
            String receiverId = "TOSHIBA";
            String msgId      = "312";
            String queueNm    = "BKG.ALPSBKG_UBIZHJS_CUSTOMER.IBMMQ.QUEUE"; 
            
          
            if("Y".equals(batchFlg)){
            	usrId = "ESM_BKG_B033";
//                ofcCd = "SELBB";//@ 2015.08.03 한진그룹 코드 표준화
                ofcCd = "SELSC";
            }else{
            	usrId = account.getUsr_id();
          		ofcCd = account.getOfc_cd();
            }
            
			// ROW 단위의 FOR시작
			for (int i = 0; i < list.size(); i++) {
				
				arrNtcSendListVO = new ArrNtcSendListVO();
				
				log.info("list.getBkgNo::"+i+">>>>>"+list.get(i).getBkgNo());
				
				arrNtcSendListVO = list.get(i);
				
				log.info("arrNtcSendListVO.getBkgNo()::"+arrNtcSendListVO.getBkgNo());
				
				//Batch or 화면 호출 여부에 따라 분기
				if(list.get(i).getChkEdi().equals("1")){
					
					String ediHdr = dbDao.searchArrNtcEdi312Header(senderId,receiverId,msgId);
					
					//log.info("ediHdr::"+ediHdr);
					
					String blInfo = dbDao.searchArrNtcEdi312Bllnfo(arrNtcSendListVO.getBkgNo());
					
					//log.info("blInfo::"+blInfo);
					
					StringBuffer flatFile = new StringBuffer();
					
					flatFile.append(ediHdr);
					flatFile.append(blInfo);
					
					//log확인
		            //flatFile.append("\n").append("======================ediHdr START=================").append("\n").append(ediHdr).append("\n").append("======================ediHdr END===================").append("\n");
		            //flatFile.append("======================blInfo START=================").append("\n").append(blInfo).append("\n").append("======================blInfo END===================").append("\n");
					
		            String[] custInfo =dbDao.searchArrNtcEdi312CustInfo(arrNtcSendListVO.getBkgNo());
					
		            for(int j=0 ; j < custInfo.length ; j++) {
		            	flatFile.append(custInfo[j]);
		            	//log확인
		                //flatFile.append("======================custInfo START=================").append("\n").append(custInfo[j]).append("\n").append("======================custInfo end===================").append("\n");
		                //log.info("custInfo>>>"+j+"::"+custInfo[j]);
		            }
		            
					//List<ArrNtcEdi312CntrInfoVO> arrNtcEdi312CntrlInfoVOs = dbDao.searchArrNtcEdi312CntrInfo(arrNtcSendListVO.getBkgNo());
					
					ArrNtcEdi312CntrInfoVO[] arrNtcEdi312CntrlInfoVOs = dbDao.searchArrNtcEdi312CntrInfo(arrNtcSendListVO.getBkgNo());
					
					//String[] cntrInfo = (String[])arrNtcEdi312CntrlInfoVOs.toArray(new String[arrNtcEdi312CntrlInfoVOs.size()]);
					
					for(int j=0 ; j < arrNtcEdi312CntrlInfoVOs.length ; j++) {
						//log.info("arrNtcEdi312CntrlInfoVOs>>>"+j+"::"+arrNtcEdi312CntrlInfoVOs[j]);
						
						cntrInfoVO = new ArrNtcEdi312CntrInfoVO();
						
						cntrInfoVO = arrNtcEdi312CntrlInfoVOs[j];
						
						flatFile.append(cntrInfoVO.getCntr());
						//log확인
						//flatFile.append("======================cntrInfoVO START=================").append("\n").append(arrNtcEdi312CntrlInfoVOs[j]).append("\n").append("======================cntrInfoVO end===================").append("\n");
						
						//log.info("cntrInfoVO.getBkgNo()::"+cntrInfoVO.getBkgNo()+", cntrInfoVO.getCntrNo()::"+cntrInfoVO.getCntrNo());
						
						String[] sealInfo = dbDao.searchArrNtcEdi312CntrSealInfo(cntrInfoVO.getBkgNo(), cntrInfoVO.getCntrNo());
						
						for(int k=0 ; k < sealInfo.length ; k++) {
							flatFile.append(sealInfo[k]);
							//log확인
			                //flatFile.append("======================sealInfo START=================").append("\n").append(sealInfo[k]).append("\n").append("======================sealInfo end===================").append("\n");
			                //log.info("sealInfo>>>"+k+"::"+sealInfo[k]);
			            }
						
						String cntrDgInfo = dbDao.searchArrNtcEdi312CntrDgInfo(cntrInfoVO.getBkgNo(), cntrInfoVO.getCntrNo());
						
						flatFile.append(cntrDgInfo);
						//log확인
						//flatFile.append("======================cntrDgInfo START=================").append("\n").append(cntrDgInfo).append("\n").append("======================cntrDtlInfo end===================").append("\n");
						
						//log.info("cntrDgInfo::"+cntrDgInfo);
						
						String cntrDescInfo = dbDao.searchArrNtcEdi312CntrDescInfo(cntrInfoVO.getBkgNo(), cntrInfoVO.getCntrNo());
						
						flatFile.append(cntrDescInfo);
						//log확인
						//flatFile.append("======================cntrDescInfo START=================").append("\n").append(cntrDescInfo).append("\n").append("======================cntrDtlInfo end===================").append("\n");
						
						//log.info("cntrDescInfo::"+cntrDescInfo);
						flatFile.append("}CNTR_INFO\n");
					}
					
					//log.info("list.end.getBkgNo::"+i+">>>>>"+list.get(i).getBkgNo());
					
					String[] chargeInfo = dbDao.searchArrNtcEdi312ChargeInfo(arrNtcSendListVO.getBkgNo());
					
					for(int k=0 ; k < chargeInfo.length ; k++) {
						flatFile.append(chargeInfo[k]);
						//log확인
		                //flatFile.append("======================chargeInfo START=================").append("\n").append(chargeInfo[k]).append("\n").append("======================chargeInfo end===================").append("\n");
		                //log.info("chargeInfo>>>"+k+"::"+chargeInfo[k]);
		            }
					
					String[] totChargeInfo = dbDao.searchArrNtcEdi312ChargeTotInfo(arrNtcSendListVO.getBkgNo());
					
					for(int k=0 ; k < totChargeInfo.length ; k++) {
						flatFile.append(totChargeInfo[k]);
						//log확인
		                //flatFile.append("======================totChargeInfo START=================").append("\n").append(totChargeInfo[k]).append("\n").append("======================totChargeInfo end===================").append("\n");
		                //log.info("totChargeInfo>>>"+k+"::"+totChargeInfo[k]);
		            }
					
					//log.info("flatFile::"+flatFile.toString());
					log.info("end arrNtcSendListVO.getBkgNo()::"+arrNtcSendListVO.getBkgNo());
					
					SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
		            sendFlatFileVO.setFlatFile(flatFile.toString());

		            //QueueNm 세팅
		            sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get(queueNm)); //2011.09.22
		            BookingUtil command = new BookingUtil();
		            
		            FlatFileAckVO flatFileAckVO = new FlatFileAckVO();
		            flatFileAckVO = command.sendFlatFile(sendFlatFileVO);
					
		            //EDI ERROR 발생 시
		            if ( flatFileAckVO.getAckStsCd().equals("E"))
		                throw new EventException(new ErrorHandler("BKG00205").getMessage());  
		            
		            dtlVO = new BkgArrNtcDtlVO();
		            
		            dtlVO.setBkgNo(arrNtcSendListVO.getBkgNo());
		            dtlVO.setBkgCustTpCd(arrNtcSendListVO.getBkgCustTpCd());
		            
		            dbDao.mergeArrNtcDtlByEdi(dtlVO, account);
		            
					ibEdiSndLog = new BkgIbEdiSndLogVO();
		            
		            ibEdiSndLog.setBkgNo(arrNtcSendListVO.getBkgNo());
		            ibEdiSndLog.setFltFileRefNo(ediHdr.substring(62,76));
		            ibEdiSndLog.setDoEdiTpCd("ARR");
		            ibEdiSndLog.setMsgTpId(msgId);
		            ibEdiSndLog.setMsgTpNm(receiverId);
		            ibEdiSndLog.setEdiSndMsgCtnt(sendFlatFileVO.getFlatFile());
		            ibEdiSndLog.setEdiEvntOfcCd(ofcCd);
		           	ibEdiSndLog.setEdiEvntUsrId(usrId);
		           	ibEdiSndLog.setCreUsrId(usrId);
		           	ibEdiSndLog.setUpdUsrId(usrId);
		            
		            dbDao.addArrNtcEdiSndLog(ibEdiSndLog);
		            
		            BkgNtcHisVO hisVO = new BkgNtcHisVO();
		            hisVO.setBkgNo(arrNtcSendListVO.getBkgNo());
                    hisVO.setBkgCustTpCd(arrNtcSendListVO.getBkgCustTpCd());
                    hisVO.setCustCntcTpCd("C1");
                    hisVO.setNtcViaCd("E");
                    hisVO.setSndId("");
                    hisVO.setSndOfcCd(ofcCd);                    
                   	hisVO.setSndUsrId(usrId);		            
                   	hisVO.setCreUsrId(usrId);		           
                    hisVO.setUpdUsrId(usrId);		            
                    
                    // Model-9
                    //History 업데이트
                    hisVOS.add(dbDao.searchArrNtcHistory(hisVO));
					
				}
			
			}
			// ROW 단위의 FOR 끝
			
		} catch(DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }

		return hisVOS;

	}
		
	/**
	 * [0381] E-Mail 전송시 본문 내용에 BKG NO를 표기하기 위함.
	 * BKG NO가 EMAIL이 같을시 RD 메일 서버에서 첫번째 본문을 내용 보내기 때문에 
	 * 첨부파일과 내용이 정확하지 않아, EMAIL 당 다른 BKG NO가 존재할시 본문 내용에 표기 하지 않는다.
	 * @param ArrNtcSendListVO[] arrNtcSendListVos
	 * @return HashMap 
	 * @exception Exception 
	 */
	public HashMap<String,String>  checkMutiBkgNoPerEmailMap(ArrNtcSendListVO[] arrNtcSendListVos){
	
		HashMap<String,String> mailBkgMap           = new HashMap<String,String>();
		HashMap<String,String> mutiBkgNoPerEmailMap = new HashMap<String,String>();
		String[] arrCustCntcTpCd = new String[] { "C1", "C2", "B1", "B2", "AN" };
		for (int i = 0; i < arrNtcSendListVos.length; i++) {
			ArrNtcSendListVO listVO = arrNtcSendListVos[i];
			
			//log.debug("--------------------------- listVO "+listVO);
			//CHK 가 선택되어있을경우만 실행
			if(!listVO.getChkEmail().equals("1")){
				continue;
			}
				//전체 Email , 저장용으로 사용
				Vector<String> vNtcEml = new Vector<String>();
				vNtcEml.add(listVO.getNtcEml1());
				vNtcEml.add(listVO.getNtcEml2());
				vNtcEml.add(listVO.getNtcEml3());
				vNtcEml.add(listVO.getNtcEml4());
				vNtcEml.add(listVO.getNtcEml5());
				//메일체크, 플래그
				Vector<String> vEmlEvntFlg = new Vector<String>();
				vEmlEvntFlg.add(listVO.getEmlEvntFlg1());
				vEmlEvntFlg.add(listVO.getEmlEvntFlg2());
				vEmlEvntFlg.add(listVO.getEmlEvntFlg3());
				vEmlEvntFlg.add(listVO.getEmlEvntFlg4());
				vEmlEvntFlg.add(listVO.getEmlEvntFlg5());
				
				for (int x = 0; x < arrCustCntcTpCd.length; x++) {
					if(vEmlEvntFlg.get(x).equals("1")){
						 if(vNtcEml.get(x) == null || vNtcEml.get(x).equals("")){
	                        	continue;
	                     }
						 
						 if(mailBkgMap.containsKey(vNtcEml.get(x))){ // 해당 email이 이미 있으면
							 if(!listVO.getBkgNo().equals(mailBkgMap.get(vNtcEml.get(x)))){ //BKB NO가 다른지 검사한다.
									 mutiBkgNoPerEmailMap.put(vNtcEml.get(x),"Y");// 다르면 multi bkg no 맵에 담는다.
							 }
						 }else{
							 mailBkgMap.put(vNtcEml.get(x),listVO.getBkgNo());
						 }
					}
					
				}				

		}
		return mutiBkgNoPerEmailMap;
	}
	/**
	 * [0381] E-Mail 전송
	 * @param ArrNtcSendListVO[] arrNtcSendListVos
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO> 
	 * @exception Exception 
	 */
	public List<BkgNtcHisVO> sendArrNtcByEmail(ArrNtcSendListVO[] arrNtcSendListVos						
						, SignOnUserAccount account) throws Exception{
		//1.modifyArrNtcBySend
		//2.modifyArrDtlByMail
		//3.sendEmail
		//4.modifyArrNtcSendId
		//5.searchBkgHistMstSeq
		//6.max seq 값을 설정		
		
		List<BkgNtcHisVO> hisVOS = new ArrayList<BkgNtcHisVO>();
		
		//@ 2016.01.15 Arrival Notice Send - 셋업된 Also Notify에 한해 2군데까지 A/notice 전송 기능 개발  
		String[] arrCustCntcTpCd = new String[] { "C1", "C2", "B1", "B2", "AN","A1","A2" };
		
		//HashMap<String,String> mutiBkgNoPerEmailMap = checkMutiBkgNoPerEmailMap(arrNtcSendListVos);
		
		//개별적으로 보낼 제목과 본문 내용
		String edtSubject  = "";
		String edtContents = "";
		String reviseYN ="";
		
		if(arrNtcSendListVos.length > 0){
			edtSubject  = arrNtcSendListVos[0].getEdtSubject();
		}   edtContents = arrNtcSendListVos[0].getEdtContents();
		
		try {
			BookingUtil util = new BookingUtil();
			// 메일 Copy 정보 조회
			String copyEml = util.searchCcEmailAddrRSQL("AN", account.getUsr_id());		
			
			List<RDMailSendVO> mailInfos = new ArrayList<RDMailSendVO>();
			//log.debug("-------------- mailInfos length"+ mailInfos.length);
			
			for (int i = 0; i < arrNtcSendListVos.length; i++) {
				ArrNtcSendListVO listVO = arrNtcSendListVos[i];
				//log.debug("--------------------------- listVO "+listVO);
				//CHK 가 선택되어있을경우만 실행
				if(listVO.getChkEmail().equals("1")){
					
					// Model-4(Master 수정)
					dbDao.modifyArrNtcBySend(listVO, account);
					
					//A/N Form Title Revise Check 
					reviseYN = dbDao.searchReviseYN(listVO.getBkgNo(),"AN");

					// Model-6(Detail 수정)
					BkgArrNtcDtlVO dtlVO = new BkgArrNtcDtlVO();
					
					//보낼 메일 주소(플래그가 있는경우만
					//@ A1,A2에 대해 chage_flag를 별도 세팅해야 하므로 객체를 세팅한다. 2016.02.26
//					Vector<String> rcvMailInfo = new Vector<String>();
					Vector<ArrNtcSendListVO> rcvMailInfo = new Vector<ArrNtcSendListVO>();
					
					//Cust cntc Tp cd 값
					Vector<String> vCustCntcTpCd = new Vector<String>();
					//전체 Email , 저장용으로 사용
					Vector<String> vNtcEml = new Vector<String>();
					vNtcEml.add(listVO.getNtcEml1());
					vNtcEml.add(listVO.getNtcEml2());
					vNtcEml.add(listVO.getNtcEml3());
					vNtcEml.add(listVO.getNtcEml4());
					vNtcEml.add(listVO.getNtcEml5());
					
					//@ 2016.01.15 Arrival Notice Send - 셋업된 Also Notify에 한해 2군데까지 A/notice 전송 기능 개발
					vNtcEml.add(listVO.getNtcEml6());
					vNtcEml.add(listVO.getNtcEml7());
					//메일체크, 플래그
					Vector<String> vEmlEvntFlg = new Vector<String>();
					vEmlEvntFlg.add(listVO.getEmlEvntFlg1());
					vEmlEvntFlg.add(listVO.getEmlEvntFlg2());
					vEmlEvntFlg.add(listVO.getEmlEvntFlg3());
					vEmlEvntFlg.add(listVO.getEmlEvntFlg4());
					vEmlEvntFlg.add(listVO.getEmlEvntFlg5());
					
					//@ 2016.01.15 Arrival Notice Send - 셋업된 Also Notify에 한해 2군데까지 A/notice 전송 기능 개발
					vEmlEvntFlg.add(listVO.getEmlEvntFlg6());
					vEmlEvntFlg.add(listVO.getEmlEvntFlg7());
					
					for (int x = 0; x < arrCustCntcTpCd.length; x++) {
						dtlVO.setBkgNo(listVO.getBkgNo());
						dtlVO.setBkgCustTpCd(listVO.getBkgCustTpCd());
						dtlVO.setCustCntcTpCd(arrCustCntcTpCd[x]);					
						dtlVO.setNtcEml(""+vNtcEml.get(x));
						dtlVO.setEmlEvntFlg(""+vEmlEvntFlg.get(x));
						dtlVO.setEmlTpCd("M");
                        dtlVO.setEmlSndUsrId(account.getUsr_id());
                        
                        // Detail 수정실행
						
                        log.debug("-------------------- reviseYN " + reviseYN);
						log.debug("-------------------- vEmlEvntFlg.get(x) " + x + "   :   "+vEmlEvntFlg.get(x));
						if(vEmlEvntFlg.get(x).equals("1")){
							log.debug("----------------- detail 수정실행");
							//@ A1,A2에 대해 chage_flag를 별도 세팅해야 하므로 객체를 세팅한다. 2016.02.26 무조건 안보여줌 03.09
							ArrNtcSendListVO sendVO = new ArrNtcSendListVO();
//							if("A1".equals(arrCustCntcTpCd[x]) ){
//								sendVO.setChgDpFlg(listVO.getEmlChgFlg6());
//							}else if("A2".equals(arrCustCntcTpCd[x])){
//								sendVO.setChgDpFlg(listVO.getEmlChgFlg7());
//							}
							sendVO.setCustCntcTpCd(arrCustCntcTpCd[x]);
							sendVO.setNtcEml(vNtcEml.get(x));
							rcvMailInfo.add(sendVO);
//							rcvMailInfo.add(vNtcEml.get(x));
							
							vCustCntcTpCd.add(arrCustCntcTpCd[x]);
							//메일의 값이 없으면 통과
	                        if(vNtcEml.get(x) == null || vNtcEml.get(x).equals("")){
	                        	continue;
	                        }
							int modResult = dbDao.modifyArrNtcDtlByMail(dtlVO, account);
							if(modResult == 0){
								dbDao.addArrNtcDtlByMail(dtlVO, account);
							}
							
						}
						
					}				
					//log.debug("-------------------- listVO.getChk()" + listVO.getChkEmail());				
					
					log.debug("-------------- mailInfos length"+ mailInfos.size());					
					
					// 발송인에게 해당  B/L에 대해 메일 Copy 본을 송신함 
					if( !StringUtils.isBlank(copyEml) ){
						//@ A1,A2에 대해 chage_flag를 별도 세팅해야 하므로 객체를 세팅한다. 2016.02.26
						ArrNtcSendListVO sendVO = new ArrNtcSendListVO();
						sendVO.setNtcEml(copyEml);
						rcvMailInfo.add(sendVO);
//						rcvMailInfo.add(copyEml);
					}					
					
					ArrNtcSendListVO sendNtcVO = new ArrNtcSendListVO (); 
					for(int v=0;v<rcvMailInfo.size();v++){
						sendNtcVO = rcvMailInfo.get(v);
						//RDMailSendVO mailInfo = new RDMailSendVO();
						RDMailSendVO mailInfo = new RDMailSendVO();
						List<ComRptDsgnXptInfoVO> rdVOs = new ArrayList<ComRptDsgnXptInfoVO>();
						
						String bkgNo = "";
						
						//해당 MRD 정보구해오기
						log.debug("------------------ 해당 MRD 정보구해오기");
						
						log.debug("rcvMailInfo.get(v) : " + sendNtcVO.getNtcEml());
						
						ArrNtcMrdSearchVO arrNtcMrdSearch = new ArrNtcMrdSearchVO();
						arrNtcMrdSearch.setBkgNo(listVO.getBkgNo());
						arrNtcMrdSearch.setUsrId(account.getUsr_id());
						arrNtcMrdSearch.setOfcCd(account.getOfc_cd());
						
						//------------------------------------
						//MRD 관련 정보를 구하기  Start 
						//------------------------------------
//						ArrNtcMrdVO mrdVO = this.searchArrNtcMrdId(arrNtcMrdSearch);
						String mrdId = listVO.getMrdId();
						String loclLangFlg = listVO.getLoclLangFlg();
						
						String eclzBlCpyFlg = listVO.getEclzBlCpyFlg();
						String comParam = listVO.getComParam();
						
						//------------------------------------
						//MRD 관련 정보를 구하기  End
						//------------------------------------
						
						bkgNo = listVO.getBkgNo();
						
						ComRptDsgnXptInfoVO rdVO = new ComRptDsgnXptInfoVO();		
						
						rdVO.setCreUsrId(account.getUsr_id());
						rdVO.setUpdUsrId(account.getUsr_id());						
						
						//파일명 : AN_BLNO.pdf
						rdVO.setXptFileNm("AN_"+listVO.getBlNo() + ".pdf");
						rdVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
						rdVO.setRdTmpltNm(mrdId + ".mrd");
						
						StringBuffer strArg = new StringBuffer("/rv ");
						
						///rv form_grpNtcSeq[1] form_usrId['TES_AARBA'] form_loclFlg['Y'] form_mainOnly[N] form_remarkCtnt['']
				                                                                                                 
						strArg.append(" form_bkgNo['")  .append(bkgNo               ).append("']");
						strArg.append(" form_revise_YN['")  .append(reviseYN        ).append("']");
						strArg.append(" form_usrId['")  .append(account.getUsr_id() ).append("']");
						strArg.append(" form_loclFlg['").append(loclLangFlg         ).append("']");
						strArg.append(" form_tsFlg['")  .append(listVO.getTsFlg()   ).append("']");
				
			// 아래 2 Line 수정
						//@ A1,A2에 대해 chage_flag를 별도 세팅해야 하므로 Send 상세 정보를 이용한다.. 2016.02.26  무조건 표기안함 03.09
						if( "A1".equals(sendNtcVO.getCustCntcTpCd()) || "A2".equals(sendNtcVO.getCustCntcTpCd()) ){
							strArg.append(" form_chgDpFlg['0']");
						}else  if("1".equals(listVO.getChgDpFlg())){
								strArg.append(" form_chgDpFlg['").append(listVO.getChgDpFlg()).append("']");		
						}else{
							strArg.append(" form_chgDpFlg['").append(listVO.getChgDpFlg()).append("']");
						}
						
						strArg.append(" form_remarkCtnt['']");
						strArg.append(" form_ofcCd['")   .append(account.getOfc_cd()) .append("']");
						
						strArg.append(" ").append(comParam);
						
						rdVO.setRdParaCtnt(strArg.toString());
						rdVOs.add(rdVO);	

						String [] arg = new String [2];
						arg[0] = bkgNo;
						StringBuilder[] content = util.getNotificationTemplated("AN", arg);

						mailInfo.setSndrNm("SM Line");
						mailInfo.setSndrEml(account.getUsr_eml());	
						mailInfo.setRcvrEml(sendNtcVO.getNtcEml());
						mailInfo.setRcvrNm(listVO.getCustNm());		
						if("".equals(edtSubject)){
							mailInfo.setEmlTitNm("[SM LINE] Container(s) will arrive at POD Soon");
						}else{
							mailInfo.setEmlTitNm(edtSubject);
						}
//						mailInfo.setTemplate("ESM_BKG_0381_01T.html");
//						System.out.println("content[1].toString():"+content[1].toString());
//						if(mutiBkgNoPerEmailMap.containsKey(rcvMailInfo.get(v))){ // 하나의 메일 주소로 여러개의 bkg no를 첨부하게 되는 경우
//							mailInfo.setTextContent(content[1].toString().replaceAll("\\(BKG No:.*\\)", ""));
//						}else{
//							mailInfo.setTextContent(content[1].toString());							
//						} 
						
						if("".equals(edtContents)){
							mailInfo.setTextContent(content[1].toString());							
						}else{
							mailInfo.setTextContent(edtContents);							
						}
						
						
						HashMap<String, String> arguments = new HashMap<String, String>();
						arguments.put("rcvrNm", listVO.getCustNm());
						mailInfo.setArguments(arguments);
						
						
						mailInfo.setFileKey(listVO.getFileKey());						
					
						//Multi RD 파일 첨부
						log.debug("--------------------------- eclzBlCpyFlg    "+eclzBlCpyFlg);
						if(eclzBlCpyFlg.equals("Y")){
							//rdVO = new ReportDesignerExportVO();
							rdVO = new ComRptDsgnXptInfoVO();
							
							rdVO.setCreUsrId(account.getUsr_id());
							rdVO.setUpdUsrId(account.getUsr_id());
							
							
							
							strArg = new StringBuffer("/rv ");
							
							strArg.append(" form_bkgNo[( '").append(listVO.getBkgNo()).append("' )] ");
						    strArg.append(" form_type[2]");// ---> Default
						    strArg.append(" form_dataOnly[N]");// ---> Default
						    strArg.append(" form_manifest[N]");// ---> Default
						    strArg.append(" form_usrId[").append(account.getUsr_id()).append("]");
						    strArg.append(" form_hiddeData[N]");// ---> Default
						    strArg.append(" form_level[(6)]");// ---> Default (ex - (1,2,3,4,5))
						    strArg.append(" form_remark[]");// ---> Default
						    strArg.append(" form_Cntr[1]");// ---> Default
						    strArg.append(" form_mainOnly[N]");// ---> Default
						    strArg.append(" form_CorrNo[]");// ---> Default
						    strArg.append(" form_his_cntr[BKG_CONTAINER]");// ---> Default
						    strArg.append(" form_his_bkg[BKG_BOOKING]");// ---> Default
						    strArg.append(" form_his_mkd[BKG_BL_MK_DESC]");// ---> Default
						    strArg.append(" form_his_xpt[BKG_XPT_IMP_LIC]");// ---> Default
						    strArg.append(" form_his_bl[BKG_BL_DOC]");// ---> Default
						    strArg.append(" /rp []");// ---> Default
						    strArg.append(" /riprnmargin");
							
							
							log.debug("---------- strArg "+ strArg);
							log.debug("------- O/B BL을 첨부하여 메일을 발송합니다.");
							//rdVO.setXptFileNm("ESM_BKG_0109_OBL_A4.pdf");
							//파일명 : OBL_BLNO.pdf
							rdVO.setXptFileNm("OBL_" +listVO.getBlNo() +".pdf");
							rdVO.setXptFileTpCd(ExportInfo.FTYPE_PDF); //pdf 생성.
							rdVO.setRdTmpltNm("ESM_BKG_0109_OBL_A4.mrd");
							rdVO.setRdParaCtnt(strArg.toString());
							
							rdVOs.add(rdVO);
						}
						
						//실제 메일 발송
						//2009.09.22 메일이 발송이 안됨으로 RD 만 발송하도록 임시 조처
						log.debug("------------------ 실제 메일 발송 ");
						mailInfo.setComRptDsgnXptInfoVOs(rdVOs);
						//retEmlSndId.add(eai.sendReportDesignerWithFiles(mailInfo, rdVOs));
						//mailInfo.setRdExportVOs(rdVOs);
						
						mailInfos.add(mailInfo);
					}
					
				}
			}

			List<String> retEmlSndId = new ArrayList<String>();
			
			retEmlSndId = eaiDao.sendEmailGroupRDWithFiles(mailInfos);
			
			int y =0;//mail send id 만큼 증가할 변수
			for (int i = 0; i < arrNtcSendListVos.length; i++) {
				ArrNtcSendListVO listVO = arrNtcSendListVos[i];
				//log.debug("--------------------------- listVO "+listVO);
				//CHK 가 선택되어있을경우만 실행
				if(listVO.getChkEmail().equals("1")){	
					// Model-6(Detail 수정)
					BkgArrNtcDtlVO dtlVO = new BkgArrNtcDtlVO();
					
					//보낼 메일 주소(플래그가 있는경우만
					Vector<String> rcvMailInfo = new Vector<String>();
					
					//Cust cntc Tp cd 값
					Vector<String> vCustCntcTpCd = new Vector<String>();
					//전체 Email , 저장용으로 사용
					Vector<String> vNtcEml = new Vector<String>();
					vNtcEml.add(listVO.getNtcEml1());
					vNtcEml.add(listVO.getNtcEml2());
					vNtcEml.add(listVO.getNtcEml3());
					vNtcEml.add(listVO.getNtcEml4());
					vNtcEml.add(listVO.getNtcEml5());
					
					//@ 2016.01.15 Arrival Notice Send - 셋업된 Also Notify에 한해 2군데까지 A/notice 전송 기능 개발
					vNtcEml.add(listVO.getNtcEml6());
					vNtcEml.add(listVO.getNtcEml7());
					//메일체크, 플래그
					Vector<String> vEmlEvntFlg = new Vector<String>();
					vEmlEvntFlg.add(listVO.getEmlEvntFlg1());
					vEmlEvntFlg.add(listVO.getEmlEvntFlg2());
					vEmlEvntFlg.add(listVO.getEmlEvntFlg3());
					vEmlEvntFlg.add(listVO.getEmlEvntFlg4());
					vEmlEvntFlg.add(listVO.getEmlEvntFlg5());
					
					//@ 2016.01.15 Arrival Notice Send - 셋업된 Also Notify에 한해 2군데까지 A/notice 전송 기능 개발
					vEmlEvntFlg.add(listVO.getEmlEvntFlg6());
					vEmlEvntFlg.add(listVO.getEmlEvntFlg7());
					
					
					for (int x = 0; x < arrCustCntcTpCd.length; x++) {
						dtlVO.setBkgNo(listVO.getBkgNo());
						dtlVO.setBkgCustTpCd(listVO.getBkgCustTpCd());
						dtlVO.setCustCntcTpCd(arrCustCntcTpCd[x]);					
						dtlVO.setNtcEml(""+vNtcEml.get(x));
						dtlVO.setEmlEvntFlg(""+vEmlEvntFlg.get(x));
						dtlVO.setEmlTpCd("M");
                        dtlVO.setEmlSndUsrId(account.getUsr_id());
                        
                        
						
						log.debug("-------------------- vEmlEvntFlg.get(x) " + x + "   :   "+vEmlEvntFlg.get(x));
						if(vEmlEvntFlg.get(x).equals("1")){
						
							rcvMailInfo.add(vNtcEml.get(x));
							vCustCntcTpCd.add(arrCustCntcTpCd[x]);
						}
						
					}		
					
					
					log.debug("------------ retEmlSndId.size() "+retEmlSndId.size());
					
					//테스트 로직
					for(int xx=0;xx<retEmlSndId.size();xx++){
						log.debug("-------------- retEmlSndId "+ xx + "    "+retEmlSndId.get(xx));
						if(retEmlSndId.get(xx) == null){
							retEmlSndId.set(xx,"NO SND NO");
						}
					}
					
					
					for (int x = 0; x < arrCustCntcTpCd.length; x++) {				
						dtlVO.setCustCntcTpCd(arrCustCntcTpCd[x]);		
						//log.debug("------------ 11111111111");
						//log.debug("-------------------- vEmlEvntFlg.get(x) "+vEmlEvntFlg.get(x));
						if(vEmlEvntFlg.get(x).equals("1")){
							//log.debug("------------ 222222222");
							//Mail 전송후 Send Id 를 업데이트
							log.debug("---------------Mail 전송후 Send Id 를 업데이트");
							log.debug("-------- bkg_no  "+dtlVO.getBkgNo());
							log.debug("-------- bkg_cust_tp_cd  "+dtlVO.getBkgCustTpCd());
							log.debug("-------- cust_cnt_tp_cd  "+dtlVO.getCustCntcTpCd());
							log.debug("-------- retEmlSndId.get(y)  "+retEmlSndId.get(y));
							dtlVO.setEmlNtcSndId(retEmlSndId.get(y));
							//log.debug("------------ 33333");
							dbDao.modifyArrNtcSendIdByMail(dtlVO, account);
							//log.debug("------------ 444444444444");
							y = y + 1;
						}
						
					}
					
					
					// Email 에서 받아온 값을 VO 에 담가라
					for(int q=0;q<rcvMailInfo.size();q++){				
						BkgNtcHisVO hisVO = new BkgNtcHisVO();
						hisVO.setNtcViaCd("M");
						hisVO.setSndId(retEmlSndId.get(q));
						hisVO.setSndOfcCd(account.getOfc_cd());
						hisVO.setSndUsrId(account.getUsr_id());
						hisVO.setCreUsrId(account.getUsr_id());
						hisVO.setUpdUsrId(account.getUsr_id());
						hisVO.setBkgNo(listVO.getBkgNo());
						hisVO.setBkgCustTpCd(listVO.getBkgCustTpCd());
						hisVO.setCustCntcTpCd(vCustCntcTpCd.get(q));
						
						log.debug("--------------listVO.getBkgNo()  "+ listVO.getBkgNo());
						
						log.debug("--------------listVO.getBkgCustTpCd()  "+ listVO.getBkgCustTpCd());
						
						// Model-9
						//History 업데이트
						hisVOS.add(dbDao.searchArrNtcHistory(hisVO));
					}
					
				}
			}

		}catch (EventException de) {
            // BKG00450 : 조회에 실패했습니다.
			log.error("err " + de.toString(), de);
            throw de;
        }catch (DAOException de) {
            log.error("err " + de.toString(), de);
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }

		return hisVOS;
		
	}

	/** [0956] Hold Remark 조회<br>
	 * podCd 값에 따른 분기
	 * @param String bkgNo
	 * @return List<BkgArrNtcCntrVO>
	 * @exception EventException
	 */
	public List<BkgArrNtcCntrVO> searchArrNtcHldRmk (String bkgNo) throws EventException {
		// TODO Auto-generated method stub
		
		List<BkgArrNtcCntrVO> retList = null;
		try {
		retList= dbDao.searchArrNtcHldRmk (bkgNo);
		
		}catch (DAOException de) {
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		return retList;
	}
	/**
	 * [0956] Hold Remark 저장<br>
	 * @param BkgArrNtcCntrVO[] vos
	 * @param SignOnUserAccount account
	 * @exception EventException 
	 */
	public void setupArrNtcHldRmk (BkgArrNtcCntrVO[] bkgArrNtcCntrVos, SignOnUserAccount account) throws EventException {
		
		try {
			for (int i = 0; i < bkgArrNtcCntrVos.length; i++) {
				BkgArrNtcCntrVO vo = bkgArrNtcCntrVos[i];								
				if(dbDao.modifyArrNtcHldRmk (vo,account) == 0){
					dbDao.addArrNtcHldRmk(vo,account);
				}
				
			}
		}catch (DAOException de) {
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
	}
	
	/** [0946] Group A/N Merge Pop-up 조회
	 * Group A/N Merge Pop-up
	 * @param ArrNtcGrpSendListVO vo
	 * @return List<ArrNtcGrpSendListVO>
	 * @exception EventException
	 */
	public List<ArrNtcGrpSendListVO> searchArrNtcGrpSendList(ArrNtcGrpSendListVO vo)
			throws EventException {
		// TODO Auto-generated method stub
		
		List<ArrNtcGrpSendListVO> retList = null;
		try {
			//log.debug("------------------- vo " + vo.getColumnValues());
			retList = dbDao.searchArrNtcGrpSendList(vo);

		}catch (DAOException de) {
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		return retList;
	}
	
	/**
	 * [0946] fax Group Arrival Notice 전송
	 * @param ArrNtcGrpSendVO grpSendVO
	 * @param ArrNtcGrpSendListVO[] arrNtcGrpSendLists
	 * @param SignOnUserAccount account
	 * @param Vector vFaxNo
	 * @return List<BkgNtcHisVO>
	 * @exception EventException 
	 */
	public List<BkgNtcHisVO> sendArrNtcByGrpFax(ArrNtcGrpSendVO grpSendVO,ArrNtcGrpSendListVO[] arrNtcGrpSendLists
			,SignOnUserAccount account,Vector vFaxNo) throws EventException{
			
		List<BkgNtcHisVO> hisVOS = new ArrayList<BkgNtcHisVO>();
		String[] arrCustCntcTpCd = new String[] { "C1", "C2", "B1", "B2", "A1", "A2", "AN"};
		String divCd = grpSendVO.getDivCd();//Combine 인지 Separate 인지를 구별
		
		//필요한 정보들을 List에서 꺼냄
		//0번 배열을 이용함. 차후 변경할수도 있음.
		//ArrNtcGrpSendListVO tmpVO = (ArrNtcGrpSendListVO)arrNtcGrpSendLists[0];


		try{
			
			//Model 8,9 ; 번호를 구하여, Insert 실행
//			String grpNtcSeq = dbDao.searchArrGrpNtcNextSeq();
//			BkgGrpArrNtcVO bkgGrpArrNtc = new BkgGrpArrNtcVO();
//			bkgGrpArrNtc.setGrpNtcSeq(grpNtcSeq);
//			dbDao.addArrGrpNtcByNextSeq(bkgGrpArrNtc , account);
			
			//데이터 저장
			//메일정보 가져오기
			//String[] arrEmlNo = new String[arrCustCntcTpCd.length] ;//eml 번호를 저장하기 위함.
			//Vector<String> rcvMailInfo = new Vector<String>();//수신 fax 주소
			
			BkgArrNtcDtlVO arrNtcDtls = new BkgArrNtcDtlVO();

			String custNm = "";
			String bkgNoStr = "";
			//String diffRmk = grpSendVO.getDiffRmk();
			String orgBkgNo = grpSendVO.getBkgNo();//대표 bkg_no
			
			
			/*
			 * 그룹메일 전송시 charge 부분은 표기되게 세팅됨.
			 */
//			String a1ChgFlg = "0";
//			String a2ChgFlg = "0";
//			
//			if(vFaxNo != null && vFaxNo.size() >= 7 ){
//				a1ChgFlg = (String)vFaxNo.get(7);
//			}
//			if(vFaxNo != null && vFaxNo.size() >= 8 ){
//				a2ChgFlg = (String)vFaxNo.get(8);
//			}
			
			//-----------------------------------------------------
			// Combine 일경우			
			//-----------------------------------------------------
			if(divCd.equals("C")){
				ArrNtcGrpSendListVO arrGrpSendList = new ArrNtcGrpSendListVO();
				
				StringBuffer bkgNoStrBf = new StringBuffer();
				//bkg_no 의 리스트를 구하기
				for(int j=0;j<arrNtcGrpSendLists.length;j++){
					arrGrpSendList = arrNtcGrpSendLists[j];
					custNm = arrGrpSendList.getCustNm();
					bkgNoStrBf.append("'").append(arrGrpSendList.getBkgNo()).append( "'");
					if(j != (arrNtcGrpSendLists.length-1) ){
						bkgNoStrBf.append(",");
					}
				}
					
				bkgNoStr = bkgNoStrBf.toString();
				
				//group 전송을 위해 	arrNtcGrpSendLists 의 반복이 필요하니 주의할것 !!!
				for(int j=0;j<arrNtcGrpSendLists.length;j++){
					arrGrpSendList = arrNtcGrpSendLists[j];	
					for(int i=0;i<arrCustCntcTpCd.length;i++){
						String[] flagFax = (vFaxNo.get(i).toString()).split("\\|");//가져온 FAX의 check와 FAX
					
						arrNtcDtls.setBkgNo(arrGrpSendList.getBkgNo());
						arrNtcDtls.setBkgCustTpCd(arrGrpSendList.getBkgCustTpCd());
						arrNtcDtls.setCustCntcTpCd(arrCustCntcTpCd[i]);		
						//arrNtcDtls.setEmlTpCd("M");
						arrNtcDtls.setFaxTpCd("F");
						
				
						if(flagFax[0].equals("1") && flagFax.length > 1){//체크되었으므로 메일발송대상
							String faxNo = flagFax[1];						
							//arrNtcDtls.setNtcEml(flagFax[1]);//보낼 faxno을 설정 , faxno의 값이 없어서 array 오류가 날수 있음.(split에서)
							arrNtcDtls.setFaxNo(faxNo);						
							arrNtcDtls.setFaxSndUsrId(account.getUsr_id());
							 
							arrNtcDtls.setCreUsrId(account.getUsr_id());
							arrNtcDtls.setUpdUsrId(account.getUsr_id());
							//Model 10. Customer 정보를 수정및 추가한다. (arrival notice Detail 에다가 넣어라)
							//dbDao.mergeArrNtcDtl(arrNtcDtls,account);
							// Detail 수정실행
												
							int modResult = dbDao.modifyArrNtcDtlByFax(arrNtcDtls, account);
							if(modResult == 0){
								dbDao.addArrNtcDtlByFax(arrNtcDtls, account);
							}
					
							List<FaxSendVO> faxInfos = new ArrayList<FaxSendVO>();
	
							FaxSendVO faxInfo = new FaxSendVO();
							faxInfo.setSysCd("BKG");
							//mailInfo.setTmplMrd("WO_NORMAL.mrd");
							
	
							faxInfo.setBatchFlg("N");
							
							ArrNtcMrdSearchVO arrNtcMrdSearch = new ArrNtcMrdSearchVO();
							//------------------------------------
							//MRD 관련 정보를 구하기  Start 
							//------------------------------------
							arrNtcMrdSearch.setBkgNo(orgBkgNo);
							arrNtcMrdSearch.setUsrId(account.getUsr_id());
							arrNtcMrdSearch.setOfcCd(account.getOfc_cd());
							
							ArrNtcMrdVO mrdVO = this.searchArrNtcMrdId(arrNtcMrdSearch);
							log.error("ERR Log arrNtcMrdSearch : " + arrNtcMrdSearch);
							log.error("ERR Log mrdVO : " + mrdVO);
							String eclzBlCpyFlg = mrdVO.getEclzBlCpyFlg();
							
							
							//------------------------------------
							//MRD 관련 정보를 구하기  End
							//------------------------------------
							String strArg = "/rv ";
							
							
							
								
							faxInfo.setTmplMrd("ESM_BKG_0918.mrd");
							faxInfo.setBatchFlg("N");
							faxInfo.setTitle("Group Arrival Notice Send(Combine)"); //제목
							
							strArg = strArg + " form_bkgNo[(" + bkgNoStr + ")]";
							strArg = strArg + " form_usrId['" + account.getUsr_id() + "']";
							strArg = strArg + " form_loclFlg['Y']";
							strArg = strArg + " form_tsFlg['" + arrNtcGrpSendLists[0].getTsFlg() + "']";
							strArg = strArg + " form_rvisFlg['" + arrNtcGrpSendLists[0].getRvisFlg()+ "']";
							strArg = strArg + " form_usrTo['"      +arrNtcGrpSendLists[0].getCustNm() +   "']";
							strArg = strArg + " form_remarkCtnt['']";
							strArg = strArg + " form_ofcCd['" + account.getOfc_cd() + "']";	
								
							
							
							
							strArg = strArg.trim();
							log.debug("----------- strArg "+strArg );
							
							faxInfo.setTmplParam(strArg); //
							
							faxInfo.setRcvInfo(custNm + ";" + faxNo);
							faxInfo.setOffice(account.getOfc_cd());
							faxInfo.setCrtUserId(account.getUsr_id());
							
							faxInfos.add(faxInfo);
							
							
							//O B/L 추가 발송
							
							if(eclzBlCpyFlg.equals("Y")){
								
								String strArgObl = "/rv ";
								
								strArgObl = strArgObl + " form_bkgNo[(" + bkgNoStr + ")]";
								strArgObl = strArgObl + " form_type[2]";// ---> Default
								strArgObl = strArgObl + " form_dataOnly[N]";// ---> Default
							    strArgObl = strArgObl + " form_manifest[N]";// ---> Default
							    strArgObl = strArgObl + " form_usrId[" + account.getUsr_id() + "]";
							    strArgObl = strArgObl + " form_hiddeData[N]";// ---> Default
							    strArgObl = strArgObl + " form_level[(6)]";// ---> Default (ex - (1,2,3,4,5))
							    strArgObl = strArgObl + " form_remark[]";// ---> Default
							    strArgObl = strArgObl + " form_Cntr[1]";// ---> Default
							    strArgObl = strArgObl + " form_mainOnly[N]";// ---> Default
							    strArgObl = strArgObl + " form_CorrNo[]";// ---> Default
							    strArgObl = strArgObl + " form_his_cntr[BKG_CONTAINER]";// ---> Default
							    strArgObl = strArgObl + " form_his_bkg[BKG_BOOKING]";// ---> Default
							    strArgObl = strArgObl + " form_his_mkd[BKG_BL_MK_DESC]";// ---> Default
							    strArgObl = strArgObl + " form_his_xpt[BKG_XPT_IMP_LIC]";// ---> Default
							    strArgObl = strArgObl + " form_his_bl[BKG_BL_DOC]";// ---> Default
							    strArgObl = strArgObl + " /rp []";// ---> Default
							    strArgObl = strArgObl + " /riprnmargin";
							    
							    strArgObl = strArgObl.trim();
								
								
								log.debug("---------- strArg "+ strArg);
								log.debug("------- O/B BL을 첨부하여 FAX를 발송합니다.");
								
								FaxSendVO faxInfoObl = new FaxSendVO();
								
								faxInfoObl.setSysCd("BKG");
								faxInfoObl.setTmplMrd("ESM_BKG_0109_OBL_A4.mrd");
	
								faxInfoObl.setBatchFlg("N");
								faxInfoObl.setTitle("O B/L(Combine)"+arrGrpSendList.getBkgNo());
								
								faxInfoObl.setTmplParam(strArg); // RD 에 넘어갈 Parameter 값을 설정한다.
								faxInfoObl.setRcvInfo(custNm + ";" + faxNo);// fax_no 를 , 로 연결한 문자열
								faxInfoObl.setOffice(account.getOfc_cd());
								faxInfoObl.setCrtUserId("SMLINE INBOUND DEPT");
								
								log.debug("------- O/B BL을 첨부하여 FAX를 발송 시작");
								faxInfos.add(faxInfoObl);
								//eai.sendFax(faxInfoObl);
								log.debug("------- O/B BL을 첨부하여 FAX를 발송 끝");
	
							}
							
							
							//fax 발송
							//-----------------------------------------
							//Fax 실제 발송
							//-----------------------------------------
							log.debug("------------------------------");
							log.debug(" FAX 실제 발송     faxInfos.size() "+ faxInfos.size());
							log.debug("------------------------------");
							
							List<String> retFaxSndId = eaiDao.sendFax(faxInfos);
							log.debug("----------- retFaxSndId "+retFaxSndId);
							
							
							
							
							log.debug("--------------group fax bkg_no "+arrGrpSendList.getBkgNo());
							log.debug("----------------group fax bl_no "+arrGrpSendList.getBlNo());
							arrNtcDtls.setBkgNo(arrGrpSendList.getBkgNo());
							arrNtcDtls.setFaxNtcSndId(retFaxSndId.get(0));		
							arrNtcDtls.setCustCntcTpCd(arrCustCntcTpCd[i]);						
							dbDao.modifyArrNtcSendIdByFax(arrNtcDtls, account);
							
						
							
							//----------------------------------------------------------
							BkgNtcHisVO hisVO = new BkgNtcHisVO();
							hisVO.setNtcViaCd("F");
							hisVO.setSndId(retFaxSndId.get(0));
							hisVO.setSndOfcCd(account.getOfc_cd());
							hisVO.setSndUsrId(account.getUsr_id());
							hisVO.setCreUsrId(account.getUsr_id());
							hisVO.setUpdUsrId(account.getUsr_id());
							hisVO.setBkgNo(arrGrpSendList.getBkgNo());
							hisVO.setBkgCustTpCd(arrNtcDtls.getBkgCustTpCd());
							hisVO.setCustCntcTpCd(arrCustCntcTpCd[i]);
							
							
							
							// Model-9
							//History 업데이트
							hisVOS.add(dbDao.searchArrNtcHistory(hisVO));
							
							//----------------------------------------------------------
					
						}
					}
				}
			}
			//-----------------------------------------------------
			// Separate 일경우			
			//-----------------------------------------------------
			else if(divCd.equals("S")){
				for(int j=0;j<arrNtcGrpSendLists.length;j++){
					ArrNtcGrpSendListVO arrGrpSendList = (ArrNtcGrpSendListVO)arrNtcGrpSendLists[j];
					custNm = arrGrpSendList.getCustNm();
					
					
					//0|   ,1|sackso@nate.com      ,0|     ,0|     ,0|    ,
					//log.debug("-------------- vEmail "+vEmail.get(i).toString());
					
					
					for(int i=0;i<arrCustCntcTpCd.length;i++){
						String[] flagFax = (vFaxNo.get(i).toString()).split("\\|");//가져온 FAX의 check와 FAX
					
						arrNtcDtls.setBkgNo(arrGrpSendList.getBkgNo());
						arrNtcDtls.setBkgCustTpCd(arrGrpSendList.getBkgCustTpCd());
						arrNtcDtls.setCustCntcTpCd(arrCustCntcTpCd[i]);	
						
						arrNtcDtls.setFaxTpCd("F");
						
				
						if(flagFax[0].equals("1") && flagFax.length > 1){//체크되었으므로 메일발송대상
							String faxNo = flagFax[1];						
							//arrNtcDtls.setNtcEml(flagFax[1]);//보낼 faxno을 설정 , faxno의 값이 없어서 array 오류가 날수 있음.(split에서)
							arrNtcDtls.setFaxNo(faxNo);						
							arrNtcDtls.setFaxSndUsrId(account.getUsr_id());							 
							arrNtcDtls.setCreUsrId(account.getUsr_id());
							arrNtcDtls.setUpdUsrId(account.getUsr_id());
							//Model 10. Customer 정보를 수정및 추가한다. (arrival notice Detail 에다가 넣어라)
							//dbDao.mergeArrNtcDtl(arrNtcDtls,account);
							// Detail 수정실행
												
							int modResult = dbDao.modifyArrNtcDtlByFax(arrNtcDtls, account);
							if(modResult == 0){
								dbDao.addArrNtcDtlByFax(arrNtcDtls, account);
							}
					
							List<FaxSendVO> faxInfos = new ArrayList<FaxSendVO>();
	
							FaxSendVO faxInfo = new FaxSendVO();
							faxInfo.setSysCd("BKG");
							//mailInfo.setTmplMrd("WO_NORMAL.mrd");
							
	
							faxInfo.setBatchFlg("N");
							String eclzBlCpyFlg = "";
							String strArg = "/rv ";
							
							
							
							ArrNtcMrdSearchVO arrNtcMrdSearch = new ArrNtcMrdSearchVO();
							
							//------------------------------------
							//MRD 관련 정보를 구하기  Start 
							//------------------------------------
							arrNtcMrdSearch.setBkgNo(arrGrpSendList.getBkgNo());
							arrNtcMrdSearch.setUsrId(account.getUsr_id());
							arrNtcMrdSearch.setOfcCd(account.getOfc_cd());
							
							ArrNtcMrdVO mrdVO = this.searchArrNtcMrdId(arrNtcMrdSearch);
							String mrdId = mrdVO.getMrdId();
							String loclLangFlg = mrdVO.getLoclLangFlg();
							eclzBlCpyFlg = mrdVO.getEclzBlCpyFlg();
							String comParam = mrdVO.getComParam();
							
							//------------------------------------
							//MRD 관련 정보를 구하기  End
							//------------------------------------					
							
							faxInfo.setTmplMrd(mrdId + ".mrd");
							faxInfo.setBatchFlg("N");
							faxInfo.setTitle("Group Arrival Notice Send(Separate)"); //제목
							                                                                                                 
							strArg = strArg + " form_bkgNo[('" + arrGrpSendList.getBkgNo() + "')]";
							strArg = strArg + " form_usrId['" + account.getUsr_id() + "']";
							strArg = strArg + " form_loclFlg['" + loclLangFlg + "']";
							strArg = strArg + " form_tsFlg['" + arrGrpSendList.getTsFlg() + "']";
							
							//@ A1,A2에 대해 chage_flag를 별도 세팅해야 하므로 Send 상세 정보를 이용한다.. 2016.02.26
//							strArg = strArg + " form_chgDpFlg['4']";
							if("A1".equals(arrCustCntcTpCd[i]) || "A2".equals(arrCustCntcTpCd[i])){
								strArg = strArg + " form_chgDpFlg['0']";		
							}else{
								strArg = strArg + " form_chgDpFlg['4']";
							}
							
							
							strArg = strArg + " form_remarkCtnt['']";
							strArg = strArg + " form_ofcCd['" + account.getOfc_cd() + "']";
							
							strArg = strArg + " "+comParam;
							
							//2010-03-29 by sungho Arial Unicode Font 사용 시 글자의 윗부분이 잘리는 현상을 해결
							//strArg = strArg + " /rfonttype40";
								
							
							
							strArg = strArg.trim();
							log.debug("----------- strArg "+strArg );
							
							faxInfo.setTmplParam(strArg); //
							
							faxInfo.setRcvInfo(custNm + ";" + faxNo);
							faxInfo.setOffice(account.getOfc_cd());
							faxInfo.setCrtUserId(account.getUsr_id());
							
							faxInfos.add(faxInfo);
							
							
							//O B/L 추가 발송
							
							if(eclzBlCpyFlg.equals("Y")){
								
								String strArgObl = "/rv ";
								
								strArgObl = strArgObl + " form_bkgNo[('" + arrGrpSendList.getBkgNo() + "')]";
								strArgObl = strArgObl + " form_type[2]";// ---> Default
								strArgObl = strArgObl + " form_dataOnly[N]";// ---> Default
							    strArgObl = strArgObl + " form_manifest[N]";// ---> Default
							    strArgObl = strArgObl + " form_usrId[" + account.getUsr_id() + "]";
							    strArgObl = strArgObl + " form_hiddeData[N]";// ---> Default
							    strArgObl = strArgObl + " form_level[(6)]";// ---> Default (ex - (1,2,3,4,5))
							    strArgObl = strArgObl + " form_remark[]";// ---> Default
							    strArgObl = strArgObl + " form_Cntr[1]";// ---> Default
							    strArgObl = strArgObl + " form_mainOnly[N]";// ---> Default
							    strArgObl = strArgObl + " form_CorrNo[]";// ---> Default
							    strArgObl = strArgObl + " form_his_cntr[BKG_CONTAINER]";// ---> Default
							    strArgObl = strArgObl + " form_his_bkg[BKG_BOOKING]";// ---> Default
							    strArgObl = strArgObl + " form_his_mkd[BKG_BL_MK_DESC]";// ---> Default
							    strArgObl = strArgObl + " form_his_xpt[BKG_XPT_IMP_LIC]";// ---> Default
							    strArgObl = strArgObl + " form_his_bl[BKG_BL_DOC]";// ---> Default
							    strArgObl = strArgObl + " /rp []";// ---> Default
							    strArgObl = strArgObl + " /riprnmargin";
							    
							    strArgObl = strArgObl.trim();
								
								
								log.debug("---------- strArg "+ strArg);
								log.debug("------- O/B BL을 첨부하여 FAX를 발송합니다.");
								
								FaxSendVO faxInfoObl = new FaxSendVO();
								
								faxInfoObl.setSysCd("BKG");
								faxInfoObl.setTmplMrd("ESM_BKG_0109_OBL_A4.mrd");
	
								faxInfoObl.setBatchFlg("N");
								faxInfoObl.setTitle("O B/L(Separate)" + arrGrpSendList.getBkgNo());
								
								faxInfoObl.setTmplParam(strArg); // RD 에 넘어갈 Parameter 값을 설정한다.
								faxInfoObl.setRcvInfo(custNm + ";" + faxNo);// fax_no 를 , 로 연결한 문자열
								faxInfoObl.setOffice(account.getOfc_cd());
								faxInfoObl.setCrtUserId("SMLINE INBOUND DEPT");
								
								log.debug("------- O/B BL을 첨부하여 FAX를 발송 시작");
								faxInfos.add(faxInfoObl);
								//eai.sendFax(faxInfoObl);
								log.debug("------- O/B BL을 첨부하여 FAX를 발송 끝");
	
							}
							
							
							//fax 발송
							//-----------------------------------------
							//Fax 실제 발송
							//-----------------------------------------
							log.debug("------------------------------");
							log.debug(" FAX 실제 발송     faxInfos.size() "+ faxInfos.size());
							log.debug("------------------------------");
							
							List<String> retFaxSndId = eaiDao.sendFax(faxInfos);
							log.debug("----------- retFaxSndId "+retFaxSndId);
							
							
							
							
						
							arrNtcDtls.setBkgNo(arrGrpSendList.getBkgNo());
							arrNtcDtls.setFaxNtcSndId(retFaxSndId.get(0));		
							arrNtcDtls.setCustCntcTpCd(arrCustCntcTpCd[i]);						
							dbDao.modifyArrNtcSendIdByFax(arrNtcDtls, account);
							
						
							
							//----------------------------------------------------------
							BkgNtcHisVO hisVO = new BkgNtcHisVO();
							hisVO.setNtcViaCd("F");
							hisVO.setSndId(retFaxSndId.get(0));
							hisVO.setSndOfcCd(account.getOfc_cd());
							hisVO.setSndUsrId(account.getUsr_id());
							hisVO.setCreUsrId(account.getUsr_id());
							hisVO.setUpdUsrId(account.getUsr_id());
							hisVO.setBkgNo(arrGrpSendList.getBkgNo());
							hisVO.setBkgCustTpCd(arrNtcDtls.getBkgCustTpCd());
							hisVO.setCustCntcTpCd(arrCustCntcTpCd[i]);
							
							
							
							// Model-9
							//History 업데이트
							hisVOS.add(dbDao.searchArrNtcHistory(hisVO));
							
							//----------------------------------------------------------
					
						}
					}
				}
			
			
			}
			
			
			
			
			
			
			
			
		}catch (DAOException de) {
			log.error("err " + de.toString(), de);
            // BKG00450 : 조회에 실패했습니다.
			throw new EventException(new ErrorHandler("BKG00110",new String[]{de.getMessage()}).getMessage(), de);
        }catch (Exception de) {
            log.error("err " + de.toString(), de);
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00110",new String[]{de.getMessage()}).getMessage(), de);
        }
		
		return hisVOS;
	}
	/**
	 * [0946] EMail Group Arrival Notice를 전송한다.
	 * @param ArrNtcGrpSendVO grpSendVO
	 * @param ArrNtcGrpSendListVO[] arrNtcGrpSendLists
	 * @param SignOnUserAccount account
	 * @param Vector vEmail
	 * @return List<BkgNtcHisVO>
	 * @exception EventException 
	 */
	public List<BkgNtcHisVO> sendArrNtcByGrpEml(ArrNtcGrpSendVO grpSendVO,ArrNtcGrpSendListVO[] arrNtcGrpSendLists
			,SignOnUserAccount account,Vector vEmail) throws EventException{
		
		List<BkgNtcHisVO> hisVOS = new ArrayList<BkgNtcHisVO>();
		String[] arrCustCntcTpCd = new String[] { "C1", "C2", "B1", "B2", "A1", "A2", "AN" };
		ComUserVO comUserVO = null;
		
		/**************************************
		 * searchArrGrpNtcNextSeq.
		 * addArrGrpNtcByNextSeq.
		 * modifyArrNtcByGrpNtcSeq. 
		 **************************************/				
		
		//필요한 정보들을 List에서 꺼냄
		//0번 배열을 이용함. 차후 변경할수도 있음.
		try{						

			BkgArrNtcDtlVO arrNtcDtls = new BkgArrNtcDtlVO();
			
			String custNm = "";
			String bkgNoStr = "";
			String bkgNoStrOnly = "";
			
			//String diffRmk = grpSendVO.getDiffRmk();
			String orgBkgNo = grpSendVO.getBkgNo();//대표 bkg_no
			String divCd = grpSendVO.getDivCd();//Combine 인지 Separate 인지를 구별
			
			String scNo = "";
			String custCd = "";
			
			/*
			 * 그룹메일 전송시 charge 부분은 표기되게 세팅됨.
			 */
//			String a1ChgFlg = "0";
//			String a2ChgFlg = "0";
//			
//			if(vEmail != null && vEmail.size() >= 7 ){
//				a1ChgFlg = (String)vEmail.get(7);
//			}
//			if(vEmail != null && vEmail.size() >= 8 ){
//				a2ChgFlg = (String)vEmail.get(8);
//			}

			// 메일 Copy 정보 조회
			BookingUtil util = new BookingUtil();
			String copyEml = util.searchCcEmailAddrRSQL("AN", account.getUsr_id());

			// 수정  account.getUsr_Eml() -> getDfltEml()
			comUserVO = util.searchComUserInfo(account.getUsr_id());
			String sUsrEml = "";
			if (null!=comUserVO) {
				sUsrEml = (null==comUserVO.getDfltEml() || "".equals(comUserVO.getDfltEml())) ? comUserVO.getUsrEml() : comUserVO.getDfltEml();
			}
//			String sUsrEml = util.searchComUserInfo(account.getUsr_id()).getDfltEml();
			
			
			StringBuffer bkgNoStrBf = new StringBuffer();
			//---------------------------
			//1.   Arrival Notice Detail 수정
			//2.   0918 전송을 위한 bkg_no 의 연결
			//---------------------------
			for(int j=0;j<arrNtcGrpSendLists.length;j++){				
				ArrNtcGrpSendListVO arrGrpSendList = (ArrNtcGrpSendListVO)arrNtcGrpSendLists[j];
				scNo = arrGrpSendList.getScNo();
				custCd = arrGrpSendList.getCustCntCd() +""+ arrGrpSendList.getCustSeq();
				
				custNm = arrGrpSendList.getCustNm();
				
				bkgNoStrBf.append("'").append(arrGrpSendList.getBkgNo()).append( "'");
				bkgNoStrOnly = arrGrpSendList.getBkgNo();
				if(j != (arrNtcGrpSendLists.length-1) ){
					bkgNoStrBf.append(",");
				}
				
				bkgNoStr = bkgNoStrBf.toString();
				
				for(int i=0;i<arrCustCntcTpCd.length;i++){
					String[] flagEmail = (vEmail.get(i).toString()).split("\\|");//가져온 이메일의 check와 이메일
					//0|   ,1|sackso@nate.com      ,0|     ,0|     ,0|    ,
					//log.debug("-------------- vEmail "+vEmail.get(i).toString());
					
					
					
					arrNtcDtls.setBkgNo(arrGrpSendList.getBkgNo());
					arrNtcDtls.setBkgCustTpCd(arrGrpSendList.getBkgCustTpCd());
					arrNtcDtls.setCustCntcTpCd(arrCustCntcTpCd[i]);		
					arrNtcDtls.setEmlTpCd("M");
					
			
					if(flagEmail[0].equals("1") && flagEmail.length > 1){//체크되었으므로 메일발송대상
						//sendEmail.add(flagEmail[1]);//보낼 이메일							
						arrNtcDtls.setNtcEml(flagEmail[1]);//보낼 이메일을 설정 , 이메일의 값이 없어서 array 오류가 날수 있음.(split에서)
						arrNtcDtls.setEmlSndUsrId(account.getUsr_id());				
						//arrNtcDtls.setEmlSndFlg(""); 
						arrNtcDtls.setCreUsrId(account.getUsr_id());
						arrNtcDtls.setUpdUsrId(account.getUsr_id());						
						
						int modResult = dbDao.modifyArrNtcDtlByMail(arrNtcDtls, account);
						if(modResult == 0){
							dbDao.addArrNtcDtlByMail(arrNtcDtls, account);
						}
				
					}
				}
				//Bkg No 해당하는 항목에 bl 묶는 seq 값 update	
				//dbDao.modifyArrNtcByGrpNtcSeq(arrGrpSendList.getBkgNo(), grpNtcSeq);
			}
			
			
			//@ A1,A2에 대해 chage_flag를 별도 세팅해야 하므로 객체를 세팅한다. 2016.02.26
//			Vector<String> sendEmail = new Vector<String>();//메일 발송을 위함
			Vector<ArrNtcSendListVO> sendEmail = new Vector<ArrNtcSendListVO>();
			
			//---------------------------
			//3.   보낼 메일 주소들 리스트 작성.
			//---------------------------
			for(int i=0;i<arrCustCntcTpCd.length;i++){
				log.debug("------------ vEmail.get(i) "+vEmail.get(i));
				String[] flagEmail = (vEmail.get(i).toString()).split("\\|");//가져온 이메일의 check와 이메일
				if(flagEmail[0].equals("1") && flagEmail.length > 1){//체크되었으므로 메일발송대상					
//					sendEmail.add(flagEmail[1]);//보낼 이메일		
					
					//@ A1,A2에 대해 chage_flag를 별도 세팅해야 하므로 객체를 세팅한다. 2016.02.26
					ArrNtcSendListVO sendVO = new ArrNtcSendListVO();
					if("A1".equals(arrCustCntcTpCd[i]) || "A2".equals(arrCustCntcTpCd[i])){
						sendVO.setChgDpFlg("0");
					}else{
						//@ A1,A2 이외에는 Charge를 보여줌
						sendVO.setChgDpFlg("1");
					}
					sendVO.setCustCntcTpCd(arrCustCntcTpCd[i]);
					sendVO.setNtcEml(flagEmail[1]);
					sendEmail.add(sendVO);
				}			
			}
			
			// 발송인에게 해당  B/L에 대해 메일 Copy 본을 송신함 			
			if( !StringUtils.isBlank(copyEml) ){	
//				sendEmail.add(copyEml);
				//@ A1,A2에 대해 chage_flag를 별도 세팅해야 하므로 객체를 세팅한다. 2016.02.26
				ArrNtcSendListVO sendVO = new ArrNtcSendListVO();
				sendVO.setNtcEml(copyEml);
				sendEmail.add(sendVO);
			}
				
			
			RDMailSendVO[] mailInfos = new RDMailSendVO[sendEmail.size()];
			List<String> retEmlSndId = new ArrayList<String>();
			//log.debug("------------- sendEmail.size() "+sendEmail.size());
			//4.    보낼 메일 주소리스트를 이용하여, 메일 발송할 내역을 만든다.
			for(int x=0;x<sendEmail.size();x++){
			

				RDMailSendVO mailInfo = new RDMailSendVO();
				
				// RD Setting
				List<ComRptDsgnXptInfoVO> rdVOs = new ArrayList<ComRptDsgnXptInfoVO>();					
				
				ComRptDsgnXptInfoVO rdVO = new ComRptDsgnXptInfoVO();	
				rdVO.setCreUsrId(account.getUsr_id());
				rdVO.setUpdUsrId(account.getUsr_id());
				
				
				//---------------------------
				//2009.11.11 
				//Group Arrival Notice 시 
				// Combine 과  Separate 를 구별하여 RD 를 전송한다. 
				//---------------------------
				if(divCd.equals("C")){//Combine
					log.debug("------------ Combine 입니다.");
					
					rdVO.setXptFileNm("Group_AN_"+custCd+scNo    +".pdf");
					rdVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
					rdVO.setRdTmpltNm("ESM_BKG_0918.mrd");
					
					String strArg = "/rv ";
					strArg = strArg + " form_bkgNo[(" + bkgNoStr + ")]";
					strArg = strArg + " form_usrId['" + account.getUsr_id() + "']";
					strArg = strArg + " form_loclFlg['Y']";				
					strArg = strArg + " form_tsFlg['" + arrNtcGrpSendLists[0].getTsFlg()+ "']";
					
					strArg = strArg + " form_rvisFlg['" + arrNtcGrpSendLists[0].getRvisFlg()+ "']";
					strArg = strArg + " form_usrTo['"      +arrNtcGrpSendLists[0].getCustNm() +   "']";
					strArg = strArg + " form_remarkCtnt['']";
					strArg = strArg + " form_ofcCd['" + account.getOfc_cd() + "']";
					
					strArg = strArg.trim();
					log.debug("----------- strArg "+strArg );
					//rdVO.setReportparameters(strArg);
					rdVO.setRdParaCtnt(strArg);
					rdVOs.add(rdVO);
					
					
					ArrNtcMrdSearchVO arrNtcMrdSearch = new ArrNtcMrdSearchVO();
					
					//------------------------------------
					//MRD 관련 정보를 구하기  Start 
					//------------------------------------
					log.debug("--------------------------------");
					log.debug("MRD 관련 정보를 구하기  Start ");
					log.debug("--------------------------------");
					arrNtcMrdSearch.setBkgNo(orgBkgNo);
					arrNtcMrdSearch.setUsrId(account.getUsr_id());
					arrNtcMrdSearch.setOfcCd(account.getOfc_cd());
					
					ArrNtcMrdVO mrdVO = this.searchArrNtcMrdId(arrNtcMrdSearch);
					log.error("ERR Log arrNtcMrdSearch : " + arrNtcMrdSearch);
					log.error("ERR Log mrdVO : " + mrdVO);
					String eclzBlCpyFlg = mrdVO.getEclzBlCpyFlg();
					
					
					log.debug("--------------------------------");
					log.debug("MRD 관련 정보를 구하기  End ");
					log.debug("--------------------------------");
					
					
					//-------------------------------
					//리스트 만큼 돌면서 bkg 번호를 넣어  O B/L 발송 Start
					//-------------------------------
					
					for(int j=0;j<arrNtcGrpSendLists.length;j++){				
						ArrNtcGrpSendListVO arrGrpSendList = (ArrNtcGrpSendListVO)arrNtcGrpSendLists[j];
						custNm = arrGrpSendList.getCustNm();
						
						if(eclzBlCpyFlg.equals("Y")){
							rdVO = new ComRptDsgnXptInfoVO();	
							rdVO.setCreUsrId(account.getUsr_id());
							rdVO.setUpdUsrId(account.getUsr_id());
							strArg = "/rv ";
							
							strArg = strArg + " form_bkgNo[('" + arrGrpSendList.getBkgNo() + "')]";
						    strArg = strArg + " form_type[2]";// ---> Default
						    strArg = strArg + " form_dataOnly[N]";// ---> Default
						    strArg = strArg + " form_manifest[N]";// ---> Default
						    strArg = strArg + " form_usrId[" + account.getUsr_id() + "]";
						    strArg = strArg + " form_hiddeData[N]";// ---> Default
						    strArg = strArg + " form_level[(6)]";// ---> Default (ex - (1,2,3,4,5))
						    strArg = strArg + " form_remark[]";// ---> Default
						    strArg = strArg + " form_Cntr[1]";// ---> Default
						    strArg = strArg + " form_mainOnly[N]";// ---> Default
						    strArg = strArg + " form_CorrNo[]";// ---> Default
						    strArg = strArg + " form_his_cntr[BKG_CONTAINER]";// ---> Default
						    strArg = strArg + " form_his_bkg[BKG_BOOKING]";// ---> Default
						    strArg = strArg + " form_his_mkd[BKG_BL_MK_DESC]";// ---> Default
						    strArg = strArg + " form_his_xpt[BKG_XPT_IMP_LIC]";// ---> Default
						    strArg = strArg + " form_his_bl[BKG_BL_DOC]";// ---> Default
						    strArg = strArg + " /rp []";// ---> Default
						    strArg = strArg + " /riprnmargin";
							
							strArg = strArg.trim();
							log.debug("---------- strArg "+ strArg);
							log.debug("------- O/B BL을 첨부하여 메일을 발송합니다.");
							
							rdVO.setXptFileNm("OBL_" +arrGrpSendList.getBlNo() + ".pdf");
							rdVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
							rdVO.setRdTmpltNm("ESM_BKG_0109_OBL_A4.mrd");
							rdVO.setRdParaCtnt(strArg);
							
							log.debug("----------XXXXXXXXXXXX "+rdVO.getCreUsrId());
							
							rdVOs.add(rdVO);
						}
						
					}
					
					//-------------------------------
					//리스트 만큼 돌면서 bkg 번호를 넣어  O B/L 발송 End
					//-------------------------------		
					
				}else if(divCd.equals("S")){
					//-------------------------------
					//리스트 만큼 돌면서 bkg 번호를 넣어  O B/L 발송 Start
					//-------------------------------
					
					for(int j=0;j<arrNtcGrpSendLists.length;j++){				
						ArrNtcGrpSendListVO arrGrpSendList = (ArrNtcGrpSendListVO)arrNtcGrpSendLists[j];
						custNm = arrGrpSendList.getCustNm();
						
						//-------------------------------------
						//Separate 이면 돌려버린다. Start
						//-------------------------------------
						ArrNtcMrdSearchVO arrNtcMrdSearch = new ArrNtcMrdSearchVO();
						
						//------------------------------------
						//MRD 관련 정보를 구하기  Start 
						//------------------------------------
						log.debug("--------------------------------");
						log.debug("MRD 관련 정보를 구하기  Start ");
						log.debug("--------------------------------");
						arrNtcMrdSearch.setBkgNo(orgBkgNo);
						arrNtcMrdSearch.setUsrId(account.getUsr_id());
						arrNtcMrdSearch.setOfcCd(account.getOfc_cd());
						
						ArrNtcMrdVO mrdVO = this.searchArrNtcMrdId(arrNtcMrdSearch);
						String mrdId = mrdVO.getMrdId();
						String loclLangFlg = mrdVO.getLoclLangFlg();
						log.error("ERR Log arrNtcMrdSearch : " + arrNtcMrdSearch);
						log.error("ERR Log mrdVO : " + mrdVO);
						String eclzBlCpyFlg = mrdVO.getEclzBlCpyFlg();
						String comParam = mrdVO.getComParam();
						
						log.debug("--------------------------------");
						log.debug("MRD 관련 정보를 구하기  End ");
						log.debug("--------------------------------");
						//------------------------------------
						//MRD 관련 정보를 구하기  End
						//------------------------------------					
						
						rdVO = new ComRptDsgnXptInfoVO();
						rdVO.setCreUsrId(account.getUsr_id());
						rdVO.setUpdUsrId(account.getUsr_id());
						
						
						//rdVO.setXptFileNm(mrdId + ".pdf");
						rdVO.setXptFileNm("AN_"+ arrGrpSendList.getBlNo() + ".pdf");
						rdVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
						rdVO.setRdTmpltNm(mrdId + ".mrd");
						
						
						StringBuffer strArg = new StringBuffer("/rv ");                                                                                                 
						strArg.append(" form_bkgNo[(")  .append(bkgNoStr)                 .append(")]");
						strArg.append(" form_usrId['")  .append(account.getUsr_id())      .append("']");
						strArg.append(" form_loclFlg['").append(loclLangFlg)              .append("']");
						strArg.append(" form_tsFlg['")  .append(arrGrpSendList.getTsFlg()).append("']");
//						arrGrpSendList
						
						// 아래 2 Line 수정
						//@ A1,A2에 대해 chage_flag를 별도 세팅해야 하므로 Send 상세 정보를 이용한다.. 2016.02.26
						if( "A1".equals(sendEmail.get(x).getCustCntcTpCd()) || "A2".equals(sendEmail.get(x).getCustCntcTpCd())  ){
							strArg.append(" form_chgDpFlg['").append(sendEmail.get(x).getChgDpFlg()).append("']");		
						}else{
							strArg.append(" form_chgDpFlg['4']");
						}
						
						//strArg.append(" form_chgDpFlg['4']");
						strArg.append(" form_remarkCtnt['']");
						strArg.append(" form_ofcCd['")  .append( account.getOfc_cd())     .append("']");
						strArg.append(" ").append(comParam);
						
						//2010-03-29 by sungho Arial Unicode Font 사용 시 글자의 윗부분이 잘리는 현상을 해결
						//strArg = strArg + " /rfonttype40";
						
						log.debug("----------- strArg "+strArg.toString().trim() );
						rdVO.setRdParaCtnt(strArg.toString().trim());
						rdVOs.add(rdVO);
						
						//-------------------------------------
						//Separate 이면 돌려버린다. End
						//-------------------------------------
						
						if(eclzBlCpyFlg.equals("Y")){
							rdVO = new ComRptDsgnXptInfoVO();
							rdVO.setCreUsrId(account.getUsr_id());
							rdVO.setUpdUsrId(account.getUsr_id());
							
							
							strArg = new StringBuffer("/rv ");
							
							strArg.append(" form_bkgNo[('").append(arrGrpSendList.getBkgNo()).append("')]");
						    strArg.append(" form_type[2]");// ---> Default
						    strArg.append(" form_dataOnly[N]");// ---> Default
						    strArg.append(" form_manifest[N]");// ---> Default
						    strArg.append(" form_usrId[").append(account.getUsr_id()).append("]");
						    strArg.append(" form_hiddeData[N]");// ---> Default
						    strArg.append(" form_level[(6)]");// ---> Default (ex - (1,2,3,4,5))
						    strArg.append(" form_remark[]");// ---> Default
						    strArg.append(" form_Cntr[1]");// ---> Default
						    strArg.append(" form_mainOnly[N]");// ---> Default
						    strArg.append(" form_CorrNo[]");// ---> Default
						    strArg.append(" form_his_cntr[BKG_CONTAINER]");// ---> Default
						    strArg.append(" form_his_bkg[BKG_BOOKING]");// ---> Default
						    strArg.append(" form_his_mkd[BKG_BL_MK_DESC]");// ---> Default
						    strArg.append(" form_his_xpt[BKG_XPT_IMP_LIC]");// ---> Default
						    strArg.append(" form_his_bl[BKG_BL_DOC]");// ---> Default
						    strArg.append(" /rp []");// ---> Default
						    strArg.append(" /riprnmargin");
							 
							log.debug("---------- strArg "+ strArg.toString().trim());
							log.debug("------- O/B BL을 첨부하여 메일을 발송합니다.1111");
							//rdVO.setXptFileNm("ESM_BKG_0109_DBL(" +arrGrpSendList.getBkgNo() + ").pdf");
							rdVO.setXptFileNm("OBL_" +arrGrpSendList.getBlNo() + ".pdf");
							rdVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
							rdVO.setRdTmpltNm("ESM_BKG_0109_OBL_A4.mrd");
							rdVO.setRdParaCtnt(strArg.toString().trim());
							
							
							
							rdVOs.add(rdVO);
						}
						
					}
					
				}	

				mailInfo.setComRptDsgnXptInfoVOs(rdVOs);

				String [] arg = new String [2];
//				arg[0] = bkgNoStrOnly;
				String   bkgNoStrWithOutComma = bkgNoStr.replaceAll("'", "");
				arg[0] = bkgNoStrWithOutComma;
				StringBuilder[] content = util.getNotificationTemplated("AN", arg);
				
				mailInfo.setSndrNm("SM Line");
//				mailInfo.setSndrEml(account.getUsr_eml());
				mailInfo.setSndrEml(sUsrEml);
				mailInfo.setRcvrEml(sendEmail.get(x).getNtcEml());
				mailInfo.setRcvrNm(custNm);
				
				mailInfo.setEmlTitNm("[SM LINE] Your container(s) will arrive at POD soon");
//				String emlTitNm = "[SM Line Corporation] Your container(s) will arrive at POD soon_"+bkgNoStrWithOutComma;
//				if(emlTitNm.length() >= 250){
//					emlTitNm = emlTitNm.substring(0, 250) +"...";
//				}
//				mailInfo.setEmlTitNm(emlTitNm );
				
				//mailInfo.setTemplate("ESM_BKG_0381_01T.html");				
				mailInfo.setTextContent(content[1].toString());
				mailInfo.setUserId(account.getUsr_id());				
				HashMap<String, String> arguments = new HashMap<String, String>();
				arguments.put("rcvrNm", custNm);
				mailInfo.setArguments(arguments);		
				
				mailInfos[x] = mailInfo;				
				
				retEmlSndId.add(eaiDao.sendReportDesignerWithFiles(mailInfo,rdVOs));
			
			}
			
			//History 남기기
			for(int j=0;j<arrNtcGrpSendLists.length;j++){
				
				ArrNtcGrpSendListVO arrGrpSendList = (ArrNtcGrpSendListVO)arrNtcGrpSendLists[j];
				int y=0;
				for(int i=0;i<arrCustCntcTpCd.length;i++){
					String[] flagEmail = (vEmail.get(i).toString()).split("\\|");//가져온 이메일의 check와 이메일
					//0|   ,1|sackso@nate.com      ,0|     ,0|     ,0|    ,
					//log.debug("-------------- vEmail "+vEmail.get(i).toString());				
					
			
					if(flagEmail[0].equals("1") && flagEmail.length > 1){//체크되었으므로 메일발송대상		
						arrNtcDtls.setBkgNo(arrGrpSendList.getBkgNo());
						arrNtcDtls.setEmlNtcSndId(retEmlSndId.get(y));		
						arrNtcDtls.setCustCntcTpCd(arrCustCntcTpCd[i]);
						dbDao.modifyArrNtcSendIdByMail(arrNtcDtls, account);
						
					
						BkgNtcHisVO hisVO = new BkgNtcHisVO();
						hisVO.setNtcViaCd("M");
						hisVO.setSndId(retEmlSndId.get(y));
						hisVO.setSndOfcCd(account.getOfc_cd());
						hisVO.setSndUsrId(account.getUsr_id());
						hisVO.setCreUsrId(account.getUsr_id());
						hisVO.setUpdUsrId(account.getUsr_id());
						hisVO.setBkgNo(arrNtcDtls.getBkgNo());
						hisVO.setBkgCustTpCd(arrNtcDtls.getBkgCustTpCd());
						hisVO.setCustCntcTpCd(arrCustCntcTpCd[i]);
						
						//log.debug("--------------1818181 retEmlSndId  "+ retEmlSndId);
						
						// Model-9
						//History 업데이트
						hisVOS.add(dbDao.searchArrNtcHistory(hisVO));
					y = y + 1;
					}
				}
			}
		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), ex);
		}   
		
		return hisVOS;
	}
	
	/**
	 * MRD ID 를 구하기위함
	 * @param ArrNtcMrdSearchVO arrNtcMrdSearch
	 * @return ArrNtcMrdVO
	 * @exception DAOException
	 */
	public ArrNtcMrdVO searchArrNtcMrdId( ArrNtcMrdSearchVO arrNtcMrdSearch) throws EventException{
		ArrNtcMrdVO arrNtcMrdVo = new ArrNtcMrdVO();
		try{
			
			arrNtcMrdVo = dbDao.searchArrNtcMrdId(arrNtcMrdSearch);	
		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}       
       
        return arrNtcMrdVo;
	}

	/**
	 * 1099   Integrated Customer Data Update Setup 조회
	 * @param String ofcCd
	 * @return 
	 * @exception EventException
	 * @author Kwak youndBeom
	 */
	public BkgIbCustCntcStupVO searchIntgCustCntcUpdtStupInfoByOfc(String ofcCd) throws EventException
	{
		BkgIbCustCntcStupVO bkgIbCustCntcStupVO = null;
		try 
		{
			bkgIbCustCntcStupVO = dbDao.searchIntgCustCntcUpdtStupInfoByOfc(ofcCd);
        }catch (DAOException de) {
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		return bkgIbCustCntcStupVO;
	}
	
	/**
     * UI-BKG-1099 Integrated Customer Data Update Setup Master & History 저장
     * @author Kwak youndBeom
	 * @param BkgIbCustCntcStupVO bkgIbCustCntcStupVo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	
	public void manageIntgCustCntcUpdtStupInfoByOfc(BkgIbCustCntcStupVO bkgIbCustCntcStupVo, SignOnUserAccount account)throws EventException
	{
		int result = 0;
		BkgIbCustCntcStupHisVO bkgIbCustCntcStupHisVO = null;
		try 
		{
			
			bkgIbCustCntcStupVo.setCreUsrId(account.getUsr_id());
			bkgIbCustCntcStupVo.setUpdUsrId(account.getUsr_id());
			
			result = dbDao.modifyIntgCustCntcUpdtStupInfoByOfc(bkgIbCustCntcStupVo);
			if(result == 0)
			{
				dbDao.addIntgCustCntcUpdtStupInfoByOfc(bkgIbCustCntcStupVo);
			}
			
			bkgIbCustCntcStupHisVO = new BkgIbCustCntcStupHisVO();
			bkgIbCustCntcStupHisVO.setOfcCd(bkgIbCustCntcStupVo.getOfcCd());
			bkgIbCustCntcStupHisVO.setNewAutoUpdFlg(bkgIbCustCntcStupVo.getAutoUpdFlg());
			bkgIbCustCntcStupHisVO.setCngUsrId(bkgIbCustCntcStupVo.getUpdUsrId());
			bkgIbCustCntcStupHisVO.setCreUsrId(bkgIbCustCntcStupVo.getUpdUsrId());
			bkgIbCustCntcStupHisVO.setUpdUsrId(bkgIbCustCntcStupVo.getUpdUsrId());
			dbDao.addIntgCustCntcUpdtStupInfoHisByOfc(bkgIbCustCntcStupHisVO);
			
        }catch (DAOException de) {
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), ex);
        }
	}	
	
	 /**
	  * BackEndJob execute.
	  * 
	  * @param SignOnUserAccount account
	  * @param ArrNtcCustListVO[] arrNtcCustListVOS
	  * @param String pgmNo
	  * @return String
	  * @throws EventException
	  * 
	  */
	 public String startBackEndJob(SignOnUserAccount account, ArrNtcCustListVO[] arrNtcCustListVOS, String pgmNo )  throws EventException{
	  
	  String resultStr = "";
	  CustomerInfoSaveBackEndJob backEndJob = new CustomerInfoSaveBackEndJob();
	  backEndJob.setPgmNo(pgmNo);
	  backEndJob.setArrNtcCustListVOs(arrNtcCustListVOS);
	  backEndJob.setAccount(account);
	  BackEndJobManager backEndJobManager = new BackEndJobManager();
	  resultStr = backEndJobManager.execute(backEndJob , account.getUsr_id(), "A/N Customer Info save");
	 
	 return resultStr;
	 }


	 /**
	  * [0244] 조회
	  *
	  * @param BkgArrNtcAntfyVO bkgArrNtcAntfyVO
	  * @return List<BkgArrNtcAntfyVO>
	  * @throws EventException
	  *
	  */
	 public List<BkgArrNtcAntfyVO> seachAlsoNotify(BkgArrNtcAntfyVO bkgArrNtcAntfyVO) throws EventException{
		try{
			return dbDao.searchAlsoNotify(bkgArrNtcAntfyVO);
		}catch(DAOException ex){
			throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
		}

	}


	 /**
	  * [0244] 등록,수정,삭제 처리
	  *
	  * @param BkgArrNtcAntfyVO[] bkgArrNtcAntfyVOs
	  * @param SignOnUserAccount account
	  * @return BkgArrNtcAntfyVO
	  * @throws EventException
	  *
	  */
	 public BkgArrNtcAntfyVO setupAlsoNotify(BkgArrNtcAntfyVO[] bkgArrNtcAntfyVOs, SignOnUserAccount account) throws EventException {

		BkgArrNtcAntfyVO rtnVo = new BkgArrNtcAntfyVO();

		List<BkgArrNtcAntfyVO> insertVoList = new ArrayList<BkgArrNtcAntfyVO>();
		List<BkgArrNtcAntfyVO> updateVoList = new ArrayList<BkgArrNtcAntfyVO>();
		List<BkgArrNtcAntfyVO> deleteVoList = new ArrayList<BkgArrNtcAntfyVO>();

		try{

			for (int i = 0; i < bkgArrNtcAntfyVOs.length; i++ ) {

				BkgArrNtcAntfyVO a1Vo = new BkgArrNtcAntfyVO();
				BkgArrNtcAntfyVO a2Vo = new BkgArrNtcAntfyVO();

				if(bkgArrNtcAntfyVOs[i].getIbflag().equals("I")){

					//A1 데이터 셋팅
					a1Vo.setScNo(bkgArrNtcAntfyVOs[i].getScNo());
					a1Vo.setAntfyCustCd(bkgArrNtcAntfyVOs[i].getAntfyCustCd());
					a1Vo.setPodCd(bkgArrNtcAntfyVOs[i].getPodCd());
					a1Vo.setCustCntcTpCd("A1");
					a1Vo.setA1FaxNo(bkgArrNtcAntfyVOs[i].getA1FaxNo());
					a1Vo.setA1CntcEml(bkgArrNtcAntfyVOs[i].getA1CntcEml());
					a1Vo.setA2FaxNo(bkgArrNtcAntfyVOs[i].getA2FaxNo());
					a1Vo.setA2CntcEml(bkgArrNtcAntfyVOs[i].getA2CntcEml());
					a1Vo.setCreUsrId(account.getUsr_id());
					a1Vo.setUpdUsrId(account.getUsr_id());

					//A1 데이터 셋팅
					a2Vo.setScNo(bkgArrNtcAntfyVOs[i].getScNo());
					a2Vo.setAntfyCustCd(bkgArrNtcAntfyVOs[i].getAntfyCustCd());
					a2Vo.setPodCd(bkgArrNtcAntfyVOs[i].getPodCd());
					a2Vo.setCustCntcTpCd("A2");
					a2Vo.setA1FaxNo(bkgArrNtcAntfyVOs[i].getA1FaxNo());
					a2Vo.setA1CntcEml(bkgArrNtcAntfyVOs[i].getA1CntcEml());
					a2Vo.setA2FaxNo(bkgArrNtcAntfyVOs[i].getA2FaxNo());
					a2Vo.setA2CntcEml(bkgArrNtcAntfyVOs[i].getA2CntcEml());
					a2Vo.setCreUsrId(account.getUsr_id());
					a2Vo.setUpdUsrId(account.getUsr_id());

					//A1 데이터 셋팅(팩스, 이메일)
					if(!bkgArrNtcAntfyVOs[i].getA1CntcEml().equals("") || !bkgArrNtcAntfyVOs[i].getA1FaxNo().equals("")){
						a1Vo.setCntcEml(bkgArrNtcAntfyVOs[i].getA1CntcEml());
						a1Vo.setFaxNo(bkgArrNtcAntfyVOs[i].getA1FaxNo());
					}

					insertVoList.add(a1Vo);

					//A2 데이터 셋틷(팩스, 이메일)
					if(!bkgArrNtcAntfyVOs[i].getA2CntcEml().equals("") || !bkgArrNtcAntfyVOs[i].getA2FaxNo().equals("")){

						a2Vo.setCntcEml(bkgArrNtcAntfyVOs[i].getA2CntcEml());
						a2Vo.setFaxNo(bkgArrNtcAntfyVOs[i].getA2FaxNo());

					}
					insertVoList.add(a2Vo);

				} else if(bkgArrNtcAntfyVOs[i].getIbflag().equals("U")){

					//A1 데이터 셋팅
					a1Vo.setScNo(bkgArrNtcAntfyVOs[i].getScNo());
					a1Vo.setAntfyCustCd(bkgArrNtcAntfyVOs[i].getAntfyCustCd());
					a1Vo.setPodCd(bkgArrNtcAntfyVOs[i].getPodCd());
					a1Vo.setCustCntcTpCd("A1");
					a1Vo.setA1FaxNo(bkgArrNtcAntfyVOs[i].getA1FaxNo());
					a1Vo.setA1CntcEml(bkgArrNtcAntfyVOs[i].getA1CntcEml());
					a1Vo.setA2FaxNo(bkgArrNtcAntfyVOs[i].getA2FaxNo());
					a1Vo.setA2CntcEml(bkgArrNtcAntfyVOs[i].getA2CntcEml());
					a1Vo.setCreUsrId(account.getUsr_id());
					a1Vo.setUpdUsrId(account.getUsr_id());

					//A1 데이터 셋팅
					a2Vo.setScNo(bkgArrNtcAntfyVOs[i].getScNo());
					a2Vo.setAntfyCustCd(bkgArrNtcAntfyVOs[i].getAntfyCustCd());
					a2Vo.setPodCd(bkgArrNtcAntfyVOs[i].getPodCd());
					a2Vo.setCustCntcTpCd("A2");
					a2Vo.setA1FaxNo(bkgArrNtcAntfyVOs[i].getA1FaxNo());
					a2Vo.setA1CntcEml(bkgArrNtcAntfyVOs[i].getA1CntcEml());
					a2Vo.setA2FaxNo(bkgArrNtcAntfyVOs[i].getA2FaxNo());
					a2Vo.setA2CntcEml(bkgArrNtcAntfyVOs[i].getA2CntcEml());
					a2Vo.setCreUsrId(account.getUsr_id());
					a2Vo.setUpdUsrId(account.getUsr_id());

					//A1 데이터 셋팅(팩스, 이메일)
					if(!bkgArrNtcAntfyVOs[i].getA1CntcEml().equals("") || !bkgArrNtcAntfyVOs[i].getA1FaxNo().equals("")){
						a1Vo.setCntcEml(bkgArrNtcAntfyVOs[i].getA1CntcEml());
						a1Vo.setFaxNo(bkgArrNtcAntfyVOs[i].getA1FaxNo());
					}

					updateVoList.add(a1Vo);

					//A2 데이터 셋틷(팩스, 이메일)
					if(!bkgArrNtcAntfyVOs[i].getA2CntcEml().equals("") || !bkgArrNtcAntfyVOs[i].getA2FaxNo().equals("")){

						a2Vo.setCntcEml(bkgArrNtcAntfyVOs[i].getA2CntcEml());
						a2Vo.setFaxNo(bkgArrNtcAntfyVOs[i].getA2FaxNo());

					}
					updateVoList.add(a2Vo);

				} else if(bkgArrNtcAntfyVOs[i].getIbflag().equals("D")){
					deleteVoList.add(bkgArrNtcAntfyVOs[i]);
				}

			}

			//삭제
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeAlsoNotify(deleteVoList);
			}

			//수정
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyAlsoNotify(updateVoList);
			}

			//등록
			if ( insertVoList.size() > 0 ) {

				// 중복데이터 존재
				for(int i = 0; i < insertVoList.size(); i++){
					if (dbDao.checkAlsoNotifyDup(insertVoList.get(i)) == true) {
						rtnVo.setScNo(insertVoList.get(i).getScNo());
						rtnVo.setAntfyCustCd(insertVoList.get(i).getAntfyCustCd());
						rtnVo.setPodCd(insertVoList.get(i).getPodCd());

						return rtnVo;
					}
				} 

				dbDao.addAlsoNotify(insertVoList);
			}

			rtnVo = null;
			return rtnVo;

		}catch(DAOException ex){
			throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), ex);
		}
	}
}