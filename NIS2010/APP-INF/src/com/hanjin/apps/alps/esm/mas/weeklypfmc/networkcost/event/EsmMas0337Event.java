/*=========================================================
*Copyright(c) 2014 CyberLogitec
**@FileName : EsmMas0337Event.java
*@FileTitle : G&A Expense Creation by Office
*Open Issues :
*Change history :
*@LastModifyDate : 2014-12-12
*@LastModifier : Je Ryang Yoo
*@LastVersion : 
*  2014-12-12 Je Ryang Yoo
*  1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.event;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.GNAExpAssignVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MasGenExpnAsgnVO;

/**
 * ESM_MAS_0337 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0337HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Dae
 * @see ESM_MAS_0337HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0337Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	/** 단건처리 */
	private GNAExpAssignVO gnaExpAssignVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private GNAExpAssignVO[] gnaExpAssignVOs = null;
	
	
	
	/** 단건처리 */
	private SearchConditionVO mSearchConditionVO = null;
	
	/** Save 단건 처리 */
	private MasGenExpnAsgnVO mMasGenExpnAsgnVO = null;
	
	/** Save Multi Data 처리 */
    private MasGenExpnAsgnVO[] mMasGenExpnAsgnVOs = null;


	/** Constructor */
	public EsmMas0337Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmMas0337Event";
	}
	
	
	/** ValueObject Getter */
	public GNAExpAssignVO getGNAExpAssignVO() {
		return gnaExpAssignVO;
	}
	
	/** ValueObject Setter */
	public void setGNAExpAssignVO(GNAExpAssignVO gnaExpAssignVO) {
		this.gnaExpAssignVO = gnaExpAssignVO;
	}
	
	/** ValueObject Array Getter - Create/Update/Delete */
	public GNAExpAssignVO[] getGNAExpAssignVOs() {
		return gnaExpAssignVOs;
	}
	
	/** ValueObject Array Setter - Create/Update/Delete */
	public void setGNAExpAssignVOs(GNAExpAssignVO[] gnaExpAssignVOs) {
		this.gnaExpAssignVOs = gnaExpAssignVOs;
	}
	
	
		
	  
	
	/** ValueObject Setter */
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this.mSearchConditionVO = searchConditionVO;
	}
	/** ValueObject Getter */
	public SearchConditionVO getSearchConditionVO(){
		return mSearchConditionVO;
	}

    public MasGenExpnAsgnVO getMasGenExpnAsgnVO() {
        return mMasGenExpnAsgnVO;
    }

    public void setMasGenExpnAsgnVO(MasGenExpnAsgnVO mMasGenExpnAsgnVO) {
        this.mMasGenExpnAsgnVO = mMasGenExpnAsgnVO;
    }

    public MasGenExpnAsgnVO[] getMasGenExpnAsgnVOs() {
        return mMasGenExpnAsgnVOs;
    }

    public void setMasGenExpnAsgnVOs(MasGenExpnAsgnVO[] mMasGenExpnAsgnVOs) {
        this.mMasGenExpnAsgnVOs = mMasGenExpnAsgnVOs;
    }		
			
}
