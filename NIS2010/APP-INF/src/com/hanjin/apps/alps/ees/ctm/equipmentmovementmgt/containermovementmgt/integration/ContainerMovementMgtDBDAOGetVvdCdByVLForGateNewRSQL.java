/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOGetVvdCdByVLForGateNewRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.04
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2010.02.04 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOGetVvdCdByVLForGateNewRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOGetVvdCdByVLForGateNewRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("event_yard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOGetVvdCdByVLForGateNewRSQL").append("\n"); 
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
		query.append("/* Use Event Location instead of POL/POD, wheh Searching VVD in Vessel Port Schedule. - 2009.09.29 */" ).append("\n"); 
		query.append("/* VL시에는 Turing Indicator가 Y or N 이면 그대로 사용하고, 이외의 경우는 Turning Voyage, Turning Direction을 사용. - 2009.11.02 */" ).append("\n"); 
		query.append("SELECT S.VSL_CD," ).append("\n"); 
		query.append("S.SKD_VOY_NO," ).append("\n"); 
		query.append("S.SKD_DIR_CD" ).append("\n"); 
		query.append("FROM (SELECT ROUND (ABS (VPS1.VPS_ETD_DT - TO_DATE (SUBSTR (@[event_date], 1, 8), 'YYYYMMDD')), 5) DIF,    /* 2008.12.04 */" ).append("\n"); 
		query.append("SKD.VSL_CD," ).append("\n"); 
		query.append("SKD.SKD_VOY_NO," ).append("\n"); 
		query.append("SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD VPS1," ).append("\n"); 
		query.append("VSK_VSL_SKD		SKD" ).append("\n"); 
		query.append("WHERE VPS1.VPS_ETD_DT BETWEEN TO_DATE (SUBSTR (@[event_date], 1, 8), 'YYYYMMDD') - 7 AND TO_DATE (SUBSTR (@[event_date], 1, 8), 'YYYYMMDD') + 7 + .99999" ).append("\n"); 
		query.append("AND VPS1.VPS_PORT_CD = SUBSTR (@[event_yard], 1, 5)" ).append("\n"); 
		query.append("AND NVL (VPS1.SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("AND SKD.VSL_CD LIKE @[vsl_cd]||'%'" ).append("\n"); 
		query.append("AND SKD.SKD_STS_CD = 'ACT'" ).append("\n"); 
		query.append("AND SKD.VSL_CD = VPS1.VSL_CD" ).append("\n"); 
		query.append("AND SKD.SKD_VOY_NO = DECODE( NVL (VPS1.TURN_PORT_IND_CD, 'N'), 'N', VPS1.SKD_VOY_NO, 'Y', VPS1.SKD_VOY_NO, VPS1.TURN_SKD_VOY_NO)" ).append("\n"); 
		query.append("AND SKD.SKD_DIR_CD = DECODE( NVL (VPS1.TURN_PORT_IND_CD, 'N'), 'N', VPS1.SKD_DIR_CD, 'Y', VPS1.SKD_DIR_CD, VPS1.TURN_SKD_DIR_CD)" ).append("\n"); 
		query.append("ORDER BY DIF ASC" ).append("\n"); 
		query.append(") S" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 

	}
}