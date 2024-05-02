/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KorManifestListDBDAOmodifyDgCNTRInfoUSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.07
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.06.07 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim minjeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOmodifyDgCNTRInfoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * 다른 항차로 이미 D/L 된 BKG이있을 경우에, Dup Error를 피하고 Update 한다.
	  * </pre>
	  */
	public KorManifestListDBDAOmodifyDgCNTRInfoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("net_weight",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("certi_seq_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("job",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("certi_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("substance",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("imdg_comp_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n");
		query.append("FileName : KorManifestListDBDAOmodifyDgCNTRInfoUSQL").append("\n");
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
		query.append("UPDATE BKG_CSTMS_KR_DG_CGO" ).append("\n");
		query.append("   SET DCGO_SEQ   = @[doc_no]" ).append("\n");
		query.append("     , MSN_NO     = @[msn_no]" ).append("\n");
		query.append("     , VSL_CD     = SUBSTR(@[vvd], 1, 4) " ).append("\n");
		query.append("     , SKD_VOY_NO = SUBSTR(@[vvd], 5, 4) " ).append("\n");
		query.append("     , SKD_DIR_CD = SUBSTR(@[vvd], 9, 1) " ).append("\n");
		query.append("     , POL_CD    = @[pol_cd]" ).append("\n");
		query.append("     , POD_CD    = @[pod_cd]" ).append("\n");
		query.append("     , IMDG_CLSS_CD = @[imdg_clss_cd]" ).append("\n");
		query.append("     , BL_NO      = @[bl_no]" ).append("\n");
		query.append("     , MF_CERTI_NO = @[certi_no]" ).append("\n");
		query.append("     , CERTI_SEQ_NO = @[certi_seq_no]" ).append("\n");
		query.append("     , DCHG_KND_CD  = @[job]" ).append("\n");
		query.append("     , PRP_SHP_NM = @[substance]" ).append("\n");
		query.append("     , NET_WGT = @[net_weight]" ).append("\n");
		query.append("     , UPD_DT   = SYSDATE " ).append("\n");
		query.append("     , UPD_USR_ID   = @[user_id]" ).append("\n");
		query.append("     , SND_DT  = NULL " ).append("\n");
		query.append("     , SND_USR_ID  = NULL" ).append("\n");
		query.append("     , IMDG_COMP_GRP_CD = @[imdg_comp_grp_cd]" ).append("\n");
		query.append(" WHERE BKG_NO           = @[bkg_no]" ).append("\n");
		query.append("   AND CSTMS_DECL_TP_CD = @[cstms_decl_tp_cd]" ).append("\n");
		query.append("   AND CNTR_SEQ         = @[cntr_seq]" ).append("\n");
		query.append("   AND CNTR_NO          = @[cntr_no]" ).append("\n");
		query.append("   AND IMDG_UN_NO       = @[imdg_un_no]" ).append("\n");

	}
}