/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0947Event.java
*@FileTitle : Customs Result Code
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.07.20 이수빈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.event;

import java.util.Arrays;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.DispoCdDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.DispoCdListCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0947 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0947HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Subin
 * @see ESM_BKG_0947HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0947Event extends EventSupport {

    private static final long serialVersionUID = 1L;

    /** 조회 조건 및 단건 처리  */
    private DispoCdListCondVO dispoCdListCondVO = null;

    /** 저장 처리 */
    private DispoCdDetailVO[] dispoCdDetailVOs = null;


    public EsmBkg0947Event(){}


	/**
	 * @return the dispoCdListCondVO
	 */
	public DispoCdListCondVO getDispoCdListCondVO() {
		return dispoCdListCondVO;
	}


	/**
	 * @param dispoCdListCondVO the dispoCdListCondVO to set
	 */
	public void setDispoCdListCondVO(DispoCdListCondVO dispoCdListCondVO) {
		this.dispoCdListCondVO = dispoCdListCondVO;
	}


	/**
	 * @return the dispoCdDetailVOs
	 */
	public DispoCdDetailVO[] getDispoCdDetailVOs() {
		DispoCdDetailVO[] rtnVOs = null;
		if (this.dispoCdDetailVOs != null) {
			rtnVOs = Arrays.copyOf(dispoCdDetailVOs, dispoCdDetailVOs.length);
		}
		return rtnVOs;
	}


	/**
	 * @param dispoCdDetailVOs the dispoCdDetailVOs to set
	 */
	public void setDispoCdDetailVOs(DispoCdDetailVO[] dispoCdDetailVOs){
		if(dispoCdDetailVOs != null){
			DispoCdDetailVO[] tmpVOs = Arrays.copyOf(dispoCdDetailVOs, dispoCdDetailVOs.length);
			this.dispoCdDetailVOs = tmpVOs;
		}
	}

    

}