/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChinaManifestListDownloadDBDAOaddBlCntrSealNoListCSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier :
*@LastVersion : 1.0
* 2009.09.03
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaManifestListDownloadDBDAOaddBlCntrSealNoListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * addBlCntrSealNoList
	  * </pre>
	  */
	public ChinaManifestListDownloadDBDAOaddBlCntrSealNoListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("seal_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("seal_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_div_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("seal_pty_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.integration").append("\n");
		query.append("FileName : ChinaManifestListDownloadDBDAOaddBlCntrSealNoListCSQL").append("\n");
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
		query.append("INSERT INTO BKG_CSTMS_SEAL_NO (" ).append("\n");
		query.append("CNT_CD," ).append("\n");
		query.append("CSTMS_DIV_ID," ).append("\n");
		query.append("BL_NO," ).append("\n");
		query.append("CNTR_NO," ).append("\n");
		query.append("SEAL_NO_SEQ," ).append("\n");
		query.append("SEAL_NO," ).append("\n");
		query.append("SEAL_PTY_TP_CD," ).append("\n");
		query.append("SEAL_KND_CD," ).append("\n");
		query.append("CRE_DT," ).append("\n");
		query.append("CRE_USR_ID," ).append("\n");
		query.append("UPD_DT," ).append("\n");
		query.append("UPD_USR_ID )" ).append("\n");
		query.append("VALUES (" ).append("\n");
		query.append("NVL(@[cnt_cd],'CN')," ).append("\n");
		query.append("NVL(@[cstms_div_id],'CTM')," ).append("\n");
		query.append("@[bl_no]," ).append("\n");
		query.append("@[cntr_no]," ).append("\n");
		query.append("NVL((SELECT /*+ index_desc(A XPKBKG_CSTMS_SEAL_NO)  */" ).append("\n");
		query.append("SEAL_NO_SEQ" ).append("\n");
		query.append("FROM   BKG_CSTMS_SEAL_NO A" ).append("\n");
		query.append("WHERE  1=1" ).append("\n");
		query.append("AND	 CNT_CD 	  = NVL(@[cnt_cd],'CN')" ).append("\n");
		query.append("AND    CSTMS_DIV_ID = NVL(@[cstms_div_id],'CTM')" ).append("\n");
		query.append("AND    BL_NO 		  = @[bl_no]" ).append("\n");
		query.append("AND    CNTR_NO 	  = @[cntr_no]" ).append("\n");
		query.append("AND    ROWNUM 	  = 1" ).append("\n");
		query.append("),0)+1," ).append("\n");
		query.append("@[seal_no]," ).append("\n");
		query.append("@[seal_pty_tp_cd]," ).append("\n");
		query.append("@[seal_knd_cd]," ).append("\n");
		query.append("SYSDATE," ).append("\n");
		query.append("@[cre_usr_id]," ).append("\n");
		query.append("SYSDATE," ).append("\n");
		query.append("@[upd_usr_id]" ).append("\n");
		query.append(")" ).append("\n");

	}
}