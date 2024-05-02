/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CIMCommonDBDAOModifyCtmMovementDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.cimcommon.cimcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CIMCommonDBDAOModifyCtmMovementDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CTM Movement Update
	  * </pre>
	  */
	public CIMCommonDBDAOModifyCtmMovementDataUSQL(){
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
		params.put("cnmv_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tir_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_yr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fcntr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_id_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("osca_bkg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_cntr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("crnt_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_repo_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("org_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_pln_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mvmt_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_trsp_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_crr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_seal_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_doc_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cim.cimcommon.cimcommon.integration").append("\n"); 
		query.append("FileName : CIMCommonDBDAOModifyCtmMovementDataUSQL").append("\n"); 
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
		query.append("UPDATE CTM_MOVEMENT CM SET" ).append("\n"); 
		query.append("	FCNTR_FLG	=	NVL(@[fcntr_flg], 'N')" ).append("\n"); 
		query.append("	, OB_CNTR_FLG		=	NVL(@[ob_cntr_flg], 'N') " ).append("\n"); 
		query.append("	, SPCL_CGO_FLG	= ''" ).append("\n"); 
		query.append("	, BKG_NO		=  @[bkg_no]" ).append("\n"); 
		query.append("	, BL_NO		=  @[bkg_no]" ).append("\n"); 
		query.append("	, CNMV_CO_CD	= COM_CONSTANTMGR_PKG.COM_GETCOMPANYCODE_FNC()" ).append("\n"); 
		query.append("	, GMT_DT		= GLOBALDATE_PKG.TIME_CONV_FNC (SUBSTR (@[org_yd_cd], 0, 5 ), SYSDATE, 'GMT' )" ).append("\n"); 
		query.append("	, UPD_USR_ID	= @[upd_usr_id]" ).append("\n"); 
		query.append("	, CRE_LOCL_DT	= GLOBALDATE_PKG.TIME_LOCAL_FNC(SUBSTR (@[org_yd_cd], 0, 5 ))" ).append("\n"); 
		query.append("	, UPD_DT		= SYSDATE " ).append("\n"); 
		query.append("	, UPD_LOCL_DT	= GLOBALDATE_PKG.TIME_LOCAL_FNC(SUBSTR (@[org_yd_cd], 0, 5 ))" ).append("\n"); 
		query.append("	, MVMT_STS_CD	= @[mvmt_sts_cd]" ).append("\n"); 
		query.append("	, BKG_CGO_TP_CD	= @[bkg_cgo_tp_cd]" ).append("\n"); 
		query.append("    , CNMV_CYC_NO   =  CASE WHEN @[cnmv_cyc_no] in (NULL, 9999, 0, 9998) THEN" ).append("\n"); 
		query.append("                                 DECODE(@[bkg_no], NULL, NULL" ).append("\n"); 
		query.append("                                                 , NVL(  (SELECT MAX(SM.CNMV_CYC_NO) " ).append("\n"); 
		query.append("                                                            FROM CTM_MOVEMENT SM" ).append("\n"); 
		query.append("                                                           WHERE SM.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("                                                             AND SM.BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("                                                       )" ).append("\n"); 
		query.append("                                                 , (SELECT MAX(SM.CNMV_CYC_NO)+ 1" ).append("\n"); 
		query.append("                                                      FROM CTM_MOVEMENT SM" ).append("\n"); 
		query.append("                                                     WHERE SM.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("                                                       AND EXISTS ( SELECT 'X'" ).append("\n"); 
		query.append("                                                                      FROM CIM_BKG_CNTR_V SC" ).append("\n"); 
		query.append("                                                                     WHERE NVL(SC.CNMV_CYC_NO, 0) IN (0, 9998, 9999)" ).append("\n"); 
		query.append("                                                                       AND SM.CNTR_NO     = SC.CNTR_NO" ).append("\n"); 
		query.append("                                                                       AND SC.BKG_NO      = @[bkg_no]" ).append("\n"); 
		query.append("                                                                       AND ROWNUM         = 1)" ).append("\n"); 
		query.append("                                                    ) " ).append("\n"); 
		query.append("                                        )                         " ).append("\n"); 
		query.append("                                 )" ).append("\n"); 
		query.append("                     ELSE" ).append("\n"); 
		query.append("                         @[cnmv_cyc_no]" ).append("\n"); 
		query.append("                     END" ).append("\n"); 
		query.append("	, CNMV_EVNT_DT	= TO_DATE(@[cnmv_evnt_dt], 'YYYY-MM-DD HH24:MI') " ).append("\n"); 
		query.append("	, DEST_YD_CD		= @[dest_yd_cd]" ).append("\n"); 
		query.append("	, INP_YD_CD		= @[org_yd_cd]" ).append("\n"); 
		query.append("	, ORG_YD_CD		= @[org_yd_cd]" ).append("\n"); 
		query.append("	, CRNT_VSL_CD		= @[crnt_vsl_cd]" ).append("\n"); 
		query.append("	, CRNT_SKD_VOY_NO	= @[crnt_skd_voy_no]" ).append("\n"); 
		query.append("	, CRNT_SKD_DIR_CD	= @[crnt_skd_dir_cd]" ).append("\n"); 
		query.append("	, SYS_AREA_GRP_ID	= (SELECT SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("					FROM COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("					WHERE CNT_CD    = SUBSTR(@[org_yd_cd], 1, 2)" ).append("\n"); 
		query.append("					AND CO_IND_CD = 'H'" ).append("\n"); 
		query.append("					AND ROWNUM    = 1)" ).append("\n"); 
		query.append("	, OFC_CD			= @[ofc_cd]" ).append("\n"); 
		query.append("	, CNMV_RMK		= @[cnmv_rmk]" ).append("\n"); 
		query.append("	, CNTR_SEAL_NO	= @[cntr_seal_no]" ).append("\n"); 
		query.append("	, MVMT_TRSP_MOD_CD	= @[mvmt_trsp_mod_cd]" ).append("\n"); 
		query.append("	, WO_NO			= @[wo_no]" ).append("\n"); 
		query.append("	, TIR_NO			= @[tir_no]" ).append("\n"); 
		query.append("	, MTY_PLN_NO		= @[mty_pln_no]" ).append("\n"); 
		query.append("	, MTY_REPO_NO		= @[mty_repo_no]" ).append("\n"); 
		query.append("	, EDI_CRR_NO		= @[edi_crr_no]" ).append("\n"); 
		query.append("	, TRSP_DOC_NO		= @[trsp_doc_no]" ).append("\n"); 
		query.append("	, OSCA_BKG_FLG	= @[osca_bkg_flg]" ).append("\n"); 
		query.append("    , CNMV_GDT   = GLOBALDATE_PKG.TIME_CONV_FNC (SUBSTR (@[org_yd_cd], 0, 5 ), TO_DATE (@[cnmv_evnt_dt], 'YYYY-MM-DD HH24:MI'), 'GMT' ) " ).append("\n"); 
		query.append(" WHERE CM.CNTR_NO = @[cntr_no]	" ).append("\n"); 
		query.append("   AND CM.CNMV_YR = @[cnmv_yr]	" ).append("\n"); 
		query.append("   AND CM.CNMV_ID_NO = @[cnmv_id_no]" ).append("\n"); 

	}
}