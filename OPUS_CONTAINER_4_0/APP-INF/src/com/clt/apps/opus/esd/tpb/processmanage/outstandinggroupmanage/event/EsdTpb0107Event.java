/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTpb0107Event.java
*@FileTitle : TPB Group Remaking
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

import com.clt.apps.opus.esd.tpb.processmanage.outstandinggroupmanage.vo.ModifyTPBGroupRemakingVO;
import com.clt.apps.opus.esd.tpb.processmanage.outstandinggroupmanage.vo.SearchTPBGroupRemakingVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESD_TPB_0107 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_0107HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Sun, CHOI
 * @see ESD_TPB_0107HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTpb0107Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchTPBGroupRemakingVO searchTPBGroupRemakingVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchTPBGroupRemakingVO[] searchTPBGroupRemakingVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ModifyTPBGroupRemakingVO modifyTPBGroupRemakingVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ModifyTPBGroupRemakingVO[] modifyTPBGroupRemakingVOs = null;
	
	public EsdTpb0107Event(){}
	
	public void setSearchTPBGroupRemakingVO(SearchTPBGroupRemakingVO searchTPBGroupRemakingVO){
		this. searchTPBGroupRemakingVO = searchTPBGroupRemakingVO;
	}

	public void setSearchTPBGroupRemakingVOS(SearchTPBGroupRemakingVO[] searchTPBGroupRemakingVOs){
		if(searchTPBGroupRemakingVOs != null){
			SearchTPBGroupRemakingVO[] tmpVOs = Arrays.copyOf(searchTPBGroupRemakingVOs, searchTPBGroupRemakingVOs.length);
			this.searchTPBGroupRemakingVOs = tmpVOs;
		}
	}

	public SearchTPBGroupRemakingVO getSearchTPBGroupRemakingVO(){
		return searchTPBGroupRemakingVO;
	}

	public SearchTPBGroupRemakingVO[] getSearchTPBGroupRemakingVOS(){
		SearchTPBGroupRemakingVO[] rtnVOs = null;
		if (this.searchTPBGroupRemakingVOs != null) {
			rtnVOs = Arrays.copyOf(searchTPBGroupRemakingVOs, searchTPBGroupRemakingVOs.length);
		}
		return rtnVOs;
	}
	
	public void setModifyTPBGroupRemakingVO(ModifyTPBGroupRemakingVO modifyTPBGroupRemakingVO){
		this. modifyTPBGroupRemakingVO = modifyTPBGroupRemakingVO;
	}

	public void setModifyTPBGroupRemakingVOS(ModifyTPBGroupRemakingVO[] modifyTPBGroupRemakingVOs){
		if(modifyTPBGroupRemakingVOs != null){
			ModifyTPBGroupRemakingVO[] tmpVOs = Arrays.copyOf(modifyTPBGroupRemakingVOs, modifyTPBGroupRemakingVOs.length);
			this.modifyTPBGroupRemakingVOs = tmpVOs;
		}
	}

	public ModifyTPBGroupRemakingVO getModifyTPBGroupRemakingVO(){
		return modifyTPBGroupRemakingVO;
	}

	public ModifyTPBGroupRemakingVO[] getModifyTPBGroupRemakingVOS(){
		ModifyTPBGroupRemakingVO[] rtnVOs = null;
		if (this.modifyTPBGroupRemakingVOs != null) {
			rtnVOs = Arrays.copyOf(modifyTPBGroupRemakingVOs, modifyTPBGroupRemakingVOs.length);
		}
		return rtnVOs;
	}

}