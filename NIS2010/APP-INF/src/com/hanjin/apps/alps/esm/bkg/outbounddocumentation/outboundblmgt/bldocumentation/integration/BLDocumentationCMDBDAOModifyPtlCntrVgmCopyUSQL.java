/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLDocumentationCMDBDAOModifyPtlCntrVgmCopyUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOModifyPtlCntrVgmCopyUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * XterVgm 조회
	  * </pre>
	  */
	public BLDocumentationCMDBDAOModifyPtlCntrVgmCopyUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("target_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOModifyPtlCntrVgmCopyUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("   SET ( VGM_WGT            " ).append("\n"); 
		query.append("       , VGM_WGT_UT_CD     " ).append("\n"); 
		query.append("       , VGM_VRFY_DT       " ).append("\n"); 
		query.append("       , VGM_DTMN_DT       " ).append("\n"); 
		query.append("       , VGM_VRFY_SIG_CTNT " ).append("\n"); 
		query.append("       , VGM_MZD_TP_CD     " ).append("\n"); 
		query.append("       ) " ).append("\n"); 
		query.append("       = ( SELECT DECODE(NVL(VGM_WGT,0),0, CNTR.VGM_WGT, VGM_WGT)" ).append("\n"); 
		query.append("                , NVL(VGM_WGT_UT_CD,     CNTR.VGM_WGT_UT_CD)" ).append("\n"); 
		query.append("                , NVL(VGM_VRFY_DT,       CNTR.VGM_VRFY_DT)" ).append("\n"); 
		query.append("                , NVL(VGM_DTMN_DT,       CNTR.VGM_DTMN_DT)" ).append("\n"); 
		query.append("                , NVL(VGM_VRFY_SIG_CTNT, CNTR.VGM_VRFY_SIG_CTNT)" ).append("\n"); 
		query.append("                , NVL(VGM_MZD_TP_CD,     CNTR.VGM_MZD_TP_CD)  " ).append("\n"); 
		query.append("             FROM BKG_CONTAINER    " ).append("\n"); 
		query.append("            WHERE BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("              AND CNTR_NO = @[cntr_no])" ).append("\n"); 
		query.append("     , UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("     , UPD_DT     = SYSDATE" ).append("\n"); 
		query.append(" WHERE BKG_NO     = @[target_bkg_no]    " ).append("\n"); 
		query.append("   AND CNTR_NO    = @[cntr_no]" ).append("\n"); 

	}
}