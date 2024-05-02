/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TESeBillingManageBizType000BCImpl.java
*@FileTitle : TES eBilling EDI 처리
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2012-06-10 
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.edi.ebilling.basic;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.syscommon.common.table.TesEdiSoHdrVO;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.basic.TESeBillingCommonBC;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.integration.TESeBillingManageBizType000DBDAO;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.util.TESeBillingManageUtil;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.vo.ComTesEdiRcvRuleMnVO;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.vo.ComTesEdiRcvRuleVndrMgmtVO;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.vo.ComTesEdiRcvFltFileTagVO;

/**
 * ALPS-ESD Business Logic Basic Command implementation<br>
 * - ALPS-ESD에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author 
 * @see TESeBillingManageBizType000BCImpl 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public abstract class TESeBillingManageBizType000BCImpl implements TESeBillingManageBizType000BC {

	/**
	 * log
	 */
	protected Logger log = Logger.getLogger(TESeBillingManageBizType000BCImpl.class.getName());
	
	/**
	 * TES eBilling TYPE별 DBDAO
	 */
	private transient TESeBillingManageBizType000DBDAO ediDbDao = null;
	
	
	/**
	 * TESeBillingManageBizType000BCImpl default 객체 생성<br>
	 */
	public TESeBillingManageBizType000BCImpl() {
	}

	/**
	 * TESeBillingManageBizType000BCImpl dao인자로 객체 생성<br>
	 * @param ediDbDao
	 */
	public TESeBillingManageBizType000BCImpl(TESeBillingManageBizType000DBDAO ediDbDao) {
		this.ediDbDao = ediDbDao;
	}
	
	/**
	 * <중> 본 CLASS를 상속하는 BIZ TYPE CLASS들은 getTagUnitData()를 구현하게 한다.
	 * F/F을 parse method로 해당 tag만 대상으로 DATA 분리해 내기
	 * 
	 * @param pars_mzd_cd
	 * @param str_ff
	 * @param tag_nm
	 * @throws EventException
	 */
	public abstract Object getTagUnitData(String pars_mzd_cd, String str_ff, String tag_nm) throws EventException;
	
	
	/**
	 * EDI에서 전송한 FLAT FILE에서 INVOICE정보를 MODEL별로 추출하여 Hashmap으로 추출하기
	 * 
	 * @param eventResponse
	 * @exception EventException
	 */
	public void getEDIInvoiceInTESformat(EventResponse eventResponse) throws EventException {
		
		log.debug("\n BEGIN - TESeBillingManageBizType000BCImpl-getEDIInvoiceInTESformat~~~~~ \n");
		
		String str_ff = null;
		ComTesEdiRcvRuleMnVO tesEdiRuleMainVO = null;
		ComTesEdiRcvRuleVndrMgmtVO tesEdiRcvRuleVndrMgmtVO = null;
		List<ComTesEdiRcvFltFileTagVO> tesEdiRcvFltFileTagVOlist = null;
		
		try {
			
			str_ff = (String)((GeneralEventResponse)eventResponse).getCustomData(TESeBillingCommonBC.FLT_FILE);
			str_ff = (str_ff!=null&&!str_ff.equals("")?str_ff.trim().replaceAll("'","''"):"");
			//str = (str!=null&&!str.equals("")?str.trim().replaceAll("(\\^|\\[|\\.|\\$|\\{|\\*|\\(|\\)|\\|\\+|\\||\\?|\\<|\\>)","\\\\$1"):"");
			
			tesEdiRuleMainVO = (ComTesEdiRcvRuleMnVO)((GeneralEventResponse)eventResponse).getCustomData(TESeBillingCommonBC.EDI_RULE_MAIN);
			
			tesEdiRcvRuleVndrMgmtVO = tesEdiRuleMainVO.getComTesEdiRcvRuleVndrMgmtVO();
			if (tesEdiRcvRuleVndrMgmtVO!=null){
				tesEdiRcvFltFileTagVOlist = tesEdiRcvRuleVndrMgmtVO.getComTesEdiRcvFltFileTagVOlist();
			}

			/**
			 * EDI RULE VO에서 TAG LIST를 쭈~욱 들고와서 LIST 수만큼 LOOP를 돈다.
			 * 
			 * 단 TAG의 순서는 반드시 -> HDR > DTL / CNTR_LIST > MNL_CNTR_LIST > AUTO_FP_LIST 순으로 가져오게 한다.
			 * 넣는 순서도 마찬가지...
			 * 
			 * 관련 EDI RULE TABLE에서 SAVE SEQ.로 순서를 정의한다.
			 * 
			 */
			for (int i=0; tesEdiRcvFltFileTagVOlist!=null && i<tesEdiRcvFltFileTagVOlist.size(); i++){
				HashMap<String,String>[] hms = null;
				hms = (HashMap<String,String>[])getTagUnitData(tesEdiRcvRuleVndrMgmtVO.getParsMzdCd(), str_ff, tesEdiRcvFltFileTagVOlist.get(i).getFltFileTagNm());

				eventResponse.setCustomData(tesEdiRcvFltFileTagVOlist.get(i).getFltFileTagNm().trim(), hms); //TAG명으로 담는다.
				
				continue;
			}
			
			log.debug("\n\n END - TESeBillingManageBizType000BCImpl.getEDIinvoiceInTESformat - ########################################### ");
			
		} catch (Exception e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		}
	}
	

	/**
	 * EDI data를 임시 저장소에 저장
	 * 
	 * @param eventResponse
	 * @exception EventException
	 */
	public void createEDIInvoiceData(EventResponse eventResponse) throws EventException {
		log.debug("\n  TESeBillingManageBizType000BCImpl-createEDIInvoiceData~~~~~BBBB \n");
		
		ComTesEdiRcvRuleMnVO tesEdiRuleMainVO = null;
		ComTesEdiRcvRuleVndrMgmtVO tesEdiRcvRuleVndrMgmtVO = null;
		List<ComTesEdiRcvFltFileTagVO> tesEdiRcvFltFileTagVOlist = null;
		TesEdiSoHdrVO tesEdiInitVO = null;
		HashMap<String,String>[] hms = null;
		String[] tab_cols = null;
		String[][] exc_cols_n_val = null;
		int valid_hdr_knt = 0;
		
		try {
			tesEdiRuleMainVO	= (ComTesEdiRcvRuleMnVO)((GeneralEventResponse)eventResponse).getCustomData(TESeBillingCommonBC.EDI_RULE_MAIN);
			tesEdiInitVO		= (TesEdiSoHdrVO)((GeneralEventResponse)eventResponse).getCustomData(TESeBillingCommonBC.EDI_INIT_VO);
			
			tesEdiRcvRuleVndrMgmtVO = tesEdiRuleMainVO.getComTesEdiRcvRuleVndrMgmtVO();
			if (tesEdiRcvRuleVndrMgmtVO!=null){
				tesEdiRcvFltFileTagVOlist = tesEdiRcvRuleVndrMgmtVO.getComTesEdiRcvFltFileTagVOlist();
			}
			
			/**
			 * 임시 TABLE에 일단 저장
			 */
			for (int i=0; tesEdiRcvFltFileTagVOlist!=null && i<tesEdiRcvFltFileTagVOlist.size(); i++){
				/** EDI RULE에서 TAG의 SAVE SEQ. 순서에 맞게 저장한다. 각 순서당 PK를 추출 및 HMS에 저장한다. **/
				if (tesEdiRcvFltFileTagVOlist.get(i)!=null){
					if (tesEdiRcvFltFileTagVOlist.get(i).getFltFileTagNm()!=null && !tesEdiRcvFltFileTagVOlist.get(i).getFltFileTagNm().trim().equals("")){
						hms = (HashMap<String,String>[])((GeneralEventResponse)eventResponse).getCustomData(tesEdiRcvFltFileTagVOlist.get(i).getFltFileTagNm().trim());
						if (hms!=null && hms.length>0){
							if (tesEdiRcvFltFileTagVOlist.get(i).getHdrTagFlg()!=null && tesEdiRcvFltFileTagVOlist.get(i).getHdrTagFlg().trim().equals("Y")){
								/** HDR TAG인 경우 **/
								if (tesEdiRcvFltFileTagVOlist.get(i).getTagVldKnt()!=null && !tesEdiRcvFltFileTagVOlist.get(i).getTagVldKnt().trim().equals("")){
									valid_hdr_knt =  Integer.parseInt(tesEdiRcvFltFileTagVOlist.get(i).getTagVldKnt()!=null&&!tesEdiRcvFltFileTagVOlist.get(i).getTagVldKnt().trim().equals("")?tesEdiRcvFltFileTagVOlist.get(i).getTagVldKnt().trim():"1");
								}
								if (hms.length == valid_hdr_knt){
									/** KEY값  inv_ofc_cd/tml_edi_so_ofc_cty_cd/tml_edi_so_seq들을 조회하고 hms[0]에도 넣어주고, tesEdiInitVO에도 설정하여 이후에도 참조할 수 있게 한다. **/
									setMainKeyValue(hms[0], tesEdiInitVO, tesEdiRcvRuleVndrMgmtVO);
								} else {
									throw new EventException("\n EDI INVOICE HEADER COUNT EXCEPTION! \n");
								}
							}
							tab_cols = ediDbDao.getTabColumns(JSPUtil.getNull(tesEdiRcvFltFileTagVOlist.get(i).getTblNm()).trim());
							
//							log.debug("\n tesEdiInitVO --"
//									+" TmlEdiSoOfcCtyCd : "+(tesEdiInitVO!=null?JSPUtil.getNull(tesEdiInitVO.getTmlEdiSoOfcCtyCd()):"") 
//									+" TmlEdiSoSeq : "+(tesEdiInitVO!=null?JSPUtil.getNull(tesEdiInitVO.getTmlEdiSoSeq()):"")
//									+" InvOfcCd : "+(tesEdiInitVO!=null?JSPUtil.getNull(tesEdiInitVO.getInvOfcCd()):"")
//									+" <<<<<\n");
							
							exc_cols_n_val 	= TESeBillingManageUtil.getExcColsNVal(tesEdiRcvFltFileTagVOlist.get(i).getComTesEdiRcvFltFileXcldVOlist(), tesEdiInitVO);
							if (tab_cols!=null && tab_cols.length>0 && exc_cols_n_val!=null && exc_cols_n_val.length>0){
								ediDbDao.saveEDInvoiceTmpData(tesEdiRcvFltFileTagVOlist.get(i), hms, tab_cols, exc_cols_n_val, tesEdiInitVO);
							}
						} else {
							log.debug("\n ["+(JSPUtil.getNull(tesEdiRcvFltFileTagVOlist.get(i).getFltFileTagNm()))+"] no hm found!!! \n");
						}
					}
				}
			}
			
		} catch(Exception e) {
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		}
		
		log.debug("\n  TESeBillingManageBizType000BCImpl-createEDIInvoiceData~~~~~EEEE \n");
	}
	
	
	/**
	 * EDI INVOICE의 주요키 값을 설정한다.
	 * 
	 * @param hms
	 * @param tesEdiInitVO
	 * @param tesEdiRcvRuleVndrMgmtVO
	 * @throws EventException
	 */
	protected void setMainKeyValue(HashMap<String,String> hm, TesEdiSoHdrVO tesEdiInitVO, ComTesEdiRcvRuleVndrMgmtVO tesEdiRcvRuleVndrMgmtVO ) throws EventException {
		log.debug("\n  TESeBillingManageBizType000BCImpl-setMainKeyValue~~~~~BBBB \n");
		
		String inv_ofc_cd = null;
		String tml_edi_so_ofc_cty_cd = null;
		String tml_edi_so_seq = null;

		try {
			
			/** F/F에서든... EDI VNDR RULE의 INV OFC를 통해서든... 또는 VNDR SEQ로 MDM VENDOR를 통해서든 INV OFC를 구해야한다. **/
			inv_ofc_cd = hm.get("INV_OFC_CD");
			if (inv_ofc_cd==null || inv_ofc_cd.trim().equals("")){
				if (tesEdiRcvRuleVndrMgmtVO!=null){
					if (tesEdiRcvRuleVndrMgmtVO.getInvOfcMdmRefFlg()!=null && tesEdiRcvRuleVndrMgmtVO.getInvOfcMdmRefFlg().trim().equals("Y")){
						inv_ofc_cd = tesEdiRcvRuleVndrMgmtVO.getInvOfcCd(); 
					}
				}
			}
			
			/**
			 * F/F에서 수신된 INV_OFC가 있다면 사용하고
			 * 만일 없다면 EDI RULE을 보고 RULE에 정의된 OFC를 사용한다.
			 *  -> 일단 저장하고 마지막 VALIDATION 단계에서 OFC유효성 검사를 한다.
			 */
			if (inv_ofc_cd!=null && !inv_ofc_cd.trim().equals("") && inv_ofc_cd.trim().length()>=5){
				tml_edi_so_ofc_cty_cd = inv_ofc_cd.substring(0,3);
				if (tml_edi_so_ofc_cty_cd!=null && !tml_edi_so_ofc_cty_cd.trim().equals("")){
					tml_edi_so_seq = ediDbDao.getEdiHdrSoSeq();
					if (tml_edi_so_seq!=null && !tml_edi_so_seq.trim().equals("")){
						if (tesEdiInitVO!=null){
							hm.put("INV_OFC_CD", inv_ofc_cd);
							hm.put("TML_EDI_SO_OFC_CTY_CD", JSPUtil.getNull(tml_edi_so_ofc_cty_cd));
							hm.put("TML_EDI_SO_SEQ", JSPUtil.getNull(tml_edi_so_seq));
							hm.put("TML_INV_EDI_SEQ", JSPUtil.getNull(tesEdiInitVO.getTmlInvEdiSeq()));
							tesEdiInitVO.setInvOfcCd(inv_ofc_cd);
							tesEdiInitVO.setTmlEdiSoOfcCtyCd(tml_edi_so_ofc_cty_cd);
							tesEdiInitVO.setTmlEdiSoSeq(tml_edi_so_seq);
							tesEdiInitVO.setEdiRcvRuleMnSeq(tesEdiRcvRuleVndrMgmtVO!=null?JSPUtil.getNull(tesEdiRcvRuleVndrMgmtVO.getEdiRcvRuleMnSeq()):"");
							/* 추가로 vndr code와 yard code도 여기서 VO에 넣어준다. */
							if ( (tesEdiInitVO.getVndrSeq()==null || tesEdiInitVO.getVndrSeq().trim().equals("")) &&
								 (hm.get("VNDR_SEQ")!=null && !hm.get("VNDR_SEQ").trim().equals("")) ) 
							{
								tesEdiInitVO.setVndrSeq(JSPUtil.getNull(hm.get("VNDR_SEQ")));
							}
							if ( (tesEdiInitVO.getYdCd()==null || tesEdiInitVO.getYdCd().trim().equals("")) &&
								 (hm.get("YD_CD")!=null && !hm.get("YD_CD").trim().equals("")) ) 
							{
								tesEdiInitVO.setYdCd(JSPUtil.getNull(hm.get("YD_CD")));
							}
						}
					}
				}
			}
			
		} catch(DAOException e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		} catch(Exception e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		}
		log.debug("\n  TESeBillingManageBizType000BCImpl-setMainKeyValue~~~~~EEEE \n");
	}
	
	/**
	 * EDI INVOICE 임시 저장 후 추가 작업
	 * 
	 * @param eventResponse
	 * @exception EventException
	 */
	public void createEDIInvoiceData2(EventResponse eventResponse) throws EventException {
		log.debug("\n  TESeBillingManageBizType000BCImpl-createEDIInvoiceData2~~~~~BBBB \n");
	
		/**
		 * 2) [HDR] COST_OFC_CD 처리 : F/F에서 COST_OFC_CD가 오더라도 RULE에 의해 MDM_YARD를 통해 OFC를 가져올지 정해서 COST_OFC_CD정함
		 * 2) [HDR] Storage invoice의 경우 FM_PRD_DT와 TO_PRD_DT를 F/F에서 받아서 처리하는게 원칙이며 없는 경우 CNTR정보에서 MIN(GI)와 MAX(GO)을 구해서 넣는다.  
		 * 2) [DTL] VNDR의 Tariff를 참조하여 Cost code update
		 * 2) (고민중) [CNTR/DTL] ATB DT 처리 : VVD와 YARD를 기반으로 ATB DT를 구해서 UPDATE해줘야함 -> VALID02에 영향
		 */
		
		createEDIInvoiceData2Step01(eventResponse);
		
		createEDIInvoiceData2Step02(eventResponse);
		
		log.debug("\n  TESeBillingManageBizType000BCImpl-createEDIInvoiceData2~~~~~EEEE \n");
	}
	
	/**
	 * EDI invoice 저장시 첫번째 단계 처리
	 * 
	 * @param eventResponse
	 * @throws EventException
	 */
	protected void createEDIInvoiceData2Step01(EventResponse eventResponse) throws EventException {
		log.error("\n\n TESeBillingManageBizType000BCImpl.createEDIInvoiceData2Step01 - ########################################### ");
		
		TesEdiSoHdrVO invVO = null;
		ComTesEdiRcvRuleMnVO tesEdiRuleMainVO = null;
		ComTesEdiRcvRuleVndrMgmtVO tesEdiRcvRuleVndrMgmtVO = null;
		
		try {
			
			invVO = (TesEdiSoHdrVO)((GeneralEventResponse)eventResponse).getCustomData(TESeBillingCommonBC.INV_HDR);
			tesEdiRuleMainVO	= (ComTesEdiRcvRuleMnVO)((GeneralEventResponse)eventResponse).getCustomData(TESeBillingCommonBC.EDI_RULE_MAIN);
			tesEdiRcvRuleVndrMgmtVO = tesEdiRuleMainVO.getComTesEdiRcvRuleVndrMgmtVO();
			if (tesEdiRcvRuleVndrMgmtVO!=null){
				if (tesEdiRcvRuleVndrMgmtVO.getCostOfcMdmRefFlg()!=null && tesEdiRcvRuleVndrMgmtVO.getCostOfcMdmRefFlg().trim().equals("Y")){
					/**
					 * Cost Ofc가 안 넘어왔거나 mapping이 안된 경우 EDI Rule에 딸 MDM YARD를 참조하여 설정한다.
					 */
					ediDbDao.updateEDInvoiceTmpCostOfc(invVO);
				}
				if (tesEdiRcvRuleVndrMgmtVO.getStoPrdDtChkFlg()!=null && tesEdiRcvRuleVndrMgmtVO.getStoPrdDtChkFlg().trim().equals("Y")){
					if (JSPUtil.getNull(invVO.getTmlInvTpCd()).trim().equals("ST")){
						/**
						 * Storage invoice의 경우 FM PRD DT와 TO PRD DT를 안 주는 경우 EDI Rule에 따라 Gate In/Out의 최소/최대 값으로 기본 설정한다.
						 * 여기서 넣지 않을 경우 정규 invoice로 변환시 설정한다.
						 */
						ediDbDao.updateEDInvoiceTmpFmToDt(invVO);
					}
				}
			}
		} catch(DAOException e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		} catch(Exception e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		}
		log.error("\n\n END - TESeBillingManageBizType000BCImpl.createEDIInvoiceData2Step01 - ########################################### ");
	}
	
	/**
	 * EDI invoice 저장시 두번째 단계 처리
	 * 
	 * @param eventResponse
	 * @throws EventException
	 */
	protected void createEDIInvoiceData2Step02(EventResponse eventResponse) throws EventException {
		log.error("\n\n BEGIN - TESeBillingManageBizType000BCImpl.createEDIInvoiceData2Step02 - ########################################### ");
		
		TesEdiSoHdrVO invVO = null;
		ComTesEdiRcvRuleMnVO tesEdiRuleMainVO = null;
		ComTesEdiRcvRuleVndrMgmtVO tesEdiRcvRuleVndrMgmtVO = null;
		
		try {
			invVO				= (TesEdiSoHdrVO)((GeneralEventResponse)eventResponse).getCustomData(TESeBillingCommonBC.INV_HDR);
			tesEdiRuleMainVO	= (ComTesEdiRcvRuleMnVO)((GeneralEventResponse)eventResponse).getCustomData(TESeBillingCommonBC.EDI_RULE_MAIN);
			tesEdiRcvRuleVndrMgmtVO = tesEdiRuleMainVO.getComTesEdiRcvRuleVndrMgmtVO();
			
			if (tesEdiRcvRuleVndrMgmtVO!=null){
				if (tesEdiRcvRuleVndrMgmtVO.getVndrTrfRefFlg()!=null && tesEdiRcvRuleVndrMgmtVO.getVndrTrfRefFlg().trim().equals("Y")){
					/**
					 * (EDI Rule에서 지정된 경우만 해당) 약속된 VNDR Tariff로 COST CODE UPDATE
					 */
					ediDbDao.updateEDInvoiceDTLTmpLGSCostCode(invVO);		
				}
			}
			
			/**
			 *  수동비용의 경우 VOL * RATE만 제공하는 경우가 있어서 DTL AMT를 확인하여 누락된 경우는 TES가 계산해서 DTL AMT에 넣어준다.
			 */
			ediDbDao.updateEDInvoiceDTLInvAmt(invVO);
			
		} catch(DAOException e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		} catch(Exception e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		}
		log.error("\n\n END - TESeBillingManageBizType000BCImpl.createEDIInvoiceData2Step02 - ########################################### ");
	}
	
	/**
	 * EDI data 유효성 확인
	 * 
	 * @param eventResponse
	 * @exception EventException
	 */
	public void validateEDIInvoice(EventResponse eventResponse) throws EventException {
		log.debug("\n TESeBillingManageBizType000BCImpl-validateEDIInvoice ---- BBBB \n");
		
		TesEdiSoHdrVO tesEdiSoHdrVO = null;
		
		try {
			if (eventResponse!=null){
				tesEdiSoHdrVO = (TesEdiSoHdrVO)((GeneralEventResponse)eventResponse).getCustomData(TESeBillingCommonBC.INV_HDR);
				if (tesEdiSoHdrVO!=null){
					
					/**
					 * EDI invoice validation 확인 작업 완료 표시하고,
					 * 하나라도 자동 reject 건수가 있으면, REMARK값에 설정이 되고 AUTO REJECT 처리한다.
					 * 
					 * Step01 : EDI invoice validation 확인
					 * 
					 * Step02 : validation 후처리 -> 자동 reject 건수가 있으면 AUTO REJECT 처리
					 * 
					 */
					
					validateEDIInvoiceStep02(tesEdiSoHdrVO, validateEDIInvoiceStep01(tesEdiSoHdrVO));
					
				} else {
					throw new EventException("\n TESeBillingManageBizType000BCImpl - validateEDIInvoice ERROR (NO TesEdiSoHdrVO FOUND)");
				}
			} else {
				throw new EventException("\n TESeBillingManageBizType000BCImpl - validateEDIInvoice ERROR (NO EventResponse FOUND)");
			}
		} catch (EventException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch(Exception e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		}
		log.debug("\n TESeBillingManageBizType000BCImpl-validateEDIInvoice ---- EEEE \n");
	}
	
	/**
	 * EDI data 유효성 확인 1단계
	 * 
	 * @param tesEdiSoHdrVO
	 * @return String
	 * @throws EventException
	 */
	protected String validateEDIInvoiceStep01(TesEdiSoHdrVO tesEdiSoHdrVO) throws EventException {
		log.debug("\n TESeBillingManageBizType000BCImpl-validateEDIInvoiceStep01 ---- BBBB \n");
		
		StringBuilder	sbuRjctRmk	= new StringBuilder();
		String			rjctRmk1	= null;
		String			rjctRmk2	= null;
		
		try {
			if (tesEdiSoHdrVO!=null){
				sbuRjctRmk	= new StringBuilder();
				rjctRmk1 = ediDbDao.validateEDIInvoice01(tesEdiSoHdrVO);
				rjctRmk2 = ediDbDao.validateEDIInvoice02(tesEdiSoHdrVO); //ATB DT를 미리 저장하냐 마냐에 따라  ATB DT 검사 LOGIC이 변경된다.
//				log.debug("\n\n rjctRmk1:"+rjctRmk1+" - rjctRmk2:"+rjctRmk2+"\n");
				if (rjctRmk1!=null && !rjctRmk1.trim().equals("")) {
					sbuRjctRmk.append(rjctRmk1);
				}
				if (rjctRmk2!=null && !rjctRmk2.trim().equals("")) {
					sbuRjctRmk.append(rjctRmk1!=null && !rjctRmk1.trim().equals("") ? ", " : "" ).append(rjctRmk2);
				}
			} else {
				throw new EventException("\n TESeBillingManageBizType000BCImpl - validateEDIInvoiceStep01 ERROR (NO TesEdiSoHdrVO FOUND)");
			}
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch(Exception e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		}
		log.debug("\n TESeBillingManageBizType000BCImpl-validateEDIInvoiceStep01 ---- EEEE \n");
		
		return sbuRjctRmk.toString();
	}
	
	/**
	 * EDI data 유효성 확인 1단계
	 * 
	 * @param tesEdiSoHdrVO
	 * @param strRjctRmk
	 * @throws EventException
	 */
	protected void validateEDIInvoiceStep02(TesEdiSoHdrVO tesEdiSoHdrVO, String strRjctRmk) throws EventException {
		log.debug("\n TESeBillingManageBizType000BCImpl-validateEDIInvoiceStep02 ---- BBBB \n");
		
		try {
			if (tesEdiSoHdrVO!=null){
				/**
				 * EDI invoice validation 확인 작업 완료 표시하고,
				 * 하나라도 자동 reject 건수가 있으면, REMARK값에 설정이 되고 AUTO REJECT 처리한다.
				 */			
				ediDbDao.setEDIInvoiceValidSts(tesEdiSoHdrVO, strRjctRmk);
			} else {
				throw new EventException("\n TESeBillingManageBizType000BCImpl - validateEDIInvoiceStep02 ERROR (NO TesEdiSoHdrVO FOUND)");
			}
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch(Exception e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		}
		log.debug("\n TESeBillingManageBizType000BCImpl-validateEDIInvoiceStep02 ---- EEEE \n");
	}
	
	/**
	 * EDI data를 정규 TMN invoice로 변환 작업 - 한번에 단일 Invoice만 대상으로 변환작업을 한다.
	 * 
	 * @param tesEdiSoHdrVo
	 * @return eventResponse
	 * @exception EventException
	 */
	public EventResponse convertEDIInvoice2TMLInvoice(TesEdiSoHdrVO  tesEdiSoHdrVo) throws EventException {
		log.debug("\n TESeBillingManageBizType000BCImpl-convertEDIInvoice2TMLInvoice~~~~~BBBB \n");

		/**
		 * 정규 TML invoice에서 중복 확인
		 */
		convertEDIInvoiceStep01(tesEdiSoHdrVo);

		
		/**
		 * 정규 TML invoice의 key값 따고 TML invoice넣고, EDI invoice에도 걸어줌
		 */
		convertEDIInvoiceStep02(tesEdiSoHdrVo);
		
		/**
		 * <중> 반드시 정규 TML invoice가 생성된 후에 VVD를 넣어야함
		 * 정규 TML invoice의 key값이 확보된 상태로 TML invoice를 같이 걸어서 INVOICE유형을 찾아서 Terminal인지 구분한다.
		 */
		convertEDIInvoiceStep03(tesEdiSoHdrVo);
		
		/**
		 * <중> 반드시 정규 TML invoice가 생성된 후에 DTL을 넣어야함
		 * 정규 TML invoice의 key값이 확보된 상태로 TML invoice를 같이 걸어서 INVOICE유형을 찾아서 값을 구분해야하는 data가 있음
		 */
		convertEDIInvoiceStep04(tesEdiSoHdrVo);
		
		
		EventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setETCData( "successFlag", "SUCCESS" );
		
		log.debug("\n TESeBillingManageBizType000BCImpl-convertEDIInvoice2TMLInvoice~~~~~EEEE \n");
		
		return eventResponse;		
	}

	/**
	 * 정규 TML invoice에서 중복 확인
	 * 
	 * @param tesEdiSoHdrVo
	 * @throws EventException
	 */
	protected void convertEDIInvoiceStep01(TesEdiSoHdrVO  tesEdiSoHdrVo) throws EventException { 
		log.error("\n\n BEGIN - TESeBillingManageBizType000BCImpl.convertEDIInvoiceStep01 - ########################################### ");
		
		try {
			
			ediDbDao.checkRegularInvoiceDup(tesEdiSoHdrVo);
		
		} catch(DAOException e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		} catch(Exception e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		}
		log.error("\n\n END - TESeBillingManageBizType000BCImpl.convertEDIInvoiceStep01 - ########################################### ");
	}
	
	
	/**
	 * 정규 TML invoice의 key값 따고 TML invoice넣고, EDI invoice에도 걸어줌
	 * 
	 * @param tesEdiSoHdrVo
	 * @throws EventException
	 */
	protected void convertEDIInvoiceStep02(TesEdiSoHdrVO  tesEdiSoHdrVo) throws EventException { 
		log.error("\n\n BEGIN - TESeBillingManageBizType000BCImpl.convertEDIInvoiceStep02 - ########################################### ");
		
		try {
			
			ediDbDao.convertEDIInvoiceGetTMLSoSeq(tesEdiSoHdrVo);
			ediDbDao.convertEDIInvoiceTesTmlSoHdr(tesEdiSoHdrVo);
			ediDbDao.convertEDIInvoiceUpdateTesEdiSoHdr(tesEdiSoHdrVo);
			
		} catch(DAOException e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		} catch(Exception e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		}
		log.error("\n\n END - TESeBillingManageBizType000BCImpl.convertEDIInvoiceHdr - ########################################### ");
	}
	
	/**
	 * <중> 반드시 정규 TML invoice가 생성된 후에 VVD를 넣어야함
	 * 정규 TML invoice의 key값이 확보된 상태로 TML invoice를 같이 걸어서 INVOICE유형을 찾아서 Terminal인지 구분한다.
	 * 
	 * @param tesEdiSoHdrVo
	 * @throws EventException
	 */
	protected void convertEDIInvoiceStep03(TesEdiSoHdrVO  tesEdiSoHdrVo) throws EventException { 
		log.error("\n\n BEGIN - TESeBillingManageBizType000BCImpl.convertEDIInvoiceStep03 - ########################################### ");
		
		try {
			
			ediDbDao.convertEDIInvoice2TmlVVDList(tesEdiSoHdrVo);
			
		} catch(DAOException e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		} catch(Exception e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		}
		log.error("\n\n END - TESeBillingManageBizType000BCImpl.convertEDIInvoiceStep03 - ########################################### ");
	}
	
	/**
	 * <중> 반드시 정규 TML invoice가 생성된 후에 DTL을 넣어야함
	 * 정규 TML invoice의 key값이 확보된 상태로 TML invoice를 같이 걸어서 INVOICE유형을 찾아서 값을 구분해야하는 data가 있음
	 * 
	 * @param tesEdiSoHdrVo
	 * @throws EventException
	 */
	protected void convertEDIInvoiceStep04(TesEdiSoHdrVO  tesEdiSoHdrVo) throws EventException { 
		log.error("\n\n BEGIN - TESeBillingManageBizType000BCImpl.convertEDIInvoiceStep04 - ########################################### ");
		
		try {
			
			ediDbDao.convertEDIInvoice2TmlDtl(tesEdiSoHdrVo);
			
		} catch(DAOException e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		} catch(Exception e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		}
		log.error("\n\n END - TESeBillingManageBizType000BCImpl.convertEDIInvoiceStep04 - ########################################### ");
	}

	/**
	 * ESD 업무 시나리오 마감작업<br>
	 * TESeBillingManageBizType000BCImpl업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		ediDbDao = null;
	}
}