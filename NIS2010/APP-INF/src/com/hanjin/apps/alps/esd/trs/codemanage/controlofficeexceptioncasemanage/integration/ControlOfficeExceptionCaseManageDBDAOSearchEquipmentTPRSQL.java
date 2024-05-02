/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ControlOfficeExceptionCaseManageDBDAOSearchEquipmentTPRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2009.07.22 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.controlofficeexceptioncasemanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JH CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ControlOfficeExceptionCaseManageDBDAOSearchEquipmentTPRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container Type 조회
	  * </pre>
	  */
	public ControlOfficeExceptionCaseManageDBDAOSearchEquipmentTPRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.codemanage.controlofficeexceptioncasemanage.integration ").append("\n"); 
		query.append("FileName : ControlOfficeExceptionCaseManageDBDAOSearchEquipmentTPRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("CNTR_TP_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MDM_CNTR_TP" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("DELT_FLG		= 'N'" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("CNTR_TP_CD" ).append("\n"); 

	}
}