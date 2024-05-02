/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0533Event.java
*@FileTitle : Generate Arrival Manifest by Container
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.07.20 김도완
* 1.0 Creation
* -----------------------------------------------------
* History
* 2012.05.10 김보배 [CHM-201217461] [BKG] [ACE M1] US AMS 전송후 1J 이후 Diversion 요청 기능 추가
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.event;

import java.util.Arrays;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.UsaInbondDataVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.UsaInbondManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.UsaMibTransmitVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0533 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0533HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Dowan
 * @see ESM_BKG_0533HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0533Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	

	/** Table Value Object 조회 조건  */
	private UsaInbondManifestListCondVO usaInbondManifestListCondVO = null;
	
	/** Table Value Object 단건 처리  */
	private UsaInbondDataVO usaInbondManifestDetailVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private UsaInbondDataVO[] usaInbondManifestDetailVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private UsaMibTransmitVO[] usaMibTransmitVOs = null;

	/** backEndJob key. */
	private String key = "";
	
	public EsmBkg0533Event(){}
	
	public void setUsaInbondManifestListCondVO(UsaInbondManifestListCondVO usaInbondManifestListCondVO){
		this. usaInbondManifestListCondVO = usaInbondManifestListCondVO;
	}
	
	public void setUsaInbondManifestDetailVO(UsaInbondDataVO usaInbondManifestDetailVO){
		this. usaInbondManifestDetailVO = usaInbondManifestDetailVO;
	}

	public void setUsaInbondManifestDetailVOS(UsaInbondDataVO[] usaInbondManifestDetailVOs){
		if(usaInbondManifestDetailVOs != null){
			UsaInbondDataVO[] tmpVOs = Arrays.copyOf(usaInbondManifestDetailVOs, usaInbondManifestDetailVOs.length);
			this.usaInbondManifestDetailVOs = tmpVOs;
		}
	}
	
	public void setUsaMibTransmitVOS(UsaMibTransmitVO[] usaMibTransmitVOs){
		if(usaMibTransmitVOs != null){
			UsaMibTransmitVO[] tmpVOs = Arrays.copyOf(usaMibTransmitVOs, usaMibTransmitVOs.length);
			this.usaMibTransmitVOs = tmpVOs;
		}
	}

	public UsaInbondManifestListCondVO getUsaInbondManifestListCondVO(){
		return usaInbondManifestListCondVO;
	}

	public UsaInbondDataVO getUsaInbondManifestDetailVO(){
		return usaInbondManifestDetailVO;
	}

	public UsaInbondDataVO[] getUsaInbondManifestDetailVOS(){
		UsaInbondDataVO[] rtnVOs = null;
		if (this.usaInbondManifestDetailVOs != null) {
			rtnVOs = Arrays.copyOf(usaInbondManifestDetailVOs, usaInbondManifestDetailVOs.length);
		}
		return rtnVOs;
	}
	
	public UsaMibTransmitVO[] getUsaMibTransmitVOS(){
		UsaMibTransmitVO[] rtnVOs = null;
		if (this.usaMibTransmitVOs != null) {
			rtnVOs = Arrays.copyOf(usaMibTransmitVOs, usaMibTransmitVOs.length);
		}
		return rtnVOs;
	}
	
	public void setUsaMibTransmitGubuns(String transGubun){
		for(int i = 0; i < usaMibTransmitVOs.length; i++){
			usaMibTransmitVOs[i].setTransGubun(transGubun);
		}
	}
	
	public void setUsaMibDivInd(String divInd){
		for(int i = 0; i < usaMibTransmitVOs.length; i++){
			usaMibTransmitVOs[i].setDivInd(divInd);
		}
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public String getKey() {
		return key;
	}	
}