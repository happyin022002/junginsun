/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOSearchCntrConverionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.07 
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

public class CarrierSettlementProcessDBDAOSearchCntrConverionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Conversion Search.
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOSearchCntrConverionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ppt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dft_tpsz_group",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOSearchCntrConverionRSQL").append("\n"); 
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
		query.append("#if (${ppt_cd} != '' && ${ppt_cd} == 'TPSZ MAP')" ).append("\n"); 
		query.append("SELECT PPT_CD" ).append("\n"); 
		query.append("     , LINE_SEQ" ).append("\n"); 
		query.append("     , ATTR_CTNT1 AS SRC_TPSZ" ).append("\n"); 
		query.append("     , ATTR_CTNT2 AS TGT_NORMAL_TPSZ" ).append("\n"); 
		query.append("     , ATTR_CTNT3 AS TGT_RAD_TPSZ" ).append("\n"); 
		query.append("     , ATTR_CTNT4 AS TGT_EMPTY_TPSZ" ).append("\n"); 
		query.append("  FROM JOO_COM_PPT" ).append("\n"); 
		query.append(" WHERE PPT_CD = @[ppt_cd]" ).append("\n"); 
		query.append(" ORDER BY LINE_SEQ" ).append("\n"); 
		query.append("#elseif (${ppt_cd} != '' && ${ppt_cd} == 'TEU CONVERSION') " ).append("\n"); 
		query.append("SELECT A.PPT_CD" ).append("\n"); 
		query.append("     , A.LINE_SEQ" ).append("\n"); 
		query.append("     , A.SLAN_CD" ).append("\n"); 
		query.append("     , A.TGT_NORMAL_TPSZ" ).append("\n"); 
		query.append("     , A.TEU_CNT" ).append("\n"); 
		query.append("  FROM (SELECT PPT_CD" ).append("\n"); 
		query.append("             , LINE_SEQ" ).append("\n"); 
		query.append("             , ATTR_CTNT1 AS SLAN_CD" ).append("\n"); 
		query.append("             , ATTR_CTNT2 AS TGT_NORMAL_TPSZ" ).append("\n"); 
		query.append("             , ATTR_CTNT3 AS TEU_CNT" ).append("\n"); 
		query.append("             , (SELECT MIN(LINE_SEQ)" ).append("\n"); 
		query.append("                  FROM JOO_COM_PPT B" ).append("\n"); 
		query.append("                 WHERE B.PPT_CD = 'TPSZ MAP'" ).append("\n"); 
		query.append("                   AND B.ATTR_CTNT2 = A.ATTR_CTNT2) AS TPSZ_LINE_SEQ" ).append("\n"); 
		query.append("          FROM JOO_COM_PPT A" ).append("\n"); 
		query.append("         WHERE A.PPT_CD = @[ppt_cd] " ).append("\n"); 
		query.append("         #if (${slan_cd} != '') " ).append("\n"); 
		query.append("           AND A.ATTR_CTNT1 = @[slan_cd]" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("       ) A" ).append("\n"); 
		query.append(" ORDER BY A.SLAN_CD, A.TPSZ_LINE_SEQ" ).append("\n"); 
		query.append("#elseif (${ppt_cd} != '' && ${ppt_cd} == 'VOID CONVERSION')  " ).append("\n"); 
		query.append("SELECT PPT_CD" ).append("\n"); 
		query.append("     , LINE_SEQ" ).append("\n"); 
		query.append("     , ATTR_CTNT1 AS SLAN_CD" ).append("\n"); 
		query.append("     , ATTR_CTNT2 AS OR_YN" ).append("\n"); 
		query.append("     , ATTR_CTNT3 AS OL_YN" ).append("\n"); 
		query.append("     , ATTR_CTNT4 AS OH_YN" ).append("\n"); 
		query.append("     , ATTR_CTNT5 AS VOID_CNT" ).append("\n"); 
		query.append("  FROM JOO_COM_PPT" ).append("\n"); 
		query.append(" WHERE PPT_CD = @[ppt_cd]" ).append("\n"); 
		query.append("   #if (${slan_cd} != '') " ).append("\n"); 
		query.append("   AND ATTR_CTNT1 = @[slan_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#elseif (${ppt_cd} != '' && ${ppt_cd} == 'DEFAULT TPSZ')  " ).append("\n"); 
		query.append("SELECT PPT_CD" ).append("\n"); 
		query.append("     , LINE_SEQ" ).append("\n"); 
		query.append("     , ATTR_CTNT1 AS DFT_TPSZ_GROUP /*F : Laden, E : Empty*/" ).append("\n"); 
		query.append("     , ATTR_CTNT2 AS DFT_TPSZ" ).append("\n"); 
		query.append("     , ATTR_CTNT3 AS DFT_TEU_CNT" ).append("\n"); 
		query.append("     , ATTR_CTNT4 AS DFT_RF_PLUG_FLG" ).append("\n"); 
		query.append("  FROM JOO_COM_PPT" ).append("\n"); 
		query.append(" WHERE PPT_CD = @[ppt_cd]" ).append("\n"); 
		query.append("   #if (${dft_tpsz_group} != '') " ).append("\n"); 
		query.append("   AND ATTR_CTNT1 = @[dft_tpsz_group]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append(" ORDER BY ATTR_CTNT1 DESC, LINE_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}