/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BookingMasterMgtDBDAOBkgZipCdVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.20
*@LastModifier : inyoung Lee
*@LastVersion : 1.0
* 2011.01.20 inyoung Lee
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author inyoung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOBkgZipCdVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public BookingMasterMgtDBDAOBkgZipCdVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("zip_dtl_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("zip_cd_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("zip_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ste_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cty_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOBkgZipCdVOUSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_ZIP_CD A" ).append("\n"); 
		query.append("USING (SELECT @[cnt_cd]                                                AS CNT_CD       " ).append("\n"); 
		query.append("             ,@[zip_cd]                                                AS ZIP_CD       " ).append("\n"); 
		query.append("             ,UPPER(@[cty_nm])                                         AS CTY_NM       " ).append("\n"); 
		query.append("             ,UPPER(@[ste_nm])                                         AS STE_NM       " ).append("\n"); 
		query.append("             ,UPPER(@[zip_dtl_addr])                                   AS ZIP_DTL_ADDR " ).append("\n"); 
		query.append("             ,@[evnt_usr_id]                                           AS EVNT_USR_ID  -- Login id" ).append("\n"); 
		query.append("             ,@[evnt_ofc_cd]                                           AS EVNT_OFC_CD  --Login office" ).append("\n"); 
		query.append("             ,GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[evnt_ofc_cd])        AS EVNT_DT" ).append("\n"); 
		query.append("             ,GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', SYSDATE, 'GMT' )   AS EVNT_GDT  " ).append("\n"); 
		query.append("             ,'N'                                                      AS DELT_FLG     " ).append("\n"); 
		query.append("             ,@[cre_usr_id]                                            AS CRE_USR_ID   " ).append("\n"); 
		query.append("             ,SYSDATE                                                  AS CRE_DT       " ).append("\n"); 
		query.append("             ,@[upd_usr_id]                                            AS UPD_USR_ID   " ).append("\n"); 
		query.append("             ,SYSDATE                                                  AS UPD_DT" ).append("\n"); 
		query.append("			 ,@[zip_cd_seq]       									   AS ZIP_CD_SEQ" ).append("\n"); 
		query.append("       FROM DUAL" ).append("\n"); 
		query.append("      ) B" ).append("\n"); 
		query.append("ON (   A.CNT_CD = B.CNT_CD" ).append("\n"); 
		query.append("   AND A.ZIP_CD = B.ZIP_CD" ).append("\n"); 
		query.append("   AND A.ZIP_CD_SEQ = B.ZIP_CD_SEQ  )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE " ).append("\n"); 
		query.append("    SET A.CTY_NM       = B.CTY_NM,         " ).append("\n"); 
		query.append("        A.STE_NM       = B.STE_NM,         " ).append("\n"); 
		query.append("        A.ZIP_DTL_ADDR = B.ZIP_DTL_ADDR,   " ).append("\n"); 
		query.append("        A.EVNT_USR_ID  = B.EVNT_USR_ID,    " ).append("\n"); 
		query.append("        A.EVNT_OFC_CD  = B.EVNT_OFC_CD,    " ).append("\n"); 
		query.append("        A.EVNT_DT      = B.EVNT_DT,        " ).append("\n"); 
		query.append("        A.EVNT_GDT     = B.EVNT_GDT,       " ).append("\n"); 
		query.append("        A.DELT_FLG     = B.DELT_FLG,       " ).append("\n"); 
		query.append("        A.UPD_USR_ID   = B.UPD_USR_ID,     " ).append("\n"); 
		query.append("        A.UPD_DT       = B.UPD_DT   " ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("          INSERT ( A.CNT_CD         " ).append("\n"); 
		query.append("                 , A.ZIP_CD         " ).append("\n"); 
		query.append("                 , A.CTY_NM         " ).append("\n"); 
		query.append("                 , A.STE_NM         " ).append("\n"); 
		query.append("                 , A.ZIP_DTL_ADDR   " ).append("\n"); 
		query.append("                 , A.EVNT_USR_ID    " ).append("\n"); 
		query.append("                 , A.EVNT_OFC_CD    " ).append("\n"); 
		query.append("                 , A.EVNT_DT        " ).append("\n"); 
		query.append("                 , A.EVNT_GDT       " ).append("\n"); 
		query.append("                 , A.DELT_FLG       " ).append("\n"); 
		query.append("                 , A.CRE_USR_ID     " ).append("\n"); 
		query.append("                 , A.CRE_DT         " ).append("\n"); 
		query.append("                 , A.UPD_USR_ID     " ).append("\n"); 
		query.append("                 , A.UPD_DT" ).append("\n"); 
		query.append("				 , A.ZIP_CD_SEQ )" ).append("\n"); 
		query.append("          VALUES(  B.CNT_CD         " ).append("\n"); 
		query.append("                 , B.ZIP_CD         " ).append("\n"); 
		query.append("                 , B.CTY_NM         " ).append("\n"); 
		query.append("                 , B.STE_NM         " ).append("\n"); 
		query.append("                 , B.ZIP_DTL_ADDR   " ).append("\n"); 
		query.append("                 , B.EVNT_USR_ID    " ).append("\n"); 
		query.append("                 , B.EVNT_OFC_CD    " ).append("\n"); 
		query.append("                 , B.EVNT_DT        " ).append("\n"); 
		query.append("                 , B.EVNT_GDT       " ).append("\n"); 
		query.append("                 , B.DELT_FLG       " ).append("\n"); 
		query.append("                 , B.CRE_USR_ID     " ).append("\n"); 
		query.append("                 , B.CRE_DT         " ).append("\n"); 
		query.append("                 , B.UPD_USR_ID     " ).append("\n"); 
		query.append("                 , B.UPD_DT" ).append("\n"); 
		query.append("				 , (SELECT NVL(MAX(B.ZIP_CD_SEQ)+1,1) " ).append("\n"); 
		query.append("					FROM BKG_ZIP_CD B " ).append("\n"); 
		query.append("					WHERE B.CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("					 AND  B.ZIP_CD = @[zip_cd]) )" ).append("\n"); 

	}
}