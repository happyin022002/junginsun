/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : US204EDISetupDBDAOSearchUSEDISetupListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.18
*@LastModifier : 
*@LastVersion : 1.0
* 2013.04.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.us204edisetup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class US204EDISetupDBDAOSearchUSEDISetupListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * US EDI Setup List 조회
	  * </pre>
	  */
	public US204EDISetupDBDAOSearchUSEDISetupListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("deltFlg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndrSeq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.codemanage.us204edisetup.integration").append("\n"); 
		query.append("FileName : US204EDISetupDBDAOSearchUSEDISetupListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    A.VNDR_SEQ," ).append("\n"); 
		query.append("    A.VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("    A.USA_EDI_CD," ).append("\n"); 
		query.append("    B.EDI_RCVR_NM," ).append("\n"); 
		query.append("    DECODE(B.EDI_RCVR_NM_USE_FLG, 'N', '0', 'Y', '1') EDI_RCVR_NM_USE_FLG," ).append("\n"); 
		query.append("    B.CRE_OFC_CD," ).append("\n"); 
		query.append("    B.UPD_USR_ID," ).append("\n"); 
		query.append("    TO_CHAR(B.UPD_DT, 'YYYYMMDD') UPD_DT" ).append("\n"); 
		query.append("FROM MDM_VENDOR A, TRS_EDI_USA_RCVR_DTL B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if(${vndrSeq} != '')" ).append("\n"); 
		query.append("    AND A.VNDR_SEQ = @[vndrSeq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    AND A.VNDR_SEQ = B.VNDR_SEQ(+)" ).append("\n"); 
		query.append("    AND A.VNDR_CNT_CD = 'US'" ).append("\n"); 
		query.append("    AND A.WO_EDI_USE_FLG = 'Y'" ).append("\n"); 
		query.append("    AND A.USA_EDI_CD IS NOT NULL" ).append("\n"); 
		query.append("    AND A.DELT_FLG = @[deltFlg]" ).append("\n"); 
		query.append("ORDER BY EDI_RCVR_NM" ).append("\n"); 

	}
}