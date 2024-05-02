/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLDocumentationBLDBDAOMfNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.10.22 김영출
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Youngchul
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationBLDBDAOMfNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLDocumentationBLDBDAOMfNoRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOMfNoRSQL").append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("SELECT BKG_STS_CD" ).append("\n"); 
		query.append(",      VSL_CD || SKD_VOY_NO || SKD_DIR_CD VVD" ).append("\n"); 
		query.append(",      POR_CD" ).append("\n"); 
		query.append(",      POL_CD" ).append("\n"); 
		query.append(",      POD_CD" ).append("\n"); 
		query.append(",      DEL_CD" ).append("\n"); 
		query.append(",      PRE_RLY_PORT_CD" ).append("\n"); 
		query.append(",      PST_RLY_PORT_CD" ).append("\n"); 
		query.append(",      USA_CSTMS_FILE_CD" ).append("\n"); 
		query.append(",      CND_CSTMS_FILE_CD" ).append("\n"); 
		query.append("FROM   BKG_BKG_HIS" ).append("\n"); 
		query.append("WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND    CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT BKG_STS_CD" ).append("\n"); 
		query.append(",      VSL_CD || SKD_VOY_NO || SKD_DIR_CD VVD" ).append("\n"); 
		query.append(",      POR_CD" ).append("\n"); 
		query.append(",      POL_CD" ).append("\n"); 
		query.append(",      POD_CD" ).append("\n"); 
		query.append(",      DEL_CD" ).append("\n"); 
		query.append(",      PRE_RLY_PORT_CD" ).append("\n"); 
		query.append(",      PST_RLY_PORT_CD" ).append("\n"); 
		query.append(",      USA_CSTMS_FILE_CD" ).append("\n"); 
		query.append(",      CND_CSTMS_FILE_CD" ).append("\n"); 
		query.append("FROM   BKG_BOOKING" ).append("\n"); 
		query.append("WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}