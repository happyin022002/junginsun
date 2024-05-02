/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : IndiaManifestListDownloadDBDAOIndiaIgmModiVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.04
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IndiaManifestListDownloadDBDAOIndiaIgmModiVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * IndiaIgmModiVO 생성을 위해 사용함
	  * </pre>
	  */
	public IndiaManifestListDownloadDBDAOIndiaIgmModiVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.integration ").append("\n"); 
		query.append("FileName : IndiaManifestListDownloadDBDAOIndiaIgmModiVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("'' VVD_CD" ).append("\n"); 
		query.append(",'' CUSTOMER_NAME" ).append("\n"); 
		query.append(",'' IAL" ).append("\n"); 
		query.append(",'' IDA_LINE_NO" ).append("\n"); 
		query.append(",'' DEL_CD" ).append("\n"); 
		query.append(",'' BL_CUST_TP" ).append("\n"); 
		query.append(",'' BL_NO" ).append("\n"); 
		query.append(",'' POD_CD" ).append("\n"); 
		query.append(",'' ENTRY_TP" ).append("\n"); 
		query.append(",'' BCD_DESC" ).append("\n"); 
		query.append(",'' HBL_IND" ).append("\n"); 
		query.append(",'' POL_CD" ).append("\n"); 
		query.append(",'' ITEM_TP" ).append("\n"); 
		query.append(",'' MODE_TRANS" ).append("\n"); 
		query.append(",'' HBL_NO" ).append("\n"); 
		query.append(",'' TRANS_OPER" ).append("\n"); 
		query.append(",'' CFS_BOND_CD" ).append("\n"); 
		query.append(",'' CFS_CD" ).append("\n"); 
		query.append(",'' DEST_CD" ).append("\n"); 
		query.append(",'' cre_usr_id" ).append("\n"); 
		query.append(",'' upd_usr_id" ).append("\n"); 
		query.append(",'' down_check" ).append("\n"); 
		query.append(",'' IBD_NO" ).append("\n"); 
		query.append(",'' BD_AREA_CD" ).append("\n"); 
		query.append(",'' TRNS_OPR_ID" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}