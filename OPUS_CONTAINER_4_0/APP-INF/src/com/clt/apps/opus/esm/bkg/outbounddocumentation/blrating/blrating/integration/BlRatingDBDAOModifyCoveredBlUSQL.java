/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BlRatingDBDAOModifyCoveredBlUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOModifyCoveredBlUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public BlRatingDBDAOModifyCoveredBlUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_cvrd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOModifyCoveredBlUSQL").append("\n"); 
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
		query.append("#if (${caflag} == 'Y') " ).append("\n"); 
		query.append(" UPDATE BKG_RT_HIS" ).append("\n"); 
		query.append(" SET " ).append("\n"); 
		query.append("    RT_BL_TP_CD = @[bl_cvrd_tp_cd]" ).append("\n"); 
		query.append(" WHERE   " ).append("\n"); 
		query.append("	BKG_NO = " ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("	    SELECT BKG_NO FROM BKG_BKG_HIS WHERE BL_NO =  CASE WHEN LENGTH(@[bl_no])>=12 THEN SUBSTR(@[bl_no],0,12)" ).append("\n"); 
		query.append("                                                           ELSE SUBSTR(@[bl_no],0,10)" ).append("\n"); 
		query.append("                                                      END" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" UPDATE BKG_RATE" ).append("\n"); 
		query.append(" SET " ).append("\n"); 
		query.append("    RT_BL_TP_CD = @[bl_cvrd_tp_cd]" ).append("\n"); 
		query.append(" WHERE   " ).append("\n"); 
		query.append("	BKG_NO = " ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("	    SELECT BKG_NO FROM BKG_BOOKING WHERE BL_NO =  CASE WHEN LENGTH(@[bl_no])>=12 THEN SUBSTR(@[bl_no],0,12)" ).append("\n"); 
		query.append("                                                           ELSE SUBSTR(@[bl_no],0,10)" ).append("\n"); 
		query.append("                                                      END" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}