/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InlandLinkManageDBDAOInlandLinkMergeUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 김귀진
*@LastVersion : 1.0
* 2009.09.22 김귀진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandlinkmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kIm kwi-jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandLinkManageDBDAOInlandLinkMergeUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InlandLinkMerge
	  * </pre>
	  */
	public InlandLinkManageDBDAOInlandLinkMergeUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lnk_dest_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tztm_hrs",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trsp_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lnk_org_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lnk_dist",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dist_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandlinkmanage.integration").append("\n"); 
		query.append("FileName : InlandLinkManageDBDAOInlandLinkMergeUSQL").append("\n"); 
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
		query.append("MERGE INTO PRD_INLND_EACH_LNK E" ).append("\n"); 
		query.append("USING (SELECT @[lnk_org_nod_cd] LNK_ORG_NOD_CD, @[lnk_dest_nod_cd] LNK_DEST_NOD_CD," ).append("\n"); 
		query.append("@[trsp_mod_cd] TRSP_MOD_CD, to_number( @[vndr_seq] )  VNDR_SEQ, @[tztm_hrs] TZTM_HRS," ).append("\n"); 
		query.append("@[lnk_dist] LNK_DIST, @[dist_ut_cd] DIST_UT_CD, @[cty_cd] trsp_agmt_ofc_cty_cd, to_number(@[i_agmt_seq] ) trsp_agmt_seq" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(") D ON (E.LNK_ORG_NOD_CD= D.LNK_ORG_NOD_CD" ).append("\n"); 
		query.append("AND E.LNK_DEST_NOD_CD=D.LNK_DEST_NOD_CD" ).append("\n"); 
		query.append("AND E.TRSP_MOD_CD = D.TRSP_MOD_CD)" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET VNDR_SEQ= D.VNDR_SEQ," ).append("\n"); 
		query.append("TZTM_HRS= D.TZTM_HRS," ).append("\n"); 
		query.append("LNK_DIST = D.LNK_DIST," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("CRE_OFC_CD = @[cre_ofc_cd]," ).append("\n"); 
		query.append("CRE_USR_ID = @[cre_usr_id]," ).append("\n"); 
		query.append("CRE_DT = SYSDATE," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("DELT_FLG = 'N'," ).append("\n"); 
		query.append("DIST_UT_CD = D.DIST_UT_CD," ).append("\n"); 
		query.append("UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("UPD_DT= SYSDATE," ).append("\n"); 
		query.append("trsp_agmt_ofc_cty_cd= d.trsp_agmt_ofc_cty_cd," ).append("\n"); 
		query.append("trsp_agmt_seq= d.trsp_agmt_seq" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT(LNK_ORG_NOD_CD,LNK_DEST_NOD_CD,TRSP_MOD_CD,VNDR_SEQ,TZTM_HRS," ).append("\n"); 
		query.append("LNK_DIST,DIST_UT_CD,RAIL_CRR_TP_CD,LNK_RMK,CRE_OFC_CD," ).append("\n"); 
		query.append("CRE_USR_ID,CRE_DT,UPD_USR_ID,UPD_DT,DELT_FLG,trsp_agmt_ofc_cty_cd, trsp_agmt_seq)" ).append("\n"); 
		query.append("VALUES(D.LNK_ORG_NOD_CD,D.LNK_DEST_NOD_CD,D.TRSP_MOD_CD,D.VNDR_SEQ,D.TZTM_HRS," ).append("\n"); 
		query.append("D.LNK_DIST,D.DIST_UT_CD,'','', @[cre_ofc_cd]," ).append("\n"); 
		query.append("@[cre_usr_id] ,SYSDATE, @[upd_usr_id] ,SYSDATE,'N',d.trsp_agmt_ofc_cty_cd, d.trsp_agmt_seq)" ).append("\n"); 

	}
}