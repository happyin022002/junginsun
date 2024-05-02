/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CommonDBDAOInsertVslLayupTotCopyCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.21
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2014.07.21 최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Duk Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOInsertVslLayupTotCopyCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COA_MNL_COST_STUP 테이블에 total값 입력
	  * </pre>
	  */
	public CommonDBDAOInsertVslLayupTotCopyCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tot_sum",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_tar_week",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOInsertVslLayupTotCopyCSQL").append("\n"); 
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
		query.append("INSERT INTO COA_MNL_COST_STUP " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    COST_YRMON" ).append("\n"); 
		query.append("    ,COST_WK" ).append("\n"); 
		query.append("    ,TRD_CD" ).append("\n"); 
		query.append("    ,RLANE_CD" ).append("\n"); 
		query.append("    ,IOC_CD" ).append("\n"); 
		query.append("    ,DIR_CD" ).append("\n"); 
		query.append("    ,SUB_TRD_CD" ).append("\n"); 
		query.append("    ,OTR_EXPN_AMT" ).append("\n"); 
		query.append("    ,CRE_USR_ID" ).append("\n"); 
		query.append("    ,CRE_DT" ).append("\n"); 
		query.append("    ,UPD_USR_ID" ).append("\n"); 
		query.append("    ,UPD_DT" ).append("\n"); 
		query.append("    ,MTY_INV_AMT" ).append("\n"); 
		query.append("    ,APLY_ADJ_PL_FLG" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    (SELECT COST_YR||EQ_WK FROM COA_WK_PRD WHERE COST_YR = SUBSTR(REPLACE(@[f_tar_week],'-',''),1,4) AND COST_WK = SUBSTR(REPLACE(@[f_tar_week],'-',''),5,2))" ).append("\n"); 
		query.append("    ,SUBSTR(REPLACE(@[f_tar_week],'-',''),5,2)" ).append("\n"); 
		query.append("    ,'COM'" ).append("\n"); 
		query.append("    ,@[rlane_cd]" ).append("\n"); 
		query.append("    ,'O'" ).append("\n"); 
		query.append("    ,'M'" ).append("\n"); 
		query.append("    ,'OT'" ).append("\n"); 
		query.append("    ,@[tot_sum]" ).append("\n"); 
		query.append("    ,@[usr_id]" ).append("\n"); 
		query.append("    ,SYSDATE" ).append("\n"); 
		query.append("    ,@[usr_id]" ).append("\n"); 
		query.append("    ,SYSDATE" ).append("\n"); 
		query.append("    ,NULL" ).append("\n"); 
		query.append("    ,NULL    " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}