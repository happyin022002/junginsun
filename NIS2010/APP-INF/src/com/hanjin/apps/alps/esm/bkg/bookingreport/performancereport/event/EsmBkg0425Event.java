/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmBkg0425Event.java
*@FileTitle : Email Account Set-up for Front Office
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.07
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2011.03.07 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.BkgEmlAcctStupVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0425 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0425HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Jong
 * @see ESM_BKG_0425HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0425Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgEmlAcctStupVO bkgEmlAcctStupVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgEmlAcctStupVO[] bkgEmlAcctStupVOs = null;

	public EsmBkg0425Event(){}
	
	public void setBkgEmlAcctStupVO(BkgEmlAcctStupVO bkgEmlAcctStupVO){
		this. bkgEmlAcctStupVO = bkgEmlAcctStupVO;
	}

	public void setBkgEmlAcctStupVOS(BkgEmlAcctStupVO[] bkgEmlAcctStupVOs){
		if(bkgEmlAcctStupVOs != null){
			BkgEmlAcctStupVO[] tmpVOs = Arrays.copyOf(bkgEmlAcctStupVOs, bkgEmlAcctStupVOs.length);
			this.bkgEmlAcctStupVOs = tmpVOs;
		}
	}

	public BkgEmlAcctStupVO getBkgEmlAcctStupVO(){
		return bkgEmlAcctStupVO;
	}

	public BkgEmlAcctStupVO[] getBkgEmlAcctStupVOS(){
		BkgEmlAcctStupVO[] rtnVOs = null;
		if (this.bkgEmlAcctStupVOs != null) {
			rtnVOs = Arrays.copyOf(bkgEmlAcctStupVOs, bkgEmlAcctStupVOs.length);
		}
		return rtnVOs;
	}

}