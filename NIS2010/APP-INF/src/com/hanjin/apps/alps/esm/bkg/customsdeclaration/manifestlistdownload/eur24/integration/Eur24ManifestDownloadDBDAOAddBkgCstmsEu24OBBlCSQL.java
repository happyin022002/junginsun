/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : Eur24ManifestDownloadDBDAOAddBkgCstmsEu24OBBlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.16
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2011.06.16 김경섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24ManifestDownloadDBDAOAddBkgCstmsEu24OBBlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur24ManifestDownloadDBDAOAddBkgCstmsEu24OBBlCSQL
	  * </pre>
	  */
	public Eur24ManifestDownloadDBDAOAddBkgCstmsEu24OBBlCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eu_1st_port_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration").append("\n"); 
		query.append("FileName : Eur24ManifestDownloadDBDAOAddBkgCstmsEu24OBBlCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_EUR_IO_BL" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append(" BND_TP_CD,    VSL_CD,      SKD_VOY_NO,     SKD_DIR_CD,    BL_NO,        CSTMS_PORT_CD" ).append("\n"); 
		query.append(" , BKG_POL_CD, BKG_POD_CD,    POL_CD,        POD_CD,       DEL_CD" ).append("\n"); 
		query.append(" , POL_NM" ).append("\n"); 
		query.append(" , POD_NM" ).append("\n"); 
		query.append(" , DEL_NM" ).append("\n"); 
		query.append(" , PCK_QTY,     PCK_TP_CD" ).append("\n"); 
		query.append(" , MEAS_QTY,    MEAS_UT_CD,    CMDT_CD,       TRSP_DOC_NO,  CSTMS_DECL_DT,  DECL_LOC_CD" ).append("\n"); 
		query.append(" , CRE_USR_ID,  CRE_DT,        UPD_USR_ID,    UPD_DT" ).append("\n"); 
		query.append(" , ACT_WGT,     WGT_UT_CD,     CSTMS_DESC" ).append("\n"); 
		query.append(" , POL_YD_CD,   POD_YD_CD,     CSTMS_YD_CD" ).append("\n"); 
		query.append(" , MVMT_REF_NO, MSG_SND_NO" ).append("\n"); 
		query.append(")  " ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("  'O',         X.VSL_CD,      X.SKD_VOY_NO,  X.SKD_DIR_CD, X.BL_NO,      X.CSTMS_PORT_CD" ).append("\n"); 
		query.append(" ,BKG.POL_CD,  BKG.POD_CD,    VVD.POL_CD,    VVD.POD_CD,   BKG.DEL_CD  " ).append("\n"); 
		query.append(" , (SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = VVD.POL_CD) AS POL_NM" ).append("\n"); 
		query.append(" , (SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = VVD.POD_CD) AS POD_NM" ).append("\n"); 
		query.append(" , (SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = BKG.DEL_CD) AS POD_NM" ).append("\n"); 
		query.append(" , BD.PCK_QTY,   BD.PCK_TP_CD " ).append("\n"); 
		query.append(" , BD.MEAS_QTY, BD.MEAS_UT_CD, BKG.CMDT_CD,   NULL,         NULL,            NULL" ).append("\n"); 
		query.append(" , @[cre_usr_id],SYSDATE,     @[cre_usr_id],  SYSDATE  " ).append("\n"); 
		query.append(" , BD.ACT_WGT,    BD.WGT_UT_CD,     BD.CSTMS_DESC      " ).append("\n"); 
		query.append(" , VVD.POL_YD_CD, VVD.POD_YD_CD ,   @[eu_1st_port_yd_cd]" ).append("\n"); 
		query.append(" , X.MVMT_REF_NO, X.MSG_SND_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT DISTINCT" ).append("\n"); 
		query.append("               BKG_GET_TOKEN_FNC(COLUMN_VALUE,1) AS VSL_CD" ).append("\n"); 
		query.append("             , BKG_GET_TOKEN_FNC(COLUMN_VALUE,2) AS SKD_VOY_NO" ).append("\n"); 
		query.append("             , BKG_GET_TOKEN_FNC(COLUMN_VALUE,3) AS SKD_DIR_CD" ).append("\n"); 
		query.append("             , BKG_GET_TOKEN_FNC(COLUMN_VALUE,4) AS BL_NO" ).append("\n"); 
		query.append("             , BKG_GET_TOKEN_FNC(COLUMN_VALUE,5) AS CSTMS_PORT_CD" ).append("\n"); 
		query.append("             , BKG_GET_TOKEN_FNC(COLUMN_VALUE,7) AS MVMT_REF_NO" ).append("\n"); 
		query.append("             , BKG_GET_TOKEN_FNC(COLUMN_VALUE,8) AS MSG_SND_NO" ).append("\n"); 
		query.append("        FROM TABLE(BKG_SPLIT_CLOB_FNC(${cntr_list},'@'))" ).append("\n"); 
		query.append("        WHERE COLUMN_VALUE IS NOT NULL" ).append("\n"); 
		query.append("     ) X," ).append("\n"); 
		query.append("     BKG_BOOKING BKG," ).append("\n"); 
		query.append("     BKG_VVD VVD," ).append("\n"); 
		query.append("     BKG_BL_DOC BD" ).append("\n"); 
		query.append("WHERE X.BL_NO = BKG.BL_NO" ).append("\n"); 
		query.append("AND VVD.VSL_CD        = X.VSL_CD" ).append("\n"); 
		query.append("AND VVD.SKD_VOY_NO    = X.SKD_VOY_NO" ).append("\n"); 
		query.append("AND VVD.SKD_DIR_CD    = X.SKD_DIR_CD " ).append("\n"); 
		query.append("AND VVD.BKG_NO        = BKG.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND BKG.BKG_NO = BD.BKG_NO" ).append("\n"); 

	}
}