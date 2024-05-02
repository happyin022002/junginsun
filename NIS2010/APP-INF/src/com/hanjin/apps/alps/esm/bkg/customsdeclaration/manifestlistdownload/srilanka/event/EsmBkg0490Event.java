/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0490Event.java
*@FileTitle : ESM_BKG-0490
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.04.21 임재택
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.srilanka.vo.SriLankaManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaManifestListCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG-0490 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-0490HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author LIM JAE TAEK
 * @see ESM_BKG-0490HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0490Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SriLankaManifestListCondVO sriLankaManifestListCondVO = null; 
	
	/** Table Value Object Multi Data 처리 */
	private SriLankaManifestListCondVO[] sriLankaManifestListCondVOs = null;
	private SriLankaManifestTransmitVO[] sriLankaManifestTransmitVOs = null;
	 
	private String vslcd = null;  
	private String skdvoyno = null;  
	private String skddircd = null;  	 
	private String vslnm = null;
	private String pgno = null;
	
	public EsmBkg0490Event(){}
	
	public String getVsl_cd() {
		return vslcd;
	}
	public String getPgNo() {
		return pgno;
	}

	public String getVsl_Nm() {
		return vslnm;
	}

	public void setVsl_Nm(String vslnm) {
		this.vslnm = vslnm;
	}
 
	public void setPgNO(String pgno) {
		this.pgno = pgno;
	}
	public void setVsl_cd(String vslcd) {
		this.vslcd = vslcd;
	}


	public String getSkd_voy_no() {
		return skdvoyno;
	}

	public void setSkd_voy_no(String skdvoyno) {
		this.skdvoyno = skdvoyno;
	}

	public String getSkd_dir_cd() {
		return skddircd;
	}

	public void setSkd_dir_cd(String skddircd) {
		this.skddircd = skddircd;
	}
	 
	public SriLankaManifestListCondVO getSriLankaManifestListCondVO(){
		return sriLankaManifestListCondVO;
	}
	public void setSriLankaManifestListCondVO(SriLankaManifestListCondVO sriLankaManifestListCondVO){
		this. sriLankaManifestListCondVO = sriLankaManifestListCondVO;
	}
	public SriLankaManifestListCondVO[] getSriLankaManifestListCondVOS(){
		return sriLankaManifestListCondVOs;
	}
	public void setSriLankaManifestListCondVOS(SriLankaManifestListCondVO[] sriLankaManifestListCondVOs){
		this. sriLankaManifestListCondVOs = sriLankaManifestListCondVOs;
	}
	public void setSriLankaManifestTransmitVOS(SriLankaManifestTransmitVO[] srilankaManifestTransmitVOs){
		this. sriLankaManifestTransmitVOs = srilankaManifestTransmitVOs;
	}
	public SriLankaManifestTransmitVO[] getSrilankaManifestTransmitVOs(){
		return sriLankaManifestTransmitVOs;
	}
	 
}