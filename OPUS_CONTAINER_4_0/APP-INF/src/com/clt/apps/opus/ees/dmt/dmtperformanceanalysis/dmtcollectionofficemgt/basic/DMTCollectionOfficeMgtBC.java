/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCollectionOfficeMgtBC.java
*@FileTitle : DEM/DET Office Inquiry by Yard
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.basic;

import java.util.List;

import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.vo.CollectionOfficeFinderVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.vo.OfficeYardListVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * Dmtperformanceanalysis Business Logic Command Interface<br>
 * 
 * @author
 * @see DMTCollectionOfficeMgtBCImpl class reference
 * @since J2EE 1.6
 */

public interface DMTCollectionOfficeMgtBC {
    /**
     * [DEM/DET Office Inquiry by Yard] [SEARCH].<br>
     * 
     * @param CollectionOfficeFinderVO CollectionOfficeFinderVO
     * @return List<OfficeYardListVO>
     * @exception EventException
     */
    public List<OfficeYardListVO> searchCollectionOfficeList ( CollectionOfficeFinderVO CollectionOfficeFinderVO ) throws EventException;
}
