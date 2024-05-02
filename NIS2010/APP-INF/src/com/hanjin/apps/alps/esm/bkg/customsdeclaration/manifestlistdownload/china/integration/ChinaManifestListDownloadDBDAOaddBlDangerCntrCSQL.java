/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChinaManifestListDownloadDBDAOaddBlDangerCntrCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaManifestListDownloadDBDAOaddBlDangerCntrCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addBlDangerCntr
	  * </pre>
	  */
	public ChinaManifestListDownloadDBDAOaddBlDangerCntrCSQL(){
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
		params.put("chn_mf_snd_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("imdg_pg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_subs_rsk_lbl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.integration ").append("\n"); 
		query.append("FileName : ChinaManifestListDownloadDBDAOaddBlDangerCntrCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_CHN_DG_CGO (" ).append("\n"); 
		query.append("CHN_MF_SND_IND_CD," ).append("\n"); 
		query.append("BL_NO," ).append("\n"); 
		query.append("DCGO_SEQ," ).append("\n"); 
		query.append("IMDG_UN_NO," ).append("\n"); 
		query.append("IMDG_CLSS_CD," ).append("\n"); 
		query.append("CNTR_NO," ).append("\n"); 
		query.append("IMDG_PG_NO," ).append("\n"); 
		query.append("IMDG_SUBS_RSK_LBL_CD," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT  )" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("@[chn_mf_snd_ind_cd]," ).append("\n"); 
		query.append("@[bl_no]," ).append("\n"); 
		query.append("--NVL(MAX(DCGO_SEQ), 0) + 1," ).append("\n"); 
		query.append("NVL((SELECT /*+ index_desc(A XPKBKG_CSTMS_CHN_DG_CGO)  */" ).append("\n"); 
		query.append("DCGO_SEQ" ).append("\n"); 
		query.append("FROM   BKG_CSTMS_CHN_DG_CGO A" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    CHN_MF_SND_IND_CD = @[chn_mf_snd_ind_cd]" ).append("\n"); 
		query.append("AND    BL_NO = @[bl_no]" ).append("\n"); 
		query.append("AND    ROWNUM 	  = 1" ).append("\n"); 
		query.append("),0)+1," ).append("\n"); 
		query.append("@[imdg_un_no]," ).append("\n"); 
		query.append("@[imdg_clss_cd]," ).append("\n"); 
		query.append("@[cntr_no]," ).append("\n"); 
		query.append("@[imdg_pg_no]," ).append("\n"); 
		query.append("@[imdg_subs_rsk_lbl_cd]," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE	  )" ).append("\n"); 

	}
}