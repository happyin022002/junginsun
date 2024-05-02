/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TesAdvanceAuditDBDAOCreateTesInvoiceAuditBatchCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.29
*@LastModifier : yOnghO
*@LastVersion : 1.0
* 2016.03.29 yOnghO
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.tesadvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOnghO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TesAdvanceAuditDBDAOCreateTesInvoiceAuditBatchCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Manual(5분) Batch 등록
	  * </pre>
	  */
	public TesAdvanceAuditDBDAOCreateTesInvoiceAuditBatchCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("expn_aud_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_cfm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.tesadvanceaudit.integration").append("\n"); 
		query.append("FileName : TesAdvanceAuditDBDAOCreateTesInvoiceAuditBatchCSQL").append("\n"); 
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
		query.append("INSERT INTO EAS_AUTO_AUD_BAT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	  AUTO_AUD_BAT_SEQ" ).append("\n"); 
		query.append("	, BAT_PROG_STS_CD" ).append("\n"); 
		query.append("	, SUB_SYS_CD" ).append("\n"); 
		query.append("	, INV_NO" ).append("\n"); 
		query.append("	, INV_VNDR_SEQ" ).append("\n"); 
		query.append("	, INV_CFM_DT" ).append("\n"); 
		query.append("	, EXPN_AUD_SEQ" ).append("\n"); 
		query.append("	, VSL_CD" ).append("\n"); 
		query.append("	, SKD_VOY_NO" ).append("\n"); 
		query.append("	, SKD_DIR_CD" ).append("\n"); 
		query.append("	, IO_BND_CD" ).append("\n"); 
		query.append("	, CRE_OFC_CD" ).append("\n"); 
		query.append("	, CRE_USR_ID" ).append("\n"); 
		query.append("	, CRE_DT" ).append("\n"); 
		query.append("	, UPD_USR_ID" ).append("\n"); 
		query.append("	, UPD_DT " ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("	NVL((SELECT /*+ INDEX_DESC(A XPKEAS_AUTO_AUD_BAT) */ AUTO_AUD_BAT_SEQ" ).append("\n"); 
		query.append("		FROM EAS_AUTO_AUD_BAT A" ).append("\n"); 
		query.append("		WHERE ROWNUM = 1" ).append("\n"); 
		query.append("		), 0) + 1" ).append("\n"); 
		query.append("	, 'P'" ).append("\n"); 
		query.append("	, 'TES'" ).append("\n"); 
		query.append("	, @[inv_no]" ).append("\n"); 
		query.append("	, @[vndr_seq]" ).append("\n"); 
		query.append("	, TO_DATE(@[inv_cfm_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("	, @[expn_aud_seq]" ).append("\n"); 
		query.append("	, @[vsl_cd]" ).append("\n"); 
		query.append("	, @[skd_voy_no]" ).append("\n"); 
		query.append("	, @[skd_dir_cd]" ).append("\n"); 
		query.append("	, @[io_bnd_cd]" ).append("\n"); 
		query.append("	, @[cre_ofc_cd]" ).append("\n"); 
		query.append("	, 'Batch'" ).append("\n"); 
		query.append("	, SYSDATE" ).append("\n"); 
		query.append("	, 'Batch'" ).append("\n"); 
		query.append("	, SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}