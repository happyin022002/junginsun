package com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.ScgImdgClssSegrListVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.ScgImdgCompGrpSegrListVO;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이도형
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class SegregationTableGrpVO {
	
	ScgImdgClssSegrListVO  scgImdgClssSegrListVO  = getScgImdgClssSegrListVO();
	ScgImdgCompGrpSegrListVO scgImdgCompGrpSegrListVO = getScgImdgCompGrpSegrListVO();

	private ScgImdgClssSegrListVO[] scgImdgClssSegrListVOs = null;
	private ScgImdgCompGrpSegrListVO[] scgImdgCompGrpSegrListVOs = null;

	
	public ScgImdgClssSegrListVO getScgImdgClssSegrListVO() {
		return scgImdgClssSegrListVO;
	}

	public ScgImdgCompGrpSegrListVO getScgImdgCompGrpSegrListVO() {
		return scgImdgCompGrpSegrListVO;
	}

	public void setScgImdgClssSegrListVO(ScgImdgClssSegrListVO scgImdgClssSegrListVO) {
		this.scgImdgClssSegrListVO = scgImdgClssSegrListVO;
	}

	public void setScgImdgCompGrpSegrListVO(ScgImdgCompGrpSegrListVO scgImdgCompGrpSegrListVO) {
		this.scgImdgCompGrpSegrListVO = scgImdgCompGrpSegrListVO;
	}


	public ScgImdgClssSegrListVO[] getScgImdgClssSegrListVOs() {
		return scgImdgClssSegrListVOs;
	}

	public ScgImdgCompGrpSegrListVO[] getScgImdgCompGrpSegrListVOs() {
		return scgImdgCompGrpSegrListVOs;
	}

	public void setScgImdgClssSegrListVOs(ScgImdgClssSegrListVO[] scgImdgClssSegrListVOs) {
		this.scgImdgClssSegrListVOs = scgImdgClssSegrListVOs;
	}

	public void setScgImdgCompGrpSegrListVOs(ScgImdgCompGrpSegrListVO[] scgImdgCompGrpSegrListVOs) {
		this.scgImdgCompGrpSegrListVOs = scgImdgCompGrpSegrListVOs;
	}	

}
