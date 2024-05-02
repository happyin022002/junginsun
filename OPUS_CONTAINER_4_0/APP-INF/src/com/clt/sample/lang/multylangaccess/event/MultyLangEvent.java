/*========================================================
 *Copyright(c) 2009 CyberLogitec
 *ProcessChain    : NPI
 *@FileName       : MultyLangEvent.java
 *@FileTitle      : NIS2010
 *Open Issues     :
 *Change history  :
 *@LastModifyDate : Jul 29, 2009
 *@LastModifier   : XXX
 *@LastVersion    : 1.0
=========================================================*/
package com.clt.sample.lang.multylangaccess.event;

import java.util.Arrays;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgClzTmVO;
import com.clt.syscommon.common.table.ComUserVO;

/**
 * 
 * MultyLangEvent.java
 * @author Jeong-Hoon, KIM
 * @see 
 * @since J2SE 1.6
 * 2016. 1. 11.
 */
public class MultyLangEvent extends EventSupport implements Event{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private ComUserVO comUserVO = null;

	private ComUserVO[] comUserVOs = null;
	
	
	

	public ComUserVO[] getComUserVOs() {
		ComUserVO[] tmpVOs = null;
		if (this.comUserVOs != null) {
			tmpVOs = Arrays.copyOf(comUserVOs, comUserVOs.length);
		}
		return tmpVOs;
	}


	public void setComUserVOs(ComUserVO[] comUserVOs) {
		if(comUserVOs != null){
			ComUserVO[] tmpVOs = Arrays.copyOf(comUserVOs, comUserVOs.length);
			this.comUserVOs = tmpVOs;
		}
	}


	public ComUserVO getComUserVO() {
		return comUserVO;
	}


	public void setComUserVO(ComUserVO comUserVO) {
		this.comUserVO = comUserVO;
	}
	
	
	
}
