/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ExpPap0007Event.java
*@FileTitle : WO Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2007-02-22
*@LastModifier : doomi
*@LastVersion : 1.0
* 2006-11-10 doomi
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.workorder.event;



import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author doomi
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class ExpPap0007Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	 private String eqNo							= ""; 
	
	
	
	
	/**
	 * 생성자
	 * @return
	 */
	public ExpPap0007Event(){}

	
	
	
	
    /**
     * 생성자 
     * @param eq_no
     */
    public ExpPap0007Event(
       	 	String eq_no		
    ) {
        this.eqNo							= eq_no;						
   
    }


	
    	
   	/**
	 * 
	 * @return
	 */
    public String getEq_no( )				{		
 		return eqNo;		}
	
    
	public void setEq_no					(String eq_no) 			{		
		this.eqNo = eq_no;		}
	
    
    	
	/**
	 * 
	 * @return
	 */
    public String getEventName() {
        return "ExpPap0007Event";
    }

	/**
	 * 
	 * @return
	 */
    public String toString() {
        return "ExpPap0007Event";
    }	

    
}
