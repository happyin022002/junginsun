/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ConstraintMasterDBDAOMultiSetFormRegistMasterCSQL.java
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

public class ConstraintMasterDBDAOMultiSetFormRegistMasterCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SPC_RPT_FOM insert
	  * </pre>
	  */
	public ConstraintMasterDBDAOMultiSetFormRegistMasterCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpt_fom_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpt_fom_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pgm_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpt_fom_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration").append("\n"); 
		query.append("FileName : ConstraintMasterDBDAOMultiSetFormRegistMasterCSQL").append("\n"); 
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
		query.append("INSERT INTO SPC_RPT_FOM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	PGM_NO	" ).append("\n"); 
		query.append("   , CRE_USR_ID" ).append("\n"); 
		query.append("   , rpt_fom_no" ).append("\n"); 
		query.append("   , rpt_fom_nm" ).append("\n"); 
		query.append("   , Rpt_Fom_Desc" ).append("\n"); 
		query.append("   , Delt_Flg" ).append("\n"); 
		query.append("   , Dp_Seq" ).append("\n"); 
		query.append("   , CRE_DT" ).append("\n"); 
		query.append("   , UPD_USR_ID" ).append("\n"); 
		query.append("   , UPD_DT" ).append("\n"); 
		query.append(")VALUES(" ).append("\n"); 
		query.append("     @[pgm_no]" ).append("\n"); 
		query.append("   , @[cre_usr_id]" ).append("\n"); 
		query.append("   , @[rpt_fom_no]" ).append("\n"); 
		query.append("   , @[rpt_fom_nm]" ).append("\n"); 
		query.append("   , @[rpt_fom_desc]" ).append("\n"); 
		query.append("   , 'N' " ).append("\n"); 
		query.append("   , (SELECT NVL(MAX(dp_seq),0)+1 seq " ).append("\n"); 
		query.append("      FROM SPC_RPT_FOM" ).append("\n"); 
		query.append("        WHERE CRE_USR_ID = @[cre_usr_id] AND PGM_NO = @[pgm_no]" ).append("\n"); 
		query.append("              GROUP BY CRE_USR_ID)" ).append("\n"); 
		query.append("                           " ).append("\n"); 
		query.append("   , SYSDATE" ).append("\n"); 
		query.append("   , @[upd_usr_id]" ).append("\n"); 
		query.append("   , SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}