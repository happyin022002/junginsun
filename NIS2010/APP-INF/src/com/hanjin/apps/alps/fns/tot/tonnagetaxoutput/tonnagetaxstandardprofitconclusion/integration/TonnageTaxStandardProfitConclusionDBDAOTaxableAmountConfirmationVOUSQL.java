/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TonnageTaxStandardProfitConclusionDBDAOTaxableAmountConfirmationVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TonnageTaxStandardProfitConclusionDBDAOTaxableAmountConfirmationVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TOT_VVD_STL_AMT 일수에 따른 정보 수정
	  * </pre>
	  */
	public TonnageTaxStandardProfitConclusionDBDAOTaxableAmountConfirmationVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dys_diff",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("stl_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tong_stl_bat_jb_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.integration").append("\n"); 
		query.append("FileName : TonnageTaxStandardProfitConclusionDBDAOTaxableAmountConfirmationVOUSQL").append("\n"); 
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
		query.append("UPDATE TOT_VVD_STL_AMT A SET" ).append("\n"); 
		query.append("     A.VOY_DYS =  (SELECT SUM(P.VOY_DYS)" ).append("\n"); 
		query.append("                   FROM TOT_PORT_STL_AMT P" ).append("\n"); 
		query.append("                   WHERE P.STL_YRMON = A.STL_YRMON" ).append("\n"); 
		query.append("                    AND P.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("                    AND P.TONG_STL_BAT_JB_SEQ = A.TONG_STL_BAT_JB_SEQ" ).append("\n"); 
		query.append("                   )   " ).append("\n"); 
		query.append("     ,A.TONG_TAX_AMT = (SELECT SUM(P.TONG_TAX_AMT)" ).append("\n"); 
		query.append("                        FROM TOT_PORT_STL_AMT P" ).append("\n"); 
		query.append("                        WHERE P.STL_YRMON = A.STL_YRMON" ).append("\n"); 
		query.append("                          AND P.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("                          AND P.TONG_STL_BAT_JB_SEQ = A.TONG_STL_BAT_JB_SEQ" ).append("\n"); 
		query.append("                       )  " ).append("\n"); 
		query.append("#if (${last_row_yn} == 'Y')" ).append("\n"); 
		query.append(",   TO_VVD_STL_DT = TO_VVD_STL_DT + @[dys_diff]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",	A.UPD_DT = SYSDATE" ).append("\n"); 
		query.append(",	A.UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("WHERE A.STL_YRMON = @[stl_yrmon]" ).append("\n"); 
		query.append("AND	A.TONG_STL_BAT_JB_SEQ = @[tong_stl_bat_jb_seq]" ).append("\n"); 
		query.append("AND	A.VSL_CD = @[vsl_cd]" ).append("\n"); 

	}
}