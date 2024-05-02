/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : WorkOrderDetailDBDAOactualTimeVerificationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.04
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.workorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderDetailDBDAOactualTimeVerificationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * actualTimeVerification
	  * </pre>
	  */
	public WorkOrderDetailDBDAOactualTimeVerificationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_act_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.workorder.integration").append("\n"); 
		query.append("FileName : WorkOrderDetailDBDAOactualTimeVerificationRSQL").append("\n"); 
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
		query.append("SELECT COP_NO," ).append("\n"); 
		query.append("       COP_DTL_SEQ," ).append("\n"); 
		query.append("       CNTR_NO," ).append("\n"); 
		query.append("       ACT_CD," ).append("\n"); 
		query.append("       ACT_DT," ).append("\n"); 
		query.append("       PRE_ACT_CD," ).append("\n"); 
		query.append("       PRE_ACT_DT," ).append("\n"); 
		query.append("       TO_CHAR(PRE_ACT_DT, 'yyyy-MM-dd hh24:mi') AS PRE_ACT_DT_INFO," ).append("\n"); 
		query.append("       CASE" ).append("\n"); 
		query.append("          WHEN PRE_ACT_CD IS NULL" ).append("\n"); 
		query.append("          THEN" ).append("\n"); 
		query.append("             'N'" ).append("\n"); 
		query.append("          WHEN PRE_ACT_DT IS NULL" ).append("\n"); 
		query.append("          THEN" ).append("\n"); 
		query.append("             'N'" ).append("\n"); 
		query.append("          WHEN     (   PRE_ACT_CD = 'FITMDO'" ).append("\n"); 
		query.append("                    OR PRE_ACT_CD = 'FITRDO'" ).append("\n"); 
		query.append("                    OR PRE_ACT_CD = 'FITYDO')" ).append("\n"); 
		query.append("               AND PRE_ACT_DT <= TO_DATE (@[in_act_dt], 'yyyyMMddhh24mi')" ).append("\n"); 
		query.append("          THEN" ).append("\n"); 
		query.append("             'Y'" ).append("\n"); 
		query.append("          ELSE" ).append("\n"); 
		query.append("             'N'" ).append("\n"); 
		query.append("       END" ).append("\n"); 
		query.append("          AS RV" ).append("\n"); 
		query.append("  FROM (SELECT D.COP_NO," ).append("\n"); 
		query.append("               D.COP_DTL_SEQ," ).append("\n"); 
		query.append("               H.CNTR_NO," ).append("\n"); 
		query.append("               D.ACT_CD," ).append("\n"); 
		query.append("               D.ACT_DT," ).append("\n"); 
		query.append("               LAG (D.ACT_CD) OVER (ORDER BY D.COP_NO, D.COP_DTL_SEQ)" ).append("\n"); 
		query.append("                  AS PRE_ACT_CD," ).append("\n"); 
		query.append("               LAG (D.ACT_DT) OVER (ORDER BY D.COP_NO, D.COP_DTL_SEQ)" ).append("\n"); 
		query.append("                  AS PRE_ACT_DT" ).append("\n"); 
		query.append("          FROM SCE_COP_DTL D, SCE_COP_HDR H, MDM_ACTIVITY M" ).append("\n"); 
		query.append("         WHERE     1 = 1" ).append("\n"); 
		query.append("               AND D.ACT_CD = M.ACT_CD" ).append("\n"); 
		query.append("               AND D.COP_NO = H.COP_NO" ).append("\n"); 
		query.append("               AND H.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("               AND H.CNTR_NO = @[cntr_no])" ).append("\n"); 
		query.append(" WHERE 1 = 1 AND ACT_CD = 'FITZAD'" ).append("\n"); 

	}
}