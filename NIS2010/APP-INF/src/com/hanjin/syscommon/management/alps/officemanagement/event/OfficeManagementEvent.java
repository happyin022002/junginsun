/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : OfficeManagementEvent.java
*@FileTitle : Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2009.07.02 정인선
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.officemanagement.event;

import java.util.Arrays;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.ComOfcPgmMtchVO;
import com.hanjin.syscommon.management.alps.officemanagement.vo.OfficListVO;

/**
 * Office_Management 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  Office_ManagementHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung In Sun
 * @see Office_ManagementHTMLAction 참조
 * @since J2EE 1.6
 */
public class OfficeManagementEvent extends EventSupport
{

    public OfficeManagementEvent()
    {
        comOfcPgmMtchVO = null;
        comOfcPgmMtchVOs = null;
        officListVO = null;
        officListVOs = null;
        pgmNo = null;
    }

    public void setComOfcPgmMtchVO(ComOfcPgmMtchVO comOfcPgmMtchVO)
    {
        this.comOfcPgmMtchVO = comOfcPgmMtchVO;
    }

    public void setComOfcPgmMtchVOS(ComOfcPgmMtchVO[] comOfcPgmMtchVOs){
		if(comOfcPgmMtchVOs != null) {
			ComOfcPgmMtchVO[] tmpVOs= Arrays.copyOf(comOfcPgmMtchVOs, comOfcPgmMtchVOs.length);
			this. comOfcPgmMtchVOs = tmpVOs;
		}
	}

    public void setOfficListVO(OfficListVO officListVO)
    {
        this.officListVO = officListVO;
    }

    public void setOfficListVOS(OfficListVO[] officListVOs){
		if(officListVOs != null) {
			OfficListVO[] tmpVOs= Arrays.copyOf(officListVOs, officListVOs.length);
			this. officListVOs = tmpVOs;
		}
	}

    public ComOfcPgmMtchVO getComOfcPgmMtchVO()
    {
        return comOfcPgmMtchVO;
    }

   public ComOfcPgmMtchVO[] getComOfcPgmMtchVOS(){
		ComOfcPgmMtchVO[] rtnVOs = null;
		if(this.comOfcPgmMtchVOs!= null) {
			rtnVOs=Arrays.copyOf(comOfcPgmMtchVOs, comOfcPgmMtchVOs.length);	
		}
		return rtnVOs;
	}

    public OfficListVO getOfficListVO()
    {
        return officListVO;
    }

    public OfficListVO[] getOfficListVOS(){
		OfficListVO[] rtnVOs = null;
		if(this.officListVOs!= null) {
			rtnVOs=Arrays.copyOf(officListVOs, officListVOs.length);	
		}
		return rtnVOs;
	}

    public String getPgm_no()
    {
        return pgmNo;
    }

    public void setPgm_no(String pgm_no)
    {
        pgmNo = pgm_no;
    }

    private static final long serialVersionUID = 1L;
    private ComOfcPgmMtchVO comOfcPgmMtchVO;
    private ComOfcPgmMtchVO comOfcPgmMtchVOs[];
    private OfficListVO officListVO;
    private OfficListVO officListVOs[];
    private String pgmNo;
}
