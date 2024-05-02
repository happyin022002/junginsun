/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AncsManifestListDownloadDBDAOaddSelectBkgCstmsAnrBl2CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.19
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2012.03.19 김경섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AncsManifestListDownloadDBDAOaddSelectBkgCstmsAnrBl2CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * i
	  * </pre>
	  */
	public AncsManifestListDownloadDBDAOaddSelectBkgCstmsAnrBl2CSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : AncsManifestListDownloadDBDAOaddSelectBkgCstmsAnrBl2CSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_ANR_BL (" ).append("\n"); 
		query.append("VSL_CD,              SKD_VOY_NO, SKD_DIR_CD, BKG_NO," ).append("\n"); 
		query.append("VVD_SEQ,             BL_NO,       BL_TP_CD," ).append("\n"); 
		query.append("POR_CD,  POL_CD,     POD_CD,     DEL_CD,    PRE_RLY_PORT_CD, " ).append("\n"); 
		query.append("PST_RLY_PORT_CD,     BKG_CGO_TP_CD, SHPR_ADDR, CNEE_ADDR," ).append("\n"); 
		query.append("ACT_WGT,             ACT_WGT_UT_CD, PCK_QTY,   PCK_TP_CD," ).append("\n"); 
		query.append("BDR_FLG, CSTMS_PRC_CD, ANR_MSG_STS_CD, CRE_OFC_CD, UPD_OFC_CD," ).append("\n"); 
		query.append("CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.BKG_NO" ).append("\n"); 
		query.append(", MAX_VVD_SEQ + ROWNUM" ).append("\n"); 
		query.append(", B.BL_NO, B.BL_TP_CD" ).append("\n"); 
		query.append(", B.POR_CD, B.POL_CD, B.POD_CD, B.DEL_CD, DECODE(C.POL_CD, B.POL_CD, NULL, C.POL_CD), DECODE(C.POD_CD, B.POD_CD, NULL, C.POD_CD), B.BKG_CGO_TP_CD" ).append("\n"); 
		query.append(", SUBSTR(D.CUST_NM || '@@' || D.CUST_ADDR, 1, 300)" ).append("\n"); 
		query.append(", SUBSTR(E.CUST_NM || '@@' || E.CUST_ADDR, 1, 300)" ).append("\n"); 
		query.append(", NVL(F.ACT_WGT,0), F.WGT_UT_CD, NVL(F.PCK_QTY,0), F.PCK_TP_CD" ).append("\n"); 
		query.append(", F.BDR_FLG" ).append("\n"); 
		query.append(", DECODE(C.POD_CD, @[pod], DECODE(B.POD_CD, 'NLRTM', 'B', 'T'), 'D') -- T: Tranship, B: RTM Barge , D: Discharging" ).append("\n"); 
		query.append(", ''" ).append("\n"); 
		query.append(", @[cre_ofc_cd]" ).append("\n"); 
		query.append(", @[upd_ofc_cd] " ).append("\n"); 
		query.append(", @[cre_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[upd_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append("FROM BKG_VVD A, BKG_BOOKING B, BKG_VVD C, BKG_CUSTOMER D, BKG_CUSTOMER E, BKG_BL_DOC F," ).append("\n"); 
		query.append("(SELECT NVL(MAX(VVD_SEQ), 0 ) MAX_VVD_SEQ" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ANR_BL" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND BKG_NO = @[bkg_no]) MAX_VVD_SEQ" ).append("\n"); 
		query.append("WHERE 1=1 " ).append("\n"); 
		query.append("AND B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("--AND A.VSL_CD   = 'AENA'" ).append("\n"); 
		query.append("--AND A.SKD_VOY_NO = '0052'" ).append("\n"); 
		query.append("--AND A.SKD_DIR_CD = 'W'" ).append("\n"); 
		query.append("AND A.POD_CD     = @[pod]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("AND B.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("AND B.BKG_CGO_TP_CD IN ('F', 'B')" ).append("\n"); 
		query.append("AND C.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND C.VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append("AND C.VSL_SEQ = '0'" ).append("\n"); 
		query.append("AND D.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND D.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("AND E.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND E.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("AND F.BKG_NO = B.BKG_NO" ).append("\n"); 

	}
}