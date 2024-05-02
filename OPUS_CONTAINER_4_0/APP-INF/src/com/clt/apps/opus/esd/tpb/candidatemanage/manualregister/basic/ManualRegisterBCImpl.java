/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ManualRegisterBCImpl.java
*@FileTitle : ManualRegister
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tpb.candidatemanage.manualregister.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.clt.apps.opus.esd.tpb.candidatemanage.manualregister.integration.ManualRegisterDBDAO;
import com.clt.apps.opus.esd.tpb.candidatemanage.manualregister.vo.CreateEACRegistrationVO;
import com.clt.apps.opus.esd.tpb.candidatemanage.manualregister.vo.CreateTPBCandidateVO;
import com.clt.apps.opus.esd.tpb.candidatemanage.manualregister.vo.SearchContainerInfoVO;
import com.clt.apps.opus.esd.tpb.candidatemanage.manualregister.vo.SearchTPBDuplicationListVO;
import com.clt.apps.opus.esd.tpb.candidatemanage.manualregister.vo.SearchTPBOfficeListVO;
import com.clt.apps.opus.esd.tpb.common.TPBUtils;
import com.clt.apps.opus.esd.tpb.common.combo.event.CommonCodeEvent;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
 
/**
 * -CandidateManage Business Logic Basic Command implementation<br>
 * - -CandidateManage Business Logic Interface<br>
 *
 * @author 
 * @see ESD_TPB_0133EventResponse,ManualRegisterBC DAO class reference
 * @since J2EE 1.6
 */
public class ManualRegisterBCImpl extends BasicCommandSupport implements ManualRegisterBC {

	// Database Access Object
	private transient ManualRegisterDBDAO dbDao = null;

