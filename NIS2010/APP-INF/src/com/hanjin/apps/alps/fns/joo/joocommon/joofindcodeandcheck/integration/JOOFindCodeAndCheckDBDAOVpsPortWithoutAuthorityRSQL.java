/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : JOOFindCodeAndCheckDBDAOVpsPortWithoutAuthorityRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.05
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.12.05 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM YOUNG-OH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JOOFindCodeAndCheckDBDAOVpsPortWithoutAuthorityRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VpsPortWithoutAuthority
	  * </pre>
	  */
	public JOOFindCodeAndCheckDBDAOVpsPortWithoutAuthorityRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("super_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("super_cd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("super_cd3",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.integration").append("\n"); 
		query.append("FileName : JOOFindCodeAndCheckDBDAOVpsPortWithoutAuthorityRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT V.VPS_PORT_CD AS CODE, V.VPS_PORT_CD AS NAME" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD V, MDM_REV_LANE L" ).append("\n"); 
		query.append("WHERE  L.REP_TRD_CD = @[super_cd1]  -- 17번 Trade" ).append("\n"); 
		query.append("AND    L.RLANE_CD 	= @[super_cd2] 	-- 18번 Land" ).append("\n"); 
		query.append("AND    V.VSL_CD     = @[super_cd3]  -- 19번 Vessel" ).append("\n"); 
		query.append("AND    V.CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("AND    NVL(V.SKD_CNG_STS_CD,'N') <> 'S'" ).append("\n"); 
		query.append("AND    V.SLAN_CD      = L.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND    V.VPS_ETD_DT > SYSDATE - 365" ).append("\n"); 
		query.append("AND    V.VPS_ETD_DT < SYSDATE + 365" ).append("\n"); 
		query.append("ORDER BY V.VPS_PORT_CD" ).append("\n"); 

	}
}