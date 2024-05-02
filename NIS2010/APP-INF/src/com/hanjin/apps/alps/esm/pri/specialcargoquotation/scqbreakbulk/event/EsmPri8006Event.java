/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EsmPri8006Event.java
*@FileTitle : Awkward Cargo Pricing Approval
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.18
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.02.18 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.event;

import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.vo.PriScqBbCgoVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.vo.PriScqBbCntrTpszVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.vo.PriScqBbCntrVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.vo.PriScqBbHdrVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.vo.PriScqBbRoutCostVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.vo.PriScqBbRqstVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_8006 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_8006HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dong-sun Moon
 * @see ESM_PRI_8006HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri8006Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriScqBbCgoVO priScqBbCgoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriScqBbCgoVO[] priScqBbCgoVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriScqBbHdrVO priScqBbHdrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriScqBbHdrVO[] priScqBbHdrVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriScqBbCntrTpszVO priScqBbCntrTpszVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriScqBbCntrTpszVO[] priScqBbCntrTpszVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriScqBbCntrVO priScqBbCntrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriScqBbCntrVO[] priScqBbCntrVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriScqBbRoutCostVO priScqBbRoutCostVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriScqBbRoutCostVO[] priScqBbRoutCostVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriScqBbRqstVO priScqBbRqstVO = null;
	
	public EsmPri8006Event(){}
	
	public void setPriScqBbCgoVO(PriScqBbCgoVO priScqBbCgoVO){
		this. priScqBbCgoVO = priScqBbCgoVO;
	}

	public void setPriScqBbCgoVOS(PriScqBbCgoVO[] priScqBbCgoVOs){
		this. priScqBbCgoVOs = priScqBbCgoVOs;
	}

	public PriScqBbCgoVO getPriScqBbCgoVO(){
		return priScqBbCgoVO;
	}

	public PriScqBbCgoVO[] getPriScqBbCgoVOS(){
		return priScqBbCgoVOs;
	}
	
	public void setPriScqBbHdrVO(PriScqBbHdrVO priScqBbHdrVO){
		this. priScqBbHdrVO = priScqBbHdrVO;
	}

	public void setPriScqBbHdrVOS(PriScqBbHdrVO[] priScqBbHdrVOs){
		this. priScqBbHdrVOs = priScqBbHdrVOs;
	}

	public PriScqBbHdrVO getPriScqBbHdrVO(){
		return priScqBbHdrVO;
	}

	public PriScqBbHdrVO[] getPriScqBbHdrVOS(){
		return priScqBbHdrVOs;
	} 

	public void setPriScqBbCntrTpszVO(PriScqBbCntrTpszVO priScqBbCntrTpszVO){
		this. priScqBbCntrTpszVO = priScqBbCntrTpszVO;
	}

	public void setPriScqBbCntrTpszVOS(PriScqBbCntrTpszVO[] priScqBbCntrTpszVOs){
		this. priScqBbCntrTpszVOs = priScqBbCntrTpszVOs;
	}

	public PriScqBbCntrTpszVO getPriScqBbCntrTpszVO(){
		return priScqBbCntrTpszVO;
	}

	public PriScqBbCntrTpszVO[] getPriScqBbCntrTpszVOS(){
		return priScqBbCntrTpszVOs;
	}
	
	public void setPriScqBbCntrVO(PriScqBbCntrVO priScqBbCntrVO){
		this. priScqBbCntrVO = priScqBbCntrVO;
	}

	public void setPriScqBbCntrVOS(PriScqBbCntrVO[] priScqBbCntrVOs){
		this. priScqBbCntrVOs = priScqBbCntrVOs;
	}

	public PriScqBbCntrVO getPriScqBbCntrVO(){
		return priScqBbCntrVO;
	}

	public PriScqBbCntrVO[] getPriScqBbCntrVOS(){
		return priScqBbCntrVOs;
	}
	
	public void setPriScqBbRoutCostVO(PriScqBbRoutCostVO priScqBbRoutCostVO){
		this. priScqBbRoutCostVO = priScqBbRoutCostVO;
	}

	public void setPriScqBbRoutCostVOS(PriScqBbRoutCostVO[] priScqBbRoutCostVOs){
		this. priScqBbRoutCostVOs = priScqBbRoutCostVOs;
	}

	public PriScqBbRoutCostVO getPriScqBbRoutCostVO(){
		return priScqBbRoutCostVO;
	}

	public PriScqBbRoutCostVO[] getPriScqBbRoutCostVOS(){
		return priScqBbRoutCostVOs;
	}
	
	public PriScqBbRqstVO getPriScqBbRqstVO() {
		return priScqBbRqstVO;
	}

	public void setPriScqBbRqstVO(PriScqBbRqstVO priScqBbRqstVO) {
		this.priScqBbRqstVO = priScqBbRqstVO;
	}
}