/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName   : EsmBkg1114Event.java
*@FileTitle  : ZIP Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.09
*@LastModifier   : 김현화
*@LastVersion    : 1.0
* 2010.12.09 김현화
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event;

import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.ZipCdListVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.ZipCdSchVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_1114 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1114HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Hyun Hwa
 * @see ESM_BKG_1114HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1114Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ZipCdSchVO zipCdSchVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ZipCdListVO[] zipCdListVOs = null;

	public EsmBkg1114Event(){}
	
	public void setZipCdSchVO(ZipCdSchVO zipCdSchVO){
		this.zipCdSchVO = zipCdSchVO;
	}

//	public void setZipCdListVOS(ZipCdListVO[] zipCdListVOs){
//		this. zipCdListVOs = zipCdListVOs;
//	}
//	
	//2015.04.10 Secure Coding 적용[CWE-496]
	public void setZipCdListVOS(ZipCdListVO[] zipCdListVOs){
		if (zipCdListVOs != null) {
			ZipCdListVO[] tmpVOs = new ZipCdListVO[zipCdListVOs.length];
			System.arraycopy(zipCdListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.zipCdListVOs = tmpVOs;
		}		
	}		

	public ZipCdSchVO getZipCdSchVO(){
		return zipCdSchVO;
	}

//	public ZipCdListVO[] getZipCdListVOS(){
//		return zipCdListVOs;
//	}

	//2015.04.10 Secure Coding 적용[CWE-496]
	public ZipCdListVO[] getZipCdListVOS(){
		ZipCdListVO[] tmpVOs = null;
		if (this.zipCdListVOs != null) {
			tmpVOs = new ZipCdListVO[zipCdListVOs.length];
			System.arraycopy(zipCdListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}		
	
}