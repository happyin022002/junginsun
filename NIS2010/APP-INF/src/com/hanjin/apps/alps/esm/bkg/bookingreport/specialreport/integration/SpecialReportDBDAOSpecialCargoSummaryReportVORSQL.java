/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SpecialReportDBDAOSpecialCargoSummaryReportVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.17
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2014.04.17 김보배
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.specialreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialReportDBDAOSpecialCargoSummaryReportVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public SpecialReportDBDAOSpecialCargoSummaryReportVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_staff",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_apro_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("zone_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.specialreport.integration").append("\n"); 
		query.append("FileName : SpecialReportDBDAOSpecialCargoSummaryReportVORSQL").append("\n"); 
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
		query.append("SELECT * FROM (" ).append("\n"); 
		query.append("#if (${chk_l_type} == 'Y'  || (${chk_l_type} == '' && ${chk_t_type} == '') )" ).append("\n"); 
		query.append("----------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("--1.Local" ).append("\n"); 
		query.append("SELECT DISTINCT BK.BKG_NO" ).append("\n"); 
		query.append("               ,NVL(LOC.UN_LOC_CD,BV.POD_CD) POD_CD" ).append("\n"); 
		query.append("               ,BK.DEL_CD" ).append("\n"); 
		query.append("               ,BK.BKG_STS_CD" ).append("\n"); 
		query.append("               ,BV.VSL_CD || BV.SKD_VOY_NO || BV.SKD_DIR_CD VVD_CD" ).append("\n"); 
		query.append("               ,BV.VSL_CD" ).append("\n"); 
		query.append("               ,BV.SKD_VOY_NO" ).append("\n"); 
		query.append("               ,BV.SKD_DIR_CD" ).append("\n"); 
		query.append("               --,'ls_zone' ZONE  --O: OCEAN,I: INTERPORT" ).append("\n"); 
		query.append("               ,@[spcl_cgo_apro_cd]   NG   --Non Approval & container match" ).append("\n"); 
		query.append("               ,VPS.CLPT_IND_SEQ" ).append("\n"); 
		query.append("               --,BKG.POL_CD" ).append("\n"); 
		query.append("               ,'L'   TS    --T이면 TS" ).append("\n"); 
		query.append("               ,BK.DOC_USR_ID" ).append("\n"); 
		query.append("               ,BK.POR_CD" ).append("\n"); 
		query.append("               ,BK.POL_CD" ).append("\n"); 
		query.append("--               ,BK.POD_CD" ).append("\n"); 
		query.append("--               ,BK.DEL_CD" ).append("\n"); 
		query.append("               ,BK.POR_NOD_CD" ).append("\n"); 
		query.append("               ,BK.POL_NOD_CD" ).append("\n"); 
		query.append("               ,BK.POD_NOD_CD" ).append("\n"); 
		query.append("               ,BK.DEL_NOD_CD" ).append("\n"); 
		query.append("               ,BK.BKG_OFC_CD" ).append("\n"); 
		query.append("--               ,BK.DOC_USR_ID" ).append("\n"); 
		query.append("               ,BK.OB_SREP_CD" ).append("\n"); 
		query.append("--               ,BK.BKG_STS_CD" ).append("\n"); 
		query.append("--               ,BV.POL_CD" ).append("\n"); 
		query.append("               ,SP.CNTR_NO" ).append("\n"); 
		query.append("               ,SP.SPCL_CGO_TYPE" ).append("\n"); 
		query.append("               ,SP.SPCL_CNTR_SEQ" ).append("\n"); 
		query.append("               ,SP.SPCL_CGO_SEQ" ).append("\n"); 
		query.append("               ,SP.AUTH_RESULT_T" ).append("\n"); 
		query.append("               ,SP.TP_SZ" ).append("\n"); 
		query.append("               ,SP.WGT" ).append("\n"); 
		query.append("               ,SP.DG_CLASS" ).append("\n"); 
		query.append("               ,SP.OVER_SIZE" ).append("\n"); 
		query.append("               ,SP.UN_NO" ).append("\n"); 
		query.append("--               ,SP.DG_APPR_REF" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("               ,(SELECT /*+ INDEX_DESC(A XPKSCG_AUTHORIZATION) */ A.APRO_REF_NO " ).append("\n"); 
		query.append("                  FROM SCG_AUTHORIZATION A" ).append("\n"); 
		query.append("                 WHERE SPCL_CGO_CATE_CD = 'DG'" ).append("\n"); 
		query.append("                   AND A.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                   AND A.VSL_PRE_PST_CD||A.VSL_SEQ IN ( SELECT MIN(VSL_PRE_PST_CD||VSL_SEQ) FROM BKG_VVD WHERE BKG_NO = A.BKG_NO )" ).append("\n"); 
		query.append("                   AND ROWNUM = 1" ).append("\n"); 
		query.append("                ) AS DG_APPR_REF" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("               ,SP.MRN_POLUT_FLG" ).append("\n"); 
		query.append("               ,SP.CDO_TEMP" ).append("\n"); 
		query.append("               ,SP.VENT" ).append("\n"); 
		query.append("               ,BK.STWG_CD STOW" ).append("\n"); 
		query.append("               , DECODE(SUBSTR(MC1.SCONTI_CD,1,1), SUBSTR(MC2.SCONTI_CD,1,1), 'I', 'O') ZONE_CODE  --ZONE O: OCEAN,I: INTERPORT" ).append("\n"); 
		query.append("               ,(CASE WHEN   AUTH_RESULT_T = 'N' THEN ''" ).append("\n"); 
		query.append("                      WHEN   BV.VSL_CD || BV.SKD_VOY_NO || BV.SKD_DIR_CD =" ).append("\n"); 
		query.append("                             (SELECT SPC.VSL_CD || SPC.SKD_VOY_NO || SPC.SKD_DIR_CD FROM   SCG_VVD_APRO_RQST SPC" ).append("\n"); 
		query.append("                              WHERE  SPC.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                              AND    SPC.POL_CD = BK.POL_CD" ).append("\n"); 
		query.append("                              AND    SPC.SPCL_CGO_APRO_RQST_SEQ = SP.MAX_SPC_AUTH_SEQ" ).append("\n"); 
		query.append("                              AND    ROWNUM =1)" ).append("\n"); 
		query.append("                      THEN   'U' ELSE 'M' END)   UM" ).append("\n"); 
		query.append("               ,'' BKG_STAFF_TYPE" ).append("\n"); 
		query.append("               ,BK.DOC_USR_ID BKG_STAFF" ).append("\n"); 
		query.append("               ,'' SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append("               ,'' CHK_L_TYPE" ).append("\n"); 
		query.append("               ,'' CHK_T_TYPE" ).append("\n"); 
		query.append("FROM   BKG_BOOKING BK" ).append("\n"); 
		query.append(",      BKG_VVD BV" ).append("\n"); 
		query.append(",      VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append(",      MDM_LOCATION LOC" ).append("\n"); 
		query.append(",      COM_USER BC    --SELECT * FROM COM_USER" ).append("\n"); 
		query.append(",      BKG_SPCL_V SP    --SELECT * FROM BKG_SPCL_V" ).append("\n"); 
		query.append(",      MDM_COUNTRY     MC1" ).append("\n"); 
		query.append(",      MDM_COUNTRY     MC2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE  BK.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("AND    BK.DOC_USR_ID = BC.USR_ID(+)" ).append("\n"); 
		query.append("AND    BK.BKG_NO = SP.BKG_NO" ).append("\n"); 
		query.append("--AND    BK.DCGO_FLG ||  BK.RC_FLG || BK.AWK_CGO_FLG || BK.BB_CGO_FLG != 'NNNN'" ).append("\n"); 
		query.append("AND    BV.POD_CD = LOC.LOC_CD" ).append("\n"); 
		query.append("AND    BK.POL_CD = BV.POL_CD" ).append("\n"); 
		query.append("AND    VPS.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("AND    BV.POD_CD = VPS.VPS_PORT_CD" ).append("\n"); 
		query.append("--AND    BK.BKG_NO IN ('CHIY3160011','PHXZ2190246','PHXZ2190251','KORZ1025122','BREZ2060025','PHXZ2190251','PHXZ2190246','HAMZ1089827','BREZ1090002','CANZ6035006')" ).append("\n"); 
		query.append("AND    MC1.CNT_CD(+) = SUBSTR(BK.POR_CD, 1, 2)" ).append("\n"); 
		query.append("AND    MC2.CNT_CD(+) = SUBSTR(BK.DEL_CD, 1, 2)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("AND     BV.VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("AND     BV.SKD_VOY_NO =  SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("AND     BV.SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("AND     VPS.VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("AND     VPS.SKD_VOY_NO =  SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("AND     VPS.SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${zone_code} != '')" ).append("\n"); 
		query.append("AND    DECODE(SUBSTR(MC1.SCONTI_CD,1,1), SUBSTR(MC2.SCONTI_CD,1,1), 'I', 'O') = @[zone_code] -- ZONE 조건이 있을시" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_no} != '')" ).append("\n"); 
		query.append("AND    BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${por_cd} != '')" ).append("\n"); 
		query.append("AND    BK.POR_CD = @[por_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${por_nod_cd} != '')" ).append("\n"); 
		query.append("AND    SUBSTR(BK.POR_NOD_CD,6,2) = @[por_nod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("AND    BK.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_nod_cd} != '')" ).append("\n"); 
		query.append("AND    SUBSTR(BK.POL_NOD_CD,6,2) = @[pol_nod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("AND    BK.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pod_nod_cd} != '')" ).append("\n"); 
		query.append("AND    SUBSTR(BK.POD_NOD_CD,6,2) = @[pod_nod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${del_cd} != '')" ).append("\n"); 
		query.append("AND    BK.DEL_CD = @[del_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${del_nod_cd} != '')" ).append("\n"); 
		query.append("AND    SUBSTR(BK.DEL_NOD_CD,6,2) = @[del_nod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("AND    BK.BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ob_srep_cd} != '')" ).append("\n"); 
		query.append("AND    BK.OB_SREP_CD = @[ob_srep_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_sts_cd} != '')" ).append("\n"); 
		query.append("AND   BK.BKG_STS_CD = @[bkg_sts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    BK.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_staff} != '')" ).append("\n"); 
		query.append("  #if (${bkg_staff_type} == 'ID')" ).append("\n"); 
		query.append("AND    BK.DOC_USR_ID = @[bkg_staff]" ).append("\n"); 
		query.append("  #elseif (${bkg_staff_type} == 'NAME')" ).append("\n"); 
		query.append("AND    BC.USR_NM LIKE TRIM(@[bkg_staff]) || '%'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${spcl_cgo_type} != '')" ).append("\n"); 
		query.append("#if (${spcl_cgo_type} == 'DG')" ).append("\n"); 
		query.append("AND    BK.DCGO_FLG = 'Y'" ).append("\n"); 
		query.append("#elseif (${spcl_cgo_type} == 'RF')" ).append("\n"); 
		query.append("AND    BK.RC_FLG = 'Y'" ).append("\n"); 
		query.append("#elseif (${spcl_cgo_type} == 'AK')" ).append("\n"); 
		query.append("AND    BK.AWK_CGO_FLG  = 'Y'" ).append("\n"); 
		query.append("#elseif (${spcl_cgo_type} == 'BB')" ).append("\n"); 
		query.append("AND    BK.BB_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${spcl_cgo_apro_cd} == 'Y')" ).append("\n"); 
		query.append("/** Non Approval & container match check시**/" ).append("\n"); 
		query.append("AND (SP.CNTR_NO IS NULL" ).append("\n"); 
		query.append("  OR (CASE WHEN SP.SPCL_CGO_TYPE = 'DG' AND SP.DG_APPR_REF IS NULL" ).append("\n"); 
		query.append("              THEN 'N' ELSE 'Y' END) = 'N')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("----------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${chk_t_type} == 'Y' || (${chk_l_type} == '' && ${chk_t_type} == '') )" ).append("\n"); 
		query.append("--2.TS" ).append("\n"); 
		query.append("  #if (${chk_l_type} == 'Y' || (${chk_l_type} == '' && ${chk_t_type} == '') )" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("----------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT DISTINCT BK.BKG_NO" ).append("\n"); 
		query.append("               ,NVL(LOC.UN_LOC_CD,BV.POD_CD) POD_CD" ).append("\n"); 
		query.append("               ,BK.DEL_CD" ).append("\n"); 
		query.append("               ,BK.BKG_STS_CD" ).append("\n"); 
		query.append("               ,BV.VSL_CD || BV.SKD_VOY_NO || BV.SKD_DIR_CD VVD_CD" ).append("\n"); 
		query.append("               ,BV.VSL_CD" ).append("\n"); 
		query.append("               ,BV.SKD_VOY_NO" ).append("\n"); 
		query.append("               ,BV.SKD_DIR_CD" ).append("\n"); 
		query.append("               --,'ls_zone' ZONE  --O: OCEAN,I: INTERPORT" ).append("\n"); 
		query.append("               ,@[spcl_cgo_apro_cd]   NG   --Non Approval & container match" ).append("\n"); 
		query.append("               ,VPS.CLPT_IND_SEQ" ).append("\n"); 
		query.append("               --,BKG.POL_CD" ).append("\n"); 
		query.append("               ,'TS'   TS    --T이면 TS" ).append("\n"); 
		query.append("               ,BK.DOC_USR_ID" ).append("\n"); 
		query.append("               ,BK.POR_CD" ).append("\n"); 
		query.append("               ,BK.POL_CD" ).append("\n"); 
		query.append("--               ,BK.POD_CD" ).append("\n"); 
		query.append("--               ,BK.DEL_CD" ).append("\n"); 
		query.append("               ,BK.POR_NOD_CD" ).append("\n"); 
		query.append("               ,BK.POL_NOD_CD" ).append("\n"); 
		query.append("               ,BK.POD_NOD_CD" ).append("\n"); 
		query.append("               ,BK.DEL_NOD_CD" ).append("\n"); 
		query.append("               ,BK.BKG_OFC_CD" ).append("\n"); 
		query.append("--               ,BK.DOC_USR_ID" ).append("\n"); 
		query.append("               ,BK.OB_SREP_CD" ).append("\n"); 
		query.append("--               ,BK.BKG_STS_CD" ).append("\n"); 
		query.append("--               ,BV.POL_CD" ).append("\n"); 
		query.append("               ,SP.CNTR_NO" ).append("\n"); 
		query.append("               ,SP.SPCL_CGO_TYPE" ).append("\n"); 
		query.append("               ,SP.SPCL_CNTR_SEQ" ).append("\n"); 
		query.append("               ,SP.SPCL_CGO_SEQ" ).append("\n"); 
		query.append("               ,SP.AUTH_RESULT_T" ).append("\n"); 
		query.append("               ,SP.TP_SZ" ).append("\n"); 
		query.append("               ,SP.WGT" ).append("\n"); 
		query.append("               ,SP.DG_CLASS" ).append("\n"); 
		query.append("               ,SP.OVER_SIZE" ).append("\n"); 
		query.append("               ,SP.UN_NO" ).append("\n"); 
		query.append("--               ,SP.DG_APPR_REF" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("               ,(SELECT /*+ INDEX_DESC(A XPKSCG_AUTHORIZATION) */ A.APRO_REF_NO " ).append("\n"); 
		query.append("                  FROM SCG_AUTHORIZATION A" ).append("\n"); 
		query.append("                 WHERE SPCL_CGO_CATE_CD = 'DG'" ).append("\n"); 
		query.append("                   AND A.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                   AND A.VSL_PRE_PST_CD||A.VSL_SEQ IN ( SELECT MIN(VSL_PRE_PST_CD||VSL_SEQ) FROM BKG_VVD WHERE BKG_NO = A.BKG_NO )" ).append("\n"); 
		query.append("                   AND ROWNUM = 1" ).append("\n"); 
		query.append("                ) AS DG_APPR_REF" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("               ,SP.MRN_POLUT_FLG" ).append("\n"); 
		query.append("               ,SP.CDO_TEMP" ).append("\n"); 
		query.append("               ,SP.VENT" ).append("\n"); 
		query.append("               ,BK.STWG_CD STOW" ).append("\n"); 
		query.append("               , DECODE(SUBSTR(MC1.SCONTI_CD,1,1), SUBSTR(MC2.SCONTI_CD,1,1), 'I', 'O') ZONE_CODE  --ZONE O: OCEAN,I: INTERPORT" ).append("\n"); 
		query.append("               ,(CASE WHEN   AUTH_RESULT_T = 'N' THEN ''" ).append("\n"); 
		query.append("                      WHEN   BV.VSL_CD || BV.SKD_VOY_NO || BV.SKD_DIR_CD =" ).append("\n"); 
		query.append("                             (SELECT SPC.VSL_CD || SPC.SKD_VOY_NO || SPC.SKD_DIR_CD FROM   SCG_VVD_APRO_RQST SPC" ).append("\n"); 
		query.append("                              WHERE  SPC.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                              AND    SPC.POL_CD = BK.POL_CD" ).append("\n"); 
		query.append("                              AND    SPC.SPCL_CGO_APRO_RQST_SEQ = SP.MAX_SPC_AUTH_SEQ" ).append("\n"); 
		query.append("                              AND    ROWNUM =1)" ).append("\n"); 
		query.append("                      THEN   'U' ELSE 'M' END)   UM" ).append("\n"); 
		query.append("               ,'' BKG_STAFF_TYPE" ).append("\n"); 
		query.append("               ,BK.DOC_USR_ID BKG_STAFF" ).append("\n"); 
		query.append("               ,'' SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append("               ,'' CHK_L_TYPE" ).append("\n"); 
		query.append("               ,'' CHK_T_TYPE" ).append("\n"); 
		query.append("FROM   BKG_BOOKING BK" ).append("\n"); 
		query.append(",      (SELECT  BOOKING.BKG_NO, BKG_VVD.VSL_CD, BKG_VVD.SKD_VOY_NO, BKG_VVD.SKD_DIR_CD, BKG_VVD.POD_CD" ).append("\n"); 
		query.append("        FROM   BKG_BOOKING   BOOKING" ).append("\n"); 
		query.append("              ,BKG_VVD     --SELECT * FROM BKG_VVD" ).append("\n"); 
		query.append("              ,(SELECT ROWID RID, BKG_VVD.BKG_NO,  BKG_VVD.POL_CD,BKG_VVD.POL_YD_CD, BKG_VVD.POD_CD" ).append("\n"); 
		query.append("                FROM   BKG_VVD" ).append("\n"); 
		query.append("                WHERE  1=1" ).append("\n"); 
		query.append("#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("                AND     BKG_VVD.VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("                AND     BKG_VVD.SKD_VOY_NO =  SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("                AND     BKG_VVD.SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                ) BKG_VVD2" ).append("\n"); 
		query.append("        WHERE  BOOKING.BKG_NO = BKG_VVD2.BKG_NO" ).append("\n"); 
		query.append("        AND    BOOKING.POD_CD <> @[pol_cd]" ).append("\n"); 
		query.append("        AND    BKG_VVD.BKG_NO = BKG_VVD2.BKG_NO" ).append("\n"); 
		query.append("        AND    BKG_VVD.POD_CD = @[pol_cd]" ).append("\n"); 
		query.append("        AND    BKG_VVD2.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_nod_cd} != '')" ).append("\n"); 
		query.append("    AND    SUBSTR(BKG_VVD.POD_YD_CD,6,2) = @[pol_nod_cd]" ).append("\n"); 
		query.append("    AND    SUBSTR(BKG_VVD2.POL_YD_CD,6,2) = @[pol_nod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        AND    BKG_VVD.VSL_PRE_PST_CD || BKG_VVD.VSL_SEQ < (SELECT BV.VSL_PRE_PST_CD || BV.VSL_SEQ --BV.BV_IND || BV.BV_SEQ" ).append("\n"); 
		query.append("                                                   FROM   BKG_VVD BV" ).append("\n"); 
		query.append("                                                   WHERE  BV.ROWID = BKG_VVD2.RID" ).append("\n"); 
		query.append("                                                     AND ROWNUM = 1)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ) BK2" ).append("\n"); 
		query.append(",      BKG_VVD BV" ).append("\n"); 
		query.append("      ,VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("      ,MDM_LOCATION LOC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",      COM_USER BC    --SELECT * FROM COM_USER" ).append("\n"); 
		query.append(",      BKG_SPCL_V SP    --SELECT * FROM BKG_SPCL_V" ).append("\n"); 
		query.append(",      MDM_COUNTRY     MC1" ).append("\n"); 
		query.append(",      MDM_COUNTRY     MC2" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND     BK.BKG_NO = BK2.BKG_NO" ).append("\n"); 
		query.append("AND     BK.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("AND     BK.DOC_USR_ID = BC.USR_ID(+)" ).append("\n"); 
		query.append("AND     BK.BKG_NO = SP.BKG_NO" ).append("\n"); 
		query.append("--AND    BK.DCGO_FLG ||  BK.RC_FLG || BK.AWK_CGO_FLG || BK.BB_CGO_FLG != 'NNNN'" ).append("\n"); 
		query.append("AND    BV.POD_CD = LOC.LOC_CD" ).append("\n"); 
		query.append("AND    VPS.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("AND    BV.POD_CD = VPS.VPS_PORT_CD" ).append("\n"); 
		query.append("--AND    BK.BKG_NO IN ('CHIY3160011','PHXZ2190246','PHXZ2190251','KORZ1025122','BREZ2060025','PHXZ2190251','PHXZ2190246','HAMZ1089827','BREZ1090002','CANZ6035006')" ).append("\n"); 
		query.append("AND    MC1.CNT_CD(+) = SUBSTR(BK.POR_CD, 1, 2)" ).append("\n"); 
		query.append("AND    MC2.CNT_CD(+) = SUBSTR(BK.DEL_CD, 1, 2)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("AND     BV.VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("AND     BV.SKD_VOY_NO =  SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("AND     BV.SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("AND     VPS.VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("AND     VPS.SKD_VOY_NO =  SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("AND     VPS.SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${zone_code} != '')" ).append("\n"); 
		query.append("AND    DECODE(SUBSTR(MC1.SCONTI_CD,1,1), SUBSTR(MC2.SCONTI_CD,1,1), 'I', 'O') = @[zone_code] -- ZONE 조건이 있을시" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_no} != '')" ).append("\n"); 
		query.append("AND    BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${por_cd} != '')" ).append("\n"); 
		query.append("AND    BK.POR_CD = @[por_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${por_nod_cd} != '')" ).append("\n"); 
		query.append("AND    SUBSTR(BK.POR_NOD_CD,6,2) = @[por_nod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("AND    BK.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pod_nod_cd} != '')" ).append("\n"); 
		query.append("AND    SUBSTR(BK.POD_NOD_CD,6,2) = @[pod_nod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${del_cd} != '')" ).append("\n"); 
		query.append("AND    BK.DEL_CD = @[del_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${del_nod_cd} != '')" ).append("\n"); 
		query.append("AND    SUBSTR(BK.DEL_NOD_CD,6,2) = @[del_nod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("AND    BK.BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ob_srep_cd} != '')" ).append("\n"); 
		query.append("AND    BK.OB_SREP_CD = @[ob_srep_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_sts_cd} != '')" ).append("\n"); 
		query.append("AND   BK.BKG_STS_CD = @[bkg_sts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    BK.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_staff} != '')" ).append("\n"); 
		query.append("  #if (${bkg_staff_type} == 'ID')" ).append("\n"); 
		query.append("AND    BK.DOC_USR_ID = @[bkg_staff]" ).append("\n"); 
		query.append("  #elseif (${bkg_staff_type} == 'NAME')" ).append("\n"); 
		query.append("AND    BC.USR_NM LIKE TRIM(@[bkg_staff]) || '%'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${spcl_cgo_type} != '')" ).append("\n"); 
		query.append("#if (${spcl_cgo_type} == 'DG')" ).append("\n"); 
		query.append("AND    BK.DCGO_FLG = 'Y'" ).append("\n"); 
		query.append("#elseif (${spcl_cgo_type} == 'RF')" ).append("\n"); 
		query.append("AND    BK.RC_FLG = 'Y'" ).append("\n"); 
		query.append("#elseif (${spcl_cgo_type} == 'AK')" ).append("\n"); 
		query.append("AND    BK.AWK_CGO_FLG  = 'Y'" ).append("\n"); 
		query.append("#elseif (${spcl_cgo_type} == 'BB')" ).append("\n"); 
		query.append("AND    BK.BB_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${spcl_cgo_apro_cd} == 'Y')" ).append("\n"); 
		query.append("/** Non Approval & container match check시**/" ).append("\n"); 
		query.append("AND (SP.CNTR_NO IS NULL" ).append("\n"); 
		query.append("  OR (CASE WHEN SP.SPCL_CGO_TYPE = 'DG' AND SP.DG_APPR_REF IS NULL" ).append("\n"); 
		query.append("              THEN 'N' ELSE 'Y' END) = 'N')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("----------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY BKG_NO" ).append("\n"); 

	}
}