	/**
	 * ManualRegisterBCImpl object creation<br>
	 * ManualRegisterDBDAO creation<br>
	 */
	public ManualRegisterBCImpl() {
		dbDao = new ManualRegisterDBDAO();
	}
	/**
	 * <br>
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
	 * <br>
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
	 * <br>
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
		//VVDStr
		String s_vvd = sTcVO.getSVvd();
		String s_yd_cd = sTcVO.getSYdCd();
		
		//checking validation
		params.put("s_if_ofc_cd", sTcVO.getSIfOfcCd());
		params.put("s_bkg_no", sTcVO.getSBkgNo());
		CommonCodeEvent event = new CommonCodeEvent();
		event.setEventParams(params);
		try {
			
			//checking Office
			if(!sTcVO.getSIfOfcCd().equals("") && !TPBUtils.checkVaildate(event, "checkOffice")){
				throw new EventException(new ErrorHandler("TPB00003").getMessage());
			}	
			//checking BKG No
//			if(sTcVO.getSBkgNo()!=null && !sTcVO.getSBkgNo().equals("") && !TPBUtils.checkVaildate(event, "checkBKGNo")){
////				throw new EventException(new ErrorHandler("TPB00054").getMessage());
//			}
			//checking B/L No
			if(sTcVO.getSBlNo()!=null && !sTcVO.getSBlNo().equals("") && !TPBUtils.checkVaildate(event, "checkBLNo")){
				throw new EventException(new ErrorHandler("TPB00055").getMessage());
			}
	
			//checking Invoice No info
			
			String svrid = dbDao.searchSVRID(createTPBCandidateVO[0]);
			if(svrid == null){
				throw new EventException(new ErrorHandler("TPB00058").getMessage());
			}
			createTPBCandidateVO[0].setSSvrId(svrid); // to save to DB Table
			
			log.debug("\n getSSrcVndrCntCd()["+sTcVO.getSSrcVndrCntCd()+"]=====================>>>>>>>>>>>>>>>>>>>>sTcVO.getSSrcVndrCntCd().equals(sTcVO.getSSrcVndrSeq())"+sTcVO.getSSrcVndrCntCd().equals(sTcVO.getSSrcVndrSeq()));
			log.debug("\n getSSrcVndrSeq()()["+sTcVO.getSSrcVndrSeq()+"]=====================>>>>>>>>>>>>>>>>>>>>");
//			if( (sTcVO.getSSrcVndrCntCd().equals("") && !sTcVO.getSSrcVndrSeq().equals("")) || (sTcVO.getSSrcVndrCntCd().equals(sTcVO.getSSrcVndrSeq())) || sTcVO.getSSrcVndrCntCd().length()>2){	
			if( (sTcVO.getSSrcVndrCntCd().equals("") && !sTcVO.getSSrcVndrSeq().equals(""))){			
				String s_src_vndr_cnt_cd = dbDao.searchVndrCntCd(createTPBCandidateVO[0]);
				if(s_src_vndr_cnt_cd!=null &&  !s_src_vndr_cnt_cd.equals("")){
					createTPBCandidateVO[0].setSSrcVndrCntCd(s_src_vndr_cnt_cd);
				}else{
					createTPBCandidateVO[0].setSSrcVndrCntCd("US");
				}
			}
			log.debug("\n createTPBCandidateVO[0].getSSrcVndrCntCd()["+createTPBCandidateVO[0].getSSrcVndrCntCd()+"]=====================>>>>>>>>>>>>>>>>>>>>");

			
			if(s_n3pty_if_tp_cd.equals("M")){ //Interface Type = Cost Exception
				createTPBCandidateVO[0].setSN3ptySrcSubSysCd("EXC");
			}else{
				createTPBCandidateVO[0].setSN3ptySrcSubSysCd(s_n3pty_expn_tp_cd);
			}
			if(s_vndr_cust_div_cd.equals("V")){
				createTPBCandidateVO[0].setSVndrLglEngNm(sTcVO.getSTrdPartyNm());
			}else if(s_vndr_cust_div_cd.equals("C")){
				createTPBCandidateVO[0].setSCustLglEngNm(sTcVO.getSTrdPartyNm());	
			}
			
			if(s_n3pty_if_tp_cd.equals("S") && s_n3pty_expn_tp_cd.equals("MNR")){  //in case of Interface Type = Source, Expense Type = MNR
				createTPBCandidateVO[0].setSAcctCd("511511");
				createTPBCandidateVO[0].setSLgsCostCd("MRCNCT");
			} 
	
			if(!s_bkg_no_all.equals("")){//SearchStr
				String[] vvd = null;
				vvd = dbDao.searchStr(createTPBCandidateVO[0]);
	
				if(vvd!=null && !vvd[0].equals("")){
					createTPBCandidateVO[0].setSVslCd(vvd[0]);
				}
				if(vvd!=null && !vvd[1].equals("")){
					createTPBCandidateVO[0].setSSkdVoyNo(vvd[1]);
				}
				if(!JSPUtil.getNull(vvd[2]).equals("")){
					createTPBCandidateVO[0].setSSkdDirCd(vvd[2].substring(0,1));
				}
			}else{//SearchVVDStr
				if(!s_vvd.equals("") && !s_yd_cd.equals("")){
					String vvd = dbDao.searchVVDStr(createTPBCandidateVO[0]);
					if(vvd!=null && !vvd.equals("")){
						createTPBCandidateVO[0].setSBkgFincDirCd(vvd);
					}
				}
			}
			
			String s_bkg_finc_dir_cd = createTPBCandidateVO[0].getSBkgFincDirCd();
			if(s_bkg_finc_dir_cd == null || s_bkg_finc_dir_cd.length() == 0){ 
				String s_skd_dir_cd =  createTPBCandidateVO[0].getSSkdDirCd();
				createTPBCandidateVO[0].setSBkgFincDirCd(s_skd_dir_cd+s_skd_dir_cd);
			}
			
			createTPBCandidateVO[0].setSCostExptFlg(s_n3pty_if_tp_cd.equals("M")?"Y":"N"); //in case of Cost Exception = 'Y'
			
			//SearchTESStr
			if(s_n3pty_expn_tp_cd.equals("TES")){
				if(!s_n3pty_src_no.equals("") && !s_src_vndr_no.equals("")){
					String tes = dbDao.searchTESStr(createTPBCandidateVO[0]);
					if(tes!=null && !tes.equals("")){
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
			}
			
		}
		
		try {
			List<CreateTPBCandidateVO> insertVoList = new ArrayList<CreateTPBCandidateVO>();
			
			if(createTPBCandidateVO != null){
				for ( int i=0; i<createTPBCandidateVO.length; i++ ) {
					if ( createTPBCandidateVO[i].getIbflag().equals("I")){
						createTPBCandidateVO[i].setUserId(account.getUsr_id());
						createTPBCandidateVO[i].setOfcCd(account.getOfc_cd());
						//checking OTS_DTL_SEQ
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
	 * <br>
	 * 
	 * @param CreateEACRegistrationVO[] createEACRegistrationVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createEACRegistration(CreateEACRegistrationVO[] createEACRegistrationVO, SignOnUserAccount account) throws EventException{
		CreateEACRegistrationVO cErVO = createEACRegistrationVO[0];
		CreateTPBCandidateVO sTcVO = new CreateTPBCandidateVO();
		
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
				log.debug("\n createEACRegistrationVO[i].getSSrcVndrCntCd()["+createEACRegistrationVO[i].getSSrcVndrCntCd()+"]=====================>>>>>>>>>>>>>>>>>>>>");
				if (createEACRegistrationVO[i].getSSrcVndrCntCd().length()==0 || createEACRegistrationVO[i].getSSrcVndrCntCd().length()>2){
					//error ����
					sTcVO.setSSrcVndrCntCd(cErVO.getSSrcVndrSeq());
					String src_vndr_cnt_cd = dbDao.searchVndrCntCd(sTcVO);
					createEACRegistrationVO[i].setSSrcVndrCntCd(src_vndr_cnt_cd);
				}
			}
		}
		
		}catch(DAOException ex) {
			log.error(ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
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

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * <br>
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
}