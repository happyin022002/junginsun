/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EsmPri8003Event.java
*@FileTitle : Awkward Cargo Pricing Application
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.18
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.02.18 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.event;

import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.AwkCgoExtraCostByRouteVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.PriScqAwkCgoVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.PriScqAwkCntrTpszVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.PriScqAwkHdrVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.PriScqAwkRqstVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.vo.PriScqAwkMnVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_PRI_8003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_8003HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dong-sun Moon
 * @see ESM_PRI_8003HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri8003Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriScqAwkCgoVO priScqAwkCgoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriScqAwkCgoVO[] priScqAwkCgoVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AwkCgoExtraCostByRouteVO awkCgoExtraCostByRouteVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private AwkCgoExtraCostByRouteVO[] awkCgoExtraCostByRouteVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriScqAwkHdrVO priScqAwkHdrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriScqAwkHdrVO[] priScqAwkHdrVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriScqAwkMnVO priScqAwkMnVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriScqAwkMnVO[] priScqAwkMnVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriScqAwkCntrTpszVO priScqAwkCntrTpszVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriScqAwkCntrTpszVO[] priScqAwkCntrTpszVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriScqAwkRqstVO priScqAwkRqstVO = null;
	
	public EsmPri8003Event(){}
	
	public void setPriScqAwkCgoVO(PriScqAwkCgoVO priScqAwkCgoVO){
		this. priScqAwkCgoVO = priScqAwkCgoVO;
	}

	public void setPriScqAwkCgoVOS(PriScqAwkCgoVO[] priScqAwkCgoVOs){
		this. priScqAwkCgoVOs = priScqAwkCgoVOs;
	}

	public PriScqAwkCgoVO getPriScqAwkCgoVO(){
		return priScqAwkCgoVO;
	}

	public PriScqAwkCgoVO[] getPriScqAwkCgoVOS(){
		return priScqAwkCgoVOs;
	}
	
	public void setAwkCgoExtraCostByRouteVO(AwkCgoExtraCostByRouteVO awkCgoExtraCostByRouteVO){
		this. awkCgoExtraCostByRouteVO = awkCgoExtraCostByRouteVO;
	}

	public void setAwkCgoExtraCostByRouteVOS(AwkCgoExtraCostByRouteVO[] awkCgoExtraCostByRouteVOs){
		this. awkCgoExtraCostByRouteVOs = awkCgoExtraCostByRouteVOs;
	}

	public AwkCgoExtraCostByRouteVO getAwkCgoExtraCostByRouteVO(){
		return awkCgoExtraCostByRouteVO;
	}

	public AwkCgoExtraCostByRouteVO[] getAwkCgoExtraCostByRouteVOS(){
		return awkCgoExtraCostByRouteVOs;
	}
	
	public void setPriScqAwkHdrVO(PriScqAwkHdrVO priScqAwkHdrVO){
		this. priScqAwkHdrVO = priScqAwkHdrVO;
	}

	public void setPriScqAwkHdrVOS(PriScqAwkHdrVO[] priScqAwkHdrVOs){
		this. priScqAwkHdrVOs = priScqAwkHdrVOs;
	}

	public PriScqAwkHdrVO getPriScqAwkHdrVO(){
		return priScqAwkHdrVO;
	}

	public PriScqAwkHdrVO[] getPriScqAwkHdrVOS(){
		return priScqAwkHdrVOs;
	} 
	
	public void setPriScqAwkMnVO(PriScqAwkMnVO priScqAwkMnVO){
		this. priScqAwkMnVO = priScqAwkMnVO;
	}

	public void setPriScqAwkMnVOS(PriScqAwkMnVO[] priScqAwkMnVOs){
		this. priScqAwkMnVOs = priScqAwkMnVOs;
	}

	public PriScqAwkMnVO getPriScqAwkMnVO(){
		return priScqAwkMnVO;
	}

	public PriScqAwkMnVO[] getPriScqAwkMnVOS(){
		return priScqAwkMnVOs;
	}

	public void setPriScqAwkCntrTpszVO(PriScqAwkCntrTpszVO priScqAwkCntrTpszVO){
		this. priScqAwkCntrTpszVO = priScqAwkCntrTpszVO;
	}

	public void setPriScqAwkCntrTpszVOS(PriScqAwkCntrTpszVO[] priScqAwkCntrTpszVOs){
		this. priScqAwkCntrTpszVOs = priScqAwkCntrTpszVOs;
	}

	public PriScqAwkCntrTpszVO getPriScqAwkCntrTpszVO(){
		return priScqAwkCntrTpszVO;
	}

	public PriScqAwkCntrTpszVO[] getPriScqAwkCntrTpszVOS(){
		return priScqAwkCntrTpszVOs;
	}
	
	public PriScqAwkRqstVO getPriScqAwkRqstVO() {
		return priScqAwkRqstVO;
	}

	public void setPriScqAwkRqstVO(PriScqAwkRqstVO priScqAwkRqstVO) {
		this.priScqAwkRqstVO = priScqAwkRqstVO;
	}
}