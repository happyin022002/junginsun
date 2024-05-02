/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOGetCTMDamageFlgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOGetCTMDamageFlgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetCTMDamageFlg
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOGetCTMDamageFlgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("event_yard",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOGetCTMDamageFlgRSQL").append("\n"); 
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
		query.append("SELECT CNMV_ID_NO, CNTR_DMG_FLG" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#if (${event_yard} != '') " ).append("\n"); 
		query.append("AND ORG_YD_CD = @[event_yard]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND CNMV_YR||TO_CHAR(CNMV_SEQ,'0000')||CNMV_SPLIT_NO = (SELECT MAX(CNMV_YR||TO_CHAR(CNMV_SEQ,'0000')||CNMV_SPLIT_NO)" ).append("\n"); 
		query.append("        FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("        AND CNMV_EVNT_DT <= TO_DATE (@[evnt_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("        AND NVL(MVMT_CRE_TP_CD, 'Z') != 'C'" ).append("\n"); 
		query.append("        AND CNMV_YR = (SELECT MAX(CNMV_YR)" ).append("\n"); 
		query.append("            FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("            AND CNMV_EVNT_DT <= TO_DATE (@[evnt_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("            AND NVL(MVMT_CRE_TP_CD, 'Z') != 'C'))" ).append("\n"); 
		query.append("AND ROWNUM=1" ).append("\n"); 
		query.append("ORDER BY CNMV_YR, CNMV_SEQ, CNMV_SPLIT_NO" ).append("\n"); 

	}
}