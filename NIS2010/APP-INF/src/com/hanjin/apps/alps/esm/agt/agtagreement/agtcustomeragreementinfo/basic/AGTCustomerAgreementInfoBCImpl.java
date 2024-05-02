/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : AGTCustomerAgreementInfoBCImpl.java
*@FileTitle : Agent Commission Customer Agreement Information Management
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-30
*@LastModifier : Hwang GyeongNam
*@LastVersion : 1.0
* 2006-11-30 Hwang GyeongNam
* 1.0 최초 생성
* 2009-09-04 : Ho-jin Lee searchFACRateInfoList 추가
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtagreement.agtcustomeragreementinfo.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.agt.agtagreement.agtcustomeragreementinfo.integration.AGTCustomerAgreementInfoDBDAO;
import com.hanjin.apps.alps.esm.agt.agtagreement.agtcustomeragreementinfo.integration.AGTCustomerAgreementInfoEAIDAO;
import com.hanjin.apps.alps.esm.agt.agtagreement.agtcustomeragreementinfo.vo.SendMailLocalDateVO;
import com.hanjin.apps.alps.esm.agt.common.basic.CommonBC;
import com.hanjin.apps.alps.esm.agt.common.basic.CommonBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.AgtBrogAgmtRtVO;
import com.hanjin.syscommon.common.table.AgtFacAgmtGrpLocListVO;
import com.hanjin.syscommon.common.table.AgtFacAgmtRtVO;
import com.hanjin.syscommon.common.table.AgtScsAgmtRtVO;


