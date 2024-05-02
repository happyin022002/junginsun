/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsdSce0146Event.java
*@FileTitle : Microsoft Exception Management
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.01
*@LastModifier : 조풍연, 김민정
*@LastVersion : 1.0
* 2015.10.20 조풍연, 김민정
* 1.0 Creation
* 
=========================================================*/
package com.hanjin.apps.alps.esd.sce.dwellnotification.event;

import java.util.List;

import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315SendVO;
import com.hanjin.apps.alps.esd.sce.dwellnotification.vo.SearchMSExptVO;
import com.hanjin.apps.alps.esd.sce.dwellnotification.vo.SearchMSExptSaveVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_SCE_0146 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_SCE_0146HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author eunju son
 * @see HTMLAction 참조
 * @since J2EE 1.6 
 */
public class EsdSce0146Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private SearchMSExptVO searchMSExptVO = null;
	
	SearchMSExptSaveVO[] searchMSExptSaveVOs = null;
	
	public EsdSce0146Event(){}
	
	/**
	 * @param searchMSExptVO
	 */
	public EsdSce0146Event(SearchMSExptVO searchMSExptVO) {
		this.searchMSExptVO = searchMSExptVO;
    }

	/**
	 * @param searchDwellVO the searchDwellVO to set
	 */
	public void setSearchMSExptVO(SearchMSExptVO searchMSExptVO) {
		this.searchMSExptVO = searchMSExptVO;
	}

	/**
	 * @return the searchDwellVO
	 */
	public SearchMSExptVO getSearchMSExptVO() {
		return searchMSExptVO;
	}
	
	public SearchMSExptSaveVO[] getSearchMSExptSaveVOs() {
		return searchMSExptSaveVOs;
	}

	public void setSearchMSExptSaveVOs(SearchMSExptSaveVO[] searchMSExptSaveVOs) {
		this.searchMSExptSaveVOs = searchMSExptSaveVOs;
	}

	public String getEventName() {
		return "EsdSce0146Event";
	}

	public String toString() {
		return "EsdSce0146Event";
	}
	
	private Edi315SendVO edi315SendVO = null;
	/** Edi315SendVO setter 함수
	 * @param edi315SendVO Edi315SendVO 
	 * @return 
	 * @throws
	 */	
	public void setEdi315SendVO(Edi315SendVO edi315SendVO){
		this.edi315SendVO = edi315SendVO;
	}
	/** Edi315SendVO getter 함수
	 * @param 
	 * @return Edi315SendVO
	 * @throws
	 */		
	public Edi315SendVO getEdi315SendVO(){
		return this.edi315SendVO;
	}
	
	List<Edi315SendVO> edi315SendVOs = null;
	/** List<Edi315SendVO>  getter 함수
	 * @param 
	 * @return List<Edi315SendVO> 
	 * @throws
	 */		
	public List<Edi315SendVO> getEdi315SendVOs(){
		 return this.edi315SendVOs;
	}
	/** List<Edi315SendVO> edi315SendVOs  setter 함수
	 * @param edi315SendVOs List<Edi315SendVO> 
	 * @return 
	 * @throws
	 */		
	public void setEdi315SendVOs(List<Edi315SendVO> edi315SendVOs){
		this.edi315SendVOs = edi315SendVOs;
	}

}
