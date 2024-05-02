/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CpsCni0403Event.java
*@FileTitle : Vessel Status Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.13
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.11.13 윤세영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.insurance.vesselstatus.event;

import com.clt.apps.opus.cps.cni.insurance.vesselstatus.vo.CondSearchVesselStatusListVO;
import com.clt.apps.opus.cps.cni.insurance.vesselstatus.vo.CustomVesselStatusVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * CPS_CNI_0403 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  CPS_CNI_0403HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Yoon, Seyeong
 * @see CPS_CNI_0403HTMLAction 참조
 * @since J2EE 1.6
 */

public class CpsCni0403Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CondSearchVesselStatusListVO condSearchVesselStatusListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomVesselStatusVO[] customVesselStatusVOs = null;
	
	/** Vessel Code */
	private String vslCd  = "";
	
	/** Country Flag */
	private String flag = "";

	public CpsCni0403Event(){}
	
	public void setCondSearchVesselStatusListVO(CondSearchVesselStatusListVO condSearchVesselStatusListVO){
		this. condSearchVesselStatusListVO = condSearchVesselStatusListVO;
	}

	public void setCustomVesselStatusVOS(CustomVesselStatusVO[] customVesselStatusVOs){
		if(customVesselStatusVOs != null){
			CustomVesselStatusVO[] tmpVOs = java.util.Arrays.copyOf(customVesselStatusVOs, customVesselStatusVOs.length);
			this.customVesselStatusVOs = tmpVOs;
		}
	}

	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public CondSearchVesselStatusListVO getCondSearchVesselStatusListVO(){
		return condSearchVesselStatusListVO;
	}

	public CustomVesselStatusVO[] getCustomVesselStatusVOS(){
		CustomVesselStatusVO[] rtnVOs = null;
		if (this.customVesselStatusVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(customVesselStatusVOs, customVesselStatusVOs.length);
		}
		return rtnVOs;
	}
	
	public String getVslCd() {
		return vslCd;
	}
	
	public String getFlag() {
		return flag;
	}

}