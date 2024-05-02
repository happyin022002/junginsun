/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ExternalFinderDBDAOSearchContractNoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.06
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExternalFinderDBDAOSearchContractNoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ExternalFinderDBDAOSearchContractNoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.integration").append("\n"); 
		query.append("FileName : ExternalFinderDBDAOSearchContractNoVORSQL").append("\n"); 
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
		query.append("SELECT AA.VSL_CD" ).append("\n"); 
		query.append("     , AA.FLET_CTRT_NO" ).append("\n"); 
		query.append("     , AA.VSL_ENG_NM" ).append("\n"); 
		query.append("     , AA.FLET_CTRT_TP_CD" ).append("\n"); 
		query.append("  FROM (SELECT A.VSL_CD" ).append("\n"); 
		query.append("             , A.FLET_CTRT_NO" ).append("\n"); 
		query.append("             , A.VSL_ENG_NM" ).append("\n"); 
		query.append("             , A.FLET_CTRT_TP_CD" ).append("\n"); 
		query.append("             , A.CRE_DT" ).append("\n"); 
		query.append("          FROM (SELECT MVC.VSL_CD" ).append("\n"); 
		query.append("                     , FC.FLET_CTRT_NO" ).append("\n"); 
		query.append("                     , MVC.VSL_ENG_NM" ).append("\n"); 
		query.append("                     , FC.FLET_CTRT_TP_CD" ).append("\n"); 
		query.append("                     , FC.CRE_DT" ).append("\n"); 
		query.append("                  FROM FMS_CONTRACT FC" ).append("\n"); 
		query.append("                     , MDM_VSL_CNTR MVC" ).append("\n"); 
		query.append("                 WHERE FC.VSL_CD = MVC.VSL_CD" ).append("\n"); 
		query.append("                #if(${type_flag} != '') " ).append("\n"); 
		query.append("                   AND FC.FLET_CTRT_TP_CD IN (" ).append("\n"); 
		query.append("                       #foreach($TYPE_FLAG IN ${list_type_flag})" ).append("\n"); 
		query.append("                            #if($list_type_flag.hasNext()) '$TYPE_FLAG', #else '$TYPE_FLAG' #end" ).append("\n"); 
		query.append("                       #end" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                   AND FC.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                   AND (FC.DELT_FLG = 'N' OR FC.DELT_FLG IS NULL)" ).append("\n"); 
		query.append("                   AND MVC.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                #if(${ctrt_flag} != 'Y')" ).append("\n"); 
		query.append("                   AND FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                 ORDER BY FC.CRE_DT DESC " ).append("\n"); 
		query.append("                 ) A" ).append("\n"); 
		query.append("         ORDER BY " ).append("\n"); 
		query.append("				 #if(${order_priority} == 'TO')" ).append("\n"); 
		query.append("                    A.FLET_CTRT_TP_CD DESC " ).append("\n"); 
		query.append("                 #else" ).append("\n"); 
		query.append("                    A.FLET_CTRT_TP_CD ASC " ).append("\n"); 
		query.append("				 #end" ).append("\n"); 
		query.append("                 ,A.CRE_DT DESC" ).append("\n"); 
		query.append("       ) AA" ).append("\n"); 
		query.append(" WHERE ROWNUM = 1" ).append("\n"); 

	}
}