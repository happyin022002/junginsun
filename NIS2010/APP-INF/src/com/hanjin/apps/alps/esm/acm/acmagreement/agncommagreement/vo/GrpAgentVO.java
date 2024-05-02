/**
 * 
 */
package com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.vo;

import java.util.HashMap;
import java.util.List;

import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestAgmtVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestBodyVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestFileVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestHeaderVO;
import com.hanjin.framework.component.common.AbstractValueObject;

 
/**
 * @author Sarang
 *
 */
public class GrpAgentVO extends AbstractValueObject {
    /**
	 * 
	 */
	private static final long serialVersionUID = 6046705653068705893L;
	
	private ComCsrRequestHeaderVO headerVo 	  = null;
    private List<ComCsrRequestBodyVO> bodyVos = null;
    private List<ComCsrRequestAgmtVO> agmtVos = null;
    private List<ComCsrRequestFileVO> fileVos = null;
    
    public GrpAgentVO(){
    }

	public ComCsrRequestHeaderVO getHeaderVo() {
		return headerVo;
	}

	public void setHeaderVo(ComCsrRequestHeaderVO headerVo) {
		this.headerVo = headerVo;
	}

	public List<ComCsrRequestBodyVO> getBodyVos() {
		return bodyVos;
	}

	public void setBodyVos(List<ComCsrRequestBodyVO> bodyVos) {
		this.bodyVos = bodyVos;
	}

	public List<ComCsrRequestAgmtVO> getAgmtVos() {
		return agmtVos;
	}

	public void setAgmtVos(List<ComCsrRequestAgmtVO> agmtVos) {
		this.agmtVos = agmtVos;
	}
	
	public List<ComCsrRequestFileVO> getFileVos() {
		return fileVos;
	}

	public void setFileVos(List<ComCsrRequestFileVO> fileVos) {
		this.fileVos = fileVos;
	}
	
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

}
