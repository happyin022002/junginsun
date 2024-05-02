/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0496Event.java
*@FileTitle : T/S Remain Status by Location
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.05.26 최영희
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSRemainListInputVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSRemianListVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0496 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0496HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Yeoung Hee
 * @see ESM_BKG_0496HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0496Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TSRemianListVO searchTSRemainList = null;
	
	/** Table Value Object Multi Data 처리 */
	private TSRemianListVO[] searchTSRemainLists = null;
	
	private TSRemainListInputVO tSRemainListInputVO = null;
	
	private TSRemainListInputVO[] tSRemainListInputVOs = null;
	
	public EsmBkg0496Event(){}
	
	public void setsearchTSRemainList(TSRemianListVO searchTSRemainList){
		this. searchTSRemainList = searchTSRemainList;
	}

	public TSRemianListVO getsearchTSRemainList(){
		return searchTSRemainList;
	}

	public TSRemainListInputVO getTSRemainListInputVO() {
		return tSRemainListInputVO;
	}

	public void setTSRemainListInputVO(TSRemainListInputVO remainListInputVO) {
		tSRemainListInputVO = remainListInputVO;
	}

	public TSRemianListVO[] getsearchTSRemainListS() {
		TSRemianListVO[] rtnVOs = null;
		if (this.searchTSRemainLists != null) {
			rtnVOs = Arrays.copyOf(searchTSRemainLists, searchTSRemainLists.length);
		}
		return rtnVOs;
	}

	public void setsearchTSRemainListS(TSRemianListVO[] searchTSRemainLists) {
		if (searchTSRemainLists != null) {
			TSRemianListVO[] tmpVOs = Arrays.copyOf(searchTSRemainLists,searchTSRemainLists.length);
			this.searchTSRemainLists = tmpVOs;
		}
	}

	public TSRemainListInputVO[] getTSRemainListInputVOs() {
		TSRemainListInputVO[] rtnVOs = null;
		if (this.tSRemainListInputVOs != null) {
			rtnVOs = Arrays.copyOf(tSRemainListInputVOs,tSRemainListInputVOs.length);
		}
		return rtnVOs;
	}

	public void setTSRemainListInputVOs(TSRemainListInputVO[] tSRemainListInputVOs) {
		if (tSRemainListInputVOs != null) {
			TSRemainListInputVO[] tmpVOs = Arrays.copyOf(tSRemainListInputVOs,tSRemainListInputVOs.length);
			this.tSRemainListInputVOs = tmpVOs;
		}
	}

	
    
}