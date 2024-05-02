/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScqAwkwardBCImpl.java
*@FileTitle : Awkward Cargo Pricing Application
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
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.vo.OrganizationVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.integration.ScqAwkwardDBDAO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.integration.ScqAwkwardEAIDAO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.AwkCgoExtraCostByRouteVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.AwkCostByCgoRoutVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.PriScqAwkCgoVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.PriScqAwkCmdtListVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.PriScqAwkCntrTpszVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.PriScqAwkHdrVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.PriScqAwkRqstVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.SearchOceanRouteYDListVO;
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
public class ScqAwkwardBCImpl extends BasicCommandSupport implements ScqAwkwardBC {

	// Database Access Object
	private transient ScqAwkwardDBDAO dbDao = null;

	/**
	 * ScqAwkwardBCImpl 객체 생성<br>
	 * ScqAwkwardDBDAO를 생성한다.<br>
	 */
	public ScqAwkwardBCImpl() {
		dbDao = new ScqAwkwardDBDAO();
	}
	/**
	 * Awkward Quotation 의 Cargo 정보를 조회 한다.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @return List<PriScqAwkCgoVO>
	 * @exception EventException
	 */
	public List<PriScqAwkCgoVO> searchPriScqAwkCgo(PriScqAwkHdrVO priScqAwkHdrVO) throws EventException {
		try {
			return dbDao.searchPriScqAwkCgo(priScqAwkHdrVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * Awkward Cargo Quotation 의 Route 및 항목별 비용 정보 조회.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @return List<AwkCgoExtraCostByRouteVO>
	 * @exception EventException
	 */
	public List<AwkCgoExtraCostByRouteVO> searchAwkCgoExtraCostByRoute(PriScqAwkHdrVO priScqAwkHdrVO) throws EventException {
		try {
			return dbDao.searchAwkCgoExtraCostByRoute(priScqAwkHdrVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * Awkward Quotation 의 Header ( Master ) 정보를 조회한다.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @return List<PriScqAwkHdrVO>
	 * @exception EventException
	 */
	public List<PriScqAwkHdrVO> searchPriScqAwkHdr(PriScqAwkHdrVO priScqAwkHdrVO, SignOnUserAccount account) throws EventException {
		try {
			priScqAwkHdrVO.setUpdUsrId(account.getUsr_id());
			return dbDao.searchPriScqAwkHdr(priScqAwkHdrVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
		
	/**
	 * Awkward Quotation 의 지정된 Request No 의 Version No List 조회.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @return List<PriScqAwkHdrVO>
	 * @exception EventException
	 */
	public List<PriScqAwkHdrVO> searchPriScqAwkVerNo(PriScqAwkHdrVO priScqAwkHdrVO) throws EventException {
		try {
			return dbDao.searchPriScqAwkVerNo(priScqAwkHdrVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}	
	
	/**
	 * Commodity Input Popup List 조회. <br>
	 * 
	 * @param PriScqAwkCmdtListVO priScqAwkCmdtListVO
	 * @return List<PriScqAwkCmdtListVO>
	 * @exception EventException
	 */
	public List<PriScqAwkCmdtListVO> searchCommodityList(PriScqAwkCmdtListVO priScqAwkCmdtListVO) throws EventException {
		try {
			return dbDao.searchCommodityList(priScqAwkCmdtListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 *  - Awkward Quotation 화면의 Cargo 정보 중 Container Typesize Combo 를 위한 조회.<br>
	 * 
	 * @param PriScqAwkCntrTpszVO priScqAwkCntrTpszVO
	 * @return List<PriScqAwkCntrTpszVO>
	 * @exception EventException
	 */
	public List<PriScqAwkCntrTpszVO> searchPriScqAwkCntrTpsz(PriScqAwkCntrTpszVO priScqAwkCntrTpszVO) throws EventException {
		try {
			return dbDao.searchPriScqAwkCntrTpsz(priScqAwkCntrTpszVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 * Product Catalog 상의 Ocean Route 리스트 조회
	 * 
	 * @param SearchConditionVO vo
	 * @return List<SearchOceanRouteYDListVO>
	 * @throws EventException
	 */
	public List<SearchOceanRouteYDListVO> searchOceanRouteYDList(SearchConditionVO vo) throws EventException{
		try{

			return dbDao.searchOceanRouteYDList(vo);

		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}

	}

	/**
	 * Awkward Quotation 에서 입력된 POL, POD 별로 적용 가능한 Service Scope List 를 조회한다.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @return List<PriScqAwkHdrVO>
	 * @exception EventException
	 */
	public List<PriScqAwkHdrVO> searchPriScqSvcScp(PriScqAwkHdrVO priScqAwkHdrVO) throws EventException {
		try {
			return dbDao.searchPriScqSvcScp(priScqAwkHdrVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
		
	/**
	 * Awkward Cargo Quotation 정보 저장.<br>
	 * 
	 * @param PriScqAwkCgoVO[] priScqAwkCgoVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public PriScqAwkHdrVO multiPriScqAwkRqst(PriScqAwkRqstVO priScqAwkRqstVO, SignOnUserAccount account) throws EventException{
		try {//PriScqAwkRqstVO
			PriScqAwkHdrVO[] hdrVOs = priScqAwkRqstVO.getPriScqAwkHdrVOs();
			PriScqAwkCgoVO[] cgoVOs = priScqAwkRqstVO.getPriScqAwkCgoVOs();
			AwkCgoExtraCostByRouteVO[] routVOs = priScqAwkRqstVO.getAwkCgoExtraCostByRouteVOs();
			
			if(hdrVOs != null)
				log.debug("^^^^hdrVOs^^^"+hdrVOs .length);
			if(cgoVOs != null)
				log.debug("^^^^cgoVOs^^^"+cgoVOs .length);
			if(routVOs != null)
				log.debug("^^^^routVOs^^^"+routVOs .length);
			
			PriScqAwkHdrVO multiVO = null; // 메서드 수행 후 반환될 VO
			PriScqAwkHdrVO hdrVO = null;
			if(hdrVOs != null){
				hdrVO = hdrVOs[0];
				multiVO = hdrVOs[0];
			}
			PriScqAwkHdrVO routCopyVO = null;
			
			// pri_scq_awk_mn , pri_scq_prog 테이블 
			if(hdrVO != null){
				if (hdrVO.getIbflag().equals("I")){ // 신규 TEMP Req no 생성
					String newRqstNo = dbDao.searchPriScqAwkNewRqstNo(hdrVO);//새로이 생성될 rqst no 조회
					hdrVO.setScqRqstNo(newRqstNo);
					hdrVO.setScqVerNo("000"); // 최초 생성이므로 ver_no "000"
					hdrVO.setSpclCgoTpCd("AK"); //Awkward cargo
					hdrVO.setCreUsrId(account.getUsr_id());
					dbDao.addPriScqAwkMn(hdrVO);
					dbDao.addPriScqAwkProg(hdrVO);
					
					multiVO = hdrVO;
				
				} else if ( hdrVO.getIbflag().equals("U")){ // Prog 진행 (Save,Request,Cancel,C-Offer,Pending,Approval,Reject)
					hdrVO.setUpdUsrId(account.getUsr_id());
					
					List<PriScqAwkHdrVO> preHdrList = dbDao.searchPriScqAwkHdr(hdrVO);
					PriScqAwkHdrVO preHdrVO = preHdrList.get(0);//현재 DB 의 해당 Request No 의 최신 정보					
					
					if(!hdrVO.getPreProgStsCd().equals(preHdrVO.getProgStsCd())){ // 그 사이 prog_sts_cd 상태가 바뀜
						multiVO.setRsltFlg("Changed");
						multiVO.setProgStsCd(multiVO.getPreProgStsCd());
						multiVO.setPgProgStsCd(multiVO.getPreProgStsCd());
						return multiVO;
					}
					
					/*
					 * new -> Temporary                              : 누구든 가능    (임시 RqstNo신규생성, VerNo는000)
					 * Temporary -> Temporary (save)                 : 누구든 가능    (update)
					 * Temporary / Canceled -> reQuested             : 생성자만 가능 (T->Q:RqstNo신규생성 VerNo는001, C->Q:RqstNo VerNo 유지)
					 * reQuested -> Canceled                         : 생성자만 가능
					 * Approved / Rejected -> count Offer            : 생성자만 가능
					 * reQuested / Pending / count Offer -> Approval : Approval Office 소속 && 해당 Scope 승인 권한 있는 자만 가능
					 * reQuested / Pending / count Offer -> Rejected : Approval Office 소속 && 해당 Scope 승인 권한 있는 자만 가능                
					 * reQuested / count Offer -> Pending            : Approval Office 소속 && 해당 Scope 승인 권한 있는 자만 가능
					 */
					
					if(hdrVO.getProgStsCd().equals("T")){ // Save : 임시 저장 상태에서 Key 정보 유지하면서 Update
							dbDao.modifyPriScqAwkMn(hdrVO);   // Main 테이블 Update
							dbDao.modifyPriScqAwkProg(hdrVO); // Prog 테이블 Update
							
							multiVO = hdrVO;
					}else if(hdrVO.getProgStsCd().equals("Q")){ // reQuest : 최초 request 날짜로 번호 다시 생성 하면서 Insert
						if(preHdrVO.getPgProgStsCd().equals("T")){ // 종전 상태 T 일 때
							String newRqstNo = dbDao.searchPriScqAwkNewRqstNo(hdrVO);//새로이 생성될 rqst no 조회
							PriScqAwkHdrVO insertVO = null;
//							PriScqAtchFileVO atchFileVO = new PriScqAtchFileVO();
							
							//종전 임시 ReqNo Prog 상태 및 Del flg 갱신
							PriScqAwkHdrVO deleteVO = null;
							deleteVO = hdrVO;
							deleteVO.setDeltFlg("Y");
							deleteVO.setCreUsrId(account.getUsr_id());
							deleteVO.setUpdUsrId(account.getUsr_id());
							dbDao.modifyPriScqAwkMn(deleteVO); // Main 테이블 Update (Del flag)
							dbDao.addPriScqAwkProg(deleteVO);  // Prog 테이블 Insert (Q)
							
							//첨부파일 복사
							PriScqAtchFileVO atchFileVO = new PriScqAtchFileVO();
							atchFileVO.setScqRqstNo(newRqstNo);
							atchFileVO.setPreScqRqstNo(deleteVO.getScqRqstNo());
							atchFileVO.setSpclCgoTpCd(deleteVO.getSpclCgoTpCd());
							atchFileVO.setCreUsrId(account.getUsr_id());
							atchFileVO.setUpdUsrId(account.getUsr_id());
							dbDao.addPriScqAtchFileCopy(atchFileVO);
							
							//route 비용 복사
							//PriScqAwkHdrVO copySaveRqstNo(PriScqAwkHdrVO priScqAwkHdrVO, SignOnUserAccount account)
							
							routCopyVO = new PriScqAwkHdrVO();
							routCopyVO.setScqRqstNo(newRqstNo);
							routCopyVO.setScqVerNo("001");
							routCopyVO.setScqRqstNoTmp(deleteVO.getScqRqstNo());
							routCopyVO.setScqVerNoTmp(deleteVO.getScqVerNo());
//							copySaveRqstNo(routCopyVO, account);
							
							insertVO = hdrVO;							
							insertVO.setCreUsrId(account.getUsr_id());
							insertVO.setScqRqstNo(newRqstNo);
							insertVO.setScqVerNo("001"); // 최초 request 이므로 ver_no "001"
							deleteVO.setDeltFlg("");
							dbDao.addPriScqAwkMn(insertVO);   // Main 테이블 Insert
							dbDao.addPriScqAwkProg(insertVO); // Prog 테이블 Insert
							
							multiVO = insertVO;
							
						}else if(preHdrVO.getPgProgStsCd().equals("C")){ // 종전 상태 C 일 때
							PriScqAwkHdrVO updateVO = null;
							updateVO = hdrVO;							
							updateVO.setCreUsrId(account.getUsr_id());
							dbDao.modifyPriScqAwkMn(updateVO); // Main 테이블 Update
							dbDao.addPriScqAwkProg(updateVO);  // Prog 테이블 Insert
							
							multiVO = updateVO;
						}
					}else if( ( hdrVO.getProgStsCd().equals("C") && !hdrVO.getPgProgStsCd().equals("O") && !hdrVO.getPgProgStsCd().equals("A") )
							    ||hdrVO.getProgStsCd().equals("P")
								||hdrVO.getProgStsCd().equals("A")
								||hdrVO.getProgStsCd().equals("R")){ 
							PriScqAwkHdrVO updateVO = null;
							updateVO = hdrVO;							
							updateVO.setCreUsrId(account.getUsr_id());
							updateVO.setUpdUsrId(account.getUsr_id());
							dbDao.modifyPriScqAwkMn(updateVO); // Main 테이블 Update
							dbDao.addPriScqAwkProg(updateVO);  // Prog 테이블 Insert
							
							multiVO = updateVO;
					}else if ( hdrVO.getProgStsCd().equals("C") && hdrVO.getPgProgStsCd().equals("O") ){ // Counter Offer Cancel
						cancelCounterOffer(hdrVO, account);
						cgoVOs = null;
						routVOs = null;
					}else if ( hdrVO.getProgStsCd().equals("C") && hdrVO.getPgProgStsCd().equals("A") ){ // Approval Cancel
						cancelApproval(hdrVO, account);
						cgoVOs = null;
						routVOs = null;
					}else if(hdrVO.getProgStsCd().equals("O")){ // count Offer : progStsCd 를 O 로 update
							PriScqAwkHdrVO updateVO = null;
							updateVO = hdrVO;							
							updateVO.setCreUsrId(account.getUsr_id());
							updateVO.setUpdUsrId(account.getUsr_id());
							
							String newVerNoStr = dbDao.searchPriScqAwkNewVerNo(updateVO);
							int newVerNo = Integer.parseInt(newVerNoStr); // Ver No 올림
							newVerNoStr = String.format("%03d", newVerNo); //3자리 String 으로 변환
							String preVerNo = updateVO.getScqVerNo(); //
							
							
							updateVO.setScqVerNo(newVerNoStr); 
							dbDao.addPriScqAwkMn(updateVO); // Main 테이블 Update
							dbDao.addPriScqAwkProg(updateVO);  // Prog 테이블 Insert
							
							//route 비용 복사
							//PriScqAwkHdrVO copySaveRqstNo(PriScqAwkHdrVO priScqAwkHdrVO, SignOnUserAccount account)
							
							routCopyVO = new PriScqAwkHdrVO();
							routCopyVO.setScqRqstNo(updateVO.getScqRqstNo());
							routCopyVO.setScqVerNo(newVerNoStr);
							routCopyVO.setScqRqstNoTmp(updateVO.getScqRqstNo());
							routCopyVO.setScqVerNoTmp(preVerNo);
//							copySaveRqstNo(routCopyVO, account);
														
							multiVO = updateVO;
					}else if(hdrVO.getProgStsCd().equals("D")){ // Delete : delt_flg 를  Y 로 update
						/* Delete : 현 상태와 동일한 sts_cd를 가지고 delt_flg "Y"인  prog 생성 
						 * 생성자 : T/C 일 때 Delete 가능
						 * Approval OFC && Scope 승인권자 : Q/O/A/P/R 일 때 Delete 가능
						 */
						if(hdrVO.getPgProgStsCd().equals("T")||hdrVO.getPgProgStsCd().equals("C")){//생성자가 삭제한 경우
							if(preHdrVO.getPgProgStsCd().equals(hdrVO.getPgProgStsCd())){//화면 조회시의 ProgStsCd 와 같아야 함(T/C)
								PriScqAwkHdrVO updateVO = null;
								updateVO = hdrVO;
								updateVO.setDeltFlg("Y");
								if(updateVO.getPgProgStsCd() != null){
									updateVO.setProgStsCd(updateVO.getPgProgStsCd());
								}
								updateVO.setCreUsrId(account.getUsr_id());
								updateVO.setUpdUsrId(account.getUsr_id());
								dbDao.modifyPriScqAwkMn(updateVO); // Main 테이블 Update
								dbDao.addPriScqAwkProg(updateVO);  // Prog 테이블 Insert
								
								multiVO = updateVO;
							}
						}else if(hdrVO.getPgProgStsCd().equals("Q")||hdrVO.getPgProgStsCd().equals("O")
									||hdrVO.getPgProgStsCd().equals("A")||hdrVO.getPgProgStsCd().equals("P")
									||hdrVO.getPgProgStsCd().equals("R")){//승인권자가 삭제한 경우
							if(preHdrVO.getPgProgStsCd().equals(hdrVO.getPgProgStsCd())){//화면 조회시의 ProgStsCd 와 같아야 함(T/C)
								PriScqAwkHdrVO updateVO = null;
								updateVO = hdrVO;
								updateVO.setDeltFlg("Y");
								if(updateVO.getPgProgStsCd() != null){
									updateVO.setProgStsCd(updateVO.getPgProgStsCd());
								}
								updateVO.setCreUsrId(account.getUsr_id());
								updateVO.setUpdUsrId(account.getUsr_id());
								dbDao.modifyPriScqAwkMn(updateVO); // Main 테이블 Update
								dbDao.addPriScqAwkProg(updateVO);  // Prog 테이블 Insert
								
								multiVO = updateVO;
							}
						}
					}
				}
			}
			
			// pri_scq_awk_cgo 테이블 
			if(cgoVOs != null){	
				List<PriScqAwkCgoVO> insertCgoVoList = new ArrayList<PriScqAwkCgoVO>();
				List<PriScqAwkCgoVO> updateCgoVoList = new ArrayList<PriScqAwkCgoVO>();
				List<PriScqAwkCgoVO> deleteCgoVoList = new ArrayList<PriScqAwkCgoVO>();		
				
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
					String nextCgoSeqStr = dbDao.searchPriScqAwkNewCgoSeq(insertCgoVoList.get(0));
					int nextCgoSeq = Integer.parseInt(nextCgoSeqStr); // 신규 생성될 CGO_SEQ 를 가져온다
					for(int i=0; i<insertCgoVoList.size(); i++){
						insertCgoVoList.get(i).setCgoSeq(Integer.toString(nextCgoSeq+i));
					}
					dbDao.addPriScqAwkCgoVOS(insertCgoVoList);
				}
				if ( updateCgoVoList.size() > 0 ) {
					dbDao.modifyPriScqAwkCgoVOS(updateCgoVoList);
				}
				if ( deleteCgoVoList.size() > 0 ) {
					dbDao.removePriScqAwkCgoVOS(deleteCgoVoList);
				}
			}
			// pri_scq_awk_rout 테이블 
			if(routVOs != null){		
				List<AwkCgoExtraCostByRouteVO> insertRoutVoList = new ArrayList<AwkCgoExtraCostByRouteVO>();		
	
				for ( int i=0; i<routVOs .length; i++ ) {
					routVOs[i].setScqRqstNo(multiVO.getScqRqstNo());
					routVOs[i].setScqVerNo(multiVO.getScqVerNo());
					if ( routVOs[i].getIbflag().equals("I")){
						routVOs[i].setCreUsrId(account.getUsr_id());				
						insertRoutVoList.add(routVOs[i]);
					}
				}
				if ( insertRoutVoList.size() > 0 ) {
					// 기존 데이터 부분 지우기
					dbDao.removePriScqAwkRoutDtlForCopy(multiVO);
					dbDao.removePriScqAwkRoutSmryForCopy(multiVO);
					dbDao.removePriScqAwkYdDtlForCopy(multiVO);
					dbDao.removePriScqAwkYdSmryForCopy(multiVO);
					dbDao.removePriScqAwkRoutForCopy(multiVO);
//					dbDao.removePriScqAwkCgoForCopy(multiVO);
					
//					dbDao.removePriScqAwkRoutVO(insertRoutVoList.get(0)); // 해당 rqst no 와 ver no 를 가진 row 를 지운다
					dbDao.addPriScqAwkRoutVOS(insertRoutVoList); // VO 리스트를 insert
				}
			}
			if(routCopyVO != null){
				copySaveRqstNo(routCopyVO, account);
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
		                
		                sendMailVO.setSubject("Approval Notice of The AWK Cargo Rate ( "+hdrVO.getScqRqstNo()+" )");
		                
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
		                sbHtmlContent.append("<tr><td style=\"font-family:arial,verdana; font-size: 16px; word-spacing:-0px; color: #313131; font-weight:bold;\">Re : Approval Notice of The AWK Cargo Rate <br><br></td></tr>");
		                sbHtmlContent.append("</table>");
		                sbHtmlContent.append("<table class=\"search\">");
		                sbHtmlContent.append("<tr><td class=\"bg\">");    
		                sbHtmlContent.append("<table border=\"0\" style=\"width:100%;\">");
		                sbHtmlContent.append("<tr>");
		                sbHtmlContent.append("<td style=\"padding:0px; font-family: Tahoma,verdana,arial,dotum,gulim; font-size: 16px; word-spacing:-0px;\">");

		                sbHtmlContent.append("Your Request No. ["+hdrVO.getScqRqstNo()+"] POL / "+hdrVO.getPolCd()+hdrVO.getPolYdCd()+", POD / "+hdrVO.getPodCd()+hdrVO.getPodYdCd()+" has been approved.<br>");
		                sbHtmlContent.append("Please check the results in system.<br>");
		                sbHtmlContent.append("<a href='" + SiteConfigFactory.get("COM.HANJIN.SYSTEM.DOMAIN_URL") + "hanjin/ESM_PRI_8003.do?p_rqstno="+hdrVO.getScqRqstNo()+"' style=\"color:#ff0000\" >[Link to Application Screen]</a> for Requester<br><br><a href='" + SiteConfigFactory.get("COM.HANJIN.SYSTEM.DOMAIN_URL") + "hanjin/ESM_PRI_8004.do?p_rqstno="+hdrVO.getScqRqstNo()+"' style=\"color:#ff0000\" >[Link to Approval Screen]</a> for Approver<br><br>");
		                
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
		                
		                		              
		                ScqAwkwardEAIDAO eaiDao = new ScqAwkwardEAIDAO();
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
		                
		                sendMailVO.setSubject("Reject Notice of The AWK Cargo Rate ( "+hdrVO.getScqRqstNo()+" )");
		                
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
		                sbHtmlContent.append("<tr><td style=\"font-family:arial,verdana; font-size: 16px; word-spacing:-0px; color: #313131; font-weight:bold;\">Re : Reject Notice of The AWK Cargo Rate<br><br></td></tr>");
		                sbHtmlContent.append("</table>");
		                sbHtmlContent.append("<table class=\"search\">");
		                sbHtmlContent.append("<tr><td class=\"bg\">");    
		                sbHtmlContent.append("<table border=\"0\" style=\"width:100%;\">");
		                sbHtmlContent.append("<tr>");
		                sbHtmlContent.append("<td style=\"padding:0px; font-family: Tahoma,verdana,arial,dotum,gulim; font-size: 16px; word-spacing:-0px;\">");
		                
		                sbHtmlContent.append("Your Request No. ["+hdrVO.getScqRqstNo()+"] POL / "+hdrVO.getPolCd()+hdrVO.getPolYdCd()+", POD / "+hdrVO.getPodCd()+hdrVO.getPodYdCd()+" has been rejected.<br>");
		                sbHtmlContent.append("Please check the reject reason in system.<br>");
		                sbHtmlContent.append("<a href='" + SiteConfigFactory.get("COM.HANJIN.SYSTEM.DOMAIN_URL") + "hanjin/ESM_PRI_8003.do?p_rqstno="+hdrVO.getScqRqstNo()+"' style=\"color:#ff0000\" >[Link to Application Screen]</a> for Requester<br><br><a href='" + SiteConfigFactory.get("COM.HANJIN.SYSTEM.DOMAIN_URL") + "hanjin/ESM_PRI_8004.do?p_rqstno="+hdrVO.getScqRqstNo()+"' style=\"color:#ff0000\" >[Link to Approval Screen]</a> for Approver<br><br>");
		                
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
		                
		                		              
		                ScqAwkwardEAIDAO eaiDao = new ScqAwkwardEAIDAO();
		                eaiDao.sendEmail(sendMailVO, toUser);   
		            } 
				}else if ( hdrVO.getProgStsCd().equals("C") && hdrVO.getPgProgStsCd().equals("A") ){ // Approval Cancel
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
		                
		                sendMailVO.setSubject("Approval Cancel Notice of The AWK Cargo Rate ( "+hdrVO.getScqRqstNo()+" )");
		                
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
		                sbHtmlContent.append("<tr><td style=\"font-family:arial,verdana; font-size: 16px; word-spacing:-0px; color: #313131; font-weight:bold;\">Re : Reject Notice of The AWK Cargo Rate<br><br></td></tr>");
		                sbHtmlContent.append("</table>");
		                sbHtmlContent.append("<table class=\"search\">");
		                sbHtmlContent.append("<tr><td class=\"bg\">");    
		                sbHtmlContent.append("<table border=\"0\" style=\"width:100%;\">");
		                sbHtmlContent.append("<tr>");
		                sbHtmlContent.append("<td style=\"padding:0px; font-family: Tahoma,verdana,arial,dotum,gulim; font-size: 16px; word-spacing:-0px;\">");
		                
		                sbHtmlContent.append("Approval of request No. ["+hdrVO.getScqRqstNo()+"] POL / "+hdrVO.getPolCd()+hdrVO.getPolYdCd()+", POD / "+hdrVO.getPodCd()+hdrVO.getPodYdCd()+" has been cancelled.<br>");
		                sbHtmlContent.append("Please check again revised results in system.<br>");
		                sbHtmlContent.append("<a href='" + SiteConfigFactory.get("COM.HANJIN.SYSTEM.DOMAIN_URL") + "hanjin/ESM_PRI_8003.do?p_rqstno="+hdrVO.getScqRqstNo()+"' style=\"color:#ff0000\" >[Link to Application Screen]</a> for Requester<br><br><a href='" + SiteConfigFactory.get("COM.HANJIN.SYSTEM.DOMAIN_URL") + "hanjin/ESM_PRI_8004.do?p_rqstno="+hdrVO.getScqRqstNo()+"' style=\"color:#ff0000\" >[Link to Approval Screen]</a> for Approver<br><br>");
		                
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
		                
		                		              
		                ScqAwkwardEAIDAO eaiDao = new ScqAwkwardEAIDAO();
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

	/*
	 * Calculation Part 
	 */
	
	/**
	 *  - Awkward Quotation 의 Cargo 정보를 조회 한다.
     *  - Temporary Calculation 에 적용하기 위해 본 테이블 ( PRI_SCQ_AWK_CGO ) 이 아닌 Temporary 테이블 ( PRI_SCQ_AWK_CGO_TMP ) 에 
     *    변경한 데이터를 저장하고 이를 대상으로 조회한다.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @return List<PriScqAwkCgoVO>
	 * @exception EventException
	 */
	public List<PriScqAwkCgoVO> searchPriScqAwkCgoTmp(PriScqAwkHdrVO priScqAwkHdrVO) throws EventException {
		try {
			return dbDao.searchPriScqAwkCgoTmp(priScqAwkHdrVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 *  - Awkward Cargo Quotation 의 Route 및 항목별 비용 정보 조회 
     *  - Calculation 의 결과로 생성된 TMP 테이블에서 가져온다.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @return List<AwkCgoExtraCostByRouteVO>
	 * @exception EventException
	 */
	public List<AwkCgoExtraCostByRouteVO> searchAwkCgoExtraCostByRouteTmp(PriScqAwkHdrVO priScqAwkHdrVO) throws EventException {
		try {
			return dbDao.searchAwkCgoExtraCostByRouteTmp(priScqAwkHdrVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	/**
	 * 
     * - Awkward 의 Cargo 와 Route 정보를 TES, TRS 에서 관리하는 테이터에 대조하여 
     *   각각의 비용을 계산한다.
     * - Temporary 하게 계산을 해 볼수 있도록 하기 위해 본 데이터를 TMP Table Set 로 Copy 하여 계산 결과를 저장한다..<br>
	 * 
	 * @param PriScqAwkCgoVO[] priScqAwkCgoVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public PriScqAwkHdrVO calcPriScqAwkTmp(PriScqAwkRqstVO priScqAwkRqstVO, SignOnUserAccount account) throws EventException{
		try {//PriScqAwkRqstVO
			PriScqAwkHdrVO hdrVO = priScqAwkRqstVO.getPriScqAwkHdrVO();
			PriScqAwkCgoVO[] cgoVOs = priScqAwkRqstVO.getPriScqAwkCgoVOs();
			AwkCgoExtraCostByRouteVO[] routVOs = priScqAwkRqstVO.getAwkCgoExtraCostByRouteVOs();
			/*
			PriScqAwkHdrVO hdrVO = null;
			if(hdrVOs != null){
				hdrVO = hdrVOs[0];
			}
			*/
			// pri_scq_awk_mn_tmp 테이블 
			if(hdrVO != null){
				hdrVO.setCreUsrId(account.getUsr_id());	
				if ( hdrVO.getScqVerNoTmp().length() != 3 ) {
					String newVerNoTmp = dbDao.searchPriScqAwkNewVerNoTmp(hdrVO);
					hdrVO.setScqVerNoTmp(newVerNoTmp);
					dbDao.addPriScqAwkMnTmp(hdrVO);
				} else {
					// 이전에 수행되었었던 Calculate 의 데이터를 삭제한다. 단 , PRI_SCQ_AWK_MN_TMP 는 다시 사용하므로 제외한다.
					this.removeTemporary(hdrVO, account, 0);					
				}
			}
			
			
			// pri_scq_awk_cgo_tmp 테이블 
			if(cgoVOs != null){	
				List<PriScqAwkCgoVO> insertCgoVoList = new ArrayList<PriScqAwkCgoVO>();
				
				int maxCgoSeq = 0;
				for ( int i=0; i<cgoVOs.length; i++ ) {
					if ( cgoVOs[i].getCgoSeq().length() > 0 ) {
						if ( Integer.parseInt(cgoVOs[i].getCgoSeq()) > maxCgoSeq ) {
							maxCgoSeq = Integer.parseInt(cgoVOs[i].getCgoSeq());
						}
					}
				}
				
				for ( int i=0; i<cgoVOs .length; i++ ) {
					if(!cgoVOs[i].getIbflag().equals("D")){
						cgoVOs[i].setScqRqstNo(hdrVO.getScqRqstNo());
						cgoVOs[i].setScqVerNoTmp(hdrVO.getScqVerNoTmp());
						cgoVOs[i].setCreUsrId(account.getUsr_id());	
						if ( cgoVOs[i].getCgoSeq().length() <= 0 ) {
							maxCgoSeq = maxCgoSeq + 1;
							cgoVOs[i].setCgoSeq(Integer.toString(maxCgoSeq));	
						}
						insertCgoVoList.add(cgoVOs[i]);
					}
				}
				if(insertCgoVoList.size()>0){
					dbDao.addPriScqAwkCgoTmpVOS(insertCgoVoList);
				}
			}
			// pri_scq_awk_rout_tmp 테이블 
			if(routVOs != null){		
				List<AwkCgoExtraCostByRouteVO> insertRoutVoList = new ArrayList<AwkCgoExtraCostByRouteVO>();		
	
				for ( int i=0; i<routVOs .length; i++ ) {
					routVOs[i].setScqRqstNo(hdrVO.getScqRqstNo());
					routVOs[i].setScqVerNoTmp(hdrVO.getScqVerNoTmp());
					routVOs[i].setCreUsrId(account.getUsr_id());	
					insertRoutVoList.add(routVOs[i]);
				}
				dbDao.addPriScqAwkRoutTmpVOS(insertRoutVoList); // VO 리스트를 insert
			}
			
			if(hdrVO != null && cgoVOs != null && routVOs != null ){
				// Rout Add-On 비용 계산 하기
				dbDao.calcPriScqAwkRoutDtlTmpAddOnCost(hdrVO);
				// Rout Shuttle 비용 계산 하기
				dbDao.calcPriScqAwkRoutDtlTmpShuttleCost(hdrVO);
				// Yard 별 Basic 비용 계산 하기
				dbDao.calcPriScqAwkYdDtlTmpBasic(hdrVO);
				// Yard 별 Wire, S.Gear 비용 계산 하기
				dbDao.calcPriScqAwkYdDtlTmpWireSGear(hdrVO);
				// Yard 별 T/S   비용 계산 하기
				dbDao.calcPriScqAwkYdDtlTmpTS(hdrVO);
				
				// Rout 비용 별 Summary Data 생성하기
				dbDao.calcPriScqAwkRoutSmryTmp(hdrVO);
				// Yard 비용 별 Summary Data 생성하기 
				dbDao.calcPriScqAwkYdSmryTmp(hdrVO);
			}
			
			return hdrVO;
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	/**
	 * TMP Table Set 에 생성된 계산 결과를 Transaction Table 로 옮겨서 저장한다..<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public PriScqAwkHdrVO copySave(PriScqAwkHdrVO priScqAwkHdrVO, SignOnUserAccount account) throws EventException{
		try {//PriScqAwkRqstVO
			PriScqAwkHdrVO hdrVO = priScqAwkHdrVO; // 메서드 수행 후 반환될 VO
			hdrVO.setCreUsrId(account.getUsr_id());	
						
			// 기존 데이터 부분 지우기
			dbDao.removePriScqAwkRoutDtlForCopy(hdrVO);
			dbDao.removePriScqAwkRoutSmryForCopy(hdrVO);
			dbDao.removePriScqAwkYdDtlForCopy(hdrVO);
			dbDao.removePriScqAwkYdSmryForCopy(hdrVO);
			dbDao.removePriScqAwkRoutForCopy(hdrVO);
			dbDao.removePriScqAwkCgoForCopy(hdrVO);
			
			// Tmp 에 생성되어 있는 데이터 부분 가져오기
			dbDao.copyPriScqAwkRout(hdrVO);
			dbDao.copyPriScqAwkCgo(hdrVO);
			dbDao.copyPriScqAwkRoutDtl(hdrVO);
			dbDao.copyPriScqAwkRoutSmry(hdrVO);
			dbDao.copyPriScqAwkYdDtl(hdrVO);
			dbDao.copyPriScqAwkYdSmry(hdrVO);
//			dbDao.copyPriScqAwkRout(hdrVO);
//			dbDao.copyPriScqAwkCgo(hdrVO);
			
			// Tmp 에 생성되어 있던 부분은 더이상 필요 없으므로 삭제  - Mn 을 포함하여 지운다
			removeTemporary ( hdrVO, account, 1 );
			
			return hdrVO;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * Counter Offer Cancel 처리..<br>
	 * C/Offer 로 생성된 새로운 Version No 의 Data Set ( Temporary Data Set 포함 ) 을 삭제하고 
     * 이전 상태 ( 이전 Version 의 Reject or Approved 상태 ) 로 복귀 
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public PriScqAwkHdrVO cancelCounterOffer(PriScqAwkHdrVO priScqAwkHdrVO, SignOnUserAccount account) throws EventException{
		try {//PriScqAwkRqstVO
			PriScqAwkHdrVO hdrVO = priScqAwkHdrVO; // 메서드 수행 후 반환될 VO
			hdrVO.setCreUsrId(account.getUsr_id());	
						
			// Tmp 에 생성되어 있던 부분은 더이상 필요 없으므로 삭제  - Mn 을 포함하여 지운다
			removeTemporary ( hdrVO, account, 1 );
			// 기존 데이터 부분 지우기
			// PRI_SCQ_AWK_MN, PRI_SCQ_PROG 삭제를 위한 것만 신규로 추가하고 
			// 나머지 삭제는 기존의 ForCopy 구문을 그대로 활용한다.
			dbDao.removePriScqAwkRoutDtlForCopy(hdrVO);
			dbDao.removePriScqAwkRoutSmryForCopy(hdrVO);
			dbDao.removePriScqAwkYdDtlForCopy(hdrVO);
			dbDao.removePriScqAwkYdSmryForCopy(hdrVO);
			dbDao.removePriScqAwkRoutForCopy(hdrVO);
			dbDao.removePriScqAwkCgoForCopy(hdrVO);
			dbDao.removePriScqProgAwk(hdrVO);
			dbDao.removePriScqAwkMn(hdrVO);
			
			List<PriScqAwkHdrVO> list = dbDao.searchPriScqAwkVerNo(priScqAwkHdrVO);
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
	 * 2.지워진 PRI_SCQ_PROG 상의 마지막 Approval 기록 직전의 Progress 상태로 PRI_SCQ_AWK_MN.PROG_STS_CD 변경 하기
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public PriScqAwkHdrVO cancelApproval(PriScqAwkHdrVO priScqAwkHdrVO, SignOnUserAccount account) throws EventException{
		try {//PriScqAwkRqstVO
			PriScqAwkHdrVO hdrVO = priScqAwkHdrVO; // 메서드 수행 후 반환될 VO
			hdrVO.setUpdUsrId(account.getUsr_id());	
						
			// PRI_SCQ_PROG 상의 마지막 Approval 기록 데이터 부분 지우기
			dbDao.removePriScqProgAwkForApprCxl(hdrVO);
			// 지워진 PRI_SCQ_PROG 상의 마지막 Approval 기록 직전의 Progress 상태로 PRI_SCQ_AWK_MN.PROG_STS_CD 변경 하기
			dbDao.modifyPriScqAwkMnForApprCxl(hdrVO);
						
			return hdrVO;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * Calculate 를 위해 생성한 Temporary Table 상의 데이터 삭제.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @param account SignOnUserAccount
	 * @paran int mnDelFlg
	 * @exception EventException
	 */
	public void removeTemporary(PriScqAwkHdrVO priScqAwkHdrVO, SignOnUserAccount account, int mnDelFlg ) throws EventException{
		try {//PriScqAwkRqstVO
			
			// Tmp 에 생성되어 있던 부분은 더이상 필요 없으므로 삭제 
			dbDao.removePriScqAwkRoutDtlTmp(priScqAwkHdrVO);
			dbDao.removePriScqAwkRoutSmryTmp(priScqAwkHdrVO);
			dbDao.removePriScqAwkYdDtlTmp(priScqAwkHdrVO);
			dbDao.removePriScqAwkYdSmryTmp(priScqAwkHdrVO);
			dbDao.removePriScqAwkRoutTmp(priScqAwkHdrVO);
			dbDao.removePriScqAwkCgoTmp(priScqAwkHdrVO);
			if ( mnDelFlg == 1 ) dbDao.removePriScqAwkMnTmp(priScqAwkHdrVO);
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Awkward Cargo Quotation 의 Cargo 별 Route 의 각 항목별 비용 정보 상세 조회.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @return List<AwkCostByCgoRoutVO>
	 * @exception EventException
	 */
	public List<AwkCostByCgoRoutVO> searchAwkCostByCgoRout(PriScqAwkHdrVO priScqAwkHdrVO) throws EventException {
		try {
			return dbDao.searchAwkCostByCgoRout(priScqAwkHdrVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	
	/**
	 *  - Awkward Cargo Quotation 의 Cargo 별 Route 의 각 항목별 비용 정보 상세 조회
     *  - Calculation 의 결과로 생성된 TMP 테이블에서 가져온다.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @return List<AwkCostByCgoRoutVO>
	 * @exception EventException
	 */
	public List<AwkCostByCgoRoutVO> searchAwkCostByCgoRoutTmp(PriScqAwkHdrVO priScqAwkHdrVO) throws EventException {
		try {
			return dbDao.searchAwkCostByCgoRoutTmp(priScqAwkHdrVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * Office Hierarchy List 조회.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @return List<OrganizationVO>
	 * @exception EventException
	 */
	public List<OrganizationVO> searchOfficeHierarchyList(PriScqAwkHdrVO priScqAwkHdrVO) throws EventException {
		try {
			return dbDao.searchOfficeHierarchyList(priScqAwkHdrVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * Request or C/Offer 의 진행으로 새로운 Version No 의 Table Set 으로 옮겨서 저장한다.<br>
	 * 
	 * @param PriScqAwkHdrVO priScqAwkHdrVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public PriScqAwkHdrVO copySaveRqstNo(PriScqAwkHdrVO priScqAwkHdrVO, SignOnUserAccount account) throws EventException{
		try {//PriScqAwkRqstVO
			PriScqAwkHdrVO hdrVO = priScqAwkHdrVO; // 메서드 수행 후 반환될 VO
			hdrVO.setCreUsrId(account.getUsr_id());	
			
			// 기존 데이터 부분 지우기
			dbDao.removePriScqAwkRoutDtlForCopy(hdrVO);
			dbDao.removePriScqAwkRoutSmryForCopy(hdrVO);
			dbDao.removePriScqAwkYdDtlForCopy(hdrVO);
			dbDao.removePriScqAwkYdSmryForCopy(hdrVO);
			dbDao.removePriScqAwkRoutForCopy(hdrVO);
			
			// Tmp 에 생성되어 있는 데이터 부분 가져오기
			//dbDao.copyPriScqAwkRqstNoCgo(hdrVO);
			dbDao.copyPriScqAwkRqstNoRout(hdrVO);
			dbDao.copyPriScqAwkRqstNoRoutSmry(hdrVO);
			dbDao.copyPriScqAwkRqstNoRoutDtl(hdrVO);
			dbDao.copyPriScqAwkRqstNoYdSmry(hdrVO);
			dbDao.copyPriScqAwkRqstNoYdDtl(hdrVO);
			
			return hdrVO;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
}