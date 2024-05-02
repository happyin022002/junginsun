/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ScqBreakbulkDBDAOaddPriScqBbProgCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.19
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2014.03.19 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SongHoJin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScqBreakbulkDBDAOaddPriScqBbProgCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addPriScqBbProg
	  * </pre>
	  */
	public ScqBreakbulkDBDAOaddPriScqBbProgCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scq_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prog_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prog_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prog_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scq_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.integration").append("\n"); 
		query.append("FileName : ScqBreakbulkDBDAOaddPriScqBbProgCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SCQ_PROG" ).append("\n"); 
		query.append("     ( SCQ_RQST_NO" ).append("\n"); 
		query.append("     , SCQ_VER_NO" ).append("\n"); 
		query.append("     , SPCL_CGO_TP_CD" ).append("\n"); 
		query.append("     , PROG_SEQ" ).append("\n"); 
		query.append("     , PROG_STS_CD" ).append("\n"); 
		query.append("     , PROG_OFC_CD" ).append("\n"); 
		query.append("     , PROG_USR_ID" ).append("\n"); 
		query.append("     , PROG_DT" ).append("\n"); 
		query.append("     , PROG_RMK" ).append("\n"); 
		query.append("     , CRE_USR_ID" ).append("\n"); 
		query.append("     , CRE_DT" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append("     , UPD_DT" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("     ( @[scq_rqst_no]" ).append("\n"); 
		query.append("     , @[scq_ver_no]" ).append("\n"); 
		query.append("     , 'BB'" ).append("\n"); 
		query.append("     , (SELECT NVL(MAX(PROG_SEQ),0)+1 " ).append("\n"); 
		query.append("          FROM PRI_SCQ_PROG" ).append("\n"); 
		query.append("         WHERE SCQ_RQST_NO = @[scq_rqst_no]" ).append("\n"); 
		query.append("           AND SCQ_VER_NO  = @[scq_ver_no]" ).append("\n"); 
		query.append("           AND SPCL_CGO_TP_CD = 'BB' )" ).append("\n"); 
		query.append("     , @[prog_sts_cd]" ).append("\n"); 
		query.append("     , @[prog_ofc_cd]" ).append("\n"); 
		query.append("     , @[cre_usr_id]" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("     , @[prog_rmk]" ).append("\n"); 
		query.append("     , @[cre_usr_id]" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("     , @[cre_usr_id]" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("     )" ).append("\n"); 

	}
}