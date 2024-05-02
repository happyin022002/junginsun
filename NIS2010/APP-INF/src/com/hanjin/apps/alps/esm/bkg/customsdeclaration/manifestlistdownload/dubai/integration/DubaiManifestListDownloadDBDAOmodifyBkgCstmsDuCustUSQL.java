/*=========================================================
*Copyright(c) 2017 SM Line
*@FileName : DubaiManifestListDownloadDBDAOmodifyBkgCstmsDuCustUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.12
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.03.12 김민정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dubai.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DubaiManifestListDownloadDBDAOmodifyBkgCstmsDuCustUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyBkgCstmsDuCust
	  * </pre>
	  */
	public DubaiManifestListDownloadDBDAOmodifyBkgCstmsDuCustUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("du_cust_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_cust_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dubai.integration").append("\n"); 
		query.append("FileName : DubaiManifestListDownloadDBDAOmodifyBkgCstmsDuCustUSQL").append("\n"); 
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
		query.append("#if (${ibflag} == 'I')" ).append("\n"); 
		query.append("    UPDATE BKG_CSTMS_DU_CUST" ).append("\n"); 
		query.append("       SET CUST_NM        = @[cust_nm]" ).append("\n"); 
		query.append("          ,CUST_ADDR      = @[cust_addr]" ).append("\n"); 
		query.append("     WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("       AND POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("       AND BKG_CUST_TP_CD = @[bkg_cust_tp_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    UPDATE BKG_CSTMS_DU_CUST" ).append("\n"); 
		query.append("       SET CUST_NM        = @[cust_nm]" ).append("\n"); 
		query.append("          ,CUST_ADDR      = @[cust_addr]" ).append("\n"); 
		query.append("          ,DU_CUST_ID     = @[du_cust_id]" ).append("\n"); 
		query.append("          ,ORG_CUST_NM    = @[org_cust_nm]" ).append("\n"); 
		query.append("          ,ORG_CUST_ADDR  = @[org_cust_addr]" ).append("\n"); 
		query.append("          ,CUST_CNT_CD    = @[cust_cnt_cd]" ).append("\n"); 
		query.append("     WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("       AND POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("       AND BKG_CUST_TP_CD = @[bkg_cust_tp_cd]" ).append("\n"); 
		query.append("#end " ).append("\n"); 

	}
}