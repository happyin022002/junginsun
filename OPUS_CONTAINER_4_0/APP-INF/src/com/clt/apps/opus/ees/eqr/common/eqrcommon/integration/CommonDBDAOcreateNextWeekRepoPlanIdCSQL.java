/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CommonDBDAOcreateNextWeekRepoPlanIdCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.27
*@LastModifier : 신용찬
*@LastVersion : 1.0
* 2014.05.27 신용찬
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.common.eqrcommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author YongChanShin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOcreateNextWeekRepoPlanIdCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CREATE REPO PLAN ID
	  * </pre>
	  */
	public CommonDBDAOcreateNextWeekRepoPlanIdCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scnr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repo_pln_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.common.eqrcommon.integration ").append("\n"); 
		query.append("FileName : CommonDBDAOcreateNextWeekRepoPlanIdCSQL").append("\n"); 
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
		query.append("INSERT INTO EQR_EQ_REPO_PLN" ).append("\n"); 
		query.append("            (  REPO_PLN_ID " ).append("\n"); 
		query.append("              ,SCNR_ID" ).append("\n"); 
		query.append("              ,INCL_ONH_FLG" ).append("\n"); 
		query.append("              ,INCL_OFFH_FLG	" ).append("\n"); 
		query.append("			  ,REPO_PLN_AUTO_GEN_FLG " ).append("\n"); 
		query.append("              ,REPO_PLN_RMK" ).append("\n"); 
		query.append("              ,DELT_FLG" ).append("\n"); 
		query.append("              ,CRE_USR_ID" ).append("\n"); 
		query.append("              ,CRE_DT" ).append("\n"); 
		query.append("              ,UPD_USR_ID" ).append("\n"); 
		query.append("              ,UPD_DT" ).append("\n"); 
		query.append("              ,INCL_CNTR_TPSZ_CTNT" ).append("\n"); 
		query.append("              ,REPO_PLN_DTRB_FLG" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("            VALUES" ).append("\n"); 
		query.append("            (  @[repo_pln_id]" ).append("\n"); 
		query.append("              ,@[scnr_id]" ).append("\n"); 
		query.append("              ,'Y'" ).append("\n"); 
		query.append("              ,'Y'" ).append("\n"); 
		query.append("              ,'Y'" ).append("\n"); 
		query.append("              ,'Manual Creation'" ).append("\n"); 
		query.append("              ,'N'" ).append("\n"); 
		query.append("              ,'SYSTEM'" ).append("\n"); 
		query.append("              ,SYSDATE" ).append("\n"); 
		query.append("              ,'SYSTEM'" ).append("\n"); 
		query.append("              ,SYSDATE" ).append("\n"); 
		query.append("              ,'D2,D4,D5,D7,R2,R5'" ).append("\n"); 
		query.append("              ,'Y'" ).append("\n"); 
		query.append("             )" ).append("\n"); 

	}
}