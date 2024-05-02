/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmPri6059Event.java
 *@FileTitle : RFA Quotation Rate - Origin & Destination
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.07.24
 *@LastModifier : 이은섭
 *@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.event;

import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.FicCheckCYPortLocationVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.FicRouteGroupVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_PRI_6097 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_PRI_6097HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author EUN-SUP, LEE
 * @see ESM_PRI_6097HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri6097Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private FicRouteGroupVO ficRouteGroupVO = null;
	private FicCheckCYPortLocationVO ficCheckCYPortLocationVO = null;

	public EsmPri6097Event() {
	}

	public FicRouteGroupVO getFicRouteGroupVO() {
		return ficRouteGroupVO;
	}

	public void setFicRouteGroupVO(FicRouteGroupVO ficRouteGroupVO) {
		this.ficRouteGroupVO = ficRouteGroupVO;
	}

	public FicCheckCYPortLocationVO getFicCheckCYPortLocationVO() {
		return ficCheckCYPortLocationVO;
	}

	public void setFicCheckCYPortLocationVO(FicCheckCYPortLocationVO ficCheckCYPortLocationVO) {
		this.ficCheckCYPortLocationVO = ficCheckCYPortLocationVO;
	}
}