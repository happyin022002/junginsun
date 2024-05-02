/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1094Event.java
*@FileTitle : ESM_BKG-1094
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.04.21 임재택
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG-1094 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-1094HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author LIM JAE TAEK
 * @see ESM_BKG-1094HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1094Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private String vslCallRefNoOld = null;
	private String vslCallRefNoNew = null;
	private String vvdCd = null;
	 
	 
	public EsmBkg1094Event(){}
	
	public String getVslCallRefNoNew() {
		return vslCallRefNoNew;
	}

	public void setVslCallRefNoNew(String vslCallRefNoNew) {
		this.vslCallRefNoNew = vslCallRefNoNew;
	}

	public String getVslCallRefNoOld() {
		return vslCallRefNoOld;
	}

	public void setVslCallRefNoOld(String vslCallRefNoOld) {
		this.vslCallRefNoOld = vslCallRefNoOld;
	}
	
	public String getVvdCd() {
		return vvdCd;
	}

	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	 
}