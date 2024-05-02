/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : KorManifestListDBDAOaddDgVVDInfoCSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.15
*@LastModifier :
*@LastVersion : 1.0
* 2012.11.15
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

public class KorManifestListDBDAOaddDgVVDInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * 최초 Download시 DG VVD정보가 Table에 Insert된다.
	  * </pre>
	  */
	public KorManifestListDBDAOaddDgVVDInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dchg_com_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dgco_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("contact",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("substance",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("authority",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trans_code",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("call_sgn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_vvd_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("total_cntr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("job_code2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("job_code1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tml_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_anch",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_area",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("port_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("total_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dsch_com_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n");
		query.append("FileName : KorManifestListDBDAOaddDgVVDInfoCSQL").append("\n");
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
		query.append("INSERT " ).append("\n");
		query.append("  INTO BKG_CSTMS_KR_DG_CGO_VVD " ).append("\n");
		query.append("     ( MRN_NO" ).append("\n");
		query.append("     , MRN_CHK_NO" ).append("\n");
		query.append("     , VSL_CD" ).append("\n");
		query.append("     , SKD_VOY_NO" ).append("\n");
		query.append("     , SKD_DIR_CD" ).append("\n");
		query.append("     , PORT_CD" ).append("\n");
		query.append("     , IO_BND_CD" ).append("\n");
		query.append("     , INTER_CNG_CTRL_NO" ).append("\n");
		query.append("     , VSL_NM" ).append("\n");
		query.append("     , KR_VSL_CALL_SGN_CD" ).append("\n");
		query.append("     , ARR_DT" ).append("\n");
		query.append("     , DCHG_FM_DT" ).append("\n");
		query.append("     , DCHG_TO_DT" ).append("\n");
		query.append("     , KR_DCHG_CO_ID" ).append("\n");
		query.append("     , DCHG_VNDR_NM" ).append("\n");
		query.append("     , KR_CSTMS_DCHG_N1ST_JB_CD" ).append("\n");
		query.append("     , KR_CSTMS_DCHG_N2ND_JB_CD" ).append("\n");
		query.append("     , TTL_CNTR_KNT" ).append("\n");
		query.append("     , DG_TTL_WGT" ).append("\n");
		query.append("     , PRE_CLPT_CD" ).append("\n");
		query.append("     , PORT_AREA_N1ST_ID" ).append("\n");
		query.append("     , PORT_AREA_N2ND_ID" ).append("\n");
		query.append("     , PORT_DESC" ).append("\n");
		query.append("     , REP_SBST_CTNT" ).append("\n");
		query.append("     , CNTC_PSON_DESC" ).append("\n");
		query.append("     , CRE_DT" ).append("\n");
		query.append("     , CRE_USR_ID" ).append("\n");
		query.append("     , UPD_DT" ).append("\n");
		query.append("     , UPD_USR_ID" ).append("\n");
		query.append("     , MF_SND_DT" ).append("\n");
		query.append("     , MF_SND_USR_ID" ).append("\n");
		query.append("     , CALL_KNT" ).append("\n");
		query.append("     , VVD_SEQ" ).append("\n");
		query.append("     , IO_BND_DT" ).append("\n");
		query.append("     , KR_PORT_AUTH_CD" ).append("\n");
		query.append("     , KR_CSTMS_DG_TRNS_CD" ).append("\n");
		query.append("     , DCGO_SEQ" ).append("\n");
		query.append("     , TML_VSL_CD" ).append("\n");
		query.append("     , TML_SKD_VOY_NO" ).append("\n");
		query.append("     )" ).append("\n");
		query.append("SELECT SUBSTR(@[mrn_no],1,10)" ).append("\n");
		query.append("     , SUBSTR(@[mrn_no],11,1)" ).append("\n");
		query.append("     , SUBSTR(@[vvd], 1, 4)" ).append("\n");
		query.append("     , SUBSTR(@[vvd], 5, 4)" ).append("\n");
		query.append("     , SUBSTR(@[vvd], 9, 1)" ).append("\n");
		query.append("     , @[port_cd]" ).append("\n");
		query.append("     , DECODE(@[io], '01', 'I', 'O')" ).append("\n");
		query.append("     , NVL(@[doc_no], MAX(INTER_CNG_CTRL_NO)+1)" ).append("\n");
		query.append("     , @[vsl_eng_nm]" ).append("\n");
		query.append("     , @[call_sgn_no]" ).append("\n");
		query.append("     , CASE WHEN @[arv_dt] = ' ' THEN NULL ELSE TO_DATE(@[arv_dt], 'YYYY-MM-DD HH24:MI') END" ).append("\n");
		query.append("     , CASE WHEN @[from_dt] = ' ' THEN NULL ELSE TO_DATE(@[from_dt], 'YYYY-MM-DD HH24:MI') END" ).append("\n");
		query.append("     , CASE WHEN @[to_dt] = ' ' THEN NULL ELSE TO_DATE(@[to_dt], 'YYYY-MM-DD HH24:MI') END" ).append("\n");
		query.append("     , @[dchg_com_cd]" ).append("\n");
		query.append("     , @[dsch_com_nm]" ).append("\n");
		query.append("     , @[job_code1]" ).append("\n");
		query.append("     , @[job_code2]" ).append("\n");
		query.append("     , @[total_cntr]" ).append("\n");
		query.append("     , @[total_wgt]" ).append("\n");
		query.append("     , @[pre_port]" ).append("\n");
		query.append("     , @[port_area]" ).append("\n");
		query.append("     , @[port_anch]" ).append("\n");
		query.append("     , @[port_desc]" ).append("\n");
		query.append("     , @[substance]" ).append("\n");
		query.append("     , @[contact]" ).append("\n");
		query.append("     , SYSDATE" ).append("\n");
		query.append("     , @[user_id]" ).append("\n");
		query.append("     , SYSDATE" ).append("\n");
		query.append("     , @[user_id]" ).append("\n");
		query.append("     , NULL" ).append("\n");
		query.append("     , NULL" ).append("\n");
		query.append("     , @[call_knt]" ).append("\n");
		query.append("     , @[max_vvd_seq]" ).append("\n");
		query.append("     , CASE WHEN @[io_dt] = ' ' THEN NULL ELSE TO_DATE(@[io_dt], 'YYYY-MM-DD HH24:MI') END" ).append("\n");
		query.append("     , @[authority]" ).append("\n");
		query.append("     , @[trans_code]" ).append("\n");
		query.append("     , NVL(@[dgco_seq],0)" ).append("\n");
		query.append("     , @[tml_vvd]" ).append("\n");
		query.append("     , @[tml_skd_voy_no]" ).append("\n");
		query.append("  FROM BKG_CSTMS_KR_DG_CGO_VVD " ).append("\n");
		query.append(" WHERE MRN_NO      =   SUBSTR(@[mrn_no],1,10)" ).append("\n");
		query.append("   AND MRN_CHK_NO  =   SUBSTR(@[mrn_no],11,1)" ).append("\n");
		query.append("   AND VSL_CD      =   SUBSTR(@[vvd], 1, 4)" ).append("\n");
		query.append("   AND SKD_VOY_NO  =   SUBSTR(@[vvd], 5, 4)" ).append("\n");
		query.append("   AND SKD_DIR_CD  =   SUBSTR(@[vvd], 9, 1)" ).append("\n");
		query.append("   AND VVD_SEQ     =   (@[max_vvd_seq] - 1)" ).append("\n");

	}
}