/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PortTimePerformanceMgtDBDAOSearchPortDoubleCallRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.03
*@LastModifier : 
*@LastVersion : 1.0
* 2012.05.03 
* 1.0 Creation
* 2012.05.03 조경완 [CHM-201217535] [TOR] Port Time Activity Creation에 Double Call추가 외1건  - D/Call 을 포함한  Combo Value를 가져옴
=========================================================*/
package com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTimePerformanceMgtDBDAOSearchPortDoubleCallRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD의 Port를 Double Call Value 를 포함하여 조회합니다. 
	  * 
	  * 2012.05.03 조경완
	  * </pre>
	  */
	public PortTimePerformanceMgtDBDAOSearchPortDoubleCallRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.integration").append("\n"); 
		query.append("FileName : PortTimePerformanceMgtDBDAOSearchPortDoubleCallRSQL").append("\n"); 
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
		query.append("SELECT  VPS_PORT_CD AS VAL," ).append("\n"); 
		query.append("VPS_PORT_CD || '|' ||" ).append("\n"); 
		query.append("( SELECT  LOC_NM" ).append("\n"); 
		query.append("FROM    MDM_LOCATION" ).append("\n"); 
		query.append("WHERE   LOC_CD       =   A.VPS_PORT_CD ) AS NAME" ).append("\n"); 
		query.append(",A.CLPT_IND_SEQ CALL_IND" ).append("\n"); 
		query.append(",VPS_PORT_CD || ' (' || CLPT_IND_SEQ || ')' AS VPORT" ).append("\n"); 
		query.append("FROM    VSK_VSL_PORT_SKD    A" ).append("\n"); 
		query.append("WHERE  VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("AND    SKD_VOY_NO = @[voy_no]" ).append("\n"); 
		query.append("AND    SKD_DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("AND    TURN_PORT_IND_CD NOT IN ('D','V')" ).append("\n"); 
		query.append("AND    DECODE(TURN_PORT_IND_CD, 'F', DECODE(TURN_SKD_VOY_NO, 'N', 'N', 'F'), 'N') <> 'F'" ).append("\n"); 
		query.append("AND	   'S' != NVL(SKD_CNG_STS_CD, ' ')" ).append("\n"); 
		query.append("ORDER BY  CLPT_SEQ" ).append("\n"); 

	}
}