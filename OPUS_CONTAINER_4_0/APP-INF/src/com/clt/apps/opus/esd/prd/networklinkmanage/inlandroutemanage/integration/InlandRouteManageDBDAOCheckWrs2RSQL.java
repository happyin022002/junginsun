/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InlandRouteManageDBDAOCheckWrs2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandRouteManageDBDAOCheckWrs2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InlandRouteManageDBDAOCheckWrs2
	  * </pre>
	  */
	public InlandRouteManageDBDAOCheckWrs2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_rout_org_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_rout_dest_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.integration ").append("\n"); 
		query.append("FileName : InlandRouteManageDBDAOCheckWrs2RSQL").append("\n"); 
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
		query.append("SELECT WRS  wrs_f_chk" ).append("\n"); 
		query.append("FROM  " ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("    SELECT 'Y' WRS " ).append("\n"); 
		query.append("    FROM PRD_INLND_ROUT_MST" ).append("\n"); 
		query.append("    WHERE ROUT_ORG_NOD_CD = @[i_rout_org_nod_cd] " ).append("\n"); 
		query.append("    AND ROUT_DEST_NOD_CD = @[i_rout_dest_nod_cd] " ).append("\n"); 
		query.append("    AND ROUT_SEQ <> @[i_rout_seq] " ).append("\n"); 
		query.append("    AND WRS_MTY_CMDT_CD = 'MN' " ).append("\n"); 
		query.append("    AND NVL(DELT_FLG,'N') <> 'Y'  " ).append("\n"); 
		query.append("    AND PCTL_IO_BND_CD = 'M' " ).append("\n"); 
		query.append("    AND ROWNUM =1 " ).append("\n"); 
		query.append("    UNION ALL " ).append("\n"); 
		query.append("    SELECT 'N'  " ).append("\n"); 
		query.append("    FROM DUAL " ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("WHERE ROWNUM =1" ).append("\n"); 

	}
}