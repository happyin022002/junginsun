/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1512Event.java
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

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.vo.DgCargoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.vo.DgInqModiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.vo.DgListCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 
/**
 * esm_bkg_1512 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1512HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kyoung Jong Yun
 * @see ESM_BKG_1512HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg1512Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DgListCondVO dgListCondVO = null;
	private DgCargoCondVO dgCargoCondVO = null;
	private DgInqModiVO dgInqModiVO = null;
	private DgInqModiVO[] dgInqModiVOs = null;
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public DgListCondVO getDgListCondVO() {
		return dgListCondVO;
	}
	public DgCargoCondVO getDgCargoCondVO() {
		return dgCargoCondVO;
	}
	public DgInqModiVO getDgInqModiVO() {
		return dgInqModiVO;
	}
	public DgInqModiVO[] getDgInqModiVOs() {
		return dgInqModiVOs;
	}
	public void setDgListCondVO(DgListCondVO dgListCondVO) {
		this.dgListCondVO = dgListCondVO;
	}
	public void setDgCargoCondVO(DgCargoCondVO dgCargoCondVO) {
		this.dgCargoCondVO = dgCargoCondVO;
	}
	public void setDgInqModiVO(DgInqModiVO dgInqModiVO) {
		this.dgInqModiVO = dgInqModiVO;
	}
	public void setDgInqModiVOs(DgInqModiVO[] dgInqModiVOs) {
		this.dgInqModiVOs = dgInqModiVOs;
	}
	
	
	
	
}
