/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BDRSettingDBDAOupdateBlDocUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.16
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2010.04.16 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bdrbookinginterface.bdrbookinginterface.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki Jong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BDRSettingDBDAOupdateBlDocUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * updateBlDoc
	  * </pre>
	  */
	public BDRSettingDBDAOupdateBlDocUSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.batch.bdrbookinginterface.integration").append("\n"); 
		query.append("FileName : BDRSettingDBDAOupdateBlDocUSQL").append("\n"); 
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
		query.append("UPDATE  BKG_BL_DOC" ).append("\n"); 
		query.append("SET     BDR_FLG = 'Y'," ).append("\n"); 
		query.append("BDR_DT = GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE-1,POL_CD)," ).append("\n"); 
		query.append("UPD_USR_ID = 'BDRBookingSetting'," ).append("\n"); 
		query.append("UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE   BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}