/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOGetVvdCdForGateNewRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.13
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2015.01.13 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOGetVvdCdForGateNewRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOGetVvdCdForGateNewRSQL(){
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
		params.put("event_yard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gate_io_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOGetVvdCdForGateNewRSQL").append("\n"); 
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
		query.append("SELECT NVL (VSL_CD, 'X') AS VSL_CD," ).append("\n"); 
		query.append("       NVL (SKD_VOY_NO, 'X') AS SKD_VOY_NO," ).append("\n"); 
		query.append("       NVL (SKD_DIR_CD, 'X') AS SKD_DIR_CD" ).append("\n"); 
		query.append("  FROM BKG_VVD" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_number]" ).append("\n"); 
		query.append("   AND DECODE (@[gate_io_cd], 'AE', POL_CD, POD_CD) = SUBSTR (@[event_yard], 1, 5)" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT NVL (VSL_CD, 'X') AS VSL_CD," ).append("\n"); 
		query.append("       NVL (SKD_VOY_NO, 'X') AS SKD_VOY_NO," ).append("\n"); 
		query.append("       NVL (SKD_DIR_CD, 'X') AS SKD_DIR_CD" ).append("\n"); 
		query.append("  FROM CTM_BKG_VVD" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_number]" ).append("\n"); 
		query.append("   AND DECODE (@[gate_io_cd], 'AE', POL_CD, POD_CD) = SUBSTR (@[event_yard], 1, 5)" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}