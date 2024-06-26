/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BkgCopManageDBDAOMergeCoaCopIfMgmtCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.26
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOMergeCoaCopIfMgmtCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 일배치 대상으로 bkg no 를 MAS 로 전송한다.
	  * </pre>
	  */
	public BkgCopManageDBDAOMergeCoaCopIfMgmtCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOMergeCoaCopIfMgmtCSQL").append("\n"); 
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
		query.append("merge into mas_cop_if_mgmt m" ).append("\n"); 
		query.append("    using (" ).append("\n"); 
		query.append("        SELECT BKG_NO FROM BKG_BOOKING H" ).append("\n"); 
		query.append("        WHERE BKG_NO IN (" ).append("\n"); 
		query.append("       #foreach($ele IN ${bkg_no})" ).append("\n"); 
		query.append("			#if($velocityCount == 1 ) " ).append("\n"); 
		query.append("				'$ele'" ).append("\n"); 
		query.append("			#else " ).append("\n"); 
		query.append("				,'$ele' " ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("        )V" ).append("\n"); 
		query.append("    on (" ).append("\n"); 
		query.append("        M.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    WHEN MATCHED THEN UPDATE" ).append("\n"); 
		query.append("        SET m.MAS_DY_BAT_CD = 'n'" ).append("\n"); 
		query.append("        ,m.COST_IF_DY_RMK = 'RouteReplan'" ).append("\n"); 
		query.append("        ,m.UPD_USR_ID = 'RouteReplan'" ).append("\n"); 
		query.append("        ,m.UPD_DT     = SYSDATE" ).append("\n"); 
		query.append("    WHEN NOT MATCHED THEN " ).append("\n"); 
		query.append("        INSERT (  BKG_NO" ).append("\n"); 
		query.append("        ,MAS_DY_BAT_CD" ).append("\n"); 
		query.append("        ,COST_IF_DY_RMK" ).append("\n"); 
		query.append("        ,CRE_DT" ).append("\n"); 
		query.append("        ,CRE_USR_ID" ).append("\n"); 
		query.append("        ,UPD_DT" ).append("\n"); 
		query.append("        ,UPD_USR_ID" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        VALUES ( V.BKG_NO" ).append("\n"); 
		query.append("        ,'n'" ).append("\n"); 
		query.append("        ,'RouteReplan'" ).append("\n"); 
		query.append("        ,SYSDATE" ).append("\n"); 
		query.append("        ,'RouteReplan'" ).append("\n"); 
		query.append("        ,SYSDATE" ).append("\n"); 
		query.append("        ,'RouteReplan'" ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}