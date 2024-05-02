/**
 * 
 */
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo;

import java.util.HashMap;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.vo.UsaCheckListDetailListVO;
import com.hanjin.framework.component.common.AbstractValueObject;


/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김도완
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class CheckListDetailListVO extends AbstractValueObject {
	private static final long serialVersionUID = 1L;
	//private Collection<CheckListDetailListVO> models = new ArrayList<CheckListDetailListVO>();
	@Override
	public HashMap<String, String> getColumnValues() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, String> getFieldNames() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private List<UsaCheckListDetailListVO> manifestStatusResultList;
	private List<UsaCheckListDetailListVO> blToBeDeletedResultList;
	
	public CheckListDetailListVO() {}
	

	public List<UsaCheckListDetailListVO> getManifestStatusResultList() {
		return manifestStatusResultList;
	}

	public List<UsaCheckListDetailListVO> getBlToBeDeletedResultList() {
		return blToBeDeletedResultList;
	}
	
	public void setManifestStatusResultList(List<UsaCheckListDetailListVO> manifestStatusResultList) {
		this.manifestStatusResultList = manifestStatusResultList;
	}

	public void setBlToBeDeletedResultList(List<UsaCheckListDetailListVO> blToBeDeletedResultList) {
		this.blToBeDeletedResultList = blToBeDeletedResultList;
	}
	
}
