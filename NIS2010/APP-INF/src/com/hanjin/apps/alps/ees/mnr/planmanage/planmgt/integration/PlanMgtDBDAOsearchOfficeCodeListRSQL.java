/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PlanMgtDBDAOsearchOfficeCodeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.02
*@LastModifier : 권영법
*@LastVersion : 1.0
* 2010.02.02 권영법
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YoungBuebKwon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PlanMgtDBDAOsearchOfficeCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public PlanMgtDBDAOsearchOfficeCodeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.integration").append("\n"); 
		query.append("FileName : PlanMgtDBDAOsearchOfficeCodeListRSQL").append("\n"); 
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
		query.append("#if (${ofc_cd} == 'NOTHQ')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT a.OFC_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION a" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND a.OFC_CD IN (" ).append("\n"); 
		query.append("SELECT a.OFC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT m.OFC_CD from  MDM_ORGANIZATION m" ).append("\n"); 
		query.append("WHERE m.OFC_CD <> m.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append(") )" ).append("\n"); 
		query.append("AND a.DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY a.OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${ofclevelcd} == 'RHQ')" ).append("\n"); 
		query.append("SELECT  B.OFC_CD, B.OFC_ENG_NM" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("select distinct m.ar_hd_qtr_ofc_cd HQ_OFC" ).append("\n"); 
		query.append("from mdm_organization m" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${boolhoofc} == 'true')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT mnr_cd_id HQ_OFC" ).append("\n"); 
		query.append("FROM mnr_gen_cd" ).append("\n"); 
		query.append("WHERE prnt_cd_id = 'HOOFC'" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") a , mdm_organization B" ).append("\n"); 
		query.append("WHERE B.ofc_cd  = HQ_OFC" ).append("\n"); 
		query.append("AND   B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY B.OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT  a.OFC_CD, a.OFC_ENG_NM , a.LOC_CD" ).append("\n"); 
		query.append("FROM  MDM_ORGANIZATION  a" ).append("\n"); 
		query.append("WHERE a.ar_hd_qtr_ofc_cd LIKE '%'|| nvl(@[ofc_cd],'') ||'%'" ).append("\n"); 
		query.append("AND a.DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY a.OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}