/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg0014Event.java
*@FileTitle : SPCL CGO APVL for Own BKG
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.06.04 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.sendeditopartnerlines.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.ScgRequestListOptionVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.ScgAuthorizationVO;


/**
 * VOP_SCG-0014 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG-0014HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dohyoung Lee
 * @see VOP_SCG-0014HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg0014Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String[] crrCd; 
	private String[] polCd;
	private String scgFlg;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgRequestListOptionVO scgRequestListOptionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgRequestListOptionVO[] scgRequestListOptionVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgAuthorizationVO scgAuthorizationVO = null;

	/** Table Value Object Multi Data 처리 */
	private ScgAuthorizationVO[] scgAuthorizationVOs = null;

	public VopScg0014Event(){}
	
	public void setScgRequestListOptionVO(ScgRequestListOptionVO scgRequestListOptionVO){
		this. scgRequestListOptionVO = scgRequestListOptionVO;
	}

	public void setScgRequestListOptionVOS(ScgRequestListOptionVO[] scgRequestListOptionVOs){
		if(scgRequestListOptionVOs != null){
			ScgRequestListOptionVO[] tmpVOs = Arrays.copyOf(scgRequestListOptionVOs, scgRequestListOptionVOs.length);
			this.scgRequestListOptionVOs = tmpVOs;
		}
	}

	public void setScgAuthorizationVO(ScgAuthorizationVO scgAuthorizationVO){
		this. scgAuthorizationVO = scgAuthorizationVO;
	}
	
	public void setScgAuthorizationVOS(ScgAuthorizationVO[] scgAuthorizationVOs){
		if(scgAuthorizationVOs != null){
			ScgAuthorizationVO[] tmpVOs = Arrays.copyOf(scgAuthorizationVOs, scgAuthorizationVOs.length);
			this.scgAuthorizationVOs = tmpVOs;
		}
	}

	public ScgRequestListOptionVO getScgRequestListOptionVO(){
		return scgRequestListOptionVO;
	}

	public ScgRequestListOptionVO[] getScgRequestListOptionVOS(){
		ScgRequestListOptionVO[] rtnVOs = null;
		if (this.scgRequestListOptionVOs != null) {
			rtnVOs = Arrays.copyOf(scgRequestListOptionVOs, scgRequestListOptionVOs.length);
		}
		return rtnVOs;
	}

	public ScgAuthorizationVO getScgAuthorizationVO(){
		return scgAuthorizationVO;
	}

	public ScgAuthorizationVO[] getScgAuthorizationVOS(){
		ScgAuthorizationVO[] rtnVOs = null;
		if (this.scgAuthorizationVOs != null) {
			rtnVOs = Arrays.copyOf(scgAuthorizationVOs, scgAuthorizationVOs.length);
		}
		return rtnVOs;
	}

	public void setCrrCd(String[] crrCd)
	{
		if(crrCd != null){
			String[] tmpVOs = Arrays.copyOf(crrCd, crrCd.length);
			this.crrCd = tmpVOs;
		}
	}
	public String[] getCrrCd()
	{
		String[] rtnVOs = null;
		if (this.crrCd != null) {
			rtnVOs = Arrays.copyOf(crrCd, crrCd.length);
		}
		return rtnVOs;
	}
	
	public void setPolCd(String[] polCd)
	{
		if(polCd != null){
			String[] tmpVOs = Arrays.copyOf(polCd, polCd.length);
			this.polCd = tmpVOs;
		}
	}
	public String[] getPolCd()
	{
		String[] rtnVOs = null;
		if (this.polCd != null) {
			rtnVOs = Arrays.copyOf(polCd, polCd.length);
		}
		return rtnVOs;
	}

	public void setScgFlg(String scgFlg)
	{
		this.scgFlg = scgFlg;
	}
	public String getScgFlg()
	{
		return this.scgFlg;
	}
	
}