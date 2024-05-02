/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsdAoc3104Event.java
*@FileTitle : Inland Cost Management Cost Detail(Asia)
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.event;

import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.vo.AsiaInlandCostAccountVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_AOC_3104 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_AOC_3104HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see ESD_AOC_3104HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdAoc3104Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	
	public EsdAoc3104Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AsiaInlandCostAccountVO asiaInlandCostAccountVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private AsiaInlandCostAccountVO[] asiaInlandCostAccountVOs = null;

	
	public AsiaInlandCostAccountVO getSearchInlandCostAccountVO() {
		return asiaInlandCostAccountVO;
	}

	public void setSearchInlandCostAccountVO(
			AsiaInlandCostAccountVO asiaInlandCostAccountVO) {
		this.asiaInlandCostAccountVO = asiaInlandCostAccountVO;
	}

	public AsiaInlandCostAccountVO[] getSearchInlandCostAccountVOs() {
		AsiaInlandCostAccountVO[] rtnVOs = null;
		if (this.asiaInlandCostAccountVOs != null) {
			rtnVOs = new AsiaInlandCostAccountVO[asiaInlandCostAccountVOs.length];
			System.arraycopy(asiaInlandCostAccountVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setSearchInlandCostAccountVOs(AsiaInlandCostAccountVO[] searchInlandCostAccountVOs){
		if(searchInlandCostAccountVOs != null){
			AsiaInlandCostAccountVO[] tmpVOs = new AsiaInlandCostAccountVO[searchInlandCostAccountVOs.length];
			System.arraycopy(searchInlandCostAccountVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.asiaInlandCostAccountVOs = tmpVOs;
		}
	}
	
}
