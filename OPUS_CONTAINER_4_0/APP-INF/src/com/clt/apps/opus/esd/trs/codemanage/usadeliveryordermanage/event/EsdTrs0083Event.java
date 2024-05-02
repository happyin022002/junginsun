/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_083Event.java
*@FileTitle : USA Delivery Order Manage
*Open Issues :
*Change history :
*@LastModifyDate : 2008-10-20
*@LastModifier : poong yeon cho
*@LastVersion : 1.0
* 2008-10-20 poong yeon cho
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.usadeliveryordermanage.event;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

import com.clt.apps.opus.esd.trs.codemanage.usadeliveryordermanage.vo.UsaDeliveryOrderManageVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.TrsTrspUsaDoDtlVO;
import com.clt.syscommon.common.table.TrsTrspUsaDoHdrVO;


/**
 * ESD_TRS_083 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_083HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author poong yeon cho
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0083Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	/** trs_trsp_usa_do Table  Value Object */
	private UsaDeliveryOrderManageVO usaDeliveryOrderManageVO =  null;
	private TrsTrspUsaDoHdrVO trsTrspUsaDoHdrVO = null;
	private TrsTrspUsaDoDtlVO trsTrspUsaDoDtlVO = null;
 
	/** trs_trsp_usa_dos Multi Action을 위한 Collection */
	private UsaDeliveryOrderManageVO[] usaDeliveryOrderManageVOs =  null;
	private TrsTrspUsaDoHdrVO[] trsTrspUsaDoHdrVOs = null;
	private TrsTrspUsaDoDtlVO[] trsTrspUsaDoDtlVOs = null;
	
	/** trs_trsp_usa_dos Multi Action을 위한 Collection */ // 수정되지 않는 메소드에 오류 발생하여 남겨둠. converting 완료 후엔 삭제하기 kys
	private Collection trsTrspUsaDoHdrs = null;
	private Collection trsTrspUsaDoDtls = null;
	private String formCreUsrId = null;
	private String formUsrOfcCd = null;
	
	/** select 변수 (Form 객체) */
	private HashMap hashParam = new HashMap();
	
	public EsdTrs0083Event(){}

	/** getHashParam */
	public HashMap getHashParam() {
		return hashParam;
	}
	
	/** setHashParam */
	public void setHashParam(HashMap hashParamValue){
		this.hashParam = hashParamValue;
	}	

	/**
	 * @return the usaDeliveryOrderManageVO
	 */
	public UsaDeliveryOrderManageVO getUsaDeliveryOrderManageVO() {
		return usaDeliveryOrderManageVO;
	}

	/**
	 * @param usaDeliveryOrderManageVO the usaDeliveryOrderManageVO to set
	 */
	public void setUsaDeliveryOrderManageVO(
			UsaDeliveryOrderManageVO usaDeliveryOrderManageVO) {
		this.usaDeliveryOrderManageVO = usaDeliveryOrderManageVO;
	}

	public String toString() {
		return "EsdTrs0083Event";
	}

	/**
	 * @return the trsTrspUsaDoHdrVO
	 */
	public TrsTrspUsaDoHdrVO getTrsTrspUsaDoHdrVO() {
		return trsTrspUsaDoHdrVO;
	}

	/**
	 * @param trsTrspUsaDoHdrVO the trsTrspUsaDoHdrVO to set
	 */
	public void setTrsTrspUsaDoHdrVO(TrsTrspUsaDoHdrVO trsTrspUsaDoHdrVO) {
		this.trsTrspUsaDoHdrVO = trsTrspUsaDoHdrVO;
	}

	/**
	 * @return the trsTrspUsaDoDtlVO
	 */
	public TrsTrspUsaDoDtlVO getTrsTrspUsaDoDtlVO() {
		return trsTrspUsaDoDtlVO;
	}

	/**
	 * @param trsTrspUsaDoDtlVO the trsTrspUsaDoDtlVO to set
	 */
	public void setTrsTrspUsaDoDtlVO(TrsTrspUsaDoDtlVO trsTrspUsaDoDtlVO) {
		this.trsTrspUsaDoDtlVO = trsTrspUsaDoDtlVO;
	}

	/**
	 * @return the usaDeliveryOrderManageVOs
	 */
	public UsaDeliveryOrderManageVO[] getUsaDeliveryOrderManageVOs() {
		UsaDeliveryOrderManageVO[] rtnVOs = null;
		if (this.usaDeliveryOrderManageVOs != null) {
			rtnVOs = Arrays.copyOf(usaDeliveryOrderManageVOs, usaDeliveryOrderManageVOs.length);
		} // end if
		return rtnVOs;
	}

	/**
	 * @param usaDeliveryOrderManageVOs the usaDeliveryOrderManageVOs to set
	 */
	public void setUsaDeliveryOrderManageVOs(
			UsaDeliveryOrderManageVO[] usaDeliveryOrderManageVOs) {
		if (usaDeliveryOrderManageVOs != null) {
			UsaDeliveryOrderManageVO[] tmpVOs = Arrays.copyOf(usaDeliveryOrderManageVOs, usaDeliveryOrderManageVOs.length);
			this.usaDeliveryOrderManageVOs = tmpVOs;
		} // end if
	}

	/**
	 * @return the trsTrspUsaDoHdrVOs
	 */
	public TrsTrspUsaDoHdrVO[] getTrsTrspUsaDoHdrVOs() {
		TrsTrspUsaDoHdrVO[] rtnVOs = null;
		if (this.trsTrspUsaDoHdrVOs != null) {
			rtnVOs = Arrays.copyOf(trsTrspUsaDoHdrVOs, trsTrspUsaDoHdrVOs.length);
		} // end if
		return rtnVOs;
	}

	/**
	 * @param trsTrspUsaDoHdrVOs the trsTrspUsaDoHdrVOs to set
	 */
	public void setTrsTrspUsaDoHdrVOs(TrsTrspUsaDoHdrVO[] trsTrspUsaDoHdrVOs) {
		if (trsTrspUsaDoHdrVOs != null) {
			TrsTrspUsaDoHdrVO[] tmpVOs = Arrays.copyOf(trsTrspUsaDoHdrVOs, trsTrspUsaDoHdrVOs.length);
			this.trsTrspUsaDoHdrVOs = tmpVOs;
		} // end if
	}

	/**
	 * @return the trsTrspUsaDoDtlVOs
	 */
	public TrsTrspUsaDoDtlVO[] getTrsTrspUsaDoDtlVOs() {
		TrsTrspUsaDoDtlVO[] rtnVOs = null;
		if (this.trsTrspUsaDoDtlVOs != null) {
			rtnVOs = Arrays.copyOf(trsTrspUsaDoDtlVOs, trsTrspUsaDoDtlVOs.length);
		} // end if
		return rtnVOs;
	}

	/**
	 * @param trsTrspUsaDoDtlVOs the trsTrspUsaDoDtlVOs to set
	 */
	public void setTrsTrspUsaDoDtlVOs(TrsTrspUsaDoDtlVO[] trsTrspUsaDoDtlVOs) {
		if (trsTrspUsaDoDtlVOs != null) {
			TrsTrspUsaDoDtlVO[] tmpVOs = Arrays.copyOf(trsTrspUsaDoDtlVOs, trsTrspUsaDoDtlVOs.length);
			this.trsTrspUsaDoDtlVOs = tmpVOs;
		} // end if
	}
	
	/**
	 * @return the trsTrspUsaDoHdrs
	 */
	public Collection getTRS_TRSP_USA_DO_HDRS() {
		return trsTrspUsaDoHdrs;
	}

	/**
	 * @param trsTrspUsaDoHdrs the trsTrspUsaDoHdrs to set
	 */
	public void setTRS_TRSP_USA_DO_HDRS(Collection trsTrspUsaDoHdrs) {
		this.trsTrspUsaDoHdrs = trsTrspUsaDoHdrs;
	}

	/**
	 * @return the trsTrspUsaDoDtls
	 */
	public Collection getTRS_TRSP_USA_DO_DTLS() {
		return trsTrspUsaDoDtls;
	}

	/**
	 * @param trsTrspUsaDoDtls the trsTrspUsaDoDtls to set
	 */
	public void setTRS_TRSP_USA_DO_DTLS(Collection trsTrspUsaDoDtls) {
		this.trsTrspUsaDoDtls = trsTrspUsaDoDtls;
	}

	public String getEventName() {
		return "EsdTrs0083Event";
	}

	public void setForm_cre_usr_id(String formCreUsrId) {
		this.formCreUsrId = formCreUsrId;
	}

	public String getForm_cre_usr_id() {
		return formCreUsrId;
	}

	public void setForm_usr_ofc_cd(String formUsrOfcCd) {
		this.formUsrOfcCd = formUsrOfcCd;
	}

	public String getForm_usr_ofc_cd() {
		return formUsrOfcCd;
	}
}