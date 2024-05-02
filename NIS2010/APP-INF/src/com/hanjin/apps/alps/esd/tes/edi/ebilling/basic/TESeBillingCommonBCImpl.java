/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TESeBillingCommonBCImpl.java
*@FileTitle : TES eBilling EDI 처리
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2012-01-04 
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.edi.ebilling.basic;

import java.util.List;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

import com.hanjin.apps.alps.esd.tes.edi.ebilling.integration.TESeBillingManageCommonDBDAO;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.vo.ComTesEdiRcvFltFileTagVO;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.vo.ComTesEdiRcvFltFileXcldVO;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.vo.ComTesEdiRcvRuleMnVO;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.vo.ComTesEdiRcvRuleVndrMgmtVO;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes0013Event;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.util.TESeBillingManageUtil;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.event.TESeBillingEvent;

import com.hanjin.syscommon.common.table.TesEdiSoErrLogVO;
import com.hanjin.syscommon.common.table.TesEdiSoHdrVO;


/**
 * ALPS-ESD Business Logic Basic Command implementation<br>
 * - ALPS-ESD에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author 
 * @see TESeBillingCommonBCImpl 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class TESeBillingCommonBCImpl extends BasicCommandSupport implements TESeBillingCommonBC {

	/**
	 * TES eBilling 공용 DBDAO
	 */
	private transient TESeBillingManageCommonDBDAO ediCommDbDao = null;
	
	public TESeBillingCommonBCImpl(){
		this.ediCommDbDao = new TESeBillingManageCommonDBDAO();
	}

	/**
	 * EDI Main Rule 조회
	 * 
	 * @param tesEdiErrLogVO
	 * @throws EventException
	 */
	public void logEDIErrMsg(TesEdiSoErrLogVO tesEdiErrLogVO) throws EventException{
		log.debug("\n BBBB - TESeBillingCommonBCImpl - logEDIErrMsg~~~~~ \n");
		
		try {
			ediCommDbDao.logEDIErrMsg(tesEdiErrLogVO);
		} catch(DAOException e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		} catch(Exception e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		}
		log.debug("\n EEEE - TESeBillingCommonBCImpl - logEDIErrMsg~~~~~ \n");
	}
	
	/**
	 * 유효한 eBilling EDI VNDR여부를 확인한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public String checkValidEdiVndrSeq(Event e) throws EventException {
		
		TESeBillingEvent event = (TESeBillingEvent)e;
		String retval = null;
		event.getTesEdiSoHdrVO();
		
		try {
			if (event!=null && event.getTesEdiSoHdrVO()!=null){
				retval = ediCommDbDao.checkValidEdiVndrSeq(event.getTesEdiSoHdrVO());	
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return retval;
	}	
	
	/**
	 * EDI Main Rule 조회
	 * 
	 * @return ComTesEdiRcvRuleMnVO
	 * @throws EventException
	 */
	public ComTesEdiRcvRuleMnVO getEdiMainRule(TesEdiSoHdrVO tesEdiInitVO) throws EventException{
		log.debug("\n TESeBillingCommonBCImpl - getEdiMainRule~~~~~ \n");
		
		try {
			return ediCommDbDao.getEdiMainRule(tesEdiInitVO);
		} catch(DAOException e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		} catch(Exception e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		}
	}
	
	/**
	 * EDI VNDR별 Rule 조회 및 vo에 설정
	 * 
	 * @return 
	 * @throws EventException
	 */
	public void getSetEdiVndrRules(TesEdiSoHdrVO tesEdiInitVO, ComTesEdiRcvRuleMnVO tesEdiRuleMainVO) throws EventException{
		log.debug("\n TESeBillingCommonBCImpl - getSetEdiVndrRules~~~~~ \n");
		
		ComTesEdiRcvRuleVndrMgmtVO tesEdiRuleVndrVO = null;
		List<ComTesEdiRcvFltFileTagVO> tesEdiRcvFltFileTagVOlist = null;
		List<ComTesEdiRcvFltFileXcldVO> tesEdiRcvFltFileXcldVOlist = null;
		
		try {
			tesEdiRuleVndrVO = ediCommDbDao.getSetEdiVndrRules(tesEdiInitVO);
			if (tesEdiRuleVndrVO!=null){
				tesEdiRuleMainVO.setComTesEdiRcvRuleVndrMgmtVO(tesEdiRuleVndrVO);
				tesEdiRcvFltFileTagVOlist = ediCommDbDao.getSetFltFileTagRules(tesEdiInitVO);
				if (tesEdiRcvFltFileTagVOlist!=null){
					tesEdiRuleVndrVO.setComTesEdiRcvFltFileTagVOlist(tesEdiRcvFltFileTagVOlist);
					for (int i=0; tesEdiRcvFltFileTagVOlist!=null && i<tesEdiRcvFltFileTagVOlist.size(); i++){
						tesEdiRcvFltFileXcldVOlist = ediCommDbDao.getSetFltFileXcldDtlRules(tesEdiInitVO, tesEdiRcvFltFileTagVOlist.get(i));
						if (tesEdiRcvFltFileXcldVOlist!=null){
							tesEdiRcvFltFileTagVOlist.get(i).setComTesEdiRcvFltFileXcldVOlist(tesEdiRcvFltFileXcldVOlist);	
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
	}
	
	/**
	 * F/F별 수신시 SESSION KEY가 되는 TML_INV_EDI_SEQ를 구함
	 * 
	 * @return String
	 * @throws EventException
	 */
	public String createTmlInvEdiSeq() throws EventException {
		log.debug("\n TESeBillingCommonBCImpl - createTmlInvEdiSeq~~~~~ \n");
		
		try {
			return ediCommDbDao.createTmlInvEdiSeq();
		} catch(DAOException e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		} catch(Exception e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		}
	}
	
	/**
	 * EDI 저장된 INVOICE목록 가져오기(처리 중인 F/F 전체 단위로)
	 *  
	 * @return List<TesEdiSoHdrVO>
	 * @param eventResponse
	 * @throws EventException
	 */
	public List<TesEdiSoHdrVO> getEDIInvoiceList(EventResponse eventResponse)throws EventException {
		log.debug("\n  TESeBillingManageDetailType01Impl-getEDIInvoiceList~~~~~BBBB \n");
		
		String tml_inv_edi_seq = (String)((GeneralEventResponse)eventResponse).getCustomData(TESeBillingCommonBC.TML_INV_EDI_SEQ);
		
		try {
			
			return ediCommDbDao.getEDIInvoiceList(tml_inv_edi_seq);
			
		} catch(DAOException e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		} catch(Exception e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		}
	}
	
	/**
	 * EDI Invoice를 정규 Invoice로 변환한다.
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse convertEDIInvoice2TMLInvoice(Event e)throws EventException {
		log.debug("\n  TESeBillingManageDetailType01Impl-getEDIInvoiceList~~~~~BBBB \n");
		
		EventResponse eventResponse = null;
		TesEdiSoHdrVO tesEdiSoHdrVo = null;
		TESeBillingManageBC tes_command = null;
		ComTesEdiRcvRuleMnVO tesEdiRuleMainVO = null;
		
		try {
			if (e!=null){
				if (e.getEventName().equalsIgnoreCase("EsdTes0013Event")){
//				if (e instanceof EsdTes0013Event){
					EsdTes0013Event event = (EsdTes0013Event)e;
					tesEdiSoHdrVo = event.getTesEdiSoHdrVO();
					if (tesEdiSoHdrVo!=null){
						tesEdiSoHdrVo.setCreUsrId(event.getSignOnUserAccount()!=null?(JSPUtil.getNull(event.getSignOnUserAccount().getUsr_id())):"");	
					}
				}
				if (tesEdiSoHdrVo!=null){
					tesEdiRuleMainVO = getEdiMainRule(tesEdiSoHdrVo);
					if (tesEdiRuleMainVO!=null){
						if (tesEdiSoHdrVo!=null && tesEdiSoHdrVo.getVndrSeq()!=null && !tesEdiSoHdrVo.getVndrSeq().trim().equals("")){
							new TESeBillingManageUtil().getSetEdiVndrRules(tesEdiSoHdrVo, tesEdiRuleMainVO);
						} else {
							log.error("\n No EDI VNDR found Exception!!! \n ");
							throw new Exception("No EDI VNDR found Exception!!!");
						}
						tes_command = TESeBillingManageUtil.getBcInstance(tesEdiRuleMainVO.getComTesEdiRcvRuleVndrMgmtVO());
						if (tes_command!=null){
							eventResponse = tes_command.convertEDIInvoice2TMLInvoice(tesEdiSoHdrVo);
						} else {
							log.debug("\n No BCImpl class found!!! \n ");
							throw new Exception("No BCImpl class found!!!");
						}
					} else {
						log.debug("\n No EDI Main Rule found!!! \n ");
						throw new Exception("No EDI Main Rule found!!!");
					}					
				} else {
					log.debug("\n No EDI Invoice Hdr found!!! \n ");
					throw new Exception("\n No EDI Invoice Hdr found!!! \n ");
				}
			}
		} catch(EventException ex){
			ex.getMessage();
			throw new EventException(ex.getMessage());
		} catch(Exception ex){
			ex.getMessage();
			throw new EventException(ex.getMessage());
		}
		return eventResponse;		
	}
	
	/**
	 * ESD 업무 시나리오 마감작업<br>
	 * TESeBillingManageDetailType01Impl업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		ediCommDbDao = null;
	}
}