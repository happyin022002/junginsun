/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BLIssuanceDBDAOmodifyOtrBlRqstUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOmodifyOtrBlRqstUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BLIssuanceDBDAOmodifyOtrBlRqstUSQL
	  * </pre>
	  */
	public BLIssuanceDBDAOmodifyOtrBlRqstUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_bl_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOmodifyOtrBlRqstUSQL").append("\n"); 
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
		query.append("UPDATE BKG_N3RD_PTY_BL_BIL_RQST" ).append("\n"); 
		query.append("SET N3PTY_BL_STS_CD = @[n3pty_bl_sts_cd]" ).append("\n"); 
		query.append("   ,N3PTY_BL_STS_RQST_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("   ,N3PTY_BL_STS_UPD_DT = sysdate" ).append("\n"); 
		query.append("   ,UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("   ,UPD_DT = sysdate" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("  AND N3PTY_BL_STS_CD in ('R','X')" ).append("\n"); 
		query.append("  AND 'Y' = (SELECT CASE WHEN TO_DATE(REPLACE(REPLACE(REPLACE(@[rqst_dt],'-',''),':',''),' ',''),'YYYYMMDDHH24MISS') >= CRE_DT THEN 'Y'" ).append("\n"); 
		query.append("                   ELSE 'N' " ).append("\n"); 
		query.append("                   END AS CRE_FLG" ).append("\n"); 
		query.append("             FROM (" ).append("\n"); 
		query.append("                  SELECT *" ).append("\n"); 
		query.append("                    FROM BKG_N3RD_PTY_BL_BIL_RQST" ).append("\n"); 
		query.append("                   WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                  ORDER BY CRE_DT DESC" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("            WHERE ROWNUM = 1)" ).append("\n"); 
		query.append("  AND CRE_DT < TO_DATE(REPLACE(REPLACE(REPLACE(@[rqst_dt],'-',''),':',''),' ',''),'YYYYMMDDHH24MISS')" ).append("\n"); 

	}
}