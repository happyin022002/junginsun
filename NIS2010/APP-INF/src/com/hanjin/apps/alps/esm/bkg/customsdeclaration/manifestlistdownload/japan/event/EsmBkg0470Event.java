/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0457Event.java
*@FileTitle : ESM_BKG-0457
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.06.02 김승민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanVesselArrivalTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanVesselArrivalCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanVesselArrivalVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG-0457 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-0457HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM SEUNG MIN
 * @see ESM_BKG-0457HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0470Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private JapanVesselArrivalCondVO japanVesselArrivalCondVO = null; 	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private JapanVesselArrivalVO japanVesselArrivalVO = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private JapanVesselArrivalTransmitVO japanVesselArrivalTransmitVO = null;
	
	public EsmBkg0470Event(){} 
	
	public void setJapanVesselArrivalCondVO(JapanVesselArrivalCondVO japanVesselArrivalCondVO){
		this.japanVesselArrivalCondVO = japanVesselArrivalCondVO;
	}	
	 
	public JapanVesselArrivalCondVO getJapanVesselArrivalCondVO(){
		return japanVesselArrivalCondVO;
	}
	
	public void setJapanVesselArrivalVO(JapanVesselArrivalVO japanVesselArrivalVO){
		this.japanVesselArrivalVO = japanVesselArrivalVO;
	}	
	 
	public JapanVesselArrivalVO getJapanVesselArrivalVO(){
		return japanVesselArrivalVO;
	}
	
	public void setJapanVesselArrivalTransmitVO(JapanVesselArrivalTransmitVO japanVesselArrivalTransmitVO){
		this.japanVesselArrivalTransmitVO = japanVesselArrivalTransmitVO;
	}	
	 
	public JapanVesselArrivalTransmitVO getJapanVesselArrivalTransmitVO(){
		return japanVesselArrivalTransmitVO;	
	}
}
