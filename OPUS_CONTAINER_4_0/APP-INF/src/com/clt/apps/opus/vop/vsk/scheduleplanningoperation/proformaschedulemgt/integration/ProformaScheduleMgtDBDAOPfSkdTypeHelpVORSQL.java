/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ProformaScheduleMgtDBDAOPfSkdTypeHelpVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.20
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2010.05.20 유혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author RYU HYUK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProformaScheduleMgtDBDAOPfSkdTypeHelpVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * P/F SKD Type Help (Pop-Up) Select Query
	  * </pre>
	  */
	public ProformaScheduleMgtDBDAOPfSkdTypeHelpVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration").append("\n"); 
		query.append("FileName : ProformaScheduleMgtDBDAOPfSkdTypeHelpVORSQL").append("\n"); 
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
		query.append("SELECT  T1.VSL_SLAN_CD" ).append("\n"); 
		query.append("        , T1.PF_SVC_TP_CD" ).append("\n"); 
		query.append("        , T2.VSL_SLAN_NM" ).append("\n"); 
		query.append("        , DECODE(N1ST_VSL_CLSS_CD, NULL, NULL,         N1ST_VSL_CLSS_CD || ' x ' || N1ST_VSL_CLSS_KNT) ||" ).append("\n"); 
		query.append("          DECODE(N2ND_VSL_CLSS_CD, NULL, NULL, ', ' || N2ND_VSL_CLSS_CD || ' x ' || N2ND_VSL_CLSS_KNT) ||" ).append("\n"); 
		query.append("          DECODE(N3RD_VSL_CLSS_CD, NULL, NULL, ', ' || N3RD_VSL_CLSS_CD || ' x ' || N3RD_VSL_CLSS_KNT) AS VSL_CLASS" ).append("\n"); 
		query.append("        , SLAN_STND_FLG" ).append("\n"); 
		query.append("        , VSL_SVC_TP_CD" ).append("\n"); 
		query.append("        , TO_CHAR(T1.CRE_DT, 'YYYYMMDDHH24MI') AS CRE_DT" ).append("\n"); 
		query.append("FROM    VSK_PF_SKD T1, MDM_VSL_SVC_LANE T2" ).append("\n"); 
		query.append("WHERE   T1.VSL_SLAN_CD    = T2.VSL_SLAN_CD" ).append("\n"); 
		query.append("#if (${vsl_slan_cd} != '') " ).append("\n"); 
		query.append("AND    T1.VSL_SLAN_CD LIKE UPPER(@[vsl_slan_cd]) ||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    T2.VSL_TP_CD = 'C' /*컨테이너선*/" ).append("\n"); 
		query.append("ORDER BY T1.VSL_SLAN_CD, T1.CRE_DT DESC" ).append("\n"); 

	}
}