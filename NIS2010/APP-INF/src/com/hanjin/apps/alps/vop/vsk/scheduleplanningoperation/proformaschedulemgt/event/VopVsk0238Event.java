/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0238Event.java
*@FileTitle : Berth Window (Pop-Up)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.05.25 서창열
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.event;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdBerthWdoVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.VskPfSkdDtlVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * VOP_VSK-0238 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK-0238HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SEO CHANG YUL
 * @see VOP_VSK-0238HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopVsk0238Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PfSkdBerthWdoVO pfSkdBerthWdoVO = null;
	private List<VskPfSkdDtlVO> vskPfSkdDtlVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private PfSkdBerthWdoVO[] pfSkdBerthWdoVOs = null;

	public VopVsk0238Event(){
		vskPfSkdDtlVOs = new ArrayList<VskPfSkdDtlVO>();
	}
	
	public void setPfSkdBerthWdoVO(PfSkdBerthWdoVO pfSkdBerthWdoVO){
		this.pfSkdBerthWdoVO = pfSkdBerthWdoVO;
	}
	
	public void setPfSkdBerthWdoVOS(PfSkdBerthWdoVO[] pfSkdBerthWdoVOs){
		if(pfSkdBerthWdoVOs != null){
			PfSkdBerthWdoVO[] tmpVOs = new PfSkdBerthWdoVO[pfSkdBerthWdoVOs.length];
			System.arraycopy(pfSkdBerthWdoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.pfSkdBerthWdoVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.pfSkdBerthWdoVOs = PfSkdBerthWdoVOs;
	}
	

	public PfSkdBerthWdoVO getPfSkdBerthWdoVO(){
		return pfSkdBerthWdoVO;
	}
	
	public PfSkdBerthWdoVO[] getPfSkdBerthWdoVOS(){
		PfSkdBerthWdoVO[] rtnVOs =  null;
		if(this.pfSkdBerthWdoVOs != null){
			rtnVOs = new PfSkdBerthWdoVO[pfSkdBerthWdoVOs.length];
			System.arraycopy(pfSkdBerthWdoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return pfSkdBerthWdoVOs;
	}
	
	
	public void setVskPfSkdDtlVOs(List<VskPfSkdDtlVO> vskPfSkdDtlVOs){
		this.vskPfSkdDtlVOs = vskPfSkdDtlVOs;
	}
	
	public List<VskPfSkdDtlVO> getVskPfSkdDtlVOs(){
		return this.vskPfSkdDtlVOs;
	}

}