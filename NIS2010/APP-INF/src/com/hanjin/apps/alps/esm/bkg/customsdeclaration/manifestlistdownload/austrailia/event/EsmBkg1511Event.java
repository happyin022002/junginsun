/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0965Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.05.11 경종윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.event;

 
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.vo.AusBkgAndLocalDgListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.vo.AusDgListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.vo.AusDgListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.vo.AusVslInfoVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * esm_bkg_0965 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0965HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kyoung Jong Yun
 * @see ESM_BKG_0965HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg1511Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	
	private AusBkgAndLocalDgListDetailVO ausBkgAndLocalDgListDetailVO = null;
	
	private AusDgListDetailVO ausDgListDetailVO = null;
	private AusDgListDetailVO[] ausDgListDetailVOs = null;
	private AusVslInfoVO ausVslInfoVO = null;
	
	private ManifestTransmitVO[] manifestTransmitVOs = null;
	
	
	public AusBkgAndLocalDgListDetailVO getAusBkgAndLocalDgListDetailVO() {
		return ausBkgAndLocalDgListDetailVO;
	}
	public void setAusBkgAndLocalDgListDetailVO(
			AusBkgAndLocalDgListDetailVO ausBkgAndLocalDgListDetailVO) {
		this.ausBkgAndLocalDgListDetailVO = ausBkgAndLocalDgListDetailVO;
	}
	
	
	public ManifestTransmitVO[] getManifestTransmitVOs() {
		return manifestTransmitVOs;
	}
	public void setManifestTransmitVOs(ManifestTransmitVO[] manifestTransmitVOs) {
		this.manifestTransmitVOs = manifestTransmitVOs;
	}
	public AusVslInfoVO getAusVslInfoVO() {
		return ausVslInfoVO;
	}
	public void setAusVslInfoVO(AusVslInfoVO ausVslInfoVO) {
		this.ausVslInfoVO = ausVslInfoVO;
	}
	private AusDgListCondVO ausDgListCondVO = null;
	
	
	public AusDgListCondVO getAusDgListCondVO() {
		return ausDgListCondVO;
	}
	public void setAusDgListCondVO(AusDgListCondVO ausDgListCondVO) {
		this.ausDgListCondVO = ausDgListCondVO;
	}
	public AusDgListDetailVO getAusDgListDetailVO() {
		return ausDgListDetailVO;
	}
	public AusDgListDetailVO[] getAusDgListDetailVOs() {
		return ausDgListDetailVOs;
	}
	public void setAusDgListDetailVO(AusDgListDetailVO ausDgListDetailVO) {
		this.ausDgListDetailVO = ausDgListDetailVO;
	}
	public void setAusDgListDetailVOs(AusDgListDetailVO[] ausDgListDetailVOs) {
		this.ausDgListDetailVOs = ausDgListDetailVOs;
	}
	
	
}
