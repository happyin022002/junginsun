/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0004Event.java
*@FileTitle : Port Information Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.05.26 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.MdmRhqComboVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.MdmYardComboVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.PortInformationConditionVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.PortInformationMgtVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortCnlPassCondVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortDistVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortDocBufTmVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortNworkVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortTrspCondVO;

/**
 * VOP_OPF_0004 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF_0004HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jong Ock
 * @see VOP_OPF_0004HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopVsk0506Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PortInformationMgtVO portInformationMgtVO = null;
	private VskPortNworkVO vskPortNworkVO = null;
	private VskPortDistVO vskPortDistVO = null;
	private VskPortDocBufTmVO vskPortDocBufTmVO = null;
	private VskPortCnlPassCondVO vskPortCnlPassCondVO = null;
	private VskPortTrspCondVO vskPortTrspCondVO = null;
	private MdmYardComboVO mdmYardComboVO = null;
	private MdmRhqComboVO mdmRhqComboVO = null;
	private PortInformationConditionVO portInformationConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PortInformationMgtVO[] portInformationMgtVOs = null;
	private VskPortNworkVO[] vskPortNworkVOs = null;
	private VskPortDistVO[] vskPortDistVOs = null;
	private VskPortDocBufTmVO[] vskPortDocBufTmVOs = null;
	private VskPortCnlPassCondVO[] vskPortCnlPassCondVOs = null;
	private VskPortTrspCondVO[] vskPortTrspCondVOs = null;

	public VopVsk0506Event(){}
	
	public void setPortInformationMgtVO(PortInformationMgtVO portInformationMgtVO){
		this. portInformationMgtVO = portInformationMgtVO;
	}

	public void setPortInformationMgtVOS(PortInformationMgtVO[] portInformationMgtVOs){
		if(portInformationMgtVOs != null){
			PortInformationMgtVO[] tmpVOs = new PortInformationMgtVO[portInformationMgtVOs.length];
			System.arraycopy(portInformationMgtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.portInformationMgtVOs = tmpVOs;
		}
		//소스보안 2015.07.20
		//this. portInformationMgtVOs = portInformationMgtVOs;
	}

	public void setMdmYardComboVO(MdmYardComboVO mdmYardComboVO) {
		this.mdmYardComboVO = mdmYardComboVO;
	}	

	public void setMdmRhqComboVO(MdmRhqComboVO mdmRhqComboVO) {
		this.mdmRhqComboVO = mdmRhqComboVO;
	}	
	
	public PortInformationMgtVO getPortInformationMgtVO(){
		return portInformationMgtVO;
	}

	public PortInformationMgtVO[] getPortInformationMgtVOS(){
		PortInformationMgtVO[] rtnVOs =  null;
		if(this.portInformationMgtVOs != null){
			rtnVOs = new PortInformationMgtVO[portInformationMgtVOs.length];
			System.arraycopy(portInformationMgtVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.20
		//return portInformationMgtVOs;
	}
	
	public MdmYardComboVO getMdmYardComboVO() {
		return mdmYardComboVO;
	}	

	public MdmRhqComboVO getMdmRhqComboVO() {
		return mdmRhqComboVO;
	}	
	
	public void setPortInformationConditionVO(PortInformationConditionVO portInformationConditionVO) {
		this.portInformationConditionVO = portInformationConditionVO;
	}
	
	public PortInformationConditionVO getPortInformationConditionVO() {
		return portInformationConditionVO;
	}
	
	/** tab2 Start **/
	public void setVskPortNworkVO(VskPortNworkVO vskPortNworkVO){
		this. vskPortNworkVO = vskPortNworkVO;
	}

	public void setVskPortNworkVOS(VskPortNworkVO[] vskPortNworkVOs){
		if(vskPortNworkVOs != null){
			VskPortNworkVO[] tmpVOs = new VskPortNworkVO[vskPortNworkVOs.length];
			System.arraycopy(vskPortNworkVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vskPortNworkVOs = tmpVOs;
		}
		//소스보안 2015.07.20
		//this. vskPortNworkVOs = vskPortNworkVOs;
	}

	public VskPortNworkVO getVskPortNworkVO(){   
		return vskPortNworkVO;                           
	}                                                        
                                                           
	public VskPortNworkVO[] getVskPortNworkVOS(){
		VskPortNworkVO[] rtnVOs =  null;
		if(this.vskPortNworkVOs != null){
			rtnVOs = new VskPortNworkVO[vskPortNworkVOs.length];
			System.arraycopy(vskPortNworkVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.20
		//return vskPortNworkVOs;                          
	}     	
	/** tab2 end **/
	
	/** tab3 Start **/
	public void setVskPortDistVO(VskPortDistVO vskPortDistVO){
		this. vskPortDistVO = vskPortDistVO;
	}

	public void setVskPortDistVOS(VskPortDistVO[] vskPortDistVOs){
		if(vskPortDistVOs != null){
			VskPortDistVO[] tmpVOs = new VskPortDistVO[vskPortDistVOs.length];
			System.arraycopy(vskPortDistVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vskPortDistVOs = tmpVOs;
		}
		//소스보안 2015.07.20
		//this. vskPortDistVOs = vskPortDistVOs;
	}

	public VskPortDistVO getVskPortDistVO(){   
		return vskPortDistVO;                           
	}                                                        
                                                           
	public VskPortDistVO[] getVskPortDistVOS(){
		VskPortDistVO[] rtnVOs =  null;
		if(this.vskPortDistVOs != null){
			rtnVOs = new VskPortDistVO[vskPortDistVOs.length];
			System.arraycopy(vskPortDistVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.20
		//return vskPortDistVOs;                          
	}     	
	/** tab3 end **/	
	
	/** tab4 Start **/
	public void setVskPortDocBufTmVO(VskPortDocBufTmVO vskPortDocBufTmVO){
		this. vskPortDocBufTmVO = vskPortDocBufTmVO;
	}

	public void setVskPortDocBufTmVOS(VskPortDocBufTmVO[] vskPortDocBufTmVOs){
		if(vskPortDocBufTmVOs != null){
			VskPortDocBufTmVO[] tmpVOs = new VskPortDocBufTmVO[vskPortDocBufTmVOs.length];
			System.arraycopy(vskPortDocBufTmVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vskPortDocBufTmVOs = tmpVOs;
		}
		//소스보안 2015.07.20
		//this. vskPortDocBufTmVOs = vskPortDocBufTmVOs;
	}

	public VskPortDocBufTmVO getVskPortDocBufTmVO(){   
		return vskPortDocBufTmVO;                           
	}                                                        
                                                           
	public VskPortDocBufTmVO[] getVskPortDocBufTmVOS(){
		VskPortDocBufTmVO[] rtnVOs =  null;
		if(this.vskPortDocBufTmVOs != null){
			rtnVOs = new VskPortDocBufTmVO[vskPortDocBufTmVOs.length];
			System.arraycopy(vskPortDocBufTmVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.20
		//return vskPortDocBufTmVOs;                          
	}     	
	/** tab4 end **/
	
	/** tab5 Start **/
	public void setVskPortCnlPassCondVO(VskPortCnlPassCondVO vskPortCnlPassCondVO){
		this. vskPortCnlPassCondVO = vskPortCnlPassCondVO;
	}

	public void setVskPortCnlPassCondVOS(VskPortCnlPassCondVO[] vskPortCnlPassCondVOs){
		if(vskPortCnlPassCondVOs != null){
			VskPortCnlPassCondVO[] tmpVOs = new VskPortCnlPassCondVO[vskPortCnlPassCondVOs.length];
			System.arraycopy(vskPortCnlPassCondVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vskPortCnlPassCondVOs = tmpVOs;
		}
		//소스보안 2015.07.20
		//this. vskPortCnlPassCondVOs = vskPortCnlPassCondVOs;
	}

	public VskPortCnlPassCondVO getVskPortCnlPassCondVO(){   
		return vskPortCnlPassCondVO;                           
	}                                                        
                                                           
	public VskPortCnlPassCondVO[] getVskPortCnlPassCondVOS(){
		VskPortCnlPassCondVO[] rtnVOs =  null;
		if(this.vskPortCnlPassCondVOs != null){
			rtnVOs = new VskPortCnlPassCondVO[vskPortCnlPassCondVOs.length];
			System.arraycopy(vskPortCnlPassCondVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.20
		//return vskPortCnlPassCondVOs;                          
	}     	
	/** tab5 end **/	
	
	/** tab 6 7 Start **/
	public void setVskPortTrspCondVO(VskPortTrspCondVO vskPortTrspCondVO){
		this. vskPortTrspCondVO = vskPortTrspCondVO;
	}

	public void setVskPortTrspCondVOS(VskPortTrspCondVO[] vskPortTrspCondVOs){
		if(vskPortTrspCondVOs != null){
			VskPortTrspCondVO[] tmpVOs = new VskPortTrspCondVO[vskPortTrspCondVOs.length];
			System.arraycopy(vskPortTrspCondVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vskPortTrspCondVOs = tmpVOs;
		}
		//소스보안 2015.07.20
		//this. vskPortTrspCondVOs = vskPortTrspCondVOs;
	}

	public VskPortTrspCondVO getVskPortTrspCondVO(){   
		return vskPortTrspCondVO;                           
	}                                                        
                                                           
	public VskPortTrspCondVO[] getVskPortTrspCondVOS(){
		VskPortTrspCondVO[] rtnVOs =  null;
		if(this.vskPortTrspCondVOs != null){
			rtnVOs = new VskPortTrspCondVO[vskPortTrspCondVOs.length];
			System.arraycopy(vskPortTrspCondVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.20
		//return vskPortTrspCondVOs;                          
	}     	
	/** tab7 end **/		
}