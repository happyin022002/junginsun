/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa2006Event.java
*@FileTitle : USA Service Mode
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.coststructure.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.CoaUsaSvcModVO;
import java.util.Arrays;									//SJH.20150508.소스품질

/**
 * ESM_COA_2006 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_2006HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Chang Hun Kim
 * @see ESM_COA_2006HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmCoa2006Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CoaUsaSvcModVO coaUsaSvcModVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CoaUsaSvcModVO[] coaUsaSvcModVOs = null;
	
	private String orgRgnCd = null;
	private String destRgnCd = null;
	private String svcModCd = null;

	public EsmCoa2006Event(){}
	
	public void setCoaUsaSvcModVO(CoaUsaSvcModVO coaUsaSvcModVO){
		this. coaUsaSvcModVO = coaUsaSvcModVO;
	}
	//SJH.20150508.소스품질
	public void setCoaUsaSvcModVOS(CoaUsaSvcModVO[] coaUsaSvcModVOs){
		if(coaUsaSvcModVOs != null){
			CoaUsaSvcModVO[] tmpVOs = Arrays.copyOf(coaUsaSvcModVOs, coaUsaSvcModVOs.length);
			this.coaUsaSvcModVOs = tmpVOs;
		}
	}

	public CoaUsaSvcModVO getCoaUsaSvcModVO(){
		return coaUsaSvcModVO;
	}
	//SJH.20150508.소스품질
	public CoaUsaSvcModVO[] getCoaUsaSvcModVOS(){
		CoaUsaSvcModVO[] rtnVOs = null;
		if (this.coaUsaSvcModVOs != null) {
			rtnVOs = Arrays.copyOf(coaUsaSvcModVOs, coaUsaSvcModVOs.length);
		}
		return rtnVOs;
	}

	public String getOrgRgnCd(){
		return orgRgnCd;
	}

	public String getDestRgnCd(){
		return destRgnCd;
	}

	public String getSvcModCd(){
		return svcModCd;
	}

	public void setOrgRgnCd(String orgRgnCd){
		this. orgRgnCd = orgRgnCd;
	}

	public void setDestRgnCd(String destRgnCd){
		this. destRgnCd = destRgnCd;
	}

	public void setSvcModCd(String svcModCd){
		this. svcModCd = svcModCd;
	}
}