/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopOpf0049Event.java
*@FileTitle : Stevedore Damage Reason Code (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : 우지석
*@LastVersion : 1.0
* 2009.05.13 우지석
* 1.0 Creation
* 2016.04.28 Arie Im CHM-201641178 아프리카 대륙 구주지역본부/동서남아지역본부 구분 로직 추가(작업중 해당 화면 Event및 HtmlAction 파일 존재하지 않아 ClassCast Exception 발생하고 있어서 Creation 화면 복사하여 생성)

=========================================================*/
package com.hanjin.apps.alps.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.OpfStvDmgCdVO;


/**
 * vop_opf_0051 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  vop_opf_0051HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ji Seok Woo
 * @see vop_opf_0051HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopOpf0051Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OpfStvDmgCdVO opfStvDmgCdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private OpfStvDmgCdVO[] opfStvDmgCdVOs = null;

	public VopOpf0051Event(){}
	
	public void setOpfStvDmgCdVO(OpfStvDmgCdVO opfStvDmgCdVO){
		this. opfStvDmgCdVO = opfStvDmgCdVO;
	}

	public void setOpfStvDmgCdVOS(OpfStvDmgCdVO[] opfStvDmgCdVOs){
		if (opfStvDmgCdVOs != null) {
			OpfStvDmgCdVO[] tmpVOs = new OpfStvDmgCdVO[opfStvDmgCdVOs.length];
			System.arraycopy(opfStvDmgCdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.opfStvDmgCdVOs = tmpVOs;
		}
	}

	public OpfStvDmgCdVO getOpfStvDmgCdVO(){
		return opfStvDmgCdVO;
	}

	public OpfStvDmgCdVO[] getOpfStvDmgCdVOS(){
		OpfStvDmgCdVO[] rtnVOs = null;

 		if (this.opfStvDmgCdVOs != null) {
 			rtnVOs = new OpfStvDmgCdVO[opfStvDmgCdVOs.length];
 			System.arraycopy(opfStvDmgCdVOs, 0, rtnVOs, 0, rtnVOs.length);
 		 }		
 		 return rtnVOs;
	}

}