/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : JapanTerminalTransmissionDBDAOaddDgCgoforNewBkgInfoCSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.16
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2012.03.16 김종옥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jong Ock
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanTerminalTransmissionDBDAOaddDgCgoforNewBkgInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * addDgCgoforNewBkgInfo
	  * </pre>
	  */
	public JapanTerminalTransmissionDBDAOaddDgCgoforNewBkgInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("mrn_polut_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_lmt_qty_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_pck_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_skd_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_vol_qty",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration ").append("\n");
		query.append("FileName : JapanTerminalTransmissionDBDAOaddDgCgoforNewBkgInfoCSQL").append("\n");
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
		query.append("INSERT INTO BKG_TML_EDI_JP_DG_CGO (" ).append("\n");
		query.append("BKG_NO" ).append("\n");
		query.append(", BKG_SKD_SEQ" ).append("\n");
		query.append(", DCGO_SEQ" ).append("\n");
		query.append(", CNTR_TPSZ_CD" ).append("\n");
		query.append(", CNTR_VOL_QTY" ).append("\n");
		query.append(", CNTR_NO" ).append("\n");
		query.append(", MRN_POLUT_FLG" ).append("\n");
		query.append(", IMDG_LMT_QTY_FLG" ).append("\n");
		query.append(", IMDG_CLSS_CD" ).append("\n");
		query.append(", IMDG_UN_NO" ).append("\n");
		query.append(", IMDG_PCK_GRP_CD" ).append("\n");
		query.append(", CRE_USR_ID" ).append("\n");
		query.append(", CRE_DT" ).append("\n");
		query.append(", UPD_USR_ID" ).append("\n");
		query.append(", UPD_DT" ).append("\n");
		query.append(") VALUES (" ).append("\n");
		query.append("@[bkg_no]" ).append("\n");
		query.append(",@[bkg_skd_seq]" ).append("\n");
		query.append(",@[dcgo_seq]" ).append("\n");
		query.append(",@[cntr_tpsz_cd]" ).append("\n");
		query.append(",@[cntr_vol_qty]" ).append("\n");
		query.append(",@[cntr_no]" ).append("\n");
		query.append(",@[mrn_polut_flg]" ).append("\n");
		query.append(",@[imdg_lmt_qty_flg]" ).append("\n");
		query.append(",@[imdg_clss_cd]" ).append("\n");
		query.append(",@[imdg_un_no]" ).append("\n");
		query.append(",@[imdg_pck_grp_cd]" ).append("\n");
		query.append(",@[cre_usr_id]" ).append("\n");
		query.append(",SYSDATE" ).append("\n");
		query.append(",@[cre_usr_id]" ).append("\n");
		query.append(",SYSDATE" ).append("\n");
		query.append(")" ).append("\n");

	}
}