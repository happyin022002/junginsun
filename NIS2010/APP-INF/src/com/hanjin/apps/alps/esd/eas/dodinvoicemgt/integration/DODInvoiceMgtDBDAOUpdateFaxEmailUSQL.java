/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : DODInvoiceMgtDBDAOUpdateFaxEmailUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.21
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.dodinvoicemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DODInvoiceMgtDBDAOUpdateFaxEmailUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UpdateFaxEmail
	  * </pre>
	  */
	public DODInvoiceMgtDBDAOUpdateFaxEmailUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dod_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.dodinvoicemgt.integration").append("\n"); 
		query.append("FileName : DODInvoiceMgtDBDAOUpdateFaxEmailUSQL").append("\n"); 
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
		query.append("UPDATE EAS_DOD_INV_MN" ).append("\n"); 
		query.append("SET  " ).append("\n"); 
		query.append("#if(${send_flg} == 'F')" ).append("\n"); 
		query.append("	FAX_SND_USR_ID = @[cre_usr_id]" ).append("\n"); 
		query.append("	,FAX_SND_DT = NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd]),SYSDATE)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${send_flg} == 'E')	" ).append("\n"); 
		query.append("	EML_SND_USR_ID = @[cre_usr_id]" ).append("\n"); 
		query.append("	,EML_SND_DT = NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd]),SYSDATE)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE DOD_INV_NO  = @[dod_inv_no]" ).append("\n"); 

	}
}