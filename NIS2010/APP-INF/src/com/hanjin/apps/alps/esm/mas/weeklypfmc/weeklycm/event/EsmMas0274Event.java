/*=========================================================
*Copyright(c) 2014 CyberLogitec
**@FileName : EsmMas0274Event.java
*@FileTitle : Storage Calculation Exception Node
*Open Issues :
*Change history :
*@LastModifyDate : 2015-02-10
*@LastModifier : Je Ryang Yoo
*@LastVersion : 
*  2015-02-10 Je Ryang Yoo
*  1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.event;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.StorageCalExcepNodeVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_MAS_0274 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0274HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Je Ryang Yoo
 * @see ESM_MAS_0274HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0274Event extends EventSupport {
	
	private static final long serialVersionUID = 1L; 
	
	/** 단건처리 */
	private StorageCalExcepNodeVO storageCalExcepNodeVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private StorageCalExcepNodeVO[] storageCalExcepNodeVOs = null;
	
	/** 단건처리 */
	private SearchConditionVO searchConditionVO = null;

	/** Constructor */
	public EsmMas0274Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmMas0274Event";
	}

	public StorageCalExcepNodeVO getStorageCalExcepNodeVO() {
		return storageCalExcepNodeVO;
	}

	public void setStorageCalExcepNodeVO(StorageCalExcepNodeVO storageCalExcepNodeVO) {
		this.storageCalExcepNodeVO = storageCalExcepNodeVO;
	}

	
	public StorageCalExcepNodeVO[] getStorageCalExcepNodeVOs() {
		return storageCalExcepNodeVOs;
	}

	public void setStorageCalExcepNodeVOs(StorageCalExcepNodeVO[] storageCalExcepNodeVOs) {
		this.storageCalExcepNodeVOs = storageCalExcepNodeVOs;
	}
		
	/** ValueObject Getter */
	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}
	/** ValueObject Setter */
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this.searchConditionVO = searchConditionVO;
	}		
			
}
