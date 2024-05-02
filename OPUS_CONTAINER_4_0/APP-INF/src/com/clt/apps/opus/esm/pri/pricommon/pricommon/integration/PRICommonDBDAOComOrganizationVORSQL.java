/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PRICommonDBDAOComOrganizationVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.23
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2011.02.23 송민석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG Min Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAOComOrganizationVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Organization Select
	  * </pre>
	  */
	public PRICommonDBDAOComOrganizationVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pnode_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAOComOrganizationVORSQL").append("\n"); 
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
		query.append("WITH OFC AS (" ).append("\n"); 
		query.append("    SELECT distinct OFC.PRNT_OFC_CD AS PNODE_ID" ).append("\n"); 
		query.append("         , OFC.OFC_CD AS NODE_ID" ).append("\n"); 
		query.append("         , OFC.OFC_CD AS NODE_NM" ).append("\n"); 
		query.append("         , OFC.OFC_CD" ).append("\n"); 
		query.append("         , '' AS USR_ID" ).append("\n"); 
		query.append("         , '' AS USR_NM" ).append("\n"); 
		query.append("         , 'O' AS TYPE_FLG" ).append("\n"); 
		query.append("         , 'N' AS AUTH_FLG" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("            SELECT PRNT_OFC_CD" ).append("\n"); 
		query.append("                 , OFC_CD" ).append("\n"); 
		query.append("                 , LTRIM(SYS_CONNECT_BY_PATH(LPAD(OFC_CD, 6, ' '), '|'), '|') BY_PATH" ).append("\n"); 
		query.append("            FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND   DECODE(DELT_FLG, 'Y', 0, 1) = 1" ).append("\n"); 
		query.append("            START WITH OFC_CD=COM_ConstantMgr_PKG.COM_getHeadOfficeCode_FNC()" ).append("\n"); 
		query.append("            CONNECT BY PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("         ) OFC, (SELECT OFC_CD FROM TABLE(COM_OfficeCodeMgr_PKG.COM_getOfficeCodeList_FNC('000001','PRI'))) APP_OFC" ).append("\n"); 
		query.append("    WHERE " ).append("\n"); 
		query.append("			OFC.OFC_CD = COM_ConstantMgr_PKG.COM_getHeadOfficeCode_FNC()" ).append("\n"); 
		query.append(" 			OR OFC.BY_PATH LIKE '%' || LPAD(APP_OFC.OFC_CD,6,' ') || '%' -- Approval office 이하 office 모두를 나오게 하기 위한 쿼리" ).append("\n"); 
		query.append("					#foreach(${key} in ${ofc_cd_list})" ).append("\n"); 
		query.append("							OR  " ).append("\n"); 
		query.append("							OFC.BY_PATH LIKE '%' || LPAD('$key'  ,6,' ') -- 단지 Approval office의 parent office라서 tree를 완성 하기 위해 parent select하는 쿼리" ).append("\n"); 
		query.append("					#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT US.OFC_CD AS PNODE_ID" ).append("\n"); 
		query.append("         , 'USR_'||US.USR_ID AS NODE_ID" ).append("\n"); 
		query.append("         , '('||US.USR_ID||')'||' '||US.USR_NM AS NODE_NM" ).append("\n"); 
		query.append("         , US.OFC_CD" ).append("\n"); 
		query.append("         , US.USR_ID" ).append("\n"); 
		query.append("         , US.USR_NM" ).append("\n"); 
		query.append("         , 'U' AS TYPE_FLG" ).append("\n"); 
		query.append("         , DECODE(AU.USR_ID, NULL, 'N', 'Y') AS AUTH_FLG" ).append("\n"); 
		query.append("    FROM COM_USER US" ).append("\n"); 
		query.append("       , (SELECT DISTINCT USR_ID" ).append("\n"); 
		query.append("          FROM PRI_AUTHORIZATION" ).append("\n"); 
		query.append("          WHERE 1=1" ).append("\n"); 
		query.append("          AND   PRC_CTRT_TP_CD = 'R'" ).append("\n"); 
		query.append("          AND   SVC_SCP_CD IN (SELECT SVC_SCP_CD FROM PRI_RP_SCP_MN " ).append("\n"); 
		query.append("                               WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq])" ).append("\n"); 
		query.append("          AND   SYSDATE BETWEEN EFF_DT AND EXP_DT) AU" ).append("\n"); 
		query.append("    WHERE US.USE_FLG = 'Y'" ).append("\n"); 
		query.append("    AND   AU.USR_ID(+) = US.USR_ID" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if (${pnode_id} == '' && (${ofc_cd} != '' || ${usr_id} != '' || ${usr_nm} != ''))" ).append("\n"); 
		query.append(", CHL AS (" ).append("\n"); 
		query.append("    SELECT LEVEL LVL" ).append("\n"); 
		query.append("         , PNODE_ID" ).append("\n"); 
		query.append("         , NODE_ID" ).append("\n"); 
		query.append("         , OFC_CD" ).append("\n"); 
		query.append("         , USR_ID" ).append("\n"); 
		query.append("         , USR_NM" ).append("\n"); 
		query.append("         , NODE_NM" ).append("\n"); 
		query.append("    FROM OFC" ).append("\n"); 
		query.append("    START WITH DECODE(@[ofc_cd], NULL, 1, OFC_CD, 1, 0) = 1" ).append("\n"); 
		query.append("           AND DECODE(@[usr_id], NULL, 1, USR_ID, 1, 0) = 1" ).append("\n"); 
		query.append("           AND DECODE(@[usr_nm], NULL, 1, INSTR(UPPER(USR_NM), UPPER(@[usr_nm]))) > 0" ).append("\n"); 
		query.append("    CONNECT BY NODE_ID = PRIOR PNODE_ID" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pnode_id} != '') " ).append("\n"); 
		query.append("SELECT * FROM (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("SELECT LEVEL as lvl" ).append("\n"); 
		query.append("     , PNODE_ID" ).append("\n"); 
		query.append("     , NODE_ID" ).append("\n"); 
		query.append("     , NODE_NM" ).append("\n"); 
		query.append("     , OFC_CD" ).append("\n"); 
		query.append("     , USR_ID" ).append("\n"); 
		query.append("     , TYPE_FLG" ).append("\n"); 
		query.append("     , AUTH_FLG" ).append("\n"); 
		query.append("#if (${pnode_id} == '' && (${ofc_cd} != '' || ${usr_id} != '' || ${usr_nm} != ''))" ).append("\n"); 
		query.append("     , CASE WHEN A.OFC_CD IN (SELECT B.OFC_CD FROM CHL B)" ).append("\n"); 
		query.append("            THEN 1" ).append("\n"); 
		query.append("            ELSE CONNECT_BY_ISLEAF" ).append("\n"); 
		query.append("       END AS HAVE_CHILD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("     , CONNECT_BY_ISLEAF AS HAVE_CHILD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     , '' AS PROP_NO" ).append("\n"); 
		query.append("     , '' AS AMDT_SEQ" ).append("\n"); 
		query.append("     , USR_NM" ).append("\n"); 
		query.append("FROM OFC A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${pnode_id} == '')" ).append("\n"); 
		query.append("    #if (${ofc_cd} != '' || ${usr_id} != '' || ${usr_nm} != '')" ).append("\n"); 
		query.append("AND   (A.NODE_ID IN (SELECT B.NODE_ID FROM CHL B)" ).append("\n"); 
		query.append("    OR A.PNODE_ID IN (SELECT B.NODE_ID FROM CHL B) )" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("AND   LEVEL = 1" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("START WITH NODE_ID=COM_ConstantMgr_PKG.COM_getHeadOfficeCode_FNC()" ).append("\n"); 
		query.append("CONNECT BY PRIOR NODE_ID = PNODE_ID" ).append("\n"); 
		query.append("ORDER SIBLINGS BY TYPE_FLG, NODE_NM" ).append("\n"); 
		query.append("#if (${pnode_id} != '') " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE PNODE_ID = @[pnode_id]" ).append("\n"); 
		query.append("ORDER BY TYPE_FLG, NODE_NM" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}