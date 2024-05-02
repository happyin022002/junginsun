/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0631Event.java
*@FileTitle : RBC Vessel Status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2009.08.26 김태경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.RbcvesselVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0631 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0631HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kim tae kyoung
 * @see ESM_BKG_0631HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0631Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RbcvesselVO rbcvesselVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RbcvesselVO[] rbcvesselVOs = null;
	
	private String fromDt = null;
	private String toDt   = null;

	public EsmBkg0631Event(){}
	
	public void setRbcvesselVO(RbcvesselVO rbcvesselVO){
		this. rbcvesselVO = rbcvesselVO;
	}

	public void setRbcvesselVOS(RbcvesselVO[] rbcvesselVOs){
		if(rbcvesselVOs != null){
			RbcvesselVO[] tmpVOs = Arrays.copyOf(rbcvesselVOs, rbcvesselVOs.length);
			this.rbcvesselVOs = tmpVOs;
		}
	}

	public RbcvesselVO getRbcvesselVO(){
		return rbcvesselVO;
	}

	public RbcvesselVO[] getRbcvesselVOS(){
		RbcvesselVO[] rtnVOs = null;
		if(this.rbcvesselVOs != null){
			rtnVOs= Arrays.copyOf(rbcvesselVOs, rbcvesselVOs.length);
		}
		return rtnVOs;
	}

	public void setFromDt(String fromDt){
		this.fromDt = fromDt;
	}	
	public void setToDt(String toDt){
		this.toDt = toDt;
	}
	public String getFromDt(){
		return fromDt;
	}
	public String getToDt(){
		return toDt;
	}
	
}