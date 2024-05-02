/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiFms00541Event.java
*@FileTitle : D/dock Schedule Input
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.04.24 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.event;

import java.util.Arrays;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedProRevenueListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.vo.CustomDckSkdVO;


/**
 * ESM_FMS_0054-1 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0054-1HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Yoon Seyeong
 * @see ESM_FMS_0054-1HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmFms00541Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** vslCd Vessel Code */
	private String vslCd = "";
	
	/** dckSelCd Dock Selection Code */
	private String dckSelCd = "";
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomDckSkdVO customdckskdvo = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomDckSkdVO[] customdckskdvos = null;

	public EsmFms00541Event(){}
	
	public void setCustomDckSkdVO(CustomDckSkdVO customdckskdvo){
		this. customdckskdvo = customdckskdvo;
	}

	public void setCustomDckSkdVOS(CustomDckSkdVO[] customdckskdvos){
		if (customdckskdvos != null) {
			CustomDckSkdVO[] tmpVOs = Arrays.copyOf(customdckskdvos, customdckskdvos.length);
			this.customdckskdvos = tmpVOs;
		}
	}

	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}

	public void setDckSelCd(String dckSelCd) {
		this.dckSelCd = dckSelCd;
	}

	public CustomDckSkdVO getCustomDckSkdVO(){
		return customdckskdvo;
	}

	public CustomDckSkdVO[] getCustomDckSkdVOS(){
		CustomDckSkdVO[] rtnVOs = null;
		if (this.customdckskdvos != null) {
			rtnVOs = Arrays.copyOf(customdckskdvos, customdckskdvos.length);
		}
		return rtnVOs;
	}
	
	public String getVslCd() {
		return vslCd;
	}
	
	public String getDckSelCd() {
		return dckSelCd;
	}

}