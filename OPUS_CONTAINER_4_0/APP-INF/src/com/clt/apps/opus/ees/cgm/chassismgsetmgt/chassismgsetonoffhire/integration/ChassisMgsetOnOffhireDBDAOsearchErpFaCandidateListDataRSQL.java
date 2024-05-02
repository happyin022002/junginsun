/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ChassisMgsetOnOffhireDBDAOsearchErpFaCandidateListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetOnOffhireDBDAOsearchErpFaCandidateListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ChassisMgsetOnOffhireDBDAOsearchErpFaCandidateListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fa_if_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("de_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no_fm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration").append("\n"); 
		query.append("FileName : ChassisMgsetOnOffhireDBDAOsearchErpFaCandidateListDataRSQL").append("\n"); 
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
		query.append("SELECT '' DEL_Chk" ).append("\n"); 
		query.append("      ,A.EQ_NO" ).append("\n"); 
		query.append("      ,A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(A.ONH_DT,'YYYY-MM-DD') AS ONH_DT" ).append("\n"); 
		query.append("      ,A.AGMT_OFC_CTY_CD || LPAD(A.AGMT_SEQ,6,0) AGMT" ).append("\n"); 
		query.append("      ,A.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("      ,A.AGMT_SEQ" ).append("\n"); 
		query.append("      ,A.EQ_SPEC_NO" ).append("\n"); 
		query.append("	  , NVL(A.EQ_CURR_CD,'USD') AS CURR_CD" ).append("\n"); 
		query.append("	  , NVL(A.EQ_AQZ_AMT,'') AS ACT_AMT" ).append("\n"); 
		query.append("	  , NVL(A.EQ_INVST_NO, '') AS INVEST_CD" ).append("\n"); 
		query.append("      , C.VNDR_SEQ" ).append("\n"); 
		query.append("      , D.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("      , TO_CHAR(TO_DATE( B.DE_YRMON,'YYYY-MM'),'YYYY-MM')  DE_YRMON" ).append("\n"); 
		query.append("      , (SELECT" ).append("\n"); 
		query.append("			DECODE(" ).append("\n"); 
		query.append("				(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("				 FROM   COM_INTG_CD_DTL E" ).append("\n"); 
		query.append("				 WHERE E.INTG_CD_ID = 'CD01863' AND E.INTG_CD_VAL_CTNT = A.FA_IF_STS_CD)" ).append("\n"); 
		query.append("				, 'Sent', 'Sent'" ).append("\n"); 
		query.append("				, 'Error', 'Error'" ).append("\n"); 
		query.append("				, 'Completed', 'Completed'" ).append("\n"); 
		query.append("				, 'Not Interfaced'" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		 FROM DUAL ) AS FA_IF_STS_CD" ).append("\n"); 
		query.append("       -- ,'' EQ_KND_CD" ).append("\n"); 
		query.append("       -- ,'' EQ_NO_FM" ).append("\n"); 
		query.append("       -- ,'' EQ_NO_TO" ).append("\n"); 
		query.append("       ,'FNS026-0001' LIFID" ).append("\n"); 
		query.append("       ,A.EAI_IF_NO SEQ" ).append("\n"); 
		query.append("       ,A.IF_TTL_ROW_KNT TOTAL_COUNT" ).append("\n"); 
		query.append("       ,A.IF_SEQ RNUM" ).append("\n"); 
		query.append("       ,'OWN_GAAP_BOOK' BOOK_TYPE_CODE" ).append("\n"); 
		query.append("       , A.EQ_TPSZ_CD ASSET_DESCRIPTION" ).append("\n"); 
		query.append("       ,'A' ASSET_TYPE" ).append("\n"); 
		query.append("       , (SELECT FA_CATE_CD " ).append("\n"); 
		query.append("          FROM MST_FA_CATE " ).append("\n"); 
		query.append("          WHERE EQ_TPSZ_CD = A.EQ_TPSZ_CD AND ROWNUM =1) CATEGORY_SEGMENT" ).append("\n"); 
		query.append("       ,A.EQ_AQZ_AMT COST" ).append("\n"); 
		query.append("       ,'CNTR' LOCATION_SEGMENT" ).append("\n"); 
		query.append("       ,'DATE_PLACED_IN_SERVICE' AS DATE_PLACED_IN_SERVICE" ).append("\n"); 
		query.append("       ,A.EQ_NO TAG_NUMBER" ).append("\n"); 
		query.append("       ,A.EQ_CURR_CD ATTRIBUTE1" ).append("\n"); 
		query.append("       ,A.EQ_AQZ_AMT ATTRIBUTE2" ).append("\n"); 
		query.append("       ,A.EQ_INVST_NO ATTRIBUTE3" ).append("\n"); 
		query.append("       ,A.FA_IF_GRP_SEQ_NO ATTRIBUTE4" ).append("\n"); 
		query.append("       ,DECODE(A.EQ_KND_CD, 'Z', 'CHS', 'G', 'MGS', null) CREATED_BY" ).append("\n"); 
		query.append("       ,TO_CHAR(SYSDATE,'YYYYMMDD') CREATION_DATE" ).append("\n"); 
		query.append("       ,DECODE(A.EQ_KND_CD, 'Z', 'CHS', 'G', 'MGS', null) LAST_UPDATED_BY" ).append("\n"); 
		query.append("       ,TO_CHAR(SYSDATE,'YYYYMMDD') LAST_UPDATE_DATE" ).append("\n"); 
		query.append("       ,D.VNDR_LGL_ENG_NM MANUFACTURER" ).append("\n"); 
		query.append("       ,TO_CHAR(A.MFT_DT, 'YYYYMMDD') ATTRIBUTE21" ).append("\n"); 
		query.append("       ,B.DE_YRMON ACQ_MTH" ).append("\n"); 
		query.append(" FROM CGM_EQUIPMENT A" ).append("\n"); 
		query.append("    , CGM_EQ_LOT   B" ).append("\n"); 
		query.append("    , CGM_EQ_SPEC   C" ).append("\n"); 
		query.append("    , MDM_VENDOR   D" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.EQ_LOT_NO = B.EQ_LOT_NO  " ).append("\n"); 
		query.append("   AND A.EQ_KND_CD = B.EQ_KND_CD  " ).append("\n"); 
		query.append("   AND A.EQ_SPEC_NO = C.EQ_SPEC_NO(+)" ).append("\n"); 
		query.append("   AND C.VNDR_SEQ   = D.VNDR_SEQ(+)" ).append("\n"); 
		query.append("   AND A.EQ_KND_CD  = @[eq_knd_cd]" ).append("\n"); 
		query.append("   AND A.EQ_NO BETWEEN @[eq_no_fm] AND SUBSTR(@[eq_no_fm], 1, 4)|| @[eq_no_to]" ).append("\n"); 
		query.append("   AND B.DE_YRMON   =TO_CHAR(TO_DATE( @[de_yrmon],'YYYY-MM'),'YYYYMM' )" ).append("\n"); 
		query.append("#if ( ${fa_if_sts_cd} == 'Not Interfaced' )" ).append("\n"); 
		query.append(" AND A.FA_IF_STS_CD IS NULL" ).append("\n"); 
		query.append("#elseif ( ${fa_if_sts_cd} != 'ALL' )" ).append("\n"); 
		query.append(" AND A.FA_IF_STS_CD = @[fa_if_sts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY A.EQ_NO ASC" ).append("\n"); 

	}
}