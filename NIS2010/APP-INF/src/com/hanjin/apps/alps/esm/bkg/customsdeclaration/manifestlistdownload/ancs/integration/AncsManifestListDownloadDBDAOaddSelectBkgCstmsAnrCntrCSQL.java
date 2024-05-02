/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : AncsManifestListDownloadDBDAOaddSelectBkgCstmsAnrCntrCSQL.java
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

public class AncsManifestListDownloadDBDAOaddSelectBkgCstmsAnrCntrCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INSERT
	  * </pre>
	  */
	public AncsManifestListDownloadDBDAOaddSelectBkgCstmsAnrCntrCSQL(){
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
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.integration").append("\n"); 
		query.append("FileName : AncsManifestListDownloadDBDAOaddSelectBkgCstmsAnrCntrCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_ANR_CNTR (" ).append("\n"); 
		query.append("VSL_CD, SKD_VOY_NO, SKD_DIR_CD, BKG_NO, CNTR_NO," ).append("\n"); 
		query.append("CNTR_TPSZ_CD, ISO_CNTR_TPSZ_CD, PCK_QTY, PCK_TP_CD, CNTR_WGT, WGT_UT_CD," ).append("\n"); 
		query.append("ORG_RCV_TERM_CD, DEST_DE_TERM_CD, DECL_FLG," ).append("\n"); 
		query.append("CRE_OFC_CD, UPD_OFC_CD, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT)" ).append("\n"); 
		query.append("SELECT B.VSL_CD, B.SKD_VOY_NO, B.SKD_DIR_CD, C.BKG_NO, C.CNTR_NO," ).append("\n"); 
		query.append("C.CNTR_TPSZ_CD, D.CNTR_TPSZ_ISO_CD, NVL(C.PCK_QTY,0), C.PCK_TP_CD, NVL(C.CNTR_WGT,0), C.WGT_UT_CD," ).append("\n"); 
		query.append("DECODE(C.RCV_TERM_CD, 'S', 'LCL', 'FCL'), DECODE(C.DE_TERM_CD, 'S', 'LCL', 'FCL'), 'Y'" ).append("\n"); 
		query.append(", @[cre_ofc_cd]" ).append("\n"); 
		query.append(", @[upd_ofc_cd]" ).append("\n"); 
		query.append(", @[cre_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[upd_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append("FROM BKG_VVD A, BKG_CSTMS_ANR_BL B, BKG_CONTAINER C, MDM_CNTR_TP_SZ D" ).append("\n"); 
		query.append("WHERE A.VSL_CD = substr(@[vvd],1,4)" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = substr(@[vvd],5,4)" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = substr(@[vvd],9,1)" ).append("\n"); 
		query.append("AND A.POL_CD = @[pol]" ).append("\n"); 
		query.append("AND A.POD_CD = @[pod]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_clpt_ind_seq} != '')" ).append("\n"); 
		query.append("AND A.POL_CLPT_IND_SEQ = @[pol_clpt_ind_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_clpt_ind_seq} != '')" ).append("\n"); 
		query.append("AND A.POD_CLPT_IND_SEQ = @[pod_clpt_ind_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND B.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("AND B.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND B.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("AND B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("AND C.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND D.CNTR_TPSZ_CD(+) = C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("#if (${chk_down} == 'Y' || ${chk_down} == 'C')" ).append("\n"); 
		query.append("AND NOT EXISTS (SELECT '*' FROM BKG_CSTMS_ANR_CNTR E WHERE E.VSL_CD = B.VSL_CD AND E.SKD_VOY_NO = B.SKD_VOY_NO AND E.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("AND E.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("AND E.CNTR_NO = C.CNTR_NO)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND NOT EXISTS (SELECT '*' FROM BKG_CSTMS_ANR_CNTR E WHERE E.VSL_CD = B.VSL_CD AND E.SKD_VOY_NO = B.SKD_VOY_NO AND E.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("AND E.BKG_NO = C.BKG_NO)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}