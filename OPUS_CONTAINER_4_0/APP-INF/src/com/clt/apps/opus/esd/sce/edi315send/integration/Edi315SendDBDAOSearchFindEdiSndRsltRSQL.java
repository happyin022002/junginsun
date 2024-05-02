/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : Edi315SendDBDAOSearchFindEdiSndRsltRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.15
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2015.12.15 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOSearchFindEdiSndRsltRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * for FIND_EDI_SND_RSLT
	  * </pre>
	  */
	public Edi315SendDBDAOSearchFindEdiSndRsltRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_edi_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_edi_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_edi_sub_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOSearchFindEdiSndRsltRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) CNT" ).append("\n"); 
		query.append("  FROM SCE_EDI_SND_RSLT  " ).append("\n"); 
		query.append(" WHERE EDI_GRP_CD  = @[e_edi_grp_cd]  " ).append("\n"); 
		query.append("   AND BKG_NO  = @[e_bkg_no]  " ).append("\n"); 
		query.append("   AND CNTR_NO = @[e_cntr_no]  " ).append("\n"); 
		query.append("   AND EDI_STS_CD = @[e_edi_sts_cd]  " ).append("\n"); 
		query.append("   AND EDI_SUB_STS_CD = @[e_edi_sub_sts_cd]" ).append("\n"); 
		query.append("   AND UPPER(EDI_SND_RMK) LIKE 'SUCCESS(SENT)%'  " ).append("\n"); 
		query.append("   AND EDI_SND_TP_CD = 'Y'" ).append("\n"); 

	}
}