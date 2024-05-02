/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TesAdvanceAuditDBDAOLgsCostSubjCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.01
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2015.07.01 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.tesadvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong Ock, Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TesAdvanceAuditDBDAOLgsCostSubjCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * LgsCostSubjCd
	  * </pre>
	  */
	public TesAdvanceAuditDBDAOLgsCostSubjCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.tesadvanceaudit.integration").append("\n"); 
		query.append("FileName : TesAdvanceAuditDBDAOLgsCostSubjCdRSQL").append("\n"); 
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
		query.append("SELECT LGS_COST_SUBJ_CD " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT  LC.LGS_COST_SUBJ_CD" ).append("\n"); 
		query.append("              , MIN(LC.LGS_COST_OPT_NO)  " ).append("\n"); 
		query.append("        FROM TES_LGS_COST LC" ).append("\n"); 
		query.append("           , TES_TML_SO_COST SC" ).append("\n"); 
		query.append("        WHERE LGS_COST_SUBJ_CD IS NOT NULL " ).append("\n"); 
		query.append("        AND   LC.LGS_COST_CD = SC.LGS_COST_CD" ).append("\n"); 
		query.append("        GROUP BY LC.LGS_COST_SUBJ_CD " ).append("\n"); 
		query.append("        ORDER BY MIN(LC.LGS_COST_OPT_NO)" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("ORDER BY LGS_COST_SUBJ_CD DESC" ).append("\n"); 

	}
}