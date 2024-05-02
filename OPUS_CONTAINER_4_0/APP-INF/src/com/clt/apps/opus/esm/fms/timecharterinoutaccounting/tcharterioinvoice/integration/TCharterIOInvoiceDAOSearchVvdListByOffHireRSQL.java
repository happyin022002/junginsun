/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TCharterIOInvoiceDAOSearchVvdListByOffHireRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.24
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOInvoiceDAOSearchVvdListByOffHireRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOInvoiceDAOSearchVvdListByOffHireRSQL
	  * </pre>
	  */
	public TCharterIOInvoiceDAOSearchVvdListByOffHireRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDAOSearchVvdListByOffHireRSQL").append("\n"); 
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
		query.append("SELECT VVD" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("		SELECT VVD," ).append("\n"); 
		query.append("			   VST_DT," ).append("\n"); 
		query.append("			   VED_DT" ).append("\n"); 
		query.append("		  FROM (" ).append("\n"); 
		query.append("				SELECT    FV.VSL_CD " ).append("\n"); 
		query.append("					   || FV.SKD_VOY_NO " ).append("\n"); 
		query.append("					   || FV.SKD_DIR_CD " ).append("\n"); 
		query.append("					   || FV.REV_DIR_CD VVD," ).append("\n"); 
		query.append("					   FV.VST_DT," ).append("\n"); 
		query.append("					   FV.VED_DT" ).append("\n"); 
		query.append("				  FROM FMS_CONTRACT FC, FMS_VVD FV" ).append("\n"); 
		query.append("				 WHERE FC.FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("				   AND FC.VSL_CD = FV.VSL_CD" ).append("\n"); 
		query.append("				   AND FV.VST_DT >= (SELECT MIN(VST_DT) " ).append("\n"); 
		query.append("									   FROM FMS_VVD" ).append("\n"); 
		query.append("									  WHERE VSL_CD = @[vsl_cd])" ).append("\n"); 
		query.append("				   AND FV.VED_DT <= (SELECT MAX(VED_DT) " ).append("\n"); 
		query.append("									   FROM FMS_VVD" ).append("\n"); 
		query.append("									  WHERE VSL_CD = @[vsl_cd])" ).append("\n"); 
		query.append("			   ) WHERE (   REPLACE(@[eff_dt],'-','') BETWEEN VST_DT AND VED_DT" ).append("\n"); 
		query.append("					    OR REPLACE(@[exp_dt],'-','') BETWEEN VST_DT AND VED_DT" ).append("\n"); 
		query.append("					   )" ).append("\n"); 
		query.append("	   ) ORDER BY VED_DT DESC" ).append("\n"); 

	}
}