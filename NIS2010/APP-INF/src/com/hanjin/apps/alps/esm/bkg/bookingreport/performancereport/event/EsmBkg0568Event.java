/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EbmBkg0568Event.java
*@FileTitle : C/A Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.09.22 강동윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.CaIssueDateOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.CaIssueDateInVO;


/**
 * EBM_BKG_0568 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EBM_BKG_0568HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kang dong yun
 * @see ESM_BKG_0568HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0568Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CaIssueDateOutVO caIssueDateOutVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CaIssueDateOutVO[] caIssueDateOutVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CaIssueDateInVO caIssueDateInVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CaIssueDateInVO[] caIssueDateInVOs = null;
	
	private String manifest = null;

	public EsmBkg0568Event(){}
	
	public void setCaIssueDateOutVO(CaIssueDateOutVO caIssueDateOutVO){
		this. caIssueDateOutVO = caIssueDateOutVO;
	}

	public void setCaIssueDateOutVOS(CaIssueDateOutVO[] caIssueDateOutVOs){
		this. caIssueDateOutVOs = caIssueDateOutVOs;
	}

	public void setCaIssueDateInVO(CaIssueDateInVO caIssueDateInVO){
		this. caIssueDateInVO = caIssueDateInVO;
	}

	public void setCaIssueDateInVOS(CaIssueDateInVO[] caIssueDateInVOs){
		this. caIssueDateInVOs = caIssueDateInVOs;
	}
	
	public void setManifest(String manifest){
		this.manifest = manifest;
	}

	public CaIssueDateOutVO getCaIssueDateOutVO(){
		return caIssueDateOutVO;
	}

	public CaIssueDateOutVO[] getCaIssueDateOutVOS(){
		return caIssueDateOutVOs;
	}

	public CaIssueDateInVO getCaIssueDateInVO(){
		return caIssueDateInVO;
	}

	public CaIssueDateInVO[] getCaIssueDateInVOS(){
		return caIssueDateInVOs;
	}
	
	public String getManifest(){
		return manifest;
	}

}