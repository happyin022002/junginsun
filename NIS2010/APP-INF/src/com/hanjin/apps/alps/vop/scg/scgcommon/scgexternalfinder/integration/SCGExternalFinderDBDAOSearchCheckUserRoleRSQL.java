/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SCGExternalFinderDBDAOSearchCheckUserRoleRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.22
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.11.22 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.scgcommon.scgexternalfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM YOUNG-OH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGExternalFinderDBDAOSearchCheckUserRoleRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCheckUserRole
	  * </pre>
	  */
	public SCGExternalFinderDBDAOSearchCheckUserRoleRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pgm_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.scgcommon.scgexternalfinder.integration").append("\n"); 
		query.append("FileName : SCGExternalFinderDBDAOSearchCheckUserRoleRSQL").append("\n"); 
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
		query.append("SELECT  CASE WHEN @[pgm_no] = 'VOP_SCG_0080' THEN" ).append("\n"); 
		query.append("            CASE " ).append("\n"); 
		query.append("            WHEN USR_ROLE_CD LIKE '%SCG01%' THEN 'ALL'" ).append("\n"); 
		query.append("            WHEN USR_ROLE_CD LIKE '%SCG02%' THEN 'ALL'" ).append("\n"); 
		query.append("            WHEN USR_ROLE_CD LIKE '%SCG99%' THEN 'RET'" ).append("\n"); 
		query.append("            END" ).append("\n"); 
		query.append("        ELSE " ).append("\n"); 
		query.append("            'XXX'" ).append("\n"); 
		query.append("        END AS        USR_ROLE_CD" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        SELECT  XMLAGG(XMLELEMENT(x,T1.USR_ROLE_CD) ORDER BY T1.USR_ROLE_CD).EXTRACT('//text()').GETSTRINGVAL() AS USR_ROLE_CD" ).append("\n"); 
		query.append("        FROM 	COM_USR_ROLE_MTCH T1" ).append("\n"); 
		query.append("        	,	COM_PGM_ROLE      T2" ).append("\n"); 
		query.append("        WHERE	T1.USR_ID      = @[usr_id]" ).append("\n"); 
		query.append("        AND	    T1.USR_ROLE_CD = T2.USR_ROLE_CD" ).append("\n"); 
		query.append("        AND     T2.PGM_NO      = @[pgm_no]" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 

	}
}