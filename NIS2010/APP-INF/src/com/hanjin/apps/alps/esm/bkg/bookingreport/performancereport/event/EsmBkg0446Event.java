/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmBkg0446Event.java
*@FileTitle : Queue List Set Serarch
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.07
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2011.04.07 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import java.util.Arrays;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgXterSrchSetVO;


/**
 * ESM_BKG_0446 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0446HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Jong
 * @see ESM_BKG_0446HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0446Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgXterSrchSetVO bkgXterSrchSetVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgXterSrchSetVO[] bkgXterSrchSetVOs = null;

	private String setSlctFlg = null;
	
	public EsmBkg0446Event(){}
	
	public void setBkgXterSrchSetVO(BkgXterSrchSetVO bkgXterSrchSetVO){
		this. bkgXterSrchSetVO = bkgXterSrchSetVO;
	}

	public void setBkgXterSrchSetVOS(BkgXterSrchSetVO[] bkgXterSrchSetVOs){
		if(bkgXterSrchSetVOs != null){
			BkgXterSrchSetVO[] tmpVOs = Arrays.copyOf(bkgXterSrchSetVOs, bkgXterSrchSetVOs.length);
			this.bkgXterSrchSetVOs = tmpVOs;
		}
	}

	public BkgXterSrchSetVO getBkgXterSrchSetVO(){
		return bkgXterSrchSetVO;
	}

	public BkgXterSrchSetVO[] getBkgXterSrchSetVOS(){
		BkgXterSrchSetVO[] rtnVOs = null;
		if (this.bkgXterSrchSetVOs != null) {
			rtnVOs = Arrays.copyOf(bkgXterSrchSetVOs, bkgXterSrchSetVOs.length);
		}
		return rtnVOs;
	}

	public String getSetSlctFlg() {
		return setSlctFlg;
	}

	public void setSetSlctFlg(String setSlctFlg) {
		this.setSlctFlg = setSlctFlg;
	}
	
	
}