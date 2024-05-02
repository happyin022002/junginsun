/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : VopScg0105Event.java
*@FileTitle : Proper IBC Code
*@LastModifyDate : 2013.02.25
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2013.02.25 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================
* History
=========================================================*/
package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event;

import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.RsltCdListVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgPckReguPkgIbcCdVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * VOP_SCG_0105 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG_0105HTMLAction에서 작성<br>
 * - ServiceCommand Layer 로 전달하는 PDTO로 사용<br>
 *
 * @author CHLOE MIJIN SEO
 * @see VOP_SCG_0105HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg0105Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public VopScg0105Event(){}
	
	private String pkgCd = "";
	
	private String pkgCdSeq = "";
	
	private String dispNo = "";
	
	private ScgPckReguPkgIbcCdVO ScgPckReguPkgIbcCdVO = null;
	
	private ScgPckReguPkgIbcCdVO[] ScgPckReguPkgIbcCdVOs = null;
	
	private RsltCdListVO rsltCdListVO = null;
	
	
	/**
	 * @return the pkgCd
	 */
	public String getPkgCd() {
		return pkgCd;
	}

	/**
	 * @param pkgCd the pkgCd to set
	 */
	public void setPkgCd(String pkgCd) {
		this.pkgCd = pkgCd;
	}

	/**
	 * @return the pkgCdSeq
	 */
	public String getPkgCdSeq() {
		return pkgCdSeq;
	}

	/**
	 * @param pkgCdSeq the pkgCdSeq to set
	 */
	public void setPkgCdSeq(String pkgCdSeq) {
		this.pkgCdSeq = pkgCdSeq;
	}
	
	/**
	 * @return the dispNo
	 */
	public String getDispNo() {
		return dispNo;
	}

	/**
	 * @param dispNo the dispNo to set
	 */
	public void setDispNo(String dispNo) {
		this.dispNo = dispNo;
	}

	/**
	 * @return the scgPckReguPkgIbcCdVO
	 */
	public ScgPckReguPkgIbcCdVO getScgPckReguPkgIbcCdVO() {
		return ScgPckReguPkgIbcCdVO;
	}

	/**
	 * @param scgPckReguPkgIbcCdVO the scgPckReguPkgIbcCdVO to set
	 */
	public void setScgPckReguPkgIbcCdVO(ScgPckReguPkgIbcCdVO scgPckReguPkgIbcCdVO) {
		ScgPckReguPkgIbcCdVO = scgPckReguPkgIbcCdVO;
	}

	/**
	 * @return the ScgPckReguPkgIbcCdVOs
	 */
	public ScgPckReguPkgIbcCdVO[] getScgPckReguPkgIbcCdVOs() {
		ScgPckReguPkgIbcCdVO[] rtnVOs = null;
		if (this.ScgPckReguPkgIbcCdVOs != null) {
			rtnVOs = new ScgPckReguPkgIbcCdVO[ScgPckReguPkgIbcCdVOs.length];
			System.arraycopy(ScgPckReguPkgIbcCdVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param ScgPckReguPkgIbcCdVOs the ScgPckReguPkgIbcCdVOs to set
	 */
	public void setScgPckReguPkgIbcCdVOs(
			ScgPckReguPkgIbcCdVO[] ScgPckReguPkgIbcCdVOs) {
		if (ScgPckReguPkgIbcCdVOs != null) {
			ScgPckReguPkgIbcCdVO[] tmpVOs = new ScgPckReguPkgIbcCdVO[ScgPckReguPkgIbcCdVOs.length];
			System.arraycopy(ScgPckReguPkgIbcCdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.ScgPckReguPkgIbcCdVOs = tmpVOs;
		}
	}

	/**
	 * @return the rsltCdListVO
	 */
	public RsltCdListVO getRsltCdListVO() {
		return rsltCdListVO;
	}

	/**
	 * @param rsltCdListVO the rsltCdListVO to set
	 */
	public void setRsltCdListVO(RsltCdListVO rsltCdListVO) {
		this.rsltCdListVO = rsltCdListVO;
	}

}