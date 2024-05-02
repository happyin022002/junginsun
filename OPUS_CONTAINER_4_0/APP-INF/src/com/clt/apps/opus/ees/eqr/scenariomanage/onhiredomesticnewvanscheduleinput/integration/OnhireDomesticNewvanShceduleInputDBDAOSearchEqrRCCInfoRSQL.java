/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OnhireDomesticNewvanShceduleInputDBDAOSearchEqrRCCInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.30
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2016.03.30 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnhireDomesticNewvanShceduleInputDBDAOSearchEqrRCCInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eqr Loc 조회
	  * </pre>
	  */
	public OnhireDomesticNewvanShceduleInputDBDAOSearchEqrRCCInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ecc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.integration").append("\n"); 
		query.append("FileName : OnhireDomesticNewvanShceduleInputDBDAOSearchEqrRCCInfoRSQL").append("\n"); 
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
		query.append("SELECT EOC.RCC_CD " ).append("\n"); 
		query.append("	FROM MDM_EQ_ORZ_CHT EOC" ).append("\n"); 
		query.append("    WHERE EOC.DELT_FLG = 'N'" ).append("\n"); 
		query.append("    AND   EOC.LCC_CD = @[ecc_cd]" ).append("\n"); 
		query.append("    AND   ROWNUM = 1" ).append("\n"); 
		query.append("--    AND   EOC.RCC_CD = (SELECT SUB.RCC_CD" ).append("\n"); 
		query.append("--						FROM MDM_ORGANIZATION MO, MDM_EQ_ORZ_CHT SUB" ).append("\n"); 
		query.append("--                        WHERE MO.OFC_CD ='11'" ).append("\n"); 
		query.append("--                        AND MO.LOC_CD = SUB.SCC_CD" ).append("\n"); 
		query.append("--                        AND SUB.DELT_FLG = 'N'" ).append("\n"); 
		query.append("--                        AND ROWNUM = 1)" ).append("\n"); 

	}
}