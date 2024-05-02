/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SpecialReportDBDAOSearchReportTemplateBstVipList1RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.19
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.specialreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialReportDBDAOSearchReportTemplateBstVipList1RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Report Template List
	  * </pre>
	  */
	public SpecialReportDBDAOSearchReportTemplateBstVipList1RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_bkg_rpt_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vis_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.specialreport.integration").append("\n"); 
		query.append("FileName : SpecialReportDBDAOSearchReportTemplateBstVipList1RSQL").append("\n"); 
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
		query.append("SELECT USR_ID" ).append("\n"); 
		query.append("    ,  BKG_RPT_KND_CD" ).append("\n"); 
		query.append("    ,  '' P_BKG_RPT_KND_CD    " ).append("\n"); 
		query.append("    ,  RPT_ID " ).append("\n"); 
		query.append("    ,  RPT_NM" ).append("\n"); 
		query.append("    ,  COM_FLG" ).append("\n"); 
		query.append("    ,  OWNR_USR_ID" ).append("\n"); 
		query.append("    ,  DP_SEQ" ).append("\n"); 
		query.append("    ,  SC_NO" ).append("\n"); 
		query.append("    ,  CUST_CNT_CD" ).append("\n"); 
		query.append("    ,  CUST_SEQ" ).append("\n"); 
		query.append("    ,  VIS_FLG" ).append("\n"); 
		query.append("    ,  USR_ID     " ).append("\n"); 
		query.append("    ,  DECODE(COM_FLG,'Y','C',PRIVATE_GB) TYPE_GUBUN" ).append("\n"); 
		query.append("    ,  DECODE(COM_FLG,'Y','View',DECODE(PRIVATE_GB,'P','Modify','View')) SEARCH_OPTION" ).append("\n"); 
		query.append("    ,  DECODE(COM_FLG,'Y','View',DECODE(PRIVATE_GB,'P','Modify','View')) ITEM_OPTION" ).append("\n"); 
		query.append("    ,  DECODE(COM_FLG,'Y','Common',TYPE_NM) TYPE_NM" ).append("\n"); 
		query.append("    ,  BZC_COND_SQL_CTNT" ).append("\n"); 
		query.append("    ,  SELECTED_COL_NM" ).append("\n"); 
		query.append("    ,  SELECTED_COL_NM MODIFIED_COL_NM" ).append("\n"); 
		query.append("    ,  BZC_COND_SQL_CTNT ||'@@'|| SELECTED_COL_NM  SQL_CTNT_COL_NM" ).append("\n"); 
		query.append("    ,  '' TBL_NM" ).append("\n"); 
		query.append("    ,  '' COL_NM" ).append("\n"); 
		query.append("    ,  '' USR_ID" ).append("\n"); 
		query.append("    ,  '' USR_NM" ).append("\n"); 
		query.append("    ,  '' OFC_CD" ).append("\n"); 
		query.append("    ,  '' BKG_CUST_TP_CD" ).append("\n"); 
		query.append("    ,  '' CRE_DT" ).append("\n"); 
		query.append("    ,  '' CRE_USR_ID" ).append("\n"); 
		query.append("    ,  '' UPD_DT" ).append("\n"); 
		query.append("    ,  '' UPD_USR_ID" ).append("\n"); 
		query.append("FROM ( SELECT /*+ INDEX(A XPKBKG_RPT_SET) */" ).append("\n"); 
		query.append("               USR_ID" ).append("\n"); 
		query.append("             , B.BKG_RPT_KND_CD" ).append("\n"); 
		query.append("             , B.RPT_ID" ).append("\n"); 
		query.append("             , B.RPT_NM         /* Editable*/" ).append("\n"); 
		query.append("             , B.COM_FLG " ).append("\n"); 
		query.append("             , B.OWNR_USR_ID" ).append("\n"); 
		query.append("             , A.DP_SEQ" ).append("\n"); 
		query.append("             , A.SC_NO          /* Editable*/" ).append("\n"); 
		query.append("             , A.BKG_CUST_TP_CD /* Editable*/" ).append("\n"); 
		query.append("             , A.CUST_CNT_CD    /* Editable*/" ).append("\n"); 
		query.append("             , A.CUST_SEQ       /* Editable*/" ).append("\n"); 
		query.append("             , A.VIS_FLG        /* Editable*/   " ).append("\n"); 
		query.append("             , DECODE(OWNR_USR_ID , @[upd_usr_id],'P','S') PRIVATE_GB" ).append("\n"); 
		query.append("             , DECODE(OWNR_USR_ID , @[upd_usr_id],'Private(Share)','Shared by '||(SELECT USR_NM FROM COM_USER WHERE USR_ID = OWNR_USR_ID)) TYPE_NM" ).append("\n"); 
		query.append("             , BZC_COND_SQL_CTNT" ).append("\n"); 
		query.append("             , BKG_JOIN_FNC(cursor(SELECT TBL_NM||'>'||COL_NM " ).append("\n"); 
		query.append("                                   FROM BKG_RPT_DFLT_DTL " ).append("\n"); 
		query.append("                                   WHERE BKG_RPT_KND_CD = B.BKG_RPT_KND_CD" ).append("\n"); 
		query.append("                                   AND   RPT_ID         = B.RPT_ID" ).append("\n"); 
		query.append("								   ORDER BY ORD_SEQ" ).append("\n"); 
		query.append("                                 ),'|') SELECTED_COL_NM" ).append("\n"); 
		query.append("        from BKG_RPT_SET A, BKG_RPT_DFLT B" ).append("\n"); 
		query.append("        WHERE A.BKG_RPT_KND_CD(+) = B.BKG_RPT_KND_CD" ).append("\n"); 
		query.append("        AND   A.RPT_ID(+)         = B.RPT_ID" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        AND   B.BKG_RPT_KND_CD    = @[p_bkg_rpt_knd_cd]" ).append("\n"); 
		query.append("        AND   (     (A.USR_ID      = @[upd_usr_id] " ).append("\n"); 
		query.append("					#if (${vis_flg} != '') " ).append("\n"); 
		query.append("					AND   A.VIS_FLG           = @[vis_flg]" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("                OR  B.COM_FLG     ='Y' )" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("/*ORDER BY  COM_FLG DESC, RPT_NM ASC*/" ).append("\n"); 
		query.append("ORDER BY  COM_FLG DESC, RPT_ID ASC" ).append("\n"); 

	}
}