/**
 * eNIS-agt Business Logic Basic Command implementation<br>
 * - eNIS-agt에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Hwang GyeongNam
 * @see ESM_AGT_025EventResponse,AGTCustomerAgreementInfoBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class AGTCustomerAgreementInfoBCImpl extends BasicCommandSupport implements AGTCustomerAgreementInfoBC {

	// Database Access Object
	private transient AGTCustomerAgreementInfoDBDAO dbDao=null;
	
	// EAI Database Access Object
	private transient AGTCustomerAgreementInfoEAIDAO eaiDao=null;	
	

	/**
	 * AGTCustomerAgreementInfoBCImpl 객체 생성<br>
	 * AGTCustomerAgreementInfoDBDAO를 생성한다.<br>
	 */
	public AGTCustomerAgreementInfoBCImpl(){
		dbDao = new AGTCustomerAgreementInfoDBDAO();
		eaiDao = new AGTCustomerAgreementInfoEAIDAO();
	}



	/**
	 * 조회 이벤트 처리<br>
	 * ESM_AGT_007 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param AgtBrogAgmtRtVO agtBrogAgmtRtVO
	 * @return List<AgtBrogAgmtRtVO>
	 * @exception EventException
	 */

	public List<AgtBrogAgmtRtVO> searchUSABrokerageRateInfoList(AgtBrogAgmtRtVO agtBrogAgmtRtVO) throws EventException {
		try {
			return dbDao.searchUSABrokerageRateInfoList(agtBrogAgmtRtVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * ESM_AGT_007 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param AgtBrogAgmtRtVO[] agtBrogAgmtRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */

	public void multiUSABrokerageRateInfo(AgtBrogAgmtRtVO[] agtBrogAgmtRtVO, SignOnUserAccount account) throws EventException{
		try {
			List<AgtBrogAgmtRtVO> insertVoList = new ArrayList<AgtBrogAgmtRtVO>();
			List<AgtBrogAgmtRtVO> updateVoList = new ArrayList<AgtBrogAgmtRtVO>();
			List<AgtBrogAgmtRtVO> deleteVoList = new ArrayList<AgtBrogAgmtRtVO>();
			//Code Check
			CommonBC cbc = new CommonBCImpl();
			String brog_cnt_cust_seq = "";
			String shpr_cnt_seq = "";


			for ( int i=0; i<agtBrogAgmtRtVO .length; i++ ) {
				if ( agtBrogAgmtRtVO[i].getIbflag().equals("I")){
					agtBrogAgmtRtVO[i].setCreUsrId(account.getUsr_id());
					agtBrogAgmtRtVO[i].setUpdUsrId(account.getUsr_id());
					brog_cnt_cust_seq = cbc.searchCode("C", "C", agtBrogAgmtRtVO[i].getBrogCntCustSeq().trim());
					agtBrogAgmtRtVO[i].setBrogCntCd(brog_cnt_cust_seq.substring(0, 2)); //초기화
					agtBrogAgmtRtVO[i].setBrogCustSeq(brog_cnt_cust_seq.substring(2)); //초기화

					if ( "*000000".equals(agtBrogAgmtRtVO[i].getShprCntSeq().trim())
					  || "000000".equals(agtBrogAgmtRtVO[i].getShprCntSeq().trim()))
					{
						agtBrogAgmtRtVO[i].setShprCntCd("*");
					} else if(agtBrogAgmtRtVO[i].getShprCntSeq().length() > 2) {
						shpr_cnt_seq = cbc.searchCode("C", "C", agtBrogAgmtRtVO[i].getShprCntSeq().trim());

						agtBrogAgmtRtVO[i].setShprCntCd(shpr_cnt_seq.substring(0, 2));
						agtBrogAgmtRtVO[i].setShprSeq(shpr_cnt_seq.substring(2));
					} else {
						agtBrogAgmtRtVO[i].setShprCntCd("*");
						agtBrogAgmtRtVO[i].setShprSeq("0");
					}

					
					insertVoList.add(agtBrogAgmtRtVO[i]);
				} else if ( agtBrogAgmtRtVO[i].getIbflag().equals("U")){
					agtBrogAgmtRtVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(agtBrogAgmtRtVO[i]);
					brog_cnt_cust_seq = cbc.searchCode("C", "C", agtBrogAgmtRtVO[i].getBrogCntCustSeq().trim());
					agtBrogAgmtRtVO[i].setBrogCntCd(brog_cnt_cust_seq.substring(0, 2)); //초기화
					agtBrogAgmtRtVO[i].setBrogCustSeq(brog_cnt_cust_seq.substring(2)); //초기화

					if ( "*000000".equals(agtBrogAgmtRtVO[i].getShprCntSeq().trim())
					  || "000000".equals(agtBrogAgmtRtVO[i].getShprCntSeq().trim()))
					{
						agtBrogAgmtRtVO[i].setShprCntCd("*");
					} else if(agtBrogAgmtRtVO[i].getShprCntSeq().length() > 2) {
						shpr_cnt_seq = cbc.searchCode("C", "C", agtBrogAgmtRtVO[i].getShprCntSeq().trim());

						agtBrogAgmtRtVO[i].setShprCntCd(shpr_cnt_seq.substring(0, 2));
						agtBrogAgmtRtVO[i].setShprSeq(shpr_cnt_seq.substring(2));
					} else {
						agtBrogAgmtRtVO[i].setShprCntCd("*");
						agtBrogAgmtRtVO[i].setShprSeq("0");
					}

				} else if ( agtBrogAgmtRtVO[i].getIbflag().equals("D")){
					brog_cnt_cust_seq = cbc.searchCode("C", "C", agtBrogAgmtRtVO[i].getBrogCntCustSeq().trim());
					agtBrogAgmtRtVO[i].setBrogCntCd(brog_cnt_cust_seq.substring(0, 2)); //초기화
					agtBrogAgmtRtVO[i].setBrogCustSeq(brog_cnt_cust_seq.substring(2)); //초기화
					deleteVoList.add(agtBrogAgmtRtVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addmultiUSABrokerageRateInfoS(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymultiUSABrokerageRateInfoS(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removemultiUSABrokerageRateInfoS(deleteVoList);
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
	 * 조회 이벤트 처리<br>
	 * ESM_AGT_0008 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param AgtFacAgmtRtVO agtFacAgmtRtVO
	 * @return List<AgtFacAgmtRtVO> 
	 * @exception EventException
	 */
	public List<AgtFacAgmtRtVO> searchFACRateInfoList(AgtFacAgmtRtVO agtFacAgmtRtVO) throws EventException {
		try {
			return dbDao.searchFACRateInfoLIst(agtFacAgmtRtVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * ESM_AGT_008 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param AgtFacAgmtRtVO[] agtFacAgmtRtVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	@Override
    public void multiFACRateInfo(AgtFacAgmtRtVO[] agtFacAgmtRtVOS, SignOnUserAccount account) throws EventException {
	    // TODO Auto-generated method stub
		try{
			String rout_tp = "5";
			String rout_cd = "S";
					
			AgtFacAgmtRtVO seqList = new AgtFacAgmtRtVO();
			//Code Check
            CommonBC cbc = new CommonBCImpl();
            
            String sShpr_cnt_seq		= "";
			String sFrt_fwrd_cnt_cd 	= "";
			String ff_cust_cd			= "";
			String sShpr_cnt_cd 		= "";
			String sShpr_cust_seq 		= "";
			String por_rout_cd_list		= "";
			String pol_rout_cd_list		= "";
			String pod_rout_cd_list		= "";
			String del_rout_cd_list		= "";
			String sPor_grp_tp_cd		= "";
			String sPor_rout_cd			= "";
			String sPol_grp_tp_cd		= "";
			String sPol_rout_cd			= "";
			String sPod_grp_tp_cd		= "";
			String sPod_rout_cd			= "";
			String sDel_grp_tp_cd		= "";
			String sDel_rout_cd			= "";
			String sFm_eff_dt			= "";
			String sTo_eff_dt			= "";			
			String sSvc_scp_cd			= "";
			String sSc_no				= "";
			String sRfa_no				= "";
			String sCmdt_tp_cd			= "";
			String sCmdt_cd				= "";
			String sFac_div_cd			= "";
			String sFac_ofc_cd			= "";
			String sComm_proc_sts_cd	= "";
			String shpr_cnt_cd 			= "";
			
			int ret = 0;
			
			log.info("\n agtFacAgmtRtVOS.length = "+agtFacAgmtRtVOS.length);
			log.info("\n agtFacAgmtRtVOS = "+agtFacAgmtRtVOS);
			for(int i=0; i<agtFacAgmtRtVOS.length; i++){
				sShpr_cnt_cd = agtFacAgmtRtVOS[i].getShprCntCd();
				sShpr_cnt_seq = agtFacAgmtRtVOS[i].getShprCntCdSeq().trim();
				if(sShpr_cnt_seq.equals("*000000") || sShpr_cnt_seq.equals("000000")){
					sShpr_cnt_cd = "*";
				}else if(sShpr_cnt_seq.length() > 2){
					sShpr_cnt_cd = sShpr_cnt_seq.substring(0, 2);
					sShpr_cust_seq = sShpr_cnt_seq.substring(2);
				}else{
					sShpr_cnt_cd = "*";
				}
				log.info("\n agtFacAgmtRtVOS[i].getPorGrpTpCd()="+agtFacAgmtRtVOS[i].getPorGrpTpCd());
				sPor_grp_tp_cd = agtFacAgmtRtVOS[i].getPorGrpTpCd().trim();
				log.info("\n Por_grp_tp_cd 1="+sPor_grp_tp_cd);
				if(sPor_grp_tp_cd.equals(rout_tp)){
					por_rout_cd_list = sPor_grp_tp_cd;
					sPor_rout_cd = rout_cd;
				}else if(sPor_grp_tp_cd.length() <= 0 || "*".equals(sPor_grp_tp_cd)){
					sPor_grp_tp_cd = "*";
					sPor_rout_cd = "*";	
				}
				log.info("\n Por_grp_tp_cd 2="+sPor_grp_tp_cd);
				sPol_grp_tp_cd = agtFacAgmtRtVOS[i].getPolGrpTpCd();
				if( sPol_grp_tp_cd.equals(rout_tp) ) {
					pol_rout_cd_list = sPol_rout_cd;
					sPol_rout_cd = rout_cd;
				} else if(sPol_grp_tp_cd.length() <= 0 || "*".equals(sPol_grp_tp_cd)) {
					sPol_grp_tp_cd = "*";
					sPol_rout_cd = "*";						
				}
				
				sPod_grp_tp_cd = agtFacAgmtRtVOS[i].getPodGrpTpCd();
				if( sPod_grp_tp_cd.equals(rout_tp) ) {
					pod_rout_cd_list = sPod_rout_cd;
					sPod_rout_cd = rout_cd;
				} else if(sPod_grp_tp_cd.length() <= 0 || "*".equals(sPod_grp_tp_cd)) {
					sPod_grp_tp_cd = "*";
					sPod_rout_cd = "*";	
				}
				
				sDel_grp_tp_cd = agtFacAgmtRtVOS[i].getDelGrpTpCd();
				if( sDel_grp_tp_cd.equals(rout_tp) ) {
					del_rout_cd_list = sDel_rout_cd;
					sDel_rout_cd = rout_cd;
				} else if(sDel_grp_tp_cd.length() <= 0 || "*".equals(sDel_grp_tp_cd)) {
					sDel_grp_tp_cd = "*";
					sDel_rout_cd = "*";
				}
				
				sFm_eff_dt = agtFacAgmtRtVOS[i].getFmEffDt();
				if(sFm_eff_dt.length() <= 0) {
					sFm_eff_dt = "20000101";
				}	
				sTo_eff_dt = agtFacAgmtRtVOS[i].getToEffDt();
				if(sTo_eff_dt.length() <= 0) {
					sTo_eff_dt = "29991231";
				}
				sSvc_scp_cd = agtFacAgmtRtVOS[i].getSvcScpCd();
				if(sSvc_scp_cd.length() <= 0) {
					sSvc_scp_cd = "*";
				}
				sSc_no = agtFacAgmtRtVOS[i].getScNo();
				if(sSc_no.length() <= 0) {
					sSc_no = "*";
				}
				sRfa_no = agtFacAgmtRtVOS[i].getRfaNo();
				if(sRfa_no.length() <= 0) {
					sRfa_no = "*";
				}	
				sPor_rout_cd = agtFacAgmtRtVOS[i].getPorRoutCd();
				if(sPor_rout_cd.length() <= 0) {
					sPor_rout_cd = "*";
				}
				sPol_rout_cd = agtFacAgmtRtVOS[i].getPolRoutCd();
				if(sPol_rout_cd.length() <= 0) {
					sPol_rout_cd = "*";
				}
				sPod_rout_cd = agtFacAgmtRtVOS[i].getPodRoutCd();
				if(sPod_rout_cd.length() <= 0) {
					sPod_rout_cd = "*";
				}
				sDel_rout_cd = agtFacAgmtRtVOS[i].getDelRoutCd();
				if(sDel_rout_cd.length() <= 0) {
					sDel_rout_cd = "*";
				}
				sCmdt_tp_cd = agtFacAgmtRtVOS[i].getCmdtTpCd();
				if(sCmdt_tp_cd.length() <= 0 || "*".equals(sCmdt_tp_cd)) {
					sCmdt_tp_cd = "*";
					sCmdt_cd = "*";
				}
				sCmdt_cd = agtFacAgmtRtVOS[i].getCmdtCd();
				if(sCmdt_cd.length() <= 0) {
					sCmdt_cd = "*";
				}
				sFac_div_cd = agtFacAgmtRtVOS[i].getFacDivCd();
				if(sFac_div_cd.equals("BL")){
					agtFacAgmtRtVOS[i].setBkgFacRt(agtFacAgmtRtVOS[i].getBkgFacBlAmt());
				}
				ff_cust_cd = agtFacAgmtRtVOS[i].getCommProcStsCd();
				if(sComm_proc_sts_cd.length() <= 0) {
					sComm_proc_sts_cd = "RN";
				}
				sFrt_fwrd_cnt_cd = cbc.searchCode("C", "C", agtFacAgmtRtVOS[i].getFrtFwrdCntCdSeq());
				
				if(agtFacAgmtRtVOS[i].getIbflag().equals("I") || agtFacAgmtRtVOS[i].getIbflag().equals("U")){
					// Insert/Update시 사용자가 Shipper를 입력했을 경우 Customer 테이블에 등록되어 있는지 체크한다.
					if(!sShpr_cnt_cd.equals("*")){
						shpr_cnt_cd = cbc.searchCode("C", "C", agtFacAgmtRtVOS[i].getShprCntCdSeq().trim());
						sShpr_cnt_cd = shpr_cnt_cd.substring(0, 2);
						sShpr_cust_seq = shpr_cnt_cd.substring(2);
					}
					// 2009.01.12 (kevin) POR,POL,POD,DEL Type이 '*'가 아닌경우 POR,POL,POD,DEL이 코드테이블에 등록되어 있는지 체크.
					sFac_ofc_cd = agtFacAgmtRtVOS[i].getFacOfcCd();
					if(sFac_ofc_cd.length() <= 0) {
						sFac_ofc_cd = agtFacAgmtRtVOS[i].getFacOfcCd();
					}
					if( !"*".equals(sPor_grp_tp_cd) && !"*".equals(sPor_rout_cd) ){
						ret = dbDao.searchGroupTypeCd(sPor_grp_tp_cd, sPor_rout_cd, sFac_ofc_cd);
						if (ret == 0) {
							//[$s] is invalid. Please check up Again!
							throw new DAOException((new ErrorHandler("AGT00080", "POR="+sPor_rout_cd)).getMessage());
						}
					}
					if( !"*".equals(sPol_grp_tp_cd) && !"*".equals(sPol_rout_cd) ) {
						ret = dbDao.searchGroupTypeCd(sPol_grp_tp_cd, sPol_rout_cd, sFac_ofc_cd);
						if (ret == 0) {
							//[$s] is invalid. Please check up Again!
							throw new DAOException((new ErrorHandler("AGT00080", "POL="+sPol_rout_cd)).getMessage());
						}
					}
					if( !"*".equals(sPod_grp_tp_cd) && !"*".equals(sPod_rout_cd) ) {
						ret = dbDao.searchGroupTypeCd(sPod_grp_tp_cd, sPod_rout_cd, sFac_ofc_cd);
						if (ret == 0) {
							//[$s] is invalid. Please check up Again!
							throw new DAOException((new ErrorHandler("AGT00080", "POD="+sPod_rout_cd)).getMessage());
						}
					}
					if( !"*".equals(sDel_grp_tp_cd) && !"*".equals(sDel_rout_cd) ) {
						ret = dbDao.searchGroupTypeCd(sDel_grp_tp_cd, sDel_rout_cd, sFac_ofc_cd);
						if (ret == 0) {
							//[$s] is invalid. Please check up Again!
							throw new DAOException((new ErrorHandler("AGT00080", "DEL="+sDel_rout_cd)).getMessage());
						}
					}
				}
				
				
				if(agtFacAgmtRtVOS[i].getIbflag().equals("I")){
					sComm_proc_sts_cd = "RN"; // RN으로...
					
					agtFacAgmtRtVOS[i].setCreUsrId(account.getUsr_id());
					agtFacAgmtRtVOS[i].setUpdUsrId(account.getUsr_id());
					agtFacAgmtRtVOS[i].setFrtFwrdCntCd(sFrt_fwrd_cnt_cd.substring(0, 2));
					agtFacAgmtRtVOS[i].setFrtFwrdCustSeq(sFrt_fwrd_cnt_cd.substring(2));
					
					seqList = dbDao.searchFACRateInfoSeqLIst(agtFacAgmtRtVOS[i]);
					agtFacAgmtRtVOS[i].setFacRtSeq(seqList.getFacRtSeq());

//					agtFacAgmtRtVOS[i].setCommProcStsCd("AS");//Approved 처리(추후  이필드는 삭제됨 - 김종범 SS 왈)
					agtFacAgmtRtVOS[i].setCommProcStsCd(sComm_proc_sts_cd);
					agtFacAgmtRtVOS[i].setShprCntCd(sShpr_cnt_cd);
					agtFacAgmtRtVOS[i].setShprCustSeq(sShpr_cust_seq);
					agtFacAgmtRtVOS[i].setPorGrpTpCd(sPor_grp_tp_cd);
					agtFacAgmtRtVOS[i].setPorRoutCd(sPor_rout_cd);
					agtFacAgmtRtVOS[i].setPolGrpTpCd(sPol_grp_tp_cd);
					agtFacAgmtRtVOS[i].setPolRoutCd(sPol_rout_cd);
					agtFacAgmtRtVOS[i].setPodGrpTpCd(sPod_grp_tp_cd);
					agtFacAgmtRtVOS[i].setPodRoutCd(sPod_rout_cd);
					agtFacAgmtRtVOS[i].setDelGrpTpCd(sDel_grp_tp_cd);
					agtFacAgmtRtVOS[i].setDelRoutCd(sDel_rout_cd);
					agtFacAgmtRtVOS[i].setSvcScpCd(sSvc_scp_cd);
					agtFacAgmtRtVOS[i].setFmEffDt(sFm_eff_dt);
					agtFacAgmtRtVOS[i].setToEffDt(sTo_eff_dt);
					agtFacAgmtRtVOS[i].setScNo(sSc_no);
					agtFacAgmtRtVOS[i].setRfaNo(sRfa_no);
					agtFacAgmtRtVOS[i].setCmdtTpCd(sCmdt_tp_cd);
					agtFacAgmtRtVOS[i].setCmdtCd(sCmdt_cd);
					agtFacAgmtRtVOS[i].setFacDivCd(sFac_div_cd);
										
					dbDao.addmultiFACRateInfo(agtFacAgmtRtVOS[i]);
				}else if(agtFacAgmtRtVOS[i].getIbflag().equals("U") && (sComm_proc_sts_cd.equals("RN") || sComm_proc_sts_cd.equals("RR"))){
					agtFacAgmtRtVOS[i].setCreUsrId(account.getUsr_id());
					agtFacAgmtRtVOS[i].setUpdUsrId(account.getUsr_id());
					
					String frt_fwrd_cnt_cd_seqStr = agtFacAgmtRtVOS[i].getFrtFwrdCntCdSeq();
					agtFacAgmtRtVOS[i].setFrtFwrdCntCd(frt_fwrd_cnt_cd_seqStr.substring(0, 2));
					agtFacAgmtRtVOS[i].setFrtFwrdCustSeq(frt_fwrd_cnt_cd_seqStr.substring(2));
					
//					seqList = dbDao.searchFACRateInfoSeqLIst(agtFacAgmtRtVOS[i]);
//					agtFacAgmtRtVOS[i].setFacRtSeq(seqList.getFacRtSeq());
					
					agtFacAgmtRtVOS[i].setShprCntCd(sShpr_cnt_cd);
					agtFacAgmtRtVOS[i].setShprCustSeq(sShpr_cust_seq);
					agtFacAgmtRtVOS[i].setPorGrpTpCd(sPor_grp_tp_cd);
					agtFacAgmtRtVOS[i].setPorRoutCd(sPor_rout_cd);
					agtFacAgmtRtVOS[i].setPolGrpTpCd(sPol_grp_tp_cd);
					agtFacAgmtRtVOS[i].setPolRoutCd(sPol_rout_cd);
					agtFacAgmtRtVOS[i].setPodGrpTpCd(sPod_grp_tp_cd);
					agtFacAgmtRtVOS[i].setPodRoutCd(sPod_rout_cd);
					agtFacAgmtRtVOS[i].setDelGrpTpCd(sDel_grp_tp_cd);
					agtFacAgmtRtVOS[i].setDelRoutCd(sDel_rout_cd);
					agtFacAgmtRtVOS[i].setSvcScpCd(sSvc_scp_cd);
					agtFacAgmtRtVOS[i].setFmEffDt(sFm_eff_dt);
					agtFacAgmtRtVOS[i].setToEffDt(sTo_eff_dt);
					agtFacAgmtRtVOS[i].setScNo(sSc_no);
					agtFacAgmtRtVOS[i].setRfaNo(sRfa_no);
					agtFacAgmtRtVOS[i].setCmdtTpCd(sCmdt_tp_cd);
					agtFacAgmtRtVOS[i].setCmdtCd(sCmdt_cd);
					agtFacAgmtRtVOS[i].setFacDivCd(sFac_div_cd);
					agtFacAgmtRtVOS[i].setCommProcStsCd(sComm_proc_sts_cd);
					
					dbDao.modifymultiFACRateInfo(agtFacAgmtRtVOS[i]);
				}else if(agtFacAgmtRtVOS[i].getIbflag().equals("U") && !(sComm_proc_sts_cd.equals("RN") || sComm_proc_sts_cd.equals("RR"))){
					String frt_fwrd_cnt_cd_seqStr = agtFacAgmtRtVOS[i].getFrtFwrdCntCdSeq();
					agtFacAgmtRtVOS[i].setFrtFwrdCntCd(frt_fwrd_cnt_cd_seqStr.substring(0, 2));
					agtFacAgmtRtVOS[i].setFrtFwrdCustSeq(frt_fwrd_cnt_cd_seqStr.substring(2));
					dbDao.modifymultiFACRateInfo2(agtFacAgmtRtVOS[i]);
				}else if(agtFacAgmtRtVOS[i].getIbflag().equals("D") && sComm_proc_sts_cd.equals("RN")){
					String frt_fwrd_cnt_cd_seqStr = agtFacAgmtRtVOS[i].getFrtFwrdCntCdSeq();
					log.info("\n  >>>>>>>>>>>>>>>frt_fwrd_cnt_cd_seqStr="+frt_fwrd_cnt_cd_seqStr);
					agtFacAgmtRtVOS[i].setFrtFwrdCntCd(frt_fwrd_cnt_cd_seqStr.substring(0, 2));
					agtFacAgmtRtVOS[i].setFrtFwrdCustSeq(frt_fwrd_cnt_cd_seqStr.substring(2));
					dbDao.deletemultiFACRateInfo(agtFacAgmtRtVOS[i]);
				}
			}
		}catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	    
    }

	/**
	 * 조회 이벤트 처리<br>
	 * ESM_AGT_0008 화면 행추가지 해당 F.Forwarder Default 정보 조회 이벤트 처리<br>
	 * 
	 * @param AgtFacAgmtRtVO agtFacAgmtRtVO
	 * @return List<AgtFacAgmtRtVO>
	 * @exception EventException
	 */
	@Override
    public List<AgtFacAgmtRtVO> searchFACCustomerInfo(AgtFacAgmtRtVO agtFacAgmtRtVO) throws EventException {
		try {
			return dbDao.searchFACCustomerInfo(agtFacAgmtRtVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
    }
	
	/**
	 * Request 이벤트 처리<br>
	 * ESM_AGT_008 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param AgtFacAgmtRtVO[] agtFacAgmtRtVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyFACRateRequest(AgtFacAgmtRtVO[] agtFacAgmtRtVOS, SignOnUserAccount account) throws EventException{
		try{
			String sts = "RN";
			String subject = "Approval Request - FAC Agreement";
			String txtTmp = "ESM_AGT_FACAgreementRateMailTemplate.txtmail";
			String htmlTmp = "ESM_AGT_FACAgreementRateMailTemplate.htmlmail";
			
			String dt = null;
			
			
			SendMailLocalDateVO locDateList = new SendMailLocalDateVO();
			
			log.info("\n agtFacAgmtRtVOS.length = "+agtFacAgmtRtVOS.length);
			for(int i=0; i<agtFacAgmtRtVOS.length; i++){
					log.info("\n check="+agtFacAgmtRtVOS[i].getCheck());
				if(agtFacAgmtRtVOS[i].getCheck() != null){
					log.info("\n usrid ="+account.getUsr_id());
					log.info("\n usermail="+account.getUsr_eml());
					log.info("\n agtFacAgmtRtVOS="+agtFacAgmtRtVOS);
					agtFacAgmtRtVOS[i].setFacRqstUsrId(account.getUsr_id());
					agtFacAgmtRtVOS[i].setFacRqstUsrEml(account.getUsr_eml());
					agtFacAgmtRtVOS[i].setFrtFwrdCntCd(agtFacAgmtRtVOS[i].getFrtFwrdCntCdSeq().substring(0, 2));
					agtFacAgmtRtVOS[i].setFrtFwrdCustSeq(agtFacAgmtRtVOS[i].getFrtFwrdCntCdSeq().substring(2));
					log.info("\n agtFacAgmtRtVOS="+agtFacAgmtRtVOS[i].getFrtFwrdCntCd());
					log.info("\n agtFacAgmtRtVOS="+agtFacAgmtRtVOS[i].getFrtFwrdCustSeq());
					dbDao.modifyFACRateRequest(agtFacAgmtRtVOS[i]);
				}
				log.info("\n agtFacAgmtRtVOS["+i+"].getCommProcStsCd()="+agtFacAgmtRtVOS[i].getCommProcStsCd());
				if(agtFacAgmtRtVOS[i].getCheck().equals("1") && agtFacAgmtRtVOS[i].getCommProcStsCd().equals("RN")){
					log.info("\n agtFacAgmtRtVOS[i].getRecipientsEml()="+agtFacAgmtRtVOS[i].getRecipientsEml());
					log.info("\n agtFacAgmtRtVOS[i].getCnt()="+agtFacAgmtRtVOS[i].getCnt());
					locDateList.setFacOfcCd(agtFacAgmtRtVOS[i].getFacOfcCd());
					//지역 현재 날짜 가져오기
					locDateList = dbDao.sendAGTTemplateMailLocalDate(agtFacAgmtRtVOS[i]);
				}

			}
			log.info("\n locDateList="+locDateList.getDt());
			dt = locDateList.getDt();
			eaiDao.sendAGTTemplateMail(sts, subject, txtTmp, htmlTmp, agtFacAgmtRtVOS, account, dt);
		}catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Approval 이벤트 처리<br>
	 * ESM_AGT_008 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param AgtFacAgmtRtVO[] agtFacAgmtRtVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyFACRateApproval(AgtFacAgmtRtVO[] agtFacAgmtRtVOS, SignOnUserAccount account) throws EventException{
		try{
			for(int i=0; i<agtFacAgmtRtVOS.length; i++){
//				log.info(agtFacAgmtRtVOS[i].getFrtFwrdCustSeq());
//				dbDao.modifyFACRateApproval(agtFacAgmtRtVOS[i]);
				agtFacAgmtRtVOS[i].setFrtFwrdCntCd(agtFacAgmtRtVOS[i].getFrtFwrdCntCdSeq().substring(0,2));
				agtFacAgmtRtVOS[i].setFrtFwrdCustSeq(agtFacAgmtRtVOS[i].getFrtFwrdCntCdSeq().substring(2));
				agtFacAgmtRtVOS[i].setFacAproUsrId(account.getUsr_id());
				agtFacAgmtRtVOS[i].setFacAproUsrEml(account.getUsr_eml());
				dbDao.modifyFACRateApproval(agtFacAgmtRtVOS[i], account);	
			}
		}catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Reject 이벤트 처리<br>
	 * ESM_AGT_008 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param AgtFacAgmtRtVO[] agtFacAgmtRtVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	 public void modifyFACRateReject(AgtFacAgmtRtVO[] agtFacAgmtRtVOS, SignOnUserAccount account) throws EventException {
		 try {
			log.info("\n agtFacAgmtRtVOS.length = "+agtFacAgmtRtVOS.length);
			for(int i=0; i<agtFacAgmtRtVOS.length; i++){
				if (agtFacAgmtRtVOS[i].getCheck().equals("1") && 
						agtFacAgmtRtVOS[i].getCommProcStsCd().equals("RR") || 
						agtFacAgmtRtVOS[i].getCommProcStsCd().equals("AS")){							
					agtFacAgmtRtVOS[i].setFrtFwrdCntCd(agtFacAgmtRtVOS[i].getFrtFwrdCntCdSeq().substring(0,2));
					agtFacAgmtRtVOS[i].setFrtFwrdCustSeq(agtFacAgmtRtVOS[i].getFrtFwrdCntCdSeq().substring(2));
					agtFacAgmtRtVOS[i].setFacAproUsrId(account.getUsr_id());
					agtFacAgmtRtVOS[i].setFacAproUsrEml(account.getUsr_eml());
					log.info("\n agtFacAgmtRtVOS[i] setFacAproUsrEml ="+agtFacAgmtRtVOS[i].getFacAproUsrEml());
					dbDao.modifyFACRateReject(agtFacAgmtRtVOS[i], account);
					
				}
			}
				
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	 }
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_AGT_0035 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param AgtFacAgmtGrpLocListVO agtFacAgmtGrpLocListVO
	 * @return List<AgtFacAgmtGrpLocListVO>
	 * @exception EventException
	 */
	public List<AgtFacAgmtGrpLocListVO> searchFACGrpLocList(AgtFacAgmtGrpLocListVO agtFacAgmtGrpLocListVO) throws EventException {
		
		try {
			return dbDao.searchFACGrpLocList(agtFacAgmtGrpLocListVO);
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * agt 업무 시나리오 마감작업<br>
	 * AGTCustomerAgreementInfo업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}



	/**
	 * 조회 이벤트 처리<br>
	 * ESM_AGT_0057 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param AgtScsAgmtRtVO agtScsAgmtRtVO
	 * @return List<AgtScsAgmtRtVO>
	 * @exception EventException
	 */

	public List<AgtScsAgmtRtVO> searchScsRateInfoList(AgtScsAgmtRtVO agtScsAgmtRtVO) throws EventException {
		try {
			return dbDao.searchScsRateInfoList(agtScsAgmtRtVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * ESM_AGT_0057 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param AgtScsAgmtRtVO[] agtScsAgmtRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */

	public void multiScsRateInfo(AgtScsAgmtRtVO[] agtScsAgmtRtVO, SignOnUserAccount account) throws EventException{
		try {
			List<AgtScsAgmtRtVO> insertVoList = new ArrayList<AgtScsAgmtRtVO>();
			List<AgtScsAgmtRtVO> updateVoList = new ArrayList<AgtScsAgmtRtVO>();
			List<AgtScsAgmtRtVO> deleteVoList = new ArrayList<AgtScsAgmtRtVO>();
			//Code Check
			CommonBC cbc = new CommonBCImpl();
			String brog_cnt_cust_seq = "";
			String shpr_cnt_seq = "";


			for ( int i=0; i<agtScsAgmtRtVO .length; i++ ) {
				if ( agtScsAgmtRtVO[i].getIbflag().equals("I")){
					agtScsAgmtRtVO[i].setCreUsrId(account.getUsr_id());
					agtScsAgmtRtVO[i].setUpdUsrId(account.getUsr_id());
					brog_cnt_cust_seq = cbc.searchCode("C", "C", agtScsAgmtRtVO[i].getBrogCntCustSeq().trim());
					agtScsAgmtRtVO[i].setBrogCntCd(brog_cnt_cust_seq.substring(0, 2)); //초기화
					agtScsAgmtRtVO[i].setBrogCustSeq(brog_cnt_cust_seq.substring(2)); //초기화

					if ( "*000000".equals(agtScsAgmtRtVO[i].getShprCntSeq().trim())
					  || "000000".equals(agtScsAgmtRtVO[i].getShprCntSeq().trim()))
					{
						agtScsAgmtRtVO[i].setShprCntCd("*");
					} else if(agtScsAgmtRtVO[i].getShprCntSeq().length() > 2) {
						shpr_cnt_seq = cbc.searchCode("C", "C", agtScsAgmtRtVO[i].getShprCntSeq().trim());

						agtScsAgmtRtVO[i].setShprCntCd(shpr_cnt_seq.substring(0, 2));
						agtScsAgmtRtVO[i].setShprSeq(shpr_cnt_seq.substring(2));
					} else {
						agtScsAgmtRtVO[i].setShprCntCd("*");
						agtScsAgmtRtVO[i].setShprSeq("0");
					}

					
					insertVoList.add(agtScsAgmtRtVO[i]);
				} else if ( agtScsAgmtRtVO[i].getIbflag().equals("U")){
					agtScsAgmtRtVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(agtScsAgmtRtVO[i]);
					brog_cnt_cust_seq = cbc.searchCode("C", "C", agtScsAgmtRtVO[i].getBrogCntCustSeq().trim());
					agtScsAgmtRtVO[i].setBrogCntCd(brog_cnt_cust_seq.substring(0, 2)); //초기화
					agtScsAgmtRtVO[i].setBrogCustSeq(brog_cnt_cust_seq.substring(2)); //초기화

					if ( "*000000".equals(agtScsAgmtRtVO[i].getShprCntSeq().trim())
					  || "000000".equals(agtScsAgmtRtVO[i].getShprCntSeq().trim()))
					{
						agtScsAgmtRtVO[i].setShprCntCd("*");
					} else if(agtScsAgmtRtVO[i].getShprCntSeq().length() > 2) {
						shpr_cnt_seq = cbc.searchCode("C", "C", agtScsAgmtRtVO[i].getShprCntSeq().trim());

						agtScsAgmtRtVO[i].setShprCntCd(shpr_cnt_seq.substring(0, 2));
						agtScsAgmtRtVO[i].setShprSeq(shpr_cnt_seq.substring(2));
					} else {
						agtScsAgmtRtVO[i].setShprCntCd("*");
						agtScsAgmtRtVO[i].setShprSeq("0");
					}

				} else if ( agtScsAgmtRtVO[i].getIbflag().equals("D")){
					brog_cnt_cust_seq = cbc.searchCode("C", "C", agtScsAgmtRtVO[i].getBrogCntCustSeq().trim());
					agtScsAgmtRtVO[i].setBrogCntCd(brog_cnt_cust_seq.substring(0, 2)); //초기화
					agtScsAgmtRtVO[i].setBrogCustSeq(brog_cnt_cust_seq.substring(2)); //초기화
					deleteVoList.add(agtScsAgmtRtVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addmultiScsRateInfoS(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymultiScsRateInfoS(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removemultiScsRateInfoS(deleteVoList);
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}


}