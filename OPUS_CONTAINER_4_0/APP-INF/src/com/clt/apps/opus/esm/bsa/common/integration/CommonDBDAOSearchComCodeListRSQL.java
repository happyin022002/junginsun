/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CommonDBDAOSearchComCodeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bsa.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchComCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Common 공통코드 조회 쿼리
	  * </pre>
	  */
	public CommonDBDAOSearchComCodeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_op_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bsa.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchComCodeListRSQL").append("\n"); 
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
		query.append("#if (${codeItem} == 'trade') /*MDM_TRADE  (콤보 반환)*/" ).append("\n"); 
		query.append("	SELECT TRD_CD CODE, TRD_CD NAME " ).append("\n"); 
		query.append("    FROM MDM_TRADE " ).append("\n"); 
		query.append("    WHERE VSL_TP_CD = 'C' " ).append("\n"); 
		query.append("     AND DELT_FLG  = 'N' " ).append("\n"); 
		query.append("     AND TRD_CD NOT IN('COM') " ).append("\n"); 
		query.append("    ORDER BY TRD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${codeItem} == 'subTrade') /* MDM_DTL_REV_LANE   (콤보 반환)*/" ).append("\n"); 
		query.append("	SELECT DISTINCT  TRD_CD KEY, SUB_TRD_CD CODE, SUB_TRD_CD NAME " ).append("\n"); 
		query.append("    FROM MDM_DTL_REV_LANE " ).append("\n"); 
		query.append("    WHERE SUB_TRD_CD IS NOT NULL " ).append("\n"); 
		query.append("    AND TRD_CD     = NVL(@[trd_cd], TRD_CD) " ).append("\n"); 
		query.append("    ORDER BY TRD_CD, SUB_TRD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${codeItem} == 'rLane') /*COA_LANE_RGST (콤보 반환)*/" ).append("\n"); 
		query.append("	SELECT DISTINCT RLANE_CD NAME, RLANE_CD CODE " ).append("\n"); 
		query.append("    FROM COA_LANE_RGST " ).append("\n"); 
		query.append("    WHERE TRD_CD = CASE  " ).append("\n"); 
		query.append("                     WHEN @[trd_cd] IS NULL AND @[sub_trd_cd] IS NULL " ).append("\n"); 
		query.append("                       THEN TRD_CD  " ).append("\n"); 
		query.append("                     WHEN @[trd_cd] IS NULL AND @[sub_trd_cd] IS NOT NULL " ).append("\n"); 
		query.append("                       THEN TRD_CD " ).append("\n"); 
		query.append("                     ELSE " ).append("\n"); 
		query.append("                       @[trd_cd] " ).append("\n"); 
		query.append("                   END " ).append("\n"); 
		query.append("     AND SUB_TRD_CD = NVL(@[sub_trd_cd],SUB_TRD_CD) " ).append("\n"); 
		query.append("     AND NVL(DELT_FLG,'N') = 'N' " ).append("\n"); 
		query.append("    ORDER BY RLANE_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${codeItem} == 'rLane4') /*COA_LANE_RGST(콤보 반환)*/" ).append("\n"); 
		query.append("	SELECT DISTINCT TRD_CD KEY, RLANE_CD NAME, RLANE_CD CODE " ).append("\n"); 
		query.append("    FROM COA_LANE_RGST " ).append("\n"); 
		query.append("    WHERE NVL(DELT_FLG,'N') = 'N' " ).append("\n"); 
		query.append("     AND TRD_CD = NVL(@[trd_cd], TRD_CD) " ).append("\n"); 
		query.append("     AND SUB_TRD_CD <> 'IP' " ).append("\n"); 
		query.append("    ORDER BY KEY, NAME " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${codeItem} == 'optBSA') /*6. Option List(BSA)	*/" ).append("\n"); 
		query.append("	SELECT bsa_op_jb_cd code, bsa_op_jb_desc name " ).append("\n"); 
		query.append("	FROM BSA_OP_JB " ).append("\n"); 
		query.append("	WHERE bsa_op_cd      ='S' " ).append("\n"); 
		query.append("	--   AND bsa_op_mgmt_cd = ? " ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("	--2009.09.25 변경" ).append("\n"); 
		query.append("	  AND bsa_op_jb_cd IN ('007','008','009','010','011','012','013','014','022') " ).append("\n"); 
		query.append("	--2009.09.25 변경" ).append("\n"); 
		query.append("	 ORDER BY CASE WHEN 	BSA_OP_JB_CD < '011' THEN BSA_OP_JB_CD ELSE BSA_OP_JB_DESC END " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${codeItem} == 'bsaOpJb') /*7. BSA Operation Job List	*/" ).append("\n"); 
		query.append("	SELECT bsa_op_jb_cd code," ).append("\n"); 
		query.append("	       bsa_op_jb_desc NAME" ).append("\n"); 
		query.append("	FROM bsa_op_jb" ).append("\n"); 
		query.append("	WHERE bsa_op_cd = 'J'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${codeItem} == 'BSACarrier') /*7. BSA Operation Job List	*/" ).append("\n"); 
		query.append("	 SELECT DISTINCT crr_cd AS code " ).append("\n"); 
		query.append("	       ,crr_cd AS name " ).append("\n"); 
		query.append("	 FROM   bsa_crr_rgst " ).append("\n"); 
		query.append("	 WHERE  bsa_op_cd     = @[bsa_op_cd] " ).append("\n"); 
		query.append("	 AND    bsa_op_jb_cd  IN ('001','002','003','004','005') " ).append("\n"); 
		query.append("	 AND    aply_flg      = 'Y' " ).append("\n"); 
		query.append("	ORDER BY crr_cd " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}