/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0203Event.java
*@FileTitle : Tire Purchase Report by Supplier
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.10.05 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.TirePurcharseBySupplierINVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.TirePurcharseBySupplierVO;


/**
 * EES_MNR_0203 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MNR_0203HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Ho Min
 * @see EES_MNR_0203HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMnr0203Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TirePurcharseBySupplierINVO tirePurcharseBySupplierINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TirePurcharseBySupplierVO[] tirePurcharseBySupplierVOs = null;

	public EesMnr0203Event(){}
	
	public void setTirePurcharseBySupplierINVO(TirePurcharseBySupplierINVO tirePurcharseBySupplierINVO){
		this. tirePurcharseBySupplierINVO = tirePurcharseBySupplierINVO;
	}

	public void setTirePurcharseBySupplierVOS(TirePurcharseBySupplierVO[] tirePurcharseBySupplierVOs){
		this. tirePurcharseBySupplierVOs = tirePurcharseBySupplierVOs;
	}

	public TirePurcharseBySupplierINVO getTirePurcharseBySupplierINVO(){
		return tirePurcharseBySupplierINVO;
	}

	public TirePurcharseBySupplierVO[] getTirePurcharseBySupplierVOS(){
		return tirePurcharseBySupplierVOs;
	}

}