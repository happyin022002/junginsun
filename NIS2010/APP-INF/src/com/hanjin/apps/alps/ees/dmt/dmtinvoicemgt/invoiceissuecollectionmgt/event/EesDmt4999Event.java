package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event;

import java.util.List;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfCntrVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfMnVO;
import com.hanjin.framework.support.layer.event.EventSupport;

public class EesDmt4999Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	public EesDmt4999Event(){}
	
	private InvArIfMnVO invArIfMnVO = null;
	private List<InvArIfChgVO> invArIfChgVOs = null;
	private List<InvArIfCntrVO> invArIfCntrVOs = null;
	
	public InvArIfMnVO getInvArIfMnVO() {
		return invArIfMnVO;
	}
	public void setInvArIfMnVO(InvArIfMnVO invArIfMnVO) {
		this.invArIfMnVO = invArIfMnVO;
	}
	public List<InvArIfChgVO> getInvArIfChgVOs() {
		return invArIfChgVOs;
	}
	public void setInvArIfChgVOs(List<InvArIfChgVO> invArIfChgVOs) {
		this.invArIfChgVOs = invArIfChgVOs;
	}
	public List<InvArIfCntrVO> getInvArIfCntrVOs() {
		return invArIfCntrVOs;
	}
	public void setInvArIfCntrVOs(List<InvArIfCntrVO> invArIfCntrVOs) {
		this.invArIfCntrVOs = invArIfCntrVOs;
	}
}