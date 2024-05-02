/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : AncsManifestListDownloadDBDAOaddSelectBkgCstmsAnrNtfyCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.02
*@LastModifier : 윤태승
*@LastVersion : 1.0
* 2013.01.02 윤태승
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yuntaeseung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AncsManifestListDownloadDBDAOaddSelectBkgCstmsAnrNtfyCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INSERT
	  * </pre>
	  */
	public AncsManifestListDownloadDBDAOaddSelectBkgCstmsAnrNtfyCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("upd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.integration").append("\n"); 
		query.append("FileName : AncsManifestListDownloadDBDAOaddSelectBkgCstmsAnrNtfyCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_ANR_NTFY (" ).append("\n"); 
		query.append("BKG_NO, NTFY_SEQ," ).append("\n"); 
		query.append("BL_NO, NTFY_NM, NTFY_ADDR, FAX_NO," ).append("\n"); 
		query.append("NTFY_EML, CHG_DP_FLG, DIFF_RMK," ).append("\n"); 
		query.append("CRE_OFC_CD, UPD_OFC_CD, CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT, UPD_USR_ID, UPD_DT)" ).append("\n"); 
		query.append("SELECT B.BKG_NO, 1" ).append("\n"); 
		query.append(", A.BL_NO,SUBSTR(B.CUST_NM,1,100), B.CUST_ADDR, CUST_FAX_NO," ).append("\n"); 
		query.append("CUST_EML, 'N', NULL" ).append("\n"); 
		query.append(", @[cre_ofc_cd]" ).append("\n"); 
		query.append(", @[upd_ofc_cd]" ).append("\n"); 
		query.append(", @[cre_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[upd_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ANR_BL A, BKG_CUSTOMER B, BKG_VVD V" ).append("\n"); 
		query.append("WHERE A.VSL_CD = substr(@[vvd],1,4)" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = substr(@[vvd],5,4)" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = substr(@[vvd],9,1)" ).append("\n"); 
		query.append("AND B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("AND B.BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND A.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("AND A.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("AND V.POL_CLPT_IND_SEQ = @[pol_clpt_ind_seq]" ).append("\n"); 
		query.append("AND V.POD_CLPT_IND_SEQ = @[pod_clpt_ind_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${chk_down} == 'Y' || ${chk_down} == 'C')" ).append("\n"); 
		query.append("AND NOT EXISTS (SELECT '*' FROM BKG_CSTMS_ANR_NTFY C WHERE C.BKG_NO = A.BKG_NO AND C.NTFY_SEQ = 1)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND NOT EXISTS (SELECT '*' FROM BKG_CSTMS_ANR_NTFY C WHERE C.BKG_NO = A.BKG_NO)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}