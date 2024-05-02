/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsdAoc3123Event.java
*@FileTitle : Ocean Feeder Cost Management - Cost Detail(Asia)
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2015.03.06 최성환 [CHM-201534710] AOC 2차 소스 보안 품질 진행 요청
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.event;

import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.vo.AsiaFeederCostAccountVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_AOC_3123 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_AOC_3123HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see ESD_AOC_3123HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdAoc3123Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	
	public EsdAoc3123Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AsiaFeederCostAccountVO asiaFeederCostAccountVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private AsiaFeederCostAccountVO[] asiaFeederCostAccountVOs = null;

	public AsiaFeederCostAccountVO getSearchOceanFeederCostAccountVO() {
		return asiaFeederCostAccountVO;
	}

	public void setSearchOceanFeederCostAccountVO(
			AsiaFeederCostAccountVO asiaFeederCostAccountVO) {
		this.asiaFeederCostAccountVO = asiaFeederCostAccountVO;
	}

	public AsiaFeederCostAccountVO[] getSearchOceanFeederCostAccountVOs() {
		AsiaFeederCostAccountVO[] rtnVOs = null;
		if (this.asiaFeederCostAccountVOs != null) {
			rtnVOs = new AsiaFeederCostAccountVO[asiaFeederCostAccountVOs.length];
			System.arraycopy(asiaFeederCostAccountVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setSearchOceanFeederCostAccountVOs(AsiaFeederCostAccountVO[] searchOceanFeederCostAccountVOs){
		if(searchOceanFeederCostAccountVOs != null){
			AsiaFeederCostAccountVO[] tmpVOs = new AsiaFeederCostAccountVO[searchOceanFeederCostAccountVOs.length];
			System.arraycopy(searchOceanFeederCostAccountVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.asiaFeederCostAccountVOs = tmpVOs;
		}
	}
}
