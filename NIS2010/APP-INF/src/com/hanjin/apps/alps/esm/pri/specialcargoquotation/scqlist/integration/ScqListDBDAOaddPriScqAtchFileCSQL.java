/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScqListDBDAOaddPriScqAtchFileCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.04
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.04.04 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dong-sun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScqListDBDAOaddPriScqAtchFileCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addPriScqAtchFile
	  * </pre>
	  */
	public ScqListDBDAOaddPriScqAtchFileCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_sav_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("scq_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.integration").append("\n"); 
		query.append("FileName : ScqListDBDAOaddPriScqAtchFileCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SCQ_ATCH_FILE" ).append("\n"); 
		query.append("     ( SCQ_RQST_NO    " ).append("\n"); 
		query.append("     , SPCL_CGO_TP_CD" ).append("\n"); 
		query.append("     , FILE_SAV_ID   " ).append("\n"); 
		query.append("     , ORG_FILE_NM   " ).append("\n"); 
		query.append("     , CRE_USR_ID    " ).append("\n"); 
		query.append("     , CRE_DT        " ).append("\n"); 
		query.append("     , UPD_USR_ID    " ).append("\n"); 
		query.append("     , UPD_DT ) " ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("     ( @[scq_rqst_no]    " ).append("\n"); 
		query.append("     , @[spcl_cgo_tp_cd]" ).append("\n"); 
		query.append("     , @[file_sav_id]   " ).append("\n"); 
		query.append("     , (SELECT FILE_UPLD_NM" ).append("\n"); 
		query.append("          FROM COM_UPLD_FILE" ).append("\n"); 
		query.append("         WHERE FILE_SAV_ID = @[file_sav_id]" ).append("\n"); 
		query.append("           AND PGM_SUB_SYS_CD = 'PRI')     " ).append("\n"); 
		query.append("     , @[cre_usr_id]    " ).append("\n"); 
		query.append("     , SYSDATE        " ).append("\n"); 
		query.append("     , @[cre_usr_id]    " ).append("\n"); 
		query.append("     , SYSDATE )" ).append("\n"); 

	}
}