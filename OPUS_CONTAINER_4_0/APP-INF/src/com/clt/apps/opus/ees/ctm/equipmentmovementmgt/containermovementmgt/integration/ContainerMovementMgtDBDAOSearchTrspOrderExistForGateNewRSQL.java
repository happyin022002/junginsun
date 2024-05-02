/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOSearchTrspOrderExistForGateNewRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.08
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2010.03.08 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOSearchTrspOrderExistForGateNewRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOSearchTrspOrderExistForGateNewRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_number",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("event_date",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("event_yard",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOSearchTrspOrderExistForGateNewRSQL").append("\n"); 
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
		query.append("SELECT 1" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("WHERE LOCL_CRE_DT BETWEEN TO_DATE (@[event_date], 'YYYY-MM-DD HH24:MI') - 20 AND TO_DATE (@[event_date], 'YYYY-MM-DD HH24:MI') + 7" ).append("\n"); 
		query.append("AND TRSP_SO_TP_CD = 'Y'" ).append("\n"); 
		query.append("AND TRSP_COST_DTL_MOD_CD = 'DR'" ).append("\n"); 
		query.append("AND FM_NOD_CD = @[event_yard]" ).append("\n"); 
		query.append("AND TRSP_BND_CD = 'I'" ).append("\n"); 
		query.append("AND BKG_NO = @[bkg_number]" ).append("\n"); 
		query.append("AND EQ_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}