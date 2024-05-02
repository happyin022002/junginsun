/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0464Event.java
*@FileTitle : bookringreport
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.06.10 강동윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import java.util.Arrays;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.ProductionRatioVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.ProductionRatioDetailVO;


/**
 * ESM_BKG_0464 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0464HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kang dong yun
 * @see ESM_BKG_0464HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0464Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ProductionRatioVO productionRatioVO = null;
		
	/** Table Value Object Multi Data 처리 */
	private ProductionRatioVO[] productionRatioVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private ProductionRatioDetailVO[] productionRatioDetailVOs = null;

	public EsmBkg0464Event(){}
	
	public void setProductionRatioVO(ProductionRatioVO productionRatioVO){
		this. productionRatioVO = productionRatioVO;
	}

	public ProductionRatioVO getProductionRatioVO() {
		return productionRatioVO;
	}
	
	public void setProductionRatioVOS(ProductionRatioVO[] productionRatioVOs){
		if(productionRatioVOs != null){
			ProductionRatioVO[] tmpVOs = Arrays.copyOf(productionRatioVOs, productionRatioVOs.length);
			this.productionRatioVOs = tmpVOs;
		}
	}

	public void setProductionRatioDetailVOS(ProductionRatioDetailVO[] productionRatioDetailVOs){
		if(productionRatioDetailVOs != null){
			ProductionRatioDetailVO[] tmpVOs = Arrays.copyOf(productionRatioDetailVOs, productionRatioDetailVOs.length);
			this.productionRatioDetailVOs = tmpVOs;
		}
	}
	
	
}