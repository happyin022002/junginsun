/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SpaceAllocationManageDBDAOSearchSpaceAllocationModelRun0054ListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.03
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2010.02.03 최윤성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpaceAllocationManageDBDAOSearchSpaceAllocationModelRun0054ListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Model 실행
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOSearchSpaceAllocationModelRun0054ListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("status",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sdate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAOSearchSpaceAllocationModelRun0054ListRSQL").append("\n"); 
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
		query.append("  SELECT T.RALOC_VER_NO         AS VER_NO," ).append("\n"); 
		query.append("         T.RALOC_MDL_EXE_STS_CD AS STS_CD," ).append("\n"); 
		query.append("         T.RALOC_MDL_EXE_STS_CD AS STS_NM," ).append("\n"); 
		query.append("         T.EXE_USR_ID           AS USR_ID," ).append("\n"); 
		query.append("         TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC('GMT', T.EXE_GDT    , @[ofc_cd]), 'YYYY-MM-DD HH24:MI:SS') AS EXE_DT," ).append("\n"); 
		query.append("         TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC('GMT', T.MDL_ST_GDT , @[ofc_cd]), 'YYYY-MM-DD HH24:MI:SS') AS ST_DT ," ).append("\n"); 
		query.append("         TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC('GMT', T.MDL_END_GDT, @[ofc_cd]), 'YYYY-MM-DD HH24:MI:SS') AS END_DT" ).append("\n"); 
		query.append("    FROM SPC_RALOC_MDL_EXE T" ).append("\n"); 
		query.append("   WHERE TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC('GMT', T.EXE_GDT, @[ofc_cd]), 'YYYY-MM-DD HH24:MI:SS') BETWEEN @[sdate]||' 00:00:00' AND @[edate]||' 23:59:59'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${user} != '')" ).append("\n"); 
		query.append("     AND T.EXE_USR_ID = @[user]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${status} != '')" ).append("\n"); 
		query.append("     AND T.RALOC_MDL_EXE_STS_CD = @[status]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY T.EXE_GDT DESC" ).append("\n"); 

	}
}