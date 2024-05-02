/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BcmCcd2003Event.java
*@FileTitle : BCM_CCD_2003
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.03
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.event;
 
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.vo.SearchMdmHistListVO;


/**
 * BCM_CCD_2004 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_2004HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see BCM_CCD_2004HTMLAction 참조
 * @since J2EE 1.6
 */
 
public class BcmCcd2004Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMdmHistListVO SearchMdmHistListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchMdmHistListVO[] SearchMdmHistListVOs = null;

	public BcmCcd2004Event(){}
	
	public void setSearchMdmHistListVO(SearchMdmHistListVO SearchMdmHistListVO){
		this. SearchMdmHistListVO = SearchMdmHistListVO;
	}

	public void setSearchMdmHistListVOS(SearchMdmHistListVO[] SearchMdmHistListVOs){
		if(SearchMdmHistListVOs != null){
			SearchMdmHistListVO[] tmpVOs = java.util.Arrays.copyOf(SearchMdmHistListVOs, SearchMdmHistListVOs.length);
			this.SearchMdmHistListVOs = tmpVOs;
		}
	}

	public SearchMdmHistListVO getSearchMdmHistListVO(){
		return SearchMdmHistListVO;
	}

	public SearchMdmHistListVO[] getSearchMdmHistListVOS(){
		SearchMdmHistListVO[] rtnVOs = null;
		if (this.SearchMdmHistListVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(SearchMdmHistListVOs, SearchMdmHistListVOs.length);
		}
		return rtnVOs;
	}

}