/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCProposalMainBCImpl.java
*@FileTitle : Proposal & Amendment Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.04
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2009.05.08 변영주
* 1.0 Creation
=========================================================
* History
* 2010.10.04 송호진 [CHM-201006291-01] [긴급 요청사항] Session 정보 관련 getCre_usr_id - getUsr_id 로 교체
* 2011.05.03 김민아 [CHM-201110615-01] S/C Proposal에서 Filed 상태의 Sales rep 수정시 EDI WEB 과의 데이터 불일치 발생에 따른 수정
* 2011.08.09 김민아 [CHM-201112688-01] Contract별 Inquiry 화면을 요청 : 특정 S/C 한건에 대한 조회  View Popup 신규 개발
* 2011.10.05 서미진 [CHM-201113544] S/C 화면에서 복수의 Real customer 입력 가능토록 시스템 보완
* 2012.09.18 원종규 [CHM-201220110] 계약 변경 통보 기능: 계약이 사용된 BKG에대해 BKG의 Rating을 진행한 유저에게  G/W 메일 발송
* 2012.11.08 원종규 [CHM-201221251] 계약 변경 통보 기능 발송 메일 Header 변경: 발송 메일 제목에 적용 계약 #를 포함
* 2013.01.15 이은섭 [CHM-201322418-01] SC fling cancel 기능 관련 변경 요청
* 2013.05.14 전윤주 [CHM-201324704] S/C List Inquiry  S"rep code 반영로직 수정 - multi customer 일 때 변경 시 Respb sls rep 에도 적용
* 2013.10.21 전윤주 [CHM-201327107] S/C Note 하 Chassis 항목 추가
* 2013.11.07 전윤주 [CHM-201327486] File 시 Revenue Audit System 수입심사 배치대상 추가 요청
* 2014.04.17 전윤주 [CHM-201429927] 미주 지역 4개 ECC 폐쇄 관련 S/C 해당 운임 Block 기능 개발
* 2014.06.02 전윤주 [CHM-201430580] s/c 자동 filing 기능 추가
* 2014.09.17 송호진 [CHM-201430558] FMC Auto-filing 개발 요청
* 2015.05.15 최성환 [CHM-201535632] Affiliate 내 Type 란 생성 및 Type 간 혼재 불가 로직  
* 2015.06.15 최성환 [CHM-201536349] S/C 다운로드 보안 강화 (다운로드 버튼 접근 제한)
* 2015.09.25 최성환 [CHM-201537788] SC 다운로드 보안 강화_2차 개발
* 2015.09.25 현성길 [CHM-201537788] SC 다운로드 보안 강화 _ 2차 개발
* 2016.01.15 [CHM-201539511] S/C Copy 시 note conversion data의 Effective Date 관련 건 
* =========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.PriEmailTargetListVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.vo.RsltReturnVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.vo.PriSpScpNoteListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration.SCProposalMainDBDAO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration.SCProposalMainEAIDAO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.ChkScNoVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.CstPriSpHdrVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.CstPriSpMnFileDtVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.CstPriSpMnFileVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.CstRequestCheckVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.CstShHistVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.CstShInqVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.InPrsMQCEstimateVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriEdiScGenInfVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpDlRecVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpFiledCancelSearchVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpInqRecListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpInqRecSearchVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RequestCheckForCalculationVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltAmdtHisMnVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltCheckMQCEstimateVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltExpChkVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltMQCEstimateVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltMainStsVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltMdmOrganizationVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPRSCMDataVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPriCrmSlLdVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPriSgGrpCmdtVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPriSpAmdHstMnVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPriSpInqVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropAmdtEFFListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropAmdtListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropAmdtSmryVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropCustInfoVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropInqListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropMnDlRecVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropMnInqVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropMnScpListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropScpAmdtSmryVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltStatusVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.ScPropMnVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.ScPropProgVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.ScSlsLdCtrtInfoVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.SchCustVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.SchSaleLeadVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.SpScpGlineCopyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.screalcustomerproposal.vo.PriSpRealCustVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltCopyToProposalVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.TriPropSendMailVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.backend.support.BackEndJobException;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.CheckUtils;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.util.code.CodeInfo;
import com.hanjin.framework.component.util.code.CodeUtil;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSgGrpCmdtVO;
import com.hanjin.syscommon.common.table.PriSpAmdtSmryVO;
import com.hanjin.syscommon.common.table.PriSpCtrtPtyVO;
import com.hanjin.syscommon.common.table.PriSpFileCxlHisVO;
import com.hanjin.syscommon.common.table.PriSpHdrVO;
import com.hanjin.syscommon.common.table.PriSpInqRecVO;
import com.hanjin.syscommon.common.table.PriSpMnVO;
import com.hanjin.syscommon.common.table.PriSpProgVO;
import com.hanjin.syscommon.common.table.PriSpScpAmdtSmryVO;
import com.hanjin.syscommon.common.table.PriSpScpDurVO;
import com.hanjin.syscommon.common.table.PriSpScpMnVO;
import com.hanjin.syscommon.common.table.PriSpScpProgVO;

