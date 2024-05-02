/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ManualRegisterBCImpl.java
*@FileTitle : ManualRegister
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 변종건
*@LastVersion : 1.0
* 2009.07.17 변종건
* 1.0 Creation
* 2011.01.10 손은주 [CHM-201108195-01] [TPB] WAS  로그 모니터링 (일부 Candidate PK구하는 값이 null이거나 이상한 값이 들어가는 현상) 수정
* 2015.04.07 KIM HYUN HWA[CHM-201535074]TPB에서 REV VVD 로직 보완 요청( BKG VVD 및 Finc Dir check 로직 추가)
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.integration.ManualRegisterDBDAO;
import com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.vo.CreateEACRegistrationVO;
import com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.vo.CreateTPBCandidateVO;
import com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.vo.SearchContainerInfoVO;
import com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.vo.SearchEQKindVO;
import com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.vo.SearchTPBDuplicationListVO;
import com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.vo.SearchTPBOfficeListVO;
import com.hanjin.apps.alps.esd.tpb.common.TPBUtils;
import com.hanjin.apps.alps.esd.tpb.common.combo.event.CommonCodeEvent;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
 
/**
 * ALPS-CandidateManage Business Logic Basic Command implementation<br>
 * - ALPS-CandidateManage에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Jong-Geon Byeon
 * @see ESD_TPB_0133EventResponse,ManualRegisterBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class ManualRegisterBCImpl extends BasicCommandSupport implements ManualRegisterBC {

	// Database Access Object
	private transient ManualRegisterDBDAO dbDao = null;

	/**
	 * ManualRegisterBCImpl 객체 생성<br>
	 * ManualRegisterDBDAO를 생성한다.<br>
	 */
	public ManualRegisterBCImpl() {
		dbDao = new ManualRegisterDBDAO();
	}
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 *
	 * @param SearchTPBDuplicationListVO searchTPBDuplicationListVO
	 * @param account SignOnUserAccount
	 * @return List<SearchTPBDuplicationListVO>
	 * @exception EventException
	 */
	public List<SearchTPBDuplicationListVO> searchTPBDuplicationList(SearchTPBDuplicationListVO searchTPBDuplicationListVO, SignOnUserAccount account) throws EventException {
		try {

			String sOfcCdTmp = JSPUtil.getNull(searchTPBDuplicationListVO.getSOfcCd());
			if (sOfcCdTmp.length()==0){
				searchTPBDuplicationListVO.setSOfcCd(account.getOfc_cd());
			}
			
			String seqnoTmp = searchTPBDuplicationListVO.getSEqNo();
			if(seqnoTmp != null && !seqnoTmp.equals("")){			
				seqnoTmp = JSPUtil.getTypeString(seqnoTmp);
				searchTPBDuplicationListVO.setSEqNo(seqnoTmp);
			}
			
			return dbDao.searchTPBDuplicationList(searchTPBDuplicationListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	} 
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchContainerInfoVO searchContainerInfoVO
	 * @return List<SearchContainerInfoVO>
	 * @exception EventException
	 */
	public List<SearchContainerInfoVO> searchContainerInfo(SearchContainerInfoVO searchContainerInfoVO) throws EventException {
		try {
			return dbDao.searchContainerInfo(searchContainerInfoVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param CreateTPBCandidateVO[] createTPBCandidateVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 * @throws DAOException 
	 */
	public void createTPBCandidate(CreateTPBCandidateVO[] createTPBCandidateVO, SignOnUserAccount account) throws EventException, DAOException{
		
		CreateTPBCandidateVO sTcVO = new CreateTPBCandidateVO();
		sTcVO = createTPBCandidateVO[0];
		
		HashMap params = new HashMap();
		
		String s_n3pty_if_tp_cd = sTcVO.getSN3ptyIfTpCd();
		String s_n3pty_expn_tp_cd = sTcVO.getSN3ptyExpnTpCd();
		String s_vndr_cust_div_cd = sTcVO.getSVndrCustDivCd();
		String s_bkg_no_all = sTcVO.getSBkgNoAll();
		String s_n3pty_src_no = sTcVO.getSN3ptySrcNo();
		String s_src_vndr_no = sTcVO.getSSrcVndrSeq();
		String s_user_id = sTcVO.getUserId();
		String s_if_amt = sTcVO.getIfAmt();
		log.debug("s_user_id=====================>>>>>>>>>>>>>>>>>>>>"+s_user_id);
		log.debug("account.getUsr_id()=====================>>>>>>>>>>>>>>>>>>>>"+account.getUsr_id());
		log.debug("s_if_amt=====================>>>>>>>>>>>>>>>>>>>>"+s_if_amt);
		//VVDStr 사용
		String s_vvd = sTcVO.getSVvd();
		String s_yd_cd = sTcVO.getSYdCd();
		
		// 유효성 검사
		params.put("s_if_ofc_cd", sTcVO.getSIfOfcCd());
		params.put("s_bkg_no", sTcVO.getSBkgNo());
		CommonCodeEvent event = new CommonCodeEvent();
		event.setEventParams(params);
		try {
			
			// Office 유효성 검사
			if(!sTcVO.getSIfOfcCd().equals("") && !TPBUtils.checkVaildate(event, "checkOffice")){
				throw new EventException(new ErrorHandler("TPB00003").getMessage());
			}	
			// BKG No 유효성 검사
			if(!sTcVO.getSBkgNo().equals("") && !TPBUtils.checkVaildate(event, "checkBKGNo")){
				throw new EventException(new ErrorHandler("TPB00054").getMessage());
			}
			// B/L No 유효성 검사
			if(!sTcVO.getSBlNo().equals("") && !TPBUtils.checkVaildate(event, "checkBLNo")){
				throw new EventException(new ErrorHandler("TPB00055").getMessage());
			}
	
			//Invoice No 에 대해 정보 유효성검사	
			
			String svrid = dbDao.searchSVRID(createTPBCandidateVO[0]);
			if(svrid == null){
				throw new EventException(new ErrorHandler("TPB00058").getMessage());
			}
			createTPBCandidateVO[0].setSSvrId(svrid); // to save to DB Table
			
			if( sTcVO.getSSrcVndrCntCd().equals("") && !sTcVO.getSSrcVndrSeq().equals("")){
				String s_src_vndr_cnt_cd = dbDao.searchVndrCntCd(createTPBCandidateVO[0]);
				if(!s_src_vndr_cnt_cd.equals("")){
					createTPBCandidateVO[0].setSSrcVndrCntCd(s_src_vndr_cnt_cd);
				}
			}
			
			createTPBCandidateVO[0].setSN3ptySrcSubSysCd(s_n3pty_expn_tp_cd);
			
			if(s_vndr_cust_div_cd.equals("V")){
				createTPBCandidateVO[0].setSVndrLglEngNm(sTcVO.getSTrdPartyNm());
			}else if(s_vndr_cust_div_cd.equals("C")){
				createTPBCandidateVO[0].setSCustLglEngNm(sTcVO.getSTrdPartyNm());	
			}
			
//			if(s_n3pty_if_tp_cd.equals("S") && s_n3pty_expn_tp_cd.equals("MNR")){  //Interface Type 이 Source 이고, Expense Type이 MNR 일때
//				createTPBCandidateVO[0].setSAcctCd("511511");
//				createTPBCandidateVO[0].setSLgsCostCd("MRCNCT");
//			} 
	
			if(!s_bkg_no_all.equals("")){//SearchStr 사용
				String[] vvd = null;
				vvd = dbDao.searchStr(createTPBCandidateVO[0]);
	
				if(!"".equals(vvd[0])){
					createTPBCandidateVO[0].setSVslCd(vvd[0]);
				}
				if(!"".equals(vvd[1])){
					createTPBCandidateVO[0].setSSkdVoyNo(vvd[1]);
				}
				if(!JSPUtil.getNull(vvd[2]).equals("")){
					createTPBCandidateVO[0].setSSkdDirCd(vvd[2].substring(0,1));
					createTPBCandidateVO[0].setSBkgFincDirCd(vvd[2].substring(0,2));
				}
			}else{//SearchVVDStr
				if(!s_vvd.equals("") && !s_yd_cd.equals("")){
					String vvd = dbDao.searchVVDStr(createTPBCandidateVO[0]);
					if(!vvd.equals("")){
						createTPBCandidateVO[0].setSBkgFincDirCd(vvd);
					}
				}
			}
			
			String s_bkg_finc_dir_cd = createTPBCandidateVO[0].getSBkgFincDirCd();
			//* 2009-01-15 O Wan-Ki 1.1 TPB VVD Role 에 따른 변경.
			if(s_bkg_finc_dir_cd == null || s_bkg_finc_dir_cd.length() == 0){ 
				String s_skd_dir_cd =  createTPBCandidateVO[0].getSSkdDirCd();
				createTPBCandidateVO[0].setSBkgFincDirCd(s_skd_dir_cd+s_skd_dir_cd);
			}
			
			createTPBCandidateVO[0].setSCostExptFlg(s_n3pty_if_tp_cd.equals("M")?"Y":"N"); //Cost Exception 일 경우 'Y'
			
			//SearchTESStr
			if(s_n3pty_expn_tp_cd.equals("TES")){
				if(!s_n3pty_src_no.equals("") && !s_src_vndr_no.equals("")){
					String tes = dbDao.searchTESStr(createTPBCandidateVO[0]);
					if(!tes.equals("") ){
						createTPBCandidateVO[0].setSTmlInvTpCd(tes);
					}
				}
			}
		
		}catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		if(createTPBCandidateVO.length > 1){
			CreateTPBCandidateVO cTcVO = createTPBCandidateVO[0];
			//ibFlag,ifAmt,eqTpCd,eqNo,eqTpszCd; // 제외
			for (int i = 1; i < createTPBCandidateVO.length; i++) {
				createTPBCandidateVO[i].setSSkdVoyNo(cTcVO.getSSkdVoyNo());
				createTPBCandidateVO[i].setSBkgNoAll(cTcVO.getSBkgNoAll());
				createTPBCandidateVO[i].setSN3ptyBilTpCd(cTcVO.getSN3ptyBilTpCd());
				createTPBCandidateVO[i].setSVslCd(cTcVO.getSVslCd());
				createTPBCandidateVO[i].setSCustSeq(cTcVO.getSCustSeq());
				createTPBCandidateVO[i].setSCustLglEngNm(cTcVO.getSCustLglEngNm());
				createTPBCandidateVO[i].setSBkgNo(cTcVO.getSBkgNo());
				createTPBCandidateVO[i].setSSvrId(cTcVO.getSSvrId());                                  
				createTPBCandidateVO[i].setSCurrCd(cTcVO.getSCurrCd());                                  
				createTPBCandidateVO[i].setSFileNo(cTcVO.getSFileNo());
				createTPBCandidateVO[i].setSBkgFincDirCd(cTcVO.getSBkgFincDirCd());
				createTPBCandidateVO[i].setSTrdPartyNm(cTcVO.getSTrdPartyNm());
				createTPBCandidateVO[i].setPagerows(cTcVO.getPagerows());
				createTPBCandidateVO[i].setSVndrCntCd(cTcVO.getSVndrCntCd());
				createTPBCandidateVO[i].setSBlNo(cTcVO.getSBlNo());
				createTPBCandidateVO[i].setSLgsCostCd(cTcVO.getSLgsCostCd());
				createTPBCandidateVO[i].setSCostExptFlg(cTcVO.getSCostExptFlg());
				createTPBCandidateVO[i].setSN3ptyOfcCd(cTcVO.getSN3ptyOfcCd());
				createTPBCandidateVO[i].setSSoNo(cTcVO.getSSoNo());
				createTPBCandidateVO[i].setUserId(cTcVO.getUserId());
				createTPBCandidateVO[i].setSMnlInpTpCd(cTcVO.getSMnlInpTpCd());
				createTPBCandidateVO[i].setSIfDt(cTcVO.getSIfDt());
				createTPBCandidateVO[i].setSYdCd(cTcVO.getSYdCd());
				createTPBCandidateVO[i].setSIfRmk(cTcVO.getSIfRmk());
				createTPBCandidateVO[i].setSN3ptySrcNo(cTcVO.getSN3ptySrcNo());
				createTPBCandidateVO[i].setSVndrSeq(cTcVO.getSVndrSeq());
				createTPBCandidateVO[i].setSCustCntCd(cTcVO.getSCustCntCd());
				createTPBCandidateVO[i].setSSrcVndrSeq(cTcVO.getSSrcVndrSeq());
				createTPBCandidateVO[i].setSVvd(cTcVO.getSVvd());
				createTPBCandidateVO[i].setSIfOfcCd(cTcVO.getSIfOfcCd());
				createTPBCandidateVO[i].setSVndrCustDivCd(cTcVO.getSVndrCustDivCd());
				createTPBCandidateVO[i].setSSkdDirCd(cTcVO.getSSkdDirCd());
				createTPBCandidateVO[i].setOfcCd(cTcVO.getOfcCd());
				createTPBCandidateVO[i].setSVndrLglEngNm(cTcVO.getSVndrLglEngNm());
				createTPBCandidateVO[i].setSN3ptySrcSubSysCd(cTcVO.getSN3ptySrcSubSysCd());
				createTPBCandidateVO[i].setSN3ptyIfTpCd(cTcVO.getSN3ptyIfTpCd());
				createTPBCandidateVO[i].setSSrcVndrCntCd(cTcVO.getSSrcVndrCntCd());
				createTPBCandidateVO[i].setSN3ptyExpnTpCd(cTcVO.getSN3ptyExpnTpCd());
				createTPBCandidateVO[i].setSAcctCd(cTcVO.getSAcctCd());
				createTPBCandidateVO[i].setSTmlInvTpCd(cTcVO.getSTmlInvTpCd());
				createTPBCandidateVO[i].setEacTpCd(cTcVO.getEacTpCd());
			}
			
		}
		
		try {
			List<CreateTPBCandidateVO> insertVoList = new ArrayList<CreateTPBCandidateVO>();
			
			if(createTPBCandidateVO != null){
				for ( int i=0; i<createTPBCandidateVO.length; i++ ) {
					if ( createTPBCandidateVO[i].getIbflag().equals("I")){
						createTPBCandidateVO[i].setUserId(account.getUsr_id());
						createTPBCandidateVO[i].setOfcCd(account.getOfc_cd());
						//OTS_DTL_SEQ 체크
						if(createTPBCandidateVO[i].getOtsDtlSeq() == null || "".equals(createTPBCandidateVO[i].getOtsDtlSeq())){
							createTPBCandidateVO[i].setOtsDtlSeq(dbDao.searchOtsDtlSeq());
						}else{
							String tmp_dtl_seq = "";
							tmp_dtl_seq = dbDao.searchGetOtsDtlSeq(createTPBCandidateVO[i].getOtsDtlSeq());
							if(!"".equals(tmp_dtl_seq)){
								createTPBCandidateVO[i].setOtsDtlSeq(dbDao.searchOtsDtlSeq());
							}
							
						}
						insertVoList.add(createTPBCandidateVO[i]);
					} 
				}
			}
			if ( insertVoList.size() > 0 ) {
				int insCnt[] = null;
				int insCntS[] = null;
				insCnt = dbDao.addTPBCandidate(insertVoList);
				insCntS = dbDao.createTPBStatus(insertVoList);
			}

		} catch(DAOException ex) {
			log.error("err " + ex.toString() + "createTPBCandidateVO[0].getOtsDtlSeq()===>" 
					+ createTPBCandidateVO[0].getOtsDtlSeq(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString() + "createTPBCandidateVO[0].getOtsDtlSeq()===>" 
					+ createTPBCandidateVO[0].getOtsDtlSeq(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param CreateEACRegistrationVO[] createEACRegistrationVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createEACRegistration(CreateEACRegistrationVO[] createEACRegistrationVO, SignOnUserAccount account) throws EventException{
		CreateEACRegistrationVO cErVO = createEACRegistrationVO[0];
		
		String s_vndr_cust_div_cd = cErVO.getSVndrCustDivCd();
		
		try {
			String svrid = dbDao.searchSvrId(createEACRegistrationVO[0]);
			if(svrid == null){
				throw new EventException(new ErrorHandler("TPB00058").getMessage());
			}
			createEACRegistrationVO[0].setSSvrId(svrid);
			
			if(s_vndr_cust_div_cd.equals("V")){
				createEACRegistrationVO[0].setSVndrLglEngNm(cErVO.getSTrdPartyNm());
			}else if(s_vndr_cust_div_cd.equals("C")){
				createEACRegistrationVO[0].setSCustLglEngNm(cErVO.getSTrdPartyNm());
			}
	
			String s_bkg_finc_dir_cd = createEACRegistrationVO[0].getSBkgFincDirCd();
	
			if(s_bkg_finc_dir_cd == null || s_bkg_finc_dir_cd.length() == 0){ 
				String s_skd_dir_cd =  createEACRegistrationVO[0].getSSkdDirCd();
				createEACRegistrationVO[0].setSBkgFincDirCd(s_skd_dir_cd + s_skd_dir_cd);
			}
		}catch(DAOException ex) {
			log.error(ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
		if(createEACRegistrationVO.length > 1){
		
			for (int i = 1; i < createEACRegistrationVO.length; i++) {
				CreateEACRegistrationVO sErVO = createEACRegistrationVO[i];
				
				createEACRegistrationVO[i].setSSrcVndrNo(cErVO.getSSrcVndrNo());
				createEACRegistrationVO[i].setSRegType(cErVO.getSRegType());
				createEACRegistrationVO[i].setSSkdVoyNo(cErVO.getSSkdVoyNo());
				createEACRegistrationVO[i].setSBkgNoAll(cErVO.getSBkgNoAll());
				createEACRegistrationVO[i].setSN3ptyBilTpCd(cErVO.getSN3ptyBilTpCd());
				createEACRegistrationVO[i].setSVslCd(cErVO.getSVslCd());
				createEACRegistrationVO[i].setSCustSeq(cErVO.getSCustSeq());
				createEACRegistrationVO[i].setSBkgNo(cErVO.getSBkgNo());
				createEACRegistrationVO[i].setSBlNoTp(cErVO.getSBlNoTp());
				createEACRegistrationVO[i].setSEqTpszCd(cErVO.getSEqTpszCd());
				createEACRegistrationVO[i].setSBlNoChk(cErVO.getSBlNoChk());
				createEACRegistrationVO[i].setSTrdPartyVal(cErVO.getSTrdPartyVal());
				createEACRegistrationVO[i].setSVndrCntCd(cErVO.getSVndrCntCd());
				createEACRegistrationVO[i].setSBlNo(cErVO.getSBlNo());
				createEACRegistrationVO[i].setEqNo(sErVO.getEqNo());//
				createEACRegistrationVO[i].setSN3ptyOfcCd(cErVO.getSN3ptyOfcCd());
				createEACRegistrationVO[i].setSYdCd(cErVO.getSYdCd());
				createEACRegistrationVO[i].setSIfDt(cErVO.getSIfDt());
				createEACRegistrationVO[i].setSIfRmk(cErVO.getSIfRmk());
				createEACRegistrationVO[i].setSEdate(cErVO.getSEdate());
				createEACRegistrationVO[i].setSN3ptySrcNo(cErVO.getSN3ptySrcNo());
				createEACRegistrationVO[i].setSIfAmt(cErVO.getSIfAmt());
				createEACRegistrationVO[i].setSVndrSeq(cErVO.getSVndrSeq());
				createEACRegistrationVO[i].setSCustCntCd(cErVO.getSCustCntCd());
				createEACRegistrationVO[i].setSBlNoAll(cErVO.getSBlNoAll());
				createEACRegistrationVO[i].setSSdate(cErVO.getSSdate());
				createEACRegistrationVO[i].setSSrcVndrSeq(cErVO.getSSrcVndrSeq());
				createEACRegistrationVO[i].setSVvd(cErVO.getSVvd());
				createEACRegistrationVO[i].setSIfOfcCd(cErVO.getSIfOfcCd());
				createEACRegistrationVO[i].setSSkdDirCd(cErVO.getSSkdDirCd());
				createEACRegistrationVO[i].setEqTpszCd(sErVO.getEqTpszCd());//
				createEACRegistrationVO[i].setSBilTpCd(cErVO.getSBilTpCd());
				createEACRegistrationVO[i].setSEqNo(cErVO.getSEqNo());
				createEACRegistrationVO[i].setSN3ptyIfTpCd(cErVO.getSN3ptyIfTpCd());
				createEACRegistrationVO[i].setSUserId(cErVO.getSUserId());
				createEACRegistrationVO[i].setSSrcVndrCntCd(cErVO.getSSrcVndrCntCd());
				createEACRegistrationVO[i].setIfAmt(sErVO.getIfAmt());//
				createEACRegistrationVO[i].setSN3ptyExpnTpCd(cErVO.getSN3ptyExpnTpCd());
				createEACRegistrationVO[i].setEqTpCd(sErVO.getEqTpCd());//
				createEACRegistrationVO[i].setSBkgNoSplit(cErVO.getSBkgNoSplit());
				createEACRegistrationVO[i].setSEqTpCd(cErVO.getSEqTpCd());
				createEACRegistrationVO[i].setSEdnTpCd(cErVO.getSEdnTpCd());
				createEACRegistrationVO[i].setSVndrCustDivCd(cErVO.getSVndrCustDivCd());
				createEACRegistrationVO[i].setSVndrLglEngNm(cErVO.getSTrdPartyNm());
				createEACRegistrationVO[i].setSCustLglEngNm(cErVO.getSCustLglEngNm());
				createEACRegistrationVO[i].setSCurrCd(cErVO.getSCurrCd()); 
				createEACRegistrationVO[i].setSSvrId(cErVO.getSSvrId()); 
				createEACRegistrationVO[i].setSBkgFincDirCd(cErVO.getSBkgFincDirCd());
			}
		}
		
		try {
			List<CreateEACRegistrationVO> insertVoList = new ArrayList<CreateEACRegistrationVO>();
			List<CreateEACRegistrationVO> updateVoList = new ArrayList<CreateEACRegistrationVO>();
			List<CreateEACRegistrationVO> deleteVoList = new ArrayList<CreateEACRegistrationVO>();
			
			for ( int i=0; i<createEACRegistrationVO .length; i++ ) {
				if ( createEACRegistrationVO[i].getIbflag().equals("I")){
					createEACRegistrationVO[i].setSUserId(account.getUsr_id());
					insertVoList.add(createEACRegistrationVO[i]);
				} else if ( createEACRegistrationVO[i].getIbflag().equals("U")){
					createEACRegistrationVO[i].setSUserId(account.getUsr_id());
					updateVoList.add(createEACRegistrationVO[i]);
				} else if ( createEACRegistrationVO[i].getIbflag().equals("D")){
					deleteVoList.add(createEACRegistrationVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addEACRegistration(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyEACRegistration(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeEACRegistration(deleteVoList);
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchTPBOfficeListVO searchTPBOfficeListVO
	 * @return List<SearchTPBOfficeListVO>
	 * @exception EventException
	 */
	public List<SearchTPBOfficeListVO> searchTPBOfficeList(SearchTPBOfficeListVO searchTPBOfficeListVO) throws EventException {
		try {
			return dbDao.searchTPBOfficeList(searchTPBOfficeListVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * EqNo 를 체크합니다.<br>
	 * 
	 * @param String eqNo
	 * @return String
	 * @exception EventException
	 */
	public String checkEqNo(String eqNo) throws EventException{
		DBRowSet rowSet = null;							// 데이터전송을 위한 DB ResultSet
        String check = "";
        
        try {
            rowSet=dbDao.checkEqNo(eqNo);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		check = rowSet.getString(1);
            	}
            }
            return check;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
	}
	
	   /**
	 * EQKind 가져온다.(콤보)<br>
	 * @param String n3pty_expn_tp_cd
	 * @return List<SearchEQKindVO> 
	 * @throws EventException
	 */
	public List<SearchEQKindVO> searchEQKindCd (String n3pty_expn_tp_cd) throws EventException {
		try {
			return dbDao.searchEQKindCd(n3pty_expn_tp_cd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * finance direction code  및 BKG VVD check 한다.<br>
	 * 
	 * @param String vvdCd
	 * @param String ydCd
	 * @param String bkgNo   
	 * @return String
	 * @exception EventException
	 */
	public String searchBkgVVDFincDirCd(String vvdCd, String ydCd, String bkgNo) throws EventException{
		String fincDirCd = "";
		String bFincDirCd = "";
		String sBkgNo = "";
        
        try {
        	bFincDirCd = dbDao.searchBkgVVDFincDirCd(vvdCd, ydCd, bkgNo);
        	if (("XX").equals(bFincDirCd)){
        		fincDirCd = dbDao.searchBkgVVDFincDirCd(vvdCd, ydCd, sBkgNo);
        		if (("XX").equals(fincDirCd)){
        		    fincDirCd = "VXX" ; // BKG No 와 상관없이 VVD 로도 finance direction 못 구함
        		}else{
        			fincDirCd = "BXX" ; // BKG_No의 VVD 로 finance direction 못 구함
        		}
        	}else{
        		fincDirCd = bFincDirCd ;
        	}
            return fincDirCd;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
	}
}