/*=========================================================
*Copyright(c) 2017 Hiplus Card
*@FileName : EsmBkgS003Event.java
*@FileTitle : SAC Master Data (India)
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.27
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.06.27 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.mdmdatamgt.mdmdatamgt.event;

import com.hanjin.apps.alps.esm.bkg.mdmdatamgt.mdmdatamgt.vo.SearchMdmChargeVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MdmChargeVO;


/**
 * esm_bkg_S003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  esm_bkg_S003HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SONG Min Seok
 * @see esm_bkg_S003HTMLAction 참조 
 * @since J2EE 1.6
 */

public class EsmBkgS003Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMdmChargeVO searchMdmChargeVO = null;
	   /** Table Value Object Multi Data 처리 */

	private SearchMdmChargeVO[] searchMdmChargeVOs = null;

	/** Table Value Object Multi Data 처리 */
	private MdmChargeVO[] mdmChargeVOs = null;
    /** Table Value Object 조회 조건 및 단건 처리  */
    private MdmChargeVO mdmChargeVO = null;
    
	public EsmBkgS003Event(){}
	
	public void setSearchMdmChargeVO(SearchMdmChargeVO searchMdmChargeVO){
		this. searchMdmChargeVO = searchMdmChargeVO;
	}

	public void setSearchMdmChargeVOS(SearchMdmChargeVO[] searchMdmChargeVOs){
		this. searchMdmChargeVOs = searchMdmChargeVOs;
	}

	public SearchMdmChargeVO getSearchMdmChargeVO(){
		return searchMdmChargeVO;
	}

	public SearchMdmChargeVO[] getSearchMdmChargeVOS(){
		return searchMdmChargeVOs;
	}
	
	
	
   public void setMdmChargeVO(MdmChargeVO mdmChargeVO){
        this. mdmChargeVO = mdmChargeVO;
    }

    public void setMdmChargeVOS(MdmChargeVO[] mdmChargeVOs){
        this. mdmChargeVOs = mdmChargeVOs;
    }

    public MdmChargeVO getMdmChargeVO(){
        return mdmChargeVO;
    }

    public MdmChargeVO[] getMdmChargeVOS(){
        return mdmChargeVOs;
    }

}