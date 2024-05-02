/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TurnTimePerformanceMgtDBDAODAOsearchPortTurnTimeVVDListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.07
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2009.05.07 박광석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Prak Kwang Seok
 * @see DAO 참조
 * @since J2EE 1.4
 */

public class TurnTimePerformanceMgtDBDAODAOsearchPortTurnTimeVVDListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD 조회
	  * </pre>
	  */
	public TurnTimePerformanceMgtDBDAODAOsearchPortTurnTimeVVDListRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from",new String[]{arrTmp[0],arrTmp[1]});	

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("period",new String[]{arrTmp[0],arrTmp[1]});	

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});	

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});	
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
		query.append("SELECT  DISTINCT VSL_CD||SKD_VOY_NO||SKD_DIR_CD" ).append("\n"); 
		query.append("FROM	CIM_PORT_TURN_TM_SMRY" ).append("\n"); 
		query.append("#if (${period} == 'M')" ).append("\n"); 
		query.append("WHERE	TGT_MVMT_DT	BETWEEN    @[from]	AND @[to]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${period} == 'W')" ).append("\n"); 
		query.append("WHERE	TGT_YRWK	BETWEEN    @[from]	AND @[to]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND     VL_LOC_CD   =   @[pol]" ).append("\n"); 
		query.append("#if (${lane} != '') " ).append("\n");
		query.append("AND     SLAN_CD     =   @[lane] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.integration ").append("\n"); 
		query.append("FileName : TurnTimePerformanceMgtDBDAODAOsearchPortTurnTimeVVDListRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}