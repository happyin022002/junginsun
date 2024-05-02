/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CLLCDLManifestDBDAOaddKorCllEdiSendLogCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.02
*@LastModifier : 문경일
*@LastVersion : 1.0
* 2016.02.02 문경일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KYOUNGIL MOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOaddKorCllEdiSendLogCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addKorCllEdiSendLog
	  * </pre>
	  */
	public CLLCDLManifestDBDAOaddKorCllEdiSendLogCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_hdr_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fnl_edi_snd_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOaddKorCllEdiSendLogCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_TML_EDI_SND_LOG" ).append("\n"); 
		query.append("	(CNTR_LIST_NO, " ).append("\n"); 
		query.append("	 CNTR_NO, " ).append("\n"); 
		query.append("	 BKG_NO, " ).append("\n"); 
		query.append("	 EDI_SND_SEQ, " ).append("\n"); 
		query.append("	 EDI_SND_DT," ).append("\n"); 
		query.append("	 FNL_EDI_SND_FLG," ).append("\n"); 
		query.append("	 EDI_HDR_RMK," ).append("\n"); 
		query.append("	 DELT_FLG," ).append("\n"); 
		query.append("	 CRE_USR_ID, " ).append("\n"); 
		query.append("	 CRE_DT, " ).append("\n"); 
		query.append("	 UPD_USR_ID, " ).append("\n"); 
		query.append("	 UPD_DT," ).append("\n"); 
		query.append("	 VSL_CD," ).append("\n"); 
		query.append("	 SKD_VOY_NO," ).append("\n"); 
		query.append("	 SKD_DIR_CD," ).append("\n"); 
		query.append("	 POL_CD," ).append("\n"); 
		query.append("	 POL_YD_CD," ).append("\n"); 
		query.append("	 POD_CD," ).append("\n"); 
		query.append("	 POD_YD_CD," ).append("\n"); 
		query.append("	 KR_CLL_TS_CD" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  " ).append("\n"); 
		query.append("	@[vsl_cd] || SUBSTR(@[skd_voy_no],2,3) || @[skd_dir_cd] || SUBSTR(@[pol_cd],3,3), " ).append("\n"); 
		query.append("	A.CNTR_NO," ).append("\n"); 
		query.append("	NVL(B.BKG_NO, A.BKG_NO) BKG_NO, " ).append("\n"); 
		query.append("	(SELECT NVL(MAX(EDI_SND_SEQ)+1, 1) " ).append("\n"); 
		query.append("	 FROM BKG_CSTMS_TML_EDI_SND_LOG" ).append("\n"); 
		query.append("	 WHERE CNTR_LIST_NO = @[vsl_cd] || SUBSTR(@[skd_voy_no],2,3) || @[skd_dir_cd] || SUBSTR(@[pol_cd],3,3)" ).append("\n"); 
		query.append("	   AND CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("	   AND BKG_NO  = NVL(B.BKG_NO, A.BKG_NO) )," ).append("\n"); 
		query.append("	SYSDATE," ).append("\n"); 
		query.append("	@[fnl_edi_snd_flg]," ).append("\n"); 
		query.append("	@[edi_hdr_rmk]," ).append("\n"); 
		query.append("	'N'," ).append("\n"); 
		query.append("	@[cre_usr_id]," ).append("\n"); 
		query.append("	SYSDATE," ).append("\n"); 
		query.append("	@[upd_usr_id]," ).append("\n"); 
		query.append("	SYSDATE," ).append("\n"); 
		query.append("	@[vsl_cd]," ).append("\n"); 
		query.append("	@[skd_voy_no]," ).append("\n"); 
		query.append("	@[skd_dir_cd]," ).append("\n"); 
		query.append("	A.POL_CD," ).append("\n"); 
		query.append("	A.POL_YD_CD," ).append("\n"); 
		query.append("	A.POD_CD," ).append("\n"); 
		query.append("	A.POD_YD_CD," ).append("\n"); 
		query.append("    A.KR_CLL_TS_CD" ).append("\n"); 
		query.append(" FROM BKG_CSTMS_TML_KR_CLL A" ).append("\n"); 
		query.append(", (SELECT C.VSL_CD, C.SKD_VOY_NO, C.SKD_DIR_CD, C.POL_CD, B.BKG_NO, B.CNTR_NO " ).append("\n"); 
		query.append("   FROM BKG_CONTAINER B, BKG_VVD C" ).append("\n"); 
		query.append("   WHERE B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("   AND C.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("   AND C.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND C.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND C.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("   ) B" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE A.CNTR_LIST_NO LIKE @[vsl_cd] || SUBSTR(@[skd_voy_no],2,3) || @[skd_dir_cd] || SUBSTR(@[pol_cd],3,3) || '%'" ).append("\n"); 
		query.append("AND A.VSL_cD = B.VSL_CD(+)" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = B.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND A.SKD_DIR_cD= B.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND A.POL_CD = B.POL_CD (+)" ).append("\n"); 
		query.append("AND A.CNTR_NO = B.CNTR_NO(+)" ).append("\n"); 
		query.append("#if (${pol_yd_cd} != '') " ).append("\n"); 
		query.append("AND A.POL_YD_CD = @[pol_yd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_cll_type} == 'TS')" ).append("\n"); 
		query.append("AND A.KR_CLL_TS_CD IS NOT NULL" ).append("\n"); 
		query.append("#elseif (${in_cll_type} == 'LOCAL')" ).append("\n"); 
		query.append("AND A.KR_CLL_TS_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}