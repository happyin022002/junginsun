/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : KorManifestListDBDAOAddExportNoMakeCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.28
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.28 
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

public class KorManifestListDBDAOAddExportNoMakeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddExportNoMake
	  * </pre>
	  */
	public KorManifestListDBDAOAddExportNoMakeCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prt_lodg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bme_wgt_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("c_bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bme_wgt_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("username",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bme_pkg_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bme_elno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bme_pkg_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kcd_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kt_port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("expt_kcd_tp",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n"); 
		query.append("FileName : KorManifestListDBDAOAddExportNoMakeCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_KR_XPT_LIC" ).append("\n"); 
		query.append("(BKG_NO, CSTMS_DECL_TP_CD, TRNS_SEQ, XPT_LIC_NO," ).append("\n"); 
		query.append("PCK_QTY, PCK_TP_CD, CNTR_WGT, WGT_UT_CD," ).append("\n"); 
		query.append("PRT_LODG_FLG, PRT_LODG_SEQ," ).append("\n"); 
		query.append("DIVD_PCK_QTY, DIVD_PCK_UT_CD, DIVD_WGT, DIVD_WGT_UT_CD," ).append("\n"); 
		query.append("KR_XPT_PCK_ID, DMST_PORT_CD, CRE_USR_ID, UPD_USR_ID, CSTMS_BL_NO)" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("( @[bkg_no]" ).append("\n"); 
		query.append(", DECODE(@[expt_kcd_tp],'R','R','T','T',@[kcd_tp])" ).append("\n"); 
		query.append(", @[kt_seq]" ).append("\n"); 
		query.append(", @[bme_elno]" ).append("\n"); 
		query.append(", @[bme_pkg_qty]" ).append("\n"); 
		query.append(", @[bme_pkg_cd]" ).append("\n"); 
		query.append(", @[bme_wgt_qty]" ).append("\n"); 
		query.append(", @[bme_wgt_tp]" ).append("\n"); 
		query.append(", NVL(TRIM(@[prt_lodg_flg]),'N')" ).append("\n"); 
		query.append(", '0'" ).append("\n"); 
		query.append(", 0" ).append("\n"); 
		query.append(", ' '" ).append("\n"); 
		query.append(", 0" ).append("\n"); 
		query.append(", ' '" ).append("\n"); 
		query.append(", ' '" ).append("\n"); 
		query.append(", @[kt_port]" ).append("\n"); 
		query.append(", @[username]" ).append("\n"); 
		query.append(", @[username]" ).append("\n"); 
		query.append(", @[c_bl_no])" ).append("\n"); 

	}
}