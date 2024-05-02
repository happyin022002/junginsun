/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0214Event.java
*@FileTitle : Doc Performance Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.21
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.08.21 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocPFMCBLListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocPFMCOfcListVO;


/**
 * ESM_BKG_0214 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0214HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Jong
 * @see ESM_BKG_0214HTMLAction 참조
 * @since J2EE 1.6 
 */

public class EsmBkg0214Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DocPFMCBLListVO docPFMCBLListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private DocPFMCBLListVO[] docPFMCBLListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private DocPFMCOfcListVO docPFMCOfcListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private DocPFMCOfcListVO[] docPFMCOfcListVOs = null;

	public EsmBkg0214Event(){}
	
	public void setDocPFMCBLListVO(DocPFMCBLListVO docPFMCBLListVO){
		this. docPFMCBLListVO = docPFMCBLListVO;
	}

	public void setDocPFMCBLListVOS(DocPFMCBLListVO[] docPFMCBLListVOs){
		if(docPFMCBLListVOs != null){
			DocPFMCBLListVO[] tmpVOs = new DocPFMCBLListVO[docPFMCBLListVOs.length];
			System.arraycopy(docPFMCBLListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.docPFMCBLListVOs = tmpVOs;
		}
	}

	public void setDocPFMCOfcListVO(DocPFMCOfcListVO docPFMCOfcListVO){
		this. docPFMCOfcListVO = docPFMCOfcListVO;
	}

	public void setDocPFMCOfcListVOS(DocPFMCOfcListVO[] docPFMCOfcListVOs){
		if(docPFMCOfcListVOs != null){
			DocPFMCOfcListVO[] tmpVOs = new DocPFMCOfcListVO[docPFMCOfcListVOs.length];
			System.arraycopy(docPFMCOfcListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.docPFMCOfcListVOs = tmpVOs;
		}
	}

	public DocPFMCBLListVO getDocPFMCBLListVO(){
		return docPFMCBLListVO;
	}

	public DocPFMCBLListVO[] getDocPFMCBLListVOS(){
		DocPFMCBLListVO[] rtnVOs = null;
		if (this.docPFMCBLListVOs != null) {
			rtnVOs = new DocPFMCBLListVO[docPFMCBLListVOs.length];
			System.arraycopy(docPFMCBLListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public DocPFMCOfcListVO getDocPFMCOfcListVO(){
		return docPFMCOfcListVO;
	}

	public DocPFMCOfcListVO[] getDocPFMCOfcListVOS(){
		DocPFMCOfcListVO[] rtnVOs = null;
		if (this.docPFMCOfcListVOs != null) {
			rtnVOs = new DocPFMCOfcListVO[docPFMCOfcListVOs.length];
			System.arraycopy(docPFMCOfcListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}