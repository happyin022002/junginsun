/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MonthlyQuotaCreationDBDAOupdateOfcVerifyUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.08
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaCreationDBDAOupdateOfcVerifyUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 버전의 Office를 수정한다.
	  * </pre>
	  */
	public MonthlyQuotaCreationDBDAOupdateOfcVerifyUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chng_ctrt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mqta_mdl_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chng_sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaCreationDBDAOupdateOfcVerifyUSQL").append("\n"); 
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
		query.append("UPDATE SAQ_MON_FCAST_TRNS " ).append("\n"); 
		query.append("       SET UPD_USR_ID = @[user_id]" ).append("\n"); 
		query.append("     , UPD_DT = SYSDATE " ).append("\n"); 
		query.append("     #if(${chng_ctrt_ofc_cd} != '') " ).append("\n"); 
		query.append("     , CTRT_OFC_CD = (SELECT N4TH_PRNT_OFC_CD" ).append("\n"); 
		query.append("                		FROM SAQ_ORGANIZATION_V " ).append("\n"); 
		query.append("               		   WHERE OFC_CD = @[chng_ctrt_ofc_cd]" ).append("\n"); 
		query.append("              		  )" ).append("\n"); 
		query.append("     , CTRT_RHQ_CD = (SELECT N2ND_PRNT_OFC_CD " ).append("\n"); 
		query.append("                		FROM SAQ_ORGANIZATION_V " ).append("\n"); 
		query.append("               		   WHERE OFC_CD = @[chng_ctrt_ofc_cd]" ).append("\n"); 
		query.append("              		  ) " ).append("\n"); 
		query.append("     , CTRT_AQ_CD = (SELECT N3RD_PRNT_OFC_CD " ).append("\n"); 
		query.append("                		FROM SAQ_ORGANIZATION_V " ).append("\n"); 
		query.append("               		   WHERE OFC_CD = @[chng_ctrt_ofc_cd]" ).append("\n"); 
		query.append("              		 ) " ).append("\n"); 
		query.append("     , CTRT_RGN_OFC_CD = (SELECT N4TH_PRNT_OFC_CD" ).append("\n"); 
		query.append("                		    FROM SAQ_ORGANIZATION_V " ).append("\n"); 
		query.append("               		       WHERE OFC_CD = @[chng_ctrt_ofc_cd]" ).append("\n"); 
		query.append("              		      )  " ).append("\n"); 
		query.append("     #end " ).append("\n"); 
		query.append("     #if(${chng_sls_ofc_cd} != '') " ).append("\n"); 
		query.append("     , SLS_OFC_CD = (SELECT N4TH_PRNT_OFC_CD" ).append("\n"); 
		query.append("                	   FROM SAQ_ORGANIZATION_V " ).append("\n"); 
		query.append("               		  WHERE OFC_CD = @[chng_sls_ofc_cd]" ).append("\n"); 
		query.append("              		 )" ).append("\n"); 
		query.append("     , SLS_RHQ_CD = (SELECT N2ND_PRNT_OFC_CD " ).append("\n"); 
		query.append("                       FROM SAQ_ORGANIZATION_V " ).append("\n"); 
		query.append("                      WHERE OFC_CD = @[chng_sls_ofc_cd] " ).append("\n"); 
		query.append("                     ) " ).append("\n"); 
		query.append("     , SLS_AQ_CD = (SELECT N3RD_PRNT_OFC_CD " ).append("\n"); 
		query.append("                	  FROM SAQ_ORGANIZATION_V " ).append("\n"); 
		query.append("               		 WHERE OFC_CD = @[chng_sls_ofc_cd]" ).append("\n"); 
		query.append("              		) " ).append("\n"); 
		query.append("     , SLS_RGN_OFC_CD = (SELECT N4TH_PRNT_OFC_CD" ).append("\n"); 
		query.append("                		   FROM SAQ_ORGANIZATION_V " ).append("\n"); 
		query.append("               		      WHERE OFC_CD = @[chng_sls_ofc_cd]" ).append("\n"); 
		query.append("              		     )" ).append("\n"); 
		query.append("     #end  " ).append("\n"); 
		query.append(" WHERE 1=1 " ).append("\n"); 
		query.append("       AND MQTA_MDL_VER_NO = @[mqta_mdl_ver_no] " ).append("\n"); 
		query.append("       AND (FCAST_TRNS_STS_CD = '0' OR FCAST_TRNS_STS_CD IS NULL)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   #if(${ctrt_ofc_cd} == '')" ).append("\n"); 
		query.append("       AND CTRT_OFC_CD IS NULL " ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if(${ctrt_ofc_cd} != '')" ).append("\n"); 
		query.append("       AND CTRT_OFC_CD = @[ctrt_ofc_cd] " ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   	   #if(${sls_ofc_cd} == '')" ).append("\n"); 
		query.append("       AND SLS_OFC_CD IS NULL" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if(${sls_ofc_cd} != '')" ).append("\n"); 
		query.append("       AND SLS_OFC_CD = @[sls_ofc_cd] " ).append("\n"); 
		query.append("       #end" ).append("\n"); 

	}
}