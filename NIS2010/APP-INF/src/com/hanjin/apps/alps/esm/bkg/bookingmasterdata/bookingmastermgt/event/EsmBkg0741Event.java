/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0741Event.java
*@FileTitle : bookring master
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.06.22 강동윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgDocPerfOfcVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgEsvcHndlOfcVO;

/**
 * ESM_BKG_0741 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0741HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kang dong yun
 * @see ESM_BKG_0741HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0741Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgDocPerfOfcVO bkgDocPerfOfcVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgDocPerfOfcVO[] bkgDocPerfOfcVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgEsvcHndlOfcVO bkgEsvcHndlOfcVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgEsvcHndlOfcVO[] bkgEsvcHndlOfcVOs = null;

	public EsmBkg0741Event(){}
	
	public void setBkgDocPerfOfcVO(BkgDocPerfOfcVO bkgDocPerfOfcVO){
		this. bkgDocPerfOfcVO = bkgDocPerfOfcVO;
	}

	public void setBkgDocPerfOfcVOS(BkgDocPerfOfcVO[] bkgDocPerfOfcVOs){
		this. bkgDocPerfOfcVOs = bkgDocPerfOfcVOs;
	}

	public void setBkgEsvcHndlOfcVO(BkgEsvcHndlOfcVO bkgEsvcHndlOfcVO){
		this. bkgEsvcHndlOfcVO = bkgEsvcHndlOfcVO;
	}

	public void setBkgEsvcHndlOfcVOS(BkgEsvcHndlOfcVO[] bkgEsvcHndlOfcVOs){
		this. bkgEsvcHndlOfcVOs = bkgEsvcHndlOfcVOs;
	}

	public BkgDocPerfOfcVO getBkgDocPerfOfcVO(){
		return bkgDocPerfOfcVO;
	}

	public BkgDocPerfOfcVO[] getBkgDocPerfOfcVOS(){
		return bkgDocPerfOfcVOs;
	}

	public BkgEsvcHndlOfcVO getBkgEsvcHndlOfcVO(){
		return bkgEsvcHndlOfcVO;
	}

	public BkgEsvcHndlOfcVO[] getBkgEsvcHndlOfcVOS(){
		return bkgEsvcHndlOfcVOs;
	}

}