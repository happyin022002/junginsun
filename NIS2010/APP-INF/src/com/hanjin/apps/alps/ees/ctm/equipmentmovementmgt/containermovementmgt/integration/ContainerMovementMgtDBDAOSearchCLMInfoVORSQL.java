/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOSearchCLMInfoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.23
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2011.05.23 나상보
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sangbo La
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOSearchCLMInfoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Ticket No : CHM-201108835-01
	  * 개발자 : 나상보
	  * Title : bkg/mvmt vl/vd unmatch inquiry 화면 logic 추가
	  * Description :    1.Cancel된 mt bkg 조회되지 않도록 수정
	  * 
	  * * 2011.05.24 나상보 [CHM-201110981] [CTM] Hitchment B/L의 HCMT_CMB_FLG 건 VL 처리 logic 추가
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOSearchCLMInfoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_yard1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_status",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_yard2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_type2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_type1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_date0",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_pol",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOSearchCLMInfoVORSQL").append("\n"); 
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
		query.append("#if (${p_status} == 'VL')" ).append("\n"); 
		query.append("        SELECT DISTINCT SUBSTR(CO.CNTR_NO,0,10) CNTR_NO, SUBSTR(CO.CNTR_NO, 11,1) CHECK_DIGIT, " ).append("\n"); 
		query.append("               CO.CNTR_TPSZ_CD, CO.CNMV_STS_CD PREV_STS_CD, @[p_yard1] || @[p_yard2] ORG_YD_CD, '' BKG_NO, " ).append("\n"); 
		query.append("               '' RCV_TERM_CD, @[p_date0] MVMT_EVNT_DT, @[p_status] MVMT_STS_CD, SUBSTR(@[p_vvd], 0 ,4) CRNT_VSL_CD," ).append("\n"); 
		query.append("               SUBSTR(@[p_vvd], 5 ,4) CRNT_SKD_VOY_NO, SUBSTR(@[p_vvd], 9,1) CRNT_SKD_DIR_CD, @[p_pol] POL_CD, " ).append("\n"); 
		query.append("               @[p_pod] POD_CD, @[p_date0] CNMV_EVNT_DT" ).append("\n"); 
		query.append("                   FROM BKG_VVD BV," ).append("\n"); 
		query.append("                        BKG_CONTAINER BC," ).append("\n"); 
		query.append("                        BKG_BOOKING BO," ).append("\n"); 
		query.append("                        MST_CONTAINER CO," ).append("\n"); 
		query.append("                        BKG_VVD BV2" ).append("\n"); 
		query.append("                  WHERE 1 = 1" ).append("\n"); 
		query.append("        #if (${p_vvd} != '')" ).append("\n"); 
		query.append("                    AND BV.VSL_CD = SUBSTR(@[p_vvd], 0,4)" ).append("\n"); 
		query.append("                    AND BV.SKD_VOY_NO = SUBSTR(@[p_vvd], 5,4)" ).append("\n"); 
		query.append("                    AND BV.SKD_DIR_CD = SUBSTR(@[p_vvd], 9,1)" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${p_pol} != '')" ).append("\n"); 
		query.append("                    AND BV.POL_CD = @[p_pol]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${p_pod} != '')" ).append("\n"); 
		query.append("                    AND BV.POD_CD = @[p_pod]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("                    AND BV.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("                    AND BC.BKG_NO = BO.BKG_NO" ).append("\n"); 
		query.append("                    AND BV2.BKG_NO(+) = BV.BKG_NO" ).append("\n"); 
		query.append("--                    AND NVL (SUBSTR (BO.BKG_STS_CD, 0, 1), '') <> 'X'" ).append("\n"); 
		query.append("					AND DECODE(BO.HCMT_CMB_FLG, 'Y', ' ', NVL (SUBSTR (BO.BKG_STS_CD, 0, 1), ' ')) <> 'X'" ).append("\n"); 
		query.append("                    AND NVL (SUBSTR (BO.BKG_STS_CD, 0, 1), ' ') <> 'S'" ).append("\n"); 
		query.append("                    AND BC.CNTR_NO = CO.CNTR_NO" ).append("\n"); 
		query.append("                    AND ASCII (BV2.VSL_PRE_PST_CD(+)) * 10 + TO_NUMBER (BV2.VSL_SEQ(+)) <" ).append("\n"); 
		query.append("                                ASCII (BV.VSL_PRE_PST_CD) * 10" ).append("\n"); 
		query.append("                                + TO_NUMBER (BV.VSL_SEQ)" ).append("\n"); 
		query.append("        #if (${p_type1} != '')" ).append("\n"); 
		query.append("                    AND DECODE (NVL (BO.BKG_CGO_TP_CD, ' '), 'P', 'M', 'M', 'M', 'F') IN (@[p_type1])" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${p_type2} != '')" ).append("\n"); 
		query.append("                    AND DECODE (BV2.VSL_PRE_PST_CD, NULL, 'N', 'Y') IN (@[p_type2])" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        MINUS" ).append("\n"); 
		query.append("        SELECT DISTINCT SUBSTR(CT.CNTR_NO,0,10) CNTR_NO, SUBSTR(CT.CNTR_NO, 11,1) CHECK_DIGIT, CT.CNTR_TPSZ_CD, CO.CNMV_STS_CD, @[p_yard1] || @[p_yard2] ORG_YD_CD, " ).append("\n"); 
		query.append("               '' BKG_NO, '' BKG_RCV_TERM_CD, @[p_date0] MVMT_EVNT_DT, @[p_status] MVMT_STS_CD, SUBSTR(@[p_vvd], 0 ,4) CRNT_VSL_CD," ).append("\n"); 
		query.append("               SUBSTR(@[p_vvd], 5 ,4) CRNT_SKD_VOY_NO, SUBSTR(@[p_vvd], 9,1) CRNT_SKD_DIR_CD, @[p_pol] POL_CD, " ).append("\n"); 
		query.append("               @[p_pod] POD_CD, @[p_date0] CNMV_EVNT_DT" ).append("\n"); 
		query.append("                   FROM CTM_MOVEMENT CT, MST_CONTAINER CO" ).append("\n"); 
		query.append("                  WHERE 1 = 1" ).append("\n"); 
		query.append("        #if (${p_vvd} != '')" ).append("\n"); 
		query.append("                    AND CT.CRNT_VSL_CD = SUBSTR(@[p_vvd], 0,4)" ).append("\n"); 
		query.append("                    AND CT.CRNT_SKD_VOY_NO = SUBSTR(@[p_vvd], 5,4)" ).append("\n"); 
		query.append("                    AND CT.CRNT_SKD_DIR_CD = SUBSTR(@[p_vvd], 9,1)" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("                    AND CT.MVMT_STS_CD   = @[p_status]" ).append("\n"); 
		query.append("        #if (${p_pol} != '')" ).append("\n"); 
		query.append("                    AND SUBSTR (CT.ORG_YD_CD, 1, 5) = @[p_pol]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("          AND CT.CNTR_NO = CO.CNTR_NO" ).append("\n"); 
		query.append("        ORDER BY CNTR_NO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	SELECT DISTINCT SUBSTR(CM.CNTR_NO,0,10) CNTR_NO, SUBSTR(CM.CNTR_NO, 11,1) CHECK_DIGIT, " ).append("\n"); 
		query.append("           CM.CNTR_TPSZ_CD, CO.CNMV_STS_CD PREV_STS_CD, @[p_yard1] || @[p_yard2] ORG_YD_CD, '' BKG_NO, '' RCV_TERM_CD, " ).append("\n"); 
		query.append("           @[p_date0] MVMT_EVNT_DT,  @[p_status] MVMT_STS_CD, SUBSTR(@[p_vvd], 0 ,4) CRNT_VSL_CD," ).append("\n"); 
		query.append("               SUBSTR(@[p_vvd], 5 ,4) CRNT_SKD_VOY_NO, SUBSTR(@[p_vvd], 9,1) CRNT_SKD_DIR_CD, @[p_pol] POL_CD, " ).append("\n"); 
		query.append("               @[p_pod] POD_CD, @[p_date0] CNMV_EVNT_DT" ).append("\n"); 
		query.append("		   FROM BKG_VVD BV, BKG_CONTAINER BC, BKG_BOOKING BO, CTM_MOVEMENT CM, MST_CONTAINER CO" ).append("\n"); 
		query.append("		  WHERE 1 = 1" ).append("\n"); 
		query.append("        #if (${p_vvd} != '')" ).append("\n"); 
		query.append("                    AND BV.VSL_CD = SUBSTR(@[p_vvd], 0,4)" ).append("\n"); 
		query.append("                    AND BV.SKD_VOY_NO = SUBSTR(@[p_vvd], 5,4)" ).append("\n"); 
		query.append("                    AND BV.SKD_DIR_CD = SUBSTR(@[p_vvd], 9,1)" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${p_pol} != '')" ).append("\n"); 
		query.append("                    AND BV.POL_CD = @[p_pol]" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("                    AND BV.POL_CD = SUBSTR (CM.ORG_YD_CD, 1, 5)" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${p_pod} != '')" ).append("\n"); 
		query.append("                    AND BV.POD_CD = @[p_pod]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("		    AND BV.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("		    AND BC.BKG_NO = BO.BKG_NO" ).append("\n"); 
		query.append("		    AND NVL (BO.BKG_STS_CD, ' ') <> 'X'" ).append("\n"); 
		query.append("		    AND NVL (BO.BKG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("		    AND BC.CNTR_NO = CM.CNTR_NO" ).append("\n"); 
		query.append("		    AND CM.MVMT_STS_CD =  'VL'" ).append("\n"); 
		query.append("            AND BC.CNTR_NO = CO.CNTR_NO" ).append("\n"); 
		query.append("        #if (${p_type1} != '')" ).append("\n"); 
		query.append("                    AND DECODE (NVL (BO.BKG_CGO_TP_CD, ' '), 'P', 'M', 'M', 'M', 'F') IN (@[p_type1])" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${p_type2} != '')" ).append("\n"); 
		query.append("                    AND DECODE (BV.VSL_PRE_PST_CD, NULL, 'N', 'Y') IN (@[p_type2])" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("			AND BO.POD_CD <> 'XXXXX'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	MINUS" ).append("\n"); 
		query.append("	SELECT DISTINCT SUBSTR(CT.CNTR_NO,0,10) CNTR_NO, SUBSTR(CT.CNTR_NO, 11,1) CHECK_DIGIT, CT.CNTR_TPSZ_CD, CO.CNMV_STS_CD, @[p_yard1] || @[p_yard2] ORG_YD_CD, '' BKG_NO, '' BKG_RCV_TERM_CD, @[p_date0] MVMT_EVNT_DT, @[p_status] MVMT_STS_CD, SUBSTR(@[p_vvd], 0 ,4) CRNT_VSL_CD," ).append("\n"); 
		query.append("               SUBSTR(@[p_vvd], 5 ,4) CRNT_SKD_VOY_NO, SUBSTR(@[p_vvd], 9,1) CRNT_SKD_DIR_CD, @[p_pol] POL_CD, " ).append("\n"); 
		query.append("               @[p_pod] POD_CD, @[p_date0] MVMT_EVNT_DT" ).append("\n"); 
		query.append("		   FROM CTM_MOVEMENT CT, MST_CONTAINER CO" ).append("\n"); 
		query.append("		  WHERE 1 = 1" ).append("\n"); 
		query.append("        #if (${p_vvd} != '')" ).append("\n"); 
		query.append("                    AND CT.CRNT_VSL_CD = SUBSTR(@[p_vvd], 0,4)" ).append("\n"); 
		query.append("                    AND CT.CRNT_SKD_VOY_NO = SUBSTR(@[p_vvd], 5,4)" ).append("\n"); 
		query.append("                    AND CT.CRNT_SKD_DIR_CD = SUBSTR(@[p_vvd], 9,1)" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("                    AND CT.MVMT_STS_CD   =  @[p_status]" ).append("\n"); 
		query.append("        #if (${p_pod} != '')" ).append("\n"); 
		query.append("                    AND SUBSTR (CT.ORG_YD_CD, 1, 5) = @[p_pod]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("          AND CT.CNTR_NO = CO.CNTR_NO" ).append("\n"); 
		query.append("        ORDER BY CNTR_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}