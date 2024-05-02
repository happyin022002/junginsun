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
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.ZipCdListVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.ZipCdSchVO;

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
	
	private int iPage 			= 0;

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ZipCdSchVO zipCdSchVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ZipCdListVO[] zipCdListVOs = null;

	public EsmBkg1114Event(){}
	
	public void setZipCdSchVO(ZipCdSchVO zipCdSchVO){
		this.zipCdSchVO = zipCdSchVO;
	}

	public void setZipCdListVOS(ZipCdListVO[] zipCdListVOs){
		this. zipCdListVOs = zipCdListVOs;
	}
	/**
	 * Page No 반환<br>
	 * @return
	 */
	public int getIPage() {
		return iPage;
	}

	/**
	 * Page No 세팅<br>
	 * @param page
	 */
	public void setIPage(int page) {
		this.iPage = page;
	}

	public ZipCdSchVO getZipCdSchVO(){
		return zipCdSchVO;
	}

	public ZipCdListVO[] getZipCdListVOS(){
		return zipCdListVOs;
	}

}