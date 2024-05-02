/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : KorManifestListDBDAOaddBlInqInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.06
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOaddBlInqInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ADD B/L 인경우 B/L 정보를 한국세관 테이블에 INSERT
	  * </pre>
	  */
	public KorManifestListDBDAOaddBlInqInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usa_bnd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cgo_desc2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_desc1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bd_area_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fldr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bb_cgo_meas_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_tml_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("biz_rgst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("meas_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_meas_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kr_wh_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kr_cstms_wh_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_ttl_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bb_cgo_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kr_meas_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_trsp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tax_code1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tax_code2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kr_cstms_bl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cstms_decl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cstms_crr_in_loc_wh_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n"); 
		query.append("FileName : KorManifestListDBDAOaddBlInqInfoCSQL").append("\n"); 
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
		query.append("INSERT" ).append("\n"); 
		query.append("  INTO BKG_CSTMS_KR_BL " ).append("\n"); 
		query.append("     ( BKG_NO" ).append("\n"); 
		query.append("     , CSTMS_DECL_TP_CD" ).append("\n"); 
		query.append("     , BL_NO" ).append("\n"); 
		query.append("	 , POR_CD" ).append("\n"); 
		query.append("     , POL_CD" ).append("\n"); 
		query.append("     , POD_CD" ).append("\n"); 
		query.append("     , DEL_CD" ).append("\n"); 
		query.append("     , MST_BL_SEQ_NO" ).append("\n"); 
		query.append("     , KR_CSTMS_BL_TP_CD" ).append("\n"); 
		query.append("     , CSTMS_FWRD_ID" ).append("\n"); 
		query.append("     , VSL_CD" ).append("\n"); 
		query.append("     , SKD_VOY_NO" ).append("\n"); 
		query.append("     , SKD_DIR_CD" ).append("\n"); 
		query.append("     , TS_POL_CD" ).append("\n"); 
		query.append("     , TS_POD_CD" ).append("\n"); 
		query.append("     , PCK_QTY" ).append("\n"); 
		query.append("     , PCK_TP_CD" ).append("\n"); 
		query.append("     , CNTR_TTL_WGT" ).append("\n"); 
		query.append("     , WGT_UT_CD" ).append("\n"); 
		query.append("     , MEAS_QTY" ).append("\n"); 
		query.append("     , BL_MEAS_UT_CD" ).append("\n"); 
		query.append("     , BD_AREA_CD" ).append("\n"); 
		query.append("     , CSTMS_CRR_IN_LOC_WH_CD" ).append("\n"); 
		query.append("     , IMDG_CLSS_CD" ).append("\n"); 
		query.append("     , N2ND_IMDG_CLSS_CD" ).append("\n"); 
		query.append("     , N3RD_IMDG_CLSS_CD" ).append("\n"); 
		query.append("     , KR_CSTMS_WH_TP_CD" ).append("\n"); 
		query.append("     , KR_WH_CD" ).append("\n"); 
		query.append("     , CRE_DT" ).append("\n"); 
		query.append("     , CRE_USR_ID" ).append("\n"); 
		query.append("     , UPD_DT" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append("     , MF_SND_DT" ).append("\n"); 
		query.append("     , MF_SND_USR_ID" ).append("\n"); 
		query.append("     , RSPN_RCV_DT" ).append("\n"); 
		query.append("     , TRNS_SEQ" ).append("\n"); 
		query.append("     , KR_BL_AMDT_STS_CD" ).append("\n"); 
		query.append("     , CGO_DESC1" ).append("\n"); 
		query.append("     , CGO_DESC2" ).append("\n"); 
		query.append("     , FRT_FWRD_CD" ).append("\n"); 
		query.append("     , BKG_CGO_TP_CD" ).append("\n"); 
		query.append("     , KR_CSTMS_BND_CD" ).append("\n"); 
		query.append("     , CSTMS_OFC_CTY_CD" ).append("\n"); 
		query.append("     , KR_CSTMS_DEPT_CD" ).append("\n"); 
		query.append("     , DMST_PORT_CD" ).append("\n"); 
		query.append("     , CMDT_CD" ).append("\n"); 
		query.append("     , KR_MEAS_UT_CD" ).append("\n"); 
		query.append("     , BIZ_RGST_NO" ).append("\n"); 
		query.append("     , BB_CGO_WGT" ).append("\n"); 
		query.append("     , BB_CGO_MEAS_QTY" ).append("\n"); 
		query.append("     , CGO_TRSP_CD " ).append("\n"); 
		query.append("     , CSTMS_BL_NO" ).append("\n"); 
		query.append("     , PORT_TML_CD" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("SELECT @[bkg_no]" ).append("\n"); 
		query.append("     , @[cstms_decl_tp_cd]" ).append("\n"); 
		query.append("     , @[bl_no]" ).append("\n"); 
		query.append("     , @[por_cd]" ).append("\n"); 
		query.append("     , @[pol_cd]" ).append("\n"); 
		query.append("     , @[pod_cd]" ).append("\n"); 
		query.append("     , @[del_cd]" ).append("\n"); 
		query.append("     , @[msn_no]" ).append("\n"); 
		query.append("     , @[kr_cstms_bl_tp_cd]" ).append("\n"); 
		query.append("     , ' '" ).append("\n"); 
		query.append("     , SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("     , SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("     , SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("     , DECODE(@[cstms_decl_tp_cd],'R',@[port_cd],@[ts_pol_cd])" ).append("\n"); 
		query.append("     , DECODE(@[cstms_decl_tp_cd],'T',@[port_cd],@[ts_pod_cd])" ).append("\n"); 
		query.append("     , @[pck_qty]" ).append("\n"); 
		query.append("     , @[pck_tp_cd]" ).append("\n"); 
		query.append("     , @[cntr_ttl_wgt]" ).append("\n"); 
		query.append("     , @[wgt_ut_cd]" ).append("\n"); 
		query.append("     , @[meas_qty]" ).append("\n"); 
		query.append("     , @[bl_meas_ut_cd]" ).append("\n"); 
		query.append("     , @[bd_area_cd]" ).append("\n"); 
		query.append("     , @[cstms_crr_in_loc_wh_cd]" ).append("\n"); 
		query.append("     , @[imdg_clss_cd]" ).append("\n"); 
		query.append("     , @[n2nd_imdg_clss_cd]" ).append("\n"); 
		query.append("     , @[n3rd_imdg_clss_cd]" ).append("\n"); 
		query.append("     , @[kr_cstms_wh_tp_cd]" ).append("\n"); 
		query.append("     , @[kr_wh_cd]" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("     , @[user_id]" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("     , @[user_id]" ).append("\n"); 
		query.append("     , NULL" ).append("\n"); 
		query.append("     , NULL" ).append("\n"); 
		query.append("     , NULL" ).append("\n"); 
		query.append("     , NVL(MAX(TRNS_SEQ), 0)+1" ).append("\n"); 
		query.append("     , NULL" ).append("\n"); 
		query.append("     , @[cgo_desc1]" ).append("\n"); 
		query.append("     , @[cgo_desc2]" ).append("\n"); 
		query.append("     , @[fldr_cd]" ).append("\n"); 
		query.append("     , @[bkg_cgo_tp_cd]" ).append("\n"); 
		query.append("     , @[usa_bnd_flg]" ).append("\n"); 
		query.append("     , TO_CHAR(NVL(@[tax_code1], 0), 'FM000')" ).append("\n"); 
		query.append("     , TO_CHAR(NVL(@[tax_code2], 0), 'FM00')" ).append("\n"); 
		query.append("     , @[port_cd]" ).append("\n"); 
		query.append("     , @[cmdt_cd]" ).append("\n"); 
		query.append("     , @[kr_meas_ut_cd]" ).append("\n"); 
		query.append("     , DECODE( @[cstms_decl_tp_cd], 'T', '' ,@[biz_rgst_no] )" ).append("\n"); 
		query.append("     , @[bb_cgo_wgt]" ).append("\n"); 
		query.append("     , @[bb_cgo_meas_qty]" ).append("\n"); 
		query.append("     , @[cgo_trsp_cd]" ).append("\n"); 
		query.append("     , SUBSTR(@[bl_no],1,12)" ).append("\n"); 
		query.append("	 , @[pod_tml_cd]" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_KR_BL" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND CSTMS_DECL_TP_CD = NVL(@[cstms_decl_tp_cd], @[cstms_decl_tp_cd])" ).append("\n"); 
		query.append("   AND DMST_PORT_CD = @[port_cd]" ).append("\n"); 

	}
}