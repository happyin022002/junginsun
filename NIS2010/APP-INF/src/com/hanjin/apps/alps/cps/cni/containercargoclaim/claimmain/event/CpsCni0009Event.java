/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsCni0009Event.java
 *@FileTitle : Find
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.05
 *@LastModifier : 양정란
 *@LastVersion : 1.0
 * 2009.10.05 양정란 
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.event;


import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmCostVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.HandlingCostVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * [CPS_CNI_0009] Handling Costs
 * @author 양정란 
 * @see CPS_CNI_0009HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsCni0009Event extends EventSupport {

	private static final long serialVersionUID = 1L;
    
    private String cgoClmNo;

    /* VO */
    private HandlingCostVO handlingCostVO;
    
    /** Table Value Object Multi Data 처리 */
	private CniCgoClmCostVO[] cniCgoClmCostVOs = null;

	public String getCgoClmNo() {
		return cgoClmNo;
	}

	public void setCgoClmNo(String cgoClmNo) {
		this.cgoClmNo = cgoClmNo;
	}

	public HandlingCostVO getHandlingCostVO() {
		return handlingCostVO;
	}

	public void setHandlingCostVO(HandlingCostVO handlingCostVO) {
		this.handlingCostVO = handlingCostVO;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public CniCgoClmCostVO[] getCniCgoClmCostVOs() {
		return cniCgoClmCostVOs;
	}

	public void setCniCgoClmCostVOs(CniCgoClmCostVO[] cniCgoClmCostVOs) {
		this.cniCgoClmCostVOs = cniCgoClmCostVOs;
	}

   }