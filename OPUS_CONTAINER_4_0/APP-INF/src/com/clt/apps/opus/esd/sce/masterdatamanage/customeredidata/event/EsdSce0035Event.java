/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdSce0035Event.java
*@FileTitle : EsdSce0035
*Open Issues :
*Change history :
*@LastModifyDate : 2009-11-02
*@LastModifier : 전병석
*@LastVersion : 1.0
* 2006-09-20 yongcheon_shin
* 1.0 최초 생성
* 2009-11-02
* 1.4 버전 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event;

import java.util.HashMap;
import java.util.List;

import com.clt.apps.opus.esd.sce.edi315send.vo.Edi315SendVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchEDIPerformanceOptionsVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchEdiSummaryReportOptionsVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EsdSce0035 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Yong-cheon Shin
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdSce0035Event extends EventSupport{
    private static final long serialVersionUID = 1L;
    private HashMap<String, String> parameterMap = null;
    public EsdSce0035Event(){}
  
	private SearchEDIPerformanceOptionsVO schEpOpts = null;
	
	/**SearchEDIPerformanceOptionsVO setter 함수
	 * @param  schEpOpts SearchEDIPerformanceOptionsVO 
	 * @return 
	 * @throws
	 */	
	public void setSchEpOpts(SearchEDIPerformanceOptionsVO schEpOpts){
		this.schEpOpts = schEpOpts;
	}
	
	/**SearchEDIPerformanceOptionsVO getter 함수
	 * @param  
	 * @return SearchEDIPerformanceOptionsVO
	 * @throws
	 */		
	public SearchEDIPerformanceOptionsVO getSchEpOpts(){
		return schEpOpts;
	}
	
	/**
	 * @param  
	 * @return HashMap
	 * @throws
	 */	
	public HashMap<String, String> getParameterMap() {
		return parameterMap;
	}
	
	/**
	 * @param  parameterMap HashMap 
	 * @return
	 * @throws
	 */	
	public void setParameterMap(HashMap<String, String> parameterMap) {
		this.parameterMap = parameterMap;
	}
	
	private SearchEdiSummaryReportOptionsVO schSROptsVO = null;
	
	/** SearchEdiSummaryReportOptionsVO setter 함수
	 * @param  schSROptsVO SearchEdiSummaryReportOptionsVO  
	 * @return 
	 * @throws
	 */		
	public void setSchSROptsVO(SearchEdiSummaryReportOptionsVO schSROptsVO){
		this.schSROptsVO = schSROptsVO;
	}
	
	/** SearchEdiSummaryReportOptionsVO getter 함수
	 * @param  
	 * @return SearchEdiSummaryReportOptionsVO
	 * @throws
	 */		
	public SearchEdiSummaryReportOptionsVO getSchSROptsVO(){
		return schSROptsVO;
	}
	
	int iPage = 0;
	
	public int getIPage() {
		return iPage;
	}

	/** page setter 함수
	 * @param  page int
	 * @return 
	 * @throws
	 */	
	public void setIPage(int page) {
		iPage = page;
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
