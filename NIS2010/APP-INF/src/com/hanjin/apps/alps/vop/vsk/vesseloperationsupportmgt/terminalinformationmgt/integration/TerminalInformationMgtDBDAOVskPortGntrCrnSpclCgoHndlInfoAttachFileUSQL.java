/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : TerminalInformationMgtDBDAOVskPortGntrCrnSpclCgoHndlInfoAttachFileUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.19
*@LastModifier : 
*@LastVersion : 1.0
* 2013.03.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalInformationMgtDBDAOVskPortGntrCrnSpclCgoHndlInfoAttachFileUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * G/Crane 작업시 Special Cargo Handling Information에 대한 첨부파일 수정
	  * </pre>
	  */
	public TerminalInformationMgtDBDAOVskPortGntrCrnSpclCgoHndlInfoAttachFileUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.integration ").append("\n"); 
		query.append("FileName : TerminalInformationMgtDBDAOVskPortGntrCrnSpclCgoHndlInfoAttachFileUSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("update" ).append("\n"); 

	}
}