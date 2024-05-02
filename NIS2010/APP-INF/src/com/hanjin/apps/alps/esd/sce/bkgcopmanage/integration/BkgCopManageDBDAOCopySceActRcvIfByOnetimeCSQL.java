/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BkgCopManageDBDAOCopySceActRcvIfByOnetimeCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.16
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOCopySceActRcvIfByOnetimeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Split 이전 org bkg + Split 이전 org bkg의 partial bkg list 의 Actual data를 new bkg no로 copy한다.
	  * </pre>
	  */
	public BkgCopManageDBDAOCopySceActRcvIfByOnetimeCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_cop_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("new_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOCopySceActRcvIfByOnetimeCSQL").append("\n"); 
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
		query.append("INSERT INTO SCE_ACT_RCV_IF (" ).append("\n"); 
		query.append("ACT_RCV_DT," ).append("\n"); 
		query.append("ACT_RCV_NO," ).append("\n"); 
		query.append("BKG_NO," ).append("\n"); 
		query.append("CNTR_NO," ).append("\n"); 
		query.append("ACT_DT," ).append("\n"); 
		query.append("ACT_STS_MAPG_CD," ).append("\n"); 
		query.append("NOD_CD," ).append("\n"); 
		query.append("ACT_RCV_TP_CD," ).append("\n"); 
		query.append("COP_RLT_FLG," ).append("\n"); 
		query.append("ACT_UMCH_TP_CD," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("VSL_CD," ).append("\n"); 
		query.append("SKD_VOY_NO," ).append("\n"); 
		query.append("SKD_DIR_CD," ).append("\n"); 
		query.append("VPS_PORT_CD," ).append("\n"); 
		query.append("CLPT_IND_SEQ," ).append("\n"); 
		query.append("CALL_YD_IND_SEQ," ).append("\n"); 
		query.append("EDI_MSG_TP_CD ," ).append("\n"); 
		query.append("VNDR_SEQ," ).append("\n"); 
		query.append("ERR_MSG," ).append("\n"); 
		query.append("BND_VSKD_SEQ_CD," ).append("\n"); 
		query.append("COP_EVNT_SEQ," ).append("\n"); 
		query.append("ACT_GDT," ).append("\n"); 
		query.append("ACT_DAT_RCV_DT," ).append("\n"); 
		query.append("COP_NO," ).append("\n"); 
		query.append("FAX_SND_RSLT_FLG," ).append("\n"); 
		query.append("EML_SND_RSLT_FLG," ).append("\n"); 
		query.append("EDI_SND_RSLT_FLG," ).append("\n"); 
		query.append("ACT_CD," ).append("\n"); 
		query.append("RTY_RSLT_FLG," ).append("\n"); 
		query.append("VNDR_NM," ).append("\n"); 
		query.append("CRE_TP_CD," ).append("\n"); 
		query.append("PRE_BKG_NO," ).append("\n"); 
		query.append("RAIL_DEST_N1ST_ETA_DT," ).append("\n"); 
		query.append("VSL_DLAY_RSN_CD," ).append("\n"); 
		query.append("VSL_DLAY_RSN_DESC," ).append("\n"); 
		query.append("VPS_LOC_CD," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT," ).append("\n"); 
		query.append("IMDT_EXT_FLG" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT TO_CHAR(SYSDATE, 'YYYYMMDD') ," ).append("\n"); 
		query.append("SCE_ACT_RCV_IF_SEQ1.NEXTVAL ," ).append("\n"); 
		query.append("@[new_bkg_no]," ).append("\n"); 
		query.append("@[cntr_no] ," ).append("\n"); 
		query.append("ACT_DT ," ).append("\n"); 
		query.append("ACT_STS_MAPG_CD ," ).append("\n"); 
		query.append("NOD_CD ," ).append("\n"); 
		query.append("ACT_RCV_TP_CD ," ).append("\n"); 
		query.append("COP_RLT_FLG ," ).append("\n"); 
		query.append("'00' , -- ACT_UMCH_TP_CD" ).append("\n"); 
		query.append("SYSDATE ," ).append("\n"); 
		query.append("VSL_CD ," ).append("\n"); 
		query.append("SKD_VOY_NO ," ).append("\n"); 
		query.append("SKD_DIR_CD ," ).append("\n"); 
		query.append("VPS_PORT_CD ," ).append("\n"); 
		query.append("CLPT_IND_SEQ ," ).append("\n"); 
		query.append("CALL_YD_IND_SEQ," ).append("\n"); 
		query.append("EDI_MSG_TP_CD ," ).append("\n"); 
		query.append("VNDR_SEQ ," ).append("\n"); 
		query.append("'' AS ERR_MSG ," ).append("\n"); 
		query.append("BND_VSKD_SEQ_CD ," ).append("\n"); 
		query.append("1 ," ).append("\n"); 
		query.append("ACT_GDT ," ).append("\n"); 
		query.append("ACT_DAT_RCV_DT ," ).append("\n"); 
		query.append("@[new_cop_no] ," ).append("\n"); 
		query.append("FAX_SND_RSLT_FLG ," ).append("\n"); 
		query.append("EML_SND_RSLT_FLG ," ).append("\n"); 
		query.append("'N' ," ).append("\n"); 
		query.append("ACT_CD ," ).append("\n"); 
		query.append("RTY_RSLT_FLG ," ).append("\n"); 
		query.append("VNDR_NM ," ).append("\n"); 
		query.append("CRE_TP_CD ," ).append("\n"); 
		query.append("PRE_BKG_NO ," ).append("\n"); 
		query.append("RAIL_DEST_N1ST_ETA_DT ," ).append("\n"); 
		query.append("VSL_DLAY_RSN_CD ," ).append("\n"); 
		query.append("VSL_DLAY_RSN_DESC ," ).append("\n"); 
		query.append("VPS_LOC_CD," ).append("\n"); 
		query.append("@[user_id]," ).append("\n"); 
		query.append("@[user_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("IMDT_EXT_FLG" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("    SELECT /* 중복 ACTUAL 정보중 최초로 발생된 건만 Insert 한다 */" ).append("\n"); 
		query.append("    RANK() OVER (PARTITION BY I.CNTR_NO, I.ACT_DT, I.ACT_RCV_TP_CD, I.ACT_STS_MAPG_CD, I.NOD_CD ORDER BY I.ACT_RCV_DT, I.ACT_RCV_NO) RANKING" ).append("\n"); 
		query.append("    , I.*" ).append("\n"); 
		query.append("     FROM" ).append("\n"); 
		query.append("    SCE_ACT_RCV_IF I," ).append("\n"); 
		query.append("    (   /* OLD BKG +  OLD PARTIAL BKG에서 발생된 ACTUAL 정보를 조회한다. */" ).append("\n"); 
		query.append("        SELECT CNTR_NO, ACT_DT, ACT_RCV_TP_CD, ACT_STS_MAPG_CD, NOD_CD FROM" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT A.CNTR_NO, A.ACT_DT, A.ACT_RCV_TP_CD, A.ACT_STS_MAPG_CD, A.NOD_CD FROM SCE_ACT_RCV_IF A" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("            AND A.BKG_NO IN (" ).append("\n"); 
		query.append("            #foreach($ele IN ${old_prtl_bkg_list})" ).append("\n"); 
		query.append("			     #if($velocityCount == 1 ) " ).append("\n"); 
		query.append("				    '$ele'" ).append("\n"); 
		query.append("			     #else " ).append("\n"); 
		query.append("				    ,'$ele'" ).append("\n"); 
		query.append("			     #end " ).append("\n"); 
		query.append("		    #end" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("            AND A.ACT_RCV_TP_CD IN ('1','3','9')" ).append("\n"); 
		query.append("            AND A.CRE_USR_ID NOT IN ('CrtBy1TimeSplt', 'CrtBy1TimeCmbn')" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    ) K" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND I.CNTR_NO = K.CNTR_NO" ).append("\n"); 
		query.append("    AND I.ACT_DT = K.ACT_DT" ).append("\n"); 
		query.append("    AND I.ACT_RCV_TP_CD = K.ACT_RCV_TP_CD" ).append("\n"); 
		query.append("    AND I.ACT_STS_MAPG_CD = K.ACT_STS_MAPG_CD" ).append("\n"); 
		query.append("    AND I.NOD_CD = K.NOD_CD" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    UNION" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("    RANK() OVER (PARTITION BY I.VSL_CD, I.SKD_VOY_NO, I.SKD_DIR_CD, I.CLPT_IND_SEQ,  I.ACT_DT, I.ACT_RCV_TP_CD, I.ACT_STS_MAPG_CD, I.NOD_CD ORDER BY I.ACT_RCV_DT, I.ACT_RCV_NO) RANKING" ).append("\n"); 
		query.append("    , I.*" ).append("\n"); 
		query.append("     FROM" ).append("\n"); 
		query.append("    SCE_ACT_RCV_IF I," ).append("\n"); 
		query.append("    (  " ).append("\n"); 
		query.append("            SELECT A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.CLPT_IND_SEQ,  A.ACT_DT, A.ACT_RCV_TP_CD, A.ACT_STS_MAPG_CD, A.NOD_CD FROM SCE_ACT_RCV_IF A, SCE_COP_DTL C" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND C.COP_NO IN (" ).append("\n"); 
		query.append("            #foreach($ele IN ${old_prtl_cop_list})" ).append("\n"); 
		query.append("			     #if($velocityCount == 1 ) " ).append("\n"); 
		query.append("				    '$ele'" ).append("\n"); 
		query.append("			     #else " ).append("\n"); 
		query.append("				    ,'$ele' " ).append("\n"); 
		query.append("			     #end " ).append("\n"); 
		query.append("		    #end" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("            AND C.COP_DTL_SEQ BETWEEN 4000 AND 6000" ).append("\n"); 
		query.append("            AND A.VSL_CD = C.VSL_CD" ).append("\n"); 
		query.append("            AND A.SKD_VOY_NO = C.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND A.SKD_DIR_CD = C.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND A.VPS_PORT_CD = C.VPS_PORT_CD" ).append("\n"); 
		query.append("            AND A.CLPT_IND_SEQ = C.CLPT_IND_SEQ" ).append("\n"); 
		query.append("            AND A.ACT_RCV_TP_CD = '2'" ).append("\n"); 
		query.append("            AND SUBSTR(A.ACT_STS_MAPG_CD, 3, 1) = SUBSTR(C.ACT_CD, 5, 1)" ).append("\n"); 
		query.append("            AND A.CRE_USR_ID NOT IN ('CrtBy1TimeSplt', 'CrtBy1TimeCmbn')" ).append("\n"); 
		query.append("    ) K" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND I.VSL_CD = K.VSL_CD" ).append("\n"); 
		query.append("    AND I.SKD_VOY_NO = K.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND I.SKD_DIR_CD = K.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND I.NOD_CD = K.NOD_CD" ).append("\n"); 
		query.append("    AND I.ACT_DT = K.ACT_DT" ).append("\n"); 
		query.append("    AND I.ACT_RCV_TP_CD = K.ACT_RCV_TP_CD" ).append("\n"); 
		query.append("    AND I.ACT_STS_MAPG_CD = K.ACT_STS_MAPG_CD            " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(") WHERE 1=1" ).append("\n"); 
		query.append("AND RANKING = 1" ).append("\n"); 

	}
}