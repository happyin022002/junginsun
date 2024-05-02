/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_903_1Event.java
*@FileTitle : Volume Adjustment PopUp 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-15
*@LastModifier : parkyeonjin
*@LastVersion : 1.0
* 2006-11-15 parkyeonjin
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.vo.OndockRailChargeInvoiceCommonVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.TesTmlSoCntrListVO;
import com.clt.syscommon.common.table.TesTmlSoDtlVO;



/**
 * ESD_TES_903_1 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_903_1HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author parkyeonjin
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTes9031Event extends EventSupport {
	
	private TesTmlSoCntrListVO		tesTmlSoCntrListVO 	= null;
	private TesTmlSoCntrListVO[]	tesTmlSoCntrListVOs = null;
	private TesTmlSoDtlVO			tesTmlSoDtlVO		= null;
	 
	private OndockRailChargeInvoiceCommonVO 	ondockRailChargeInvoiceCommonVO 	= null;
	private OndockRailChargeInvoiceCommonVO[] 	ondockRailChargeInvoiceCommonVOs 	= null;
	
	/**
	 * @return the tesTmlSoCntrListVO
	 */
	public TesTmlSoCntrListVO getTesTmlSoCntrListVO() {
		return tesTmlSoCntrListVO;
	}
	/**
	 * @param tesTmlSoCntrListVO the tesTmlSoCntrListVO to set
	 */
	public void setTesTmlSoCntrListVO(TesTmlSoCntrListVO tesTmlSoCntrListVO) {
		this.tesTmlSoCntrListVO = tesTmlSoCntrListVO;
	}
	/**
	 * @return the tesTmlSoCntrListVOs
	 */
	public TesTmlSoCntrListVO[] getTesTmlSoCntrListVOs() {
		TesTmlSoCntrListVO[] rtnVOs = null;
		if (this.tesTmlSoCntrListVOs != null) {
			rtnVOs = Arrays.copyOf(tesTmlSoCntrListVOs, tesTmlSoCntrListVOs.length);
		}
		return rtnVOs;
	}
	/**
	 * @param tesTmlSoCntrListVOs the tesTmlSoCntrListVOs to set
	 */
	public void setTesTmlSoCntrListVOs(TesTmlSoCntrListVO[] tesTmlSoCntrListVOs){
		if(tesTmlSoCntrListVOs != null){
			TesTmlSoCntrListVO[] tmpVOs = Arrays.copyOf(tesTmlSoCntrListVOs, tesTmlSoCntrListVOs.length);
			this.tesTmlSoCntrListVOs = tmpVOs;
		}
	}
	/**
	 * @return the ondockRailChargeInvoiceCommonVO
	 */
	public OndockRailChargeInvoiceCommonVO getOndockRailChargeInvoiceCommonVO() {
		return ondockRailChargeInvoiceCommonVO;
	}
	/**
	 * @param ondockRailChargeInvoiceCommonVO the ondockRailChargeInvoiceCommonVO to set
	 */
	public void setOndockRailChargeInvoiceCommonVO(
			OndockRailChargeInvoiceCommonVO ondockRailChargeInvoiceCommonVO) {
		this.ondockRailChargeInvoiceCommonVO = ondockRailChargeInvoiceCommonVO;
	}
	/**
	 * @return the tesTmlSoDtlVO
	 */
	public TesTmlSoDtlVO getTesTmlSoDtlVO() {
		return tesTmlSoDtlVO;
	}
	/**
	 * @param tesTmlSoDtlVO the tesTmlSoDtlVO to set
	 */
	public void setTesTmlSoDtlVO(TesTmlSoDtlVO tesTmlSoDtlVO) {
		this.tesTmlSoDtlVO = tesTmlSoDtlVO;
	}
	/**
	 * @return the ondockRailChargeInvoiceCommonVOs
	 */
	public OndockRailChargeInvoiceCommonVO[] getOndockRailChargeInvoiceCommonVOs() {
		OndockRailChargeInvoiceCommonVO[] rtnVOs = null;
		if (this.ondockRailChargeInvoiceCommonVOs != null) {
			rtnVOs = Arrays.copyOf(ondockRailChargeInvoiceCommonVOs, ondockRailChargeInvoiceCommonVOs.length);
		}
		return rtnVOs;
	}
	/**
	 * @param ondockRailChargeInvoiceCommonVOs the ondockRailChargeInvoiceCommonVOs to set
	 */
	public void setOndockRailChargeInvoiceCommonVOs(OndockRailChargeInvoiceCommonVO[] ondockRailChargeInvoiceCommonVOs){
		if(ondockRailChargeInvoiceCommonVOs != null){
			OndockRailChargeInvoiceCommonVO[] tmpVOs = Arrays.copyOf(ondockRailChargeInvoiceCommonVOs, ondockRailChargeInvoiceCommonVOs.length);
			this.ondockRailChargeInvoiceCommonVOs = tmpVOs;
		}
	}
	
	

//	/** param용 HashMap */
//	private HashMap param_map = null;
//
//	private TES_TML_SO_CNTR_LIST tes_tml_so_cntr_list = null;
//
//	private Collection tes_tml_so_cntr_lists = null;
//
//	public EsdTes9031Event(){}
//
//	public EsdTes9031Event(HashMap param_map) {
//		this.param_map = param_map;
//    }
//
//	public EsdTes9031Event(Collection tes_tml_so_cntr_lists, HashMap param_map){
//		this.tes_tml_so_cntr_lists = tes_tml_so_cntr_lists;
//		this.param_map = param_map;
//	}
//
//
//	public Collection getTES_TML_SO_CNTR_LISTS(){
//		return tes_tml_so_cntr_lists;
//	}
//
//	public TES_TML_SO_CNTR_LIST getTES_TML_SO_CNTR_LIST(){
//		return tes_tml_so_cntr_list;
//	}
//
//	public HashMap getParams(){
//		return param_map;
//	}

}
