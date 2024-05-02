/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOsearchCntrReeferUnitInfoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.22
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.10.22 남궁진호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author NamKoong JinHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOsearchCntrReeferUnitInfoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Reefer Unit Info Retrieve Query
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOsearchCntrReeferUnitInfoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sts_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOsearchCntrReeferUnitInfoListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("        A.CNTR_NO" ).append("\n"); 
		query.append("        ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        ,A.LSTM_CD" ).append("\n"); 
		query.append("        ,TO_CHAR(A.ONH_DT, 'YYYY-MM-DD') ONH_DT" ).append("\n"); 
		query.append("        ,AGMT_CTY_CD||TO_CHAR(AGMT_SEQ,'000000') AS AGMT_NO" ).append("\n"); 
		query.append("        ,A.VNDR_SEQ" ).append("\n"); 
		query.append("        ,DECODE(A.RF_MKR_SEQ, 0, '', A.RF_MKR_SEQ)AS RF_MKR_SEQ" ).append("\n"); 
		query.append("        ,NVL(B.VNDR_ABBR_NM, B.VNDR_LGL_ENG_NM) AS  RF_MKR_NM" ).append("\n"); 
		query.append("        ,A.RF_MDL_NM" ).append("\n"); 
		query.append("        ,A.RF_RFR_NO" ).append("\n"); 
		query.append("        ,A.MIN_TEMP" ).append("\n"); 
		query.append("        ,A.MAX_TEMP        " ).append("\n"); 
		query.append("        ,'' AS AEFlG" ).append("\n"); 
		query.append("        ,'' AS BEFlG" ).append("\n"); 
		query.append("        ,'' AS CEFlG" ).append("\n"); 
		query.append("        ,'' AS DEFlG" ).append("\n"); 
		query.append("        ,'' AS EEFlG" ).append("\n"); 
		query.append("    FROM " ).append("\n"); 
		query.append("        MST_CONTAINER A, " ).append("\n"); 
		query.append("        MDM_VENDOR B" ).append("\n"); 
		query.append("    WHERE  A.RF_MKR_SEQ  = B.VNDR_SEQ(+)" ).append("\n"); 
		query.append(" 	AND A.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append(" #if (${lstm_cd} != '' && ${lstm_cd} != 'ALL')" ).append("\n"); 
		query.append("    AND   A.LSTM_CD  IN ( #foreach($key IN ${arr_lstm_cd})" ).append("\n"); 
		query.append("                                     #if($velocityCount < $arr_lstm_cd.size())" ).append("\n"); 
		query.append("                                        '$key'," ).append("\n"); 
		query.append("                                     #else" ).append("\n"); 
		query.append("                                        '$key'" ).append("\n"); 
		query.append("                                     #end" ).append("\n"); 
		query.append("                                #end )" ).append("\n"); 
		query.append(" #else" ).append("\n"); 
		query.append("    AND A.LSTM_CD IN ('ST', 'LT')" ).append("\n"); 
		query.append(" #end " ).append("\n"); 
		query.append("  #if (${agmt_cty_cd} != '' && ${agmt_seq} != '')" ).append("\n"); 
		query.append("    AND A.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("    AND A.AGMT_SEQ    = @[agmt_seq]			" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${sts_flg} != '')" ).append("\n"); 
		query.append("    AND A.ACIAC_DIV_CD = @[sts_flg]" ).append("\n"); 
		query.append(" #end " ).append("\n"); 
		query.append(" #if (${mi_flg} == 'Y')" ).append("\n"); 
		query.append("    AND NVL(A.RF_MKR_SEQ, 0) <> 0" ).append("\n"); 
		query.append(" #elseif(${mi_flg} == 'N')" ).append("\n"); 
		query.append("    AND NVL(A.RF_MKR_SEQ, 0) = 0" ).append("\n"); 
		query.append(" #end  " ).append("\n"); 
		query.append(" #if (${cntr_tpsz_cd} != '' && ${cntr_tpsz_cd} != 'ALL')" ).append("\n"); 
		query.append("    AND   A.CNTR_TPSZ_CD  IN ( #foreach($key IN ${arr_cntr_tpsz_cd})" ).append("\n"); 
		query.append("                                     #if($velocityCount < $arr_cntr_tpsz_cd.size())" ).append("\n"); 
		query.append("                                        '$key'," ).append("\n"); 
		query.append("                                     #else" ).append("\n"); 
		query.append("                                        '$key'" ).append("\n"); 
		query.append("                                     #end" ).append("\n"); 
		query.append("                                #end )" ).append("\n"); 
		query.append(" #else" ).append("\n"); 
		query.append("    AND A.CNTR_TPSZ_CD LIKE 'R%'" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" ORDER BY A.CNTR_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${a} != '') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${a} != '') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}