/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CsScreenDBDAOaddUsCustSvcInstrCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.17
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2012.05.17 김보배
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CsScreenDBDAOaddUsCustSvcInstrCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addUsCustSvcInstr
	  * * History
	  * 2012.05.16 김보배 [CHM-201217815] [BKG] Inbound CS_USA 화면 및 기능 변경사항 요청
	  * </pre>
	  */
	public CsScreenDBDAOaddUsCustSvcInstrCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("instr_rmk_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_evnt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("instr_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration").append("\n"); 
		query.append("FileName : CsScreenDBDAOaddUsCustSvcInstrCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_USA_CUST_SVC_INSTR ( BKG_NO" ).append("\n"); 
		query.append("                                    ,INSTR_RMK_SEQ" ).append("\n"); 
		query.append("                                    ,INSTR_RMK" ).append("\n"); 
		query.append("                                    ,INSTR_RMK_TP_CD" ).append("\n"); 
		query.append("                                    ,UPD_LOCL_DT" ).append("\n"); 
		query.append("                                    ,UPD_LOCL_GDT" ).append("\n"); 
		query.append("                                    ,DELT_FLG" ).append("\n"); 
		query.append("                                    ,CRE_USR_ID" ).append("\n"); 
		query.append("                                    ,CRE_DT" ).append("\n"); 
		query.append("                                    ,UPD_USR_ID" ).append("\n"); 
		query.append("                                    ,UPD_DT" ).append("\n"); 
		query.append(")                                " ).append("\n"); 
		query.append("SELECT @[bkg_no]" ).append("\n"); 
		query.append("      ,(SELECT NVL(MAX(INSTR_RMK_SEQ)+ 1, 1) FROM BKG_USA_CUST_SVC_INSTR WHERE BKG_NO = @[bkg_no]) AS INSTR_RMK_SEQ  " ).append("\n"); 
		query.append("      ,@[instr_rmk]  " ).append("\n"); 
		query.append("      ,(SELECT INTG_CD_VAL_CTNT FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03056' AND INTG_CD_VAL_CTNT = @[instr_rmk_tp_cd] ) AS INSTR_RMK_TP_CD    " ).append("\n"); 
		query.append("      ,GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[edi_evnt_ofc_cd])" ).append("\n"); 
		query.append("      ,GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',sysdate,'GMT') " ).append("\n"); 
		query.append("      ,'N'" ).append("\n"); 
		query.append("      ,@[cre_usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("      ,@[upd_usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE  " ).append("\n"); 
		query.append("FROM  DUAL" ).append("\n"); 

	}
}