/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0745Event.java
*@FileTitle : ManifestListDownload
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.05.04 경종윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.brazil.event;

import java.util.Arrays;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.brazil.vo.BrHsCdCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.brazil.vo.BrHsCdDetailVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0745 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0745HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kyoung Jong Yun
 * @see ESM_BKG_0745HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0745Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BrHsCdDetailVO brHsCdDetailVO = null;
	private BrHsCdCondVO brHsCdCondVO = null;
	
	private BrHsCdDetailVO[] brHsCdDetailVOs = null;
	
	public EsmBkg0745Event(){}


	/**
	 * @return the bkgCstmsCmdtVO
	 */
	public BrHsCdDetailVO getBrHsCdDetailVO() {
		return brHsCdDetailVO;
	}


	/**
	 * @param bkgCstmsCmdtVO the bkgCstmsCmdtVO to set
	 */
	public void setBrHsCdDetailVO(BrHsCdDetailVO brHsCdDetailVO) {
		this.brHsCdDetailVO = brHsCdDetailVO;
	}


	/**
	 * @return the brHsCdCondVO
	 */
	public BrHsCdCondVO getBrHsCdCondVO() {
		return brHsCdCondVO;
	}


	/**
	 * @param brHsCdCondVO the brHsCdCondVO to set
	 */
	public void setBrHsCdCondVO(BrHsCdCondVO brHsCdCondVO) {
		this.brHsCdCondVO = brHsCdCondVO;
	}


	/**
	 * @return the brHsCdDetailVOs
	 */
	public BrHsCdDetailVO[] getBrHsCdDetailVOs() {
		BrHsCdDetailVO[] rtnVOs = null;
		if (this.brHsCdDetailVOs != null) {
			rtnVOs = Arrays.copyOf(brHsCdDetailVOs, brHsCdDetailVOs.length);
		}
		return rtnVOs;
	}


	/**
	 * @param brHsCdDetailVOs the brHsCdDetailVOs to set
	 */
	public void setBrHsCdDetailVOs(BrHsCdDetailVO[] brHsCdDetailVOs){
		if(brHsCdDetailVOs != null){
			BrHsCdDetailVO[] tmpVOs = Arrays.copyOf(brHsCdDetailVOs, brHsCdDetailVOs.length);
			this.brHsCdDetailVOs = tmpVOs;
		}
	}
	
	
	

}