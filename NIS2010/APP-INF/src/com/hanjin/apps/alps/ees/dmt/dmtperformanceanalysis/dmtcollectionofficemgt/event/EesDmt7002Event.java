/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt7002Event.java
*@FileTitle : Remark(s)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : mun jung cheol
*@LastVersion : 1.0
* 2009.10.13 mun jung cheol
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.event;

import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.vo.CollectionOfficeFinderVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.vo.OfficeYardListVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EES_DMT_7002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_7002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Mun Jung Cheol
 * @see EES_DMT_7002HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt7002Event extends EventSupport {
    
    private static final long serialVersionUID = 1L;
    
    private CollectionOfficeFinderVO collectionOfficeFinderVO  = null;
    
    private CollectionOfficeFinderVO[] collectionOfficeFinderVOs  = null;
    
    private OfficeYardListVO officeYardListVO  = null;
    
    private OfficeYardListVO[] officeYardListVOs  = null;    
    
    public EesDmt7002Event(){}

    /**
    * @return the collectionOfficeFinderVO
    */
    public CollectionOfficeFinderVO getCollectionOfficeFinderVO() {
        return collectionOfficeFinderVO;
    }

    /**
    * @param collectionOfficeFinderVO the collectionOfficeFinderVO to set
    */
    public void setCollectionOfficeFinderVO(
            CollectionOfficeFinderVO collectionOfficeFinderVO) {
        this.collectionOfficeFinderVO = collectionOfficeFinderVO;
    }

    /**
    * @return the collectionOfficeFinderVOs
    */
    public CollectionOfficeFinderVO[] getCollectionOfficeFinderVOs() {
        return collectionOfficeFinderVOs;
    }

    /**
    * @param collectionOfficeFinderVOs the collectionOfficeFinderVOs to set
    */
    public void setCollectionOfficeFinderVOs(
            CollectionOfficeFinderVO[] collectionOfficeFinderVOs) {
        this.collectionOfficeFinderVOs = collectionOfficeFinderVOs;
    }

    /**
    * @return the officeYardListVO
    */
    public OfficeYardListVO getOfficeYardListVO() {
        return officeYardListVO;
    }

    /**
    * @param officeYardListVO the officeYardListVO to set
    */
    public void setOfficeYardListVO(OfficeYardListVO officeYardListVO) {
        this.officeYardListVO = officeYardListVO;
    }

    /**
    * @return the officeYardListVOs
    */
    public OfficeYardListVO[] getOfficeYardListVOs() {
        return officeYardListVOs;
    }

    /**
    * @param officeYardListVOs the officeYardListVOs to set
    */
    public void setOfficeYardListVOs(OfficeYardListVO[] officeYardListVOs) {
        this.officeYardListVOs = officeYardListVOs;
    }

}
