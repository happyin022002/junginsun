/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0230Event.java
*@FileTitle : ACEP Candidate Cntr List
*Open Issues :
*Change history : 
*@LastModifyDate : 2009.10.22 	
*@LastModifier : 김완규 	
*@LastVersion : 1.0
* 2009.10.22 김완규  
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.event;

import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.ACEPListGRPVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 
/**
 * ees_mnr_0230 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_mnr_0230HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author 김완규
 * @see ees_mnr_0230HTMLAction 참조
 * @since J2EE 1.6   
 */    
      
public class EesMnr0230Event extends EventSupport { 

	private static final long serialVersionUID = 1L; 
	 
	public EesMnr0230Event(){}   

	private ACEPListGRPVO aCEPListGRPVO = null;

	public ACEPListGRPVO getACEPListGRPVO() {
		return aCEPListGRPVO;
	}

	public void setACEPListGRPVO(ACEPListGRPVO listGRPVO) {
		aCEPListGRPVO = listGRPVO;
	}
}