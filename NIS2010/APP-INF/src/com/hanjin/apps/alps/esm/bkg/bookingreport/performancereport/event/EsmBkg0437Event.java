/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0437Event.java
*@FileTitle : Queue List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.25 김경섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocQueueDetailListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocQueueListInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocQueueListOutVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0437 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0437HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김경섭
 * @see ESM_BKG_0437HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0437Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DocQueueListInVO infoVO = null;

	/** Table Value Object Multi Data 처리 */
	private DocQueueListInVO[] infoVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DocQueueDetailListVO docQueueDetailListVO = null;

	/** Table Value Object Multi Data 처리 */
	private DocQueueDetailListVO[] docQueueDetailListVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DocQueueListOutVO DocQueueListOutVO = null;

	/** Table Value Object Multi Data 처리 */
	private DocQueueListOutVO[] DocQueueListOutVOs = null;
	
	
	private String usrId  = "";
	
	public String getUsrId() {
		return usrId;
	}


	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}


	public EsmBkg0437Event(){}
	

	public DocQueueListInVO getInfoVO() {
		return infoVO;
	}


	public void setInfoVO(DocQueueListInVO infoVO) {
		this.infoVO = infoVO;
	}


	public DocQueueListInVO[] getInfoVOs() {
		DocQueueListInVO[] rtnVOs = null;
		if (this.infoVOs != null) {
			rtnVOs = Arrays.copyOf(infoVOs, infoVOs.length);
		}
		return rtnVOs;
	}


	public void setInfoVOs(DocQueueListInVO[] infoVOs){
		if(infoVOs != null){
			DocQueueListInVO[] tmpVOs = Arrays.copyOf(infoVOs, infoVOs.length);
			this.infoVOs = tmpVOs;
		}
	}


	public DocQueueDetailListVO getDocQueueDetailListVO() {
		return docQueueDetailListVO;
	}


	public void setDocQueueDetailListVO(DocQueueDetailListVO docQueueDetailListVO) {
		this.docQueueDetailListVO = docQueueDetailListVO;
	}


	public DocQueueDetailListVO[] getDocQueueDetailListVOs() {
		DocQueueDetailListVO[] rtnVOs = null;
		if (this.docQueueDetailListVOs != null) {
			rtnVOs = Arrays.copyOf(docQueueDetailListVOs, docQueueDetailListVOs.length);
		}
		return rtnVOs;
	}


	public void setDocQueueDetailListVOs(DocQueueDetailListVO[] docQueueDetailListVOs){
		if(docQueueDetailListVOs != null){
			DocQueueDetailListVO[] tmpVOs = Arrays.copyOf(docQueueDetailListVOs, docQueueDetailListVOs.length);
			this.docQueueDetailListVOs = tmpVOs;
		}
	}
	

	public DocQueueListOutVO getDocQueueListOutVO() {
		return DocQueueListOutVO;
	}


	public void setDocQueueListOutVO(DocQueueListOutVO DocQueueListOutVO) {
		this.DocQueueListOutVO = DocQueueListOutVO;
	}


	public DocQueueListOutVO[] getDocQueueListOutVOs() {
		DocQueueListOutVO[] rtnVOs = null;
		if (this.DocQueueListOutVOs != null) {
			rtnVOs = Arrays.copyOf(DocQueueListOutVOs, DocQueueListOutVOs.length);
		}
		return rtnVOs;
	}


	public void setDocQueueListOutVOs(DocQueueListOutVO[] DocQueueListOutVOs){
		if(DocQueueListOutVOs != null){
			DocQueueListOutVO[] tmpVOs = Arrays.copyOf(DocQueueListOutVOs, DocQueueListOutVOs.length);
			this.DocQueueListOutVOs = tmpVOs;
		}
	}
	
	
	
}