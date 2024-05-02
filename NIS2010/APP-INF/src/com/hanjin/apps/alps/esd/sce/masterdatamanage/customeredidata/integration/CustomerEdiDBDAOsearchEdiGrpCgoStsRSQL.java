/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CustomerEdiDBDAOsearchEdiGrpCgoStsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.14
*@LastModifier : 
*@LastVersion : 1.0
* 2012.08.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerEdiDBDAOsearchEdiGrpCgoStsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * My Performance Report Edi Group code 별 EDI Standard Status Code 및 Customer Status Code 정보 조회
	  * </pre>
	  */
	public CustomerEdiDBDAOsearchEdiGrpCgoStsRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cs_grp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.integration").append("\n"); 
		query.append("FileName : CustomerEdiDBDAOsearchEdiGrpCgoStsRSQL").append("\n"); 
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
		query.append("#if(${mycust} != '')" ).append("\n"); 
		query.append("SELECT 1 AS S_USE_FLG" ).append("\n"); 
		query.append(", RPT_COL_SEQ S_RPT_COL_SEQ" ).append("\n"); 
		query.append(", RPT_COL_NM S_RPT_COL_NM" ).append("\n"); 
		query.append(", CRE_USR_ID S_CRE_USR_ID" ).append("\n"); 
		query.append(", EDI_GRP_CD S_EDI_GRP_CD" ).append("\n"); 
		query.append(", RPT_COL_DESC S_RPT_COL_DESC" ).append("\n"); 
		query.append(", EDI_STS_FLG S_EDI_STS_FLG" ).append("\n"); 
		query.append(", '' S_CUST_EDI_STS_CD" ).append("\n"); 
		query.append(", 0 S_HIDDEN_FLG" ).append("\n"); 
		query.append("FROM SCE_PERF_RPT_FOM P" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND P.EDI_STS_FLG = 'N'" ).append("\n"); 
		query.append("AND P.USE_FLG = 'Y'" ).append("\n"); 
		query.append("AND P.CRE_USR_ID = @[cre_usr_id]" ).append("\n"); 
		query.append("AND P.EDI_GRP_CD = @[cs_grp_id]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT DECODE(USE_FLG, 'Y',1,0) AS S_USE_FLG" ).append("\n"); 
		query.append(", RPT_COL_SEQ S_RPT_COL_SEQ" ).append("\n"); 
		query.append(", RPT_COL_NM S_RPT_COL_NM" ).append("\n"); 
		query.append(", @[cre_usr_id] S_CRE_USR_ID" ).append("\n"); 
		query.append(", @[cs_grp_id] S_EDI_GRP_CD" ).append("\n"); 
		query.append(", RPT_COL_DESC S_RPT_COL_DESC" ).append("\n"); 
		query.append(", EDI_STS_FLG S_EDI_STS_FLG" ).append("\n"); 
		query.append(", '' S_CUST_EDI_STS_CD" ).append("\n"); 
		query.append(", 1 S_HIDDEN_FLG" ).append("\n"); 
		query.append("FROM SCE_RPT_FOM_PRTP P" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND P.EDI_STS_FLG = 'N'" ).append("\n"); 
		query.append("#if(${bzc_col} != '')" ).append("\n"); 
		query.append("AND  P.RPT_COL_NM IN (" ).append("\n"); 
		query.append("#foreach($ele in ${bzc_col})" ).append("\n"); 
		query.append("#if($velocityCount == 1)'$ele' #else ,'$ele' #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")  -- bzc_col" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND USE_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT DECODE(USE_FLG, 'Y',1,0) AS S_USE_FLG" ).append("\n"); 
		query.append(", RPT_COL_SEQ S_RPT_COL_SEQ" ).append("\n"); 
		query.append(", RPT_COL_NM S_RPT_COL_NM" ).append("\n"); 
		query.append(", @[cre_usr_id] S_CRE_USR_ID" ).append("\n"); 
		query.append(", @[cs_grp_id] S_EDI_GRP_CD" ).append("\n"); 
		query.append(", RPT_COL_DESC S_RPT_COL_DESC" ).append("\n"); 
		query.append(", EDI_STS_FLG S_EDI_STS_FLG" ).append("\n"); 
		query.append(", E.CUST_EDI_STS_CD S_CUST_EDI_STS_CD" ).append("\n"); 
		query.append(", DECODE(E.CUST_EDI_STS_CD, NULL, 0, 1) S_HIDDEN_FLG" ).append("\n"); 
		query.append("FROM SCE_RPT_FOM_PRTP P, EDI_GRP_CGO E" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND P.EDI_STS_FLG = 'Y'" ).append("\n"); 
		query.append("AND E.EDI_SND_FLG = 'Y'" ).append("\n"); 
		query.append("AND E.EDI_GRP_CD = @[cs_grp_id]" ).append("\n"); 
		query.append("AND E.EDI_STND_STS_CD = RPT_COL_DESC" ).append("\n"); 
		query.append("#if(${edi_sts} !='')" ).append("\n"); 
		query.append("AND P.RPT_COL_DESC IN (" ).append("\n"); 
		query.append("#foreach($ele in ${edi_sts})" ).append("\n"); 
		query.append("#if($velocityCount == 1)'$ele' #else ,'$ele' #end" ).append("\n"); 
		query.append("#end  -- edi_sts" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY S_RPT_COL_SEQ" ).append("\n"); 

	}
}