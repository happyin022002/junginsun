/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : EsdSce0074Event.java
*@FileTitle : EsdSce0074
*Open Issues :
*Change history :
*@LastModifyDate : 2008-05-10
*@LastModifier : sanghyun-kim
*@LastVersion : 1.0
* 2008-05-10 sanghyun-kim
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchMissingListVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EsdSce0074 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author sanghyun-kim
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdSce0074Event extends EventSupport {

	private static final long serialVersionUID = 1L;

    private SearchMissingListVO searchMissingListVo = null;
    private SearchMissingListVO[] searchMissingListVos = null;    

    /**
     * Evenct Name 을 반환한다.
     * @return "EsdSce074Event"
     */
    public String getEventName() {
        return "EsdSce0074Event";
    }
    
    /**
     * String Casting 된 Evenct Name 을 반환한다.
     * @return "EsdSce074Event"
     */
    public String toString() {
        return "EsdSce0074Event";
    }
    
    public SearchMissingListVO getSearchMissingList(){
    	return this.searchMissingListVo;
    }
    
    public void setSearchMissingList(SearchMissingListVO searchMissingListVo){
    	this.searchMissingListVo = searchMissingListVo;
    }
    
    public SearchMissingListVO[] getSelectedMissingList(){
    	SearchMissingListVO[] rtnVOs = null;
		if (this.searchMissingListVos != null) {
			rtnVOs = Arrays.copyOf(searchMissingListVos, searchMissingListVos.length);
		}
		return rtnVOs;
    }
    
    public void setSelectedMissingList(SearchMissingListVO[] searchMissingListVos){
		if(searchMissingListVos != null){
			SearchMissingListVO[] tmpVOs = Arrays.copyOf(searchMissingListVos, searchMissingListVos.length);
			this.searchMissingListVos = tmpVOs;
		}
    }
}
