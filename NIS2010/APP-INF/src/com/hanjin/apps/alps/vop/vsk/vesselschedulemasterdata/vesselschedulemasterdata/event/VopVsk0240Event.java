/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0240Event.java
*@FileTitle : Service Provider Group Registration (Pop-up)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.08.24 서창열
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.event;

import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdGRPVO;
import com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo.CanalAgencyLaneVO;
import com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo.CanelRegistGRPVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VendorVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * VOP_VSK_0240 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0240HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SEO CHANG YUL
 * @see VOP_VSK_0240HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopVsk0240Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VendorVO vendorVO = null;
	private CanalAgencyLaneVO canalAgencyLaneVO = null;
	private CanelRegistGRPVO canelRegistGRPVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private VendorVO[] vendorVOs = null;
	private CanalAgencyLaneVO[] canalAgencyLaneVOs = null;

	public VopVsk0240Event(){}
	
	public void setVendorVO(VendorVO vendorVO){
		this. vendorVO = vendorVO;
	}
	
	public void setCanalAgencyLaneVO(CanalAgencyLaneVO canalAgencyLaneVO){
		this. canalAgencyLaneVO = canalAgencyLaneVO;
	}

	public void setVendorVOS(VendorVO[] vendorVOs){
		if(vendorVOs != null){
			VendorVO[] tmpVOs = new VendorVO[vendorVOs.length];
			System.arraycopy(vendorVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vendorVOs = tmpVOs;
		}
		//소스보안 2015.07.20
		//this. vendorVOs = vendorVOs;
	}
	
	public void setCanalAgencyLaneVOS(CanalAgencyLaneVO[] canalAgencyLaneVOs){
		if(canalAgencyLaneVOs != null){
			CanalAgencyLaneVO[] tmpVOs = new CanalAgencyLaneVO[canalAgencyLaneVOs.length];
			System.arraycopy(canalAgencyLaneVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.canalAgencyLaneVOs = tmpVOs;
		}
		//소스보안 2015.07.20
		//this. canalAgencyLaneVOs = canalAgencyLaneVOs;
	}
	
	public void setCanelRegistGRPVO(CanelRegistGRPVO canelRegistGRPVO){
		this.canelRegistGRPVO = canelRegistGRPVO;
	}

	public VendorVO getVendorVO(){
		return vendorVO;
	}
	
	public CanalAgencyLaneVO getCanalAgencyLaneVO(){
		return canalAgencyLaneVO;
	}

	public VendorVO[] getVendorVOS(){
		VendorVO[] rtnVOs =  null;
		if(this.vendorVOs != null){
			rtnVOs = new VendorVO[vendorVOs.length];
			System.arraycopy(vendorVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.20
		//return vendorVOs;
	}
	
	public CanalAgencyLaneVO[] getCanalAgencyLaneVOS(){
		CanalAgencyLaneVO[] rtnVOs =  null;
		if(this.canalAgencyLaneVOs != null){
			rtnVOs = new CanalAgencyLaneVO[canalAgencyLaneVOs.length];
			System.arraycopy(canalAgencyLaneVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.20
		//return canalAgencyLaneVOs;
	}
	
	public CanelRegistGRPVO getCanelRegistGRPVO(){
		return canelRegistGRPVO;
	}

}