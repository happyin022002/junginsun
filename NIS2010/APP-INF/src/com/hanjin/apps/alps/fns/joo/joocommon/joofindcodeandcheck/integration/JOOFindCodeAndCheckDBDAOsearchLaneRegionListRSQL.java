/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : JOOFindCodeAndCheckDBDAOsearchLaneRegionListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.25
*@LastModifier : 
*@LastVersion : 1.0
* 2012.07.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JOOFindCodeAndCheckDBDAOsearchLaneRegionListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD code를 파라미터로 입력하여 Lane과 Region를 조회한다.
	  * </pre>
	  */
	public JOOFindCodeAndCheckDBDAOsearchLaneRegionListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.integration").append("\n"); 
		query.append("FileName : JOOFindCodeAndCheckDBDAOsearchLaneRegionListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("CASE WHEN SC.CONTI_CD = 'A' AND CC.CNT_CD    = 'AU' THEN 'T'" ).append("\n"); 
		query.append("WHEN SC.CONTI_CD = 'A' AND SC.SCONTI_CD = 'AM' THEN 'D'" ).append("\n"); 
		query.append("WHEN SC.CONTI_CD = 'A'                         THEN 'A'" ).append("\n"); 
		query.append("WHEN SC.CONTI_CD = 'M' AND SC.SCONTI_CD = 'MS' THEN 'S'" ).append("\n"); 
		query.append("WHEN SC.CONTI_CD = 'M'                         THEN 'M'" ).append("\n"); 
		query.append("WHEN SC.CONTI_CD = 'E'                         THEN 'E'" ).append("\n"); 
		query.append("WHEN SC.CONTI_CD = 'F'                         THEN 'F'" ).append("\n"); 
		query.append("ELSE 'O'" ).append("\n"); 
		query.append("END  AS code" ).append("\n"); 
		query.append(",   MR.RLANE_CD  as name" ).append("\n"); 
		query.append("FROM  VSK_VSL_PORT_SKD           PS" ).append("\n"); 
		query.append(",   MDM_COUNTRY                CC" ).append("\n"); 
		query.append(",   MDM_SUBCONTINENT           SC" ).append("\n"); 
		query.append(",   MDM_REV_LANE               MR" ).append("\n"); 
		query.append("WHERE       1 = 1" ).append("\n"); 
		query.append("AND         SUBSTR(PS.VPS_PORT_CD,1,2) = CC.CNT_CD" ).append("\n"); 
		query.append("AND         CC.SCONTI_CD           = SC.SCONTI_CD" ).append("\n"); 
		query.append("AND      PS.VSL_CD     = SUBSTR(@[code], 1,4)" ).append("\n"); 
		query.append("AND      PS.SKD_VOY_NO = SUBSTR(@[code], 5,4)" ).append("\n"); 
		query.append("AND      PS.SKD_DIR_CD = SUBSTR(@[code], 9,1)" ).append("\n"); 
		query.append("AND         PS.TURN_PORT_IND_CD   IN ('Y', 'N')" ).append("\n"); 
		query.append("AND         NVL(PS.SKD_CNG_STS_CD, '*') <> 'S'" ).append("\n"); 
		query.append("AND         PS.VPS_PORT_CD        NOT IN ('PAPAC', 'EGSUZ')" ).append("\n"); 
		query.append("AND         MR.VSL_SLAN_CD = PS.SLAN_CD" ).append("\n"); 
		query.append("AND        ROWNUM = 1" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}