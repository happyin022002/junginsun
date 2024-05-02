
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
package com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.event;

import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo.SearchBsaConditionVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BsaJntOpCrrCapaVO;
import com.clt.syscommon.common.table.BsaJntOpPortDwnVO;
import com.clt.syscommon.common.table.BsaSltChtrCrrCapaVO;
import com.clt.syscommon.common.table.BsaSltChtrPortDwnVO;
import java.util.Arrays;									//SJH.20150507.소스품질

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
	
	/** ValueObject Array Setter - Create/Update/Delete : SJH.20150507.소스품질 */
	public void setBsaJntOpCrrCapaVOs(BsaJntOpCrrCapaVO[] bsaJntOpCrrCapaVOs){
		if(bsaJntOpCrrCapaVOs != null){
			BsaJntOpCrrCapaVO[] tmpVOs = Arrays.copyOf(bsaJntOpCrrCapaVOs, bsaJntOpCrrCapaVOs.length);
			this.bsaJntOpCrrCapaVOs = tmpVOs;
		}
	}
	/** ValueObject Array Getter - Create/Update/Delete : SJH.20150507.소스품질 */
	public BsaJntOpCrrCapaVO[] getBsaJntOpCrrCapaVOs(){
		BsaJntOpCrrCapaVO[] rtnVOs = null;
		if (this.bsaJntOpCrrCapaVOs != null) {
			rtnVOs = Arrays.copyOf(bsaJntOpCrrCapaVOs, bsaJntOpCrrCapaVOs.length);
		}
		return rtnVOs;
	}	
	
	
	/** ValueObject Setter */
	public void setBsaJntOpPortDwnVO(BsaJntOpPortDwnVO bsaJntOpPortDwnVO){
		this.bsaJntOpPortDwnVO = bsaJntOpPortDwnVO;
	}
	/** ValueObject Getter */
	public BsaJntOpPortDwnVO getBsaJntOpPortDwnVO(){
		return bsaJntOpPortDwnVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete : SJH.20150507.소스품질 */
	public void setBsaJntOpPortDwnVOs(BsaJntOpPortDwnVO[] bsaJntOpPortDwnVOs){
		if(bsaJntOpPortDwnVOs != null){
			BsaJntOpPortDwnVO[] tmpVOs = Arrays.copyOf(bsaJntOpPortDwnVOs, bsaJntOpPortDwnVOs.length);
			this.bsaJntOpPortDwnVOs = tmpVOs;
		}
	}
	/** ValueObject Array Getter - Create/Update/Delete : SJH.20150507.소스품질 */
	public BsaJntOpPortDwnVO[] getBsaJntOpPortDwnVOs(){
		BsaJntOpPortDwnVO[] rtnVOs = null;
		if (this.bsaJntOpPortDwnVOs != null) {
			rtnVOs = Arrays.copyOf(bsaJntOpPortDwnVOs, bsaJntOpPortDwnVOs.length);
		}
		return rtnVOs;
	}	
	
	
	/** ValueObject Setter */
	public void setBsaSltChtrCrrCapaVO(BsaSltChtrCrrCapaVO bsaSltChtrCrrCapaVO){
		this.bsaSltChtrCrrCapaVO = bsaSltChtrCrrCapaVO;
	}
	/** ValueObject Getter */
	public BsaSltChtrCrrCapaVO getBsaSltChtrCrrCapaVO(){
		return bsaSltChtrCrrCapaVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete : SJH.20150507.소스품질 */
	public void setBsaSltChtrCrrCapaVOs(BsaSltChtrCrrCapaVO[] bsaSltChtrCrrCapaVOs){
		if(bsaSltChtrCrrCapaVOs != null){
			BsaSltChtrCrrCapaVO[] tmpVOs = Arrays.copyOf(bsaSltChtrCrrCapaVOs, bsaSltChtrCrrCapaVOs.length);
			this.bsaSltChtrCrrCapaVOs = tmpVOs;
		}
	}
	/** ValueObject Array Getter - Create/Update/Delete : SJH.20150507.소스품질  */
	public BsaSltChtrCrrCapaVO[] getBsaSltChtrCrrCapaVOs(){
		BsaSltChtrCrrCapaVO[] rtnVOs = null;
		if (this.bsaSltChtrCrrCapaVOs != null) {
			rtnVOs = Arrays.copyOf(bsaSltChtrCrrCapaVOs, bsaSltChtrCrrCapaVOs.length);
		}
		return rtnVOs;
	}		

	
	/** ValueObject Setter */
	public void setBsaSltChtrPortDwnVO(BsaSltChtrPortDwnVO bsaSltChtrPortDwnVO){
		this.bsaSltChtrPortDwnVO = bsaSltChtrPortDwnVO;
	}
	/** ValueObject Getter */
	public BsaSltChtrPortDwnVO getBsaSltChtrPortDwnVO(){
		return bsaSltChtrPortDwnVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete : SJH.20150507.소스품질*/
	public void setBsaSltChtrPortDwnVOs(BsaSltChtrPortDwnVO[] bsaSltChtrPortDwnVOs){
		if(bsaSltChtrPortDwnVOs != null){
			BsaSltChtrPortDwnVO[] tmpVOs = Arrays.copyOf(bsaSltChtrPortDwnVOs, bsaSltChtrPortDwnVOs.length);
			this.bsaSltChtrPortDwnVOs = tmpVOs;
		}
	}
	/** ValueObject Array Getter - Create/Update/Delete : SJH.20150507.소스품질*/
	public BsaSltChtrPortDwnVO[] getBsaSltChtrPortDwnVOs(){
		BsaSltChtrPortDwnVO[] rtnVOs = null;
		if (this.bsaSltChtrPortDwnVOs != null) {
			rtnVOs = Arrays.copyOf(bsaSltChtrPortDwnVOs, bsaSltChtrPortDwnVOs.length);
		}
		return rtnVOs;
	}

	public SearchBsaConditionVO getSearchBsaConditionVO() {
		return searchBsaConditionVO;
	}

	public void setSearchBsaConditionVO(SearchBsaConditionVO searchBsaConditionVO) {
		this.searchBsaConditionVO = searchBsaConditionVO;
	}	
	
	
}
