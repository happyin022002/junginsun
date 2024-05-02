/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0077Event.java
*@FileTitle : Booking Copy
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.09.09 김병규
* 1.0 Creation
 * ------------------------------------------------------
 * HISTORY
 * 2010.11.04 김영철 [] Booking Creation / Update / Cancel시, Vessel Operation 모듈의 Final CBF 생성 여부를 체크해서 경고 메시지
=========================================================*/ 
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.BlckKwListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0077 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0077HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KimByungKyu
 * @see ESM_BKG_0077HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0325Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private String blckKwTpCd = null;
	private BlckKwListVO blckKwListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BlckKwListVO[] blckKwListVOs = null;	

	public EsmBkg0325Event(){}
	
	public void setBlckKwListVO(BlckKwListVO blckKwListVO){
		this. blckKwListVO = blckKwListVO;
	}

	public BlckKwListVO getBlckKwListVO(){
		return blckKwListVO;
	}

	public void setBlckKwListVOs(BlckKwListVO[] blckKwListVOs){
		if(blckKwListVOs != null){
			BlckKwListVO[] tmpVOs = new BlckKwListVO[blckKwListVOs.length];
			System.arraycopy(blckKwListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.blckKwListVOs = tmpVOs;
		}
	}

	public BlckKwListVO[] getBlckKwListVOs(){
		BlckKwListVO[] rtnVOs = null;
		if (this.blckKwListVOs != null) {
			rtnVOs = new BlckKwListVO[blckKwListVOs.length];
			System.arraycopy(blckKwListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	/**
	 * @return blckKwTpCd
	 */
	public String getBlckKwTpCd() {
		return blckKwTpCd;
	}

	public void setBlckKwTpCd(String blckKwTpCd) {
		this.blckKwTpCd = blckKwTpCd;
	}
	
	
}