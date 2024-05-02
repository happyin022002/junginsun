/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CSRExternalFinderBCImpl.java
*@FileTitle : 공통유틸
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.15
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.10.15 함대성
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.csr.csrcommon.csrexternalfinder.basic;

import java.util.ArrayList;
import java.util.List;
 
import com.hanjin.bizcommon.csr.csrcommon.csrexternalfinder.integration.CSRExternalFinderDBDAO;
import com.hanjin.bizcommon.csr.csrcommon.csrexternalfinder.vo.SpCsrVO;
import com.hanjin.framework.component.message.ErrorHandler; 
import com.hanjin.framework.core.layer.event.EventException; 
import com.hanjin.framework.core.layer.integration.DAOException; 
import com.hanjin.framework.support.layer.basic.BasicCommandSupport; 
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ApPayInvDtlVO;
import com.hanjin.syscommon.common.table.ApPayInvVO;
/**
 * NIS2010-SCGCommon Business Logic Basic Command implementation<br>
 * - NIS2010-SCGCommon에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Dohyoung Lee
 * @see SCG_COM_EventResponse,SCGExternalFinderBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class CSRExternalFinderBCImpl extends BasicCommandSupport implements CSRExternalFinderBC {

	// Database Access Object
	private transient CSRExternalFinderDBDAO dbDao = null;

	/**
	 * SCGExternalFinderBCImpl 객체 생성<br>
	 * CSRExternalFinderDBDAO를 생성한다.<br>
	 */
	public CSRExternalFinderBCImpl() {
		dbDao = new CSRExternalFinderDBDAO();
	}
	
