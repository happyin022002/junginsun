/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VskGloEvent.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.05.21 유혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.event;

import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.CodeInfoVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.LocationVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.PfLaneTypeVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.RqstSimNoVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VesselVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VslSvcLaneforBudgetVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VvdPortLaneOtherVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MdmCountryVO;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;


/**
 * VSK_GLO 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VSK_GLO_HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ryu Hyuk
 * @see VOP_GLO_HTMLAction 참조
 * @since J2EE 1.4
 */

public class VskGloEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** 업무 구분자 */
	private String op;
	
	/** MdmVslSvcLaneVO 조회 조건 및 단건 처리  */
	private MdmVslSvcLaneVO mdmVslSvcLaneVO = null;
	
	/** MdmVslSvcLaneVO Multi Data 처리 */
	private MdmVslSvcLaneVO[] mdmVslSvcLaneVOs = null;
	
	/** LocationVO 조회 조건 및 단건 처리  */
	private LocationVO locationVO = null;
	
	/** LocationVO Multi Data 처리 */
	private LocationVO[] locationVOs = null;
	
	/** VesselVO 조회 조건 및 단건 처리  */
	private VesselVO vesselVO = null;
	
	/** VesselVO Multi Data 처리 */
	private VesselVO[] vesselVOs = null;
	
	/** MdmCountryVO 조회 조건 및 단건 처리  */
	private MdmCountryVO mdmCountryVO = null;
	
	/** MdmCountryVO Multi Data 처리 */
	private MdmCountryVO[] mdmCountryVOs = null;
	
	/** PfLaneTypeVO 조회 조건 및 단건 처리  */
	private PfLaneTypeVO pfLaneTypeVO = null;
	
	/** PfLaneTypeVO Multi Data 처리 */
	private PfLaneTypeVO[] pfLaneTypeVOs = null;
	
	/** VvdPortLaneOtherVO 조회 조건 및 단건 처리  */
	private VvdPortLaneOtherVO vvdPortLaneOtherVO = null;
	
	/** VvdPortLaneOtherVO Multi Data 처리 */
	private VvdPortLaneOtherVO[] vvdPortLaneOtherVOs = null;
	
	/** RqstSimNoVO 조회 조건 및 단건 처리  */
	private RqstSimNoVO rqstSimNoVO = null;
	
	/** RqstSimNoVO Multi Data 처리 */
	private RqstSimNoVO[] rqstSimNoVOs = null;
	
	/** CodeInfoVO 조회 조건 및 단건 처리  */
	private CodeInfoVO codeInfoVO = null;
	
	/** CodeInfoVO Multi Data 처리 */
	private CodeInfoVO[] codeInfoVOs = null;
	
	private VslSvcLaneforBudgetVO vslSvcLaneforBudgetVO	= null;
	
	
	public VskGloEvent(){}
	
	/**
	 * 업무 구분자를 구한다.
	 * 
	 * @return String
	 */
	public String getOp() {
		return op;
	}

	/**
	 * 업무 구분자를 설정한다.
	 * 
	 * @param op String
	 */
	public void setOp(String op) {
		this.op = op;
	}

	/**
	 * MdmVslSvcLaneVO 정보를 설정한다.
	 * 
	 * @param mdmVslSvcLaneVO MdmVslSvcLaneVO
	 */
	public void setMdmVslSvcLaneVO(MdmVslSvcLaneVO mdmVslSvcLaneVO){
		this.mdmVslSvcLaneVO = mdmVslSvcLaneVO;
	}

	/**
	 * MdmVslSvcLaneVO 다건 정보를 설정한다. 
	 * 
	 * @param mdmVslSvcLaneVOs MdmVslSvcLaneVO[]
	 */
	public void setMdmVslSvcLaneVOS(MdmVslSvcLaneVO[] mdmVslSvcLaneVOs){
		if(mdmVslSvcLaneVOs != null){
			MdmVslSvcLaneVO[] tmpVOs = new MdmVslSvcLaneVO[mdmVslSvcLaneVOs.length];
			System.arraycopy(mdmVslSvcLaneVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mdmVslSvcLaneVOs = tmpVOs;
		}
		//소스보안 2015.07.16
		//this. mdmVslSvcLaneVOs = mdmVslSvcLaneVOs;
	}

	/**
	 * MdmVslSvcLaneVO 정보를 구한다.
	 * 
	 * @return MdmVslSvcLaneVO
	 */
	public MdmVslSvcLaneVO getMdmVslSvcLaneVO(){
		return mdmVslSvcLaneVO;
	}

	/**
	 * MdmVslSvcLaneVO 다건 정보를 구한다.
	 * 
	 * @return rtnVOs
	 */
	public MdmVslSvcLaneVO[] getMdmVslSvcLaneVOS(){
		MdmVslSvcLaneVO[] rtnVOs =  null;
		if(this.mdmVslSvcLaneVOs != null){
			rtnVOs = new MdmVslSvcLaneVO[mdmVslSvcLaneVOs.length];
			System.arraycopy(mdmVslSvcLaneVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.16
		//return mdmVslSvcLaneVOs;
	}

	/**
	 * LocationVO 정보를 설정한다.
	 * 
	 * @param locationVO
	 */
	public void setLocationVO(LocationVO locationVO){
		this. locationVO = locationVO;
	}

	/**
	 * LocationVO 다건 정보를 설정한다.
	 * 
	 * @param locationVOs
	 */
	public void setLocationVOS(LocationVO[] locationVOs){
		if(locationVOs != null){
			LocationVO[] tmpVOs = new LocationVO[locationVOs.length];
			System.arraycopy(locationVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.locationVOs = tmpVOs;
		}
		//소스보안 2015.07.16
		//this. locationVOs = locationVOs;
	}

	/**
	 * LocationVO 정보를 구한다.
	 * 
	 * @return LocationVO
	 */
	public LocationVO getLocationVO(){
		return locationVO;
	}

	/**
	 * LocationVO 다건 정보를 구한다.
	 * 
	 * @return rtnVOs
	 */
	public LocationVO[] getLocationVOS(){
		LocationVO[] rtnVOs =  null;
		if(this.locationVOs != null){
			rtnVOs = new LocationVO[locationVOs.length];
			System.arraycopy(locationVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.16
		//return locationVOs;
	}
	
	
	
	/**
	 * LocationVO 다건 정보를 구한다.
	 * 
	 * @return LocationVO[]
	 */
	public VslSvcLaneforBudgetVO getVslSvcLaneforBudgetVO(){
		return this.vslSvcLaneforBudgetVO;
	}
	
	/**
	 * VesselVO 정보를 설정한다.
	 * 
	 * @param vesselVO
	 */
	public void setVesselVO(VesselVO vesselVO){
		this.vesselVO = vesselVO;
	}

	/**
	 * VesselVO 다건 정보를 설정한다.
	 * 
	 * @param vesselVOs
	 */
	public void setVesselVOS(VesselVO[] vesselVOs){
		if(vesselVOs != null){
			VesselVO[] tmpVOs = new VesselVO[vesselVOs.length];
			System.arraycopy(vesselVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vesselVOs = tmpVOs;
		}
		//소스보안 2015.07.16
		//this.vesselVOs = vesselVOs;
	}

	/**
	 * VesselVO 정보를 구한다.
	 * 
	 * @return VesselVO
	 */
	public VesselVO getVesselVO(){
		return vesselVO;
	}

	/**
	 * VesselVO 다건 정보를 구한다.
	 * 
	 * @return VesselVO[]
	 */
	public VesselVO[] getVesselVOS(){
		VesselVO[] rtnVOs =  null;
		if(this.vesselVOs != null){
			rtnVOs = new VesselVO[vesselVOs.length];
			System.arraycopy(vesselVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.16
		//return vesselVOs;
	}
	
	/**
	 * MdmCountryVO 정보를 설정한다.
	 * 
	 * @param mdmCountryVO
	 */
	public void setMdmCountryVO(MdmCountryVO mdmCountryVO){
		this. mdmCountryVO = mdmCountryVO;
	}

	/**
	 * MdmCountryVO 다건 정보를 설정한다.
	 * 
	 * @param mdmCountryVOs
	 */
	public void setMdmCountryVOS(MdmCountryVO[] mdmCountryVOs){
		if(mdmCountryVOs != null){
			MdmCountryVO[] tmpVOs = new MdmCountryVO[mdmCountryVOs.length];
			System.arraycopy(mdmCountryVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mdmCountryVOs = tmpVOs;
		}
		//소스보안 2015.07.16
		//this. mdmCountryVOs = mdmCountryVOs;
	}

	/**
	 * MdmCountryVO 정보를 구한다.
	 * 
	 * @return MdmCountryVO
	 */
	public MdmCountryVO getMdmCountryVO(){
		return mdmCountryVO;
	}

	/**
	 * MdmCountryVO 다건 정보를 구한다.
	 * 
	 * @return MdmCountryVO[]
	 */
	public MdmCountryVO[] getMdmCountryVOS(){
		MdmCountryVO[] rtnVOs =  null;
		if(this.mdmCountryVOs != null){
			rtnVOs = new MdmCountryVO[mdmCountryVOs.length];
			System.arraycopy(mdmCountryVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.16
		//return mdmCountryVOs;
	}
	
	/**
	 * PfLaneTypeVO 정보를 설정한다.
	 * 
	 * @param pfLaneTypeVO
	 */
	public void setPfLaneTypeVO(PfLaneTypeVO pfLaneTypeVO){
		this.pfLaneTypeVO = pfLaneTypeVO;
	}

	/**
	 * PfLaneTypeVO 다건 정보를 설정한다.
	 * 
	 * @param pfLaneTypeVOs
	 */
	public void setPfLaneTypeVOS(PfLaneTypeVO[] pfLaneTypeVOs){
		if(pfLaneTypeVOs != null){
			PfLaneTypeVO[] tmpVOs = new PfLaneTypeVO[pfLaneTypeVOs.length];
			System.arraycopy(pfLaneTypeVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.pfLaneTypeVOs = tmpVOs;
		}
		//소스보안 2015.07.16
		//this.pfLaneTypeVOs = pfLaneTypeVOs;
	}

	/**
	 * PfLaneTypeVO 정보를 구한다.
	 * 
	 * @return MdmCountryVO
	 */
	public PfLaneTypeVO getPfLaneTypeVO(){
		return pfLaneTypeVO;
	}

	/**
	 * PfLaneTypeVO 다건 정보를 구한다.
	 * 
	 * @return rtnVOs
	 */
	public PfLaneTypeVO[] getPfLaneTypeVOS(){
		PfLaneTypeVO[] rtnVOs =  null;
		if(this.pfLaneTypeVOs != null){
			rtnVOs = new PfLaneTypeVO[pfLaneTypeVOs.length];
			System.arraycopy(pfLaneTypeVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.16
		//return pfLaneTypeVOs;
	}

	/**
	 * VvdPortLaneOtherVO 정보를 구한다.
	 * 
	 * @return VvdPortLaneOtherVO
	 */
	public VvdPortLaneOtherVO getVvdPortLaneOtherVO() {
		return vvdPortLaneOtherVO;
	}

	/**
	 * VvdPortLaneOtherVO 정보를 설정한다.
	 * 
	 * @param vvdPortLaneOtherVO VvdPortLaneOtherVO
	 */
	public void setVvdPortLaneOtherVO(VvdPortLaneOtherVO vvdPortLaneOtherVO) {
		this.vvdPortLaneOtherVO = vvdPortLaneOtherVO;
	}

	/**
	 * VvdPortLaneOtherVO 다건 정보를 구한다.
	 * 
	 * @return rtnVOs
	 */
	public VvdPortLaneOtherVO[] getVvdPortLaneOtherVOs() {
		VvdPortLaneOtherVO[] rtnVOs =  null;
		if(this.vvdPortLaneOtherVOs != null){
			rtnVOs = new VvdPortLaneOtherVO[vvdPortLaneOtherVOs.length];
			System.arraycopy(vvdPortLaneOtherVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.16
		//return vvdPortLaneOtherVOs;
	}

	/**
	 * VvdPortLaneOtherVO 다건 정보를 설정한다.
	 * 
	 * @param vvdPortLaneOtherVOs VvdPortLaneOtherVO[]
	 */
	public void setVvdPortLaneOtherVOs(VvdPortLaneOtherVO[] vvdPortLaneOtherVOs) {
		if(vvdPortLaneOtherVOs != null){
			VvdPortLaneOtherVO[] tmpVOs = new VvdPortLaneOtherVO[vvdPortLaneOtherVOs.length];
			System.arraycopy(vvdPortLaneOtherVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vvdPortLaneOtherVOs = tmpVOs;
		}
		//소스보안 2015.07.16
		//this.vvdPortLaneOtherVOs = vvdPortLaneOtherVOs;
	}
	
	
	public void setVslSvcLaneforBudgetVO(VslSvcLaneforBudgetVO vslSvcLaneforBudgetVO){
		this.vslSvcLaneforBudgetVO = vslSvcLaneforBudgetVO;
	}
	
	/**
	 * RqstSimNoVO 정보를 구한다.
	 * 
	 * @return RqstSimNoVO
	 */
	public RqstSimNoVO getRqstSimNoVO() {
		return rqstSimNoVO;
	}

	/**
	 * RqstSimNoVO 정보를 설정한다.
	 * 
	 * @param RqstSimNoVO rqstSimNoVO
	 */
	public void setRqstSimNoVO(RqstSimNoVO rqstSimNoVO) {
		this.rqstSimNoVO = rqstSimNoVO;
	}

	/**
	 * RqstSimNoVO 다건 정보를 구한다.
	 * 
	 * @return rtnVOs
	 */
	public RqstSimNoVO[] getRqstSimNoVOs() {
		RqstSimNoVO[] rtnVOs =  null;
		if(this.rqstSimNoVOs != null){
			rtnVOs = new RqstSimNoVO[rqstSimNoVOs.length];
			System.arraycopy(rqstSimNoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.16
		//return rqstSimNoVOs;
	}

	/**
	 * RqstSimNoVO 다건 정보를 설정한다.
	 * 
	 * @param RqstSimNoVO[] rqstSimNoVOs
	 */
	public void setRqstSimNoVOs(RqstSimNoVO[] rqstSimNoVOs) {
		if(rqstSimNoVOs != null){
			RqstSimNoVO[] tmpVOs = new RqstSimNoVO[rqstSimNoVOs.length];
			System.arraycopy(rqstSimNoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rqstSimNoVOs = tmpVOs;
		}
		//소스보안 2015.07.16
		//this.rqstSimNoVOs = rqstSimNoVOs;
	}
	
	public void setCodeInfoVO(CodeInfoVO codeInfoVO){
		this. codeInfoVO = codeInfoVO;
	}

	public void setCodeInfoVOS(CodeInfoVO[] codeInfoVOs){
		if(codeInfoVOs != null){
			CodeInfoVO[] tmpVOs = new CodeInfoVO[codeInfoVOs.length];
			System.arraycopy(codeInfoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.codeInfoVOs = tmpVOs;
		}
		//소스보안 2015.07.16
		//this. codeInfoVOs = codeInfoVOs;
	}

	public CodeInfoVO getCodeInfoVO(){
		return codeInfoVO;
	}

	public CodeInfoVO[] getCodeInfoVOS(){
		CodeInfoVO[] rtnVOs =  null;
		if(this.codeInfoVOs != null){
			rtnVOs = new CodeInfoVO[codeInfoVOs.length];
			System.arraycopy(codeInfoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.16
		//return codeInfoVOs;
	}

}