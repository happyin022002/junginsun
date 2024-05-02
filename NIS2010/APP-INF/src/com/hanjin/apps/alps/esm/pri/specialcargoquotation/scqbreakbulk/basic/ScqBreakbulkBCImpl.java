/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScqBreakbulkBCImpl.java
*@FileTitle : Breakbulk Cargo Pricing Application
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.26
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.02.18 문동선
* 1.0 Creation
=========================================================
* History 
* 2013.06.26 이혜민 [CHM-201325215] Special cargo Quotation System 수정 요청 - Approval Office에서 Approval/Reject/Pending으로 처리한 경우  해당 Sales Rep 에게 GW Mail로 송부
* 2013.07.03 송호진 [CHM-201324872] Counter Offer Cancel 기능 추가
* 2013.07.25 송호진 [CHM-201325102] Approval Cancel 기능 추가
* 2014.09.11 송호진 [CHM-201431718] SCQ System 기능 추가 개발 요청 - Actual Customer란
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.integration.ScqBreakbulkDBDAO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.integration.ScqBreakbulkEAIDAO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.vo.PriScqBbCgoVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.vo.PriScqBbCntrTpszVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.vo.PriScqBbCntrVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.vo.PriScqBbHdrVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.vo.PriScqBbRoutCostVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.vo.PriScqBbRqstVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.vo.PriScqAtchFileVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.TriPropSendMailVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.framework.core.config.SiteConfigFactory;

/**
 * ALPS-SpecialCargoQuotation Business Logic Command Interface<br>
 * - ALPS-SpecialCargoQuotation에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Dong-sun Moon
 * @since J2EE 1.6
 */
public class ScqBreakbulkBCImpl extends BasicCommandSupport implements ScqBreakbulkBC {

	// Database Access Object
	private transient ScqBreakbulkDBDAO dbDao = null;

