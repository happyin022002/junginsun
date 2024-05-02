/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0504Event.java
*@FileTitle : Port Information Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.05.26 김종옥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.MdmRhqComboVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.MdmYardComboVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.PortInformationConditionVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.PortInformationMgtVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortCnlPassCondVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortDistVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortDocBufTmVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortNworkVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortTrspCondVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.VskPortCnlTrScgVO;

/**
 * VOP_OPF_0504 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF_0504HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jong Ock
 * @see VOP_OPF_0504HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopVsk0504Event extends EventSupport {

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
	private VskPortCnlTrScgVO[] vskPortCnlTrScgVOs = null;
	private VskPortTrspCondVO[] vskPortTrspCondVOs = null;

	public VopVsk0504Event(){}
	
	public void setPortInformationMgtVO(PortInformationMgtVO portInformationMgtVO){
		this. portInformationMgtVO = portInformationMgtVO;
	}

	public void setPortInformationMgtVOS(PortInformationMgtVO[] portInformationMgtVOs){
		if(portInformationMgtVOs != null){
			PortInformationMgtVO[] tmpVOs = Arrays.copyOf(portInformationMgtVOs, portInformationMgtVOs.length);
			this.portInformationMgtVOs = tmpVOs;
		}
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
		PortInformationMgtVO[] rtnVOs = null;
		if (this.portInformationMgtVOs != null) {
			rtnVOs = Arrays.copyOf(portInformationMgtVOs, portInformationMgtVOs.length);
		}
		return rtnVOs;
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
			VskPortNworkVO[] tmpVOs = Arrays.copyOf(vskPortNworkVOs, vskPortNworkVOs.length);
			this.vskPortNworkVOs = tmpVOs;
		}
	}

	public VskPortNworkVO getVskPortNworkVO(){   
		return vskPortNworkVO;                           
	}                                                        
                                                           
	public VskPortNworkVO[] getVskPortNworkVOS(){
		VskPortNworkVO[] rtnVOs = null;
		if (this.vskPortNworkVOs != null) {
			rtnVOs = Arrays.copyOf(vskPortNworkVOs, vskPortNworkVOs.length);
		}
		return rtnVOs;
	}     	
	/** tab2 end **/
	
	/** tab3 Start **/
	public void setVskPortDistVO(VskPortDistVO vskPortDistVO){
		this. vskPortDistVO = vskPortDistVO;
	}

	public void setVskPortDistVOS(VskPortDistVO[] vskPortDistVOs){
		if(vskPortDistVOs != null){
			VskPortDistVO[] tmpVOs = Arrays.copyOf(vskPortDistVOs, vskPortDistVOs.length);
			this.vskPortDistVOs = tmpVOs;
		}
	}

	public VskPortDistVO getVskPortDistVO(){   
		return vskPortDistVO;                           
	}                                                        
                                                           
	public VskPortDistVO[] getVskPortDistVOS(){
		VskPortDistVO[] rtnVOs = null;
		if (this.vskPortDistVOs != null) {
			rtnVOs = Arrays.copyOf(vskPortDistVOs, vskPortDistVOs.length);
		}
		return rtnVOs;
	}     	
	/** tab3 end **/	
	
	/** tab4 Start **/
	public void setVskPortDocBufTmVO(VskPortDocBufTmVO vskPortDocBufTmVO){
		this. vskPortDocBufTmVO = vskPortDocBufTmVO;
	}

	public void setVskPortDocBufTmVOS(VskPortDocBufTmVO[] vskPortDocBufTmVOs){
		if(vskPortDocBufTmVOs != null){
			VskPortDocBufTmVO[] tmpVOs = Arrays.copyOf(vskPortDocBufTmVOs, vskPortDocBufTmVOs.length);
			this.vskPortDocBufTmVOs = tmpVOs;
		}
	}

	public VskPortDocBufTmVO getVskPortDocBufTmVO(){   
		return vskPortDocBufTmVO;                           
	}                                                        
                                                           
	public VskPortDocBufTmVO[] getVskPortDocBufTmVOS(){
		VskPortDocBufTmVO[] rtnVOs = null;
		if (this.vskPortDocBufTmVOs != null) {
			rtnVOs = Arrays.copyOf(vskPortDocBufTmVOs, vskPortDocBufTmVOs.length);
		}
		return rtnVOs;
	}     	
	/** tab4 end **/
	
	/** tab5 Start **/
	public void setVskPortCnlPassCondVO(VskPortCnlPassCondVO vskPortCnlPassCondVO){
		this. vskPortCnlPassCondVO = vskPortCnlPassCondVO;
	}

	public void setVskPortCnlPassCondVOS(VskPortCnlPassCondVO[] vskPortCnlPassCondVOs){
		if(vskPortCnlPassCondVOs != null){
			VskPortCnlPassCondVO[] tmpVOs = Arrays.copyOf(vskPortCnlPassCondVOs, vskPortCnlPassCondVOs.length);
			this.vskPortCnlPassCondVOs = tmpVOs;
		}
	}

	public VskPortCnlPassCondVO getVskPortCnlPassCondVO(){   
		return vskPortCnlPassCondVO;                           
	}                                                        
                                                           
	public VskPortCnlPassCondVO[] getVskPortCnlPassCondVOS(){
		VskPortCnlPassCondVO[] rtnVOs = null;
		if (this.vskPortCnlPassCondVOs != null) {
			rtnVOs = Arrays.copyOf(vskPortCnlPassCondVOs, vskPortCnlPassCondVOs.length);
		}
		return rtnVOs;
	}
	
	public void setVskPortCnlTrScgVOS(VskPortCnlTrScgVO[] vskPortCnlTrScgVOs){
		if(vskPortCnlTrScgVOs != null){
			VskPortCnlTrScgVO[] tmpVOs = Arrays.copyOf(vskPortCnlTrScgVOs, vskPortCnlTrScgVOs.length);
			this.vskPortCnlTrScgVOs = tmpVOs;
		}
	}
	
	public VskPortCnlTrScgVO[] getVskPortCnlTrScgVOS(){
		VskPortCnlTrScgVO[] rtnVOs = null;
		if (this.vskPortCnlTrScgVOs != null) {
			rtnVOs = Arrays.copyOf(vskPortCnlTrScgVOs, vskPortCnlTrScgVOs.length);
		}
		return rtnVOs;
	}
	
	/** tab5 end **/	
	
	/** tab 6 7 Start **/
	public void setVskPortTrspCondVO(VskPortTrspCondVO vskPortTrspCondVO){
		this. vskPortTrspCondVO = vskPortTrspCondVO;
	}

	public void setVskPortTrspCondVOS(VskPortTrspCondVO[] vskPortTrspCondVOs){
		if(vskPortTrspCondVOs != null){
			VskPortTrspCondVO[] tmpVOs = Arrays.copyOf(vskPortTrspCondVOs, vskPortTrspCondVOs.length);
			this.vskPortTrspCondVOs = tmpVOs;
		}
	}

	public VskPortTrspCondVO getVskPortTrspCondVO(){   
		return vskPortTrspCondVO;                           
	}                                                        
                                                           
	public VskPortTrspCondVO[] getVskPortTrspCondVOS(){
		VskPortTrspCondVO[] rtnVOs = null;
		if (this.vskPortTrspCondVOs != null) {
			rtnVOs = Arrays.copyOf(vskPortTrspCondVOs, vskPortTrspCondVOs.length);
		}
		return rtnVOs;
	}     	
	/** tab7 end **/		
}