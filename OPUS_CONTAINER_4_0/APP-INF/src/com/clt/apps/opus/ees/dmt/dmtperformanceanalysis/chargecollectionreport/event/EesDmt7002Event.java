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

package com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecollectionreport.event;

import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo.CollectionOfficeFinderVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo.OfficeYardListVO;
import com.clt.framework.support.layer.event.EventSupport;

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
    	CollectionOfficeFinderVO[] tmpVOs = null;
		if (this.collectionOfficeFinderVOs != null) {
			tmpVOs = new CollectionOfficeFinderVO[collectionOfficeFinderVOs.length];
			System.arraycopy(collectionOfficeFinderVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
    }

    /**
    * @param collectionOfficeFinderVOs the collectionOfficeFinderVOs to set
    */
    public void setCollectionOfficeFinderVOs(
            CollectionOfficeFinderVO[] collectionOfficeFinderVOs) {
    	if (collectionOfficeFinderVOs != null) {
    		CollectionOfficeFinderVO[] tmpVOs = new CollectionOfficeFinderVO[collectionOfficeFinderVOs.length];
			System.arraycopy(collectionOfficeFinderVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.collectionOfficeFinderVOs = tmpVOs;
		}
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
    	OfficeYardListVO[] tmpVOs = null;
		if (this.officeYardListVOs != null) {
			tmpVOs = new OfficeYardListVO[officeYardListVOs.length];
			System.arraycopy(officeYardListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
    }

    /**
    * @param officeYardListVOs the officeYardListVOs to set
    */
    public void setOfficeYardListVOs(OfficeYardListVO[] officeYardListVOs) {
    	if (officeYardListVOs != null) {
    		OfficeYardListVO[] tmpVOs = new OfficeYardListVO[officeYardListVOs.length];
			System.arraycopy(officeYardListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.officeYardListVOs = tmpVOs;
		}
    }

}
