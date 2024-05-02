/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName 			: EsmBkg1053Event.java
*@FileTitle 		: ESM_BKG-1053
*Open Issues 		:
*Change history 	:
*@LastModifyDate 	: 2014.09.01
*@LastModifier 		: OH DONG HYUN
*@LastVersion 		: 1.0
* 2014.09.01 OH DONG HYUN
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.china.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.china.vo.BkgCstmsCCAMCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.china.vo.BkgCstmsCCAMListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.china.vo.ChinaManifestListTransmitHistDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.china.vo.ChinaTransmitHistCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eu24EnsListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 
/**
 * ESM_BKG_1053 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1053HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author  OH DONG HYUN
 * @see ESM_BKG_1053HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1053Event extends EventSupport {
	private static final long serialVersionUID = 1L;
		
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgCstmsCCAMCondVO bkgCstmsCCAMCondVO = null; 
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgCstmsCCAMListVO[] bkgCstmsCCAMListVOs  = null;


	public void setBkgCstmsCCAMCondVO(BkgCstmsCCAMCondVO bkgCstmsCCAMCondVO){
		this.bkgCstmsCCAMCondVO = bkgCstmsCCAMCondVO;
	}	
	 
	public BkgCstmsCCAMCondVO getBkgCstmsCCAMCondVO(){
		return bkgCstmsCCAMCondVO;
	}
	
	public void setBkgCstmsCCAMListVOs(BkgCstmsCCAMListVO[] bkgCstmsCCAMListVOs){
		this.bkgCstmsCCAMListVOs = bkgCstmsCCAMListVOs;
	}	
	 
	public BkgCstmsCCAMListVO[] getBkgCstmsCCAMListVO(){
		return bkgCstmsCCAMListVOs;
	}
	
}