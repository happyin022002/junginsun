/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOInvoiceDAOSearchVvdListByCharterRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.09.25 정윤태
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JUNGYOONTAE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOInvoiceDAOSearchVvdListByCharterRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOInvoiceDAOSearchVvdListByCharterRSQL
	  * </pre>
	  */
	public TCharterIOInvoiceDAOSearchVvdListByCharterRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDAOSearchVvdListByCharterRSQL").append("\n"); 
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
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT VVD, VED_DT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT FV.VSL_CD || FV.SKD_VOY_NO || FV.SKD_DIR_CD || FV.REV_DIR_CD VVD," ).append("\n"); 
		query.append("FV.VED_DT" ).append("\n"); 
		query.append("FROM FMS_CONTRACT FC, FMS_VVD FV" ).append("\n"); 
		query.append("WHERE FC.FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("AND FC.VSL_CD = FV.VSL_CD" ).append("\n"); 
		query.append("AND @[rev_yrmon] BETWEEN FV.VST_DT AND FV.VED_DT" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT FV.VSL_CD || FV.SKD_VOY_NO || FV.SKD_DIR_CD || FV.REV_DIR_CD VVD," ).append("\n"); 
		query.append("FV.VED_DT" ).append("\n"); 
		query.append("FROM FMS_ID_VSL FI, FMS_VVD FV" ).append("\n"); 
		query.append("WHERE FI.FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("AND FI.USE_FLG = 'Y'" ).append("\n"); 
		query.append("AND FI.VSL_CD = FV.VSL_CD || '1234'" ).append("\n"); 
		query.append("AND @[rev_yrmon] BETWEEN FV.VST_DT AND FV.VED_DT" ).append("\n"); 
		query.append(") ORDER BY VED_DT DESC" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}