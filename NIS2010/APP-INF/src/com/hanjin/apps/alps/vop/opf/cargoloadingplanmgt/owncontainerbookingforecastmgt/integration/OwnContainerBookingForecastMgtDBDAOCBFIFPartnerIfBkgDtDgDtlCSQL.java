/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOCBFIFPartnerIfBkgDtDgDtlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.16
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnContainerBookingForecastMgtDBDAOCBFIFPartnerIfBkgDtDgDtlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Partner CLL 의 dg co-load수신
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOCBFIFPartnerIfBkgDtDgDtlCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration").append("\n"); 
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOCBFIFPartnerIfBkgDtDgDtlCSQL").append("\n"); 
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
		query.append("INSERT INTO  OPF_CGO_BKG_FCAST_DG_DTL (" ).append("\n"); 
		query.append("VSL_CD," ).append("\n"); 
		query.append("SKD_VOY_NO," ).append("\n"); 
		query.append("SKD_DIR_CD," ).append("\n"); 
		query.append("YD_CD," ).append("\n"); 
		query.append("POL_CLPT_IND_SEQ," ).append("\n"); 
		query.append("CRR_CD," ).append("\n"); 
		query.append("POD_CD," ).append("\n"); 
		query.append("BLCK_STWG_CD," ).append("\n"); 
		query.append("CBF_SMRY_SEQ," ).append("\n"); 
		query.append("CBF_SMRY_DCGO_SEQ," ).append("\n"); 
		query.append("CNTR_TPSZ_CD," ).append("\n"); 
		query.append("IMDG_UN_NO," ).append("\n"); 
		query.append("IMDG_CLSS_CD," ).append("\n"); 
		query.append("MRN_POLUT_FLG," ).append("\n"); 
		query.append("IMDG_LMT_QTY_FLG," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT )" ).append("\n"); 
		query.append("SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD, YD_CD, POL_CLPT_IND_SEQ, CRR_CD, POD_CD, BLCK_STWG_CD," ).append("\n"); 
		query.append("       CBF_SPCL_SMRY_SEQ, CBF_SMRY_DCGO_SEQ + ROWNUM , CNTR_TPSZ_CD, IMDG_UN_NO," ).append("\n"); 
		query.append("       IMDG_CLSS_CD," ).append("\n"); 
		query.append("       MRN_POLUT_FLG," ).append("\n"); 
		query.append("       IMDG_LMT_QTY_FLG, @[cre_usr_id],SYSDATE,@[upd_usr_id],SYSDATE" ).append("\n"); 
		query.append(" FROM (" ).append("\n"); 
		query.append(" SELECT Y.VSL_CD, Y.SKD_VOY_NO, Y.SKD_DIR_CD,   Y.YD_CD, Y.POL_CLPT_IND_SEQ, " ).append("\n"); 
		query.append("       Y.CRR_CD, Y.POD_CD,     Y.BLCK_STWG_CD, Y.CBF_SPCL_SMRY_SEQ, " ).append("\n"); 
		query.append("       Y.CNTR_TPSZ_CD,         Y.IMDG_UN_NO   ,Y.IMDG_CLSS_CD," ).append("\n"); 
		query.append("       Y.MRN_POLUT_FLG ,       Y.IMDG_LMT_QTY_FLG, Y.CNTR_NO," ).append("\n"); 
		query.append("          ( SELECT NVL(MAX(CBF_SMRY_DCGO_SEQ),0) " ).append("\n"); 
		query.append("                             FROM  OPF_CGO_BKG_FCAST_DG_DTL" ).append("\n"); 
		query.append("                            WHERE  VSL_CD      =  @[vsl_cd]" ).append("\n"); 
		query.append("                              AND  SKD_VOY_NO  =  @[skd_voy_no]" ).append("\n"); 
		query.append("                              AND  SKD_DIR_CD  =  @[skd_dir_cd]" ).append("\n"); 
		query.append("                              AND  YD_CD       =  @[pol_cd]" ).append("\n"); 
		query.append("                              AND  POL_CLPT_IND_SEQ =  @[pol_clpt_ind_seq] ) AS CBF_SMRY_DCGO_SEQ" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("SELECT DISTINCT B.VSL_CD, B.SKD_VOY_NO, B.SKD_DIR_CD, B.YD_CD, B.POL_CLPT_IND_SEQ," ).append("\n"); 
		query.append("                B.CRR_CD, A.POD_CD, SUBSTR(A.POD_CD,3,3) BLCK_STWG_CD, " ).append("\n"); 
		query.append("                B.CBF_SPCL_SMRY_SEQ, " ).append("\n"); 
		query.append("                A.CNTR_TPSZ_CD, A.IMDG_UN_NO, A.IMDG_CLSS_CD, A.MRN_POLUT_FLG, A.IMDG_LMT_QTY_FLG, A.CNTR_NO" ).append("\n"); 
		query.append(" FROM OPF_PRNR_EDI_CGO_BKG_FCAST A, OPF_CGO_BKG_FCAST_SPCL_SMRY B" ).append("\n"); 
		query.append("WHERE A.VSL_CD           = B.VSL_CD" ).append("\n"); 
		query.append("  AND A.SKD_VOY_NO       = B.SKD_VOY_NO" ).append("\n"); 
		query.append("  AND A.SKD_DIR_CD       = B.SKD_DIR_CD" ).append("\n"); 
		query.append("  AND A.YD_CD            = B.YD_CD" ).append("\n"); 
		query.append("  AND A.POL_CLPT_IND_SEQ = B.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("  AND A.CRR_CD           = B.CRR_CD" ).append("\n"); 
		query.append("  AND A.EDI_BL_NO        = B.BKG_NO" ).append("\n"); 
		query.append("  AND A.VSL_CD           = @[vsl_cd]" ).append("\n"); 
		query.append("  AND A.SKD_VOY_NO       = @[skd_voy_no]" ).append("\n"); 
		query.append("  AND A.SKD_DIR_CD       = @[skd_dir_cd]" ).append("\n"); 
		query.append("  AND A.YD_CD            = @[pol_cd]" ).append("\n"); 
		query.append("  AND A.POL_CLPT_IND_SEQ = @[pol_clpt_ind_seq]" ).append("\n"); 
		query.append("  AND A.UPLD_DT         IS NULL" ).append("\n"); 
		query.append("  AND A.DCGO_FLG         = 'Y' ) Y ) " ).append("\n"); 

	}
}