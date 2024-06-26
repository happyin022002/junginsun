/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTpb0108Event.java
*@FileTitle : TPB Modification
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.04
*@LastModifier : 최 선
*@LastVersion : 1.1
* 2008-09-16 Kim Jin-seung	1.0	최초 생성
* 2009.09.04 Sun, CHOI		1.1 Renewal Migration
=========================================================*/
package com.clt.apps.opus.esd.tpb.processmanage.outstandinggroupmanage.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.tpb.processmanage.outstandinggroupmanage.vo.ModifyTPBModificationVO;
import com.clt.apps.opus.esd.tpb.processmanage.outstandinggroupmanage.vo.SearchTPBModificationVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESD_TPB_0108 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_0108HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Sun, CHOI
 * @see ESD_TPB_0108HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTpb0108Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private SearchTPBModificationVO searchTPBModificationVO = null;

	/** Table Value Object Multi Data 처리 */
	private SearchTPBModificationVO[] searchTPBModificationVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private ModifyTPBModificationVO modifyTPBModificationVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ModifyTPBModificationVO[] modifyTPBModificationVOs = null;
	
	public EsdTpb0108Event(){}
	
	public void setSearchTPBModificationVO(SearchTPBModificationVO searchTPBModificationVO){
		this. searchTPBModificationVO = searchTPBModificationVO;
	}

	public void setSearchTPBModificationVOS(SearchTPBModificationVO[] searchTPBModificationVOs){
		if(searchTPBModificationVOs != null){
			SearchTPBModificationVO[] tmpVOs = Arrays.copyOf(searchTPBModificationVOs, searchTPBModificationVOs.length);
			this.searchTPBModificationVOs = tmpVOs;
		}
	}

	public SearchTPBModificationVO getSearchTPBModificationVO(){
		return searchTPBModificationVO;
	}

	public SearchTPBModificationVO[] getSearchTPBModificationVOS(){
		SearchTPBModificationVO[] rtnVOs = null;
		if (this.searchTPBModificationVOs != null) {
			rtnVOs = Arrays.copyOf(searchTPBModificationVOs, searchTPBModificationVOs.length);
		}
		return rtnVOs;
	}
	
	public void setModifyTPBModificationVO(ModifyTPBModificationVO modifyTPBModificationVO){
		this. modifyTPBModificationVO = modifyTPBModificationVO;
	}

	public void setModifyTPBModificationVOS(ModifyTPBModificationVO[] modifyTPBModificationVOs){
		if(modifyTPBModificationVOs != null){
			ModifyTPBModificationVO[] tmpVOs = Arrays.copyOf(modifyTPBModificationVOs, modifyTPBModificationVOs.length);
			this.modifyTPBModificationVOs = tmpVOs;
		}
	}

	public ModifyTPBModificationVO getModifyTPBModificationVO(){
		return modifyTPBModificationVO;
	}

	public ModifyTPBModificationVO[] getModifyTPBModificationVOS(){
		ModifyTPBModificationVO[] rtnVOs = null;
		if (this.modifyTPBModificationVOs != null) {
			rtnVOs = Arrays.copyOf(modifyTPBModificationVOs, modifyTPBModificationVOs.length);
		}
		return rtnVOs;
	}

}