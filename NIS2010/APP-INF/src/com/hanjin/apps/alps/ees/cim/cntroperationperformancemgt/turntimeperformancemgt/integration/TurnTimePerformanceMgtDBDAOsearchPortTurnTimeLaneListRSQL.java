/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TurnTimePerformanceMgtDBDAOsearchPortTurnTimeLaneListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.19
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2010.01.19 박광석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Prak Kwang Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TurnTimePerformanceMgtDBDAOsearchPortTurnTimeLaneListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchPortTurnTimeLaneList
	  * </pre>
	  */
	public TurnTimePerformanceMgtDBDAOsearchPortTurnTimeLaneListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.integration").append("\n"); 
		query.append("FileName : TurnTimePerformanceMgtDBDAOsearchPortTurnTimeLaneListRSQL").append("\n"); 
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
		query.append("SELECT  DISTINCT B.SLAN_CD||'|'||A.RLANE_NM" ).append("\n"); 
		query.append("FROM	MDM_REV_LANE A,CIM_PORT_TURN_TM_SMRY B" ).append("\n"); 
		query.append("WHERE	SUBSTR(A.RLANE_CD,1,3)		= B.SLAN_CD " ).append("\n"); 
		query.append("#if (${period} == 'M')" ).append("\n"); 
		query.append("AND	TGT_MVMT_DT	BETWEEN    @[from]	AND @[to]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${period} == 'W')" ).append("\n"); 
		query.append("AND	TGT_YRWK	BETWEEN    @[from]	AND @[to]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND     VL_LOC_CD   =   @[pol]" ).append("\n"); 
		query.append("ORDER BY B.SLAN_CD||'|'||A.RLANE_NM" ).append("\n"); 

	}
}