/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerMovementFinderDBDAOConCBookingVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementFinderDBDAOConCBookingVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ContainerMovementFinderDBDAOConCBookingVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vls_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_yard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_type",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.integration").append("\n"); 
		query.append("FileName : ContainerMovementFinderDBDAOConCBookingVORSQL").append("\n"); 
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
		query.append("#if (${flgrslt} == 'RL')" ).append("\n"); 
		query.append("	#if (${viewtype} == '1')" ).append("\n"); 
		query.append("    SELECT CNTR_NO, CNTR_TPSZ_CD, MAX(ORG_YD_CD) ORG_YD_CD, FULL_FG, MAX(MVMT_STS_CD) MVMT_STS_CD, MAX(BKG_NO) BKG_NO" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("		SELECT C.CNTR_NO, C.CNTR_TPSZ_CD, C.ORG_YD_CD, DECODE (B.BKG_CGO_TP_CD, 'P', 'M', 'F' ) FULL_FG, C.CNMV_STS_CD MVMT_STS_CD, C.BKG_NO" ).append("\n"); 
		query.append("		  FROM BKG_CONTAINER C, BKG_BOOKING B" ).append("\n"); 
		query.append("		 WHERE C.BKG_NO IN (" ).append("\n"); 
		query.append("			  SELECT BV.BKG_NO" ).append("\n"); 
		query.append("			    FROM BKG_VVD BV2, BKG_VVD BV" ).append("\n"); 
		query.append("			   WHERE BV.VSL_CD = SUBSTR(@[vls_cd], 0,4)" ).append("\n"); 
		query.append("			     AND BV.SKD_VOY_NO = SUBSTR(@[vls_cd], 5,4)" ).append("\n"); 
		query.append("			     AND BV.SKD_DIR_CD = SUBSTR(@[vls_cd], 9,1)" ).append("\n"); 
		query.append("			     AND BV.POL_YD_CD LIKE @[p_yard] || '%'" ).append("\n"); 
		query.append("			     AND BV2.BKG_NO(+) = BV.BKG_NO" ).append("\n"); 
		query.append("			     AND ASCII (BV2.VSL_PRE_PST_CD(+)) * 10 + TO_NUMBER (BV2.VSL_SEQ(+)) >" ).append("\n"); 
		query.append("					 ASCII (BV.VSL_PRE_PST_CD) * 10" ).append("\n"); 
		query.append("					+ TO_NUMBER (BV.VSL_SEQ)" ).append("\n"); 
		query.append("				#if (${locl_type} != '')" ).append("\n"); 
		query.append("			     AND DECODE (BV2.VSL_PRE_PST_CD, NULL, 'N', 'Y') IN (@[locl_type])" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("		   AND C.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("		   AND B.BKG_STS_CD NOT IN ('X', 'S')" ).append("\n"); 
		query.append("		#if (${cgo_type} != '')" ).append("\n"); 
		query.append("		   AND DECODE(B.BKG_CGO_TP_CD , 'P', 'P', 'F') = @[cgo_type]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    GROUP BY CNTR_NO, CNTR_TPSZ_CD, FULL_FG" ).append("\n"); 
		query.append("    ORDER BY CNTR_NO" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		#if (${mv_type} == '')" ).append("\n"); 
		query.append("			SELECT DISTINCT CNTR_NO, CNTR_TPSZ_CD, CTM.ORG_YD_CD, DECODE(BKG_CGO_TP_CD, 'P', 'M', 'F') FULL_FG, MVMT_STS_CD, MVMT_INP_TP_CD BKG_NO" ).append("\n"); 
		query.append("			  FROM CTM_MOVEMENT CTM " ).append("\n"); 
		query.append("			 WHERE CRNT_VSL_CD = SUBSTR(@[vls_cd], 0,4)" ).append("\n"); 
		query.append("			   AND CRNT_SKD_VOY_NO = SUBSTR(@[vls_cd], 5,4)" ).append("\n"); 
		query.append("			   AND CRNT_SKD_DIR_CD = SUBSTR(@[vls_cd], 9,1)" ).append("\n"); 
		query.append("			   AND ORG_YD_CD       LIKE @[p_yard] || '%'" ).append("\n"); 
		query.append("			#if (${cgo_type} != '')" ).append("\n"); 
		query.append("			   AND DECODE(BKG_CGO_TP_CD , 'P', 'P', 'F') = @[cgo_type]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			   AND MVMT_STS_CD = 'VL'" ).append("\n"); 
		query.append("             ORDER BY CNTR_NO" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			SELECT DISTINCT CNTR_REF_NO CNTR_NO, CNTR_TPSZ_CD CNTR_TPSZ_CD, '' ORG_YD_CD, DECODE(FULL_MTY_CD, 'E', 'M', 'F') FULL_FG, 'VL' MVMT_STS_CD, '' BKG_NO" ).append("\n"); 
		query.append("			  FROM OPF_BAY_PLN_LDIS" ).append("\n"); 
		query.append("			 WHERE VSL_CD = SUBSTR(@[vls_cd], 0,4)" ).append("\n"); 
		query.append("			   AND SKD_VOY_NO = SUBSTR(@[vls_cd], 5,4)" ).append("\n"); 
		query.append("			   AND SKD_DIR_CD = SUBSTR(@[vls_cd], 9,1)" ).append("\n"); 
		query.append("			   AND POL_CD LIKE @[p_yard] || '%'" ).append("\n"); 
		query.append("			   AND LODG_DCHG_IND_CD = 'L'" ).append("\n"); 
		query.append("               AND CRR_CD = COM_CONSTANTMGR_PKG.COM_GETCOMPANYCODE_FNC()" ).append("\n"); 
		query.append("			#if (${cgo_type} != '')" ).append("\n"); 
		query.append("               AND DECODE(FULL_MTY_CD, 'E', 'P', 'M', 'P', 'F') = @[cgo_type]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("          ORDER BY CNTR_NO" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#elseif (${flgrslt} == 'PD')" ).append("\n"); 
		query.append("	#if (${viewtype} == '1')" ).append("\n"); 
		query.append("    SELECT CNTR_NO, CNTR_TPSZ_CD, FULL_FG, MAX(ORG_YD_CD) ORG_YD_CD, MAX(MVMT_STS_CD) MVMT_STS_CD, MAX(BKG_NO) BKG_NO" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("		SELECT C.CNTR_NO, C.CNTR_TPSZ_CD, C.ORG_YD_CD, DECODE(B.BKG_CGO_TP_CD, 'P', 'M', 'F') FULL_FG, C.CNMV_STS_CD MVMT_STS_CD, C.BKG_NO" ).append("\n"); 
		query.append("		FROM BKG_CONTAINER C, BKG_BOOKING B" ).append("\n"); 
		query.append("		WHERE C.BKG_NO IN (" ).append("\n"); 
		query.append("			SELECT BV.BKG_NO" ).append("\n"); 
		query.append("			    FROM BKG_VVD BV2, BKG_VVD BV" ).append("\n"); 
		query.append("			    WHERE  BV.VSL_CD = SUBSTR(@[vls_cd], 0,4)" ).append("\n"); 
		query.append("			    AND BV.SKD_VOY_NO = SUBSTR(@[vls_cd], 5,4)" ).append("\n"); 
		query.append("			    AND BV.SKD_DIR_CD = SUBSTR(@[vls_cd], 9,1)" ).append("\n"); 
		query.append("			    AND BV.POD_YD_CD LIKE @[p_yard] || '%'" ).append("\n"); 
		query.append("			    AND BV2.BKG_NO(+) = BV.BKG_NO" ).append("\n"); 
		query.append("			    AND	ASCII(BV2.VSL_PRE_PST_CD(+)) * 10 + TO_NUMBER(BV2.VSL_SEQ(+)) >" ).append("\n"); 
		query.append("					ASCII(BV.VSL_PRE_PST_CD) * 10 + TO_NUMBER(BV.VSL_SEQ)" ).append("\n"); 
		query.append("				#if (${locl_type} != '')" ).append("\n"); 
		query.append("			     AND DECODE (BV2.VSL_PRE_PST_CD, NULL, 'N', 'Y') IN (@[locl_type])" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("		    )" ).append("\n"); 
		query.append("		AND C.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("		#if (${cgo_type} != '')" ).append("\n"); 
		query.append(" 	    AND DECODE(B.BKG_CGO_TP_CD , 'P', 'P', 'F') = @[cgo_type]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		AND B.BKG_STS_CD NOT IN ('X', 'S')" ).append("\n"); 
		query.append("        AND B.POD_CD <> 'XXXXX'" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    GROUP BY CNTR_NO, CNTR_TPSZ_CD, FULL_FG" ).append("\n"); 
		query.append("    ORDER BY CNTR_NO" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		#if (${mv_type} == '')" ).append("\n"); 
		query.append("		SELECT DISTINCT A.CNTR_NO, A.CNTR_TPSZ_CD, A.FULL_FG, A.ORG_YD_CD, A.MVMT_STS_CD, A.MVMT_INP_TP_CD BKG_NO" ).append("\n"); 
		query.append("		  FROM (SELECT CNTR_NO, CNTR_TPSZ_CD, ORG_YD_CD," ).append("\n"); 
		query.append("			           DECODE (BKG_CGO_TP_CD, 'P', 'M', 'F') FULL_FG, MVMT_STS_CD," ).append("\n"); 
		query.append("			           MVMT_INP_TP_CD, BKG_NO" ).append("\n"); 
		query.append(" 			      FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("			     WHERE CRNT_VSL_CD = SUBSTR(@[vls_cd], 0,4)" ).append("\n"); 
		query.append("			       AND CRNT_SKD_VOY_NO = SUBSTR(@[vls_cd], 5,4)" ).append("\n"); 
		query.append("			       AND CRNT_SKD_DIR_CD = SUBSTR(@[vls_cd], 9,1)" ).append("\n"); 
		query.append("			#if (${cgo_type} != '')" ).append("\n"); 
		query.append(" 		   	       AND DECODE(BKG_CGO_TP_CD , 'P', 'P', 'F') = @[cgo_type]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			       AND MVMT_STS_CD  = 'VL') A," ).append("\n"); 
		query.append("		       (SELECT BV.BKG_NO" ).append("\n"); 
		query.append("			      FROM BKG_VVD BV2, BKG_VVD BV" ).append("\n"); 
		query.append("			     WHERE BV.VSL_CD = SUBSTR(@[vls_cd], 0,4)" ).append("\n"); 
		query.append("			       AND BV.SKD_VOY_NO = SUBSTR(@[vls_cd], 5,4)" ).append("\n"); 
		query.append("			       AND BV.SKD_DIR_CD = SUBSTR(@[vls_cd], 9,1)" ).append("\n"); 
		query.append("			       AND BV.POD_YD_CD LIKE @[p_yard] || '%'" ).append("\n"); 
		query.append("			       AND BV2.BKG_NO(+) = BV.BKG_NO" ).append("\n"); 
		query.append("			       AND ASCII (BV2.VSL_PRE_PST_CD(+)) * 10 + TO_NUMBER (BV2.VSL_SEQ(+)) >" ).append("\n"); 
		query.append("					   ASCII (BV.VSL_PRE_PST_CD) * 10" ).append("\n"); 
		query.append("					   + TO_NUMBER (BV.VSL_SEQ)" ).append("\n"); 
		query.append("				#if (${locl_type} != '')" ).append("\n"); 
		query.append("			       AND DECODE (BV2.VSL_PRE_PST_CD, NULL, 'N', 'Y') IN (@[locl_type])" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				) B" ).append("\n"); 
		query.append("		 WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("         ORDER BY CNTR_NO" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			SELECT DISTINCT CNTR_REF_NO CNTR_NO, CNTR_TPSZ_CD CNTR_TPSZ_CD, '' ORG_YD_CD, DECODE(FULL_MTY_CD, 'E', 'M', 'F') FULL_FG, 'VD' MVMT_STS_CD, '' BKG_NO" ).append("\n"); 
		query.append("  			  FROM OPF_BAY_PLN_LDIS" ).append("\n"); 
		query.append("			 WHERE VSL_CD = SUBSTR(@[vls_cd], 0,4)" ).append("\n"); 
		query.append("			   AND SKD_VOY_NO = SUBSTR(@[vls_cd], 5,4)" ).append("\n"); 
		query.append("			   AND SKD_DIR_CD = SUBSTR(@[vls_cd], 9,1)" ).append("\n"); 
		query.append("			   AND POD_CD LIKE @[p_yard] || '%'" ).append("\n"); 
		query.append("			   AND LODG_DCHG_IND_CD = 'L'" ).append("\n"); 
		query.append("               AND CRR_CD = COM_CONSTANTMGR_PKG.COM_GETCOMPANYCODE_FNC()" ).append("\n"); 
		query.append("			#if (${cgo_type} != '')" ).append("\n"); 
		query.append("               AND DECODE(FULL_MTY_CD,'E', 'P', 'M', 'P', 'F') = @[cgo_type]" ).append("\n"); 
		query.append("             ORDER BY CNTR_NO" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#elseif (${flgrslt} == 'RD')" ).append("\n"); 
		query.append("	#if (${viewtype} == '1')" ).append("\n"); 
		query.append("    SELECT CNTR_NO, CNTR_TPSZ_CD, FULL_FG, MAX(ORG_YD_CD) ORG_YD_CD, MAX(MVMT_STS_CD) MVMT_STS_CD, MAX(BKG_NO) BKG_NO" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("		SELECT C.CNTR_NO, C.CNTR_TPSZ_CD, C.ORG_YD_CD, DECODE(B.BKG_CGO_TP_CD, 'P', 'M', 'F') FULL_FG, C.CNMV_STS_CD MVMT_STS_CD, C.BKG_NO" ).append("\n"); 
		query.append("		FROM BKG_CONTAINER C, BKG_BOOKING B" ).append("\n"); 
		query.append("		WHERE C.BKG_NO IN (" ).append("\n"); 
		query.append("		SELECT BV.BKG_NO" ).append("\n"); 
		query.append("			    FROM BKG_VVD BV2, BKG_VVD BV" ).append("\n"); 
		query.append("			    WHERE  BV.VSL_CD = SUBSTR(@[vls_cd], 0,4)" ).append("\n"); 
		query.append("			    AND BV.SKD_VOY_NO = SUBSTR(@[vls_cd], 5,4)" ).append("\n"); 
		query.append("			    AND BV.SKD_DIR_CD = SUBSTR(@[vls_cd], 9,1)" ).append("\n"); 
		query.append("			    AND BV.POD_YD_CD LIKE @[p_yard] || '%'" ).append("\n"); 
		query.append("			    AND BV2.BKG_NO(+) = BV.BKG_NO" ).append("\n"); 
		query.append("			    AND	ASCII(BV2.VSL_PRE_PST_CD(+)) * 10 + TO_NUMBER(BV2.VSL_SEQ(+)) >" ).append("\n"); 
		query.append("					ASCII(BV.VSL_PRE_PST_CD) * 10 + TO_NUMBER(BV.VSL_SEQ)" ).append("\n"); 
		query.append("				#if (${locl_type} != '')" ).append("\n"); 
		query.append("			     AND DECODE (BV2.VSL_PRE_PST_CD, NULL, 'N', 'Y') IN (@[locl_type])" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("		AND C.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("		#if (${cgo_type} != '')" ).append("\n"); 
		query.append("   	    AND DECODE(B.BKG_CGO_TP_CD , 'P', 'P', 'F') = @[cgo_type]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		AND B.BKG_STS_CD NOT IN ('X', 'S')" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    GROUP BY CNTR_NO, CNTR_TPSZ_CD, FULL_FG" ).append("\n"); 
		query.append("    ORDER BY CNTR_NO" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		SELECT DISTINCT A.CNTR_NO, A.CNTR_TPSZ_CD, A.ORG_YD_CD, A.FULL_FG, A.MVMT_STS_CD, A.MVMT_INP_TP_CD BKG_NO" ).append("\n"); 
		query.append("		  FROM (SELECT CNTR_NO, CNTR_TPSZ_CD, ORG_YD_CD," ).append("\n"); 
		query.append("			       DECODE (BKG_CGO_TP_CD, 'P', 'M', 'F') FULL_FG, MVMT_STS_CD," ).append("\n"); 
		query.append("			       MVMT_INP_TP_CD, BKG_NO" ).append("\n"); 
		query.append("			  FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("			 WHERE CRNT_VSL_CD = SUBSTR(@[vls_cd], 0,4)" ).append("\n"); 
		query.append("			   AND CRNT_SKD_VOY_NO = SUBSTR(@[vls_cd], 5,4)" ).append("\n"); 
		query.append("			   AND CRNT_SKD_DIR_CD = SUBSTR(@[vls_cd], 9,1)" ).append("\n"); 
		query.append("			   AND ORG_YD_CD       LIKE @[p_yard] || '%'" ).append("\n"); 
		query.append("		#if (${cgo_type} != '')" ).append("\n"); 
		query.append(" 		   	   AND DECODE(BKG_CGO_TP_CD , 'P', 'P', 'F') = @[cgo_type]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("			   AND MVMT_STS_CD = 'VD') A," ).append("\n"); 
		query.append("		       (SELECT BV.BKG_NO" ).append("\n"); 
		query.append("			  FROM BKG_VVD BV2, BKG_VVD BV" ).append("\n"); 
		query.append("			 WHERE BV.VSL_CD = SUBSTR(@[vls_cd], 0,4)" ).append("\n"); 
		query.append("			   AND BV.SKD_VOY_NO = SUBSTR(@[vls_cd], 5,4)" ).append("\n"); 
		query.append("			   AND BV.SKD_DIR_CD = SUBSTR(@[vls_cd], 9,1)" ).append("\n"); 
		query.append("			   AND BV.POD_CD = SUBSTR(@[p_yard], 0,5)" ).append("\n"); 
		query.append("			   AND BV2.BKG_NO(+) = BV.BKG_NO" ).append("\n"); 
		query.append("			   AND ASCII (BV2.VSL_PRE_PST_CD(+)) * 10 + TO_NUMBER (BV2.VSL_SEQ(+)) >" ).append("\n"); 
		query.append("				   ASCII (BV.VSL_PRE_PST_CD) * 10" ).append("\n"); 
		query.append("					+ TO_NUMBER (BV.VSL_SEQ)" ).append("\n"); 
		query.append("				#if (${locl_type} != '')" ).append("\n"); 
		query.append("			     AND DECODE (BV2.VSL_PRE_PST_CD, NULL, 'N', 'Y') IN (@[locl_type])" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				) B" ).append("\n"); 
		query.append("		 WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("         ORDER BY CNTR_NO" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}