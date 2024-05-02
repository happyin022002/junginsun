/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InlandRouteManageUsaDBDAOInlandRouteMsUSRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandRouteManageUsaDBDAOInlandRouteMsUSRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InlandRouteMsUS
	  * </pre>
	  */
	public InlandRouteManageUsaDBDAOInlandRouteMsUSRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_rout_org_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_rout_dest_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_wrs_mt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_rout_pln_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_inv",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r_inbound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_wrs_fl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.integration").append("\n"); 
		query.append("FileName : InlandRouteManageUsaDBDAOInlandRouteMsUSRSQL").append("\n"); 
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
		query.append("select m.ROUT_ORG_NOD_CD, m.ROUT_DEST_NOD_CD, m.ROUT_SEQ, nvl(m.DELT_FLG,'N') DELT_FLG" ).append("\n"); 
		query.append("from  " ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("    select ROUT_ORG_NOD_CD, ROUT_DEST_NOD_CD, ROUT_SEQ" ).append("\n"); 
		query.append("#if(${param_val} != '')	" ).append("\n"); 
		query.append("#foreach(${itm} in ${param_val}) " ).append("\n"); 
		query.append("	           , MIN(DECODE(r, '${itm.a}',LNK_ORG_NOD_CD)) LNK_ORG_NOD_CD${itm.a} " ).append("\n"); 
		query.append("	           , MIN(DECODE(r,'${itm.a}',TRSP_MOD_CD)) TRSP_MOD_CD${itm.a}" ).append("\n"); 
		query.append("	           , MIN(DECODE(r,'${itm.a}',sp)) sp${itm.a} " ).append("\n"); 
		query.append("	           , MIN(DECODE(r,'${itm.a}',cofc)) cofc${itm.a}  " ).append("\n"); 
		query.append("	           , MIN(DECODE(r,'${itm.a}',AGMT)) AGMT${itm.a}  " ).append("\n"); 
		query.append("	           , MIN(DECODE(r,'${itm.a}',CMB)) CMB${itm.a} " ).append("\n"); 
		query.append("	           , MIN(DECODE(r,'${itm.a}',trim(JUNK))) JUNK${itm.a}" ).append("\n"); 
		query.append("#if(${itm.a} == ${param_size})" ).append("\n"); 
		query.append("		       , MIN(DECODE(r,'${itm.a}' ,LNK_dest_NOD_CD)) LNK_dest_NOD_CD${itm.a} " ).append("\n"); 
		query.append("#end	" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    from " ).append("\n"); 
		query.append("    ( " ).append("\n"); 
		query.append("        SELECT   " ).append("\n"); 
		query.append("            b.ROUT_ORG_NOD_CD, b.ROUT_DEST_NOD_CD,b.ROUT_SEQ, b.LNK_ORG_NOD_CD,   " ).append("\n"); 
		query.append("            b.LNK_DEST_NOD_CD, b.ROUT_DTL_SEQ, b.TRSP_MOD_CD, B.VNDR_SEQ SP,B.RAIL_CRR_TP_CD cofc,  " ).append("\n"); 
		query.append("            DECODE(B.TRSP_AGMT_OFC_CTY_CD, NULL,'', B.TRSP_AGMT_OFC_CTY_CD||B.TRSP_AGMT_SEQ) AGMT, " ).append("\n"); 
		query.append("            B.INLND_ROUT_CMB_FLG CMB, B.INLND_ROUT_JUNC_NM JUNK, " ).append("\n"); 
		query.append("            ROW_NUMBER() OVER(PARTITION BY b.ROUT_ORG_NOD_CD, b.ROUT_DEST_NOD_CD,b.ROUT_SEQ  ORDER BY b.ROUT_ORG_NOD_CD, b.ROUT_DEST_NOD_CD, b.ROUT_SEQ,  b.ROUT_DTL_SEQ) r " ).append("\n"); 
		query.append("        FROM prd_inlnd_rout_dtl B, " ).append("\n"); 
		query.append("        ( " ).append("\n"); 
		query.append("        select COUNT(*),rout_org_nod_cd,rout_dest_nod_cd, ROUT_SEQ  " ).append("\n"); 
		query.append("        from prd_inlnd_rout_dtl a " ).append("\n"); 
		query.append("        where rout_org_nod_cd = @[i_rout_org_nod_cd] --'USLGBPT' " ).append("\n"); 
		query.append("        and rout_dest_nod_cd = @[i_rout_dest_nod_cd] --'USCLE01' " ).append("\n"); 
		query.append("        HAVING COUNT(*)= ${param_size}" ).append("\n"); 
		query.append("        GROUP BY rout_org_nod_cd,rout_dest_nod_cd,ROUT_SEQ  " ).append("\n"); 
		query.append("        ) AA " ).append("\n"); 
		query.append("        WHERE B.ROUT_ORG_NOD_CD = AA.ROUT_ORG_NOD_CD  " ).append("\n"); 
		query.append("        AND   B.rout_dest_nod_cd = AA.rout_dest_nod_cd " ).append("\n"); 
		query.append("        AND   B.ROUT_SEQ = AA.ROUT_SEQ " ).append("\n"); 
		query.append("    ) " ).append("\n"); 
		query.append("    group by ROUT_ORG_NOD_CD,ROUT_DEST_NOD_CD,ROUT_SEQ " ).append("\n"); 
		query.append(") dtl, " ).append("\n"); 
		query.append("prd_inlnd_rout_mst m " ).append("\n"); 
		query.append("where 1=1  " ).append("\n"); 
		query.append("and m.ROUT_ORG_NOD_CD = dtl.ROUT_ORG_NOD_CD " ).append("\n"); 
		query.append("and m.ROUT_DEST_NOD_CD = dtl.ROUT_DEST_NOD_CD " ).append("\n"); 
		query.append("and m.ROUT_SEQ = dtl.ROUT_SEQ " ).append("\n"); 
		query.append("--and nvl(m.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("and m.PCTL_IO_BND_CD = @[r_inbound] " ).append("\n"); 
		query.append("and nvl(m.INLND_ROUT_INV_BIL_PATT_CD,'X')= nvl(@[i_inv] ,'X')  " ).append("\n"); 
		query.append("and nvl(m.ROUT_PLN_CD     ,'X')=nvl( @[i_rout_pln_cd]     ,'X') " ).append("\n"); 
		query.append("and nvl(m.WRS_FULL_CMDT_CD,'X')=nvl(@[i_wrs_fl_cd]       ,'X') " ).append("\n"); 
		query.append("and nvl(m.WRS_MTY_CMDT_CD ,'X')=nvl(@[i_wrs_mt_cd]       ,'X')" ).append("\n"); 
		query.append("#if(${param_val} != '')	" ).append("\n"); 
		query.append("#foreach(${itm} in ${param_val}) " ).append("\n"); 
		query.append("	AND LNK_ORG_NOD_CD${itm.a} = '${itm.lnk_org_loc}${itm.lnk_org_type}'  " ).append("\n"); 
		query.append("	AND TRSP_MOD_CD${itm.a} = '${itm.trsp_mod_cd}' " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${itm.a} == ${param_size})" ).append("\n"); 
		query.append("		AND LNK_DEST_NOD_CD${itm.a} = @[i_rout_dest_nod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	and nvl(dtl.SP${itm.a}           ,0)=nvl(${itm.vndr_seq}     ,0) " ).append("\n"); 
		query.append("	and nvl(dtl.AGMT${itm.a}         ,'X')=nvl('${itm.agmt_no}','X') " ).append("\n"); 
		query.append("	and nvl(dtl.CMB${itm.a}          ,'N')=nvl( '${itm.inlnd_rout_cmb_flg}'       ,'N') " ).append("\n"); 
		query.append("	and nvl(dtl.COFC${itm.a}         ,'X')=nvl( '${itm.rail_crr_tp_cd}'     ,'X') " ).append("\n"); 
		query.append("	and nvl(dtl.JUNK${itm.a}         ,'X')=nvl('${itm.inlnd_rout_junc_nm}'     ,'X') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}