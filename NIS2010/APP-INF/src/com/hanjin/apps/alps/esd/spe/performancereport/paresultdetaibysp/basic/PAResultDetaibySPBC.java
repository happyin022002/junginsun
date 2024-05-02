/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PAResultDetaibySPBC.java
*@FileTitle : Quantitative Analysis PA Result Detail by S/P
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.03.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancereport.paresultdetaibysp.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.spe.performancereport.paresultdetaibysp.vo.PAResultDetaibySPVO;
import com.hanjin.apps.alps.esd.spe.performancereport.sdanalysisresultdetail.vo.SpeSDAnalysisDtlVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Performancereport Business Logic Command Interface<br>
 * - ALPS-Performancereport에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author HI
 * @see
 * @since J2EE 1.6
 */

public interface PAResultDetaibySPBC {

	/**
	 * Quantitative Analysis : PA Result Detail by S/P 데이터를 조회한다.<br>
	 * 
	 * @param PAResultDetaibySPVO pAResultDetaibySPVO
	 * @return List<PAResultDetaibySPVO>
	 * @exception EventException
	 */
	public List<PAResultDetaibySPVO> searchPaResultDetaiSP(PAResultDetaibySPVO pAResultDetaibySPVO) throws EventException;		

}