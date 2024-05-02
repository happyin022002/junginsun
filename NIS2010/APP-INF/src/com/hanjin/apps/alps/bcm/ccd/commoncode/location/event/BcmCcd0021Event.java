/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BcmCcd0021Event.java
*@FileTitle : zone
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.location.event;
 
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.ZoneGroupVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.vo.MdmDatProcVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * BCM_CCD_0021 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_0021HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see BCM_CCD_0021HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd0021Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public BcmCcd0021Event(){}
	
	private String znCd = null;
	
	private String repYdCd = null;
	
	private String rqstNo = null;
	
	private String locCd = null;
	
	private MdmDatProcVO mdmDatProcVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ZoneGroupVO zoneGroupVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ZoneGroupVO[] zoneGroupVOs = null;

	public String getZnCd() {
		return znCd;
	}

	public void setZnCd(String znCd) {
		this.znCd = znCd;
	}

	public String getRepYdCd() {
		return repYdCd;
	}

	public void setRepYdCd(String repYdCd) {
		this.repYdCd = repYdCd;
	}

	public ZoneGroupVO getZoneGroupVO() {
		return zoneGroupVO;
	}

	public void setZoneGroupVO(ZoneGroupVO zoneGroupVO) {
		this.zoneGroupVO = zoneGroupVO;
	}

	public ZoneGroupVO[] getZoneGroupVOs() {
		ZoneGroupVO[] rtnVOs = null;
		if (this.zoneGroupVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(zoneGroupVOs, zoneGroupVOs.length);
		}
		return rtnVOs;
	}

	public void setZoneGroupVOs(ZoneGroupVO[] zoneGroupVOs){
		if(zoneGroupVOs != null){
			ZoneGroupVO[] tmpVOs = java.util.Arrays.copyOf(zoneGroupVOs, zoneGroupVOs.length);
			this.zoneGroupVOs = tmpVOs;
		}
	}
	
	public String getRqstNo() {
		return rqstNo;
	}
	
	public void setRqstNo(String rqstNo) {
		this.rqstNo = rqstNo;
	}
	
	public String getLocCd() {
		return locCd;
	}
	
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	public MdmDatProcVO getMdmDatProcVO() {
		return mdmDatProcVO;
	}

	public void setMdmDatProcVO(MdmDatProcVO mdmDatProcVO) {
		this.mdmDatProcVO = mdmDatProcVO;
	}
	
}