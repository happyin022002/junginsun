/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : OwnDangerousCargoApprovalDBDAOAproRefNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.03
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2011.03.03 장창수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JangChangSu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnDangerousCargoApprovalDBDAOAproRefNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AproRefNo를 생성하는 화면
	  * </pre>
	  */
	public OwnDangerousCargoApprovalDBDAOAproRefNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : OwnDangerousCargoApprovalDBDAOAproRefNoRSQL").append("\n"); 
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
		query.append("SELECT      'COM'" ).append("\n"); 
		query.append("         || 'POL'" ).append("\n"); 
		query.append("         || TO_CHAR(SYSDATE, 'YYMMDD')" ).append("\n"); 
		query.append("         || LPAD('1', 3, '0')  AS APRO_REF_NO " ).append("\n"); 
		query.append("FROM     DUAL  " ).append("\n"); 

	}
}