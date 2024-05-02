/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0594Event.java
*@FileTitle : Cargo Closing Time Setup
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.28
*@LastModifier : 오동현
*@LastVersion : 1.0
* 2013.01.28 오동현
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.CgoClzTmStupVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0594 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0594HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Jong
 * @see ESM_BKG_0594HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0594Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CgoClzTmStupVO cgoClzTmStupVO= null;
	
	/** Table Value Object Multi Data 처리 */
	private CgoClzTmStupVO[] cgoClzTmStupVOs = null;

	public EsmBkg0594Event(){}


	public CgoClzTmStupVO getCgoClzTmStupVO() {
		return cgoClzTmStupVO;
	}



	public void setCgoClzTmStupVO(CgoClzTmStupVO cgoClzTmStupVO) {
		this.cgoClzTmStupVO = cgoClzTmStupVO;
	}



	public CgoClzTmStupVO[] getCgoClzTmStupVOs() {
		return cgoClzTmStupVOs;
	}





	public void setCgoClzTmStupVOs(CgoClzTmStupVO[] cgoClzTmStupVOs) {
		this.cgoClzTmStupVOs = cgoClzTmStupVOs;
	}


}