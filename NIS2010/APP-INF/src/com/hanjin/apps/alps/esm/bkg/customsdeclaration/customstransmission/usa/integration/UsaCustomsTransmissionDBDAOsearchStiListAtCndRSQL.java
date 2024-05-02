/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchStiListAtCndRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.09
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchStiListAtCndRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, 1023화면 조회용. Exclude Canada Import 가 체크 되어 있을 경우, Canada를 제외하고 대상을 조회하는 쿼리.
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchStiListAtCndRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lastpol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntropr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchStiListAtCndRSQL").append("\n"); 
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
		query.append("    A.ID cntr_no ," ).append("\n"); 
		query.append("    A.OPR_CD," ).append("\n"); 
		query.append("    A.POL pol," ).append("\n"); 
		query.append("    A.POD_ISO pod," ).append("\n"); 
		query.append("    A.SZTP," ).append("\n"); 
		query.append("    DECODE(SUBSTR(A.SZTP,  1, 1), 	'R',	'REEFER'," ).append("\n"); 
		query.append("				 					'O',	'OPEN TOP'," ).append("\n"); 
		query.append("				 					'F',	'FLAT RACK'," ).append("\n"); 
		query.append("				 					'P',	'PLATFFORM'," ).append("\n"); 
		query.append("				 					'D',	'DRY'," ).append("\n"); 
		query.append("				 					'T',	'TANK'," ).append("\n"); 
		query.append("				 					'A',	'ADJUSTABLE'," ).append("\n"); 
		query.append("				 					'S',	'OPEN TOP SLIDING'," ).append("\n"); 
		query.append("				 					'Q',	'DEAD SPACE'," ).append("\n"); 
		query.append("				 					'XX') fe," ).append("\n"); 
		query.append("    A.BAY||A.ROWW||A.TIER sti_pos," ).append("\n"); 
		query.append("    A.IMDG," ).append("\n"); 
		query.append("    A.UNNO," ).append("\n"); 
		query.append("    A.VSL_CD || A.VOY_NO || A.DIR_CD vvd," ).append("\n"); 
		query.append("    A.PORT_CD l_pol," ).append("\n"); 
		query.append("    TO_CHAR(L.SND_DT,'YYYY-MM-DD HH24:MI') sent_time," ).append("\n"); 
		query.append("    L.POD_CD o_pod," ).append("\n"); 
		query.append("	'' vsl_eng_nm, -- VO 필드추가용." ).append("\n"); 
		query.append("	'' vsl_voy, -- VO 필드추가용." ).append("\n"); 
		query.append("	'' crr_cd, -- VO 필드추가용." ).append("\n"); 
		query.append("	'' TMP1, -- 임시필드." ).append("\n"); 
		query.append("	'' TMP2, -- 임시필드." ).append("\n"); 
		query.append("	'' TMP3, -- 임시필드." ).append("\n"); 
		query.append("	'' TMP4, -- 임시필드." ).append("\n"); 
		query.append("	'' TMP5  -- 임시필드." ).append("\n"); 
		query.append("FROM BAY_PLAN A, BKG_CSTMS_ADV_STWG_CNTR L" ).append("\n"); 
		query.append("WHERE A.VSL_CD 		= SUBSTR(@[vvd],1, 4)" ).append("\n"); 
		query.append("    and A.VOY_NO 	= SUBSTR(@[vvd],5, 4)" ).append("\n"); 
		query.append("    and A.DIR_CD 	= SUBSTR(@[vvd],9, 1)" ).append("\n"); 
		query.append("#if (${lastpol} != '')" ).append("\n"); 
		query.append("    and A.PORT_CD 	= @[lastpol]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol} != '')" ).append("\n"); 
		query.append("    AND A.POL 		= @[pol]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod} != '')" ).append("\n"); 
		query.append("    AND A.POD_ISO 	= @[pod]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntropr} != '')" ).append("\n"); 
		query.append("    AND A.OPR_CD 	= @[cntropr]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("--------------------------------------------------------------------------" ).append("\n"); 
		query.append("	AND A.POD_ISO 	NOT LIKE 'CA%' -- searchStiListAtUsa와 틀린 부분은 이 라인 뿐이다 ." ).append("\n"); 
		query.append("	--------------------------------------------------------------------------" ).append("\n"); 
		query.append("    AND A.VSL_CD = L.VSL_CD(+)" ).append("\n"); 
		query.append("    AND A.VOY_NO = L.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("    AND A.DIR_CD = L.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("    AND A.ID     = L.CNTR_NO(+)" ).append("\n"); 
		query.append("    AND A.PORT_CD = L.LODG_PORT_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND A.PLAN_TYPE= ( SELECT MIN(PLAN_TYPE) FROM BAY_PLAN BB" ).append("\n"); 
		query.append("                 WHERE A.VSL_CD = BB.VSL_CD" ).append("\n"); 
		query.append("                 AND A.VOY_NO = BB.VOY_NO" ).append("\n"); 
		query.append("                 AND A.DIR_CD = BB.DIR_CD" ).append("\n"); 
		query.append("                 AND A.PORT_CD = BB.PORT_CD" ).append("\n"); 
		query.append("                 AND A.ID = BB.ID" ).append("\n"); 
		query.append("                 AND A.CALL_IND = BB.CALL_IND" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${allerror} == 'ERR') " ).append("\n"); 
		query.append("	and A.POD_ISO <> L.POD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY  " ).append("\n"); 
		query.append("    A.ID" ).append("\n"); 
		query.append("    ,A.OPR_CD" ).append("\n"); 
		query.append("    ,A.POL" ).append("\n"); 
		query.append("    ,A.POD_ISO" ).append("\n"); 
		query.append("    ,A.SZTP" ).append("\n"); 
		query.append("    ,SUBSTR(A.SZTP,  1, 1)" ).append("\n"); 
		query.append("    ,A.BAY||A.ROWW||A.TIER" ).append("\n"); 
		query.append("    ,A.IMDG" ).append("\n"); 
		query.append("    ,A.UNNO" ).append("\n"); 
		query.append("    ,A.VSL_CD || A.VOY_NO || A.DIR_CD" ).append("\n"); 
		query.append("    ,A.PORT_CD" ).append("\n"); 
		query.append("    ,TO_CHAR(L.SND_DT,'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("    ,L.POD_CD" ).append("\n"); 

	}
}