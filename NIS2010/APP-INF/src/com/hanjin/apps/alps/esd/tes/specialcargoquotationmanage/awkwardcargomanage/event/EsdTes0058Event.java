/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTes0058Event.java
*@FileTitle : Select Cost for Break Bulk
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.13
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.02.13 이혜민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.event;


import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.vo.TesBbCgoCostVO;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.vo.TesBbCgoDtlVO;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.vo.BlCustomerInfoVO;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.vo.BbCntrListVO;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.vo.BkgBbCgoVO;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.vo.CntrTypzQtyVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TesTmlSoBbDtlVO;
import com.hanjin.syscommon.common.table.TesTmlSoDtlVO;



/**
 * ESD_TES_0058 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TES_0058HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 이혜민
 * @see EsdTes0058Event 참조
 * @since J2EE 1.6
 */

public class EsdTes0058Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgBbCgoVO bkgBbCgoVO = null;
	private BbCntrListVO bbCntrListVO = null;
	private CntrTypzQtyVO cntrTypzQtyVO = null;
	private BlCustomerInfoVO blCustomerInfoVO = null;
	private TesBbCgoCostVO tesBbCgoCostVO = null;
	private TesTmlSoBbDtlVO tesTmlSoBbDtlVO = null;
	private TesTmlSoDtlVO tesTmlSoDtlVO = null;
	private TesBbCgoDtlVO tesBbCgoDtlVO = null;
	
	private String bkgNo = null;
  
	/** Table Value Object Multi Data 처리 */
	private BkgBbCgoVO[] bkgBbCgoVOs = null;
	private BbCntrListVO[] bbCntrListVOs = null;
	private CntrTypzQtyVO[] cntrTypzQtyVOs = null;
	private BlCustomerInfoVO[] blCustomerInfoVOs = null;
	private TesBbCgoCostVO[] tesBbCgoCostVOs = null;
	private TesTmlSoBbDtlVO[] tesTmlSoBbDtlVOs = null;
	private TesTmlSoDtlVO[] tesTmlSoDtlVOs = null;
	private TesBbCgoDtlVO[] tesBbCgoDtlVOs = null;

	public EsdTes0058Event(){}
	
	/**
	 * @return the bkgBbCgoVO
	 */
	public BkgBbCgoVO getBkgBbCgoVO() {
		return bkgBbCgoVO;
	}

	/**
	 * @param bkgBbCgoVO the bkgBbCgoVO to set
	 */
	public void setBkgBbCgoVO(BkgBbCgoVO bkgBbCgoVO) {
		this.bkgBbCgoVO = bkgBbCgoVO;
	}

	/**
	 * @return the tesBbCgoDtlVO
	 */
	public TesBbCgoDtlVO getTesBbCgoDtlVO() {
		return tesBbCgoDtlVO;
	}

	/**
	 * @param tesBbCgoDtlVO the tesBbCgoDtlVO to set
	 */
	public void setTesBbCgoDtlVO(TesBbCgoDtlVO tesBbCgoDtlVO) {
		this.tesBbCgoDtlVO = tesBbCgoDtlVO;
	}
	
	/**
	 * @return the tesTmlSoBbDtlVO
	 */
	public TesTmlSoBbDtlVO getTesTmlSoBbDtlVO() {
		return tesTmlSoBbDtlVO;
	}

	/**
	 * @param tesTmlSoBbDtlVO the tesTmlSoBbDtlVO to set
	 */
	public void setTesTmlSoBbDtlVO(TesTmlSoBbDtlVO tesTmlSoBbDtlVO) {
		this.tesTmlSoBbDtlVO = tesTmlSoBbDtlVO;
	}
	
	/**
	 * @return the tesTmlSoDtlVO
	 */
	public TesTmlSoDtlVO getTesTmlSoDtlVO() {
		return tesTmlSoDtlVO;
	}

	/**
	 * @param tesTmlSoDtlVO the tesTmlSoDtlVO to set
	 */
	public void setTesTmlSoDtlVO(TesTmlSoDtlVO tesTmlSoDtlVO) {
		this.tesTmlSoDtlVO = tesTmlSoDtlVO;
	}
	
	/**
	 * @return the tesBbCgoCostVO
	 */
	public TesBbCgoCostVO getTesBbCgoCostVO() {
		return tesBbCgoCostVO;
	}

	/**
	 * @param tesBbCgoCostVO the tesBbCgoCostVO to set
	 */
	public void setTesBbCgoCostVO(TesBbCgoCostVO tesBbCgoCostVO) {
		this.tesBbCgoCostVO = tesBbCgoCostVO;
	}

	/**
	 * @return the blCustomerInfoVO
	 */
	public BlCustomerInfoVO getBlCustomerInfoVO() {
		return blCustomerInfoVO;
	}

	/**
	 * @param blCustomerInfoVO the blCustomerInfoVO to set
	 */
	public void setBlCustomerInfoVO(BlCustomerInfoVO blCustomerInfoVO) {
		this.blCustomerInfoVO = blCustomerInfoVO;
	}
	
	/**
	 * @return the bbCntrListVO
	 */
	public BbCntrListVO getBbCntrListVO() {
		return bbCntrListVO;
	}

	/**
	 * @param bbCntrListVO the bbCntrListVO to set
	 */
	public void setBbCntrListVO(BbCntrListVO bbCntrListVO) {
		this.bbCntrListVO = bbCntrListVO;
	}

	/**
	 * @return the cntrTypzQtyVO
	 */
	public CntrTypzQtyVO getCntrTypzQtyVO() {
		return cntrTypzQtyVO;
	}

	/**
	 * @param cntrTypzQtyVO the cntrTypzQtyVO to set
	 */
	public void setCntrTypzQtyVO(CntrTypzQtyVO cntrTypzQtyVO) {
		this.cntrTypzQtyVO = cntrTypzQtyVO;
	}

	/**
	 * @return the bkgNo
	 */
	public String getBkgNo() {
		return bkgNo;
	}

	/**
	 * @param bkgNo the bkgNo to set
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	/**
	 * @return the tesTmlSoBbDtlVOs
	 */
	public TesTmlSoBbDtlVO[] getTesTmlSoBbDtlVOs() {
		return tesTmlSoBbDtlVOs;
	}

	/**
	 * @param tesTmlSoBbDtlVOs the tesTmlSoBbDtlVOs to set
	 */
	public void setTesTmlSoBbDtlVOs(TesTmlSoBbDtlVO[] tesTmlSoBbDtlVOs) {
		this.tesTmlSoBbDtlVOs = tesTmlSoBbDtlVOs;
	}
	
	/**
	 * @return the tesTmlSoDtlVOs
	 */
	public TesTmlSoDtlVO[] getTesTmlSoDtlVOs() {
		return tesTmlSoDtlVOs;
	}

	/**
	 * @param tesTmlSoDtlVOs the tesTmlSoDtlVOs to set
	 */
	public void setTesTmlSoDtlVOs(TesTmlSoDtlVO[] tesTmlSoDtlVOs) {
		this.tesTmlSoDtlVOs = tesTmlSoDtlVOs;
	}
	
	/**
	 * @return the bkgBbCgoVOs
	 */
	public BkgBbCgoVO[] getBkgBbCgoVOs() {
		return bkgBbCgoVOs;
	}

	/**
	 * @param bkgBbCgoVOs the bkgBbCgoVOs to set
	 */
	public void setBkgBbCgoVOs(BkgBbCgoVO[] bkgBbCgoVOs) {
		this.bkgBbCgoVOs = bkgBbCgoVOs;
	}
	
	/**
	 * @return the tesBbCgoDtlVOs
	 */
	public TesBbCgoDtlVO[] getTesBbCgoDtlVOs() {
		return tesBbCgoDtlVOs;
	}

	/**
	 * @param tesBbCgoDtlVOs the tesBbCgoDtlVOs to set
	 */
	public void setTesBbCgoDtlVOs(TesBbCgoDtlVO[] tesBbCgoDtlVOs) {
		this.tesBbCgoDtlVOs = tesBbCgoDtlVOs;
	}
	
	/**
	 * @return the tesBbCgoCostVOs
	 */
	public TesBbCgoCostVO[] getTesBbCgoCostVOs() {
		return tesBbCgoCostVOs;
	}

	/**
	 * @param tesBbCgoCostVOs the tesBbCgoCostVOs to set
	 */
	public void setTesBbCgoCostVOs(TesBbCgoCostVO[] tesBbCgoCostVOs) {
		this.tesBbCgoCostVOs = tesBbCgoCostVOs;
	}

	/**
	 * @return the blCustomerInfoVOs
	 */
	public BlCustomerInfoVO[] getBlCustomerInfoVOs() {
		return blCustomerInfoVOs;
	}

	/**
	 * @param blCustomerInfoVOs the blCustomerInfoVOs to set
	 */
	public void setBlCustomerInfoVOs(BlCustomerInfoVO[] blCustomerInfoVOs) {
		this.blCustomerInfoVOs = blCustomerInfoVOs;
	}
	
	/**
	 * @return the bbCntrListVOs
	 */
	public BbCntrListVO[] getBbCntrListVOs() {
		return bbCntrListVOs;
	}

	/**
	 * @param bbCntrListVOs the bbCntrListVOs to set
	 */
	public void setBbCntrListVOs(BbCntrListVO[] bbCntrListVOs) {
		this.bbCntrListVOs = bbCntrListVOs;
	}

	/**
	 * @return the cntrTypzQtyVOs
	 */
	public CntrTypzQtyVO[] getCntrTypzQtyVOs() {
		return cntrTypzQtyVOs;
	}

	/**
	 * @param cntrTypzQtyVOs the cntrTypzQtyVOs to set
	 */
	public void setCntrTypzQtyVOs(CntrTypzQtyVO[] cntrTypzQtyVOs) {
		this.cntrTypzQtyVOs = cntrTypzQtyVOs;
	}

	
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}



}