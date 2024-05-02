/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLDocumentationCMDBDAOMstContainerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.23
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOMstContainerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLDocumentationCMDBDAOMstContainerRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOMstContainerRSQL").append("\n"); 
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
		query.append("SELECT CNTR_NO" ).append("\n"); 
		query.append(",      CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",      CNTR_STS_CD" ).append("\n"); 
		query.append(",      CNMV_CYC_NO" ).append("\n"); 
		query.append(",      CNMV_STS_CD" ).append("\n"); 
		query.append(",      DMG_FLG" ).append("\n"); 
		query.append(",      ACIAC_DIV_CD" ).append("\n"); 
		query.append(",      ECC_CD" ).append("\n"); 
		query.append(",      SYS_AREA_GRP_ID" ).append("\n"); 
		query.append(",	   IMDT_EXT_FLG" ).append("\n"); 
		query.append("FROM   MST_CONTAINER" ).append("\n"); 
		query.append("WHERE  CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("UNION " ).append("\n"); 
		query.append("SELECT '' CNTR_NO" ).append("\n"); 
		query.append(",      'B4' CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",      '' CNTR_STS_CD" ).append("\n"); 
		query.append(",      TO_NUMBER('')  CNMV_CYC_NO" ).append("\n"); 
		query.append(",      '' CNMV_STS_CD" ).append("\n"); 
		query.append(",      '' DMG_FLG" ).append("\n"); 
		query.append(",      '' ACIAC_DIV_CD" ).append("\n"); 
		query.append(",      '' ECC_CD" ).append("\n"); 
		query.append(",      '' SYS_AREA_GRP_ID" ).append("\n"); 
		query.append(",	   '' IMDT_EXT_FLG" ).append("\n"); 
		query.append("FROM   DUAL" ).append("\n"); 
		query.append("WHERE  'BREAKBULK' =  UPPER(@[cntr_no])" ).append("\n"); 

	}
}