	/**
	 * ScqBreakbulkBCImpl 객체 생성<br>
	 * ScqBreakbulkDBDAO를 생성한다.<br>
	 */
	public ScqBreakbulkBCImpl() {
		dbDao = new ScqBreakbulkDBDAO();
	}
	/**
	 * Break Bulk Quotation 의 Cargo 정보 조회.<br>
	 * 
	 * @param PriScqBbCgoVO PriScqBbCgoVO
	 * @return List<PriScqBbCgoVO>
	 * @exception EventException
	 */
	public List<PriScqBbCgoVO> searchPriScqBbCgo(PriScqBbCgoVO PriScqBbCgoVO) throws EventException {
		try {
			return dbDao.searchPriScqBbCgo(PriScqBbCgoVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * Break Bulk Quotation 의 Container 정보 조회.<br>
	 * 
	 * @param PriScqBbCgoVO PriScqBbCgoVO
	 * @return List<PriScqBbCgoVO>
	 * @exception EventException
	 */
	public List<PriScqBbCntrVO> searchPriScqBbCntr(PriScqBbCntrVO priScqBbCntrVO) throws EventException {
		try {
			return dbDao.searchPriScqBbCntr(priScqBbCntrVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * Break Bulk Quotation 의 Header ( Master ) 정보를 조회한다.<br>
	 * 
	 * @param PriScqBbHdrVO PriScqBbHdrVO
	 * @return List<PriScqBbHdrVO>
	 * @exception EventException
	 */
	public List<PriScqBbHdrVO> searchPriScqBbHdr(PriScqBbHdrVO PriScqBbHdrVO, SignOnUserAccount account) throws EventException {
		try {
			PriScqBbHdrVO.setUpdUsrId(account.getUsr_id());
			return dbDao.searchPriScqBbHdr(PriScqBbHdrVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * Break Bulk Quotation 의 지정된 Request No 의 Version No List 조회.<br>
	 * 
	 * @param PriScqBbHdrVO PriScqBbHdrVO
	 * @return List<PriScqBbHdrVO>
	 * @exception EventException
	 */
	public List<PriScqBbHdrVO> searchPriScqBbVerNo(PriScqBbHdrVO PriScqBbHdrVO) throws EventException {
		try {
			return dbDao.searchPriScqBbVerNo(PriScqBbHdrVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}	
	
	/**
	 * Break Bulk Quotation 화면의 Container 정보 중 Container Typesize Combo 를 위한 조회.<br>
	 * 
	 * @param PriScqBbCntrTpszVO PriScqBbCntrTpszVO
	 * @return List<PriScqBbCntrTpszVO>
	 * @exception EventException
	 */
	public List<PriScqBbCntrTpszVO> searchPriScqBbCntrTpsz(PriScqBbCntrTpszVO PriScqBbCntrTpszVO) throws EventException {
		try {
			return dbDao.searchPriScqBbCntrTpsz(PriScqBbCntrTpszVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	

	/**
	 * Break Bulk Quotation 에서 입력된 POL, POD 별로 적용 가능한 Service Scope List 를 조회한다.<br>
	 * 
	 * @param PriScqBbHdrVO PriScqBbHdrVO
	 * @return List<PriScqBbHdrVO>
	 * @exception EventException
	 */
	public List<PriScqBbHdrVO> searchPriScqBbSvcScp(PriScqBbHdrVO PriScqBbHdrVO) throws EventException {
		try {
			return dbDao.searchPriScqBbSvcScp(PriScqBbHdrVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 *  Break Bulk Cargo Quotation 의 Request 진행 .<br>
	 * 
	 * @param PriScqBbCgoVO[] PriScqBbCgoVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public PriScqBbHdrVO multiPriScqBbRqst(PriScqBbRqstVO PriScqBbRqstVO, SignOnUserAccount account) throws EventException{
		try {//PriScqBbRqstVO
			PriScqBbHdrVO[] hdrVOs = PriScqBbRqstVO.getPriScqBbHdrVOs();
			PriScqBbCgoVO[] cgoVOs = PriScqBbRqstVO.getPriScqBbCgoVOs();
			PriScqBbCntrVO[] cntrVOs = PriScqBbRqstVO.getPriScqBbCntrVOs();
			
			if(hdrVOs != null)
				log.debug("^^^^hdrVOs^^^"+hdrVOs .length);
			if(cgoVOs != null)
				log.debug("^^^^cgoVOs^^^"+cgoVOs .length);
			if(cntrVOs != null)
				log.debug("^^^^cntrVOs^^^"+cntrVOs .length);
			
			PriScqBbHdrVO multiVO = null; // 메서드 수행 후 반환될 VO
			PriScqBbHdrVO hdrVO = null;
			PriScqBbHdrVO preHdrVO = null;
			
			if(hdrVOs != null){
				hdrVO = hdrVOs[0];
				multiVO = hdrVOs[0];
			}
			// pri_scq_awk_mn , pri_scq_prog 테이블 
			if(hdrVO != null){
				if (hdrVO.getIbflag().equals("I")){ // 신규 TEMP Req no 생성
					String newRqstNo = dbDao.searchPriScqBbNewRqstNo(hdrVO);//새로이 생성될 rqst no 조회
					hdrVO.setScqRqstNo(newRqstNo);
					hdrVO.setScqVerNo("000"); // 최초 생성이므로 ver_no "000"
					hdrVO.setSpclCgoTpCd("BB"); //Breakbulk cargo
					hdrVO.setCreUsrId(account.getUsr_id());
					dbDao.addPriScqBbMn(hdrVO);
					dbDao.addPriScqBbProg(hdrVO);

					multiVO = hdrVO;
				
				} else if ( hdrVO.getIbflag().equals("U")){ // Prog 진행 (Save,Request,Cancel,C-Offer,Pending,Approval,Reject)
					hdrVO.setUpdUsrId(account.getUsr_id());
					
					List<PriScqBbHdrVO> preHdrList = dbDao.searchPriScqBbHdr(hdrVO);
					preHdrVO = preHdrList.get(0);//현재 DB 의 해당 Request No 의 최신 정보					
					
					if(!hdrVO.getPreProgStsCd().equals(preHdrVO.getProgStsCd())){ // 그 사이 prog_sts_cd 상태가 바뀜
						multiVO.setRsltFlg("Changed");
						multiVO.setProgStsCd(multiVO.getPreProgStsCd());
						multiVO.setPgProgStsCd(multiVO.getPreProgStsCd());
						return multiVO;
					}
					
					/*
					 * new -> Temporary                              : 누구든 가능    (임시 RqstNo신규생성, VerNo는000)
					 * Temporary -> Temporary (save)                 : 누구든 가능    (update)
					 * Temporary / Canceled -> proceSsing            : 생성자만 가능 (T->S:RqstNo신규생성 VerNo는001, C->S:RqstNo VerNo 유지)
					 * proceSsing -> reQuested                       : 누구든 가능 (rout cost 정보가 모두 confirm 되면)
					 * proceSsing / reQuested -> Canceled            : 생성자만 가능
					 * Approved / Rejected -> count Offer            : 생성자만 가능
					 * reQuested / Pending / count Offer -> Approval : Approval Office 소속 && 해당 Scope 승인 권한 있는 자만 가능
					 * reQuested / Pending / count Offer -> Rejected : Approval Office 소속 && 해당 Scope 승인 권한 있는 자만 가능                
					 * reQuested / count Offer -> Pending            : Approval Office 소속 && 해당 Scope 승인 권한 있는 자만 가능
					 */
					
					if(hdrVO.getProgStsCd().equals("T")){ // Save : 임시 저장 상태에서 Key 정보 유지하면서 Update
							dbDao.modifyPriScqBbMn(hdrVO);   // Main 테이블 Update
							dbDao.modifyPriScqBbProg(hdrVO); // Prog 테이블 Update
							
							multiVO = hdrVO;
					}else if(hdrVO.getProgStsCd().equals("S")){ // proceSsing : 최초 request 날짜로 번호 다시 생성 하면서 Insert
						if(preHdrVO.getPgProgStsCd().equals("T")){ // 종전 상태 T 일 때
							String newRqstNo = dbDao.searchPriScqBbNewRqstNo(hdrVO);//새로이 생성될 rqst no 조회
							PriScqBbHdrVO insertVO = null;
							
							//종전 임시 ReqNo Prog 상태 및 Del flg 갱신
							PriScqBbHdrVO deleteVO = null;
							deleteVO = hdrVO;
							deleteVO.setDeltFlg("Y");
							deleteVO.setCreUsrId(account.getUsr_id());
							deleteVO.setUpdUsrId(account.getUsr_id());
							dbDao.modifyPriScqBbMn(deleteVO); // Main 테이블 Update (Del flag)
							dbDao.addPriScqBbProg(deleteVO);  // Prog 테이블 Insert (S)
							
							//첨부파일 복사
							PriScqAtchFileVO atchFileVO = new PriScqAtchFileVO();
							atchFileVO.setScqRqstNo(newRqstNo);
							atchFileVO.setPreScqRqstNo(deleteVO.getScqRqstNo());
							atchFileVO.setSpclCgoTpCd(deleteVO.getSpclCgoTpCd());
							atchFileVO.setCreUsrId(account.getUsr_id());
							atchFileVO.setUpdUsrId(account.getUsr_id());
							dbDao.addPriScqAtchFileCopy(atchFileVO);
							
							insertVO = hdrVO;							
							insertVO.setCreUsrId(account.getUsr_id());
							insertVO.setScqRqstNo(newRqstNo);
							insertVO.setScqVerNo("001"); // 최초 request 이므로 ver_no "001"
							deleteVO.setDeltFlg("");
							dbDao.addPriScqBbMn(insertVO);   // Main 테이블 Insert
							dbDao.addPriScqBbProg(insertVO); // Prog 테이블 Insert
							
							multiVO = insertVO;
							
						}else if(preHdrVO.getPgProgStsCd().equals("C")){ // 종전 상태 C 일 때
							PriScqBbHdrVO updateVO = null;
							updateVO = hdrVO;							
							updateVO.setCreUsrId(account.getUsr_id());
							dbDao.modifyPriScqBbMn(updateVO); // Main 테이블 Update
							dbDao.addPriScqBbProg(updateVO);  // Prog 테이블 Insert
							
							multiVO = updateVO;
						}
					}else if( ( hdrVO.getProgStsCd().equals("C") && !preHdrVO.getPgProgStsCd().equals("O") && !preHdrVO.getPgProgStsCd().equals("A") )
							||hdrVO.getProgStsCd().equals("Q")
							||hdrVO.getProgStsCd().equals("P")
							||hdrVO.getProgStsCd().equals("A")
							||hdrVO.getProgStsCd().equals("R")){ // C/Q/P/A/R : progStsCd 를 update
						PriScqBbHdrVO updateVO = null;
						updateVO = hdrVO;							
						updateVO.setCreUsrId(account.getUsr_id());
						updateVO.setUpdUsrId(account.getUsr_id());
						dbDao.modifyPriScqBbMn(updateVO); // Main 테이블 Update
						dbDao.addPriScqBbProg(updateVO);  // Prog 테이블 Insert
							
						multiVO = updateVO;
					}else if ( hdrVO.getProgStsCd().equals("C") && preHdrVO.getPgProgStsCd().equals("O") ) { // Counter Offer Cancel
						cancelCounterOffer(hdrVO, account);
						cgoVOs = null;
						cntrVOs = null;
					}else if ( hdrVO.getProgStsCd().equals("C") && preHdrVO.getPgProgStsCd().equals("A") ) { // Approval Cancel
						cancelApproval(hdrVO, account);
						cgoVOs = null;
						cntrVOs = null;
					}else if(hdrVO.getProgStsCd().equals("O")){ // count Offer : progStsCd 를 O 로 update
						PriScqBbHdrVO updateVO = null;
						updateVO = hdrVO;							
						updateVO.setCreUsrId(account.getUsr_id());
						updateVO.setUpdUsrId(account.getUsr_id());
						
						String newVerNoStr = dbDao.searchPriScqBbNewVerNo(updateVO);
						int newVerNo = Integer.parseInt(newVerNoStr); // Ver No 올림
						newVerNoStr = String.format("%03d", newVerNo); //3자리 String 으로 변환
						
						updateVO.setScqVerNo(newVerNoStr); 
						dbDao.addPriScqBbMn(updateVO); // Main 테이블 Update
						dbDao.addPriScqBbProg(updateVO);  // Prog 테이블 Insert
						
						multiVO = updateVO;
					}else if(hdrVO.getProgStsCd().equals("D")){ // Delete : delt_flg 를  Y 로 update
						/* Delete : 현 상태와 동일한 sts_cd를 가지고 delt_flg "Y"인  prog 생성 
						 * 생성자 : T/C 일 때 Delete 가능
						 * Approval OFC && Scope 승인권자 : Q/O/A/P/R 일 때 Delete 가능
						 */
						if(hdrVO.getPreProgStsCd().equals("T")||hdrVO.getPreProgStsCd().equals("S")||hdrVO.getPreProgStsCd().equals("C")){
							//생성자가 삭제한 경우
							PriScqBbHdrVO updateVO = null;
							updateVO = hdrVO;
							updateVO.setDeltFlg("Y");
							if(updateVO.getPgProgStsCd() != null){
								updateVO.setProgStsCd(updateVO.getPgProgStsCd());
							}
							updateVO.setCreUsrId(account.getUsr_id());
							updateVO.setUpdUsrId(account.getUsr_id());
							dbDao.modifyPriScqBbMn(updateVO); // Main 테이블 Update
							dbDao.addPriScqBbProg(updateVO);  // Prog 테이블 Insert
							
							multiVO = updateVO;
						}else if(hdrVO.getPreProgStsCd().equals("Q")||hdrVO.getPreProgStsCd().equals("O")
									||hdrVO.getPreProgStsCd().equals("A")||hdrVO.getPreProgStsCd().equals("P")
									||hdrVO.getPreProgStsCd().equals("R")){
							//승인권자가 삭제한 경우
							PriScqBbHdrVO updateVO = null;
							updateVO = hdrVO;
							updateVO.setDeltFlg("Y");
							if(updateVO.getPgProgStsCd() != null){
								updateVO.setProgStsCd(updateVO.getPgProgStsCd());
							}
							updateVO.setCreUsrId(account.getUsr_id());
							updateVO.setUpdUsrId(account.getUsr_id());
							dbDao.modifyPriScqBbMn(updateVO); // Main 테이블 Update
							dbDao.addPriScqBbProg(updateVO);  // Prog 테이블 Insert
							
							multiVO = updateVO;
						}
					}
				}
			}
			
			// pri_scq_bb_cgo 테이블 
			if(cgoVOs != null){	
				List<PriScqBbCgoVO> insertCgoVoList = new ArrayList<PriScqBbCgoVO>();
				List<PriScqBbCgoVO> updateCgoVoList = new ArrayList<PriScqBbCgoVO>();
				List<PriScqBbCgoVO> deleteCgoVoList = new ArrayList<PriScqBbCgoVO>();		
				
				for ( int i=0; i<cgoVOs .length; i++ ) {
					cgoVOs[i].setScqRqstNo(multiVO.getScqRqstNo());
					cgoVOs[i].setScqVerNo(multiVO.getScqVerNo());
					if ( cgoVOs[i].getIbflag().equals("I")){
						cgoVOs[i].setCreUsrId(account.getUsr_id());					
						insertCgoVoList.add(cgoVOs[i]);
					} else if ( cgoVOs[i].getIbflag().equals("U")){
						cgoVOs[i].setUpdUsrId(account.getUsr_id());
						updateCgoVoList.add(cgoVOs[i]);
					} else if ( cgoVOs[i].getIbflag().equals("D")){
						deleteCgoVoList.add(cgoVOs[i]);
					}
				}
				if ( insertCgoVoList.size() > 0 ) {
					String nextCgoSeqStr = dbDao.searchPriScqBbNewCgoSeq(insertCgoVoList.get(0));
					int nextCgoSeq = Integer.parseInt(nextCgoSeqStr); // 신규 생성될 CGO_SEQ 를 가져온다
					for(int i=0; i<insertCgoVoList.size(); i++){
						insertCgoVoList.get(i).setCgoSeq(Integer.toString(nextCgoSeq+i));
					}
					dbDao.addPriScqBbCgoVOS(insertCgoVoList);
				}
				if ( updateCgoVoList.size() > 0 ) {
					dbDao.modifyPriScqBbCgoVOS(updateCgoVoList);
				}
				if ( deleteCgoVoList.size() > 0 ) {
					dbDao.removePriScqBbCgoVOS(deleteCgoVoList);
				}
			}
			// pri_scq_bb_cntr 테이블 
			if(cntrVOs != null){		
				List<PriScqBbCntrVO> insertCntrVoList = new ArrayList<PriScqBbCntrVO>();
				List<PriScqBbCntrVO> updateCntrVoList = new ArrayList<PriScqBbCntrVO>();
				List<PriScqBbCntrVO> deleteCntrVoList = new ArrayList<PriScqBbCntrVO>();		
				
				for ( int i=0; i<cntrVOs .length; i++ ) {
					cntrVOs[i].setScqRqstNo(multiVO.getScqRqstNo());
					cntrVOs[i].setScqVerNo(multiVO.getScqVerNo());
					if ( cntrVOs[i].getIbflag().equals("I")){
						cntrVOs[i].setCreUsrId(account.getUsr_id());					
						insertCntrVoList.add(cntrVOs[i]);
					} else if ( cntrVOs[i].getIbflag().equals("U")){
						cntrVOs[i].setUpdUsrId(account.getUsr_id());
						updateCntrVoList.add(cntrVOs[i]);
					} else if ( cntrVOs[i].getIbflag().equals("D")){
						deleteCntrVoList.add(cntrVOs[i]);
					}
				}
				if ( insertCntrVoList.size() > 0 ) {
					String nextCntrSeqStr = dbDao.searchPriScqBbNewCntrSeq(insertCntrVoList.get(0));
					int nextCntrSeq = Integer.parseInt(nextCntrSeqStr); // 신규 생성될 CNTR_SEQ 를 가져온다
					for(int i=0; i<insertCntrVoList.size(); i++){
						insertCntrVoList.get(i).setCntrSeq(Integer.toString(nextCntrSeq+i));
					}
					dbDao.addPriScqBbCntrVOS(insertCntrVoList);
				}
				if ( updateCntrVoList.size() > 0 ) {
					dbDao.modifyPriScqBbCntrVOS(updateCntrVoList);
				}
				if ( deleteCntrVoList.size() > 0 ) {
					dbDao.removePriScqBbCntrVOS(deleteCntrVoList);
				}
			}
			//승인권자가 Approval, Reject 시 해당 requester에게 G/W 메일 발송(Approval Cancel 추가 예정)
			if(hdrVO != null){
				if(hdrVO.getProgStsCd().equals("A")){ 
					TriPropSendMailVO sendMailVO = new TriPropSendMailVO();
		            //TO USER 세팅
					String[] toUser = dbDao.searchEmailTargetUser(hdrVO);
		            // mail 대상 조회
		            if (toUser != null) {
		            	// mail content
		            	//sendMailVO.setToUser(toUser);
		                sendMailVO.setFromUser(account.getUsr_eml());
		                sendMailVO.setFromUserNm(account.getUsr_nm());
		                sendMailVO.setOfcCd(account.getOfc_cd());
		                
		                sendMailVO.setSubject("Approval Notice of The Break Bulk Cargo Rate ( "+hdrVO.getScqRqstNo()+" )");
		                
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
		                sbHtmlContent.append("<tr><td style=\"font-family:arial,verdana; font-size: 16px; word-spacing:-0px; color: #313131; font-weight:bold;\">TO. Whom it may concerned</td></tr>");
		                sbHtmlContent.append("<tr><td style=\"font-family:arial,verdana; font-size: 16px; word-spacing:-0px; color: #313131; font-weight:bold;\">Re : Approval Notice of The Break Bulk Cargo Rate <br><br></td></tr>");
		                sbHtmlContent.append("</table>");
		                sbHtmlContent.append("<table class=\"search\">");
		                sbHtmlContent.append("<tr><td class=\"bg\">");    
		                sbHtmlContent.append("<table border=\"0\" style=\"width:100%;\">");
		                sbHtmlContent.append("<tr>");
		                sbHtmlContent.append("<td style=\"padding:0px; font-family: Tahoma,verdana,arial,dotum,gulim; font-size: 16px; word-spacing:-0px;\">");
		                
		                sbHtmlContent.append("Your Request No. ["+hdrVO.getScqRqstNo()+"] POL / "+hdrVO.getPolCd()+hdrVO.getPolYdCd()+", POD / "+hdrVO.getPodCd()+hdrVO.getPodYdCd()+" has been approved.<br>");
		                sbHtmlContent.append("Please check the results in system.<br>");
		                sbHtmlContent.append("<a href='" + SiteConfigFactory.get("COM.HANJIN.SYSTEM.DOMAIN_URL") + "hanjin/ESM_PRI_8005.do?p_rqstno="+hdrVO.getScqRqstNo()+"' style=\"color:#ff0000\" >[Link to Application Screen]</a> for Requester<br><br><a href='" + SiteConfigFactory.get("COM.HANJIN.SYSTEM.DOMAIN_URL") + "hanjin/ESM_PRI_8006.do?p_rqstno="+hdrVO.getScqRqstNo()+"' style=\"color:#ff0000\" >[Link to Approval Screen]</a> for Approver<br><br>");
		                
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
		                
		                		              
		                ScqBreakbulkEAIDAO eaiDao = new ScqBreakbulkEAIDAO();
		                eaiDao.sendEmail(sendMailVO, toUser);   
		            }  
				}else if(hdrVO.getProgStsCd().equals("R")){
					TriPropSendMailVO sendMailVO = new TriPropSendMailVO();
		            //TO USER 세팅
					String[] toUser = dbDao.searchEmailTargetUser(hdrVO);
		            // mail 대상 조회
		            if (toUser != null) {
		            	// mail content
		            	//sendMailVO.setToUser(toUser);
		                sendMailVO.setFromUser(account.getUsr_eml());
		                sendMailVO.setFromUserNm(account.getUsr_nm());
		                sendMailVO.setOfcCd(account.getOfc_cd());
		                
		                sendMailVO.setSubject("Reject Notice of The Break Bulk Cargo Rate ( "+hdrVO.getScqRqstNo()+" )");
		                
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
		                sbHtmlContent.append("<tr><td style=\"font-family:arial,verdana; font-size: 16px; word-spacing:-0px; color: #313131; font-weight:bold;\">TO. Whom it may concerned</td></tr>");
		                sbHtmlContent.append("<tr><td style=\"font-family:arial,verdana; font-size: 16px; word-spacing:-0px; color: #313131; font-weight:bold;\">Re : Reject Notice of The Break Bulk Cargo Rate <br><br></td></tr>");
		                sbHtmlContent.append("</table>");
		                sbHtmlContent.append("<table class=\"search\">");
		                sbHtmlContent.append("<tr><td class=\"bg\">");    
		                sbHtmlContent.append("<table border=\"0\" style=\"width:100%;\">");
		                sbHtmlContent.append("<tr>");
		                sbHtmlContent.append("<td style=\"padding:0px; font-family: Tahoma,verdana,arial,dotum,gulim; font-size: 16px; word-spacing:-0px;\">");
		                
		                sbHtmlContent.append("Your Request No. ["+hdrVO.getScqRqstNo()+"] POL / "+hdrVO.getPolCd()+hdrVO.getPolYdCd()+", POD / "+hdrVO.getPodCd()+hdrVO.getPodYdCd()+" has been rejected.<br>");
		                sbHtmlContent.append("Please check the reject reason in system.<br>");
		                sbHtmlContent.append("<a href='" + SiteConfigFactory.get("COM.HANJIN.SYSTEM.DOMAIN_URL") + "hanjin/ESM_PRI_8005.do?p_rqstno="+hdrVO.getScqRqstNo()+"' style=\"color:#ff0000\" >[Link to Application Screen]</a> for Requester<br><br><a href='" + SiteConfigFactory.get("COM.HANJIN.SYSTEM.DOMAIN_URL") + "hanjin/ESM_PRI_8006.do?p_rqstno="+hdrVO.getScqRqstNo()+"' style=\"color:#ff0000\" >[Link to Approval Screen]</a> for Approver<br><br>");
		                
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
		                
		                		              
		                ScqBreakbulkEAIDAO eaiDao = new ScqBreakbulkEAIDAO();
		                eaiDao.sendEmail(sendMailVO, toUser);   
		            } 
				}else if ( hdrVO.getIbflag().equals("U") && hdrVO.getProgStsCd().equals("C") && preHdrVO.getPgProgStsCd().equals("A") ) { // Approval Cancel
					TriPropSendMailVO sendMailVO = new TriPropSendMailVO();
		            //TO USER 세팅
					String[] toUser = dbDao.searchEmailTargetUser(hdrVO);
		            // mail 대상 조회
		            if (toUser != null) {
		            	// mail content
		            	//sendMailVO.setToUser(toUser);
		                sendMailVO.setFromUser(account.getUsr_eml());
		                sendMailVO.setFromUserNm(account.getUsr_nm());
		                sendMailVO.setOfcCd(account.getOfc_cd());
		                
		                sendMailVO.setSubject("Approval Cancel Notice of The Break Bulk Cargo Rate ( "+hdrVO.getScqRqstNo()+" )");
		                
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
		                sbHtmlContent.append("<tr><td style=\"font-family:arial,verdana; font-size: 16px; word-spacing:-0px; color: #313131; font-weight:bold;\">TO. Whom it may concerned</td></tr>");
		                sbHtmlContent.append("<tr><td style=\"font-family:arial,verdana; font-size: 16px; word-spacing:-0px; color: #313131; font-weight:bold;\">Re : Reject Notice of The Break Bulk Cargo Rate <br><br></td></tr>");
		                sbHtmlContent.append("</table>");
		                sbHtmlContent.append("<table class=\"search\">");
		                sbHtmlContent.append("<tr><td class=\"bg\">");    
		                sbHtmlContent.append("<table border=\"0\" style=\"width:100%;\">");
		                sbHtmlContent.append("<tr>");
		                sbHtmlContent.append("<td style=\"padding:0px; font-family: Tahoma,verdana,arial,dotum,gulim; font-size: 16px; word-spacing:-0px;\">");
		                
		                sbHtmlContent.append("Approval of Request No. ["+hdrVO.getScqRqstNo()+"] POL / "+hdrVO.getPolCd()+hdrVO.getPolYdCd()+", POD / "+hdrVO.getPodCd()+hdrVO.getPodYdCd()+" has been cancelled.<br>");
		                sbHtmlContent.append("Please check again revised results in system.<br>");
		                sbHtmlContent.append("<a href='" + SiteConfigFactory.get("COM.HANJIN.SYSTEM.DOMAIN_URL") + "hanjin/ESM_PRI_8005.do?p_rqstno="+hdrVO.getScqRqstNo()+"' style=\"color:#ff0000\" >[Link to Application Screen]</a> for Requester<br><br><a href='" + SiteConfigFactory.get("COM.HANJIN.SYSTEM.DOMAIN_URL") + "hanjin/ESM_PRI_8006.do?p_rqstno="+hdrVO.getScqRqstNo()+"' style=\"color:#ff0000\" >[Link to Approval Screen]</a> for Approver<br><br>");
		                
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
		                
		                		              
		                ScqBreakbulkEAIDAO eaiDao = new ScqBreakbulkEAIDAO();
		                eaiDao.sendEmail(sendMailVO, toUser);   
		            } 
				}
			}
			
			return multiVO;
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Counter Offer Cancel 처리..<br>
	 * C/Offer 로 생성된 새로운 Version No 의 Data Set 을 삭제하고 
     * 이전 상태 ( 이전 Version 의 Reject or Approved 상태 ) 로 복귀 
	 * 
	 * @param PriScqBbHdrVO priScqBbHdrVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public PriScqBbHdrVO cancelCounterOffer(PriScqBbHdrVO priScqBbHdrVO, SignOnUserAccount account) throws EventException{
		try {
			PriScqBbHdrVO hdrVO = priScqBbHdrVO; // 메서드 수행 후 반환될 VO
			hdrVO.setCreUsrId(account.getUsr_id());	
			// 기존 데이터 부분 지우기
			dbDao.removePriScqBbRoutCost(hdrVO);
			dbDao.removePriScqBbRout(hdrVO);
			dbDao.removePriScqBbCntr(hdrVO);
			dbDao.removePriScqBbCgo(hdrVO);
			dbDao.removePriScqProgBb(hdrVO);
			dbDao.removePriScqBbMn(hdrVO);
						
			List<PriScqBbHdrVO> list = dbDao.searchPriScqBbVerNo(hdrVO);
			hdrVO.setScqVerNo(list.get(0).getScqVerNo());
			
			return hdrVO;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	/**
	 * Approval Cancel 처리..<br>
	 * 
	 * Approval 이전 상태로 복귀 
	 * 1.PRI_SCQ_PROG 상의 마지막 Approval 기록 데이터 부분 지우기
	 * 2.지워진 PRI_SCQ_PROG 상의 마지막 Approval 기록 직전의 Progress 상태로 PRI_SCQ_BB_MN.PROG_STS_CD 변경 하기
	 * 
	 * @param PriScqBbHdrVO priScqBbHdrVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public PriScqBbHdrVO cancelApproval(PriScqBbHdrVO priScqBbHdrVO, SignOnUserAccount account) throws EventException{
		try {
			PriScqBbHdrVO hdrVO = priScqBbHdrVO; // 메서드 수행 후 반환될 VO
			hdrVO.setUpdUsrId(account.getUsr_id());	

			// PRI_SCQ_PROG 상의 마지막 Approval 기록 데이터 부분 지우기
			dbDao.removePriScqProgBbForApprCxl(hdrVO);
			// 지워진 PRI_SCQ_PROG 상의 마지막 Approval 기록 직전의 Progress 상태로 PRI_SCQ_BB_MN.PROG_STS_CD 변경 하기
			dbDao.modifyPriScqBbMnForApprCxl(hdrVO);
						
			
			return hdrVO;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	/**
	 * Break Bulk Cargo Quotation 의 Route 및 항목별 비용 정보 조회.<br>
	 * 
	 * @param PriScqBbRoutCostVO PriScqBbRoutCostVO
	 * @return List<PriScqBbRoutCostVO>
	 * @exception EventException
	 */
	public List<PriScqBbRoutCostVO> searchPriScqBbRoutCost(PriScqBbRoutCostVO priScqBbRoutCostVO) throws EventException {
		try {
			return dbDao.searchPriScqBbRoutCost(priScqBbRoutCostVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * Break Bulk Cargo Quotation 정보 저장.<br>
	 * 
	 * @param PriScqBbRoutCostVO[] priScqBbRoutCostVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiPriScqBbRoutCost(PriScqBbRoutCostVO[] priScqBbRoutCostVOs, SignOnUserAccount account) throws EventException{
		try {
			List<PriScqBbRoutCostVO> insertVoList = new ArrayList<PriScqBbRoutCostVO>();
			List<PriScqBbRoutCostVO> updateVoList = new ArrayList<PriScqBbRoutCostVO>();
			
			if(priScqBbRoutCostVOs == null) {
				return;
			} 
			
			/* ibflag I : rout 테이블에 add
			 * ibflag U : rout 테이블에 modify
			 * rout_cost_seq 없음 : rout_cost 테이블에 add
			 * rout_cost_seq 존재 : rout_cost 테이블에 modify
			 */
			PriScqBbRoutCostVO routVO = null;
			if(priScqBbRoutCostVOs != null){
				routVO = priScqBbRoutCostVOs[0];
			}
			if(routVO != null){
				if (routVO.getIbflag().equals("I")){ // 신규 RoutSeqVerNo 생성				
					String newRoutSeqVerNo = dbDao.searchPriScqBbNewRoutSeqVerNo(routVO);
					if(routVO.getScqVerNo()!=null){
						if(routVO.getScqVerNo().equals("000") || routVO.getScqVerNo().equals("001")){
							for(int i=0; i<priScqBbRoutCostVOs .length; i++) {
								priScqBbRoutCostVOs[i].setRoutSeqVerNo(newRoutSeqVerNo);
								priScqBbRoutCostVOs[i].setCreUsrId(account.getUsr_id());
								insertVoList.add(priScqBbRoutCostVOs[i]);
							}
						}else{// Count Offer 시엔 route upd_usr_id 를 그대로 유지
							for(int i=0; i<priScqBbRoutCostVOs .length; i++) {
								priScqBbRoutCostVOs[i].setRoutSeqVerNo(newRoutSeqVerNo);
								priScqBbRoutCostVOs[i].setCreUsrId(priScqBbRoutCostVOs[i].getUpdUsrId());
								insertVoList.add(priScqBbRoutCostVOs[i]);
							}
						}
					}
					if ( insertVoList.size() > 0 ) {
						dbDao.addPriScqBbRout(insertVoList.get(0));
						dbDao.addPriScqBbRoutCost(insertVoList);
					}
				}else if(routVO.getIbflag().equals("U")){
					for(int i=0; i<priScqBbRoutCostVOs .length; i++) {
						priScqBbRoutCostVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(priScqBbRoutCostVOs[i]);
					}
					if ( updateVoList.size() > 0 ) {
						dbDao.modifyPriScqBbRout(updateVoList.get(0));
		                dbDao.modifyPriScqBbRoutCost(updateVoList);
					}
				}
			}
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 * Break Bulk Cargo Quotation Container 정보 저장.<br>
	 * 
	 * @param PriScqBbRqstVO priScqBbRqstVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void addPriScqBbCntrNewVerNo(PriScqBbRqstVO priScqBbRqstVO, SignOnUserAccount account) throws EventException{
		try {
			PriScqBbHdrVO[] hdrVOs = priScqBbRqstVO.getPriScqBbHdrVOs();
			PriScqBbCntrVO[] cntrVOs = priScqBbRqstVO.getPriScqBbCntrVOs();
			
			PriScqBbHdrVO hdrVO = null;
			
			if(hdrVOs != null){
				hdrVO = hdrVOs[0];
			}
			List<PriScqBbCntrVO> insertVoList = new ArrayList<PriScqBbCntrVO>();

			String newCntrGrpVerNo = dbDao.searchPriScqBbNewCntrGrpVerNo(hdrVO);
			if(cntrVOs != null){
				for(int i=0; i<cntrVOs .length; i++) {
					if ( !cntrVOs[i].getIbflag().equals("D") ) {
						cntrVOs[i].setScqRqstNo(hdrVO.getScqRqstNo());
						cntrVOs[i].setScqVerNo(hdrVO.getScqVerNo());
						cntrVOs[i].setCntrGrpVerNo(newCntrGrpVerNo);
						cntrVOs[i].setCntrSeq((i+1)+"");
						cntrVOs[i].setCreUsrId(account.getUsr_id());
						insertVoList.add(cntrVOs[i]);
					}
				}
				if ( insertVoList.size() > 0 ) {
					dbDao.addPriScqBbCntrVOS(insertVoList);
				}
			}
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	


	/**
	 * 지정된 Lane - POL 에 대한 VVD - ETA List 를 조회한다.<br>
	 * 
	 * @param PriScqBbHdrVO hdrVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchVVDETAList(PriScqBbHdrVO hdrVO) throws EventException {
		try {
			return dbDao.searchVVDETAList(hdrVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

}