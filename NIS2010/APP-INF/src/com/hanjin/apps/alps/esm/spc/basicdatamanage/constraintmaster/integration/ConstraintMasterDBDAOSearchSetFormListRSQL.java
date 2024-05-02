/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ConstraintMasterDBDAOSearchSetFormListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.30
*@LastModifier : Arie
*@LastVersion : 1.0
* 2015.03.30 Arie
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Arie
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConstraintMasterDBDAOSearchSetFormListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SPC_RPT_FOM select
	  * </pre>
	  */
	public ConstraintMasterDBDAOSearchSetFormListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pgm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration").append("\n"); 
		query.append("FileName : ConstraintMasterDBDAOSearchSetFormListRSQL").append("\n"); 
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
		query.append("SELECT mst.PGM_NO AS PGM_NO" ).append("\n"); 
		query.append("   , MST.RPT_FOM_DESC              AS RPT_FOM_DESC" ).append("\n"); 
		query.append("   , DTL.DP_SEQ                 AS DP_SEQ" ).append("\n"); 
		query.append("   , DTL.COL_NM                AS COL_NM" ).append("\n"); 
		query.append("   , DTL.DP_NM                   AS DP_NM" ).append("\n"); 
		query.append("   , DTL.RPT_FOM_NO   			AS RPT_FOM_NO" ).append("\n"); 
		query.append("  FROM SPC_RPT_FOM MST" ).append("\n"); 
		query.append("     , SPC_RPT_FOM_DTL DTL" ).append("\n"); 
		query.append("   WHERE MST.CRE_USR_ID = DTL.CRE_USR_ID(+)" ).append("\n"); 
		query.append("     AND MST.PGM_NO = DTL.PGM_NO(+)" ).append("\n"); 
		query.append("	 AND MST.RPT_FOM_NO = DTL.RPT_FOM_NO" ).append("\n"); 
		query.append("     --AND MST.DELT_FLG = 'N'" ).append("\n"); 
		query.append("     AND MST.RPT_FOM_NO = '1'" ).append("\n"); 
		query.append("     AND MST.CRE_USR_ID = 'DEFAULT'" ).append("\n"); 
		query.append("     AND MST.PGM_NO=@[pgm]" ).append("\n"); 
		query.append("     ORDER BY DP_SEQ" ).append("\n"); 

	}
}