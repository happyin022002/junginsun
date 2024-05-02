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
package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event;

import java.util.Collection;
import java.util.HashMap;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchMissingListVO;

/**
 * EsdSce0074 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author sanghyun-kim
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsdSce0074Event extends EventSupport{
	//private String trunk_vvd = null;
    //private String cntr_no = null;
    //private HashMap parameterMap = null;
    //private Collection parameterMaps = null;
    //private String tabno = "";
    //private int iPage = 0;
    
   // private String cs_grp_name = null;
    private SearchMissingListVO searchMissingListVo = null;
    private SearchMissingListVO[] searchMissingListVos = null;    
    //private SearchMissingListVO searchOnTimeListVO = null;
    /** Constructor
     * @param parameterMap_
     */
//    public EsdSce0074Event(HashMap parameterMap_){
//        this.parameterMap = parameterMap_;
//        this.trunk_vvd = (String)parameterMap_.get("trunk_vvd");
//        this.cntr_no = (String)parameterMap_.get("cntr_no");
//        this.tabno =  (String)parameterMap_.get("tabno");
//    }
    
    /** Constructor
     * @param parameterMap_
     * @param parameterMaps_
     */
//    public EsdSce0074Event(HashMap parameterMap_, Collection parameterMaps_){
//        this.parameterMap = parameterMap_;
//        this.parameterMaps = parameterMaps_;
//        this.trunk_vvd = (String)parameterMap_.get("trunk_vvd");
//        this.cntr_no = (String)parameterMap_.get("cntr_no");
//    }
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
    	return this.searchMissingListVos;
    }
    public void setSelectedMissingList(SearchMissingListVO[] searchMissingListVos){
    	this.searchMissingListVos = searchMissingListVos;
    }    

//    /**
//     * @return Returns the cntr_no.
//     */
//    public String getCntr_no() {
//        return cntr_no;
//    }
//    /**
//     * @return Returns the parameterMap.
//     */
//    public HashMap getParameterMap() {
//        return parameterMap;
//    }
//    /**
//     * @return Returns the trunk_vvd.
//     */
//    public String getTrunk_vvd() {
//        return trunk_vvd;
//    }

//    /**
//     * @return Returns the cs_grp_name.
//     */
//    public String getCs_grp_name() {
//        return cs_grp_name;
//    }
//
//    /**
//     * @return Returns the parameterMaps.
//     */
//    public Collection getParameterMaps() {
//        return parameterMaps;
//    }
//
//	/**
//	 * @return Returns the tabno.
//	 */
//	public String getTabno() {
//		return tabno;
//	}
//
//	/**
//	 * @param tabno The tabno to set.
//	 */
//	public void setTabno(String tabno) {
//		this.tabno = tabno;
//	}
//
//	/**
//	 * @return Returns the iPage.
//	 */
//	public int getIPage() {
//		return iPage;
//	}
//
//	/**
//	 * @param page The iPage to set.
//	 */
//	public void setIPage(int page) {
//		iPage = page;
//	}
}
