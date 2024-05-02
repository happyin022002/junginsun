/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmPri6059Event.java
 *@FileTitle : RFA Quotation Rate - Origin & Destination
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.19
 *@LastModifier : 이승준
 *@LastVersion : 1.0
 * 2009.10.19 이승준
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.event;

import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_PRI_6059 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_PRI_6059HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Seung-Jun,Lee
 * @see ESM_PRI_6059HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri6059Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	public EsmPri6059Event() {
	}
}