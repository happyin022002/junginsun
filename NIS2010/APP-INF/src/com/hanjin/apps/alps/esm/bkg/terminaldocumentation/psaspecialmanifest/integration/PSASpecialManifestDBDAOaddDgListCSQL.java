/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PSASpecialManifestDBDAOaddDgListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.31
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2011.10.31 박성진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSASpecialManifestDBDAOaddDgListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 위험물 정보들을 신규생성한다.
	  * </pre>
	  */
	public PSASpecialManifestDBDAOaddDgListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntrts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("d_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("msg_snd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.integration").append("\n"); 
		query.append("FileName : PSASpecialManifestDBDAOaddDgListCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_PSA_DG (" ).append("\n"); 
		query.append("	MSG_SND_NO" ).append("\n"); 
		query.append(",	PSA_DG_DECL_TP_CD				                                    " ).append("\n"); 
		query.append(",	VSL_CD                                                      " ).append("\n"); 
		query.append(",	SKD_VOY_NO                                                  " ).append("\n"); 
		query.append(",	SKD_DIR_CD                                                  " ).append("\n"); 
		query.append(",	PORT_CD                                                     " ).append("\n"); 
		query.append(",	CNTR_NO                                                     " ).append("\n"); 
		query.append(",	CNTR_CGO_SEQ " ).append("\n"); 
		query.append(",   CNTR_TPSZ_CD                                               " ).append("\n"); 
		query.append(",	BL_NO                                                       " ).append("\n"); 
		query.append(",	POL_CD                                                      " ).append("\n"); 
		query.append(",	POD_CD                                                      " ).append("\n"); 
		query.append(",	CELL_PSN_NO                                                 " ).append("\n"); 
		query.append(",	PSA_FWRD_ID                                                 " ).append("\n"); 
		query.append(",	SVC_RQST_NO  " ).append("\n"); 
		query.append(",	PSA_CRR_TP_CD                                               " ).append("\n"); 
		query.append(",	FDR_SVC_RQST_NO" ).append("\n"); 
		query.append(",	FDR_VVD_ID" ).append("\n"); 
		query.append(",	FDR_VSL_NM" ).append("\n"); 
		query.append(",	FDR_VSL_LLOYD_NO                                           " ).append("\n"); 
		query.append(",	IMDG_PCK_GRP_CD                                             " ).append("\n"); 
		query.append(",	IMDG_CLSS_CD                                                " ).append("\n"); 
		query.append(",	IMDG_UN_NO" ).append("\n"); 
		query.append(",   IMDG_UN_NO_SEQ                                                  " ).append("\n"); 
		query.append(",	PSA_SPCL_TP_ID                                              " ).append("\n"); 
		query.append(",	FLSH_PNT_CDO_TEMP                                           " ).append("\n"); 
		query.append(",	NET_WGT                                                     " ).append("\n"); 
		query.append(",	GRS_WGT                                                     " ).append("\n"); 
		query.append(",	PRP_SHP_NM                                                  " ).append("\n"); 
		query.append(",	HZD_DESC                                                    " ).append("\n"); 
		query.append(",	IMDG_LMT_QTY_FLG                                            " ).append("\n"); 
		query.append(",	PCK_QTY                                                     " ).append("\n"); 
		query.append(",	PCK_TP_CD                                                   " ).append("\n"); 
		query.append(",	OUT_IMDG_PCK_QTY1                                           " ).append("\n"); 
		query.append(",	OUT_IMDG_PCK_CD1  " ).append("\n"); 
		query.append(",   PSA_OUTR_PCK_DESC                                          " ).append("\n"); 
		query.append(",	IN_IMDG_PCK_QTY1                                           " ).append("\n"); 
		query.append(",	IN_IMDG_PCK_CD1" ).append("\n"); 
		query.append(",   PSA_INR_PCK_DESC" ).append("\n"); 
		query.append(",	EMS_NO  " ).append("\n"); 
		query.append(",   PSA_ROLE_DIV_CD                                                    " ).append("\n"); 
		query.append(",	CRE_USR_ID                                                  " ).append("\n"); 
		query.append(",	CRE_DT                                                      " ).append("\n"); 
		query.append(",	UPD_USR_ID                                                  " ).append("\n"); 
		query.append(",	UPD_DT   " ).append("\n"); 
		query.append(",   PSA_PCK_DESC " ).append("\n"); 
		query.append(",   PSA_DCGO_MRN_POLUT_CD    " ).append("\n"); 
		query.append(",	CRR_DT" ).append("\n"); 
		query.append(",	IMDG_SUBS_RSK_LBL_CD1" ).append("\n"); 
		query.append(",	IMDG_SUBS_RSK_LBL_CD2" ).append("\n"); 
		query.append(",	IMDG_SUBS_RSK_LBL_CD3" ).append("\n"); 
		query.append(",	IMDG_SUBS_RSK_LBL_CD4                                              " ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[msg_snd_no]" ).append("\n"); 
		query.append(",	@[d_type]              " ).append("\n"); 
		query.append(",	SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append(",	SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append(",	SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append(",	@[port_cd]             " ).append("\n"); 
		query.append(",	@[cntr_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",   (" ).append("\n"); 
		query.append("        SELECT NVL(MAX(CNTR_CGO_SEQ), 0) + 1 AS CNTR_CGO_SEQ" ).append("\n"); 
		query.append("        FROM BKG_CSTMS_PSA_DG" ).append("\n"); 
		query.append("        WHERE PSA_DG_DECL_TP_CD = @[d_type]" ).append("\n"); 
		query.append("        AND   VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("        AND   SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("        AND   SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("	    AND   BL_NO       = @[bl_no]" ).append("\n"); 
		query.append("        AND   PORT_CD     = @[port_cd]" ).append("\n"); 
		query.append("        AND   CNTR_NO     = @[cntr_no]" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",	@[cntrts_cd]               " ).append("\n"); 
		query.append(",	@[bl_no]               " ).append("\n"); 
		query.append(",	@[p_pol_cd]              " ).append("\n"); 
		query.append(",	@[p_pod_cd]              " ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",   ''" ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",   ''" ).append("\n"); 
		query.append(",   ''" ).append("\n"); 
		query.append(",   ''" ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	0             " ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	0" ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	0" ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	'' " ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	@[usr_id]          " ).append("\n"); 
		query.append(",	SYSDATE                " ).append("\n"); 
		query.append(",	@[usr_id]         " ).append("\n"); 
		query.append(",	SYSDATE  " ).append("\n"); 
		query.append(",   ''" ).append("\n"); 
		query.append(",   ''         " ).append("\n"); 
		query.append(",   SYSDATE" ).append("\n"); 
		query.append(",	''  " ).append("\n"); 
		query.append(",	''    " ).append("\n"); 
		query.append(",	''  " ).append("\n"); 
		query.append(",	''    " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}