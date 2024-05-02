/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : DgCgoAproRqstEvent.java
*@FileTitle : DgCgoAproRqst Event
*Open Issues :
*Change history : 2015.05.14
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.vo.FlatFilePartnerLineVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * DgCgoAproRqst Event<br>
 *
 * @author 
 * @see 
 * @since J2EE 1.6
 */
public class DgCgoAproRqstEvent extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	public DgCgoAproRqstEvent(){}
	
	public String flatFileText = null;

	/** Table Value Object 단건 처리  */
	private FlatFilePartnerLineVO flatFileVo = null;

	/** Table Value Object Multi Data 처리 */
	private FlatFilePartnerLineVO[] flatFileVOs = null;

	

	public void setFlatFileVO(FlatFilePartnerLineVO flatFileVo){
		this.flatFileVo = flatFileVo;
	}

	public void setFlatFileVOS(FlatFilePartnerLineVO[] flatFileVOs){
		if(flatFileVOs != null){
			FlatFilePartnerLineVO[] tmpVOs = Arrays.copyOf(flatFileVOs, flatFileVOs.length);
			this.flatFileVOs = tmpVOs;
		}
	}

	public FlatFilePartnerLineVO getFlatFileVO(){
		return flatFileVo;
	}

	public FlatFilePartnerLineVO[] getFlatFileVOS(){
		FlatFilePartnerLineVO[] rtnVOs = null;
		if (this.flatFileVOs != null) {
			rtnVOs = Arrays.copyOf(flatFileVOs, flatFileVOs.length);
		}
		return rtnVOs;
	}

	public void setFlatFileText(String flatFileText) {
		this.flatFileText = flatFileText;
	}

	public String getFlatFileText() {
		return flatFileText;
	}
}
