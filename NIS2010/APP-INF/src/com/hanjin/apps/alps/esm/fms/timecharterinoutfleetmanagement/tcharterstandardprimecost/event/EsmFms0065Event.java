/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0062Event.java
*@FileTitle : TEU Range Target
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.15
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.04.15 최우석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedProRevenueListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.vo.CustomMktRtVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0065 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0065HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Woo-Seok
 * @see ESM_FMS_0065HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmFms0065Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomMktRtVO customMktRtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomMktRtVO[] customMktRtVOs = null;
	
	private String mktRtYrmon =  "";

	public EsmFms0065Event(){}
	
	public void setCustomMktRtVO(CustomMktRtVO customMktRtVO){
		this. customMktRtVO = customMktRtVO;
	}

	public void setCustomMktRtVOS(CustomMktRtVO[] customMktRtVOs){
		if (customMktRtVOs != null) {
			CustomMktRtVO[] tmpVOs = Arrays.copyOf(customMktRtVOs, customMktRtVOs.length);
			this.customMktRtVOs = tmpVOs;
		}
	}
	
	public void setMktRtYrmon(String mktRtYrmon){
		this. mktRtYrmon = mktRtYrmon;
	}

	public CustomMktRtVO getCustomMktRtVO(){
		return customMktRtVO;
	}

	public CustomMktRtVO[] getCustomMktRtVOS(){
		CustomMktRtVO[] rtnVOs = null;
		if (this.customMktRtVOs != null) {
			rtnVOs = Arrays.copyOf(customMktRtVOs, customMktRtVOs.length);
		}
		return rtnVOs;
	}
	
	public String getMktRtYrmon(){
		return mktRtYrmon;
	}

}