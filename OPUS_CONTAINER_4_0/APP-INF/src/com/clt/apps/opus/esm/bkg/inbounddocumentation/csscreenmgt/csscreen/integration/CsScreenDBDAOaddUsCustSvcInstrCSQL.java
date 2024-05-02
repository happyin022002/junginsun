/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CsScreenDBDAOaddUsCustSvcInstrCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.08
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
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
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration").append("\n"); 
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
		query.append("      ,@[instr_rmk]      " ).append("\n"); 
		query.append("      ,GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[edi_evnt_ofc_cd])" ).append("\n"); 
		query.append("      ,GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC,sysdate,'GMT') " ).append("\n"); 
		query.append("      ,'N'" ).append("\n"); 
		query.append("      ,@[cre_usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("      ,@[upd_usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE  " ).append("\n"); 
		query.append("FROM  DUAL" ).append("\n"); 

	}
}