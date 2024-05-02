/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : KorManifestListDBDAOaddVVDInfoInKorCstmCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOaddVVDInfoInKorCstmCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 전송되었거나 데이터가 없는 경우 추가
	  * </pre>
	  */
	public KorManifestListDBDAOaddVVDInfoInKorCstmCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mst_bl_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_meas_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_chk_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_bl_knt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ttl_pck_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_mty_feu_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_mty_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_lc_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_mty_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_ts_45ft_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_full_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnsl_bl_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_ts_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_mty_45ft_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ttl_ts_feu_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_lc_45ft_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_lc_feu_qty",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n"); 
		query.append("FileName : KorManifestListDBDAOaddVVDInfoInKorCstmCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_KR_VVD_SMRY" ).append("\n"); 
		query.append("( MRN_NO , MRN_CHK_NO , VSL_CD , SKD_VOY_NO , SKD_DIR_CD , OB_DECL_TP_CD ," ).append("\n"); 
		query.append("  VVD_SEQ , PORT_CD , IO_BND_CD , VSL_CNT_CD , VSL_NM , KR_VSL_CALL_SGN_CD ," ).append("\n"); 
		query.append("  ETA_DT , ETD_DT , MST_BL_KNT , CNSL_BL_KNT , MTY_BL_KNT , TTL_WGT ," ).append("\n"); 
		query.append("  TTL_MEAS_QTY , TTL_PCK_QTY , TTL_FULL_KNT , TTL_MTY_KNT , TTL_LC_TEU_QTY ," ).append("\n"); 
		query.append("  TTL_LC_FEU_QTY , TTL_LC_45FT_QTY, TTL_TS_TEU_QTY , TTL_TS_FEU_QTY , TTL_TS_45FT_QTY," ).append("\n"); 
		query.append("  TTL_MTY_TEU_QTY , TTL_MTY_FEU_QTY , TTL_MTY_45FT_QTY," ).append("\n"); 
		query.append("  JO_CRR_KNT , CRE_DT , CRE_USR_ID , UPD_DT , UPD_USR_ID ," ).append("\n"); 
		query.append("  MF_SND_DT , MF_SND_USR_ID , RSPN_RCV_DT , CSTMS_DCHG_CD , DCHG_RPT_SND_DT , DCHG_RPT_SND_USR_ID," ).append("\n"); 
		query.append("  CALL_KNT, DCHG_MZD_CD, IO_TML_LOC_CD)" ).append("\n"); 
		query.append("SELECT  MRN_NO, MRN_CHK_NO, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, @[in_type], @[vvd_seq]+1," ).append("\n"); 
		query.append("        PORT_CD, IO_BND_CD, VSL_CNT_CD, VSL_NM, KR_VSL_CALL_SGN_CD, ETA_DT, ETD_DT," ).append("\n"); 
		query.append("		@[mst_bl_knt] , @[cnsl_bl_knt] , @[mty_bl_knt] , NVL(@[ttl_wgt],0) ," ).append("\n"); 
		query.append("	    NVL(@[ttl_meas_qty],0) , NVL(@[ttl_pck_qty],0) , @[ttl_full_knt] , @[ttl_mty_knt] , NVL(@[ttl_lc_teu_qty],0) ," ).append("\n"); 
		query.append("  		NVL(@[ttl_lc_feu_qty],0) , NVL(@[ttl_lc_45ft_qty],0), NVL(@[ttl_ts_teu_qty],0) , NVL(@[ttl_ts_feu_qty],0) , NVL(@[ttl_ts_45ft_qty],0)," ).append("\n"); 
		query.append("  		NVL(@[ttl_mty_teu_qty],0) , NVL(@[ttl_mty_feu_qty],0) , NVL(@[ttl_mty_45ft_qty],0)," ).append("\n"); 
		query.append("        JO_CRR_KNT, SYSDATE, CRE_USR_ID, SYSDATE, @[user_id], NULL, NULL," ).append("\n"); 
		query.append("        NULL, DECODE(PORT_CD,'KRPUS','030197004','KRKAN','062112001','KRINC','020104002','KRPTK','016105001','KRUSN','110109004','KRGIN','020112001','030197004'), NULL, NULL," ).append("\n"); 
		query.append("        0, NULL, NULL" ).append("\n"); 
		query.append("FROM    BKG_CSTMS_KR_VVD_SMRY KV" ).append("\n"); 
		query.append("WHERE   KV.VSL_CD        = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND     KV.SKD_VOY_NO    = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND     KV.SKD_DIR_CD    = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND     KV.MRN_NO        = @[mrn_no]" ).append("\n"); 
		query.append("AND     KV.MRN_CHK_NO    = @[mrn_chk_no]" ).append("\n"); 
		query.append("AND     KV.OB_DECL_TP_CD = @[in_type]" ).append("\n"); 
		query.append("AND     KV.VVD_SEQ        = @[vvd_seq]" ).append("\n"); 
		query.append("AND     ROWNUM = 1" ).append("\n"); 

	}
}