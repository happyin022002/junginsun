/*========================================================
*Copyright(c) 2009 CyberLogitec
*ProcessChain    : NPI
*@FileName       : BackEndJobSearchSampleBC.java
*@FileTitle      : NIS2010
*Open Issues     :
*Change history  :
*@LastModifyDate : Sep 22, 2009
*@LastModifier   : Jeong-Hoon, KIM
*@LastVersion    : 1.0
=========================================================*/
package com.clt.sample.backendjob.thread.basic;

import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * 
 * BackEndJobSearchSampleBC.java
 * @author Jeong-Hoon, KIM
 * @see 
 * @since J2SE 1.6
 * 2016. 1. 11.
 */
public interface BackEndJobSearchSampleBC {
	
	String doStart(SignOnUserAccount account);

}
