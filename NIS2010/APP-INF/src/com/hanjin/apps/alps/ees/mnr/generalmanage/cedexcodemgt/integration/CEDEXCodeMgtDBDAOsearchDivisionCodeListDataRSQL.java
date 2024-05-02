/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CEDEXCodeMgtDBDAOsearchDivisionCodeListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.31
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.08.31 박명신
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Myoung Sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CEDEXCodeMgtDBDAOsearchDivisionCodeListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchDivisionCodeListData
	  * </pre>
	  */
	public CEDEXCodeMgtDBDAOsearchDivisionCodeListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_cost_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_eq_cmpo_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.integration").append("\n"); 
		query.append("FileName : CEDEXCodeMgtDBDAOsearchDivisionCodeListDataRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("A.EQ_CEDEX_RLT_TP_CD" ).append("\n"); 
		query.append(",A.FM_RLT_CD" ).append("\n"); 
		query.append(",A.TO_RLT_CD" ).append("\n"); 
		query.append(",A.COST_GRP_CD" ).append("\n"); 
		query.append(",A.MNR_RLT_CD_DESC" ).append("\n"); 
		query.append(",A.CRE_USR_ID" ).append("\n"); 
		query.append(",A.RPR_LBR_HRS" ).append("\n"); 
		query.append(",SUBSTR(A.FM_RLT_CD,0,LENGTH(A.FM_RLT_CD)-2) AS EQ_CMPO_CD" ).append("\n"); 
		query.append(",SUBSTR(A.FM_RLT_CD,LENGTH(A.FM_RLT_CD)-1,LENGTH(A.FM_RLT_CD)) AS EQ_RPR_CD" ).append("\n"); 
		query.append(",TO_CHAR(A.CRE_DT, 'yyyy-mm-dd') CRE_DT" ).append("\n"); 
		query.append(",A.UPD_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(A.UPD_DT, 'yyyy-mm-dd') UPD_DT" ).append("\n"); 
		query.append("FROM MNR_CD_RLT A" ).append("\n"); 
		query.append("WHERE A.EQ_CEDEX_RLT_TP_CD  = 'CTV'" ).append("\n"); 
		query.append("#if (${in_cost_grp_cd} != 'ALL')" ).append("\n"); 
		query.append("AND A.COST_GRP_CD = @[in_cost_grp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_eq_cmpo_cd} != '')" ).append("\n"); 
		query.append("AND A.FM_RLT_CD LIKE @[in_eq_cmpo_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}