/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CndCustomsTransmissionDBDAOsearchStiListAtCndRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.28
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.11.28 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndCustomsTransmissionDBDAOsearchStiListAtCndRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vessel Stowage Plan Transmit (BAPLIE) 조회
	  * </pre>
	  */
	public CndCustomsTransmissionDBDAOsearchStiListAtCndRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.integration").append("\n"); 
		query.append("FileName : CndCustomsTransmissionDBDAOsearchStiListAtCndRSQL").append("\n"); 
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
		query.append("SELECT A.ID CNTR_NO ," ).append("\n"); 
		query.append("    A.OPR_CD," ).append("\n"); 
		query.append("    A.POL POL," ).append("\n"); 
		query.append("    A.POD_ISO POD," ).append("\n"); 
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
		query.append("				 					'XX') FE," ).append("\n"); 
		query.append("    A.BAY||A.ROWW||A.TIER STI_POS," ).append("\n"); 
		query.append("    A.IMDG," ).append("\n"); 
		query.append("    A.UNNO," ).append("\n"); 
		query.append("    A.VSL_CD || A.VOY_NO || A.DIR_CD SEARCH_VVD_CD," ).append("\n"); 
		query.append("    A.PORT_CD L_POL," ).append("\n"); 
		query.append("    TO_CHAR(L.SND_DT,'YYYY-MM-DD HH24:MI') SENT_TIME," ).append("\n"); 
		query.append("	L.RSPN_ERR_RSLT_CD CUST_RESULT," ).append("\n"); 
		query.append("    L.POD_CD O_POD," ).append("\n"); 
		query.append("	'' vvd," ).append("\n"); 
		query.append("	'' excludeca," ).append("\n"); 
		query.append("	'' vsl_eng_nm, -- VO 필드추가용." ).append("\n"); 
		query.append("	'' vsl_voy, -- VO 필드추가용." ).append("\n"); 
		query.append("	'' crr_cd, -- VO 필드추가용." ).append("\n"); 
		query.append("	'' TMP1, -- 임시필드." ).append("\n"); 
		query.append("	'' TMP2, -- 임시필드." ).append("\n"); 
		query.append("	'' TMP3, -- 임시필드." ).append("\n"); 
		query.append("	'' TMP4, -- 임시필드." ).append("\n"); 
		query.append("	'' TMP5,  -- 임시필드." ).append("\n"); 
		query.append("    L.VVD_CD as VVD_BAPLIE" ).append("\n"); 
		query.append("FROM BAY_PLAN A, BKG_CSTMS_ADV_STWG_CNTR L, VSK_VSL_PORT_SKD V" ).append("\n"); 
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
		query.append("	-- 20100608 하동일, 경종윤" ).append("\n"); 
		query.append("	-- 미국 Port 이후 부분만 FROB로 신고 되도록 로직 추가 " ).append("\n"); 
		query.append("	AND A.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("	AND A.VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("	AND A.DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("	AND A.POD_ISO = V.VPS_PORT_CD" ).append("\n"); 
		query.append("	AND V.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("	AND V.CLPT_SEQ >= ( " ).append("\n"); 
		query.append("                    SELECT MIN(CLPT_SEQ)" ).append("\n"); 
		query.append("                    FROM VSK_VSL_PORT_SKD " ).append("\n"); 
		query.append("                    WHERE 1=1" ).append("\n"); 
		query.append("                    AND VSL_CD      = SUBSTR(@[vvd],1, 4)" ).append("\n"); 
		query.append("                    AND SKD_VOY_NO  = SUBSTR(@[vvd],5, 4)" ).append("\n"); 
		query.append("                    AND SKD_DIR_CD  = SUBSTR(@[vvd],9, 1)" ).append("\n"); 
		query.append("                    AND VPS_PORT_CD LIKE 'CA%'" ).append("\n"); 
		query.append("                    AND NVL(SKD_CNG_STS_CD, 'X') != 'S'" ).append("\n"); 
		query.append("                  ) " ).append("\n"); 
		query.append("    AND A.VSL_CD = L.VSL_CD(+)" ).append("\n"); 
		query.append("    AND A.VOY_NO = L.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("    AND A.DIR_CD = L.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("    AND A.ID     = L.CNTR_NO(+)" ).append("\n"); 
		query.append("    AND A.PORT_CD = L.LODG_PORT_CD(+)" ).append("\n"); 
		query.append("    --AND NVL(A.PLAN_TYPE, 'XX')=  " ).append("\n"); 
		query.append("    -- NVL((" ).append("\n"); 
		query.append("    --       SELECT DECODE(CHK_MTY_PLN_FLG, 'Y', 'E', 'F') AS PLAN_TYPE" ).append("\n"); 
		query.append("    --       FROM STO_PLN_VSL_PORT_SKD BB" ).append("\n"); 
		query.append("    --       WHERE BB.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("    --        AND BB.SKD_VOY_NO= A.VOY_NO" ).append("\n"); 
		query.append("    --        AND BB.SKD_DIR_CD= A.DIR_CD" ).append("\n"); 
		query.append("    --        AND BB.VPS_PORT_CD= A.PORT_CD" ).append("\n"); 
		query.append("    --        AND CLPT_IND_SEQ='1'" ).append("\n"); 
		query.append("    --   ),'XX')" ).append("\n"); 
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
		query.append("    ,L.RSPN_ERR_RSLT_CD" ).append("\n"); 
		query.append("    ,L.POD_CD" ).append("\n"); 
		query.append("	,L.VVD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ORDER BY CNTR_NO,OPR_CD,POL,POD" ).append("\n"); 

	}
}