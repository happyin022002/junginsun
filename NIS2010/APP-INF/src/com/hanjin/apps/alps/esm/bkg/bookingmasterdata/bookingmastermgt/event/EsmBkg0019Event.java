/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0019Event.java
*@FileTitle : Vessel SKD & Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.05.13 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.VskVslPortSkdConditionVO;


/**
 * esm_bkg_0019 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  esm_bkg_0019HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Jong
 * @see esm_bkg_0019HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0019Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VskVslPortSkdConditionVO vskVslPortSkdConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private VskVslPortSkdConditionVO[] vskVslPortSkdConditionVOs = null;

	public EsmBkg0019Event(){}
	
	public void setVskVslPortSkdConditionVO(VskVslPortSkdConditionVO vskVslPortSkdConditionVO){
		this. vskVslPortSkdConditionVO = vskVslPortSkdConditionVO;
	}

	public void setVskVslPortSkdConditionVOS(VskVslPortSkdConditionVO[] vskVslPortSkdConditionVOs){
		this. vskVslPortSkdConditionVOs = vskVslPortSkdConditionVOs;
	}

	public VskVslPortSkdConditionVO getVskVslPortSkdConditionVO(){
		return vskVslPortSkdConditionVO;
	}

	public VskVslPortSkdConditionVO[] getVskVslPortSkdConditionVOS(){
		return vskVslPortSkdConditionVOs;
	}

}