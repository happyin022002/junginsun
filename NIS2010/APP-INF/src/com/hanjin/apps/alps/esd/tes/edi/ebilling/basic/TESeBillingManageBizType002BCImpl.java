/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TESeBillingManageDetailType002BCImpl.java
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

//import java.util.HashMap;
import java.util.List;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.syscommon.common.table.TesEdiSoDtlVO;
import com.hanjin.syscommon.common.table.TesEdiSoHdrVO;
import com.hanjin.syscommon.common.table.TesEdiSoCntrListVO;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.basic.TESeBillingCommonBC;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.integration.TESeBillingManageBizType002DBDAO;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.util.TESeBillingManageParseUtil;

/**
 * ALPS-ESD Business Logic Basic Command implementation<br>
 * - ALPS-ESD에 대한 비지니스 로직을 처리한다.<br>
 * 
 * TYPE2. EUR (ECT/Euromax...)
 *
 * @author 
 * @see TESeBillingManageBizType002BCImpl 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class TESeBillingManageBizType002BCImpl extends TESeBillingManageBizType000BCImpl {

	/**
	 * TES eBilling TYPE별 DBDAO
	 */
	private transient TESeBillingManageBizType002DBDAO ediDbDao = new TESeBillingManageBizType002DBDAO();
	
	/**
	 * TESeBillingManageDetailType002BCImpl default 객체 생성<br>
	 */
	public TESeBillingManageBizType002BCImpl(){
		super(new TESeBillingManageBizType002DBDAO());
	}
	 
	/**
	 * TESeBillingManageDetailType002BCImpl dao 인자 객체 생성<br>
	 * @param ediDbDao
	 */
	public TESeBillingManageBizType002BCImpl(TESeBillingManageBizType002DBDAO ediDbDao) {
		super(ediDbDao);
	}

	
	/**
	 * F/F을 parse method로 해당 tag만 대상으로 DATA 분리해 내기
	 * 
	 * @param pars_mzd_cd
	 * @param str_ff
	 * @param tag_nm
	 * @return Object
	 * @throws EventException
	 */
	public Object getTagUnitData(String pars_mzd_cd, String str_ff, String tag_nm) throws EventException {
		log.error("\n\n bbbb -- TESeBillingManageDetailType002BCImpl.getTagUnitData - ########################################### ");
		if (pars_mzd_cd!=null && !pars_mzd_cd.trim().equals("")){
			return new TESeBillingManageParseUtil(pars_mzd_cd).getTagUnitData(str_ff, tag_nm);
		} else {
			return null;
		}
	}

	/**
	 * EDI INVOICE 임시 저장 후 추가 작업 : 구주는 VVD구하는 작업이 다르다.
	 * 
	 * @param eventResponse
	 * @exception EventException
	 */
	protected void createEDIInvoiceData2Step02(EventResponse eventResponse) throws EventException {
//		log.error("\n BEGIN "+JSPUtil.getNull(this.getClass().getName()).split("\\.")[JSPUtil.getNull(this.getClass().getName()).split("\\.").length-1] +".createEDIInvoiceData2Step02 - ########################################### ");
		log.error("\n BEGIN "+JSPUtil.getNull(this.getClass().getName())+".createEDIInvoiceData2Step02 - ########################################### ");

		TesEdiSoHdrVO invVO = null;
		List<TesEdiSoDtlVO> tesEdiSoDtlVOlist = null;
		List<TesEdiSoCntrListVO> tesEdiSoCntrListVOlist = null;
		
		try {
			invVO = (TesEdiSoHdrVO)((GeneralEventResponse)eventResponse).getCustomData(TESeBillingCommonBC.INV_HDR);
			if (invVO!=null){
				if (JSPUtil.getNull(invVO.getTmlInvTpCd()).trim().equals("TM")){
					/**
					 * 정규 VVD가 없어서 CALL SIGN / LLOYD CD / BKG REF NO / CNTR NO / BKG NO로 VVD Update해야 할 DTL 대상 조회 및 Update하기
					 */
					tesEdiSoDtlVOlist = ediDbDao.getEDInvoiceToUpdateDtlVVD(invVO);
					if (tesEdiSoDtlVOlist!=null && tesEdiSoDtlVOlist.size()>0){
						ediDbDao.updateEDInvoiceDtlVVD(tesEdiSoDtlVOlist);	
					}

					/**
					 * 정규 VVD가 없어서 CALL SIGN / LLOYD CD / BKG REF NO / CNTR NO / BKG NO로 VVD Update해야 할 CNTR List 대상 조회 및 Update하기
					 */
					tesEdiSoCntrListVOlist = ediDbDao.getEDInvoiceToUpdateCntrListVVD(invVO);
					if (tesEdiSoCntrListVOlist!=null && tesEdiSoCntrListVOlist.size()>0){
						ediDbDao.updateEDInvoiceCntrListVVD(tesEdiSoCntrListVOlist);	
					}
				}
				
				/**
				 * (구주EDI의 경우) 수동비용의 경우 구주는 VOL * RATE만 제공하는 경우가 있어서 DTL AMT를 확인하여 누락된 경우는 TES가 계산해서 DTL AMT에 넣어준다.
				 */
				ediDbDao.updateEDInvoiceDTLInvAmt(invVO);
			}
		} catch(DAOException e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		} catch(Exception e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		}
		log.error("\n END "+JSPUtil.getNull(this.getClass().getName())+".createEDIInvoiceData2Step02 - ########################################### ");
	}
	
	/**
	 * ESD 업무 시나리오 마감작업<br>
	 * TESeBillingManageDetailType002BCImpl업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		ediDbDao = null;
	}
}