//	/**
//	 * PSO의 2Phase Commit을 지원하기 위한 Parameterized Default Constructor
//	 * @param dataSource
//	 */
//	public CSRExternalFinderBCImpl(String dataSource) {
//		dbDao = new CSRExternalFinderDBDAO(dataSource);
//	}

	/**
	 * CSR_0001 : 공통<br>
	 * vendor체크 조회 처리<br>
	 * @param String vndrSeq
	 * @return SpCsrVO
	 * @exception EventException
	 */
	public SpCsrVO checkVendor(String vndrSeq) throws EventException {
		try { 
			//다건조회       
			List<SpCsrVO> spCsrVOLst = null;
			SpCsrVO spCsrVO = new SpCsrVO();
			
			spCsrVOLst = dbDao.checkVendor(vndrSeq);
			
			if(spCsrVOLst.size() > 0){   
				spCsrVO.setVndrSeq(spCsrVOLst.get(0).getVndrSeq());
				spCsrVO.setVndrLglEngNm(spCsrVOLst.get(0).getVndrLglEngNm());
				spCsrVO.setVndrSeqExisting(spCsrVOLst.get(0).getVndrSeqExisting());
			}
			return spCsrVO;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
 			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), ex);
		}
	}
	
	/**
	 * CSR_0008 : 공통<br>
	 * 권한 로케이션 날짜 조회 처리<br>
	 * @param String ofcCd
	 * @return SpCsrVO
	 * @exception EventException
	 */
	public SpCsrVO getDBdate(String ofcCd) throws EventException {
		try { 
			//다건조회       
			List<SpCsrVO> spCsrVOLst = null;
			SpCsrVO spCsrVO = new SpCsrVO();
			
			spCsrVOLst = dbDao.getDBdate(ofcCd);
			
			if(spCsrVOLst.size() > 0){   
				spCsrVO.setCurrDate(spCsrVOLst.get(0).getCurrDate());
			}
			return spCsrVO;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
 			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), ex);
		}
	}
	
	/**
	 * CSR_0008 : 공통<br>
	 * Office change기능 추가로 인해 session의 ofc_cd를 기준으로 (session이 아닌) MDM의 cnt_cd를 조회 <br>
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String getMDMCntCd(String ofcCd) throws EventException {
		
		try {
			return dbDao.getMDMCntCd(ofcCd);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
 			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), ex);
		}
	}

	/**
	 * AP연계 인터페이스 : 공통
	 * AP_PAY_INV 및 AP_PAY_INV_DTL 목록 저장<br>
	 * @param ApPayInvVO apPayInvVO
	 * @param ApPayInvDtlVO[] apPayInvDtlVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String createApPayInvInfo(ApPayInvVO apPayInvVO, ApPayInvDtlVO[] apPayInvDtlVOs, SignOnUserAccount signOnUserAccount) throws EventException {
		String invRgstNo = "";
		String vndrSeq   = "";
		String ttlLssDivCd = "";
		String invIssDt  = "";
		String mdfChk    = "";	//입력로직
		try {
			//생성자 OR 수정자 
			String usrIdStr = (String)signOnUserAccount.getUsr_id();
			String invOfcCd = apPayInvVO.getInvOfcCd();
			//AP_PAY_INV 정보를 생성합니다.
			apPayInvVO.setCreUsrId(usrIdStr);
			apPayInvVO.setUpdUsrId(usrIdStr);
			invRgstNo = apPayInvVO.getInvRgstNo() != null ? apPayInvVO.getInvRgstNo() : "";
			invIssDt  = apPayInvVO.getInvIssDt()  != null ? apPayInvVO.getInvIssDt()  : "";
			//2010-02-22 vndor 체크
			vndrSeq   = apPayInvVO.getVndrSeq()   != null ? apPayInvVO.getVndrSeq()   : "";
			
			// 1. AP_PAY_INV 생성및 수정 - KRW, JPY 의 경우 ROUND(금액,0) 처리후 저장 
			if(invRgstNo.equals("")){ //생성
				//inv_iss_dt null 체크 - CSR00082
				if(invIssDt.equals("")){
					log.error("\n\n Wrong inv_iss_dt null--------------------- \n\n");
					throw new DAOException((new ErrorHandler("CSR00082").getMessage()));
				}
				//vndr_seq null 체크 - CSR00093
				if(vndrSeq.equals("")){
					log.error("\n\n Wrong vndr_seq null--------------------- \n\n");
					throw new DAOException((new ErrorHandler("CSR00093").getMessage()));
				}
				
				//invRgstNo 조회
				invRgstNo = dbDao.srchInvRgstNo(apPayInvVO);
				apPayInvVO.setInvRgstNo(invRgstNo);
				
				//INV_NO DUP CHK
				dbDao.searchInvNOChk(apPayInvVO);
				
				dbDao.addApPayInv(apPayInvVO);
				
				mdfChk = "N";	//입력로직
			}else{
				mdfChk = "Y";	//수정로직
				//상태체크 조회 후 에러메세지 여부체크 
				dbDao.searchStsChk(apPayInvVO);
				//수정
				dbDao.modifyApPayInv(apPayInvVO);
			}
			
			//AP_PAY_INV_DTL목록 목록을 일괄 생성합니다.
			List<ApPayInvDtlVO> insertVoList = new ArrayList<ApPayInvDtlVO>();
			List<ApPayInvDtlVO> updateVoList = new ArrayList<ApPayInvDtlVO>();	
			for(int i = 0; i < apPayInvDtlVOs.length; i++ ) {
				if(apPayInvDtlVOs[i].getIbflag().equals("I")) {
					apPayInvDtlVOs[i].setCreUsrId(usrIdStr);
					apPayInvDtlVOs[i].setUpdUsrId(usrIdStr);
					apPayInvDtlVOs[i].setInvRgstNo(invRgstNo);
					apPayInvDtlVOs[i].setCreDt(invOfcCd);
					
					insertVoList.add(apPayInvDtlVOs[i]);
				}else if(apPayInvDtlVOs[i].getIbflag().equals("U")) {
					apPayInvDtlVOs[i].setUpdUsrId(usrIdStr);
					apPayInvDtlVOs[i].setInvRgstNo(invRgstNo);
					apPayInvDtlVOs[i].setCreDt(invOfcCd);
					
					updateVoList.add(apPayInvDtlVOs[i]);
				}
			}
			if(insertVoList.size() > 0) {
				dbDao.addApPayInvDtl(insertVoList);
				
				apPayInvVO.setInvOfcCd(invOfcCd);
				// 2. AP_PAY_INV INV_NET_AMT 와 AP_PAY_INV_DTL INV_AMT 합이 다를 경우 에러 - KRW, JPY 의 경우 ROUND(금액,0) 처리후 비교
	 			dbDao.searchApInvAmtChk(apPayInvVO);
	 			
	 			ttlLssDivCd = apPayInvVO.getTtlLssDivCd() != null ? apPayInvVO.getTtlLssDivCd() : "";
	 			
	 			//PL, PO제외 AP_PAY_INV & AP_PAY_INV 비용비교 
	 			if(!(ttlLssDivCd.equals("PL") || ttlLssDivCd.equals("PO"))){
	 				dbDao.searchApInvVsAmtChk(apPayInvVO);
	 			}
			}else{	//AP_PAY_INV_DTL 테이블에 등록할 데이타가 없는 경우
				if(mdfChk.equals("N")){	//입력로직인 경우
					throw new DAOException((new ErrorHandler("CSR00009", new String[]{"Invoice Detail"})).getMessage());
				}
			}
			if(updateVoList.size() > 0) {	//삭제플래그
				dbDao.modifyApPayInvDtl(updateVoList);
			}
			
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(de.getMessage());
			//throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(ex.getMessage());
			//throw new EventException(new ErrorHandler("CSR00010", new String[]{" "}).getMessage(), ex);
		}
		return invRgstNo;
	}
	 
}