/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0096Event.java
*@FileTitle : Yard Assign by CNTR
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.10.28 최영희
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.YardAssignVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0096 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0096HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Yeoung Hee
 * @see ESM_BKG_0096HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0096Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private BkgBlNoVO bkgBlNoVO = null;
    private YardAssignVO yardAssignVO = null;
	
	public EsmBkg0096Event(){}


	public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}


	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
	}


	public YardAssignVO getYardAssignVO() {
		return yardAssignVO;
	}


	public void setYardAssignVO(YardAssignVO yardAssignVO) {
		this.yardAssignVO = yardAssignVO;
	}
	
}