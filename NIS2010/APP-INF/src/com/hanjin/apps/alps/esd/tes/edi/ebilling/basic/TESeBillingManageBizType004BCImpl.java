/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TESeBillingManageDetailType004BCImpl.java
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

import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.syscommon.common.table.TesEdiSoHdrVO;
//import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.integration.TESeBillingManageBizType004DBDAO;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.util.TESeBillingManageParseUtil;


/**
 * ALPS-ESD Business Logic Basic Command implementation<br>
 * - ALPS-ESD에 대한 비지니스 로직을 처리한다.<br>
 *
 * TYPE4. HIT/YICT
 * 
 * @author 
 * @see TESeBillingManageBizType004BCImpl 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class TESeBillingManageBizType004BCImpl extends TESeBillingManageBizType000BCImpl {

	/**
	 * TES eBilling TYPE별 DBDAO
	 */
	private transient TESeBillingManageBizType004DBDAO ediDbDao = new TESeBillingManageBizType004DBDAO();
	
	/**
	 * TESeBillingManageDetailType004BCImpl default 객체 생성<br>
	 */
	public TESeBillingManageBizType004BCImpl() {
		super(new TESeBillingManageBizType004DBDAO());
	}

	/**
	 * TESeBillingManageBizType004Impl dao 인자 객체 생성<br>
	 * @param ediDbDao
	 */
	public TESeBillingManageBizType004BCImpl(TESeBillingManageBizType004DBDAO ediDbDao) {
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
		log.error("\n\n bbbb -- TESeBillingManageDetailType004BCImpl.getTagUnitData - ########################################### ");
		if (pars_mzd_cd!=null && !pars_mzd_cd.trim().equals("")){
			return new TESeBillingManageParseUtil(pars_mzd_cd).getTagUnitData(str_ff, tag_nm);
		} else {
			return null;
		}
	}
	
	/**
	 * <중> 반드시 정규 TML invoice가 생성된 후에 DTL을 넣어야함
	 * 정규 TML invoice의 key값이 확보된 상태로 TML invoice를 같이 걸어서 INVOICE유형을 찾아서 값을 구분해야하는 data가 있음
	 * -> HIT/YICT의 경우 자동대상이 아닌경우만 수동비용을 옮긴다.
	 * 
	 * @param tesEdiSoHdrVo
	 * @throws EventException
	 */
	protected void convertEDIInvoiceStep04(TesEdiSoHdrVO  tesEdiSoHdrVo) throws EventException { 
		log.error("\n\n BEGIN - TESeBillingManageDetailType004BCImpl.convertEDIInvoiceStep04 - ########################################### ");
		
		try {
			if (tesEdiSoHdrVo!=null){
				if (  !tesEdiSoHdrVo.getTmlInvTpCd().trim().equals("") && 
						(!tesEdiSoHdrVo.getTmlInvTpCd().trim().equals("MA") && !tesEdiSoHdrVo.getTmlInvTpCd().trim().equals("MK")
						&& !tesEdiSoHdrVo.getTmlInvTpCd().trim().equals("SC") && !tesEdiSoHdrVo.getTmlInvTpCd().trim().equals("SE")
						&& !tesEdiSoHdrVo.getTmlInvTpCd().trim().equals("SF"))  
					)
				{
					ediDbDao.convertEDIInvoice2TmlDtl(tesEdiSoHdrVo);		
				}
			}
		} catch(DAOException e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		} catch(Exception e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		}
		log.error("\n\n END - TESeBillingManageBizType000Impl.convertEDIInvoiceStep04 - ########################################### ");
	}
	
	/**
	 * ESD 업무 시나리오 마감작업<br>
	 * TESeBillingManageDetailType004BCImpl업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		ediDbDao = null;
	}
}