/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1045Event.java
*@FileTitle : Awakward Cargo Application
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.13
*@LastModifier : 이병규
*@LastVersion : 1.0
* 2009.06.10 이병규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.DgPackageVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1045 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1045HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Byung Kyu 
 * @see ESM_BKG_1045HTMLAction에서 참조
 * @since J2EE 1.6
 */

public class EsmBkg1045Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	
	private DgPackageVO dgPackageVO = null;
	private String code = null;
    private String desc = null;
    private String pckTpCd = null;
    private String evntUsrId = null;
    private String evntDt = null;
    private String awkCgoSeq = null;    

	/** Table Value Object Multi Data 처리 */
	private DgPackageVO[] dgPackageVOs = null;

	public EsmBkg1045Event(){}

	/**
	 * @return the dgPackageVO
	 */
	public DgPackageVO getDgPackageVO() {
		return dgPackageVO;
	}

	/**
	 * @param dgPackageVO the dgPackageVO to set
	 */
	public void setDgPackageVO(DgPackageVO dgPackageVO) {
		this.dgPackageVO = dgPackageVO;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * @return the pckTpCd
	 */
	public String getPckTpCd() {
		return pckTpCd;
	}

	/**
	 * @param pckTpCd the pckTpCd to set
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}

	/**
	 * @return the evntUsrId
	 */
	public String getEvntUsrId() {
		return evntUsrId;
	}

	/**
	 * @param evntUsrId the evntUsrId to set
	 */
	public void setEvntUsrId(String evntUsrId) {
		this.evntUsrId = evntUsrId;
	}

	/**
	 * @return the evntDt
	 */
	public String getEvntDt() {
		return evntDt;
	}

	/**
	 * @param evntDt the evntDt to set
	 */
	public void setEvntDt(String evntDt) {
		this.evntDt = evntDt;
	}

	/**
	 * @return the awkCgoSeq
	 */
	public String getAwkCgoSeq() {
		return awkCgoSeq;
	}

	/**
	 * @param awkCgoSeq the awkCgoSeq to set
	 */
	public void setAwkCgoSeq(String awkCgoSeq) {
		this.awkCgoSeq = awkCgoSeq;
	}

	/**
	 * @return the dgPackageVOs
	 */
	public DgPackageVO[] getDgPackageVOs() {
		DgPackageVO[] rtnVOs = null;
		if (this.dgPackageVOs != null) {
			rtnVOs = Arrays.copyOf(dgPackageVOs, dgPackageVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param dgPackageVOs the dgPackageVOs to set
	 */
	public void setDgPackageVOs(DgPackageVO[] dgPackageVOs) {
		if(dgPackageVOs != null){
			DgPackageVO[] tmpVOs = Arrays.copyOf(dgPackageVOs, dgPackageVOs.length);
			this.dgPackageVOs = tmpVOs;
		}
	}

	/**
	 * @return the serialVersionUID
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

}