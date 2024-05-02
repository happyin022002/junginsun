/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0159Event.java
*@FileTitle : ESM_BKG_0161
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier :
*@LastVersion : 1.0
* 2009.07.10
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.event;

import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0161 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0161HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Seung Min
 * @see ESM_BKG_0161HTMLAction 참조
 * @since J2EE 1.6
 */

@SuppressWarnings("serial")
public class EsmBkg0161Event extends EventSupport {

	private String code = null;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	} 
	

}