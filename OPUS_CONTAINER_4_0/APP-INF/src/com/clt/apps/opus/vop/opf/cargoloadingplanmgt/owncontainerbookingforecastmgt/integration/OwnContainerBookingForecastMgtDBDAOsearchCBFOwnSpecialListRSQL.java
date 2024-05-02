/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOsearchCBFOwnSpecialListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.07
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2010.05.07 김현욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Hyun Uk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnContainerBookingForecastMgtDBDAOsearchCBFOwnSpecialListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCBFOwnSpecialList
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOsearchCBFOwnSpecialListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("awk_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bb_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mlb_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stwg_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("qty1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qty3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qty2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qty5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qty4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration").append("\n"); 
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOsearchCBFOwnSpecialListRSQL").append("\n"); 
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
		query.append("SELECT DECODE(B.BKG_SHPR_OWNR_FLG, 'Y', A.BKG_NO, A.PRNR_BKG_REF_NO) BKG_NO," ).append("\n"); 
		query.append("DECODE(B.BKG_SHPR_OWNR_FLG, 'Y', A.CNTR_NO, A.PRNR_CNTR_REF_NO) CNTR_NO," ).append("\n"); 
		query.append("A.POD_CD," ).append("\n"); 
		query.append("A.MLB_CD," ).append("\n"); 
		query.append("A.CRR_CD," ).append("\n"); 
		query.append("A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("A.CBF_SPCL_CGO_CATE_CD," ).append("\n"); 
		query.append("A.DCGO_FLG," ).append("\n"); 
		query.append("A.RC_FLG," ).append("\n"); 
		query.append("A.AWK_CGO_FLG," ).append("\n"); 
		query.append("A.BB_CGO_FLG," ).append("\n"); 
		query.append("A.STWG_CGO_FLG," ).append("\n"); 
		query.append("A.CNTR_SEQ," ).append("\n"); 
		query.append("A.CGO_SEQ," ).append("\n"); 
		query.append("A.CNTR_GRS_WGT," ).append("\n"); 
		query.append("A.CGO_GRS_WGT," ).append("\n"); 
		query.append("A.IMDG_CLSS_CD," ).append("\n"); 
		query.append("A.IMDG_UN_NO," ).append("\n"); 
		query.append("A.PRP_SHP_NM," ).append("\n"); 
		query.append("A.HZD_DESC," ).append("\n"); 
		query.append("S.IMDG_SUBS_RSK_LBL_CD," ).append("\n"); 
		query.append("A.IMDG_MRN_POLUT_CD," ).append("\n"); 
		query.append("DECODE(A.PCK_GRP_CD, '1', 'I', '2', 'II', '3', 'III', '') PCK_GRP_CD," ).append("\n"); 
		query.append("A.LMT_QTY_FLG," ).append("\n"); 
		query.append("A.EXPT_QTY_FLG," ).append("\n"); 
		query.append("DECODE(A.FDO_TEMP, '0', '', A.FDO_TEMP) FDO_TEMP," ).append("\n"); 
		query.append("DECODE(A.CDO_TEMP, '0', '', A.CDO_TEMP) CDO_TEMP," ).append("\n"); 
		query.append("A.CBF_CMDT_NM," ).append("\n"); 
		query.append("DECODE(A.DIM_LEN, 0, '', A.DIM_LEN) DIM_LEN," ).append("\n"); 
		query.append("DECODE(A.DIM_WDT, 0, '', A.DIM_WDT) DIM_WDT," ).append("\n"); 
		query.append("DECODE(A.DIM_HGT, 0, '', A.DIM_HGT) DIM_HGT," ).append("\n"); 
		query.append("DECODE(A.FWRD_OVR_DIM_LEN, 0, '', A.FWRD_OVR_DIM_LEN)   OVR_FWD," ).append("\n"); 
		query.append("DECODE(A.BKWD_OVR_DIM_LEN, 0, '', A.BKWD_OVR_DIM_LEN)   OVR_AFT," ).append("\n"); 
		query.append("DECODE(A.LF_SD_OVR_DIM_LEN, 0, '', A.LF_SD_OVR_DIM_LEN) OVR_LFT," ).append("\n"); 
		query.append("DECODE(A.RT_SD_OVR_DIM_LEN, 0, '', A.RT_SD_OVR_DIM_LEN) OVR_RGT," ).append("\n"); 
		query.append("DECODE(A.HGT_OVR_DIM_LEN, 0, '', A.HGT_OVR_DIM_LEN)     OVR_HGT," ).append("\n"); 
		query.append("A.CRN_PST_STS_CD," ).append("\n"); 
		query.append("A.STWG_CD," ).append("\n"); 
		query.append("DECODE(A.SPCL_CGO_AUTH_FLG,'N','',A.SPCL_CGO_AUTH_FLG) SPCL_CGO_AUTH_FLG," ).append("\n"); 
		query.append("A.APRO_REF_NO," ).append("\n"); 
		query.append("A.CBF_RMK," ).append("\n"); 
		query.append("A.CBF_DP_CD," ).append("\n"); 
		query.append("B.UPD_USR_ID," ).append("\n"); 
		query.append("B.UPD_DT," ).append("\n"); 
		query.append("A.VSL_CD," ).append("\n"); 
		query.append("A.SKD_VOY_NO," ).append("\n"); 
		query.append("A.SKD_DIR_CD," ).append("\n"); 
		query.append("A.YD_CD," ).append("\n"); 
		query.append("A.BKG_SHPR_OWNR_FLG," ).append("\n"); 
		query.append("A.CBF_SMRY_SEQ," ).append("\n"); 
		query.append("A.SPCL_CGO_SEQ," ).append("\n"); 
		query.append("B.CBF_IND_FLG," ).append("\n"); 
		query.append("B.CBF_BKG_STS_CD," ).append("\n"); 
		query.append("'R' RD_ST" ).append("\n"); 
		query.append("FROM OPF_CGO_BKG_FCAST_CNTR     A," ).append("\n"); 
		query.append("OPF_CGO_BKG_FCAST          B," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT VSL_CD," ).append("\n"); 
		query.append("SKD_VOY_NO," ).append("\n"); 
		query.append("SKD_DIR_CD," ).append("\n"); 
		query.append("BKG_SHPR_OWNR_FLG," ).append("\n"); 
		query.append("CRR_CD," ).append("\n"); 
		query.append("YD_CD," ).append("\n"); 
		query.append("CBF_SMRY_SEQ," ).append("\n"); 
		query.append("SUBSTR(XMLAGG(XMLELEMENT(X, '/' || IMDG_SUBS_RSK_LBL_CD) ORDER BY IMDG_SUBS_RSK_LBL_CD).EXTRACT('//text()'), 2) IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("FROM OPF_CBF_CNTR_IMDG_SUBS_RSK" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("VSL_CD," ).append("\n"); 
		query.append("SKD_VOY_NO," ).append("\n"); 
		query.append("SKD_DIR_CD," ).append("\n"); 
		query.append("BKG_SHPR_OWNR_FLG," ).append("\n"); 
		query.append("CRR_CD," ).append("\n"); 
		query.append("YD_CD," ).append("\n"); 
		query.append("CBF_SMRY_SEQ" ).append("\n"); 
		query.append(") S" ).append("\n"); 
		query.append("WHERE A.VSL_CD            = @[vsl_cd]" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO        = @[skd_voy_no]" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD        = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND A.CRR_CD IN ( @[qty1], @[qty2], @[qty3], @[qty4], @[qty5] )" ).append("\n"); 
		query.append("AND A.YD_CD||A.POL_CLPT_IND_SEQ = @[yd_cd]" ).append("\n"); 
		query.append("AND B.VSL_CD            = A.VSL_CD" ).append("\n"); 
		query.append("AND B.SKD_VOY_NO        = A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND B.SKD_DIR_CD        = A.SKD_DIR_CD" ).append("\n"); 
		query.append("AND B.BKG_SHPR_OWNR_FLG = A.BKG_SHPR_OWNR_FLG" ).append("\n"); 
		query.append("AND B.CRR_CD            = A.CRR_CD" ).append("\n"); 
		query.append("AND B.YD_CD             = A.YD_CD" ).append("\n"); 
		query.append("AND B.POL_CLPT_IND_SEQ  = A.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("AND A.CBF_DP_CD         = 'S'" ).append("\n"); 
		query.append("AND A.VSL_CD            = S.VSL_CD(+)" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO        = S.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD        = S.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND A.BKG_SHPR_OWNR_FLG = S.BKG_SHPR_OWNR_FLG(+)" ).append("\n"); 
		query.append("AND A.CRR_CD            = S.CRR_CD(+)" ).append("\n"); 
		query.append("AND A.YD_CD             = S.YD_CD(+)" ).append("\n"); 
		query.append("AND A.CBF_SMRY_SEQ      = S.CBF_SMRY_SEQ(+)" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("AND A.POD_CD||A.POD_CLPT_IND_SEQ LIKE @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${mlb_cd} != '')" ).append("\n"); 
		query.append("AND A.MLB_CD LIKE @[mlb_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${all_flg} != 'Y')" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("(A.DCGO_FLG     = @[dcgo_flg])" ).append("\n"); 
		query.append("OR (A.RC_FLG       = @[rc_flg])" ).append("\n"); 
		query.append("OR (A.AWK_CGO_FLG  = @[awk_cgo_flg])" ).append("\n"); 
		query.append("OR (A.BB_CGO_FLG   = @[bb_cgo_flg])" ).append("\n"); 
		query.append("OR (A.STWG_CGO_FLG = @[stwg_cgo_flg])" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("POD_CD," ).append("\n"); 
		query.append("A.POD_CLPT_IND_SEQ," ).append("\n"); 
		query.append("MLB_CD," ).append("\n"); 
		query.append("DECODE(B.BKG_SHPR_OWNR_FLG, 'Y', A.BKG_NO, A.PRNR_BKG_REF_NO)," ).append("\n"); 
		query.append("CNTR_SEQ," ).append("\n"); 
		query.append("CGO_SEQ," ).append("\n"); 
		query.append("DECODE(B.BKG_SHPR_OWNR_FLG, 'Y', A.CNTR_NO, A.PRNR_CNTR_REF_NO)," ).append("\n"); 
		query.append("CNTR_TPSZ_CD" ).append("\n"); 

	}
}