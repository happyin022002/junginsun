/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PartnerDBDAOSearchVndrCntcRqstRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.12
*@LastModifier : 윤태승
*@LastVersion : 1.0
* 2012.06.12 윤태승
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.partner.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author YunTaeSeung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerDBDAOSearchVndrCntcRqstRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 입력된 Request Vendor 정보를 조회한다
	  * </pre>
	  */
	public PartnerDBDAOSearchVndrCntcRqstRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.partner.integration").append("\n"); 
		query.append("FileName : PartnerDBDAOSearchVndrCntcRqstRSQL").append("\n"); 
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
		query.append("SELECT RQST_NO " ).append("\n"); 
		query.append("	,VNDR_SEQ" ).append("\n"); 
		query.append("    ,VNDR_CNTC_PNT_SEQ" ).append("\n"); 
		query.append("    ,INTL_PHN_NO" ).append("\n"); 
		query.append("    ,PHN_NO" ).append("\n"); 
		query.append("    ,INTL_FAX_NO" ).append("\n"); 
		query.append("    ,FAX_NO" ).append("\n"); 
		query.append("    ,VNDR_EML" ).append("\n"); 
		query.append("    ,PRMRY_CHK_FLG" ).append("\n"); 
		query.append("    ,DELT_FLG" ).append("\n"); 
		query.append("FROM MDM_VNDR_CNTC_PNT_RQST" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND RQST_NO = @[rqst_no]" ).append("\n"); 

	}
}