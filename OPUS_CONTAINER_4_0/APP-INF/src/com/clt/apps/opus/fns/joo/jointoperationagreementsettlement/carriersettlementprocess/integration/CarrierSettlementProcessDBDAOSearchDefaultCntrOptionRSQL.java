/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOSearchDefaultCntrOptionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.26
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOSearchDefaultCntrOptionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Default Option Search
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOSearchDefaultCntrOptionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOSearchDefaultCntrOptionRSQL").append("\n"); 
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
		query.append("SELECT NVL(B.PPT_CD     , A.PPT_CD)     AS PPT_CD" ).append("\n"); 
		query.append("     , NVL(B.LINE_SEQ   , A.LINE_SEQ)   AS LINE_SEQ" ).append("\n"); 
		query.append("     , NVL(B.SLAN_CD    , A.SLAN_CD)    AS SLAN_CD" ).append("\n"); 
		query.append("     , NVL(B.OPTION_A   , A.OPTION_A)   AS OPTION_A" ).append("\n"); 
		query.append("     , NVL(B.OPTION_B   , A.OPTION_B)   AS OPTION_B" ).append("\n"); 
		query.append("  FROM (SELECT 'OPTION'     AS PPT_CD" ).append("\n"); 
		query.append("             , 1            AS LINE_SEQ" ).append("\n"); 
		query.append("             , NULL         AS SLAN_CD" ).append("\n"); 
		query.append("             , 'OPTION1'    AS OPTION_A" ).append("\n"); 
		query.append("             , 'OPTION1'    AS OPTION_B" ).append("\n"); 
		query.append("          FROM DUAL ) A" ).append("\n"); 
		query.append("     , (SELECT PPT_CD" ).append("\n"); 
		query.append("             , LINE_SEQ" ).append("\n"); 
		query.append("             , ATTR_CTNT1   AS SLAN_CD" ).append("\n"); 
		query.append("             , ATTR_CTNT2   AS OPTION_A" ).append("\n"); 
		query.append("             , ATTR_CTNT3   AS OPTION_B" ).append("\n"); 
		query.append("          FROM JOO_COM_PPT" ).append("\n"); 
		query.append("         WHERE PPT_CD       = 'OPTION'" ).append("\n"); 
		query.append("           AND ATTR_CTNT1   = @[slan_cd]" ).append("\n"); 
		query.append("           AND ROWNUM       = 1) B" ).append("\n"); 
		query.append(" WHERE A.PPT_CD = B.PPT_CD(+)" ).append("\n"); 

	}
}