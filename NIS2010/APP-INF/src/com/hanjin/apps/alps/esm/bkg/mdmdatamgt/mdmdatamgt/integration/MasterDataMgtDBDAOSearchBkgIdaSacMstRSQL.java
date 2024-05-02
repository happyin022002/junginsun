/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : MasterDataMgtDBDAOSearchBkgIdaSacMstRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.28
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.07.28 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.mdmdatamgt.mdmdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG Min Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MasterDataMgtDBDAOSearchBkgIdaSacMstRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *  
	  * </pre>
	  */
	public MasterDataMgtDBDAOSearchBkgIdaSacMstRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_sac_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_sac_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.mdmdatamgt.mdmdatamgt.integration").append("\n"); 
		query.append("FileName : MasterDataMgtDBDAOSearchBkgIdaSacMstRSQL").append("\n"); 
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
		query.append("with base_data as (" ).append("\n"); 
		query.append("    select " ).append("\n"); 
		query.append("         a.IDA_SAC_CD" ).append("\n"); 
		query.append("        , a.IDA_SAC_NM" ).append("\n"); 
		query.append("        , a.IDA_SAC_TP_CD" ).append("\n"); 
		query.append("        , a.PRNT_IDA_SAC_CD" ).append("\n"); 
		query.append("        , a.DELT_FLG" ).append("\n"); 
		query.append("        , a.CRE_DT" ).append("\n"); 
		query.append("        , a.CRE_USR_ID" ).append("\n"); 
		query.append("        , a.UPD_DT" ).append("\n"); 
		query.append("        , a.UPD_USR_ID " ).append("\n"); 
		query.append("		, a.IDA_GST_RTO" ).append("\n"); 
		query.append("		, a.IDA_CGST_RTO" ).append("\n"); 
		query.append("		, a.IDA_SGST_RTO " ).append("\n"); 
		query.append("		, a.IDA_IGST_RTO" ).append("\n"); 
		query.append("		, a.IDA_UGST_RTO " ).append("\n"); 
		query.append("    from BKG_IDA_SAC_MST a " ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("        and a.ida_sac_tp_cd = 'SAC'" ).append("\n"); 
		query.append("#if (${ida_sac_cd} != '' ) " ).append("\n"); 
		query.append("        and a.IDA_SAC_CD LIKE  @[ida_sac_cd] || '%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ida_sac_nm} != '' ) " ).append("\n"); 
		query.append("        and a.IDA_SAC_NM LIKE  '%' || @[ida_sac_nm] || '%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("prnt_data as (" ).append("\n"); 
		query.append("    select distinct" ).append("\n"); 
		query.append("         a.IDA_SAC_CD" ).append("\n"); 
		query.append("        , a.IDA_SAC_NM" ).append("\n"); 
		query.append("        , a.IDA_SAC_TP_CD" ).append("\n"); 
		query.append("        , a.PRNT_IDA_SAC_CD" ).append("\n"); 
		query.append("        , a.DELT_FLG" ).append("\n"); 
		query.append("        , a.CRE_DT" ).append("\n"); 
		query.append("        , a.CRE_USR_ID" ).append("\n"); 
		query.append("        , a.UPD_DT" ).append("\n"); 
		query.append("        , a.UPD_USR_ID " ).append("\n"); 
		query.append("		, a.IDA_GST_RTO" ).append("\n"); 
		query.append("		, a.IDA_CGST_RTO" ).append("\n"); 
		query.append("		, a.IDA_SGST_RTO" ).append("\n"); 
		query.append("		, a.IDA_IGST_RTO" ).append("\n"); 
		query.append("		, a.IDA_UGST_RTO " ).append("\n"); 
		query.append("    from BKG_IDA_SAC_MST a ,base_data b" ).append("\n"); 
		query.append("    WHERE 1=1 --SCT : SECTION, HDG:HEADING, GRP:GROUP, SAC : SAC " ).append("\n"); 
		query.append("        and a.IDA_SAC_TP_CD <> 'SAC'" ).append("\n"); 
		query.append("        and ( a.IDA_SAC_TP_CD = 'STR' " ).append("\n"); 
		query.append("                OR ( a.IDA_SAC_TP_CD = 'SCT' and a.IDA_SAC_CD = substr(b.IDA_SAC_CD,0,3) ) " ).append("\n"); 
		query.append("                OR ( a.IDA_SAC_TP_CD = 'HDG' and a.IDA_SAC_CD = substr(b.IDA_SAC_CD,0,4) ) " ).append("\n"); 
		query.append("                OR ( a.IDA_SAC_TP_CD = 'GRP' and a.IDA_SAC_CD = substr(b.IDA_SAC_CD,0,5) ) " ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("select " ).append("\n"); 
		query.append("	level  " ).append("\n"); 
		query.append("	, a.IDA_SAC_CD" ).append("\n"); 
		query.append("	, a.IDA_SAC_NM" ).append("\n"); 
		query.append("	, a.IDA_SAC_TP_CD" ).append("\n"); 
		query.append("	, a.PRNT_IDA_SAC_CD" ).append("\n"); 
		query.append("	, a.DELT_FLG" ).append("\n"); 
		query.append("	, a.CRE_DT" ).append("\n"); 
		query.append("	, a.CRE_USR_ID" ).append("\n"); 
		query.append("	, a.UPD_DT" ).append("\n"); 
		query.append("	, a.UPD_USR_ID " ).append("\n"); 
		query.append("		, a.IDA_GST_RTO" ).append("\n"); 
		query.append("		, a.IDA_CGST_RTO" ).append("\n"); 
		query.append("		, a.IDA_SGST_RTO" ).append("\n"); 
		query.append("		, a.IDA_IGST_RTO" ).append("\n"); 
		query.append("		, a.IDA_UGST_RTO " ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("    select " ).append("\n"); 
		query.append("         a.IDA_SAC_CD" ).append("\n"); 
		query.append("        , a.IDA_SAC_NM" ).append("\n"); 
		query.append("        , a.IDA_SAC_TP_CD" ).append("\n"); 
		query.append("        , a.PRNT_IDA_SAC_CD" ).append("\n"); 
		query.append("        , a.DELT_FLG" ).append("\n"); 
		query.append("        , a.CRE_DT" ).append("\n"); 
		query.append("        , a.CRE_USR_ID" ).append("\n"); 
		query.append("        , a.UPD_DT" ).append("\n"); 
		query.append("        , a.UPD_USR_ID    " ).append("\n"); 
		query.append("		, a.IDA_GST_RTO" ).append("\n"); 
		query.append("		, a.IDA_CGST_RTO" ).append("\n"); 
		query.append("		, a.IDA_SGST_RTO" ).append("\n"); 
		query.append("		, a.IDA_IGST_RTO" ).append("\n"); 
		query.append("		, a.IDA_UGST_RTO  " ).append("\n"); 
		query.append("    from base_data a" ).append("\n"); 
		query.append("    union all" ).append("\n"); 
		query.append("     select " ).append("\n"); 
		query.append("         a.IDA_SAC_CD" ).append("\n"); 
		query.append("        , a.IDA_SAC_NM" ).append("\n"); 
		query.append("        , a.IDA_SAC_TP_CD" ).append("\n"); 
		query.append("        , a.PRNT_IDA_SAC_CD" ).append("\n"); 
		query.append("        , a.DELT_FLG" ).append("\n"); 
		query.append("        , a.CRE_DT" ).append("\n"); 
		query.append("        , a.CRE_USR_ID" ).append("\n"); 
		query.append("        , a.UPD_DT" ).append("\n"); 
		query.append("        , a.UPD_USR_ID    " ).append("\n"); 
		query.append("		, a.IDA_GST_RTO" ).append("\n"); 
		query.append("		, a.IDA_CGST_RTO" ).append("\n"); 
		query.append("		, a.IDA_SGST_RTO" ).append("\n"); 
		query.append("		, a.IDA_IGST_RTO" ).append("\n"); 
		query.append("		, a.IDA_UGST_RTO  " ).append("\n"); 
		query.append("    from prnt_data a   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") a" ).append("\n"); 
		query.append("CONNECT BY PRIOR IDA_SAC_CD = PRNT_IDA_SAC_CD                                    " ).append("\n"); 
		query.append("START WITH PRNT_IDA_SAC_CD = '99'" ).append("\n"); 
		query.append("ORDER SIBLINGS BY IDA_SAC_CD" ).append("\n"); 

	}
}