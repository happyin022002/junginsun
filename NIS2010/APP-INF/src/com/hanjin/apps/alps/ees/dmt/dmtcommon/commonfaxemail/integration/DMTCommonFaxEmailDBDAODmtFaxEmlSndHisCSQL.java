/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DMTCommonFaxEmailDBDAODmtFaxEmlSndHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.20
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfaxemail.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCommonFaxEmailDBDAODmtFaxEmlSndHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DMT_FAX_EML_SND_HIS
	  * </pre>
	  */
	public DMTCommonFaxEmailDBDAODmtFaxEmlSndHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sndoctp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("invoice",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("payrfax",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fesndno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("payercd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fesndtp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("payreml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usof",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usid",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfaxemail.integration ").append("\n"); 
		query.append("FileName : DMTCommonFaxEmailDBDAODmtFaxEmlSndHisCSQL").append("\n"); 
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
		query.append("INSERT INTO DMT_FAX_EML_SND_HIS (" ).append("\n"); 
		query.append("DMDT_FAX_EML_SND_TP_CD" ).append("\n"); 
		query.append(", FAX_EML_SND_NO" ).append("\n"); 
		query.append(", FAX_EML_SND_HIS_SEQ" ).append("\n"); 
		query.append(", DMDT_SND_DOC_TP_CD" ).append("\n"); 
		query.append(", DMDT_INV_NO" ).append("\n"); 
		query.append(", ACT_PAYR_CNT_CD" ).append("\n"); 
		query.append(", ACT_PAYR_SEQ" ).append("\n"); 
		query.append(", DMDT_PAYR_EML" ).append("\n"); 
		query.append(", DMDT_PAYR_FAX_NO" ).append("\n"); 
		query.append(", FAX_EML_SND_RSLT_MSG" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", CRE_OFC_CD" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("@[fesndtp]" ).append("\n"); 
		query.append(", @[fesndno]" ).append("\n"); 
		query.append(", ( select (nvl(max(FAX_EML_SND_HIS_SEQ),1)+1) from DMT_FAX_EML_SND_HIS where DMDT_FAX_EML_SND_TP_CD = @[fesndtp] and FAX_EML_SND_NO = @[fesndno] )" ).append("\n"); 
		query.append(", @[sndoctp]" ).append("\n"); 
		query.append(", @[invoice]" ).append("\n"); 
		query.append(", DECODE( LENGTH( @[payercd] ) , 8 , SUBSTR( @[payercd] , 1 , 2 ) , 6 , '00' , '00' )" ).append("\n"); 
		query.append(", DECODE( LENGTH( @[payercd] ) , 8 , SUBSTR( @[payercd] , 3 , 6 ) , 6 , @[payercd] , 0 )" ).append("\n"); 
		query.append(", @[payreml]" ).append("\n"); 
		query.append(", @[payrfax]" ).append("\n"); 
		query.append(", ( SELECT EML_ERR_MSG FROM COM_EML_SND_INFO WHERE RD_SUB_SYS_CD = 'DMT' AND EML_SND_NO = @[fesndno] )" ).append("\n"); 
		query.append(", @[usid]" ).append("\n"); 
		query.append(", NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[usof]),SYSDATE)" ).append("\n"); 
		query.append(", @[usof]" ).append("\n"); 
		query.append(", @[usid]" ).append("\n"); 
		query.append(", NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[usof]),SYSDATE)" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}