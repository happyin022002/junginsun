/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerMovementFinderDBDAOConCBookingCountRSQL.java
*@FileTitle : VL/VD EDI Test Result
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.31
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.08.31 우경민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kyung Min Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementFinderDBDAOConCBookingCountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EES_CTM_0413의 Matched Count를 구한다
	  * </pre>
	  */
	public ContainerMovementFinderDBDAOConCBookingCountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("vls_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cgo_type",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.integration").append("\n"); 
		query.append("FileName : ContainerMovementFinderDBDAOConCBookingCountRSQL").append("\n"); 
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
		query.append("SELECT COUNT(1) AS MAT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT C.CNTR_NO, C.CNTR_TPSZ_CD, DECODE (B.BKG_CGO_TP_CD, 'P', 'M', 'F' ) FULL_FG, C.CNMV_STS_CD MVMT_STS_CD, C.BKG_NO" ).append("\n"); 
		query.append("FROM BKG_CONTAINER C, BKG_BOOKING B" ).append("\n"); 
		query.append("WHERE C.BKG_NO IN (" ).append("\n"); 
		query.append("SELECT BV.BKG_NO" ).append("\n"); 
		query.append("FROM BKG_VVD BV2, BKG_VVD BV" ).append("\n"); 
		query.append("WHERE BV.VSL_CD = SUBSTR(@[vls_cd], 0,4)" ).append("\n"); 
		query.append("AND BV.SKD_VOY_NO = SUBSTR(@[vls_cd], 5,4)" ).append("\n"); 
		query.append("AND BV.SKD_DIR_CD = SUBSTR(@[vls_cd], 9,1)" ).append("\n"); 
		query.append("AND BV.POL_CD = SUBSTR(@[pol_cd], 0, 5)" ).append("\n"); 
		query.append("AND BV2.BKG_NO(+) = BV.BKG_NO" ).append("\n"); 
		query.append("AND ASCII (BV2.VSL_PRE_PST_CD(+)) * 10 + TO_NUMBER (BV2.VSL_SEQ(+)) <" ).append("\n"); 
		query.append("ASCII (BV.VSL_PRE_PST_CD) * 10" ).append("\n"); 
		query.append("+ TO_NUMBER (BV.VSL_SEQ)" ).append("\n"); 
		query.append("#if (${locl_type} != '')" ).append("\n"); 
		query.append("AND DECODE (BV2.VSL_PRE_PST_CD, NULL, 'N', 'Y') IN (@[locl_type])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND C.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND B.BKG_STS_CD NOT IN ('X', 'S')" ).append("\n"); 
		query.append(") A, (" ).append("\n"); 
		query.append("#if (${mv_type} == '')" ).append("\n"); 
		query.append("SELECT CNTR_NO, CNTR_TPSZ_CD, DECODE (BKG_CGO_TP_CD, 'P', 'M', 'F' ) FULL_FG, MVMT_STS_CD, MVMT_INP_TP_CD BKG_NO" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("WHERE CRNT_VSL_CD = SUBSTR(@[vls_cd], 0,4)" ).append("\n"); 
		query.append("AND CRNT_SKD_VOY_NO = SUBSTR(@[vls_cd], 5,4)" ).append("\n"); 
		query.append("AND CRNT_SKD_DIR_CD = SUBSTR(@[vls_cd], 9,1)" ).append("\n"); 
		query.append("AND SUBSTR(ORG_YD_CD,1, 5) = @[pol_cd]" ).append("\n"); 
		query.append("AND MVMT_STS_CD = 'VL'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT CNTR_REF_NO CNTR_NO, ISM_CNTR_TPSZ_CD CNTR_TPSZ_CD, DECODE(FULL_MTY_CD, 'E', 'M', 'F') FULL_FG, 'VL' MVMT_STS_CD, '' BKG_NO" ).append("\n"); 
		query.append("FROM OPF_BAY_PLN_LDIS" ).append("\n"); 
		query.append("WHERE VSL_CD = SUBSTR(@[vls_cd], 0,4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[vls_cd], 5,4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[vls_cd], 9,1)" ).append("\n"); 
		query.append("AND POL_CD = SUBSTR(@[pol_cd], 0, 5)" ).append("\n"); 
		query.append("AND LODG_DCHG_IND_CD = 'C'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("AND A.MVMT_STS_CD = B.MVMT_STS_CD" ).append("\n"); 
		query.append("#elseif (${flgrslt} == 'PD')" ).append("\n"); 
		query.append("SELECT COUNT(1) AS MAT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT C.CNTR_NO, C.CNTR_TPSZ_CD, DECODE(B.BKG_CGO_TP_CD, 'P', 'M', 'F') FULL_FG, C.CNMV_STS_CD MVMT_STS_CD, C.BKG_NO" ).append("\n"); 
		query.append("FROM BKG_CONTAINER C, BKG_BOOKING B" ).append("\n"); 
		query.append("WHERE C.BKG_NO IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT BV.BKG_NO" ).append("\n"); 
		query.append("FROM BKG_VVD BV2, BKG_VVD BV" ).append("\n"); 
		query.append("WHERE  BV.VSL_CD = SUBSTR(@[vls_cd], 0,4)" ).append("\n"); 
		query.append("AND BV.SKD_VOY_NO = SUBSTR(@[vls_cd], 5,4)" ).append("\n"); 
		query.append("AND BV.SKD_DIR_CD = SUBSTR(@[vls_cd], 9,1)" ).append("\n"); 
		query.append("AND BV.POD_CD = SUBSTR(@[pol_cd], 0, 5)" ).append("\n"); 
		query.append("AND BV2.BKG_NO(+) = BV.BKG_NO" ).append("\n"); 
		query.append("AND	ASCII(BV2.VSL_PRE_PST_CD(+)) * 10 + TO_NUMBER(BV2.VSL_SEQ(+))" ).append("\n"); 
		query.append("< ASCII(BV.VSL_PRE_PST_CD) * 10 + TO_NUMBER(BV.VSL_SEQ)" ).append("\n"); 
		query.append("#if (${locl_type} != '')" ).append("\n"); 
		query.append("AND DECODE (BV2.VSL_PRE_PST_CD, NULL, 'N', 'Y') IN (@[locl_type])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND C.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND B.BKG_STS_CD NOT IN ('X', 'S')" ).append("\n"); 
		query.append(") A," ).append("\n"); 
		query.append("#if (${mv_type} == '')" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A.CNTR_NO, A.CNTR_TPSZ_CD, A.FULL_FG, A.MVMT_STS_CD, A.MVMT_INP_TP_CD BKG_NO" ).append("\n"); 
		query.append("FROM (SELECT CNTR_NO, CNTR_TPSZ_CD," ).append("\n"); 
		query.append("DECODE (BKG_CGO_TP_CD, 'P', 'M', 'F') FULL_FG, MVMT_STS_CD," ).append("\n"); 
		query.append("MVMT_INP_TP_CD, BKG_NO" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("WHERE CRNT_VSL_CD = SUBSTR(@[vls_cd], 0,4)" ).append("\n"); 
		query.append("AND CRNT_SKD_VOY_NO = SUBSTR(@[vls_cd], 5,4)" ).append("\n"); 
		query.append("AND CRNT_SKD_DIR_CD = SUBSTR(@[vls_cd], 9,1)" ).append("\n"); 
		query.append("#if (${cgo_type} != '')" ).append("\n"); 
		query.append("AND B.BKG_CGO_TP_CD = @[cgo_type]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND MVMT_STS_CD <> 'VD') A," ).append("\n"); 
		query.append("(SELECT BV.BKG_NO" ).append("\n"); 
		query.append("FROM BKG_VVD BV2, BKG_VVD BV" ).append("\n"); 
		query.append("WHERE BV.VSL_CD = SUBSTR(@[vls_cd], 0,4)" ).append("\n"); 
		query.append("AND BV.SKD_VOY_NO = SUBSTR(@[vls_cd], 5,4)" ).append("\n"); 
		query.append("AND BV.SKD_DIR_CD = SUBSTR(@[vls_cd], 9,1)" ).append("\n"); 
		query.append("AND BV.POD_CD = SUBSTR(@[pol_cd], 0, 5)" ).append("\n"); 
		query.append("AND BV2.BKG_NO(+) = BV.BKG_NO" ).append("\n"); 
		query.append("AND ASCII (BV2.VSL_PRE_PST_CD(+)) * 10 + TO_NUMBER (BV2.VSL_SEQ(+)) <" ).append("\n"); 
		query.append("ASCII (BV.VSL_PRE_PST_CD) * 10" ).append("\n"); 
		query.append("+ TO_NUMBER (BV.VSL_SEQ)" ).append("\n"); 
		query.append("#if (${locl_type} != '')" ).append("\n"); 
		query.append("AND DECODE (BV2.VSL_PRE_PST_CD, NULL, 'N', 'Y') IN (@[locl_type])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT CNTR_REF_NO CNTR_NO, ISM_CNTR_TPSZ_CD CNTR_TPSZ_CD, DECODE(FULL_MTY_CD, 'E', 'M', 'F') FULL_FG, 'VD' MVMT_STS_CD, '' BKG_NO" ).append("\n"); 
		query.append("FROM OPF_BAY_PLN_LDIS" ).append("\n"); 
		query.append("WHERE VSL_CD = SUBSTR(@[vls_cd], 0,4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[vls_cd], 5,4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[vls_cd], 9,1)" ).append("\n"); 
		query.append("AND POD_CD = SUBSTR(@[pol_cd], 0, 5)" ).append("\n"); 
		query.append("AND LODG_DCHG_IND_CD = 'C'" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("AND A.MVMT_STS_CD = B.MVMT_STS_CD" ).append("\n"); 
		query.append("#elseif (${flgrslt} == 'RD')" ).append("\n"); 
		query.append("SELECT COUNT(1) AS MAT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT C.CNTR_NO, C.CNTR_TPSZ_CD, DECODE(B.BKG_CGO_TP_CD, 'P', 'M', 'F') FULL_FG, C.CNMV_STS_CD MVMT_STS_CD, C.BKG_NO" ).append("\n"); 
		query.append("FROM BKG_CONTAINER C, BKG_BOOKING B" ).append("\n"); 
		query.append("WHERE C.BKG_NO IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT BV.BKG_NO" ).append("\n"); 
		query.append("FROM BKG_VVD BV2, BKG_VVD BV" ).append("\n"); 
		query.append("WHERE  BV.VSL_CD = SUBSTR(@[vls_cd], 0,4)" ).append("\n"); 
		query.append("AND BV.SKD_VOY_NO = SUBSTR(@[vls_cd], 5,4)" ).append("\n"); 
		query.append("AND BV.SKD_DIR_CD = SUBSTR(@[vls_cd], 9,1)" ).append("\n"); 
		query.append("AND BV.POD_CD = SUBSTR(@[pol_cd], 0, 5)" ).append("\n"); 
		query.append("AND BV2.BKG_NO(+) = BV.BKG_NO" ).append("\n"); 
		query.append("AND	ASCII(BV2.VSL_PRE_PST_CD(+)) * 10 + TO_NUMBER(BV2.VSL_SEQ(+))" ).append("\n"); 
		query.append("< ASCII(BV.VSL_PRE_PST_CD) * 10 + TO_NUMBER(BV.VSL_SEQ)" ).append("\n"); 
		query.append("#if (${locl_type} != '')" ).append("\n"); 
		query.append("AND DECODE (BV2.VSL_PRE_PST_CD, NULL, 'N', 'Y') IN (@[locl_type])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND C.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND B.BKG_STS_CD NOT IN ('X', 'S')" ).append("\n"); 
		query.append(") A, (" ).append("\n"); 
		query.append("SELECT A.CNTR_NO, A.CNTR_TPSZ_CD, A.FULL_FG, A.MVMT_STS_CD, A.MVMT_INP_TP_CD" ).append("\n"); 
		query.append("FROM (SELECT CNTR_NO, CNTR_TPSZ_CD," ).append("\n"); 
		query.append("DECODE (BKG_CGO_TP_CD, 'P', 'M', 'F') FULL_FG, MVMT_STS_CD," ).append("\n"); 
		query.append("MVMT_INP_TP_CD, BKG_NO" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("WHERE CRNT_VSL_CD = SUBSTR(@[vls_cd], 0,4)" ).append("\n"); 
		query.append("AND CRNT_SKD_VOY_NO = SUBSTR(@[vls_cd], 5,4)" ).append("\n"); 
		query.append("AND CRNT_SKD_DIR_CD = SUBSTR(@[vls_cd], 9,1)" ).append("\n"); 
		query.append("AND MVMT_STS_CD = 'VD') A," ).append("\n"); 
		query.append("(SELECT BV.BKG_NO" ).append("\n"); 
		query.append("FROM BKG_VVD BV2, BKG_VVD BV" ).append("\n"); 
		query.append("WHERE BV.VSL_CD = SUBSTR(@[vls_cd], 0,4)" ).append("\n"); 
		query.append("AND BV.SKD_VOY_NO = SUBSTR(@[vls_cd], 5,4)" ).append("\n"); 
		query.append("AND BV.SKD_DIR_CD = SUBSTR(@[vls_cd], 9,1)" ).append("\n"); 
		query.append("AND BV.POD_CD = SUBSTR(@[pol_cd], 0, 5)" ).append("\n"); 
		query.append("AND BV2.BKG_NO(+) = BV.BKG_NO" ).append("\n"); 
		query.append("AND ASCII (BV2.VSL_PRE_PST_CD(+)) * 10 + TO_NUMBER (BV2.VSL_SEQ(+)) <" ).append("\n"); 
		query.append("ASCII (BV.VSL_PRE_PST_CD) * 10" ).append("\n"); 
		query.append("+ TO_NUMBER (BV.VSL_SEQ)" ).append("\n"); 
		query.append("#if (${locl_type} != '')" ).append("\n"); 
		query.append("AND DECODE (BV2.VSL_PRE_PST_CD, NULL, 'N', 'Y') IN (@[locl_type])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("AND A.MVMT_STS_CD = B.MVMT_STS_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}