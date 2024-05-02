/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UNNumberGrpVO.java
*@FileTitle : UNNumberGrpVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.29
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.05.29 이도형 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo;

import java.util.ArrayList;
import java.util.List;
import com.hanjin.syscommon.common.table.ScgImdgUnNoVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.ScgImdgUnNoSegrListVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.UNNumberListOptionVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.syscommon.common.table.ScgImdgSubsRskLblVO;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이도형
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class UNNumberGrpVO {
	
	UNNumberListOptionVO  unNumberListOptionVO  = getUNNumberListOptionVO();
	ScgImdgUnNoSegrListVO scgImdgUnNoSegrListVO = getScgImdgUnNoSegrListVO();

	private UNNumberListOptionVO[] unNumberListOptionVOs = null;
	private ScgImdgUnNoSegrListVO[] scgImdgUnNoSegrListVOs = null;

	
	public UNNumberListOptionVO getUNNumberListOptionVO() {
		return unNumberListOptionVO;
	}

	public void setUNNumberListOptionVO(UNNumberListOptionVO unNumberListOptionVO) {
		this.unNumberListOptionVO = unNumberListOptionVO;
	}

	public ScgImdgUnNoSegrListVO getScgImdgUnNoSegrListVO() {
		return scgImdgUnNoSegrListVO;
	}

	public void setScgImdgUnNoSegrListVO(ScgImdgUnNoSegrListVO scgImdgUnNoSegrListVO) {
		this.scgImdgUnNoSegrListVO = scgImdgUnNoSegrListVO;
	}

	public UNNumberListOptionVO[] getUNNumberListOptionVOs() {
		return unNumberListOptionVOs;
	}

	public void setUNNumberListOptionVOs(UNNumberListOptionVO[] unNumberListOptionVOs) {
		this.unNumberListOptionVOs = unNumberListOptionVOs;
	}

	public ScgImdgUnNoSegrListVO[] getScgImdgUnNoSegrListVOs() {
		return scgImdgUnNoSegrListVOs;
	}

	public void setScgImdgUnNoSegrListVOs(ScgImdgUnNoSegrListVO[] scgImdgUnNoSegrListVOs) {
		this.scgImdgUnNoSegrListVOs = scgImdgUnNoSegrListVOs;
	}	

}
