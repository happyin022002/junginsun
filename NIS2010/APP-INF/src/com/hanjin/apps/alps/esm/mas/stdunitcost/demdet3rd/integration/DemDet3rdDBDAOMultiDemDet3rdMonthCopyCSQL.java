/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : DemDet3rdDBDAOMultiDemDet3rdMonthCopyCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.05.15
*@LastModifier : 
*@LastVersion : 1.0
* 2017.05.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.demdet3rd.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DemDet3rdDBDAOMultiDemDet3rdMonthCopyCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2017.05.15 송민석 ERP MAS의 Phase out에 따라 영향 받는 화면에 대한 수정 프로젝트 1차
	  * </pre>
	  */
	public DemDet3rdDBDAOMultiDemDet3rdMonthCopyCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_src_mon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_tar_mon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.demdet3rd.integration").append("\n"); 
		query.append("FileName : DemDet3rdDBDAOMultiDemDet3rdMonthCopyCSQL").append("\n"); 
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
		query.append("INSERT  INTO MAS_DMDT_N3RD_PTY (" ).append("\n"); 
		query.append("	COST_YRMON" ).append("\n"); 
		query.append("	, CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	, STND_COST_CD" ).append("\n"); 
		query.append("	, UC_AMT" ).append("\n"); 
		query.append("	, BKG_VOL_QTY" ).append("\n"); 
		query.append("	, TTL_DMDT_AMT" ).append("\n"); 
		query.append("	, COST_ASS_BSE_CD" ).append("\n"); 
		query.append("	, CRE_USR_ID" ).append("\n"); 
		query.append("	, CRE_DT" ).append("\n"); 
		query.append("	, UPD_USR_ID" ).append("\n"); 
		query.append("	, UPD_DT" ).append("\n"); 
		query.append("	, TRD_CD " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT @[f_tar_mon] as COST_YRMON" ).append("\n"); 
		query.append("	, CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	, STND_COST_CD" ).append("\n"); 
		query.append("	, UC_AMT" ).append("\n"); 
		query.append("	, BKG_VOL_QTY" ).append("\n"); 
		query.append("	, TTL_DMDT_AMT" ).append("\n"); 
		query.append("	, COST_ASS_BSE_CD" ).append("\n"); 
		query.append("        , @[user_id] CRE_USR_ID" ).append("\n"); 
		query.append("        , SYSDATE CRE_DT" ).append("\n"); 
		query.append("        , @[user_id] UPD_USR_ID" ).append("\n"); 
		query.append("        , SYSDATE UPD_DT" ).append("\n"); 
		query.append("	, TRD_CD " ).append("\n"); 
		query.append("  FROM MAS_DMDT_N3RD_PTY" ).append("\n"); 
		query.append(" WHERE COST_YRMON = @[f_src_mon]" ).append("\n"); 

	}
}