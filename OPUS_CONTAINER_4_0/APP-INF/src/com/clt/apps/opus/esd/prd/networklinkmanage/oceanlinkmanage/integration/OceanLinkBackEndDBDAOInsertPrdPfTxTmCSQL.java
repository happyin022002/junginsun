/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OceanLinkBackEndDBDAOInsertPrdPfTxTmCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OceanLinkBackEndDBDAOInsertPrdPfTxTmCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * insert시 해당 lane, pol, pod를 가지는 ocean link가 존재하면 정보를 업데이트하고, 존재하지 않으면 정보를 추가한다.
	  * </pre>
	  */
	public OceanLinkBackEndDBDAOInsertPrdPfTxTmCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmt_tztm_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("podprot",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("poletb",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("podetb",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dircd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("poletd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("podetd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lanecd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lnk_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("polprot",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.integration").append("\n"); 
		query.append("FileName : OceanLinkBackEndDBDAOInsertPrdPfTxTmCSQL").append("\n"); 
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
		query.append("MERGE INTO PRD_PF_TZ_TM A" ).append("\n"); 
		query.append("USING DUAL ON ( A.VSL_SLAN_CD       = @[lanecd]" ).append("\n"); 
		query.append("                AND A.FM_PORT_CD    = @[polprot]" ).append("\n"); 
		query.append("                AND A.TO_PORT_CD    = @[podprot]" ).append("\n"); 
		query.append("				AND A.SKD_DIR_CD 	= @[dircd]" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE SET" ).append("\n"); 
		query.append("          A.TZTM_HRS          =   TO_NUMBER(@[fmt_tztm_hrs])" ).append("\n"); 
		query.append("        , A.FM_PORT_ETB_DY_CD =   @[poletb]" ).append("\n"); 
		query.append("        , A.FM_PORT_ETD_DY_CD =   @[poletd]" ).append("\n"); 
		query.append("        , A.TO_PORT_ETB_DY_CD =   @[podetb]" ).append("\n"); 
		query.append("        , A.TO_PORT_ETD_DY_CD =   @[podetd]" ).append("\n"); 
		query.append("        , A.UPD_OFC_CD        =   @[cre_ofc_cd]" ).append("\n"); 
		query.append("        , A.OCN_LNK_MNL_FLG   =   'Y'" ).append("\n"); 
		query.append("        , A.CRE_USR_ID        =   @[cre_usr_id]" ).append("\n"); 
		query.append("        , A.CRE_DT            =   sysdate" ).append("\n"); 
		query.append("        , A.UPD_USR_ID        =   @[cre_usr_id]" ).append("\n"); 
		query.append("        , A.UPD_DT            =   sysdate" ).append("\n"); 
		query.append("        , A.LNK_RMK           =   @[cre_usr_id]||' has created on '||TO_CHAR(SYSDATE,'Mon-DD,YYYY', 'NLS_DATE_LANGUAGE=ENGLISH')||' : '||@[lnk_rmk]" ).append("\n"); 
		query.append("        , A.DELT_FLG          =   'N'" ).append("\n"); 
		query.append("        , A.LNK_DIST          =   (SELECT NVL(LNK_DIST, 0) " ).append("\n"); 
		query.append("										 FROM (" ).append("\n"); 
		query.append("										 SELECT SUM(NVL(P.LNK_DIST,D.STND_DIST)) LNK_DIST" ).append("\n"); 
		query.append("										 FROM PRD_PF_TZ_TM P, VSK_PORT_DIST D," ).append("\n"); 
		query.append("										     (SELECT V.SLAN_CD, V.SKD_DIR_CD, V.VPS_PORT_CD FM_PORT, V.CLPT_SEQ," ).append("\n"); 
		query.append("										             LEAD(V.VPS_PORT_CD, 1, NULL) OVER (PARTITION BY V.VSL_CD, V.SKD_VOY_NO, V.SKD_DIR_CD ORDER BY V.CLPT_SEQ) TO_PORT" ).append("\n"); 
		query.append("										      FROM VSK_VSL_PORT_SKD V, " ).append("\n"); 
		query.append("											       (SELECT *" ).append("\n"); 
		query.append("											        FROM(SELECT A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.CLPT_SEQ FM_SEQ, B.CLPT_SEQ TO_SEQ " ).append("\n"); 
		query.append("											             FROM VSK_VSL_PORT_SKD A, VSK_VSL_PORT_SKD B" ).append("\n"); 
		query.append("											             WHERE A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("											             AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("											             AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("											             AND A.CLPT_SEQ < B.CLPT_SEQ" ).append("\n"); 
		query.append("											             AND A.VPS_PORT_CD = @[polprot]" ).append("\n"); 
		query.append("												         AND B.VPS_PORT_CD = @[podprot]" ).append("\n"); 
		query.append("											             AND A.SLAN_CD = @[lanecd]" ).append("\n"); 
		query.append("											             AND A.SKD_DIR_CD = @[dircd]" ).append("\n"); 
		query.append("											             ORDER BY ABS(SYSDATE - A.VPS_ETD_DT)" ).append("\n"); 
		query.append("										           )WHERE ROWNUM = 1) L" ).append("\n"); 
		query.append("												    WHERE V.VSL_CD = L.VSL_CD" ).append("\n"); 
		query.append("												    AND V.SKD_VOY_NO = L.SKD_VOY_NO" ).append("\n"); 
		query.append("												    AND V.SKD_DIR_CD = L.SKD_DIR_CD" ).append("\n"); 
		query.append("												    AND V.CLPT_SEQ BETWEEN L.FM_SEQ AND L.TO_SEQ" ).append("\n"); 
		query.append("											    ) M" ).append("\n"); 
		query.append("											WHERE M.FM_PORT = P.FM_PORT_CD(+)" ).append("\n"); 
		query.append("											AND M.TO_PORT = P.TO_PORT_CD(+)" ).append("\n"); 
		query.append("											AND M.SLAN_CD = P.VSL_SLAN_CD(+)" ).append("\n"); 
		query.append("											AND M.FM_PORT = D.FM_LOC_CD(+)" ).append("\n"); 
		query.append("											AND M.TO_PORT = D.TO_LOC_CD(+)" ).append("\n"); 
		query.append("											AND M.TO_PORT IS NOT NULL )" ).append("\n"); 
		query.append("									)" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND A.VSL_SLAN_CD     = @[lanecd]" ).append("\n"); 
		query.append("    AND A.FM_PORT_CD      = @[polprot]" ).append("\n"); 
		query.append("    AND A.TO_PORT_CD      = @[podprot]" ).append("\n"); 
		query.append("    AND A.SKD_DIR_CD      = @[dircd]" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT (" ).append("\n"); 
		query.append("        A.VSL_SLAN_CD" ).append("\n"); 
		query.append("        , A.FM_PORT_CD" ).append("\n"); 
		query.append("        , A.TO_PORT_CD" ).append("\n"); 
		query.append("        , A.TZTM_HRS" ).append("\n"); 
		query.append("        , A.SKD_DIR_CD" ).append("\n"); 
		query.append("        , A.FM_PORT_ETB_DY_CD" ).append("\n"); 
		query.append("        , A.FM_PORT_ETD_DY_CD" ).append("\n"); 
		query.append("        , A.TO_PORT_ETB_DY_CD" ).append("\n"); 
		query.append("        , A.TO_PORT_ETD_DY_CD" ).append("\n"); 
		query.append("        , A.UPD_OFC_CD" ).append("\n"); 
		query.append("        , A.OCN_LNK_MNL_FLG" ).append("\n"); 
		query.append("        , A.CRE_USR_ID" ).append("\n"); 
		query.append("        , A.CRE_DT" ).append("\n"); 
		query.append("        , A.UPD_USR_ID" ).append("\n"); 
		query.append("        , A.UPD_DT" ).append("\n"); 
		query.append("        , A.LNK_RMK" ).append("\n"); 
		query.append("        , A.LNK_DIST" ).append("\n"); 
		query.append("--        , A.DELT_FLG" ).append("\n"); 
		query.append("    ) values (" ).append("\n"); 
		query.append("          @[lanecd]" ).append("\n"); 
		query.append("        , @[polprot]" ).append("\n"); 
		query.append("        , @[podprot]" ).append("\n"); 
		query.append("        , TO_NUMBER(@[fmt_tztm_hrs])" ).append("\n"); 
		query.append("        , @[dircd]" ).append("\n"); 
		query.append("        , @[poletb]" ).append("\n"); 
		query.append("        , @[poletd]" ).append("\n"); 
		query.append("        , @[podetb]" ).append("\n"); 
		query.append("        , @[podetd]" ).append("\n"); 
		query.append("        , @[cre_ofc_cd]" ).append("\n"); 
		query.append("        , 'Y'" ).append("\n"); 
		query.append("        , @[cre_usr_id]" ).append("\n"); 
		query.append("        , sysdate" ).append("\n"); 
		query.append("        , @[cre_usr_id]" ).append("\n"); 
		query.append("        , sysdate" ).append("\n"); 
		query.append("        , @[cre_usr_id]||' has created on '||TO_CHAR(SYSDATE,'Mon-DD,YYYY', 'NLS_DATE_LANGUAGE=ENGLISH')||' : '||@[lnk_rmk]" ).append("\n"); 
		query.append("--        , 'N'" ).append("\n"); 
		query.append("        ,(SELECT NVL(LNK_DIST, 0) " ).append("\n"); 
		query.append("										 FROM (" ).append("\n"); 
		query.append("										 SELECT SUM(NVL(P.LNK_DIST,D.STND_DIST)) LNK_DIST" ).append("\n"); 
		query.append("										 FROM PRD_PF_TZ_TM P, VSK_PORT_DIST D," ).append("\n"); 
		query.append("										     (SELECT V.SLAN_CD, V.SKD_DIR_CD, V.VPS_PORT_CD FM_PORT, V.CLPT_SEQ," ).append("\n"); 
		query.append("										             LEAD(V.VPS_PORT_CD, 1, NULL) OVER (PARTITION BY V.VSL_CD, V.SKD_VOY_NO, V.SKD_DIR_CD ORDER BY V.CLPT_SEQ) TO_PORT" ).append("\n"); 
		query.append("										      FROM VSK_VSL_PORT_SKD V, " ).append("\n"); 
		query.append("											       (SELECT *" ).append("\n"); 
		query.append("											        FROM(SELECT A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.CLPT_SEQ FM_SEQ, B.CLPT_SEQ TO_SEQ " ).append("\n"); 
		query.append("											             FROM VSK_VSL_PORT_SKD A, VSK_VSL_PORT_SKD B" ).append("\n"); 
		query.append("											             WHERE A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("											             AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("											             AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("											             AND A.CLPT_SEQ < B.CLPT_SEQ" ).append("\n"); 
		query.append("											             AND A.VPS_PORT_CD = @[polprot]" ).append("\n"); 
		query.append("												         AND B.VPS_PORT_CD = @[podprot]" ).append("\n"); 
		query.append("											             AND A.SLAN_CD = @[lanecd]" ).append("\n"); 
		query.append("											             AND A.SKD_DIR_CD = @[dircd]" ).append("\n"); 
		query.append("											             ORDER BY ABS(SYSDATE - A.VPS_ETD_DT)" ).append("\n"); 
		query.append("										           )WHERE ROWNUM = 1) L" ).append("\n"); 
		query.append("												    WHERE V.VSL_CD = L.VSL_CD" ).append("\n"); 
		query.append("												    AND V.SKD_VOY_NO = L.SKD_VOY_NO" ).append("\n"); 
		query.append("												    AND V.SKD_DIR_CD = L.SKD_DIR_CD" ).append("\n"); 
		query.append("												    AND V.CLPT_SEQ BETWEEN L.FM_SEQ AND L.TO_SEQ" ).append("\n"); 
		query.append("											    ) M" ).append("\n"); 
		query.append("											WHERE M.FM_PORT = P.FM_PORT_CD(+)" ).append("\n"); 
		query.append("											AND M.TO_PORT = P.TO_PORT_CD(+)" ).append("\n"); 
		query.append("											AND M.SLAN_CD = P.VSL_SLAN_CD(+)" ).append("\n"); 
		query.append("											AND M.SKD_DIR_CD = P.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("											AND M.FM_PORT = D.FM_LOC_CD(+)" ).append("\n"); 
		query.append("											AND M.TO_PORT = D.TO_LOC_CD(+)" ).append("\n"); 
		query.append("											AND M.TO_PORT IS NOT NULL )" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}