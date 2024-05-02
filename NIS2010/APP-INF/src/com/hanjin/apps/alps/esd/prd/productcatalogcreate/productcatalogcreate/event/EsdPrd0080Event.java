/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdPrd0080Event.java
*@FileTitle : ProductCatalogCreate
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.22
*@LastModifier : 정선용
*@LastVersion : 1.0
* 2009.08.22 정선용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.event;

import com.hanjin.apps.alps.esd.prd.common.prdcreate.vo.PrdPcCreateVO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdCnstRemarkVO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdCreateParamVO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdQuantityVO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdSearchParamVO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdSubQuantityVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_PRD_0080 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_PRD_0080HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author sun yong Jung
 * @see ESD_PRD_0080HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdPrd0080Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PrdCreateParamVO prdCreateParamVO = null;
	
	public PrdCreateParamVO getPrdCreateParamVO() {
		return prdCreateParamVO;
	}

	public void setPrdCreateParamVO(PrdCreateParamVO prdCreateParamVO) {
		this.prdCreateParamVO = prdCreateParamVO;
	}

	private PrdPcCreateVO prdPcCreateVO = null;
	
	public PrdPcCreateVO getPrdPcCreateVO() {
		return prdPcCreateVO;
	}

	public void setPrdPcCreateVO(PrdPcCreateVO prdPcCreateVO) {
		this.prdPcCreateVO = prdPcCreateVO;
	}
	
	/** Constraint Remarking 처리 */
	private PrdCnstRemarkVO prdCnstRemarkVO = null;
	
	public PrdCnstRemarkVO getPrdCnstRemarkVO() {
		return prdCnstRemarkVO;
	}

	public void setPrdCnstRemarkVO(PrdCnstRemarkVO prdCnstRemarkVO) {
		this.prdCnstRemarkVO = prdCnstRemarkVO;
	}	
	
	
	/** Table Value Object Multi Data 처리 */
	private PrdQuantityVO[] prdQuantityVOs = null;
//	/** Table Value Object Multi Data 처리 */

	private PrdSubQuantityVO[] prdSubQuantityVOs = null;

	private PrdSearchParamVO prdSearchParamVO = null;

	public PrdSearchParamVO getPrdSearchParamVO() {
		return prdSearchParamVO;
	}

	public PrdSubQuantityVO[] getPrdSubQuantityVOs() {
		return prdSubQuantityVOs;
	}

	public PrdQuantityVO[] getPrdQuantityVOs() {
		return prdQuantityVOs;
	}

	public void setPrdQuantityVOs(PrdQuantityVO[] prdQuantityVOs) {
		this.prdQuantityVOs = prdQuantityVOs;
	}

	public EsdPrd0080Event(){}
	
 
 

	public void setPrdSubQuantityVOs(PrdSubQuantityVO[] prdSubQuantityVOs) {
		// TODO Auto-generated method stub
		this.prdSubQuantityVOs = prdSubQuantityVOs;
		
	}

	public void setPrdSearchParamVO(PrdSearchParamVO vo) {
		// TODO Auto-generated method stub
		this.prdSearchParamVO = vo;
	}
 

}