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
package com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.event;

import com.clt.apps.opus.esd.prd.common.prdcreate.vo.PrdPcCreateVO;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdCnstRemarkVO;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdCreateParamVO;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdQuantityVO;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdSearchParamVO;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdSubQuantityVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESD_PRD_0080 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_PRD_0080HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author sun yong Jung
 * @see ESD_PRD_0080HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsdPrd0080Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private PrdCreateParamVO prdCreateParamVO = null;

	private PrdSearchParamVO prdSearchParamVO = null;

	/** Constraint Remarking 처리 */
	private PrdCnstRemarkVO prdCnstRemarkVO = null;

	private PrdPcCreateVO prdPcCreateVO = null;

	/** Table Value Object Multi Data 처리 */
	private PrdQuantityVO[] prdQuantityVOs = null;

	private PrdSubQuantityVO[] prdSubQuantityVOs = null;

	public EsdPrd0080Event() {
	}

	public PrdCreateParamVO getPrdCreateParamVO() {
		return prdCreateParamVO;
	}

	public void setPrdCreateParamVO(PrdCreateParamVO prdCreateParamVO) {
		this.prdCreateParamVO = prdCreateParamVO;
	}

	public PrdSearchParamVO getPrdSearchParamVO() {
		return prdSearchParamVO;
	}

	public void setPrdSearchParamVO(PrdSearchParamVO prdSearchParamVO) {
		this.prdSearchParamVO = prdSearchParamVO;
	}

	public PrdCnstRemarkVO getPrdCnstRemarkVO() {
		return prdCnstRemarkVO;
	}

	public void setPrdCnstRemarkVO(PrdCnstRemarkVO prdCnstRemarkVO) {
		this.prdCnstRemarkVO = prdCnstRemarkVO;
	}

	public PrdPcCreateVO getPrdPcCreateVO() {
		return prdPcCreateVO;
	}

	public void setPrdPcCreateVO(PrdPcCreateVO prdPcCreateVO) {
		this.prdPcCreateVO = prdPcCreateVO;
	}

	public PrdQuantityVO[] getPrdQuantityVOs() {
		PrdQuantityVO[] tmpVOs = null;
		if (this.prdQuantityVOs != null) {
			tmpVOs = new PrdQuantityVO[this.prdQuantityVOs.length];
			System.arraycopy(this.prdQuantityVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setPrdQuantityVOs(PrdQuantityVO[] prdQuantityVOs) {
		if (prdQuantityVOs != null) {
			PrdQuantityVO[] tmpVOs = new PrdQuantityVO[prdQuantityVOs.length];
			System.arraycopy(prdQuantityVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.prdQuantityVOs = tmpVOs;
		}
	}

	public PrdSubQuantityVO[] getPrdSubQuantityVOs() {
		PrdSubQuantityVO[] tmpVOs = null;
		if (this.prdSubQuantityVOs != null) {
			tmpVOs = new PrdSubQuantityVO[this.prdSubQuantityVOs.length];
			System.arraycopy(this.prdSubQuantityVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setPrdSubQuantityVOs(PrdSubQuantityVO[] prdSubQuantityVOs) {
		if (prdSubQuantityVOs != null) {
			PrdSubQuantityVO[] tmpVOs = new PrdSubQuantityVO[prdSubQuantityVOs.length];
			System.arraycopy(prdSubQuantityVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.prdSubQuantityVOs = tmpVOs;
		}
	}
}