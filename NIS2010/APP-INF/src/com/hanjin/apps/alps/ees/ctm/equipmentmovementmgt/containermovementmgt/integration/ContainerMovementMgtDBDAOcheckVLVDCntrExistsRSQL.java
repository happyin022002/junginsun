/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOcheckVLVDCntrExistsRSQL.java
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

public class ContainerMovementMgtDBDAOcheckVLVDCntrExistsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VL VD시 컨테이너및 VVD번호가 존재하는지 체크
	  * 
	  * * 2011.05.24 나상보 [CHM-201110981] [CTM] Hitchment B/L의 HCMT_CMB_FLG 건 VL 처리 logic 추가
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOcheckVLVDCntrExistsRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("crnt_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_type1",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOcheckVLVDCntrExistsRSQL").append("\n"); 
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
		query.append("#if (${mvmt_sts_cd} == 'VL')" ).append("\n"); 
		query.append("SELECT DISTINCT SUBSTR (CO.CNTR_NO, 0, 10) CNTR_NO," ).append("\n"); 
		query.append("                SUBSTR (CO.CNTR_NO, 11, 1) CHECK_DIGIT, CO.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                CO.CNMV_STS_CD PREV_STS_CD, CO.CRNT_YD_CD ORG_YD_CD" ).append("\n"); 
		query.append("           FROM BKG_VVD BV," ).append("\n"); 
		query.append("                BKG_CONTAINER BC," ).append("\n"); 
		query.append("                BKG_BOOKING BO," ).append("\n"); 
		query.append("                MST_CONTAINER CO," ).append("\n"); 
		query.append("                BKG_VVD BV2" ).append("\n"); 
		query.append("          WHERE BC.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("            AND BV.VSL_CD = @[crnt_vsl_cd]" ).append("\n"); 
		query.append("            AND BV.SKD_VOY_NO = @[crnt_skd_voy_no]" ).append("\n"); 
		query.append("            AND BV.SKD_DIR_CD = @[crnt_skd_dir_cd]" ).append("\n"); 
		query.append("            AND BV.POL_CD = SUBSTR(@[pol_cd], 0, 5)" ).append("\n"); 
		query.append("            AND BV.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("            AND BC.BKG_NO = BO.BKG_NO" ).append("\n"); 
		query.append("#if (${p_type1} != '')" ).append("\n"); 
		query.append("            AND DECODE (NVL (BO.BKG_CGO_TP_CD, ' '), 'P', 'M', 'M', 'M', 'F') = @[p_type1]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_type2} != '')" ).append("\n"); 
		query.append("            AND DECODE (BV2.VSL_PRE_PST_CD, NULL, 'N', 'Y') = (@[p_type2])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            AND BV2.BKG_NO(+) = BV.BKG_NO" ).append("\n"); 
		query.append("--            AND NVL (SUBSTR (BO.BKG_STS_CD, 0, 1), '') <> 'X'" ).append("\n"); 
		query.append("			AND DECODE(BO.HCMT_CMB_FLG, 'Y', ' ', NVL (SUBSTR (BO.BKG_STS_CD, 0, 1), ' ')) <> 'X'" ).append("\n"); 
		query.append("            AND NVL (SUBSTR (BO.BKG_STS_CD, 0, 1), ' ') <> 'S'" ).append("\n"); 
		query.append("            AND BC.CNTR_NO = CO.CNTR_NO" ).append("\n"); 
		query.append("            AND ASCII (BV2.VSL_PRE_PST_CD(+)) * 10 + TO_NUMBER (BV2.VSL_SEQ(+)) <" ).append("\n"); 
		query.append("                        ASCII (BV.VSL_PRE_PST_CD) * 10" ).append("\n"); 
		query.append("                        + TO_NUMBER (BV.VSL_SEQ)" ).append("\n"); 
		query.append("            AND ROWNUM = 1" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT DISTINCT SUBSTR (CM.CNTR_NO, 0, 10) CNTR_NO," ).append("\n"); 
		query.append("                SUBSTR (CM.CNTR_NO, 11, 1) CHECK_DIGIT, CM.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                CO.CNMV_STS_CD PREV_STS_CD, CO.CRNT_YD_CD ORG_YD_CD" ).append("\n"); 
		query.append("           FROM BKG_VVD BV," ).append("\n"); 
		query.append("                BKG_CONTAINER BC," ).append("\n"); 
		query.append("                BKG_BOOKING BO," ).append("\n"); 
		query.append("                CTM_MOVEMENT CM," ).append("\n"); 
		query.append("                MST_CONTAINER CO" ).append("\n"); 
		query.append("          WHERE BC.CNTR_NO = @[cntr_no] " ).append("\n"); 
		query.append("            AND BV.VSL_CD = @[crnt_vsl_cd]" ).append("\n"); 
		query.append("            AND BV.SKD_VOY_NO = @[crnt_skd_voy_no]" ).append("\n"); 
		query.append("            AND BV.SKD_DIR_CD = @[crnt_skd_dir_cd]" ).append("\n"); 
		query.append("            AND BV.POD_CD = SUBSTR(@[pod_cd], 0 ,5)" ).append("\n"); 
		query.append("        #if (${pol_cd} != '')" ).append("\n"); 
		query.append("                    AND BV.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("                    AND BV.POL_CD = SUBSTR (CM.ORG_YD_CD, 1, 5)" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("            AND BV.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("            AND BC.BKG_NO = BO.BKG_NO" ).append("\n"); 
		query.append("            AND NVL (BO.BKG_STS_CD, ' ') <> 'X'" ).append("\n"); 
		query.append("            AND NVL (BO.BKG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("#if (${p_type1} != '')" ).append("\n"); 
		query.append("            AND DECODE (NVL (BO.BKG_CGO_TP_CD, ' '), 'P', 'M', 'M', 'M', 'F') = @[p_type1]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_type2} != '')" ).append("\n"); 
		query.append("            AND DECODE (BV.VSL_PRE_PST_CD, NULL, 'N', 'Y') = (@[p_type2])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            AND BC.CNTR_NO = CM.CNTR_NO" ).append("\n"); 
		query.append("            AND CM.MVMT_STS_CD = 'VL'" ).append("\n"); 
		query.append("            AND BC.CNTR_NO = CO.CNTR_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}