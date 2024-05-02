/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ArrivalNoticeDBDAOmergeArrNtcDtlByEdiUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.29
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ArrivalNoticeDBDAOmergeArrNtcDtlByEdiUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 추가하기
	  * </pre>
	  */
	public ArrivalNoticeDBDAOmergeArrNtcDtlByEdiUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : ArrivalNoticeDBDAOmergeArrNtcDtlByEdiUSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_ARR_NTC_DTL A" ).append("\n"); 
		query.append("USING (SELECT   @[bkg_no]                 AS BKG_NO   " ).append("\n"); 
		query.append("              , @[bkg_cust_tp_cd]         AS BKG_CUST_TP_CD " ).append("\n"); 
		query.append("              , 'C1'                      AS CUST_CNTC_TP_CD" ).append("\n"); 
		query.append("              , GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',TO_DATE(sysdate, 'YYYY/MM/DD HH24MISS'),@[ofc_cd] )  AS EDI_SND_DT   " ).append("\n"); 
		query.append("              , GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',TO_DATE(sysdate, 'YYYY/MM/DD HH24MISS'),'GMT' )      AS EDI_SND_GDT   " ).append("\n"); 
		query.append("              , @[cre_usr_id]             AS EDI_SND_USR_ID  " ).append("\n"); 
		query.append("              , @[cre_usr_id]             AS CRE_USR_ID  " ).append("\n"); 
		query.append("              , SYSDATE                   AS CRE_DT           " ).append("\n"); 
		query.append("              , @[upd_usr_id]             AS UPD_USR_ID " ).append("\n"); 
		query.append("	      , SYSDATE                   AS UPD_DT    " ).append("\n"); 
		query.append("        FROM DUAL " ).append("\n"); 
		query.append("      ) B" ).append("\n"); 
		query.append("ON ( A.BKG_NO = B.BKG_NO " ).append("\n"); 
		query.append("     AND A.BKG_CUST_TP_CD  = B.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("     AND A.CUST_CNTC_TP_CD = B.CUST_CNTC_TP_CD )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE " ).append("\n"); 
		query.append("    SET  EDI_SND_DT            = B.EDI_SND_DT" ).append("\n"); 
		query.append("       , EDI_SND_GDT           = B.EDI_SND_GDT" ).append("\n"); 
		query.append("       , EDI_SND_USR_ID        = B.EDI_SND_USR_ID" ).append("\n"); 
		query.append("       , UPD_USR_ID            = B.UPD_USR_ID" ).append("\n"); 
		query.append("       , UPD_DT                = B.UPD_DT    " ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT (BKG_NO,BKG_CUST_TP_CD,CUST_CNTC_TP_CD,EDI_SND_DT,EDI_SND_GDT,EDI_SND_USR_ID, CRE_USR_ID,CRE_DT, UPD_USR_ID, UPD_DT) " ).append("\n"); 
		query.append("    VALUES( B.BKG_NO                  " ).append("\n"); 
		query.append("           ,B.BKG_CUST_TP_CD           " ).append("\n"); 
		query.append("           ,B.CUST_CNTC_TP_CD           " ).append("\n"); 
		query.append("           ,B.EDI_SND_DT           " ).append("\n"); 
		query.append("           ,B.EDI_SND_GDT           " ).append("\n"); 
		query.append("           ,B.EDI_SND_USR_ID           " ).append("\n"); 
		query.append("           ,B.CRE_USR_ID              " ).append("\n"); 
		query.append("           ,B.CRE_DT               " ).append("\n"); 
		query.append("           ,B.UPD_USR_ID" ).append("\n"); 
		query.append("           ,B.UPD_DT" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}