/**
 * NIS2010-SCProposal Business Logic Basic Command implementation<br>
 * - NIS2010-SCProposal에 대한 비지니스 로직을 처리합니다.<br>
 *
 * @author Byeon Young Joo
 * @see ESM_PRI_0003EventResponse,SCProposalMainBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class SCProposalMainBCImpl extends BasicCommandSupport implements SCProposalMainBC {

	// Database Access Object
	private transient SCProposalMainDBDAO dbDao = null;

	/**
	 * SCProposalMainBCImpl 객체 생성<br>
	 * SCProposalMainDBDAO를 생성한다.<br>
	 */
	public SCProposalMainBCImpl() { 
		dbDao = new SCProposalMainDBDAO(); 
	}

	/**
	 * S/C Proposal Main 정보를 조회합니다.<br>
	 * 
	 * @param PriSpHdrVO priSpHdrVO
	 * @param SignOnUserAccount account
	 * @return RsltPropListVO
	 * @exception EventException
	 */
	public RsltPropListVO searchProposalMain(PriSpHdrVO priSpHdrVO, SignOnUserAccount account) throws EventException {
		try {
			RsltPropListVO vo = new RsltPropListVO();
			
			// HQ Office에 해당하는지 조회 한다.
			RsltMdmOrganizationVO orgVO = dbDao.searchMemOrganization(account);
			vo.setRsltPropMnVOs(dbDao.searchProposalMain(priSpHdrVO,orgVO, account));
			vo.setRsltPropMnScpListVOs(dbDao.searchProposalMainScpList(priSpHdrVO, account));			

			return vo;
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}
	
	/**
     * S/C Proposal Master Creation의 데이터를 조회합니다.의 RD Print 파일 오픈 권한 정보 조회를 한다. <br>
	 * 사용대상 : RD Print 파일 오픈시 권한 정보 조회를 한다 <br>
	 * 
	 * @param PriSpHdrVO priSpHdrVO
	 * @param SignOnUserAccount account
	 * @return RsltPropListVO
	 * @exception EventException
	 */
	public RsltPropListVO searchProposalMainPrintAuthInfo(PriSpHdrVO priSpHdrVO, SignOnUserAccount account) throws EventException {
		try {
			RsltPropListVO vo = new RsltPropListVO();
			
			// HQ Office에 해당하는지 조회 한다.
			RsltMdmOrganizationVO orgVO = dbDao.searchMemOrganization(account);
			vo.setRsltPropMnVOs(dbDao.searchProposalMainPrintAuthInfo(priSpHdrVO,orgVO, account));	

			return vo;
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 * S/C Main 정보를 저장합니다.<br>
	 * 
	 * @param ScPropMnVO scPropMnVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String manageProposal(ScPropMnVO scPropMnVO, SignOnUserAccount account) throws EventException{
		String newPropNo = "";
		try {			
			PriSpHdrVO[] hdrVo = scPropMnVO.getPriSpHdrVOs();
			PriSpMnVO[] vo = scPropMnVO.getPriSpMnVOs();
			PriSpProgVO[] progVo = scPropMnVO.getPriSpProgVOs();
			PriSpAmdtSmryVO[] smryVo = scPropMnVO.getPriSpAmdtSmryVOs();
			PriSpScpMnVO[] scpVo = scPropMnVO.getPriSpScpMnVOs();
			PriSpScpProgVO[] scpProgVo = scPropMnVO.getPriSpScpProgVOs();
			PriSpScpAmdtSmryVO[] scpSmryVo = scPropMnVO.getPriSpScpAmdtSmryVOs();			
			PriSpCtrtPtyVO[] ptyVo = scPropMnVO.getPriSpCtrtPtyVOs();			
			List<PriSpHdrVO> insertHdrVoList = new ArrayList<PriSpHdrVO>();
			List<PriSpMnVO> insertVoList = new ArrayList<PriSpMnVO>();
			List<PriSpProgVO> insertProgVoList = new ArrayList<PriSpProgVO>();
			List<PriSpAmdtSmryVO> insertSmryVoList = new ArrayList<PriSpAmdtSmryVO>();
			List<PriSpScpMnVO> insertScpVoList = new ArrayList<PriSpScpMnVO>();
			List<PriSpScpProgVO> insertScpProgVoList = new ArrayList<PriSpScpProgVO>();
			List<PriSpScpAmdtSmryVO> insertScpSmryVoList = new ArrayList<PriSpScpAmdtSmryVO>();
			List<PriSpHdrVO> updateHdrVoList = new ArrayList<PriSpHdrVO>();
			List<PriSpMnVO> updateVoList = new ArrayList<PriSpMnVO>();
			List<PriSpScpMnVO> updateScpVoList = new ArrayList<PriSpScpMnVO>();
		
			newPropNo = dbDao.searchCreationProposalNo(vo[0].getPropOfcCd());
			for ( int i = 0; hdrVo != null && i < hdrVo.length; i++ ) {
			    if (JSPUtil.getNull(hdrVo[i].getPrcPropCreTpCd()).equals("")) {
			        hdrVo[i].setPrcPropCreTpCd("G");
			    }
                if (JSPUtil.getNull(hdrVo[i].getPrcMstPropTpCd()).equals("")) {
                    hdrVo[i].setPrcMstPropTpCd("P");
                }
			    
				if ( hdrVo[i].getIbflag().equals("I")){
					hdrVo[i].setPropNo(newPropNo);
					hdrVo[i].setCreUsrId(account.getUsr_id());
					hdrVo[i].setUpdUsrId(account.getUsr_id());					
					insertHdrVoList.add(hdrVo[i]);
				} else if ( hdrVo[i].getIbflag().equals("U")){
					hdrVo[i].setUpdUsrId(account.getUsr_id());
					updateHdrVoList.add(hdrVo[i]);
				}
			}			
			log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			log.debug("getRealCustCntCd======"+vo[0].getRealCustCntCd());
			log.debug("getRealCustSrepCd====="+vo[0].getRealCustSrepCd());
			log.debug("getRealCustSlsOfcCd====="+vo[0].getRealCustSlsOfcCd());
			log.debug("                                                      ");
			log.debug("setRespbSrepCd=========="+vo[0].getRespbSrepCd() );
			log.debug("setRespbSlsOfcCd========"+vo[0].getRespbSlsOfcCd());
			log.debug("                                                      ");			
			log.debug("getCtrtCustSrepCd======="+ptyVo[0].getCtrtCustSrepCd());
			log.debug("getCtrtCustSrepCd======="+ptyVo[0].getCtrtCustSlsOfcCd());
			log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			
			
			////////////////////////////////////////////////////////////////////////////////////////
//			for ( int i = 0; vo != null && i < vo.length; i++ ) {
//				if ( vo[i].getIbflag().equals("I")){
//					vo[i].setPropNo(newPropNo);	
//					vo[i].setCreUsrId(account.getUsr_id());
//					vo[i].setUpdUsrId(account.getUsr_id());	
//					if (vo[i].getAmdtSeq().equals("0")){
////						log.debug(" amdt_seq=0");
//						if (vo[i].getRealCustCntCd().equals("")){
//							if (vo[i].getRealCustSrepCd().equals("")){
//								vo[i].setRespbSrepCd(ptyVo[i].getCtrtCustSrepCd()) ;
//								vo[i].setRespbSlsOfcCd(ptyVo[i].getCtrtCustSlsOfcCd());
//							}
//						}else{
//							if (vo[i].getRealCustSrepCd().equals("")){
//								vo[i].setRespbSrepCd(ptyVo[i].getCtrtCustSrepCd()) ;
//								vo[i].setRespbSlsOfcCd(ptyVo[i].getCtrtCustSlsOfcCd());
//							}else{
//								vo[i].setRespbSrepCd(vo[i].getRealCustSrepCd()) ;
//								vo[i].setRespbSlsOfcCd(vo[i].getRealCustSlsOfcCd());
//							}
//						}
//					}else{
////						log.debug(" amdt_seq != 0");
//						if (vo[i].getRespbSrepCd().equals("")){
//							vo[i].setRespbSrepCd(ptyVo[i].getCtrtCustSrepCd()) ;
//							vo[i].setRespbSlsOfcCd(ptyVo[i].getCtrtCustSlsOfcCd());
//						}
//					}
//					insertVoList.add(vo[i]);
//				} else if ( vo[i].getIbflag().equals("U")){
//					vo[i].setUpdUsrId(account.getUsr_id());
//					if (vo[i].getAmdtSeq().equals("0")){
////						log.debug(" amdt_seq=0");
//						if (vo[i].getRealCustCntCd().equals("")){
//							if (vo[i].getRealCustSrepCd().equals("")){
//								vo[i].setRespbSrepCd(ptyVo[i].getCtrtCustSrepCd()) ;
//								vo[i].setRespbSlsOfcCd(ptyVo[i].getCtrtCustSlsOfcCd());
//							}
//						}else{
//							if (vo[i].getRealCustSrepCd().equals("")){
//								vo[i].setRespbSrepCd(ptyVo[i].getCtrtCustSrepCd()) ;
//								vo[i].setRespbSlsOfcCd(ptyVo[i].getCtrtCustSlsOfcCd());
//							}else{
//								vo[i].setRespbSrepCd(vo[i].getRealCustSrepCd()) ;
//								vo[i].setRespbSlsOfcCd(vo[i].getRealCustSlsOfcCd());
//							}
//						}
//					}else{
//
////						if (vo[i].getRespbSrepCd().equals("")){
////							vo[i].setRespbSrepCd(ptyVo[i].getCtrtCustSrepCd()) ;
////							vo[i].setRespbSlsOfcCd(ptyVo[i].getCtrtCustSlsOfcCd());
////						}
//						if (vo[i].getRealCustCntCd().equals("")){
//							if (vo[i].getRealCustSrepCd().equals("")){
//								vo[i].setRespbSrepCd(ptyVo[i].getCtrtCustSrepCd()) ;
//								vo[i].setRespbSlsOfcCd(ptyVo[i].getCtrtCustSlsOfcCd());
//							}
//						}else{
//							if (vo[i].getRealCustSrepCd().equals("")){
//								vo[i].setRespbSrepCd(ptyVo[i].getCtrtCustSrepCd()) ;
//								vo[i].setRespbSlsOfcCd(ptyVo[i].getCtrtCustSlsOfcCd());
//							}else{
//								vo[i].setRespbSrepCd(vo[i].getRealCustSrepCd()) ;
//								vo[i].setRespbSlsOfcCd(vo[i].getRealCustSlsOfcCd());
//							}
//						}						
//						
//					}					
//					if (vo[i].getRealCustCntCd().equals("") || vo[i].getRealCustSeq().equals("")){
//						vo[i].setRealCustCntCd("XX"); //값이 비어 있다면 real customer 빈값으로 update
//					}
//					if (vo[i].getSlsLdNo().equals("")){
//						vo[i].setSlsLdNo("XX");
//					}
//					updateVoList.add(vo[i]);
//				} 
//			}			
			////////////////////////////////////////////////////////////////////////////////////////
			
			for ( int i = 0; vo != null && i < vo.length; i++ ) {
				if ( vo[i].getIbflag().equals("I")){
					vo[i].setPropNo(newPropNo);	
					vo[i].setCreUsrId(account.getUsr_id());
					vo[i].setUpdUsrId(account.getUsr_id());	

					if (vo[i].getRealCustCntCd().equals("")){
						vo[i].setRespbSrepCd(ptyVo[i].getCtrtCustSrepCd()) ;
						vo[i].setRespbSlsOfcCd(ptyVo[i].getCtrtCustSlsOfcCd());
					}else{
						if (vo[i].getRealCustSrepCd().equals("")){
							vo[i].setRespbSrepCd(ptyVo[i].getCtrtCustSrepCd()) ;
							vo[i].setRespbSlsOfcCd(ptyVo[i].getCtrtCustSlsOfcCd());
						}else{
							vo[i].setRespbSrepCd(vo[i].getRealCustSrepCd()) ;
							vo[i].setRespbSlsOfcCd(vo[i].getRealCustSlsOfcCd());
						}
					}

					insertVoList.add(vo[i]);
				} else if ( vo[i].getIbflag().equals("U")){
					vo[i].setUpdUsrId(account.getUsr_id());

					if (vo[i].getRealCustCntCd().equals("")){
						vo[i].setRespbSrepCd(ptyVo[i].getCtrtCustSrepCd()) ;
						vo[i].setRespbSlsOfcCd(ptyVo[i].getCtrtCustSlsOfcCd());					
					}else{
						if (vo[i].getRealCustSrepCd().equals("")){
							vo[i].setRespbSrepCd(ptyVo[i].getCtrtCustSrepCd()) ;
							vo[i].setRespbSlsOfcCd(ptyVo[i].getCtrtCustSlsOfcCd());
						}else{
							vo[i].setRespbSrepCd(vo[i].getRealCustSrepCd()) ;
							vo[i].setRespbSlsOfcCd(vo[i].getRealCustSlsOfcCd());
						}
					}								
					
					if (vo[i].getRealCustCntCd().equals("") || vo[i].getRealCustSeq().equals("")){
						vo[i].setRealCustCntCd("XX"); //값이 비어 있다면 real customer 빈값으로 update
					}
					if (vo[i].getSlsLdNo().equals("")){
						vo[i].setSlsLdNo("XX");
					}
					updateVoList.add(vo[i]);
				} 
			}
			
			
			for ( int i = 0; progVo != null && i < progVo.length; i++ ) {
				if ( progVo[i].getIbflag().equals("I")){
					progVo[i].setPropNo(newPropNo);	
					progVo[i].setCreUsrId(account.getUsr_id());
					progVo[i].setUpdUsrId(account.getUsr_id());		
					progVo[i].setProgOfcCd(account.getOfc_cd());
					progVo[i].setProgUsrId(account.getUsr_id());								
					insertProgVoList.add(progVo[i]);
				}
			}
			
			for ( int i = 0; smryVo != null && i < smryVo.length; i++ ) {
				if ( smryVo[i].getIbflag().equals("I")){
					smryVo[i].setPropNo(newPropNo);	
					smryVo[i].setCreUsrId(account.getUsr_id());
					smryVo[i].setUpdUsrId(account.getUsr_id());					
					insertSmryVoList.add(smryVo[i]);
				}
			}			
			for ( int i = 0; scpVo != null && i < scpVo.length; i++ ) {
				if ( scpVo[i].getIbflag().equals("I")){
					if(scpVo[i].getPropNo().equals("")){
						scpVo[i].setPropNo(newPropNo);
						scpVo[i].setAmdtSeq("0");
					}
					scpVo[i].setCreUsrId(account.getUsr_id());
					scpVo[i].setUpdUsrId(account.getUsr_id());					
					insertScpVoList.add(scpVo[i]);
				} else if ( scpVo[i].getIbflag().equals("U")){
					scpVo[i].setUpdUsrId(account.getUsr_id());
					updateScpVoList.add(scpVo[i]);
				}
			}

			for ( int i = 0; scpProgVo != null && i < scpProgVo.length; i++ ) {
				if ( scpProgVo[i].getIbflag().equals("I")){
					if(scpProgVo[i].getPropNo().equals("")){
						scpProgVo[i].setPropNo(newPropNo);
						scpProgVo[i].setAmdtSeq("0");
					}					
					scpProgVo[i].setCreUsrId(account.getUsr_id());
					scpProgVo[i].setUpdUsrId(account.getUsr_id());
					scpProgVo[i].setProgOfcCd(account.getOfc_cd());
					scpProgVo[i].setProgUsrId(account.getUsr_id());					
					insertScpProgVoList.add(scpProgVo[i]);
				}
			}
			
			for ( int i = 0; scpSmryVo != null && i < scpSmryVo.length; i++ ) {
				if ( scpSmryVo[i].getIbflag().equals("I")){
					if(scpSmryVo[i].getPropNo().equals("")){
						scpSmryVo[i].setPropNo(newPropNo);
						scpSmryVo[i].setAmdtSeq("0");
					}						
					scpSmryVo[i].setCreUsrId(account.getUsr_id());
					scpSmryVo[i].setUpdUsrId(account.getUsr_id());					
					insertScpSmryVoList.add(scpSmryVo[i]);
				}
			}			
			
			//mn 이 신규 추가 되었을 경우
			if ( insertVoList.size() > 0 ) {
				dbDao.addProposalHeader(insertHdrVoList);
				dbDao.addProposalMain(insertVoList);
				dbDao.addProposalProgress(insertProgVoList);
				dbDao.addProposalAmendmentSummary(insertSmryVoList);
			}
			
			if ( updateHdrVoList.size() > 0 ) {
				dbDao.modifyProposalHeader(updateHdrVoList);
			}			

			//기존 mn 에 대한 update
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyProposalMain(updateVoList);
			}

			// scp mn 이 신규 추가되었을 경우
			if ( insertScpVoList.size() > 0 ) {
				dbDao.addProposalScopeMain(insertScpVoList);
				dbDao.addProposalScopeProgress(insertScpProgVoList);
				dbDao.addProposalScopeAmendmentSummary(insertScpSmryVoList);
			}
			
			// 기존 scp mn 이 update
			if ( updateScpVoList.size() > 0 ) {
				dbDao.modifyProposalScopeMain(updateScpVoList);
			}

			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
		
		return newPropNo;
	}	

	/**
	 *   Amend Request 정보를 조회합니다.<br>
	 * 
	 * @param PriSpHdrVO priSpHdrVO
	 * @return List<RsltPropAmdtListVO>
	 * @exception EventException
	 */
	public List<RsltPropAmdtListVO> searchProposalAmendList (PriSpHdrVO priSpHdrVO) throws EventException {
		try {
			return dbDao.searchProposalAmendList (priSpHdrVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	   /**
     *   Amend Effective Date 정보를 조회합니다.<br>
     * 
     * @param PriSpMnVO priSpMnVO
     * @return List<RsltPropAmdtEFFListVO>
     * @exception EventException
     */
    public List<RsltPropAmdtEFFListVO> searchProposalAmendEffList (PriSpMnVO priSpMnVO) throws EventException {
        try {  
            
            return dbDao.searchProposalAmendEffList (priSpMnVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
    }
	
 
	
	
	/**
	 *   Amend 시 해당 Proposal 의 MAX seq.가 filed 상태가 아니면 amend 할 수 없다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchAmendCheckProposalStatus(PriSpMnVO priSpMnVO) throws EventException {
		try {
			return dbDao.searchAmendCheckProposalStatus(priSpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * Amend Request를 처리합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException{
		try {
			List<PriSpMnVO> insertVoList = new ArrayList<PriSpMnVO>();

			priSpMnVO.setCreUsrId(account.getUsr_id());
			priSpMnVO.setUpdUsrId(account.getUsr_id());
			priSpMnVO.setPropOfcCd(account.getOfc_cd());
			insertVoList.add(priSpMnVO);
		
			dbDao.addProposalMainAmend(insertVoList);
			dbDao.addProposalScopeMainAmend(insertVoList);
			
			//Filing 에서 exp_dt를 자른다.
//			dbDao.modifyProposalMainAmend(insertVoList);			
//			dbDao.modifyProposalScopeMainAmend(insertVoList);	
			dbDao.addProposalProgressAmend(insertVoList);
			dbDao.addProposalAmendmentSummaryAmend(insertVoList);
			dbDao.addProposalScopeProgressAmend(insertVoList);
			dbDao.addProposalScopeAmendmentSummaryAmend(insertVoList);
			
// pri_sp_prog 신규 insert
// pri_sp_amdt_smry 신규 insert
// pri_sp_scp_prog 신규 insert
// pri_sp_scp_amdt_smry 신규 insert
			
	} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}

	/**
	 * TPW Group Commodity Guideline Effective Date 조회 이벤트 처리<br>
	 * TPW Group Commodity Guideline Effective Date 조회 이벤트 처리<br>
	 * 
	 * @param rsltPriSgGrpCmdtVO   RsltPriSgGrpCmdtVO
	 * @return List<String>
	 * @exception EventException
	 */
//	public PriSpScpMnVO searchGRIGroupCommodityEffectiveDt (RsltPriSgGrpCmdtVO rsltPriSgGrpCmdtVO) throws EventException {
//		try {
//			return dbDao.searchGRIGroupCommodityEffectiveDt (rsltPriSgGrpCmdtVO);
//		} catch (DAOException ex) {
//			throw new EventException(new ErrorHandler(ex).getMessage());
//		}
//	}

	/**
	 * TPW Group Commodity Guideline List 조회합니다.<br>
	 * 
	 * @param RsltPriSgGrpCmdtVO rsltPriSgGrpCmdtVO
	 * @return List<PriSgGrpCmdtVO>
	 * @exception EventException
	 */
	public List<PriSgGrpCmdtVO> searchGRIGroupCommodityList (RsltPriSgGrpCmdtVO rsltPriSgGrpCmdtVO) throws EventException {
		try {
			return dbDao.searchGRIGroupCommodityList (rsltPriSgGrpCmdtVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
     * S/C Proposal Master Creation의 상태를 변경합니다.<br>
	 * 
	 * @param ScPropProgVO scPropProgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void counterofferProposal(ScPropProgVO scPropProgVO, SignOnUserAccount account) throws EventException{
		try {
			
			PriSpMnVO[] vo =  scPropProgVO.getPriSpMnVOs();
//			log.debug("=====count bc ibflag==="+vo[0].getIbflag() );
			PriSpProgVO[] pVo = scPropProgVO.getPriSpProgVOs();
			
			List<PriSpMnVO> updateVoList = new ArrayList<PriSpMnVO>();
			List<PriSpProgVO> insertVoList = new ArrayList<PriSpProgVO>();			
			if (vo != null){
				for ( int i = 0; i< vo.length ; i++ ) {
					if ( vo[i].getIbflag().equals("U")){
						vo[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(vo[i]);
					} 
				}
			}
			for ( int i = 0; i < pVo.length; i++ ) {
				if ( pVo[i].getIbflag().equals("U")){
					pVo[i].setUpdUsrId(account.getUsr_id());
					pVo[i].setCreUsrId(account.getUsr_id());
					pVo[i].setProgUsrId(account.getUsr_id());
					pVo[i].setProgOfcCd(account.getOfc_cd());
					pVo[i].setProgDt(account.getUpd_dt());					
					insertVoList.add(pVo[i]);
				} 
			}			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyProposalMain(updateVoList);
			}
			if ( insertVoList.size() > 0 ) {
				dbDao.addProposalProgress(insertVoList);	
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
     * S/C Proposal Master Creation의 상태를 Approve로 변경합니다.<br>
     *
     * @param ScPropProgVO scPropProgVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
	public void approveProposal(ScPropProgVO scPropProgVO, SignOnUserAccount account) throws EventException{
		try {
			
			PriSpMnVO[] vo =  scPropProgVO.getPriSpMnVOs();
			PriSpProgVO[] pVo = scPropProgVO.getPriSpProgVOs();
			
			List<PriSpMnVO> updateVoList = new ArrayList<PriSpMnVO>();
			List<PriSpProgVO> insertVoList = new ArrayList<PriSpProgVO>();			
			
			for ( int i = 0; i< vo.length; i++ ) {
				if ( vo[i].getIbflag().equals("U")){
					vo[i].setUpdUsrId(account.getUsr_id());
					vo[i].setPropAproDt(account.getUpd_dt());					
					updateVoList.add(vo[i]);
				} 
			}
			
			for ( int i = 0; i< pVo.length; i++ ) {
				if ( pVo[i].getIbflag().equals("U")){
					pVo[i].setUpdUsrId(account.getUsr_id());
					pVo[i].setCreUsrId(account.getUsr_id());
					pVo[i].setProgUsrId(account.getUsr_id());
					pVo[i].setProgOfcCd(account.getOfc_cd());
					pVo[i].setProgDt(account.getUpd_dt());
					
					insertVoList.add(pVo[i]);
				} 
			}			
			
			dbDao.modifyProposalMain(updateVoList);
			dbDao.addProposalProgress(insertVoList);			
			//approval date update
			dbDao.modifyProposalApprovalDate(updateVoList);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
    /**
     * S/C Proposal Master Creation의 상태를 이전 상태로 변경합니다.<br>
     *
     * @param ScPropProgVO scPropProgVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
	public void cancelProposal(ScPropProgVO scPropProgVO, SignOnUserAccount account) throws EventException{
		try {
			
			PriSpMnVO[] vo =  scPropProgVO.getPriSpMnVOs();
			PriSpProgVO[] pVo = scPropProgVO.getPriSpProgVOs();
//			PriSpHdrVO hdrVo =  new PriSpHdrVO();// Approve Cancel시 S/C No. 초기화하지 않는다.-현업요청
			
			List<PriSpMnVO> updateVoList = new ArrayList<PriSpMnVO>();
			List<PriSpProgVO> insertVoList = new ArrayList<PriSpProgVO>();	
//			List<PriSpHdrVO> updateHdrVoList = new ArrayList<PriSpHdrVO>();
			
			for ( int i = 0; i< vo.length; i++ ) {
				if ( vo[i].getIbflag().equals("U")){
					vo[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(vo[i]);
//					if (vo[i].getPropStsCd().equals("Q") && vo[i].getAmdtSeq().equals("0")){
//						hdrVo.setPropNo(vo[i].getPropNo());
//						hdrVo.setScNo("INIT");
//						hdrVo.setUpdUsrId(account.getUsr_id());
//						updateHdrVoList.add(hdrVo);
//					}
				} 
			}
			
			for ( int i = 0; i< pVo.length; i++ ) {
				if ( pVo[i].getIbflag().equals("U")){
					pVo[i].setUpdUsrId(account.getUsr_id());
					pVo[i].setCreUsrId(account.getUsr_id());
					pVo[i].setProgUsrId(account.getUsr_id());
					pVo[i].setProgOfcCd(account.getOfc_cd());
					pVo[i].setProgDt(account.getUpd_dt());					
					insertVoList.add(pVo[i]);
				} 
			}			
			
//			dbDao.modifyProposalHeader(updateHdrVoList);
			dbDao.modifyProposalMain(updateVoList);
			dbDao.addProposalProgress(insertVoList);		
			//approval date update
			log.debug("modifyProposalApprovalDate===================>");
			log.debug(vo[0].getPropStsCd());
			log.debug("modifyProposalApprovalDate===================>");
			if (vo[0].getPropStsCd().equals("Q")){
				dbDao.modifyProposalApprovalDate(updateVoList);	
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
     * Terms의 데이터 변경 시 Scope별  Terms Summary정보를 수정 합니다.<br>
     *
     * @param PriSpScpAmdtSmryVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
	public void manageProposalScopeAmendmentSummary(PriSpScpAmdtSmryVO vo, SignOnUserAccount account) throws EventException{
		try {
			
			List<PriSpScpAmdtSmryVO> updateVoList = new ArrayList<PriSpScpAmdtSmryVO>();		
			vo.setUpdUsrId(account.getUsr_id());
			updateVoList.add(vo);
			
			dbDao.modifyProposalScopeAmendmentSummary(updateVoList);
			//Scope Main의 상태를 변경한다.
			dbDao.modifyProposalScopeStatus(updateVoList);			
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
	
	
    /**
     * Terms의 상태 변경 시 Scope별  Terms Summary정보를 수정 합니다.<br>
     *
     * @param PriSpScpAmdtSmryVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
	public void manageScopeAmendmentSummary(PriSpScpAmdtSmryVO vo, SignOnUserAccount account) throws EventException{
		try {			
			List<PriSpScpAmdtSmryVO> updateVoList = new ArrayList<PriSpScpAmdtSmryVO>();		
			vo.setUpdUsrId(account.getUsr_id());
			updateVoList.add(vo);
			
			dbDao.modifyProposalScopeAmendmentSummary(updateVoList);
			dbDao.modifyProposalScopeStatus(updateVoList);
						
            PriSpScpMnVO scpVo = new PriSpScpMnVO();
            ObjectCloner.build(vo, scpVo);
            int cnt = dbDao.searchProposalScopeAcceptCheck(scpVo);
            
            if (cnt == 0){//scope status accept change
                PriSpScpMnVO[] priSpScpMnVO = new PriSpScpMnVO[1];
                priSpScpMnVO[0] = new PriSpScpMnVO();
                ObjectCloner.build(scpVo, priSpScpMnVO[0]);
                priSpScpMnVO[0].setPropScpStsCd("A");//Accept로 변경
                
    			List<PriSpScpMnVO> updateScpVoList = new ArrayList<PriSpScpMnVO>();
    			List<PriSpScpProgVO> insertProgVoList =  new ArrayList<PriSpScpProgVO>(); 
    			
    			priSpScpMnVO[0].setUpdUsrId(account.getUsr_id());
    			updateScpVoList.add(priSpScpMnVO[0]);
    			
    			PriSpScpProgVO progVo = new PriSpScpProgVO();
				ObjectCloner.build(priSpScpMnVO[0], progVo);
				progVo.setProgOfcCd(account.getOfc_cd());	
				progVo.setProgUsrId(account.getUsr_id());
				progVo.setCreUsrId(account.getUsr_id());
				insertProgVoList .add(progVo);	
				
    			if ( updateVoList.size() > 0 ) {				
    				dbDao.modifymanageScopeStatus(updateScpVoList);
    			}    			
    			//pregress 변경    			
    			if ( insertProgVoList.size() > 0 ) {				
    				log.debug("progvo propno============"+progVo.getPropNo());
    				dbDao.addProposalScopeProgress(insertProgVoList);
    			}                
            }else{
            	scpVo.setUpdUsrId(account.getUsr_id());	
				dbDao.modifyAutoScopeReturnStatus (scpVo);
				List<PriSpScpProgVO> insertProgVoList =  new ArrayList<PriSpScpProgVO>(); 
				if (dbDao.searchScopeProgressStatus(scpVo) == 0){
					//prog와 Mn의 상태가 다르다면 prog에 insert
					PriSpScpProgVO spScpProgVo = new PriSpScpProgVO();
					ObjectCloner.build(scpVo, spScpProgVo);
					spScpProgVo.setProgOfcCd(account.getOfc_cd());	
					spScpProgVo.setProgUsrId(account.getUsr_id());
					spScpProgVo.setCreUsrId(account.getUsr_id());
					insertProgVoList .add(spScpProgVo);	
					if ( insertProgVoList.size() > 0 ) {				
						dbDao.addProposalScopeProgressScopeMn(insertProgVoList);
					}						
				}
            	
            }
                        
            PriSpMnVO mnVo = new PriSpMnVO();
            ObjectCloner.build(vo, mnVo); 
            mnVo.setUpdUsrId(account.getUsr_id());            
            dbDao.modifyAutoChangeMainStatus(mnVo);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}		
	
	
    /**
     * S/C Proposal Request시 자동 Accept되는 항목에대한 Summary정보를 수정 합니다.<br>
     *  
     * @param PriSpScpAmdtSmryVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
	public void manageProposalScopeAutoAcceptAmendmentSummary(PriSpScpAmdtSmryVO vo, SignOnUserAccount account) throws EventException{
		try {
			
			List<PriSpScpAmdtSmryVO> updateVoList = new ArrayList<PriSpScpAmdtSmryVO>();		
			vo.setUpdUsrId(account.getUsr_id());
			vo.setAcptFlg("Y");
			vo.setSvcScpCd("");
			updateVoList.add(vo);
			if (vo.getPropScpTermTpCd().equals("31")){
				dbDao.modifyProposalScopeAutoAcceptNoteAmendmentSummary(updateVoList);				
			}else{
				dbDao.modifyProposalScopeAutoAcceptAmendmentSummary(updateVoList);	
			}
			dbDao.modifyProposalScopeStatus(updateVoList);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
    /**
     * Request Cancel시 자동으로 Accept된 항목을 이전상태로 돌린다.(Scope)<br>
     *
     * @param PriSpScpAmdtSmryVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
	public void manageProposalScopeRequestCancelAmendmentSummary(PriSpScpAmdtSmryVO vo, SignOnUserAccount account) throws EventException{
		try {
			
			List<PriSpScpAmdtSmryVO> updateVoList = new ArrayList<PriSpScpAmdtSmryVO>();		
			vo.setUpdUsrId(account.getUsr_id());
			vo.setAcptFlg("N");
			updateVoList.add(vo);			
			dbDao.modifyProposalScopeRequestCancelAmendmentSummary(updateVoList);			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}		
	
    /**
     * Request Cancel시 자동으로 Accept된 항목을 이전상태로 돌린다.(Scope)<br>
     *
     * @param PriSpScpAmdtSmryVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
	public void manageProposalAutoScopeRequestCancelAmendmentSummary(PriSpScpAmdtSmryVO vo, SignOnUserAccount account) throws EventException{
		try {
			
			List<PriSpScpAmdtSmryVO> updateVoList = new ArrayList<PriSpScpAmdtSmryVO>();		
			vo.setUpdUsrId(account.getUsr_id());
			vo.setAcptFlg("N");
			updateVoList.add(vo);			
			dbDao.modifyProposalAutoScopeRequestCancelAmendmentSummary(updateVoList);			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}		
	
    /**
     * Terms의 상태 변경 시 Terms Summary정보를 수정 합니다.<br>
     *
     * @param PriSpAmdtSmryVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
	public void manageProposalAmendmentSummary(PriSpAmdtSmryVO vo, SignOnUserAccount account) throws EventException{
		try {
			
			List<PriSpAmdtSmryVO> updateVoList = new ArrayList<PriSpAmdtSmryVO>();
		
			vo.setUpdUsrId(account.getUsr_id());
			updateVoList.add(vo);
			
			dbDao.modifyProposalAmendmentSummary(updateVoList);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
	
    /**
     * Terms의 상태 변경 시 Terms Summary정보를 수정 합니다.<br>
     * Main 의 상태가 Returned일 경우 모든 Terms가 Accept되었다면 Main 의 상태를 Request로 변경한다.
     * @param PriSpAmdtSmryVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
	public void manageAmendmentSummary(PriSpAmdtSmryVO vo, SignOnUserAccount account) throws EventException{
		try {
			
			List<PriSpAmdtSmryVO> updateVoList = new ArrayList<PriSpAmdtSmryVO>();		
			vo.setUpdUsrId(account.getUsr_id());
			updateVoList.add(vo);
			dbDao.modifyProposalAmendmentSummary(updateVoList);
			
			PriSpMnVO  mnVo = new PriSpMnVO();
			mnVo.setPropNo(vo.getPropNo());
			mnVo.setAmdtSeq(vo.getAmdtSeq());
			mnVo.setUpdUsrId(account.getUsr_id());            
            dbDao.modifyAutoChangeMainStatus(mnVo);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}		
	
	
	/**
     * Request, Request Cancel시 Accept 상태를 수정합니다.<br>
	 * 
	 * @param PriSpAmdtSmryVO vo
	 * @param List<String> termList
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyProposalAutoAcceptAmendmentSummary(PriSpAmdtSmryVO vo, List<String> termList, SignOnUserAccount account) throws EventException{
		try {
			
			List<PriSpAmdtSmryVO> updateVoList = new ArrayList<PriSpAmdtSmryVO>();
		
			vo.setUpdUsrId(account.getUsr_id());
			vo.setAcptFlg("Y");
			updateVoList.add(vo);
			
			dbDao.modifyProposalAutoAcceptAmendmentSummary(updateVoList,termList);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}		
	 
	
	
	/**
     * Request Cancel시 자동으로 Accept된 항목을 Init 상태로 돌린다.<br>
	 * 
	 * @param PriSpAmdtSmryVO vo
	 * @param List<String> termList
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalAutoRequestCancelAmendmentSummary(PriSpAmdtSmryVO vo, List<String> termList,SignOnUserAccount account) throws EventException{
		try {
			
			List<PriSpAmdtSmryVO> updateVoList = new ArrayList<PriSpAmdtSmryVO>();
		
			vo.setUpdUsrId(account.getUsr_id());
			vo.setAcptFlg("N");
			updateVoList.add(vo);
			
			dbDao.modifyProposalAutoRequestCancelAmendmentSummary(updateVoList,termList);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
	
	/**
	 *  S/C Proposal Customer 정보를 조회합니다.<br>
	 * 
	 * @param SchCustVO schCustVO
	 * @return List<RsltPropCustInfoVO>
	 * @exception EventException
	 */
	public List<RsltPropCustInfoVO> searchProposalCustomerInfo(SchCustVO schCustVO) throws EventException {
		try {
			return dbDao.searchProposalCustomerInfo(schCustVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}

	//------------------JIN START---------------------------------------
    /**
     * S/C Proposal Boiler Plate/Affiliate 의 Copy 정보를 조회합니다.<br>
     * 
     * @param RsltPropCopyVO rsltPropCopyVO
     * @return List<RsltPropCopyVO>
     * @exception EventException
     */
    public List<RsltPropCopyVO> searchProposalCopyBlplAfilList (RsltPropCopyVO rsltPropCopyVO) throws EventException {
        try {
            return dbDao.searchProposalCopyBlplAfilList (rsltPropCopyVO);
        } catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
    }

	/**
	 * S/C Proposal Main/Scope 의 Copy 정보를 조회합니다.<br>
	 * 
	 * @param RsltPropCopyVO rsltPropCopyVO
	 * @return List<RsltPropCopyVO>
	 * @exception EventException
	 */
	public List<RsltPropCopyVO> searchProposalCopyList (RsltPropCopyVO rsltPropCopyVO) throws EventException {
		try {
			return dbDao.searchProposalCopyList (rsltPropCopyVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * S/C Proposal Main 정보를 Copy 합니다.<br>
	 * 
	 * @param RsltPropCopyVO rsltPropCopyVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyProposalMain(RsltPropCopyVO rsltPropCopyVO, SignOnUserAccount account) throws EventException{
        try {
            rsltPropCopyVO.setCreUsrId(account.getUsr_id());
            rsltPropCopyVO.setUpdUsrId(account.getUsr_id());
            rsltPropCopyVO.setOfcCd(account.getOfc_cd());
            rsltPropCopyVO.setSrepCd(account.getSrep_cd());
            // PRI_SP_HDR COPY
            dbDao.addCopyProposalHdr(rsltPropCopyVO);

            // PRI_SP_MN COPY
            dbDao.addCopyProposalMain(rsltPropCopyVO);
            
            // PRI_SP_AMDT_SMRY
            PriSpAmdtSmryVO priSpAmdtSmryVO = new PriSpAmdtSmryVO();
            priSpAmdtSmryVO.setPropNo(rsltPropCopyVO.getNewPropNo());
            priSpAmdtSmryVO.setAmdtSeq("0");
            priSpAmdtSmryVO.setCreUsrId(account.getUsr_id());
            priSpAmdtSmryVO.setUpdUsrId(account.getUsr_id());
            dbDao.addProposalAmendmentSummary(priSpAmdtSmryVO);

            // PRI_SP_PROG
            dbDao.addCopyProposalProg(rsltPropCopyVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}

    /**
     * S/C Proposal Main Amendment Summary 를 수정합니다.<br>
     * 
     * @param PriSpAmdtSmryVO priSpAmdtSmryVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    public void manageProposalAmendmentSummaryAll(PriSpAmdtSmryVO priSpAmdtSmryVO, SignOnUserAccount account) throws EventException{
        try {
//            PriSpAmdtSmryVO priSpAmdtSmryVO = null;
            priSpAmdtSmryVO.setUpdUsrId(account.getUsr_id());
            CodeUtil cdUtil = CodeUtil.getInstance();
            ArrayList<CodeInfo> cdList =(ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD01737",0);
            
            for (int j = 0, m = cdList.size(); j < m; j++) {
                priSpAmdtSmryVO.setPropTermTpCd(cdList.get(j).getCode());
                dbDao.modifyProposalAmendmentSummary(priSpAmdtSmryVO);
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
     * S/C Proposal Copy 시 새로운 Proposal Number 를 조회합니다.<br>
     * 
     * @param SignOnUserAccount account
     * @return String
     * @exception EventException
     */
    public String searchMaxPropNo (SignOnUserAccount account) throws EventException {
        try {
            return dbDao.searchCreationProposalNo(account.getOfc_cd());
        } catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
    }
	//------------------JIN END---------------------------------------
    
	/**
     * Terms의 Summary 정보를 조회 합니다.<br>
	 * 
	 * @param PriSpAmdtSmryVO priSpAmdtSmryVO
	 * @return List<RsltPropAmdtSmryVO>
	 * @exception EventException
	 */
	
	public List<RsltPropAmdtSmryVO> searchProposalAmendmentSummary(PriSpAmdtSmryVO priSpAmdtSmryVO) throws EventException {
		try {
			return dbDao.searchProposalAmendmentSummary(priSpAmdtSmryVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
     * Scope Terms의 Summary 정보를 조회 합니다.<br>
	 * 
	 * @param PriSpScpAmdtSmryVO priSpScpAmdtSmryVO
	 * @return List<RsltPropScpAmdtSmryVO>
	 * @exception EventException
	 */
	
	public List<RsltPropScpAmdtSmryVO> searchProposalScopeAmendmentSummary(PriSpScpAmdtSmryVO priSpScpAmdtSmryVO) throws EventException {
		try {
			return dbDao.searchProposalScopeAmendmentSummary(priSpScpAmdtSmryVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}    

    /**
     * S/C Proposal Scope 정보를 Copy 합니다.<br>
     * 
     * @param RsltPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeMain(RsltPropCopyVO vo, SignOnUserAccount account) throws EventException{
        try {
            vo.setCreUsrId(account.getUsr_id());
            vo.setUpdUsrId(account.getUsr_id());
            vo.setOfcCd(account.getOfc_cd());
            // PRI_SP_SCP_MN COPY
            dbDao.addCopyProposalScopeMain(vo);
            
            List<PriSpScpProgVO> progList = new ArrayList<PriSpScpProgVO>();
            PriSpScpProgVO scpVo = new PriSpScpProgVO();
            scpVo.setPropNo(vo.getNewPropNo());
            scpVo.setAmdtSeq("0");
            scpVo.setSvcScpCd(vo.getSvcScpCd());
            scpVo.setPropScpStsCd("I");
            scpVo.setProgUsrId(account.getUsr_id());
            scpVo.setProgOfcCd(account.getOfc_cd());
            scpVo.setCreUsrId(account.getUsr_id());
            scpVo.setUpdUsrId(account.getUsr_id());
            progList.add(scpVo);
            
            // PRI_SP_SCP_PROG
            dbDao.addProposalScopeProgress(progList);
            
            List<PriSpScpAmdtSmryVO> smryList = new ArrayList<PriSpScpAmdtSmryVO>();
            PriSpScpAmdtSmryVO smVo = new PriSpScpAmdtSmryVO();
            smVo.setPropNo(vo.getNewPropNo());
            smVo.setAmdtSeq("0");
            smVo.setSvcScpCd(vo.getSvcScpCd());
            smVo.setCreUsrId(account.getUsr_id());
            smVo.setUpdUsrId(account.getUsr_id());
            smryList.add(smVo);
            
            // PRI_SP_SCP_AMDT_SMRY INSERT
            dbDao.addProposalScopeAmendmentSummary(smryList);
            
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
        }
    }

    /**
     * Proposal Scope Amendment Summary 데이터를 저장합니다.<br>
     * 
     * @param RsltPropCopyVO[] vos
     * @param SignOnUserAccount account
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    public void copyProposalScopeAmdtSmry(RsltPropCopyVO[] vos, SignOnUserAccount account) throws EventException{
        try {
//            List<PriSpScpAmdtSmryVO> updateVoList = new ArrayList<PriSpScpAmdtSmryVO>();
            PriSpScpAmdtSmryVO smVo = new PriSpScpAmdtSmryVO();
            
            CodeUtil cdUtil = CodeUtil.getInstance();
            ArrayList<CodeInfo> cdList =(ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD01738",0);
            
            for (int i = 0, n = vos.length; i < n; i++) {
                for (int j = 0, m = cdList.size(); j < m; j++) {
                    smVo = new PriSpScpAmdtSmryVO();
                    smVo.setPropNo(vos[i].getNewPropNo());
                    smVo.setAmdtSeq("0");
                    smVo.setSvcScpCd(vos[i].getSvcScpCd());
                    smVo.setPropScpTermTpCd(cdList.get(j).getCode());
                    smVo.setUpdUsrId(account.getUsr_id());
                    dbDao.modifyProposalScopeAmendmentSummary(smVo);
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
     * Guideline Copy 대상 정보를 조회합니다.<br>
     * 
     * @param SpScpGlineCopyVO spScpGlineCopyVO
     * @return List<SpScpGlineCopyVO>
     * @exception EventException
     */
    public List<SpScpGlineCopyVO> searchGuidelineCopyCheck(SpScpGlineCopyVO spScpGlineCopyVO) throws EventException {
        try {
            return dbDao.searchGuidelineCopyCheck(spScpGlineCopyVO);
        } catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Copy 할 Guideline 의 gline_seq 를 조회합니다.<br>
     * 
     * @param SpScpGlineCopyVO spScpGlineCopyVO
     * @return String
     * @exception EventException
     */
    public String searchCopyGlineSeq(SpScpGlineCopyVO spScpGlineCopyVO) throws EventException {
        try {
            return dbDao.searchCopyGlineSeq(spScpGlineCopyVO);
        } catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Proposal Scope Main 의 note_hdr_seq 컬럼을 업데이트 합니다.<br>
     * 
     * @param SpScpGlineCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void modifyScpMnNoteHdrSeqGlineCopy (SpScpGlineCopyVO vo, SignOnUserAccount account) throws EventException {
        try {
            vo.setCreUsrId(account.getUsr_id());
            vo.setUpdUsrId(account.getUsr_id());
            
            dbDao.modifyScpMnNoteHdrSeqGlineCopy(vo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
        }
    }

    /**
     * Proposal Scope Amendment Summary 를 업데이트 합니다.<br>
     * 
     * @param SpScpGlineCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    public void copyScopeGuidelineScopeAmdtSmry(SpScpGlineCopyVO vo, SignOnUserAccount account) throws EventException{
        try {
//            List<PriSpScpAmdtSmryVO> updateVoList = new ArrayList<PriSpScpAmdtSmryVO>();
            PriSpScpAmdtSmryVO smVo = new PriSpScpAmdtSmryVO();
            
            CodeUtil cdUtil = CodeUtil.getInstance();
            ArrayList<CodeInfo> cdList =(ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD01738",0);
            
            for (int i = 0, m = cdList.size(); i < m; i++) {
                smVo = new PriSpScpAmdtSmryVO();
                smVo.setPropNo(vo.getPropNo());
                smVo.setAmdtSeq(vo.getAmdtSeq());
                smVo.setSvcScpCd(vo.getSvcScpCd());
                smVo.setPropScpTermTpCd(cdList.get(i).getCode());
                smVo.setUpdUsrId(account.getUsr_id());
//                updateVoList.add(smVo);
                dbDao.modifyProposalScopeAmendmentSummary(smVo);
            }

//            dbDao.modifyProposalScopeAmendmentSummary(updateVoList);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
        }
    }
    
	/**
     * Main의 상태를 Approve로 변경하기 위하여 Terms가 ACCEPT 되었는지 조회 합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @return List<PriSpMnVO>
	 * @exception EventException
	 */
	public List<PriSpMnVO> searchProposalAcceptCheck(PriSpMnVO priSpMnVO) throws EventException {
		try {
			return dbDao.searchProposalAcceptCheck(priSpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}    
	
	
	/**
     * Main의 상태를 조회한다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltMainStsVO>
	 * @exception EventException
	 */
	public List<RsltMainStsVO> searchProposalMainStatus(PriSpMnVO priSpMnVO) throws EventException {
		try {
			return dbDao.searchProposalMainStatus(priSpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	} 	
	
	
	/**
     * Scope상태를 Scope별로 변경 합니다.<br>
	 * 
	 * @param PriSpScpMnVO[] priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyScopeStatus(PriSpScpMnVO[] priSpScpMnVO, SignOnUserAccount account) throws EventException{
		try {
			List<PriSpScpMnVO> updateVoList = new ArrayList<PriSpScpMnVO>();
			List<PriSpScpProgVO> insertProgVoList =  new ArrayList<PriSpScpProgVO>(); 
			
			for ( int i=0; i<priSpScpMnVO .length; i++ ) {
				if ( priSpScpMnVO[i].getIbflag().equals("U")){
					priSpScpMnVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priSpScpMnVO[i]);
					PriSpScpProgVO vo = new PriSpScpProgVO();
					ObjectCloner.build(priSpScpMnVO[i], vo);
					vo.setProgOfcCd(account.getOfc_cd());	
					vo.setProgUsrId(account.getUsr_id());
					vo.setCreUsrId(account.getUsr_id());
					insertProgVoList .add(vo);					
				}
			}		
			
			if ( updateVoList.size() > 0 ) {				
				dbDao.modifymanageScopeStatus(updateVoList);
			}
			//pregress 변경		
			if ( insertProgVoList.size() > 0 ) {				
				dbDao.addProposalScopeProgress(insertProgVoList);
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
	 * Scope상태를   변경합니다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyAllScopeStatus(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException{
		try {				
			priSpScpMnVO.setUpdUsrId(account.getUsr_id());
			priSpScpMnVO.setPropScpStsCd("I");
			dbDao.modifymanageAllScopeStatus(priSpScpMnVO);
			
			PriSpScpProgVO vo = new PriSpScpProgVO();
			ObjectCloner.build(priSpScpMnVO, vo);
			vo.setProgOfcCd(account.getOfc_cd());
			vo.setProgUsrId(account.getUsr_id());
			vo.setPropScpStsCd("I");
			vo.setCreUsrId(account.getUsr_id());
			vo.setUpdUsrId(account.getUsr_id());
			dbDao.addProposalScopeProgressChange(vo);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}		
	
    /**
     * Proposal  Main 의 Status 컬럼을 업데이트 합니다.<br>
     * 
     * @param PriSpMnVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void modifyMainStatus (PriSpMnVO vo, SignOnUserAccount account) throws EventException {
        try {
            vo.setUpdUsrId(account.getUsr_id());
            
            dbDao.modifyMainStatus(vo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
        }
    }	
    
	/**
	 * TERMS가  모두 ACCEPT되었는지 확인 합니다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @return int
	 * @exception EventException
	 */
	public int searchProposalScopeAcceptCheck(PriSpScpMnVO  priSpScpMnVO) throws EventException {
		try {
			return dbDao.searchProposalScopeAcceptCheck(priSpScpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}        
	
	
	/**
	 * Scope의 상태를 조회 합니다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @return List<PriSpScpMnVO>
	 * @exception EventException
	 */
	public List<PriSpScpMnVO> searchProposalScopeStatusCheck(PriSpScpMnVO  priSpScpMnVO) throws EventException {
		try {
			return dbDao.searchProposalScopeStatusCheck(priSpScpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}      
	
	/**
	 * Scope이 삭제될 때 해당 Amend seq에 해당하는 모든 데이터를 삭제처리 합니다. <br>
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposalScopeAmdtSmry(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.removeProposalScopeAmdtSmry(priSpScpMnVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}		
	
	/**
	 * Init Cancel시 Amend seq에 해당하는 모든 데이터를 삭제처리 합니다. <br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposalAmdtSmry(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.removeProposalAmdtSmry(priSpMnVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}		
    
	/**
	 * Scope이 삭제될 때 해당 Amend seq에 해당하는 모든 데이터를 삭제처리 합니다. <br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposalScopeProgress(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.removeProposalScopeProgress(priSpScpMnVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}		
	
	/**
	 * Init Cancel시 Amend seq에 해당하는 모든 데이터를 삭제처리 합니다. <br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposalProgress(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.removeProposalProgress(priSpMnVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
	/**
	 * Init Cancel시 Amend seq에 해당하는 모든 데이터를 삭제처리 합니다. <br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposalScopeMain(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.removeProposalScopeMain(priSpScpMnVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	    
	/**
     * 이전에 File된 File Date와 현재 File Date를 조회 합니다. <br>
	 * 
	 * @param CstPriSpMnFileDtVO cstPriSpMnFileDtVO
	 * @param SignOnUserAccount account
	 * @return List<CstPriSpMnFileDtVO>
	 * @exception EventException
	 */
	public List<CstPriSpMnFileDtVO> searchProposalFilingList (CstPriSpMnFileDtVO cstPriSpMnFileDtVO, SignOnUserAccount account) throws EventException {
		try {
			cstPriSpMnFileDtVO.setPropOfcCd(account.getOfc_cd());
			return dbDao.searchProposalFilingList (cstPriSpMnFileDtVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}	
	
	
	/**
     * 해당 Proposal을 Filing 합니다.<br>
	 * 
	 * @param CstPriSpMnFileVO cstPriSpMnFileVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalFiling(CstPriSpMnFileVO cstPriSpMnFileVO, SignOnUserAccount account) throws EventException{
	
		try {			
            //이전 seq의 exp_dt를 자른다,status를 변경 합니다.
			List<PriSpMnVO > updateVoList = new ArrayList<PriSpMnVO >();
			List<PriSpProgVO> insertVoList = new ArrayList<PriSpProgVO>();	
			
//			cstPriSpMnFileVO.setUpdUsrId(account.getUpd_usr_id());		
			cstPriSpMnFileVO.setUpdUsrId(account.getUsr_id());
			cstPriSpMnFileVO.setPropStsCd("F");
			PriSpMnVO mnVO = new PriSpMnVO();
			ObjectCloner.build(cstPriSpMnFileVO, mnVO);
			updateVoList.add(mnVO);
			
			PriSpProgVO vo = new PriSpProgVO();
			vo.setAmdtSeq(cstPriSpMnFileVO.getAmdtSeq());
			vo.setPropNo(cstPriSpMnFileVO.getPropNo());
			vo.setPropStsCd("F");
			vo.setProgUsrId(account.getUsr_id());
			vo.setProgOfcCd(account.getOfc_cd());
			vo.setCreUsrId(account.getUsr_id());
			vo.setUpdUsrId(account.getUsr_id());
			insertVoList.add(vo);

			//기존 mn 에 대한 update
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyProposalMain(updateVoList);//status변경
				dbDao.addProposalProgress(insertVoList);
				//2009/12/15 - 변경 
				//사용자의 선택에 따라 eff_dt와 file_dt의 비교 없이 모두 변경한다.
				if (cstPriSpMnFileVO.getEffDtChg().equals("Y")){
					dbDao.modifyProposalMainFile(updateVoList);
					dbDao.modifyProposalScopeMainFile(updateVoList);
				}

			}
		
			//Filing 에서 이전 amdt_seq의 exp_dt를 자른다.
			dbDao.modifyProposalMainAmend(updateVoList);
			dbDao.modifyProposalScopeMainAmend(updateVoList);	

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
		
	}		
	
	/**
     * Proposal Scope List를 조회 합니다.<br>
	 * 
	 * @param PriSpHdrVO priSpHdrVO
	 * @param SignOnUserAccount account
	 * @return List<RsltPropMnScpListVO>
	 * @exception EventException
	 */
	public List<RsltPropMnScpListVO> searchProposalMainScpList(PriSpHdrVO priSpHdrVO, SignOnUserAccount account) throws EventException {
		try {
			return dbDao.searchProposalMainScpList (priSpHdrVO, account);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
     * C/offer를 실행 하기 위하여 Terms에 Init인 데이터가 있는지 조회합니다. <br>
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltStatusVO>
	 * @exception EventException
	 */
	public List<RsltStatusVO> searchCountOfferStatus(PriSpMnVO priSpMnVO) throws EventException {
		try {
			return dbDao.searchCountOfferStatus(priSpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}		
	
			
	
	/**
	 * Scope삭제시 Terms의 데이터가 있는지 확인 합니다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
     * @return int
	 * @exception EventException
	 */
	public int searchProposalScopeDeleteCheck(PriSpScpMnVO  priSpScpMnVO) throws EventException {
		try {
			return dbDao.searchProposalScopeDeleteCheck(priSpScpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}   
	
	/**
     * S/C Number를 저장 합니다.<br>
	 * 
	 * @param PriSpHdrVO priSpHdrVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createaProposalSCNumber (PriSpHdrVO priSpHdrVO, SignOnUserAccount account) throws EventException{
		try {
			List<PriSpHdrVO> updateVoList = new ArrayList<PriSpHdrVO>();

			priSpHdrVO.setCreUsrId(account.getUsr_id());
			priSpHdrVO.setUpdUsrId(account.getUsr_id());

			updateVoList.add(priSpHdrVO);
		
			dbDao.modifyProposalHeader(updateVoList);
			
	} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
	
    /**
     * S/C Number를 저장하기 전에 중복 여부를 조회 합니다.  <br>
     * 
     * @param PriSpHdrVO priSpHdrVO
     * @return List<PriSpHdrVO>
     * @exception EventException
     */
    public List<PriSpHdrVO> checkProposalSCNumber (PriSpHdrVO priSpHdrVO) throws EventException {
        try {
            return dbDao.searchCheckProposalSCNumber(priSpHdrVO);
        } catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
    }	
    /**
     * 유효한 S/C Number PreFix인지 조회 합니다. <br>
     * 
     * @param CstPriSpHdrVO cstPriSpHdrVO
     * @return List<CstPriSpHdrVO>
     * @exception EventException
     */
    public List<CstPriSpHdrVO> checkProposalPreFixNumber (CstPriSpHdrVO cstPriSpHdrVO) throws EventException {
        try {
            return dbDao.searchCheckProposalPreFixNumber(cstPriSpHdrVO);
        } catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
    }    
    
	/**
     * Reqeust 시 필수 입력 데이터를 조회 합니다<br>
	 * @param PriSpMnVO priSpMnVO
	 * @return List<CstRequestCheckVO>
	 * @exception EventException
	 */
	public List<CstRequestCheckVO> searchRequestTermsCheck(PriSpMnVO priSpMnVO) throws EventException {
		try {
			return dbDao.searchRequestTermsCheck(priSpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	
	/**
     * Reqeust 시 Calcualte를 하지 않은 scope를 조회 합니다<br>
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @return List<RequestCheckForCalculationVO>
	 * @exception EventException
	 */
	public List<RequestCheckForCalculationVO> searchRequestCheckCalculate(PriSpScpMnVO priSpScpMnVO) throws EventException {
		try {
			return dbDao.searchRequestCheckCalculate(priSpScpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Init Cancel시 모든 데이터를 삭제처리 합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposal(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.removeProposal(priSpMnVO);
//			log.debug("priSpMnVO.getAmdtSeq()==================="+priSpMnVO.getAmdtSeq());
			if (priSpMnVO.getAmdtSeq().equals("0")){
				dbDao.removeProposalHdr(priSpMnVO);
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
     * Proposal이거나 Filing시 filing Date가 더 늦을 경우 Expire Date를 변경 합니다.<br>
	 * 
	 * @param PriSpScpDurVO priSpScpDurVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalTerms(PriSpScpDurVO priSpScpDurVO, SignOnUserAccount account) throws EventException{
		try {

			if (priSpScpDurVO != null  ) {
				priSpScpDurVO.setUpdUsrId(account.getUsr_id());					
			}

			dbDao.modifyProposalTerms (priSpScpDurVO);

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
	
	/**
     * filing 시 이전 amend 차수의 exp_dt를 변경 합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyProposalPreTerms(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException{
		try {

			if (priSpMnVO != null  ) {
				priSpMnVO.setUpdUsrId(account.getUsr_id());					
			}

			dbDao.modifyProposalMainPreTerms (priSpMnVO);
			dbDao.modifyProposalScopePreTerms (priSpMnVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
	
	/**
     * MAIN의  Expire Date를 변경 합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalMainExpiry(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException{
		try {

			if (priSpMnVO != null  ) {
				priSpMnVO.setUpdUsrId(account.getUsr_id());	
				
				dbDao.modifyProposalMainExpiry (priSpMnVO);
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
	 * Proposal의 상태가 Init이고 Initial상태를 Cancel 할 경우 Main Expire Date를 수정 합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalMainExpiryCancel(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException{
		try {
			int amdtSeq = 0;
			
			if (priSpMnVO != null  ) {
				priSpMnVO.setUpdUsrId(account.getUsr_id());	
				PriSpMnVO vo = new PriSpMnVO();
				ObjectCloner.build(priSpMnVO, vo);
				amdtSeq = Integer.parseInt(vo.getAmdtSeq()) -1 ;				
				vo.setAmdtSeq(String.valueOf(amdtSeq));
				vo.setPropStsCd("F");
				dbDao.modifyProposalMainExpiry (vo);
//				log.debug("manageProposalMainExpiryCancel==PriSpMnVO amdtseq"+ priSpMnVO.getAmdtSeq());
//				log.debug("manageProposalMainExpiryCancel==vo amdtseq"+ vo.getAmdtSeq());
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
     * Duration 변경시 Scope MAIN의  Expire Date를 변경 합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalScopeMainExpiry(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException{
		try {

			if (priSpMnVO != null  ) {
				priSpMnVO.setUpdUsrId(account.getUsr_id());	
				dbDao.modifyProposalScopeMainExpiry (priSpMnVO);
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
	 * Proposal의 상태가 Init이고 Initial상태를 Cancel 할 경우 Scope Main Expire Date를 수정 합니다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalScopeMainExpiryCancel(PriSpScpMnVO priSpScpMnVO,SignOnUserAccount account) throws EventException{
		try {
			int amdtSeq = 0;
			if (priSpScpMnVO != null  ) {
				priSpScpMnVO.setUpdUsrId(account.getUsr_id());	
				PriSpScpMnVO vo = new PriSpScpMnVO();
				ObjectCloner.build(priSpScpMnVO, vo);
				amdtSeq = Integer.parseInt(vo.getAmdtSeq()) -1 ;				
				vo.setAmdtSeq(String.valueOf(amdtSeq));
				dbDao.modifyProposalScopeMainExpiryChange (vo);
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
     * 추가 할 S/C Number를 조회합니다.<br>
	 * @param CstPriSpHdrVO cstPriSpHdrVO
	 * @return List<CstPriSpHdrVO>
	 * @exception EventException
	 */
	public List<CstPriSpHdrVO> searchProposalSCNumberMain(CstPriSpHdrVO cstPriSpHdrVO) throws EventException {
		try {
			CstPriSpHdrVO vo = new CstPriSpHdrVO();
			List<CstPriSpHdrVO> rVo = new ArrayList<CstPriSpHdrVO>();
			vo.setScNo("");
			List<CstPriSpHdrVO> list1 = dbDao.searchProposalSCNumberMain(cstPriSpHdrVO);
			if (list1 != null && list1.size() > 0){
				vo.setScNo(list1.get(0).getScNo()) ;
			}
//			if (vo.getScNo().equals("")){
//				List<CstPriSpHdrVO> list2 = dbDao.searchProposalMaxSCNumberMain(cstPriSpHdrVO);
//				if (list2 != null && list2.size() > 0){
//					vo.setScNo(list2.get(0).getScNo()) ;
//				}
//			}
						
			rVo.add(vo);
			return rVo;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}		
	
	/**
	 * Terms중 하나라도 Returned 가 있다면 Scope의 상태를 Returned로 변경 합니다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void changeAutoScopeReturnStatus(PriSpScpMnVO priSpScpMnVO,SignOnUserAccount account) throws EventException{
		try {
			List<PriSpScpProgVO> insertProgVoList =  new ArrayList<PriSpScpProgVO>(); 
			if (priSpScpMnVO != null  ) {
				priSpScpMnVO.setUpdUsrId(account.getUsr_id());	
				dbDao.modifyAutoScopeReturnStatus (priSpScpMnVO);
				
				if (dbDao.searchScopeProgressStatus(priSpScpMnVO) == 0){
					//prog와 Mn의 상태가 다르다면 prog에 insert
					PriSpScpProgVO vo = new PriSpScpProgVO();
					ObjectCloner.build(priSpScpMnVO, vo);
					vo.setProgOfcCd(account.getOfc_cd());	
					vo.setProgUsrId(account.getUsr_id());
					vo.setCreUsrId(account.getUsr_id());
					insertProgVoList .add(vo);	
					if ( insertProgVoList.size() > 0 ) {				
						dbDao.addProposalScopeProgressScopeMn(insertProgVoList);
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
     * S/C Proposal Master 를 Proposal에 적용합니다.<br>
     * 
     * @param PriSpHdrVO priSpHdrVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void confirmMasterProposal(PriSpHdrVO priSpHdrVO, SignOnUserAccount account) throws EventException{
        try {
        	priSpHdrVO.setUpdUsrId(account.getUsr_id());
            dbDao.modifyConfirmMasterProposal(priSpHdrVO);
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
        } catch (Exception de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
        }
    }

	/**
	 * Proposal Main의 Boiler Plate Header Seq를 변경 합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalMainBoilerPlateSeq(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException{
		try {
			List<PriSpMnVO> updateVoList = new ArrayList<PriSpMnVO>();
			
			if (priSpMnVO != null  ) {
				priSpMnVO.setUpdUsrId(account.getUsr_id());	
				if (priSpMnVO.getBlplHdrSeq().equals("")){
					priSpMnVO.setBlplHdrSeq("XX");
				}
				
				updateVoList.add(priSpMnVO);
				
				dbDao.modifyProposalMain (updateVoList);
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
	 * DURATION 변경시  SCOPE MAIN  Expire Date를 수정 합니다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void changeProposalScopeMainExpiry(PriSpScpMnVO priSpScpMnVO,SignOnUserAccount account) throws EventException{
		try {

			if (priSpScpMnVO != null  ) {
				priSpScpMnVO.setUpdUsrId(account.getUsr_id());	
				dbDao.modifyProposalScopeMainExpiryChange (priSpScpMnVO);
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
     * S/C Master 생성 시 S/C Number의 중복여부를 체크합니다.<br>
     * 
     * @param PriSpHdrVO priSpHdrVO
     * @return boolean
     * @exception EventException
     */
    public boolean checkScNumberDup(PriSpHdrVO priSpHdrVO) throws EventException {
        try {
            return dbDao.searchCheckScNumberDup(priSpHdrVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
    }

    /**
     * S/C Master 생성 시 S/C Number Prefix의 정합성을 체크합니다.<br>
     * 
     * @param ChkScNoVO chkScNoVO
     * @return String
     * @exception EventException
     */
    public String checkScNumberPrefix(ChkScNoVO chkScNoVO) throws EventException {
        try {
            return dbDao.searchCheckScNumberPrefix(chkScNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
    }

    /**
     * Sales Lead Contract Info를 CRM으로 전송합니다.<br>
     * 
     * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void transferScSalesLeadContractInfo(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException{
        try {
            List<ScSlsLdCtrtInfoVO> list = dbDao.searchScSalesLeadContractInfo(priSpMnVO);
            if (list != null && list.size() > 0) {
                SCProposalMainEAIDAO eaiDao = new SCProposalMainEAIDAO();
                eaiDao.transferScSalesLeadContractInfo(list.get(0));
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
	 * c/offer 이 있는 terms 에서 returned 인 데이터를 조회합니다.<br>
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltReturnVO>
	 * @exception EventException
	 */
	public List<RsltReturnVO> searchProposalReturnedList(PriSpMnVO priSpMnVO) throws EventException {
		try {
			return dbDao.searchProposalReturnedList(priSpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}	
	
    /**
     * Proposal  Main 의 Status 컬럼을 Returned에서 Request로 업데이트 합니다.<br>
     * 
     * @param PriSpMnVO vo
     * @param SignOnUserAccount account
     * @return int
     * @exception EventException
     */
    public int changeAutoRequestMainStatus (PriSpMnVO vo, SignOnUserAccount account) throws EventException {
        int result = 0;
    	try {
            vo.setUpdUsrId(account.getUsr_id());            
            result = dbDao.modifyAutoChangeMainStatus(vo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
        return result;
    }		
    
	/**
	 * Approve 시 validation 을 하기 위해 DEM/DET Exception의 Status를 가져온다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchCheckDmdtList(PriSpMnVO priSpMnVO) throws EventException {
		try {
			log.debug("searchCheckDmdtList=======================bc ");
			return dbDao.searchCheckDmdtList(priSpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	} 
	
	/**
	 * Approve 시 validation 을 하기 위해 CHSS Exception의 Status를 가져온다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchCheckChssList(PriSpMnVO priSpMnVO) throws EventException {
		try {
			log.debug("searchCheckChssList=======================bc ");
			return dbDao.searchCheckChssList(priSpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Amend History Main정보를 조회합니다.<br>
	 * 
	 * @param PriSpHdrVO priSpHdrVO
	 * @return List<RsltPriSpAmdHstMnVO>
	 * @exception EventException
	 */
	public List<RsltPriSpAmdHstMnVO> searchAmendmentHistoryMain(PriSpHdrVO priSpHdrVO) throws EventException {
		try {
			
			return dbDao.searchAmendmentHistoryMain(priSpHdrVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}   	
	
	/**
	 * Amend History Scope List 정보를 조회합니다.<br>
	 * 
	 * @param CstShHistVO CstShHistVO
	 * @return List<RsltAmdtHisMnVO>
	 * @exception EventException
	 */
	public List<RsltAmdtHisMnVO> searchAmendmentHistoryList(CstShHistVO cstShHistVO) throws EventException {
		try {
			log.debug("cstShHistVO.getConvFlg()==bc=="+cstShHistVO.getConvFlg());
			return dbDao.searchAmendmentHistoryList(cstShHistVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	} 	
	
	/**
	 * Amend 된 Terms를 조회 합니다.
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltPropScpAmdtSmryVO>
	 * @exception EventException
	 */	
	public List<RsltPropScpAmdtSmryVO> searchHistoryAmendTermList(PriSpMnVO priSpMnVO) throws EventException {
		try {
			return dbDao.searchHistoryAmendTermList(priSpMnVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}   
	/**
	 * Proposal No.에 해당 하는 모든 Scope 을 조회 합니다.
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */	
	public List<RsltCdListVO> searchHistoryScopeList(PriSpMnVO priSpMnVO) throws EventException {
		try {
			return dbDao.searchHistoryScopeList(priSpMnVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	} 	
	
	/**
     * 각 Terms에 수정된 정보가 있는 지 조회 합니다.<br>
	 * 레거시 데이터일 경우 데이터가 있는지 조회합니다.<br>
	 * @param CstShHistVO cstShHistVO
	 * @return List<RsltPropScpAmdtSmryVO>
	 * @exception EventException
	 */
	public List<RsltPropScpAmdtSmryVO> searchAmendmentHistorySummary(CstShHistVO cstShHistVO) throws EventException {
		try {
			log.debug("searchAmendmentHistorySummary=========svcscpcd======"+cstShHistVO.getSvcScpCd());
			if (cstShHistVO.getLgcyIfFlg().equals("Y")){ //레거시데이터
				return dbDao.searchAmendmentHistoryLgcy(cstShHistVO);
			}else{
				return dbDao.searchAmendmentHistorySummary(cstShHistVO);
			}
			
			
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}

	/**
     * Filing시 main,scope에서 validation하기 위하여 입력한 file date 보다 <br>
	 * duration Expire Date가 작거나 같은 Scope을 조회 합니다. <br>
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltExpChkVO>
	 * @exception EventException
	 */
	public List<RsltExpChkVO> searchExpireDateCheck(PriSpMnVO priSpMnVO) throws EventException {
		try {
			return dbDao.searchExpireDateCheck(priSpMnVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}
	
	
	/**
	 * Filing Save 버튼 컨트롤 시 FMC confirm date를 확인한다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchFmcConfirmDateCheck(PriSpMnVO priSpMnVO) throws EventException {
		try {
			log.debug("searchFmcConfirmDateCheck=======================bc ");
			return dbDao.searchFmcConfirmDateCheck(priSpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Filing C/T 버튼 컨트롤 시 FMC confirm date를 확인한다. (48시간 이내인지)<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchCorrectionLimitCheck(PriSpMnVO priSpMnVO) throws EventException {
		try {
			log.debug("searchCorrectionLimitCheck=======================bc ");
			return dbDao.searchCorrectionLimitCheck(priSpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * S/C메인화면의 Filing C/T 버튼 가능한 시간을 조회 한다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchCorrectionLimitTime(PriSpMnVO priSpMnVO) throws EventException {
		try {
			log.debug("searchCorrectionLimitTime=======================bc ");
			return dbDao.searchCorrectionLimitTime(priSpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Filing C/T 버튼 클릭 시 최초 FMC confirm date를 확인한다. (최초 filing 후 48시간 이내인지)<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchInitFileDtCheck(PriSpMnVO priSpMnVO) throws EventException {
		try {
			log.debug("searchInitFileDtCheck=======================bc ");
			return dbDao.searchInitFileDtCheck(priSpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 *Sale Lead 를 조회 합니다.<br>
	 * 
	 * @param SchSaleLeadVO schSaleLeadVO
	 * @return List<RsltPriCrmSlLdVO>
	 * @exception EventException
	 */
	public List<RsltPriCrmSlLdVO> searchProposalMainSaleLeadList (SchSaleLeadVO schSaleLeadVO) throws EventException {
		try {
			return dbDao.searchProposalMainSaleLeadList (schSaleLeadVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}

	/**
	 * Proposal & Amendment Search List 를 조회 합니다.<br>
	 * 
	 * @param CstShInqVO cstShInqVO
	 * @return List<RsltPriSpInqVO>
	 * @exception EventException
	 */
	public List<RsltPriSpInqVO> searchProposalMainInquiryList(CstShInqVO cstShInqVO) throws EventException {
		try {
			log.debug("searchProposalMainInquiryList====cstShInqVO="+ cstShInqVO.getSprcCtrtCustTpCd());
			return dbDao.searchProposalMainInquiryList (cstShInqVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}

	/**
	 * Proposal & Amendment 정보를 조회 합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @return RsltPropInqListVO
	 * @exception EventException
	 */
	public RsltPropInqListVO searchProposalMainInquiry(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException {
		try {
			RsltPropInqListVO vo = new RsltPropInqListVO();
			vo.setRsltPropMnInqVOs(dbDao.searchProposalMainInquiry(priSpMnVO));
			vo.setRsltPropMnScpInqListVOs(dbDao.searchProposalMainScpInquiryList(priSpMnVO));	

			return vo;
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}

	/**
     * Customer 정보를 조회 합니다.<br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @return List<RsltPropCustInfoVO>
	 * @exception EventException
	 */
	public List<RsltPropCustInfoVO> searchProposalCustomerInfoInquiry(PriSpCtrtPtyVO priSpCtrtPtyVO) throws EventException {
		try {
			return dbDao.searchProposalCustomerInfoInquiry(priSpCtrtPtyVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}

	/**
	 * Summry 테이블에서 terms의 데이터가 수정 되었는지 조회한다.<br>
	 * 
	 * @param priSpScpAmdtSmryVO PriSpScpAmdtSmryVO
	 * @return List<RsltPropScpAmdtSmryVO>
	 * @exception EventException
	 */
	public List<RsltPropScpAmdtSmryVO> searchProposalScopeAmendmentSummaryInquiry(PriSpScpAmdtSmryVO priSpScpAmdtSmryVO) throws EventException {
		try {
			return dbDao.searchProposalScopeAmendmentSummaryInquiry(priSpScpAmdtSmryVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}

    /**
     * Custmoer Type이 변경된 경우 Commodity Group,Rate,Standard Note의 데이터를 조회 합니다.<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @return List<RsltCdListVO>
     * @exception EventException
     */
	public List<RsltCdListVO> searchProposalMainCustTypeChkList(PriSpMnVO priSpMnVO) throws EventException {
		try {
			log.debug("searchProposalMainCustTypeChkList=======================bc ");
			return dbDao.searchProposalMainCustTypeChkList(priSpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * COPY TO PROPOSAL BASE<br>
	 * Proposal Copy 를 위한 기본 정보들을 copy 한다. 
	 * 
	 * @param RsltCopyToProposalVO rsltCopyToProposalVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyToProposalBase(RsltCopyToProposalVO rsltCopyToProposalVO, SignOnUserAccount account) 
		throws EventException{
		try {
			rsltCopyToProposalVO.setCreUsrId(account.getUsr_id());
			rsltCopyToProposalVO.setUpdUsrId(account.getUsr_id());
			//office
			rsltCopyToProposalVO.setQttnOfcCd(account.getOfc_cd());
			
			int chk = 0;
			
			//PRI_SP_HDR
			chk = dbDao.addCopyToProposalSpHeader(rsltCopyToProposalVO);
			if (chk < 1) {
				throw new EventException(new ErrorHandler("PRI03016").getMessage());
			}
			//PRI_SP_MN
			chk = dbDao.addCopyToProposalSpMain(rsltCopyToProposalVO);
			if (chk < 1) {
				throw new EventException(new ErrorHandler("PRI03016").getMessage());
			}
			//PRI_SP_AMDT_SMRY
			chk = dbDao.addCopyToProposalSpAmdtSmry(rsltCopyToProposalVO);
			if (chk < 1) {
				throw new EventException(new ErrorHandler("PRI03016").getMessage());
			}
			//PRI_SP_CTRT_CUST_TP
			chk = dbDao.addCopyToProposalSpProg(rsltCopyToProposalVO);
			if (chk < 1) {
				throw new EventException(new ErrorHandler("PRI03016").getMessage());
			}
			//PRI_SP_SCP_MN
			chk = dbDao.addCopyToProposalSpScpMn(rsltCopyToProposalVO);
			if (chk < 1) {
				throw new EventException(new ErrorHandler("PRI03016").getMessage());
			}
			//PRI_SP_SCP_AMDT_SMRY
			chk = dbDao.addCopyToProposalSpScpAmdtSmry(rsltCopyToProposalVO);
			if (chk < 1) {
				throw new EventException(new ErrorHandler("PRI03016").getMessage());
			}
			//PRI_SP_SCP_PROG
			chk = dbDao.addCopyToProposalSpScpProg(rsltCopyToProposalVO);
			if (chk < 1) {
				throw new EventException(new ErrorHandler("PRI03016").getMessage());
			}
		} catch(EventException ex) {
			throw ex;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}

    /**
     * S/C General Information 을 EDI 로 전송합니다.<br>
     * 
     * @param PriEdiScGenInfVO priEdiScGenInfVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void transferScGeneralInfo (PriEdiScGenInfVO priEdiScGenInfVO, SignOnUserAccount account) throws EventException {
        try {
            List<PriEdiScGenInfVO> list = dbDao.searchScGeneralInfo(priEdiScGenInfVO);
            if (list != null && list.size() > 0) {
                SCProposalMainEAIDAO eaiDao = new SCProposalMainEAIDAO();
                eaiDao.transferScGeneralInfo(list.get(0));
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
	 * Guideline Standard Note 정보 COPY시 HEADER SEQ정보를 수정 합니다.<br>
	 * 
	 * @param PriSpScpNoteListVO priSpScpNoteListVO
	 * @param String isCopy
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyNoteHeaderSeq(PriSpScpNoteListVO priSpScpNoteListVO, String isCopy, SignOnUserAccount account) throws EventException{		
		try {
			priSpScpNoteListVO.setCreUsrId(account.getUsr_id());
			priSpScpNoteListVO.setUpdUsrId(account.getUsr_id());
			if(priSpScpNoteListVO != null){
				dbDao.modifyProposalNoteHeaderSequence (priSpScpNoteListVO, isCopy);
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Performance를 조회하기 위해 BackEndJob을 실행한다.<br>
     *
	 * @param SignOnUserAccount account
	 * @param PriSpMnVO priSpMnVO
	 * @return String
	 * @exception EventException
	 */
	public String searchSCPerformanceDoStart(SignOnUserAccount account, PriSpMnVO priSpMnVO) throws EventException {
		SearchSCPerformanceBackEndJob searchSCPerformanceBackEndJob = new SearchSCPerformanceBackEndJob();
		searchSCPerformanceBackEndJob.setPerfromanceVO(account, priSpMnVO);
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		try {
			return backEndJobManager.execute(searchSCPerformanceBackEndJob, account.getUsr_id(), "ESM_PRI_0003 - Search");
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}	
	
	/**
	 * BackEndJob의 상태값을 조회한다.<br>
	 * 
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String comBakEndJbVOs(String key) throws EventException {
		DBRowSet rowSet;
		try {
			rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			rowSet.next();
			Thread.sleep(1000);
			return (String) rowSet.getObject("jb_sts_flg");
		} catch (BackEndJobException e) {
			throw new EventException(e.getMessage());
		} catch (SQLException e) {
			throw new EventException(e.getMessage());
		} catch (InterruptedException e) {
			throw new EventException(e.getMessage());
		} catch(Exception e){
			throw new EventException(e.getMessage());
		}
	}	
	
    /**
     * PRS CM Data를 조회합니다.<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @return List<RsltPRSCMDataVO>
     * @exception EventException
     */
	public List<RsltPRSCMDataVO> searchProposalMainPRSCMData(PriSpMnVO priSpMnVO) throws EventException {
		try {
			return dbDao.searchProposalMainPRSCMData (priSpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
    /**
     * Conversion Flag를 수정합니다.<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account 
     * @exception EventException
     */
    public void changeConversionFlg (PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException{
		try {
			if (priSpMnVO != null  ) {
				priSpMnVO.setUpdUsrId(account.getUsr_id());	
				dbDao.modifyProposalMainConversionFlg (priSpMnVO);
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
	 * Init Cancel시 validation 을 하기 위해 DEM/DET 의 데이터를 조회한다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchProposalMainInitCancelCheck(PriSpMnVO priSpMnVO) throws EventException {
		try {
			log.debug("searchProposalMainInitCancelCheck=======================bc ");
			return dbDao.searchProposalMainInitCancelCheck(priSpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Init Cancel시 validation 을 하기 위해 CHSS의 데이터를 조회한다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchProposalMainInitCancelChssCheck(PriSpMnVO priSpMnVO) throws EventException {
		try {
			log.debug("searchProposalMainInitCancelChssCheck=======================bc ");
			return dbDao.searchProposalMainInitCancelChssCheck(priSpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 *  1회차 이상의 Amend proposal init Cancel시 validation 을 하기 위해 CHSS 의 데이터를 조회한다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchProposalMainInitCancelChssEffDtCheck(PriSpMnVO priSpMnVO) throws EventException {
		try {
			log.debug("searchProposalMainInitCancelChssEffDtCheck=======================bc ");
			return dbDao.searchProposalMainInitCancelChssEffDtCheck(priSpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 *  Request 시 TPE Scope Destination에 Block하는 location이 있는지 체크한다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchProposalRouteCheck(PriSpMnVO priSpMnVO) throws EventException {
		try {
			log.debug("searchProposalRouteCheck=======================bc ");
			return dbDao.searchProposalRouteCheck(priSpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 *  Request 시 Affiliate type code 가 중복이 되는지 체크한다. <br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchAffiliateTypeDupCheck(PriSpMnVO priSpMnVO) throws EventException {
		try {
			return dbDao.searchAffiliateTypeDupCheck(priSpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * Proposal No., Amend Seq 에 해당 하는 Scope 을 조회 합니다.
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */	
	public List<RsltCdListVO> searchScopeList(PriSpMnVO priSpMnVO) throws EventException {
		try {
			return dbDao.searchScopeList(priSpMnVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	} 	
	
	
	/**
	 * S/C Scope Main 정보를 삭제합니다.<br>
	 * 
	 * @param ScPropMnVO scPropMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRemove(ScPropMnVO scPropMnVO, SignOnUserAccount account) throws EventException{
		try {
			PriSpScpMnVO[] scpVo = scPropMnVO.getPriSpScpMnVOs();
			List<PriSpScpMnVO> deleteScpVoList = new ArrayList<PriSpScpMnVO>();
			for ( int i = 0; scpVo != null && i < scpVo.length; i++ ) {
				if ( scpVo[i].getIbflag().equals("D")){
					deleteScpVoList.add(scpVo[i]);
				}
			}
			// 기존 scp mn 이 delete ( 관련 하위 데이터 삭제 ) 
			if ( deleteScpVoList.size() > 0 ) {				
				dbDao.removeProposalScopeAmdtSmry(deleteScpVoList);
				dbDao.removeProposalScopeProgress(deleteScpVoList);
				dbDao.removeProposalScopeMain(deleteScpVoList);
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
	 * ETL Batch를 비동기 적으로 실행킨다.<br>
	 * 
	 * @param String propNo
	 * @param String amdtNo
	 * @param String opCd
	 * @exception EventException
	 */
	public void receiveNISProposalInfo(String propNo, String amdtNo, String opCd) throws EventException {
		try {

			dbDao.manageETLInProcessLog(propNo, amdtNo, opCd);

		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}		
	}
	
    /**
     * Rate Save시, Scope Main의 PRS Calc 관련 테이블을 업데이트한다.<br>
     * 
     * @param PriSpScpMnVO priSpScpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void updatePrsCalcFlgOnSaveRt(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException {
		try {
			if (priSpScpMnVO != null) {
				priSpScpMnVO.setUpdUsrId(account.getUsr_id());	
				dbDao.modifyPrsCalcFlgOnSaveRt(priSpScpMnVO);
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
     * Reqeust Cancel 시 Accept, Returned 데이터가 있는지 조회한다.<br>
     * @param PriSpMnVO priSpMnVO
     * @return List<CstRequestCheckVO>
     * @exception EventException
     */
	public List<CstRequestCheckVO> searchProposalRequestCancelCheck(PriSpMnVO priSpMnVO) throws EventException {
		try {
			return dbDao.searchProposalRequestCancelCheck(priSpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}    
    
    /**
     * Request 시 Group Ware Main 을 PopUp 하기 위한 조건을 조회한다.<br>
     * Request Cancel을 한번이라도 했다면 다음번 Request 시 Group Ware Main을 PopUp하지 않는다.<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @return List<RsltCdListVO>
     * @exception EventException
     */
    public List<RsltCdListVO> searchProgRequestList(PriSpMnVO priSpMnVO) throws EventException {
		try {
			return dbDao.searchProgRequestList(priSpMnVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	} 	
    
    
    /**
     * MQC estimate 를 저장 하지 않는것이 있는지 확인한다.<br>
     *
     * @param InPrsMQCEstimateVO inPrsMQCEstimateVO
     * @return List<RsltCheckMQCEstimateVO>
     * @exception EventException
     */
    public List<RsltCheckMQCEstimateVO> searchCheckMQCEstimateList(InPrsMQCEstimateVO inPrsMQCEstimateVO)  throws EventException {
		try {
			return dbDao.searchCheckMQCEstimateList(inPrsMQCEstimateVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}     
    
    /**
     * MQC estimate Popup의 List를 조회한다..<br>
     *
     * @param InPrsMQCEstimateVO inPrsMQCEstimateVO
     * @return List<RsltMQCEstimateVO>
     * @exception EventException
     */
    public List<RsltMQCEstimateVO> searchMQCEstimateList(InPrsMQCEstimateVO inPrsMQCEstimateVO)  throws EventException {
		try {
			return dbDao.searchMQCEstimateList(inPrsMQCEstimateVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}     
    
	/**
	 *  MQC estimate 정보를 갱신합니다.<br>
	 * 
	 * @param PriSpScpMnVO[] priSpScpMnVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageMQCEstimateList(PriSpScpMnVO[] priSpScpMnVOs, SignOnUserAccount account) throws EventException{
		try {

			 
			List<PriSpScpMnVO> updateScpVoList = new ArrayList<PriSpScpMnVO>(); 
			for ( int i = 0; priSpScpMnVOs != null && i < priSpScpMnVOs.length; i++ ) {
				if ( priSpScpMnVOs[i].getIbflag().equals("U")){
					updateScpVoList.add(priSpScpMnVOs[i]);
				}
			}
		 
			dbDao.modifyMQCEstimateList(updateScpVoList);
 
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}	
		
	}		
	
	
    /**
     * 숨은 기능인 Superuser만 실행 시킬수 있는 Cancel Filing<br>
     *
     * @param ScPropProgVO scPropProgVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void cancelFilingForSuperuser(ScPropProgVO scPropProgVO,SignOnUserAccount account) throws EventException{
		try {
			PriSpMnVO priSpMnVO = scPropProgVO.getPriSpMnVOs()[0];
			PriSpProgVO priSpProgVO = scPropProgVO.getPriSpProgVOs()[0];


			priSpMnVO.setUpdUsrId(account.getUsr_id());

			//main 정보 update 상태를 A로 변경하고 filed_dt를 null로 바꾼다.
			dbDao.modifyProposalMainCancelFiling(priSpMnVO);

			
			// amdt_seq 가 0이면 이전 seq에 대한 update는 할필요가 없다.
			if( !priSpMnVO.getAmdtSeq().equals("0") ){
				PriSpMnVO clonePriSpMnVo = (PriSpMnVO)priSpMnVO.clone();//new PriSpMnVO();
				//ObjectCloner.build(priSpMnVO,clonePriSpMnVo);
				// SEQ를 이전 SEQ로 변경시킴
				clonePriSpMnVo.setAmdtSeq(String.valueOf(Integer.parseInt(priSpMnVO.getAmdtSeq()) - 1 ));
				// Main의 이전 seq의 exp_dt를 update한다.
				dbDao.modifyProposalMainCancelFilingExpDt(clonePriSpMnVo);
				// Scope Main의 이전 seq의 exp_dt를 update한다.(모든 scope에 대해 수행함.)
				dbDao.modifyProposalScopeMainCancelFilingExpDt(clonePriSpMnVo);
			}
			
			
			// propStsCd는 화면에서 A(Approved)로 넘어온다.
			// Filed 상태를 Cancel하면 이전 상태인 Approved가되기 때문에 A를 insert함.
			List<PriSpProgVO> insertVoList = new ArrayList<PriSpProgVO>();
			priSpProgVO.setUpdUsrId(account.getUsr_id());
			priSpProgVO.setCreUsrId(account.getUsr_id());
			if(CheckUtils.isNullAndNullString(priSpProgVO.getProgOfcCd())) {
				priSpProgVO.setProgOfcCd(account.getOfc_cd());
			}
			if(CheckUtils.isNullAndNullString(priSpProgVO.getProgUsrId())) {
				priSpProgVO.setProgUsrId(account.getUsr_id());
			}
			priSpProgVO.setProgDt(account.getUpd_dt());	
			insertVoList.add(priSpProgVO);
			dbDao.addProposalProgress(insertVoList);		
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
	
    /**
     * Sales Rep 정보의 변경 유무를 체크한다.<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @return int
     * @exception EventException
     */
    public int searchCheckOfcSrepDiffList(PriSpMnVO priSpMnVO)  throws EventException {
		try {
			return dbDao.searchCheckOfcSrepDiffList(priSpMnVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}
    
    /**
     * S/C No로 Prop No 를 조회합니다.<br>
     *
     * @param PriSpHdrVO priSpHdrVO
     * @return PriSpHdrVO
     * @exception EventException
     */
    public PriSpHdrVO searchProposalNoFromScNo(PriSpHdrVO priSpHdrVO) throws EventException {
		try {
			List<PriSpHdrVO> list = dbDao.searchProposalNoFromScNo(priSpHdrVO);
			if(list != null && list.size() > 0){
				return list.get(0);
			}else{
				return null;
			}
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}
    
	/**
     * S/C Proposal Real Customer의 데이터를 수정합니다.<br>
	 * 
	 * @param PriSpRealCustVO[] priSpRealCustVOs
	 * @param String delFlag
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyProposalMainRealCustomer(PriSpRealCustVO[] priSpRealCustVOs,String delFlag,SignOnUserAccount account) throws EventException {
		// TODO Auto-generated method stub
		try {
			List<PriSpMnVO> updateVoList = new ArrayList<PriSpMnVO>();
			PriSpMnVO vo = new PriSpMnVO();
			
			if( delFlag == null || "N".equals(delFlag)  ){
				for ( int i = 0; priSpRealCustVOs != null && i < priSpRealCustVOs.length; i++ ) {
					if ( priSpRealCustVOs[i].getRepCustFlg().equals("Y")){			
						vo.setAmdtSeq(priSpRealCustVOs[i].getAmdtSeq());
						vo.setPropNo(priSpRealCustVOs[i].getPropNo());
		 
						vo.setRealCustCntCd(priSpRealCustVOs[i].getCustCntCd());
						vo.setRealCustSeq(priSpRealCustVOs[i].getCustSeq());
						vo.setRealCustValSgmCd(priSpRealCustVOs[i].getCustValSgmCd());
						vo.setRealCustTpCd(priSpRealCustVOs[i].getPrcCtrtCustTpCd());
						vo.setRealCustSrepCd(priSpRealCustVOs[i].getCustSrepCd());
						vo.setRealCustSlsOfcCd(priSpRealCustVOs[i].getCustSlsOfcCd());
						vo.setRespbSrepCd(priSpRealCustVOs[i].getCustSrepCd());
						vo.setRespbSlsOfcCd(priSpRealCustVOs[i].getCustSlsOfcCd());
						vo.setUpdUsrId(account.getUsr_id());			
						updateVoList.add(vo);
					}
				}
			}else{
			    /*
			     * 2017-06-14  송민석
			     * Real Customer 삭제시 RespbSrepCd와 Ofc를 Contract Srep으로 변경해야 하는데
			     * 변경하지 않는 버그 수정
			     */
			    PriSpMnVO priSpMnVO = new PriSpMnVO();
			    priSpMnVO.setAmdtSeq(priSpRealCustVOs[0].getAmdtSeq());
			    priSpMnVO.setPropNo(priSpRealCustVOs[0].getPropNo());
			    List<RsltPropMnInqVO> list = dbDao.searchProposalMainInquiry(priSpMnVO);
			    RsltPropMnInqVO mnVO = list.get(0);		
                vo.setRespbSrepCd(mnVO.getCtrtCustSrepCd()) ;
                vo.setRespbSlsOfcCd(mnVO.getCtrtCustSlsOfcCd());
                
				vo.setAmdtSeq(priSpRealCustVOs[0].getAmdtSeq());
				vo.setPropNo(priSpRealCustVOs[0].getPropNo());
				vo.setRealCustCntCd("XX");
				vo.setRealCustSeq("XX");
				vo.setRealCustValSgmCd("XX");
				vo.setRealCustTpCd("XX");
				vo.setRealCustSrepCd("XX");
				vo.setRealCustSlsOfcCd("XX");
				vo.setUpdUsrId(account.getUsr_id());	
				updateVoList.add(vo);
			}

			if ( updateVoList.size() > 0 ) {
				dbDao.modifyProposalMain(updateVoList);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI06004",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI06004",new String[]{}).getMessage(), ex);
		}
	}	  
	
	/**
     * Filed S/C Cancel List를 조회합니다.<br>
     *
     * @param PriSpFiledCancelSearchVO priSpFiledCancelSearchVO
     * @return List<PriSpFiledCancelSearchVO>
     * @exception EventException
     */
    public List<PriSpFiledCancelSearchVO> searchFiledCancelHistoryList(PriSpFiledCancelSearchVO priSpFiledCancelSearchVO) throws EventException{
	try {
		return dbDao.searchFiledCancelHistoryList(priSpFiledCancelSearchVO);
	} catch (DAOException ex) {
        throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
	} catch (Exception ex) {
        throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
    }
}
    
    /**
     * Filed 된 s/C를 Cancel 하는 기능<br>
     *
     * @param PriSpFileCxlHisVO priSpFileCxlHisVO
     * @param PriSpProgVO priSpProgVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageFiledCancelProposal(PriSpFileCxlHisVO priSpFileCxlHisVO, PriSpProgVO priSpProgVO, SignOnUserAccount account) throws EventException{
		try {
			PriSpMnVO priSpMnVO = new PriSpMnVO();
			
			// S/C Filed History Table에 Insert 한다.
			priSpFileCxlHisVO.setUpdUsrId(account.getUsr_id());
			priSpFileCxlHisVO.setCreUsrId(account.getUsr_id());
			dbDao.addFiledCancelProposal(priSpFileCxlHisVO);
			
            priSpMnVO.setAmdtSeq(priSpFileCxlHisVO.getAmdtSeq());
            priSpMnVO.setPropNo(priSpFileCxlHisVO.getPropNo());
            priSpMnVO.setPropStsCd("A");
			priSpMnVO.setUpdUsrId(account.getUsr_id());

			//main 정보 update 상태를 A로 변경하고 filed_dt를 null로 바꾼다.
			dbDao.modifyProposalMainCancelFiling(priSpMnVO);

			
			// amdt_seq 가 0이면 이전 seq에 대한 update는 할필요가 없다.
			if( !priSpMnVO.getAmdtSeq().equals("0") ){
				PriSpMnVO clonePriSpMnVo = (PriSpMnVO)priSpMnVO.clone();//new PriSpMnVO();
				//ObjectCloner.build(priSpMnVO,clonePriSpMnVo);
				// SEQ를 이전 SEQ로 변경시킴
				clonePriSpMnVo.setAmdtSeq(String.valueOf(Integer.parseInt(priSpMnVO.getAmdtSeq()) - 1 ));
				// Main의 이전 seq의 exp_dt를 update한다.
				dbDao.modifyProposalMainCancelFilingExpDt(clonePriSpMnVo);
				// Scope Main의 이전 seq의 exp_dt를 update한다.(모든 scope에 대해 수행함.)
				dbDao.modifyProposalScopeMainCancelFilingExpDt(clonePriSpMnVo);
			}
			
			
			// propStsCd는 화면에서 A(Approved)로 넘어온다.
			// Filed 상태를 Cancel하면 이전 상태인 Approved가되기 때문에 A를 insert함.
			List<PriSpProgVO> insertVoList = new ArrayList<PriSpProgVO>();
			priSpProgVO.setAmdtSeq(priSpFileCxlHisVO.getAmdtSeq());
			priSpProgVO.setPropNo(priSpFileCxlHisVO.getPropNo());
			priSpProgVO.setPropStsCd(priSpMnVO.getPropStsCd());
			priSpProgVO.setUpdUsrId(account.getUsr_id());
			priSpProgVO.setCreUsrId(account.getUsr_id());
			if(CheckUtils.isNullAndNullString(priSpProgVO.getProgOfcCd())) {
				priSpProgVO.setProgOfcCd(account.getOfc_cd());
			}
			if(CheckUtils.isNullAndNullString(priSpProgVO.getProgUsrId())) {
				priSpProgVO.setProgUsrId(account.getUsr_id());
			}
			
			priSpProgVO.setProgDt(account.getUpd_dt());	
			insertVoList.add(priSpProgVO);
			dbDao.addProposalProgress(insertVoList);		
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
    
	/**
     * Filed S/C Cancel List를 조회합니다.<br>
     *
     * @param PriSpFiledCancelSearchVO priSpFiledCancelSearchVO
     * @return List<PriSpFiledCancelSearchVO>
     * @exception EventException
     */
    public List<PriSpFiledCancelSearchVO> searchFiledCancelHistoryInquiryList(PriSpFiledCancelSearchVO priSpFiledCancelSearchVO) throws EventException{
	try {
		return dbDao.searchFiledCancelHistoryList(priSpFiledCancelSearchVO);
	} catch (DAOException ex) {
        throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
	} catch (Exception ex) {
        throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
    }
   }
    
    /**
     * S/C FILING 시 유저에게 G/W 메일 발송<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
     * @return List<PriEmailTargetListVO>
     * @exception EventException
     */
    public List<PriEmailTargetListVO> sendEmail(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException{
        try {
            TriPropSendMailVO sendMailVO = new TriPropSendMailVO();
            List<String> emailList = new ArrayList<String>();            
           
            // mail 대상 조회
            List<PriEmailTargetListVO> list = dbDao.searchEmailTargetUser(priSpMnVO);
            
            if (list != null && list.size() > 0) { 
	            // mail content
	            sendMailVO.setFromUser(account.getUsr_eml());
	            sendMailVO.setFromUserNm(account.getUsr_nm());
	            sendMailVO.setOfcCd(account.getOfc_cd());
	            
	            sendMailVO.setSubject("Notice of The S/C Amendment("+list.get(0).getScNo()+")");
	            
	            StringBuilder sbHtmlContent = new StringBuilder();
	            sbHtmlContent.append("<html>");
	            sbHtmlContent.append("<head>");
	            sbHtmlContent.append("<title></title>");
	            sbHtmlContent.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=euc-kr\">");
	            sbHtmlContent.append("<link rel=\"stylesheet\" href=\"include/style.css\" type=\"text/css\">");
	            sbHtmlContent.append("</head>");
	            sbHtmlContent.append("<table style=\"width:100%\" class=\"popup\" cellpadding=\"0\" border=\"0\">");
	            sbHtmlContent.append("<tr><td class=\"top\"></td></tr>");
	            sbHtmlContent.append("<tr><td valign=\"top\">");
	            sbHtmlContent.append("<table width=\"100%\" border=\"0\">");
	            sbHtmlContent.append("<tr><td style=\"font-family:arial,verdana; font-size: 16px; word-spacing:-0px; color: #313131; font-weight:bold;\">To whom it may concerned</td></tr>");
	            sbHtmlContent.append("<tr><td style=\"font-family:arial,verdana; font-size: 16px; word-spacing:-0px; color: #313131; font-weight:bold;\">Re : Notice of The S/C Amendment<br><br></td></tr>");
	            sbHtmlContent.append("</table>");
	            sbHtmlContent.append("<table class=\"search\">");
	            sbHtmlContent.append("<tr><td class=\"bg\">");    
	            sbHtmlContent.append("<table border=\"0\" style=\"width:100%;\">");
	            sbHtmlContent.append("<tr>");
	            sbHtmlContent.append("<td style=\"padding:0px; font-family: Tahoma,verdana,arial,dotum,gulim; font-size: 16px; word-spacing:-0px;\">");
	            
	            sbHtmlContent.append("Your contract ("+list.get(0).getScNo()+") for the following bookings has been amended by salesperson.<br>");
	            sbHtmlContent.append("Please, check and rerate it accordingly.<br><br>");
	            sbHtmlContent.append("Booking Number / Your ID (This mail is sent to all documentation staffs who have a B/L with the contract)<br><br>");
	            
	            // booking list 
	            sbHtmlContent.append("<table cellpadding=\"1\" cellspacing=\"1\" bgcolor=\"#ffffff\" border=\"0\" style=\"width:100%;\">");          
	            for(int i=0;i<list.size();i++){
	            sbHtmlContent.append("<tr><td><table><tr><td style=\"background-color: #ffffff; color: #313131; text-align : left; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 16px; padding-right:3px;\">"+list.get(i).getSeq()+". "+list.get(i).getBkgNo()+" / "+list.get(i).getUpdUsrId()+"</td></tr></table></td></tr>");
	            }
	            sbHtmlContent.append("</table><br>");
	        
	            sbHtmlContent.append("* This notification is automatically made by system when your contract is amended after your rating.<br>");
	            sbHtmlContent.append("Since the sender of your mail does not send the mail, you are not to reply to him and may figure out the amendment of contract thru ALPS on your own.<br>"); 
	            sbHtmlContent.append("* It may not be the amendment on amount of charges/surcharges.<br>");
	            
	            sbHtmlContent.append("<table class=\"search\" border=\"0\" style=\"width:100%;\">");
	            sbHtmlContent.append("<tr>");
	            sbHtmlContent.append("<td style=\"padding:0px; font-family: arial,verdana; font-size: 16px; word-spacing:-0px;\"><br>Thank you.<br>");
	            sbHtmlContent.append("Best Regards,</td>");
	            sbHtmlContent.append("</tr>");
	            sbHtmlContent.append("</table>");            
	            sbHtmlContent.append("</td></tr>");
	            sbHtmlContent.append("</table>");
	            sbHtmlContent.append("</td></tr>");
	            sbHtmlContent.append("</table>");
	            sbHtmlContent.append("</html>");
	            sendMailVO.setHtmlContent(sbHtmlContent.toString());
	            
	            // mail 대상 Key(email send Seq) List 에 담기
	            String preUsrId = "";
	            for (int i = 0 ; i < list.size() ; i++) {            	
	            	if(!list.get(i).getUpdUsrId().equals(preUsrId)){
	                   emailList.add(list.get(i).getUsrEml());
	            	}            	
	            	preUsrId = list.get(i).getUpdUsrId();
	            }
	          
	              SCProposalMainEAIDAO eaiDao = new SCProposalMainEAIDAO();
	              eaiDao.sendEmail(sendMailVO, emailList);            
            }
              
          return list;   
            
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("FMS01187",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("FMS01187",new String[]{}).getMessage(), ex);
        }
    }


	
	/**
     * 해당 Proposal을 Filing 합니다.<br>
	 * 
	 * @param CstPriSpMnFileDtVO cstPriSpMnFileDtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalFmcFiling(CstPriSpMnFileDtVO cstPriSpMnFileDtVO, SignOnUserAccount account) throws EventException{
	
		try {			
            //이전 seq의 exp_dt를 자른다,status를 변경 합니다.
			List<PriSpMnVO > updateVoList = new ArrayList<PriSpMnVO >();
			
			cstPriSpMnFileDtVO.setUpdUsrId(account.getUsr_id());
			PriSpMnVO mnVO = new PriSpMnVO();
			ObjectCloner.build(cstPriSpMnFileDtVO, mnVO);
			updateVoList.add(mnVO);
			

			//기존 mn 에 대한 update
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyProposalMainFmcFiling(updateVoList);//status변경
				
				//2009/12/15 - 변경 
				//사용자의 선택에 따라 eff_dt와 file_dt의 비교 없이 모두 변경한다.
				if (cstPriSpMnFileDtVO.getEffDtChg().equals("Y")){
					dbDao.modifyProposalMainFile(updateVoList);
					dbDao.modifyProposalScopeMainFile(updateVoList);
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
	 * PRI_SP_FILE_PROG 의 신규 건을 생성하고 생성된 신규 File Progress Sequence 를 Return 합니다.<br>
	 * 
	 * @param CstPriSpMnFileDtVO vo
	 * @param account SignOnUserAccount
     * @return int
	 * @exception EventException
	 */
	public int createPriSpFileProg(CstPriSpMnFileDtVO vo, SignOnUserAccount account) throws EventException{
		int newFileProgSeq = -1;
		try {

			newFileProgSeq = dbDao.searchPriSpFileProgNewSeq(vo);
			vo.setCreUsrId(account.getUsr_id());

			vo.setFileProgSeq(newFileProgSeq+"");
			dbDao.createPriSpFileProg(vo);

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return newFileProgSeq;
	}
	
    

	/**
	 * FMC Return Message 를 사용하여 PRI_SP_FILE_PROG 을 Update 하고 PRI_SP_FILE_ERR 을 생성 한다.<br>
	 * 
	 * @param CstPriSpMnFileDtVO vo
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyPriSpFileProg(CstPriSpMnFileDtVO vo, SignOnUserAccount account) throws EventException{
		try {

			vo.setCreUsrId(account.getUsr_id());
			vo.setUpdUsrId(account.getUsr_id());

			dbDao.modifyPriSpFileProgUsingRtnMsg(vo);
			dbDao.createPriSpFileErrUsingRtnMsg(vo);

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
    /**
     * S/C Filing 을 WebService 를 통해 FMC 에 송부 합니다. FILECONTRACT<br>
     * 
     * @param CstPriSpMnFileDtVO vo
     * @exception EventException
     */
    public void sendFmcFileContract (CstPriSpMnFileDtVO vo) throws EventException {
        try {
            SCProposalMainEAIDAO eaiDao = new SCProposalMainEAIDAO();
            eaiDao.sendFmcFileContract(vo);
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
        } catch (Exception de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
        }
    }
    
    /**
     * S/C Filing 을 WebService 를 통해 FMC 에 송부 합니다. FILECORRECTEDCOPY<br>
     * 
     * @param CstPriSpMnFileDtVO vo
     * @exception EventException
     */
    public void sendFmcFileCorrectedCopy (CstPriSpMnFileDtVO vo) throws EventException {
        try {
            SCProposalMainEAIDAO eaiDao = new SCProposalMainEAIDAO();
            eaiDao.sendFmcFileCorrectedCopy(vo);
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
        } catch (Exception de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
        }
    }

	/**
	 * S/C Filing 을 WebService FILECONTRACT 를 통해 FMC 에 송부를 비동기 적으로 실행킨다.<br>
	 * 
	 * @param CstPriSpMnFileDtVO fileDtVo
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String sendFmcFileContractDoStart(CstPriSpMnFileDtVO fileDtVo, SignOnUserAccount account) throws EventException {
		try { 
			
//			SendFmcFileContractBackEndJob sendFmcFileContractBackEndJob = new SendFmcFileContractBackEndJob(); 
//			sendFmcFileContractBackEndJob.setSendFmcFileContractVO( fileDtVo, account); 
//			BackEndJobManager backEndJobManager = new BackEndJobManager();
//			return backEndJobManager.execute(sendFmcFileContractBackEndJob, account.getUsr_id(), "ESM_PRI_0058 - FileContract");
			
			
			int newFileProgSeq = dbDao.searchPriSpFileProgNewSeq(fileDtVo);
			fileDtVo.setCreUsrId(account.getUsr_id());

			fileDtVo.setFileProgSeq(newFileProgSeq+"");
			dbDao.createPriSpFileProg(fileDtVo);

			log.error ("FileContract-#2|"+fileDtVo.getScNo()+"|"+fileDtVo.getAmdtSeq()+"|"+fileDtVo.getFileProgSeq());
            // INTERFACE : Webservice 로 FMC 로  을 전송
            SCProposalMainEAIDAO eaiDao = new SCProposalMainEAIDAO();
            eaiDao.sendFmcFileContract(fileDtVo);
            
			log.error ("FileContract-#3|"+fileDtVo.getScNo()+"|"+fileDtVo.getAmdtSeq()+"|"+fileDtVo.getFileProgSeq());
            // Webservice 의 결과로 전송된 값을 기반하여 PRI_SP_FILE_PROG 의 Update 및 PRI_SP_FILE_ERR 테이블을 생성한다.
            fileDtVo.setCreUsrId(account.getUsr_id());
            fileDtVo.setUpdUsrId(account.getUsr_id());

            dbDao.modifyPriSpFileProgUsingRtnMsg(fileDtVo);
            dbDao.createPriSpFileErrUsingRtnMsg(fileDtVo);
            
//            CstPriSpMnFileDtVO newFileDtVo = new CstPriSpMnFileDtVO();
//            ObjectCloner.build(fileDtVo, newFileDtVo);
//            list.add(newFileDtVo);
//			log.error ("FileContract-#4|"+fileDtVo.getScNo()+"|"+fileDtVo.getAmdtSeq()+"|"+fileDtVo.getFileProgSeq());

			System.out.println("==============================");
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
		
		return "";
		
	}


	/**
	 * S/C Filing 을 WebService FILECORRECTEDCOPY 를 통해 FMC 에 송부를 비동기 적으로 실행킨다.<br>
	 * 
	 * @param CstPriSpMnFileDtVO fileDtVo
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String sendFmcFileCorrectedCopyDoStart(CstPriSpMnFileDtVO fileDtVo, SignOnUserAccount account) throws EventException {
		try { 
//			SendFmcFileCorrectedCopyBackEndJob sendFmcFileCorrectedCopyBackEndJob = new SendFmcFileCorrectedCopyBackEndJob(); 
//			sendFmcFileCorrectedCopyBackEndJob.setSendFmcFileCorrectedCopyVO( fileDtVo, account); 
//			BackEndJobManager backEndJobManager = new BackEndJobManager();
//			return backEndJobManager.execute(sendFmcFileCorrectedCopyBackEndJob, account.getUsr_id(), "ESM_PRI_0058 - FileCorrectedCopy");
			
			
			log.debug ("FileCorrectedCopy-#1|"+fileDtVo.getScNo()+"|"+fileDtVo.getAmdtSeq());
            fileDtVo.setFmcFileTpCd("C");
//            ObjectCloner.build(fileDtVo, priSpMnVO);

            // PRI_SP_FILE_PROG 를 신규 생성 한다.
			int newFileProgSeq = dbDao.searchPriSpFileProgNewSeq(fileDtVo);
			fileDtVo.setCreUsrId(account.getUsr_id());

			fileDtVo.setFileProgSeq(newFileProgSeq+"");
			dbDao.createPriSpFileProg(fileDtVo);

			log.debug ("FileCorrectedCopy-#2|"+fileDtVo.getScNo()+"|"+fileDtVo.getAmdtSeq()+"|"+fileDtVo.getFileProgSeq());
            // INTERFACE : Webservice 로 FMC 로  을 전송
            SCProposalMainEAIDAO eaiDao = new SCProposalMainEAIDAO();
            eaiDao.sendFmcFileCorrectedCopy(fileDtVo);
            
            // Webservice 의 결과로 전송된 값을 기반하여 PRI_SP_FILE_PROG 의 Update 및 PRI_SP_FILE_ERR 테이블을 생성한다.
            fileDtVo.setCreUsrId(account.getUsr_id());
            fileDtVo.setUpdUsrId(account.getUsr_id());

			log.debug ("FileCorrectedCopy-#3|"+fileDtVo.getScNo()+"|"+fileDtVo.getAmdtSeq()+"|"+fileDtVo.getFileProgSeq());
			dbDao.modifyPriSpFileProgUsingRtnMsg(fileDtVo);
			dbDao.createPriSpFileErrUsingRtnMsg(fileDtVo);
            
//            CstPriSpMnFileDtVO newFileDtVo = new CstPriSpMnFileDtVO();
//            ObjectCloner.build(fileDtVo, newFileDtVo);
//            list.add(newFileDtVo);
			log.debug ("FileCorrectedCopy-#4|"+fileDtVo.getScNo()+"|"+fileDtVo.getAmdtSeq()+"|"+fileDtVo.getFileProgSeq());

			
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
		return "";
	}
	
	/**
	 *  PRI_SP_DL_REC 의 신규 Screen Event Sequence 를 조회합니다.<br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchScreenEventSeq() throws EventException{
		int scrnEvntSeq = -1;
		try {

			scrnEvntSeq = dbDao.searchScreenEventSeq();

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return ""+scrnEvntSeq;
	}	
	
	/**
     * 사용자의 RD 리포트 사용 내역(파일오픈, 저장, 닫기등)을 관리합니다.<br>
     *
     * @param RsltPropMnDlRecVO rsltPropMnDlRecVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDownloadRecord(RsltPropMnDlRecVO rsltPropMnDlRecVO,SignOnUserAccount account)  throws EventException {
		 
		try {
			 	
				log.debug("account:::::\n"+account);
			 	rsltPropMnDlRecVO.setCreUsrId(account.getUsr_id());
			 	rsltPropMnDlRecVO.setCreOfcCd(account.getOfc_cd());
			 	rsltPropMnDlRecVO.setUpdUsrId(account.getUsr_id());

			 	// 저장시 서버에서 최소 필수값 확인
			 	//클라이언트의 작업으로 필수 값의 데이터가 소실될 경우 데이터를 저장을 피한다. (서버에서 최소 필수값 확인)
			 	if( !JSPUtil.getNull(rsltPropMnDlRecVO.getScrnEvntSeq()).equals("") 						&&  		//ScrnEvntSeq
			 	    !JSPUtil.getNull(rsltPropMnDlRecVO.getPrntScrnEvntSeq()).equals("") 				&&			//PrntScrnEvntSeq
			 	    !JSPUtil.getNull(rsltPropMnDlRecVO.getPrntScrnEvntSeq()).equals("undefined") 	&&			//PrntScrnEvntSeq
			 	    !JSPUtil.getNull(rsltPropMnDlRecVO.getPropNo()).equals("") 								&&			//PropNo
			 		!JSPUtil.getNull(rsltPropMnDlRecVO.getAmdtSeq()).equals("") 							&&			//AmdtSeq
			 		!JSPUtil.getNull(rsltPropMnDlRecVO.getAmdtSeq()).equals("undefined") ) {						//AmdtSeq
			 			dbDao.manageDownloadRecord(rsltPropMnDlRecVO);
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
	 * S/C Download Record 정보를 조회합니다.<br>
	 * 
	 * @param PriSpDlRecVO PriSpDlRecVO
	 * @return List<PriSpDlRecVO>
	 * @exception EventException
	 */
	public List<PriSpDlRecVO> searchPriDownloadRecord(PriSpDlRecVO PriSpDlRecVO) throws EventException {
		try {
			return dbDao.searchPriDownloadRecord(PriSpDlRecVO);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} 
	}

	/**
	 * PROPOSAL 필수 항목들이 입력되었는지의 여부 확인 (N: 복사 직후 아직 필수값이 입력되기 이전 Y: 복사 이후 필수값 입력됨).<br>
	 * 
     * @param PriSpMnVO priSpMnVO
	 * @return String
	 * @exception EventException
	 */
	public String searchPropPrprFlg(PriSpMnVO priSpMnVO) throws EventException{
		String propPrprFlg = "";
		try {			
			propPrprFlg = dbDao.searchPropPrprFlg(priSpMnVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
		return propPrprFlg;
	}		
	
	
	

    /**
     * 해당 Proposal의 Effective Date를 변경 합니다.<br>
     * 
     * @param  PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageEffectiveDate(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException{
    
        try {           
            //이전 seq의 exp_dt를 자른다,status를 변경 합니다.
            List<PriSpMnVO > updateVoList = new ArrayList<PriSpMnVO >();
             
            priSpMnVO.setUpdUsrId(account.getUsr_id());
            priSpMnVO.setFileDt(priSpMnVO.getEffDt());
            updateVoList.add(priSpMnVO);
             
            dbDao.modifyProposalMainFile(updateVoList);
            dbDao.modifyProposalScopeMainFile(updateVoList);
                

        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
        } catch (Exception de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
        }
        
    }       
    

    
    
    

    /**
     *  PRI_SP_INQ_REC 의 신규 Screen Event Sequence 를 조회합니다.<br>
     * 
     * @return String
     * @exception EventException
     */
    public String searchScreenInquiryEventSeq() throws EventException{
        int scrnEvntSeq = -1;
        try {

            scrnEvntSeq = dbDao.searchScreenInquiryEventSeq();

        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler(ex).getMessage(),ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler(ex).getMessage(),ex);
        }
        return String.valueOf(scrnEvntSeq);
    }   
    
    /**
     * 사용자의 S/C 조회 사용 내역을 관리합니다.<br>
     *
     * @param PriSpInqRecVO priSpInqRecVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageInquiryRecord(PriSpInqRecVO priSpInqRecVO,SignOnUserAccount account)  throws EventException {
         
        try {
                String scrnEvntSeq = searchScreenInquiryEventSeq();
                priSpInqRecVO.setScrnEvntSeq(scrnEvntSeq);

                log.debug("account:::::\n"+account);
                priSpInqRecVO.setCreUsrId(account.getUsr_id());
                priSpInqRecVO.setCreOfcCd(account.getOfc_cd());
                priSpInqRecVO.setUpdUsrId(account.getUsr_id());

                // 저장시 서버에서 최소 필수값 확인
                //클라이언트의 작업으로 필수 값의 데이터가 소실될 경우 데이터를 저장을 피한다. (서버에서 최소 필수값 확인)
                if( !JSPUtil.getNull(priSpInqRecVO.getScrnEvntSeq()).equals("")                         &&          //ScrnEvntSeq
                    !JSPUtil.getNull(priSpInqRecVO.getPropNo()).equals("")                              &&          //PropNo
                    !JSPUtil.getNull(priSpInqRecVO.getAmdtSeq()).equals("")                             &&          //AmdtSeq
                    !JSPUtil.getNull(priSpInqRecVO.getAmdtSeq()).equals("undefined") ) {                        //AmdtSeq
                        dbDao.manageInquiryRecord(priSpInqRecVO);
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
     * S/C Open Record 정보를 조회합니다.<br>
     * 
     * @param PriSpInqRecVO priSpInqRecVO
     * @return List<PriSpInqRecListVO>
     * @exception EventException
     */
    public List<PriSpInqRecListVO> searchPriOpenRecord(PriSpInqRecSearchVO priSpInqRecSearchVO) throws EventException {
        try {
            return dbDao.searchPriOpenRecord(priSpInqRecSearchVO);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } 
    }    
    
}