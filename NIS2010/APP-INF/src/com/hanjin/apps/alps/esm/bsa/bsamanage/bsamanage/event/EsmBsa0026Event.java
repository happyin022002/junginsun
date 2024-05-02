
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBsa0026Event.java
*@FileTitle : EsmBsa0026Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.event;

import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.SearchBsaConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BsaJntOpCrrCapaVO;
import com.hanjin.syscommon.common.table.BsaJntOpPortDwnVO;
import com.hanjin.syscommon.common.table.BsaSltChtrCrrCapaVO;
import com.hanjin.syscommon.common.table.BsaSltChtrPortDwnVO;

/**
 * ESM_BSA_0024 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BSA_0024HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Dae
 * @see ESM_BSA_0024HTMLAction 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class EsmBsa0026Event extends EventSupport {
	
	/** 조회 조건 단건처리 */
	private SearchBsaConditionVO searchBsaConditionVO = null;
	
		
	/** 단건처리 */
	private BsaJntOpCrrCapaVO bsaJntOpCrrCapaVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private BsaJntOpCrrCapaVO[] bsaJntOpCrrCapaVOs = null;	
	
	/** 단건처리 */
	private BsaJntOpPortDwnVO bsaJntOpPortDwnVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private BsaJntOpPortDwnVO[] bsaJntOpPortDwnVOs = null;	
	
	
	/** 단건처리 */
	private BsaSltChtrCrrCapaVO bsaSltChtrCrrCapaVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private BsaSltChtrCrrCapaVO[] bsaSltChtrCrrCapaVOs = null;	
	
	/** 단건처리 */
	private BsaSltChtrPortDwnVO bsaSltChtrPortDwnVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private BsaSltChtrPortDwnVO[] bsaSltChtrPortDwnVOs = null;		
	

	/** Constructor */
	public EsmBsa0026Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmBsa0026Event";
	}
	
	/** ValueObject Setter */
	public void setBsaJntOpCrrCapaVO(BsaJntOpCrrCapaVO bsaJntOpCrrCapaVO){
		this.bsaJntOpCrrCapaVO = bsaJntOpCrrCapaVO;
	}
	/** ValueObject Getter */
	public BsaJntOpCrrCapaVO getBsaJntOpCrrCapaVO(){
		return bsaJntOpCrrCapaVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */
	//Yongseup Kim - Secure Coding [CWE-496]
	public void setBsaJntOpCrrCapaVOs(BsaJntOpCrrCapaVO[] bsaJntOpCrrCapaVOs){
		this.bsaJntOpCrrCapaVOs = new BsaJntOpCrrCapaVO[bsaJntOpCrrCapaVOs.length];
		for(int i=0; i< bsaJntOpCrrCapaVOs.length; ++i){
			this.bsaJntOpCrrCapaVOs[i] = bsaJntOpCrrCapaVOs[i];
		}
	}
	
	/** ValueObject Array Getter - Create/Update/Delete */
	//Yongseup Kim - Secure Coding [CWE-495]
	public BsaJntOpCrrCapaVO[] getBsaJntOpCrrCapaVOs(){
		BsaJntOpCrrCapaVO[] ret = null;
		if(this.bsaJntOpCrrCapaVOs != null){
			ret = new BsaJntOpCrrCapaVO[bsaJntOpCrrCapaVOs.length];
			for(int i=0; i<bsaJntOpCrrCapaVOs.length; i++){
				ret[i] = this.bsaJntOpCrrCapaVOs[i];
			}
		}
		return ret;
	}	
	
	
	/** ValueObject Setter */
	public void setBsaJntOpPortDwnVO(BsaJntOpPortDwnVO bsaJntOpPortDwnVO){
		this.bsaJntOpPortDwnVO = bsaJntOpPortDwnVO;
	}
	/** ValueObject Getter */
	public BsaJntOpPortDwnVO getBsaJntOpPortDwnVO(){
		return bsaJntOpPortDwnVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */
	//Yongseup Kim - Secure Coding [CWE-496]
	public void setBsaJntOpPortDwnVOs(BsaJntOpPortDwnVO[] bsaJntOpPortDwnVOs){
		this.bsaJntOpPortDwnVOs = new BsaJntOpPortDwnVO[bsaJntOpPortDwnVOs.length];
		for(int i=0; i< bsaJntOpPortDwnVOs.length; ++i){
			this.bsaJntOpPortDwnVOs[i] = bsaJntOpPortDwnVOs[i];
		}
	}
	
	/** ValueObject Array Getter - Create/Update/Delete */
	//Yongseup Kim - Secure Coding [CWE-495]
	public BsaJntOpPortDwnVO[] getBsaJntOpPortDwnVOs(){
		BsaJntOpPortDwnVO[] ret = null;
		if(this.bsaJntOpPortDwnVOs != null){
			ret = new BsaJntOpPortDwnVO[bsaJntOpPortDwnVOs.length];
			for(int i=0; i<bsaJntOpPortDwnVOs.length; i++){
				ret[i] = this.bsaJntOpPortDwnVOs[i];
			}
		}
		return ret;
	}	
	
	
	/** ValueObject Setter */
	public void setBsaSltChtrCrrCapaVO(BsaSltChtrCrrCapaVO bsaSltChtrCrrCapaVO){
		this.bsaSltChtrCrrCapaVO = bsaSltChtrCrrCapaVO;
	}
	/** ValueObject Getter */
	public BsaSltChtrCrrCapaVO getBsaSltChtrCrrCapaVO(){
		return bsaSltChtrCrrCapaVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */
	//Yongseup Kim - Secure Coding [CWE-496]
	public void setBsaSltChtrCrrCapaVOs(BsaSltChtrCrrCapaVO[] bsaSltChtrCrrCapaVOs){
		this.bsaSltChtrCrrCapaVOs = new BsaSltChtrCrrCapaVO[bsaSltChtrCrrCapaVOs.length];
		for(int i=0; i< bsaSltChtrCrrCapaVOs.length; ++i){
			this.bsaSltChtrCrrCapaVOs[i] = bsaSltChtrCrrCapaVOs[i];
		}	
	}
	
	/** ValueObject Array Getter - Create/Update/Delete */
	//Yongseup Kim - Secure Coding [CWE-495]
	public BsaSltChtrCrrCapaVO[] getBsaSltChtrCrrCapaVOs(){
		BsaSltChtrCrrCapaVO[] ret = null;
		if(this.bsaSltChtrCrrCapaVOs != null){
			ret = new BsaSltChtrCrrCapaVO[bsaSltChtrCrrCapaVOs.length];
			for(int i=0; i<bsaSltChtrCrrCapaVOs.length; i++){
				ret[i] = this.bsaSltChtrCrrCapaVOs[i];
			}
		}
		return ret;
	}		

	
	/** ValueObject Setter */
	public void setBsaSltChtrPortDwnVO(BsaSltChtrPortDwnVO bsaSltChtrPortDwnVO){
		this.bsaSltChtrPortDwnVO = bsaSltChtrPortDwnVO;
	}
	/** ValueObject Getter */
	public BsaSltChtrPortDwnVO getBsaSltChtrPortDwnVO(){
		return bsaSltChtrPortDwnVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */
	//Yongseup Kim - Secure Coding [CWE-496]
	public void setBsaSltChtrPortDwnVOs(BsaSltChtrPortDwnVO[] bsaSltChtrPortDwnVOs){
		this.bsaSltChtrPortDwnVOs = new BsaSltChtrPortDwnVO[bsaSltChtrPortDwnVOs.length];
		for(int i=0; i< bsaSltChtrPortDwnVOs.length; ++i){
			this.bsaSltChtrPortDwnVOs[i] = bsaSltChtrPortDwnVOs[i];
		} 
	}
	
	/** ValueObject Array Getter - Create/Update/Delete */
	//Yongseup Kim - Secure Coding [CWE-495]
	public BsaSltChtrPortDwnVO[] getBsaSltChtrPortDwnVOs(){
		BsaSltChtrPortDwnVO[] ret = null;
		if(this.bsaSltChtrPortDwnVOs != null){
			ret = new BsaSltChtrPortDwnVO[bsaSltChtrPortDwnVOs.length];
			for(int i=0; i<bsaSltChtrPortDwnVOs.length; i++){
				ret[i] = this.bsaSltChtrPortDwnVOs[i];
			}
		}
		return ret;
	}

	public SearchBsaConditionVO getSearchBsaConditionVO() {
		return searchBsaConditionVO;
	}

	public void setSearchBsaConditionVO(SearchBsaConditionVO searchBsaConditionVO) {
		this.searchBsaConditionVO = searchBsaConditionVO;
	}	
	
	
}
