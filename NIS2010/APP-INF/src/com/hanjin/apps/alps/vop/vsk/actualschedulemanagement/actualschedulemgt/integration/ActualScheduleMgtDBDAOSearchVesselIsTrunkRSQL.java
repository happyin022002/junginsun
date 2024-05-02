/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ActualScheduleMgtDBDAOSearchVesselIsTrunkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.17
*@LastModifier : 
*@LastVersion : 1.0
* 2012.07.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ActualScheduleMgtDBDAOSearchVesselIsTrunkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vessel이 Trunk인지 조회한다.
	  * ---------------------------------------------------------------------------
	  * 2011.01.25 CHM-201007580-01 진마리아 신규 등록
	  * 2011.08.16 CHM-201112897-01 진마리아 Call Sign No., IMU No. 를 이용하여 Vessel Code를 찾도록 로직 변경
	  * </pre>
	  */
	public ActualScheduleMgtDBDAOSearchVesselIsTrunkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lloyd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_sgn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_vsl_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.integration").append("\n"); 
		query.append("FileName : ActualScheduleMgtDBDAOSearchVesselIsTrunkRSQL").append("\n"); 
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
		query.append("SELECT 		VSL_CD " ).append("\n"); 
		query.append("FROM 		MDM_VSL_CNTR" ).append("\n"); 
		query.append("WHERE 		1 = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${edi_vsl_nm} != '') " ).append("\n"); 
		query.append("AND 		VSL_CD 		= @[edi_vsl_nm]" ).append("\n"); 
		query.append("#elseif (${call_sgn_no} != '') " ).append("\n"); 
		query.append("AND 		VSL_CD 		IN (" ).append("\n"); 
		query.append("    						SELECT  VSL_CD" ).append("\n"); 
		query.append("    						FROM    MDM_VSL_CNTR" ).append("\n"); 
		query.append("    						WHERE 	CALL_SGN_NO = @[call_sgn_no]" ).append("\n"); 
		query.append("    						AND 	DELT_FLG 	= 'N'" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("#elseif (${lloyd_no} != '') " ).append("\n"); 
		query.append("AND 		VSL_CD 		IN (" ).append("\n"); 
		query.append("    						SELECT	VSL_CD" ).append("\n"); 
		query.append("    						FROM	MDM_VSL_CNTR" ).append("\n"); 
		query.append("    						WHERE   LLOYD_NO 	= @[lloyd_no]" ).append("\n"); 
		query.append("    						AND 	DELT_FLG 	= 'N'" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("AND 		VSL_CD 		= ''" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND 		FDR_DIV_CD 	= 'T'" ).append("\n"); 
		query.append("AND 		DELT_FLG 	= 'N'" ).append("\n"); 

	}
}