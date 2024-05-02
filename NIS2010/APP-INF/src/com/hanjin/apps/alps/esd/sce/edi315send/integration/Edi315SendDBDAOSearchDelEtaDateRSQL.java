/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : Edi315SendDBDAOSearchDelEtaDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.22
*@LastModifier : 
*@LastVersion : 1.0
* 2013.02.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOSearchDelEtaDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRAMS MODE에 따른 DEL ETA를 구한다.
	  * </pre>
	  */
	public Edi315SendDBDAOSearchDelEtaDateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOSearchDelEtaDateRSQL").append("\n"); 
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
		query.append("SELECT 	TO_CHAR(ESTM_DT,'YYYYMMDDHH24MI') DEL_ETA," ).append("\n"); 
		query.append("TO_CHAR(ESTM_GDT,'YYYYMMDDHH24MI') DEL_ETA_GMT," ).append("\n"); 
		query.append("TO_CHAR(ACT_DT,'YYYYMMDDHH24MI') DEL_ATA," ).append("\n"); 
		query.append("DECODE(NOD_CD, NULL, '', DECODE(ACT_DT, NULL, '', TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR(NOD_CD,0,5), ACT_DT, 'GMT'), 'YYYYMMDDHH24MI'))) DEL_ATA_GMT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT  CASE WHEN SUBSTR(A.COP_RAIL_CHK_CD ,2,1) = 'I' THEN" ).append("\n"); 
		query.append("CASE WHEN B.ACT_CD = 'FIRRUD' THEN '1'" ).append("\n"); 
		query.append("WHEN B.ACT_CD = 'FITZAD' THEN '2' END" ).append("\n"); 
		query.append("ELSE CASE WHEN B.ACT_CD = 'FIWMUD' THEN '3'" ).append("\n"); 
		query.append("WHEN B.ACT_CD = 'FITZAD' THEN '4'  END" ).append("\n"); 
		query.append("END CHK, ESTM_DT, ESTM_GDT, ACT_DT, NOD_CD" ).append("\n"); 
		query.append("FROM SCE_COP_HDR A, SCE_COP_DTL B" ).append("\n"); 
		query.append("WHERE A.COP_NO = B.COP_NO" ).append("\n"); 
		query.append("AND A.DEL_NOD_CD = B.NOD_CD" ).append("\n"); 
		query.append("AND A.COP_NO = @[e_cop_no]) A" ).append("\n"); 
		query.append("WHERE CHK IS NOT NULL" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}