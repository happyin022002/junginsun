/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BlRatingDBDAOModifyAudDtUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.21
*@LastModifier : 
*@LastVersion : 1.0
* 2014.02.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOModifyAudDtUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BlRatingDBDAOModifyAudDtUSQL
	  * </pre>
	  */
	public BlRatingDBDAOModifyAudDtUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_aud_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOModifyAudDtUSQL").append("\n"); 
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
		query.append("UPDATE BKG_RATE R" ).append("\n"); 
		query.append("#if (${rev_aud_dt} != '') " ).append("\n"); 
		query.append("SET R.REV_AUD_DT = TO_DATE(@[rev_aud_dt],'YYYYMMDDHH24MISS')," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SET R.REV_AUD_DT = SYSDATE," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("R.LST_AUD_BAT_DT = NVL((SELECT MAX(N1ST_UMCH_FND_DT) FROM BKG_REV_UMCH_BKG U WHERE U.BKG_NO = R.BKG_NO),SYSDATE)," ).append("\n"); 
		query.append("R.UPD_USR_ID = @[user_id], " ).append("\n"); 
		query.append("R.UPD_DT = SYSDATE " ).append("\n"); 
		query.append("WHERE R.BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}