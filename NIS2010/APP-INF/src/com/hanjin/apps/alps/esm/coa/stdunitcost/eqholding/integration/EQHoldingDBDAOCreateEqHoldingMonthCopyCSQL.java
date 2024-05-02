/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EQHoldingDBDAOCreateEqHoldingMonthCopyCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.02
*@LastModifier : 
*@LastVersion : 1.0
* 2012.08.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.eqholding.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQHoldingDBDAOCreateEqHoldingMonthCopyCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.08.02 이석준[CHM-201219334-01] EQ Holding Cost 화면 Month Copy 기능 추가
	  * </pre>
	  */
	public EQHoldingDBDAOCreateEqHoldingMonthCopyCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_tar_mon",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.stdunitcost.eqholding.integration").append("\n"); 
		query.append("FileName : EQHoldingDBDAOCreateEqHoldingMonthCopyCSQL").append("\n"); 
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
		query.append("INSERT INTO COA_HLD_COST" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("COST_YRMON," ).append("\n"); 
		query.append("CNTR_CHSS_DIV_CD," ).append("\n"); 
		query.append("EQ_TPSZ_CD," ).append("\n"); 
		query.append("STND_COST_CD," ).append("\n"); 
		query.append("CHSS_HLD_UC_AMT," ).append("\n"); 
		query.append("TTL_HLD_AMT," ).append("\n"); 
		query.append("EQ_BX_KNT," ).append("\n"); 
		query.append("EQ_HLD_DYS," ).append("\n"); 
		query.append("CHSS_USA_QTY," ).append("\n"); 
		query.append("COST_ASS_BSE_CD," ).append("\n"); 
		query.append("DELT_FLG," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[f_tar_mon] AS COST_YRMON," ).append("\n"); 
		query.append("CNTR_CHSS_DIV_CD," ).append("\n"); 
		query.append("EQ_TPSZ_CD," ).append("\n"); 
		query.append("STND_COST_CD," ).append("\n"); 
		query.append("CHSS_HLD_UC_AMT," ).append("\n"); 
		query.append("TTL_HLD_AMT," ).append("\n"); 
		query.append("EQ_BX_KNT," ).append("\n"); 
		query.append("EQ_HLD_DYS," ).append("\n"); 
		query.append("CHSS_USA_QTY," ).append("\n"); 
		query.append("COST_ASS_BSE_CD," ).append("\n"); 
		query.append("DELT_FLG," ).append("\n"); 
		query.append("@[user_id] AS CRE_USR_ID," ).append("\n"); 
		query.append("SYSDATE AS CRE_DT," ).append("\n"); 
		query.append("@[user_id] AS UPD_USR_ID," ).append("\n"); 
		query.append("SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("FROM COA_HLD_COST" ).append("\n"); 
		query.append("WHERE COST_YRMON     = @[f_src_mon]" ).append("\n"); 

	}
}