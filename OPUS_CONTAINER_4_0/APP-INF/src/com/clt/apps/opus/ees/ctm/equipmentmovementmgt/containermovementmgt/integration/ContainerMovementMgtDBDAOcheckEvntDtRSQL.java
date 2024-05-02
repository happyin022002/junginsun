/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOcheckEvntDtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.26
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2014.11.26 김성욱
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

public class ContainerMovementMgtDBDAOcheckEvntDtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * container의 evnt_dt가 변경되었는지 체크한다.
	  * 2013.04.17 [CHM-201324017-01] Event Date외 Movement Status, Yard Code도 변경시에는 I/F하도록 수정
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOcheckEvntDtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_id_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cnmv_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOcheckEvntDtRSQL").append("\n"); 
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
		query.append("SELECT NVL(MAX('T'),'F') AS EVNT_DT_FLG" ).append("\n"); 
		query.append("  FROM CTM_MOVEMENT" ).append("\n"); 
		query.append(" WHERE CNTR_NO    = @[cntr_no]" ).append("\n"); 
		query.append("   AND CNMV_YR    = @[cnmv_yr]" ).append("\n"); 
		query.append("   AND CNMV_ID_NO = @[cnmv_id_no]" ).append("\n"); 
		query.append("   AND TO_CHAR (CNMV_EVNT_DT, 'YYYY-MM-DD HH24:MI') = TO_CHAR(TO_DATE (@[cnmv_evnt_dt], 'YYYYMMDDHH24MISS'), 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("#if (${mvmt_sts_cd} != '')" ).append("\n"); 
		query.append("   AND MVMT_STS_CD = @[mvmt_sts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${org_yd_cd} != '')" ).append("\n"); 
		query.append("   AND ORG_YD_CD   = @[org_yd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("	AND CRNT_VSL_CD		= SUBSTR(@[vvd_cd], 0,4)" ).append("\n"); 
		query.append("	AND CRNT_SKD_VOY_NO	= SUBSTR(@[vvd_cd], 5,4)" ).append("\n"); 
		query.append("	AND CRNT_SKD_DIR_CD = SUBSTR(@[vvd_cd], 9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}