/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg0078Event.java
*@FileTitle : Time of SPCL CGO Request APVL
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.14
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.12.14 김현욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event;

import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchScgRequestApvlTimeInputVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * VOP_SCG-0078 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG-0078HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HyunUk Kim
 * @see VOP_SCG-0078HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg0078Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchScgRequestApvlTimeInputVO searchScgRequestApvlTimeInputVO = null;

	public VopScg0078Event(){}
	
	public void setSearchScgRequestApvlTimeInputVO(SearchScgRequestApvlTimeInputVO searchScgRequestApvlTimeInputVO){
		this.searchScgRequestApvlTimeInputVO = searchScgRequestApvlTimeInputVO;
	}

	public SearchScgRequestApvlTimeInputVO getSearchScgRequestApvlTimeInputVO(){
		return searchScgRequestApvlTimeInputVO;
	}

}